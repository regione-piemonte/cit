package it.csi.sigit.sigitwebn.business.gestisci_libretto_scheda14_3;

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

/*PROTECTED REGION ID(R143883121) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDCombustibileDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTConsumoDaoException;

/*PROTECTED REGION END*/

public class CPBECpGestLibScheda14_3 {

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

	// ApplicationData: [risultatoRicercaImpianti, scope:USER_SESSION]
	public static final String APPDATA_RISULTATORICERCAIMPIANTI_CODE = "appDatarisultatoRicercaImpianti";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [righeSelezionate, scope:USER_ACTION]
	public static final String APPDATA_RIGHESELEZIONATE_CODE = "appDatarigheSelezionate";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [elencoTipoUnitaMisura, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOUNITAMISURA_CODE = "appDataelencoTipoUnitaMisura";

	// ApplicationData: [listaPkCancellare, scope:USER_SESSION]
	public static final String APPDATA_LISTAPKCANCELLARE_CODE = "appDatalistaPkCancellare";

	// ApplicationData: [controlloLibretto, scope:USER_SESSION]
	public static final String APPDATA_CONTROLLOLIBRETTO_CODE = "appDatacontrolloLibretto";

	// ApplicationData: [consumoAcqua, scope:USER_SESSION]
	public static final String APPDATA_CONSUMOACQUA_CODE = "appDataconsumoAcqua";

	// ApplicationData: [listaConsumiTrovati, scope:USER_SESSION]
	public static final String APPDATA_LISTACONSUMITROVATI_CODE = "appDatalistaConsumiTrovati";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestLibScheda14_3";

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
	 * ContentPanel cpGestLibScheda14_3
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda14_3.CpGestLibScheda14_3Model theModel

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
			/*PROTECTED REGION ID(R-1444596445) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(
					GenericUtil.gestisciTreeClick(theModel.getIdNodo(), theModel.getAppDatalibrettoMenuTree()));

			// Setto la pagina in cui sto andando, mi servirà nel caso ci sia necessità di ricaricare la pagina con un messaggio (es. consolida libretto)
			theModel.getSession().put(Constants.SESSIONE_VAR_LIBRETTO_SCHEDA, result.getResultCode());

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
	 * Implementazione del metodo onRipristinaConsumo definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda14_3
	 */
	public ExecResults onRipristinaConsumo(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda14_3.CpGestLibScheda14_3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONRIPRISTINACONSUMO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1894476946) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			loadDatiScheda(theModel);

			theModel.setAppDatarigheSelezionate(new ArrayList<String>());
			theModel.setAppDatalistaPkCancellare(new ArrayList<Integer>());

			// impostazione del result code 
			result.setResultCode(ONRIPRISTINACONSUMO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onRipristinaConsumo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onRimuovi definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda14_3
	 */
	public ExecResults onRimuovi(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda14_3.CpGestLibScheda14_3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONRIMUOVI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2087317334) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (theModel.getAppDatarigheSelezionate() == null || theModel.getAppDatarigheSelezionate().isEmpty()) {
				result.getGlobalErrors().add(Messages.ERROR_SELEZIONARE_RIGA);
			} else {
				List<Consumo> newDtos = new ArrayList<Consumo>();
				List<Consumo> listaConsumiTrovati = theModel.getAppDataconsumoAcqua().getListaConsumi();
				if (listaConsumiTrovati != null) {
					for (Consumo oldDtos : listaConsumiTrovati) {
						if (!theModel.getAppDatarigheSelezionate().contains(oldDtos.getIndice().toString())) {
							oldDtos.setIndice(newDtos.size() + 1);
							newDtos.add(oldDtos);
						} else {
							theModel.getAppDatalistaPkCancellare().add(oldDtos.getIdConsumo());
						}
					}

					theModel.getAppDataconsumoAcqua().setListaConsumi((ArrayList<Consumo>) newDtos);
				}
				theModel.setAppDatarigheSelezionate(null);
			}
			theModel.setAppDatalistaConsumiTrovati(theModel.getAppDataconsumoAcqua().getListaConsumi());
			resetClearStatus_widg_tbConsumoCombustibile(theModel.getSession());

			result.setResultCode(ONRIMUOVI_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onRimuovi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaScheda definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda14_3
	 */
	public ExecResults salvaScheda(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda14_3.CpGestLibScheda14_3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVASCHEDA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVASCHEDA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1401840997) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			String codiceImpianto = theModel.getAppDataidImpiantoSelez();

			try {
				// VALIDAZIONE
				getValidationMgr().validazioneFormaleLibrettoScheda14_3(theModel.getAppDataconsumoAcqua(),
						theModel.getAppDatacontrolloLibretto(), result);

				getSigitMgr().salvaLibrettoScheda14_3_Trans(theModel.getAppDataconsumoAcqua(),
						theModel.getAppDatalistaPkCancellare(), codiceImpianto, utente.getCodiceFiscale(),
						utente.getRuolo().getCodiceRea());

				theModel.setAppDatarigheSelezionate(new ArrayList<String>());
				theModel.setAppDatalistaPkCancellare(new ArrayList<Integer>());

				// Ricarico i dati e ricreo le strutture
				loadDatiScheda(theModel);

				result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);

				// impostazione del result code 
				result.setResultCode(SALVASCHEDA_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezioneTabellaEditabile(result, ex);
				Validator.gestisciEccezione(result, ex);
				result.setResultCode(SALVASCHEDA_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaScheda] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onAggiungi definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda14_3
	 */
	public ExecResults onAggiungi(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda14_3.CpGestLibScheda14_3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONAGGIUNGI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ONAGGIUNGI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-102803672) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			List<Consumo> listaConsumiTrovati = theModel.getAppDataconsumoAcqua().getListaConsumi();
			if (listaConsumiTrovati == null) {
				listaConsumiTrovati = new ArrayList<Consumo>();
			}

			Consumo consumoNew = new Consumo();
			// Se l'utente ha potuto fare "aggiungi riga" vuol dire che è abilitato alla compilazione
			consumoNew.setDatoEditabile(true);
			consumoNew.setIndice(listaConsumiTrovati.size() + 1);
			listaConsumiTrovati.add(consumoNew);

			theModel.getAppDataconsumoAcqua().setListaConsumi((ArrayList<Consumo>) listaConsumiTrovati);
			theModel.setAppDatalistaConsumiTrovati(theModel.getAppDataconsumoAcqua().getListaConsumi());
			theModel.setAppDatarigheSelezionate(new ArrayList<String>());

			result.setResultCode(ONAGGIUNGI_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onAggiungi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda14_3
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda14_3.CpGestLibScheda14_3Model theModel

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
			/*PROTECTED REGION ID(R-829903028) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(GenericUtil.gestisciTreeIndietro(theModel.getAppDatapaginaChiamante()));

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
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda14_3
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda14_3.CpGestLibScheda14_3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2126034526) ENABLED START*/
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
	 * Implementazione del metodo cercaConsumi definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda14_3
	 */
	public ExecResults cercaConsumi(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda14_3.CpGestLibScheda14_3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCACONSUMI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2076191224) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataelencoTipoUnitaMisura() == null
					|| theModel.getAppDataelencoTipoUnitaMisura().isEmpty()) {
				theModel.setAppDataelencoTipoUnitaMisura(getSigitMgr().getListUnitaMisura());
			}

			theModel.setAppDatarigheSelezionate(new ArrayList<String>());
			theModel.setAppDatalistaPkCancellare(new ArrayList<Integer>());

			loadDatiScheda(theModel);
			// impostazione del result code 
			result.setResultCode(CERCACONSUMI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaConsumi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazione definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda14_3
	 */
	public ExecResults gestisciAbilitazione(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda14_3.CpGestLibScheda14_3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONE_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONE_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R725111990) ENABLED START*/
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
	 * Implementazione del metodo gestisciMsg definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda14_3
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda14_3.CpGestLibScheda14_3Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1508270788) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			GenericUtil.gestisciMessaggioSessione(theModel, result);

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

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbConsumoCombustibile
	 */
	public static void resetClearStatus_widg_tbConsumoCombustibile(java.util.Map session) {
		session.put("cpGestLibScheda14_3_tbConsumoCombustibile_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1202489501) ENABLED START*/
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

	private static ArrayList<PkTabellaEdit> creaTabPkFirst(ArrayList<Consumo> listDatiExtra) {
		log.debug("[CPBECpGestLibScheda14_3::creaTabPkFirst] : START");

		ArrayList<PkTabellaEdit> listPkChiavi = new ArrayList<PkTabellaEdit>();

		PkTabellaEdit pkChiave;
		Consumo dato;

		for (int i = 0; i < listDatiExtra.size(); i++) {
			dato = listDatiExtra.get(i);

			pkChiave = new PkTabellaEdit();
			pkChiave.setIndice(i);
			pkChiave.setIdDb(dato.getIdConsumo());

			listPkChiavi.add(pkChiave);
		}

		log.debug("[CPBECpGestLibScheda14_3::creaTabPkFirst] : END");

		return listPkChiavi;
	}

	private static ArrayList<Consumo> creaTabWeb(ArrayList<Consumo> listRisultatiWebOld) {
		log.debug("[CPBECpGestLibScheda14_3::creaTabWeb] : START");

		ArrayList<Consumo> listRisultatiWebNew = new ArrayList<Consumo>();

		Consumo datoExtraNew;
		Consumo datoExtraOld;

		for (int i = 0; i < listRisultatiWebOld.size(); i++) {
			datoExtraOld = listRisultatiWebOld.get(i);

			datoExtraNew = new Consumo();
			datoExtraNew.setIndice(i + 1);

			datoExtraNew.setIdConsumo(datoExtraOld.getIdConsumo());
			datoExtraNew.setEsercizioDa(datoExtraOld.getEsercizioDa());
			datoExtraNew.setEsercizioA(datoExtraOld.getEsercizioA());
			datoExtraNew.setCodiceImpianto(datoExtraOld.getCodiceImpianto());
			datoExtraNew.setLetturaIniziale(datoExtraOld.getLetturaIniziale());
			datoExtraNew.setLetturaFinale(datoExtraOld.getLetturaFinale());
			datoExtraNew.setConsumo(datoExtraOld.getConsumo());
			datoExtraNew.setUnitaMisura(datoExtraOld.getUnitaMisura());
			datoExtraNew.setDatoEditabile(datoExtraOld.getDatoEditabile());

			listRisultatiWebNew.add(datoExtraNew);

		}

		log.debug("[CPBECpGestLibScheda14_3::creaTabWeb] : START");

		return listRisultatiWebNew;
	}

	private static ArrayList<PkTabellaEdit> creaTabPk(ArrayList<PkTabellaEdit> listRisultatiPkOld) {
		log.debug("[CPBECpGestLibScheda14_3::creaTabPk] : START");

		ArrayList<PkTabellaEdit> listRisultatiPkNew = new ArrayList<PkTabellaEdit>();

		PkTabellaEdit pkNew;
		PkTabellaEdit pkOld;

		for (int i = 0; i < listRisultatiPkOld.size(); i++) {
			pkOld = listRisultatiPkOld.get(i);

			pkNew = new PkTabellaEdit();
			pkNew.setIndice(i);
			pkNew.setIdDb(pkOld.getIdDb());

			listRisultatiPkNew.add(pkNew);
		}

		log.debug("[CPBECpGestLibScheda14_3::creaTabPk] : START");

		return listRisultatiPkNew;
	}

	private void loadDatiScheda(
			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda14_3.CpGestLibScheda14_3Model theModel)
			throws SigitTConsumoDaoException, SigitDCombustibileDaoException, ManagerException {

		String codiceImpianto = theModel.getAppDataidImpiantoSelez();
		ConsumoAcqua consumoAcqua = getSigitMgr().ricercaConsumoAcquaImpianto(codiceImpianto,
				GenericUtil.isUtenteAbilModLibWeb(theModel.getAppDatautenteLoggato()));
		theModel.setAppDataconsumoAcqua(consumoAcqua);
		theModel.setAppDatalistaConsumiTrovati(consumoAcqua.getListaConsumi());

	}

	/*
	private ArrayList<Consumo> copyListaConsumi(ArrayList<Consumo> listRisultatiConsumo)
			throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		ArrayList<Consumo> listRisultatiConsumoBE = new ArrayList<Consumo>();
		for (Consumo consumo : listRisultatiConsumo) {
			Consumo consumoNew = new Consumo();
			PropertyUtils.copyProperties(consumoNew, consumo);
			listRisultatiConsumoBE.add(consumoNew);
		}
		return listRisultatiConsumoBE;
	}
	
	private ArrayList<Consumo> copyValueConsumo(ArrayList<Consumo> listaConsumiFE, ArrayList<Consumo> listaConsumiBE,
			Boolean fromAggiungiConsumo,
			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda14_3.CpGestLibScheda14_3Model theModel) {
		log.debug("listaConsumiFE ------>" + listaConsumiFE.size());
		log.debug("listaConsumiBE ------>" + listaConsumiBE.size());
		for (int i = 0; i < listaConsumiFE.size(); i++) {
			//listaConsumiFE.get(i).setListaCombustibile(theModel.getAppDataelencoTipoCombustibili());
			listaConsumiFE.get(i).setListaUnitaMisura(theModel.getAppDataelencoTipoUnitaMisura());
		}
		if (fromAggiungiConsumo) {
			Consumo newConsumo = new Consumo();
			//newConsumo.setListaCombustibile(theModel.getAppDataelencoTipoCombustibili());
			newConsumo.setListaUnitaMisura(theModel.getAppDataelencoTipoUnitaMisura());
			listaConsumiFE.add(newConsumo);
		}
		Integer indice = new Integer(1);
		for (Consumo consumo : listaConsumiFE) {
			consumo.setIndice(indice);
			indice++;
		}
		return listaConsumiFE;
	}
	*/

	/*PROTECTED REGION END*/
}
