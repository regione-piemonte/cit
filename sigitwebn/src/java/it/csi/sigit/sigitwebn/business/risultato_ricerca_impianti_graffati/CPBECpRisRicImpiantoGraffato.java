package it.csi.sigit.sigitwebn.business.risultato_ricerca_impianti_graffati;

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

/*PROTECTED REGION ID(R521657833) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti_graffati.CpRisRicImpiantoGraffatoModel;
/*PROTECTED REGION END*/

public class CPBECpRisRicImpiantoGraffato {

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

	// ApplicationData: [impiantoApprofondito, scope:USER_SESSION]
	public static final String APPDATA_IMPIANTOAPPROFONDITO_CODE = "appDataimpiantoApprofondito";

	// ApplicationData: [elencoImpiantiGraffati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOIMPIANTIGRAFFATI_CODE = "appDataelencoImpiantiGraffati";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisRicImpiantoGraffato";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestInserisciImpiantoGraffato definito in un ExecCommand del
	 * ContentPanel cpRisRicImpiantoGraffato
	 */
	public ExecResults gestInserisciImpiantoGraffato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti_graffati.CpRisRicImpiantoGraffatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINSERISCIIMPIANTOGRAFFATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTINSERISCIIMPIANTOGRAFFATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R456342863) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			if (GenericUtil.isNotNullOrEmpty(theModel.getAppDataidImpiantoSelez())) {
				Impianto impiantoSelez = getDbMgr().cercaImpiantoById(theModel.getAppDataidImpiantoSelez());
				if (!theModel.getAppDataimpiantoApprofondito().getImpCodImpianto()
						.equals(impiantoSelez.getImpCodImpianto())) {
					getDbMgr().insertNewImpiantoGraffatura(theModel.getAppDataimpiantoApprofondito(), impiantoSelez,
							theModel.getAppDatautenteLoggato(), result, GESTINSERISCIIMPIANTOGRAFFATO_OUTCOME_CODE__OK,
							GESTINSERISCIIMPIANTOGRAFFATO_OUTCOME_CODE__KO);
					ArrayList<ElencoImpiantiGraffati> elencoImpiantiGraffatiList = getDbMgr()
							.getElencoImpiantiGraffatiByCodImpianto(
									theModel.getAppDataimpiantoApprofondito().getImpCodImpianto());
					theModel.setAppDataelencoImpiantiGraffati(elencoImpiantiGraffatiList);
				} else {
					result.getGlobalErrors().add("Non è possibile associare l'impianto a se stesso.");
					result.setResultCode(GESTINSERISCIIMPIANTOGRAFFATO_OUTCOME_CODE__KO);
				}
			} else {
				result.getGlobalErrors().add("Selezionare un impianto");
				result.setResultCode(GESTINSERISCIIMPIANTOGRAFFATO_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestInserisciImpiantoGraffato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpRisRicImpiantoGraffato
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti_graffati.CpRisRicImpiantoGraffatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1517115350) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoImpianti(utenteLoggato)) {
				result.setResultCode(ISRUOLOABILITATO_OUTCOME_CODE__OK);
			} else {
				GenericUtil.redirectToNotAllowedPage();
			}

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
	 * ContentPanel cpRisRicImpiantoGraffato
	 */
	public ExecResults gestioneAggElenco(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti_graffati.CpRisRicImpiantoGraffatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEAGGELENCO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTIONEAGGELENCO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1139602213) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				log.debug("gestioneAggElenco - START");

				if (theModel.getAppDataaggiornaElencoImpianti() != null
						&& theModel.getAppDataaggiornaElencoImpianti()) {

					ArrayList<RisultatoRicImpianto> risRicCodImpiantoList = null;

					risRicCodImpiantoList = getSigitMgr().ricercaElencoImpiantiWS(theModel.getAppDataricercaImpianti(),
							theModel.getAppDatautenteLoggato());

					theModel.setAppDatarisultatoRicercaImpianti(risRicCodImpiantoList);

					theModel.setAppDataaggiornaElencoImpianti(false);

					resetClearStatus_widg_tbRisultatoRicImp(theModel.getSession());
				}
				gestioneMsgRicerca(theModel, result);
				result.setResultCode(GESTIONEAGGELENCO_OUTCOME_CODE__OK);
				log.debug("gestioneAggElenco - END");
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			} catch (ServiceException ex) {
				result.getGlobalErrors().add(ex.getMessage());
				result.setResultCode(GESTIONEAGGELENCO_OUTCOME_CODE__KO);
			}
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
	 * Implementazione del metodo gestisciVisualizzaButton definito in un ExecCommand del
	 * ContentPanel cpRisRicImpiantoGraffato
	 */
	public ExecResults gestisciVisualizzaButton(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti_graffati.CpRisRicImpiantoGraffatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVISUALIZZABUTTON_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTISCIVISUALIZZABUTTON_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-858062535) ENABLED START*/
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatarisultatoRicercaImpianti()))
				result.setResultCode(GESTISCIVISUALIZZABUTTON_OUTCOME_CODE__NASCONDI);
			else
				result.setResultCode(GESTISCIVISUALIZZABUTTON_OUTCOME_CODE__VISUALIZZA);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciVisualizzaButton] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneMessaggio definito in un ExecCommand del
	 * ContentPanel cpRisRicImpiantoGraffato
	 */
	public ExecResults gestioneMessaggio(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti_graffati.CpRisRicImpiantoGraffatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEMESSAGGIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R710304723) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

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

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

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
	 * permette di resettare lo stato di paginazione della tabella widg_tbRisultatoRicImp
	 */
	public static void resetClearStatus_widg_tbRisultatoRicImp(java.util.Map session) {
		session.put("cpRisRicImpiantoGraffato_tbRisultatoRicImp_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-64296277) ENABLED START*/

	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	private void gestioneMsgRicerca(CpRisRicImpiantoGraffatoModel theModel, ExecResults result)
			throws DbManagerException {
		Integer maxNumRighe = getDbMgr().cercaConfigValueNumerico(Constants.MAX_RIGHE);
		log.debug("MAX num righe da visualizzare = " + maxNumRighe);
		ArrayList<RisultatoRicImpianto> risRicImpiantoList = theModel.getAppDatarisultatoRicercaImpianti();
		if (risRicImpiantoList != null && risRicImpiantoList.size() == maxNumRighe)
			result.getGlobalMessages()
					.add(Messages.MSG_RISULTATI_RICERCA.replaceFirst("##value##", maxNumRighe.toString()));
	}

	private IdentificativoImpianto getIdentificativoImpianto(CpRisRicImpiantoGraffatoModel theModel) {
		IdentificativoImpianto identificativo = new IdentificativoImpianto();

		String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

		ArrayList<RisultatoRicImpianto> risRicCodImpiantoList = theModel.getAppDatarisultatoRicercaImpianti();

		for (RisultatoRicImpianto risultatoRicImpianto : risRicCodImpiantoList) {

			if (risultatoRicImpianto.getCodiceImpianto().equals(idImpiantoSelez)) {

				identificativo.setCodiceImpianto(risultatoRicImpianto.getCodiceImpianto());
				identificativo.setUbicazione(risultatoRicImpianto.getDescIndirizzoCompleto());
				identificativo.setResponsabile(risultatoRicImpianto.getDenomResponsabile());

				theModel.setAppDataidentificativoImpianto(identificativo);
				break;
			}
		}

		return identificativo;

	}
	/*PROTECTED REGION END*/
}
