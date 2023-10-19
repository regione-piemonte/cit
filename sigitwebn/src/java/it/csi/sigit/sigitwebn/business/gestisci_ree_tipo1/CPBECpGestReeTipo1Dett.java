package it.csi.sigit.sigitwebn.business.gestisci_ree_tipo1;

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

/*PROTECTED REGION ID(R-1672014087) ENABLED START*/
import it.csi.custom.component.tree.base.TreeNode;

import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTConsumoTipo1BDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettTipo1Dto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTRappTipo1Dto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVSk4GtDto;
import it.csi.sigit.sigitwebn.util.enumutil.CondottoEvacuazioneFumiTipo1BEnum;
import it.csi.sigit.sigitwebn.util.enumutil.TipologiaTipo1BEnum;

/*PROTECTED REGION END*/

public class CPBECpGestReeTipo1Dett {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [reeMenuTree, scope:USER_SESSION]
	public static final String APPDATA_REEMENUTREE_CODE = "appDatareeMenuTree";

	// ApplicationData: [allegato, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATO_CODE = "appDataallegato";

	// ApplicationData: [reeTipo1, scope:USER_SESSION]
	public static final String APPDATA_REETIPO1_CODE = "appDatareeTipo1";

	// ApplicationData: [reeTipo1Dett, scope:USER_SESSION]
	public static final String APPDATA_REETIPO1DETT_CODE = "appDatareeTipo1Dett";

	// ApplicationData: [progressivoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_PROGRESSIVOSELEZIONATO_CODE = "appDataprogressivoSelezionato";

	// ApplicationData: [reeTipo1DettModulo, scope:USER_SESSION]
	public static final String APPDATA_REETIPO1DETTMODULO_CODE = "appDatareeTipo1DettModulo";

	// ApplicationData: [portataCombustibile, scope:USER_SESSION]
	public static final String APPDATA_PORTATACOMBUSTIBILE_CODE = "appDataportataCombustibile";

	// ApplicationData: [moduloSelezionato, scope:USER_SESSION]
	public static final String APPDATA_MODULOSELEZIONATO_CODE = "appDatamoduloSelezionato";

	// ApplicationData: [elencoModuli, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMODULI_CODE = "appDataelencoModuli";

	// ApplicationData: [ricaricaPagina, scope:USER_SESSION]
	public static final String APPDATA_RICARICAPAGINA_CODE = "appDataricaricaPagina";

	// ApplicationData: [elencoStelle, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTELLE_CODE = "appDataelencoStelle";

	// ApplicationData: [elencoTipo1B, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPO1B_CODE = "appDataelencoTipo1B";

	// ApplicationData: [elencoAriaComburente, scope:USER_SESSION]
	public static final String APPDATA_ELENCOARIACOMBURENTE_CODE = "appDataelencoAriaComburente";

	// ApplicationData: [elencoCaricamentoCombustibile, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCARICAMENTOCOMBUSTIBILE_CODE = "appDataelencoCaricamentoCombustibile";

	// ApplicationData: [elencoControlloAriaComburente, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCONTROLLOARIACOMBURENTE_CODE = "appDataelencoControlloAriaComburente";

	// ApplicationData: [elencoConsumiTipo1B, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCONSUMITIPO1B_CODE = "appDataelencoConsumiTipo1B";

	// ApplicationData: [tipo1BConsumiSelezionati, scope:USER_SESSION]
	public static final String APPDATA_TIPO1BCONSUMISELEZIONATI_CODE = "appDatatipo1BConsumiSelezionati";

	// ApplicationData: [tipo1BConsumiDaCancellare, scope:USER_SESSION]
	public static final String APPDATA_TIPO1BCONSUMIDACANCELLARE_CODE = "appDatatipo1BConsumiDaCancellare";

	// ApplicationData: [elencoUnitaMisuraREE, scope:USER_SESSION]
	public static final String APPDATA_ELENCOUNITAMISURAREE_CODE = "appDataelencoUnitaMisuraREE";

	// ApplicationData: [elencoCondottoEvacuazioneFumiTipo1B, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCONDOTTOEVACUAZIONEFUMITIPO1B_CODE = "appDataelencoCondottoEvacuazioneFumiTipo1B";

	// ApplicationData: [elencoTipologiaTipo1B, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOLOGIATIPO1B_CODE = "appDataelencoTipologiaTipo1B";

	// ApplicationData: [elencoREEPresenteAssente, scope:USER_SESSION]
	public static final String APPDATA_ELENCOREEPRESENTEASSENTE_CODE = "appDataelencoREEPresenteAssente";

	// ApplicationData: [elencoNaturaleForzata, scope:USER_SESSION]
	public static final String APPDATA_ELENCONATURALEFORZATA_CODE = "appDataelencoNaturaleForzata";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestReeTipo1Dett";

	public static final String MULTIPANEL_MPREETIPO1TITLE = "mpReeTipo1Title";
	public static final String MPI_MPREETIPO1TITLE_FPGESTREETITLETIPO1 = CPNAME + "_" + MULTIPANEL_MPREETIPO1TITLE + "_"
			+ "fpGestReeTitleTipo1";

	public static final String MULTIPANEL_MPREETIPO1BTITLE = "mpReeTipo1BTitle";
	public static final String MPI_MPREETIPO1BTITLE_FPGESTREETITLETIPO1B = CPNAME + "_" + MULTIPANEL_MPREETIPO1BTITLE
			+ "_" + "fpGestReeTitleTipo1B";

	public static final String MULTIPANEL_MPCONSUMOCOMBUSTIBILE = "mpConsumoCombustibile";
	public static final String MPI_MPCONSUMOCOMBUSTIBILE_FPCONSUMOCOMBUSTIBILE = CPNAME + "_"
			+ MULTIPANEL_MPCONSUMOCOMBUSTIBILE + "_" + "fpConsumoCombustibile";

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
	 * ContentPanel cpGestReeTipo1Dett
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONTREECLICK_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SEZIONE_ABCDF = //NOSONAR  Reason:EIAS
				"SEZIONE_ABCDF"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SEZIONE_E = //NOSONAR  Reason:EIAS
				"SEZIONE_E"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R933365419) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String ret = null;

			String clickedNodeId = theModel.getIdNodo();

			log.debug("Ho premuto theModel.getAppDatareeMenuTree(): " + theModel.getAppDatareeMenuTree());
			log.debug("Ho premuto clickedNodeId: " + clickedNodeId);

			// recupero il nodo corrispondente all'ID
			TreeNode clickedNode = theModel.getAppDatareeMenuTree().getChildren(clickedNodeId);

			log.debug("HO PREMUTO il NODO: CLICKED NODE: " + clickedNodeId + " ("
					+ (clickedNode != null ? clickedNode.getDescription() : "") + ")");

			if (clickedNodeId.equals("F-tipo1")) {
				// impostazione del result code 
				ret = ONTREECLICK_OUTCOME_CODE__SEZIONE_ABCDF;
			} else if (clickedNodeId.startsWith(Constants.PREFIX_ID_NODO_TIPO_1_E)) {
				// impostazione del result code 
				ret = ONTREECLICK_OUTCOME_CODE__SEZIONE_E;

				// devo salvare il progressivo
				String progr = clickedNodeId.substring(Constants.PREFIX_ID_NODO_TIPO_1_E.length());
				theModel.setAppDataprogressivoSelezionato(ConvertUtil.convertToInteger(progr));

				log.debug("Il progressivo trovato e': " + progr);

				// Devo forzare il caricamento della pagina (perchè non c'è un cambio di CP)
				theModel.setAppDataricaricaPagina(true);

			} else {
				ret = ONTREECLICK_OUTCOME_CODE__KO;
			}

			log.debug("Stampo il resultCod - cpGestReeTipo1Dett: " + ret);

			// Setto la pagina in cui sto andando, mi servirà nel caso ci sia necessità di ricaricare la pagina con un messaggio (es. invia allegato)
			theModel.getSession().put(Constants.SESSIONE_VAR_ALLEGATO_SEZIONE, ret);

			result.setResultCode(ret);

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
	 * Implementazione del metodo aggiungiConsumoCombustibile definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo1Dett
	 */
	public ExecResults aggiungiConsumoCombustibile(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIUNGICONSUMOCOMBUSTIBILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-16199649) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			ArrayList<Tipo1Consumo> consumi = theModel.getAppDataelencoConsumiTipo1B();

			if (consumi == null) {
				consumi = new ArrayList<Tipo1Consumo>();
			}

			Tipo1Consumo consumoNew = new Tipo1Consumo();
			consumoNew.setIdTipoConsumo(Constants.ID_TIPO_CONSUMO_1B_CONSUMO_BIOMASSA);
			// Se l'utente ha potuto fare "aggiungi riga" vuol dire che ï¿½ abilitato alla compilazione
			consumoNew.setIndice(consumi.size() + 1);

			consumi.add(consumoNew);
			theModel.setAppDataelencoConsumiTipo1B(consumi);

			// impostazione del result code 
			result.setResultCode(AGGIUNGICONSUMOCOMBUSTIBILE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::aggiungiConsumoCombustibile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo rimuoviConsumoCombustibile definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo1Dett
	 */
	public ExecResults rimuoviConsumoCombustibile(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RIMUOVICONSUMOCOMBUSTIBILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1675430357) ENABLED START*/

			ArrayList<Tipo1Consumo> consumi = theModel.getAppDataelencoConsumiTipo1B();

			ArrayList<Integer> tipo1BConsumiDaCancellare = theModel.getAppDatatipo1BConsumiDaCancellare();

			if (tipo1BConsumiDaCancellare == null) {
				tipo1BConsumiDaCancellare = new ArrayList<Integer>();
			}

			if (theModel.getAppDatatipo1BConsumiSelezionati() == null
					|| theModel.getAppDatatipo1BConsumiSelezionati().isEmpty()) {
				result.getGlobalErrors().add(Messages.ERROR_SELEZIONARE_RIGA);
			} else {
				ArrayList<Tipo1Consumo> newDtos = new ArrayList<>();
				if (consumi != null) {
					for (Tipo1Consumo oldDtos : consumi) {
						if (!theModel.getAppDatatipo1BConsumiSelezionati().contains(oldDtos.getIndice().toString())) {
							oldDtos.setIndice(newDtos.size() + 1);
							newDtos.add(oldDtos);
						} else {
							tipo1BConsumiDaCancellare.add(oldDtos.getIdConsumo());
						}
					}

					theModel.setAppDataelencoConsumiTipo1B(newDtos);
				}
				theModel.setAppDatatipo1BConsumiSelezionati(null);
			}

			theModel.setAppDatatipo1BConsumiDaCancellare(tipo1BConsumiDaCancellare);

			resetClearStatus_widg_tbConsumoCombustibile(theModel.getSession());

			// impostazione del result code 
			result.setResultCode(RIMUOVICONSUMOCOMBUSTIBILE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::rimuoviConsumoCombustibile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaModulo definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo1Dett
	 */
	public ExecResults caricaModulo(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAMODULO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2120334151) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioAllegato dettAll = theModel.getAppDataallegato();

			log.debug("theModel.getAppDatamoduloSelezionato(): " + theModel.getAppDatamoduloSelezionato());

			// Devo recuperare il modulo selezionato
			Tipo1DettModulo modulo = recuperaModuloSelez(dettAll.getCodiceImpianto(), dettAll.getIdAllegato(),
					theModel.getAppDataprogressivoSelezionato(), theModel.getAppDatamoduloSelezionato());

			theModel.setAppDatareeTipo1DettModulo(modulo);

			// impostazione del result code 
			result.setResultCode(CARICAMODULO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaModulo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaReeDett definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo1Dett
	 */
	public ExecResults salvaReeDett(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAREEDETT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAREEDETT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1399331656) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				DettaglioAllegato allegato = theModel.getAppDataallegato();
				String idTipoAllegato = allegato.getIdTipoAllegato();

				Tipo1Dett tipo1Dett = theModel.getAppDatareeTipo1Dett();
				tipo1Dett.setConsumiCombustibile(theModel.getAppDataelencoConsumiTipo1B());
				Tipo1DettModulo tipo1DettModulo = theModel.getAppDatareeTipo1DettModulo();

				ArrayList<Integer> consumiTipo1DaCancellare = theModel.getAppDatatipo1BConsumiDaCancellare();
				List<SigitVSk4GtDto> compGtListAllegato = null;

				if (idTipoAllegato.equals(Constants.ALLEGATO_TIPO_1B)) {
					compGtListAllegato = getDbMgr()
							.getCompGtByIdAllegato(ConvertUtil.convertToInteger(allegato.getIdAllegato()));
				}

				// verifico che abbia compilato la scheda
				getValidationMgr().validazioneFormaleReeTipo1Dett(tipo1Dett, idTipoAllegato, result);

				//la valida
				getValidationMgr().validazioneFormaleReeTipo1DettModulo(tipo1DettModulo, tipo1Dett.getIdCombustibile(),
						idTipoAllegato, compGtListAllegato);

				getDbMgr().salvaReeTipo1Dett(tipo1Dett, tipo1DettModulo, consumiTipo1DaCancellare,
						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				List<SigitTConsumoTipo1BDto> consumiCombustibile = getDbMgr().findConsumiTipo1ByIdAllegatoIdTipoConsumo(
						ConvertUtil.convertToBigDecimal(allegato.getIdAllegato()),
						Constants.ID_TIPO_CONSUMO_1B_CONSUMO_BIOMASSA);
				tipo1Dett.setConsumiCombustibile(MapDto.mapListToTipo1ConsumoList(consumiCombustibile));

				theModel.setAppDatareeTipo1Dett(tipo1Dett);
				theModel.setAppDataelencoConsumiTipo1B(tipo1Dett.getConsumiCombustibile());

				// recupero nuovamente i dati per aggiornare la lista da compilare
				List<SigitTDettTipo1Dto> tDettTipo1List = getDbMgr().getDettTipo1(
						ConvertUtil.convertToString(tipo1Dett.getCodImpianto()),
						theModel.getAppDataprogressivoSelezionato(),
						ConvertUtil.convertToString(tipo1Dett.getIdAllegato()));

				tipo1Dett = MapDto.mapToTipo1Dett(tipo1Dett, tDettTipo1List);

				theModel.setAppDatareeTipo1Dett(tipo1Dett);

				result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);

				// impostazione del result code 
				result.setResultCode(SALVAREEDETT_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaReeDett] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo1Dett
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__ELENCO_ALLEGATI_IMPIANTO = //NOSONAR  Reason:EIAS
				"ELENCO_ALLEGATI_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RISULTATO_RICERCA_ALLEGATI = //NOSONAR  Reason:EIAS
				"RISULTATO_RICERCA_ALLEGATI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1330964796) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(GenericUtil.gestisciTreeReeIndietro(theModel.getAppDataallegato().getArrivoDa()));

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
	 * ContentPanel cpGestReeTipo1Dett
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1242026726) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoReeWEB(utente)) {
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
	 * Implementazione del metodo caricaReeTipo1Dett definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo1Dett
	 */
	public ExecResults caricaReeTipo1Dett(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAREETIPO1DETT_OUTCOME_CODE__TIPO1 = //NOSONAR  Reason:EIAS
				"TIPO1"; //NOSONAR  Reason:EIAS
		final String CARICAREETIPO1DETT_OUTCOME_CODE__TIPO1B = //NOSONAR  Reason:EIAS
				"TIPO1B"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-294231229) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// Setto le combo
			theModel.setAppDataportataCombustibile(GenericUtil.getComboPortataCombustibile());

			if (theModel.getAppDataelencoStelle() == null) {
				theModel.setAppDataelencoStelle(getSigitMgr().getIdDescriptionStelle());
			}

			if (theModel.getAppDataelencoTipo1B() == null) {
				theModel.setAppDataelencoTipo1B(getSigitMgr().getIdDescriptionTipo1B());
			}

			if (theModel.getAppDataelencoAriaComburente() == null) {
				theModel.setAppDataelencoAriaComburente(getSigitMgr().getIdDescriptionAriaComburente());
			}

			if (theModel.getAppDataelencoControlloAriaComburente() == null) {
				theModel.setAppDataelencoControlloAriaComburente(getSigitMgr().getIdDescriptionControlloAria());
			}

			if (theModel.getAppDataelencoCaricamentoCombustibile() == null) {
				theModel.setAppDataelencoCaricamentoCombustibile(getSigitMgr().getIdDescriptionTipoCaricCombu());
			}

			if (theModel.getAppDataelencoUnitaMisuraREE() == null) {
				theModel.setAppDataelencoUnitaMisuraREE(getSigitMgr().getListUnitaMisura());
			}

			if (theModel.getAppDataelencoREEPresenteAssente() == null) {
				theModel.setAppDataelencoREEPresenteAssente(GenericUtil.getComboIdPresenteAssente());
			}

			if (theModel.getAppDataelencoNaturaleForzata() == null) {
				theModel.setAppDataelencoNaturaleForzata(GenericUtil.getComboNaturaleForzata());
			}

			if (theModel.getAppDataelencoTipologiaTipo1B() == null) {
				theModel.setAppDataelencoTipologiaTipo1B(getComboTipologiaTipo1B());
			}

			if (theModel.getAppDataelencoCondottoEvacuazioneFumiTipo1B() == null) {
				theModel.setAppDataelencoCondottoEvacuazioneFumiTipo1B(getComboCondottoEvacuazioneFumiTipo1B());
			}

			caricaDettaglio(theModel);

			DettaglioAllegato dettaglioAllegato = theModel.getAppDataallegato();

			// impostazione del result code 
			if (dettaglioAllegato.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_1B)) {
				result.setResultCode(CARICAREETIPO1DETT_OUTCOME_CODE__TIPO1B);
			} else {
				result.setResultCode(CARICAREETIPO1DETT_OUTCOME_CODE__TIPO1);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaReeTipo1Dett] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciRicaricaPagina definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo1Dett
	 */
	public ExecResults gestisciRicaricaPagina(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIRICARICAPAGINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-435919613) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Boolean isRicarica = theModel.getAppDataricaricaPagina();

			if (ConvertUtil.convertToBooleanAllways(isRicarica)) {
				caricaDettaglio(theModel);

				theModel.setAppDataricaricaPagina(false);
			}

			// impostazione del result code 
			result.setResultCode(GESTISCIRICARICAPAGINA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciRicaricaPagina] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciMsg definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo1Dett
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R869691076) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			GenericUtil.gestisciMessaggioSessione(theModel, result);
			/*
			Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);
			if (msg != null) {
				if (msg.getType() == Message.ERROR)
					result.getGlobalErrors().add(msg.getText());
				else
					result.getGlobalMessages().add(msg.getText());
			
				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
			}
			*/

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
	 * permette di resettare lo stato di paginazione della tabella widg_tbConsumoCombustibile
	 */
	public static void resetClearStatus_widg_tbConsumoCombustibile(java.util.Map session) {
		session.put("cpGestReeTipo1Dett_tbConsumoCombustibile_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R666726875) ENABLED START*/
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

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	private Tipo1DettModulo recuperaModuloSelez(String codImpianto, String idAllegato, Integer progressivo,
			String moduloSelez) throws ManagerException {
		Tipo1DettModulo modulo = getSigitMgr().caricaDatiReeTipo1DettModulo(codImpianto, idAllegato, progressivo,
				ConvertUtil.convertToInteger(moduloSelez));

		return modulo;
	}

	private void caricaDettaglio(it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1DettModel theModel)
			throws Exception {
		try {
			DettaglioAllegato dettAll = theModel.getAppDataallegato();

			Tipo1Dett tipo1Dett = getSigitMgr().caricaDatiReeTipo1Dett(dettAll.getIdAllegato(),
					theModel.getAppDataprogressivoSelezionato());

			List<SigitTDettTipo1Dto> tDettTipo1List = getDbMgr().getDettTipo1(dettAll.getCodiceImpianto(),
					theModel.getAppDataprogressivoSelezionato(), dettAll.getIdAllegato());

			tipo1Dett = MapDto.mapToTipo1Dett(tipo1Dett, tDettTipo1List);

			theModel.setAppDatareeTipo1Dett(tipo1Dett);
			theModel.setAppDataelencoConsumiTipo1B(tipo1Dett.getConsumiCombustibile());

			// Setto la combo dei moduli
			ArrayList<CodeDescription> moduliList = MapDto.mapToModuli(tDettTipo1List);
			theModel.setAppDataelencoModuli(moduliList);

			// Setto come default il primo modulo
			String moduloDefault = moduliList.get(0).getCode();

			theModel.setAppDatamoduloSelezionato(moduloDefault);

			// Devo recuperare il modulo selezionato
			Tipo1DettModulo modulo = recuperaModuloSelez(ConvertUtil.convertToString(tipo1Dett.getCodImpianto()),
					ConvertUtil.convertToString(tipo1Dett.getIdAllegato()),
					ConvertUtil.convertToInteger(tipo1Dett.getProgressivo()), moduloDefault);
			theModel.setAppDatareeTipo1DettModulo(modulo);
		} catch (Exception e) {
			throw e;
		}
	}

	private ArrayList<IdDescription> getComboTipologiaTipo1B() {

		return GenericUtil.getComboIdValues(TipologiaTipo1BEnum.class.getName());
	}

	private ArrayList<IdDescription> getComboCondottoEvacuazioneFumiTipo1B() {

		return GenericUtil.getComboIdValues(CondottoEvacuazioneFumiTipo1BEnum.class.getName());
	}

	/*PROTECTED REGION END*/
}
