# versione v3.14.4.Final-csi-1.0.0

* aggiornamento versione di kickstart del progetto quarkus (3.14.4)
* eliminazione della dipendenza dell'exporter opentelemetry (non più utile in quanto 
  la chart helm prevede l'instrumentazione automatica; inoltre l'assenza della versione
  rendeva non più funzionante il pom.xml dopo il passaggio alla versione 3.14.4 di quarkus)
* upgrade della versione del generatore swagger custom-csi (v. 1.1.0.002)
* spostamento delle classi generate da swagger sotto *target*

# versione v3.4.2.Final-csi-1.0.0

versione di partenza