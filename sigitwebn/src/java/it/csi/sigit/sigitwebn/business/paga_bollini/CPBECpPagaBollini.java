package it.csi.sigit.sigitwebn.business.paga_bollini;

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

/*PROTECTED REGION ID(R-1992189268) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;

/*PROTECTED REGION END*/

public class CPBECpPagaBollini {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [elencoGestoriPagamento, scope:USER_SESSION]
	public static final String APPDATA_ELENCOGESTORIPAGAMENTO_CODE = "appDataelencoGestoriPagamento";

	// ApplicationData: [datiPagamento, scope:USER_SESSION]
	public static final String APPDATA_DATIPAGAMENTO_CODE = "appDatadatiPagamento";

	// ApplicationData: [mdpURL, scope:USER_SESSION]
	public static final String APPDATA_MDPURL_CODE = "appDatamdpURL";

	// ApplicationData: [transazioneApp, scope:USER_SESSION]
	public static final String APPDATA_TRANSAZIONEAPP_CODE = "appDatatransazioneApp";

	// ApplicationData: [acquistaBollini, scope:USER_SESSION]
	public static final String APPDATA_ACQUISTABOLLINI_CODE = "appDataacquistaBollini";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpPagaBollini";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaPagamentoRegistrazione definito in un ExecCommand del
	 * ContentPanel cpPagaBollini
	 */
	public ExecResults preparaPagamentoRegistrazione(

			it.csi.sigit.sigitwebn.dto.paga_bollini.CpPagaBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAPAGAMENTOREGISTRAZIONE_OUTCOME_CODE__GOTO_MDP = //NOSONAR  Reason:EIAS
				"GOTO_MDP"; //NOSONAR  Reason:EIAS
		final String PREPARAPAGAMENTOREGISTRAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1757804006) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				DatiPagamento dpaga = theModel.getAppDatadatiPagamento();

				if (log.isDebugEnabled())
					GenericUtil.stampa(dpaga, true, 3);

				AcquistoBollini acquistoBollini = theModel.getAppDataacquistaBollini();

				getValidationMgr().validazioneFormalePagaBollini(dpaga);

				TransazioneApp transazioneApp = theModel.getAppDatatransazioneApp();

				//				String mdpURL = getServiziMgr().startTransazione(
				//						transazioneApp, dpaga.getIdGestorePagamento());
				String mdpURL = null;

				// Adesso c'è l'assegnazione automatica dei bollini
				//				getDbMgr().aggiornaStatoTransazioneBoll(acquistoBollini.getIdTransazione(),
				//						Constants.TRANSAZIONE_MDP_STARTED, theModel.getAppDatautenteLoggato().getCodiceFiscale());

				theModel.setAppDatamdpURL(mdpURL);

				// impostazione del result code 
				result.setResultCode(PREPARAPAGAMENTOREGISTRAZIONE_OUTCOME_CODE__GOTO_MDP);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaPagamentoRegistrazione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneDatiPagamento definito in un ExecCommand del
	 * ContentPanel cpPagaBollini
	 */
	public ExecResults gestioneDatiPagamento(

			it.csi.sigit.sigitwebn.dto.paga_bollini.CpPagaBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEDATIPAGAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1318676625) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			TransazioneApp transazione = theModel.getAppDatatransazioneApp();

			ArrayList<CodeDescription> gestoriPagamentoList = theModel.getAppDataelencoGestoriPagamento();

			if (gestoriPagamentoList == null || gestoriPagamentoList.size() == 0) {
				// Carico i metodi di pagamento
				//				theModel.setAppDataelencoGestoriPagamento(getServiziMgr()
				//						.cercaMetodiPagamento(transazione));
			}

			AcquistoBollini acquistoBoll = theModel.getAppDataacquistaBollini();

			DatiPagamento dpaga = new DatiPagamento();

			dpaga.setImporto(ConvertUtil.convertToString(transazione.getAmount(), Constants.NUMERO_DECIMALI));

			//dpaga.setModPagamento("BB");
			// la causale e' fissa
			//dpaga.setQuantita(theModel.getAppDatanumACEDesiderati());
			dpaga.setCausale("Matricola xxxxx, Prenotazione xxx A.P.E.");
			dpaga.setDataValuta(acquistoBoll.getDataAcquisto());
			dpaga.setDescMetodoPagamento(Constants.DESC_TIPO_PAGAMENTO_CC);

			theModel.setAppDatadatiPagamento(dpaga);

			// impostazione del result code 
			result.setResultCode(GESTIONEDATIPAGAMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneDatiPagamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1962432834) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
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

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}
	/*PROTECTED REGION END*/
}
