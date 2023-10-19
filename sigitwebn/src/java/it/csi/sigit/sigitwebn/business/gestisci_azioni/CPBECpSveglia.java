package it.csi.sigit.sigitwebn.business.gestisci_azioni;

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

/*PROTECTED REGION ID(R1670658649) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;

/*PROTECTED REGION END*/

public class CPBECpSveglia {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [sveglia, scope:USER_SESSION]
	public static final String APPDATA_SVEGLIA_CODE = "appDatasveglia";

	// ApplicationData: [idAzioneSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDAZIONESELEZIONATA_CODE = "appDataidAzioneSelezionata";

	// ApplicationData: [idTipoAzione, scope:USER_SESSION]
	public static final String APPDATA_IDTIPOAZIONE_CODE = "appDataidTipoAzione";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpSveglia";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaSveglia definito in un ExecCommand del
	 * ContentPanel cpSveglia
	 */
	public ExecResults salvaSveglia(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpSvegliaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVASVEGLIA_OUTCOME_CODE__VERIFICA = //NOSONAR  Reason:EIAS
				"VERIFICA"; //NOSONAR  Reason:EIAS
		final String SALVASVEGLIA_OUTCOME_CODE__ACCERTAMENTO = //NOSONAR  Reason:EIAS
				"ACCERTAMENTO"; //NOSONAR  Reason:EIAS
		final String SALVASVEGLIA_OUTCOME_CODE__ISPEZIONE = //NOSONAR  Reason:EIAS
				"ISPEZIONE"; //NOSONAR  Reason:EIAS
		final String SALVASVEGLIA_OUTCOME_CODE__SANZIONE = //NOSONAR  Reason:EIAS
				"SANZIONE"; //NOSONAR  Reason:EIAS
		final String SALVASVEGLIA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1165414100) ENABLED START*/

			//			Il sistema verifica, oltre all’obbligatorietà dei campi, che la data indicata sia futura; 
			//			se non rispetta questo criterio viene presentato un messaggio di errore
			//			Se i controlli vengono superati il sistema aggiorna (su DB) 
			//			il campo SIGIT_T_VERIFICA.dt_sveglia, chiude le maschere M079_4 e M079_3 e riaggiorna la maschera M079_1

			try {
				getValidationMgr().validazioneFormaleSveglia(theModel.getAppDatasveglia());

				int idTipoAzione = theModel.getAppDataidTipoAzione();

				getSigitMgr().modificaSveglia(theModel.getAppDatasveglia(), idTipoAzione,
						theModel.getAppDataidAzioneSelezionata());

				switch (idTipoAzione) {
					case Constants.ID_TIPO_AZIONE_VERIFICA :
						result.setResultCode(SALVASVEGLIA_OUTCOME_CODE__VERIFICA);
						break;
					case Constants.ID_TIPO_AZIONE_ACCERTAMENTO :
						result.setResultCode(SALVASVEGLIA_OUTCOME_CODE__ACCERTAMENTO);
						break;
					case Constants.ID_TIPO_AZIONE_ISPEZIONE :
						result.setResultCode(SALVASVEGLIA_OUTCOME_CODE__ISPEZIONE);
						break;
					case Constants.ID_TIPO_AZIONE_SANZIONE :
						result.setResultCode(SALVASVEGLIA_OUTCOME_CODE__SANZIONE);
						break;
				}

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
			log.error("[BackEndFacade::salvaSveglia] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaSveglia definito in un ExecCommand del
	 * ContentPanel cpSveglia
	 */
	public ExecResults eliminaSveglia(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpSvegliaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINASVEGLIA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String ELIMINASVEGLIA_OUTCOME_CODE__VERIFICA = //NOSONAR  Reason:EIAS
				"VERIFICA"; //NOSONAR  Reason:EIAS
		final String ELIMINASVEGLIA_OUTCOME_CODE__ACCERTAMENTO = //NOSONAR  Reason:EIAS
				"ACCERTAMENTO"; //NOSONAR  Reason:EIAS
		final String ELIMINASVEGLIA_OUTCOME_CODE__ISPEZIONE = //NOSONAR  Reason:EIAS
				"ISPEZIONE"; //NOSONAR  Reason:EIAS
		final String ELIMINASVEGLIA_OUTCOME_CODE__SANZIONE = //NOSONAR  Reason:EIAS
				"SANZIONE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2081706132) ENABLED START*/
			//VENGONO SVUOTATI I CAMPI DATA SVEGLIA E NOTE
			try {
				//in base al tipo di azione si stabilisce l'oggetto da modificare

				int idTipoAzione = theModel.getAppDataidTipoAzione();

				Sveglia svegliaVerifica = new Sveglia();
				svegliaVerifica.setNoteSveglia(null);
				svegliaVerifica.setDataSveglia(null);

				getSigitMgr().modificaSveglia(svegliaVerifica, idTipoAzione, theModel.getAppDataidAzioneSelezionata());

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.INFO_SALVATAGGIO_CORRETTO, Message.INFO));

				// impostazione del result code 
				result.setResultCode(tornaAPaginaChiamante(theModel, ELIMINASVEGLIA_OUTCOME_CODE__VERIFICA,
						ELIMINASVEGLIA_OUTCOME_CODE__ACCERTAMENTO, ELIMINASVEGLIA_OUTCOME_CODE__ISPEZIONE,
						ELIMINASVEGLIA_OUTCOME_CODE__SANZIONE));

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaSveglia] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietro definito in un ExecCommand del
	 * ContentPanel cpSveglia
	 */
	public ExecResults gestisciIndietro(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpSvegliaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRO_OUTCOME_CODE__VERIFICA = //NOSONAR  Reason:EIAS
				"VERIFICA"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__ACCERTAMENTO = //NOSONAR  Reason:EIAS
				"ACCERTAMENTO"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__ISPEZIONE = //NOSONAR  Reason:EIAS
				"ISPEZIONE"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__SANZIONE = //NOSONAR  Reason:EIAS
				"SANZIONE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1689537699) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(tornaAPaginaChiamante(theModel, GESTISCIINDIETRO_OUTCOME_CODE__VERIFICA,
					GESTISCIINDIETRO_OUTCOME_CODE__ACCERTAMENTO, GESTISCIINDIETRO_OUTCOME_CODE__ISPEZIONE,
					GESTISCIINDIETRO_OUTCOME_CODE__SANZIONE));
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciIndietro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpSveglia
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpSvegliaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1965284794) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String descRuolo = theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo();

			if (descRuolo.equals(Constants.RUOLO_ISPETTORE) || descRuolo.equals(Constants.RUOLO_VALIDATORE)
					|| descRuolo.equals(Constants.RUOLO_SUPER)) {
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
	 * Implementazione del metodo preparaFormSveglia definito in un ExecCommand del
	 * ContentPanel cpSveglia
	 */
	public ExecResults preparaFormSveglia(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpSvegliaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAFORMSVEGLIA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAFORMSVEGLIA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R252128522) ENABLED START*/
			// in base all'id della verifica viene caricato l'oggetto da db
			try {

				log.debug("[BackEndFacade::preparaFormSveglia] idTipoAzione: " + theModel.getAppDataidTipoAzione());
				log.debug("[BackEndFacade::preparaFormSveglia] idAzioneSelezionata: "
						+ theModel.getAppDataidAzioneSelezionata());

				Sveglia sveglia = getSigitMgr().getSvegliaById(theModel.getAppDataidTipoAzione(),
						theModel.getAppDataidAzioneSelezionata());
				if (sveglia != null && sveglia.getIdentificativoExtended() != null) {
					theModel.setAppDatasveglia(sveglia);
				}
				result.setResultCode(PREPARAFORMSVEGLIA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaFormSveglia] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1464536309) ENABLED START*/
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

	private String tornaAPaginaChiamante(it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpSvegliaModel theModel,
			String backVerifica, String backAccertamento, String backIspezione, String backSanzione) {
		String risultato = null;

		if (theModel.getAppDataidTipoAzione() != null) {
			switch (theModel.getAppDataidTipoAzione()) {
				case Constants.ID_TIPO_AZIONE_VERIFICA :
					risultato = backVerifica;
					break;
				case Constants.ID_TIPO_AZIONE_ACCERTAMENTO :
					risultato = backAccertamento;
					break;
				case Constants.ID_TIPO_AZIONE_ISPEZIONE :
					risultato = backIspezione;
					break;
				case Constants.ID_TIPO_AZIONE_SANZIONE :
					risultato = backSanzione;
					break;
			}
		}

		return risultato;

	}

	/*PROTECTED REGION END*/
}
