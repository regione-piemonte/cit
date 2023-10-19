package it.csi.sigit.sigitwebn.business.conferma_terzo_responsabile;

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

/*PROTECTED REGION ID(R-1835670535) ENABLED START*/
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRContr2019AutodichiarDto;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ConnectorMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
/*PROTECTED REGION END*/

public class CPBECpConf3Resp {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [elencoProvincePiemonte, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCEPIEMONTE_CODE = "appDataelencoProvincePiemonte";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [impianto, scope:USER_SESSION]
	public static final String APPDATA_IMPIANTO_CODE = "appDataimpianto";

	// ApplicationData: [elencoIndirizzi3Resp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINDIRIZZI3RESP_CODE = "appDataelencoIndirizzi3Resp";

	// ApplicationData: [terzoResponsabile, scope:USER_SESSION]
	public static final String APPDATA_TERZORESPONSABILE_CODE = "appDataterzoResponsabile";

	// ApplicationData: [elencoResponsabiliImpianto, scope:USER_SESSION]
	public static final String APPDATA_ELENCORESPONSABILIIMPIANTO_CODE = "appDataelencoResponsabiliImpianto";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [dettaglioTerzoResponsabile, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOTERZORESPONSABILE_CODE = "appDatadettaglioTerzoResponsabile";

	// ApplicationData: [elencoApp3Responsabile, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAPP3RESPONSABILE_CODE = "appDataelencoApp3Responsabile";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [elencoAutodichiarazioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAUTODICHIARAZIONI_CODE = "appDataelencoAutodichiarazioni";

	// ApplicationData: [elencoIdSelezionati, scope:USER_ACTION]
	public static final String APPDATA_ELENCOIDSELEZIONATI_CODE = "appDataelencoIdSelezionati";

	// ApplicationData: [elencoTipiCessazione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPICESSAZIONE_CODE = "appDataelencoTipiCessazione";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpConf3Resp";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo effettuaSalvataggioResponsabile definito in un ExecCommand del
	 * ContentPanel cpConf3Resp
	 */
	public ExecResults effettuaSalvataggioResponsabile(

			it.csi.sigit.sigitwebn.dto.conferma_terzo_responsabile.CpConf3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EFFETTUASALVATAGGIORESPONSABILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String EFFETTUASALVATAGGIORESPONSABILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1033316105) ENABLED START*/

			try {
				//dcosta: il form non contiene piu' le apparecchiature quindi viene eliminata la logica su di esse
				TerzoResponsabile responsabile = theModel.getAppDataterzoResponsabile();

				UtenteLoggato utente = theModel.getAppDatautenteLoggato();

				String infoEmail = getConnectorMgr().diventa3Responsabile2019(responsabile, utente,
						theModel.getAppDataelencoIdSelezionati());

				// In questo modo quando torno indietro i campi sono puliti
				theModel.setAppDatapaginaChiamante(Constants.ARRIVO_DA_MENU);

				theModel.setAppDatamessaggioDinamico("terzo responsabile inserito con successo. " + infoEmail);

				result.setResultCode(EFFETTUASALVATAGGIORESPONSABILE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::effettuaSalvataggioResponsabile] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpConf3Resp
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.conferma_terzo_responsabile.CpConf3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1968848870) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoNomina3Responsabile(utente)) {
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
	 * Implementazione del metodo caricaAutodichiarazioni definito in un ExecCommand del
	 * ContentPanel cpConf3Resp
	 */
	public ExecResults caricaAutodichiarazioni(

			it.csi.sigit.sigitwebn.dto.conferma_terzo_responsabile.CpConf3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAAUTODICHIARAZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICAAUTODICHIARAZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1342577646) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			//METODO CHE SERVE A RECUPERARE L'ELENCO DI TUTTE LE AUTODICHIARAZIONI E A FLAGGARE QUELLE CHE RISULTANO ASSOCIATE AL CONTRATTO
			if (theModel.getAppDataelencoAutodichiarazioni() == null
					|| theModel.getAppDataelencoAutodichiarazioni().isEmpty()) {
				theModel.setAppDataelencoAutodichiarazioni(
						(ArrayList<IdDescription>) getDbMgr().cercaListaAutodichiarazioni());
			}

			//VENGONO RECUPERATE LE AUTODICHIARAZIONI ASSOCIATE AL CONTRATTO
			costruisciListaAutodichiarazioniContratto(theModel);

			// impostazione del result code 
			result.setResultCode(CARICAAUTODICHIARAZIONI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaAutodichiarazioni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbAutodichiarazioni
	 */
	public static void resetClearStatus_widg_tbAutodichiarazioni(java.util.Map session) {
		session.put("cpConf3Resp_tbAutodichiarazioni_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-333541355) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
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

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	private void costruisciListaAutodichiarazioniContratto(
			it.csi.sigit.sigitwebn.dto.conferma_terzo_responsabile.CpConf3RespModel theModel)
			throws DbManagerException {

		ArrayList<Integer> idSelezionati = getSigitMgr().costruisciListaAutodichiarazioniContratto("N",
				theModel.getAppDatadettaglioTerzoResponsabile().getIdContratto());
		theModel.setAppDataelencoIdSelezionati(idSelezionati);

		//		if (theModel.getAppDataelencoIdSelezionati() == null) {
		//			theModel.setAppDataelencoIdSelezionati(new ArrayList<Integer>());
		//		}
		//		if (theModel.getAppDatadettaglioTerzoResponsabile().getIdContratto() != null) {
		//			List<SigitRContr2019AutodichiarDto> autodichiarazioniContratto = getDbMgr()
		//					.cercaListaAutodichiarazioniContratto(
		//							theModel.getAppDatadettaglioTerzoResponsabile().getIdContratto(), null, "N");
		//			if (autodichiarazioniContratto != null) {
		//				for (SigitRContr2019AutodichiarDto autod : autodichiarazioniContratto) {
		//					theModel.getAppDataelencoIdSelezionati().add(autod.getIdAutodichiarazione());
		//				}
		//			}
		//		}
	}

	/*PROTECTED REGION END*/
}
