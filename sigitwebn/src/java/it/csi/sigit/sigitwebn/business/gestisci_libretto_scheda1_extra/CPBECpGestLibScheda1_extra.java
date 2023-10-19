package it.csi.sigit.sigitwebn.business.gestisci_libretto_scheda1_extra;

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

/*PROTECTED REGION ID(R-1391204398) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;

/*PROTECTED REGION END*/

public class CPBECpGestLibScheda1_extra {

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

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [righeSelezionate, scope:USER_ACTION]
	public static final String APPDATA_RIGHESELEZIONATE_CODE = "appDatarigheSelezionate";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [listaDatiExtra, scope:USER_SESSION]
	public static final String APPDATA_LISTADATIEXTRA_CODE = "appDatalistaDatiExtra";

	// ApplicationData: [listaPkTabellaEdit, scope:USER_SESSION]
	public static final String APPDATA_LISTAPKTABELLAEDIT_CODE = "appDatalistaPkTabellaEdit";

	// ApplicationData: [listaPkCancellare, scope:USER_SESSION]
	public static final String APPDATA_LISTAPKCANCELLARE_CODE = "appDatalistaPkCancellare";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestLibScheda1_extra";

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
	 * ContentPanel cpGestLibScheda1_extra
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1_extra.CpGestLibScheda1_extraModel theModel

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
			/*PROTECTED REGION ID(R-1804182460) ENABLED START*/
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
	 * Implementazione del metodo onRipristina definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1_extra
	 */
	public ExecResults onRipristina(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1_extra.CpGestLibScheda1_extraModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONRIPRISTINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R830741343) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceImpianto = theModel.getAppDataidImpiantoSelez();
			ArrayList<DatiExtra> listDatiExtra = getSigitMgr().ricercaDatiExtra(codiceImpianto,
					GenericUtil.isUtenteAbilModLibWeb(theModel.getAppDatautenteLoggato()));

			ArrayList<PkTabellaEdit> listPkChiavi = creaTabPkFirst(listDatiExtra);

			theModel.setAppDatalistaDatiExtra(listDatiExtra);
			theModel.setAppDatalistaPkTabellaEdit(listPkChiavi);
			theModel.setAppDatarigheSelezionate(new ArrayList<String>());
			theModel.setAppDatalistaPkCancellare(new ArrayList<Integer>());

			// impostazione del result code 
			result.setResultCode(ONRIPRISTINA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onRipristina] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onRimuovi definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1_extra
	 */
	public ExecResults onRimuovi(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1_extra.CpGestLibScheda1_extraModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONRIMUOVI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1260876789) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<DatiExtra> listDatiExtra = theModel.getAppDatalistaDatiExtra();
			ArrayList<PkTabellaEdit> listPkChiavi = theModel.getAppDatalistaPkTabellaEdit();
			ArrayList<Integer> listPkChiaviCancellare = theModel.getAppDatalistaPkCancellare();

			ArrayList<String> listaRigheSelez = theModel.getAppDatarigheSelezionate();

			if (!GenericUtil.isNullOrEmpty(listaRigheSelez)) {
				int rigaSelez;

				if (listPkChiaviCancellare == null) {
					listPkChiaviCancellare = new ArrayList<Integer>();
				}

				List<DatiExtra> listDatiExtraNew = new ArrayList<DatiExtra>();
				List<PkTabellaEdit> listPkChiaviNew = new ArrayList<PkTabellaEdit>();

				for (int i = 0; i < listDatiExtra.size(); i++) {
					DatiExtra dato = listDatiExtra.get(i);
					PkTabellaEdit pk = listPkChiavi.get(i);
					if (!listaRigheSelez.contains(dato.getIndice().toString())) {
						listDatiExtraNew.add(dato);
						listPkChiaviNew.add(pk);
					} else {
						listPkChiaviCancellare.add(pk.getIdDb());
					}
				}

				//				for (String rigaSelezionata : listaRigheSelez) {
				//					rigaSelez = ConvertUtil.convertToInteger(rigaSelezionata);
				//
				//					PkTabellaEdit pkChiave = listPkChiavi.get(rigaSelez - 1);
				//
				//					// Verifico se l'elemento da eliminare ha l'id (del DB)
				//
				//					if (pkChiave != null && pkChiave.getIdDb() != null) {
				//						// Sto eliminando una riga che era presente sul DB
				//						listPkChiaviCancellare.add(pkChiave.getIdDb());
				//					}
				//
				//					listDatiExtra.remove(rigaSelez - 1);
				//					listPkChiavi.remove(rigaSelez - 1);
				//
				//				}
				//				
				listDatiExtra = creaTabWeb((ArrayList<DatiExtra>) listDatiExtraNew);
				listPkChiavi = creaTabPk((ArrayList<PkTabellaEdit>) listPkChiaviNew);

				theModel.setAppDatalistaPkCancellare(listPkChiaviCancellare);
				theModel.setAppDatalistaDatiExtra(listDatiExtra);
				theModel.setAppDatalistaPkTabellaEdit(listPkChiavi);
				theModel.setAppDatarigheSelezionate(new ArrayList<String>());

				resetClearStatus_widg_tbPodPdr(theModel.getSession());

				//result.getGlobalMessages().add(Messages.INFO_ELIMINAZIONE_CORRETTA);
			} else {
				result.getGlobalErrors().add(Messages.ERROR_SELEZIONARE_RIGA);
			}

			// impostazione del result code 
			result.setResultCode(ONRIMUOVI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

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
	 * Implementazione del metodo onAggiungiConsumo definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1_extra
	 */
	public ExecResults onAggiungiConsumo(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1_extra.CpGestLibScheda1_extraModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONAGGIUNGICONSUMO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ONAGGIUNGICONSUMO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1126567211) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<DatiExtra> listDatiExtra = theModel.getAppDatalistaDatiExtra();
			ArrayList<PkTabellaEdit> listPkChiavi = theModel.getAppDatalistaPkTabellaEdit();

			DatiExtra datiExtraNew = new DatiExtra();
			// Se l'utente ha potuto fare "aggiungi riga" vuol dire che è abilitato alla compilazione
			datiExtraNew.setDatoEditabile(true);

			listDatiExtra.add(datiExtraNew);
			listPkChiavi.add(new PkTabellaEdit());

			listDatiExtra = creaTabWeb(listDatiExtra);
			listPkChiavi = creaTabPk(listPkChiavi);

			/*
			DatiExtra datoExtraNew = new DatiExtra();
			datoExtraNew.setIndice(listDatiExtra.size());
			
			PkTabellaEdit pkTabella = new PkTabellaEdit();
			pkTabella.setIndice(listPkChiavi.size()-1);
			*/

			theModel.setAppDatalistaDatiExtra(listDatiExtra);
			theModel.setAppDatalistaPkTabellaEdit(listPkChiavi);
			theModel.setAppDatarigheSelezionate(new ArrayList<String>());

			//result.getGlobalMessages().add(Messages.INFO_INSERIMENTO_CORRETTO);

			// impostazione del result code 
			result.setResultCode(ONAGGIUNGICONSUMO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onAggiungiConsumo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaScheda1_extra definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1_extra
	 */
	public ExecResults salvaScheda1_extra(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1_extra.CpGestLibScheda1_extraModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVASCHEDA1_EXTRA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVASCHEDA1_EXTRA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1819127654) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			String codiceImpianto = theModel.getAppDataidImpiantoSelez();

			try {
				ArrayList<DatiExtra> listDatiExtra = theModel.getAppDatalistaDatiExtra();
				ArrayList<PkTabellaEdit> listPkChiavi = theModel.getAppDatalistaPkTabellaEdit();
				ArrayList<Integer> listPkChiaviCancellare = theModel.getAppDatalistaPkCancellare();

				// VALIDAZIONE
				getValidationMgr().validazioneFormaleLibrettoScheda1_extra(listDatiExtra, result);

				getSigitMgr().salvaLibrettoScheda1_extra(listDatiExtra, listPkChiavi, listPkChiaviCancellare,
						codiceImpianto, utente.getCodiceFiscale());

				// Ricarico i dati e ricreo le strutture
				listDatiExtra = getSigitMgr().ricercaDatiExtra(codiceImpianto,
						GenericUtil.isUtenteAbilModLibWeb(utente));
				listPkChiavi = creaTabPkFirst(listDatiExtra);

				theModel.setAppDatalistaDatiExtra(listDatiExtra);
				theModel.setAppDatalistaPkTabellaEdit(listPkChiavi);
				theModel.setAppDatarigheSelezionate(new ArrayList<String>());
				theModel.setAppDatalistaPkCancellare(new ArrayList<Integer>());

				result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);

				// impostazione del result code 
				result.setResultCode(SALVASCHEDA1_EXTRA_OUTCOME_CODE__OK);

				// modifica degli attributi del model (che verranno propagati allo strato
				// di presentation). si puo' agire anche direttamente sull'attributo "session".
			} catch (ManagerException ex) {
				Validator.gestisciEccezioneTabellaEditabile(result, ex);
				result.setResultCode(SALVASCHEDA1_EXTRA_OUTCOME_CODE__KO);
			}
			resetClearStatus_widg_tbPodPdr(theModel.getSession());
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaScheda1_extra] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1_extra
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1_extra.CpGestLibScheda1_extraModel theModel

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
			/*PROTECTED REGION ID(R-456458933) ENABLED START*/
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
	 * ContentPanel cpGestLibScheda1_extra
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1_extra.CpGestLibScheda1_extraModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1319530273) ENABLED START*/
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
	 * Implementazione del metodo cercaDatiAggiuntivi definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1_extra
	 */
	public ExecResults cercaDatiAggiuntivi(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1_extra.CpGestLibScheda1_extraModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCADATIAGGIUNTIVI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1514840134) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceImpianto = theModel.getAppDataidImpiantoSelez();

			ArrayList<DatiExtra> listDatiExtra = getSigitMgr().ricercaDatiExtra(codiceImpianto,
					GenericUtil.isUtenteAbilModLibWeb(theModel.getAppDatautenteLoggato()));

			ArrayList<PkTabellaEdit> listPkChiavi = creaTabPkFirst(listDatiExtra);

			theModel.setAppDatalistaDatiExtra(listDatiExtra);
			theModel.setAppDatalistaPkTabellaEdit(listPkChiavi);
			theModel.setAppDatarigheSelezionate(new ArrayList<String>());
			theModel.setAppDatalistaPkCancellare(new ArrayList<Integer>());

			// impostazione del result code 
			result.setResultCode(CERCADATIAGGIUNTIVI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaDatiAggiuntivi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilitazione definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda1_extra
	 */
	public ExecResults gestisciAbilitazione(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1_extra.CpGestLibScheda1_extraModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONE_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONE_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1098556085) ENABLED START*/
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
	 * ContentPanel cpGestLibScheda1_extra
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda1_extra.CpGestLibScheda1_extraModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1867856803) ENABLED START*/
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
	 * permette di resettare lo stato di paginazione della tabella widg_tbPodPdr
	 */
	public static void resetClearStatus_widg_tbPodPdr(java.util.Map session) {
		session.put("cpGestLibScheda1_extra_tbPodPdr_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1476918046) ENABLED START*/
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

	private static ArrayList<PkTabellaEdit> creaTabPkFirst(ArrayList<DatiExtra> listDatiExtra) {
		log.debug("[CPBECpGestLibScheda1_extra::creaTabPkFirst] : START");

		ArrayList<PkTabellaEdit> listPkChiavi = new ArrayList<PkTabellaEdit>();

		PkTabellaEdit pkChiave;
		DatiExtra datoExtra;

		for (int i = 0; i < listDatiExtra.size(); i++) {
			datoExtra = listDatiExtra.get(i);

			pkChiave = new PkTabellaEdit();
			pkChiave.setIndice(i + 1);
			pkChiave.setIdDb(datoExtra.getIdUnitaImm());

			listPkChiavi.add(pkChiave);
		}

		log.debug("[CPBECpGestLibScheda1_extra::creaTabPkFirst] : END");

		return listPkChiavi;
	}

	private static ArrayList<DatiExtra> creaTabWeb(ArrayList<DatiExtra> listRisultatiWebOld) {
		log.debug("[CPBECpGestLibScheda1_extra::creaTabWeb] : START");

		ArrayList<DatiExtra> listRisultatiWebNew = new ArrayList<DatiExtra>();

		DatiExtra datoExtraNew;
		DatiExtra datoExtraOld;

		for (int i = 0; i < listRisultatiWebOld.size(); i++) {
			datoExtraOld = listRisultatiWebOld.get(i);

			datoExtraNew = new DatiExtra();
			datoExtraNew.setIndice(i + 1);
			datoExtraNew.setSezione(datoExtraOld.getSezione());
			datoExtraNew.setFoglio(datoExtraOld.getFoglio());
			datoExtraNew.setParticella(datoExtraOld.getParticella());
			datoExtraNew.setSubalterno(datoExtraOld.getSubalterno());
			datoExtraNew.setPod(datoExtraOld.getPod());
			datoExtraNew.setPdr(datoExtraOld.getPdr());
			datoExtraNew.setDatoEditabile(datoExtraOld.getDatoEditabile());

			listRisultatiWebNew.add(datoExtraNew);
		}

		log.debug("[CPBECpGestLibScheda1_extra::creaTabWeb] : START");

		return listRisultatiWebNew;
	}

	private static ArrayList<PkTabellaEdit> creaTabPk(ArrayList<PkTabellaEdit> listRisultatiPkOld) {
		log.debug("[CPBECpGestLibScheda1_extra::creaTabPk] : START");

		ArrayList<PkTabellaEdit> listRisultatiPkNew = new ArrayList<PkTabellaEdit>();

		PkTabellaEdit pkNew;
		PkTabellaEdit pkOld;

		for (int i = 0; i < listRisultatiPkOld.size(); i++) {
			pkOld = listRisultatiPkOld.get(i);

			pkNew = new PkTabellaEdit();
			pkNew.setIndice(i + 1);
			pkNew.setIdDb(pkOld.getIdDb());

			listRisultatiPkNew.add(pkNew);
		}

		log.debug("[CPBECpGestLibScheda1_extra::creaTabPk] : START");

		return listRisultatiPkNew;
	}

	/*PROTECTED REGION END*/
}
