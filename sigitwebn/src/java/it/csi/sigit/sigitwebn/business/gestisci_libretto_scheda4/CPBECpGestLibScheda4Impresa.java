package it.csi.sigit.sigitwebn.business.gestisci_libretto_scheda4;

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

/*PROTECTED REGION ID(R-1324498801) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;

/*PROTECTED REGION END*/

public class CPBECpGestLibScheda4Impresa {

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

	// ApplicationData: [rigaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_RIGASELEZIONATA_CODE = "appDatarigaSelezionata";

	// ApplicationData: [isNuovoComponente, scope:USER_SESSION]
	public static final String APPDATA_ISNUOVOCOMPONENTE_CODE = "appDataisNuovoComponente";

	// ApplicationData: [elencoImprese, scope:USER_SESSION]
	public static final String APPDATA_ELENCOIMPRESE_CODE = "appDataelencoImprese";

	// ApplicationData: [idImpresaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDIMPRESASELEZIONATA_CODE = "appDataidImpresaSelezionata";

	// ApplicationData: [ricercaImprese, scope:USER_SESSION]
	public static final String APPDATA_RICERCAIMPRESE_CODE = "appDataricercaImprese";

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	// ApplicationData: [componenteGT, scope:USER_SESSION]
	public static final String APPDATA_COMPONENTEGT_CODE = "appDatacomponenteGT";

	// ApplicationData: [listaStoricoComponentiGT, scope:USER_SESSION]
	public static final String APPDATA_LISTASTORICOCOMPONENTIGT_CODE = "appDatalistaStoricoComponentiGT";

	// ApplicationData: [componenteCG, scope:USER_SESSION]
	public static final String APPDATA_COMPONENTECG_CODE = "appDatacomponenteCG";

	// ApplicationData: [listaComponentiCG, scope:USER_SESSION]
	public static final String APPDATA_LISTACOMPONENTICG_CODE = "appDatalistaComponentiCG";

	// ApplicationData: [listaStoricoComponentiCG, scope:USER_SESSION]
	public static final String APPDATA_LISTASTORICOCOMPONENTICG_CODE = "appDatalistaStoricoComponentiCG";

	// ApplicationData: [componenteGF, scope:USER_SESSION]
	public static final String APPDATA_COMPONENTEGF_CODE = "appDatacomponenteGF";

	// ApplicationData: [listaComponentiGF, scope:USER_SESSION]
	public static final String APPDATA_LISTACOMPONENTIGF_CODE = "appDatalistaComponentiGF";

	// ApplicationData: [listaStoricoComponentiGF, scope:USER_SESSION]
	public static final String APPDATA_LISTASTORICOCOMPONENTIGF_CODE = "appDatalistaStoricoComponentiGF";

	// ApplicationData: [componenteSC, scope:USER_SESSION]
	public static final String APPDATA_COMPONENTESC_CODE = "appDatacomponenteSC";

	// ApplicationData: [listaComponentiSC, scope:USER_SESSION]
	public static final String APPDATA_LISTACOMPONENTISC_CODE = "appDatalistaComponentiSC";

	// ApplicationData: [listaStoricoComponentiSC, scope:USER_SESSION]
	public static final String APPDATA_LISTASTORICOCOMPONENTISC_CODE = "appDatalistaStoricoComponentiSC";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestLibScheda4Impresa";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaImprese definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4Impresa
	 */
	public ExecResults cercaImprese(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4.CpGestLibScheda4ImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAIMPRESE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAIMPRESE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2090354473) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				RicercaImprese ricImpresa = theModel.getAppDataricercaImprese();

				getValidationMgr().verificaRicercaImpresaScheda4(ricImpresa);

				ArrayList<PersonaGiuridica> impreseList = getSigitMgr().cercaImpreseByParam(ricImpresa);
				theModel.setAppDataelencoImprese(impreseList);

				//gestioneMsgRicerca(theModel, result);

				// impostazione del result code 
				result.setResultCode(CERCAIMPRESE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				theModel.setAppDataelencoImprese(null);

				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaImprese] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaAllegato definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4Impresa
	 */
	public ExecResults salvaAllegato(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4.CpGestLibScheda4ImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAALLEGATO_OUTCOME_CODE__DETTAGLIO4_1 = //NOSONAR  Reason:EIAS
				"DETTAGLIO4_1"; //NOSONAR  Reason:EIAS
		final String SALVAALLEGATO_OUTCOME_CODE__DETTAGLIO4_4 = //NOSONAR  Reason:EIAS
				"DETTAGLIO4_4"; //NOSONAR  Reason:EIAS
		final String SALVAALLEGATO_OUTCOME_CODE__DETTAGLIO4_5 = //NOSONAR  Reason:EIAS
				"DETTAGLIO4_5"; //NOSONAR  Reason:EIAS
		final String SALVAALLEGATO_OUTCOME_CODE__DETTAGLIO4_6 = //NOSONAR  Reason:EIAS
				"DETTAGLIO4_6"; //NOSONAR  Reason:EIAS
		final String SALVAALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1458480298) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idImpSelez = theModel.getAppDataidImpresaSelezionata();
			try {
				getValidationMgr().checkSelezioneElemento(idImpSelez);

				String codImpiantoSelez = theModel.getAppDataidImpiantoSelez();

				UtenteLoggato utente = theModel.getAppDatautenteLoggato();

				String librettoScheda = (String) theModel.getSession().get(Constants.SESSIONE_VAR_LIBRETTO_SCHEDA);;
				log.debug("librettoScheda: " + librettoScheda);

				if (librettoScheda.equals("SCHEDA4_1")) {
					// impostazione del result code 
					result.setResultCode(SALVAALLEGATO_OUTCOME_CODE__DETTAGLIO4_1);

					ComponenteGT componente = theModel.getAppDatacomponenteGT();
					ArrayList<ComponenteGT> compList = theModel.getAppDatalistaStoricoComponentiGT();

					Integer progressivo = GenericUtil.getProgrComponente(componente.getComponente());

					getSigitMgr().salvaComponenteGT(codImpiantoSelez, progressivo.toString(), componente, compList,
							idImpSelez, utente, theModel.getAppDataisNuovoComponente());

					theModel.setAppDatarigaSelezionata(componente.getComponente());
				} else if (librettoScheda.equals("SCHEDA4_4")) {
					// impostazione del result code 
					result.setResultCode(SALVAALLEGATO_OUTCOME_CODE__DETTAGLIO4_4);

					ComponenteGF componente = theModel.getAppDatacomponenteGF();
					ArrayList<ComponenteGF> compList = theModel.getAppDatalistaStoricoComponentiGF();

					Integer progressivo = GenericUtil.getProgrComponente(componente.getComponente());

					getSigitMgr().salvaComponenteGF(codImpiantoSelez, progressivo.toString(), componente, compList,
							idImpSelez, utente, theModel.getAppDataisNuovoComponente());

					theModel.setAppDatarigaSelezionata(componente.getComponente());
				} else if (librettoScheda.equals("SCHEDA4_5")) {
					// impostazione del result code 
					result.setResultCode(SALVAALLEGATO_OUTCOME_CODE__DETTAGLIO4_5);

					ComponenteSC componente = theModel.getAppDatacomponenteSC();
					ArrayList<ComponenteSC> compList = theModel.getAppDatalistaStoricoComponentiSC();

					Integer progressivo = GenericUtil.getProgrComponente(componente.getComponente());

					getSigitMgr().salvaComponenteSC(codImpiantoSelez, progressivo.toString(), componente, compList,
							idImpSelez, utente, theModel.getAppDataisNuovoComponente());

					theModel.setAppDatarigaSelezionata(componente.getComponente());
				} else if (librettoScheda.equals("SCHEDA4_6")) {
					// impostazione del result code 
					result.setResultCode(SALVAALLEGATO_OUTCOME_CODE__DETTAGLIO4_6);

					ComponenteCG componente = theModel.getAppDatacomponenteCG();
					ArrayList<ComponenteCG> compList = theModel.getAppDatalistaStoricoComponentiCG();

					Integer progressivo = GenericUtil.getProgrComponente(componente.getComponente());

					getSigitMgr().salvaComponenteCG(codImpiantoSelez, progressivo.toString(), componente, compList,
							idImpSelez, utente, theModel.getAppDataisNuovoComponente());

					theModel.setAppDatarigaSelezionata(componente.getComponente());
				}

				theModel.setAppDataisNuovoComponente(false);

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.INFO_SALVATAGGIO_CORRETTO, Message.INFO));

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4Impresa
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4.CpGestLibScheda4ImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__SCHEDA4_1 = //NOSONAR  Reason:EIAS
				"SCHEDA4_1"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__SCHEDA4_4 = //NOSONAR  Reason:EIAS
				"SCHEDA4_4"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__SCHEDA4_5 = //NOSONAR  Reason:EIAS
				"SCHEDA4_5"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__SCHEDA4_6 = //NOSONAR  Reason:EIAS
				"SCHEDA4_6"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R328034670) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String librettoScheda = (String) theModel.getSession().get(Constants.SESSIONE_VAR_LIBRETTO_SCHEDA);;
			log.debug("librettoScheda: " + librettoScheda);

			if (librettoScheda.equals("SCHEDA4_1")) {
				// impostazione del result code 
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__SCHEDA4_1);
			} else if (librettoScheda.equals("SCHEDA4_4")) {
				// impostazione del result code 
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__SCHEDA4_4);
			} else if (librettoScheda.equals("SCHEDA4_5")) {
				// impostazione del result code 
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__SCHEDA4_5);
			} else if (librettoScheda.equals("SCHEDA4_6")) {
				// impostazione del result code 
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__SCHEDA4_6);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::tornaPaginaChiamante] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaScheda definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4Impresa
	 */
	public ExecResults caricaScheda(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4.CpGestLibScheda4ImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICASCHEDA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1698627535) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// Ripulisco i campi
			theModel.setAppDataidImpresaSelezionata(null);
			theModel.setAppDataricercaImprese(null);
			theModel.setAppDataelencoImprese(null);

			// impostazione del result code 
			result.setResultCode(CARICASCHEDA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaScheda] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazione definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda4Impresa
	 */
	public ExecResults gestisciAbilitazione(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4.CpGestLibScheda4ImpresaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONE_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONE_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1883049688) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTISCIABILITAZIONE_OUTCOME_CODE__ABILITA);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilitazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbImpTrovate
	 */
	public static void resetClearStatus_widg_tbImpTrovate(java.util.Map session) {
		session.put("cpGestLibScheda4Impresa_tbImpTrovate_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-374417345) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

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

	/*PROTECTED REGION END*/
}
