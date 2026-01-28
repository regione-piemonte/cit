/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util;

/**
 * <p>Classe delle costanti applicative.</p>
 *
 * @author GuiGen
 */

//import org.openarchitectureware/workflow/lib/AbstractWorkflowComponent

public interface ConstantsField {
	
	// Accreditamento
	public final static String ACCREDITAMENTO_PERSONA_F_DENOMANAZIONE = "appDatapersonaFisica.denominazione";
	public final static String ACCREDITAMENTO_PERSONA_F_CF = "appDatapersonaFisica.codiceFiscalee";
	public final static String ACCREDITAMENTO_PERSONA_F_ID_PROV_SELEZ = "appDatapersonaFisica.idProvinciaSelez";
	public final static String ACCREDITAMENTO_PERSONA_F_ID_COM_SELEZ = "appDatapersonaFisica.idComuneSelez";
	public final static String ACCREDITAMENTO_PERSONA_F_CAP = "appDatapersonaFisica.cap";

	// Ricerca codici impianto
	public final static String RICERCA_CODICI_COD_IMPIANTO = "appDataricercaCodImpianto.codiceImpianto";
	public final static String RICERCA_CODICI_ID_SIGLA_REA = "appDataricercaCodImpianto.idSiglaRea";
	public final static String RICERCA_CODICI_NUMERO_REA = "appDataricercaCodImpianto.numeroRea";
	public final static String RICERCA_CODICI_CF = "appDataricercaCodImpianto.codiceFiscale";
	
	
	// Ricerca allegati
	public final static String RICERCA_ALLEGATI_ID_SIGLA_REA = "appDataricercaAllegati.idReaSigla";
	public final static String RICERCA_ALLEGATI_NUMERO_REA = "appDataricercaAllegati.numeroRea";
	public final static String RICERCA_ALLEGATI_CF = "appDataricercaAllegati.codiceFiscale";
	public final static String RICERCA_ALLEGATI_NUMERO_BOLLINO = "appDataricercaAllegati.numeroBollino";
	public final static String RICERCA_ALLEGATI_DATA_CONTROLLO_DA = "appDataricercaAllegati.DataControlloDa";
	public final static String RICERCA_ALLEGATI_DATA_CONTROLLO_A = "appDataricercaAllegati.DataControlloA";
	public final static String RICERCA_ALLEGATI_DATA_INTERVENTO_DA = "appDataricercaAllegati.interventoDa";
	public final static String RICERCA_ALLEGATI_DATA_INTERVENTO_A = "appDataricercaAllegati.interventoA";
	
	//Allegati
	public final static String DATI_ALLEGATO_DATA_CONTROLLO = "appDataallegato.dataControllo";
	public final static String DATI_ALLEGATO_TIPO_DOCUMENTO = "AppDataallegato.idTipoAllegato";
	public final static String DATI_ALLEGATO_NUMERO_BOLLINO = "AppDataallegato.numeroBollinoVerde";
	public final static String DATI_ALLEGATO_ID_APPARECCHIATURE = "appDataallegato.idApparecchiature";

	// Respingi allegato
	public final static String DATI_ALLEGATO_MOTIVO_RESPINTO = "appDatadettaglioElencoAllegati.motivo";

	
	// Ricerca bollini
	public final static String RICERCA_BOLLINI_ID_SIGLA_REA = "appDataricercaBollini.idSiglaRea";
	public final static String RICERCA_BOLLINI_NUMERO_REA = "appDataricercaBollini.numeroRea";
	public final static String RICERCA_BOLLINI_CF = "appDataricercaBollini.codiceFiscale";

	// Acquista bollini
	public final static String ACQUISTA_BOILLINI_MINORE_35_QUANTITA = "appDataacquistaBollini.qtaMinore35";
	public final static String ACQUISTA_BOILLINI_35_116_QUANTITA = "appDataacquistaBollini.qta35_116";
	public final static String ACQUISTA_BOILLINI_116_350_QUANTITA = "appDataacquistaBollini.qta116_350";
	public final static String ACQUISTA_BOILLINI_MAGGIORE_350_QUANTITA = "appDataacquistaBollini.qtaMaggiore350";
	public final static String ACQUISTA_BOLLINI_CF = "appDataacquistaBollini.codiceFiscaleImpresa";
	public final static String ACQUISTA_BOLLINI_ID_SIGLA_REA = "appDataacquistaBollini.idSiglaRea";
	public final static String ACQUISTA_BOLLINI_NUMERO_REA = "appDataacquistaBollini.numeroRea";
	
	// Ricerca impianto
	public final static String RICERCA_IMPIANTI_COD_IMPIANTO = "appDataricercaImpianti.codiceImpianto";
	public final static String RICERCA_IMPIANTI_ID_PROVINCIA = "appDataricercaImpianti.idProvincia";
	public final static String RICERCA_IMPIANTI_ID_COMUNE = "appDataricercaImpianti.idComune";
	public final static String RICERCA_IMPIANTI_DESC_COMUNE = "appDataricercaImpianti.descComune";
	public final static String RICERCA_IMPIANTI_INDIRIZZO = "appDataricercaImpianti.indirizzo";
	public final static String RICERCA_IMPIANTI_CF_RESPONSABILE = "appDataricercaImpianti.cfResponsabile";
	public final static String RICERCA_IMPIANTI_CF_3RESPONSABILE = "appDataricercaImpianti.cf3Responsabile";
	public final static String RICERCA_IMPIANTI_MATRICOLA_APP = "appDataricercaImpianti.matricolaApparecchiatura";
//	public final static String RICERCA_IMPIANTI_ID_SIGLA_BOLLINO = "appDataricercaImpianti.idSiglaBollino";
//	public final static String RICERCA_IMPIANTI_NUMERO_BOLLINO = "appDataricercaImpianti.numeroBollino";
	public final static String RICERCA_IMPIANTI_ID_SIGLA_REA = "appDataricercaImpianti.idSiglaRea";
	public final static String RICERCA_IMPIANTI_NUMERO_REA = "appDataricercaImpianti.numeroRea";
	public final static String RICERCA_IMPIANTI_CF_IMPRESA = "appDataricercaImpianti.cfImpresa";
	public final static String RICERCA_IMPIANTI_ID_STATO_IMP = "appDataricercaImpianti.idStatoImp";
	
	// Ricerca avanzata impianto
	public final static String RICERCA_AVANZ_IMPIANTI_DESC_COMUNE = "appDataricercaAvanzataImpianti.descComune";
	public final static String RICERCA_AVANZ_IMPIANTI_ID_TIPO_UNITA_MISURA = "appDataricercaAvanzataImpianti.idTipoUnitaMisura";
	
	
	//Risultato ricerca impianti
	public final static String RICERCA_IMPIANTI_DATA_REVOCA = "appDatadataRevocaResponsabile";
	
	// Gestisci impianto
	
	public final static String GESTISCI_IMPIANTO_INST_CF = "appDataimpianto.instCf";
	public final static String GESTISCI_IMPIANTO_INST_SIGLA_REA = "appDataimpianto.instIdSiglaRea";
	public final static String GESTISCI_IMPIANTO_INST_NUM_REA = "appDataimpianto.instNumeroRea";

	public final static String GESTISCI_IMPIANTO_COD_IMP = "appDataimpianto.impCodImpianto";
	public final static String GESTISCI_IMPIANTO_DATA_ASS = "appDataimpianto.impDataAssegnazione";
	public final static String GESTISCI_IMPIANTO_DATA_DISM = "appDataimpianto.impDataDismissione";
	public final static String GESTISCI_IMPIANTO_ID_STATO_IMP = "appDataimpianto.impIdStatoImp";
	public final static String GESTISCI_IMPIANTO_MOTIVAZIONE = "appDataimpianto.impMotivazione";

	public final static String GESTISCI_IMPIANTO_TIPO_IMPIANTO = "appDataimpianto.impTipoImpianto";
	public final static String GESTISCI_IMPIANTO_FLG_APPARECC_UI_EXT = "appDataimpianto.impFlgAppareccUiExt";
	public final static String GESTISCI_IMPIANTO_FLG_CONTABILIZZATORE = "appDataimpianto.impFlgContabilizzatore";
	public final static String GESTISCI_IMPIANTO_FLG_MEDIO_IMPIANTO_CIVILE = "appDataimpianto.impFlgMedioCivile";
	
	public final static String GESTISCI_IMPIANTO_LOC_ID_PROVINCIA = "appDataimpianto.impLocIdProvincia";
	public final static String GESTISCI_IMPIANTO_LOC_ID_COMUNE = "appDataimpianto.impLocIdComune";
	public final static String GESTISCI_IMPIANTO_LOC_INDIRIZZO = "appDataimpianto.impLocIndirizzo";
	public final static String GESTISCI_IMPIANTO_LOC_CAP = "appDataimpianto.impLocCap";

	public final static String GESTISCI_IMPIANTO_LOC_ID_INDIRIZZO = "appDataimpianto.impLocIdIndirizzo";
	public final static String GESTISCI_IMPIANTO_LOC_INDIRIZZO_NON_TROVATO = "appDataimpianto.impLocIndirizzoNoStrad";
	public final static String GESTISCI_IMPIANTO_LOC_CIVICO = "appDataimpianto.impLocCivico";
	public final static String GESTISCI_IMPIANTO_LOC_FOGLIO = "appDataimpianto.impLocFoglio";
	public final static String GESTISCI_IMPIANTO_LOC_PARTICELLA = "appDataimpianto.impLocParticella";
	public final static String GESTISCI_IMPIANTO_LOC_EDIF_NON_ACCATASTATO = "appDataimpianto.impLocEdifNonAcc";
	public final static String GESTISCI_IMPIANTO_LOC_PALAZZO = "appDataimpianto.impLocPalazzo";
	public final static String GESTISCI_IMPIANTO_LOC_POD = "appDataimpianto.impLocPod";
	public final static String GESTISCI_IMPIANTO_LOC_PDR = "appDataimpianto.impLocPdr";
	public final static String GESTISCI_IMPIANTO_LOC_PDR_NON_PRES = "appDataimpianto.impLocPdrNonPres";
	public final static String GESTISCI_IMPIANTO_LOC_SCALA = "appDataimpianto.impLocScala";
	public final static String GESTISCI_IMPIANTO_LOC_SEZIONE = "appDataimpianto.impLocSezione";

	public final static String GESTISCI_IMPIANTO_LOC_NOTE = "appDataimpianto.impLocNote";
	
	
	
	
	// Gestisci responsabile
	public final static String GESTISCI_RESPONSABILE_ID_TITOLO = "appDataresponsabile.idTitolo";
	public final static String GESTISCI_RESPONSABILE_FLG_IMPRESA = "appDataresponsabile.flgImpresa";

	public final static String GESTISCI_RESPONSABILE_PEC= "appDataresponsabile.pec";
	public final static String GESTISCI_RESPONSABILE_TELEFONO= "appDataresponsabile.telefono";



	public final static String GESTISCI_RESPONSABILE_ID_SIGLA_REA = "appDataresponsabile.idSiglaRea";
	public final static String GESTISCI_RESPONSABILE_NUMERO_REA = "appDataresponsabile.numeroRea";
	
	public final static String GESTISCI_RESPONSABILE_CF = "appDataresponsabile.codiceFiscale";
	public final static String GESTISCI_RESPONSABILE_COGNOME = "appDataresponsabile.cognome";
	public final static String GESTISCI_RESPONSABILE_NOME = "appDataresponsabile.nome";


	public final static String GESTISCI_RESPONSABILE_ID_PROVINCIA = "appDataresponsabile.idProvincia";
	public final static String GESTISCI_RESPONSABILE_ID_COMUNE = "appDataresponsabile.idComune";
	public final static String GESTISCI_RESPONSABILE_INDIRIZZO = "appDataresponsabile.indirizzo";
	public final static String GESTISCI_RESPONSABILE_ID_INDIRIZZO = "appDataresponsabile.idIndirizzo";
	public final static String GESTISCI_RESPONSABILE_INDIRIZZO_NON_TROVATO = "appDataresponsabile.indirizzoNoStrad";
	public final static String GESTISCI_RESPONSABILE_CAP = "appDataresponsabile.cap";

	public final static String GESTISCI_RESPONSABILE_EST_STATO = "appDataresponsabile.estStato";
	public final static String GESTISCI_RESPONSABILE_EST_CITTA = "appDataresponsabile.estCitta";
	public final static String GESTISCI_RESPONSABILE_EST_INDIRIZZO = "appDataresponsabile.estIndirizzo";
	public final static String GESTISCI_RESPONSABILE_EST_CAP = "appDataresponsabile.estCap";

	
	public final static String GESTISCI_RESPONSABILE_DATA_INIZIO = "appDataresponsabile.dataInizioResp";
	public final static String GESTISCI_RESPONSABILE_DATA_FINE = "appDataresponsabile.dataFineResp";
	

	// Acquisisci codice
	public final static String ACQUISISCI_CODICE_CF = "appDataacquisizioneCodiciImpianto.codiceFiscale";
	public final static String ACQUISISCI_CODICE_SIGLA_REA = "appDataacquisizioneCodiciImpianto.idSiglaRea";
	public final static String ACQUISISCI_CODICE_NUM_REA = "appDataacquisizioneCodiciImpianto.numeroRea";

	public final static String ACQUISISCI_CODICE_QUANTITA = "appDataacquisizioneCodiciImpianto.quantita";
	
	// Subentro
	public final static String GESTISCI_SUBENTRO_RESP_IMP_CF = "appDatasubentro.respImpCf";
	public final static String GESTISCI_SUBENTRO_RESP_IMP_SIGLA_REA = "appDatasubentro.respImpIdSiglaRea";
	public final static String GESTISCI_SUBENTRO_RESP_IMP_NUM_REA = "appDatasubentro.respImpNumeroRea";

	public final static String GESTISCI_SUBENTRO_COD_IMP = "appDatasubentro.impCodImpianto";

	public final static String GESTISCI_SUBENTRO_LOC_ID_PROVINCIA = "appDatasubentro.impLocIdProvincia";
	public final static String GESTISCI_SUBENTRO_LOC_ID_COMUNE = "appDatasubentro.impLocIdComune";
	public final static String GESTISCI_SUBENTRO_LOC_INDIRIZZO = "appDatasubentro.impLocIndirizzo";
	public final static String GESTISCI_SUBENTRO_LOC_CAP = "appDatasubentro.impLocCap";

	public final static String GESTISCI_SUBENTRO_LOC_ID_INDIRIZZO = "appDatasubentro.impLocIdIndirizzo";
	public final static String GESTISCI_SUBENTRO_LOC_INDIRIZZO_NON_TROVATO = "appDatasubentro.impLocIndirizzoNoStrad";

	public final static String GESTISCI_SUBENTRO_ID_TIPO = "appDatasubentro.idTipoSubentro";
	public final static String GESTISCI_SUBENTRO_ID_APPARECCHIATURE = "appDatasubentro.idApparecchiature";

	
	// Delega
	public final static String GESTISCI_DELEGA_IMP_CF = "appDatadelega.impCf";
	public final static String GESTISCI_DELEGA_IMP_SIGLA_REA = "appDatadelega.impIdSiglaRea";
	public final static String GESTISCI_DELEGA_IMP_NUM_REA = "appDatadelega.impNumeroRea";
	
	public final static String GESTISCI_DELEGA_CF = "appDatadelega.codiceFiscale";

	// Incarico
	public final static String GESTISCI_INCARICO_IMP_CF = "appDataincarico.impCf";
	public final static String GESTISCI_INCARICO_IMP_SIGLA_REA = "appDataincarico.impIdSiglaRea";
	public final static String GESTISCI_INCARICO_IMP_NUM_REA = "appDataincarico.impNumeroRea";
	
	public final static String GESTISCI_INCARICO_ID_CAT = "appDataincaricato.idIncaricato";

	// Terzo Responsabile
	public final static String GESTISCI_3_RESPONSABILE_RESP_IMP_CF = "appDataterzoResponsabile.respImpCf";
	public final static String GESTISCI_3_RESPONSABILE_RESP_IMP_SIGLA_REA = "appDataterzoResponsabile.respImpIdSiglaRea";
	public final static String GESTISCI_3_RESPONSABILE_RESP_IMP_NUM_REA = "appDataterzoResponsabile.respImpNumeroRea";
	public final static String GESTISCI_3_RESPONSABILE_RESP_DENOMINAZIONE = "appDataterzoResponsabile.respImpImpresa";
	
	public final static String GESTISCI_3_RESPONSABILE_COD_IMP = "appDataterzoResponsabile.impCodImpianto";
	
	public final static String GESTISCI_3_RESPONSABILE_LOC_ID_PROVINCIA = "appDataterzoResponsabile.impLocIdProvincia";
	public final static String GESTISCI_3_RESPONSABILE_LOC_ID_COMUNE = "appDataterzoResponsabile.impLocIdComune";
	public final static String GESTISCI_3_RESPONSABILE_LOC_INDIRIZZO = "appDataterzoResponsabile.impLocIndirizzo";
	public final static String GESTISCI_3_RESPONSABILE_LOC_ID_INDIRIZZO = "appDataterzoResponsabile.impLocIdIndirizzo";
	public final static String GESTISCI_3_RESPONSABILE_LOC_INDIRIZZO_NON_TROVATO = "appDataterzoResponsabile.impLocIndirizzoNoStrad";
	public final static String GESTISCI_3_RESPONSABILE_LOC_CAP = "appDataterzoResponsabile.impLocCap";

	public final static String GESTISCI_3_RESPONSABILE_DATA_INIZIO = "appDataterzoResponsabile.dataInizioContratto";
	public final static String GESTISCI_3_RESPONSABILE_DATA_FINE = "appDataterzoResponsabile.dataFineContratto";
	
	public final static String GESTISCI_3_RESPONSABILE_ID_APPARECCHIATURE = "appDataterzoResponsabile.idApparecchiature";
	
	// Ispezioni
	public final static String DATI_ISPEZIONE_CF_ISPETTORE = "appDataispezione.ispettoreCF";
	public final static String DATI_ISPEZIONE_DATA_ISPEZIONE = "appDataispezione.dataIspezione";
	public final static String DATI_ISPEZIONE_ENTE_COMPETENTE = "appDataispezione.enteCompetente";
	public final static String DATI_ISPEZIONE_ESITO_ISPEZIONE = "appDataispezione.esitoIspezione";
	
	//Allegati
	public final static String DATI_ALLEGATO_ISP_DATA_CONTROLLO = "appDataallegatoIsp.dataControllo";
	public final static String DATI_ALLEGATO_ISP_TIPO_DOCUMENTO = "appDataallegatoIsp.idTipoAllegato";
	public final static String DATI_ALLEGATO_ISP_NUMERO_BOLLINO = "appDataallegatoIsp.numeroBollinoVerde";
	public final static String DATI_ALLEGATO_ISP_ID_APPARECCHIATURE = "appDataallegatoIsp.idApparecchiature";

	// 	Distributori
	public final static String GESTISCI_DISTRIBUTORI_CF = "appDatadistributori.distrCf";
	public final static String GESTISCI_DISTRIBUTORI_SIGLA_REA = "appDatadistributori.distrIdSiglaRea";
	public final static String GESTISCI_DISTRIBUTORI_NUM_REA = "appDatadistributori.distrNumeroRea";
	
	// Impresa
	public final static String GESTISCI_IMPRESA_RIC_SIGLA_REA = "appDataricercaImprese.siglaRea";
	public final static String GESTISCI_IMPRESA_RIC_NUMERO_REA = "appDataricercaImprese.numeroRea";
	public final static String GESTISCI_IMPRESA_RIC_CF = "appDataricercaImprese.codiceFiscale";
	public final static String GESTISCI_IMPRESA_RIC_DENOMINAZIONE = "appDataricercaImprese.denominazione";
	
	public final static String GESTISCI_IMPRESA_SIGLA_REA = "appDataimpresa.siglaRea";
	public final static String GESTISCI_IMPRESA_NUMERO_REA = "appDataimpresa.numeroRea";
	public final static String GESTISCI_IMPRESA_DENOMINAZIONE = "appDataimpresa.denominazione";
	public final static String GESTISCI_IMPRESA_CODICE_FISCALE = "appDataimpresa.codiceFiscale";
	public final static String GESTISCI_IMPRESA_DATA_INIZIO_ATTIVITA = "appDataimpresa.dataInizioAttivita";
	public final static String GESTISCI_IMPRESA_DATA_CESSAZIONE = "appDataimpresa.dataCessazione";
	public final static String GESTISCI_IMPRESA_DATA_VARIAZIONE = "appDataimpresa.dataVariazione";
	public final static String GESTISCI_IMPRESA_MOTIVO_VARIAZIONE = "appDataimpresa.motivoVariazione";
	
	public final static String GESTISCI_IMPRESA_ID_PROVINCIA = "appDataimpresa.idProvinciaSelez";
	public final static String GESTISCI_IMPRESA_ID_COMUNE = "appDataimpresa.idComuneSelez";
	public final static String GESTISCI_IMPRESA_ID_IND_SELEZ = "appDataimpresa.idIndirizzoSel";
	public final static String GESTISCI_IMPRESA_IND_NON_TROVATO = "appDataimpresa.indirizzoNonTrovato";
	public final static String GESTISCI_IMPRESA_INDIRIZZO = "appDataimpresa.indirizzo";
	public final static String GESTISCI_IMPRESA_CAP = "appDataimpresa.cap";
	
	public final static String GESTISCI_IMPRESA_EST_STATO = "appDataimpresa.estStato";
	public final static String GESTISCI_IMPRESA_EST_CITTA = "appDataimpresa.estCitta";
	public final static String GESTISCI_IMPRESA_EST_INDIRIZZO = "appDataimpresa.estIndirizzo";
	
	public final static String GESTISCI_IMPRESA_EMAIL = "appDataimpresa.email";
	public final static String GESTISCI_IMPRESA_PEC = "appDataimpresa.pec";
	public final static String GESTISCI_IMPRESA_ID_RUOLO_ACC = "appDataimpresa.idRuoloAccred";
	public final static String GESTISCI_IMPRESA_TIPO_DM = "appDataimpresa.tipoDm";
	public final static String GESTISCI_IMPRESALAG_MANUTENTORE = "appDataimpresa.flgManutentore";
	public final static String GESTISCI_IMPRESALAG_AMMINISTRATORE = "appDataimpresa.flgAmministratore";
	public final static String GESTISCI_IMPRESALAG_INSTALLATORE = "appDataimpresa.flgInstallatore";
	public final static String GESTISCI_IMPRESALAG_3RESPONSABILE = "appDataimpresa.flgTerzoResponsabile";
	public final static String GESTISCI_IMPRESALAG_DISTRIBUTORE = "appDataimpresa.flgDistributore";
	public final static String GESTISCI_IMPRESALAG_CAT = "appDataimpresa.flgCat";
	public final static String GESTISCI_IMPRESALAG_SOGG_INCARICATO = "appDataimpresa.flgSoggIncaricato";
	public final static String GESTISCI_IMPRESALAG_DELEGA_SOGG_INCARICATO = "appDataimpresa.delegaSoggIncaricato";
	

	// Gestisci responsabile
	public final static String GESTISCI_DOCUMENTO_ID_TIPO_DOC = "appDatadocumento.idTipoDocumento";
	public final static String GESTISCI_DOCUMENTO_DESC_ALTRO_DOC = "appDatadocumento.descAltroDoc";
	
	public final static String GESTISCI_EXPORT_XML = "appDataelencoCodImpianto";


	// Libretto

	//Scheda4_7
	public final static String GESTISCI_LIBRETTO4_7_DATA_INSTALLAZIONE = "appDatacomponenteCS.dataInstallazione";
	public final static String GESTISCI_LIBRETTO4_7_DATA_DISMISSIONE = "appDatacomponenteCS.dataDismissione";
	public final static String GESTISCI_LIBRETTO4_7_ID_FABBRICANTE = "appDatacomponenteCS.idFabbricante";
	public final static String GESTISCI_LIBRETTO4_7_COLLETTORI = "appDatacomponenteCS.collettori";
	public final static String GESTISCI_LIBRETTO4_7_SUP_TOT_AP = "appDatacomponenteCS.supTotAp";


	//Scheda4_8
	public final static String GESTISCI_LIBRETTO4_8_DATA_INSTALLAZIONE = "appDatacomponenteAG.dataInstallazione";
	public final static String GESTISCI_LIBRETTO4_8_DATA_DISMISSIONE = "appDatacomponenteAG.dataDismissione";
	public final static String GESTISCI_LIBRETTO4_8_ID_FABBRICANTE = "appDatacomponenteAG.idFabbricante";
	public final static String GESTISCI_LIBRETTO4_8_MODELLO = "appDatacomponenteAG.modello";
	public final static String GESTISCI_LIBRETTO4_8_MATRICOLA = "appDatacomponenteAG.matricola";
	public final static String GESTISCI_LIBRETTO4_8_TIPOLOGIA = "appDatacomponenteAG.tipologia";
	public final static String GESTISCI_LIBRETTO4_8_POTENZA = "appDatacomponenteAG.potenza";


	//Scheda5_1SR
	public final static String GESTISCI_LIBRETTO5_1SR_DATA_INSTALLAZIONE = "appDatacomponenteSR.dataInstallazione";
	public final static String GESTISCI_LIBRETTO5_1SR_DATA_DISMISSIONE = "appDatacomponenteSR.dataDismissione";
	public final static String GESTISCI_LIBRETTO5_1SR_ID_FABBRICANTE = "appDatacomponenteSR.idFabbricante";
	public final static String GESTISCI_LIBRETTO5_1SR_MODELLO = "appDatacomponenteSR.modello";
	public final static String GESTISCI_LIBRETTO5_1SR_NUM_PUNTI = "appDatacomponenteSR.numPunti";
	public final static String GESTISCI_LIBRETTO5_1SR_NUM_LIVELLI = "appDatacomponenteSR.numLivelli";


	//Scheda5_1VR
	public final static String GESTISCI_LIBRETTO5_1VR_DATA_INSTALLAZIONE = "appDatacomponenteVR.dataInstallazione";
	public final static String GESTISCI_LIBRETTO5_1VR_DATA_DISMISSIONE = "appDatacomponenteVR.dataDismissione";
	public final static String GESTISCI_LIBRETTO5_1VR_ID_FABBRICANTE = "appDatacomponenteVR.idFabbricante";
	public final static String GESTISCI_LIBRETTO5_1VR_MODELLO = "appDatacomponenteVR.modello";
	public final static String GESTISCI_LIBRETTO5_1VR_NUM_VIE = "appDatacomponenteVR.numVie";
	public final static String GESTISCI_LIBRETTO5_1VR_SERVOMOTORE = "appDatacomponenteVR.servomotore";


	//Scheda6_4
	public final static String GESTISCI_LIBRETTO6_4_DATA_INSTALLAZIONE = "appDatacomponentePO.dataInstallazione";
	public final static String GESTISCI_LIBRETTO6_4_DATA_DISMISSIONE = "appDatacomponentePO.dataDismissione";
	public final static String GESTISCI_LIBRETTO6_4_ID_FABBRICANTE = "appDatacomponentePO.idFabbricante";
	public final static String GESTISCI_LIBRETTO6_4_MODELLO = "appDatacomponentePO.modello";
	public final static String GESTISCI_LIBRETTO6_4_FLG_GIRI_VARIABILI = "appDatacomponentePO.flgGiriVariabili";
	public final static String GESTISCI_LIBRETTO6_4_POTENZA = "appDatacomponentePO.potenza";

	
	//Scheda8
	public final static String GESTISCI_LIBRETTO8_DATA_INSTALLAZIONE = "appDatacomponenteAC.dataInstallazione";
	public final static String GESTISCI_LIBRETTO8_DATA_DISMISSIONE = "appDatacomponenteAC.dataDismissione";
	public final static String GESTISCI_LIBRETTO8_ID_FABBRICANTE = "appDatacomponenteAC.idFabbricante";
	public final static String GESTISCI_LIBRETTO8_MODELLO = "appDatacomponenteAC.modello";
	public final static String GESTISCI_LIBRETTO8_MATRICOLA = "appDatacomponenteAC.matricola";
	public final static String GESTISCI_LIBRETTO8_CAPACITA = "appDatacomponenteAC.capacita";
	public final static String GESTISCI_LIBRETTO8_COIBENTAZIONE = "appDatacomponenteAC.coibentazione";

	//Scheda9_1
	public final static String GESTISCI_LIBRETTO9_1_DATA_INSTALLAZIONE = "appDatacomponenteTE.dataInstallazione";
	public final static String GESTISCI_LIBRETTO9_1_DATA_DISMISSIONE = "appDatacomponenteTE.dataDismissione";
	public final static String GESTISCI_LIBRETTO9_1_ID_FABBRICANTE = "appDatacomponenteTE.idFabbricante";
	public final static String GESTISCI_LIBRETTO9_1_MODELLO = "appDatacomponenteTE.modello";
	public final static String GESTISCI_LIBRETTO9_1_MATRICOLA = "appDatacomponenteTE.matricola";
	public final static String GESTISCI_LIBRETTO9_1_CAPACITA = "appDatacomponenteTE.capacita";
	public final static String GESTISCI_LIBRETTO9_1_NUM_VENTILATORI = "appDatacomponenteTE.numVentilatori";

	//Scheda9_2
	public final static String GESTISCI_LIBRETTO9_2_DATA_INSTALLAZIONE = "appDatacomponenteRV.dataInstallazione";
	public final static String GESTISCI_LIBRETTO9_2_DATA_DISMISSIONE = "appDatacomponenteRV.dataDismissione";
	public final static String GESTISCI_LIBRETTO9_2_ID_FABBRICANTE = "appDatacomponenteRV.idFabbricante";
	public final static String GESTISCI_LIBRETTO9_2_MODELLO = "appDatacomponenteRV.modello";
	public final static String GESTISCI_LIBRETTO9_2_MATRICOLA = "appDatacomponenteRV.matricola";
	public final static String GESTISCI_LIBRETTO9_2_NUM_VENTILATORI = "appDatacomponenteRV.numVentilatori";

	//Scheda9_3
	public final static String GESTISCI_LIBRETTO9_3_DATA_INSTALLAZIONE = "appDatacomponenteSCX.dataInstallazione";
	public final static String GESTISCI_LIBRETTO9_3_DATA_DISMISSIONE = "appDatacomponenteSCX.dataDismissione";
	public final static String GESTISCI_LIBRETTO9_3_ID_FABBRICANTE = "appDatacomponenteSCX.idFabbricante";
	public final static String GESTISCI_LIBRETTO9_3_MODELLO = "appDatacomponenteSCX.modello";

	//Scheda9_4
	public final static String GESTISCI_LIBRETTO9_4_DATA_INSTALLAZIONE = "appDatacomponenteCI.dataInstallazione";
	public final static String GESTISCI_LIBRETTO9_4_DATA_DISMISSIONE = "appDatacomponenteCI.dataDismissione";
	public final static String GESTISCI_LIBRETTO9_4_LUNG_CIRCUITO = "appDatacomponenteCI.lungCircuito";
	public final static String GESTISCI_LIBRETTO9_4_SUP_SCAMBIATORE = "appDatacomponenteCI.supScambiatore";
	public final static String GESTISCI_LIBRETTO9_4_PROF_INSTALLAZ = "appDatacomponenteCI.profInstallaz";

	//Scheda9_5
	public final static String GESTISCI_LIBRETTO9_5_DATA_INSTALLAZIONE = "appDatacomponenteUT.dataInstallazione";
	public final static String GESTISCI_LIBRETTO9_5_DATA_DISMISSIONE = "appDatacomponenteUT.dataDismissione";
	public final static String GESTISCI_LIBRETTO9_5_ID_FABBRICANTE = "appDatacomponenteUT.idFabbricante";
	public final static String GESTISCI_LIBRETTO9_5_MODELLO = "appDatacomponenteUT.modello";
	public final static String GESTISCI_LIBRETTO9_5_MATRICOLA = "appDatacomponenteUT.matricola";
	public final static String GESTISCI_LIBRETTO9_5_PORT_VENT_MAND_LS = "appDatacomponenteUT.portVentMandLs";
	public final static String GESTISCI_LIBRETTO9_5_PORT_VENT_MAND_KW = "appDatacomponenteUT.portVentMandKw";
	public final static String GESTISCI_LIBRETTO9_5_PORT_VENT_RIPRESA_LS = "appDatacomponenteUT.portVentRipresaLs";
	public final static String GESTISCI_LIBRETTO9_5_PORT_VENT_RIPRESA_KW = "appDatacomponenteUT.portVentRipresaKw";

	//Scheda9_6
	public final static String GESTISCI_LIBRETTO9_6_DATA_INSTALLAZIONE = "appDatacomponenteRC.dataInstallazione";
	public final static String GESTISCI_LIBRETTO9_6_DATA_DISMISSIONE = "appDatacomponenteRC.dataDismissione";
	public final static String GESTISCI_LIBRETTO9_6_TIPOLOGIA = "appDatacomponenteRC.tipologia";
	public final static String GESTISCI_LIBRETTO9_6_INSTALLAZIONE = "appDatacomponenteRC.tipoInstall";
	public final static String GESTISCI_LIBRETTO9_6_PORT_VENT_MAND_LS = "appDatacomponenteRC.portVentMandLs";
	public final static String GESTISCI_LIBRETTO9_6_PORT_VENT_MAND_KW = "appDatacomponenteRC.portVentMandKw";
	public final static String GESTISCI_LIBRETTO9_6_PORT_VENT_RIPRESA_LS = "appDatacomponenteRC.portVentRipresaLs";
	public final static String GESTISCI_LIBRETTO9_6_PORT_VENT_RIPRESA_KW = "appDatacomponenteRC.portVentRipresaKw";

	//Scheda10_1
	public final static String GESTISCI_LIBRETTO10_1_DATA_INSTALLAZIONE = "appDatacomponenteVM.dataInstallazione";
	public final static String GESTISCI_LIBRETTO10_1_DATA_DISMISSIONE = "appDatacomponenteVM.dataDismissione";
	public final static String GESTISCI_LIBRETTO10_1_ID_FABBRICANTE = "appDatacomponenteVM.idFabbricante";
	public final static String GESTISCI_LIBRETTO10_1_MODELLO = "appDatacomponenteVM.modello";
	public final static String GESTISCI_LIBRETTO10_1_TIPOLOGIA = "appDatacomponenteVM.idDettVm";
	public final static String GESTISCI_LIBRETTO10_1_DESC_ALTRO = "appDatacomponenteVM.descAltro";
	public final static String GESTISCI_LIBRETTO10_1_PORT_MAX = "appDatacomponenteVM.portMassima";
	public final static String GESTISCI_LIBRETTO10_1_REND_REC = "appDatacomponenteVM.rendimentoRec";

	//Scheda15
	public final static String DATI_MANUTENZIONE_DATA_MANUT = "appDatadettaglioManutenzione.dataManut";
	public final static String DATI_MANUTENZIONE_TIPO_MANUT = "appDatadettaglioManutenzione.idTipoManut";
	public final static String DATI_MANUTENZIONE_ID_APPARECCHIATURE = "appDatadettaglioManutenzione.idApparecchiature";
	public final static String DATI_MANUTENZIONE_ID_TIPO_INTERVENTO = "appDatadettaglioManutenzione.idTipoIntervento";
	public final static String DATI_MANUTENZIONE_ALTRO = "appDatadettaglioManutenzione.altro";
	public final static String DATI_MANUTENZIONE_INTERVENTO_ENTRO = "appDatadettaglioManutenzione.interventoEntro";
	public final static String DATI_MANUTENZIONE_DENOMINAZIONE_TECNICO = "appDatadettaglioManutenzione.denominazTecnico";
	public final static String DATI_MANUTENZIONE_OSSERVAZIONI = "appDatadettaglioManutenzione.osservazioni";
	public final static String DATI_MANUTENZIONE_RACCOMANDAZIONI = "appDatadettaglioManutenzione.raccomandazioni";
	public final static String DATI_MANUTENZIONE_PRESCRIZIONI = "appDatadettaglioManutenzione.prescrizioni";
	
	
	// Documento REE
	public final static String GESTISCI_DOCUMENTO_REE_DESC_DOC = "appDatadocumento.descAltroDoc";

	// Distributore
	public final static String GESTISCI_DISTRIBUTORE_ID_PROVINCIA_FORN = "appDatadistributoreManuale.idProvinciaForn";
	public final static String GESTISCI_DISTRIBUTORE_ID_COMUNE_FORN = "appDatadistributoreManuale.idComuneForn";
	public final static String GESTISCI_DISTRIBUTORE_INDIRIZZO_FORN = "appDatadistributoreManuale.indirizzoForn";
	//public final static String GESTISCI_DISTRIBUTORE_CAP_FORN = "appDatadistributoreManuale.impLocCap";

	public final static String GESTISCI_DISTRIBUTORE_ID_PROVINCIA_FATT = "appDatadistributoreManuale.idProvinciaFatt";
	public final static String GESTISCI_DISTRIBUTORE_ID_COMUNE_FATT = "appDatadistributoreManuale.idComuneFatt";
	public final static String GESTISCI_DISTRIBUTORE_INDIRIZZO_FATT = "appDatadistributoreManuale.indirizzoFatt";
	//public final static String GESTISCI_DISTRIBUTORE_CAP_FATT = "appDatadistributoreManuale.impLocCap";

	public final static String USER_WS_TOKEN_ID_USER_WS_SELECTED = "appDataidUserWsSelected";
	public final static String USER_WS_TOKEN_DATA_SCADENZA = "appDatauserWs.dtScadenzaToken";
	
	//Inserimento ispezioni massive
	public final static String INSERIMENTO_ISPEZIONI_MASSIVE_ID_TIPO_VERIFICA = "appDatainserimentoIspezioniMassive.idTipoVerifica";
	public final static String INSERIMENTO_ISPEZIONI_MASSIVE_ELENCO_VALORI = "appDatainserimentoIspezioniMassive.elencoValori";
}
