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

/*PROTECTED REGION ID(R1233980080) ENABLED START*/
import org.apache.log4j.*;
import it.csi.sigit.sigitwebn.util.*;
import it.csi.sigit.sigitwebn.util.enumutil.O2CO2Enum;
import it.csi.custom.component.tree.base.TreeNode;
import it.csi.custom.component.tree.base.TreeNodeBase;
import it.csi.sigit.sigitwebn.business.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGfDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGtDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettTipo1Dto;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import java.math.BigDecimal;
/*PROTECTED REGION END*/

public class CPBECpGestRapProvaTipo1Dett {

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

	// ApplicationData: [ricaricaPagina, scope:USER_SESSION]
	public static final String APPDATA_RICARICAPAGINA_CODE = "appDataricaricaPagina";

	// ApplicationData: [ElencoModalitaEvacuazione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMODALITAEVACUAZIONE_CODE = "appDataElencoModalitaEvacuazione";

	// ApplicationData: [elencoModuliRappProva, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMODULIRAPPPROVA_CODE = "appDataelencoModuliRappProva";

	// ApplicationData: [moduloSelezionatoRappProva, scope:USER_SESSION]
	public static final String APPDATA_MODULOSELEZIONATORAPPPROVA_CODE = "appDatamoduloSelezionatoRappProva";

	// ApplicationData: [progressivoSelezionatoRappProva, scope:USER_SESSION]
	public static final String APPDATA_PROGRESSIVOSELEZIONATORAPPPROVA_CODE = "appDataprogressivoSelezionatoRappProva";

	// ApplicationData: [TipoGTDett, scope:USER_SESSION]
	public static final String APPDATA_TIPOGTDETT_CODE = "appDataTipoGTDett";

	// ApplicationData: [TipoGTDettModulo, scope:USER_SESSION]
	public static final String APPDATA_TIPOGTDETTMODULO_CODE = "appDataTipoGTDettModulo";

	// ApplicationData: [elencoClassDPR, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCLASSDPR_CODE = "appDataelencoClassDPR";

	// ApplicationData: [elencoFrequenzaManut, scope:USER_SESSION]
	public static final String APPDATA_ELENCOFREQUENZAMANUT_CODE = "appDataelencoFrequenzaManut";

	// ApplicationData: [ElencoO2CO2, scope:USER_SESSION]
	public static final String APPDATA_ELENCOO2CO2_CODE = "appDataElencoO2CO2";

	// ApplicationData: [ElencoIndiceFumosita, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINDICEFUMOSITA_CODE = "appDataElencoIndiceFumosita";

	// ApplicationData: [ElencoSufficienteNonSufficiente, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSUFFICIENTENONSUFFICIENTE_CODE = "appDataElencoSufficienteNonSufficiente";

	// ApplicationData: [ElencoRegolareIrregolare, scope:USER_SESSION]
	public static final String APPDATA_ELENCOREGOLAREIRREGOLARE_CODE = "appDataElencoRegolareIrregolare";

	// ApplicationData: [rapProvaMenuTree, scope:USER_SESSION]
	public static final String APPDATA_RAPPROVAMENUTREE_CODE = "appDatarapProvaMenuTree";

	// ApplicationData: [allegatoIsp, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATOISP_CODE = "appDataallegatoIsp";

	// ApplicationData: [Ispezione2018, scope:USER_SESSION]
	public static final String APPDATA_ISPEZIONE2018_CODE = "appDataIspezione2018";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestRapProvaTipo1Dett";

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
	 * ContentPanel cpGestRapProvaTipo1Dett
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo1DettModel theModel

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
			/*PROTECTED REGION ID(R734003618) ENABLED START*/

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
	 * Implementazione del metodo caricaModuloNew definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaTipo1Dett
	 */
	public ExecResults caricaModuloNew(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAMODULONEW_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-800945226) ENABLED START*/

			DettaglioAllegato dettAll = theModel.getAppDataallegatoIsp();

			log.debug("theModel.getAppDatamoduloSelezionatoRappProva(): "
					+ theModel.getAppDatamoduloSelezionatoRappProva());

			TipoGTDettModulo modulo = recuperaModuloSelez(dettAll.getCodiceImpianto(), dettAll.getIdAllegato(),
					theModel.getAppDataprogressivoSelezionatoRappProva(),
					theModel.getAppDatamoduloSelezionatoRappProva());

			theModel.setAppDataTipoGTDettModulo(modulo);

			result.setResultCode(CARICAMODULONEW_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaModuloNew] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaRapProvaDett definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaTipo1Dett
	 */
	public ExecResults salvaRapProvaDett(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVARAPPROVADETT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVARAPPROVADETT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-831030132) ENABLED START*/

			try {
				TipoGTDett dett = theModel.getAppDataTipoGTDett();
				TipoGTDettModulo dettModulo = theModel.getAppDataTipoGTDettModulo();

				//validazione del dettaglio
				getValidationMgr().validazioneFormaleRapProvaGTDett(dett,
						ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoFrequenzaManut()));

				//validazione del modulo
				getValidationMgr().validazioneFormaleRapProvaGTDettModulo(dettModulo);

				getDbMgr().salvaRappProvaTipoGT(dett, dettModulo,
						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				//				String elencoModuli = dett.getElencoModuliNonComp();
				//				String elencoModuliNew = "";
				//				if (GenericUtil.isNotNullOrEmpty(elencoModuli)) {
				//					List<String> listaModuli = Arrays.asList(elencoModuli.split(", "));
				//					if (listaModuli != null) {
				//						for (int i = 0; i < listaModuli.size(); i++) {
				//							String modulo = listaModuli.get(i);
				//							if (!modulo.equals(dettModulo.getS8aNModuloTermico())) {
				//								if (i == listaModuli.size() - 1) {
				//									elencoModuliNew += modulo;
				//								} else {
				//									elencoModuliNew += modulo + ", ";
				//								}
				//							}
				//						}
				//					}
				//				}
				//
				//				dett.setElencoModuliNonComp(elencoModuliNew);
				//				theModel.setAppDataTipoGTDett(dett);
				//
				//				result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.INFO_SALVATAGGIO_CORRETTO, Message.INFO));

				theModel.setAppDataricaricaPagina(Boolean.TRUE);

				result.setResultCode(SALVARAPPROVADETT_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaRapProvaDett] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaTipo1Dett
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__DETTAGLIO_ISPEZIONE = //NOSONAR  Reason:EIAS
				"DETTAGLIO_ISPEZIONE"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RISULTATO_RICERCA_ALLEGATI = //NOSONAR  Reason:EIAS
				"RISULTATO_RICERCA_ALLEGATI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2021818797) ENABLED START*/

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
	 * ContentPanel cpGestRapProvaTipo1Dett
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R218330243) ENABLED START*/
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
	 * Implementazione del metodo caricaRapProvaTipo1Dett definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaTipo1Dett
	 */
	public ExecResults caricaRapProvaTipo1Dett(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICARAPPROVATIPO1DETT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1343111673) ENABLED START*/
			caricaDettaglio(theModel);

			if (theModel.getAppDataelencoClassDPR() == null || theModel.getAppDataelencoClassDPR().isEmpty()) {
				theModel.setAppDataelencoClassDPR(getSigitMgr().cercaElencoClassificazioneDPR660_96());
			}

			if (theModel.getAppDataelencoFrequenzaManut() == null
					|| theModel.getAppDataelencoFrequenzaManut().isEmpty()) {
				theModel.setAppDataelencoFrequenzaManut(getSigitMgr().cercaElencoFrequenzaManut());
			}

			if (theModel.getAppDataElencoIndiceFumosita() == null
					|| theModel.getAppDataElencoIndiceFumosita().isEmpty()) {
				theModel.setAppDataElencoIndiceFumosita(GenericUtil.getComboIndiceFumosita());
			}

			if (theModel.getAppDataElencoModalitaEvacuazione() == null
					|| theModel.getAppDataElencoModalitaEvacuazione().isEmpty()) {
				theModel.setAppDataElencoModalitaEvacuazione(GenericUtil.getComboModalitaEvacuazione());
			}

			if (theModel.getAppDataElencoO2CO2() == null || theModel.getAppDataElencoO2CO2().isEmpty()) {
				theModel.setAppDataElencoO2CO2(GenericUtil.getComboO2Co2());
			}

			if (theModel.getAppDataElencoRegolareIrregolare() == null
					|| theModel.getAppDataElencoRegolareIrregolare().isEmpty()) {
				theModel.setAppDataElencoRegolareIrregolare(GenericUtil.getComboRegolareIrregolare());
			}

			if (theModel.getAppDataElencoSufficienteNonSufficiente() == null
					|| theModel.getAppDataElencoSufficienteNonSufficiente().isEmpty()) {
				theModel.setAppDataElencoSufficienteNonSufficiente(GenericUtil.getComboSufficienteNonSufficiente());
			}

			result.setResultCode(CARICARAPPROVATIPO1DETT_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaRapProvaTipo1Dett] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaMenu definito in un ExecCommand del
	 * ContentPanel cpGestRapProvaTipo1Dett
	 */
	public ExecResults caricaMenu(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAMENU_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1400875431) ENABLED START*/
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
	 * ContentPanel cpGestRapProvaTipo1Dett
	 */
	public ExecResults gestisciRicaricaPagina(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIRICARICAPAGINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R363641260) ENABLED START*/

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
	 * ContentPanel cpGestRapProvaTipo1Dett
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo1DettModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R670329275) ENABLED START*/

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
	/*PROTECTED REGION ID(R780291710) ENABLED START*/
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

	private static String getChiavePrefixProgr(String prefixIdNodo, String tipoComponente) {
		return Constants.PREFIX_ID_NODO_RP_DET + tipoComponente + "-";
	}

	private TipoGTDettModulo recuperaModuloSelez(String codImpianto, String idAllegato, Integer progressivo,
			String moduloSelez) throws ManagerException {
		TipoGTDettModulo modulo = getSigitMgr().caricaDatiRappProvaTipoGTDettModulo(codImpianto, idAllegato,
				progressivo, ConvertUtil.convertToInteger(moduloSelez));

		return modulo;
	}

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	private void caricaDettaglio(it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpGestRapProvaTipo1DettModel theModel)
			throws Exception {
		try {
			DettaglioAllegato dettAll = theModel.getAppDataallegatoIsp();

			TipoGTDett tipoGTDett = getSigitMgr().caricaDatiRappProvaTipoGTDett(dettAll.getIdAllegato(),
					ConvertUtil.convertToSqlDate(dettAll.getDataControllo()),
					theModel.getAppDataprogressivoSelezionatoRappProva());

			List<SigitTDettIspezGtDto> tDettTipo1List = getDbMgr().getDettRappProvaGT(dettAll.getCodiceImpianto(),
					theModel.getAppDataprogressivoSelezionatoRappProva(), dettAll.getIdAllegato());

			tipoGTDett = MapDto.mapToTipoGTDett(tipoGTDett, tDettTipo1List);

			theModel.setAppDataTipoGTDett(tipoGTDett);

			// Setto la combo dei moduli
			ArrayList<CodeDescription> moduliList = MapDto.mapToModuliRappProva(tDettTipo1List);
			theModel.setAppDataelencoModuliRappProva(moduliList);

			// Setto come default il primo modulo
			String moduloDefault = moduliList.get(0).getCode();

			theModel.setAppDatamoduloSelezionatoRappProva(moduloDefault);

			TipoGTDettModulo modulo = recuperaModuloSelez(ConvertUtil.convertToString(tipoGTDett.getCodImpianto()),
					ConvertUtil.convertToString(tipoGTDett.getIdAllegato()),
					ConvertUtil.convertToInteger(tipoGTDett.getProgressivo()), moduloDefault);
			theModel.setAppDataTipoGTDettModulo(modulo);

		} catch (Exception e) {
			throw e;
		}
	}

	/*PROTECTED REGION END*/
}
