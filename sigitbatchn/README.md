# Project Title
SIGITBATCHN

# Project Description
Questa componente è un batch per la gestione degli import dei dati distributori.

# Configurations
Aprire il file buildfiles/dev-rp-01.properties e configurare i seguenti parametri:
- app.jdbc.url: url di configurazione Datasource - jdbc:postgresql://HOST:PORT/DATABASE;
- app.db.username: utente db;
- app.db.password: password db;
- log.path: path ella cartella in cui verranno scritti i log;
- mail.host: host del server di posta;
- mail.port: porta del server di posta;
- mail.user: user del server di posta;
- mail.pwd: pwd del server di posta;
- notify.token: x-authentication per contattare il Notificatore;
- notify.mb.url: servizi di fruizione della gestione delle preferenze sul Notificatore;
- citpwa.url: servizi di fruizione della componente CITPWAWEB;
- index.wsdl.url: servizi di fruizione del gestionale documentale;
- mtom.wsdl.url: servizi di fruizione del gestionale documentale (CXF/MTOM);

# Getting Started 
Modificare il file di configurazione e compilare il progetto. 

# Prerequisites
I prerequisiti per l'installazione della componente sono i seguenti:
## Software
- [JDK 8](https://www.apache.org)
- [PostgreSQL 15.8](https://www.postgresql.org/download/)  

- Tutte le librerie elencate nel sigitbatchn.sbom.csv devono essere accessibili per compilare il progetto. Le librerie sono pubblicate su http://repart.csi.it, ma per semplicità sono state incluse nella cartella lib/.

# Installing
Spacchettare il file tar su filesystem accedere alla cartella sigitbatchn\lib\ ed eseguire il seguente comando:
java -Xms1024m -Xmx1024m -jar sigitbatchn.jar importMassivoDistributori 

# Versioning
Per la gestione del codice sorgente viene utilizzata Git. Per la gestione del versioning si fa riferimento alla metodologia [Semantic Versioning](https://semver.org/).

# Copyrights
(C) Copyright 2026 Regione Piemonte

# License
[EUPL-1.2](https://joinup.ec.europa.eu/collection/eupl/eupl-text-11-12) Compatibile. Consulta il file [LICENSE.txt](LICENSE.txt) per i dettagli sulla licenza.

