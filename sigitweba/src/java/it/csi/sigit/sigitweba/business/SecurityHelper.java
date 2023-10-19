
package it.csi.sigit.sigitweba.business;

import java.util.*;
import java.io.*;
import it.csi.csi.porte.InfoPortaDelegata;
import it.csi.csi.porte.proxy.PDProxy;
import it.csi.csi.util.xml.PDConfigReader;
import it.csi.csi.wrapper.SystemException;
import it.csi.csi.wrapper.UnrecoverableException;
import it.csi.iride2.policy.entity.*;
import it.csi.iride2.policy.exceptions.*;
import it.csi.iride2.policy.interfaces.PolicyEnforcerBaseService;
import it.csi.iride2.iridefed.entity.Ruolo;
import it.csi.iride2.iridefed.exceptions.BadRuoloException;
import it.csi.sigit.sigitweba.dto.*;
import org.apache.log4j.*;
import it.csi.sigit.sigitweba.util.*;
/*PROTECTED REGION ID(R-952919469) ENABLED START*/

/*PROTECTED REGION END*/

public class SecurityHelper {

	/**  */
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE + ".security");

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi di supporto alla sicurezza.
	//////////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////////
	//// Metodi per la sicurezza basata su IRIDE2
	///////////////////////////////////////////////////////////////////////////////

	public static final String IRIDE_PEP_RESOURCE = "/META-INF/iride2_pep_defPD_ejb.xml";
	public static final String IRIDE_PEP_WS_RESOURCE = "/META-INF/iride2_pep_defPD_ws.xml";

	it.csi.iride2.policy.interfaces.PolicyEnforcerBaseService iride = null;

	/**
	 * restituisce il percorso effettivo della configurazione della PD
	 * di IRIDE da caricare.
	 * Se la security (e la pep-implementation) e' custom viene restituito sempre il 
	 * valore della costante IRIDE_PEP_RESOURCE.
	 * Se la security non e' custom viene restituito un valore differente a seconda del valore
	 * della property "pdProtocol":
	 * <ul>
	 * <li>EJB: IRIDE_PEP_RESOURCE</li>
	 * <li>WS: IRIDE_PEP_WS_RESOURCE</li>
	 * <li>(altro): IRIDE_PEP_RESOURCE</li>
	 * </ul>  
	 */
	protected String getActualIridePepResource() {
		if ("WS".equals(pdProtocol)) {
			return IRIDE_PEP_WS_RESOURCE;
		} else {
			return IRIDE_PEP_RESOURCE;
		}
	}

	/**
	 * Carica la configurazione della PD del PEP e crea il proxy.
	 * @return il proxy della PD del PEP. 
	 */
	protected PolicyEnforcerBaseService getIridePEP() {
		if (this.iride == null) {
			InputStream is = getClass().getResourceAsStream(getActualIridePepResource());
			if (is != null) {
				try {
					InfoPortaDelegata info = PDConfigReader.read(is);
					this.iride = (PolicyEnforcerBaseService) PDProxy.newInstance(info);
					return this.iride;
				} catch (Exception e) {
					LOG.error(
							"[SecurityHelper::getIridePEP] errore nella parsificazione della configurazione di IRIDE2:"
									+ e,
							e);
					throw new IllegalArgumentException("errore nella parsificazione della configurazione di IRIDE2", e);
				}
			} else
				LOG.error("[SecurityHelper::getIridePEP] configurazione di IRIDE2 non trovata, risorsa:"
						+ getActualIridePepResource());
			throw new IllegalArgumentException(
					"configurazione di IRIDE2 non trovata, risorsa:" + getActualIridePepResource());
		} else
			return this.iride;
	}

	public static final String IRIDE_ID_SESSIONATTR = "iride2_id";

	protected Identita getCurrentUser(Map session) throws BEException {
		Identita id = (Identita) session.get(IRIDE_ID_SESSIONATTR);
		if (id == null) {
			LOG.error(
					"[SecurityHelper::getCurrentUser] Errore nel reperimento del current user dalla sessione: attributo non trovato");
			throw new IllegalStateException(
					"Errore nel reperimento del current user dalla sessione: attributo non trovato");
		} else {
			return id;
		}
	}

	protected it.csi.sigit.sigitweba.dto.common.UserInfo getCurrentUserInfo(Map session) throws BEException {
		it.csi.sigit.sigitweba.dto.common.UserInfo userInfo = (it.csi.sigit.sigitweba.dto.common.UserInfo) session
				.get("appDatacurrentUser");
		if (userInfo == null) {
			LOG.error(
					"[SecurityHelper::getCurrentUser] Errore nel reperimento del current user dalla sessione: attributo non trovato");
			throw new IllegalStateException(
					"Errore nel reperimento del current user dalla sessione: attributo non trovato");
		} else {
			return userInfo;
		}
	}

	public static final Application IRIDE2_APPLICATION = new Application("SIGITWEB");

	public boolean verifyCurrentUserForRole(Map session, String roleCode, String domainCode) throws BEException {
		Identita currentUser = getCurrentUser(session);
		Ruolo rol = new Ruolo();

		rol.setCodiceRuolo(roleCode);
		rol.setCodiceDominio(domainCode);
		try {
			return getIridePEP().isPersonaInRuolo(getCurrentUser(session), rol);
		} catch (InternalException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] Errore interno in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore interno in verifyCurrentUserForRole:" + e, e);
		} catch (IdentitaNonAutenticaException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] identita' non autentica [" + currentUser + "]," + e);
			throw new BEException("verifyCurrentUserForRole: identita' non autentica [" + currentUser + "]," + e, e);
		} catch (BadRuoloException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] ruolo [" + rol + "] non valido" + e);
			throw new BEException("verifyCurrentUserForRole: ruolo [" + rol + "] non valido" + e, e);
		} catch (UnrecoverableException e) {
			LOG.error(
					"[SecurityHelper::verifyCurrentUserForRole] Errore non recuperabile in verifyCurrentUserForUC:" + e,
					e);
			throw new BEException("Errore non recuperabile in verifyCurrentUserForRole:" + e, e);
		} catch (SystemException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] Errore di sistema in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore di sistema in verifyCurrentUserForRole:" + e, e);
		} catch (Exception e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForRole] Errore interno in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore interno in verifyCurrentUserForRole:" + e, e);
		}
	}

	/**
	 * estrae il prefisso dal cod ruolo in formato <idruolo>@<coddominio>
	 * @param codRuolo
	 */
	private String getPrefixFromCodRuolo(String codRuolo) {
		return codRuolo.substring(0, codRuolo.indexOf("@"));
	}

	/**
	 * estrae il codice dominio dal cod ruolo in formato <idruolo>@<coddominio>
	 * @param codRuolo
	 */
	private String getDomainFromCodRuolo(String codRuolo) {
		return codRuolo.substring(codRuolo.indexOf("@") + 1);
	}

	public boolean verifyCurrentUserForUC(Map session, String useCaseCode) throws BEException {
		Identita currentUser = getCurrentUser(session);
		UseCase uc = new UseCase();

		uc.setAppId(IRIDE2_APPLICATION);
		uc.setId(useCaseCode);
		try {
			it.csi.sigit.sigitweba.dto.common.UserInfo currentUserInfo = getCurrentUserInfo(session);
			if (currentUserInfo == null || currentUserInfo.getCodRuolo() == null
					|| currentUserInfo.getCodRuolo().length() == 0) {
				// verifica dell'abilitazione allo UC senza tener conto del ruolo corrente
				return getIridePEP().isPersonaAutorizzataInUseCase(getCurrentUser(session), uc);
			} else {
				// verifica dell'abilitazione allo UC tenendo conto del ruolo corrente
				Ruolo[] ruoliForPersonaInUseCase = getIridePEP().findRuoliForPersonaInUseCase(currentUser, uc);

				String codDominioRuolo = getDomainFromCodRuolo(currentUserInfo.getCodRuolo());
				String codRuoloRuolo = getPrefixFromCodRuolo(currentUserInfo.getCodRuolo());
				boolean authorized = false;
				Ruolo currentRole = new Ruolo(codRuoloRuolo, codDominioRuolo);
				for (Ruolo ruolo : ruoliForPersonaInUseCase) {
					if (ruolo != null && currentRole.getMnemonico().equals(ruolo.getMnemonico())) {
						authorized = true;
						break;
					}
				}
				return authorized;
			}
		} catch (InternalException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForUC] Errore interno in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore interno in verifyCurrentUserForUC:" + e, e);
		} catch (IdentitaNonAutenticaException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForUC] identita' non autentica [" + currentUser + "]," + e);
			throw new BEException("verifyCurrentUserForUC: identita' non autentica [" + currentUser + "]," + e, e);
		} catch (NoSuchUseCaseException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForUC] use case [" + uc + "] non valido" + e);
			throw new BEException("verifyCurrentUserForUC: use case [" + uc + "] non valido" + e, e);
		} catch (NoSuchApplicationException e) {
			LOG.error(
					"[SecurityHelper::verifyCurrentUserForUC] applicazione " + IRIDE2_APPLICATION + " non valida" + e);
			throw new BEException("verifyCurrentUserForUC: applicazione " + IRIDE2_APPLICATION + " non valida" + e, e);
		} catch (UnrecoverableException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForUC] Errore non recuperabile in verifyCurrentUserForUC:" + e,
					e);
			throw new BEException("Errore non recuperabile in verifyCurrentUserForUC:" + e, e);
		} catch (SystemException e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForUC] Errore di sistema in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore di sistema in verifyCurrentUserForUC:" + e, e);
		} catch (Exception e) {
			LOG.error("[SecurityHelper::verifyCurrentUserForUC] Errore interno in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore interno in verifyCurrentUserForUC:" + e, e);
		}
	}

	public boolean verifyCurrentUserForActor(Map session, String actorCode) throws BEException {
		Identita currentUser = getCurrentUser(session);
		Actor act = new Actor();

		act.setAppId(IRIDE2_APPLICATION);
		act.setId(actorCode);
		try {
			Actor[] actors = getIridePEP().findActorsForPersonaInApplication(currentUser, IRIDE2_APPLICATION);
			if (actors != null) {
				for (int i = 0; i < actors.length; i++) {
					Actor actor = actors[i];
					if (actor.equals(act))
						return true;
				}
				return false;
			} else
				return false;
		} catch (InternalException e) {
			LOG.error("[SecurityHelper::verifyCurentUserForActor] Errore interno in verifyCurrentUserForUC:" + e);
			throw new BEException("Errore interno in verifyCurrentUserForUC:" + e, e);
		} catch (IdentitaNonAutenticaException e) {
			LOG.error("[SecurityHelper::verifyCurentUserForActor] identita' non autentica [" + currentUser + "]," + e,
					e);
			throw new BEException("verifyCurrentUserForUC: identita' non autentica [" + currentUser + "]," + e, e);
		} catch (NoSuchApplicationException e) {
			LOG.error(
					"[SecurityHelper::verifyCurentUserForActor] applicazione " + IRIDE2_APPLICATION + " non valida" + e,
					e);
			throw new BEException("verifyCurrentUserForUC: applicazione " + IRIDE2_APPLICATION + " non valida" + e, e);
		} catch (UnrecoverableException e) {
			LOG.error(
					"[SecurityHelper::verifyCurentUserForActor] Errore non recuperabile in verifyCurrentUserForUC:" + e,
					e);
			throw new BEException("Errore non recuperabile in verifyCurrentUserForUC:" + e, e);
		} catch (SystemException e) {
			LOG.error("[SecurityHelper::verifyCurentUserForActor] Errore di sistema in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore di sistema in verifyCurrentUserForUC:" + e, e);
		} catch (Exception e) {
			LOG.error("[SecurityHelper::verifyCurentUserForActor] Errore interno in verifyCurrentUserForUC:" + e, e);
			throw new BEException("Errore interno in verifyCurrentUserForUC:" + e, e);
		}
	}

	///////////////////////////////////////////////////////////////////////////////
	//// Metodi per la sicurezza custom
	///////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// properieta' di configurazione dell'helper
	//////////////////////////////////////////////////////////////////////////////

	private String pdProtocol = "EJB";

	/**
	 * @param prot protocollo di richiamo del PEP. Puo' valere: 
	 * 1) EJB (default)
	 * 2) WS
	 * utilizzato solo se la security non e' custom
	 */
	public void setPDProtocol(String prot) {
		pdProtocol = prot;
	}

	public String getPDProtocol() {
		return pdProtocol;
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1742205394) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
