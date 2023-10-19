package it.csi.sigit.sigitwebn.business.ricerca_allegati_module;

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

/*PROTECTED REGION ID(R-1279335570) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
/*PROTECTED REGION END*/

public class CPBECpRicercaAllegati {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [elencoStatiAllegato, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATIALLEGATO_CODE = "appDataelencoStatiAllegato";

	// ApplicationData: [elencoTipiDocumento, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPIDOCUMENTO_CODE = "appDataelencoTipiDocumento";

	// ApplicationData: [ricercaAllegati, scope:USER_SESSION]
	public static final String APPDATA_RICERCAALLEGATI_CODE = "appDataricercaAllegati";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [elencoSigleBollino, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLEBOLLINO_CODE = "appDataelencoSigleBollino";

	// ApplicationData: [elencoSigleRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLEREA_CODE = "appDataelencoSigleRea";

	// ApplicationData: [aggiornaElencoAllegati, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOALLEGATI_CODE = "appDataaggiornaElencoAllegati";

	// ApplicationData: [elencoAllegati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALLEGATI_CODE = "appDataelencoAllegati";

	// ApplicationData: [elencoSiNo, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSINO_CODE = "appDataelencoSiNo";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicercaAllegati";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eseguiRicercaAllegati definito in un ExecCommand del
	 * ContentPanel cpRicercaAllegati
	 */
	public ExecResults eseguiRicercaAllegati(

			it.csi.sigit.sigitwebn.dto.ricerca_allegati_module.CpRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ESEGUIRICERCAALLEGATI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ESEGUIRICERCAALLEGATI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1698112059) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("FRAAAAAAAAAAAA ---> ESEGUI RICERCA ALLEGATI");
			try {
				RicercaAllegati ricercaAllegati = theModel.getAppDataricercaAllegati();

				UtenteLoggato utente = theModel.getAppDatautenteLoggato();
				String descrizioneRuolo = utente.getRuolo().getDescRuolo();

				if (descrizioneRuolo.equals(Constants.RUOLO_IMPRESA)) {

					ricercaAllegati.setCodiceFiscale(ReplaceSpecialCharUtils.sanitize(utente.getRuolo().getCodiceFiscale()));
					ricercaAllegati.setIdReaSigla(ReplaceSpecialCharUtils.sanitize(utente.getRuolo().getSiglaRea()));
					ricercaAllegati
							.setNumeroRea(ConvertUtil.convertToUDTPositiveInteger(utente.getRuolo().getNumeroRea()));

					theModel.setAppDataricercaAllegati(ricercaAllegati);
				}

				//Fa i controlli di validazione della pagina
				getValidationMgr().validazioneFormaleRicercaAlleagti(ricercaAllegati);

				//imposto i criteri di ricerca
				ArrayList<String> listaCodiciImpianti = null;

				//imposto il filtro per la ricerca dei codici impianti
				FiltroRicercaCodiciImpianto filtro = new FiltroRicercaCodiciImpianto();
				filtro.setDescrizioneRuoloFunzionale(ReplaceSpecialCharUtils.sanitize(descrizioneRuolo));
				filtro.setCodiceFiscaleUtenteLoggato(ReplaceSpecialCharUtils.sanitize(utente.getCodiceFiscale()));
				filtro.setCodiceFiscalePersonaGiuridica(ReplaceSpecialCharUtils.sanitize(utente.getRuolo().getCodiceFiscale()));

				// se PG setto anche SiglaRea e CodiceRea
				if (GenericUtil.isNotNullOrEmpty(utente.getRuolo().getSiglaRea())
						&& GenericUtil.isNotNullOrEmpty(utente.getRuolo().getNumeroRea())) {
					filtro.setSiglaRea(ReplaceSpecialCharUtils.sanitize(utente.getRuolo().getSiglaRea()));
					filtro.setNumeroRea(ConvertUtil.convertToUDTPositiveInteger(utente.getRuolo().getNumeroRea()));
				}

				log.debug(" FRAAAA CODICE FISCALE UTENTE LOGGATO: " + utente.getCodiceFiscale());
				log.debug(" FRAAAA DENOMINAZIONE UTENTE LOGGATO: " + utente.getDenominazione());
				log.debug(" FRAAAA RUOLO CODICE FISCALE: " + utente.getRuolo().getCodiceFiscale());
				log.debug(" FRAAAA RUOLO CODICE REA: " + utente.getRuolo().getCodiceRea());
				log.debug(" FRAAAA RUOLO DATA CESSAZIONE: " + utente.getRuolo().getDataCessazione());
				log.debug(" FRAAAA RUOLO DENOMINAZIONE DITTA: " + utente.getRuolo().getDenomDitta());
				log.debug(" FRAAAA RUOLO DESCRIZIONE RUOLO: " + utente.getRuolo().getDescRuolo());
				log.debug(" FRAAAA RUOLO SIGLA REA: " + utente.getRuolo().getSiglaRea());
				log.debug(" FRAAAA RUOLO ID PERSONA GIURIDICA: " + utente.getRuolo().getIdPersonaGiuridica());
				log.debug(
						" FRAAAA RUOLO ID RUOLO DA NON PRENDERE IN CONSIDERAZIONE: " + utente.getRuolo().getIdRuolo());
				log.debug(" FRAAAA RUOLO NUMERO REA: " + utente.getRuolo().getNumeroRea());

				if (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)
						|| descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO_IMPRESA)
						|| descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE)
						|| descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO)
						|| descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_3RESPONSABILE)) {

					//devo cercare la lista dei codici impianti da considerare nella ricerca degli allegati sulla vista_ricerca_allegati
					listaCodiciImpianti = this.getSigitMgr().cercaCodiciImpiantoPersFisicaGiuridica(filtro);

					if ((listaCodiciImpianti != null && !listaCodiciImpianti.isEmpty())
							&& (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO_IMPRESA)
									|| descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO))) {
						listaCodiciImpianti = getSigitMgr()
								.filtraCodiciImpiantoVisibiliDaProprietario(listaCodiciImpianti);
					}

					ricercaAllegati.setElencoCodiciImpianto(listaCodiciImpianti);
				}

				if ((listaCodiciImpianti == null || listaCodiciImpianti.isEmpty())
						&& (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)
								|| descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO_IMPRESA)
								|| descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE)
								|| descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO)
								|| descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_3RESPONSABILE))) {
					log.debug("Nessun impianto per il responsabile");
				} else {
					//					Integer count = getSigitMgr().cercaElencoAllegatiCount(
					//							ricercaAllegati, descrRuoloUtente);
					//
					//					log.debug("FRAAAAAAAAAAA NUMERO DI ALLEGATI TROVATI: "
					//							+ count);
				}
				//indico che quando entro nel metodo di inalizzazione dell'elenco devo ricaricarlo
				theModel.setAppDataaggiornaElencoAllegati(true);

				// impostazione del result code 
				result.setResultCode(ESEGUIRICERCAALLEGATI_OUTCOME_CODE__OK);

				// modifica degli attributi del model (che verranno propagati allo strato
				// di presentation). si puo' agire anche direttamente sull'attributo "session".
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

				result.setResultCode(ESEGUIRICERCAALLEGATI_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eseguiRicercaAllegati] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaRicercaAllegati definito in un ExecCommand del
	 * ContentPanel cpRicercaAllegati
	 */
	public ExecResults annullaRicercaAllegati(

			it.csi.sigit.sigitwebn.dto.ricerca_allegati_module.CpRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLARICERCAALLEGATI_OUTCOME_CODE__MANUTENTORE = //NOSONAR  Reason:EIAS
				"MANUTENTORE"; //NOSONAR  Reason:EIAS
		final String ANNULLARICERCAALLEGATI_OUTCOME_CODE__NOMANUTENTORE = //NOSONAR  Reason:EIAS
				"NOMANUTENTORE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1370146128) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();
			String descrRuoloUtente = utente.getRuolo().getDescRuolo();
			//devo ripulire la pagina dei dati inseriti dall'utente, solo quelli modificabili
			RicercaAllegati ricercaAllegati = theModel.getAppDataricercaAllegati();

			ricercaAllegati.setDataControlloA("");
			ricercaAllegati.setDataControlloDa("");
			ricercaAllegati.setIdBollinoSigla("");
			ricercaAllegati.setIdStatoAllegato(null);
			ricercaAllegati.setIdTipoDocumento(null);
			ricercaAllegati.setSicurezzaImpianti(null);

			ricercaAllegati.setConOsservazioni(null);
			ricercaAllegati.setConRaccomandazioni(null);
			ricercaAllegati.setConPrescrizioni(null);

			ricercaAllegati.setInterventoA("");
			ricercaAllegati.setInterventoDa("");
			ricercaAllegati.setNumeroBollino(null);

			if (descrRuoloUtente.equals(Constants.RUOLO_IMPRESA)) {

				// impostazione del result code 
				result.setResultCode(ANNULLARICERCAALLEGATI_OUTCOME_CODE__MANUTENTORE);
			} else {

				ricercaAllegati.setCodiceFiscale("");
				ricercaAllegati.setIdReaSigla("");
				ricercaAllegati.setNumeroRea(null);
				// impostazione del result code 
				result.setResultCode(ANNULLARICERCAALLEGATI_OUTCOME_CODE__NOMANUTENTORE);
			}

			theModel.setAppDataricercaAllegati(ricercaAllegati);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaRicercaAllegati] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpRicercaAllegati
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.ricerca_allegati_module.CpRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1479100421) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoRicercaAllegati(utente)) {
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
	 * Implementazione del metodo precaricaDatiProfiloAllegatiEnt definito in un ExecCommand del
	 * ContentPanel cpRicercaAllegati
	 */
	public ExecResults precaricaDatiProfiloAllegatiEnt(

			it.csi.sigit.sigitwebn.dto.ricerca_allegati_module.CpRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PRECARICADATIPROFILOALLEGATIENT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PRECARICADATIPROFILOALLEGATIENT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1711428098) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result = precaricaDatiProfiloAllegati(theModel, PRECARICADATIPROFILOALLEGATIENT_OUTCOME_CODE__OK,
					PRECARICADATIPROFILOALLEGATIENT_OUTCOME_CODE__KO);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::precaricaDatiProfiloAllegatiEnt] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo precaricaDatiProfiloAllegatiRef definito in un ExecCommand del
	 * ContentPanel cpRicercaAllegati
	 */
	public ExecResults precaricaDatiProfiloAllegatiRef(

			it.csi.sigit.sigitwebn.dto.ricerca_allegati_module.CpRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PRECARICADATIPROFILOALLEGATIREF_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PRECARICADATIPROFILOALLEGATIREF_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-328136874) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result = precaricaDatiProfiloAllegati(theModel, PRECARICADATIPROFILOALLEGATIREF_OUTCOME_CODE__OK,
					PRECARICADATIPROFILOALLEGATIREF_OUTCOME_CODE__KO);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::precaricaDatiProfiloAllegatiRef] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R71987904) ENABLED START*/
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

	private void precaricaComboAllegati(
			it.csi.sigit.sigitwebn.dto.ricerca_allegati_module.CpRicercaAllegatiModel theModel) throws BEException {

		try {
			theModel.setAppDataelencoSigleBollino(getServiziMgr().getListaSiglaProvincePiemonteManipolata());

			theModel.setAppDataelencoSigleRea(getSigitMgr().getListaSigleRea());

			theModel.setAppDataelencoSiNo(GenericUtil.getComboSiNo());

			theModel.setAppDataelencoStatiAllegato(getDbMgr().cercaListaStatiAllegato());

			theModel.setAppDataelencoTipiDocumento(getDbMgr().cercaListaTipoAllegati());

		} catch (ServiceException e) {
			throw new BEException("Errore in CpRicercaAllegati per il metodo  precaricaComboAllegati:" + e, e);
		} catch (ManagerException e) {
			throw new BEException("Errore in CpRicercaAllegati per il metodo  precaricaComboAllegati:" + e, e);
		}

	}

	private ExecResults precaricaDatiProfiloAllegati(

			it.csi.sigit.sigitwebn.dto.ricerca_allegati_module.CpRicercaAllegatiModel theModel, String codAbilita,
			String codDisabilita) throws BEException {

		ExecResults result = new ExecResults();

		UtenteLoggato utente = theModel.getAppDatautenteLoggato();

		log.debug(" PRECARICA DATI PROFILO ALLEGATI");
		String descrizioneRuolo = utente.getRuolo().getDescRuolo();
		log.debug(" FRAAAAAAAAAAAAA ---> descrizioneRuolo: " + descrizioneRuolo);

		RicercaAllegati ricercaAllegati = theModel.getAppDataricercaAllegati();
		if (ricercaAllegati == null) {
			ricercaAllegati = new RicercaAllegati();
		}

		this.precaricaComboAllegati(theModel);

		if (descrizioneRuolo.equals(Constants.RUOLO_IMPRESA)) {

			ricercaAllegati.setCodiceFiscale(utente.getRuolo().getCodiceFiscale());
			ricercaAllegati.setIdReaSigla(utente.getRuolo().getSiglaRea());
			ricercaAllegati.setNumeroRea(ConvertUtil.convertToUDTPositiveInteger(utente.getRuolo().getNumeroRea()));

			theModel.setAppDataricercaAllegati(ricercaAllegati);
			result.setResultCode(codAbilita);
		} else {
			result.setResultCode(codDisabilita);
		}

		// impostazione del result code 

		// modifica degli attributi del model (che verranno propagati allo strato
		// di presentation). si puo' agire anche direttamente sull'attributo "session".

		result.setModel(theModel);
		return result;

	}

	/*PROTECTED REGION END*/
}
