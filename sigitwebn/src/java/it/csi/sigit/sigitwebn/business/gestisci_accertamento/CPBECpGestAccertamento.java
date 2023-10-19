package it.csi.sigit.sigitwebn.business.gestisci_accertamento;

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

/*PROTECTED REGION ID(R-778007217) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTImpiantoDto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicercaImpiantiDto;
import it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpGestAccertamentoModel;
import it.csi.sigit.sigitwebn.dto.ricerca_accertamenti.CpRicercaAccertamentiModel;

/*PROTECTED REGION END*/

public class CPBECpGestAccertamento {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [accertamento, scope:USER_SESSION]
	public static final String APPDATA_ACCERTAMENTO_CODE = "appDataaccertamento";

	// ApplicationData: [elencoTipoAnomalie, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOANOMALIE_CODE = "appDataelencoTipoAnomalie";

	// ApplicationData: [idAccertamentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDACCERTAMENTOSELEZIONATO_CODE = "appDataidAccertamentoSelezionato";

	// ApplicationData: [verifica, scope:USER_SESSION]
	public static final String APPDATA_VERIFICA_CODE = "appDataverifica";

	// ApplicationData: [elencoComuniPiemonteIstat, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIPIEMONTEISTAT_CODE = "appDataelencoComuniPiemonteIstat";

	// ApplicationData: [elencoProvincePiemonteIstat, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCEPIEMONTEISTAT_CODE = "appDataelencoProvincePiemonteIstat";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestAccertamento";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadComuni definito in un ExecCommand del
	 * ContentPanel cpGestAccertamento
	 */
	public ExecResults loadComuni(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpGestAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-971190697) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(LOADCOMUNI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadComuni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaAccertamento definito in un ExecCommand del
	 * ContentPanel cpGestAccertamento
	 */
	public ExecResults salvaAccertamento(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpGestAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAACCERTAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAACCERTAMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1442018835) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				getValidationMgr().validazioneFormaleAccertamento(theModel.getAppDataaccertamento());

				String idAccertamento = getSigitMgr().salvaAccertamento(theModel.getAppDataaccertamento(), null,
						theModel.getAppDatautenteLoggato());

				theModel.setAppDataidAccertamentoSelezionato(idAccertamento);
				result.getGlobalMessages().add(Messages.INFO_INSERIMENTO_CORRETTO);
				result.setResultCode(SALVAACCERTAMENTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaAccertamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestAccertamento
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpGestAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R685015044) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String descRuolo = theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo();

			if (descRuolo.equals(Constants.RUOLO_VALIDATORE) || descRuolo.equals(Constants.RUOLO_SUPER)) {
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
	 * ContentPanel cpGestAccertamento
	 */
	public ExecResults preparaFormRicerca(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpGestAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAFORMRICERCA_OUTCOME_CODE__RUOLO_PA_PROVINCIA = //NOSONAR  Reason:EIAS
				"RUOLO_PA_PROVINCIA"; //NOSONAR  Reason:EIAS
		final String PREPARAFORMRICERCA_OUTCOME_CODE__RUOLO_PA_COMUNE = //NOSONAR  Reason:EIAS
				"RUOLO_PA_COMUNE"; //NOSONAR  Reason:EIAS
		final String PREPARAFORMRICERCA_OUTCOME_CODE__RUOLO_ALTRO = //NOSONAR  Reason:EIAS
				"RUOLO_ALTRO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R579835164) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			resetRicerca(theModel);

			preparaAccertamento(theModel);

			if (theModel.getAppDataverifica() != null
					&& GenericUtil.isNotNullOrEmpty(theModel.getAppDataverifica().getCodiceImpianto())) {
				SigitTImpiantoDto imp = sigitMgr.getImpiantoByCodice(theModel.getAppDataverifica().getCodiceImpianto());
				theModel.setAppDataelencoProvincePiemonteIstat(getServiziMgr().getListaIstatProvincePiemonte());
				theModel.setAppDataelencoComuniPiemonteIstat(getServiziMgr().getListaComuniByIstatProvincia(
						GenericUtil.getCodIstatProvByCodIstatComune(imp.getIstatComune())));
				theModel.getAppDataaccertamento().setCodIstatCom(imp.getIstatComune());
				theModel.getAppDataaccertamento()
						.setCodIstatProv(GenericUtil.getCodIstatProvByCodIstatComune(imp.getIstatComune()));
				result.setResultCode(PREPARAFORMRICERCA_OUTCOME_CODE__RUOLO_PA_COMUNE);
			} else {
				result = gestisciAbilRuoloRef(theModel, PREPARAFORMRICERCA_OUTCOME_CODE__RUOLO_PA_PROVINCIA,
						PREPARAFORMRICERCA_OUTCOME_CODE__RUOLO_PA_COMUNE, PREPARAFORMRICERCA_OUTCOME_CODE__RUOLO_ALTRO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaFormRicerca] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboGeo definito in un ExecCommand del
	 * ContentPanel cpGestAccertamento
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpGestAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOGEO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R638219642) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			gestisciComboDtCatasto(theModel);

			// impostazione del result code 
			result.setResultCode(GESTISCICOMBOGEO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

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
	/*PROTECTED REGION ID(R933188549) ENABLED START*/
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

	private void resetRicerca(it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpGestAccertamentoModel theModel)
			throws ManagerException, ServiceException {

		if (theModel.getAppDataelencoTipoAnomalie() == null || theModel.getAppDataelencoTipoAnomalie().isEmpty()) {
			//viene popolata la lista dei tipi di anomalia
			theModel.setAppDataelencoTipoAnomalie(getSigitMgr().getElencoTipoAnomalie());
		}

		theModel.setAppDataelencoComuniPiemonteIstat(new ArrayList<>());

		if (theModel.getAppDataelencoProvincePiemonteIstat() == null
				|| theModel.getAppDataelencoProvincePiemonteIstat().isEmpty()) {
			theModel.setAppDataelencoProvincePiemonteIstat(getServiziMgr().getListaIstatProvincePiemonte());
		}

	}

	private void preparaAccertamento(it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpGestAccertamentoModel theModel)
			throws ManagerException {
		//SE NON C'E' LA RIGA SELEZIONATA ALLORA SI TRATTA DI UN NUOV ACCERTAMENTO
		boolean nuova = GenericUtil.isNullOrEmpty(theModel.getAppDataidAccertamentoSelezionato());

		Accertamento accertamento = null;

		if (nuova) {
			UtenteLoggato utente = theModel.getAppDatautenteLoggato();
			//IMPOSTAZIONE INFO DEFAULT
			accertamento = new Accertamento();
			accertamento.setCfUtenteCaricamento(utente.getCodiceFiscale());
			accertamento.setDenomUtenteCaricamento(utente.getDenominazione());
			//accertamento.setAssegnatario(utente.getDenominazione() + " (" + utente.getCodiceFiscale() + ")");
			accertamento.setDataCreazione(DateUtil.getDataCorrenteFormat());

			SigitVRicercaImpiantiDto impiantoEntity = null;

			// Se arrivo dalle veriche, e se e' presente il codiceImpianto, ricerco l'indirizzo
			if (theModel.getAppDataverifica() != null
					&& GenericUtil.isNotNullOrEmpty(theModel.getAppDataverifica().getCodiceImpianto())) {
				impiantoEntity = getDbMgr().cercaImpiantoByCodImpianto(
						ConvertUtil.convertToBigDecimal(theModel.getAppDataverifica().getCodiceImpianto()));

				accertamento.setCodiceImpianto(theModel.getAppDataverifica().getCodiceImpianto());
				accertamento.setIndirizzoImpianto(MapDto.getIndirizzoCompleto(impiantoEntity.getDenominazioneComune(),
						impiantoEntity.getIndirizzoUnitaImmob(), impiantoEntity.getCivico(),
						impiantoEntity.getSiglaProvincia()));

				accertamento.setSiglaProv(impiantoEntity.getSiglaProvincia());
				accertamento.setDenomComune(impiantoEntity.getDenominazioneComune());
				accertamento
						.setCodIstatProv(GenericUtil.getCodIstatProvByCodIstatComune(impiantoEntity.getIstatComune()));
				accertamento.setCodIstatCom(impiantoEntity.getIstatComune());
			}

		} else {
			//VIENE RECUPERATA L'ACCERTAMENTO DAL DB
			accertamento = getSigitMgr().getAccertamentoDaId(theModel.getAppDataaccertamento().getIdentificativo(),
					null, null);
		}

		accertamento.setIdVerifica(theModel.getAppDataverifica().getIdentificativo());

		theModel.setAppDataaccertamento(accertamento);
	}

	private ExecResults gestisciAbilRuoloRef(CpGestAccertamentoModel theModel, String codRetRuoloPaProvincia,
			String codRetRuoloPaComune, String codRetAltro) throws ServiceException, BEException, ManagerException {
		ExecResults result = new ExecResults();

		UtenteLoggato utenteLog = theModel.getAppDatautenteLoggato();

		if (log.isDebugEnabled())
			GenericUtil.stampa(utenteLog, true, 2);

		Accertamento acc = theModel.getAppDataaccertamento();

		if (acc == null) {
			acc = new Accertamento();
		}

		String descRuolo = utenteLog.getRuolo().getDescRuolo();

		String istatAbilitazione = utenteLog.getRuolo().getIstatAbilitazione();

		if ((descRuolo.equals(Constants.RUOLO_CONSULTATORE) || descRuolo.equals(Constants.RUOLO_VALIDATORE)
				|| descRuolo.equals(Constants.RUOLO_ISPETTORE)) && istatAbilitazione.length() > 2) {

			ArrayList<CodeDescription> comuni = getSigitMgr().impostaProvinciaSuInserisciAccertamento(acc,
					istatAbilitazione);
			theModel.setAppDataelencoComuniPiemonteIstat(comuni);

			result.setResultCode(codRetRuoloPaProvincia);

			if (istatAbilitazione.length() > 5) {
				getSigitMgr().impostaComuneSuInserisciAccertamento(theModel.getAppDataelencoComuniPiemonteIstat(), acc,
						istatAbilitazione);

				result.setResultCode(codRetRuoloPaComune);
			}

		} else {
			result.setResultCode(codRetAltro);
		}

		theModel.setAppDataaccertamento(acc);

		return result;
	}

	private void gestisciComboDtCatasto(CpGestAccertamentoModel theModel) throws BEException {

		log.debug("[BackEndFacade::gestisciComboDtCatasto] BEGIN");

		try {
			Accertamento acc = theModel.getAppDataaccertamento();
			ArrayList<CodeDescription> comuni = new ArrayList<CodeDescription>();

			if (acc != null) {
				String istatProvincia = acc.getCodIstatProv();

				log.debug("STAMPO idProvSel: " + istatProvincia);

				if (GenericUtil.isNotNullOrEmpty(istatProvincia)) {
					comuni = (ArrayList<CodeDescription>) getServiziMgr()
							.getListaComuniByIstatProvincia(istatProvincia);
				}
			}
			theModel.setAppDataelencoComuniPiemonteIstat(comuni);
		} catch (ServiceException e) {
			//throw new ManagerException(e, new Message(Messages.ERROR_SERVIZIO_NON_RAGGIUNGIBILE));
			throw new BEException("Errore in getComuni della provincia:" + e, e);

		} finally {
			log.debug("[BackEndFacade::gestisciComboDtCatasto] END");

		}
	}

	/*PROTECTED REGION END*/
}
