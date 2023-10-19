package it.csi.sigit.sigitwebn.business.gestisci_libretto_scheda4_2;

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

/*PROTECTED REGION ID(R795245388) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
/*PROTECTED REGION END*/

public class CPBECpGestLibScheda4_2Dett {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [componenteBRRC, scope:USER_SESSION]
	public static final String APPDATA_COMPONENTEBRRC_CODE = "appDatacomponenteBRRC";

	// ApplicationData: [elencoFabbricante, scope:USER_SESSION]
	public static final String APPDATA_ELENCOFABBRICANTE_CODE = "appDataelencoFabbricante";

	// ApplicationData: [librettoMenuTree, scope:USER_SESSION]
	public static final String APPDATA_LIBRETTOMENUTREE_CODE = "appDatalibrettoMenuTree";

	// ApplicationData: [isNuovoComponente, scope:USER_SESSION]
	public static final String APPDATA_ISNUOVOCOMPONENTE_CODE = "appDataisNuovoComponente";

	// ApplicationData: [elencoComponentiGT, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMPONENTIGT_CODE = "appDataelencoComponentiGT";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [elencoTipoCombustibili, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOCOMBUSTIBILI_CODE = "appDataelencoTipoCombustibili";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [rigaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_RIGASELEZIONATA_CODE = "appDatarigaSelezionata";

	// ApplicationData: [listaStoricoComponentiBRRC, scope:USER_SESSION]
	public static final String APPDATA_LISTASTORICOCOMPONENTIBRRC_CODE = "appDatalistaStoricoComponentiBRRC";

	// ApplicationData: [listaComponentiBRRC, scope:USER_SESSION]
	public static final String APPDATA_LISTACOMPONENTIBRRC_CODE = "appDatalistaComponentiBRRC";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestLibScheda4_2Dett";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onTreeClick definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4_2Dett
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONTREECLICK_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA1_EXTRA = //NOSONAR  Reason:EIAS
				"SCHEDA1_EXTRA"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA1 = //NOSONAR  Reason:EIAS
				"SCHEDA1"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA2 = //NOSONAR  Reason:EIAS
				"SCHEDA2"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA3 = //NOSONAR  Reason:EIAS
				"SCHEDA3"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_1 = //NOSONAR  Reason:EIAS
				"SCHEDA4_1"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_2 = //NOSONAR  Reason:EIAS
				"SCHEDA4_2"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_3 = //NOSONAR  Reason:EIAS
				"SCHEDA4_3"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_4 = //NOSONAR  Reason:EIAS
				"SCHEDA4_4"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_5 = //NOSONAR  Reason:EIAS
				"SCHEDA4_5"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_6 = //NOSONAR  Reason:EIAS
				"SCHEDA4_6"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_7 = //NOSONAR  Reason:EIAS
				"SCHEDA4_7"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_8 = //NOSONAR  Reason:EIAS
				"SCHEDA4_8"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA5_1SR = //NOSONAR  Reason:EIAS
				"SCHEDA5_1SR"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA5_1VR = //NOSONAR  Reason:EIAS
				"SCHEDA5_1VR"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA5_2 = //NOSONAR  Reason:EIAS
				"SCHEDA5_2"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA6_4 = //NOSONAR  Reason:EIAS
				"SCHEDA6_4"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA6 = //NOSONAR  Reason:EIAS
				"SCHEDA6"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA7 = //NOSONAR  Reason:EIAS
				"SCHEDA7"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA8 = //NOSONAR  Reason:EIAS
				"SCHEDA8"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_1 = //NOSONAR  Reason:EIAS
				"SCHEDA9_1"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_2 = //NOSONAR  Reason:EIAS
				"SCHEDA9_2"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_3 = //NOSONAR  Reason:EIAS
				"SCHEDA9_3"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_4 = //NOSONAR  Reason:EIAS
				"SCHEDA9_4"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_5 = //NOSONAR  Reason:EIAS
				"SCHEDA9_5"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_6 = //NOSONAR  Reason:EIAS
				"SCHEDA9_6"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA10 = //NOSONAR  Reason:EIAS
				"SCHEDA10"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA12 = //NOSONAR  Reason:EIAS
				"SCHEDA12"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA13 = //NOSONAR  Reason:EIAS
				"SCHEDA13"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA14_1 = //NOSONAR  Reason:EIAS
				"SCHEDA14_1"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA14_2 = //NOSONAR  Reason:EIAS
				"SCHEDA14_2"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA14_3 = //NOSONAR  Reason:EIAS
				"SCHEDA14_3"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA14_4 = //NOSONAR  Reason:EIAS
				"SCHEDA14_4"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA15 = //NOSONAR  Reason:EIAS
				"SCHEDA15"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R535453502) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			result.setResultCode(
					GenericUtil.gestisciTreeClick(theModel.getIdNodo(), theModel.getAppDatalibrettoMenuTree()));

			// Setto la pagina in cui sto andando, mi servirà nel caso ci sia necessità di ricaricare la pagina con un messaggio (es. consolida libretto)
			theModel.getSession().put(Constants.SESSIONE_VAR_LIBRETTO_SCHEDA, result.getResultCode());

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onTreeClick] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo sostituisciComponente definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4_2Dett
	 */
	public ExecResults sostituisciComponente(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SOSTITUISCICOMPONENTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SOSTITUISCICOMPONENTE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1047721116) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ComponenteBRRC componente = theModel.getAppDatacomponenteBRRC();
			componente.setFabbricanteLabel(GenericUtil.getDescriptionByCod(
					ReplaceSpecialCharUtils.sanitize(componente.getFabbricante()),
					theModel.getAppDataelencoFabbricante()));
			List<ComponenteBRRC> compList = theModel.getAppDatalistaStoricoComponentiBRRC();
			try {

				getValidationMgr().validazioneFormaleLibrettoScheda4_2_4_3Dett(componente,
						(ArrayList<ComponenteBRRC>) compList, true, Constants.TIPO_COMPONENTE_BR, result);

				//per la sostituzione va aggiunta la componente in primoPiano tra quelle dello storico
				//creata una nuova componente da settare come componente in primo piano
				if (compList == null) {
					compList = new ArrayList<ComponenteBRRC>();
				}
				componente.setFlgDismesso(true);
				compList.add(0, componente);
				theModel.setAppDatalistaStoricoComponentiBRRC((ArrayList<ComponenteBRRC>) compList);

				//nuova Componente in primo Piano
				ComponenteBRRC componenteNew = new ComponenteBRRC();
				componenteNew.setComponente(ReplaceSpecialCharUtils.sanitize(componente.getComponente()));
				componenteNew.setFlgDismesso(false);

				theModel.setAppDatacomponenteBRRC(componenteNew);

				settaRiattivaSostituiti(true, theModel);

				// impostazione del result code 
				result.setResultCode(SOSTITUISCICOMPONENTE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::sostituisciComponente] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo dismettiComponente definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4_2Dett
	 */
	public ExecResults dismettiComponente(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DISMETTICOMPONENTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String DISMETTICOMPONENTE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-933792988) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				ComponenteBRRC componente = theModel.getAppDatacomponenteBRRC();
				List<ComponenteBRRC> compList = theModel.getAppDatalistaStoricoComponentiBRRC();

				//VALIDAZIONE
				getValidationMgr().validazioneFormaleLibrettoScheda4_2_4_3Dett(componente,
						(ArrayList<ComponenteBRRC>) compList, true, Constants.TIPO_COMPONENTE_BR, result);

				componente.setFlgDismesso(true);

				theModel.setAppDatacomponenteBRRC(componente);

				// devo togliere il Riattiva dai sostituiti
				settaRiattivaSostituiti(false, theModel);

				result.setResultCode(DISMETTICOMPONENTE_OUTCOME_CODE__OK);
			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::dismettiComponente] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo riattivaComponente definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4_2Dett
	 */
	public ExecResults riattivaComponente(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RIATTIVACOMPONENTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RIATTIVACOMPONENTE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2033532477) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ComponenteBRRC componente = theModel.getAppDatacomponenteBRRC();
			componente.setDataDismissione(null);
			componente.setFlgDismesso(false);

			settaRiattivaSostituiti(true, theModel);

			// impostazione del result code 
			result.setResultCode(RIATTIVACOMPONENTE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::riattivaComponente] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo riattivaComponenteSostituita definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4_2Dett
	 */
	public ExecResults riattivaComponenteSostituita(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RIATTIVACOMPONENTESOSTITUITA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RIATTIVACOMPONENTESOSTITUITA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1262501164) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			List<ComponenteBRRC> compList = theModel.getAppDatalistaStoricoComponentiBRRC();

			//prende la componente piu' recente tra i sostituiti
			ComponenteBRRC componenteNew = compList.get(0);

			//ripristino la componente appena recuperata
			componenteNew.setAzione(null);
			componenteNew.setFlgDismesso(false);
			componenteNew.setFlgRipristina(false);
			componenteNew.setDataDismissione(null);

			//imposto la componente ripristinata come componente corrente (dimenticando quindi quella vecchia)
			theModel.setAppDatacomponenteBRRC(componenteNew);

			//la componente appena dichiarata attiva viene tolta dalla lista delle sostituite
			compList.remove(0);

			//l'elenco dei sostutuiti viene quindi aggiornato per capire qual e' la nuova componente riattivabile
			settaRiattivaSostituiti(true, theModel);

			// impostazione del result code 
			result.setResultCode(RIATTIVACOMPONENTESOSTITUITA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::riattivaComponenteSostituita] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ripristinaDettaglioAttuale definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4_2Dett
	 */
	public ExecResults ripristinaDettaglioAttuale(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RIPRISTINADETTAGLIOATTUALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RIPRISTINADETTAGLIOATTUALE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R428522217) ENABLED START*/
			//vengono ricaricate le vecchie informazioni persistite
			recuperaComponenteDett(theModel);

			// impostazione del result code 
			result.setResultCode(RIPRISTINADETTAGLIOATTUALE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ripristinaDettaglioAttuale] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazioneByFlgDismissioneOnRipristina definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4_2Dett
	 */
	public ExecResults gestisciAbilitazioneByFlgDismissioneOnRipristina(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONEBYFLGDISMISSIONEONRIPRISTINA_OUTCOME_CODE__DISMESSO = //NOSONAR  Reason:EIAS
				"DISMESSO"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONEBYFLGDISMISSIONEONRIPRISTINA_OUTCOME_CODE__ATTIVO = //NOSONAR  Reason:EIAS
				"ATTIVO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R409179668) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTISCIABILITAZIONEBYFLGDISMISSIONEONRIPRISTINA_OUTCOME_CODE__DISMESSO);

			if (isAbilitatoByFlgDismesso(theModel)) {
				result.setResultCode(GESTISCIABILITAZIONEBYFLGDISMISSIONEONRIPRISTINA_OUTCOME_CODE__ATTIVO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciAbilitazioneByFlgDismissioneOnRipristina] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////
 
	/**
	 * Implementazione del metodo salvaDettaglio definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4_2Dett
	 */
	public ExecResults salvaDettaglio(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVADETTAGLIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVADETTAGLIO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1917070957) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();
			String codImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			ComponenteBRRC componente = theModel.getAppDatacomponenteBRRC();
			ArrayList<ComponenteBRRC> compList = theModel.getAppDatalistaStoricoComponentiBRRC();

			try {
				//VALIDAZIONE
				getValidationMgr().validazioneFormaleLibrettoScheda4_2_4_3Dett(componente, compList, false,
						Constants.TIPO_COMPONENTE_BR, result);

				//n.b se la componente in primo piano ha il flagDismesso = true allora la componente e' dismessa
				if (GenericUtil.isNotNullOrEmpty(componente.getDataDismissione()) && !componente.getFlgDismesso()) {
					throw new ValidationManagerException(new Message(Messages.ERROR_COMPONENTE_NON_DISMESSA));
				}

				getDbMgr().salvaComponenteBRRC(codImpiantoSelez, componente, compList, utente.getCodiceFiscale(),
						Constants.TIPO_COMPONENTE_BR);

				theModel.setAppDataisNuovoComponente(false);
				theModel.setAppDatarigaSelezionata(componente.getComponente());

				result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);

				// impostazione del result code 
				result.setResultCode(SALVADETTAGLIO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaDettaglio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietroDaDettaglio definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4_2Dett
	 */
	public ExecResults gestisciIndietroDaDettaglio(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRODADETTAGLIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1514429216) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTISCIINDIETRODADETTAGLIO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciIndietroDaDettaglio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4_2Dett
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-536922009) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoLibrettoWEB(utente)) {
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
	 * Implementazione del metodo caricaSchedaDett definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4_2Dett
	 */
	public ExecResults caricaSchedaDett(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICASCHEDADETT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2050307151) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataelencoFabbricante() == null) {
				theModel.setAppDataelencoFabbricante(getSigitMgr().getListMarche());
			}

			if (theModel.getAppDataelencoTipoCombustibili() == null) {
				theModel.setAppDataelencoTipoCombustibili(getSigitMgr().getListCombustibile());
			}

			if (theModel.getAppDataelencoComponentiGT() == null) {
				theModel.setAppDataelencoComponentiGT(
						getSigitMgr().getListaComponentiGT(theModel.getAppDataidImpiantoSelez()));
			}

			recuperaComponenteDett(theModel);

			// impostazione del result code 
			result.setResultCode(CARICASCHEDADETT_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaSchedaDett] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazione definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4_2Dett
	 */
	public ExecResults gestisciAbilitazione(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONE_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONE_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2065783035) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			// impostazione del result code 
			if (GenericUtil.isUtenteAutorLibWebScheda4(utente)) {
				result.setResultCode(GESTISCIABILITAZIONE_OUTCOME_CODE__ABILITA);
			} else {
				result.setResultCode(GESTISCIABILITAZIONE_OUTCOME_CODE__DISABILITA);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilitazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazioneByFlgDismissioneOnEnter definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4_2Dett
	 */
	public ExecResults gestisciAbilitazioneByFlgDismissioneOnEnter(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONEBYFLGDISMISSIONEONENTER_OUTCOME_CODE__DISMESSO = //NOSONAR  Reason:EIAS
				"DISMESSO"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONEBYFLGDISMISSIONEONENTER_OUTCOME_CODE__ATTIVO = //NOSONAR  Reason:EIAS
				"ATTIVO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-221207583) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTISCIABILITAZIONEBYFLGDISMISSIONEONENTER_OUTCOME_CODE__DISMESSO);

			if (isAbilitatoByFlgDismesso(theModel)) {
				result.setResultCode(GESTISCIABILITAZIONEBYFLGDISMISSIONEONENTER_OUTCOME_CODE__ATTIVO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciAbilitazioneByFlgDismissioneOnEnter] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciMsg definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4_2Dett
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R471779159) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			GenericUtil.gestisciMessaggioSessione(theModel, result);

			// impostazione del result code 
			result.setResultCode(GESTISCIMSG_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciMsg] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbSostituzioni
	 */
	public static void resetClearStatus_widg_tbSostituzioni(java.util.Map session) {
		session.put("cpGestLibScheda4_2Dett_tbSostituzioni_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1869612840) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

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

	private void recuperaComponenteDett(
			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel)
			throws ManagerException {
		String codImpiantoSelez = theModel.getAppDataidImpiantoSelez();
		boolean isNuovoComponente = theModel.getAppDataisNuovoComponente();
		String compSelez = theModel.getAppDatarigaSelezionata();

		int progressivo = 0;

		if (isNuovoComponente) {
			//trattandosi di nuovo componente il progressivo dipende dalla lista di componenti gia' create
			List<ComponenteBRRC> componentiPersisted = theModel.getAppDatalistaComponentiBRRC();
			//find max value
			if (componentiPersisted != null) {
				for (ComponenteBRRC comp : componentiPersisted) {
					Integer progrComp = GenericUtil.getProgrComponente(comp.getComponente());
					if (progressivo < progrComp.intValue()) {
						progressivo = progrComp.intValue();
					}
				}
			}

			progressivo++;

			//viene creata una nuova componente
			ComponenteBRRC componenteNew = new ComponenteBRRC();
			componenteNew.setComponente(Constants.TIPO_COMPONENTE_BR + Constants.INTERVAL_SEP + progressivo);
			componenteNew.setFlgDismesso(false);

			//la nuova componente viene impostata nel modello come componente su cui lavorare
			theModel.setAppDatacomponenteBRRC(componenteNew);
			theModel.setAppDatalistaStoricoComponentiBRRC(null);
		} else {
			//si sta accedendo dal pulsante dettaglio: si caricano le componenti dello stesso progressivo
			//viene estratto il progressivo della componente da cui costruire lo storico
			progressivo = GenericUtil.getProgrComponente(compSelez);

			try {
				//si recupera lo storico della compSelez
				List<ComponenteBRRC> compList = getSigitMgr().cercaComponentiBrRcByFilter(codImpiantoSelez, progressivo,
						Constants.TIPO_COMPONENTE_BR, false, false);

				if (compList != null) {
					//la componente da impostare in primo piano corrisponde alla prima della lista
					ComponenteBRRC componentePrimoPriano = compList.get(0);
					theModel.setAppDatacomponenteBRRC(componentePrimoPriano);

					if (compList.size() > 1) {
						theModel.setAppDatalistaStoricoComponentiBRRC(
								new ArrayList<ComponenteBRRC>(compList.subList(1, compList.size())));
						settaRiattivaSostituiti(!componentePrimoPriano.getFlgDismesso(), theModel);
					} else {
						theModel.setAppDatalistaStoricoComponentiBRRC(null);
					}
				}

			} catch (Exception e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
		}
	}

	private void settaRiattivaSostituiti(boolean isRiattivabile,
			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel) {
		ArrayList<ComponenteBRRC> compList = theModel.getAppDatalistaStoricoComponentiBRRC();
		//isRiattivabile viene arricchito con l'info sull'utente loggato
		isRiattivabile = isRiattivabile && GenericUtil.isUtenteAutorLibWebScheda4(theModel.getAppDatautenteLoggato());
		if (compList != null) {
			for (int i = 0; i < compList.size(); i++) {
				if (isRiattivabile && i == 0) {
					// devo mettere il ripristina
					compList.get(i).setAzione(Constants.LABEL_RIPRISTINA);
					compList.get(i).setFlgRipristina(true);
				} else {
					// devo togliere il ripristina					
					compList.get(i).setAzione(null);
					compList.get(i).setFlgRipristina(false);
				}
			}
		}

		theModel.setAppDatalistaStoricoComponentiBRRC(compList);

	}

	private boolean isAbilitatoByFlgDismesso(
			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_2.CpGestLibScheda4_2DettModel theModel) {
		ComponenteBRRC componentePrimoPiano = theModel.getAppDatacomponenteBRRC();
		if (componentePrimoPiano != null && !componentePrimoPiano.getFlgDismesso()) {
			return true;
			//			result.setResultCode(GESTISCIABILITAZIONEBYFLGDISMISSIONE_OUTCOME_CODE__ATTIVO);
		} else {
			return false;
			//			result.setResultCode(GESTISCIABILITAZIONEBYFLGDISMISSIONE_OUTCOME_CODE__DISMESSO);
		}
	}

	/*PROTECTED REGION END*/
}
