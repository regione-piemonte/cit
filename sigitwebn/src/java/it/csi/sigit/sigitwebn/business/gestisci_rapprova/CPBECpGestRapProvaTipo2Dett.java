package it.csi.sigit.sigitwebn.business.gestisci_rapprova;

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

/*PROTECTED REGION ID(R825155855) ENABLED START*/
import it.csi.custom.component.tree.base.TreeNode;
import org.apache.log4j.*;
import it.csi.sigit.sigitwebn.util.*;
import it.csi.sigit.sigitwebn.business.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGfDto;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.custom.component.tree.base.TreeNodeBase;
/*PROTECTED REGION END*/

public class CPBECpGestRapProvaTipo2Dett {

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

	// ApplicationData: [progressivoSelezionatoRappProva, scope:USER_SESSION]
	public static final String APPDATA_PROGRESSIVOSELEZIONATORAPPPROVA_CODE = "appDataprogressivoSelezionatoRappProva";

	// ApplicationData: [rapProvaMenuTree, scope:USER_SESSION]
	public static final String APPDATA_RAPPROVAMENUTREE_CODE = "appDatarapProvaMenuTree";

	// ApplicationData: [allegatoIsp, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATOISP_CODE = "appDataallegatoIsp";

	// ApplicationData: [elencoFrequenzaManut, scope:USER_SESSION]
	public static final String APPDATA_ELENCOFREQUENZAMANUT_CODE = "appDataelencoFrequenzaManut";

	// ApplicationData: [elencoCircuitiRappProva, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCIRCUITIRAPPPROVA_CODE = "appDataelencoCircuitiRappProva";

	// ApplicationData: [circuitoSelezionatoRappProva, scope:USER_SESSION]
	public static final String APPDATA_CIRCUITOSELEZIONATORAPPPROVA_CODE = "appDatacircuitoSelezionatoRappProva";

	// ApplicationData: [TipoGFDett, scope:USER_SESSION]
	public static final String APPDATA_TIPOGFDETT_CODE = "appDataTipoGFDett";

	// ApplicationData: [TipoGFDettCircuito, scope:USER_SESSION]
	public static final String APPDATA_TIPOGFDETTCIRCUITO_CODE = "appDataTipoGFDettCircuito";

	// ApplicationData: [ricaricaPagina, scope:USER_SESSION]
	public static final String APPDATA_RICARICAPAGINA_CODE = "appDataricaricaPagina";

	// ApplicationData: [Ispezione2018, scope:USER_SESSION]
	public static final String APPDATA_ISPEZIONE2018_CODE = "appDataIspezione2018";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestRapProvaTipo2Dett";

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
	 * ContentPanel cpGestRapProvaTipo2Dett
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONTREECLICK_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__RP_DATI_GEN = //NOSONAR  Reason:EIAS
				"RP_DATI_GEN"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__RPGENGT = //NOSONAR  Reason:EIAS
				"RPGENGT"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__RPDETTGT = //NOSONAR  Reason:EIAS
				"RPDETTGT"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__RPGENGF = //NOSONAR  Reason:EIAS
				"RPGENGF"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__RPDETTGF = //NOSONAR  Reason:EIAS
				"RPDETTGF"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R745319745) ENABLED START*/
			String ret = null;

			String clickedNodeId = theModel.getIdNodo();

			log.debug("Ho premuto theModel.getAppDatarapProvaMenuTree(): " + theModel.getAppDatarapProvaMenuTree());
			log.debug("Ho premuto clickedNodeId: " + clickedNodeId);

			// recupero il nodo corrispondente all'ID
			TreeNode clickedNode = theModel.getAppDatarapProvaMenuTree().getChildren(clickedNodeId);

			log.debug("HO PREMUTO il NODO: CLICKED NODE: " + clickedNodeId + " ("
					+ (clickedNode != null ? clickedNode.getDescription() : "") + ")");

			DettaglioAllegato allegato = theModel.getAppDataallegatoIsp();

			String tipoComponente = null;
			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(allegato.getIdTipoAllegato()))
				tipoComponente = Constants.TIPO_COMPONENTE_GT;
			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equals(allegato.getIdTipoAllegato()))
				tipoComponente = Constants.TIPO_COMPONENTE_GF;

			if (clickedNodeId.equals("F-DatiGen")) {
				// impostazione del result code 
				ret = ONTREECLICK_OUTCOME_CODE__RP_DATI_GEN;
			} else if (clickedNodeId.equals("F-DatiRPGen")) {
				if (Constants.TIPO_COMPONENTE_GT.equals(tipoComponente)) {
					ret = ONTREECLICK_OUTCOME_CODE__RPGENGT;
				} else {
					ret = ONTREECLICK_OUTCOME_CODE__RPGENGF;
				}
			} else if (clickedNodeId.startsWith(Constants.PREFIX_ID_NODO_RP_DET + tipoComponente)) {
				// impostazione del result code 
				if (Constants.TIPO_COMPONENTE_GT.equals(tipoComponente)) {
					ret = ONTREECLICK_OUTCOME_CODE__RPDETTGT;
				} else {
					ret = ONTREECLICK_OUTCOME_CODE__RPDETTGF;
				}

				// devo salvare il progressivo
				String progr = clickedNodeId
						.substring(getChiavePrefixProgr(Constants.PREFIX_ID_NODO_RP_DET, tipoComponente).length());

				log.debug("Il progressivo trovato e': " + progr);

				theModel.setAppDataprogressivoSelezionatoRappProva(ConvertUtil.convertToInteger(progr));

				theModel.setAppDataricaricaPagina(true);

			} else {
				ret = ONTREECLICK_OUTCOME_CODE__KO;
			}

			log.debug("Stampo il resultCod - cpGestRapProvaGenerale: " + ret);

			result.setResultCode(ret);

			// Setto la pagina in cui sto andando, mi servirà nel caso ci sia necessità di ricaricare la pagina con un messaggio (es. invia allegato)
			theModel.getSession().put(Constants.SESSIONE_VAR_ALLEGATO_SEZIONE, ret);

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
	 * Implementazione del metodo caricaCircuitoNew definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaTipo2Dett
	 */
	public ExecResults caricaCircuitoNew(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICACIRCUITONEW_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2032877125) ENABLED START*/
			DettaglioAllegato dettAll = theModel.getAppDataallegatoIsp();

			log.debug("theModel.getAppDatacircuitoSelezionatoRappProva(): "
					+ theModel.getAppDatacircuitoSelezionatoRappProva());

			TipoGFDettCircuito circuito = recuperaCircuitoSelez(dettAll.getCodiceImpianto(), dettAll.getIdAllegato(),
					theModel.getAppDataprogressivoSelezionatoRappProva(),
					theModel.getAppDatacircuitoSelezionatoRappProva());

			theModel.setAppDataTipoGFDettCircuito(circuito);

			result.setResultCode(CARICACIRCUITONEW_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaCircuitoNew] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaRapProva definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaTipo2Dett
	 */
	public ExecResults salvaRapProva(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVARAPPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVARAPPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2058007340) ENABLED START*/

			try {
				TipoGFDett dett = theModel.getAppDataTipoGFDett();

				TipoGFDettCircuito dettCircuito = theModel.getAppDataTipoGFDettCircuito();

				getValidationMgr().validazioneFormaleRapProvaGFDett(dett,
						ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoFrequenzaManut()));

				getValidationMgr().validazioneFormaleRapProvaGFDettCircuito(dettCircuito);

				getDbMgr().salvaRappProvaTipoGF(dett, dettCircuito,
						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.INFO_SALVATAGGIO_CORRETTO, Message.INFO));

				theModel.setAppDataricaricaPagina(Boolean.TRUE);

				result.setResultCode(SALVARAPPROVA_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaRapProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaTipo2Dett
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__DETTAGLIO_ISPEZIONE = //NOSONAR  Reason:EIAS
				"DETTAGLIO_ISPEZIONE"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RISULTATO_RICERCA_ALLEGATI = //NOSONAR  Reason:EIAS
				"RISULTATO_RICERCA_ALLEGATI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1099135214) ENABLED START*/
			if (Constants.ARRIVO_DA_IMPIANTO_ISP.equals(theModel.getAppDataallegatoIsp().getArrivoDa())) {
				Ispezione2018 ispezione = new Ispezione2018();
				ispezione.setIdentificativoIspezione(
						ConvertUtil.convertToString(theModel.getAppDataallegatoIsp().getIdIspezione2018()));

				theModel.setAppDataIspezione2018(ispezione);

				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__DETTAGLIO_ISPEZIONE);
			} else {
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__RISULTATO_RICERCA_ALLEGATI);
			}

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
	 * ContentPanel cpGestRapProvaTipo2Dett
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1943811140) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isUtenteAbilitatoRapProva(utente)) {
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
	 * Implementazione del metodo caricaRapProvaTipo2Dett definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaTipo2Dett
	 */
	public ExecResults caricaRapProvaTipo2Dett(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICARAPPROVATIPO2DETT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1270671415) ENABLED START*/
			caricaDettaglio(theModel);

			if (theModel.getAppDataelencoFrequenzaManut() == null
					|| theModel.getAppDataelencoFrequenzaManut().isEmpty()) {
				theModel.setAppDataelencoFrequenzaManut(getSigitMgr().cercaElencoFrequenzaManut());
			}

			result.setResultCode(CARICARAPPROVATIPO2DETT_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaRapProvaTipo2Dett] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaMenu definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaTipo2Dett
	 */
	public ExecResults caricaMenu(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAMENU_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-707773734) ENABLED START*/
			DettaglioAllegato allegato = theModel.getAppDataallegatoIsp();

			if (log.isDebugEnabled())
				GenericUtil.stampa(allegato, true, 3);

			String tipoComponente = null;
			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(allegato.getIdTipoAllegato()))
				tipoComponente = Constants.TIPO_COMPONENTE_GT;
			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equals(allegato.getIdTipoAllegato()))
				tipoComponente = Constants.TIPO_COMPONENTE_GF;

			if (theModel.getAppDatarapProvaMenuTree() == null) {
				// creo il nodo root del tree
				TreeNode root = new TreeNodeBase("root", "root", false);

				String librettoNodeId = "R-" + tipoComponente;
				TreeNodeBase libNode = new TreeNodeBase(librettoNodeId, "RapProva " + tipoComponente, false);
				libNode.setOpened(true);
				root.getChildren().add(libNode);

				/////////////////////////////////////////////////////
				// RapProva GT

				// Aggiungo la sottoscheda (foglio)
				TreeNodeBase sottoSchedaNode = new TreeNodeBase("F-DatiGen", Constants.LABEL_SEZIONE_RP_DATI_GEN, true);
				root.getChildren(librettoNodeId).getChildren().add(sottoSchedaNode);

				// Aggiungo la sottoscheda (foglio)
				sottoSchedaNode = new TreeNodeBase("F-DatiRPGen", Constants.LABEL_SEZIONE_RP_GEN, true);
				root.getChildren(librettoNodeId).getChildren().add(sottoSchedaNode);

				// Devo ciclare per tutte le componenti selezionate
				List<String> idCompProgressiviList = allegato.getIdApparecchiatureFunz();
				for (String idCompProgressivo : idCompProgressiviList) {
					//					sottoSchedaNode = new TreeNodeBase(Constants.PREFIX_ID_NODO_TIPO_1_E + idCompProgressivo,
					//							Constants.LABEL_SEZIONE_E + " - " + Constants.TIPO_COMPONENTE_GT + "-" + idCompProgressivo, true);

					sottoSchedaNode = new TreeNodeBase(
							getChiavePrefixProgr(Constants.PREFIX_ID_NODO_RP_DET, tipoComponente) + idCompProgressivo,
							GenericUtil.getDescSezioneRPComp(tipoComponente, idCompProgressivo), true);

					root.getChildren(librettoNodeId).getChildren().add(sottoSchedaNode);
				}

				// aggiungo il tree al modello
				theModel.setAppDatarapProvaMenuTree(root);

			}

			// Setto la pagina in cui sto andando, mi servirà nel caso ci sia necessità di ricaricare la pagina con un messaggio (es. invia allegato)
			theModel.getSession().put(Constants.SESSIONE_VAR_ALLEGATO_SEZIONE, Constants.LABEL_SEZIONE_RP_GEN);

			// impostazione del result code 
			result.setResultCode(CARICAMENU_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaMenu] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciRicaricaPagina definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaTipo2Dett
	 */
	public ExecResults gestisciRicaricaPagina(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIRICARICAPAGINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1572019027) ENABLED START*/
			Boolean isRicarica = theModel.getAppDataricaricaPagina();

			if (ConvertUtil.convertToBooleanAllways(isRicarica)) {
				caricaDettaglio(theModel);

				theModel.setAppDataricaricaPagina(false);
			}

			// impostazione del result code 
			result.setResultCode(GESTISCIRICARICAPAGINA_OUTCOME_CODE__OK);

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
	 * ContentPanel cpGestRapProvaTipo2Dett
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R681645402) ENABLED START*/

			GenericUtil.gestisciMessaggioSessione(theModel, result);

			result.setResultCode(GESTISCIMSG_OUTCOME_CODE__OK);

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
	/*PROTECTED REGION ID(R2025056191) ENABLED START*/

	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	private static String getChiavePrefixProgr(String prefixIdNodo, String tipoComponente) {
		return Constants.PREFIX_ID_NODO_RP_DET + tipoComponente + "-";
	}

	private TipoGFDettCircuito recuperaCircuitoSelez(String codImpianto, String idAllegato, Integer progressivo,
			String circuitoSelez) throws ManagerException {
		TipoGFDettCircuito circuito = getSigitMgr().caricaDatiRappProvaTipoGFDettCircuito(codImpianto, idAllegato,
				progressivo, ConvertUtil.convertToInteger(circuitoSelez));

		return circuito;
	}

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	private void caricaDettaglio(it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo2DettModel theModel)
			throws Exception {
		try {
			DettaglioAllegato dettAll = theModel.getAppDataallegatoIsp();

			TipoGFDett tipoGFDett = getSigitMgr().caricaDatiRappProvaTipoGFDett(dettAll.getIdAllegato(),
					theModel.getAppDataprogressivoSelezionatoRappProva());

			List<SigitTDettIspezGfDto> tDettTipo2List = getDbMgr().getDettRappProvaGF(dettAll.getCodiceImpianto(),
					theModel.getAppDataprogressivoSelezionatoRappProva(), dettAll.getIdAllegato());

			tipoGFDett = MapDto.mapToTipoGFDett(tipoGFDett, tDettTipo2List);

			theModel.setAppDataTipoGFDett(tipoGFDett);

			ArrayList<CodeDescription> circuitiList = MapDto.mapToCircuitiRappProva(tDettTipo2List);
			theModel.setAppDataelencoCircuitiRappProva(circuitiList);

			// Setto come default il primo circuito
			String circuitoDefault = circuitiList.get(0).getCode();

			theModel.setAppDatacircuitoSelezionatoRappProva(circuitoDefault);

			TipoGFDettCircuito circuito = recuperaCircuitoSelez(
					ConvertUtil.convertToString(tipoGFDett.getCodImpianto()),
					ConvertUtil.convertToString(tipoGFDett.getIdAllegato()),
					ConvertUtil.convertToInteger(tipoGFDett.getProgressivo()), circuitoDefault);
			theModel.setAppDataTipoGFDettCircuito(circuito);

		} catch (Exception e) {
			throw e;
		}
	}
	/*PROTECTED REGION END*/
}
