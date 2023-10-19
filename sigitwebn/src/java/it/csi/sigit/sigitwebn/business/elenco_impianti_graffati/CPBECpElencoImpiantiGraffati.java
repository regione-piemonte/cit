package it.csi.sigit.sigitwebn.business.elenco_impianti_graffati;

import java.util.*;

import it.csi.sigit.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.dto.accesso.*;
import it.csi.sigit.sigitwebn.dto.codici_impianto.*;
import it.csi.sigit.sigitwebn.dto.common.*;
import it.csi.sigit.sigitwebn.dto.impianto.*;
import it.csi.sigit.sigitwebn.dto.main.*;
import it.csi.sigit.sigitwebn.dto.bollini.*;
import it.csi.sigit.sigitwebn.dto.allegati.*;
import it.csi.sigit.sigitwebn.dto.subentro.*;
import it.csi.sigit.sigitwebn.dto.delega.*;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.*;
import it.csi.sigit.sigitwebn.dto.ispezioni.*;
import it.csi.sigit.sigitwebn.dto.distributori.*;
import it.csi.sigit.sigitwebn.dto.incarico.*;
import it.csi.sigit.sigitwebn.dto.impresa.*;
import it.csi.sigit.sigitwebn.dto.documentazione.*;
import it.csi.sigit.sigitwebn.dto.libretto.*;
import it.csi.sigit.sigitwebn.dto.ree.*;
import it.csi.sigit.sigitwebn.dto.verifica.*;
import it.csi.sigit.sigitwebn.dto.accertamento.*;
import it.csi.sigit.sigitwebn.dto.azioni.*;
import it.csi.sigit.sigitwebn.dto.sanzioni.*;
import it.csi.sigit.sigitwebn.dto.rappprova.*;
import it.csi.sigit.sigitwebn.dto.back_office.*;
import it.csi.sigit.sigitwebn.dto.userws.*;

import org.apache.log4j.*;
import it.csi.sigit.sigitwebn.util.*;
import it.csi.sigit.sigitwebn.business.*;

/*PROTECTED REGION ID(R-911291831) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
/*PROTECTED REGION END*/

public class CPBECpElencoImpiantiGraffati {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [risultatoRicercaImpianti, scope:USER_SESSION]
	public static final String APPDATA_RISULTATORICERCAIMPIANTI_CODE = "appDatarisultatoRicercaImpianti";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [aggiornaElencoImpianti, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOIMPIANTI_CODE = "appDataaggiornaElencoImpianti";

	// ApplicationData: [impianto, scope:USER_SESSION]
	public static final String APPDATA_IMPIANTO_CODE = "appDataimpianto";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [ricercaImpianti, scope:USER_SESSION]
	public static final String APPDATA_RICERCAIMPIANTI_CODE = "appDataricercaImpianti";

	// ApplicationData: [paginaChiamanteImp, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEIMP_CODE = "appDatapaginaChiamanteImp";

	// ApplicationData: [isAbilitazioneDatiAllegato, scope:USER_SESSION]
	public static final String APPDATA_ISABILITAZIONEDATIALLEGATO_CODE = "appDataisAbilitazioneDatiAllegato";

	// ApplicationData: [responsabile, scope:USER_SESSION]
	public static final String APPDATA_RESPONSABILE_CODE = "appDataresponsabile";

	// ApplicationData: [elencoResponsabili, scope:USER_SESSION]
	public static final String APPDATA_ELENCORESPONSABILI_CODE = "appDataelencoResponsabili";

	// ApplicationData: [elencoResponsabiliTemp, scope:USER_SESSION]
	public static final String APPDATA_ELENCORESPONSABILITEMP_CODE = "appDataelencoResponsabiliTemp";

	// ApplicationData: [elencoManutentori, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMANUTENTORI_CODE = "appDataelencoManutentori";

	// ApplicationData: [dataRevocaResponsabileOld, scope:USER_SESSION]
	public static final String APPDATA_DATAREVOCARESPONSABILEOLD_CODE = "appDatadataRevocaResponsabileOld";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [idImpiantoRevoca, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOREVOCA_CODE = "appDataidImpiantoRevoca";

	// ApplicationData: [elencoDettaglioTerzoResponsabile, scope:USER_SESSION]
	public static final String APPDATA_ELENCODETTAGLIOTERZORESPONSABILE_CODE = "appDataelencoDettaglioTerzoResponsabile";

	// ApplicationData: [risultatoRicercaImpiantiSelez, scope:USER_SESSION]
	public static final String APPDATA_RISULTATORICERCAIMPIANTISELEZ_CODE = "appDatarisultatoRicercaImpiantiSelez";

	// ApplicationData: [aggiornaElencoDocumenti, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCODOCUMENTI_CODE = "appDataaggiornaElencoDocumenti";

	// ApplicationData: [paginaChiamanteDocumenti, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEDOCUMENTI_CODE = "appDatapaginaChiamanteDocumenti";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [idAllegatoImpiantoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALLEGATOIMPIANTOSELEZIONATO_CODE = "appDataidAllegatoImpiantoSelezionato";

	// ApplicationData: [verifica, scope:USER_SESSION]
	public static final String APPDATA_VERIFICA_CODE = "appDataverifica";

	// ApplicationData: [provenienza, scope:USER_SESSION]
	public static final String APPDATA_PROVENIENZA_CODE = "appDataprovenienza";

	// ApplicationData: [elencoTipoImpianto, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOIMPIANTO_CODE = "appDataelencoTipoImpianto";

	// ApplicationData: [idImpiantoGrafSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOGRAFSELEZ_CODE = "appDataidImpiantoGrafSelez";

	// ApplicationData: [impiantoApprofondito, scope:USER_SESSION]
	public static final String APPDATA_IMPIANTOAPPROFONDITO_CODE = "appDataimpiantoApprofondito";

	// ApplicationData: [elencoImpiantiGraffati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOIMPIANTIGRAFFATI_CODE = "appDataelencoImpiantiGraffati";

	// ApplicationData: [elencoStoricoVariazioniStatoImpianto, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTORICOVARIAZIONISTATOIMPIANTO_CODE = "appDataelencoStoricoVariazioniStatoImpianto";

	// ApplicationData: [idStoricoStatoSelez, scope:USER_ACTION]
	public static final String APPDATA_IDSTORICOSTATOSELEZ_CODE = "appDataidStoricoStatoSelez";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpElencoImpiantiGraffati";

	public static final String TABSET_TSGRAFFATURA = "tsGraffatura";
	public static final String TAB_TSGRAFFATURA_FPIMPIANTIGRAFFATI = CPNAME + "_" + TABSET_TSGRAFFATURA + "_"
			+ "fpImpiantiGraffati";
	public static final String TAB_TSGRAFFATURA_FPSTORICOVARIAZIONE = CPNAME + "_" + TABSET_TSGRAFFATURA + "_"
			+ "fpStoricoVariazione";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestInserisciImpiantoGraf definito in un ExecCommand del
	 * ContentPanel cpElencoImpiantiGraffati
	 */
	public ExecResults gestInserisciImpiantoGraf(

			it.csi.sigit.sigitwebn.dto.elenco_impianti_graffati.CpElencoImpiantiGraffatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINSERISCIIMPIANTOGRAF_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTINSERISCIIMPIANTOGRAF_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1429572837) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTINSERISCIIMPIANTOGRAF_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestInserisciImpiantoGraf] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisualizzaImpiantoGraf definito in un ExecCommand del
	 * ContentPanel cpElencoImpiantiGraffati
	 */
	public ExecResults gestVisualizzaImpiantoGraf(

			it.csi.sigit.sigitwebn.dto.elenco_impianti_graffati.CpElencoImpiantiGraffatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISUALIZZAIMPIANTOGRAF_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTVISUALIZZAIMPIANTOGRAF_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1365794886) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (GenericUtil.isNullOrEmpty(theModel.getAppDataidImpiantoGrafSelez())) {
				theModel.setAppDataidImpiantoGrafSelez(null);
				result.getGlobalErrors().add("Selezionare una voce dall'elenco.");
				result.setResultCode(GESTVISUALIZZAIMPIANTOGRAF_OUTCOME_CODE__KO);
			} else {
				String chiave = theModel.getAppDataidImpiantoGrafSelez();
				String[] primaryKey = chiave.split("_");
				Impianto impianto = getDbMgr().cercaImpiantoById(primaryKey[1]);
				LogicaVisualizzazione logica = new LogicaVisualizzazione();
				logica.setCaso(Constants.COD_CASO_C);
				logica.setIsImpiantoIndConfermato(true);
				theModel.setAppDataprovenienza(Constants.PAG_ELEN_GRAFF);
				impianto.setLogicaVisual(logica);
				theModel.setAppDataimpianto(impianto);
				result.setResultCode(GESTVISUALIZZAIMPIANTOGRAF_OUTCOME_CODE__OK);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisualizzaImpiantoGraf] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestEliminaImpiantoGraf definito in un ExecCommand del
	 * ContentPanel cpElencoImpiantiGraffati
	 */
	public ExecResults gestEliminaImpiantoGraf(

			it.csi.sigit.sigitwebn.dto.elenco_impianti_graffati.CpElencoImpiantiGraffatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTELIMINAIMPIANTOGRAF_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTELIMINAIMPIANTOGRAF_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1080440161) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// impostazione del result code
			String chiave = theModel.getAppDataidImpiantoGrafSelez();
			if (GenericUtil.isNotNullOrEmpty(chiave)) {
				String[] primaryKey = chiave.split("_");
				UtenteLoggato utente = theModel.getAppDatautenteLoggato();
				getDbMgr().deleteImpiantoGraffatura(primaryKey[1], utente);
				ArrayList<ElencoImpiantiGraffati> elencoImpiantiGraffatiList = getDbMgr()
						.getElencoImpiantiGraffatiByCodImpianto(primaryKey[1]);
				theModel.setAppDataelencoImpiantiGraffati(elencoImpiantiGraffatiList);
				result.setResultCode(GESTELIMINAIMPIANTOGRAF_OUTCOME_CODE__OK);
			} else {
				theModel.setAppDataidImpiantoGrafSelez(null);
				result.getGlobalErrors().add("Selezionare una voce dall'elenco.");
				result.setResultCode(GESTELIMINAIMPIANTOGRAF_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestEliminaImpiantoGraf] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpElencoImpiantiGraffati
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.elenco_impianti_graffati.CpElencoImpiantiGraffatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-881233974) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ISRUOLOABILITATO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isRuoloAbilitato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneAggElenco definito in un ExecCommand del
	 * ContentPanel cpElencoImpiantiGraffati
	 */
	public ExecResults gestioneAggElenco(

			it.csi.sigit.sigitwebn.dto.elenco_impianti_graffati.CpElencoImpiantiGraffatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEAGGELENCO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTIONEAGGELENCO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-622911611) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTIONEAGGELENCO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneAggElenco] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneVisInserisci definito in un ExecCommand del
	 * ContentPanel cpElencoImpiantiGraffati
	 */
	public ExecResults gestioneVisInserisci(

			it.csi.sigit.sigitwebn.dto.elenco_impianti_graffati.CpElencoImpiantiGraffatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISINSERISCI_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISINSERISCI_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1751293067) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			result.setResultCode(GESTIONEVISINSERISCI_OUTCOME_CODE__VISUALIZZA);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneVisInserisci] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneVisElimina definito in un ExecCommand del
	 * ContentPanel cpElencoImpiantiGraffati
	 */
	public ExecResults gestioneVisElimina(

			it.csi.sigit.sigitwebn.dto.elenco_impianti_graffati.CpElencoImpiantiGraffatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISELIMINA_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISELIMINA_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1280481669) ENABLED START*/
			if (GenericUtil.isNullOrEmpty(theModel.getAppDataelencoImpiantiGraffati()))
				result.setResultCode(GESTIONEVISELIMINA_OUTCOME_CODE__NASCONDI);
			else
				result.setResultCode(GESTIONEVISELIMINA_OUTCOME_CODE__VISUALIZZA);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneVisElimina] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneVisVisualizza definito in un ExecCommand del
	 * ContentPanel cpElencoImpiantiGraffati
	 */
	public ExecResults gestioneVisVisualizza(

			it.csi.sigit.sigitwebn.dto.elenco_impianti_graffati.CpElencoImpiantiGraffatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISVISUALIZZA_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISVISUALIZZA_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1351343658) ENABLED START*/
			if (GenericUtil.isNullOrEmpty(theModel.getAppDataelencoImpiantiGraffati()))
				result.setResultCode(GESTIONEVISVISUALIZZA_OUTCOME_CODE__NASCONDI);
			else
				result.setResultCode(GESTIONEVISVISUALIZZA_OUTCOME_CODE__VISUALIZZA);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneVisVisualizza] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recuperaStoricoStatoVariazioni definito in un ExecCommand del
	 * ContentPanel cpElencoImpiantiGraffati
	 */
	public ExecResults recuperaStoricoStatoVariazioni(

			it.csi.sigit.sigitwebn.dto.elenco_impianti_graffati.CpElencoImpiantiGraffatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECUPERASTORICOSTATOVARIAZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-327043549) ENABLED START*/
			Impianto imp = theModel.getAppDataimpiantoApprofondito();
			if (GenericUtil.isNotNullOrEmpty(imp)) {
				ArrayList<Storico> storico = getDbMgr()
						.getStoricoVariazioniStatoByCodiceImpianto(imp.getImpCodImpianto());
				theModel.setAppDataelencoStoricoVariazioniStatoImpianto(storico);
			}
			result.setResultCode(RECUPERASTORICOSTATOVARIAZIONI_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recuperaStoricoStatoVariazioni] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneMessaggio definito in un ExecCommand del
	 * ContentPanel cpElencoImpiantiGraffati
	 */
	public ExecResults gestioneMessaggio(

			it.csi.sigit.sigitwebn.dto.elenco_impianti_graffati.CpElencoImpiantiGraffatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEMESSAGGIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1052209101) ENABLED START*/
			Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);

			if (msg != null && msg.isInfoMessage()) {
				result.getGlobalMessages().add(msg.getText());
				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
			} else if (msg != null && msg.isErrorMessage()) {

				result.getGlobalErrors().add(msg.getText());
				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
			}

			// impostazione del result code
			result.setResultCode(GESTIONEMESSAGGIO_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneMessaggio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbElencoImpGraf
	 */
	public static void resetClearStatus_widg_tbElencoImpGraf(java.util.Map session) {
		session.put("cpElencoImpiantiGraffati_tbElencoImpGraf_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbStorico
	 */
	public static void resetClearStatus_widg_tbStorico(java.util.Map session) {
		session.put("cpElencoImpiantiGraffati_tbStorico_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1387781557) ENABLED START*/

	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	private ServiziMgr serviziMgr;

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	protected Map session;

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
