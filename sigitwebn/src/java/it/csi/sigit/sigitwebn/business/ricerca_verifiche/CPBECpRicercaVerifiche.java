package it.csi.sigit.sigitwebn.business.ricerca_verifiche;

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

/*PROTECTED REGION ID(R-1616336220) ENABLED START*/
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.*;
import it.csi.sigit.sigitwebn.util.*;
import it.csi.sigit.sigitwebn.business.*;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import java.util.stream.Collectors;
import it.csi.sigit.sigitwebn.dto.ricerca_verifiche.CpRicercaVerificheModel;

/*PROTECTED REGION END*/

public class CPBECpRicercaVerifiche {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [ricercaVerifica, scope:USER_SESSION]
	public static final String APPDATA_RICERCAVERIFICA_CODE = "appDataricercaVerifica";

	// ApplicationData: [elencoVerifiche, scope:USER_SESSION]
	public static final String APPDATA_ELENCOVERIFICHE_CODE = "appDataelencoVerifiche";

	// ApplicationData: [idVerificaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDVERIFICASELEZIONATA_CODE = "appDataidVerificaSelezionata";

	// ApplicationData: [elencoTipiVerifica, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPIVERIFICA_CODE = "appDataelencoTipiVerifica";

	// ApplicationData: [elencoSiglaBollini, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLABOLLINI_CODE = "appDataelencoSiglaBollini";

	// ApplicationData: [elencoValidatoriVerifica, scope:USER_SESSION]
	public static final String APPDATA_ELENCOVALIDATORIVERIFICA_CODE = "appDataelencoValidatoriVerifica";

	// ApplicationData: [elencoTipiVerificaInserimentoIspezioniMassive, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPIVERIFICAINSERIMENTOISPEZIONIMASSIVE_CODE = "appDataelencoTipiVerificaInserimentoIspezioniMassive";

	// ApplicationData: [inserimentoIspezioniMassive, scope:SAME_PAGE]
	public static final String APPDATA_INSERIMENTOISPEZIONIMASSIVE_CODE = "appDatainserimentoIspezioniMassive";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicercaVerifiche";

	public static final String MULTIPANEL_MPINSERIMENTOISPEZIONIMASSIVE = "mpInserimentoIspezioniMassive";
	public static final String MPI_MPINSERIMENTOISPEZIONIMASSIVE_FPINSERIMENTOISPEZIONIMASSIVE = CPNAME + "_"
			+ MULTIPANEL_MPINSERIMENTOISPEZIONIMASSIVE + "_" + "fpInserimentoIspezioniMassive";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaVerifiche definito in un ExecCommand del
	 * ContentPanel cpRicercaVerifiche
	 */
	public ExecResults ricercaVerifiche(

			it.csi.sigit.sigitwebn.dto.ricerca_verifiche.CpRicercaVerificheModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAVERIFICHE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAVERIFICHE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1260362985) ENABLED START*/

			try {

				getValidationMgr().validazioneFormaleRicercaVerifiche(theModel.getAppDataricercaVerifica());

				result.setResultCode(RICERCAVERIFICHE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
				result.setResultCode(RICERCAVERIFICHE_OUTCOME_CODE__KO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaVerifiche] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo pulisciCampi definito in un ExecCommand del
	 * ContentPanel cpRicercaVerifiche
	 */
	public ExecResults pulisciCampi(

			it.csi.sigit.sigitwebn.dto.ricerca_verifiche.CpRicercaVerificheModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PULISCICAMPI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-978691578) ENABLED START*/

			//RESET DEL FORM DI RICERCA
			RicercaVerifica nuovaRicerca = new RicercaVerifica();

			theModel.setAppDataricercaVerifica(nuovaRicerca);

			//IMPOSTAZIONE DEI DEFAULT SUL FORM
			resetRicerca(theModel);

			// impostazione del result code 
			result.setResultCode(PULISCICAMPI_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::pulisciCampi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciInserisciVerifica definito in un ExecCommand del
	 * ContentPanel cpRicercaVerifiche
	 */
	public ExecResults gestisciInserisciVerifica(

			it.csi.sigit.sigitwebn.dto.ricerca_verifiche.CpRicercaVerificheModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINSERISCIVERIFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIINSERISCIVERIFICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-699446914) ENABLED START*/
			theModel.setAppDataidVerificaSelezionata(null);
			result.setResultCode(GESTISCIINSERISCIVERIFICA_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciInserisciVerifica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cleanFormInserimentoIspezioniMassive definito in un ExecCommand del
	 * ContentPanel cpRicercaVerifiche
	 */
	public ExecResults cleanFormInserimentoIspezioniMassive(

			it.csi.sigit.sigitwebn.dto.ricerca_verifiche.CpRicercaVerificheModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CLEANFORMINSERIMENTOISPEZIONIMASSIVE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1288105831) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDatainserimentoIspezioniMassive(new InserimentoIspezioniMassive());

			// impostazione del result code 
			result.setResultCode(CLEANFORMINSERIMENTOISPEZIONIMASSIVE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cleanFormInserimentoIspezioniMassive] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo avviaInserimentoIspezioniMassive definito in un ExecCommand del
	 * ContentPanel cpRicercaVerifiche
	 */
	public ExecResults avviaInserimentoIspezioniMassive(

			it.csi.sigit.sigitwebn.dto.ricerca_verifiche.CpRicercaVerificheModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AVVIAINSERIMENTOISPEZIONIMASSIVE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String AVVIAINSERIMENTOISPEZIONIMASSIVE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1187882789) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			InserimentoIspezioniMassive datiInsIspMas = theModel.getAppDatainserimentoIspezioniMassive();

			List<String> valoriConErroriList = new ArrayList<String>();

			try {
				getValidationMgr().verificaDatiInserimentoIspezioniMassive(datiInsIspMas);

				UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

				Integer idTipoVerifica = datiInsIspMas.getIdTipoVerifica();

				boolean isIspezionePagamento = datiInsIspMas.getIsIspezionePagamento();

				String elencoValori = datiInsIspMas.getElencoValori();

				List<String> elencoValoriList = Arrays.asList(elencoValori.split(";"));

				elencoValoriList = elencoValoriList.stream().map(valore -> valore.trim()).collect(Collectors.toList());

				switch (idTipoVerifica) {
					case Constants.ID_TIPO_VERIFICA_IMPIANTO :
						valoriConErroriList = getValidationMgr().verificaCodiciImpianto(elencoValoriList);
						valoriConErroriList.addAll(getSigitMgr().inserimentoIspezioniMassive(elencoValoriList,
								Constants.ID_TIPO_VERIFICA_IMPIANTO, isIspezionePagamento, utenteLoggato));
						break;
					case Constants.ID_TIPO_VERIFICA_DATO_DISTRIBUTORE :
						valoriConErroriList = getValidationMgr().verificaIdDatiDistributore(elencoValoriList);
						valoriConErroriList.addAll(getSigitMgr().inserimentoIspezioniMassive(elencoValoriList,
								Constants.ID_TIPO_VERIFICA_DATO_DISTRIBUTORE, isIspezionePagamento, utenteLoggato));
						break;
					default :
						throw new ManagerException(
								new Message(Messages.ERROR_TIPO_VERIFICA_NON_VALIDO_INSERIMENTO_ISPEZIONI_MASSIVE));
				}

				if (!elencoValoriList.isEmpty()) {
					result.getGlobalMessages().add(Messages.INFO_INSERIMENTO_ISPEZIONI_MASSIVE_AVVENUTO_CORRETTAMENTE);
					result.setResultCode(AVVIAINSERIMENTOISPEZIONIMASSIVE_OUTCOME_CODE__OK);
				} else {
					result.setResultCode(AVVIAINSERIMENTOISPEZIONIMASSIVE_OUTCOME_CODE__KO);
				}

			} catch (ValidationManagerException e) {
				Validator.gestisciEccezione(result, e);
				result.setResultCode(AVVIAINSERIMENTOISPEZIONIMASSIVE_OUTCOME_CODE__KO);
			} catch (ManagerException e) {
				result.getGlobalErrors().add(e.getMessage());
				result.setResultCode(AVVIAINSERIMENTOISPEZIONIMASSIVE_OUTCOME_CODE__KO);
			}

			if (!valoriConErroriList.isEmpty()) {
				String valoriConErrori = valoriConErroriList.stream().reduce("", (subtotal, element) -> {
					if (GenericUtil.isNotNullOrEmpty(subtotal)) {
						subtotal += ", ";
					}
					return subtotal + element;
				});

				result.getGlobalErrors().add(
						Messages.ERROR_VALORI_INSERIMENTO_ISPEZIONI_MASSIVE.replaceFirst("##value##", valoriConErrori));
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::avviaInserimentoIspezioniMassive] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaFormRicerca definito in un ExecCommand del
	 * ContentPanel cpRicercaVerifiche
	 */
	public ExecResults preparaFormRicerca(

			it.csi.sigit.sigitwebn.dto.ricerca_verifiche.CpRicercaVerificheModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAFORMRICERCA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-258659225) ENABLED START*/

			resetRicerca(theModel);

			result.setResultCode(PREPARAFORMRICERCA_OUTCOME_CODE__OK);

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
	 * Implementazione del metodo preparaComboboxTipoVerificaInserimentoIspezioniMassive definito in un ExecCommand del
	 * ContentPanel cpRicercaVerifiche
	 */
	public ExecResults preparaComboboxTipoVerificaInserimentoIspezioniMassive(

			it.csi.sigit.sigitwebn.dto.ricerca_verifiche.CpRicercaVerificheModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARACOMBOBOXTIPOVERIFICAINSERIMENTOISPEZIONIMASSIVE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R271224519) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDataelencoTipiVerificaInserimentoIspezioniMassive(
					getSigitMgr().getTipiVerificaInserimentoIspezioniMassive());
			// impostazione del result code 
			result.setResultCode(PREPARACOMBOBOXTIPOVERIFICAINSERIMENTOISPEZIONIMASSIVE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::preparaComboboxTipoVerificaInserimentoIspezioniMassive] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpRicercaVerifiche
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.ricerca_verifiche.CpRicercaVerificheModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-178426353) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isUtenteAbilitatoRicercaVerificheAccertamentiIspezioniSanzioni(utente)) {
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
	 * Implementazione del metodo gestisciAbilRuoloEnte definito in un ExecCommand del
	 * ContentPanel cpRicercaVerifiche
	 */
	public ExecResults gestisciAbilRuoloEnte(

			it.csi.sigit.sigitwebn.dto.ricerca_verifiche.CpRicercaVerificheModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILRUOLOENTE_OUTCOME_CODE__CONSULTATORE_VALIDATORE_ISPETTORE = //NOSONAR  Reason:EIAS
				"CONSULTATORE_VALIDATORE_ISPETTORE"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOENTE_OUTCOME_CODE__ALTRO = //NOSONAR  Reason:EIAS
				"ALTRO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2101781557) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			result = gestisciAbilRuoloRef(theModel,
					GESTISCIABILRUOLOENTE_OUTCOME_CODE__CONSULTATORE_VALIDATORE_ISPETTORE,
					GESTISCIABILRUOLOENTE_OUTCOME_CODE__ALTRO);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilRuoloEnte] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1508686416) ENABLED START*/
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

	public static boolean isInserimentoVerificaAbilitato(
			it.csi.sigit.sigitwebn.dto.ricerca_verifiche.CpRicercaVerificheModel theModel) {
		UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

		String descrizioneRuolo = utenteLoggato.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)
				|| descrizioneRuolo.equals(Constants.RUOLO_SUPER)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isInserimentoIspezioniMassiveAbilitato(
			it.csi.sigit.sigitwebn.dto.ricerca_verifiche.CpRicercaVerificheModel theModel) {
		UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

		String descrizioneRuolo = utenteLoggato.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE) || descrizioneRuolo.equals(Constants.RUOLO_SUPER)) {
			return true;
		} else {
			return false;
		}
	}

	private ExecResults gestisciAbilRuoloRef(CpRicercaVerificheModel theModel, String codRet, String codRetAltro)
			throws ServiceException, BEException, ManagerException {
		ExecResults result = new ExecResults();

		UtenteLoggato utenteLog = theModel.getAppDatautenteLoggato();

		if (log.isDebugEnabled())
			GenericUtil.stampa(utenteLog, true, 2);

		RicercaVerifica ricVer = theModel.getAppDataricercaVerifica();

		if (ricVer == null) {
			ricVer = new RicercaVerifica();
		}

		String descRuolo = utenteLog.getRuolo().getDescRuolo();

		String istatAbilitazione = utenteLog.getRuolo().getIstatAbilitazione();

		if ((descRuolo.equals(Constants.RUOLO_CONSULTATORE) || descRuolo.equals(Constants.RUOLO_VALIDATORE)
				|| descRuolo.equals(Constants.RUOLO_ISPETTORE)) && istatAbilitazione.length() > 2) {
			result.setResultCode(codRet);
		} else {
			result.setResultCode(codRetAltro);
		}

		theModel.setAppDataricercaVerifica(ricVer);

		return result;
	}

	private void resetRicerca(it.csi.sigit.sigitwebn.dto.ricerca_verifiche.CpRicercaVerificheModel theModel)
			throws ManagerException, ServiceException {

		if (theModel.getAppDataelencoTipiVerifica() == null || theModel.getAppDataelencoTipiVerifica().isEmpty()) {
			//viene popolata la lista dei tipi di verifica
			theModel.setAppDataelencoTipiVerifica(getSigitMgr().getElencoTipoVerifiche());
		}

		theModel.setAppDataelencoValidatoriVerifica(getSigitMgr().getElencoValidatoriIdPf(false));

		//il form di ricerca presenta di default il CF utente caricatore impostato a quello dell'utente collegato
		if (theModel.getAppDataricercaVerifica() == null) {
			theModel.setAppDataricercaVerifica(new RicercaVerifica());

		}

		if (theModel.getAppDataelencoValidatoriVerifica() != null) {
			for (CodeDescription validatore : theModel.getAppDataelencoValidatoriVerifica()) {
				if (validatore.getDescription().contains(theModel.getAppDatautenteLoggato().getCodiceFiscale())) {
					theModel.getAppDataricercaVerifica().setIdValidatore(validatore.getCode());
					break;
				}
			}
		}

		if (theModel.getAppDataelencoSiglaBollini() == null || theModel.getAppDataelencoSiglaBollini().isEmpty()) {
			theModel.setAppDataelencoSiglaBollini(getServiziMgr().getListaSiglaProvincePiemonteManipolata());
		}

	}

	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
