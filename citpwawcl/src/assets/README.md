# Reference implementation di un'applicazione basata su stack Angular 13/Openlayers 7

Applicazione di esempio basata su Angular 13 ed OpenLayers 7 per la visualizzazione di una mappa minimale avente uno sfondo WMS.
Nel repository corrente, è fornita un'applicazione minimale di esempio `app` che simula il comportamento di un'applicazione esterna che vuole includere la mappa.
Per i dettagli, leggere le sezioni seguenti.

É possibile fornire come parametri alla mappa una lista di layer WMS ed una lista di dataset GeoJSON da rappresentare, con relativi parametri di personalizzazione; inoltre, alcuni altri parametri generali consentono personalizzazioni di funzionalità.

I GeoJSON forniti vengono presentati sopra (coprono nel caso di sovrapposizione) i WMS.
I GeoJSON ed i WMS vengono caricati nell'ordine fornito: il primo elemento fornito in lista è il primo elemento ad essere caricato dal basso verso l'alto, quindi il secondo elemento viene posto sopra al primo durante il caricamento in mappa. 

L'ordinamento si riflette anche nell'ordine dei risultati della funzione "identifica" sempre attiva per i GeoJSON ed i WMS specificati essere interrogabili.

Per eseguire il codice dell'applicazione (usare node 12.20.x)
```
npm install
ng serve
```

# NOTE SVILUPPO
- L'applicativo è stato sviluppato utilizzando node 12.20.2, installando Angular13 e OpenLayers 7.
- Il sistema di riferimento della mappa è `EPSG:32632`, come adottato nel branch feature/ol-sfondi-bdtre
- La componente di mappa si aspetta i GeoJson nel sistema di riferimento `EPSG:4326`
- Sono stati installati i pacchetti: `ol, ol-ext, proj4`
- Sono stati installati come devDependencies i pacchetti: `@types/ol-ext@npm:@siedlerchr/types-ol-ext, @types/proj4`


# INTEGRAZIONE MAPPA
Di seguito le indicazioni per includere in un applicativo esistente la componente di mappa:

1. Installare i pacchetti: `npm install ol@7.5.2 ol-ext@4.0.18 proj4@2.11.0`.
2. Installare devDependencies: `npm install --dev @types/ol-ext@npm:@siedlerchr/types-ol-ext @types/proj4`, per poter sviluppare l'applicativo senza errori in compilazione
3. Aggiungere gli stili di `ol` e `ol-ext` nel file angular.json:
    - Andare nel file angular.json: nell'oggetto `projects > _nome del progetto_ > architect > build > options > styles` e aggiungere alla lista `styles` i riferimenti ai file css `"node_modules/ol/ol.css"` e `"node_modules/ol-ext/dist/ol-ext.css"`
4. File necessari:
    1. La cartella `src/app/map` che contiene la mappa e tutti i file necessari per identify e geolocalizzazione.
    2. La cartella `src/app/models` che contiene tutte le classi per la gestione dei dati di input
    3. I file `src/app/assets/target_empty.svg` e `src/app/assets/target_full.svg`, icone per il bottone di geolocalizzazione, devono essere messi nella cartella `src/app/assets`
    4. Il file `src/app/assets/zoom-in.svg`, icona del bottone _Vai al punto_ nell'identify, deve essere messo nella cartella `src/app/assets`


# COMPONENTE DI MAPPA
Di seguito si descrive il componente di mappa e configurabilità.

## Dimensione mappa
Per fare in modo che la mappa venga renderizzata correttamente all'interno del container della mappa, c'è bisogno che esso abbia una dimensione specifica, questo perchè la mappa ha bisogno di una dimensione fissa quando viene renderizzata.

## Configurazioni da passare al componente `map.component`
Di seguito si descrivono i parametri che il componente 'espone'.

### `options` (classe `MapConfig`)
Permette di configurare alcune funzionalità di mappa:

Attributi: 
- `fullScreen (deafult = false)` => variabile che indica se abilitare o meno il bottone di full screen della mappa che appare in alto a destra nella mappa
- `switchBaseLayer (deafult = false)` => variabile che indica se abilitare o meno lo strumento che compare in basso a sinistra, sopra la scala della mappa, per consentire all'utente di cambiare il layer di sfondo, denominato "switch layer". In esso appaiono solo gli elementi definiti in `baseLayer`
- `geolocationConfig (classe GeolocationConf)`:
    - `visible (default = true)` => variabile che indica la visibilità o meno del bottone per attivare la geolocalizzazione
    - `iconGeoEnabled (default = 'assets/target_full.svg')` => variabile che indica l'immagine/icona nel bottone della geolocalizzazione quando è attiva
    - `iconGeoDisabled (default = 'assets/target_empty.svg')` => variabile che indica l'immagine/icon del bottone della geolocalizzazione quando è disattivata
    - `pointStyle (classe PointStyle)` => leggere sezione "**Spiegazione classe PointStyle**"
	- `enableZoomTo (default = false)` => permette di abilitare lo zoom sul punto della geolocalizzaione quando si attiva la geolocalizzazione, schiacciando sul bottone in mappa

### `datasets` (classe `Dataset`)
Lista di elementi che contengono i geojson e la configurazione per quel determinato set di dati. 
I layer creati dei diversi geojson verranno sovrapposti gli uni agli altri, partendo dal primo elemento della lista. 

Attributi:
- `style (classe PointStyle)` => leggere sezione "**Spiegazione classe PointStyle**"
- `geojson` => geojson dei punti da far vedere in mappa
- `layerName` => nome del layer che apparirà nel popup dell'identify quando si seleziona un elemento
- `clusterDistance (default = 10)` => distanza entro la quale i punti verranno raggruppati insieme
- `clusterMinDistance (default = 0)` => distanza minima tra i cluster per evitare sovrapposizioni in mappa. Non può essere maggiore della distanza configurata `clusterDistance`

### `baseLayer` (classe `Layers` | `required`)
Variabile che dichiara la lista dei layers da mettere come sfondo.
Se lo `switchBaseLayer` è disabilitato e si hanno più layer di base visibili, in mappa i layer verranno sovrapposti, partendo dal primo elemento della lista. 

Tutti i layer sono intesi essere WMTS.

Attributi: 
- `layers (interfaccia LayersI | required)` lista dei layer passati:
    - `visible(required)` => variabile che indica se il layer è visibile o meno
    - `baseLayer (required)` => variabile che indica se il layer è un layer di base o meno
    - `title (required)` => nome del layer, visibile nello switch layer se abilitato
    - `sourceOption (required)` => contentente le opzioni per creare il layer :
        - `url (required)` => url del servizio dove si trova il layer
        - `crossOrigin (required)` => al momento lasciare "anonymous", per dettagli consultare la [documentazione](https://openlayers.org/en/v7.5.2/apidoc/module-ol_source_WMTS-WMTS.html)
        - `projection (required)` => sistema di riferimento (e.g. 'EPSG:32632')
        - `layer (required)` => nome del layer da utilizzare censito nel servizio, che si trova nella GetCapabilities del servizio
        - `style (required)` => nome dello stile del layer che si può trovare nella GetCapabilities del servizio (e.g. "default")
        - `matrixSet (required)` => matrix set del layer specificato dal parametro `layer`, che si trova nella GetCapabilities del servizio
        - `maxZoom (required)` => zoom massimo per la visibilità del layer oltre il quale il layer non è più visibile
        - `format (required)` => formato della risposta per renderizzare il layer (e.g. "image/png")

### `wmsList` (classe `WMSLayer`) 
Lista di elementi che contengono le configurazioni dei layer wms.
I layer wms creati verranno sovrapposti gli uni agli altri, partendo dal primo elemento della lista. 

Attributi:
- `url (required)` => url del servizio wms
- `layerName (required)` => lista di nomi dei layer da visualizzare, ovviamente devono essere tutti reperibili allo stesso url
- `querable (default = true)` => variabile che definisce se il wms può essere interrogabile, ergo fare l'identify sul layer
- `opacity (default = 0.5)` => variabile che definisce quanto il layer è trasparente, 1 non trasparente, 0 trasparente

### `zoomTo` (`Extent | [number,number] | GeoJson`)
Permette di fare lo zoom su un'area o un punto specifico della mappa, può essere definito quando si lancia l'applicativo ma può essere modificato runtime.
Accetta valori di tipo:
- `Extent` (chiamato anche `Bbox`) => `[minx, miny, maxx, maxy]`
- Coordinate (`[number,number]`) => `[x, y]`
- `GeoJson` => stesso formato usato nell'attributo `geojson` della classe `Dataset`

### Spiegazione classe `PointStyle`
Classe comune per definire lo stile dei punti sulla mappa. Tutti i colori possono essere hex, rgb o rgba. È possibile gestire la trasparenza dei colori utilizzando rgba.

Attributi:
- `featureBorderColor (default = '#ffffff' )` => colore del bordo del cerchio, usato quando si vede solo un singolo punto
- `fillColor (required)` => colore del riempimento del cerchio, utilizzato per lo stile del cluster e dei singoli punti appartenenti allo stesso cluster
- `selectFillColor` => colore di rimpimento del cerchio quando viene selezionato
- `textColor (default = '#000000')` => colore del testo che appare all'interno del cerchio quando ci sono i punti clusterizzati
- `featurePointRadius (default = 5)` => dimensione del cerchio, utilizzato per lo stile dei singoli punti appartenenti allo stesso cluster
- `icon` => icona che si vuole visualizzare al posto del cerchio, quando il punto non è clusterizzato. Se non è configurata si utilizzano gli attributi `featureBorderColor` e `fillColor` per creare lo stile del cerchio
- `selectIcon` => icona che si visualizza quando il punto è selezionato. Se non è presente nella configurazione, viene visualizzata l'attributo `icon`, se anch'esso non è presente si utilizza il valore dell'attributo `selectFillColor` o `fillColor` per creare lo stile del cerchio
- `heightIcon (default = 20)` => dimensione dell'icona dei punti visualizzati in mappa
- `featureBorderWidth (default = 1)` => dimensione del bordo del cerchio, quando si visualizza un punto non clusterizzato
- `clusterPointRadius (default = 5)` => dimensione del cerchio, utilizzato per lo stile del cluster


## Identify
L'identify è un componente separato dalla mappa che viene aggiunto al file `map.component.html` questo per comodità di renderizzazione del componente. 

### Dimensione identify
È possibile cambiare la dimensione dell'identify in base alla dimensione della finestra. Per farlo è necessario andare nel file `identify.component.scss` e modificare le variabili `--width` e `--height`, tenere l'unità di misura `vh` per l'altezza e `vw` per la larghezza. Se si utilizza `--height: 30vh` significa che l'altezza del popup dell'identify è il 30% dell'altezza della schermata, mentre `--width: 30vw` significa che la larghezza è il 30% della larghezza della schermata.

## Geolocation
La funzionalità viene istanziata all'interno del componente mappa, in base alla configurazione passata al componente mappa. 

Una volta che l'utente attiva la geolocalizzazione, agendo sul pulsante, non può essere disattivata. La posizione utente verrà continuamente aggiornata in mappa.
Nel caso l'utente voglia disattivarla deve disabilitarla da browser o ricaricare la pagina dell'applicativo.

Nel caso il valore `geolocationConfig.enableZoomTo` sia posto a `true`, alla pressione sul bottone della geolocalizzazione essa si attia ed esegue uno zoom alla posizione del dispositivo. Se l'attributo `geolocationConfig.enableZoomTo` è `false`, invece, non succederà nulla

Il codice si trova all'interno di `geolocation.component.ts`.