package it.csi.sigit.sigitwebn.business.gestisci_sanzioni;

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

/*PROTECTED REGION ID(R-1180772737) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaPersonaGiuridicaFisicaFilter;
/*PROTECTED REGION END*/

public class CPBECpInserisciNotificaSanzione {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [datiInserimentoSanzione, scope:USER_SESSION]
	public static final String APPDATA_DATIINSERIMENTOSANZIONE_CODE = "appDatadatiInserimentoSanzione";

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

	// ApplicationData: [elencoIndirizziSanzionato, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINDIRIZZISANZIONATO_CODE = "appDataelencoIndirizziSanzionato";

	// ApplicationData: [idSanzioneSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDSANZIONESELEZIONATA_CODE = "appDataidSanzioneSelezionata";

	// ApplicationData: [idSanzionatoScelto, scope:USER_SESSION]
	public static final String APPDATA_IDSANZIONATOSCELTO_CODE = "appDataidSanzionatoScelto";

	// ApplicationData: [elencoCandidatiSanzionati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCANDIDATISANZIONATI_CODE = "appDataelencoCandidatiSanzionati";

	// ApplicationData: [paginaChiamanteDettaglioSanzione, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEDETTAGLIOSANZIONE_CODE = "appDatapaginaChiamanteDettaglioSanzione";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpInserisciNotificaSanzione";

	public static final String MULTIPANEL_MPSANZIONATI = "mpSanzionati";
	public static final String MPI_MPSANZIONATI_FPSANZIONATO = CPNAME + "_" + MULTIPANEL_MPSANZIONATI + "_"
			+ "fpSanzionato";
	public static final String MPI_MPSANZIONATI_FPELENCOSANZIONATI = CPNAME + "_" + MULTIPANEL_MPSANZIONATI + "_"
			+ "fpElencoSanzionati";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaIsImpresa definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults gestLogicaIsImpresa(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAISIMPRESA_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAISIMPRESA_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-159427557) ENABLED START*/
			//in base alla selezione del flag bisogna svuotare o meno i campi di persona giuridica
			DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

			if (sanzione.getFlgEnteImpresa()) {

				sanzione.setNome(null);
				result.setResultCode(GESTLOGICAISIMPRESA_OUTCOME_CODE__SI);
			} else {
				result.setResultCode(GESTLOGICAISIMPRESA_OUTCOME_CODE__NO);
			}

			theModel.setAppDatadatiInserimentoSanzione(sanzione);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaIsImpresa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaPersonaSanzionataDaCF definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults cercaPersonaSanzionataDaCF(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAPERSONASANZIONATADACF_OUTCOME_CODE__OK_SINGOLO = //NOSONAR  Reason:EIAS
				"OK_SINGOLO"; //NOSONAR  Reason:EIAS
		final String CERCAPERSONASANZIONATADACF_OUTCOME_CODE__OK_MULTIPLO = //NOSONAR  Reason:EIAS
				"OK_MULTIPLO"; //NOSONAR  Reason:EIAS
		final String CERCAPERSONASANZIONATADACF_OUTCOME_CODE__OK_NO_RESULT = //NOSONAR  Reason:EIAS
				"OK_NO_RESULT"; //NOSONAR  Reason:EIAS
		final String CERCAPERSONASANZIONATADACF_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1146020354) ENABLED START*/
			try {
				DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();
				getValidationMgr().verificaRicercaSanzionata(theModel.getAppDatadatiInserimentoSanzione());

				if (!sanzione.getFlgEnteImpresa()) {
					ArrayList<PersonaFisica> canditatiSanzionabiliFisici = (ArrayList<PersonaFisica>) getDbMgr()
							.cercaPersonaFisicaByFilter(
									RicercaPersonaGiuridicaFisicaFilter.costruisciDaFormSanzione(sanzione));

					if (canditatiSanzionabiliFisici != null) {
						if (canditatiSanzionabiliFisici.size() == 1) {
							result.setResultCode(CERCAPERSONASANZIONATADACF_OUTCOME_CODE__OK_SINGOLO);
							//un unico candidato selezionabile. il form con le informazioni del sanzionato viene quindi pre-compilato con i dati trovati
							PersonaFisica unicoCandidato = canditatiSanzionabiliFisici.get(0);
							settaInfoSanzionatoFisico(theModel, unicoCandidato);

						} else if (canditatiSanzionabiliFisici.size() > 0) {
							//viene costruita la lista dei candidati
							ArrayList<CandidatoSanzionato> listaCandidatiPerTabella = new ArrayList<CandidatoSanzionato>();
							for (PersonaFisica candidatoCorrente : canditatiSanzionabiliFisici) {
								CandidatoSanzionato candidato = new CandidatoSanzionato();
								candidato.setId(ConvertUtil.convertToString(candidatoCorrente.getIdPersonaFisica()));
								candidato.setCodiceFiscale(candidatoCorrente.getCodiceFiscale());
								candidato.setDenomCompleta(candidatoCorrente.getDenominazione());
								candidato.setDsIndirizzoCompleto(MapDto.getIndirizzo(
										candidatoCorrente.getFlgIndirizzoEst()
												? candidatoCorrente.getEstIndirizzo()
												: candidatoCorrente.getIndirizzo(),
										candidatoCorrente.getIndirizzoNonTrovato(), candidatoCorrente.getCivico()));
								candidato.setDescComuneProv(MapDto.getComuneProvincia(
										candidatoCorrente.getFlgIndirizzoEst()
												? candidatoCorrente.getEstCitta()
												: candidatoCorrente.getComune(),
										candidatoCorrente.getFlgIndirizzoEst()
												? candidatoCorrente.getEstStato()
												: candidatoCorrente.getProvincia()));
								listaCandidatiPerTabella.add(candidato);

							}

							theModel.setAppDataelencoCandidatiSanzionati(listaCandidatiPerTabella);

							result.setResultCode(CERCAPERSONASANZIONATADACF_OUTCOME_CODE__OK_MULTIPLO);
						} else {
							result.setResultCode(CERCAPERSONASANZIONATADACF_OUTCOME_CODE__OK_SINGOLO);
						}

					}
				} else {

					ArrayList<PersonaGiuridica> canditatiSanzionabiliGiuridici = (ArrayList<PersonaGiuridica>) getDbMgr()
							.cercaPersonaGiuridicaByFilter(
									RicercaPersonaGiuridicaFisicaFilter.costruisciDaFormSanzione(sanzione));

					if (canditatiSanzionabiliGiuridici != null) {
						if (canditatiSanzionabiliGiuridici.size() == 1) {
							result.setResultCode(CERCAPERSONASANZIONATADACF_OUTCOME_CODE__OK_SINGOLO);
							//un unico candidato selezionabile. il form con le informazioni del sanzionato viene quindi pre-compilato con i dati trovati
							PersonaGiuridica unicoCandidato = canditatiSanzionabiliGiuridici.get(0);
							settaInfoSanzionatoGiuridico(theModel, unicoCandidato);

						} else if (canditatiSanzionabiliGiuridici.size() > 0) {
							//viene costruita la lista dei candidati
							ArrayList<CandidatoSanzionato> listaCandidatiPerTabella = new ArrayList<CandidatoSanzionato>();
							for (PersonaGiuridica candidatoCorrente : canditatiSanzionabiliGiuridici) {
								CandidatoSanzionato candidato = new CandidatoSanzionato();
								candidato.setId(ConvertUtil.convertToString(candidatoCorrente.getIdPersonaGiuridica()));
								candidato.setCodiceFiscale(candidatoCorrente.getCodiceFiscale());
								candidato.setDenomCompleta(candidatoCorrente.getDenominazione());
								candidato.setDsIndirizzoCompleto(MapDto.getIndirizzo(
										candidatoCorrente.getFlgIndirizzoEst()
												? candidatoCorrente.getEstIndirizzo()
												: candidatoCorrente.getIndirizzo(),
										candidatoCorrente.getIndirizzoNonTrovato(), candidatoCorrente.getCivico()));
								candidato.setDescComuneProv(MapDto.getComuneProvincia(
										candidatoCorrente.getFlgIndirizzoEst()
												? candidatoCorrente.getEstCitta()
												: candidatoCorrente.getComune(),
										candidatoCorrente.getFlgIndirizzoEst()
												? candidatoCorrente.getEstStato()
												: candidatoCorrente.getProvincia()));
								listaCandidatiPerTabella.add(candidato);

							}

							theModel.setAppDataelencoCandidatiSanzionati(listaCandidatiPerTabella);
							result.setResultCode(CERCAPERSONASANZIONATADACF_OUTCOME_CODE__OK_MULTIPLO);

						} else {
							result.setResultCode(CERCAPERSONASANZIONATADACF_OUTCOME_CODE__OK_NO_RESULT);
							result.getGlobalMessages()
									.add("Attenzione: soggetto non trovato. Procedere con l'inserimento");
						}
					}

				}

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaPersonaSanzionataDaCF] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaPersonaSanzionata definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults nuovaRicercaPersonaSanzionata(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAPERSONASANZIONATA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCAPERSONASANZIONATA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1068479380) ENABLED START*/

			//vengono resettate tutte le possibili info recuperate sul soggetto sanzionato
			DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

			sanzione.setCodiceFiscale(null);
			sanzione.setDenominazione(null);
			sanzione.setNome(null);
			theModel.setAppDataelencoCandidatiSanzionati(null);
			theModel.setAppDataidSanzionatoScelto(null);

			svuotaIndirizzo(theModel, false);

			theModel.setAppDataelencoIndirizziSanzionato(new ArrayList<CodeDescription>());

			// impostazione del result code 
			result.setResultCode(NUOVARICERCAPERSONASANZIONATA_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaPersonaSanzionata] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestTipoIndirizzo definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults gestTipoIndirizzo(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTTIPOINDIRIZZO_OUTCOME_CODE__NAZIONALE = //NOSONAR  Reason:EIAS
				"NAZIONALE"; //NOSONAR  Reason:EIAS
		final String GESTTIPOINDIRIZZO_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1047437057) ENABLED START*/
			DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

			svuotaIndirizzo(theModel, sanzione.getFlgIndirizzoEstero());

			if (sanzione.getFlgIndirizzoEstero()) {
				result.setResultCode(GESTTIPOINDIRIZZO_OUTCOME_CODE__ESTERO);
			} else {
				result.setResultCode(GESTTIPOINDIRIZZO_OUTCOME_CODE__NAZIONALE);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestTipoIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestIndirizzoConf definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults gestIndirizzoConf(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINDIRIZZOCONF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTINDIRIZZOCONF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-502105879) ENABLED START*/
			DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

			if (GenericUtil.isNotNullOrEmpty(sanzione.getIdIndirizzo())
					|| GenericUtil.isNotNullOrEmpty(sanzione.getIndirizzoNoStradario())) {
				result.setResultCode(GESTINDIRIZZOCONF_OUTCOME_CODE__SI);
			} else {
				result.setResultCode(GESTINDIRIZZOCONF_OUTCOME_CODE__NO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestIndirizzoConf] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadComuni definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults loadComuni(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1159341273) ENABLED START*/

			DatiInserimentoSanzione datiInserimento = theModel.getAppDatadatiInserimentoSanzione();

			ArrayList<CodeDescription> comuniLoc = recuperaComuni(datiInserimento.getIdProvincia());

			theModel.setAppDataelencoComuni(comuniLoc);

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
	 * Implementazione del metodo cercaIndirizzo definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults cercaIndirizzo(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAINDIRIZZO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAINDIRIZZO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-189402628) ENABLED START*/
			try {
				DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

				getValidationMgr().verificaRicercaIndirizzoSanzionato(sanzione);

				theModel.setAppDataelencoIndirizziSanzionato(
						getServiziMgr().getListaVieValide(sanzione.getIndirizzo(), sanzione.getIdComune()));

				result.setResultCode(CERCAINDIRIZZO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaIndirizzo definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults nuovaRicercaIndirizzo(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAINDIRIZZO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCAINDIRIZZO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R488091346) ENABLED START*/

			//viene svuotato l'indirizzo
			svuotaIndirizzo(theModel, false);

			theModel.setAppDataelencoIndirizziSanzionato(new ArrayList<CodeDescription>());

			result.setResultCode(NUOVARICERCAINDIRIZZO_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaSceltaSanzionato definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults annullaSceltaSanzionato(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLASCELTASANZIONATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ANNULLASCELTASANZIONATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R504457565) ENABLED START*/

			//il click su questo pulsante pulisce l'intera lista dei possibili candidati trovati
			//ed eventuali selezioni fatte

			theModel.setAppDataelencoCandidatiSanzionati(null);
			theModel.setAppDataidSanzionatoScelto(null);

			// impostazione del result code 
			result.setResultCode(ANNULLASCELTASANZIONATO_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaSceltaSanzionato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo confermaSceltaSanzionato definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults confermaSceltaSanzionato(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CONFERMASCELTASANZIONATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CONFERMASCELTASANZIONATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1079666949) ENABLED START*/

			//prima si verifica se di fatto un soggetto e' stato scelto
			try {

				getValidationMgr().checkSelezioneElemento(theModel.getAppDataidSanzionatoScelto());

				DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

				//in base alla scelta fatta sul flg impresa viene caricato riversato il dato nella sanzione
				if (sanzione.getFlgEnteImpresa()) {
					//il candidato selezionato proviene da una persona giuridica
					PersonaGiuridica giuridico = getDbMgr()
							.cercaPersonaGiuridicaById(theModel.getAppDataidSanzionatoScelto());

					settaInfoSanzionatoGiuridico(theModel, giuridico);
				} else {
					PersonaFisica fisico = getDbMgr().cercaPersonaFisicaById(theModel.getAppDataidSanzionatoScelto());

					settaInfoSanzionatoFisico(theModel, fisico);
				}

				// impostazione del result code 
				result.setResultCode(CONFERMASCELTASANZIONATO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::confermaSceltaSanzionato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazioneEnteImpresa2 definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults gestisciAbilitazioneEnteImpresa2(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONEENTEIMPRESA2_OUTCOME_CODE__FISICA = //NOSONAR  Reason:EIAS
				"FISICA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONEENTEIMPRESA2_OUTCOME_CODE__GIURIDICA = //NOSONAR  Reason:EIAS
				"GIURIDICA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-53938967) ENABLED START*/

			DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

			if (sanzione.getFlgEnteImpresa()) {
				result.setResultCode(GESTISCIABILITAZIONEENTEIMPRESA2_OUTCOME_CODE__GIURIDICA);
			} else {
				result.setResultCode(GESTISCIABILITAZIONEENTEIMPRESA2_OUTCOME_CODE__FISICA);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciAbilitazioneEnteImpresa2] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazioneIndirizzo2 definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults gestisciAbilitazioneIndirizzo2(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONEINDIRIZZO2_OUTCOME_CODE__INDIRIZZO_SI = //NOSONAR  Reason:EIAS
				"INDIRIZZO_SI"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONEINDIRIZZO2_OUTCOME_CODE__INDIRIZZO_NO = //NOSONAR  Reason:EIAS
				"INDIRIZZO_NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1014625732) ENABLED START*/
			DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

			if (GenericUtil.isNullOrEmpty(sanzione.getIdIndirizzo())
					&& GenericUtil.isNullOrEmpty(sanzione.getIndirizzoEstero())
					&& GenericUtil.isNullOrEmpty(sanzione.getIndirizzoNoStradario())) {
				result.setResultCode(GESTISCIABILITAZIONEINDIRIZZO2_OUTCOME_CODE__INDIRIZZO_NO);
			} else {
				result.setResultCode(GESTISCIABILITAZIONEINDIRIZZO2_OUTCOME_CODE__INDIRIZZO_SI);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilitazioneIndirizzo2] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazioneIndirizzoEsteroLocale2 definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults gestisciAbilitazioneIndirizzoEsteroLocale2(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONEINDIRIZZOESTEROLOCALE2_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONEINDIRIZZOESTEROLOCALE2_OUTCOME_CODE__LOCALE = //NOSONAR  Reason:EIAS
				"LOCALE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-490415622) ENABLED START*/
			DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

			if (!GenericUtil.isNullOrEmpty(sanzione.getIdIndirizzo())
					|| !GenericUtil.isNullOrEmpty(sanzione.getIndirizzoNoStradario())) {
				result.setResultCode(GESTISCIABILITAZIONEINDIRIZZOESTEROLOCALE2_OUTCOME_CODE__LOCALE);
			} else {
				result.setResultCode(GESTISCIABILITAZIONEINDIRIZZOESTEROLOCALE2_OUTCOME_CODE__ESTERO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciAbilitazioneIndirizzoEsteroLocale2] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaSanzione definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults salvaSanzione(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVASANZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVASANZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1792683492) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {

				DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

				getValidationMgr().validazioneFormaleInserimentoSanzione(sanzione);

				ArrayList<CodeDescription> elencoComuni = theModel.getAppDataelencoComuni();
				ArrayList<CodeDescription> elencoProvince = theModel.getAppDataelencoProvince();
				ArrayList<CodeDescription> elencoIndirizzi = theModel.getAppDataelencoIndirizziSanzionato();

				if (elencoComuni != null && !elencoComuni.isEmpty()) {
					String descComune = GenericUtil.getDescriptionByCod(sanzione.getIdComune(), elencoComuni);
					sanzione.setDescComune(ReplaceSpecialCharUtils.sanitize(descComune));
				}

				if (elencoProvince != null && !elencoProvince.isEmpty()) {
					String descProvincia = GenericUtil.getDescriptionByCod(sanzione.getIdProvincia(), elencoProvince);
					sanzione.setDescProvincia(ReplaceSpecialCharUtils.sanitize(descProvincia));
				}

				if (elencoIndirizzi != null && !elencoIndirizzi.isEmpty()) {
					String descIndirizzoSitad = GenericUtil.getDescriptionByCod(sanzione.getIdIndirizzo(),
							elencoIndirizzi);

					sanzione.setDescIndirizzo(ReplaceSpecialCharUtils.sanitize(descIndirizzoSitad));
				}

				if (sanzione.getIdSanzione() == null) {
					Integer idSanzione = getSigitMgr().inserisciSanzioneTrans(sanzione,
							theModel.getAppDatautenteLoggato());
					sanzione.setIdSanzione(idSanzione);

					theModel.setAppDataidSanzioneSelezionata(idSanzione);
				} else {
					//trattandosi di salvataggio in update si tratta di notifica
					getSigitMgr().notificaSanzioneTrans(sanzione, theModel.getAppDatautenteLoggato());
				}

				result.setResultCode(SALVASANZIONE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaSanzione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietroInserisciSanzione definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults gestisciIndietroInserisciSanzione(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETROINSERISCISANZIONE_OUTCOME_CODE__ACCERTAMENTO = //NOSONAR  Reason:EIAS
				"ACCERTAMENTO"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETROINSERISCISANZIONE_OUTCOME_CODE__ISPEZIONE = //NOSONAR  Reason:EIAS
				"ISPEZIONE"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETROINSERISCISANZIONE_OUTCOME_CODE__DETTAGLIO = //NOSONAR  Reason:EIAS
				"DETTAGLIO"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETROINSERISCISANZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1559715615) ENABLED START*/

			//in base a quanto specificato
			//da questa pagina si potrebbe tornare indietro alla pagina 
			//-dell'accertamento (con il click sull'avvia sanzione)
			//-dell'ispezione	 (con il click sull'avvia sanzione)
			//-se c'e' l'id della sanzione si arriva dal dettaglio

			DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

			if (sanzione.getIdSanzione() == null || sanzione.getIdSanzione() == 0) {
				//si tratta di inserimento. si distingue sulla base della chiave esterna
				if (GenericUtil.isNotNullOrEmpty(sanzione.getAccertamentoAssociato())
						&& !Constants.DATO_NON_DISPONIBILE_S.equals(sanzione.getAccertamentoAssociato())) {
					result.setResultCode(GESTISCIINDIETROINSERISCISANZIONE_OUTCOME_CODE__ACCERTAMENTO);
				}

				if (GenericUtil.isNotNullOrEmpty(sanzione.getIspezioneAssociata())
						&& !Constants.DATO_NON_DISPONIBILE_S.equals(sanzione.getIspezioneAssociata())) {
					result.setResultCode(GESTISCIINDIETROINSERISCISANZIONE_OUTCOME_CODE__ISPEZIONE);
				}
			} else {
				result.setResultCode(GESTISCIINDIETROINSERISCISANZIONE_OUTCOME_CODE__DETTAGLIO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciIndietroInserisciSanzione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1756672212) ENABLED START*/
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
	 * Implementazione del metodo inizializzaScheda definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults inizializzaScheda(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZASCHEDA_OUTCOME_CODE__OK_INSERIMENTO = //NOSONAR  Reason:EIAS
				"OK_INSERIMENTO"; //NOSONAR  Reason:EIAS
		final String INIZIALIZZASCHEDA_OUTCOME_CODE__OK_MODIFICA = //NOSONAR  Reason:EIAS
				"OK_MODIFICA"; //NOSONAR  Reason:EIAS
		final String INIZIALIZZASCHEDA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String INIZIALIZZASCHEDA_OUTCOME_CODE__OK_MODIFICA_OLD = //NOSONAR  Reason:EIAS
				"OK_MODIFICA_OLD"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-186174852) ENABLED START*/

			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

			theModel.setAppDataelencoProvince(getServiziMgr().getListaProvincePrimaPiemonte());

			// inserire qui la logica applicativa da eseguire:
			DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

			if (sanzione == null || sanzione.getIdSanzione() == null || sanzione.getIdSanzione() == 0) {
				//inserimento
				sanzione.setIdProvincia(theModel.getAppDataelencoProvince().get(0).getCode());

				if (GenericUtil.isNotNullOrEmpty(sanzione.getAccertamentoAssociato())
						&& !Constants.DATO_NON_DISPONIBILE_S.equals(sanzione.getAccertamentoAssociato())) {
					theModel.setAppDatapaginaChiamanteDettaglioSanzione("ACCERTAMENTO");
				}

				if (GenericUtil.isNotNullOrEmpty(sanzione.getIspezioneAssociata())
						&& !Constants.DATO_NON_DISPONIBILE_S.equals(sanzione.getIspezioneAssociata())) {
					theModel.setAppDatapaginaChiamanteDettaglioSanzione("ISPEZIONE");
				}

				// Nel caso in cui il RUOLO sia VALIDATORE o ISPETTORE, bisogna impostare il responsabile PA con l'utente loggato
				if (GenericUtil.checkValidRole(utenteLoggato,
						Arrays.asList(Constants.RUOLO_VALIDATORE, Constants.RUOLO_ISPETTORE), true, true)) {
					sanzione.setResponsabilePA(ConvertUtil.getStringByConcat(" ", utenteLoggato.getDenominazione(),
							utenteLoggato.getCodiceFiscale()));
					sanzione.setCodFisRespPA(utenteLoggato.getCodiceFiscale());
					sanzione.setDenomRespPA(utenteLoggato.getDenominazione());
				}

				result.setResultCode(INIZIALIZZASCHEDA_OUTCOME_CODE__OK_INSERIMENTO);

			} else {
				//notifica
				//viene ricercata la sanzione in input
				sanzione = getSigitMgr().getSanzionePerNotificaDaId(sanzione.getIdSanzione());

				if (GenericUtil.isNotNullOrEmpty(sanzione.getIdIndirizzo())) {
					theModel.setAppDataelencoIndirizziSanzionato(
							getServiziMgr().getListaVieValide(sanzione.getIndirizzo(), sanzione.getIdComune()));
				}

				result.setResultCode(INIZIALIZZASCHEDA_OUTCOME_CODE__OK_MODIFICA);
			}

			theModel.setAppDatadatiInserimentoSanzione(sanzione);

			if (theModel.getAppDataelencoIndirizziSanzionato() == null
					|| theModel.getAppDataelencoIndirizziSanzionato().isEmpty()) {
				theModel.setAppDataelencoIndirizziSanzionato(new ArrayList<CodeDescription>());
			}

			loadComuni(theModel);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inizializzaScheda] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazioneSoggetto definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults gestisciAbilitazioneSoggetto(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONESOGGETTO_OUTCOME_CODE__SOGGETTO_SI = //NOSONAR  Reason:EIAS
				"SOGGETTO_SI"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONESOGGETTO_OUTCOME_CODE__SOGGETTO_NO = //NOSONAR  Reason:EIAS
				"SOGGETTO_NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-92136222) ENABLED START*/

			//metodo che verifica semplicemente se esiste o no il soggetto
			DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

			if (GenericUtil.isNotNullOrEmpty(sanzione.getCodiceFiscale())) {
				result.setResultCode(GESTISCIABILITAZIONESOGGETTO_OUTCOME_CODE__SOGGETTO_SI);
			} else {
				result.setResultCode(GESTISCIABILITAZIONESOGGETTO_OUTCOME_CODE__SOGGETTO_NO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilitazioneSoggetto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazioneEnteImpresa definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults gestisciAbilitazioneEnteImpresa(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONEENTEIMPRESA_OUTCOME_CODE__FISICA = //NOSONAR  Reason:EIAS
				"FISICA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONEENTEIMPRESA_OUTCOME_CODE__GIURIDICA = //NOSONAR  Reason:EIAS
				"GIURIDICA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2118158813) ENABLED START*/

			DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

			if (sanzione.getFlgEnteImpresa()) {
				result.setResultCode(GESTISCIABILITAZIONEENTEIMPRESA_OUTCOME_CODE__GIURIDICA);
			} else {
				result.setResultCode(GESTISCIABILITAZIONEENTEIMPRESA_OUTCOME_CODE__FISICA);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilitazioneEnteImpresa] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazioneIndirizzo definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults gestisciAbilitazioneIndirizzo(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONEINDIRIZZO_OUTCOME_CODE__INDIRIZZO_SI = //NOSONAR  Reason:EIAS
				"INDIRIZZO_SI"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONEINDIRIZZO_OUTCOME_CODE__INDIRIZZO_NO = //NOSONAR  Reason:EIAS
				"INDIRIZZO_NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2142338654) ENABLED START*/

			DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

			if (GenericUtil.isNullOrEmpty(sanzione.getIdIndirizzo())
					&& GenericUtil.isNullOrEmpty(sanzione.getIndirizzoEstero())
					&& GenericUtil.isNullOrEmpty(sanzione.getIndirizzoNoStradario())) {
				result.setResultCode(GESTISCIABILITAZIONEINDIRIZZO_OUTCOME_CODE__INDIRIZZO_NO);
			} else {
				result.setResultCode(GESTISCIABILITAZIONEINDIRIZZO_OUTCOME_CODE__INDIRIZZO_SI);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilitazioneIndirizzo] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazioneIndirizzoEsteroLocale definito in un ExecCommand del
	 * ContentPanel cpInserisciNotificaSanzione
	 */
	public ExecResults gestisciAbilitazioneIndirizzoEsteroLocale(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONEINDIRIZZOESTEROLOCALE_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONEINDIRIZZOESTEROLOCALE_OUTCOME_CODE__LOCALE = //NOSONAR  Reason:EIAS
				"LOCALE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1134247596) ENABLED START*/

			DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

			if (!GenericUtil.isNullOrEmpty(sanzione.getIdIndirizzo())
					|| !GenericUtil.isNullOrEmpty(sanzione.getIndirizzoNoStradario())) {
				result.setResultCode(GESTISCIABILITAZIONEINDIRIZZOESTEROLOCALE_OUTCOME_CODE__LOCALE);
			} else {
				result.setResultCode(GESTISCIABILITAZIONEINDIRIZZOESTEROLOCALE_OUTCOME_CODE__ESTERO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciAbilitazioneIndirizzoEsteroLocale] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbElencoSanzionabili
	 */
	public static void resetClearStatus_widg_tbElencoSanzionabili(java.util.Map session) {
		session.put("cpInserisciNotificaSanzione_tbElencoSanzionabili_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1893928399) ENABLED START*/

	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
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

	private ArrayList<CodeDescription> recuperaComuni(String idProvSel) throws ServiceException {

		ArrayList<CodeDescription> comuniLoc = new ArrayList<CodeDescription>();

		if (GenericUtil.isNotNullOrEmpty(idProvSel)) {

			// Localizzazione COMUNE 
			log.debug("STAMPO idProvSelLoc: " + idProvSel);

			comuniLoc = (ArrayList<CodeDescription>) getServiziMgr().getListaComuniByIstatProvincia(idProvSel);

		}

		return comuniLoc;
	}

	private void settaInfoSanzionatoGiuridico(
			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel,
			PersonaGiuridica candidatoGiuridico) throws BEException {
		DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

		sanzione.setCapEstero(candidatoGiuridico.getEstCap());
		sanzione.setCivico(candidatoGiuridico.getFlgIndirizzoEst() ? null : candidatoGiuridico.getCivico());
		sanzione.setCivicoEstero(candidatoGiuridico.getFlgIndirizzoEst() ? candidatoGiuridico.getCivico() : null);
		sanzione.setCodiceFiscale(candidatoGiuridico.getCodiceFiscale());
		sanzione.setComuneEstero(candidatoGiuridico.getEstCitta());
		sanzione.setDenominazione(candidatoGiuridico.getDenominazione());
		sanzione.setFlgIndirizzoEstero(candidatoGiuridico.getFlgIndirizzoEst());
		sanzione.setIdComune(candidatoGiuridico.getIdComuneSelez());
		sanzione.setIdIndirizzo(candidatoGiuridico.getIdIndirizzoSel());
		sanzione.setIdProvincia(candidatoGiuridico.getIdProvinciaSelez());
		sanzione.setIndirizzo(candidatoGiuridico.getIndirizzo());
		sanzione.setIndirizzoEstero(candidatoGiuridico.getEstIndirizzo());
		sanzione.setIndirizzoNoStradario(candidatoGiuridico.getIndirizzoNonTrovato());
		sanzione.setStatoEstero(candidatoGiuridico.getEstStato());
		sanzione.setIdSanzionatoGiuridico(candidatoGiuridico.getIdPersonaGiuridica());

		//costruzione della combo indirizzi popolata con l'unico indirizzo a disposizione
		if (GenericUtil.isNotNullOrEmpty(candidatoGiuridico.getIdIndirizzoSel())) {
			ArrayList<CodeDescription> vie = new ArrayList<CodeDescription>();

			CodeDescription via = new CodeDescription();
			via.setCode(candidatoGiuridico.getIdIndirizzoSel());
			via.setDescription(candidatoGiuridico.getIndirizzo());
			vie.add(via);
			theModel.setAppDataelencoIndirizziSanzionato(vie);
		} else {
			theModel.setAppDataelencoIndirizziSanzionato(new ArrayList<CodeDescription>());
		}

		if (GenericUtil.isNotNullOrEmpty(candidatoGiuridico.getIdProvinciaSelez())) {
			loadComuni(theModel);
		} else {
			theModel.setAppDataelencoComuni(new ArrayList<CodeDescription>());
		}
	}

	private void settaInfoSanzionatoFisico(
			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel,
			PersonaFisica candidatoFisico) throws BEException {
		DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();

		sanzione.setCapEstero(candidatoFisico.getEstCap());
		sanzione.setCivico(candidatoFisico.getFlgIndirizzoEst() ? null : candidatoFisico.getCivico());
		sanzione.setCivicoEstero(candidatoFisico.getFlgIndirizzoEst() ? candidatoFisico.getCivico() : null);
		sanzione.setCodiceFiscale(candidatoFisico.getCodiceFiscale());
		sanzione.setComuneEstero(candidatoFisico.getEstCitta());
		sanzione.setDenominazione(candidatoFisico.getCognome());
		sanzione.setFlgIndirizzoEstero(candidatoFisico.getFlgIndirizzoEst());
		sanzione.setIdComune(candidatoFisico.getIdComuneSelez());
		sanzione.setIdIndirizzo(candidatoFisico.getIdIndirizzoSel());
		sanzione.setIdProvincia(candidatoFisico.getIdProvinciaSelez());
		sanzione.setIndirizzo(candidatoFisico.getIndirizzo());
		sanzione.setIndirizzoEstero(candidatoFisico.getEstIndirizzo());
		sanzione.setIndirizzoNoStradario(candidatoFisico.getIndirizzoNonTrovato());
		sanzione.setStatoEstero(candidatoFisico.getEstStato());
		sanzione.setNome(candidatoFisico.getNome());
		sanzione.setIdSanzionatoFisico(candidatoFisico.getIdPersonaFisica());

		//costruzione della combo indirizzi popolata con l'unico indirizzo a disposizione
		if (GenericUtil.isNotNullOrEmpty(candidatoFisico.getIdIndirizzoSel())) {
			ArrayList<CodeDescription> vie = new ArrayList<CodeDescription>();

			CodeDescription via = new CodeDescription();
			via.setCode(candidatoFisico.getIdIndirizzoSel());
			via.setDescription(candidatoFisico.getIndirizzo());
			vie.add(via);
			theModel.setAppDataelencoIndirizziSanzionato(vie);
		} else {
			theModel.setAppDataelencoIndirizziSanzionato(new ArrayList<CodeDescription>());
		}

		if (GenericUtil.isNotNullOrEmpty(candidatoFisico.getIdProvinciaSelez())) {
			loadComuni(theModel);
		} else {
			theModel.setAppDataelencoComuni(new ArrayList<CodeDescription>());
		}
	}

	private void svuotaIndirizzo(it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel theModel,
			Boolean defaultValue) {
		DatiInserimentoSanzione sanzione = theModel.getAppDatadatiInserimentoSanzione();
		sanzione.setCapEstero(null);
		sanzione.setCivico(null);
		sanzione.setCivicoEstero(null);
		sanzione.setComuneEstero(null);
		sanzione.setFlgIndirizzoEstero(defaultValue);
		sanzione.setIdComune(null);
		sanzione.setIdIndirizzo(null);
		sanzione.setIdProvincia(null);
		sanzione.setIndirizzo(null);
		sanzione.setIndirizzoEstero(null);
		sanzione.setIndirizzoNoStradario(null);
		theModel.setAppDataelencoIndirizziSanzionato(null);
		sanzione.setStatoEstero(null);
	}

	/*PROTECTED REGION END*/
}
