/**
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 */
/**
 *
 */
package it.csi.sigit.sigitext.business.be.manager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.rpc.ServiceException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import it.csi.csi.wrapper.CSIException;
import it.csi.csi.wrapper.UnrecoverableException;
import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitLAccessoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CodiceReaAndFiscaleFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.FiltroRicercaPfPg;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.ImportFileSuper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.DettaglioGeograficoPortale;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.MvOdVistaDettaglioImpiantiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.PersonaGiuridica;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDAutodichiarazioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDRuoloDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDStatoImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDStatoIspezioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoCessazioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoDocDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitExtImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitLAccessoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompCgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompGfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompScDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRComp4ManutDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRContr2019AutodichiarDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRImpRuoloPfpgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRIspezIspetDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfPgDelegaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfPgDelegaFindByPfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfRuoloPaFindByPfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPgPgNominaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAbilitazioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAbilitazionePk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAccertamentoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAccertamentoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllegatoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzioneContrattoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTComp4Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTContratto2019Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTContratto2019Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTControlloLibrettoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo1Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo2Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo3Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo4Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAggiuntivaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAggiuntivaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAllegatoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAzioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAzionePk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocContrattoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocContrattoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTElencoWsDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTIspezione2018Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTIspezione2018Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLibrettoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaFisicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaFisicaJoinSigitRPfDelegaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaFisicaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaJoinSigitRPgPgNominaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTStoricoVarStatoPgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTTrattH2ODto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTTrattH2OPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTUnitaImmobiliareDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTVerificaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTVerificaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicercaImpiantiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitWrkConfigDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.UnitaImmobiliareDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.DaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDRuoloDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDStatoIspezioneDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRAllegatoCompCgDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRAllegatoCompGfDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRAllegatoCompGtDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRAllegatoCompScDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRComp4ManutDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRImpRuoloPfpgDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRPfPgDelegaDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRPfRuoloPaDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRPgPgNominaDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTAbilitazioneDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTAllegatoDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTAzioneDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTContratto2019DaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDocAggiuntivaDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDocAzioneDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDocContrattoDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTImpiantoDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTIspezione2018DaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTPersonaFisicaDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTPersonaGiuridicaDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTStoricoVarStatoPgDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTTrattH2ODaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTUnitaImmobiliareDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTVerificaDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.UnitaImmobiliareDaoException;
import it.csi.sigit.sigitext.business.pdf.LetteraAvvisoBuilder;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.ConstantsField;
import it.csi.sigit.sigitext.business.util.ConvertUtil;
import it.csi.sigit.sigitext.business.util.DateUtil;
import it.csi.sigit.sigitext.business.util.FieldError;
import it.csi.sigit.sigitext.business.util.GenericUtil;
import it.csi.sigit.sigitext.business.util.JWTUtil;
import it.csi.sigit.sigitext.business.util.MapDto;
import it.csi.sigit.sigitext.business.util.Message;
import it.csi.sigit.sigitext.business.util.Messages;
import it.csi.sigit.sigitext.business.util.exceptions.ValidationManagerException;
import it.csi.sigit.sigitext.business.util.mail.ResultInvioMail;
import it.csi.sigit.sigitext.dto.Assegnatario;
import it.csi.sigit.sigitext.dto.RicercaDatiVerifica;
import it.csi.sigit.sigitext.dto.sigitext.Accreditamento;
import it.csi.sigit.sigitext.dto.sigitext.Autodichiarazione;
import it.csi.sigit.sigitext.dto.sigitext.Azione;
import it.csi.sigit.sigitext.dto.sigitext.Categoria;
import it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione;
import it.csi.sigit.sigitext.dto.sigitext.Componente;
import it.csi.sigit.sigitext.dto.sigitext.ConsumoPodPdr;
import it.csi.sigit.sigitext.dto.sigitext.Controlli;
import it.csi.sigit.sigitext.dto.sigitext.Controllo;
import it.csi.sigit.sigitext.dto.sigitext.ControlloDisponibile;
import it.csi.sigit.sigitext.dto.sigitext.DatiAffidamento;
import it.csi.sigit.sigitext.dto.sigitext.DatiAggiuntivi;
import it.csi.sigit.sigitext.dto.sigitext.DatiCG;
import it.csi.sigit.sigitext.dto.sigitext.DatiContratto;
import it.csi.sigit.sigitext.dto.sigitext.DatiDelega;
import it.csi.sigit.sigitext.dto.sigitext.DatiDistributore;
import it.csi.sigit.sigitext.dto.sigitext.DatiGF;
import it.csi.sigit.sigitext.dto.sigitext.DatiGT;
import it.csi.sigit.sigitext.dto.sigitext.DatiImpianto;
import it.csi.sigit.sigitext.dto.sigitext.DatiImpresa;
import it.csi.sigit.sigitext.dto.sigitext.DatiIncarico;
import it.csi.sigit.sigitext.dto.sigitext.DatiIspezione;
import it.csi.sigit.sigitext.dto.sigitext.DatiSC;
import it.csi.sigit.sigitext.dto.sigitext.DatiToken;
import it.csi.sigit.sigitext.dto.sigitext.DettaglioAllegato;
import it.csi.sigit.sigitext.dto.sigitext.DettaglioPersonaGiuridica;
import it.csi.sigit.sigitext.dto.sigitext.DettaglioVerifica;
import it.csi.sigit.sigitext.dto.sigitext.DocumentiAggiuntiviImpianto;
import it.csi.sigit.sigitext.dto.sigitext.DocumentiAllegatiImpianto;
import it.csi.sigit.sigitext.dto.sigitext.DocumentiAssociatiContratto;
import it.csi.sigit.sigitext.dto.sigitext.DocumentiAzioni;
import it.csi.sigit.sigitext.dto.sigitext.Documento;
import it.csi.sigit.sigitext.dto.sigitext.DocumentoPwa;
import it.csi.sigit.sigitext.dto.sigitext.Esito;
import it.csi.sigit.sigitext.dto.sigitext.Impianto;
import it.csi.sigit.sigitext.dto.sigitext.ImpiantoFiltro;
import it.csi.sigit.sigitext.dto.sigitext.IncarichiSoggettiDelegatiResponse;
import it.csi.sigit.sigitext.dto.sigitext.JWTDto;
import it.csi.sigit.sigitext.dto.sigitext.Libretto;
import it.csi.sigit.sigitext.dto.sigitext.ListaImpiantiGeo;
import it.csi.sigit.sigitext.dto.sigitext.Metadati;
import it.csi.sigit.sigitext.dto.sigitext.PFLoggato;
import it.csi.sigit.sigitext.dto.sigitext.PdfControllo;
import it.csi.sigit.sigitext.dto.sigitext.Persona;
import it.csi.sigit.sigitext.dto.sigitext.RequestTerzoResponsabile;
import it.csi.sigit.sigitext.dto.sigitext.RespPropModel;
import it.csi.sigit.sigitext.dto.sigitext.Responsabile;
import it.csi.sigit.sigitext.dto.sigitext.ResponseGetDettaglioNomina;
import it.csi.sigit.sigitext.dto.sigitext.ResponseGetElencoDocumenti;
import it.csi.sigit.sigitext.dto.sigitext.RisultatoRicResponsabile;
import it.csi.sigit.sigitext.dto.sigitext.Ruoli;
import it.csi.sigit.sigitext.dto.sigitext.RuoloPA;
import it.csi.sigit.sigitext.dto.sigitext.RuoloPF;
import it.csi.sigit.sigitext.dto.sigitext.RuoloPG;
import it.csi.sigit.sigitext.dto.sigitext.Scheda1;
import it.csi.sigit.sigitext.dto.sigitext.Scheda2;
import it.csi.sigit.sigitext.dto.sigitext.SubentroComponente;
import it.csi.sigit.sigitext.dto.sigitext.TipoImportAllegatoEnum;
import it.csi.sigit.sigitext.dto.sigitext.UtenteJWT;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggatoModel;
import it.csi.sigit.sigitext.dto.sigitext.Verifica;
import it.csi.sigit.sigitext.dto.sigitext.VerificaMassiva;
import it.csi.sigit.sigitext.enums.JWTUserEnum;
import it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException;
import it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import it.csi.sigit.sigitext.mapper.DatiIspezioneMapper;
import it.doqui.index.ecmengine.client.webservices.dto.OperationContext;
import it.doqui.index.ecmengine.client.webservices.dto.engine.search.ResultContent;

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
	private static final String ALTRA_DOCUMENTAZIONE = "Altra documentazione";
	private static final String END_WITH_ERROR = " - END WITH ERROR";		

	public SigitextManager() {
	}

	private ServiceManager serviceManager;
	private DbServiceImp dbServiceImp;
	private ValidationManager validationManager;
	private LetteraAvvisoBuilder letteraAvvisoBuilderService;
	private DbAzioneMgr dbAzioneMgr;
	private DbVerificaMgr dbVerificaMgr;
	private DbIspezioneMgr dbIspezioneMgr;
	
		
	public DbIspezioneMgr getDbIspezioneMgr() {
		return dbIspezioneMgr;
	}

	public void setDbIspezioneMgr(DbIspezioneMgr dbIspezioneMgr) {
		this.dbIspezioneMgr = dbIspezioneMgr;
	}

	public DbVerificaMgr getDbVerificaMgr() {
		return dbVerificaMgr;
	}

	public void setDbVerificaMgr(DbVerificaMgr dbVerificaMgr) {
		this.dbVerificaMgr = dbVerificaMgr;
	}

	public DbAzioneMgr getDbAzioneMgr() {
		return dbAzioneMgr;
	}

	public void setDbAzioneMgr(DbAzioneMgr dbAzioneMgr) {
		this.dbAzioneMgr = dbAzioneMgr;
	}

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

	public LetteraAvvisoBuilder getLetteraAvvisoBuilderService() {
		return letteraAvvisoBuilderService;
	}

	public void setLetteraAvvisoBuilderService(LetteraAvvisoBuilder letteraAvvisoBuilderService) {
		this.letteraAvvisoBuilderService = letteraAvvisoBuilderService;
	}

	private SigitLAccessoDao getSigitLAccessoDao() {
		return (SigitLAccessoDao) SpringApplicationContextHelper.getBean("sigitLAccessoDao");
	}

	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getFluidoCIT(

	) throws it.csi.csi.wrapper.CSIException {
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
				logger.error("[SigitextImpl::getFluidoCIT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error("[SigitextImpl::getFluidoCIT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
						+ ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getFluidoCIT()", "invocazione servizio [sigitext]::[getFluidoCIT]",
					"(valore input omesso)");
			logger.debug("[SigitextImpl::getFluidoCIT] - END");
		}
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByCodiceJWT(

			java.lang.Integer codiceImpianto,

			java.lang.String tokenJWT

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

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
				logger.error(
						"[SigitextImpl::getImpiantoByCodiceJWT] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getImpiantoByCodiceJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getImpiantoByCodiceJWT()",
					"invocazione servizio [sigitext]::[getImpiantoByCodiceJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getImpiantoByCodiceJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantiByFiltroJWT(

			it.csi.sigit.sigitext.dto.sigitext.ImpiantoFiltro impiantoFiltro,

			java.lang.String tokenJWT

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException,
			it.csi.sigit.sigitext.exception.sigitext.SigitextException,
			it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException {
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
				logger.error(
						"[SigitextImpl::getImpiantiByFiltroJWT] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getImpiantiByFiltroJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getImpiantiByFiltroJWT()",
					"invocazione servizio [sigitext]::[getImpiantiByFiltroJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getImpiantiByFiltroJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.ListaImpiantiGeo getImpiantiGeoByFiltroJWT(

			it.csi.sigit.sigitext.dto.sigitext.ImpiantoFiltro impiantoFiltro,

			java.lang.String tokenJWT

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException {
		logger.debug("[SigitextImpl::getImpiantiGeoByFiltroJWT] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_GET_IMPIANTI_BY_FILTRO;

			// UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT,
			// idFunzionalita);

			ListaImpiantiGeo listImpiantiGeo = null;

			// if (utenteJWT != null) {
			logger.debug(impiantoFiltro);
			listImpiantiGeo = getServiceManager().ricercaImpiantoGeoByFiltro(impiantoFiltro);
			logger.debug("LIST IMPIANTI: " + Arrays.toString(listImpiantiGeo.getImpianti()));

			// } else {
			// throw new SigitUserNotAuthorizedException("Utente non autorizzato
			// all'utilizzo del servizio");
			// }

			// getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);

			return listImpiantiGeo;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[SigitextImpl::getImpiantiGeoByFiltroJWT] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getImpiantiGeoByFiltroJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getImpiantiGeoByFiltroJWT()",
					"invocazione servizio [sigitext]::[getImpiantiGeoByFiltroJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getImpiantiGeoByFiltroJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.ListaImpiantiGeo getImpiantiGeoByFiltroDuplicatiResponsabileJWT(

			it.csi.sigit.sigitext.dto.sigitext.ImpiantoFiltro impiantoFiltro,

			java.lang.String tokenJWT

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException {
		logger.debug("[SigitextImpl::getImpiantiGeoByFiltroJWT] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_GET_IMPIANTI_BY_FILTRO;

			// UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT,
			// idFunzionalita);

			ListaImpiantiGeo listImpiantiGeo = null;

			// if (utenteJWT != null) {
			logger.debug(impiantoFiltro);
			listImpiantiGeo = getServiceManager().ricercaImpiantoGeoByFiltroDuplicatiResponsabile(impiantoFiltro);
			logger.debug("LIST IMPIANTI: " + Arrays.toString(listImpiantiGeo.getImpianti()));

			// } else {
			// throw new SigitUserNotAuthorizedException("Utente non autorizzato
			// all'utilizzo del servizio");
			// }

			// getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);

			return listImpiantiGeo;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[SigitextImpl::getImpiantiGeoByFiltroJWT] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getImpiantiGeoByFiltroJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getImpiantiGeoByFiltroJWT()",
					"invocazione servizio [sigitext]::[getImpiantiGeoByFiltroJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getImpiantiGeoByFiltroJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByPODJWT(java.lang.String pod,
			java.lang.String tokenJWT) throws it.csi.csi.wrapper.CSIException,
			it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException,
			it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException,
			it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException {
		logger.debug("[SigitextImpl::getImpiantoByPODJWT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_CERCA_IMPIANTO_BY_POD;
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);
			Impianto[] listImpianti = null;
			ArrayList<Impianto> listImpiantiTmp = new ArrayList<>();

			if (utenteJWT != null) {
				listImpianti = getServiceManager().getImpiantoByPod(pod);

				if (listImpianti != null && listImpianti.length > 0) {
					for (Impianto impianto : listImpianti) {
						if (getServiceManager().isAbilitatoSuImpianto(impianto.getCodiceImpianto(), utenteJWT)) {

							// Compongo la lista degli impianti su cui l'utente e' abilitato
							listImpiantiTmp.add(impianto);
						}
					}

					if (listImpiantiTmp != null && !listImpiantiTmp.isEmpty()) {
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
				logger.error("[SigitextImpl::getImpiantoByPODJWT] - Errore CSI occorso durante l'esecuzione del metodo:"
						+ ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getImpiantoByPODJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getImpiantoByPODJWT()",
					"invocazione servizio [sigitext]::[getImpiantoByPODJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getImpiantoByPODJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByPODJWTOld(java.lang.String pod,
			java.lang.String tokenJWT) throws it.csi.csi.wrapper.CSIException,
			it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException,
			it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException,
			it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException {
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
				logger.error("[SigitextImpl::getImpiantoByPODJWT] - Errore CSI occorso durante l'esecuzione del metodo:"
						+ ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getImpiantoByPODJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getImpiantoByPODJWT()",
					"invocazione servizio [sigitext]::[getImpiantoByPODJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getImpiantoByPODJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByPDRJWT(

			java.lang.String pdr,

			java.lang.String tokenJWT

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException

			, it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException {
		logger.debug("[SigitextImpl::getImpiantoByPDRJWT] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_CERCA_IMPIANTO_BY_PDR;
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);
			Impianto[] listImpianti = null;
			ArrayList<Impianto> listImpiantiTmp = new ArrayList<>();

			if (utenteJWT != null) {

				listImpianti = getServiceManager().getImpiantoByPdr(pdr);

				if (listImpianti != null && listImpianti.length > 0) {
					for (Impianto impianto : listImpianti) {
						if (getServiceManager().isAbilitatoSuImpianto(impianto.getCodiceImpianto(), utenteJWT)) {

							// Compongo la lista degli impianti su cui l'utente e' abilitato
							listImpiantiTmp.add(impianto);
						}
					}

					if (listImpiantiTmp != null && !listImpiantiTmp.isEmpty()) {
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
				logger.error("[SigitextImpl::getImpiantoByPDRJWT] - Errore CSI occorso durante l'esecuzione del metodo:"
						+ ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getImpiantoByPDRJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getImpiantoByPDRJWT()",
					"invocazione servizio [sigitext]::[getImpiantoByPDRJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getImpiantoByPDRJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByPDRJWTOld(

			java.lang.String pdr,

			java.lang.String tokenJWT

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException

			, it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException {
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
				logger.error("[SigitextImpl::getImpiantoByPDRJWT] - Errore CSI occorso durante l'esecuzione del metodo:"
						+ ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getImpiantoByPDRJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getImpiantoByPDRJWT()",
					"invocazione servizio [sigitext]::[getImpiantoByPDRJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getImpiantoByPDRJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Documento getLibrettoByUIDJWT(

			java.lang.String uid,

			java.lang.String tokenJWT

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

			, SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException {
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
				logger.error("[SigitextImpl::getLibrettoByUIDJWT] - Errore CSI occorso durante l'esecuzione del metodo:"
						+ ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getLibrettoByUIDJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getLibrettoByUIDJWT()",
					"invocazione servizio [sigitext]::[getLibrettoByUIDJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getLibrettoByUIDJWT] - END");
		}
	}

	public SigitTLibrettoDto getLibrettoDtoByUIDJWT(

			java.lang.String uid

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

			, SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException {
		logger.debug("[SigitextImpl::getLibrettoDtoByUIDJWT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {

			return getServiceManager().getLibrettoDtoByUid(uid);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[SigitextImpl::getLibrettoDtoByUIDJWT] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getLibrettoDtoByUIDJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getLibrettoDtoByUIDJWT()",
					"invocazione servizio [sigitext]::[getLibrettoDtoByUIDJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getLibrettoDtoByUIDJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Documento getXMLLibrettoNowJWT(

			java.lang.Integer codiceImpianto,

			java.lang.Boolean isConsolidato,

			java.lang.String tokenJWT

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException {
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
				logger.error(
						"[SigitextImpl::getXMLLibrettoNowJWT] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getXMLLibrettoNowJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getXMLLibrettoNowJWT()",
					"invocazione servizio [sigitext]::[getXMLLibrettoNowJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getXMLLibrettoNowJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getCombustibileCIT(

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException {
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
				logger.error(
						"[SigitextImpl::getCombustibileCIT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getCombustibileCIT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getCombustibileCIT()",
					"invocazione servizio [sigitext]::[getCombustibileCIT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getCombustibileCIT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getClassDpr66096CIT(

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException {
		logger.debug("[SigitextImpl::getClassDpr66096CIT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			CodiceDescrizione[] lista = null;
			lista = getServiceManager().getListaClassDpr66096CIT();
			return lista;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[SigitextImpl::getClassDpr66096CIT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getClassDpr66096CIT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getClassDpr66096CIT()",
					"invocazione servizio [sigitext]::[getClassDpr66096CIT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getClassDpr66096CIT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getFrequenzaManutCIT(

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException {
		logger.debug("[SigitextImpl::getFrequenzaManutCIT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			CodiceDescrizione[] lista = null;
			lista = getServiceManager().getListaFrequenzaManutCIT();
			return lista;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[SigitextImpl::getFrequenzaManutCIT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getFrequenzaManutCIT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getFrequenzaManutCIT()",
					"invocazione servizio [sigitext]::[getFrequenzaManutCIT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getFrequenzaManutCIT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getMarcaCIT(

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException {
		logger.debug("[SigitextImpl::getMarcaCIT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			CodiceDescrizione[] lista = getServiceManager().getListaMarcaCIT();
			return lista;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getMarcaCIT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getMarcaCIT] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getMarcaCIT()", "invocazione servizio [sigitext]::[getMarcaCIT]",
					"(valore input omesso)");
			logger.debug("[SigitextImpl::getMarcaCIT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getUnitaMisuraCIT(

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException {
		logger.debug("[SigitextImpl::getUnitaMisuraCIT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			CodiceDescrizione[] lista = getServiceManager().getListaUnitaMisuraCIT();
			return lista;
			/* PROTECTED REGION END */
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[SigitextImpl::getUnitaMisuraCIT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getUnitaMisuraCIT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getUnitaMisuraCIT()",
					"invocazione servizio [sigitext]::[getUnitaMisuraCIT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getUnitaMisuraCIT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Libretto getLibrettoNowJWT(

			java.lang.Integer codiceImpianto,

			java.lang.Boolean isConsolidato,

			java.lang.String tokenJWT

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException {
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
			ex.printStackTrace();
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[SigitextImpl::getLibrettoNowJWT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getLibrettoNowJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getLibrettoNowJWT()",
					"invocazione servizio [sigitext]::[getLibrettoNowJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getLibrettoNowJWT] - END");
		}
	}

	public Scheda1 getSchedaLibrettoJWT(

			java.lang.Integer codiceImpianto,

			java.lang.String tokenJWT

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException {
		logger.debug("[SigitextImpl::getSchedaLibrettoJWT] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			int idFunzionalita = Constants.ID_FUNZ_GET_LIBRETTO_NOW;
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);
			Scheda1 libretto = null;
			if (utenteJWT != null) {
				if (!getServiceManager().isAbilitatoSuImpianto(codiceImpianto, utenteJWT)) {
					throw new SigitextException(Messages.ERROR_IMPRESA_NON_ABILITATA_SU_IMPIANTO);
				}

				logger.debug("[SigitextImpl::getSchedaLibrettoJWT] ###########################");
				logger.debug("[SigitextImpl::getSchedaLibrettoJWT] - codiceImpianto: " + codiceImpianto);
				logger.debug("[SigitextImpl::getSchedaLibrettoJWT] ###########################");

				libretto = getServiceManager().getSchedaLibretto(codiceImpianto);
			} else {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}

			getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);

			return libretto;

		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[SigitextImpl::getSchedaLibrettoJWT] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getSchedaLibrettoJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getSchedaLibrettoJWT()",
					"invocazione servizio [sigitext]::[getSchedaLibrettoJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getSchedaLibrettoJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Documento getXMLLibrettoConsolidatoJWT(java.lang.Integer codiceImpianto,
			java.lang.String tokenJWT) throws it.csi.csi.wrapper.CSIException,
			it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException,
			it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException {
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
				logger.error(
						"[SigitextImpl::getXMLLibrettoConsolidatoJWT] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getXMLLibrettoConsolidatoJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getXMLLibrettoConsolidatoJWT()",
					"invocazione servizio [sigitext]::[getXMLLibrettoConsolidatoJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getXMLLibrettoConsolidatoJWT] - END");
		}
	}

	public void uploadXMLLibrettoJWT(java.lang.Integer codiceImpianto, byte[] xml, java.lang.String tokenJWT)
			throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException,
			it.csi.sigit.sigitext.exception.sigitext.SigitextException,
			it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException {
		logger.debug("[SigitextImpl::uploadXMLLibrettoJWT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			/* PROTECTED REGION ID(R-1759379489) ENABLED START */
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
				if (ex.getMessage().equals(Messages.ERROR_LIBRETTO_IMPIANTO_PRESENTE)
						|| ex.getMessage().contains(Messages.S137.replace(" ##value##", "")))
					logger.info(
							"[SigitextImpl::uploadXMLLibrettoJWT] - Errore CSI occorso durante l'esecuzione del metodo:"
									+ ex,
							ex);
				else
					logger.error(
							"[SigitextImpl::uploadXMLLibrettoJWT] - Errore CSI occorso durante l'esecuzione del metodo:"
									+ ex,
							ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::uploadXMLLibrettoJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "uploadXMLLibrettoJWT()",
					"invocazione servizio [sigitext]::[uploadXMLLibrettoJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::uploadXMLLibrettoJWT] - END");
		}
	}

	public int uploadXMLControlloJWT(

			java.lang.Integer codiceImpianto,

			java.lang.String tipoControllo,

			byte[] xml,

			java.lang.String tokenJWT

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException {
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
			logger.error(
					"[SigitextImpl::uploadXMLControlloJWT] - Errore CSI occorso durante l'esecuzione del metodo:" + e,
					e);
			throw e;
		} catch (Exception ex) {
			logger.error(
					"[SigitextImpl::uploadXMLControlloJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex,
					ex);
			throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "uploadXMLControlloJWT()",
					"invocazione servizio [sigitext]::[uploadXMLControlloJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::uploadXMLControlloJWT] - END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByIndirizzoJWT(

			java.lang.String indirizzo,

			java.lang.Integer civico,

			java.lang.String istat,

			java.lang.String tokenJWT

	) throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.UnrecoverableException

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException {
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
				logger.error(
						"[SigitextImpl::getImpiantoByIndirizzoJWT] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getImpiantoByIndirizzoJWT] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getImpiantoByIndirizzoJWT()",
					"invocazione servizio [sigitext]::[getImpiantoByIndirizzoJWT]", "(valore input omesso)");
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
			} else if (personaF.getFlgAccreditato() == null
					|| (personaF.getFlgAccreditato() != null && !personaF.getFlgAccreditato().equals("A"))) {
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
				logger.error(
						"[SigitextImpl::getRuoli] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getRuoli()", "invocazione servizio [sigitext]::[getRuoli]",
					"(valore input omesso)");
			logger.debug("[SigitextImpl::getRuoli] - END");
		}
	}

	public Ruoli getRuoliDistributore(String codiceFiscale, String cognome, String nome) throws CSIException {

		logger.debug("[SigitextImpl::getRuoliDistributore] - START");
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
			} else if (personaF.getFlgAccreditato() == null
					|| (personaF.getFlgAccreditato() != null && !personaF.getFlgAccreditato().equals("A"))) {
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
			ruoli.setRuoliPA(fillRuoliPADistributori(personaF));
			ruoli.setRuoliPG(fillRuoliPgDistributori(personaF));
			return ruoli;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::getRuoliDistributore] - Errore CSI occorso durante l'esecuzione del metodo:" + ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getRuoliDistributore] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getRuoliDistributore()", "invocazione servizio [sigitext]::[getRuoliDistributore]",
					"(valore input omesso)");
			logger.debug("[SigitextImpl::getRuoliDistributore] - END");
		}
	}

	private RuoloPG[] fillRuoliPg(SigitTPersonaFisicaDto dto) throws SigitextException {
		List<RuoloPG> ruoliPG = new ArrayList<>();
		List<SigitRPfPgDelegaFindByPfDto> ruoliPgList = getServiceManager().findRuoliPgByPf(dto);

		for (SigitRPfPgDelegaFindByPfDto dto2 : ruoliPgList) {
			if (GenericUtil.isNotNullOrEmpty(dto2.getPgFlgDm37Letterac())
					&& dto2.getPgFlgDm37Letterac().intValue() == 1) {
				ruoliPG.add(creaRuoloPg(dto2, Constants.RUOLO_IMPRESA));
			}

			// Controllo se e' un amministratore
			if ((GenericUtil.isNotNullOrEmpty(dto2.getPgFlgAmministratore())
					&& dto2.getPgFlgAmministratore().intValue() == 1)
					|| ((GenericUtil.isNotNullOrEmpty(dto2.getPgFlgSoggIncaricato())
							&& dto2.getPgFlgSoggIncaricato().intValue() == 1))) {
				ruoliPG.add(creaRuoloPg(dto2, Constants.RUOLO_RESPONSABILE_IMPRESA));
				ruoliPG.add(creaRuoloPg(dto2, Constants.RUOLO_PROPRIETARIO_IMPRESA));
			}

			// Controllo se e' un terzo responsabile
			if (GenericUtil.isNotNullOrEmpty(dto2.getPgFlgTerzoResponsabile())
					&& dto2.getPgFlgTerzoResponsabile().intValue() == 1) {
				ruoliPG.add(creaRuoloPg(dto2, Constants.RUOLO_3RESPONSABILE));
			}

			// Controllo se e' un distributore
			if (GenericUtil.isNotNullOrEmpty(dto2.getPgFlgDistributore())
					&& dto2.getPgFlgDistributore().intValue() == 1) {
				ruoliPG.add(creaRuoloPg(dto2, Constants.RUOLO_DISTRIBUTORE));
			}

			// Controllo se e' un CAT
			if (GenericUtil.isNotNullOrEmpty(dto2.getPgFlgCat()) && dto2.getPgFlgCat().intValue() == 1) {
				ruoliPG.add(creaRuoloPg(dto2, Constants.RUOLO_CAT));
			}
		}

		for (SigitRPfPgDelegaFindByPfDto dto2 : ruoliPgList) {
			if (GenericUtil.isNotNullOrEmpty(dto2.getPgFlgCat()) && dto2.getPgFlgCat().intValue() == 1) {
				List<SigitRPgPgNominaDto> elencoPgImp = getServiceManager()
						.cercaSigitRPgPgIncaricoAttByIdPersonaGiuridicaCat(dto2.getPgIdPersonaGiuridica());
				for (SigitRPgPgNominaDto sigitRPgPgNominaDto : elencoPgImp) {
					PersonaGiuridica persGiuridicaImp = getServiceManager().cercaPersonaGiuridicaById(
							ConvertUtil.convertToInteger(sigitRPgPgNominaDto.getIdPersonaGiuridicaImpresa()));

					// Controllo se e' un impresa
					if (GenericUtil.isNotNullOrEmpty(persGiuridicaImp.getFlgDm37Letterac())
							&& persGiuridicaImp.getFlgDm37Letterac().intValue() == 1) {
						ruoliPG.add(creaRuoloPg(persGiuridicaImp, Constants.CAT_RUOLO_IMPRESA));
					}

					// Controllo se e' un amministratore
					if (GenericUtil.isNotNullOrEmpty(persGiuridicaImp.getFlgAmministratore())
							&& persGiuridicaImp.getFlgAmministratore().intValue() == 1) {
						ruoliPG.add(creaRuoloPg(persGiuridicaImp, Constants.CAT_RUOLO_RESPONSABILE_IMPRESA));
					}

					// Controllo se e' un terzo responsabile
					if (GenericUtil.isNotNullOrEmpty(persGiuridicaImp.getFlgTerzoResponsabile())
							&& persGiuridicaImp.getFlgTerzoResponsabile().intValue() == 1) {
						ruoliPG.add(creaRuoloPg(persGiuridicaImp, Constants.CAT_RUOLO_3RESPONSABILE));
					}

					// Controllo se e' un distributore
					if (GenericUtil.isNotNullOrEmpty(persGiuridicaImp.getFlgDistributore())
							&& persGiuridicaImp.getFlgDistributore().intValue() == 1) {
						ruoliPG.add(creaRuoloPg(persGiuridicaImp, Constants.CAT_RUOLO_DISTRIBUTORE));
					}

				}

			}

		}

		logger.debug("Ruoli pg recuperati per pf " + dto.getIdPersonaFisica() + " : " + ruoliPG);
		return ruoliPG.toArray(new RuoloPG[0]);
	}

	private RuoloPG[] fillRuoliPgDistributori(SigitTPersonaFisicaDto dto) throws SigitextException {
		List<RuoloPG> ruoliPG = new ArrayList<>();
		List<SigitRPfPgDelegaFindByPfDto> ruoliPgList = getServiceManager().findRuoliPgByPf(dto);

		for (SigitRPfPgDelegaFindByPfDto dto2 : ruoliPgList) {

			// Controllo se e' un distributore
			if (GenericUtil.isNotNullOrEmpty(dto2.getPgFlgDistributore())
					&& dto2.getPgFlgDistributore().intValue() == 1) {
				ruoliPG.add(creaRuoloPg(dto2, Constants.RUOLO_DISTRIBUTORE));
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
				logger.error("[SigitextImpl::setAccesso] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::setAccesso] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getRuoli()", "invocazione servizio [sigitext]::[getRuoli]",
					"(valore input omesso)");
			logger.debug("[SigitextImpl::getRuoli] - END");
		}
	}

	public void getDisponibilitaServizio(String servizio, String codiceFiscale) throws CSIException {

		logger.debug("[SigitextImpl::getDisponibilitaServizio] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		// inizio misurazione
		watcher.start();
		try {
			String chiaveServizio = servizio + "_SERVIZIO_ATTIVO";
			Boolean isServizioAttivo = getServiceManager().cercaConfigValueBooleano(chiaveServizio);
			if (!isServizioAttivo) {
				Boolean isUtenteAutorizzato = getServiceManager().checkUtenteAutorizzato(codiceFiscale);
				if (!isUtenteAutorizzato) {
					throw new CSIException(Messages.ERROR_SERVIZIO_NON_DISPONIBILE);
				}
			}

		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[SigitextImpl::getDisponibilitaServizio] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getDisponibilitaServizio] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getDisponibilitaServizio()",
					"invocazione servizio [sigitext]::[getDisponibilitaServizio]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getDisponibilitaServizio] - END");
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
		ruoloPG.setIdPersonaGiuridica(
				dto2.getPgIdPersonaGiuridica() != null ? dto2.getPgIdPersonaGiuridica().intValue() : null);
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
		ruoloPG.setIdPersonaGiuridica(
				dto2.getIdPersonaGiuridica() != null ? dto2.getIdPersonaGiuridica().intValue() : null);
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

	public RuoloPA[] fillRuoliPADistributori(SigitTPersonaFisicaDto dto) throws SigitextException {
		List<RuoloPA> ruoliPA = new ArrayList<>();
		List<SigitRPfRuoloPaFindByPfDto> ruolipaList = getServiceManager().findRuoliPAByPf(dto);
		for (SigitRPfRuoloPaFindByPfDto dto2 : ruolipaList) {
			if (dto2.getDRuoloPaDesRuoloPa().equals(Constants.RUOLO_SUPER) 
					|| (dto2.getDRuoloPaDesRuoloPa().equals(Constants.RUOLO_CONSULTATORE) 
							&& dto2.getRPfRuoloPaIstatAbilitazione().equals(Constants.COD_ISTAT_PIEMONTE)) ) {
				RuoloPA ruoloPA = new RuoloPA();
				ruoloPA.setRuoloPA(dto2.getDRuoloPaDesRuoloPa());
				ruoloPA.setIdRuoloPA(dto2.getRPfRuoloPaIdRuoloPa());
				ruoloPA.setIstatAbilitazione(dto2.getRPfRuoloPaIstatAbilitazione());
				ruoloPA.setDescrAbilitazione(dto2.getRPfRuoloPaDescAbilitazione());
				ruoliPA.add(ruoloPA);
			}
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
				codiceDescrizioneArray[count]
						.setCodice(stato.getIdStato() != null ? stato.getIdStato().toString() : "");
				codiceDescrizioneArray[count].setDescrizione(stato.getDesStato());
				count++;
			}
			return codiceDescrizioneArray;
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[SigitextImpl::setAccesso] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::setAccesso] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getStatoImpianto()",
					"invocazione servizio [sigitext]::[getStatoImpianto]", "(valore input omesso)");
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
				logger.error("[SigitextImpl::getStelle] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getStelle] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getStelle()", "invocazione servizio [sigitext]::[getStelle]",
					"(valore input omesso)");
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
				logger.error(
						"[SigitextImpl::getApparecchiature] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getApparecchiature] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getApparecchiature()",
					"invocazione servizio [sigitext]::[getApparecchiature]", "(valore input omesso)");
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
				logger.error(
						"[SigitextImpl::getControlloAria] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getControlloAria] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getControlloAria()",
					"invocazione servizio [sigitext]::[getControlloAria]", "(valore input omesso)");
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
				logger.error(
						"[SigitextImpl::getAriaComburente] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[SigitextImpl::getAriaComburente] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getAriaComburente()",
					"invocazione servizio [sigitext]::[getAriaComburente]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getAriaComburente] - END");
		}
	}

	public Esito salvaImpianto(UtenteLoggato utenteLoggato, DatiImpianto datiImpianto, Integer responsabilita)
			throws SigitextException {
		try {

			String ruoloUtente = utenteLoggato.getRuoloLoggato().getRuolo();

			if (GenericUtil.isNotNullOrEmpty(datiImpianto.getCodiceImpianto())) {
				getValidationManager().verificaCodiceImpiantoIdentificazione(datiImpianto.getCodiceImpianto());
			}
			String codiceImpianto = getServiceManager().salvaImpiantoTrans(datiImpianto, ruoloUtente, utenteLoggato,
					responsabilita);
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

	public Esito updateImpianto(UtenteLoggato utenteLoggato, DatiImpianto datiImpianto)
			throws SigitextException, ValidationManagerException {
		try {

			String ruoloUtente = utenteLoggato.getRuoloLoggato().getRuolo();
			getValidationManager().validazioneFormaleSalvaImpianto(datiImpianto, ruoloUtente);

			if (!(ruoloUtente.equalsIgnoreCase(Constants.RUOLO_SUPER)
					|| ruoloUtente.equalsIgnoreCase(Constants.RUOLO_VALIDATORE)
					|| ruoloUtente.equalsIgnoreCase(Constants.RUOLO_ISPETTORE))) {
				getValidationManager().verificaModificaUbicazioneImpiantoIdentificazione(datiImpianto);
			}
			SigitVRicercaImpiantiDto oldImpianto = dbServiceImp
					.cercaImpiantoByCodImpianto(ConvertUtil.convertToBigDecimal(datiImpianto.getCodiceImpianto()));
			datiImpianto = getDbServiceImp().updateImpianto(datiImpianto, ruoloUtente, utenteLoggato);

			Esito esito = new Esito();
			esito.setEsito("OK");
			esito.setCodiceImpianto(datiImpianto.getCodiceImpianto());
			Documento doc = getServiceManager().getXMLLibretto(Integer.parseInt(datiImpianto.getCodiceImpianto()),
					false);
			if (doc != null)
				esito.setXmlLibretto(doc.getDoc());
			ImpiantoFiltro filtro = new ImpiantoFiltro();
			filtro.setPod(datiImpianto.getPod());
			filtro.setFkStato(Constants.ID_STATO_IMPRESA_ATTIVA);
			List<SigitExtImpiantoDto> podAttivi = dbServiceImp.ricercaImpiantoByFiltro(filtro);
			if (podAttivi != null && 
				!podAttivi.isEmpty() && 
				oldImpianto.getPodElettrico() != null && 
				datiImpianto.getPod() != null) {
				if (!oldImpianto.getPodElettrico().equals(datiImpianto.getPod())) {
					if (checkPODPDRPresenti(datiImpianto.getCodiceImpianto(), podAttivi)) {
						esito.setDescrizioneEsito("Codice POD inserito gia' presente sul sistema");
					}
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

	public Persona[] getRespProp(Integer tipo, String cf, String siglaRea, String numeroRea)
			throws SigitextException, ValidationManagerException {
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
					personaGiutidicaDto = getDbServiceImp().getSigitTPersonaGiuridicaDao()
							.findByCodiceReaAndFiscale(filter);
				}
				if (personaGiutidicaDto != null) {
					for (SigitTPersonaGiuridicaDto tPersonaGiutidicaDto : personaGiutidicaDto) {
						Persona personaRecuperata = MapDto.mapPersonaGiuridica(tPersonaGiutidicaDto, "1", tipo);
						List<SigitRPfPgDelegaDto> deleghePg = getDbServiceImp().getSigitRPfPgDelegaDao().findFindByPg(
								ConvertUtil.convertToInteger(tPersonaGiutidicaDto.getIdPersonaGiuridica()));
						if (deleghePg != null && !deleghePg.isEmpty()) {
							personaRecuperata.setAccreditato(Constants.FLG_ACCREDITATO);
						}
						persona.add(personaRecuperata);
					}
				}
			} else {
				List<SigitTPersonaFisicaDto> personaFisicaList = getDbServiceImp().getSigitTPersonaFisicaDao()
						.findByCodiceFiscale(cf);
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
						filter.addIdRuoloList(
								Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO);
						filter.addIdRuoloList(
								Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE);
						filter.addIdRuoloList(
								Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE);
						filter.setIdPersonaGiuridica(BigDecimal.valueOf(responsabile.getIdResponsabile()));
					} else {
						filter.addIdRuoloList(Constants.ID_RUOLO_PROPRIETARIO);
						filter.addIdRuoloList(Constants.ID_RUOLO_OCCUPANTE);
						filter.addIdRuoloList(Constants.ID_RUOLO_AMMINISTRATORE);
						filter.setIdPersonaFisica(BigDecimal.valueOf(responsabile.getIdResponsabile()));
					}
					List<SigitRImpRuoloPfpgDto> proprietariList = getDbServiceImp().getSigitRImpRuoloPfpgDao()
							.findAttiviByFilter(filter);
					if (proprietariList != null && proprietariList.size() != 0) {
						responsabile.setIdImpResp(proprietariList.get(0).getIdImpRuoloPfpg().intValue());
					}
				}

				// Queste verifiche non le devo fare se sto inserendo un proprietario
				// (esplicito)
				ArrayList<RisultatoRicResponsabile> responsabiliList = getServiceManager()
						.cercaResponsabiliByIdImpianto(ConvertUtil.convertToInteger(model.getCodiceImpianto()));
				getValidationManager().verificaDateResponsabile(responsabile, responsabiliList,
						model.getCodiceImpianto());
			}

			responsabile = getServiceManager().salvaResponsabileTrans(responsabile, model.getCodiceImpianto(),
					model.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());

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

	public DatiGT[] getGT(String codiceimpianto, Integer progressivo, Integer idPersonaGiuridica)
			throws SigitextException {
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

	public DatiGF[] getGF(String codiceimpianto, Integer progressivo, Integer idPersonaGiuridica)
			throws SigitextException {
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

	public DatiSC[] getSC(String codiceimpianto, Integer progressivo, Integer idPersonaGiuridica)
			throws SigitextException {
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

	public DatiCG[] getCG(String codiceimpianto, Integer progressivo, Integer idPersonaGiuridica)
			throws SigitextException {
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
			logger.error("[SigitextImpl::getTipologiaGT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
					ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getTipologiaGT()", "invocazione servizio [sigitext]::[getTipologiaGT]",
					"(valore input omesso)");
			logger.debug("[SigitextImpl::getTipologiaGT] - END");
		}
	}

	public CodiceDescrizione[] getTipoIntervento() throws CSIException {
		logger.debug("[SigitextImpl::getTipoIntervento] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			CodiceDescrizione[] lista = null;
			lista = getServiceManager().getTipoIntervento();
			return lista;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getTipoIntervento] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
					ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getTipoIntervento()",
					"invocazione servizio [sigitext]::[getTipoIntervento]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getTipoIntervento] - END");
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
			logger.error("[SigitextImpl::getTipologiaGF] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
					ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getTipologiaGF()", "invocazione servizio [sigitext]::[getTipologiaGF]",
					"(valore input omesso)");
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
			watcher.dumpElapsed("SigitextImpl", "getFonteCIT()", "invocazione servizio [sigitext]::[getFonteCIT]",
					"(valore input omesso)");
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
			logger.error("[SigitextImpl::getTipologiaGT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
					ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getTipologiaGT()", "invocazione servizio [sigitext]::[getTipologiaGT]",
					"(valore input omesso)");
			logger.debug("[SigitextImpl::getTipologiaGT] - END");
		}
	}

	public Esito updateGT(String codiceImpianto, List<DatiGT> datiGTList, UtenteLoggato utenteLoggato,
			Integer idImpresa) throws NotFoundException, CSIException {
		logger.debug("[SigitextImpl::getTipologiaGT] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			Integer idPersonaGiuridica = idImpresa;
			String progressivo = datiGTList.get(0).getProgressivo() != null
					? datiGTList.get(0).getProgressivo().toString()
					: null;
			if (progressivo == null) {
				SigitTComp4Dto last = getDbServiceImp().cercaUltimoComponente(codiceImpianto,
						Constants.TIPO_COMPONENTE_GT);
				if (last != null) {
					progressivo = ConvertUtil.convertToString((last.getProgressivo().add(BigDecimal.ONE)));
				} else {
					progressivo = ConvertUtil.convertToString(BigDecimal.ONE);
				}
			}
			if (idImpresa == null) {
				idPersonaGiuridica = getServiceManager().getImpresaAssociata(utenteLoggato, codiceImpianto,
						Constants.ID_RUOLO_MANUTENTORE_ALL_1, ConvertUtil.convertToInteger(progressivo));
			}
			if (idPersonaGiuridica != null) {
				getServiceManager().salvaComponenteGT(codiceImpianto, progressivo, datiGTList, idPersonaGiuridica,
						utenteLoggato);
				return new Esito(Constants.OK, "Operazione completata");
			} else {
				throw new NotFoundException(Constants.KO_PG);
			}
		} catch (NotFoundException e) {
			throw e;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getTipologiaGT] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
					ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getTipologiaGT()", "invocazione servizio [sigitext]::[getTipologiaGT]",
					"(valore input omesso)");
			logger.debug("[SigitextImpl::getTipologiaGT] - END");
		}
	}

	public Esito updateGF(String codiceImpianto, List<DatiGF> datiGFList, UtenteLoggato utenteLoggato,
			Integer idImpresa) throws NotFoundException, CSIException {
		logger.debug("[SigitextImpl::getTipologiaGF] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			Integer idPersonaGiuridica = idImpresa;
			String progressivo = datiGFList.get(0).getProgressivo() != null
					? datiGFList.get(0).getProgressivo().toString()
					: null;
			if (progressivo == null) {
				SigitTComp4Dto last = getDbServiceImp().cercaUltimoComponente(codiceImpianto,
						Constants.TIPO_COMPONENTE_GF);
				if (last != null) {
					progressivo = ConvertUtil.convertToString((last.getProgressivo().add(BigDecimal.ONE)));
				} else {
					progressivo = ConvertUtil.convertToString(BigDecimal.ONE);
				}
			}
			if (idImpresa == null) {
				idPersonaGiuridica = getServiceManager().getImpresaAssociata(utenteLoggato, codiceImpianto,
						Constants.ID_RUOLO_MANUTENTORE_ALL_2, ConvertUtil.convertToInteger(progressivo));
			}
			if (idPersonaGiuridica != null) {
				getServiceManager().salvaComponenteGF(codiceImpianto, progressivo, datiGFList, idPersonaGiuridica,
						utenteLoggato);
				return new Esito(Constants.OK, "Operazione completata");
			} else {
				throw new NotFoundException(Constants.KO_PG);
			}
		} catch (NotFoundException e) {
			throw e;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getTipologiaGF] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
					ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getTipologiaGF()", "invocazione servizio [sigitext]::[getTipologiaGF]",
					"(valore input omesso)");
			logger.debug("[SigitextImpl::getTipologiaGF] - END");
		}
	}

	public Esito updateSC(String codiceImpianto, List<DatiSC> datiSCList, UtenteLoggato utenteLoggato,
			Integer idImpresa) throws NotFoundException, CSIException {
		logger.debug("[SigitextImpl::getTipologiaSC] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			Integer idPersonaGiuridica = idImpresa;
			String progressivo = datiSCList.get(0).getProgressivo() != null
					? datiSCList.get(0).getProgressivo().toString()
					: null;
			if (progressivo == null) {
				SigitTComp4Dto last = getDbServiceImp().cercaUltimoComponente(codiceImpianto,
						Constants.TIPO_COMPONENTE_SC);
				if (last != null) {
					progressivo = ConvertUtil.convertToString((last.getProgressivo().add(BigDecimal.ONE)));
				} else {
					progressivo = ConvertUtil.convertToString(BigDecimal.ONE);
				}
			}
			if (idImpresa == null) {
				idPersonaGiuridica = getServiceManager().getImpresaAssociata(utenteLoggato, codiceImpianto,
						Constants.ID_RUOLO_MANUTENTORE_ALL_3, ConvertUtil.convertToInteger(progressivo));
			}
			if (idPersonaGiuridica != null) {
				getServiceManager().salvaComponenteSC(codiceImpianto, progressivo, datiSCList, idPersonaGiuridica,
						utenteLoggato);
				return new Esito(Constants.OK, "Operazione completata");
			} else {
				throw new NotFoundException(Constants.KO_PG);
			}
		} catch (NotFoundException e) {
			throw e;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getTipologiaSC] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
					ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getTipologiaSC()", "invocazione servizio [sigitext]::[getTipologiaSC]",
					"(valore input omesso)");
			logger.debug("[SigitextImpl::getTipologiaSC] - END");
		}
	}

	public Esito updateCG(String codiceImpianto, List<DatiCG> datiCGList, UtenteLoggato utenteLoggato,
			Integer idImpresa) throws NotFoundException, CSIException {
		logger.debug("[SigitextImpl::getTipologiaCG] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			Integer idPersonaGiuridica = idImpresa;
			String progressivo = datiCGList.get(0).getProgressivo() != null
					? datiCGList.get(0).getProgressivo().toString()
					: null;
			if (progressivo == null) {
				SigitTComp4Dto last = getDbServiceImp().cercaUltimoComponente(codiceImpianto,
						Constants.TIPO_COMPONENTE_CG);
				if (last != null) {
					progressivo = ConvertUtil.convertToString((last.getProgressivo().add(BigDecimal.ONE)));
				} else {
					progressivo = ConvertUtil.convertToString(BigDecimal.ONE);
				}
			}
			if (idImpresa == null) {
				idPersonaGiuridica = getServiceManager().getImpresaAssociata(utenteLoggato, codiceImpianto,
						Constants.ID_RUOLO_MANUTENTORE_ALL_4, ConvertUtil.convertToInteger(progressivo));
			}
			if (idPersonaGiuridica != null) {
				getServiceManager().salvaComponenteCG(codiceImpianto, progressivo, datiCGList, idPersonaGiuridica,
						utenteLoggato);
				return new Esito(Constants.OK, "Operazione completata");
			} else {
				throw new NotFoundException(Constants.KO_PG);
			}
		} catch (NotFoundException e) {
			throw e;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getTipologiaCG] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
					ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getTipologiaCG()", "invocazione servizio [sigitext]::[getTipologiaCG]",
					"(valore input omesso)");
			logger.debug("[SigitextImpl::getTipologiaCG] - END");
		}
	}

	public List<Controllo> getControlli(String codiceImpianto, String ordinamento, Integer numRighe)
			throws CSIException {
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
			watcher.dumpElapsed("SigitextImpl", "getControlli()", "invocazione servizio [sigitext]::[getControlli]",
					"(valore input omesso)");
			logger.debug("[SigitextImpl::getControlli] - END");
		}
	}

	@Transactional
	public Esito delComponenteImpianto(String codiceImpianto, String tipologia, Integer progressivo, String cfUtente)
			throws ValidationManagerException, SigitextException {
		logger.debug("[SigitextImpl::delComponenteImpianto] - START");
		try {
			Integer count = getServiceManager().contaComponenti4ByFilter(codiceImpianto, progressivo, tipologia);
			if (count != null && count > 1) {
				throw new ValidationManagerException(new Message("Sono presenti altri componenti dismessi"));
			} else {
				switch (tipologia) {
				case Constants.TIPO_COMPONENTE_GT:
					DatiGT componenteToDelete = (DatiGT) getServiceManager()
							.cercaComponente4AttivaByFilter(codiceImpianto, progressivo, tipologia);
					if (componenteToDelete != null) {
						getServiceManager().checkPresenzaREEComponenteDaEliminare(codiceImpianto, tipologia,
								progressivo.toString());
						getServiceManager().checkPresenzaBRRCbyGT(codiceImpianto,
								ConvertUtil.convertToString(componenteToDelete.getDataInstall()),
								progressivo.toString());
					}
					getDbServiceImp().cancellaComponenteGT(ConvertUtil.convertToInteger(codiceImpianto),
							ConvertUtil.convertToString(progressivo), tipologia, cfUtente);
					break;
				case Constants.TIPO_COMPONENTE_GF:
					DatiGF componenteToDeleteGF = (DatiGF) getServiceManager()
							.cercaComponente4AttivaByFilter(codiceImpianto, progressivo, tipologia);
					if (componenteToDeleteGF != null) {
						getServiceManager().checkPresenzaREEComponenteDaEliminare(codiceImpianto, tipologia,
								progressivo.toString());
					}
					getDbServiceImp().cancellaComponenteGF(ConvertUtil.convertToInteger(codiceImpianto),
							ConvertUtil.convertToString(progressivo), tipologia, cfUtente);
					break;
				case Constants.TIPO_COMPONENTE_SC:
					DatiSC componenteToDeleteSC = (DatiSC) getServiceManager()
							.cercaComponente4AttivaByFilter(codiceImpianto, progressivo, tipologia);
					if (componenteToDeleteSC != null) {
						getServiceManager().checkPresenzaREEComponenteDaEliminare(codiceImpianto, tipologia,
								progressivo.toString());
					}
					getDbServiceImp().cancellaComponenteSC(ConvertUtil.convertToInteger(codiceImpianto),
							ConvertUtil.convertToString(progressivo), tipologia, cfUtente);
					break;
				case Constants.TIPO_COMPONENTE_CG:
					DatiCG componenteToDeleteCG = (DatiCG) getServiceManager()
							.cercaComponente4AttivaByFilter(codiceImpianto, progressivo, tipologia);
					if (componenteToDeleteCG != null) {
						getServiceManager().checkPresenzaREEComponenteDaEliminare(codiceImpianto, tipologia,
								progressivo.toString());
					}
					getDbServiceImp().cancellaComponenteCG(ConvertUtil.convertToInteger(codiceImpianto),
							ConvertUtil.convertToString(progressivo), tipologia, cfUtente);
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
			SigitVRicercaAllegatiDto ricercaAllegatiDto = getServiceManager().getDbServiceImp()
					.cercaSigitVRicercaAllegatiByIdAllegato(idAllegato.toString());
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
			watcher.dumpElapsed("SigitextImpl", "downloadXMLControllo()",
					"invocazione servizio [sigitext]::[downloadXMLControllo]", "(valore input omesso)");
			logger.debug("[SigitextImpl::downloadXMLControllo] - END");
		}
	}

	public byte[] getRicevutaControllo(String tipoComponente, String codiceImpianto, Integer progressivo,
			Date dataInstallazione, String idAllegato, String ruolo, Integer idPersona) throws CSIException {
		logger.debug("[SigitextImpl::getRicevutaControllo] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		byte[] ricevuta = null;
		try {
			SigitVRicercaAllegatiDto allegatoDB = getDbServiceImp().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);
			if (allegatoDB != null) {
				if (Constants.RUOLO_SUPER.equals(ruolo) || Constants.RUOLO_VALIDATORE.equals(ruolo)
						|| Constants.RUOLO_ISPETTORE.equals(ruolo) || Constants.RUOLO_CONSULTATORE.equals(ruolo)
						|| Constants.RUOLO_PROPRIETARIO.equals(ruolo) || (Constants.RUOLO_IMPRESA.equals(ruolo)
								&& idPersona == allegatoDB.getIdPersonaGiuridica().intValue())) {
					ricevuta = getServiceManager().generaRicevutaAllegato(idAllegato);
				} else
					throw new SigitextException("Utente non autorizzato al recupero della ricevuta");
			}
		} catch (Exception ex) {
			logger.error(
					"[SigitextImpl::getRicevutaControllo] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
					ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getRicevutaControllo()",
					"invocazione servizio [sigitext]::[getRicevutaControllo]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getRicevutaControllo] - END");
		}
		return ricevuta;
	}

	public PdfControllo getPDFControllo(String tipoComponente, String codiceImpianto, Integer progressivo,
			Date dataInstallazione, String idAllegato, Boolean firmato, String ruolo, Integer idPersona)
			throws CSIException {
		logger.debug("[SigitextImpl::getPDFControllo] - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		PdfControllo pdf = null;
		try {
			SigitVRicercaAllegatiDto allegatoDB = getDbServiceImp().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);
			if (allegatoDB != null) {
				if (Constants.RUOLO_SUPER.equals(ruolo) || Constants.RUOLO_VALIDATORE.equals(ruolo)
						|| Constants.RUOLO_ISPETTORE.equals(ruolo) || Constants.RUOLO_CONSULTATORE.equals(ruolo)
						|| Constants.RUOLO_PROPRIETARIO.equals(ruolo) || (Constants.RUOLO_IMPRESA.equals(ruolo)
								&& idPersona == allegatoDB.getIdPersonaGiuridica().intValue())) {
					pdf = getServiceManager().recueraAllegatoRee(idAllegato, codiceImpianto, firmato);
				} else
					throw new SigitextException("Utente non autorizzato al recupero della ricevuta");
			}
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getPDFControllo] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
					ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getPDFControllo()",
					"invocazione servizio [sigitext]::[getPDFControllo]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getPDFControllo] - END");
		}
		return pdf;
	}

	public List<ControlloDisponibile> getControlloDisponibile(String codiceImpianto, Date dataControllo,
			String tipoControllo, String tipoComponente, String ruolo, Integer idImpresa)
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
			disponibileList = getServiceManager().getControlliDisponibili(codiceImpianto, tipoComponente, tipoControllo,
					dataControllo, idImpresaUtente);
			if (validationManager.isNessunResponsabileByCodImpiantoApp(codiceImpianto,
					ConvertUtil.convertToString(dataControllo))) {
				throw new ValidationManagerException(
						new Message(GenericUtil.replacePlaceholder(Messages.ERROR_NESSUN_RESPONSABILE_A_DATA_CONTROLLO,
								ConvertUtil.convertToString(dataControllo), codiceImpianto)));
			}
		} catch (ValidationManagerException e) {
			logger.error(
					"[SigitextImpl::getControlloDisponibile] - Errore CSI occorso durante l'esecuzione del metodo:" + e,
					e);
			throw e;
		} catch (Exception ex) {
			logger.error("[SigitextImpl::getControlloDisponibile] - Errore CSI occorso durante l'esecuzione del metodo:"
					+ ex, ex);
			throw (CSIException) ex;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getControlloDisponibile()",
					"invocazione servizio [sigitext]::[getControlloDisponibile]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getControlloDisponibile] - END");
		}
		return disponibileList;
	}

	public Esito uploadReeFirmato(byte[] file, Integer idAllegato, String fileName, String contentType, String ruolo,
			Integer idImpresa, String cf) throws SigitextException {
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
				SigitTAllegatoDto allegato = getDbServiceImp().getSigitTAllegatoDao()
						.findByPrimaryKey(new SigitTAllegatoPk(new BigDecimal(idAllegato)));
				if (impianto != null) {
					if (contentType.equals("application/pkcs7-mime")
							|| contentType.equals("application/x-pkcs7-mime")) {
						logger.debug("--------------unzip--------------");
						unzippedFile = getServiceManager().estraiDocumento(dettaglioAllegato, allegato, file, impianto);
					}
					logger.debug("---------------------"
							+ (contentType.equals("application/pdf") || unzippedFile != null) + "-----------------");
					if (contentType.equals("application/pdf") || unzippedFile != null) {
						if (allegato != null) {
							if (unzippedFile != null) {
								proceed = getServiceManager()
										.leggiPdfReeFirmato(Files.readAllBytes(unzippedFile.toPath()), allegato);
								logger.debug("--------------------- proceed unzipped " + proceed + "-----------------");
							} else {
								proceed = getServiceManager().leggiPdfReeFirmato(file, allegato);
								logger.debug("--------------------- proceed normale" + proceed + "-----------------");
							}
							if (proceed) {
								if (allegato.getUidIndexFirmato() != null) {
									getServiceManager().indexDeleteContentByUid(allegato.getUidIndexFirmato());
								}
								Metadati metadati = getServiceManager().createMetadatiReeFirmato(dettaglioAllegato,
										impianto);
								logger.debug(metadati);
								ImportFileSuper doc = new ImportFileSuper();
								doc.setContentType(contentType);
								File temp = File.createTempFile(fileName, "");
								FileUtils.writeByteArrayToFile(temp, file);
								doc.setFile(temp);
								doc.setNomeFile(fileName);
								String dataControllo = dettaglioAllegato.getDataControllo().replace("/", "_");
								if (contentType.equals("application/pkcs7-mime")
										|| contentType.equals("application/x-pkcs7-mime")) {
									newName = "REEFIRMA_" + dettaglioAllegato.getCodiceImpianto() + "_" + dataControllo
											+ "_" + dettaglioAllegato.getIdAllegato() + ".pdf.p7m";
								} else {
									newName = "REEFIRMA_" + dettaglioAllegato.getCodiceImpianto() + "_" + dataControllo
											+ "_" + dettaglioAllegato.getIdAllegato() + ".pdf";
								}
								String uidFirmato = getServiceManager().caricaFileIndex(doc, Constants.INDEX_FOLDER_REE,
										newName, metadati);
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
	public Esito deleteControllo(Integer idAllegato, String ruolo, Integer idImpresa, String cf)
			throws SigitextException {
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
	public Esito updateControllo(Integer idAllegato, Integer codiceImpianto, String tipoControllo, byte[] xml,
			String tokenJWT) throws SigitextException {
		Esito esito = new Esito();
		try {
			Integer idAllegatoNew = null;
			if (idAllegato != null) {
				SigitTAllegatoDto allegatoDto = getServiceManager().getAllegatoByidAllegato(idAllegato);
				if (allegatoDto != null && allegatoDto.getFkStatoRapp() != null
						&& allegatoDto.getFkStatoRapp().intValue() == Constants.ID_STATO_RAPPORTO_BOZZA) {
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
				List<SigitTDettTipo1Dto> dettTipo1List = getDbServiceImp().getDettTipo1(null, null,
						ConvertUtil.convertToString(idAllegatoNew));
				if (dettTipo1List != null && !dettTipo1List.isEmpty()) {
					for (SigitTDettTipo1Dto sigitTDettTipo1Dto : dettTipo1List) {
						sigitTDettTipo1Dto.setEControlloweb(DateUtil.getSqlDataCorrente());
						getDbServiceImp().getSigitTDettTipo1Dao().update(sigitTDettTipo1Dto);
					}
				}
				break;
			case ALLEGATOIII:
				List<SigitTDettTipo2Dto> dettTipo2List = getDbServiceImp().getDettTipo2(null, null,
						ConvertUtil.convertToString(idAllegatoNew));
				if (dettTipo2List != null && !dettTipo2List.isEmpty()) {
					for (SigitTDettTipo2Dto sigitTDettTipo2Dto : dettTipo2List) {
						sigitTDettTipo2Dto.setEControlloweb(DateUtil.getSqlDataCorrente());
						getDbServiceImp().getSigitTDettTipo2Dao().update(sigitTDettTipo2Dto);
					}
				}
				break;
			case ALLEGATOIV:
				List<SigitTDettTipo3Dto> dettTipo3List = getDbServiceImp().getDettTipo3(null, null,
						ConvertUtil.convertToString(idAllegatoNew));
				if (dettTipo3List != null && !dettTipo3List.isEmpty()) {
					for (SigitTDettTipo3Dto sigitTDettTipo3Dto : dettTipo3List) {
						sigitTDettTipo3Dto.setEControlloweb(DateUtil.getSqlDataCorrente());
						getDbServiceImp().getSigitTDettTipo3Dao().update(sigitTDettTipo3Dto);
					}
				}
				break;
			case ALLEGATOV:
				List<SigitTDettTipo4Dto> dettTipo4List = getDbServiceImp().getDettTipo4(null, null,
						ConvertUtil.convertToString(idAllegatoNew));
				if (dettTipo4List != null && !dettTipo4List.isEmpty()) {
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

	public Esito inviaAllegato(Integer idAllegato, String ruolo, Integer idImpresa, String cf, Boolean cat)
			throws Exception {
		try {
			Esito esito = new Esito();
			// Ho centralizzato i controlli
			logger.debug(idAllegato);
			DettaglioAllegato dettaglio = getServiceManager().getDettaglioAllegatoById(idAllegato);
			getValidationManager().validazioneFormaleInviaAllegato(dettaglio, ruolo, idImpresa);
			SigitVRicercaAllegatiDto allegatoDto = getDbServiceImp()
					.cercaSigitVRicercaAllegatiByIdAllegato(ConvertUtil.convertToString(dettaglio.getIdAllegato()));
			Integer idStatoRapp = ConvertUtil.convertToInteger(allegatoDto.getFkStatoRapp());
			String msg;
			if (Constants.ID_STATO_RAPPORTO_INVIATO == idStatoRapp
					|| Constants.ID_STATO_RAPPORTO_RESPINTO == idStatoRapp) {
				throw new SigitextException("Controllo non nello stato bozza");
			} else {
				ResultInvioMail resultInvioMail = getServiceManager().getConnectorManager()
						.inviaAllegatoTrans(dettaglio, cat != null && cat ? idImpresa : null, cf);
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

	public ConsumoPodPdr[] getConsumiByPodPdrJWT(String podPdr, String tokenJWT) throws Exception {
		logger.debug("[SigitextManager::getConsumiByPodPdrJWT] BEGIN");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		// logger.debug("podPdr : " + podPdr + ", tk : " + tokenJWT);
		ConsumoPodPdr[] listConsumiToReturn = null;
		List<ConsumoPodPdr> listConsumi = new ArrayList<>();
		try {
			int idFunzionalita = Constants.ID_FUNZ_CERCA_CONSUMI_BY_PODPDR;
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);

			// Impianto[] listImpianti = null;
			// ArrayList < Impianto > listImpiantiTmp = new ArrayList < Impianto > ();

			// boolean isAbilitatoSuImpianto = false;

			// se PG restituisco messaggio di errore
			if (utenteJWT != null && utenteJWT.getIdPersonaGiuridica() == null) {

				// al termine delle verifiche su abilitazione utenza richiamo getConsumiByPodPdr
				listConsumi = getServiceManager().getConsumiByPodPdr(podPdr);

				if (listConsumi != null && !listConsumi.isEmpty()) {

					logger.debug("parametri in input trovata corrispondenza su DB");
					logger.debug("list Consumo size : " + listConsumi.size());
					listConsumiToReturn = listConsumi.toArray(new ConsumoPodPdr[listConsumi.size()]);
					logger.debug("list consumi to return length : " + listConsumiToReturn.length);

				} else {
					logger.debug("parametri in input non trovata corrispondenza su DB");
				}

			} else {
				logger.info("Servizio non abilitato per l'utente");
				throw new SigitextException(Messages.ERROR_UTENTE_NON_ABILITATO);
			}

			logger.debug("inizio procedura scrittura su Sigit L Accesso Dao");
			// se il fruitore del servizio non é il SIGIT, inserire un record su SIGIT_L_ACCESSO:
			if (!utenteJWT.getCodiceFruitore().equals(Constants.CODICE_FRUITORE_SIGIT)) {
				logger.debug("codice fruitore utente : " + utenteJWT.getCodiceFruitore());
				// ricerco su db servizio richiamato
				SigitTElencoWsDto webService = getDbServiceImp().cercaWsByidWs(idFunzionalita);
				logger.debug("web service cerca ws by id : " + webService.toString());

				if (utenteJWT.getIdPersonaGiuridica() != null) {

					logger.debug("utenteJWT get Id Persona Giuridica  not null");
					SigitTPersonaGiuridicaDto personaGiuridicaDto = getDbServiceImp().cercaPersonaGiuridicaById(
							ConvertUtil.convertToBigDecimal(utenteJWT.getIdPersonaGiuridica()));
					SigitLAccessoDto accessoDto = new SigitLAccessoDto();
					logger.debug("[TEST UPPER CASE START] denominazione persona giuridica: "
							+ personaGiuridicaDto.getDenominazione());
					// dtAccesso
					accessoDto.setDtAccesso(ConvertUtil.getSqlDataCorrente());

					accessoDto.setCodiceFiscale(personaGiuridicaDto.getCodiceFiscale());
					accessoDto.setCognome(personaGiuridicaDto.getDenominazione().toUpperCase());
					accessoDto.setRuolo(webService.getDescrizioneWs());
					logger.info("BEP accessoDto : " + accessoDto.toString());
					dbServiceImp.inserisciAccesso(accessoDto);

					logger.debug("[TEST UPPER CASE END] cognome dto di accesso: " + accessoDto.getCognome());
				} else if (utenteJWT.getCodiceFruitore().equals(Constants.CODICE_FRUITORE_ESTERNO_APPLICATIVO)) {
					try {
						logger.debug("utenteJWT get Codice Fruitore equals fruitore esterno applicativo : "
								+ utenteJWT.getCodiceFruitore());

						SigitLAccessoDto lAccessoDto = new SigitLAccessoDto();
						// lAccessoDto.setDtAccesso(new Timestamp(new Date().getTime()));
						lAccessoDto.setDtAccesso(ConvertUtil.getSqlDataCorrente());
						lAccessoDto.setCodiceFiscale(utenteJWT.getCodiceFruitore());
						lAccessoDto.setRuolo(webService.getDescrizioneWs());
						logger.debug("BEP lAccessoDto : " + lAccessoDto.toString() + ", CodiceFiscale : "
								+ lAccessoDto.getCodiceFiscale() + ", DtAccesso : " + lAccessoDto.getDtAccesso());
						dbServiceImp.inserisciAccesso(lAccessoDto);
						// SigitLAccessoPk insertAccessoDto =
						// dbServiceImp.inserisciAccesso(lAccessoDto);

					} catch (Exception ex) {
						if (CSIException.class.isAssignableFrom(ex.getClass())) {
							logger.error(
									"[SigitextImpl::setAccesso] - Errore CSI occorso durante l'esecuzione del metodo:"
											+ ex,
									ex);
							throw (CSIException) ex;
						} else {
							logger.error(
									"[SigitextImpl::setAccesso] - Errore imprevisto occorso durante l'esecuzione del metodo:"
											+ ex,
									ex);
							throw new UnrecoverableException(
									"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
						}
					}
				}
			}

		} catch (SigitextException e) {
			logger.error("[getConsumiByPodPdrJWT] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new Exception("Errore occorso nell'esecuzione del metodo:" + e, e);
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "getConsumiByPodPdrJWT()",
					"invocazione servizio [sigitext]::[getConsumiByPodPdrJWT]", "(valore input omesso)");
			logger.debug("[SigitextImpl::getConsumiByPodPdrJWT] - END");
		}
		return listConsumiToReturn;
	}

	public String[] getComuniPGJWT(String tokenJWT) throws Exception {
		String nomeMetodo = "--------- getComuniPGJWT ---------";
		// int idFunzionalita = Constants.ID_FUNZ_CERCA_MANUTENTORI;
		// UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT,
		// idFunzionalita);
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			List<String> listResult = getDbServiceImp().getSigitTPersonaGiuridicaDao().getComuniPG();
			return listResult.toArray(new String[listResult.size()]);
		} catch (SigitExtDaoException e) {
			logger.error("[" + nomeMetodo + "] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new Exception("Errore occorso nell'esecuzione del metodo:" + e, e);
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "" + nomeMetodo + "()",
					"invocazione servizio [sigitext]::[" + nomeMetodo + "]", "(valore input omesso)");
			logger.debug("[SigitextImpl::" + nomeMetodo + "] - END");
		}
	}

	public DettaglioPersonaGiuridica[] getManutentoriJWT(String denominazione, String comune, String tokenJWT)
			throws SigitextException, SigitExcessiveResultsException {
		String nomeMetodo = "--------- getManutentoriJWT ---------";
		if ((comune == null || comune.isEmpty()) && (denominazione == null || denominazione.isEmpty())) {
			throw new SigitextException("I filtri non possono essere entrambi non valorizzati");
		}

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();

		try {
			int idFunzionalita = Constants.ID_FUNZ_CERCA_MANUTENTORI;
			UtenteJWT utenteJWT = getServiceManager().isUtenteAutorizzato(tokenJWT, idFunzionalita);
			logger.debug(nomeMetodo + " utente autorizzato");
			getServiceManager().salvaAccesso(utenteJWT, idFunzionalita);

			List<SigitTPersonaGiuridicaDto> personeGiuridiche = getDbServiceImp().getSigitTPersonaGiuridicaDao()
					.getManutentori(denominazione, comune);
			DettaglioPersonaGiuridica[] listResult = new DettaglioPersonaGiuridica[personeGiuridiche.size()];
			for (int x = 0; x < personeGiuridiche.size(); x++) {
				listResult[x] = MapDto.mapToDettaglioPersonaGiuridica(personeGiuridiche.get(x));
			}
			return listResult;
		} catch (Exception e) {
			logger.error("[" + nomeMetodo + "] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new SigitextException("Errore occorso nell'esecuzione del metodo:" + e, e);
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", nomeMetodo + "()",
					"invocazione servizio [sigitext]::[" + nomeMetodo + "]", "(denominazione, comune)");
			logger.debug("[SigitextImpl::" + nomeMetodo + "] - END");
		}
	}

	public String setLibSch1IdImpianto(Integer codiceImpianto, Scheda1 scheda1, String cfUtenteLoggato) throws SigitextException {
		String nomeMetodo = "--------- setLibSch1IdImpianto ---------";
		logger.debug(nomeMetodo + " - START");
		String endWithError = nomeMetodo + " - END with error";

		logger.debug("codiceImpianto: " + codiceImpianto);
		logger.debug("cfUtenteLoggato: " + cfUtenteLoggato);

		try {
			SigitTImpiantoDto sigitTImpiantoDto = getDbServiceImp().cercaImpiantoDtoById(codiceImpianto.toString());

			if (sigitTImpiantoDto != null && sigitTImpiantoDto.getFkStato().compareTo(BigDecimal.ONE) == 0) {

				List<SigitTUnitaImmobiliareDto> sigitTUnitaImmobiliareDtoList = getDbServiceImp().getUnitaImmobiliariImpianto(codiceImpianto);

				checkIfUpdateSigitTUnitaImmobiliare(codiceImpianto, scheda1, cfUtenteLoggato, sigitTUnitaImmobiliareDtoList);

				logger.debug("scheda1.getL1_3_pot_h2o_kw(): " + scheda1.getL1_3_pot_h2o_kw());
				sigitTImpiantoDto.setL13PotH2oKw(getNumberValueIfExist(scheda1.getL1_3_pot_h2o_kw()));
				logger.debug("scheda1.getL1_3_pot_clima_inv_kw(): " + scheda1.getL1_3_pot_clima_inv_kw());
				sigitTImpiantoDto.setL13PotClimaInvKw(getNumberValueIfExist(scheda1.getL1_3_pot_clima_inv_kw()));
				logger.debug("scheda1.getL1_3_pot_clima_est_kw(): " + scheda1.getL1_3_pot_clima_est_kw());
				sigitTImpiantoDto.setL13PotClimaEstKw(getNumberValueIfExist(scheda1.getL1_3_pot_clima_est_kw()));
				logger.debug("scheda1.getL1_3_altro(): " + scheda1.getL1_3_altro());
				sigitTImpiantoDto.setL13Altro(scheda1.getL1_3_altro());
				logger.debug("scheda1.getL1_4_flg_h2o(): " + scheda1.getL1_4_flg_h2o());
				sigitTImpiantoDto.setL14FlgH2o(new BigDecimal(scheda1.getL1_4_flg_h2o()));
				logger.debug("scheda1.getL1_4_flg_aria(): " + scheda1.getL1_4_flg_aria());
				sigitTImpiantoDto.setL14FlgAria(new BigDecimal(scheda1.getL1_4_flg_aria()));
				logger.debug("scheda1.getL1_4_altro(): " + scheda1.getL1_4_altro());
				sigitTImpiantoDto.setL14Altro(scheda1.getL1_4_altro());
				logger.debug("scheda1.getL1_5_flg_generatore(): " + scheda1.getL1_5_flg_generatore());
				sigitTImpiantoDto.setL15FlgGeneratore(new BigDecimal(scheda1.getL1_5_flg_generatore()));
				logger.debug("scheda1.getL1_5_flg_pompa(): " + scheda1.getL1_5_flg_pompa());
				sigitTImpiantoDto.setL15FlgPompa(new BigDecimal(scheda1.getL1_5_flg_pompa()));
				logger.debug("scheda1.getL1_5_flg_frigo(): " + scheda1.getL1_5_flg_frigo());
				sigitTImpiantoDto.setL15FlgFrigo(new BigDecimal(scheda1.getL1_5_flg_frigo()));
				logger.debug("scheda1.getL1_5_flg_telerisc(): " + scheda1.getL1_5_flg_telerisc());
				sigitTImpiantoDto.setL15FlgTelerisc(new BigDecimal(scheda1.getL1_5_flg_telerisc()));
				logger.debug("scheda1.getL1_5_flg_teleraffr(): " + scheda1.getL1_5_flg_teleraffr());
				sigitTImpiantoDto.setL15FlgTeleraffr(new BigDecimal(scheda1.getL1_5_flg_teleraffr()));
				logger.debug("scheda1.getL1_5_flg_cogeneratore(): " + scheda1.getL1_5_flg_cogeneratore());
				sigitTImpiantoDto.setL15FlgCogeneratore(new BigDecimal(scheda1.getL1_5_flg_cogeneratore()));
				logger.debug("scheda1.getL1_5_altro(): " + scheda1.getL1_5_altro());
				sigitTImpiantoDto.setL15Altro(scheda1.getL1_5_altro());
				logger.debug("scheda1.getL1_5_sup_pannelli_sol_m2(): " + scheda1.getL1_5_sup_pannelli_sol_m2());
				sigitTImpiantoDto.setL15SupPannelliSolM2(new BigDecimal(scheda1.getL1_5_sup_pannelli_sol_m2()));
				logger.debug("scheda1.getL1_5_altro_integrazione(): " + scheda1.getL1_5_altro_integrazione());
				sigitTImpiantoDto.setL15AltroIntegrazione(scheda1.getL1_5_altro_integrazione());
				logger.debug("scheda1.getL1_5_altro_integr_pot_kw(): " + scheda1.getL1_5_altro_integr_pot_kw());
				sigitTImpiantoDto.setL15AltroIntegrPotKw(getNumberValueIfExist(scheda1.getL1_5_altro_integr_pot_kw()));
				logger.debug("scheda1.getL1_5_flg_altro_clima_inv(): " + scheda1.getL1_5_flg_altro_clima_inv());
				sigitTImpiantoDto.setL15FlgAltroClimaInv(new BigDecimal(scheda1.getL1_5_flg_altro_clima_inv()));
				logger.debug("scheda1.getL1_5_flg_altro_clima_estate(): " + scheda1.getL1_5_flg_altro_clima_estate());
				sigitTImpiantoDto.setL15FlgAltroClimaEstate(new BigDecimal(scheda1.getL1_5_flg_altro_clima_estate()));
				logger.debug("scheda1.getL1_5_flg_altro_acs(): " + scheda1.getL1_5_flg_altro_acs());
				sigitTImpiantoDto.setL15FlgAltroAcs(new BigDecimal(scheda1.getL1_5_flg_altro_acs()));
				logger.debug("scheda1.getL1_5_altro_desc(): " + scheda1.getL1_5_altro_desc());
				sigitTImpiantoDto.setL15AltroDesc(scheda1.getL1_5_altro_desc());
				sigitTImpiantoDto.setDataUltMod(new Timestamp(System.currentTimeMillis()));
				sigitTImpiantoDto.setUtenteUltMod(cfUtenteLoggato);
				logger.debug("scheda1.getFkTipoIntervento(): " + scheda1.getFkTipoIntervento());
				sigitTImpiantoDto.setFkTipoIntervento(new BigDecimal(scheda1.getFkTipoIntervento()));
				logger.debug("scheda1.getDataIntervento(): " + scheda1.getDataIntervento());
				if(scheda1.getDataIntervento() != null) {
					sigitTImpiantoDto.setDataIntervento(new java.sql.Date(scheda1.getDataIntervento().getTime()));
				}
				

				getDbServiceImp().updateSigitTImpianto(sigitTImpiantoDto);

				List<DatiAggiuntivi> datiAggiuntivi = scheda1.getDatiAggiuntivi();
				logger.debug("datiAggiuntivi size: " + datiAggiuntivi.size());

				List<DatiAggiuntivi> datiAggiuntiviToSave = checkIfRemoveSigitTUnitaImmobiliare(codiceImpianto, sigitTUnitaImmobiliareDtoList, datiAggiuntivi);
				logger.debug("datiAggiuntiviToSave size: " + datiAggiuntiviToSave.size());

				createNewSigitTUnitaImmobiliareFromDatiAggiuntivi(codiceImpianto, cfUtenteLoggato, datiAggiuntiviToSave);
				
				SigitTControlloLibrettoDto tControlloLibretto = getDbServiceImp().getControlloLibretto(codiceImpianto);
				if(tControlloLibretto == null) {
					tControlloLibretto = new SigitTControlloLibrettoDto();
					createUpdateSigitTControlloLibretto(codiceImpianto, cfUtenteLoggato, tControlloLibretto);
					getDbServiceImp().insertControlloLibretto(tControlloLibretto);
				}else if(tControlloLibretto != null && tControlloLibretto.getFlgL1Controlloweb().equals(BigDecimal.ZERO)) {
					createUpdateSigitTControlloLibretto(codiceImpianto, cfUtenteLoggato, tControlloLibretto);
					getDbServiceImp().updateControlloLibretto(tControlloLibretto);
				}

			} else {
				logger.error("SigitTImpianto not found");
				logger.debug(endWithError);
				throw new SigitextException("SigitTImpianto not found");
			}

		} catch (SigitTImpiantoDaoException ex) {
			logger.error("Error when update SigitTImpiantoDto: " + ex);
			logger.debug(endWithError);
			throw new SigitextException("Error when update SigitTImpiantoDto: " + ex);
		} catch (SigitTUnitaImmobiliareDaoException ex) {
			logger.error("Error when update SigitTUnitaImmobiliare: " + ex);
			logger.debug(endWithError);
			throw new SigitextException("Error when update SigitTUnitaImmobiliare: " + ex);
		} catch (Exception ex) {
			logger.error("Generic error: " + ex);
			logger.debug(endWithError);
			throw new SigitextException("Generic error: " + ex);
		}

		logger.debug(nomeMetodo + " - END");
		return "OK";
	}

	private void createUpdateSigitTControlloLibretto(Integer codiceImpianto, String cfUtenteLoggato, SigitTControlloLibrettoDto tControlloLibretto) {
		logger.debug("[SigitextImpl:: createUpdateSigitTControlloLibretto] - START");
		
		tControlloLibretto.setCodiceImpianto(new BigDecimal(codiceImpianto));
		tControlloLibretto.setFlgL1Controlloweb(BigDecimal.ONE);
		tControlloLibretto.setDtUltMod(new Timestamp(System.currentTimeMillis()));
		tControlloLibretto.setUtenteUltAgg(cfUtenteLoggato);
		
		logger.debug("[SigitextImpl:: createUpdateSigitTControlloLibretto] - END");
	}

	public List<Categoria> getCategorie() throws SigitExtDaoException {
		return getDbServiceImp().getCategorie();
	}

	private void createNewSigitTUnitaImmobiliareFromDatiAggiuntivi(Integer codiceImpianto, String cfUtenteLoggato, List<DatiAggiuntivi> datiAggiuntivi) {
		for (DatiAggiuntivi da : datiAggiuntivi) {
			logger.debug("Creazione nuvo SigitTUnitaImmobiliare per dati aggiuntivi");

			SigitTUnitaImmobiliareDto sigitTUnitaImmobiliareDto = new SigitTUnitaImmobiliareDto();

			logger.debug("sezione: " + da.getSezione());
			sigitTUnitaImmobiliareDto.setSezione(da.getSezione());
			logger.debug("foglio: " + da.getFoglio());
			sigitTUnitaImmobiliareDto.setFoglio(da.getFoglio());
			logger.debug("particella: " + da.getParticella());
			sigitTUnitaImmobiliareDto.setSubalterno(da.getParticella());
			logger.debug("subalterno: " + da.getSubalterno());
			sigitTUnitaImmobiliareDto.setParticella(da.getSubalterno());
			logger.debug("pod elettrico: " + da.getPod_elettrico());
			if (da.getPod_elettrico() != null) {
				sigitTUnitaImmobiliareDto.setPodElettrico(da.getPod_elettrico());
			}
			logger.debug("pdr gas: " + da.getPdr_gas());
			if (da.getPdr_gas() != null) {
				sigitTUnitaImmobiliareDto.setPdrGas(da.getPdr_gas());
			}
			sigitTUnitaImmobiliareDto.setCodiceImpianto(BigDecimal.valueOf(codiceImpianto));
			sigitTUnitaImmobiliareDto.setFlgPrincipale(BigDecimal.ZERO);
			sigitTUnitaImmobiliareDto.setDataUltMod(new Timestamp(System.currentTimeMillis()));
			sigitTUnitaImmobiliareDto.setUtenteUltMod(cfUtenteLoggato);

			getDbServiceImp().insertSigitTUnitaImmobiliare(sigitTUnitaImmobiliareDto);
		}
	}

	private List<DatiAggiuntivi> checkIfRemoveSigitTUnitaImmobiliare(Integer codiceImpianto, List<SigitTUnitaImmobiliareDto> sigitTUnitaImmobiliareDtoList, List<DatiAggiuntivi> datiAggiuntivi) throws SigitTUnitaImmobiliareDaoException {

		List<String> daDataToReturn = new ArrayList<>();
		List<String> daDataAlreadyOnDB = new ArrayList<>();
		List<DatiAggiuntivi> response = new ArrayList<>();
		Boolean addAll = true;

		for (SigitTUnitaImmobiliareDto stuid : sigitTUnitaImmobiliareDtoList) {
			if (stuid.getCodiceImpianto().compareTo(BigDecimal.valueOf(codiceImpianto)) == 0 && stuid.getFlgPrincipale().compareTo(BigDecimal.ZERO) == 0) {
				addAll = checkDatiAggiuntivi(datiAggiuntivi, daDataToReturn, daDataAlreadyOnDB, stuid);
			}
		}

		if (Boolean.TRUE.equals(addAll)) {
			logger.debug("Add all datiAggiuntivi to response");
			response.addAll(datiAggiuntivi);
		} else {
			composeListForResponse(datiAggiuntivi, daDataToReturn, response);
		}

		return response;
	}

	private void composeListForResponse(List<DatiAggiuntivi> datiAggiuntivi, List<String> daDataToReturn,
			List<DatiAggiuntivi> response) {
		for (String daData : daDataToReturn) {
			for (DatiAggiuntivi da : datiAggiuntivi) {
				String daStringData = da.getSezione() + da.getFoglio() + da.getParticella() + da.getSubalterno()
						+ (da.getPod_elettrico() != null ? da.getPod_elettrico() : "")
						+ (da.getPdr_gas() != null ? da.getPdr_gas() : "");
				logger.debug("daStringData: " + daStringData);

				if (daData.equals(daStringData)) {
					logger.debug("add datiAggiuntivi with daStringData " + daStringData + " to response");
					response.add(da);
				}
			}
		}
	}

	private Boolean checkDatiAggiuntivi(List<DatiAggiuntivi> datiAggiuntivi, List<String> daDataToReturn,
			List<String> daDataAlreadyOnDB, SigitTUnitaImmobiliareDto stuid) throws SigitTUnitaImmobiliareDaoException {
		Boolean addAll;
		logger.debug("flgPrincipale = 0");

		Boolean stuidIsDifferent = true;
		addAll = false;

		for (DatiAggiuntivi da : datiAggiuntivi) {
			String daStringData = da.getSezione() + da.getFoglio() + da.getParticella() + da.getSubalterno()
					+ (da.getPod_elettrico() != null ? da.getPod_elettrico() : "")
					+ (da.getPdr_gas() != null ? da.getPdr_gas() : "");
			logger.debug("daStringData: " + daStringData);
			logger.debug("daDataAlreadyOnDB size: " + daDataAlreadyOnDB.size());
			logger.debug("daStringData is in daDataAlreadyOnDB? " + daDataAlreadyOnDB.contains(daStringData));

			/*
			 * Se i dati aggiuntivi sono diversi da quelli presenti nel DB allora quella
			 * riga del DB va rimossa e devo inserire il dato aggiuntivo alla response
			 * perchè va inserito nel DB
			 */
			if (!daDataAlreadyOnDB.contains(daStringData) && da.getSezione().equals(stuid.getSezione())
					&& da.getFoglio().equals(stuid.getFoglio()) && da.getParticella().equals(stuid.getParticella())
					&& da.getSubalterno().equals(stuid.getSubalterno())
					&& (da.getPod_elettrico() != null && da.getPod_elettrico().equals(stuid.getPodElettrico()))
					&& (da.getPdr_gas() != null && da.getPdr_gas().equals(stuid.getPdrGas()))) {

				logger.debug("remove datiAggiuntivi da response list, daStringData: " + daStringData);

				daDataToReturn.remove(daStringData);
				daDataAlreadyOnDB.add(daStringData);

				stuidIsDifferent = false;
			} else if (!daDataAlreadyOnDB.contains(daStringData) && !daDataToReturn.contains(daStringData)) {
				logger.debug("Add datiAggiuntivi da response list, daStringData: " + daStringData);
				daDataToReturn.add(daStringData);
			}
		}

		// se la riga nel DB non é uguale a nessun dato aggiuntivo nella lista devo
		// rimuoverla
		if (Boolean.TRUE.equals(stuidIsDifferent)) {
			logger.debug("remove datiAggiuntivi da DB, idUnitaImm: " + stuid.getIdUnitaImm());
			getDbServiceImp().removeSigitTUnitaImmobiliare(stuid);
		}
		return addAll;
	}

	private void checkIfUpdateSigitTUnitaImmobiliare(Integer codiceImpianto, Scheda1 scheda1, String cfUtenteLoggato, List<SigitTUnitaImmobiliareDto> sigitTUnitaImmobiliareDtoList) throws SigitTUnitaImmobiliareDaoException {
		String nomeMetodo = "--------- checkIfUpdateSigitTUnitaImmobiliare ---------";
		logger.debug(nomeMetodo + " - START");
		
		for (SigitTUnitaImmobiliareDto stuid : sigitTUnitaImmobiliareDtoList) {
			if (stuid.getCodiceImpianto().compareTo(BigDecimal.valueOf(codiceImpianto)) == 0 && stuid.getFlgPrincipale().compareTo(BigDecimal.ONE) == 0) {
				logger.debug("flgPrincipale = 1");
				logger.debug("idUnitaImm: " + stuid.getIdUnitaImm());

				stuid.setL12FlgSingolaUnita(new BigDecimal(scheda1.getL1_2_flg_singola_unita()));
				stuid.setL12FkCategoria(scheda1.getL1_2_fk_categoria());
				stuid.setL12VolRiscM3(getNumberValueIfExist(scheda1.getL1_2_vol_risc_m3()));
				stuid.setL12VolRaffM3(getNumberValueIfExist(scheda1.getL1_2_vol_raff_m3()));
				stuid.setDataUltMod(new Timestamp(System.currentTimeMillis()));
				stuid.setUtenteUltMod(cfUtenteLoggato);

				getDbServiceImp().updateSigitTUnitaImmobiliare(stuid);
			}
		}
		
		logger.debug(nomeMetodo + " - END");
	}

	private BigDecimal getNumberValueIfExist(Float value) {
		if (value == null) {
			return null;
		}
		return BigDecimal.valueOf(value);
	}

	public Documento getCopertinaIspezioneJWT(Integer idIspezione, String jwt) throws Exception {
		String nomeMetodo = "getCopertinaIspezioneJWT";
		logger.info("SigitExt::getCopertinaIspezioneJWT - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			return getLetteraAvvisoBuilderService().generaCopertinaIspezione(idIspezione);
		} catch (Exception e) {
			logger.error("[" + nomeMetodo + "] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw e;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "" + nomeMetodo + "()",
					"invocazione servizio [sigitext]::[" + nomeMetodo + "]", "(valore input omesso)");
			logger.debug("[SigitextImpl::" + nomeMetodo + "] - END");
		}
	}

	public Documento getLetteraAvvisoJWT(Integer idIspezione, String jwt) throws Exception {
		String nomeMetodo = "getLetteraAvvisoJWT";
		logger.info("SigitExt::getLetteraAvvisoJWT - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			return getLetteraAvvisoBuilderService().generaLetteraAvviso(idIspezione, false);
		} catch (SigitextException e) {
			logger.error("[" + nomeMetodo + "] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw e;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "" + nomeMetodo + "()",
					"invocazione servizio [sigitext]::[" + nomeMetodo + "]", "(valore input omesso)");
			logger.debug("[SigitextImpl::" + nomeMetodo + "] - END");
		}
	}

	public Documento getLetteraAvviso180GgJWT(Integer idIspezione, String jwt) throws Exception {
		String nomeMetodo = "getLetteraAvviso180GgJWT";
		logger.info("SigitExt::getLetteraAvviso180GgJWT - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			return getLetteraAvvisoBuilderService().generaLetteraAvviso180Gg(idIspezione);
		} catch (SigitextException e) {
			logger.error("[" + nomeMetodo + "] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw e;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "" + nomeMetodo + "()",
					"invocazione servizio [sigitext]::[" + nomeMetodo + "]", "(valore input omesso)");
			logger.debug("[SigitextImpl::" + nomeMetodo + "] - END");
		}
	}

	public Documento getFileExcelJWT(List<Integer> ids, String jwt) throws Exception {
		String nomeMetodo = "getFileExcelJWT";
		logger.info("SigitExt::getFileExcelJWT - START");
		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
		watcher.start();
		try {
			return getLetteraAvvisoBuilderService().generaFileExcel(ids);
		} catch (SigitextException e) {
			logger.error("[" + nomeMetodo + "] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw e;
		} finally {
			watcher.stop();
			watcher.dumpElapsed("SigitextImpl", "" + nomeMetodo + "()",
					"invocazione servizio [sigitext]::[" + nomeMetodo + "]", "(valore input omesso)");
			logger.debug("[SigitextImpl::" + nomeMetodo + "] - END");
		}
	}

	public String setDocumento(DocumentoPwa documento, Integer idContratto, String cfUtenteLoggato,
			Integer codiceImpianto, Integer idAzione, String tipoDoc, Integer fkIspezIspett, String dataControllo)
			throws SigitextException {
		logger.debug("setDocumento START");

		String errorIndexUpload = "Error with index upload: ";

		SigitWrkConfigDto wrkConfigDto = getDbServiceImp().cercaConfigValue(Constants.MAX_MB_DOC);

		logger.debug("tipoDoc: " + tipoDoc);
		logger.debug("documento mimeType: " + documento.getMimeType());
		logger.debug("documento dimension in MB: " + documento.getDimensione() / 1000000);
		logger.debug("max dimension in MB: " + wrkConfigDto.getValoreConfigNum().longValue());
		logger.debug("id jpeg mimeType " + documento.getMimeType().equals(Constants.MIME_TYPE_JPEG));
		logger.debug("if all mimeType " + (documento.getMimeType().equals(Constants.MIME_TYPE_PDF)
				|| documento.getMimeType().equals(Constants.MIME_TYPE_JPG)
				|| documento.getMimeType().equals(Constants.MIME_TYPE_JPEG)
				|| documento.getMimeType().equals(Constants.MIME_TYPE_PNG)));
		logger.debug("if dimension " + (documento.getDimensione() < wrkConfigDto.getValoreConfigNum().longValue()));

		if ((documento.getMimeType().equals(Constants.MIME_TYPE_PDF)
				|| documento.getMimeType().equals(Constants.MIME_TYPE_JPG)
				|| documento.getMimeType().equals(Constants.MIME_TYPE_JPEG)
				|| documento.getMimeType().equals(Constants.MIME_TYPE_PNG))
				&& documento.getDimensione() / 1000000 < wrkConfigDto.getValoreConfigNum().longValue()) {

			try {
				SigitTImpiantoDto impiantoDto = getDbServiceImp().getImpiantoByCod(new BigDecimal(codiceImpianto));

				switch (tipoDoc) {
				case "3 resp":
					logger.debug("inside 3 resp");
					SigitTDocContrattoDto dto3resp = new SigitTDocContrattoDto();
					dto3resp.setFkContratto(new BigDecimal(idContratto));
					dto3resp.setNomeDocOriginale(documento.getNome());
					dto3resp.setDescrizione(documento.getDescrizione());
					dto3resp.setDataUpload(new Date(System.currentTimeMillis()));
					dto3resp.setDataDelete(null);
					dto3resp.setDataUltMod(new Date(System.currentTimeMillis()));
					dto3resp.setUtenteUltMod(cfUtenteLoggato);

					SigitTDocContrattoPk docContrattoPk = getDbServiceImp().insertSigitTDocContratto(dto3resp);

					String fileName3resp = "Doc_CONTRATTO" + docContrattoPk.getIdDocContratto().intValue()
							+ documento.getNome();
					String folder3resp = impiantoDto.getDenominazioneProvincia() + "."
							+ impiantoDto.getDenominazioneComune() + "." + codiceImpianto + ".doc";

					String uidFirmato3resp = loadToIndex(documento, impiantoDto, fileName3resp, folder3resp);

					getDbServiceImp().updateSigitTDocContrattoUidIndex(docContrattoPk.getIdDocContratto().intValue(),
							uidFirmato3resp, fileName3resp);

					break;
				case "aggiuntivo":
					logger.debug("inside aggiuntivo");
					SigitTDocAggiuntivaDto dtoAggiuntivo = new SigitTDocAggiuntivaDto();
					dtoAggiuntivo.setCodiceImpianto(new BigDecimal(codiceImpianto));
					dtoAggiuntivo.setFkTipoDocagg(new BigDecimal(documento.getTipoDocumento()));
					dtoAggiuntivo.setNomeDocOriginale(documento.getNome());
					dtoAggiuntivo.setDesAltroTipodoc(documento.getDescrizione());
					dtoAggiuntivo.setDataUpload(new Timestamp(System.currentTimeMillis()));
					dtoAggiuntivo.setDataDelete(null);
					dtoAggiuntivo.setDataUltMod(new Timestamp(System.currentTimeMillis()));
					dtoAggiuntivo.setUtenteUltMod(cfUtenteLoggato);

					SigitTDocAggiuntivaPk pkDocAggiuntiva = getDbServiceImp().insertSigitTDocAggiuntiva(dtoAggiuntivo);

					String fileNameAggiuntivo = "Doc_" + pkDocAggiuntiva.getIdDocAggiuntiva() + documento.getNome();
					String folderAggiuntivo = impiantoDto.getDenominazioneProvincia() + "."
							+ impiantoDto.getDenominazioneComune() + "." + codiceImpianto + ".doc";

					logger.debug("fileName: " + fileNameAggiuntivo);
					logger.debug("folder: " + folderAggiuntivo);

					String uidFirmatoAggiuntivo = loadToIndex(documento, impiantoDto, fileNameAggiuntivo,
							folderAggiuntivo);

					logger.debug("uidFirmato: " + uidFirmatoAggiuntivo);

					dtoAggiuntivo.setUidIndex(uidFirmatoAggiuntivo);
					dtoAggiuntivo.setNomeDoc(fileNameAggiuntivo);
					dtoAggiuntivo.setIdDocAggiuntiva(pkDocAggiuntiva.getIdDocAggiuntiva());

					getDbServiceImp().updateSigitTDocAggiuntivaAggiornaNomeUid(dtoAggiuntivo);

					break;
				case "azione_verifica":
					logger.debug("inside azione_verifica");
					createDocAzione(documento, cfUtenteLoggato, codiceImpianto, idAzione, impiantoDto, "VERIFICA");
					break;
				case "azione_accertamento":
					logger.debug("inside azione_accertamento");
					createDocAzione(documento, cfUtenteLoggato, codiceImpianto, idAzione, impiantoDto, "ACCERTAMENTO");
					break;
				case "azione_ispezione":
					logger.debug("inside azione_ispezione");
					createDocAzione(documento, cfUtenteLoggato, codiceImpianto, idAzione, impiantoDto, "ISPEZIONE");
					break;
				case "ree":
					logger.debug("inside ree");
					break;
				case "rapprova":
					logger.debug("inside rapprova");

					setDocumentoRapprova(documento, cfUtenteLoggato, codiceImpianto, fkIspezIspett, dataControllo,
							impiantoDto);

					break;
				default:
					logger.info("default case, no action executed");
					break;
				}

			} catch (IOException ex) {
				logger.error(errorIndexUpload + ex);
				logger.debug("setDocumento END with error: " + errorIndexUpload);
				throw new SigitextException(errorIndexUpload);
			} catch (SigitTDocAggiuntivaDaoException e) {
				logger.debug("Error when update SigitTDocAggiuntivaDto: " + e);
				logger.debug("setDocumento END with error: Error when update SigitTDocAggiuntivaDto");
				throw new SigitextException(e.getMessage());
			}
		} else {
			logger.debug("setDocumento END with error: Wrong Documento type");
			throw new SigitextException("Wrong Documento type");
		}

		logger.debug("setDocumento END");
		return "OK";
	}

	private void setDocumentoRapprova(Documento documento, String cfUtenteLoggato, Integer codiceImpianto,
			Integer fkIspezIspett, String dataControllo, SigitTImpiantoDto impiantoDto)
			throws SigitextException, IOException {

		try {

			SigitTAllegatoDto dto = new SigitTAllegatoDto();
			dto.setFkStatoRapp(BigDecimal.ONE);
			dto.setFkIspezIspet(new BigDecimal(fkIspezIspett)); // da inserire una volta implementato l'oggetto
																// DatiRapProva
			dto.setDataUltMod(new Timestamp(System.currentTimeMillis()));
			dto.setDataInvio(new java.sql.Date(System.currentTimeMillis()));
			dto.setUtenteUltMod(cfUtenteLoggato);

			BigDecimal idAllegato = getDbServiceImp().inserisciAllegato(dto);

			String fileName = "RAPPROVA_" + codiceImpianto + "_" + dataControllo + "_" + idAllegato; // da inserire una
																										// volta
																										// implementato
																										// l'oggetto
																										// DatiRapProva
			String folder = impiantoDto.getDenominazioneProvincia() + "." + impiantoDto.getDenominazioneComune() + "."
					+ codiceImpianto + "ISPEZIONI";

			String uidFirmato = loadToIndex(documento, impiantoDto, fileName, folder);

			dto.setNomeAllegato(fileName);
			dto.setUidIndex(uidFirmato);
			dto.setIdAllegato(idAllegato);

			getDbServiceImp().aggiornaAllegato(dto);

			/*
			 * In base al tipo allegato selezionato, inoltre, aggiornare per il componente
			 * selezionato su: - SIGIT_R_ALLEGATO_COMP_GT se tipo allegato = "Rapporto Prova
			 * GT" - SIGIT_R_ALLEGATO_COMP_GF se tipo allegato = "Rapporto Prova GF
			 * Valorizzando i dati del responsabile/3responsabile su fk_r_pg, fk_r_pf,
			 * fk_3r_pg ATTENZIONE: Al momento dell'invio é valido quanto presente su DB
			 * alla data del controllo
			 * 
			 */

		} catch (IOException ex) {
			String errorIndexUpload = "Error with index upload: ";
			logger.error(errorIndexUpload + ex);
			logger.debug("setDocumento END with error: " + errorIndexUpload);
			throw new SigitextException(errorIndexUpload);
		}

	}

	private void createDocAzione(Documento documento, String cfUtenteLoggato, Integer codiceImpianto, Integer idAzione,
			SigitTImpiantoDto impiantoDto, String tipoAzione) throws SigitextException {
		if (idAzione != null) {
			try {
				SigitTDocAzioneDto dto = new SigitTDocAzioneDto();
				dto.setFkAzione(idAzione);
				dto.setNomeDocOriginale(documento.getNome());
				dto.setDataUltMod(new java.sql.Date(System.currentTimeMillis()));
				dto.setUtenteUltMod(cfUtenteLoggato);

				SigitTDocAzionePk sigitTDocAzionePk = getDbAzioneMgr().inserisciDocAzione(dto);

				String fileName = "DocAzione_" + tipoAzione + "_" + sigitTDocAzionePk.getIdDocAzione() + "_" + documento.getNome();
				String folder;

				if (codiceImpianto != null) {
					folder = impiantoDto.getDenominazioneProvincia() + "." + impiantoDto.getDenominazioneComune() + "."
							+ codiceImpianto + ".doc_pa";
				} else {
					folder = "doc_pa";
				}
				String uidFirmato = loadToIndex(documento, impiantoDto, fileName, folder);

				dto.setNomeDoc(fileName);
				dto.setUidIndex(uidFirmato);
				dto.setIdDocAzione(sigitTDocAzionePk.getIdDocAzione());

				getDbAzioneMgr().aggiornaTDocAzione(dto);

			} catch (IOException ex) {
				logger.error("Error with index upload: " + ex);
				throw new SigitextException("Error with index upload");
			}
		}
	}

	public String loadToIndex(Documento documento, SigitTImpiantoDto impiantoDto, String fileName, String folder)
			throws IOException, SigitextException {
		Metadati metadati = getServiceManager().createMetadatiDocumento(impiantoDto);
		logger.debug("Metadati:" + metadati);
		ImportFileSuper doc = new ImportFileSuper();
		doc.setContentType(documento.getMimeType());

		File temp = File.createTempFile(fileName, "");
		FileUtils.writeByteArrayToFile(temp, documento.getDoc());

		doc.setFile(temp);
		doc.setNomeFile(fileName);

		return getServiceManager().caricaFileIndex(doc, folder, fileName, metadati);
	}

	public ResponseGetElencoDocumenti getElencoDocumenti(String codiceImpianto, String idVerifica, String idAccertamento, String idIspezione2018) throws SigitextException {
		logger.debug("getElencoDocumenti START");

		ResponseGetElencoDocumenti response = new ResponseGetElencoDocumenti();
		String errorString = "ATTENZIONE Non ci sono elementi da visualizzare";

		try {
			List<SigitTContratto2019Dto> sigitTContratto2019DtoList = getDbServiceImp().findSigitTContratto2019DtoByCodiceImpianto(codiceImpianto);
			logger.debug("sigitTContratto2019DtoList size: " + sigitTContratto2019DtoList.size());

			createDocumentiAssociatiContratto(response, sigitTContratto2019DtoList);

			List<SigitTDocAggiuntivaDto> sigitTDocAggiuntivaDtoList = getDbServiceImp().findByCodImp(codiceImpianto);
			logger.debug("sigitTDocAggiuntivaDtoList size: " + sigitTDocAggiuntivaDtoList.size());

			createDocumentiAggiuntiviImpianto(response, sigitTDocAggiuntivaDtoList);

			if (idVerifica != null && !idVerifica.isEmpty()) {
				List<SigitTAzioneDto> sigitTAzioneDtoList = getDbServiceImp().findSigitTAzioneByFkVerifica(Integer.parseInt(idVerifica));
				logger.debug("sigitTAzioneDtoList size: " + sigitTAzioneDtoList.size());

				fillDocumentiAzioni(response, sigitTAzioneDtoList);
			}

			if (idAccertamento != null && !idAccertamento.isEmpty()) {
				List<SigitTAzioneDto> sigitTAzioneDtoList = getDbServiceImp().findSigitTAzioneByFkAccertamento(Integer.parseInt(idAccertamento));
				logger.debug("sigitTAzioneDtoList size: " + sigitTAzioneDtoList.size());

				fillDocumentiAzioni(response, sigitTAzioneDtoList);
			}

			if (idIspezione2018 != null && !idIspezione2018.isEmpty()) {
				List<SigitTAzioneDto> sigitTAzioneDtoList = getDbServiceImp().findSigitTAzioneByFkIspezione2018(Integer.parseInt(idIspezione2018));
				logger.debug("sigitTAzioneDtoList size: " + sigitTAzioneDtoList.size());

				fillDocumentiAzioni(response, sigitTAzioneDtoList);
			}

			List<Integer> idAllegatoList = getServiceManager().getIdAllegatoListFromSigitRAllegatoCompXXByCodiceImpianto(Integer.parseInt(codiceImpianto));
			logger.debug("idAllegatoList size: " + idAllegatoList.size());

			response.getDocumentiAllegatiImpianto().addAll(createDocumentiReeImpianto(idAllegatoList));

		} catch (SigitTDocContrattoDaoException e) {
			logger.error("Error when retrieve sigitTDocContrattoDtoList: " + e);
			throw new SigitextException(errorString);
		} catch (SigitTDocAggiuntivaDaoException e) {
			logger.error("Error when retrieve sigitTDocAggiuntivaDtoList: " + e);
			throw new SigitextException(errorString);
		} catch (SigitTAzioneDaoException e) {
			logger.error("Error when retrieve sigitTAzioneDtoList: " + e);
			throw new SigitextException(errorString);
		} catch (SigitTDocAzioneDaoException | NumberFormatException e) {
			logger.error("Error when retrieve sigitTDocAzioneDtoList: " + e);
			throw new SigitextException(errorString);
		} catch (SigitRAllegatoCompScDaoException | SigitRAllegatoCompGtDaoException | SigitRAllegatoCompGfDaoException
				| SigitRAllegatoCompCgDaoException e) {
			logger.error("Error when retrieve idAllegatoList: " + e);
			throw new SigitextException(errorString);
		} catch (SigitTContratto2019DaoException e) {
			logger.error("Error when retrieve sigitTContratto2019DtoList: " + e);
			throw new SigitextException(errorString);
		} catch (SigitTAllegatoDaoException e) {
			logger.error("Error when retrieve sigitTAllegatoDtoList: " + e);
			throw new SigitextException(errorString);
		} catch (Exception e) {
			logger.error("Generic error: " + e);
			throw new SigitextException(errorString);
		}

		logger.debug("getElencoDocumenti END");
		return response;
	}

	private List<DocumentiAllegatiImpianto> createDocumentiReeImpianto(List<Integer> idAllegatoList)
			throws SigitTAllegatoDaoException, SigitextException {

		List<DocumentiAllegatiImpianto> response = new ArrayList<>();

		for (Integer idAllegato : idAllegatoList) {
			List<SigitTAllegatoDto> sigitTAllegatoDtoList = getDbServiceImp()
					.findSigitTAllegatoByIdAllegatoAndFkStatoRapp(new BigDecimal(idAllegato));
			logger.debug("sigitTAllegatoDtoList size: " + sigitTAllegatoDtoList.size());

			for (SigitTAllegatoDto allegato : sigitTAllegatoDtoList) {
				List<SigitTDocAllegatoDto> sigitTDocAllegatoDtoList = getDbServiceImp()
						.cercaElencoDocumentiPerIdAllegato(allegato.getIdAllegato().intValue());
				logger.debug("sigitTDocAllegatoDtoList size: " + sigitTDocAllegatoDtoList.size());

				for (SigitTDocAllegatoDto docAllegatoDto : sigitTDocAllegatoDtoList) {
					DocumentiAllegatiImpianto documentiReeImpianto = new DocumentiAllegatiImpianto();
					documentiReeImpianto.setIdDocAllegato(docAllegatoDto.getIdDocAllegato());
					documentiReeImpianto.setNomeDoc(docAllegatoDto.getNomeDocOriginale());
					documentiReeImpianto.setTipoDoc(ALTRA_DOCUMENTAZIONE);
					documentiReeImpianto.setDescrizione(docAllegatoDto.getDescrizione());
					documentiReeImpianto.setDataUpload(docAllegatoDto.getDataUpload());
					documentiReeImpianto.setUidIndex(docAllegatoDto.getUidIndex());
					documentiReeImpianto.setDataControllo(allegato.getDataControllo());
					documentiReeImpianto.setTipoREE(allegato.getFkTipoDocumento().toString());
					documentiReeImpianto.setStatoREE(allegato.getFkStatoRapp().intValue());
					documentiReeImpianto.setTipoComponente(allegato.getElencoApparecchiature());
					documentiReeImpianto.setStato(docAllegatoDto.getDataDelete() != null ? "CANCELLATO" : "ATTIVO");
					documentiReeImpianto.setDescrizioneTipoRee(getDbServiceImp()
							.getSigitDTipoDocumentoDescrizioneById(allegato.getFkTipoDocumento().intValue()));
					documentiReeImpianto.setDescrizioneStatoRee(getDbServiceImp()
							.getSigitDStatoRappDaoDesStatoRappById(allegato.getFkStatoRapp().intValue()));

					response.add(documentiReeImpianto);
				}
			}
		}

		return response;
	}

	private void createDocumentiAggiuntiviImpianto(ResponseGetElencoDocumenti response, List<SigitTDocAggiuntivaDto> sigitTDocAggiuntivaDtoList) throws SigitextException {
		for (SigitTDocAggiuntivaDto dto : sigitTDocAggiuntivaDtoList) {
			DocumentiAggiuntiviImpianto documentiAggiuntivi = new DocumentiAggiuntiviImpianto();
			documentiAggiuntivi.setIdDocAggiuntiva(dto.getIdDocAggiuntiva());
			documentiAggiuntivi.setNomeDoc(dto.getNomeDocOriginale());
			documentiAggiuntivi.setTipoDoc(ALTRA_DOCUMENTAZIONE);
			documentiAggiuntivi.setTipoDocDes(getDbServiceImp().getSigitDTipoDocumentoDescrizioneById(dto.getFkTipoDocagg().intValue()));
			documentiAggiuntivi.setDescrizione(dto.getDesAltroTipodoc());
			documentiAggiuntivi.setDataUpload(dto.getDataUpload());
			if (dto.getDataDelete() != null) {
				documentiAggiuntivi.setStato("CANCELLATO");
			} else {
				documentiAggiuntivi.setStato("ATTIVO");
			}
			documentiAggiuntivi.setUidIndex(dto.getUidIndex());

			response.getDocumentiAggiuntiviImpianto().add(documentiAggiuntivi);
		}
	}

	private void createDocumentiAssociatiContratto(ResponseGetElencoDocumenti response, List<SigitTContratto2019Dto> sigitTContratto2019DtoList) throws SigitTDocContrattoDaoException, SigitextException {
		for (SigitTContratto2019Dto contratto2019 : sigitTContratto2019DtoList) {
			List<SigitTDocContrattoDto> sigitTDocContrattoDtoList = getDbServiceImp().findSigitTDocContrattoByFkContratto(contratto2019.getIdContratto());
			logger.debug("sigitTDocContrattoDtoList size: " + sigitTDocContrattoDtoList.size());

			for (SigitTDocContrattoDto dto : sigitTDocContrattoDtoList) {

				DocumentiAssociatiContratto documentiAssociatiContratto = new DocumentiAssociatiContratto();
				documentiAssociatiContratto.setIdDocContratto(dto.getIdDocContratto().intValue());
				documentiAssociatiContratto.setNomeDoc(dto.getNomeDocOriginale());
				documentiAssociatiContratto.setTipoDoc(ALTRA_DOCUMENTAZIONE);
				documentiAssociatiContratto.setDescrizione(dto.getDescrizione());
				documentiAssociatiContratto.setDataUpload(dto.getDataUpload());
				if (dto.getDataDelete() != null) {
					documentiAssociatiContratto.setStato("CANCELLATO");
				} else {
					documentiAssociatiContratto.setStato("ATTIVO");
				}
				documentiAssociatiContratto.setUidIndex(dto.getUidIndex());
				documentiAssociatiContratto.setFkContratto(dto.getFkContratto().intValue());
				documentiAssociatiContratto.setDataInizio(contratto2019.getDataInizio());
				documentiAssociatiContratto.setDataFine(contratto2019.getDataFine());
				documentiAssociatiContratto.setFlgTacitoRinnovo(contratto2019.getFlgTacitoRinnovo().intValue());
				documentiAssociatiContratto.setDataCessazione(contratto2019.getDataCessazione());
				documentiAssociatiContratto.setMotivoCessazione(contratto2019.getMotivoCessazione());
				documentiAssociatiContratto.setFkTipoCessazione(contratto2019.getFkTipoCessazione());
				documentiAssociatiContratto.setDesTipoCessazione(getDbServiceImp().getTipoCessazioneById(contratto2019.getFkTipoCessazione()).getDes_tipo_cessazione());
				documentiAssociatiContratto.setNote(contratto2019.getNote());
				documentiAssociatiContratto.setFkPg3Resp(contratto2019.getFkPg3Resp().intValue());
				
				SigitTPersonaGiuridicaDto personaGiuridica = getDbServiceImp().cercaPersonaGiuridicaById(contratto2019.getFkPg3Resp());
				documentiAssociatiContratto.setDenominazione3Resp(personaGiuridica.getDenominazione());
				documentiAssociatiContratto.setCodiceFiscale3Resp(personaGiuridica.getCodiceFiscale());
				
				
				
				response.getDocumentiAssociatiContratto().add(documentiAssociatiContratto);
			}
		}
	}

	private void fillDocumentiAzioni(ResponseGetElencoDocumenti response, List<SigitTAzioneDto> sigitTAzioneDtoList)
			throws SigitTDocAzioneDaoException {
		for (SigitTAzioneDto azione : sigitTAzioneDtoList) {
			List<SigitTDocAzioneDto> sigitTDocAzioneDtoList = getDbServiceImp()
					.findSigitTDocAzioneByIdAzione(azione.getIdAzione());

			for (SigitTDocAzioneDto dto : sigitTDocAzioneDtoList) {
				DocumentiAzioni docAzioni = new DocumentiAzioni();

				docAzioni.setIdDocAzione(dto.getIdDocAzione());
				docAzioni.setNomeDoc(dto.getNomeDocOriginale());
				docAzioni.setTipoDoc(azione.getFkTipoAzione().toString());
				docAzioni.setDescrizione(azione.getDescrizioneAzione());
				docAzioni.setDataUpload(dto.getDataUltMod());
				docAzioni.setUidIndex(dto.getUidIndex());

				response.getDocumentiAzioni().add(docAzioni);
			}
		}
	}

	public Documento getDocumentoByUid(String uidIndex) throws SigitextException {
		Documento documento;
		try {
			documento = getServiceManager().getDocumentoByUid(uidIndex);
		} catch (Exception e) {
			logger.error("Error when try to retrieve Documento from index: " + e);
			throw new SigitextException("Error when try to retrieve Documento from index");
		}

		return documento;
	}

	public String deleteDocumento(String uidIndex) throws SigitextException {
		try {
			SigitTDocAggiuntivaDto docAggiuntivo = getDbServiceImp().findSigitTDocAggiuntivaByUidIndex(uidIndex);
			if (docAggiuntivo != null) {
				docAggiuntivo.setDataDelete(new Timestamp(System.currentTimeMillis()));
				docAggiuntivo.setDataUltMod(new Timestamp(System.currentTimeMillis()));
				getDbServiceImp().updateSigitTDocAggiuntivaColumnsAggiornaEliminaDoc(docAggiuntivo);

				return "OK";
			}

			SigitTDocAllegatoDto docAllegato = getDbServiceImp().findSigitTDocAllegatoByUidIndex(uidIndex);
			if (docAllegato != null) {
				docAllegato.setDataDelete(new Timestamp(System.currentTimeMillis()));
				docAllegato.setDataUltMod(new java.sql.Date(System.currentTimeMillis()));
				getDbServiceImp().updateSigitTDocAllegatoColumnsAggiornaEliminaDoc(docAllegato);

				return "OK";
			}

			SigitTDocContrattoDto docContratto = getDbServiceImp().findSigitTDocContrattoByUidIndex(uidIndex);
			if (docContratto != null) {
				docContratto.setDataDelete(new Date(System.currentTimeMillis()));
				docContratto.setDataUltMod(new Date(System.currentTimeMillis()));
				getDbServiceImp().updateSigitTDocContrattoColumnsAggiornaEliminaDoc(docContratto);

				return "OK";
			}

		} catch (Exception e) {
			logger.error("Error when try to retrieve Documento from index: " + e);
			throw new SigitextException("Error when try to retrieve Documento from index");
		}

		return "OK";
	}

	public List<SigitDTipoDocDto> getTipoDocumenti() throws SigitextException {
		try {
			return getDbServiceImp().getTipoDocumenti();
		} catch (Exception e) {
			logger.error("Error when try to retrieve Tipi documento");
			throw new SigitextException("Error when try to retrieve Tipi documento");
		}
	}

	public Accreditamento getDatiAccreditamento(String codiceFiscalePF) {
		String nomeMetodo = "--------- getDatiAccreditamento ---------";
		logger.debug(nomeMetodo + " - START");
		Accreditamento response = new Accreditamento();

		Persona persona = getDettaglioPersonaFisica(codiceFiscalePF);

		response.setPersona(persona);

		response.setDatiImpresaList(getDatiImpreseAssociate(codiceFiscalePF));

		List<DatiDelega> datiDelegaList = new ArrayList<>();
		List<DatiIncarico> datiIncaricoList = new ArrayList<>();
		for (DatiImpresa datiImpresa : response.getDatiImpresaList()) {
			datiDelegaList.addAll(getElencoDeleghe(datiImpresa.getId_persona_giuridica()));
			datiIncaricoList.addAll(getElencoIncarichi(datiImpresa.getId_persona_giuridica()));
		}

		response.setDatiDelegaList(datiDelegaList);
		response.setDatiIncaricoList(datiIncaricoList);

		logger.debug(nomeMetodo + " - END");
		return response;
	}

	public Persona getDettaglioPersonaFisica(String codiceFiscalePF) {
		String nomeMetodo = "--------- getDettaglioPersonaFisica ---------";
		logger.debug(nomeMetodo + " - START");

		try {
			List<SigitTPersonaFisicaDto> personeFisiche = getDbServiceImp()
					.cercaPersonaFisicaByCodiceFiscale(codiceFiscalePF);
			logger.debug("personeFisiche!= null: " + personeFisiche != null);
			logger.debug("personeFisiche.size(): " + personeFisiche.size());
			if (personeFisiche.size() == 1) {
				Persona persona = new Persona();

				persona.setIdPersona(personeFisiche.get(0).getIdPersonaFisica().intValue());
				persona.setTitolo(null);
				persona.setTipo(0);
				persona.setCodiceFiscale(personeFisiche.get(0).getCodiceFiscale());
				persona.setCognomeDenominazione(personeFisiche.get(0).getCognome());
				persona.setNome(personeFisiche.get(0).getNome());
				persona.setResidenzaEstera(personeFisiche.get(0).getFlgIndirizzoEstero() != null
						? personeFisiche.get(0).getFlgIndirizzoEstero().intValue()
						: 0);
				persona.setStradario((personeFisiche.get(0).getIndirizzoNonTrovato() != null
						&& !personeFisiche.get(0).getIndirizzoNonTrovato().isEmpty()) ? 1 : 0);
				persona.setIndirizzoSitad(personeFisiche.get(0).getIndirizzoSitad());
				persona.setIndirizzoNonTrovato(personeFisiche.get(0).getIndirizzoNonTrovato());
				persona.setComune(personeFisiche.get(0).getComune());
				persona.setProvincia(personeFisiche.get(0).getProvincia());
				persona.setCivico(personeFisiche.get(0).getCivico());
				persona.setCapEstero(personeFisiche.get(0).getCapEstero());
				persona.setStatoEstero(personeFisiche.get(0).getStatoEstero());
				persona.setCittaEstero(personeFisiche.get(0).getCittaEstero());
				persona.setIndirizzoEstero(personeFisiche.get(0).getIndirizzoEstero());
				persona.setDataInizioResp(null);
				persona.setEmail(personeFisiche.get(0).getEmail());
				persona.setAccreditato(personeFisiche.get(0).getFlgAccreditato());
				persona.setCap(personeFisiche.get(0).getCap());
				persona.setNewsletter(personeFisiche.get(0).getFlgNewsletter() != null
						? personeFisiche.get(0).getFlgNewsletter().intValue()
						: 0);
				persona.setGdpr(
						personeFisiche.get(0).getFlgGdpr() != null ? personeFisiche.get(0).getFlgGdpr().intValue() : 0);
				persona.setIstatComune(personeFisiche.get(0).getIstatComune());
				persona.setSiglaProv(personeFisiche.get(0).getSiglaProv());
				logger.debug(nomeMetodo + " - END");
				return persona;
			} else {
				logger.error("More than one SigitTPersonaFisicaDto found for codiceFiscale: " + codiceFiscalePF);
				logger.debug(nomeMetodo + END_WITH_ERROR);
				return null;
			}
		} catch (SigitextException e) {
			logger.error("Error when try to execute cercaPersonaFisicaByCodiceFiscale: " + e);
			logger.debug(nomeMetodo + END_WITH_ERROR);
			return null;
		}
	}

	private List<DatiImpresa> getDatiImpreseAssociate(String codiceFiscalePF) {
		String nomeMetodo = "--------- getDatiImpreseAssociate ---------";
		logger.debug(nomeMetodo + " - START");

		List<DatiImpresa> resultList = new ArrayList<>();

		try {
			List<SigitTPersonaGiuridicaDto> personaGiuridicaDtoList = getDbServiceImp()
					.getPersonaGiuridicaByCF(codiceFiscalePF);
			logger.debug("personaGiuridicaDtoList.size(): " + personaGiuridicaDtoList.size());

			for (SigitTPersonaGiuridicaDto dto : personaGiuridicaDtoList) {
				DatiImpresa datiImpresa = new DatiImpresa();

				logger.debug("dto.getIdPersonaGiuridica(): " + dto.getIdPersonaGiuridica());
				logger.debug("dto.getDenominazione(): " + dto.getDenominazione());
				logger.debug("dto.getSiglaRea(): " + dto.getSiglaRea());
				logger.debug("dto.getNumeroRea(): " + dto.getNumeroRea());
				logger.debug("dto.getCodiceFiscale(): " + dto.getCodiceFiscale());
				logger.debug("dto.getFkStatoPg(): " + dto.getFkStatoPg());

				datiImpresa.setId_persona_giuridica(dto.getIdPersonaGiuridica().intValue());
				datiImpresa.setDenominazione(dto.getDenominazione());
				datiImpresa.setSigla_rea(dto.getSiglaRea());
				datiImpresa.setNumero_rea(dto.getNumeroRea() != null ? dto.getNumeroRea().intValue() : null);
				datiImpresa.setCodice_fiscale(dto.getCodiceFiscale());
				datiImpresa.setFk_stato_pg(dto.getFkStatoPg());

				resultList.add(datiImpresa);
			}

			logger.debug(nomeMetodo + " - END");
			return resultList;
		} catch (SigitExcessiveResultsException | SigitExtDaoException e) {
			logger.error("Error when try to execute getPersonaGiuridicaByCF: " + e);
			logger.debug(nomeMetodo + END_WITH_ERROR);
			return new ArrayList<>();
		}
	}

	public List<DatiDelega> getElencoDeleghe(Integer id_persona_giuridica) {
		String nomeMetodo = "--------- getElencoDeleghe ---------";
		logger.debug(nomeMetodo + " - START");

		List<DatiDelega> resultList = new ArrayList<>();

		try {
			List<SigitTPersonaFisicaJoinSigitRPfDelegaDto> sigitTPersonaFisicaJoinSigitRPfDelegaDtoList = getDbServiceImp()
					.findSigitTPersonaFisicaJoinSigitRPfDelegaDtoByIdPersonaGiuridica(id_persona_giuridica);

			for (SigitTPersonaFisicaJoinSigitRPfDelegaDto dto : sigitTPersonaFisicaJoinSigitRPfDelegaDtoList) {
				DatiDelega datiDelega = new DatiDelega();

				datiDelega.setId_persona_fisica(dto.getId_persona_fisica().intValue());
				datiDelega.setId_persona_giuridic(dto.getId_persona_giuridica().intValue());
				datiDelega.setCognome(dto.getCognome());
				datiDelega.setNome(dto.getNome());
				datiDelega.setCodice_fiscale(dto.getCodice_fiscale());
				datiDelega.setData_inizio_legame(dto.getData_inizio());
				if (dto.getTipo_legame().contentEquals("A")) {
					datiDelega.setTipo_legame("Accreditato");
				} else if (dto.getTipo_legame().contentEquals("D")) {
					datiDelega.setTipo_legame("Delegato");
				}

				resultList.add(datiDelega);
			}

		} catch (SigitTPersonaFisicaDaoException e) {
			logger.error(
					"Error when try to execute findSigitTPersonaFisicaJoinSigitRPfDelegaDtoByIdPersonaGiuridica: " + e);

		}

		logger.debug(nomeMetodo + " - END");
		return resultList;
	}

	public List<DatiIncarico> getElencoIncarichi(Integer id_persona_giuridica) {
		String nomeMetodo = "--------- getElencoIncarichi ---------";
		logger.debug(nomeMetodo + " - START");

		List<DatiIncarico> resultList = new ArrayList<>();

		try {
			List<SigitTPersonaGiuridicaJoinSigitRPgPgNominaDto> sigitTPersonaGiuridicaJoinSigitRPgPgNominaDtoList = getDbServiceImp()
					.findSigitTPersonaGiuridicaJoinSigitRPgPgNominaDtoByIdPersonaGiuridicaImpresa(id_persona_giuridica);

			for (SigitTPersonaGiuridicaJoinSigitRPgPgNominaDto dto : sigitTPersonaGiuridicaJoinSigitRPgPgNominaDtoList) {
				DatiIncarico datiIncarico = new DatiIncarico();

				datiIncarico.setId_persona_giuridica_cat(dto.getId_persona_giuridica_cat().intValue());
				datiIncarico.setId_persona_giuridica_impresa(dto.getId_persona_giuridica_impresa().intValue());
				datiIncarico.setDenominazione(dto.getDenominazione());
				datiIncarico.setCodice_fiscale(dto.getCodice_fiscale());
				datiIncarico.setData_inizio_legame(dto.getData_inizio());
				datiIncarico.setData_fine_legame(dto.getData_fine());

				resultList.add(datiIncarico);
			}

		} catch (SigitExtDaoException e) {
			logger.error(
					"Error when try to execute findSigitTPersonaGiuridicaJoinSigitRPgPgNominaDtoByIdPersonaGiuridicaImpresa: "
							+ e);

		}
		logger.debug(nomeMetodo + " - END");
		return resultList;
	}

	public String setDatiPersonaliUtente(String codiceFiscalePF, Persona persona) throws SigitextException {

		SigitTPersonaFisicaDto dto = new SigitTPersonaFisicaDto();

		dto.setIdPersonaFisica(new BigDecimal(persona.getIdPersona()));
		dto.setNome(persona.getNome());
		dto.setCognome(persona.getCognomeDenominazione());
		dto.setCodiceFiscale(persona.getCodiceFiscale());
		dto.setFkL2(null);
		dto.setIndirizzoSitad(persona.getIndirizzoSitad());
		dto.setIndirizzoNonTrovato(persona.getIndirizzoNonTrovato());
		dto.setIstatComune(persona.getIstatComune());
		dto.setSiglaProv(persona.getSiglaProv());
		dto.setComune(persona.getComune());
		dto.setProvincia(persona.getProvincia());
		dto.setCivico(persona.getCivico());
		dto.setCap(persona.getCap());
		dto.setEmail(persona.getEmail());
		dto.setFlgAccreditato(persona.getAccreditato());
		dto.setDataUltMod(new Timestamp(System.currentTimeMillis()));
		dto.setUtenteUltMod(codiceFiscalePF);
		dto.setIndirizzoEstero(persona.getIndirizzoEstero());
		dto.setStatoEstero(persona.getStatoEstero());
		dto.setCittaEstero(persona.getCittaEstero());
		dto.setFlgIndirizzoEstero(new BigDecimal(persona.getResidenzaEstera()));
		dto.setCapEstero(persona.getCapEstero());
		dto.setFlgNewsletter(new BigDecimal(persona.getNewsletter()));
		dto.setFlgGdpr(new BigDecimal(persona.getGdpr()));

		getServiceManager().inserisciOAggiornaPersonaFisica(dto);

		return "OK";
	}

	public List<DatiImpresa> getDatiImpresa(String codiceFiscale, String siglaRea, Integer numeroRea)
			throws SigitextException {
		String nomeMetodo = "--------- getDatiImpresa ---------";
		logger.debug(nomeMetodo + " - START");

		List<DatiImpresa> resultList = new ArrayList<>();

		if (StringUtils.isNotBlank(codiceFiscale) || (StringUtils.isNotBlank(siglaRea) && numeroRea != null)) {

			BigDecimal numeroReaBigDecimal = null;
			if (numeroRea != null) {
				numeroReaBigDecimal = new BigDecimal(numeroRea);
			}

			List<SigitTPersonaGiuridicaDto> dtoList = getDbServiceImp().cercaPersonaGiuridica(codiceFiscale, siglaRea,
					numeroReaBigDecimal);
			logger.debug("dtoList.size(): " + dtoList.size());

			for (SigitTPersonaGiuridicaDto dto : dtoList) {

				try {
					createDatiImpresaList(resultList, dto);
				} catch (SigitExtDaoException e) {
					logger.debug("Impossible retireve desStatoPg for idStato: " + dto.getFkStatoPg());
				}
			}

		} else {
			logger.debug(
					"codiceFiscale or siglaRea not valid - codiceFiscale: " + codiceFiscale + " siglaRea: " + siglaRea);
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException("codiceFiscale or sgialRea and numberRea needed");
		}

		logger.debug(nomeMetodo + " - END");
		return resultList;
	}

	public List<DatiImpresa> getDatiImpresaDistributore(String codiceFiscale, String siglaRea, Integer numeroRea)
			throws SigitextException {
		String nomeMetodo = "--------- getDatiImpresa ---------";
		logger.debug(nomeMetodo + " - START");

		List<DatiImpresa> resultList = new ArrayList<>();

		if (StringUtils.isNotBlank(codiceFiscale) || (StringUtils.isNotBlank(siglaRea) && numeroRea != null)) {

			BigDecimal numeroReaBigDecimal = null;
			if (numeroRea != null) {
				numeroReaBigDecimal = new BigDecimal(numeroRea);
			}

			List<SigitTPersonaGiuridicaDto> dtoList = getDbServiceImp().cercaPersonaGiuridica(codiceFiscale, siglaRea,
					numeroReaBigDecimal);
			logger.debug("dtoList.size(): " + dtoList.size());

			for (SigitTPersonaGiuridicaDto dto : dtoList) {

				try {
					createDatiImpresaList(resultList, dto);
				} catch (SigitExtDaoException e) {
					logger.debug("Impossible retireve desStatoPg for idStato: " + dto.getFkStatoPg());
				}
			}

		} else {
			logger.debug(
					"codiceFiscale or siglaRea not valid - codiceFiscale: " + codiceFiscale + " siglaRea: " + siglaRea);
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException("codiceFiscale or sgialRea and numberRea needed");
		}

		logger.debug(nomeMetodo + " - END");
		return resultList;
	}
	
	private void createDatiImpresaList(List<DatiImpresa> resultList, SigitTPersonaGiuridicaDto dto)
			throws SigitExtDaoException {
		DatiImpresa datiImpresa = new DatiImpresa();

		datiImpresa.setId_persona_giuridica(dto.getIdPersonaGiuridica().intValue());
		datiImpresa.setDenominazione(dto.getDenominazione());
		datiImpresa.setSigla_rea(dto.getSiglaRea());
		datiImpresa.setNumero_rea(dto.getNumeroRea() != null ? dto.getNumeroRea().intValue() : null);
		datiImpresa.setCodice_fiscale(dto.getCodiceFiscale());
		datiImpresa.setFk_stato_pg(dto.getFkStatoPg());
		datiImpresa.setDesStato(getDbServiceImp().getSigitDStatoPgDescriptionByIdStato(dto.getFkStatoPg()));
		datiImpresa.setData_inizio_attivita(dto.getDataInizioAttivita());
		datiImpresa.setFlg_indirizzo_estero(
				dto.getFlgIndirizzoEstero() != null ? dto.getFlgIndirizzoEstero().intValue() : 0);
		datiImpresa.setStato_estero(dto.getStatoEstero());
		datiImpresa.setCitta_estero(dto.getCittaEstero());
		datiImpresa.setIndirizzo_estero(dto.getIndirizzoEstero());
		datiImpresa.setCap_estero(dto.getCapEstero());
		datiImpresa.setIndirizzo_sitad(dto.getIndirizzoSitad());
		datiImpresa.setComune(dto.getComune());
		datiImpresa.setCivico(dto.getCivico());
		datiImpresa.setCap(dto.getCap());
		datiImpresa.setSigla_prov(dto.getSiglaProv());
		datiImpresa.setProvincia(dto.getProvincia());
		datiImpresa.setStradario(StringUtils.isNotBlank(dto.getIndirizzoNonTrovato()) ? 1 : 0);
		datiImpresa.setIndirizzo_non_trovato(dto.getIndirizzoNonTrovato());
		datiImpresa.setEmail(dto.getEmail());
		datiImpresa.setPec(dto.getPec());
		datiImpresa.setTelefono(dto.getTelefono());
		datiImpresa.setFlg_dm37_letterac(dto.getFlgDm37Letterac() != null ? dto.getFlgDm37Letterac().intValue() : 0);
		datiImpresa.setFlg_dm37_letterad(dto.getFlgDm37Letterad() != null ? dto.getFlgDm37Letterad().intValue() : 0);
		datiImpresa.setFlg_dm37_letterae(dto.getFlgDm37Letterae() != null ? dto.getFlgDm37Letterae().intValue() : 0);
		datiImpresa.setFlg_fgas(dto.getFlgFgas() != null ? dto.getFlgFgas().intValue() : 0);
		datiImpresa.setFlg_conduttore(dto.getFlgConduttore() != null ? dto.getFlgConduttore().intValue() : 0);
		datiImpresa.setFlg_terzo_responsabile(
				dto.getFlgTerzoResponsabile() != null ? dto.getFlgTerzoResponsabile().intValue() : 0);
		datiImpresa.setFlg_cat(dto.getFlgCat() != null ? dto.getFlgCat().intValue() : 0);
		datiImpresa.setFlg_distributore(dto.getFlgDistributore() != null ? dto.getFlgDistributore().intValue() : 0);
		datiImpresa
				.setFlg_amministratore(dto.getFlgAmministratore() != null ? dto.getFlgAmministratore().intValue() : 0);
		datiImpresa
				.setFlg_sogg_incaricato(dto.getFlgSoggIncaricato() != null ? dto.getFlgSoggIncaricato().intValue() : 0);
		datiImpresa.setDelega_sogg_incaricato(dto.getDelegaSoggIncaricato());
		datiImpresa.setData_ult_mod(dto.getDataUltMod());
		datiImpresa.setUtente_ult_mod(dto.getUtenteUltMod());
		datiImpresa.setSigla_prov(dto.getSiglaProv());
		datiImpresa.setIstat_comune(dto.getIstatComune());
		datiImpresa.setData_cessazione(dto.getDataCessazione());
		datiImpresa.setDt_agg_dichiarazione(dto.getDtAggDichiarazione());
		datiImpresa.setDt_creazione_token(dto.getDtCreazioneToken());
		datiImpresa.setDt_scadenza_token(dto.getDtScadenzaToken());
		datiImpresa.setToken(dto.getToken());

		resultList.add(datiImpresa);
	}

	public Object getComponentiGeoportaleJWT(String coords, String tipoComponente, String tokenJWT) throws Exception {
		try {
			MvOdVistaDettaglioImpiantiDto filter = new MvOdVistaDettaglioImpiantiDto();
			String[] coordinate = coords.split(";");
			filter.setCoordXLongDd(new BigDecimal(coordinate[0]));
			filter.setCoordYLatDd(new BigDecimal(coordinate[1]));
			filter.setTipoComponente(tipoComponente);
			List<MvOdVistaDettaglioImpiantiDto> odVistaDettaglioImpiantiDtoArrayList = getDbServiceImp()
					.findComponentiByGeoPortale(filter);
			SigitLAccessoDto accessoDto = new SigitLAccessoDto();
			accessoDto.setDtAccesso(ConvertUtil.getSqlDataCorrente());
			accessoDto.setCodiceFiscale("ENERGIAPT");
			accessoDto.setRuolo("getComponentiGeoPortale");
			logger.info("EnergiaPT accessoDto : " + accessoDto.toString());
			dbServiceImp.inserisciAccesso(accessoDto);
			return odVistaDettaglioImpiantiDtoArrayList != null
					? mapToDettagliogeografico(odVistaDettaglioImpiantiDtoArrayList)
					: null;
		} catch (SigitextException e) {
			logger.error("[getComponentiGeoportaleJWT] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new Exception("Errore occorso nell'esecuzione del metodo:" + e, e);
		} finally {
			logger.debug("[SigitextImpl::getComponentiGeoportaleJWT] - END");
		}
	}

	private ArrayList<DettaglioGeograficoPortale> mapToDettagliogeografico(
			List<MvOdVistaDettaglioImpiantiDto> odVistaDettaglioImpiantiDtoArrayList) {
		ArrayList<DettaglioGeograficoPortale> dettaglioGeograficoPortales = new ArrayList<>();
		for (MvOdVistaDettaglioImpiantiDto odVistaDettaglioImpiantiDto : odVistaDettaglioImpiantiDtoArrayList) {
			String ubicazione = (odVistaDettaglioImpiantiDto.getIndirizzoUnitaImmob() != null
					? odVistaDettaglioImpiantiDto.getIndirizzoUnitaImmob()
					: "") + " "
					+ (odVistaDettaglioImpiantiDto.getCivico() != null ? odVistaDettaglioImpiantiDto.getCivico() : "")
					+ ", "
					+ (odVistaDettaglioImpiantiDto.getDenominazioneComune() != null
							? odVistaDettaglioImpiantiDto.getDenominazioneComune()
							: "")
					+ " ("
					+ (odVistaDettaglioImpiantiDto.getDenominazioneProvincia() != null
							? odVistaDettaglioImpiantiDto.getDenominazioneProvincia()
							: "")
					+ ")";

			DettaglioGeograficoPortale dettaglioGeograficoPortale = new DettaglioGeograficoPortale();
			dettaglioGeograficoPortale.setVolRiscM3(odVistaDettaglioImpiantiDto.getL12VolRiscM3() != null
					? odVistaDettaglioImpiantiDto.getL12VolRiscM3().toString()
					: "");
			dettaglioGeograficoPortale.setVolRaffM3(odVistaDettaglioImpiantiDto.getL12VolRaffM3() != null
					? odVistaDettaglioImpiantiDto.getL12VolRaffM3().toString()
					: "");
			dettaglioGeograficoPortale.setComponente(odVistaDettaglioImpiantiDto.getTipoComponente() != null
					? odVistaDettaglioImpiantiDto.getTipoComponente() + "-"
							+ odVistaDettaglioImpiantiDto.getProgressivo()
					: "");
			dettaglioGeograficoPortale.setPotClimaInv(odVistaDettaglioImpiantiDto.getL13PotClimaInvKw() != null
					? odVistaDettaglioImpiantiDto.getL13PotClimaInvKw().toString()
					: "");
			dettaglioGeograficoPortale.setPotClimaEst(odVistaDettaglioImpiantiDto.getL13PotClimaEstKw() != null
					? odVistaDettaglioImpiantiDto.getL13PotClimaEstKw().toString()
					: "");
			dettaglioGeograficoPortale.setImpianto(odVistaDettaglioImpiantiDto.getCodiceImpianto() != null
					? odVistaDettaglioImpiantiDto.getCodiceImpianto().toString()
					: "");
			dettaglioGeograficoPortale.setUbicazione(ubicazione);
			dettaglioGeograficoPortales.add(dettaglioGeograficoPortale);
		}
		return dettaglioGeograficoPortales;
	}

	public String setImpresaAssociata(String operation, String codiceFiscalePF, DatiImpresa datiImpresa) throws SigitextException, ValidationManagerException {
		String nomeMetodo = "--------- setImpresaAssociata ---------";
		logger.debug(nomeMetodo + " - START");

		if (StringUtils.isBlank(codiceFiscalePF)) {
			logger.error("S006 - codiceFiscalePF is null");
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException("S006 - codiceFiscalePF is null");
		} else if (datiImpresa == null) {
			logger.error("S006 - datiImpresa is null");
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException("S006 - datiImpresa is null");
		}

		getValidationManager().controlloCf(codiceFiscalePF, ConstantsField.GESTISCI_RESPONSABILE_CF);
		getValidationManager().checkCodiceFiscalePartitaIva(datiImpresa.getCodice_fiscale(), ConstantsField.GESTISCI_RESPONSABILE_CF);


		logger.debug("datiImpresa.getData_cessazione() " + datiImpresa.getData_cessazione());
		logger.debug("datiImpresa.getData_inizio_attivita() " + datiImpresa.getData_inizio_attivita());
		logger.debug("datiImpresa.getFlg_dm37_letterac() " + datiImpresa.getFlg_dm37_letterac());
		logger.debug("datiImpresa.getFlg_terzo_responsabile() " + datiImpresa.getFlg_terzo_responsabile());
		logger.debug("datiImpresa.getFlg_sogg_incaricato() " + datiImpresa.getFlg_sogg_incaricato());
		logger.debug("datiImpresa.getFlg_distributore() " + datiImpresa.getFlg_distributore());

		if (checkSetImpresaAssociataConditions(datiImpresa)){

			try {
				insertUpdatePersonaGiuridica(operation, codiceFiscalePF, datiImpresa);

			} catch (SigitExcessiveResultsException | SigitExtDaoException e) {
				logger.error("Error when try to retrieve sigitTPersonaGiuridicaList: " + e.getMessage());
				logger.debug(nomeMetodo + END_WITH_ERROR);
				throw new SigitextException(e.getMessage());
			} catch (SigitTPersonaGiuridicaDaoException e) {
				logger.error("Error when try to insert/update SigitTPersonaGiuridica: " + e.getMessage());
				logger.debug(nomeMetodo + END_WITH_ERROR);
				throw new SigitextException(e.getMessage());
			} catch (SigitRPfPgDelegaDaoException e) {
				logger.error("Error when try to insert SigitRPfPgDelega: " + e.getMessage());
				logger.debug(nomeMetodo + END_WITH_ERROR);
				throw new SigitextException(e.getMessage());
			} catch (SigitTStoricoVarStatoPgDaoException e) {
				logger.error("Error when try to insert SigitTStoricoVarStatoPg: " + e.getMessage());
				logger.debug(nomeMetodo + END_WITH_ERROR);
			}

		}

		logger.debug(nomeMetodo + " - END");
		return "OK";
	}

	private boolean checkSetImpresaAssociataConditions(DatiImpresa datiImpresa) {
		String nomeMetodo = "--------- checkSetImpresaAssociataConditions ---------";
		logger.debug(nomeMetodo + " - START");
		
		
		if(datiImpresa.getData_inizio_attivita() == null || datiImpresa.getData_inizio_attivita().after(new Date())) {
			logger.debug("check data_inizio_attivita: datiImpresa.getData_inizio_attivita() " + datiImpresa.getData_inizio_attivita());
			logger.debug(nomeMetodo + " - END");
			return false;
		}
		
		if(datiImpresa.getData_cessazione() != null) {
			if(datiImpresa.getData_cessazione().compareTo(datiImpresa.getData_inizio_attivita()) < 0) {
				logger.debug("check data_icessazione: datiImpresa.getData_cessazione() " + datiImpresa.getData_cessazione());
				logger.debug(nomeMetodo + " - END");
				return false;
			}
		}
		
		if(datiImpresa.getFlg_dm37_letterac() == 0 
			&& datiImpresa.getFlg_amministratore() == 0
			&& datiImpresa.getFlg_cat() == 0 
			&& datiImpresa.getFlg_terzo_responsabile() == 0
			&& datiImpresa.getFlg_sogg_incaricato() == 0 
			&& datiImpresa.getFlg_distributore() == 0) {
			logger.debug(nomeMetodo + " - END");
			return false;
		}
		
		logger.debug(nomeMetodo + " - END");
		return true;
	}
	
	private void insertUpdatePersonaGiuridica(String operation, String codiceFiscalePF, DatiImpresa datiImpresa) throws SigitExtDaoException, SigitExcessiveResultsException, SigitTPersonaGiuridicaDaoException, SigitextException, SigitRPfPgDelegaDaoException, SigitTStoricoVarStatoPgDaoException {
		String nomeMetodo = "--------- insertUpdatePersonaGiuridica ---------";
		logger.debug(nomeMetodo + " - START");
		BigDecimal numeroRea = datiImpresa.getNumero_rea() != null ? new BigDecimal(datiImpresa.getNumero_rea()): null;
		List<SigitTPersonaGiuridicaDto> sigitTPersonaGiuridicaList = getDbServiceImp().findSigitTPersonaGiuridicaaByCFAndCodiceRea(datiImpresa.getCodice_fiscale(), datiImpresa.getSigla_rea(), numeroRea);
		if (sigitTPersonaGiuridicaList.isEmpty()) {
			SigitTPersonaGiuridicaDto personaGiuridicaDto = new SigitTPersonaGiuridicaDto();

			createPersonaGiuridicaDto(codiceFiscalePF, datiImpresa, personaGiuridicaDto);
			SigitTPersonaGiuridicaPk sigitTPersonaGiuridicaPk = getDbServiceImp().insertSigitTPersonaGiuridicaDao(personaGiuridicaDto);

			insertSigitRPfPgDelega(codiceFiscalePF, datiImpresa, sigitTPersonaGiuridicaPk.getIdPersonaGiuridica());

			logger.debug("Insert SigitTStoricoVarStatoPgDto - START");
			SigitTStoricoVarStatoPgDto varStatoDto = new SigitTStoricoVarStatoPgDto();
			logger.debug("datiImpresa.getId_persona_giuridica() " + datiImpresa.getId_persona_giuridica());
			varStatoDto.setId_persona_giuridica(datiImpresa.getId_persona_giuridica() != null ? new BigDecimal(datiImpresa.getId_persona_giuridica()) : sigitTPersonaGiuridicaPk.getIdPersonaGiuridica());
			varStatoDto.setDt_evento(new java.sql.Timestamp(System.currentTimeMillis()));
			logger.debug("dt_evento: " + varStatoDto.getDt_evento());
			varStatoDto.setStato_pg_da(null);
			logger.debug("personaGiuridicaDto.getFkStatoPg() " + personaGiuridicaDto.getFkStatoPg());
			varStatoDto.setStato_pg_a(new BigDecimal(personaGiuridicaDto.getFkStatoPg()));
			varStatoDto.setMotivo("Primo caricamento sul CIT");
			logger.debug("datiImpresa.getData_inizio_attivita() " + datiImpresa.getData_inizio_attivita());
			varStatoDto.setDt_inizio_variazione(new java.sql.Date(datiImpresa.getData_inizio_attivita().getTime()));
			varStatoDto.setData_ult_mod(new Timestamp(System.currentTimeMillis()));
			varStatoDto.setUtente_ult_mod(codiceFiscalePF);
			getDbServiceImp().insertSigitTStoricoVarStatoPg(varStatoDto);
			logger.debug("Insert SigitTStoricoVarStatoPgDto - END");

		} else {

			//si potrebbe anche già controllare qui se sono caduto in update e l'operation é "insert" allora c'é già un Accreditato presente, 
			//verifico successivamente tramite le deleghe
			checkIfPersonaGiuridicaDtoNeedUpdate(operation, codiceFiscalePF, datiImpresa, sigitTPersonaGiuridicaList);

		}

		logger.debug(nomeMetodo + " - END");
	}

	private void checkIfPersonaGiuridicaDtoNeedUpdate(String operation, String codiceFiscalePF, DatiImpresa datiImpresa, List<SigitTPersonaGiuridicaDto> sigitTPersonaGiuridicaList) throws SigitRPfPgDelegaDaoException, SigitextException, SigitTPersonaGiuridicaDaoException, SigitTStoricoVarStatoPgDaoException {

		String nomeMetodo = "--------- checkIfPersonaGiuridicaDtoNeedUpdate ---------";
		logger.debug(nomeMetodo + " - START");

		for (SigitTPersonaGiuridicaDto personaGiuridicaDto : sigitTPersonaGiuridicaList) {
			// TODO Commentato il controllo dato che solo un utente accreditato può vedere
			// la sua impresa sulla PWA.

			/*
			 * Boolean delegaExist = false;
			 * 
			 * List<SigitRPfPgDelegaDto> pfPgDelegaList =
			 * getDbServiceImp().getSigitRPfPgDelegaDao().findFindByPg(personaGiuridicaDto.
			 * getIdPersonaGiuridica().intValue()); for (SigitRPfPgDelegaDto pfPgDelegaDto :
			 * pfPgDelegaList) { if (pfPgDelegaDto.getFlgDelega().equals("A")) { delegaExist
			 * = true; } if (Boolean.TRUE.equals(delegaExist)) { break; } }
			 * 
			 * if (Boolean.TRUE.equals(delegaExist)) {
			 * logger.error("Impresa già presente e con un utente accreditato attivo");
			 * logger.debug(nomeMetodo + END_WITH_ERROR); throw new
			 * SigitextException("Impresa già presente e con un utente accreditato attivo");
			 * } else {
			 * 
			 * updatePersonaGiuridica(codiceFiscalePF, datiImpresa, personaGiuridicaDto);
			 * 
			 * }
			 */
			updatePersonaGiuridica(operation, codiceFiscalePF, datiImpresa, personaGiuridicaDto);

		}

		logger.debug(nomeMetodo + " - END");
	}

	/**
	 * 
	 * @param operation "insert" or "update" , passato dal FE
	 * @param codiceFiscalePF
	 * @param datiImpresa
	 * @param personaGiuridicaDto
	 * @throws SigitTPersonaGiuridicaDaoException
	 * @throws SigitextException
	 * @throws SigitRPfPgDelegaDaoException
	 * @throws SigitTStoricoVarStatoPgDaoException
	 */
	private void updatePersonaGiuridica(String operation, String codiceFiscalePF, DatiImpresa datiImpresa, SigitTPersonaGiuridicaDto personaGiuridicaDto) throws SigitTPersonaGiuridicaDaoException, SigitextException, SigitRPfPgDelegaDaoException, SigitTStoricoVarStatoPgDaoException {
		String nomeMetodo = "--------- updatePersonaGiuridica ---------";
		logger.debug(nomeMetodo + " - START");
		
		logger.debug("personaGiuridicaDto.getDataCessazione(): " + personaGiuridicaDto.getDataCessazione());
		logger.debug("datiImpresa.getData_cessazione(): " + datiImpresa.getData_cessazione());

		Boolean dataCessazioneValorizzata = personaGiuridicaDto.getDataCessazione() == null && datiImpresa.getData_cessazione() != null;
		
		logger.debug("dataCessazioneValorizzata: " + dataCessazioneValorizzata);

		BigDecimal oldFkStatoPg = new BigDecimal(personaGiuridicaDto.getFkStatoPg());

		if (Boolean.TRUE.equals(dataCessazioneValorizzata)) {
			logger.debug("set personaGiuridica stato to CESSATO");
			personaGiuridicaDto.setFkStatoPg(2);
		} else {
			logger.debug("set personaGiuridica stato to ATTIVO");
			personaGiuridicaDto.setFkStatoPg(1);
		}
		logger.debug("personaGiuridicaDto.getFkStatoPg() " + personaGiuridicaDto.getFkStatoPg());
		
		List<SigitRPfPgDelegaDto> listDeleghe = getDbServiceImp().getSigitRPfPgDelegaDao().findFindByPg(personaGiuridicaDto.getIdPersonaGiuridica().intValue());
		if(listDeleghe != null) {
			for(Iterator<SigitRPfPgDelegaDto> i = listDeleghe.iterator(); i.hasNext();) {
				SigitRPfPgDelegaDto delega = i.next();
				if("A".equalsIgnoreCase(delega.getFlgDelega()) && "INSERT".equalsIgnoreCase(operation)) {
					throw new SigitextException("Impresa gia' presente e con un utente accreditato attivo. Richiedere la delega all'utente accreditato.");
				}
			}
		}
		
		createPersonaGiuridicaDto(codiceFiscalePF, datiImpresa, personaGiuridicaDto);
		getDbServiceImp().updateSigitTPersonaGiuridicaDao(personaGiuridicaDto);
		insertSigitRPfPgDelega(codiceFiscalePF, datiImpresa, personaGiuridicaDto.getIdPersonaGiuridica());

		if (Boolean.TRUE.equals(dataCessazioneValorizzata)) {
			logger.debug("Insert SigitTStoricoVarStatoPgDto - START");
			SigitTStoricoVarStatoPgDto varStatoDto = new SigitTStoricoVarStatoPgDto();
			logger.debug("personaGiuridicaDto.getIdPersonaGiuridica() " + personaGiuridicaDto.getIdPersonaGiuridica());
			varStatoDto.setId_persona_giuridica(personaGiuridicaDto.getIdPersonaGiuridica());
			varStatoDto.setDt_evento(new java.sql.Timestamp(System.currentTimeMillis()));
			logger.debug("dt_evento: " + varStatoDto.getDt_evento());
			logger.debug("oldFkStatoPg " + oldFkStatoPg);
			varStatoDto.setStato_pg_da(new BigDecimal(datiImpresa.getFk_stato_pg())); 
			logger.debug("datiImpresa.getFk_stato_pg() " + datiImpresa.getFk_stato_pg());
			varStatoDto.setStato_pg_a(new BigDecimal(2)); //setto lo stato dell'impresa a 2 (cessato) 
			varStatoDto.setMotivo("Cessazione impresa");
			logger.debug("datiImpresa.getData_cessazione() " + datiImpresa.getData_cessazione());
			if (datiImpresa.getData_cessazione() != null) {
				varStatoDto.setDt_inizio_variazione(new java.sql.Date(datiImpresa.getData_cessazione().getTime()));
			}
			varStatoDto.setUtente_ult_mod(codiceFiscalePF);
			varStatoDto.setData_ult_mod(new Timestamp(new java.util.Date().getTime()));
			getDbServiceImp().insertSigitTStoricoVarStatoPg(varStatoDto);
			logger.debug("Insert SigitTStoricoVarStatoPgDto - END");
		}

		logger.debug(nomeMetodo + " - END");
	}

	private void insertSigitRPfPgDelega(String codiceFiscalePF, DatiImpresa datiImpresa, BigDecimal idPersonaGiuridica)
			throws SigitextException, SigitRPfPgDelegaDaoException {
		String nomeMetodo = "--------- insertSigitRPfPgDelega ---------";
		logger.debug(nomeMetodo + " - START");

		SigitTPersonaFisicaDto personaFisica = getDbServiceImp().cercaPersonaFisicaByCodiceFiscale(codiceFiscalePF).get(0);

		SigitRPfPgDelegaDto delegaDto = new SigitRPfPgDelegaDto();

		delegaDto.setIdPersonaFisica(personaFisica.getIdPersonaFisica());
		delegaDto.setIdPersonaGiuridica(idPersonaGiuridica);
		delegaDto.setDataInizio(new java.sql.Date(System.currentTimeMillis()));
		delegaDto.setFkRuoloAccred(null);
		delegaDto.setFkTipoDm(null);
		delegaDto.setFlgDelega("A");
		delegaDto.setDataFine(null);
		delegaDto.setDataUltMod(new Timestamp(System.currentTimeMillis()));
		delegaDto.setUtenteUltMod(codiceFiscalePF);

		logger.debug("personaFisica.getIdPersonaFisica(): " + personaFisica.getIdPersonaFisica());
		logger.debug("idPersonaGiuridica: " + idPersonaGiuridica);

		List<SigitRPfPgDelegaDto> list = getDbServiceImp().findSigitRPfPgDelegaByPfAndPg(personaFisica.getIdPersonaFisica().intValue(), idPersonaGiuridica.intValue());

		if (list != null && !list.isEmpty()) {
			logger.debug("Non inserisco la delega in quanto gia esiste ma faccio l'update");
			getDbServiceImp().updateSigitRPfPgDelega(delegaDto);
			return;
		} else {
			logger.debug("Non esistono deleghe attive, la inserisco");
			getDbServiceImp().insertSigitRPfPgDelega(delegaDto);
		}

		logger.debug(nomeMetodo + " - END");
	}

	private void createPersonaGiuridicaDto(String codiceFiscalePF, DatiImpresa datiImpresa, SigitTPersonaGiuridicaDto personaGiuridicaDto) {
		String nomeMetodo = "--------- createPersonaGiuridicaDto ---------";
		logger.debug(nomeMetodo + " - START");
		
		logger.debug("personaGiuridicaDto.getFkStatoPg() " + personaGiuridicaDto.getFkStatoPg());
		if(personaGiuridicaDto.getFkStatoPg() == null) {
			logger.debug("Nuovo inserimento quindi metto lo stato a 1");
			personaGiuridicaDto.setFkStatoPg(1);
		}

		logger.debug("datiImpresa.getDenominazione() " + datiImpresa.getDenominazione());
		personaGiuridicaDto.setDenominazione(datiImpresa.getDenominazione());
		logger.debug("datiImpresa.getSigla_rea() " + datiImpresa.getSigla_rea());
		personaGiuridicaDto.setSiglaRea(datiImpresa.getSigla_rea());
		logger.debug("datiImpresa.getNumero_rea() " + datiImpresa.getNumero_rea());
		personaGiuridicaDto.setNumeroRea(datiImpresa.getNumero_rea() != null ? new BigDecimal(datiImpresa.getNumero_rea()) : null);
		logger.debug("datiImpresa.getCodice_fiscale() " + datiImpresa.getCodice_fiscale());
		personaGiuridicaDto.setCodiceFiscale(datiImpresa.getCodice_fiscale());
		logger.debug("datiImpresa.getData_inizio_attivita() " + datiImpresa.getData_inizio_attivita());
		personaGiuridicaDto.setDataInizioAttivita(datiImpresa.getData_inizio_attivita() != null ? new java.sql.Date(datiImpresa.getData_inizio_attivita().getTime()) : null);
		logger.debug("datiImpresa.getFlg_indirizzo_estero() " + datiImpresa.getFlg_indirizzo_estero());
		personaGiuridicaDto.setFlgIndirizzoEstero(datiImpresa.getFlg_indirizzo_estero() != null ? new BigDecimal(datiImpresa.getFlg_indirizzo_estero()) : null);
		logger.debug("datiImpresa.getStato_estero() " + datiImpresa.getStato_estero());
		personaGiuridicaDto.setStatoEstero(datiImpresa.getStato_estero());
		logger.debug("datiImpresa.getCitta_estero() " + datiImpresa.getCitta_estero());
		personaGiuridicaDto.setCittaEstero(datiImpresa.getCitta_estero());
		logger.debug("datiImpresa.getIndirizzo_estero() " + datiImpresa.getIndirizzo_estero());
		personaGiuridicaDto.setIndirizzoEstero(datiImpresa.getIndirizzo_estero());
		logger.debug("datiImpresa.getCap_estero() " + datiImpresa.getCap_estero());
		personaGiuridicaDto.setCapEstero(datiImpresa.getCap_estero());
		logger.debug("datiImpresa.getIndirizzo_sitad() " + datiImpresa.getIndirizzo_sitad());
		personaGiuridicaDto.setIndirizzoSitad(datiImpresa.getIndirizzo_sitad());
		logger.debug("datiImpresa.getComune() " + datiImpresa.getComune());
		personaGiuridicaDto.setComune(datiImpresa.getComune());
		logger.debug("datiImpresa.getCivico() " + datiImpresa.getCivico());
		personaGiuridicaDto.setCivico(datiImpresa.getCivico());
		logger.debug("datiImpresa.getCap() " + datiImpresa.getCap());
		personaGiuridicaDto.setCap(datiImpresa.getCap());
		logger.debug("datiImpresa.getSigla_prov() " + datiImpresa.getSigla_prov());
		personaGiuridicaDto.setSiglaProv(datiImpresa.getSigla_prov());
		logger.debug("datiImpresa.getIstat_comune() " + datiImpresa.getIstat_comune());
		personaGiuridicaDto.setIstatComune(datiImpresa.getIstat_comune());
		logger.debug("datiImpresa.getProvincia() " + datiImpresa.getProvincia());
		personaGiuridicaDto.setProvincia(datiImpresa.getProvincia());
		logger.debug("datiImpresa.getIndirizzo_non_trovato() " + datiImpresa.getIndirizzo_non_trovato());
		personaGiuridicaDto.setIndirizzoNonTrovato(datiImpresa.getIndirizzo_non_trovato());
		logger.debug("datiImpresa.getEmail() " + datiImpresa.getEmail());
		personaGiuridicaDto.setEmail(datiImpresa.getEmail());
		logger.debug("datiImpresa.getPec() " + datiImpresa.getPec());
		personaGiuridicaDto.setPec(datiImpresa.getPec());
		logger.debug("datiImpresa.getTelefono() " + datiImpresa.getTelefono());
		personaGiuridicaDto.setTelefono(datiImpresa.getTelefono());
		logger.debug("datiImpresa.getFlg_dm37_letterac() " + datiImpresa.getFlg_dm37_letterac());
		personaGiuridicaDto.setFlgDm37Letterac(datiImpresa.getFlg_dm37_letterac() != null ? new BigDecimal(datiImpresa.getFlg_dm37_letterac()) : null);
		logger.debug("datiImpresa.getFlg_dm37_letterad() " + datiImpresa.getFlg_dm37_letterad());
		personaGiuridicaDto.setFlgDm37Letterad(datiImpresa.getFlg_dm37_letterad() != null ? new BigDecimal(datiImpresa.getFlg_dm37_letterad()) : null);
		logger.debug("datiImpresa.getFlg_dm37_letterae() " + datiImpresa.getFlg_dm37_letterae());
		personaGiuridicaDto.setFlgDm37Letterae(datiImpresa.getFlg_dm37_letterae() != null ? new BigDecimal(datiImpresa.getFlg_dm37_letterae()) : null);
		logger.debug("datiImpresa.getFlg_fgas() " + datiImpresa.getFlg_fgas());
		personaGiuridicaDto.setFlgFgas(datiImpresa.getFlg_fgas() != null ? new BigDecimal(datiImpresa.getFlg_fgas()) : null);
		logger.debug("datiImpresa.getFlg_conduttore() " + datiImpresa.getFlg_conduttore());
		personaGiuridicaDto.setFlgConduttore(datiImpresa.getFlg_conduttore() != null ? new BigDecimal(datiImpresa.getFlg_conduttore()) : null);
		logger.debug("datiImpresa.getFlg_terzo_responsabile() " + datiImpresa.getFlg_terzo_responsabile());
		personaGiuridicaDto.setFlgTerzoResponsabile(datiImpresa.getFlg_terzo_responsabile() != null ? new BigDecimal(datiImpresa.getFlg_terzo_responsabile()) : null);
		logger.debug("datiImpresa.getFlg_cat() " + datiImpresa.getFlg_cat());
		personaGiuridicaDto.setFlgCat(datiImpresa.getFlg_cat() != null ? new BigDecimal(datiImpresa.getFlg_cat()) : null);
		logger.debug("datiImpresa.getFlg_distributore() " + datiImpresa.getFlg_distributore());
		personaGiuridicaDto.setFlgDistributore(datiImpresa.getFlg_distributore() != null ? new BigDecimal(datiImpresa.getFlg_distributore()) : null);
		logger.debug("datiImpresa.getFlg_amministratore() " + datiImpresa.getFlg_amministratore());
		personaGiuridicaDto.setFlgAmministratore(datiImpresa.getFlg_amministratore() != null ? new BigDecimal(datiImpresa.getFlg_amministratore()) : null);
		logger.debug("datiImpresa.getFlg_sogg_incaricato() " + datiImpresa.getFlg_sogg_incaricato());
		personaGiuridicaDto.setFlgSoggIncaricato(datiImpresa.getFlg_sogg_incaricato() != null ? new BigDecimal(datiImpresa.getFlg_sogg_incaricato()) : null);
		logger.debug("datiImpresa.getDelega_sogg_incaricato() " + datiImpresa.getDelega_sogg_incaricato());
		personaGiuridicaDto.setDelegaSoggIncaricato(datiImpresa.getDelega_sogg_incaricato());
		personaGiuridicaDto.setDataUltMod(new Timestamp(System.currentTimeMillis()));
		personaGiuridicaDto.setUtenteUltMod(codiceFiscalePF);
		logger.debug("datiImpresa.getData_cessazione() " + datiImpresa.getData_cessazione());
		personaGiuridicaDto.setDataCessazione(datiImpresa.getData_cessazione() != null ? new java.sql.Date(datiImpresa.getData_cessazione().getTime()) : null);
		personaGiuridicaDto.setDtAggDichiarazione(new Timestamp(System.currentTimeMillis()));

		logger.debug(nomeMetodo + " - END");
	}

	public String setDelega(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersona)
			throws SigitextException {
		logger.debug("setDelega - START");

		try {
			List<SigitRPfPgDelegaDto> sigitRPfPgDelegaList = getDbServiceImp().findSigitRPfPgDelegaByPfAndPg(idPersona,
					idPersonaGiuridica);

			logger.debug("sigitRPfPgDelegaList.size(): " + sigitRPfPgDelegaList.size());

			if (!sigitRPfPgDelegaList.isEmpty()) {
				logger.error("SigitRPfPgDelega already exist for idPersonaFisica " + idPersona
						+ " and idPersonaGiuridica " + idPersonaGiuridica);
				logger.debug("setDelega - END WITH ERROR");
				throw new SigitextException("S079");
			} else {
				SigitRPfPgDelegaDto dto = new SigitRPfPgDelegaDto();

				dto.setIdPersonaFisica(new BigDecimal(idPersona));
				dto.setIdPersonaGiuridica(new BigDecimal(idPersonaGiuridica));
				dto.setDataInizio(new java.sql.Date(System.currentTimeMillis()));
				dto.setFkRuoloAccred(null);
				dto.setFkTipoDm(null);
				dto.setFlgDelega("D");
				dto.setDataFine(null);
				dto.setDataUltMod(new Timestamp(System.currentTimeMillis()));
				dto.setUtenteUltMod(codiceFiscalePF);

				getDbServiceImp().insertSigitRPfPgDelega(dto);
			}

		} catch (SigitRPfPgDelegaDaoException e) {
			logger.error("Error when try to retrieve sigitRPfPgDelegaList: " + e);
			logger.debug("setDelega - END WITH ERROR");
			throw new SigitextException(e.getMessage());
		}
		logger.debug("setDelega - END");
		return "OK";
	}

	public String deleteDelega(UtenteLoggato utenteLoggato, Integer idPersona) throws SigitextException {
		logger.debug("deleteDelega - START");

		try {
			List<SigitRPfPgDelegaDto> sigitRPfPgDelegaList = getDbServiceImp()
					.findSigitRPfPgDelegaByIdPersonaFisica(idPersona);

			if (sigitRPfPgDelegaList.isEmpty()) {
				logger.error("Persona fisica non delegata o accreditata idPersonaFisica " + idPersona);
				logger.debug("deleteDelega - END WITH ERROR");
				throw new SigitextException("S080");
			} else {
				for (SigitRPfPgDelegaDto dto : sigitRPfPgDelegaList) {
					if (dto.getFlgDelega().contentEquals("A")) {
						if (utenteLoggato.getRuoloLoggato() != null
								&& utenteLoggato.getRuoloLoggato().getRuolo() != null
								&& (utenteLoggato.getRuoloLoggato().getRuolo().equalsIgnoreCase("SUP")
										|| utenteLoggato.getRuoloLoggato().getRuolo().equalsIgnoreCase("VAL")
										|| utenteLoggato.getRuoloLoggato().getRuolo().equalsIgnoreCase("ISP"))) {
							logger.error("UtenteLoggato con cf " + utenteLoggato.getPfLoggato().getCodiceFiscalePF()
									+ " non ha il ruolo adeguato, il suo ruolo é "
									+ utenteLoggato.getRuoloLoggato().getRuolo());
							logger.debug("deleteDelega - END WITH ERROR");
							throw new SigitextException("S081");
						} else {
							logger.debug("deleteDelega - END");
							return "C001";
						}
					}
				}
			}

		} catch (SigitRPfPgDelegaDaoException e) {
			logger.error("Error when try to retrieve sigitRPfPgDelegaList: " + e);
			logger.debug("deleteDelega - END WITH ERROR");
			throw new SigitextException(e.getMessage());
		}
		logger.debug("deleteDelega - END");
		return "OK";
	}

	public String deleteDelegaConfirm(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersona)
			throws SigitextException {
		logger.debug("deleteDelegaConfirm - START");

		try {
			List<SigitRPfPgDelegaDto> sigitRPfPgDelegaList = getDbServiceImp().findSigitRPfPgDelegaByPfAndPg(idPersona,
					idPersonaGiuridica);

			if (sigitRPfPgDelegaList.isEmpty()) {
				logger.error("SigitRPfPgDelega not found idPersonaFisica " + idPersona + " and idPersonaGiuridica "
						+ idPersonaGiuridica);
				logger.debug("deleteDelegaConfirm - END WITH ERROR");
				throw new SigitextException("SigitRPfPgDelega not found idPersonaFisica " + idPersona
						+ " and idPersonaGiuridica " + idPersonaGiuridica);
			} else {
				for (SigitRPfPgDelegaDto dto : sigitRPfPgDelegaList) {
					dto.setDataFine(new java.sql.Date(System.currentTimeMillis()));
					dto.setDataUltMod(new Timestamp(System.currentTimeMillis()));
					dto.setUtenteUltMod(codiceFiscalePF);

					getDbServiceImp().updateSigitRPfPgDelega(dto);
				}
			}

		} catch (SigitRPfPgDelegaDaoException e) {
			logger.error("Error when try to retrieve sigitRPfPgDelegaList: " + e);
			logger.debug("deleteDelegaConfirm - END WITH ERROR");
			throw new SigitextException(e.getMessage());
		}
		logger.debug("deleteDelegaConfirm - END");
		return "I011";
	}

	public List<IncarichiSoggettiDelegatiResponse> getIncarichiSoggettiDelegati() throws SigitextException {
		String nomeMetodo = "--------- getIncarichiSoggettiDelegati ---------";
		logger.debug(nomeMetodo + " - START");

		List<IncarichiSoggettiDelegatiResponse> incarichiList = new ArrayList<>();

		try {
			List<Map<String, Object>> dbResultList = getDbServiceImp().getIncarichiSoggettiDelegati();

			for (Map<String, Object> m : dbResultList) {

				logger.debug("id_persona_giuridica: " + m.get("id_persona_giuridica"));
				logger.debug("denominazione: " + m.get("denominazione"));

				IncarichiSoggettiDelegatiResponse incarico = new IncarichiSoggettiDelegatiResponse();
				incarico.setIdPersonaGiuridica(((BigDecimal) m.get("id_persona_giuridica")).intValue());
				incarico.setDenominazione((String) m.get("denominazione"));
				incarichiList.add(incarico);
			}

		} catch (SigitExcessiveResultsException | SigitExtDaoException e) {
			logger.error("Error when try to retrieve getIncarichiSoggettiDelegati: " + e.getMessage());
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException(e.getMessage());
		}

		logger.debug(nomeMetodo + " - END");
		return incarichiList;
	}

	public String setIncaricoSoggettoDelegato(String codiceFiscalePF, Integer idPersonaGiuridica,
			Integer idPersonaGiuridicaCat) throws SigitextException {
		logger.debug("setIncaricoSoggettoDelegato - START");

		try {
			List<SigitRPgPgNominaDto> sigitRPgPgNominaDtoList = getDbServiceImp()
					.getSigitRPgPgNominaByIdPersonaGiuridicaCatAndIdPersonaGiuridica(idPersonaGiuridicaCat,
							idPersonaGiuridica);

			if (!sigitRPgPgNominaDtoList.isEmpty()) {
				logger.error("SigitRPgPgNomina already exist for idPersonaGiuridicaCat " + idPersonaGiuridicaCat);
				logger.debug("setIncaricoSoggettoDelegato - END WITH ERROR");
				throw new SigitextException("S128");
			} else {
				SigitRPgPgNominaDto dto = new SigitRPgPgNominaDto();

				dto.setIdPersonaGiuridicaCat(new BigDecimal(idPersonaGiuridicaCat));
				dto.setIdPersonaGiuridicaImpresa(new BigDecimal(idPersonaGiuridica));
				dto.setDataInizio(new java.sql.Date(System.currentTimeMillis()));
				dto.setDataFine(null);
				dto.setDataUltimaModifica(new java.sql.Date(System.currentTimeMillis()));
				dto.setUtenteUltimaModifica(codiceFiscalePF);

				getDbServiceImp().insertSigitRPgPgNomina(dto);

				SigitTPersonaGiuridicaDto personaGiuridica = getDbServiceImp()
						.cercaPersonaGiuridicaById(new BigDecimal(idPersonaGiuridica));
				SigitTPersonaGiuridicaDto personaGiuridicaCat = getDbServiceImp()
						.cercaPersonaGiuridicaById(new BigDecimal(idPersonaGiuridicaCat));

				String mailObject = "CIT: Assegnazione incarico a Soggetto Delegato";
				StringBuilder bodyHtml = new StringBuilder();

				bodyHtml.append("L'impresa<br/>");
				bodyHtml.append(personaGiuridica.getDenominazione() + "<br/>");
				bodyHtml.append(personaGiuridica.getCodiceFiscale() + "<br/>");
				bodyHtml.append(personaGiuridica.getSiglaRea() + personaGiuridica.getNumeroRea() + "<br/>");
				bodyHtml.append("ha assegnato incarico al Soggetto Delegato<br/>");
				bodyHtml.append(personaGiuridicaCat.getDenominazione() + "<br/>");
				bodyHtml.append(personaGiuridicaCat.getCodiceFiscale() + "<br/>");
				bodyHtml.append(personaGiuridicaCat.getSiglaRea() + personaGiuridicaCat.getNumeroRea() + "<br/>");
				bodyHtml.append("per operare sul CIT per conto suo");

				ArrayList<String> mailAddress = new ArrayList<>();
				logger.debug("personaGiuridica.getEmail(): " + personaGiuridica.getEmail());
				logger.debug("personaGiuridicaCat.getEmail(): " + personaGiuridicaCat.getEmail());
				mailAddress.add(personaGiuridica.getEmail());
				mailAddress.add(personaGiuridicaCat.getEmail());

				getServiceManager().sendMail(null, mailAddress, mailObject, bodyHtml.toString(), bodyHtml.toString());
			}

		} catch (SigitRPgPgNominaDaoException | ServiceException e) {
			logger.error("Error when try to retrieve sigitRPfPgDelegaList: " + e);
			logger.debug("setIncaricoSoggettoDelegato - END WITH ERROR");
			throw new SigitextException(e.getMessage());
		}
		logger.debug("setIncaricoSoggettoDelegato - END");
		return "OK";
	}

	public String deleteIncaricoSoggettoDelegato(String codiceFiscalePF, Integer idPersonaGiuridica,
			Integer idPersonaGiuridicaCat) throws SigitextException {
		logger.debug("deleteIncaricoSoggettoDelegato - START");

		try {
			List<SigitRPgPgNominaDto> sigitRPgPgNominaDtoList = getDbServiceImp()
					.getSigitRPgPgNominaByIdPersonaGiuridicaCat(idPersonaGiuridicaCat);

			if (sigitRPgPgNominaDtoList.isEmpty()) {
				logger.error("SigitRPgPgNomina not exist for idPersonaGiuridicaCat " + idPersonaGiuridicaCat);
				logger.debug("deleteIncaricoSoggettoDelegato - END WITH ERROR");
				throw new SigitextException("S080");
			} else {
				SigitRPgPgNominaDto dto = new SigitRPgPgNominaDto();

				dto.setIdPersonaGiuridicaCat(new BigDecimal(idPersonaGiuridicaCat));
				dto.setIdPersonaGiuridicaImpresa(new BigDecimal(idPersonaGiuridica));
				dto.setDataFine(new java.sql.Date(System.currentTimeMillis()));
				dto.setDataUltimaModifica(new java.sql.Date(System.currentTimeMillis()));
				dto.setUtenteUltimaModifica(codiceFiscalePF);

				getDbServiceImp().updateSigitRPgPgNomina(dto);

				SigitTPersonaGiuridicaDto personaGiuridica = getDbServiceImp()
						.cercaPersonaGiuridicaById(new BigDecimal(idPersonaGiuridica));
				SigitTPersonaGiuridicaDto personaGiuridicaCat = getDbServiceImp()
						.cercaPersonaGiuridicaById(new BigDecimal(idPersonaGiuridicaCat));

				String mailObject = "CIT: Cessazione incarico a Soggetto Delegato";
				StringBuilder bodyHtml = new StringBuilder();

				bodyHtml.append("L'impresa<br/>");
				bodyHtml.append(personaGiuridica.getDenominazione() + "<br/>");
				bodyHtml.append(personaGiuridica.getCodiceFiscale() + "<br/>");
				bodyHtml.append(personaGiuridica.getSiglaRea() + personaGiuridica.getNumeroRea() + "<br/>");
				bodyHtml.append("ha cessato l'incarico al Soggetto Delegato<br/>");
				bodyHtml.append(personaGiuridicaCat.getDenominazione() + "<br/>");
				bodyHtml.append(personaGiuridicaCat.getCodiceFiscale() + "<br/>");
				bodyHtml.append(personaGiuridicaCat.getSiglaRea() + personaGiuridicaCat.getNumeroRea() + "<br/>");
				bodyHtml.append("per operare sul CIT per conto suo");

				ArrayList<String> mailAddress = new ArrayList<>();
				logger.debug("personaGiuridica.getEmail(): " + personaGiuridica.getEmail());
				logger.debug("personaGiuridicaCat.getEmail(): " + personaGiuridicaCat.getEmail());
				mailAddress.add(personaGiuridica.getEmail());
				mailAddress.add(personaGiuridicaCat.getEmail());

				getServiceManager().sendMail(null, mailAddress, mailObject, bodyHtml.toString(), bodyHtml.toString());
			}

		} catch (SigitRPgPgNominaDaoException | ServiceException e) {
			logger.error("Error when try to retrieve sigitRPfPgDelegaList: " + e);
			logger.debug("deleteIncaricoSoggettoDelegato - END WITH ERROR");
			throw new SigitextException(e.getMessage());
		}
		logger.debug("deleteIncaricoSoggettoDelegato - END");
		return "OK";
	}

	public String sendEmailProva(String emailAddress) throws SigitextException {
		String nomeMetodo = "--------- sendEmailProva ---------";
		logger.debug(nomeMetodo + " - START");

		try {

			String object = "Registrazione al CIT: conferma indirizzo e-mail";

			StringBuilder testoHtml = new StringBuilder();
			testoHtml.append("CIT - Catasto degli Impianti Termici, indirizzo e-mail scritto correttamente; tutte le notifiche future saranno mandate a questo indirizzo.<br/>");
			testoHtml.append("Si ricorda di eseguire il salvataggio dell'informazione a video.<br/><br>");
			testoHtml.append("N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa email");

			getServiceManager().sendMail(emailAddress, object, testoHtml.toString(), testoHtml.toString());
		} catch (ServiceException e) {
			logger.error("Error when try to send email: " + e.getMessage());
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException(e.getMessage());
		} catch (Exception e) {
			logger.error("Error when try to retrieve email config: " + e.getMessage());
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException(e.getMessage());
		}
		logger.debug(nomeMetodo + " - END");
		return "OK";
	}

	public List<SigitTVerificaDto> getElencoVerifiche(RicercaDatiVerifica datiVerifica) throws SigitextException {
		String nomeMetodo = "getElencoVerifiche";
		logger.debug(nomeMetodo + " - START");

		List<SigitTVerificaDto> response = new ArrayList<>();

		try {

			List<SigitTVerificaDto> listSigitTVerificaDto = getDbServiceImp().getElencoVerifiche(datiVerifica);
			
			if(listSigitTVerificaDto==null) {
				return new ArrayList<>();
			}
			
			logger.debug("listSigitTVerificaDto - "+listSigitTVerificaDto.size());
			if (new BigDecimal(listSigitTVerificaDto.size()).compareTo(dbIspezioneMgr.getMaxRigheRicAvzImp()) > 0) {
				throw new BadRequestException("La ricerca ha prodotto troppi risultati. Inserire criteri di ricerca piu' restrittivi e riprovare.");
			}
			
			response = listSigitTVerificaDto;

		} catch (SigitextException | SigitTIspezione2018DaoException e) {
			logger.error("Error when try to retrieve getElencoVerifiche: " + e.getMessage());
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException(e.getMessage());
		}

		logger.debug(nomeMetodo + " - END");
		return response;
	}

	public DatiDistributore getDistributore(Integer idDatoDistrib) throws SigitextException {
		String nomeMetodo = "getDistributore";
		logger.debug(nomeMetodo + " - START");

		DatiDistributore response = new DatiDistributore();

		try {
			
			
			DatiDistributore datiDistributore = getDbServiceImp().getDistributore(idDatoDistrib);
			if(datiDistributore!=null) {
				SigitTImpiantoDto sigitTImpiantoDto = getDbServiceImp().getSigitTImpiantoDao().findByIstatComune(datiDistributore.getIstatComuneFatt());
				if(sigitTImpiantoDto!=null) {
					datiDistributore.setIstatComuneFatt(sigitTImpiantoDto.getDenominazioneComune());
				}
				response = datiDistributore;
			}
			

		} catch (SigitextException e) {
			logger.error("Error when try to retrieve getDistributore: " + e.getMessage());
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException(e.getMessage());
		} catch (DaoException e) {
			logger.error("Error when try to retrieve getDistributore: " + e.getMessage());
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException(e.getMessage());
		}

		logger.debug(nomeMetodo + " - END");
		return response;
	}

	public String setVerifica(Verifica verifica, UtenteLoggatoModel utenteLoggatoModel) throws SigitextException {
		String nomeMetodo = "setVerifica";
		logger.debug(nomeMetodo + " - START");

		String response = "OK";

		try {

			Persona persona = getDettaglioPersonaFisica(verifica.getCfUtenteCaricamento());

			if (persona != null) {
				utenteLoggatoModel.setDenominazione(persona.getCognomeDenominazione() + " " + persona.getNome());
			}

			response = getServiceManager().salvaVerifica(verifica, utenteLoggatoModel);

		} catch (SigitextException e) {
			logger.error("Error when try to retrieve setVerifica: " + e.getMessage());
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException(e.getMessage());
		}

		logger.debug(nomeMetodo + " - END");
		return response;
	}

	public String setVerificaMassiva(VerificaMassiva verifica, Integer flgIspPagamento)
			throws SigitextException {
		String nomeMetodo = "setVerificaMassiva";
		logger.debug(nomeMetodo + " - START");

		String response = "OK";

		try {

			response = getServiceManager().salvaVerificaMassiva(verifica.getVerifica(), flgIspPagamento, verifica.getUtenteLoggatoModel());

		} catch (SigitextException e) {
			logger.error("Error when try to retrieve setVerificaMassiva: " + e.getMessage());
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException(e.getMessage());
		}

		logger.debug(nomeMetodo + " - END");
		return response;
	}

	public DettaglioVerifica getDettaglioVerifica(Integer idVerifica) throws SigitextException {

		String nomeMetodo = "getDettaglioVerifica";
		logger.debug(nomeMetodo + " - START");

		DettaglioVerifica response = new DettaglioVerifica();

		try {

			response = getServiceManager().getDettaglioVerifica(idVerifica);

		} catch (SigitextException e) {
			logger.error("Error when try to retrieve getDettaglioVerifica: " + e.getMessage());
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException(e.getMessage());
		}

		logger.debug(nomeMetodo + " - END");
		return response;

	}

	public String deleteVerifica(Integer idVerifica) throws SigitextException {

		String nomeMetodo = "deleteVerifica";
		logger.debug(nomeMetodo + " - START");

		String response = "OK";

		try {

			response = getServiceManager().deleteVerifica(idVerifica);

		} catch (SigitextException e) {
			logger.error("Error when try to retrieve deleteVerifica: " + e.getMessage());
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException(e.getMessage(), e);
		}

		logger.debug(nomeMetodo + " - END");
		return response;

	}

	public Controlli getControllo(String siglaRee, Long numeroRee) throws SigitextException {

		String nomeMetodo = "getControllo";
		logger.debug(nomeMetodo + " - START");

		Controlli response = new Controlli();

		try {

			response = getServiceManager().getControllo(siglaRee, numeroRee);

		} catch (SigitextException e) {
			logger.error("Error when try to retrieve getControllo: " + e.getMessage());
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException(e.getMessage());
		}

		logger.debug(nomeMetodo + " - END");
		return response;

	}

	public List<Assegnatario> getAssegnatario() throws SigitextException {

		String nomeMetodo = "getAssegnatario";
		logger.debug(nomeMetodo + " - START");

		List<Assegnatario> response = new ArrayList<>();

		try {

			response = getServiceManager().getAssegnatario();

		} catch (SigitextException e) {
			logger.error("Error when try to retrieve getIspettori: " + e.getMessage());
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException(e.getMessage());
		}

		logger.debug(nomeMetodo + " - END");
		return response;

	}

	public List<String> getSiglaRee() throws SigitextException {

		String nomeMetodo = "getSiglaRee";
		logger.debug(nomeMetodo + " - START");

		List<String> response = new ArrayList<>();

		try {

			response = getServiceManager().getSiglaRee();

		} catch (SigitextException e) {
			logger.error("Error when try to retrieve getSiglaRee: " + e.getMessage());
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException(e.getMessage());
		}

		logger.debug(nomeMetodo + " - END");
		return response;

	}

	public List<SigitTAzioneDto> getAzione(Integer idVerifica, Integer idAccertamento, Integer idIspezione2018)
			throws SigitextException {

		String nomeMetodo = "getAzione";
		logger.debug(nomeMetodo + " - START");

		List<SigitTAzioneDto> response = new ArrayList<>();

		try {

			response = getServiceManager().getAzione(idVerifica, idAccertamento, idIspezione2018);

		} catch (SigitextException e) {
			logger.error("Error when try to retrieve getSiglaRee: " + e.getMessage());
			logger.debug(nomeMetodo + END_WITH_ERROR);
			throw new SigitextException(e.getMessage());
		}

		logger.debug(nomeMetodo + " - END");
		return response;

	}

	public ResponseGetDettaglioNomina getDettaglioNomina(Integer idContratto, Integer codiceImpianto)
			throws SigitextException, SigitRComp4ManutDaoException {
		String nomeMetodo = "--------- getDettaglioNomina ---------";
		logger.debug(nomeMetodo + " - START");

		ResponseGetDettaglioNomina response = new ResponseGetDettaglioNomina();

		try {
			setDatiImpresaToResponseGetDettaglioNomina(idContratto, codiceImpianto, response);

			setDatiContrattoToResponseGetDettaglioNomina(idContratto, response);

			setDatiImpiantoToResponseGetDettaglioNomina(codiceImpianto, response);

			setPersonaToResponseGetDettaglioNomina(response, idContratto);

			setAutodichiarazioneToResponseGetDettaglioNomina(idContratto, response);

			setDatiAffidamentoToResponseGetDettaglioNomina(idContratto, codiceImpianto, response);

		} catch (SigitTContratto2019DaoException e) {
			logger.debug("Error when try to retrieve SigitTContratto2019: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitRImpRuoloPfpgDaoException e) {
			logger.debug("Error when try to retrieve SigitRImpRuoloPfpg: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		}

		logger.debug(nomeMetodo + " - END");
		return response;
	}

	private void setAutodichiarazioneToResponseGetDettaglioNomina(Integer idContratto,
			ResponseGetDettaglioNomina response) throws SigitextException {
		String nomeMetodo = "--------- setAutodichiarazioneToResponseGetDettaglioNomina ---------";
		logger.debug(nomeMetodo + " - START");

		List<SigitRContr2019AutodichiarDto> rContr2019List = getDbServiceImp().getSigitRContr2019AutodichiarByIdContratto(idContratto);

		for (SigitRContr2019AutodichiarDto rContr2019 : rContr2019List) {

			String desAutodichiarazione = getDbServiceImp().getSigitDAutodichiarazioneDesById(rContr2019.getId_autodichiarazione());

			Autodichiarazione autodichiarazione = new Autodichiarazione();

			autodichiarazione.setIdContratto(rContr2019.getId_contratto());
			autodichiarazione.setIdAutodichiarazione(rContr2019.getId_autodichiarazione());
			autodichiarazione.setDesAutodichiarazione(desAutodichiarazione);
			autodichiarazione.setFlgNominaCessa(rContr2019.getFlg_nomina_cessa());

			response.getAutodichiarazione().add(autodichiarazione);
		}

		logger.debug(nomeMetodo + " - END");
	}

	private void setDatiAffidamentoToResponseGetDettaglioNomina(Integer idContratto, Integer codiceImpianto,
			ResponseGetDettaglioNomina response) throws SigitTContratto2019DaoException, SigitextException, SigitRComp4ManutDaoException {
		String nomeMetodo = "--------- setDatiAffidamentoToResponseGetDettaglioNomina ---------";
		logger.debug(nomeMetodo + " - START");

		SigitTContratto2019Dto contratto2019 = getDbServiceImp().findSigitTContratto2019ByIdContratto(idContratto);

		CompFilter filter = new CompFilter();
		filter.setCodImpianto(codiceImpianto);
		filter.setNotIdPG(contratto2019.getFkPg3Resp().intValue());

		List<SigitRComp4ManutDto> rComp4ManuList = getDbServiceImp().getSigitRComp4ManutDao().findByPersonaGiuridicaCodImpianto(filter);

		for (SigitRComp4ManutDto rComp4Manu : rComp4ManuList) {
			SigitTPersonaGiuridicaDto personaGiuridica = getDbServiceImp().cercaPersonaGiuridicaById(rComp4Manu.getFkPersonaGiuridica());

			DatiAffidamento datiAffidamento = new DatiAffidamento();
			datiAffidamento.setIdTipoComponente(rComp4Manu.getIdTipoComponente());
			datiAffidamento.setProgressivo(
					rComp4Manu.getProgressivo() != null ? rComp4Manu.getProgressivo().intValue() : null);
			datiAffidamento.setCodiceFiscale(personaGiuridica.getCodiceFiscale());
			datiAffidamento.setSiglaRea(personaGiuridica.getSiglaRea());
			datiAffidamento.setNumeroRea(
					personaGiuridica.getNumeroRea() != null ? personaGiuridica.getNumeroRea().intValue() : null);
			datiAffidamento.setDenominazione(personaGiuridica.getDenominazione());

			response.getDatiAffidamento().add(datiAffidamento);

			logger.debug(nomeMetodo + " - END");
		}
	}

	private void setPersonaToResponseGetDettaglioNomina(ResponseGetDettaglioNomina response, Integer idContratto)
			throws SigitRImpRuoloPfpgDaoException, SigitextException, SigitTContratto2019DaoException {
		String nomeMetodo = "--------- setPersonaToResponseGetDettaglioNomina ---------";
		logger.debug(nomeMetodo + " - START");

		SigitTContratto2019Dto contratto2019 = getDbServiceImp().findSigitTContratto2019ByIdContratto(idContratto);
		SigitRImpRuoloPfpgDto impRuoloPfPg = getDbServiceImp()
				.findSigitRImpRuoloPfpgListById(contratto2019.getFkImpRuoloPfpgResp().intValue()).get(0);

		/* if (impRuoloPfPg.getFkPersonaFisica() == null) {
			logger.debug(
					"Error when try to retrieve SigitTPersonaFisica, SigitRImpRuoloPfpg.fk_persona_fisica missing");
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(
					"Error when try to retrieve SigitTPersonaFisica, SigitRImpRuoloPfpg.fk_persona_fisica missing");
		} */

		Persona persona = new Persona();

		if (impRuoloPfPg.getFkPersonaGiuridica() != null) {
			SigitTPersonaGiuridicaDto personaGiuridica = getDbServiceImp()
					.cercaPersonaGiuridicaById(impRuoloPfPg.getFkPersonaGiuridica());

			persona.setCognomeDenominazione(personaGiuridica.getDenominazione());
		} else {
			SigitTPersonaFisicaDto personaFisica = getDbServiceImp()
					.cercaTPersonaFisicaById(impRuoloPfPg.getFkPersonaFisica().intValue());

			persona.setNome(personaFisica.getNome());
			persona.setCognomeDenominazione(personaFisica.getCognome());
		}

		response.getPersona().add(persona);

		logger.debug(nomeMetodo + " - END");
	}

	private void setDatiImpiantoToResponseGetDettaglioNomina(Integer codiceImpianto,
			ResponseGetDettaglioNomina response) throws SigitextException {
		String nomeMetodo = "--------- setDatiImpiantoToResponseGetDettaglioNomina ---------";
		logger.debug(nomeMetodo + " - START");

		SigitTImpiantoDto impiantoDto = getDbServiceImp().cercaImpiantoDtoById("" + codiceImpianto);
		SigitTUnitaImmobiliareDto unitaImmobiliare = getDbServiceImp().getUnitaImmobiliariImpianto(codiceImpianto)
				.get(0);

		DatiImpianto datiImpianto = new DatiImpianto();
		datiImpianto.setCodiceImpianto("" + codiceImpianto);
		datiImpianto.setIndirizzoSitad(unitaImmobiliare.getIndirizzoSitad());
		datiImpianto.setIndirizzoNonTrovato(unitaImmobiliare.getIndirizzoNonTrovato());
		datiImpianto.setCivico(unitaImmobiliare.getCivico());
		datiImpianto.setComune(impiantoDto.getDenominazioneComune());
		datiImpianto.setProvincia(impiantoDto.getSiglaProvincia());

		response.getDatiImpianto().add(datiImpianto);

		logger.debug(nomeMetodo + " - END");
	}

	private void setDatiContrattoToResponseGetDettaglioNomina(Integer idContratto, ResponseGetDettaglioNomina response)
			throws SigitTContratto2019DaoException {
		String nomeMetodo = "--------- setDatiContrattoToResponseGetDettaglioNomina ---------";
		logger.debug(nomeMetodo + " - START");

		SigitTContratto2019Dto contratto2019 = getDbServiceImp().findSigitTContratto2019ByIdContratto(idContratto);

		DatiContratto datiContratto = new DatiContratto();
		datiContratto.setId_contratto(idContratto);
		datiContratto
				.setFk_pg_3_resp(contratto2019.getFkPg3Resp() != null ? contratto2019.getFkPg3Resp().intValue() : null);
		datiContratto.setFk_imp_ruolo_pfpg_resp(
				contratto2019.getFkImpRuoloPfpgResp() != null ? contratto2019.getFkImpRuoloPfpgResp().intValue()
						: null);
		datiContratto.setData_inizio(contratto2019.getDataInizio());
		datiContratto.setData_fine(contratto2019.getDataFine());
		datiContratto.setFlg_tacito_rinnovo(
				contratto2019.getFlgTacitoRinnovo() != null ? contratto2019.getFlgTacitoRinnovo().intValue() : 0);
		datiContratto.setData_cessazione(contratto2019.getDataCessazione());
		datiContratto.setFk_tipo_cessazione("" + contratto2019.getFkTipoCessazione());
		datiContratto.setMotivo_cessazione(contratto2019.getMotivoCessazione());
		datiContratto.setNote(contratto2019.getNote());

		response.getDatiContratto().add(datiContratto);

		logger.debug(nomeMetodo + " - END");
	}

	private void setDatiImpresaToResponseGetDettaglioNomina(Integer idContratto, Integer codiceImpianto,
			ResponseGetDettaglioNomina response) throws SigitTContratto2019DaoException, SigitextException {
		String nomeMetodo = "--------- setDatiImpresaToResponseGetDettaglioNomina ---------";
		logger.debug(nomeMetodo + " - START");

		SigitTContratto2019Dto contratto2019 = getDbServiceImp()
				.findSigitTContratto2019ByIdContrattoAndCodiceImpianto(idContratto, codiceImpianto);
		SigitTPersonaGiuridicaDto personaGiuridica = getDbServiceImp()
				.cercaPersonaGiuridicaById(contratto2019.getFkPg3Resp());

		DatiImpresa datiImpresa = new DatiImpresa();
		datiImpresa.setId_persona_giuridica(personaGiuridica.getIdPersonaGiuridica().intValue());
		datiImpresa.setSigla_rea(personaGiuridica.getSiglaRea());
		datiImpresa.setNumero_rea(
				personaGiuridica.getNumeroRea() != null ? personaGiuridica.getNumeroRea().intValue() : null);
		datiImpresa.setCodice_fiscale(personaGiuridica.getCodiceFiscale());
		datiImpresa.setDenominazione(personaGiuridica.getDenominazione());

		response.getDatiImpresa().add(datiImpresa);

		logger.debug(nomeMetodo + " - END");
	}

	public String deleteAffidamento(String codiceFiscale, Integer idPersonaGiuridica, Integer codiceImpianto,
			DatiAffidamento datiAffidamento) throws SigitextException {
		String nomeMetodo = "--------- deleteAffidamento ---------";
		logger.debug(nomeMetodo + " - START");

		try {
			List<SigitRComp4ManutDto> rComp4ManutDtoList = getDbServiceImp()
					.findSigitRComp4ManutByCodiceImpiantoAndIdTipoComponenteAndProgressivo(
							new BigDecimal(codiceImpianto), datiAffidamento.getIdTipoComponente(),
							new BigDecimal(datiAffidamento.getProgressivo()));

			for (SigitRComp4ManutDto rComp4ManutDto : rComp4ManutDtoList) {

				Calendar c = Calendar.getInstance();
				c.add(Calendar.DAY_OF_YEAR, -1);
				rComp4ManutDto.setDataFine(new java.sql.Date(c.getTimeInMillis()));
				rComp4ManutDto.setIdTipoComponente(datiAffidamento.getIdTipoComponente());
				rComp4ManutDto.setProgressivo(new BigDecimal(datiAffidamento.getProgressivo()));
				rComp4ManutDto.setCodiceImpianto(new BigDecimal(codiceImpianto));
				getDbServiceImp().updateSigitRComp4ManutDataFine(rComp4ManutDto);

				SigitRComp4ManutDto newDto = new SigitRComp4ManutDto();
				newDto.setFkPersonaGiuridica(new BigDecimal(idPersonaGiuridica));
				newDto.setCodiceImpianto(new BigDecimal(codiceImpianto));
				newDto.setIdTipoComponente(datiAffidamento.getIdTipoComponente());
				newDto.setProgressivo(
						datiAffidamento.getProgressivo() != null ? new BigDecimal(datiAffidamento.getProgressivo())
								: null);
				newDto.setDataInizio(new java.sql.Date(System.currentTimeMillis()));
				newDto.setDataFine(null);
				newDto.setDataUltMod(new Timestamp(System.currentTimeMillis()));
				newDto.setUtenteUltMod(codiceFiscale);

				switch (datiAffidamento.getIdTipoComponente()) {
				case "GT":
					newDto.setFkRuolo(new BigDecimal(6));
					break;
				case "GF":
					newDto.setFkRuolo(new BigDecimal(7));
					break;
				case "SC":
					newDto.setFkRuolo(new BigDecimal(8));
					break;
				case "CG":
					newDto.setFkRuolo(new BigDecimal(9));
					break;
				default:
					logger.info("No idTipoComponente found");
					break;
				}

				getDbServiceImp().insertSigitRComp4Manu(newDto);
			}

		} catch (SigitRComp4ManutDaoException e) {
			e.printStackTrace();
			logger.debug("Error when try to retrieve SigitRComp4Manut: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		}

		logger.debug(nomeMetodo + " - END");
		return "OK";
	}

	public List<Map<Integer, String>> getTipoCessazione() throws SigitextException {
		String nomeMetodo = "--------- getTipoCessazione ---------";
		logger.debug(nomeMetodo + " - START");

		List<Map<Integer, String>> response = new ArrayList<>();

		List<SigitDTipoCessazioneDto> listTipoCessazione = getDbServiceImp()
				.getAllTipoCessazioneByIdTipoCessazioneMajorZero();

		for (SigitDTipoCessazioneDto tipoCessazione : listTipoCessazione) {
			Map<Integer, String> map = new HashMap<>();
			map.put(tipoCessazione.getId_tipo_cessazione(), tipoCessazione.getDes_tipo_cessazione());
			response.add(map);
		}

		logger.debug(nomeMetodo + " - END");
		return response;
	}

	public List<Map<Integer, String>> getTipoAutodichiarazione() throws SigitextException {
		String nomeMetodo = "--------- getTipoAutodichiarazione ---------";
		logger.debug(nomeMetodo + " - START");

		List<Map<Integer, String>> response = new ArrayList<>();

		List<SigitDAutodichiarazioneDto> listTipoDichiarazione = getDbServiceImp().findAllSigitDAutodichiarazione();

		for (SigitDAutodichiarazioneDto tipoDichiarazione : listTipoDichiarazione) {
			Map<Integer, String> map = new HashMap<>();
			map.put(tipoDichiarazione.getId_autodichiarazione(), tipoDichiarazione.getDes_autodichiarazione());
			response.add(map);
		}

		logger.debug(nomeMetodo + " - END");
		return response;
	}

	public List<SigitTDocAzioneDto> getDocAzione(Integer idAzione)
			throws SigitTDocAzioneDaoException {
		String nomeMetodo = "--------- getDocAzione ---------";
		logger.debug(nomeMetodo + " - START");
		List<SigitTDocAzioneDto> response = getDbAzioneMgr().getSigitTDocAzioneDao().findByIdAzione(idAzione);
		for (SigitTDocAzioneDto sigitTDocAzioneDto : response) {
			OperationContext oc = getServiceManager().indexGetOperationContext(Constants.INDEX_USERNAME_READ);
			ResultContent metaDati = getServiceManager().indexMetadatiByUid(sigitTDocAzioneDto.getUidIndex(), oc);
			sigitTDocAzioneDto.setMimeTypeDoc(metaDati.getMimeType());
		}
		logger.debug(nomeMetodo + " - END");
		return response;
	}

	@Transactional
	public String setAzioneVerifica(Azione datiAzione, UtenteLoggato utenteLoggato, DocumentoPwa documentoPwa)
			throws SigitextException, SigitTVerificaDaoException {

		String nomeMetodo = "--------- setAzioneVerifica ---------";
		String response = "OK";
		logger.debug(nomeMetodo + " - START");
		try {					
	
			UtenteLoggatoModel utenteLoggatoModel = new UtenteLoggatoModel();
			if (utenteLoggato != null && utenteLoggato.getPfLoggato() != null) {
				utenteLoggatoModel.setCodiceFiscale(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
				Persona persona = getDettaglioPersonaFisica(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
				if(persona!=null) {
					utenteLoggatoModel.setDenominazione(persona.getCognomeDenominazione()+" "+persona.getNome());
				}
			}
	
			SigitTVerificaPk pk = new SigitTVerificaPk();
			pk.setIdVerifica(datiAzione.getFkAzione());
			SigitTVerificaDto sigitTVerificaDto = getServiceManager().getDbServiceImp().getSigitTVerificaDao().findByPrimaryKey(pk);
	
			if (sigitTVerificaDto != null) {
				SigitTAzioneDto sigitTAzioneDto = MapDto.mapToSigitTAzioneDto(Constants.ID_TIPO_AZIONE_VERIFICA,
						datiAzione);
				sigitTAzioneDto.setFkAccertamento(0);
				sigitTAzioneDto.setFkIspezione2018(0);
				sigitTAzioneDto.setFkSanzione(0);
				sigitTAzioneDto.setFkTipoAzione(1);
				sigitTAzioneDto.setCfUtenteAzione(utenteLoggatoModel.getCodiceFiscale());
				sigitTAzioneDto.setDenomUtenteAzione(utenteLoggatoModel.getDenominazione());
				getServiceManager().getDbServiceImp().getSigitTAzioneDao().insert(sigitTAzioneDto);
	
				if (documentoPwa != null && documentoPwa.getDoc() != null && documentoPwa.getDoc().length > 0) {
					documentoPwa.setDimensione((long) documentoPwa.getDoc().length);
					response = setDocumento(documentoPwa, null, utenteLoggatoModel.getCodiceFiscale(),
							sigitTVerificaDto.getCodiceImpianto().intValue(), sigitTAzioneDto.getIdAzione(),
							"azione_verifica", null, null);
				}
	
				if ("OK".equalsIgnoreCase(response)) {
	
					response = "" + sigitTAzioneDto.getIdAzione();
	
				}
			}
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error(e);
			throw e;
		}

		logger.debug(nomeMetodo + " - END");
		return response;

	}

	public String setCessazione(RequestTerzoResponsabile requestSetCessazione) throws SigitextException, SigitDRuoloDaoException {
		String nomeMetodo = "--------- setCessazione ---------";
		logger.debug(nomeMetodo + " - START");

		try {
			SigitTContratto2019Dto contratto2019 = getDbServiceImp().findSigitTContratto2019ByIdContratto(requestSetCessazione.getDatiContratto().getId_contratto());

			if (Boolean.TRUE.equals(setCessazioneSendErrorMessage(contratto2019, requestSetCessazione))) {
				logger.debug(nomeMetodo + " - END WITH ERRORS");
//				return "S088";
				return "Non esiste alcun legame da revocare per l'impianto selezionato ";
			}

			if (requestSetCessazione.getDatiContratto().getData_cessazione().compareTo(contratto2019.getDataInizio()) < 0) {
				logger.debug(nomeMetodo + " - END WITH ERRORS");
//				return "S093";
				return "La data revoca indicata e' precedente alla data di inizio del contratto di terza responsabilita'";
			}
			
			logger.debug("Check last date - Start");
			java.sql.Date lastDate = null;
			lastDate = setLastDateForSetCessazione(requestSetCessazione, contratto2019, lastDate);
			logger.debug("Check last date - End");
			if(lastDate!=null && lastDate.compareTo(requestSetCessazione.getDatiContratto().getData_cessazione()) > 0) {
				logger.debug(nomeMetodo + " - END WITH ERRORS");
//				return "S094";
				return "La data revoca indicata e' precedente alla data di controllo di un rapporto di controllo inviato";
			}
			
			

			logger.debug("Set data cesazione, inserimento, motivo cessazione e tipo cessazione");
			contratto2019.setDataCessazione(new java.sql.Date(requestSetCessazione.getDatiContratto().getData_cessazione().getTime()));
			contratto2019.setDataInserimentoCessazione(new Timestamp(System.currentTimeMillis()));
			contratto2019.setMotivoCessazione(requestSetCessazione.getDatiContratto().getMotivo_cessazione());
			contratto2019.setFkTipoCessazione(getDbServiceImp().getTipoCessazioneByDes(requestSetCessazione.getDatiContratto().getFk_tipo_cessazione()).getId_tipo_cessazione());

			getDbServiceImp().updateSigitTContratto2019PerRevoca(contratto2019);


			logger.debug("Ciclo for per autodichiarazioni se presenti");
			checkAutodichiarazioneForSetCessazione(requestSetCessazione);
			
			List<SigitTLibrettoDto> librettoList = getDbServiceImp().cercaLibrettoByStato(Integer.parseInt(requestSetCessazione.getDatiImpianto().getCodiceImpianto()), 2);
			getServiceManager().consolidaLibretto(Integer.parseInt(requestSetCessazione.getDatiImpianto().getCodiceImpianto()), null, Constants.RUOLO_CESSAZIONE, null, requestSetCessazione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
			
			
			sendMailCessazioneTerzoResponsabile(Integer.parseInt(requestSetCessazione.getDatiImpianto().getCodiceImpianto()), requestSetCessazione);
			
			manageTipoCessazioneDecadenza(requestSetCessazione.getDatiImpianto().getCodiceImpianto(), requestSetCessazione);
			

		} catch (SigitTContratto2019DaoException e) {
			logger.debug("Error when try to retrieve SigitTContratto2019: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (NumberFormatException e) {
			logger.debug("Error when try to convert codiceImpianto: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitRAllegatoCompGtDaoException e) {
			logger.debug("Error when try to retrieve SigitRAllegatoCompGtDto: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitRAllegatoCompScDaoException e) {
			logger.debug("Error when try to retrieve SigitRAllegatoCompScDto: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitRAllegatoCompGfDaoException e) {
			logger.debug("Error when try to retrieve SigitRAllegatoCompGfDto: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitRAllegatoCompCgDaoException e) {
			logger.debug("Error when try to retrieve SigitRAllegatoCompCgDto: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitRImpRuoloPfpgDaoException e) {
			logger.debug("Error when try to retrieve SigitRImpRuoloPfpg: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (ServiceException e) {
			logger.debug("Error when try to send mail: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitTImpiantoDaoException e) {
			logger.debug("Error when try to retrieve SigitTImpiantoDaoException: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitTAbilitazioneDaoException e) {
			logger.debug("Error when try to retrieve SigitTAbilitazioneDaoException: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitTAllegatoDaoException e) {
			logger.debug("Error when try to retrieve SigitTAllegatoDaoException: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		}

		logger.debug(nomeMetodo + " - END");
		return "OK";
	}

	private void manageTipoCessazioneDecadenza(String codiceImpianto, RequestTerzoResponsabile requestSetCessazione)
			throws SigitextException, SigitTImpiantoDaoException, SigitTAbilitazioneDaoException, NumberFormatException, SigitTContratto2019DaoException, SigitRImpRuoloPfpgDaoException, SigitDRuoloDaoException, ServiceException {
		if(requestSetCessazione.getDatiContratto().getFk_tipo_cessazione().equalsIgnoreCase("DECADENZA")) {
			SigitTVerificaDto verificaDto = new SigitTVerificaDto();
			
			verificaDto.setFkTipoVerifica(6);
			verificaDto.setCodiceImpianto(new BigDecimal(codiceImpianto));
			verificaDto.setCfUtenteCaricamento("INSERTAUTOMATICO");
			verificaDto.setDenomUtenteCaricamento("INSERIMENTO AUTOMATICO");
			verificaDto.setDtCaricamento(new java.sql.Date(System.currentTimeMillis()));
			
			SigitTVerificaPk verificaPk = getDbVerificaMgr().salvaVerifica(verificaDto);
			
			SigitTAzioneDto azioneDto = new SigitTAzioneDto();
			azioneDto.setFkTipoAzione(1);
			azioneDto.setFkVerifica(verificaPk.getIdVerifica());
			azioneDto.setFkAccertamento(0);
			azioneDto.setFkIspezione2018(0);
			azioneDto.setFkSanzione(0);
			azioneDto.setDescrizioneAzione("creazione automatica di verifica per decadenza 3 RESP");
			azioneDto.setCfUtenteAzione("INSERTAUTOMATICO");
			azioneDto.setDenomUtenteAzione("INSERIMENTO AUTOMATICO");
			azioneDto.setDtAzione(new java.sql.Date(System.currentTimeMillis()));
			getDbAzioneMgr().inserisciOModificaAzione(azioneDto);
			
			SigitTAccertamentoDto accertamentoDto = new SigitTAccertamentoDto();
			accertamentoDto.setFkVerifica(verificaPk.getIdVerifica());
			accertamentoDto.setFkStatoAccertamento(Constants.ID_STATO_ACCERTAMENTO_IN_CORSO);
			accertamentoDto.setCodiceImpianto(new BigDecimal(codiceImpianto));
			accertamentoDto.setDtCreazione(new java.sql.Date(System.currentTimeMillis()));
			accertamentoDto.setDtConclusione(null);
			accertamentoDto.setFkTipoConclusione(0);
			accertamentoDto.setFkTipoAnomalia(0);
			accertamentoDto.setCfUtenteAssegn(null);
			accertamentoDto.setDenomUtenteAssegn(null);
			accertamentoDto.setSiglaProvCompetenza(requestSetCessazione.getDatiImpianto().getSiglaProv());
			accertamentoDto.setIstatProvCompetenza(requestSetCessazione.getDatiImpianto().getIstatComune().substring(0,3));
			accertamentoDto.setIstatComuneCompetenza(requestSetCessazione.getDatiImpianto().getIstatComune());
			
			
			SigitTAccertamentoPk accertamentoPk = getDbVerificaMgr().salvaAccertamento(accertamentoDto);
			
			SigitTImpiantoDto impiantoDto = new SigitTImpiantoDto();
			impiantoDto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
			impiantoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
			impiantoDto.setUtenteUltMod(requestSetCessazione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
			impiantoDto.setFlgBloccoNomina3r(new BigDecimal(Constants.SI_1));
			
			getDbServiceImp().updateBloccoNomina3ROnSigitTImpianto(impiantoDto);
			
			String istatProvincia = accertamentoDto.getIstatProvCompetenza();
			logger.debug("istatProvincia:  " + istatProvincia);
			SigitTAbilitazionePk abiitazionePk = new SigitTAbilitazionePk();
			abiitazionePk.setIdRuoloPa(4);
			abiitazionePk.setIstatAbilitazione("01" + istatProvincia);
			SigitTAbilitazioneDto abiitazioneDto = getDbServiceImp().findSigitTAbilitazioneByPk(abiitazionePk);
			logger.debug("");
			
			sendMailCessazioneProvinciaTerzoResponsabile(Integer.parseInt(codiceImpianto), requestSetCessazione, accertamentoPk, abiitazioneDto.getMailComunicazione());

		}
	}

	private void checkAutodichiarazioneForSetCessazione(RequestTerzoResponsabile requestSetCessazione)
			throws SigitextException {
		for(Autodichiarazione autodichiarazione : requestSetCessazione.getAutodichiarazioni()) {
			SigitRContr2019AutodichiarDto autodichiarazioneDto = new SigitRContr2019AutodichiarDto();
			autodichiarazioneDto.setFlg_nomina_cessa(autodichiarazione.getFlgNominaCessa());
			autodichiarazioneDto.setId_contratto(autodichiarazione.getIdContratto());
			autodichiarazioneDto.setId_autodichiarazione(autodichiarazione.getIdAutodichiarazione());
			
			getDbServiceImp().insertSigitRContr2019Autodichiar(autodichiarazioneDto);
		}
	}

	private java.sql.Date setLastDateForSetCessazione(RequestTerzoResponsabile requestSetCessazione,
			SigitTContratto2019Dto contratto2019, java.sql.Date lastDate)
			throws SigitRAllegatoCompGtDaoException, SigitRAllegatoCompScDaoException, SigitRAllegatoCompGfDaoException,
			SigitRAllegatoCompCgDaoException, SigitTAllegatoDaoException {
		List<BigDecimal> idAllegatoList = getIdAllegatoListFromCodiceImpianto(requestSetCessazione);
		for(BigDecimal idAllegato : idAllegatoList) {
			List<SigitTAllegatoDto> allegatoList = getDbServiceImp().findSigitTAllegatoByIdAllegatoAndFkStatoRapp(idAllegato);
			for(SigitTAllegatoDto allegato : allegatoList) {
				if(lastDate != null) {
					if(lastDate.compareTo(allegato.getDataControllo()) < 0) {
						lastDate = allegato.getDataControllo();
					}
				}else {
					lastDate = allegato.getDataControllo();
				}
				
			}
		}
		return lastDate;
	}

	private Boolean setCessazioneSendErrorMessage(SigitTContratto2019Dto contratto2019, RequestTerzoResponsabile requestSetCessazione) {
		if (contratto2019.getDataCessazione() != null) {
			return true;
		}

		if (Boolean.TRUE.equals(checkContrattoForCessazione(contratto2019)) && contratto2019.getCodiceImpianto().equals(new BigDecimal(requestSetCessazione.getDatiImpianto().getCodiceImpianto()))) {
			
			if (requestSetCessazione.getUtenteLoggato().getRuoloLoggato().getRuolo().equalsIgnoreCase("3RESPONSABILE") ) {

				if(Boolean.TRUE.equals(checkContrattoForCessazione(contratto2019))
					&& contratto2019.getFkPg3Resp().equals(new BigDecimal(requestSetCessazione.getUtenteLoggato().getRuoloLoggato().getIdPersonaGiuridica()))
					&& contratto2019.getCodiceImpianto().equals(new BigDecimal(requestSetCessazione.getDatiImpianto().getCodiceImpianto()))) {
					return false;	
				}
			}else {
				if(Boolean.TRUE.equals(checkContrattoForCessazione(contratto2019)) 
						&& contratto2019.getCodiceImpianto().equals(new BigDecimal(requestSetCessazione.getDatiImpianto().getCodiceImpianto()))){
					return false;
				}
			}
			
		}
		
		return true;

	}
	
	private Boolean checkContrattoForCessazione(SigitTContratto2019Dto contratto2019) {
		if(contratto2019.getDataCessazione() == null 
				&& (
						(contratto2019.getFlgTacitoRinnovo() != null && contratto2019.getFlgTacitoRinnovo().compareTo(BigDecimal.ONE) == 0)
						|| (
								(contratto2019.getFlgTacitoRinnovo() == null || contratto2019.getFlgTacitoRinnovo().compareTo(BigDecimal.ZERO) == 0) 
								&& contratto2019.getDataFine().after(new java.sql.Date(System.currentTimeMillis()))
						)
				)) {
					return true;
				}
		
		return false;
	}

	public String verifyIndirizzoImpianto(DatiImpianto datiImpianto, Boolean checkContrattoInEssere) throws SigitextException {
		String nomeMetodo = "--------- verifyIndirizzoImpianto ---------";
		logger.debug(nomeMetodo + " - START");

		try {
			SigitTImpiantoDto impiantoDto = getDbServiceImp().cercaImpiantoDtoById(datiImpianto.getCodiceImpianto());

			if (impiantoDto == null) {
				logger.debug(nomeMetodo + " - END WITH ERROR");
				throw new SigitextException("NOIMPIANTO");
			}

		} catch (SigitextException ex) {
			logger.debug(nomeMetodo + " - END WITH ERROR");
			throw new SigitextException("NOIMPIANTO");
		}

		if (Boolean.TRUE.equals(checkContrattoInEssere)) {
			SigitTContratto2019Dto contrattoInEssere = getDbServiceImp().checkContrattoInEssere(datiImpianto.getCodiceImpianto());

			if (contrattoInEssere != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date dataFine = contrattoInEssere.getDataCessazione() != null ? contrattoInEssere.getDataCessazione() : contrattoInEssere.getDataFine();
				String tacitoRinnovo =  BigDecimal.ONE.compareTo(contrattoInEssere.getFlgTacitoRinnovo()) == 0 ? "Si'" : "No";
				String errorMessage = String.format("Esiste gia' un terzo responsabile attivo per l'impianto indicato. Data inizio contratto: %s. Richiedere delega manutentore.",
						sdf.format(contrattoInEssere.getDataInizio()), sdf.format(dataFine), tacitoRinnovo);

				throw new SigitextException(errorMessage);
			}
		}

		Integer count = 0;
		List<SigitTUnitaImmobiliareDto> unitaImmobiliareDtoList = getDbServiceImp()
				.getUnitaImmobiliariImpianto(Integer.parseInt(datiImpianto.getCodiceImpianto()));
		logger.debug(nomeMetodo + " find unita immobiliari: " + unitaImmobiliareDtoList != null
				? unitaImmobiliareDtoList.size()
				: "null");
		for (SigitTUnitaImmobiliareDto unitaImmobiliareDto : unitaImmobiliareDtoList) {
			if (((unitaImmobiliareDto.getIndirizzoSitad() != null
					&& unitaImmobiliareDto.getIndirizzoSitad().equals(datiImpianto.getIndirizzoSitad()))
					|| (unitaImmobiliareDto.getIndirizzoNonTrovato() != null && unitaImmobiliareDto
							.getIndirizzoNonTrovato().contentEquals(datiImpianto.getIndirizzoNonTrovato())))
					&& ((datiImpianto.getCivico() == null || datiImpianto.getCivico().isEmpty()) || ((datiImpianto.getCivico() != null &&
							  datiImpianto.getCivico().contentEquals(unitaImmobiliareDto.getCivico())) ||
							  datiImpianto.getCivico() == null))
					&& unitaImmobiliareDto.getFlgPrincipale().compareTo(BigDecimal.ONE) >= 0) {
					count++;	
			}
		}
		logger.debug(nomeMetodo + " - total count: " + count);
		if (count != 1) {
			logger.debug(nomeMetodo + " - END WITH ERROR");
			throw new SigitextException("S070");
		}

		logger.debug(nomeMetodo + " - END");
		return "OK";
	}

	public List<Persona> getElencoStoricoResponsabiliImpianto(String codiceImpianto) throws SigitextException {
		String nomeMetodo = "--------- getElencoStoricoResponsabiliImpianto ---------";
		logger.debug(nomeMetodo + " - START");

		List<Persona> response = new ArrayList<>();

		try {
			List<SigitRImpRuoloPfpgDto> impRuoloDtoLit = getDbServiceImp()
					.getResponsabiliImpianto(Integer.parseInt(codiceImpianto));
			for (SigitRImpRuoloPfpgDto impRuoloDto : impRuoloDtoLit) {
				if (impRuoloDto.getFkPersonaFisica() != null) {
					SigitTPersonaFisicaDto personaFisica = getDbServiceImp()
							.cercaTPersonaFisicaById(impRuoloDto.getFkPersonaFisica().intValue());
					SigitDRuoloDto ruolo = getDbServiceImp().findSigitDRuoloById(impRuoloDto.getFkRuolo().intValue());

					Persona persona = new Persona();
					persona.setNome(personaFisica.getNome());
					persona.setCognomeDenominazione(personaFisica.getCognome());
					persona.setTitolo(ruolo.getDesRuolo());
					persona.setDataInizioResp(impRuoloDto.getDataInizio());
					persona.setDataFineResp(impRuoloDto.getDataFine());

					response.add(persona);
				}
				if (impRuoloDto.getFkPersonaGiuridica() != null) {
					SigitTPersonaGiuridicaDto personaGiuridica = getDbServiceImp()
							.cercaPersonaGiuridicaById(impRuoloDto.getFkPersonaGiuridica());
					SigitDRuoloDto ruolo = getDbServiceImp().findSigitDRuoloById(impRuoloDto.getFkRuolo().intValue());

					Persona persona = new Persona();
					persona.setCognomeDenominazione(personaGiuridica.getDenominazione());
					persona.setTitolo(ruolo.getDesRuolo());
					persona.setDataInizioResp(impRuoloDto.getDataInizio());
					persona.setDataFineResp(impRuoloDto.getDataFine());

					response.add(persona);
				}
			}
		} catch (NumberFormatException | SigitRImpRuoloPfpgDaoException | SigitDRuoloDaoException e) {
			logger.debug(nomeMetodo + " - END WITH ERROR");
			throw new SigitextException(e.getMessage());
		}

		logger.debug(nomeMetodo + " - END");
		return response;
	}

	public String setSubentroComponente(String codiceImpianto, String idPersonaGiuridica, Boolean sendMail,
			SubentroComponente subentro) throws SigitextException {
		String nomeMetodo = "--------- setSubentroComponente ---------";
		String bitMetodo = "setSubentroComponente: ";
		if(subentro == null) {
			logger.debug("oggetto subentrocomponente null");
			throw new SigitextException("oggetto subentrocomponente null");
		}
		List<Componente> componenti = subentro.getComponenti();
		logger.debug(nomeMetodo + " - START");
		if(componenti == null || componenti.isEmpty()) {
			logger.debug("La lista componenti risulta vuota");
			throw new SigitextException("La lista componenti risulta vuota");
		}
		// Verificare che il manutentore indicato (tag siglaREA, numeroREA,
		// codiceFiscale) esista su SIGIT_T_PERSONA_GIURIDICA
		
		SigitTPersonaGiuridicaDto  pg =  getDbServiceImp().cercaPersonaGiuridicaById(new BigDecimal(idPersonaGiuridica));
		if (pg == null ) {
			logger.debug("Persona giuridica non trovata");
			throw new SigitextException(GenericUtil.replacePlaceholder(Messages.S100, idPersonaGiuridica));
		}
		if (pg.getFkStatoPg().intValue() == Constants.ID_STATO_IMPRESA_SOSPESA
				|| pg.getFkStatoPg().intValue() == Constants.ID_STATO_IMPRESA_RADIATA) {
			throw new SigitextException(GenericUtil.replacePlaceholder(Messages.S147, idPersonaGiuridica, pg.getCodiceFiscale()));
		}
		logger.debug("Check stato impresa completato");
		//Aggiorno il record su SIGIT_R_COMP4_MANUT 
		SigitRComp4ManutDto filter = new SigitRComp4ManutDto();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		filter.setDataFine(new java.sql.Date(calendar.getTime().getTime()));
		try {
			for(int i = 0;i<componenti.size(); i++) {
				String fkRuolo ="";
				String idTipoComponente = componenti.get(i).getIdTipoComponente();
				switch (idTipoComponente) {
					case Constants.TIPO_COMPONENTE_GT:
						fkRuolo = "6";
						break;
					case Constants.TIPO_COMPONENTE_GF:
						fkRuolo = "7";
						break;
					case Constants.TIPO_COMPONENTE_SC:
						fkRuolo = "8";
						break;
					case Constants.TIPO_COMPONENTE_CG:
						fkRuolo = "9";
						break;
					default:
						break;
				}

				logger.debug(bitMetodo + "Update data fine");
				filter.setCodiceImpianto(new BigDecimal(codiceImpianto));
				filter.setIdTipoComponente(componenti.get(i).getIdTipoComponente());
				filter.setProgressivo(new BigDecimal(componenti.get(i).getProgressivo()));
				getDbServiceImp().getSigitRComp4ManutDao().updateDataFine(filter);
				logger.debug(bitMetodo + "Data fine aggiornata");
				logger.debug(bitMetodo + " Insert componente ");
				SigitRComp4ManutDto dto = new SigitRComp4ManutDto();
				dto.setFkPersonaGiuridica(new BigDecimal(idPersonaGiuridica));
				dto.setCodiceImpianto(new BigDecimal(codiceImpianto));
				dto.setIdTipoComponente(idTipoComponente);
				dto.setProgressivo(new BigDecimal(componenti.get(i).getProgressivo()));
				dto.setDataInizio(new java.sql.Date(new Date().getTime()));
				dto.setDataUltMod(new Timestamp(new Date().getTime()));
				dto.setUtenteUltMod(subentro.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
				dto.setFkRuolo(new BigDecimal(fkRuolo));
				getDbServiceImp().getSigitRComp4ManutDao().insert(dto);
			}
		} catch (SigitRComp4ManutDaoException e) {
			logger.debug("ERRORE " + nomeMetodo);
			logger.debug(e);
			logger.debug("FINE ERRORE " + nomeMetodo);
			throw new SigitextException("Errore durante il salvataggio su sigitRcomp");
		}
		if (Boolean.TRUE.equals(sendMail)) {
			try {
				sendMailSubentroComponente(Integer.valueOf(codiceImpianto), idPersonaGiuridica, subentro);
			} catch (NumberFormatException e) {
				logger.error("Numberformatexception prima dell'invio mail subentro su componente");
				throw e;
			} catch (SigitTContratto2019DaoException e) {
				logger.error("SigitTContratto2019DaoException " + e.getMessage());
				throw new SigitextException(e.getMessage());		
			}
		}
		logger.debug(nomeMetodo + " - END");
		return "OK";
	}
	
	public String setProroga(RequestTerzoResponsabile request) throws SigitextException {
		String nomeMetodo = "--------- setProroga ---------";
		logger.debug(nomeMetodo + " - START");
		
		try {
			SigitTContratto2019Dto contratto2019 = getDbServiceImp().findSigitTContratto2019ByIdContratto(request.getDatiContratto().getId_contratto());
			
			if(contratto2019.getDataCessazione() != null) {
				logger.debug(nomeMetodo + " - END WITH ERRORS");
				return "Non e' possibile prorogare un contratto cessato esplicitamente dall'utente prima della naturale scadenza";
			}
			
			if(BigDecimal.ONE.compareTo(contratto2019.getFlgTacitoRinnovo()) == 0) {
				logger.debug(nomeMetodo + " - END WITH ERRORS");
				return "Non e' necessario prorogare la terza responsabilita' in quanto gia' soggetta al tacito rinnovo";
			}
			
			if(request.getDatiContratto().getData_fine().compareTo(contratto2019.getDataFine()) < 0) {
				logger.debug(nomeMetodo + " - END WITH ERRORS");
				return "La data fine contratto inserita deve essere successiva alla attuale data fine contratto.";
			}
			
			List<BigDecimal> idAllegatoList = getIdAllegatoListFromCodiceImpianto(request);
			String response = manageAllegatoForSetProroga(request, nomeMetodo, contratto2019, idAllegatoList);
			if(!"OK".equals(response)) {
				logger.debug(nomeMetodo + " - END after manageAllegatoForSetProroga");
				return response;
			}
			
			java.sql.Date lastDateFine = contratto2019.getDataFine();
			
			contratto2019.setDataFine(new java.sql.Date(request.getDatiContratto().getData_fine().getTime()));
			contratto2019.setFlgTacitoRinnovo(new BigDecimal(request.getDatiContratto().getFlg_tacito_rinnovo()));
			
			getDbServiceImp().updateSigitTContratto2019PerProroga(contratto2019);
			
			SigitTAzioneContrattoDto azioneContrattoDto = new SigitTAzioneContrattoDto();
			azioneContrattoDto.setId_contratto(new BigDecimal(request.getDatiContratto().getId_contratto()));
			azioneContrattoDto.setCf_utente_azione(request.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
			azioneContrattoDto.setDescrizione_azione("Proroga nomina terza responsabilità impianto " + request.getDatiImpianto().getCodiceImpianto());
			azioneContrattoDto.setDt_azione(new Timestamp(System.currentTimeMillis()));
			azioneContrattoDto.setOld_data_fine(lastDateFine);
			
			getDbServiceImp().insertSigitTAzioneContratto(azioneContrattoDto);
			
			List<SigitTLibrettoDto> librettoList = getDbServiceImp().cercaLibrettoByStato(Integer.parseInt(request.getDatiImpianto().getCodiceImpianto()), 2);
			getServiceManager().consolidaLibretto(Integer.parseInt(request.getDatiImpianto().getCodiceImpianto()), null, Constants.RUOLO_PROROGA, null, request.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
			
			sendMailProrogaTerzoResponsabile(Integer.parseInt(request.getDatiImpianto().getCodiceImpianto()), request);
			
		} catch (SigitTContratto2019DaoException e) {
			logger.debug("Error when try to retrieve SigitTContratto2019: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (NumberFormatException e) {
			logger.debug("Error when try to convert codiceImpianto: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitRAllegatoCompGtDaoException e) {
			logger.debug("Error when try to retrieve SigitRAllegatoCompGtDto: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitRAllegatoCompScDaoException e) {
			logger.debug("Error when try to retrieve SigitRAllegatoCompScDto: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitRAllegatoCompGfDaoException e) {
			logger.debug("Error when try to retrieve SigitRAllegatoCompGfDto: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitRAllegatoCompCgDaoException e) {
			logger.debug("Error when try to retrieve SigitRAllegatoCompCgDto: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitTAllegatoDaoException e) {
			logger.debug("Error when try to retrieve SigitTAllegato: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitRImpRuoloPfpgDaoException e) {
			logger.debug("Error when try to retrieve SigitRImpRuoloPfpg: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (ServiceException e) {
			logger.debug("Error when try to send mail: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitDRuoloDaoException e) {
			logger.debug("Error when try to send mail: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		}
		
		
		
		logger.debug(nomeMetodo + " - END");
		return "OK";
	}

	private String manageAllegatoForSetProroga(RequestTerzoResponsabile request, String nomeMetodo, SigitTContratto2019Dto contratto2019, List<BigDecimal> idAllegatoList) throws SigitTAllegatoDaoException {
		for(BigDecimal idAllegato : idAllegatoList) {
			List<SigitTAllegatoDto> allegatoList = getDbServiceImp().findSigitTAllegatoByIdAllegatoAndFkStatoRapp(idAllegato);
			for(SigitTAllegatoDto allegato : allegatoList) {
				if(allegato.getDataControllo().compareTo(contratto2019.getDataFine()) > -1 && allegato.getDataControllo().compareTo(request.getDatiContratto().getData_fine()) < 0) {
					logger.debug(nomeMetodo + " - END WITH ERRORS");
					return "Impossibile procedere poiche' esistono degli allegati inviati nelle date indicate";
				}
				
			}
		}
		return "OK";
	}

	private List<BigDecimal> getIdAllegatoListFromCodiceImpianto(RequestTerzoResponsabile requestSetCessazione) throws SigitRAllegatoCompGtDaoException, SigitRAllegatoCompScDaoException, SigitRAllegatoCompGfDaoException, SigitRAllegatoCompCgDaoException {
		
		List<SigitRAllegatoCompGtDto> gtList = getDbServiceImp().findSigitRAllegatoCompGtDtoByCodiceImpianto(Integer.parseInt(requestSetCessazione.getDatiImpianto().getCodiceImpianto()));
		List<SigitRAllegatoCompScDto> scList = getDbServiceImp().findSigitRAllegatoCompScDtoByCodiceImpianto(Integer.parseInt(requestSetCessazione.getDatiImpianto().getCodiceImpianto()));
		List<SigitRAllegatoCompGfDto> gfList = getDbServiceImp().findSigitRAllegatoCompGfDtoByCodiceImpianto(Integer.parseInt(requestSetCessazione.getDatiImpianto().getCodiceImpianto()));
		List<SigitRAllegatoCompCgDto> cgList = getDbServiceImp().findSigitRAllegatoCompCgDtoByCodiceImpianto(Integer.parseInt(requestSetCessazione.getDatiImpianto().getCodiceImpianto()));
		
		List<BigDecimal> idAllegatoList = new ArrayList<>();
		
		for(SigitRAllegatoCompGtDto gt : gtList) {
			idAllegatoList.add(gt.getIdAllegato());
		}
		for(SigitRAllegatoCompScDto gt : scList) {
			idAllegatoList.add(gt.getIdAllegato());
		}
		for(SigitRAllegatoCompGfDto gt : gfList) {
			idAllegatoList.add(gt.getIdAllegato());
		}
		for(SigitRAllegatoCompCgDto gt : cgList) {
			idAllegatoList.add(gt.getIdAllegato());
		}
		
		return idAllegatoList;
	}
	
	public String setSubentrosuImpianto(String codiceFiscale, Integer idPersona, Integer codiceImpianto, String desRuolo, UtenteLoggato utenteLoggato) throws SigitextException {
		String nomeMetodo = "--------- setSubentrosuImpianto ---------";
		logger.debug(nomeMetodo + " - START");
		SigitRImpRuoloPfpgDto dto = new SigitRImpRuoloPfpgDto();
		try {
			
			ValidationManager vm = getValidationManager();
			SigitTControlloLibrettoDto controlloLibDto = vm.getDbServiceImp().findControlloLibretto(codiceImpianto.toString());
			if(controlloLibDto == null ||
			   !ConvertUtil.convertToBooleanAllways(controlloLibDto.getFlgL1Controlloweb())/* ||
			   !ConvertUtil.convertToBooleanAllways(controlloLibDto.getFlgL5Controlloweb()) ||
			   !ConvertUtil.convertToBooleanAllways(controlloLibDto.getFlgL6Controlloweb()) ||
			   !ConvertUtil.convertToBooleanAllways(controlloLibDto.getFlgL7Controlloweb())*/) 
			{
				return Messages.ERROR_LIBRETTO_NON_CONTROLLATO;
			}
			
			if(!desRuolo.equalsIgnoreCase("Caricatore")) {
				Integer checkResponsabileImpresaOProrietarioImpresa = 0;
				if(idPersona != null)
					checkResponsabileImpresaOProrietarioImpresa = getDbServiceImp().checkSigitRImpRuoloPfpgResponsabileImpresa(codiceImpianto, idPersona, utenteLoggato.getRuoloLoggato().getRuolo());
				
				String cfValido = utenteLoggato.getRuoloLoggato().getPiva() != null ? utenteLoggato.getRuoloLoggato().getPiva() :  utenteLoggato.getPfLoggato().getCodiceFiscalePF();
				
				Integer checkResponsabile = getDbServiceImp().checkSigitRImpRuoloPfpgResponsabile(codiceImpianto, cfValido);
				Integer checkProprietario = getDbServiceImp().checkSigitRImpRuoloPfpgProprietario(codiceImpianto, cfValido);
				
				/*if(checkResponsabileImpresaOProrietarioImpresa != 0 || checkResponsabileOProprietario != 0) {
					logger.debug(nomeMetodo + " - END WITH ERRORS");
					return "S075";
				}*/
					
				if(utenteLoggato.getRuoloLoggato().getRuolo().equalsIgnoreCase("RESPONSABILE") && checkResponsabile != 0) {
					return "S075";
				}

				if(utenteLoggato.getRuoloLoggato().getRuolo().equalsIgnoreCase("PROPRIETARIO") && checkProprietario != 0) {
					return "S075";
				}
				
				if((utenteLoggato.getRuoloLoggato().getRuolo().equalsIgnoreCase("RESPONSABILE IMPRESA/ENTE") ||
				    utenteLoggato.getRuoloLoggato().getRuolo().equalsIgnoreCase("PROPRIETARIO IMPRESA/ENTE")) &&
				   checkResponsabileImpresaOProrietarioImpresa != 0) {
					return "S075";
				}
				
				///////////////////////////////////////////////////////////////////
				List<SigitRImpRuoloPfpgDto> impRuoloDtoList = getDbServiceImp().findSigitRImpRuoloPfpgByCodiceImpiantoEDataFineOggiONull(codiceImpianto);
				List<SigitDRuoloDto> listRuoliTotale = new ArrayList<SigitDRuoloDto>();
				if(utenteLoggato.getRuoloLoggato().getRuolo().equalsIgnoreCase("PROPRIETARIO") || utenteLoggato.getRuoloLoggato().getRuolo().equalsIgnoreCase("PROPRIETARIO IMPRESA/ENTE")){
					List<SigitDRuoloDto> listRuoliInFunzioneProp = getDbServiceImp().findSigitDRuoloByRuoloFunz("PROPRIETARIO");
					List<SigitDRuoloDto> listRuoliInFunzionePropEnte = getDbServiceImp().findSigitDRuoloByRuoloFunz("PROPRIETARIO IMPRESA/ENTE");
					listRuoliTotale.addAll(listRuoliInFunzioneProp);
					listRuoliTotale.addAll(listRuoliInFunzionePropEnte);
				}else {
					List<SigitDRuoloDto> listRuoliInFunzioneResponsabile = getDbServiceImp().findSigitDRuoloByRuoloFunz("RESPONSABILE");
					List<SigitDRuoloDto> listRuoliInFunzioneResponsabileEnte = getDbServiceImp().findSigitDRuoloByRuoloFunz("RESPONSABILE IMPRESA/ENTE");
					listRuoliTotale.addAll(listRuoliInFunzioneResponsabile);
					listRuoliTotale.addAll(listRuoliInFunzioneResponsabileEnte);
				}
				
				SigitDRuoloDto ruoloDto = getDbServiceImp().findSigitDRuoloByDes(desRuolo, utenteLoggato.getRuoloLoggato().getRuolo());
				for(SigitRImpRuoloPfpgDto impRuoloDto : impRuoloDtoList) {
					for(SigitDRuoloDto ruolo : listRuoliTotale) {
						if((impRuoloDto.getFkRuolo().compareTo(new BigDecimal(ruolo.getIdRuolo().intValue()))) == 0) {
							Calendar calendar = Calendar.getInstance();
							calendar.add(Calendar.DAY_OF_YEAR, -1);
							impRuoloDto.setDataFine(new java.sql.Date(calendar.getTimeInMillis()));
							getDbServiceImp().updateSigitRImpRuoloPfpg(impRuoloDto);
						}
					}
				}
				dto.setFkRuolo(new BigDecimal(ruoloDto.getIdRuolo()));
				dto.setCodiceImpianto(new BigDecimal(codiceImpianto));
				dto.setDataInizio(new java.sql.Date(System.currentTimeMillis()));
				if(utenteLoggato.getRuoloLoggato().getRuolo().contentEquals("RESPONSABILE") || utenteLoggato.getRuoloLoggato().getRuolo().contentEquals("PROPRIETARIO")) {
					//Se responsabile recupero la persona fisica a partire dal codice fiscale nel ruolo loggato
					List<SigitTPersonaFisicaDto> persone = getDbServiceImp().getSigitTPersonaFisicaDao().findByCodiceFiscale(codiceFiscale);
					if(persone.isEmpty()) {
						logger.debug(nomeMetodo + " Nessuna persona trovata");
						throw new SigitextException("Impossibile trovare persona fisica");
					}
					dto.setFkPersonaFisica(persone.get(0).getIdPersonaFisica());
				}else {
					dto.setFkPersonaGiuridica(new BigDecimal(idPersona));
				}
				dto.setDataUltMod(new Timestamp(System.currentTimeMillis()));
				dto.setUtenteUltMod(codiceFiscale);
				dto.setDataFine(null);
				
				getDbServiceImp().insertSigitRImpRuoloPfpg(dto);
				
				if(utenteLoggato.getRuoloLoggato().getRuolo().contentEquals("RESPONSABILE") || utenteLoggato.getRuoloLoggato().getRuolo().contentEquals("RESPONSABILE IMPRESA/ENTE")) {
					getServiceManager().consolidaLibretto(codiceImpianto, null, Constants.CONSOLIDAMENTO_PER_SUBENTRO_RESPONSABILE, null, utenteLoggato.getPfLoggato().getCodiceFiscalePF());

				}
				
			}else {
				
				//Aggiorno 
				getDbServiceImp().closeCaricatoriImpiantoSigitRImpRuoloPfpg(codiceImpianto, codiceFiscale);
				
				dto.setFkRuolo(new BigDecimal(3)); //Prendere 
				dto.setCodiceImpianto(new BigDecimal(codiceImpianto));
				dto.setDataInizio(new java.sql.Date(System.currentTimeMillis()));
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_YEAR, 7);
				dto.setDataFine(new java.sql.Date(calendar.getTimeInMillis()));
				dto.setFkPersonaGiuridica(new BigDecimal(idPersona));
				dto.setDataUltMod(new Timestamp(System.currentTimeMillis()));
				dto.setUtenteUltMod(codiceFiscale);
				
				getDbServiceImp().insertSigitRImpRuoloPfpg(dto);
			}
		} catch (SigitRImpRuoloPfpgDaoException e) {
			logger.debug("Error when try to retrieve SigitRImpRuoloPfpg: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitDRuoloDaoException e) {
			logger.debug("Error when try to retrieve SigitDRuolo: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitTPersonaFisicaDaoException e) {
			logger.debug("Error when try to retrieve PersonaFisica: " + e );
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (SigitRPfRuoloPaDaoException e) {
			logger.debug("Error when try to update sigit_r_imp_ruolo_pfpg: " + e );
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		} catch (ServiceException e) {
			logger.debug("Error when try to consolidamento libretto: " + e );
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		}
		
		logger.debug(nomeMetodo + " - END");
		return "OK";
	}
	
	public String verifyContrattoTerzoResponsabile(RequestTerzoResponsabile requestVerifyContratto) throws SigitextException {
		String nomeMetodo = "--------- verifyContrattoTerzoResponsabile ---------";
		logger.debug(nomeMetodo + " - START");
		
		String errorCheckPGVerifyContrattoTerzoResponsabile =  null;
		SigitTPersonaGiuridicaDto pgImpresa = getDbServiceImp().cercaPersonaGiuridicaById(new BigDecimal(requestVerifyContratto.getDatiImpresa().getId_persona_giuridica()));
		errorCheckPGVerifyContrattoTerzoResponsabile = checkPGVerifyContrattoTerzoResponsabile(nomeMetodo, pgImpresa);
				
		if(requestVerifyContratto.getUtenteLoggato().getRuoloLoggato().getIdPersonaGiuridica() != null ) {
			//Non faccio questo controllo nel caso l'idPerrsonaGiuridica nel ruolo non é presente, tipo nel caso di amministratore
			SigitTPersonaGiuridicaDto pg = getDbServiceImp().cercaPersonaGiuridicaById(new BigDecimal(requestVerifyContratto.getUtenteLoggato().getRuoloLoggato().getIdPersonaGiuridica()));
			errorCheckPGVerifyContrattoTerzoResponsabile =checkPGVerifyContrattoTerzoResponsabile(nomeMetodo, pg);
		}
		
		if(errorCheckPGVerifyContrattoTerzoResponsabile != null) {
			return errorCheckPGVerifyContrattoTerzoResponsabile;
		}
		
		if(requestVerifyContratto.getDatiContratto() == null || requestVerifyContratto.getDatiImpianto() == null || requestVerifyContratto.getDatiImpresa() == null || requestVerifyContratto.getUtenteLoggato() == null) {
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			logger.error("S006");
			return "S006";
		}
		
		if(pgImpresa.getFkStatoPg() == 2 && requestVerifyContratto.getDatiContratto().getData_inizio().compareTo(pgImpresa.getDataCessazione()) > 0) {
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			logger.error("S148");
			return "Non e' possibile procedere in quanto l'impresa e' CESSATA in data " + new SimpleDateFormat("dd/MM/yyyy").format(pgImpresa.getDataCessazione());
		}
						
		try {
			boolean error = true;
			List<SigitRImpRuoloPfpgDto> rImpRuoloDtoList = getDbServiceImp().findSigitRImpRuoloPfpgByCodiceImpiantoAndRuolo(Integer.parseInt(requestVerifyContratto.getDatiImpianto().getCodiceImpianto()));
			for(SigitRImpRuoloPfpgDto rImpRuoloDto : rImpRuoloDtoList) {
				
				if(rImpRuoloDto != null && rImpRuoloDto.getDataInizio().compareTo(requestVerifyContratto.getDatiContratto().getData_inizio()) < 1) {
					error = false;
				}
			}
			
			if(error) {
				logger.debug(nomeMetodo + " - END WITH ERRORS");
				logger.error("S089");
				return "Alla data di inizio del contratto non esiste un responsabile valido";
			}
			
			
		} catch (NumberFormatException | SigitRImpRuoloPfpgDaoException e) {
			logger.debug("Error when try to retrieve SigitRImpRuoloPfpgDto: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		}
		
		SigitTImpiantoDto impiantoDto = getDbServiceImp().cercaImpiantoDtoById(requestVerifyContratto.getDatiImpianto().getCodiceImpianto());
		if(impiantoDto!=null && impiantoDto.getFlgBloccoNomina3r()!=null && BigDecimal.ONE.compareTo(impiantoDto.getFlgBloccoNomina3r()) == 0) {
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			logger.error("Non e' possibile procedere con la nomina della terza responsabilita' in quanto c'e' un accertamento in corso sull'impianto stesso");
			return "Non e' possibile procedere con la nomina della terza responsabilita' in quanto c'e' un accertamento in corso sull'impianto stesso";
		}
		
		try {
			List<SigitTContratto2019Dto> contratto2019DtoList = getDbServiceImp().findSigitTContratto2019ByCodiceImpianto(Integer.parseInt(requestVerifyContratto.getDatiImpianto().getCodiceImpianto()));
			for (SigitTContratto2019Dto contratto2019 : contratto2019DtoList) {
				if (contratto2019.getDataCessazione() == null && ((contratto2019.getFlgTacitoRinnovo() != null
						&& contratto2019.getFlgTacitoRinnovo().compareTo(BigDecimal.ONE) == 0)
						|| ((contratto2019.getFlgTacitoRinnovo() == null
								|| contratto2019.getFlgTacitoRinnovo().compareTo(BigDecimal.ZERO) == 0)
								&& (contratto2019.getDataFine().after(requestVerifyContratto.getDatiContratto().getData_inizio())
									|| contratto2019.getDataFine().equals(requestVerifyContratto.getDatiContratto().getData_inizio())
								)))) {

					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dataFine = contratto2019.getDataFine();
					String tacitoRinnovo =  BigDecimal.ONE.compareTo(contratto2019.getFlgTacitoRinnovo()) == 0 ? "Si'" : "No";
					return String.format("Esiste gia' un terzo responsabile attivo per l'impianto indicato. Data inizio contratto: %s; Data fine contratto: %s; Tacito rinnovo: %s.",
							sdf.format(contratto2019.getDataInizio()), sdf.format(dataFine), tacitoRinnovo);
				}
				
				if (contratto2019.getDataCessazione() != null && 
						(contratto2019.getDataCessazione().after(requestVerifyContratto.getDatiContratto().getData_inizio())
									|| contratto2019.getDataCessazione().equals(requestVerifyContratto.getDatiContratto().getData_inizio())
								)) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dataCessazione = contratto2019.getDataCessazione();
					String tacitoRinnovo =  BigDecimal.ONE.compareTo(contratto2019.getFlgTacitoRinnovo()) == 0 ? "Si'" : "No";
					return String.format("Esiste gia' un terzo responsabile attivo per l'impianto indicato. Data inizio contratto: %s; Data cessazione contratto: %s; Tacito rinnovo: %s.",
							sdf.format(contratto2019.getDataInizio()), sdf.format(dataCessazione), tacitoRinnovo);
					}
				}
			} 
			catch (SigitTContratto2019DaoException e) {
			logger.debug("Error when try to retrieve SigitTContratto2019Dto: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			throw new SigitextException(e.getMessage());
		}
		
		if (getDbServiceImp().getSigitVRicercaAllegatiDao().checkAllegatoInviatoBetweenTwoDatesAndCodImpAndFkStatoRapp(
				requestVerifyContratto.getDatiContratto().getData_inizio(),
				requestVerifyContratto.getDatiContratto().getData_fine(),
				requestVerifyContratto.getDatiImpianto().getCodiceImpianto()
		)) {
				return "Esiste gia' un documento Rapporto di Efficienza Energetica/Manutenzione/Rapporto di Prova in stato inviato per il periodo indicato";
		} 

		logger.debug(nomeMetodo + " - END");
		return "OK";
	}

	private String checkPGVerifyContrattoTerzoResponsabile(String nomeMetodo, SigitTPersonaGiuridicaDto pgImpresa) {
		if(checkPersonaGiuridicaAbilitataTerzaResponsabilita(pgImpresa)){
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			logger.error("L'impresa indicata non e' abilitata ad operare in qualita' di terzo responsabile");
			return "L'impresa indicata non e' abilitata ad operare in qualita' di terzo responsabile";
		}
		if(pgImpresa.getFkStatoPg() == 4 || pgImpresa.getFkStatoPg() == 3) {
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			logger.error("Non é possibile procedere in quanto l'impresa é in stato RADIATO o SOSPESO");
			return "Non e' possibile procedere in quanto l'impresa e' in stato RADIATO o SOSPESO";
		}
		return null;
	}
	
	private Boolean checkPersonaGiuridicaAbilitataTerzaResponsabilita(SigitTPersonaGiuridicaDto pg) {
		logger.debug("checkPersonaGiuridicaAbilitataTerzaResponsabilita");
		if(pg.getFlgTerzoResponsabile().compareTo(BigDecimal.ONE) == 0) {
			return false;
		}
		return true;
	}
	
	@Transactional
	public String setNuovoTerzoResp(Integer codiceImpianto, RequestTerzoResponsabile request) throws SigitextException, SigitRComp4ManutDaoException {
		String nomeMetodo = "--------- setNuovoTerzoResp ---------";
		logger.debug(nomeMetodo + " - START");
		
		String verify = verifyContrattoTerzoResponsabile(request); 
		if (!verify.equals("OK")) {
			logger.error("Errore durante lo stato di verifica: " + verify);
			throw new SigitextException(verify);
		}
		
		try {
			SigitTContratto2019Dto contrattoDto = new SigitTContratto2019Dto();
			contrattoDto.setFkImpRuoloPfpgResp(getDbServiceImp().findSigitRImpRuoloPfpgByCodiceImpiantoAndRuolo(Integer.parseInt(request.getDatiImpianto().getCodiceImpianto())).get(0).getIdImpRuoloPfpg());
			contrattoDto.setFkPg3Resp(new BigDecimal(request.getUtenteLoggato().getRuoloLoggato().getIdPersonaGiuridica()));
			contrattoDto.setCodiceImpianto(new BigDecimal(codiceImpianto));
			contrattoDto.setDataInizio(new java.sql.Date(request.getDatiContratto().getData_inizio().getTime()));
			contrattoDto.setDataFine(new java.sql.Date(request.getDatiContratto().getData_fine().getTime()));
			contrattoDto.setFlgTacitoRinnovo(new BigDecimal(request.getDatiContratto().getFlg_tacito_rinnovo()));
			contrattoDto.setDataUltMod(new Timestamp(System.currentTimeMillis()));
			contrattoDto.setUtenteUltMod(request.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
			contrattoDto.setDataCaricamento(new Timestamp(System.currentTimeMillis()));
			contrattoDto.setNote(request.getDatiContratto().getNote());
			contrattoDto.setDataCessazione(null);
			contrattoDto.setDataInserimentoCessazione(null);
			contrattoDto.setFkTipoCessazione(0);
			contrattoDto.setMotivoCessazione(null);
			
			SigitTContratto2019Pk contratto2019Pk = getDbServiceImp().insertSigitTContratto2019(contrattoDto);
			
			for(Autodichiarazione autodichiarazione : request.getAutodichiarazioni()) {
				SigitRContr2019AutodichiarDto autodichiarazioneDto = new SigitRContr2019AutodichiarDto();
				autodichiarazioneDto.setId_contratto(contratto2019Pk.getIdContratto().intValue());
				autodichiarazioneDto.setId_autodichiarazione(autodichiarazione.getIdAutodichiarazione());
				autodichiarazioneDto.setFlg_nomina_cessa(autodichiarazione.getFlgNominaCessa());
				
				getDbServiceImp().insertSigitRContr2019Autodichiar(autodichiarazioneDto);
			}
			
			//List<SigitTLibrettoDto> librettoList = getDbServiceImp().cercaLibrettoByStato(Integer.parseInt(request.getDatiImpianto().getCodiceImpianto()), 2);
			getServiceManager().consolidaLibretto(Integer.parseInt(request.getDatiImpianto().getCodiceImpianto()), null, Constants.RUOLO_NOMINA, null, request.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
			
			//setto la pk generata
			request.getDatiContratto().setId_contratto(contratto2019Pk.getIdContratto().intValue());
			sendMailNominaTerzoResponsabile(codiceImpianto, request);

			Date now = new Date();
			if (
					(now.after(contrattoDto.getDataInizio()) || now.equals(contrattoDto.getDataInizio())) &&
					(now.before(contrattoDto.getDataFine()) || now.equals(contrattoDto.getDataFine()))) {
				SigitRComp4ManutDto input = new SigitRComp4ManutDto();
				input.setCodiceImpianto(new BigDecimal(codiceImpianto));

				List<SigitRComp4ManutDto> comp4manutList = getDbServiceImp().getSigitRComp4ManutDao().findAttiviByFilter(input);

				List<Componente> componenti = new ArrayList<>();
				for (SigitRComp4ManutDto comp4Manut : comp4manutList) {
					Componente componente = new Componente();
					componente.setIdTipoComponente(comp4Manut.getIdTipoComponente());
					componente.setProgressivo(comp4Manut.getProgressivo().intValue());

					componenti.add(componente);
				}

				SubentroComponente subentro = new SubentroComponente();
				subentro.setComponenti(componenti);
				subentro.setUtenteLoggato(request.getUtenteLoggato());

				setSubentroComponente(codiceImpianto.toString(), contrattoDto.getFkPg3Resp().toString(), true, subentro);
			}
		} catch (NumberFormatException | SigitRImpRuoloPfpgDaoException e) {
			logger.debug("Error when try to retrieve SigitRImpRuoloPfpg: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new SigitextException("Errore: l'operazione non è andata a buon fine. Riprovare il salvataggio.", e);
        } catch (ServiceException e) {
			logger.debug("Error in consolidaLibretto: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new SigitextException("Errore: l'operazione non è andata a buon fine. Riprovare il salvataggio.", e);
		} catch (Exception e) {
			logger.debug("Error when try to retrieve SigitDRuoloDaoException: " + e);
			logger.debug(nomeMetodo + " - END WITH ERRORS");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new SigitextException("Errore: l'operazione non è andata a buon fine. Riprovare il salvataggio.", e);
		}
		
		
		logger.debug(nomeMetodo + " - END");
		return "OK";
	}

	private void sendMailNominaTerzoResponsabile(Integer codiceImpianto, RequestTerzoResponsabile request) throws SigitTContratto2019DaoException, SigitRImpRuoloPfpgDaoException, SigitextException, ServiceException, SigitDRuoloDaoException {
		logger.debug("sendMailNominaTerzoResponsabile - START");
		SigitTContratto2019Dto contrattoDto;
		String mailResponsabile;

		try {
			contrattoDto = getDbServiceImp().findSigitTContratto2019ByIdContrattoAndCodiceImpianto(request.getDatiContratto().getId_contratto(), codiceImpianto);
			logger.debug("findSigitRImpRuoloPfpgListById con fkImpRuoloPfgpResp : " + contrattoDto.getFkImpRuoloPfpgResp().intValue());
			SigitRImpRuoloPfpgDto impRuolo = getDbServiceImp().findSigitRImpRuoloPfpgListById(contrattoDto.getFkImpRuoloPfpgResp().intValue()).get(0);
			logger.debug("imp ruolo getFkPersonaFisica" + impRuolo.getFkPersonaFisica());
			String denominazioneResponsabile = "";
			if(impRuolo.getFkPersonaFisica() != null) {
				SigitTPersonaFisicaDto fisicaDto = getDbServiceImp().cercaTPersonaFisicaById(impRuolo.getFkPersonaFisica().intValue());
				mailResponsabile = fisicaDto.getEmail();
				denominazioneResponsabile = fisicaDto.getCognome() + " " + fisicaDto.getNome()  ;
			}else {
				SigitTPersonaGiuridicaDto giuridicaDto = getDbServiceImp().cercaPersonaGiuridicaById(impRuolo.getFkPersonaGiuridica());
				mailResponsabile = giuridicaDto.getEmail();
				denominazioneResponsabile = giuridicaDto.getDenominazione();
			}
			
			SigitTImpiantoDto impianto = getDbServiceImp().getImpiantoByCod(new BigDecimal(codiceImpianto));
			
			UnitaImmobiliareDto unitaImmobiliari = null;
			try {
				unitaImmobiliari = getDbServiceImp().getUnitaImmobiliareDao().findPrincipaleByCodiceImpianto(codiceImpianto);
			} catch (UnitaImmobiliareDaoException e1) {
				logger.error(String.format("Impossibile trovare un unità immobiliare principale per l'impianto %d di conseguenza non é possibile recuperare l'ubicazione", codiceImpianto));
				return;
			}
			
			SigitDRuoloDto sigitDRuoloDto = getDbServiceImp().findSigitDRuoloById(impRuolo.getFkRuolo().intValue());
			
			
			SigitTPersonaGiuridicaDto terzoResponsabile = getDbServiceImp().cercaPersonaGiuridicaById(contrattoDto.getFkPg3Resp());
			String mailTerzoResponsabile = terzoResponsabile.getEmail();
			String object = "[CIT] Nomina terzo responsabile: impianto " + request.getDatiImpianto().getCodiceImpianto() + "";
	
			StringBuilder testoHtml = new StringBuilder();
			testoHtml.append("L'impresa " + terzoResponsabile.getDenominazione() + " " +  terzoResponsabile.getSiglaRea() + " " + terzoResponsabile.getNumeroRea() + " dichiara di essere terzo responsabile dell'impianto in oggetto.<br/><br/>");
			testoHtml.append("<b>Descrizione impianto</b><br/>");
			testoHtml.append("Codice impianto: " + request.getDatiImpianto().getCodiceImpianto() + "<br/>");
			String indirizzo = unitaImmobiliari.getIndirizzoNonTrovato() != null && !unitaImmobiliari.getIndirizzoNonTrovato().isEmpty()  ? unitaImmobiliari.getIndirizzoNonTrovato() : unitaImmobiliari.getIndirizzoSitad(); 
			testoHtml.append("Localizzazione: " + indirizzo + " " + unitaImmobiliari.getCivico() + ", " + impianto.getDenominazioneComune() + " (" + impianto.getSiglaProvincia() + ") <br/>");
			testoHtml.append("<br/><b>Responsabile attuale</b><br/>");
			testoHtml.append("Denominazione: " +denominazioneResponsabile+ "<br/>");
			testoHtml.append("Titolo responsabilita': " + sigitDRuoloDto.getDesRuolo() +"<br/><br/>");
			testoHtml.append("<b>Descrizione contratto</b><br/>");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			testoHtml.append("Data inizio del contratto: " + sdf.format(request.getDatiContratto().getData_inizio()) + "<br/>");
			testoHtml.append("Data fine del contratto: " + sdf.format(request.getDatiContratto().getData_fine()) + "<br/>");
			if (request.getDatiContratto().getFlg_tacito_rinnovo() == 1) {
				testoHtml.append("Tacito rinnovo: SI<br/><br/>");
			} else {
				testoHtml.append("Tacito rinnovo: NO<br/><br/>");
			}
			if (request.getAutodichiarazioni() != null && request.getAutodichiarazioni().size() > 0) {
				testoHtml.append("<b>Autodichiarazione dei titoli e dello stato dell'impianto</b><br/>");
				for (Autodichiarazione autodichiarazione : request.getAutodichiarazioni()) {
					if (autodichiarazione.getFlgNominaCessa().contentEquals("N")) {
						testoHtml.append(autodichiarazione.getDesAutodichiarazione() + "<br/>");
					}
				}
			}
			testoHtml.append("<br/>N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa e-mail. ");
		
			ArrayList<String> emailAddress = new ArrayList<>();
			emailAddress.add(mailResponsabile);
			if (!mailTerzoResponsabile.isEmpty()) {
				emailAddress.add(mailTerzoResponsabile);
			}
			
			getServiceManager().sendMail(null, emailAddress, object, testoHtml.toString(), testoHtml.toString());
		} catch(Exception e) {
			logger.error("sendMailNominaTerzoResponsabile - Errore durante l'invio della mail di nomina al terzo responsabile", e);
		}
		logger.debug("sendMailNominaTerzoResponsabile - END");
	}
	
	
	private void sendMailCessazioneTerzoResponsabile(Integer codiceImpianto, RequestTerzoResponsabile request) throws SigitTContratto2019DaoException, SigitRImpRuoloPfpgDaoException, SigitextException, ServiceException, SigitDRuoloDaoException {
		logger.debug("sendMailCessazioneTerzoResponsabile - START");
		SigitTContratto2019Dto contrattoDto;
		contrattoDto = getDbServiceImp().findSigitTContratto2019ByIdContrattoAndCodiceImpianto(request.getDatiContratto().getId_contratto(), codiceImpianto);
		logger.debug("findSigitRImpRuoloPfpgListById con fkImpRuoloPfgpResp : " + contrattoDto.getFkImpRuoloPfpgResp().intValue());
		SigitRImpRuoloPfpgDto impRuolo = getDbServiceImp().findSigitRImpRuoloPfpgListById(contrattoDto.getFkImpRuoloPfpgResp().intValue()).get(0);
		logger.debug("imp ruolo getFkPersonaFisica" + impRuolo.getFkPersonaFisica());
		SigitTPersonaFisicaDto responsabileFisico = null;
		SigitTPersonaGiuridicaDto responsabileGiuridico = null;
		if(impRuolo.getFkPersonaFisica() != null) {
			responsabileFisico = getDbServiceImp().cercaTPersonaFisicaById(impRuolo.getFkPersonaFisica().intValue());
		    if (responsabileFisico == null) {
		        throw new ServiceException("Persona fisica non trovata per FkPersonaFisica: " + impRuolo.getFkPersonaFisica());
		    }
		}else {
			responsabileGiuridico = getDbServiceImp().cercaPersonaGiuridicaById(impRuolo.getFkPersonaGiuridica());
		    if (responsabileGiuridico == null) {
		        throw new ServiceException("Persona giuridica non trovata per FkPersonaGiuridica: " + impRuolo.getFkPersonaGiuridica());
		    }
		}
		String denominazioneResponsabile;
		String emailResponsabile = "";
		String ruoloDesc =  getDbServiceImp().findSigitDRuoloById(impRuolo.getFkRuolo().intValue()).getDesRuolo();
		if(responsabileFisico != null) {
			denominazioneResponsabile = responsabileFisico.getNome() + " " + responsabileFisico.getCognome();
			emailResponsabile = responsabileFisico.getEmail();
		}else {
			denominazioneResponsabile = responsabileGiuridico.getDenominazione();
			emailResponsabile = responsabileGiuridico.getEmail();
		}
		
		
		SigitTPersonaGiuridicaDto terzoResp =  getDbServiceImp().cercaPersonaGiuridicaById(contrattoDto.getFkPg3Resp());
		String emailTerzo = terzoResp.getEmail();
		logger.debug("email terzo: " + emailTerzo);
		logger.debug("email resp: " + emailResponsabile);
		try {
		String object = "[CIT] Cessazione terzo responsabile: impianto " + request.getDatiImpianto().getCodiceImpianto() + "";

		StringBuilder testoHtml = new StringBuilder();
		testoHtml.append("E' stata dichiara la cessazione per " +request.getDatiContratto().getFk_tipo_cessazione() + " della terza responsabilita' dell'impianto in oggetto. <br/>");
		testoHtml.append("<br/><b>Descrizione impianto</b><br/>");
		testoHtml.append("Codice impianto: " + request.getDatiImpianto().getCodiceImpianto() + "<br/>");
		testoHtml.append("Localizzazione: " + request.getDatiImpianto().getIndirizzoSitad() + " " + request.getDatiImpianto().getCivico() + ", " + request.getDatiImpianto().getComune() + " (" + request.getDatiImpianto().getSiglaProv() + ")<br/>");
		testoHtml.append("<br/><b>Responsabile attuale</b><br/>");
		testoHtml.append("Denominazione: "+ denominazioneResponsabile + "<br/>");
		testoHtml.append("Titolo responsabilita': " + ruoloDesc + "<br/>");
		testoHtml.append("<br/><b>Terzo responsabile</b><br/>");
		testoHtml.append("Denominazione: "+ terzoResp.getDenominazione() + "<br/>");
		testoHtml.append("Codice REA: " + terzoResp.getSiglaRea() +" "+ terzoResp.getNumeroRea() +"<br/>");
		testoHtml.append("<br/><b>Descrizione contratto</b><br/>");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		testoHtml.append("Data inizio del contratto: " + sdf.format(contrattoDto.getDataInizio()) + "<br/>");
		testoHtml.append("Data fine del contratto: " + sdf.format(contrattoDto.getDataFine()) + "<br/>");
		
		if(request.getDatiContratto().getFlg_tacito_rinnovo() == 1) {
			testoHtml.append("Tacito rinnovo: SI<br/><br/>");
		}else {
			testoHtml.append("Tacito rinnovo: NO<br/><br/>");
		}
		if(request.getAutodichiarazioni() != null && request.getAutodichiarazioni().size() > 0) {
			testoHtml.append("<b>Dichiarazione stato dell'impianto alla cessazione</b><br/>");	
			for(Autodichiarazione autodichiarazione : request.getAutodichiarazioni()) {
				testoHtml.append(autodichiarazione.getDesAutodichiarazione() + "<br/>");
			}
		}
		testoHtml.append("<br/>N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa e-mail. ");

		ArrayList<String> emailAddress = new ArrayList<>();
		emailAddress.add(emailResponsabile);
		if(!emailTerzo.isEmpty()) {
			emailAddress.add(emailTerzo);
		}
		
		getServiceManager().sendMail(null, emailAddress, object, testoHtml.toString(), testoHtml.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		logger.debug("sendMailCessazioneTerzoResponsabile - END");
	}
	
	private void sendMailCessazioneProvinciaTerzoResponsabile(Integer codiceImpianto, RequestTerzoResponsabile request, SigitTAccertamentoPk accertamentoPk, String mailComunicazioneProvincia) throws SigitTContratto2019DaoException, SigitRImpRuoloPfpgDaoException, SigitextException, ServiceException, SigitDRuoloDaoException {
		logger.debug("sendMailCessazioneTerzoResponsabile - START");
		logger.debug("emailComunicazione Provincia " + mailComunicazioneProvincia);

		SigitTContratto2019Dto contrattoDto;
		contrattoDto = getDbServiceImp().findSigitTContratto2019ByIdContrattoAndCodiceImpianto(request.getDatiContratto().getId_contratto(), codiceImpianto);
		logger.debug("findSigitRImpRuoloPfpgListById con fkImpRuoloPfgpResp : " + contrattoDto.getFkImpRuoloPfpgResp().intValue());
		SigitRImpRuoloPfpgDto impRuolo = getDbServiceImp().findSigitRImpRuoloPfpgListById(contrattoDto.getFkImpRuoloPfpgResp().intValue()).get(0);
		logger.debug("imp ruolo getFkPersonaFisica" + impRuolo.getFkPersonaFisica());
		SigitTPersonaFisicaDto responsabileFisico = null;
		SigitTPersonaGiuridicaDto responsabileGiuridico = null;
		if(impRuolo.getFkPersonaFisica() != null) {
			responsabileFisico = getDbServiceImp().cercaTPersonaFisicaById(impRuolo.getFkPersonaFisica().intValue());
		}else {
			responsabileGiuridico = getDbServiceImp().cercaPersonaGiuridicaById(impRuolo.getFkPersonaGiuridica());
		}
		String denominazioneResponsabile;
		String emailResponsabile = "";
		String ruoloDesc =  getDbServiceImp().findSigitDRuoloById(impRuolo.getFkRuolo().intValue()).getDesRuolo();
		if(responsabileFisico != null) {
			denominazioneResponsabile = responsabileFisico.getNome() + " " + responsabileFisico.getCognome();
			emailResponsabile = responsabileFisico.getEmail();
		}else {
			denominazioneResponsabile = responsabileGiuridico.getDenominazione();
			emailResponsabile = responsabileGiuridico.getEmail();
		}
		
		
		SigitTPersonaGiuridicaDto terzoResp =  getDbServiceImp().cercaPersonaGiuridicaById(contrattoDto.getFkPg3Resp());
		
		logger.debug(emailResponsabile);
		try {
		String object = "[CIT] Creato ACCERTAMENTO "+ accertamentoPk.getIdAccertamento() +" per decadenza terzo responsabile sull'impianto " + request.getDatiImpianto().getCodiceImpianto() + "";
		StringBuilder testoHtml = new StringBuilder();
		testoHtml.append("E' stata dichiara la cessazione per " +request.getDatiContratto().getFk_tipo_cessazione() + " della terza responsabilita' dell'impianto in oggetto. <br/>");
		testoHtml.append("<br/><b>Descrizione impianto</b><br/>");
		testoHtml.append("Codice impianto: " + request.getDatiImpianto().getCodiceImpianto() + "<br/>");
		testoHtml.append("Localizzazione: " + request.getDatiImpianto().getIndirizzoSitad() + " " + request.getDatiImpianto().getCivico() + ", " + request.getDatiImpianto().getComune() + " (" + request.getDatiImpianto().getSiglaProv() + ")<br/>");
		testoHtml.append("<br/><b>Responsabile attuale</b><br/>");
		testoHtml.append("Denominazione: "+ denominazioneResponsabile + "<br/>");
		testoHtml.append("Titolo responsabilita': " + ruoloDesc  + "<br/>");
		testoHtml.append("<br/><b>Terzo responsabile</b><br/>");
		testoHtml.append("Denominazione: "+ terzoResp.getDenominazione() + "<br/>");
		testoHtml.append("Codice REA: " + terzoResp.getSiglaRea() +" "+ terzoResp.getNumeroRea() +"<br/>");
		testoHtml.append("<br/><b>Descrizione contratto</b><br/>");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		testoHtml.append("Data inizio del contratto: " + sdf.format(contrattoDto.getDataInizio()) + "<br/>");
		testoHtml.append("Data fine del contratto: " + sdf.format(contrattoDto.getDataFine()) + "<br/>");
		
		if(request.getDatiContratto().getFlg_tacito_rinnovo() == 1) {
			testoHtml.append("Tacito rinnovo: SI<br/><br/>");
		}else {
			testoHtml.append("Tacito rinnovo: NO<br/><br/>");
		}
		if(request.getAutodichiarazioni() != null && request.getAutodichiarazioni().size()>0) {
			testoHtml.append("<b>Dichiarazione stato dell'impianto alla cessazione</b><br/>");	
			for(Autodichiarazione autodichiarazione : request.getAutodichiarazioni()) {
				testoHtml.append(autodichiarazione.getDesAutodichiarazione() + "<br/>");
			}
		}
		testoHtml.append("<br/>N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa e-mail. ");

		ArrayList<String> emailAddress = new ArrayList<>();
		emailAddress.add(mailComunicazioneProvincia);
		getServiceManager().sendMail(null, emailAddress, object, testoHtml.toString(), testoHtml.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		logger.debug("sendMailCessazioneTerzoResponsabile - END");
	}
	
	private void sendMailProrogaTerzoResponsabile(Integer codiceImpianto, RequestTerzoResponsabile request) throws SigitTContratto2019DaoException, SigitRImpRuoloPfpgDaoException, SigitextException, ServiceException, SigitDRuoloDaoException {
		logger.debug("sendMailProrogaTerzoResponsabile - START");
		SigitTContratto2019Dto contrattoDto;
		contrattoDto = getDbServiceImp().findSigitTContratto2019ByIdContrattoAndCodiceImpianto(request.getDatiContratto().getId_contratto(), codiceImpianto);
		logger.debug("findSigitRImpRuoloPfpgListById con fkImpRuoloPfgpResp : " + contrattoDto.getFkImpRuoloPfpgResp().intValue());
		SigitRImpRuoloPfpgDto impRuolo = getDbServiceImp().findSigitRImpRuoloPfpgListById(contrattoDto.getFkImpRuoloPfpgResp().intValue()).get(0);
		logger.debug("imp ruolo getFkPersonaFisica" + impRuolo.getFkPersonaFisica());
		SigitTPersonaFisicaDto responsabileFisico = null;
		SigitTPersonaGiuridicaDto responsabileGiuridico = null;
		if(impRuolo.getFkPersonaFisica() != null) {
			responsabileFisico = getDbServiceImp().cercaTPersonaFisicaById(impRuolo.getFkPersonaFisica().intValue());
		}else {
			responsabileGiuridico = getDbServiceImp().cercaPersonaGiuridicaById(impRuolo.getFkPersonaGiuridica());
		}
		String denominazioneResponsabile;
		String emailResponsabile = "";
		String ruoloDesc =  getDbServiceImp().findSigitDRuoloById(impRuolo.getFkRuolo().intValue()).getDesRuolo();
		if(responsabileFisico != null) {
			denominazioneResponsabile = responsabileFisico.getNome() + " " + responsabileFisico.getCognome();
			emailResponsabile = responsabileFisico.getEmail();
		}else {
			denominazioneResponsabile = responsabileGiuridico.getDenominazione();
			emailResponsabile = responsabileGiuridico.getEmail();
		}
		
		
		SigitTPersonaGiuridicaDto terzoResp =  getDbServiceImp().cercaPersonaGiuridicaById(contrattoDto.getFkPg3Resp());
		String emailTerzo = terzoResp.getEmail();
		try {
		String object = "[CIT] Proroga nomina terzo responsabile: impianto " + request.getDatiImpianto().getCodiceImpianto() + "";

		StringBuilder testoHtml = new StringBuilder();
		testoHtml.append("E' stata dichiara la proroga per la terza responsabilita' dell'impianto in oggetto. <br/>");
		testoHtml.append("<br/><b>Descrizione impianto</b><br/>");
		testoHtml.append("Codice impianto: " + request.getDatiImpianto().getCodiceImpianto() + "<br/>");
		testoHtml.append("Localizzazione: " + request.getDatiImpianto().getIndirizzoSitad() + " " + request.getDatiImpianto().getCivico() + ", " + request.getDatiImpianto().getComune() + " (" + request.getDatiImpianto().getSiglaProv() + ")<br/>");
		testoHtml.append("<br/><b>Responsabile attuale</b><br/>");
		testoHtml.append("Denominazione: "+ denominazioneResponsabile + "<br/>");
		testoHtml.append("Titolo responsabilita': " + ruoloDesc + "<br/>");
		testoHtml.append("<br/><b>Descrizione contratto</b><br/>");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		testoHtml.append("Data inizio del contratto: " + sdf.format(contrattoDto.getDataInizio()) + "<br/>");
		testoHtml.append("Data fine del contratto: " + sdf.format(contrattoDto.getDataFine()) + "<br/>");
		
		if(request.getDatiContratto().getFlg_tacito_rinnovo() == 1) {
			testoHtml.append("Tacito rinnovo: SI<br/><br/>");
		}else {
			testoHtml.append("Tacito rinnovo: NO<br/><br/>");
		}
		if(request.getAutodichiarazioni() != null && request.getAutodichiarazioni().size()>0) {
			testoHtml.append("<b>Dichiarazione stato dell'impianto alla cessazione<b><br/>");	
			for(Autodichiarazione autodichiarazione : request.getAutodichiarazioni()) {
				testoHtml.append(autodichiarazione.getDesAutodichiarazione() + "<br/>");
			}
		}
		testoHtml.append("N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa e-mail. ");

		ArrayList<String> emailAddress = new ArrayList<>();
		emailAddress.add(emailResponsabile);
		if(!emailTerzo.isEmpty()) {
			emailAddress.add(emailTerzo);
		}
		
		getServiceManager().sendMail(null, emailAddress, object, testoHtml.toString(), testoHtml.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		logger.debug("sendMailProrogaTerzoResponsabile - END");
	}
	
	private void sendMailSubentroComponente(Integer codiceImpianto, String idPersonaGiuridica, SubentroComponente subentro) throws SigitTContratto2019DaoException, SigitextException {
		logger.debug("sendMailSubentroComponente - START");
		List<SigitTContratto2019Dto> contrattoDtoList = getDbServiceImp().findSigitTContratto2019ByCodiceImpianto(codiceImpianto);
		SigitTContratto2019Dto contrattoDto = null;
		for(SigitTContratto2019Dto contratto: contrattoDtoList) {
			if(contratto.getDataCessazione() != null) {
				continue;
			}
			if(contratto.getFlgTacitoRinnovo().compareTo(BigDecimal.ONE) == 0) {
				contrattoDto = contratto;
				break;
			}
			if(contratto.getDataFine().after(new Date(System.currentTimeMillis())) 
					&& contratto.getDataInizio().before(new Date(System.currentTimeMillis()))){
				contrattoDto = contratto;
				break;
			}
		}
		
		if(contrattoDto == null || contrattoDto.getFkPg3Resp() == null) {
			logger.error(String.format("Impossibile trovare un contratto attivo per l'impianto %d di conseguenza non é possibile recuperare la mail del 3resp", codiceImpianto));
			return;
		}

		SigitTPersonaGiuridicaDto subentrante = getDbServiceImp().cercaPersonaGiuridicaById(new BigDecimal(idPersonaGiuridica));
		
		SigitTPersonaGiuridicaDto terzoResp =  getDbServiceImp().cercaPersonaGiuridicaById(contrattoDto.getFkPg3Resp());
		String emailTerzo = terzoResp.getEmail();
		UnitaImmobiliareDto unitaImmobiliari = null;
		try {
			unitaImmobiliari = getDbServiceImp().getUnitaImmobiliareDao().findPrincipaleByCodiceImpianto(codiceImpianto);
		} catch (UnitaImmobiliareDaoException e1) {
			logger.error(String.format("Impossibile trovare un unità immobiliare principale per l'impianto %d di conseguenza non é possibile recuperare l'ubicazione", codiceImpianto));
			return;
		}
		try {
		SigitTImpiantoDto impianto = getDbServiceImp().getImpiantoByCod(new BigDecimal(codiceImpianto));
		String indirizzo = unitaImmobiliari.getIndirizzoNonTrovato() != null ? unitaImmobiliari.getIndirizzoNonTrovato() : unitaImmobiliari.getIndirizzoSitad(); 
		String object = "[CIT] Avviso subentro su impianto " + codiceImpianto + "";
		StringBuilder testoHtml = new StringBuilder();
		testoHtml.append("L'impresa " + subentrante.getDenominazione() + ", " +  subentrante.getCodiceFiscale() +
				", con codice REA " + subentrante.getSiglaRea() + " " + subentrante.getNumeroRea() + "<br/>");
		testoHtml.append("ha effettuato il subentro su: <br/>");
		testoHtml.append("Codice Impianto: " + codiceImpianto + "<br/>");
		testoHtml.append("Ubicazione: " + indirizzo + " " + unitaImmobiliari.getCivico() + ", " + impianto.getDenominazioneComune() + " ("+ impianto.getSiglaProvincia() +")"+ "<br/>");
		testoHtml.append("con ruolo: ");

		Set<String> menutentori = new HashSet<>();
		for (Componente componente : subentro.getComponenti()) {
			String menutentore = String.format("Manutentore - %s", componente.getIdTipoComponente());
			menutentori.add(menutentore);
		}

		testoHtml.append(StringUtils.join(menutentori, ", "));
		testoHtml.append("<br/><br/>");

		testoHtml.append("N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa e-mail. ");

		ArrayList<String> emailAddress = new ArrayList<>();
		if(!emailTerzo.isEmpty()) {
			emailAddress.add(emailTerzo);
		}
		
		getServiceManager().sendMail(null, emailAddress, object, testoHtml.toString(), testoHtml.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		logger.debug("sendMailSubentroComponente - END");
	}
	
	public DatiIspezione getDettaglioIspezione(Integer idIspezione2018) throws DaoException, SigitextException {

		SigitTIspezione2018Dto sigitTIspezione2018Dto = dbIspezioneMgr.getDettaglioIspezione(idIspezione2018);
		
		if(sigitTIspezione2018Dto==null) {
			return new DatiIspezione();
		}
		SigitVRicercaImpiantiDto sigitVRicercaImpiantiDto = dbServiceImp.cercaImpiantoByCodImpianto(sigitTIspezione2018Dto.getCodiceImpianto());						
		
		List<SigitDStatoIspezioneDto> listSigitDStatoIspezioneDto = getStatoIspezione();
		
		List<SigitTUnitaImmobiliareDto> listSigitTUnitaImmobiliareDto  = new ArrayList<>();
		SigitTUnitaImmobiliareDto sigitTUnitaImmobiliareDtoOut = new SigitTUnitaImmobiliareDto();
		if(sigitTIspezione2018Dto.getCodiceImpianto() != null) {
			listSigitTUnitaImmobiliareDto = dbServiceImp.getUnitaImmobiliariImpianto(sigitTIspezione2018Dto.getCodiceImpianto().intValue());
			for (SigitTUnitaImmobiliareDto sigitTUnitaImmobiliareDtoIn : listSigitTUnitaImmobiliareDto) {
				if(sigitTUnitaImmobiliareDtoIn.getFlgPrincipale()!= null && sigitTUnitaImmobiliareDtoIn.getFlgPrincipale().equals(BigDecimal.ONE)) {
					sigitTUnitaImmobiliareDtoOut = sigitTUnitaImmobiliareDtoIn;
				}
			}
		}
		
		List<SigitRIspezIspetDto> listSigitRIspezIspetDto  = dbIspezioneMgr.getSigitRIspezIspetByIdIspezione2018(new BigDecimal(idIspezione2018));

		BigDecimal idIspezIspet = BigDecimal.ZERO;
		String cfUtente = "";
		String denomUente = "";
		if(listSigitRIspezIspetDto!=null && !listSigitRIspezIspetDto.isEmpty()) {
			BigDecimal fkPersonaFisica = BigDecimal.ZERO;
			for(SigitRIspezIspetDto sigitRIspezIspetDto : listSigitRIspezIspetDto) {
				BigDecimal idIspezIspetCorrente = sigitRIspezIspetDto.getIdIspezIspet();
				if(idIspezIspetCorrente.compareTo(idIspezIspet) >0) {
					fkPersonaFisica = sigitRIspezIspetDto.getFkPersonaFisica();
					idIspezIspet = idIspezIspetCorrente;
				}
			}
						
			SigitTPersonaFisicaPk sigitTPersonaFisicaPk = new SigitTPersonaFisicaPk();
			sigitTPersonaFisicaPk.setIdPersonaFisica(fkPersonaFisica);
			SigitTPersonaFisicaDto personeFisiche = getDbServiceImp().getSigitTPersonaFisicaDao().findByPrimaryKey(sigitTPersonaFisicaPk);	
			if(personeFisiche!=null) {
				cfUtente = personeFisiche.getCodiceFiscale();
				denomUente=personeFisiche.getCognome()+" "+personeFisiche.getNome();
			}
		}		
		
		return DatiIspezioneMapper.getDatiIspezione(sigitTIspezione2018Dto, sigitVRicercaImpiantiDto, sigitTUnitaImmobiliareDtoOut, idIspezIspet, cfUtente, denomUente, listSigitDStatoIspezioneDto);
		
	}
	
	public List<DatiIspezione> getElencoIspezioni(Integer idVerifica, Integer idAccertamento,
			DatiIspezione datiIspezioneIn) throws SigitTIspezione2018DaoException {

		List<DatiIspezione> listDatiIspezione = new ArrayList<>();

		try {
			logger.debug("getElencoIspezioni - START");
			logger.debug("getElencoIspezioni - "+datiIspezioneIn);
			if (idVerifica == null && idAccertamento == null
					&& (datiIspezioneIn == null || datiIspezioneIn.vuoto())) {
				throw new BadRequestException("Nessun criterio impostato");
			}
			
			datiIspezioneIn.setFkAccertamento(idAccertamento);
			datiIspezioneIn.setFkVerifica(idVerifica);
			
			//conto occorrenze se eccedono il valore di defoult
			BigDecimal sizeListSigitTIspezione2018Dto = dbIspezioneMgr.getCountElencoIspezioni(datiIspezioneIn);
			logger.debug("sizeListSigitTIspezione2018Dto - "+sizeListSigitTIspezione2018Dto);
			if (sizeListSigitTIspezione2018Dto == null
					|| sizeListSigitTIspezione2018Dto.compareTo(dbIspezioneMgr.getMaxRigheRicAvzImp()) > 0) {
				throw new BadRequestException("La ricerca ha prodotto troppi risultati. Inserire criteri di ricerca piu' restrittivi e riprovare.");
			}

			//ricavo l'elenco delle ispezioni con i filtri in input
			List<SigitTIspezione2018Dto> listSigitTIspezione2018Dto = dbIspezioneMgr.getElencoIspezioni(datiIspezioneIn);
			logger.debug("listSigitTIspezione2018Dto - "+listSigitTIspezione2018Dto);
			List<SigitRIspezIspetDto> listSigitRIspezIspetDto = new ArrayList<>();
			
			//se é valorizzato il codice fiscale assegnatario
			if (datiIspezioneIn != null && datiIspezioneIn.getCfUtenteAssegn() != null
					&& !"".equalsIgnoreCase(datiIspezioneIn.getCfUtenteAssegn().trim())) {
				logger.debug(" getDbServiceImp() - "+ getDbServiceImp());
				logger.debug(" getDbServiceImp().getSigitTPersonaFisicaDao() - "+ getDbServiceImp().getSigitTPersonaFisicaDao());
				//ricavo la persona fisica relativa al codice fiscale
				List<SigitTPersonaFisicaDto> personeFisiche = getDbServiceImp().getSigitTPersonaFisicaDao().findByCodiceFiscale(datiIspezioneIn.getCfUtenteAssegn());
								
				logger.debug(" personeFisiche - "+ personeFisiche);
				if(personeFisiche!=null && personeFisiche.size()>0) {
					//ricavo l'elenco delle ispezioni assegnate alla persona fisica ottenuta dal codice fiscale
					listSigitRIspezIspetDto = dbIspezioneMgr.getSigitRIspezIspetByFkPersonaFisica(personeFisiche.get(0).getIdPersonaFisica());
					logger.debug("listSigitRIspezIspetDto - "+listSigitRIspezIspetDto);
					if(listSigitRIspezIspetDto == null || listSigitRIspezIspetDto.isEmpty()) {
						//codice fiscale assegnatario valorizzato ma nessuna ispezione assegnata al codice fiscale
						return new ArrayList<>(); 
					}
				}else {
					throw new SigitTIspezione2018DaoException("Persona non trovata per il codice fiscale");
				}
			}						
			
			SigitTPersonaFisicaDto sigitTPersonaFisicaDtoIn = null;
			if(datiIspezioneIn.getCfUtenteAssegn()!=null && !"".equals(datiIspezioneIn.getCfUtenteAssegn()) ) {
				List<SigitTPersonaFisicaDto> listSigitTPersonaFisicaDto = dbIspezioneMgr.getSigitTPersonaFisicaDao().findByCodiceFiscale(datiIspezioneIn.getCfUtenteAssegn());
				if(listSigitTPersonaFisicaDto != null && !listSigitTPersonaFisicaDto.isEmpty()) {
					sigitTPersonaFisicaDtoIn = listSigitTPersonaFisicaDto.get(0);
				}
			}
			if(datiIspezioneIn.getDenomUtenteAssegn()!=null && !"".equals(datiIspezioneIn.getDenomUtenteAssegn()) ) {
				sigitTPersonaFisicaDtoIn  = dbIspezioneMgr.getSigitTPersonaFisicaDao().findByDenominazione(datiIspezioneIn.getDenomUtenteAssegn());
			}

			for (SigitTIspezione2018Dto sigitTIspezione2018Dto : listSigitTIspezione2018Dto) {
			
				String cfUtente = "";
				String denomUtente = "";
				boolean add = true;
				BigDecimal fkPersonaFisica = BigDecimal.ZERO;
				listSigitRIspezIspetDto = dbIspezioneMgr.getSigitRIspezIspetDao().findByIdIspezione2018(new BigDecimal(sigitTIspezione2018Dto.getIdIspezione2018()));
				if(listSigitRIspezIspetDto!=null && listSigitRIspezIspetDto.size()>0) {
					Date dataFine = listSigitRIspezIspetDto.get(0).getDataFine();
					fkPersonaFisica = listSigitRIspezIspetDto.get(0).getFkPersonaFisica();
					BigDecimal idIspezIspet = listSigitRIspezIspetDto.get(0).getIdIspezione2018();
					for (SigitRIspezIspetDto sigitRIspezIspetDto : listSigitRIspezIspetDto) {
						if(sigitRIspezIspetDto.getDataFine()==null) {
							fkPersonaFisica = sigitRIspezIspetDto.getFkPersonaFisica();
							dataFine = sigitRIspezIspetDto.getDataFine();
						}
						else if(dataFine!=null && dataFine.before(sigitRIspezIspetDto.getDataFine())) {
							fkPersonaFisica = sigitRIspezIspetDto.getFkPersonaFisica();
							dataFine = sigitRIspezIspetDto.getDataFine();
						}else if(idIspezIspet!=null && idIspezIspet.compareTo(sigitRIspezIspetDto.getIdIspezIspet())<0){
							fkPersonaFisica = sigitRIspezIspetDto.getFkPersonaFisica();
							idIspezIspet = sigitRIspezIspetDto.getIdIspezIspet();
						}
					
					}
				
					SigitTPersonaFisicaPk sigitTPersonaFisicaPk = new SigitTPersonaFisicaPk();
					sigitTPersonaFisicaPk.setIdPersonaFisica(fkPersonaFisica);
					SigitTPersonaFisicaDto sigitTPersonaFisicaDto = dbIspezioneMgr.getSigitTPersonaFisicaDao().findByPrimaryKey(sigitTPersonaFisicaPk);
					
					if(sigitTPersonaFisicaDtoIn!=null && sigitTPersonaFisicaDto.getIdPersonaFisica().compareTo(sigitTPersonaFisicaDtoIn.getIdPersonaFisica())!=0) {
						add = false;
					}
				
					cfUtente = sigitTPersonaFisicaDto.getCodiceFiscale();
					denomUtente = sigitTPersonaFisicaDto.getCognome()+" "+sigitTPersonaFisicaDto.getNome();
				
				}
				
				List<SigitDStatoIspezioneDto> listSigitDStatoIspezioneDto = getStatoIspezione();
				
				SigitVRicercaImpiantiDto sigitVRicercaImpiantiDto = dbServiceImp.cercaImpiantoByCodImpianto(sigitTIspezione2018Dto.getCodiceImpianto());
				
				List<SigitTUnitaImmobiliareDto> listSigitTUnitaImmobiliareDto  = new ArrayList<>();
				SigitTUnitaImmobiliareDto sigitTUnitaImmobiliareDtoOut = new SigitTUnitaImmobiliareDto();
				if(sigitTIspezione2018Dto.getCodiceImpianto() != null) {
					listSigitTUnitaImmobiliareDto = dbServiceImp.getUnitaImmobiliariImpianto(sigitTIspezione2018Dto.getCodiceImpianto().intValue());
					for (SigitTUnitaImmobiliareDto sigitTUnitaImmobiliareDtoIn : listSigitTUnitaImmobiliareDto) {
						if(sigitTUnitaImmobiliareDtoIn.getFlgPrincipale()!= null && sigitTUnitaImmobiliareDtoIn.getFlgPrincipale().equals(BigDecimal.ONE)) {
							sigitTUnitaImmobiliareDtoOut = sigitTUnitaImmobiliareDtoIn;
						}
					}
				}
				
				if(datiIspezioneIn.getNonAssegnato()!=null && datiIspezioneIn.getNonAssegnato() && (listSigitRIspezIspetDto == null || listSigitRIspezIspetDto.isEmpty())) {					
					listDatiIspezione.add(DatiIspezioneMapper.getDatiIspezione(sigitTIspezione2018Dto, sigitVRicercaImpiantiDto, sigitTUnitaImmobiliareDtoOut, null, cfUtente, denomUtente, listSigitDStatoIspezioneDto));									
				}else if(add){
					listDatiIspezione.add(DatiIspezioneMapper.getDatiIspezione(sigitTIspezione2018Dto, sigitVRicercaImpiantiDto, sigitTUnitaImmobiliareDtoOut, null, cfUtente, denomUtente, listSigitDStatoIspezioneDto));					
				}
				
			}
			listDatiIspezione.sort(new Comparator<DatiIspezione>() {

				@Override
				public int compare(DatiIspezione o1, DatiIspezione o2) {						
					return o2.getIdIspezione2018().compareTo(o1.getIdIspezione2018());
				}
				
			});
					
			logger.debug("getElencoIspezioni - END");
		} catch (BadRequestException e) {
			logger.error(getStackTraceAsString(e));
			throw new BadRequestException(e.getMessage());		
		} catch (Exception e) {
			logger.error(getStackTraceAsString(e));
			throw new SigitTIspezione2018DaoException(e.getMessage());
		}
		return listDatiIspezione;
	}
	
	public static String getStackTraceAsString(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        return stringWriter.toString();
    }
	
//	private boolean isCfUtenteAssegn(List<SigitRIspezIspetDto> listSigitRIspezIspetDto,SigitTIspezione2018Dto sigitTIspezione2018Dto) {
//		
//		//se esistono degli assegnatari ed è stato scelto un assegnatario filtro i risultati
//		if (listSigitRIspezIspetDto != null && !listSigitRIspezIspetDto.isEmpty()) {
//			for (SigitRIspezIspetDto sigitRIspezIspetDto : listSigitRIspezIspetDto) {
//				if (sigitTIspezione2018Dto.getIdIspezione2018() == sigitRIspezIspetDto.getIdIspezione2018().intValue()) {
//					return true;
//				}
//			}	
//			
//			return false;
//		}
//				
//		return true;
//		
//	}

	public List<SigitDStatoIspezioneDto> getStatoIspezione() throws SigitDStatoIspezioneDaoException {	
		return dbIspezioneMgr.getStatoIspezione();
	}

	@Transactional
	public String setAzioneIspezione(Azione datiAzione, UtenteLoggato utenteLoggato, DocumentoPwa documentoPwa) throws SigitTIspezione2018DaoException, SigitextException {

		String nomeMetodo = "--------- setAzioneIspezione ---------";
		logger.debug(nomeMetodo + " - START");

		String response = "OK";
		try {
				UtenteLoggatoModel utenteLoggatoModel = new UtenteLoggatoModel();
				if (utenteLoggato != null && utenteLoggato.getPfLoggato() != null) {
					utenteLoggatoModel.setCodiceFiscale(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
					Persona persona = getDettaglioPersonaFisica(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
					if(persona!=null) {
						utenteLoggatoModel.setDenominazione(persona.getCognomeDenominazione()+" "+persona.getNome());
					}
				}
		
				SigitTIspezione2018Pk pk = new SigitTIspezione2018Pk();
				pk.setIdIspezione2018(datiAzione.getFkAzione());
				SigitTIspezione2018Dto sigitTIspezione2018Dto = getServiceManager().getDbServiceImp().getSigitTIspezione2018Dao().findByPrimaryKey(pk);
		
				if (sigitTIspezione2018Dto != null) {
					SigitTAzioneDto sigitTAzioneDto = MapDto.mapToSigitTAzioneDto(Constants.ID_TIPO_AZIONE_ISPEZIONE,
							datiAzione);
					sigitTAzioneDto.setFkAccertamento(0);
					sigitTAzioneDto.setFkVerifica(0);
					sigitTAzioneDto.setFkSanzione(0);
					sigitTAzioneDto.setFkTipoAzione(3);
					sigitTAzioneDto.setCfUtenteAzione(utenteLoggatoModel.getCodiceFiscale());
					sigitTAzioneDto.setDenomUtenteAzione(utenteLoggatoModel.getDenominazione());
					getServiceManager().getDbServiceImp().getSigitTAzioneDao().insert(sigitTAzioneDto);
		
					if (documentoPwa != null && documentoPwa.getDoc() != null && documentoPwa.getDoc().length > 0) {
						documentoPwa.setDimensione((long) documentoPwa.getDoc().length);
						response = setDocumento(documentoPwa, null, utenteLoggatoModel.getCodiceFiscale(),
								sigitTIspezione2018Dto.getCodiceImpianto().intValue(), sigitTAzioneDto.getIdAzione(),
								"azione_ispezione", null, null);
					}
		
					if ("OK".equalsIgnoreCase(response)) {
		
						response = "" + sigitTAzioneDto.getIdAzione();
		
					}
				}
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();			
			logger.error(e);
			throw e;
		}
	
		logger.debug(nomeMetodo + " - END");
		return response;
	}

	public List<Assegnatario> getIspettore() throws SigitextException {

		logger.debug("[ServiceManager::getIspettore] BEGIN");

		List<Assegnatario> listAssegnatario = new ArrayList<>();
		try {
			listAssegnatario = getDbServiceImp().getSigitRPfRuoloPaDao().findAllIspettori();

		} catch (Exception e) {
			logger.error("[ServiceManager::getIspettore] Errore : ", e);
			throw new SigitextException(e.getMessage(), e);
		} finally {
			logger.debug("[ServiceManager::getgetIspettoreAssegnatario] END");
		}
		return listAssegnatario;

	}

	public String setLibSch2IdImpianto(Integer codiceImpianto, Scheda2 scheda2, String cfUtenteLoggato) throws SigitextException {
		String nomeMetodo = "--------- setLibSch2IdImpianto ---------";
		logger.debug(nomeMetodo + " - START");
		String endWithError = nomeMetodo + " - END with error";

		logger.debug("codiceImpianto: " + codiceImpianto);
		logger.debug("cfUtenteLoggato: " + cfUtenteLoggato);

		try {
			boolean isNew = false;
			SigitTImpiantoDto sigitTImpiantoDto = getDbServiceImp().cercaImpiantoDtoById(codiceImpianto.toString());

			if (sigitTImpiantoDto != null && sigitTImpiantoDto.getFkStato().compareTo(BigDecimal.ONE) == 0) {
				
				SigitTTrattH2OPk sigitTTrattH2OPk = new SigitTTrattH2OPk();
				sigitTTrattH2OPk.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
				SigitTTrattH2ODto sigitTTratH2ODto = getDbServiceImp().getSigitTTrattH2ODao().findByPrimaryKey(sigitTTrattH2OPk);
				if(sigitTTratH2ODto == null) {
					isNew = true;
					sigitTTratH2ODto = new SigitTTrattH2ODto();
				}
				sigitTTratH2ODto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
		        sigitTTratH2ODto.setL21H2oClimaM3(scheda2.getL21H2oClimam3());
		        sigitTTratH2ODto.setL22DurezzaH2oFr(scheda2.getL22DurezzaH2oFr());
		        sigitTTratH2ODto.setL23FlgTrattRiscNonRich(scheda2.getL23FlgTrattRiscNonRich());
		        sigitTTratH2ODto.setL23FlgTrattClimaAssente(scheda2.getL23FlgTrattClimaAssente());
		        sigitTTratH2ODto.setL23DurezzaTotH2oFr(scheda2.getL23DurezzaTotH2oFr());
		        sigitTTratH2ODto.setL23FlgTrattClimaFiltr(scheda2.getL23FlgTrattClimaFiltr());
		        sigitTTratH2ODto.setL23FlgTrattClimaAddolc(scheda2.getL23FlgTrattClimaAddolc());
		        sigitTTratH2ODto.setL23FlgTrattClimaChimico(scheda2.getL23FlgTrattClimaChimico());
		        sigitTTratH2ODto.setL23FlgTrattGeloAssente(scheda2.getL23FlgTrattGeloAssente());
		        sigitTTratH2ODto.setL23FlgTrattGeloGliEtil(scheda2.getL23FlgTrattGeloGliEtil());
		        sigitTTratH2ODto.setL23PercGliEtil(scheda2.getL23PercGliEtil());		                
                sigitTTratH2ODto.setL23PhGliEtil(scheda2.getL23PhGliEtil());
                sigitTTratH2ODto.setL23FlgTrattGeloGliProp(scheda2.getL23FlgTrattGeloGliProp());
                sigitTTratH2ODto.setL23PercGliProp(scheda2.getL23PercGliProp());
                sigitTTratH2ODto.setL23PhGliProp(scheda2.getL23PhGliProp());
                sigitTTratH2ODto.setL24FlgTrattAcsNonRich(scheda2.getL24FlgTrattAcsNonRich());
                sigitTTratH2ODto.setL24FlgTrattAcsAssente(scheda2.getL24FlgTrattAcsAssente());
                sigitTTratH2ODto.setL24FlgTrattAcsFiltr(scheda2.getL24FlgTrattAcsFiltr());
                sigitTTratH2ODto.setL24FlgTrattAcsAddolc(scheda2.getL24FlgTrattAcsAddolc());
                sigitTTratH2ODto.setL24DurezzaAddolcFr(scheda2.getL24DurezzaAddolcFr());
                sigitTTratH2ODto.setL24FlgTrattAcsChimico(scheda2.getL24FlgTrattAcsChimico());
                sigitTTratH2ODto.setL25FlgTrattRaffAssente(scheda2.getL25FlgTrattRaffAssente());
                sigitTTratH2ODto.setL25FlgTrattRaffNoRt(scheda2.getL25FlgTrattRaffNoRt());
                sigitTTratH2ODto.setL25FlgTrattRaffRtp(scheda2.getL25FlgTrattRaffRtp());
                sigitTTratH2ODto.setL25FlgTrattRaffRtt(scheda2.getL25FlgTrattRaffRtt());
                sigitTTratH2ODto.setL25FlgTrattRaffAcq(scheda2.getL25FlgTrattRaffAcq());
                sigitTTratH2ODto.setL25FlgTrattRaffPzz(scheda2.getL25FlgTrattRaffPzz());
                sigitTTratH2ODto.setL25FlgTrattRaffH2oSup(scheda2.getL25FlgTrattRaffH2oSup());
                sigitTTratH2ODto.setL25FlgTrattFFiltSic(scheda2.getL25FlgTrattFFiltSic());
                sigitTTratH2ODto.setL25FlgTrattFFiltMas(scheda2.getL25FlgTrattFFiltmas());
                sigitTTratH2ODto.setL25FlgTrattFNoTratt(scheda2.getL25FlgTrattFNoTratt());
                sigitTTratH2ODto.setL25TrattFAltro(scheda2.getL25TrattFAltro());
                sigitTTratH2ODto.setL25FlgTrattTAddolc(scheda2.getL25FlgTrattTAddolc());
                sigitTTratH2ODto.setL25FlgTrattTOsmosi(scheda2.getL25FlgTrattTOsmosi());
                sigitTTratH2ODto.setL25FlgTrattTDemin(scheda2.getL25FlgTrattTDemin());
                sigitTTratH2ODto.setL25FlgTrattTNoTratt(scheda2.getL25FlgTrattTNoTratt());
                sigitTTratH2ODto.setL25TrattTAltro(scheda2.getL25TrattTAltro());
                sigitTTratH2ODto.setL25FlgTrattCPaantincro(scheda2.getL25FlgTrattCPaantincro());
                sigitTTratH2ODto.setL25FlgTrattCPaanticorr(scheda2.getL25FlgTrattCPaanticorr());
                sigitTTratH2ODto.setL25FlgTrattCAaa(scheda2.getL25FlgTrattCAaa());
                sigitTTratH2ODto.setL25FlgTrattCBiocida(scheda2.getL25FlgTrattCBiocida());
                sigitTTratH2ODto.setL25FlgTrattCNoTratt(scheda2.getL25FlgTrattCNoTratt());
                sigitTTratH2ODto.setL25TrattCAltro(scheda2.getL25TrattCAltro());
                sigitTTratH2ODto.setL25FlgSpurgoAutom(scheda2.getL25FlgSpurgoAutom());
                sigitTTratH2ODto.setL25ConducH2oIng(scheda2.getL25ConducH2oIng());
                sigitTTratH2ODto.setL25Taratura(scheda2.getL25Taratura());
				
                if(isNew) {
                	getDbServiceImp().getSigitTTrattH2ODao().insert(sigitTTratH2ODto);
                }else {
                	getDbServiceImp().getSigitTTrattH2ODao().update(sigitTTratH2ODto);
                }


			} else {
				logger.error("SigitTImpianto not found");
				logger.debug(endWithError);
				throw new SigitextException("SigitTImpianto not found");
			}

		} catch (SigitTTrattH2ODaoException ex) {
			logger.error("Error when update SigitTTrattH2ODao: " + ex);
			logger.debug(endWithError);
			throw new SigitextException("Error when update SigitTImpiantoDto: " + ex);		
		} catch (Exception ex) {
			logger.error("Generic error: " + ex);
			logger.debug(endWithError);
			throw new SigitextException("Generic error: " + ex);
		}

		logger.debug(nomeMetodo + " - END");
		return "OK";
	}

	public DatiToken getDatiTokenImpresa(Integer idPersonaGiuridica) throws SigitextException {
		
		try {
			SigitTPersonaGiuridicaDto dto = getDbServiceImp().cercaPersonaGiuridicaById(new BigDecimal(idPersonaGiuridica));
			
			return MapDto.mapToDatiToken(dto);
					
		} catch (SigitextException e) {
			logger.error("SigitextManager.getDatiTokenImpresa - Errore durante l'esecuzione del servizio.", e);
			throw new SigitextException ("Errore durante il recupero dei dati del token impresa.", e);
		}
	}

	public DatiToken generateTokenImpresa(Integer idPersonaGiuridica) throws SigitextException {

		try {
			SigitTPersonaGiuridicaDto dto = getDbServiceImp().cercaPersonaGiuridicaById(new BigDecimal(idPersonaGiuridica));
			
			JWTDto jwtDto = creaTokenImpresa(dto);
			
			dto.setToken(jwtDto.getToken());
			dto.setDtCreazioneToken(ConvertUtil.convertToSqlDate(jwtDto.getDtCreazioneToken()));
			dto.setDtScadenzaToken(ConvertUtil.convertToSqlDate(jwtDto.getDtScadenzaToken()));
			
			getDbServiceImp().updateSigitTPersonaGiuridicaDao(dto);
			
			return MapDto.mapToDatiToken(dto);
			
		} catch (SigitextException e) {
			logger.error("SigitextManager.generateTokenImpresa - Errore durante la generazione del token impresa.", e);
			throw new SigitextException ("Errore durante la generazione del token impresa.", e);
		} catch (SigitTPersonaGiuridicaDaoException e) {
			logger.error("SigitextManager.generateTokenImpresa - Errore durante l'aggiornamento dei dati impresa.", e);
			throw new SigitextException ("Errore durante l'aggiornamento dei dati impresa.", e);
		} catch (Exception e) {
			logger.error("SigitextManager.generateTokenImpresa - Errore durante l'esecuzione del servizio.", e);
			throw new SigitextException ("Errore durante l'esecuzione del servizio.", e);
		}
	}

	private JWTDto creaTokenImpresa(SigitTPersonaGiuridicaDto dto) throws SigitextException {

		JWTDto jwtDto = new JWTDto(JWTUserEnum.IMPRESA);
		jwtDto.setIdPg(ConvertUtil.convertToString(dto.getIdPersonaGiuridica()));
		jwtDto.setSubject(MapDto.getCodiceRea(dto.getSiglaRea(), dto.getNumeroRea()));
		jwtDto = JWTUtil.createToken(jwtDto);
		
		return jwtDto;
	}

	public Integer getMaxNumImpiantiResults() throws SigitextException {
		
		try {
			return getServiceManager().getMaxNumImpiantiResults();
		} catch (SigitextException e) {
			logger.error("SigitextManager.getMaxNumImpiantiResults - Errore durante il recupero del massimo numero di impianti recuperabile.", e);
			throw new SigitextException ("Errore durante il recupero del massimo numero di impianti recuperabile.", e);
		}
	}

	public Integer getCombustyMaxNumImpiantiResults() throws SigitextException {
		
		try {
			return getServiceManager().getCombustyMaxNumImpiantiResults();
		} catch (SigitextException e) {
			logger.error("SigitextManager.getMaxNumImpiantiResults - Errore durante il recupero del massimo numero di impianti recuperabile.", e);
			throw new SigitextException ("Errore durante il recupero del massimo numero di impianti recuperabile.", e);
		}
	}

}
