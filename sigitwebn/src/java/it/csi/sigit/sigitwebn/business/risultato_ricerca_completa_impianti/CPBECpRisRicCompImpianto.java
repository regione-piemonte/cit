package it.csi.sigit.sigitwebn.business.risultato_ricerca_completa_impianti;

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

/*PROTECTED REGION ID(R-2082663552) ENABLED START*/
import it.csi.sigit.sigitwebn.dto.risultato_ricerca_completa_impianti.CpRisRicCompImpiantoModel;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;

import org.apache.commons.beanutils.PropertyUtils;

/*PROTECTED REGION END*/

public class CPBECpRisRicCompImpianto {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [risultatoRicercaImpianti, scope:USER_SESSION]
	public static final String APPDATA_RISULTATORICERCAIMPIANTI_CODE = "appDatarisultatoRicercaImpianti";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [aggiornaElencoImpianti, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOIMPIANTI_CODE = "appDataaggiornaElencoImpianti";

	// ApplicationData: [impianto, scope:USER_SESSION]
	public static final String APPDATA_IMPIANTO_CODE = "appDataimpianto";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [ricercaImpianti, scope:USER_SESSION]
	public static final String APPDATA_RICERCAIMPIANTI_CODE = "appDataricercaImpianti";

	// ApplicationData: [paginaChiamanteImp, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEIMP_CODE = "appDatapaginaChiamanteImp";

	// ApplicationData: [isAbilitazioneDatiAllegato, scope:USER_SESSION]
	public static final String APPDATA_ISABILITAZIONEDATIALLEGATO_CODE = "appDataisAbilitazioneDatiAllegato";

	// ApplicationData: [responsabile, scope:USER_SESSION]
	public static final String APPDATA_RESPONSABILE_CODE = "appDataresponsabile";

	// ApplicationData: [elencoResponsabili, scope:USER_SESSION]
	public static final String APPDATA_ELENCORESPONSABILI_CODE = "appDataelencoResponsabili";

	// ApplicationData: [elencoResponsabiliTemp, scope:USER_SESSION]
	public static final String APPDATA_ELENCORESPONSABILITEMP_CODE = "appDataelencoResponsabiliTemp";

	// ApplicationData: [elencoManutentori, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMANUTENTORI_CODE = "appDataelencoManutentori";

	// ApplicationData: [dataRevocaResponsabileOld, scope:USER_SESSION]
	public static final String APPDATA_DATAREVOCARESPONSABILEOLD_CODE = "appDatadataRevocaResponsabileOld";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [idImpiantoRevoca, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOREVOCA_CODE = "appDataidImpiantoRevoca";

	// ApplicationData: [elencoDettaglioTerzoResponsabile, scope:USER_SESSION]
	public static final String APPDATA_ELENCODETTAGLIOTERZORESPONSABILE_CODE = "appDataelencoDettaglioTerzoResponsabile";

	// ApplicationData: [risultatoRicercaImpiantiSelez, scope:USER_SESSION]
	public static final String APPDATA_RISULTATORICERCAIMPIANTISELEZ_CODE = "appDatarisultatoRicercaImpiantiSelez";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisRicCompImpianto";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpRisRicCompImpianto
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_completa_impianti.CpRisRicCompImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1104760397) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String descRuolo = theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo();

			if (descRuolo.equals(Constants.RUOLO_IMPRESA)) {
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
	 * Implementazione del metodo gestioneAggElenco definito in un ExecCommand del
	 * ContentPanel cpRisRicCompImpianto
	 */
	public ExecResults gestioneAggElenco(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_completa_impianti.CpRisRicCompImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEAGGELENCO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTIONEAGGELENCO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1037703868) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				log.debug("gestioneAggElenco - START");
				//				if (theModel.getAppDataaggiornaElencoImpianti() != null
				//						&& theModel.getAppDataaggiornaElencoImpianti()) {

				RicercaImpianti ricImpianti = theModel.getAppDataricercaImpianti();

				RicercaImpianti ricComplImpianti = new RicercaImpianti();

				PropertyUtils.copyProperties(ricComplImpianti, ricImpianti);

				ricComplImpianti.setCfImpresa(null);
				ricComplImpianti.setIdSiglaRea(null);
				ricComplImpianti.setNumeroRea(null);

				ArrayList<RisultatoRicImpianto> risRicCodImpiantoList = getSigitMgr().cercaElencoImpianti(
						ricComplImpianti, theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo());

				theModel.setAppDatarisultatoRicercaImpianti(risRicCodImpiantoList);

				theModel.setAppDataaggiornaElencoImpianti(false);
				resetClearStatus_widg_tbRisultatoRicImp(theModel.getSession());
				//}
				gestioneMsgRicerca(theModel, result);
				result.setResultCode(GESTIONEAGGELENCO_OUTCOME_CODE__OK);
				log.debug("gestioneAggElenco - END");
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneAggElenco] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbRisultatoRicImp
	 */
	public static void resetClearStatus_widg_tbRisultatoRicImp(java.util.Map session) {
		session.put("cpRisRicCompImpianto_tbRisultatoRicImp_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-925820108) ENABLED START*/
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

	private void gestioneMsgRicerca(CpRisRicCompImpiantoModel theModel, ExecResults result) throws DbManagerException {
		Integer maxNumRighe = getDbMgr().cercaConfigValueNumerico(Constants.MAX_RIGHE);
		log.debug("MAX num righe da visualizzare = " + maxNumRighe);
		ArrayList<RisultatoRicImpianto> risRicImpiantoList = theModel.getAppDatarisultatoRicercaImpianti();
		if (risRicImpiantoList != null && risRicImpiantoList.size() == maxNumRighe)
			result.getGlobalMessages()
					.add(Messages.MSG_RISULTATI_RICERCA.replaceFirst("##value##", maxNumRighe.toString()));
	}

	/*PROTECTED REGION END*/
}
