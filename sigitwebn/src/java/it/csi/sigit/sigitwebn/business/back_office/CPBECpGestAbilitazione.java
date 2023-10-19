package it.csi.sigit.sigitwebn.business.back_office;

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

/*PROTECTED REGION ID(R1006303808) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;

/*PROTECTED REGION END*/

public class CPBECpGestAbilitazione {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [elencoIstatAbilitazioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOISTATABILITAZIONI_CODE = "appDataelencoIstatAbilitazioni";

	// ApplicationData: [elencoRuolo, scope:USER_SESSION]
	public static final String APPDATA_ELENCORUOLO_CODE = "appDataelencoRuolo";

	// ApplicationData: [abilitazione, scope:USER_SESSION]
	public static final String APPDATA_ABILITAZIONE_CODE = "appDataabilitazione";

	// ApplicationData: [elencoUtentiPaTrovati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOUTENTIPATROVATI_CODE = "appDataelencoUtentiPaTrovati";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [elencoUtentiPa, scope:USER_SESSION]
	public static final String APPDATA_ELENCOUTENTIPA_CODE = "appDataelencoUtentiPa";

	// ApplicationData: [comuniAbilitazione, scope:USER_SESSION]
	public static final String APPDATA_COMUNIABILITAZIONE_CODE = "appDatacomuniAbilitazione";

	// ApplicationData: [provinceAbilitazione, scope:USER_SESSION]
	public static final String APPDATA_PROVINCEABILITAZIONE_CODE = "appDataprovinceAbilitazione";

	// ApplicationData: [provinciaAbilitazioneSelez, scope:USER_ACTION]
	public static final String APPDATA_PROVINCIAABILITAZIONESELEZ_CODE = "appDataprovinciaAbilitazioneSelez";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestAbilitazione";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaUtente definito in un ExecCommand del
	 * ContentPanel cpGestAbilitazione
	 */
	public ExecResults ricercaUtente(

			it.csi.sigit.sigitwebn.dto.back_office.CpGestAbilitazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAUTENTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAUTENTE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R730249677) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDataelencoUtentiPaTrovati(
					getSigitMgr().getElencoUtentiPaByCf(theModel.getAppDataabilitazione().getCfUtente()));

			// impostazione del result code 
			result.setResultCode(RICERCAUTENTE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaUtente] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboboxComuni definito in un ExecCommand del
	 * ContentPanel cpGestAbilitazione
	 */
	public ExecResults gestisciComboboxComuni(

			it.csi.sigit.sigitwebn.dto.back_office.CpGestAbilitazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOBOXCOMUNI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-886751936) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			loadComuni(theModel);

			// impostazione del result code 
			result.setResultCode(GESTISCICOMBOBOXCOMUNI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboboxComuni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaAbilitazione definito in un ExecCommand del
	 * ContentPanel cpGestAbilitazione
	 */
	public ExecResults salvaAbilitazione(

			it.csi.sigit.sigitwebn.dto.back_office.CpGestAbilitazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAABILITAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAABILITAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1875334385) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Abilitazione abilitazione = theModel.getAppDataabilitazione();

				//Aggiungo descrizione dell' abilitazione
				abilitazione.setDescrAbilitazione(
						getSigitMgr().getDescrizioneAbilitazioneDaCodIstat(abilitazione.getIstatAbilitazione()));

				getValidationMgr().validazioneFormaleAbilitazione(abilitazione);

				getSigitMgr().salvaAbilitazione(abilitazione);

				// Ripulisco la combo per forzare il ricaricamento della stessa
				theModel.setAppDataelencoRuolo(null);
				theModel.setAppDataelencoUtentiPa(null);

				theModel.setAppDatamessaggioDinamico(Messages.INFO_INSERIMENTO_CORRETTO);
				//result.getGlobalMessages().add(Messages.INFO_INSERIMENTO_CORRETTO);

				// impostazione del result code 
				result.setResultCode(SALVAABILITAZIONE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaAbilitazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaAbilitazione definito in un ExecCommand del
	 * ContentPanel cpGestAbilitazione
	 */
	public ExecResults annullaAbilitazione(

			it.csi.sigit.sigitwebn.dto.back_office.CpGestAbilitazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLAABILITAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ANNULLAABILITAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R383129259) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			resetCampi(theModel);

			// impostazione del result code 
			result.setResultCode(ANNULLAABILITAZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaAbilitazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestAbilitazione
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.back_office.CpGestAbilitazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1663464179) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoBackOffice(utente)) {
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
	 * Implementazione del metodo inizializzaGestAbilitazione definito in un ExecCommand del
	 * ContentPanel cpGestAbilitazione
	 */
	public ExecResults inizializzaGestAbilitazione(

			it.csi.sigit.sigitwebn.dto.back_office.CpGestAbilitazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZAGESTABILITAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INIZIALIZZAGESTABILITAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2145237277) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			resetCampi(theModel);

			// impostazione del result code 
			result.setResultCode(INIZIALIZZAGESTABILITAZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inizializzaGestAbilitazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1467288268) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private SigitMgr sigitMgr;
	private DbMgr dbMgr;
	private ValidationMgr validationMgr;
	private ServiziMgr serviziMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

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

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	private Abilitazione getAbilitazioneSelez(ArrayList<Abilitazione> listAbilitazioni, Integer idAbilSelez) {
		return listAbilitazioni.get(idAbilSelez);
	}

	private void loadProvince(CpGestAbilitazioneModel theModel) throws ServiceException {

		ArrayList<CodeDescription> province = new ArrayList<CodeDescription>();

		CodeDescription tutteLeProvince = new CodeDescription();
		tutteLeProvince.setCode(Constants.COD_ISTAT_PIEMONTE);
		tutteLeProvince.setDescription(Constants.LABEL_ABILITA_SU_TUTTE_PROVINCE);

		province.add(tutteLeProvince);

		province.addAll(getServiziMgr().getListaIstatProvincePiemonte());

		theModel.setAppDataprovinceAbilitazione(province);

	}

	private void loadComuni(CpGestAbilitazioneModel theModel) throws ServiceException {

		String istatAbilitazione = theModel.getAppDataprovinciaAbilitazioneSelez();

		Abilitazione abilitazione = theModel.getAppDataabilitazione();

		ArrayList<CodeDescription> comuni = new ArrayList<CodeDescription>();

		if (istatAbilitazione != null) {

			if (!istatAbilitazione.equals(Constants.COD_ISTAT_PIEMONTE)) {
				CodeDescription tuttiIComuni = new CodeDescription();
				tuttiIComuni.setCode(istatAbilitazione);
				tuttiIComuni.setDescription(Constants.LABEL_ABILITA_SU_TUTTI_COMUNI);

				comuni.add(tuttiIComuni);

				comuni.addAll(getServiziMgr().getListaComuniByIstatProvincia(istatAbilitazione));

				abilitazione.setIstatAbilitazione(istatAbilitazione);
			} else {
				CodeDescription tutteLeProvince = new CodeDescription();
				tutteLeProvince.setCode(Constants.COD_ISTAT_PIEMONTE);
				tutteLeProvince.setDescription(Constants.LABEL_ABILITA_SU_TUTTE_PROVINCE);

				comuni.add(tutteLeProvince);

				abilitazione.setIstatAbilitazione(Constants.COD_ISTAT_PIEMONTE);
			}
		}

		theModel.setAppDatacomuniAbilitazione(comuni);

		theModel.setAppDataabilitazione(abilitazione);
	}

	private void resetCampi(it.csi.sigit.sigitwebn.dto.back_office.CpGestAbilitazioneModel theModel)
			throws ServiceException {

		theModel.setAppDataelencoUtentiPaTrovati(new ArrayList<CodeDescription>());

		Abilitazione abilitazione = theModel.getAppDataabilitazione();

		if (abilitazione == null) {
			abilitazione = new Abilitazione();
		}

		abilitazione.setIstatAbilitazione(null);

		theModel.setAppDataabilitazione(abilitazione);

		theModel.setAppDataprovinciaAbilitazioneSelez(null);

		loadProvince(theModel);

		loadComuni(theModel);
	}

	/*PROTECTED REGION END*/
}
