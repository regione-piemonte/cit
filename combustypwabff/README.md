# Project Title
COMBUSTYPWAWEB

# Project Description
Questa componente espone i servizi API REST per la componente COMBUSTYPWAWCL.

# Configurations
Aprire il file src/main/resources/application.properties e configurare i seguenti parametri:
- quarkus.rest-client.sigitext.url: servizi di fruizione della componente SIGITEXT;
- quarkus.rest-client.locsi.url: servizi di fruizione della Ricerca Indirizzi;
- quarkus.rest-client.locsi-token.url: servizi di fruizione della ricerca del Bearer di accesso per l'API manager APIMBBONE;
- locsi-token.client-id: chiave di accesso all'API manager APIMBBONE;
- locsi-token.secret: password di accesso per l'API manager APIMBBONE;
- quarkus.cxf.client.mtom.wsdl: WSDL dei servizi di fruizione del gestionale documentale (CXF/MTOM);
- quarkus.cxf.client.mtom.client-endpoint-url: servizi di fruizione del gestionale documentale (CXF/MTOM);

# Getting Started 
Modificare il file di configurazione e compilare il progetto.

# Prerequisites
I prerequisiti per l'installazione della componente sono i seguenti:
## Software
- [AdoptOpenJDK 17](https://openjdk.org)
- [Apache 2.4](https://www.apache.org)
- [Quarkus 3.14.4](https://quarkus.io)
- [PostgreSQL 15.8](https://www.postgresql.org)

- Tutte le librerie elencate nel citpwaweb.sbom.csv devono essere accessibili per compilare il progetto. Le librerie sono pubblicate su [Maven](https://maven.apache.org/).

# Installing
Installare il file ear sull'ambiente Quarkus 3.14.4.  

# Versioning
Per la gestione del codice sorgente viene utilizzata Git. Per la gestione del versioning si fa riferimento alla metodologia [Semantic Versioning](https://semver.org/).

# Copyrights
(C) Copyright 2026 Regione Piemonte

# License
[EUPL-1.2](https://joinup.ec.europa.eu/collection/eupl/eupl-text-11-12) Compatibile. Consulta il file [LICENSE.txt](LICENSE.txt) per i dettagli sulla licenza.