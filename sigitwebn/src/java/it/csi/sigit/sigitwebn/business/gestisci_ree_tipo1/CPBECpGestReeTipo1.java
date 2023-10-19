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

/*PROTECTED REGION ID(R751441402) ENABLED START*/

import it.csi.sigit.sigitwebn.xml.allegato2.data.RowAllegatoIIDocument.RowAllegatoII;

import java.math.BigDecimal;

import it.csi.custom.component.tree.base.TreeNode;
import it.csi.custom.component.tree.base.TreeNodeBase;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllTxtDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTConsumoTipo1BDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTRappTipo1Dto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTTrattH2ODto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTTrattH2OPk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTUnitaImmobiliareDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVSk4GtDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVTotImpiantoDto;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;

/*PROTECTED REGION END*/

public class CPBECpGestReeTipo1 {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [reeMenuTree, scope:USER_SESSION]
	public static final String APPDATA_REEMENUTREE_CODE = "appDatareeMenuTree";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [allegato, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATO_CODE = "appDataallegato";

	// ApplicationData: [reeTipo1, scope:USER_SESSION]
	public static final String APPDATA_REETIPO1_CODE = "appDatareeTipo1";

	// ApplicationData: [progressivoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_PROGRESSIVOSELEZIONATO_CODE = "appDataprogressivoSelezionato";

	// ApplicationData: [tipo1BConsumiSelezionati, scope:USER_SESSION]
	public static final String APPDATA_TIPO1BCONSUMISELEZIONATI_CODE = "appDatatipo1BConsumiSelezionati";

	// ApplicationData: [tipo1BConsumiDaCancellare, scope:USER_SESSION]
	public static final String APPDATA_TIPO1BCONSUMIDACANCELLARE_CODE = "appDatatipo1BConsumiDaCancellare";

	// ApplicationData: [elencoConsumiTipo1B, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCONSUMITIPO1B_CODE = "appDataelencoConsumiTipo1B";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestReeTipo1";

	public static final String MULTIPANEL_MPREETIPO1TITLE = "mpReeTipo1Title";
	public static final String MPI_MPREETIPO1TITLE_FPGESTREETITLETIPO1 = CPNAME + "_" + MULTIPANEL_MPREETIPO1TITLE + "_"
			+ "fpGestReeTitleTipo1";

	public static final String MULTIPANEL_MPREETIPO1BTITLE = "mpReeTipo1BTitle";
	public static final String MPI_MPREETIPO1BTITLE_FPGESTREETITLETIPO1B = CPNAME + "_" + MULTIPANEL_MPREETIPO1BTITLE
			+ "_" + "fpGestReeTitleTipo1B";

	public static final String MULTIPANEL_MPACQUAREINTEGRO = "mpAcquaReintegro";
	public static final String MPI_MPACQUAREINTEGRO_FPACQUAREINTEGRO = CPNAME + "_" + MULTIPANEL_MPACQUAREINTEGRO + "_"
			+ "fpAcquaReintegro";

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
	 * ContentPanel cpGestReeTipo1
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1Model theModel

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
			/*PROTECTED REGION ID(R-997787540) ENABLED START*/
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

				log.debug("Il progressivo trovato e': " + progr);

				theModel.setAppDataprogressivoSelezionato(ConvertUtil.convertToInteger(progr));

			} else {
				ret = ONTREECLICK_OUTCOME_CODE__KO;
			}

			log.debug("Stampo il resultCod - cpGestReeTipo1: " + ret);

			result.setResultCode(ret);

			// Setto la pagina in cui sto andando, mi servir� nel caso ci sia necessit� di ricaricare la pagina con un messaggio (es. invia allegato)
			theModel.getSession().put(Constants.SESSIONE_VAR_ALLEGATO_SEZIONE, ret);

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
	 * Implementazione del metodo aggiungiAcquaReintegro definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo1
	 */
	public ExecResults aggiungiAcquaReintegro(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIUNGIACQUAREINTEGRO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R38274014) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			ArrayList<Tipo1Consumo> consumi = theModel.getAppDataelencoConsumiTipo1B();

			if (consumi == null) {
				consumi = new ArrayList<Tipo1Consumo>();
			}

			Tipo1Consumo consumoNew = new Tipo1Consumo();
			consumoNew.setIdTipoConsumo(Constants.ID_TIPO_CONSUMO_1B_ACQUA_REINTEGRO);
			consumoNew.setIdUnitaMisura(Constants.ID_UNITA_MISURA_LITRI);

			// Se l'utente ha potuto fare "aggiungi riga" vuol dire che � abilitato alla compilazione
			consumoNew.setIndice(consumi.size() + 1);

			consumi.add(consumoNew);
			theModel.setAppDataelencoConsumiTipo1B(consumi);

			// impostazione del result code 
			result.setResultCode(AGGIUNGIACQUAREINTEGRO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::aggiungiAcquaReintegro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo rimuoviAcquaReintegro definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo1
	 */
	public ExecResults rimuoviAcquaReintegro(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RIMUOVIACQUAREINTEGRO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1006083892) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

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

			resetClearStatus_widg_tbAcquaReintegro(theModel.getSession());

			// impostazione del result code 
			result.setResultCode(RIMUOVIACQUAREINTEGRO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::rimuoviAcquaReintegro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaRee definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo1
	 */
	public ExecResults salvaRee(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAREE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAREE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1106190168) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Tipo1 tipo1 = theModel.getAppDatareeTipo1();
			tipo1.setConsumi(theModel.getAppDataelencoConsumiTipo1B());

			if (log.isDebugEnabled())
				GenericUtil.stampa(tipo1, true, 3);

			DettaglioAllegato dettaglioAllegato = theModel.getAppDataallegato();

			ArrayList<Integer> consumiTipo1DaCancellare = theModel.getAppDatatipo1BConsumiDaCancellare();

			try {
				// verifico che abbia compilato la scheda
				getValidationMgr().validazioneFormaleReeTipo1(tipo1, dettaglioAllegato, result);

				getDbMgr().salvaReeTipo1(tipo1, dettaglioAllegato, consumiTipo1DaCancellare,
						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				List<SigitTConsumoTipo1BDto> consumoTipo1BList = getDbMgr().findConsumiTipo1ByIdAllegatoIdTipoConsumo(
						ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()),
						Constants.ID_TIPO_CONSUMO_1B_ACQUA_REINTEGRO);

				tipo1.setConsumi(MapDto.mapListToTipo1ConsumoList(consumoTipo1BList));

				theModel.setAppDataelencoConsumiTipo1B(tipo1.getConsumi());
				theModel.setAppDatareeTipo1(tipo1);

				result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);

				// impostazione del result code 
				result.setResultCode(SALVAREE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaRee] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo1
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__ELENCO_ALLEGATI_IMPIANTO = //NOSONAR  Reason:EIAS
				"ELENCO_ALLEGATI_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RISULTATO_RICERCA_ALLEGATI = //NOSONAR  Reason:EIAS
				"RISULTATO_RICERCA_ALLEGATI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1289515485) ENABLED START*/
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
	 * ContentPanel cpGestReeTipo1
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R551103481) ENABLED START*/
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
	 * Implementazione del metodo caricaReeTipo1 definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo1
	 */
	public ExecResults caricaReeTipo1(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAREETIPO1_OUTCOME_CODE__TIPO1 = //NOSONAR  Reason:EIAS
				"TIPO1"; //NOSONAR  Reason:EIAS
		final String CARICAREETIPO1_OUTCOME_CODE__TIPO1B = //NOSONAR  Reason:EIAS
				"TIPO1B"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1343195101) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();
			DettaglioAllegato allegato = theModel.getAppDataallegato();

			log.debug("caricaReeTipo1");

			if (log.isDebugEnabled())
				GenericUtil.stampa(allegato, true, 3);

			GenericUtil.gestisciMessaggioSessione(theModel, result);

			String idAllegato = null;
			boolean isAllegatoInInsert = false;

			if (GenericUtil.isNullOrEmpty(allegato.getIdAllegato())) {
				log.debug(" STOOOOOOOOOO INSERENDOOOOOOOOOOOOOO");
				//salvo sulla tabella SIGIT_T_ALLEGATO una parte di dati, quelli che arrivano dal client e il pdf

				BigDecimal idAllegatoNuovo = getSigitMgr().salvaAllegatoTrans(allegato, utenteLoggato);

				idAllegato = ConvertUtil.convertToString(idAllegatoNuovo);
				allegato.setIdAllegato(idAllegato);
				isAllegatoInInsert = true;
			}

			Tipo1 tipo1 = getSigitMgr().getAllegatoTipo1(allegato);

			theModel.setAppDataelencoConsumiTipo1B(tipo1.getConsumi());
			theModel.setAppDatareeTipo1(tipo1);

			// impostazione del result code 
			if (allegato.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_1B)) {
				result.setResultCode(CARICAREETIPO1_OUTCOME_CODE__TIPO1B);
			} else {
				result.setResultCode(CARICAREETIPO1_OUTCOME_CODE__TIPO1);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaReeTipo1] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaMenuTipo1 definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo1
	 */
	public ExecResults caricaMenuTipo1(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAMENUTIPO1_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R746919916) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioAllegato allegato = theModel.getAppDataallegato();

			//theModel.getAppDatareeTipo1();

			if (log.isDebugEnabled())
				GenericUtil.stampa(allegato, true, 3);

			if (theModel.getAppDatareeMenuTree() == null) {
				// creo il nodo root del tree
				TreeNode root = new TreeNodeBase("root", "root", false);
				//TreeNode root = new TreeNodeBase("root", "root", false, "root", true);
				//root.setExpanded(true);

				// Aggiungo la cartella "Libretto"
				String librettoNodeId = "R-tipo1";

				String nodeLabel = "REE Rapporto di Efficienza Energetica Tipo 1";

				if (allegato.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_1B)) {
					nodeLabel += "B";
				}

				TreeNodeBase libNode = new TreeNodeBase(librettoNodeId, nodeLabel, false);
				libNode.setOpened(true);
				root.getChildren().add(libNode);

				/////////////////////////////////////////////////////
				// REE tipo 1

				// Aggiungo la sottoscheda (foglio)
				TreeNodeBase sottoSchedaNode = new TreeNodeBase("F-tipo1", Constants.LABEL_SEZIONE_ABCDF, true);
				root.getChildren(librettoNodeId).getChildren().add(sottoSchedaNode);
				//allegato.getElencoApparecchiature()
				// Devo ciclare per tutte le componenti selezionate
				List<String> idCompProgressiviList = allegato.getIdApparecchiatureFunz();
				for (String idCompProgressivo : idCompProgressiviList) {
					//					sottoSchedaNode = new TreeNodeBase(Constants.PREFIX_ID_NODO_TIPO_1_E + idCompProgressivo,
					//							Constants.LABEL_SEZIONE_E + " - " + Constants.TIPO_COMPONENTE_GT + "-" + idCompProgressivo, true);

					sottoSchedaNode = new TreeNodeBase(Constants.PREFIX_ID_NODO_TIPO_1_E + idCompProgressivo,
							GenericUtil.getDescSezioneEComp(Constants.TIPO_COMPONENTE_GT, idCompProgressivo), true);

					root.getChildren(librettoNodeId).getChildren().add(sottoSchedaNode);
				}

				// aggiungo il tree al modello
				theModel.setAppDatareeMenuTree(root);

				// Setto la pagina in cui sto andando, mi servir� nel caso ci sia necessit� di ricaricare la pagina con un messaggio (es. invia allegato)
				theModel.getSession().put(Constants.SESSIONE_VAR_ALLEGATO_SEZIONE, "SEZIONE_ABCDF");

				/*
				
				
				// aggiungo le varie voci
				String schedaNodeId = "scheda1";
				TreeNodeBase menuNode = new TreeNodeBase(schedaNodeId,
						"1.scheda identificativa", true);
				root.getChildren().add(menuNode);
				
				schedaNodeId = "scheda2";
				menuNode = new TreeNodeBase(schedaNodeId,
						"2.trattamento acqua", true);
				root.getChildren().add(menuNode);
				
				schedaNodeId = "scheda14_1";
				menuNode = new TreeNodeBase(schedaNodeId,
						"14.1.consumo di combustibile", true);
				root.getChildren().add(menuNode);
				
				// aggiungo il tree al modello
				theModel.setAppDatalibrettoMenuTree(root);
				 */
			}

			// impostazione del result code 
			result.setResultCode(CARICAMENUTIPO1_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaMenuTipo1] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciMsg definito in un ExecCommand del
	 * ContentPanel cpGestReeTipo1
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1.CpGestReeTipo1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1061461883) ENABLED START*/
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
	 * permette di resettare lo stato di paginazione della tabella widg_tbAcquaReintegro
	 */
	public static void resetClearStatus_widg_tbAcquaReintegro(java.util.Map session) {
		session.put("cpGestReeTipo1_tbAcquaReintegro_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R676104378) ENABLED START*/
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

	/*PROTECTED REGION END*/
}
