package it.csi.sigit.sigitwebn.business.gestisci_libretto_scheda13;

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

/*PROTECTED REGION ID(R1861336454) ENABLED START*/
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllegatoRappProvaByIdAllegatoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllegatoRappProvaByIdIspezioneDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicercaIspezioniDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.IspezioneFilter;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
/*PROTECTED REGION END*/

public class CPBECpGestLibScheda13 {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [librettoMenuTree, scope:USER_SESSION]
	public static final String APPDATA_LIBRETTOMENUTREE_CODE = "appDatalibrettoMenuTree";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [scheda12, scope:USER_SESSION]
	public static final String APPDATA_SCHEDA12_CODE = "appDatascheda12";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [scheda11Intest, scope:USER_SESSION]
	public static final String APPDATA_SCHEDA11INTEST_CODE = "appDatascheda11Intest";

	// ApplicationData: [idIspezioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDISPEZIONESELEZIONATO_CODE = "appDataidIspezioneSelezionato";

	// ApplicationData: [ElencoIspezioni2018, scope:USER_SESSION]
	public static final String APPDATA_ELENCOISPEZIONI2018_CODE = "appDataElencoIspezioni2018";

	// ApplicationData: [Ispezione2018, scope:USER_SESSION]
	public static final String APPDATA_ISPEZIONE2018_CODE = "appDataIspezione2018";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestLibScheda13";

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
	 * ContentPanel cpGestLibScheda13
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda13.CpGestLibScheda13Model theModel

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
			/*PROTECTED REGION ID(R1604034808) ENABLED START*/
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
	 * Implementazione del metodo preparaAperturaDettaglioIspezione definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda13
	 */
	public ExecResults preparaAperturaDettaglioIspezione(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda13.CpGestLibScheda13Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAAPERTURADETTAGLIOISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAAPERTURADETTAGLIOISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1350158233) ENABLED START*/

			try {

				getValidationMgr().checkSelezioneElemento(theModel.getAppDataidIspezioneSelezionato());

				Ispezione2018 ispezioneEsistente = new Ispezione2018();
				ispezioneEsistente.setIdentificativoIspezione(
						ConvertUtil.convertToString(theModel.getAppDataidIspezioneSelezionato()));

				theModel.setAppDataIspezione2018(ispezioneEsistente);

				//				theModel.setAppDataProvenienzaDettaglioIspezione2018("RICERCA");
				theModel.setAppDatapaginaChiamante(Constants.PAG_SCHEDA_13);

				result.setResultCode(PREPARAAPERTURADETTAGLIOISPEZIONE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::preparaAperturaDettaglioIspezione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo downloadRapProva definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda13
	 */
	public ExecResults downloadRapProva(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda13.CpGestLibScheda13Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DOWNLOADRAPPROVA_OUTCOME_CODE__DOWNLOAD_RAP_PROVA = //NOSONAR  Reason:EIAS
				"DOWNLOAD_RAP_PROVA"; //NOSONAR  Reason:EIAS
		final String DOWNLOADRAPPROVA_OUTCOME_CODE__DOWNLOAD_RAP_PROVA_FIRMATO = //NOSONAR  Reason:EIAS
				"DOWNLOAD_RAP_PROVA_FIRMATO"; //NOSONAR  Reason:EIAS
		final String DOWNLOADRAPPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1071048886) ENABLED START*/
			try {
				SigitTAllegatoRappProvaByIdAllegatoDto allegato = getDbMgr()
						.cercaRappProvaByIdAllegato(ConvertUtil.convertToInteger(theModel.getIdRiga()));

				theModel.getSession().put(Constants.SESSIONE_VAR_ID_ALLEGATO,
						ConvertUtil.convertToString(allegato.getAlleIdAllegato()));
				theModel.getSession().put(Constants.SESSIONE_VAR_ID_IMPIANTO,
						ConvertUtil.convertToString(allegato.getIspCodiceImpianto()));

				if (GenericUtil.isNullOrEmpty(allegato.getAlleUidIndexFirmato())) {
					result.setResultCode(DOWNLOADRAPPROVA_OUTCOME_CODE__DOWNLOAD_RAP_PROVA);
				} else {
					result.setResultCode(DOWNLOADRAPPROVA_OUTCOME_CODE__DOWNLOAD_RAP_PROVA_FIRMATO);
				}

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::downloadRapProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda13
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda13.CpGestLibScheda13Model theModel

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
			/*PROTECTED REGION ID(R418759447) ENABLED START*/
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
	 * ContentPanel cpGestLibScheda13
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda13.CpGestLibScheda13Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-279708947) ENABLED START*/
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
	 * Implementazione del metodo caricaScheda definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda13
	 */
	public ExecResults caricaScheda(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda13.CpGestLibScheda13Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICASCHEDA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1990988408) ENABLED START*/

			//viene eseguita la ricerca per codice impianto
			try {

				//				RicercaIspezioni2018 ricercaIspezioni2018 = new RicercaIspezioni2018();
				//				ricercaIspezioni2018.setCodiceImpianto(theModel.getAppDataidImpiantoSelez());
				//				ricercaIspezioni2018.setIdStatoIspezione(Constants.ID_STATO_ISPEZIONE_CONSOLIDATO);

				List<Ispezione2018> listaRisultati = getSigitMgr().findIspezioniConsByCodImpianto(
						ConvertUtil.convertToInteger(theModel.getAppDataidImpiantoSelez()));

				/*
				List<SigitVRicercaIspezioniDto> listIspezioni = getDbMgr().getSigitVRicercaIspezioniDao().findConsByCodiceImpianto(ConvertUtil.convertToInteger(theModel.getAppDataidImpiantoSelez()));
				List<Ispezione2018> listaRisultati = new ArrayList<Ispezione2018>();
				
				List<String> rapportiDesc = new ArrayList<String>();
				List<Long> rapportiId = new ArrayList<Long>();
				
				
				for (SigitVRicercaIspezioniDto sigitVRicercaIspezioniDto : listIspezioni) {
					Ispezione2018 ispezione2018 = new Ispezione2018();
					ispezione2018.setIdentificativoIspezione(ConvertUtil.convertToString(sigitVRicercaIspezioniDto.getIdIspezione2018()));
					
					ispezione2018.setDataCreazione(ConvertUtil.convertToString(sigitVRicercaIspezioniDto.getDtCreazione()));
					ispezione2018.setEnteCompetente(sigitVRicercaIspezioniDto.getEnteCompetente());
					ispezione2018.setNote(sigitVRicercaIspezioniDto.getNote());
					Boolean esitoBoolean = ConvertUtil.convertToBoolean(sigitVRicercaIspezioniDto.getFlgEsito());
					ispezione2018.setEsito(esitoBoolean == null ? "" : esitoBoolean ? PositivoNegativoEnum.POSITIVO.getDescrizione() : PositivoNegativoEnum.NEGATIVO.getDescrizione());
				
					rapportiDesc.add(etichettaCorrente);
					rapportiId.add(ConvertUtil.convertToLong(rappProva.getAlleIdAllegato()));
					
					ispezione2018.setd
					
					String denominazioneIspettore = ConvertUtil.getStringByConcat(" ", sigitVRicercaIspezioniDto.getCognomeIspettore(), sigitVRicercaIspezioniDto.getNomeIspettore(), risultatoRicerca.getCfIspettore());
					ispezione2018.setDescrizioneIspettore(denominazioneIspettore);
					ispezione2018.setCfSecondoIspettore(risultatoRicerca.getCfIspettoreSecondario());
					
					
					
					if (mappaStatoIspezione != null) {
						if (risultatoRicerca.getStatoIspezione() != null && risultatoRicerca.getStatoIspezione().intValue() != 0) {
							ispezione2018.setDescrizioneStato(mappaStatoIspezione.get(ConvertUtil.convertToInteger(risultatoRicerca.getStatoIspezione())));
						}
					}
					
					if (risultatoRicerca.getCodiceImpianto() != null && risultatoRicerca.getCodiceImpianto().intValue() != 0) {
						ispezione2018.setCodiceImpianto(ConvertUtil.convertToString(risultatoRicerca.getCodiceImpianto()));
					} else {
						ispezione2018.setCodiceImpianto(null);
					}
					
					
					
				}
				*/

				/*
				List<Ispezione2018> listaRisultati = getSigitMgr().findIspezioniByFilter(ricercaIspezioni2018, null);
				
				//per ogni ispezione viene caricata la lista dei rapporti di prova in modo da poterli riepilogare in tabella
				if (listaRisultati != null) {
					for (Ispezione2018 ispezione : listaRisultati) {
						List<SigitTAllegatoRappProvaByIdIspezioneDto> rappProvaIspez = getDbMgr()
								.cercaElencoRapProvaPerIspezione(
										ConvertUtil.convertToInteger(ispezione.getIdentificativoIspezione()));
						List<String> rapportiDesc = new ArrayList<String>();
						List<Long> rapportiId = new ArrayList<Long>();
						if (rappProvaIspez != null && !rappProvaIspez.isEmpty()) {
							for (SigitTAllegatoRappProvaByIdIspezioneDto rappProva : rappProvaIspez) {
								String etichettaCorrente = ConvertUtil.getStringByConcat(":",
										ConvertUtil.convertToString(rappProva.getAlleDataControllo()),
										rappProva.getAlleElencoApparecchiature());
								rapportiDesc.add(etichettaCorrente);
								rapportiId.add(ConvertUtil.convertToLong(rappProva.getAlleIdAllegato()));
							}
				
						}
						ispezione.setRapportiDesc((ArrayList<String>) rapportiDesc);
						ispezione.setRapportiId((ArrayList<Long>) rapportiId);
					}
				}
				*/
				theModel.setAppDataElencoIspezioni2018((ArrayList<Ispezione2018>) listaRisultati);
				result.setResultCode(CARICASCHEDA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaScheda] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciMsg definito in un ExecCommand del
	 * ContentPanel cpGestLibScheda13
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda13.CpGestLibScheda13Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1540360465) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

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
	 * permette di resettare lo stato di paginazione della tabella widg_tbRisultatiRicerca
	 */
	public static void resetClearStatus_widg_tbRisultatiRicerca(java.util.Map session) {
		session.put("cpGestLibScheda13_tbRisultatiRicerca_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-2030288472) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
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

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	public static boolean isUtenteAbilitatoOperazioneDettaglio(
			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda13.CpGestLibScheda13Model theModel) {

		UtenteLoggato utente = theModel.getAppDatautenteLoggato();

		return GenericUtil.checkValidRole(utente, Arrays.asList(Constants.RUOLO_VALIDATORE, Constants.RUOLO_SUPER,
				Constants.RUOLO_ISPETTORE, Constants.RUOLO_CONSULTATORE), false, true);

	}

	/*PROTECTED REGION END*/
}
