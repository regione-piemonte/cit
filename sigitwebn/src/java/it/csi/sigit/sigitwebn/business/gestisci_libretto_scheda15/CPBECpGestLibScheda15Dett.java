package it.csi.sigit.sigitwebn.business.gestisci_libretto_scheda15;

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

/*PROTECTED REGION ID(R2068563267) ENABLED START*/
import java.io.File;
import java.math.BigDecimal;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportDocumentoFilter;
import it.csi.sigit.sigitwebn.business.manager.ConnectorMgr;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.util.mail.ResultInvioMail;
/*PROTECTED REGION END*/

public class CPBECpGestLibScheda15Dett {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [librettoMenuTree, scope:USER_SESSION]
	public static final String APPDATA_LIBRETTOMENUTREE_CODE = "appDatalibrettoMenuTree";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [dettaglioManutenzione, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOMANUTENZIONE_CODE = "appDatadettaglioManutenzione";

	// ApplicationData: [elencoTipoManutenzione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOMANUTENZIONE_CODE = "appDataelencoTipoManutenzione";

	// ApplicationData: [elencoApparecchiatureManut, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAPPARECCHIATUREMANUT_CODE = "appDataelencoApparecchiatureManut";

	// ApplicationData: [elencoTipoIntervento, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOINTERVENTO_CODE = "appDataelencoTipoIntervento";

	// ApplicationData: [isNuovoComponente, scope:USER_SESSION]
	public static final String APPDATA_ISNUOVOCOMPONENTE_CODE = "appDataisNuovoComponente";

	// ApplicationData: [rigaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_RIGASELEZIONATA_CODE = "appDatarigaSelezionata";

	// ApplicationData: [documento, scope:USER_SESSION]
	public static final String APPDATA_DOCUMENTO_CODE = "appDatadocumento";

	// ApplicationData: [elencoDocumenti, scope:USER_SESSION]
	public static final String APPDATA_ELENCODOCUMENTI_CODE = "appDataelencoDocumenti";

	// ApplicationData: [idDocumentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDDOCUMENTOSELEZIONATO_CODE = "appDataidDocumentoSelezionato";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestLibScheda15Dett";

	public static final String MULTIPANEL_MPELENCODOCUMENTI = "mpElencoDocumenti";
	public static final String MPI_MPELENCODOCUMENTI_FPELENCODOCUMENTI = CPNAME + "_" + MULTIPANEL_MPELENCODOCUMENTI
			+ "_" + "fpElencoDocumenti";

	public static final String MULTIPANEL_MPDATIDOCUMENTO = "mpDatiDocumento";
	public static final String MPI_MPDATIDOCUMENTO_FPDATIDOCUMENTO = CPNAME + "_" + MULTIPANEL_MPDATIDOCUMENTO + "_"
			+ "fpDatiDocumento";

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
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

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
			/*PROTECTED REGION ID(R1899028597) ENABLED START*/
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
	 * Implementazione del metodo cercaApparecchiature definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults cercaApparecchiature(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAAPPARECCHIATURE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAAPPARECCHIATURE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-330043611) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioManutenzione allegato = theModel.getAppDatadettaglioManutenzione();

			log.debug("FRAAAAAAAAAAAAAA  -- > caricaNumeriBollinoVerde --- BEGIN ");
			//			log.debug("FRAAAAAAAAAAAAAA  -- > caricaNumeriBollinoVerde --- CODICE IMPIANTO "
			//					+ allegato.getCodiceImpianto());
			log.debug("FRAAAAAAAAAAAAAA  -- > caricaNumeriBollinoVerde --- ID TIPO DOCUMENTO "
					+ allegato.getIdTipoManut());

			try {
				getValidationMgr().validazioneFormaleDatiManutenzioneCerca(allegato);

				allegato.setIdApparecchiature(null);
				//				allegato.setNumeroBollinoVerde(null);
				//				allegato.setIdTipiCombustibile(null);

				//				theModel.setAppDataelencoTipiCombustibile(
				//						getSigitMgr().cercaElencoCombustibili(allegato.getIdTipoAllegato()));

				allegato.setIdTipoAllegato(GenericUtil.getIdTipoAllegatoByIdTipoManut(allegato.getIdTipoManut()));

				theModel.setAppDataelencoApparecchiatureManut(
						getSigitMgr().cercaElencoApparecchiatureManutenzione(allegato));

				// impostazione del result code 
				result.setResultCode(CERCAAPPARECCHIATURE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				//log.debug("Errore: ", ex);
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaApparecchiature] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaApparecchiature definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults verificaApparecchiature(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAAPPARECCHIATURE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAAPPARECCHIATURE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1191950746) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				DettaglioManutenzione dettaglio = theModel.getAppDatadettaglioManutenzione();

				log.debug("@@@ STAMPO dettaglio.getIdApparecchiature(): " + dettaglio.getIdApparecchiature());

				getValidationMgr().verificaManutentoreUnivoco(dettaglio);

				Ruolo profiloUtente = theModel.getAppDatautenteLoggato().getRuolo();

				if (!(Constants.RUOLO_IMPRESA.equalsIgnoreCase(profiloUtente.getDescRuolo()))) {
					// Se passo di qua son sicuro che tutte le apparecchiature selezionate appartengono allo stesso manutentore, quindi vado a recuperare i suoi bollini 
					String fkManutNew = GenericUtil.getFkManutentore(dettaglio.getIdApparecchiature().get(0));

					dettaglio.setIdPersonaGiuridica(ConvertUtil.convertToInteger(fkManutNew));

					//PersonaGiuridica pg = getSigitMgr().
					SigitTPersonaGiuridicaDto pg = getDbMgr()
							.cercaTPersonaGiuridicaById(dettaglio.getIdPersonaGiuridica());

					String manutentore = pg.getDenominazione() + " "
							+ MapDto.getCodiceRea(pg.getSiglaRea(), pg.getNumeroRea());
					dettaglio.setDescManutentore(manutentore);

					theModel.setAppDatadettaglioManutenzione(dettaglio);
				}
				/*
				ArrayList<CodeDescription> value = new ArrayList<CodeDescription>();
				
				if (allegato.getIdTipoAllegato() != null) {
					value = this.getSigitMgr().cercaElencoNumeriBollinoVerde(ConvertUtil.convertToInteger(fkManutNew),
							ConvertUtil.convertToInteger(allegato.getCodiceImpianto()), allegato.getIdAllegato());
				}
				*/
				//devo ricaricare la combo della tipologia di documento
				//theModel.setAppDataelencoNumeroBollinoVerde(value);

				// impostazione del result code 
				result.setResultCode(VERIFICAAPPARECCHIATURE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				//log.debug("Errore: ", ex);
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaApparecchiature] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciTipoIntAltro definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults gestisciTipoIntAltro(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCITIPOINTALTRO_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTISCITIPOINTALTRO_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1267075614) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioManutenzione dettaglioAllegato = theModel.getAppDatadettaglioManutenzione();

			if (dettaglioAllegato != null && dettaglioAllegato.getIdTipoIntervento() != null
					&& dettaglioAllegato.getIdTipoIntervento() == Constants.ID_TIPO_MANUTENZIONE_ALTRO) {
				// impostazione del result code 
				result.setResultCode(GESTISCITIPOINTALTRO_OUTCOME_CODE__VISUALIZZA);
			} else {
				dettaglioAllegato.setAltro(null);

				// impostazione del result code 
				result.setResultCode(GESTISCITIPOINTALTRO_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciTipoIntAltro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaManutenzione definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults salvaManutenzione(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAMANUTENZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAMANUTENZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-924815646) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioManutenzione dettaglioAllegato = theModel.getAppDatadettaglioManutenzione();
			Ruolo profiloUtente = theModel.getAppDatautenteLoggato().getRuolo();
			//GenericUtil.stampa(dettaglioAllegato, true, 3);

			try {

				log.debug("FRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA CODICE IMPIANTO : "
						+ dettaglioAllegato.getCodiceImpianto());
				log.debug("FRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA RUOLO UTENTE : " + profiloUtente.getDescRuolo());

				//				Integer fkManutentore = ConvertUtil
				//						.convertToInteger(GenericUtil
				//								.getFkManutentore(dettaglioAllegato

				//										.getIdApparecchiature().get(0)));

				Integer fkManutentore = null;

				log.debug("Sono in inserimento manutenzione");

				getValidationMgr().validazioneFormaleDatiManutenzione(dettaglioAllegato);

				fkManutentore = ConvertUtil.convertToInteger(
						GenericUtil.getFkManutentore(dettaglioAllegato.getIdApparecchiature().get(0)));

				// recupero il manutentore (siccome appartengono tutti allo stesso manutentore, prendo il primo
				String manutApp = dettaglioAllegato.getIdApparecchiature().get(0);

				dettaglioAllegato
						.setIdPersonaGiuridica(ConvertUtil.convertToInteger(GenericUtil.getFkManutentore(manutApp)));

				//controllo se i campi obbligatori sono stati valorizzati
				//getValidationMgr().verificaDatiAllegato(dettaglioAllegato, fkManutentore);

				// Se sono in inserimento devo ripulire l'id
				// Devo ripulire l'id della combo apparecchiature (e' comp4mnaut#fKManut#progressivo), devo recupero il com4manut
				dettaglioAllegato
						.setIdCom4Manut(GenericUtil.recuperaComp4Manut(dettaglioAllegato.getIdApparecchiature()));

				//GenericUtil.stampa(dettaglioAllegato, true, 3);

				log.debug("Stampo dettaglioAllegato.getIdApparecchiature() (prima): "
						+ dettaglioAllegato.getIdApparecchiature());

				// Devo ripulire l'id della combo apparecchiature (e' comp4mnaut#fKManut#progressivo), devo recupero il progressivo
				//dettaglioAllegato.setIdApparecchiatureFunz(
				dettaglioAllegato.setIdApparecchiature(
						GenericUtil.recuperaProgressivo(dettaglioAllegato.getIdApparecchiature()));
				//					dettaglioAllegato.setIdApparecchiature(
				//							GenericUtil.recuperaProgressivo(dettaglioAllegato.getIdApparecchiature()));

				log.debug("Stampo dettaglioAllegato.getIdApparecchiature() (dopo): "
						+ dettaglioAllegato.getIdApparecchiature());

				PersonaGiuridica personaGiuridica = getDbMgr().cercaPersonaGiuridicaById(fkManutentore);

				//controllo se il manutentore loggato non abbia l'attivita' cessata
				getValidationMgr().verificaDataCessazioneAttivita(dettaglioAllegato.getDataManut(),
						personaGiuridica.getDataCessazione());

				/*
				//setto a BOZZA l'allegato che si sta per aprire (se ha passato tutti i controlli precedenti)
				dettaglioAllegato.setIdStatoRapporto(Constants.ID_STATO_RAPPORTO_BOZZA);
				//setto il codice fiscale dell'utente loggato
				dettaglioAllegato.setCodFiscaleUtenteLoggato(theModel.getAppDatautenteLoggato().getCodiceFiscale());
				//setto il flagControlloBozza a false(0) perche' se e' null va in eccezione quando cerco di inviarlo
				dettaglioAllegato.setFlagControlloBozza(Constants.FLAG_CONTROLLO_BOZZA_ALLEGATO_FALSE);
				//setto da dove sto arrivando
				dettaglioAllegato.setArrivoDa(Constants.ARRIVO_DA_IMPIANTO);
				
				dettaglioAllegato.setCodiceBollino(MapDto.costruisciCodiceBollino(dettaglioAllegato.getSiglaBollino(),
						ConvertUtil.convertToBigDecimal(dettaglioAllegato.getNumeroBollinoVerde())));
				*/

				log.debug("BEPPE - prima di mettere in sessione: " + dettaglioAllegato);

				//				//rimetto in sessione l'oggetto dettaglio allegato per la action showAllegatoNow
				//				theModel.getSession().put(Constants.SESSIONE_VAR_DETT_ALLEGATO, dettaglioAllegato);

				if (log.isDebugEnabled())
					GenericUtil.stampa(dettaglioAllegato, true, 3);

				ResultInvioMail resultInvioMail = getConnectorMgr().caricaManutenzione(dettaglioAllegato,
						theModel.getAppDatautenteLoggato());

				String msg = GenericUtil.getMsgFormatterHtml(resultInvioMail, Messages.INFO_SALVATAGGIO_CORRETTO);

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE, new Message(msg, Message.INFO));

				result.getGlobalMessages().add(msg);

				// Ricarico i dati
				dettaglioAllegato = getSigitMgr().cercaDettaglioManutenzioneById(dettaglioAllegato.getIdAllegato());

				// Forse non serve, ho appena inserito la manutenzione, sicuramente non avrà documenti associati
				caricaElencoDocumenti(theModel);

				theModel.setAppDatadettaglioManutenzione(dettaglioAllegato);

				// impostazione del result code 
				result.setResultCode(SALVAMANUTENZIONE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				//log.debug("Errore: ", ex);
				Validator.gestisciEccezione(result, ex);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaManutenzione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaDocumento definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults visualizzaDocumento(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZADOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZADOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1762509244) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idDocumentoSelezionato = theModel.getAppDataidDocumentoSelezionato();
				log.debug(" DOCUMENTI ----> VISUALIZZA DOCUMENTO ------------> idDocumentoSelezionato: "
						+ idDocumentoSelezionato);

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idDocumentoSelezionato));

				Documento documentoSelez = GenericUtil.getDocumentoById(idDocumentoSelezionato,
						theModel.getAppDataelencoDocumenti());

				theModel.getSession().put(Constants.SESSIONE_VAR_DOCUMENTO_SELEZIONATO, documentoSelez);

				//				theModel.getSession().put(Constants.SESSIONE_VAR_ID_DOCUMENTO, idDocumentoSelezionato);

				result.setResultCode(VISUALIZZADOCUMENTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inserisciDocumento definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults inserisciDocumento(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIDOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERISCIDOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R446060911) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDatadocumento(null);

			// impostazione del result code 
			result.setResultCode(INSERISCIDOCUMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inserisciDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaDocumento definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults eliminaDocumento(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINADOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ELIMINADOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-465091787) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Integer idADocumentoSelezionato = theModel.getAppDataidDocumentoSelezionato();
				log.debug(" BEPPE ----> ELIMINA DOCUMENTO ------------> idADocumentoSelezionato: "
						+ idADocumentoSelezionato);

				//controllo che abbiano selezionato un allegato
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idADocumentoSelezionato));

				if (!GenericUtil.isDocCancellabile(idADocumentoSelezionato, theModel.getAppDataelencoDocumenti())) {
					throw new ValidationManagerException(new Message(Messages.S180));

				}

				//				Ruolo ruoloUtente = theModel.getAppDatautenteLoggato().getRuolo();
				//
				//				//				DettaglioAllegato dettaglioAllegato = this.getDbMgr()
				//				//						.getDettaglioAllegatoById(idAllegatoSelezionato);
				//
				//				getValidationMgr().validazioneFormaleDocumentazioneAllegato(idADocumentoSelezionato,
				//						ruoloUtente);

				//theModel.setAppDataisAbilitazioneDatiAllegato(false);
				//lo spedisco a una maschera di conferma

				//				Message msg = new Message(Messages.C004);
				//				theModel.setAppDatamessaggioDinamico(msg.getText());

				// impostazione del result code 
				result.setResultCode(ELIMINADOCUMENTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietro definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults gestisciIndietro(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R262387507) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__OK);

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
	 * Implementazione del metodo chiudiDatiDocumento definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults chiudiDatiDocumento(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHIUDIDATIDOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-518791084) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(CHIUDIDATIDOCUMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::chiudiDatiDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaDocumento definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults caricaDocumento(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICADOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICADOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1523415007) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

				getValidationMgr().validazioneFormaleCaricaDocumentoRee(theModel.getAppDatadocumento());

				DettaglioManutenzione allegato = theModel.getAppDatadettaglioManutenzione();

				String idAllegato = allegato.getIdAllegato();

				if (log.isDebugEnabled())
					GenericUtil.stampa(allegato, true, 3);

				log.debug("inizio import xml");
				File file = theModel.getWidg_fuUploadDoc();
				if (file == null) {
					throw new ValidationManagerException(new Message("Selezionare un file"));

				} else {

					log.debug("STAMPO LA LUNGHEZZA DEL FILE: " + file.length());
					log.debug("STAMPO Integer.MAX_VALUE: " + Integer.MAX_VALUE);

					log.debug("elaborazione file");
					String nomeFile = theModel.getWidg_fuUploadDocFileName();

					// BEPPE - Ho commentato queste righe di codice perche' ricevo un'eccezione
					// E' da SCOMMENTARE!!!!!
					//if (false) // Questo if non serve, bisogna scommentare quello sopra (2 righe)
					String mimeTypeFile = getSigitMgr().getMimeTypeFile(file);
					if (!getValidationMgr().checkMimeTypeDocumento(mimeTypeFile)) {
						throw new ValidationManagerException(new Message(Messages.S095));
					} else if (nomeFile.length() > Constants.MAX_NOME_FILE_LEN) {
						throw new ValidationManagerException(
								new Message(Messages.S160, ConvertUtil.convertToString(Constants.MAX_NOME_FILE_LEN)));

					}

					Integer maxMB = getDbMgr().cercaConfigValueNumerico(Constants.MAX_MB_DOC);
					Integer maxByte = GenericUtil.getByteToMb(maxMB);

					if (file.length() > maxByte) {
						throw new ValidationManagerException(
								new Message(Messages.S156, ConvertUtil.convertToString(maxMB)));
					}

					ImportDocumentoFilter docFilter = new ImportDocumentoFilter();
					docFilter.setFile(file);
					docFilter.setCodImpianto(allegato.getCodiceImpianto());
					docFilter.setIdAllegato(idAllegato);
					docFilter.setContentType(theModel.getWidg_fuUploadDocContentType());
					//					docFilter.setIdTipoDocumento(theModel.getAppDatadocumento().getIdTipoDocumento());
					docFilter.setNomeFile(theModel.getWidg_fuUploadDocFileName());
					docFilter.setDescrizione(theModel.getAppDatadocumento().getDescAltroDoc());

					//					DettaglioIspezione ispezione = theModel.getAppDataidentificativoIspezione();
					//
					//					if (ispezione != null) {
					//						docFilter.setIdImpRuoloPfpg(ispezione.getIdIspezione());
					//					}

					boolean isManut = false;
					int idTipoDoc = allegato.getIdTipoManut();

					if (idTipoDoc == Constants.MANUTENZIONE_GT || idTipoDoc == Constants.MANUTENZIONE_GF
							|| idTipoDoc == Constants.MANUTENZIONE_SC || idTipoDoc == Constants.MANUTENZIONE_CG) {
						isManut = true;
					}

					getSigitMgr().inserisciDocumentoAllegato(docFilter, !isManut, utenteLoggato.getCodiceFiscale());

					result.getGlobalMessages().add(Messages.INFO_DOCUMENTO_IMPORTATO_CORRETTAMENTE);

					//theModel.setAppDataaggiornaElencoDocumenti(true);

					// Ricarico i documenti
					caricaElencoDocumenti(theModel);

					result.setResultCode(CARICADOCUMENTO_OUTCOME_CODE__OK);
				}
			} catch (ManagerException ex) {

				//getDbMgr().deleteImportLibretto(idImpianto);

				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaEliminaDocumento definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults salvaEliminaDocumento(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAELIMINADOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAELIMINADOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R374081172) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idDocumentoSelezionato = theModel.getAppDataidDocumentoSelezionato();

				getSigitMgr().eliminaDocumentoAllegato(idDocumentoSelezionato,
						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.INFO_ELIMINAZIONE_CORRETTA, Message.INFO));

				result.getGlobalMessages().add(Messages.INFO_ELIMINAZIONE_CORRETTA);

				caricaElencoDocumenti(theModel);

				theModel.setAppDataidDocumentoSelezionato(null);
				//theModel.setAppDatamessaggioDinamico(null);

				result.setResultCode(SALVAELIMINADOCUMENTO_OUTCOME_CODE__OK);

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
			log.error("[BackEndFacade::salvaEliminaDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-377757296) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isUtenteAutorLibWebScheda15(utente)) {
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
	 * Implementazione del metodo cercaComponenteDett definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults cercaComponenteDett(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCACOMPONENTEDETT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R488099625) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataelencoTipoManutenzione() == null) {
				theModel.setAppDataelencoTipoManutenzione(getDbMgr().cercaListaTipiManutenzione());
			}

			// Queste due combo le ricarico perche' in altri punti dell'applicativo hanno un significato diverso
			theModel.setAppDataelencoTipoIntervento(getDbMgr().cercaListaTipiIntervento());

			// Se sono in modifica devo carica l'elenco dei documenti
			boolean isNuovoComp = theModel.getAppDataisNuovoComponente();

			log.debug("cpGestLibScheda15Dett - isNuovoComp: " + isNuovoComp);
			log.debug("cpGestLibScheda15Dett - rigaSelezionata: " + theModel.getAppDatarigaSelezionata());

			DettaglioManutenzione dettaglio = null;
			if (isNuovoComp) {

				dettaglio = new DettaglioManutenzione();
				dettaglio.setCodiceImpianto(theModel.getAppDataidImpiantoSelez());

				Ruolo profiloUtente = theModel.getAppDatautenteLoggato().getRuolo();

				if (Constants.RUOLO_IMPRESA.equalsIgnoreCase(profiloUtente.getDescRuolo())) {
					dettaglio.setIdPersonaGiuridica(profiloUtente.getIdPersonaGiuridica());

					String manutentore = profiloUtente.getDenomDitta() + " "
							+ MapDto.getCodiceRea(profiloUtente.getSiglaRea(), profiloUtente.getNumeroRea());
					dettaglio.setDescManutentore(manutentore);

				}

				theModel.setAppDatadettaglioManutenzione(dettaglio);

			} else {
				dettaglio = getSigitMgr().cercaDettaglioManutenzioneById(theModel.getAppDatarigaSelezionata());

				if (log.isDebugEnabled())
					GenericUtil.stampa(dettaglio, true, 3);

				// Devo settare in questo punto, perche' questo dato verra' usato dal metodo caricaElencoDocumenti
				theModel.setAppDatadettaglioManutenzione(dettaglio);

				caricaElencoDocumenti(theModel);
			}

			// impostazione del result code 
			result.setResultCode(CERCACOMPONENTEDETT_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaComponenteDett] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciVisibilita definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults gestisciVisibilita(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVISIBILITA_OUTCOME_CODE__SCRITTURA = //NOSONAR  Reason:EIAS
				"SCRITTURA"; //NOSONAR  Reason:EIAS
		final String GESTISCIVISIBILITA_OUTCOME_CODE__LETTURA = //NOSONAR  Reason:EIAS
				"LETTURA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R32465423) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			boolean isNuovoComp = theModel.getAppDataisNuovoComponente();

			if (isNuovoComp) {
				// impostazione del result code 
				result.setResultCode(GESTISCIVISIBILITA_OUTCOME_CODE__SCRITTURA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCIVISIBILITA_OUTCOME_CODE__LETTURA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciVisibilita] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciTipoIntAltroInit definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults gestisciTipoIntAltroInit(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCITIPOINTALTROINIT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTISCITIPOINTALTROINIT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1034253806) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioManutenzione dettaglioAllegato = theModel.getAppDatadettaglioManutenzione();

			if (dettaglioAllegato != null && dettaglioAllegato.getIdTipoIntervento() != null
					&& dettaglioAllegato.getIdTipoIntervento() == Constants.ID_TIPO_MANUTENZIONE_ALTRO) {
				// impostazione del result code 
				result.setResultCode(GESTISCITIPOINTALTROINIT_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCITIPOINTALTROINIT_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciTipoIntAltroInit] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciMsg definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda15Dett
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1835354254) ENABLED START*/
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
	 * permette di resettare lo stato di paginazione della tabella widg_tblElencoDocumenti
	 */
	public static void resetClearStatus_widg_tblElencoDocumenti(java.util.Map session) {
		session.put("cpGestLibScheda15Dett_tblElencoDocumenti_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1498297931) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

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

	private void caricaElencoDocumenti(
			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel theModel)
			throws ManagerException {

		try {
			log.debug("Carico l'elenco dei documenti");

			String idManutenzione = theModel.getAppDatadettaglioManutenzione().getIdAllegato();

			log.debug("caricaElencoDocumenti - idManutenzione: " + idManutenzione);

			ArrayList<Documento> documenti = getSigitMgr().cercaDocumentiPerIdAllegato(idManutenzione);

			if (documenti != null) {
				theModel.setAppDataelencoDocumenti(documenti);
			}
			resetClearStatus_widg_tblElencoDocumenti(theModel.getSession());

			log.debug("CaricaElencoAllegati: END");
		} catch (ManagerException e) {
			log.error("Errore: ", e);
			throw e;
		}

	}
	/*PROTECTED REGION END*/
}
