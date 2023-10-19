package it.csi.sigit.sigitwebn.business.ricerca_avanz_impianti;

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

/*PROTECTED REGION ID(R-497249146) ENABLED START*/
import it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;

/*PROTECTED REGION END*/

public class CPBECpRicAvzImpianto {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [risultatoRicercaImpianti, scope:USER_SESSION]
	public static final String APPDATA_RISULTATORICERCAIMPIANTI_CODE = "appDatarisultatoRicercaImpianti";

	// ApplicationData: [aggiornaElencoImpianti, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOIMPIANTI_CODE = "appDataaggiornaElencoImpianti";

	// ApplicationData: [elencoProvincePiemonte, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCEPIEMONTE_CODE = "appDataelencoProvincePiemonte";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [ricercaAvanzataImpianti, scope:USER_SESSION]
	public static final String APPDATA_RICERCAAVANZATAIMPIANTI_CODE = "appDataricercaAvanzataImpianti";

	// ApplicationData: [elencoTipoComponenti, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOCOMPONENTI_CODE = "appDataelencoTipoComponenti";

	// ApplicationData: [elencoCombustibili, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMBUSTIBILI_CODE = "appDataelencoCombustibili";

	// ApplicationData: [elencoMarche, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMARCHE_CODE = "appDataelencoMarche";

	// ApplicationData: [elencoTipoRapporto, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPORAPPORTO_CODE = "appDataelencoTipoRapporto";

	// ApplicationData: [elencoSigleBollino, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLEBOLLINO_CODE = "appDataelencoSigleBollino";

	// ApplicationData: [elencoStatoImpianto, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATOIMPIANTO_CODE = "appDataelencoStatoImpianto";

	// ApplicationData: [elencoCat, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCAT_CODE = "appDataelencoCat";

	// ApplicationData: [elencoTipiDocumentazione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPIDOCUMENTAZIONE_CODE = "appDataelencoTipiDocumentazione";

	// ApplicationData: [elencoSiNo, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSINO_CODE = "appDataelencoSiNo";

	// ApplicationData: [elencoTipoImpianto, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOIMPIANTO_CODE = "appDataelencoTipoImpianto";

	// ApplicationData: [elencoUnitMisuraNox, scope:USER_SESSION]
	public static final String APPDATA_ELENCOUNITMISURANOX_CODE = "appDataelencoUnitMisuraNox";

	// ApplicationData: [linkMappaWms, scope:USER_SESSION]
	public static final String APPDATA_LINKMAPPAWMS_CODE = "appDatalinkMappaWms";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicAvzImpianto";

	public static final String TABSET_TSRICAVZ = "tsRicAvz";
	public static final String TAB_TSRICAVZ_FPTABRICAVZ = CPNAME + "_" + TABSET_TSRICAVZ + "_" + "fpTabRicAvz";
	public static final String TAB_TSRICAVZ_FPRICAVZALL = CPNAME + "_" + TABSET_TSRICAVZ + "_" + "fpRicAvzAll";
	public static final String TAB_TSRICAVZ_FPRICAVZ3RESP = CPNAME + "_" + TABSET_TSRICAVZ + "_" + "fpRicAvz3Resp";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadComuniComp definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults loadComuniComp(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNICOMP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1655227087) ENABLED START*/

			loadComuni(theModel);
			result.setResultCode(LOADCOMUNICOMP_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadComuniComp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cambioTab definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults cambioTab(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CAMBIOTAB_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-991090745) ENABLED START*/

			pulisciCampi(theModel);
			result.setResultCode(CAMBIOTAB_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cambioTab] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cambioTipoComponente definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults cambioTipoComponente(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CAMBIOTIPOCOMPONENTE_OUTCOME_CODE__CON_POTENZA = //NOSONAR  Reason:EIAS
				"CON_POTENZA"; //NOSONAR  Reason:EIAS
		final String CAMBIOTIPOCOMPONENTE_OUTCOME_CODE__SENZA_POTENZA = //NOSONAR  Reason:EIAS
				"SENZA_POTENZA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1435635072) ENABLED START*/

			//			GT, GF, SC, CG,CS,AG
			String tipoComponente = theModel.getAppDataricercaAvanzataImpianti().getTipoComponente();
			if (Constants.TIPO_COMPONENTE_AG.equals(tipoComponente)
					|| Constants.TIPO_COMPONENTE_GT.equals(tipoComponente)
					|| Constants.TIPO_COMPONENTE_GF.equals(tipoComponente)
					|| Constants.TIPO_COMPONENTE_SC.equals(tipoComponente)
					|| Constants.TIPO_COMPONENTE_CG.equals(tipoComponente)
					|| Constants.TIPO_COMPONENTE_CS.equals(tipoComponente))
				result.setResultCode(CAMBIOTIPOCOMPONENTE_OUTCOME_CODE__CON_POTENZA);
			else
				result.setResultCode(CAMBIOTIPOCOMPONENTE_OUTCOME_CODE__SENZA_POTENZA);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cambioTipoComponente] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaImpiantoComp definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults ricercaImpiantoComp(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAIMPIANTOCOMP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAIMPIANTOCOMP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1170369480) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				log.debug("validazione ricerca avanzata");
				getValidationMgr()
						.validazioneFormaleRicercaAvanzataImpianto(theModel.getAppDataricercaAvanzataImpianti());
				theModel.setAppDataaggiornaElencoImpianti(true);
				result.setResultCode(RICERCAIMPIANTOCOMP_OUTCOME_CODE__OK);
			} catch (ValidationManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaImpiantoComp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo pulisciCampiComp definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults pulisciCampiComp(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PULISCICAMPICOMP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1384217323) ENABLED START*/

			pulisciCampi(theModel);
			result.setResultCode(PULISCICAMPICOMP_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::pulisciCampiComp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciVerificaAssociata definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults gestisciVerificaAssociata(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVERIFICAASSOCIATA_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTISCIVERIFICAASSOCIATA_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-166672385) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			RicercaAvanzataImpianti ric = theModel.getAppDataricercaAvanzataImpianti();
			String tipoRapp = ric.getTipoRapporto();

			if (Constants.ALLEGATO_TIPO_1.equals(tipoRapp) || Constants.ALLEGATO_TIPO_1B.equals(tipoRapp)
					|| Constants.ALLEGATO_TIPO_2.equals(tipoRapp) || Constants.ALLEGATO_TIPO_3.equals(tipoRapp)
					|| Constants.ALLEGATO_TIPO_4.equals(tipoRapp)) {

				log.debug("DEVO VISUALIZZARE!!!");
				// impostazione del result code 
				result.setResultCode(GESTISCIVERIFICAASSOCIATA_OUTCOME_CODE__VISUALIZZA);
			} else {

				ric.setFlgVerificaAssociata(null);

				// impostazione del result code 
				result.setResultCode(GESTISCIVERIFICAASSOCIATA_OUTCOME_CODE__NASCONDI);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciVerificaAssociata] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciNox definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults gestisciNox(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCINOX_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTISCINOX_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-702233989) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			RicercaAvanzataImpianti ric = theModel.getAppDataricercaAvanzataImpianti();
			String tipoRapp = ric.getTipoRapporto();

			log.debug("gestisciNox - tipoRapp: " + tipoRapp);

			if (Constants.ALLEGATO_TIPO_1.equals(tipoRapp) || Constants.ALLEGATO_TIPO_1B.equals(tipoRapp)
					|| Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(tipoRapp)) {

				log.debug("DEVO VISUALIZZARE!!!");
				// impostazione del result code 
				result.setResultCode(GESTISCINOX_OUTCOME_CODE__VISUALIZZA);
			} else {

				ric.setIdTipoUnitaMisura(null);
				ric.setNoxDa(null);
				ric.setNoxA(null);

				theModel.setAppDataricercaAvanzataImpianti(ric);

				log.debug("NON DEVO VISUALIZZARE!!!");

				// impostazione del result code 
				result.setResultCode(GESTISCINOX_OUTCOME_CODE__NASCONDI);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciNox] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciUMisuraNox definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults gestisciUMisuraNox(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIUMISURANOX_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTISCIUMISURANOX_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1631021585) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			RicercaAvanzataImpianti ric = theModel.getAppDataricercaAvanzataImpianti();
			String tipoRapp = ric.getTipoRapporto();

			if (Constants.ALLEGATO_TIPO_1.equals(tipoRapp) || Constants.ALLEGATO_TIPO_1B.equals(tipoRapp)) {
				// impostazione del result code 
				result.setResultCode(GESTISCIUMISURANOX_OUTCOME_CODE__VISUALIZZA);
			} else {

				ric.setIdTipoUnitaMisura(null);

				theModel.setAppDataricercaAvanzataImpianti(ric);

				// impostazione del result code 
				result.setResultCode(GESTISCIUMISURANOX_OUTCOME_CODE__NASCONDI);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciUMisuraNox] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaImpiantoAll definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults ricercaImpiantoAll(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAIMPIANTOALL_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAIMPIANTOALL_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R697282384) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				log.debug("validazione ricerca avanzata");
				getValidationMgr()
						.validazioneFormaleRicercaAvanzataImpianto(theModel.getAppDataricercaAvanzataImpianti());
				theModel.setAppDataaggiornaElencoImpianti(true);
				result.setResultCode(RICERCAIMPIANTOALL_OUTCOME_CODE__OK);
			} catch (ValidationManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaImpiantoAll] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo pulisciCampiAll definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults pulisciCampiAll(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PULISCICAMPIALL_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1244573395) ENABLED START*/

			pulisciCampi(theModel);
			result.setResultCode(PULISCICAMPIALL_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::pulisciCampiAll] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaImpiantoResp definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults ricercaImpiantoResp(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAIMPIANTORESP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAIMPIANTORESP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1730562025) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				log.debug("validazione ricerca avanzata");
				getValidationMgr()
						.validazioneFormaleRicercaAvanzataImpianto(theModel.getAppDataricercaAvanzataImpianti());
				theModel.setAppDataaggiornaElencoImpianti(true);
				result.setResultCode(RICERCAIMPIANTORESP_OUTCOME_CODE__OK);
			} catch (ValidationManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaImpiantoResp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo pulisciCampiResp definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults pulisciCampiResp(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PULISCICAMPIRESP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1944409868) ENABLED START*/

			pulisciCampi(theModel);
			result.setResultCode(PULISCICAMPIRESP_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::pulisciCampiResp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initRicercaImpianto definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults initRicercaImpianto(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITRICERCAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R787965239) ENABLED START*/
			caricamentoInizialeCombo(theModel);
			theModel.setAppDatalinkMappaWms(
					getDbMgr().cercaConfigValue(Constants.CHIAVE_CONFIG_MAPPA_WMS).getValoreConfigChar());
			result.setResultCode(INITRICERCAIMPIANTO_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initRicercaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2080392173) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoRicercaImpiantiAvanzata(utente)) {
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
	 * Implementazione del metodo gestioneOnEnter definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults gestioneOnEnter(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEONENTER_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-794263002) ENABLED START*/

			pulisciCampi(theModel);
			result.setResultCode(GESTIONEONENTER_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneOnEnter] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIstatAbilitazione definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults gestisciIstatAbilitazione(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIISTATABILITAZIONE_OUTCOME_CODE__RUOLO_PROVINCIA = //NOSONAR  Reason:EIAS
				"RUOLO_PROVINCIA"; //NOSONAR  Reason:EIAS
		final String GESTISCIISTATABILITAZIONE_OUTCOME_CODE__RUOLO_COMUNE = //NOSONAR  Reason:EIAS
				"RUOLO_COMUNE"; //NOSONAR  Reason:EIAS
		final String GESTISCIISTATABILITAZIONE_OUTCOME_CODE__RUOLO_ALTRO = //NOSONAR  Reason:EIAS
				"RUOLO_ALTRO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R855086032) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utenteLog = theModel.getAppDatautenteLoggato();

			String istatAbilitazione = utenteLog.getRuolo().getIstatAbilitazione();

			RicercaAvanzataImpianti ricAvazImp = theModel.getAppDataricercaAvanzataImpianti();

			if (ricAvazImp == null) {
				ricAvazImp = new RicercaAvanzataImpianti();
			}

			theModel.setAppDataelencoComuni(new ArrayList<>());

			if (istatAbilitazione.length() > 2) {
				ArrayList<CodeDescription> comuni = getSigitMgr().impostaProvinciaSuRicercaImpianti(ricAvazImp,
						istatAbilitazione);
				theModel.setAppDataelencoComuni(comuni);

				result.setResultCode(GESTISCIISTATABILITAZIONE_OUTCOME_CODE__RUOLO_PROVINCIA);
			} else {
				result.setResultCode(GESTISCIISTATABILITAZIONE_OUTCOME_CODE__RUOLO_ALTRO);
			}

			if (istatAbilitazione.length() > 5) {
				getSigitMgr().impostaComuneSuRicercaImpianti(theModel.getAppDataelencoComuni(), ricAvazImp,
						istatAbilitazione);

				result.setResultCode(GESTISCIISTATABILITAZIONE_OUTCOME_CODE__RUOLO_COMUNE);
			}

			theModel.setAppDataricercaAvanzataImpianti(ricAvazImp);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciIstatAbilitazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboGeo definito in un ExecCommand del
	 * ContentPanel cpRicAvzImpianto
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOGEO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2033596771) ENABLED START*/
			result.setResultCode(GESTISCICOMBOGEO_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboGeo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1384884754) ENABLED START*/

	private SigitMgr sigitMgr;
	private ServiziMgr serviziMgr;
	private ValidationMgr validationMgr;
	private DbMgr dbMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	private void pulisciCampi(CpRicAvzImpiantoModel theModel) {

		RicercaAvanzataImpianti ric = theModel.getAppDataricercaAvanzataImpianti();

		UtenteLoggato utenteLog = theModel.getAppDatautenteLoggato();

		String istatAbilitazione = utenteLog.getRuolo().getIstatAbilitazione();

		if (ric != null) {
			ric.setCodiceImpianto(null);

			if (istatAbilitazione.length() < 8) {
				ric.setIdComune(null);
				ric.setDescComune(null);
			}

			if (istatAbilitazione.length() < 5) {
				ric.setIdProvincia(null);
				theModel.setAppDataelencoComuni(new ArrayList<CodeDescription>());
			}

			ric.setIndirizzo(null);
			ric.setCfResponsabile(null);
			ric.setIdSiglaRea(null);
			ric.setNumeroRea(null);
			ric.setCfImpresa(null);
			ric.setStatoImpianto(null);

			ric.setSezione(null);
			ric.setFoglio(null);
			ric.setParticella(null);
			ric.setSubalterno(null);
			ric.setPod(null);
			ric.setPdr(null);

			ric.setSenzaPdr(null);

			ric.setPotenzaAcsA(null);
			ric.setPotenzaAcsDa(null);
			ric.setPotenzaClimaEstDa(null);
			ric.setPotenzaClimaEstA(null);
			ric.setPotenzaClimaInvDa(null);
			ric.setPotenzaClimaInvA(null);

			//dati componente
			ric.setMarca(null);
			ric.setTipoComponente(null);
			ric.setFlgDismesse(null);
			ric.setCombustibile(null);
			ric.setRendimentoPercDa(null);
			ric.setRendimentoPercA(null);
			ric.setPotenzaTermicaA(null);
			ric.setPotenzaTermicaDa(null);
			ric.setDataInstallazioneA(null);
			ric.setDataInstallazioneDa(null);

			//altro
			ric.setSicurezzaImpianti(null);
			ric.setConOsservazioni(null);
			ric.setConPrescrizioni(null);
			ric.setConRaccomandazioni(null);
			ric.setFlgVerificaAssociata(null);

			//dati allegato
			ric.setDataControlloA(null);
			ric.setDataControlloDa(null);
			ric.setTipoRapporto(null);
			ric.setInterventoManutentivoDa(null);
			ric.setInterventoManutentivoA(null);
			ric.setSiglaBollino(null);
			ric.setNumeroBollino(null);

			ric.setIdTipoUnitaMisura(null);
			ric.setNoxDa(null);
			ric.setNoxA(null);

			//dati terzo responsabile 
			ric.setCf3Responsabile(null);
			ric.setGgInserimentoContratto(null);
			ric.setGgRevoca(null);
			ric.setDataInizioContrattoDa(null);
			ric.setDataInizioContrattoA(null);
			ric.setDataFineContrattoDa(null);
			ric.setDataFineContrattoA(null);
		}
	}

	private void loadComuni(CpRicAvzImpiantoModel theModel) throws ServiceException {
		RicercaImpianti imp = theModel.getAppDataricercaAvanzataImpianti();
		ArrayList<CodeDescription> comuni = new ArrayList<CodeDescription>();

		if (imp != null) {
			String idProvSel = imp.getIdProvincia();

			log.debug("STAMPO idProvSel: " + idProvSel);

			if (GenericUtil.isNotNullOrEmpty(idProvSel)) {
				comuni = (ArrayList<CodeDescription>) getServiziMgr().getListaComuniByIstatProvincia(idProvSel);
			}
		}
		theModel.setAppDataelencoComuni(comuni);
	}

	private void caricamentoInizialeCombo(CpRicAvzImpiantoModel theModel) {

		theModel.setAppDataelencoComuni(new ArrayList<CodeDescription>());
		theModel.setAppDataelencoCombustibili(getSigitMgr().getListCombustibile());
		theModel.setAppDataelencoMarche(getSigitMgr().getListMarche());
		theModel.setAppDataelencoTipoComponenti(getSigitMgr().getListTipoComponente());
		theModel.setAppDataelencoTipoRapporto(getSigitMgr().getTipiRapportiControllo());

		theModel.setAppDataelencoSiNo(GenericUtil.getComboSiNo());
		theModel.setAppDataelencoUnitMisuraNox(GenericUtil.getComboUnitaMisuraNox());

		theModel.setAppDataelencoTipoImpianto(GenericUtil.getComboTipoImpianto());

		try {
			theModel.setAppDataelencoTipiDocumentazione(getSigitMgr().cercaElencoTipiDocumentazione());
		} catch (ManagerException e) {
			log.error("Errore durante il recupero tipo documentazione");
			theModel.setAppDataelencoTipiDocumentazione(new ArrayList<CodeDescription>());
		}

		try {
			theModel.setAppDataelencoCat(getSigitMgr().cercaElencoCat());
		} catch (ManagerException e) {
			log.error("Errore durante il recupero dei CAT");
			theModel.setAppDataelencoCat(new ArrayList<CodeDescription>());
		}

		try {
			theModel.setAppDataelencoSigleBollino(getServiziMgr().getListaSiglaProvincePiemonteManipolata());
		} catch (ServiceException e) {
			log.error("Errore durante il recupero delle sigle bollino");
			theModel.setAppDataelencoSigleBollino(new ArrayList<CodeDescription>());
		}

		ArrayList<CodeDescription> elencoStatiImpianto = theModel.getAppDataelencoStatoImpianto();
		if (elencoStatiImpianto == null) {
			try {
				elencoStatiImpianto = getDbMgr().cercaListaStatiImpianto();
				theModel.setAppDataelencoStatoImpianto(elencoStatiImpianto);
			} catch (DbManagerException e) {
				log.error("Errore durante il recupero dello stato impianto");
				theModel.setAppDataelencoStatoImpianto(new ArrayList<CodeDescription>());
			}
		}
	}
	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	/*PROTECTED REGION END*/
}
