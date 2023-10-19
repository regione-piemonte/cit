/**
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 */
/**
 *
 */
package it.csi.sigit.sigitext.business.be.manager;

import it.csi.csi.wrapper.CSIException;
import it.csi.csi.wrapper.UnrecoverableException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitVRicercaImpiantiDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CodiceReaAndFiscaleFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.FiltroRicercaPfPg;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.ImportFileSuper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.*;
import it.csi.sigit.sigitext.business.util.*;
import it.csi.sigit.sigitext.business.util.exceptions.ValidationManagerException;
import it.csi.sigit.sigitext.business.util.mail.Allegato;
import it.csi.sigit.sigitext.business.util.mail.ResultInvioMail;
import it.csi.sigit.sigitext.dto.sigitext.*;
import it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException;
import it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.MODIIBDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jboss.resteasy.spi.NotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.util.*;

import static it.csi.sigit.sigitext.dto.sigitext.TipoImportAllegatoEnum.ALLEGATOII;

/**
 * @author 1456
 */
public class SigitextManager implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 2327466097627228908L;
	/**
	 *
	 */

	protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE + ".SigitextManager==>");

	private final String INDEX_MNG_RESOURCE = "/META-INF/defpd_indexmngmt.xml";

	public SigitextManager() {
	}

	private ServiceManager serviceManager;
	private DbServiceImp dbServiceImp;
	private ValidationManager validationManager;

	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public DbServiceImp getDbServiceImp() {
		return dbServiceImp;
	}

	public void setDbServiceImp(DbServiceImp dbServiceImp) {
		this.dbServiceImp = dbServiceImp;
	}

	public ValidationManager getValidationManager() {
		return validationManager;
	}

	public void setValidationManager(ValidationManager validationManager) {
		this.validationManager = validationManager;
	}

	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getFluidoCIT( //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException { //NOSONAR  Reason:EIAS
		logger.debug("[SigitextImpl::getFluidoCIT] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();

		try {
			CodiceDescrizione[] lista = null;
			lista = getServiceManager().getListaFluidoCIT();
			return lista;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getFluidoCIT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getFluidoCIT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getFluidoCIT()", "invocazione servizio [sigitext]::[getFluidoCIT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getFluidoCIT] - END");
		}
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByCodiceJWT( //NOSONAR  Reason:EIAS

			java.lang.Integer codiceImpianto, //NOSONAR  Reason:EIAS

			java.lang.String tokenJWT //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException {
		logger.debug("[SigitextImpl::getImpiantoByCodiceJWT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_CERCA_IMPIANTO_BY_CODICE;

			logger.debug("codice impianto: " + codiceImpianto);
			if (codiceImpianto == null) {
				throw new SigitextException(Messages.ERROR_CODICE_IMPIANTO_NON_VALIDO);
			}

			logger.debug("serviceManager: " + getServiceManager());
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);
			logger.debug("serviceManager: " + utenteJWT);

			Impianto[] listImpianti = null;
			if (utenteJWT != null) {
				if (!getServiceManager().isAbilitatoSuImpianto(codiceImpianto, utenteJWT)) {
					throw new SigitextException(Messages.ERROR_IMPRESA_NON_ABILITATA_SU_IMPIANTO);
				}

				listImpianti = getServiceManager().getImpiantoByCodImpianto(codiceImpianto);
			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}
			getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);
			return listImpianti;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getImpiantoByCodiceJWT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getImpiantoByCodiceJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getImpiantoByCodiceJWT()", "invocazione servizio [sigitext]::[getImpiantoByCodiceJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getImpiantoByCodiceJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantiByFiltroJWT( //NOSONAR  Reason:EIAS

			it.csi.sigit.sigitext.dto.sigitext.ImpiantoFiltro impiantoFiltro, //NOSONAR  Reason:EIAS

			java.lang.String tokenJWT //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { //NOSONAR  Reason:EIAS
		logger.debug("[SigitextImpl::getImpiantiByFiltroJWT] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_GET_IMPIANTI_BY_FILTRO;

			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);

			Impianto[] listImpianti = null;

			if (utenteJWT != null) {
				logger.debug(impiantoFiltro);
				listImpianti = getServiceManager().ricercaImpiantoByFiltro(impiantoFiltro);
				logger.debug("LIST IMPIANTI: " + Arrays.toString(listImpianti));

			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}

			getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);

			return listImpianti;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getImpiantiByFiltroJWT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getImpiantiByFiltroJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getImpiantiByFiltroJWT()", "invocazione servizio [sigitext]::[getImpiantiByFiltroJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getImpiantiByFiltroJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByPODJWT( //NOSONAR  Reason:EIAS
			java.lang.String pod, //NOSONAR  Reason:EIAS
			java.lang.String tokenJWT //NOSONAR  Reason:EIAS
	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS
			, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException, it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException { //NOSONAR  Reason:EIAS
		logger.debug("[SigitextImpl::getImpiantoByPODJWT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_CERCA_IMPIANTO_BY_POD;
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);
			Impianto[] listImpianti = null;
			ArrayList<Impianto> listImpiantiTmp = new ArrayList<Impianto>();

			if (utenteJWT != null) {
				listImpianti = getServiceManager().getImpiantoByPod(pod);

				if (listImpianti != null && listImpianti.length > 0) {
					for (Impianto impianto : listImpianti) {
						if (getServiceManager().isAbilitatoSuImpianto(impianto.getCodiceImpianto(), utenteJWT)) {

							// Compongo la lista degli impianti su cui l'utente e' abilitato
							listImpiantiTmp.add(impianto);
						}
					}

					if (listImpiantiTmp != null && listImpiantiTmp.size() > 0) {
						// Setto la lista degli impianti su cui l'utente e' abilitato
						listImpianti = listImpiantiTmp.toArray(new Impianto[listImpiantiTmp.size()]);
					} else {
						// Sono stati trovato degli impianti, ma su nessuno l'utete e' abilitato
						throw new SigitextException(Messages.ERROR_IMPRESA_NON_ABILITATA_SU_IMPIANTO);
					}
				}
			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}
			getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);
			return listImpianti;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getImpiantoByPODJWT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getImpiantoByPODJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getImpiantoByPODJWT()", "invocazione servizio [sigitext]::[getImpiantoByPODJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getImpiantoByPODJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByPODJWTOld( //NOSONAR  Reason:EIAS
			java.lang.String pod, //NOSONAR  Reason:EIAS
			java.lang.String tokenJWT //NOSONAR  Reason:EIAS
	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS
			, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException, it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException { //NOSONAR  Reason:EIAS
		logger.debug("[SigitextImpl::getImpiantoByPODJWT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_CERCA_IMPIANTO_BY_POD;
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);
			Impianto[] listImpianti = null;

			if (utenteJWT != null) {
				listImpianti = getServiceManager().getImpiantoByPod(pod);

				if (listImpianti != null && listImpianti.length > 0) {
					for (Impianto impianto : listImpianti) {
						if (!getServiceManager().isAbilitatoSuImpianto(impianto.getCodiceImpianto(), utenteJWT)) {
							throw new SigitextException(Messages.ERROR_IMPRESA_NON_ABILITATA_SU_IMPIANTO);
						}
					}
				}

			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}
			getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);
			return listImpianti;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getImpiantoByPODJWT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getImpiantoByPODJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getImpiantoByPODJWT()", "invocazione servizio [sigitext]::[getImpiantoByPODJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getImpiantoByPODJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByPDRJWT( //NOSONAR  Reason:EIAS

			java.lang.String pdr, //NOSONAR  Reason:EIAS

			java.lang.String tokenJWT //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException

			, it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException { //NOSONAR  Reason:EIAS
		logger.debug("[SigitextImpl::getImpiantoByPDRJWT] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_CERCA_IMPIANTO_BY_PDR;
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);
			Impianto[] listImpianti = null;
			ArrayList<Impianto> listImpiantiTmp = new ArrayList<Impianto>();

			if (utenteJWT != null) {

				listImpianti = getServiceManager().getImpiantoByPdr(pdr);

				if (listImpianti != null && listImpianti.length > 0) {
					for (Impianto impianto : listImpianti) {
						if (getServiceManager().isAbilitatoSuImpianto(impianto.getCodiceImpianto(), utenteJWT)) {

							// Compongo la lista degli impianti su cui l'utente e' abilitato
							listImpiantiTmp.add(impianto);
						}
					}

					if (listImpiantiTmp != null && listImpiantiTmp.size() > 0) {
						// Setto la lista degli impianti su cui l'utente e' abilitato
						listImpianti = listImpiantiTmp.toArray(new Impianto[listImpiantiTmp.size()]);
					} else {
						// Sono stati trovato degli impianti, ma su nessuno l'utete e' abilitato
						throw new SigitextException(Messages.ERROR_IMPRESA_NON_ABILITATA_SU_IMPIANTO);
					}
				}
			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}

			getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);
			return listImpianti;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getImpiantoByPDRJWT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getImpiantoByPDRJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getImpiantoByPDRJWT()", "invocazione servizio [sigitext]::[getImpiantoByPDRJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getImpiantoByPDRJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByPDRJWTOld( //NOSONAR  Reason:EIAS

			java.lang.String pdr, //NOSONAR  Reason:EIAS

			java.lang.String tokenJWT //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException

			, it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException { //NOSONAR  Reason:EIAS
		logger.debug("[SigitextImpl::getImpiantoByPDRJWT] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_CERCA_IMPIANTO_BY_PDR;
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);
			Impianto[] listImpianti = null;
			if (utenteJWT != null) {

				listImpianti = getServiceManager().getImpiantoByPdr(pdr);

				if (listImpianti != null && listImpianti.length > 0) {
					for (Impianto impianto : listImpianti) {
						if (!getServiceManager().isAbilitatoSuImpianto(impianto.getCodiceImpianto(), utenteJWT)) {
							throw new SigitextException(Messages.ERROR_IMPRESA_NON_ABILITATA_SU_IMPIANTO);
						}
					}
				}
			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}

			getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);
			return listImpianti;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getImpiantoByPDRJWT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getImpiantoByPDRJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getImpiantoByPDRJWT()", "invocazione servizio [sigitext]::[getImpiantoByPDRJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getImpiantoByPDRJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Documento getLibrettoByUIDJWT( //NOSONAR  Reason:EIAS

			java.lang.String uid, //NOSONAR  Reason:EIAS

			java.lang.String tokenJWT //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { //NOSONAR  Reason:EIAS
		logger.debug("[SigitextImpl::getLibrettoByUIDJWT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_CERCA_LIBRETTO_BY_UID;
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);
			Documento libretto = null;
			if (utenteJWT != null) {
				if (!getServiceManager().isAbilitatoSuLibretto(uid, utenteJWT)) {
					throw new SigitextException(Messages.ERROR_IMPRESA_NON_ABILITATA_SU_IMPIANTO);
				}
				libretto = getServiceManager().getLibrettoByUid(uid);
			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}
			getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);
			return libretto;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getLibrettoByUIDJWT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getLibrettoByUIDJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getLibrettoByUIDJWT()", "invocazione servizio [sigitext]::[getLibrettoByUIDJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getLibrettoByUIDJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Documento getXMLLibrettoNowJWT( //NOSONAR  Reason:EIAS

			java.lang.Integer codiceImpianto, //NOSONAR  Reason:EIAS

			java.lang.Boolean isConsolidato, //NOSONAR  Reason:EIAS

			java.lang.String tokenJWT //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { //NOSONAR  Reason:EIAS
		logger.debug("[SigitextImpl::getXMLLibrettoNowJWT] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_GET_XML_LIBRETTO_NOW;
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);
			Documento xmlLibretto = null;
			if (utenteJWT != null) {
				if (!getServiceManager().isAbilitatoSuImpianto(codiceImpianto, utenteJWT)) {
					throw new SigitextException(Messages.ERROR_IMPRESA_NON_ABILITATA_SU_IMPIANTO);
				}
				xmlLibretto = getServiceManager().getXMLLibretto(codiceImpianto, isConsolidato);
			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}
			getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);
			return xmlLibretto;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getXMLLibrettoNowJWT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getXMLLibrettoNowJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getXMLLibrettoNowJWT()", "invocazione servizio [sigitext]::[getXMLLibrettoNowJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getXMLLibrettoNowJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getCombustibileCIT( //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException { //NOSONAR  Reason:EIAS
		logger.debug("[SigitextImpl::getCombustibileCIT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			CodiceDescrizione[] lista = null;
			lista = getServiceManager().getListaCombustibileCIT();
			return lista;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getCombustibileCIT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getCombustibileCIT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getCombustibileCIT()", "invocazione servizio [sigitext]::[getCombustibileCIT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getCombustibileCIT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getMarcaCIT( //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException { //NOSONAR  Reason:EIAS
		logger.debug("[SigitextImpl::getMarcaCIT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			CodiceDescrizione[] lista = getServiceManager().getListaMarcaCIT();
			return lista;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getMarcaCIT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getMarcaCIT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getMarcaCIT()", "invocazione servizio [sigitext]::[getMarcaCIT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getMarcaCIT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getUnitaMisuraCIT( //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException { //NOSONAR  Reason:EIAS
		logger.debug("[SigitextImpl::getUnitaMisuraCIT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			CodiceDescrizione[] lista = getServiceManager().getListaUnitaMisuraCIT();
			return lista;
			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getUnitaMisuraCIT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getUnitaMisuraCIT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getUnitaMisuraCIT()", "invocazione servizio [sigitext]::[getUnitaMisuraCIT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getUnitaMisuraCIT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Libretto getLibrettoNowJWT( //NOSONAR  Reason:EIAS

			java.lang.Integer codiceImpianto, //NOSONAR  Reason:EIAS

			java.lang.Boolean isConsolidato, //NOSONAR  Reason:EIAS

			java.lang.String tokenJWT //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { //NOSONAR  Reason:EIAS
		logger.debug("[SigitextImpl::getLibrettoNowJWT] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_GET_LIBRETTO_NOW;
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);
			Libretto libretto = null;
			if (utenteJWT != null) {
				if (!getServiceManager().isAbilitatoSuImpianto(codiceImpianto, utenteJWT)) {
					throw new SigitextException(Messages.ERROR_IMPRESA_NON_ABILITATA_SU_IMPIANTO);
				}

				logger.debug("[SigitextImpl::getLibrettoNowJWT] ###########################");
				logger.debug("[SigitextImpl::getLibrettoNowJWT] - codiceImpianto: " + codiceImpianto);
				logger.debug("[SigitextImpl::getLibrettoNowJWT] - isConsolidato: " + isConsolidato);
				logger.debug("[SigitextImpl::getLibrettoNowJWT] ###########################");

				libretto = getServiceManager().getLibretto(codiceImpianto, isConsolidato);
			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}

			getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);

			return libretto;

		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getLibrettoNowJWT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getLibrettoNowJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getLibrettoNowJWT()", "invocazione servizio [sigitext]::[getLibrettoNowJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getLibrettoNowJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Documento getXMLLibrettoConsolidatoJWT( //NOSONAR  Reason:EIAS
			java.lang.Integer codiceImpianto, //NOSONAR  Reason:EIAS
			java.lang.String tokenJWT //NOSONAR  Reason:EIAS
	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS
			, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { //NOSONAR  Reason:EIAS
		logger.debug("[SigitextImpl::getXMLLibrettoConsolidatoJWT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_GET_XML_LIBRETTO_CONSOLIDATO;
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);

			Documento xmlLibrettoConsolidato = null;
			if (utenteJWT != null) {
				if (!getServiceManager().isAbilitatoSuImpianto(codiceImpianto, utenteJWT)) {
					throw new SigitextException(Messages.ERROR_IMPRESA_NON_ABILITATA_SU_IMPIANTO);
				}
				xmlLibrettoConsolidato = getServiceManager().getXMLLibrettoConsolidato(codiceImpianto);
			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}
			getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);
			return xmlLibrettoConsolidato;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getXMLLibrettoConsolidatoJWT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getXMLLibrettoConsolidatoJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getXMLLibrettoConsolidatoJWT()", "invocazione servizio [sigitext]::[getXMLLibrettoConsolidatoJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getXMLLibrettoConsolidatoJWT] - END");
		}
	}

	public void uploadXMLLibrettoJWT( //NOSONAR  Reason:EIAS
			java.lang.Integer codiceImpianto, //NOSONAR  Reason:EIAS
			byte[] xml, //NOSONAR  Reason:EIAS
			java.lang.String tokenJWT //NOSONAR  Reason:EIAS
	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS
			, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { //NOSONAR  Reason:EIAS
		logger.debug("[SigitextImpl::uploadXMLLibrettoJWT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			/*PROTECTED REGION ID(R-1759379489) ENABLED START*/
			// inserire qui il codice di implementazione del metodo 'uploadXMLLibrettoJWT'.
			// non verr&agrave; sovrascritto nelle successive rigenerazioni
			int idFunzionalita = Constants.ID_FUNZ_UPLOAD_XML_LIBRETTO;
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);
			if (utenteJWT != null) {
				if (!getServiceManager().isAbilitatoSuImpianto(codiceImpianto, utenteJWT)) {
					throw new SigitextException(Messages.ERROR_IMPRESA_NON_ABILITATA_SU_IMPIANTO);
				}
				getServiceManager().uploadXMLLibretto(codiceImpianto, xml, utenteJWT);
			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}
			getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::uploadXMLLibrettoJWT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::uploadXMLLibrettoJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "uploadXMLLibrettoJWT()", "invocazione servizio [sigitext]::[uploadXMLLibrettoJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::uploadXMLLibrettoJWT] - END");
		}
	}

	public int uploadXMLControlloJWT( //NOSONAR  Reason:EIAS

			java.lang.Integer codiceImpianto, //NOSONAR  Reason:EIAS

			java.lang.String tipoControllo, //NOSONAR  Reason:EIAS

			byte[] xml, //NOSONAR  Reason:EIAS

			java.lang.String tokenJWT //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { //NOSONAR  Reason:EIAS
		logger.debug("[SigitextImpl::uploadXMLControlloJWT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_UPLOAD_XML_CONTROLLO;
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);
			int idAllegato;
			if (utenteJWT != null) {
				if (!getServiceManager().isAbilitatoSuImpianto(codiceImpianto, utenteJWT)) {
					throw new SigitextException(Messages.ERROR_IMPRESA_NON_ABILITATA_SU_IMPIANTO);
				}
				idAllegato = getServiceManager().uploadXMLControllo(codiceImpianto, tipoControllo, xml, utenteJWT);
			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}

			getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);

			return idAllegato;
		} catch (SigitextException e) {
			logger.error("[SigitextImpl::uploadXMLControlloJWT] - Errore CSI occorso durante l'esecuzione del metodo:" + e, e);
			throw e;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::uploadXMLControlloJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "uploadXMLControlloJWT()", "invocazione servizio [sigitext]::[uploadXMLControlloJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::uploadXMLControlloJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByIndirizzoJWT( //NOSONAR  Reason:EIAS

			java.lang.String indirizzo, //NOSONAR  Reason:EIAS

			java.lang.Integer civico, //NOSONAR  Reason:EIAS

			java.lang.String istat, //NOSONAR  Reason:EIAS

			java.lang.String tokenJWT //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { //NOSONAR  Reason:EIAS
		logger.debug("[SigitextImpl::getImpiantoByIndirizzoJWT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_CERCA_IMPIANTO_BY_INDIRIZZO;
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);
			Impianto[] listImpianti = null;
			if (utenteJWT != null) {
				listImpianti = getServiceManager().getImpiantoByIndirizzo(indirizzo, civico, istat);
				if (listImpianti != null && listImpianti.length > 0) {
					for (Impianto impianto : listImpianti) {
						if (!getServiceManager().isAbilitatoSuImpianto(impianto.getCodiceImpianto(), utenteJWT)) {
							throw new SigitextException(Messages.ERROR_IMPRESA_NON_ABILITATA_SU_IMPIANTO);
						}
					}
				}
			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}
			getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);
			return listImpianti;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getImpiantoByIndirizzoJWT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getImpiantoByIndirizzoJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getImpiantoByIndirizzoJWT()", "invocazione servizio [sigitext]::[getImpiantoByIndirizzoJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getImpiantoByIndirizzoJWT] - END");
		}
	}

	public Ruoli getRuoli(String codiceFiscale, String cognome, String nome) throws CSIException {

		logger.debug("[SigitextImpl::getRuoli] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			SigitTPersonaFisicaDto personaF = getServiceManager().findPersonaFisicaByCF(codiceFiscale);
			Ruoli ruoli = new Ruoli();

			if (personaF == null) {
				SigitTPersonaFisicaDto newPF = new SigitTPersonaFisicaDto();
				newPF.setCodiceFiscale(StringUtils.upperCase(codiceFiscale));
				newPF.setCognome(StringUtils.upperCase(cognome));
				newPF.setNome(StringUtils.upperCase(nome));
				newPF.setFlgAccreditato(Constants.FLG_ACCREDITATO);
				newPF.setDataUltMod(new Timestamp(new Date().getTime()));
				newPF.setUtenteUltMod(codiceFiscale);
				newPF.setFlgGdpr(BigDecimal.ONE);
				personaF = getServiceManager().inserisciOAggiornaPersonaFisica(newPF);
			} else if (personaF.getFlgAccreditato() == null || (personaF.getFlgAccreditato() != null && !personaF.getFlgAccreditato().equals("A"))) {
				personaF.setCognome(StringUtils.upperCase(cognome));
				personaF.setNome(StringUtils.upperCase(nome));
				personaF.setFlgAccreditato(Constants.FLG_ACCREDITATO);
				personaF = getServiceManager().inserisciOAggiornaPersonaFisica(personaF);
			}

			PFLoggato pfLoggato = new PFLoggato();
			pfLoggato.setCodiceFiscalePF(codiceFiscale);
			pfLoggato.setNomePF(nome);
			pfLoggato.setCognomePF(cognome);
			ruoli.setPfLoggato(pfLoggato);
			ruoli.setRuoliPF(fillRuoliPF());
			ruoli.setRuoliPA(fillRuoliPA(personaF));
			ruoli.setRuoliPG(fillRuoliPg(personaF));
			return ruoli;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getRuoli] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getRuoli] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getRuoli()", "invocazione servizio [sigitext]::[getRuoli]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getRuoli] - END");
		}
	}

	private RuoloPG[] fillRuoliPg(SigitTPersonaFisicaDto dto) throws SigitextException {
		List<RuoloPG> ruoliPG = new ArrayList<>();
		List<SigitRPfPgDelegaFindByPfDto> ruoliPgList = getServiceManager().findRuoliPgByPf(dto);

		for (SigitRPfPgDelegaFindByPfDto dto2 : ruoliPgList) {
			if (GenericUtil.isNotNullOrEmpty(dto2.getPgFlgDm37Letterac()) && dto2.getPgFlgDm37Letterac().intValue() == 1) {
				ruoliPG.add(creaRuoloPg(dto2, Constants.RUOLO_IMPRESA));
			}

			// Controllo se e' un amministratore
			if ((GenericUtil.isNotNullOrEmpty(dto2.getPgFlgAmministratore()) && dto2.getPgFlgAmministratore().intValue() == 1) || ((GenericUtil.isNotNullOrEmpty(dto2.getPgFlgSoggIncaricato())
					&& dto2.getPgFlgSoggIncaricato().intValue() == 1))) {
				ruoliPG.add(creaRuoloPg(dto2, Constants.RUOLO_RESPONSABILE_IMPRESA));
				ruoliPG.add(creaRuoloPg(dto2, Constants.RUOLO_PROPRIETARIO_IMPRESA));
			}

			// Controllo se e' un terzo responsabile
			if (GenericUtil.isNotNullOrEmpty(dto2.getPgFlgTerzoResponsabile()) && dto2.getPgFlgTerzoResponsabile().intValue() == 1) {
				ruoliPG.add(creaRuoloPg(dto2, Constants.RUOLO_3RESPONSABILE));
			}

			// Controllo se e' un distributore
			if (GenericUtil.isNotNullOrEmpty(dto2.getPgFlgDistributore()) && dto2.getPgFlgDistributore().intValue() == 1) {
				ruoliPG.add(creaRuoloPg(dto2, Constants.RUOLO_DISTRIBUTORE));
			}

			// Controllo se e' un CAT
			if (GenericUtil.isNotNullOrEmpty(dto2.getPgFlgCat()) && dto2.getPgFlgCat().intValue() == 1) {
				ruoliPG.add(creaRuoloPg(dto2, Constants.RUOLO_CAT));
			}
		}

		for (SigitRPfPgDelegaFindByPfDto dto2 : ruoliPgList) {
			if (GenericUtil.isNotNullOrEmpty(dto2.getPgFlgCat()) && dto2.getPgFlgCat().intValue() == 1) {
				List<SigitRPgPgNominaDto> elencoPgImp = getServiceManager().cercaSigitRPgPgIncaricoAttByIdPersonaGiuridicaCat(dto2.getPgIdPersonaGiuridica());
				for (SigitRPgPgNominaDto sigitRPgPgNominaDto : elencoPgImp) {
					PersonaGiuridica persGiuridicaImp = getServiceManager().cercaPersonaGiuridicaById(ConvertUtil.convertToInteger(sigitRPgPgNominaDto.getIdPersonaGiuridicaImpresa()));

					// Controllo se e' un impresa
					if (GenericUtil.isNotNullOrEmpty(persGiuridicaImp.getFlgDm37Letterac()) && persGiuridicaImp.getFlgDm37Letterac().intValue() == 1) {
						ruoliPG.add(creaRuoloPg(persGiuridicaImp, Constants.CAT_RUOLO_IMPRESA));
					}

					// Controllo se e' un amministratore
					if (GenericUtil.isNotNullOrEmpty(persGiuridicaImp.getFlgAmministratore()) && persGiuridicaImp.getFlgAmministratore().intValue() == 1) {
						ruoliPG.add(creaRuoloPg(persGiuridicaImp, Constants.CAT_RUOLO_RESPONSABILE_IMPRESA));
					}

					// Controllo se e' un terzo responsabile
					if (GenericUtil.isNotNullOrEmpty(persGiuridicaImp.getFlgTerzoResponsabile()) && persGiuridicaImp.getFlgTerzoResponsabile().intValue() == 1) {
						ruoliPG.add(creaRuoloPg(persGiuridicaImp, Constants.CAT_RUOLO_3RESPONSABILE));
					}

					// Controllo se e' un distributore
					if (GenericUtil.isNotNullOrEmpty(persGiuridicaImp.getFlgDistributore()) && persGiuridicaImp.getFlgDistributore().intValue() == 1) {
						ruoliPG.add(creaRuoloPg(persGiuridicaImp, Constants.CAT_RUOLO_DISTRIBUTORE));
					}

				}

			}

		}

		logger.debug("Ruoli pg recuperati per pf " + dto.getIdPersonaFisica() + " : " + ruoliPG);
		return ruoliPG.toArray(new RuoloPG[0]);
	}

	public void setAccesso(UtenteLoggato utenteLoggato) throws CSIException {
		logger.debug("[SigitextImpl::setAccesso] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			SigitLAccessoDto lAccessoDto = new SigitLAccessoDto();
			lAccessoDto.setDtAccesso(new Timestamp(new Date().getTime()));
			lAccessoDto.setNome(utenteLoggato.getPfLoggato().getNomePF());
			lAccessoDto.setCognome(utenteLoggato.getPfLoggato().getCognomePF());
			lAccessoDto.setCodiceFiscale(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
			lAccessoDto.setRuolo(utenteLoggato.getRuoloLoggato().getRuolo());
			logger.info(lAccessoDto);
			getServiceManager().setAccesso(lAccessoDto);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::setAccesso] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::setAccesso] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getRuoli()", "invocazione servizio [sigitext]::[getRuoli]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getRuoli] - END");
		}
	}

	private RuoloPG creaRuoloPg(SigitRPfPgDelegaFindByPfDto dto2, String ruoloImpresa) {
		RuoloPG ruoloPG = new RuoloPG();
		ruoloPG.setPiva(dto2.getPgCodiceFiscale());
		ruoloPG.setSiglaREA(dto2.getPgSiglaRea());
		ruoloPG.setNumeroREA(dto2.getPgNumeroRea() != null ? dto2.getPgNumeroRea().toString() : null);
		ruoloPG.setDenominazione(dto2.getPgDenominazione());
		ruoloPG.setDataCessazione(dto2.getPgDataCessazione());
		ruoloPG.setIdStato(dto2.getPgFkStatoPg());
		ruoloPG.setDescStato(dto2.getStatoPgDesStatoPg());
		ruoloPG.setRuoloPG(ruoloImpresa);
		ruoloPG.setIdPersonaGiuridica(dto2.getPgIdPersonaGiuridica() != null ? dto2.getPgIdPersonaGiuridica().intValue() : null);
		return ruoloPG;
	}

	private RuoloPG creaRuoloPg(PersonaGiuridica dto2, String ruoloImpresa) {
		RuoloPG ruoloPG = new RuoloPG();
		ruoloPG.setPiva(dto2.getCodiceFiscale());
		ruoloPG.setSiglaREA(dto2.getSiglaRea());
		ruoloPG.setNumeroREA(dto2.getNumeroRea() != null ? dto2.getNumeroRea().toString() : null);
		ruoloPG.setDenominazione(dto2.getDenominazione());
		ruoloPG.setDataCessazione(dto2.getDataCessazione());
		ruoloPG.setIdStato(dto2.getFkStatoPg());
		ruoloPG.setDescStato(dto2.getDescStatoPg());
		ruoloPG.setRuoloPG(ruoloImpresa);
		ruoloPG.setIdPersonaGiuridica(dto2.getIdPersonaGiuridica() != null ? dto2.getIdPersonaGiuridica().intValue() : null);
		return ruoloPG;
	}

	public RuoloPF[] fillRuoliPF() {
		List<RuoloPF> ruoliPF = new ArrayList<>();
		ruoliPF.add(new RuoloPF());
		ruoliPF.get(0).setRuoloPF(Constants.RUOLO_RESPONSABILE);
		ruoliPF.add(new RuoloPF());
		ruoliPF.get(1).setRuoloPF(Constants.RUOLO_PROPRIETARIO);
		return ruoliPF.toArray(new RuoloPF[0]);
	}

	public RuoloPA[] fillRuoliPA(SigitTPersonaFisicaDto dto) throws SigitextException {
		List<RuoloPA> ruoliPA = new ArrayList<>();
		List<SigitRPfRuoloPaFindByPfDto> ruolipaList = getServiceManager().findRuoliPAByPf(dto);
		for (SigitRPfRuoloPaFindByPfDto dto2 : ruolipaList) {
			RuoloPA ruoloPA = new RuoloPA();
			ruoloPA.setRuoloPA(dto2.getDRuoloPaDesRuoloPa());
			ruoloPA.setIdRuoloPA(dto2.getRPfRuoloPaIdRuoloPa());
			ruoloPA.setIstatAbilitazione(dto2.getRPfRuoloPaIstatAbilitazione());
			ruoloPA.setDescrAbilitazione(dto2.getRPfRuoloPaDescAbilitazione());
			ruoliPA.add(ruoloPA);
		}
		logger.debug("Ruoli pa recuperati per pf " + dto.getIdPersonaFisica() + " : " + ruoliPA);
		return ruoliPA.toArray(new RuoloPA[0]);
	}

	public CodiceDescrizione[] getStatiImpianto() throws CSIException {
		logger.debug("[SigitextImpl::getStatoImpianto] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			List<SigitDStatoImpiantoDto> statiImpianto = getServiceManager().getStatiImpianto();
			CodiceDescrizione[] codiceDescrizioneArray = new CodiceDescrizione[statiImpianto.size()];
			int count = 0;
			for (SigitDStatoImpiantoDto stato : statiImpianto) {
				codiceDescrizioneArray[count] = new CodiceDescrizione();
				codiceDescrizioneArray[count].setCodice(stato.getIdStato() != null ? stato.getIdStato().toString() : "");
				codiceDescrizioneArray[count].setDescrizione(stato.getDesStato());
				count++;
			}
			return codiceDescrizioneArray;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::setAccesso] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::setAccesso] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getStatoImpianto()", "invocazione servizio [sigitext]::[getStatoImpianto]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getStatoImpianto] - END");
		}
	}

	public CodiceDescrizione[] getStelle() throws CSIException {
		logger.debug("[SigitextImpl::getStelle] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			List<CodiceDescrizione> stelleList = getServiceManager().getIdDescriptionStelle();
			return stelleList.toArray(new CodiceDescrizione[0]);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getStelle] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getStelle] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getStelle()", "invocazione servizio [sigitext]::[getStelle]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getStelle] - END");
		}
	}

	public CodiceDescrizione[] getApparecchiature() throws CSIException {
		logger.debug("[SigitextImpl::getApparecchiature] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			List<CodiceDescrizione> apparecchiature = getServiceManager().getIdDescriptionApparecchiature();
			return apparecchiature.toArray(new CodiceDescrizione[0]);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getApparecchiature] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getApparecchiature] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getApparecchiature()", "invocazione servizio [sigitext]::[getApparecchiature]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getApparecchiature] - END");
		}
	}

	public CodiceDescrizione[] getControlloAria() throws CSIException {
		logger.debug("[SigitextImpl::getControlloAria] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			List<CodiceDescrizione> controlloAriaList = getServiceManager().getIdDescriptionControlloAria();
			return controlloAriaList.toArray(new CodiceDescrizione[0]);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getControlloAria] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getControlloAria] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getControlloAria()", "invocazione servizio [sigitext]::[getControlloAria]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getControlloAria] - END");
		}
	}

	public CodiceDescrizione[] getAriaComburente() throws CSIException {
		logger.debug("[SigitextImpl::getAriaComburente] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			List<CodiceDescrizione> ariaComburenteList = getServiceManager().getIdDescriptionAriaComburente();
			return ariaComburenteList.toArray(new CodiceDescrizione[0]);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getAriaComburente] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getAriaComburente] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getAriaComburente()", "invocazione servizio [sigitext]::[getAriaComburente]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getAriaComburente] - END");
		}
	}

	public Esito salvaImpianto(UtenteLoggato utenteLoggato, DatiImpianto datiImpianto, Integer responsabilita) throws SigitextException {
		try {

			String ruoloUtente = utenteLoggato.getRuoloLoggato().getRuolo();

			if (GenericUtil.isNotNullOrEmpty(datiImpianto.getCodiceImpianto())) {
				getValidationManager().verificaCodiceImpiantoIdentificazione(datiImpianto.getCodiceImpianto());
			}
			String codiceImpianto = getServiceManager().salvaImpiantoTrans(datiImpianto, ruoloUtente, utenteLoggato, responsabilita);
			Esito esito = new Esito();
			esito.setEsito("OK");
			esito.setCodiceImpianto(codiceImpianto);
			return esito;
		} catch (SigitextException e) {
			logger.error("errore validazione", e);
			logger.error(e.getMessage());
			throw new SigitextException(e.getMessage());
		} catch (Exception e) {
			logger.error("Errore inserimento impianto:", e);
			throw new SigitextException("Errore generico inserisci impianto");
		}
	}

	public Esito updateImpianto(UtenteLoggato utenteLoggato, DatiImpianto datiImpianto) throws SigitextException, ValidationManagerException {
		try {

			String ruoloUtente = utenteLoggato.getRuoloLoggato().getRuolo();
			getValidationManager().validazioneFormaleSalvaImpianto(datiImpianto, ruoloUtente);

			if (!(ruoloUtente.equalsIgnoreCase(Constants.RUOLO_SUPER) || ruoloUtente.equalsIgnoreCase(Constants.RUOLO_VALIDATORE) || ruoloUtente.equalsIgnoreCase(Constants.RUOLO_ISPETTORE))) {
				getValidationManager().verificaModificaUbicazioneImpiantoIdentificazione(datiImpianto);
			}
			SigitVRicercaImpiantiDto oldImpianto = dbServiceImp.cercaImpiantoByCodImpianto(ConvertUtil.convertToBigDecimal(datiImpianto.getCodiceImpianto()));
			datiImpianto = getDbServiceImp().updateImpianto(datiImpianto, ruoloUtente, utenteLoggato);

			Esito esito = new Esito();
			esito.setEsito("OK");
			esito.setCodiceImpianto(datiImpianto.getCodiceImpianto());
			Documento doc = getServiceManager().getXMLLibretto(Integer.parseInt(datiImpianto.getCodiceImpianto()), false);
			if (doc != null)
				esito.setXmlLibretto(doc.getDoc());
			ImpiantoFiltro filtro = new ImpiantoFiltro();
			filtro.setPod(datiImpianto.getPod());
			filtro.setFkStato(Constants.ID_STATO_IMPRESA_ATTIVA);
			List<SigitExtImpiantoDto> podAttivi = dbServiceImp.ricercaImpiantoByFiltro(filtro);
			if (!oldImpianto.getPodElettrico().equals(datiImpianto.getPod())) {
				if (checkPODPDRPresenti(datiImpianto.getCodiceImpianto(), podAttivi)) {
					esito.setDescrizioneEsito("Codice POD inserito gia' presente sul sistema");
				}
			}
			if (datiImpianto.getFlgNoPdr() == 0) {
				if (!datiImpianto.getPdr().equals(oldImpianto.getPdrGas())) {
					filtro.setPod(null);
					filtro.setPdr(datiImpianto.getPdr());
					List<SigitExtImpiantoDto> pdrAttivi = dbServiceImp.ricercaImpiantoByFiltro(filtro);
					if (checkPODPDRPresenti(datiImpianto.getCodiceImpianto(), pdrAttivi)) {
						esito.setDescrizioneEsito("Codice PDR inserito gia' presente sul sistema");
					}
				}
			}
			return esito;
		} catch (ValidationManagerException e) {
			logger.error("Errore: ", e);
			logger.error(e.getMessage());
			logger.error(e.getFieldList());
			for (FieldError fieldError : e.getFieldList()) {
				logger.error(fieldError.getField() + ":" + fieldError.getMessageField());
			}
			throw new ValidationManagerException(e.getMsg());
		} catch (Exception e) {
			logger.error("Errore inserimento impianto:", e);
			throw new SigitextException("");
		}
	}
	
	private boolean checkPODPDRPresenti(String codiceImpianto, List<SigitExtImpiantoDto> impianti) {
		
		boolean check = false;
		if (impianti != null && !impianti.isEmpty()) {
			for (SigitExtImpiantoDto impianto : impianti) {
				if (!impianto.getCodiceImpianto().equals(new BigDecimal(codiceImpianto))) {
					check = true;
					break;
				}
			}
		}
		
		return check;
	}

	public Persona[] getRespProp(Integer tipo, String cf, String siglaRea, String numeroRea) throws SigitextException, ValidationManagerException {
		try {
			List<Persona> persona = new ArrayList<>();
			if (tipo != null && tipo == 1) {
				List<SigitTPersonaGiuridicaDto> personaGiutidicaDto = null;
				if (cf != null) {
					personaGiutidicaDto = getDbServiceImp().getSigitTPersonaGiuridicaDao().findByPiva(cf);
				} else {
					logger.debug(siglaRea);
					logger.debug(numeroRea);
					CodiceReaAndFiscaleFilter filter = new CodiceReaAndFiscaleFilter();
					filter.setNumeroRea(new BigDecimal(numeroRea));
					filter.setSiglaRea(siglaRea);
					personaGiutidicaDto = getDbServiceImp().getSigitTPersonaGiuridicaDao().findByCodiceReaAndFiscale(filter);
				}
				if (personaGiutidicaDto != null) {
					for (SigitTPersonaGiuridicaDto tPersonaGiutidicaDto : personaGiutidicaDto) {
						Persona personaRecuperata = MapDto.mapPersonaGiuridica(tPersonaGiutidicaDto, "1", tipo);
						List<SigitRPfPgDelegaDto> deleghePg = getDbServiceImp().getSigitRPfPgDelegaDao().findFindByPg(ConvertUtil.convertToInteger(tPersonaGiutidicaDto.getIdPersonaGiuridica()));
						if(deleghePg!=null && !deleghePg.isEmpty()){
							personaRecuperata.setAccreditato(Constants.FLG_ACCREDITATO);
						}
						persona.add(personaRecuperata);
					}
				}
			} else {
				List<SigitTPersonaFisicaDto> personaFisicaList = getDbServiceImp().getSigitTPersonaFisicaDao().findByCodiceFiscale(cf);
				if (personaFisicaList != null)
					for (SigitTPersonaFisicaDto personaFisicaDto : personaFisicaList) {
						persona.add(MapDto.mapPersonaFisica(personaFisicaDto, "0", tipo));
					}
			}
			return persona.toArray(new Persona[0]);
		} catch (Exception e) {
			logger.error("Errore recupero persone:", e);
			throw new SigitextException("Errore recupero persone:", e);
		}
	}

	public Esito salvaResponsabile(RespPropModel model) throws SigitextException, ValidationManagerException {
		try {
			Persona persona = model.getPersona();
			Responsabile responsabile = MapDto.mapPersonaToResponsabile(persona);
			getValidationManager().validazioneFormaleSalvaResponsabile(responsabile, responsabile.getFlgResponsabile());

			if (responsabile.getFlgResponsabile()) {
				if (!GenericUtil.isNullOrEmpty(responsabile.getIdResponsabile())) {
					FiltroRicercaPfPg filter = new FiltroRicercaPfPg();
					filter.setCodiceImpianto(model.getCodiceImpianto());
					if (responsabile.getFlgImpresa()) {
						filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO));
						filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE));
						filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE));
						filter.setIdPersonaGiuridica(BigDecimal.valueOf(responsabile.getIdResponsabile()));
					} else {
						filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_PROPRIETARIO));
						filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_OCCUPANTE));
						filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_AMMINISTRATORE));
						filter.setIdPersonaFisica(BigDecimal.valueOf(responsabile.getIdResponsabile()));
					}
					List<SigitRImpRuoloPfpgDto> proprietariList = getDbServiceImp().getSigitRImpRuoloPfpgDao().findAttiviByFilter(filter);
					if (proprietariList != null && proprietariList.size() != 0) {
						responsabile.setIdImpResp(proprietariList.get(0).getIdImpRuoloPfpg().intValue());
					}
				}

				// Queste verifiche non le devo fare se sto inserendo un proprietario (esplicito)
				ArrayList<RisultatoRicResponsabile> responsabiliList = getServiceManager().cercaResponsabiliByIdImpianto(ConvertUtil.convertToInteger(model.getCodiceImpianto()));
				getValidationManager().verificaDateResponsabile(responsabile, responsabiliList, model.getCodiceImpianto());
			}

			responsabile = getServiceManager().salvaResponsabileTrans(responsabile, model.getCodiceImpianto(), model.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());

			Esito esito = new Esito();
			esito.setEsito("OK");
			esito.setCodiceImpianto(model.getCodiceImpianto());
			Documento doc = getServiceManager().getXMLLibretto(Integer.parseInt(model.getCodiceImpianto()), false);
			if (doc != null)
				esito.setXmlLibretto(doc.getDoc());
			return esito;
		} catch (ValidationManagerException ex) {
			logger.error(ex.getMsg().getText(), ex);
			throw new ValidationManagerException(ex.getMsg());
		} catch (Exception e) {
			logger.error("[salvaResponsabile] Errore occorso nell'esecuzione del metodo:" + e.getMessage(), e);
			throw new SigitextException("[salvaResponsabile] Errore occorso nell'esecuzione del metodo:", e);
		}
	}

	public DatiGT[] getGT(String codiceimpianto, Integer progressivo, Integer idPersonaGiuridica) throws SigitextException {
		try {
			CompFilter compFilter = new CompFilter();
			if (codiceimpianto != null) {
				compFilter.setCodImpianto(Integer.parseInt(codiceimpianto));
			}
			if (progressivo != null) {
				compFilter.setProgressivo(progressivo.toString());
			}
			if (idPersonaGiuridica != null) {
				compFilter.setIdPG(idPersonaGiuridica);
			}
			compFilter.setTipoComponente(Constants.TIPO_COMPONENTE_GT);

			List<DatiGT> datiGTList = getServiceManager().findDatiGTByFiltro(compFilter);
			logger.debug(datiGTList);
			if (datiGTList != null)
				return datiGTList.toArray(new DatiGT[0]);
			else
				return new DatiGT[0];
		} catch (Exception e) {
			logger.error("Errore recupero persone:", e);
			throw new SigitextException("Errore recupero persone:", e);
		}
	}

	public DatiGF[] getGF(String codiceimpianto, Integer progressivo, Integer idPersonaGiuridica) throws SigitextException {
		try {
			CompFilter compFilter = new CompFilter();
			if (codiceimpianto != null) {
				compFilter.setCodImpianto(Integer.parseInt(codiceimpianto));
			}
			if (progressivo != null) {
				compFilter.setProgressivo(progressivo.toString());
			}
			if (idPersonaGiuridica != null) {
				compFilter.setIdPG(idPersonaGiuridica);
			}
			compFilter.setTipoComponente(Constants.TIPO_COMPONENTE_GF);

			List<DatiGF> datiGF = getServiceManager().findDatiGFByFiltro(compFilter);
			logger.debug(datiGF);
			if (datiGF != null)
				return datiGF.toArray(new DatiGF[0]);
			else
				return new DatiGF[0];
		} catch (Exception e) {
			logger.error("Errore recupero persone:", e);
			throw new SigitextException("Errore recupero persone:", e);
		}
	}

	public DatiSC[] getSC(String codiceimpianto, Integer progressivo, Integer idPersonaGiuridica) throws SigitextException {
		try {
			CompFilter compFilter = new CompFilter();
			if (codiceimpianto != null) {
				compFilter.setCodImpianto(Integer.parseInt(codiceimpianto));
			}
			if (progressivo != null) {
				compFilter.setProgressivo(progressivo.toString());
			}
			if (idPersonaGiuridica != null) {
				compFilter.setIdPG(idPersonaGiuridica);
			}
			compFilter.setTipoComponente(Constants.TIPO_COMPONENTE_SC);

			List<DatiSC> datiSC = getServiceManager().findDatiSCByFiltro(compFilter);
			logger.debug(datiSC);
			if (datiSC != null)
				return datiSC.toArray(new DatiSC[0]);
			else
				return new DatiSC[0];
		} catch (Exception e) {
			logger.error("Errore recupero persone:", e);
			throw new SigitextException("Errore recupero persone:", e);
		}
	}

	public DatiCG[] getCG(String codiceimpianto, Integer progressivo, Integer idPersonaGiuridica) throws SigitextException {
		try {
			CompFilter compFilter = new CompFilter();
			if (codiceimpianto != null) {
				compFilter.setCodImpianto(Integer.parseInt(codiceimpianto));
			}
			if (progressivo != null) {
				compFilter.setProgressivo(progressivo.toString());
			}
			if (idPersonaGiuridica != null) {
				compFilter.setIdPG(idPersonaGiuridica);
			}
			compFilter.setTipoComponente(Constants.TIPO_COMPONENTE_CG);

			List<DatiCG> datiCG = getServiceManager().findDatiCGByFiltro(compFilter);
			logger.debug(datiCG);
			if (datiCG != null)
				return datiCG.toArray(new DatiCG[0]);
			else
				return new DatiCG[0];
		} catch (Exception e) {
			logger.error("Errore recupero persone:", e);
			throw new SigitextException("Errore recupero persone:", e);
		}
	}

	public CodiceDescrizione[] getTipologiaGT() throws CSIException {
		logger.debug("[SigitextImpl::getTipologiaGT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			CodiceDescrizione[] lista = null;
			lista = getServiceManager().getTipologaGT();
			return lista;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getTipologiaGT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getTipologiaGT()", "invocazione servizio [sigitext]::[getTipologiaGT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getTipologiaGT] - END");
		}
	}

	public CodiceDescrizione[] getTipologiaGF() throws CSIException {
		logger.debug("[SigitextImpl::getTipologiaGF] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			CodiceDescrizione[] lista = null;
			lista = getServiceManager().getTipologaGF();
			return lista;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getTipologiaGF] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getTipologiaGF()", "invocazione servizio [sigitext]::[getTipologiaGF]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getTipologiaGF] - END");
		}
	}

	public CodiceDescrizione[] getFonteCIT() throws CSIException {
		logger.debug("[SigitextImpl::getFonteCIT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			CodiceDescrizione[] lista = null;
			lista = getServiceManager().getFonteCIT();
			return lista;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getFonteCIT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getFonteCIT()", "invocazione servizio [sigitext]::[getFonteCIT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getFonteCIT] - END");
		}
	}

	public CodiceDescrizione[] getTipoCannaFumaria() throws CSIException {
		logger.debug("[SigitextImpl::getTipologiaGT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			CodiceDescrizione[] lista = null;
			lista = getServiceManager().getTipoCannaFumaria();
			return lista;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getTipologiaGT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getTipologiaGT()", "invocazione servizio [sigitext]::[getTipologiaGT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getTipologiaGT] - END");
		}
	}

	public Esito updateGT(String codiceImpianto, List<DatiGT> datiGTList, UtenteLoggato utenteLoggato, Integer idImpresa) throws NotFoundException, CSIException {
		logger.debug("[SigitextImpl::getTipologiaGT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			Integer idPersonaGiuridica = idImpresa;
			if (idImpresa == null) {
				idPersonaGiuridica = getServiceManager().getImpresaAssociata(utenteLoggato, codiceImpianto);
			}
			if (idPersonaGiuridica != null) {
				String progressivo = datiGTList.get(0).getProgressivo() != null ? datiGTList.get(0).getProgressivo().toString() : null;
				if (progressivo == null) {
					SigitTComp4Dto last = getDbServiceImp().cercaUltimoComponente(codiceImpianto, Constants.TIPO_COMPONENTE_GT);
					if (last != null) {
						progressivo = ConvertUtil.convertToString((last.getProgressivo().add(BigDecimal.ONE)));
					} else {
						progressivo = ConvertUtil.convertToString(BigDecimal.ONE);
					}
				}
				getServiceManager().salvaComponenteGT(codiceImpianto, progressivo, datiGTList, idPersonaGiuridica, utenteLoggato);
				return new Esito(Constants.OK, "Operazione completata");
			} else {
				throw new NotFoundException(Constants.KO_PG);
			}
		} catch (NotFoundException e) {
			throw e;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getTipologiaGT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getTipologiaGT()", "invocazione servizio [sigitext]::[getTipologiaGT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getTipologiaGT] - END");
		}
	}

	public Esito updateGF(String codiceImpianto, List<DatiGF> datiGFList, UtenteLoggato utenteLoggato, Integer idImpresa) throws NotFoundException, CSIException {
		logger.debug("[SigitextImpl::getTipologiaGF] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			Integer idPersonaGiuridica = idImpresa;
			if (idImpresa == null) {
				idPersonaGiuridica = getServiceManager().getImpresaAssociata(utenteLoggato, codiceImpianto);
			}
			if (idPersonaGiuridica != null) {
				String progressivo = datiGFList.get(0).getProgressivo() != null ? datiGFList.get(0).getProgressivo().toString() : null;
				if (progressivo == null) {
					SigitTComp4Dto last = getDbServiceImp().cercaUltimoComponente(codiceImpianto, Constants.TIPO_COMPONENTE_GF);
					if (last != null) {
						progressivo = ConvertUtil.convertToString((last.getProgressivo().add(BigDecimal.ONE)));
					} else {
						progressivo = ConvertUtil.convertToString(BigDecimal.ONE);
					}
				}
				getServiceManager().salvaComponenteGF(codiceImpianto, progressivo, datiGFList, idPersonaGiuridica, utenteLoggato);
				return new Esito(Constants.OK, "Operazione completata");
			} else {
				throw new NotFoundException(Constants.KO_PG);
			}
		} catch (NotFoundException e) {
			throw e;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getTipologiaGF] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getTipologiaGF()", "invocazione servizio [sigitext]::[getTipologiaGF]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getTipologiaGF] - END");
		}
	}

	public Esito updateSC(String codiceImpianto, List<DatiSC> datiSCList, UtenteLoggato utenteLoggato, Integer idImpresa) throws NotFoundException, CSIException {
		logger.debug("[SigitextImpl::getTipologiaSC] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			Integer idPersonaGiuridica = idImpresa;
			if (idImpresa == null) {
				idPersonaGiuridica = getServiceManager().getImpresaAssociata(utenteLoggato, codiceImpianto);
			}
			if (idPersonaGiuridica != null) {
				String progressivo = datiSCList.get(0).getProgressivo() != null ? datiSCList.get(0).getProgressivo().toString() : null;
				if (progressivo == null) {
					SigitTComp4Dto last = getDbServiceImp().cercaUltimoComponente(codiceImpianto, Constants.TIPO_COMPONENTE_SC);
					if (last != null) {
						progressivo = ConvertUtil.convertToString((last.getProgressivo().add(BigDecimal.ONE)));
					} else {
						progressivo = ConvertUtil.convertToString(BigDecimal.ONE);
					}
				}
				getServiceManager().salvaComponenteSC(codiceImpianto, progressivo, datiSCList, idPersonaGiuridica, utenteLoggato);
				return new Esito(Constants.OK, "Operazione completata");
			} else {
				throw new NotFoundException(Constants.KO_PG);
			}
		} catch (NotFoundException e) {
			throw e;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getTipologiaSC] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getTipologiaSC()", "invocazione servizio [sigitext]::[getTipologiaSC]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getTipologiaSC] - END");
		}
	}

	public Esito updateCG(String codiceImpianto, List<DatiCG> datiCGList, UtenteLoggato utenteLoggato, Integer idImpresa) throws NotFoundException, CSIException {
		logger.debug("[SigitextImpl::getTipologiaCG] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			Integer idPersonaGiuridica = idImpresa;
			if (idImpresa == null) {
				idPersonaGiuridica = getServiceManager().getImpresaAssociata(utenteLoggato, codiceImpianto);
			}
			if (idPersonaGiuridica != null) {
				String progressivo = datiCGList.get(0).getProgressivo() != null ? datiCGList.get(0).getProgressivo().toString() : null;
				if (progressivo == null) {
					SigitTComp4Dto last = getDbServiceImp().cercaUltimoComponente(codiceImpianto, Constants.TIPO_COMPONENTE_CG);
					if (last != null) {
						progressivo = ConvertUtil.convertToString((last.getProgressivo().add(BigDecimal.ONE)));
					} else {
						progressivo = ConvertUtil.convertToString(BigDecimal.ONE);
					}
				}
				getServiceManager().salvaComponenteCG(codiceImpianto, progressivo, datiCGList, idPersonaGiuridica, utenteLoggato);
				return new Esito(Constants.OK, "Operazione completata");
			} else {
				throw new NotFoundException(Constants.KO_PG);
			}
		} catch (NotFoundException e) {
			throw e;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getTipologiaCG] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getTipologiaCG()", "invocazione servizio [sigitext]::[getTipologiaCG]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getTipologiaCG] - END");
		}
	}

	public List<Controllo> getControlli(String codiceImpianto, String ordinamento, Integer numRighe) throws CSIException {
		logger.debug("[SigitextImpl::getControlli] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			return getServiceManager().getControlliOrdinati(codiceImpianto, ordinamento, numRighe);
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getControlli] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getControlli()", "invocazione servizio [sigitext]::[getControlli]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getControlli] - END");
		}
	}

	@Transactional
	public Esito delComponenteImpianto(String codiceImpianto, String tipologia, Integer progressivo, String cfUtente) throws ValidationManagerException, SigitextException {
		logger.debug("[SigitextImpl::delComponenteImpianto] - START");
		try {
			Integer count = getServiceManager().contaComponenti4ByFilter(codiceImpianto, progressivo, tipologia);
			if (count != null && count > 1) {
				throw new ValidationManagerException(new Message("Sono presenti altri componenti dismessi"));
			} else {
				switch (tipologia) {
					case Constants.TIPO_COMPONENTE_GT:
						DatiGT componenteToDelete = (DatiGT) getServiceManager().cercaComponente4AttivaByFilter(codiceImpianto, progressivo, tipologia);
						if (componenteToDelete != null) {
							getServiceManager().checkPresenzaREEComponenteDaEliminare(codiceImpianto, tipologia, progressivo.toString());
							getServiceManager().checkPresenzaBRRCbyGT(codiceImpianto, ConvertUtil.convertToString(componenteToDelete.getDataInstall()), progressivo.toString());
						}
						getDbServiceImp().cancellaComponenteGT(ConvertUtil.convertToInteger(codiceImpianto), ConvertUtil.convertToString(progressivo), tipologia, cfUtente);
						break;
					case Constants.TIPO_COMPONENTE_GF:
						DatiGF componenteToDeleteGF = (DatiGF) getServiceManager().cercaComponente4AttivaByFilter(codiceImpianto, progressivo, tipologia);
						if (componenteToDeleteGF != null) {
							getServiceManager().checkPresenzaREEComponenteDaEliminare(codiceImpianto, tipologia, progressivo.toString());
						}
						getDbServiceImp().cancellaComponenteGF(ConvertUtil.convertToInteger(codiceImpianto), ConvertUtil.convertToString(progressivo), tipologia, cfUtente);
						break;
					case Constants.TIPO_COMPONENTE_SC:
						DatiSC componenteToDeleteSC = (DatiSC) getServiceManager().cercaComponente4AttivaByFilter(codiceImpianto, progressivo, tipologia);
						if (componenteToDeleteSC != null) {
							getServiceManager().checkPresenzaREEComponenteDaEliminare(codiceImpianto, tipologia, progressivo.toString());
						}
						getDbServiceImp().cancellaComponenteSC(ConvertUtil.convertToInteger(codiceImpianto), ConvertUtil.convertToString(progressivo), tipologia, cfUtente);
						break;
					case Constants.TIPO_COMPONENTE_CG:
						DatiCG componenteToDeleteCG = (DatiCG) getServiceManager().cercaComponente4AttivaByFilter(codiceImpianto, progressivo, tipologia);
						if (componenteToDeleteCG != null) {
							getServiceManager().checkPresenzaREEComponenteDaEliminare(codiceImpianto, tipologia, progressivo.toString());
						}
						getDbServiceImp().cancellaComponenteCG(ConvertUtil.convertToInteger(codiceImpianto), ConvertUtil.convertToString(progressivo), tipologia, cfUtente);
						break;
				}
			}
			return new Esito(Constants.OK, "Eliminazione effettuata con successo");
		} catch (SigitextException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("[delComponenteImpianto] errore cancellazione componente:" + e.getMessage(), e);
			throw new SigitextException(e.getMessage());
		} catch (ValidationManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("[delComponenteImpianto] errore cancellazione componente:" + e.getMsg().getText(), e);
			throw new SigitextException(e.getMsg().getText());
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("[delComponenteImpianto] errore cancellazione componente:" + e, e);
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO, e);
		} finally {
			logger.debug("[SigitextImpl::delComponenteImpianto] - END");
		}
	}

	public byte[] downloadXMLControllo(Integer idAllegato) throws CSIException {
		logger.debug("[SigitextImpl::downloadXMLControllo] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		byte[] xml = null;
		try {
			logger.debug("[ID ALLEGATO] - " + idAllegato);
			SigitTAllegatoDto allegatoDto = getServiceManager().getAllegatoByidAllegato(idAllegato);
			SigitVRicercaAllegatiDto ricercaAllegatiDto = getServiceManager().getDbServiceImp().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato.toString());
			if (allegatoDto != null) {
				logger.debug("[tipo doc] - " + allegatoDto.getFkTipoDocumento().toString());
				switch (allegatoDto.getFkTipoDocumento().toString()) {
					case Constants.ALLEGATO_TIPO_1:
						xml = getServiceManager().generaXMLControlloTipo1(ricercaAllegatiDto, allegatoDto);
						break;
					case Constants.ALLEGATO_TIPO_1B:
						xml = getServiceManager().generaXMLControlloTipo1B(ricercaAllegatiDto, allegatoDto);
						break;
					case Constants.ALLEGATO_TIPO_2:
						xml = getServiceManager().generaXMLControlloTipo2(ricercaAllegatiDto, allegatoDto);
						break;
					case Constants.ALLEGATO_TIPO_3:
						xml = getServiceManager().generaXMLControlloTipo3(ricercaAllegatiDto, allegatoDto);
						break;
					case Constants.ALLEGATO_TIPO_4:
						xml = getServiceManager().generaXMLControlloTipo4(ricercaAllegatiDto, allegatoDto);
						break;
				}
			}
			return xml;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getControlli] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "downloadXMLControllo()", "invocazione servizio [sigitext]::[downloadXMLControllo]", "(valore input omesso)");
			logger.debug("[SigitextImpl::downloadXMLControllo] - END");
		}
	}

	public byte[] getRicevutaControllo(String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, String ruolo, Integer idPersona)
			throws CSIException {
		logger.debug("[SigitextImpl::getRicevutaControllo] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		byte[] ricevuta = null;
		try {
			SigitVRicercaAllegatiDto allegatoDB = getDbServiceImp().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);
			if (allegatoDB != null) {
				if (Constants.RUOLO_SUPER.equals(ruolo) || Constants.RUOLO_VALIDATORE.equals(ruolo) || Constants.RUOLO_ISPETTORE.equals(ruolo) || Constants.RUOLO_CONSULTATORE.equals(ruolo)
						|| Constants.RUOLO_PROPRIETARIO.equals(ruolo) || (Constants.RUOLO_IMPRESA.equals(ruolo) && idPersona == allegatoDB.getIdPersonaGiuridica().intValue())) {
					ricevuta = getServiceManager().generaRicevutaAllegato(idAllegato);
				} else
					throw new SigitextException("Utente non autorizzato al recupero della ricevuta");
			}
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getRicevutaControllo] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getRicevutaControllo()", "invocazione servizio [sigitext]::[getRicevutaControllo]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getRicevutaControllo] - END");
		}
		return ricevuta;
	}

	public PdfControllo getPDFControllo(String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, Boolean firmato, String ruolo, Integer idPersona)
			throws CSIException {
		logger.debug("[SigitextImpl::getPDFControllo] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		PdfControllo pdf = null;
		try {
			SigitVRicercaAllegatiDto allegatoDB = getDbServiceImp().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);
			if (allegatoDB != null) {
				if (Constants.RUOLO_SUPER.equals(ruolo) || Constants.RUOLO_VALIDATORE.equals(ruolo) || Constants.RUOLO_ISPETTORE.equals(ruolo) || Constants.RUOLO_CONSULTATORE.equals(ruolo)
						|| Constants.RUOLO_PROPRIETARIO.equals(ruolo) || (Constants.RUOLO_IMPRESA.equals(ruolo) && idPersona == allegatoDB.getIdPersonaGiuridica().intValue())) {
					pdf = getServiceManager().recueraAllegatoRee(idAllegato, codiceImpianto, firmato);
				} else
					throw new SigitextException("Utente non autorizzato al recupero della ricevuta");
			}
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getPDFControllo] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getPDFControllo()", "invocazione servizio [sigitext]::[getPDFControllo]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getPDFControllo] - END");
		}
		return pdf;
	}

	public List<ControlloDisponibile> getControlloDisponibile(String codiceImpianto, Date dataControllo, String tipoControllo, String tipoComponente, String ruolo, Integer idImpresa)
			throws CSIException, ValidationManagerException {
		logger.debug("[SigitextImpl::getControlloDisponibile] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		List<ControlloDisponibile> disponibileList = null;
		Integer idImpresaUtente = null;
		try {
			if (ruolo != null && ruolo.equals(Constants.RUOLO_IMPRESA)) {
				idImpresaUtente = idImpresa;
			}
			disponibileList = getServiceManager().getControlliDisponibili(codiceImpianto, tipoComponente, tipoControllo, dataControllo, idImpresaUtente);
			if (validationManager.isNessunResponsabileByCodImpiantoApp(codiceImpianto, ConvertUtil.convertToString(dataControllo))) {
				throw new ValidationManagerException(new Message(GenericUtil.replacePlaceholder(Messages.ERROR_NESSUN_RESPONSABILE_A_DATA_CONTROLLO, ConvertUtil.convertToString(dataControllo), codiceImpianto)));
			}
		} catch (ValidationManagerException e) {
			logger.error("[SigitextImpl::getControlloDisponibile] - Errore CSI occorso durante l'esecuzione del metodo:" + e, e);
			throw e;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getControlloDisponibile] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getControlloDisponibile()", "invocazione servizio [sigitext]::[getControlloDisponibile]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getControlloDisponibile] - END");
		}
		return disponibileList;
	}

	public Esito uploadReeFirmato(byte[] file, Integer idAllegato, String fileName, String contentType, String ruolo, Integer idImpresa, String cf) throws SigitextException {
		Esito esito = new Esito();
		try {
			SigitTImpiantoDto impianto = null;
			DettaglioAllegato dettaglioAllegato = null;
			File unzippedFile = null;
			boolean proceed = false;
			String newName;
			logger.debug("id allegato selez: " + idAllegato);
			dettaglioAllegato = getServiceManager().getDettaglioAllegatoById(idAllegato);
			if (dettaglioAllegato != null) {
				impianto = getDbServiceImp().cercaImpiantoDtoById(dettaglioAllegato.getCodiceImpianto());
				SigitTAllegatoDto allegato = getDbServiceImp().getSigitTAllegatoDao().findByPrimaryKey(new SigitTAllegatoPk(new BigDecimal(idAllegato)));
				if (impianto != null) {
					if (contentType.equals("application/pkcs7-mime") || contentType.equals("application/x-pkcs7-mime")) {
						logger.debug("--------------unzip--------------");
						unzippedFile = getServiceManager().estraiDocumento(dettaglioAllegato, allegato, file, impianto);
					}
					logger.debug("---------------------" + (contentType.equals("application/pdf") || unzippedFile != null) + "-----------------");
					if (contentType.equals("application/pdf") || unzippedFile != null) {
						if (allegato != null) {
							if (unzippedFile != null) {
								proceed = getServiceManager().leggiPdfReeFirmato(Files.readAllBytes(unzippedFile.toPath()), allegato);
								logger.debug("--------------------- proceed unzipped " + proceed + "-----------------");
							} else {
								proceed = getServiceManager().leggiPdfReeFirmato(file, allegato);
								logger.debug("--------------------- proceed normale" + proceed + "-----------------");
							}
							if (proceed) {
								if (allegato.getUidIndexFirmato() != null) {
									getServiceManager().indexDeleteContentByUid(allegato.getUidIndexFirmato());
								}
								Metadati metadati = getServiceManager().createMetadatiReeFirmato(dettaglioAllegato, impianto);
								logger.debug(metadati);
								ImportFileSuper doc = new ImportFileSuper();
								doc.setContentType(contentType);
								File temp = File.createTempFile(fileName, "");
								FileUtils.writeByteArrayToFile(temp, file);
								doc.setFile(temp);
								doc.setNomeFile(fileName);
								String dataControllo = dettaglioAllegato.getDataControllo().replace("/", "_");
								if (contentType.equals("application/pkcs7-mime") || contentType.equals("application/x-pkcs7-mime")) {
									newName = "REEFIRMA_" + dettaglioAllegato.getCodiceImpianto() + "_" + dataControllo + "_" + dettaglioAllegato.getIdAllegato() + ".pdf.p7m";
								} else {
									newName = "REEFIRMA_" + dettaglioAllegato.getCodiceImpianto() + "_" + dataControllo + "_" + dettaglioAllegato.getIdAllegato() + ".pdf";
								}
								String uidFirmato = getServiceManager().caricaFileIndex(doc, Constants.INDEX_FOLDER_REE, newName, metadati);
								if (uidFirmato != null) {
									allegato.setUidIndexFirmato(uidFirmato);
									allegato.setNomeAllegatoFirmato(newName);
									allegato.setDataUltMod(new Timestamp(new Date().getTime()));
									allegato.setUtenteUltMod(cf);
									getDbServiceImp().aggiornaAllegato(allegato);

									esito.setEsito(Constants.OK);
								} else {
									throw new SigitextException("Errore nel caricamento del file.");
								}
							} else {
								throw new SigitextException("Allegato caricato non valido per il ree selezionato.");

							}
						} else {
							throw new SigitextException("Allegato non trovato.");

						}
					} else {
						throw new SigitextException("Formato file non valido. Caricare file .PDF o .P7M");

					}
				} else {
					throw new SigitextException("Errore nel recupero dell' impianto associato");

				}
			} else {
				throw new SigitextException("Errore nel recupero dell' allegato");

			}
			return esito;
		} catch (SigitextException e) {
			logger.error("[uploadReeFirmato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw e;
		} catch (Exception e) {
			logger.error("[uploadReeFirmato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new SigitextException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	@Transactional
	public Esito deleteControllo(Integer idAllegato, String ruolo, Integer idImpresa, String cf) throws SigitextException {
		Esito esito = new Esito();
		try {
			List<SigitTDocAllegatoDto> docList = getDbServiceImp().cercaElencoDocumentiPerIdAllegato(idAllegato);
			getDbServiceImp().eliminaAllegato(ConvertUtil.convertToBigDecimal(idAllegato), cf);
			getDbServiceImp().salvaLogEliminaAllegato(idAllegato.toString(), cf);
			for (SigitTDocAllegatoDto sigitTDocAllegatoDto : docList) {
				try {
					getServiceManager().indexDeleteContentByUid(sigitTDocAllegatoDto.getUidIndex());
				} catch (Exception ignored) {
				}
			}
			esito.setEsito(Constants.OK);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("[deleteControllo] errore cancellazione controllo:" + e, e);
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO, e);
		}
		return esito;
	}

	@Transactional
	public Esito updateControllo(Integer idAllegato, Integer codiceImpianto, String tipoControllo, byte[] xml, String tokenJWT) throws SigitextException {
		Esito esito = new Esito();
		try {
			Integer idAllegatoNew = null;
			if (idAllegato != null) {
				SigitTAllegatoDto allegatoDto = getServiceManager().getAllegatoByidAllegato(idAllegato);
				if (allegatoDto != null && allegatoDto.getFkStatoRapp() != null && allegatoDto.getFkStatoRapp().intValue() == Constants.ID_STATO_RAPPORTO_BOZZA) {
					Esito esito1 = deleteControllo(idAllegato, "", 0, "");
					if (esito1.getEsito().equals(Constants.KO_PG)) {
						throw new SigitextException("Errore aggiornamento controllo");
					}
				} else {
					throw new SigitextException("Impossibile modificare un allegato non in bozza");
				}
			}
			idAllegatoNew = uploadXMLControlloJWT(codiceImpianto, tipoControllo, xml, tokenJWT);
			logger.debug("id Allegato nuovo: " + idAllegatoNew);
			SigitTAllegatoDto allegatonew = getServiceManager().getAllegatoByidAllegato(idAllegatoNew);
			if (allegatonew != null) {
				allegatonew.setAbcdfControlloweb(DateUtil.getSqlDataCorrente());
				getDbServiceImp().getSigitTAllegatoDao().update(allegatonew);
			}
			TipoImportAllegatoEnum tipoImport = TipoImportAllegatoEnum.valueOfLabel(tipoControllo);
			switch (tipoImport) {
				case ALLEGATOII:
				case ALLEGATOIIB:
					List<SigitTDettTipo1Dto> dettTipo1List = getDbServiceImp().getDettTipo1(null, null, ConvertUtil.convertToString(idAllegatoNew));
					if (dettTipo1List != null && dettTipo1List.size() > 0) {
						for (SigitTDettTipo1Dto sigitTDettTipo1Dto : dettTipo1List) {
							sigitTDettTipo1Dto.setEControlloweb(DateUtil.getSqlDataCorrente());
							getDbServiceImp().getSigitTDettTipo1Dao().update(sigitTDettTipo1Dto);
						}
					}
					break;
				case ALLEGATOIII:
					List<SigitTDettTipo2Dto> dettTipo2List = getDbServiceImp().getDettTipo2(null, null, ConvertUtil.convertToString(idAllegatoNew));
					if (dettTipo2List != null && dettTipo2List.size() > 0) {
						for (SigitTDettTipo2Dto sigitTDettTipo2Dto : dettTipo2List) {
							sigitTDettTipo2Dto.setEControlloweb(DateUtil.getSqlDataCorrente());
							getDbServiceImp().getSigitTDettTipo2Dao().update(sigitTDettTipo2Dto);
						}
					}
					break;
				case ALLEGATOIV:
					List<SigitTDettTipo3Dto> dettTipo3List = getDbServiceImp().getDettTipo3(null, null, ConvertUtil.convertToString(idAllegatoNew));
					if (dettTipo3List != null && dettTipo3List.size() > 0) {
						for (SigitTDettTipo3Dto sigitTDettTipo3Dto : dettTipo3List) {
							sigitTDettTipo3Dto.setEControlloweb(DateUtil.getSqlDataCorrente());
							getDbServiceImp().getSigitTDettTipo3Dao().update(sigitTDettTipo3Dto);
						}
					}
					break;
				case ALLEGATOV:
					List<SigitTDettTipo4Dto> dettTipo4List = getDbServiceImp().getDettTipo4(null, null, ConvertUtil.convertToString(idAllegatoNew));
					if (dettTipo4List != null && dettTipo4List.size() > 0) {
						for (SigitTDettTipo4Dto sigitTDettTipo4Dto : dettTipo4List) {
							sigitTDettTipo4Dto.setEControlloweb(DateUtil.getSqlDataCorrente());
							getDbServiceImp().getSigitTDettTipo4Dao().update(sigitTDettTipo4Dto);
						}
					}
					break;
			}
			esito.setEsito(Constants.OK);
			esito.setIdAllegatoNew(idAllegatoNew);
			return esito;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("[updateControllo] errore cancellazione controllo:" + e, e);
			throw new SigitextException(e.getMessage(), e);
		}
	}

	public Esito inviaAllegato(Integer idAllegato, String ruolo, Integer idImpresa, String cf, Boolean cat) throws Exception {
		try {
			Esito esito = new Esito();
			// Ho centralizzato i controlli
			logger.debug(idAllegato);
			DettaglioAllegato dettaglio = getServiceManager().getDettaglioAllegatoById(idAllegato);
			getValidationManager().validazioneFormaleInviaAllegato(dettaglio, ruolo, idImpresa);
			SigitVRicercaAllegatiDto allegatoDto = getDbServiceImp().cercaSigitVRicercaAllegatiByIdAllegato(ConvertUtil.convertToString(dettaglio.getIdAllegato()));
			Integer idStatoRapp = ConvertUtil.convertToInteger(allegatoDto.getFkStatoRapp());
			String msg;
			if (Constants.ID_STATO_RAPPORTO_INVIATO == idStatoRapp || Constants.ID_STATO_RAPPORTO_RESPINTO == idStatoRapp) {
				throw new SigitextException("Controllo non nello stato bozza");
			} else {
				ResultInvioMail resultInvioMail = getServiceManager().getConnectorManager().inviaAllegatoTrans(dettaglio, cat != null && cat ? idImpresa : null, cf);
				msg = getServiceManager().getMsgInvioRee(dettaglio, allegatoDto, resultInvioMail);
			}
			esito.setEsito(Constants.OK);
			esito.setDescrizioneEsito(msg);
			return esito;
		} catch (ValidationManagerException e) {
			logger.error("[inviaAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new SigitextException(e.getMsg().getText());
		} catch (Exception e) {
			logger.error("[inviaAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new Exception("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	@Transactional
	public Esito consolidaLibrettoEsplicito(Integer codiceImpianto, Integer idPg, String descrizioneRuolo, String codiceRea, String cfUtenteMod) throws Exception {
		try {
			Esito esito = new Esito();
			serviceManager.consolidaLibretto(codiceImpianto, idPg, descrizioneRuolo, codiceRea, cfUtenteMod);
			esito.setEsito(Constants.OK);
			return esito;
		} catch (SigitextException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("[consolidaLibrettoEsplicito] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw e;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("[consolidaLibrettoEsplicito] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new Exception("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}
}
