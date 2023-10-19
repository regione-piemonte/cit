
package it.csi.sigit.sigitwebn.business;

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
import it.csi.sigit.sigitwebn.dto.*;
import org.apache.log4j.*;
import it.csi.sigit.sigitwebn.util.*;
/*PROTECTED REGION ID(R-952919469) ENABLED START*/
import it.csi.sigit.sigitwebn.dto.accesso.AbilitazioniRuoloFunz;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
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

	protected it.csi.sigit.sigitwebn.dto.common.UserInfo getCurrentUserInfo(Map session) throws BEException {
		it.csi.sigit.sigitwebn.dto.common.UserInfo userInfo = (it.csi.sigit.sigitwebn.dto.common.UserInfo) session
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
			it.csi.sigit.sigitwebn.dto.common.UserInfo currentUserInfo = getCurrentUserInfo(session);
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

	public boolean customCheckIsRisRicImpInsVerificaAbilitato(Map session) throws BEException {
		/*PROTECTED REGION ID(R1373371251) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {

			UtenteLoggato utenteLoggato = ((UtenteLoggato) session.get("appDatautenteLoggato"));
			String descrizioneRuolo = utenteLoggato.getRuolo().getDescRuolo();

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckIsRisRicImpInsVerificaAbilitato] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsRisRicImpInsVerificaAbilitato",
					ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsLibrettoWebAbilitato4(Map session) throws BEException {
		/*PROTECTED REGION ID(R1123423747) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			return Constants.LIBRETTO_WEB_ABILITATO;
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsLibrettoWebAbilitato4] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsLibrettoWebAbilitato4", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsLibrettoWebAbilitato1(Map session) throws BEException {
		/*PROTECTED REGION ID(R1123423744) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			return Constants.LIBRETTO_WEB_ABILITATO;
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsLibrettoWebAbilitato1] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsLibrettoWebAbilitato1", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsLibrettoWebAbilitato2(Map session) throws BEException {
		/*PROTECTED REGION ID(R1123423745) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			return Constants.LIBRETTO_WEB_ABILITATO;
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsLibrettoWebAbilitato2] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsLibrettoWebAbilitato2", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsAbilitatoDocRee(Map session) throws BEException {
		/*PROTECTED REGION ID(R-2101518362) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {

			UtenteLoggato utenteLoggato = ((UtenteLoggato) session.get("appDatautenteLoggato"));

			return GenericUtil.isRuoloAbilitatoAccessoDocumentazioneReeWEB(utenteLoggato);

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoDocRee] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoDocRee", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsAbilitatoInsVerificaReeImp(Map session) throws BEException {
		/*PROTECTED REGION ID(R1714218915) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {

			UtenteLoggato utenteLoggato = ((UtenteLoggato) session.get("appDatautenteLoggato"));
			String descrizioneRuolo = utenteLoggato.getRuolo().getDescRuolo();

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckIsAbilitatoInsVerificaReeImp] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoInsVerificaReeImp", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsAbilitatoDocReeImp(Map session) throws BEException {
		/*PROTECTED REGION ID(R1404825094) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {

			UtenteLoggato utenteLoggato = ((UtenteLoggato) session.get("appDatautenteLoggato"));
			String descrizioneRuolo = utenteLoggato.getRuolo().getDescRuolo();

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_IMPRESA)
					|| descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_CONSULTATORE)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoDocReeImp] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoDocReeImp", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsAbilitatoReeFirmato(Map session) throws BEException {
		/*PROTECTED REGION ID(R296485976) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			UtenteLoggato utenteLoggato = ((UtenteLoggato) session.get("appDatautenteLoggato"));
			String descrizioneRuolo = utenteLoggato.getRuolo().getDescRuolo();

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_IMPRESA)
					|| descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoReeFirmato] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoReeFirmato", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsRisRicAvzImpInsVerificaAbilitato(Map session) throws BEException {
		/*PROTECTED REGION ID(R2144981328) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			UtenteLoggato utenteLoggato = ((UtenteLoggato) session.get("appDatautenteLoggato"));
			String descrizioneRuolo = utenteLoggato.getRuolo().getDescRuolo();

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckIsRisRicAvzImpInsVerificaAbilitato] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException(
					"Errore durante l'esecuzione del metodo customCheckIsRisRicAvzImpInsVerificaAbilitato", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsLibrettoWebAbilitato3(Map session) throws BEException {
		/*PROTECTED REGION ID(R1123423746) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			return Constants.LIBRETTO_WEB_ABILITATO;
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsLibrettoWebAbilitato3] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsLibrettoWebAbilitato3", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsAbilitatoVisualDoc(Map session) throws BEException {
		/*PROTECTED REGION ID(R-617824596) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			return true;
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoVisualDoc] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoVisualDoc", ex);
		}
		/*PROTECTED REGION END*/
	}
	public boolean customCheckIsAbilitatoElimDoc(Map session) throws BEException {
		/*PROTECTED REGION ID(R85370625) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			return true;
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoElimDoc] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoElimDoc", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoAcquisisci(Map session) throws BEException {
		/*PROTECTED REGION ID(R1159865900) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			return false; //(customCheckIsAbilitatoCodiciImpianto(session) || customCheckIsAbilitatoAcquistaBollini(session));
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoAcquisisci] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoAcquisisci", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoCodiciImpianto(Map session) throws BEException {
		/*PROTECTED REGION ID(R-375778840) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			AbilitazioniRuoloFunz abilitazioniRuoloFunz = ((UtenteLoggato) session.get("appDatautenteLoggato"))
					.getAbilitazioniRuoloFunz();

			if (abilitazioniRuoloFunz.getFlgAcqCodImp()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoCodiciImpianto] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoCodiciImpianto", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoAcquistaBollini(Map session) throws BEException {
		/*PROTECTED REGION ID(R321551726) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			AbilitazioniRuoloFunz abilitazioniRuoloFunz = ((UtenteLoggato) session.get("appDatautenteLoggato"))
					.getAbilitazioniRuoloFunz();

			if (abilitazioniRuoloFunz.getFlgAcqBollino()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoAcquistaBollini] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoAcquistaBollini", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoAbilitazioni(Map session) throws BEException {
		/*PROTECTED REGION ID(R1061036469) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			return (customCheckIsAbilitatoSubentro(session) || customCheckIsAbilitatoDelega(session)
					|| customCheckIsAbilitatoIncaricoCat(session) || customCheckIsAbilitato3Responsabile(session));
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoAbilitazioni] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoAbilitazioni", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoSubentro(Map session) throws BEException {
		/*PROTECTED REGION ID(R467093204) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			return GenericUtil.isRuoloAbilitatoAccessoSubentro(((UtenteLoggato) session.get("appDatautenteLoggato")));

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoSubentro] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoSubentro", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoDelega(Map session) throws BEException {
		/*PROTECTED REGION ID(R-2110467136) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			return GenericUtil.isRuoloAbilitatoAccessoDelega(((UtenteLoggato) session.get("appDatautenteLoggato")));

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoDelega] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoDelega", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoIncaricoCat(Map session) throws BEException {
		/*PROTECTED REGION ID(R382420516) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			return GenericUtil.isRuoloAbilitatoAccessoIncaricoCat((UtenteLoggato) session.get("appDatautenteLoggato"));

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoIncaricoCat] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoIncaricoCat", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitato3Responsabile(Map session) throws BEException {
		/*PROTECTED REGION ID(R645019780) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			return GenericUtil
					.isRuoloAbilitatoAccessoNomina3Responsabile(((UtenteLoggato) session.get("appDatautenteLoggato")));

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitato3Responsabile] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitato3Responsabile", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoGestione(Map session) throws BEException {
		/*PROTECTED REGION ID(R213443144) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			return (customCheckIsAbilitatoImpianto(session) || customCheckIsAbilitatoAllegati(session)
					|| customCheckIsAbilitatoImportMassivo(session));
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoGestione] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoGestione", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoImpianto(Map session) throws BEException {
		/*PROTECTED REGION ID(R2112873393) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			return GenericUtil.isRuoloAbilitatoAccessoImpianti(((UtenteLoggato) session.get("appDatautenteLoggato")));

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoImpianto] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoImpianto", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoAllegati(Map session) throws BEException {
		/*PROTECTED REGION ID(R49744479) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			return GenericUtil
					.isRuoloAbilitatoAccessoRicercaAllegati(((UtenteLoggato) session.get("appDatautenteLoggato")));

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoAllegati] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoAllegati", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoImportMassivo(Map session) throws BEException {
		/*PROTECTED REGION ID(R1252943069) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			return GenericUtil.isRuoloAbilitatoAccessoImportMassivoAllegato(
					((UtenteLoggato) session.get("appDatautenteLoggato")));

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoImportMassivo] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoImportMassivo", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoPA(Map session) throws BEException {
		/*PROTECTED REGION ID(R-1704914051) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			return (customCheckIsAbilitatoRicercaAvanzataImpianti(session) || customCheckIsAbilitatoImpresa(session)
					|| customCheckIsAbilitatoExportMassivo(session));
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoPA] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoPA", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoRicercaAvanzataImpianti(Map session) throws BEException {
		/*PROTECTED REGION ID(R-1615957024) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			return GenericUtil.isRuoloAbilitatoAccessoRicercaImpiantiAvanzata(
					((UtenteLoggato) session.get("appDatautenteLoggato")));

		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckIsAbilitatoRicercaAvanzataImpianti] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException(
					"Errore durante l'esecuzione del metodo customCheckIsAbilitatoRicercaAvanzataImpianti", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoImpresa(Map session) throws BEException {
		/*PROTECTED REGION ID(R-624307359) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			return GenericUtil.isRuoloAbilitatoAccessoDatiImpresa((UtenteLoggato) session.get("appDatautenteLoggato"));

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoImpresa] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoImpresa", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoExportMassivo(Map session) throws BEException {
		/*PROTECTED REGION ID(R-448502290) ENABLED START*//// inserire qui il codice del controllo custom
		try {
			AbilitazioniRuoloFunz abilitazioniRuoloFunz = ((UtenteLoggato) session.get("appDatautenteLoggato"))
					.getAbilitazioniRuoloFunz();
			if (abilitazioniRuoloFunz.getFlgExpXmlModol()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoExportMassivo] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoExportMassivo", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoBackOffice(Map session) throws BEException {
		/*PROTECTED REGION ID(R612188207) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			UtenteLoggato utenteLoggato = ((UtenteLoggato) session.get("appDatautenteLoggato"));
			return GenericUtil.isRuoloAbilitatoAccessoBackOffice(utenteLoggato);
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoBackOffice] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoBackOffice", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoRicercaVerifiche(Map session) throws BEException {
		/*PROTECTED REGION ID(R1765804332) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			//DCOSTA: DA RIPRISTINARE
			UtenteLoggato utenteLoggato = ((UtenteLoggato) session.get("appDatautenteLoggato"));
			if (GenericUtil.isUtenteAbilitatoRicercaVerificheAccertamentiIspezioniSanzioni(utenteLoggato)) {
				return true;
			} else {
				return false;
			}
			//			return false;
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoRicercaVerifiche] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoRicercaVerifiche", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoRicercaAccertamenti(Map session) throws BEException {
		/*PROTECTED REGION ID(R-947840485) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			UtenteLoggato utenteLoggato = ((UtenteLoggato) session.get("appDatautenteLoggato"));
			if (GenericUtil.isUtenteAbilitatoRicercaVerificheAccertamentiIspezioniSanzioni(utenteLoggato)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			LOG.error(
					"[SecurityHelper::customCheckIsAbilitatoRicercaAccertamenti] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoRicercaAccertamenti",
					ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoRicercaIspezioni(Map session) throws BEException {
		/*PROTECTED REGION ID(R546374961) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			UtenteLoggato utenteLoggato = ((UtenteLoggato) session.get("appDatautenteLoggato"));
			if (GenericUtil.isUtenteAbilitatoRicercaVerificheAccertamentiIspezioniSanzioni(utenteLoggato)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoRicercaIspezioni] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoRicercaIspezioni", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoRicercaSanzioni(Map session) throws BEException {
		/*PROTECTED REGION ID(R2125033670) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			UtenteLoggato utenteLoggato = ((UtenteLoggato) session.get("appDatautenteLoggato"));
			if (GenericUtil.isUtenteAbilitatoRicercaVerificheAccertamentiIspezioniSanzioni(utenteLoggato)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoRicercaSanzioni] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoRicercaSanzioni", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoRicercaSveglie(Map session) throws BEException {
		/*PROTECTED REGION ID(R1907812600) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			UtenteLoggato utenteLoggato = ((UtenteLoggato) session.get("appDatautenteLoggato"));

			return GenericUtil.isRuoloAbilitatoAccessoRicercaSveglie(utenteLoggato);

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoRicercaSveglie] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoRicercaSveglie", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoDistributore(Map session) throws BEException {
		/*PROTECTED REGION ID(R-133217270) ENABLED START*//// inserire qui il codice del controllo custom
		try {

			return GenericUtil
					.isRuoloAbilitatoAccessoDatiDistributore(((UtenteLoggato) session.get("appDatautenteLoggato")));

		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoDistributore] Errore durante l'esecuzione del metodo",
					ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoDistributore", ex);
		}
		/*PROTECTED REGION END*/
	}

	public boolean customCheckIsAbilitatoToken(Map session) throws BEException {
		/*PROTECTED REGION ID(R1193919693) ENABLED START*/ /// inserire qui il codice del controllo custom
		try {
			UtenteLoggato utenteLoggato = ((UtenteLoggato) session.get("appDatautenteLoggato"));
			return GenericUtil.isRuoloAbilitatoAccessoGeneraToken(utenteLoggato);
		} catch (Exception ex) {
			LOG.error("[SecurityHelper::customCheckIsAbilitatoToken] Errore durante l'esecuzione del metodo", ex);
			throw new BEException("Errore durante l'esecuzione del metodo customCheckIsAbilitatoToken", ex);
		}
		/*PROTECTED REGION END*/
	}

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
