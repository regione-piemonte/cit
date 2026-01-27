# Project Title
CITPWAWCL

# Project Description
Questa componente è una Componente Angular di frontend che si interfaccia alle API REST di CITPWAWEB, realizzata in tecnica PWA, nativamente adattabile ai dispositivi sia mobili che desktop.

# Configurations
Aprire il file buildfiles/environment.dev-rp-01.ts e configurare i seguenti parametri:
- shibbolethSSOLogoutURL: url di logout;
- urlNotifiche: url della getsione delle notifiche;

# Getting Started 
Modificare il file di configurazione e compilare il progetto.

# Prerequisites
I prerequisiti per l'installazione della componente sono i seguenti:
## Software
- [Angular 13](https://angular.io/)
- [Node.js 16](https://nodejs.org/it)

- Tutte le librerie elencate nel citpwawcl.sbom.csv devono essere accessibili per compilare il progetto.
- La libreria Angular @sigit/common-lib è una libreria creata con il progetto commonwcl ed include parti condivise tra i vari progetti Angular

# Installing
Il pacchetto generato devrà essere inserito all'interno del pacchetto generato da CITPWAWEB sotto citpwaweb.ear\citpwaweb-web.war\.  

# Versioning
Per la gestione del codice sorgente viene utilizzata Git. Per la gestione del versioning si fa riferimento alla metodologia [Semantic Versioning](https://semver.org/).

# Copyrights
(C) Copyright 2026 Regione Piemonte

# License
[EUPL-1.2](https://joinup.ec.europa.eu/collection/eupl/eupl-text-11-12) Compatibile. Consulta il file [LICENSE.txt](LICENSE.txt) per i dettagli sulla licenza.

