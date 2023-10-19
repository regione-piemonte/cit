package it.csi.sigit.sigitwebn.business.esito_pagamento_bollini;

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

/*PROTECTED REGION ID(R-673896428) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;

/*PROTECTED REGION END*/

public class CPBECpEsitoPagamento {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [msgPagamento, scope:SAME_PAGE]
	public static final String APPDATA_MSGPAGAMENTO_CODE = "appDatamsgPagamento";

	// ApplicationData: [idTransazione, scope:USER_SESSION]
	public static final String APPDATA_IDTRANSAZIONE_CODE = "appDataidTransazione";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpEsitoPagamento";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recepisciPagamentoOK definito in un ExecCommand del
	 * ContentPanel cpEsitoPagamento
	 */
	public ExecResults recepisciPagamentoOK(

			it.csi.sigit.sigitwebn.dto.esito_pagamento_bollini.CpEsitoPagamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECEPISCIPAGAMENTOOK_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-576861872) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// Adesso c'è l'assegnazione automatica dei bollini
			//			Long idTransazione = theModel.getAppDataidTransazione();
			//			getDbMgr().completaAcquistoBollini(idTransazione, theModel.getAppDatautenteLoggato().getCodiceFiscale());

			// impostazione del result code 
			result.setResultCode(RECEPISCIPAGAMENTOOK_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recepisciPagamentoOK] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recepisciPagamentoKO definito in un ExecCommand del
	 * ContentPanel cpEsitoPagamento
	 */
	public ExecResults recepisciPagamentoKO(

			it.csi.sigit.sigitwebn.dto.esito_pagamento_bollini.CpEsitoPagamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECEPISCIPAGAMENTOKO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R282607304) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//			Long idTransazione = theModel.getAppDataidTransazione();
			//
			//			DatiCertificatore cert = theModel.getAppDatacertificatore();
			//			//getTransazioneAceMgr().aggiornaStatoTransazione(idTransazione);
			//
			//			getdbCertificatoMgr().completaAcquistoBollini(idTransazione, cert);

			// impostazione del result code 
			result.setResultCode(RECEPISCIPAGAMENTOKO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recepisciPagamentoKO] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recepisciPagamentoABORT definito in un ExecCommand del
	 * ContentPanel cpEsitoPagamento
	 */
	public ExecResults recepisciPagamentoABORT(

			it.csi.sigit.sigitwebn.dto.esito_pagamento_bollini.CpEsitoPagamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECEPISCIPAGAMENTOABORT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-89876772) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(RECEPISCIPAGAMENTOABORT_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recepisciPagamentoABORT] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1745842080) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}
	/*PROTECTED REGION END*/
}
