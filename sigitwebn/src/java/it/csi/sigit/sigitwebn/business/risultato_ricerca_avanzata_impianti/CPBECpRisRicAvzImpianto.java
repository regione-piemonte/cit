package it.csi.sigit.sigitwebn.business.risultato_ricerca_avanzata_impianti;

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

/*PROTECTED REGION ID(R-994813442) ENABLED START*/
import it.csi.sigit.sigitwebn.dto.risultato_ricerca_avanzata_impianti.CpRisRicAvzImpiantoModel;

import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.business.gestisci_verifica.CPBECpGestVerifica.TipoVerificaEnum;
/*PROTECTED REGION END*/

public class CPBECpRisRicAvzImpianto {

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

	// ApplicationData: [ricercaAvanzataImpianti, scope:USER_SESSION]
	public static final String APPDATA_RICERCAAVANZATAIMPIANTI_CODE = "appDataricercaAvanzataImpianti";

	// ApplicationData: [provenienza, scope:USER_SESSION]
	public static final String APPDATA_PROVENIENZA_CODE = "appDataprovenienza";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [paginaChiamanteDocumenti, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEDOCUMENTI_CODE = "appDatapaginaChiamanteDocumenti";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [idAllegatoImpiantoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALLEGATOIMPIANTOSELEZIONATO_CODE = "appDataidAllegatoImpiantoSelezionato";

	// ApplicationData: [verifica, scope:USER_SESSION]
	public static final String APPDATA_VERIFICA_CODE = "appDataverifica";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisRicAvzImpianto";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestRapportoControllo definito in un ExecCommand del
	 * ContentPanel cpRisRicAvzImpianto
	 */
	public ExecResults gestRapportoControllo(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_avanzata_impianti.CpRisRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTRAPPORTOCONTROLLO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTRAPPORTOCONTROLLO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-835031001) ENABLED START*/
			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idImpiantoSelez);
				theModel.setAppDatapaginaChiamanteImp(Constants.PAG_RIS_RIC_AVZ_IMPIANTI);
				theModel.setAppDataisAbilitazioneDatiAllegato(false);
				log.debug("idImpiantoSelezionato: " + idImpiantoSelez);
				result.setResultCode(GESTRAPPORTOCONTROLLO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestRapportoControllo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestModificaImpianto definito in un ExecCommand del
	 * ContentPanel cpRisRicAvzImpianto
	 */
	public ExecResults gestModificaImpianto(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_avanzata_impianti.CpRisRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTMODIFICAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R941804657) ENABLED START*/
			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idImpiantoSelez);

				Impianto impianto = getDbMgr().cercaImpiantoById(idImpiantoSelez);

				impianto.setLogicaVisual(GenericUtil.setLogicaVisualizzazione(impianto));

				//impianto.getLogicaVisual().setIsBotInsModLibrettoVisibile(true);
				impianto.getLogicaVisual().setIsImpiantoIndConfermato(true);
				//				impianto.getLogicaVisual().setCaso(Constants.COD_CASO_F);
				theModel.setAppDataprovenienza(Constants.PAG_RIS_RIC_AVZ_IMPIANTI);
				theModel.setAppDataimpianto(impianto);
				result.setResultCode(GESTMODIFICAIMPIANTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestModificaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestAvviaVerifica definito in un ExecCommand del
	 * ContentPanel cpRisRicAvzImpianto
	 */
	public ExecResults gestAvviaVerifica(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_avanzata_impianti.CpRisRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTAVVIAVERIFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTAVVIAVERIFICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R583746426) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idImpiantoSelez);
				theModel.setAppDatapaginaChiamante(Constants.PAG_RIS_RIC_AVZ_IMPIANTI);

				//theModel.setAppDataisAbilitazioneDatiAllegato(false);
				log.debug("risultato ricerca impianti  nel bottone gestAvviaVerifica --> idImpiantoSelezionato: "
						+ idImpiantoSelez);

				UtenteLoggato utente = theModel.getAppDatautenteLoggato();

				Verifica verifica = new Verifica();
				verifica.setTipoVerifica(TipoVerificaEnum.IMPIANTO.getIdDb());
				verifica.setCodiceImpianto(ReplaceSpecialCharUtils.sanitize(idImpiantoSelez));
				verifica.setIdAllegato(Constants.DATO_NON_DISPONIBILE_S);
				verifica.setIdDatoDistributore(Constants.DATO_NON_DISPONIBILE_S);
				verifica.setCfUtenteCaricamento(ReplaceSpecialCharUtils.sanitize(utente.getCodiceFiscale()));
				verifica.setDenomUtenteCaricamento(ReplaceSpecialCharUtils.sanitize(utente.getDenominazione()));
				verifica.setEseguitoDa(ReplaceSpecialCharUtils.sanitize(utente.getDenominazione()) 
						+ " (" + ReplaceSpecialCharUtils.sanitize(utente.getCodiceFiscale()) + ")");
				verifica.setDataCaricamento(DateUtil.getDataCorrenteFormat());

				IdentificativoImpianto getIdentificativoImpianto = getIdentificativoImpianto(theModel);

				String msgConferma = "Vuoi creare una verifica sull'IMPIANTO "
						+ getIdentificativoImpianto.getCodiceImpianto() + " "
						+ getIdentificativoImpianto.getUbicazione() + "?";

				theModel.setAppDatamessaggioDinamico(msgConferma);

				theModel.setAppDataverifica(verifica);

				// impostazione del result code 
				result.setResultCode(GESTAVVIAVERIFICA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAvviaVerifica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestIspezione definito in un ExecCommand del
	 * ContentPanel cpRisRicAvzImpianto
	 */
	public ExecResults gestIspezione(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_avanzata_impianti.CpRisRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1713011522) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idImpiantoSelez);
				theModel.setAppDatapaginaChiamanteImp(Constants.PAG_RIS_RIC_AVZ_IMPIANTI);
				//theModel.setAppDataisAbilitazioneDatiAllegato(false);
				log.debug("risultato ricerca impianti  nel bottone gestIspezione --> idImpiantoSelezionato: "
						+ idImpiantoSelez);

				// impostazione del result code 
				result.setResultCode(GESTISPEZIONE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestIspezione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestDocumentazione definito in un ExecCommand del
	 * ContentPanel cpRisRicAvzImpianto
	 */
	public ExecResults gestDocumentazione(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_avanzata_impianti.CpRisRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTDOCUMENTAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTDOCUMENTAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1057609939) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idImpiantoSelez);

				theModel.setAppDataidentificativoImpianto(getIdentificativoImpianto(theModel));

				theModel.setAppDatapaginaChiamanteDocumenti(Constants.PAG_RIS_RIC_AVZ_IMPIANTI);

				// impostazione del result code 
				result.setResultCode(GESTDOCUMENTAZIONE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestDocumentazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLibrettoWeb definito in un ExecCommand del
	 * ContentPanel cpRisRicAvzImpianto
	 */
	public ExecResults gestLibrettoWeb(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_avanzata_impianti.CpRisRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLIBRETTOWEB_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTLIBRETTOWEB_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-662334947) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idImpiantoSelez);

				theModel.setAppDataidentificativoImpianto(getIdentificativoImpianto(theModel));

				theModel.setAppDatapaginaChiamante(Constants.PAG_RIS_RIC_AVZ_IMPIANTI);

				// impostazione del result code 
				result.setResultCode(GESTLIBRETTOWEB_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLibrettoWeb] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisualizzaImpianto definito in un ExecCommand del
	 * ContentPanel cpRisRicAvzImpianto
	 */
	public ExecResults gestVisualizzaImpianto(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_avanzata_impianti.CpRisRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISUALIZZAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTVISUALIZZAIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1464672545) ENABLED START*/
			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idImpiantoSelez);

				Impianto impianto = getDbMgr().cercaImpiantoById(idImpiantoSelez);

				LogicaVisualizzazione logica = new LogicaVisualizzazione();
				logica.setCaso(Constants.COD_CASO_F);
				logica.setIsImpiantoIndConfermato(true);

				impianto.setLogicaVisual(logica);
				theModel.setAppDataimpianto(impianto);
				result.setResultCode(GESTVISUALIZZAIMPIANTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisualizzaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpRisRicAvzImpianto
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_avanzata_impianti.CpRisRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1125785739) ENABLED START*/
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
	 * Implementazione del metodo gestioneAggElenco definito in un ExecCommand del
	 * ContentPanel cpRisRicAvzImpianto
	 */
	public ExecResults gestioneAggElenco(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_avanzata_impianti.CpRisRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEAGGELENCO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTIONEAGGELENCO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R385918266) ENABLED START*/
			try {
				if (theModel.getAppDataaggiornaElencoImpianti() != null
						&& theModel.getAppDataaggiornaElencoImpianti()) {
					ArrayList<RisultatoRicImpianto> risRicImpiantoList = getSigitMgr()
							.ricercaAvanzataImpianti(theModel.getAppDataricercaAvanzataImpianti());
					theModel.setAppDatarisultatoRicercaImpianti(risRicImpiantoList);
					theModel.setAppDataaggiornaElencoImpianti(false);
				}
				Integer maxNumRighe = getDbMgr().cercaConfigValueNumerico(Constants.MAX_RIGHE_RIC_AVANZATA_IMPIANTI);
				log.debug("MAX num righe da visualizzare = " + maxNumRighe);
				ArrayList<RisultatoRicImpianto> risRicImpiantoList = theModel.getAppDatarisultatoRicercaImpianti();
				if (risRicImpiantoList != null && risRicImpiantoList.size() == maxNumRighe)
					result.getGlobalMessages()
							.add(Messages.MSG_RISULTATI_RICERCA.replaceFirst("##value##", maxNumRighe.toString()));
				resetClearStatus_widg_tbRisultatoRicImp(theModel.getSession());
				result.setResultCode(GESTIONEAGGELENCO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}
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
	 * Implementazione del metodo gestioneVisBottoniInit definito in un ExecCommand del
	 * ContentPanel cpRisRicAvzImpianto
	 */
	public ExecResults gestioneVisBottoniInit(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_avanzata_impianti.CpRisRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONIINIT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONIINIT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1433165068) ENABLED START*/

			ArrayList<RisultatoRicImpianto> risRicImpiantoList = theModel.getAppDatarisultatoRicercaImpianti();

			if (risRicImpiantoList != null && risRicImpiantoList.size() > 0) {
				result.setResultCode(GESTIONEVISBOTTONIINIT_OUTCOME_CODE__VISUALIZZA);
			} else {
				result.setResultCode(GESTIONEVISBOTTONIINIT_OUTCOME_CODE__NASCONDI);
			}

			result.setModel(theModel);

			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneVisBottoniInit] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnRapportiImpianto definito in un ExecCommand del
	 * ContentPanel cpRisRicAvzImpianto
	 */
	public ExecResults isVisualizzaBtnRapportiImpianto(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_avanzata_impianti.CpRisRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNRAPPORTIIMPIANTO_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNRAPPORTIIMPIANTO_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1061995371) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ISVISUALIZZABTNRAPPORTIIMPIANTO_OUTCOME_CODE__VISUALIZZA);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnRapportiImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnModificaImpianto definito in un ExecCommand del
	 * ContentPanel cpRisRicAvzImpianto
	 */
	public ExecResults isVisualizzaBtnModificaImpianto(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_avanzata_impianti.CpRisRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNMODIFICAIMPIANTO_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNMODIFICAIMPIANTO_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1576824884) ENABLED START*/
			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();
			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_IMPRESA)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)) {
				result.setResultCode(ISVISUALIZZABTNMODIFICAIMPIANTO_OUTCOME_CODE__VISUALIZZA);
			} else {
				result.setResultCode(ISVISUALIZZABTNMODIFICAIMPIANTO_OUTCOME_CODE__NASCONDI);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnModificaImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnIspezioniImpianto definito in un ExecCommand del
	 * ContentPanel cpRisRicAvzImpianto
	 */
	public ExecResults isVisualizzaBtnIspezioniImpianto(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_avanzata_impianti.CpRisRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNISPEZIONIIMPIANTO_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNISPEZIONIIMPIANTO_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R415079510) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();
			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_ISPETTORE)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_CONSULTATORE)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNISPEZIONIIMPIANTO_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNISPEZIONIIMPIANTO_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::isVisualizzaBtnIspezioniImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneMessaggio definito in un ExecCommand del
	 * ContentPanel cpRisRicAvzImpianto
	 */
	public ExecResults gestioneMessaggio(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_avanzata_impianti.CpRisRicAvzImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEMESSAGGIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-43379224) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

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
		session.put("cpRisRicAvzImpianto_tbRisultatoRicImp_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-55115024) ENABLED START*/
	private SigitMgr sigitMgr;
	private ValidationMgr validationMgr;
	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

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

	private IdentificativoImpianto getIdentificativoImpianto(CpRisRicAvzImpiantoModel theModel) {
		IdentificativoImpianto identificativo = new IdentificativoImpianto();

		String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

		ArrayList<RisultatoRicImpianto> risRicCodImpiantoList = theModel.getAppDatarisultatoRicercaImpianti();

		for (RisultatoRicImpianto risultatoRicImpianto : risRicCodImpiantoList) {

			if (risultatoRicImpianto.getCodiceImpianto().equals(idImpiantoSelez)) {

				identificativo.setCodiceImpianto(risultatoRicImpianto.getCodiceImpianto());
				identificativo.setUbicazione(risultatoRicImpianto.getDescIndirizzoCompleto());
				identificativo.setResponsabile(risultatoRicImpianto.getDenomResponsabile());

				break;
			}
		}

		return identificativo;

	}

	/*PROTECTED REGION END*/
}
