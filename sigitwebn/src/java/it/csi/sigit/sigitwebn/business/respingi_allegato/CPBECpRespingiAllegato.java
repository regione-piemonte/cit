package it.csi.sigit.sigitwebn.business.respingi_allegato;

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

/*PROTECTED REGION ID(R-2081840716) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.ConnectorMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.util.mail.ResultInvioMail;

/*PROTECTED REGION END*/

public class CPBECpRespingiAllegato {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [dettaglioElencoAllegati, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOELENCOALLEGATI_CODE = "appDatadettaglioElencoAllegati";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

	// ApplicationData: [paginaChiamanteAllegati, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEALLEGATI_CODE = "appDatapaginaChiamanteAllegati";

	// ApplicationData: [aggiornaElencoAllegati, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOALLEGATI_CODE = "appDataaggiornaElencoAllegati";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRespingiAllegato";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo confermaRespingiAllegato definito in un ExecCommand del
	 * ContentPanel cpRespingiAllegato
	 */
	public ExecResults confermaRespingiAllegato(

			it.csi.sigit.sigitwebn.dto.respingi_allegato.CpRespingiAllegatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CONFERMARESPINGIALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CONFERMARESPINGIALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-569298190) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				getValidationMgr().validazioneFormaleConfRespingiAllegato(theModel.getAppDatadettaglioElencoAllegati());

				ResultInvioMail resultInvioMail = getConnectorMgr().respingiAllegato(
						ConvertUtil.convertToString(theModel.getAppDatadettaglioElencoAllegati().getId()),
						theModel.getAppDatautenteLoggato(), theModel.getAppDatadettaglioElencoAllegati().getMotivo());

				// INIZIO PROVA
				//ResultInvioMail resultInvioMail = new ResultInvioMail();
				//				resultInvioMail.addDestinatarioOK("beppe@libero.it");
				//				resultInvioMail.addDestinatarioOK("beppeto@libero.it");
				//
				//				resultInvioMail.addDestinatarioKO("beppeto@pippo.libero.it");
				//				resultInvioMail.addDestinatarioKO("beppeto@.tilibero.it");

				//				if (false)
				//					throw new ManagerException(null);

				// FINE PROVA

				String msg = GenericUtil.getMsgFormatterHtml(resultInvioMail,
						Messages.INFO_ALLEGATO_RESPINTO_CORRETTAMENTE);

				/*
				StringBuffer msg = new StringBuffer(Messages.INFO_ALLEGATO_RESPINTO_CORRETTAMENTE);
				
				
				
				if (GenericUtil.isNotNullOrEmpty(resultInvioMail)) {
				
					msg = resultInvioMail.getMsgSBFormatterHtml(msg.toString());
					
					
				} else {
				
					msg.append(Messages.INFO_NESSUNA_MAIL_INVIATA);
				}
				 */

				theModel.setAppDatamessaggioDinamico(ReplaceSpecialCharUtils.sanitize(msg));

				theModel.setAppDataaggiornaElencoAllegati(true);

				//result.getGlobalMessages().add(messaggio.getText());

				// impostazione del result code 
				result.setResultCode(CONFERMARESPINGIALLEGATO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::confermaRespingiAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestRitornoPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpRespingiAllegato
	 */
	public ExecResults gestRitornoPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.respingi_allegato.CpRespingiAllegatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTRITORNOPAGINACHIAMANTE_OUTCOME_CODE__ELENCO_ALL_IMPIANTO = //NOSONAR  Reason:EIAS
				"ELENCO_ALL_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String GESTRITORNOPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_ALLEGATI = //NOSONAR  Reason:EIAS
				"RIS_RIC_ALLEGATI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1770271585) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDatapaginaChiamanteAllegati().equals(Constants.PAG_ELENCO_ALL_IMPIANTI)) {
				// impostazione del result code 
				result.setResultCode(GESTRITORNOPAGINACHIAMANTE_OUTCOME_CODE__ELENCO_ALL_IMPIANTO);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTRITORNOPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_ALLEGATI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestRitornoPaginaChiamante] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpRespingiAllegato
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.respingi_allegato.CpRespingiAllegatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__ELENCO_ALL_IMPIANTO = //NOSONAR  Reason:EIAS
				"ELENCO_ALL_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_ALLEGATI = //NOSONAR  Reason:EIAS
				"RIS_RIC_ALLEGATI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R480240681) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDatapaginaChiamanteAllegati().equals(Constants.PAG_ELENCO_ALL_IMPIANTI)) {
				// impostazione del result code 
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__ELENCO_ALL_IMPIANTO);

			} else if (theModel.getAppDatapaginaChiamanteAllegati().equals(Constants.PAG_RIS_RIC_AVZ_ALLEGATI)) {
				// impostazione del result code 
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_ALLEGATI);
			}

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

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R2113644864) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)

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

	/*PROTECTED REGION END*/
}
