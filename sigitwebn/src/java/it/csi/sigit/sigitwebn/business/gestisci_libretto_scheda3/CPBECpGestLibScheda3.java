package it.csi.sigit.sigitwebn.business.gestisci_libretto_scheda3;

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

/*PROTECTED REGION ID(R-1744367999) ENABLED START*/
import java.io.File;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ConnectorMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRContr2019AutodichiarByExampleExtendedDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRContr2019AutodichiarDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVAllegatiComponentiDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.DocumentoContrattoDto;
import it.csi.sigit.sigitwebn.business.gestisci_verifica.CPBECpGestVerifica.TipoVerificaEnum;
/*PROTECTED REGION END*/

public class CPBECpGestLibScheda3 {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [elencoDettaglioTerzoResponsabile, scope:USER_SESSION]
	public static final String APPDATA_ELENCODETTAGLIOTERZORESPONSABILE_CODE = "appDataelencoDettaglioTerzoResponsabile";

	// ApplicationData: [elencoTipiCessazione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPICESSAZIONE_CODE = "appDataelencoTipiCessazione";

	// ApplicationData: [datiRevocaResponsabile, scope:USER_SESSION]
	public static final String APPDATA_DATIREVOCARESPONSABILE_CODE = "appDatadatiRevocaResponsabile";

	// ApplicationData: [librettoMenuTree, scope:USER_SESSION]
	public static final String APPDATA_LIBRETTOMENUTREE_CODE = "appDatalibrettoMenuTree";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [aggiornaElencoImpianti, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOIMPIANTI_CODE = "appDataaggiornaElencoImpianti";

	// ApplicationData: [idContrattoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDCONTRATTOSELEZ_CODE = "appDataidContrattoSelez";

	// ApplicationData: [dettaglioTerzoResponsabile, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOTERZORESPONSABILE_CODE = "appDatadettaglioTerzoResponsabile";

	// ApplicationData: [idTipoCessazioneSelez, scope:USER_SESSION]
	public static final String APPDATA_IDTIPOCESSAZIONESELEZ_CODE = "appDataidTipoCessazioneSelez";

	// ApplicationData: [elencoAutodichiarazioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAUTODICHIARAZIONI_CODE = "appDataelencoAutodichiarazioni";

	// ApplicationData: [elencoIdSelezionati, scope:USER_ACTION]
	public static final String APPDATA_ELENCOIDSELEZIONATI_CODE = "appDataelencoIdSelezionati";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestLibScheda3";

	public static final String MULTIPANEL_MPDATAREVOCA = "mpDataRevoca";
	public static final String MPI_MPDATAREVOCA_FPMPREVOCA = CPNAME + "_" + MULTIPANEL_MPDATAREVOCA + "_"
			+ "fpMpRevoca";
	public static final String MULTIPANEL_MPAUTODICHIARAZIONI = "mpAutodichiarazioni";
	public static final String MPI_MPAUTODICHIARAZIONI_FPAUTODICHIARAZIONI = CPNAME + "_"
			+ MULTIPANEL_MPAUTODICHIARAZIONI + "_" + "fpAutodichiarazioni";

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
	 * ContentPanel cpGestLibScheda3
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpGestLibScheda3Model theModel

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
			/*PROTECTED REGION ID(R1720202291) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(
					GenericUtil.gestisciTreeClick(theModel.getIdNodo(), theModel.getAppDatalibrettoMenuTree()));

			// Setto la pagina in cui sto andando, mi servirà nel caso ci sia necessità di ricaricare la pagina con un messaggio (es. consolida libretto)
			theModel.getSession().put(Constants.SESSIONE_VAR_LIBRETTO_SCHEDA, result.getResultCode());

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

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
	 * Implementazione del metodo revocaTerzoResponsabile definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda3
	 */
	public ExecResults revocaTerzoResponsabile(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpGestLibScheda3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String REVOCATERZORESPONSABILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String REVOCATERZORESPONSABILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1093274155) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idContrattoSelez = theModel.getAppDataidContrattoSelez();

			ArrayList<DettaglioTerzoResponsabile> elenco3Resp = theModel.getAppDataelencoDettaglioTerzoResponsabile();

			try {

				RisultatoRicImpianto risRicCodImpianto = getSigitMgr().cercaImpianto(
						theModel.getAppDataidImpiantoSelez(),
						theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo());

				getValidationMgr().validazioneFormaleRevocaTerzoResponsabile(risRicCodImpianto, idContrattoSelez,
						elenco3Resp, theModel.getAppDatautenteLoggato());

				// Questo comando serve se l'utente clicca il pulsante indietro (quindi l'elenco degli impianti) bisogna rieseguire la query, 
				theModel.setAppDataaggiornaElencoImpianti(true);

				//viene caricata la lista di tipi cessazione
				if (theModel.getAppDataelencoTipiCessazione() == null
						|| theModel.getAppDataelencoTipiCessazione().isEmpty()) {
					theModel.setAppDataelencoTipiCessazione(getSigitMgr()
							.creaElencoTipoCessazione(theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo()));
				}

				// impostazione del result code 
				result.setResultCode(REVOCATERZORESPONSABILE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::revocaTerzoResponsabile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo dettaglioTerzoResponsabile definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda3
	 */
	public ExecResults dettaglioTerzoResponsabile(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpGestLibScheda3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DETTAGLIOTERZORESPONSABILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String DETTAGLIOTERZORESPONSABILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R153633010) ENABLED START*/

			try {
				Integer idContrattoSelez = theModel.getAppDataidContrattoSelez();

				getValidationMgr().validazioneFormaleDettaglioNominaTerzoResponsabile(idContrattoSelez);

				ArrayList<DettaglioTerzoResponsabile> elenco3Resp = theModel
						.getAppDataelencoDettaglioTerzoResponsabile();

				if (elenco3Resp != null && !elenco3Resp.isEmpty()) {
					for (DettaglioTerzoResponsabile dettaglioInElenco : elenco3Resp) {
						if (dettaglioInElenco.getIdContratto().equals(idContrattoSelez)) {
							theModel.setAppDatadettaglioTerzoResponsabile(dettaglioInElenco);
							break;
						}
					}
				}

				//se non riesce a recuperare il contratto
				if (theModel.getAppDatadettaglioTerzoResponsabile() == null
						|| theModel.getAppDatadettaglioTerzoResponsabile().getIdContratto() == null) {
					result.setResultCode(DETTAGLIOTERZORESPONSABILE_OUTCOME_CODE__KO);
				} else {
					result.setResultCode(DETTAGLIOTERZORESPONSABILE_OUTCOME_CODE__OK);
				}

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::dettaglioTerzoResponsabile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo checkCaricamentoAutodichiarazioni definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda3
	 */
	public ExecResults checkCaricamentoAutodichiarazioni(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpGestLibScheda3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHECKCARICAMENTOAUTODICHIARAZIONI_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String CHECKCARICAMENTOAUTODICHIARAZIONI_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R505298393) ENABLED START*/

			//se il motivo di cessazione è la decadenza allora vengono caricate le autodichiarazioni possibili

			log.debug("### checkCaricamentoAutodichiarazioni ###");
			log.debug("Stampo getIdTipoCessazione(): "
					+ theModel.getAppDatadatiRevocaResponsabile().getIdTipoCessazione());
			log.debug(
					"Stampo equals(1): " + theModel.getAppDatadatiRevocaResponsabile().getIdTipoCessazione().equals(1));

			if (theModel.getAppDatadatiRevocaResponsabile().getIdTipoCessazione() != null
					&& theModel.getAppDatadatiRevocaResponsabile().getIdTipoCessazione().equals(1)) {

				/*
				//METODO CHE SERVE A RECUPERARE L'ELENCO DI TUTTE LE AUTODICHIARAZIONI E A FLAGGARE QUELLE CHE RISULTANO ASSOCIATE AL CONTRATTO
				if (theModel.getAppDataelencoAutodichiarazioni() == null
						|| theModel.getAppDataelencoAutodichiarazioni().isEmpty()) {
				
					theModel.setAppDataelencoAutodichiarazioni(
							(ArrayList<IdDescription>) getDbMgr().cercaListaAutodichiarazioni());
				
					GenericUtil.stampa(theModel.getAppDataelencoAutodichiarazioni(), true, 3);
				}
				*/

				costruisciListaAutodichiarazioniContratto(theModel);

				// impostazione del result code 
				result.setResultCode(CHECKCARICAMENTOAUTODICHIARAZIONI_OUTCOME_CODE__VISUALIZZA);

			} else {
				//theModel.setAppDataelencoAutodichiarazioni(null);
				theModel.setAppDataelencoIdSelezionati(null);

				// impostazione del result code 
				result.setResultCode(CHECKCARICAMENTOAUTODICHIARAZIONI_OUTCOME_CODE__NASCONDI);

			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::checkCaricamentoAutodichiarazioni] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo confermaRevocaTerzoResponsabile definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda3
	 */
	public ExecResults confermaRevocaTerzoResponsabile(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpGestLibScheda3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CONFERMAREVOCATERZORESPONSABILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CONFERMAREVOCATERZORESPONSABILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1275847014) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idContrattoSelez = theModel.getAppDataidContrattoSelez();

			ArrayList<DettaglioTerzoResponsabile> elenco3Resp = theModel.getAppDataelencoDettaglioTerzoResponsabile();

			try {

				getValidationMgr()
						.validazioneFormaleDataRevocaResponsabile(theModel.getAppDatadatiRevocaResponsabile());

				StringBuffer msgError = new StringBuffer();

				UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

				Integer idPGLoggato = utenteLoggato.getRuolo().getIdPersonaGiuridica();

				boolean isError = false;
				boolean isInsert = false;

				String msg = null;
				StringBuffer msgCorrect = new StringBuffer();

				DettaglioTerzoResponsabile dettaglioTerzoResponsabile = null;

				Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();

				for (int j = 0; j < elenco3Resp.size(); j++) {

					if (idContrattoSelez.intValue() == elenco3Resp.get(j).getIdContratto()) {
						dettaglioTerzoResponsabile = elenco3Resp.get(j);

						log.debug("Data revoca: " + theModel.getAppDatadatiRevocaResponsabile().getDataCessazione());
						log.debug("Ho trovato il dettaglio 3responsabile per l'id contratto: " + idContrattoSelez);

						if (log.isDebugEnabled())
							GenericUtil.stampa(dettaglioTerzoResponsabile, true, 3);

						if (utenteLoggato.getRuolo().getDescRuolo().equals(Constants.RUOLO_3RESPONSABILE)) {
							if (dettaglioTerzoResponsabile.getIdPersonaGiuridica().intValue() != idPGLoggato
									.intValue()) {
								msg = Messages.S154;

								break;
							}
						}

						if (!DateUtil.checkDateOrder(dettaglioTerzoResponsabile.getDataInizioContratto(),
								theModel.getAppDatadatiRevocaResponsabile().getDataCessazione(), true)) {
							msg = Messages.S093;
							break;

						} else if (!dettaglioTerzoResponsabile.getFlgTacitoRinnovo() && !DateUtil.checkDateOrder(
								theModel.getAppDatadatiRevocaResponsabile().getDataCessazione(),
								dettaglioTerzoResponsabile.getDataFineContratto(), true)) {
							msg = Messages.S153;
							break;

						} else {
							List<SigitVAllegatiComponentiDto> dtoList = getDbMgr()
									.cerca3RespAllCompByFilterAttivoByCodImpianto(
											dettaglioTerzoResponsabile.getCodImpianto(), idContrattoSelez,
											theModel.getAppDatadatiRevocaResponsabile().getDataCessazione());

							if (dtoList != null && dtoList.size() > 0) {
								msg = Messages.S149;
								break;
							}
						}
						if (GenericUtil.isNullOrEmpty(msg)) {

							CessazioneTerzaResponsabilita datiCessazione = theModel.getAppDatadatiRevocaResponsabile();
							List<IdDescription> elencoAutodichiarazioniScelte = new ArrayList<IdDescription>();
							if (theModel.getAppDataelencoAutodichiarazioni() != null
									&& !theModel.getAppDataelencoAutodichiarazioni().isEmpty()
									&& theModel.getAppDataelencoIdSelezionati() != null
									&& !theModel.getAppDataelencoIdSelezionati().isEmpty()) {
								Map<Integer, String> mappaAutodichiarazioni = ConvertUtil
										.convertIdDescriptionsInMap(theModel.getAppDataelencoAutodichiarazioni());
								for (Integer idAutodichiarazioneScelta : theModel.getAppDataelencoIdSelezionati()) {
									IdDescription coppiaValoriScelta = new IdDescription();
									coppiaValoriScelta.setId(idAutodichiarazioneScelta);
									coppiaValoriScelta
											.setDescription(mappaAutodichiarazioni.get(idAutodichiarazioneScelta));
									elencoAutodichiarazioniScelte.add(coppiaValoriScelta);
								}
							}
							//viene arricchito l'oggetto con le informazioni della cessazione
							datiCessazione.setElencoAutodichiarazioniSelezionate(
									(ArrayList<IdDescription>) elencoAutodichiarazioniScelte);
							Map<Integer, String> mappaTipiCessazione = ConvertUtil
									.convertIdDescriptionsInMap(theModel.getAppDataelencoTipiCessazione());
							datiCessazione.setDesTipoCessazione(
									mappaTipiCessazione.get(datiCessazione.getIdTipoCessazione()));

							//							String infoEmail = getConnectorMgr().revoca3Responsabile(idContrattoSelez,
							//									dettaglioTerzoResponsabile.getCodImpianto(),
							//									theModel.getAppDatautenteLoggato().getRuolo(),
							//									theModel.getAppDatautenteLoggato().getCodiceFiscale(),
							//									theModel.getAppDatadatiRevocaResponsabile().getDataCessazione(),
							//									dettaglioTerzoResponsabile.getIdPersonaGiuridica());

							String infoEmail2 = getConnectorMgr().revoca3Responsabile2019(dettaglioTerzoResponsabile,
									theModel.getAppDatautenteLoggato(), datiCessazione, idContrattoSelez);

							isInsert = true;

							msgCorrect.append(Constants.VALUE_ENTER_HTML);
							//							msgCorrect.append(dettaglioTerzoResponsabile.getDescElencoApparecchiature());
							//							msgCorrect.append(" " + Constants.INTERVAL_SEP + " ");

							//msgCorrect.append(dettaglioTerzoResponsabile.getDataInizioContratto());
							//msgCorrect.append(" " + Constants.INTERVAL_SEP + " ");

							msgCorrect.append(infoEmail2);

							//msg = infoEmail;
						}

						// Siccome ho gia' analizzato il 3responsabile posso uscire dal for piu' interno
						break;
					}
				}

				if (GenericUtil.isNotNullOrEmpty(msg)) {
					if (!isError) {
						msgError.append("Elenco revoche che hanno evidenziato problemi:");
						msgError.append(Constants.VALUE_ENTER_HTML);

					}

					msgError.append(Constants.VALUE_ENTER_HTML);
					//msgError.append(dettaglioTerzoResponsabile.getDescElencoApparecchiature());
					//msgError.append(" " + Constants.INTERVAL_SEP + " ");
					msgError.append("Data inizio contratto: ");
					msgError.append(dettaglioTerzoResponsabile.getDataInizioContratto());
					msgError.append(" " + Constants.INTERVAL_SEP + " ");
					msgError.append(msg);
					msg = null;
					isError = true;

				}

				StringBuffer msgFinal = new StringBuffer();

				if (isInsert) {
					// Nel caso in cui qualche revoca sia andata a buon fine
					msgFinal.append(Messages.INFO_SALVATAGGIO_CORRETTO);
					msgFinal.append(Constants.VALUE_ENTER_HTML);

					msgFinal.append(msgCorrect);

					if (isError) {
						// Nel caso in cui qualche revoca non sia andata a buon fine
						msgFinal.append(Constants.VALUE_ENTER_HTML);
						msgFinal.append(Constants.VALUE_ENTER_HTML);
						msgFinal.append("<font color=\"red\">" + msgError + "</font>");
					}

					result.getGlobalMessages().add(msgFinal.toString());

					String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

					ArrayList<DettaglioTerzoResponsabile> list3Resp = getSigitMgr()
							.cercaTutti3ResponsabiliByCodImp(idImpiantoSelez, ruolo.getDescRuolo());

					theModel.setAppDataelencoDettaglioTerzoResponsabile(list3Resp);

					// impostazione del result code 
					result.setResultCode(CONFERMAREVOCATERZORESPONSABILE_OUTCOME_CODE__OK);
				} else if (isError) {
					// Nel caso in cui nessuna revoca sia andata a buon fine

					result.getGlobalErrors().add(msgError.toString());

					// impostazione del result code 
					result.setResultCode(CONFERMAREVOCATERZORESPONSABILE_OUTCOME_CODE__KO);
				}

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::confermaRevocaTerzoResponsabile] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda3
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpGestLibScheda3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_IMPIANTO = //NOSONAR  Reason:EIAS
				"RIS_RIC_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_AVZ_IMPIANTI = //NOSONAR  Reason:EIAS
				"RIS_RIC_AVZ_IMPIANTI"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__GEST_IMPIANTO = //NOSONAR  Reason:EIAS
				"GEST_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__GEST_IMPIANTO_RESP = //NOSONAR  Reason:EIAS
				"GEST_IMPIANTO_RESP"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1804885444) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(GenericUtil.gestisciTreeIndietro(theModel.getAppDatapaginaChiamante()));

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
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda3
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpGestLibScheda3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1728498542) ENABLED START*/
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
	 * Implementazione del metodo caricaScheda3 definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda3
	 */
	public ExecResults caricaScheda3(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpGestLibScheda3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICASCHEDA3_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R295176392) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();
			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			ArrayList<DettaglioTerzoResponsabile> list3Resp = getSigitMgr()
					.cercaTutti3ResponsabiliByCodImp(idImpiantoSelez, ruolo.getDescRuolo());

			theModel.setAppDataelencoDettaglioTerzoResponsabile(list3Resp);
			theModel.setAppDatadatiRevocaResponsabile(null);
			theModel.setAppDatadettaglioTerzoResponsabile(null);
			theModel.setAppDataidContrattoSelez(null);
			theModel.setAppDataelencoIdSelezionati(null);

			if (theModel.getAppDataelencoAutodichiarazioni() == null
					|| theModel.getAppDataelencoAutodichiarazioni().isEmpty()) {

				// Carico l'elenco delle autodichiarazioni
				theModel.setAppDataelencoAutodichiarazioni(
						(ArrayList<IdDescription>) getDbMgr().cercaListaAutodichiarazioni());
			}

			// impostazione del result code 
			result.setResultCode(CARICASCHEDA3_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaScheda3] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciMsg definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda3
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpGestLibScheda3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1656527948) ENABLED START*/
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
	 * permette di resettare lo stato di paginazione della tabella widg_tbRespImpianto3Resp
	 */
	public static void resetClearStatus_widg_tbRespImpianto3Resp(java.util.Map session) {
		session.put("cpGestLibScheda3_tbRespImpianto3Resp_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbAutodichiarazioni
	 */
	public static void resetClearStatus_widg_tbAutodichiarazioni(java.util.Map session) {
		session.put("cpGestLibScheda3_tbAutodichiarazioni_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1459443219) ENABLED START*/
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

	private ConnectorMgr connectorMgr;

	public ConnectorMgr getConnectorMgr() {
		return connectorMgr;
	}

	public void setConnectorMgr(ConnectorMgr connectorMgr) {
		this.connectorMgr = connectorMgr;
	}

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	private void costruisciListaAutodichiarazioniContratto(
			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpGestLibScheda3Model theModel)
			throws DbManagerException {

		ArrayList<Integer> idSelezionati = getSigitMgr().costruisciListaAutodichiarazioniContratto("C",
				theModel.getAppDataidContrattoSelez());

		log.debug("Stampo gli idSelezionati: ");

		if (log.isDebugEnabled())
			GenericUtil.stampa(idSelezionati, true, 3);

		theModel.setAppDataelencoIdSelezionati(idSelezionati);

	}

	/*PROTECTED REGION END*/
}
