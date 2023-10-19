package it.csi.sigit.sigitwebn.business.gestisci_delega;

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

/*PROTECTED REGION ID(R128039569) ENABLED START*/
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPfPgDelegaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.DelegaFilter;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;

/*PROTECTED REGION END*/

public class CPBECpGestDelega {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [delega, scope:USER_SESSION]
	public static final String APPDATA_DELEGA_CODE = "appDatadelega";

	// ApplicationData: [delegato, scope:USER_SESSION]
	public static final String APPDATA_DELEGATO_CODE = "appDatadelegato";

	// ApplicationData: [elencoDelegatiAssociati, scope:USER_SESSION]
	public static final String APPDATA_ELENCODELEGATIASSOCIATI_CODE = "appDataelencoDelegatiAssociati";

	// ApplicationData: [elencoDelegatiPotenziali, scope:USER_SESSION]
	public static final String APPDATA_ELENCODELEGATIPOTENZIALI_CODE = "appDataelencoDelegatiPotenziali";

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [idDelegatoAssociatoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDDELEGATOASSOCIATOSELEZ_CODE = "appDataidDelegatoAssociatoSelez";

	// ApplicationData: [idDelegatoPotenzialeSelez, scope:USER_SESSION]
	public static final String APPDATA_IDDELEGATOPOTENZIALESELEZ_CODE = "appDataidDelegatoPotenzialeSelez";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestDelega";

	public static final String MULTIPANEL_MPDELEGATI = "mpDelegati";
	public static final String MPI_MPDELEGATI_FPDELEGATI = CPNAME + "_" + MULTIPANEL_MPDELEGATI + "_" + "fpDelegati";

	public static final String MULTIPANEL_MPINSDELEGATO = "mpInsDelegato";
	public static final String MPI_MPINSDELEGATO_FPINSDELEGATO = CPNAME + "_" + MULTIPANEL_MPINSDELEGATO + "_"
			+ "fpInsDelegato";

	public static final String MULTIPANEL_MPDELEGATIPOTENZIALI = "mpDelegatiPotenziali";
	public static final String MPI_MPDELEGATIPOTENZIALI_FPDELEGATIPOTENZIALI = CPNAME + "_"
			+ MULTIPANEL_MPDELEGATIPOTENZIALI + "_" + "fpDelegatiPotenziali";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaImpresa definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults cercaImpresa(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAIMPRESA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-533465749) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Delega delega = theModel.getAppDatadelega();

				if (log.isDebugEnabled())
					GenericUtil.stampa(delega, true, 2);

				getValidationMgr().verificaManutentore(delega.getImpCf(), delega.getImpIdSiglaRea(),
						delega.getImpNumeroRea(), ConstantsField.GESTISCI_DELEGA_IMP_CF,
						ConstantsField.GESTISCI_DELEGA_IMP_SIGLA_REA, ConstantsField.GESTISCI_DELEGA_IMP_NUM_REA);

				PersonaGiuridica installatore = getSigitMgr().cercaPersonaGiuridica(delega.getImpCf(),
						delega.getImpIdSiglaRea(), delega.getImpNumeroRea(), false);

				if (installatore != null) {
					delega.setImpCf(ReplaceSpecialCharUtils.sanitize(installatore.getCodiceFiscale()));
					delega.setImpIdSiglaRea(ReplaceSpecialCharUtils.sanitize(installatore.getSiglaRea()));
					delega.setImpNumeroRea(installatore.getNumeroRea());
					delega.setImpImpresa(ReplaceSpecialCharUtils.sanitize(installatore.getDenominazione()));
					delega.setImpId(installatore.getIdPersonaGiuridica());

					log.debug("STAMPO L'IMPRESA TROVATA: " + delega.getImpId());

					// Devo recuperare l'elenco dei delegati

					ArrayList<Delegato> listDelegati = getDbMgr()
							.cercaPersonaFisDelByIdPersGiu(installatore.getIdPersonaGiuridica());

					theModel.setAppDataelencoDelegatiAssociati(listDelegati);

					// impostazione del result code
					result.setResultCode(CERCAIMPRESA_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add(Messages.I003);

					// impostazione del result code
					result.setResultCode(CERCAIMPRESA_OUTCOME_CODE__KO);
				}

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaImpresa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisBotCessa definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults gestVisBotCessa(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOTCESSA_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOTCESSA_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-266497643) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataelencoDelegatiAssociati() != null
					&& theModel.getAppDataelencoDelegatiAssociati().size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTCESSA_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTCESSA_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisBotCessa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaImpresa definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults nuovaRicercaImpresa(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2106362203) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// E' stato premuto "Nuova ricerca", pulisco l'id impresa 
			theModel.getAppDatadelega().setImpId(null);

			// impostazione del result code 
			result.setResultCode(NUOVARICERCAIMPRESA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaImpresa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestInserisciDelega definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults gestInserisciDelega(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINSERISCIDELEGA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R55320558) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Delegato delegato = new Delegato();

			delegato.setDataDelegaDal(DateUtil.getDataCorrenteFormat());

			theModel.setAppDatadelegato(delegato);

			// impostazione del result code 
			result.setResultCode(GESTINSERISCIDELEGA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestInserisciDelega] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestCessaLegame definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults gestCessaLegame(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTCESSALEGAME_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTCESSALEGAME_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-664768061) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String chiaveDelegato = theModel.getAppDataidDelegatoAssociatoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(chiaveDelegato);

				UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

				ArrayList<Delegato> delegatiList = theModel.getAppDataelencoDelegatiAssociati();

				for (Delegato delegato : delegatiList) {

					log.debug("STAMPO responsabile.getIdDelegato(): " + delegato.getIdDelegato());
					log.debug("STAMPO chiaveDelegato: " + chiaveDelegato);

					if (delegato.getIdDelegato().equalsIgnoreCase(chiaveDelegato)) {
						// Ho trovato il delegato selezionato

						if (log.isDebugEnabled())
							GenericUtil.stampa(delegato, true, 3);

						getValidationMgr().validazioneFormaleCessaDelega(delegato,
								utenteLoggato.getRuolo().getDescRuolo());

						Message msg = new Message(Messages.C001);
						theModel.setAppDatamessaggioDinamico(msg.getText());

					}
				}

				result.setResultCode(GESTCESSALEGAME_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestCessaLegame] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaPotenzialeDelegato definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults cercaPotenzialeDelegato(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAPOTENZIALEDELEGATO_OUTCOME_CODE__OK_SINGOLO = //NOSONAR  Reason:EIAS
				"OK_SINGOLO"; //NOSONAR  Reason:EIAS
		final String CERCAPOTENZIALEDELEGATO_OUTCOME_CODE__OK_MULTIPLO = //NOSONAR  Reason:EIAS
				"OK_MULTIPLO"; //NOSONAR  Reason:EIAS
		final String CERCAPOTENZIALEDELEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R697490180) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Delegato delegato = theModel.getAppDatadelegato();

			try {

				getValidationMgr().verificaRicercaDelegatiPotenziali(delegato);

				ArrayList<Delegato> listDelegati = getSigitMgr().cercaDelegatiPotenzialiCodFiscaleDenominazione(
						delegato.getCodiceFiscale(), delegato.getCognome());

				if (listDelegati.size() == 1) {

					Delegato delegatoNew = listDelegati.get(0);

					delegatoNew.setDataDelegaDal(delegato.getDataDelegaDal());

					theModel.setAppDatadelegato(delegatoNew);

					// impostazione del result code
					result.setResultCode(CERCAPOTENZIALEDELEGATO_OUTCOME_CODE__OK_SINGOLO);
				} else if (listDelegati.size() > 1) {
					theModel.setAppDataelencoDelegatiPotenziali(listDelegati);

					result.setResultCode(CERCAPOTENZIALEDELEGATO_OUTCOME_CODE__OK_MULTIPLO);

				} else {
					result.getGlobalErrors().add(Messages.I003);

					// impostazione del result code
					result.setResultCode(CERCAPOTENZIALEDELEGATO_OUTCOME_CODE__KO);
				}

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaPotenzialeDelegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaPotenzialeDelegato definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults nuovaRicercaPotenzialeDelegato(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAPOTENZIALEDELEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1015558538) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.getAppDatadelegato().setIdDelegato(null);

			// impostazione del result code 
			result.setResultCode(NUOVARICERCAPOTENZIALEDELEGATO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaPotenzialeDelegato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaDelegato definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults salvaDelegato(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVADELEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVADELEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-804308586) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Delega delega = theModel.getAppDatadelega();
				Delegato delegato = theModel.getAppDatadelegato();

				getValidationMgr().validazioneFormaleSalvaDelega(delega.getImpId(), delegato.getIdDelegato());

				// Posso proseguire

				getDbMgr().inserisciDelega(delega.getImpId(), delegato.getIdDelegato(),
						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				ArrayList<Delegato> listDelegati = getDbMgr().cercaPersonaFisDelByIdPersGiu(delega.getImpId());

				theModel.setAppDataelencoDelegatiAssociati(listDelegati);

				result.getGlobalMessages().add(Messages.INFO_DELEGA_INSERITA_CORRETTAMENTE);

				// impostazione del result code 
				result.setResultCode(SALVADELEGATO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaDelegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo impostaDelegato definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults impostaDelegato(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String IMPOSTADELEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String IMPOSTADELEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1446487938) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idDelegaSelez = theModel.getAppDataidDelegatoPotenzialeSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idDelegaSelez);

				ArrayList<Delegato> delegatiList = theModel.getAppDataelencoDelegatiPotenziali();

				for (Delegato delegato : delegatiList) {

					if (ConvertUtil.convertToInteger(delegato.getIdDelegato()).intValue() == idDelegaSelez) {
						// Ho trovato il delegato selezionato

						if (log.isDebugEnabled())
							GenericUtil.stampa(delegato, true, 3);

						Delegato delegatoOld = theModel.getAppDatadelegato();

						delegato.setDataDelegaDal(delegatoOld.getDataDelegaDal());

						theModel.setAppDatadelegato(delegato);
					}

				}

				// impostazione del result code 
				result.setResultCode(IMPOSTADELEGATO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::impostaDelegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cessaDelega definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults cessaDelega(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CESSADELEGA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CESSADELEGA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1700496219) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String chiaveDelegato = theModel.getAppDataidDelegatoAssociatoSelez();

			try {

				getDbMgr().cessaDelega(chiaveDelegato, theModel.getAppDatautenteLoggato().getCodiceFiscale());

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.I011, Message.INFO));

				ArrayList<Delegato> listDelegati = getDbMgr()
						.cercaPersonaFisDelByIdPersGiu(theModel.getAppDatadelega().getImpId());

				theModel.setAppDataelencoDelegatiAssociati(listDelegati);

				// impostazione del result code 
				result.setResultCode(CESSADELEGA_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

				log.debug("DEVO SETTARE L'ERRORE!!!!");
				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.ERROR_RECUPERO_SERVIZIO, Message.ERROR));
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cessaDelega] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisBotCessaConf definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults gestVisBotCessaConf(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOTCESSACONF_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOTCESSACONF_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R311446609) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataelencoDelegatiAssociati() != null
					&& theModel.getAppDataelencoDelegatiAssociati().size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTCESSACONF_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTCESSACONF_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisBotCessaConf] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-598808958) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoDelega(utente)) {
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
	 * Implementazione del metodo gestLogicaImpresaEnt definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults gestLogicaImpresaEnt(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAIMPRESAENT_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAIMPRESAENT_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2078896618) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result = gestLogicaImpresa(theModel, GESTLOGICAIMPRESAENT_OUTCOME_CODE__ABILITA,
					GESTLOGICAIMPRESAENT_OUTCOME_CODE__DISABILITA);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaImpresaEnt] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisBot definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults gestVisBot(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1273621468) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			SigitRPfPgDelegaDto pfPgDelega = getDbMgr().cercaSigitRPfPgDelegaAttByIdPersonaGiuridicaCFFisica(
					theModel.getAppDatadelega().getImpId(), theModel.getAppDatautenteLoggato().getCodiceFiscale());

			log.debug("STAMPO la pfPgDelega: " + pfPgDelega);

			Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();
			String descRuolo = ruolo.getDescRuoloCompleto();
			//			if(BooleanUtils.isTrue(ruolo.getIsCat())) 
			//				descRuolo = Constants.CAT_RUOLO_PREFISSO + descRuolo; 
			if (pfPgDelega != null && pfPgDelega.getFlgDelega().equalsIgnoreCase(Constants.FLAG_ACCREDITATO_A)
					&& !Constants.CAT_RUOLO_IMPRESA.equals(descRuolo)) {
				// impostazione del result code 
				result.setResultCode(GESTVISBOT_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTVISBOT_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisBot] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisBotCessaEnt definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults gestVisBotCessaEnt(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOTCESSAENT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOTCESSAENT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1111036280) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataelencoDelegatiAssociati() != null
					&& theModel.getAppDataelencoDelegatiAssociati().size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTCESSAENT_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTCESSAENT_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisBotCessaEnt] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciLogicaResetVis definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults gestisciLogicaResetVis(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCILOGICARESETVIS_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESETVIS_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1955008519) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("@@@ STAMPO theModel.getAppDatadelega(): " + theModel.getAppDatadelega());

			if (theModel.getAppDatadelega() == null) {
				// impostazione del result code 
				result.setResultCode(GESTISCILOGICARESETVIS_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCILOGICARESETVIS_OUTCOME_CODE__NO);
			}

			log.debug("@@@ STAMPO il result: " + result.getResultCode());

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciLogicaResetVis] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaImpresaRef definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults gestLogicaImpresaRef(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAIMPRESAREF_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAIMPRESAREF_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-832779454) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result = gestLogicaImpresa(theModel, GESTLOGICAIMPRESAREF_OUTCOME_CODE__ABILITA,
					GESTLOGICAIMPRESAREF_OUTCOME_CODE__DISABILITA);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaImpresaRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisBotRef definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults gestVisBotRef(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOTREF_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOTREF_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-384980511) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			SigitRPfPgDelegaDto pfPgDelega = getDbMgr().cercaSigitRPfPgDelegaAttByIdPersonaGiuridicaCFFisica(
					theModel.getAppDatadelega().getImpId(), theModel.getAppDatautenteLoggato().getCodiceFiscale());

			log.debug("STAMPO la pfPgDelega: " + pfPgDelega);

			if (pfPgDelega != null && pfPgDelega.getFlgDelega().equalsIgnoreCase(Constants.FLAG_ACCREDITATO_A)) {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTREF_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTREF_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisBotRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisBotCessaRef definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults gestVisBotCessaRef(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISBOTCESSAREF_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTVISBOTCESSAREF_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1800639792) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataelencoDelegatiAssociati() != null
					&& theModel.getAppDataelencoDelegatiAssociati().size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTCESSAREF_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTVISBOTCESSAREF_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisBotCessaRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneMessaggio definito in un ExecCommand del
	 * ContentPanel cpGestDelega
	 */
	public ExecResults gestioneMessaggio(

			it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEMESSAGGIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-886968197) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);

			log.debug("stampo il messaggio di errore: " + msg);

			if (msg != null && msg.isInfoMessage()) {
				result.getGlobalMessages().add(msg.getText());
				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
				log.debug("STAMPO L'INFO: " + msg.getText());
			} else if (msg != null && msg.isErrorMessage()) {
				result.getGlobalErrors().add(msg.getText());
				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
				log.debug("STAMPO L'ERRORE: " + msg.getText());
			}

			// impostazione del result code 
			result.setResultCode(GESTIONEMESSAGGIO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneMessaggio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbDelegatiAssociati
	 */
	public static void resetClearStatus_widg_tbDelegatiAssociati(java.util.Map session) {
		session.put("cpGestDelega_tbDelegatiAssociati_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbDelegatiPotenziali
	 */
	public static void resetClearStatus_widg_tbDelegatiPotenziali(java.util.Map session) {
		session.put("cpGestDelega_tbDelegatiPotenziali_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R977457539) ENABLED START*/
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

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	private ExecResults gestLogicaImpresa(it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel theModel,
			String codAbilita, String codDisabilita) throws DbManagerException {
		ExecResults result = new ExecResults();

		Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();

		//CodeDescription cd = null;
		if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
				|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {
			// impostazione del result code 
			result.setResultCode(codAbilita);
		} else {
			// impostazione del result code 
			result.setResultCode(codDisabilita);

			Delega delega = new Delega();

			delega.setImpId(ruolo.getIdPersonaGiuridica());
			delega.setImpIdSiglaRea(ruolo.getSiglaRea());
			delega.setImpNumeroRea(ConvertUtil.convertToUDTPositiveInteger(ruolo.getNumeroRea()));
			delega.setImpCf(ruolo.getCodiceFiscale());
			delega.setImpImpresa(ruolo.getDenomDitta());

			if (log.isDebugEnabled())
				GenericUtil.stampa(delega, true, 3);

			ArrayList<Delegato> listDelegati = getDbMgr().cercaPersonaFisDelByIdPersGiu(delega.getImpId());

			theModel.setAppDatadelega(delega);

			theModel.setAppDataelencoDelegatiAssociati(listDelegati);

		}

		return result;
	}

	/*PROTECTED REGION END*/
}
