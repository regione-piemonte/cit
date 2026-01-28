/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.util;

public class Messages {

	// Classe che contieni le costanti MESSAGGI
	public static final String ERROR_RECUPERO_DB = "Errore durante il recupero dei dati";
	public static final String ERROR_INSERT_DB = "Errore durante l'inserimento dei dati. Contattare l'amministratore di sistema";
	public static final String ERROR_UPDATE_DB = "Errore durante l'aggiornamento dei dati. Contattare l'amministratore di sistema";
	public static final String ERROR_GENERAZIONE_MODULO = "Errore nella generazione del modulo";
	public static final String ERROR_RECUPERO_SERVIZIO = "Errore durante il recupero dei dati dal servizio";
	public static final String ERROR_NESSUN_LIBRETTO_CONSOLIDATO_TROVATO = "Non sono presenti libretti consolidati negli ultimi 5";
	public static final String ERROR_IMPIANTO_NON_CENSITO = "Impossibile procedere. Impianto non ancora censito";
	public static final String ERROR_LIBRETTO_IMPIANTO_PRESENTE = "Impossibile procedere. L'impianto ha gia' un libretto";
	public static final String ERROR_RUOLO_UTENTE_LOGGATO = "XML corretto. Con il ruolo attuale non si puo' procedere poiche' non e' possibile associare il manutentore alle componenti della scheda 4";
	public static final String ERROR_IMPIANTO_NON_CENTRALIZZATO = "Prima di procedere e' necessario eseguire un aggiornamento dei dati di ubicazione dell'impianto";
	public static final String ERROR_CODICE_IMPIANTO_DIVERSO_DA_CODICE_CATASTO = "Il codice impianto indicato sull' XML e' diverso da quello comunicato tra i parametri in input";
	public static final String ERROR_DATA_INTERVENTO_PRECEDENTE_DATA_CONTROLLO = "Non e' possibile indicare una data intervento raccomandato precedente alla data del rapporto di controllo";
	public static final String ERROR_FORMAT_DATA_CONTROLLO = "Formato della data controllo non valido";
	public static final String ERROR_PORTATA_COMBUSTIBILE_NON_TROVATA = "Errore: portata combustibile senza alcuna unita' di misura";
	public static final String ERROR_PORTATA_COMBUSTIBILE_NON_COERENTE = "Errore: unita' di misura della portata combustibile non coerente con il valore atteso";
	public static final String ERROR_NESSUN_RESPONSABILE_A_DATA_CONTROLLO = "Errore: impossibile creare il rapporto di controllo in quanto non esiste una responsabile o un terzo responsabile valido alla data del controllo ##value1## sull'impianto ##value2##";
	public static final String ERROR_NESSUN_RESPONSABILE_A_DATA_CORRENTE = "Errore: impossibile creare la versione aggiornata del libretto in quanto non esiste una responsabile valido alla data odierna ##value1## sull'impianto ##value2##";
	public static final String ERROR_RESPONSABILE_ASSENTE = "Non esistono responsabili attivi";
	public static final String ERROR_IMPOSSIBILE_CONSOLIDARE = "Impossibile consolidare";
	public static final String ERROR_TIPO_CONTROLLO = "Tipo controllo non valido";
	public static final String ERROR_TOKEN_NON_VALIDO = "TOKEN non valido";
	public static final String ERROR_FORMALE_POD = "POD formalmente errato";
	public static final String ERROR_FORMALE_PDR = "PDR formalmente errato";
	public static final String ERROR_FORMALE_DATA = "data formalmente errata";
	public static final String ERROR_DATA_FUTURA = "non e' possibile inserire una data futura";
	public static final String S027 = "non e' possibile modificare la localizzazione dell'impianto";
	public static final String ERROR_FIELD_FORMAL_ERROR = "campo non corretto";
	public static final String ERROR_CAMPO_ABBIGATORIO = "il campo e' obbligatorio";
	public static final String ERROR_IMPRESA_CESSATA = "L'impresa non puo' operare";
	public static final String ERROR_IMPRESA_NON_ABILITATA_SU_IMPIANTO = "L'impresa non e' abilitata sull'impianto";
	public static final String ERROR_LIBRETTO_NON_TROVATO = "Libretto non trovato";
	public static final String ERROR_CODICE_IMPIANTO_NON_VALIDO = "Codice impianto non valido";
	public static final String ERROR_UTENTE_NON_ABILITATO = "Errore: utente non abilitato alla fruizione del servizio";
	

	public static final String S044 = "non si posseggono i privilegi per visionare e/o operare sul documento selezionato";
	public static final String S052 = "il manutentore ha cessato l'attivita' in data ##value## non e' possibile inserire una data di controllo successiva";
	public static final String S096 = "Errore: il file non e' presente oppure non ha il formato richiesto (##value##)";
	public static final String S097 = "nome file non coerente con le specifiche";
	public static final String S098 = "struttura file non conforme all'XSD concordato";
	public static final String S099 = "codice impianto ##value## sprovvisto di libretto consolidato";
	public static final String S100 = "il manutentore indicato ##value## non censito";
	public static final String S101 = "il manutentore indicato ##value## non risulta associato all'impianto ##valueCodImpianto## alla data attuale per la tipologia REE ##valueTipoAllegato##";
	public static final String S102 = "la data controllo non puo' essere futura (##value##)";
	public static final String S103 = "il bollino indicato ##value## non e' corretto";
	public static final String S105 = "il tag ##value## non e' coerente con il valore atteso";
	public static final String S106 = "La componente ##value1## non risulta associata al manutentore ##value2## oppure risulta dismessa";
	public static final String S107_GT = "composizione impianto ##value## discordante da quanto presente su CIT. Verificare le prove fumi dei componenti GT";
	public static final String S107_GF = "composizione impianto ##value## discordante da quanto presente su CIT. Verificare i circuiti dei componenti GF";
	public static final String S130 = "incongruenza sulle date per il componente ##value1##-##value2## installato il ##value3##: la data di installazione deve essere successiva o uguale alla data di dismissione del medesimo";
	public static final String S131 = "incongruenza sulle date per il componente ##value1##-##value2##: la data di installazione [##value3##] deve essere successiva alla data di dismissione [##value4##]";
	public static final String S132 = "incongruenza sul GT collegato per la componente ##value1##-##value2##, il GT-##value3## non e' presente";
	public static final String S133 = "il dato ##value1## ##value2## non e' presente nel sistema";
	public static final String S134 = "incongruenza sulla data per il componente ##value1##-##value2##: la data ##value3## non puo' essere futura";
	public static final String S137 = "selezionare almeno un elemento della sezione ##value##";
	public static final String S142 = "incongruenza sulle date per il componente ##value1##-##value2##: la data di installazione [##value3##] deve essere successiva alla data di installazione [##value4##]";
	public static final String S143 = "incongruenza sulle date per il componente ##value1##-##value2##: la data di dismissione [##value3##] deve essere successiva alla data di dismissione [##value4##]";
	public static final String S147 = "non e' possibile procedere in quanto la ditta indicata (##value1## CF/PIVA ##value2##) e' in stato RADIATO o SOSPESO";
	public static final String S157 = "codice impianto ##value## prima di procedere e' necessario eseguire un aggiornamento dei dati di ubicazione dell'impianto";
	public static final String S160 = "occorre prima verificare e salvare la seguente componente: ##value##";
	public static final String S161 = "errore durante il controllo di verifica della seguente componente: ##value##";
	public final static String S163 = "il file ha un nome che supera il massimo consentito (##value##)";
	public static final String S170 = "il campo ##value1## e' obbligatorio perche' il componente e' stato installato dopo il ##value2##";

	public static final String PDR_OBBLIGATORIO = "bisogna indicare il pdr o dichiare che non e' presente";

	public static final String INFO_ALLEGATO_INVIATO_CORRETTAMENTE = "l'allegato e' stato inviato correttamente";
	public static final String INFO_ALLEGATO_INVIATO_IMP_NON_VALVOLE = "<BR><font color=\"red\">l'impianto centralizzato oggetto del presente rapporto di controllo, non e' conforme all'obbligo di installazione di un sistema di contabilizzazione / ripartizione ai sensi del dlgs 102/2014 e non risulta caricata nessuna relazione di deroga all'obbligo</font>";
	public static final String INFO_ALLEGATO_INVIATO_NON_SICURO = "<BR><font color=\"red\">In caso di carenze riscontrate in materia di sicurezza, tali da arrecare un immediato pericolo alle persone, agli animali domestici e ai beni, deve essere data comunicazione al Comune su cui insiste l'impianto</font>";

	public static final String ERROR_LUNGHEZZA_MASSIMA = "il campo accetta massimo ##value## caratteri alfanumerici";
	public static final String ERROR_DATA_RESPONSABILE = "la data di fine responsabilita' deve essere uguale o successiva alla data di inizio responsabilita'";

	public static final String ERROR_PARTITA_IVA = "partita iva formalmente errata";
	public static final String ERROR_SOLO_NUMERICI = "il campo deve essere numerico";
	public static final String ERROR_FORMALE_CODICE_FISCALE = "codice fiscale formalmente errato";

	public static final String ERROR_CF_NON_CERCATO = "il codice fiscale inserito e' gia' presente nel sistema. Per associarlo all'impianto premere il tasto 'cerca'";

	public static final String S164_3 = "non e' possibile dismettere o eliminare il componente in quanto e' presente un REE o manutenzione o rapporto di prova con data controllo ##value##";

	public static final String S224_2 = "La componente non puo' essere eliminata poiche' esistono Bruciatori/Recuperatori ad essa associati";

	public static final String ERROR_CODICE_REA_NON_CERCATO = "il codice REA e codice fiscale inserito e' gia' presente nel sistema. Per associarlo all'impianto premere il tasto 'cerca'";

	public static final String INFO_INDIRIZZI_MAIL_OK = "E-mail inviate: ##value##";
	public static final String INFO_INDIRIZZI_MAIL_KO = "<font color=\"red\">E-mail non inviate (verificare l'indirizzo mail): ##value##</font>";
	public static final String INFO_AZIONE_CORRETTA = "l'azione e' stata caricata correttamente";
	public static final String INFO_NESSUNA_MAIL_INVIATA = "Non e' stata inviata nessuna mail";
	public static final String S122 = "il REE e' legato ad una ispezione, la gestione puo' avvenire nella funzione ispezioni";
	public static final String S055 = "libretto in BOZZA. Non e' possibile creare un nuovo REE";

	public static final String S040 = "il REE puo' essere modificato o inviato solo da chi lo ha generato e se in stato BOZZA";
	public static final String S040_RAPP_PROVA = "il Rapporto di Prova puo' essere modificato o inviato solo se in stato BOZZA";
	public static final String ERROR_RESPONSABILE_DATA_RAPP_ASSENTE = "non esistono responsabili attivi alla data controllo";
	public static final String ERROR_RECUPERO_PERSONA_GIURIDICA = "Non trovata alcuna persona giuridica";
	public static final String ERROR_LIBRETTO_COMP_NON_CONTROLLATE = "occorre prima verificare le seguenti componenti: ##value##";

	public static final String ERROR_LIBRETTO_NON_CONTROLLATO = "Occorre prima verificare il libretto";
	public static final String S092 = "Errore: impossibile procedere con il salvataggio delle modifiche, verificare la data inizio e/o la data fine responsabilita' in modo che sia congruente con le nomine di terza responsabilita' caricate";
	public static final String S162 = "impossibile procedere con il salvataggio delle modifiche, verificare la data inizio e/o la data fine responsabilita' in modo che sia congruente con le date dei rapporti di controllo e delle manutenzioni su cui il responsabile e' tracciato";
	public static final String S057 = "per lo stesso impianto non puo' esistere piu' di un responsabile attivo";

	public static final String ERROR_SERVIZIO_NON_DISPONIBILE = "Servizio non disponibile";
}
