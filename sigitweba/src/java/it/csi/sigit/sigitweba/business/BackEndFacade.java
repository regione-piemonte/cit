package it.csi.sigit.sigitweba.business;

import java.util.*;

import it.csi.sigit.sigitweba.dto.*;

import org.apache.log4j.*;
import it.csi.sigit.sigitweba.util.*;

/*PROTECTED REGION ID(R-1534196706) ENABLED START*/
import it.csi.sigit.sigitweba.business.manager.DbMgr;
import it.csi.sigit.sigitweba.business.manager.util.DbManagerException;
import it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaFisica;
import it.csi.sigit.sigitweba.dto.common.UserInfo;
import it.csi.sigit.sigitweba.util.Messages;
/*PROTECTED REGION END*/

public class BackEndFacade {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [authVerify, scope:USER_SESSION]
	public static final String APPDATA_AUTHVERIFY_CODE = "appDataauthVerify";

	// ApplicationData: [personaFisica, scope:USER_SESSION]
	public static final String APPDATA_PERSONAFISICA_CODE = "appDatapersonaFisica";

	// ApplicationData: [province, scope:USER_SESSION]
	public static final String APPDATA_PROVINCE_CODE = "appDataprovince";

	// ApplicationData: [comuni, scope:USER_SESSION]
	public static final String APPDATA_COMUNI_CODE = "appDatacomuni";

	// ApplicationData: [messaggioErrore, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIOERRORE_CODE = "appDatamessaggioErrore";

	// ApplicationData: [elencoIndirizziPF, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINDIRIZZIPF_CODE = "appDataelencoIndirizziPF";

	// ApplicationData: [listFormazioni, scope:USER_SESSION]
	public static final String APPDATA_LISTFORMAZIONI_CODE = "appDatalistFormazioni";

	// ApplicationData: [Formazione, scope:USER_SESSION]
	public static final String APPDATA_FORMAZIONE_CODE = "appDataFormazione";

	// ApplicationData: [personaGiuridica, scope:USER_SESSION]
	public static final String APPDATA_PERSONAGIURIDICA_CODE = "appDatapersonaGiuridica";

	// ApplicationData: [elencoImprese, scope:USER_SESSION]
	public static final String APPDATA_ELENCOIMPRESE_CODE = "appDataelencoImprese";

	// ApplicationData: [elencoSigleRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLEREA_CODE = "appDataelencoSigleRea";

	// ApplicationData: [impresaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IMPRESASELEZIONATA_CODE = "appDataimpresaSelezionata";

	// ApplicationData: [elencoIndirizziPG, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINDIRIZZIPG_CODE = "appDataelencoIndirizziPG";

	// ApplicationData: [ruoliImpresa, scope:USER_SESSION]
	public static final String APPDATA_RUOLIIMPRESA_CODE = "appDataruoliImpresa";

	// ApplicationData: [tipiDM, scope:USER_SESSION]
	public static final String APPDATA_TIPIDM_CODE = "appDatatipiDM";

	// ApplicationData: [elencoProvinceIT, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCEIT_CODE = "appDataelencoProvinceIT";

	// ApplicationData: [elencoComuniPG, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIPG_CODE = "appDataelencoComuniPG";

	// ApplicationData: [isPrimoIngresso, scope:USER_SESSION]
	public static final String APPDATA_ISPRIMOINGRESSO_CODE = "appDataisPrimoIngresso";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	/// - i metodi relativi a menu e azioni di inizializzazione sono direttamente 
	///   implementati in questa classe
	/// - i metodi relativi ai singoli content panel sono delegati nei rispettivi
	///   bean
	//////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestTipoIndirizzo utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults gestTipoIndirizzo(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().gestTipoIndirizzo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestIndirizzoConf utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults gestIndirizzoConf(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().gestIndirizzoConf(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo loadComuni utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults loadComuni(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().loadComuni(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaIndirizzo utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults ricercaIndirizzo(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().ricercaIndirizzo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo nuovaRicercaIndirizzo utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults nuovaRicercaIndirizzo(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().nuovaRicercaIndirizzo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaMail utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults verificaMail(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().verificaMail(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo salvaAccreditamento utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults salvaAccreditamento(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().salvaAccreditamento(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo inserisciFormazione utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults inserisciFormazione(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().inserisciFormazione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo salvaFormazione utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults salvaFormazione(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().salvaFormazione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo annullaFormazione utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults annullaFormazione(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().annullaFormazione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo inserisciImpresa utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults inserisciImpresa(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().inserisciImpresa(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo selezionaImpresa utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults selezionaImpresa(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().selezionaImpresa(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestTipoIndirizzoImpresaMod utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults gestTipoIndirizzoImpresaMod(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().gestTipoIndirizzoImpresaMod(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestDataInizioAtt utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults gestDataInizioAtt(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().gestDataInizioAtt(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestDataCessazione utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults gestDataCessazione(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().gestDataCessazione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo apriConfermaCessazioneLegame utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults apriConfermaCessazioneLegame(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().apriConfermaCessazioneLegame(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestTipoIndirizzoImpresa utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults gestTipoIndirizzoImpresa(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().gestTipoIndirizzoImpresa(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestIndirizzoConfImpresa utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults gestIndirizzoConfImpresa(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().gestIndirizzoConfImpresa(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo loadComuniImpresa utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults loadComuniImpresa(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().loadComuniImpresa(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo cercaIndirizzoImpresa utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults cercaIndirizzoImpresa(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().cercaIndirizzoImpresa(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo nuovaRicercaIndImpresa utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults nuovaRicercaIndImpresa(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().nuovaRicercaIndImpresa(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaEmailImpresa utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults verificaEmailImpresa(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().verificaEmailImpresa(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo salvaImpresaAssociata utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults salvaImpresaAssociata(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().salvaImpresaAssociata(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo cessaLegame utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults cessaLegame(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().cessaLegame(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestTipoIndirizzoInit utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults gestTipoIndirizzoInit(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().gestTipoIndirizzoInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciComboGeo utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().gestisciComboGeo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo visualizzaComboIndirizzo utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults visualizzaComboIndirizzo(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().visualizzaComboIndirizzo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo caricaFormazione utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults caricaFormazione(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().caricaFormazione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo caricaImpreseAssociate utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults caricaImpreseAssociate(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().caricaImpreseAssociate(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestVisBottoni utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults gestVisBottoni(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().gestVisBottoni(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo isPrimoAccesso utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults isPrimoAccesso(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().isPrimoAccesso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestTipoIndirizzoRef utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults gestTipoIndirizzoRef(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().gestTipoIndirizzoRef(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciComboGeoRef utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults gestisciComboGeoRef(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().gestisciComboGeoRef(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo visualizzaComboIndirizzoRef utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults visualizzaComboIndirizzoRef(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().visualizzaComboIndirizzoRef(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo caricaImpreseAssociateRef utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults caricaImpreseAssociateRef(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().caricaImpreseAssociateRef(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestVisBottoniRef utilizzato in un ExecCommand
	 * del ContentPanel cpAccreditamento
	 */
	public ExecResults gestVisBottoniRef(

			it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAccreditamento
		return getCPBECpAccreditamento().gestVisBottoniRef(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestioneMessaggio utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults gestioneMessaggio(

			it.csi.sigit.sigitweba.dto.home_module.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().gestioneMessaggio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initApplicativo definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults initApplicativo(

			it.csi.sigit.sigitweba.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITAPPLICATIVO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INITAPPLICATIVO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String INITAPPLICATIVO_OUTCOME_CODE__NON_DISP = //NOSONAR  Reason:EIAS
				"NON_DISP"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-544167614) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UserInfo userInfo = theModel.getAppDatacurrentUser();

			// JIRA SIGIT-418 Un utente ha sul certificato il CF minuscolo, quindi per sicurezza trasformo tutti i CF in maiuscolo!!
			userInfo.setCodFisc(userInfo.getCodFisc().toUpperCase());
			theModel.setAppDatacurrentUser(userInfo);

			try {

				boolean isUtenteAutorizzato = false;

				boolean isAttivo = getDbMgr().cercaConfigValueFlg(Constants.CIT_SIGITWEBA_SERVIZIO_ATTIVO);

				String portale = (String) theModel.getSession().get(
						it.csi.sigit.sigitweba.presentation.multiportalutils.MultiPortalUtil.MDD_PORTAL_SESSIONATTR);

				log.debug("Stampo il PORTALE: " + portale);

				if (isAttivo) {
					// impostazione del result code 
					result.setResultCode(INITAPPLICATIVO_OUTCOME_CODE__OK);
					isUtenteAutorizzato = true;
				} else {

					String utentiAutorizzati = getDbMgr().cercaConfigValueCarattere(Constants.CIT_UTENTI_AUTORIZZATI);

					if (GenericUtil.isNonNullOrEmpty(utentiAutorizzati)) {
						String[] cf = utentiAutorizzati.split(",");
						for (int i = 0; i < cf.length; i++) {
							if (cf[i].equalsIgnoreCase(userInfo.getCodFisc())) {
								isUtenteAutorizzato = true;
								break;
							}
						}
					}

				}

				if (!isUtenteAutorizzato) {
					theModel.setAppDatamessaggioErrore(Messages.WARN_APPLICATIVO_IN_MANUTENZIONE);

					// impostazione del result code 
					result.setResultCode(INITAPPLICATIVO_OUTCOME_CODE__NON_DISP);
				} else {
					PersonaFisica personaF = getDbMgr().cercaPersonaFisicaByCF(userInfo.getCodFisc());

					GenericUtil.stampa(personaF, false, 2);

					if (personaF == null) {
						// Se non ho trovato la persona la inserisco
						personaF = new PersonaFisica();
						personaF.setCognome(userInfo.getCognome());
						personaF.setNome(userInfo.getNome());
						personaF.setDenominazione(userInfo.getCognome() + " " + userInfo.getNome());
						personaF.setCodiceFiscale(userInfo.getCodFisc());

						personaF.setFlgMailNewsletter(true);
						personaF.setFlgGDPR(true);

						personaF.setFlgAccreditato("A");

						getDbMgr().salvaPersonaFisica(personaF, userInfo.getCodFisc());
					} else {
						//controllo nome e cognome e se diversi aggiornare il DB
						if (!personaF.getNome().equals(userInfo.getNome())
								|| !personaF.getCognome().equals(userInfo.getCognome())) {
							personaF.setNome(userInfo.getNome());
							personaF.setCognome(userInfo.getCognome());
							personaF.setFlgAccreditato("A");
							getDbMgr().modificaPersonaFisica(personaF, userInfo.getCodFisc());
						} else if ("D".equals(personaF.getFlgAccreditato())) {
							personaF.setFlgAccreditato("A");
							getDbMgr().modificaPersonaFisica(personaF, userInfo.getCodFisc());
						}
					}

					theModel.setAppDataisPrimoIngresso(true);
					theModel.setAppDatapersonaFisica(personaF);

					// impostazione del result code 
					result.setResultCode(INITAPPLICATIVO_OUTCOME_CODE__OK);
				}
			} catch (DbManagerException ex) {

				//				result.getGlobalErrors().add(ex.getMessage());
				//				throw ex;
				log.error(ex);
				//				System.out.println("STAMPO IL MESSAGGIO DI ERRORE: "
				//						+ ex.getMessage());

				theModel.setAppDatamessaggioErrore(ex.getMessage());

				Validator.gestisciEccezione(result, ex);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initApplicativo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property relative ai bean spring associati agli specifici content panel
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * riferimento al CPBE del content panel cpAccreditamento
	 */
	private it.csi.sigit.sigitweba.business.accreditamento_module.CPBECpAccreditamento cPBECpAccreditamento = null;

	/**
	 * riferimento al CPBE del content panel cpAccreditamento
	 */
	public void setCPBECpAccreditamento(
			it.csi.sigit.sigitweba.business.accreditamento_module.CPBECpAccreditamento bean) {
		this.cPBECpAccreditamento = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpAccreditamento
	 */
	public it.csi.sigit.sigitweba.business.accreditamento_module.CPBECpAccreditamento getCPBECpAccreditamento() {
		return this.cPBECpAccreditamento;
	}

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	private it.csi.sigit.sigitweba.business.home_module.CPBECpHome cPBECpHome = null;

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	public void setCPBECpHome(it.csi.sigit.sigitweba.business.home_module.CPBECpHome bean) {
		this.cPBECpHome = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	public it.csi.sigit.sigitweba.business.home_module.CPBECpHome getCPBECpHome() {
		return this.cPBECpHome;
	}

	/**
	 * riferimento al CPBE del content panel cpDialog
	 */
	private it.csi.sigit.sigitweba.business.home_module.CPBECpDialog cPBECpDialog = null;

	/**
	 * riferimento al CPBE del content panel cpDialog
	 */
	public void setCPBECpDialog(it.csi.sigit.sigitweba.business.home_module.CPBECpDialog bean) {
		this.cPBECpDialog = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDialog
	 */
	public it.csi.sigit.sigitweba.business.home_module.CPBECpDialog getCPBECpDialog() {
		return this.cPBECpDialog;
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1264235389) ENABLED START*/
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
