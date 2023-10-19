package it.csi.sigit.sigitwebn.business.gestisci_verifica;

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

/*PROTECTED REGION ID(R-1274911234) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
/*PROTECTED REGION END*/

public class CPBECpGestVerifica {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [verifica, scope:USER_SESSION]
	public static final String APPDATA_VERIFICA_CODE = "appDataverifica";

	// ApplicationData: [elencoTipiVerifica, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPIVERIFICA_CODE = "appDataelencoTipiVerifica";

	// ApplicationData: [elencoSiglaBollini, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLABOLLINI_CODE = "appDataelencoSiglaBollini";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [idVerificaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDVERIFICASELEZIONATA_CODE = "appDataidVerificaSelezionata";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestVerifica";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestInsVerificaAuto definito in un ExecCommand del
	 * ContentPanel cpGestVerifica
	 */
	public ExecResults gestInsVerificaAuto(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINSVERIFICAAUTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1081227254) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTINSVERIFICAAUTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestInsVerificaAuto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo resetInserimento definito in un ExecCommand del
	 * ContentPanel cpGestVerifica
	 */
	public ExecResults resetInserimento(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RESETINSERIMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RESETINSERIMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1742732951) ENABLED START*/
			//invocata al cambiamento del valore della combo sul tipo di verifica.
			//deve resettare i valori impostati dalle ricerche

			Verifica verifica = theModel.getAppDataverifica();
			if (verifica != null) {
				verifica.setCodiceImpianto(null);
				verifica.setRisultatoImpianto(null);
				verifica.setSiglaBollino(null);
				verifica.setNumeroBollino(null);
				verifica.setIdAllegato(null);
				verifica.setRisultatoBollino(null);
				verifica.setRisultatoBollinoExtended(null);
				verifica.setIdDatoDistributore(null);
				verifica.setRisultatoDatoDistributore(null);
			}
			// impostazione del result code 
			result.setResultCode(RESETINSERIMENTO_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::resetInserimento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaImpianto definito in un ExecCommand del
	 * ContentPanel cpGestVerifica
	 */
	public ExecResults cercaImpianto(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1860589640) ENABLED START*/
			try {
				UtenteLoggato utenteLog = theModel.getAppDatautenteLoggato();
				String istatAbilitazioneTmp = utenteLog.getRuolo().getIstatAbilitazione();

				String istatAbilitazione = null;

				String descRuolo = utenteLog.getRuolo().getDescRuolo();

				if ((descRuolo.equals(Constants.RUOLO_CONSULTATORE) || descRuolo.equals(Constants.RUOLO_VALIDATORE)
						|| descRuolo.equals(Constants.RUOLO_ISPETTORE)) && istatAbilitazioneTmp.length() > 2) {
					istatAbilitazione = istatAbilitazioneTmp;
				}

				getSigitMgr().ricercaImpiantoPerVerifica(theModel.getAppDataverifica(), true, istatAbilitazione);

				// impostazione del result code 
				result.setResultCode(CERCAIMPIANTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
				result.setResultCode(CERCAIMPIANTO_OUTCOME_CODE__KO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaImpianto definito in un ExecCommand del
	 * ContentPanel cpGestVerifica
	 */
	public ExecResults nuovaRicercaImpianto(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCAIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-691090988) ENABLED START*/
			Verifica verifica = theModel.getAppDataverifica();
			if (verifica != null) {
				verifica.setCodiceImpianto(null);
				verifica.setRisultatoImpianto(null);
			}

			result.setResultCode(NUOVARICERCAIMPIANTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaBollino definito in un ExecCommand del
	 * ContentPanel cpGestVerifica
	 */
	public ExecResults cercaBollino(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCABOLLINO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCABOLLINO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R309550) ENABLED START*/
			try {

				UtenteLoggato utenteLog = theModel.getAppDatautenteLoggato();
				String istatAbilitazioneTmp = utenteLog.getRuolo().getIstatAbilitazione();

				String istatAbilitazione = null;

				String descRuolo = utenteLog.getRuolo().getDescRuolo();

				if ((descRuolo.equals(Constants.RUOLO_CONSULTATORE) || descRuolo.equals(Constants.RUOLO_VALIDATORE)
						|| descRuolo.equals(Constants.RUOLO_ISPETTORE)) && istatAbilitazioneTmp.length() > 2) {
					istatAbilitazione = istatAbilitazioneTmp;
				}

				getSigitMgr().ricercaBollinoPerVerifica(theModel.getAppDataverifica(), true, istatAbilitazione);

				result.setResultCode(CERCABOLLINO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
				result.setResultCode(CERCABOLLINO_OUTCOME_CODE__KO);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaBollino] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaBollino definito in un ExecCommand del
	 * ContentPanel cpGestVerifica
	 */
	public ExecResults nuovaRicercaBollino(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCABOLLINO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCABOLLINO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1883118046) ENABLED START*/
			//vengono resettati i campi per la ricerca del bollino e anche l'id dell'allegato trovato
			Verifica verifica = theModel.getAppDataverifica();
			if (verifica != null) {
				verifica.setSiglaBollino(null);
				verifica.setNumeroBollino(null);
				verifica.setIdAllegato(null);
				verifica.setRisultatoBollino(null);
				verifica.setRisultatoBollinoExtended(null);
			}

			// impostazione del result code 
			result.setResultCode(NUOVARICERCABOLLINO_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaBollino] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaDistributore definito in un ExecCommand del
	 * ContentPanel cpGestVerifica
	 */
	public ExecResults cercaDistributore(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCADISTRIBUTORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCADISTRIBUTORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1430374129) ENABLED START*/
			try {

				UtenteLoggato utenteLog = theModel.getAppDatautenteLoggato();
				String istatAbilitazioneTmp = utenteLog.getRuolo().getIstatAbilitazione();

				String istatAbilitazione = null;

				String descRuolo = utenteLog.getRuolo().getDescRuolo();

				if ((descRuolo.equals(Constants.RUOLO_CONSULTATORE) || descRuolo.equals(Constants.RUOLO_VALIDATORE)
						|| descRuolo.equals(Constants.RUOLO_ISPETTORE)) && istatAbilitazioneTmp.length() > 2) {
					istatAbilitazione = istatAbilitazioneTmp;
				}

				getSigitMgr().ricercaDistributorePerVerifica(theModel.getAppDataverifica(), true, istatAbilitazione);

				// impostazione del result code 
				result.setResultCode(CERCADISTRIBUTORE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
				result.setResultCode(CERCADISTRIBUTORE_OUTCOME_CODE__KO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaDistributore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaDistributore definito in un ExecCommand del
	 * ContentPanel cpGestVerifica
	 */
	public ExecResults nuovaRicercaDistributore(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCADISTRIBUTORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCADISTRIBUTORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R515572891) ENABLED START*/

			Verifica verifica = theModel.getAppDataverifica();
			if (verifica != null) {
				verifica.setIdDatoDistributore(null);
				verifica.setRisultatoDatoDistributore(null);
			}
			result.setResultCode(NUOVARICERCADISTRIBUTORE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaDistributore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaVerifica definito in un ExecCommand del
	 * ContentPanel cpGestVerifica
	 */
	public ExecResults salvaVerifica(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAVERIFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAVERIFICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R585155467) ENABLED START*/
			try {
				//VIENE RECUPERATA LA DESCRIZIONE DEL TIPO VERIFICA
				TipoVerificaEnum tipoVerificaEnum = null;

				if (!GenericUtil.isNullOrEmpty(theModel.getAppDataverifica().getTipoVerifica())
						&& theModel.getAppDataelencoTipiVerifica() != null) {
					for (IdDescription codeDes : theModel.getAppDataelencoTipiVerifica()) {
						if (codeDes.getId() == theModel.getAppDataverifica().getTipoVerifica()) {
							tipoVerificaEnum = TipoVerificaEnum.getFromDbValue(codeDes.getId());
							break;
						}
					}
				}

				getValidationMgr().validazioneFormaleVerifica(theModel.getAppDataverifica(), tipoVerificaEnum);

				Verifica verifica = theModel.getAppDataverifica();

				// Pulisco il campo dell'id per forzare l'inserimento, perche' nel caso l'utente usa il back del browser il capo "Identificativo" e' valorizzato e quindi va in update
				verifica.setIdentificativo(null);

				String idVerifica = getSigitMgr().salvaVerifica(verifica, theModel.getAppDatautenteLoggato());
				theModel.setAppDataidVerificaSelezionata(idVerifica);
				result.getGlobalMessages().add(Messages.INFO_INSERIMENTO_CORRETTO);
				result.setResultCode(SALVAVERIFICA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaVerifica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaVerificaAuto definito in un ExecCommand del
	 * ContentPanel cpGestVerifica
	 */
	public ExecResults salvaVerificaAuto(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAVERIFICAAUTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAVERIFICAAUTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2136785820) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Verifica verifica = theModel.getAppDataverifica();

				// Pulisco il campo dell'id per forzare l'inserimento, perche' nel caso l'utente usa il back del browser il capo "Identificativo" e' valorizzato e quindi va in update
				verifica.setIdentificativo(null);

				String idVerifica = getSigitMgr().salvaVerifica(verifica, theModel.getAppDatautenteLoggato());
				theModel.setAppDataidVerificaSelezionata(idVerifica);
				result.getGlobalMessages().add(Messages.INFO_INSERIMENTO_CORRETTO);

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.INFO_INSERIMENTO_CORRETTO, Message.INFO));

				result.setResultCode(SALVAVERIFICAAUTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.ERROR_RECUPERO_SERVIZIO, Message.ERROR));

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaVerificaAuto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAnnulla definito in un ExecCommand del
	 * ContentPanel cpGestVerifica
	 */
	public ExecResults gestisciAnnulla(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIANNULLA_OUTCOME_CODE__ELENCO_IMPIANTI = //NOSONAR  Reason:EIAS
				"ELENCO_IMPIANTI"; //NOSONAR  Reason:EIAS
		final String GESTISCIANNULLA_OUTCOME_CODE__ELENCO_IMPIANTI_AVZ = //NOSONAR  Reason:EIAS
				"ELENCO_IMPIANTI_AVZ"; //NOSONAR  Reason:EIAS
		final String GESTISCIANNULLA_OUTCOME_CODE__ELENCO_ALLEGATI_IMP = //NOSONAR  Reason:EIAS
				"ELENCO_ALLEGATI_IMP"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-482120739) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String paginaChiamante = theModel.getAppDatapaginaChiamante();

			if (Constants.PAG_RIS_RIC_IMPIANTI.equals(paginaChiamante)) {
				// impostazione del result code 
				result.setResultCode(GESTISCIANNULLA_OUTCOME_CODE__ELENCO_IMPIANTI);
			} else if (Constants.PAG_RIS_RIC_AVZ_IMPIANTI.equals(paginaChiamante)) {
				// impostazione del result code 
				result.setResultCode(GESTISCIANNULLA_OUTCOME_CODE__ELENCO_IMPIANTI_AVZ);
			} else if (Constants.PAG_ELENCO_ALL_IMPIANTI.equals(paginaChiamante)) {
				// impostazione del result code 
				result.setResultCode(GESTISCIANNULLA_OUTCOME_CODE__ELENCO_ALLEGATI_IMP);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAnnulla] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestVerifica
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1581142901) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoInserimentoAzioneSvegliaIspezioneSanzione(utenteLoggato)) {
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
	 * Implementazione del metodo preparaFormRicerca definito in un ExecCommand del
	 * ContentPanel cpGestVerifica
	 */
	public ExecResults preparaFormRicerca(

			it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAFORMRICERCA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1529720755) ENABLED START*/
			resetRicerca(theModel);

			preparaVerifica(theModel);

			result.setResultCode(PREPARAFORMRICERCA_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaFormRicerca] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-629929418) ENABLED START*/
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

	private ServiziMgr serviziMgr;

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	private void resetRicerca(it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel theModel)
			throws ManagerException, ServiceException {

		if (theModel.getAppDataelencoTipiVerifica() == null || theModel.getAppDataelencoTipiVerifica().isEmpty()) {
			//viene popolata la lista dei tipi di verifica
			theModel.setAppDataelencoTipiVerifica(getSigitMgr().getElencoTipoVerifiche());
		}

		if (theModel.getAppDataelencoSiglaBollini() == null || theModel.getAppDataelencoSiglaBollini().isEmpty()) {
			theModel.setAppDataelencoSiglaBollini(getServiziMgr().getListaSiglaProvincePiemonteManipolata());
		}
	}

	private void preparaVerifica(it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel theModel)
			throws ManagerException {
		Verifica verifica = new Verifica();
		UtenteLoggato utente = theModel.getAppDatautenteLoggato();
		//IMPOSTAZIONE INFO DEFAULT
		verifica.setCfUtenteCaricamento(utente.getCodiceFiscale());
		verifica.setDenomUtenteCaricamento(utente.getDenominazione());
		verifica.setEseguitoDa(utente.getDenominazione() + " (" + utente.getCodiceFiscale() + ")");
		verifica.setDataCaricamento(DateUtil.getDataCorrenteFormat());
		theModel.setAppDataverifica(verifica);
	}

	public enum RicercaCampoVerificaEnum {
		RICERCA_IMPIANTO, RICERCA_BOLLINO, RICERCA_DISTRIBUTORE
	}

	public enum TipoVerificaEnum {

		IMPIANTO(1, "Impianto"), REE(2, "Rapporto Efficienza Energetica (REE)"), RELAZIONE(3,
				"Relazione Esimente"), DATO_DISTRIBUTORE(4, "Dato distributore"), SEGNALAZIONE(5,
						"Segnalazione"), DECADENZA3R(6, "Decadenza 3 Responsabile"), ALTRO(7, "Altro");

		private Integer idDb;

		private String descrizioneDb;

		public Integer getIdDb() {
			return idDb;
		}

		public void setIdDb(Integer idDb) {
			this.idDb = idDb;
		}

		public String getDescrizioneDb() {
			return descrizioneDb;
		}

		public void setDescrizioneDb(String descrizioneDb) {
			this.descrizioneDb = descrizioneDb;
		}

		private TipoVerificaEnum(Integer idDb, String descrizioneDb) {
			this.idDb = idDb;
			this.descrizioneDb = descrizioneDb;
		}

		public static TipoVerificaEnum getFromDbValue(Integer dbValue) {
			for (TipoVerificaEnum tipoEnum : TipoVerificaEnum.values()) {
				if (tipoEnum.getIdDb().equals(dbValue)) {
					return tipoEnum;
				}
			}
			return null;
		}
	}

	/*PROTECTED REGION END*/
}
