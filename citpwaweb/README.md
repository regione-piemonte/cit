# Project Title
CITPWAWEB

# Project Description
Questa componente espone i servizi API REST per la componente CITPWAWCL.

# Configurations
Aprire il file citpwaweb-jar/profiles/dev-rp-01/config.properties e configurare i seguenti parametri:
- CIT_URL: servizi di fruizione della componente SIGITEXT;
- API_GWECOSIS_TOKEN_URL: servizi di fruizione della ricerca del Bearer di accesso per l'API manager GWECOSIS;
- API_GWECOSIS_TOKEN_CONSUMERKEY: chiave di accesso all'API manager GWECOSIS;
- API_GWECOSIS_TOKEN_CONSUMERSECRET: password di accesso per l'API manager GWECOSIS;
- SVISTA_WSDL_URL: servizi di fruizione Dati Territoriali;
- LOCCSI_API_URL: servizi di fruizione della Ricerca Indirizzi;
- LOCCSI_AUTH_URL: servizi di fruizione della ricerca del Bearer di accesso per l'API manager APIMBBONE;
- LOCCSI_KEY: chiave di accesso all'API manager APIMBBONE;
- LOCCSI_SECRET: password di accesso per l'API manager APIMBBONE;

# Getting Started 
Modificare il file di configurazione e compilare il progetto.

# Prerequisites
I prerequisiti per l'installazione della componente sono i seguenti:
## Software
- [AdoptOpenJDK 11](https://openjdk.org)
- [Apache 2.4](https://www.apache.org)
- [WildFly 23](https://www.wildfly.org)
- [PostgreSQL 15.8](https://www.postgresql.org)

- Tutte le librerie elencate nel citpwaweb.sbom.csv devono essere accessibili per compilare il progetto. Le librerie sono pubblicate su [Maven](https://maven.apache.org/).

# Installing
Installare il file ear sull'ambiente WildFly 23.  

# Versioning
Per la gestione del codice sorgente viene utilizzata Git. Per la gestione del versioning si fa riferimento alla metodologia [Semantic Versioning](https://semver.org/).

# Copyrights
(C) Copyright 2026 Regione Piemonte

# License
[EUPL-1.2](https://joinup.ec.europa.eu/collection/eupl/eupl-text-11-12) Compatibile. Consulta il file [LICENSE.txt](LICENSE.txt) per i dettagli sulla licenza.