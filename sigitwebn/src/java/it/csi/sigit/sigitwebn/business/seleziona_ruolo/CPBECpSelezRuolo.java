package it.csi.sigit.sigitwebn.business.seleziona_ruolo;

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

/*PROTECTED REGION ID(R-1712270364) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import org.apache.commons.lang.StringUtils;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaFisicaDto;
/*PROTECTED REGION END*/

public class CPBECpSelezRuolo {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [ruoliTrovati, scope:USER_SESSION]
	public static final String APPDATA_RUOLITROVATI_CODE = "appDataruoliTrovati";

	// ApplicationData: [idRuoloSelez, scope:USER_ACTION]
	public static final String APPDATA_IDRUOLOSELEZ_CODE = "appDataidRuoloSelez";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [filtroRuoloSelez, scope:USER_SESSION]
	public static final String APPDATA_FILTRORUOLOSELEZ_CODE = "appDatafiltroRuoloSelez";

	// ApplicationData: [ruoliFiltro, scope:USER_SESSION]
	public static final String APPDATA_RUOLIFILTRO_CODE = "appDataruoliFiltro";

	// ApplicationData: [ruoliTrovatiFiltrati, scope:USER_SESSION]
	public static final String APPDATA_RUOLITROVATIFILTRATI_CODE = "appDataruoliTrovatiFiltrati";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpSelezRuolo";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo filtraRuoli definito in un ExecCommand del
	 * ContentPanel cpSelezRuolo
	 */
	public ExecResults filtraRuoli(

			it.csi.sigit.sigitwebn.dto.seleziona_ruolo.CpSelezRuoloModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String FILTRARUOLI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String FILTRARUOLI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1531608686) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			ArrayList<Ruolo> ruoliTrovati = theModel.getAppDataruoliTrovati();

			String ruoloDaFiltrare = theModel.getAppDatafiltroRuoloSelez();

			ArrayList<Ruolo> ruoliFiltrati = new ArrayList<Ruolo>();
			try {
				getValidationMgr().checkSelezioneElemento(ruoloDaFiltrare);

				if (StringUtils.equals(ruoloDaFiltrare, Constants.RIMUOVI_FILTRO_RUOLO)) {
					theModel.setAppDataruoliTrovatiFiltrati(ruoliTrovati);
				} else {
					for (Ruolo ruolo : ruoliTrovati) {
						if (StringUtils.equals(ruolo.getDenomDitta(), ruoloDaFiltrare)) {
							ruoliFiltrati.add(ruolo);
						}
					}

					theModel.setAppDataruoliTrovatiFiltrati(ruoliFiltrati);
				}

				// impostazione del result code 
				result.setResultCode(FILTRARUOLI_OUTCOME_CODE__OK);

				// modifica degli attributi del model (che verranno propagati allo strato
				// di presentation). si puo' agire anche direttamente sull'attributo "session".
			} catch (ManagerException ex) {

				log.debug("##################### INTERCETTO L'eccezione");
				Validator.gestisciEccezione(result, ex);

			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::filtraRuoli] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo selezionaRuolo definito in un ExecCommand del
	 * ContentPanel cpSelezRuolo
	 */
	public ExecResults selezionaRuolo(

			it.csi.sigit.sigitwebn.dto.seleziona_ruolo.CpSelezRuoloModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SELEZIONARUOLO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SELEZIONARUOLO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1949457424) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idRuoloSelez = theModel.getAppDataidRuoloSelez();
			boolean isCorrect = true;
			try {
				getValidationMgr().checkSelezioneElemento(idRuoloSelez);

				log.debug("STAMPO L'ID RUOLO SELEZ: " + idRuoloSelez);

				//if (GenericUtil.isNotNullOrEmpty(idRuoloSelez)) {
				ArrayList<Ruolo> ruoli = theModel.getAppDataruoliTrovatiFiltrati();

				for (Ruolo ruolo : ruoli) {

					log.debug("ANALIZZO l'ID: " + ruolo.getIdRuolo());
					log.debug("DESC RUOLO: " + ruolo.getDescRuolo());

					if (ruolo.getIdRuolo().intValue() == ConvertUtil.convertToInteger(idRuoloSelez).intValue()) {

						String descrizioneRuoloLogAccesso = ruolo.getDescRuoloCompleto();

						if (log.isDebugEnabled())
							GenericUtil.stampa(ruolo, true, 2);

						// Per ruoli PA abilitati su provincia o comune devo verificare che la provincia o il comune non siano cessati
						if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_CONSULTATORE)
								|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_ISPETTORE)
								|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
								|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {

							String istatAbilitazione = ruolo.getIstatAbilitazione();

							if (istatAbilitazione.length() > 2) {
								istatAbilitazione = istatAbilitazione.substring(2);
							}

							try {
								if (istatAbilitazione.length() == 3) {
									getServiziMgr().getProvinciaDaCodiceIstatOrSigla(istatAbilitazione);
								} else if (istatAbilitazione.length() == 6) {
									getServiziMgr().getComuneDaCodiceIstat(istatAbilitazione);
								}
							} catch (Exception e) {
								result.getGlobalErrors().add(Messages.ERROR_SELEZIONE_PROVINCIA_COMUNE_CESSATI);
								result.setResultCode(SELEZIONARUOLO_OUTCOME_CODE__KO);
								break;
							}
						}

						// Devo verificare che non sia RADIATO o SOSPESO
						if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_IMPRESA)
								|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_3RESPONSABILE)
								|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_DISTRIBUTORE)
								|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_CAT)) {

							log.debug("ID PG: " + ruolo.getIdPersonaGiuridica());

							PersonaGiuridica personaGiuridica = getDbMgr()
									.cercaPersonaGiuridicaById(ruolo.getIdPersonaGiuridica());

							String codiceRea = MapDto.getCodiceRea(personaGiuridica.getSiglaRea(),
									ConvertUtil.convertToInteger(personaGiuridica.getNumeroRea()));

							descrizioneRuoloLogAccesso += " REA " + codiceRea;

							if (personaGiuridica.getIdStatoPg() == null
									|| personaGiuridica.getIdStatoPg().intValue() == Constants.ID_STATO_IMPRESA_SOSPESA
									|| personaGiuridica.getIdStatoPg()
											.intValue() == Constants.ID_STATO_IMPRESA_RADIATA) {
								result.getGlobalErrors().add(Messages.S141);
								result.setResultCode(SELEZIONARUOLO_OUTCOME_CODE__KO);
								break;
							}

						}

						//						ruolo.setIsCat(ruolo.getDescRuolo().startsWith(
						//								Constants.CAT_RUOLO_PREFISSO));
						//
						//						ruolo.setDescRuoloCompleto(ruolo.getDescRuolo());

						// Devo verificare se e' un CAT
						if (ConvertUtil.convertToBooleanAllways(ruolo.getIsCat())) {
							// E' un CAT
							// tolgo dalla descrizione la parola cat (altrimenti c'e' un proliferrasi di ruoli che complicherebbe il codice)
							ruolo.setDescRuolo(ruolo.getDescRuolo().replace(Constants.CAT_RUOLO_PREFISSO, ""));

						}

						// Setto il ruolo selezionato all'utente loggato
						theModel.getAppDatautenteLoggato().setRuolo(ruolo);

						// recupero le abilitazioni per il ruolo selezionato
						AbilitazioniRuoloFunz abilRuoloFunz = getDbMgr()
								.cercaAbilitazioniRuoloFunzByDescRuolo(ruolo.getDescRuolo());
						theModel.getAppDatautenteLoggato().setAbilitazioniRuoloFunz(abilRuoloFunz);

						Integer idPersonaFisica = ConvertUtil
								.convertToInteger(theModel.getAppDatautenteLoggato().getIdPersonaFisica());

						SigitTPersonaFisicaDto personaFisicaDto = getDbMgr().cercaTPersonaFisicaById(idPersonaFisica);

						//salvataggio dell'accesso dell'utente
						getDbMgr().inserisciLogAccesso(personaFisicaDto, descrizioneRuoloLogAccesso);

						// impostazione del result code 
						result.setResultCode(SELEZIONARUOLO_OUTCOME_CODE__OK);

						break;
					}
				}

				//			} else {
				//				result.getGlobalErrors().add(Messages.S007);
				//
				//				// impostazione del result code 
				//				result.setResultCode(SELEZIONARUOLO_OUTCOME_CODE__KO);
				//			}
			} catch (ManagerException ex) {

				log.debug("##################### INTERCETTO L'eccezione");
				Validator.gestisciEccezione(result, ex);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::selezionaRuolo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbElencoRuoli
	 */
	public static void resetClearStatus_widg_tbElencoRuoli(java.util.Map session) {
		session.put("cpSelezRuolo_tbElencoRuoli_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1561776976) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)

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

	private ServiziMgr serviziMgr;

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	/*PROTECTED REGION END*/
}
