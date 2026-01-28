package it.csi.sigit.sigitext.business.be.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URLConnection;
import java.nio.file.Files;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.xml.rpc.ServiceException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.parser.PdfTextExtractor;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.DocumentoAzioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.ImportFileSuper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.ImportFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.UtenteFunzionalitaFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.ClassDpr66096CITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.CombustibileCITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.ExtImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.FluidoCITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.FrequenzaManutCITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.MarcaCITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.PersonaGiuridica;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.RicercaAllegatiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDDettaglioGfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDDettaglioGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDFonteEnSfruttataDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDStatoImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoCannaFumariaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoInterventoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitExtImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitExtRespImpDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitExtVerificaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitLAccessoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompCgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompGfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompScDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRComp4ManutAllDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRComp4ManutDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRImpRuoloPfpgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfPgDelegaFindByPfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfRuoloPaFindByPfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPgPgNominaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAbilitazioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAccertamentoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAccertamentoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllegatoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzionePk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTComp4Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompCgCompletoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompGfCompletoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompGtCompletoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompScCompletoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTConsumoTipo1BDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTControlloLibrettoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDatoDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDatoDistribPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo1Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo2Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo3Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo4Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAzioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTElencoWsDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImpiantoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportXmlLibDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTIspezione2018Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTIspezione2018Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLibTxtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLibrettoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaFisicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaFisicaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPreImportDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo1Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo1Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo2Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo2Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo3Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo3Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo4Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo4Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTUnitaImmobiliareDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTUserWSDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTVerificaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTVerificaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicerca3ResponsabileDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicercaImpiantiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVTotImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.UnitaImmobiliareDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.UnitaMisuraCITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.UserElencoWsDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.WrkConfigDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRAllegatoCompCgDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRAllegatoCompGfDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRAllegatoCompGtDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRAllegatoCompScDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRComp4ManutDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRPfPgDelegaDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRPfRuoloPaDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRPgPgNominaDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTAbilitazioneDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTAllegatoDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTPersonaFisicaDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTPersonaGiuridicaDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.WrkConfigDaoException;
import it.csi.sigit.sigitext.business.pdf.DatiCGCommon;
import it.csi.sigit.sigitext.business.pdf.DatiGFCommon;
import it.csi.sigit.sigitext.business.pdf.DatiGTCommon;
import it.csi.sigit.sigitext.business.pdf.DatiLibretto;
import it.csi.sigit.sigitext.business.pdf.DatiSCCommon;
import it.csi.sigit.sigitext.business.pdf.LibrettoBuilder;
import it.csi.sigit.sigitext.business.pdf.ReeBuilder;
import it.csi.sigit.sigitext.business.pdf.RicevutaBuilder;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.ConvertUtil;
import it.csi.sigit.sigitext.business.util.DateUtil;
import it.csi.sigit.sigitext.business.util.GenericUtil;
import it.csi.sigit.sigitext.business.util.IndirizzoUtils;
import it.csi.sigit.sigitext.business.util.InputStreamDataSource;
import it.csi.sigit.sigitext.business.util.MapDto;
import it.csi.sigit.sigitext.business.util.Message;
import it.csi.sigit.sigitext.business.util.Messages;
import it.csi.sigit.sigitext.business.util.XmlBeanUtils;
import it.csi.sigit.sigitext.business.util.exceptions.ValidationManagerException;
import it.csi.sigit.sigitext.business.util.mail.Allegato;
import it.csi.sigit.sigitext.business.util.mail.Mail;
import it.csi.sigit.sigitext.business.util.mail.MailSender;
import it.csi.sigit.sigitext.business.util.mail.ResultInvioMail;
import it.csi.sigit.sigitext.business.ws.service.svista.client.Comune;
import it.csi.sigit.sigitext.business.ws.service.svista.client.LimammEnteServiceLocator;
import it.csi.sigit.sigitext.business.ws.service.svista.client.LimammEnte_PortType;
import it.csi.sigit.sigitext.business.ws.service.svista.client.Provincia;
import it.csi.sigit.sigitext.dto.Assegnatario;
import it.csi.sigit.sigitext.dto.index.DettaglioDocumento;
import it.csi.sigit.sigitext.dto.index.DettaglioDocumentoMultiplo;
import it.csi.sigit.sigitext.dto.sigitext.Accertamento;
import it.csi.sigit.sigitext.dto.sigitext.Azione;
import it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione;
import it.csi.sigit.sigitext.dto.sigitext.ConsumoPodPdr;
import it.csi.sigit.sigitext.dto.sigitext.Controlli;
import it.csi.sigit.sigitext.dto.sigitext.Controllo;
import it.csi.sigit.sigitext.dto.sigitext.ControlloDisponibile;
import it.csi.sigit.sigitext.dto.sigitext.DatiCG;
import it.csi.sigit.sigitext.dto.sigitext.DatiDistributore;
import it.csi.sigit.sigitext.dto.sigitext.DatiGF;
import it.csi.sigit.sigitext.dto.sigitext.DatiGT;
import it.csi.sigit.sigitext.dto.sigitext.DatiImpianto;
import it.csi.sigit.sigitext.dto.sigitext.DatiSC;
import it.csi.sigit.sigitext.dto.sigitext.DatiVerifica;
import it.csi.sigit.sigitext.dto.sigitext.DettaglioAllegato;
import it.csi.sigit.sigitext.dto.sigitext.DettaglioPersonaGiuridica;
import it.csi.sigit.sigitext.dto.sigitext.DettaglioVerifica;
import it.csi.sigit.sigitext.dto.sigitext.Documento;
import it.csi.sigit.sigitext.dto.sigitext.Impianto;
import it.csi.sigit.sigitext.dto.sigitext.ImpiantoFiltro;
import it.csi.sigit.sigitext.dto.sigitext.IndirizzoFiltro;
import it.csi.sigit.sigitext.dto.sigitext.Libretto;
import it.csi.sigit.sigitext.dto.sigitext.ListaImpiantiGeo;
import it.csi.sigit.sigitext.dto.sigitext.Metadati;
import it.csi.sigit.sigitext.dto.sigitext.PdfControllo;
import it.csi.sigit.sigitext.dto.sigitext.PersonaFisica;
import it.csi.sigit.sigitext.dto.sigitext.RappControllo;
import it.csi.sigit.sigitext.dto.sigitext.Responsabile;
import it.csi.sigit.sigitext.dto.sigitext.RifCatastale;
import it.csi.sigit.sigitext.dto.sigitext.RisultatoRicResponsabile;
import it.csi.sigit.sigitext.dto.sigitext.Scheda1;
import it.csi.sigit.sigitext.dto.sigitext.TipoVerificaEnum;
import it.csi.sigit.sigitext.dto.sigitext.UtenteJWT;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggatoModel;
import it.csi.sigit.sigitext.dto.sigitext.Verifica;
import it.csi.sigit.sigitext.dto.sigitext.geojson.Feature;
import it.csi.sigit.sigitext.dto.sigitext.geojson.FeatureCollection;
import it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException;
import it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.CheckListDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiIdentificativiDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiIntestazioneDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiManutentoreDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DocumentazioneTecnicaDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.FumiFN;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.Portata;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowAllegatoIIDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.TrattamentoAcquaDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.MODIIBDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.RowAcquaReintegroDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.RowAllegatoIIBDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.RowCombustibileDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.UM;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.ModalitaRaRi;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowAllegatoIIIDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RowAllegatoIVDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RowAllegatoVDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.LibrettoDocument;
import it.csi.sigit.sigitwebn.xml.libretto.data.MODDocument;
import it.csi.wso2.apiman.oauth2.helper.GenericWrapperFactoryBean;
import it.csi.wso2.apiman.oauth2.helper.OauthHelper;
import it.csi.wso2.apiman.oauth2.helper.TokenRetryManager;
import it.csi.wso2.apiman.oauth2.helper.WsProvider;
import it.csi.wso2.apiman.oauth2.helper.extra.axis1.Axis1Impl;
import it.doqui.index.ecmengine.client.webservices.dto.Node;
import it.doqui.index.ecmengine.client.webservices.dto.OperationContext;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.Content;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.Mimetype;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.Property;
import it.doqui.index.ecmengine.client.webservices.dto.engine.search.NodeResponse;
import it.doqui.index.ecmengine.client.webservices.dto.engine.search.ResultContent;
import it.doqui.index.ecmengine.client.webservices.dto.engine.search.SearchParams;
import it.doqui.index.ecmengine.client.webservices.dto.engine.search.SearchResponse;
import it.doqui.index.ecmengine.client.webservices.dto.engine.security.Document;
import it.doqui.index.ecmengine.client.webservices.dto.engine.security.EnvelopedContent;
import it.doqui.index.ecmengine.mtom.dto.Attachment;
import it.doqui.index.ecmengine.mtom.dto.MtomNode;
import it.doqui.index.ecmengine.mtom.dto.MtomOperationContext;
import it.doqui.index.ecmengine.mtom.exception.MtomException;

public class ServiceManager {

	private static final String PROPERTIES_RESOURCE = "/META-INF/sigitext.properties";

	private DbServiceImp serviceDb;

	private DocumentBuilderManager documentBuilderManager;

	private LibrettoBuilder librettoBuilderService;

	private ValidationManager validationManager;

	private ConnectorManager connectorManager;

	public ConnectorManager getConnectorManager() {
		return connectorManager;
	}

	public void setConnectorManager(ConnectorManager connectorManager) {
		this.connectorManager = connectorManager;
	}

	public ValidationManager getValidationManager() {
		return validationManager;
	}

	public void setValidationManager(ValidationManager validationManager) {
		this.validationManager = validationManager;
	}

	public DbServiceImp getDbServiceImp() {
		return serviceDb;
	}

	public void setDbServiceImp(DbServiceImp serviceDb) {
		this.serviceDb = serviceDb;
	}

	public LibrettoBuilder getLibrettoBuilderService() {
		return librettoBuilderService;
	}

	public void setLibrettoBuilderService(LibrettoBuilder librettoBuilderService) {
		this.librettoBuilderService = librettoBuilderService;
	}

	public DocumentBuilderManager getDocumentBuilderManager() {
		return documentBuilderManager;
	}

	public void setDocumentBuilderManager(DocumentBuilderManager documentBuilderManager) {
		this.documentBuilderManager = documentBuilderManager;
	}

	private IndexServiceImp serviceIndex;

	public IndexServiceImp getServiceIndex() {
		return serviceIndex;
	}

	public void setServiceIndex(IndexServiceImp serviceIndex) {
		this.serviceIndex = serviceIndex;
	}

	private MtomServiceImp cxf;

	private DbVerificaMgr dbVerificaMgr;

	private DbAzioneMgr dbAzioneMgr;

	private ReeBuilder reeBuilder;

	private RicevutaBuilder ricevutaBuilder;

	public ReeBuilder getReeBuilder() {
		return reeBuilder;
	}

	public void setReeBuilder(ReeBuilder reeBuilder) {
		this.reeBuilder = reeBuilder;
	}

	public RicevutaBuilder getRicevutaBuilder() {
		return ricevutaBuilder;
	}

	public void setRicevutaBuilder(RicevutaBuilder ricevutaBuilder) {
		this.ricevutaBuilder = ricevutaBuilder;
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

	public MtomServiceImp getCxf() {

		return cxf;
	}

	public void setCxf(MtomServiceImp cxf) {
		this.cxf = cxf;
	}

	protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE + ".SigitextManager==>");

	private static OauthHelper oauthHelper = null;

	protected LimammEnte_PortType getSvista() {
		
		String limammURL = getProperties().getProperty(Constants.SVISTA_WSDL_URL);
		String oauthURL = getProperties().getProperty(Constants.APIMAN_TOKEN_URL);
		String consumerKey = getProperties().getProperty(Constants.APIMAN_TOKEN_CONSUMERKEY);
		String consumerSecret = getProperties().getProperty(Constants.APIMAN_TOKEN_CONSUMERSECRET);	
		int timeout = Constants.APIMAN_TIMEOUT;
		
//		String limammURL = SRV_URL;
//		String oauthURL = TOKEN_URL;
//		String consumerKey = CONSUMER_KEY;
//		String consumerSecret = CONSUMER_SECRET;
		
//		log.info("oauthURL: " + oauthURL);
//		log.info("consumerKey: " + consumerKey);
//		log.info("consumerSecret: " + consumerSecret);

		LimammEnte_PortType limAmmEnte = null;

		try {
			
			LimammEnteServiceLocator serviceLoc = new LimammEnteServiceLocator();
			serviceLoc.setlimammEnteEndpointAddress(limammURL);
			LimammEnte_PortType port = serviceLoc.getlimammEnte();

			TokenRetryManager trm = new TokenRetryManager();
			trm.setOauthHelper(getOauthHelper(oauthURL, consumerKey, consumerSecret, timeout));
			
			WsProvider wsp = new Axis1Impl();
			trm.setWsProvider(wsp);
			GenericWrapperFactoryBean gwfb = new GenericWrapperFactoryBean();
			gwfb.setEndPoint(limammURL);
			gwfb.setWrappedClass(LimammEnte_PortType.class.getCanonicalName());
			gwfb.setTokenRetryManager(trm);
			gwfb.setPort(port);
			
			limAmmEnte = (LimammEnte_PortType) gwfb.create();

		
		} catch (javax.xml.rpc.ServiceException | ClassNotFoundException e) {
			logger.error("Errore SVISTA getSvita", e);
		}
		
		return limAmmEnte;
	}

	private static OauthHelper getOauthHelper(String oauthURL, String consumerKey, String consumerSecret, int timeout) {
		if (oauthHelper == null) {
			oauthHelper = new OauthHelper(
					oauthURL,
					consumerKey,
					consumerSecret, 
					timeout);
		}
		
		logger.debug("oauthHelper: "+oauthHelper.getToken());
		
		return oauthHelper;
	}

	public UtenteJWT isUtenteAutorizzato(String tokenJWT, int idFunzionalita) throws Exception {
		UtenteJWT utenteJWT = null;

		try {
			logger.debug("isUtenteAutorizzato - verifyToken - START");
			utenteJWT = GenericUtil.verifyToken(tokenJWT);
			logger.debug("isUtenteAutorizzato - verifyToken - END");
			String subjectJWT = utenteJWT.getSubject();
			logger.debug("subjectJWT: " + utenteJWT.getSubject());

			String idPersonaGiuridica = utenteJWT.getIdPersonaGiuridica();
			logger.debug("IdPersonaGiuridica: " + utenteJWT.getIdPersonaGiuridica());

			Integer idUtenteWS = null;

			if (subjectJWT.equals(Constants.SUBJECT_JWT_FRUITORE)) {

				logger.debug("codiceFruitore: " + utenteJWT.getCodiceFruitore());
				String codiceFruitore = utenteJWT.getCodiceFruitore();

				List<SigitTUserWSDto> utentiWS = getDbServiceImp().cercaUtenteWSByUserWS(codiceFruitore);

				if (utentiWS == null || utentiWS.isEmpty()) {
					throw new SigitextException(Messages.ERROR_TOKEN_NON_VALIDO);
				}
				logger.debug("utentiWS list: " + utentiWS.size());

				SigitTUserWSDto utenteWS = utentiWS.get(0);

				idUtenteWS = utenteWS.getIdUserWs();

				if (!codiceFruitore.equals(Constants.CODICE_FRUITORE_SIGIT)) {

					if (!utenteWS.getToken().equals(tokenJWT) || utenteWS.getDtScadenzaToken() == null || utenteWS.getDtScadenzaToken().compareTo(utenteJWT.getExpiration()) != 0) {
						throw new SigitextException(Messages.ERROR_TOKEN_NON_VALIDO);
					}
				} else {
					logger.debug("codiceFiscalePF: " + utenteJWT.getCodiceFiscalePersonaFisica());
					String codiceFiscalePF = utenteJWT.getCodiceFiscalePersonaFisica();

					List<SigitTPersonaFisicaDto> personeFisiche = getDbServiceImp().cercaPersonaFisicaByCodiceFiscale(codiceFiscalePF);
					SigitTPersonaGiuridicaDto personaGiuridica = null;

					if (idPersonaGiuridica != null) {

						personaGiuridica = getDbServiceImp().cercaPersonaGiuridicaById(ConvertUtil.convertToBigDecimal(idPersonaGiuridica));
					}

					if ((idPersonaGiuridica != null && personaGiuridica == null) || personeFisiche == null || personeFisiche.isEmpty()) {
						logger.debug("ECCEZIONE GESTITA START(isUtenteAutorizzato) risultato condizione in if");
						throw new SigitextException(Messages.ERROR_TOKEN_NON_VALIDO);
					}
					logger.debug("personeFisiche: " + personeFisiche.size());

				}

			} else {

				idUtenteWS = Constants.ID_USER_WS_FRUITORI_ESTERNI;

				SigitTPersonaGiuridicaDto personaGiuridica = getDbServiceImp().cercaPersonaGiuridicaById(ConvertUtil.convertToBigDecimal(idPersonaGiuridica));

				String codiceRea = MapDto.getCodiceRea(personaGiuridica.getSiglaRea(), ConvertUtil.convertToString(personaGiuridica.getNumeroRea()));

				if (!personaGiuridica.getToken().equals(tokenJWT) || !subjectJWT.equals(codiceRea) || personaGiuridica.getDtScadenzaToken() == null
						|| utenteJWT.getExpiration() == null || personaGiuridica.getDtScadenzaToken().compareTo(utenteJWT.getExpiration()) != 0) {
					throw new SigitextException(Messages.ERROR_TOKEN_NON_VALIDO);
				}

				Integer statoPg = personaGiuridica.getFkStatoPg();

				if (statoPg == Constants.ID_STATO_IMPRESA_CESSATA || statoPg == Constants.ID_STATO_IMPRESA_SOSPESA || statoPg == Constants.ID_STATO_IMPRESA_RADIATA) {
					throw new SigitextException(Messages.ERROR_IMPRESA_CESSATA);
				}
			}
			logger.debug("idUtenteWS: " + idUtenteWS);
			logger.debug("idFunzionalita: " + idFunzionalita);
			List<UserElencoWsDto> elencoWS = getDbServiceImp().getUserElencoWsDao().findByIdUtenteAndIdFunzionalita(new UtenteFunzionalitaFilter(idUtenteWS, idFunzionalita));
			if (elencoWS == null || elencoWS.isEmpty()) {
				throw new SigitUserNotAuthorizedException("Utente non autorizzato all'utilizzo del servizio");
			}
			logger.debug("elencoWS: " + elencoWS.size());

			logger.debug("L'utente e' autorizzato");
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		}
		return utenteJWT;
	}

	public boolean isAbilitatoSuImpianto(Integer codImpianto, UtenteJWT utenteJWT) throws SigitextException {

		if (utenteJWT.getSubject().equals(Constants.SUBJECT_JWT_FRUITORE)) {
			return true;
		}

		Integer idPersonaGiuridica = ConvertUtil.convertToInteger(utenteJWT.getIdPersonaGiuridica());

		if (idPersonaGiuridica == null || idPersonaGiuridica == 0) {
			return true;
		}

		List<SigitRComp4ManutDto> manutentori = getDbServiceImp().cercaManutentoriByPersonaGiuridicaCodiceImpiantoRuoloFunz(idPersonaGiuridica, codImpianto, Constants.RUOLO_IMPRESA);

		List<SigitRImpRuoloPfpgDto> assImpresaImpianto = getDbServiceImp().cercaAssociazioneImpresaImpiantoByPersonaGiuridicaCodiceImpiantoRuoloFunz(idPersonaGiuridica, codImpianto, Constants.RUOLO_CARICATORE);
		
		return !((manutentori == null || manutentori.isEmpty()) && (assImpresaImpianto == null || assImpresaImpianto.isEmpty()));
		
	}

	public boolean isDistributoreAttivo(UtenteJWT utenteJWT) throws SigitextException {

		if (utenteJWT.getSubject().equals(Constants.SUBJECT_JWT_FRUITORE)) {
			return true;
		}

		Integer idPersonaGiuridica = ConvertUtil.convertToInteger(utenteJWT.getIdPersonaGiuridica());
		
		SigitTPersonaGiuridicaDto personaGiuridica = getDbServiceImp().cercaPersonaGiuridicaById(new BigDecimal(idPersonaGiuridica));

		return personaGiuridica.getDataCessazione() == null && personaGiuridica.getFlgDistributore() == BigDecimal.ONE;
	}

	public void salvaAccesso(UtenteJWT utenteJWT, Integer idWebService) throws SigitextException {

		logger.debug("salvaAccesso - BEGIN");
		String subjectJWT = utenteJWT.getSubject();
		logger.debug("salvaAccesso - subjectJWT: " + subjectJWT);

		String codiceFruitore = utenteJWT.getCodiceFruitore();
		logger.debug("salvaAccesso - codiceFruitore: " + codiceFruitore);

		SigitTElencoWsDto webService = getDbServiceImp().cercaWsByidWs(idWebService);

		SigitLAccessoDto accessoDto = new SigitLAccessoDto();

		accessoDto.setDtAccesso(ConvertUtil.getSqlDataCorrente());

		accessoDto.setRuolo(webService.getDescrizioneWs());

		if (!subjectJWT.equals(Constants.SUBJECT_JWT_FRUITORE)) {
			String idPersonaGiuridica = utenteJWT.getIdPersonaGiuridica();

			SigitTPersonaGiuridicaDto personaGiuridicaDto = getDbServiceImp().cercaPersonaGiuridicaById(ConvertUtil.convertToBigDecimal(idPersonaGiuridica));
			logger.debug("[TEST UPPER CASE START] denominazione persona giuridica: " + personaGiuridicaDto.getDenominazione());
			accessoDto.setCodiceFiscale(personaGiuridicaDto.getCodiceFiscale());
			accessoDto.setCognome(personaGiuridicaDto.getDenominazione().toUpperCase());
			logger.debug("[TEST UPPER CASE END] cognome dto di accesso: " + accessoDto.getCognome());
		} else if (!codiceFruitore.equals(Constants.CODICE_FRUITORE_SIGIT)) {
			accessoDto.setCodiceFiscale(utenteJWT.getCodiceFruitore());
		} else {
			logger.debug("salvaAccesso - END WITHOUT SAVE");
			return;
		}

		getDbServiceImp().inserisciAccesso(accessoDto);
		logger.debug("salvaAccesso - END AFTER SAVE");
	}

	public boolean isAbilitatoSuLibretto(String uid, UtenteJWT utenteJWT) throws SigitextException {

		List<SigitTLibrettoDto> libretti = getDbServiceImp().cercaLibrettoByUid(uid);

		if (libretti == null || libretti.isEmpty()) {
			throw new SigitextException(Messages.ERROR_LIBRETTO_NON_TROVATO);
		}

		BigDecimal codiceImpianto = libretti.get(0).getCodiceImpianto();

		return isAbilitatoSuImpianto(ConvertUtil.convertToInteger(codiceImpianto), utenteJWT);

	}

	protected OperationContext indexGetOperationContext(String user) {
		String header = "!!!!indexGetOperationContext==>.";
		logger.debug(header + "inizio!!");

		OperationContext ctx = new OperationContext();
		ctx.setUsername(user);
		ctx.setPassword(Constants.INDEX_PSW);
		ctx.setNomeFisico(Constants.INDEX_UTENTE);
		ctx.setFruitore(Constants.INDEX_FRUITORE);
		ctx.setRepository(Constants.INDEX_REPOSITORY);
		logger.debug(header + "fine");

		return ctx;
	}

	ResultContent indexMetadatiByUid(String uid, OperationContext oc) {
		String header = "!!!!indexFileByUid==>.";
		logger.debug(header + "inizio!!");
		logger.debug(header + "uid: " + uid);

		ResultContent result = null;
		try {
			result = getServiceIndex().getEcmengineDelegate().getContentMetadata(new Node(uid), oc);

			//			if (logger.isDebugEnabled())
			//			{
			//				GenericUtil.stampa(result, true, 3); // commentato dopo il rilascio
			//			}
		} catch (Exception e) {

			logger.error(header + "errore= ", e);
		}

		logger.debug(header + "fine");
		return result;
	}

	byte[] indexFileByUid(String uid, String fileName, OperationContext oc) {
		String header = "!!!!indexFileByUid==>.";
		logger.debug(header + "inizio!!");

		byte[] result = null;
		try {
			result = getServiceIndex().getEcmengineDelegate().retrieveContentData(new Node(uid), indexGetContent(fileName), oc);

		} catch (Exception e) {

			logger.error(header + "errore= ", e);
		}

		logger.debug(header + "fine");
		return result;
	}

	public Content indexGetContent(String fileName) throws SigitextException {
		String header = "!!!!indexGetContent==>.";
		logger.debug(header + "inizio!!");
		Content myFile = new Content();
		myFile.setContentPropertyPrefixedName(Constants.INDEX_PREFIX_NAME);
		myFile.setPrefixedName(Constants.INDEX_PREFIX + fileName);
		myFile.setParentAssocTypePrefixedName(Constants.INDEX_PREFIX_CONTAINS);
		myFile.setTypePrefixedName(Constants.INDEX_ALLEGATO_NAME);
		myFile.setMimeType(indexGetMimeType(fileName));
		myFile.setEncoding(Constants.INDEX_ENCODING);
		logger.debug(header + "fine");
		return myFile;
	}

	private String indexGetMimeType(String fileName) throws SigitextException {
		logger.debug("[SigitextManager::indexGetMimeType] BEGIN");
		String estensione = StringUtils.substringAfterLast(fileName, ".");
		Mimetype mt = new Mimetype();
		logger.debug("[SigitextManager::indexGetMimeType] Estensione " + estensione);
		mt.setFileExtension(estensione);
		Mimetype[] mime = null;
		try {
			mime = getServiceIndex().getEcmengineDelegate().getMimetype(mt);
		} catch (RemoteException e) {
			throw new SigitextException("", e);
		}
		logger.debug("[SigitextManager::indexGetMimeType] Mime Type " + mime[0].getMimetype());
		logger.debug("[SigitextManager::indexGetMimeType] END");
		return mime[0].getMimetype();
	}

	public CodiceDescrizione[] getListaFluidoCIT() throws Exception {
		String header = "!!!!getListaFluidoCIT==>.";
		logger.debug(header + "inizio!!");
		CodiceDescrizione[] listone = new CodiceDescrizione[] {};

		try {

			List<FluidoCITDto> lista = getDbServiceImp().getFluidoCITDao().findAll();
			if (lista == null) {
				logger.debug(header + "lista =  null!!");

			} else {
				logger.debug(header + "lista not  null!!");

				listone = new CodiceDescrizione[lista.size()];

				//logger.debug(header+"listaPro not null");
				for (int i = 0; i < lista.size(); i++) {

					FluidoCITDto dto = new FluidoCITDto();
					dto = lista.get(i);
					if (dto != null) {

						CodiceDescrizione cod = new CodiceDescrizione();
						cod.setCodice(String.valueOf(dto.getIdFluido()));
						cod.setDescrizione(dto.getDesFluido());
						if (logger.isDebugEnabled()) {
							logger.debug(header + "cod.getCodice() = " + cod.getCodice());
							logger.debug(header + "cod.getDescrizione() = " + cod.getDescrizione());
						}
						listone[i] = cod;
					}

				}
			}

			logger.debug(header + "fine");
		} catch (Exception ex) {
			logger.error(header + "errore= ", ex);
		}
		return listone;

	}

	public Impianto[] getImpiantoByCodImpianto(Integer codImpianto) throws Exception {
		String header = "!!!!getImpiantoByCodImpianto==>.";
		logger.debug(header + "inizio!!");

		Impianto[] result = null;

		try {

			ArrayList<Impianto> listaImpiantiParz = getListImpiantoByCodImpianto(codImpianto);

			if (listaImpiantiParz != null && !listaImpiantiParz.isEmpty()) {
				result = listaImpiantiParz.toArray(new Impianto[listaImpiantiParz.size()]);
			}

			logger.debug(header + "fine");
		} catch (Exception ex) {
			logger.error(header + "errore= ", ex);
		}
		return result;

	}

	public ArrayList<Impianto> getListImpiantoByCodImpianto(Integer codiceImp) throws Exception {
		String header = "!!!!getImpiantoByCodice==>.";
		logger.debug(header + "inizio!!");
		ArrayList<Impianto> listaImpianti = new ArrayList<>();
		RifCatastale[] listaUi = new RifCatastale[] {};
		RappControllo[] listaRapp = new RappControllo[] {};

		try {
			List<ExtImpiantoDto> listaImpiantiDto = getDbServiceImp().getSigitExtDao().findImpiantiByCodice(codiceImp);
			if (listaImpiantiDto == null) {
				logger.debug(header + "lista =  null!!");

			} else {
				logger.debug(header + "lista not  null!!");

				for (int i = 0; i < listaImpiantiDto.size(); i++) {

					ExtImpiantoDto dto = new ExtImpiantoDto();
					dto = listaImpiantiDto.get(i);
					if (dto != null) {

						Impianto imp = new Impianto();

						imp.setCodiceImpianto(ConvertUtil.convertToInteger(dto.getCodiceImpianto()));
						imp.setStato(dto.getDesStato());
						imp.setDtAssegnazione(ConvertUtil.convertToString(dto.getDataAssegnazione()));
						imp.setDtDismissione(ConvertUtil.convertToString(dto.getDataDismissione()));
						imp.setMotivoDisimissione(dto.getMotivazione());

						imp.setIndirizzo(dto.getIndirizzo());
						imp.setCivico(dto.getCivico());
						imp.setDescComune(dto.getDenominazioneComune());
						imp.setSiglaProv(dto.getSiglaProvincia());

						imp.setCfResponsabile(dto.getCfResponsabile());
						imp.setDenomResponsabile(dto.getDenominazioneResponsabile());

						imp.setCf3Responsabile(dto.getCf3Responsabile());
						imp.setDenom3Responsabile(dto.getDenominazione3Responsabile());

						imp.setDtUltAggLibretto(ConvertUtil.convertToString(dto.getDataConsolidamento()));
						imp.setUidIndexLibretto(dto.getUidIndex());

						List<UnitaImmobiliareDto> listaUiDto = getDbServiceImp().getUnitaImmobiliareDao().findByCodiceImpianto(ConvertUtil.convertToInteger(dto.getCodiceImpianto()));

						RifCatastale rifC = null;
						listaUi = new RifCatastale[listaUiDto.size()];

						UnitaImmobiliareDto uiDto = null;
						for (int j = 0; j < listaUiDto.size(); j++) {

							uiDto = listaUiDto.get(j);

							rifC = new RifCatastale();

							rifC.setSezione(uiDto.getSezione());
							rifC.setFoglio(uiDto.getFoglio());
							rifC.setParticella(uiDto.getParticella());
							rifC.setSubalterno(uiDto.getSubalterno());
							rifC.setPod(uiDto.getPodElettrico());
							rifC.setPdr(uiDto.getPdrGas());

							listaUi[j] = rifC;
						}

						List<RicercaAllegatiDto> listaAllegatoDto = getDbServiceImp().getRicercaAllegatiDao().findInviatiByCodiceImpianto(ConvertUtil.convertToString(dto.getCodiceImpianto()));

						RappControllo rappC = null;
						listaRapp = new RappControllo[listaAllegatoDto.size()];

						RicercaAllegatiDto allegatoDto = null;
						for (int j = 0; j < listaAllegatoDto.size(); j++) {

							allegatoDto = listaAllegatoDto.get(j);

							rappC = new RappControllo();

							rappC.setDescTipoDoc(allegatoDto.getDesTipoDocumento());

							rappC.setSiglaBollino(allegatoDto.getFkSiglaBollino());
							rappC.setNumBollino(ConvertUtil.convertToString(allegatoDto.getFkNumeroBollino()));
							rappC.setDtControllo(ConvertUtil.convertToString(allegatoDto.getDataControllo()));
							rappC.setApparecchiature(allegatoDto.getElencoApparecchiature());
							rappC.setUidIndexLibretto(allegatoDto.getUidIndex());

							listaRapp[j] = rappC;
						}

						imp.setRifCatastali(listaUi);
						imp.setRappControllo(listaRapp);

						listaImpianti.add(imp);
					}

				}
			}

			logger.debug(header + "fine");
		} catch (Exception ex) {
			logger.error(header + "errore= ", ex);
		}
		return listaImpianti;
	}

	public Impianto[] getImpiantoByPod(String pod) throws Exception, SigitExcessiveResultsException {
		String header = "!!!!getImpiantoByPod==>.";
		logger.debug(header + "inizio!!");

		Impianto[] result = null;

		try {

			int maxResult = cercaConfigValueNumerico(Constants.MAX_RISULTATI_WS);

			logger.debug("STAMPO IL MAX DI RISULTATI: " + maxResult);

			ArrayList<Impianto> listaImpianti = new ArrayList<>();

			List<UnitaImmobiliareDto> listaUnitaImmDto = getDbServiceImp().getUnitaImmobiliareDao().findByPod(pod);

			if (logger.isDebugEnabled())
				logger.debug("STAMPO IL numero di unita immobiliari: " + listaUnitaImmDto);

			if (listaUnitaImmDto != null && !listaUnitaImmDto.isEmpty()) {
				if (listaUnitaImmDto.size() >= maxResult) {				
					throw new SigitExcessiveResultsException("Sono stati estratti troppi risultati");
				}
				
				for (UnitaImmobiliareDto unitaImmobiliareDto : listaUnitaImmDto) {

					ArrayList<Impianto> listaImpiantiParz = getListImpiantoByCodImpianto(ConvertUtil.convertToInteger(unitaImmobiliareDto.getCodiceImpianto()));

					if (listaImpiantiParz != null && !listaImpiantiParz.isEmpty()) {
						listaImpianti.addAll(listaImpiantiParz);
					}

				}

				result = listaImpianti.toArray(new Impianto[listaImpianti.size()]);
				
			}

			logger.debug(header + "fine");
		} catch (SigitExcessiveResultsException ex) {
			throw ex;
		} catch (Exception ex) {
			logger.error(header + "errore= ", ex);
		}
		return result;
	}
	
	public String cercaConfigValueString(String chiave) throws Exception {
		WrkConfigDto dto = null;
		String header = "!!!!cercaConfigValueString==>.";
		logger.debug(header + "inizio!!");
		dto = cercaConfigValue(chiave);
		logger.debug(header + "fine");
		return dto != null ? dto.getValoreConfigChar() : null;
	}

	private Integer cercaConfigValueNumerico(String chiave) throws Exception {
		WrkConfigDto dto = null;
		String header = "!!!!cercaConfigValueNumerico==>.";
		logger.debug(header + "inizio!!");
		dto = cercaConfigValue(chiave);
		logger.debug(header + "fine");
		return dto != null ? ConvertUtil.convertToInteger(dto.getValoreConfigNum()) : null;
	}

	public Boolean cercaConfigValueBooleano(String chiave) throws Exception {
		WrkConfigDto dto = null;
		String header = "!!!!cercaConfigValueNumerico==>.";
		logger.debug(header + "inizio!!");
		dto = cercaConfigValue(chiave);
		logger.debug(header + "fine");
		return ConvertUtil.convertToBoolean(dto!=null?dto.getValoreFlag():"");
	}

	private WrkConfigDto cercaConfigValue(String chiave) throws WrkConfigDaoException {

		String header = "!!!!cercaConfigValue==>.";
		logger.debug(header + "inizio!!");
		List<WrkConfigDto> dtoList = null;
		WrkConfigDto dto = null;
		logger.debug("[DbMgr::getConfigValue] BEGIN");
		dtoList = getDbServiceImp().getWrkConfigDao().findByChiaveConfig(chiave);

		if ((dtoList != null) && (!dtoList.isEmpty())) {
			dto = dtoList.get(0);
			logger.debug("[DbMgr::getConfigValue] Trovato il DTO " + dto);
		} else {
			logger.debug("[DbMgr::getConfigValue] Nessun DTO trovato");
		}
		logger.debug(header + "fine");
		return dto;
	}

	public Impianto[] getImpiantoByPdr(String pdr) throws Exception, SigitExcessiveResultsException {
		String header = "!!!!getImpiantoByPdr==>.";
		logger.debug(header + "inizio!!");
		Impianto[] result = null;

		try {

			int maxResult = cercaConfigValueNumerico(Constants.MAX_RISULTATI_WS);

			logger.debug("STAMPO IL MAX DI RISULTATI: " + maxResult);

			ArrayList<Impianto> listaImpianti = new ArrayList<>();

			List<UnitaImmobiliareDto> listaUnitaImmDto = getDbServiceImp().getUnitaImmobiliareDao().findByPdr(pdr);

			if (listaUnitaImmDto != null && !listaUnitaImmDto.isEmpty()) {
				if (listaUnitaImmDto.size() < maxResult) {
					for (UnitaImmobiliareDto unitaImmobiliareDto : listaUnitaImmDto) {

						ArrayList<Impianto> listaImpiantiParz = getListImpiantoByCodImpianto(ConvertUtil.convertToInteger(unitaImmobiliareDto.getCodiceImpianto()));

						if (listaImpiantiParz != null && !listaImpiantiParz.isEmpty()) {
							listaImpianti.addAll(listaImpiantiParz);
						}

					}

					result = listaImpianti.toArray(new Impianto[listaImpianti.size()]);
				} else {
					throw new SigitExcessiveResultsException("Sono stati estratti troppi risultati");
				}
			}

			logger.debug(header + "fine");
		} catch (SigitExcessiveResultsException ex) {
			throw ex;
		} catch (Exception ex) {
			logger.error(header + "errore= ", ex);
		}
		return result;

	}
	
	public Documento getDocumentoByUid(String uid) throws SigitextException {
		String header = "!!!!getDocumentoByUid==>.";
		logger.debug(header + "inizio!!");
		Documento result = null;
		try {
			OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_READ);
			result = new Documento();
			byte[] docByte = null;
			ResultContent metaDati = indexMetadatiByUid(uid, oc);
			logger.debug(uid);
			String nomeFile = metaDati.getPrefixedName().substring(6);

			docByte = indexFileByUid(uid, nomeFile, oc);

			result.setDoc(docByte);

			result.setUid(metaDati.getUid());

			result.setNome(nomeFile);
			result.setMimeType(metaDati.getMimeType());
			result.setEncoding(metaDati.getEncoding());

			logger.debug(header + "fine");
		} catch (Exception ex) {
			logger.error(header + "errore= ", ex);
			throw new SigitextException("Error in getDocumentoByUid: ", ex);
		}
		return result;

	}

	public Documento getLibrettoByUid(String uid) throws Exception {
		String header = "!!!!getLibrettoByUid==>.";
		logger.debug(header + "inizio!!");
		Documento result = null;
		try {
			OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_READ);
			result = new Documento();
			byte[] docByte = null;
			ResultContent metaDati = indexMetadatiByUid(uid, oc);
			logger.debug(uid);
			String nomeFile = metaDati.getPrefixedName().substring(6);

			docByte = indexFileByUid(uid, nomeFile, oc);

			result.setDoc(docByte);

			result.setUid(metaDati.getUid());

			result.setNome(nomeFile);
			result.setMimeType(metaDati.getMimeType());
			result.setEncoding(metaDati.getEncoding());

			logger.debug(header + "fine");
		} catch (Exception ex) {
			logger.error(header + "errore= ", ex);
		}
		return result;

	}
	
	public SigitTLibrettoDto getLibrettoDtoByUid(String uid) {
		String header = "!!!!getLibrettoDtoByUid==>.";
		logger.debug(header + "inizio!!");
		SigitTLibrettoDto result = null;
		try {
			List<SigitTLibrettoDto> libretti = getDbServiceImp().getSigitTLibrettoDao().findByUid(uid);
			if(libretti != null && !libretti.isEmpty()) {
				result = libretti.get(0);
			}
			logger.debug(header + "fine");
		} catch (Exception ex) {
			logger.error(header + "errore= ", ex);
		}
		return result;

	}

	public List<ControlloDisponibile> getControlliDisponibili(String codiceImpianto, String tipoComponente, String tipoControllo, Date dataControllo, Integer idPersonaGiuridica)
			throws SigitextException {
		logger.debug("[SigitManager::getControlliDisponibili] START");
		List<ControlloDisponibile> output = null;
		try {
			output = getDbServiceImp().getControlliDisponibili(codiceImpianto, tipoComponente, tipoControllo, dataControllo, idPersonaGiuridica);
			logger.debug(output);
		} catch (Exception e) {
			logger.error("Errore recupero controlli disponibili: ", e);
			throw new SigitextException("Errore recupero controlli disponibili", e);
		} finally {
			logger.debug("[SigitManager::getControlliDisponibili] END");
		}
		return output;
	}

	public Documento getXMLLibretto(Integer idImpianto, Boolean isConsolidato) {
		logger.debug("[ModuloBuilder::getXMLLibretto] START");
		Documento result;
		try {
			result = new Documento();

			byte[] docByte = getXmlModelLibrettoByte(idImpianto, isConsolidato);
			result.setDoc(docByte);
			result.setNome(getNomeFileXMLLibretto(idImpianto));
			result.setMimeType(Constants.MIME_TYPE_XML);
			result.setEncoding(Constants.UTF_8_ENCODING);

			return result;

		} catch (Exception e) {
			logger.error("Errore apertura file", e);
			return null;
		} finally {
			logger.debug("[ModuloBuilder::getXMLLibretto] END");
		}
	}

	private byte[] getXmlModelLibrettoByte(Integer idImpianto, Boolean isConsolidato) {
		logger.debug("[ModuloBuilder::getXmlModelLibrettoByte] START");

		//recupero il modello xml dal documento
		byte[] xmlByteArray = null;
		try {
			xmlByteArray = XmlBeanUtils.extractByteArray(getLibrettoDocument(idImpianto, isConsolidato));

			//logger.debug(new String(xmlByteArray,"UTF-8"));

			return xmlByteArray;
		} catch (Exception e) {
			logger.error("Errore", e);
			return new byte[0] ;
		} finally {
			logger.debug("[ModuloBuilder::getXmlModelLibrettoByte] END");
		}
	}

	private String getNomeFileXMLLibretto(Integer codiceImpianto) {
		StringBuilder nome = new StringBuilder();
		nome.append(Constants.FILE_PREFIX_TRACCIATO);
		nome.append("_");
		nome.append(Constants.FILE_PREFIX_LIBRETTO);
		nome.append("_");
		nome.append(codiceImpianto);
		nome.append("_");
		nome.append(ConvertUtil.convertToString(new Date(), ConvertUtil.FORMAT_DATE_UNDERSCORE));
		nome.append(".xml");
		return nome.toString();
	}

	private MODDocument getLibrettoDocument(Integer idImpianto, Boolean isConsolidato) throws Exception {
		logger.debug("[SigitextManager::getLibrettoDocument] BEGIN");
		try {

			logger.debug("Creiamo il libretto con i dati del DB");
			//	il libretto e' nullo, prendere i dati dal db anche quando NON ci sono libretti consolidati
			return getDbServiceImp().getModuloLibretto(idImpianto, ConvertUtil.convertToBooleanAllways(isConsolidato));
		} catch (Exception e) {
			logger.error("Errore getLibrettoDocument", e);
			throw new Exception(e);
		} finally {
			logger.debug("[SigitextManager::getLibrettoDocument] END");
		}
	}

	public CodiceDescrizione[] getListaCombustibileCIT() throws Exception {
		String header = "!!!!getListaCombustibileCIT==>.";
		logger.debug(header + "inizio!!");
		CodiceDescrizione[] listone = new CodiceDescrizione[] {};

		try {

			List<CombustibileCITDto> lista = getDbServiceImp().getCombustibileCITDao().findAll();
			if (lista == null) {
				logger.debug(header + "lista =  null!!");

			} else {
				logger.debug(header + "lista not  null!!");

				listone = new CodiceDescrizione[lista.size()];

				//logger.debug(header+"listaPro not null");
				for (int i = 0; i < lista.size(); i++) {
					
					CombustibileCITDto dto = lista.get(i);
					if (dto != null) {

						CodiceDescrizione cod = new CodiceDescrizione();
						cod.setCodice(String.valueOf(dto.getIdCombustibile()));
						cod.setDescrizione(dto.getDesCombustibile());
						logger.debug(header + "cod.getCodice() = " + cod.getCodice());
						logger.debug(header + "cod.getDescrizione() = " + cod.getDescrizione());
						listone[i] = cod;
					}

				}
			}

			logger.debug(header + "fine");
		} catch (Exception ex) {
			logger.error(header + "errore= ", ex);
		}
		return listone;

	}

	public CodiceDescrizione[] getListaClassDpr66096CIT() throws Exception {
		String header = "!!!!getListaClassDpr66096CIT==>.";
		logger.debug(header + "inizio!!");
		CodiceDescrizione[] listone = new CodiceDescrizione[] {};

		try {

			List<ClassDpr66096CITDto> lista = getDbServiceImp().getClassDpr66096CITDao().findAll();
			if (lista == null) {
				logger.debug(header + "lista =  null!!");

			} else {
				logger.debug(header + "lista not  null!!");

				listone = new CodiceDescrizione[lista.size()];

				//logger.debug(header+"listaPro not null");
				for (int i = 0; i < lista.size(); i++) {
					
					ClassDpr66096CITDto dto = lista.get(i);
					if (dto != null) {

						CodiceDescrizione cod = new CodiceDescrizione();
						cod.setCodice(String.valueOf(dto.getIdClass()));
						cod.setDescrizione(dto.getDesClass());
						logger.debug(header + "cod.getCodice() = " + cod.getCodice());
						logger.debug(header + "cod.getDescrizione() = " + cod.getDescrizione());
						listone[i] = cod;
					}

				}
			}

			logger.debug(header + "fine");
		} catch (Exception ex) {
			logger.error(header + "errore= ", ex);
		}
		return listone;

	}

	public CodiceDescrizione[] getListaFrequenzaManutCIT() throws Exception {
		String header = "!!!!getListaFrequenzaManutCIT==>.";
		logger.debug(header + "inizio!!");
		CodiceDescrizione[] listone = new CodiceDescrizione[] {};

		try {

			List<FrequenzaManutCITDto> lista = getDbServiceImp().getFrequenzaManutCITDao().findAll();
			if (lista == null) {
				logger.debug(header + "lista =  null!!");

			} else {
				logger.debug(header + "lista not  null!!");

				listone = new CodiceDescrizione[lista.size()];

				//logger.debug(header+"listaPro not null");
				for (int i = 0; i < lista.size(); i++) {
					
					FrequenzaManutCITDto dto = lista.get(i);
					if (dto != null) {

						CodiceDescrizione cod = new CodiceDescrizione();
						cod.setCodice(String.valueOf(dto.getIdFrequenza()));
						cod.setDescrizione(dto.getDesFrequenza());
						logger.debug(header + "cod.getCodice() = " + cod.getCodice());
						logger.debug(header + "cod.getDescrizione() = " + cod.getDescrizione());
						listone[i] = cod;
					}

				}
			}

			logger.debug(header + "fine");
		} catch (Exception ex) {
			logger.error(header + "errore= ", ex);
		}
		return listone;

	}

	public CodiceDescrizione[] getListaMarcaCIT() throws Exception {
		String header = "!!!!getListaMarcaCIT==>.";
		logger.debug(header + "inizio!!");
		CodiceDescrizione[] listone = new CodiceDescrizione[] {};
		try {
			List<MarcaCITDto> lista = getDbServiceImp().getMarcaCITDao().findAll();
			if (lista == null) {
				logger.debug(header + "lista =  null!!");
			} else {
				logger.debug(header + "lista not  null!!");
				listone = new CodiceDescrizione[lista.size()];
				for (int i = 0; i < lista.size(); i++) {
					MarcaCITDto dto;
					dto = lista.get(i);
					if (dto != null) {
						CodiceDescrizione cod = new CodiceDescrizione();
						cod.setCodice(String.valueOf(dto.getIdMarca()));
						cod.setDescrizione(dto.getDesMarca());
						listone[i] = cod;
					}
				}
			}
			logger.debug(header + "fine");
		} catch (Exception ex) {
			logger.error(header + "errore= ", ex);
		}
		return listone;
	}

	public CodiceDescrizione[] getListaUnitaMisuraCIT() throws Exception {
		String header = "!!!!getListaUnitaMisuraCIT==>.";
		logger.debug(header + "inizio!!");
		CodiceDescrizione[] listone = new CodiceDescrizione[] {};
		try {
			List<UnitaMisuraCITDto> lista = getDbServiceImp().getUnitaMisuraCITDao().findAll();
			if (lista == null) {
				logger.debug(header + "lista =  null!!");
			} else {
				logger.debug(header + "lista not  null!!");
				listone = new CodiceDescrizione[lista.size()];
				for (int i = 0; i < lista.size(); i++) {					 
					 UnitaMisuraCITDto dto = lista.get(i);
					if (dto != null) {
						CodiceDescrizione cod = new CodiceDescrizione();
						cod.setCodice(String.valueOf(dto.getIdUnitaMisura()));
						cod.setDescrizione(dto.getDesUnitaMisura());
						if (logger.isDebugEnabled()) {
							logger.debug(header + "cod.getCodice() = " + cod.getCodice());
							logger.debug(header + "cod.getDescrizione() = " + cod.getDescrizione());
						}
						listone[i] = cod;
					}
				}
			}
			logger.debug(header + "fine");
		} catch (Exception ex) {
			logger.error(header + "errore= ", ex);
		}
		return listone;
	}

	public Libretto getLibretto(Integer idImpianto, Boolean isConsolidato) {
		logger.debug("[ModuloBuilder::showLibretto] START");
		Libretto result;
		try {
			result = new Libretto();
			byte[] docByte = getXmlModelLibrettoByte(idImpianto, isConsolidato);
			DatiLibretto datiLibretto = getDbServiceImp().getDatiLibretto(idImpianto, isConsolidato);
			Documento doc = getLibrettoBuilderService().generaLibretto(datiLibretto, false, !isConsolidato);
			if (docByte != null) {
				result.setLibrettoXml(docByte);
			}
			result.setLibrettoPdf(doc);
			return result;
		} catch (Exception e) {
			logger.error("Errore apertura file", e);
			return null;
		} finally {
			logger.debug("[ModuloBuilder::showLibretto] END");
		}
	}
	
	public Scheda1 getSchedaLibretto(Integer idImpianto) {
		logger.debug("[ModuloBuilder::getSchedaLibretto] START");
		try {
			return getDbServiceImp().getSchedaLibretto(idImpianto);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Errore apertura file", e);
		} finally {
			logger.debug("[ModuloBuilder::getSchedaLibretto] END");
		}
		return null;
	}
	
	public Comune getComuneByCodIstat(String codiceIstat) throws ServiceException {
		
		logger.info("getComuneByCodIstat - codice: " + codiceIstat);
		
		Comune comune = null;
		try {
				logger.info("CALL cercaComunePerCodiceIstat START");
				comune = getSvista().cercaComunePerCodiceIstat(codiceIstat);
				logger.info("CALL cercaComunePerCodiceIstat END");
				return comune;
		} catch (RemoteException e) {
			throw new ServiceException(Messages.ERROR_RECUPERO_SERVIZIO, e);
		}
	}

	public Documento getXMLLibrettoConsolidato(Integer codiceImpianto) throws SigitextException, IOException {

		Documento xmlLibrettoConsolidato = new Documento();

		List<SigitTLibrettoDto> librettoList = getDbServiceImp().cercaLibrettoByStato(codiceImpianto, Constants.ID_STATO_LIBRETTO_CONSOLIDATO);

		if (librettoList == null || librettoList.isEmpty() || librettoList.get(0) == null) {
			// Non esiste un libretto consolidato
			throw new SigitextException(Messages.ERROR_NESSUN_LIBRETTO_CONSOLIDATO_TROVATO);
		}

		SigitTLibrettoDto libretto = librettoList.get(0);

		SigitTLibTxtDto libTxt = getDbServiceImp().getTxtLibretto(libretto.getIdLibretto());

		if (libTxt == null) {
			// Esiste il libretto su SigitTLibretto ma non esiste su SigitTLibTxt (sono 599500), consolidati dal 01/01/2016 al 10/11/2018
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		}

		byte[] fileXml = XmlBeanUtils.readString(libTxt.getXmlLibretto());

		xmlLibrettoConsolidato.setDoc(fileXml);
		xmlLibrettoConsolidato.setNome(libretto.getFileIndex() + ".xml");
		xmlLibrettoConsolidato.setMimeType(Constants.MIME_TYPE_XML);
		xmlLibrettoConsolidato.setEncoding(Constants.UTF_8_ENCODING);

		return xmlLibrettoConsolidato;
	}

	public void uploadXMLLibretto(Integer codiceImpianto, byte[] xml, UtenteJWT utenteJWT) throws SigitextException {

		if (codiceImpianto == null) {
			throw new SigitextException(Messages.ERROR_CODICE_IMPIANTO_NON_VALIDO);
		}

		SigitTImpiantoDto impianto = getDbServiceImp().getImpiantoByCod(ConvertUtil.convertToBigDecimal(codiceImpianto));
		List<SigitTUnitaImmobiliareDto> unitaImmobiliariImpianto = getDbServiceImp().getUnitaImmobiliariImpianto(codiceImpianto);

		if (impianto == null || unitaImmobiliariImpianto == null || unitaImmobiliariImpianto.isEmpty()) {
			throw new SigitextException(Messages.ERROR_IMPIANTO_NON_CENSITO);
		}

		SigitTControlloLibrettoDto controlloLibrettoImpianto = getDbServiceImp().getControlloLibretto(codiceImpianto);
		List<SigitTLibrettoDto> librettoImpianto = getDbServiceImp().getLibrettoByCodImpianto(codiceImpianto);
		SigitTImportXmlLibDto importXmlLibretto = getDbServiceImp().getImportXmlLibrettoByCodImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));

		if ((controlloLibrettoImpianto != null && ConvertUtil.convertToBooleanAllways(controlloLibrettoImpianto.getFlgL1Controlloweb())) || (librettoImpianto != null && librettoImpianto.size() != 0)
				|| importXmlLibretto != null) {
			throw new SigitextException(Messages.ERROR_LIBRETTO_IMPIANTO_PRESENTE);
		}

		LibrettoDocument document = getValidationManager().validazioneXmlImportLibretto(xml);

		String idPersonaGiuridica = utenteJWT.getIdPersonaGiuridica();
		if (idPersonaGiuridica == null) {
			throw new SigitextException(Messages.ERROR_RUOLO_UTENTE_LOGGATO);
		}

		SigitTPersonaGiuridicaDto personaGiuridica = getDbServiceImp().cercaPersonaGiuridicaById(ConvertUtil.convertToBigDecimal(idPersonaGiuridica));

		String cfUtente = utenteJWT.getCodiceFiscalePersonaFisica() != null ? utenteJWT.getCodiceFiscalePersonaFisica() : personaGiuridica.getCodiceFiscale();

		getDbServiceImp().insertImportLibretto(ConvertUtil.convertToBigDecimal(codiceImpianto), xml, cfUtente);

		getDbServiceImp().generaLibrettoImportNew(document, ConvertUtil.convertToString(codiceImpianto), ConvertUtil.convertToInteger(idPersonaGiuridica), cfUtente);
	}

	public Integer uploadXMLControllo(Integer codiceImpianto, String tipoControllo, byte[] xml, UtenteJWT utenteJWT) throws SigitextException {

		if (codiceImpianto == null) {
			throw new SigitextException(Messages.ERROR_CODICE_IMPIANTO_NON_VALIDO);
		}

		SigitTImpiantoDto impianto = getDbServiceImp().getImpiantoByCod(ConvertUtil.convertToBigDecimal(codiceImpianto));

		if (impianto == null || GenericUtil.isNullOrEmpty(impianto.getFlgTipoImpianto())) {
			throw new SigitextException(GenericUtil.replacePlaceholder(Messages.S157, codiceImpianto));
		}

		List<SigitTLibrettoDto> librettoList = getDbServiceImp().cercaLibrettoByStato(codiceImpianto, Constants.ID_STATO_LIBRETTO_CONSOLIDATO);

		if (librettoList == null || librettoList.isEmpty() || librettoList.get(0) == null) {
			// Non esiste un libretto consolidato
			throw new SigitextException(GenericUtil.replacePlaceholder(Messages.S099, codiceImpianto));
		}
		
		String idPersonaGiuridica = utenteJWT.getIdPersonaGiuridica();

		SigitTPersonaGiuridicaDto personaGiuridica = getDbServiceImp().cercaPersonaGiuridicaById(ConvertUtil.convertToBigDecimal(idPersonaGiuridica));

		String cfUtente = utenteJWT.getCodiceFiscalePersonaFisica() != null ? utenteJWT.getCodiceFiscalePersonaFisica() : personaGiuridica.getCodiceFiscale();

		SigitTPreImportDto dtoPreImport = inserisciPreImport(cfUtente);

		ImportFilter importData;

		try {
			importData = getValidationManager().validazionePreImportXmlControllo(codiceImpianto, tipoControllo, personaGiuridica, xml);
		} catch (SigitextException e) {
			dtoPreImport.setMsg(e.getMessage());
			getDbServiceImp().aggiornaPreImport(dtoPreImport);
			throw e;
		}

		importData.setIdPreImport(dtoPreImport.getIdPreImport());

		SigitTImportDto dtoImport = getDbServiceImp().insertImport(importData);

		DettaglioAllegato dettaglioAllegato = importData.getDettaglioAllegato();

		dettaglioAllegato.setCodFiscaleUtenteLoggato(cfUtente);

		try {
			getValidationManager().validazioneImportXmlControllo(importData, tipoControllo);

			getConnectorManager().salvaAllegatoImportTrans(dettaglioAllegato, xml, tipoControllo, librettoList.get(0), cfUtente);

		} catch (SigitextException e) {
			getDbServiceImp().aggiornaImport(dtoImport, e.getMessage(), dettaglioAllegato.getIdAllegato());
			throw e;
		}

		getDbServiceImp().aggiornaImport(dtoImport, null, dettaglioAllegato.getIdAllegato());

		return dettaglioAllegato.getIdAllegato();
	}

	public SigitTPreImportDto inserisciPreImport(String cfUtente) throws SigitextException {
		logger.debug("inserisciPreImport START");
		SigitTPreImportDto dto = new SigitTPreImportDto();
		try {
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());
			dto.setIdPersonaFisica(ConvertUtil.convertToBigDecimal(-1));
			dto.setUtenteUltMod(cfUtente);
			getDbServiceImp().inserisciPreImport(dto);
			return dto;
		} catch (SigitextException e) {
			logger.error("Errore", e);
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			logger.debug("inserisciPreImport END");
		}
	}

	@Transactional
	public void consolidaLibrettoTrans(String cfUtente, SigitTLibrettoDto librettoDto, String codiceRea, int motivoConsolidamento) throws SigitextException {
		boolean isRespAssente = false;
		try {
			BigDecimal codiceImpianto = librettoDto.getCodiceImpianto();

			SigitTImpiantoDto impianto = getDbServiceImp().getImpiantoByCod(codiceImpianto);

			librettoDto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
			librettoDto.setCfRedattore(cfUtente);
			librettoDto.setUtenteUltMod(cfUtente);
			librettoDto.setDataUltMod(DateUtil.getSqlDataCorrente());

			getDbServiceImp().inserisciLibretto(librettoDto);

			BigDecimal idLibretto = librettoDto.getIdLibretto();

			// Controllo il responsabile
			SigitVTotImpiantoDto respAttivo = getDbServiceImp().cercaResponsabileAttivoByCodImpianto(ConvertUtil.convertToInteger(codiceImpianto));
			if (respAttivo == null) {
				isRespAssente = true;
				throw new SigitextException(Messages.ERROR_RESPONSABILE_ASSENTE);

			}

			Libretto libretto = getLibretto(ConvertUtil.convertToInteger(codiceImpianto), true);
			byte[] thePdf = libretto.getLibrettoPdf().getDoc();

			if (logger.isDebugEnabled()) {
				logger.debug("##################");
				logger.debug("##################");
				logger.debug("Cod impianto: " + codiceImpianto);
				logger.debug("##################");
				logger.debug("##################");
			}

			String nome = getNomeFileLibretto(ConvertUtil.convertToInteger(codiceImpianto), idLibretto);

			logger.debug("nome file libretto: " + nome);
			Metadati metadati = MapDto.mapMetadati(impianto, librettoDto, codiceRea);
			String uidIndex = indexUploadFileNew(nome, thePdf, metadati, Constants.INDEX_FOLDER_LIBRETTI, true);
			logger.debug("UID index: " + uidIndex);
			//storicizzare altri libretti consolidati
			librettoDto.setUtenteUltMod(cfUtente);

			getDbServiceImp().storicizzaLibretti(librettoDto);
			logger.debug("libretti storicizzati");
			//consolidare libretto in bozza
			librettoDto.setFkMotivoConsolid(new BigDecimal(motivoConsolidamento));
			librettoDto.setFileIndex(nome);
			librettoDto.setUidIndex(uidIndex);
			getDbServiceImp().consolidaLibretto(librettoDto);
			logger.debug("Aggiornamento xml su DB");

			if (logger.isDebugEnabled()) {
				logger.debug("librettoDto.getIdLibretto(): " + librettoDto.getIdLibretto());
				logger.debug("libretto: " + libretto);
				logger.debug("libretto.getLibrettoXml(): " + libretto.getLibrettoXml());
			}

			getDbServiceImp().updateTxtLibretto(librettoDto.getIdLibretto(), XmlBeanUtils.readByteArray(libretto.getLibrettoXml()));
			logger.debug("libretto consolidato");
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			logger.error("Errore in consolidamento:", e);

			if (isRespAssente) {
				throw new SigitextException(Messages.ERROR_IMPOSSIBILE_CONSOLIDARE, e);
			} else {
				throw new SigitextException(Messages.ERROR_IMPOSSIBILE_CONSOLIDARE + ": contattare l'amministrattore del sistema", e);
			}
		}
	}

	public String indexUploadFileNew(String fileName, byte[] file, Metadati metadati, String cartella, boolean isSovrascrivibile) throws SigitextException {
		logger.debug("[SigitextManager::indexUploadFileNew] BEGIN");
		String uidFile = null;
		Node n = null;
		Content c = null;
		OperationContext oc = null;
		try {
			oc = indexGetOperationContext(Constants.INDEX_USERNAME_READ);
			logger.debug("------- OPERATION CONTEXT --- " + oc);
			n = indexSearchFolder(getQueryLuceneSearchCartella(metadati, cartella), oc);
			// Ho cercato la cartella passata come parametro
			if (n == null) {
				// Recupero il nodo del cod impianto
				n = new Node(indexGetFolder(metadati, oc));
				logger.debug("STAMPO IL NODO CODICE_IMPIANTO: " + n.getUid());
				c = indexGetContentFolder(null);
				// creo la cartella passata come parametro
				n = indexCreateFolder(cartella, c, n, oc);

			}
			// Cerco il file
			Node nodeFile = indexSearchFolder(getQueryLuceneSearchFile(fileName, metadati, cartella), oc);
			c = indexGetContent(metadati, fileName, file);
			if (nodeFile != null && isSovrascrivibile) {
				// Il file esiste gia', faccio l'update
				getServiceIndex().getEcmengineDelegate().updateContentData(nodeFile, c, oc);
				logger.debug("------- UPDATE NODO --- " + nodeFile);
			} else {
				// Il file non esiste (oppure non e' previsto l'update), faccio l'insert
				nodeFile = getServiceIndex().getEcmengineDelegate().createContent(n, c, oc);
				logger.debug("------- NUOVO NODO --- " + nodeFile);
				if (nodeFile != null) {
					uidFile = nodeFile.getUid();
				}
			}
		} catch (Exception e) {
			logger.error("Errore index: ", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO, e);
		}
		logger.debug("[SigitextManager::indexUploadFileNew] END");
		return uidFile;
	}

	private SearchParams getQueryLuceneSearchFile(String nomeFile, Metadati metadati, String cartella) {
		SearchParams searchParams = new SearchParams();
		searchParams.setLimit(1);

		StringBuilder luceneQuery = new StringBuilder();

		luceneQuery.append("PATH:\"");
		luceneQuery.append(Constants.INDEX_ROOT_SIGIT);
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodIstatProvincia());
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodIstatComune());
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodiceImpianto());
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(cartella);
		luceneQuery.append("/*");
		luceneQuery.append("\"");
		luceneQuery.append(" AND ");
		luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
		luceneQuery.append("name:\"");
		luceneQuery.append(nomeFile + "\"");

		logger.debug("getQueryLuceneSearchFile: " + luceneQuery.toString());

		searchParams.setLuceneQuery(luceneQuery.toString());

		return searchParams;
	}

	protected Node indexCreateFolder(String folderName, Content content, Node nodeParent, OperationContext op) throws SigitextException {
		logger.debug("[SigitextManager::indexCreateFolder] BEGIN");
		Node folder = null;
		try {
			content.setPrefixedName(Constants.INDEX_DEFAULT_PREFIX + folderName);

			Property p = new Property();
			p.setPrefixedName(Constants.INDEX_PREFIX_NAME_SHORT);
			p.setDataType("text");
			p.setValues(new String[] { folderName });
			content.setProperties(new Property[] { p });

			folder = getServiceIndex().getEcmengineDelegate().createContent(nodeParent, content, op);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO, e);
		}
		logger.debug("[SigitextManager::indexCreateFolder] END");
		return folder;
	}

	public Content indexGetContentFolder(String folderName) {
		logger.debug("[SigitextManager::indexGetContentFolder] BEGIN");
		Content myFolder = new Content();
		myFolder.setPrefixedName(Constants.INDEX_DEFAULT_PREFIX + folderName);
		myFolder.setParentAssocTypePrefixedName(Constants.INDEX_PREFIX_CONTAINS);
		myFolder.setModelPrefixedName(Constants.INDEX_PREFIX_MODEL);
		myFolder.setTypePrefixedName(Constants.INDEX_PREFIX_FOLDER);
		Property p = new Property();
		p.setPrefixedName(Constants.INDEX_PREFIX_NAME_SHORT);
		p.setDataType("text");
		p.setValues(new String[] { folderName });
		myFolder.setProperties(new Property[] { p });
		logger.debug("[SigitextManager::indexGetContentFolder] END");
		return myFolder;
	}

	private String indexGetFolder(Metadati metadati, OperationContext op) throws SigitextException {
		logger.debug("[SigitextManager::indexGetFolder] BEGIN");
		try {

			Content content = indexGetContentFolder(null);

			Node nodeCodImp = indexSearchFolder(getQueryLuceneSearchCodImp(metadati), op);

			logger.debug("Ho cercato il codice impianto: " + nodeCodImp);

			if (nodeCodImp == null) {
				logger.debug("Non esiste il nodo codice impianto");

				Node nodeComune = indexSearchFolder(getQueryLuceneSearchComune(metadati), op);

				logger.debug("Ho cercato il comune: " + nodeComune);

				if (nodeComune == null) {
					logger.debug("Non esiste il nodo comune");

					Node nodeProvincia = indexSearchFolder(getQueryLuceneSearchProvincia(metadati), op);

					logger.debug("Ho cercato la provincia: " + nodeProvincia);

					if (nodeProvincia == null) {
						logger.debug("Non esiste il nodo provincia");

						Node nodeApplicativo = indexSearchFolder(getQueryLuceneSearchApplicativo(), op);

						logger.debug("Ho cercato l'applicativo: " + nodeApplicativo);

						if (nodeApplicativo == null) {
							logger.debug("Se non esiste neanche l'applicativo rilancio l'eccezione!!!");
							throw new SigitextException("Su INDEX non e' configurato l'applicativo");
						}

						logger.debug("creo il nodo provincia");

						nodeProvincia = indexCreateFolder(metadati.getCodIstatProvincia(), content, nodeApplicativo, op);

						logger.debug("ho creato il nodo provincia: " + nodeProvincia.getUid());
					}

					logger.debug("creo il nodo comune");

					nodeComune = indexCreateFolder(metadati.getCodIstatComune(), content, nodeProvincia, op);

					logger.debug("ho creato il nodo comune: " + nodeComune.getUid());

				}

				logger.debug("creo il nodo codice impianto");

				nodeCodImp = indexCreateFolder(metadati.getCodiceImpianto(), content, nodeComune, op);

				logger.debug("ho creato il nodo codice impianto: " + nodeCodImp.getUid());

			}

			return nodeCodImp.getUid();
		} catch (SigitextException e) {
			throw e;
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO, e);
		} finally {
			logger.debug("[SigitextManager::indexGetFolder] END");
		}
	}

	private String getNomeFileLibretto(Integer codiceImpianto, BigDecimal idLibretto) {
		StringBuilder nome = new StringBuilder();
		nome.append(Constants.FILE_PREFIX_LIBRETTO);
		nome.append("_");
		nome.append(codiceImpianto);
		nome.append("_");
		nome.append(ConvertUtil.convertToString(idLibretto));
		nome.append(".pdf");
		return nome.toString();
	}

	private Content indexGetContent(Metadati metadati, String fileName, byte[] file) throws SigitextException {
		logger.debug("[SigitextManager::indexGetContent] BEGIN");
		Content c = indexGetContent(fileName);
		c.setModelPrefixedName(Constants.INDEX_SIGIT_PREFIX_MODEL);
		c.setProperties(indexSetMetadati(metadati));
		c.setContent(file);
		logger.debug("[SigitextManager::indexGetContent] END");
		return c;
	}

	private Property[] indexSetMetadati(Metadati metadati) {
		logger.debug("[SigitextManager::indexSetMetadati] BEGIN");
		Property[] result = new Property[6];
		result[0] = new Property();
		result[0].setDataType(Constants.INDEX_TYPE_TEXT);
		result[0].setPrefixedName(Metadati.META_BOLLINO_VERDE);
		result[0].setValues(new String[] { metadati.getBollinoVerde() });

		result[1] = new Property();
		result[1].setDataType(Constants.INDEX_TYPE_TEXT);
		result[1].setPrefixedName(Metadati.META_COD_ISTAT_COMUNE);
		result[1].setValues(new String[] { metadati.getCodIstatComune() });

		result[2] = new Property();
		result[2].setDataType(Constants.INDEX_TYPE_TEXT);
		result[2].setPrefixedName(Metadati.META_COD_ISTAT_PROVINCIA);
		result[2].setValues(new String[] { metadati.getCodIstatProvincia() });

		result[3] = new Property();
		result[3].setDataType(Constants.INDEX_TYPE_TEXT);
		result[3].setPrefixedName(Metadati.META_CODICE_REA);
		result[3].setValues(new String[] { metadati.getCodiceRea() });

		result[4] = new Property();
		result[4].setDataType(Constants.INDEX_TYPE_TEXT);
		result[4].setPrefixedName(Metadati.META_DATA_RAPPORTO);
		result[4].setValues(new String[] { metadati.getDataRapporto() });

		result[5] = new Property();
		result[5].setDataType(Constants.INDEX_TYPE_TEXT);
		result[5].setPrefixedName(Metadati.META_ID_RAPPORTO);
		result[5].setValues(new String[] { metadati.getIdRapporto() });
		logger.debug("[SigitextManager::indexSetMetadati] END");
		return result;
	}

	public Node indexSearchFolder(SearchParams params, OperationContext op) throws SigitextException {
		logger.debug("[SigitextManager::indexSearchFolder] BEGIN");
		Node node = null;
		try {

			logger.debug("Stampo la query lucene: " + params.getLuceneQuery());
			//GenericUtil.stampa(params, true, 3);

			NodeResponse nodeResponse = getServiceIndex().getEcmengineDelegate().luceneSearchNoMetadata(params, op);

			//GenericUtil.stampa(nodeResponse, true, 3);

			if (nodeResponse != null && nodeResponse.getNodeArray() != null && nodeResponse.getNodeArray().length > 0) {
				node = nodeResponse.getNodeArray()[0];
			}

		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO, e);
		}
		logger.debug("[SigitextManager::indexSearchFolder] END");
		return node;
	}

	private SearchParams getQueryLuceneSearchCartella(Metadati metadati, String cartella) {
		SearchParams searchParams = new SearchParams();
		searchParams.setLimit(1);

		StringBuilder luceneQuery = new StringBuilder();

		luceneQuery.append("PATH:\"");
		luceneQuery.append(Constants.INDEX_ROOT_SIGIT);
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodIstatProvincia());
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodIstatComune());
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodiceImpianto());
		luceneQuery.append("/*");
		luceneQuery.append("\"");
		luceneQuery.append(" AND ");
		luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
		luceneQuery.append("name:\"");
		luceneQuery.append(cartella + "\"");

		logger.debug("getQueryLuceneSearchCartella: " + luceneQuery.toString());

		searchParams.setLuceneQuery(luceneQuery.toString());

		return searchParams;
	}

	private SearchParams getQueryLuceneSearchCodImp(Metadati metadati) {
		SearchParams searchParams = new SearchParams();
		searchParams.setLimit(1);

		StringBuilder luceneQuery = new StringBuilder();

		luceneQuery.append("PATH:\"");
		luceneQuery.append(Constants.INDEX_ROOT_SIGIT);
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodIstatProvincia());
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodIstatComune());
		luceneQuery.append("/*");
		luceneQuery.append("\"");
		luceneQuery.append(" AND ");
		luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
		luceneQuery.append("name:\"");
		luceneQuery.append(metadati.getCodiceImpianto() + "\"");

		logger.debug("getQueryLuceneSearchCodImp: " + luceneQuery.toString());

		searchParams.setLuceneQuery(luceneQuery.toString());

		return searchParams;
	}

	private SearchParams getQueryLuceneSearchComune(Metadati metadati) {
		SearchParams searchParams = new SearchParams();
		searchParams.setLimit(1);

		StringBuilder luceneQuery = new StringBuilder();

		luceneQuery.append("PATH:\"");
		luceneQuery.append(Constants.INDEX_ROOT_SIGIT);
		luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
		luceneQuery.append(metadati.getCodIstatProvincia());
		luceneQuery.append("/*");
		luceneQuery.append("\"");
		luceneQuery.append(" AND ");
		luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
		luceneQuery.append("name:\"");
		luceneQuery.append(metadati.getCodIstatComune() + "\"");

		logger.debug("getQueryLuceneSearchComune: " + luceneQuery.toString());

		searchParams.setLuceneQuery(luceneQuery.toString());

		return searchParams;
	}

	private SearchParams getQueryLuceneSearchProvincia(Metadati metadati) {
		SearchParams searchParams = new SearchParams();
		searchParams.setLimit(1);

		StringBuilder luceneQuery = new StringBuilder();

		luceneQuery.append("PATH:\"");
		luceneQuery.append(Constants.INDEX_ROOT_SIGIT);
		luceneQuery.append("/*");
		luceneQuery.append("\"");
		luceneQuery.append(" AND ");
		luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
		luceneQuery.append("name:\"");
		luceneQuery.append(metadati.getCodIstatProvincia() + "\"");

		logger.debug("getQueryLuceneSearchProvincia: " + luceneQuery.toString());

		searchParams.setLuceneQuery(luceneQuery.toString());

		return searchParams;
	}

	private SearchParams getQueryLuceneSearchApplicativo() {
		SearchParams searchParams = new SearchParams();
		searchParams.setLimit(1);

		StringBuilder luceneQuery = new StringBuilder();

		luceneQuery.append("PATH:\"");
		luceneQuery.append(Constants.INDEX_ROOT);
		luceneQuery.append("/*");
		luceneQuery.append("\"");
		luceneQuery.append(" AND ");
		luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
		luceneQuery.append("name:\"");
		luceneQuery.append(Constants.INDEX_FRUITORE + "\"");

		logger.debug("getQueryLuceneSearchApplicativo: " + luceneQuery.toString());

		searchParams.setLuceneQuery(luceneQuery.toString());

		return searchParams;
	}

	public Impianto[] getImpiantoByIndirizzo(String indirizzo, Integer civico, String istat) throws SigitExcessiveResultsException {
		String header = "!!!!getImpiantoByIndirizzo==>.";
		logger.debug(header + "inizio!!");

		Impianto[] result = null;

		try {

			int maxResult = cercaConfigValueNumerico(Constants.MAX_RISULTATI_WS);

			logger.debug("STAMPO IL MAX DI RISULTATI: " + maxResult);

			ArrayList<Impianto> listaImpianti = new ArrayList<>();

			IndirizzoFiltro filtro = new IndirizzoFiltro();
			if (indirizzo != null)
				indirizzo = indirizzo.toLowerCase(Locale.ROOT);
			filtro.setIndirizzo(indirizzo);
			filtro.setCivico(civico);
			filtro.setIstat(istat);

			List<SigitTImpiantoDto> listaImpiantiDto = getDbServiceImp().getSigitTImpiantoDao().findFindByIndirizzo(filtro);

			logger.debug("LISTA IMPIANTO DTO: " + listaImpiantiDto);

			if (listaImpiantiDto != null && !listaImpiantiDto.isEmpty()) {
				if (listaImpiantiDto.size() < maxResult) {
					for (SigitTImpiantoDto impiantoDto : listaImpiantiDto) {

						List<Impianto> listaImpiantiParz = getListImpiantoByCodImpianto(ConvertUtil.convertToInteger(impiantoDto.getCodiceImpianto()));
						logger.debug("listaImpiantiParz: " + listaImpiantiParz);

						if (listaImpiantiParz != null && !listaImpiantiParz.isEmpty()) {
							listaImpianti.addAll(listaImpiantiParz);
						}
					}

					result = listaImpianti.toArray(new Impianto[listaImpianti.size()]);
				} else {
					throw new SigitExcessiveResultsException("Attenzione! Sono stati estratti troppi risultati. Si prega di affinare la ricerca.");
				}
			}

			logger.debug(header + "fine");
		} catch (SigitExcessiveResultsException ex) {
			throw ex;
		} catch (Exception ex) {
			logger.error(header + "errore= ", ex);
		}
		return result;

	}

	public SigitTPersonaFisicaDto findPersonaFisicaByCF(String codiceFiscale) throws SigitextException {
		try {
			List<SigitTPersonaFisicaDto> personeFisiche = getDbServiceImp().getSigitTPersonaFisicaDao().findByCodiceFiscale(codiceFiscale);
			if (personeFisiche.size() == 1)
				return personeFisiche.get(0);
			else if (!personeFisiche.isEmpty())
				throw new SigitextException("Recuperate più persone fisiche con lo stesso codice fiscale");
			return null;
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new SigitextException("Persona fisica non trovata");
		}
	}

	public SigitTPersonaFisicaDto inserisciOAggiornaPersonaFisica(SigitTPersonaFisicaDto newPF) throws SigitextException {
		SigitTPersonaFisicaPk insertPfPk = null;
		SigitTPersonaFisicaDto insertPf = null;
		try {
			if (newPF.getIdPersonaFisica() != null) {
				getDbServiceImp().getSigitTPersonaFisicaDao().update(newPF);
				insertPf = getDbServiceImp().getSigitTPersonaFisicaDao().findByPrimaryKey(newPF.createPk());
				return insertPf;
			} else {
				insertPfPk = getDbServiceImp().getSigitTPersonaFisicaDao().insert(newPF);
				insertPf = getDbServiceImp().getSigitTPersonaFisicaDao().findByPrimaryKey(insertPfPk);
				return insertPf;
			}
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new SigitextException("Errore aggiornamento persona fisica");
		}
	}

	public List<SigitRPfRuoloPaFindByPfDto> findRuoliPAByPf(SigitTPersonaFisicaDto dto) throws SigitextException {
		String header = "!!!!findRuoliPaByPf==>.";
		logger.debug(header + "inizio!!");
		try {
			return getDbServiceImp().getSigitRPfRuoloPaDao().findFindByPf(dto.getIdPersonaFisica().intValue());
		} catch (SigitRPfRuoloPaDaoException e) {
			logger.error(header + "errore= ", e);
			throw new SigitextException("Errore recupero ruoli PA");
		} finally {
			logger.debug(header + "fine!!");
		}
	}

	public List<SigitRPfPgDelegaFindByPfDto> findRuoliPgByPf(SigitTPersonaFisicaDto dto) throws SigitextException {
		String header = "!!!!findRuoliPgByPf==>.";
		try {
			return getDbServiceImp().getSigitRPfPgDelegaDao().findFindByPf(dto.getIdPersonaFisica().intValue());
		} catch (SigitRPfPgDelegaDaoException e) {
			logger.error(header + "errore= ", e);
			throw new SigitextException("Errore recupero ruoli PG");
		} finally {
			logger.debug(header + "fine!!");
		}
	}

	public List<SigitRPgPgNominaDto> cercaSigitRPgPgIncaricoAttByIdPersonaGiuridicaCat(BigDecimal pgIdPersonaGiuridica) throws SigitextException {
		List<SigitRPgPgNominaDto> dtoList = null;
		try {
			dtoList = getDbServiceImp().getSigitRPgPgNominaDao().findFindByPgCat(pgIdPersonaGiuridica.intValue());

		} catch (SigitRPgPgNominaDaoException e) {
			throw new SigitextException("Errore recupero deleghe");
		}
		return dtoList;
	}

	public PersonaGiuridica cercaPersonaGiuridicaById(Integer id) throws SigitextException {
		PersonaGiuridica persona = null;
		try {
			persona = getDbServiceImp().getSigitTPersonaGiuridicaDao().findByPrimaryKeyDescStato(new SigitTPersonaGiuridicaPk(BigDecimal.valueOf(id)));
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new SigitextException("Errore recupero persona giuridica");
		}
		return persona;
	}

	public void setAccesso(SigitLAccessoDto accessoDto) throws SigitextException {
		try {
			getDbServiceImp().getSigitLAccessoDao().insert(accessoDto);
		} catch (Exception e) {
			throw new SigitextException("Errore inserimento accesso");
		}
	}

	public List<SigitDStatoImpiantoDto> getStatiImpianto() throws SigitextException {
		try {
			return getDbServiceImp().getSigitDStatoImpiantoDao().findAll();
		} catch (Exception e) {
			throw new SigitextException("Errore recupero stati");
		}
	}

	public Impianto[] ricercaImpiantoByFiltro(ImpiantoFiltro impiantoFiltro) throws SigitextException {

		String header = "!!!!ricercaImpiantoByFiltro==>.";
		logger.debug(header + "inizio!!");

		List<Impianto> impiantiListToMap = new LinkedList<>();

		try {
			List<SigitExtImpiantoDto> impiantiList = getDbServiceImp().ricercaImpiantoByFiltro(impiantoFiltro);

			if (impiantiList == null) {
				logger.debug(header + "lista =  null!!");

			} else {
				logger.debug(header + "lista not  null!!");
				for (SigitExtImpiantoDto dto : impiantiList) {
					Impianto impianto = MapDto.mapSigitExtImpiantoDtoToImpianto(dto);
					impiantiListToMap.add(impianto);
				}
			}

			logger.debug(header + "fine");

		} catch (Exception e) {
			logger.error(header + "errore= ", e);
			throw e;
		}
		return impiantiListToMap.toArray(new Impianto[0]);
	}

	public ListaImpiantiGeo ricercaImpiantoGeoByFiltro(ImpiantoFiltro impiantoFiltro) throws SigitextException {

		String header = "!!!!ricercaImpiantoByFiltro==>.";
		logger.debug(header + "inizio!!");

		ListaImpiantiGeo listaImpiantiGeo = new ListaImpiantiGeo();
		List<Impianto> impiantiListToMap = new LinkedList<>();
		List<Feature> featuresListToMap = new LinkedList<>();
		FeatureCollection featureCollection = new FeatureCollection();
//		Crs crs = new Crs();
//		HashMap<String, String> properties = new HashMap<String, String>();
//		properties.put("name", Constants.EPSG_4326);
//		crs.setProperties(properties);
//		featureCollection.setCrs(crs);

		try {
			List<SigitExtImpiantoDto> impiantiList = getDbServiceImp().ricercaImpiantoByFiltro(impiantoFiltro);

			String prefixLinkDettaglio = ""; 
			WrkConfigDto wrkConfigDto = cercaConfigValue(Constants.CIT_PREFIX_LINK_DETTAGLIO_IMPIANTO);
			if(wrkConfigDto!=null) {
				prefixLinkDettaglio = wrkConfigDto.getValoreConfigChar();
			}
			
			if (impiantiList == null) {
				logger.debug(header + "lista =  null!!");

			} else {
				logger.debug(header + "lista not  null!!");
				for (SigitExtImpiantoDto dto : impiantiList) {
					SigitVRicercaImpiantiDto vi = getDbServiceImp().cercaImpiantoByCodImpianto(dto.getCodiceImpianto());
					dto.setIdPfResponsabile(vi.getIdPfResponsabile());
					dto.setIdPgResponsabile(dto.getIdPgResponsabile());
					Impianto impianto = MapDto.mapSigitExtImpiantoDtoToImpianto(dto);
					impiantiListToMap.add(impianto);
					Feature feature = MapDto.mapSigitExtImpiantoDtoToFeature(dto);
					feature.getProperties().put("linkDettaglio", prefixLinkDettaglio + dto.getCodiceImpianto().toString());
					featuresListToMap.add(feature);
				}
			}

			logger.debug(header + "fine");

		} catch (WrkConfigDaoException e) {
			logger.error(header + "errore= ", e);
			throw new SigitextException(e.getMessage(), e);
		} catch (SigitextException e) {
			logger.error(header + "errore= ", e);
			throw e;
		}
		
		listaImpiantiGeo.setImpianti(impiantiListToMap.toArray(new Impianto[0]));
		featureCollection.setFeatures(featuresListToMap.toArray(new Feature[0]));
		listaImpiantiGeo.setFeatureCollection(featureCollection);
				
		return listaImpiantiGeo;
	}

	public ListaImpiantiGeo ricercaImpiantoGeoByFiltroDuplicatiResponsabile(ImpiantoFiltro impiantoFiltro) throws SigitextException {

		String header = "!!!!ricercaImpiantoByFiltro==>.";
		logger.debug(header + "inizio!!");

		ListaImpiantiGeo listaImpiantiGeo = new ListaImpiantiGeo();
		List<Impianto> impiantiListToMap = new LinkedList<>();
		List<Feature> featuresListToMap = new LinkedList<>();
		FeatureCollection featureCollection = new FeatureCollection();
//		Crs crs = new Crs();
//		HashMap<String, String> properties = new HashMap<String, String>();
//		properties.put("name", Constants.EPSG_4326);
//		crs.setProperties(properties);
//		featureCollection.setCrs(crs);

		try {
			List<SigitExtImpiantoDto> impiantiList = getDbServiceImp().ricercaImpiantoByCodImpiantoDuplicatiResponsabile(impiantoFiltro);

			String prefixLinkDettaglio = ""; 
			WrkConfigDto wrkConfigDto = cercaConfigValue(Constants.CIT_PREFIX_LINK_DETTAGLIO_IMPIANTO);
			if(wrkConfigDto!=null) {
				prefixLinkDettaglio = wrkConfigDto.getValoreConfigChar();
			}
			
			if (impiantiList == null) {
				logger.debug(header + "lista =  null!!");

			} else {
				logger.debug(header + "lista not  null!!");
				for (SigitExtImpiantoDto dto : impiantiList) {
					SigitVRicercaImpiantiDto vi = getDbServiceImp().cercaImpiantoByCodImpianto(dto.getCodiceImpianto());
					dto.setIdPfResponsabile(vi.getIdPfResponsabile());
					dto.setIdPgResponsabile(dto.getIdPgResponsabile());
					Impianto impianto = MapDto.mapSigitExtImpiantoDtoToImpianto(dto);
					impiantiListToMap.add(impianto);
					Feature feature = MapDto.mapSigitExtImpiantoDtoToFeature(dto);
					feature.getProperties().put("linkDettaglio", prefixLinkDettaglio + dto.getCodiceImpianto().toString());
					featuresListToMap.add(feature);
				}
			}

			logger.debug(header + "fine");

		} catch (WrkConfigDaoException e) {
			logger.error(header + "errore= ", e);
			throw new SigitextException(e.getMessage(), e);
		} catch (SigitextException e) {
			logger.error(header + "errore= ", e);
			throw e;
		}
		
		listaImpiantiGeo.setImpianti(impiantiListToMap.toArray(new Impianto[0]));
		featureCollection.setFeatures(featuresListToMap.toArray(new Feature[0]));
		listaImpiantiGeo.setFeatureCollection(featureCollection);
				
		return listaImpiantiGeo;
	}
	
	@Transactional
	public String salvaImpiantoTrans(DatiImpianto impianto, String descRuolo, UtenteLoggato utenteLoggato, Integer responsabilita) throws Exception {
		try {
			DatiImpianto datiImpianto = getDbServiceImp().inserisciNuovoImpianto(impianto, descRuolo, utenteLoggato, responsabilita);
			if (datiImpianto != null)
				return datiImpianto.getCodiceImpianto();
			else
				throw new Exception("Nessun impianto inserito");
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	}

	@Transactional
	public Responsabile salvaResponsabileTrans(Responsabile responsabile, String codiceImpianto, String codiceFiscalePF) throws SigitextException {
		logger.debug("[DbMgr::salvaResponsabileTrans] BEGIN");
		try {
			return getDbServiceImp().salvaResponsabile(responsabile, codiceImpianto, codiceFiscalePF);
		} catch (SigitextException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		} finally {
			logger.debug("[salvaResponsabileTrans] END");
		}
	}

	public ArrayList<RisultatoRicResponsabile> cercaResponsabiliByIdImpianto(Integer idImpianto) throws SigitextException {

		ArrayList<RisultatoRicResponsabile> risRicResp = new ArrayList<>();

		logger.debug("[cercaResponsabiliByIdImpianto] BEGIN");
		try {

			List<SigitExtRespImpDto> dtoList = getDbServiceImp().cercaResponsabileAttivoByCodImpiantoExt(idImpianto);

			for (SigitExtRespImpDto sigitExtRespImpDto : dtoList) {
				risRicResp.add(MapDto.mapToRisultatoRicResponsabile(sigitExtRespImpDto));
			}

		} catch (Exception e) {
			throw new SigitextException("");
		} finally {
			logger.debug("[cercaResponsabiliByIdImpianto] END");
		}
		return risRicResp;
	}

	public List<DatiGT> findDatiGTByFiltro(CompFilter compFilter) throws Exception {
		List<DatiGT> datiGTList = null;
		logger.debug("[findDatiGTByFiltro] BEGIN");
		try {
			List<SigitTCompGtCompletoDto> dtoList = getDbServiceImp().findCompGtByFilter(compFilter);
			if (dtoList != null) {
				datiGTList = new ArrayList<>();
				for (SigitTCompGtCompletoDto compGtCompletoDto : dtoList) {
					SigitTAllegatoDto sigitTAllegatoDto = getDbServiceImp().getSigitTAllegatoDao().findUltimoControlloGT(compGtCompletoDto.getProgressivo(), compGtCompletoDto.getCodiceImpianto());
					DatiGT dato = MapDto.mapToDatiGT(compGtCompletoDto);
					if (sigitTAllegatoDto != null)
						dato.setDataMassimaControllo(sigitTAllegatoDto.getDataControllo());
					dato.setDataMinimaControllo(compGtCompletoDto.getDataInstall());
					datiGTList.add(dato);
				}
			}
		} catch (Exception e) {
			logger.debug("[findDatiGTByFiltro] Errore", e);
			throw e;
		} finally {
			logger.debug("[findDatiGTByFiltro] END");
		}
		return datiGTList;
	}

	public List<DatiGF> findDatiGFByFiltro(CompFilter compFilter) throws Exception {
		List<DatiGF> datiGF = null;
		logger.debug("[findDatiGFByFiltro] BEGIN");
		try {
			List<SigitTCompGfCompletoDto> dtoList = getDbServiceImp().findCompGfByFilter(compFilter);
			if (dtoList != null) {
				datiGF = new ArrayList<>();
				for (SigitTCompGfCompletoDto compGfCompletoDto : dtoList) {
					SigitTAllegatoDto sigitTAllegatoDto = getDbServiceImp().getSigitTAllegatoDao().findUltimoControlloGF(compGfCompletoDto.getProgressivo(), compGfCompletoDto.getCodiceImpianto());
					DatiGF dato = MapDto.mapToDatiGF(compGfCompletoDto);
					if (sigitTAllegatoDto != null)
						dato.setDataMassimaControllo(sigitTAllegatoDto.getDataControllo());
					dato.setDataMinimaControllo(compGfCompletoDto.getDataInstall());
					datiGF.add(dato);
				}
			}
		} catch (Exception e) {
			logger.error("[findDatiGFByFiltro] Errore", e);
			throw e;
		} finally {
			logger.debug("[findDatiGFByFiltro] END");
		}
		return datiGF;
	}

	public List<DatiSC> findDatiSCByFiltro(CompFilter compFilter) throws Exception {
		List<DatiSC> datiSC = null;
		logger.debug("[findDatiGFByFiltro] BEGIN");
		try {
			List<SigitTCompScCompletoDto> dtoList = getDbServiceImp().findCompScByFilter(compFilter);
			if (dtoList != null) {
				datiSC = new ArrayList<>();
				for (SigitTCompScCompletoDto compScCompletoDto : dtoList) {
					SigitTAllegatoDto sigitTAllegatoDto = getDbServiceImp().getSigitTAllegatoDao().findUltimoControlloSC(compScCompletoDto.getProgressivo(), compScCompletoDto.getCodiceImpianto());
					DatiSC dato = MapDto.mapToDatiSC(compScCompletoDto);
					if (sigitTAllegatoDto != null)
						dato.setDataMassimaControllo(sigitTAllegatoDto.getDataControllo());
					dato.setDataMinimaControllo(compScCompletoDto.getDataInstall());
					datiSC.add(dato);
				}
			}
		} catch (Exception e) {
			logger.error("[findDatiGFByFiltro] Errore", e);
			throw e;
		} finally {
			logger.debug("[findDatiGFByFiltro] END");
		}
		return datiSC;
	}

	public List<DatiCG> findDatiCGByFiltro(CompFilter compFilter) throws Exception {
		List<DatiCG> datiCG = null;
		logger.debug("[findDatiCGByFiltro] BEGIN");
		try {
			List<SigitTCompCgCompletoDto> dtoList = getDbServiceImp().findCompCgByFilter(compFilter);
			if (dtoList != null) {
				datiCG = new ArrayList<>();
				for (SigitTCompCgCompletoDto compCgCompletoDto : dtoList) {
					SigitTAllegatoDto sigitTAllegatoDto = getDbServiceImp().getSigitTAllegatoDao().findUltimoControlloCG(compCgCompletoDto.getProgressivo(), compCgCompletoDto.getCodiceImpianto());
					DatiCG dato = MapDto.mapToDatiCG(compCgCompletoDto);
					if (sigitTAllegatoDto != null)
						dato.setDataMassimaControllo(sigitTAllegatoDto.getDataControllo());
					dato.setDataMinimaControllo(compCgCompletoDto.getDataInstall());
					datiCG.add(dato);
				}
			}
		} catch (Exception e) {
			logger.error("[findDatiCGByFiltro] Errore", e);
			throw e;
		} finally {
			logger.debug("[findDatiCGByFiltro] END");
		}
		return datiCG;
	}

	public CodiceDescrizione[] getTipologaGT() {
		List<CodiceDescrizione> listone = new ArrayList<>();
		try {
			List<SigitDDettaglioGtDto> lista = getDbServiceImp().getSigitDDettaglioGtDao().findAll();
			if (lista != null) {
				for (SigitDDettaglioGtDto dto : lista) {
					CodiceDescrizione cod = new CodiceDescrizione();
					cod.setCodice(String.valueOf(dto.getIdDettaglioGt()));
					cod.setDescrizione(dto.getDesDettaglioGt());
					listone.add(cod);
				}
			}
		} catch (Exception ex) {
			logger.error("errore= ", ex);
		}
		return listone.toArray(new CodiceDescrizione[0]);
	}
	
	public CodiceDescrizione[] getTipoIntervento() {
		List<CodiceDescrizione> listone = new ArrayList<>();
		try {
			List<SigitDTipoInterventoDto> lista = getDbServiceImp().getSigitDTipoInterventoDao().findAll();
			logger.debug("SIZE OF TIPI INTERVENTO LIST: " + lista.size());
			for (SigitDTipoInterventoDto dto : lista) {
				CodiceDescrizione cod = new CodiceDescrizione();
				cod.setCodice(dto.getIdTipoIntervento().toString());
				cod.setDescrizione(dto.getDesTipoIntervento());
				listone.add(cod);
			}
		} catch (Exception ex) {
			logger.error("errore= ", ex);
		}
		return listone.toArray(new CodiceDescrizione[0]);
	}

	public CodiceDescrizione[] getTipologaGF() {
		List<CodiceDescrizione> listone = new ArrayList<>();
		try {
			List<SigitDDettaglioGfDto> lista = getDbServiceImp().getSigitDDettaglioGfDao().findAll();
			if (lista != null) {
				for (SigitDDettaglioGfDto dto : lista) {
					CodiceDescrizione cod = new CodiceDescrizione();
					cod.setCodice(String.valueOf(dto.getIdDettaglioGf()));
					cod.setDescrizione(dto.getDesDettaglioGf());
					listone.add(cod);
				}
			}
		} catch (Exception ex) {
			logger.error("errore= ", ex);
		}
		return listone.toArray(new CodiceDescrizione[0]);
	}

	public CodiceDescrizione[] getFonteCIT() {
		List<CodiceDescrizione> listone = new ArrayList<>();
		try {
			List<SigitDFonteEnSfruttataDto> lista = getDbServiceImp().getSigitDFonteEnSfruttataDao().findAll();
			if (lista != null) {
				for (SigitDFonteEnSfruttataDto dto : lista) {
					CodiceDescrizione cod = new CodiceDescrizione();
					cod.setCodice(String.valueOf(dto.getIdFonteEnSfruttata()));
					cod.setDescrizione(dto.getDescFonteEnSfruttata());
					listone.add(cod);
				}
			}
		} catch (Exception ex) {
			logger.error("errore= ", ex);
		}
		return listone.toArray(new CodiceDescrizione[0]);
	}

	public CodiceDescrizione[] getTipoCannaFumaria() {
		List<CodiceDescrizione> listone = new ArrayList<>();
		try {
			List<SigitDTipoCannaFumariaDto> lista = getDbServiceImp().getSigitDTipoCannaFumariaDao().findAll();
			if (lista != null) {
				for (SigitDTipoCannaFumariaDto dto : lista) {
					CodiceDescrizione cod = new CodiceDescrizione();
					cod.setCodice(String.valueOf(dto.getIdTipoCannaFumaria()));
					cod.setDescrizione(dto.getDescTipoCannaFumaria());
					listone.add(cod);
				}
			}
		} catch (Exception ex) {
			logger.error("errore= ", ex);
		}
		return listone.toArray(new CodiceDescrizione[0]);
	}

	@Transactional
	public void salvaComponenteGT(String codImpianto, String progressivo, List<DatiGT> compList, Integer idPersonaGiuridica, UtenteLoggato utenteMod) throws SigitextException {
		logger.debug("ServiceManager:salvaComponenteGT - START");
		BigDecimal codImpiantoBigD = ConvertUtil.convertToBigDecimal(codImpianto);
		BigDecimal progressivoBigD = ConvertUtil.convertToBigDecimal(progressivo);
		try {
			DatiGT componente = compList.get(0);
			if (componente.getProgressivo() == null) {
				getDbServiceImp().salvaComp4(codImpiantoBigD, progressivoBigD, Constants.TIPO_COMPONENTE_GT);
			}

			String cfUtenteMod = utenteMod != null ? utenteMod.getPfLoggato().getCodiceFiscalePF() : null;
			getDbServiceImp().insertComp4Manut(codImpiantoBigD, Constants.TIPO_COMPONENTE_GT, progressivoBigD, idPersonaGiuridica, cfUtenteMod, Constants.ID_RUOLO_MANUTENTORE_ALL_1);
			getDbServiceImp().updateListComponentiGT(compList, codImpianto, progressivo, cfUtenteMod);
			SigitTComp4Pk pkComp4 = new SigitTComp4Pk(codImpiantoBigD, Constants.TIPO_COMPONENTE_GT, progressivoBigD);
			if(utenteMod!=null && utenteMod.getRuoloLoggato()!=null) {
				getDbServiceImp().salvaAzioneComp4(pkComp4, componente.getDataInstall(), cfUtenteMod, utenteMod.getRuoloLoggato().getRuolo());
			}
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new SigitextException("Errore salvataggio dati GT");
		} finally {
			logger.debug("[ServiceManager::salvaComponenteGT] END");
		}
	}

	@Transactional
	public void salvaComponenteGF(String codImpianto, String progressivo, List<DatiGF> compList, Integer idPersonaGiuridica, UtenteLoggato utenteMod) throws SigitextException {
		logger.debug("ServiceManager:salvaComponenteGF - START");
		BigDecimal codImpiantoBigD = ConvertUtil.convertToBigDecimal(codImpianto);
		BigDecimal progressivoBigD = ConvertUtil.convertToBigDecimal(progressivo);
		try {
			DatiGF componente = compList.get(0);
			if (componente.getProgressivo() == null) {
				getDbServiceImp().salvaComp4(codImpiantoBigD, progressivoBigD, Constants.TIPO_COMPONENTE_GF);
			}

			String cfUtenteMod = utenteMod != null ? utenteMod.getPfLoggato().getCodiceFiscalePF() : null;
			getDbServiceImp().insertComp4Manut(codImpiantoBigD, Constants.TIPO_COMPONENTE_GF, progressivoBigD, idPersonaGiuridica, cfUtenteMod, Constants.ID_RUOLO_MANUTENTORE_ALL_2);
			getDbServiceImp().updateListComponentiGF(compList, codImpianto, progressivo, cfUtenteMod);
			SigitTComp4Pk pkComp4 = new SigitTComp4Pk(codImpiantoBigD, Constants.TIPO_COMPONENTE_GF, progressivoBigD);
			if(utenteMod!=null && utenteMod.getRuoloLoggato()!=null) {
				getDbServiceImp().salvaAzioneComp4(pkComp4, componente.getDataInstall(), cfUtenteMod, utenteMod.getRuoloLoggato().getRuolo());
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("Errore salvataggio componente GF: ", e);
			throw new SigitextException("Errore salvataggio dati GF");
		} finally {
			logger.debug("[ServiceManager::salvaComponenteGF] END");
		}
	}

	@Transactional
	public void salvaComponenteSC(String codImpianto, String progressivo, List<DatiSC> compList, Integer idPersonaGiuridica, UtenteLoggato utenteMod) throws SigitextException {
		logger.debug("ServiceManager:salvaComponenteSC - START");
		BigDecimal codImpiantoBigD = ConvertUtil.convertToBigDecimal(codImpianto);
		BigDecimal progressivoBigD = ConvertUtil.convertToBigDecimal(progressivo);
		try {
			DatiSC componente = compList.get(0);
			if (componente.getProgressivo() == null) {
				getDbServiceImp().salvaComp4(codImpiantoBigD, progressivoBigD, Constants.TIPO_COMPONENTE_SC);
			}

			String cfUtenteMod = utenteMod != null ? utenteMod.getPfLoggato().getCodiceFiscalePF() : null;
			getDbServiceImp().insertComp4Manut(codImpiantoBigD, Constants.TIPO_COMPONENTE_SC, progressivoBigD, idPersonaGiuridica, cfUtenteMod, Constants.ID_RUOLO_MANUTENTORE_ALL_3);
			getDbServiceImp().updateListComponentiSC(compList, codImpianto, progressivo, cfUtenteMod);
			SigitTComp4Pk pkComp4 = new SigitTComp4Pk(codImpiantoBigD, Constants.TIPO_COMPONENTE_SC, progressivoBigD);
			if(utenteMod!=null && utenteMod.getRuoloLoggato()!=null) {
				getDbServiceImp().salvaAzioneComp4(pkComp4, componente.getDataInstall(), cfUtenteMod, utenteMod.getRuoloLoggato().getRuolo());
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("Errore salvataggio componente SC: ", e);
			throw new SigitextException("Errore salvataggio dati SC");
		} finally {
			logger.debug("[ServiceManager::salvaComponenteSC] END");
		}
	}

	@Transactional
	public void salvaComponenteCG(String codImpianto, String progressivo, List<DatiCG> compList, Integer idPersonaGiuridica, UtenteLoggato utenteMod) throws SigitextException {
		logger.debug("ServiceManager:salvaComponenteCG - START");
		BigDecimal codImpiantoBigD = ConvertUtil.convertToBigDecimal(codImpianto);
		BigDecimal progressivoBigD = ConvertUtil.convertToBigDecimal(progressivo);
		try {
			DatiCG componente = compList.get(0);
			if (componente.getProgressivo() == null) {
				getDbServiceImp().salvaComp4(codImpiantoBigD, progressivoBigD, Constants.TIPO_COMPONENTE_CG);
			}

			String cfUtenteMod = utenteMod != null ? utenteMod.getPfLoggato().getCodiceFiscalePF() : null;
			getDbServiceImp().insertComp4Manut(codImpiantoBigD, Constants.TIPO_COMPONENTE_CG, progressivoBigD, idPersonaGiuridica, cfUtenteMod, Constants.ID_RUOLO_MANUTENTORE_ALL_4);
			getDbServiceImp().updateListComponentiCG(compList, codImpianto, progressivo, cfUtenteMod);
			SigitTComp4Pk pkComp4 = new SigitTComp4Pk(codImpiantoBigD, Constants.TIPO_COMPONENTE_CG, progressivoBigD);
			if(utenteMod!=null && utenteMod.getRuoloLoggato()!=null) {
				getDbServiceImp().salvaAzioneComp4(pkComp4, componente.getDataInstall(), cfUtenteMod, utenteMod.getRuoloLoggato().getRuolo());
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("Errore salvataggio componente CG: ", e);
			throw new SigitextException("Errore salvataggio dati CG");
		} finally {
			logger.debug("[ServiceManager::salvaComponenteCG] END");
		}
	}

	public Integer getImpresaAssociata(UtenteLoggato utente, String codImpiantoSelez, int FkRuolo, int progressivo) throws SigitRComp4ManutDaoException {
		Integer idPersonaGiuridica = utente != null && utente.getRuoloLoggato() != null ? utente.getRuoloLoggato().getIdPersonaGiuridica() : null;

		if (idPersonaGiuridica == null) {
			//SigitRImpRuoloPfpgDto installatore = getDbServiceImp().getInstallatoreImpianto(codImpiantoSelez);
			SigitRComp4ManutDto manutentore = getDbServiceImp().getManutentoreImpianto(codImpiantoSelez, FkRuolo, progressivo);
			logger.debug(manutentore);
			if (manutentore != null) {
				idPersonaGiuridica = ConvertUtil.convertToInteger(manutentore.getFkPersonaGiuridica());
			}
		}

		return idPersonaGiuridica;

	}

	public Integer contaComponenti4ByFilter(String codiceImpianto, Integer progressivo, String tipologia) throws SigitextException {
		logger.debug("[ServiceManager::contaComponenti4ByFilter] START");
		List<?> output = null;
		CompFilter filter = new CompFilter(Integer.parseInt(codiceImpianto), progressivo != null ? progressivo.toString() : null);
		try {
			if (Constants.TIPO_COMPONENTE_CG.equals(tipologia)) {
				output = getDbServiceImp().getSigitTCompCgDao().ricercaComponentiByFiltro(filter);
			} else if (Constants.TIPO_COMPONENTE_GT.equals(tipologia)) {
				output = getDbServiceImp().getSigitTCompGtDao().ricercaComponentiByFiltro(filter);
			} else if (Constants.TIPO_COMPONENTE_SC.equals(tipologia)) {
				output = getDbServiceImp().getSigitTCompScDao().ricercaComponentiByFiltro(filter);
			} else if (Constants.TIPO_COMPONENTE_GF.equals(tipologia)) {
				output = getDbServiceImp().getSigitTCompGfDao().ricercaComponentiByFiltro(filter);
			}
			if (output != null) {
				return output.size();
			}
			return 0;
		} catch (Exception e) {
			logger.error("[ServiceManager::contaComponenti4ByFilter] errore recuoeri componenti: ", e);
			throw new SigitextException("Errore recupero dati DB");
		} finally {
			logger.debug("[ServiceManager::contaComponenti4ByFilter] END");
		}
	}

	public Object cercaComponente4AttivaByFilter(String codiceImpianto, Integer progressivo, String tipoComponente) throws SigitextException {
		logger.debug("[SigitManager::cercaComponente4AttivaByFilter] START");
		CompFilter filter = new CompFilter(Integer.parseInt(codiceImpianto), progressivo != null ? progressivo.toString() : null);
		Object output = null;
		List<?> outputList = null;
		try {
			switch (tipoComponente) {
				case Constants.TIPO_COMPONENTE_CG:
					outputList = getDbServiceImp().getSigitTCompCgDao().ricercaComponentiCompletoByFiltro(filter);
					if (outputList != null && !outputList.isEmpty()) {
						output = MapDto.mapToDatiCG((SigitTCompCgCompletoDto) outputList.get(0));
					}
					break;
				case Constants.TIPO_COMPONENTE_GT:
					outputList = getDbServiceImp().getSigitTCompGtDao().ricercaComponentiByFiltro(filter);
					if (outputList != null && !outputList.isEmpty()) {
						output = MapDto.mapToDatiGT((SigitTCompGtCompletoDto) outputList.get(0));
					}
					break;
				case Constants.TIPO_COMPONENTE_SC:
					outputList = getDbServiceImp().getSigitTCompScDao().ricercaComponentiCompletoByFiltro(filter);
					if (outputList != null && !outputList.isEmpty()) {
						output = MapDto.mapToDatiSC((SigitTCompScCompletoDto) outputList.get(0));
					}
					break;
				case Constants.TIPO_COMPONENTE_GF:
					outputList = getDbServiceImp().getSigitTCompGfDao().ricercaComponentiCompletoByFiltro(filter);
					if (outputList != null && !outputList.isEmpty()) {
						output = MapDto.mapToDatiGF((SigitTCompGfCompletoDto) outputList.get(0));
					}
					break;
			}
		} catch (Exception e) {
			logger.error("Errore recupero componenti attivi: " + e.getMessage(), e);
			throw new SigitextException("Errore recupero componenti attivi");
		} finally {
			logger.debug("[SigitManager::cercaComponente4AttivaByFilter] END");
		}
		return output;

	}

	public void checkPresenzaREEComponenteDaEliminare(String codiceImpianto, String tipoComponente, String progressivo) throws ValidationManagerException, SigitextException {
		//CONTROLLA SE SULLA COMPONENTE CI SONO REE E PRENDE L'ULTIMO
		CompFilter filter = new CompFilter();
		filter.setCodImpianto(Integer.parseInt(codiceImpianto));
		filter.setTipoComponente(tipoComponente);
		filter.setProgressivo(progressivo);

		List<SigitRComp4ManutAllDto> listaIdAllegati = getDbServiceImp().cercaComp4ManutAllByComp(filter);
		SigitRComp4ManutAllDto ultimo = null;
		if (listaIdAllegati != null && !listaIdAllegati.isEmpty()) {
			ultimo = listaIdAllegati.get(listaIdAllegati.size() - 1);
		}

		if (ultimo != null) {
			SigitTAllegatoDto allegato = getDbServiceImp().cercaSigitTAllegatoById(ultimo.getIdAllegato());
			throw new ValidationManagerException(new Message(Messages.S164_3, ConvertUtil.convertToString(allegato.getDataControllo())));
		}
	}

	public void checkPresenzaBRRCbyGT(String codiceImpiantoGT, String dataInstallazioneGT, String progressivoGT) throws SigitextException {
		getDbServiceImp().verificaBRRCByGT(codiceImpiantoGT, dataInstallazioneGT, progressivoGT);
	}
	
	public List<Integer> getIdAllegatoListFromSigitRAllegatoCompXXByCodiceImpianto(Integer codiceImpianto) throws SigitRAllegatoCompScDaoException, SigitRAllegatoCompGtDaoException, SigitRAllegatoCompGfDaoException, SigitRAllegatoCompCgDaoException{
		List<Integer> responseList = new ArrayList<>();
		
		List<SigitRAllegatoCompScDto> scList = getDbServiceImp().findSigitRAllegatoCompScDtoByCodiceImpianto(codiceImpianto);
		List<SigitRAllegatoCompGtDto> gtList = getDbServiceImp().findSigitRAllegatoCompGtDtoByCodiceImpianto(codiceImpianto);
		List<SigitRAllegatoCompGfDto> gfList = getDbServiceImp().findSigitRAllegatoCompGfDtoByCodiceImpianto(codiceImpianto);
		List<SigitRAllegatoCompCgDto> cgList = getDbServiceImp().findSigitRAllegatoCompCgDtoByCodiceImpianto(codiceImpianto);
		
		for(SigitRAllegatoCompScDto dto : scList) {
			responseList.add(dto.getIdAllegato().intValue());
		}
		for(SigitRAllegatoCompGtDto dto : gtList) {
			responseList.add(dto.getIdAllegato().intValue());
		}
		for(SigitRAllegatoCompGfDto dto : gfList) {
			responseList.add(dto.getIdAllegato().intValue());
		}
		for(SigitRAllegatoCompCgDto dto : cgList) {
			responseList.add(dto.getIdAllegato().intValue());
		}
		
		return responseList;
	}

	public List<Controllo> getControlliOrdinati(String codice, String ordinamento, Integer numeroRighe) throws SigitextException {
		logger.debug("[SigitManager::getControlliOrdinati] START");
		List<SigitVRicercaAllegatiDto> outputList = null;
		List<Controllo> output = null;
		try {
			outputList = getDbServiceImp().cercaControlliOrdinati(codice, ordinamento, numeroRighe);
			CompFilter compFilter = new CompFilter();
			for (SigitVRicercaAllegatiDto ricercaAllegatiDto : outputList) {
				compFilter.setIdAllegato(ricercaAllegatiDto.getIdAllegato().intValue());
				StringBuilder compList = new StringBuilder();
				String delimitatore = "";
				switch (ricercaAllegatiDto.getFkTipoDocumento().toString()) {
					case Constants.ALLEGATO_TIPO_1:
					case Constants.ALLEGATO_TIPO_1B:
					case Constants.MANUTENZIONE_GT:
						List<SigitRAllegatoCompGtDto> ricercaAllegato = getDbServiceImp().getSigitRAllegatoCompGtDao().findByFilter(compFilter);
						for (SigitRAllegatoCompGtDto comp : ricercaAllegato) {
							compList.append(delimitatore).append(comp.getIdTipoComponente()).append("-").append(comp.getProgressivo());
							delimitatore = "|";
						}
						break;
					case Constants.ALLEGATO_TIPO_2:
					case Constants.MANUTENZIONE_GF:

						List<SigitRAllegatoCompGfDto> ricercaAllegatoGf = getDbServiceImp().getSigitRAllegatoCompGfDao().findByFilter(compFilter);
						for (SigitRAllegatoCompGfDto comp : ricercaAllegatoGf) {
							compList.append(delimitatore).append(comp.getIdTipoComponente()).append("-").append(comp.getProgressivo());
							delimitatore = "|";
						}
						break;
					case Constants.ALLEGATO_TIPO_3:
					case Constants.MANUTENZIONE_SC:

						List<SigitRAllegatoCompScDto> ricercaAllegatoSc = getDbServiceImp().getSigitRAllegatoCompScDao().findByFilter(compFilter);
						for (SigitRAllegatoCompScDto comp : ricercaAllegatoSc) {
							compList.append(delimitatore).append(comp.getIdTipoComponente()).append("-").append(comp.getProgressivo());
							delimitatore = "|";
						}
						break;
					case Constants.ALLEGATO_TIPO_4:
					case Constants.MANUTENZIONE_CG:

						List<SigitRAllegatoCompCgDto> ricercaAllegatoCg = getDbServiceImp().getSigitRAllegatoCompCgDao().findByFilter(compFilter);
						for (SigitRAllegatoCompCgDto comp : ricercaAllegatoCg) {
							compList.append(delimitatore).append(comp.getIdTipoComponente()).append("-").append(comp.getProgressivo());
							delimitatore = "|";
						}
						break;

				}
				ricercaAllegatiDto.setElencoApparecchiature(compList.toString());
			}
			output = MapDto.mapToControllo(outputList);
		} catch (Exception e) {
			logger.error("Errore recupero controlli: ", e);
			throw new SigitextException("Errore recupero controlli", e);
		} finally {
			logger.debug("[SigitManager::getControlliOrdinati] END");
		}
		return output;
	}

	public SigitTAllegatoDto getAllegatoByidAllegato(Integer idAllegato) throws SigitextException {
		logger.debug("[SigitManager::getAllegatoByidAllegato] START");
		SigitTAllegatoDto output = null;
		try {
			output = getDbServiceImp().cercaSigitTAllegatoById(new BigDecimal(idAllegato));
		} catch (Exception e) {
			logger.error("Errore recupero allegato: ", e);
			throw new SigitextException("Errore recupero allegato", e);
		} finally {
			logger.debug("[SigitManager::getAllegatoByidAllegato] END");
		}
		return output;
	}

	public byte[] generaXMLControlloTipo1(SigitVRicercaAllegatiDto ricercaAllegatiDto, SigitTAllegatoDto allegatoDto) throws SigitextException {
		logger.debug("[SigitManager::generaXMLControlloTipo1] START");
		byte[] output = null;
		try {
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument mod1Import = MODIIDocument.Factory.newInstance();
			DatiManutentoreDocument.DatiManutentore datiManutentore = mod1Import.addNewMODII().addNewRichiesta().addNewDatiManutentore();
			datiManutentore.setNumeroREA(ricercaAllegatiDto.getPgNumeroRea().toString());
			datiManutentore.setCodiceFiscale(ricercaAllegatiDto.getPgCodiceFiscale());
			datiManutentore.setSiglaREA(ricercaAllegatiDto.getPgSiglaRea());
			DatiIntestazioneDocument.DatiIntestazione datiIntestazione = mod1Import.getMODII().getRichiesta().addNewDatiIntestazione();
			datiIntestazione.setAFDataControllo(ConvertUtil.convertToXmlCalendar(ricercaAllegatiDto.getDataControllo()));
			datiIntestazione.setCodiceBollino(ricercaAllegatiDto.getFkNumeroBollino().toString());
			datiIntestazione.setCodiceCatasto(ricercaAllegatiDto.getCodiceImpianto().toString());
			DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = mod1Import.getMODII().getRichiesta().addNewDatiAllegato().addNewDatiIdentificativi();
			datiIdentificativi.setAAPotenzaTermicaNomTotMax(allegatoDto.getAPotenzaTermicaNominaleMax());
			DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = mod1Import.getMODII().getRichiesta().getDatiAllegato().addNewDocumentazioneTecnica();
			documentazioneTecnica.setABFlagDichiarazConf(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgDichiarConform()));
			documentazioneTecnica.setABFlagManutGen(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgLibrettoUso()));
			documentazioneTecnica.setABFlagLibrettoComp(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgLibCompl()));
			documentazioneTecnica.setABFlagLibrettoImp(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgLibImp()));

			CheckListDocument.CheckList importCheckList = mod1Import.getMODII().getRichiesta().getDatiAllegato().addNewCheckList();

			importCheckList.setAFOsservazioni(ricercaAllegatiDto.getFOsservazioni());
			importCheckList.setAFRaccomandazioni(ricercaAllegatiDto.getFRaccomandazioni());
			importCheckList.setAFPrescrizioni(ricercaAllegatiDto.getFPrescrizioni());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiTecnicoDocument.DatiTecnico datiTecnico = mod1Import.getMODII().getRichiesta().getDatiAllegato().addNewDatiTecnico();

			datiTecnico.setAFFlagFunzImp(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getFFlgPuoFunzionare()));

			datiTecnico.setAFDataIntervento(ConvertUtil.convertDateToXmlCalendar(ricercaAllegatiDto.getFInterventoEntro()));

			datiTecnico.setAFOrarioArrivo(ricercaAllegatiDto.getFOraArrivo());
			datiTecnico.setAFOrarioPartenza(ricercaAllegatiDto.getFOraPartenza());

			if (ricercaAllegatiDto.getFDenominazTecnico() != null && ricercaAllegatiDto.getFDenominazTecnico().split(" ").length == 2) {
				datiTecnico.setAFNomeTecnico(ricercaAllegatiDto.getFDenominazTecnico().split(" ")[0]);
				datiTecnico.setAFCognomeTecnico(ricercaAllegatiDto.getFDenominazTecnico().split(" ")[1]);
			} else {
				datiTecnico.setAFCognomeTecnico(ricercaAllegatiDto.getFDenominazTecnico() != null ? ricercaAllegatiDto.getFDenominazTecnico().split(" ")[0] : null);
			}

			datiTecnico.setAFFirmaTecnico(allegatoDto.getFFirmaTecnico());
			datiTecnico.setAFFirmaResp(allegatoDto.getFFirmaResponsabile());

			BigDecimal idAllegato = ricercaAllegatiDto.getIdAllegato();

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.ControlloImpiantoDocument.ControlloImpianto importCi = mod1Import.getMODII().getRichiesta().getDatiAllegato()
					.addNewControlloImpianto();

			SigitTRappTipo1Dto rapportoTipo1Dto = getDbServiceImp().getSigitTRappTipo1Dao().findByPrimaryKey(new SigitTRappTipo1Pk(idAllegato));

			//sezione D.controllo dell'impianto
			importCi.setADFlagInterno(ConvertUtil.convertToBigInteger(rapportoTipo1Dto.getDFlgLocaleIntIdoneo()));
			importCi.setADFlagEsterno(ConvertUtil.convertToBigInteger(rapportoTipo1Dto.getDFlgGenExtIdoneo()));
			importCi.setADFlagAperture(ConvertUtil.convertToBigInteger(rapportoTipo1Dto.getDFlgApertureLibere()));

			importCi.setADFlagDimensioni(ConvertUtil.convertToBigInteger(rapportoTipo1Dto.getDFlgApertureAdeg()));
			importCi.setADFlagCanaleFumo(ConvertUtil.convertToBigInteger(rapportoTipo1Dto.getDFlgScaricoIdoneo()));
			importCi.setADFlagSistRegolaz(ConvertUtil.convertToBigInteger(rapportoTipo1Dto.getDFlgTempAmbFunz()));
			importCi.setADFlagPerdite(ConvertUtil.convertToBigInteger(rapportoTipo1Dto.getDFlgAssenzaPerdComb()));
			importCi.setADFlagTenuta(ConvertUtil.convertToBigInteger(rapportoTipo1Dto.getDFlgIdoTenImpInt()));

			TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod1Import.getMODII().getRichiesta().getDatiAllegato().addNewTrattamentoAcqua();

			impTa.setACFlagTrattH2ONR(ConvertUtil.convertToBooleanAllways(rapportoTipo1Dto.getCFlgTrattClimaNonRich()));
			impTa.setACFlagTrattAcsNR(ConvertUtil.convertToBooleanAllways(rapportoTipo1Dto.getCFlgTrattAcsNonRichiesto()));

			CompFilter compFilter = new CompFilter();
			compFilter.setIdAllegato(idAllegato.intValue());

			SigitTDettTipo1Dto input = new SigitTDettTipo1Dto();
			input.setFkAllegato(idAllegato);
			List<SigitTDettTipo1Dto> compGtList = getDbServiceImp().getSigitTDettTipo1Dao().findByAllegatoCodImpianto(input);
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiAllegatoDocument.DatiAllegato.AllegatoII allegato2 = mod1Import.getMODII().getRichiesta().getDatiAllegato().addNewAllegatoII();
			RowAllegatoIIDocument.RowAllegatoII rowAllegatoII = null;
			RowAllegatoIIDocument.RowAllegatoII.TabFumi tabFumi = null;
			BigDecimal progressivo = BigDecimal.ZERO;
			for (SigitTDettTipo1Dto sigitTDettTipo1Dto : compGtList) {
				if (!sigitTDettTipo1Dto.getProgressivo().equals(progressivo)) {
					progressivo = sigitTDettTipo1Dto.getProgressivo();
					rowAllegatoII = allegato2.addNewRowAllegatoII();
					it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica importCve = rowAllegatoII.addNewControlloVerificaEnergetica();
					rowAllegatoII.setAENumGT(ConvertUtil.convertToBigInteger(sigitTDettTipo1Dto.getProgressivo()));
					importCve.setAEFlagClimatizInv(ConvertUtil.convertToBooleanAllways(sigitTDettTipo1Dto.getEFlgClimaInverno()));
					importCve.setAEFlagProduzACS(ConvertUtil.convertToBooleanAllways(sigitTDettTipo1Dto.getEFlgProduzAcs()));
					importCve.setAEFlagDispComando(ConvertUtil.convertToBigInteger(sigitTDettTipo1Dto.getEFlgDisposComando()));
					importCve.setAEFlagDispSicu(ConvertUtil.convertToBigInteger(sigitTDettTipo1Dto.getEFlgDisposSicurezza()));
					importCve.setAEFlagValvSicu(ConvertUtil.convertToBigInteger(sigitTDettTipo1Dto.getEFlgValvolaSicurezza()));
					importCve.setAEFlagScambiatore(ConvertUtil.convertToBigInteger(sigitTDettTipo1Dto.getEFlgScambiatoreFumi()));
					importCve.setAEFlagRiflusso(ConvertUtil.convertToBigInteger(sigitTDettTipo1Dto.getEFlgRiflusso()));
					importCve.setAEFlagRisultati(ConvertUtil.convertToBigInteger(sigitTDettTipo1Dto.getEFlgUni103891()));
					importCve.setAEPotenzaFocolare(sigitTDettTipo1Dto.getEPotTermFocolKw());
					importCve.setAEFlagEvacFumi(FumiFN.Enum.forString(sigitTDettTipo1Dto.getEFlgEvacuFumi()));
					importCve.setAEAltroRifNormativo(sigitTDettTipo1Dto.getL111AltroRiferimento());
					importCve.setAEDepressCanaleFumo(sigitTDettTipo1Dto.getEDeprCanaleFumoPa());
					tabFumi = rowAllegatoII.addNewTabFumi();
				}
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowFumiDocument.RowFumi rowFumiImport = tabFumi.addNewRowFumi();
				rowFumiImport.setAETempFumi(sigitTDettTipo1Dto.getETempFumiC());
				rowFumiImport.setAETempAria(sigitTDettTipo1Dto.getETempAriaC());
				rowFumiImport.setAEO2(sigitTDettTipo1Dto.getEO2Perc());
				rowFumiImport.setAECO2(sigitTDettTipo1Dto.getECo2Perc());
				rowFumiImport.setAEBacharach1(sigitTDettTipo1Dto.getEBacharachMin());
				rowFumiImport.setAEBacharach2(sigitTDettTipo1Dto.getEBacharachMed());
				rowFumiImport.setAEBacharach3(sigitTDettTipo1Dto.getEBacharachMax());
				rowFumiImport.setAECOcorretto(sigitTDettTipo1Dto.getECoCorrettoPpm());
				rowFumiImport.setAERendimCombu(sigitTDettTipo1Dto.getERendCombPerc());
				rowFumiImport.setAERendimentoLegge(sigitTDettTipo1Dto.getERendMinLeggePerc());
				rowFumiImport.setAENox(sigitTDettTipo1Dto.getENoxMgKwh());
				rowFumiImport.setAEModuloTermico(ConvertUtil.convertToBigInteger(sigitTDettTipo1Dto.getENModuloTermico()));
				rowFumiImport.setAEPortataCombu(Portata.Enum.forString(sigitTDettTipo1Dto.getL111PortataCombustibileUm()));
				rowFumiImport.setAEValorePortata(sigitTDettTipo1Dto.getL111PortataCombustibile());
				rowFumiImport.setAECOfumiSecchi(sigitTDettTipo1Dto.getL111CoNoAriaPpm());
				if (sigitTDettTipo1Dto.getL111FlgRispettaBacharach() != null)
					rowFumiImport.setAERispettoIndBacharach(ConvertUtil.convertToBoolean(sigitTDettTipo1Dto.getL111FlgRispettaBacharach()));
				if (sigitTDettTipo1Dto.getL111FlgRendMagRendMin() != null)
					rowFumiImport.setAEMinimo(ConvertUtil.convertToBoolean(sigitTDettTipo1Dto.getL111FlgRendMagRendMin()));
			}
			importCheckList.setAFFlagValvole(ConvertUtil.convertToBooleanAllways(rapportoTipo1Dto.getFFlgAdozioneValvoleTerm()));
			importCheckList.setAFFlagIsolamento(ConvertUtil.convertToBooleanAllways(rapportoTipo1Dto.getFFlgIsolamenteRete()));
			importCheckList.setAFFlagSistTrattACS(ConvertUtil.convertToBooleanAllways(rapportoTipo1Dto.getFFlgAdozSistTrattamH2o()));
			importCheckList.setAFFlagSistRegolaz(ConvertUtil.convertToBooleanAllways(rapportoTipo1Dto.getFFlgSostituzSistRegolaz()));

			output = XmlBeanUtils.extractByteArray(mod1Import);
		} catch (Exception e) {
			logger.error("Errore generazione XML controllo tipo 1: ", e);
			throw new SigitextException("Errore generazione XML", e);
		} finally {
			logger.debug("[SigitManager::generaXMLControlloTipo1] END");
		}
		return output;
	}

	public byte[] generaXMLControlloTipo1B(SigitVRicercaAllegatiDto ricercaAllegatiDto, SigitTAllegatoDto allegatoDto) throws SigitextException {
		logger.debug("[SigitManager::generaXMLControlloTipo1] START");
		byte[] output = null;
		try {
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.MODIIBDocument mod1Import = MODIIBDocument.Factory.newInstance();
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.DatiManutentoreDocument.DatiManutentore datiManutentore = mod1Import.addNewMODIIB().addNewRichiesta().addNewDatiManutentore();
			datiManutentore.setNumeroREA(ricercaAllegatiDto.getPgNumeroRea().toString());
			datiManutentore.setCodiceFiscale(ricercaAllegatiDto.getPgCodiceFiscale());
			datiManutentore.setSiglaREA(ricercaAllegatiDto.getPgSiglaRea());
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = mod1Import.getMODIIB().getRichiesta().addNewDatiIntestazione();
			datiIntestazione.setAFDataControllo(ConvertUtil.convertToXmlCalendar(ricercaAllegatiDto.getDataControllo()));
			datiIntestazione.setCodiceBollino(ricercaAllegatiDto.getFkNumeroBollino().toString());
			datiIntestazione.setCodiceCatasto(ricercaAllegatiDto.getCodiceImpianto().toString());
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = mod1Import.getMODIIB().getRichiesta().addNewDatiAllegato()
					.addNewDatiIdentificativi();
			datiIdentificativi.setAAPotenzaTermicaNomTotMax(allegatoDto.getAPotenzaTermicaNominaleMax());
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = mod1Import.getMODIIB().getRichiesta().getDatiAllegato()
					.addNewDocumentazioneTecnica();
			documentazioneTecnica.setABFlagDichiarazConf(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgDichiarConform()));
			documentazioneTecnica.setABFlagManutGen(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgLibrettoUso()));
			documentazioneTecnica.setABFlagLibrettoComp(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgLibCompl()));
			documentazioneTecnica.setABFlagLibrettoImp(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgLibImp()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.CheckListDocument.CheckList importCheckList = mod1Import.getMODIIB().getRichiesta().getDatiAllegato().addNewCheckList();

			importCheckList.setAFOsservazioni(ricercaAllegatiDto.getFOsservazioni());
			importCheckList.setAFRaccomandazioni(ricercaAllegatiDto.getFRaccomandazioni());
			importCheckList.setAFPrescrizioni(ricercaAllegatiDto.getFPrescrizioni());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.DatiTecnicoDocument.DatiTecnico datiTecnico = mod1Import.getMODIIB().getRichiesta().getDatiAllegato().addNewDatiTecnico();

			datiTecnico.setAFFlagFunzImp(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getFFlgPuoFunzionare()));

			datiTecnico.setAFDataIntervento(ConvertUtil.convertDateToXmlCalendar(ricercaAllegatiDto.getFInterventoEntro()));

			datiTecnico.setAFOrarioArrivo(ricercaAllegatiDto.getFOraArrivo());
			datiTecnico.setAFOrarioPartenza(ricercaAllegatiDto.getFOraPartenza());

			if (ricercaAllegatiDto.getFDenominazTecnico() != null && ricercaAllegatiDto.getFDenominazTecnico().split(" ").length == 2) {
				datiTecnico.setAFNomeTecnico(ricercaAllegatiDto.getFDenominazTecnico().split(" ")[0]);
				datiTecnico.setAFCognomeTecnico(ricercaAllegatiDto.getFDenominazTecnico().split(" ")[1]);
			} else {
				datiTecnico.setAFCognomeTecnico(ricercaAllegatiDto.getFDenominazTecnico() != null ? ricercaAllegatiDto.getFDenominazTecnico().split(" ")[0] : null);
			}

			datiTecnico.setAFFirmaTecnico(allegatoDto.getFFirmaTecnico());
			datiTecnico.setAFFirmaResp(allegatoDto.getFFirmaResponsabile());

			BigDecimal idAllegato = ricercaAllegatiDto.getIdAllegato();

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.ControlloImpiantoDocument.ControlloImpianto importCi = mod1Import.getMODIIB().getRichiesta().getDatiAllegato()
					.addNewControlloImpianto();

			SigitTRappTipo1Dto sigitTRappTipo1Dto = getDbServiceImp().getSigitTRappTipo1Dao().findByPrimaryKey(new SigitTRappTipo1Pk(idAllegato));

			//sezione D.controllo dell'impianto
			importCi.setADFlagInterno(ConvertUtil.convertToBigInteger(sigitTRappTipo1Dto.getDFlgLocaleIntIdoneo()));
			importCi.setADFlagEsterno(ConvertUtil.convertToBigInteger(sigitTRappTipo1Dto.getDFlgGenExtIdoneo()));
			importCi.setADFlagAperture(ConvertUtil.convertToBigInteger(sigitTRappTipo1Dto.getDFlgApertureLibere()));
			importCi.setADFlagDimensioni(ConvertUtil.convertToBigInteger(sigitTRappTipo1Dto.getDFlgApertureAdeg()));
			importCi.setADFlagCanaleFumo(ConvertUtil.convertToBigInteger(sigitTRappTipo1Dto.getDFlgScaricoIdoneo()));
			importCi.setADFlagSistRegolaz(ConvertUtil.convertToBigInteger(sigitTRappTipo1Dto.getDFlgTempAmbFunz()));
			importCi.setADFlagTenuta(ConvertUtil.convertToBigInteger(sigitTRappTipo1Dto.getDFlgIdoTenImpInt()));
			importCi.setADFlagPuliziaCamino(ConvertUtil.convertToBigInteger(sigitTRappTipo1Dto.getDFlgAssenzaPerdComb()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod1Import.getMODIIB().getRichiesta().getDatiAllegato().addNewTrattamentoAcqua();

			impTa.setACFlagTrattH2ONR(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getCFlgTrattClimaNonRich()));
			impTa.setACFlagTrattAcsNR(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getCFlgTrattAcsNonRichiesto()));

			SigitTConsumoTipo1BDto filter = new SigitTConsumoTipo1BDto();
			filter.setFkAllegato(idAllegato);
			filter.setIdTipoConsumo1b(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_CONSUMO_1B_ACQUA_REINTEGRO));
			List<SigitTConsumoTipo1BDto> consumoTipo1BAcquaReintegroDtoList = getDbServiceImp().getSigitTConsumoTipo1BDao().findByFilter(filter);

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.TrattamentoAcquaDocument.TrattamentoAcqua.ACAcquaReintegro ac = impTa.addNewACAcquaReintegro();

			for (SigitTConsumoTipo1BDto consumo : consumoTipo1BAcquaReintegroDtoList) {
				RowAcquaReintegroDocument.RowAcquaReintegro row = ac.addNewRowAcquaReintegro();
				row.setACEsercizio(ConvertUtil.convertToBigInteger(consumo.getEsercizio()));
				row.setACLetturaIniziale(ConvertUtil.convertToBigInteger(consumo.getLetturaIniziale()));
				row.setACLetturaFinale(ConvertUtil.convertToBigInteger(consumo.getLetturaFinale()));
				row.setACConsumoTotale(ConvertUtil.convertToBigDecimal(consumo.getConsumo()));
				row.setACUnitaMisura(ConvertUtil.convertToInteger(consumo.getIdUnitaMisura()));
			}

			CompFilter compFilter = new CompFilter();
			compFilter.setIdAllegato(idAllegato.intValue());

			SigitTDettTipo1Dto input = new SigitTDettTipo1Dto();
			input.setFkAllegato(idAllegato);
			List<SigitTDettTipo1Dto> compGtList = getDbServiceImp().getSigitTDettTipo1Dao().findByAllegatoCodImpianto(input);
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.DatiAllegatoDocument.DatiAllegato.AllegatoIIB allegato2 = mod1Import.getMODIIB().getRichiesta().getDatiAllegato()
					.addNewAllegatoIIB();
			RowAllegatoIIBDocument.RowAllegatoIIB rowAllegatoIIB = null;
			RowAllegatoIIBDocument.RowAllegatoIIB.TabFumi tabFumi = null;
			BigDecimal progressivo = BigDecimal.ZERO;
			filter = new SigitTConsumoTipo1BDto();
			filter.setFkAllegato(idAllegato);
			filter.setIdTipoConsumo1b(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_CONSUMO_1B_CONSUMO_BIOMASSA));
			List<SigitTConsumoTipo1BDto> consumoCombustibile = getDbServiceImp().getSigitTConsumoTipo1BDao().findByFilter(filter);
			for (SigitTDettTipo1Dto sigitTDettTipo1Dto : compGtList) {
				if (!sigitTDettTipo1Dto.getProgressivo().equals(progressivo)) {
					progressivo = sigitTDettTipo1Dto.getProgressivo();
					rowAllegatoIIB = allegato2.addNewRowAllegatoIIB();
					it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica importCve = rowAllegatoIIB.addNewControlloVerificaEnergetica();
					rowAllegatoIIB.setAENumGT(ConvertUtil.convertToBigInteger(sigitTDettTipo1Dto.getProgressivo()));
					importCve.setAEFlagCaldaia(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getE1bFlgCaldaia()));
					importCve.setAEFlagStufa(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getE1bFlgStufa()));
					importCve.setAEFlagStufaAccumulo(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getE1bFlgStufaAccumulo()));
					importCve.setAEFlagTermocucina(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getE1bFlgTermocucina()));
					importCve.setAEFlagCaminoAperto(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getE1bFlgCaminettoAperto()));
					importCve.setAEFlagCaminoChiuso(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getE1bFlgCaminettoChiuso()));
					importCve.setAEFlagInsertoCamino(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getE1bFlgInsertoCaminetto()));
					importCve.setAEFlagStufaAssemblata(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getE1bFlgStufaAssemblata()));
					importCve.setAEFlagStufaPellet(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getE1bFlgStufaPellet()));
					if (sigitTRappTipo1Dto.getIdStelle() != null)
						importCve.setAEStelle(MapDto.mapStellaCitToStellaXml(sigitTRappTipo1Dto.getIdStelle().intValue()));
					if (sigitTRappTipo1Dto.getIdTipo1b() != null)
						importCve.setAEApparecchiatura(ConvertUtil.convertToInteger(sigitTRappTipo1Dto.getIdTipo1b()));
					if (sigitTRappTipo1Dto.getIdAriaComburente() != null)
						importCve.setAEAriaComburente(ConvertUtil.convertToInteger(sigitTRappTipo1Dto.getIdAriaComburente()));
					if (sigitTRappTipo1Dto.getIdControlloAria() != null)
						importCve.setAEControlloAria(ConvertUtil.convertToInteger(sigitTRappTipo1Dto.getIdControlloAria()));
					if (sigitTRappTipo1Dto.getIdTipoCaricCombu() != null)
						importCve.setAECarcaCombu(ConvertUtil.convertToInteger(sigitTRappTipo1Dto.getIdTipoCaricCombu()));
					importCve.setAEFlagMarcaturaCEE(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getE1bFlgMarcaturaCe()));
					importCve.setAEFlagPlaccaCamino(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getE1bFlgPlaccaCamino()));
					importCve.setAEFlagClimatizInv(ConvertUtil.convertToBooleanAllways(sigitTDettTipo1Dto.getEFlgClimaInverno()));
					importCve.setAEFlagProduzACS(ConvertUtil.convertToBooleanAllways(sigitTDettTipo1Dto.getEFlgProduzAcs()));
					importCve.setAEFlagCucina(ConvertUtil.convertToBooleanAllways(sigitTDettTipo1Dto.getE1bFlgCucina()));
					importCve.setAEFlagDispComando(ConvertUtil.convertToBigInteger(sigitTDettTipo1Dto.getEFlgDisposComando()));
					importCve.setAEFlagDispSicu(ConvertUtil.convertToBigInteger(sigitTDettTipo1Dto.getEFlgDisposSicurezza()));
					importCve.setAEFlagValvSicu(ConvertUtil.convertToBigInteger(sigitTDettTipo1Dto.getEFlgValvolaSicurezza()));
					importCve.setAEFlagScambiatore(ConvertUtil.convertToBigInteger(sigitTDettTipo1Dto.getEFlgScambiatoreFumi()));
					importCve.setAEFlagRiflusso(ConvertUtil.convertToBigInteger(sigitTDettTipo1Dto.getEFlgRiflusso()));
					importCve.setAEFlagRisultati(ConvertUtil.convertToBigInteger(sigitTDettTipo1Dto.getEFlgUni103891()));
					importCve.setAEFlagRisultati(ConvertUtil.convertToBigInteger(sigitTDettTipo1Dto.getE1bFlgUni103892()));
					importCve.setAEPotenzaFocolare(sigitTDettTipo1Dto.getEPotTermFocolKw());
					importCve.setAEFlagEvacFumi(
							sigitTDettTipo1Dto.getEFlgEvacuFumi() != null ? it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.FumiFN.Enum.forString(sigitTDettTipo1Dto.getEFlgEvacuFumi()) :
									null);
					importCve.setAEAltroRifNormativo(sigitTDettTipo1Dto.getL111AltroRiferimento());
					importCve.setAEDepressCanaleFumo(sigitTDettTipo1Dto.getEDeprCanaleFumoPa());
					RowAllegatoIIBDocument.RowAllegatoIIB.TabCombustibile tabCombustibile = rowAllegatoIIB.addNewTabCombustibile();
					for (SigitTConsumoTipo1BDto combu : consumoCombustibile) {
						RowCombustibileDocument.RowCombustibile row = tabCombustibile.addNewRowCombustibile();
						row.setAEEsercizio(ConvertUtil.convertToBigInteger(combu.getEsercizio()));
						row.setAEConsumoAnnuo(combu.getConsumo());
						row.setAEUnitaMisura(ConvertUtil.convertToInteger(combu.getIdUnitaMisura()));
					}
					tabFumi = rowAllegatoIIB.addNewTabFumi();
				}

				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.RowFumiDocument.RowFumi rowFumiImport = tabFumi.addNewRowFumi();
				rowFumiImport.setAETempFumi(sigitTDettTipo1Dto.getETempFumiC());
				rowFumiImport.setAETempAria(sigitTDettTipo1Dto.getETempAriaC());
				rowFumiImport.setAEO2(sigitTDettTipo1Dto.getEO2Perc());
				rowFumiImport.setAECO2(sigitTDettTipo1Dto.getECo2Perc());
				rowFumiImport.setAEParticolato(sigitTDettTipo1Dto.getE1bParticolatoMgAlM3());
				rowFumiImport.setAECOcorretto(sigitTDettTipo1Dto.getECoCorrettoPpm());
				rowFumiImport.setAERendimCombu(sigitTDettTipo1Dto.getERendCombPerc());
				rowFumiImport.setAERendimentoLegge(sigitTDettTipo1Dto.getERendMinLeggePerc());
				if (sigitTDettTipo1Dto.getENoxMgNm3() != null) {
					rowFumiImport.setAENox(sigitTDettTipo1Dto.getENoxMgNm3());
					rowFumiImport.setAENoxUM(UM.MG_NM_3);
				}
				if (sigitTDettTipo1Dto.getENoxMgKwh() != null) {
					rowFumiImport.setAENox(sigitTDettTipo1Dto.getENoxMgKwh());
					rowFumiImport.setAENoxUM(UM.MG_K_WH);
				}

				sigitTDettTipo1Dto.setENModuloTermico(ConvertUtil.convertToInteger(rowFumiImport.getAEModuloTermico()));
			}
			importCheckList.setAFFlagValvole(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getFFlgAdozioneValvoleTerm()));
			importCheckList.setAFFlagIsolamento(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getFFlgIsolamenteRete()));
			importCheckList.setAFFlagSistTrattACS(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getFFlgAdozSistTrattamH2o()));
			importCheckList.setAFFlagSistRegolaz(ConvertUtil.convertToBooleanAllways(sigitTRappTipo1Dto.getFFlgSostituzSistRegolaz()));

			output = XmlBeanUtils.extractByteArray(mod1Import);
		} catch (Exception e) {
			logger.error("Errore generazione XML controllo tipo 1: ", e);
			throw new SigitextException("Errore generazione XML", e);
		} finally {
			logger.debug("[SigitManager::generaXMLControlloTipo1] END");
		}
		return output;
	}

	public byte[] generaXMLControlloTipo2(SigitVRicercaAllegatiDto ricercaAllegatiDto, SigitTAllegatoDto allegatoDto) throws SigitextException {
		logger.debug("[SigitManager::generaXMLControlloTipo1] START");
		byte[] output = null;
		try {
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument mod1Import = MODIIIDocument.Factory.newInstance();
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiManutentoreDocument.DatiManutentore datiManutentore = mod1Import.addNewMODIII().addNewRichiesta().addNewDatiManutentore();
			datiManutentore.setNumeroREA(ricercaAllegatiDto.getPgNumeroRea().toString());
			datiManutentore.setCodiceFiscale(ricercaAllegatiDto.getPgCodiceFiscale());
			datiManutentore.setSiglaREA(ricercaAllegatiDto.getPgSiglaRea());
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = mod1Import.getMODIII().getRichiesta().addNewDatiIntestazione();
			datiIntestazione.setAFDataControllo(ConvertUtil.convertToXmlCalendar(ricercaAllegatiDto.getDataControllo()));
			datiIntestazione.setCodiceBollino(ricercaAllegatiDto.getFkNumeroBollino().toString());
			datiIntestazione.setCodiceCatasto(ricercaAllegatiDto.getCodiceImpianto().toString());
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = mod1Import.getMODIII().getRichiesta().addNewDatiAllegato()
					.addNewDatiIdentificativi();
			datiIdentificativi.setAAPotenzaTermicaNomTotMax(allegatoDto.getAPotenzaTermicaNominaleMax());
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = mod1Import.getMODIII().getRichiesta().getDatiAllegato()
					.addNewDocumentazioneTecnica();
			documentazioneTecnica.setABFlagDichiarazConf(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgDichiarConform()));
			documentazioneTecnica.setABFlagManutGen(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgLibrettoUso()));
			documentazioneTecnica.setABFlagLibrettoComp(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgLibCompl()));
			documentazioneTecnica.setABFlagLibrettoImp(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgLibImp()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.CheckListDocument.CheckList importCheckList = mod1Import.getMODIII().getRichiesta().getDatiAllegato().addNewCheckList();

			importCheckList.setAFOsservazioni(ricercaAllegatiDto.getFOsservazioni());
			importCheckList.setAFRaccomandazioni(ricercaAllegatiDto.getFRaccomandazioni());
			importCheckList.setAFPrescrizioni(ricercaAllegatiDto.getFPrescrizioni());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiTecnicoDocument.DatiTecnico datiTecnico = mod1Import.getMODIII().getRichiesta().getDatiAllegato().addNewDatiTecnico();

			datiTecnico.setAFFlagFunzImp(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getFFlgPuoFunzionare()));

			datiTecnico.setAFDataIntervento(ConvertUtil.convertDateToXmlCalendar(ricercaAllegatiDto.getFInterventoEntro()));

			datiTecnico.setAFOrarioArrivo(ricercaAllegatiDto.getFOraArrivo());
			datiTecnico.setAFOrarioPartenza(ricercaAllegatiDto.getFOraPartenza());

			if (ricercaAllegatiDto.getFDenominazTecnico() != null && ricercaAllegatiDto.getFDenominazTecnico().split(" ").length == 2) {
				datiTecnico.setAFNomeTecnico(ricercaAllegatiDto.getFDenominazTecnico().split(" ")[0]);
				datiTecnico.setAFCognomeTecnico(ricercaAllegatiDto.getFDenominazTecnico().split(" ")[1]);
			} else {
				datiTecnico.setAFCognomeTecnico(ricercaAllegatiDto.getFDenominazTecnico() != null ? ricercaAllegatiDto.getFDenominazTecnico().split(" ")[0] : null);
			}

			datiTecnico.setAFFirmaTecnico(allegatoDto.getFFirmaTecnico());
			datiTecnico.setAFFirmaResp(allegatoDto.getFFirmaResponsabile());

			BigDecimal idAllegato = ricercaAllegatiDto.getIdAllegato();

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.ControlloImpiantoDocument.ControlloImpianto importCi = mod1Import.getMODIII().getRichiesta().getDatiAllegato()
					.addNewControlloImpianto();

			SigitTRappTipo2Dto sigitTRappTipo2Dto = getDbServiceImp().getSigitTRappTipo2Dao().findByPrimaryKey(new SigitTRappTipo2Pk(idAllegato));

			//sezione D.controllo dell'impianto
			importCi.setADFlagLocaleIdoneo(ConvertUtil.convertToBigInteger(sigitTRappTipo2Dto.getDFlgLocaleIdoneo()));
			importCi.setADFlagAperture(ConvertUtil.convertToBigInteger(sigitTRappTipo2Dto.getDFlgApertureLibere()));
			importCi.setADFlagDimensioni(ConvertUtil.convertToBigInteger(sigitTRappTipo2Dto.getDFlgApertureAdeg()));
			importCi.setADFlagLineeIdonee(ConvertUtil.convertToBigInteger(sigitTRappTipo2Dto.getDFlgLineaElettIdonea()));
			importCi.setADFlagCoibenIdonee(ConvertUtil.convertToBigInteger(sigitTRappTipo2Dto.getDFlgCoibIdonea()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod1Import.getMODIII().getRichiesta().getDatiAllegato().addNewTrattamentoAcqua();

			impTa.setACFlagTrattH2ONR(ConvertUtil.convertToBooleanAllways(sigitTRappTipo2Dto.getCFlgTrattClimaNonRichiest()));

			CompFilter compFilter = new CompFilter();
			compFilter.setIdAllegato(idAllegato.intValue());

			SigitTDettTipo2Dto input = new SigitTDettTipo2Dto();
			input.setFkAllegato(idAllegato);
			List<SigitTDettTipo2Dto> compGfList = getDbServiceImp().getSigitTDettTipo2Dao().findByAllegatoCodImpianto(input);
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiAllegatoDocument.DatiAllegato.AllegatoIII allegato2 = mod1Import.getMODIII().getRichiesta().getDatiAllegato()
					.addNewAllegatoIII();
			RowAllegatoIIIDocument.RowAllegatoIII rowAllegatoIII = null;
			RowAllegatoIIIDocument.RowAllegatoIII.TabFumi tabFumi = null;
			BigDecimal progressivo = BigDecimal.ZERO;
			for (SigitTDettTipo2Dto sigitTDettTipo2Dto : compGfList) {
				if (!sigitTDettTipo2Dto.getProgressivo().equals(progressivo)) {
					progressivo = sigitTDettTipo2Dto.getProgressivo();
					rowAllegatoIII = allegato2.addNewRowAllegatoIII();
					it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica importCve = rowAllegatoIII.addNewControlloVerificaEnergetica();
					rowAllegatoIII.setAENumGF(ConvertUtil.convertToBigInteger(sigitTDettTipo2Dto.getProgressivo()));
					importCve.setAEFlagModalita(ModalitaRaRi.Enum.forString((sigitTDettTipo2Dto.getEFlgModProva())));
					importCve.setAEFlagPerdite(ConvertUtil.convertToBigInteger(sigitTDettTipo2Dto.getEFlgPerditaGas()));
					importCve.setAEFlagRilevFugheDiretta(ConvertUtil.convertToBigInteger(sigitTDettTipo2Dto.getEFlgLeakDetector()));
					importCve.setAEFlagRilevFugheInDiretta(ConvertUtil.convertToBigInteger(sigitTDettTipo2Dto.getEFlgParamTermodinam()));
					importCve.setAEFlagScambPuliti(ConvertUtil.convertToBigInteger(sigitTDettTipo2Dto.getEFlgIncrostazioni()));
					tabFumi = rowAllegatoIII.addNewTabFumi();
				}
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowFumiDocument.RowFumi rowFumiImport = tabFumi.addNewRowFumi();

				rowFumiImport.setAESurrisc(ConvertUtil.convertToBigDecimal(sigitTDettTipo2Dto.getETSurriscC()));
				rowFumiImport.setAESottoRaffr(ConvertUtil.convertToBigDecimal(sigitTDettTipo2Dto.getETSottorafC()));
				rowFumiImport.setAECondens(ConvertUtil.convertToBigDecimal(sigitTDettTipo2Dto.getETCondensazioneC()));
				rowFumiImport.setAEEvaporaz(ConvertUtil.convertToBigDecimal(sigitTDettTipo2Dto.getETEvaporazioneC()));
				rowFumiImport.setAEIngLatoEst(ConvertUtil.convertToBigDecimal(sigitTDettTipo2Dto.getETInExtC()));
				rowFumiImport.setAEUscLatoEst(ConvertUtil.convertToBigDecimal(sigitTDettTipo2Dto.getETOutExtC()));
				rowFumiImport.setAEIngLatoUtenze(ConvertUtil.convertToBigDecimal(sigitTDettTipo2Dto.getETInUtenzeC()));
				rowFumiImport.setAEUscLatoUtenze(ConvertUtil.convertToBigDecimal(sigitTDettTipo2Dto.getETOutUtenzeC()));
				rowFumiImport.setAETuscFluido(ConvertUtil.convertToBigDecimal(sigitTDettTipo2Dto.getL112TorreTOutFluido()));
				rowFumiImport.setAETbulboUmido(ConvertUtil.convertToBigDecimal(sigitTDettTipo2Dto.getL112TorreTBulboUmido()));
				rowFumiImport.setAETingFluidoSorg(ConvertUtil.convertToBigDecimal(sigitTDettTipo2Dto.getL112ScambiatoreTInExt()));
				rowFumiImport.setAETuscFluidoSorg(ConvertUtil.convertToBigDecimal(sigitTDettTipo2Dto.getL112ScambiatoreTOutExt()));
				rowFumiImport.setAETingFluidoMacc(ConvertUtil.convertToBigDecimal(sigitTDettTipo2Dto.getL112ScambiatTInMacchina()));
				rowFumiImport.setAETuscFluidoMacc(ConvertUtil.convertToBigDecimal(sigitTDettTipo2Dto.getL112ScambiatTOutMacchina()));
				rowFumiImport.setAEPotenzaAss(ConvertUtil.convertToBigDecimal(sigitTDettTipo2Dto.getL112PotenzaAssorbitaKw()));
				rowFumiImport.setAEFiltriPuliti(ConvertUtil.convertToBooleanAllways(sigitTDettTipo2Dto.getL112FlgPuliziaFiltri()));
				rowFumiImport.setAEVerifica(ConvertUtil.convertToBooleanAllways(sigitTDettTipo2Dto.getL112FlgVerificaSuperata()));
				rowFumiImport.setAEDataRipristino(ConvertUtil.convertToXmlCalendar(sigitTDettTipo2Dto.getL112DataRipristino()));
			}
			importCheckList.setAFFlagSostGen1(ConvertUtil.convertToBooleanAllways(sigitTRappTipo2Dto.getFFlgSostituzGeneratori()));
			importCheckList.setAFFlagSostGen2(ConvertUtil.convertToBooleanAllways(sigitTRappTipo2Dto.getFFlgSostituzSistemiReg()));
			importCheckList.setAFFlagIsolamentoRete(ConvertUtil.convertToBooleanAllways(sigitTRappTipo2Dto.getFFlgIsolDistribuzH2o()));
			importCheckList.xsetAFFlagIsolamentoCanali(MapDto.getXmlBoolean(ConvertUtil.convertToBooleanAllways(sigitTRappTipo2Dto.getFFlgIsolDistribuzAria())));

			output = XmlBeanUtils.extractByteArray(mod1Import);
		} catch (Exception e) {
			logger.error("Errore generazione XML controllo tipo 1: ", e);
			throw new SigitextException("Errore generazione XML", e);
		} finally {
			logger.debug("[SigitManager::generaXMLControlloTipo1] END");
		}
		return output;
	}

	public byte[] generaXMLControlloTipo3(SigitVRicercaAllegatiDto ricercaAllegatiDto, SigitTAllegatoDto allegatoDto) throws SigitextException {
		logger.debug("[SigitManager::generaXMLControlloTipo1] START");
		byte[] output = null;
		try {
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument mod1Import = MODIVDocument.Factory.newInstance();
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiManutentoreDocument.DatiManutentore datiManutentore = mod1Import.addNewMODIV().addNewRichiesta().addNewDatiManutentore();
			datiManutentore.setNumeroREA(ricercaAllegatiDto.getPgNumeroRea().toString());
			datiManutentore.setCodiceFiscale(ricercaAllegatiDto.getPgCodiceFiscale());
			datiManutentore.setSiglaREA(ricercaAllegatiDto.getPgSiglaRea());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = mod1Import.getMODIV().getRichiesta().addNewDatiIntestazione();
			datiIntestazione.setAFDataControllo(ConvertUtil.convertToXmlCalendar(ricercaAllegatiDto.getDataControllo()));
			datiIntestazione.setCodiceBollino(ricercaAllegatiDto.getFkNumeroBollino().toString());
			datiIntestazione.setCodiceCatasto(ricercaAllegatiDto.getCodiceImpianto().toString());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = mod1Import.getMODIV().getRichiesta().addNewDatiAllegato()
					.addNewDatiIdentificativi();
			datiIdentificativi.setAAPotenzaTermicaNomTotMax(allegatoDto.getAPotenzaTermicaNominaleMax());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = mod1Import.getMODIV().getRichiesta().getDatiAllegato()
					.addNewDocumentazioneTecnica();
			documentazioneTecnica.setABFlagDichiarazConf(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgDichiarConform()));
			documentazioneTecnica.setABFlagManutGen(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgLibrettoUso()));
			documentazioneTecnica.setABFlagLibrettoComp(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgLibCompl()));
			documentazioneTecnica.setABFlagLibrettoImp(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgLibImp()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiTecnicoDocument.DatiTecnico datiTecnico = mod1Import.getMODIV().getRichiesta().getDatiAllegato().addNewDatiTecnico();
			datiTecnico.setAFFlagFunzImp(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getFFlgPuoFunzionare()));
			datiTecnico.setAFDataIntervento(ConvertUtil.convertDateToXmlCalendar(ricercaAllegatiDto.getFInterventoEntro()));
			datiTecnico.setAFOrarioArrivo(ricercaAllegatiDto.getFOraArrivo());
			datiTecnico.setAFOrarioPartenza(ricercaAllegatiDto.getFOraPartenza());
			if (ricercaAllegatiDto.getFDenominazTecnico() != null && ricercaAllegatiDto.getFDenominazTecnico().split(" ").length == 4) {
				datiTecnico.setAFNomeTecnico(ricercaAllegatiDto.getFDenominazTecnico().split(" ")[0]);
				datiTecnico.setAFCognomeTecnico(ricercaAllegatiDto.getFDenominazTecnico().split(" ")[1]);
			} else {
				datiTecnico.setAFCognomeTecnico(ricercaAllegatiDto.getFDenominazTecnico() != null ? ricercaAllegatiDto.getFDenominazTecnico().split(" ")[0] : null);
			}
			datiTecnico.setAFFirmaTecnico(allegatoDto.getFFirmaTecnico());
			datiTecnico.setAFFirmaResp(allegatoDto.getFFirmaResponsabile());

			BigDecimal idAllegato = ricercaAllegatiDto.getIdAllegato();
			SigitTRappTipo3Dto sigitTRappTipo3Dto = getDbServiceImp().getSigitTRappTipo3Dao().findByPrimaryKey(new SigitTRappTipo3Pk(idAllegato));

			//sezione D.controllo dell'impianto
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.ControlloImpiantoDocument.ControlloImpianto importCi = mod1Import.getMODIV().getRichiesta().getDatiAllegato()
					.addNewControlloImpianto();
			importCi.setADFlagLuogoIdoneo(ConvertUtil.convertToBigInteger(sigitTRappTipo3Dto.getDFlgLocaleIdoneo()));
			importCi.setADFlagLineeIdonee(ConvertUtil.convertToBigInteger(sigitTRappTipo3Dto.getDFlgLineaElettIdonea()));
			importCi.setADFlagStatoCoiben(ConvertUtil.convertToBigInteger(sigitTRappTipo3Dto.getDFlgCoibIdonea()));
			importCi.setADFlagPerdite(ConvertUtil.convertToBigInteger(sigitTRappTipo3Dto.getDFlgAssenzaPerdite()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod1Import.getMODIV().getRichiesta().getDatiAllegato().addNewTrattamentoAcqua();

			impTa.setACFlagTrattH2ONR(ConvertUtil.convertToBooleanAllways(sigitTRappTipo3Dto.getCFlgTrattClimaNonRichiest()));
			impTa.setACFlagTrattAcsNR(ConvertUtil.convertToBooleanAllways(sigitTRappTipo3Dto.getCFlgTrattAcsNonRichiesto()));

			CompFilter compFilter = new CompFilter();
			compFilter.setIdAllegato(idAllegato.intValue());

			SigitTDettTipo3Dto input = new SigitTDettTipo3Dto();
			input.setFkAllegato(idAllegato);
			List<SigitTDettTipo3Dto> compGfList = getDbServiceImp().getSigitTDettTipo3Dao().findByAllegatoCodImpianto(input);
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiAllegatoDocument.DatiAllegato.AllegatoIV allegato4 = mod1Import.getMODIV().getRichiesta().getDatiAllegato().addNewAllegatoIV();
			RowAllegatoIVDocument.RowAllegatoIV rowAllegatoIV = null;
			RowAllegatoIVDocument.RowAllegatoIV.TabFumi tabFumi = null;
			BigDecimal progressivo = BigDecimal.ZERO;
			for (SigitTDettTipo3Dto sigitTDettTipo3Dto : compGfList) {
				if (!sigitTDettTipo3Dto.getProgressivo().equals(progressivo)) {
					progressivo = sigitTDettTipo3Dto.getProgressivo();
					rowAllegatoIV = allegato4.addNewRowAllegatoIV();

					it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica importCve = rowAllegatoIV.addNewControlloVerificaEnergetica();
					rowAllegatoIV.setAENumSC(ConvertUtil.convertToBigInteger(sigitTDettTipo3Dto.getProgressivo()));
					importCve.setAEFlagClimatizInv(ConvertUtil.convertToBooleanAllways(sigitTDettTipo3Dto.getEFlgClimaInverno()));
					importCve.setAEFlagProduzACS(ConvertUtil.convertToBooleanAllways(sigitTDettTipo3Dto.getEFlgProduzAcs()));
					importCve.setAECombustibile(ConvertUtil.convertToString(sigitTDettTipo3Dto.getFkFluidoAlimentaz()));
					importCve.setAEFluidoVett(ConvertUtil.convertToString(sigitTDettTipo3Dto.getFkFluido()));
					importCve.setAEFlagPotComp(ConvertUtil.convertToBigInteger(sigitTDettTipo3Dto.getEFlgPotenzaCompatibile()));
					importCve.setAEFlagStatoCoiben(ConvertUtil.convertToBigInteger(sigitTDettTipo3Dto.getEFlgCoibIdonea()));
					importCve.setAEFlagDispReg(ConvertUtil.convertToBigInteger(sigitTDettTipo3Dto.getEFlgDispFunzionanti()));
					tabFumi = rowAllegatoIV.addNewTabFumi();
				}
				if(tabFumi!=null) {
					it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RowFumiDocument.RowFumi rowFumiImport = tabFumi.addNewRowFumi();
								
					rowFumiImport.setAETempEst(sigitTDettTipo3Dto.getETempExtC());
					rowFumiImport.setAETempMandPrim(sigitTDettTipo3Dto.getETempMandPrimarioC());
					rowFumiImport.setAETempRitPrim(sigitTDettTipo3Dto.getETempRitorPrimarioC());
					rowFumiImport.setAEPotenzaTerm(sigitTDettTipo3Dto.getEPotenzaTermKw());
					rowFumiImport.setAEPortataFluido(sigitTDettTipo3Dto.getEPortFluidoM3H());
					rowFumiImport.setAETempMandSecond(sigitTDettTipo3Dto.getETempMandSecondarioC());
					rowFumiImport.setAETempRitSecond(sigitTDettTipo3Dto.getETempRitSecondarioC());
				
				}
			}
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.CheckListDocument.CheckList importCheckList = mod1Import.getMODIV().getRichiesta().getDatiAllegato().addNewCheckList();
			importCheckList.setAFOsservazioni(ricercaAllegatiDto.getFOsservazioni());
			importCheckList.setAFRaccomandazioni(ricercaAllegatiDto.getFRaccomandazioni());
			importCheckList.setAFPrescrizioni(ricercaAllegatiDto.getFPrescrizioni());
			importCheckList.setAFFlagValvole(ConvertUtil.convertToBooleanAllways(sigitTRappTipo3Dto.getFFlgValvoleTermost()));
			importCheckList.setAFFlagCurvaClim(ConvertUtil.convertToBooleanAllways(sigitTRappTipo3Dto.getFFlgVerificaParam()));
			importCheckList.setAFFlagPerditaH2O(ConvertUtil.convertToBooleanAllways(sigitTRappTipo3Dto.getFFlgPerditeH2o()));
			importCheckList.setAFFlagInvolucro(ConvertUtil.convertToBooleanAllways(sigitTRappTipo3Dto.getFFlgInstallInvolucro()));
			output = XmlBeanUtils.extractByteArray(mod1Import);
		} catch (Exception e) {
			logger.error("Errore generazione XML controllo tipo 1: ", e);
			throw new SigitextException("Errore generazione XML", e);
		} finally {
			logger.debug("[SigitManager::generaXMLControlloTipo1] END");
		}
		return output;
	}

	public byte[] generaXMLControlloTipo4(SigitVRicercaAllegatiDto ricercaAllegatiDto, SigitTAllegatoDto allegatoDto) throws SigitextException {
		logger.debug("[SigitManager::generaXMLControlloTipo1] START");
		byte[] output = null;
		try {
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument mod1Import = MODVDocument.Factory.newInstance();
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiManutentoreDocument.DatiManutentore datiManutentore = mod1Import.addNewMODV().addNewRichiesta().addNewDatiManutentore();
			datiManutentore.setNumeroREA(ricercaAllegatiDto.getPgNumeroRea().toString());
			datiManutentore.setCodiceFiscale(ricercaAllegatiDto.getPgCodiceFiscale());
			datiManutentore.setSiglaREA(ricercaAllegatiDto.getPgSiglaRea());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = mod1Import.getMODV().getRichiesta().addNewDatiIntestazione();
			datiIntestazione.setAFDataControllo(ConvertUtil.convertToXmlCalendar(ricercaAllegatiDto.getDataControllo()));
			datiIntestazione.setCodiceBollino(ricercaAllegatiDto.getFkNumeroBollino().toString());
			datiIntestazione.setCodiceCatasto(ricercaAllegatiDto.getCodiceImpianto().toString());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = mod1Import.getMODV().getRichiesta().addNewDatiAllegato()
					.addNewDatiIdentificativi();
			datiIdentificativi.setAAPotenzaTermicaNomTotMax(allegatoDto.getAPotenzaTermicaNominaleMax());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = mod1Import.getMODV().getRichiesta().getDatiAllegato()
					.addNewDocumentazioneTecnica();
			documentazioneTecnica.setABFlagDichiarazConf(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgDichiarConform()));
			documentazioneTecnica.setABFlagManutGen(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgLibrettoUso()));
			documentazioneTecnica.setABFlagLibrettoComp(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgLibCompl()));
			documentazioneTecnica.setABFlagLibrettoImp(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getBFlgLibImp()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiTecnicoDocument.DatiTecnico datiTecnico = mod1Import.getMODV().getRichiesta().getDatiAllegato().addNewDatiTecnico();
			datiTecnico.setAFFlagFunzImp(ConvertUtil.convertToBooleanAllways(ricercaAllegatiDto.getFFlgPuoFunzionare()));
			datiTecnico.setAFDataIntervento(ConvertUtil.convertDateToXmlCalendar(ricercaAllegatiDto.getFInterventoEntro()));
			datiTecnico.setAFOrarioArrivo(ricercaAllegatiDto.getFOraArrivo());
			datiTecnico.setAFOrarioPartenza(ricercaAllegatiDto.getFOraPartenza());
			if (ricercaAllegatiDto.getFDenominazTecnico() != null && ricercaAllegatiDto.getFDenominazTecnico().split(" ").length == 4) {
				datiTecnico.setAFNomeTecnico(ricercaAllegatiDto.getFDenominazTecnico().split(" ")[0]);
				datiTecnico.setAFCognomeTecnico(ricercaAllegatiDto.getFDenominazTecnico().split(" ")[1]);
			} else {
				datiTecnico.setAFCognomeTecnico(ricercaAllegatiDto.getFDenominazTecnico() != null ? ricercaAllegatiDto.getFDenominazTecnico().split(" ")[0] : null);
			}
			datiTecnico.setAFFirmaTecnico(allegatoDto.getFFirmaTecnico());
			datiTecnico.setAFFirmaResp(allegatoDto.getFFirmaResponsabile());

			BigDecimal idAllegato = ricercaAllegatiDto.getIdAllegato();
			SigitTRappTipo4Dto sigitTRappTipo4Dto = getDbServiceImp().getSigitTRappTipo4Dao().findByPrimaryKey(new SigitTRappTipo4Pk(idAllegato));

			//sezione D.controllo dell'impianto
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.ControlloImpiantoDocument.ControlloImpianto importCi = mod1Import.getMODV().getRichiesta().getDatiAllegato()
					.addNewControlloImpianto();
			importCi.setADFlagLuogoIdoneo(ConvertUtil.convertToBigInteger(sigitTRappTipo4Dto.getDFlgLuogoIdoneo()));
			importCi.setADFlagDimensioni(ConvertUtil.convertToBigInteger(sigitTRappTipo4Dto.getDFlgVentilazAdeg()));
			importCi.setADFlagAperture(ConvertUtil.convertToBigInteger(sigitTRappTipo4Dto.getDFlgVentilazLibera()));
			importCi.setADFlagLineeIdonee(ConvertUtil.convertToBigInteger(sigitTRappTipo4Dto.getDFlgLineaElettIdonea()));
			importCi.setADFlagCanaleFumo(ConvertUtil.convertToBigInteger(sigitTRappTipo4Dto.getDFlgCaminoIdoneo()));
			importCi.setADFlagCapsulaInso(ConvertUtil.convertToBigInteger(sigitTRappTipo4Dto.getDFlgCapsulaIdonea()));
			importCi.setADFlagTenutaIdraulica(ConvertUtil.convertToBigInteger(sigitTRappTipo4Dto.getDFlgCircIdrIdoneo()));
			importCi.setADFlagTenutaOlio(ConvertUtil.convertToBigInteger(sigitTRappTipo4Dto.getDFlgCircOlioIdoneo()));
			importCi.setADFlagTenutaAlimentaz(ConvertUtil.convertToBigInteger(sigitTRappTipo4Dto.getDFlgCircCombIdoneo()));
			importCi.setADFlagFunzionalita(ConvertUtil.convertToBigInteger(sigitTRappTipo4Dto.getDFlgFunzScambIdonea()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod1Import.getMODV().getRichiesta().getDatiAllegato().addNewTrattamentoAcqua();
			impTa.setACFlagTrattH2ONR(ConvertUtil.convertToBooleanAllways(sigitTRappTipo4Dto.getCFlgTrattClimaNonRichiest()));

			CompFilter compFilter = new CompFilter();
			compFilter.setIdAllegato(idAllegato.intValue());

			SigitTDettTipo4Dto input = new SigitTDettTipo4Dto();
			input.setFkAllegato(idAllegato);
			List<SigitTDettTipo4Dto> compGfList = getDbServiceImp().getSigitTDettTipo4Dao().findByAllegatoCodImpianto(input);
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiAllegatoDocument.DatiAllegato.AllegatoV allegato5 = mod1Import.getMODV().getRichiesta().getDatiAllegato().addNewAllegatoV();
			RowAllegatoVDocument.RowAllegatoV rowAllegatoV = null;
			RowAllegatoVDocument.RowAllegatoV.TabFumi tabFumi = null;
			BigDecimal progressivo = BigDecimal.ZERO;
			for (SigitTDettTipo4Dto sigitTDettTipo4Dto : compGfList) {
				if (!sigitTDettTipo4Dto.getProgressivo().equals(progressivo)) {
					progressivo = sigitTDettTipo4Dto.getProgressivo();
					rowAllegatoV = allegato5.addNewRowAllegatoV();

					it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica importCve = rowAllegatoV.addNewControlloVerificaEnergetica();
					rowAllegatoV.setAENumCG(ConvertUtil.convertToBigInteger(sigitTDettTipo4Dto.getProgressivo()));
					importCve.setAEFluidoVett(ConvertUtil.convertToString(sigitTDettTipo4Dto.getFkFluido()));
					importCve.setAEPotenzaAssorbita(sigitTDettTipo4Dto.getEPotenzaAssorbCombKw());
					importCve.setAEPotenzaTermByPass(sigitTDettTipo4Dto.getEPotenzaTermBypassKw());
					tabFumi = rowAllegatoV.addNewTabFumi();
				}

				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RowFumiDocument.RowFumi rowFumiImport = tabFumi.addNewRowFumi();
				rowFumiImport.setAETempAriaCombur(sigitTDettTipo4Dto.getETempAriaC());
				rowFumiImport.setAETempAcquaIng(sigitTDettTipo4Dto.getETempH2oInC());
				rowFumiImport.setAETempAcquaUsc(sigitTDettTipo4Dto.getETempH2oOutC());
				rowFumiImport.setAEPotenzaMorsetti(sigitTDettTipo4Dto.getEPotenzaMorsettiKw());
				rowFumiImport.setAETempH2Omotore(sigitTDettTipo4Dto.getETempH2oMotoreC());
				rowFumiImport.setAETempFumiAvalle(sigitTDettTipo4Dto.getETempFumiValleC());
				rowFumiImport.setAETempFumiAmonte(sigitTDettTipo4Dto.getETempFumiMonteC());
				rowFumiImport.setAESovraFreqSoglia1(sigitTDettTipo4Dto.getL114SovrafreqSogliaHzMin());
				rowFumiImport.setAESovraFreqSoglia2(sigitTDettTipo4Dto.getL114SovrafreqSogliaHzMed());
				rowFumiImport.setAESovraFreqSoglia3(sigitTDettTipo4Dto.getL114SovrafreqSogliaHzMax());
				rowFumiImport.setAESovraFreqTempo1(sigitTDettTipo4Dto.getL114SovrafreqTempoSMin());
				rowFumiImport.setAESovraFreqTempo2(sigitTDettTipo4Dto.getL114SovrafreqTempoSMed());
				rowFumiImport.setAESovraFreqTempo3(sigitTDettTipo4Dto.getL114SovrafreqTempoSMax());
				rowFumiImport.setAESottoFreqSoglia1(sigitTDettTipo4Dto.getL114SottofreqSogliaHzMin());
				rowFumiImport.setAESottoFreqSoglia2(sigitTDettTipo4Dto.getL114SottofreqSogliaHzMed());
				rowFumiImport.setAESottoFreqSoglia3(sigitTDettTipo4Dto.getL114SottofreqSogliaHzMax());
				rowFumiImport.setAESottoFreqTempo1(sigitTDettTipo4Dto.getL114SottofreqTempoSMin());
				rowFumiImport.setAESottoFreqTempo2(sigitTDettTipo4Dto.getL114SottofreqTempoSMed());
				rowFumiImport.setAESottoFreqTempo3(sigitTDettTipo4Dto.getL114SottofreqTempoSMax());
				rowFumiImport.setAESovraTensSoglia1(sigitTDettTipo4Dto.getL114SovratensSogliaVMin());
				rowFumiImport.setAESovraTensSoglia2(sigitTDettTipo4Dto.getL114SovratensSogliaVMed());
				rowFumiImport.setAESovraTensSoglia3(sigitTDettTipo4Dto.getL114SovratensSogliaVMax());
				rowFumiImport.setAESovraTensTempo1(sigitTDettTipo4Dto.getL114SovratensTempoSMin());
				rowFumiImport.setAESovraTensTempo2(sigitTDettTipo4Dto.getL114SovratensTempoSMed());
				rowFumiImport.setAESovraTensTempo3(sigitTDettTipo4Dto.getL114SovratensTempoSMax());
				rowFumiImport.setAESottoTensSoglia1(sigitTDettTipo4Dto.getL114SottotensSogliaVMin());
				rowFumiImport.setAESottoTensSoglia2(sigitTDettTipo4Dto.getL114SottotensSogliaVMed());
				rowFumiImport.setAESottoTensSoglia3(sigitTDettTipo4Dto.getL114SottotensSogliaVMax());
				rowFumiImport.setAESottoTensTempo1(sigitTDettTipo4Dto.getL114SottotensTempoSMin());
				rowFumiImport.setAESottoTensTempo2(sigitTDettTipo4Dto.getL114SottotensTempoSMed());
				rowFumiImport.setAESottoTensTempo3(sigitTDettTipo4Dto.getL114SottotensTempoSMax());
			}
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.CheckListDocument.CheckList importCheckList = mod1Import.getMODV().getRichiesta().getDatiAllegato().addNewCheckList();
			importCheckList.setAFFlagValvole(ConvertUtil.convertToBooleanAllways(sigitTRappTipo4Dto.getFFlgAdozioneValvole()));
			importCheckList.setAFFlagIsolamento(ConvertUtil.convertToBooleanAllways(sigitTRappTipo4Dto.getFFlgIsolamentoRete()));
			importCheckList.setAFFlagSistTrattACS(ConvertUtil.convertToBooleanAllways(sigitTRappTipo4Dto.getFFlgSistemaTrattH2o()));
			importCheckList.setAFFlagSistRegolaz(ConvertUtil.convertToBooleanAllways(sigitTRappTipo4Dto.getFFlgSostSistemaRegolaz()));
			importCheckList.setAFOsservazioni(allegatoDto.getFOsservazioni());
			importCheckList.setAFRaccomandazioni(allegatoDto.getFRaccomandazioni());
			importCheckList.setAFPrescrizioni(allegatoDto.getFPrescrizioni());

			output = XmlBeanUtils.extractByteArray(mod1Import);
		} catch (Exception e) {
			logger.error("Errore generazione XML controllo tipo 1: ", e);
			throw new SigitextException("Errore generazione XML", e);
		} finally {
			logger.debug("[SigitManager::generaXMLControlloTipo1] END");
		}
		return output;
	}

	public byte[] generaRicevutaAllegato(String idAllegato) throws SigitextException {
		logger.debug("[SigitManager::generaRicevutaAllegato] START");
		byte[] output = null;
		try {
			output = documentBuilderManager.generaRicevutaAllegato(idAllegato);
		} catch (Exception e) {
			logger.error("Errore generazione ricevuta: ", e);
			throw new SigitextException("Errore generazione RICEVUTA", e);
		} finally {
			logger.debug("[SigitManager::generaRicevutaAllegato] END");
		}
		return output;
	}

	public PdfControllo recueraAllegatoRee(String idAllegato, String idImpianto, Boolean firmato) throws SigitextException {
		logger.debug("[SigitManager::recueraAllegatoReeFirmato] START");
		PdfControllo output = null;
		try {
			output = getAllegatoIndex(idImpianto, idAllegato, firmato);
		} catch (Exception e) {
			logger.error("Errore recupero ree firmato: ", e);
			throw new SigitextException("Errore recupero ree firmato", e);
		} finally {
			logger.debug("[SigitManager::recueraAllegatoReeFirmato] END");
		}
		return output;
	}

	public PdfControllo getAllegatoIndex(String idImpianto, String idAllegato, Boolean firmato) throws SigitextException {
		logger.debug("[ServiceManager::getAllegatoIndexNew] BEGIN");
		try {

			OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);

			byte[] file = null;
			String uid = null;
			String nomeFile = null;
			String mimeType = null;

			// recupero l'allegato
			SigitVRicercaAllegatiDto allegato = getDbServiceImp().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);
			if (allegato != null) {
				if (firmato && GenericUtil.isNotNullOrEmpty(allegato.getUidIndexFirmato())) {
					uid = allegato.getUidIndexFirmato();
					file = indexOpenFileByUID(uid, allegato.getNomeAllegatoFirmato(), oc);
				} else if (!firmato && GenericUtil.isNotNullOrEmpty(allegato.getUidIndex())) {
					uid = allegato.getUidIndex();
					file = indexOpenFileByUID(uid, allegato.getNomeAllegato(), oc);
				}

				if (file == null) {
					SigitTImpiantoDto impianto = getDbServiceImp().cercaImpiantoDtoById(idImpianto);

					Metadati md = new Metadati();
					md.setCodiceImpianto(ConvertUtil.convertToString(impianto.getCodiceImpianto()));
					md.setCodIstatComune(impianto.getIstatComune());
					md.setCodIstatProvincia(StringUtils.substring(impianto.getIstatComune(), 0, 3));
					md.setDataRapporto(ConvertUtil.convertToString(allegato.getDataControllo()));
					md.setIdRapporto(ConvertUtil.convertToString(allegato.getIdAllegato()));

					logger.debug("getAllegatoIndex - cerco con il nome file nel FOLDER ");
					if (firmato)
						uid = indexSearchUIDFileInFolderNew(allegato.getNomeAllegatoFirmato(), md, oc, Constants.INDEX_FOLDER_REE);
					else
						uid = indexSearchUIDFileInFolderNew(allegato.getNomeAllegato(), md, oc, Constants.INDEX_FOLDER_REE);

					if (uid != null && firmato) {
						file = indexOpenFileByUID(uid, allegato.getNomeAllegatoFirmato(), oc);
					}else if(uid != null){
						file = indexOpenFileByUID(uid, allegato.getNomeAllegato(), oc);
					}
				}
				nomeFile = firmato?allegato.getNomeAllegatoFirmato():allegato.getNomeAllegato();
				mimeType = URLConnection.guessContentTypeFromName(nomeFile);
			}
			PdfControllo documento = new PdfControllo();
			documento.setFile(file);
			documento.setName(nomeFile);
			documento.setMimeType(mimeType);
			return documento;
		} catch (Exception e) {
			logger.error("Errore getAllegatoIndexNew", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO);
		} finally {
			logger.debug("[ServiceManager::getAllegatoIndex] END");
		}
	}

	public byte[] indexOpenFileByUID(String uid, String fileName, OperationContext oc) {
		logger.debug("[ServiceManager::indexOpenFileByUID] BEGIN");
		byte[] result = null;
		try {
			result = getServiceIndex().getEcmengineDelegate().retrieveContentData(new Node(uid), indexGetContent(fileName), oc);
		} catch (Exception e) {
			logger.error("Ho ricevuto un'eccezione nel metodo indexOpenFileByUID ma proseguo nella ricerca", e);
		}
		logger.debug("[ServiceManager::indexOpenFileByUID] END");
		return result;
	}

	public String indexSearchUIDFileInFolderNew(String fileName, Metadati metadati, OperationContext oc, String cartella) {
		logger.debug("[ServiceManager::indexSearchUIDFileInFolder] BEGIN");
		String uid = null;
		try {
			logger.debug("indexSearchUIDFileInFolderNew - cerco con il nome file nella cartella: " + cartella);
			uid = indexSearchUIDFileInFolder(fileName, metadati, oc, cartella);
			if (uid == null) {
				logger.debug("indexSearchUIDFileInFolderNew - cerco con il nome file nella cartella codice_impianto: " + metadati.getCodiceImpianto());

				uid = indexSearchUIDFileInFolder(fileName, metadati, oc, null);
			}

			if (uid == null) {
				logger.debug("indexSearchUIDFileInFolderNew - cerco con il nome file nella ROOT ");
				uid = indexSearchUIDFileInAllRoot(fileName, metadati, oc);

			}
		} catch (Exception e) {
			logger.error("Ho ricevuto un'eccezione nel metodo indexSearchUIDFileInFolder ma proseguo nella ricerca", e);
		}
		logger.debug("[ServiceManager::indexSearchUIDFileInFolder] END");
		return uid;
	}

	public String indexSearchUIDFileInFolder(String fileName, Metadati metadati, OperationContext oc, String cartella) {
		logger.debug("[ServiceManager::indexSearchUIDFileInFolder] BEGIN");
		String uid = null;
		try {
			StringBuilder luceneQuery = new StringBuilder();
			luceneQuery.append("PATH:");
			luceneQuery.append("\"");
			luceneQuery.append(Constants.INDEX_ROOT_SIGIT);
			luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
			luceneQuery.append(metadati.getCodIstatProvincia());
			luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
			luceneQuery.append(metadati.getCodIstatComune());
			luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
			luceneQuery.append(metadati.getCodiceImpianto());

			if (cartella != null) {
				luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
				luceneQuery.append(cartella);
			}

			luceneQuery.append("/*");
			luceneQuery.append("\"");
			luceneQuery.append(" AND ");
			luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
			luceneQuery.append("name:\"");
			luceneQuery.append(fileName);
			luceneQuery.append("\"");

			SearchParams params = new SearchParams();
			params.setLimit(0);
			params.setLuceneQuery(luceneQuery.toString());
			SearchResponse response = getServiceIndex().getEcmengineDelegate().luceneSearch(params, oc);
			if (response != null) {
				ResultContent[] results = response.getResultContentArray();

				if (results != null && results.length > 0) {
					logger.debug("results.length " + results.length);
					uid = results[0].getUid();
				}
			}
		} catch (Exception e) {
			logger.error("Ho ricevuto un'eccezione nel metodo indexSearchUIDFileInFolder ma proseguo nella ricerca", e);
		}
		logger.debug("[ServiceManager::indexSearchUIDFileInFolder] END");
		return uid;
	}

	public String indexSearchUIDFileInAllRoot(String fileName, Metadati metadati, OperationContext oc) {
		logger.debug("[ServiceManager::indexSearchUIDFileInAllRoot] BEGIN");
		String uid = null;
		try {
			StringBuilder luceneQuery = new StringBuilder();
			luceneQuery.append(Constants.INDEX_METADATO_SUFFIX);
			luceneQuery.append("name:\"");
			luceneQuery.append(fileName);
			luceneQuery.append("\"");
			SearchParams params = new SearchParams();
			params.setLimit(0);
			params.setLuceneQuery(luceneQuery.toString());
			SearchResponse response = getServiceIndex().getEcmengineDelegate().luceneSearch(params, oc);
			if (response != null) {
				ResultContent[] results = response.getResultContentArray();
				if (results != null && results.length > 0) {
					logger.debug("results.length " + results.length);
					uid = results[0].getUid();
				}
			}
		} catch (Exception e) {
			logger.error("Ho ricevuto un'eccezione nel metodo indexSearchUIDFileInAllRoot ma proseguo nella ricerca", e);
		}
		logger.debug("[ServiceManager::indexSearchUIDFileInAllRoot] END");
		return uid;
	}

	public List<CodiceDescrizione> getIdDescriptionStelle() throws SigitextException {
		return MapDto.mapStelleDtoListToCodiceDescrizione(getDbServiceImp().findAllStelle());
	}

	public List<CodiceDescrizione> getIdDescriptionApparecchiature() throws SigitextException {
		return MapDto.mapSigitDTipo1BDtoListToCodiceDescrizione(getDbServiceImp().findSigitDTipo1BAll());
	}

	public List<CodiceDescrizione> getIdDescriptionControlloAria() throws SigitextException {
		return MapDto.mapSigitDControlloAriaListToCodiceDescrizione(getDbServiceImp().findSigitDControlloAriaAll());
	}

	public List<CodiceDescrizione> getIdDescriptionAriaComburente() throws SigitextException {
		return MapDto.mapSigitDAriaComburenteListToCodiceDescrizione(getDbServiceImp().findSigitDAriaComburenteAll());
	}

	public DettaglioAllegato getDettaglioAllegatoById(Integer idAllegato) throws SigitextException {
		DettaglioAllegato dett = null;
		SigitVRicercaAllegatiDto allegato = getDbServiceImp().cercaSigitVRicercaAllegatiByIdAllegato(ConvertUtil.convertToString(idAllegato));
		dett = MapDto.mapToDettaglioAllegato(allegato);
		return dett;
	}

	public File estraiDocumento(DettaglioAllegato dettaglioAllegato, SigitTAllegatoDto allegato, byte[] file, SigitTImpiantoDto impianto) throws IOException {
		EnvelopedContent envelope = new EnvelopedContent();
		envelope.setData(file);
		envelope.setStore(false);
		Document doc = extractDocument(envelope);
		if (doc != null) {
			File extractedFile = Files.createTempFile("file", ".pdf").toFile();
			FileUtils.writeByteArrayToFile(extractedFile, doc.getBuffer());
			return extractedFile;
		} else
			throw new FileNotFoundException();
	}

	public it.doqui.index.ecmengine.client.webservices.dto.engine.security.Document extractDocument(EnvelopedContent content) throws RemoteException {
		OperationContext moc = new OperationContext();
		moc.setUsername(Constants.INDEX_USERNAME_ADMIN);
		moc.setPassword(Constants.INDEX_PSW);
		moc.setRepository(Constants.INDEX_REPOSITORY);
		moc.setFruitore(Constants.INDEX_FRUITORE);
		moc.setNomeFisico(Constants.INDEX_UTENTE);
		try {
			return getServiceIndex().getEcmengineDelegate().extractDocumentFromEnvelope(content, moc);
		} catch (Exception e) {
			logger.error("[EXTRACT DOCUMENT] Errore occorso nell'esecuzione del metodo:" + e.getMessage(), e);
			throw e;
		}
	}

	public boolean leggiPdfReeFirmato(byte[] file, SigitTAllegatoDto allegato) throws IOException {
		PdfReader reader = null;
		reader = new PdfReader(file);
		PdfTextExtractor textExtractor = new PdfTextExtractor(reader);
		String text = textExtractor.getTextFromPage(1);
		String idAllegato = StringUtils.substringBetween(text, "id_allegato:", "#");
		logger.debug("-----------------------------id allegato" + idAllegato + "----------------------------");
		return idAllegato != null && idAllegato.equals(allegato.getIdAllegato().toString());
	}

	public void indexDeleteContentByUid(String fileUid) throws SigitextException {
		logger.debug("[ServiceManager::indexDeleteContentByUid] START");
		try {

			OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);

			getServiceIndex().getEcmengineDelegate().deleteContent(new Node(fileUid), oc);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO, e);
		}

		logger.debug("[ServiceManager::indexDeleteContentByUid] END");
	}

	public Metadati createMetadatiReeFirmato(DettaglioAllegato allegato, SigitTImpiantoDto impianto) {
		Metadati metadati = new Metadati();
		metadati.setCodiceImpianto(allegato.getCodiceImpianto());
		metadati.setIdAllegato(allegato.getIdAllegato().toString());
		metadati.setCodIstatComune(impianto.getIstatComune());
		metadati.setCodIstatProvincia(StringUtils.substring(impianto.getIstatComune(), 0, 3));
		metadati.setCodiceRea(allegato.getCodiceReaPg());
		metadati.setDataRapporto(allegato.getDataControllo());
		metadati.setIdRapporto(allegato.getIdAllegato().toString());
		return metadati;
	}
	
	public Metadati createMetadatiDocumento(SigitTImpiantoDto impiantoDto) {
		Metadati metadati = new Metadati();
		metadati.setCodiceImpianto(impiantoDto.getCodiceImpianto().toString());
		metadati.setCodIstatComune(impiantoDto.getIstatComune());
		metadati.setCodIstatProvincia(StringUtils.substring(impiantoDto.getIstatComune(), 0, 3));
		return metadati;
	}

	public String caricaFileIndex(ImportFileSuper docFilter, String folder, String nomeFileMod, Metadati metadati) throws SigitextException {
		logger.debug("[ServiceManager::caricaFileIndex] BEGIN");
		String uidIndex = null;
		try {
			uidIndex = indexUploadFileNew(nomeFileMod, new byte[0], metadati, folder, false);
			logger.debug("inserisco il file fittizio - dopo - uid: " + uidIndex);
			docFilter.setUidIndex(uidIndex);
			docFilter.setNomeFileMod(nomeFileMod);
			logger.debug("inserisco il file vero - prima");
			mtomUploadFileGeneric(docFilter);
		} catch (SigitextException e) {
			logger.error("[ServiceManager::caricaFileIndex] errore caricamento file index", e);
			throw e;
		} finally {
			logger.debug("[ServiceManager::caricaFileIndex] END");
		}
		return uidIndex;
	}

	public void mtomUploadFileGeneric(ImportFileSuper dataFile) throws SigitextException {
		logger.debug("[ServiceManager::mtomUploadFileGeneric] BEGIN");
		FileInputStream fis = null;
		try {
			MtomOperationContext moc = mtomGetOperationContext();

			MtomNode node = new MtomNode(dataFile.getUidIndex(), Constants.INDEX_PREFIX_NAME);

			fis = new FileInputStream(dataFile.getFile());
			Attachment a = new Attachment();
			a.fileName = dataFile.getNomeFileMod();
			a.fileType = dataFile.getContentType();
			a.attachmentDataHandler = new DataHandler(new InputStreamDataSource(fis, dataFile.getContentType(), dataFile.getNomeFileMod()));

			logger.debug("Prima della chiusura dell'upload ");
			node = getCxf().getEcmEngineMtomDelegateImpl().directUploadMethod(a, node, moc);

			logger.debug("Prima della chiusura del fis");

			fis.close();
			logger.debug("Dopo la chiusura del fis");
		} catch (MtomException e) {
			logger.error("Errore mtomUploadFileGeneric " + e.getMessage(), e);
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO, e);

		} catch (Exception e) {
			logger.error("Errore mtomUploadFileGeneric", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO, e);

		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					logger.error("Errore mtomUploadFileGeneric " + e.getMessage(), e);
				}
			}
		}
		logger.debug("[ServiceManager::mtomUploadFileGeneric] END");
	}

	public MtomOperationContext mtomGetOperationContext() {
		logger.debug("[ServiceManager::mtomGetOperationContext] BEGIN");
		MtomOperationContext moc = new MtomOperationContext();
		moc.setUsername(Constants.INDEX_USERNAME_ADMIN);
		moc.setPassword(Constants.INDEX_PSW);
		moc.setRepository(Constants.INDEX_REPOSITORY);
		moc.setFruitore(Constants.INDEX_FRUITORE);
		moc.setNomeFisico(Constants.INDEX_UTENTE);
		logger.debug("[ServiceManager::mtomGetOperationContext] END");
		return moc;
	}

	public DatiGFCommon cercaDatiAllegato2Common(DettaglioAllegato ispezione) throws SigitextException {
		try {
			DettaglioAllegato dettAllegato = new DettaglioAllegato();
			dettAllegato.setIdAllegato(ispezione.getIdAllegato());
			dettAllegato.setCodiceImpianto(ispezione.getCodiceImpianto());
			dettAllegato.setDataControllo(ispezione.getDataControllo());
			return getDbServiceImp().getDettaglioAllegato2Common(dettAllegato);
		} catch (SigitextException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO);
		}
	}

	public DatiGTCommon cercaDatiAllegato1Common(DettaglioAllegato ispezione) throws SigitextException {
		try {
			DettaglioAllegato dettAllegato = new DettaglioAllegato();
			dettAllegato.setIdAllegato(ispezione.getIdAllegato());
			dettAllegato.setCodiceImpianto(ispezione.getCodiceImpianto());
			dettAllegato.setDataControllo(ispezione.getDataControllo());
			return getDbServiceImp().getDettaglioAllegato1Common(dettAllegato);
		} catch (SigitextException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO);
		}
	}

	public DatiSCCommon cercaDatiAllegato3Common(DettaglioAllegato ispezione) throws SigitextException {
		try {
			DettaglioAllegato dettAllegato = new DettaglioAllegato();
			dettAllegato.setIdAllegato(ispezione.getIdAllegato());
			dettAllegato.setCodiceImpianto(ispezione.getCodiceImpianto());
			dettAllegato.setDataControllo(ispezione.getDataControllo());
			return getDbServiceImp().getDettaglioAllegato3Common(dettAllegato);
		} catch (SigitextException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO);
		}
	}

	public DatiCGCommon cercaDatiAllegato4Common(DettaglioAllegato ispezione) throws SigitextException {
		try {
			DettaglioAllegato dettAllegato = new DettaglioAllegato();
			dettAllegato.setIdAllegato(ispezione.getIdAllegato());
			dettAllegato.setCodiceImpianto(ispezione.getCodiceImpianto());
			dettAllegato.setDataControllo(ispezione.getDataControllo());
			return getDbServiceImp().getDettaglioAllegato4Common(dettAllegato);
		} catch (SigitextException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO);
		}
	}

	@Transactional
	public ResultInvioMail inviaAllegatoNow(DettaglioAllegato dettaglio, String cfUtenteLoggato, Integer idPgCat) throws SigitextException {
		logger.debug("[ServiceManager::inviaAllegatoNow] START");
		ResultInvioMail resultInvioMail = null;
		SigitTAllegatoDto allegatoDto = null;
		//SigitTImpiantoDto impiantoDto = null;
		SigitVTotImpiantoDto impiantoDto = null;
		String uid = null;
		String codiceRea = null;
		try {
			List<SigitVTotImpiantoDto> listResp = getDbServiceImp().cercaResponsabiliAttiviAllaDataByCodImpianto(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());
			if (listResp != null && !listResp.isEmpty()) {
				impiantoDto = listResp.get(0);
			}
			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(ConvertUtil.convertToBigDecimal(dettaglio.getIdAllegato()));
			//devo caricare l'oggetto Allegato dal DB perche' devo ottenere l'xml dell'allegato
			allegatoDto = getDbServiceImp().getSigitTAllegatoDao().findByPrimaryKey(pk);
			codiceRea = getCodiceRea(ConvertUtil.convertToInteger(dettaglio.getPersonaGiuridica().getIdPersonaGiuridica()));
			if (GenericUtil.isNotNullOrEmpty(idPgCat)) {
				allegatoDto.setFkPgCat(ConvertUtil.convertToBigDecimal(idPgCat));
			}
			DettaglioDocumento allegato = getReeAllegatoDettaglioDocumento(dettaglio, false);
			byte[] thePdfStatico = allegato.getFile();
			String nomeAllegato = getNomeAllegato(allegatoDto.getFkTipoDocumento(), new BigDecimal(dettaglio.getCodiceImpianto()), allegatoDto.getDataControllo(), allegatoDto.getIdAllegato());
			Metadati metadati = MapDto.mapMetadatiAllegati(impiantoDto, allegatoDto, codiceRea);
			uid = indexUploadFileNew(nomeAllegato, thePdfStatico, metadati, Constants.INDEX_FOLDER_REE, true);
			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = getDbServiceImp().cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp2(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());
			SigitTPersonaGiuridicaDto pg3Resp = null;
			if (list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty()) {
				SigitVRicerca3ResponsabileDto vTot3Responsabile = list3RespAttiviImpianto.get(0);
				pg3Resp = getDbServiceImp().cercaPersonaGiuridicaById(vTot3Responsabile.getFkPg3Resp());
			}
			// Verifico che sia abilitato l'accertamento automatico
			if (getDbServiceImp().cercaConfigValueFlg(Constants.CIT_ACCERTAMENTO_AUTOMATICO_IMP_NON_SICURO)) {
				if (!ConvertUtil.convertToBooleanAllways(allegatoDto.getFFlgPuoFunzionare())) {
					CodiceDescrizione coppiaIdAccertamentoMailPA = creaAutomatismiInvioRee(dettaglio.getCodiceImpianto(), allegatoDto);
					String emailPA = coppiaIdAccertamentoMailPA.getDescrizione();
					try {
						inviaMailAvvioAutomaticoAccertamentoRee(pg3Resp, emailPA, impiantoDto, dettaglio, coppiaIdAccertamentoMailPA.getCodice());
					}catch (NullPointerException e) {
						throw new SigitextException("impossibile iviare emal avvio automatico accertamento ree");
					}
				}
			}
			//setto i valori per fare l'update sul db per sigit_t_allegato
			allegatoDto.setDataInvio(DateUtil.getSqlCurrentDate());
			allegatoDto.setNomeAllegato(nomeAllegato);
			allegatoDto.setFkStatoRapp(new BigDecimal(Constants.ID_STATO_RAPPORTO_INVIATO));
			if (uid != null)
				allegatoDto.setUidIndex(uid);
			getDbServiceImp().getSigitTAllegatoDao().update(allegatoDto);
			String emailResponsabile = cercaEMailResponsabileAttivoAllaDataByCodImpianto(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());
			SigitTPersonaGiuridicaDto manutentore = getDbServiceImp().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(dettaglio.getPersonaGiuridica().getIdPersonaGiuridica()));
			ArrayList<Allegato> elencoAllegati = new ArrayList<>();
			Allegato allegatoREE = new Allegato();
			allegatoREE.setNomeFile(nomeAllegato);
			allegatoREE.setFile(thePdfStatico);
			allegatoREE.setContentType("application/pdf");
			elencoAllegati.add(allegatoREE);

			byte[] ricevuaAllegato = getRicevutaBuilder().generaRicevutaAllegato(ConvertUtil.convertToString(dettaglio.getIdAllegato()));
			Allegato allegatoRicevuta = new Allegato();
			allegatoRicevuta.setNomeFile("ricevutaAllegato.pdf");
			allegatoRicevuta.setFile(ricevuaAllegato);
			allegatoRicevuta.setContentType("application/pdf");
			elencoAllegati.add(allegatoRicevuta);
			resultInvioMail = sendMailInviata(allegatoDto, impiantoDto, manutentore, emailResponsabile, pg3Resp, elencoAllegati);
		} catch (SigitTAllegatoDaoException e) {
			logger.error("[ServiceManager] - inviaAllegatoNow - errore: " + e, e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} catch (ServiceException e) {
			logger.error("[ServiceManager] - inviaAllegatoNow - errore: " + e, e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO);
		} catch (SigitextException e) {
			logger.error("[ServiceManager] - inviaAllegatoNow - errore: " + e, e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}

		logger.debug("[ServiceManager::inviaAllegatoNow] END");

		return resultInvioMail;
	}

	public ResultInvioMail sendMailInviata(SigitTAllegatoDto vAllegato, SigitVTotImpiantoDto impiantoDto, SigitTPersonaGiuridicaDto manutentore, String emailResponsabile, SigitTPersonaGiuridicaDto terzoResponsabile, ArrayList<Allegato> elencoAllegati)
			throws ServiceException {
		String oggetto = null;
		StringBuffer testoHtml = new StringBuffer();

		String ubicazione = MapDto.getIndirizzoCompleto(impiantoDto.getDenominazioneComune(), impiantoDto.getIndirizzoSitad(), null, impiantoDto.getCivico(), impiantoDto.getSiglaProvincia());
		String codiceBollino = null;
		if (GenericUtil.isNotNullOrEmpty(vAllegato.getFkNumeroBollino())) {
			codiceBollino = vAllegato.getFkSiglaBollino() + "-" + vAllegato.getFkNumeroBollino();
		}

		oggetto = "CIT: avvenuta ricezione Rapporto Efficienza Energetica impianto " + impiantoDto.getCodiceImpianto();

		// Compongo la mail con formato HTML
		testoHtml.append("Avvenuta ricezione del Rapporto Efficienza Energetica dell'impianto in oggetto.<BR/><BR/>");
		testoHtml.append("Descrizione impianto<BR/>");

		testoHtml.append("Codice impianto: " + impiantoDto.getCodiceImpianto() + "<BR/>");

		testoHtml.append("Localizzazione: " + ubicazione + "<BR/><BR/>");

		testoHtml.append("Descrizione rapporto di controllo<BR/>");
		testoHtml.append("Data controllo: " + ConvertUtil.convertToString(vAllegato.getDataControllo()) + "<BR/>");
		if (GenericUtil.isNotNullOrEmpty(codiceBollino)) {
			testoHtml.append("Codice bollino: " + codiceBollino + "<BR/>");
		}
		testoHtml.append("Componenti controllate: " + vAllegato.getElencoApparecchiature() + "<BR/>");
		testoHtml.append("Data invio rapporto: " + ConvertUtil.convertToString(vAllegato.getDataInvio()) + "<BR/><BR/><BR/>");

		testoHtml.append("Regione Piemonte<BR/><BR/>");
		testoHtml.append("Per qualsiasi approfondimento utilizzare il seguente link<BR/>");
		testoHtml.append("https://energia-cit.regione.piemonte.it/citpwa");

		ArrayList<String> destinatariSingoli = new ArrayList<>();
		if (GenericUtil.isNotNullOrEmpty(manutentore.getEmail())) {

			logger.debug("Stampo la mail del manutentore: " + manutentore.getEmail());
			destinatariSingoli.add(manutentore.getEmail());
		}

		if (GenericUtil.isNotNullOrEmpty(emailResponsabile)) {
			logger.debug("Stampo la mail del responsabile: " + emailResponsabile);

			destinatariSingoli.add(emailResponsabile);
		}

		if (terzoResponsabile != null && GenericUtil.isNotNullOrEmpty(terzoResponsabile.getEmail())) {
			destinatariSingoli.add(terzoResponsabile.getEmail());
		}

		return sendMail(destinatariSingoli, null, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()), elencoAllegati);
	}

	public String cercaEMailResponsabileAttivoAllaDataByCodImpianto(String codImpianto, String dataRapporto) throws SigitextException {
		logger.debug("[SigitMgr::cercaEMailResponsabileAttivoAllaDataByCodImpianto] BEGIN");
		String emailResponsabile = null;
		try {

			// Cerco il responsabile alla data controllo, mi serve per l'indirizzo mail ira' nel caso non ci sia il 3Responsabile
			List<SigitVTotImpiantoDto> listResp = getDbServiceImp().cercaResponsabiliAttiviAllaDataByCodImpianto(codImpianto, dataRapporto);
			if (listResp != null && !listResp.isEmpty()) {

				SigitVTotImpiantoDto impiantoResp = listResp.get(0);

				if (impiantoResp.getPfPg().equals(Constants.LABEL_PF)) {
					PersonaFisica pfResp = getDbServiceImp().cercaPersonaFisicaById(impiantoResp.getIdPersonaFisica().intValue());

					if (pfResp != null && GenericUtil.isNotNullOrEmpty(pfResp.getEmail()))
						emailResponsabile = pfResp.getEmail();
				} else {
					SigitTPersonaGiuridicaDto pgResp = getDbServiceImp().cercaPersonaGiuridicaById(impiantoResp.getIdPersonaFisica());

					if (pgResp != null && GenericUtil.isNotNullOrEmpty(pgResp.getEmail()))
						emailResponsabile = pgResp.getEmail();
				}
			}

		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO);
		} finally {
			logger.debug("[SigitMgr::cercaEMailResponsabileAttivoAllaDataByCodImpianto] END");
		}
		return emailResponsabile;
	}

	private CodiceDescrizione creaAutomatismiInvioRee(String codiceImpianto, SigitTAllegatoDto allegatoDto) throws SigitextException {
		return creaAutomatismiAccertamento(codiceImpianto, TipoVerificaEnum.REE.getIdDb(), allegatoDto);
	}

	private CodiceDescrizione creaAutomatismiAccertamento(String codiceImpianto, int idTipoVerifica, SigitTAllegatoDto allegatoDto) throws SigitextException {
		logger.debug("[ServiceManager::creaAutomatismiAccertamento] BEGIN");

		try {
			UtenteLoggatoModel utenteAuto = new UtenteLoggatoModel();
			utenteAuto.setCodiceFiscale("INSERTAUTOMATICO");

			Verifica verificaAuto = new Verifica();
			verificaAuto.setTipoVerifica(idTipoVerifica);
			verificaAuto.setCodiceImpianto(codiceImpianto);

			if (allegatoDto != null) {
				// Nel caso di "Avvio automatico accertamento" per invio REE
				verificaAuto.setIdAllegato(ConvertUtil.convertToString(allegatoDto.getIdAllegato()));
				verificaAuto.setSiglaBollino(allegatoDto.getFkSiglaBollino());
				verificaAuto.setNumeroBollino(ConvertUtil.convertToString(allegatoDto.getFkNumeroBollino()));
			}

			verificaAuto.setDataCaricamento(DateUtil.getDataCorrenteFormat());
			String idVerifica = salvaVerifica(verificaAuto, utenteAuto);
			logger.debug("[ServiceManager::creaAutomatismiAccertamento] salvataggio verifica");

			Azione azioneAuto = new Azione();
			azioneAuto.setFkAzione(ConvertUtil.convertToInteger(idVerifica));

			if (idTipoVerifica == TipoVerificaEnum.DECADENZA3R.getIdDb()) {
				azioneAuto.setDescrizione("Creazione automatica di verifica per decadenza 3 RESP");
			} else if (idTipoVerifica == TipoVerificaEnum.REE.getIdDb()) {
				azioneAuto.setDescrizione("Creazione automatica di verifica su impianto che non puo' funzionare ai fini della sicurezza");
			}

			inserisciAzioneEDocumento(Constants.ID_TIPO_AZIONE_VERIFICA, azioneAuto, null, utenteAuto);
			logger.debug("[ServiceManager::creaAutomatismiAccertamento] salvataggio azione");

			SigitVRicercaImpiantiDto impiantoEntity = getDbServiceImp().cercaImpiantoByCodImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
			logger.debug("[ServiceManager::creaAutomatismiAccertamento] ricerca impianto");

			Accertamento accertamentoAuto = new Accertamento();
			accertamentoAuto.setIdVerifica(idVerifica);
			accertamentoAuto.setIdStatoAccertamento(Constants.ID_STATO_ACCERTAMENTO_IN_CORSO);
			accertamentoAuto.setCodiceImpianto(codiceImpianto);

			accertamentoAuto.setDataCreazione(DateUtil.getDataCorrenteFormat());
			if (impiantoEntity != null) {
				accertamentoAuto.setSiglaProv(impiantoEntity.getSiglaProvincia());
				accertamentoAuto.setCodIstatProv(GenericUtil.getCodIstatProvByCodIstatComune(impiantoEntity.getIstatComune()));
			}
			accertamentoAuto.setIdTipoAnomalia(ConvertUtil.convertToString(Constants.DATO_NON_DISPONIBILE));

			String identificativoAccertamento = salvaAccertamento(accertamentoAuto, null, null);
			logger.debug("[ServiceManager::creaAutomatismiAccertamento] salvataggio accertamento");

			if (idTipoVerifica == TipoVerificaEnum.DECADENZA3R.getIdDb()) {
				getDbServiceImp().aggiornaImpiantoSblocca3R(codiceImpianto, utenteAuto.getCodiceFiscale(), true);
				logger.debug("[ServiceManager::creaAutomatismiAccertamento] salvataggio impianto");
			}
			
			String indirizzoMail = "indirizzo impianto non trovato";
			if(impiantoEntity!=null) {
				indirizzoMail = getDbServiceImp().cercaIndirizzoMailAbilitazioneValidatore(GenericUtil.getCodIstatProvByCodIstatComune(impiantoEntity.getIstatComune()), Constants.ID_RUOLO_PA_VALIDATORE);
			}
			logger.debug("[ServiceManager::creaAutomatismiAccertamento] manca invio mail");

			CodiceDescrizione risultato = new CodiceDescrizione();
			risultato.setCodice(identificativoAccertamento);
			risultato.setDescrizione(indirizzoMail);

			return risultato;

		} catch (SigitextException e) {
			throw new SigitextException(e.getMessage() == null ? Messages.ERROR_RECUPERO_DB : e.getMessage());
		} finally {
			logger.debug("[ServiceManager::creaAutomatismiAccertamento] END");
		}
	}

	private ResultInvioMail inviaMailAvvioAutomaticoAccertamentoRee(SigitTPersonaGiuridicaDto terzoResponsabile, String destinatario, SigitVTotImpiantoDto impianto, DettaglioAllegato dettaglio, String idAccertamento)
			throws SigitextException {
		logger.debug("ServiceManager:::[inviaMailAvvioAutomaticoAccertamentoRee] - START");

		logger.debug("desctinatario: " + destinatario);
		try {
			String oggetto = "CIT - Creato ACCERTAMENTO-" + idAccertamento + " sull'impianto " + impianto.getCodiceImpianto() + " che non puo' funzionare ai fini della sicurezza";

			StringBuilder testoHtml = new StringBuilder();

			logger.debug("numero rea: " + impianto.getNumeroRea());
			String localizzazione = impianto.getIndirizzoSitad() + " " + impianto.getCivico() + ", " + impianto.getDenominazioneComune() + " (" + impianto.getDenominazioneProvincia();

			testoHtml.append("Sul REE con data controllo ").append(dettaglio.getDataControllo()).append("</br>");
			testoHtml.append("e' stato dichiarato che l'impianto ").append(impianto.getCodiceImpianto()).append(" non puo' funzionare ai fini della sicurezza.</br></br>");

			testoHtml.append("<b>Descrizione impianto</b></br>");
			testoHtml.append("Codice impianto: ").append(impianto.getCodiceImpianto()).append("</br>");
			testoHtml.append("Localizzazione:  ").append(localizzazione).append(")</br></br>");

			testoHtml.append("<b>Responsabile attuale</b></br>");

			String denominazione = impianto.getDenominazione();

			if (impianto.getPfPg().equalsIgnoreCase(Constants.LABEL_PF)) {
				denominazione += " " + impianto.getNome();
			}

			testoHtml.append("Denominazione: ").append(denominazione).append("</br>");
			testoHtml.append("Titolo responsabililita': ").append(impianto.getDesRuolo()).append("</br></br>");

			if (terzoResponsabile != null) {
				testoHtml.append("<b>Terzo responsabile</b></br>");
				testoHtml.append("Denominazione: ").append(terzoResponsabile.getDenominazione()).append("</br>");
				testoHtml.append("Codice REA: ").append(ConvertUtil.getStringByConcat(" ", terzoResponsabile.getSiglaRea(), ConvertUtil.convertToString(terzoResponsabile.getNumeroRea())))
						.append("</br></br>");
			}

			testoHtml.append("N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa email.");

			if (logger.isDebugEnabled())
				logger.debug("TESTO EMAIL: \n" + testoHtml);

			return sendMail(destinatario, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		} catch (Exception e) {
			logger.error("Errore invio email revoca terzo responsabile", e);
			throw new SigitextException(e.getMessage());
		}
	}

	public ResultInvioMail sendMail(String destinatario, String oggetto, String testoHtml, String testoTxt) throws ServiceException {
		ArrayList<String> destinatariSingoli = new ArrayList<>();
		destinatariSingoli.add(destinatario);
		return sendMail(destinatariSingoli, null, oggetto, testoHtml, testoTxt);
	}

	public ResultInvioMail sendMail(ArrayList<String> destinatariSingoli, ArrayList<String> destinatari, String oggetto, String testoHtml, String testoTxt) throws ServiceException {
		return sendMail(destinatariSingoli, destinatari, oggetto, testoHtml, testoTxt, null);
	}

	public ResultInvioMail sendMail(ArrayList<String> destinatariSingoli, ArrayList<String> destinatari, String oggetto, String testoHtml, String testoTxt, ArrayList<Allegato> elencoAllegati)
			throws ServiceException {
		MailSender sender = new MailSender();
		Mail email = new Mail();
		ResultInvioMail resultInvioMail = new ResultInvioMail();
		try {

			email.setHost(getProperties().getProperty(Constants.MAIL_HOST));
			email.setPort(getProperties().getProperty(Constants.MAIL_PORT));

			email.setIdEmail(getProperties().getProperty(Constants.MAIL_USER));
			email.setPassword(getProperties().getProperty(Constants.MAIL_PWD));

			email.setMittente(getDbServiceImp().cercaConfigValueCarattere(Constants.WEB_MAIL_IND_MITT));

			email.setOggetto(oggetto);
			email.setHtml(testoHtml);
			email.setTesto(testoTxt);

			if (elencoAllegati != null && !elencoAllegati.isEmpty()) {
				email.setElencoAllegati(elencoAllegati);
			}

			if (destinatariSingoli != null && !destinatariSingoli.isEmpty()) {
				for (String destinatario : destinatariSingoli) {
					// Destinatario
					email.setDestinatario(destinatario);
					logger.info("destinatario singolo:");
					logger.info(destinatario);
					try {
						sender.sendMail(email);
						resultInvioMail.addDestinatarioOK(destinatario);
					} catch (Exception e) {
						logger.error(e);
						resultInvioMail.addDestinatarioKO(destinatario);
					}

				}
			}
			if (destinatari != null && !destinatari.isEmpty()) {

				email.setDestinatari(destinatari);

				// Formatto gli indirizzi mail
				String destElenco = destinatari.toString();
				String destElencoForm = destElenco.substring(1, destElenco.length() - 1);

				//ArrayList<String> destinatariSingoli = new ArrayList<String>();
				try {
					sender.sendMail(email);
					resultInvioMail.addDestinatarioOK(destElencoForm);
				} catch (Exception e) {
					logger.error(e);
					resultInvioMail.addDestinatarioKO(destElencoForm);
				}
			}

		} catch (Exception e) {
			logger.error("Errore send mail: " + e.getMessage(), e);
			throw new ServiceException(Messages.ERROR_RECUPERO_SERVIZIO);
		}

		return resultInvioMail;

	}

	public String salvaVerifica(Verifica verifica, UtenteLoggatoModel utente) throws SigitextException {
		logger.debug("[ServiceManager::salvaVerifica] BEGIN");
		String idVerifica = null;
		try {
			SigitTVerificaPk pk = getDbVerificaMgr().salvaVerifica(MapDto.mapToSigitTVerificaDto(verifica, utente));
			verifica.setIdentificativo(ConvertUtil.convertToString(pk.getIdVerifica()));
			idVerifica = verifica.getIdentificativo();
		} catch (SigitextException e) {
			throw new SigitextException(e.getMessage() == null ? Messages.ERROR_RECUPERO_DB : e.getMessage());
		} finally {
			logger.debug("[ServiceManager::salvaVerifica] END");
		}
		return idVerifica;
	}

	public String getCodiceRea(Integer idPersonaGiuridica) throws SigitextException {
		logger.debug("[ServiceManager::getCodiceRea] BEGIN");
		String value = null;
		try {
			if (idPersonaGiuridica != null) {
				SigitTPersonaGiuridicaPk pk = new SigitTPersonaGiuridicaPk();
				pk.setIdPersonaGiuridica(ConvertUtil.convertToBigDecimal(idPersonaGiuridica));
				SigitTPersonaGiuridicaDto pg = getDbServiceImp().getSigitTPersonaGiuridicaDao().findByPrimaryKey(pk);
				if (GenericUtil.isNotNullOrEmpty(pg.getSiglaRea()) && GenericUtil.isNotNullOrEmpty(pg.getNumeroRea())) {
					value = pg.getSiglaRea() + "-" + pg.getNumeroRea();
				}
			}
			logger.debug("[ServiceManager::getCodiceRea] FRAAAAAAAAAAAAAAA CODICE REA: " + value);
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		}
		logger.debug("[ServiceManager::getCodiceRea] END");
		return value;
	}

	public DettaglioDocumento getReeAllegatoDettaglioDocumento(DettaglioAllegato dettaglio, boolean isBozza) {
		DettaglioDocumento allegato = null;
		if (dettaglio.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_1)) {
			allegato = getReeBuilder().generaReeGt(dettaglio, false, isBozza);
		} else if (dettaglio.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_1B)) {
			allegato = getReeBuilder().generaReeGtB(dettaglio, false, isBozza);
		} else if (dettaglio.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_2)) {
			allegato = getReeBuilder().generaReeGf(dettaglio, false, isBozza);
		} else if (dettaglio.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_3)) {
			allegato = getReeBuilder().generaReeSc(dettaglio, false, isBozza);
		} else if (dettaglio.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_4)) {
			allegato = getReeBuilder().generaReeCg(dettaglio, false, isBozza);
		}

		return allegato;
	}

	private String getNomeAllegato(BigDecimal idTipoAllegato, BigDecimal codiceImpianto, java.sql.Date dataControllo, BigDecimal pkAllegato) {
		StringBuilder nome = new StringBuilder();

		if (Constants.ALLEGATO_TIPO_1.equalsIgnoreCase("" + idTipoAllegato)) {
			nome.append(Constants.DESC_ALLEGATO_TIPO_1);
		} else if (Constants.ALLEGATO_TIPO_2.equalsIgnoreCase("" + idTipoAllegato)) {
			nome.append(Constants.DESC_ALLEGATO_TIPO_2);
		} else if (Constants.ALLEGATO_TIPO_3.equalsIgnoreCase("" + idTipoAllegato)) {
			nome.append(Constants.DESC_ALLEGATO_TIPO_3);
		} else if (Constants.ALLEGATO_TIPO_4.equalsIgnoreCase("" + idTipoAllegato)) {
			nome.append(Constants.DESC_ALLEGATO_TIPO_4);
		} else if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(ConvertUtil.convertToString(idTipoAllegato))
				|| Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equals(ConvertUtil.convertToString(idTipoAllegato))) {
			nome.append(Constants.DESC_ALLEGATO_RAPPROVA);
		}
		nome.append("_");
		nome.append(codiceImpianto);
		nome.append("_");
		nome.append(ConvertUtil.convertToString(dataControllo, ConvertUtil.FORMAT_DATE_UNDERSCORE));
		nome.append("_");
		nome.append(pkAllegato);
		nome.append(".pdf");
		return nome.toString();
	}

	protected Properties getProperties() {
		logger.debug("[ServiceManager::getProperties] BEGIN");
		InputStream is = getClass().getResourceAsStream(PROPERTIES_RESOURCE);
		if (is != null) {
			try {
				Properties properties = new Properties();
				properties.load(is);
				return properties;
			} catch (Exception e) {
				logger.error("[ServiceManager::getProperties] errore nella parsificazione della configurazione delle PROPERTIES:" + e, e);
				throw new IllegalArgumentException("errore nella parsificazione della configurazione delle PROPERTIES");
			}
		} else {
			logger.error("[ServiceManager::getProperties] configurazione delle PROPERTIES non trovata");
		}
		throw new IllegalArgumentException("configurazione delle PROPERTIES non trovata");
	}

	@Transactional
	public void inserisciAzioneEDocumento(Integer idTipoAzioneVerifica, Azione azione, DocumentoAzioneDto docFilter, UtenteLoggatoModel utente) throws SigitextException {
		logger.debug("[SigitMgr::inserisciDocumento] START");

		try {

			//idTipoAzioneVerifica = checkTipoAzioneVerifica(idTipoAzioneVerifica);

			String prefisso = null;
			if (Constants.ID_TIPO_AZIONE_VERIFICA == idTipoAzioneVerifica) {
				prefisso = "VERIFICA";
			} else if (Constants.ID_TIPO_AZIONE_ACCERTAMENTO == idTipoAzioneVerifica) {
				prefisso = "ACCERTAMENTO";
			} else if (Constants.ID_TIPO_AZIONE_ISPEZIONE == idTipoAzioneVerifica) {
				prefisso = "ISPEZIONE";
			} else if (Constants.ID_TIPO_AZIONE_SANZIONE == idTipoAzioneVerifica) {
				prefisso = "SANZIONE";
			}

			//PRIMA VIENE FATTO L'INSERIMENTO DELL'AZIONE
			SigitTAzioneDto dtoDaPersistere = MapDto.mapToSigitTAzioneDto(idTipoAzioneVerifica, azione);
			if (dtoDaPersistere != null && dtoDaPersistere.getIdAzione() == null) {
				dtoDaPersistere.setCfUtenteAzione(utente.getCodiceFiscale());
				dtoDaPersistere.setDenomUtenteAzione(utente.getDenominazione());
				dtoDaPersistere.setDtAzione(DateUtil.getSqlCurrentDate());
			}
			SigitTAzionePk pk = getDbAzioneMgr().inserisciOModificaAzione(dtoDaPersistere);

			if (docFilter != null) {
				SigitTDocAzioneDto docDto = DocumentoAzioneDto.mapToSigitTDocAzioneDto(pk.getIdAzione(), docFilter, utente.getCodiceFiscale());

				getDbAzioneMgr().inserisciDocAzione(docDto);

				logger.debug("Chiave del doc: " + docDto.getIdDocAzione());

				String nomeFileMod = "DocAzione_" + prefisso + "_" + docDto.getIdDocAzione() + "_" + docFilter.getNomeFile();

				// Inserisco il file fittizio
				logger.debug("inserisco il file fittizio - prima");

				Metadati metadati = new Metadati();
				//	        	metadati.setCodiceImpianto(docFilter.getCodImpianto());
				//	        	metadati.setCodIstatProvincia(StringUtils.substring(ubicazione.getIstatComune(), 0, 3));
				//	        	metadati.setCodIstatComune(ubicazione.getIstatComune());

				final String uidIndex = indexUploadFileNew(nomeFileMod, new byte[0], metadati, Constants.INDEX_FOLDER_DOC, false);

				logger.debug("inserisco il file fittizio - dopo - uid: " + uidIndex);

				docDto.setNomeDoc(nomeFileMod);
				docDto.setUidIndex(uidIndex);

				docFilter.setUidIndex(uidIndex);
				docFilter.setNomeFileMod(nomeFileMod);

				// Inserisco il file vero
				logger.debug("inserisco il file vero - prima");

				mtomUploadFileGeneric(docFilter);

				logger.debug("inserisco il file vero - dopo");

				logger.debug("salvo l'operazione sul DB - prima");

				getDbAzioneMgr().aggiornaTDocAzione(docDto);

				logger.debug("salvo l'operazione sul DB - dopo");
			}

		} catch (SigitextException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO);

		}
		logger.debug("[SigitMgr::inviaAllegato] END");
	}

	@Transactional
	public String salvaAccertamento(Accertamento accertamento, Map<String, String> mappaTipoAnomalieVerifica, UtenteLoggatoModel utente) throws SigitextException {
		logger.debug("[SigitMgr::salvaAccertamento] BEGIN");
		String idAccertamento = null;
		try {
			SigitTAccertamentoDto dto = null;
			if (GenericUtil.isNotNullOrEmpty(accertamento.getIdentificativo())) {
				dto = getDbVerificaMgr().getAccertamentoById(ConvertUtil.convertToInteger(accertamento.getIdentificativo()));

				if (accertamento.getIdTipoAnomalia() != null && ConvertUtil.convertToBigInteger(accertamento.getIdTipoAnomalia()).intValue() != dto.getFkTipoAnomalia()) {
					StringBuilder sbDescr = new StringBuilder("Variazione Tipo anomalia ");

					if (mappaTipoAnomalieVerifica != null) {
						if (GenericUtil.isNotNullOrEmpty(dto.getFkTipoAnomalia()) && dto.getFkTipoAnomalia() != Constants.DATO_NON_DISPONIBILE) {
							sbDescr.append(" da ").append(mappaTipoAnomalieVerifica.get(ConvertUtil.convertToString(dto.getFkTipoAnomalia())));
						}

						sbDescr.append(" a ").append(mappaTipoAnomalieVerifica.get(accertamento.getIdTipoAnomalia()));
					}

					getDbAzioneMgr().inserisciAzioneSimply(sbDescr.toString(), Constants.ID_TIPO_AZIONE_ACCERTAMENTO, utente, ConvertUtil.convertToInteger(accertamento.getIdentificativo()));

				}
			} else {
				dto = new SigitTAccertamentoDto();
			}
			SigitTAccertamentoDto accertamentoDto = MapDto.mapToSigitTAccertamentoDto(accertamento, dto, utente);
			if (accertamentoDto.getSiglaProvCompetenza() == null && accertamentoDto.getIstatProvCompetenza() != null) {
					Provincia provincia = getProvinciaDaCodiceIstatOrSigla(accertamentoDto.getIstatProvCompetenza());
					String siglaProv = provincia.getSigla().toUpperCase();
					accertamentoDto.setSiglaProvCompetenza(siglaProv);
			}			

			SigitTAccertamentoPk pk = getDbVerificaMgr().salvaAccertamento(accertamentoDto);
			accertamento.setIdentificativo(ConvertUtil.convertToString(pk.getIdAccertamento()));
			idAccertamento = accertamento.getIdentificativo();
		} catch (SigitextException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new SigitextException(e.getMessage() == null ? Messages.ERROR_RECUPERO_DB : e.getMessage());
		} catch (ServiceException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		} finally {
			logger.debug("[SigitMgr::salvaAccertamento] END");
		}
		return idAccertamento;
	}

	public String getMsgInvioRee(DettaglioAllegato dettaglioAllegato, SigitVRicercaAllegatiDto allegatoDto, ResultInvioMail resultInvioMail) throws ValidationManagerException {
		String msg = Messages.INFO_ALLEGATO_INVIATO_CORRETTAMENTE;

		if (getValidationManager().isImpiantoSenzaValvoleTermostatiche(dettaglioAllegato.getDataControllo(), allegatoDto.getCodiceImpianto(), false)) {
			msg += Messages.INFO_ALLEGATO_INVIATO_IMP_NON_VALVOLE;
		}

		if (!ConvertUtil.convertToBooleanAllways(allegatoDto.getFFlgPuoFunzionare())) {
			msg += Messages.INFO_ALLEGATO_INVIATO_NON_SICURO;
		}

		msg = GenericUtil.getMsgFormatterHtml(resultInvioMail, msg);
		return msg;
	}

	public Provincia getProvinciaDaCodiceIstatOrSigla(String codiceIstatProv) throws ServiceException {
		logger.debug("[ServiziMgr::getListaSiglaProvincePiemonteManipolata] BEGIN");

		Provincia provincia = null;

		try {
			provincia = getProvinciaByCodIstatOrSigla(codiceIstatProv);
		} catch (Exception e) {
			throw new ServiceException(Messages.ERROR_RECUPERO_SERVIZIO);
		} finally {
			logger.debug("[ServiziMgr::getListaSiglaProvincePiemonteManipolata] END");
		}
		return provincia;
	}

	private Provincia getProvinciaByCodIstatOrSigla(String codiceIstatProv) throws ServiceException {
		
		logger.info("getProvinciaByCodIstatOrSigla - codice: " + codiceIstatProv);
		
		Provincia provincia = null;
		Provincia[] provRegione;
		try {
			if (codiceIstatProv.length() == 3) {
				// Ricerca per codice istat
				logger.info("CALL cercaProvinciaPerCodiceIstat START");
				provincia = getSvista().cercaProvinciaPerCodiceIstat(codiceIstatProv);				
				logger.info("CALL cercaProvinciaPerCodiceIstat END");
				return provincia;
			} else if (codiceIstatProv.length() == 2) {
				// ricerca per sigla
				logger.info("CALL cercaTutteLeProvince START");
				provRegione = getSvista().cercaTutteLeProvince();
				logger.info("CALL cercaTutteLeProvince END");
				for (Provincia provTmp : provRegione) {
					if (provTmp.getSigla() != null && !provTmp.getSigla().isEmpty() 
							&& provTmp.getSigla().equals(codiceIstatProv))
						return provTmp;
				}
			} else {
				throw new ServiceException("getProvinciaByCodIstatOrSigla - ERROR: codice istat o sigla (" + codiceIstatProv + ") non valide.");
			}
		} catch (RemoteException e) {
			throw new ServiceException(Messages.ERROR_RECUPERO_SERVIZIO, e);
		}
		throw new ServiceException("getProvinciaByCodIstatOrSigla - ERROR: codice istat o sigla (" + codiceIstatProv + ") non valide.");
	}

	@Transactional
	public void inviaAllegatoLibretto(String codiceImpianto, Integer idPersonaGiuridica, int idMotivoConsolidamento, String cfUtenteLoggato, boolean isIspezioni) throws SigitextException {
		logger.debug("[SigitMgr::inviaAllegatoLibretto] START");
		try {
			String codiceRea = null;
			if (isIspezioni) {
				codiceRea = this.getCodiceRea(Constants.ID_PG_RUOLO_ISPETTORE);
			} else {
				if (idPersonaGiuridica != null) {
					SigitTPersonaGiuridicaDto manutentore = getDbServiceImp().cercaTPersonaGiuridicaById(idPersonaGiuridica);
					codiceRea = MapDto.getCodiceRea(manutentore.getSiglaRea(), ConvertUtil.convertToInteger(manutentore.getNumeroRea()));
				}
			}
			SigitTLibrettoDto recordLibretto = getDbServiceImp().cercaSigitTLibrettoConsolidatoByCodImpianto(codiceImpianto);
			recordLibretto.setCfRedattore(cfUtenteLoggato);
			recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
			recordLibretto.setUtenteUltMod(cfUtenteLoggato);
			recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
			getDbServiceImp().inserisciLibretto(recordLibretto);
			SigitTImpiantoDto sigitTImpiantoDto = getDbServiceImp().cercaImpiantoDtoById(codiceImpianto);
			logger.debug("[SigitMgr::inviaAllegatoLibretto] END --> INSERT SU sigit_t_libretto");
			//adesso eseguo i punti 4, 5, 6 dell'algoritmo A002_7 riferito al libretto
			this.creaPdfEConsolidaLibretto(ConvertUtil.convertToString(idPersonaGiuridica), cfUtenteLoggato, sigitTImpiantoDto, codiceRea, recordLibretto, idMotivoConsolidamento);
			logger.debug("FRAAAAAAAAAAAAAAAAAAAA 12 STEP  ");
		} catch (SigitextException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
		logger.debug("[SigitMgr::inviaAllegatoLibretto] END");
	}

	public void creaPdfEConsolidaLibretto(String idPersonaGiuridicaLoggata, String cfUtente, SigitTImpiantoDto impianto, String codiceRea, SigitTLibrettoDto libretto, int motivoConsolidamento)
			throws SigitextException {
		boolean isRespAssente = false;
		try {
			String codiceImpianto = impianto.getCodiceImpianto().toString();
			String idLibretto = libretto.getIdLibretto().toString();
			// Controllo il responsabile
			SigitVTotImpiantoDto respAttivo = getDbServiceImp().cercaResponsabileAttivoByCodImpianto(Integer.parseInt(codiceImpianto));
			if (respAttivo == null) {
				isRespAssente = true;
				throw new SigitextException(Messages.ERROR_RESPONSABILE_ASSENTE);

			}
			DettaglioDocumentoMultiplo documento = getLibrettoCompletoNow(codiceImpianto, true);
			byte[] thePdf = documento.getDocumentoPdf().getFile();
			String nome = getNomeFileLibretto(ConvertUtil.convertToInteger(codiceImpianto), ConvertUtil.convertToBigDecimal(idLibretto));
			logger.debug("nome file libretto: " + nome);
			Metadati metadati = MapDto.mapMetadati(impianto, libretto, codiceRea);
			String uidIndex = indexUploadFileNew(nome.toString(), thePdf, metadati, Constants.INDEX_FOLDER_LIBRETTI, true);
			logger.debug("UID index: " + uidIndex);
			//storicizzare altri libretti consolidati
			libretto.setUtenteUltMod(cfUtente);
			getDbServiceImp().storicizzaLibretti(libretto);
			logger.debug("libretti storicizzati");
			//consolidare libretto in bozza
			libretto.setFkMotivoConsolid(new BigDecimal(motivoConsolidamento));
			libretto.setFileIndex(nome);
			libretto.setUidIndex(uidIndex);
			getDbServiceImp().consolidaLibretto(libretto);
			logger.debug("Aggiornamento xml su DB");
			if (logger.isDebugEnabled()) {
				logger.debug("libretto.getIdLibretto(): " + libretto.getIdLibretto());
				logger.debug("documento: " + documento);
				logger.debug("documento.getDocumentoXml(): " + documento.getDocumentoXml());
				logger.debug("documento.getDocumentoXml().getFile(): " + Arrays.toString(documento.getDocumentoXml().getFile()));
			}
			getDbServiceImp().updateTxtLibretto(libretto.getIdLibretto(), XmlBeanUtils.readByteArray(documento.getDocumentoXml().getFile()));
			logger.debug("libretto consolidato");
		} catch (Exception e) {
			logger.error("Errore in consolidamento:", e);

			if (isRespAssente) {
				throw new SigitextException(Messages.ERROR_IMPOSSIBILE_CONSOLIDARE + ": " + e.getMessage());
			} else {
				throw new SigitextException(Messages.ERROR_IMPOSSIBILE_CONSOLIDARE + ": contattare l'amministrattore del sistema");
			}
		}
	}

	public DettaglioDocumentoMultiplo getLibrettoCompletoNow(String idImpianto, boolean isConsolidato) throws ServiceException {
		logger.debug("[ServiziMgr::getLibrettoCompletoNow] BEGIN");
		DettaglioDocumentoMultiplo result = new DettaglioDocumentoMultiplo();
		try {
			Libretto libretto = getLibretto(ConvertUtil.convertToInteger(idImpianto), isConsolidato);
			DettaglioDocumento doc = new DettaglioDocumento();
			if (libretto.getLibrettoPdf() != null) {
				doc.setFile(libretto.getLibrettoPdf().getDoc());
				doc.setNomeDocumento(libretto.getLibrettoPdf().getNome());
			}
			result.setDocumentoPdf(doc);
			doc = new DettaglioDocumento();
			doc.setFile(libretto.getLibrettoXml());
			result.setDocumentoXml(doc);
		} catch (Exception e) {
			throw new ServiceException(Messages.ERROR_RECUPERO_SERVIZIO);
		}
		logger.debug("[ServiziMgr::getLibrettoCompletoNow] END");
		return result;
	}

	public void consolidaLibretto(Integer codiceImpianto, Integer idPersonaGiuridica, String descrizioneRuolo, String codiceRea, String cfUtenteMod) throws SigitextException, ServiceException {
		try {
			getValidationManager().verificaLibrettoWeb(ConvertUtil.convertToString(codiceImpianto));
			int motivoConsolidamento = Constants.ID_MOTIVO_CONSOLIDAMENTO_ESP_UTENTE;
			if (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA) || descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE)) {
				motivoConsolidamento = Constants.ID_MOTIVO_CONSOLIDAMENTO_COMP_SCHEDA_1_14;
			}
			if(descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_NOMINA)){
				motivoConsolidamento = Constants.ID_MOTIVO_CONSOLIDAMENTO_4;
			}
			if(descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_CESSAZIONE)){
				motivoConsolidamento = Constants.ID_MOTIVO_CONSOLIDAMENTO_5;
			}
			if(descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_PROROGA)){
				motivoConsolidamento = Constants.ID_MOTIVO_CONSOLIDAMENTO_13;
			}
			if(descrizioneRuolo.equalsIgnoreCase(Constants.CONSOLIDAMENTO_PER_ANNULLAMENTO)){
				motivoConsolidamento = Constants.ID_MOTIVO_CONSOLIDAMENTO_4;
			}
			if(descrizioneRuolo.equalsIgnoreCase(Constants.CONSOLIDAMENTO_PER_NUOVA_ISPEZIONE)){
				motivoConsolidamento = Constants.ID_CONSOLIDAMENTO_PER_NUOVA_ISPEZIONE;
			}
			if(descrizioneRuolo.equalsIgnoreCase(Constants.CONSOLIDAMENTO_PER_SUBENTRO_RESPONSABILE)){
				motivoConsolidamento = Constants.ID_SUBENTRO_RESPONSABILE;
			}
			if(descrizioneRuolo.equalsIgnoreCase(Constants.CONSOLIDAMENTO_PER_ANNULLAMENTO_ISPEZIONE)) {
				motivoConsolidamento = Constants.ID_CONSOLIDAMENTO_PER_ANNULLAMENTO_ISPEZIONE;
			}
			consolidaLibrettoTrans(idPersonaGiuridica, cfUtenteMod, codiceRea, ConvertUtil.convertToString(codiceImpianto), motivoConsolidamento);
		} catch (ValidationManagerException ex) {
			logger.error("Errore consolida libretto: " + ex.getMsg(), ex);
			throw new SigitextException(ex.getMsg().getText());
		} catch (Exception ex) {
			logger.error("Errore consolida libretto: ", ex);
			throw new ServiceException(Messages.ERROR_RECUPERO_SERVIZIO);
		}
	}

	public void consolidaLibrettoTrans(Integer idPersonaGiuridica, String cfUtenteMod, String codiceRea, String codiceImpianto, int motivoConsolidamento) throws SigitextException {
		logger.debug("[ServiceManager::consolidaLibrettoTrans] BEGIN");
		try {
			gestisciLibrettoWeb(idPersonaGiuridica, cfUtenteMod, codiceRea, codiceImpianto, motivoConsolidamento);
		} catch (Exception e) {
			logger.error("Errore consolida libretto trans: ", e);
			throw e;
		} finally {
			logger.debug("[ServiceManager::consolidaLibrettoTrans] END");
		}
	}

	public void gestisciLibrettoWeb(Integer idPersonaGiuridica, String cfUtenteMod, String codiceRea, String codiceImpianto, int motivoConsolidamento) throws SigitextException {
		try {
			SigitTLibrettoDto librettoDto = new SigitTLibrettoDto();
			librettoDto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
			librettoDto.setFkStato(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_LIBRETTO_BOZZA));
			librettoDto.setFkTipoDocumento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_DOC_LIBRETTO));
			librettoDto.setCfRedattore(cfUtenteMod);
			librettoDto.setFlgControlloBozza(BigDecimal.ONE);
			librettoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
			librettoDto.setUtenteUltMod(cfUtenteMod);
			logger.debug("Stampo cfUtenteMod: " + cfUtenteMod);
			if (logger.isDebugEnabled())
				GenericUtil.stampa(librettoDto, true, 3);
			getDbServiceImp().getSigitTLibrettoDao().insert(librettoDto);
			logger.debug("Ricerca impiantoDto");
			SigitTImpiantoDto impiantoDto = getDbServiceImp().cercaImpiantoDtoById(codiceImpianto);
			logger.debug("Consolidamento libretto per motivo: esplicito utente");
			creaPdfEConsolidaLibretto(ConvertUtil.convertToString(idPersonaGiuridica), cfUtenteMod, impiantoDto, codiceRea, librettoDto, motivoConsolidamento);
		} catch (SigitextException e) {
			logger.error("Errore gestisci libretto web: ", e);
			throw e;
		} finally {
			logger.debug("[DbMgr::salvaLibrettoScheda1Trans] END");
		}
	}

	public ResultInvioMail sendMailInserisciManutenzione(SigitVRicercaAllegatiDto vAllegato, SigitTPersonaGiuridicaDto manutentore, String emailResponsabile, DettaglioPersonaGiuridica terzoResponsabile)
			throws ServiceException {
		String oggetto = null;

		String ubicazione = MapDto.getIndirizzoCompleto(vAllegato.getComuneImpianto(), vAllegato.getIndirizzoUnitaImmob(), null, vAllegato.getCivicoUnitaImmob(), vAllegato.getSiglaProvImpianto());
		String codiceBollino = null;
		if (GenericUtil.isNotNullOrEmpty(vAllegato.getFkNumeroBollino())) {
			codiceBollino = vAllegato.getFkSiglaBollino() + "-" + vAllegato.getFkNumeroBollino();
		}

		oggetto = "CIT: avvenuta comunicazione manutenzione impianto " + vAllegato.getCodiceImpianto();

		// Compongo la mail con formato HTML
		StringBuilder testoHtml = getContenutoMailManutenzione(vAllegato, ubicazione, codiceBollino, false);

		ArrayList<String> destinatariSingoli = new ArrayList<>();
		
		if (GenericUtil.isNotNullOrEmpty(manutentore.getEmail())) {
			destinatariSingoli.add(manutentore.getEmail());

		}
		
		if (GenericUtil.isNotNullOrEmpty(emailResponsabile)) {
			destinatariSingoli.add(emailResponsabile);
		}

		if (terzoResponsabile != null && GenericUtil.isNotNullOrEmpty(terzoResponsabile.getEmail())) {
			destinatariSingoli.add(terzoResponsabile.getEmail());
		}

		ResultInvioMail resultInvioMail = null;

		if (!destinatariSingoli.isEmpty()) {
			resultInvioMail = sendMail(destinatariSingoli, null, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		}

		return resultInvioMail;
	}

	private StringBuilder getContenutoMailManutenzione(SigitVRicercaAllegatiDto vAllegato, String ubicazione, String codiceBollino, boolean isAnnullamento) {
		StringBuilder testoHtml = new StringBuilder();

		if (isAnnullamento) {

			testoHtml.append("Si avvisa che la manutenzione dell'impianto in oggetto e' stata annullata.<BR/><BR/>");
		} else {
			testoHtml.append("Avvenuta comunicazione manutenzione sull'impianto in oggetto.<BR/><BR/>");

		}
		testoHtml.append("Descrizione impianto<BR/>");

		testoHtml.append("Codice impianto: " + vAllegato.getCodiceImpianto() + "<BR/>");

		testoHtml.append("Localizzazione: " + ubicazione + "<BR/><BR/>");
		testoHtml.append("Descrizione intervento di manutenzione<BR/>");
		testoHtml.append("Data controllo: " + ConvertUtil.convertToString(vAllegato.getDataControllo()) + "<BR/>");
		if (GenericUtil.isNotNullOrEmpty(codiceBollino)) {
			testoHtml.append("Codice bollino: " + codiceBollino + "<BR/>");
		}
		testoHtml.append("Componenti controllate: " + GenericUtil.getStringValid(vAllegato.getElencoApparecchiature()) + "<BR/>");
		testoHtml.append("Data comunicazione manutenzione: " + ConvertUtil.convertToString(vAllegato.getDataInvio()) + "<BR/>");
		if (isAnnullamento) {
			testoHtml.append("Data annullamento manutenzione: " + DateUtil.getDataCorrenteFormat() + "<BR/>");
		}

		testoHtml.append("<BR/><BR/>Regione Piemonte<BR/><BR/>");
		testoHtml.append("Per qualsiasi approfondimento utilizzare il seguente link<BR/>");
		testoHtml.append("https://energia-cit.regione.piemonte.it/citpwa");

		
		return testoHtml;
	}

	public Boolean checkUtenteAutorizzato(String codiceFiscale) throws Exception {
		
		WrkConfigDto utentiAutorizzati = cercaConfigValue(Constants.CIT_UTENTI_AUTORIZZATI);
		
		return utentiAutorizzati!=null && utentiAutorizzati.getValoreConfigChar()!=null?utentiAutorizzati.getValoreConfigChar().contains(codiceFiscale):false;
	}

	public List<ConsumoPodPdr> getConsumiByPodPdr(String podPdr) throws Exception {

		logger.debug("[ServiceManager::getConsumiByPodPdr] BEGIN");
		logger.debug("podPdr : " + podPdr);
		List<ConsumoPodPdr> consumoPodPdr = null;
		try {
			List<SigitTDatoDistribDto> dtoList = getDbServiceImp().getConsumiByPodPdr(podPdr);
			if (dtoList != null) {
				logger.debug("dto list get consumi pod/pdr size : " + dtoList.size());
				consumoPodPdr = new ArrayList<>();
				for (SigitTDatoDistribDto sigitTDatoDistribDto : dtoList) {
					logger.debug("sigit T Dato Distrib Dto : " + sigitTDatoDistribDto.toString());
					ConsumoPodPdr dtoPodPdr = new ConsumoPodPdr();
					dtoPodPdr.setAnno(sigitTDatoDistribDto.getAnnoRif());
					dtoPodPdr.setConsumoAnno(sigitTDatoDistribDto.getConsumoAnno());
					dtoPodPdr.setPodPdr(sigitTDatoDistribDto.getPodPdr());
					logger.debug("dto Pod Pdr dopo chiamata t_dato_distrib : " + dtoPodPdr.toString());
					consumoPodPdr.add(dtoPodPdr);
				}
				logger.debug("final size consumo pod pdr list : " + consumoPodPdr.size());
			}
		} catch (Exception e) {
			logger.error("[ServiceManager::getConsumiByPodPdr] Errore : ", e);
			throw e;
		} finally {
			logger.debug("[ServiceManager::getConsumiByPodPdr] END");
		}
		return consumoPodPdr;
	}

	@Transactional
	public String salvaVerificaMassiva(Verifica verifica, Integer flgIspPagamento, UtenteLoggatoModel utenteLoggatoModel) throws SigitextException {
		
		String errors = "";
		String istatComune="";
		
		try {		
		
		if(utenteLoggatoModel!=null && utenteLoggatoModel.getCodiceFiscale()!=null) {
			List<SigitTPersonaFisicaDto> personeFisiche = getDbServiceImp().cercaPersonaFisicaByCodiceFiscale(utenteLoggatoModel.getCodiceFiscale());
			if (personeFisiche.size() == 1) {
				SigitTPersonaFisicaDto persona = personeFisiche.get(0);
				utenteLoggatoModel.setDenominazione(persona.getCognome()+" "+persona.getNome());				
			}
		}
		
		SigitTAbilitazioneDto regioneSigitTAbilitazioneDto = new SigitTAbilitazioneDto(); 
		SigitTAbilitazioneDto sigitTAbilitazioneDto = new SigitTAbilitazioneDto();
		sigitTAbilitazioneDto.setIdRuoloPa(2);
		sigitTAbilitazioneDto.setIstatAbilitazione("01");
		List<SigitTAbilitazioneDto> listSigitTAbilitazioneDto = getDbServiceImp().getSigitTAbilitazioneDao().findByExample(sigitTAbilitazioneDto);
		if(listSigitTAbilitazioneDto!=null && listSigitTAbilitazioneDto.size()>0) {
			regioneSigitTAbilitazioneDto = listSigitTAbilitazioneDto.get(0);
		}					 
		
		//IMPIANTO
		if(verifica.getTipoVerifica()!=null && verifica.getTipoVerifica().intValue() == Constants.IMPIANTO) {						
			
			String codiciImpianto = verifica.getCodiceImpianto()!=null?verifica.getCodiceImpianto():"";
			for (String  codiceImpianto : 	codiciImpianto.split(",")) {
				
				codiceImpianto = codiceImpianto.trim();
				
				try {
					
					SigitVRicercaImpiantiDto sigitVRicercaImpiantiDto = serviceDb.cercaImpiantoByCodImpianto(new BigDecimal(codiceImpianto));										
					
					
					if(sigitVRicercaImpiantiDto != null) {
						try {
							Verifica entity = new Verifica();							
							entity.setTipoVerifica(Constants.IMPIANTO);
							entity.setIdAllegato("0");
							entity.setIdDatoDistributore("0");
							entity.setCodiceImpianto(codiceImpianto);
							entity.setCfUtenteCaricamento(utenteLoggatoModel.getCodiceFiscale());
							entity.setDenomUtenteCaricamento(utenteLoggatoModel.getDenominazione());	
							entity.setDataCaricamento(ConvertUtil.convertToString(new Date()));
							entity.setNote("creazione massiva");
							SigitTVerificaPk pk = getDbVerificaMgr().salvaVerifica(MapDto.mapToSigitTVerificaDto(entity, utenteLoggatoModel));
																					
							SigitTIspezione2018Dto sigitTIspezione2018Dto = new SigitTIspezione2018Dto();												
							sigitTIspezione2018Dto.setFkStatoIspezione(new BigDecimal(1));
							sigitTIspezione2018Dto.setFkVerifica(pk.getIdVerifica());
							sigitTIspezione2018Dto.setFkAccertamento(0);
							sigitTIspezione2018Dto.setCodiceImpianto(new BigDecimal(codiceImpianto));	
							if(sigitVRicercaImpiantiDto.getIstatComune()!=null) {
								sigitTIspezione2018Dto.setIstatProvCompetenza(sigitVRicercaImpiantiDto.getIstatComune().substring(0, 3));
								sigitTIspezione2018Dto.setIstatComuneCompetenza(sigitVRicercaImpiantiDto.getIstatComune());
								istatComune = sigitVRicercaImpiantiDto.getIstatComune();
							}
							sigitTIspezione2018Dto.setFlgAccSostitutivo(new BigDecimal(0));
							sigitTIspezione2018Dto.setDtCreazione(new Timestamp((new Date()).getTime()));							
							sigitTIspezione2018Dto.setFlgIspPagamento(new BigDecimal(flgIspPagamento));
							
							SigitTIspezione2018Pk sigitTIspezione2018Pk = getDbServiceImp().getSigitTIspezione2018Dao().insert(sigitTIspezione2018Dto );	
							
							String indirizzoImpianto = null;
							String denominazioneComune = null;
							String siglaProvincia = null;
							if(codiceImpianto!=null) {
								List<SigitTUnitaImmobiliareDto> listSigitTUnitaImmobiliareDto = getDbServiceImp().getSigitTUnitaImmobiliareDao().findByCodiceImpianto(Integer.parseInt(codiceImpianto));
								if(listSigitTUnitaImmobiliareDto!=null && listSigitTUnitaImmobiliareDto.size()>0) {
									SigitTUnitaImmobiliareDto sigitTUnitaImmobiliareDto = listSigitTUnitaImmobiliareDto.get(0);
									indirizzoImpianto = sigitTUnitaImmobiliareDto.getIndirizzoSitad();
									
								}
								
								SigitTImpiantoPk sigitTImpiantoPk = new SigitTImpiantoPk();
								sigitTImpiantoPk.setCodiceImpianto(new BigDecimal(codiceImpianto));
								SigitTImpiantoDto sigitTImpiantoDto = getDbServiceImp().getSigitTImpiantoDao().findByPrimaryKey(sigitTImpiantoPk);
								
								denominazioneComune = sigitTImpiantoDto.getDenominazioneComune();
								siglaProvincia = sigitTImpiantoDto.getSiglaProvincia();
							}
							
							String indirizzo = IndirizzoUtils.formattaIndirizzo(indirizzoImpianto, null, denominazioneComune, siglaProvincia);
							String oggetto = "CIT - richiesta nuova ispezione "+sigitTIspezione2018Pk.getIdIspezione2018()+" su impianto con localizzazione: "+indirizzo;
							String corpo = "Dalla verifica "+pk.getIdVerifica()+" e' stata richiesta una nuova ispezione.<BR>" + 
									"Descrizione dell'ispezione<BR>" + 
									"Ispezione numero: "+sigitTIspezione2018Pk.getIdIspezione2018()+"<BR>" + 
									"Data creazione: "+new SimpleDateFormat("dd/MM/yyyy").format(new Date())+"<BR>" + 
									"Stato: BOZZA<BR>" + 
									"Codice impianto: "+codiceImpianto+"<BR>" + 
									"Localizzazione: "+indirizzo+"<BR>" + 
									"Note: creazione massiva";
							
							setVerificaMassivaMail(regioneSigitTAbilitazioneDto, sigitTIspezione2018Dto, oggetto,
									corpo);
							
						} catch (SigitextException e) {
							errors = String.join(",",codiceImpianto,errors);
						} finally {
							logger.debug("[ServiceManager::salvaVerificaMassiva] errore: "+codiceImpianto);
						}
						
					}else {
						errors = String.join(",",codiceImpianto,errors);
					}
					
					
				} catch (NumberFormatException e) {
					errors = String.join(",",codiceImpianto,errors);
				}															
				
			}		
			
		}
		//FINE IMPIANTO
		
		//DATO DISTRIBUTORE
		if(verifica.getTipoVerifica()!=null && verifica.getTipoVerifica().intValue() == Constants.DATO_DISTRIBUTORE) {
			
			String elencoIdDatoDistributore = verifica.getIdDatoDistributore()!=null?verifica.getIdDatoDistributore():"";
			for (String  idDatoDistributore : 	elencoIdDatoDistributore.split(",")) {
				
				idDatoDistributore = idDatoDistributore.trim();
				
				try {
															
					DatiDistributore datiDistributore =  serviceDb.getDistributore(Integer.parseInt((idDatoDistributore)));
										
					if(datiDistributore != null) {
						try {
							Verifica entity = new Verifica();							
							entity.setTipoVerifica(Constants.DATO_DISTRIBUTORE);
							entity.setIdAllegato("0");
							entity.setIdDatoDistributore(idDatoDistributore);
							entity.setCodiceImpianto("0");
							entity.setCfUtenteCaricamento(utenteLoggatoModel.getCodiceFiscale());
							entity.setDenomUtenteCaricamento(utenteLoggatoModel.getDenominazione());	
							entity.setDataCaricamento(ConvertUtil.convertToString(new Date()));
							entity.setNote("creazione massiva");
							SigitTVerificaPk pk = getDbVerificaMgr().salvaVerifica(MapDto.mapToSigitTVerificaDto(entity, utenteLoggatoModel));
																					
							SigitTIspezione2018Dto sigitTIspezione2018Dto = new SigitTIspezione2018Dto();												
							sigitTIspezione2018Dto.setFkStatoIspezione(new BigDecimal(1));
							sigitTIspezione2018Dto.setFkVerifica(pk.getIdVerifica());
							sigitTIspezione2018Dto.setFkAccertamento(0);
							sigitTIspezione2018Dto.setCodiceImpianto(BigDecimal.ZERO);		
							if(datiDistributore.getIstatComuneFatt()!=null) {
								sigitTIspezione2018Dto.setIstatProvCompetenza(datiDistributore.getIstatComuneFatt().substring(0,3));
								sigitTIspezione2018Dto.setIstatComuneCompetenza(datiDistributore.getIstatComuneFatt());
							}
							istatComune= datiDistributore.getIstatComuneFatt();
							sigitTIspezione2018Dto.setFlgAccSostitutivo(new BigDecimal(0));
							sigitTIspezione2018Dto.setDtCreazione(new Timestamp((new Date()).getTime()));							
							sigitTIspezione2018Dto.setFlgIspPagamento(new BigDecimal(flgIspPagamento));																																									
							
							SigitTIspezione2018Pk sigitTIspezione2018Pk = getDbServiceImp().getSigitTIspezione2018Dao().insert(sigitTIspezione2018Dto );	
							
							String indirizzoImpianto = null;
							String denominazioneComune = null;
							String siglaProvincia = null;
							if(idDatoDistributore!=null) {
								SigitTDatoDistribPk sigitTDatoDistribPk = new SigitTDatoDistribPk();
								sigitTDatoDistribPk.setIdDatoDistrib(Integer.parseInt(idDatoDistributore));
								SigitTDatoDistribDto sigitTDatoDistribDto = getDbServiceImp().getSigitTDatoDistribDao().findByPrimaryKey(sigitTDatoDistribPk);
								if(sigitTDatoDistribDto!=null) {									
									indirizzoImpianto = sigitTDatoDistribDto.getDugFatt()+" "+sigitTDatoDistribDto.getIndirizzoFatt()+" "+sigitTDatoDistribDto.getCivicoFatt();									
								}
															
							}							
							
							SigitTImpiantoDto sigitTImpiantoDto = getDbServiceImp().getSigitTImpiantoDao().findByIstatComune(istatComune);
							if(sigitTImpiantoDto!=null) {								
								denominazioneComune = sigitTImpiantoDto.getDenominazioneComune();
								siglaProvincia = sigitTImpiantoDto.getSiglaProvincia();								
							}

							
							String indirizzo = IndirizzoUtils.formattaIndirizzo(indirizzoImpianto, null, denominazioneComune, siglaProvincia);
							String oggetto = "CIT - richiesta nuova ispezione "+sigitTIspezione2018Pk.getIdIspezione2018()+" su impianto con localizzazione: "+indirizzo;
							String corpo = "Dalla verifica "+pk.getIdVerifica()+" e' stata richiesta una nuova ispezione.<BR>" + 
									"Descrizione dell'ispezione<BR>" + 
									"Ispezione numero: "+sigitTIspezione2018Pk.getIdIspezione2018()+"<BR>" + 
									"Data creazione: "+new SimpleDateFormat("dd/MM/yyyy").format(new Date())+"<BR>" + 
									"Stato: BOZZA<BR>" + 
									"Dato distributore: "+idDatoDistributore+"<BR>" + 
									"Localizzazione: "+indirizzo+"<BR>" + 
									"Note: creazione massiva";
							
							setVerificaMassivaMail(regioneSigitTAbilitazioneDto, sigitTIspezione2018Dto, oggetto,
									corpo);
							
						} catch (SigitextException e) {
							errors = String.join(",",idDatoDistributore,errors);							
						} finally {
							logger.debug("[ServiceManager::salvaVerificaMassiva] errore: "+idDatoDistributore);
						}
						
					}else {
						errors = String.join(",",idDatoDistributore,errors);
					}
					
					
				} catch (NumberFormatException e) {
					errors = String.join(",",idDatoDistributore,errors);
				}								
				
			}				
		}
		//FINE DATO DISTRIBUTORE			    	 	    			    		   	    
			
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new SigitextException(e.getMessage(),e);
		}
		
		return errors.indexOf(",")==-1?"OK":errors.substring(0, errors.length()-1);
	}

	private void setVerificaMassivaMail(SigitTAbilitazioneDto regioneSigitTAbilitazioneDto,
			SigitTIspezione2018Dto sigitTIspezione2018Dto, String oggetto, String corpo)
			throws ServiceException, SigitTAbilitazioneDaoException {
		List<SigitTAbilitazioneDto> listSigitTAbilitazioneDto;
		sendMail(regioneSigitTAbilitazioneDto.getMailComunicazione(), oggetto, corpo, GenericUtil.getStringaTxtToHtml(corpo));
		
		SigitTAbilitazioneDto sigitTAbilitazioneDtoSearch = new SigitTAbilitazioneDto();
		sigitTAbilitazioneDtoSearch.setIdRuoloPa(2);
		sigitTAbilitazioneDtoSearch.setIstatAbilitazione("01"+sigitTIspezione2018Dto.getIstatProvCompetenza());
		listSigitTAbilitazioneDto = getDbServiceImp().getSigitTAbilitazioneDao().findByExample(sigitTAbilitazioneDtoSearch);
					    	    								
		if (listSigitTAbilitazioneDto != null) {
			for (SigitTAbilitazioneDto sigitTAbilitazioneDto : listSigitTAbilitazioneDto) {
				sendMail(sigitTAbilitazioneDto.getMailComunicazione(), oggetto, corpo, GenericUtil.getStringaTxtToHtml(corpo));
			}
		}
	}

	public DettaglioVerifica getDettaglioVerifica(Integer idVerifica) throws SigitextException {
		
		logger.debug("[ServiceManager::getDettaglioVerifica] BEGIN");
		logger.debug("idVerifica : " + idVerifica);
		DettaglioVerifica dettaglioVerifica = new DettaglioVerifica();
		try {
			SigitTVerificaPk pk = new SigitTVerificaPk();
			pk.setIdVerifica(idVerifica);
			SigitTVerificaDto sigitTVerificaDto = getDbServiceImp().getSigitTVerificaDao().findByPrimaryKey(pk);
			if (sigitTVerificaDto != null) {
				
				DatiVerifica datiVerifica = new DatiVerifica();
				DatiImpianto datiImpianto = new DatiImpianto();
				
				datiVerifica.setIdVerifica(idVerifica);
				datiVerifica.setCfUtenteCaricamento(sigitTVerificaDto.getCfUtenteCaricamento());
			    datiVerifica.setDenomUtenteCaricamento(sigitTVerificaDto.getDenomUtenteCaricamento());
			    datiVerifica.setDtCaricamento(sigitTVerificaDto.getDtCaricamento());			    			    
			    datiVerifica.setFkTipoVerifica(sigitTVerificaDto.getFkTipoVerifica());			    			    
			    datiVerifica.setCodiceImpianto(sigitTVerificaDto.getCodiceImpianto()==null?"":sigitTVerificaDto.getCodiceImpianto().toString());
			    
			    List<SigitTUnitaImmobiliareDto> listSigitTUnitaImmobiliareDto = getDbServiceImp().getSigitTUnitaImmobiliareDao().findByCodiceImpianto(sigitTVerificaDto.getCodiceImpianto()==null?-1:sigitTVerificaDto.getCodiceImpianto().intValue());
			    
			    SigitTImpiantoPk sigitTImpiantoPk = new SigitTImpiantoPk();
			    sigitTImpiantoPk.setCodiceImpianto(sigitTVerificaDto.getCodiceImpianto());
			    SigitTImpiantoDto sigitTImpiantoDto = getDbServiceImp().getSigitTImpiantoDao().findByPrimaryKey(sigitTImpiantoPk);
			    
			    if(listSigitTUnitaImmobiliareDto != null && !listSigitTUnitaImmobiliareDto.isEmpty()) {	
			    	SigitTUnitaImmobiliareDto sigitTUnitaImmobiliareDto = listSigitTUnitaImmobiliareDto.get(0);
			    	datiImpianto.setIndirizzoSitad(sigitTUnitaImmobiliareDto.getIndirizzoSitad());
			        datiImpianto.setIndirizzoNonTrovato(sigitTUnitaImmobiliareDto.getIndirizzoNonTrovato());			    	   
			        datiImpianto.setComune(sigitTImpiantoDto.getDenominazioneComune());			    	    
			        datiImpianto.setCivico(sigitTUnitaImmobiliareDto.getCivico());
			        datiImpianto.setIstatComune(sigitTImpiantoDto.getIstatComune());
			    }
			    	    
			    datiVerifica.setSiglaRee(sigitTVerificaDto.getSiglaBollino());
			    datiVerifica.setNumeroRee(sigitTVerificaDto.getNumeroBollino()==null?"":sigitTVerificaDto.getNumeroBollino().toString());
			    datiVerifica.setFkDatoDistrib(sigitTVerificaDto.getFkDatoDistrib());
			    datiVerifica.setDtSveglia(sigitTVerificaDto.getDtSveglia());
			    datiVerifica.setNoteSveglia(sigitTVerificaDto.getNoteSveglia());
			    datiVerifica.setNote(sigitTVerificaDto.getNote());
			    
			    dettaglioVerifica.setDatiImpianto(datiImpianto);
			    dettaglioVerifica.setDatiVerifica(datiVerifica);
				
			}
		} catch (Exception e) {
			logger.error("[ServiceManager::getDettaglioVerifica] Errore : ", e);
			throw new SigitextException(e.getMessage(),e);
		} finally {
			logger.debug("[ServiceManager::getDettaglioVerifica] END");
		}
		return dettaglioVerifica;
		
	}

	public String deleteVerifica(Integer idVerifica) throws SigitextException{

		logger.debug("[SigitMgr::deleteVerifica] BEGIN");
		String response = "OK";
		try {
						
			SigitExtVerificaDto sigitExtVerificaDto = getDbVerificaMgr().getVerificaById(idVerifica);
			logger.info(sigitExtVerificaDto.getDtSveglia());
			if(sigitExtVerificaDto.getDtSveglia()!=null && (new Date()).before(sigitExtVerificaDto.getDtSveglia()) ) {
				return "Attenzione: impossibile eliminare la verifica in presenza di sveglia attiva";
			}
			
			
			if(sigitExtVerificaDto.getFkAccertamento()!=null) {
				BigDecimal fkAccertamento = sigitExtVerificaDto.getFkAccertamento();
				SigitTAccertamentoDto sigitTAccertamentoDto = getDbVerificaMgr().getAccertamentoById(fkAccertamento.intValue());
				if(sigitTAccertamentoDto!=null) {
					return "Attenzione: impossibile eliminare la verifica in presenza di accertamenti";
				}
			}
							
			if(sigitExtVerificaDto.getFkIspezione()!=null){
				BigDecimal fkIspezione = sigitExtVerificaDto.getFkIspezione();
				SigitTIspezione2018Pk sigitTIspezione201Pk = new SigitTIspezione2018Pk();
				sigitTIspezione201Pk.setIdIspezione2018(fkIspezione.intValue());
				SigitTIspezione2018Dto sigitTIspezione2018Dto  = getDbServiceImp().getSigitTIspezione2018Dao().findByPrimaryKey(sigitTIspezione201Pk);			
				if(sigitTIspezione2018Dto!=null) {
					return "Attenzione: impossibile eliminare la verifica in presenza di ispezioni";
				}
			}
			
			List<SigitTAzioneDto> listSigitTAzioneDto = getDbAzioneMgr().getSigitTAzioneDao().findByFkVerifica(idVerifica);
			
			if(listSigitTAzioneDto!=null && !listSigitTAzioneDto.isEmpty()) {
				return "Attenzione: impossibile eliminare la verifica in presenza di azioni";	
			}
			
			getDbVerificaMgr().eliminaVerificaById(idVerifica);
				
		} catch (Exception e) {
			logger.error("[ServiceManager::deleteVerifica] Errore : ", e);
			throw new SigitextException(e.getMessage() == null ? Messages.ERROR_RECUPERO_DB : e.getMessage());
		}

		logger.debug("[SigitMgr::deleteVerifica] END");
		return response;
		
	}

	public Controlli getControllo(String siglaRee, Long numeroRee) throws SigitextException{
		
		logger.debug("[ServiceManager::getControllo] BEGIN");
		logger.debug("siglaRee : " + siglaRee);
		logger.debug("numeroRee : " + numeroRee);
		Controlli controlli = new Controlli();
		try {
			List<SigitVRicercaAllegatiDto> dtoList = getDbServiceImp().getSigitVRicercaAllegatiDao().findBySiglaReeNumeroRee(siglaRee, numeroRee);
			if (dtoList != null && dtoList.size()==1) {
				logger.debug("dto list get controlli size : " + dtoList.size());
				
				controlli.setDataControllo(dtoList.get(0).getDataControllo().getTime());
				controlli.setCodiceImpianto(dtoList.get(0).getCodiceImpianto());

			}else{
				throw new SigitextException("Non esiste un REE con il codice specificato");
			}
		} catch (Exception e) {
			logger.error("[ServiceManager::getControllo] Errore : ", e);
			throw new SigitextException(e.getMessage(),e);
		} finally {
			logger.debug("[ServiceManager::getControllo] END");
		}
		return controlli;
		
	}

	public List<Assegnatario> getAssegnatario() throws SigitextException {

		logger.debug("[ServiceManager::getAssegnatario] BEGIN");
	
		List<Assegnatario> listAssegnatario = new ArrayList<>();
		try {
			listAssegnatario = getDbServiceImp().getSigitRPfRuoloPaDao().findAllAssegnatario();
			
		} catch (Exception e) {
			logger.error("[ServiceManager::getAssegnatario] Errore : ", e);
			throw new SigitextException(e.getMessage(),e);
		} finally {
			logger.debug("[ServiceManager::getAssegnatario] END");
		}
		return listAssegnatario;
		
	}

	public List<String> getSiglaRee() throws SigitextException {

		logger.debug("[ServiceManager::getSiglaRee] BEGIN");
		
		List<String> listSiglaRee = new ArrayList<>();
		try {
			listSiglaRee = getDbServiceImp().getSigitVRicercaAllegatiDao().findAllSiglaRee();
			
		} catch (Exception e) {
			logger.error("[ServiceManager::getSiglaRee] Errore : ", e);
			throw new SigitextException(e.getMessage(),e);
		} finally {
			logger.debug("[ServiceManager::getSiglaRee] END");
		}
		return listSiglaRee;
		
	}

	public List<SigitTAzioneDto> getAzione(Integer idVerifica, Integer idAccertamento, Integer idIspezione2018) throws SigitextException {

	logger.debug("[ServiceManager::getAzione] BEGIN");
		
		List<SigitTAzioneDto> listSigitTAzioneDto = new ArrayList<>();
		try {
			if(idVerifica!=null) {
				listSigitTAzioneDto = getDbServiceImp().getSigitTAzioneDao().findByFkVerifica(idVerifica);
			}
			if(idAccertamento!=null) {
				listSigitTAzioneDto = getDbServiceImp().getSigitTAzioneDao().findByFkAccertamento(idAccertamento);
			}
			if(idIspezione2018!=null) {
				listSigitTAzioneDto = getDbServiceImp().getSigitTAzioneDao().findByFkIspezione2018(idIspezione2018);
			}
		} catch (Exception e) {
			logger.error("[ServiceManager::getAzione] Errore : ", e);
			throw new SigitextException(e.getMessage(),e);
		} finally {
			logger.debug("[ServiceManager::getAzione] END");
		}
		return listSigitTAzioneDto;
		
	}

	public Integer getMaxNumImpiantiResults() throws SigitextException {

		try {
			return cercaConfigValueNumerico(Constants.MAX_RIGHE);
		} catch (Exception e) {
			logger.error("[ServiceManager::getMaxNumImpiantiResults] Errore : ", e);
			throw new SigitextException(e.getMessage(),e);
		}
	}

	public Integer getCombustyMaxNumImpiantiResults() throws SigitextException {

		try {
			return cercaConfigValueNumerico(Constants.CIT_COMBUSTY_MAX_RIGHE);
		} catch (Exception e) {
			logger.error("[ServiceManager::getMaxNumImpiantiResults] Errore : ", e);
			throw new SigitextException(e.getMessage(),e);
		}
	}

}
