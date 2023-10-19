package it.csi.sigit.sigitwebn.business.gestisci_ree_confirm;

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

/*PROTECTED REGION ID(R1462376983) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ConnectorMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitwebn.util.mail.ResultInvioMail;

/*PROTECTED REGION END*/

public class CPBECpGestReeConfirm {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [allegato, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATO_CODE = "appDataallegato";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestReeConfirm";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaInvioREE definito in un ExecCommand del
	 * ContentPanel cpGestReeConfirm
	 */
	public ExecResults verificaInvioREE(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_confirm.CpGestReeConfirmModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAINVIOREE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAINVIOREE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1958499618) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				DettaglioAllegato dettaglioAllegato = theModel.getAppDataallegato();
				log.debug("verificaInvioREE - dettaglioAllegato: " + dettaglioAllegato);

				//vado a cercare il dettaglio dell'allegato con la primary Key
				dettaglioAllegato = getDbMgr().getDettaglioAllegatoByIdAllegato(
						ConvertUtil.convertToInteger(dettaglioAllegato.getIdAllegato()),
						dettaglioAllegato.getCodiceImpianto());

				if (log.isDebugEnabled())
					GenericUtil.stampa(dettaglioAllegato, true, 3);

				UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();
				log.debug("utenteLoggato: " + utenteLoggato);

				// Recupero l'utente loggato per capire se e' un CAT
				Ruolo ruoloUtente = utenteLoggato.getRuolo();

				log.debug("ruoloUtente: " + ruoloUtente);

				// Ho centralizzato i controlli
				getValidationMgr().validazioneFormaleInviaAllegato(dettaglioAllegato, ruoloUtente);

				Message msg = new Message(Messages.C003, "REE");
				theModel.setAppDatamessaggioDinamico(msg.getText());

				// impostazione del result code 
				result.setResultCode(VERIFICAINVIOREE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE, ex.getMsg());
				result.setResultCode(VERIFICAINVIOREE_OUTCOME_CODE__KO);

				//Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaInvioREE] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaInviaAllegato definito in un ExecCommand del
	 * ContentPanel cpGestReeConfirm
	 */
	public ExecResults salvaInviaAllegato(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_confirm.CpGestReeConfirmModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAINVIAALLEGATO_OUTCOME_CODE__OK_ALLEGATI = //NOSONAR  Reason:EIAS
				"OK_ALLEGATI"; //NOSONAR  Reason:EIAS
		final String SALVAINVIAALLEGATO_OUTCOME_CODE__OK_IMPIANTO = //NOSONAR  Reason:EIAS
				"OK_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String SALVAINVIAALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1807511627) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioAllegato dettaglioAllegato = theModel.getAppDataallegato();

			SigitVRicercaAllegatiDto allegatoDto = getDbMgr()
					.cercaSigitVRicercaAllegatiByIdAllegato(dettaglioAllegato.getIdAllegato());

			log.debug("salvaInviaAllegato - allegatoDto: " + allegatoDto);

			Integer idStatoRapp = ConvertUtil.convertToInteger(allegatoDto.getFkStatoRapp());
			if (Constants.ID_STATO_RAPPORTO_INVIATO == idStatoRapp
					|| Constants.ID_STATO_RAPPORTO_RESPINTO == idStatoRapp) {

				//				result.getGlobalErrors().add(Messages.S129);
				//				
				//				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
				//						new Message(Messages.S129, Message.ERROR));
				//
				//				result.setResultCode(SALVAINVIAALLEGATO_OUTCOME_CODE__KO);

				throw new ManagerException(new Message(Messages.S129));

				//session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.S129, Message.ERROR));
				//return "KO";

			} else {

				log.debug("prima dell'invio");

				UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();
				log.debug("utenteLoggato: " + utenteLoggato);

				// Recupero l'utente loggato per capire se e' un CAT
				Ruolo ruoloUtente = utenteLoggato.getRuolo();

				ResultInvioMail resultInvioMail = getConnectorMgr().inviaAllegatoTrans(dettaglioAllegato,
						ruoloUtente.getIdPgCat(), utenteLoggato);

				log.debug("dopo l'invio");

				// BUG - devo verificare che l'allegano non sia gia' in stato INVIATO, l'utente potrebbe aver fatto F5

				String msg = getSigitMgr().getMsgInvioRee(dettaglioAllegato, allegatoDto, resultInvioMail);

				String arrivoDa = dettaglioAllegato.getArrivoDa() != null ? dettaglioAllegato.getArrivoDa() : ""; // dovrebbe essere sempre valorizzato

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE, new Message(msg, Message.INFO));

				// pulisco questo campo, altrimenti poi viene visualizzato sull'elenco
				theModel.setAppDatamessaggioDinamico(null);

				if (arrivoDa.equals(Constants.ARRIVO_DA_ALLEGATI)) {
					result.setResultCode(SALVAINVIAALLEGATO_OUTCOME_CODE__OK_ALLEGATI);

				} else if (arrivoDa.equals(Constants.ARRIVO_DA_IMPIANTO)) {
					result.setResultCode(SALVAINVIAALLEGATO_OUTCOME_CODE__OK_IMPIANTO);

				} else {
					// Non so dove ritornare
					result.setResultCode(SALVAINVIAALLEGATO_OUTCOME_CODE__KO);
				}

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaInviaAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestReeConfirm
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_confirm.CpGestReeConfirmModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1082734020) ENABLED START*/
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

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R641637053) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
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

	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	/*PROTECTED REGION END*/
}
