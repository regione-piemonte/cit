package it.csi.sigit.sigitwebn.business.gestisci_libretto_scheda1;

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

/*PROTECTED REGION ID(R-723299645) ENABLED START*/
import it.csi.custom.component.tree.base.TreeNode;
import it.csi.custom.component.tree.base.TreeNodeBase;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTControlloLibrettoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTControlloLibrettoPk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTLibrettoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTUnitaImmobiliareDto;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;

/*PROTECTED REGION END*/

public class CPBECpGestLibScheda1 {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [librettoMenuTree, scope:USER_SESSION]
	public static final String APPDATA_LIBRETTOMENUTREE_CODE = "appDatalibrettoMenuTree";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [scheda1, scope:USER_SESSION]
	public static final String APPDATA_SCHEDA1_CODE = "appDatascheda1";

	// ApplicationData: [elencoTipoIntervento, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOINTERVENTO_CODE = "appDataelencoTipoIntervento";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [elencoCategoria, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCATEGORIA_CODE = "appDataelencoCategoria";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [controlloLibretto, scope:USER_SESSION]
	public static final String APPDATA_CONTROLLOLIBRETTO_CODE = "appDatacontrolloLibretto";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestLibScheda1";

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
	 * ContentPanel cpGestLibScheda1
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1.CpGestLibScheda1Model theModel

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
			/*PROTECTED REGION ID(R1658162677) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			/*
			// verifico quale nodo e' stato cliccato
			String clickedNodeId = theModel.getIdNodo();
			
			// recupero l'albero dalla sessione
			TreeNode root = theModel.getAppDatalibrettoMenuTree();
			
			// recupero il nodo corrispondente all'ID
			TreeNode clickedNode = root.getChildren(clickedNodeId);
			
			log.debug("HO PREMUTO il NODO: CLICKED NODE: " + clickedNodeId + " ("
					+ (clickedNode != null ? clickedNode.getDescription() : "") + ")");
			
			if (clickedNodeId.equals("F-scheda1")) {
				// impostazione del result code 
				result.setResultCode(ONTREECLICK_OUTCOME_CODE__SCHEDA1);
			}
			if (clickedNodeId.equals("F-scheda1_0")) {
				// impostazione del result code 
				result.setResultCode(ONTREECLICK_OUTCOME_CODE__SCHEDA1_EXTRA);
			} else if (clickedNodeId.equals("F-scheda2")) {
				// impostazione del result code 
				result.setResultCode(ONTREECLICK_OUTCOME_CODE__SCHEDA2);
			} else if (clickedNodeId.equals("F-scheda14_1")) {
				// impostazione del result code 
				result.setResultCode(ONTREECLICK_OUTCOME_CODE__SCHEDA14_1);
			} else {
				result.setResultCode(ONTREECLICK_OUTCOME_CODE__OK);
			
			}
			*/

			ControlloLibretto controlloLib = theModel.getAppDatacontrolloLibretto();

			String descrizioneRuolo = theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo();

			// Se l'utente non ha salvato la scheda1 o non ha il ruolo CONSULTATORE non puo' cliccare sugl'altri link
			if (controlloLib.getFlgControlloScheda1() || descrizioneRuolo.equals(Constants.RUOLO_SUPER)
					|| descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_CONSULTATORE)) {
				result.setResultCode(
						GenericUtil.gestisciTreeClick(theModel.getIdNodo(), theModel.getAppDatalibrettoMenuTree()));
				// Setto la pagina in cui sto andando, mi servirà nel caso ci sia necessità di ricaricare la pagina con un messaggio (es. consolida libretto)
				theModel.getSession().put(Constants.SESSIONE_VAR_LIBRETTO_SCHEDA, result.getResultCode());
			} else {
				result.setResultCode(ONTREECLICK_OUTCOME_CODE__OK);
			}

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
	 * Implementazione del metodo salvaScheda1 definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1
	 */
	public ExecResults salvaScheda1(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1.CpGestLibScheda1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVASCHEDA1_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVASCHEDA1_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-132127558) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			Scheda1 scheda1 = theModel.getAppDatascheda1();

			if (log.isDebugEnabled())
				GenericUtil.stampa(scheda1, true, 3);

			try {
				UtenteLoggato utente = theModel.getAppDatautenteLoggato();
				String descrizioneRuolo = utente.getRuolo().getDescRuolo();

				// TODO: VALIDAZIONE
				getValidationMgr().validazioneFormaleLibrettoScheda1(scheda1);

				String codiceImpianto = theModel.getAppDataidImpiantoSelez();
				boolean isScheda1Present = theModel.getAppDatacontrolloLibretto().getFlgControlloScheda1();

				getSigitMgr().salvaLibrettoScheda1Trans(scheda1, utente.getCodiceFiscale(),
						utente.getRuolo().getCodiceRea(), codiceImpianto, isScheda1Present);

				theModel.getAppDatacontrolloLibretto().setFlgControlloScheda1(true);

				result.getGlobalMessages().add(Messages.INFO_INSERIMENTO_CORRETTO);
				result.setResultCode(SALVASCHEDA1_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
				//result.setResultCode(SALVASCHEDA1_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaScheda1] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaSchedaAfterSave definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1
	 */
	public ExecResults caricaSchedaAfterSave(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1.CpGestLibScheda1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICASCHEDAAFTERSAVE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-83618908) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			Scheda1 scheda1 = new Scheda1();
			String codiceImpianto = theModel.getAppDataidImpiantoSelez();
			scheda1 = loadScheda(codiceImpianto);

			theModel.setAppDatascheda1(scheda1);

			// impostazione del result code 
			result.setResultCode(CARICASCHEDAAFTERSAVE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaSchedaAfterSave] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1.CpGestLibScheda1Model theModel

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
			/*PROTECTED REGION ID(R-960879942) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(GenericUtil.gestisciTreeIndietro(theModel.getAppDatapaginaChiamante()));
			/*
			String paginaChiamante = theModel.getAppDatapaginaChiamante();
			
			
			if (Constants.PAG_GEST_IMPIANTI.equals(paginaChiamante))
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__GEST_IMPIANTO);
			else if (Constants.PAG_RIS_RIC_AVZ_IMPIANTI.equals(paginaChiamante))
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_AVZ_IMPIANTI);
			else if (Constants.PAG_RIS_RIC_IMPIANTI.equals(paginaChiamante))
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_IMPIANTO);
			else if (Constants.PAG_GEST_IMPIANTI_RESP.equals(paginaChiamante))
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__GEST_IMPIANTO_RESP);
			*/

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
	 * Implementazione del metodo caricaMenuLibretto definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1
	 */
	public ExecResults caricaMenuLibretto(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1.CpGestLibScheda1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAMENULIBRETTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R863072367) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			/*
			if (theModel.getAppDatalibrettoMenuTree() == null) {
				// creo il nodo root del tree
				TreeNode root = new TreeNodeBase("root", "root", false);
			
				// aggiungo le varie voci
				String schedaNodeId = "scheda1";
				TreeNodeBase menuNode = new TreeNodeBase(schedaNodeId, "1.scheda identificativa", true);
				root.getChildren().add(menuNode);
			
				schedaNodeId = "scheda1_extra";
				menuNode = new TreeNodeBase(schedaNodeId, "1.dati aggiuntivi", true);
				root.getChildren().add(menuNode);
			
				schedaNodeId = "scheda2";
				menuNode = new TreeNodeBase(schedaNodeId, "2.trattamento acqua", true);
				root.getChildren().add(menuNode);
			
				schedaNodeId = "scheda14_1";
				menuNode = new TreeNodeBase(schedaNodeId, "14.1.consumo di combustibile", true);
				root.getChildren().add(menuNode);
			
				// aggiungo il tree al modello
				theModel.setAppDatalibrettoMenuTree(root);
			
			}
			*/

			if (theModel.getAppDatalibrettoMenuTree() == null) {

				/*
				// creo il nodo root del tree
				TreeNode root = new TreeNodeBase("root", "root", false);
				//TreeNode root = new TreeNodeBase("root", "root", false, "root", true);
				//root.setExpanded(true);
				
				// Aggiungo la cartella "Libretto"
				String librettoNodeId = "lib";
				TreeNodeBase libNode = new TreeNodeBase(librettoNodeId, "Libretto", false);
				libNode.setOpened(true);
				root.getChildren().add(libNode);
				
				/////////////////////////////////////////////////////
				// SCHEDA 1
				
				// Aggiungo la cartella "Scheda1"
				String schedaNodeId = "S-scheda1";
				
				TreeNodeBase schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 1", false);
				schedaNode.setOpened(true);
				
				root.getChildren(librettoNodeId).getChildren().add(schedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				TreeNodeBase sottoSchedaNode = new TreeNodeBase("F-scheda1_0", "1 Dati aggiuntivi", true);
				
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda1", "1 Scheda identificativa impianto", true);
				
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				/////////////////////////////////////////////////////
				// SCHEDA 2
				// Aggiungo la cartella "Scheda2"
				schedaNodeId = "S-scheda2";
				
				schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 2", false);
				schedaNode.setOpened(true);
				
				root.getChildren(librettoNodeId).getChildren().add(schedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda2", "2 Trattamento acqua", true);
				sottoSchedaNode.setOpened(true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// SCHEDA 3
				// Aggiungo la cartella "Scheda3"
				schedaNodeId = "S-scheda3";
				
				schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 3", false);
				schedaNode.setOpened(true);
				
				root.getChildren(librettoNodeId).getChildren().add(schedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda3", "3 Nomina terzo responsabile impianto termico", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// SCHEDA 4
				// Aggiungo la cartella "Scheda4"
				schedaNodeId = "S-scheda4";
				
				schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 4", false);
				schedaNode.setOpened(true);
				
				root.getChildren(librettoNodeId).getChildren().add(schedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda4_1", "4.1 Gruppi termici o caldaie", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda4_2", "4.2 Bruciatori", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda4_3", "4.3 Recuperatori / Condensatori lato fumi", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda4_4", "4.4 Macchine frigorifere / Pompe di calore", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda4_5", "4.5 Scambiatori di calore", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda4_6", "4.6 Cogeneratori / Trigeneratori", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda4_7", "4.7 Campi solari termici", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda4_8", "4.8 Altri generatori", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// SCHEDA 5
				// Aggiungo la cartella "Scheda5"
				schedaNodeId = "S-scheda5";
				
				schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 5", false);
				schedaNode.setOpened(true);
				
				root.getChildren(librettoNodeId).getChildren().add(schedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda5_1SR", "5.1 Sistemi di regolazione SR", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda5_1VR", "5.1 Valvole di regolazione VR", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda5_2", "5 Sistemi di regolazione e contabilizzazione", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// SCHEDA 6
				// Aggiungo la cartella "Scheda6"
				schedaNodeId = "S-scheda6";
				
				schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 6", false);
				schedaNode.setOpened(true);
				
				root.getChildren(librettoNodeId).getChildren().add(schedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda6", "6 Sistemi di distribuzione", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda6_4",
						"6.4 Pompe di circolazione (se non incorporate nel generatore)", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// SCHEDA 7
				// Aggiungo la cartella "Scheda7"
				schedaNodeId = "S-scheda7";
				
				schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 7", false);
				schedaNode.setOpened(true);
				
				root.getChildren(librettoNodeId).getChildren().add(schedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda7", "7 Sistema di emissione", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// SCHEDA 8
				// Aggiungo la cartella "Scheda8"
				schedaNodeId = "S-scheda8";
				
				schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 8", false);
				schedaNode.setOpened(true);
				
				root.getChildren(librettoNodeId).getChildren().add(schedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda8", "8.1 Sistema di accumulo", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// SCHEDA 9
				// Aggiungo la cartella "Scheda9"
				schedaNodeId = "S-scheda9";
				
				schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 9", false);
				schedaNode.setOpened(true);
				
				root.getChildren(librettoNodeId).getChildren().add(schedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda9_1", "9.1 Torri evaporative", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda9_2", "9.2 Raffreddatori di liquido", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda9_3", "9.3 Scambiatori di calore intermedi", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda9_4",
						"9.4 Circuiti interrati a condensazione / espansione diretta", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda9_5", "9.5 Unita' di trattamento aria", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda9_6", "9.6 Recuperatori di calore (aria ambiente)", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// SCHEDA 10
				// Aggiungo la cartella "Scheda10"
				schedaNodeId = "S-scheda10";
				
				schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 10", false);
				schedaNode.setOpened(true);
				
				root.getChildren(librettoNodeId).getChildren().add(schedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda10_1",
						"10.1 Impianto di ventilazione meccanica controllata", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				
				// SCHEDA 11
				// Aggiungo la cartella "Scheda11"
				//				schedaNodeId = "S-scheda11";
				//				
				//				schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 11", false);
				//				schedaNode.setOpened(true);
				//				
				//				root.getChildren(librettoNodeId).getChildren().add(schedaNode);
				//				
				//				// Aggiungo la sottoscheda (foglio)
				//				sottoSchedaNode = new TreeNodeBase("F-scheda11_1", "11.1 Gruppi termici", true);
				//				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				//				
				//				// Aggiungo la sottoscheda (foglio)
				//				sottoSchedaNode = new TreeNodeBase("F-scheda11_2", "11.2 Macchine frigo / Pompe di calore", true);
				//				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				//				
				//				// Aggiungo la sottoscheda (foglio)
				//				sottoSchedaNode = new TreeNodeBase("F-scheda11_3",
				//						"11.3 Scambiatori calore sottostazione teleriscaldamento / teleraffrescamento", true);
				//				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				//				
				//				// Aggiungo la sottoscheda (foglio)
				//				sottoSchedaNode = new TreeNodeBase("F-scheda11_4", "11.4 Cogeneratori / Trigeneratori", true);
				//				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				//				
				
				// SCHEDA 12
				// Aggiungo la cartella "Scheda12"
				schedaNodeId = "S-scheda12";
				
				schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 12 e Scheda 11", false);
				schedaNode.setOpened(true);
				
				root.getChildren(librettoNodeId).getChildren().add(schedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda12", "12 Interventi di controllo efficienza energetica",
						true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// SCHEDA 13
				// Aggiungo la cartella "Scheda13"
				schedaNodeId = "S-scheda13";
				
				schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 13", false);
				schedaNode.setOpened(true);
				
				root.getChildren(librettoNodeId).getChildren().add(schedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda13",
						"13 Risultati ispezioni periodiche a cura ente competente", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				/////////////////////////////////////////////////////
				// SCHEDA 14
				// Aggiungo la cartella "Scheda14"
				
				schedaNodeId = "S-scheda14";
				schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 14", false);
				schedaNode.setOpened(true);
				
				root.getChildren(librettoNodeId).getChildren().add(schedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda14_1", "14.1 Consumo di combustibile", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda14_2", "14.2 Consumo di energia elettrica", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda14_3",
						"14.3 Consumo di acqua di reintegro nel circuito dell'impianto termico", true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				
				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-scheda14_4",
						"14.4 Consumo di prodotti chimici per il trattamento acqua del circuito dell'impianto termico",
						true);
				root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
				*/

				// aggiungo il tree al modello
				theModel.setAppDatalibrettoMenuTree(GenericUtil.gestisciTreeLibretto());

			}

			// impostazione del result code 
			result.setResultCode(CARICAMENULIBRETTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaMenuLibretto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1.CpGestLibScheda1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1864868880) ENABLED START*/
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
	 * Implementazione del metodo caricaScheda1 definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1
	 */
	public ExecResults caricaScheda1(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1.CpGestLibScheda1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICASCHEDA1_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R747391180) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getSession().put(Constants.SESSIONE_VAR_LIBRETTO_SCHEDA, "SCHEDA1");

			// Setto questa variabile, mi serve nei seguenti link:
			// PDF libretto consolidato
			// XML libretto consolidato
			// PDF libretto generato RUN TIME
			// Consolida libretto
			// Non posso usare getAppDataidImpiantoSelez perchè la Classe recuperaLibretto, richiamato da "PDF libretto consolidato", è richiamato da tante altre classi
			theModel.getSession().put(Constants.SESSIONE_VAR_ID_IMPIANTO, theModel.getAppDataidImpiantoSelez());

			Scheda1 scheda1 = new Scheda1();
			String codiceImpianto = theModel.getAppDataidImpiantoSelez();
			scheda1 = loadScheda(codiceImpianto);

			theModel.setAppDatascheda1(scheda1);

			SigitTControlloLibrettoDto controlloLibDto = getDbMgr().findControlloLibretto(codiceImpianto);

			ControlloLibretto controlloLib = new ControlloLibretto();

			String descrizioneRuolo = theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo();

			if (controlloLibDto != null
					&& ConvertUtil.convertToBooleanAllways(controlloLibDto.getFlgL1Controlloweb())) {
				controlloLib.setFlgControlloScheda1(ConvertUtil.convertToBoolean(Constants.SI_1));
			} else {
				controlloLib.setFlgControlloScheda1(ConvertUtil.convertToBoolean(Constants.NO_0));

				log.debug("#### caricaScheda1 AGGIUNGO MSG");

				if (!descrizioneRuolo.equals(Constants.RUOLO_SUPER)
						&& !descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)
						&& !descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)
						&& !descrizioneRuolo.equals(Constants.RUOLO_CONSULTATORE)) {
					result.getGlobalErrors().add(Messages.ERROR_LIBRETTO_SCHEDA1_NON_SALVATA);
				}

			}

			// TEST
			log.debug("####Entro in caricaScheda1");

			Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);
			log.debug("msg (prima): " + msg);

			GenericUtil.gestisciMessaggioSessione(theModel, result);

			Message msg2 = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);
			log.debug("msg (dopo): " + msg2);

			log.debug("Ho recuperato sul result (error-getGlobalErrors): " + result.getGlobalErrors());
			log.debug("Ho recuperato sul result (error-getGlobalMessages): " + result.getGlobalMessages());

			/*
			Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);
			if (msg != null) {
				if (msg.getType() == Message.ERROR)
					result.getGlobalErrors().add(msg.getText());
				else
					result.getGlobalMessages().add(msg.getText());
			
				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
			}
			
			xx
			*/
			log.debug("####Esco in caricaScheda1");

			theModel.setAppDatacontrolloLibretto(controlloLib);

			// impostazione del result code 
			result.setResultCode(CARICASCHEDA1_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaScheda1] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaCombo definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1
	 */
	public ExecResults caricaCombo(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1.CpGestLibScheda1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICACOMBO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R545667653) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				theModel.setAppDataelencoTipoIntervento(getDbMgr().cercaTipoIntervento());

				if (theModel.getAppDataelencoCategoria() == null) {
					theModel.setAppDataelencoCategoria(getDbMgr().cercaCategoria());
				}
			} catch (ManagerException e) {
				throw new BEException("Errore in CpGestLibScheda1 per il metodo  caricaCombo:" + e, e);
			}

			// impostazione del result code 
			result.setResultCode(CARICACOMBO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaCombo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazione definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1
	 */
	public ExecResults gestisciAbilitazione(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1.CpGestLibScheda1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONE_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONE_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R594135076) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isUtenteAbilModLibWeb(utente)) {
				// impostazione del result code 
				result.setResultCode(GESTISCIABILITAZIONE_OUTCOME_CODE__ABILITA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCIABILITAZIONE_OUTCOME_CODE__DISABILITA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilitazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciMsgControlloLibretto definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1
	 */
	public ExecResults gestisciMsgControlloLibretto(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1.CpGestLibScheda1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSGCONTROLLOLIBRETTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R946928403) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ControlloLibretto controlloLib = theModel.getAppDatacontrolloLibretto();

			String descrizioneRuolo = theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo();

			if ((controlloLib != null && !ConvertUtil.convertToBooleanAllways(controlloLib.getFlgControlloScheda1()))
					&& !descrizioneRuolo.equals(Constants.RUOLO_SUPER)
					&& !descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)
					&& !descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)
					&& !descrizioneRuolo.equals(Constants.RUOLO_CONSULTATORE)) {
				log.debug("#### gestisciMsgControlloLibretto AGGIUNGO MSG");
				result.getGlobalErrors().add(Messages.ERROR_LIBRETTO_SCHEDA1_NON_SALVATA);
			}

			// impostazione del result code 
			result.setResultCode(GESTISCIMSGCONTROLLOLIBRETTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciMsgControlloLibretto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciMsg definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1.CpGestLibScheda1Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1594488334) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

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
			// TEST
			log.debug("####Entro in caricaScheda1");

			Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);
			log.debug("msg (prima): " + msg);

			GenericUtil.gestisciMessaggioSessione(theModel, result);

			Message msg2 = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);
			log.debug("msg (dopo): " + msg2);

			log.debug("Ho recuperato sul result (error-getGlobalErrors): " + result.getGlobalErrors());
			log.debug("Ho recuperato sul result (error-getGlobalMessages): " + result.getGlobalMessages());

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

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1146580335) ENABLED START*/
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

	private Scheda1 loadScheda(String codiceImpianto) throws DbManagerException {
		Scheda1 schedaTemp = new Scheda1();
		/*
		List<SigitTLibrettoDto> librettoBozzaDtoList = getDbMgr().cercaLibrettoByStato(codiceImpianto,
				Constants.ID_STATO_LIBRETTO_BOZZA);
		List<SigitTLibrettoDto> librettoDtoConsolidatoList = getDbMgr().cercaLibrettoByStato(codiceImpianto,
				Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
		SigitTLibrettoDto libretto = null;
		// se sono presenti sia bozza che consolidato carico il libretto bozza
		if (!GenericUtil.isNullOrEmpty(librettoBozzaDtoList) && librettoBozzaDtoList.size() != 0) {
			libretto = librettoBozzaDtoList.get(0);
		} else if (!GenericUtil.isNullOrEmpty(librettoDtoConsolidatoList) && librettoDtoConsolidatoList.size() != 0) {
			libretto = librettoDtoConsolidatoList.get(0);
			GenericUtil.stampa(libretto, true, 3);
		}
		
		if (GenericUtil.isNotNullOrEmpty(libretto)) {
			
			
		
		*/
		// recupero l'unita' immobiliare associata all'impianto
		SigitTUnitaImmobiliareDto unitaImmobiliareDto = getDbMgr()
				.cercaSigitTUnitaImmobiliareByCodImpianto(codiceImpianto);
		if (unitaImmobiliareDto != null) {

			schedaTemp.setFlagSingolaUnita(
					GenericUtil.isNotNullOrEmpty(unitaImmobiliareDto.getL12FlgSingolaUnita()) && unitaImmobiliareDto
							.getL12FlgSingolaUnita().equals(ConvertUtil.convertToBigDecimal(Constants.SI_1)));
			schedaTemp.setCategoria(unitaImmobiliareDto.getL12FkCategoria());
			schedaTemp
					.setVolumeLordoRiscaldato(ConvertUtil.convertToStringLogic(unitaImmobiliareDto.getL12VolRiscM3()));
			schedaTemp
					.setVolumeLordoRaffrescato(ConvertUtil.convertToStringLogic(unitaImmobiliareDto.getL12VolRaffM3()));
		}

		// recupero l'impianto
		SigitTImpiantoDto impiantoDto = getDbMgr().cercaImpiantoDtoById(codiceImpianto);
		if (impiantoDto != null) {
			schedaTemp.setDataIntervento(ConvertUtil.convertToString(impiantoDto.getDataIntervento()));
			schedaTemp.setIdTipoIntervento(ConvertUtil.convertToInteger(impiantoDto.getFkTipoIntervento()));
			schedaTemp.setFlagPotenzaUtileProduzioneACS(GenericUtil.isNotNullOrEmpty(impiantoDto.getL13PotH2oKw()));
			schedaTemp.setPotenzaUtileProduzioneACS(ConvertUtil.convertToStringLogic(impiantoDto.getL13PotH2oKw()));
			schedaTemp.setFlagPotenzaUtileClimatInvernale(
					GenericUtil.isNotNullOrEmpty(impiantoDto.getL13PotClimaInvKw()));
			schedaTemp.setPotenzaUtileClimatInvernale(
					ConvertUtil.convertToStringLogic(impiantoDto.getL13PotClimaInvKw()));
			schedaTemp.setFlagPotenzaUtileClimatEstiva(GenericUtil.isNotNullOrEmpty(impiantoDto.getL13PotClimaEstKw()));
			schedaTemp.setPotenzaUtileClimatEstiva(ConvertUtil.convertToStringLogic(impiantoDto.getL13PotClimaEstKw()));
			schedaTemp.setFlagPotenzaUtileAltro(GenericUtil.isNotNullOrEmpty(impiantoDto.getL13Altro()));
			schedaTemp.setPotenzaUtileAltro(impiantoDto.getL13Altro());

			schedaTemp.setFlagTipologiaFluidoAcqua(GenericUtil.isNotNullOrEmpty(impiantoDto.getL14FlgH2o())
					&& impiantoDto.getL14FlgH2o().equals(ConvertUtil.convertToBigDecimal(Constants.SI_1)));
			schedaTemp.setFlagTipologiaFluidoAria(GenericUtil.isNotNullOrEmpty(impiantoDto.getL14FlgAria())
					&& impiantoDto.getL14FlgAria().equals(ConvertUtil.convertToBigDecimal(Constants.SI_1)));
			schedaTemp.setFlagTipologiaFluidoAltro(GenericUtil.isNotNullOrEmpty(impiantoDto.getL14Altro()));
			schedaTemp.setTipologiaFluidoAltro(impiantoDto.getL14Altro());

			schedaTemp.setFlagGeneratoreCombustione(GenericUtil.isNotNullOrEmpty(impiantoDto.getL15FlgGeneratore())
					&& impiantoDto.getL15FlgGeneratore().equals(ConvertUtil.convertToBigDecimal(Constants.SI_1)));
			schedaTemp.setFlagPompaDiCalore(GenericUtil.isNotNullOrEmpty(impiantoDto.getL15FlgPompa())
					&& impiantoDto.getL15FlgPompa().equals(ConvertUtil.convertToBigDecimal(Constants.SI_1)));
			schedaTemp.setFlagGeneratoreMacchinaFrigorifera(GenericUtil.isNotNullOrEmpty(impiantoDto.getL15FlgFrigo())
					&& impiantoDto.getL15FlgFrigo().equals(ConvertUtil.convertToBigDecimal(Constants.SI_1)));

			schedaTemp.setFlagGeneratoreTeleriscaldamento(GenericUtil.isNotNullOrEmpty(impiantoDto.getL15FlgTelerisc())
					&& impiantoDto.getL15FlgTelerisc().equals(ConvertUtil.convertToBigDecimal(Constants.SI_1)));
			schedaTemp.setFlagGeneratoreTeleraffrescamento(
					GenericUtil.isNotNullOrEmpty(impiantoDto.getL15FlgTeleraffr()) && impiantoDto.getL15FlgTeleraffr()
							.equals(ConvertUtil.convertToBigDecimal(Constants.SI_1)));

			schedaTemp.setFlagCogenerazioneTrigenerazione(
					GenericUtil.isNotNullOrEmpty(impiantoDto.getL15FlgCogeneratore()) && impiantoDto
							.getL15FlgCogeneratore().equals(ConvertUtil.convertToBigDecimal(Constants.SI_1)));
			schedaTemp.setFlagAltroTipoGeneratori(GenericUtil.isNotNullOrEmpty(impiantoDto.getL15Altro()));
			schedaTemp.setAltroTipoGeneratori(impiantoDto.getL15Altro());

			schedaTemp.setFlagPannelliSolari(GenericUtil.isNotNullOrEmpty(impiantoDto.getL15SupPannelliSolM2()));
			schedaTemp.setTotaleSuperficieLorda(ConvertUtil.convertToStringLogic(impiantoDto.getL15SupPannelliSolM2()));

			schedaTemp.setFlagAltraIntegrazione((GenericUtil.isNotNullOrEmpty(impiantoDto.getL15AltroIntegrazione())
					|| GenericUtil.isNotNullOrEmpty(impiantoDto.getL15AltroIntegrPotKw())));

			schedaTemp.setAltraIntegrazione(impiantoDto.getL15AltroIntegrazione());
			schedaTemp.setPotenzaUtileAltraIntegrazione(
					ConvertUtil.convertToStringLogic(impiantoDto.getL15AltroIntegrPotKw()));

			schedaTemp.setFlagTipoGeneratoriClimatInvernale(
					GenericUtil.isNotNullOrEmpty(impiantoDto.getL15FlgAltroClimaInv()) && impiantoDto
							.getL15FlgAltroClimaInv().equals(ConvertUtil.convertToBigDecimal(Constants.SI_1)));
			schedaTemp.setFlagTipoGeneratoriClimatEstiva(
					GenericUtil.isNotNullOrEmpty(impiantoDto.getL15FlgAltroClimaEstate()) && impiantoDto
							.getL15FlgAltroClimaEstate().equals(ConvertUtil.convertToBigDecimal(Constants.SI_1)));
			schedaTemp.setFlagTipologiaGeneratoriProdACS(GenericUtil.isNotNullOrEmpty(impiantoDto.getL15FlgAltroAcs())
					&& impiantoDto.getL15FlgAltroAcs().equals(ConvertUtil.convertToBigDecimal(Constants.SI_1)));
			schedaTemp.setFlagAltroTipologiaGeneratori(GenericUtil.isNotNullOrEmpty(impiantoDto.getL15AltroDesc()));
			schedaTemp.setAltroTipologiaGeneratori(impiantoDto.getL15AltroDesc());
		}

		return schedaTemp;
	}
	/*PROTECTED REGION END*/
}
