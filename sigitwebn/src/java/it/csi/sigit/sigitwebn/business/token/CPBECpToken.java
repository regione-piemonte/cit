package it.csi.sigit.sigitwebn.business.token;

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

/*PROTECTED REGION ID(R1740573119) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.dto.ExecResults;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica;
import it.csi.sigit.sigitwebn.dto.accesso.Ruolo;
import it.csi.sigit.sigitwebn.dto.token.CpTokenModel;
import it.csi.sigit.sigitwebn.dto.userws.UserWs;
import it.csi.sigit.sigitwebn.util.enumutil.JWTUserEnum;
import org.apache.commons.io.FileUtils;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTUserWsDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTUserWsPk;
import java.io.File;
import java.io.IOException;
/*PROTECTED REGION END*/

public class CPBECpToken {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [impresa, scope:USER_SESSION]
	public static final String APPDATA_IMPRESA_CODE = "appDataimpresa";

	// ApplicationData: [elencoUserWs, scope:SAME_PAGE]
	public static final String APPDATA_ELENCOUSERWS_CODE = "appDataelencoUserWs";

	// ApplicationData: [userWs, scope:SAME_PAGE]
	public static final String APPDATA_USERWS_CODE = "appDatauserWs";

	// ApplicationData: [idUserWsSelected, scope:SAME_PAGE]
	public static final String APPDATA_IDUSERWSSELECTED_CODE = "appDataidUserWsSelected";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpToken";

	public static final String MULTIPANEL_MPFRUITORI = "mpFruitori";
	public static final String MPI_MPFRUITORI_FPGENERATOKENFRUITORI = CPNAME + "_" + MULTIPANEL_MPFRUITORI + "_"
			+ "fpGeneraTokenFruitori";

	public static final String MULTIPANEL_MPIMPRESA = "mpImpresa";
	public static final String MPI_MPIMPRESA_FPGENERATOKEN = CPNAME + "_" + MULTIPANEL_MPIMPRESA + "_"
			+ "fpGeneraToken";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadUserWsToken definito in un ExecCommand del
	 * ContentPanel cpToken
	 */
	public ExecResults loadUserWsToken(

			it.csi.sigit.sigitwebn.dto.token.CpTokenModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADUSERWSTOKEN_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1901957488) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// impostazione del result code
			List<UserWs> elencoUserWs = theModel.getAppDataelencoUserWs();
			Integer idUserWsSelected = theModel.getAppDataidUserWsSelected();
			UserWs userWs = elencoUserWs.stream().filter(user -> user.getIdUserWs().equals(idUserWsSelected)).findAny()
					.orElse(null);
			theModel.setAppDatauserWs(userWs);
			result.setResultCode(LOADUSERWSTOKEN_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadUserWsToken] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo generaTokenFruitore definito in un ExecCommand del
	 * ContentPanel cpToken
	 */
	public ExecResults generaTokenFruitore(

			it.csi.sigit.sigitwebn.dto.token.CpTokenModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GENERATOKENFRUITORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GENERATOKENFRUITORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R886402201) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			UserWs userWs = theModel.getAppDatauserWs();
			try {
				getValidationMgr().verificaDataScadenzaToken(theModel.getAppDatauserWs());

				JWTDto jwtDto = creaTokenFruitore(theModel);
				if (jwtDto != null && jwtDto.getToken() != null) {
					SigitTUserWsDto userWsDto = getDbMgr().getSigitTUserWsDao()
							.findByPrimaryKey(new SigitTUserWsPk(userWs.getIdUserWs()));
					userWsDto.setToken(jwtDto.getToken());
					userWsDto.setDtCreazioneToken(ConvertUtil.convertToSqlDate(jwtDto.getDtCreazioneToken()));
					userWsDto.setDtScadenzaToken(ConvertUtil.convertToSqlDate(jwtDto.getDtScadenzaToken()));
					getDbMgr().aggiornaUserWs(userWsDto);
					theModel.setAppDatauserWs(MapDto.mapToUserWsFromDto(userWsDto));
					result.setResultCode(GENERATOKENFRUITORE_OUTCOME_CODE__OK);
				} else {
					result.setResultCode(GENERATOKENFRUITORE_OUTCOME_CODE__KO);
				}
				// impostazione del result code
				// modifica degli attributi del model (che verranno propagati allo strato
				// di presentation). si puo' agire anche direttamente sull'attributo "session".

				result.setModel(theModel);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::generaTokenFruitore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo generaTokenImpresa definito in un ExecCommand del
	 * ContentPanel cpToken
	 */
	public ExecResults generaTokenImpresa(

			it.csi.sigit.sigitwebn.dto.token.CpTokenModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GENERATOKENIMPRESA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GENERATOKENIMPRESA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R958053028) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			PersonaGiuridica personaGiuridica = theModel.getAppDataimpresa();
			JWTDto jwtDto = creaTokenImpresa(theModel);
			if (jwtDto != null && jwtDto.getToken() != null) {
				SigitTPersonaGiuridicaDto pgDto = getDbMgr()
						.cercaTPersonaGiuridicaById(personaGiuridica.getIdPersonaGiuridica());
				pgDto.setDtCreazioneToken(ConvertUtil.convertToSqlDate(jwtDto.getDtCreazioneToken()));
				pgDto.setDtScadenzaToken(ConvertUtil.convertToSqlDate(jwtDto.getDtScadenzaToken()));
				pgDto.setToken(jwtDto.getToken());
				getDbMgr().aggiornaPersonaGiuridicaDto(pgDto, theModel.getAppDatautenteLoggato().getCodiceFiscale());
				theModel.setAppDataimpresa(MapDto.mapToPersonaGiuridica(pgDto));
				result.setResultCode(GENERATOKENIMPRESA_OUTCOME_CODE__OK);
			} else {
				result.setResultCode(GENERATOKENIMPRESA_OUTCOME_CODE__KO);
			}
			// impostazione del result code
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::generaTokenImpresa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpToken
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.token.CpTokenModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R708810132) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoGeneraToken(utenteLoggato)) {
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
	 * Implementazione del metodo gestLogicaInit definito in un ExecCommand del
	 * ContentPanel cpToken
	 */
	public ExecResults gestLogicaInit(

			it.csi.sigit.sigitwebn.dto.token.CpTokenModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAINIT_OUTCOME_CODE__IMPRESA = //NOSONAR  Reason:EIAS
				"IMPRESA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAINIT_OUTCOME_CODE__SUPERUSER = //NOSONAR  Reason:EIAS
				"SUPERUSER"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1813313334) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();

			if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)) {
				result.setResultCode(GESTLOGICAINIT_OUTCOME_CODE__SUPERUSER);
				theModel.setAppDataelencoUserWs(getDbMgr().getAllUserWs());
			} else if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_IMPRESA)) {
				result.setResultCode(GESTLOGICAINIT_OUTCOME_CODE__IMPRESA);
				PersonaGiuridica impresa = getDbMgr().cercaPersonaGiuridicaById(ruolo.getIdPersonaGiuridica());
				theModel.setAppDataimpresa(impresa);
			} else {
				throw new ValidationManagerException(new Message("Utente non abilitato alla generazione del TOKEN"));
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaInit] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-968754417) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao,
	//// proxy di pd, ...)

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

	private JWTDto creaTokenImpresa(CpTokenModel theModel) {
		PersonaGiuridica pg = theModel.getAppDataimpresa();
		JWTDto jwtDto = new JWTDto(JWTUserEnum.IMPRESA);
		jwtDto.setIdPg(ConvertUtil.convertToString(pg.getIdPersonaGiuridica()));
		jwtDto.setSubject(pg.getCodiceRea());
		JWTUtil.createToken(jwtDto);
		//		File file = createTxtToken(jwtDto.getToken());
		//		theModel.getSession().put(Constants.SESSIONE_VAR_TOKEN, file);
		return jwtDto;
	}

	private JWTDto creaTokenFruitore(CpTokenModel theModel) throws Exception {
		UserWs uw = theModel.getAppDatauserWs();
		Date dtScadenzaToken = ConvertUtil.convertToDate(theModel.getAppDatauserWs().getDtScadenzaToken());

		JWTDto jwtDto = new JWTDto(JWTUserEnum.FRUITORE);
		jwtDto.setCodApplFruitore(uw.getUserWs());
		jwtDto.setDtScadenzaToken(dtScadenzaToken);
		JWTUtil.createToken(jwtDto);
		//		File file = createTxtToken(jwtDto.getToken());
		//		theModel.getSession().put(Constants.SESSIONE_VAR_TOKEN, file);
		return jwtDto;
	}

	private File createTxtToken(String token) {
		File file = new File("token.txt");
		try {
			if (file.createNewFile()) {
				log.debug("File created: " + file.getName());
				FileUtils.write(file, token);
			} else {
				log.debug("File already exists.");
			}
			return file;
		} catch (IOException e) {
			log.debug("An error occurred.");
			e.printStackTrace();
			return file;
		}
	}
	/*PROTECTED REGION END*/
}
