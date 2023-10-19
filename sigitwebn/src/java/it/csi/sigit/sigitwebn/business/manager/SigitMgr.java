/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.manager;


import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.sql.Date;
import java.text.ParseException;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.parser.PdfTextExtractor;
import it.csi.sigit.sigitwebn.dto.ExecResults;
import it.csi.sigit.sigitwebn.dto.accertamento.RicercaAccertamento;
import it.doqui.index.ecmengine.client.webservices.dto.engine.security.Document;
import it.doqui.index.ecmengine.client.webservices.dto.engine.security.EnvelopedContent;
import it.doqui.index.ecmengine.interfacecsi.security.EcmEngineSecurityInterface;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.components.Head;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import it.csi.sigit.sigitext.dto.sigitext.ImpiantoFiltro;
import it.csi.sigit.sigitext.dto.sigitext.TipoImportAllegatoEnum;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.DaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDClassDPR660_96DaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDCombustibileDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDFrequenzaManutDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDTipoCessazioneDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDTipoDocAggDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitRComp4ManutDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitRImpRuoloPfpgDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitRIspezIspetDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitRRuoloTipodocDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTAccertamentoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTAllegatoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompBrRcDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompVxDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTConsumo14_4DaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTConsumoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTContratto2019DaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTImpiantoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTIspezione2018DaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTPersonaFisicaDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTPersonaGiuridicaDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTSanzioneDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompAcDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompAgDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompCiDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompCsDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompGfDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompGtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompPoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompRcDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompRvDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompScxDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompSrDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompTeDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompUtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompVmDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompVrDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVRicercaAllegatiDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVRicercaIspezioniDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.DocumentoAzioneDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.DocumentoContrattoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaAllegati;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaPfPg;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImpiantoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportDistribFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportDocumentoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportFileSuper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.IspezioneFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaAccertamentoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaAvanzataImpiantoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaIspezioniFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaSanzioniFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaVerificaFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.TransazioneFilter;
import it.csi.sigit.sigitwebn.business.gestisci_accertamento.CPBECpDettaglioAccertamentoConf.RicercaCampoAccertamentoEnum;
import it.csi.sigit.sigitwebn.business.gestisci_verifica.CPBECpGestVerifica.RicercaCampoVerificaEnum;
import it.csi.sigit.sigitwebn.business.gestisci_verifica.CPBECpGestVerifica.TipoVerificaEnum;
import it.csi.sigit.sigitwebn.business.manager.db.DbAzioneMgr;
import it.csi.sigit.sigitwebn.business.manager.db.DbIspezioneMgr;
import it.csi.sigit.sigitwebn.business.manager.db.DbSvegliaMgr;
import it.csi.sigit.sigitwebn.business.manager.db.DbVerificaMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.business.pdf.DatiCGCommon;
import it.csi.sigit.sigitwebn.business.pdf.DatiGFCommon;
import it.csi.sigit.sigitwebn.business.pdf.DatiGTCommon;
import it.csi.sigit.sigitwebn.business.pdf.DatiSCCommon;
import it.csi.sigit.sigitwebn.business.pdf.IspezioneBuilder;
import it.csi.sigit.sigitwebn.business.pdf.ReeBuilder;
import it.csi.sigit.sigitwebn.business.pdf.RicevutaBuilder;
import it.csi.sigit.sigitwebn.business.ws.service.svista.client.Comune;
import it.csi.sigit.sigitwebn.business.ws.service.svista.client.Provincia;
import it.csi.sigit.sigitwebn.dto.accertamento.Accertamento;
import it.csi.sigit.sigitwebn.dto.accertamento.IspezioneAccertamento;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaFisica;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica;
import it.csi.sigit.sigitwebn.dto.accesso.Ruolo;
import it.csi.sigit.sigitwebn.dto.allegati.AllegatiPerImpianto;
import it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato;
import it.csi.sigit.sigitwebn.dto.allegati.ElencoAllegati;
import it.csi.sigit.sigitwebn.dto.allegati.FiltroControlloInserisciAllegato;
import it.csi.sigit.sigitwebn.dto.allegati.FiltroRicercaCodiciImpianto;
import it.csi.sigit.sigitwebn.dto.allegati.RicercaAllegati;
import it.csi.sigit.sigitwebn.dto.azioni.Azione;
import it.csi.sigit.sigitwebn.dto.azioni.Sveglia;
import it.csi.sigit.sigitwebn.dto.back_office.Abilitazione;
import it.csi.sigit.sigitwebn.dto.bollini.AcquistoBollini;
import it.csi.sigit.sigitwebn.dto.bollini.AcquistoBolliniQuantita;
import it.csi.sigit.sigitwebn.dto.codici_impianto.RisultatoRicCodImpiantoLib;
import it.csi.sigit.sigitwebn.dto.common.CodeDescription;
import it.csi.sigit.sigitwebn.dto.common.IdDescription;
import it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger;
import it.csi.sigit.sigitwebn.dto.delega.Delegato;
import it.csi.sigit.sigitwebn.dto.distributori.DettaglioErrore;
import it.csi.sigit.sigitwebn.dto.distributori.DistributoreMan;
import it.csi.sigit.sigitwebn.dto.documentazione.Documento;
import it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto;
import it.csi.sigit.sigitwebn.dto.impianto.Impianto;
import it.csi.sigit.sigitwebn.dto.impianto.Proprietario;
import it.csi.sigit.sigitwebn.dto.impianto.Responsabile;
import it.csi.sigit.sigitwebn.dto.impianto.RicercaAvanzataImpianti;
import it.csi.sigit.sigitwebn.dto.impianto.RicercaImpianti;
import it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicImpianto;
import it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicResponsabile;
import it.csi.sigit.sigitwebn.dto.impresa.LabelValue;
import it.csi.sigit.sigitwebn.dto.impresa.RicercaImprese;
import it.csi.sigit.sigitwebn.dto.index.DettaglioDocumento;
import it.csi.sigit.sigitwebn.dto.index.DettaglioDocumentoMultiplo;
import it.csi.sigit.sigitwebn.dto.index.Metadati;
import it.csi.sigit.sigitwebn.dto.ispezioni.ConclusioneIspezione2018;
import it.csi.sigit.sigitwebn.dto.ispezioni.DettaglioIspezione;
import it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018;
import it.csi.sigit.sigitwebn.dto.ispezioni.IspezioniPerImpianto;
import it.csi.sigit.sigitwebn.dto.ispezioni.RapProvaDatiGenerali;
import it.csi.sigit.sigitwebn.dto.ispezioni.RicercaImpiantoDaAssociare;
import it.csi.sigit.sigitwebn.dto.ispezioni.RicercaIspezioni2018;
import it.csi.sigit.sigitwebn.dto.libretto.Componente;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteBRRC;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteCG;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteGF;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteGT;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteSC;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteVX;
import it.csi.sigit.sigitwebn.dto.libretto.Consumo;
import it.csi.sigit.sigitwebn.dto.libretto.ConsumoAcqua;
import it.csi.sigit.sigitwebn.dto.libretto.ControlloLibretto;
import it.csi.sigit.sigitwebn.dto.libretto.DatiExtra;
import it.csi.sigit.sigitwebn.dto.libretto.DettaglioManutenzione;
import it.csi.sigit.sigitwebn.dto.libretto.LibrettoDett;
import it.csi.sigit.sigitwebn.dto.libretto.PkTabellaEdit;
import it.csi.sigit.sigitwebn.dto.libretto.Scheda1;
import it.csi.sigit.sigitwebn.dto.libretto.Scheda11Intest;
import it.csi.sigit.sigitwebn.dto.libretto.Scheda12;
import it.csi.sigit.sigitwebn.dto.libretto.Scheda15;
import it.csi.sigit.sigitwebn.dto.libretto.SistemaEmissione;
import it.csi.sigit.sigitwebn.dto.libretto.SistemiDistribuzione;
import it.csi.sigit.sigitwebn.dto.libretto.SistemiRegolazioneContabilizzazione;
import it.csi.sigit.sigitwebn.dto.libretto.TrattamentoAcqua;
import it.csi.sigit.sigitwebn.dto.main.RicercaTransazione;
import it.csi.sigit.sigitwebn.dto.main.RisultatoRicTransazione;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGF;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGFDett;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGFDettCircuito;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGT;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGTDett;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGTDettModulo;
import it.csi.sigit.sigitwebn.dto.ree.Tipo1;
import it.csi.sigit.sigitwebn.dto.ree.Tipo1Dett;
import it.csi.sigit.sigitwebn.dto.ree.Tipo1DettModulo;
import it.csi.sigit.sigitwebn.dto.ree.Tipo2;
import it.csi.sigit.sigitwebn.dto.ree.Tipo2Dett;
import it.csi.sigit.sigitwebn.dto.ree.Tipo2DettCircuito;
import it.csi.sigit.sigitwebn.dto.ree.Tipo3;
import it.csi.sigit.sigitwebn.dto.ree.Tipo3Dett;
import it.csi.sigit.sigitwebn.dto.ree.Tipo4;
import it.csi.sigit.sigitwebn.dto.ree.Tipo4Dett;
import it.csi.sigit.sigitwebn.dto.sanzioni.DatiInserimentoSanzione;
import it.csi.sigit.sigitwebn.dto.sanzioni.RicercaSanzioni;
import it.csi.sigit.sigitwebn.dto.sanzioni.RisultatoRicerca;
import it.csi.sigit.sigitwebn.dto.sanzioni.Sanzione;
import it.csi.sigit.sigitwebn.dto.subentro.Subentro;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.CessazioneTerzaResponsabilita;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.DettaglioTerzoResponsabile;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.DocContratto;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.ProrogaTerzoResponsabile;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.TerzoResponsabile;
import it.csi.sigit.sigitwebn.dto.verifica.Verifica;
import it.csi.sigit.sigitwebn.util.ComparatorUtil;
//import it.csi.sigit.sigitwebn.dto.verifica.Azione;
//import it.csi.sigit.sigitwebn.dto.verifica.Verifica;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.DateUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.MapDto;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.ReeSuperDto;
import it.csi.sigit.sigitwebn.util.ReplaceSpecialCharUtils;
import it.csi.sigit.sigitwebn.util.XmlBeanUtils;
import it.csi.sigit.sigitwebn.util.XmlValidator;
import it.csi.sigit.sigitwebn.util.XmlValidatorException;
import it.csi.sigit.sigitwebn.util.enumutil.PositivoNegativoEnum;
import it.csi.sigit.sigitwebn.util.enumutil.TipoSubentroEnum;
import it.csi.sigit.sigitwebn.util.mail.Allegato;
import it.csi.sigit.sigitwebn.util.mail.ResultInvioMail;
import it.csi.sigit.sigitwebn.xml.allegato2.data.CheckListDocument.CheckList;
import it.csi.sigit.sigitwebn.xml.allegato2.data.ControlloImpiantoDocument.ControlloImpianto;
import it.csi.sigit.sigitwebn.xml.allegato2.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica;
import it.csi.sigit.sigitwebn.xml.allegato2.data.DatiTecnicoDocument.DatiTecnico;
import it.csi.sigit.sigitwebn.xml.allegato2.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica;
import it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument;
import it.csi.sigit.sigitwebn.xml.allegato2.data.RowAllegatoIIDocument.RowAllegatoII;
import it.csi.sigit.sigitwebn.xml.allegato2.data.RowAllegatoIIDocument.RowAllegatoII.TabFumi;
import it.csi.sigit.sigitwebn.xml.allegato2.data.RowFumiDocument.RowFumi;
import it.csi.sigit.sigitwebn.xml.allegato3.data.MODIIIDocument;
import it.csi.sigit.sigitwebn.xml.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII;
import it.csi.sigit.sigitwebn.xml.allegato4.data.MODIVDocument;
import it.csi.sigit.sigitwebn.xml.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV;
import it.csi.sigit.sigitwebn.xml.allegato5.data.MODVDocument;
import it.csi.sigit.sigitwebn.xml.allegato5.data.RowAllegatoVDocument.RowAllegatoV;
import it.csi.sigit.sigitwebn.xml.libretto.data.MODDocument;
import it.csi.sigit.sigitwebn.xml.libretto.data.RichiestaDocument.Richiesta;
//import it.doqui.index.ecmengine.dto.OperationContext;
//import sun.misc.Perf.GetPerfAction;

//import com.sun.corba.se.impl.orbutil.closure.Constant;

/**
 * Manager generale del sigit, nel caso in cui bisogna chiamare vari servizi o servizi e DB
 *
 */
public class SigitMgr {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");

	/**
	 * Manager dei servizi
	 */
	protected ServiziMgr serviziMgr;

	/**
	 * Restituisce il manager dei servizi
	 *
	 * @return Manager dei servizi
	 */
	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	/**
	 * Imposta i manager dei servizi
	 *
	 * @param serviziMgr Manager dei servizi
	 */
	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	protected DbVerificaMgr dbVerificaMgr;
	protected DbAzioneMgr dbAzioneMgr;
	protected DbSvegliaMgr dbSvegliaMgr;
	protected DbIspezioneMgr dbIspezioneMgr;
	protected IspezioneBuilder ispezioneBuilder;
	protected ReeBuilder reeBuilder;
	protected RicevutaBuilder ricevutaBuilder;

	public DbSvegliaMgr getDbSvegliaMgr() {
		return dbSvegliaMgr;
	}

	public void setDbSvegliaMgr(DbSvegliaMgr dbSvegliaMgr) {
		this.dbSvegliaMgr = dbSvegliaMgr;
	}

	public DbIspezioneMgr getDbIspezioneMgr() {
		return dbIspezioneMgr;
	}

	public void setDbIspezioneMgr(DbIspezioneMgr dbIspezioneMgr) {
		this.dbIspezioneMgr = dbIspezioneMgr;
	}

	public DbAzioneMgr getDbAzioneMgr() {
		return dbAzioneMgr;
	}
	public void setDbAzioneMgr(DbAzioneMgr dbAzioneMgr) {
		this.dbAzioneMgr = dbAzioneMgr;
	}
	public DbVerificaMgr getDbVerificaMgr() {
		return dbVerificaMgr;
	}
	public void setDbVerificaMgr(DbVerificaMgr dbVerificaMgr) {
		this.dbVerificaMgr = dbVerificaMgr;
	}

	public IspezioneBuilder getIspezioneBuilder() {
		return ispezioneBuilder;
	}
	public void setIspezioneBuilder(IspezioneBuilder ispezioneBuilder) {

		log.error("SETTO l'ISPEZIONE BUILDER: "+ispezioneBuilder);
		this.ispezioneBuilder = ispezioneBuilder;
	}

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

	/**
	 * Manager del DB
	 */
	protected DbMgr dbMgr;

	/**
	 * Restituisce il manager del DB
	 *
	 * @return Manager del DB
	 */
	public DbMgr getDbMgr() {
		return dbMgr;
	}

	/**
	 * Imposta i manager del DB
	 *
	 * @param serviziMgr Manager del DB
	 */
	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	/**
	 * Manager del DB
	 */
	protected DbMgrImport dbMgrImport;

	/**
	 * Restituisce il manager del DB
	 *
	 * @return Manager del DB
	 */
	public DbMgrImport getDbMgrImport() {
		return dbMgrImport;
	}

	/**
	 * Imposta i manager del DB
	 *
	 * @param serviziMgr Manager del DB
	 */
	public void setDbMgrImport(DbMgrImport dbMgrImport) {
		this.dbMgrImport = dbMgrImport;
	}


	protected ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	/**
	 * Restituisce la lista delle sigle Rea
	 *
	 * @return Lista delle sigle Rea
	 * @throws ManagerException Errore durante il recupero dei dati
	 */
	public ArrayList<CodeDescription> getListaSigleRea() throws ManagerException {
		log.debug("[SigitMgr::getListaSigleRea] BEGIN");
		ArrayList<CodeDescription> listaSigleRea = null;
		ArrayList<CodeDescription> listaProvince = null;
		Hashtable<String, CodeDescription> hashProvincePiemonte = null;

		try {
			listaProvince = getServiziMgr().getListaProvince();
			listaSigleRea = getServiziMgr().getListaSiglaProvincePiemonte();
			// Si accodano le province non piemontesi
			hashProvincePiemonte = new Hashtable<String, CodeDescription>();
			for(CodeDescription codeDescription : listaSigleRea) {
				hashProvincePiemonte.put(codeDescription.getCode(), codeDescription);
			}
			for(CodeDescription codeDescription : listaProvince) {
				if(hashProvincePiemonte.get(codeDescription.getCode()) == null) {
					listaSigleRea.add(codeDescription);
				}
			}
		}
		catch(Exception e) {

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		log.debug("[SigitMgr::getListaSigleRea] END");
		return listaSigleRea;
	}

	/**
	 * Restituisce la lista dei ruoli completa (Ruoli PA + Ruoli Privati)
	 *
	 * @return Lista delle sigle Rea
	 * @throws ManagerException Errore durante il recupero dei dati
	 */
	public ArrayList<Ruolo> getListaRuoli(List<SigitRPfRuoloPaAllActiveDto> ruoli, PersonaFisica personaFisica) throws ManagerException {
		log.debug("[SigitMgr::getListaRuoli] BEGIN");
		ArrayList<Ruolo> listaRuoliCompleta = new ArrayList<Ruolo>();

		int idRuolo = 0;

		try {

			//getDbMgr().cercaPersonaFisicaByCF(cf)ServiziMgr().

			// Aggiungo alla lista ruoli i ruoli di IRIDE
//			for (it.csi.iride2.iridefed.entity.Ruolo ruolo : ruoliIride) {
//
//				//log.debug("Stampo il ruolo IRIDE");
//				//GenericUtil.stampa(ruolo, false, 2);
//
//				if (!ruolo.getCodiceRuolo().equalsIgnoreCase(Constants.RUOLO_TITOLARE_CF))
//				{
//					Ruolo ruoloIride = new Ruolo();
//					ruoloIride.setIdRuolo(idRuolo++);
//					ruoloIride.setDescRuolo(ruolo.getCodiceRuolo());
//					ruoloIride.setDescRuoloCompleto(ruolo.getCodiceRuolo());
//					listaRuoliCompleta.add(ruoloIride);
//				}
//			}

			// Aggiungo alla lista ruoli i ruoli PA
			if (ruoli != null)
			{
				for (SigitRPfRuoloPaAllActiveDto ruoloPA : ruoli) {
					int lunghezzaIstatAbilitazione = 0;

					if (ruoloPA.getRpaIstatAbilitazione() != null) {
						lunghezzaIstatAbilitazione = ruoloPA.getRpaIstatAbilitazione().length();
					}

					Ruolo ruolo = new Ruolo();

					String desRuoloPa = ruoloPA.getDrDesRuoloPa().toUpperCase();

					ruolo.setIdRuolo(idRuolo++);
					ruolo.setDescRuolo(desRuoloPa);
					ruolo.setDescRuoloCompleto(desRuoloPa);
					ruolo.setIstatAbilitazione(ruoloPA.getRpaIstatAbilitazione());

					String denominazioneRuolo = "";

					String rpaDescAbilitazione = StringUtils.trimToEmpty(ruoloPA.getRpaDescAbilitazione());

					switch (lunghezzaIstatAbilitazione) {
					case 8 :
						denominazioneRuolo = "Abilitato al " + rpaDescAbilitazione;
						break;
					case 5 :
						denominazioneRuolo = "Abilitato alla " + rpaDescAbilitazione;
						break;
					case 2 :
						denominazioneRuolo = "Abilitato su tutto";
						break;
					}

					ruolo.setDenomDitta(denominazioneRuolo);
					listaRuoliCompleta.add(ruolo);
				}
			}

			if (personaFisica != null)
			{

				Ruolo ruoloResponsabile = new Ruolo();
				ruoloResponsabile.setIdRuolo(idRuolo++);
				ruoloResponsabile.setCodiceFiscale(personaFisica.getCodiceFiscale());
				ruoloResponsabile.setDescRuolo(Constants.RUOLO_RESPONSABILE);
				ruoloResponsabile.setDescRuoloCompleto(Constants.RUOLO_RESPONSABILE);

				listaRuoliCompleta.add(ruoloResponsabile);

				Ruolo ruoloProprietario = new Ruolo();
				ruoloProprietario.setIdRuolo(idRuolo++);
				ruoloProprietario.setCodiceFiscale(personaFisica.getCodiceFiscale());
				ruoloProprietario.setDescRuolo(Constants.RUOLO_PROPRIETARIO);
				ruoloProprietario.setDescRuoloCompleto(Constants.RUOLO_PROPRIETARIO);

				listaRuoliCompleta.add(ruoloProprietario);

				// Cerco con queli ditte e' collegata la persona fisica
				ArrayList<SigitRPfPgDelegaDto> pFisGiuDelList =  getDbMgr().cercaPersonaGiuDelByIdPersFis(personaFisica.getIdPersonaFisica());

				if (pFisGiuDelList != null && pFisGiuDelList.size() > 0)
				{

					for (SigitRPfPgDelegaDto sigitRPfPgDelegaDto : pFisGiuDelList) {
						Integer idPersonaG = ConvertUtil.convertToInteger(sigitRPfPgDelegaDto.getIdPersonaGiuridica());
						PersonaGiuridica persGiuridica = getDbMgr().cercaPersonaGiuridicaById(idPersonaG);

//						// Controllo se e' un installatore
//						if (GenericUtil.isNotNullOrEmpty(persGiuridica.getFlgInstallatore()) && persGiuridica.getFlgInstallatore())
//						{
//							listaRuoliCompleta.add(creaRuoloPrivato(idRuolo++, persGiuridica, Constants.RUOLO_INSTALLATORE));
//						}

						// Controllo se e' impresa
						if (GenericUtil.isNotNullOrEmpty(persGiuridica.getFlgDm37LetteraC()) && persGiuridica.getFlgDm37LetteraC())
						{
							listaRuoliCompleta.add(creaRuoloPrivato(idRuolo++, persGiuridica, Constants.RUOLO_IMPRESA));
						}

						// Controllo se e' un amministratore
						if ((GenericUtil.isNotNullOrEmpty(persGiuridica.getFlgAmministratore()) && persGiuridica.getFlgAmministratore())
								|| ((GenericUtil.isNotNullOrEmpty(persGiuridica.getFlgSoggIncaricato()) && persGiuridica.getFlgSoggIncaricato())))
						{
							listaRuoliCompleta.add(creaRuoloPrivato(idRuolo++, persGiuridica, Constants.RUOLO_RESPONSABILE_IMPRESA));
							listaRuoliCompleta.add(creaRuoloPrivato(idRuolo++, persGiuridica, Constants.RUOLO_PROPRIETARIO_IMPRESA));
						}

						// Controllo se e' un terzo responsabile
						if (GenericUtil.isNotNullOrEmpty(persGiuridica.getFlgTerzoResponsabile()) && persGiuridica.getFlgTerzoResponsabile())
						{
							listaRuoliCompleta.add(creaRuoloPrivato(idRuolo++, persGiuridica, Constants.RUOLO_3RESPONSABILE));
						}

						// Controllo se e' un distributore
						if (GenericUtil.isNotNullOrEmpty(persGiuridica.getFlgDistributore()) && persGiuridica.getFlgDistributore())
						{
							listaRuoliCompleta.add(creaRuoloPrivato(idRuolo++, persGiuridica, Constants.RUOLO_DISTRIBUTORE));
						}

						// Controllo se e' un CAT
						if (GenericUtil.isNotNullOrEmpty(persGiuridica.getFlgCat()) && persGiuridica.getFlgCat())
						{
							listaRuoliCompleta.add(creaRuoloPrivato(idRuolo++, persGiuridica, Constants.RUOLO_CAT));
						}
					}

					///////////////// NEW CAT

					if (log.isDebugEnabled())
					{
						log.debug("DEVO CONTROLLARE I CAT");
						log.debug("pFisGiuDelList: "+pFisGiuDelList);
						log.debug("pFisGiuDelList.size(): "+pFisGiuDelList.size());
					}

					for (SigitRPfPgDelegaDto sigitRPfPgDelegaDto : pFisGiuDelList) {
						Integer idPersonaG = ConvertUtil.convertToInteger(sigitRPfPgDelegaDto.getIdPersonaGiuridica());
						PersonaGiuridica persGiuridica = getDbMgr().cercaPersonaGiuridicaById(idPersonaG);

						log.debug("persGiuridica: "+persGiuridica);
						log.debug("persGiuridica.getFlgCat(): "+persGiuridica.getFlgCat());

						if (persGiuridica.getFlgCat())
						{
							ArrayList<SigitRPgPgNominaDto> elencoPgImp = getDbMgr().cercaSigitRPgPgIncaricoAttByIdPersonaGiuridicaCat(persGiuridica.getIdPersonaGiuridica());

							for (SigitRPgPgNominaDto sigitRPgPgNominaDto : elencoPgImp) {

								PersonaGiuridica persGiuridicaImp = getDbMgr().cercaPersonaGiuridicaById(ConvertUtil.convertToInteger(sigitRPgPgNominaDto.getIdPersonaGiuridicaImpresa()));

								// Controllo se e' un installatore
//								if (GenericUtil.isNotNullOrEmpty(persGiuridicaImp.getFlgInstallatore()) && persGiuridicaImp.getFlgInstallatore())
//								{
//									listaRuoliCompleta.add(creaRuoloPrivatoCat(idRuolo++, persGiuridicaImp, Constants.CAT_RUOLO_INSTALLATORE, persGiuridica.getIdPersonaGiuridica(), persGiuridica.getDenominazione()));
//								}

								// Controllo se e' un impresa
								if (GenericUtil.isNotNullOrEmpty(persGiuridicaImp.getFlgDm37LetteraC()) && persGiuridicaImp.getFlgDm37LetteraC())
								{
									listaRuoliCompleta.add(creaRuoloPrivatoCat(idRuolo++, persGiuridicaImp, Constants.CAT_RUOLO_IMPRESA, persGiuridica.getIdPersonaGiuridica(), persGiuridica.getDenominazione()));
								}

								// Controllo se e' un amministratore
								if (GenericUtil.isNotNullOrEmpty(persGiuridicaImp.getFlgAmministratore()) && persGiuridicaImp.getFlgAmministratore())
								{
									listaRuoliCompleta.add(creaRuoloPrivatoCat(idRuolo++, persGiuridicaImp, Constants.CAT_RUOLO_RESPONSABILE_IMPRESA, persGiuridica.getIdPersonaGiuridica(), persGiuridica.getDenominazione()));
								}

								// Controllo se e' un terzo responsabile
								if (GenericUtil.isNotNullOrEmpty(persGiuridicaImp.getFlgTerzoResponsabile()) && persGiuridicaImp.getFlgTerzoResponsabile())
								{
									listaRuoliCompleta.add(creaRuoloPrivatoCat(idRuolo++, persGiuridicaImp, Constants.CAT_RUOLO_3RESPONSABILE, persGiuridica.getIdPersonaGiuridica(), persGiuridica.getDenominazione()));
								}

								// Controllo se e' un distributore
								if (GenericUtil.isNotNullOrEmpty(persGiuridicaImp.getFlgDistributore()) && persGiuridicaImp.getFlgDistributore())
								{
									listaRuoliCompleta.add(creaRuoloPrivatoCat(idRuolo++, persGiuridicaImp, Constants.CAT_RUOLO_DISTRIBUTORE, persGiuridica.getIdPersonaGiuridica(), persGiuridica.getDenominazione()));
								}

							}


						}


					}

					//altro for per cat

				}
			}
		}
		catch(Exception e) {

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		log.debug("[SigitMgr::getListaRuoli] END");
		return listaRuoliCompleta;
	}

	public ArrayList<Ruolo> getRuoliFiltroDaRuoliTrovati(ArrayList<Ruolo> ruoliTrovati) {
		ArrayList<Ruolo> ruoliFiltro = new ArrayList<Ruolo>();

		ArrayList<String> denomRuoliTrovati = new ArrayList<String>();

		for (Ruolo ruolo : ruoliTrovati) {

			String denomRuolo = ruolo.getDenomDitta();

			if (denomRuoliTrovati.indexOf(denomRuolo) == -1 && !StringUtils.isEmpty(denomRuolo)) {
				denomRuoliTrovati.add(denomRuolo);
				ruoliFiltro.add(ruolo);
			}
		}

		Collections.sort(ruoliFiltro, ComparatorUtil.compareDenomDittaRuoli());

		Ruolo visualizzaTutti = new Ruolo();
		visualizzaTutti.setDenomDitta(Constants.RIMUOVI_FILTRO_RUOLO);

		ruoliFiltro.add(0, visualizzaTutti);

		return ruoliFiltro;
	}

//	public PersonaGiuridica cercaInstallatore(Impianto impianto) throws DbManagerException {
//		log.debug("[SigitMgr::cercaInstallatore] BEGIN");
//		PersonaGiuridica installatore = getDbMgr().cercaPersonaGiuridica(impianto.getInstCf(), impianto.getInstIdSiglaRea(), impianto.getInstNumeroRea());
//
//
//		log.debug("[SigitMgr::cercaInstallatore] END");
//		return installatore;
//	}

	/*
	public ArrayList<CodeDescription> getListaTitoliResponsabile() throws ServiceException{
		log.debug("[SigitMgr::getListaTitoliResponsabile] BEGIN");
		try{

			ArrayList<CodeDescription> titoli = new ArrayList<CodeDescription>();

			CodeDescription titolo = new CodeDescription();
			titolo.setCode(ConvertUtil.convertToString(Constants.ID_RUOLO_PROPRIETARIO));
			titolo.setDescription(getDbMgr().cercaDescRuoloById(Constants.ID_RUOLO_PROPRIETARIO));
			titoli.add(titolo);

			titolo = new CodeDescription();
			titolo.setCode(ConvertUtil.convertToString(Constants.ID_RUOLO_OCCUPANTE));
			titolo.setDescription(getDbMgr().cercaDescRuoloById(Constants.ID_RUOLO_OCCUPANTE));
			titoli.add(titolo);

			titolo = new CodeDescription();
			titolo.setCode(ConvertUtil.convertToString(Constants.ID_RUOLO_AMMINISTRATORE));
			titolo.setDescription(getDbMgr().cercaDescRuoloById(Constants.ID_RUOLO_AMMINISTRATORE));
			titoli.add(titolo);


			return titoli;
		}
		catch (Exception e) {
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally{
			log.debug("[SigitMgr::getListaTitoliResponsabile] END");
		}
	}
	*/
	public ArrayList<Responsabile> cercaResponsabiliByCodReaCodFiscaleDenominazione(Responsabile dto) throws ManagerException {
		log.debug("[SigitMgr::cercaResponsabiliByCodReaCodFiscaleDenominazione] BEGIN");
		try {


			//dto = getDbMgr().cercaResponsabileByCodiceFiscale(dto);
			//dto.setFromRicerca(true);


			ArrayList<Responsabile> listaPersone = new ArrayList<Responsabile>();

			List<SigitVPfPgDto> listaPersonaDB = new ArrayList<SigitVPfPgDto>();

			listaPersonaDB = getDbMgr().cercaPersonaByFilter(dto.getIdSiglaRea(), ConvertUtil.convertToBigDecimal(dto.getNumeroRea()), dto.getCodiceFiscale(), dto.getCognome(), dto.getFlgImpresa());

			/*
			// Beppe - commnetanto il 21/11/19, se l'utente setta pi� parametri vado in AND
			if (GenericUtil.isNotNullOrEmpty(dto.getIdSiglaRea()) && GenericUtil.isNotNullOrEmpty(dto.getNumeroRea()))
			{
				listaPersonaDB = getDbMgr().cercaPersonaByCodiceRea(dto.getIdSiglaRea(), ConvertUtil.convertToBigDecimal(dto.getNumeroRea()), dto.getFlgImpresa());
			}
			else if (GenericUtil.isNotNullOrEmpty(dto.getCodiceFiscale()))
			{
				listaPersonaDB = getDbMgr().cercaPersonaByCodiceFiscale(dto.getCodiceFiscale(), dto.getFlgImpresa());
			}
			else if (GenericUtil.isNotNullOrEmpty(dto.getCognome()))
			{
				listaPersonaDB = getDbMgr().cercaPersonaByDenominazione(dto.getCognome(), dto.getFlgImpresa());
			}
			*/

			for (SigitVPfPgDto sigitVPfPgDto : listaPersonaDB) {

				listaPersone.add(MapDto.mapToResponsabile(sigitVPfPgDto));
			}

//
//			if (GenericUtil.isNotNullOrEmpty(dto.getIdSiglaRea()) && GenericUtil.isNotNullOrEmpty(dto.getNumeroRea()))
//			{
//				List<SigitTPersonaGiuridicaDto> listaPersonaDB = getDbMgr().cercaPersonaGiuridicaByCodiceRea(dto.getIdSiglaRea(), ConvertUtil.convertToBigDecimal(dto.getNumeroRea()));
//
//				for (SigitTPersonaGiuridicaDto sigitTPersonaGiuridicaDto : listaPersonaDB) {
//
//					listaPersone.add(MapDto.mapToResponsabile(sigitTPersonaGiuridicaDto));
//				}
//			}
//			else
//			{
//
//			}
			return listaPersone;
		}
		finally {
			log.debug("[SigitMgr::cercaResponsabiliByCodReaCodFiscaleDenominazione] END");
		}
	}

	public Responsabile cercaResponsabileByRespSelez(RisultatoRicResponsabile responsabileSelez) throws ManagerException {
		log.debug("[SigitMgr::cercaResponsabileByRespSelez] BEGIN");
		try {

			Responsabile responsabile = null;


			Integer idPersona = responsabileSelez.getIdPersona();

			if (responsabileSelez.getIsImpresa().equalsIgnoreCase(Constants.LABEL_SI))
			{
				// E' una persona giuridica

				SigitTPersonaGiuridicaDto personaG = getDbMgr().cercaTPersonaGiuridicaById(idPersona);

				List<SigitRPfPgDelegaDto> deleghePG = cercaDelegheAccreditoAByidPersonaGiuridica(ConvertUtil.convertToBigDecimal(idPersona));

				responsabile = MapDto.mapToResponsabile(personaG, responsabileSelez, deleghePG);
			}
			else
			{
				// E' una persona fisica

				SigitTPersonaFisicaDto personaF = getDbMgr().cercaTPersonaFisicaById(idPersona);

				responsabile = MapDto.mapToResponsabile(personaF, responsabileSelez);
			}

			return responsabile;
		}
		finally {
			log.debug("[SigitMgr::cercaResponsabileByRespSelez] END");
		}
	}

	public Responsabile cercaResponsabileAttivoByIdImpianto(Integer idImpianto) throws ManagerException {
		log.debug("[SigitMgr::cercaResponsabileByRespSelez] BEGIN");
		try {

			RisultatoRicResponsabile responsabileSelez = getDbMgr().cercaResponsabileAttivoByIdImpianto(idImpianto);
			Responsabile responsabile = null;

			if (responsabileSelez != null) {
				if (responsabileSelez.getIsImpresa().equalsIgnoreCase(Constants.LABEL_SI))
				{
					// E' una persona giuridica

					SigitTPersonaGiuridicaDto personaG = getDbMgr().cercaTPersonaGiuridicaById(responsabileSelez.getIdPersona());

					List<SigitRPfPgDelegaDto> deleghePG = cercaDelegheAccreditoAByidPersonaGiuridica(ConvertUtil.convertToBigDecimal(responsabileSelez.getIdPersona()));

					responsabile = MapDto.mapToResponsabile(personaG, responsabileSelez, deleghePG);
				}
				else
				{
					// E' una persona fisica

					SigitTPersonaFisicaDto personaF = getDbMgr().cercaTPersonaFisicaById(responsabileSelez.getIdPersona());

					responsabile = MapDto.mapToResponsabile(personaF, responsabileSelez);
				}
			}


			return responsabile;
		}
		finally {
			log.debug("[SigitMgr::cercaResponsabileByRespSelez] END");
		}
	}

	public List<SigitRPfPgDelegaDto> cercaDelegheAccreditoAByidPersonaGiuridica(BigDecimal idPersonaGiuridica) throws DbManagerException {
		SigitRPfPgDelegaDto filter = new SigitRPfPgDelegaDto();
		filter.setIdPersonaGiuridica(idPersonaGiuridica);
		filter.setFlgDelega(Constants.FLAG_ACCREDITATO_A);

		return getDbMgr().cercaSigitRPfPgDelegaAttByFilter(filter);
	}

	public PersonaGiuridica cercaPersonaGiuridica(String codiceFiscale, String siglaRea, UDTPositiveInteger numeroRea) throws ManagerException {
		log.debug("[SigitMgr::cercaPersonaGiuridica] BEGIN");
		PersonaGiuridica obj = null;
		try
		{
			obj = cercaPersonaGiuridica(codiceFiscale, siglaRea, numeroRea, true);
		}
		finally {
			log.debug("[SigitMgr::cercaPersonaGiuridica] END");
		}
		return obj;
	}

	/**
	 * Cerca un manutentore nel DB
	 *
	 * @param codiceFiscale Codice fiscale dell'installatore
	 * @param siglaRea Sigla REA dell'installatore
	 * @param numeroRea Numero REA dell'installatore
	 * @return PersonaGiuridica trovata, null se non trovato
	 * @throws DbManagerException Errore durante il recupero della
	 *             persona giuridica
	 */
	public PersonaGiuridica cercaPersonaGiuridica(String codiceFiscale, String siglaRea, UDTPositiveInteger numeroRea, boolean flgDm37LetteraC) throws ManagerException {
		log.debug("[SigitMgr::cercaPersonaGiuridica] BEGIN");
		PersonaGiuridica obj = null;

		List<SigitTPersonaGiuridicaDto> dtoList = null;
		SigitTPersonaGiuridicaDto dto = null;
//		BigDecimal numRea = null;
//
//		if(GenericUtil.isNotNullOrEmpty(numeroRea)) {
//			numRea = new BigDecimal(numeroRea);
//		}

		try {
			dtoList = getDbMgr().cercaPersonaGiuridica(codiceFiscale, siglaRea, ConvertUtil.convertToBigDecimal(numeroRea), flgDm37LetteraC);

			log.debug("fraaaaaaaaaaaaaaaaaa il dtoList : "+dtoList);

			if (dtoList !=null && dtoList.size() > 1)
			{
				throw new ValidationManagerException(new Message(Messages.I001));
			}
			else
			{
				// Ho trovato un solo manutentore, non e' detto se il codice fiscale e' errato
				if(dtoList.size() == 1)
					dto = dtoList.get(0);
			}


			/*
			if((dtoList != null) && (dtoList.size() > 0)) {

				// Nel caso in cui la ricerca abbia dato come risultato piu' di un elemento,
				// bisognerebbe prevedere una pagina di selezione dell'elemento desiderato, ma per motivi di tempo (e visto che questo metodo viene richiamato in molti punti),
				// prendo il primo che abbia data_cessazione = null, nel caso in cui tutti i manutentori siano cessati prendo l'elemento ZERO

				// Verifico quanti ce ne sono attivi, se piu' di uno rilancio eccezione
				if (dtoList.size() > 1)
				{
					for (SigitTPersonaGiuridicaDto sigitTPersonaGiuridicaDto : dtoList) {
						// Cerco il primo manutentore che non sia dismesso
						if (sigitTPersonaGiuridicaDto != null && sigitTPersonaGiuridicaDto.getDataCessazione() == null)
						{
							// se dto != null vuol dire che ci sono piu' installatori attivi
							if (dto != null)
							{
								throw new ValidationManagerException(new Message(Messages.I001));
							}
							dto = sigitTPersonaGiuridicaDto;
						}
					}

					// Tutti i manutentori della lista sono dismessi, quindi prendo il primo
					if (dto == null)
					{
						dto = dtoList.get(0);
					}
				}
				else
				{
					// Ho trovato un solo manutentore
					dto = dtoList.get(0);
				}
			}
			*/
			if (dto != null)
			{
				obj = MapDto.mapToPersonaGiuridica(dto);
			}
		}
		finally {
			log.debug("[SigitMgr::cercaPersonaGiuridica] END");
		}
		return obj;
	}

	/**
	 * Cerca un manutentore nel DB
	 *
	 * @param codiceFiscale Codice fiscale dell'installatore
	 * @param siglaRea Sigla REA dell'installatore
	 * @param numeroRea Numero REA dell'installatore
	 * @return PersonaGiuridica trovata, null se non trovato
	 * @throws DbManagerException Errore durante il recupero della
	 *             persona giuridica
	 */
	public ArrayList<PersonaGiuridica> cercaImpreseByParam(RicercaImprese ricImpresa) throws ManagerException {
		log.debug("[SigitMgr::cercaPersonaGiuridica] BEGIN");
		PersonaGiuridica obj = null;

		ArrayList<PersonaGiuridica> dtoList = new ArrayList<PersonaGiuridica>();

		try {
			List<SigitTPersonaGiuridicaByParamDto> dtoPgList = getDbMgr().cercaImpreseByParam(ricImpresa);

			if (dtoPgList != null && dtoPgList.size() > 0)
			{
				for (SigitTPersonaGiuridicaByParamDto sigitTPersonaGiuridicaByParamDto : dtoPgList) {
					dtoList.add(MapDto.mapToPersonaGiuridica(sigitTPersonaGiuridicaByParamDto));
				}
			}
		}
		finally {
			log.debug("[SigitMgr::cercaPersonaGiuridica] END");
		}
		return dtoList;
	}


	public ArrayList<PersonaGiuridica> cercaIncarichiCatAttivi(Integer idCat) throws ManagerException {
		log.debug("[SigitMgr::cercaIncarichiCatAttivi] BEGIN");

		ArrayList<PersonaGiuridica> dtoList = new ArrayList<PersonaGiuridica>();

		try {
			List<SigitTPersonaGiuridicaDto> dtoPgList = getDbMgr().cercaIncarichiAttiviCat(idCat);

			if (dtoPgList != null && dtoPgList.size() > 0)
			{
				for (SigitTPersonaGiuridicaDto sigitTPersonaGiuridicaDto : dtoPgList) {
					dtoList.add(MapDto.mapToPersonaGiuridica(sigitTPersonaGiuridicaDto));
				}
			}
		}
		finally {
			log.debug("[SigitMgr::cercaIncarichiCatAttivi] END");
		}
		return dtoList;
	}

	public ArrayList<CodeDescription> cercaElencoCatAttivi() throws ManagerException {
		log.debug("[SigitMgr::cercaElencoCatAttivi] BEGIN");
		ArrayList<CodeDescription> catList = new ArrayList<CodeDescription>();
		try
		{
			List<SigitTPersonaGiuridicaDto> pgCatList = getDbMgr().cercaPersonaGiuCatAttivi();
			if (pgCatList != null && pgCatList.size() > 0)
			{

				catList = MapDto.mapToCat(pgCatList);

			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::cercaElencoCatAttivi] END");
		}

		return catList;
	}

	public ArrayList<CodeDescription> cercaElencoCat() throws ManagerException {
		log.debug("[SigitMgr::cercaElencoCat] BEGIN");
		ArrayList<CodeDescription> catList = new ArrayList<CodeDescription>();
		try
		{
			List<SigitTPersonaGiuridicaDto> pgCatList = getDbMgr().cercaPersonaGiuCat();
			if (pgCatList != null && pgCatList.size() > 0)
			{

				catList = MapDto.mapToCat(pgCatList);

			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::cercaElencoCat] END");
		}

		return catList;
	}

	public Integer cercaElencoCodiciCount(RicercaTransazione ricCodici) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoCodiciCount] BEGIN");
		Integer count = 0;

		try
		{
			TransazioneFilter filter = new TransazioneFilter(ConvertUtil.convertToInteger(ricCodici.getCodiceImpianto()), ricCodici.getIdSiglaRea(), ConvertUtil.convertToInteger(ricCodici.getNumeroRea()), ricCodici.getCodiceFiscale(), ConvertUtil.convertToSqlDate(ricCodici.getDataAcquisizioneDa()), ConvertUtil.convertToSqlDate(ricCodici.getDataAcquisizioneA()));

			count = getDbMgr().cercaCodiciImpiantoByFiltroCount(filter);

		}
		finally {
			log.debug("[SigitMgr::cercaElencoCodiciCount] END");
		}

		return count;
	}


	/*
	public ArrayList<RisultatoRicTransazione> cercaElencoCodici(RicercaTransazione ricCodici) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoCodici] BEGIN");
		ArrayList<RisultatoRicTransazione> risRicCodImpiantoList = new ArrayList<RisultatoRicTransazione>();

		try
		{
			TransazioneFilter filter = new TransazioneFilter(ConvertUtil.convertToInteger(ricCodici.getCodiceImpianto()), ricCodici.getIdSiglaRea(), ConvertUtil.convertToInteger(ricCodici.getNumeroRea()), ricCodici.getCodiceFiscale(), ConvertUtil.convertToSqlDate(ricCodici.getDataAcquisizioneDa()), ConvertUtil.convertToSqlDate(ricCodici.getDataAcquisizioneA()));


			List<SigitTTransazioneImpByTransazioneFilterDto> dtoList = getDbMgr().cercaCodiciImpiantoByFiltro(filter);

			// Ho recuperato i codici impianto per i filtri, adesso devo eseguire gli algoritmi

			for (SigitTTransazioneImpByTransazioneFilterDto dto : dtoList) {

				//Integer numCodImpUtilz = getDbMgr().cercaCodiciImpiantoUtilizzatiByIdTransCount(ConvertUtil.convertToInteger(dto.getTranIdTransazione()));

				risRicCodImpiantoList.add(MapDto.mapToRisultatoRicTransazione(dto));

			}

		}
		finally {
			log.debug("[SigitMgr::cercaElencoCodici] END");
		}

		return risRicCodImpiantoList;
	}
	*/

	public ArrayList<RisultatoRicCodImpiantoLib> cercaElencoCodiciLiberi(RisultatoRicTransazione risRicCodImpianto, Integer idTransazione) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoCodici] BEGIN");
		ArrayList<RisultatoRicCodImpiantoLib> risRicCodImpiantolibList = new ArrayList<RisultatoRicCodImpiantoLib>();

		try
		{

//			List<SigitTCodiceImpDto> dtoList = getDbMgr().cercaCodiciImpiantoLiberiByIdTrans(idTransazione);
//
//			for (SigitTCodiceImpDto sigitTCodiceImpDto : dtoList) {
//
//				risRicCodImpiantolibList.add(MapDto.mapToRisultatoRicCodImpiantoLib(risRicCodImpianto, sigitTCodiceImpDto));
//			}

		}
		finally {
			log.debug("[SigitMgr::cercaElencoCodici] END");
		}

		return risRicCodImpiantolibList;
	}

	public Integer cercaElencoBolliniCount(RicercaTransazione ricCodici) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoBolliniCount] BEGIN");
		Integer count = 0;

		try
		{
			TransazioneFilter filter = new TransazioneFilter(ricCodici.getSiglaBollino(), ConvertUtil.convertToInteger(ricCodici.getNumeroBollino()), ricCodici.getIdSiglaRea(), ConvertUtil.convertToInteger(ricCodici.getNumeroRea()), ricCodici.getCodiceFiscale(), ConvertUtil.convertToSqlDate(ricCodici.getDataAcquisizioneDa()), ConvertUtil.convertToSqlDate(ricCodici.getDataAcquisizioneA()));

			count = getDbMgr().cercaBolliniByFiltroCount(filter);

		}
		finally {
			log.debug("[SigitMgr::cercaElencoBolliniCount] END");
		}

		return count;
	}

	/*
	public ArrayList<RisultatoRicTransazione> cercaElencoBollini(RicercaTransazione ricCodici) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoBollini] BEGIN");
		ArrayList<RisultatoRicTransazione> risRicBolliniList = new ArrayList<RisultatoRicTransazione>();

		try
		{
			TransazioneFilter filter = new TransazioneFilter(ricCodici.getSiglaBollino(), ConvertUtil.convertToInteger(ricCodici.getNumeroBollino()), ricCodici.getIdSiglaRea(), ConvertUtil.convertToInteger(ricCodici.getNumeroRea()), ricCodici.getCodiceFiscale(), ConvertUtil.convertToSqlDate(ricCodici.getDataAcquisizioneDa()), ConvertUtil.convertToSqlDate(ricCodici.getDataAcquisizioneA()));


			List<SigitTTransazioneBollByTransazioneFilterDto> dtoList = getDbMgr().cercaBolliniByFiltro(filter);

			for (SigitTTransazioneBollByTransazioneFilterDto dto : dtoList) {


				risRicBolliniList.add(MapDto.mapToRisultatoRicTransazione(dto));

			}



		}
		finally {
			log.debug("[SigitMgr::cercaElencoBollini] END");
		}

		return risRicBolliniList;
	}
	*/

//	public AcquistoBollini settaPrezziBollino(AcquistoBollini acquistoBoll) throws ManagerException {
//		log.debug("[SigitMgr::settaPrezziBollino] BEGIN");
//
//		try
//		{
//
//			List<SigitVPotenzaPrezzoDto> dtoList = getDbMgr().cercaPrezziBollino();
//
//			for (SigitVPotenzaPrezzoDto dto : dtoList)
//			{
//
//				int idPotenza = dto.getIdPotenza().intValue();
//				String descPotenza = null;
//				descPotenza = MapDto.getDescrizioneComplPotenza(dto.getDesPotenza(), dto.getPrezzo());
//
//				log.debug("STAMPO LA DESCRIZIONE POTENZA: "+descPotenza);
//
//				switch (idPotenza) {
//				case Constants.ID_POTENZA_MINORE_35:
//					acquistoBoll.setDescMinore35(descPotenza);
//					acquistoBoll.setPrezzoMinore35(dto.getPrezzo().doubleValue());
//					break;
//				case Constants.ID_POTENZA_35_116:
//					acquistoBoll.setDesc35_116(descPotenza);
//					acquistoBoll.setPrezzo35_116(dto.getPrezzo().doubleValue());
//					break;
//				case Constants.ID_POTENZA_116_350:
//					acquistoBoll.setDesc116_350(descPotenza);
//					acquistoBoll.setPrezzo116_350(dto.getPrezzo().doubleValue());
//					break;
//				case Constants.ID_POTENZA_MAGGIORE_350:
//					acquistoBoll.setDescMaggiore350(descPotenza);
//					acquistoBoll.setPrezzoMaggiore350(dto.getPrezzo().doubleValue());
//					break;
//
//				}
//			}
//		}
//		finally {
//			log.debug("[SigitMgr::settaPrezziBollino] END");
//		}
//
//		return acquistoBoll;
//	}

	public ArrayList<AcquistoBolliniQuantita> settaPrezziBollino(AcquistoBollini acquistoBoll) throws ManagerException {
		log.debug("[SigitMgr::settaPrezziBollino] BEGIN");

		ArrayList<AcquistoBolliniQuantita> acqBolliniQtaList = new ArrayList<AcquistoBolliniQuantita>();

		try
		{

			List<SigitVPotenzaPrezzoDto> dtoList = getDbMgr().cercaPrezziBollino();

			AcquistoBolliniQuantita acqBolliniQta = null;
			for (SigitVPotenzaPrezzoDto dto : dtoList)
			{

				acqBolliniQta = new AcquistoBolliniQuantita();

				acqBolliniQta.setIdPotenza(ConvertUtil.convertToInteger(dto.getIdPotenza()));
				acqBolliniQta.setDescrizione(MapDto.getDescrizioneComplPotenza(dto.getDesPotenza(), dto.getPrezzo()));
				acqBolliniQta.setIdPrezzo(ConvertUtil.convertToInteger(dto.getIdPrezzo()));
				acqBolliniQta.setPrezzo(dto.getPrezzo().doubleValue());
				acqBolliniQta.setDataInizioAcquisto(ConvertUtil.convertToString(dto.getDtInizio()));
				acqBolliniQtaList.add(acqBolliniQta);

			}
		}
		finally {
			log.debug("[SigitMgr::settaPrezziBollino] END");
		}

		return acqBolliniQtaList;
	}
	public Integer cercaElencoImpiantiCount(RicercaImpianti ricImpianti, String descRuolo) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoImpiantiCount] BEGIN");
		Integer count = 0;
		try
		{
			ImpiantoFilter filter = MapDto.mapToImpiantoFilter(ricImpianti, descRuolo);

			count = getDbMgr().cercaImpiantoByFiltroCount(filter);

		}
		finally {
			log.debug("[SigitMgr::cercaElencoImpiantiCount] END");
		}

		return count;
	}

	public ArrayList<RisultatoRicImpianto> cercaElencoImpianti(RicercaImpianti ricImpianti, String descRuolo) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoImpianti] BEGIN");
		ArrayList<RisultatoRicImpianto> risRicImpiantoList = new ArrayList<RisultatoRicImpianto>();

		try
		{
			ImpiantoFilter filter = MapDto.mapToImpiantoFilter(ricImpianti, descRuolo);

			// Step 1 - recupero i codici impianto e l'indirizzo
			//TODO: Sostituire il metodo cercaImpiantoByFiltro con il metodo getImpiantiByFiltroJWT
			//		creato su sigitext, quindi per farlo richiamare il servizio nuovo creato
			List<SigitVRicercaImpiantiDto> dtoList = getDbMgr().cercaImpiantoByFiltro(filter);

			RisultatoRicImpianto obj = null;
			for (SigitVRicercaImpiantiDto sigitVRicercaImpiantiDto : dtoList) {


				obj = new RisultatoRicImpianto();

//				log.debug("STAMPO il CODICE IMPIANTO DB: "+sigitVRicercaImpiantiDto.getCodiceImpianto());

				obj.setCodiceImpianto(ConvertUtil.convertToString(sigitVRicercaImpiantiDto.getCodiceImpianto()));

//				log.debug("STAMPO il CODICE IMPIANTO OBJ: "+obj.getCodiceImpianto());

				obj.setDescComune(MapDto.getComuneProvincia(ReplaceSpecialCharUtils.sanitize(sigitVRicercaImpiantiDto.getDenominazioneComune()), ReplaceSpecialCharUtils.sanitize(sigitVRicercaImpiantiDto.getSiglaProvincia())));
				obj.setIndirizzo(MapDto.getIndirizzo(ReplaceSpecialCharUtils.sanitize(sigitVRicercaImpiantiDto.getIndirizzoUnitaImmob()), ReplaceSpecialCharUtils.sanitize(sigitVRicercaImpiantiDto.getCivico())));
				obj.setDescIndirizzoCompleto(MapDto.getIndirizzoCompleto(ReplaceSpecialCharUtils.sanitize(sigitVRicercaImpiantiDto.getDenominazioneComune()), ReplaceSpecialCharUtils.sanitize(sigitVRicercaImpiantiDto.getIndirizzoUnitaImmob()), 
						ReplaceSpecialCharUtils.sanitize(sigitVRicercaImpiantiDto.getCivico()), ReplaceSpecialCharUtils.sanitize(sigitVRicercaImpiantiDto.getSiglaProvincia())));

				obj.setDenomResponsabile(ReplaceSpecialCharUtils.sanitize(sigitVRicercaImpiantiDto.getDenominazioneResponsabile()));
				obj.setDenom3Responsabile(ReplaceSpecialCharUtils.sanitize(sigitVRicercaImpiantiDto.getDenominazione3Responsabile()));

				obj.setStatoImpianto(ReplaceSpecialCharUtils.sanitize(sigitVRicercaImpiantiDto.getDesStato()));
				risRicImpiantoList.add(obj);
			}

		}
		finally {
			log.debug("[SigitMgr::cercaElencoImpianti] END");
		}

		return risRicImpiantoList;
	}

	public ArrayList<RisultatoRicImpianto> ricercaElencoImpiantiWS(RicercaImpianti ricImpianti, UtenteLoggato utente) throws ServiceException {
		log.debug("[SigitMgr::ricercaElencoImpiantiWS] BEGIN");
		ArrayList<RisultatoRicImpianto> risRicImpiantoList = new ArrayList<RisultatoRicImpianto>();

		ImpiantoFiltro impiantoFiltro = MapDto.mapToImpiantoFiltro(ricImpianti, utente.getRuolo().getDescRuolo());

		it.csi.sigit.sigitext.dto.sigitext.Impianto[] dtoList = getServiziMgr().getImpiantoByFiltroJWT(impiantoFiltro, utente);

		RisultatoRicImpianto obj = null;
		for (it.csi.sigit.sigitext.dto.sigitext.Impianto impianto : dtoList) {

			obj = new RisultatoRicImpianto();

			obj.setCodiceImpianto(ConvertUtil.convertToString(impianto.getCodiceImpianto()));
			obj.setDescComune(MapDto.getComuneProvincia(impianto.getDescComune(), impianto.getSiglaProv()));
			obj.setIndirizzo(MapDto.getIndirizzo(impianto.getIndirizzo(), impianto.getCivico()));
			obj.setDescIndirizzoCompleto(MapDto.getIndirizzoCompleto(impianto.getDescComune(), impianto.getIndirizzo(), impianto.getCivico(), impianto.getSiglaProv()));
			obj.setDenomResponsabile(impianto.getDenomResponsabile());
			obj.setDenom3Responsabile(impianto.getDenom3Responsabile());
			obj.setStatoImpianto(impianto.getStato());

			risRicImpiantoList.add(obj);
		}

		log.debug("[SigitMgr::ricercaElencoImpiantiWS] END");

		return risRicImpiantoList;
	}

	public RisultatoRicImpianto cercaImpianto(String codiceImpianto, String descRuolo) throws ManagerException {
		log.debug("[SigitMgr::cercaImpianto] BEGIN");
		RisultatoRicImpianto obj = null;

		try
		{
			ImpiantoFilter filter = new ImpiantoFilter();

			filter.setCodiceImpianto(ConvertUtil.convertToInteger(codiceImpianto));
			filter.setDescRuoloFuonz(descRuolo);


			// Step 1 - recupero l'impianto, siccome passo il codiceImpianto mi ritorner� solo un risultato
			List<SigitVRicercaImpiantiDto> dtoList = getDbMgr().cercaImpiantoByFiltro(filter);

			for (SigitVRicercaImpiantiDto sigitVRicercaImpiantiDto : dtoList) {


				obj = new RisultatoRicImpianto();

//				log.debug("STAMPO il CODICE IMPIANTO DB: "+sigitVRicercaImpiantiDto.getCodiceImpianto());

				obj.setCodiceImpianto(ConvertUtil.convertToString(sigitVRicercaImpiantiDto.getCodiceImpianto()));

//				log.debug("STAMPO il CODICE IMPIANTO OBJ: "+obj.getCodiceImpianto());

				obj.setDescComune(MapDto.getComuneProvincia(sigitVRicercaImpiantiDto.getDenominazioneComune(), sigitVRicercaImpiantiDto.getSiglaProvincia()));
				obj.setIndirizzo(MapDto.getIndirizzo(sigitVRicercaImpiantiDto.getIndirizzoUnitaImmob(), sigitVRicercaImpiantiDto.getCivico()));
				obj.setDescIndirizzoCompleto(MapDto.getIndirizzoCompleto(sigitVRicercaImpiantiDto.getDenominazioneComune(), sigitVRicercaImpiantiDto.getIndirizzoUnitaImmob(), sigitVRicercaImpiantiDto.getCivico(), sigitVRicercaImpiantiDto.getSiglaProvincia()));

				obj.setDenomResponsabile(sigitVRicercaImpiantiDto.getDenominazioneResponsabile());
				obj.setDenom3Responsabile(sigitVRicercaImpiantiDto.getDenominazione3Responsabile());

				obj.setStatoImpianto(sigitVRicercaImpiantiDto.getDesStato());
			}

		}
		finally {
			log.debug("[SigitMgr::cercaImpianto] END");
		}

		return obj;
	}


	public ArrayList<DettaglioTerzoResponsabile> cercaTutti3ResponsabiliByCodImp(String codiceImpianto, String descRuolo) throws ManagerException {
		log.debug("[SigitMgr::cercaTutti3ResponsabiliByCodImp] BEGIN");
		ArrayList<DettaglioTerzoResponsabile> dettaglioTerzoResponsabileList = new ArrayList<DettaglioTerzoResponsabile>();

		try
		{

			// recupero tutti i 3 responsabili dell'impianto
			List<SigitExtContrattoImpDto> dtoList = getDbMgr().cerca3ResponsabileByCodImpianto(codiceImpianto);
			SigitTUnitaImmobiliareDto unitaImmobiliare = getDbMgr().cercaSigitTUnitaImmobiliareByCodImpianto(codiceImpianto);
			if (dtoList != null && dtoList.size() > 0)
			{
				boolean isValSup = descRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER) ||	descRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE)
						|| descRuolo.equalsIgnoreCase(Constants.RUOLO_ISPETTORE) || descRuolo.equalsIgnoreCase(Constants.RUOLO_CONSULTATORE);

				SigitExtContrattoImpDto dtoOld = null;

				for (int i = 0; i < dtoList.size(); i++)
				{
					SigitExtContrattoImpDto dtoNew = dtoList.get(i);

					if (dtoOld != null)
					{
						if (dtoOld.getIdContratto().intValue() != dtoNew.getIdContratto().intValue())
						{
							dettaglioTerzoResponsabileList.add(MapDto.mapToDettaglio3Responsabile(dtoOld, isValSup, unitaImmobiliare));
						}
					}

					dtoOld = dtoNew;

				}

				dettaglioTerzoResponsabileList.add(MapDto.mapToDettaglio3Responsabile(dtoOld, isValSup, unitaImmobiliare));
			}
		}
		finally {
			log.debug("[SigitMgr::cercaTutti3ResponsabiliByCodImp] END");
		}

		return dettaglioTerzoResponsabileList;
	}

	@Transactional
	public ResultInvioMail eliminaImpianto(String codImpianto, String cfUtenteMod) throws ManagerException {
		log.debug("[SigitMgr::eliminaImpianto] BEGIN");

		ResultInvioMail resultInvioMail = null;

		try
		{
			Integer codiceImpianto = ConvertUtil.convertToInteger(codImpianto);
			//List<SigitTAllRespintoDto> allegatiRespinti = getDbMgr().getAllegatiRespintiImpianto(codiceImpianto);

			List<SigitTDocAggiuntivaDto> docList = getDbMgr().cercaDocumentoByCodImpianto(codiceImpianto);

			SigitVTotImpiantoDto datiImpianto = getDbMgr().cercaResponsabileAttivoByCodImpianto(codiceImpianto);
			getDbMgr().eliminaImpianto(codImpianto, cfUtenteMod);

			for (SigitTDocAggiuntivaDto sigitTDocAggiuntivaDto : docList) {
				try
				{
					getServiziMgr().indexDeleteContentByUid(sigitTDocAggiuntivaDto.getUidIndex());
				}
				catch (Exception e)
				{
					// Non faccio niente, proseguo con l'esecuzione
				}
			}

			/*
			if(allegatiRespinti!=null && !allegatiRespinti.isEmpty())
			{
				log.debug("Cancellazione allegati da INDEX");
				Metadati metadati = new Metadati();
				metadati.setCodIstatProvincia(StringUtils.substring(datiImpianto.getIstatComune(), 0, 3));
				metadati.setCodIstatComune(datiImpianto.getIstatComune());
				metadati.setCodiceImpianto(codImpianto);
				for (SigitTAllRespintoDto allegato : allegatiRespinti) {
					if(GenericUtil.isNotNullOrEmpty(allegato.getUidIndex()))
					{
						log.debug("Cancellazione file da index: " + allegato.getUidIndex());
						getServiziMgr().indexDeleteContent(allegato.getUidIndex(), metadati);
					}
				}
			}
			*/

			//dcosta: mev reignerizzazione viste. la porzione di codice sottostante che riguarda l'invio mail al terzo responsabile viene commentata
			//poich� non � possibile eliminare un impianto con un libretto CONSOLIDATO. il terzo responsabile pu� esistere solo in caso di libretto CONSOLIDATO
			//quindi questa porzione di codice non verrebbe mai invocata
			/*if(datiImpianto != null && GenericUtil.isNotNullOrEmpty(datiImpianto.getIdPersonaGiuridica3r()))
			{
				PersonaGiuridica pg = getDbMgr().cercaPersonaGiuridicaById(ConvertUtil.convertToInteger(datiImpianto.getIdPersonaGiuridica3r()));

				// Valutare se mandare anche al responsabile con cui e' stato fatto il contratto di terza responsabilita' la mail!!!

				if(GenericUtil.isNotNullOrEmpty(pg.getEmail()))
					resultInvioMail = inviaEmailCancellazioneImpianto(codImpianto, pg.getEmail());
				else
					log.debug("Email pg " + pg.getIdPersonaGiuridica() + " non settata");
			}*/
		}
		catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[SigitMgr::eliminaImpianto] END");
		}

		return resultInvioMail;
	}

	private ResultInvioMail inviaEmailCancellazioneImpianto(String codImpianto, String destinatario) throws Exception
	{
		log.debug("inviaEmailCancellazioneImpianto: START");

		log.debug("desctinatario: " + destinatario);
		try {
			String oggetto = "CIT:  cancellazione impianto " + codImpianto;
			StringBuffer testoHtml = new StringBuffer();

			testoHtml.append("L'impianto "+codImpianto+" e' stato cancellato </br>");
			testoHtml.append("N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa email.");

			if (log.isDebugEnabled())
				log.debug("TESTO EMAIL: \n"+testoHtml);

			return getServiziMgr().sendMail(destinatario, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		} catch (ServiceException e) {
			log.error("Errore invio email nomina terzo responsabile", e);
			throw new ManagerException(e, new Message(e.getMessage()));
		}
		finally{
			log.debug("inviaEmailCancellazioneImpianto: END");
		}
	}

	/*
	@Transactional
	public void salvaLibrettoTrans(MODDocument librettoDoc, byte[] datiXml, String cfUtenteMod, String idImpianto) throws ManagerException {
		log.debug("[SigitMgr::salvaLibrettoTrans] BEGIN");

		try
		{
			salvaLibretto(librettoDoc, datiXml, cfUtenteMod, idImpianto);
		}
		catch (Exception e) {
			log.error("Errore: ", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[SigitMgr::salvaLibrettoTrans] END");
		}

	}
	*/
	/*
	public void salvaLibretto(MODDocument librettoDoc, byte[] datiXml, String cfUtenteMod, String idImpianto) throws ManagerException {
		log.debug("[SigitMgr::salvaLibretto] BEGIN");

		try
		{
			Richiesta richiesta = librettoDoc.getMOD().getRichiesta();
			SigitTLibrettoDto librettoDto = new SigitTLibrettoDto();
			librettoDto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(idImpianto));
			librettoDto.setFkStato(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_LIBRETTO_BOZZA));

			SigitTImpiantoDto impiantoDb = getDbMgr().cercaImpiantoDtoById(idImpianto);

			impiantoDb.setFkTipoIntervento(Constants.ID_TIPO_INT_NON_VALORIZZATO);
			if(richiesta.getDatiSchedaIdentificativaImp()!=null)
			{
				if (richiesta.getDatiSchedaIdentificativaImp().getL11FlagNuovaInst())
				{
					impiantoDb.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_INT_NUOVA_INSTALZ));
				}
				else if (richiesta.getDatiSchedaIdentificativaImp().getL11FlagRistrutt())
				{
					impiantoDb.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_INT_RISTRUTTURAZ));
				}
				else if (richiesta.getDatiSchedaIdentificativaImp().getL11FlagSostGenerat())
				{
					impiantoDb.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_INT_SOSTITUZIONE));
				}
				else if (richiesta.getDatiSchedaIdentificativaImp().getL11FlagCompilaLibretto())
				{
					impiantoDb.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_INT_COMPILAZIONE));
				}
			}

			librettoDto.setFkTipoDocumento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_DOC_LIBRETTO));
			librettoDto.setCfRedattore(cfUtenteMod);
			librettoDto.setFlgControlloBozza(BigDecimal.ZERO);
			try{librettoDto.setFlgControlloBozza(ConvertUtil.convertToBigDecimal(richiesta.getDatiModulo().getFlagControlloBozza()));}catch(Exception e){librettoDto.setFlgControlloBozza(null);}

			librettoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
			librettoDto.setUtenteUltMod(cfUtenteMod);
			//salvataggio di tutta la scheda 1 e 14
			try{impiantoDb.setDataIntervento(ConvertUtil.convertToDate(richiesta.getDatiSchedaIdentificativaImp().getL11DataIntervento()));}catch (Exception e) {impiantoDb.setDataIntervento(null);}

			getDbMgr().getSigitTImpiantoDao().update(impiantoDb);

			log.debug("salvaScheda1Libretto");
			salvaScheda1Libretto(idImpianto, richiesta, cfUtenteMod, false);
			log.debug("salvaScheda14Libretto");
			salvaDatiScheda14Libretto(idImpianto, cfUtenteMod, richiesta);

			getDbMgr().salvaLibretto(librettoDto, datiXml);
		}
		catch (Exception e) {
			log.error("Errore: ", e);
			throw new DbManagerException(new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[SigitMgr::salvaLibretto] END");
		}

	}
	*/

	/*
	@Transactional
	public void salvaLibrettoLight(it.csi.sigit.sigitwebn.xml.librettoLight.data.MODDocument librettoDoc, String cfUtenteMod, String idImpianto, String xmlDati, String codiceRea) throws ManagerException {
		log.debug("[SigitMgr::salvaLibretto] BEGIN");

		try
		{
			it.csi.sigit.sigitwebn.xml.librettoLight.data.RichiestaDocument.Richiesta richiesta = librettoDoc.getMOD().getRichiesta();
			SigitTLibrettoDto librettoDto = new SigitTLibrettoDto();
			librettoDto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(idImpianto));
			librettoDto.setFkStato(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_LIBRETTO_BOZZA));

			SigitTImpiantoDto impiantoDb = getDbMgr().cercaImpiantoDtoById(idImpianto);

			impiantoDb.setFkTipoIntervento(Constants.ID_TIPO_INT_NON_VALORIZZATO);
			if(richiesta.getDatiSchedaIdentificativaImp()!=null)
			{
				if (richiesta.getDatiSchedaIdentificativaImp().getL11FlagNuovaInst())
				{
					impiantoDb.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_INT_NUOVA_INSTALZ));
				}
				else if (richiesta.getDatiSchedaIdentificativaImp().getL11FlagRistrutt())
				{
					impiantoDb.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_INT_RISTRUTTURAZ));
				}
				else if (richiesta.getDatiSchedaIdentificativaImp().getL11FlagSostGenerat())
				{
					impiantoDb.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_INT_SOSTITUZIONE));
				}
				else if (richiesta.getDatiSchedaIdentificativaImp().getL11FlagCompilaLibretto())
				{
					impiantoDb.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_INT_COMPILAZIONE));
				}
			}


			librettoDto.setFkTipoDocumento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_DOC_LIBRETTO));
			librettoDto.setCfRedattore(cfUtenteMod);
			librettoDto.setFlgControlloBozza(BigDecimal.ZERO);
			try{librettoDto.setFlgControlloBozza(ConvertUtil.convertToBigDecimal(richiesta.getDatiModulo().getFlagControlloBozza()));}catch(Exception e){librettoDto.setFlgControlloBozza(null);}

			librettoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
			librettoDto.setUtenteUltMod(cfUtenteMod);
			//salvataggio di tutta la scheda 1 e 14
			try{impiantoDb.setDataIntervento(ConvertUtil.convertToDate(richiesta.getDatiSchedaIdentificativaImp().getL11DataIntervento()));}catch (Exception e) {impiantoDb.setDataIntervento(null);}

			getDbMgr().getSigitTImpiantoDao().update(impiantoDb);


			log.debug("salvaScheda1Libretto");
			salvaScheda1LibrettoLight(idImpianto, richiesta, cfUtenteMod);
			log.debug("salvaScheda14Libretto");
			salvaDatiScheda14LibrettoLight(idImpianto, cfUtenteMod, richiesta);

			librettoDto.setFkStato(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_LIBRETTO_BOZZA));
			getDbMgr().salvaLibrettoLight(librettoDto, xmlDati);
			log.debug("Ricerca impiantoDto");
			SigitTImpiantoDto impiantoDto = getDbMgr().cercaImpiantoDtoById(idImpianto);
			log.debug("Consolidamento libretto per motivo: esplicito utente");
			creaPdfEConsolidaLibretto(cfUtenteMod, impiantoDto, codiceRea, librettoDto, Constants.ID_MOTIVO_CONSOLIDAMENTO_ESP_UTENTE);
		}
		catch (Exception e) {
			log.error("Errore: ", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(new Message(e.getMessage()));
		}
		finally {
			log.debug("[SigitMgr::salvaLibretto] END");
		}

	}
	*/

	/*
	@Transactional
	public void salvaLibrettoScheda1_14(it.csi.sigit.sigitwebn.xml.librettoLight.data.MODDocument librettoDoc, String cfUtenteMod, String idImpianto, String xmlDati, String codiceRea) throws ManagerException {
		log.debug("[SigitMgr::salvaLibrettoScheda1_14] BEGIN");

		try
		{
			it.csi.sigit.sigitwebn.xml.librettoLight.data.RichiestaDocument.Richiesta richiesta = librettoDoc.getMOD().getRichiesta();
			SigitTLibrettoDto librettoDto = new SigitTLibrettoDto();
			librettoDto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(idImpianto));
			librettoDto.setFkStato(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_LIBRETTO_BOZZA));
			librettoDto.setFkTipoIntervento(Constants.ID_TIPO_INT_NON_VALORIZZATO);
			if(richiesta.getDatiSchedaIdentificativaImp()!=null)
			{
				if (richiesta.getDatiSchedaIdentificativaImp().getL11FlagNuovaInst())
				{
					librettoDto.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_INT_NUOVA_INSTALZ));
				}
				else if (richiesta.getDatiSchedaIdentificativaImp().getL11FlagRistrutt())
				{
					librettoDto.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_INT_RISTRUTTURAZ));
				}
				else if (richiesta.getDatiSchedaIdentificativaImp().getL11FlagSostGenerat())
				{
					librettoDto.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_INT_SOSTITUZIONE));
				}
				else if (richiesta.getDatiSchedaIdentificativaImp().getL11FlagCompilaLibretto())
				{
					librettoDto.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_INT_COMPILAZIONE));
				}
			}


			librettoDto.setFkTipoDocumento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_DOC_LIBRETTO));
			librettoDto.setCfRedattore(cfUtenteMod);
			librettoDto.setFlgControlloBozza(BigDecimal.ZERO);
			try{librettoDto.setFlgControlloBozza(ConvertUtil.convertToBigDecimal(richiesta.getDatiModulo().getFlagControlloBozza()));}catch(Exception e){librettoDto.setFlgControlloBozza(null);}

			librettoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
			librettoDto.setUtenteUltMod(cfUtenteMod);
			//salvataggio di tutta la scheda 1 e 14
			try{librettoDto.setDataIntervento(ConvertUtil.convertToDate(richiesta.getDatiSchedaIdentificativaImp().getL11DataIntervento()));}catch (Exception e) {librettoDto.setDataIntervento(null);}
			log.debug("salvaScheda1Libretto");
			salvaScheda1LibrettoLight(idImpianto, richiesta, cfUtenteMod);
			log.debug("salvaScheda14Libretto");
			salvaDatiScheda14LibrettoLight(idImpianto, cfUtenteMod, richiesta);

			librettoDto.setFkStato(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_LIBRETTO_BOZZA));
			getDbMgr().salvaLibrettoLight(librettoDto, xmlDati);
			log.debug("Ricerca impiantoDto");
			SigitTImpiantoDto impiantoDto = getDbMgr().cercaImpiantoDtoById(idImpianto);
			log.debug("Consolidamento libretto per motivo: esplicito utente");
			creaPdfEConsolidaLibretto(cfUtenteMod, impiantoDto, codiceRea, librettoDto, Constants.ID_MOTIVO_CONSOLIDAMENTO_ESP_UTENTE);
		}
		catch (Exception e) {
			log.error("Errore: ", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(new Message(e.getMessage()));
		}
		finally {
			log.debug("[SigitMgr::salvaLibrettoScheda1_14] END");
		}

	}
	*/

	/**
	 * Consolida il libretto in stato bozza. Alla fine della funzionalita', tutti i dati salvati in bozza nell'xml, saranno salvati sul db,
	 * il libretto cambia stato in CONSOLIDATO, e gli eventuali libretti consolidati, diventeranno STORICIZZATI.<br/>
	 * Il file pdf stampabile viene inviato a INDEX
	 * @param idImpianto id dell'impianto
	 * @param cfUtente codice fiscale dell'utente che sta consolidando
	 * @throws ManagerException
	 */
	/*
	@Transactional
	public void consolidaLibretto_OLD(String idImpianto, String cfUtente, Integer idPersonaGiuridica, String codiceRea) throws ManagerException
	{
		try
		{	log.info("[SigitMgr::consolidaLibretto] BEGIN - codImpianto: " + idImpianto);
			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(idImpianto,  Constants.ID_STATO_LIBRETTO_BOZZA);
			//librettoList dovrebbe avere un solo libretto in stato bozza
			SigitTLibrettoDto libretto = librettoList.get(0);
			//recuperare xml
			SigitTLibTxtDto librettoTxt = getDbMgr().getTxtLibretto(libretto.getIdLibretto());
			byte[] xmlLibrettoArr = XmlBeanUtils.readString(librettoTxt.getXmlLibretto());
			MODDocument mod = MapDto.mapToMODDocument(xmlLibrettoArr);
			//salvare i dati dell'xml sul db
			Richiesta richiesta = mod.getMOD().getRichiesta();

			SigitTImpiantoDto impianto = consolidaScheda1Libretto(idImpianto, richiesta, cfUtente);
			//SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(idImpianto);

			//trattamento H2O
			getDbMgr().consolidaTrattamentoH2o(idImpianto, cfUtente, richiesta.getDatiSchedaTrattH2O());

			//GT
			List<RowGT> gtList = richiesta.getDatiSchedaGT().getSezGruppiTermici().getRowGTList();
			getDbMgr().consolidaGT(idImpianto, cfUtente, gtList, idPersonaGiuridica);
			//BR
			getDbMgr().consolidaBR(idImpianto, cfUtente, richiesta.getDatiSchedaBR().getSezBR().getRowBRList(), gtList);
			//RC
			getDbMgr().consolidaRC(idImpianto, cfUtente, richiesta.getDatiSchedaRC().getSezRC().getRowRCList(), gtList);
			//GF
			getDbMgr().consolidaGF(idImpianto, cfUtente, richiesta.getDatiSchedaGF().getSezGF().getRowGFList(), idPersonaGiuridica);
			//SC
			getDbMgr().consolidaSC(idImpianto, cfUtente, richiesta.getDatiSchedaSC().getSezSC().getRowSCList(), idPersonaGiuridica);
			//CG
			getDbMgr().consolidaCG(idImpianto, cfUtente, richiesta.getDatiSchedaCG().getSezCG().getRowCGList(), idPersonaGiuridica);
			//CS
			getDbMgr().consolidaCS(idImpianto, cfUtente, richiesta.getDatiSchedaCS().getSezCS().getRowCSList());
			//AG
			getDbMgr().consolidaAG(idImpianto, cfUtente, richiesta.getDatiSchedaAG().getSezAG().getRowAGList());
			getDbMgr().consolidaSistemiRegolazioneContabilizzazione(idImpianto, cfUtente, richiesta);
			getDbMgr().consolidaAC(idImpianto, cfUtente, richiesta.getDatiSchedaSistemaAC());
			getDbMgr().consolidaTE(idImpianto, cfUtente, richiesta.getDatiAltriComponentiTE());
			getDbMgr().consolidaRV(idImpianto, cfUtente, richiesta.getDatiAltriComponentiRV());
			getDbMgr().consolidaSCX(idImpianto, cfUtente, richiesta.getDatiAltriComponentiSC());
			getDbMgr().consolidaCI(idImpianto, cfUtente, richiesta.getDatiAltriComponentiCI());
			getDbMgr().consolidaUT(idImpianto, cfUtente, richiesta.getDatiAltriComponentiUT());
			getDbMgr().consolidaRC(idImpianto, cfUtente, richiesta.getDatiAltriComponentiRC());
			getDbMgr().consolidaVM(idImpianto, cfUtente, richiesta.getDatiVentilazMeccanicaVM());
			salvaDatiScheda14Libretto(idImpianto, cfUtente, richiesta);

			impianto.setDataIntervento(ConvertUtil.convertToDate(richiesta.getDatiSchedaIdentificativaImp().getL11DataIntervento()));

			//TODO da cancellare, lo fa l'allegato. Il libretto li usa solo in visualizzazione
			impianto.setL111FlgNormaUni103891(ConvertUtil.convertToBigDecimal(richiesta.getDatiRisultatiGT().getL111FlagNorma()));
			impianto.setL111AltraNorma(richiesta.getDatiRisultatiGT().getL111DescrAltro());

			log.debug("data intervento libretto: " + ConvertUtil.convertToString(impianto.getDataIntervento()));
			creaPdfEConsolidaLibretto(cfUtente, impianto, codiceRea, libretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_ESP_UTENTE);

		}
		catch (DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.error("Errore in consolidamento: ", e);
			throw e;
		}
		catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.error("Errore in consolidamento: ", e);
			throw new ManagerException(new Message("Errore durante il consolidamento, contattare l'amministrattore del sistema"));
		}
	}
	*/

	/**
	 * Salvataggio dei dati della scheda 7 del libretto, su db
	 * @param idImpianto
	 * @param cfUtente
	 * @param sistemaEmissione
	 * @throws DbManagerException
	 * @throws SigitTConsumoDaoException
	 */
	public void salvaDatiScheda7Libretto(String idImpianto, String cfUtente, SistemaEmissione sistemaEmissione) throws DbManagerException
	{
		log.debug("SigitMgr:salvaDatiScheda7Libretto - START");
		BigDecimal codiceImpiantoId = ConvertUtil.convertToBigDecimal(idImpianto);

		SigitTCompXSempliceDto entity = getDbMgr().cercaSigitTCompXSempliceByCodImpianto(codiceImpiantoId);

		boolean insert = false;
		if (entity == null) {
			entity = new SigitTCompXSempliceDto();
			entity.setCodiceImpianto(codiceImpiantoId);
			insert = true;
		}

		entity.setDataUltMod(DateUtil.getSqlDataCorrente());
		entity.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtente));

		entity = MapDto.mapToSigitTCompXSempliceDto(sistemaEmissione, entity);
		getDbMgr().salvaScheda7(entity, insert, cfUtente);
		log.debug("SigitMgr:salvaDatiScheda7Libretto - END");
	} 

	public SistemaEmissione caricaDatiScheda7Libretto(String codiceImpianto) throws ManagerException {
		log.debug("[SigitMgr::caricaDatiScheda7Libretto] BEGIN");
		SistemaEmissione sistemaEmissione = null;
		SigitTCompXSempliceDto dto = getDbMgr().cercaSigitTCompXSempliceByCodImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));

		if (dto != null) {
			sistemaEmissione = MapDto.mapToSistemaEmissione(dto);
		}

		log.debug("[SigitMgr::caricaDatiScheda7Libretto] END");
		return sistemaEmissione;
	}

	public TrattamentoAcqua caricaDatiScheda2Libretto(String codiceImpianto) throws ManagerException {
		log.debug("[SigitMgr::caricaDatiScheda2Libretto] BEGIN");
		TrattamentoAcqua trattamentoAcqua = null;
		SigitTTrattH2ODto dto = getDbMgr().cercaSigitTTrattH2OByCodImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
		if (dto != null) {
			trattamentoAcqua = MapDto.mapToTrattamentoAcqua(dto);
		}
		log.debug("[SigitMgr::caricaDatiScheda7Libretto] END");
		return trattamentoAcqua;
	}

	public SistemiRegolazioneContabilizzazione caricaDatiScheda5_2Libretto(String codiceImpianto) throws ManagerException {
		log.debug("[SigitMgr::caricaDatiScheda5_2Libretto] BEGIN");
		SistemiRegolazioneContabilizzazione sistemi = null;
		SigitTCompXSempliceDto dto = getDbMgr().cercaSigitTCompXSempliceByCodImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
		if (dto != null) {
			sistemi = MapDto.mapToSistemaRegolazione(dto);
		}
		log.debug("[SigitMgr::caricaDatiScheda5_2Libretto] END");
		return sistemi;
	}

	public SistemiDistribuzione caricaDatiScheda6Libretto(String codiceImpianto) throws DbManagerException {
		log.debug("[SigitMgr::caricaDatiScheda6Libretto] BEGIN");
		SistemiDistribuzione dto = null;
		SigitTCompXSempliceDto entity = getDbMgr().cercaSigitTCompXSempliceByCodImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
		if (entity != null) {
			dto = MapDto.mapToSistemiDistribuzione(entity);
		}
		log.debug("[SigitMgr::caricaDatiScheda6Libretto] END");
		return dto;
	}

	public List<ComponenteVX> caricaDatiComponentiVX(String codiceImpianto) throws SigitTCompVxDaoException {
		log.debug("[SigitMgr::caricaDatiComponentiVX] BEGIN");
		List<ComponenteVX> componentiVxDtos = null;
		List<SigitTCompVxDto> componentiVxEntities = getDbMgr().getSigitTCompVxDao().findByCodImpianto(ConvertUtil.convertToInteger(codiceImpianto));
		if (componentiVxEntities != null && !componentiVxEntities.isEmpty()) {
			componentiVxDtos = new ArrayList<ComponenteVX>();
			for (SigitTCompVxDto entity : componentiVxEntities) {
				componentiVxDtos.add(MapDto.mapToComponenteVX(entity));
			}
		}
		log.debug("[SigitMgr::caricaDatiComponentiVX] END");
		return componentiVxDtos;
	}

	public void salvaDatiScheda5_2Libretto(String idImpianto, String cfUtente, SistemiRegolazioneContabilizzazione sistemaRegolazione) throws DbManagerException
	{
		log.debug("SigitMgr:salvaDatiScheda5_2Libretto - START");
		BigDecimal codiceImpiantoId = ConvertUtil.convertToBigDecimal(idImpianto);

		SigitTCompXSempliceDto entity = getDbMgr().cercaSigitTCompXSempliceByCodImpianto(codiceImpiantoId);

		boolean insert = false;
		if (entity == null) {
			entity = new SigitTCompXSempliceDto();
			entity.setCodiceImpianto(codiceImpiantoId);
			insert = true;
		}

		entity.setDataUltMod(DateUtil.getSqlDataCorrente());
		entity.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtente));

		entity = MapDto.mapToSigitTCompXSempliceDto(sistemaRegolazione, entity);

		getDbMgr().salvaScheda5_2(entity, insert, cfUtente);
		log.debug("SigitMgr:salvaDatiScheda5_2Libretto - END");
	}

	public void salvaDatiScheda6Libretto(String idImpianto, String cfUtente, SistemiDistribuzione sistema, List<ComponenteVX> componentiVx) throws DbManagerException {
		log.debug("SigitMgr:salvaDatiScheda6Libretto - START");

		BigDecimal codiceImpianto = ConvertUtil.convertToBigDecimal(idImpianto);
		//vengono salvati i dati del sistema
		SigitTCompXSempliceDto entity = getDbMgr().cercaSigitTCompXSempliceByCodImpianto(codiceImpianto);

		boolean insert = false;
		if (entity == null) {
			entity = new SigitTCompXSempliceDto();
			entity.setCodiceImpianto(codiceImpianto);
			insert = true;
		}
		entity.setDataUltMod(DateUtil.getSqlDataCorrente());
		entity.setUtenteUltMod(cfUtente);

		entity = MapDto.mapToSigitTCompXSempliceDto(sistema, entity);

		Map<Integer, SigitTCompVxDto> entityVXRows = null;
		Map<Integer, SigitTCompXDto> entityXRows = null;
		if (componentiVx != null && !componentiVx.isEmpty()) {
			entityVXRows = new HashMap<Integer, SigitTCompVxDto>();
			entityXRows = new HashMap<Integer, SigitTCompXDto>();
			for (ComponenteVX componente : componentiVx) {
				SigitTCompVxDto componenteVx = MapDto.mapToSigitTCompVXDto(componente, codiceImpianto);
				SigitTCompXDto componenteX = MapDto.mapToSigitTCompX(componente, codiceImpianto, cfUtente);
				entityVXRows.put(componente.getIndice(), componenteVx);
				entityXRows.put(componente.getIndice(), componenteX);
			}
		}

		getDbMgr().salvaScheda6(entity, entityVXRows, entityXRows, insert, cfUtente);

		log.debug("SigitMgr:salvaDatiScheda6Libretto - END");
	}

	public void salvaDatiScheda2Libretto(String codiceImpianto, TrattamentoAcqua trattamentoAcqua) throws DbManagerException
	{
		log.debug("SigitMgr:salvaDatiScheda2Libretto - START");
		BigDecimal codiceImpiantoId = ConvertUtil.convertToBigDecimal(codiceImpianto);

		SigitTTrattH2ODto entity = getDbMgr().cercaSigitTTrattH2OByCodImpianto(codiceImpiantoId);
		boolean insert = false;
		if ( entity == null ) {
			entity = new SigitTTrattH2ODto();
			entity.setCodiceImpianto(codiceImpiantoId);
			insert = true;
		}

		entity = MapDto.mapToSigitTTrattH2ODto(trattamentoAcqua, entity);
		getDbMgr().salvaScheda2(entity, insert);
		log.debug("SigitMgr:salvaDatiScheda2Libretto - END");
	}


	/**
	 * Salvataggio dei dati della scheda 14 del libretto, su db
	 * @param idImpianto
	 * @param cfUtente
	 * @param richiesta
	 * @throws SigitTConsumoDaoException
	 * @throws SigitTConsumo14_4DaoException
	 */
	private void salvaDatiScheda14Libretto(String idImpianto, String cfUtente, Richiesta richiesta) throws SigitTConsumoDaoException, SigitTConsumo14_4DaoException
	{
		log.debug("salvaDatiScheda14Libretto - START");
		getDbMgr().consolidaConsumoCombustibile(idImpianto, cfUtente, richiesta.getDatiConsumoCombu());
		getDbMgr().consolidaConsumoEnergia(idImpianto, cfUtente, richiesta.getDatiConsumoEE());
		getDbMgr().consolidaConsumoH2O(idImpianto, cfUtente, richiesta.getDatiConsumoH2O());
		getDbMgr().consolidaConsumoProdottiChimici(idImpianto, cfUtente, richiesta.getDatiConsumoProdottiChimici());
		log.debug("salvaDatiScheda14Libretto - END");
	}

	private void salvaDatiScheda14LibrettoLight(String idImpianto, String cfUtente, it.csi.sigit.sigitwebn.xml.librettoLight.data.RichiestaDocument.Richiesta richiesta) throws SigitTConsumoDaoException, SigitTConsumo14_4DaoException
	{
		log.debug("salvaDatiScheda14LibrettoLight - START");
		getDbMgr().consolidaConsumoCombustibileLight(idImpianto, cfUtente, richiesta.getDatiConsumoCombu());
		getDbMgr().consolidaConsumoEnergiaLight(idImpianto, cfUtente, richiesta.getDatiConsumoEE());
		getDbMgr().consolidaConsumoH2OLight(idImpianto, cfUtente, richiesta.getDatiConsumoH2O());
		getDbMgr().consolidaConsumoProdottiChimiciLight(idImpianto, cfUtente, richiesta.getDatiConsumoProdottiChimici());
		log.debug("salvaDatiScheda14LibrettoLight - END");
	}

	private SigitTImpiantoDto consolidaScheda1Libretto(String idImpianto, Richiesta richiesta, String cfUtente) throws DbManagerException
	{
		return salvaScheda1Libretto(idImpianto, richiesta, cfUtente, true);
	}

	/**
	 * Salvataggio dei dati del impianto della scheda 1 del libretto. unita' immobiliare, secondarie e dati impianto.
	 * @param idImpianto
	 * @param richiesta
	 * @param cfUtente
	 * @return
	 * @throws DbManagerException
	 */
	private SigitTImpiantoDto salvaScheda1Libretto(String idImpianto, Richiesta richiesta, String cfUtente, boolean checkCatasto) throws DbManagerException
	{
		getDbMgr().consolidaUnitaImmobiliarePrincipale(idImpianto, richiesta, cfUtente, checkCatasto);
		getDbMgr().consolidaUnitaImmobiliareSecondarie(idImpianto, richiesta, cfUtente);
		//impianto
		SigitTImpiantoDto impianto = getDbMgr().consolidaDatiImpianto(idImpianto, cfUtente, richiesta.getDatiSchedaIdentificativaImp());
		return impianto;
	}

	private SigitTImpiantoDto salvaScheda1LibrettoLight(String idImpianto, it.csi.sigit.sigitwebn.xml.librettoLight.data.RichiestaDocument.Richiesta richiesta, String cfUtente) throws DbManagerException
	{
		getDbMgr().consolidaUnitaImmobiliarePrincipaleLight(idImpianto, richiesta, cfUtente);
		getDbMgr().consolidaUnitaImmobiliareSecondarieLight(idImpianto, richiesta, cfUtente);
		//impianto
		SigitTImpiantoDto impianto = getDbMgr().consolidaDatiImpiantoLight(idImpianto, cfUtente, richiesta.getDatiSchedaIdentificativaImp());
		return impianto;
	}

	/*
	public ResultInvioMail respingiAllegato(String idAllegato, String cfUtenteMod, String motivoRespinto) throws ManagerException {
		log.debug("[SigitMgr::respingiAllegato] BEGIN");
		ResultInvioMail resultInvioMail = null;
		try
		{
			getDbMgr().respingiAllegato(ConvertUtil.convertToBigDecimal(idAllegato), cfUtenteMod, motivoRespinto);

			respingiAllegatoLibretto(idAllegato, cfUtenteMod, motivoRespinto);

		}
		catch (Exception e) {

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[SigitMgr::respingiAllegato] END");
		}
		return resultInvioMail;
	}
	*/

	@Transactional
	public ResultInvioMail respingiAllegatoLibretto(String idAllegato, UtenteLoggato utenteLoggato) throws ManagerException {
		log.debug("[SigitMgr::respingiAllegato] BEGIN");
		ResultInvioMail resultInvioMail = null;
		try
		{
			String cfUtenteMod = utenteLoggato.getCodiceFiscale();

			SigitVRicercaAllegatiDto vAllegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);

			SigitTPersonaGiuridicaDto manutentore = getDbMgr().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(vAllegato.getIdPersonaGiuridica()));

			ArrayList<SigitTPersonaFisicaDto> delegati = getDbMgr().cercaPersonaFisDelValidiByIdPersGiu(manutentore.getIdPersonaGiuridica());

			if(!(Constants.ALLEGATO_F.equalsIgnoreCase(""+vAllegato.getFkTipoDocumento()) ||
					Constants.ALLEGATO_G.equalsIgnoreCase(""+vAllegato.getFkTipoDocumento())))
			{

				SigitTLibrettoDto librettoDto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(ConvertUtil.convertToString(vAllegato.getCodiceImpianto()));

				librettoDto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
				librettoDto.setCfRedattore(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
				librettoDto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
				librettoDto.setDataUltMod(DateUtil.getSqlDataCorrente());

				getDbMgr().inserisciLibretto(librettoDto);

				getDbMgr().storicizzaLibretti(librettoDto);

				SigitTImpiantoDto sigitTImpiantoDto = getDbMgr().cercaImpiantoDtoById(ConvertUtil.convertToString(vAllegato.getCodiceImpianto()));

				creaPdfEConsolidaLibretto(utenteLoggato, sigitTImpiantoDto, MapDto.getCodiceRea(manutentore.getSiglaRea(), ConvertUtil.convertToInteger(manutentore.getNumeroRea())), librettoDto, Constants.ID_MOTIVO_CONSOLIDAMENTO_RESP_RAPP_CONTROLLO);
			}




			// PARTE PER L'INVIO DELLA MAIL
			//SigitVRicercaAllegatiDto vAllegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(dettaglio.getIdAllegato());

			// Cerco la mail del responsabile alla data controllo
			String emailResponsabile = cercaEMailResponsabileAttivoAllaDataByCodImpianto(ConvertUtil.convertToString(vAllegato.getCodiceImpianto()), ConvertUtil.convertToString(vAllegato.getDataControllo()));

			// Cerco il 3Responsabile
			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(ConvertUtil.convertToString(vAllegato.getCodiceImpianto()),
					ConvertUtil.convertToString(vAllegato.getDataControllo()));

			PersonaGiuridica pg3Resp = null;
			if (list3RespAttiviImpianto != null && list3RespAttiviImpianto.size() > 0) {
				SigitVRicerca3ResponsabileDto vTot3Responsabile = list3RespAttiviImpianto.get(0);
				pg3Resp = getDbMgr().cercaPersonaGiuridicaById(vTot3Responsabile.getFkPg3Resp().intValue());
			}

			resultInvioMail = getServiziMgr().sendMailRespinta(vAllegato, manutentore, delegati, emailResponsabile, pg3Resp);

		}
		catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[SigitMgr::respingiAllegato] END");
		}
		return resultInvioMail;
	}


	public String cercaEMailResponsabileAttivoAllaDataByCodImpianto (String codImpianto, String dataRapporto) throws ManagerException {
		log.debug("[SigitMgr::cercaEMailResponsabileAttivoAllaDataByCodImpianto] BEGIN");
		String emailResponsabile = null;
		try
		{

			// Cerco il responsabile alla data controllo, mi serve per l'indirizzo mail ira' nel caso non ci sia il 3Responsabile
			List<SigitVTotImpiantoDto> listResp = getDbMgr().cercaResponsabiliAttiviAllaDataByCodImpianto(codImpianto, dataRapporto);
			if(listResp!=null && !listResp.isEmpty()){

				SigitVTotImpiantoDto impiantoResp = listResp.get(0);

				if(impiantoResp.getPfPg().equals(Constants.LABEL_PF))
				{
					PersonaFisica pfResp = getDbMgr().cercaPersonaFisicaById(impiantoResp.getIdPersonaFisica().intValue());

					if (pfResp != null && GenericUtil.isNotNullOrEmpty(pfResp.getEmail()))
						emailResponsabile = pfResp.getEmail();
				}else{
					PersonaGiuridica pgResp = getDbMgr().cercaPersonaGiuridicaById(impiantoResp.getIdPersonaFisica().intValue());

					if (pgResp != null && GenericUtil.isNotNullOrEmpty(pgResp.getEmail()))
						emailResponsabile = pgResp.getEmail();
				}
			}

		}
		catch (Exception e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[SigitMgr::cercaEMailResponsabileAttivoAllaDataByCodImpianto] END");
		}
		return emailResponsabile;
	}

	@Transactional
	public void eliminaAllegatoRappProva (String idAllegato, String cfUtenteMod, String tipoComponente) throws ManagerException {
		log.debug("[SigitMgr::eliminaAllegatoRappProva] BEGIN");

		//vengono recuperati tutti i sigit_t_dett_ispez ed eliminati
		//List<SigitTDettIspezGtDto> listaDettIspez = getDbMgr().getSigitTDettIspezGtDao().findByIdAllegato(ConvertUtil.convertToInteger(idAllegato));
		try
		{
			if (Constants.TIPO_COMPONENTE_GT.equals(tipoComponente)) {
				getDbMgr().getSigitTDettIspezGtDao().customDeleterDeleteByIdAllegato(ConvertUtil.convertToInteger(idAllegato));
				getDbMgr().getSigitTRappIspezGtDao().customDeleterDeleteByIdAllegato(ConvertUtil.convertToInteger(idAllegato));
			}

			if (Constants.TIPO_COMPONENTE_GF.equals(tipoComponente)) {
				getDbMgr().getSigitTDettIspezGfDao().customDeleterDeleteByIdAllegato(ConvertUtil.convertToInteger(idAllegato));
				getDbMgr().getSigitTRappIspezGfDao().customDeleterDeleteByIdAllegato(ConvertUtil.convertToInteger(idAllegato));
			}

			eliminaAllegato(idAllegato, cfUtenteMod);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[SigitMgr::eliminaAllegatoRappProva] END");
		}

	}

	public void modificaStatoAllegatoRappProva (String idAllegato, String cfUtenteMod, String tipoComponente) throws ManagerException {
		log.debug("[SigitMgr::modificaStatoAllegatoRappProva] BEGIN");

		//vengono recuperati tutti i sigit_t_dett_ispez ed eliminati
		//List<SigitTDettIspezGtDto> listaDettIspez = getDbMgr().getSigitTDettIspezGtDao().findByIdAllegato(ConvertUtil.convertToInteger(idAllegato));
		try
		{
			SigitTAllegatoDto allegato = new SigitTAllegatoDto();
			allegato.setIdAllegato(ConvertUtil.convertToBigDecimal(idAllegato));
			allegato.setFkStatoRapp(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_RAPPORTO_RESPINTO));
			allegato.setFkSiglaBollino(null);
			allegato.setNomeAllegato(null);
			allegato.setDataRespinta(DateUtil.getSqlCurrentDate());
			allegato.setDataUltMod(DateUtil.getSqlDataCorrente());
			allegato.setUtenteUltMod(cfUtenteMod);
			allegato.setMotivoRespinta("respinta per annullamento ispezione associata");

			getDbMgr().getSigitTAllegatoDao().updateColumnsRespingiAllegato(allegato);

		} catch (Exception e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[SigitMgr::modificaStatoAllegatoRappProva] END");
		}

	}


	@Transactional
	public String eliminaAllegato(String idAllegato, String cfUtenteMod) throws ManagerException {
		log.debug("[SigitMgr::eliminaAllegato] BEGIN");
		String elencoMail = null;
		try
		{
//			SigitVRicercaAllegatiDto vAllegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);

			List<SigitTDocAllegatoDto> docList = getDbMgr().cercaElencoDocumentiPerIdAllegato(ConvertUtil.convertToInteger(idAllegato));

			getDbMgr().eliminaAllegato(ConvertUtil.convertToBigDecimal(idAllegato), ReplaceSpecialCharUtils.sanitize(cfUtenteMod));

			getDbMgr().salvaLogEliminaAllegato(ReplaceSpecialCharUtils.sanitize(idAllegato), ReplaceSpecialCharUtils.sanitize(cfUtenteMod));

			for (SigitTDocAllegatoDto sigitTDocAllegatoDto : docList) {
				try
				{
					getServiziMgr().indexDeleteContentByUid(ReplaceSpecialCharUtils.sanitize(sigitTDocAllegatoDto.getUidIndex()));
				}
				catch (Exception e)
				{
					// Non faccio niente, proseguo con l'esecuzione
				}
			}


		}
		catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[SigitMgr::eliminaAllegato] END");
		}
		return elencoMail;
	}

	@Transactional
	public void annullaManutenzione(BigDecimal idAllegato, String cfUtenteMod, String motivo)throws ManagerException {
		log.debug("[SigitMgr::annullaManutenzione] START");
		try {
			getDbMgr().respingiManutenzione(idAllegato, cfUtenteMod, motivo);

		}
		catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}

		log.debug("[SigitMgr::annullaManutenzione] END");
	}

	@Transactional
	public ResultInvioMail annullaManutenzioneLibretto(String idAllegato, UtenteLoggato utenteLoggato) throws ManagerException {
		log.debug("[SigitMgr::annullaManutenzioneLibretto] BEGIN");
		ResultInvioMail resultInvioMail = null;
		try
		{
			String cfUtenteMod = utenteLoggato.getCodiceFiscale();

			SigitVRicercaAllegatiDto vAllegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);

			SigitTPersonaGiuridicaDto manutentore = getDbMgr().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(vAllegato.getIdPersonaGiuridica()));

			ArrayList<SigitTPersonaFisicaDto> delegati = getDbMgr().cercaPersonaFisDelValidiByIdPersGiu(manutentore.getIdPersonaGiuridica());

			String codiceImpianto = ConvertUtil.convertToString(vAllegato.getCodiceImpianto());

			String dataControllo = ConvertUtil.convertToString(vAllegato.getDataControllo());

			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(codiceImpianto, dataControllo);

			PersonaGiuridica pg3Resp = null;
			if (list3RespAttiviImpianto != null && list3RespAttiviImpianto.size() > 0) {
				SigitVRicerca3ResponsabileDto vTot3Responsabile = list3RespAttiviImpianto.get(0);
				pg3Resp = getDbMgr().cercaPersonaGiuridicaById(vTot3Responsabile.getFkPg3Resp().intValue());
			}

			String emailResponsabile = cercaEMailResponsabileAttivoAllaDataByCodImpianto(codiceImpianto, dataControllo);

			SigitTLibrettoDto librettoDto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(ConvertUtil.convertToString(vAllegato.getCodiceImpianto()));

			librettoDto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
			librettoDto.setCfRedattore(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
			librettoDto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
			librettoDto.setDataUltMod(DateUtil.getSqlDataCorrente());

			getDbMgr().inserisciLibretto(librettoDto);

			getDbMgr().storicizzaLibretti(librettoDto);

			SigitTImpiantoDto sigitTImpiantoDto = getDbMgr().cercaImpiantoDtoById(ConvertUtil.convertToString(vAllegato.getCodiceImpianto()));

			creaPdfEConsolidaLibretto(utenteLoggato, sigitTImpiantoDto, MapDto.getCodiceRea(manutentore.getSiglaRea(), ConvertUtil.convertToInteger(manutentore.getNumeroRea())), librettoDto, Constants.ID_MOTIVO_CONSOLIDAMENTO_ANNULLAMENTO_MANUT);

			resultInvioMail = getServiziMgr().sendMailAnnulaManutenzione(vAllegato, manutentore, delegati, emailResponsabile, pg3Resp);

		}
		catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[SigitMgr::annullaManutenzioneLibretto] END");
		}
		return resultInvioMail;
	}

	public String eliminaDocumentoAllegato(Integer idDocumento, String cfUtenteMod) throws ManagerException {
		log.debug("[SigitMgr::eliminaDocumento] BEGIN");
		String elencoMail = null;
		try
		{
			// E' una eliminazione logica
			//SigitTDocAggiuntivaDto doc = getDbMgr().cercaDocumentoAggById(idDocumento);

			getDbMgr().eliminaDocumentoAllegato(idDocumento, cfUtenteMod);

			//log.debug("Cancellazione allegati da INDEX");
			//getServiziMgr().indexDeleteContentByUid(doc.getUidIndex());

		}
		catch (Exception e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[SigitMgr::eliminaDocumento] END");
		}
		return elencoMail;
	}

	public String eliminaDocumentoAggiuntivo(Integer idDocumento, String cfUtenteMod) throws ManagerException {
		log.debug("[SigitMgr::eliminaDocumentoAggiuntivo] BEGIN");
		String elencoMail = null;
		try
		{
			// E' una eliminazione logica

			getDbMgr().eliminaDocumentoAgg(idDocumento, cfUtenteMod);

		}
		catch (Exception e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[SigitMgr::eliminaDocumentoAggiuntivo] END");
		}
		return elencoMail;
	}

	private Ruolo creaRuoloPrivato(int idRuolo, PersonaGiuridica persGiuridica, String descRuolo)
	{
		Ruolo ruoloPrivato  = new Ruolo();
		ruoloPrivato.setIdRuolo(idRuolo);
		ruoloPrivato.setDescRuolo(descRuolo);
		ruoloPrivato.setDescRuoloCompleto(descRuolo);
		ruoloPrivato.setIdPersonaGiuridica(persGiuridica.getIdPersonaGiuridica());
		ruoloPrivato.setCodiceFiscale(persGiuridica.getCodiceFiscale());
		ruoloPrivato.setDenomDitta(persGiuridica.getDenominazione());
		ruoloPrivato.setSiglaRea(persGiuridica.getSiglaRea());
		ruoloPrivato.setNumeroRea(ConvertUtil.convertToInteger(persGiuridica.getNumeroRea()));
		if(GenericUtil.isNotNullOrEmpty(persGiuridica.getSiglaRea()))
			ruoloPrivato.setCodiceRea(MapDto.getCodiceRea(persGiuridica.getSiglaRea(), ConvertUtil.convertToInteger(persGiuridica.getNumeroRea())));
		ruoloPrivato.setDataCessazione(persGiuridica.getDataCessazione());

		return ruoloPrivato;
	}

	private Ruolo creaRuoloPrivatoCat(int idRuolo, PersonaGiuridica persGiuridica, String descRuolo, int idPgCat, String descCat)
	{

		Ruolo ruoloPrivato  = creaRuoloPrivato(idRuolo, persGiuridica, descRuolo);

		ruoloPrivato.setIsCat(true);

		// tolgo dalla descrizione la parola cat (altrimenti c'e' un proliferarsi di ruoli che complicherebbe il codice)
//		ruoloPrivato.setDescRuolo(ruoloPrivato.getDescRuolo().replace(
//				Constants.CAT_RUOLO_PREFISSO, ""));

		ruoloPrivato.setIdPgCat(idPgCat);
		ruoloPrivato.setDescCat(descCat);

		return ruoloPrivato;
	}


	/**
	 * Crea l'xml a partire dai dati salvati sulle tabelle del db, crea il pdf definitivo in sola lettura e lo invia a INDEX,
	 * <br/>storiccizza il libretto consolidato e consolida il libretto in bozza
	 * @param cfUtente
	 * @param impianto
	 * @param codiceRea
	 * @param libretto il libretto in bozza (da consolidare)
	 * @param motivoConsolidamento
	 * @throws ManagerException
	 */
	public void creaPdfEConsolidaLibretto(UtenteLoggato utenteLoggato, SigitTImpiantoDto impianto, String codiceRea, SigitTLibrettoDto libretto, int motivoConsolidamento) throws ManagerException
	{
		boolean isRespAssente = false;
		try
		{
			String codiceImpianto = impianto.getCodiceImpianto().toString();
			String idLibretto = libretto.getIdLibretto().toString();

			String cfUtente = utenteLoggato.getCodiceFiscale();
			String idPersonaGiuridicaLoggata = ConvertUtil.convertToString(utenteLoggato.getRuolo().getIdPersonaGiuridica());

			// Controllo il responsabile
			SigitVTotImpiantoDto respAttivo = getDbMgr().cercaResponsabileAttivoByCodImpianto(new Integer(codiceImpianto));
			if(respAttivo==null)
			{
				isRespAssente = true;
				throw new ManagerException(new Message(Messages.ERROR_RESPONSABILE_ASSENTE));

			}


//			//controllo responsabile attivo per motivo_consolidamento = respinta
//			if(Constants.ID_MOTIVO_CONSOLIDAMENTO_RESP_RAPP_CONTROLLO == motivoConsolidamento)
//			{
//				SigitVTotImpiantoDto respAttivo = getDbMgr().cercaResponsabileAttivoByCodImpiantoOLD(new Integer(codiceImpianto));
//				if(respAttivo==null)
//				{
//					isRespAssente = true;
//					throw new ManagerException(new Message("Responsabile impianto non presente."));
//
//				}
//			}



			// PARTE IN CUI UTILIZZARE WS - inizio

			/*
			MODDocument mod = getDbMgr().getModuloLibretto(codiceImpianto, idLibretto, true);
			//creare pdf finale non modificabile, e salvare su INDEX,
			Applicazione app = new Applicazione();
			XmlModel xmlModel = new XmlModel();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);

			Modulo modulo = getServiziMgr().cercaModulo(app, Constants.CODICE_MODULO_MODOL_LIBRETTO);

			mod.getMOD().getRichiesta().getDatiPrecompilati().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
			mod.getMOD().getRichiesta().getDatiSchedaIdentificativaImp().setL11DataIntervento(ConvertUtil.convertToXmlCalendar(impianto.getDataIntervento()));

			// DA PORTARE!!!!
			if(mod.getMOD().getRichiesta().getDatiRisultatiGT()!=null)
			{
				mod.getMOD().getRichiesta().getDatiRisultatiGT().setL111DescrAltro(impianto.getL111AltraNorma());
				if(GenericUtil.isNotNullOrEmpty(impianto.getL111AltraNorma()))
					mod.getMOD().getRichiesta().getDatiRisultatiGT().xsetL111FlagAltro(MapDto.getXmlBoolean(true));
				mod.getMOD().getRichiesta().getDatiRisultatiGT().xsetL111FlagNorma(MapDto.getXmlBoolean(ConvertUtil.convertToBooleanAllways(impianto.getL111FlgNormaUni103891())));
			}

			xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(mod));
			log.debug("generato xml completo");
			RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
			modulo = getServiziMgr().getModol().mergeModulo(app, null, modulo, xmlModel);

			log.debug("merge effettuato");
			byte[] thePdf = modulo.getDataContent();
			*/

			DettaglioDocumentoMultiplo documento = getServiziMgr().getLibrettoCompletoNow(codiceImpianto, true, cfUtente, idPersonaGiuridicaLoggata);
			byte[] thePdf = documento.getDocumentoPdf().getFile();
			// PARTE IN CUI UTILIZZARE WS - fine

//			boolean isStatico = documento.getDocumentoPdf().isPdfStatic();

			if (log.isDebugEnabled())
			{
				log.debug("##################");
				log.debug("##################");
//				log.debug("Cod impianto: "+codiceImpianto+" - isStatic: "+isStatico);
				log.debug("Cod impianto: "+codiceImpianto);
				log.debug("##################");
				log.debug("##################");
			}

			String nome = getNomeFileLibretto(codiceImpianto, impianto.getDataIntervento(), idLibretto);

			log.debug("nome file libretto: " + nome);
			Metadati metadati = MapDto.mapMetadati(impianto, libretto, ReplaceSpecialCharUtils.sanitize(codiceRea));
			String uidIndex = getServiziMgr().indexUploadFileNew(nome.toString(), thePdf, metadati, Constants.INDEX_FOLDER_LIBRETTI, true);
			log.debug("UID index: " + uidIndex);
			//storicizzare altri libretti consolidati
			libretto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtente));

			getDbMgr().storicizzaLibretti(libretto);
			log.debug("libretti storicizzati");
			//consolidare libretto in bozza
			libretto.setFkMotivoConsolid(new BigDecimal(motivoConsolidamento));
			libretto.setFileIndex(ReplaceSpecialCharUtils.sanitize(nome));
			libretto.setUidIndex(ReplaceSpecialCharUtils.sanitize(uidIndex));
			getDbMgr().consolidaLibretto(libretto);
			log.debug("Aggiornamento xml su DB");

			if (log.isDebugEnabled())
			{
				log.debug("libretto.getIdLibretto(): "+libretto.getIdLibretto());
				log.debug("documento: "+documento);
				log.debug("documento.getDocumentoXml(): "+documento.getDocumentoXml());
				log.debug("documento.getDocumentoXml().getFile(): "+documento.getDocumentoXml().getFile());
			}

			getDbMgr().updateTxtLibretto(libretto.getIdLibretto(), XmlBeanUtils.readByteArray(documento.getDocumentoXml().getFile()));
			log.debug("libretto consolidato");
		}
		catch (Exception e) {
			log.error("Errore in consolidamento:", e);

			if (isRespAssente)
			{
				throw new ManagerException(e, new Message(Messages.ERROR_IMPOSSIBILE_CONSOLIDARE + ": " + e.getMessage()));
			}
			else
			{
				throw new ManagerException(e, new Message(Messages.ERROR_IMPOSSIBILE_CONSOLIDARE + ": contattare l'amministrattore del sistema"));
			}
		}
	}

	private String getNomeFileLibretto(String codiceImpianto, Date dataIntervento, String idLibretto)
	{
		StringBuilder nome = new StringBuilder();
		nome.append(Constants.INDEX_FILE_PREFIX_LIBRETTO);
		nome.append("_");
		nome.append(codiceImpianto);
		nome.append("_");
		nome.append(ConvertUtil.convertToString(dataIntervento, ConvertUtil.FORMAT_DATE_UNDERSCORE));
		nome.append("_");
		nome.append(idLibretto);
//		if (!isStatico)
//		{
//			nome.append("_nopdfa");
//		}
		nome.append(".pdf");
		return nome.toString();
	}

	public AllegatiPerImpianto cercaAllegatiPerCodiceImpianto(String codiceImpianto) throws ManagerException {
		return cercaAllegatiPerCodiceImpianto(codiceImpianto, false);
	}


	/**
	 * Ricerca l'elenco degli allegati relativi ad un codice impianto con le informazioni di base dell'impianto associato
	 * @param codiceImpianto
	 * @return
	 * @throws ManagerException
	 */
	public AllegatiPerImpianto cercaAllegatiPerCodiceImpianto(String codiceImpianto, boolean contaVerifiche) throws ManagerException {
		AllegatiPerImpianto allegatiPerImpianto = new AllegatiPerImpianto();
		log.debug("[SigitMgr::cercaAllegatiPerCodiceImpianto] BEGIN");
		try {
			 List<SigitVTotImpiantoCercaImpiantoPerAllegatiDto> listaImpianti = getDbMgr().cercaImpiantoPerAllegati(ConvertUtil.convertToInteger(codiceImpianto));
			 if(listaImpianti!=null && listaImpianti.size()>0){
				//mi setto le informazioni per l'impianto
				 allegatiPerImpianto.setIdentificativoImpianto(MapDto.mapToImpiantoPerAllegati(listaImpianti));
			 }else{
				//vado a valorizzare solo la parte dell'ubicazione
				 SigitVTotImpiantoCercaUbicazioneImpiantoDto ubicazione = getDbMgr().cercaUbicazioneImpianto(ConvertUtil.convertToInteger(codiceImpianto));
				 allegatiPerImpianto.setIdentificativoImpianto(MapDto.mapToUbicazioneImpianto(ubicazione));
			 }

			 if(!contaVerifiche) {
				 //trovo l'arraylist per l'elenco degli allegati
				 List<SigitVRicercaAllegatiDto> elencoAllegati = getDbMgr().cercaElencoAllegatiPerImpianto(codiceImpianto);
				 //e me li salvo sull'oggetto che arriva al client
				 allegatiPerImpianto.setListaAllegati(mapToElencoAllegatiPerImpianto(elencoAllegati));
			 } else {
				 List<SigitVRicercaAllegatiByCodiceImpiantoCountVerificheDto> elencoAllegati = getDbMgr().cercaElencoAllegatiPerImpiantoCountVerifiche(codiceImpianto);
				 allegatiPerImpianto.setListaAllegati(mapToElencoAllegatiPerImpiantoHasVerifiche(elencoAllegati));
			 }

		} catch (SigitTAllegatoDaoException e) {
			e.printStackTrace();
		} finally {
			log.debug("[SigitMgr::cercaAllegatiPerCodiceImpianto] END");
		}
		return allegatiPerImpianto;
	}

	/**
	 * Ricerca lo storico degli allegati relativi ad un codice impianto con le informazioni di base dell'impianto associato
	 * @param codiceImpianto
	 * @return
	 * @throws ManagerException
	 */
	public AllegatiPerImpianto cercaStoricoAllegatiPerCodiceImpianto(String codiceImpianto) throws ManagerException {
		AllegatiPerImpianto allegatiPerImpianto = new AllegatiPerImpianto();
		log.debug("[SigitMgr::cercaStoricoAllegatiPerCodiceImpianto] BEGIN");
		try {
			 List<SigitVTotImpiantoCercaImpiantoPerAllegatiDto> listaImpianti = getDbMgr().cercaImpiantoPerAllegati(ConvertUtil.convertToInteger(codiceImpianto));
			 if(listaImpianti!=null && listaImpianti.size()>0){
				//mi setto le informazioni per l'impianto
				 allegatiPerImpianto.setIdentificativoImpianto(MapDto.mapToImpiantoPerAllegati(listaImpianti));
			 }else{
				//vado a valorizzare solo la parte dell'ubicazione
				 SigitVTotImpiantoCercaUbicazioneImpiantoDto ubicazione = getDbMgr().cercaUbicazioneImpianto(ConvertUtil.convertToInteger(codiceImpianto));
				 allegatiPerImpianto.setIdentificativoImpianto(MapDto.mapToUbicazioneImpianto(ubicazione));
			 }
			 //trovo l'arraylist per l'elenco degli allegati
			 List<SigitVRicercaAllegatiStoricoDto> elencoAllegati = getDbMgr().cercaElencoStoricoAllegatiPerImpianto(codiceImpianto);
			//e me li salvo sull'oggetto che arriva al client
			 allegatiPerImpianto.setListaAllegati(mapToElencoStoricoAllegatiPerImpianto(elencoAllegati));
		} finally {
			log.debug("[SigitMgr::cercaStoricoAllegatiPerCodiceImpianto] END");
		}
		return allegatiPerImpianto;
	}

	/**
	 * Ricerca l'elenco degli allegati relativi ad un codice impianto con le informazioni di base dell'impianto associato
	 * @param codiceImpianto
	 * @return
	 * @throws ManagerException
	 */
	public IdentificativoImpianto cercaIdentificativoImpianto(String codiceImpianto) throws ManagerException {
		IdentificativoImpianto identificativoImpianto = new IdentificativoImpianto();
		log.debug("[SigitMgr::cercaIdentificativoImpianto] BEGIN");
		try {
			 List<SigitVTotImpiantoCercaImpiantoPerAllegatiDto> listaImpianti = getDbMgr().cercaImpiantoPerAllegati(ConvertUtil.convertToInteger(codiceImpianto));
			 if(listaImpianti!=null && listaImpianti.size()>0){
				//mi setto le informazioni per l'impianto
				 identificativoImpianto = MapDto.mapToIdentificativoImpianto(listaImpianti);
			 }else{
				//vado a valorizzare solo la parte dell'ubicazione
				 SigitVTotImpiantoCercaUbicazioneImpiantoDto ubicazione = getDbMgr().cercaUbicazioneImpianto(ConvertUtil.convertToInteger(codiceImpianto));
				 identificativoImpianto =MapDto.mapToUbicazioneIdentificativoImpianto(ubicazione);
			 }

		} finally { 
			log.debug("[SigitMgr::cercaIdentificativoImpianto] END");
		}
		return identificativoImpianto;
	}


	public ArrayList<Documento> cercaDocumentiPerCodiceImpianto(String codImpianto) throws ManagerException {
		log.debug("[SigitMgr::cercaDocumentiPerCodiceImpianto] BEGIN");
		ArrayList<Documento> elencoDocumentiList = new ArrayList<Documento>();

		try
		{

			List<SigitTDocAggiuntivaByCodImpDecodDto> listaDocumenti = getDbMgr().cercaElencoDocumentiPerImpianto(ConvertUtil.convertToInteger(codImpianto));
			//devo castare l'oggetto all'elenco per il client
			if(listaDocumenti!=null && listaDocumenti.size()>0) {
				Documento elencoDocumenti = null;
				for(SigitTDocAggiuntivaByCodImpDecodDto dto : listaDocumenti){
					elencoDocumenti = MapDto.mapToDocumento(dto);

					elencoDocumentiList.add(elencoDocumenti);
				}
			}

		}
		finally {
			log.debug("[SigitMgr::cercaDocumentiPerCodiceImpianto] END");
		}

		return elencoDocumentiList;
	}

	public ArrayList<Documento> cercaDocumentiPerIdAllegato(String idAllegato) throws ManagerException {
		log.debug("[SigitMgr::cercaDocumentiPerIdAllegato] BEGIN");
		ArrayList<Documento> elencoDocumentiList = new ArrayList<Documento>();

		try
		{

			List<SigitTDocAllegatoDto> listaDocumenti = getDbMgr().cercaElencoDocumentiPerIdAllegato(ConvertUtil.convertToInteger(idAllegato));
			if(listaDocumenti!=null && listaDocumenti.size()>0) {
				Documento elencoDocumenti = null;
				for(SigitTDocAllegatoDto dto : listaDocumenti){
					elencoDocumenti = MapDto.mapToDocumento(dto);

					elencoDocumentiList.add(elencoDocumenti);
				}
			}

		}
		finally {
			log.debug("[SigitMgr::cercaDocumentiPerIdAllegato] END");
		}

		return elencoDocumentiList;
	}

	public ArrayList<DettaglioAllegato>  mapToElencoAllegatiPerImpianto(List<SigitVRicercaAllegatiDto> lista)  throws ManagerException{

		ArrayList<DettaglioAllegato> arrayAllegati = new ArrayList<DettaglioAllegato>();
		if(lista!=null && lista.size()>0){
			DettaglioAllegato dettaglio = null;
			for(SigitVRicercaAllegatiDto dto : lista){
				dettaglio = new DettaglioAllegato();
				dettaglio.setIdAllegato(""+dto.getIdAllegato());
				dettaglio.setDataControllo(ConvertUtil.convertToString(dto.getDataControllo()));
				dettaglio.setOsservazioni(dto.getFOsservazioni());
				dettaglio.setRaccomandazioni(dto.getFRaccomandazioni());
				dettaglio.setPrescrizioni(dto.getFPrescrizioni());
				dettaglio.setInterventoRaccomandato(ConvertUtil.convertToString(dto.getFInterventoEntro()));
				dettaglio.setTipoAllegato(dto.getDesTipoDocumento());
				dettaglio.setStatoAllegato(dto.getDesStatoRapp());
				dettaglio.setElencoApparecchiature(MapDto.mapToElencoApparecchiatureSplit(dto.getElencoApparecchiature()));
				arrayAllegati.add(dettaglio);
			}
		}

		return arrayAllegati;
	}

	public ArrayList<DettaglioAllegato>  mapToElencoAllegatiPerImpiantoHasVerifiche(List<SigitVRicercaAllegatiByCodiceImpiantoCountVerificheDto> lista)
			throws ManagerException, SigitTAllegatoDaoException {

		ArrayList<DettaglioAllegato> arrayAllegati = new ArrayList<DettaglioAllegato>();
		if(lista!=null && lista.size()>0){
			DettaglioAllegato dettaglio = null;
			for(SigitVRicercaAllegatiByCodiceImpiantoCountVerificheDto dto : lista){
				SigitTAllegatoDto allegatoDto = getDbMgr().getSigitTAllegatoDao().findByPrimaryKey(new SigitTAllegatoPk(dto.getIdallegato()));
				dettaglio = new DettaglioAllegato();
				dettaglio.setIdAllegato(""+dto.getIdallegato());
				dettaglio.setDataControllo(ConvertUtil.convertToString(dto.getDatacontrollo()));
				dettaglio.setOsservazioni(dto.getOsservazioni());
				dettaglio.setRaccomandazioni(dto.getRaccomandazioni());
				dettaglio.setPrescrizioni(dto.getPrescrizioni());
				dettaglio.setInterventoRaccomandato(ConvertUtil.convertToString(dto.getInterv()));
				dettaglio.setTipoAllegato(dto.getDescdocumento());
				dettaglio.setStatoAllegato(dto.getDescstatorapp());
				dettaglio.setElencoApparecchiature(MapDto.mapToElencoApparecchiatureSplit(dto.getElencoapp()));
				String presenzaVerifica = (dto.getNum_verifiche().intValue() > 0) ? "V" : " ";
				dettaglio.setPresenzaVerifica(presenzaVerifica);
				if (allegatoDto.getUidIndexFirmato() != null)
					dettaglio.setFlgFirmato("SI");
				else
					dettaglio.setFlgFirmato("NO");

				arrayAllegati.add(dettaglio);
			}
		}

		return arrayAllegati;
	}

	public ArrayList<DettaglioAllegato> mapToElencoStoricoAllegatiPerImpianto(List<SigitVRicercaAllegatiStoricoDto> lista)  throws ManagerException{

		ArrayList<DettaglioAllegato> arrayAllegati = new ArrayList<DettaglioAllegato>();
		if(lista!=null && lista.size()>0){
			DettaglioAllegato dettaglio = null;
			for(SigitVRicercaAllegatiStoricoDto dto : lista){
				dettaglio = new DettaglioAllegato();
				dettaglio.setIdAllegato(""+dto.getIdAllegato());
				dettaglio.setDataControllo(ConvertUtil.convertToString(dto.getDataControllo()));
				dettaglio.setOsservazioni(dto.getFOsservazioni());
				dettaglio.setRaccomandazioni(dto.getFRaccomandazioni());
				dettaglio.setPrescrizioni(dto.getFPrescrizioni());
				dettaglio.setInterventoRaccomandato(ConvertUtil.convertToString(dto.getFInterventoEntro()));
				dettaglio.setTipoAllegato(dto.getDesTipoDocumento());
				dettaglio.setStatoAllegato(dto.getDesStatoRapp());
				dettaglio.setElencoApparecchiature(MapDto.mapToElencoApparecchiatureSplit(dto.getElencoApparecchiature()));
				arrayAllegati.add(dettaglio);
			}
		}

		return arrayAllegati;
	}

	public IdentificativoImpianto caricaDatiImpiantoPerAllegati(String codiceImpianto) throws ManagerException {
		try {
			List<SigitVTotImpiantoCercaImpiantoPerAllegatiDto> listaImpianti = getDbMgr().cercaImpiantoPerAllegati(ConvertUtil.convertToInteger(codiceImpianto));
			if(listaImpianti!=null && listaImpianti.size()>0){
				//mi setto le informazioni per l'impianto
				return MapDto.mapToImpiantoPerIspezioni(listaImpianti);
			} else{
				//vado a valorizzare solo la parte dell'ubicazione
				SigitVTotImpiantoCercaUbicazioneImpiantoDto ubicazione = getDbMgr().cercaUbicazioneImpianto(ConvertUtil.convertToInteger(codiceImpianto));
				return MapDto.mapToUbicazioneImpiantoPerIspezioni(ubicazione);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}

	}


	/**
	 * Ricerca l'elenco delle ispezioni relative ad un codice impianto con le informazioni di base dell'impianto associato
	 * @param codiceImpianto
	 * @return
	 * @throws ManagerException
	 */
	public IspezioniPerImpianto cercaIspezioniPerCodiceImpianto(String codiceImpianto) throws ManagerException {
		IspezioniPerImpianto ispezioniPerImpianto = new IspezioniPerImpianto();
		log.debug("[SigitMgr::cercaIspezioniPerCodiceImpianto] BEGIN");
		try {
			Integer codImpianto = ConvertUtil.convertToInteger(codiceImpianto);
			 ispezioniPerImpianto.setIdentificativoImpianto(caricaDatiImpiantoPerAllegati(codiceImpianto));
			 //trovo l'arraylist per l'elenco delle ispezioni
			 List<SigitVRicercaIspezioniDto> elencoIspezioni = getDbMgr().cercaElencoIspezioniPerImpianto(codImpianto);
			//e me li salvo sull'oggetto che arriva al client
			 ispezioniPerImpianto.setListaIspezioni(MapDto.mapToElencoIspezioniPerImpianto(elencoIspezioni));
		} finally {
			log.debug("[SigitMgr::cercaIspezioniPerCodiceImpianto] END");
		}
		return ispezioniPerImpianto;
	}

	/**
	 * Ricerca l'elenco delle ispezioni relative ad un codice impianto con le informazioni di base dell'impianto associato
	 * @param codiceImpianto
	 * @return
	 * @throws ManagerException
	 */
	public ArrayList<DettaglioAllegato> cercaRappProvaPerIdIspezione(Integer idIspezione) throws ManagerException {
		ArrayList<DettaglioAllegato> elencoAllegati = null;

		log.debug("[SigitMgr::cercaRappProvaPerIdIspezione] BEGIN");
		try {

			// cerco l'arraylist dell'elenco dei Rapporti Prova
			 List<SigitTAllegatoRappProvaByIdIspezioneDto> elencoRappProvaIspezioni = getDbMgr().cercaElencoRapProvaPerIspezione(idIspezione);

			 elencoAllegati = MapDto.mapToElencoRappProva(elencoRappProvaIspezioni);

		} finally {
			log.debug("[SigitMgr::cercaRappProvaPerIdIspezione] END");
		}
		return elencoAllegati;
	}


	/**
	 * Ricerca l'elenco codici impianto in base al codice fiscale dell'utente loggato e del ruolo funzionale
	 * @param codiceFiscaleUtente
	 * @param codiceFiscaleDitta
	 * @param descrizioneRuolo
	 * @return
	 * @throws ManagerException
	 */
	public ArrayList<String> cercaCodiciImpiantoPersFisicaGiuridica(FiltroRicercaCodiciImpianto filtro) throws ManagerException {
		 ArrayList<String> array = new  ArrayList<String>();
		log.debug("[SigitMgr::cercaCodiciImpiantoPersFisicaGiuridica] BEGIN");
		try {

			//Dipende dal ruolo funzionale che arriva dal filtro(se metto la descrizione funzionale non e' detto che mi tiri un solo id)
			ArrayList<BigDecimal> elencoIdRuolo = getDbMgr().cercaIdRuoloByDescRuoloFunzionale(filtro.getDescrizioneRuoloFunzionale());
			ArrayList<String> listaIdRuoli = new ArrayList<String>();

			for(BigDecimal big : elencoIdRuolo){
				if(big !=null)
					listaIdRuoli.add(""+big);
			}
			filtro.setIdRuolo(listaIdRuoli);

			if(filtro.getDescrizioneRuoloFunzionale().equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)
					|| filtro.getDescrizioneRuoloFunzionale().equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO_IMPRESA)){
				log.debug("[SigitMgr::cercaAllegatiPerCodiceImpianto] RESPONSABILE IMPRESA*************** ");
				 //devo considerare il codice fiscale della persona giuridica
				List<SigitTPersonaGiuridicaDto> personaGiuridica = getDbMgr().cercaPersonaGiuridica(filtro.getCodiceFiscalePersonaGiuridica(), filtro.getSiglaRea(), ConvertUtil.convertToBigDecimal(filtro.getNumeroRea()));
				//immagino che me ne tira solo uno
				SigitTPersonaGiuridicaDto pg = personaGiuridica.get(0);
				filtro.setIdPersonaGiuridica(pg.getIdPersonaGiuridica().toString());
				//vado a cercare la lista dei codici impianto
				List<SigitRImpRuoloPfpgDto> lista = getDbMgr().cercaCodiciImpiantoResponsabileAmministratore(filtro);
				if(lista!=null && lista.size()>0){
					log.debug("[SigitMgr::cercaCodiciImpiantoPersFisicaGiuridica] AMMINISTRATORE*************** dimensione codici impianto : "+lista.size());
					for(SigitRImpRuoloPfpgDto dtoRpfpg: lista){
						array.add(dtoRpfpg.getCodiceImpianto().toString());
					}
				}

			}else if(filtro.getDescrizioneRuoloFunzionale().equalsIgnoreCase(Constants.RUOLO_RESPONSABILE)
					|| filtro.getDescrizioneRuoloFunzionale().equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO)){
				log.debug("[SigitMgr::cercaAllegatiPerCodiceImpianto] RESPONSABILE *************** ");
				//devo considerare il codice fiscale dell'utente loggato (persona fisica)
				PersonaFisica personaFisica = cercaPersonaFisicaByCF(filtro.getCodiceFiscaleUtenteLoggato());
				filtro.setIdPersonaFisica(""+personaFisica.getIdPersonaFisica());
				//vado a cercare la lista dei codici impianto
				List<SigitRImpRuoloPfpgDto> listaCodici = getDbMgr().cercaCodiciImpiantoResponsabileAmministratore(filtro);
				if(listaCodici!=null && listaCodici.size()>0){
					log.debug("[SigitMgr::cercaAllegatiPerCodiceImpianto] RESPONSABILE*************** dimensione codici impianto : "+listaCodici.size());
					for(SigitRImpRuoloPfpgDto dtoRpf: listaCodici){
						array.add(dtoRpf.getCodiceImpianto().toString());
					}
				}
			}else{
				log.debug("[SigitMgr::cercaAllegatiPerCodiceImpianto] TERZO RESPONSABILE *************** ");
				//sono nel caso del terzo responsabile
				//devo considerare il codice fiscale della persona giuridica
				List<SigitTPersonaGiuridicaDto> personaGiuridica = getDbMgr().cercaPersonaGiuridica(filtro.getCodiceFiscalePersonaGiuridica(), filtro.getSiglaRea(), ConvertUtil.convertToBigDecimal(filtro.getNumeroRea()));
				//immagino che ci sia una sola persona giuridica con quel codice fiscale
				SigitTPersonaGiuridicaDto personaGiuridicaDto = personaGiuridica.get(0);
				try {
					List<SigitTContratto2019Dto> listaContratti3Resp = getDbMgr().getSigitTContratto2019Dao().findById3Responsabile(personaGiuridicaDto.getIdPersonaGiuridica());

					if(listaContratti3Resp!=null && listaContratti3Resp.size()>0){
						log.debug("[SigitMgr::cercaAllegatiPerCodiceImpianto] TERZO RESPONSABILE DIMENSIONE: "+listaContratti3Resp.size());
						for(SigitTContratto2019Dto dto: listaContratti3Resp){
							array.add(ConvertUtil.convertToString(dto.getCodiceImpianto()));
						}
					}

				} catch (SigitTContratto2019DaoException e) {
					throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
				}

			}

		} finally {
			log.debug("[SigitMgr::cercaCodiciImpiantoPersFisicaGiuridica] END");
		}
		return array;
	}

	public PersonaFisica cercaPersonaFisicaByCF(String cf) throws ManagerException {
		log.debug("[SigitMgr::cercaPersonaFisicaByCF] BEGIN");
		PersonaFisica personaFisica = null;
		try
		{
			personaFisica = getDbMgr().cercaPersonaFisicaByCF(cf);

		}
		finally {
			log.debug("[SigitMgr::cercaPersonaFisicaByCF] END");
		}

		return personaFisica;
	}


	public ArrayList<Delegato> cercaDelegatiPotenzialiCodFiscaleDenominazione(String codiceFiscale, String cognome) throws ManagerException {
		log.debug("[SigitMgr::cercaDelegatiPotenzialiCodFiscaleDenominazione] BEGIN");
		try {

			ArrayList<Delegato> listaDelegatiPot = new ArrayList<Delegato>();

			List<SigitVPfPgDto> listaDelegatiPotDB = new ArrayList<SigitVPfPgDto>();

			if (GenericUtil.isNotNullOrEmpty(codiceFiscale))
			{
				listaDelegatiPotDB = getDbMgr().cercaPersonaByCodiceFiscale(GenericUtil.getStringValid(codiceFiscale), false);
			}
			else if (GenericUtil.isNotNullOrEmpty(cognome))
			{
				listaDelegatiPotDB = getDbMgr().cercaPersonaByDenominazione(GenericUtil.getStringValid(cognome), false);
			}


			for (SigitVPfPgDto sigitVPfPgDto : listaDelegatiPotDB) {

				listaDelegatiPot.add(MapDto.mapToDelegato(sigitVPfPgDto));
			}

			return listaDelegatiPot;
		}
		finally {
			log.debug("[SigitMgr::cercaDelegatiPotenzialiCodFiscaleDenominazione] END");
		}
	}

	public Integer cercaElencoAllegatiCount(RicercaAllegati ricercaAllegati, String descrizioneRuoloFunzionale) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoAllegatiCount] BEGIN");
		Integer count = 0;
		try
		{
			FiltroRicercaAllegati filter = MapDto.mapToFiltroRicercaAllegati(ricercaAllegati, descrizioneRuoloFunzionale);

			count = getDbMgr().cercaAllegatiByFiltroCount(filter);

		}
		finally {
			log.debug("[SigitMgr::cercaElencoAllegatiCount] END");
		}

		return count;
	}

	public ArrayList<ElencoAllegati> cercaElencoAllegati(RicercaAllegati ricercaAllegati, String descrizioneRuoloFunzionale, String istatAbilitazione) throws ManagerException, ServiceException {
		log.debug("[SigitMgr::cercaElencoAllegati] BEGIN");
		ArrayList<ElencoAllegati> elencoAllegatiList = new ArrayList<ElencoAllegati>();

		try
		{
			FiltroRicercaAllegati filter = MapDto.mapToFiltroRicercaAllegati(ricercaAllegati, descrizioneRuoloFunzionale);
			if (GenericUtil.isNotNullOrEmpty(istatAbilitazione) && istatAbilitazione.length() > 2) {
				if(istatAbilitazione.length() == 8) {
					String comune = getComumeByIstatAbilitazione(istatAbilitazione);
					filter.setComuneImpianto(comune);
				}
				if(istatAbilitazione.length() == 5) {
					String siglaProvincia = getSiglaProvinciaByIstatAbilitazione(istatAbilitazione);
					filter.setSiglaProvImpianto(siglaProvincia);
				}
				filter.setIstatAbilitazione(istatAbilitazione);
			}
			List<SigitVRicercaAllegatiDto> listaAllegati = getDbMgr().cercaAllegatiByFiltro(filter);
			//devo castare l'oggetto all'elenco per il client
			if(listaAllegati!=null && listaAllegati.size()>0){
				ElencoAllegati elencoAllegati = null;
				for(SigitVRicercaAllegatiDto dto : listaAllegati){
					elencoAllegati = MapDto.mapToElencoAllegati(dto);

					elencoAllegatiList.add(elencoAllegati);
				}
			}

		}
		finally {
			log.debug("[SigitMgr::cercaElencoAllegati] END");
		}

		return elencoAllegatiList;
	}

	public ElencoAllegati cercaAllegatoById(String idAllegato) throws ManagerException {
		log.debug("[SigitMgr::cercaAllegatoById] BEGIN");
		ElencoAllegati allegato = null;

		try
		{
			SigitVRicercaAllegatiDto allegatoDto = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);

			if (allegatoDto != null)
			{
				allegato = MapDto.mapToElencoAllegati(allegatoDto);
			}
		}
		finally {
			log.debug("[SigitMgr::cercaAllegatoById] END");
		}

		return allegato;
	}

	public DettaglioManutenzione cercaDettaglioManutenzioneById(String idAllegato) throws DbManagerException {
		log.debug("[SigitMgr::cercaDettaglioManutenzioneById] BEGIN");
		DettaglioManutenzione manutenzione = null;

		try
		{
			SigitVRicercaAllegatiDto allegatoDto = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);

			if (allegatoDto != null)
			{
				manutenzione = MapDto.mapToDettaglioManutenzione(allegatoDto);
			}
		}
		finally {
			log.debug("[SigitMgr::cercaDettaglioManutenzioneById] END");
		}

		return manutenzione;
	}

	public Integer cercaStatoLibrettoByCodiceImpianto(String codiceImpianto) throws ManagerException {
		log.debug("[SigitMgr::cercaStatoLibrettoByCodiceImpianto] BEGIN");
		Integer value = null;
		try
		{
			List<SigitTLibrettoDto> lista = getDbMgr().getListaLibrettiByCodiceImpianto(ConvertUtil.convertToInteger(codiceImpianto));
			if(lista!=null && lista.size()>0){
				SigitTLibrettoDto dto = lista.get(0);
				if(dto.getFkStato()!=null)
					value = ConvertUtil.convertToInteger(dto.getFkStato());
			}
		}
		finally {
			log.debug("[SigitMgr::cercaStatoLibrettoByCodiceImpianto] END");
		}
		return value;
	}

	/*
	 // Non vengono piu' gestiti i libretti in stato BOZZA, quindi togliamo il controllo
	public boolean isPresenteLibrettoBozza(String idImpianto) throws ServiceException {
		log.debug("[SigitMgr::isPresenteLibrettoBozza] BEGIN");
//		DettaglioAllegatoIndex result = new DettaglioAllegatoIndex();
		try {

			boolean isPresente = false;
			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(idImpianto,  Constants.ID_STATO_LIBRETTO_BOZZA);

			if (librettoList != null && librettoList.size() > 0)
			{
				isPresente = true;
			}

			return isPresente;

		}catch (Exception e) {
				log.error("Errore isPresenteLibrettoBozza",e);
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[SigitMgr::isPresenteLibrettoBozza] END");
		}
	}
	*/

	public boolean isPresenteLibrettoConsolidato(String idImpianto) throws ServiceException {
		log.debug("[SigitMgr::isPresenteLibrettoConsolidato] BEGIN");
//		DettaglioAllegatoIndex result = new DettaglioAllegatoIndex();
		try {

			boolean isPresente = false;

			SigitTLibrettoDto libretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(idImpianto);
			/*
			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(idImpianto,  Constants.ID_STATO_LIBRETTO_CONSOLIDATO);

			if (librettoList != null && librettoList.size() > 0)
			{
				isPresente = true;
			}
			*/

			if (libretto != null)
			{
				isPresente = true;
			}

			return isPresente;

		}catch (Exception e) {
				log.error("Errore isPresenteLibrettoConsolidato",e);
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[SigitMgr::isPresenteLibrettoConsolidato] END");
		}
	}


	public boolean isPresenteLibretto(String idImpianto) throws ServiceException {
		log.debug("[SigitMgr::isPresenteLibretto] BEGIN");
//		DettaglioAllegatoIndex result = new DettaglioAllegatoIndex();
		try {

			boolean isPresente = false;
			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibretto(idImpianto);

			if (librettoList != null && librettoList.size() > 0)
			{
				isPresente = true;
			}

			return isPresente;

		}catch (Exception e) {
				log.error("Errore isPresenteLibretto",e);
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[SigitMgr::isPresenteLibretto] END");
		}
	}


	public boolean isUtenteAutorizzato(String cfUtenteLoggato) throws ServiceException {
		log.debug("[SigitMgr::isUtenteAutorizzato] BEGIN");
//		DettaglioAllegatoIndex result = new DettaglioAllegatoIndex();
		try {

			boolean isAutorizzato = false;
			String utentiAutorizzati = getDbMgr().cercaConfigValueCarattere(Constants.CIT_UTENTI_AUTORIZZATI);

			if (GenericUtil.isNotNullOrEmpty(utentiAutorizzati))
			{
				String[] cf = utentiAutorizzati.split(",");
				for (int i = 0; i < cf.length; i++) {
					if (cf[i].equalsIgnoreCase(cfUtenteLoggato)) {
						isAutorizzato = true;
						break;
					}
				}
			}

			return isAutorizzato;

		}catch (Exception e) {
				log.error("Errore isUtenteAutorizzato",e);
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[SigitMgr::isUtenteAutorizzato] END");
		}
	}

	/*
	public boolean verificaUtentePerTipoDocumento(String codiceImpianto, Integer idPersonaGiuridica, String idTipoDocumento) throws ManagerException {
		log.debug("[SigitMgr::verificaUtentePerTipoDocumento] BEGIN");
		boolean value = false;
		BigDecimal idRuolo = null;
		try
		{
//			serve???? Si
//					o visto che ci sono i filtri prima questo passo non serve piu'?
//							se serve devo passare anche l'elenco dei progressivi??
//							verificare anche gli altri punti in cui viene richiamato findByPersonaGiuridicaCodImpianto
//
			//cerco il ruolo dal documento selezionato
			FiltroControlloInserisciAllegato dtoInput = new FiltroControlloInserisciAllegato();
			dtoInput.setIdTipoDocumento(ConvertUtil.convertToInteger(idTipoDocumento));
			List<SigitRRuoloTipodocDto> dtoRTipoDoc = getDbMgr().getSigitRRuoloTipodocDao().findVerificaAllegatoSelezionato(dtoInput);
			if(dtoRTipoDoc!=null && dtoRTipoDoc.size()>0){
				SigitRRuoloTipodocDto dtoTipoDoc = dtoRTipoDoc.get(0);
				idRuolo = dtoTipoDoc.getIdRuolo();
			}
			log.debug("++++++++++++++++++ FRAAAAAAAAAAAAAAAAA idRuolo: "+idRuolo);
			//vado a verificare se esiste un record con quei i valori in input
			SigitRImpRuoloPfpgDto input = new SigitRImpRuoloPfpgDto();
			input.setCodiceImpianto(new BigDecimal(codiceImpianto));
			input.setFkPersonaGiuridica(new BigDecimal(ConvertUtil.convertToString(idPersonaGiuridica)));
			input.setFkRuolo(idRuolo);
			log.debug("FRAAAAAAAAAAAA ---> [SigitMgr::verificaUtentePerTipoDocumento] idPersonaGiuridica: "+idPersonaGiuridica);
			log.debug("FRAAAAAAAAAAAA ---> [SigitMgr::verificaUtentePerTipoDocumento] idTipoDocumento: "+idTipoDocumento);
			List<SigitRImpRuoloPfpgDto> dtoRImp = getDbMgr().getSigitRImpRuoloPfpgDao().findByPersonaGiuridicaCodImpianto(input);
			if(dtoRImp!=null && dtoRImp.size()>0){
				//ha trovato almeno un valore
				value = true;
			}else{
				value = false;
				throw new ManagerException(new Message(Messages.S053));
			}
		}
		catch (SigitRImpRuoloPfpgDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitRRuoloTipodocDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::verificaUtentePerTipoDocumento] END");
		}
		return value;
	}
	*/


	public PersonaGiuridica verificaTipoDocumentoAssociatoManutentore(String codiceImpianto,String idTipoDocumento) throws ManagerException {
		log.debug("[SigitMgr::verificaTipoDocumentoAssociatoManutentore] BEGIN");
		PersonaGiuridica personaGiuridica = null;
		BigDecimal idRuolo = null;
		SigitRRuoloTipodocDto sigitRRuoloTipodocDto = null;
		List<SigitRImpRuoloPfpgDto> relazione =null;
		String tipoDocumento = null;
		try
		{

			//mi serve la descrizione del documento selezionato e dell'impianto su cui sto lavorando
			tipoDocumento = getDbMgr().getDescrizioneTipoAllegato(new BigDecimal(idTipoDocumento));

			//cercare dalla tabella sigit_r_ruolo_tipodoc il ruolo associato al tipo documento selezionato
			FiltroControlloInserisciAllegato inputRuoloTipoDoc = new FiltroControlloInserisciAllegato();
			inputRuoloTipoDoc.setIdTipoDocumento(ConvertUtil.convertToInteger(idTipoDocumento));
			List<SigitRRuoloTipodocDto> lista = getDbMgr().getSigitRRuoloTipodocDao().findVerificaAllegatoSelezionato(inputRuoloTipoDoc);
			if(lista!=null && lista.size()>0){
				//me ne aspetto solo un record di questa lista
				sigitRRuoloTipodocDto = lista.get(0);
				//mi vado a settare il ruolo del manutentore che cercavo associato al tipo documento selezionato
				idRuolo = sigitRRuoloTipodocDto.getIdRuolo();
			}

			log.debug("************************ FRAAAAAAAAAAAAAAAAA idRuolo: "+idRuolo);

			if(idRuolo!=null){
				//cerco il manutentore dalla tabella sigit_r_imp_ruolo_pfpg
				FiltroRicercaPfPg input = new FiltroRicercaPfPg();
				input.setCodiceImpianto(codiceImpianto);
				input.setIdRuolo(ConvertUtil.convertToString(idRuolo));

				relazione = getDbMgr().getSigitRImpRuoloPfpgDao().findAttiviByFilter(input );
			}

			log.debug("************************ FRAAAAAAAAAAAAAAAAA relazione: "+relazione);

			if(relazione!=null && relazione.size()>0){
				//ne avra' trovato solo uno
				SigitRImpRuoloPfpgDto dto = relazione.get(0);
				//il manutentore e' una impresa quindi mi aspetto un idPersonaGiuridica
				personaGiuridica = getDbMgr().cercaPersonaGiuridicaById(ConvertUtil.convertToInteger(""+dto.getFkPersonaGiuridica()));
			}else{
				//non ha trovato nulla lancio l'eccezione
				throw new ManagerException(new Message(Messages.S054,tipoDocumento,codiceImpianto));
			}

		}
		catch (SigitRImpRuoloPfpgDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitRRuoloTipodocDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::verificaTipoDocumentoAssociatoManutentore] END");
		}
		return personaGiuridica;
	}


	/*
	public ArrayList<CodeDescription> cercaElencoNumeriBollinoVerde(UtenteLoggato utenteLoggato, Integer idTipoDocumento, Integer codiceImpianto, String idAllegato) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoNumeriBollinoVerde] BEGIN");
		ArrayList<CodeDescription> numeriBollinoVerdeList = new ArrayList<CodeDescription>();
		try
		{
			// L'installatore deve anche lui selezionare le apparecchiature?
			if(utenteLoggato.getRuolo().getDescRuolo().equalsIgnoreCase(Constants.RUOLO_INSTALLATORE)
					||utenteLoggato.getRuolo().getDescRuolo().equalsIgnoreCase(Constants.RUOLO_MANUTENTORE)){

				FiltroRicercaNumeriBollino input = new FiltroRicercaNumeriBollino();
				input.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
				input.setIdPersonaGiuridica(utenteLoggato.getRuolo().getIdPersonaGiuridica());
				if(GenericUtil.isNotNullOrEmpty(idAllegato))
					input.setIdAllegato(ConvertUtil.convertToInteger(idAllegato));
				//so gia' chi e' l'impresa perche' ho l'idPersonaGiuridica, precarico la combo
				List<SigitTTransazioneBollByElencoNumeriBollinoByPersGiuridicaDto> lista =
						this.getDbMgr().getSigitTTransazioneBollDao().findByElencoNumeriBollinoByPersGiuridica(input);
				if(lista!=null && lista.size()>0){
					numeriBollinoVerdeList = MapDto.mapToNumeriBollino(lista);
				}

			}
			else
			{
				if(idTipoDocumento!=null){
					BigDecimal  idRuolo = null;
					BigDecimal idPersonaGiuridica = null;
					//mi vado a cercare l'idPersonaGiuridica a partire dal documento
					//cercare dalla tabella sigit_r_ruolo_tipodoc il ruolo associato al tipo documento selezionato
					FiltroControlloInserisciAllegato inputRuoloTipoDoc = new FiltroControlloInserisciAllegato();
					inputRuoloTipoDoc.setIdTipoDocumento(idTipoDocumento);
					List<SigitRRuoloTipodocDto> listaTipoDoc = getDbMgr().getSigitRRuoloTipodocDao().findVerificaAllegatoSelezionato(inputRuoloTipoDoc);
					if(listaTipoDoc!=null && listaTipoDoc.size()>0){
						//me ne aspetto solo un record di questa lista
						SigitRRuoloTipodocDto sigitRRuoloTipodocDto = listaTipoDoc.get(0);
						//mi vado a settare il ruolo del manutentore che cercavo associato al tipo documento selezionato
						idRuolo = sigitRRuoloTipodocDto.getIdRuolo();
					}

					if(idRuolo!=null){
						//cerco il manutentore dalla tabella sigit_r_imp_ruolo_pfpg
//						SigitRImpRuoloPfpgDto inputPfPg = new SigitRImpRuoloPfpgDto();
//						inputPfPg.setCodiceImpianto(new BigDecimal(codiceImpianto));
//						inputPfPg.setFkRuolo(idRuolo);
//
//						List<SigitRImpRuoloPfpgDto> sigitRImpRuoloPfpgDtoList = getDbMgr().getSigitRImpRuoloPfpgDao().findAttiviByFilter(inputPfPg);

						SigitRComp4ManutDto inputComp4Manut = new SigitRComp4ManutDto();
						inputComp4Manut.setCodiceImpianto(new BigDecimal(codiceImpianto));
						inputComp4Manut.setFkRuolo(idRuolo);
						List<SigitRComp4ManutDto> sigiRComp4ManutDtoList = getDbMgr().getSigitRComp4ManutDao().findAttiviByFilter(inputComp4Manut);

						if(sigiRComp4ManutDtoList!=null && sigiRComp4ManutDtoList.size()>0){
							//ne avra' trovao solo uno
							SigitRComp4ManutDto dto = sigiRComp4ManutDtoList.get(0);
							idPersonaGiuridica = dto.getFkPersonaGiuridica();
						}



						//finalmente ho il parametro cercato e vado a caricare la lista
						log.debug("FRAAAAAAAAAAAAAAAAAAAAAAAAA --------------> idPersonaGiuridica: "+idPersonaGiuridica);
						if(idPersonaGiuridica!=null){
							FiltroRicercaNumeriBollino input = new FiltroRicercaNumeriBollino();
							input.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
							input.setIdPersonaGiuridica(ConvertUtil.convertToInteger(idPersonaGiuridica));
							if(GenericUtil.isNotNullOrEmpty(idAllegato))
								input.setIdAllegato(ConvertUtil.convertToInteger(idAllegato));
							List<SigitTTransazioneBollByElencoNumeriBollinoByPersGiuridicaDto> elencoNumeri =
									this.getDbMgr().getSigitTTransazioneBollDao().findByElencoNumeriBollinoByPersGiuridica(input);
							if(elencoNumeri!=null && elencoNumeri.size()>0){
								numeriBollinoVerdeList = MapDto.mapToNumeriBollino(elencoNumeri);
							}else{
								numeriBollinoVerdeList = new ArrayList<CodeDescription>();
							}
						}

					}

				}
				else{
					//sono un SUPER o VALIDATORE e la lista e' vuota la carica quando sceglie una tipologia di documento
					numeriBollinoVerdeList = new ArrayList<CodeDescription>();
				}
			}

		} catch (SigitTTransazioneBollDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitRRuoloTipodocDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitRComp4ManutDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::cercaElencoNumeriBollinoVerde] END");
		}

		return numeriBollinoVerdeList;
	}
	*/

	/*
	public ArrayList<CodeDescription> cercaElencoNumeriBollinoVerdeOLD(Integer idManutentore, Integer codiceImpianto, String idAllegato) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoNumeriBollinoVerde] BEGIN");
		ArrayList<CodeDescription> numeriBollinoVerdeList = new ArrayList<CodeDescription>();
		try
		{

			FiltroRicercaNumeriBollino input = new FiltroRicercaNumeriBollino();
			input.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
			input.setIdPersonaGiuridica(idManutentore);
			if(GenericUtil.isNotNullOrEmpty(idAllegato)) {
				input.setIdAllegato(ConvertUtil.convertToInteger(idAllegato));
			}

			//so gia' chi e' l'impresa perche' ho l'idPersonaGiuridica, precarico la combo
			List<SigitTTransazioneBollByElencoNumeriBollinoByPersGiuridicaDto> lista =
					this.getDbMgr().getSigitTTransazioneBollDao().findByElencoNumeriBollinoByPersGiuridica(input);
			if(lista!=null && lista.size()>0){
				numeriBollinoVerdeList = MapDto.mapToNumeriBollino(lista);
			}

		} catch (SigitTTransazioneBollDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::cercaElencoNumeriBollinoVerde] END");
		}

		return numeriBollinoVerdeList;
	}
	*/

	public ArrayList<IdDescription> cercaElencoClassificazioneDPR660_96()  throws ManagerException {
		log.debug("[SigitMgr::cercaElencoClassificazioneDPR660_96] BEGIN");
		ArrayList<IdDescription> classificazioni = new ArrayList<IdDescription>();

		try
		{
			List<SigitDClassDPR660_96Dto> lista =
					this.getDbMgr().getSigitDClassDPR660_96Dao().findAll();
			if(lista!=null && lista.size()>0){
				for (SigitDClassDPR660_96Dto classificazione : lista) {
					IdDescription elemento = new IdDescription();
					elemento.setId(ConvertUtil.convertToInteger(classificazione.getIdClass()));
					elemento.setDescription(classificazione.getDesClass());
					classificazioni.add(elemento);
				}
			}
		} catch(SigitDClassDPR660_96DaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}finally {
			log.debug("[SigitMgr::cercaElencoClassificazioneDPR660_96] END");
		}

		return classificazioni;
	}


	public ArrayList<IdDescription> cercaElencoFrequenzaManut() throws ManagerException {
		log.debug("[SigitMgr::cercaElencoFrequenzaManut] BEGIN");
		ArrayList<IdDescription> frequenze = new ArrayList<IdDescription>();

		try
		{
			List<SigitDFrequenzaManutDto> lista =
					this.getDbMgr().getSigitDFrequenzaManutDao().findAll();
			if(lista!=null && lista.size()>0){
				for (SigitDFrequenzaManutDto frequenza : lista) {
					IdDescription elemento = new IdDescription();
					elemento.setId(frequenza.getIdFrequenza());
					elemento.setDescription(frequenza.getDesFrequenza());
					frequenze.add(elemento);
				}
			}
		} catch(SigitDFrequenzaManutDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}finally {
			log.debug("[SigitMgr::cercaElencoFrequenzaManut] END");
		}

		return frequenze;
	}

	public ArrayList<CodeDescription> cercaElencoTipiDocumentazione(Integer idRaggDocAgg) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoTipiDocumentazione] BEGIN");
		ArrayList<CodeDescription> tipiDocumentoList = new ArrayList<CodeDescription>();
		try
		{

			//ricerco il tipo documentazione in base dalla pagina di arrivo
			List<SigitDTipoDocAggDto> lista =
					this.getDbMgr().getSigitDTipoDocAggDao().findByIdRaggDocAgg(idRaggDocAgg);
			if(lista!=null && lista.size()>0){
				tipiDocumentoList = MapDto.mapToTipoDocAgg(lista);
			}

		} catch (SigitDTipoDocAggDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::cercaElencoTipiDocumentazione] END");
		}

		return tipiDocumentoList;
	}

	public ArrayList<CodeDescription> cercaElencoTipiDocumentazione() throws ManagerException {
		log.debug("[SigitMgr::cercaElencoTipiDocumentazione] BEGIN");
		ArrayList<CodeDescription> tipiDocumentoList = new ArrayList<CodeDescription>();
		try
		{

			//ricerco il tipo documentazione in base dalla pagina di arrivo
			List<SigitDTipoDocAggDto> lista =
					this.getDbMgr().getSigitDTipoDocAggDao().findAll();
			if(lista!=null && lista.size()>0){
				tipiDocumentoList = MapDto.mapToTipoDocAgg(lista);

				CodeDescription tutti = new CodeDescription();
				tutti.setCode(Constants.ID_TUTTE);
				tutti.setDescription(Constants.DESC_TUTTI);
				tipiDocumentoList.add(0, tutti);

			}

		} catch (SigitDTipoDocAggDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::cercaElencoTipiDocumentazione] END");
		}

		return tipiDocumentoList;
	}

	/*

	public ArrayList<CodeDescription> cercaElencoNumeriBollinoVerde(UtenteLoggato utenteLoggato, Integer idTipoDocumento, Integer codiceImpianto, String idAllegato) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoNumeriBollinoVerde] BEGIN");
		ArrayList<CodeDescription> numeriBollinoVerdeList = new ArrayList<CodeDescription>();
		try
		{
			// L'installatore deve anche lui selezionare le apparecchiature?
			if(utenteLoggato.getRuolo().getDescRuolo().equalsIgnoreCase(Constants.RUOLO_INSTALLATORE)
					||utenteLoggato.getRuolo().getDescRuolo().equalsIgnoreCase(Constants.RUOLO_MANUTENTORE)){

				FiltroRicercaNumeriBollino input = new FiltroRicercaNumeriBollino();
				input.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
				input.setIdPersonaGiuridica(utenteLoggato.getRuolo().getIdPersonaGiuridica());
				if(GenericUtil.isNotNullOrEmpty(idAllegato))
					input.setIdAllegato(ConvertUtil.convertToInteger(idAllegato));
				//so gia' chi e' l'impresa perche' ho l'idPersonaGiuridica, precarico la combo
				List<SigitTTransazioneBollByElencoNumeriBollinoByPersGiuridicaDto> lista =
						this.getDbMgr().getSigitTTransazioneBollDao().findByElencoNumeriBollinoByPersGiuridica(input);
				if(lista!=null && lista.size()>0){
					numeriBollinoVerdeList = MapDto.mapToNumeriBollino(lista);
				}

			}
			else
			{
				if(idTipoDocumento!=null){
					BigDecimal  idRuolo = null;
					BigDecimal idPersonaGiuridica = null;
					//mi vado a cercare l'idPersonaGiuridica a partire dal documento
					//cercare dalla tabella sigit_r_ruolo_tipodoc il ruolo associato al tipo documento selezionato
					FiltroControlloInserisciAllegato inputRuoloTipoDoc = new FiltroControlloInserisciAllegato();
					inputRuoloTipoDoc.setIdTipoDocumento(idTipoDocumento);
					List<SigitRRuoloTipodocDto> listaTipoDoc = getDbMgr().getSigitRRuoloTipodocDao().findVerificaAllegatoSelezionato(inputRuoloTipoDoc);
					if(listaTipoDoc!=null && listaTipoDoc.size()>0){
						//me ne aspetto solo un record di questa lista
						SigitRRuoloTipodocDto sigitRRuoloTipodocDto = listaTipoDoc.get(0);
						//mi vado a settare il ruolo del manutentore che cercavo associato al tipo documento selezionato
						idRuolo = sigitRRuoloTipodocDto.getIdRuolo();
					}

					if(idRuolo!=null){
						//cerco il manutentore dalla tabella sigit_r_imp_ruolo_pfpg
//						SigitRImpRuoloPfpgDto inputPfPg = new SigitRImpRuoloPfpgDto();
//						inputPfPg.setCodiceImpianto(new BigDecimal(codiceImpianto));
//						inputPfPg.setFkRuolo(idRuolo);
//
//						List<SigitRImpRuoloPfpgDto> sigitRImpRuoloPfpgDtoList = getDbMgr().getSigitRImpRuoloPfpgDao().findAttiviByFilter(inputPfPg);

						SigitRComp4ManutDto inputComp4Manut = new SigitRComp4ManutDto();
						inputComp4Manut.setCodiceImpianto(new BigDecimal(codiceImpianto));
						inputComp4Manut.setFkRuolo(idRuolo);
						List<SigitRComp4ManutDto> sigiRComp4ManutDtoList = getDbMgr().getSigitRComp4ManutDao().findAttiviByFilter(inputComp4Manut);

						if(sigiRComp4ManutDtoList!=null && sigiRComp4ManutDtoList.size()>0){
							//ne avra' trovao solo uno
							SigitRComp4ManutDto dto = sigiRComp4ManutDtoList.get(0);
							idPersonaGiuridica = dto.getFkPersonaGiuridica();
						}



						//finalmente ho il parametro cercato e vado a caricare la lista
						log.debug("FRAAAAAAAAAAAAAAAAAAAAAAAAA --------------> idPersonaGiuridica: "+idPersonaGiuridica);
						if(idPersonaGiuridica!=null){
							FiltroRicercaNumeriBollino input = new FiltroRicercaNumeriBollino();
							input.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
							input.setIdPersonaGiuridica(ConvertUtil.convertToInteger(idPersonaGiuridica));
							if(GenericUtil.isNotNullOrEmpty(idAllegato))
								input.setIdAllegato(ConvertUtil.convertToInteger(idAllegato));
							List<SigitTTransazioneBollByElencoNumeriBollinoByPersGiuridicaDto> elencoNumeri =
									this.getDbMgr().getSigitTTransazioneBollDao().findByElencoNumeriBollinoByPersGiuridica(input);
							if(elencoNumeri!=null && elencoNumeri.size()>0){
								numeriBollinoVerdeList = MapDto.mapToNumeriBollino(elencoNumeri);
							}else{
								numeriBollinoVerdeList = new ArrayList<CodeDescription>();
							}
						}

					}

				}
				else{
					//sono un SUPER o VALIDATORE e la lista e' vuota la carica quando sceglie una tipologia di documento
					numeriBollinoVerdeList = new ArrayList<CodeDescription>();
				}
			}

		} catch (SigitTTransazioneBollDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitRRuoloTipodocDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitRComp4ManutDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::cercaElencoNumeriBollinoVerde] END");
		}

		return numeriBollinoVerdeList;
	}
	*/

	public ArrayList<CodeDescription> cercaElencoCombustibili(String idTipoDocumento) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoCombustibili] BEGIN");
		ArrayList<CodeDescription> combustibiliList = new ArrayList<CodeDescription>();
		try
		{
			ArrayList<Integer> idCombustibileTipo1BList = new ArrayList<>(Arrays.asList(Constants.ID_TIPO_COMBUSIBILE_BIOMASSA_ARRAY));
			if (StringUtils.equals(idTipoDocumento, Constants.ALLEGATO_TIPO_1) || StringUtils.equals(idTipoDocumento, Constants.RAPP_PROVA_ALLEGATO_TIPO_1)){
				combustibiliList = cercaElencoCombustibiliByNotInIdList(idCombustibileTipo1BList);
			} else if (StringUtils.equals(idTipoDocumento, Constants.ALLEGATO_TIPO_1B)) {
				combustibiliList = cercaElencoCombustibiliByIds(idCombustibileTipo1BList);
			}
		}
		catch (ManagerException e) {
			throw e;
		}
		finally {
			log.debug("[SigitMgr::cercaElencoCombustibili] END");
		}

		return combustibiliList;
	}

	public ArrayList<CodeDescription> cercaElencoCombustibiliByIds(ArrayList<Integer> idCombustibileList) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoCombustibiliByIds] BEGIN");
		ArrayList<CodeDescription> combustibiliList = new ArrayList<CodeDescription>();
		try
		{

			List<SigitDCombustibileDto> listCombustibiliDto = getDbMgr().getElencoCombustibileById(idCombustibileList);
			combustibiliList = MapDto.mapToCombustibili(listCombustibiliDto);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::cercaElencoCombustibiliByIds] END");
		}

		return combustibiliList;
	}

	public ArrayList<CodeDescription> cercaElencoCombustibiliByNotInIdList(ArrayList<Integer> idCombustibileList) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoCombustibiliByNotInIdList] BEGIN");
		ArrayList<CodeDescription> combustibiliList = new ArrayList<CodeDescription>();
		try
		{

			List<SigitDCombustibileDto> listCombustibiliDto = getDbMgr().getElencoCombustibileNotInIdList(idCombustibileList);
			combustibiliList = MapDto.mapToCombustibili(listCombustibiliDto);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::cercaElencoCombustibiliByNotInIdList] END");
		}

		return combustibiliList;
	}

	public ArrayList<CodeDescription> cercaElencoCombustibili() throws ManagerException {
		log.debug("[SigitMgr::cercaElencoCombustibili] BEGIN");
		ArrayList<CodeDescription> combustibiliList = new ArrayList<CodeDescription>();
		try
		{

			List<SigitDCombustibileDto> listCombustibiliDto = getDbMgr().getElencoCombustibile();
			combustibiliList = MapDto.mapToCombustibili(listCombustibiliDto);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::cercaElencoCombustibili] END");
		}

		return combustibiliList;
	}


	public ArrayList<CodeDescription> cercaElencoApparecchiature(DettaglioAllegato allegato) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoApparecchiature] BEGIN");
		ArrayList<CodeDescription> apparecchiatureList = new ArrayList<CodeDescription>();
		try
		{

			if (GenericUtil.isNotNullOrEmpty(allegato.getIdTipoAllegato()))
			{
				int idTipoDoc = ConvertUtil.convertToInteger(allegato.getIdTipoAllegato()).intValue();
				String descTipoComponente = null;

				if (idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_1) ||
					idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_1B) ||
					idTipoDoc == ConvertUtil.convertToInteger(Constants.RAPP_PROVA_ALLEGATO_TIPO_1))
				{
					descTipoComponente = Constants.TIPO_COMPONENTE_GT;
				}
				else if (idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_2) || idTipoDoc == ConvertUtil.convertToInteger(Constants.RAPP_PROVA_ALLEGATO_TIPO_2))
				{
					descTipoComponente = Constants.TIPO_COMPONENTE_GF;
				}
				else if (idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_3))
				{
					descTipoComponente = Constants.TIPO_COMPONENTE_SC;
				}
				else if (idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_4))
				{
					descTipoComponente = Constants.TIPO_COMPONENTE_CG;
				}


				GenericUtil.eliminaCampoVuoto(allegato.getIdTipiCombustibile());

				CompFilter filter = new CompFilter(allegato.getCodiceImpianto(), descTipoComponente, allegato.getIdTipiCombustibile(), ConvertUtil.convertToSqlDate(allegato.getDataControllo()));

				if (idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_1B)) {
					filter.setListCombustibile(ConvertUtil.convertIntegerArrayToStringList(Constants.ID_TIPO_COMBUSIBILE_BIOMASSA_ARRAY));
				}

				if (idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_1)) {
					filter.setListNotCombustibile(ConvertUtil.convertIntegerArrayToStringList(Constants.ID_TIPO_COMBUSIBILE_BIOMASSA_ARRAY));
				}

				if (allegato.getIdPersonaGiuridica() != null)
				{
					filter.setIdPG(allegato.getIdPersonaGiuridica());
				}


				List<SigitExtComponenteDto> listApparecchiatureDto = getDbMgr().findComponentiByFilter(filter, idTipoDoc);

				apparecchiatureList = MapDto.mapToComponenti(listApparecchiatureDto, false);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::cercaElencoApparecchiature] END");
		}

		return apparecchiatureList;
	}

	public ArrayList<CodeDescription> cercaElencoApparecchiatureManutenzione(DettaglioManutenzione allegato) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoApparecchiature] BEGIN");
		ArrayList<CodeDescription> apparecchiatureList = new ArrayList<CodeDescription>();
		try
		{

			if (GenericUtil.isNotNullOrEmpty(allegato.getIdTipoManut()))
			{
				int idTipoManut = allegato.getIdTipoManut().intValue();
				int idTipoRee = 0;
				String descTipoComponente = null;

				if (idTipoManut == Constants.MANUTENZIONE_GT)
				{
					idTipoRee = ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_1);
					descTipoComponente = Constants.TIPO_COMPONENTE_GT;
				}
				else if (idTipoManut == Constants.MANUTENZIONE_GF)
				{
					idTipoRee = ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_2);
					descTipoComponente = Constants.TIPO_COMPONENTE_GF;
				}
				else if (idTipoManut == Constants.MANUTENZIONE_SC)
				{
					idTipoRee = ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_3);
					descTipoComponente = Constants.TIPO_COMPONENTE_SC;
				}
				else if (idTipoManut == Constants.MANUTENZIONE_CG)
				{
					idTipoRee = ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_4);
					descTipoComponente = Constants.TIPO_COMPONENTE_CG;
				}


				CompFilter filter = new CompFilter();
				//allegato.getCodiceImpianto(), descTipoComponente, ConvertUtil.convertToSqlDate(allegato.getDataManut()));
				filter.setCodImpianto(allegato.getCodiceImpianto());
				filter.setTipoComponente(descTipoComponente);
				filter.setDataInstallazione(ConvertUtil.convertToSqlDate(allegato.getDataManut()));

				if (allegato.getIdPersonaGiuridica() != null)
				{
					filter.setIdPG(allegato.getIdPersonaGiuridica());
				}

				List<SigitExtComponenteDto> listApparecchiatureDto = getDbMgr().findComponentiByFilter(filter, idTipoRee);

				apparecchiatureList = MapDto.mapToComponenti(listApparecchiatureDto, false);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::cercaElencoApparecchiature] END");
		}

		return apparecchiatureList;
	}

	public ArrayList<CodeDescription> cercaElencoApparecchiatureSubentro(Subentro subentro) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoApparecchiatureSubentro] BEGIN");
		ArrayList<CodeDescription> apparecchiatureList = new ArrayList<CodeDescription>();
		try
		{


			if (GenericUtil.isNotNullOrEmpty(subentro.getIdTipoSubentro()))
			{
				int idTipoRuolo = subentro.getIdTipoSubentro().intValue();
				String descTipoComponente = null;

				if (idTipoRuolo == Constants.ID_RUOLO_MANUTENTORE_ALL_1)
				{
					descTipoComponente = Constants.TIPO_COMPONENTE_GT;
				}
				else if (idTipoRuolo == Constants.ID_RUOLO_MANUTENTORE_ALL_2)
				{
					descTipoComponente = Constants.TIPO_COMPONENTE_GF;
				}
				else if (idTipoRuolo == Constants.ID_RUOLO_MANUTENTORE_ALL_3)
				{
					descTipoComponente = Constants.TIPO_COMPONENTE_SC;
				}
				else if (idTipoRuolo == Constants.ID_RUOLO_MANUTENTORE_ALL_4)
				{
					descTipoComponente = Constants.TIPO_COMPONENTE_CG;
				}

				CompFilter filter = new CompFilter();
				filter.setCodImpianto(subentro.getImpCodImpianto());
				filter.setTipoComponente(descTipoComponente);
				filter.setIdPG(subentro.getRespImpId());

//				if (subentro.getIdPersonaGiuridica() != null)
//				{
//					filter.setIdPG(allegato.getIdPersonaGiuridica());
//				}

				//List<SigitTComp4Dto> listApparecchiatureDto = getDbMgr().getSigitTComp4Dao().findByFilter(filter);

				List<SigitExtComponenteDto> listApparecchiatureDto = getDbMgr().findComponentiSubentroByFilter(filter, idTipoRuolo);
//

				apparecchiatureList = MapDto.mapToComponenti(listApparecchiatureDto, true);

				if (apparecchiatureList != null && apparecchiatureList.size() > 0)
				{
					CodeDescription tutti = new CodeDescription();
					tutti.setCode(Constants.ID_TUTTE);
					tutti.setDescription(Constants.DESC_TUTTE);
					apparecchiatureList.add(0, tutti);
				}
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::cercaElencoApparecchiatureSubentro] END");
		}

		return apparecchiatureList;
	}

	public ArrayList<CodeDescription> cercaElencoApparecchiatureTerzoResp(TerzoResponsabile terzoResp) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoApparecchiatureTerzoResp] BEGIN");
		ArrayList<CodeDescription> apparecchiatureList = new ArrayList<CodeDescription>();
		try
		{
			if (GenericUtil.isNotNullOrEmpty(terzoResp))
			{

				CompFilter filter = new CompFilter();
				filter.setCodImpianto(terzoResp.getImpCodImpianto());
				filter.setDataInstallazione(ConvertUtil.convertToSqlDate(terzoResp.getDataInizioContratto()));

				List<SigitVRicercaCompComponentiByFilterDto> listApparecchiatureDto = getDbMgr().findComponentiTerzoResponsabileByFilter(filter);

				apparecchiatureList = MapDto.mapToComponenti(listApparecchiatureDto);

				if (apparecchiatureList != null && apparecchiatureList.size() > 0)
				{
					CodeDescription tutti = new CodeDescription();
					tutti.setCode(Constants.ID_TUTTE);
					tutti.setDescription(Constants.DESC_TUTTE);
					apparecchiatureList.add(0, tutti);
				}
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::cercaElencoApparecchiatureTerzoResp] END");
		}

		return apparecchiatureList;
	}

	@Transactional
	/*
	public XmlModel inserisciAllegato(DettaglioAllegato allegato, UtenteLoggato utenteLoggato)throws ManagerException {

		log.debug("[SigitMgr::inserisciAllegato] START");

		try
		{
			String idAllegato = null;
			boolean isAllegatoInInsert = false;
			XmlModel model;

			if(GenericUtil.isNullOrEmpty(allegato.getIdAllegato())){
				log.debug(" STOOOOOOOOOO INSERENDOOOOOOOOOOOOOO");
				//salvo sulla tabella SIGIT_T_ALLEGATO una parte di dati, quelli che arrivano dal client e il pdf
				BigDecimal idAllegatoNuovo = salvaAllegato(allegato, utenteLoggato);
				idAllegato = ConvertUtil.convertToString(idAllegatoNuovo);
				allegato.setIdAllegato(idAllegato);
				isAllegatoInInsert = true;
			}

			model = getXmlAllegato(allegato, isAllegatoInInsert);

			if(isAllegatoInInsert){
				//eseguo l'update sulla tabella allegato per inserirgli l'allegato con l'idAllegato al suo interno solo nel caso di inserimento
				//non c'e' bisogno nella fase di modifica
				inserisciXmlAllegato(ConvertUtil.convertToBigDecimal(allegato.getIdAllegato()), model.getXmlContent());
				// getSigitMgr().updateXmlAllegato(getDettaglioAllegato().getIdAllegato(), model.getXmlContent(), getDettaglioAllegato().getCodFiscaleUtenteLoggato());

			}

			return model;

		} catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
		finally{
			log.debug("[SigitMgr::inserisciAllegato] END");
		}
	}
	*/
	/*
	private XmlModel getXmlAllegato(DettaglioAllegato allegato, boolean isAllegatoInInsert){
		log.debug("[ModuloBuilder::getXmlAllegato] START");

		//recupero il modello xml dal documento
		XmlModel model;
		try {
			model = new XmlModel();
			byte[] xmlByteArray = null;

			if(Constants.ALLEGATO_TIPO_1.equals(allegato.getIdTipoAllegato()))
				xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getAllegato(allegato,isAllegatoInInsert));
			if(Constants.ALLEGATO_TIPO_2.equals(allegato.getIdTipoAllegato()))
				xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getAllegatoTipo2(allegato,isAllegatoInInsert));
			if(Constants.ALLEGATO_TIPO_3.equals(allegato.getIdTipoAllegato()))
				xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getAllegatoTipo3(allegato,isAllegatoInInsert));
			if(Constants.ALLEGATO_TIPO_4.equals(allegato.getIdTipoAllegato()))
				xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getAllegatoTipo4(allegato,isAllegatoInInsert));
			if(xmlByteArray == null)
				throw new ServiceException("xmlByteArray modulo non trovato");

			model.setXmlContent(xmlByteArray);
			return model;
		}catch(Exception e){
			log.error("Errore", e);
			return null;
		} finally{
			log.debug("[ModuloBuilder::getXmlAllegato] END");

		}
	}
	*/
	/*
	public void inviaAllegatoTrans(DettaglioAllegato dettaglio, Integer idPgCat, String cfUtenteLoggato)throws ManagerException {
		log.debug("[SigitMgr::inviaAllegatoTrans] START");
		try {
			inviaAllegatoNow(dettaglio, cfUtenteLoggato, false, idPgCat);

			inviaAllegatoLibretto(dettaglio, cfUtenteLoggato, false, idPgCat);
		}
		catch (ManagerException e) {

			log.debug("PRIMA DELLA TRANSAZIONALITA'");
			log.debug("DOPO LA TRANSAZIONALITA'");


			throw e;
		}
		log.debug("[SigitMgr::inviaAllegatoTrans] END");

	}
	*/
	/*
	public DettaglioDocumento getAllegatoPdfNow(DettaglioAllegato dettaglio) throws ServiceException {

		log.debug("[SigitMgr::getAllegatoPdfNow] BEGIN");
		DettaglioDocumento result = new DettaglioDocumento();
		try{

			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(ConvertUtil.convertToBigDecimal(dettaglio.getIdAllegato()));
			//devo caricare l'oggetto Allegato dal DB perche' devo ottenere l'xml dell'allegato
			//SigitTAllegatoDto allegatoDto = getDbMgr().getSigitTAllegatoDao().findByPrimaryKey(pk);

			//XmlModel xmlModel = getAllegatoXmlModel(dettaglio, allegatoDto);
			XmlModel xmlModel = getAllegatoXmlModel(dettaglio, false);


			//log.debug("FRAAAAAAAAAAAAAAAAAAAA 1.2 STEP  allegatoDto.getFkTipoDocumento(): "+allegatoDto.getFkTipoDocumento());
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 1.2 STEP  dettaglio.getIdTipoAllegato(): "+dettaglio.getIdTipoAllegato());

			String tipoDocumento = GenericUtil.getModelloModolAllegato(dettaglio.getIdTipoAllegato().toString());

			Applicazione app = new Applicazione();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);



			//quello che cambia e' xmlModel in base ai tipi di allegati che mi arrivano
			Modulo modulo = getServiziMgr().cercaModulo(app, tipoDocumento);

			if (log.isDebugEnabled())
				log.debug("FRAAAAAAAAAAAAAAAAAAAA 6.1 STEP  modulo: "+modulo);

			RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
			modulo = getServiziMgr().getModol().mergeModulo(app, null, modulo, xmlModel);

			byte[] thePdfStatico = getServiziMgr().creaModuloStaticoModol(modulo);

			//a questo punto recupero l'xml dal modulo aggiornato
//			byte[] thePdf = modulo.getDataContent();
//
//			it.csi.modolxp.modolxppdfgensrv.dto.Applicazione appPdfStatico = new it.csi.modolxp.modolxppdfgensrv.dto.Applicazione();
//			appPdfStatico.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
//
//			log.debug("FRAAAAAAAAAAAAAAAAAAAA 7 STEP ");

			// DA FARE
//			byte[] thePdfStaticoNew = null;
//			PdfStaticInputRequest pdfStaticInputRequest = new PdfStaticInputRequest();
//			pdfStaticInputRequest.setPdfInput(thePdf);
//			thePdfStaticoNew = getServiziMgr().getModolPdf().toStaticPdf(appPdfStatico, null, pdfStaticInputRequest);
//
//			log.debug("PRIMA DELLA CREAZIONE DEL PDF STATICO");
//
//			PdfAInputRequest pdfAInputRequest = new PdfAInputRequest();
//			pdfAInputRequest.setPdfInput(thePdf);
//
//			byte[] thePdfStatico = null;
//			thePdfStatico = getServiziMgr().getModolPdf().toPdfA(appPdfStatico, null, pdfAInputRequest);


			log.debug("Stampo l'array del pdf statico: "+thePdfStatico);

			log.debug("DOPO DELLA CREAZIONE DEL PDF STATICO");

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 12 STEP  ");

			result.setFile(thePdfStatico);
			result.setNomeDocumento("Allegato_bozza.pdf");



//			DettaglioDocumentoMultiplo docMultiplo = getLibrettoCompletoNow(idImpianto, isConsolidato);
//
//
//			if (docMultiplo != null)
//			{
//				result.setFile(docMultiplo.getDocumentoPdf().getFile());
//				result.setNomeDocumento(docMultiplo.getDocumentoPdf().getNomeDocumento());
//			}

		}
		catch(Exception e){
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		log.debug("[SigitMgr::getAllegatoPdfNow] END");
		return result;
	}
	*/

	public String getAllegatoXmlModel(DettaglioAllegato dettaglio, boolean isDefinitivo) throws ServiceException {

		log.debug("[SigitMgr::getAllegatoXmlModel] BEGIN");
		String datiXmlSt = null;
		try{

			//SigitTAllegatoDto allegatoDto = null;
			//SigitTAllTxtDto fileAllegatoDto = null;
			//SigitTImpiantoDto impiantoDto = null;
			//String uid = null;
			//String codiceRea = null;
			MODIIDocument mod1 = null;
			MODIIIDocument mod2 = null;
			MODIVDocument mod3 = null;
			MODVDocument mod4 = null;
			try {

//				SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
//				pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));
//				//recupero l'impianto associato all'allegato
//				impiantoDto = getDbMgr().getSigitTImpiantoDao().findByPrimaryKey(pkImpianto );

//				SigitTAllegatoPk pk = new SigitTAllegatoPk();
//				pk.setIdAllegato(ConvertUtil.convertToBigDecimal(dettaglio.getIdAllegato()));
//				//devo caricare l'oggetto Allegato dal DB perche' devo ottenere l'xml dell'allegato
//				allegatoDto = getDbMgr().getSigitTAllegatoDao().findByPrimaryKey(pk);

				log.debug("FRAAAAAAAAAAAAAAAAAAAA 1 STEP ");

				//Parte comune a tutti i tipi di allegati, serve per istanziare un nuovo document da andare a popolare con i dati
				//aggiornati dal documento ottenuto utilizzando i dati dal db
//				Applicazione app = new Applicazione();
//				app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);

				//vado a discernere quale allegato scegliere dall'fkTipoDocumento
				//String tipoDocumento = GenericUtil.getModelloModolAllegato(dettaglio.getIdTipoAllegato());

				//log.debug("FRAAAAAAAAAAAAAAAAAAAA 1.2 STEP  allegatoDto.getFkTipoDocumento(): "+allegatoDto.getFkTipoDocumento());
				log.debug("FRAAAAAAAAAAAAAAAAAAAA 1.2 STEP  dettaglio.getIdTipoAllegato(): "+dettaglio.getIdTipoAllegato());

				byte[] moduloAggiornatoByte = null;
				//recupero l'oggetto che mi viene formattato dalla libreria di modol
				if(Constants.ALLEGATO_TIPO_1.equalsIgnoreCase(dettaglio.getIdTipoAllegato())){
					//mod1 = MapDto.mapToMODIIDocument(allegato);
					mod1 = getDbMgr().getModuloAllegatoTipo1NowFattorComune(dettaglio);
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 2 STEP ");
					//ho il documento con i valori che sono presenti sull'xml, che in parte devo aggiornare
					//con quelli che si trovano sul db, devo richiamre un metodo che mi aggiorni i valori da sostituire
					MODIIDocument moduloAggiornato = getDbMgr().getModuloAllegatoTipo1(mod1, dettaglio, isDefinitivo);
					//ribaltare i dati della prima pagina (i flag), alle altre pagine
					MapDto.mappaturaDatiAllegatoTipo1(moduloAggiornato);
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 3 STEP ");
					//il moduloAggiornato deve essere ristrasformato in formato byteArray, ne creo uno nuovo passandogli il moduloAggiornato
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 4 STEP ");
					moduloAggiornatoByte = XmlBeanUtils.extractByteArray(moduloAggiornato);
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 5 STEP ");
					//trovo il codice REA
				}else if(Constants.ALLEGATO_TIPO_2.equalsIgnoreCase(dettaglio.getIdTipoAllegato())){
					mod2 = getDbMgr().getModuloAllegatoTipo2NowFattorComune(dettaglio);
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 2 STEP ");
					//ho il documento con i valori che sono presenti sull'xml, che in parte devo aggiornare
					//con quelli che si trovano sul db, devo richiamre un metodo che mi aggiorni i valori da sostituire
					MODIIIDocument moduloAggiornato = getDbMgr().getModuloAllegatoTipo2(mod2, dettaglio, isDefinitivo);
					//ribaltare i dati della prima pagina (i flag), alle altre pagine
					MapDto.mappaturaDatiAllegatoTipo2(moduloAggiornato);
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 3 STEP ");
					//il moduloAggiornato deve essere ristrasformato in formato byteArray, ne creo uno nuovo passandogli il moduloAggiornato
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 4 STEP ");
					moduloAggiornatoByte = XmlBeanUtils.extractByteArray(moduloAggiornato);
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 5 STEP ");
				}else if(Constants.ALLEGATO_TIPO_3.equalsIgnoreCase(dettaglio.getIdTipoAllegato())){
					mod3 = getDbMgr().getModuloAllegatoTipo3Now(dettaglio);
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 2 STEP ");
					//ho il documento con i valori che sono presenti sull'xml, che in parte devo aggiornare
					//con quelli che si trovano sul db, devo richiamre un metodo che mi aggiorni i valori da sostituire
					MODIVDocument moduloAggiornato = getDbMgr().getModuloAllegatoTipo3(mod3, dettaglio, isDefinitivo);
					//ribaltare i dati della prima pagina (i flag), alle altre pagine
					MapDto.mappaturaDatiAllegatoTipo3(moduloAggiornato);
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 3 STEP ");
					//il moduloAggiornato deve essere ristrasformato in formato byteArray, ne creo uno nuovo passandogli il moduloAggiornato
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 4 STEP ");
					moduloAggiornatoByte = XmlBeanUtils.extractByteArray(moduloAggiornato);
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 5 STEP ");
				}else if(Constants.ALLEGATO_TIPO_4.equalsIgnoreCase(dettaglio.getIdTipoAllegato())){
					mod4 = getDbMgr().getModuloAllegatoTipo4Now(dettaglio);
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 2 STEP ");
					//ho il documento con i valori che sono presenti sull'xml, che in parte devo aggiornare
					//con quelli che si trovano sul db, devo richiamre un metodo che mi aggiorni i valori da sostituire
					MODVDocument moduloAggiornato = getDbMgr().getModuloAllegatoTipo4(mod4, dettaglio, isDefinitivo);
					//ribaltare i dati della prima pagina (i flag), alle altre pagine
					MapDto.mappaturaDatiAllegatoTipo4(moduloAggiornato);
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 3 STEP ");
					//il moduloAggiornato deve essere ristrasformato in formato byteArray, ne creo uno nuovo passandogli il moduloAggiornato
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 4 STEP ");
					moduloAggiornatoByte = XmlBeanUtils.extractByteArray(moduloAggiornato);
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 5 STEP ");
				}

				log.debug("FRAAAAAAAAAAAAAAAAAAAA 6 STEP ");

				// Riroeno l'XML in formato stringa
				datiXmlSt = XmlBeanUtils.readByteArray(moduloAggiornatoByte);

				/*
				// Salvo l'xml sul DB
				String datiXmlSt = XmlBeanUtils.readByteArray(xmlModel.getXmlContent());

				//quello che cambia e' xmlModel in base ai tipi di allegati che mi arrivano
				Modulo modulo = getServiziMgr().cercaModulo(app, tipoDocumento);

				if (log.isDebugEnabled())
					log.debug("FRAAAAAAAAAAAAAAAAAAAA 6.1 STEP  modulo: "+modulo);

				RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
				modulo = getServiziMgr().getModol().mergeModulo(app, null, modulo, xmlModel);

				//a questo punto recupero l'xml dal modulo aggiornato
				byte[] thePdf = modulo.getDataContent();
				*/
				log.debug("FRAAAAAAAAAAAAAAAAAAAA 7 STEP ");


				log.debug("FRAAAAAAAAAAAAAAAAAAAA 12 STEP  ");

			}
//			catch (ServiceException e) {
//				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
//			}
			catch (IOException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
//			catch (ModolsrvException e) {
//				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
//			}
			catch (ManagerException e) {
				throw e;
			}


			/*

			DettaglioDocumentoMultiplo docMultiplo = getLibrettoCompletoNow(idImpianto, isConsolidato);


			if (docMultiplo != null)
			{
				result.setFile(docMultiplo.getDocumentoPdf().getFile());
				result.setNomeDocumento(docMultiplo.getDocumentoPdf().getNomeDocumento());
			}
			*/
		}
		catch(Exception e){
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		log.debug("[SigitMgr::getAllegatoXmlModel] END");
		return datiXmlSt;
	}

	/*
	public void inviaAllegato(DettaglioAllegato dettaglio, String cfUtenteLoggato, boolean isIspezioni, Integer idPgCat)throws ManagerException {
		log.debug("[SigitMgr::inviaAllegato] START");
		SigitTAllegatoDto allegatoDto = null;
		SigitTAllTxtDto fileAllegatoDto = null;
		SigitTImpiantoDto impiantoDto = null;
		String uid = null;
		String codiceRea = null;
		MODIIDocument mod1 = null;
		MODIIIDocument mod2 = null;
		MODIVDocument mod3 = null;
		MODVDocument mod4 = null;
		try {

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));
			//recupero l'impianto associato all'allegato
			impiantoDto = getDbMgr().getSigitTImpiantoDao().findByPrimaryKey(pkImpianto );

			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(ConvertUtil.convertToBigDecimal(dettaglio.getIdAllegato()));
			//devo caricare l'oggetto Allegato dal DB perche' devo ottenere l'xml dell'allegato
			allegatoDto = getDbMgr().getSigitTAllegatoDao().findByPrimaryKey(pk);

			fileAllegatoDto = getDbMgr().getAllTxtAllegato(pk.getIdAllegato());

			//recupero l'allegato xml
			byte[] allegato = XmlBeanUtils.readString(fileAllegatoDto.getXmlAllegato());

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 1 STEP ");

			if(allegato!=null)
				log.debug("FRAAAAAAAAAAAAAAAAAAAA xml lunghezza:  "+allegato.length);

			//Parte comune a tutti i tipi di allegati, serve per istanziare un nuovo document da andare a popolare con i dati
			//aggiornati dal documento ottenuto utilizzando i dati dal db
			Applicazione app = new Applicazione();
			XmlModel xmlModel = new XmlModel();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);

			//vado a discernere quale allegato scegliere dall'fkTipoDocumento
			String tipoDocumento = GenericUtil.getModelloModolAllegato(allegatoDto.getFkTipoDocumento().toString());
			Modulo modulo = getServiziMgr().cercaModulo(app, tipoDocumento);
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 1.2 STEP  allegatoDto.getFkTipoDocumento(): "+allegatoDto.getFkTipoDocumento());

			if (log.isDebugEnabled())
				log.debug("FRAAAAAAAAAAAAAAAAAAAA 1.3 STEP  modulo: "+modulo);

			if (isIspezioni)
			{
				codiceRea = this.getCodiceRea(Constants.ID_PG_RUOLO_ISPETTORE);
			}
			else
			{
				codiceRea = this.getCodiceRea(dettaglio.getIdPersonaGiuridica());

				// Devo settare se e' un CAT ad inviare l'allegato
				if (GenericUtil.isNotNullOrEmpty(idPgCat))
				{
					allegatoDto.setFkPgCat(ConvertUtil.convertToBigDecimal(idPgCat));
				}
			}

			//recupero l'oggetto che mi viene formattato dalla libreria di modol
			if(Constants.ALLEGATO_TIPO_1.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				mod1 = MapDto.mapToMODIIDocument(allegato);
				log.debug("FRAAAAAAAAAAAAAAAAAAAA 2 STEP ");
				//ho il documento con i valori che sono presenti sull'xml, che in parte devo aggiornare
				//con quelli che si trovano sul db, devo richiamre un metodo che mi aggiorni i valori da sostituire
				MODIIDocument moduloAggiornato = getDbMgr().getModuloAllegatoTipo1(mod1, dettaglio, true);
				//ribaltare i dati della prima pagina (i flag), alle altre pagine
				MapDto.mappaturaDatiAllegatoTipo1(moduloAggiornato);
				log.debug("FRAAAAAAAAAAAAAAAAAAAA 3 STEP ");
				//il moduloAggiornato deve essere ristrasformato in formato byteArray, ne creo uno nuovo passandogli il moduloAggiornato
				log.debug("FRAAAAAAAAAAAAAAAAAAAA 4 STEP ");
				xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(moduloAggiornato));
				log.debug("FRAAAAAAAAAAAAAAAAAAAA 5 STEP ");
				//trovo il codice REA
			}else if(Constants.ALLEGATO_TIPO_2.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				mod2 = MapDto.mapToMODIIIDocument(allegato);
				MODIIIDocument moduloAggiornato2 = getDbMgr().getModuloAllegatoTipo2(mod2, dettaglio, true);
				MapDto.mappaturaDatiAllegatoTipo2(mod2);
				xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(moduloAggiornato2));
			}else if(Constants.ALLEGATO_TIPO_3.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				mod3 = MapDto.mapToMODIVDocument(allegato);
				MODIVDocument moduloAggiornato3 = getDbMgr().getModuloAllegatoTipo3(mod3, dettaglio, true);
				MapDto.mappaturaDatiAllegatoTipo3(mod3);
				xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(moduloAggiornato3));
			}else if(Constants.ALLEGATO_TIPO_4.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				mod4 = MapDto.mapToMODVDocument(allegato);
				MODVDocument moduloAggiornato4 = getDbMgr().getModuloAllegatoTipo4(mod4, dettaglio, true);
				MapDto.mappaturaDatiAllegatoTipo4(moduloAggiornato4);
				xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(moduloAggiornato4));
			}

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 6 STEP ");

			//quello che cambia e' xmlModel in base ai tipi di allegati che mi arrivano
			RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
			modulo = getServiziMgr().getModol().mergeModulo(app, null, modulo, xmlModel);

			//a questo punto recupero l'xml dal modulo aggiornato
			byte[] thePdf = modulo.getDataContent();

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 7 STEP ");

			//mi preparo i dati da inviare ad index
			String nomeAllegato = getNomeAllegato(allegatoDto.getFkTipoDocumento(),
					new BigDecimal(dettaglio.getCodiceImpianto()), allegatoDto.getDataControllo(), allegatoDto.getIdAllegato());
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 8 STEP NOME ALLEGATO : "+nomeAllegato);
			Metadati metadati = MapDto.mapMetadatiAllegati(impiantoDto, allegatoDto, codiceRea);
			uid = getServiziMgr().indexUploadFileNew(nomeAllegato, thePdf, metadati, Constants.INDEX_FOLDER_REE, true);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 9 STEP UID: "+uid);

			//setto i valori per fare l'update sul db per sigit_t_allegato
			allegatoDto.setDataInvio(DateUtil.getSqlCurrentDate());
			allegatoDto.setNomeAllegato(nomeAllegato);
			allegatoDto.setFkStatoRapp(new BigDecimal(Constants.ID_STATO_RAPPORTO_INVIATO));
			if(uid!=null)
				allegatoDto.setUidIndex(uid);

			//aggiorno pure il pdf appena spedito ad index

			//verificare che non lo si debba fare
			//allegatoDto.setXmlAllegato(thePdf);



			log.debug("FRAAAAAAAAAAAAAAAAAAAA 10 STEP  ");

			//chiamo l'aggiornamento per la tabella sigit_t_allegato
			getDbMgr().getSigitTAllegatoDao().update(allegatoDto);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 11 STEP  ");

			//ADESSO eseguo il metodo per il salvataggio dei dati sul db che ho appena spediti ad index
			if(Constants.ALLEGATO_TIPO_1.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				salvaInfoDaXmlAllegato1(mod1, allegatoDto, impiantoDto, cfUtenteLoggato, codiceRea);
			}else if(Constants.ALLEGATO_TIPO_2.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				salvaInfoDaXmlAllegato2(mod2, allegatoDto, impiantoDto, cfUtenteLoggato, codiceRea);
			}else if(Constants.ALLEGATO_TIPO_3.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				salvaInfoDaXmlAllegato3(mod3, allegatoDto, impiantoDto, cfUtenteLoggato, codiceRea);
			}else if(Constants.ALLEGATO_TIPO_4.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				salvaInfoDaXmlAllegato4(mod4, allegatoDto, impiantoDto, cfUtenteLoggato, codiceRea);
			}


			log.debug("FRAAAAAAAAAAAAAAAAAAAA 12 STEP  ");

		} catch (SigitTAllegatoDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (ServiceException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} catch (IOException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (ModolsrvException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} catch (SigitTImpiantoDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (ManagerException e) {
			throw e;
		}

		log.debug("[SigitMgr::inviaAllegato] END");
	}
	*/

	@Transactional
	public ResultInvioMail inviaAllegatoNow(DettaglioAllegato dettaglio, String cfUtenteLoggato, Integer idPgCat)throws ManagerException {
		log.debug("[SigitMgr::inviaAllegatoNow] START");

		ResultInvioMail resultInvioMail = null;

		SigitTAllegatoDto allegatoDto = null;
		//SigitTImpiantoDto impiantoDto = null;
		SigitVTotImpiantoDto impiantoDto = null;
		String uid = null;
		String codiceRea = null;
		try {
			/*
			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));
			//recupero l'impianto associato all'allegato
			impiantoDto = getDbMgr().getSigitTImpiantoDao().findByPrimaryKey(pkImpianto );
			*/

			List<SigitVTotImpiantoDto> listResp = getDbMgr()
					.cercaResponsabiliAttiviAllaDataByCodImpianto(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());

			if (listResp != null && !listResp.isEmpty()) {

				impiantoDto = listResp.get(0);
			}

			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(ConvertUtil.convertToBigDecimal(dettaglio.getIdAllegato()));
			//devo caricare l'oggetto Allegato dal DB perche' devo ottenere l'xml dell'allegato
			allegatoDto = getDbMgr().getSigitTAllegatoDao().findByPrimaryKey(pk);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 1 STEP ");

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 1.2 STEP  allegatoDto.getFkTipoDocumento(): "+allegatoDto.getFkTipoDocumento());

				codiceRea = this.getCodiceRea(dettaglio.getIdPersonaGiuridica());

				// Devo settare se e' un CAT ad inviare l'allegato
				if (GenericUtil.isNotNullOrEmpty(idPgCat))
				{
					allegatoDto.setFkPgCat(ConvertUtil.convertToBigDecimal(idPgCat));
				}


			log.debug("FRAAAAAAAAAAAAAAAAAAAA 6 STEP ");

			DettaglioDocumento allegato = getReeAllegatoDettaglioDocumento(dettaglio, false);

			byte[] thePdfStatico = allegato.getFile();

			//mi preparo i dati da inviare ad index
			String nomeAllegato = getNomeAllegato(allegatoDto.getFkTipoDocumento(),
					new BigDecimal(dettaglio.getCodiceImpianto()), allegatoDto.getDataControllo(), allegatoDto.getIdAllegato());
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 8 STEP NOME ALLEGATO : "+nomeAllegato);
			Metadati metadati = MapDto.mapMetadatiAllegati(impiantoDto, allegatoDto, codiceRea);
			uid = getServiziMgr().indexUploadFileNew(nomeAllegato, thePdfStatico, metadati, Constants.INDEX_FOLDER_REE, true);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 9 STEP UID: "+uid);


			// Cerco il 3Responsabile
			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglio.getCodiceImpianto(),
					dettaglio.getDataControllo());

			PersonaGiuridica pg3Resp = null;
			if (list3RespAttiviImpianto != null && list3RespAttiviImpianto.size() > 0) {
				SigitVRicerca3ResponsabileDto vTot3Responsabile = list3RespAttiviImpianto.get(0);
				pg3Resp = getDbMgr().cercaPersonaGiuridicaById(vTot3Responsabile.getFkPg3Resp().intValue());
			}

			// Verifico che sia abilitato l'accertamento automatico
			if (getDbMgr().cercaConfigValueFlg(Constants.CIT_ACCERTAMENTO_AUTOMATICO_IMP_NON_SICURO))
			{
				if (!ConvertUtil.convertToBooleanAllways(allegatoDto.getFFlgPuoFunzionare()))
				{
					CodeDescription coppiaIdAccertamentoMailPA = creaAutomatismiInvioRee(dettaglio.getCodiceImpianto(), allegatoDto);
					String emailPA = coppiaIdAccertamentoMailPA.getDescription();

					inviaMailAvvioAutomaticoAccertamentoRee(pg3Resp, emailPA, impiantoDto, dettaglio, coppiaIdAccertamentoMailPA.getCode());
				}
			}
			//setto i valori per fare l'update sul db per sigit_t_allegato
			allegatoDto.setDataInvio(DateUtil.getSqlCurrentDate());
			allegatoDto.setNomeAllegato(ReplaceSpecialCharUtils.sanitize(nomeAllegato));
			allegatoDto.setFkStatoRapp(new BigDecimal(Constants.ID_STATO_RAPPORTO_INVIATO));
			if(uid!=null)
				allegatoDto.setUidIndex(uid);

			//aggiorno pure il pdf appena spedito ad index

			//verificare che non lo si debba fare
			//allegatoDto.setXmlAllegato(thePdf);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 10 STEP  ");

			//chiamo l'aggiornamento per la tabella sigit_t_allegato
			getDbMgr().getSigitTAllegatoDao().update(allegatoDto);


			// PARTE PER L'INVIO DELLA MAIL
			//SigitVRicercaAllegatiDto vAllegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(dettaglio.getIdAllegato());

			// Cerco la mail del responsabile alla data controllo
			String emailResponsabile = cercaEMailResponsabileAttivoAllaDataByCodImpianto(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());

			SigitTPersonaGiuridicaDto manutentore = getDbMgr().cercaTPersonaGiuridicaById(dettaglio.getIdPersonaGiuridica());

			ArrayList<Allegato> elencoAllegati = new ArrayList<Allegato>();
			Allegato allegatoREE = new Allegato();
			allegatoREE.setNomeFile(ReplaceSpecialCharUtils.sanitize(nomeAllegato));
			allegatoREE.setFile(thePdfStatico);
			allegatoREE.setContentType("application/pdf");
			elencoAllegati.add(allegatoREE);

			byte[] ricevuaAllegato = getRicevutaBuilder().generaRicevutaAllegato(dettaglio.getIdAllegato());
			Allegato allegatoRicevuta = new Allegato();
			allegatoRicevuta.setNomeFile("ricevutaAllegato.pdf");
			allegatoRicevuta.setFile(ricevuaAllegato);
			allegatoRicevuta.setContentType("application/pdf");
			elencoAllegati.add(allegatoRicevuta);

			resultInvioMail = getServiziMgr().sendMailInviata(allegatoDto, impiantoDto, manutentore, emailResponsabile, pg3Resp, elencoAllegati);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 11 STEP  ");

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 12 STEP  ");

		} catch (SigitTAllegatoDaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (ServiceException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
//		catch (ModolsrvException e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
//		}
//		catch (SigitTImpiantoDaoException e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
//		}
		catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}

		log.debug("[SigitMgr::inviaAllegatoNow] END");

		return resultInvioMail;
	}

	@Transactional
	public void inviaRappProvaNow(DettaglioAllegato dettaglio, String cfUtenteLoggato, Integer idPgCat)throws ManagerException {
		log.debug("[SigitMgr::inviaRappProvaNow] START");
		SigitTAllegatoDto allegatoDto = null;
		SigitTImpiantoDto impiantoDto = null;
		String uid = null;
		String codiceRea = null;
		try {

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));
			//recupero l'impianto associato all'allegato
			impiantoDto = getDbMgr().getSigitTImpiantoDao().findByPrimaryKey(pkImpianto );

			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(ConvertUtil.convertToBigDecimal(dettaglio.getIdAllegato()));
			//devo caricare l'oggetto Allegato dal DB perche' devo ottenere l'xml dell'allegato
			allegatoDto = getDbMgr().getSigitTAllegatoDao().findByPrimaryKey(pk);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 1 STEP ");

			//Parte comune a tutti i tipi di allegati, serve per istanziare un nuovo document da andare a popolare con i dati
			//aggiornati dal documento ottenuto utilizzando i dati dal db
//			Applicazione app = new Applicazione();
//			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);



			//vado a discernere quale allegato scegliere dall'fkTipoDocumento
			//String tipoDocumento = GenericUtil.getModelloModolAllegato(allegatoDto.getFkTipoDocumento().toString());

			DettaglioDocumento dettaglioDoc = null;

			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(ConvertUtil.convertToString(allegatoDto.getFkTipoDocumento())))
			{
				dettaglioDoc = getIspezioneBuilder().generaIspezioneGt(dettaglio, false, false);
			} else if (Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equals(ConvertUtil.convertToString(allegatoDto.getFkTipoDocumento())))
			{
				dettaglioDoc = getIspezioneBuilder().generaIspezioneGf(dettaglio, false, false);
			}


			log.debug("FRAAAAAAAAAAAAAAAAAAAA 1.2 STEP  allegatoDto.getFkTipoDocumento(): "+allegatoDto.getFkTipoDocumento());

			codiceRea = Constants.COD_REA_ISPETTORE;//this.getCodiceRea(Constants.ID_PG_RUOLO_ISPETTORE);

//			if (isIspezioni)
//			{
//			}
//			else
//			{
//				codiceRea = this.getCodiceRea(dettaglio.getIdPersonaGiuridica());
//
//				// Devo settare se e' un CAT ad inviare l'allegato
//				if (GenericUtil.isNotNullOrEmpty(idPgCat))
//				{
//					allegatoDto.setFkPgCat(ConvertUtil.convertToBigDecimal(idPgCat));
//				}
//			}

			//XmlModel xmlModel = getAllegatoXmlModel(dettaglio, true);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 6 STEP ");

			// Salvo l'xml sul DB
//			String datiXmlSt = XmlBeanUtils.readByteArray(xmlModel.getXmlContent());
//			getDbMgr().insertAllTxtAllegato(allegatoDto.getIdAllegato(), datiXmlSt);

			//quello che cambia e' xmlModel in base ai tipi di allegati che mi arrivano
//			Modulo modulo = getServiziMgr().cercaModulo(app, tipoDocumento);
//			//log.debug("FRAAAAAAAAAAAAAAAAAAAA 6.1 STEP  modulo: "+modulo);
//
//			RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
//			modulo = getServiziMgr().getModol().mergeModulo(app, null, modulo, xmlModel);

			byte[] thePdfStatico = dettaglioDoc.getFile();

			//mi preparo i dati da inviare ad index
			String nomeAllegato = getNomeAllegato(allegatoDto.getFkTipoDocumento(),
					new BigDecimal(dettaglio.getCodiceImpianto()), allegatoDto.getDataControllo(), allegatoDto.getIdAllegato());
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 8 STEP NOME ALLEGATO : "+nomeAllegato);
			Metadati metadati = MapDto.mapMetadatiAllegati(impiantoDto, allegatoDto, codiceRea);
			uid = getServiziMgr().indexUploadFileNew(nomeAllegato, thePdfStatico, metadati, Constants.INDEX_FOLDER_ISPEZIONI, true);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 9 STEP UID: "+uid);

			//setto i valori per fare l'update sul db per sigit_t_allegato
			allegatoDto.setDataInvio(DateUtil.getSqlCurrentDate());
			allegatoDto.setNomeAllegato(ReplaceSpecialCharUtils.sanitize(nomeAllegato));
			allegatoDto.setFkStatoRapp(new BigDecimal(Constants.ID_STATO_RAPPORTO_INVIATO));
			if(uid!=null)
				allegatoDto.setUidIndex(ReplaceSpecialCharUtils.sanitize(uid));

			//aggiorno pure il pdf appena spedito ad index

			//verificare che non lo si debba fare
			//allegatoDto.setXmlAllegato(thePdf);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 10 STEP  ");

			//chiamo l'aggiornamento per la tabella sigit_t_allegato
			getDbMgr().getSigitTAllegatoDao().update(allegatoDto);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 11 STEP  ");

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 12 STEP  ");

		} catch (SigitTAllegatoDaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (ServiceException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} catch (SigitTImpiantoDaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}

		log.debug("[SigitMgr::inviaRappProvaNow] END");
	}

	@Transactional
	public void inviaRappProvaNowOLD(DettaglioAllegato dettaglio, String cfUtenteLoggato, boolean isIspezioni, Integer idPgCat)throws ManagerException {
		log.debug("[SigitMgr::inviaAllegatoNow] START");
		SigitTAllegatoDto allegatoDto = null;
		SigitTImpiantoDto impiantoDto = null;
		String uid = null;
		String codiceRea = null;
		try {

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));
			//recupero l'impianto associato all'allegato
			impiantoDto = getDbMgr().getSigitTImpiantoDao().findByPrimaryKey(pkImpianto );

			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(ConvertUtil.convertToBigDecimal(dettaglio.getIdAllegato()));
			//devo caricare l'oggetto Allegato dal DB perche' devo ottenere l'xml dell'allegato
			allegatoDto = getDbMgr().getSigitTAllegatoDao().findByPrimaryKey(pk);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 1 STEP ");

			//Parte comune a tutti i tipi di allegati, serve per istanziare un nuovo document da andare a popolare con i dati
			//aggiornati dal documento ottenuto utilizzando i dati dal db

			//dcosta dismissione Modol Applicazione app = new Applicazione();
			//dcosta dismissione Modol app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);

			//vado a discernere quale allegato scegliere dall'fkTipoDocumento
			//dcosta dismissione Modol String tipoDocumento = GenericUtil.getModelloModolAllegato(allegatoDto.getFkTipoDocumento().toString());
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 1.2 STEP  allegatoDto.getFkTipoDocumento(): "+allegatoDto.getFkTipoDocumento());

			if (isIspezioni)
			{
				codiceRea = this.getCodiceRea(Constants.ID_PG_RUOLO_ISPETTORE);
			}
			else
			{
				codiceRea = this.getCodiceRea(dettaglio.getIdPersonaGiuridica());

				// Devo settare se e' un CAT ad inviare l'allegato
				if (GenericUtil.isNotNullOrEmpty(idPgCat))
				{
					allegatoDto.setFkPgCat(ConvertUtil.convertToBigDecimal(idPgCat));
				}
			}

			//dcosta dismissione Modol XmlModel xmlModel = getAllegatoXmlModel(dettaglio, true);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 6 STEP ");

			// Salvo l'xml sul DB
			//dcosta dismissione Modol String datiXmlSt = XmlBeanUtils.readByteArray(xmlModel.getXmlContent());
			//dcosta dismissione Modol getDbMgr().insertAllTxtAllegato(allegatoDto.getIdAllegato(), datiXmlSt);

			//quello che cambia e' xmlModel in base ai tipi di allegati che mi arrivano
			//dcosta dismissione Modol Modulo modulo = getServiziMgr().cercaModulo(app, tipoDocumento);
			//log.debug("FRAAAAAAAAAAAAAAAAAAAA 6.1 STEP  modulo: "+modulo);

			//dcosta dismissione Modol RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
			//dcosta dismissione Modol modulo = getServiziMgr().getModol().mergeModulo(app, null, modulo, xmlModel);


			//dcosta dismissione Modol byte[] thePdfStatico = getServiziMgr().creaModuloStaticoModol(modulo);

			//mi preparo i dati da inviare ad index
			String nomeAllegato = getNomeAllegato(allegatoDto.getFkTipoDocumento(),
					new BigDecimal(dettaglio.getCodiceImpianto()), allegatoDto.getDataControllo(), allegatoDto.getIdAllegato());
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 8 STEP NOME ALLEGATO : "+nomeAllegato);
			Metadati metadati = MapDto.mapMetadatiAllegati(impiantoDto, allegatoDto, codiceRea);


			//dcosta dismissione Modol: invocazione di test per recuperare un file da usare come input al nuovo caricamento su index
			byte[] thePdfStatico = getServiziMgr().getFileIndexByUid("46172f90-ee32-11e8-83dd-8bb41c399c67", "PROVA_INVIO_RAP_PROVA.pdf");

			uid = getServiziMgr().indexUploadFileNew(nomeAllegato, thePdfStatico, metadati, isIspezioni? Constants.INDEX_FOLDER_ISPEZIONI : Constants.INDEX_FOLDER_REE, true);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 9 STEP UID: "+uid);

			//setto i valori per fare l'update sul db per sigit_t_allegato
			allegatoDto.setDataInvio(DateUtil.getSqlCurrentDate());
			allegatoDto.setNomeAllegato(nomeAllegato);
			allegatoDto.setFkStatoRapp(new BigDecimal(Constants.ID_STATO_RAPPORTO_INVIATO));
			if(uid!=null)
				allegatoDto.setUidIndex(uid);

			//aggiorno pure il pdf appena spedito ad index

			//verificare che non lo si debba fare
			//allegatoDto.setXmlAllegato(thePdf);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 10 STEP  ");

			//chiamo l'aggiornamento per la tabella sigit_t_allegato
			getDbMgr().getSigitTAllegatoDao().update(allegatoDto);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 11 STEP  ");

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 12 STEP  ");

		} catch (SigitTAllegatoDaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (ServiceException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
			//dcosta dismissione Modol } catch (IOException e) {
			//dcosta dismissione Modol 	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			//dcosta dismissione Modol 	throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			//dcosta dismissione Modol } catch (ModolsrvException e) {
			//dcosta dismissione Modol 	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			//dcosta dismissione Modol throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} catch (SigitTImpiantoDaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}

		log.debug("[SigitMgr::inviaAllegatoNow] END");
	}

	@Transactional
	public void inviaAllegatoLibretto(String codiceImpianto, Integer idPersonaGiuridica, int idMotivoConsolidamento, UtenteLoggato utenteLoggato, boolean isIspezioni)throws ManagerException {
		log.debug("[SigitMgr::inviaAllegatoLibretto] START");
		try {

			String cfUtenteLoggato = utenteLoggato.getCodiceFiscale();

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 11 STEP  ");

			String codiceRea = null;

			if (isIspezioni)
			{
				codiceRea = this.getCodiceRea(Constants.ID_PG_RUOLO_ISPETTORE);
			}
			else
			{
				if (idPersonaGiuridica != null)
				{
					SigitTPersonaGiuridicaDto manutentore = getDbMgr().cercaTPersonaGiuridicaById(idPersonaGiuridica);
					codiceRea = MapDto.getCodiceRea(manutentore.getSiglaRea(), ConvertUtil.convertToInteger(manutentore.getNumeroRea()));
				}
			}

			SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(codiceImpianto);
			//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
			recordLibretto.setCfRedattore(ReplaceSpecialCharUtils.sanitize(cfUtenteLoggato));
			recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
			recordLibretto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteLoggato));
			recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
			//inserisco
			getDbMgr().inserisciLibretto(recordLibretto);

			SigitTImpiantoDto sigitTImpiantoDto = getDbMgr().cercaImpiantoDtoById(codiceImpianto);

			log.debug("[SigitMgr::inviaAllegatoLibretto] END --> INSERT SU sigit_t_libretto");
			//adesso eseguo i punti 4, 5, 6 dell'algoritmo A002_7 riferito al libretto
			this.creaPdfEConsolidaLibretto(utenteLoggato, sigitTImpiantoDto, codiceRea, recordLibretto, idMotivoConsolidamento);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 12 STEP  ");

		} catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}

		log.debug("[SigitMgr::inviaAllegatoLibretto] END");
	}

	private String getNomeAllegato(BigDecimal idTipoAllegato, BigDecimal codiceImpianto, Date dataControllo, BigDecimal pkAllegato){
		StringBuilder nome = new StringBuilder();

		if (Constants.ALLEGATO_TIPO_1.equalsIgnoreCase(""+idTipoAllegato)){
			nome.append(Constants.DESC_ALLEGATO_TIPO_1);
		} else if (Constants.ALLEGATO_TIPO_2.equalsIgnoreCase(""+idTipoAllegato)){
			nome.append(Constants.DESC_ALLEGATO_TIPO_2);
		} else if (Constants.ALLEGATO_TIPO_3.equalsIgnoreCase(""+idTipoAllegato)){
			nome.append(Constants.DESC_ALLEGATO_TIPO_3);
		} else if (Constants.ALLEGATO_TIPO_4.equalsIgnoreCase(""+idTipoAllegato)){
			nome.append(Constants.DESC_ALLEGATO_TIPO_4);
		} else if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(ConvertUtil.convertToString(idTipoAllegato)) || Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equals(ConvertUtil.convertToString(idTipoAllegato))) {
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

	private String getNomeRappProvaFirmato(BigDecimal idTipoAllegato, BigDecimal codiceImpianto, Date dataControllo, BigDecimal pkAllegato, String estensioneFile) {
		StringBuilder nome = new StringBuilder();
		nome.append(Constants.DESC_ALLEGATO_RAPPROVA_FIRMATO);
		nome.append("_");
		nome.append(codiceImpianto);
		nome.append("_");
		nome.append(ConvertUtil.convertToString(dataControllo, ConvertUtil.FORMAT_DATE_UNDERSCORE));
		nome.append("_");
		nome.append(pkAllegato);

		if (estensioneFile.equalsIgnoreCase(Constants.ESTENSIONE_PDF)) {
			nome.append(".pdf");
		} else {
			nome.append(".pdf.p7m");
		}

		return nome.toString();
	}

	/*
	@Transactional
	public void inserisciDocumentoAgg(ImportDistribFilter dataFile) throws ManagerException {
		 log.debug("[SigitMgr::inserisciDocumentoAgg] BEGIN");
	        try {


	        	int idImport = getDbMgr().getIdSeqImportDistrib();
	        	dataFile.setIdImport(idImport);
	        	dataFile.setNomeFileMod(idImport+Constants.INTERVAL_SEP_CHIAVI+dataFile.getNomeFile());

	        	// Inserisco il file fittizio
	        	log.debug("inserisco il file fittizio - prima");

	        	final String uidIndex = getServiziMgr().indexUploadDistributoreFile(dataFile.getNomeFileMod(), new byte[0]);

	            log.debug("inserisco il file fittizio - dopo - uid: "+uidIndex);

	            dataFile.setUidIndex(uidIndex);

	            // Inserisco il file vero
	            log.debug("inserisco il file vero - prima");

//	            this.getServiziMgr().mtomUploadFile(dataFile);
	            this.getServiziMgr().mtomUploadFileGeneric(dataFile);

	            log.debug("inserisco il file vero - dopo");

	            log.debug("salvo l'operazione sul DB - prima");

	            if (GenericUtil.isNotNullOrEmpty(dataFile.getIdImportSostituzione()))
	            {
	            	// E' una sostituzione
	            	getDbMgr().salvaImportSostituzioneDistributore(dataFile);

	            }
	            else
	            {
	            	// E' un inserimento
	            	getDbMgr().salvaImportDistributore(dataFile);
	            }

	            log.debug("salvo l'operazione sul DB - dopo");

	        }
	        catch (DbManagerException e) {
				log.error("Errore",e);
				throw e;
			}
	        catch (ServiceException e) {

//	        	this.getServiziMgr().indexDeleteFile(uid);
//
//	            this.getDbMgr().cancellaAllegatoByIstanzaNomeAllegato(idIstanza, allegato);

	            log.debug("[SigitMgr::inserisciDocumentoAgg] ERROR: " + e.getMessage());

	            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
	        } finally {
	        	log.debug("[SigitMgr::inserisciDocumentoAgg] END");
	        }
	    }
	*/
	@Transactional
	public void inserisciDocumento(ImportDocumentoFilter docFilter, String descAltroDoc, String cfUtenteLoggato)throws ManagerException {
		log.debug("[SigitMgr::inserisciDocumento] START");

		try {
			SigitVTotImpiantoCercaUbicazioneImpiantoDto ubicazione = getDbMgr().cercaUbicazioneImpianto(ConvertUtil.convertToInteger(docFilter.getCodImpianto()));

			SigitTDocAggiuntivaDto docDto = MapDto.mapToSigitTDocAggiuntivaDto(docFilter, descAltroDoc, cfUtenteLoggato);

			getDbMgr().inserisciTDocAggiuntiva(docDto);

			log.debug("Chiave del doc: "+docDto.getIdDocAggiuntiva());

			String nomeFileMod = "Doc"+docFilter.getIdTipoDocumento()+"_"+docDto.getIdDocAggiuntiva()+"_"+docFilter.getNomeFile();

			// Inserisco il file fittizio
        	log.debug("inserisco il file fittizio - prima");

        	Metadati metadati = new Metadati();
        	metadati.setCodiceImpianto(ReplaceSpecialCharUtils.sanitize(docFilter.getCodImpianto()));
        	metadati.setCodIstatProvincia(StringUtils.substring(ReplaceSpecialCharUtils.sanitize(ubicazione.getIstatComune()), 0, 3));
        	metadati.setCodIstatComune(ReplaceSpecialCharUtils.sanitize(ubicazione.getIstatComune()));

        	final String uidIndex = getServiziMgr().indexUploadFileNew(nomeFileMod, new byte[0], metadati, Constants.INDEX_FOLDER_DOC, false);

            log.debug("inserisco il file fittizio - dopo - uid: "+uidIndex);

            docDto.setNomeDoc(ReplaceSpecialCharUtils.sanitize(nomeFileMod));
            docDto.setUidIndex(ReplaceSpecialCharUtils.sanitize(uidIndex));

            docFilter.setUidIndex(ReplaceSpecialCharUtils.sanitize(uidIndex));
            docFilter.setNomeFileMod(ReplaceSpecialCharUtils.sanitize(nomeFileMod));

            // Inserisco il file vero
            log.debug("inserisco il file vero - prima");

//            this.getServiziMgr().mtomUploadFile(docFilter);
            this.getServiziMgr().mtomUploadFileGeneric(docFilter);

            log.debug("inserisco il file vero - dopo");

            log.debug("salvo l'operazione sul DB - prima");

            getDbMgr().aggiornaTDocAggiuntiva(docDto);

            log.debug("salvo l'operazione sul DB - dopo");

		} catch (ServiceException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));

		}

		log.debug("[SigitMgr::inviaAllegato] END");
	}

	@Transactional
	public void inserisciDocumentoAllegato(ImportDocumentoFilter docFilter, boolean isREE, String cfUtenteLoggato)throws ManagerException {
		log.debug("[SigitMgr::inserisciDocumentoAllegato] START");

		try {

			SigitVTotImpiantoCercaUbicazioneImpiantoDto ubicazione = getDbMgr().cercaUbicazioneImpianto(ConvertUtil.convertToInteger(docFilter.getCodImpianto()));

			SigitTDocAllegatoDto docDto = MapDto.mapToSigitTDocAllegatoDto(docFilter, cfUtenteLoggato);

			getDbMgr().inserisciTDocAllegato(docDto);

			log.debug("Chiave del doc: "+docDto.getIdDocAllegato());

			String prefixNome = isREE?"IMG_REE":"MANUT";
			String nomeFileMod = prefixNome+"_"+docDto.getFkAllegato()+"_"+docDto.getIdDocAllegato()+"_"+docFilter.getNomeFile();

			// Inserisco il file fittizio
        	log.debug("inserisco il file fittizio - prima");

        	Metadati metadati = new Metadati();
        	metadati.setCodiceImpianto(docFilter.getCodImpianto());
        	metadati.setCodIstatProvincia(StringUtils.substring(ubicazione.getIstatComune(), 0, 3));
        	metadati.setCodIstatComune(ubicazione.getIstatComune());

        	final String uidIndex = getServiziMgr().indexUploadFileNew(nomeFileMod, new byte[0], metadati, Constants.INDEX_FOLDER_DOC, false);

            log.debug("inserisco il file fittizio - dopo - uid: "+uidIndex);

            docDto.setNomeDoc(nomeFileMod);
            docDto.setUidIndex(uidIndex);

            docFilter.setUidIndex(uidIndex);
            docFilter.setNomeFileMod(nomeFileMod);

            // Inserisco il file vero
            log.debug("inserisco il file vero - prima");

//            this.getServiziMgr().mtomUploadFile(docFilter);
            this.getServiziMgr().mtomUploadFileGeneric(docFilter);

            log.debug("inserisco il file vero - dopo");

            log.debug("salvo l'operazione sul DB - prima");

            getDbMgr().aggiornaTDocAllegato(docDto);

            log.debug("salvo l'operazione sul DB - dopo");

		} catch (ServiceException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));

		}

		log.debug("[SigitMgr::inserisciDocumentoAllegato] END");
	}

	public void salvaInfoDaXmlAllegato1(MODIIDocument modAllegatoTipo1,
			SigitTAllegatoDto allegato, SigitTImpiantoDto impianto, UtenteLoggato utenteLoggato, String codiceRea)throws ManagerException {
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] BEGIN");

		String cfUtenteLoggato = utenteLoggato.getCodiceFiscale();

		//aggiorniamo di nuovo la tabella SIGIT_T_ALLEGATO con gli altri elementi aggiuntivi sia dell'xml che le informazioni dell'utente
		it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta richiesta = modAllegatoTipo1.getMODII().getRichiesta();

		//sezione B.documentazione tecnica a corredo
		List<RowAllegatoII> allegatoIIList = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
		boolean flagControllo = false;
		try{
			for(RowAllegatoII allegatoII : allegatoIIList){

				//RowAllegatoII allegatoII = allegatoIIList.get(0);
				DocumentazioneTecnica documentazioneTecnica = allegatoII.getDocumentazioneTecnica();
				it.csi.sigit.sigitwebn.xml.allegato2.data.TrattamentoAcquaDocument.TrattamentoAcqua trattamentoAcqua = allegatoII.getTrattamentoAcqua();
				it.csi.sigit.sigitwebn.xml.allegato2.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = allegatoII.getDatiIdentificativi();


					if(documentazioneTecnica.getABFlagDichiarazConfNO()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.NO_0));
					}
					if(documentazioneTecnica.getABFlagDichiarazConfSI()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.SI_1));
					}
					if(documentazioneTecnica.getABFlagLibrettoCompNO()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.NO_0));
					}
					if(documentazioneTecnica.getABFlagLibrettoCompSI()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.SI_1));
					}
					if(documentazioneTecnica.getABFlagLibrettoImpNO()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.NO_0));
					}
					if(documentazioneTecnica.getABFlagLibrettoImpSI()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.SI_1));
					}
					if(documentazioneTecnica.getABFlagManutGenNO()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.NO_0));
					}
					if(documentazioneTecnica.getABFlagManutGenSI()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.SI_1));
					}

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> A. Dati identificativi ");
					try{
						if(GenericUtil.isNotNullOrEmpty(datiIdentificativi.getAAPotenzaTermicaNomTotMax())){
							allegato.setAPotenzaTermicaNominaleMax(datiIdentificativi.getAAPotenzaTermicaNomTotMax());
						}
					}catch (Exception e) {allegato.setAPotenzaTermicaNominaleMax(null);}


					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> B. documentazione tecnica a corredo");

					//sezione F.check list
					CheckList checkList = allegatoII.getCheckList();
					log.debug("[F ]check list --> checkList.getAFOsservazioni(): "+checkList.getAFOsservazioni());
					if(GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni())){
						allegato.setFOsservazioni(checkList.getAFOsservazioni());
					}
					log.debug("[F ]check list --> checkList.getAFRaccomandazioni(): "+checkList.getAFRaccomandazioni());
					if(GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni())){
						allegato.setFRaccomandazioni(checkList.getAFRaccomandazioni());
					}
					log.debug("[F ]check list --> checkList.getAFPrescrizioni(): "+checkList.getAFPrescrizioni());
					if(GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni())){
						allegato.setFPrescrizioni(checkList.getAFPrescrizioni());
					}

					DatiTecnico datiTecnico = allegatoII.getDatiTecnico();
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpNO(): "+datiTecnico.getAFFlagFunzImpNO());
					if(datiTecnico.getAFFlagFunzImpNO()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpSI(): "+datiTecnico.getAFFlagFunzImpSI());
					if(datiTecnico.getAFFlagFunzImpSI()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.SI_1));
					}

					try{allegato.setFInterventoEntro(DateUtil.getSqlDate(datiTecnico.getAFDataIntervento()));}catch (Exception e) {allegato.setFInterventoEntro(null);}

					log.debug("[F ]check list --> datiTecnico.getAFOrarioArrivo(): "+datiTecnico.getAFOrarioArrivo());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioArrivo())){
						allegato.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
					}
					log.debug("[F ]check list --> datiTecnico.getAFOrarioPartenza(): "+datiTecnico.getAFOrarioPartenza());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioPartenza())){
						allegato.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
					}
					log.debug("[F ]check listcheck list --> datiTecnico.getAFNomeTecnico(): "+datiTecnico.getAFNomeTecnico());
					log.debug("[F ]check list --> datiTecnico.getAFCognomeTecnico(): "+datiTecnico.getAFCognomeTecnico());
					allegato.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));
					log.debug("[F ]check list --> datiTecnico.getAFFirmaTecnico(): "+datiTecnico.getAFFirmaTecnico());

					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
						allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
						allegato.setFFirmaTecnico(datiTecnico.getAFFirmaTecnico());
					}else{
						allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
						allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
						allegato.setFFirmaResponsabile(datiTecnico.getAFFirmaResp());
					}else{
						allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
					}

					//Non so ancora cosa settare a livello di flg_controllo_bozza????
					allegato.setFlgControlloBozza(new BigDecimal(Constants.SI_1));
					allegato.setDataUltMod(DateUtil.getSqlDataCorrente());
					allegato.setUtenteUltMod(cfUtenteLoggato);

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> F.check list per  sigit_t_allegato");
					//aggiorno la tabella SIGIT_T_ALLEGATO
					if(!flagControllo){
						//faccio l'update altrimenti al secondo giro non mi riporta piu' i dati del primo e me li va a cancellare
						try {
							getDbMgr().getSigitTAllegatoDao().update(allegato);
						} catch (SigitTAllegatoDaoException e) {
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
							throw new ManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
						}
					}

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> update su  sigit_t_allegato");

					SigitTRappTipo1Dto rapportoTipo1 = new SigitTRappTipo1Dto();
					log.debug("[F ]check list --> checkList.getAFFlagValvole(): "+checkList.getAFFlagValvole());
					//attenzione parte legata a sigit_t_rapp_tipo1
					if(checkList.getAFFlagValvole()){
						rapportoTipo1.setFFlgAdozioneValvoleTerm(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setFFlgAdozioneValvoleTerm(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F ]check list --> checkList.getAFFlagIsolamento(): "+checkList.getAFFlagIsolamento());
					if(checkList.getAFFlagIsolamento()){
						rapportoTipo1.setFFlgIsolamenteRete(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setFFlgIsolamenteRete(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F ]check list --> checkList.getAFFlagSistTrattACS(): "+checkList.getAFFlagSistTrattACS());
					if(checkList.getAFFlagSistTrattACS()){
						rapportoTipo1.setFFlgAdozSistTrattamH2o(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setFFlgAdozSistTrattamH2o(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F ]check list --> checkList.getAFFlagSistRegolaz(): "+checkList.getAFFlagSistRegolaz());
					if(checkList.getAFFlagSistRegolaz()){
						rapportoTipo1.setFFlgSostituzSistRegolaz(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setFFlgSostituzSistRegolaz(new BigDecimal(Constants.NO_0));
					}
					//Sezione C. trattamento dell'acqua
					if(trattamentoAcqua.getACFlagTrattH2ONR()){
						rapportoTipo1.setCFlgTrattClimaNonRich(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setCFlgTrattClimaNonRich(new BigDecimal(Constants.NO_0));
					}
					if(trattamentoAcqua.getACFlagTrattAcsNR()){
						rapportoTipo1.setCFlgTrattAcsNonRichiesto(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setCFlgTrattAcsNonRichiesto(new BigDecimal(Constants.NO_0));
					}

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END -->  sezione F.check list legata a sigit_t_rapp_tipo1");

					//sezione D.controllo dell'impianto
					ControlloImpianto controlloImpianto = allegatoII.getControlloImpianto();
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagInternoSI(): "+controlloImpianto.getADFlagInternoSI());
					if(controlloImpianto.getADFlagInternoSI()){
						rapportoTipo1.setDFlgLocaleIntIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagInternoNO()){
						rapportoTipo1.setDFlgLocaleIntIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagInternoNC()){
						rapportoTipo1.setDFlgLocaleIntIdoneo(new BigDecimal(Constants.NC_2));
					}

					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagEsternoSI(): "+controlloImpianto.getADFlagEsternoSI());
					if(controlloImpianto.getADFlagEsternoSI()){
						rapportoTipo1.setDFlgGenExtIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagEsternoNO()){
						rapportoTipo1.setDFlgGenExtIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagEsternoNC()){
						rapportoTipo1.setDFlgGenExtIdoneo(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagApertureSI(): "+controlloImpianto.getADFlagApertureSI());
					if(controlloImpianto.getADFlagApertureSI()){
						rapportoTipo1.setDFlgApertureLibere(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagApertureNO()){
						rapportoTipo1.setDFlgApertureLibere(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagApertureNC()){
						rapportoTipo1.setDFlgApertureLibere(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagDimensioniSI(): "+controlloImpianto.getADFlagDimensioniSI());
					if(controlloImpianto.getADFlagDimensioniSI()){
						rapportoTipo1.setDFlgApertureAdeg(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagDimensioniNO()){
						rapportoTipo1.setDFlgApertureAdeg(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagDimensioniNC()){
						rapportoTipo1.setDFlgApertureAdeg(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagCanaleFumoSI(): "+controlloImpianto.getADFlagCanaleFumoSI());
					if(controlloImpianto.getADFlagCanaleFumoSI()){
						rapportoTipo1.setDFlgScaricoIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagCanaleFumoNO()){
						rapportoTipo1.setDFlgScaricoIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagCanaleFumoNC()){
						rapportoTipo1.setDFlgScaricoIdoneo(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagSistRegolazSI(): "+controlloImpianto.getADFlagSistRegolazSI());
					if(controlloImpianto.getADFlagSistRegolazSI()){
						rapportoTipo1.setDFlgTempAmbFunz(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagSistRegolazNO()){
						rapportoTipo1.setDFlgTempAmbFunz(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagSistRegolazNC()){
						rapportoTipo1.setDFlgTempAmbFunz(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagPerditeSI(): "+controlloImpianto.getADFlagPerditeSI());
					if(controlloImpianto.getADFlagPerditeSI()){
						rapportoTipo1.setDFlgAssenzaPerdComb(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagPerditeNO()){
						rapportoTipo1.setDFlgAssenzaPerdComb(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagPerditeNC()){
						rapportoTipo1.setDFlgAssenzaPerdComb(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagTenutaSI(): "+controlloImpianto.getADFlagTenutaSI());
					if(controlloImpianto.getADFlagTenutaSI()){
						rapportoTipo1.setDFlgIdoTenImpInt(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagTenutaNO()){
						rapportoTipo1.setDFlgIdoTenImpInt(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagTenutaNC()){
						rapportoTipo1.setDFlgIdoTenImpInt(new BigDecimal(Constants.NC_2));
					}

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END -->  sezione D.controllo dell'impianto legata a sigit_t_rapp_tipo1");

					//INSERISCO nella tabella SIGIT_RAPP_TIPO1
					rapportoTipo1.setIdAllegato(allegato.getIdAllegato());

					SigitTRappTipo1Pk pk = new SigitTRappTipo1Pk();
					pk.setIdAllegato(allegato.getIdAllegato());
					//devo controllare se ho un record presente sulla tabella o no
					SigitTRappTipo1Dto dettaglioRappTipo1 = getDbMgr().getSigitTRappTipo1Dao().findByPrimaryKey(pk);
					if(dettaglioRappTipo1!=null){
						log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] TROVATO RECORD SU sigit_t_rapp_tipo1");
						//non posso fare l'update perche' nelle pagine successive non mi riporta tutti i dati
						//getDbMgr().getSigitTRappTipo1Dao().update(rapportoTipo1);
					}
					else{
						getDbMgr().getSigitTRappTipo1Dao().insert(rapportoTipo1);
						log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> INSERT SU sigit_t_rapp_tipo1");
					}


					//sezione E.controllo e verifica energetica  del gruppo termico
					ControlloVerificaEnergetica controlloVerificaEnergetica = allegatoII.getControlloVerificaEnergetica();
					SigitTDettTipo1Dto sigitTDettTipo1Dto = new SigitTDettTipo1Dto();
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagClimatizInv(): "+controlloVerificaEnergetica.getAEFlagClimatizInv());
					if(controlloVerificaEnergetica.getAEFlagClimatizInv()){
						sigitTDettTipo1Dto.setEFlgClimaInverno(new BigDecimal(Constants.SI_1));
					}else{
						sigitTDettTipo1Dto.setEFlgClimaInverno(new BigDecimal(Constants.NO_0));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagProduzACS(): "+controlloVerificaEnergetica.getAEFlagProduzACS());
					if(controlloVerificaEnergetica.getAEFlagProduzACS()){
						sigitTDettTipo1Dto.setEFlgProduzAcs(new BigDecimal(Constants.SI_1));
					}else{
						sigitTDettTipo1Dto.setEFlgProduzAcs(new BigDecimal(Constants.NO_0));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagDispComandoSI(): "+controlloVerificaEnergetica.getAEFlagDispComandoSI());
					if(controlloVerificaEnergetica.getAEFlagDispComandoSI()){
						sigitTDettTipo1Dto.setEFlgDisposComando(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagDispComandoNO()){
						sigitTDettTipo1Dto.setEFlgDisposComando(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagDispComandoNC()){
						sigitTDettTipo1Dto.setEFlgDisposComando(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagDispSicuSI(): "+controlloVerificaEnergetica.getAEFlagDispSicuSI());
					if(controlloVerificaEnergetica.getAEFlagDispSicuSI()){
						sigitTDettTipo1Dto.setEFlgDisposSicurezza(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagDispSicuNO()){
						sigitTDettTipo1Dto.setEFlgDisposSicurezza(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagDispSicuNC()){
						sigitTDettTipo1Dto.setEFlgDisposSicurezza(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagValvSicuSI(): "+controlloVerificaEnergetica.getAEFlagValvSicuSI());
					if(controlloVerificaEnergetica.getAEFlagValvSicuSI()){
						sigitTDettTipo1Dto.setEFlgValvolaSicurezza(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagValvSicuNO()){
						sigitTDettTipo1Dto.setEFlgValvolaSicurezza(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagValvSicuNC()){
						sigitTDettTipo1Dto.setEFlgValvolaSicurezza(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagScambiatoreSI(): "+controlloVerificaEnergetica.getAEFlagScambiatoreSI());
					if(controlloVerificaEnergetica.getAEFlagScambiatoreSI()){
						sigitTDettTipo1Dto.setEFlgScambiatoreFumi(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagScambiatoreNO()){
						sigitTDettTipo1Dto.setEFlgScambiatoreFumi(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagScambiatoreNC()){
						sigitTDettTipo1Dto.setEFlgScambiatoreFumi(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagRiflussoSI(): "+controlloVerificaEnergetica.getAEFlagRiflussoSI());
					if(controlloVerificaEnergetica.getAEFlagRiflussoSI()){
						sigitTDettTipo1Dto.setEFlgRiflusso(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagRiflussoNO()){
						sigitTDettTipo1Dto.setEFlgRiflusso(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagRiflussoNC()){
						sigitTDettTipo1Dto.setEFlgRiflusso(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagRisultatiSI(): "+controlloVerificaEnergetica.getAEFlagRisultatiSI());
					if(controlloVerificaEnergetica.getAEFlagRisultatiSI()){
						sigitTDettTipo1Dto.setEFlgUni103891(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagRisultatiNO()){
						sigitTDettTipo1Dto.setEFlgUni103891(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagRisultatiNC()){
						sigitTDettTipo1Dto.setEFlgUni103891(new BigDecimal(Constants.NC_2));
					}

					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEPotenzaFocolare() ********************************************** ");

					try{sigitTDettTipo1Dto.setEPotTermFocolKw(ConvertUtil.convertToBigDecimal(controlloVerificaEnergetica.getAEPotenzaFocolare()));}catch (Exception e) {sigitTDettTipo1Dto.setEPotTermFocolKw(null);}

					if(controlloVerificaEnergetica.getAEFlagEvacFumiFORZ()){
						sigitTDettTipo1Dto.setEFlgEvacuFumi(Constants.FLAG_EVACUAZIONE_FUMI_FORZATA);
					}
					if(controlloVerificaEnergetica.getAEFlagEvacFumiNATU()){
						sigitTDettTipo1Dto.setEFlgEvacuFumi(Constants.FLAG_EVACUAZIONE_FUMI_NATURALE);
					}

					try{sigitTDettTipo1Dto.setL111AltroRiferimento(controlloVerificaEnergetica.getAEAltroRifNormativo());}catch (Exception e) {sigitTDettTipo1Dto.setL111AltroRiferimento(null);}

					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEDepressCanaleFumo(): ++++++++++++++++++++++++++++++++++++++++++++ ");

					try{sigitTDettTipo1Dto.setEDeprCanaleFumoPa(ConvertUtil.convertToBigDecimal(controlloVerificaEnergetica.getAEDepressCanaleFumo()));}catch (Exception e) {sigitTDettTipo1Dto.setEDeprCanaleFumoPa(null);}

					sigitTDettTipo1Dto.setCodiceImpianto(impianto.getCodiceImpianto());
					sigitTDettTipo1Dto.setFkAllegato(allegato.getIdAllegato());
					sigitTDettTipo1Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
					sigitTDettTipo1Dto.setUtenteUltMod(cfUtenteLoggato);
					sigitTDettTipo1Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_GT);

					try{sigitTDettTipo1Dto.setProgressivo(ConvertUtil.convertToBigDecimal(allegatoII.getAENumGT()));}catch (Exception e) {sigitTDettTipo1Dto.setProgressivo(null);}
					try{sigitTDettTipo1Dto.setDataInstall(DateUtil.getSqlDate(allegatoII.getAEDataInstallaz()));}catch (Exception e) {sigitTDettTipo1Dto.setDataInstall(null);}

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> sezione E.controllo e verifica energetica  del gruppo termico sigit_t_DETT_tipo1");
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] BEGIN --> sezione E.controllo e verifica energetica tab fumi del gruppo termico sigit_t_DETT_tipo1");
					TabFumi tabFumi = allegatoII.getTabFumi();
					List<RowFumi> rigaFumi = tabFumi.getRowFumiList();
					if(rigaFumi!=null && rigaFumi.size()>0){
						log.debug("FRAAAAAAAAAAAAAAA ---> rowfumi lunghezza lista da inserire : "+rigaFumi.size());
						int count = 0;
						 for(RowFumi dto : rigaFumi){
							 log.debug("FRAAAAAAAAAAAAAAA ---> rowfumi count : "+count);

							 try {sigitTDettTipo1Dto.setETempFumiC(dto.getAETempFumi());}catch (Exception e) {sigitTDettTipo1Dto.setETempFumiC(null);}
							 try {sigitTDettTipo1Dto.setETempAriaC(dto.getAETempAria());}catch (Exception e) {sigitTDettTipo1Dto.setETempAriaC(null);}
							 try {sigitTDettTipo1Dto.setEO2Perc(dto.getAEO2());}catch (Exception e) {sigitTDettTipo1Dto.setEO2Perc(null);}
							 try {sigitTDettTipo1Dto.setECo2Perc(dto.getAECO2());}catch (Exception e) {sigitTDettTipo1Dto.setECo2Perc(null);}

							 try{sigitTDettTipo1Dto.setEBacharachMin(dto.getAEBacharach1());}catch (Exception e) {sigitTDettTipo1Dto.setEBacharachMin(null);}
							 try{sigitTDettTipo1Dto.setEBacharachMed(dto.getAEBacharach2());}catch (Exception e) {sigitTDettTipo1Dto.setEBacharachMed(null);}
							 try{ sigitTDettTipo1Dto.setEBacharachMax(dto.getAEBacharach3());}catch (Exception e) {sigitTDettTipo1Dto.setEBacharachMax(null);}

							 try {sigitTDettTipo1Dto.setECoCorrettoPpm(dto.getAECOcorretto());}catch (Exception e) {sigitTDettTipo1Dto.setECoCorrettoPpm(null);}

							 sigitTDettTipo1Dto.setL111FlgCoMin1000(null);

							 if (GenericUtil.isNotNullOrEmpty(sigitTDettTipo1Dto.getECoCorrettoPpm())) {
								 if (sigitTDettTipo1Dto.getECoCorrettoPpm().doubleValue() <= new BigDecimal(1000).doubleValue()) {
									 sigitTDettTipo1Dto.setL111FlgCoMin1000(new BigDecimal(Constants.SI_1));
								 }
								 else {
									 sigitTDettTipo1Dto.setL111FlgCoMin1000(new BigDecimal(Constants.NO_0));
								 }
							 }

							 try {sigitTDettTipo1Dto.setERendCombPerc(dto.getAERendimCombu());}catch (Exception e) {sigitTDettTipo1Dto.setERendCombPerc(null);}
							 try {sigitTDettTipo1Dto.setERendMinLeggePerc(dto.getAERendimentoLegge());}catch (Exception e) {sigitTDettTipo1Dto.setERendMinLeggePerc(null);}
							 try {sigitTDettTipo1Dto.setENoxPpm(dto.getAENox());}catch (Exception e) {sigitTDettTipo1Dto.setENoxPpm(null);}
							 try{ sigitTDettTipo1Dto.setENModuloTermico(ConvertUtil.convertToInteger(dto.getAEModuloTermico()));}catch (Exception e) {sigitTDettTipo1Dto.setENModuloTermico(null);}

							 /*
							 try{ sigitTDettTipo1Dto.setL111PortataCombustibileUm(dto.getAEPortataCombu());}catch (Exception e) {sigitTDettTipo1Dto.setL111PortataCombustibileUm(null);}
							 try{ sigitTDettTipo1Dto.setL111PortataCombustibile(ConvertUtil.convertToBigDecimal(dto.getAEValorePortata()));}catch (Exception e) {sigitTDettTipo1Dto.setL111PortataCombustibile(null);}
							 try{ sigitTDettTipo1Dto.setL111CoNoAriaPpm(ConvertUtil.convertToBigDecimal(dto.getAECOfumiSecchi()));}catch (Exception e) {sigitTDettTipo1Dto.setL111CoNoAriaPpm(null);}
							 try{
								 if(Constants.RENDIMENTO_MINIMO_SI.equalsIgnoreCase(dto.getAERispettoIndBacharach())){
									 sigitTDettTipo1Dto.setL111FlgRispettaBacharach(new BigDecimal(Constants.SI_1));
								 }
								 if(Constants.RENDIMENTO_MINIMO_NO.equalsIgnoreCase(dto.getAERispettoIndBacharach())){
									 sigitTDettTipo1Dto.setL111FlgRispettaBacharach(new BigDecimal(Constants.NO_0));
								 }
							 }catch (Exception e) {

								 log.error(e);
								 sigitTDettTipo1Dto.setL111FlgRispettaBacharach(null);
							 }

							 try{
								 if(Constants.RENDIMENTO_MINIMO_SI.equalsIgnoreCase(dto.getAEMinimo())){
									 sigitTDettTipo1Dto.setL111FlgRendMagRendMin(new BigDecimal(Constants.SI_1));
								 }

								 if(Constants.RENDIMENTO_MINIMO_NO.equalsIgnoreCase(dto.getAEMinimo())){
									 sigitTDettTipo1Dto.setL111FlgRendMagRendMin(new BigDecimal(Constants.NO_0));
								 }
							 }catch (Exception e) {
								 log.error(e);
								 sigitTDettTipo1Dto.setL111FlgRendMagRendMin(null);

							 }
								*/
							 //INSERISCO
							 getDbMgr().getSigitTDettTipo1Dao().insert(sigitTDettTipo1Dto);
							 count++;

						 }
					}
					//traccio il primo giro del for con tutti i dati del pdf
					flagControllo = true;
				}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> INSERT SU sigit_t_DETT_tipo1");
				//adesso devo aggiornare la parte di libretto che e' dedicata esclusivamente all'allegato
				//mi trovo l'ultimo libretto aggiornato e creo una copia di questo sulla tabella
				//dopodiche' mi vado a richiamare il metodo che scrive il libretto e lo consolida

				SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
				//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
				recordLibretto.setCfRedattore(cfUtenteLoggato);
				recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
				recordLibretto.setUtenteUltMod(cfUtenteLoggato);
				recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
				//inserisco
				getDbMgr().inserisciLibretto(recordLibretto);

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> INSERT SU sigit_t_libretto");
				//adesso eseguo i punti 4, 5, 6 dell'algoritmo A002_7 riferito al libretto
				this.creaPdfEConsolidaLibretto(utenteLoggato, impianto, codiceRea, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO);

		}catch(Exception e){
			log.error("[SigitMgr::salvaInfoDaXmlAllegato1] END ", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));

		}
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END");
	}

	/*
	public void inviaAllegatoNow(SigitTAllegatoDto allegato, SigitTImpiantoDto impianto, String cfUtenteLoggato, String codiceRea)throws ManagerException {
		log.debug("[SigitMgr::inviaAllegatoNow] BEGIN");

		try{

				SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
				//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
				recordLibretto.setCfRedattore(cfUtenteLoggato);
				recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
				recordLibretto.setUtenteUltMod(cfUtenteLoggato);
				recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
				//inserisco
				getDbMgr().inserisciLibretto(recordLibretto);

				log.debug("[SigitMgr::inviaAllegatoNow] END --> INSERT SU sigit_t_libretto");
				//adesso eseguo i punti 4, 5, 6 dell'algoritmo A002_7 riferito al libretto
				this.creaPdfEConsolidaLibretto(cfUtenteLoggato, impianto, codiceRea, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO);

		}catch(Exception e){
			log.error("[SigitMgr::inviaAllegatoNow] END ", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));

		}
		log.debug("[SigitMgr::inviaAllegato1] END");
	}
	*/

	public void inviaAllegato1OLD(MODIIDocument modAllegatoTipo1,
			SigitTAllegatoDto allegato, SigitTImpiantoDto impianto, UtenteLoggato utenteLoggato, String codiceRea)throws ManagerException {
		log.debug("[SigitMgr::inviaAllegato1] BEGIN");

		//aggiorniamo di nuovo la tabella SIGIT_T_ALLEGATO con gli altri elementi aggiuntivi sia dell'xml che le informazioni dell'utente
		//it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta richiesta = modAllegatoTipo1.getMODII().getRichiesta();

		//sezione B.documentazione tecnica a corredo
		//List<RowAllegatoII> allegatoIIList = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
		//boolean flagControllo = false;
		try{

			/*
			for(RowAllegatoII allegatoII : allegatoIIList){

				//RowAllegatoII allegatoII = allegatoIIList.get(0);
				DocumentazioneTecnica documentazioneTecnica = allegatoII.getDocumentazioneTecnica();
				it.csi.sigit.sigitwebn.xml.allegato2.data.TrattamentoAcquaDocument.TrattamentoAcqua trattamentoAcqua = allegatoII.getTrattamentoAcqua();
				it.csi.sigit.sigitwebn.xml.allegato2.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = allegatoII.getDatiIdentificativi();


					if(documentazioneTecnica.getABFlagDichiarazConfNO()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.NO_0));
					}
					if(documentazioneTecnica.getABFlagDichiarazConfSI()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.SI_1));
					}
					if(documentazioneTecnica.getABFlagLibrettoCompNO()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.NO_0));
					}
					if(documentazioneTecnica.getABFlagLibrettoCompSI()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.SI_1));
					}
					if(documentazioneTecnica.getABFlagLibrettoImpNO()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.NO_0));
					}
					if(documentazioneTecnica.getABFlagLibrettoImpSI()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.SI_1));
					}
					if(documentazioneTecnica.getABFlagManutGenNO()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.NO_0));
					}
					if(documentazioneTecnica.getABFlagManutGenSI()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.SI_1));
					}

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> A. Dati identificativi ");
					try{
						if(GenericUtil.isNotNullOrEmpty(datiIdentificativi.getAAPotenzaTermicaNomTotMax())){
							allegato.setAPotenzaTermicaNominaleMax(datiIdentificativi.getAAPotenzaTermicaNomTotMax());
						}
					}catch (Exception e) {allegato.setAPotenzaTermicaNominaleMax(null);}


					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> B. documentazione tecnica a corredo");

					//sezione F.check list
					CheckList checkList = allegatoII.getCheckList();
					log.debug("[F ]check list --> checkList.getAFOsservazioni(): "+checkList.getAFOsservazioni());
					if(GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni())){
						allegato.setFOsservazioni(checkList.getAFOsservazioni());
					}
					log.debug("[F ]check list --> checkList.getAFRaccomandazioni(): "+checkList.getAFRaccomandazioni());
					if(GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni())){
						allegato.setFRaccomandazioni(checkList.getAFRaccomandazioni());
					}
					log.debug("[F ]check list --> checkList.getAFPrescrizioni(): "+checkList.getAFPrescrizioni());
					if(GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni())){
						allegato.setFPrescrizioni(checkList.getAFPrescrizioni());
					}

					DatiTecnico datiTecnico = allegatoII.getDatiTecnico();
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpNO(): "+datiTecnico.getAFFlagFunzImpNO());
					if(datiTecnico.getAFFlagFunzImpNO()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpSI(): "+datiTecnico.getAFFlagFunzImpSI());
					if(datiTecnico.getAFFlagFunzImpSI()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.SI_1));
					}

					try{allegato.setFInterventoEntro(DateUtil.getSqlDate(datiTecnico.getAFDataIntervento()));}catch (Exception e) {allegato.setFInterventoEntro(null);}

					log.debug("[F ]check list --> datiTecnico.getAFOrarioArrivo(): "+datiTecnico.getAFOrarioArrivo());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioArrivo())){
						allegato.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
					}
					log.debug("[F ]check list --> datiTecnico.getAFOrarioPartenza(): "+datiTecnico.getAFOrarioPartenza());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioPartenza())){
						allegato.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
					}
					log.debug("[F ]check listcheck list --> datiTecnico.getAFNomeTecnico(): "+datiTecnico.getAFNomeTecnico());
					log.debug("[F ]check list --> datiTecnico.getAFCognomeTecnico(): "+datiTecnico.getAFCognomeTecnico());
					allegato.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));
					log.debug("[F ]check list --> datiTecnico.getAFFirmaTecnico(): "+datiTecnico.getAFFirmaTecnico());

					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
						allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
						allegato.setFFirmaTecnico(datiTecnico.getAFFirmaTecnico());
					}else{
						allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
						allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
						allegato.setFFirmaResponsabile(datiTecnico.getAFFirmaResp());
					}else{
						allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
					}

					//Non so ancora cosa settare a livello di flg_controllo_bozza????
					allegato.setFlgControlloBozza(new BigDecimal(Constants.SI_1));
					allegato.setDataUltMod(DateUtil.getSqlDataCorrente());
					allegato.setUtenteUltMod(cfUtenteLoggato);

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> F.check list per  sigit_t_allegato");
					//aggiorno la tabella SIGIT_T_ALLEGATO
					if(!flagControllo){
						//faccio l'update altrimenti al secondo giro non mi riporta piu' i dati del primo e me li va a cancellare
						try {
							getDbMgr().getSigitTAllegatoDao().update(allegato);
						} catch (SigitTAllegatoDaoException e) {
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
							throw new ManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
						}
					}

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> update su  sigit_t_allegato");

					SigitTRappTipo1Dto rapportoTipo1 = new SigitTRappTipo1Dto();
					log.debug("[F ]check list --> checkList.getAFFlagValvole(): "+checkList.getAFFlagValvole());
					//attenzione parte legata a sigit_t_rapp_tipo1
					if(checkList.getAFFlagValvole()){
						rapportoTipo1.setFFlgAdozioneValvoleTerm(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setFFlgAdozioneValvoleTerm(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F ]check list --> checkList.getAFFlagIsolamento(): "+checkList.getAFFlagIsolamento());
					if(checkList.getAFFlagIsolamento()){
						rapportoTipo1.setFFlgIsolamenteRete(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setFFlgIsolamenteRete(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F ]check list --> checkList.getAFFlagSistTrattACS(): "+checkList.getAFFlagSistTrattACS());
					if(checkList.getAFFlagSistTrattACS()){
						rapportoTipo1.setFFlgAdozSistTrattamH2o(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setFFlgAdozSistTrattamH2o(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F ]check list --> checkList.getAFFlagSistRegolaz(): "+checkList.getAFFlagSistRegolaz());
					if(checkList.getAFFlagSistRegolaz()){
						rapportoTipo1.setFFlgSostituzSistRegolaz(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setFFlgSostituzSistRegolaz(new BigDecimal(Constants.NO_0));
					}
					//Sezione C. trattamento dell'acqua
					if(trattamentoAcqua.getACFlagTrattH2ONR()){
						rapportoTipo1.setCFlgTrattClimaNonRich(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setCFlgTrattClimaNonRich(new BigDecimal(Constants.NO_0));
					}
					if(trattamentoAcqua.getACFlagTrattAcsNR()){
						rapportoTipo1.setCFlgTrattAcsNonRichiesto(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setCFlgTrattAcsNonRichiesto(new BigDecimal(Constants.NO_0));
					}

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END -->  sezione F.check list legata a sigit_t_rapp_tipo1");

					//sezione D.controllo dell'impianto
					ControlloImpianto controlloImpianto = allegatoII.getControlloImpianto();
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagInternoSI(): "+controlloImpianto.getADFlagInternoSI());
					if(controlloImpianto.getADFlagInternoSI()){
						rapportoTipo1.setDFlgLocaleIntIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagInternoNO()){
						rapportoTipo1.setDFlgLocaleIntIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagInternoNC()){
						rapportoTipo1.setDFlgLocaleIntIdoneo(new BigDecimal(Constants.NC_2));
					}

					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagEsternoSI(): "+controlloImpianto.getADFlagEsternoSI());
					if(controlloImpianto.getADFlagEsternoSI()){
						rapportoTipo1.setDFlgGenExtIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagEsternoNO()){
						rapportoTipo1.setDFlgGenExtIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagEsternoNC()){
						rapportoTipo1.setDFlgGenExtIdoneo(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagApertureSI(): "+controlloImpianto.getADFlagApertureSI());
					if(controlloImpianto.getADFlagApertureSI()){
						rapportoTipo1.setDFlgApertureLibere(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagApertureNO()){
						rapportoTipo1.setDFlgApertureLibere(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagApertureNC()){
						rapportoTipo1.setDFlgApertureLibere(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagDimensioniSI(): "+controlloImpianto.getADFlagDimensioniSI());
					if(controlloImpianto.getADFlagDimensioniSI()){
						rapportoTipo1.setDFlgApertureAdeg(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagDimensioniNO()){
						rapportoTipo1.setDFlgApertureAdeg(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagDimensioniNC()){
						rapportoTipo1.setDFlgApertureAdeg(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagCanaleFumoSI(): "+controlloImpianto.getADFlagCanaleFumoSI());
					if(controlloImpianto.getADFlagCanaleFumoSI()){
						rapportoTipo1.setDFlgScaricoIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagCanaleFumoNO()){
						rapportoTipo1.setDFlgScaricoIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagCanaleFumoNC()){
						rapportoTipo1.setDFlgScaricoIdoneo(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagSistRegolazSI(): "+controlloImpianto.getADFlagSistRegolazSI());
					if(controlloImpianto.getADFlagSistRegolazSI()){
						rapportoTipo1.setDFlgTempAmbFunz(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagSistRegolazNO()){
						rapportoTipo1.setDFlgTempAmbFunz(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagSistRegolazNC()){
						rapportoTipo1.setDFlgTempAmbFunz(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagPerditeSI(): "+controlloImpianto.getADFlagPerditeSI());
					if(controlloImpianto.getADFlagPerditeSI()){
						rapportoTipo1.setDFlgAssenzaPerdComb(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagPerditeNO()){
						rapportoTipo1.setDFlgAssenzaPerdComb(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagPerditeNC()){
						rapportoTipo1.setDFlgAssenzaPerdComb(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagTenutaSI(): "+controlloImpianto.getADFlagTenutaSI());
					if(controlloImpianto.getADFlagTenutaSI()){
						rapportoTipo1.setDFlgIdoTenImpInt(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagTenutaNO()){
						rapportoTipo1.setDFlgIdoTenImpInt(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagTenutaNC()){
						rapportoTipo1.setDFlgIdoTenImpInt(new BigDecimal(Constants.NC_2));
					}

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END -->  sezione D.controllo dell'impianto legata a sigit_t_rapp_tipo1");

					//INSERISCO nella tabella SIGIT_RAPP_TIPO1
					rapportoTipo1.setIdAllegato(allegato.getIdAllegato());

					SigitTRappTipo1Pk pk = new SigitTRappTipo1Pk();
					pk.setIdAllegato(allegato.getIdAllegato());
					//devo controllare se ho un record presente sulla tabella o no
					SigitTRappTipo1Dto dettaglioRappTipo1 = getDbMgr().getSigitTRappTipo1Dao().findByPrimaryKey(pk);
					if(dettaglioRappTipo1!=null){
						log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] TROVATO RECORD SU sigit_t_rapp_tipo1");
						//non posso fare l'update perche' nelle pagine successive non mi riporta tutti i dati
						//getDbMgr().getSigitTRappTipo1Dao().update(rapportoTipo1);
					}
					else{
						getDbMgr().getSigitTRappTipo1Dao().insert(rapportoTipo1);
						log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> INSERT SU sigit_t_rapp_tipo1");
					}


					//sezione E.controllo e verifica energetica  del gruppo termico
					ControlloVerificaEnergetica controlloVerificaEnergetica = allegatoII.getControlloVerificaEnergetica();
					SigitTDettTipo1Dto sigitTDettTipo1Dto = new SigitTDettTipo1Dto();
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagClimatizInv(): "+controlloVerificaEnergetica.getAEFlagClimatizInv());
					if(controlloVerificaEnergetica.getAEFlagClimatizInv()){
						sigitTDettTipo1Dto.setEFlgClimaInverno(new BigDecimal(Constants.SI_1));
					}else{
						sigitTDettTipo1Dto.setEFlgClimaInverno(new BigDecimal(Constants.NO_0));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagProduzACS(): "+controlloVerificaEnergetica.getAEFlagProduzACS());
					if(controlloVerificaEnergetica.getAEFlagProduzACS()){
						sigitTDettTipo1Dto.setEFlgProduzAcs(new BigDecimal(Constants.SI_1));
					}else{
						sigitTDettTipo1Dto.setEFlgProduzAcs(new BigDecimal(Constants.NO_0));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagDispComandoSI(): "+controlloVerificaEnergetica.getAEFlagDispComandoSI());
					if(controlloVerificaEnergetica.getAEFlagDispComandoSI()){
						sigitTDettTipo1Dto.setEFlgDisposComando(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagDispComandoNO()){
						sigitTDettTipo1Dto.setEFlgDisposComando(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagDispComandoNC()){
						sigitTDettTipo1Dto.setEFlgDisposComando(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagDispSicuSI(): "+controlloVerificaEnergetica.getAEFlagDispSicuSI());
					if(controlloVerificaEnergetica.getAEFlagDispSicuSI()){
						sigitTDettTipo1Dto.setEFlgDisposSicurezza(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagDispSicuNO()){
						sigitTDettTipo1Dto.setEFlgDisposSicurezza(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagDispSicuNC()){
						sigitTDettTipo1Dto.setEFlgDisposSicurezza(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagValvSicuSI(): "+controlloVerificaEnergetica.getAEFlagValvSicuSI());
					if(controlloVerificaEnergetica.getAEFlagValvSicuSI()){
						sigitTDettTipo1Dto.setEFlgValvolaSicurezza(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagValvSicuNO()){
						sigitTDettTipo1Dto.setEFlgValvolaSicurezza(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagValvSicuNC()){
						sigitTDettTipo1Dto.setEFlgValvolaSicurezza(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagScambiatoreSI(): "+controlloVerificaEnergetica.getAEFlagScambiatoreSI());
					if(controlloVerificaEnergetica.getAEFlagScambiatoreSI()){
						sigitTDettTipo1Dto.setEFlgScambiatoreFumi(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagScambiatoreNO()){
						sigitTDettTipo1Dto.setEFlgScambiatoreFumi(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagScambiatoreNC()){
						sigitTDettTipo1Dto.setEFlgScambiatoreFumi(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagRiflussoSI(): "+controlloVerificaEnergetica.getAEFlagRiflussoSI());
					if(controlloVerificaEnergetica.getAEFlagRiflussoSI()){
						sigitTDettTipo1Dto.setEFlgRiflusso(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagRiflussoNO()){
						sigitTDettTipo1Dto.setEFlgRiflusso(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagRiflussoNC()){
						sigitTDettTipo1Dto.setEFlgRiflusso(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagRisultatiSI(): "+controlloVerificaEnergetica.getAEFlagRisultatiSI());
					if(controlloVerificaEnergetica.getAEFlagRisultatiSI()){
						sigitTDettTipo1Dto.setEFlgUni103891(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagRisultatiNO()){
						sigitTDettTipo1Dto.setEFlgUni103891(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagRisultatiNC()){
						sigitTDettTipo1Dto.setEFlgUni103891(new BigDecimal(Constants.NC_2));
					}

					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEPotenzaFocolare() ********************************************** ");

					try{sigitTDettTipo1Dto.setEPotTermFocolKw(ConvertUtil.convertToBigDecimal(controlloVerificaEnergetica.getAEPotenzaFocolare()));}catch (Exception e) {sigitTDettTipo1Dto.setEPotTermFocolKw(null);}

					if(controlloVerificaEnergetica.getAEFlagEvacFumiFORZ()){
						sigitTDettTipo1Dto.setEFlgEvacuFumi(Constants.FLAG_EVACUAZIONE_FUMI_FORZATA);
					}
					if(controlloVerificaEnergetica.getAEFlagEvacFumiNATU()){
						sigitTDettTipo1Dto.setEFlgEvacuFumi(Constants.FLAG_EVACUAZIONE_FUMI_NATURALE);
					}

					try{sigitTDettTipo1Dto.setL111AltroRiferimento(controlloVerificaEnergetica.getAEAltroRifNormativo());}catch (Exception e) {sigitTDettTipo1Dto.setL111AltroRiferimento(null);}

					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEDepressCanaleFumo(): ++++++++++++++++++++++++++++++++++++++++++++ ");

					try{sigitTDettTipo1Dto.setEDeprCanaleFumoPa(ConvertUtil.convertToBigDecimal(controlloVerificaEnergetica.getAEDepressCanaleFumo()));}catch (Exception e) {sigitTDettTipo1Dto.setEDeprCanaleFumoPa(null);}

					sigitTDettTipo1Dto.setCodiceImpianto(impianto.getCodiceImpianto());
					sigitTDettTipo1Dto.setFkAllegato(allegato.getIdAllegato());
					sigitTDettTipo1Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
					sigitTDettTipo1Dto.setUtenteUltMod(cfUtenteLoggato);
					sigitTDettTipo1Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_GT);

					try{sigitTDettTipo1Dto.setProgressivo(ConvertUtil.convertToBigDecimal(allegatoII.getAENumGT()));}catch (Exception e) {sigitTDettTipo1Dto.setProgressivo(null);}
					try{sigitTDettTipo1Dto.setDataInstall(DateUtil.getSqlDate(allegatoII.getAEDataInstallaz()));}catch (Exception e) {sigitTDettTipo1Dto.setDataInstall(null);}

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> sezione E.controllo e verifica energetica  del gruppo termico sigit_t_DETT_tipo1");
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] BEGIN --> sezione E.controllo e verifica energetica tab fumi del gruppo termico sigit_t_DETT_tipo1");
					TabFumi tabFumi = allegatoII.getTabFumi();
					List<RowFumi> rigaFumi = tabFumi.getRowFumiList();
					if(rigaFumi!=null && rigaFumi.size()>0){
						log.debug("FRAAAAAAAAAAAAAAA ---> rowfumi lunghezza lista da inserire : "+rigaFumi.size());
						int count = 0;
						 for(RowFumi dto : rigaFumi){
							 log.debug("FRAAAAAAAAAAAAAAA ---> rowfumi count : "+count);

							 try {sigitTDettTipo1Dto.setETempFumiC(dto.getAETempFumi());}catch (Exception e) {sigitTDettTipo1Dto.setETempFumiC(null);}
							 try {sigitTDettTipo1Dto.setETempAriaC(dto.getAETempAria());}catch (Exception e) {sigitTDettTipo1Dto.setETempAriaC(null);}
							 try {sigitTDettTipo1Dto.setEO2Perc(dto.getAEO2());}catch (Exception e) {sigitTDettTipo1Dto.setEO2Perc(null);}
							 try {sigitTDettTipo1Dto.setECo2Perc(dto.getAECO2());}catch (Exception e) {sigitTDettTipo1Dto.setECo2Perc(null);}

							 try{sigitTDettTipo1Dto.setEBacharachMin(dto.getAEBacharach1());}catch (Exception e) {sigitTDettTipo1Dto.setEBacharachMin(null);}
							 try{sigitTDettTipo1Dto.setEBacharachMed(dto.getAEBacharach2());}catch (Exception e) {sigitTDettTipo1Dto.setEBacharachMed(null);}
							 try{ sigitTDettTipo1Dto.setEBacharachMax(dto.getAEBacharach3());}catch (Exception e) {sigitTDettTipo1Dto.setEBacharachMax(null);}

							 try {sigitTDettTipo1Dto.setECoCorrettoPpm(dto.getAECOcorretto());}catch (Exception e) {sigitTDettTipo1Dto.setECoCorrettoPpm(null);}

							 if (GenericUtil.isNotNullOrEmpty(sigitTDettTipo1Dto.getECoCorrettoPpm()) && sigitTDettTipo1Dto.getECoCorrettoPpm().doubleValue() <= new BigDecimal(1000).doubleValue())
							 {
								 sigitTDettTipo1Dto.setL111FlgCoMin1000(new BigDecimal(Constants.SI_1));
							 }
							 else
							 {
								 sigitTDettTipo1Dto.setL111FlgCoMin1000(new BigDecimal(Constants.NO_0));
							 }

							 try {sigitTDettTipo1Dto.setERendCombPerc(dto.getAERendimCombu());}catch (Exception e) {sigitTDettTipo1Dto.setERendCombPerc(null);}
							 try {sigitTDettTipo1Dto.setERendMinLeggePerc(dto.getAERendimentoLegge());}catch (Exception e) {sigitTDettTipo1Dto.setERendMinLeggePerc(null);}
							 try {sigitTDettTipo1Dto.setENoxPpm(dto.getAENox());}catch (Exception e) {sigitTDettTipo1Dto.setENoxPpm(null);}
							 try{ sigitTDettTipo1Dto.setENModuloTermico(ConvertUtil.convertToString(dto.getAEModuloTermico()));}catch (Exception e) {sigitTDettTipo1Dto.setENModuloTermico(null);}

							 try{ sigitTDettTipo1Dto.setL111PortataCombustibileUm(dto.getAEPortataCombu());}catch (Exception e) {sigitTDettTipo1Dto.setL111PortataCombustibileUm(null);}
							 try{ sigitTDettTipo1Dto.setL111PortataCombustibile(ConvertUtil.convertToBigDecimal(dto.getAEValorePortata()));}catch (Exception e) {sigitTDettTipo1Dto.setL111PortataCombustibile(null);}
							 try{ sigitTDettTipo1Dto.setL111CoNoAriaPpm(ConvertUtil.convertToBigDecimal(dto.getAECOfumiSecchi()));}catch (Exception e) {sigitTDettTipo1Dto.setL111CoNoAriaPpm(null);}
							 try{
								 if(Constants.RENDIMENTO_MINIMO_SI.equalsIgnoreCase(dto.getAERispettoIndBacharach())){
									 sigitTDettTipo1Dto.setL111FlgRispettaBacharach(new BigDecimal(Constants.SI_1));
								 }
								 if(Constants.RENDIMENTO_MINIMO_NO.equalsIgnoreCase(dto.getAERispettoIndBacharach())){
									 sigitTDettTipo1Dto.setL111FlgRispettaBacharach(new BigDecimal(Constants.NO_0));
								 }
							 }catch (Exception e) {

								 log.error(e);
								 sigitTDettTipo1Dto.setL111FlgRispettaBacharach(null);
							 }

							 try{
								 if(Constants.RENDIMENTO_MINIMO_SI.equalsIgnoreCase(dto.getAEMinimo())){
									 sigitTDettTipo1Dto.setL111FlgRendMagRendMin(new BigDecimal(Constants.SI_1));
								 }

								 if(Constants.RENDIMENTO_MINIMO_NO.equalsIgnoreCase(dto.getAEMinimo())){
									 sigitTDettTipo1Dto.setL111FlgRendMagRendMin(new BigDecimal(Constants.NO_0));
								 }
							 }catch (Exception e) {
								 log.error(e);
								 sigitTDettTipo1Dto.setL111FlgRendMagRendMin(null);

							 }

							 //INSERISCO
							 getDbMgr().getSigitTDettTipo1Dao().insert(sigitTDettTipo1Dto);
							 count++;

						 }
					}
					//traccio il primo giro del for con tutti i dati del pdf
					flagControllo = true;
				}
				*/

				String cfUtenteLoggato = utenteLoggato.getCodiceFiscale();

				log.debug("[SigitMgr::inviaAllegato1] END --> INSERT SU sigit_t_DETT_tipo1");
				//adesso devo aggiornare la parte di libretto che e' dedicata esclusivamente all'allegato
				//mi trovo l'ultimo libretto aggiornato e creo una copia di questo sulla tabella
				//dopodiche' mi vado a richiamare il metodo che scrive il libretto e lo consolida

				SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
				//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
				recordLibretto.setCfRedattore(cfUtenteLoggato);
				recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
				recordLibretto.setUtenteUltMod(cfUtenteLoggato);
				recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
				//inserisco
				getDbMgr().inserisciLibretto(recordLibretto);

				log.debug("[SigitMgr::inviaAllegato1] END --> INSERT SU sigit_t_libretto");
				//adesso eseguo i punti 4, 5, 6 dell'algoritmo A002_7 riferito al libretto
				this.creaPdfEConsolidaLibretto(utenteLoggato, impianto, codiceRea, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO);

		}catch(Exception e){
			log.error("[SigitMgr::inviaAllegato1] END ", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));

		}
		log.debug("[SigitMgr::inviaAllegato1] END");
	}

	public void salvaInfoDaXmlAllegato2(MODIIIDocument modAllegatoTipo2,
			SigitTAllegatoDto allegato, SigitTImpiantoDto impianto, UtenteLoggato utenteLoggato, String codiceRea)throws ManagerException {
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] BEGIN");

		String cfUtenteLoggato = utenteLoggato.getCodiceFiscale();

		//aggiorniamo di nuovo la tabella SIGIT_T_ALLEGATO con gli altri elementi aggiuntivi sia dell'xml che le informazioni dell'utente
		it.csi.sigit.sigitwebn.xml.allegato3.data.RichiestaDocument.Richiesta richiesta = modAllegatoTipo2.getMODIII().getRichiesta();

		//sezione B.documentazione tecnica a corredo
		List<RowAllegatoIII> allegatoIIIList = richiesta.getDatiAllegato().getAllegatoIII().getRowAllegatoIIIList();
		boolean flagControllo = false;
		try{
			log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] lubghezza rowAllegatiIII --> "+allegatoIIIList.size());
			for(RowAllegatoIII allegatoIII: allegatoIIIList){
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] entro nel for RowAllegatoIII");
				//RowAllegatoIII allegatoIII = allegatoIIIList.get(0);
				it.csi.sigit.sigitwebn.xml.allegato3.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = allegatoIII.getDocumentazioneTecnica();
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 1");
				it.csi.sigit.sigitwebn.xml.allegato3.data.TrattamentoAcquaDocument.TrattamentoAcqua trattamentoAcqua =  allegatoIII.getTrattamentoAcqua();
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 2");
				it.csi.sigit.sigitwebn.xml.allegato3.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = allegatoIII.getDatiIdentificativi();

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 3");
				try{
					if(documentazioneTecnica.getABFlagDichiarazConfNO()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 4");
				try{
					if(documentazioneTecnica.getABFlagDichiarazConfSI()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 5");
				try{
					if(documentazioneTecnica.getABFlagLibrettoCompNO()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 6");
				try{
					if(documentazioneTecnica.getABFlagLibrettoCompSI()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 7");
				try{
					if(documentazioneTecnica.getABFlagLibrettoImpNO()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 8");
				try{
					if(documentazioneTecnica.getABFlagLibrettoImpSI()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 9");
				try{
					if(documentazioneTecnica.getABFlagManutGenNO()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 10");
				try{
					if(documentazioneTecnica.getABFlagManutGenSI()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> A. Dati identificativi ");
				try{
					if(GenericUtil.isNotNullOrEmpty(datiIdentificativi.getAAPotenzaTermicaNomTotMax())){
						allegato.setAPotenzaTermicaNominaleMax(datiIdentificativi.getAAPotenzaTermicaNomTotMax());
					}
				}catch (Exception e) {allegato.setAPotenzaTermicaNominaleMax(null);}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> B. documentazione tecnica a corredo");

				//sezione F.check list
				it.csi.sigit.sigitwebn.xml.allegato3.data.CheckListDocument.CheckList checkList = allegatoIII.getCheckList();
				log.debug("[F ]check list --> checkList.getAFOsservazioni(): "+checkList.getAFOsservazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni())){
					allegato.setFOsservazioni(checkList.getAFOsservazioni());
				}
				log.debug("[F]check list --> checkList.getAFRaccomandazioni(): "+checkList.getAFRaccomandazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni())){
					allegato.setFRaccomandazioni(checkList.getAFRaccomandazioni());
				}
				log.debug("[F ]check list --> checkList.getAFPrescrizioni(): "+checkList.getAFPrescrizioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni())){
					allegato.setFPrescrizioni(checkList.getAFPrescrizioni());
				}

				it.csi.sigit.sigitwebn.xml.allegato3.data.DatiTecnicoDocument.DatiTecnico datiTecnico = allegatoIII.getDatiTecnico();

				try{
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpNO(): "+datiTecnico.getAFFlagFunzImpNO());
					if(datiTecnico.getAFFlagFunzImpNO()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					log.debug("[F]check list --> datiTecnico.getAFFlagFunzImpSI(): "+datiTecnico.getAFFlagFunzImpSI());
					if(datiTecnico.getAFFlagFunzImpSI()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				try{allegato.setFInterventoEntro(DateUtil.getSqlDate(datiTecnico.getAFDataIntervento()));}catch (Exception e) {allegato.setFInterventoEntro(null);}


				try{
					log.debug("[F ]check list --> datiTecnico.getAFOrarioArrivo(): "+datiTecnico.getAFOrarioArrivo());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioArrivo())){
						allegato.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
					}
				}catch (Exception e) {allegato.setFOraArrivo(null);}

				try{
					log.debug("[F]check list --> datiTecnico.getAFOrarioPartenza(): "+datiTecnico.getAFOrarioPartenza());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioPartenza())){
						allegato.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
					}
				}catch (Exception e) {allegato.setFOraPartenza(null);}
				log.debug("[F ]check list --> datiTecnico.getAFNomeTecnico(): "+datiTecnico.getAFNomeTecnico());
				log.debug("[F]check list --> datiTecnico.getAFCognomeTecnico(): "+datiTecnico.getAFCognomeTecnico());
				allegato.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));

				try{
					log.debug("[F]check list --> datiTecnico.getAFFirmaTecnico(): "+datiTecnico.getAFFirmaTecnico());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
						allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
						allegato.setFFirmaTecnico(datiTecnico.getAFFirmaTecnico());
					}else{
						allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {allegato.setFFlgFirmaTecnico(null);allegato.setFFlgFirmaTecnico(null);}


				try{
					log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
						allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
						allegato.setFFirmaResponsabile(datiTecnico.getAFFirmaResp());
					}else{
						allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {allegato.setFFlgFirmaResponsabile(null);allegato.setFFirmaResponsabile(null);}
				//Non so ancora cosa settare a livello di flg_controllo_bozza????
				allegato.setFlgControlloBozza(new BigDecimal(Constants.SI_1));
				allegato.setDataUltMod(DateUtil.getSqlDataCorrente());
				allegato.setUtenteUltMod(cfUtenteLoggato);

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> F.check list per  sigit_t_allegato");
				//aggiorno la tabella SIGIT_T_ALLEGATO
				if(!flagControllo){
					//solo al primo giro mi fai l'update perche' le ulteriori pagine non sono valorizzate per la sezione relativa allallegato
					try {
						getDbMgr().getSigitTAllegatoDao().update(allegato);
					} catch (SigitTAllegatoDaoException e) {
						throw new ManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
					}
				}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> update su  sigit_t_allegato");

				SigitTRappTipo2Dto rapportoTipo2 = new SigitTRappTipo2Dto();

				//attenzione parte legata a sigit_t_rapp_tipo1
				try {
					log.debug("[F ]check list --> checkList.getAFFlagIsolamentoCanali(): "+checkList.getAFFlagIsolamentoCanali());
					if(checkList.getAFFlagIsolamentoCanali()){
						rapportoTipo2.setFFlgIsolDistribuzH2o(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo2.setFFlgIsolDistribuzH2o(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {rapportoTipo2.setFFlgIsolDistribuzH2o(null);}


				try {
					log.debug("[F ]check list --> checkList.getAFFlagIsolamentoRete(): "+checkList.getAFFlagIsolamentoRete());
					if(checkList.getAFFlagIsolamentoRete()){
						rapportoTipo2.setFFlgIsolDistribuzAria(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo2.setFFlgIsolDistribuzAria(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {rapportoTipo2.setFFlgIsolDistribuzAria(null);}


				try {
					log.debug("[F ]check list --> checkList.getAFFlagSostGen1(): "+checkList.getAFFlagSostGen1());
					if(checkList.getAFFlagSostGen1()){
						rapportoTipo2.setFFlgSostituzGeneratori(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo2.setFFlgSostituzGeneratori(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {rapportoTipo2.setFFlgSostituzGeneratori(null);}


				try {
					log.debug("[F ]check list --> checkList.getAFFlagSostGen2(): "+checkList.getAFFlagSostGen2());
					if(checkList.getAFFlagSostGen2()){
						rapportoTipo2.setFFlgSostituzSistemiReg(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo2.setFFlgSostituzSistemiReg(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {rapportoTipo2.setFFlgSostituzSistemiReg(null);}
				//SEZIONE C.TRATTAMENTO ACQUA
				try {
					if(trattamentoAcqua.getACFlagTrattH2ONR()){
						rapportoTipo2.setCFlgTrattClimaNonRichiest(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo2.setCFlgTrattClimaNonRichiest(new BigDecimal(Constants.NO_0));
					}
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END -->  sezione F.check list legata a sigit_t_rapp_tipo1");
				}catch (Exception e) {rapportoTipo2.setCFlgTrattClimaNonRichiest(null);}


				//sezione D.controllo dell'impianto
				it.csi.sigit.sigitwebn.xml.allegato3.data.ControlloImpiantoDocument.ControlloImpianto controlloImpianto = allegatoIII.getControlloImpianto();

				try {
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLocaleIdoneoSI(): "+controlloImpianto.getADFlagLocaleIdoneoSI());
					if(controlloImpianto.getADFlagLocaleIdoneoSI()){
						rapportoTipo2.setDFlgLocaleIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagLocaleIdoneoNO()){
						rapportoTipo2.setDFlgLocaleIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagLocaleIdoneoNC()){
						rapportoTipo2.setDFlgLocaleIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo2.setDFlgLocaleIdoneo(null);}

				try {
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagDimensioniSI(): "+controlloImpianto.getADFlagDimensioniSI());
					if(controlloImpianto.getADFlagDimensioniSI()){
						rapportoTipo2.setDFlgApertureAdeg(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagDimensioniNO()){
						rapportoTipo2.setDFlgApertureAdeg(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagDimensioniNC()){
						rapportoTipo2.setDFlgApertureAdeg(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo2.setDFlgApertureAdeg(null);}


				try {
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagApertureSI(): "+controlloImpianto.getADFlagApertureSI());
					if(controlloImpianto.getADFlagApertureSI()){
						rapportoTipo2.setDFlgApertureLibere(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagApertureNO()){
						rapportoTipo2.setDFlgApertureLibere(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagApertureNC()){
						rapportoTipo2.setDFlgApertureLibere(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo2.setDFlgApertureLibere(null);}


				try {
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLineeIdoneeSI(): "+controlloImpianto.getADFlagLineeIdoneeSI());
					if(controlloImpianto.getADFlagLineeIdoneeSI()){
						rapportoTipo2.setDFlgLineaElettIdonea(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagLineeIdoneeNO()){
						rapportoTipo2.setDFlgLineaElettIdonea(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagLineeIdoneeNC()){
						rapportoTipo2.setDFlgLineaElettIdonea(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo2.setDFlgLineaElettIdonea(null);}


				try {
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagCoibenIdoneeSI(): "+controlloImpianto.getADFlagCoibenIdoneeSI());
					if(controlloImpianto.getADFlagCoibenIdoneeSI()){
						rapportoTipo2.setDFlgCoibIdonea(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagCoibenIdoneeNO()){
						rapportoTipo2.setDFlgCoibIdonea(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagCoibenIdoneeNC()){
						rapportoTipo2.setDFlgCoibIdonea(new BigDecimal(Constants.NC_2));
					}
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END -->  sezione D.controllo dell'impianto legata a sigit_t_rapp_tipo2");
				}catch (Exception e) {rapportoTipo2.setDFlgCoibIdonea(null);}


				//INSERISCO nella tabella SIGIT_RAPP_TIPO2
				rapportoTipo2.setIdAllegato(allegato.getIdAllegato());
				//controllo che non ci sia alcun record con questo id
				SigitTRappTipo2Pk pk = new SigitTRappTipo2Pk();
				pk.setIdAllegato(allegato.getIdAllegato());
				SigitTRappTipo2Dto dettaglioRapportoTipo2 = getDbMgr().getSigitTRappTipo2Dao().findByPrimaryKey(pk);
				if(dettaglioRapportoTipo2!=null){
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> UPDATE SU sigit_t_rapp_tipo2");
					//NON FACCIO ALCUN UPDATE PERCHE' AL SECONDO GIRO L'OGGETTO ROWALLEGATOIII NON HA TUTTI I CAMPI VALORIZZATI
				}else{
					getDbMgr().getSigitTRappTipo2Dao().insert(rapportoTipo2);
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> INSERT SU sigit_t_rapp_tipo2");
				}

				//sezione E.controllo e verifica energetica  del gruppo termico
				it.csi.sigit.sigitwebn.xml.allegato3.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVerificaEnergetica = allegatoIII.getControlloVerificaEnergetica();
				SigitTDettTipo2Dto sigitTDettTipo2Dto = new SigitTDettTipo2Dto();

				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagPerditeSI(): "+controlloVerificaEnergetica.getAEFlagPerditeSI());
				if(controlloVerificaEnergetica.getAEFlagPerditeSI()){
					sigitTDettTipo2Dto.setEFlgPerditaGas(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagPerditeNO()){
					sigitTDettTipo2Dto.setEFlgPerditaGas(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagPerditeNC()){
					sigitTDettTipo2Dto.setEFlgPerditaGas(new BigDecimal(Constants.NC_2));
				}
				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagRilevFugheDirettaSI(): "+controlloVerificaEnergetica.getAEFlagRilevFugheDirettaSI());
				if(controlloVerificaEnergetica.getAEFlagRilevFugheDirettaSI()){
					sigitTDettTipo2Dto.setEFlgLeakDetector(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagRilevFugheDirettaNO()){
					sigitTDettTipo2Dto.setEFlgLeakDetector(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagRilevFugheDirettaNC()){
					sigitTDettTipo2Dto.setEFlgLeakDetector(new BigDecimal(Constants.NC_2));
				}
				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaSI(): "+controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaSI());
				if(controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaSI()){
					sigitTDettTipo2Dto.setEFlgParamTermodinam(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaNO()){
					sigitTDettTipo2Dto.setEFlgParamTermodinam(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaNO()){
					sigitTDettTipo2Dto.setEFlgParamTermodinam(new BigDecimal(Constants.NC_2));
				}
				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagScambPulitiSI(): "+controlloVerificaEnergetica.getAEFlagScambPulitiSI());
				if(controlloVerificaEnergetica.getAEFlagScambPulitiSI()){
					sigitTDettTipo2Dto.setEFlgIncrostazioni(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagScambPulitiNO()){
					sigitTDettTipo2Dto.setEFlgIncrostazioni(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagScambPulitiNC()){
					sigitTDettTipo2Dto.setEFlgIncrostazioni(new BigDecimal(Constants.NC_2));
				}

				if(controlloVerificaEnergetica.getAEFlagRaffr()){
					sigitTDettTipo2Dto.setEFlgModProva(Constants.FLAG_MODALITA_RAFFRESCAMENTO);
				}
				if(controlloVerificaEnergetica.getAEFlagRisc()){
					sigitTDettTipo2Dto.setEFlgModProva(Constants.FLAG_MODALITA_RISCALDAMENTO);
				}

				sigitTDettTipo2Dto.setCodiceImpianto(impianto.getCodiceImpianto());
				sigitTDettTipo2Dto.setFkAllegato(allegato.getIdAllegato());
				sigitTDettTipo2Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
				sigitTDettTipo2Dto.setUtenteUltMod(cfUtenteLoggato);
				sigitTDettTipo2Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_GF);
				try{sigitTDettTipo2Dto.setProgressivo(ConvertUtil.convertToBigDecimal(allegatoIII.getAENumGF()));}catch (Exception e) {sigitTDettTipo2Dto.setProgressivo(null);}
				try{sigitTDettTipo2Dto.setDataInstall(DateUtil.getSqlDate(allegatoIII.getAEDataInstallaz()));}catch (Exception e) {sigitTDettTipo2Dto.setDataInstall(null);}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> sezione E.controllo e verifica energetica  del gruppo termico sigit_t_DETT_tipo2");
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] BEGIN --> sezione E.controllo e verifica energetica tab fumi del gruppo termico sigit_t_DETT_tipo1");
				it.csi.sigit.sigitwebn.xml.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII.TabFumi	tabFumi = allegatoIII.getTabFumi();
				List<it.csi.sigit.sigitwebn.xml.allegato3.data.RowFumiDocument.RowFumi> rigaFumi = tabFumi.getRowFumiList();
				if(rigaFumi!=null && rigaFumi.size()>0){
					log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO III LUNGHEZZA LISTA: "+rigaFumi.size());
					int count = 0;
					 for(it.csi.sigit.sigitwebn.xml.allegato3.data.RowFumiDocument.RowFumi dto : rigaFumi){
						 log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO III count: "+count);
						 try{ sigitTDettTipo2Dto.setETSurriscC(dto.getAESurrisc());}catch (Exception e) {sigitTDettTipo2Dto.setETSurriscC(null);}
						 try{ sigitTDettTipo2Dto.setETSottorafC(dto.getAESottoRaffr());}catch (Exception e) {sigitTDettTipo2Dto.setETSurriscC(null);}
						 try{ sigitTDettTipo2Dto.setETCondensazioneC(dto.getAECondens());}catch (Exception e) {sigitTDettTipo2Dto.setETCondensazioneC(null);}
						 try{ sigitTDettTipo2Dto.setETEvaporazioneC(dto.getAEEvaporaz());}catch (Exception e) {sigitTDettTipo2Dto.setETEvaporazioneC(null);}
						 try{ sigitTDettTipo2Dto.setETInExtC(dto.getAEIngLatoEst());}catch (Exception e) {sigitTDettTipo2Dto.setETInExtC(null);}
						 try{ sigitTDettTipo2Dto.setETOutExtC(dto.getAEUscLatoEst());}catch (Exception e) {sigitTDettTipo2Dto.setETOutExtC(null);}
						 try{ sigitTDettTipo2Dto.setETInUtenzeC(dto.getAEIngLatoUtenze());}catch (Exception e) {sigitTDettTipo2Dto.setETInUtenzeC(null);}
						 try{ sigitTDettTipo2Dto.setETOutUtenzeC(dto.getAEUscLatoUtenze());}catch (Exception e) {sigitTDettTipo2Dto.setETOutUtenzeC(null);}
						 try{ sigitTDettTipo2Dto.setENCircuito(ConvertUtil.convertToString(dto.getAENumCircuito()));}catch (Exception e) {sigitTDettTipo2Dto.setENCircuito(null);}
						 /*
						 try{ sigitTDettTipo2Dto.setL112TorreTOutFluido(ConvertUtil.convertToBigDecimal(dto.getAETuscFluido()));}catch (Exception e) {sigitTDettTipo2Dto.setL112TorreTOutFluido(null);}
						 try{ sigitTDettTipo2Dto.setL112TorreTBulboUmido(ConvertUtil.convertToBigDecimal(dto.getAETbulboUmido()));}catch (Exception e) {sigitTDettTipo2Dto.setL112TorreTBulboUmido(null);}
						 try{ sigitTDettTipo2Dto.setL112ScambiatoreTInExt(ConvertUtil.convertToBigDecimal(dto.getAETingFluidoSorg()));}catch (Exception e) {sigitTDettTipo2Dto.setL112ScambiatoreTInExt(null);}
						 try{ sigitTDettTipo2Dto.setL112ScambiatoreTOutExt(ConvertUtil.convertToBigDecimal(dto.getAETuscFluidoSorg()));}catch (Exception e) {sigitTDettTipo2Dto.setL112ScambiatoreTOutExt(null);}
						 try{ sigitTDettTipo2Dto.setL112ScambiatTInMacchina(ConvertUtil.convertToBigDecimal(dto.getAETingFluidoMacc()));}catch (Exception e) {sigitTDettTipo2Dto.setL112ScambiatTInMacchina(null);}
						 try{ sigitTDettTipo2Dto.setL112ScambiatTOutMacchina(ConvertUtil.convertToBigDecimal(dto.getAETuscFluidoMacc()));}catch (Exception e) {sigitTDettTipo2Dto.setL112ScambiatTOutMacchina(null);}
						 try{ sigitTDettTipo2Dto.setL112PotenzaAssorbitaKw(ConvertUtil.convertToBigDecimal(dto.getAEPotenzaAss()));}catch (Exception e) {sigitTDettTipo2Dto.setL112PotenzaAssorbitaKw(null);}

						 try{
							if(Constants.FILTRI_PULITI_SI.equalsIgnoreCase(dto.getAEFiltriPuliti()))
								sigitTDettTipo2Dto.setL112FlgPuliziaFiltri(new BigDecimal(Constants.SI_1));
							if(Constants.FILTRI_PULITI_NO.equalsIgnoreCase(dto.getAEFiltriPuliti()))
								sigitTDettTipo2Dto.setL112FlgPuliziaFiltri(new BigDecimal(Constants.NO_0));
							 }catch (Exception e) {
								 sigitTDettTipo2Dto.setL112FlgPuliziaFiltri(null);
							 }


						 try{
							 if(Constants.VERIFICA_SUPERATA_SI.equalsIgnoreCase(dto.getAEVerifica()))
								sigitTDettTipo2Dto.setL112FlgVerificaSuperata(new BigDecimal(Constants.SI_1));
							 if(Constants.VERIFICA_SUPERATA_NO.equalsIgnoreCase(dto.getAEVerifica()))
							    sigitTDettTipo2Dto.setL112FlgVerificaSuperata(new BigDecimal(Constants.NO_0));
							 }catch (Exception e) {
								 sigitTDettTipo2Dto.setL112FlgVerificaSuperata(null);
							 }

						 try{sigitTDettTipo2Dto.setL112DataRipristino(DateUtil.getSqlDate(dto.getAEDataRipristino()));}catch (Exception e) {sigitTDettTipo2Dto.setL112DataRipristino(null);}
							*/
						 //INSERISCO
						 getDbMgr().getSigitTDettTipo2Dao().insert(sigitTDettTipo2Dto);

						 count++;
					 }
				}
				//devo tracciaare il fatto che sono entrata la prima volta
				flagControllo = true;
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END dentro il for");
			}

			log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> INSERT SU sigit_t_DETT_tipo2");
			//adesso devo aggiornare la parte di libretto che e' dedicata esclusivamente all'allegato
			//mi trovo l'ultimo libretto aggiornato e creo una copia di questo sulla tabella
			//dopodiche' mi vado a richiamare il metodo che scrive il libretto e lo consolida

			SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
			//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
			recordLibretto.setCfRedattore(cfUtenteLoggato);
			recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
			recordLibretto.setUtenteUltMod(cfUtenteLoggato);
			recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
			//inserisco
			getDbMgr().inserisciLibretto(recordLibretto);

			log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> INSERT SU sigit_t_libretto");
			//adesso eseguo i punti 4, 5, 6 dell'algoritmo A002_7 riferito al libretto
			this.creaPdfEConsolidaLibretto(utenteLoggato, impianto, codiceRea, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO);
		}catch(Exception e){
			log.error("eccezione salvaInfoDaXmlAllegato2 --> "+e.getMessage(),e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));

		}
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END");
	}

	public void salvaInfoDaXmlAllegato3(MODIVDocument modAllegatoTipo3,
			SigitTAllegatoDto allegato, SigitTImpiantoDto impianto, UtenteLoggato utenteLoggato, String codiceRea)throws ManagerException {
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] BEGIN");

		String cfUtenteLoggato = utenteLoggato.getCodiceFiscale();

		//aggiorniamo di nuovo la tabella SIGIT_T_ALLEGATO con gli altri elementi aggiuntivi sia dell'xml che le informazioni dell'utente
		it.csi.sigit.sigitwebn.xml.allegato4.data.RichiestaDocument.Richiesta richiesta = modAllegatoTipo3.getMODIV().getRichiesta();

		//sezione B.documentazione tecnica a corredo
		List<RowAllegatoIV> allegatoIVList = richiesta.getDatiAllegato().getAllegatoIV().getRowAllegatoIVList();
		boolean flagControllo = false;

		try{
			log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] lubghezza rowAllegatiIII --> "+allegatoIVList.size());
			for(RowAllegatoIV allegatoIV: allegatoIVList){
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] entro nel for RowAllegatoIV");

				//RowAllegatoIV allegatoIV = allegatoIVList.get(0);
				it.csi.sigit.sigitwebn.xml.allegato4.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = allegatoIV.getDocumentazioneTecnica();
				it.csi.sigit.sigitwebn.xml.allegato4.data.TrattamentoAcquaDocument.TrattamentoAcqua trattamentoAcqua =  allegatoIV.getTrattamentoAcqua();

				try{
					if(documentazioneTecnica.getABFlagDichiarazConfNO()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagDichiarazConfSI()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

//				if(documentazioneTecnica.getABFlagDichiarazConfNO()){
//					allegato.setBFlgDichiarConform(new BigDecimal(Constants.NO_0));
//				}
//				if(documentazioneTecnica.getABFlagDichiarazConfSI()){
//					allegato.setBFlgDichiarConform(new BigDecimal(Constants.SI_1));
//				}

				try{
					if(documentazioneTecnica.getABFlagLibrettoCompNO()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagLibrettoCompSI()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}


//				if(documentazioneTecnica.getABFlagLibrettoCompNO()){
//					allegato.setBFlgLibCompl(new BigDecimal(Constants.NO_0));
//				}
//				if(documentazioneTecnica.getABFlagLibrettoCompSI()){
//					allegato.setBFlgLibCompl(new BigDecimal(Constants.SI_1));
//				}

				try{
					if(documentazioneTecnica.getABFlagLibrettoImpNO()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagLibrettoImpSI()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

//				if(documentazioneTecnica.getABFlagLibrettoImpNO()){
//					allegato.setBFlgLibImp(new BigDecimal(Constants.NO_0));
//				}
//				if(documentazioneTecnica.getABFlagLibrettoImpSI()){
//					allegato.setBFlgLibImp(new BigDecimal(Constants.SI_1));
//				}

				try{
					if(documentazioneTecnica.getABFlagManutGenNO()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagManutGenSI()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

//				if(documentazioneTecnica.getABFlagManutGenNO()){
//					allegato.setBFlgLibrettoUso(new BigDecimal(Constants.NO_0));
//				}
//				if(documentazioneTecnica.getABFlagManutGenSI()){
//					allegato.setBFlgLibrettoUso(new BigDecimal(Constants.SI_1));
//				}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END --> B. documentazione tecnica a corredo");

				//sezione F.check list
				it.csi.sigit.sigitwebn.xml.allegato4.data.CheckListDocument.CheckList checkList = allegatoIV.getCheckList();
				log.debug("[F ]check list --> checkList.getAFOsservazioni(): "+checkList.getAFOsservazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni())){
					allegato.setFOsservazioni(checkList.getAFOsservazioni());
				}
				log.debug("[F]check list --> checkList.getAFRaccomandazioni(): "+checkList.getAFRaccomandazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni())){
					allegato.setFRaccomandazioni(checkList.getAFRaccomandazioni());
				}
				log.debug("[F ]check list --> checkList.getAFPrescrizioni(): "+checkList.getAFPrescrizioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni())){
					allegato.setFPrescrizioni(checkList.getAFPrescrizioni());
				}

				it.csi.sigit.sigitwebn.xml.allegato4.data.DatiTecnicoDocument.DatiTecnico datiTecnico = allegatoIV.getDatiTecnico();
				try{
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpNO(): "+datiTecnico.getAFFlagFunzImpNO());
				if(datiTecnico.getAFFlagFunzImpNO()){
					allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.NO_0));
				}
				}catch (Exception e) {}
				try{
					log.debug("[F]check list --> datiTecnico.getAFFlagFunzImpSI(): "+datiTecnico.getAFFlagFunzImpSI());
				if(datiTecnico.getAFFlagFunzImpSI()){
					allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.SI_1));
				}
			}catch (Exception e) {}
				try{allegato.setFInterventoEntro(DateUtil.getSqlDate(datiTecnico.getAFDataIntervento()));}catch (Exception e) {allegato.setFInterventoEntro(null);}


				try{
					log.debug("[F ]check list --> datiTecnico.getAFOrarioArrivo(): "+datiTecnico.getAFOrarioArrivo());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioArrivo())){
					allegato.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
				}
				}catch (Exception e) {allegato.setFOraArrivo(null);}

				try{
					log.debug("[F]check list --> datiTecnico.getAFOrarioPartenza(): "+datiTecnico.getAFOrarioPartenza());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioPartenza())){
					allegato.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
				}
				}catch (Exception e) {allegato.setFOraPartenza(null);}
				log.debug("[F ]check list --> datiTecnico.getAFNomeTecnico(): "+datiTecnico.getAFNomeTecnico());
				log.debug("[F]check list --> datiTecnico.getAFCognomeTecnico(): "+datiTecnico.getAFCognomeTecnico());
				allegato.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));
				try{
					log.debug("[F]check list --> datiTecnico.getAFFirmaTecnico(): "+datiTecnico.getAFFirmaTecnico());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
					allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
				}else{
					allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
				}
				}catch (Exception e) {allegato.setFFlgFirmaTecnico(null);}
				try{
					log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
					allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
				}else{
					allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
				}
			}catch (Exception e) {allegato.setFFlgFirmaResponsabile(null);}
				//Non so ancora cosa settare a livello di flg_controllo_bozza????
				allegato.setFlgControlloBozza(new BigDecimal(Constants.SI_1));
				allegato.setDataUltMod(DateUtil.getSqlDataCorrente());
				allegato.setUtenteUltMod(cfUtenteLoggato);

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END --> F.check list per  sigit_t_allegato");
				//aggiorno la tabella SIGIT_T_ALLEGATO
				if(!flagControllo){
					//solo al primo giro mi fai l'update perche' le ulteriori pagine non sono valorizzate per la sezione relativa allallegato
					try {
						getDbMgr().getSigitTAllegatoDao().update(allegato);
					} catch (SigitTAllegatoDaoException e) {
						throw new ManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
					}
				}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END --> update su  sigit_t_allegato");

				SigitTRappTipo3Dto rapportoTipo3 = new SigitTRappTipo3Dto();
				//		log.debug("[F ]check list --> checkList.getAFFlagIsolamentoCanali(): "+checkList.getAFFlagIsolamentoCanali());
				//		//attenzione parte legata a sigit_t_rapp_tipo3
				//		if(checkList.getAFFlagIsolamentoCanali()){
				//			rapportoTipo3.setFFlgIsolDistribuzH2o(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo3.setFFlgIsolDistribuzH2o(new BigDecimal(Constants.NO_0));
				//		}
				//		log.debug("[F ]check list --> checkList.getAFFlagIsolamentoRete(): "+checkList.getAFFlagIsolamentoRete());
				//		if(checkList.getAFFlagIsolamentoRete()){
				//			rapportoTipo3.setFFlgIsolDistribuzAria(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo3.setFFlgIsolDistribuzAria(new BigDecimal(Constants.NO_0));
				//		}
				//		log.debug("[F ]check list --> checkList.getAFFlagSostGen1(): "+checkList.getAFFlagSostGen1());
				//		if(checkList.getAFFlagSostGen1()){
				//			rapportoTipo3.setFFlgSostituzGeneratori(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo3.setFFlgSostituzGeneratori(new BigDecimal(Constants.NO_0));
				//		}
				//		log.debug("[F ]check list --> checkList.getAFFlagSostGen2(): "+checkList.getAFFlagSostGen2());
				//		if(checkList.getAFFlagSostGen2()){
				//			rapportoTipo3.setFFlgSostituzSistemiReg(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo3.setFFlgSostituzSistemiReg(new BigDecimal(Constants.NO_0));
				//		}


				//SEZIONE C.TRATTAMENTO ACQUA
				try{
				if(trattamentoAcqua.getACFlagTrattH2ONR()){
					rapportoTipo3.setCFlgTrattClimaNonRichiest(new BigDecimal(Constants.SI_1));
				}else{
					rapportoTipo3.setCFlgTrattClimaNonRichiest(new BigDecimal(Constants.NO_0));
				}
				}catch (Exception e) {rapportoTipo3.setCFlgTrattClimaNonRichiest(null);}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END -->  sezione F.check list legata a sigit_t_rapp_tipo3");

				//sezione D.controllo dell'impianto
				it.csi.sigit.sigitwebn.xml.allegato4.data.ControlloImpiantoDocument.ControlloImpianto controlloImpianto = allegatoIV.getControlloImpianto();

				log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLuogoIdoneoSI(): "+controlloImpianto.getADFlagLuogoIdoneoSI());
				try{
					if(controlloImpianto.getADFlagLuogoIdoneoSI()){
						rapportoTipo3.setDFlgLocaleIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagLuogoIdoneoNO()){
						rapportoTipo3.setDFlgLocaleIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagLuogoIdoneoNC()){
						rapportoTipo3.setDFlgLocaleIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo3.setDFlgLocaleIdoneo(null);}
				//		log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagDimensioniSI(): "+controlloImpianto.getADFlagDimensioniSI());
				//		if(controlloImpianto.getADFlagDimensioniSI()){
				//			rapportoTipo3.setDFlgApertureAdeg(new BigDecimal(Constants.SI_1));
				//		}else if(controlloImpianto.getADFlagDimensioniNO()){
				//			rapportoTipo3.setDFlgApertureAdeg(new BigDecimal(Constants.NO_0));
				//		}else if(controlloImpianto.getADFlagDimensioniNC()){
				//			rapportoTipo3.setDFlgApertureAdeg(new BigDecimal(Constants.NC_2));
				//		}

				//		log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagApertureSI(): "+controlloImpianto.getADFlagApertureSI());
				//		if(controlloImpianto.getADFlagApertureSI()){
				//			rapportoTipo3.setDFlgApertureLibere(new BigDecimal(Constants.SI_1));
				//		}else if(controlloImpianto.getADFlagApertureNO()){
				//			rapportoTipo3.setDFlgApertureLibere(new BigDecimal(Constants.NO_0));
				//		}else if(controlloImpianto.getADFlagApertureNC()){
				//			rapportoTipo3.setDFlgApertureLibere(new BigDecimal(Constants.NC_2));
				//		}

				log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLineeIdoneeSI(): "+controlloImpianto.getADFlagLineeIdoneeSI());
				try{
				if(controlloImpianto.getADFlagLineeIdoneeSI()){
					rapportoTipo3.setDFlgLineaElettIdonea(new BigDecimal(Constants.SI_1));
				}else if(controlloImpianto.getADFlagLineeIdoneeNO()){
					rapportoTipo3.setDFlgLineaElettIdonea(new BigDecimal(Constants.NO_0));
				}else if(controlloImpianto.getADFlagLineeIdoneeNC()){
					rapportoTipo3.setDFlgLineaElettIdonea(new BigDecimal(Constants.NC_2));
				}
				}catch (Exception e) {rapportoTipo3.setDFlgLineaElettIdonea(null);}

				try{
				log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagCoibenIdoneeSI(): "+controlloImpianto.getADFlagStatoCoibenSI());
				if(controlloImpianto.getADFlagStatoCoibenSI()){
					rapportoTipo3.setDFlgCoibIdonea(new BigDecimal(Constants.SI_1));
				}else if(controlloImpianto.getADFlagStatoCoibenNO()){
					rapportoTipo3.setDFlgCoibIdonea(new BigDecimal(Constants.NO_0));
				}else if(controlloImpianto.getADFlagStatoCoibenNC()){
					rapportoTipo3.setDFlgCoibIdonea(new BigDecimal(Constants.NC_2));
				}
				}catch (Exception e) {rapportoTipo3.setDFlgCoibIdonea(null);}

				try{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagPerditeSI(): "+controlloImpianto.getADFlagPerditeSI());
					if(controlloImpianto.getADFlagPerditeSI()){
						rapportoTipo3.setDFlgAssenzaPerdite(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagPerditeNO()){
						rapportoTipo3.setDFlgAssenzaPerdite(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagPerditeNC()){
						rapportoTipo3.setDFlgAssenzaPerdite(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo3.setDFlgAssenzaPerdite(null);}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END -->  sezione D.controllo dell'impianto legata a sigit_t_rapp_tipo2");

				//INSERISCO nella tabella SIGIT_RAPP_TIPO3
				rapportoTipo3.setIdAllegato(allegato.getIdAllegato());

				SigitTRappTipo3Pk pk = new SigitTRappTipo3Pk();
				pk.setIdAllegato(allegato.getIdAllegato());
				//devo controllare se ho un record presente sulla tabella o no
				SigitTRappTipo3Dto dettaglioRappTipo3 = getDbMgr().getSigitTRappTipo3Dao().findByPrimaryKey(pk);
				if(dettaglioRappTipo3!=null){
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] TROVATO RECORD SU sigit_t_rapp_tipo3");
					//non posso fare l'update perche' nelle pagine successive non mi riporta tutti i dati
					//getDbMgr().getSigitTRappTipo1Dao().update(rapportoTipo1);
				}
				else{
					getDbMgr().getSigitTRappTipo3Dao().insert(rapportoTipo3);
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END --> INSERT SU sigit_t_rapp_tipo3");
				}

				//sezione E.controllo e verifica energetica  del gruppo termico
				it.csi.sigit.sigitwebn.xml.allegato4.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVerificaEnergetica = allegatoIV.getControlloVerificaEnergetica();
				SigitTDettTipo3Dto sigitTDettTipo3Dto = new SigitTDettTipo3Dto();

				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagPotCompSI(): "+controlloVerificaEnergetica.getAEFlagPotCompSI());
				if(controlloVerificaEnergetica.getAEFlagPotCompSI()){
					sigitTDettTipo3Dto.setEFlgPotenzaCompatibile(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagPotCompNO()){
					sigitTDettTipo3Dto.setEFlgPotenzaCompatibile(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagPotCompNC()){
					sigitTDettTipo3Dto.setEFlgPotenzaCompatibile(new BigDecimal(Constants.NC_2));
				}

				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagStatoCoibenSI(): "+controlloVerificaEnergetica.getAEFlagStatoCoibenSI());
				if(controlloVerificaEnergetica.getAEFlagStatoCoibenSI()){
					sigitTDettTipo3Dto.setEFlgCoibIdonea(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagStatoCoibenNO()){
					sigitTDettTipo3Dto.setEFlgCoibIdonea(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagStatoCoibenNC()){
					sigitTDettTipo3Dto.setEFlgCoibIdonea(new BigDecimal(Constants.NC_2));
				}

				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagDispRegSI(): "+controlloVerificaEnergetica.getAEFlagDispRegSI());
				if(controlloVerificaEnergetica.getAEFlagDispRegSI()){
					sigitTDettTipo3Dto.setEFlgDispFunzionanti(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagDispRegNO()){
					sigitTDettTipo3Dto.setEFlgDispFunzionanti(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagDispRegNO()){
					sigitTDettTipo3Dto.setEFlgDispFunzionanti(new BigDecimal(Constants.NC_2));
				}
				//
				//		log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagScambPulitiSI(): "+controlloVerificaEnergetica.getAEFlagScambPulitiSI());
				//		if(controlloVerificaEnergetica.getAEFlagScambPulitiSI()){
				//			sigitTDettTipo3Dto.setEFlgIncrostazioni(new BigDecimal(Constants.SI_1));
				//		}else if(controlloVerificaEnergetica.getAEFlagScambPulitiNO()){
				//			sigitTDettTipo3Dto.setEFlgIncrostazioni(new BigDecimal(Constants.NO_0));
				//		}else if(controlloVerificaEnergetica.getAEFlagScambPulitiNC()){
				//			sigitTDettTipo3Dto.setEFlgIncrostazioni(new BigDecimal(Constants.NC_2));
				//		}
				//
				//		if(controlloVerificaEnergetica.getAEFlagRaffr()){
				//			sigitTDettTipo3Dto.setEFlgModProva(Constants.FLAG_MODALITA_RAFFRESCAMENTO);
				//		}
				//		if(controlloVerificaEnergetica.getAEFlagRisc()){
				//			sigitTDettTipo3Dto.setEFlgModProva(Constants.FLAG_MODALITA_RISCALDAMENTO);
				//		}

				sigitTDettTipo3Dto.setCodiceImpianto(impianto.getCodiceImpianto());
				sigitTDettTipo3Dto.setFkAllegato(allegato.getIdAllegato());
				sigitTDettTipo3Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
				sigitTDettTipo3Dto.setUtenteUltMod(cfUtenteLoggato);
				sigitTDettTipo3Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_SC);
				try{sigitTDettTipo3Dto.setProgressivo(ConvertUtil.convertToBigDecimal(allegatoIV.getAENumSC()));}catch (Exception e) {sigitTDettTipo3Dto.setProgressivo(null);}
				try{sigitTDettTipo3Dto.setDataInstall(DateUtil.getSqlDate(allegatoIV.getAEDataInstallaz()));}catch (Exception e) {sigitTDettTipo3Dto.setDataInstall(null);}

				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagClimatizInv(): "+controlloVerificaEnergetica.getAEFlagClimatizInv());
				if(controlloVerificaEnergetica.getAEFlagClimatizInv()){
					sigitTDettTipo3Dto.setEFlgClimaInverno(new BigDecimal(Constants.SI_1));
				}else{
					sigitTDettTipo3Dto.setEFlgClimaInverno(new BigDecimal(Constants.NO_0));
				}
				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagProduzACS(): "+controlloVerificaEnergetica.getAEFlagProduzACS());
				if(controlloVerificaEnergetica.getAEFlagProduzACS()){
					sigitTDettTipo3Dto.setEFlgProduzAcs(new BigDecimal(Constants.SI_1));
				}else{
					sigitTDettTipo3Dto.setEFlgProduzAcs(new BigDecimal(Constants.NO_0));
				}

				sigitTDettTipo3Dto.setFkFluidoAlimentaz(new BigDecimal(controlloVerificaEnergetica.getAECombustibile()));
				sigitTDettTipo3Dto.setFkFluido(new BigDecimal(controlloVerificaEnergetica.getAEFluidoVett()));


				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END --> sezione E.controllo e verifica energetica  del gruppo termico sigit_t_DETT_tipo3");
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] BEGIN --> sezione E.controllo e verifica energetica tab fumi del gruppo termico sigit_t_DETT_tipo3");
				it.csi.sigit.sigitwebn.xml.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV.TabFumi	tabFumi = allegatoIV.getTabFumi();
				List<it.csi.sigit.sigitwebn.xml.allegato4.data.RowFumiDocument.RowFumi> rigaFumi = tabFumi.getRowFumiList();
				if(rigaFumi!=null && rigaFumi.size()>0){
					log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO IV LUNGHEZZA LISTA: "+rigaFumi.size());
					for(it.csi.sigit.sigitwebn.xml.allegato4.data.RowFumiDocument.RowFumi dto : rigaFumi){
						try{ sigitTDettTipo3Dto.setETempExtC(dto.getAETempEst());}catch (Exception e) {sigitTDettTipo3Dto.setETempExtC(null);}

						try{ sigitTDettTipo3Dto.setETempMandPrimarioC(dto.getAETempMandPrim());}catch (Exception e) {sigitTDettTipo3Dto.setETempMandPrimarioC(null);}
						try{ sigitTDettTipo3Dto.setETempRitorPrimarioC(dto.getAETempRitPrim());}catch (Exception e) {sigitTDettTipo3Dto.setETempRitorPrimarioC(null);}
						try{ sigitTDettTipo3Dto.setEPotenzaTermKw(dto.getAEPotenzaTerm());}catch (Exception e) {sigitTDettTipo3Dto.setEPotenzaTermKw(null);}
						try{ sigitTDettTipo3Dto.setEPortFluidoM3H(dto.getAEPortataFluido());}catch (Exception e) {sigitTDettTipo3Dto.setEPortFluidoM3H(null);}
						try{ sigitTDettTipo3Dto.setETempMandSecondarioC(dto.getAETempMandSecond());}catch (Exception e) {sigitTDettTipo3Dto.setETempMandSecondarioC(null);}
						try{ sigitTDettTipo3Dto.setETempRitSecondarioC(dto.getAETempRitSecond());}catch (Exception e) {sigitTDettTipo3Dto.setETempRitSecondarioC(null);}

						//INSERISCO
						getDbMgr().getSigitTDettTipo3Dao().insert(sigitTDettTipo3Dto);
						log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END --> INSERT SU sigit_t_DETT_tipo3");

					}
				}
				//devo tracciaare il fatto che sono entrata la prima volta
				flagControllo = true;
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END dentro il for");
			}



		//adesso devo aggiornare la parte di libretto che e' dedicata esclusivamente all'allegato
		//mi trovo l'ultimo libretto aggiornato e creo una copia di questo sulla tabella
		//dopodiche' mi vado a richiamare il metodo che scrive il libretto e lo consolida

		SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
		//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
		recordLibretto.setCfRedattore(cfUtenteLoggato);
		recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
		recordLibretto.setUtenteUltMod(cfUtenteLoggato);
		recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
		//inserisco
		getDbMgr().inserisciLibretto(recordLibretto);

		log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END --> INSERT SU sigit_t_libretto");
		//adesso eseguo i punti 4, 5, 6 dell'algoritmo A002_7 riferito al libretto
		this.creaPdfEConsolidaLibretto(utenteLoggato, impianto, codiceRea, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO);

		}catch(Exception e){
			log.error("eccezione salvaInfoDaXmlAllegato3 --> "+e.getMessage(),e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END");
	}

	public void salvaInfoDaXmlAllegato4(MODVDocument modAllegatoTipo4,
			SigitTAllegatoDto allegato, SigitTImpiantoDto impianto, UtenteLoggato utenteLoggato, String codiceRea)throws ManagerException {
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] BEGIN");

		String cfUtenteLoggato = utenteLoggato.getCodiceFiscale();

		//aggiorniamo di nuovo la tabella SIGIT_T_ALLEGATO con gli altri elementi aggiuntivi sia dell'xml che le informazioni dell'utente
		it.csi.sigit.sigitwebn.xml.allegato5.data.RichiestaDocument.Richiesta richiesta = modAllegatoTipo4.getMODV().getRichiesta();

		//sezione B.documentazione tecnica a corredo
		List<RowAllegatoV> allegatoVList = richiesta.getDatiAllegato().getAllegatoV().getRowAllegatoVList();
		boolean flagControllo = false;

		try{
			log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] lubghezza rowAllegatiV --> "+allegatoVList.size());
			for(RowAllegatoV allegatoV: allegatoVList){
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] entro nel for RowAllegatoV");



				it.csi.sigit.sigitwebn.xml.allegato5.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = allegatoV.getDocumentazioneTecnica();
//				it.csi.sigit.sigitwebn.xml.allegato5.data.TrattamentoAcquaDocument.TrattamentoAcqua trattamentoAcqua =  allegatoV.getTrattamentoAcqua();

				try{
					if(documentazioneTecnica.getABFlagDichiarazConfNO()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagDichiarazConfSI()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagLibrettoCompNO()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagLibrettoCompSI()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagLibrettoImpNO()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagLibrettoImpSI()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagManutGenNO()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagManutGenSI()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> B. documentazione tecnica a corredo");

				//sezione F.check list
				it.csi.sigit.sigitwebn.xml.allegato5.data.CheckListDocument.CheckList checkList = allegatoV.getCheckList();
				log.debug("[F ]check list --> checkList.getAFOsservazioni(): "+checkList.getAFOsservazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni())){
					allegato.setFOsservazioni(checkList.getAFOsservazioni());
				}
				log.debug("[F]check list --> checkList.getAFRaccomandazioni(): "+checkList.getAFRaccomandazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni())){
					allegato.setFRaccomandazioni(checkList.getAFRaccomandazioni());
				}
				log.debug("[F ]check list --> checkList.getAFPrescrizioni(): "+checkList.getAFPrescrizioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni())){
					allegato.setFPrescrizioni(checkList.getAFPrescrizioni());
				}

				it.csi.sigit.sigitwebn.xml.allegato5.data.DatiTecnicoDocument.DatiTecnico datiTecnico = allegatoV.getDatiTecnico();

				try{
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpNO(): "+datiTecnico.getAFFlagFunzImpNO());

					if(datiTecnico.getAFFlagFunzImpNO()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					log.debug("[F]check list --> datiTecnico.getAFFlagFunzImpSI(): "+datiTecnico.getAFFlagFunzImpSI());
					if(datiTecnico.getAFFlagFunzImpSI()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				try{allegato.setFInterventoEntro(DateUtil.getSqlDate(datiTecnico.getAFDataIntervento()));}catch (Exception e) {allegato.setFInterventoEntro(null);}

				log.debug("[F ]check list --> datiTecnico.getAFOrarioArrivo(): "+datiTecnico.getAFOrarioArrivo());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioArrivo())){
					allegato.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
				}
				log.debug("[F]check list --> datiTecnico.getAFOrarioPartenza(): "+datiTecnico.getAFOrarioPartenza());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioPartenza())){
					allegato.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
				}
				log.debug("[F ]check list --> datiTecnico.getAFNomeTecnico(): "+datiTecnico.getAFNomeTecnico());
				log.debug("[F]check list --> datiTecnico.getAFCognomeTecnico(): "+datiTecnico.getAFCognomeTecnico());
				allegato.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));
				log.debug("[F]check list --> datiTecnico.getAFFirmaTecnico(): "+datiTecnico.getAFFirmaTecnico());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
					allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
				}else{
					allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
				}
				log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
					allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
				}else{
					allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
				}

				//Non so ancora cosa settare a livello di flg_controllo_bozza????
				allegato.setFlgControlloBozza(new BigDecimal(Constants.SI_1));
				allegato.setDataUltMod(DateUtil.getSqlDataCorrente());
				allegato.setUtenteUltMod(cfUtenteLoggato);


				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END --> F.check list per  sigit_t_allegato");
				//aggiorno la tabella SIGIT_T_ALLEGATO
				if(!flagControllo){
					//solo al primo giro mi fai l'update perche' le ulteriori pagine non sono valorizzate per la sezione relativa allallegato
					try {
						getDbMgr().getSigitTAllegatoDao().update(allegato);
					} catch (SigitTAllegatoDaoException e) {
						throw new ManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
					}
				}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] END --> update su  sigit_t_allegato");

				SigitTRappTipo4Dto rapportoTipo4 = new SigitTRappTipo4Dto();
				//		log.debug("[F ]check list --> checkList.getAFFlagIsolamentoCanali(): "+checkList.getAFFlagIsolamentoCanali());
				//		//attenzione parte legata a sigit_t_rapp_tipo1
				//		if(checkList.getAFFlagIsolamentoCanali()){
				//			rapportoTipo2.setFFlgIsolDistribuzH2o(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo2.setFFlgIsolDistribuzH2o(new BigDecimal(Constants.NO_0));
				//		}
				//		log.debug("[F ]check list --> checkList.getAFFlagIsolamentoRete(): "+checkList.getAFFlagIsolamentoRete());
				//		if(checkList.getAFFlagIsolamentoRete()){
				//			rapportoTipo2.setFFlgIsolDistribuzAria(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo2.setFFlgIsolDistribuzAria(new BigDecimal(Constants.NO_0));
				//		}
				//		log.debug("[F ]check list --> checkList.getAFFlagSostGen1(): "+checkList.getAFFlagSostGen1());
				//		if(checkList.getAFFlagSostGen1()){
				//			rapportoTipo2.setFFlgSostituzGeneratori(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo2.setFFlgSostituzGeneratori(new BigDecimal(Constants.NO_0));
				//		}
				//		log.debug("[F ]check list --> checkList.getAFFlagSostGen2(): "+checkList.getAFFlagSostGen2());
				//		if(checkList.getAFFlagSostGen2()){
				//			rapportoTipo2.setFFlgSostituzSistemiReg(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo2.setFFlgSostituzSistemiReg(new BigDecimal(Constants.NO_0));
				//		}
				//		//SEZIONE C.TRATTAMENTO ACQUA
				//		if(trattamentoAcqua.getACFlagTrattH2ONR()){
				//			rapportoTipo2.setCFlgTrattClimaNonRichiest(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo2.setCFlgTrattClimaNonRichiest(new BigDecimal(Constants.NO_0));
				//		}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END -->  sezione F.check list legata a sigit_t_rapp_tipo1");

				//sezione D.controllo dell'impianto
				it.csi.sigit.sigitwebn.xml.allegato5.data.ControlloImpiantoDocument.ControlloImpianto controlloImpianto = allegatoV.getControlloImpianto();

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLuogoIdoneoSI(): "+controlloImpianto.getADFlagLuogoIdoneoSI());
					if(controlloImpianto.getADFlagLuogoIdoneoSI()){
						rapportoTipo4.setDFlgLuogoIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagLuogoIdoneoNO()){
						rapportoTipo4.setDFlgLuogoIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagLuogoIdoneoNC()){
						rapportoTipo4.setDFlgLuogoIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgLuogoIdoneo(null);}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagDimensioniSI(): "+controlloImpianto.getADFlagDimensioniSI());
					if(controlloImpianto.getADFlagDimensioniSI()){
						rapportoTipo4.setDFlgVentilazAdeg(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagDimensioniNO()){
						rapportoTipo4.setDFlgVentilazAdeg(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagDimensioniNC()){
						rapportoTipo4.setDFlgVentilazAdeg(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgVentilazAdeg(null);}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagApertureSI(): "+controlloImpianto.getADFlagApertureSI());
					if(controlloImpianto.getADFlagApertureSI()){
						rapportoTipo4.setDFlgVentilazLibera(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagApertureNO()){
						rapportoTipo4.setDFlgVentilazLibera(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagApertureNC()){
						rapportoTipo4.setDFlgVentilazLibera(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgVentilazLibera(null);}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLineeIdoneeSI(): "+controlloImpianto.getADFlagLineeIdoneeSI());
					if(controlloImpianto.getADFlagLineeIdoneeSI()){
						rapportoTipo4.setDFlgLineaElettIdonea(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagLineeIdoneeNO()){
						rapportoTipo4.setDFlgLineaElettIdonea(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagLineeIdoneeNC()){
						rapportoTipo4.setDFlgLineaElettIdonea(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgLineaElettIdonea(null);}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagCanaleFumoSI(): "+controlloImpianto.getADFlagCanaleFumoSI());
					if(controlloImpianto.getADFlagCanaleFumoSI()){
						rapportoTipo4.setDFlgCaminoIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagCanaleFumoNO()){
						rapportoTipo4.setDFlgCaminoIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagCanaleFumoNC()){
						rapportoTipo4.setDFlgCaminoIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgCaminoIdoneo(null);}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagCapsulaInsoSI(): "+controlloImpianto.getADFlagCapsulaInsoSI());
					if(controlloImpianto.getADFlagCapsulaInsoSI()){
						rapportoTipo4.setDFlgCapsulaIdonea(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagCapsulaInsoNO()){
						rapportoTipo4.setDFlgCapsulaIdonea(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagCapsulaInsoNC()){
						rapportoTipo4.setDFlgCapsulaIdonea(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgCapsulaIdonea(null);}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagTenutaIdraulicaSI(): "+controlloImpianto.getADFlagTenutaIdraulicaSI());
					if(controlloImpianto.getADFlagTenutaIdraulicaSI()){
						rapportoTipo4.setDFlgCircIdrIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagTenutaIdraulicaNO()){
						rapportoTipo4.setDFlgCircIdrIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagTenutaIdraulicaNC()){
						rapportoTipo4.setDFlgCircIdrIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgCircIdrIdoneo(null);}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagTenutaOlioSI(): "+controlloImpianto.getADFlagTenutaOlioSI());
					if(controlloImpianto.getADFlagTenutaOlioSI()){
						rapportoTipo4.setDFlgCircOlioIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagTenutaOlioNO()){
						rapportoTipo4.setDFlgCircOlioIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagTenutaOlioNC()){
						rapportoTipo4.setDFlgCircOlioIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgCircOlioIdoneo(null);}


				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagTenutaAlimentazSI(): "+controlloImpianto.getADFlagTenutaAlimentazSI());
					if(controlloImpianto.getADFlagTenutaAlimentazSI()){
						rapportoTipo4.setDFlgCircCombIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagTenutaAlimentazNO()){
						rapportoTipo4.setDFlgCircCombIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagTenutaAlimentazNC()){
						rapportoTipo4.setDFlgCircCombIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgCircCombIdoneo(null);}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagFunzionalitaSI(): "+controlloImpianto.getADFlagFunzionalitaSI());
					if(controlloImpianto.getADFlagFunzionalitaSI()){
						rapportoTipo4.setDFlgFunzScambIdonea(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagFunzionalitaNO()){
						rapportoTipo4.setDFlgFunzScambIdonea(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagFunzionalitaNC()){
						rapportoTipo4.setDFlgFunzScambIdonea(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgFunzScambIdonea(null);}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END -->  sezione D.controllo dell'impianto legata a sigit_t_rapp_tipo2");

				//INSERISCO nella tabella SIGIT_RAPP_TIPO4
				rapportoTipo4.setIdAllegato(allegato.getIdAllegato());

				SigitTRappTipo4Pk pk = new SigitTRappTipo4Pk();
				pk.setIdAllegato(allegato.getIdAllegato());
				//devo controllare se ho un record presente sulla tabella o no
				SigitTRappTipo4Dto dettaglioRappTipo4 = getDbMgr().getSigitTRappTipo4Dao().findByPrimaryKey(pk);
				if(dettaglioRappTipo4!=null){
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] TROVATO RECORD SU sigit_t_rapp_tipo4");
					//non posso fare l'update perche' nelle pagine successive non mi riporta tutti i dati
				}
				else{
					getDbMgr().getSigitTRappTipo4Dao().insert(rapportoTipo4);
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] END --> INSERT SU sigit_t_rapp_tipo4");
				}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] END --> INSERT SU sigit_t_rapp_tipo4");

				//sezione E.controllo e verifica energetica  del gruppo termico
				it.csi.sigit.sigitwebn.xml.allegato5.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVerificaEnergetica = allegatoV.getControlloVerificaEnergetica();
				SigitTDettTipo4Dto sigitTDettTipo4Dto = new SigitTDettTipo4Dto();

				/*
		log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagPerditeSI(): "+controlloVerificaEnergetica.getAEFlagPerditeSI());
		if(controlloVerificaEnergetica.getAEFlagPerditeSI()){
			sigitTDettTipo4Dto.setEFlgPerditaGas(new BigDecimal(Constants.SI_1));
		}else if(controlloVerificaEnergetica.getAEFlagPerditeNO()){
			sigitTDettTipo4Dto.setEFlgPerditaGas(new BigDecimal(Constants.NO_0));
		}else if(controlloVerificaEnergetica.getAEFlagPerditeNC()){
			sigitTDettTipo4Dto.setEFlgPerditaGas(new BigDecimal(Constants.NC_2));
		}
		log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagRilevFugheDirettaSI(): "+controlloVerificaEnergetica.getAEFlagRilevFugheDirettaSI());
		if(controlloVerificaEnergetica.getAEFlagRilevFugheDirettaSI()){
			sigitTDettTipo4Dto.setEFlgLeakDetector(new BigDecimal(Constants.SI_1));
		}else if(controlloVerificaEnergetica.getAEFlagRilevFugheDirettaNO()){
			sigitTDettTipo4Dto.setEFlgLeakDetector(new BigDecimal(Constants.NO_0));
		}else if(controlloVerificaEnergetica.getAEFlagRilevFugheDirettaNC()){
			sigitTDettTipo4Dto.setEFlgLeakDetector(new BigDecimal(Constants.NC_2));
		}
		log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaSI(): "+controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaSI());
		if(controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaSI()){
			sigitTDettTipo4Dto.setEFlgParamTermodinam(new BigDecimal(Constants.SI_1));
		}else if(controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaNO()){
			sigitTDettTipo4Dto.setEFlgParamTermodinam(new BigDecimal(Constants.NO_0));
		}else if(controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaNO()){
			sigitTDettTipo4Dto.setEFlgParamTermodinam(new BigDecimal(Constants.NC_2));
		}
		log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagScambPulitiSI(): "+controlloVerificaEnergetica.getAEFlagScambPulitiSI());
		if(controlloVerificaEnergetica.getAEFlagScambPulitiSI()){
			sigitTDettTipo4Dto.setEFlgIncrostazioni(new BigDecimal(Constants.SI_1));
		}else if(controlloVerificaEnergetica.getAEFlagScambPulitiNO()){
			sigitTDettTipo4Dto.setEFlgIncrostazioni(new BigDecimal(Constants.NO_0));
		}else if(controlloVerificaEnergetica.getAEFlagScambPulitiNC()){
			sigitTDettTipo4Dto.setEFlgIncrostazioni(new BigDecimal(Constants.NC_2));
		}

		if(controlloVerificaEnergetica.getAEFlagRaffr()){
			sigitTDettTipo4Dto.setEFlgModProva(Constants.FLAG_MODALITA_RAFFRESCAMENTO);
		}
		if(controlloVerificaEnergetica.getAEFlagRisc()){
			sigitTDettTipo4Dto.setEFlgModProva(Constants.FLAG_MODALITA_RISCALDAMENTO);
		}
				 */

				sigitTDettTipo4Dto.setCodiceImpianto(impianto.getCodiceImpianto());
				sigitTDettTipo4Dto.setFkAllegato(allegato.getIdAllegato());
				sigitTDettTipo4Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
				sigitTDettTipo4Dto.setUtenteUltMod(cfUtenteLoggato);
				sigitTDettTipo4Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_CG);
				try{sigitTDettTipo4Dto.setProgressivo(ConvertUtil.convertToBigDecimal(allegatoV.getAENumCG()));}catch (Exception e) {sigitTDettTipo4Dto.setProgressivo(null);}
				try{sigitTDettTipo4Dto.setDataInstall(DateUtil.getSqlDate(allegatoV.getAEDataInstallaz()));}catch (Exception e) {sigitTDettTipo4Dto.setDataInstall(null);}

				sigitTDettTipo4Dto.setFkFluido(new BigDecimal(controlloVerificaEnergetica.getAEFluidoVett()));


				try{sigitTDettTipo4Dto.setEPotenzaAssorbCombKw(allegatoV.getAEPotenzaAssorbita());}catch (Exception e) {sigitTDettTipo4Dto.setEPotenzaAssorbCombKw(null);}
				try{sigitTDettTipo4Dto.setEPotenzaTermBypassKw(allegatoV.getAEPotenzaTermByPass());}catch (Exception e) {sigitTDettTipo4Dto.setEPotenzaTermBypassKw(null);}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] END --> sezione E.controllo e verifica energetica  del gruppo termico sigit_t_DETT_tipo4");

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] BEGIN --> sezione E.controllo e verifica energetica tab fumi del gruppo termico sigit_t_DETT_tipo4");
				it.csi.sigit.sigitwebn.xml.allegato5.data.RowAllegatoVDocument.RowAllegatoV.TabFumi	tabFumi = allegatoV.getTabFumi();
				List<it.csi.sigit.sigitwebn.xml.allegato5.data.RowFumiDocument.RowFumi> rigaFumi = tabFumi.getRowFumiList();
				if(rigaFumi!=null && rigaFumi.size()>0){
					log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO V LUNGHEZZA LISTA: "+rigaFumi.size());
					int count = 0;
					for(it.csi.sigit.sigitwebn.xml.allegato5.data.RowFumiDocument.RowFumi dto : rigaFumi){
						log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO V count: "+count);

						try{ sigitTDettTipo4Dto.setETempAriaC(dto.getAETempAriaCombur());}catch (Exception e) {sigitTDettTipo4Dto.setETempAriaC(null);}

						try{ sigitTDettTipo4Dto.setETempH2oInC(dto.getAETempAriaIng());}catch (Exception e) {sigitTDettTipo4Dto.setETempH2oInC(null);}
						try{ sigitTDettTipo4Dto.setETempH2oOutC(dto.getAETempAriaUsc());}catch (Exception e) {sigitTDettTipo4Dto.setETempH2oOutC(null);}


						try{ sigitTDettTipo4Dto.setEPotenzaMorsettiKw(dto.getAEPotenzaMorsetti());}catch (Exception e) {sigitTDettTipo4Dto.setEPotenzaMorsettiKw(null);}
						try{ sigitTDettTipo4Dto.setETempH2oMotoreC(dto.getAETempH2Omotore());}catch (Exception e) {sigitTDettTipo4Dto.setETempH2oMotoreC(null);}
						try{ sigitTDettTipo4Dto.setETempFumiValleC(dto.getAETempFumiAvalle());}catch (Exception e) {sigitTDettTipo4Dto.setETempFumiValleC(null);}
						try{ sigitTDettTipo4Dto.setETempFumiMonteC(dto.getAETempFumiAmonte());}catch (Exception e) {sigitTDettTipo4Dto.setETempFumiMonteC(null);}

						/*
						try{ sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMin(dto.getAESovraFreqSoglia1());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMin(null);}
						try{ sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMed(dto.getAESovraFreqSoglia2());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMed(null);}
						try{ sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMax(dto.getAESovraFreqSoglia3());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMax(null);}

						try{ sigitTDettTipo4Dto.setL114SovrafreqTempoSMin(dto.getAESovraFreqTempo1());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovrafreqTempoSMin(null);}
						try{ sigitTDettTipo4Dto.setL114SovrafreqTempoSMed(dto.getAESovraFreqTempo2());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovrafreqTempoSMed(null);}
						try{ sigitTDettTipo4Dto.setL114SovrafreqTempoSMax(dto.getAESovraFreqTempo3());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovrafreqTempoSMax(null);}

						try{ sigitTDettTipo4Dto.setL114SottofreqSogliaHzMin(dto.getAESottoFreqSoglia1());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottofreqSogliaHzMin(null);}
						try{ sigitTDettTipo4Dto.setL114SottofreqSogliaHzMed(dto.getAESottoFreqSoglia2());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottofreqSogliaHzMed(null);}
						try{ sigitTDettTipo4Dto.setL114SottofreqSogliaHzMax(dto.getAESottoFreqSoglia3());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottofreqSogliaHzMax(null);}

						try{ sigitTDettTipo4Dto.setL114SottofreqTempoSMin(dto.getAESottoFreqTempo1());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottofreqTempoSMin(null);}
						try{ sigitTDettTipo4Dto.setL114SottofreqTempoSMed(dto.getAESottoFreqTempo2());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottofreqTempoSMed(null);}
						try{ sigitTDettTipo4Dto.setL114SottofreqTempoSMax(dto.getAESottoFreqTempo3());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottofreqTempoSMax(null);}

						try{ sigitTDettTipo4Dto.setL114SovratensSogliaVMin(dto.getAESovraTensSoglia1());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovratensSogliaVMin(null);}
						try{ sigitTDettTipo4Dto.setL114SovratensSogliaVMed(dto.getAESovraTensSoglia2());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovratensSogliaVMed(null);}
						try{ sigitTDettTipo4Dto.setL114SovratensSogliaVMax(dto.getAESovraTensSoglia3());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovratensSogliaVMax(null);}

						try{ sigitTDettTipo4Dto.setL114SovratensTempoSMin(dto.getAESovraTensTempo1());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovratensTempoSMin(null);}
						try{ sigitTDettTipo4Dto.setL114SovratensTempoSMed(dto.getAESovraTensTempo2());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovratensTempoSMed(null);}
						try{ sigitTDettTipo4Dto.setL114SovratensTempoSMax(dto.getAESovraTensTempo3());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovratensTempoSMax(null);}

						try{ sigitTDettTipo4Dto.setL114SottotensSogliaVMin(dto.getAESottoTensSoglia1());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottotensSogliaVMin(null);}
						try{ sigitTDettTipo4Dto.setL114SottotensSogliaVMed(dto.getAESottoTensSoglia2());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottotensSogliaVMed(null);}
						try{ sigitTDettTipo4Dto.setL114SottotensSogliaVMax(dto.getAESottoTensSoglia3());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottotensSogliaVMax(null);}

						try{ sigitTDettTipo4Dto.setL114SottotensTempoSMin(dto.getAESottoTensTempo1());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottotensTempoSMin(null);}
						try{ sigitTDettTipo4Dto.setL114SottotensTempoSMed(dto.getAESottoTensTempo2());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottotensTempoSMed(null);}
						try{ sigitTDettTipo4Dto.setL114SottotensTempoSMax(dto.getAESottoTensTempo3());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottotensTempoSMax(null);}
						*/

						//INSERISCO
						getDbMgr().getSigitTDettTipo4Dao().insert(sigitTDettTipo4Dto);

						count++;
					}
				}

				//devo tracciaare il fatto che sono entrata la prima volta
				flagControllo = true;
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END dentro il for");
			}

			log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] END --> INSERT SU sigit_t_DETT_tipo4");

			//adesso devo aggiornare la parte di libretto che e' dedicata esclusivamente all'allegato
			//mi trovo l'ultimo libretto aggiornato e creo una copia di questo sulla tabella
			//dopodiche' mi vado a richiamare il metodo che scrive il libretto e lo consolida

			SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
			//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
			recordLibretto.setCfRedattore(cfUtenteLoggato);
			recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
			recordLibretto.setUtenteUltMod(cfUtenteLoggato);
			recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
			//inserisco
			getDbMgr().inserisciLibretto(recordLibretto);

			log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] END --> INSERT SU sigit_t_libretto");
			//adesso eseguo i punti 4, 5, 6 dell'algoritmo A002_7 riferito al libretto
			this.creaPdfEConsolidaLibretto(utenteLoggato, impianto, codiceRea, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO);

		}catch(Exception e){
			log.error("eccezione salvaInfoDaXmlAllegato3 --> "+e.getMessage(),e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));

		}
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END");
	}

	public String getCodiceRea(Integer idPersonaGiuridica) throws ManagerException{
		log.debug("[SigitMgr::getCodiceRea] BEGIN");
		String value = null;
		//trovo il codice REA
		try {
			log.debug("[SigitMgr::getCodiceRea] FRAAAAAAAAAAAAAAA ID PERSONA GIURIDICA: "+idPersonaGiuridica);
			if(idPersonaGiuridica!=null){
				SigitTPersonaGiuridicaPk pk = new SigitTPersonaGiuridicaPk();
				pk.setIdPersonaGiuridica(ConvertUtil.convertToBigDecimal(idPersonaGiuridica));
				SigitTPersonaGiuridicaDto pg = getDbMgr().getSigitTPersonaGiuridicaDao().findByPrimaryKey(pk);
				if(GenericUtil.isNotNullOrEmpty(pg.getSiglaRea()) && GenericUtil.isNotNullOrEmpty(pg.getNumeroRea()))
				{
					value = pg.getSiglaRea()+"-"+pg.getNumeroRea();
				}
			}

			log.debug("[SigitMgr::getCodiceRea] FRAAAAAAAAAAAAAAA CODICE REA: "+value);
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[SigitMgr::getCodiceRea] END");
		return value;
	}

	private String getCodiceReaOld(String codiceImpianto, String tipoDocumento) throws ManagerException{
		log.debug("[SigitMgr::getCodiceRea] BEGIN");
		String value = null;
		//trovo il codice REA
		try {
			FiltroControlloInserisciAllegato dtoInput = new FiltroControlloInserisciAllegato();
			dtoInput.setIdTipoDocumento(ConvertUtil.convertToInteger(tipoDocumento));
			List<SigitRRuoloTipodocDto> rRuoloTipoDoc = getDbMgr().getSigitRRuoloTipodocDao().findVerificaAllegatoSelezionato(dtoInput);
			//ne trovo solo uno
			BigDecimal  idRuolo = null;
			BigDecimal idPersonaGiuridica = null;
			if(rRuoloTipoDoc!=null && rRuoloTipoDoc.size()>0){
				SigitRRuoloTipodocDto dett = rRuoloTipoDoc.get(0);
				idRuolo = dett.getIdRuolo();
			}
			log.debug("[SigitMgr::getCodiceRea] FRAAAAAAAAAAAAAAA ID RUOLO: "+idRuolo);
			if(idRuolo!=null){
				FiltroRicercaPfPg input = new FiltroRicercaPfPg();
				input.setCodiceImpianto(codiceImpianto);
				input.setIdRuolo(ConvertUtil.convertToString(idRuolo));
				//trovo la persona giuridica
				List<SigitRImpRuoloPfpgDto> rImpPfPg = getDbMgr().getSigitRImpRuoloPfpgDao().findAttiviByFilter(input);
				//ne devo trovare solo uno
				if(rImpPfPg!=null && rImpPfPg.size()>0){
					SigitRImpRuoloPfpgDto dto = rImpPfPg.get(0);
					idPersonaGiuridica = dto.getFkPersonaGiuridica();
				}

				log.debug("[SigitMgr::getCodiceRea] FRAAAAAAAAAAAAAAA ID PERSONA GIURIDICA: "+idPersonaGiuridica);
				if(idPersonaGiuridica!=null){
					SigitTPersonaGiuridicaPk pk = new SigitTPersonaGiuridicaPk();
					pk.setIdPersonaGiuridica(idPersonaGiuridica);
					SigitTPersonaGiuridicaDto pg = getDbMgr().getSigitTPersonaGiuridicaDao().findByPrimaryKey(pk);
					if(GenericUtil.isNotNullOrEmpty(pg.getSiglaRea()) && GenericUtil.isNotNullOrEmpty(pg.getNumeroRea()))
					{
						value = pg.getSiglaRea()+"-"+pg.getNumeroRea();
					}
				}
			}
			log.debug("[SigitMgr::getCodiceRea] FRAAAAAAAAAAAAAAA CODICE REA: "+value);
		}  catch (SigitRRuoloTipodocDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitRImpRuoloPfpgDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[SigitMgr::getCodiceRea] END");
		return value;
	}

	@Transactional
	public BigDecimal salvaAllegatoTrans(DettaglioAllegato allegato, UtenteLoggato utenteLoggato)throws ManagerException {
		log.debug("[SigitMgr::salvaAllegatoTrans] START");
		try {
			return salvaAllegato(allegato, utenteLoggato);
		}
		catch (ManagerException e) {

			log.debug("PRIMA DELLA TRANSAZIONALITA'");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.debug("DOPO LA TRANSAZIONALITA'");


			throw e;
		}
		finally
		{
			log.debug("[SigitMgr::salvaAllegatoTrans] END");
		}
	}


	public BigDecimal salvaAllegato(DettaglioAllegato allegato, UtenteLoggato utenteLoggato) throws ManagerException{
		log.debug("[SigitMgr::salvaAllegato] BEGIN");
		//byte[] xmlAllegato = model.getXmlContent();
		try {

			/*
			// Nel caso si arriva dalle ispezioni, bisogna assegnare un codice bollino "d'ufficio"
			if (allegato.getArrivoDa().equalsIgnoreCase(Constants.ARRIVO_DA_IMPIANTO_ISP))
			{
				BigDecimal numBollino = null;
				FiltroRicercaNumeriBollino input = new FiltroRicercaNumeriBollino();
				input.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
				input.setIdPersonaGiuridica(Constants.ID_PG_RUOLO_ISPETTORE);

				//so gia' chi e' l'impresa perche' ho l'idPersonaGiuridica, precarico la combo
				List<SigitTTransazioneBollByElencoNumeriBollinoByPersGiuridicaDto> listCodBollLIberi =
						this.getDbMgr().getSigitTTransazioneBollDao().findByElencoNumeriBollinoByPersGiuridica(input);

				if (listCodBollLIberi != null && listCodBollLIberi.size() > 0)
				{
					// Esisistono dei codici impianto liberi assegnati al ruolo ispettore
					numBollino = listCodBollLIberi.get(0).getNumeroBollino();
				}
				else
				{
					// NON esisistono dei codici impianto liberi assegnati al ruolo ispettore
					// devo inserirlo


					AcquistoBollini acquistoBoll = new AcquistoBollini();
					acquistoBoll.setCodiceFiscaleOp(utenteLoggato
							.getCodiceFiscale());
					acquistoBoll.setDataAcquisto(DateUtil.getDataCorrenteFormat());
					//metto a video in codice bollino 'RP'che viene passato al db come parametro
					//nel caso in cui viene passato l'oggetto AcquistoBollini
					acquistoBoll.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
					acquistoBoll.setIdInstallatore(Constants.ID_PG_RUOLO_ISPETTORE);


					ArrayList<AcquistoBolliniQuantita> acquistoBollList = settaPrezziBollino(acquistoBoll);
					acquistoBollList.get(0).setQuantita(Constants.NUM_BOLLINO_ISPETTORE);

					getDbMgr().salvaTransazione(acquistoBoll, acquistoBollList,
							null, utenteLoggato);

					// Recupero il numero bollino libero (appena inserito) assegnati al ruolo ispettore
					listCodBollLIberi =
							this.getDbMgr().getSigitTTransazioneBollDao().findByElencoNumeriBollinoByPersGiuridica(input);
					numBollino = listCodBollLIberi.get(0).getNumeroBollino();

				}


				allegato.setNumeroBollinoVerde(ConvertUtil.convertToString(numBollino));
			}
			*/




			BigDecimal numBollino = getDbMgr().salvaCodiceBollino();
			allegato.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
			allegato.setNumeroBollinoVerde(ConvertUtil.convertToString(numBollino));
			allegato.setCodiceBollino(MapDto.costruisciCodiceBollino(allegato.getSiglaBollino(),
					ConvertUtil.convertToBigDecimal(allegato.getNumeroBollinoVerde())));


//			if (allegato.getIdTipiCombustibile() != null && allegato.getIdTipiCombustibile().size() > 0)
//			{
//
//				String elencoCombustibili = MapDto.mapToElencoCombustibili(getDbMgr().getElencoCombustibileById(allegato.getIdTipiCombustibile()));
//
//				allegato.setElencoCombustibili(elencoCombustibili);
//
//			}

			log.debug("STAMPO ALLEGATO ID_APPARECCHIATURE: "+allegato.getIdApparecchiatureFunz());
			//String tipoComponente = null;
			List<SigitVSk4GtDto> listCompGtDettDto = null;
			List<SigitVSk4GfDto> listCompGfDettDto = null;
			List<SigitVSk4ScDto> listCompScDettDto = null;
			List<SigitVSk4CgDto> listCompCgDettDto = null;

			if (allegato.getIdApparecchiatureFunz() != null && allegato.getIdApparecchiatureFunz().size() > 0)
			{
				String elencoApparecchiature = null;
				String elencoCombustibili = null;
				//ArrayList<String> elencoCombustibiliList = null;

				if(Constants.ALLEGATO_TIPO_1.equals(allegato.getIdTipoAllegato()) || Constants.ALLEGATO_TIPO_1B.equals(allegato.getIdTipoAllegato()))
				{
					//tipoComponente = Constants.TIPO_COMPONENTE_GT;
					listCompGtDettDto = getDbMgr().getCompGtAttiviInDataProgressivi(allegato.getCodiceImpianto(), allegato.getDataControllo(), allegato.getIdApparecchiatureFunz());

					elencoCombustibili = MapDto.mapToElencoCombustibiliGt(listCompGtDettDto);
					elencoApparecchiature = MapDto.mapToElencoApparecchiatureGt(listCompGtDettDto);
				}

				if(Constants.ALLEGATO_TIPO_2.equals(allegato.getIdTipoAllegato()))
				{
					//tipoComponente = Constants.TIPO_COMPONENTE_GF;

					listCompGfDettDto = getDbMgr().getCompGfAttiviInDataProgressivi(allegato.getCodiceImpianto(), allegato.getDataControllo(), allegato.getIdApparecchiatureFunz());
					//elencoCombustibiliList = null;//GenericUtil.getElencoCombustibiliCompGf(listCompGfDettDto);
					elencoApparecchiature = MapDto.mapToElencoApparecchiatureGf(listCompGfDettDto);
				}

				if(Constants.ALLEGATO_TIPO_3.equals(allegato.getIdTipoAllegato()))
				{
					//tipoComponente = Constants.TIPO_COMPONENTE_SC;

					listCompScDettDto = getDbMgr().getCompScAttiviInDataProgressivi(allegato.getCodiceImpianto(), allegato.getDataControllo(), allegato.getIdApparecchiatureFunz());
					//elencoCombustibiliList = null;//GenericUtil.getElencoCombustibiliCompSc(listCompScDettDto);
					elencoApparecchiature = MapDto.mapToElencoApparecchiatureSc(listCompScDettDto);
				}

				if(Constants.ALLEGATO_TIPO_4.equals(allegato.getIdTipoAllegato()))
				{
					//tipoComponente = Constants.TIPO_COMPONENTE_CG;
					listCompCgDettDto = getDbMgr().getCompCgAttiviInDataProgressivi(allegato.getCodiceImpianto(), allegato.getDataControllo(), allegato.getIdApparecchiatureFunz());
					//elencoCombustibiliList = null;//GenericUtil.getElencoCombustibiliCompCg(listCompCgDettDto);
					elencoApparecchiature = MapDto.mapToElencoApparecchiatureCg(listCompCgDettDto);
				}

				allegato.setElencoApparecchiature(elencoApparecchiature);

//				if (elencoCombustibili != null)
//				{
//					elencoCombustibili = MapDto.mapToElencoCombustibili(elencoCombustibiliList);
//				}

				allegato.setElencoCombustibili(elencoCombustibili);
			}

			SigitTAllegatoDto dto = MapDto.mapToAllegatoDtoForInsert(allegato, Constants.ID_TIPO_MANUTENZIONE_REE);

			getDbMgr().inserisciAllegato(dto);


			log.debug("BEPPE - DEVO INSERIRE NELLA NUOVA TABELLA!!!!");
			Integer numMod = 0;
			if(Constants.ALLEGATO_TIPO_1.equals(allegato.getIdTipoAllegato()) || Constants.ALLEGATO_TIPO_1B.equals(allegato.getIdTipoAllegato()))
			{
				for (SigitVSk4GtDto sigitVSk4GtDto : listCompGtDettDto) {

					getDbMgr().inserisciRAllegatoCompGt(dto.getIdAllegato(), sigitVSk4GtDto);

					numMod = ConvertUtil.convertToInteger(sigitVSk4GtDto.getNModuli());

					if (numMod == null || numMod.intValue() == 0)
					{
						// Se non e' valorizzato inserisco comunque una prova fumi
						numMod = 1;
					}

					for (int i = 0; i < numMod; i++) {

						// inseriamo su dettTipo1 una prova fumi
						getDbMgr().inserisciTDettTipo1(dto.getIdAllegato(), sigitVSk4GtDto, (i+1), utenteLoggato
								.getCodiceFiscale());

					}

				}

				getDbMgr().inserisciTRappTipo1(dto.getIdAllegato());

			}
			else
			if(Constants.ALLEGATO_TIPO_2.equals(allegato.getIdTipoAllegato()))
			{
				for (SigitVSk4GfDto sigitVSk4GfDto : listCompGfDettDto) {

					getDbMgr().inserisciRAllegatoCompGf(dto.getIdAllegato(), sigitVSk4GfDto);

					numMod = ConvertUtil.convertToInteger(sigitVSk4GfDto.getNCircuiti());

					if (numMod == null || numMod.intValue() == 0)
					{
						numMod = 1;
					}

					for (int i = 0; i < numMod; i++) {

						// inseriamo su dettTipo1 una prova fumi
						getDbMgr().inserisciTDettTipo2(dto.getIdAllegato(), sigitVSk4GfDto, (i+1), utenteLoggato
								.getCodiceFiscale());

					}
				}

				 getDbMgr().inserisciTRappTipo2(dto.getIdAllegato());

			}
			else
			if(Constants.ALLEGATO_TIPO_3.equals(allegato.getIdTipoAllegato()))
			{
				for (SigitVSk4ScDto sigitVSk4ScDto : listCompScDettDto) {

					getDbMgr().inserisciRAllegatoCompSc(dto.getIdAllegato(), sigitVSk4ScDto);

					getDbMgr().inserisciTDettTipo3(dto.getIdAllegato(), sigitVSk4ScDto, utenteLoggato
							.getCodiceFiscale());

				}

				getDbMgr().inserisciTRappTipo3(dto.getIdAllegato());

			}
			else
			if(Constants.ALLEGATO_TIPO_4.equals(allegato.getIdTipoAllegato()))
			{
				for (SigitVSk4CgDto sigitVSk4CgDto : listCompCgDettDto) {

					getDbMgr().inserisciRAllegatoCompCg(dto.getIdAllegato(), sigitVSk4CgDto);

					// inseriamo su dettTipo1 una prova fumi
					getDbMgr().inserisciTDettTipo4(dto.getIdAllegato(), sigitVSk4CgDto, utenteLoggato
							.getCodiceFiscale());
				}

				getDbMgr().inserisciTRappTipo4(dto.getIdAllegato());

//				for (SigitVSk4CgDto sigitVSk4CgDto : listCompCgDettDto) {
//
//					getDbMgr().inserisciRAllegatoCompCg(dto.getIdAllegato(), sigitVSk4CgDto);
//
//				}

				// 	getDbMgr().inserisciTRappTipo4(dto.getIdAllegato());

			}

			log.debug("allegato.getIdCom4Manut(): "+allegato.getIdCom4Manut());

			SigitRComp4ManutAllDto comp4Manut = null;
			for (String fkManut : allegato.getIdCom4Manut())
			{
				log.debug("fkManut: "+fkManut);
				comp4Manut = new SigitRComp4ManutAllDto();
				comp4Manut.setIdRComp4Manut(ConvertUtil.convertToInteger(fkManut));
				comp4Manut.setIdAllegato(dto.getIdAllegato());
				// Devo inserire su sigit_r_comp4manut_all
				getDbMgr().getSigitRComp4ManutAllDao().insert(comp4Manut);

			}

			return dto.getIdAllegato();
		} catch (Exception e) {
			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally{
			log.debug("[SigitMgr::salvaAllegato] END");
		}
	}

	@Transactional
	public DettaglioManutenzione salvaManutenzioneTrans(DettaglioManutenzione allegato, UtenteLoggato utenteLoggato) throws ManagerException{
		log.debug("[SigitMgr::salvaManutenzioneTrans] BEGIN");
		//byte[] xmlAllegato = model.getXmlContent();
		try {


			log.debug("STAMPO ALLEGATO ID_APPARECCHIATURE: "+allegato.getIdApparecchiature());
			//String tipoComponente = null;
			List<SigitVSk4GtDto> listCompGtDettDto = null;
			List<SigitVSk4GfDto> listCompGfDettDto = null;
			List<SigitVSk4ScDto> listCompScDettDto = null;
			List<SigitVSk4CgDto> listCompCgDettDto = null;

			String elencoCombustibili = null;
			if (allegato.getIdApparecchiature() != null && allegato.getIdApparecchiature().size() > 0)
			{
				String elencoApparecchiature = null;
				//ArrayList<String> elencoCombustibiliList = null;

				if(Constants.MANUTENZIONE_GT == allegato.getIdTipoManut())
				{
					//tipoComponente = Constants.TIPO_COMPONENTE_GT;
					listCompGtDettDto = getDbMgr().getCompGtAttiviInDataProgressivi(allegato.getCodiceImpianto(), allegato.getDataManut(), allegato.getIdApparecchiature());

					elencoCombustibili = MapDto.mapToElencoCombustibiliGt(listCompGtDettDto);
					elencoApparecchiature = MapDto.mapToElencoApparecchiatureGt(listCompGtDettDto);
				}

				if(Constants.MANUTENZIONE_GF == allegato.getIdTipoManut())
				{
					//tipoComponente = Constants.TIPO_COMPONENTE_GF;

					listCompGfDettDto = getDbMgr().getCompGfAttiviInDataProgressivi(allegato.getCodiceImpianto(), allegato.getDataManut(), allegato.getIdApparecchiature());
					//elencoCombustibiliList = null;//GenericUtil.getElencoCombustibiliCompGf(listCompGfDettDto);
					elencoApparecchiature = MapDto.mapToElencoApparecchiatureGf(listCompGfDettDto);
				}

				if(Constants.MANUTENZIONE_SC == allegato.getIdTipoManut())
				{
					//tipoComponente = Constants.TIPO_COMPONENTE_SC;

					listCompScDettDto = getDbMgr().getCompScAttiviInDataProgressivi(allegato.getCodiceImpianto(), allegato.getDataManut(), allegato.getIdApparecchiature());
					//elencoCombustibiliList = null;//GenericUtil.getElencoCombustibiliCompSc(listCompScDettDto);
					elencoApparecchiature = MapDto.mapToElencoApparecchiatureSc(listCompScDettDto);
				}

				if(Constants.MANUTENZIONE_CG == allegato.getIdTipoManut())
				{
					//tipoComponente = Constants.TIPO_COMPONENTE_CG;
					listCompCgDettDto = getDbMgr().getCompCgAttiviInDataProgressivi(allegato.getCodiceImpianto(), allegato.getDataManut(), allegato.getIdApparecchiature());
					//elencoCombustibiliList = null;//GenericUtil.getElencoCombustibiliCompCg(listCompCgDettDto);
					elencoApparecchiature = MapDto.mapToElencoApparecchiatureCg(listCompCgDettDto);
				}

				allegato.setElencoApparecchiature(elencoApparecchiature);

//				if (elencoCombustibili != null)
//				{
//					elencoCombustibili = MapDto.mapToElencoCombustibili(elencoCombustibiliList);
//				}

				//allegato.setElencoCombustibili(elencoCombustibili);
			}

			SigitTAllegatoDto dto = MapDto.mapToAllegatoDto(allegato, elencoCombustibili, utenteLoggato.getCodiceFiscale());

			getDbMgr().inserisciAllegato(dto);


			BigDecimal idContratto = null;
			// qui setto l'idImpRuoloPfpg del responsabile
			BigDecimal idImpRuoloPfpg = null;

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			SigitVTotImpiantoDto responsabile = getDbMgr().cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(allegato.getCodiceImpianto()), ConvertUtil.convertToSqlDate(allegato.getDataManut()));

			if (responsabile != null)
			{
				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
			}

			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(allegato.getCodiceImpianto(), allegato.getDataManut());

			if(Constants.MANUTENZIONE_GT == allegato.getIdTipoManut())
			{
				for (SigitVSk4GtDto sigitVSk4GtDto : listCompGtDettDto) {

					if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
					{
						idContratto = list3RespAttiviImpianto.get(0).getIdContratto();
						getDbMgr().inserisciRAllegatoCompGtManut(dto.getIdAllegato(), sigitVSk4GtDto, null, idContratto);
					}
					else
					{
						getDbMgr().inserisciRAllegatoCompGtManut(dto.getIdAllegato(), sigitVSk4GtDto, idImpRuoloPfpg, null);
					}
				}
			}

			else if(Constants.MANUTENZIONE_GF == allegato.getIdTipoManut())
			{
				for (SigitVSk4GfDto sigitVSk4GfDto : listCompGfDettDto) {

					if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
					{
						idContratto = list3RespAttiviImpianto.get(0).getIdContratto();
						getDbMgr().inserisciRAllegatoCompGfManut(dto.getIdAllegato(), sigitVSk4GfDto, null, idContratto);
					}
					else
					{
						getDbMgr().inserisciRAllegatoCompGfManut(dto.getIdAllegato(), sigitVSk4GfDto, idImpRuoloPfpg, null);
					}

				}
			}
			else if(Constants.MANUTENZIONE_SC == allegato.getIdTipoManut())
			{
				for (SigitVSk4ScDto sigitVSk4ScDto : listCompScDettDto) {

					if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
					{
						idContratto = list3RespAttiviImpianto.get(0).getIdContratto();
						getDbMgr().inserisciRAllegatoCompScManut(dto.getIdAllegato(), sigitVSk4ScDto, null, idContratto);
					}
					else
					{
						getDbMgr().inserisciRAllegatoCompScManut(dto.getIdAllegato(), sigitVSk4ScDto, idImpRuoloPfpg, null);
					}

				}

			}
			else if(Constants.MANUTENZIONE_CG == allegato.getIdTipoManut())
			{
				for (SigitVSk4CgDto sigitVSk4CgDto : listCompCgDettDto) {

					if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
					{
						idContratto = list3RespAttiviImpianto.get(0).getIdContratto();
						getDbMgr().inserisciRAllegatoCompCgManut(dto.getIdAllegato(), sigitVSk4CgDto, null, idContratto);
					}
					else
					{
						getDbMgr().inserisciRAllegatoCompCgManut(dto.getIdAllegato(), sigitVSk4CgDto, idImpRuoloPfpg, null);
					}

				}

			}

			log.debug("allegato.getIdCom4Manut(): "+allegato.getIdCom4Manut());

			SigitRComp4ManutAllDto comp4Manut = null;
			for (String fkManut : allegato.getIdCom4Manut())
			{
				log.debug("fkManut: "+fkManut);
				comp4Manut = new SigitRComp4ManutAllDto();
				comp4Manut.setIdRComp4Manut(ConvertUtil.convertToInteger(fkManut));
				comp4Manut.setIdAllegato(dto.getIdAllegato());
				// Devo inserire su sigit_r_comp4manut_all
				getDbMgr().getSigitRComp4ManutAllDao().insert(comp4Manut);

			}

			allegato.setIdAllegato(ConvertUtil.convertToString(dto.getIdAllegato()));
			return allegato;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally{
			log.debug("[SigitMgr::salvaManutenzioneTrans] END");
		}
	}


	@Transactional
	public BigDecimal salvaAllegatoImport(DettaglioAllegato dettaglioAllegato,
			byte[] theXml, UtenteLoggato utenteLoggato) throws ManagerException{
		log.debug("[SigitMgr::salvaAllegato] BEGIN");
		//byte[] xmlAllegato = model.getXmlContent();
		try {

			// Riutilizzo il metodo usato da REE WEB, quindi mi crea la struttura vuota
			BigDecimal idAllegato = salvaAllegato(dettaglioAllegato, utenteLoggato);

			// Devo ciclare per ogni Allegato ed inserirlo
			dettaglioAllegato.setIdAllegato(ConvertUtil.convertToString(idAllegato));




			if(Constants.ALLEGATO_TIPO_1.equals(dettaglioAllegato.getIdTipoAllegato()))
			{
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument mod1Import = MapDto.mapToImportMODIIDocument(theXml);

				salvaAllegato1DaXml(dettaglioAllegato, mod1Import);
			}
			else if(Constants.ALLEGATO_TIPO_2.equals(dettaglioAllegato.getIdTipoAllegato()))
			{
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument mod2Import = MapDto.mapToImportMODIIIDocument(theXml);

				salvaAllegato2DaXml(dettaglioAllegato, mod2Import);
			}
			else if(Constants.ALLEGATO_TIPO_3.equals(dettaglioAllegato.getIdTipoAllegato()))
			{
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument mod3Import = MapDto.mapToImportMODIVDocument(theXml);

				salvaAllegato3DaXml(dettaglioAllegato, mod3Import);
			}
			else if(Constants.ALLEGATO_TIPO_4.equals(dettaglioAllegato.getIdTipoAllegato()))
			{
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument mod4Import = MapDto.mapToImportMODVDocument(theXml);

				salvaAllegato4DaXml(dettaglioAllegato, mod4Import);
			}


			/*
			getSigitTRappTipo1Dao().delete(new SigitTRappTipo1Pk(idAllegato));
			getSigitTRappTipo2Dao().delete(new SigitTRappTipo2Pk(idAllegato));
			getSigitTRappTipo3Dao().delete(new SigitTRappTipo3Pk(idAllegato));
			getSigitTRappTipo4Dao().delete(new SigitTRappTipo4Pk(idAllegato));

			getSigitTDettTipo1Dao().customDeleterByIdAllegato(idAllegato);
			getSigitTDettTipo2Dao().customDeleterByIdAllegato(idAllegato);
			getSigitTDettTipo3Dao().customDeleterByIdAllegato(idAllegato);
			getSigitTDettTipo4Dao().customDeleterByIdAllegato(idAllegato);

			 */

			return idAllegato;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally{
			log.debug("[SigitMgr::salvaAllegato] END");
		}
	}




	public void salvaAllegato1DaXml(DettaglioAllegato dettaglioAllegato, it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument mod1Import) throws ManagerException
	{
		try
		{
			SigitTAllegatoDto allegatoDto = getDbMgr().cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = mod1Import.getMODII().getRichiesta().getDatiAllegato().getDatiIdentificativi();

			allegatoDto.setAPotenzaTermicaNominaleMax(datiIdentificativi.getAAPotenzaTermicaNomTotMax());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = mod1Import.getMODII().getRichiesta().getDatiAllegato().getDocumentazioneTecnica();


			allegatoDto.setBFlgDichiarConform(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagDichiarazConf()));
			allegatoDto.setBFlgLibrettoUso(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagManutGen()));
			allegatoDto.setBFlgLibCompl(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoComp()));
			allegatoDto.setBFlgLibImp(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoImp()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.ControlloImpiantoDocument.ControlloImpianto importCi = mod1Import.getMODII().getRichiesta().getDatiAllegato().getControlloImpianto();

			SigitTRappTipo1Dto rapportoTipo1 = getDbMgr().cercaTRappTipo1ById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

			//sezione D.controllo dell'impianto
			rapportoTipo1.setDFlgLocaleIntIdoneo(new BigDecimal(importCi.getADFlagInterno()));
			rapportoTipo1.setDFlgGenExtIdoneo(new BigDecimal(importCi.getADFlagEsterno()));
			rapportoTipo1.setDFlgApertureLibere(new BigDecimal(importCi.getADFlagAperture()));

			rapportoTipo1.setDFlgApertureAdeg(new BigDecimal(importCi.getADFlagDimensioni()));
			rapportoTipo1.setDFlgScaricoIdoneo(new BigDecimal(importCi.getADFlagCanaleFumo()));
			rapportoTipo1.setDFlgTempAmbFunz(new BigDecimal(importCi.getADFlagSistRegolaz()));
			rapportoTipo1.setDFlgAssenzaPerdComb(new BigDecimal(importCi.getADFlagPerdite()));
			rapportoTipo1.setDFlgIdoTenImpInt(new BigDecimal(importCi.getADFlagTenuta()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod1Import.getMODII().getRichiesta().getDatiAllegato().getTrattamentoAcqua();

			rapportoTipo1.setCFlgTrattClimaNonRich(ConvertUtil.convertToBigDecimal(impTa.getACFlagTrattH2ONR()));
			rapportoTipo1.setCFlgTrattAcsNonRichiesto(ConvertUtil.convertToBigDecimal(impTa.getACFlagTrattAcsNR()));

			SigitTDettTipo1Dto sigitTDettTipo1Dto = new SigitTDettTipo1Dto();

			for(it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowAllegatoIIDocument.RowAllegatoII all : mod1Import.getMODII().getRichiesta().getDatiAllegato().getAllegatoII().getRowAllegatoIIList())
			{

				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica importCve = all.getControlloVerificaEnergetica();


				sigitTDettTipo1Dto.setEFlgClimaInverno(ConvertUtil.convertToBigDecimal(importCve.getAEFlagClimatizInv()));
				sigitTDettTipo1Dto.setEFlgProduzAcs(ConvertUtil.convertToBigDecimal(importCve.getAEFlagProduzACS()));

				sigitTDettTipo1Dto.setEFlgDisposComando(ConvertUtil.convertToBigDecimal(importCve.getAEFlagDispComando()));
				sigitTDettTipo1Dto.setEFlgDisposSicurezza(ConvertUtil.convertToBigDecimal(importCve.getAEFlagDispSicu()));

				sigitTDettTipo1Dto.setEFlgValvolaSicurezza(ConvertUtil.convertToBigDecimal(importCve.getAEFlagValvSicu()));
				sigitTDettTipo1Dto.setEFlgScambiatoreFumi(ConvertUtil.convertToBigDecimal(importCve.getAEFlagScambiatore()));
				sigitTDettTipo1Dto.setEFlgRiflusso(ConvertUtil.convertToBigDecimal(importCve.getAEFlagRiflusso()));
				sigitTDettTipo1Dto.setEFlgUni103891(ConvertUtil.convertToBigDecimal(importCve.getAEFlagRisultati()));


				sigitTDettTipo1Dto.setEPotTermFocolKw(importCve.getAEPotenzaFocolare());
				sigitTDettTipo1Dto.setEFlgEvacuFumi(importCve.getAEFlagEvacFumi().toString());

				sigitTDettTipo1Dto.setL111AltroRiferimento(importCve.getAEAltroRifNormativo());
				sigitTDettTipo1Dto.setEDeprCanaleFumoPa(importCve.getAEDepressCanaleFumo());

				sigitTDettTipo1Dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getCodiceImpianto()));
				sigitTDettTipo1Dto.setFkAllegato(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));
				sigitTDettTipo1Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
				sigitTDettTipo1Dto.setUtenteUltMod(dettaglioAllegato.getCodFiscaleUtenteLoggato());
				sigitTDettTipo1Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_GT);

				sigitTDettTipo1Dto.setProgressivo(ConvertUtil.convertToBigDecimal(all.getAENumGT()));

				getDbMgr().getSigitTDettTipo1Dao().customUpdaterAggiornaDatiComuni(sigitTDettTipo1Dto, null);

				for (it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowFumiDocument.RowFumi rowFumiImport : all.getTabFumi().getRowFumiList())
				{
					SigitTDettTipo1Dto sigitTDettTipo1DtoFind = getDbMgr().getDettTipo1(dettaglioAllegato.getCodiceImpianto(),
							ConvertUtil.convertToInteger(all.getAENumGT()), dettaglioAllegato.getIdAllegato(),
							ConvertUtil.convertToInteger(rowFumiImport.getAEModuloTermico()));

					// devo fare l'update di tutta la riga
					// setto la chiave
					//sigitTDettTipo1DtoFind.setIdDettTipo1(sigitTDettTipo1DtoFind.getIdDettTipo1());

					sigitTDettTipo1DtoFind.setETempFumiC(rowFumiImport.getAETempFumi());
					sigitTDettTipo1DtoFind.setETempAriaC(rowFumiImport.getAETempAria());
					sigitTDettTipo1DtoFind.setEO2Perc(rowFumiImport.getAEO2());
					sigitTDettTipo1DtoFind.setECo2Perc(rowFumiImport.getAECO2());
					sigitTDettTipo1DtoFind.setEBacharachMin(rowFumiImport.getAEBacharach1());
					sigitTDettTipo1DtoFind.setEBacharachMed(rowFumiImport.getAEBacharach2());
					sigitTDettTipo1DtoFind.setEBacharachMax(rowFumiImport.getAEBacharach3());
					sigitTDettTipo1DtoFind.setECoCorrettoPpm(rowFumiImport.getAECOcorretto());
					sigitTDettTipo1DtoFind.setERendCombPerc(rowFumiImport.getAERendimCombu());
					sigitTDettTipo1DtoFind.setERendMinLeggePerc(rowFumiImport.getAERendimentoLegge());
					sigitTDettTipo1DtoFind.setENoxMgKwh(rowFumiImport.getAENox());
					sigitTDettTipo1DtoFind.setENModuloTermico(ConvertUtil.convertToInteger(rowFumiImport.getAEModuloTermico()));
					sigitTDettTipo1DtoFind.setL111PortataCombustibileUm(rowFumiImport.getAEPortataCombu().toString());
					sigitTDettTipo1DtoFind.setL111PortataCombustibile(rowFumiImport.getAEValorePortata());
					sigitTDettTipo1DtoFind.setL111CoNoAriaPpm(rowFumiImport.getAECOfumiSecchi());
					sigitTDettTipo1DtoFind.setL111FlgRispettaBacharach(ConvertUtil.convertToBigDecimal(rowFumiImport.getAERispettoIndBacharach()));
					sigitTDettTipo1DtoFind.setL111FlgRendMagRendMin(ConvertUtil.convertToBigDecimal(rowFumiImport.getAEMinimo()));

					getDbMgr().getSigitTDettTipo1Dao().update(sigitTDettTipo1DtoFind);
				}

			}

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.CheckListDocument.CheckList importCheckList = mod1Import.getMODII().getRichiesta().getDatiAllegato().getCheckList();

			rapportoTipo1.setFFlgAdozioneValvoleTerm(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagValvole()));
			rapportoTipo1.setFFlgIsolamenteRete(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagIsolamento()));
			rapportoTipo1.setFFlgAdozSistTrattamH2o(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagSistTrattACS()));
			rapportoTipo1.setFFlgSostituzSistRegolaz(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagSistRegolaz()));

			if(GenericUtil.isNotNullOrEmpty(importCheckList.getAFOsservazioni())){
				allegatoDto.setFOsservazioni(importCheckList.getAFOsservazioni());
			}
			if(GenericUtil.isNotNullOrEmpty(importCheckList.getAFRaccomandazioni())){
				allegatoDto.setFRaccomandazioni(importCheckList.getAFRaccomandazioni());
			}
			if(GenericUtil.isNotNullOrEmpty(importCheckList.getAFPrescrizioni())){
				allegatoDto.setFPrescrizioni(importCheckList.getAFPrescrizioni());
			}

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiTecnicoDocument.DatiTecnico datiTecnico = mod1Import.getMODII().getRichiesta().getDatiAllegato().getDatiTecnico();

			allegatoDto.setFFlgPuoFunzionare(ConvertUtil.convertToBigDecimal(datiTecnico.getAFFlagFunzImp()));

			allegatoDto.setFInterventoEntro(ConvertUtil.convertToDate(datiTecnico.getAFDataIntervento()));

			allegatoDto.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
			allegatoDto.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
			allegatoDto.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));

			if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
				allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
				allegatoDto.setFFirmaTecnico(datiTecnico.getAFFirmaTecnico());
			}else{
				allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
			}
			log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
			if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
				allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
				allegatoDto.setFFirmaResponsabile(datiTecnico.getAFFirmaResp());
			}else{
				allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
			}

			getDbMgr().getSigitTRappTipo1Dao().update(rapportoTipo1);

			getDbMgr().aggiornaAllegato(allegatoDto);

		}
		catch (DaoException e)
		{
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
	}


	public void salvaAllegato2DaXml(DettaglioAllegato dettaglioAllegato, it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument mod2Import) throws ManagerException
	{
		try
		{
			SigitTAllegatoDto allegatoDto = getDbMgr().cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = mod2Import.getMODIII().getRichiesta().getDatiAllegato().getDatiIdentificativi();

			allegatoDto.setAPotenzaTermicaNominaleMax(datiIdentificativi.getAAPotenzaTermicaNomTotMax());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = mod2Import.getMODIII().getRichiesta().getDatiAllegato().getDocumentazioneTecnica();


			allegatoDto.setBFlgDichiarConform(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagDichiarazConf()));
			allegatoDto.setBFlgLibrettoUso(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagManutGen()));
			allegatoDto.setBFlgLibCompl(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoComp()));
			allegatoDto.setBFlgLibImp(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoImp()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.ControlloImpiantoDocument.ControlloImpianto importCi = mod2Import.getMODIII().getRichiesta().getDatiAllegato().getControlloImpianto();

			SigitTRappTipo2Dto rapportoTipo2 = getDbMgr().cercaTRappTipo2ById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

			//sezione D.controllo dell'impianto
			rapportoTipo2.setDFlgLocaleIdoneo(new BigDecimal(importCi.getADFlagLocaleIdoneo()));
			rapportoTipo2.setDFlgApertureAdeg(new BigDecimal(importCi.getADFlagDimensioni()));
			rapportoTipo2.setDFlgApertureLibere(new BigDecimal(importCi.getADFlagAperture()));

			rapportoTipo2.setDFlgLineaElettIdonea(new BigDecimal(importCi.getADFlagLineeIdonee()));
			rapportoTipo2.setDFlgCoibIdonea(new BigDecimal(importCi.getADFlagCoibenIdonee()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod2Import.getMODIII().getRichiesta().getDatiAllegato().getTrattamentoAcqua();

			rapportoTipo2.setCFlgTrattClimaNonRichiest(ConvertUtil.convertToBigDecimal(impTa.getACFlagTrattH2ONR()));

			SigitTDettTipo2Dto sigitTDettTipo2Dto = new SigitTDettTipo2Dto();

			for(it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII all : mod2Import.getMODIII().getRichiesta().getDatiAllegato().getAllegatoIII().getRowAllegatoIIIList())
			{

				log.debug("Entro nel dettaglio RowAllegatoIII");

				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica importCve = all.getControlloVerificaEnergetica();

				log.debug("Gestisco il importCve");
				if (log.isDebugEnabled())
					GenericUtil.stampa(importCve, true, 3);

				sigitTDettTipo2Dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getCodiceImpianto()));
				sigitTDettTipo2Dto.setFkAllegato(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));
				sigitTDettTipo2Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
				sigitTDettTipo2Dto.setUtenteUltMod(dettaglioAllegato.getCodFiscaleUtenteLoggato());
				sigitTDettTipo2Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_GF);
				sigitTDettTipo2Dto.setProgressivo(ConvertUtil.convertToBigDecimal(all.getAENumGF()));

				sigitTDettTipo2Dto.setEFlgModProva(importCve.getAEFlagModalita().toString());
				sigitTDettTipo2Dto.setEFlgPerditaGas(ConvertUtil.convertToBigDecimal(importCve.getAEFlagPerdite()));
				sigitTDettTipo2Dto.setEFlgLeakDetector(ConvertUtil.convertToBigDecimal(importCve.getAEFlagRilevFugheDiretta()));
				sigitTDettTipo2Dto.setEFlgParamTermodinam(ConvertUtil.convertToBigDecimal(importCve.getAEFlagRilevFugheInDiretta()));
				sigitTDettTipo2Dto.setEFlgIncrostazioni(ConvertUtil.convertToBigDecimal(importCve.getAEFlagScambPuliti()));

				log.debug("Gestisco l'aggiornamento di sigitTDettTipo2Dto.customUpdaterAggiornaDatiComuni");

				if (log.isDebugEnabled())
					GenericUtil.stampa(sigitTDettTipo2Dto, true, 3);

				getDbMgr().getSigitTDettTipo2Dao().customUpdaterAggiornaDatiComuni(sigitTDettTipo2Dto, null);

				for (it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowFumiDocument.RowFumi rowFumiImport : all.getTabFumi().getRowFumiList())
				{

					SigitTDettTipo2Dto sigitTDettTipo2DtoFind = getDbMgr().getDettTipo2(dettaglioAllegato.getCodiceImpianto(),
							ConvertUtil.convertToInteger(all.getAENumGF()), dettaglioAllegato.getIdAllegato(),
							ConvertUtil.convertToString(rowFumiImport.getAENumCircuito()));

					// devo fare l'update di tutta la riga
					// setto la chiave
					//sigitTDettTipo1DtoFind.setIdDettTipo1(sigitTDettTipo1DtoFind.getIdDettTipo1());

					sigitTDettTipo2DtoFind.setETSurriscC(rowFumiImport.getAESurrisc());
					sigitTDettTipo2DtoFind.setETSottorafC(rowFumiImport.getAESottoRaffr());
					sigitTDettTipo2DtoFind.setETCondensazioneC(rowFumiImport.getAECondens());
					sigitTDettTipo2DtoFind.setETEvaporazioneC(rowFumiImport.getAEEvaporaz());

					sigitTDettTipo2DtoFind.setETInExtC(rowFumiImport.getAEIngLatoEst());
					sigitTDettTipo2DtoFind.setETOutExtC(rowFumiImport.getAEUscLatoEst());

					sigitTDettTipo2DtoFind.setETInUtenzeC(rowFumiImport.getAEIngLatoUtenze());
					sigitTDettTipo2DtoFind.setETOutUtenzeC(rowFumiImport.getAEUscLatoUtenze());

					sigitTDettTipo2DtoFind.setL112TorreTOutFluido(rowFumiImport.getAETuscFluido());
					sigitTDettTipo2DtoFind.setL112TorreTBulboUmido(rowFumiImport.getAETbulboUmido());
					sigitTDettTipo2DtoFind.setL112ScambiatoreTInExt(rowFumiImport.getAETingFluidoSorg());
					sigitTDettTipo2DtoFind.setL112ScambiatoreTOutExt(rowFumiImport.getAETuscFluidoSorg());
					sigitTDettTipo2DtoFind.setL112ScambiatTInMacchina(rowFumiImport.getAETingFluidoMacc());
					sigitTDettTipo2DtoFind.setL112ScambiatTOutMacchina(rowFumiImport.getAETuscFluidoMacc());
					sigitTDettTipo2DtoFind.setL112PotenzaAssorbitaKw(rowFumiImport.getAEPotenzaAss());

					sigitTDettTipo2DtoFind.setL112FlgPuliziaFiltri(ConvertUtil.convertToBigDecimal(rowFumiImport.getAEFiltriPuliti()));
					sigitTDettTipo2DtoFind.setL112FlgVerificaSuperata(ConvertUtil.convertToBigDecimal(rowFumiImport.getAEVerifica()));

					// Beppe - correzione Jira SIGIT-597
					if (GenericUtil.isNotNullOrEmpty(rowFumiImport.getAEDataRipristino()))
					{
						sigitTDettTipo2DtoFind.setL112DataRipristino(DateUtil.getSqlDate(rowFumiImport.getAEDataRipristino()));
					}

					getDbMgr().getSigitTDettTipo2Dao().update(sigitTDettTipo2DtoFind);
				}

			}

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.CheckListDocument.CheckList importCheckList = mod2Import.getMODIII().getRichiesta().getDatiAllegato().getCheckList();

			rapportoTipo2.setFFlgSostituzGeneratori(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagSostGen1()));
			rapportoTipo2.setFFlgSostituzSistemiReg(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagSostGen2()));
			rapportoTipo2.setFFlgIsolDistribuzH2o(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagIsolamentoRete()));
			rapportoTipo2.setFFlgIsolDistribuzAria(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagIsolamentoCanali()));

			if(GenericUtil.isNotNullOrEmpty(importCheckList.getAFOsservazioni())){
				allegatoDto.setFOsservazioni(importCheckList.getAFOsservazioni());
			}
			if(GenericUtil.isNotNullOrEmpty(importCheckList.getAFRaccomandazioni())){
				allegatoDto.setFRaccomandazioni(importCheckList.getAFRaccomandazioni());
			}
			if(GenericUtil.isNotNullOrEmpty(importCheckList.getAFPrescrizioni())){
				allegatoDto.setFPrescrizioni(importCheckList.getAFPrescrizioni());
			}

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiTecnicoDocument.DatiTecnico datiTecnico = mod2Import.getMODIII().getRichiesta().getDatiAllegato().getDatiTecnico();

			allegatoDto.setFFlgPuoFunzionare(ConvertUtil.convertToBigDecimal(datiTecnico.getAFFlagFunzImp()));

			allegatoDto.setFInterventoEntro(ConvertUtil.convertToDate(datiTecnico.getAFDataIntervento()));

			allegatoDto.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
			allegatoDto.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
			allegatoDto.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));

			if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
				allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
				allegatoDto.setFFirmaTecnico(datiTecnico.getAFFirmaTecnico());
			}else{
				allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
			}
			log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
			if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
				allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
				allegatoDto.setFFirmaResponsabile(datiTecnico.getAFFirmaResp());
			}else{
				allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
			}

			getDbMgr().getSigitTRappTipo2Dao().update(rapportoTipo2);

			getDbMgr().aggiornaAllegato(allegatoDto);

		}
		catch (DaoException e)
		{
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
	}

	public void salvaAllegato3DaXml(DettaglioAllegato dettaglioAllegato, it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument mod3Import) throws ManagerException
	{
		try
		{
			SigitTAllegatoDto allegatoDto = getDbMgr().cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = mod3Import.getMODIV().getRichiesta().getDatiAllegato().getDatiIdentificativi();

			allegatoDto.setAPotenzaTermicaNominaleMax(datiIdentificativi.getAAPotenzaTermicaNomTotMax());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = mod3Import.getMODIV().getRichiesta().getDatiAllegato().getDocumentazioneTecnica();

			allegatoDto.setBFlgDichiarConform(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagDichiarazConf()));
			allegatoDto.setBFlgLibrettoUso(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagManutGen()));
			allegatoDto.setBFlgLibCompl(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoComp()));
			allegatoDto.setBFlgLibImp(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoImp()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.ControlloImpiantoDocument.ControlloImpianto importCi = mod3Import.getMODIV().getRichiesta().getDatiAllegato().getControlloImpianto();

			SigitTRappTipo3Dto rapportoTipo3 = getDbMgr().cercaTRappTipo3ById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

			//sezione D.controllo dell'impianto
			rapportoTipo3.setDFlgLocaleIdoneo(new BigDecimal(importCi.getADFlagLuogoIdoneo()));
			rapportoTipo3.setDFlgLineaElettIdonea(new BigDecimal(importCi.getADFlagLineeIdonee()));
			rapportoTipo3.setDFlgCoibIdonea(new BigDecimal(importCi.getADFlagStatoCoiben()));
			rapportoTipo3.setDFlgAssenzaPerdite(new BigDecimal(importCi.getADFlagPerdite()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod3Import.getMODIV().getRichiesta().getDatiAllegato().getTrattamentoAcqua();

			rapportoTipo3.setCFlgTrattClimaNonRichiest(ConvertUtil.convertToBigDecimal(impTa.getACFlagTrattH2ONR()));
			rapportoTipo3.setCFlgTrattAcsNonRichiesto(ConvertUtil.convertToBigDecimal(impTa.getACFlagTrattAcsNR()));


			//SigitTDettTipo1Dto sigitTDettTipo1Dto = new SigitTDettTipo1Dto();

			for(it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV all : mod3Import.getMODIV().getRichiesta().getDatiAllegato().getAllegatoIV().getRowAllegatoIVList())
			{

				List<SigitTDettTipo3Dto> sigitTDettTipo3DtoFindList = getDbMgr().getDettTipo3(dettaglioAllegato.getCodiceImpianto(),
						ConvertUtil.convertToInteger(all.getAENumSC()), dettaglioAllegato.getIdAllegato());

				SigitTDettTipo3Dto sigitTDettTipo3DtoFind = sigitTDettTipo3DtoFindList.get(0);

				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica importCve = all.getControlloVerificaEnergetica();

				sigitTDettTipo3DtoFind.setEFlgClimaInverno(ConvertUtil.convertToBigDecimal(importCve.getAEFlagClimatizInv()));
				sigitTDettTipo3DtoFind.setEFlgProduzAcs(ConvertUtil.convertToBigDecimal(importCve.getAEFlagProduzACS()));

				sigitTDettTipo3DtoFind.setFkFluidoAlimentaz(new BigDecimal(importCve.getAECombustibile()));
				sigitTDettTipo3DtoFind.setFkFluido(new BigDecimal(importCve.getAEFluidoVett()));

				sigitTDettTipo3DtoFind.setEFlgPotenzaCompatibile(ConvertUtil.convertToBigDecimal(importCve.getAEFlagPotComp()));
				sigitTDettTipo3DtoFind.setEFlgCoibIdonea(ConvertUtil.convertToBigDecimal(importCve.getAEFlagStatoCoiben()));
				sigitTDettTipo3DtoFind.setEFlgDispFunzionanti(ConvertUtil.convertToBigDecimal(importCve.getAEFlagDispReg()));

				/*
				sigitTDettTipo3DtoFind.setCodiceImpianto(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getCodiceImpianto()));
				sigitTDettTipo3DtoFind.setFkAllegato(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));
				sigitTDettTipo3DtoFind.setDataUltMod(DateUtil.getSqlDataCorrente());
				sigitTDettTipo3DtoFind.setUtenteUltMod(dettaglioAllegato.getCodFiscaleUtenteLoggato());
				sigitTDettTipo3DtoFind.setFkTipoComponente(Constants.TIPO_COMPONENTE_SC);

				sigitTDettTipo3DtoFind.setProgressivo(ConvertUtil.convertToBigDecimal(all.getAENumSC()));
				*/
				//getDbMgr().getSigitTDettTipo1Dao().customUpdaterAggiornaDatiComuni(sigitTDettTipo1Dto, null);

				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RowFumiDocument.RowFumi rowFumiImport = all.getTabFumi().getRowFumi();

				sigitTDettTipo3DtoFind.setETempExtC(rowFumiImport.getAETempEst());
				sigitTDettTipo3DtoFind.setETempMandPrimarioC(rowFumiImport.getAETempMandPrim());
				sigitTDettTipo3DtoFind.setETempRitorPrimarioC(rowFumiImport.getAETempRitPrim());
				sigitTDettTipo3DtoFind.setEPotenzaTermKw(rowFumiImport.getAEPotenzaTerm());
				sigitTDettTipo3DtoFind.setEPortFluidoM3H(rowFumiImport.getAEPortataFluido());
				sigitTDettTipo3DtoFind.setETempMandSecondarioC(rowFumiImport.getAETempMandSecond());
				sigitTDettTipo3DtoFind.setETempRitSecondarioC(rowFumiImport.getAETempRitSecond());


				getDbMgr().getSigitTDettTipo3Dao().update(sigitTDettTipo3DtoFind);


			}

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.CheckListDocument.CheckList importCheckList = mod3Import.getMODIV().getRichiesta().getDatiAllegato().getCheckList();

			rapportoTipo3.setFFlgValvoleTermost(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagValvole()));
			rapportoTipo3.setFFlgVerificaParam(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagCurvaClim()));
			rapportoTipo3.setFFlgPerditeH2o(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagPerditaH2O()));
			rapportoTipo3.setFFlgInstallInvolucro(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagInvolucro()));

			if(GenericUtil.isNotNullOrEmpty(importCheckList.getAFOsservazioni())){
				allegatoDto.setFOsservazioni(importCheckList.getAFOsservazioni());
			}
			if(GenericUtil.isNotNullOrEmpty(importCheckList.getAFRaccomandazioni())){
				allegatoDto.setFRaccomandazioni(importCheckList.getAFRaccomandazioni());
			}
			if(GenericUtil.isNotNullOrEmpty(importCheckList.getAFPrescrizioni())){
				allegatoDto.setFPrescrizioni(importCheckList.getAFPrescrizioni());
			}

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiTecnicoDocument.DatiTecnico datiTecnico = mod3Import.getMODIV().getRichiesta().getDatiAllegato().getDatiTecnico();

			allegatoDto.setFFlgPuoFunzionare(ConvertUtil.convertToBigDecimal(datiTecnico.getAFFlagFunzImp()));

			allegatoDto.setFInterventoEntro(ConvertUtil.convertToDate(datiTecnico.getAFDataIntervento()));

			allegatoDto.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
			allegatoDto.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
			allegatoDto.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));

			if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
				allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
				allegatoDto.setFFirmaTecnico(datiTecnico.getAFFirmaTecnico());
			}else{
				allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
			}
			log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
			if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
				allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
				allegatoDto.setFFirmaResponsabile(datiTecnico.getAFFirmaResp());
			}else{
				allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
			}

			getDbMgr().getSigitTRappTipo3Dao().update(rapportoTipo3);

			getDbMgr().aggiornaAllegato(allegatoDto);

		}
		catch (DaoException e)
		{
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
	}

	public void salvaAllegato4DaXml(DettaglioAllegato dettaglioAllegato, it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument mod4Import) throws ManagerException
	{
		try
		{
			SigitTAllegatoDto allegatoDto = getDbMgr().cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = mod4Import.getMODV().getRichiesta().getDatiAllegato().getDatiIdentificativi();

			allegatoDto.setAPotenzaTermicaNominaleMax(datiIdentificativi.getAAPotenzaTermicaNomTotMax());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = mod4Import.getMODV().getRichiesta().getDatiAllegato().getDocumentazioneTecnica();

			allegatoDto.setBFlgDichiarConform(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagDichiarazConf()));
			allegatoDto.setBFlgLibrettoUso(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagManutGen()));
			allegatoDto.setBFlgLibCompl(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoComp()));
			allegatoDto.setBFlgLibImp(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoImp()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.ControlloImpiantoDocument.ControlloImpianto importCi = mod4Import.getMODV().getRichiesta().getDatiAllegato().getControlloImpianto();

			SigitTRappTipo4Dto rapportoTipo4 = getDbMgr().cercaTRappTipo4ById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

			//sezione D.controllo dell'impianto
			rapportoTipo4.setDFlgLuogoIdoneo(new BigDecimal(importCi.getADFlagLuogoIdoneo()));
			rapportoTipo4.setDFlgVentilazAdeg(new BigDecimal(importCi.getADFlagDimensioni()));
			rapportoTipo4.setDFlgVentilazLibera(new BigDecimal(importCi.getADFlagAperture()));

			rapportoTipo4.setDFlgLineaElettIdonea(new BigDecimal(importCi.getADFlagLineeIdonee()));
			rapportoTipo4.setDFlgCaminoIdoneo(new BigDecimal(importCi.getADFlagCanaleFumo()));
			rapportoTipo4.setDFlgCapsulaIdonea(new BigDecimal(importCi.getADFlagCapsulaInso()));

			rapportoTipo4.setDFlgCircIdrIdoneo(new BigDecimal(importCi.getADFlagTenutaIdraulica()));
			rapportoTipo4.setDFlgCircOlioIdoneo(new BigDecimal(importCi.getADFlagTenutaOlio()));
			rapportoTipo4.setDFlgCircCombIdoneo(new BigDecimal(importCi.getADFlagTenutaAlimentaz()));
			rapportoTipo4.setDFlgFunzScambIdonea(new BigDecimal(importCi.getADFlagFunzionalita()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod4Import.getMODV().getRichiesta().getDatiAllegato().getTrattamentoAcqua();

			rapportoTipo4.setCFlgTrattClimaNonRichiest(ConvertUtil.convertToBigDecimal(impTa.getACFlagTrattH2ONR()));


			//SigitTDettTipo1Dto sigitTDettTipo1Dto = new SigitTDettTipo1Dto();

			for(it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RowAllegatoVDocument.RowAllegatoV all : mod4Import.getMODV().getRichiesta().getDatiAllegato().getAllegatoV().getRowAllegatoVList())
			{

				List<SigitTDettTipo4Dto> sigitTDettTipo3DtoFindList = getDbMgr().getDettTipo4(dettaglioAllegato.getCodiceImpianto(),
						ConvertUtil.convertToInteger(all.getAENumCG()), dettaglioAllegato.getIdAllegato());

				SigitTDettTipo4Dto sigitTDettTipo4DtoFind = sigitTDettTipo3DtoFindList.get(0);

				/*
				sigitTDettTipo4DtoFind.setCodiceImpianto(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getCodiceImpianto()));
				sigitTDettTipo4DtoFind.setFkAllegato(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));
				sigitTDettTipo4DtoFind.setDataUltMod(DateUtil.getSqlDataCorrente());
				sigitTDettTipo4DtoFind.setUtenteUltMod(dettaglioAllegato.getCodFiscaleUtenteLoggato());
				sigitTDettTipo4DtoFind.setFkTipoComponente(Constants.TIPO_COMPONENTE_CG);
				sigitTDettTipo4DtoFind.setProgressivo(ConvertUtil.convertToBigDecimal(all.getAENumCG()));
				*/
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica importCve = all.getControlloVerificaEnergetica();

				sigitTDettTipo4DtoFind.setFkFluido(new BigDecimal(importCve.getAEFluidoVett()));

				sigitTDettTipo4DtoFind.setEPotenzaAssorbCombKw(importCve.getAEPotenzaAssorbita());
				sigitTDettTipo4DtoFind.setEPotenzaTermBypassKw(importCve.getAEPotenzaTermByPass());

				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RowFumiDocument.RowFumi rowFumiImport = all.getTabFumi().getRowFumi();

				sigitTDettTipo4DtoFind.setETempAriaC(rowFumiImport.getAETempAriaCombur());

				sigitTDettTipo4DtoFind.setETempH2oInC(rowFumiImport.getAETempAcquaIng());
				sigitTDettTipo4DtoFind.setETempH2oOutC(rowFumiImport.getAETempAcquaUsc());

				sigitTDettTipo4DtoFind.setEPotenzaMorsettiKw(rowFumiImport.getAEPotenzaMorsetti());
				sigitTDettTipo4DtoFind.setETempH2oMotoreC(rowFumiImport.getAETempH2Omotore());
				sigitTDettTipo4DtoFind.setETempFumiValleC(rowFumiImport.getAETempFumiAvalle());
				sigitTDettTipo4DtoFind.setETempFumiMonteC(rowFumiImport.getAETempFumiAmonte());

				sigitTDettTipo4DtoFind.setL114SovrafreqSogliaHzMin(rowFumiImport.getAESovraFreqSoglia1());
				sigitTDettTipo4DtoFind.setL114SovrafreqSogliaHzMed(rowFumiImport.getAESovraFreqSoglia2());
				sigitTDettTipo4DtoFind.setL114SovrafreqSogliaHzMax(rowFumiImport.getAESovraFreqSoglia3());

				sigitTDettTipo4DtoFind.setL114SovrafreqTempoSMin(rowFumiImport.getAESovraFreqTempo1());
				sigitTDettTipo4DtoFind.setL114SovrafreqTempoSMed(rowFumiImport.getAESovraFreqTempo2());
				sigitTDettTipo4DtoFind.setL114SovrafreqTempoSMax(rowFumiImport.getAESovraFreqTempo3());

				sigitTDettTipo4DtoFind.setL114SottofreqSogliaHzMin(rowFumiImport.getAESottoFreqSoglia1());
				sigitTDettTipo4DtoFind.setL114SottofreqSogliaHzMed(rowFumiImport.getAESottoFreqSoglia2());
				sigitTDettTipo4DtoFind.setL114SottofreqSogliaHzMax(rowFumiImport.getAESottoFreqSoglia3());

				sigitTDettTipo4DtoFind.setL114SottofreqTempoSMin(rowFumiImport.getAESottoFreqTempo1());
				sigitTDettTipo4DtoFind.setL114SottofreqTempoSMed(rowFumiImport.getAESottoFreqTempo2());
				sigitTDettTipo4DtoFind.setL114SottofreqTempoSMax(rowFumiImport.getAESottoFreqTempo3());

				sigitTDettTipo4DtoFind.setL114SovratensSogliaVMin(rowFumiImport.getAESovraTensSoglia1());
				sigitTDettTipo4DtoFind.setL114SovratensSogliaVMed(rowFumiImport.getAESovraTensSoglia2());
				sigitTDettTipo4DtoFind.setL114SovratensSogliaVMax(rowFumiImport.getAESovraTensSoglia3());

				sigitTDettTipo4DtoFind.setL114SovratensTempoSMin(rowFumiImport.getAESovraTensTempo1());
				sigitTDettTipo4DtoFind.setL114SovratensTempoSMed(rowFumiImport.getAESovraTensTempo2());
				sigitTDettTipo4DtoFind.setL114SovratensTempoSMax(rowFumiImport.getAESovraTensTempo3());

				sigitTDettTipo4DtoFind.setL114SottotensSogliaVMin(rowFumiImport.getAESottoTensSoglia1());
				sigitTDettTipo4DtoFind.setL114SottotensSogliaVMed(rowFumiImport.getAESottoTensSoglia2());
				sigitTDettTipo4DtoFind.setL114SottotensSogliaVMax(rowFumiImport.getAESottoTensSoglia3());

				sigitTDettTipo4DtoFind.setL114SottotensTempoSMin(rowFumiImport.getAESottoTensTempo1());
				sigitTDettTipo4DtoFind.setL114SottotensTempoSMed(rowFumiImport.getAESottoTensTempo2());
				sigitTDettTipo4DtoFind.setL114SottotensTempoSMax(rowFumiImport.getAESottoTensTempo3());


				getDbMgr().getSigitTDettTipo4Dao().update(sigitTDettTipo4DtoFind);


			}

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.CheckListDocument.CheckList importCheckList = mod4Import.getMODV().getRichiesta().getDatiAllegato().getCheckList();

			rapportoTipo4.setFFlgAdozioneValvole(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagValvole()));
			rapportoTipo4.setFFlgIsolamentoRete(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagIsolamento()));
			rapportoTipo4.setFFlgSistemaTrattH2o(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagSistTrattACS()));
			rapportoTipo4.setFFlgSostSistemaRegolaz(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagSistRegolaz()));

			if(GenericUtil.isNotNullOrEmpty(importCheckList.getAFOsservazioni())){
				allegatoDto.setFOsservazioni(importCheckList.getAFOsservazioni());
			}
			if(GenericUtil.isNotNullOrEmpty(importCheckList.getAFRaccomandazioni())){
				allegatoDto.setFRaccomandazioni(importCheckList.getAFRaccomandazioni());
			}
			if(GenericUtil.isNotNullOrEmpty(importCheckList.getAFPrescrizioni())){
				allegatoDto.setFPrescrizioni(importCheckList.getAFPrescrizioni());
			}

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiTecnicoDocument.DatiTecnico datiTecnico = mod4Import.getMODV().getRichiesta().getDatiAllegato().getDatiTecnico();

			allegatoDto.setFFlgPuoFunzionare(ConvertUtil.convertToBigDecimal(datiTecnico.getAFFlagFunzImp()));

			allegatoDto.setFInterventoEntro(ConvertUtil.convertToDate(datiTecnico.getAFDataIntervento()));

			allegatoDto.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
			allegatoDto.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
			allegatoDto.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));

			if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
				allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
				allegatoDto.setFFirmaTecnico(datiTecnico.getAFFirmaTecnico());
			}else{
				allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
			}
			log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
			if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
				allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
				allegatoDto.setFFirmaResponsabile(datiTecnico.getAFFirmaResp());
			}else{
				allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
			}

			getDbMgr().getSigitTRappTipo4Dao().update(rapportoTipo4);

			getDbMgr().aggiornaAllegato(allegatoDto);

		}
		catch (DaoException e)
		{
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
	}

	@Transactional
	public BigDecimal salvaRapProva(DettaglioAllegato allegato, boolean isScannerizzato, ImportFileSuper fileUpload, UtenteLoggato utenteLoggato) throws ManagerException{
		log.debug("[SigitMgr::salvaRapProva] BEGIN");
		try {

			/*

			// 21/10/19 - Beppe - questa parte di codice era stata inserita quando i RapProva erano "uguali" ai REE adesso che vivono di vita propria non si setta piu' il bollino perche' non serve

			//Nel caso si arriva dalle ispezioni, bisogna assegnare un codice bollino "d'ufficio"
			if (allegato.getArrivoDa().equalsIgnoreCase(Constants.ARRIVO_DA_IMPIANTO_ISP))
			{
				BigDecimal numBollino = null;
				FiltroRicercaNumeriBollino input = new FiltroRicercaNumeriBollino();
				input.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
				input.setIdPersonaGiuridica(Constants.ID_PG_RUOLO_ISPETTORE);

				//so gia' chi e' l'impresa perche' ho l'idPersonaGiuridica, precarico la combo
				List<SigitTTransazioneBollByElencoNumeriBollinoByPersGiuridicaDto> listCodBollLIberi =
						this.getDbMgr().getSigitTTransazioneBollDao().findByElencoNumeriBollinoByPersGiuridica(input);

				if (listCodBollLIberi != null && listCodBollLIberi.size() > 0)
				{
					// Esisistono dei codici impianto liberi assegnati al ruolo ispettore
					numBollino = listCodBollLIberi.get(0).getNumeroBollino();
				}
				else
				{
					// NON esisistono dei codici impianto liberi assegnati al ruolo ispettore
					// devo inserirlo


					AcquistoBollini acquistoBoll = new AcquistoBollini();
					acquistoBoll.setCodiceFiscaleOp(utenteLoggato
							.getCodiceFiscale());
					acquistoBoll.setDataAcquisto(DateUtil.getDataCorrenteFormat());
					//metto a video in codice bollino 'RP'che viene passato al db come parametro
					//nel caso in cui viene passato l'oggetto AcquistoBollini
					acquistoBoll.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
					acquistoBoll.setIdInstallatore(Constants.ID_PG_RUOLO_ISPETTORE);


					ArrayList<AcquistoBolliniQuantita> acquistoBollList = settaPrezziBollino(acquistoBoll);
					acquistoBollList.get(0).setQuantita(Constants.NUM_BOLLINO_ISPETTORE);

					getDbMgr().salvaTransazione(acquistoBoll, acquistoBollList,
							null, utenteLoggato);

					// Recupero il numero bollino libero (appena inserito) assegnati al ruolo ispettore
					listCodBollLIberi =
							this.getDbMgr().getSigitTTransazioneBollDao().findByElencoNumeriBollinoByPersGiuridica(input);
					numBollino = listCodBollLIberi.get(0).getNumeroBollino();

				}


				allegato.setNumeroBollinoVerde(ConvertUtil.convertToString(numBollino));
			}
			*/



			log.debug("STAMPO ALLEGATO ID_APPARECCHIATURE: "+allegato.getIdApparecchiature());
			List<SigitVSk4GtDto> listCompGtDettDto = null;
			List<SigitVSk4GfDto> listCompGfDettDto = null;
			boolean componentiGt = Constants.ALLEGATO_TIPO_1.equals(allegato.getIdTipoAllegato()) || Constants.ALLEGATO_TIPO_1B.equals(allegato.getIdTipoAllegato()) || Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(allegato.getIdTipoAllegato());
			boolean componentiGf = Constants.ALLEGATO_TIPO_2.equals(allegato.getIdTipoAllegato()) || Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equals(allegato.getIdTipoAllegato());

			if (allegato.getIdApparecchiatureFunz() != null && allegato.getIdApparecchiatureFunz().size() > 0)
			{
				String elencoApparecchiature = null;
				String elencoCombustibili = null;

				if(componentiGt)
				{
					listCompGtDettDto = getDbMgr().getCompGtAttiviInDataProgressivi(allegato.getCodiceImpianto(), allegato.getDataControllo(), allegato.getIdApparecchiatureFunz());

					elencoCombustibili = MapDto.mapToElencoCombustibiliGt(listCompGtDettDto);
					elencoApparecchiature = MapDto.mapToElencoApparecchiatureGt(listCompGtDettDto);
				}

				if(componentiGf)
				{
					listCompGfDettDto = getDbMgr().getCompGfAttiviInDataProgressivi(allegato.getCodiceImpianto(), allegato.getDataControllo(), allegato.getIdApparecchiatureFunz());
					elencoApparecchiature = MapDto.mapToElencoApparecchiatureGf(listCompGfDettDto);
				}

				allegato.setElencoApparecchiature(elencoApparecchiature);

				allegato.setElencoCombustibili(elencoCombustibili);
			}

			SigitTAllegatoDto allegatoDto = MapDto.mapToAllegatoDtoForInsert(allegato, Constants.ID_TIPO_MANUTENZIONE_NESSUNA);

			BigDecimal idAllegato = getDbMgr().inserisciAllegato(allegatoDto); //inserimento in sigit_t_allegato


			String uid = null;
			if (isScannerizzato)
			{
				allegatoDto.setIdAllegato(idAllegato);

				//recupero l'impianto associato all'allegato
				SigitTImpiantoDto impiantoDto = getDbMgr().getSigitTImpiantoDao().findByPrimaryKey(new SigitTImpiantoPk(new BigDecimal(allegato.getCodiceImpianto())));

				String nomeAllegato = getNomeAllegato(allegatoDto.getFkTipoDocumento(),
						new BigDecimal(allegato.getCodiceImpianto()), allegatoDto.getDataControllo(), allegatoDto.getIdAllegato());

				Metadati metadati = MapDto.mapMetadatiAllegati(impiantoDto, allegatoDto, Constants.COD_REA_ISPETTORE);

				// Carico il file scannerizzato su INDEX
				uid = getServiziMgr().caricaFileIndex(fileUpload, Constants.INDEX_FOLDER_ISPEZIONI, nomeAllegato, metadati);

				allegatoDto.setDataInvio(DateUtil.getSqlCurrentDate());
				allegatoDto.setNomeAllegato(nomeAllegato);
				//dto.setFkStatoRapp(new BigDecimal(Constants.ID_STATO_RAPPORTO_INVIATO));
				if(uid!=null)
					allegatoDto.setUidIndex(uid);

				getDbMgr().getSigitTAllegatoDao().update(allegatoDto);

			}


			log.debug("RAP PROVA - DEVO INSERIRE NELLA NUOVA TABELLA!!!!");
			if(componentiGt)
			{
				getDbMgr().inserisciTRappIspezGt(idAllegato, utenteLoggato.getCodiceFiscale());

				//per ogni componente viene fatto l'inserimento in sigit_r_allegato_comp_gt + sigit_t_det_ispez_gt
				Integer numMod = 0;
				for (SigitVSk4GtDto sigitVSk4GtDto : listCompGtDettDto) {
					numMod = ConvertUtil.convertToInteger(sigitVSk4GtDto.getNModuli());

					getDbMgr().inserisciRAllegatoCompGt(idAllegato, sigitVSk4GtDto);
					if (numMod == null || numMod.intValue() == 0)
					{
						// Se non e' valorizzato inserisco comunque una prova fumi
						numMod = 1;
					}

					for (int i = 0; i < numMod; i++) {
						getDbMgr().inserisciTDettIspezGt(idAllegato, sigitVSk4GtDto, utenteLoggato
								.getCodiceFiscale(), (i+1));
					}

				}
			}
			else if(componentiGf)
			{
				getDbMgr().inserisciTRappIspezGf(idAllegato, utenteLoggato.getCodiceFiscale());
				//per ogni componente viene fatto l'inserimento in sigit_r_allegato_comp_gf + sigit_t_det_ispez_gf

				Integer numCirc = 0;
				for (SigitVSk4GfDto sigitVSk4GfDto : listCompGfDettDto) {
					getDbMgr().inserisciRAllegatoCompGf(idAllegato, sigitVSk4GfDto);

					numCirc = ConvertUtil.convertToInteger(sigitVSk4GfDto.getNCircuiti());

					if (numCirc == null || numCirc.intValue() == 0)
					{
						numCirc = 1;
					}

					for (int i = 0; i < numCirc; i++) {
						getDbMgr().inserisciTDettIspezGf(idAllegato, sigitVSk4GfDto, utenteLoggato.getCodiceFiscale(), (i+1));
					}
				}

			}

			return idAllegato;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally{
			log.debug("[SigitMgr::salvaRapProva] END");
		}
	}


	public DettaglioAllegato gestisciAllegatoById(Integer idAllegato) throws ManagerException{
		log.debug("[SigitMgr::gestisciAllegatoById] BEGIN");

		try {
			DettaglioAllegato dett =  null;

			//SigitTAllegatoDto allegatoDto = getDbMgr().cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(idAllegato));
			SigitVRicercaAllegatiDto allegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(ConvertUtil.convertToString(idAllegato));

			String idTipoAllegato = ConvertUtil.convertToString(allegato.getFkTipoDocumento());

			String elencoApparecchiature = null;
			ArrayList<String> progressivi = null;
			if(Constants.ALLEGATO_TIPO_1.equals(idTipoAllegato) || Constants.ALLEGATO_TIPO_1B.equals(idTipoAllegato) || Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(idTipoAllegato) )
			{

				//xxx
				// Per l'allegato TIPO 1 uso il metodo nuovo

				// Per sicurezza vado a cercare i le singole componenti
				/*
				List<SigitRAllegatoCompGtDto> compGt = getDbMgr().getSigitRAllegatoCompGtDao().findByIdAllegatoGt(idAllegato);

				for (SigitRAllegatoCompGtDto sigitRAllegatoCompGtDto : compGt) {

					progressivi.add(ConvertUtil.convertToString(sigitRAllegatoCompGtDto.getProgressivo()));
				}
				*/
				//CompFilter filter = new CompFilter(ConvertUtil.convertToString(allegato.getCodiceImpianto()), progressivi, allegato.getDataInvio()Controllo());

				List<SigitVCompGtDto> gtList = getDbMgr().getSigitVCompGtDao().findByIdAllegatoOrdered(idAllegato);
				elencoApparecchiature = MapDto.mapToElencoComponentiGt(gtList);
				progressivi = MapDto.mapToElencoProgressiviGt(gtList);
				//vado a mappare l'oggetto che mi interessa
				//dett = MapDto.mapToDettaglioAllegatoRee(allegato, progressivi, elencoApparecchiature);

			} else if (Constants.ALLEGATO_TIPO_2.equals(idTipoAllegato) || Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equals(idTipoAllegato)) {

				List<SigitVSk4GfDto> gfList = getDbMgr().getSigitVSk4GfDao().findByIdAllegato(idAllegato);
				elencoApparecchiature = MapDto.mapToElencoApparecchiatureGf(gfList);
				progressivi = MapDto.mapToElencoProgressiviGf(gfList);
				//dett = MapDto.mapToDettaglioAllegatoRee(allegato, progressivi, elencoApparecchiature);

			} else if (Constants.ALLEGATO_TIPO_3.equals(idTipoAllegato)) {
				List<SigitVSk4ScDto> scList = getDbMgr().getSigitVSk4ScDao().findByIdAllegato(idAllegato);
				elencoApparecchiature = MapDto.mapToElencoApparecchiatureSc(scList);
				progressivi = MapDto.mapToElencoProgressiviSc(scList);
				//dett = MapDto.mapToDettaglioAllegatoRee(allegato, progressivi, elencoApparecchiature);
			} else if (Constants.ALLEGATO_TIPO_4.equals(idTipoAllegato)){

				List<SigitVCompCgDto> gtList = getDbMgr().getSigitVCompCgDao().findByIdAllegatoOrdered(idAllegato);
				elencoApparecchiature = MapDto.mapToElencoComponentiCg(gtList);
				progressivi = MapDto.mapToElencoProgressiviCg(gtList);

			}
			//vado a mappare l'oggetto che mi interessa
			dett = MapDto.mapToDettaglioAllegatoRee(allegato, progressivi, elencoApparecchiature);


			return dett;

		} catch (Exception e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally{
			log.debug("[SigitMgr::gestisciAllegatoById] END");
		}
	}

	/*
	public DettaglioManutenzione gestisciManutenzioneById(Integer idAllegato) throws ManagerException{
		log.debug("[SigitMgr::gestisciAllegatoById] BEGIN");

		try {
			DettaglioManutenzione dett =  null;

			//SigitTAllegatoDto allegatoDto = getDbMgr().cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(idAllegato));
			SigitVRicercaAllegatiDto allegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(ConvertUtil.convertToString(idAllegato));

			String idTipoAllegato = ConvertUtil.convertToString(allegato.getFkTipoDocumento());

			String elencoApparecchiature = null;
			ArrayList<String> progressivi = null;
			if(Constants.ALLEGATO_TIPO_1.equals(idTipoAllegato))
			{

				List<SigitVCompGtDto> gtList = getDbMgr().getSigitVCompGtDao().findByIdAllegatoOrdered(idAllegato);
				elencoApparecchiature = MapDto.mapToElencoComponentiGt(gtList);
				progressivi = MapDto.mapToElencoProgressiviGt(gtList);
				//vado a mappare l'oggetto che mi interessa
				//dett = MapDto.mapToDettaglioAllegatoRee(allegato, progressivi, elencoApparecchiature);

			} else if (Constants.ALLEGATO_TIPO_2.equals(idTipoAllegato)) {

				List<SigitVSk4GfDto> gfList = getDbMgr().getSigitVSk4GfDao().findByIdAllegato(idAllegato);
				elencoApparecchiature = MapDto.mapToElencoApparecchiatureGf(gfList);
				progressivi = MapDto.mapToElencoProgressiviGf(gfList);
				//dett = MapDto.mapToDettaglioAllegatoRee(allegato, progressivi, elencoApparecchiature);

			} else if (Constants.ALLEGATO_TIPO_3.equals(idTipoAllegato)) {
				List<SigitVSk4ScDto> scList = getDbMgr().getSigitVSk4ScDao().findByIdAllegato(idAllegato);
				elencoApparecchiature = MapDto.mapToElencoApparecchiatureSc(scList);
				progressivi = MapDto.mapToElencoProgressiviSc(scList);
				//dett = MapDto.mapToDettaglioAllegatoRee(allegato, progressivi, elencoApparecchiature);
			} else if (Constants.ALLEGATO_TIPO_4.equals(idTipoAllegato)){

				List<SigitVCompCgDto> gtList = getDbMgr().getSigitVCompCgDao().findByIdAllegatoOrdered(idAllegato);
				elencoApparecchiature = MapDto.mapToElencoComponentiCg(gtList);
				progressivi = MapDto.mapToElencoProgressiviCg(gtList);

			}
			//vado a mappare l'oggetto che mi interessa
			dett = MapDto.mapToDettaglioManutenzione(allegato, progressivi, elencoApparecchiature);


			return dett;

		} catch (Exception e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally{
			log.debug("[SigitMgr::gestisciAllegatoById] END");
		}
	}
	*/

//	public BigDecimal salvaIspezione(DettaglioIspezione ispezione, String cfUtenteLoggato) throws ManagerException{
//		log.debug("[SigitMgr::salvaIspezione] BEGIN");
//		SigitTIspezionePk pk = null;
//		try {
//
//			pk = getDbMgr().inserisciIspezione(ispezione, cfUtenteLoggato);
//			return pk.getIdImpRuoloPfpg();
//
//		} catch (Exception e) {
//
//			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
//		}
//		finally{
//			log.debug("[SigitMgr::salvaIspezione] END");
//		}
//	}
//
//	public void modificaIspezione(DettaglioIspezione ispezione, String cfUtenteLoggato) throws ManagerException{
//		log.debug("[SigitMgr::modificaIspezione] BEGIN");
//		SigitTIspezionePk pk = null;
//		try {
//
//			getDbMgr().modificaIspezione(ispezione, cfUtenteLoggato);
//
//		} catch (Exception e) {
//
//			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
//		}
//		finally{
//			log.debug("[SigitMgr::modificaIspezione] END");
//		}
//	}

	public void inserisciXmlAllegato(BigDecimal idAllegato, byte[] xmlAllegato) throws ManagerException{
		log.debug("[SigitMgr::inserisciXmlAllegato] BEGIN");

		try {

			String datiXmlSt = XmlBeanUtils.readByteArray(xmlAllegato);

			// Non esiste il file allegato
			getDbMgr().insertAllTxtAllegato(idAllegato, datiXmlSt);

		} catch (Exception e) {
			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		log.debug("[SigitMgr::inserisciXmlAllegato] END");
	}

	public void updateAllegato(BigDecimal idAllegato, byte[] xmlAllegato, boolean isControllato, String cfUtente) throws ManagerException{
		log.debug("[SigitMgr::salvaAllegato] BEGIN");
		SigitTAllegatoDto dto = getDbMgr().cercaSigitTAllegatoById(idAllegato);
		//dto.setXmlAllegato(xmlAllegato);
		dto.setUtenteUltMod(cfUtente);
		dto.setDataUltMod(DateUtil.getSqlDataCorrente());
		dto.setFlgControlloBozza(ConvertUtil.convertToBigDecimal(isControllato));

		try {
			String datiXmlSt = XmlBeanUtils.readByteArray(xmlAllegato);

			getDbMgr().aggiornaAllegato(dto);

			// esiste il file allegato
			getDbMgr().updateAllTxtAllegato(idAllegato, datiXmlSt);

			/*
			if (getDbMgr().getAllTxtAllegato(ConvertUtil.convertToBigDecimal(idAllegato)) != null)
			{
				// Non esiste il file allegato
				getDbMgr().insertAllTxtAllegato(idAllegato, datiXmlSt);

			}
			else
			{
				// esiste il file allegato
				getDbMgr().updateAllTxtAllegato(idAllegato, datiXmlSt);
			}
			*/
		} catch (Exception e) {
			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		log.debug("[SigitMgr::salvaAllegato] END");
	}

	/*
	public void updateXmlAllegato(String idAllegato, byte[] xmlAllegato, String cfUtente) throws ManagerException{
		log.debug("[SigitMgr::salvaAllegato] BEGIN");

		SigitTAllegatoDto dto = getDbMgr().cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(idAllegato));

		GenericUtil.stampa(dto, true, 3);

		dto.setXmlAllegato(xmlAllegato);
		dto.setUtenteUltMod(cfUtente);
		dto.setDataUltMod(DateUtil.getSqlDataCorrente());
		try {
			getDbMgr().aggiornaAllegato(dto);
		} catch (Exception e) {
			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		log.debug("[SigitMgr::salvaAllegato] END");
	}
	*/
	/*
	@Transactional
	public void inviaIspezioneOLD(DettaglioAllegato dettaglio, String cfUtenteLoggato)throws ManagerException {
		log.debug("[SigitMgr::inviaIspezione] START");
		SigitTAllegatoDto allegatoDto = null;
		SigitTAllTxtDto fileAllegatoDto = null;
		SigitTImpiantoDto impiantoDto = null;
		String uid = null;
		String codiceRea = null;
		MODIIDocument mod1 = null;
		MODIIIDocument mod2 = null;
		MODIVDocument mod3 = null;
		MODVDocument mod4 = null;
		try {

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));
			//recupero l'impianto associato all'allegato
			impiantoDto = getDbMgr().getSigitTImpiantoDao().findByPrimaryKey(pkImpianto );

			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(ConvertUtil.convertToBigDecimal(dettaglio.getIdAllegato()));
			//devo caricare l'oggetto Allegato dal DB perche' devo ottenere l'xml dell'allegato
			allegatoDto = getDbMgr().getSigitTAllegatoDao().findByPrimaryKey(pk);

			fileAllegatoDto = getDbMgr().getAllTxtAllegato(pk.getIdAllegato());

			//recupero l'allegato xml
			byte[] allegato = XmlBeanUtils.readString(fileAllegatoDto.getXmlAllegato());

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 1 STEP ");

			if(allegato!=null)
				log.debug("FRAAAAAAAAAAAAAAAAAAAA xml lunghezza:  "+allegato.length);

			//Parte comune a tutti i tipi di allegati, serve per istanziare un nuovo document da andare a popolare con i dati
			//aggiornati dal documento ottenuto utilizzando i dati dal db
			Applicazione app = new Applicazione();
			XmlModel xmlModel = new XmlModel();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);

			//vado a discernere quale allegato scegliere dall'fkTipoDocumento
			String tipoDocumento = GenericUtil.getModelloModolAllegato(allegatoDto.getFkTipoDocumento().toString());
			Modulo modulo = getServiziMgr().cercaModulo(app, tipoDocumento);
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 1.2 STEP  allegatoDto.getFkTipoDocumento(): "+allegatoDto.getFkTipoDocumento());

			if (log.isDebugEnabled())
				log.debug("FRAAAAAAAAAAAAAAAAAAAA 1.3 STEP  modulo: "+modulo);

			//recupero l'oggetto che mi viene formattato dalla libreria di modol
			if(Constants.ALLEGATO_TIPO_1.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				mod1 = MapDto.mapToMODIIDocument(allegato);
				log.debug("FRAAAAAAAAAAAAAAAAAAAA 2 STEP ");
				//ho il documento con i valori che sono presenti sull'xml, che in parte devo aggiornare
				//con quelli che si trovano sul db, devo richiamre un metodo che mi aggiorni i valori da sostituire
				MODIIDocument moduloAggiornato = getDbMgr().getModuloAllegatoTipo1(mod1, dettaglio, true);
				//ribaltare i dati della prima pagina (i flag), alle altre pagine
				MapDto.mappaturaDatiAllegatoTipo1(moduloAggiornato);
				log.debug("FRAAAAAAAAAAAAAAAAAAAA 3 STEP ");
				//il moduloAggiornato deve essere ristrasformato in formato byteArray, ne creo uno nuovo passandogli il moduloAggiornato
				log.debug("FRAAAAAAAAAAAAAAAAAAAA 4 STEP ");
				xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(moduloAggiornato));
				log.debug("FRAAAAAAAAAAAAAAAAAAAA 5 STEP ");
				//trovo il codice REA
				codiceRea = this.getCodiceReaOld(dettaglio.getCodiceImpianto(), Constants.ALLEGATO_TIPO_1);
			}else if(Constants.ALLEGATO_TIPO_2.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				mod2 = MapDto.mapToMODIIIDocument(allegato);
				MODIIIDocument moduloAggiornato2 = getDbMgr().getModuloAllegatoTipo2(mod2, dettaglio, true);
				MapDto.mappaturaDatiAllegatoTipo2(mod2);
				xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(moduloAggiornato2));
				codiceRea = this.getCodiceReaOld(dettaglio.getCodiceImpianto(), Constants.ALLEGATO_TIPO_2);
			}else if(Constants.ALLEGATO_TIPO_3.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				mod3 = MapDto.mapToMODIVDocument(allegato);
				MODIVDocument moduloAggiornato3 = getDbMgr().getModuloAllegatoTipo3(mod3, dettaglio, true);
				MapDto.mappaturaDatiAllegatoTipo3(mod3);
				xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(moduloAggiornato3));
				codiceRea = this.getCodiceReaOld(dettaglio.getCodiceImpianto(), Constants.ALLEGATO_TIPO_3);
			}else if(Constants.ALLEGATO_TIPO_4.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				mod4 = MapDto.mapToMODVDocument(allegato);
				MODVDocument moduloAggiornato4 = getDbMgr().getModuloAllegatoTipo4(mod4, dettaglio, true);
				MapDto.mappaturaDatiAllegatoTipo4(moduloAggiornato4);
				xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(moduloAggiornato4));
				codiceRea = this.getCodiceReaOld(dettaglio.getCodiceImpianto(), Constants.ALLEGATO_TIPO_4);
			}

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 6 STEP ");

			//quello che cambia e' xmlModel in base ai tipi di allegati che mi arrivano
			RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
			modulo = getServiziMgr().getModol().mergeModulo(app, null, modulo, xmlModel);

			//a questo punto recupero l'xml dal modulo aggiornato
			byte[] thePdf = modulo.getDataContent();

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 7 STEP ");

			//mi preparo i dati da inviare ad index
			String nomeAllegato = getNomeAllegato(allegatoDto.getFkTipoDocumento(),
					new BigDecimal(dettaglio.getCodiceImpianto()), allegatoDto.getDataControllo(), allegatoDto.getIdAllegato());
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 8 STEP NOME ALLEGATO : "+nomeAllegato);
			Metadati metadati = MapDto.mapMetadatiAllegati(impiantoDto, allegatoDto, codiceRea);
			//uid = getServiziMgr().indexUploadFileOld(nomeAllegato, thePdf, metadati);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 9 STEP UID: "+uid);

			//setto i valori per fare l'update sul db per sigit_t_allegato
			allegatoDto.setDataInvio(DateUtil.getSqlCurrentDate());
			allegatoDto.setNomeAllegato(nomeAllegato);
			allegatoDto.setFkStatoRapp(new BigDecimal(Constants.ID_STATO_RAPPORTO_INVIATO));
			if(uid!=null)
				allegatoDto.setUidIndex(uid);

			//aggiorno pure il pdf appena spedito ad index

			//verificare che non lo si debba fare
			//allegatoDto.setXmlAllegato(thePdf);



			log.debug("FRAAAAAAAAAAAAAAAAAAAA 10 STEP  ");

			//chiamo l'aggiornamento per la tabella sigit_t_allegato
			getDbMgr().getSigitTAllegatoDao().update(allegatoDto);

			log.debug("FRAAAAAAAAAAAAAAAAAAAA 11 STEP  ");

			//ADESSO eseguo il metodo per il salvataggio dei dati sul db che ho appena spediti ad index
			if(Constants.ALLEGATO_TIPO_1.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				salvaInfoDaXmlAllegato1(mod1, allegatoDto, impiantoDto, cfUtenteLoggato, codiceRea);
			}else if(Constants.ALLEGATO_TIPO_2.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				salvaInfoDaXmlAllegato2(mod2, allegatoDto, impiantoDto, cfUtenteLoggato, codiceRea);
			}else if(Constants.ALLEGATO_TIPO_3.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				salvaInfoDaXmlAllegato3(mod3, allegatoDto, impiantoDto, cfUtenteLoggato, codiceRea);
			}else if(Constants.ALLEGATO_TIPO_4.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				salvaInfoDaXmlAllegato4(mod4, allegatoDto, impiantoDto, cfUtenteLoggato, codiceRea);
			}


			log.debug("FRAAAAAAAAAAAAAAAAAAAA 12 STEP  ");

		} catch (SigitTAllegatoDaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (ServiceException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (IOException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (ModolsrvException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} catch (SigitTImpiantoDaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}

		log.debug("[SigitMgr::inviaIspezione] END");
	}
	*/
	/*
	@Transactional
	public void annullaIspezione(DettaglioIspezione dettaglio, String cfUtenteMod)throws ManagerException {
		log.debug("[SigitMgr::annullaIspezione] START");
		try {


			// Se lo stato ispezione e' in CONSOLIDATO metto il libretto in stato ANNULLATO e l'eventuale rapporto di controllo in stato RESPINTO

			// Aggiorno lo stato ispezione
			getDbMgr().aggiornaStatoIspezione(dettaglio.getIdIspezione(), Constants.ID_STATO_ISPEZIONE_ANNULLATO, cfUtenteMod);


			if (GenericUtil.isNotNullOrEmpty(dettaglio.getIdAllegato()))
			{
				// Se presente aggiorno l'allegato
				//getDbMgr().annullaAllegatoIspezione(dettaglio.getIdAllegato(), cfUtenteMod);
				respingiAllegato(ConvertUtil.convertToBigDecimal(dettaglio.getIdAllegato()), cfUtenteMod, Constants.DESC_MOTIVO_RESP_ALLEGATO_ISP);

			}

			// Se esiste un libretto in stato consolidato
			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(dettaglio.getCodiceImpianto(), Constants.ID_STATO_LIBRETTO_CONSOLIDATO);

			if (librettoList!=null && !librettoList.isEmpty())
			{

				SigitTLibrettoDto recordLibretto = librettoList.get(0);

				SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(dettaglio.getCodiceImpianto());
				// Devo modificare anche il libretto

				//SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
				//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
				recordLibretto.setCfRedattore(cfUtenteMod);
				recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
				recordLibretto.setUtenteUltMod(cfUtenteMod);
				recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
				//inserisco
				getDbMgr().inserisciLibretto(recordLibretto);

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> INSERT SU sigit_t_libretto");
				//adesso eseguo i punti 4, 5, 6 dell'algoritmo A006_7 riferito al libretto
				this.creaPdfEConsolidaLibretto(cfUtenteMod, impianto, null, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_ANNULLAMENTO_ISP);
			}

		} catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}

		log.debug("[SigitMgr::annullaIspezione] END");
	}
	*/

//	@Transactional
//	public void annullaIspezioneNow(DettaglioIspezione dettaglio, String cfUtenteMod)throws ManagerException {
//		log.debug("[SigitMgr::annullaIspezione] START");
//		try {
//
//
//			// Se lo stato ispezione e' in CONSOLIDATO metto il libretto in stato ANNULLATO e l'eventuale rapporto di controllo in stato RESPINTO
//
//			// Aggiorno lo stato ispezione
//			getDbMgr().aggiornaStatoIspezione(dettaglio.getIdIspezione(), Constants.ID_STATO_ISPEZIONE_ANNULLATO, cfUtenteMod);
//
//
//			if (GenericUtil.isNotNullOrEmpty(dettaglio.getIdAllegato()))
//			{
//				// Se presente aggiorno l'allegato
//				//getDbMgr().annullaAllegatoIspezione(dettaglio.getIdAllegato(), cfUtenteMod);
//				respingiAllegato(ConvertUtil.convertToBigDecimal(dettaglio.getIdAllegato()), cfUtenteMod, Constants.DESC_MOTIVO_RESP_ALLEGATO_ISP);
//
//			}
//
//
//			/*
//
//			// Se esiste un libretto in stato consolidato
//			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(dettaglio.getCodiceImpianto(), Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
//
//			if (librettoList!=null && !librettoList.isEmpty())
//			{
//
//				SigitTLibrettoDto recordLibretto = librettoList.get(0);
//
//				SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(dettaglio.getCodiceImpianto());
//				// Devo modificare anche il libretto
//
//				//SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
//				//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
//				recordLibretto.setCfRedattore(cfUtenteMod);
//				recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
//				recordLibretto.setUtenteUltMod(cfUtenteMod);
//				recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
//				//inserisco
//				getDbMgr().inserisciLibretto(recordLibretto);
//
//				log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> INSERT SU sigit_t_libretto");
//				//adesso eseguo i punti 4, 5, 6 dell'algoritmo A006_7 riferito al libretto
//				this.creaPdfEConsolidaLibretto(cfUtenteMod, impianto, null, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_ANNULLAMENTO_ISP);
//			}
//			*/
//
//		} catch (ManagerException e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			throw e;
//		}
//
//		log.debug("[SigitMgr::annullaIspezione] END");
//	}

	@Transactional
	public void respingiAllegato(BigDecimal idAllegato, String cfUtenteMod, String motivo)throws ManagerException {
		log.debug("[SigitMgr::respingiAllegato] START");
		try {
			getDbMgr().respingiAllegato(idAllegato, cfUtenteMod, motivo);

		}
		catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}

		log.debug("[SigitMgr::respingiAllegato] END");
	}

//	@Transactional
//	public void cancellaIspezione(DettaglioIspezione dettaglio, String cfUtenteMod)throws ManagerException {
//		log.debug("[SigitMgr::cancellaIspezione] START");
//		try {
//
//
//			// L'ispezione e' in BOZZA, quindi la elimino fisicamente i record
//			if (GenericUtil.isNotNullOrEmpty(dettaglio.getIdAllegato()))
//			{
//				getDbMgr().eliminaAllegato(ConvertUtil.convertToBigDecimal(dettaglio.getIdAllegato()), cfUtenteMod);
//			}
//			getDbMgr().eliminaIspezione(ConvertUtil.convertToBigDecimal(dettaglio.getIdIspezione()), cfUtenteMod);
//
//		} catch (ManagerException e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			throw e;
//		}
//
//		log.debug("[SigitMgr::cancellaIspezione] END");
//	}

	/*
	@Transactional
	public void consolidaIspezione(DettaglioIspezione dettaglio, String cfUtenteLoggato)throws ManagerException {
		log.debug("[SigitMgr::consolidaIspezione] START");
		String codiceRea = null;
		try {


			if (GenericUtil.isNotNullOrEmpty(dettaglio.getIdAllegato()))
			{
				DettaglioAllegato allegato = getDbMgr()
						.getDettaglioAllegatoById(
								dettaglio.getIdAllegato());

				allegato.setCodiceImpianto(dettaglio.getCodiceImpianto());

				allegato.setIdIspezione(dettaglio.getIdIspezione());

				// Devo inviare anche l'allegato
				inviaAllegato(allegato, cfUtenteLoggato, true, null);
			}

			// Aggiorno lo stato ispezione
			getDbMgr().aggiornaStatoIspezione(dettaglio.getIdIspezione(), Constants.ID_STATO_ISPEZIONE_CONSOLIDATO, cfUtenteLoggato);

			// Se esiste un libretto in stato consolidato
			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(dettaglio.getCodiceImpianto(), Constants.ID_STATO_LIBRETTO_CONSOLIDATO);

			if (librettoList!=null && !librettoList.isEmpty())
			{

				SigitTLibrettoDto recordLibretto = librettoList.get(0);

				SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(dettaglio.getCodiceImpianto());
				// Devo modificare anche il libretto

				//SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
				//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
				recordLibretto.setCfRedattore(cfUtenteLoggato);
				recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
				recordLibretto.setUtenteUltMod(cfUtenteLoggato);
				recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
				//inserisco
				getDbMgr().inserisciLibretto(recordLibretto);

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> INSERT SU sigit_t_libretto");
				//adesso eseguo i punti 4, 5, 6 dell'algoritmo A006_7 riferito al libretto
				this.creaPdfEConsolidaLibretto(cfUtenteLoggato, impianto, null, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_CARICAMENTO_ISP);
			}


		} catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}

		log.debug("[SigitMgr::consolidaIspezione] END");
	}
	*/

//	@Transactional
//	public void consolidaIspezioneNow(DettaglioIspezione dettaglio, String cfUtenteLoggato)throws ManagerException {
//		log.debug("[SigitMgr::consolidaIspezione] START");
//		String codiceRea = null;
//		try {
//
//
//			if (GenericUtil.isNotNullOrEmpty(dettaglio.getIdAllegato()))
//			{
//				DettaglioAllegato allegato = getDbMgr()
//						.getDettaglioAllegatoById(
//								dettaglio.getIdAllegato());
//
//				allegato.setCodiceImpianto(dettaglio.getCodiceImpianto());
//
//				allegato.setIdIspezione(dettaglio.getIdIspezione());
//
//				// Devo inviare anche l'allegato
//				inviaAllegato(allegato, cfUtenteLoggato, true, null);
//			}
//
//			// Aggiorno lo stato ispezione
//			getDbMgr().aggiornaStatoIspezione(dettaglio.getIdIspezione(), Constants.ID_STATO_ISPEZIONE_CONSOLIDATO, cfUtenteLoggato);
//
//		} catch (ManagerException e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			throw e;
//		}
//
//		log.debug("[SigitMgr::consolidaIspezione] END");
//	}

	/*
	@Transactional
	public void consolidaIspezioneLibretto(DettaglioIspezione dettaglio, String cfUtenteLoggato)throws ManagerException {
		log.debug("[SigitMgr::consolidaIspezioneLibretto] START");

		try {


			// Se esiste un libretto in stato consolidato
			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(dettaglio.getCodiceImpianto(), Constants.ID_STATO_LIBRETTO_CONSOLIDATO);

			if (librettoList!=null && !librettoList.isEmpty())
			{

				SigitTLibrettoDto recordLibretto = librettoList.get(0);

				SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(dettaglio.getCodiceImpianto());
				// Devo modificare anche il libretto

				//SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
				//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
				recordLibretto.setCfRedattore(cfUtenteLoggato);
				recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
				recordLibretto.setUtenteUltMod(cfUtenteLoggato);
				recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
				//inserisco
				getDbMgr().inserisciLibretto(recordLibretto);

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> INSERT SU sigit_t_libretto");
				//adesso eseguo i punti 4, 5, 6 dell'algoritmo A006_7 riferito al libretto
				this.creaPdfEConsolidaLibretto(cfUtenteLoggato, impianto, null, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_CARICAMENTO_ISP);
			}


		} catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}

		log.debug("[SigitMgr::consolidaIspezioneLibretto] END");
	}
	*/

	/**
	 * Inserimento di un terzo responsabile
	 * @param resp
	 * @throws ManagerException
	 */
	/*
	@Transactional
	public String diventa3ResponsabileNow(TerzoResponsabile resp, ArrayList<String> idApparecchiatureSel, UtenteLoggato utente) throws ManagerException
	{
		log.debug("[SigitMgr::diventa3ResponsabileNow] START");
		StringBuilder sbEmail = new StringBuilder();
		try {
			log.debug("Inserimento contratto");

			SigitTContrattoDto dtoContratto = getDbMgr().inserisciNuovoContratto(resp, utente);

			String codImpianto = resp.getImpCodImpianto();

			log.debug("Inserimento impianto-contratto");

			getDbMgr().inserisciNuovoImpiantoCompContratto(ConvertUtil.convertToBigDecimal(codImpianto), dtoContratto.getIdContratto(), idApparecchiatureSel);

			log.debug("Ricerca ultimo libretto consolidato");





			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(codImpianto, Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			if(librettoList!=null && !librettoList.isEmpty())
			{
				SigitTLibrettoDto libretto = librettoList.get(0);
				log.debug("Libretto consolidato trovato: " + libretto.getIdLibretto());

				libretto.setIdLibretto(null);
				libretto.setFkStato(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_LIBRETTO_BOZZA));

				// Da replicare su tutti
				libretto.setCfRedattore(utente.getCodiceFiscale());

				log.debug("Inserimento libretto in bozza");

				getDbMgr().inserisciLibretto(libretto);

				log.debug("Ricerca impiantoDto");

				SigitTImpiantoDto impiantoDto = getDbMgr().cercaImpiantoDtoById(codImpianto);

				log.debug("Consolidamento libretto per motivo: nomina terzo resp");

				creaPdfEConsolidaLibretto(utente.getCodiceFiscale(), impiantoDto, MapDto.getCodiceRea(resp.getRespImpIdSiglaRea(), resp.getRespImpNumeroRea().getValue()), libretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_NOMINA_3_RESP);
			}
			//invio email
			sbEmail.append("\n\r");
			//sbEmail.append("E' stata inviata una mail ");

			log.debug("Invio email al responsabile e terzo responsabile");
			PersonaGiuridica terzoResponsabile = getDbMgr().cercaPersonaGiuridicaById(resp.getRespImpId());

			String emailResponsabileImpianto = null;
			if(resp.getImpIdRuoloResp()==Constants.ID_RUOLO_AMMINISTRATORE || resp.getImpIdRuoloResp()==Constants.ID_RUOLO_PROPRIETARIO || resp.getImpIdRuoloResp()==Constants.ID_RUOLO_OCCUPANTE)
			{
				PersonaFisica pf = getDbMgr().cercaPersonaFisicaById(ConvertUtil.convertToInteger(resp.getImpIdRespAttivo()));
				if(GenericUtil.isNotNullOrEmpty(pf.getEmail()))
					emailResponsabileImpianto = pf.getEmail();
			}
			else
			{
				PersonaGiuridica respImpianto = getDbMgr().cercaPersonaGiuridicaById(ConvertUtil.convertToInteger(resp.getImpIdRespAttivo()));
				if(GenericUtil.isNotNullOrEmpty(respImpianto.getEmail()))
					emailResponsabileImpianto = respImpianto.getEmail();
			}

			boolean hasMailResponsabile = false;
			boolean hasMail3Responsabile = false;
			ResultInvioMail resultInvioMail = null;
			if(emailResponsabileImpianto!=null)
			{
				log.debug("Invio email al responsabile impianto");
				resultInvioMail = inviaMailNomina3Responsabile(emailResponsabileImpianto, codImpianto, resp, idApparecchiatureSel);

				if (resultInvioMail.isPresentsOK())
				{
					sbEmail.append("E' stata inviata una mail al responsabile dell'impianto ("+emailResponsabileImpianto+") ");
				}
				else if (resultInvioMail.isPresentsKO())
				{
					sbEmail.append("<font color=\"red\">Non e' stata inviata una mail al responsabile dell'impianto ("+emailResponsabileImpianto+"), verificare l'indirizzo mail </font>");
				}

				hasMailResponsabile = true;
			}
			else
				log.debug("Nessuna mail responsabile attivo. Mail non inviata");

			if(GenericUtil.isNotNullOrEmpty(terzoResponsabile.getEmail()))
			{
				log.debug("Invio email al terzo responsabile");
				resultInvioMail = inviaMailNomina3Responsabile(terzoResponsabile.getEmail(), codImpianto, resp, idApparecchiatureSel);
				if(GenericUtil.isNotNullOrEmpty(emailResponsabileImpianto))
				{
//					sbEmail.append(" e ");
					//sbEmail.append("\n\r");
					sbEmail.append(Constants.VALUE_ENTER_HTML);


				}
				if (resultInvioMail.isPresentsOK())
				{
					sbEmail.append("E' stata inviata una mail al terzo responsabile dell'impianto ("+terzoResponsabile.getEmail()+") ");
				}
				else if (resultInvioMail.isPresentsKO())
				{
					sbEmail.append("<font color=\"red\">Non e' stata inviata una mail al terzo responsabile dell'impianto ("+terzoResponsabile.getEmail()+"), verificare l'indirizzo mail </font>");
				}
				hasMail3Responsabile = true;
			}
			else
				log.debug("Email non impostata per terzo responsabile");

			if(hasMail3Responsabile && hasMailResponsabile)
			{
				log.debug("Messaggio nomina: " + sbEmail.toString());
				return sbEmail.toString();
			}
			else
			{
				if(!hasMailResponsabile && !hasMail3Responsabile)
					sbEmail = new StringBuilder();
				if(!hasMailResponsabile)
					sbEmail.append("<BR><font color=\"red\">Responsabile non notificato per mancanza indirizzo email.</font>");
				if(!hasMail3Responsabile)
					sbEmail.append("<BR><font color=\"red\">Terzo responsabile non notificato per mancanza indirizzo email.</font>");
			}

			log.debug("Messaggio nomina: " + sbEmail.toString());
			return sbEmail.toString();
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.debug("Errore in diventa3ResponsabileNow",e);
			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally{
			log.debug("[SigitMgr::diventa3ResponsabileNow] END");
		}
	}
	*/



	@Transactional
	public void diventa3ResponsabileNow2019(TerzoResponsabile resp, UtenteLoggato utente, List<Integer> elencoAutodichiarazioni) throws ManagerException
	{
		log.debug("[SigitMgr::diventa3ResponsabileNow2019] START");
		try {
			log.debug("Inserimento contratto 2019");

			//INSERIMENTO IN CONTRATTO 2019
			SigitTContratto2019Dto dtoContratto = getDbMgr().inserisciNuovoContratto2019(resp, utente);

			log.debug("Inserimento autodichiarazioni nomina contratto");
			//non vengono inserite le righe per le apparecchiature
//			getDbMgr().inserisciNuovoImpiantoCompContratto(ConvertUtil.convertToBigDecimal(codImpianto), dtoContratto.getIdContratto(), idApparecchiatureSel);

			if (elencoAutodichiarazioni != null && !elencoAutodichiarazioni.isEmpty())
			{
				//vengono invece inserite le righe per le autodichiarazioni
				getDbMgr().inserisciAutodichiarazioni3Resp(ConvertUtil.convertToBigDecimal(dtoContratto.getIdContratto()), elencoAutodichiarazioni, "N");
			}

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.debug("Errore in diventa3ResponsabileNow2019",e);
			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally{
			log.debug("[SigitMgr::diventa3ResponsabileNow2019] END");
		}
	}


	@Transactional
	public void proroga3ResponsabileNow2019(DettaglioTerzoResponsabile terzoResponsabile, ProrogaTerzoResponsabile proroga, UtenteLoggato utente) throws ManagerException {
		log.debug("[SigitMgr::proroga3ResponsabileNow2019] START");

		try {
			SigitTAzioneContrattoDto dto = new SigitTAzioneContrattoDto();
			dto.setCfUtenteAzione(utente.getCodiceFiscale());
			dto.setDescrizioneAzione("Proroga nomina terza responsabilita' impianto " + terzoResponsabile.getCodImpianto());
			dto.setDtAzione(DateUtil.getSqlDataCorrente());
			dto.setIdContratto(terzoResponsabile.getIdContratto());
			dto.setOldDataFine(ConvertUtil.convertToSqlDate(terzoResponsabile.getDataFineContratto()));

			log.debug("[SigitMgr::proroga3ResponsabileNow2019] inserimento azione contratto START");

			getDbMgr().getSigitTAzioneContrattoDao().insert(dto);

			log.debug("[SigitMgr::proroga3ResponsabileNow2019] inserimento azione contratto END");

			//aggiornamento delle info sul contratto
			SigitTContratto2019Dto dtoContratto = new SigitTContratto2019Dto();
			dtoContratto.setIdContratto(ConvertUtil.convertToBigDecimal(terzoResponsabile.getIdContratto()));
			dtoContratto.setDataFine(ConvertUtil.convertToSqlDate(proroga.getDataFineContratto()));
			dtoContratto.setFlgTacitoRinnovo(ConvertUtil.convertToBigDecimal(proroga.getFlgTacitoRinnovo()));

			log.debug("[SigitMgr::proroga3ResponsabileNow2019] aggiornamento proroga contratto START");

			getDbMgr().getSigitTContratto2019Dao().updateColumnsPerProroga(dtoContratto);

			log.debug("[SigitMgr::proroga3ResponsabileNow2019] aggiornamento proroga contratto END");

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.debug("Errore in proroga3ResponsabileNow2019",e);
			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally{
			log.debug("[SigitMgr::proroga3ResponsabileNow2019] END");
		}
	}

	@Transactional
	public String proroga3ResponsabileLibretto(DettaglioTerzoResponsabile terzoResp, ProrogaTerzoResponsabile proroga, UtenteLoggato utente) throws ManagerException
	{
		log.debug("[SigitMgr::proroga3ResponsabileLibretto] START");
		StringBuilder sbEmail = new StringBuilder();

		try {

			sbEmail.append("\n\r");
			PersonaGiuridica terzoResponsabile = getDbMgr().cercaPersonaGiuridicaById(terzoResp.getIdPersonaGiuridica());

			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(terzoResp.getCodImpianto(), Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			if(librettoList!=null && !librettoList.isEmpty())
			{
				SigitTLibrettoDto libretto = librettoList.get(0);
				log.debug("Libretto consolidato trovato: " + libretto.getIdLibretto());

				libretto.setIdLibretto(null);
				libretto.setFkStato(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_LIBRETTO_BOZZA));

				// Da replicare su tutti
				libretto.setCfRedattore(utente.getCodiceFiscale());

				log.debug("Inserimento libretto in bozza");

				getDbMgr().inserisciLibretto(libretto);

				log.debug("Ricerca impiantoDto");

				SigitTImpiantoDto impiantoDto = getDbMgr().cercaImpiantoDtoById(terzoResp.getCodImpianto());

				log.debug("Consolidamento libretto per motivo: nomina terzo resp");

				creaPdfEConsolidaLibretto(utente, impiantoDto, MapDto.getCodiceRea(terzoResponsabile.getSiglaRea(), terzoResponsabile.getNumeroRea().getValue()), libretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_PROROGA_3_RESP);
			}
			//invio email
			sbEmail.append("\n\r");

			SigitVTotImpiantoDto respAttivoInData = getDbMgr().cercaResponsabileAttivoAllaDataImpianto(
					ConvertUtil.convertToInteger(terzoResp.getCodImpianto()),
					ConvertUtil.convertToSqlDate(terzoResp.getDataInizioContratto()));


			log.debug("Invio email al responsabile e terzo responsabile");

			String emailResponsabileImpianto = null;
			if ("PG".equals(respAttivoInData.getPfPg())) {
				PersonaGiuridica responsabile =  getDbMgr().cercaPersonaGiuridicaById(ConvertUtil.convertToInteger(respAttivoInData.getIdPersonaFisica()));
				emailResponsabileImpianto = responsabile.getEmail();
			} else {
				PersonaFisica responsabile = getDbMgr().cercaPersonaFisicaById(ConvertUtil.convertToInteger(respAttivoInData.getIdPersonaFisica()));
				emailResponsabileImpianto = responsabile.getEmail();
			}

			TerzoResponsabile dto = new TerzoResponsabile();
			dto.setRespImpImpresa(terzoResponsabile.getDenominazione());
			dto.setRespImpIdSiglaRea(terzoResponsabile.getSiglaRea());
			dto.setRespImpNumeroRea(terzoResponsabile.getNumeroRea());


			dto.setImpLocIndirizzoNoStrad(respAttivoInData.getIndirizzoSitad());
			dto.setImpLocCivico(respAttivoInData.getCivico());
			dto.setImpLocDesComune(respAttivoInData.getDenominazioneComune());
			dto.setImpLocIdProvincia(respAttivoInData.getDenominazioneProvincia());

			dto.setImpRespDenominazione(terzoResponsabile.getDenominazione());
			dto.setImpRespDescRuolo(respAttivoInData.getDesRuolo());
			dto.setDataInizioContratto(terzoResp.getDataInizioContratto());
			dto.setDataFineContratto(proroga.getDataFineContratto());
			dto.setFlgTacitoRinnovo(proroga.getFlgTacitoRinnovo());

			boolean hasMailResponsabile = false;
			boolean hasMail3Responsabile = false;
			ResultInvioMail resultInvioMail = null;
			if(emailResponsabileImpianto!=null)
			{
				log.debug("Invio email al responsabile impianto");
				resultInvioMail = inviaMailNomina3Responsabile(emailResponsabileImpianto, terzoResp.getCodImpianto(), dto, null, true);

				if (resultInvioMail.isPresentsOK())
				{
					sbEmail.append("E' stata inviata una mail al responsabile dell'impianto ("+emailResponsabileImpianto+") ");
				}
				else if (resultInvioMail.isPresentsKO())
				{
					sbEmail.append("<font color=\"red\">Non e' stata inviata una mail al responsabile dell'impianto ("+emailResponsabileImpianto+"), verificare l'indirizzo mail </font>");
				}

				hasMailResponsabile = true;
			}
			else
				log.debug("Nessuna mail responsabile attivo. Mail non inviata");

			if(GenericUtil.isNotNullOrEmpty(terzoResponsabile.getEmail()))
			{
				log.debug("Invio email al terzo responsabile");
				resultInvioMail = inviaMailNomina3Responsabile(terzoResponsabile.getEmail(), terzoResp.getCodImpianto(), dto, null, true);
				if(GenericUtil.isNotNullOrEmpty(emailResponsabileImpianto))
				{
//					sbEmail.append(" e ");
					//sbEmail.append("\n\r");
					sbEmail.append(Constants.VALUE_ENTER_HTML);


				}
				if (resultInvioMail.isPresentsOK())
				{
					sbEmail.append("E' stata inviata una mail al terzo responsabile dell'impianto ("+terzoResponsabile.getEmail()+") ");
				}
				else if (resultInvioMail.isPresentsKO())
				{
					sbEmail.append("<font color=\"red\">Non e' stata inviata una mail al terzo responsabile dell'impianto ("+terzoResponsabile.getEmail()+"), verificare l'indirizzo mail </font>");
				}
				hasMail3Responsabile = true;
			}
			else
				log.debug("Email non impostata per terzo responsabile");

			if(hasMail3Responsabile && hasMailResponsabile)
			{
				log.debug("Messaggio nomina: " + sbEmail.toString());
				return sbEmail.toString();
			}
			else
			{
				if(!hasMailResponsabile && !hasMail3Responsabile)
					sbEmail = new StringBuilder();
				if(!hasMailResponsabile)
					sbEmail.append("<BR><font color=\"red\">Responsabile non notificato per mancanza indirizzo email.</font>");
				if(!hasMail3Responsabile)
					sbEmail.append("<BR><font color=\"red\">Terzo responsabile non notificato per mancanza indirizzo email.</font>");
			}

			log.debug("Messaggio nomina: " + sbEmail.toString());
			return sbEmail.toString();
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.debug("Errore in proroga3ResponsabileLibretto",e);
			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally{
			log.debug("[SigitMgr::proroga3ResponsabileLibretto] END");
		}
	}



	@Transactional
	public String diventa3ResponsabileLibretto(TerzoResponsabile resp, ArrayList<String> idApparecchiatureSel, UtenteLoggato utente) throws ManagerException
	{
		log.debug("[SigitMgr::diventa3ResponsabileLibretto] START");
		StringBuilder sbEmail = new StringBuilder();
		try {

			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(resp.getImpCodImpianto(), Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			if(librettoList!=null && !librettoList.isEmpty())
			{
				SigitTLibrettoDto libretto = librettoList.get(0);
				log.debug("Libretto consolidato trovato: " + libretto.getIdLibretto());

				libretto.setIdLibretto(null);
				libretto.setFkStato(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_LIBRETTO_BOZZA));

				// Da replicare su tutti
				libretto.setCfRedattore(utente.getCodiceFiscale());

				log.debug("Inserimento libretto in bozza");

				getDbMgr().inserisciLibretto(libretto);

				log.debug("Ricerca impiantoDto");

				SigitTImpiantoDto impiantoDto = getDbMgr().cercaImpiantoDtoById(resp.getImpCodImpianto());

				log.debug("Consolidamento libretto per motivo: nomina terzo resp");

				creaPdfEConsolidaLibretto(utente, impiantoDto, MapDto.getCodiceRea(resp.getRespImpIdSiglaRea(), resp.getRespImpNumeroRea().getValue()), libretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_NOMINA_3_RESP);
			}
			//invio email
			sbEmail.append("\n\r");
			//sbEmail.append("E' stata inviata una mail ");

			log.debug("Invio email al responsabile e terzo responsabile");
			PersonaGiuridica terzoResponsabile = getDbMgr().cercaPersonaGiuridicaById(resp.getRespImpId());

			String emailResponsabileImpianto = null;
			if(resp.getImpIdRuoloResp()==Constants.ID_RUOLO_AMMINISTRATORE || resp.getImpIdRuoloResp()==Constants.ID_RUOLO_PROPRIETARIO || resp.getImpIdRuoloResp()==Constants.ID_RUOLO_OCCUPANTE)
			{
				PersonaFisica pf = getDbMgr().cercaPersonaFisicaById(ConvertUtil.convertToInteger(resp.getImpIdRespAttivo()));
				if(GenericUtil.isNotNullOrEmpty(pf.getEmail()))
					emailResponsabileImpianto = pf.getEmail();
			}
			else
			{
				PersonaGiuridica respImpianto = getDbMgr().cercaPersonaGiuridicaById(ConvertUtil.convertToInteger(resp.getImpIdRespAttivo()));
				if(GenericUtil.isNotNullOrEmpty(respImpianto.getEmail()))
					emailResponsabileImpianto = respImpianto.getEmail();
			}

			boolean hasMailResponsabile = false;
			boolean hasMail3Responsabile = false;
			ResultInvioMail resultInvioMail = null;
			if(emailResponsabileImpianto!=null)
			{
				log.debug("Invio email al responsabile impianto");
				resultInvioMail = inviaMailNomina3Responsabile(emailResponsabileImpianto, resp.getImpCodImpianto(), resp, idApparecchiatureSel, false);

				if (resultInvioMail.isPresentsOK())
				{
					sbEmail.append("E' stata inviata una mail al responsabile dell'impianto ("+emailResponsabileImpianto+") ");
				}
				else if (resultInvioMail.isPresentsKO())
				{
					sbEmail.append("<font color=\"red\">Non e' stata inviata una mail al responsabile dell'impianto ("+emailResponsabileImpianto+"), verificare l'indirizzo mail </font>");
				}

				hasMailResponsabile = true;
			}
			else
				log.debug("Nessuna mail responsabile attivo. Mail non inviata");

			if(GenericUtil.isNotNullOrEmpty(terzoResponsabile.getEmail()))
			{
				log.debug("Invio email al terzo responsabile");
				resultInvioMail = inviaMailNomina3Responsabile(terzoResponsabile.getEmail(), resp.getImpCodImpianto(), resp, idApparecchiatureSel, false);
				if(GenericUtil.isNotNullOrEmpty(emailResponsabileImpianto))
				{
//					sbEmail.append(" e ");
					//sbEmail.append("\n\r");
					sbEmail.append(Constants.VALUE_ENTER_HTML);


				}
				if (resultInvioMail.isPresentsOK())
				{
					sbEmail.append("E' stata inviata una mail al terzo responsabile dell'impianto ("+terzoResponsabile.getEmail()+") ");
				}
				else if (resultInvioMail.isPresentsKO())
				{
					sbEmail.append("<font color=\"red\">Non e' stata inviata una mail al terzo responsabile dell'impianto ("+terzoResponsabile.getEmail()+"), verificare l'indirizzo mail </font>");
				}
				hasMail3Responsabile = true;
			}
			else
				log.debug("Email non impostata per terzo responsabile");

			if(hasMail3Responsabile && hasMailResponsabile)
			{
				log.debug("Messaggio nomina: " + sbEmail.toString());
				return sbEmail.toString();
			}
			else
			{
				if(!hasMailResponsabile && !hasMail3Responsabile)
					sbEmail = new StringBuilder();
				if(!hasMailResponsabile)
					sbEmail.append("<BR><font color=\"red\">Responsabile non notificato per mancanza indirizzo email.</font>");
				if(!hasMail3Responsabile)
					sbEmail.append("<BR><font color=\"red\">Terzo responsabile non notificato per mancanza indirizzo email.</font>");
			}

			log.debug("Messaggio nomina: " + sbEmail.toString());
			return sbEmail.toString();
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.debug("Errore in diventa3ResponsabileLibretto",e);
			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally{
			log.debug("[SigitMgr::diventa3ResponsabileLibretto] END");
		}
	}

	public void effettuaSubentro(Subentro subentro, String descRuolo, String descTipoSubentro, String cfUtenteMod)throws ManagerException {
		log.debug("[SigitMgr::effettuaSubentro] START");
		try {

			if (subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_1 ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_2 ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_3 ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_4)
			{

				log.debug("EFFETTUO IL SUBENTRO MANUTENTORE!!!!");
				log.debug("Stampo la lista app: "+subentro.getIdApparecchiature());

				getDbMgr().effettuaSubentroManutentore(subentro, descRuolo, cfUtenteMod);

				gestisciInvioMailSubentro3RespByCodImpianto(subentro.getImpCodImpianto(), subentro.getRespImpId(), descTipoSubentro);

				/*
				// Cerco la nuova Persona Giuridica
				SigitTPersonaGiuridicaDto pgNew = getDbMgr().cercaTPersonaGiuridicaById(subentro.getRespImpId());

				// Se presente un contratto attivo invia una notifica mail al 3R attivo avvisandolo dell'avvenuto subentro:
				List<SigitTContratto2019Dto> listContrattiAttivi = getDbMgr().cercaContrattiAttiviByCodImp(subentro.getImpCodImpianto());

				if (listContrattiAttivi != null && listContrattiAttivi.size() > 0)
				{
					SigitTPersonaGiuridicaDto pgOld = null;
					for (SigitTContratto2019Dto sigitTContratto2019Dto : listContrattiAttivi) {

						pgOld = getDbMgr().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(sigitTContratto2019Dto.getFkPg3Resp()));

						inviaMailSubentroImpianto3Responsabile2019(pgNew, pgOld.getEmail(), ubicazioneImpianto, descTipoSubentro);

					}

				}
				*/
			}
			else
			{
				getDbMgr().effettuaSubentro(subentro, descRuolo, cfUtenteMod);

				if (subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_CARICATORE)
				{
					gestisciInvioMailSubentro3RespByCodImpianto(subentro.getImpCodImpianto(), subentro.getRespImpId(), descTipoSubentro);
				}
			}

		} catch (ManagerException e) {
			throw e;
		}

		log.debug("[SigitMgr::effettuaSubentro] END");
	}

	private void gestisciInvioMailSubentro3RespByCodImpianto(String codImpianto, Integer respImpId, String descTipoSubentro) throws ManagerException
	{
		try
		{
			// Cerco la nuova Persona Giuridica
			SigitTPersonaGiuridicaDto pgNew = getDbMgr().cercaTPersonaGiuridicaById(respImpId);

			// Cerco l'impianto
			SigitVTotImpiantoCercaUbicazioneImpiantoDto ubicazione = getDbMgr().cercaUbicazioneImpianto(ConvertUtil.convertToInteger(codImpianto));
			IdentificativoImpianto ubicazioneImpianto = MapDto.mapToUbicazioneImpiantoPerIspezioni(ubicazione);

			// Se presente un contratto attivo invia una notifica mail al 3R attivo avvisandolo dell'avvenuto subentro:
			List<SigitTContratto2019Dto> listContrattiAttivi = getDbMgr().cercaContrattiAttiviByCodImp(codImpianto);

			if (listContrattiAttivi != null && listContrattiAttivi.size() > 0)
			{
				SigitTPersonaGiuridicaDto pgOld = null;
				for (SigitTContratto2019Dto sigitTContratto2019Dto : listContrattiAttivi) {

					pgOld = getDbMgr().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(sigitTContratto2019Dto.getFkPg3Resp()));

					inviaMailSubentroImpianto3Responsabile2019(pgNew, pgOld.getEmail(), ubicazioneImpianto, descTipoSubentro);

				}

			}

		} catch (ManagerException e) {
			throw e;
		}

	}

	private ResultInvioMail inviaMailIspezione(String destinatario, String codImpianto, String identificativoIspezione, Integer motivoMail, UtenteLoggato utente) throws ManagerException {
		log.debug("inviaMailIspezione: START");
		String oggetto = "";
		StringBuffer testoHtml = new StringBuffer();
		testoHtml.append("L'utente " + utente.getDenominazione() + " " + utente.getCodiceFiscale());
		if (Constants.ID_MOTIVO_CONSOLIDAMENTO_ANNULLAMENTO_ISP == motivoMail) {
			oggetto = "CIT - notifica annullamento ispezione " + identificativoIspezione;
			testoHtml.append(" ha annullato l'ispezione " + identificativoIspezione);
		} else {
			oggetto = "CIT - notifica conclusione ispezione " + identificativoIspezione;
			testoHtml.append(" ha concluso l'ispezione " + identificativoIspezione);
		}

		if (GenericUtil.isNotNullOrEmpty(codImpianto)) {
			testoHtml.append(". Codice impianto: "+codImpianto+"</br>");

			SigitVTotImpiantoCercaUbicazioneImpiantoDto ubicazione = getDbMgr().cercaUbicazioneImpianto(ConvertUtil.convertToInteger(codImpianto));
			IdentificativoImpianto ubicazioneImpianto = MapDto.mapToUbicazioneImpiantoPerIspezioni(ubicazione);
			testoHtml.append(". Ubicazione impianto: "+ubicazioneImpianto.getUbicazione()+"</br>");
		}

		try {
			log.debug("TESTO: \n"+testoHtml);
			return getServiziMgr().sendMail(destinatario, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		} catch (ServiceException e) {
			log.error("Errore invio email ispezione", e);
			throw new ManagerException(e, new Message(e.getMessage()));
		}



	}


	private ResultInvioMail inviaMailNomina3Responsabile(String destinatario, String codImpianto, TerzoResponsabile resp, ArrayList<String> idApparecchiatureSel, boolean isProroga) throws Exception
	{
		log.debug("inviaMailNomina3Responsabile: START");

		log.debug("desctinatario: " + destinatario);
		try {
			String oggetto = isProroga ? "CIT - Proroga nomina terzo responsabile: impianto " + codImpianto : "CIT - Nomina terzo responsabile:  impianto " + codImpianto;
			StringBuffer testoHtml = new StringBuffer();

			String indirizzo = "";

			if(GenericUtil.isNotNullOrEmpty(resp.getImpLocIdIndirizzo()))
				indirizzo = resp.getImpLocDesIndirizzo();
			else
				indirizzo = resp.getImpLocIndirizzoNoStrad();

			testoHtml.append("L'impresa " + resp.getRespImpImpresa() + " ("+MapDto.getCodiceRea(resp.getRespImpIdSiglaRea(), resp.getRespImpNumeroRea().getValue())+") dichiara di essere terzo responsabile dell'impianto in oggetto.</br></br>");

			testoHtml.append("<b>Descrizione impianto</b></br>");
			testoHtml.append("Codice impianto: "+codImpianto+"</br>");
			testoHtml.append("Localizzazione:  "+indirizzo+" "+resp.getImpLocCivico()+", " + resp.getImpLocDesComune()+ " ("+ resp.getImpLocIdProvincia() +")</br>");
			testoHtml.append("Responsabile: "+ resp.getImpRespDenominazione()+"</br>");
			testoHtml.append("Titolo responsabililita': "+resp.getImpRespDescRuolo()+"</br></br>");

			String componenti = "";
			if (idApparecchiatureSel != null) {
				for (int i = 0; i < idApparecchiatureSel.size(); i++) {

					if (i != 0)
					{
						componenti += ", ";
					}

					componenti += idApparecchiatureSel.get(i).replace(Constants.INTERVAL_SEP_HASH, "");
				}
			}

			if (GenericUtil.isNotNullOrEmpty(componenti)) {
				testoHtml.append("Elenco apparecchiature: "+componenti+"</br></br>");
			}

			testoHtml.append("<b>Descrizione contratto</b></br>");
			testoHtml.append("Data inizio del contratto: "+resp.getDataInizioContratto()+"</br>");
			testoHtml.append("Data fine del contratto: "+resp.getDataFineContratto()+"</br>");
			testoHtml.append("Tacito rinnovo: "+(resp.getFlgTacitoRinnovo() ? "SI" : "NO")+"</br></br>");
			testoHtml.append("N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa email.");

			log.debug("TESTO: \n"+testoHtml);

			return getServiziMgr().sendMail(destinatario, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		} catch (ServiceException e) {
			log.error("Errore invio email nomina terzo responsabile", e);
			throw new ManagerException(e, new Message(e.getMessage()));
		}
	}




	private ResultInvioMail inviaMailAssociaA(String numAccertamento, String destinatario, UtenteLoggato utente) throws Exception
	{
		log.debug("inviaMailAssociaA: START");

		log.debug("desctinatario: " + destinatario);
		try {
			String oggetto = "CIT - notifica assegnazione accertamento " + numAccertamento;
			StringBuffer testoHtml = new StringBuffer();

			testoHtml.append("L'utente " + utente.getDenominazione() + " " + utente.getCodiceFiscale());

			testoHtml.append(" Le ha assegnato l'accertamento "+numAccertamento);

			log.debug("TESTO: \n"+testoHtml);
			log.debug("inviaMailAssociaA: STOP");
			return getServiziMgr().sendMail(destinatario, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		} catch (ServiceException e) {
			log.error("Errore invio email associa a...", e);
			throw new ManagerException(e, new Message(e.getMessage()));
		}
	}


	@Transactional
	public CodeDescription revoca3Responsabile2019Now(String codiceImpianto, String ruoloUtente, Integer idContratto, CessazioneTerzaResponsabilita datiCessazione, String codiceFiscaleUtente) throws ManagerException {
		log.debug("SigitMgr:::[revoca3Responsabile2019Now] - START");

		try {

			getDbMgr().modificaContratto2019PerRevoca(idContratto, datiCessazione.getIdTipoCessazione(), datiCessazione.getDataCessazione(), datiCessazione.getMotivoCessazione(), codiceFiscaleUtente);

			//costruzione lista di autodichiarazioni selezionate
			List<Integer> autodichiarazioniSelezionate = new ArrayList<Integer>();
			if (datiCessazione.getElencoAutodichiarazioniSelezionate() != null) {
				for (IdDescription autodichiarazioneSelezionata : datiCessazione.getElencoAutodichiarazioniSelezionate()) {
					autodichiarazioniSelezionate.add(autodichiarazioneSelezionata.getId());
				}
			}

			if (autodichiarazioniSelezionate != null && !autodichiarazioniSelezionate.isEmpty())
			{
				getDbMgr().inserisciAutodichiarazioni3Resp(ConvertUtil.convertToBigDecimal(idContratto), autodichiarazioniSelezionate, "C");
			}

			CodeDescription coppiaIdAccertamentoMailPA= null;
			//nel caso di cessazione di decadenza viene creata una verifica
			if (Constants.ID_TIPO_CESSAZIONE_DECADENZA.equals(datiCessazione.getIdTipoCessazione())) {
				coppiaIdAccertamentoMailPA = creaAutomatismiDecadenza(codiceImpianto);
			}
			return coppiaIdAccertamentoMailPA;
		} catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.debug("Errore in revoca3ResponsabileNow");
			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally{
			log.debug("SigitMgr:::[revoca3Responsabile2019Now] - END");
		}
	}

	/*
	@Transactional
	public String revoca3ResponsabileLibretto(Integer idContratto, String codiceImpianto, Ruolo ruolo, String cfUtente, String dataRevoca, Integer idPG3Responsabile) throws ManagerException
	{
		StringBuilder sbEmail = new StringBuilder();
		log.debug("SigitMgr:::[revoca3ResponsabileLibretto] - START");
		try {
			SigitVTotImpiantoDto datiImpianto = getDbMgr().cercaResponsabileAttivoByCodImpianto(ConvertUtil.convertToInteger(codiceImpianto));
			//Integer idPG3Responsabile = ConvertUtil.convertToInteger(datiImpianto.getIdPersonaGiuridica3r());
			log.debug("ID 3 RESPONSABILE: " + idPG3Responsabile);

			SigitTContrattoDto contratto = getDbMgr().cercaContrattoById(ConvertUtil.convertToBigDecimal(idContratto));

			//consolidamento libretto
			log.debug("Ricerca ultimo libretto consolidato");
			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(codiceImpianto, Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			if(librettoList!=null && !librettoList.isEmpty())
			{
				SigitTLibrettoDto libretto = librettoList.get(0);
				libretto.setIdLibretto(null);
				libretto.setCfRedattore(cfUtente);

				libretto.setFkStato(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_LIBRETTO_BOZZA));
				log.debug("Inserimento libretto in bozza");
				getDbMgr().inserisciLibretto(libretto);
				log.debug("Ricerca impiantoDto");
				SigitTImpiantoDto impiantoDto = getDbMgr().cercaImpiantoDtoById(codiceImpianto);
				log.debug("Consolidamento libretto per motivo: nomina terzo resp");
				creaPdfEConsolidaLibretto(cfUtente, impiantoDto, MapDto.getCodiceRea(ruolo.getSiglaRea(), ruolo.getNumeroRea()), libretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_REVOCA_3_RESP);
			}

			//invio email
			log.debug("Invio email");
			//sbEmail.append("\n");
			//sbEmail.append(Constants.VALUE_ENTER_HTML);
			//sbEmail.append("E' stata inviata una mail ");

			boolean hasMailResponsabile = false;
			boolean hasMail3Responsabile = false;
			ResultInvioMail resultInvioMail = null;

			PersonaGiuridica terzoResponsabile = getDbMgr().cercaPersonaGiuridicaById(idPG3Responsabile);
			if(GenericUtil.isNotNullOrEmpty(terzoResponsabile.getEmail()))
			{
				resultInvioMail = inviaMailRevoca3Responsabile(terzoResponsabile, terzoResponsabile.getEmail(), codiceImpianto, datiImpianto, contratto, dataRevoca);
				if (resultInvioMail.isPresentsOK())
				{
					sbEmail.append("E' stata inviata una mail al terzo responsabile dell'impianto ("+terzoResponsabile.getEmail()+") ");
				}
				else if (resultInvioMail.isPresentsKO())
				{
					sbEmail.append("<font color=\"red\">Non e' stata inviata una mail al terzo responsabile dell'impianto ("+terzoResponsabile.getEmail()+"), verificare l'indirizzo mail </font>");
				}

				hasMail3Responsabile = true;
			}
			else
				log.debug("Email non impostata per terzo responsabile");

			String emailResponsabileImpianto = null;
			if(datiImpianto.getPfPg().equals("PF"))
			{
				PersonaFisica pf = getDbMgr().cercaPersonaFisicaById(ConvertUtil.convertToInteger(datiImpianto.getIdPersonaFisica()));
				if(GenericUtil.isNotNullOrEmpty(pf.getEmail()))
					emailResponsabileImpianto = pf.getEmail();
			}
			else
			{
				PersonaGiuridica respImpianto = getDbMgr().cercaPersonaGiuridicaById(ConvertUtil.convertToInteger(datiImpianto.getIdPersonaFisica()));
				if(GenericUtil.isNotNullOrEmpty(respImpianto.getEmail()))
					emailResponsabileImpianto = respImpianto.getEmail();
			}

			if(GenericUtil.isNotNullOrEmpty(emailResponsabileImpianto))
			{
				if(GenericUtil.isNotNullOrEmpty(terzoResponsabile.getEmail()))
				{
					//sbEmail.append("e ");
					//sbEmail.append("\n\r");
					sbEmail.append(Constants.VALUE_ENTER_HTML);

				}

				resultInvioMail = inviaMailRevoca3Responsabile(terzoResponsabile, emailResponsabileImpianto, codiceImpianto, datiImpianto, contratto, dataRevoca);
				if (resultInvioMail.isPresentsOK())
				{
					sbEmail.append("E' stata inviata una mail al responsabile dell'impianto ("+emailResponsabileImpianto+")");
				}
				else if (resultInvioMail.isPresentsKO())
				{
					sbEmail.append("<font color=\"red\">Non e' stata inviata una mail al responsabile dell'impianto ("+emailResponsabileImpianto+"), verificare l'indirizzo mail </font>");
				}

				hasMailResponsabile = true;
			}
			else
				log.debug("Nessuna mail responsabile attivo. Mail non inviata");

			if(hasMail3Responsabile && hasMailResponsabile)
			{
				if (log.isDebugEnabled())
					log.debug("Messaggio revoca: " + sbEmail.toString());

				return sbEmail.toString();
			}
			else
			{
				if(!hasMailResponsabile && !hasMail3Responsabile)
					sbEmail = new StringBuilder();
				if(!hasMailResponsabile)
					sbEmail.append("<BR><font color=\"red\">Responsabile non notificato per mancanza indirizzo email.</font>");
				if(!hasMail3Responsabile)
					sbEmail.append("<BR><font color=\"red\">Terzo responsabile non notificato per mancanza indirizzo email.</font>");
			}
			if (log.isDebugEnabled())
				log.debug("Messaggio revoca: " + sbEmail.toString());

			return sbEmail.toString();
		} catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.debug("Errore in revoca3ResponsabileLibretto");
			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally{
			log.debug("SigitMgr:::[revoca3ResponsabileLibretto] - END");
		}
	}
	*/

	@Transactional
	public String revoca3ResponsabileLibretto2019(Integer idContratto, String codiceImpianto, Ruolo ruolo, UtenteLoggato utenteLoggato, CessazioneTerzaResponsabilita datiCessazione, Integer idPG3Responsabile, CodeDescription coppiaIdAccertamentoMailPA) throws ManagerException
	{
		StringBuilder sbEmail = new StringBuilder();
		log.debug("SigitMgr:::[revoca3ResponsabileLibretto2019] - START");
		try {
			String cfUtente = utenteLoggato.getCodiceFiscale();

			SigitVTotImpiantoDto datiImpianto = getDbMgr().cercaResponsabileAttivoByCodImpianto(ConvertUtil.convertToInteger(codiceImpianto));
			log.debug("ID 3 RESPONSABILE: " + idPG3Responsabile);

			SigitTContratto2019Dto contratto = getDbMgr().cercaContratto2019ById(idContratto);

			//consolidamento libretto
			log.debug("Ricerca ultimo libretto consolidato");
			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(codiceImpianto, Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			if(librettoList!=null && !librettoList.isEmpty())
			{
				SigitTLibrettoDto libretto = librettoList.get(0);
				libretto.setIdLibretto(null);
				libretto.setCfRedattore(cfUtente);

				libretto.setFkStato(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_LIBRETTO_BOZZA));
				log.debug("Inserimento libretto in bozza");
				getDbMgr().inserisciLibretto(libretto);
				log.debug("Ricerca impiantoDto");
				SigitTImpiantoDto impiantoDto = getDbMgr().cercaImpiantoDtoById(codiceImpianto);
				log.debug("Consolidamento libretto per motivo: nomina terzo resp");
				creaPdfEConsolidaLibretto(utenteLoggato, impiantoDto, MapDto.getCodiceRea(ruolo.getSiglaRea(), ruolo.getNumeroRea()), libretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_REVOCA_3_RESP);
			}

			//invio email
			log.debug("Invio email");
			//sbEmail.append("\n");
			//sbEmail.append(Constants.VALUE_ENTER_HTML);
			//sbEmail.append("E' stata inviata una mail ");

			boolean hasMailResponsabile = false;
			boolean hasMail3Responsabile = false;
			boolean hasMailPA = coppiaIdAccertamentoMailPA == null; //il booleano sulla mail PA ha senso solo se l'account e' valorizzato (esso sara' valorizzato solo nel caso di cessazione per decadenza)
			ResultInvioMail resultInvioMail = null;

			PersonaGiuridica terzoResponsabile = getDbMgr().cercaPersonaGiuridicaById(idPG3Responsabile);
			if(GenericUtil.isNotNullOrEmpty(terzoResponsabile.getEmail()))
			{
				resultInvioMail = inviaMailRevoca3Responsabile2019(terzoResponsabile, terzoResponsabile.getEmail(), datiImpianto, contratto, datiCessazione, null);
				if (resultInvioMail.isPresentsOK())
				{
					sbEmail.append("E' stata inviata una mail al terzo responsabile dell'impianto ("+terzoResponsabile.getEmail()+") ");
				}
				else if (resultInvioMail.isPresentsKO())
				{
					sbEmail.append("<font color=\"red\">Non e' stata inviata una mail al terzo responsabile dell'impianto ("+terzoResponsabile.getEmail()+"), verificare l'indirizzo mail </font>");
				}

				hasMail3Responsabile = true;
			}
			else
				log.debug("Email non impostata per terzo responsabile");

			String emailResponsabileImpianto = null;
			if(datiImpianto.getPfPg().equals("PF"))
			{
				PersonaFisica pf = getDbMgr().cercaPersonaFisicaById(ConvertUtil.convertToInteger(datiImpianto.getIdPersonaFisica()));
				if(GenericUtil.isNotNullOrEmpty(pf.getEmail()))
					emailResponsabileImpianto = pf.getEmail();
			}
			else
			{
				PersonaGiuridica respImpianto = getDbMgr().cercaPersonaGiuridicaById(ConvertUtil.convertToInteger(datiImpianto.getIdPersonaFisica()));
				if(GenericUtil.isNotNullOrEmpty(respImpianto.getEmail()))
					emailResponsabileImpianto = respImpianto.getEmail();
			}

			if(GenericUtil.isNotNullOrEmpty(emailResponsabileImpianto))
			{
				if(GenericUtil.isNotNullOrEmpty(terzoResponsabile.getEmail()))
				{
					//sbEmail.append("e ");
					//sbEmail.append("\n\r");
					sbEmail.append(Constants.VALUE_ENTER_HTML);

				}

				resultInvioMail = inviaMailRevoca3Responsabile2019(terzoResponsabile, emailResponsabileImpianto, datiImpianto, contratto, datiCessazione, null);
				if (resultInvioMail.isPresentsOK())
				{
					sbEmail.append("E' stata inviata una mail al responsabile dell'impianto ("+emailResponsabileImpianto+")");
				}
				else if (resultInvioMail.isPresentsKO())
				{
					sbEmail.append("<font color=\"red\">Non e' stata inviata una mail al responsabile dell'impianto ("+emailResponsabileImpianto+"), verificare l'indirizzo mail </font>");
				}

				hasMailResponsabile = true;
			}
			else
				log.debug("Nessuna mail responsabile attivo. Mail non inviata");

			//sezione dedicata all'invio della mail per la pubblica amministrazione nel caso di cessazione per revoca
			if(coppiaIdAccertamentoMailPA != null && StringUtils.isNotBlank(coppiaIdAccertamentoMailPA.getCode()) && StringUtils.isNotBlank(coppiaIdAccertamentoMailPA.getDescription())) {

				sbEmail.append(Constants.VALUE_ENTER_HTML);

				String emailPA = coppiaIdAccertamentoMailPA.getDescription();

				resultInvioMail = inviaMailRevoca3Responsabile2019(terzoResponsabile, emailPA, datiImpianto, contratto, datiCessazione, coppiaIdAccertamentoMailPA.getCode());
				if (resultInvioMail.isPresentsOK())
				{
					sbEmail.append("E' stata inviata una mail alla PA legata all'impianto ("+emailPA+")");
				}
				else if (resultInvioMail.isPresentsKO())
				{
					sbEmail.append("<font color=\"red\">Non e' stata inviata una mail alla PA legata all'impianto ("+emailPA+"), verificare l'indirizzo mail </font>");
				}

				hasMailPA = true;

			} else {
				log.debug("Nessuna mail per pubblica amministrazione. Mail non inviata");
			}

			if(hasMail3Responsabile && hasMailResponsabile && hasMailPA)
			{
				if (log.isDebugEnabled())
					log.debug("Messaggio revoca: " + sbEmail.toString());

				return sbEmail.toString();
			}
			else
			{
				if(!hasMailResponsabile && !hasMail3Responsabile && !hasMailPA)
					sbEmail = new StringBuilder();
				if(!hasMailResponsabile)
					sbEmail.append("<BR><font color=\"red\">Responsabile non notificato per mancanza indirizzo email.</font>");
				if(!hasMail3Responsabile)
					sbEmail.append("<BR><font color=\"red\">Terzo responsabile non notificato per mancanza indirizzo email.</font>");
				if(!hasMailPA)
					sbEmail.append("<BR><font color=\"red\">Pubblica amministrazione non notificata per mancanza indirizzo email.</font>");
			}
			if (log.isDebugEnabled())
				log.debug("Messaggio revoca: " + sbEmail.toString());

			return sbEmail.toString();
		} catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.debug("Errore in revoca3ResponsabileLibretto");
			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally{
			log.debug("SigitMgr:::[revoca3ResponsabileLibretto] - END");
		}
	}

	/*
	private ResultInvioMail inviaMailRevoca3Responsabile(PersonaGiuridica terzoResponsabile, String destinatario, String codImpianto, SigitVTotImpiantoDto impianto, SigitTContrattoDto contratto,  String dataRevoca) throws ManagerException
	{
		log.debug("inviaMailNomina3Responsabile: START");

		log.debug("desctinatario: " + destinatario);
		try {
			String oggetto = "CIT - Revoca terzo responsabile:  impianto " + codImpianto;
			StringBuffer testoHtml = new StringBuffer();

			log.debug("numero rea: " + impianto.getNumeroRea());
			String denominazioneTerzoResp = terzoResponsabile.getDenominazione();
			denominazioneTerzoResp += " (" + MapDto.getCodiceRea(terzoResponsabile.getSiglaRea(), ConvertUtil.convertToInteger(terzoResponsabile.getNumeroRea()).intValue())+") ";

			String localizzazione = impianto.getIndirizzoSitad()+" "+impianto.getCivico()+", " + impianto.getDenominazioneComune()+ " ("+ impianto.getDenominazioneProvincia() ;

			testoHtml.append("L'impresa "+denominazioneTerzoResp+") dichiara la revoca dal ruolo di terzo responsabile dell'impianto in oggetto.</br></br>");

			testoHtml.append("<b>Descrizione impianto</b></br>");
			testoHtml.append("Codice impianto: "+codImpianto+"</br>");
			testoHtml.append("Localizzazione:  "+localizzazione+")</br>");
			testoHtml.append("Responsabile: "+ impianto.getDenominazione()+"</br>");
			testoHtml.append("Titolo responsabililita': "+impianto.getDesRuolo()+"</br></br>");


			testoHtml.append("<b>Descrizione contratto</b></br>");
			testoHtml.append("Data inizio del contratto: "+ConvertUtil.convertToString(contratto.getDataInizio())+"</br>");
			testoHtml.append("Data fine del contratto: "+ConvertUtil.convertToString(contratto.getDataFine())+"</br>");
			testoHtml.append("Tacito rinnovo: "+(ConvertUtil.convertToBooleanAllways(contratto.getFlgTacitoRinnovo()) ? "SI" : "NO")+"</br>");
			testoHtml.append("Data revoca del contratto: "+dataRevoca+"</br></br>");
			testoHtml.append("N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa email.");

			if (log.isDebugEnabled())
				log.debug("TESTO EMAIL: \n"+testoHtml);

			return getServiziMgr().sendMail(destinatario, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		} catch (Exception e) {
			log.error("Errore invio email revoca terzo responsabile", e);
			throw new ManagerException(e, new Message(e.getMessage()));
		}
	}
	*/

	private ResultInvioMail inviaMailRevoca3Responsabile2019(PersonaGiuridica terzoResponsabile, String destinatario, SigitVTotImpiantoDto impianto, SigitTContratto2019Dto contratto,  CessazioneTerzaResponsabilita datiCessazione, String idAccertamento) throws ManagerException
	{
		log.debug("SigitMgr:::[inviaMailRevoca3Responsabile2019] - START");

		log.debug("desctinatario: " + destinatario);
		try {
			String oggetto = null;
			//se l'id accertamento e' true allora la mail di revoca che si sta creando e' quella inviata per l'accertamento creato in automatico (questo accade quando il motivo della cessazione e' decadenza)
			if (StringUtils.isNotBlank(idAccertamento)) {
				//viene recuperato l'accertamento
				oggetto = "CIT - Creato Accertamento-" + idAccertamento +" per DECADENZA terzo responsabile sull'impianto " + impianto.getCodiceImpianto();
			} else {
				oggetto = "CIT - Cessazione terzo responsabile:  impianto " + impianto.getCodiceImpianto();
			}

			StringBuffer testoHtml = new StringBuffer();

			log.debug("numero rea: " + impianto.getNumeroRea());
//			String denominazioneTerzoResp = terzoResponsabile.getDenominazione();
//			denominazioneTerzoResp += " (" + MapDto.getCodiceRea(terzoResponsabile.getSiglaRea(), ConvertUtil.convertToInteger(terzoResponsabile.getNumeroRea()).intValue())+") ";

			String localizzazione = impianto.getIndirizzoSitad()+" "+impianto.getCivico()+", " + impianto.getDenominazioneComune()+ " ("+ impianto.getDenominazioneProvincia() ;

//			testoHtml.append("L'impresa "+denominazioneTerzoResp+") dichiara la revoca dal ruolo di terzo responsabile dell'impianto in oggetto.</br></br>");


			testoHtml.append("E' stata dichiarata la cessazione per "+datiCessazione.getDesTipoCessazione()+" della terza responsabilit� dell'impianto in oggetto</br></br>");

			testoHtml.append("<b>Descrizione impianto</b></br>");
			testoHtml.append("Codice impianto: "+impianto.getCodiceImpianto()+"</br>");
			testoHtml.append("Localizzazione:  "+localizzazione+")</br></br>");

			testoHtml.append("<b>Responsabile attuale</b></br>");
			testoHtml.append("Denominazione: "+ impianto.getDenominazione()+"</br>");
			testoHtml.append("Titolo responsabililita': "+impianto.getDesRuolo()+"</br></br>");

			testoHtml.append("<b>Terzo responsabile</b></br>");
			testoHtml.append("Denominazione: "+ terzoResponsabile.getDenominazione()+"</br>");
			testoHtml.append("Codice REA: "+ ConvertUtil.getStringByConcat(" ", terzoResponsabile.getSiglaRea(), ConvertUtil.convertToString(terzoResponsabile.getNumeroRea()))+"</br></br>");

			testoHtml.append("<b>Descrizione contratto</b></br>");
			testoHtml.append("Data inizio del contratto: "+ConvertUtil.convertToString(contratto.getDataInizio())+"</br>");
			testoHtml.append("Data fine del contratto: "+ConvertUtil.convertToString(contratto.getDataFine())+"</br>");
			testoHtml.append("Data revoca del contratto: "+datiCessazione.getDataCessazione()+"</br>");
			testoHtml.append("Tacito rinnovo: "+(ConvertUtil.convertToBooleanAllways(contratto.getFlgTacitoRinnovo()) ? "SI" : "NO")+"</br></br>");

			//se ci sono autodichiarazioni Cessazione
			if (datiCessazione.getElencoAutodichiarazioniSelezionate() != null && datiCessazione.getElencoAutodichiarazioniSelezionate().size() > 0) {
				testoHtml.append("<b>Dichiarazione stato dell'impianto alla cessazione</b></br>");
				for (IdDescription autodichiarazioneScelta : datiCessazione.getElencoAutodichiarazioniSelezionate()) {
					testoHtml.append("	- " + autodichiarazioneScelta.getDescription() + "</b>");
				}
				testoHtml.append("</b>");
			}

			testoHtml.append("N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa email.");

			if (log.isDebugEnabled())
				log.debug("TESTO EMAIL: \n"+testoHtml);

			return getServiziMgr().sendMail(destinatario, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		} catch (Exception e) {
			log.error("Errore invio email revoca terzo responsabile", e);
			throw new ManagerException(e, new Message(e.getMessage()));
		}
	}

	private String inviaMailSubentroImpianto3Responsabile2019(SigitTPersonaGiuridicaDto pg, String emailDestinatario, IdentificativoImpianto ubicazioneImpianto, String descTipoSubentro) throws ManagerException
	{
		log.debug("[SigitMgr::inviaMailSubentroImpianto3Responsabile2019] BEGIN");
		StringBuilder sbEmail = new StringBuilder();

		try {


			if (emailDestinatario != null) {

				log.debug("SigitMgr::inviaMailSubentroImpianto3Responsabile2019: fase invio mail START");
				log.debug("desctinatario: " + emailDestinatario);

				try {
					String oggetto = "CIT - Subentro: impianto " + ubicazioneImpianto.getCodiceImpianto();
					StringBuffer testoHtml = new StringBuffer();

					testoHtml.append("L'impresa " + pg.getDenominazione() + " (" + MapDto.getCodiceRea(pg.getSiglaRea(), pg.getNumeroRea())+") ha effettuato il subentro sull'impianto in oggetto.</br></br>");

					testoHtml.append("<b>Descrizione impianto</b></br>");
					testoHtml.append("Codice impianto: "+ubicazioneImpianto.getCodiceImpianto()+"</br>");
					testoHtml.append("Localizzazione: "+ubicazioneImpianto.getUbicazione()+"</br>");
					testoHtml.append("Tipo subentro: "+descTipoSubentro);

					log.debug("inviaMailSubentroImpianto3Responsabile2019 TESTO: \n"+testoHtml);

					ResultInvioMail resultInvioMail = getServiziMgr().sendMail(emailDestinatario, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));

					sbEmail.append("<BR>");


				} catch (ServiceException e) {
					log.error("Errore invio email subentro a...", e);
					throw new ManagerException(e, new Message(e.getMessage()));
				}
			}


		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		} catch (Exception e) {
			throw new ManagerException(e, new Message(Messages.ERROR_INVIO_MAIL));
		}
		finally {
			log.debug("[SigitMgr::inviaMailSubentroImpianto3Responsabile2019] END");
		}

		return sbEmail.toString();
	}

	private ResultInvioMail inviaMailAvvioAutomaticoAccertamentoRee(PersonaGiuridica terzoResponsabile, String destinatario,
			SigitVTotImpiantoDto impianto, DettaglioAllegato dettaglio, String idAccertamento) throws ManagerException
	{
		log.debug("SigitMgr:::[inviaMailAvvioAutomaticoAccertamentoRee] - START");

		log.debug("desctinatario: " + destinatario);
		try {
			String oggetto = "CIT - Creato ACCERTAMENTO-" + idAccertamento +" sull'impianto " + impianto.getCodiceImpianto() + " che non puo' funzionare ai fini della sicurezza";

			StringBuffer testoHtml = new StringBuffer();

			log.debug("numero rea: " + impianto.getNumeroRea());
//			String denominazioneTerzoResp = terzoResponsabile.getDenominazione();
//			denominazioneTerzoResp += " (" + MapDto.getCodiceRea(terzoResponsabile.getSiglaRea(), ConvertUtil.convertToInteger(terzoResponsabile.getNumeroRea()).intValue())+") ";

			String localizzazione = impianto.getIndirizzoSitad()+" "+impianto.getCivico()+", " + impianto.getDenominazioneComune()+ " ("+ impianto.getDenominazioneProvincia() ;

//			testoHtml.append("L'impresa "+denominazioneTerzoResp+") dichiara la revoca dal ruolo di terzo responsabile dell'impianto in oggetto.</br></br>");

			testoHtml.append("Sul REE con data controllo " + dettaglio.getDataControllo() + "</br>");
			testoHtml.append("e' stato dichiarato che l'impianto " + impianto.getCodiceImpianto() + " non puo' funzionare ai fini della sicurezza.</br></br>");

			testoHtml.append("<b>Descrizione impianto</b></br>");
			testoHtml.append("Codice impianto: "+impianto.getCodiceImpianto()+"</br>");
			testoHtml.append("Localizzazione:  "+localizzazione+")</br></br>");

			testoHtml.append("<b>Responsabile attuale</b></br>");

			String denominazione = impianto.getDenominazione();

			if (impianto.getPfPg().equalsIgnoreCase(Constants.LABEL_PF))
			{
				denominazione += " " + impianto.getNome();
			}

			testoHtml.append("Denominazione: "+ denominazione+"</br>");
			testoHtml.append("Titolo responsabililita': "+impianto.getDesRuolo()+"</br></br>");

			if (terzoResponsabile != null)
			{
				testoHtml.append("<b>Terzo responsabile</b></br>");
				testoHtml.append("Denominazione: "+ terzoResponsabile.getDenominazione()+"</br>");
				testoHtml.append("Codice REA: "+ ConvertUtil.getStringByConcat(" ", terzoResponsabile.getSiglaRea(), ConvertUtil.convertToString(terzoResponsabile.getNumeroRea()))+"</br></br>");
			}

			testoHtml.append("N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa email.");

			if (log.isDebugEnabled())
				log.debug("TESTO EMAIL: \n"+testoHtml);

			return getServiziMgr().sendMail(destinatario, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		} catch (Exception e) {
			log.error("Errore invio email revoca terzo responsabile", e);
			throw new ManagerException(e, new Message(e.getMessage()));
		}
	}

	@Transactional
	public void elaboraXmlLibrettoBozza(BigDecimal idLibretto, String cfUtente) throws DbManagerException
	{
		log.debug("Inizio elaborazione libretto: " + idLibretto);
		try {
			SigitTLibTxtDto txtLibretto = getDbMgr().getTxtLibretto(idLibretto);
			//salvare sez 1 e 14
			MODDocument librettoDoc = MapDto.mapToMODDocument(XmlBeanUtils.readString(txtLibretto.getXmlLibretto()));
			Richiesta richiesta = librettoDoc.getMOD().getRichiesta();
			String idImpianto = richiesta.getDatiPrecompilati().getCodiceImpianto();
			log.debug("idImpianto = " + idImpianto);
			salvaScheda1Libretto(idImpianto, richiesta, cfUtente, false);
			log.debug("fine dati scheda 1, inizio scheda 14");
			salvaDatiScheda14Libretto(idImpianto, cfUtente, richiesta);
		} catch (Exception e) {
			log.error("Errore: ",e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException();
		}
		finally
		{
			log.debug("Fine elaborazione libretto: " + idLibretto);
		}
	}

	public byte[] creaZipListaLibrettoXmlByElCodImp(String elencoCodImp) throws DbManagerException
	{
		log.debug("SigitMgr:::[creaZipListaLibrettoXmlByElCodImp] - START");

		byte[] bosByte = null;
		try {
			List<SigitTLibTxtByCodImpiantiDto> librettiList = getDbMgr().cercaListaLibrettoXmlByElCodImp(elencoCodImp);


			//FileOutputStream fos = new FileOutputStream("atest.zip");
		    ByteArrayOutputStream bos = new ByteArrayOutputStream();

			ZipOutputStream zos = new ZipOutputStream(bos);

			byte[] tracciato = null;

			for (SigitTLibTxtByCodImpiantiDto libretto : librettiList) {
				if (libretto != null)
				{
					tracciato = XmlBeanUtils.readString(libretto.getTxtXmlLibretto());
					addToZipFile(ConvertUtil.convertToString(libretto.getLibCodiceImpianto())+".xml", tracciato, zos);

				}
			}
//
//			String file1Name = "file1.txt";
//			String file2Name = "file2.txt";
//			String file3Name = "folder/file3.txt";
//			String file4Name = "folder/file4.txt";
//			String file5Name = "f1/f2/f3/file5.txt";
//
//			addToZipFile(file2Name, zos);
//			addToZipFile(file3Name, zos);
//			addToZipFile(file4Name, zos);
//			addToZipFile(file5Name, zos);

			if (zos != null)
				zos.close();

			if (bos != null)
			{
				bos.close();
				bosByte = bos.toByteArray();
			}
			return bosByte;

		} catch (Exception e) {
			log.debug("SigitMgr:::[creaZipListaLibrettoXmlByElCodImp] - ERRORE");
			log.error("Errore: ",e);
			throw new DbManagerException();
		}
		finally
		{
			log.debug("SigitMgr:::[creaZipListaLibrettoXmlByElCodImp] - END");
		}
	}

	private static void addToZipFile(String fileName, byte[] tracciato, ZipOutputStream zos) throws FileNotFoundException, IOException {

		log.debug("Writing '" + fileName + "' to zip file");

		ZipEntry zipEntry = new ZipEntry(fileName);
		zos.putNextEntry(zipEntry);

		zos.write(tracciato);
		zos.closeEntry();


	}

	private static void addToZipFileOld(String fileName, ZipOutputStream zos) throws FileNotFoundException, IOException {

		log.debug("Writing '" + fileName + "' to zip file");

		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		ZipEntry zipEntry = new ZipEntry(fileName);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}

	/**
	 * Salva l'esito dell'elaborazione del xml in bozza
	 * @param idLibretto
	 * @param esito true se non ci sono stati errori, false altrimenti. in caso di eccezioni, il libretto deve essere messo di nuovo in elaborazione
	 * @param dto
	 * @throws ManagerException
	 */
	public void salvaEsitoElaborazioneBozza(SigitTmpLibrettoDto dto, boolean esito) throws ManagerException
	{
		log.debug("salvaEsitoElaborazioneBozza START");
		dto.setDataElab(DateUtil.getSqlDataCorrente());
		dto.setFlgElaborato(new BigDecimal("1"));
		dto.setFlgEsitoElab(ConvertUtil.convertToBigDecimal(esito));
		getDbMgr().salvaInfoLibrettoElaborato(dto);
		log.debug("salvaEsitoElaborazioneBozza END");
	}

	/*
	@Transactional
	public void elaboraXmlAllegatoRespinto(BigDecimal idAllegato, String cfUtente) throws DbManagerException
	{
		log.debug("Inizio elaborazione allegato: " + idAllegato);
		try {

			MODIIDocument mod1 = null;
			MODIIIDocument mod2 = null;
			MODIVDocument mod3 = null;
			MODVDocument mod4 = null;

			//SigitTAllTxtDto txtLibretto = getDbMgr().getAllTxtAllegato(idAllegato);
			SigitTAllegatoDto allegatoDto = getDbMgr().getSigitTAllegatoDao().findByPrimaryKey(new SigitTAllegatoPk(idAllegato));

			log.debug("Stampo l'Uid Index: "+allegatoDto.getUidIndex());

			if (GenericUtil.isNotNullOrEmpty(allegatoDto.getUidIndex()))
			{
				// Recupero il pdf da index
				byte[] fileIndex = getServiziMgr().getFileIndexByUid(allegatoDto.getUidIndex(), allegatoDto.getNomeAllegato());

				log.debug("Ho recuperato il file pdf da Index");

				// Recupero dal pdf l'xml
				byte[] datiXml = getServiziMgr().getXmlFromPdf(fileIndex);

				log.debug("Ho recuperato il file xml dal pdf");

				if (log.isDebugEnabled())
					log.debug("Stampo datiXml di index: "+datiXml);


				//byte[] allegato = XmlBeanUtils.readString(datiXml);

				if(Constants.ALLEGATO_TIPO_1.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
					mod1 = MapDto.mapToMODIIDocument(datiXml);

					salvaInfoDaXmlAllegato1Respinto(mod1, allegatoDto, cfUtente);

				}
				else if(Constants.ALLEGATO_TIPO_2.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
					mod2 = MapDto.mapToMODIIIDocument(datiXml);

					salvaInfoDaXmlAllegato2Respinto(mod2, allegatoDto, cfUtente);
				}
				else if(Constants.ALLEGATO_TIPO_3.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
					mod3 = MapDto.mapToMODIVDocument(datiXml);

					salvaInfoDaXmlAllegato3Respinto(mod3, allegatoDto, cfUtente);
				}
				else if(Constants.ALLEGATO_TIPO_4.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
					mod4 = MapDto.mapToMODVDocument(datiXml);

					salvaInfoDaXmlAllegato4Respinto(mod4, allegatoDto, cfUtente);
				}
			}

		} catch (Exception e) {
			log.error("Errore: ",e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException();
		}
		finally
		{
			log.debug("Fine elaborazione allegato: " + idAllegato);
		}
	}
	*/
	/**
	 * Salva l'esito dell'elaborazione del xml in stato respinto
	 * @param idAllegato
	 * @param esito true se non ci sono stati errori, false altrimenti. in caso di eccezioni, l'allegato deve essere messo di nuovo in elaborazione
	 * @param dto
	 * @throws ManagerException
	 */
	public void salvaEsitoElaborazioneRespinto(SigitTmpLibrettoDto dto, boolean esito) throws ManagerException
	{
		log.debug("salvaEsitoElaborazioneRespinto START");
		dto.setDataElab(DateUtil.getSqlDataCorrente());
		dto.setFlgElaborato(new BigDecimal("1"));
		dto.setFlgEsitoElab(ConvertUtil.convertToBigDecimal(esito));
		getDbMgr().salvaInfoLibrettoElaborato(dto);
		log.debug("salvaEsitoElaborazioneRespinto END");
	}


	/*
	public void salvaInfoDaXmlAllegato1Respinto(MODIIDocument modAllegatoTipo1,
			SigitTAllegatoDto allegato, String cfUtenteLoggato)throws ManagerException {
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato1Respinto] BEGIN");

		//aggiorniamo di nuovo la tabella SIGIT_T_ALLEGATO con gli altri elementi aggiuntivi sia dell'xml che le informazioni dell'utente
		it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta richiesta = modAllegatoTipo1.getMODII().getRichiesta();

		//sezione B.documentazione tecnica a corredo
		List<RowAllegatoII> allegatoIIList = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
//		boolean flagControllo = false;
		String codiceImpianto = modAllegatoTipo1.getMODII().getRichiesta().getDatiAllegato().getAllegatoII().getRowAllegatoIIArray(0).getCodiceCatasto();
		try{
			for(RowAllegatoII allegatoII : allegatoIIList){

				//RowAllegatoII allegatoII = allegatoIIList.get(0);
				DocumentazioneTecnica documentazioneTecnica = allegatoII.getDocumentazioneTecnica();
				it.csi.sigit.sigitwebn.xml.allegato2.data.TrattamentoAcquaDocument.TrattamentoAcqua trattamentoAcqua = allegatoII.getTrattamentoAcqua();
				it.csi.sigit.sigitwebn.xml.allegato2.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = allegatoII.getDatiIdentificativi();


					if(documentazioneTecnica.getABFlagDichiarazConfNO()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.NO_0));
					}
					if(documentazioneTecnica.getABFlagDichiarazConfSI()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.SI_1));
					}
					if(documentazioneTecnica.getABFlagLibrettoCompNO()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.NO_0));
					}
					if(documentazioneTecnica.getABFlagLibrettoCompSI()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.SI_1));
					}
					if(documentazioneTecnica.getABFlagLibrettoImpNO()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.NO_0));
					}
					if(documentazioneTecnica.getABFlagLibrettoImpSI()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.SI_1));
					}
					if(documentazioneTecnica.getABFlagManutGenNO()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.NO_0));
					}
					if(documentazioneTecnica.getABFlagManutGenSI()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.SI_1));
					}

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1Respinto] END --> A. Dati identificativi ");
					try{
						if(GenericUtil.isNotNullOrEmpty(datiIdentificativi.getAAPotenzaTermicaNomTotMax())){
							allegato.setAPotenzaTermicaNominaleMax(datiIdentificativi.getAAPotenzaTermicaNomTotMax());
						}
					}catch (Exception e) {allegato.setAPotenzaTermicaNominaleMax(null);}


					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1Respinto] END --> B. documentazione tecnica a corredo");

					//sezione F.check list
					CheckList checkList = allegatoII.getCheckList();
					log.debug("[F ]check list --> checkList.getAFOsservazioni(): "+checkList.getAFOsservazioni());
					if(GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni())){
						allegato.setFOsservazioni(checkList.getAFOsservazioni());
					}
					log.debug("[F ]check list --> checkList.getAFRaccomandazioni(): "+checkList.getAFRaccomandazioni());
					if(GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni())){
						allegato.setFRaccomandazioni(checkList.getAFRaccomandazioni());
					}
					log.debug("[F ]check list --> checkList.getAFPrescrizioni(): "+checkList.getAFPrescrizioni());
					if(GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni())){
						allegato.setFPrescrizioni(checkList.getAFPrescrizioni());
					}

					DatiTecnico datiTecnico = allegatoII.getDatiTecnico();
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpNO(): "+datiTecnico.getAFFlagFunzImpNO());
					if(datiTecnico.getAFFlagFunzImpNO()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpSI(): "+datiTecnico.getAFFlagFunzImpSI());
					if(datiTecnico.getAFFlagFunzImpSI()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.SI_1));
					}

					try{allegato.setFInterventoEntro(DateUtil.getSqlDate(datiTecnico.getAFDataIntervento()));}catch (Exception e) {allegato.setFInterventoEntro(null);}

					log.debug("[F ]check list --> datiTecnico.getAFOrarioArrivo(): "+datiTecnico.getAFOrarioArrivo());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioArrivo())){
						allegato.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
					}
					log.debug("[F ]check list --> datiTecnico.getAFOrarioPartenza(): "+datiTecnico.getAFOrarioPartenza());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioPartenza())){
						allegato.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
					}
					log.debug("[F ]check listcheck list --> datiTecnico.getAFNomeTecnico(): "+datiTecnico.getAFNomeTecnico());
					log.debug("[F ]check list --> datiTecnico.getAFCognomeTecnico(): "+datiTecnico.getAFCognomeTecnico());
					allegato.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));
					log.debug("[F ]check list --> datiTecnico.getAFFirmaTecnico(): "+datiTecnico.getAFFirmaTecnico());

					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
						allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
						allegato.setFFirmaTecnico(datiTecnico.getAFFirmaTecnico());
					}else{
						allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
						allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
						allegato.setFFirmaResponsabile(datiTecnico.getAFFirmaResp());
					}else{
						allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
					}

					//Non so ancora cosa settare a livello di flg_controllo_bozza????
//					allegato.setFlgControlloBozza(new BigDecimal(Constants.SI_1));
//					allegato.setDataUltMod(DateUtil.getSqlDataCorrente());
//					allegato.setUtenteUltMod(cfUtenteLoggato);

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1Respinto] END --> F.check list per  sigit_t_allegato");
					//aggiorno la tabella SIGIT_T_ALLEGATO
					getDbMgr().getSigitTAllegatoDao().update(allegato);


					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1Respinto] END --> update su  sigit_t_allegato");

					SigitTRappTipo1Dto rapportoTipo1 = new SigitTRappTipo1Dto();
					log.debug("[F ]check list --> checkList.getAFFlagValvole(): "+checkList.getAFFlagValvole());
					//attenzione parte legata a sigit_t_rapp_tipo1
					if(checkList.getAFFlagValvole()){
						rapportoTipo1.setFFlgAdozioneValvoleTerm(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setFFlgAdozioneValvoleTerm(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F ]check list --> checkList.getAFFlagIsolamento(): "+checkList.getAFFlagIsolamento());
					if(checkList.getAFFlagIsolamento()){
						rapportoTipo1.setFFlgIsolamenteRete(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setFFlgIsolamenteRete(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F ]check list --> checkList.getAFFlagSistTrattACS(): "+checkList.getAFFlagSistTrattACS());
					if(checkList.getAFFlagSistTrattACS()){
						rapportoTipo1.setFFlgAdozSistTrattamH2o(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setFFlgAdozSistTrattamH2o(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F ]check list --> checkList.getAFFlagSistRegolaz(): "+checkList.getAFFlagSistRegolaz());
					if(checkList.getAFFlagSistRegolaz()){
						rapportoTipo1.setFFlgSostituzSistRegolaz(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setFFlgSostituzSistRegolaz(new BigDecimal(Constants.NO_0));
					}
					//Sezione C. trattamento dell'acqua
					if(trattamentoAcqua.getACFlagTrattH2ONR()){
						rapportoTipo1.setCFlgTrattClimaNonRich(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setCFlgTrattClimaNonRich(new BigDecimal(Constants.NO_0));
					}
					if(trattamentoAcqua.getACFlagTrattAcsNR()){
						rapportoTipo1.setCFlgTrattAcsNonRichiesto(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setCFlgTrattAcsNonRichiesto(new BigDecimal(Constants.NO_0));
					}

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1Respinto] END -->  sezione F.check list legata a sigit_t_rapp_tipo1");

					//sezione D.controllo dell'impianto
					ControlloImpianto controlloImpianto = allegatoII.getControlloImpianto();
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagInternoSI(): "+controlloImpianto.getADFlagInternoSI());
					if(controlloImpianto.getADFlagInternoSI()){
						rapportoTipo1.setDFlgLocaleIntIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagInternoNO()){
						rapportoTipo1.setDFlgLocaleIntIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagInternoNC()){
						rapportoTipo1.setDFlgLocaleIntIdoneo(new BigDecimal(Constants.NC_2));
					}

					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagEsternoSI(): "+controlloImpianto.getADFlagEsternoSI());
					if(controlloImpianto.getADFlagEsternoSI()){
						rapportoTipo1.setDFlgGenExtIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagEsternoNO()){
						rapportoTipo1.setDFlgGenExtIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagEsternoNC()){
						rapportoTipo1.setDFlgGenExtIdoneo(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagApertureSI(): "+controlloImpianto.getADFlagApertureSI());
					if(controlloImpianto.getADFlagApertureSI()){
						rapportoTipo1.setDFlgApertureLibere(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagApertureNO()){
						rapportoTipo1.setDFlgApertureLibere(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagApertureNC()){
						rapportoTipo1.setDFlgApertureLibere(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagDimensioniSI(): "+controlloImpianto.getADFlagDimensioniSI());
					if(controlloImpianto.getADFlagDimensioniSI()){
						rapportoTipo1.setDFlgApertureAdeg(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagDimensioniNO()){
						rapportoTipo1.setDFlgApertureAdeg(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagDimensioniNC()){
						rapportoTipo1.setDFlgApertureAdeg(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagCanaleFumoSI(): "+controlloImpianto.getADFlagCanaleFumoSI());
					if(controlloImpianto.getADFlagCanaleFumoSI()){
						rapportoTipo1.setDFlgScaricoIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagCanaleFumoNO()){
						rapportoTipo1.setDFlgScaricoIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagCanaleFumoNC()){
						rapportoTipo1.setDFlgScaricoIdoneo(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagSistRegolazSI(): "+controlloImpianto.getADFlagSistRegolazSI());
					if(controlloImpianto.getADFlagSistRegolazSI()){
						rapportoTipo1.setDFlgTempAmbFunz(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagSistRegolazNO()){
						rapportoTipo1.setDFlgTempAmbFunz(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagSistRegolazNC()){
						rapportoTipo1.setDFlgTempAmbFunz(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagPerditeSI(): "+controlloImpianto.getADFlagPerditeSI());
					if(controlloImpianto.getADFlagPerditeSI()){
						rapportoTipo1.setDFlgAssenzaPerdComb(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagPerditeNO()){
						rapportoTipo1.setDFlgAssenzaPerdComb(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagPerditeNC()){
						rapportoTipo1.setDFlgAssenzaPerdComb(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagTenutaSI(): "+controlloImpianto.getADFlagTenutaSI());
					if(controlloImpianto.getADFlagTenutaSI()){
						rapportoTipo1.setDFlgIdoTenImpInt(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagTenutaNO()){
						rapportoTipo1.setDFlgIdoTenImpInt(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagTenutaNC()){
						rapportoTipo1.setDFlgIdoTenImpInt(new BigDecimal(Constants.NC_2));
					}

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1Respinto] END -->  sezione D.controllo dell'impianto legata a sigit_t_rapp_tipo1");

					//INSERISCO nella tabella SIGIT_RAPP_TIPO1
					rapportoTipo1.setIdAllegato(allegato.getIdAllegato());

					SigitTRappTipo1Pk pk = new SigitTRappTipo1Pk();
					pk.setIdAllegato(allegato.getIdAllegato());
					//devo controllare se ho un record presente sulla tabella o no

					// E' DA FARE?????????????? (punto1)

					SigitTRappTipo1Dto dettaglioRappTipo1 = getDbMgr().getSigitTRappTipo1Dao().findByPrimaryKey(pk);
					if(dettaglioRappTipo1!=null){
						log.debug("[SigitMgr::salvaInfoDaXmlAllegato1Respinto] TROVATO RECORD SU sigit_t_rapp_tipo1");
						//non posso fare l'update perche' nelle pagine successive non mi riporta tutti i dati
						//getDbMgr().getSigitTRappTipo1Dao().update(rapportoTipo1);
					}
					else{
						getDbMgr().getSigitTRappTipo1Dao().insert(rapportoTipo1);
						log.debug("[SigitMgr::salvaInfoDaXmlAllegato1Respinto] END --> INSERT SU sigit_t_rapp_tipo1");
					}


					//sezione E.controllo e verifica energetica  del gruppo termico
					ControlloVerificaEnergetica controlloVerificaEnergetica = allegatoII.getControlloVerificaEnergetica();
					SigitTDettTipo1Dto sigitTDettTipo1Dto = new SigitTDettTipo1Dto();
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagClimatizInv(): "+controlloVerificaEnergetica.getAEFlagClimatizInv());
					if(controlloVerificaEnergetica.getAEFlagClimatizInv()){
						sigitTDettTipo1Dto.setEFlgClimaInverno(new BigDecimal(Constants.SI_1));
					}else{
						sigitTDettTipo1Dto.setEFlgClimaInverno(new BigDecimal(Constants.NO_0));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagProduzACS(): "+controlloVerificaEnergetica.getAEFlagProduzACS());
					if(controlloVerificaEnergetica.getAEFlagProduzACS()){
						sigitTDettTipo1Dto.setEFlgProduzAcs(new BigDecimal(Constants.SI_1));
					}else{
						sigitTDettTipo1Dto.setEFlgProduzAcs(new BigDecimal(Constants.NO_0));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagDispComandoSI(): "+controlloVerificaEnergetica.getAEFlagDispComandoSI());
					if(controlloVerificaEnergetica.getAEFlagDispComandoSI()){
						sigitTDettTipo1Dto.setEFlgDisposComando(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagDispComandoNO()){
						sigitTDettTipo1Dto.setEFlgDisposComando(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagDispComandoNC()){
						sigitTDettTipo1Dto.setEFlgDisposComando(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagDispSicuSI(): "+controlloVerificaEnergetica.getAEFlagDispSicuSI());
					if(controlloVerificaEnergetica.getAEFlagDispSicuSI()){
						sigitTDettTipo1Dto.setEFlgDisposSicurezza(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagDispSicuNO()){
						sigitTDettTipo1Dto.setEFlgDisposSicurezza(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagDispSicuNC()){
						sigitTDettTipo1Dto.setEFlgDisposSicurezza(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagValvSicuSI(): "+controlloVerificaEnergetica.getAEFlagValvSicuSI());
					if(controlloVerificaEnergetica.getAEFlagValvSicuSI()){
						sigitTDettTipo1Dto.setEFlgValvolaSicurezza(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagValvSicuNO()){
						sigitTDettTipo1Dto.setEFlgValvolaSicurezza(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagValvSicuNC()){
						sigitTDettTipo1Dto.setEFlgValvolaSicurezza(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagScambiatoreSI(): "+controlloVerificaEnergetica.getAEFlagScambiatoreSI());
					if(controlloVerificaEnergetica.getAEFlagScambiatoreSI()){
						sigitTDettTipo1Dto.setEFlgScambiatoreFumi(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagScambiatoreNO()){
						sigitTDettTipo1Dto.setEFlgScambiatoreFumi(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagScambiatoreNC()){
						sigitTDettTipo1Dto.setEFlgScambiatoreFumi(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagRiflussoSI(): "+controlloVerificaEnergetica.getAEFlagRiflussoSI());
					if(controlloVerificaEnergetica.getAEFlagRiflussoSI()){
						sigitTDettTipo1Dto.setEFlgRiflusso(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagRiflussoNO()){
						sigitTDettTipo1Dto.setEFlgRiflusso(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagRiflussoNC()){
						sigitTDettTipo1Dto.setEFlgRiflusso(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagRisultatiSI(): "+controlloVerificaEnergetica.getAEFlagRisultatiSI());
					if(controlloVerificaEnergetica.getAEFlagRisultatiSI()){
						sigitTDettTipo1Dto.setEFlgUni103891(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagRisultatiNO()){
						sigitTDettTipo1Dto.setEFlgUni103891(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagRisultatiNC()){
						sigitTDettTipo1Dto.setEFlgUni103891(new BigDecimal(Constants.NC_2));
					}

					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEPotenzaFocolare() ********************************************** ");

					try{sigitTDettTipo1Dto.setEPotTermFocolKw(ConvertUtil.convertToBigDecimal(controlloVerificaEnergetica.getAEPotenzaFocolare()));}catch (Exception e) {sigitTDettTipo1Dto.setEPotTermFocolKw(null);}

					if(controlloVerificaEnergetica.getAEFlagEvacFumiFORZ()){
						sigitTDettTipo1Dto.setEFlgEvacuFumi(Constants.FLAG_EVACUAZIONE_FUMI_FORZATA);
					}
					if(controlloVerificaEnergetica.getAEFlagEvacFumiNATU()){
						sigitTDettTipo1Dto.setEFlgEvacuFumi(Constants.FLAG_EVACUAZIONE_FUMI_NATURALE);
					}

					try{sigitTDettTipo1Dto.setL111AltroRiferimento(controlloVerificaEnergetica.getAEAltroRifNormativo());}catch (Exception e) {sigitTDettTipo1Dto.setL111AltroRiferimento(null);}

					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEDepressCanaleFumo(): ++++++++++++++++++++++++++++++++++++++++++++ ");

					try{sigitTDettTipo1Dto.setEDeprCanaleFumoPa(ConvertUtil.convertToBigDecimal(controlloVerificaEnergetica.getAEDepressCanaleFumo()));}catch (Exception e) {sigitTDettTipo1Dto.setEDeprCanaleFumoPa(null);}

					sigitTDettTipo1Dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
					sigitTDettTipo1Dto.setFkAllegato(allegato.getIdAllegato());
					sigitTDettTipo1Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
					sigitTDettTipo1Dto.setUtenteUltMod(cfUtenteLoggato);
					sigitTDettTipo1Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_GT);

					try{sigitTDettTipo1Dto.setProgressivo(ConvertUtil.convertToBigDecimal(allegatoII.getAENumGT()));}catch (Exception e) {sigitTDettTipo1Dto.setProgressivo(null);}
					try{sigitTDettTipo1Dto.setDataInstall(DateUtil.getSqlDate(allegatoII.getAEDataInstallaz()));}catch (Exception e) {sigitTDettTipo1Dto.setDataInstall(null);}

					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1Respinto] END --> sezione E.controllo e verifica energetica  del gruppo termico sigit_t_DETT_tipo1");
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1Respinto] BEGIN --> sezione E.controllo e verifica energetica tab fumi del gruppo termico sigit_t_DETT_tipo1");
					TabFumi tabFumi = allegatoII.getTabFumi();
					List<RowFumi> rigaFumi = tabFumi.getRowFumiList();
					if(rigaFumi!=null && rigaFumi.size()>0){
						log.debug("FRAAAAAAAAAAAAAAA ---> rowfumi lunghezza lista da inserire : "+rigaFumi.size());
						int count = 0;
						 for(RowFumi dto : rigaFumi){
							 log.debug("FRAAAAAAAAAAAAAAA ---> rowfumi count : "+count);

							 try {sigitTDettTipo1Dto.setETempFumiC(dto.getAETempFumi());}catch (Exception e) {sigitTDettTipo1Dto.setETempFumiC(null);}
							 try {sigitTDettTipo1Dto.setETempAriaC(dto.getAETempAria());}catch (Exception e) {sigitTDettTipo1Dto.setETempAriaC(null);}
							 try {sigitTDettTipo1Dto.setEO2Perc(dto.getAEO2());}catch (Exception e) {sigitTDettTipo1Dto.setEO2Perc(null);}
							 try {sigitTDettTipo1Dto.setECo2Perc(dto.getAECO2());}catch (Exception e) {sigitTDettTipo1Dto.setECo2Perc(null);}

							 try{sigitTDettTipo1Dto.setEBacharachMin(dto.getAEBacharach1());}catch (Exception e) {sigitTDettTipo1Dto.setEBacharachMin(null);}
							 try{sigitTDettTipo1Dto.setEBacharachMed(dto.getAEBacharach2());}catch (Exception e) {sigitTDettTipo1Dto.setEBacharachMed(null);}
							 try{ sigitTDettTipo1Dto.setEBacharachMax(dto.getAEBacharach3());}catch (Exception e) {sigitTDettTipo1Dto.setEBacharachMax(null);}

							 try {sigitTDettTipo1Dto.setECoCorrettoPpm(dto.getAECOcorretto());}catch (Exception e) {sigitTDettTipo1Dto.setECoCorrettoPpm(null);}

							 if (GenericUtil.isNotNullOrEmpty(sigitTDettTipo1Dto.getECoCorrettoPpm()) && sigitTDettTipo1Dto.getECoCorrettoPpm().doubleValue() <= new BigDecimal(1000).doubleValue())
							 {
								 sigitTDettTipo1Dto.setL111FlgCoMin1000(new BigDecimal(Constants.SI_1));
							 }
							 else
							 {
								 sigitTDettTipo1Dto.setL111FlgCoMin1000(new BigDecimal(Constants.NO_0));
							 }

							 try {sigitTDettTipo1Dto.setERendCombPerc(dto.getAERendimCombu());}catch (Exception e) {sigitTDettTipo1Dto.setERendCombPerc(null);}
							 try {sigitTDettTipo1Dto.setERendMinLeggePerc(dto.getAERendimentoLegge());}catch (Exception e) {sigitTDettTipo1Dto.setERendMinLeggePerc(null);}
							 try {sigitTDettTipo1Dto.setENoxPpm(dto.getAENox());}catch (Exception e) {sigitTDettTipo1Dto.setENoxPpm(null);}
							 try{ sigitTDettTipo1Dto.setENModuloTermico(ConvertUtil.convertToInteger(dto.getAEModuloTermico()));}catch (Exception e) {sigitTDettTipo1Dto.setENModuloTermico(null);}


							 //INSERISCO
							 getDbMgr().getSigitTDettTipo1Dao().insert(sigitTDettTipo1Dto);
							 count++;

						 }
					}
					//traccio il primo giro del for con tutti i dati del pdf
					//flagControllo = true;
				}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato1Respinto] END --> INSERT SU sigit_t_DETT_tipo1");
				//adesso devo aggiornare la parte di libretto che e' dedicata esclusivamente all'allegato
				//mi trovo l'ultimo libretto aggiornato e creo una copia di questo sulla tabella
				//dopodiche' mi vado a richiamare il metodo che scrive il libretto e lo consolida

				//SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(codiceImpianto);
				//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
//				recordLibretto.setCfRedattore(cfUtenteLoggato);
//				recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
//				recordLibretto.setUtenteUltMod(cfUtenteLoggato);
//				recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
				//inserisco
//				getDbMgr().inserisciLibretto(recordLibretto);

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato1Respinto] END --> INSERT SU sigit_t_libretto");
				//adesso eseguo i punti 4, 5, 6 dell'algoritmo A002_7 riferito al libretto
				//this.creaPdfEConsolidaLibretto(cfUtenteLoggato, impianto, codiceRea, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO);

		}catch(Exception e){
			log.error("[SigitMgr::salvaInfoDaXmlAllegato1Respinto] END ", e);
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));

		}
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato1Respinto] END");
	}
	*/
	/*
	public void salvaInfoDaXmlAllegato2Respinto(MODIIIDocument modAllegatoTipo2,
			SigitTAllegatoDto allegato, String cfUtenteLoggato)throws ManagerException {
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] BEGIN");

		//aggiorniamo di nuovo la tabella SIGIT_T_ALLEGATO con gli altri elementi aggiuntivi sia dell'xml che le informazioni dell'utente
		it.csi.sigit.sigitwebn.xml.allegato3.data.RichiestaDocument.Richiesta richiesta = modAllegatoTipo2.getMODIII().getRichiesta();
		String codiceImpianto = richiesta.getDatiAllegato().getAllegatoIII().getRowAllegatoIIIArray(0).getCodiceCatasto();

		//sezione B.documentazione tecnica a corredo
		List<RowAllegatoIII> allegatoIIIList = richiesta.getDatiAllegato().getAllegatoIII().getRowAllegatoIIIList();
//		boolean flagControllo = false;
		try{
			log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] lubghezza rowAllegatiIII --> "+allegatoIIIList.size());
			for(RowAllegatoIII allegatoIII: allegatoIIIList){
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] entro nel for RowAllegatoIII");
				//RowAllegatoIII allegatoIII = allegatoIIIList.get(0);
				it.csi.sigit.sigitwebn.xml.allegato3.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = allegatoIII.getDocumentazioneTecnica();
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] passo 1");
				it.csi.sigit.sigitwebn.xml.allegato3.data.TrattamentoAcquaDocument.TrattamentoAcqua trattamentoAcqua =  allegatoIII.getTrattamentoAcqua();
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] passo 2");
				it.csi.sigit.sigitwebn.xml.allegato3.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = allegatoIII.getDatiIdentificativi();

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] passo 3");
				try{
					if(documentazioneTecnica.getABFlagDichiarazConfNO()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] passo 4");
				try{
					if(documentazioneTecnica.getABFlagDichiarazConfSI()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] passo 5");
				try{
					if(documentazioneTecnica.getABFlagLibrettoCompNO()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] passo 6");
				try{
					if(documentazioneTecnica.getABFlagLibrettoCompSI()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] passo 7");
				try{
					if(documentazioneTecnica.getABFlagLibrettoImpNO()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] passo 8");
				try{
					if(documentazioneTecnica.getABFlagLibrettoImpSI()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] passo 9");
				try{
					if(documentazioneTecnica.getABFlagManutGenNO()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] passo 10");
				try{
					if(documentazioneTecnica.getABFlagManutGenSI()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] END --> A. Dati identificativi ");
				try{
					if(GenericUtil.isNotNullOrEmpty(datiIdentificativi.getAAPotenzaTermicaNomTotMax())){
						allegato.setAPotenzaTermicaNominaleMax(datiIdentificativi.getAAPotenzaTermicaNomTotMax());
					}
				}catch (Exception e) {allegato.setAPotenzaTermicaNominaleMax(null);}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] END --> B. documentazione tecnica a corredo");

				//sezione F.check list
				it.csi.sigit.sigitwebn.xml.allegato3.data.CheckListDocument.CheckList checkList = allegatoIII.getCheckList();
				log.debug("[F ]check list --> checkList.getAFOsservazioni(): "+checkList.getAFOsservazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni())){
					allegato.setFOsservazioni(checkList.getAFOsservazioni());
				}
				log.debug("[F]check list --> checkList.getAFRaccomandazioni(): "+checkList.getAFRaccomandazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni())){
					allegato.setFRaccomandazioni(checkList.getAFRaccomandazioni());
				}
				log.debug("[F ]check list --> checkList.getAFPrescrizioni(): "+checkList.getAFPrescrizioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni())){
					allegato.setFPrescrizioni(checkList.getAFPrescrizioni());
				}

				it.csi.sigit.sigitwebn.xml.allegato3.data.DatiTecnicoDocument.DatiTecnico datiTecnico = allegatoIII.getDatiTecnico();

				try{
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpNO(): "+datiTecnico.getAFFlagFunzImpNO());
					if(datiTecnico.getAFFlagFunzImpNO()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					log.debug("[F]check list --> datiTecnico.getAFFlagFunzImpSI(): "+datiTecnico.getAFFlagFunzImpSI());
					if(datiTecnico.getAFFlagFunzImpSI()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				try{allegato.setFInterventoEntro(DateUtil.getSqlDate(datiTecnico.getAFDataIntervento()));}catch (Exception e) {allegato.setFInterventoEntro(null);}


				try{
					log.debug("[F ]check list --> datiTecnico.getAFOrarioArrivo(): "+datiTecnico.getAFOrarioArrivo());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioArrivo())){
						allegato.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
					}
				}catch (Exception e) {allegato.setFOraArrivo(null);}

				try{
					log.debug("[F]check list --> datiTecnico.getAFOrarioPartenza(): "+datiTecnico.getAFOrarioPartenza());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioPartenza())){
						allegato.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
					}
				}catch (Exception e) {allegato.setFOraPartenza(null);}
				log.debug("[F ]check list --> datiTecnico.getAFNomeTecnico(): "+datiTecnico.getAFNomeTecnico());
				log.debug("[F]check list --> datiTecnico.getAFCognomeTecnico(): "+datiTecnico.getAFCognomeTecnico());
				allegato.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));

				try{
					log.debug("[F]check list --> datiTecnico.getAFFirmaTecnico(): "+datiTecnico.getAFFirmaTecnico());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
						allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
						allegato.setFFirmaTecnico(datiTecnico.getAFFirmaTecnico());
					}else{
						allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {allegato.setFFlgFirmaTecnico(null);allegato.setFFlgFirmaTecnico(null);}


				try{
					log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
						allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
						allegato.setFFirmaResponsabile(datiTecnico.getAFFirmaResp());
					}else{
						allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {allegato.setFFlgFirmaResponsabile(null);allegato.setFFirmaResponsabile(null);}
				//Non so ancora cosa settare a livello di flg_controllo_bozza????
//				allegato.setFlgControlloBozza(new BigDecimal(Constants.SI_1));
//				allegato.setDataUltMod(DateUtil.getSqlDataCorrente());
//				allegato.setUtenteUltMod(cfUtenteLoggato);

				getDbMgr().getSigitTAllegatoDao().update(allegato);


				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] END --> update su  sigit_t_allegato");

				SigitTRappTipo2Dto rapportoTipo2 = new SigitTRappTipo2Dto();

				//attenzione parte legata a sigit_t_rapp_tipo1
				try {
					log.debug("[F ]check list --> checkList.getAFFlagIsolamentoCanali(): "+checkList.getAFFlagIsolamentoCanali());
					if(checkList.getAFFlagIsolamentoCanali()){
						rapportoTipo2.setFFlgIsolDistribuzH2o(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo2.setFFlgIsolDistribuzH2o(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {rapportoTipo2.setFFlgIsolDistribuzH2o(null);}


				try {
					log.debug("[F ]check list --> checkList.getAFFlagIsolamentoRete(): "+checkList.getAFFlagIsolamentoRete());
					if(checkList.getAFFlagIsolamentoRete()){
						rapportoTipo2.setFFlgIsolDistribuzAria(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo2.setFFlgIsolDistribuzAria(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {rapportoTipo2.setFFlgIsolDistribuzAria(null);}


				try {
					log.debug("[F ]check list --> checkList.getAFFlagSostGen1(): "+checkList.getAFFlagSostGen1());
					if(checkList.getAFFlagSostGen1()){
						rapportoTipo2.setFFlgSostituzGeneratori(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo2.setFFlgSostituzGeneratori(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {rapportoTipo2.setFFlgSostituzGeneratori(null);}


				try {
					log.debug("[F ]check list --> checkList.getAFFlagSostGen2(): "+checkList.getAFFlagSostGen2());
					if(checkList.getAFFlagSostGen2()){
						rapportoTipo2.setFFlgSostituzSistemiReg(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo2.setFFlgSostituzSistemiReg(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {rapportoTipo2.setFFlgSostituzSistemiReg(null);}
				//SEZIONE C.TRATTAMENTO ACQUA
				try {
					if(trattamentoAcqua.getACFlagTrattH2ONR()){
						rapportoTipo2.setCFlgTrattClimaNonRichiest(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo2.setCFlgTrattClimaNonRichiest(new BigDecimal(Constants.NO_0));
					}
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] END -->  sezione F.check list legata a sigit_t_rapp_tipo1");
				}catch (Exception e) {rapportoTipo2.setCFlgTrattClimaNonRichiest(null);}


				//sezione D.controllo dell'impianto
				it.csi.sigit.sigitwebn.xml.allegato3.data.ControlloImpiantoDocument.ControlloImpianto controlloImpianto = allegatoIII.getControlloImpianto();

				try {
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLocaleIdoneoSI(): "+controlloImpianto.getADFlagLocaleIdoneoSI());
					if(controlloImpianto.getADFlagLocaleIdoneoSI()){
						rapportoTipo2.setDFlgLocaleIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagLocaleIdoneoNO()){
						rapportoTipo2.setDFlgLocaleIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagLocaleIdoneoNC()){
						rapportoTipo2.setDFlgLocaleIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo2.setDFlgLocaleIdoneo(null);}

				try {
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagDimensioniSI(): "+controlloImpianto.getADFlagDimensioniSI());
					if(controlloImpianto.getADFlagDimensioniSI()){
						rapportoTipo2.setDFlgApertureAdeg(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagDimensioniNO()){
						rapportoTipo2.setDFlgApertureAdeg(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagDimensioniNC()){
						rapportoTipo2.setDFlgApertureAdeg(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo2.setDFlgApertureAdeg(null);}


				try {
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagApertureSI(): "+controlloImpianto.getADFlagApertureSI());
					if(controlloImpianto.getADFlagApertureSI()){
						rapportoTipo2.setDFlgApertureLibere(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagApertureNO()){
						rapportoTipo2.setDFlgApertureLibere(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagApertureNC()){
						rapportoTipo2.setDFlgApertureLibere(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo2.setDFlgApertureLibere(null);}


				try {
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLineeIdoneeSI(): "+controlloImpianto.getADFlagLineeIdoneeSI());
					if(controlloImpianto.getADFlagLineeIdoneeSI()){
						rapportoTipo2.setDFlgLineaElettIdonea(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagLineeIdoneeNO()){
						rapportoTipo2.setDFlgLineaElettIdonea(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagLineeIdoneeNC()){
						rapportoTipo2.setDFlgLineaElettIdonea(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo2.setDFlgLineaElettIdonea(null);}


				try {
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagCoibenIdoneeSI(): "+controlloImpianto.getADFlagCoibenIdoneeSI());
					if(controlloImpianto.getADFlagCoibenIdoneeSI()){
						rapportoTipo2.setDFlgCoibIdonea(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagCoibenIdoneeNO()){
						rapportoTipo2.setDFlgCoibIdonea(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagCoibenIdoneeNC()){
						rapportoTipo2.setDFlgCoibIdonea(new BigDecimal(Constants.NC_2));
					}
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] END -->  sezione D.controllo dell'impianto legata a sigit_t_rapp_tipo2");
				}catch (Exception e) {rapportoTipo2.setDFlgCoibIdonea(null);}


				//INSERISCO nella tabella SIGIT_RAPP_TIPO2
				rapportoTipo2.setIdAllegato(allegato.getIdAllegato());
				//controllo che non ci sia alcun record con questo id
				SigitTRappTipo2Pk pk = new SigitTRappTipo2Pk();
				pk.setIdAllegato(allegato.getIdAllegato());
				SigitTRappTipo2Dto dettaglioRapportoTipo2 = getDbMgr().getSigitTRappTipo2Dao().findByPrimaryKey(pk);
				if(dettaglioRapportoTipo2!=null){
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] END --> UPDATE SU sigit_t_rapp_tipo2");
					//NON FACCIO ALCUN UPDATE PERCHE' AL SECONDO GIRO L'OGGETTO ROWALLEGATOIII NON HA TUTTI I CAMPI VALORIZZATI
				}else{
					getDbMgr().getSigitTRappTipo2Dao().insert(rapportoTipo2);
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] END --> INSERT SU sigit_t_rapp_tipo2");
				}

				//sezione E.controllo e verifica energetica  del gruppo termico
				it.csi.sigit.sigitwebn.xml.allegato3.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVerificaEnergetica = allegatoIII.getControlloVerificaEnergetica();
				SigitTDettTipo2Dto sigitTDettTipo2Dto = new SigitTDettTipo2Dto();

				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagPerditeSI(): "+controlloVerificaEnergetica.getAEFlagPerditeSI());
				if(controlloVerificaEnergetica.getAEFlagPerditeSI()){
					sigitTDettTipo2Dto.setEFlgPerditaGas(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagPerditeNO()){
					sigitTDettTipo2Dto.setEFlgPerditaGas(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagPerditeNC()){
					sigitTDettTipo2Dto.setEFlgPerditaGas(new BigDecimal(Constants.NC_2));
				}
				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagRilevFugheDirettaSI(): "+controlloVerificaEnergetica.getAEFlagRilevFugheDirettaSI());
				if(controlloVerificaEnergetica.getAEFlagRilevFugheDirettaSI()){
					sigitTDettTipo2Dto.setEFlgLeakDetector(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagRilevFugheDirettaNO()){
					sigitTDettTipo2Dto.setEFlgLeakDetector(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagRilevFugheDirettaNC()){
					sigitTDettTipo2Dto.setEFlgLeakDetector(new BigDecimal(Constants.NC_2));
				}
				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaSI(): "+controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaSI());
				if(controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaSI()){
					sigitTDettTipo2Dto.setEFlgParamTermodinam(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaNO()){
					sigitTDettTipo2Dto.setEFlgParamTermodinam(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaNO()){
					sigitTDettTipo2Dto.setEFlgParamTermodinam(new BigDecimal(Constants.NC_2));
				}
				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagScambPulitiSI(): "+controlloVerificaEnergetica.getAEFlagScambPulitiSI());
				if(controlloVerificaEnergetica.getAEFlagScambPulitiSI()){
					sigitTDettTipo2Dto.setEFlgIncrostazioni(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagScambPulitiNO()){
					sigitTDettTipo2Dto.setEFlgIncrostazioni(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagScambPulitiNC()){
					sigitTDettTipo2Dto.setEFlgIncrostazioni(new BigDecimal(Constants.NC_2));
				}

				if(controlloVerificaEnergetica.getAEFlagRaffr()){
					sigitTDettTipo2Dto.setEFlgModProva(Constants.FLAG_MODALITA_RAFFRESCAMENTO);
				}
				if(controlloVerificaEnergetica.getAEFlagRisc()){
					sigitTDettTipo2Dto.setEFlgModProva(Constants.FLAG_MODALITA_RISCALDAMENTO);
				}

				sigitTDettTipo2Dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
				sigitTDettTipo2Dto.setFkAllegato(allegato.getIdAllegato());
				sigitTDettTipo2Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
				sigitTDettTipo2Dto.setUtenteUltMod(cfUtenteLoggato);
				sigitTDettTipo2Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_GF);
				try{sigitTDettTipo2Dto.setProgressivo(ConvertUtil.convertToBigDecimal(allegatoIII.getAENumGF()));}catch (Exception e) {sigitTDettTipo2Dto.setProgressivo(null);}
				try{sigitTDettTipo2Dto.setDataInstall(DateUtil.getSqlDate(allegatoIII.getAEDataInstallaz()));}catch (Exception e) {sigitTDettTipo2Dto.setDataInstall(null);}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] END --> sezione E.controllo e verifica energetica  del gruppo termico sigit_t_DETT_tipo2");
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] BEGIN --> sezione E.controllo e verifica energetica tab fumi del gruppo termico sigit_t_DETT_tipo1");
				it.csi.sigit.sigitwebn.xml.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII.TabFumi	tabFumi = allegatoIII.getTabFumi();
				List<it.csi.sigit.sigitwebn.xml.allegato3.data.RowFumiDocument.RowFumi> rigaFumi = tabFumi.getRowFumiList();
				if(rigaFumi!=null && rigaFumi.size()>0){
					log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO III LUNGHEZZA LISTA: "+rigaFumi.size());
					int count = 0;
					 for(it.csi.sigit.sigitwebn.xml.allegato3.data.RowFumiDocument.RowFumi dto : rigaFumi){
						 log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO III count: "+count);
						 try{ sigitTDettTipo2Dto.setETSurriscC(dto.getAESurrisc());}catch (Exception e) {sigitTDettTipo2Dto.setETSurriscC(null);}
						 try{ sigitTDettTipo2Dto.setETSottorafC(dto.getAESottoRaffr());}catch (Exception e) {sigitTDettTipo2Dto.setETSurriscC(null);}
						 try{ sigitTDettTipo2Dto.setETCondensazioneC(dto.getAECondens());}catch (Exception e) {sigitTDettTipo2Dto.setETCondensazioneC(null);}
						 try{ sigitTDettTipo2Dto.setETEvaporazioneC(dto.getAEEvaporaz());}catch (Exception e) {sigitTDettTipo2Dto.setETEvaporazioneC(null);}
						 try{ sigitTDettTipo2Dto.setETInExtC(dto.getAEIngLatoEst());}catch (Exception e) {sigitTDettTipo2Dto.setETInExtC(null);}
						 try{ sigitTDettTipo2Dto.setETOutExtC(dto.getAEUscLatoEst());}catch (Exception e) {sigitTDettTipo2Dto.setETOutExtC(null);}
						 try{ sigitTDettTipo2Dto.setETInUtenzeC(dto.getAEIngLatoUtenze());}catch (Exception e) {sigitTDettTipo2Dto.setETInUtenzeC(null);}
						 try{ sigitTDettTipo2Dto.setETOutUtenzeC(dto.getAEUscLatoUtenze());}catch (Exception e) {sigitTDettTipo2Dto.setETOutUtenzeC(null);}
						 try{ sigitTDettTipo2Dto.setENCircuito(ConvertUtil.convertToString(dto.getAENumCircuito()));}catch (Exception e) {sigitTDettTipo2Dto.setENCircuito(null);}

						 //INSERISCO
						 getDbMgr().getSigitTDettTipo2Dao().insert(sigitTDettTipo2Dto);

						 count++;
					 }
				}
				//devo tracciaare il fatto che sono entrata la prima volta
//				flagControllo = true;
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] END dentro il for");
			}

			log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] END --> INSERT SU sigit_t_DETT_tipo2");
			//adesso devo aggiornare la parte di libretto che e' dedicata esclusivamente all'allegato
			//mi trovo l'ultimo libretto aggiornato e creo una copia di questo sulla tabella
			//dopodiche' mi vado a richiamare il metodo che scrive il libretto e lo consolida

//			SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
			//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
//			recordLibretto.setCfRedattore(cfUtenteLoggato);
//			recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
//			recordLibretto.setUtenteUltMod(cfUtenteLoggato);
//			recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
//			//inserisco
//			getDbMgr().inserisciLibretto(recordLibretto);

			log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] END --> INSERT SU sigit_t_libretto");
			//adesso eseguo i punti 4, 5, 6 dell'algoritmo A002_7 riferito al libretto
			//this.creaPdfEConsolidaLibretto(cfUtenteLoggato, impianto, codiceRea, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO);
		}catch(Exception e){
			log.error("eccezione salvaInfoDaXmlAllegato2Respinto --> "+e.getMessage(),e);
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));

		}
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato2Respinto] END");
	}
	*/
	/*
	public void salvaInfoDaXmlAllegato3Respinto(MODIVDocument modAllegatoTipo3,
			SigitTAllegatoDto allegato, String cfUtenteLoggato)throws ManagerException {
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato3Respinto] BEGIN");

		//aggiorniamo di nuovo la tabella SIGIT_T_ALLEGATO con gli altri elementi aggiuntivi sia dell'xml che le informazioni dell'utente
		it.csi.sigit.sigitwebn.xml.allegato4.data.RichiestaDocument.Richiesta richiesta = modAllegatoTipo3.getMODIV().getRichiesta();
		String codiceImpianto = richiesta.getDatiAllegato().getAllegatoIV().getRowAllegatoIVArray(0).getCodiceCatasto();

		//sezione B.documentazione tecnica a corredo
		List<RowAllegatoIV> allegatoIVList = richiesta.getDatiAllegato().getAllegatoIV().getRowAllegatoIVList();

		try{
			log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] lubghezza rowAllegatiIII --> "+allegatoIVList.size());
			for(RowAllegatoIV allegatoIV: allegatoIVList){
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3Respinto] entro nel for RowAllegatoIV");

				//RowAllegatoIV allegatoIV = allegatoIVList.get(0);
				it.csi.sigit.sigitwebn.xml.allegato4.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = allegatoIV.getDocumentazioneTecnica();
				it.csi.sigit.sigitwebn.xml.allegato4.data.TrattamentoAcquaDocument.TrattamentoAcqua trattamentoAcqua =  allegatoIV.getTrattamentoAcqua();

				try{
					if(documentazioneTecnica.getABFlagDichiarazConfNO()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagDichiarazConfSI()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

//				if(documentazioneTecnica.getABFlagDichiarazConfNO()){
//					allegato.setBFlgDichiarConform(new BigDecimal(Constants.NO_0));
//				}
//				if(documentazioneTecnica.getABFlagDichiarazConfSI()){
//					allegato.setBFlgDichiarConform(new BigDecimal(Constants.SI_1));
//				}

				try{
					if(documentazioneTecnica.getABFlagLibrettoCompNO()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagLibrettoCompSI()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}


//				if(documentazioneTecnica.getABFlagLibrettoCompNO()){
//					allegato.setBFlgLibCompl(new BigDecimal(Constants.NO_0));
//				}
//				if(documentazioneTecnica.getABFlagLibrettoCompSI()){
//					allegato.setBFlgLibCompl(new BigDecimal(Constants.SI_1));
//				}

				try{
					if(documentazioneTecnica.getABFlagLibrettoImpNO()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagLibrettoImpSI()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

//				if(documentazioneTecnica.getABFlagLibrettoImpNO()){
//					allegato.setBFlgLibImp(new BigDecimal(Constants.NO_0));
//				}
//				if(documentazioneTecnica.getABFlagLibrettoImpSI()){
//					allegato.setBFlgLibImp(new BigDecimal(Constants.SI_1));
//				}

				try{
					if(documentazioneTecnica.getABFlagManutGenNO()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagManutGenSI()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

//				if(documentazioneTecnica.getABFlagManutGenNO()){
//					allegato.setBFlgLibrettoUso(new BigDecimal(Constants.NO_0));
//				}
//				if(documentazioneTecnica.getABFlagManutGenSI()){
//					allegato.setBFlgLibrettoUso(new BigDecimal(Constants.SI_1));
//				}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3Respinto] END --> B. documentazione tecnica a corredo");

				//sezione F.check list
				it.csi.sigit.sigitwebn.xml.allegato4.data.CheckListDocument.CheckList checkList = allegatoIV.getCheckList();
				log.debug("[F ]check list --> checkList.getAFOsservazioni(): "+checkList.getAFOsservazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni())){
					allegato.setFOsservazioni(checkList.getAFOsservazioni());
				}
				log.debug("[F]check list --> checkList.getAFRaccomandazioni(): "+checkList.getAFRaccomandazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni())){
					allegato.setFRaccomandazioni(checkList.getAFRaccomandazioni());
				}
				log.debug("[F ]check list --> checkList.getAFPrescrizioni(): "+checkList.getAFPrescrizioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni())){
					allegato.setFPrescrizioni(checkList.getAFPrescrizioni());
				}

				it.csi.sigit.sigitwebn.xml.allegato4.data.DatiTecnicoDocument.DatiTecnico datiTecnico = allegatoIV.getDatiTecnico();
				try{
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpNO(): "+datiTecnico.getAFFlagFunzImpNO());
				if(datiTecnico.getAFFlagFunzImpNO()){
					allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.NO_0));
				}
				}catch (Exception e) {}
				try{
					log.debug("[F]check list --> datiTecnico.getAFFlagFunzImpSI(): "+datiTecnico.getAFFlagFunzImpSI());
				if(datiTecnico.getAFFlagFunzImpSI()){
					allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.SI_1));
				}
			}catch (Exception e) {}
				try{allegato.setFInterventoEntro(DateUtil.getSqlDate(datiTecnico.getAFDataIntervento()));}catch (Exception e) {allegato.setFInterventoEntro(null);}


				try{
					log.debug("[F ]check list --> datiTecnico.getAFOrarioArrivo(): "+datiTecnico.getAFOrarioArrivo());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioArrivo())){
					allegato.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
				}
				}catch (Exception e) {allegato.setFOraArrivo(null);}

				try{
					log.debug("[F]check list --> datiTecnico.getAFOrarioPartenza(): "+datiTecnico.getAFOrarioPartenza());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioPartenza())){
					allegato.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
				}
				}catch (Exception e) {allegato.setFOraPartenza(null);}
				log.debug("[F ]check list --> datiTecnico.getAFNomeTecnico(): "+datiTecnico.getAFNomeTecnico());
				log.debug("[F]check list --> datiTecnico.getAFCognomeTecnico(): "+datiTecnico.getAFCognomeTecnico());
				allegato.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));
				try{
					log.debug("[F]check list --> datiTecnico.getAFFirmaTecnico(): "+datiTecnico.getAFFirmaTecnico());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
					allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
				}else{
					allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
				}
				}catch (Exception e) {allegato.setFFlgFirmaTecnico(null);}
				try{
					log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
						allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
					}else{
						allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {allegato.setFFlgFirmaResponsabile(null);}

				getDbMgr().getSigitTAllegatoDao().update(allegato);


				//Non so ancora cosa settare a livello di flg_controllo_bozza????
//				allegato.setFlgControlloBozza(new BigDecimal(Constants.SI_1));
//				allegato.setDataUltMod(DateUtil.getSqlDataCorrente());
//				allegato.setUtenteUltMod(cfUtenteLoggato);

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3Respinto] END --> F.check list per  sigit_t_allegato");
				//aggiorno la tabella SIGIT_T_ALLEGATO

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3Respinto] END --> update su  sigit_t_allegato");

				SigitTRappTipo3Dto rapportoTipo3 = new SigitTRappTipo3Dto();
				//		log.debug("[F ]check list --> checkList.getAFFlagIsolamentoCanali(): "+checkList.getAFFlagIsolamentoCanali());
				//		//attenzione parte legata a sigit_t_rapp_tipo3
				//		if(checkList.getAFFlagIsolamentoCanali()){
				//			rapportoTipo3.setFFlgIsolDistribuzH2o(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo3.setFFlgIsolDistribuzH2o(new BigDecimal(Constants.NO_0));
				//		}
				//		log.debug("[F ]check list --> checkList.getAFFlagIsolamentoRete(): "+checkList.getAFFlagIsolamentoRete());
				//		if(checkList.getAFFlagIsolamentoRete()){
				//			rapportoTipo3.setFFlgIsolDistribuzAria(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo3.setFFlgIsolDistribuzAria(new BigDecimal(Constants.NO_0));
				//		}
				//		log.debug("[F ]check list --> checkList.getAFFlagSostGen1(): "+checkList.getAFFlagSostGen1());
				//		if(checkList.getAFFlagSostGen1()){
				//			rapportoTipo3.setFFlgSostituzGeneratori(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo3.setFFlgSostituzGeneratori(new BigDecimal(Constants.NO_0));
				//		}
				//		log.debug("[F ]check list --> checkList.getAFFlagSostGen2(): "+checkList.getAFFlagSostGen2());
				//		if(checkList.getAFFlagSostGen2()){
				//			rapportoTipo3.setFFlgSostituzSistemiReg(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo3.setFFlgSostituzSistemiReg(new BigDecimal(Constants.NO_0));
				//		}


				//SEZIONE C.TRATTAMENTO ACQUA
				try{
				if(trattamentoAcqua.getACFlagTrattH2ONR()){
					rapportoTipo3.setCFlgTrattClimaNonRichiest(new BigDecimal(Constants.SI_1));
				}else{
					rapportoTipo3.setCFlgTrattClimaNonRichiest(new BigDecimal(Constants.NO_0));
				}
				}catch (Exception e) {rapportoTipo3.setCFlgTrattClimaNonRichiest(null);}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3Respinto] END -->  sezione F.check list legata a sigit_t_rapp_tipo3");

				//sezione D.controllo dell'impianto
				it.csi.sigit.sigitwebn.xml.allegato4.data.ControlloImpiantoDocument.ControlloImpianto controlloImpianto = allegatoIV.getControlloImpianto();

				log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLuogoIdoneoSI(): "+controlloImpianto.getADFlagLuogoIdoneoSI());
				try{
					if(controlloImpianto.getADFlagLuogoIdoneoSI()){
						rapportoTipo3.setDFlgLocaleIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagLuogoIdoneoNO()){
						rapportoTipo3.setDFlgLocaleIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagLuogoIdoneoNC()){
						rapportoTipo3.setDFlgLocaleIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo3.setDFlgLocaleIdoneo(null);}
				//		log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagDimensioniSI(): "+controlloImpianto.getADFlagDimensioniSI());
				//		if(controlloImpianto.getADFlagDimensioniSI()){
				//			rapportoTipo3.setDFlgApertureAdeg(new BigDecimal(Constants.SI_1));
				//		}else if(controlloImpianto.getADFlagDimensioniNO()){
				//			rapportoTipo3.setDFlgApertureAdeg(new BigDecimal(Constants.NO_0));
				//		}else if(controlloImpianto.getADFlagDimensioniNC()){
				//			rapportoTipo3.setDFlgApertureAdeg(new BigDecimal(Constants.NC_2));
				//		}

				//		log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagApertureSI(): "+controlloImpianto.getADFlagApertureSI());
				//		if(controlloImpianto.getADFlagApertureSI()){
				//			rapportoTipo3.setDFlgApertureLibere(new BigDecimal(Constants.SI_1));
				//		}else if(controlloImpianto.getADFlagApertureNO()){
				//			rapportoTipo3.setDFlgApertureLibere(new BigDecimal(Constants.NO_0));
				//		}else if(controlloImpianto.getADFlagApertureNC()){
				//			rapportoTipo3.setDFlgApertureLibere(new BigDecimal(Constants.NC_2));
				//		}

				log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLineeIdoneeSI(): "+controlloImpianto.getADFlagLineeIdoneeSI());
				try{
				if(controlloImpianto.getADFlagLineeIdoneeSI()){
					rapportoTipo3.setDFlgLineaElettIdonea(new BigDecimal(Constants.SI_1));
				}else if(controlloImpianto.getADFlagLineeIdoneeNO()){
					rapportoTipo3.setDFlgLineaElettIdonea(new BigDecimal(Constants.NO_0));
				}else if(controlloImpianto.getADFlagLineeIdoneeNC()){
					rapportoTipo3.setDFlgLineaElettIdonea(new BigDecimal(Constants.NC_2));
				}
				}catch (Exception e) {rapportoTipo3.setDFlgLineaElettIdonea(null);}

				try{
				log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagCoibenIdoneeSI(): "+controlloImpianto.getADFlagStatoCoibenSI());
				if(controlloImpianto.getADFlagStatoCoibenSI()){
					rapportoTipo3.setDFlgCoibIdonea(new BigDecimal(Constants.SI_1));
				}else if(controlloImpianto.getADFlagStatoCoibenNO()){
					rapportoTipo3.setDFlgCoibIdonea(new BigDecimal(Constants.NO_0));
				}else if(controlloImpianto.getADFlagStatoCoibenNC()){
					rapportoTipo3.setDFlgCoibIdonea(new BigDecimal(Constants.NC_2));
				}
				}catch (Exception e) {rapportoTipo3.setDFlgCoibIdonea(null);}

				try{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagPerditeSI(): "+controlloImpianto.getADFlagPerditeSI());
					if(controlloImpianto.getADFlagPerditeSI()){
						rapportoTipo3.setDFlgAssenzaPerdite(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagPerditeNO()){
						rapportoTipo3.setDFlgAssenzaPerdite(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagPerditeNC()){
						rapportoTipo3.setDFlgAssenzaPerdite(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo3.setDFlgAssenzaPerdite(null);}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END -->  sezione D.controllo dell'impianto legata a sigit_t_rapp_tipo2");

				//INSERISCO nella tabella SIGIT_RAPP_TIPO3
				rapportoTipo3.setIdAllegato(allegato.getIdAllegato());

				SigitTRappTipo3Pk pk = new SigitTRappTipo3Pk();
				pk.setIdAllegato(allegato.getIdAllegato());
				//devo controllare se ho un record presente sulla tabella o no
				SigitTRappTipo3Dto dettaglioRappTipo3 = getDbMgr().getSigitTRappTipo3Dao().findByPrimaryKey(pk);
				if(dettaglioRappTipo3!=null){
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato3Respinto] TROVATO RECORD SU sigit_t_rapp_tipo3");
					//non posso fare l'update perche' nelle pagine successive non mi riporta tutti i dati
					//getDbMgr().getSigitTRappTipo1Dao().update(rapportoTipo1);
				}
				else{
					getDbMgr().getSigitTRappTipo3Dao().insert(rapportoTipo3);
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato3Respinto] END --> INSERT SU sigit_t_rapp_tipo3");
				}

				//sezione E.controllo e verifica energetica  del gruppo termico
				it.csi.sigit.sigitwebn.xml.allegato4.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVerificaEnergetica = allegatoIV.getControlloVerificaEnergetica();
				SigitTDettTipo3Dto sigitTDettTipo3Dto = new SigitTDettTipo3Dto();

				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagPotCompSI(): "+controlloVerificaEnergetica.getAEFlagPotCompSI());
				if(controlloVerificaEnergetica.getAEFlagPotCompSI()){
					sigitTDettTipo3Dto.setEFlgPotenzaCompatibile(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagPotCompNO()){
					sigitTDettTipo3Dto.setEFlgPotenzaCompatibile(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagPotCompNC()){
					sigitTDettTipo3Dto.setEFlgPotenzaCompatibile(new BigDecimal(Constants.NC_2));
				}

				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagStatoCoibenSI(): "+controlloVerificaEnergetica.getAEFlagStatoCoibenSI());
				if(controlloVerificaEnergetica.getAEFlagStatoCoibenSI()){
					sigitTDettTipo3Dto.setEFlgCoibIdonea(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagStatoCoibenNO()){
					sigitTDettTipo3Dto.setEFlgCoibIdonea(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagStatoCoibenNC()){
					sigitTDettTipo3Dto.setEFlgCoibIdonea(new BigDecimal(Constants.NC_2));
				}

				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagDispRegSI(): "+controlloVerificaEnergetica.getAEFlagDispRegSI());
				if(controlloVerificaEnergetica.getAEFlagDispRegSI()){
					sigitTDettTipo3Dto.setEFlgDispFunzionanti(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagDispRegNO()){
					sigitTDettTipo3Dto.setEFlgDispFunzionanti(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagDispRegNO()){
					sigitTDettTipo3Dto.setEFlgDispFunzionanti(new BigDecimal(Constants.NC_2));
				}
				//
				//		log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagScambPulitiSI(): "+controlloVerificaEnergetica.getAEFlagScambPulitiSI());
				//		if(controlloVerificaEnergetica.getAEFlagScambPulitiSI()){
				//			sigitTDettTipo3Dto.setEFlgIncrostazioni(new BigDecimal(Constants.SI_1));
				//		}else if(controlloVerificaEnergetica.getAEFlagScambPulitiNO()){
				//			sigitTDettTipo3Dto.setEFlgIncrostazioni(new BigDecimal(Constants.NO_0));
				//		}else if(controlloVerificaEnergetica.getAEFlagScambPulitiNC()){
				//			sigitTDettTipo3Dto.setEFlgIncrostazioni(new BigDecimal(Constants.NC_2));
				//		}
				//
				//		if(controlloVerificaEnergetica.getAEFlagRaffr()){
				//			sigitTDettTipo3Dto.setEFlgModProva(Constants.FLAG_MODALITA_RAFFRESCAMENTO);
				//		}
				//		if(controlloVerificaEnergetica.getAEFlagRisc()){
				//			sigitTDettTipo3Dto.setEFlgModProva(Constants.FLAG_MODALITA_RISCALDAMENTO);
				//		}

				sigitTDettTipo3Dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
				sigitTDettTipo3Dto.setFkAllegato(allegato.getIdAllegato());
				sigitTDettTipo3Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
				sigitTDettTipo3Dto.setUtenteUltMod(cfUtenteLoggato);
				sigitTDettTipo3Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_SC);
				try{sigitTDettTipo3Dto.setProgressivo(ConvertUtil.convertToBigDecimal(allegatoIV.getAENumSC()));}catch (Exception e) {sigitTDettTipo3Dto.setProgressivo(null);}
				try{sigitTDettTipo3Dto.setDataInstall(DateUtil.getSqlDate(allegatoIV.getAEDataInstallaz()));}catch (Exception e) {sigitTDettTipo3Dto.setDataInstall(null);}

				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagClimatizInv(): "+controlloVerificaEnergetica.getAEFlagClimatizInv());
				if(controlloVerificaEnergetica.getAEFlagClimatizInv()){
					sigitTDettTipo3Dto.setEFlgClimaInverno(new BigDecimal(Constants.SI_1));
				}else{
					sigitTDettTipo3Dto.setEFlgClimaInverno(new BigDecimal(Constants.NO_0));
				}
				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagProduzACS(): "+controlloVerificaEnergetica.getAEFlagProduzACS());
				if(controlloVerificaEnergetica.getAEFlagProduzACS()){
					sigitTDettTipo3Dto.setEFlgProduzAcs(new BigDecimal(Constants.SI_1));
				}else{
					sigitTDettTipo3Dto.setEFlgProduzAcs(new BigDecimal(Constants.NO_0));
				}

				sigitTDettTipo3Dto.setFkFluidoAlimentaz(new BigDecimal(controlloVerificaEnergetica.getAECombustibile()));
				sigitTDettTipo3Dto.setFkFluido(new BigDecimal(controlloVerificaEnergetica.getAEFluidoVett()));


				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3Respinto] END --> sezione E.controllo e verifica energetica  del gruppo termico sigit_t_DETT_tipo3");
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3Respinto] BEGIN --> sezione E.controllo e verifica energetica tab fumi del gruppo termico sigit_t_DETT_tipo3");
				it.csi.sigit.sigitwebn.xml.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV.TabFumi	tabFumi = allegatoIV.getTabFumi();
				List<it.csi.sigit.sigitwebn.xml.allegato4.data.RowFumiDocument.RowFumi> rigaFumi = tabFumi.getRowFumiList();
				if(rigaFumi!=null && rigaFumi.size()>0){
					log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO IV LUNGHEZZA LISTA: "+rigaFumi.size());
					for(it.csi.sigit.sigitwebn.xml.allegato4.data.RowFumiDocument.RowFumi dto : rigaFumi){
						try{ sigitTDettTipo3Dto.setETempExtC(dto.getAETempEst());}catch (Exception e) {sigitTDettTipo3Dto.setETempExtC(null);}

						try{ sigitTDettTipo3Dto.setETempMandPrimarioC(dto.getAETempMandPrim());}catch (Exception e) {sigitTDettTipo3Dto.setETempMandPrimarioC(null);}
						try{ sigitTDettTipo3Dto.setETempRitorPrimarioC(dto.getAETempRitPrim());}catch (Exception e) {sigitTDettTipo3Dto.setETempRitorPrimarioC(null);}
						try{ sigitTDettTipo3Dto.setEPotenzaTermKw(dto.getAEPotenzaTerm());}catch (Exception e) {sigitTDettTipo3Dto.setEPotenzaTermKw(null);}
						try{ sigitTDettTipo3Dto.setEPortFluidoM3H(dto.getAEPortataFluido());}catch (Exception e) {sigitTDettTipo3Dto.setEPortFluidoM3H(null);}
						try{ sigitTDettTipo3Dto.setETempMandSecondarioC(dto.getAETempMandSecond());}catch (Exception e) {sigitTDettTipo3Dto.setETempMandSecondarioC(null);}
						try{ sigitTDettTipo3Dto.setETempRitSecondarioC(dto.getAETempRitSecond());}catch (Exception e) {sigitTDettTipo3Dto.setETempRitSecondarioC(null);}

						//INSERISCO
						getDbMgr().getSigitTDettTipo3Dao().insert(sigitTDettTipo3Dto);
						log.debug("[SigitMgr::salvaInfoDaXmlAllegato3Respinto] END --> INSERT SU sigit_t_DETT_tipo3");

					}
				}
				//devo tracciaare il fatto che sono entrata la prima volta
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3Respinto] END dentro il for");
			}



		//adesso devo aggiornare la parte di libretto che e' dedicata esclusivamente all'allegato
		//mi trovo l'ultimo libretto aggiornato e creo una copia di questo sulla tabella
		//dopodiche' mi vado a richiamare il metodo che scrive il libretto e lo consolida

//		SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
//		//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
//		recordLibretto.setCfRedattore(cfUtenteLoggato);
//		recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
//		recordLibretto.setUtenteUltMod(cfUtenteLoggato);
//		recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
//		//inserisco
//		getDbMgr().inserisciLibretto(recordLibretto);
//
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato3Respinto] END --> INSERT SU sigit_t_libretto");
		//adesso eseguo i punti 4, 5, 6 dell'algoritmo A002_7 riferito al libretto
//		this.creaPdfEConsolidaLibretto(cfUtenteLoggato, impianto, codiceRea, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO);

		}catch(Exception e){
			log.error("eccezione salvaInfoDaXmlAllegato3Respinto --> "+e.getMessage(),e);
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato3Respinto] END");
	}
	*/
	/*
	public void salvaInfoDaXmlAllegato4Respinto(MODVDocument modAllegatoTipo4,
			SigitTAllegatoDto allegato, String cfUtenteLoggato)throws ManagerException {
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato4Respinto] BEGIN");

		//aggiorniamo di nuovo la tabella SIGIT_T_ALLEGATO con gli altri elementi aggiuntivi sia dell'xml che le informazioni dell'utente
		it.csi.sigit.sigitwebn.xml.allegato5.data.RichiestaDocument.Richiesta richiesta = modAllegatoTipo4.getMODV().getRichiesta();
		String codiceImpianto = richiesta.getDatiAllegato().getAllegatoV().getRowAllegatoVArray(0).getCodiceCatasto();

		//sezione B.documentazione tecnica a corredo
		List<RowAllegatoV> allegatoVList = richiesta.getDatiAllegato().getAllegatoV().getRowAllegatoVList();

		try{
			log.debug("[SigitMgr::salvaInfoDaXmlAllegato4Respinto] lubghezza rowAllegatiV --> "+allegatoVList.size());
			for(RowAllegatoV allegatoV: allegatoVList){
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4Respinto] entro nel for RowAllegatoV");



				it.csi.sigit.sigitwebn.xml.allegato5.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = allegatoV.getDocumentazioneTecnica();
//				it.csi.sigit.sigitwebn.xml.allegato5.data.TrattamentoAcquaDocument.TrattamentoAcqua trattamentoAcqua =  allegatoV.getTrattamentoAcqua();

				try{
					if(documentazioneTecnica.getABFlagDichiarazConfNO()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagDichiarazConfSI()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagLibrettoCompNO()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagLibrettoCompSI()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagLibrettoImpNO()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagLibrettoImpSI()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagManutGenNO()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagManutGenSI()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> B. documentazione tecnica a corredo");

				//sezione F.check list
				it.csi.sigit.sigitwebn.xml.allegato5.data.CheckListDocument.CheckList checkList = allegatoV.getCheckList();
				log.debug("[F ]check list --> checkList.getAFOsservazioni(): "+checkList.getAFOsservazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni())){
					allegato.setFOsservazioni(checkList.getAFOsservazioni());
				}
				log.debug("[F]check list --> checkList.getAFRaccomandazioni(): "+checkList.getAFRaccomandazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni())){
					allegato.setFRaccomandazioni(checkList.getAFRaccomandazioni());
				}
				log.debug("[F ]check list --> checkList.getAFPrescrizioni(): "+checkList.getAFPrescrizioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni())){
					allegato.setFPrescrizioni(checkList.getAFPrescrizioni());
				}

				it.csi.sigit.sigitwebn.xml.allegato5.data.DatiTecnicoDocument.DatiTecnico datiTecnico = allegatoV.getDatiTecnico();

				try{
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpNO(): "+datiTecnico.getAFFlagFunzImpNO());

					if(datiTecnico.getAFFlagFunzImpNO()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					log.debug("[F]check list --> datiTecnico.getAFFlagFunzImpSI(): "+datiTecnico.getAFFlagFunzImpSI());
					if(datiTecnico.getAFFlagFunzImpSI()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				try{allegato.setFInterventoEntro(DateUtil.getSqlDate(datiTecnico.getAFDataIntervento()));}catch (Exception e) {allegato.setFInterventoEntro(null);}

				log.debug("[F ]check list --> datiTecnico.getAFOrarioArrivo(): "+datiTecnico.getAFOrarioArrivo());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioArrivo())){
					allegato.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
				}
				log.debug("[F]check list --> datiTecnico.getAFOrarioPartenza(): "+datiTecnico.getAFOrarioPartenza());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioPartenza())){
					allegato.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
				}
				log.debug("[F ]check list --> datiTecnico.getAFNomeTecnico(): "+datiTecnico.getAFNomeTecnico());
				log.debug("[F]check list --> datiTecnico.getAFCognomeTecnico(): "+datiTecnico.getAFCognomeTecnico());
				allegato.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));
				log.debug("[F]check list --> datiTecnico.getAFFirmaTecnico(): "+datiTecnico.getAFFirmaTecnico());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
					allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
				}else{
					allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
				}
				log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
					allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
				}else{
					allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
				}

				//Non so ancora cosa settare a livello di flg_controllo_bozza????
//				allegato.setFlgControlloBozza(new BigDecimal(Constants.SI_1));
//				allegato.setDataUltMod(DateUtil.getSqlDataCorrente());
//				allegato.setUtenteUltMod(cfUtenteLoggato);

				getDbMgr().getSigitTAllegatoDao().update(allegato);

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4Respinto] END --> update su  sigit_t_allegato");

				SigitTRappTipo4Dto rapportoTipo4 = new SigitTRappTipo4Dto();
				//		log.debug("[F ]check list --> checkList.getAFFlagIsolamentoCanali(): "+checkList.getAFFlagIsolamentoCanali());
				//		//attenzione parte legata a sigit_t_rapp_tipo1
				//		if(checkList.getAFFlagIsolamentoCanali()){
				//			rapportoTipo2.setFFlgIsolDistribuzH2o(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo2.setFFlgIsolDistribuzH2o(new BigDecimal(Constants.NO_0));
				//		}
				//		log.debug("[F ]check list --> checkList.getAFFlagIsolamentoRete(): "+checkList.getAFFlagIsolamentoRete());
				//		if(checkList.getAFFlagIsolamentoRete()){
				//			rapportoTipo2.setFFlgIsolDistribuzAria(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo2.setFFlgIsolDistribuzAria(new BigDecimal(Constants.NO_0));
				//		}
				//		log.debug("[F ]check list --> checkList.getAFFlagSostGen1(): "+checkList.getAFFlagSostGen1());
				//		if(checkList.getAFFlagSostGen1()){
				//			rapportoTipo2.setFFlgSostituzGeneratori(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo2.setFFlgSostituzGeneratori(new BigDecimal(Constants.NO_0));
				//		}
				//		log.debug("[F ]check list --> checkList.getAFFlagSostGen2(): "+checkList.getAFFlagSostGen2());
				//		if(checkList.getAFFlagSostGen2()){
				//			rapportoTipo2.setFFlgSostituzSistemiReg(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo2.setFFlgSostituzSistemiReg(new BigDecimal(Constants.NO_0));
				//		}
				//		//SEZIONE C.TRATTAMENTO ACQUA
				//		if(trattamentoAcqua.getACFlagTrattH2ONR()){
				//			rapportoTipo2.setCFlgTrattClimaNonRichiest(new BigDecimal(Constants.SI_1));
				//		}else{
				//			rapportoTipo2.setCFlgTrattClimaNonRichiest(new BigDecimal(Constants.NO_0));
				//		}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4Respinto] END -->  sezione F.check list legata a sigit_t_rapp_tipo1");

				//sezione D.controllo dell'impianto
				it.csi.sigit.sigitwebn.xml.allegato5.data.ControlloImpiantoDocument.ControlloImpianto controlloImpianto = allegatoV.getControlloImpianto();

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLuogoIdoneoSI(): "+controlloImpianto.getADFlagLuogoIdoneoSI());
					if(controlloImpianto.getADFlagLuogoIdoneoSI()){
						rapportoTipo4.setDFlgLuogoIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagLuogoIdoneoNO()){
						rapportoTipo4.setDFlgLuogoIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagLuogoIdoneoNC()){
						rapportoTipo4.setDFlgLuogoIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgLuogoIdoneo(null);}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagDimensioniSI(): "+controlloImpianto.getADFlagDimensioniSI());
					if(controlloImpianto.getADFlagDimensioniSI()){
						rapportoTipo4.setDFlgVentilazAdeg(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagDimensioniNO()){
						rapportoTipo4.setDFlgVentilazAdeg(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagDimensioniNC()){
						rapportoTipo4.setDFlgVentilazAdeg(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgVentilazAdeg(null);}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagApertureSI(): "+controlloImpianto.getADFlagApertureSI());
					if(controlloImpianto.getADFlagApertureSI()){
						rapportoTipo4.setDFlgVentilazLibera(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagApertureNO()){
						rapportoTipo4.setDFlgVentilazLibera(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagApertureNC()){
						rapportoTipo4.setDFlgVentilazLibera(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgVentilazLibera(null);}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLineeIdoneeSI(): "+controlloImpianto.getADFlagLineeIdoneeSI());
					if(controlloImpianto.getADFlagLineeIdoneeSI()){
						rapportoTipo4.setDFlgLineaElettIdonea(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagLineeIdoneeNO()){
						rapportoTipo4.setDFlgLineaElettIdonea(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagLineeIdoneeNC()){
						rapportoTipo4.setDFlgLineaElettIdonea(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgLineaElettIdonea(null);}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagCanaleFumoSI(): "+controlloImpianto.getADFlagCanaleFumoSI());
					if(controlloImpianto.getADFlagCanaleFumoSI()){
						rapportoTipo4.setDFlgCaminoIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagCanaleFumoNO()){
						rapportoTipo4.setDFlgCaminoIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagCanaleFumoNC()){
						rapportoTipo4.setDFlgCaminoIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgCaminoIdoneo(null);}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagCapsulaInsoSI(): "+controlloImpianto.getADFlagCapsulaInsoSI());
					if(controlloImpianto.getADFlagCapsulaInsoSI()){
						rapportoTipo4.setDFlgCapsulaIdonea(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagCapsulaInsoNO()){
						rapportoTipo4.setDFlgCapsulaIdonea(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagCapsulaInsoNC()){
						rapportoTipo4.setDFlgCapsulaIdonea(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgCapsulaIdonea(null);}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagTenutaIdraulicaSI(): "+controlloImpianto.getADFlagTenutaIdraulicaSI());
					if(controlloImpianto.getADFlagTenutaIdraulicaSI()){
						rapportoTipo4.setDFlgCircIdrIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagTenutaIdraulicaNO()){
						rapportoTipo4.setDFlgCircIdrIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagTenutaIdraulicaNC()){
						rapportoTipo4.setDFlgCircIdrIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgCircIdrIdoneo(null);}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagTenutaOlioSI(): "+controlloImpianto.getADFlagTenutaOlioSI());
					if(controlloImpianto.getADFlagTenutaOlioSI()){
						rapportoTipo4.setDFlgCircOlioIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagTenutaOlioNO()){
						rapportoTipo4.setDFlgCircOlioIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagTenutaOlioNC()){
						rapportoTipo4.setDFlgCircOlioIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgCircOlioIdoneo(null);}


				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagTenutaAlimentazSI(): "+controlloImpianto.getADFlagTenutaAlimentazSI());
					if(controlloImpianto.getADFlagTenutaAlimentazSI()){
						rapportoTipo4.setDFlgCircCombIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagTenutaAlimentazNO()){
						rapportoTipo4.setDFlgCircCombIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagTenutaAlimentazNC()){
						rapportoTipo4.setDFlgCircCombIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgCircCombIdoneo(null);}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagFunzionalitaSI(): "+controlloImpianto.getADFlagFunzionalitaSI());
					if(controlloImpianto.getADFlagFunzionalitaSI()){
						rapportoTipo4.setDFlgFunzScambIdonea(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagFunzionalitaNO()){
						rapportoTipo4.setDFlgFunzScambIdonea(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagFunzionalitaNC()){
						rapportoTipo4.setDFlgFunzScambIdonea(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {rapportoTipo4.setDFlgFunzScambIdonea(null);}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END -->  sezione D.controllo dell'impianto legata a sigit_t_rapp_tipo2");

				//INSERISCO nella tabella SIGIT_RAPP_TIPO4
				rapportoTipo4.setIdAllegato(allegato.getIdAllegato());

				SigitTRappTipo4Pk pk = new SigitTRappTipo4Pk();
				pk.setIdAllegato(allegato.getIdAllegato());
				//devo controllare se ho un record presente sulla tabella o no
				SigitTRappTipo4Dto dettaglioRappTipo4 = getDbMgr().getSigitTRappTipo4Dao().findByPrimaryKey(pk);
				if(dettaglioRappTipo4!=null){
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato4Respinto] TROVATO RECORD SU sigit_t_rapp_tipo4");
					//non posso fare l'update perche' nelle pagine successive non mi riporta tutti i dati
				}
				else{
					getDbMgr().getSigitTRappTipo4Dao().insert(rapportoTipo4);
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato4Respinto] END --> INSERT SU sigit_t_rapp_tipo4");
				}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4Respinto] END --> INSERT SU sigit_t_rapp_tipo4");

				//sezione E.controllo e verifica energetica  del gruppo termico
				it.csi.sigit.sigitwebn.xml.allegato5.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVerificaEnergetica = allegatoV.getControlloVerificaEnergetica();
				SigitTDettTipo4Dto sigitTDettTipo4Dto = new SigitTDettTipo4Dto();



				sigitTDettTipo4Dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
				sigitTDettTipo4Dto.setFkAllegato(allegato.getIdAllegato());
				sigitTDettTipo4Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
				sigitTDettTipo4Dto.setUtenteUltMod(cfUtenteLoggato);
				sigitTDettTipo4Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_CG);
				try{sigitTDettTipo4Dto.setProgressivo(ConvertUtil.convertToBigDecimal(allegatoV.getAENumCG()));}catch (Exception e) {sigitTDettTipo4Dto.setProgressivo(null);}
				try{sigitTDettTipo4Dto.setDataInstall(DateUtil.getSqlDate(allegatoV.getAEDataInstallaz()));}catch (Exception e) {sigitTDettTipo4Dto.setDataInstall(null);}

				sigitTDettTipo4Dto.setFkFluido(new BigDecimal(controlloVerificaEnergetica.getAEFluidoVett()));


				try{sigitTDettTipo4Dto.setEPotenzaAssorbCombKw(allegatoV.getAEPotenzaAssorbita());}catch (Exception e) {sigitTDettTipo4Dto.setEPotenzaAssorbCombKw(null);}
				try{sigitTDettTipo4Dto.setEPotenzaTermBypassKw(allegatoV.getAEPotenzaTermByPass());}catch (Exception e) {sigitTDettTipo4Dto.setEPotenzaTermBypassKw(null);}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4Respinto] END --> sezione E.controllo e verifica energetica  del gruppo termico sigit_t_DETT_tipo4");

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4Respinto] BEGIN --> sezione E.controllo e verifica energetica tab fumi del gruppo termico sigit_t_DETT_tipo4");
				it.csi.sigit.sigitwebn.xml.allegato5.data.RowAllegatoVDocument.RowAllegatoV.TabFumi	tabFumi = allegatoV.getTabFumi();
				List<it.csi.sigit.sigitwebn.xml.allegato5.data.RowFumiDocument.RowFumi> rigaFumi = tabFumi.getRowFumiList();
				if(rigaFumi!=null && rigaFumi.size()>0){
					log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO V LUNGHEZZA LISTA: "+rigaFumi.size());
					int count = 0;
					for(it.csi.sigit.sigitwebn.xml.allegato5.data.RowFumiDocument.RowFumi dto : rigaFumi){
						log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO V count: "+count);

						try{ sigitTDettTipo4Dto.setETempAriaC(dto.getAETempAriaCombur());}catch (Exception e) {sigitTDettTipo4Dto.setETempAriaC(null);}

						try{ sigitTDettTipo4Dto.setETempH2oInC(dto.getAETempAriaIng());}catch (Exception e) {sigitTDettTipo4Dto.setETempH2oInC(null);}
						try{ sigitTDettTipo4Dto.setETempH2oOutC(dto.getAETempAriaUsc());}catch (Exception e) {sigitTDettTipo4Dto.setETempH2oOutC(null);}


						try{ sigitTDettTipo4Dto.setEPotenzaMorsettiKw(dto.getAEPotenzaMorsetti());}catch (Exception e) {sigitTDettTipo4Dto.setEPotenzaMorsettiKw(null);}
						try{ sigitTDettTipo4Dto.setETempH2oMotoreC(dto.getAETempH2Omotore());}catch (Exception e) {sigitTDettTipo4Dto.setETempH2oMotoreC(null);}
						try{ sigitTDettTipo4Dto.setETempFumiValleC(dto.getAETempFumiAvalle());}catch (Exception e) {sigitTDettTipo4Dto.setETempFumiValleC(null);}
						try{ sigitTDettTipo4Dto.setETempFumiMonteC(dto.getAETempFumiAmonte());}catch (Exception e) {sigitTDettTipo4Dto.setETempFumiMonteC(null);}

						//INSERISCO
						getDbMgr().getSigitTDettTipo4Dao().insert(sigitTDettTipo4Dto);

						count++;
					}
				}

				//devo tracciaare il fatto che sono entrata la prima volta
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4Respinto] END dentro il for");
			}

			log.debug("[SigitMgr::salvaInfoDaXmlAllegato4Respinto] END --> INSERT SU sigit_t_DETT_tipo4");

			//adesso devo aggiornare la parte di libretto che e' dedicata esclusivamente all'allegato
			//mi trovo l'ultimo libretto aggiornato e creo una copia di questo sulla tabella
			//dopodiche' mi vado a richiamare il metodo che scrive il libretto e lo consolida

//			SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
//			//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
//			recordLibretto.setCfRedattore(cfUtenteLoggato);
//			recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
//			recordLibretto.setUtenteUltMod(cfUtenteLoggato);
//			recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
//			//inserisco
//			getDbMgr().inserisciLibretto(recordLibretto);

			log.debug("[SigitMgr::salvaInfoDaXmlAllegato4Respinto] END --> INSERT SU sigit_t_libretto");
			//adesso eseguo i punti 4, 5, 6 dell'algoritmo A002_7 riferito al libretto
//			this.creaPdfEConsolidaLibretto(cfUtenteLoggato, impianto, codiceRea, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO);

		}catch(Exception e){
			log.error("eccezione salvaInfoDaXmlAllegato4Respinto --> "+e.getMessage(),e);
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));

		}
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END");
	}
	*/
	public SigitTPreImportDto inserisciPreImport(UtenteLoggato utente) throws DbManagerException
	{
		log.debug("inserisciPreImport START");
		SigitTPreImportDto dto = new SigitTPreImportDto();
		try {
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());
			dto.setIdPersonaFisica(ConvertUtil.convertToBigDecimal(utente.getIdPersonaFisica()));
			dto.setUtenteUltMod(utente.getCodiceFiscale());
			getDbMgr().inserisciPreImport(dto);
			return dto;
		} catch (DbManagerException e) {
			log.error("Errore",e);
			throw new DbManagerException(new Message(Messages.ERROR_INSERT_DB));
		}
		finally{
			log.debug("inserisciPreImport END");
		}
	}

	public ArrayList<CodeDescription> getListMarche()
	{
		List<SigitDMarcaDto> elencoMarche;
		try {
			elencoMarche = getDbMgr().getElencoMarche();
			return MapDto.mapToCodeDescriptionList(elencoMarche);
		} catch (DbManagerException e) {
			log.error("Errore ",e);
			return new ArrayList<CodeDescription>();
		}
	}

	public ArrayList<CodeDescription> getListTipoComponente()
	{
		log.debug("getListTipoComponente START");
		try {
			List<SigitDTipoComponenteDto> elencoTipiComp = getDbMgr().getElencoTipoComponente();
			return MapDto.mapToCodeDescriptionElencoComponente(elencoTipiComp);
		} catch (DbManagerException e) {
			log.error("Errore ",e);
			return new ArrayList<CodeDescription>();
		}
		finally{
			log.debug("getListTipoComponente END");
		}
	}

	public ArrayList<CodeDescription> getListCombustibile()
	{
		try {
			List<SigitDCombustibileDto> elencoCombu = getDbMgr().getElencoCombustibile();
			return MapDto.mapToCodeDescriptionElencoCombustibile(elencoCombu);
		} catch (DbManagerException e) {
			log.error("Errore ",e);
			return new ArrayList<CodeDescription>();
		}
	}

	public ArrayList<CodeDescription> getListCannaFumaria()
	{
		try {
			List<SigitDTipoCannaFumariaDto> elencoCannaFumaria = getDbMgr().getElencoTipoCannaFumaria();
			return MapDto.mapToCodeDescriptionElencoCannaFumaria(elencoCannaFumaria);
		} catch (DbManagerException e) {
			log.error("Errore ",e);
			return new ArrayList<CodeDescription>();
		}
	}

	public ArrayList<CodeDescription> getListFonteEnergiaSfruttata()
	{
		try {
			List<SigitDFonteEnSfruttataDto> elencoFonteEnergiaSfruttata = getDbMgr().getElencoFonteEnergiaSfruttata();
			return MapDto.mapToCodeDescriptionElencoFonteEnergiaSfruttata(elencoFonteEnergiaSfruttata);
		} catch (DbManagerException e) {
			log.error("Errore ",e);
			return new ArrayList<CodeDescription>();
		}
	}

	public Map<BigDecimal, String> getDizionarioCombustibile() {
		Map<BigDecimal, String> dizionario = new HashMap<BigDecimal, String>();
		try {
			List<SigitDCombustibileDto> elencoCombu = getDbMgr().getElencoCombustibile();
			if (elencoCombu != null) {
				for (SigitDCombustibileDto combu : elencoCombu) {
					dizionario.put(combu.getIdCombustibile(), combu.getDesCombustibile());
				}
			}
		} catch (DbManagerException e) {
			log.error("Errore ",e);
		}
		return dizionario;
	}

	public ArrayList<CodeDescription> getListUnitaMisura()
	{
		try {
			List<SigitDUnitaMisuraDto> elencoUnitaMisura = getDbMgr().getElencoUnitaMisura();
			return MapDto.mapToCodeDescriptionElencoUnitaMisura(elencoUnitaMisura);
		} catch (DbManagerException e) {
			log.error("Errore ",e);
			return new ArrayList<CodeDescription>();
		}
	}

	public ArrayList<IdDescription> getListTipoContrattoDistrib()
	{
		try {
			List<SigitDTipoContrattoDistribDto> elencoTipoContrattoDistrib = getDbMgr().getElencoTipoContrattoDistrib();
			return MapDto.mapToTipoContrattoDistrib(elencoTipoContrattoDistrib);
		} catch (DbManagerException e) {
			log.error("Errore ",e);
			return new ArrayList<IdDescription>();
		}
	}

	public ArrayList<CodeDescription> getListCategoriaUtil()
	{
		try {
			List<SigitDCategoriaUtilDto> elencoCategoriaUtil = getDbMgr().getElencoCategoriaUtil();
			return MapDto.mapToCategoriaUtil(elencoCategoriaUtil);
		} catch (DbManagerException e) {
			log.error("Errore ",e);
			return new ArrayList<CodeDescription>();
		}
	}

	public ArrayList<CodeDescription> getListFluido()
	{
		try {
			List<SigitDFluidoDto> elencoFluido = getDbMgr().getElencoFluidi();
			return MapDto.mapToCodeDescriptionElencoFluido(elencoFluido);
		} catch (DbManagerException e) {
			log.error("Errore ",e);
			return new ArrayList<CodeDescription>();
		}
	}

	public ArrayList<CodeDescription> getTipiRapportiControllo()
	{
		try {
			return getDbMgr().cercaListaTipoAllegati();
		} catch (DbManagerException e) {
			log.error("Errore ",e);
			return new ArrayList<CodeDescription>();
		}
	}

	public ArrayList<CodeDescription> getListDettaglioVm()
	{
		List<SigitDDettaglioVmDto> elencoDettaglio;
		try {
			elencoDettaglio = getDbMgr().getElencoDettaglioVm();
			ArrayList<CodeDescription> list = MapDto.mapToCodeDescriptionElencoDettaglioVm(elencoDettaglio);

			return list;

		} catch (DbManagerException e) {
			log.error("Errore ",e);
			return new ArrayList<CodeDescription>();
		}
	}

	public ArrayList<CodeDescription> getListDettaglioGt()
	{
		List<SigitDDettaglioGtDto> elencoDettaglio;
		try {
			elencoDettaglio = getDbMgr().getElencoDettaglioGt();
			ArrayList<CodeDescription> list = MapDto.mapToCodeDescriptionElencoDettaglioGt(elencoDettaglio);

			return list;

		} catch (DbManagerException e) {
			log.error("Errore ",e);
			return new ArrayList<CodeDescription>();
		}
	}

	public ArrayList<CodeDescription> getListDettaglioGf()
	{
		List<SigitDDettaglioGfDto> elencoDettaglio;
		try {
			elencoDettaglio = getDbMgr().getElencoDettaglioGf();
			ArrayList<CodeDescription> list = MapDto.mapToCodeDescriptionElencoDettaglioGf(elencoDettaglio);

			return list;

		} catch (DbManagerException e) {
			log.error("Errore ",e);
			return new ArrayList<CodeDescription>();
		}
	}

	public ArrayList<CodeDescription> getListFluidiTermovett()
	{
		List<SigitDFluidoDto> elencoFluidi;
		try {
			elencoFluidi = getDbMgr().getElencoFluidi();
			ArrayList<CodeDescription> list = MapDto.mapToCodeDescriptionElencoFluidi(elencoFluidi);

			return list;

		} catch (DbManagerException e) {
			log.error("Errore ",e);
			return new ArrayList<CodeDescription>();
		}
	}

	public ArrayList<RisultatoRicImpianto> ricercaAvanzataImpianti(RicercaAvanzataImpianti ricImpianti) throws ManagerException {
		log.debug("[SigitMgr::ricercaAvanzataImpianti] BEGIN");
		ArrayList<RisultatoRicImpianto> risRicImpiantoList = new ArrayList<RisultatoRicImpianto>();
		try
		{
			RicercaAvanzataImpiantoFilter filter = MapDto.mapToRicercaAvanzataFilter(ricImpianti);
			List<SigitVRicercaImpiantiDto> dtoList = getDbMgr().ricercaAvanzataImpiantoByFiltro(filter);

			for (SigitVRicercaImpiantiDto sigitVRicercaImpiantiDto : dtoList) {
				RisultatoRicImpianto obj = new RisultatoRicImpianto();
				obj.setCodiceImpianto(ConvertUtil.convertToString(sigitVRicercaImpiantiDto.getCodiceImpianto()));
				obj.setDescComune(MapDto.getComuneProvincia(sigitVRicercaImpiantiDto.getDenominazioneComune(), sigitVRicercaImpiantiDto.getSiglaProvincia()));
				obj.setIndirizzo(MapDto.getIndirizzo(sigitVRicercaImpiantiDto.getIndirizzoUnitaImmob(), sigitVRicercaImpiantiDto.getCivico()));
				obj.setDescIndirizzoCompleto(MapDto.getIndirizzoCompleto(sigitVRicercaImpiantiDto.getDenominazioneComune(), sigitVRicercaImpiantiDto.getIndirizzoUnitaImmob(), sigitVRicercaImpiantiDto.getCivico(), sigitVRicercaImpiantiDto.getSiglaProvincia()));

				obj.setDenomResponsabile(sigitVRicercaImpiantiDto.getDenominazioneResponsabile());
				obj.setDenom3Responsabile(sigitVRicercaImpiantiDto.getDenominazione3Responsabile());
				obj.setSezione(sigitVRicercaImpiantiDto.getSezione());
				obj.setFoglio(sigitVRicercaImpiantiDto.getFoglio());
				obj.setParticella(sigitVRicercaImpiantiDto.getParticella());
				obj.setSubalterno(sigitVRicercaImpiantiDto.getSubalterno());
				obj.setPod(sigitVRicercaImpiantiDto.getPodElettrico());
				obj.setPdr(sigitVRicercaImpiantiDto.getPdrGas());
				risRicImpiantoList.add(obj);
			}
		}
		finally {
			log.debug("[SigitMgr::ricercaAvanzataImpianti] END");
		}
		return risRicImpiantoList;
	}

	public void inserisciAzione(Azione azione, File file, String nomeFile, String contType) {
		log.debug("[SigitMgr::inserisciAzione] BEGIN");


	}

	public Azione cercaAzioneById(String idAzione) throws ManagerException {
		log.debug("[SigitMgr::cercaAzioneById] START");
		Azione output = null;
		try {
			SigitTAzioneDto azioneDb = getDbAzioneMgr().cercaAzioneById(ConvertUtil.convertToInteger(idAzione));
			SigitTDocAzioneDto doc = null;
			if (azioneDb != null && azioneDb.getIdAzione() != null) {
				doc = getDbAzioneMgr().cercaDocAzioneByIdAzione(azioneDb.getIdAzione());
			}
			output = MapDto.mapToAzione(azioneDb, doc);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[SigitMgr::cercaAzioneById] END");
		return output;
	}

	public List<Azione> cercaAzioniByFiltro (Integer idTipoAzione, Azione azioneFiltro, boolean caricaDoc) throws ManagerException {
		log.debug("[SigitMgr::cercaAzioniByFiltro] START");
		List<Azione> listaOut = new ArrayList<Azione>();
		try {
			//idTipoAzioneVerifica = checkTipoAzioneVerifica(idTipoAzioneVerifica);

			List<SigitTAzioneDto> listaDb = getDbAzioneMgr().cercaAzione(MapDto.mapToSigitTAzioneDto(idTipoAzione, azioneFiltro));
			if (listaDb != null && !listaDb.isEmpty()) {
				for (SigitTAzioneDto azioneDb : listaDb) {
					SigitTDocAzioneDto docDb = null;
					if (caricaDoc) {
						//viene caricato il doc per l'azione corrispondente
						docDb = getDbAzioneMgr().cercaDocAzioneByIdAzione(azioneDb.getIdAzione());
					}
					Azione azione = MapDto.mapToAzione(azioneDb, docDb);
					listaOut.add(azione);
				}
			}
		}  catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
//		catch (ServiceException e) {
//			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
//		}
		log.debug("[SigitMgr::cercaAzioniByFiltro] END");
		return listaOut;
	}

	private Integer checkTipoAzioneVerifica( Integer idTipoAzioneVerifica) throws ServiceException, DbManagerException {
		//VIENE RECUPERATO L'ID DEL TIPO AZIONE DA SETTARE (VERIFICA)
		if (idTipoAzioneVerifica == null) {
			SigitDTipoAzioneDto tipoAzioneVerifica = getDbAzioneMgr().getTipoAzioneByCode("VERIFICA");

			if (tipoAzioneVerifica == null) {
				log.debug("nessuna tipologia di azione trovata per il codice VERIFICA");
				throw new ServiceException(Messages.ERROR_RECUPERO_DB);
			} else {
				idTipoAzioneVerifica = tipoAzioneVerifica.getIdTipoAzione();
			}
		}

		return idTipoAzioneVerifica;
	}

	@Transactional
	public DocContratto inserisciDocContratto(Integer idContratto, DocumentoContrattoDto docFilter, UtenteLoggato utente)throws ManagerException {
		log.debug("[SigitMgr::inserisciDocContratto] START");
		DocContratto risultato = null;

		try {

			//metodo in cui il docFilter contiene la descrizione che verra' persistita nella nuova riga di docContratto.
			//il file puo' esserci o no
			SigitTDocContrattoDto dtoDaPersistere = DocumentoContrattoDto.mapToSigitTDocContrattoDto(idContratto, docFilter, utente.getCodiceFiscale());
			dtoDaPersistere.setDataUpload(DateUtil.getSqlDataCorrente());

			SigitTDocContrattoPk pk = getDbMgr().inserisciDocContratto(dtoDaPersistere);
			dtoDaPersistere.setIdDocContratto(pk.getIdDocContratto());

			log.debug("Chiave del doc: "+dtoDaPersistere.getIdDocContratto());

			if (docFilter.getFile() != null) {
				String nomeFileMod = "Doc_CONTRATTO_"+dtoDaPersistere.getIdDocContratto()+"_"+docFilter.getNomeFile();

				// Inserisco il file fittizio
	        	log.debug("inserisco il file fittizio - prima");

	        	Metadati metadati = new Metadati();

	        	final String uidIndex = getServiziMgr().indexUploadFileNew(nomeFileMod, new byte[0], metadati, Constants.INDEX_FOLDER_DOC, false);

	            log.debug("inserisco il file fittizio - dopo - uid: "+uidIndex);

	            dtoDaPersistere.setNomeDoc(nomeFileMod);
	            dtoDaPersistere.setUidIndex(uidIndex);

	            docFilter.setUidIndex(uidIndex);
	            docFilter.setNomeFileMod(nomeFileMod);

	            // Inserisco il file vero
	            log.debug("inserisco il file vero - prima");

	            this.getServiziMgr().mtomUploadFileGeneric(docFilter);

	            log.debug("inserisco il file vero - dopo");

	            log.debug("salvo l'operazione sul DB - prima");

	            getDbMgr().aggiornaTDocContrattoPerCreazione(dtoDaPersistere);

	            log.debug("salvo l'operazione sul DB - dopo");
			}

			risultato = DocumentoContrattoDto.mapToSigitTDocContrattoClient(dtoDaPersistere);


		} catch (ServiceException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));

		}

		log.debug("[SigitMgr::inserisciDocContratto] END");
		return risultato;

	}

	public void eliminaDocContratto(String cfUtente, Integer idDocContratto) throws ManagerException {
		log.debug("[SigitMgr::eliminaDocContratto] START");

		SigitTDocContrattoDto datoDaPersistere = new SigitTDocContrattoDto();
		datoDaPersistere.setDataDelete(DateUtil.getSqlDataCorrente());
		datoDaPersistere.setDataUltMod(DateUtil.getSqlCurrentDate());
		datoDaPersistere.setUtenteUltMod(cfUtente);
		datoDaPersistere.setIdDocContratto(idDocContratto);
		try {
			getDbMgr().aggiornaTDocContrattoPerEliminazione(datoDaPersistere);
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[SigitMgr::eliminaDocContratto] END");
		}



	}

	public List<DocContratto> recuperaDocContratti (Integer idContratto) throws ManagerException {
		log.debug("[SigitMgr::recuperaDocContratti] START");

		List<DocContratto> risultatoClient = new ArrayList<DocContratto>();

		SigitTDocContrattoDto example = new SigitTDocContrattoDto();
		example.setFkContratto(idContratto);

		List<SigitTDocContrattoDto> risultati;
		try {
			risultati = getDbMgr().cercaContratti2019(example);

			if (risultati != null) {
				for (SigitTDocContrattoDto docDb : risultati) {
					risultatoClient.add(DocumentoContrattoDto.mapToSigitTDocContrattoClient(docDb));
				}
			}

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[SigitMgr::recuperaDocContratti] END");
		}

		return risultatoClient;
	}




	@Transactional
	public void inserisciAzioneEDocumento(Integer idTipoAzioneVerifica, Azione azione, DocumentoAzioneDto docFilter, UtenteLoggato utente)throws ManagerException {
		log.debug("[SigitMgr::inserisciDocumento] START");

		try {

			//idTipoAzioneVerifica = checkTipoAzioneVerifica(idTipoAzioneVerifica);

			String prefisso = null;
			if (Constants.ID_TIPO_AZIONE_VERIFICA == idTipoAzioneVerifica) {
				prefisso = "VERIFICA";
			} else if(Constants.ID_TIPO_AZIONE_ACCERTAMENTO == idTipoAzioneVerifica) {
				prefisso = "ACCERTAMENTO";
			} else if(Constants.ID_TIPO_AZIONE_ISPEZIONE == idTipoAzioneVerifica) {
				prefisso = "ISPEZIONE";
			} else if(Constants.ID_TIPO_AZIONE_SANZIONE == idTipoAzioneVerifica) {
				prefisso = "SANZIONE";
			}

			//PRIMA VIENE FATTO L'INSERIMENTO DELL'AZIONE
			SigitTAzioneDto dtoDaPersistere = MapDto.mapToSigitTAzioneDto(idTipoAzioneVerifica, azione);
			if (dtoDaPersistere != null && dtoDaPersistere.getIdAzione() == null) {
				dtoDaPersistere.setCfUtenteAzione(ReplaceSpecialCharUtils.sanitize(utente.getCodiceFiscale()));
				dtoDaPersistere.setDenomUtenteAzione(ReplaceSpecialCharUtils.sanitize(utente.getDenominazione()));
				dtoDaPersistere.setDtAzione(DateUtil.getSqlCurrentDate());
			}
			SigitTAzionePk pk = getDbAzioneMgr().inserisciOModificaAzione(dtoDaPersistere);

			if (docFilter != null) {
				SigitTDocAzioneDto docDto = DocumentoAzioneDto.mapToSigitTDocAzioneDto(pk.getIdAzione(), docFilter, utente.getCodiceFiscale());

				getDbAzioneMgr().inserisciDocAzione(docDto);

				log.debug("Chiave del doc: "+docDto.getIdDocAzione());

				String nomeFileMod = "DocAzione_"+prefisso+"_"+docDto.getIdDocAzione()+"_"+docFilter.getNomeFile();

				// Inserisco il file fittizio
	        	log.debug("inserisco il file fittizio - prima");

	        	Metadati metadati = new Metadati();
//	        	metadati.setCodiceImpianto(docFilter.getCodImpianto());
//	        	metadati.setCodIstatProvincia(StringUtils.substring(ubicazione.getIstatComune(), 0, 3));
//	        	metadati.setCodIstatComune(ubicazione.getIstatComune());

	        	final String uidIndex = getServiziMgr().indexUploadFileNew(nomeFileMod, new byte[0], metadati, Constants.INDEX_FOLDER_DOC, false);

	            log.debug("inserisco il file fittizio - dopo - uid: "+uidIndex);

	            docDto.setNomeDoc(ReplaceSpecialCharUtils.sanitize(nomeFileMod));
	            docDto.setUidIndex(ReplaceSpecialCharUtils.sanitize(uidIndex));

	            docFilter.setUidIndex(ReplaceSpecialCharUtils.sanitize(uidIndex));
	            docFilter.setNomeFileMod(ReplaceSpecialCharUtils.sanitize(nomeFileMod));

	            // Inserisco il file vero
	            log.debug("inserisco il file vero - prima");

	            this.getServiziMgr().mtomUploadFileGeneric(docFilter);

	            log.debug("inserisco il file vero - dopo");

	            log.debug("salvo l'operazione sul DB - prima");

	            getDbAzioneMgr().aggiornaTDocAzione(docDto);

	            log.debug("salvo l'operazione sul DB - dopo");
			}


		} catch (ServiceException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));

		}

		log.debug("[SigitMgr::inviaAllegato] END");
	}




	 public void inserisciDistributore(ImportDistribFilter dataFile, String utenteUltMod) throws ManagerException {
		 log.debug("[SigitMgr::inserisciDistributore] BEGIN");
	        try {

	        	int idImport = getDbMgr().getIdSeqImportDistrib();
	        	dataFile.setIdImport(idImport);
	        	dataFile.setNomeFileMod(idImport+Constants.INTERVAL_SEP_CHIAVI+ReplaceSpecialCharUtils.sanitize(dataFile.getNomeFile()));

	        	// Inserisco il file fittizio
	        	log.debug("inserisco il file fittizio - prima");

	        	final String uidIndex = getServiziMgr().indexUploadDistributoreFile(dataFile.getNomeFileMod(), new byte[0]);

	            log.debug("inserisco il file fittizio - dopo - uid: "+uidIndex);

	            dataFile.setUidIndex(uidIndex);

	            // Inserisco il file vero
	            log.debug("inserisco il file vero - prima");

//	            this.getServiziMgr().mtomUploadFile(dataFile);
	            this.getServiziMgr().mtomUploadFileGeneric(dataFile);

	            log.debug("inserisco il file vero - dopo");

	            log.debug("salvo l'operazione sul DB - prima");

	            if (GenericUtil.isNotNullOrEmpty(dataFile.getIdImportSostituzione()))
	            {
	            	// E' una sostituzione
	            	getDbMgr().salvaImportSostituzioneDistributore(dataFile, utenteUltMod);

	            }
	            else
	            {
	            	// E' un inserimento
	            	getDbMgr().salvaImportDistributore(dataFile, utenteUltMod);
	            }

	            log.debug("salvo l'operazione sul DB - dopo");

	        }
	        catch (DbManagerException e) {
				log.error("Errore",e);
				throw e;
			}
	        catch (ServiceException e) {

//	        	this.getServiziMgr().indexDeleteFile(uid);
//
//	            this.getDbMgr().cancellaAllegatoByIstanzaNomeAllegato(idIstanza, allegato);

	            log.debug("[SigitMgr::inserisciDistributore] ERROR: " + e.getMessage());

				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
	        } finally {
	        	log.debug("[SigitMgr::inserisciDistributore] END");
	        }
	    }

	 public void annullaImportDistributore(Integer idImportDistr, String utenteUltMod) throws ManagerException {
		 log.debug("[SigitMgr::annullaImportDistributore] BEGIN");
	        try {


	            log.debug("salvo l'operazione sul DB - prima");

	        	getDbMgr().annullaImportDistributore(idImportDistr, utenteUltMod);

	            log.debug("salvo l'operazione sul DB - dopo");

	        }
	        catch (DbManagerException e) {
				log.error("Errore",e);
				throw e;
			}
	       finally {
	        	log.debug("[SigitMgr::annullaImportDistributore] END");
	        }
	    }

	 public ArrayList<DettaglioErrore> cercaErroriImportDistributore(Integer idImportDistr) throws ManagerException {
		 log.debug("[SigitMgr::cercaErroriImportDistributore] BEGIN");

			ArrayList<DettaglioErrore> risRicErroriList = new ArrayList<DettaglioErrore>();

		 try {

	            List<SigitTLogDistribDto> logList = getDbMgr().cercaErroriImportDistributoriByIdImport(idImportDistr);

	            if (logList != null && logList.size() > 0)
	            {
		            for (SigitTLogDistribDto sigitTLogDistribDto : logList) {

		            	risRicErroriList.add(MapDto.mapToDettaglioErrore(sigitTLogDistribDto));
					}
	            }

	            return risRicErroriList;
	        }
	        catch (DbManagerException e) {
				log.error("Errore",e);
				throw e;
			}
	       finally {
	        	log.debug("[SigitMgr::cercaErroriImportDistributore] END");
	        }
	    }
	 	/*
	 	@Transactional
		public MODDocument generaLibrettoImport(LibrettoDocument librettoDoc, String idImpianto, UtenteLoggato utenteLoggato) throws ServiceException {
			log.debug("[SigitMgr::generaLibrettoImport] BEGIN");
			try {


				// SU MAP HO GIA' CREATO IL METODO DI RIMAPPAGGIO BYTE -_> LibrettoDocument mapToLibrettoDocument


				Impianto impianto = getDbMgr().cercaImpiantoById(idImpianto);

				// Creo il libretto in bozza
				MODDocument modDoc = getDbMgr().getModuloLibrettoImport(idImpianto);


				log.debug("Libretto in bozza. Compilazione solo dei dati precompilati");
				Richiesta richiesta = modDoc.getMOD().getRichiesta();

				DatiPrecompilati datiPrecompilati = richiesta.getDatiPrecompilati();
				datiPrecompilati.setCodiceImpianto(idImpianto);


				datiPrecompilati.setElencoCombustibile(MapDto.mapToElencoCombustibile(getDbMgr().getElencoCombustibile()));
				datiPrecompilati.setElencoFabbricante(MapDto.mapToElencoFabbricante(getDbMgr().getElencoMarche()));
				datiPrecompilati.setElencoFluidoTermoVett(MapDto.mapToElencoFluido(getDbMgr().getElencoFluidi()));
				datiPrecompilati.setElencoUM(MapDto.mapToElencoUnitaMisura(getDbMgr().getElencoUnitaMisura()));

				datiPrecompilati.setCodiceCatasto(idImpianto);

				modDoc = MapDto.margeLibrettoDocumentToMODDocument(modDoc, librettoDoc);


				//MapDto.mapToSchedaIdentificativaImpiantoImport(modDoc.addNewMOD().getRichiesta().addNewDatiSchedaIdentificativaImp(), librettoDoc.getLibretto().getLibrettoCatasto().addNewL1SchedaIdentificativa(), impianto, unitaPrincipale);

				//SigitTImpiantoDto impiantoDto = getDbMgr().cercaImpiantoDtoById(idImpianto);
				//dati scheda 1 - impianto e scheda 14 - consumo
				//getDbMgr().compilaScheda1E14Libretto(richiesta, libretto, impiantoDto);


				datiPrecompilati.setStatoModulo(Constants.STATO_MODULO_BOZZA);
				if(modDoc.getMOD().getSystem()==null)
					modDoc.getMOD().addNewSystem();
				if(modDoc.getMOD().getSystem().getCatDig()==null)
					modDoc.getMOD().getSystem().addNewCatDig();
				modDoc.getMOD().getSystem().getCatDig().setBtSalva(true);


				if (log.isDebugEnabled())
					GenericUtil.stampa(impianto, true, 3);

				XmlModel xmlModel = new XmlModel();
				xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(modDoc));

				byte[] datiXml = xmlModel.getXmlContent();
				salvaLibretto(modDoc, datiXml, utenteLoggato.getCodiceFiscale(), idImpianto);


//				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//				log.debug("STAMPO RESULT: "+modDoc);
//				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

				return modDoc;

			}catch (Exception e) {
					log.error("Errore generaLibrettoImport",e);
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

					throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
			}finally{
				log.debug("[SigitMgr::generaLibrettoImport] END");
			}
		}
		*/

//	 	@Transactional
//		public void generaLibrettoImportNew(LibrettoDocument librettoDoc, String codImpianto, Integer idPersonaGiuridica, UtenteLoggato utenteLoggato) throws ServiceException {
//			log.debug("[SigitMgr::generaLibrettoImportNew] BEGIN");
//			try {
//
//				getDbMgr().cancellaListaComponentiAll(ConvertUtil.convertToInteger(codImpianto));
//
//				getDbMgrImport().consolidaLibrettoImport(librettoDoc, ConvertUtil.convertToBigDecimal(codImpianto), idPersonaGiuridica, utenteLoggato.getCodiceFiscale());
//
//
//			}catch (Exception e) {
//					log.error("Errore generaLibrettoImportNew",e);
//					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//
//					throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
//			}finally{
//				log.debug("[SigitMgr::generaLibrettoImportNew] END");
//			}
//		}

		public ArrayList<LabelValue> visuraImpresaAaep(String codFiscale) throws ManagerException {
			log.debug("[SigitMgr::visuraImpresaAaep] START");
			try {
				return getServiziMgr().cercaImpresaAaep(codFiscale);
			}
			catch (ServiceException e) {
				throw new ManagerException(e, new Message(e.getMessage()));
			}
			finally{
				log.debug("[SigitMgr::visuraImpresaAaep] END");
			}

		}

		/**
		 * Read file.
		 *
		 * @param f
		 *            the f
		 * @return the byte[]
		 */
		public byte[] readFile(File f) {
			InputStream is = null;
			byte[] bytes = null;
			try {
				is = new FileInputStream(f);

				long length = f.length();
				if (length > Integer.MAX_VALUE) {
					log.error("File is too large");
				}

				bytes = new byte[(int) length];

				is.read(bytes);

				is.close();
			} catch (Exception e) {
				log.error("Impossibile leggere file", e);
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						log.error("Impossibile chiudere stream", e);
					}
				}
			}
			return bytes;
		}


		/*
		public void gestisciMessaggioInvioMail(ExecResults result, ResultInvioMail resultInvioMail)
		{

			StringBuffer msg = new StringBuffer();
//			ArrayList<String> destinatari = null;

			if (resultInvioMail != null)
			{
				if (resultInvioMail.getDestinatariOK() != null && !resultInvioMail.getDestinatariOK().isEmpty())
				{

					log.debug("SETTO IL MESSAGGIO DELLA MAIL!!!!!");
					result.getGlobalMessages().add(new Message(Messages.INFO_INDIRIZZI_MAIL_OK, resultInvioMail.getFormatDestinatariOK()).getText());

//					msg.append(Messages.INFO_INDIRIZZI_MAIL_OK);
//					msg.append(resultInvioMail.getFormatDestinatariOK());
//					result.getGlobalMessages().add(
//							Messages.INFO_INDIRIZZI_MAIL_OK.concat(resultInvioMail.getFormatDestinatariOK()));
				}

//				destinatariResult = null;
//				destinatari = null;

				if (resultInvioMail.getDestinatariKO() != null && !resultInvioMail.getDestinatariKO().isEmpty())
				{


					result.getGlobalMessages().add(new Message(Messages.INFO_INDIRIZZI_MAIL_KO, resultInvioMail.getFormatDestinatariKO()).getText());

//					msg.append(Messages.INFO_INDIRIZZI_MAIL_KO);
//					msg.append(resultInvioMail.getFormatDestinatariKO());

//					result.getGlobalErrors().add(
//							Messages.INFO_INDIRIZZI_MAIL_KO.concat(resultInvioMail.getFormatDestinatariKO()));
				}

				log.debug("AGGIUNGO IL MESSAGGIO DELLA MAIL!!!!!");

				result.getGlobalMessages().add(msg.toString());
			}
		}
		*/

		public ArrayList<Consumo> ricercaConsumoCombustibileImpianto(String codiceImpianto, boolean isAbilitato) throws ManagerException, SigitTConsumoDaoException, SigitDCombustibileDaoException {
			log.debug("[SigitMgr::ricercaConsumoCombustibileImpianto] BEGIN");
			ArrayList<Consumo> risRicCombustImpiantoList = new ArrayList<Consumo>();
			try
			{
				SigitTConsumoDto consumoDto = new SigitTConsumoDto();
				consumoDto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
				consumoDto.setFkTipoConsumo(Constants.TIPO_CONSUMO_CB);
				List<SigitTConsumoDto> risRicCombustImpiantoDtoList = getDbMgr().getSigitTConsumoDao().findByCodImpiantoAndTipo(consumoDto);
				log.debug("[SigitMgr::ricercaConsumoCombustibileImpianto] DANIELECOMB "+ risRicCombustImpiantoDtoList.size());
				Integer indice = new Integer(1);
				for (SigitTConsumoDto temp : risRicCombustImpiantoDtoList) {
					Consumo obj = new Consumo();
					obj.setIdConsumo(ConvertUtil.convertToInteger(temp.getIdConsumo()));
					obj.setEsercizioDa(ConvertUtil.convertToString(temp.getEsercizioDa()));
					obj.setEsercizioA(ConvertUtil.convertToString(temp.getEsercizioA()));
					obj.setAcquisti(temp.getAcquisti());
					obj.setCodiceImpianto(ConvertUtil.convertToInteger(temp.getCodiceImpianto()));
					obj.setLetturaIniziale(ConvertUtil.convertToString(temp.getLetturaIniziale()));
					obj.setLetturaFinale(ConvertUtil.convertToString(temp.getLetturaFinale()));
					obj.setConsumo(ConvertUtil.convertToString(temp.getConsumo()));

					//obj = caricaTipoligica(obj,elencoTipoCombustibili,elencoTipoUnitaMisura);


					obj.setCombustibile(ConvertUtil.convertToString(temp.getFkCombustibile()));


					obj.setUnitaMisura(ConvertUtil.convertToInteger(temp.getFkUnitaMisura()));
					obj.setDatoEditabile(isAbilitato);

					obj.setIndice(indice);
					indice++;

					risRicCombustImpiantoList.add(obj);
				}
			}
			finally {
				log.debug("[SigitMgr::ricercaConsumoCombustibileImpianto] END");
			}
			return risRicCombustImpiantoList;
		}

		public ArrayList<Consumo> ricercaConsumoElettricoImpianto(String codiceImpianto, boolean isAbilitato) throws ManagerException, SigitTConsumoDaoException, SigitDCombustibileDaoException {
			log.debug("[SigitMgr::ricercaConsumoElettricoImpianto] BEGIN");
			ArrayList<Consumo> risRicCombustImpiantoList = new ArrayList<Consumo>();
			try
			{
				SigitTConsumoDto consumoDto = new SigitTConsumoDto();
				consumoDto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
				consumoDto.setFkTipoConsumo(Constants.TIPO_CONSUMO_EE);
				List<SigitTConsumoDto> risRicCombustImpiantoDtoList = getDbMgr().getSigitTConsumoDao().findByCodImpiantoAndTipo(consumoDto);
				log.debug("[SigitMgr::ricercaConsumoElettricoImpianto] DANIELECOMB "+ risRicCombustImpiantoDtoList.size());
				Integer indice = new Integer(1);
				for (SigitTConsumoDto temp : risRicCombustImpiantoDtoList) {
					Consumo obj = new Consumo();
					obj.setIdConsumo(ConvertUtil.convertToInteger(temp.getIdConsumo()));
					obj.setEsercizioDa(ConvertUtil.convertToString(temp.getEsercizioDa()));
					obj.setEsercizioA(ConvertUtil.convertToString(temp.getEsercizioA()));
					obj.setCodiceImpianto(ConvertUtil.convertToInteger(temp.getCodiceImpianto()));
					obj.setLetturaIniziale(ConvertUtil.convertToStringLogic(temp.getLetturaIniziale()));
					obj.setLetturaFinale(ConvertUtil.convertToStringLogic(temp.getLetturaFinale()));
					obj.setConsumo(ConvertUtil.convertToStringLogic(temp.getConsumo()));
					obj.setDatoEditabile(isAbilitato);

					obj.setIndice(indice);
					indice++;

					risRicCombustImpiantoList.add(obj);
				}
			}
			finally {
				log.debug("[SigitMgr::ricercaConsumoElettricoImpianto] END");
			}
			return risRicCombustImpiantoList;
		}

		public ConsumoAcqua ricercaConsumoAcquaImpianto(String codiceImpianto, boolean isAbilitato) throws ManagerException, SigitTConsumoDaoException, SigitDCombustibileDaoException {
			log.debug("[SigitMgr::ricercaConsumoAcquaImpianto] BEGIN");
			ConsumoAcqua consumoAcqua = new ConsumoAcqua();
			ArrayList<Consumo> risRicCombustImpiantoList = new ArrayList<Consumo>();
			try
			{
				SigitTConsumoDto consumoDto = new SigitTConsumoDto();
				consumoDto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
				consumoDto.setFkTipoConsumo(Constants.TIPO_CONSUMO_H2O);

				List<SigitTConsumoDto> risRicCombustImpiantoDtoList = getDbMgr().getSigitTConsumoDao().findByCodImpiantoAndTipo(consumoDto);
				log.debug("[SigitMgr::ricercaConsumoAcquaImpianto] DANIELECOMB "+ risRicCombustImpiantoDtoList.size());
				Integer indice = new Integer(1);
				for (SigitTConsumoDto temp : risRicCombustImpiantoDtoList) {
					Consumo obj = new Consumo();
					obj.setIdConsumo(ConvertUtil.convertToInteger(temp.getIdConsumo()));
					obj.setEsercizioDa(ConvertUtil.convertToString(temp.getEsercizioDa()));
					obj.setEsercizioA(ConvertUtil.convertToString(temp.getEsercizioA()));
					obj.setCodiceImpianto(ConvertUtil.convertToInteger(temp.getCodiceImpianto()));
					obj.setLetturaIniziale(ConvertUtil.convertToStringLogic(temp.getLetturaIniziale()));
					obj.setLetturaFinale(ConvertUtil.convertToStringLogic(temp.getLetturaFinale()));
					obj.setConsumo(ConvertUtil.convertToStringLogic(temp.getConsumo()));


					obj.setUnitaMisura(ConvertUtil.convertToInteger(temp.getFkUnitaMisura()));
					obj.setDatoEditabile(isAbilitato);

					obj.setIndice(indice);
					indice++;

					risRicCombustImpiantoList.add(obj);
				}

				consumoAcqua.setListaConsumi(risRicCombustImpiantoList);
				if (risRicCombustImpiantoList != null && !risRicCombustImpiantoList.isEmpty()) {
					consumoAcqua.setUnitaMisura(risRicCombustImpiantoList.get(0).getUnitaMisura());
				}
			}
			finally {
				log.debug("[SigitMgr::ricercaConsumoAcquaImpianto] END");
			}

			return consumoAcqua;
		}

		public ArrayList<Consumo> ricercaConsumoProdottiChimiciImpianto(String codiceImpianto, ArrayList<CodeDescription> elencoTipoUnitaMisura, boolean isAbilitato) throws ManagerException, SigitTConsumo14_4DaoException, SigitDCombustibileDaoException {
			log.debug("[SigitMgr::ricercaConsumoProdottiChimiciImpianto] BEGIN");
			ArrayList<Consumo> risRicCombustImpiantoList = new ArrayList<Consumo>();
			try
			{
//				SigitTConsumoDto consumoDto = new SigitTConsumoDto();
//				consumoDto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
//				consumoDto.setFkTipoConsumo(Constants.TIPO_CONSUMO_H2O);

				List<SigitTConsumo14_4Dto> risRicCombustImpiantoDtoList = getDbMgr().getSigitTConsumo144Dao().findByCodImpianto(ConvertUtil.convertToInteger(codiceImpianto));
				log.debug("[SigitMgr::ricercaConsumoProdottiChimiciImpianto] DANIELECOMB "+ risRicCombustImpiantoDtoList.size());

				Integer indice = new Integer(1);
				for (SigitTConsumo14_4Dto temp : risRicCombustImpiantoDtoList) {
					Consumo obj = new Consumo();
					obj.setIdConsumo(ConvertUtil.convertToInteger(temp.getIdConsumoH2o()));
					obj.setCodiceImpianto(ConvertUtil.convertToInteger(temp.getCodiceImpianto()));
					obj.setEsercizioDa(ConvertUtil.convertToString(temp.getEsercizioDa()));
					obj.setEsercizioA(ConvertUtil.convertToString(temp.getEsercizioA()));

					obj.setFlgCircuitoImpTer(ConvertUtil.convertToBoolean(temp.getFlgCircuitoIt()));
					obj.setFlgCircuitoAcs(ConvertUtil.convertToBoolean(temp.getFlgCircuitoAcs()));
					obj.setFlgCircuitoAltri(ConvertUtil.convertToBoolean(temp.getFlgAca()));

					obj.setNomeProdotto(temp.getNomeProdotto());

					obj.setConsumo(ConvertUtil.convertToStringLogic(temp.getQtaConsumata()));


					obj.setUnitaMisura(ConvertUtil.convertToInteger(temp.getFkUnitaMisura()));
					obj.setDatoEditabile(isAbilitato);

					obj.setIndice(indice);
					indice++;

					risRicCombustImpiantoList.add(obj);
				}
			}
			finally {
				log.debug("[SigitMgr::ricercaConsumoProdottiChimiciImpianto] END");
			}
			return risRicCombustImpiantoList;
		}



		public ArrayList<DatiExtra> ricercaDatiExtra(String codiceImpianto, boolean isAbilitato) throws ManagerException, SigitTConsumoDaoException, SigitDCombustibileDaoException {
			log.debug("[SigitMgr::ricercaDatiExtra] BEGIN");
			ArrayList<DatiExtra> risRicDatiExtraList = new ArrayList<DatiExtra>();
			try
			{

				List<SigitTUnitaImmobiliareDto> unitaImmobList = getDbMgr().getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(codiceImpianto));

				log.debug("[SigitMgr::ricercaDatiExtra] ELENCO "+ unitaImmobList.size());
				Integer indice = new Integer(1);
				for (SigitTUnitaImmobiliareDto temp : unitaImmobList) {

					if(!ConvertUtil.convertToBooleanAllways(temp.getFlgPrincipale()))
					{
						DatiExtra obj = new DatiExtra();
						obj.setIdUnitaImm(ConvertUtil.convertToInteger(temp.getIdUnitaImm()));
						obj.setSezione(temp.getSezione());
						obj.setFoglio(temp.getFoglio());
						obj.setParticella(temp.getParticella());
						obj.setSubalterno(temp.getSubalterno());
						obj.setPod(temp.getPodElettrico());
						obj.setPdr(temp.getPdrGas());
						obj.setDatoEditabile(isAbilitato);

						obj.setIndice(indice);
						indice++;

						risRicDatiExtraList.add(obj);
					}
				}
			}
			finally {
				log.debug("[SigitMgr::ricercaDatiExtra] END");
			}
			return risRicDatiExtraList;
		}

		public ArrayList<DatiExtra> gestisciDatiExtra(String codiceImpianto) throws ManagerException, SigitTConsumoDaoException, SigitDCombustibileDaoException {
			log.debug("[SigitMgr::ricercaDatiExtra] BEGIN");
			ArrayList<DatiExtra> risRicDatiExtraList = new ArrayList<DatiExtra>();
			try
			{

				List<SigitTUnitaImmobiliareDto> unitaImmobList = getDbMgr().getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(codiceImpianto));

				log.debug("[SigitMgr::ricercaDatiExtra] ELENCO "+ unitaImmobList.size());
				Integer indice = new Integer(1);
				for (SigitTUnitaImmobiliareDto temp : unitaImmobList) {

					if(!ConvertUtil.convertToBooleanAllways(temp.getFlgPrincipale()))
					{
						DatiExtra obj = new DatiExtra();
						obj.setIdUnitaImm(ConvertUtil.convertToInteger(temp.getIdUnitaImm()));
						obj.setSezione(temp.getSezione());
						obj.setFoglio(temp.getFoglio());
						obj.setParticella(temp.getParticella());
						obj.setSubalterno(temp.getSubalterno());
						obj.setPod(temp.getPodElettrico());
						obj.setPdr(temp.getPdrGas());

						obj.setIndice(indice);
						indice++;

						risRicDatiExtraList.add(obj);
					}
				}
			}
			finally {
				log.debug("[SigitMgr::ricercaDatiExtra] END");
			}
			return risRicDatiExtraList;
		}

		@Transactional
		public void consolidaLibrettoTrans(UtenteLoggato utenteLoggato, String codiceRea, String codiceImpianto, int motivoConsolidamento) throws ManagerException {
			log.debug("[SigitMgr::consolidaLibrettoTrans] BEGIN");
			try {

				gestisciLibrettoWeb(utenteLoggato, codiceRea, codiceImpianto, motivoConsolidamento);

			}
			catch(ManagerException e) {

				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

				throw e;
			}
			finally {
				log.debug("[SigitMgr::consolidaLibrettoTrans] END");
			}
		}

		@Transactional
		public void salvaLibrettoScheda1_extra(ArrayList<DatiExtra> listDatiExtra, ArrayList<PkTabellaEdit> listPkChiavi, ArrayList<Integer> listPkChiaviCancellare, String codiceImpianto, String cfUtenteMod) throws DbManagerException, ManagerException {
			log.debug("[SigitMgr::salvaLibrettoScheda1_extra] BEGIN");
			try {
				getDbMgr().salvaLibrettoScheda1_extra(listDatiExtra, listPkChiavi, listPkChiaviCancellare, codiceImpianto, cfUtenteMod);
			}
			catch(DbManagerException e) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

				throw e;
			}
			finally {
				log.debug("[SigitMgr::salvaLibrettoScheda1_extra] END");
			}
		}

		@Transactional
		public void salvaLibrettoScheda1Trans(Scheda1 scheda1, String cfUtenteMod, String codiceRea, String codiceImpianto, boolean isScheda1Present) throws ManagerException {
			log.debug("[DbMgr::salvaLibrettoScheda1Trans] BEGIN");
			try {
				getDbMgr().salvaLibrettoScheda1(scheda1, cfUtenteMod, codiceImpianto, isScheda1Present);

//				dcosta: eliminato consolidamento libretto gestisciLibrettoWeb(cfUtenteMod, codiceRea, codiceImpianto);

			}
			catch(ManagerException e) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

				throw e;
			}
			finally {
				log.debug("[DbMgr::salvaLibrettoScheda1Trans] END");
			}
		}


		@Transactional
		public void salvaLibrettoScheda14_1_Trans(ArrayList<Consumo> listaConsumi, ArrayList<Integer> listPkChiaviCancellare, String codiceImpianto, String cfUtenteMod, String codiceRea) throws ManagerException {
			log.debug("[SigitMgr::salvaLibrettoScheda14_1_Trans] BEGIN");
			try {
				getDbMgr().salvaLibrettoScheda14_1(listaConsumi, listPkChiaviCancellare, codiceImpianto, cfUtenteMod);

//				dcosta: eliminato consolidamento libretto gestisciLibrettoWeb(cfUtenteMod, codiceRea, codiceImpianto);

			}
			catch(ManagerException e) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

				throw e;
			}
			finally {
				log.debug("[SigitMgr::salvaLibrettoScheda14_1_Trans] END");
			}
		}

		@Transactional
		public void salvaLibrettoScheda14_2_Trans(ArrayList<Consumo> listaConsumi, ArrayList<Integer> listPkChiaviCancellare, String codiceImpianto, String cfUtenteMod, String codiceRea) throws ManagerException {
			log.debug("[SigitMgr::salvaLibrettoScheda14_2_Trans] BEGIN");
			try {
				getDbMgr().salvaLibrettoScheda14_2(listaConsumi, listPkChiaviCancellare, codiceImpianto, cfUtenteMod);

//				dcosta: eliminato consolidamento libretto gestisciLibrettoWeb(cfUtenteMod, codiceRea, codiceImpianto);

			}
			catch(ManagerException e) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

				throw e;
			}
			finally {
				log.debug("[SigitMgr::salvaLibrettoScheda14_2_Trans] END");
			}
		}

		@Transactional
		public void salvaLibrettoScheda14_3_Trans(ConsumoAcqua consumoAcqua, ArrayList<Integer> listPkChiaviCancellare, String codiceImpianto, String cfUtenteMod, String codiceRea) throws ManagerException {
			log.debug("[SigitMgr::salvaLibrettoScheda14_3_Trans] BEGIN");
			try {
				ArrayList<Consumo> listaConsumi = consumoAcqua.getListaConsumi();
				//per ogni consumo viene settata la stessa unita' di misura
				if (listaConsumi != null && !listaConsumi.isEmpty()) {
					for (Consumo consumo : listaConsumi) {
						consumo.setUnitaMisura(consumoAcqua.getUnitaMisura());
					}
				}
				getDbMgr().salvaLibrettoScheda14_3(listaConsumi, listPkChiaviCancellare, codiceImpianto, cfUtenteMod);

//				dcosta: eliminato consolidamento libretto gestisciLibrettoWeb(cfUtenteMod, codiceRea, codiceImpianto);

			}
			catch(ManagerException e) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

				throw e;
			}
			finally {
				log.debug("[SigitMgr::salvaLibrettoScheda14_1_Trans] END");
			}
		}

		@Transactional
		public void salvaLibrettoScheda14_4_Trans(ArrayList<Consumo> listaConsumi, ArrayList<Integer> listPkChiaviCancellare, String codiceImpianto, String cfUtenteMod, String codiceRea) throws ManagerException {
			log.debug("[SigitMgr::salvaLibrettoScheda14_4_Trans] BEGIN");
			try {
				getDbMgr().salvaLibrettoScheda14_4(listaConsumi, listPkChiaviCancellare, codiceImpianto, cfUtenteMod);

//				dcosta: eliminato consolidamento libretto gestisciLibrettoWeb(cfUtenteMod, codiceRea, codiceImpianto);

			}
			catch(ManagerException e) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

				throw e;
			}
			finally {
				log.debug("[SigitMgr::salvaLibrettoScheda14_4_Trans] END");
			}
		}

		public void gestisciLibrettoWeb(UtenteLoggato utenteLoggato, String codiceRea, String codiceImpianto, int motivoConsolidamento) throws ManagerException
		{
			try
			{
				String cfUtenteMod = utenteLoggato.getCodiceFiscale();

				SigitTLibrettoDto librettoDto = new SigitTLibrettoDto();
				librettoDto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
				librettoDto.setFkStato(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_LIBRETTO_BOZZA));
				/*
				 *  BEPPE
				librettoDto.setFkTipoIntervento(Constants.ID_TIPO_INT_NON_VALORIZZATO);
				if(richiesta.getDatiSchedaIdentificativaImp()!=null)
				{
					if (richiesta.getDatiSchedaIdentificativaImp().getL11FlagNuovaInst())
					{
						librettoDto.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_INT_NUOVA_INSTALZ));
					}
					else if (richiesta.getDatiSchedaIdentificativaImp().getL11FlagRistrutt())
					{
						librettoDto.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_INT_RISTRUTTURAZ));
					}
					else if (richiesta.getDatiSchedaIdentificativaImp().getL11FlagSostGenerat())
					{
						librettoDto.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_INT_SOSTITUZIONE));
					}
					else if (richiesta.getDatiSchedaIdentificativaImp().getL11FlagCompilaLibretto())
					{
						librettoDto.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_INT_COMPILAZIONE));
					}
				}
				 */

				librettoDto.setFkTipoDocumento(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_DOC_LIBRETTO));
				librettoDto.setCfRedattore(cfUtenteMod);
				librettoDto.setFlgControlloBozza(BigDecimal.ONE);

				librettoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
				librettoDto.setUtenteUltMod(cfUtenteMod);

				log.debug("Stampo cfUtenteMod: "+cfUtenteMod);

				if (log.isDebugEnabled())
					GenericUtil.stampa(librettoDto, true, 3);

				// BEPPE - Questa riga e' da togliere quando toglieranno il vincolo del NOT NULL sul DB
				//librettoDto.setFkTipoIntervento(Constants.ID_TIPO_INT_NON_VALORIZZATO);

				//getDbMgr().salvaLibrettoWeb(librettoDto);

				getDbMgr().getSigitTLibrettoDao().insert(librettoDto);

				log.debug("Ricerca impiantoDto");
				SigitTImpiantoDto impiantoDto = getDbMgr().cercaImpiantoDtoById(codiceImpianto);
				log.debug("Consolidamento libretto per motivo: esplicito utente");
				creaPdfEConsolidaLibretto(utenteLoggato, impiantoDto, codiceRea, librettoDto, motivoConsolidamento);
			}
			catch(DbManagerException e) {

				throw e;
			}
			finally {
				log.debug("[DbMgr::salvaLibrettoScheda1Trans] END");
			}
		}

		public ArrayList<Componente> ricercaComponenteAC(String codiceImpianto) throws ManagerException {
			log.debug("[SigitMgr::ricercaComponenteAC] BEGIN");
			ArrayList<Componente> componentiList = null;
			try
			{
				List<SigitVCompAcDto> compList = getDbMgr().getSigitVCompAcDao().findByCodImpiantoOrdered(new CompFilter(codiceImpianto));

				componentiList = MapDto.mapToComponentiPrincAC(compList);

			}
			catch (SigitVCompAcDaoException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaComponenteAC] END");
			}
			return componentiList;
		}


		//////////////////

		public ArrayList<Componente> ricercaComponenteCS(String codiceImpianto) throws ManagerException {
			log.debug("[SigitMgr::ricercaComponenteCS] BEGIN");
			ArrayList<Componente> componentiList = null;
			try
			{
				List<SigitVCompCsDto> compList = getDbMgr().getSigitVCompCsDao().findByCodImpiantoOrdered(new CompFilter(codiceImpianto));

				componentiList = MapDto.mapToComponentiPrincCS(compList);

			}
			catch (SigitVCompCsDaoException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaComponenteCS] END");
			}
			return componentiList;
		}

		public ArrayList<Componente> ricercaComponenteAG(String codiceImpianto) throws ManagerException {
			log.debug("[SigitMgr::ricercaComponenteAG] BEGIN");
			ArrayList<Componente> componentiList = null;
			try
			{
				List<SigitVCompAgDto> compList = getDbMgr().getSigitVCompAgDao().findByCodImpiantoOrdered(new CompFilter(codiceImpianto));

				componentiList = MapDto.mapToComponentiPrincAG(compList);

			}
			catch (SigitVCompAgDaoException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaComponenteAG] END");
			}
			return componentiList;
		}

		public ArrayList<Componente> ricercaComponenteSR(String codiceImpianto) throws ManagerException {
			log.debug("[SigitMgr::ricercaComponenteSR] BEGIN");
			ArrayList<Componente> componentiList = null;
			try
			{
				List<SigitVCompSrDto> compList = getDbMgr().getSigitVCompSrDao().findByCodImpiantoOrdered(new CompFilter(codiceImpianto));

				componentiList = MapDto.mapToComponentiPrincSR(compList);

			}
			catch (SigitVCompSrDaoException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaComponenteSR] END");
			}
			return componentiList;
		}

		public ArrayList<Componente> ricercaComponenteVR(String codiceImpianto) throws ManagerException {
			log.debug("[SigitMgr::ricercaComponenteVR] BEGIN");
			ArrayList<Componente> componentiList = null;
			try
			{
				List<SigitVCompVrDto> compList = getDbMgr().getSigitVCompVrDao().findByCodImpiantoOrdered(new CompFilter(codiceImpianto));

				componentiList = MapDto.mapToComponentiPrincVR(compList);

			}
			catch (SigitVCompVrDaoException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaComponenteVR] END");
			}
			return componentiList;
		}

		public ArrayList<Componente> ricercaComponentePO(String codiceImpianto) throws ManagerException {
			log.debug("[SigitMgr::ricercaComponentePO] BEGIN");
			ArrayList<Componente> componentiList = null;
			try
			{
				List<SigitVCompPoDto> compList = getDbMgr().getSigitVCompPoDao().findByCodImpiantoOrdered(new CompFilter(codiceImpianto));

				componentiList = MapDto.mapToComponentiPrincPO(compList);

			}
			catch (SigitVCompPoDaoException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaComponentePO] END");
			}
			return componentiList;
		}

		/////////////////

		public ArrayList<Componente> ricercaComponenteTE(String codiceImpianto) throws ManagerException {
			log.debug("[SigitMgr::ricercaComponenteTE] BEGIN");
			ArrayList<Componente> componentiList = null;
			try
			{
				List<SigitVCompTeDto> compList = getDbMgr().getSigitVCompTeDao().findByCodImpiantoOrdered(new CompFilter(codiceImpianto));

				componentiList = MapDto.mapToComponentiPrincTE(compList);

			}
			catch (SigitVCompTeDaoException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaComponenteTE] END");
			}
			return componentiList;
		}

		public ArrayList<Componente> ricercaComponenteRV(String codiceImpianto) throws ManagerException {
			log.debug("[SigitMgr::ricercaComponenteRV] BEGIN");
			ArrayList<Componente> componentiList = null;
			try
			{
				List<SigitVCompRvDto> compList = getDbMgr().getSigitVCompRvDao().findByCodImpiantoOrdered(new CompFilter(codiceImpianto));

				componentiList = MapDto.mapToComponentiPrincRV(compList);

			}
			catch (SigitVCompRvDaoException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaComponenteRV] END");
			}
			return componentiList;
		}

		public ArrayList<Componente> ricercaComponenteSCX(String codiceImpianto) throws ManagerException {
			log.debug("[SigitMgr::ricercaComponenteSCX] BEGIN");
			ArrayList<Componente> componentiList = null;
			try
			{
				List<SigitVCompScxDto> compList = getDbMgr().getSigitVCompScxDao().findByCodImpiantoOrdered(new CompFilter(codiceImpianto));

				componentiList = MapDto.mapToComponentiPrincSCX(compList);

			}
			catch (SigitVCompScxDaoException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaComponenteSCX] END");
			}
			return componentiList;
		}

		public ArrayList<Componente> ricercaComponenteCI(String codiceImpianto) throws ManagerException {
			log.debug("[SigitMgr::ricercaComponenteCI] BEGIN");
			ArrayList<Componente> componentiList = null;
			try
			{
				List<SigitVCompCiDto> compList = getDbMgr().getSigitVCompCiDao().findByCodImpiantoOrdered(new CompFilter(codiceImpianto));

				componentiList = MapDto.mapToComponentiPrincCI(compList);

			}
			catch (SigitVCompCiDaoException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaComponenteCI] END");
			}
			return componentiList;
		}

		public ArrayList<Componente> ricercaComponenteUT(String codiceImpianto) throws ManagerException {
			log.debug("[SigitMgr::ricercaComponenteUT] BEGIN");
			ArrayList<Componente> componentiList = null;
			try
			{
				List<SigitVCompUtDto> compList = getDbMgr().getSigitVCompUtDao().findByCodImpiantoOrdered(new CompFilter(codiceImpianto));

				componentiList = MapDto.mapToComponentiPrincUT(compList);

			}
			catch (SigitVCompUtDaoException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaComponenteUT] END");
			}
			return componentiList;
		}

		public ArrayList<Componente> ricercaComponenteRC(String codiceImpianto) throws ManagerException {
			log.debug("[SigitMgr::ricercaComponenteRC] BEGIN");
			ArrayList<Componente> componentiList = null;
			try
			{
				List<SigitVCompRcDto> compList = getDbMgr().getSigitVCompRcDao().findByCodImpiantoOrdered(new CompFilter(codiceImpianto));

				componentiList = MapDto.mapToComponentiPrincRC(compList);

			}
			catch (SigitVCompRcDaoException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaComponenteRC] END");
			}
			return componentiList;
		}

		public ArrayList<Componente> ricercaComponenteVM(String codiceImpianto) throws ManagerException {
			log.debug("[SigitMgr::ricercaComponenteVM] BEGIN");
			ArrayList<Componente> componentiList = null;
			try
			{
				List<SigitVCompVmDto> compList = getDbMgr().getSigitVCompVmDao().findByCodImpiantoOrdered(new CompFilter(codiceImpianto));

				componentiList = MapDto.mapToComponentiPrincVM(compList);

			}
			catch (SigitVCompVmDaoException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaComponenteVM] END");
			}
			return componentiList;
		}

		public ArrayList<Scheda12> ricercaScheda12(String codiceImpianto) throws ManagerException {
			log.debug("[SigitMgr::ricercaScheda12] BEGIN");
			ArrayList<Scheda12> scheda12 = null;
			try
			{
				List<SigitVRicercaAllegatiDto> listControlli = getDbMgr().getSigitVRicercaAllegatiDao().findReeByCodImpiantoOrderedByData(ConvertUtil.convertToInteger(codiceImpianto));

				scheda12 = MapDto.mapToScheda12(listControlli);

			}
			catch (SigitVRicercaAllegatiDaoException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaScheda12] END");
			}
			return scheda12;
		}

		public ArrayList<Scheda15> ricercaScheda15(String codiceImpianto) throws ManagerException {
			log.debug("[SigitMgr::ricercaScheda15] BEGIN");
			ArrayList<Scheda15> scheda15 = null;
			try
			{
				List<SigitVRicercaAllegatiDto> listControlli = getDbMgr().getSigitVRicercaAllegatiDao().findManutByCodImpianto(ConvertUtil.convertToInteger(codiceImpianto));

				scheda15 = MapDto.mapToScheda15(listControlli);

			}
			catch (SigitVRicercaAllegatiDaoException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaScheda15] END");
			}
			return scheda15;
		}

		public Scheda11Intest ricercaScheda11IntestOld(String codiceImpianto, String componente) throws ManagerException {
			log.debug("[SigitMgr::ricercaScheda11Intest] BEGIN");
			Scheda11Intest scheda11Intest = null;
			try
			{
				SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(codiceImpianto);

				scheda11Intest = MapDto.mapToScheda11IntestOld(impianto, componente);

			}
			catch (DbManagerException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaScheda11Intest] END");
			}
			return scheda11Intest;
		}


		public Scheda11Intest ricercaScheda11Intest(String codiceImpianto, String tipoComponente, Integer progressivo, Integer idAllegato) throws ManagerException {
			log.debug("[SigitMgr::ricercaScheda11Intest] BEGIN");
			Scheda11Intest scheda11Intest =  new Scheda11Intest();
			try
			{
				String componente = MapDto.getApparecchiatura(tipoComponente, progressivo);
				scheda11Intest.setComponente(componente);
				if (Constants.TIPO_COMPONENTE_GT.equals(tipoComponente)) {
					//si accede al dettaglio tipo 1 per valorizzare i campi di altra norma + flg
					List<SigitTDettTipo1Dto> dettagliTipo1 = getDbMgr().getDettTipo1(codiceImpianto, progressivo, idAllegato.toString());
					if (dettagliTipo1 != null && dettagliTipo1.size() > 0) {
						SigitTDettTipo1Dto primoDett = dettagliTipo1.get(0);
						scheda11Intest.setAltraNorma(primoDett.getL111AltroRiferimento());
						scheda11Intest.setFlgNormaUni103891(ConvertUtil.convertToBooleanAllways(primoDett.getEFlgUni103891()));
					}
				}

			}
			catch (DbManagerException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaScheda11Intest] END");
			}
			return scheda11Intest;
		}

		public Tipo1Dett caricaDatiReeTipo1Dett(String idAllegato, Integer progressivo) throws ManagerException {
			log.debug("[SigitMgr::caricaDatiReeTipo1Dett] BEGIN");

			BigDecimal idAllegatoBigDecimal = ConvertUtil.convertToBigDecimal(idAllegato);
			SigitRAllegatoCompGtDto rAllCompGt = (SigitRAllegatoCompGtDto) getDbMgr().cercaRAllegatoComByIdProgr(ConvertUtil.convertToInteger(idAllegato), Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToString(progressivo));
			SigitVSk4GtDto vCompGt = getDbMgr().getCompGtByIdAllegatoProgr(ConvertUtil.convertToInteger(idAllegato), ConvertUtil.convertToString(progressivo));
			SigitTRappTipo1Dto rappTipo1Dto = getDbMgr().cercaTRappTipo1ById(idAllegatoBigDecimal);
			List<SigitTConsumoTipo1BDto> consumiCombustibile = getDbMgr().findConsumiTipo1ByIdAllegatoIdTipoConsumo(idAllegatoBigDecimal, Constants.ID_TIPO_CONSUMO_1B_CONSUMO_BIOMASSA);

			Tipo1Dett dett = MapDto.mapToTipo1Dett(rAllCompGt, vCompGt, rappTipo1Dto);
			dett.setConsumiCombustibile(MapDto.mapListToTipo1ConsumoList(consumiCombustibile));

			log.debug("[SigitMgr::caricaDatiReeTipo1Dett] END");
			return dett;
		}

		public TipoGFDett caricaDatiRappProvaTipoGFDett(String idAllegato, Integer progressivo)  throws ManagerException{
			log.debug("[SigitMgr::caricaDatiRappProvaTipoGTDett] BEGIN");

			SigitRAllegatoCompGfDto rAllCompGf = (SigitRAllegatoCompGfDto) getDbMgr().cercaRAllegatoComByIdProgr(ConvertUtil.convertToInteger(idAllegato), Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToString(progressivo));

			List<SigitVCompGfDto> vCompGfLista;

			try {
				vCompGfLista = getDbMgr().getSigitVCompGfDao().findByIdAllegatoOrdered(ConvertUtil.convertToInteger(idAllegato));
			} catch (SigitVCompGfDaoException e1) {
				throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DB));
			}
			SigitVCompGfDto vCompGf = null;

			if (vCompGfLista != null) {
				for (SigitVCompGfDto comp : vCompGfLista) {
					vCompGf = comp;
					break;
				}
			}

			if (vCompGf == null) {
				throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DB));
			}

			TipoGFDett dett = MapDto.mapToTipoGFDett(rAllCompGf, vCompGf);
			log.debug("[SigitMgr::caricaDatiRappProvaTipoGFDett] END");
			return dett;
		}

		public TipoGTDett caricaDatiRappProvaTipoGTDett(String idAllegato, Date dataControllo, Integer progressivo)  throws ManagerException{
			log.debug("[SigitMgr::caricaDatiRappProvaTipoGTDett] BEGIN");

			SigitRAllegatoCompGtDto rAllCompGt = (SigitRAllegatoCompGtDto) getDbMgr().cercaRAllegatoComByIdProgr(ConvertUtil.convertToInteger(idAllegato), Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToString(progressivo));
//			da sostituire
//			SigitVSk4GtDto vCompGt = getDbMgr().getCompGtByIdAllegatoProgr(ConvertUtil.convertToInteger(idAllegato), ConvertUtil.convertToString(progressivo));
			List<SigitVCompGtDto> vCompGtLista;
			try {
				vCompGtLista = getDbMgr().getSigitVCompGtDao().findByIdAllegatoOrdered(ConvertUtil.convertToInteger(idAllegato));
			} catch (SigitVCompGtDaoException e1) {
				throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DB));
			}
			SigitVCompGtDto vCompGt = null;
			if (vCompGtLista != null ) {
				for (SigitVCompGtDto comp : vCompGtLista) {
					if (ConvertUtil.convertToInteger(comp.getProgressivo()).equals(progressivo)) {
						vCompGt = comp;
						break;
					}
				}
			}

			if (vCompGt == null) {
				throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DB));
			}

			/*
			CompFilter filter = new CompFilter();
			filter.setCodImpianto(ConvertUtil.convertToString(rAllCompGt.getCodiceImpianto()));
			filter.setDataInstallazione(rAllCompGt.getDataInstall());
			filter.setProgressivo(ConvertUtil.convertToString(rAllCompGt.getProgressivo()));
			filter.setTipoComponente(Constants.TIPO_COMPONENTE_BR);
			filter.setDataControllo(dataControllo);
			*/

			List<SigitTCompBrRcBrRcLegateAGtComplexDto> bruciatoriAssociati = cercaBrRcLegateAGt(rAllCompGt.getCodiceImpianto(), rAllCompGt.getDataInstall(), rAllCompGt.getProgressivo(), dataControllo);

			/*
			List<SigitTCompBrRcBrRcLegateAGtComplexDto> bruciatoriAssociati = null

			try {
				bruciatoriAssociati = getDbMgr().getSigitTCompBrRcDao().findBrRcLegateAGtComplex(filter);
			} catch (SigitTCompBrRcDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			*/

			TipoGTDett dett = MapDto.mapToTipoGTDett(rAllCompGt, vCompGt, bruciatoriAssociati);
			log.debug("[SigitMgr::caricaDatiRappProvaTipoGTDett] END");
			return dett;
		}

		public List<SigitTCompBrRcBrRcLegateAGtComplexDto> cercaBrRcLegateAGt(BigDecimal codiceImpianto, Date dataInstall, BigDecimal progressivo, Date dataControllo ) throws DbManagerException
		{
			CompFilter filter = new CompFilter();
			filter.setCodImpianto(ConvertUtil.convertToString(codiceImpianto));
			filter.setDataInstallazione(dataInstall);
			filter.setProgressivo(ConvertUtil.convertToString(progressivo));
			filter.setTipoComponente(Constants.TIPO_COMPONENTE_BR);
			filter.setDataControllo(dataControllo);

			List<SigitTCompBrRcBrRcLegateAGtComplexDto> bruciatoriAssociati;
			try {
				bruciatoriAssociati = getDbMgr().getSigitTCompBrRcDao().findBrRcLegateAGtComplex(filter);
			} catch (SigitTCompBrRcDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}

			return bruciatoriAssociati;
		}

		public Tipo1DettModulo caricaDatiReeTipo1DettModulo(String codImpianto, String idAllegato, Integer progressivo, Integer numModulo) throws ManagerException {

			log.debug("[SigitMgr::caricaDatiReeTipo1DettModulo] BEGIN");

			Tipo1DettModulo modulo = new Tipo1DettModulo();

			SigitTDettTipo1Dto tDettTipo1	= getDbMgr().getDettTipo1(codImpianto, progressivo, idAllegato, numModulo);

			modulo = MapDto.mapToTipo1DettModulo(tDettTipo1);

			log.debug("[SigitMgr::caricaDatiReeTipo1DettModulo] END");
			return modulo;
		}

		public TipoGTDettModulo caricaDatiRappProvaTipoGTDettModulo (String codImpianto, String idAllegato, Integer progressivo, Integer numModulo) throws ManagerException {

			log.debug("[SigitMgr::caricaDatiRappProvaTipoGTDettModulo] BEGIN");
			TipoGTDettModulo modulo = new TipoGTDettModulo();

			SigitTDettIspezGtDto tDettTipo1 = getDbMgr().getDettRappProvaGT(codImpianto, progressivo, idAllegato, numModulo);

			modulo = MapDto.mapToTipoGTDettModulo(tDettTipo1);

			log.debug("[SigitMgr::caricaDatiRappProvaTipoGTDettModulo] END");
			return modulo;
		}

		public TipoGFDettCircuito caricaDatiRappProvaTipoGFDettCircuito (String codImpianto, String idAllegato, Integer progressivo, Integer numCircuito) throws ManagerException {

			log.debug("[SigitMgr::caricaDatiRappProvaTipoGFDettCircuito] BEGIN");
			TipoGFDettCircuito circuito = new TipoGFDettCircuito();

			SigitTDettIspezGfDto tDettTipo2 = getDbMgr().getDettRappProvaGF(codImpianto, progressivo, idAllegato, numCircuito);

			circuito = MapDto.mapToTipoGFDettCircuito(tDettTipo2);

			log.debug("[SigitMgr::caricaDatiRappProvaTipoGFDettCircuito] END");
			return circuito;
		}


		public Tipo2Dett caricaDatiReeTipo2Dett(String idAllegato, Integer progressivo) throws ManagerException {
			log.debug("[SigitMgr::caricaDatiReeTipo2Dett] BEGIN");

			SigitRAllegatoCompGfDto rAllCompGf = (SigitRAllegatoCompGfDto) getDbMgr().cercaRAllegatoComByIdProgr(ConvertUtil.convertToInteger(idAllegato), Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToString(progressivo));

			SigitVSk4GfDto vCompGf = getDbMgr().getCompGfByIdAllegatoProgr(ConvertUtil.convertToInteger(idAllegato), ConvertUtil.convertToString(progressivo));

			Tipo2Dett dett = MapDto.mapToTipo2Dett(rAllCompGf, vCompGf);

			log.debug("[SigitMgr::caricaDatiReeTipo2Dett] END");
			return dett;
		}

		public Tipo2DettCircuito caricaDatiReeTipo2DettCircuito(String codImpianto, String idAllegato, Integer progressivo, String numCircuito) throws ManagerException {
			log.debug("[SigitMgr::caricaDatiReeTipo2DettCircuito] BEGIN");

			Tipo2DettCircuito circuito = new Tipo2DettCircuito();

			SigitTDettTipo2Dto tDettTipo2= getDbMgr().getDettTipo2(codImpianto, progressivo, idAllegato, numCircuito);

			circuito = MapDto.mapToTipo2DettCircuito(tDettTipo2);

			log.debug("[SigitMgr::caricaDatiReeTipo2DettCircuito] END");
			return circuito;
		}

		public Tipo3Dett caricaDatiReeTipo3Dett(String idAllegato, Integer progressivo) throws ManagerException {
			log.debug("[SigitMgr::caricaDatiReeTipo3Dett] BEGIN");

			SigitRAllegatoCompScDto rAllCompSc = (SigitRAllegatoCompScDto) getDbMgr().cercaRAllegatoComByIdProgr(ConvertUtil.convertToInteger(idAllegato), Constants.TIPO_COMPONENTE_SC, ConvertUtil.convertToString(progressivo));

			SigitVSk4ScDto vCompSc = (SigitVSk4ScDto) getDbMgr().getCompByIdAllegatoProgr(ConvertUtil.convertToInteger(idAllegato), Constants.TIPO_COMPONENTE_SC, ConvertUtil.convertToString(progressivo));

			Tipo3Dett dett = MapDto.mapToTipo3Dett(rAllCompSc, vCompSc);

			log.debug("[SigitMgr::caricaDatiReeTipo3Dett] END");
			return dett;
		}

		public Tipo4Dett caricaDatiReeTipo4Dett(String idAllegato, Integer progressivo) throws ManagerException {
			log.debug("[SigitMgr::caricaDatiReeTipo4Dett] BEGIN");

			SigitRAllegatoCompCgDto rAllCompCg = (SigitRAllegatoCompCgDto) getDbMgr().cercaRAllegatoComByIdProgr(ConvertUtil.convertToInteger(idAllegato), Constants.TIPO_COMPONENTE_CG, ConvertUtil.convertToString(progressivo));

			SigitVSk4CgDto vCompCg = getDbMgr().getCompCgByIdAllegatoProgr(ConvertUtil.convertToInteger(idAllegato), ConvertUtil.convertToString(progressivo));

			Tipo4Dett dett = MapDto.mapToTipo4Dett(rAllCompCg, vCompCg);

			log.debug("[SigitMgr::caricaDatiReeTipo4Dett] END");
			return dett;
		}




		/*
		public ArrayList<Scheda11> ricercaScheda11_1(String codiceImpianto, Integer progressivo) throws ManagerException {
			log.debug("[SigitMgr::ricercaScheda11_1] BEGIN");
			ArrayList<Scheda11> scheda11 = null;
			try
			{
				List<SigitVCompGtDettDto> listControlli = getDbMgr().getCompGtProgrDett(codiceImpianto, progressivo);

				scheda11 = MapDto.mapToScheda11_1(listControlli);

			}
			catch (DbManagerException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::ricercaScheda11_1] END");
			}
			return scheda11;
		}
		*/

		/*
		public List<SigitVTotImpiantoDto> cercaResponsabiliAttiviByCodImpianto(Integer codiceImpianto)  throws ManagerException
		{
			boolean isImportabile = false;
			log.debug("[SigitMgr::cercaResponsabiliAttiviByCodImpianto] BEGIN");
			try
			{
				return getDbMgr().cercaResponsabiliAttiviByCodImpianto(codiceImpianto);
							}
			catch (DbManagerException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::cercaResponsabiliAttiviByCodImpianto] END");
			}
		}
		*/

		public boolean isLibrettoImportabile(Integer codiceImpianto)  throws ManagerException
		{
			boolean isImportabile = false;
			log.debug("[SigitMgr::isLibrettoImportabile] BEGIN");
			try
			{
				SigitTControlloLibrettoDto controlloLib = getDbMgr().findControlloLibretto(ConvertUtil.convertToString(codiceImpianto));


				//SigitTImportXmlLibDto importXml = getDbMgr().getImportLibrettoByIdImpianto(codiceImpianto);

				log.debug("Recupero 0 codiceImpianto: "+codiceImpianto);
				log.debug("Recupero 1 check: "+controlloLib);
				//log.debug("Recupero 2 librettoList: "+librettoList);
				//log.debug("Recupero 3 importXml: "+importXml);

				log.debug("Controllo 0 codiceImpianto: "+(codiceImpianto != null));
				log.debug("Controllo 1 check: "+(controlloLib == null || !ConvertUtil.convertToBooleanAllways(controlloLib.getFlgL1Controlloweb())));
				//log.debug("Controllo 2 librettoList: "+(librettoList == null || librettoList.size() == 0));
				//log.debug("Controllo 3 importXml: "+(importXml == null));

				if (codiceImpianto != null && (controlloLib == null || !ConvertUtil.convertToBooleanAllways(controlloLib.getFlgL1Controlloweb())))
				{
					List<SigitTLibrettoDto> librettoList = getDbMgr().getListaLibrettiByCodiceImpianto(codiceImpianto);

					if (librettoList == null || librettoList.size() == 0)
					{
						isImportabile = true;
					}
				}

				log.debug("isImportabile: "+isImportabile);

			}
			catch (ManagerException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::isLibrettoImportabile] END");
			}
			return isImportabile;
		}

		public boolean isLibrettoImportabileOLD(Integer codiceImpianto)  throws ManagerException
		{
			boolean isImportabile = false;
			log.debug("[SigitMgr::isLibrettoImportabile] BEGIN");
			try
			{
				SigitTControlloLibrettoDto controlloLib = getDbMgr().findControlloLibretto(ConvertUtil.convertToString(codiceImpianto));

				List<SigitTLibrettoDto> librettoList = getDbMgr().getListaLibrettiByCodiceImpianto(codiceImpianto);

				SigitTImportXmlLibDto importXml = getDbMgr().getImportLibrettoByIdImpianto(codiceImpianto);

				if (log.isDebugEnabled())
				{
					log.debug("Recupero 0 codiceImpianto: "+codiceImpianto);
					log.debug("Recupero 1 check: "+controlloLib);
					log.debug("Recupero 2 librettoList: "+librettoList);
					log.debug("Recupero 3 importXml: "+importXml);

					log.debug("Controllo 0 codiceImpianto: "+(codiceImpianto != null));
					log.debug("Controllo 1 check: "+(controlloLib == null || !ConvertUtil.convertToBooleanAllways(controlloLib.getFlgL1Controlloweb())));
					log.debug("Controllo 2 librettoList: "+(librettoList == null || librettoList.size() == 0));
					log.debug("Controllo 3 importXml: "+(importXml == null));
				}

				if (codiceImpianto != null && (controlloLib == null || !ConvertUtil.convertToBooleanAllways(controlloLib.getFlgL1Controlloweb())) &&
						(librettoList == null || librettoList.size() == 0) &&
						importXml == null)
				{
					isImportabile = true;
				}

				log.debug("isImportabile: "+isImportabile);

			}
			catch (ManagerException e) {
				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally {
				log.debug("[SigitMgr::isLibrettoImportabile] END");
			}
			return isImportabile;
		}


		public Integer contaComponenti4ByFilter (String codiceImpianto, Integer progressivo, String tipoComponente4) throws DbManagerException {
			log.debug("[SigitMgr::contaComponenti4ByFilter] START");
			List output = null;
			CompFilter filter = new CompFilter(codiceImpianto, progressivo != null ? progressivo.toString() : null);
			try {
				if (Constants.TIPO_COMPONENTE_CG.equals(tipoComponente4)) {
					output = getDbMgr().getSigitTCompCgDao().findByExample(filter);
				} else if ( Constants.TIPO_COMPONENTE_GT.equals(tipoComponente4)) {
					output = getDbMgr().getSigittCompGtDao().findByExample(filter);
				} else if (Constants.TIPO_COMPONENTE_SC.equals(tipoComponente4)) {
					output = getDbMgr().getSigitTCompScDao().findByExample(filter);
				} else if (Constants.TIPO_COMPONENTE_GF.equals(tipoComponente4)) {
					output = getDbMgr().getSigitTCompGfDao().findByExample(filter);
				}

				if (output != null) {
					return output.size();
				}
				return 0;
			} catch (Exception e) {
				Message msg = null;
				if (e instanceof DbManagerException) {
					msg = ((DbManagerException) e).getMsg();
				}
				throw new DbManagerException(e, msg == null? new Message(Messages.ERROR_RECUPERO_DB) : msg);
			} finally {
				log.debug("[SigitMgr::contaComponenti4ByFilter] END");
			}
		}



		public Object cercaComponente4AttivaByFilter(String codiceImpianto, Integer progressivo, String tipoComponente) throws DbManagerException {
			log.debug("[SigitMgr::cercaComponente4AttivaByFilter] START");
			CompFilter filter = new CompFilter(codiceImpianto, progressivo != null ? progressivo.toString() : null);
			Object output = null;
			List outputList = null;
			try {
				if (Constants.TIPO_COMPONENTE_CG.equals(tipoComponente)) {
					outputList = getDbMgr().getSigitTCompCgDao().findByExample(filter);
					if (outputList != null && !outputList.isEmpty()) {
						output = MapDto.mapToComponenteCG((SigitTCompCgDto) outputList.get(0), null, null);
					}
				} else if (Constants.TIPO_COMPONENTE_GT.equals(tipoComponente)) {
					outputList = getDbMgr().getSigittCompGtDao().findByExample(filter);
					if (outputList != null && !outputList.isEmpty()) {
						output = MapDto.mapToComponenteGT((SigitTCompGtDto) outputList.get(0), null, null);
					}
				} else if (Constants.TIPO_COMPONENTE_SC.equals(tipoComponente)) {
					outputList = getDbMgr().getSigitTCompScDao().findByExample(filter);
					if (outputList != null && !outputList.isEmpty()) {
						output = MapDto.mapToComponenteSC((SigitTCompScDto) outputList.get(0), null);
					}
				} else if (Constants.TIPO_COMPONENTE_GF.equals(tipoComponente)) {
					outputList = getDbMgr().getSigitTCompGfDao().findByExample(filter);
					if (outputList != null && !outputList.isEmpty()) {
						output = MapDto.mapToComponenteGF((SigitTCompGfDto) outputList.get(0), null, null);
					}
				}
			} catch (Exception e) {
				Message msg = null;
				if (e instanceof DbManagerException) {
					msg = ((DbManagerException) e).getMsg();
				}
				throw new DbManagerException(e, msg == null ? new Message(Messages.ERROR_RECUPERO_DB) : msg);
			} finally {
				log.debug("[SigitMgr::cercaComponente4AttivaByFilter] END");
			}
			return output;


		}



		public List<ComponenteSC> cercaComponentiScByFilter (String codiceImpianto, Integer progressivo, boolean componentiDistinte) throws DbManagerException {
			log.debug("[SigitMgr::cercaComponentiScByFilter] START");
			//lightLoad = booleano che coordina se caricare anche le info delle entita' collegate come fabbricante e combustibile
			CompFilter filter = new CompFilter(codiceImpianto, progressivo != null ? progressivo.toString() : null);
			List<ComponenteSC> listaOutput = new ArrayList<ComponenteSC>();

			try {
				List<SigitTCompScDto> output = getDbMgr().getSigitTCompScDao().findByExample(filter);
				if (output != null) {

					Map<BigDecimal, String> dizionarioFabbricante = new HashMap<BigDecimal, String>();
					Set<BigDecimal> componentKeys = new HashSet<BigDecimal>();

					//crea un dizionario temporaneo dei fabbricanti usati e contestualmente costruisce la componente grafica
					for (SigitTCompScDto result : output) {
						if (dizionarioFabbricante.get(result.getFkMarca()) == null ) {
							SigitDMarcaDto fabbricante = getDbMgr().getMarcaById(ConvertUtil.convertToInteger(result.getFkMarca()));
							if (fabbricante != null) {
								dizionarioFabbricante.put(fabbricante.getIdMarca(), fabbricante.getDesMarca());
							}
						}

						if (componentiDistinte) { //se si vogliono componenti distinte, l'oggetto viene aggiunto nella lista solo se ha un progressivo diverso da quelli gestiti fino a quel momento
							if (!componentKeys.contains(result.getProgressivo())) {
								componentKeys.add(result.getProgressivo());
								listaOutput.add(MapDto.mapToComponenteSC(result, dizionarioFabbricante));
							}
						} else {
							//aggiunta a prescindere
							listaOutput.add(MapDto.mapToComponenteSC(result, dizionarioFabbricante));
						}
					}
				}
				return listaOutput;
			} catch (Exception e) {
				Message msg = null;
				if (e instanceof DbManagerException) {
					msg = ((DbManagerException) e).getMsg();
				}
				throw new DbManagerException(e, msg == null? new Message(Messages.ERROR_RECUPERO_DB) : msg);
			} finally {
				log.debug("[SigitMgr::cercaComponentiScByFilter] END");
			}
		}

		public List<ComponenteGF> cercaComponentiGfByFilter (String codiceImpianto, Integer progressivo, boolean lightLoad, boolean componentiDistinte) throws DbManagerException {
			log.debug("[SigitMgr::cercaComponentiGfByFilter] START");
			//lightLoad = booleano che coordina se caricare anche le info delle entita' collegate come fabbricante e combustibile
			CompFilter filter = new CompFilter(codiceImpianto, progressivo != null ? progressivo.toString() : null);
			List<ComponenteGF> listaOutput = new ArrayList<ComponenteGF>();

			try {
				List<SigitTCompGfDto> output = getDbMgr().getSigitTCompGfDao().findByExample(filter);
				if (output != null) {

					Map<BigDecimal, String> dizionarioFabbricante = new HashMap<BigDecimal, String>();
					Map<BigDecimal, String> dizionarioCombustibile =new HashMap<BigDecimal, String>();
					Set<BigDecimal> componentKeys = new HashSet<BigDecimal>();

					if (!lightLoad) {
						dizionarioCombustibile = getDizionarioCombustibile();
					}
					//crea un dizionario temporaneo dei fabbricanti usati e contestualmente costruisce la componente grafica
					for (SigitTCompGfDto result : output) {
						if (dizionarioFabbricante.get(result.getFkMarca()) == null ) {
							SigitDMarcaDto fabbricante = getDbMgr().getMarcaById(ConvertUtil.convertToInteger(result.getFkMarca()));
							if (fabbricante != null) {
								dizionarioFabbricante.put(fabbricante.getIdMarca(), fabbricante.getDesMarca());
							}
						}

						if (componentiDistinte) { //se si vogliono componenti distinte, l'oggetto viene aggiunto nella lista solo se ha un progressivo diverso da quelli gestiti fino a quel momento
							if (!componentKeys.contains(result.getProgressivo())) {
								componentKeys.add(result.getProgressivo());
								listaOutput.add(MapDto.mapToComponenteGF(result, dizionarioFabbricante, dizionarioCombustibile));
							}
						} else {
							//aggiunta a prescindere
							listaOutput.add(MapDto.mapToComponenteGF(result, dizionarioFabbricante, dizionarioCombustibile));
						}
					}
				}
				return listaOutput;
			} catch (Exception e) {
				Message msg = null;
				if (e instanceof DbManagerException) {
					msg = ((DbManagerException) e).getMsg();
				}
				throw new DbManagerException(e, msg == null? new Message(Messages.ERROR_RECUPERO_DB) : msg);
			} finally {
				log.debug("[SigitMgr::cercaComponentiCgByFilter] END");
			}
		}

		public List<ComponenteCG> cercaComponentiCgByFilter (String codiceImpianto, Integer progressivo, boolean lightLoad, boolean componentiDistinte) throws DbManagerException {
			log.debug("[SigitMgr::cercaComponentiCgByFilter] START");
			//lightLoad = booleano che coordina se caricare anche le info delle entita' collegate come fabbricante e combustibile
			CompFilter filter = new CompFilter(codiceImpianto, progressivo != null ? progressivo.toString() : null);
			List<ComponenteCG> listaOutput = new ArrayList<ComponenteCG>();

			try {
				List<SigitTCompCgDto> output = getDbMgr().getSigitTCompCgDao().findByExample(filter);
				if (output != null) {

					Map<BigDecimal, String> dizionarioFabbricante = new HashMap<BigDecimal, String>();
					Map<BigDecimal, String> dizionarioCombustibile =new HashMap<BigDecimal, String>();
					Set<BigDecimal> componentKeys = new HashSet<BigDecimal>();

					if (!lightLoad) {
						dizionarioCombustibile = getDizionarioCombustibile();
					}
					//crea un dizionario temporaneo dei fabbricanti usati e contestualmente costruisce la componente grafica
					for (SigitTCompCgDto result : output) {
						if (dizionarioFabbricante.get(result.getFkMarca()) == null ) {
							SigitDMarcaDto fabbricante = getDbMgr().getMarcaById(ConvertUtil.convertToInteger(result.getFkMarca()));
							if (fabbricante != null) {
								dizionarioFabbricante.put(fabbricante.getIdMarca(), fabbricante.getDesMarca());
							}
						}

						if (componentiDistinte) { //se si vogliono componenti distinte, l'oggetto viene aggiunto nella lista solo se ha un progressivo diverso da quelli gestiti fino a quel momento
							if (!componentKeys.contains(result.getProgressivo())) {
								componentKeys.add(result.getProgressivo());
								listaOutput.add(MapDto.mapToComponenteCG(result, dizionarioFabbricante, dizionarioCombustibile));
							}
						} else {
							//aggiunta a prescindere
							listaOutput.add(MapDto.mapToComponenteCG(result, dizionarioFabbricante, dizionarioCombustibile));
						}
					}
				}
				return listaOutput;
			} catch (Exception e) {
				Message msg = null;
				if (e instanceof DbManagerException) {
					msg = ((DbManagerException) e).getMsg();
				}
				throw new DbManagerException(e, msg == null? new Message(Messages.ERROR_RECUPERO_DB) : msg);
			} finally {
				log.debug("[SigitMgr::cercaComponentiCgByFilter] END");
			}
		}

		public List<ComponenteGT> cercaComponentiGtByFilter (String codiceImpianto, Integer progressivo, boolean lightLoad, boolean componentiDistinte) throws DbManagerException {
			log.debug("[SigitMgr::cercaComponentiGtByFilter] START");
			//lightLoad = booleano che coordina se caricare anche le info delle entita' collegate come fabbricante e combustibile
//			SigitTCompGtPk pk = new SigitTCompGtPk(Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToBigDecimal(progressivo),
//					null, ConvertUtil.convertToBigDecimal(codiceImpianto));

			List<ComponenteGT> listaOutput = new ArrayList<ComponenteGT>();

			try {
//				List<SigitTCompGtDto> output = getDbMgr().getSigittCompGtDao().findFindByExample(pk);
				List<SigitTCompGtDto> output = getDbMgr().getSigittCompGtDao().findByExample(new CompFilter(codiceImpianto, progressivo != null ? progressivo.toString() : null));
				if (output != null) {

					Map<BigDecimal, String> dizionarioFabbricante = new HashMap<BigDecimal, String>();
					Map<BigDecimal, String> dizionarioCombustibile =new HashMap<BigDecimal, String>();
					Set<BigDecimal> componentKeys = new HashSet<BigDecimal>();

					if (!lightLoad) {
						dizionarioCombustibile = getDizionarioCombustibile();
					}
					//crea un dizionario temporaneo dei fabbricanti usati e contestualmente costruisce la componente grafica
					for (SigitTCompGtDto result : output) {
						if (dizionarioFabbricante.get(result.getFkMarca()) == null ) {
							SigitDMarcaDto fabbricante = getDbMgr().getMarcaById(ConvertUtil.convertToInteger(result.getFkMarca()));
							if (fabbricante != null) {
								dizionarioFabbricante.put(fabbricante.getIdMarca(), fabbricante.getDesMarca());
							}
						}

						if (componentiDistinte) { //se si vogliono componenti distinte, l'oggetto viene aggiunto nella lista solo se ha un progressivo diverso da quelli gestiti fino a quel momento
							if (!componentKeys.contains(result.getProgressivo())) {
								componentKeys.add(result.getProgressivo());
								listaOutput.add(MapDto.mapToComponenteGT(result, dizionarioFabbricante, dizionarioCombustibile));
							}
						} else {
							//aggiunta a prescindere
							listaOutput.add(MapDto.mapToComponenteGT(result, dizionarioFabbricante, dizionarioCombustibile));
						}
					}
				}
				return listaOutput;
			} catch (Exception e) {
				Message msg = null;
				if (e instanceof DbManagerException) {
					msg = ((DbManagerException) e).getMsg();
				}
				throw new DbManagerException(e, msg == null? new Message(Messages.ERROR_RECUPERO_DB) : msg);
			} finally {
				log.debug("[SigitMgr::cercaComponentiGtByFilter] END");
			}
		}

		public Integer contaComponentiBrRcByFilter (String codiceImpianto, Integer progressivo, String tipoComponente) throws DbManagerException {

			log.debug("[SigitMgr::contaComponentiBrRcByFilter] START");
			SigitTCompBrRcDto filter = costruisciFiltroBrRc(codiceImpianto, progressivo, tipoComponente);

			try {
				List<SigitTCompBrRcDto> output = getDbMgr().getSigitTCompBrRcDao().findByTipoAndCodImpiantoOrdered(filter);
				if (output != null) {
					return output.size();
				}
				return 0;
			} catch (Exception e) {
				Message msg = null;
				if (e instanceof DbManagerException) {
					msg = ((DbManagerException) e).getMsg();
				}
				throw new DbManagerException(e, msg == null? new Message(Messages.ERROR_RECUPERO_DB) : msg);
			} finally {
				log.debug("[SigitMgr::contaComponentiBrRcByFilter] END");
			}


		}

		public List<ComponenteBRRC> cercaComponentiBrRcByFilter (String codiceImpianto, Integer progressivo, String tipoComponente, boolean lightLoad, boolean componentiDistinte) throws DbManagerException {
			log.debug("[SigitMgr::cercaComponentiBrRcByFilter] START");
			//lightLoad = booleano che coordina se caricare anche le info delle entita' collegate come fabbricante e combustibile
			SigitTCompBrRcDto filter = costruisciFiltroBrRc(codiceImpianto, progressivo, tipoComponente);
			List<ComponenteBRRC> listaOutput = new ArrayList<ComponenteBRRC>();

			try {
				List<SigitTCompBrRcDto> output = getDbMgr().getSigitTCompBrRcDao().findByTipoAndCodImpiantoOrdered(filter);
				if (output != null) {

					Map<BigDecimal, String> dizionarioFabbricante = new HashMap<BigDecimal, String>();
					Map<BigDecimal, String> dizionarioCombustibile =new HashMap<BigDecimal, String>();
					Set<BigDecimal> componentKeys = new HashSet<BigDecimal>();

					if (!lightLoad) {
						dizionarioCombustibile = getDizionarioCombustibile();
					}
					//crea un dizionario temporaneo dei fabbricanti usati e contestualmente costruisce la componente grafica
					for (SigitTCompBrRcDto result : output) {
						if (dizionarioFabbricante.get(result.getFkMarca()) == null ) {
							SigitDMarcaDto fabbricante = getDbMgr().getMarcaById(ConvertUtil.convertToInteger(result.getFkMarca()));
							if (fabbricante != null) {
								dizionarioFabbricante.put(fabbricante.getIdMarca(), fabbricante.getDesMarca());
							}
						}

						if (componentiDistinte) {
							if (!componentKeys.contains(result.getProgressivoBrRc())) {
								componentKeys.add(result.getProgressivoBrRc());
								listaOutput.add(MapDto.mapToComponenteBRRC(result, dizionarioFabbricante, dizionarioCombustibile));
							}
						} else {
							//aggiunta a prescindere
							listaOutput.add(MapDto.mapToComponenteBRRC(result, dizionarioFabbricante, dizionarioCombustibile));
						}
					}
				}
				return listaOutput;
			} catch (Exception e) {
				Message msg = null;
				if (e instanceof DbManagerException) {
					msg = ((DbManagerException) e).getMsg();
				}
				throw new DbManagerException(e, msg == null? new Message(Messages.ERROR_RECUPERO_DB) : msg);
			} finally {
				log.debug("[SigitMgr::cercaComponentiBrRcByFilter] END");
			}
		}

		private SigitTCompBrRcDto costruisciFiltroBrRc (String codiceImpianto, Integer progressivo, String tipoComponente) {
			SigitTCompBrRcDto filter = new SigitTCompBrRcDto();
			filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
			filter.setTipologiaBrRc(tipoComponente);
			if (progressivo != null) {
				filter.setProgressivoBrRc(ConvertUtil.convertToBigDecimal(progressivo));
			}
			return filter;
		}

	public ArrayList<CodeDescription> getListaComponentiGT(String codiceImpianto) throws DbManagerException {
		log.debug("[SigitMgr::creaListaComponentiGT] START");
		List<CodeDescription> listaOutput = new ArrayList<CodeDescription>();


		try {
//			List<SigitTCompGtDto> listaGt = getDbMgr().getSigittCompGtDao().findFindByExample(filter);
			List<SigitTCompGtDto> listaGt = getDbMgr().getSigittCompGtDao().findByExample(new CompFilter(codiceImpianto, null));
			Set<String> differentKeys = new HashSet<String>();
			if (listaGt != null) {
				for (SigitTCompGtDto gt : listaGt) {
					String currentKey = gt.getIdTipoComponente().toUpperCase() + "-" + gt.getProgressivo();
					if (!differentKeys.contains(currentKey)) {
						CodeDescription newRow = new CodeDescription();
						newRow.setCode(ConvertUtil.convertToString(gt.getProgressivo()));
						newRow.setDescription(currentKey);
						listaOutput.add(newRow);
						differentKeys.add(currentKey);
					}
				}
			}
			return (ArrayList<CodeDescription>) listaOutput;
		} catch (Exception e) {
			Message msg = null;
			if (e instanceof DbManagerException) {
				msg = ((DbManagerException) e).getMsg();
			}
			throw new DbManagerException(e, msg == null ? new Message(Messages.ERROR_RECUPERO_DB) : msg);
		} finally {
			log.debug("[SigitMgr::creaListaComponentiGT] END");
		}

	}

	public Integer contaREE (String codiceImpianto, String dataInstallazione, String tipoComponente, String progressivo) throws DbManagerException {
		CompFilter filter = new CompFilter(codiceImpianto, progressivo, ConvertUtil.convertToSqlDate(dataInstallazione));
		filter.setTipoComponente(tipoComponente);

		Integer count = getDbMgr().contaAllegatiCompByFilter(filter, Arrays.asList(Constants.ID_STATO_RAPPORTO_BOZZA, Constants.ID_STATO_RAPPORTO_INVIATO));

		return count;
	}


	public Integer verificaREENomina3Resp(String codiceImpianto, String dataInizioContratto, String dataFineContratto) throws DbManagerException {
		log.debug("[SigitMgr::verificaREENomina3Resp] INIZIO");

		Integer contaREE = 0;
		FiltroRicercaAllegati filtro = new FiltroRicercaAllegati();
		filtro.setCodiceImpianto(ConvertUtil.convertToInteger(codiceImpianto));
		filtro.setDataControlloDa(ReplaceSpecialCharUtils.sanitize(dataInizioContratto));
		filtro.setDataControlloA(ReplaceSpecialCharUtils.sanitize(dataFineContratto));
		filtro.setIdStatoAllegato(Constants.ID_STATO_RAPPORTO_INVIATO);

		filtro.setListaTipoDocumento(Arrays.asList(ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_1), ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_1B), ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_2),
				ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_3), ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_4),
				ConvertUtil.convertToInteger(Constants.RAPP_PROVA_ALLEGATO_TIPO_1), ConvertUtil.convertToInteger(Constants.RAPP_PROVA_ALLEGATO_TIPO_2),
				Constants.MANUTENZIONE_GT, Constants.MANUTENZIONE_GF, Constants.MANUTENZIONE_SC, Constants.MANUTENZIONE_CG));

		try {
			contaREE = getDbMgr().cercaAllegatiByFiltroCount(filtro);

		} catch (Exception e) {
			throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[SigitMgr::verificaREENomina3Resp] FINE");
		}

		return contaREE;

	}

	public void checkPresenzaREE (String codiceImpianto, String dataInstallazione, String tipoComponente, String progressivo) throws DbManagerException, ValidationManagerException {
		//CONTROLLA SE SULLA COMPONENTE CI SONO REE E PRENDE L'ULTIMO
		CompFilter filter = new CompFilter(codiceImpianto, progressivo, ConvertUtil.convertToSqlDate(dataInstallazione));
		filter.setTipoComponente(tipoComponente);

		List<SigitVAllegatiComponentiDto> listaAllegati = getDbMgr().cercaAllegatiCompByFilter(filter, Arrays.asList(Constants.ID_STATO_RAPPORTO_BOZZA, Constants.ID_STATO_RAPPORTO_INVIATO));
		SigitVAllegatiComponentiDto ultimo = null;
		if (listaAllegati != null && !listaAllegati.isEmpty()) {
			ultimo = listaAllegati.get(listaAllegati.size()-1);
		}

		if (ultimo!= null) {
			throw new ValidationManagerException(new Message(Messages.S164_3, ConvertUtil.convertToString(ultimo.getDataControllo())));
		}
	}

	public void checkPresenzaREEComponenteDaEliminare (String codiceImpianto, String tipoComponente, String progressivo) throws DbManagerException, ValidationManagerException {
		//CONTROLLA SE SULLA COMPONENTE CI SONO REE E PRENDE L'ULTIMO
		CompFilter filter = new CompFilter(codiceImpianto, progressivo, tipoComponente);

		List<SigitRComp4ManutAllDto> listaIdAllegati = getDbMgr().cercaComp4ManutAllByComp(filter);
		SigitRComp4ManutAllDto ultimo = null;
		if (listaIdAllegati != null && !listaIdAllegati.isEmpty()) {
			ultimo = listaIdAllegati.get(listaIdAllegati.size()-1);
		}

		if (ultimo!= null) {
			SigitTAllegatoDto allegato = getDbMgr().cercaSigitTAllegatoById(ultimo.getIdAllegato());

			throw new ValidationManagerException(new Message(Messages.S164_3, ConvertUtil.convertToString(allegato.getDataControllo())));
		}
	}


	public void checkPresenzaBRRCbyGT(String codiceImpiantoGT, String dataInstallazioneGT, String progressivoGT) throws DbManagerException {
		getDbMgr().verificaBRRCByGT(codiceImpiantoGT, dataInstallazioneGT, progressivoGT);
	}

	public void checkREESostituzioneDismissone(String codiceImpianto, String tipoComponente, String progressivo, String dataInstallazione, String dataDismissione) throws DbManagerException, ValidationManagerException {
		CompFilter filter = new CompFilter(codiceImpianto, progressivo, ConvertUtil.convertToSqlDate(dataInstallazione));
		filter.setTipoComponente(ReplaceSpecialCharUtils.sanitize(tipoComponente));
		List<SigitVAllegatiComponentiDto> dtoList = getDbMgr().cercaAllegatiCompByFilter(filter, Arrays.asList(Constants.ID_STATO_RAPPORTO_BOZZA, Constants.ID_STATO_RAPPORTO_INVIATO));

		if (dtoList != null && !dtoList.isEmpty()) {

			SigitVAllegatiComponentiDto ree = dtoList.get(dtoList.size()-1);
			//SE LA DATA DI DISMISSIONE PRECEDE LA DATA CONTROLLO ALLORA VA IN ERRORE
			if (DateUtil.checkDateOrder(dataDismissione, ConvertUtil.convertToString(ree.getDataControllo()), false)) {
				throw new ValidationManagerException(new Message(Messages.S164_3, ConvertUtil.convertToString(ree.getDataControllo())));
			}
		}
	}

	@Transactional
	public void salvaComponenteSC(String codImpianto, String progressivo, ComponenteSC componente, ArrayList<ComponenteSC> compList, Integer idPersonaGiuridica, UtenteLoggato utenteMod, Boolean nuovaComponente) throws ManagerException
	{
		log.debug("SigitMgr:salvaComponenteSC - START");
		BigDecimal codImpiantoBigD = ConvertUtil.convertToBigDecimal(codImpianto);
		BigDecimal progressivoBigD = ConvertUtil.convertToBigDecimal(progressivo);
		try
		{
			//SE NUOVA COMPONENTE VIENE CREATA LA MADRE COMP4
			if (nuovaComponente) {

				getDbMgr().salvaComp4(codImpiantoBigD, progressivoBigD, Constants.TIPO_COMPONENTE_SC);
			}

			/*
			Integer idPersonaGiuridica = utenteMod != null && utenteMod.getRuolo() != null ? utenteMod.getRuolo().getIdPersonaGiuridica() : null;

			if (idPersonaGiuridica == null) {
				SigitRImpRuoloPfpgDto installatore = getInstallatoreImpianto(codImpianto);
				if (installatore != null) {
					idPersonaGiuridica = ConvertUtil.convertToInteger(installatore.getFkPersonaGiuridica());
				}
			}
			*/

			String cfUtenteMod = utenteMod != null ? utenteMod.getCodiceFiscale() : null;

			//SI VERIFICA SE INSERIRE O NO LA COMP4_MANUT
			getDbMgr().insertComp4Manut(codImpiantoBigD, Constants.TIPO_COMPONENTE_SC, progressivoBigD, idPersonaGiuridica, cfUtenteMod, it.csi.sigit.sigitwebn.business.dao.util.Constants.ID_RUOLO_MANUTENTORE_ALL_3);

			ArrayList<ComponenteSC> compListAll = new ArrayList<ComponenteSC>();
			compListAll.add(componente);

			if (compList != null) {
				compListAll.addAll(compList);
			}

			getDbMgr().updateListComponentiSC(compListAll, codImpianto, progressivo, cfUtenteMod);

			SigitTComp4Pk pkComp4 = new SigitTComp4Pk(codImpiantoBigD, Constants.TIPO_COMPONENTE_SC, progressivoBigD);
			//CDU 036 (versione 1.1): aggiunto salvataggio azione su comp4
			getDbMgr().salvaAzioneComp4(pkComp4, componente.getDataInstallazione(), cfUtenteMod, utenteMod.getRuolo());
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[SigitMgr::salvaComponenteSC] END");
		}
	}


	@Transactional
	public void salvaComponenteGF(String codImpianto, String progressivo, ComponenteGF componente, ArrayList<ComponenteGF> compList, Integer idPersonaGiuridica, UtenteLoggato utenteMod, Boolean nuovaComponente) throws ManagerException
	{
		log.debug("SigitMgr:salvaComponenteGF - START");
		BigDecimal codImpiantoBigD = ConvertUtil.convertToBigDecimal(codImpianto);
		BigDecimal progressivoBigD = ConvertUtil.convertToBigDecimal(progressivo);
		try
		{
			//SE NUOVA COMPONENTE VIENE CREATA LA MADRE COMP4
			if (nuovaComponente) {

				getDbMgr().salvaComp4(codImpiantoBigD, progressivoBigD, Constants.TIPO_COMPONENTE_GF);
			}

			/*
			Integer idPersonaGiuridica = utenteMod != null && utenteMod.getRuolo() != null ? utenteMod.getRuolo().getIdPersonaGiuridica() : null;

			if (idPersonaGiuridica == null) {
				SigitRImpRuoloPfpgDto installatore = getInstallatoreImpianto(codImpianto);
				if (installatore != null) {
					idPersonaGiuridica = ConvertUtil.convertToInteger(installatore.getFkPersonaGiuridica());
				}
			}
			*/

			String cfUtenteMod = utenteMod != null ? utenteMod.getCodiceFiscale() : null;

			//SI VERIFICA SE INSERIRE O NO LA COMP4_MANUT
			getDbMgr().insertComp4Manut(codImpiantoBigD, Constants.TIPO_COMPONENTE_GF, progressivoBigD, idPersonaGiuridica, cfUtenteMod, it.csi.sigit.sigitwebn.business.dao.util.Constants.ID_RUOLO_MANUTENTORE_ALL_2);

			ArrayList<ComponenteGF> compListAll = new ArrayList<ComponenteGF>();
			compListAll.add(componente);

			if (compList != null) {
				compListAll.addAll(compList);
			}

			getDbMgr().updateListComponentiGF(compListAll, codImpianto, progressivo, cfUtenteMod);
			SigitTComp4Pk pkComp4 = new SigitTComp4Pk(codImpiantoBigD, Constants.TIPO_COMPONENTE_GF, progressivoBigD);
			//CDU 035 (versione 1.1): aggiunto salvataggio azione su comp4
			getDbMgr().salvaAzioneComp4(pkComp4, componente.getDataInstallazione(), cfUtenteMod, utenteMod.getRuolo());
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[SigitMgr::salvaComponenteSC] END");
		}
	}

	@Transactional
	public void salvaComponenteCG(String codImpianto, String progressivo, ComponenteCG componente, ArrayList<ComponenteCG> compList, Integer idPersonaGiuridica, UtenteLoggato utenteMod, Boolean nuovaComponente) throws ManagerException
	{
		log.debug("SigitMgr:salvaComponenteCG - START");
		BigDecimal codImpiantoBigD = ConvertUtil.convertToBigDecimal(codImpianto);
		BigDecimal progressivoBigD = ConvertUtil.convertToBigDecimal(progressivo);
		try
		{
			//SE NUOVA COMPONENTE VIENE CREATA LA MADRE COMP4
			if (nuovaComponente) {

				getDbMgr().salvaComp4(codImpiantoBigD, progressivoBigD, Constants.TIPO_COMPONENTE_CG);
			}

			/*
			Integer idPersonaGiuridica = utenteMod != null && utenteMod.getRuolo() != null ? utenteMod.getRuolo().getIdPersonaGiuridica() : null;

			if (idPersonaGiuridica == null) {
				SigitRImpRuoloPfpgDto installatore = getInstallatoreImpianto(codImpianto);
				if (installatore != null) {
					idPersonaGiuridica = ConvertUtil.convertToInteger(installatore.getFkPersonaGiuridica());
				}
			}
			*/

			String cfUtenteMod = utenteMod != null ? utenteMod.getCodiceFiscale() : null;

			//SI VERIFICA SE INSERIRE O NO LA COMP4_MANUT
			getDbMgr().insertComp4Manut(codImpiantoBigD, Constants.TIPO_COMPONENTE_CG, progressivoBigD, idPersonaGiuridica, cfUtenteMod, it.csi.sigit.sigitwebn.business.dao.util.Constants.ID_RUOLO_MANUTENTORE_ALL_4);

			ArrayList<ComponenteCG> compListAll = new ArrayList<ComponenteCG>();
			compListAll.add(componente);

			if (compList != null) {
				compListAll.addAll(compList);
			}

			getDbMgr().updateListComponentiCG(compListAll, codImpianto, progressivo, cfUtenteMod);
			SigitTComp4Pk pkComp4 = new SigitTComp4Pk(codImpiantoBigD, Constants.TIPO_COMPONENTE_CG, progressivoBigD);
			//CDU 035 (versione 1.1): aggiunto salvataggio azione su comp4
			getDbMgr().salvaAzioneComp4(pkComp4, componente.getDataInstallazione(), cfUtenteMod, utenteMod.getRuolo());
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[SigitMgr::salvaComponenteCG] END");
		}

	}


	@Transactional
	public void salvaComponenteGT(String codImpianto, String progressivo, ComponenteGT componente, ArrayList<ComponenteGT> compList, Integer idPersonaGiuridica, UtenteLoggato utenteMod, Boolean nuovaComponente) throws ManagerException
	{
		log.debug("SigitMgr:salvaComponenteGT - START");
		BigDecimal codImpiantoBigD = ConvertUtil.convertToBigDecimal(codImpianto);
		BigDecimal progressivoBigD = ConvertUtil.convertToBigDecimal(progressivo);
		try
		{
			//SE NUOVA COMPONENTE VIENE CREATA LA MADRE COMP4
			if (nuovaComponente) {

				getDbMgr().salvaComp4(codImpiantoBigD, progressivoBigD, Constants.TIPO_COMPONENTE_GT);
			}

			/*
			Integer idPersonaGiuridica = utenteMod != null && utenteMod.getRuolo() != null ? utenteMod.getRuolo().getIdPersonaGiuridica() : null;

			if (idPersonaGiuridica == null) {
				SigitRImpRuoloPfpgDto installatore = getInstallatoreImpianto(codImpianto);
				if (installatore != null) {
					idPersonaGiuridica = ConvertUtil.convertToInteger(installatore.getFkPersonaGiuridica());
				}
			}
			*/

			String cfUtenteMod = utenteMod != null ? ReplaceSpecialCharUtils.sanitize(utenteMod.getCodiceFiscale()) : null;

			//SI VERIFICA SE INSERIRE O NO LA COMP4_MANUT
			getDbMgr().insertComp4Manut(codImpiantoBigD, Constants.TIPO_COMPONENTE_GT, progressivoBigD, idPersonaGiuridica, cfUtenteMod, it.csi.sigit.sigitwebn.business.dao.util.Constants.ID_RUOLO_MANUTENTORE_ALL_1);

			ArrayList<ComponenteGT> compListAll = new ArrayList<ComponenteGT>();
			compListAll.add(componente);

			if (compList != null) {
				compListAll.addAll(compList);
			}

			getDbMgr().updateListComponentiGT(compListAll, codImpianto, progressivo, cfUtenteMod);
			SigitTComp4Pk pkComp4 = new SigitTComp4Pk(codImpiantoBigD, Constants.TIPO_COMPONENTE_GT, progressivoBigD);
			//CDU 032 (versione 1.1): aggiunto salvataggio azione su comp4
			getDbMgr().salvaAzioneComp4(pkComp4, componente.getDataInstallazione(), cfUtenteMod, utenteMod.getRuolo());


		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[SigitMgr::salvaComponenteGT] END");
		}

	}

	public Integer getImpresaAssociata(UtenteLoggato utente, String codImpiantoSelez) throws SigitRImpRuoloPfpgDaoException
	{
		Integer idPersonaGiuridica = utente != null && utente.getRuolo() != null
				? utente.getRuolo().getIdPersonaGiuridica()
						: null;

				if (idPersonaGiuridica == null) {
					SigitRImpRuoloPfpgDto installatore = getDbMgr().getInstallatoreImpianto(codImpiantoSelez);
					if (installatore != null) {
						idPersonaGiuridica = ConvertUtil.convertToInteger(installatore.getFkPersonaGiuridica());
					}
				}

				return idPersonaGiuridica;

	}

	public List<SigitTComp4Dto> getTComp4NonControllate(DettaglioManutenzione allegato) throws ManagerException {
		log.debug("[SigitMgr::getTComp4NonControllate] START");

		List<SigitTComp4Dto> dtoList = null;
		try {
			CompFilter filter = new CompFilter();
			filter.setCodImpianto(allegato.getCodiceImpianto());

			String tipoComponente = null;
			if(Constants.MANUTENZIONE_GT == allegato.getIdTipoManut())
			{
				tipoComponente = Constants.TIPO_COMPONENTE_GT;
			}
			else if(Constants.MANUTENZIONE_GF == allegato.getIdTipoManut())
			{
				tipoComponente = Constants.TIPO_COMPONENTE_GF;
			}
			else if(Constants.MANUTENZIONE_SC == allegato.getIdTipoManut())
			{
				tipoComponente = Constants.TIPO_COMPONENTE_SC;
			}
			else if(Constants.MANUTENZIONE_CG == allegato.getIdTipoManut())
			{
				tipoComponente = Constants.TIPO_COMPONENTE_CG;
			}

			filter.setTipoComponente(tipoComponente);

			filter.setListProgressivi(GenericUtil.recuperaProgressivo(allegato.getIdApparecchiature()));

			dtoList = getDbMgr().cercaTComp4NonControllateByFilter(filter);
			return dtoList;
		} catch (Exception e) {
			log.error("Errore getTComp4NonControllate", e);
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[SigitMgr::getTComp4NonControllate] END");
		}
	}

	public List<SigitTComp4Dto> getTComp4NonControllate(DettaglioAllegato allegato) throws ManagerException {
		log.debug("[SigitMgr::getTComp4NonControllate] START");

		List<SigitTComp4Dto> dtoList = null;
		try {

			String idTipoAllegato = allegato.getIdTipoAllegato();

			CompFilter filter = new CompFilter();
			filter.setCodImpianto(allegato.getCodiceImpianto());

			String tipoComponente = null;
			if(Constants.ALLEGATO_TIPO_1.equals(idTipoAllegato) ||
				Constants.ALLEGATO_TIPO_1B.equals(idTipoAllegato))
			{
				tipoComponente = Constants.TIPO_COMPONENTE_GT;
			}
			else if(Constants.ALLEGATO_TIPO_2.equals(idTipoAllegato))
			{
				tipoComponente = Constants.TIPO_COMPONENTE_GF;
			}
			else if(Constants.ALLEGATO_TIPO_3.equals(idTipoAllegato))
			{
				tipoComponente = Constants.TIPO_COMPONENTE_SC;
			}
			else if(Constants.ALLEGATO_TIPO_4.equals(idTipoAllegato))
			{
				tipoComponente = Constants.TIPO_COMPONENTE_CG;
			}
			else if(Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(idTipoAllegato))
			{
				tipoComponente = Constants.TIPO_COMPONENTE_GT;
			}
			else if(Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equals(idTipoAllegato))
			{
				tipoComponente = Constants.TIPO_COMPONENTE_GF;
			}

			filter.setTipoComponente(tipoComponente);

			filter.setListProgressivi(GenericUtil.recuperaProgressivo(allegato.getIdApparecchiature()));

			dtoList = getDbMgr().cercaTComp4NonControllateByFilter(filter);
			return dtoList;
		} catch (Exception e) {
			log.error("Errore getTComp4NonControllate", e);
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[SigitMgr::getTComp4NonControllate] END");
		}
	}

	public TipoGF getAllegatoRappProvaTipoGF (String idAllegato, String codiceImpianto) throws ServiceException {
		log.debug("[SigitMgr::getAllegatoRappProvaTipoGF] START");
		log.debug("[SigitMgr::getAllegatoRappProvaTipoGF] **************************************** ID ALLEGATO: "
				+ idAllegato);

		try {
			TipoGF tipoGF = new TipoGF();

			SigitTRappIspezGfDto dtoDb = getDbMgr().cercaTRappIspezGfById(ConvertUtil.convertToBigDecimal(idAllegato));

			if (dtoDb != null) {
				tipoGF.setInRiscaldamentoDesc(getElencoDescrizioniByTrattAcqua(codiceImpianto, "CLIMA"));
				tipoGF.setS1cDataRee(ConvertUtil.convertToString(dtoDb.getS1cDataRee()));
				tipoGF.setS1cFlgReeBollino(ConvertUtil.convertToInteger(dtoDb.getS1cFlgReeBollino()));
				tipoGF.setS1cFlgReeInviato(ConvertUtil.convertToInteger(dtoDb.getS1cFlgReeInviato()));
				tipoGF.setS1cNumBollino(ConvertUtil.convertToString(dtoDb.getS1cNumBollino()));
				tipoGF.setS1cSiglaBollino(dtoDb.getS1cSiglaBollino());
				tipoGF.setS1eDtPrimaInstallazione(ConvertUtil.convertToString(dtoDb.getS1eDtPrimaInstallazione()));
				tipoGF.setS1ePotTermicaMaxKw(ConvertUtil.convertToString(dtoDb.getS1ePotTermicaMaxKw()));
				tipoGF.setS1lDenomDelegat(dtoDb.getS1lDenomDelegato());
				tipoGF.setS1lFlgDelega(ConvertUtil.convertToInteger(dtoDb.getS1lFlgDelega()));
				tipoGF.setS2eFlgTrattH2ONonRich(ConvertUtil.convertToInteger(dtoDb.getS2eFlgTrattH2oNonRich()));
				tipoGF.setS3aFlgLocaleIntIdoneo(ConvertUtil.convertToInteger(dtoDb.getS3aFlgLocaleIntIdoneo()));
				tipoGF.setS3bFlgLineeElettrIdonee(ConvertUtil.convertToInteger(dtoDb.getS3bFlgLineeElettrIdonee()));
				tipoGF.setS3cFlgVentilazAdeguate(ConvertUtil.convertToInteger(dtoDb.getS3cFlgVentilazAdeguate()));
				tipoGF.setS3dFlgCoibentazioniIdonee(ConvertUtil.convertToInteger(dtoDb.getS3dFlgCoibentazioniIdonee()));
				tipoGF.setS4aFlgLibImpPresente(ConvertUtil.convertToInteger(dtoDb.getS4aFlgLibImpPresente()));
				tipoGF.setS4bFlgLibCompilato(ConvertUtil.convertToInteger(dtoDb.getS4bFlgLibCompilato()));
				tipoGF.setS4cFlgConformitaPresente(ConvertUtil.convertToInteger(dtoDb.getS4cFlgConformitaPresente()));
				tipoGF.setS4dFlgLibUsoPresente(ConvertUtil.convertToInteger(dtoDb.getS4dFlgLibUsoPresente()));
				tipoGF.setS5aFlgIsolamCanaliDistrib(ConvertUtil.convertToBooleanAllways(dtoDb.getS5aFlgIsolamCanaliDistrib()));
				tipoGF.setS5aFlgIsolamReteDistrib(ConvertUtil.convertToBooleanAllways(dtoDb.getS5aFlgIsolamReteDistrib()));
				tipoGF.setS5aFlgSostituzMacchineReg(ConvertUtil.convertToBooleanAllways(dtoDb.getS5aFlgSostituzMacchineReg()));
				tipoGF.setS5aFlgSostituzSistemiReg(ConvertUtil.convertToBooleanAllways(dtoDb.getS5aFlgSostituzSistemiReg()));
				tipoGF.setS5bFlgNoIntervConv(ConvertUtil.convertToBooleanAllways(dtoDb.getS5bFlgNoIntervConv()));
				tipoGF.setS5bFlgRelazDettaglio(ConvertUtil.convertToBooleanAllways(dtoDb.getS5bFlgRelazDettaglio()));
				tipoGF.setS5bFlgRelazDettaglioSucc(ConvertUtil.convertToBooleanAllways(dtoDb.getS5bFlgRelazDettaglioSucc()));
				tipoGF.setS5bFlgValutazNonEseguita(ConvertUtil.convertToBooleanAllways(dtoDb.getS5bFlgValutazNonEseguita()));
				tipoGF.setS5bMotivoRelazNonEseg(dtoDb.getS5bMotivoRelazNonEseg());
				tipoGF.setS5cFlgDimensCorretto(ConvertUtil.convertToBooleanAllways(dtoDb.getS5cFlgDimensCorretto()));
				tipoGF.setS5cFlgDimensNonControll(ConvertUtil.convertToBooleanAllways(dtoDb.getS5cFlgDimensNonControll()));
				tipoGF.setS5cFlgDimensNonCorretto(ConvertUtil.convertToBooleanAllways(dtoDb.getS5cFlgDimensNonCorretto()));
				tipoGF.setS5cFlgDimensRelazSucces(ConvertUtil.convertToBooleanAllways(dtoDb.getS5cFlgDimensRelazSucces()));

			}

			return tipoGF;
		} catch (Exception e) {
			log.error("Errore getAllegatoRappProvaTipoGF", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally {
			log.debug("[SigitMgr::getAllegatoRappProvaTipoGF] END");
		}
	}


	public TipoGT getAllegatoRappProvaTipoGT (String idAllegato, String codiceImpianto) throws ServiceException {
		log.debug("[SigitMgr::getAllegatoRappProvaTipoGT] START");

		log.debug("[SigitMgr::getAllegatoRappProvaTipoGT] **************************************** ID ALLEGATO: "
				+ idAllegato);
		try {
			TipoGT tipoGT = new TipoGT();

//			SigitTAllegatoDto allegatoDto = getDbMgr().cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(da.getIdAllegato()));
//			tipoGT.setOsservazioni(allegatoDto.getFOsservazioni());
//			tipoGT.setRaccomandazioni(allegatoDto.getFRaccomandazioni());
//			tipoGT.setPrescrizioni(allegatoDto.getFPrescrizioni());

			SigitTRappIspezGtDto sigitTRappIspezGtDto = getDbMgr().cercaTRappIspezGtById(ConvertUtil.convertToBigDecimal(idAllegato));

			if (sigitTRappIspezGtDto != null) {
				tipoGT.setInProduzioneACSDesc(getElencoDescrizioniByTrattAcqua(codiceImpianto, "ACS"));
				tipoGT.setInRiscaldamentoDesc(getElencoDescrizioniByTrattAcqua(codiceImpianto, "CLIMA"));
				tipoGT.setS1cDataRee(ConvertUtil.convertToString(sigitTRappIspezGtDto.getS1cDataRee()));
				tipoGT.setS1cFlgReeBollino(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS1cFlgReeBollino()));
				tipoGT.setS1cFlgReeInviato(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS1cFlgReeInviato()));
				tipoGT.setS1cNumBollino(ConvertUtil.convertToString(sigitTRappIspezGtDto.getS1cNumBollino()));
				tipoGT.setS1cSiglaBollino(sigitTRappIspezGtDto.getS1cSiglaBollino());
				tipoGT.setS1eDtPrimaInstallazione(ConvertUtil.convertToString(sigitTRappIspezGtDto.getS1eDtPrimaInstallazione()));
				tipoGT.setS1ePotFocolareKw(ConvertUtil.convertToString(sigitTRappIspezGtDto.getS1ePotFocolareKw()));
				tipoGT.setS1ePotUtileKw(ConvertUtil.convertToString(sigitTRappIspezGtDto.getS1ePotUtileKw()));
				tipoGT.setS1lDenomDelegat(sigitTRappIspezGtDto.getS1lDenomDelegato());
				tipoGT.setS1lFlgDelega(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS1lFlgDelega()));
				tipoGT.setS2b1FlgTermoContab(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS2b1FlgTermoContab()));
				tipoGT.setS2b1FlgUni10200(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS2b2FlgUni10200()));
				tipoGT.setS2fFlgTrattAcsNonRich(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS2fFlgTrattAcsNonRich()));
				tipoGT.setS2fFlgTrattClimaNonRich(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS2fFlgTrattClimaNonRich()));
				tipoGT.setS3aFlgLocaleIntIdoneo(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS3aFlgLocaleIntIdoneo()));
				tipoGT.setS3bFlgGenExtIdoneo(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS3bFlgGenExtIdoneo()));
				tipoGT.setS3cFlgVentilazSuff(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS3cFlgVentilazSuff()));
				tipoGT.setS3dFlgEvacFumiIdoneo(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS3dFlgEvacFumiIdoneo()));
				tipoGT.setS3eFlgCartelliPresenti(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS3eFlgCartelliPresenti()));
				tipoGT.setS3fFlgEstinzPresenti(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS3fFlgEstinzPresenti()));
				tipoGT.setS3gFlgInterrGenPresenti(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS3gFlgInterrGenPresenti()));
				tipoGT.setS3hFlgRubinPresente(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS3hFlgRubinPresente()));
				tipoGT.setS3iFlgAssenzaPerdComb(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS3iFlgAssenzaPerdComb()));
				tipoGT.setS3jFlgTempAmbFunz(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS3jFlgTempAmbFunz()));
				tipoGT.setS3kFlgDm_1_12_1975(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS3kFlgDm1121975()));
				tipoGT.setS4aFlgLibImpPresente(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS4aFlgLibImpPresente()));
				tipoGT.setS4bFlgLibCompilato(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS4bFlgLibCompilato()));
				tipoGT.setS4cFlgConformitaPresente(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS4cFlgConformitaPresente()));
				tipoGT.setS4dFlgLibUsoPresente(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS4dFlgLibUsoPresente()));
				tipoGT.setS4eFlgPraticaVvfPresente(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS4eFlgPraticaVvfPresente()));
				tipoGT.setS4fFlgPraticaInailPresente(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS4fFlgPraticaInailPresente()));
				tipoGT.setS4gFlgDm12_1975(ConvertUtil.convertToInteger(sigitTRappIspezGtDto.getS4gFlgDm121975()));
				tipoGT.setS4gMatricolaDm_1_12_1975(sigitTRappIspezGtDto.getS4gMatricolaDm1121975());
				tipoGT.setS5aFlgAdozioneValvoleTerm(ConvertUtil.convertToBooleanAllways(sigitTRappIspezGtDto.getS5aFlgAdozioneValvoleTerm()));
				tipoGT.setS5aFlgAdozSistTrattamH2o(ConvertUtil.convertToBooleanAllways(sigitTRappIspezGtDto.getS5aFlgAdozSistTrattamH2o()));
				tipoGT.setS5aFlgIsolamenteRete(ConvertUtil.convertToBooleanAllways(sigitTRappIspezGtDto.getS5aFlgIsolamenteRete()));
				tipoGT.setS5aFlgSostituzSistRegolaz(ConvertUtil.convertToBooleanAllways(sigitTRappIspezGtDto.getS5aFlgSostituzSistRegolaz()));
				tipoGT.setS5bFlgNoIntervConv(ConvertUtil.convertToBooleanAllways(sigitTRappIspezGtDto.getS5bFlgNoIntervConv()));
				tipoGT.setS5bFlgRelazDettaglio(ConvertUtil.convertToBooleanAllways(sigitTRappIspezGtDto.getS5bFlgRelazDettaglio()));
				tipoGT.setS5bFlgRelazDettaglioSucc(ConvertUtil.convertToBooleanAllways(sigitTRappIspezGtDto.getS5bFlgRelazDettaglioSucc()));
				tipoGT.setS5bFlgValutazNonEseguita(ConvertUtil.convertToBooleanAllways(sigitTRappIspezGtDto.getS5bFlgValutazNonEseguita()));
				tipoGT.setS5bMotivoRelazNonEseg(sigitTRappIspezGtDto.getS5bMotivoRelazNonEseg());
				tipoGT.setS5cFlgDimensCorretto(ConvertUtil.convertToBooleanAllways(sigitTRappIspezGtDto.getS5cFlgDimensCorretto()));
				tipoGT.setS5cFlgDimensNonControll(ConvertUtil.convertToBooleanAllways(sigitTRappIspezGtDto.getS5cFlgDimensNonControll()));
				tipoGT.setS5cFlgDimensNonCorretto(ConvertUtil.convertToBooleanAllways(sigitTRappIspezGtDto.getS5cFlgDimensNonCorretto()));
				tipoGT.setS5cFlgDimensRelazSucces(ConvertUtil.convertToBooleanAllways(sigitTRappIspezGtDto.getS5cFlgDimensRelazSucces()));

			}

			return tipoGT;
		} catch (Exception e) {
			log.error("Errore getAllegatoRappProvaTipoGT", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally {
			log.debug("[SigitMgr::getAllegatoRappProvaTipoGT] END");
		}

	}

	public Tipo1 getAllegatoTipo1(DettaglioAllegato da) throws ServiceException {
		log.debug("[SigitMgr::getAllegatoTipo1] START");

		log.debug("[SigitMgr::getAllegatoTipo1] **************************************** ID ALLEGATO: "
				+ da.getIdAllegato());

		//Tipo1 tipo1 = new Tipo1();
		try {

			ReeSuperDto allegatoGenerico = getAllegatoGenerico(da,
					Constants.TIPO_COMPONENTE_GT);
			Tipo1 tipo1 = ReeSuperDto.getTipo1(allegatoGenerico);

			//sezione custom

			BigDecimal idAllegato = ConvertUtil.convertToBigDecimal(da.getIdAllegato());
			SigitTRappTipo1Dto rappTipo1Dto = getDbMgr()
					.cercaTRappTipo1ById(idAllegato);

			if (rappTipo1Dto != null) {
				tipo1.setFlgTrattClimaNonRich(ConvertUtil.convertToInteger(rappTipo1Dto.getCFlgTrattClimaNonRich()));
				tipo1.setFlgTrattAcsNonRichiesto(
						ConvertUtil.convertToInteger(rappTipo1Dto.getCFlgTrattAcsNonRichiesto()));

				tipo1.setFlgLocaleIntIdoneo(ConvertUtil.convertToInteger(rappTipo1Dto.getDFlgLocaleIntIdoneo()));
				tipo1.setFlgGenExtIdoneo(ConvertUtil.convertToInteger(rappTipo1Dto.getDFlgGenExtIdoneo()));
				tipo1.setFlgApertureLibere(ConvertUtil.convertToInteger(rappTipo1Dto.getDFlgApertureLibere()));
				tipo1.setFlgApertureAdeguate(ConvertUtil.convertToInteger(rappTipo1Dto.getDFlgApertureAdeg()));
				tipo1.setFlgScaricoIdoneo(ConvertUtil.convertToInteger(rappTipo1Dto.getDFlgScaricoIdoneo()));
				tipo1.setFlgTempAmbFunz(ConvertUtil.convertToInteger(rappTipo1Dto.getDFlgTempAmbFunz()));
				tipo1.setFlgAssenzaPerdComb(ConvertUtil.convertToInteger(rappTipo1Dto.getDFlgAssenzaPerdComb()));
				tipo1.setFlgIdoTenImpInt(ConvertUtil.convertToInteger(rappTipo1Dto.getDFlgIdoTenImpInt()));
				tipo1.setFlgPuliziaCamino(ConvertUtil.convertToInteger(rappTipo1Dto.getD1bFlgPuliziaCamino()));
				//SEZIONE F. Check-list

				tipo1.setFlgAdozioneValvoleTerm(
						ConvertUtil.convertToBoolean(rappTipo1Dto.getFFlgAdozioneValvoleTerm()));
				tipo1.setFlgIsolamentoRete(ConvertUtil.convertToBoolean(rappTipo1Dto.getFFlgIsolamenteRete()));
				tipo1.setFlgAdozSistTrattamH2O(ConvertUtil.convertToBoolean(rappTipo1Dto.getFFlgAdozSistTrattamH2o()));
				tipo1.setFlgSostituzSistRegolaz(
						ConvertUtil.convertToBoolean(rappTipo1Dto.getFFlgSostituzSistRegolaz()));
			}

			List<SigitTConsumoTipo1BDto> consumoTipo1BList = getDbMgr().findConsumiTipo1ByIdAllegatoIdTipoConsumo(idAllegato, Constants.ID_TIPO_CONSUMO_1B_ACQUA_REINTEGRO);

			tipo1.setConsumi(MapDto.mapListToTipo1ConsumoList(consumoTipo1BList));

			return tipo1;

			/*
			tipo1.setOsservazioni(allegatoDto.getFOsservazioni());
			tipo1.setRaccomandazioni(allegatoDto.getFRaccomandazioni());
			tipo1.setPrescrizioni(allegatoDto.getFPrescrizioni());
			tipo1.setFlgPuoFunzionare(ConvertUtil.convertToInteger(allegatoDto.getFFlgPuoFunzionare()));

			tipo1.setInterventoEntro(ConvertUtil.convertToString(allegatoDto.getFInterventoEntro()));

			tipo1.setOraArrivo(allegatoDto.getFOraArrivo());
			tipo1.setOraPartenza(allegatoDto.getFOraPartenza());
			tipo1.setDenominazTecnico(allegatoDto.getFDenominazTecnico());
			*/
		} catch (Exception e) {
			log.error("Errore getAllegatoTipo1", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally {
			log.debug("[SigitMgr::getAllegatoTipo1] END");
		}
	}

	public Tipo2 getAllegatoTipo2(DettaglioAllegato da) throws ServiceException {
		log.debug("[SigitMgr::getAllegatoTipo2] START");

		log.debug("[SigitMgr::getAllegatoTipo2] **************************************** ID ALLEGATO: "
				+ da.getIdAllegato());

		try {

			ReeSuperDto allegatoGenerico = getAllegatoGenerico(da, Constants.TIPO_COMPONENTE_GF);
			Tipo2 tipo2 = ReeSuperDto.getTipo2(allegatoGenerico);

			//sezione custom

			SigitTRappTipo2Dto rappTipo2Dto = getDbMgr()
					.cercaTRappTipo2ById(ConvertUtil.convertToBigDecimal(da.getIdAllegato()));

			if (rappTipo2Dto != null) {
				tipo2.setFlgTrattClimaNonRich(
						ConvertUtil.convertToInteger(rappTipo2Dto.getCFlgTrattClimaNonRichiest()));

				tipo2.setFlgLocaleIntIdoneo(ConvertUtil.convertToInteger(rappTipo2Dto.getDFlgLocaleIdoneo()));
				tipo2.setFlgApertureAdeguate(ConvertUtil.convertToInteger(rappTipo2Dto.getDFlgApertureAdeg()));
				tipo2.setFlgApertureLibere(ConvertUtil.convertToInteger(rappTipo2Dto.getDFlgApertureLibere()));
				tipo2.setFlgLineaElettIdonea(ConvertUtil.convertToInteger(rappTipo2Dto.getDFlgLineaElettIdonea()));
				tipo2.setFlgCoibentIdonea(ConvertUtil.convertToInteger(rappTipo2Dto.getDFlgCoibIdonea()));

				tipo2.setFlgSostituzGeneratori(ConvertUtil.convertToBoolean(rappTipo2Dto.getFFlgSostituzGeneratori()));
				tipo2.setFlgSostituzRestemiReg(ConvertUtil.convertToBoolean(rappTipo2Dto.getFFlgSostituzSistemiReg()));
				tipo2.setFlgIsolDistribuzH2o(ConvertUtil.convertToBoolean(rappTipo2Dto.getFFlgIsolDistribuzH2o()));
				tipo2.setFlgIsolDistribuzAria(ConvertUtil.convertToBoolean(rappTipo2Dto.getFFlgIsolDistribuzAria()));

			}

			return tipo2;

		} catch (Exception e) {
			log.error("Errore getAllegatoTipo2", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally {
			log.debug("[SigitMgr::getAllegatoTipo2] END");
		}
	}

	public Tipo3 getAllegatoTipo3(DettaglioAllegato da) throws ServiceException {
		log.debug("[SigitMgr::getAllegatoTipo3] START");

		log.debug("[SigitMgr::getAllegatoTipo3] **************************************** ID ALLEGATO: "
				+ da.getIdAllegato());

		try {

			ReeSuperDto allegatoGenerico = getAllegatoGenerico(da, Constants.TIPO_COMPONENTE_SC);
			Tipo3 tipo3 = ReeSuperDto.getTipo3(allegatoGenerico);

			//sezione custom

			SigitTRappTipo3Dto rappTipo3Dto = getDbMgr()
					.cercaTRappTipo3ById(ConvertUtil.convertToBigDecimal(da.getIdAllegato()));

			if (rappTipo3Dto != null) {
				tipo3.setFlgTrattClimaNonRich(
						ConvertUtil.convertToInteger(rappTipo3Dto.getCFlgTrattClimaNonRichiest()));
				tipo3.setFlgTrattAcsNonRichiesto(
						ConvertUtil.convertToInteger(rappTipo3Dto.getCFlgTrattAcsNonRichiesto()));
				tipo3.setFlgLocaleIntIdoneo(ConvertUtil.convertToInteger(rappTipo3Dto.getDFlgLocaleIdoneo()));
				tipo3.setFlgLineaElettIdonea(ConvertUtil.convertToInteger(rappTipo3Dto.getDFlgLineaElettIdonea()));
				tipo3.setFlgCoibentIdonea(ConvertUtil.convertToInteger(rappTipo3Dto.getDFlgCoibIdonea()));
				tipo3.setFlgAssenzaPerdite(ConvertUtil.convertToInteger(rappTipo3Dto.getDFlgAssenzaPerdite()));
				tipo3.setFlgAdozioneValvoleTerm(ConvertUtil.convertToBoolean(rappTipo3Dto.getFFlgValvoleTermost()));
				tipo3.setFlgVerificaParam(ConvertUtil.convertToBoolean(rappTipo3Dto.getFFlgVerificaParam()));
				tipo3.setFlgPerditeH2O(ConvertUtil.convertToBoolean(rappTipo3Dto.getFFlgPerditeH2o()));
				tipo3.setFlgInstallInvolucro(ConvertUtil.convertToBoolean(rappTipo3Dto.getFFlgInstallInvolucro()));
			}

			return tipo3;

		} catch (Exception e) {
			log.error("Errore getAllegatoTipo3", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally {
			log.debug("[SigitMgr::getAllegatoTipo3] END");
		}

	}

	public Tipo4 getAllegatoTipo4(DettaglioAllegato da) throws ServiceException {
		log.debug("[SigitMgr::getAllegatoTipo4] START");

		log.debug("[SigitMgr::getAllegatoTipo4] **************************************** ID ALLEGATO: "
				+ da.getIdAllegato());

		try {

			ReeSuperDto allegatoGenerico = getAllegatoGenerico(da, Constants.TIPO_COMPONENTE_CG);
			Tipo4 tipo4 = ReeSuperDto.getTipo4(allegatoGenerico);

			//sezione custom

			SigitTRappTipo4Dto rappTipo4Dto = getDbMgr()
					.cercaTRappTipo4ById(ConvertUtil.convertToBigDecimal(da.getIdAllegato()));

			if (rappTipo4Dto != null) {
				tipo4.setFlgTrattClimaNonRich(
						ConvertUtil.convertToInteger(rappTipo4Dto.getCFlgTrattClimaNonRichiest()));
				//				tipo4.setFlgTrattAcsNonRichiesto(
				//						ConvertUtil.convertToInteger(rappTipo4Dto.getCFlgTrattAcsNonRichiesto()));

				tipo4.setFlgLuogoIdoneo(ConvertUtil.convertToInteger(rappTipo4Dto.getDFlgLuogoIdoneo()));
				tipo4.setFlgVentilazAdeg(ConvertUtil.convertToInteger(rappTipo4Dto.getDFlgVentilazAdeg()));
				tipo4.setFlgVentilazLibera(ConvertUtil.convertToInteger(rappTipo4Dto.getDFlgVentilazLibera()));
				tipo4.setFlgLineaElettIdonea(ConvertUtil.convertToInteger(rappTipo4Dto.getDFlgLineaElettIdonea()));
				tipo4.setFlgCaminoIdoneo(ConvertUtil.convertToInteger(rappTipo4Dto.getDFlgCaminoIdoneo()));
				tipo4.setFlgCapsulaIdonea(ConvertUtil.convertToInteger(rappTipo4Dto.getDFlgCapsulaIdonea()));
				tipo4.setFlgCircIdrIdoneo(ConvertUtil.convertToInteger(rappTipo4Dto.getDFlgCircIdrIdoneo()));

				tipo4.setFlgCircOlioIdoneo(ConvertUtil.convertToInteger(rappTipo4Dto.getDFlgCircOlioIdoneo()));
				tipo4.setFlgCircCombIdoneo(ConvertUtil.convertToInteger(rappTipo4Dto.getDFlgCircCombIdoneo()));
				tipo4.setFlgFunzScambIdonea(ConvertUtil.convertToInteger(rappTipo4Dto.getDFlgFunzScambIdonea()));

				//SEZIONE F. Check-list

				tipo4.setFlgAdozioneValvoleTerm(ConvertUtil.convertToBoolean(rappTipo4Dto.getFFlgAdozioneValvole()));
				tipo4.setFlgIsolamentoRete(ConvertUtil.convertToBoolean(rappTipo4Dto.getFFlgIsolamentoRete()));
				tipo4.setFlgSistemaTrattH2O(ConvertUtil.convertToBoolean(rappTipo4Dto.getFFlgSistemaTrattH2o()));
				tipo4.setFlgSostSistemaRegolaz(ConvertUtil.convertToBoolean(rappTipo4Dto.getFFlgSostSistemaRegolaz()));
			}

			return tipo4;

		} catch (Exception e) {
			log.error("Errore getAllegatoTipo4", e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} finally {
			log.debug("[SigitMgr::getAllegatoTipo4] END");
		}
	}

	public String getElencoDescrizioniByTrattAcqua (String codImpianto, String tipoTrattamento) throws ManagerException {
		SigitTTrattH2ODto dettaglioTrattAcqua = null;
		try {
			dettaglioTrattAcqua = this.getDbMgr().cercaSigitTTrattH2OByCodImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
		} catch (DbManagerException e) {
			log.error("Errore getElencoDescrizioniByTrattAcqua", e);
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		List<String> descrizioni = new ArrayList<String>();
		if (dettaglioTrattAcqua != null ) {
			if ("CLIMA".equals(tipoTrattamento)) {
				if(ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAddolc())) {
					descrizioni.add("ADDOLCIMENTO");
				}
				if (ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAssente())) {
					descrizioni.add("ASSENTE");
				}
				if (ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaChimico())) {
					descrizioni.add("CONDIZ. CHIMICO");
				}
				if (ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaFiltr())) {
					descrizioni.add("FILTRAZIONE");
				}
			} else if ("ACS".equals(tipoTrattamento)) {
				if (ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsAddolc())) {
					descrizioni.add("ADDOLCIMENTO");
				}
				if (ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsAssente())) {
					descrizioni.add("ASSENTE");
				}
				if (ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsChimico())) {
					descrizioni.add("CONDIZ. CHIMICO");
				}
				if (ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsFiltr())) {
					descrizioni.add("FILTRAZIONE");
				}
			}
		}

		return ConvertUtil.getStringByList(descrizioni);
	}


	public ReeSuperDto getAllegatoGenerico(DettaglioAllegato da, String tipoComponente) throws ManagerException {
		ReeSuperDto output = new ReeSuperDto();

		String codImpianto = da.getCodiceImpianto();

		//in questo oggetto setto il responsabile dell'impianto
		SigitVTotImpiantoDto vTotImpiantoResp = null;

		//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)


		// Se il responsabile e una PF
		PersonaFisica pfResp = null;

		//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		PersonaGiuridica pg = null;

		BigDecimal idRuolo = null;

		try {

			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(da.getCodiceImpianto(),
							da.getDataControllo());
			SigitVRicerca3ResponsabileDto vTot3Responsabile = null;
			if (list3RespAttiviImpianto != null && list3RespAttiviImpianto.size() > 0) {
				vTot3Responsabile = list3RespAttiviImpianto.get(0);
				pg = getDbMgr().cercaPersonaGiuridicaById(vTot3Responsabile.getFkPg3Resp().intValue());
				idRuolo = vTot3Responsabile.getFkRuolo();
			}

			//se la persona giuridica del 3resp e' ancora nulla, allora si passa a caricare il dato del responsabile
			if (pg == null) {
				// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
				List<SigitVTotImpiantoDto> listResp = getDbMgr()
						.cercaResponsabiliAttiviAllaDataByCodImpianto(da.getCodiceImpianto(), da.getDataControllo());
				if (listResp != null && !listResp.isEmpty()) {

					vTotImpiantoResp = listResp.get(0);
					idRuolo = vTotImpiantoResp.getIdRuolo();

					if (vTotImpiantoResp.getPfPg().equals(Constants.LABEL_PF)) {
						pfResp = getDbMgr().cercaPersonaFisicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());
					} else {
						pg = getDbMgr().cercaPersonaGiuridicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());
					}
				}
			}

			StringBuffer responsabileImpresa = new StringBuffer();

			if (pg != null) {
				responsabileImpresa.append(pg.getDenominazione() + " " + pg.getCodiceFiscale());
			} else {
				responsabileImpresa.append(pfResp.getCognome() + " " + pfResp.getNome() + " " + pfResp.getCodiceFiscale());
			}
			responsabileImpresa.append(" in qualita' di ");

			if (list3RespAttiviImpianto == null || list3RespAttiviImpianto.isEmpty()) {
				//se non e' stato trovato il terzo responsabile
				if (Constants.ID_RUOLO_AMMINISTRATORE == idRuolo.intValue()
						|| Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE == idRuolo
								.intValue()) {
					responsabileImpresa.append("Amministratore Condominio");
				}

				if (Constants.ID_RUOLO_OCCUPANTE == idRuolo.intValue()
						|| Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE == idRuolo
								.intValue()) {
					responsabileImpresa.append("Occupante");
				}

				if (Constants.ID_RUOLO_PROPRIETARIO == idRuolo.intValue()
						|| Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO == idRuolo
								.intValue()) {
					responsabileImpresa.append("Proprietario");
				}
			} else {
				responsabileImpresa.append("Terzo Responsabile");
			}

			output.setResponsabileImpianto(responsabileImpresa == null ? "" : responsabileImpresa.toString());

			SigitTPersonaGiuridicaDto dettaglioImpresaManutentrice = null;
			DettaglioIspezione dettaglioIspezione = null;

			if (GenericUtil.isNotNullOrEmpty(da.getIdIspezione())) {
				// Recupero l'ispezione
				dettaglioIspezione = getDbMgr().getDettaglioIspezioneById(da.getIdIspezione());
			} else {
				//cerco i dati dell'impresa manutentrice
				dettaglioImpresaManutentrice = getDbMgr().cercaTPersonaGiuridicaById(da.getIdPersonaGiuridica());
			}

			SigitTAllegatoDto allegatoDto = getDbMgr()
					.cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(da.getIdAllegato()));

			output.setPotenzaTermicaNomMax(ConvertUtil.convertToString(allegatoDto.getAPotenzaTermicaNominaleMax()));


			String impresaManutentrice = null;

			//impresa manutentrice
			if (dettaglioImpresaManutentrice != null) {

				impresaManutentrice = dettaglioImpresaManutentrice.getDenominazione() + " "
						+ dettaglioImpresaManutentrice.getCodiceFiscale();

				if (ConvertUtil.convertToBooleanAllways(dettaglioImpresaManutentrice.getFlgIndirizzoEstero())) {
					impresaManutentrice += " " + dettaglioImpresaManutentrice.getIndirizzoEstero() + " "
							+ GenericUtil.getStringValid(dettaglioImpresaManutentrice.getCittaEstero()) + " ("
							+ GenericUtil.getStringValid(dettaglioImpresaManutentrice.getStatoEstero()) + ")"
							+ GenericUtil.getStringValid(dettaglioImpresaManutentrice.getCivico());
				} else {
					if (GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoSitad())) {
						impresaManutentrice += " "
								+ GenericUtil.getStringValid(dettaglioImpresaManutentrice.getIndirizzoSitad());
					} else if (GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoNonTrovato())) {
						impresaManutentrice += " "
								+ GenericUtil.getStringValid(dettaglioImpresaManutentrice.getIndirizzoNonTrovato());
					}

					impresaManutentrice += " " + GenericUtil.getStringValid(dettaglioImpresaManutentrice.getCivico()) + ", " + GenericUtil.getStringValid(dettaglioImpresaManutentrice.getComune())
					+ " " + GenericUtil.getStringValid(dettaglioImpresaManutentrice.getSiglaProv());
				}
			}  else if (dettaglioIspezione != null) {
				impresaManutentrice = MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione);
			}

			output.setImpresaManutInstal(impresaManutentrice);

			//SEZIONE B. Documentazione tecnica a corredo
			output.setFlgDichiarConform(ConvertUtil.convertToInteger(allegatoDto.getBFlgDichiarConform()));
			output.setFlgLibImp(ConvertUtil.convertToInteger(allegatoDto.getBFlgLibImp()));
			output.setFlgLibrettoUso(ConvertUtil.convertToInteger(allegatoDto.getBFlgLibrettoUso()));
			output.setFlgLibCompl(ConvertUtil.convertToInteger(allegatoDto.getBFlgLibCompl()));

			//SEZIONE C. Trattamento dell'acqua
			SigitTTrattH2ODto dettaglioTrattAcqua = this.getDbMgr().cercaSigitTTrattH2OByCodImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			if (dettaglioTrattAcqua != null) {
				output.setDurezzaH2OFr(ConvertUtil.convertToString(dettaglioTrattAcqua.getL22DurezzaH2oFr()));

				output.setDescTrattAcs(getElencoDescrizioniByTrattAcqua(codImpianto, "ACS"));

				output.setDescTrattClima(getElencoDescrizioniByTrattAcqua(codImpianto, "CLIMA"));

			}

				output.setOsservazioni(allegatoDto.getFOsservazioni());
				output.setRaccomandazioni(allegatoDto.getFRaccomandazioni());
				output.setPrescrizioni(allegatoDto.getFPrescrizioni());
				output.setFlgPuoFunzionare(ConvertUtil.convertToInteger(allegatoDto.getFFlgPuoFunzionare()));

				output.setInterventoEntro(ConvertUtil.convertToString(allegatoDto.getFInterventoEntro()));

				output.setOraArrivo(allegatoDto.getFOraArrivo());
				output.setOraPartenza(allegatoDto.getFOraPartenza());
				output.setDenominazTecnico(allegatoDto.getFDenominazTecnico());


		} catch (DbManagerException e) {
			// TODO Auto-generated catch block
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return output;

	}

	public String getMimeTypeFile(File file) throws ManagerException {
		log.debug("getMimeTypeFile - START");

		String mimeType = null;
		try
		{
			mimeType = getServiziMgr().getMimeTypeFile(file.getName(), readFile(file));
			log.debug("getMimeTypeFile - mimeType: "+mimeType);

		}
		catch (ServiceException e)
		{
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));

		}
		finally
		{
			log.debug("getMimeTypeFile - END");
		}
		return mimeType;
	}

	public ControlloLibretto caricaControlloLibretto(String codImpianto) throws ManagerException {
		log.debug("[SigitMgr::caricaControlloLibretto] BEGIN");

		ControlloLibretto controllo = new ControlloLibretto();

		SigitTControlloLibrettoDto tControlloLibretto= getDbMgr().findControlloLibretto(codImpianto);

		controllo = MapDto.mapToControlloLibretto(tControlloLibretto);

		List<SigitTComp4Dto> compNonControllate = getDbMgr().cercaTComp4NonControllateByCodImp(codImpianto);

		if (compNonControllate != null && compNonControllate.size() > 0)
		{
			String elencoComp = GenericUtil.getDescComponentiNonComp(compNonControllate);
			controllo.setDescCompNonContr(elencoComp);

		}
		else
		{
			controllo.setDescCompNonContr(Constants.DESC_TUTTE_COMP_VERIFICATE);
		}


		log.debug("[SigitMgr::caricaControlloLibretto] END");
		return controllo;
	}

	public ArrayList<LibrettoDett> cercaLibrettiNonBozza(String codImpianto) throws ManagerException {
		log.debug("[SigitMgr::caricaControlloLibretto] BEGIN");

		ArrayList<LibrettoDett> librettiCons = new ArrayList<LibrettoDett>();

		List<SigitTLibrettoByCodiceImpNonBozzaDto> tlibretti = getDbMgr().findLibrettiNonBozza(codImpianto);

		librettiCons = MapDto.convertToListLibrettoDett(tlibretti);

		log.debug("[SigitMgr::caricaControlloLibretto] END");
		return librettiCons;
	}

	public ArrayList<LibrettoDett> cercaStoricoLibrettiConsolidatiNonBozza(String codImpianto) throws ManagerException {
		log.debug("[SigitMgr::cercaStoricoLibrettiConsolidatiNonBozza] BEGIN");

		ArrayList<LibrettoDett> librettiCons = new ArrayList<LibrettoDett>();

		List<SigitSLibrettoByCodiceImpiantoNonBozzaDto> tlibretti = getDbMgr().findStoricoLibrettiConsNonBozza(codImpianto);

		librettiCons = MapDto.convertToListStoricoLibrettoDett(tlibretti);

		log.debug("[SigitMgr::cercaStoricoLibrettiConsolidatiNonBozza] END");
		return librettiCons;
	}

	public RapProvaDatiGenerali getRapProvaDatiGenerali(DettaglioAllegato da, boolean isAllegatoInInsert, String tipoComponente, SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto unitaImmobiliareDto) throws ManagerException {

		RapProvaDatiGenerali output = new RapProvaDatiGenerali();
		//in questo oggetto setto il responsabile dell'impianto
		SigitVTotImpiantoDto vTotImpiantoResp = null;
		//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		SigitVRicerca3ResponsabileDto vTot3Responsabile = null;
		// Se il responsabile e una PF
		PersonaFisica pf = null;
		// Se il responsabile e una PG
		PersonaGiuridica pgResp = null;
		//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		PersonaGiuridica pg = null;
		BigDecimal idRuolo = null;

		String codImpianto = da.getCodiceImpianto();
		// Devo per forza caricare questo dato, conviene inserirlo nella vista?
		SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(codImpianto);
		try {
			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			List<SigitVTotImpiantoDto> listResp = getDbMgr()
					.cercaResponsabiliAttiviAllaDataByCodImpianto(codImpianto, da.getDataControllo());

			if (listResp != null && !listResp.isEmpty()) {

				vTotImpiantoResp = listResp.get(0);
				idRuolo = vTotImpiantoResp.getIdRuolo();

				if (vTotImpiantoResp.getPfPg().equals(Constants.LABEL_PF)) {
					pf = getDbMgr().cercaPersonaFisicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());
				} else {
					pgResp = getDbMgr().cercaPersonaGiuridicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());
				}
			}

			Ispezione2018 dettaglioIspezione = caricaIspezioneDaId(ConvertUtil.convertToString(da.getIdIspezione2018()), false, true);

			StringBuffer responsabileImpresa = null;

			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = getDbMgr()
					.cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(da.getCodiceImpianto(),
							da.getDataControllo());

			if (list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty()) {
				vTot3Responsabile =  list3RespAttiviImpianto.get(0);
				pg = getDbMgr().cercaPersonaGiuridicaById(vTot3Responsabile.getFkPg3Resp().intValue());
				idRuolo = vTot3Responsabile.getFkRuolo();
			} else {
				pg = pgResp;
				idRuolo = vTotImpiantoResp.getIdRuolo();
			}

			if (responsabileImpresa == null) {
				responsabileImpresa = new StringBuffer();
			}

			String indirizzo = "";
			if (pg != null) {
				responsabileImpresa.append(pg.getDenominazione() + " " + pg.getCodiceFiscale());
				if (ConvertUtil.convertToBooleanAllways(pg.getFlgIndirizzoEst()))
				{
					indirizzo = MapDto.getIndirizzoEsteroCompleto(pg.getEstStato(), pg.getEstCitta(), pg.getEstIndirizzo(), pg.getCivico());
				}
				else
				{
					indirizzo = MapDto.getIndirizzoCompleto(pg.getComune(), pg.getIndirizzo(), pg.getIndirizzoNonTrovato(),
							pg.getCivico(), pg.getIdProvinciaSelez());
				}
			} else {
				responsabileImpresa.append(pf.getCognome() + " " + pf.getNome() + " " + pf.getCodiceFiscale());
				if (ConvertUtil.convertToBooleanAllways(pf.getFlgIndirizzoEst()))
				{
					indirizzo = MapDto.getIndirizzoEsteroCompleto(pf.getEstStato(), pf.getEstCitta(), pf.getEstIndirizzo(), pf.getCivico());
				}
				else
				{
					indirizzo = MapDto.getIndirizzoCompleto(pf.getComune(), pf.getIndirizzo(), pf.getIndirizzoNonTrovato(),
							pf.getCivico(), pf.getIdProvinciaSelez());
				}
			}

			responsabileImpresa.append(GenericUtil.isNullOrEmpty(indirizzo)? "" : " " + indirizzo);

			responsabileImpresa.append(" in qualita' di ");

			if (list3RespAttiviImpianto == null || list3RespAttiviImpianto.isEmpty()) {
				if (Constants.ID_RUOLO_AMMINISTRATORE == idRuolo.intValue()
						|| Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE == idRuolo
								.intValue()) {
					responsabileImpresa.append("Amministratore Condominio");
				}

				if (Constants.ID_RUOLO_OCCUPANTE == idRuolo.intValue()
						|| Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE == idRuolo
								.intValue()) {
					responsabileImpresa.append("Occupante");
				}

				if (Constants.ID_RUOLO_PROPRIETARIO == idRuolo.intValue()
						|| Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO == idRuolo
								.intValue()) {
					responsabileImpresa.append("Proprietario");
				}
			} else {
				responsabileImpresa.append("Terzo Responsabile");
			}

			output.setResponsabile(responsabileImpresa == null ? "" : responsabileImpresa.toString());

			String ispettore = dettaglioIspezione.getDescrizioneIspettore();

			if (GenericUtil.isNotNullOrEmpty(dettaglioIspezione.getCfSecondoIspettore())) {
				List<SigitTPersonaFisicaDto> listaSoggetti = getDbMgr().getSigitTPersonaFisicaDao().findByCodFisc(dettaglioIspezione.getCfSecondoIspettore());
				SigitTPersonaFisicaDto pfSecIspett = null;
				if (listaSoggetti != null && !listaSoggetti.isEmpty()) {
					pfSecIspett = listaSoggetti.get(0);
				}
				if (pfSecIspett != null) {
					ispettore += " (secondo ispettore: " + ConvertUtil.getStringByConcat(" ", pfSecIspett.getCognome(), pfSecIspett.getNome(), pfSecIspett.getCodiceFiscale()) + ")";
				}

			}

			output.setIspettore(ispettore);



			output.setCodiceImpianto(codImpianto);
			output.setDataControllo(da.getDataControllo());
			output.setOraArrivo(da.getOraArrivo());
			output.setIdIspezione(da.getIdIspezione2018());
			output.setQualificaIspettore("");//DA DEFINIRE
			output.setComune(ConvertUtil.getStringByConcat(" ", impianto.getDenominazioneComune(), impianto.getSiglaProvincia()));


			if (GenericUtil.isBigDecimalPositive(impianto.getL13PotH2oKw()))
			{
				output.setUsoImpianto(Constants.LABEL_PRODUZIONE_ACS);
			}


			if (GenericUtil.isBigDecimalPositive(impianto.getL13PotClimaInvKw()))
			{
				output.setUsoImpianto(ConvertUtil.getStringByConcat(", ", output.getUsoImpianto(), Constants.LABEL_RISCALDAMENTO_AMBIENTI));
			}


			if (unitaImmobiliareDto != null) {

				if (GenericUtil.isNotNullOrEmpty(unitaImmobiliareDto.getUiL12FlgSingolaUnita()) && unitaImmobiliareDto
								.getUiL12FlgSingolaUnita().equals(ConvertUtil.convertToBigDecimal(Constants.SI_1)))
				{
					output.setDescUnitaImmServite(Constants.DESC_UNITA_UNICA);
				}
				else
				{
					output.setDescUnitaImmServite(Constants.DESC_UNITA_MULTIPLE);
				}

				output.setDescCatEdificio(ConvertUtil.getStringByConcat("-", unitaImmobiliareDto.getUiL12FkCategoria(), unitaImmobiliareDto.getCatDesCategoria()));

				if (unitaImmobiliareDto.getUiIndirizzoSitad() == null) {
					output.setIndirizzo(GenericUtil.normalizeString(unitaImmobiliareDto.getUiIndirizzoNonTrovato()));
				} else {
					output.setIndirizzo(ConvertUtil.getStringByConcat(",", GenericUtil.normalizeString(unitaImmobiliareDto.getUiIndirizzoSitad()), unitaImmobiliareDto.getUiCivico()));
				}

				output.setVolRiscM3(ConvertUtil.convertToString(unitaImmobiliareDto.getUiL12VolRiscM3()));


			}

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (ManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		return output;

	}


	public ArrayList<IdDescription> getElencoTipoVerifiche() throws ManagerException {
		log.debug("[SigitMgr::getElencoTipoVerifiche] BEGIN");
		ArrayList<IdDescription> catList = new ArrayList<IdDescription>();
		try
		{
			List<SigitDTipoVerificaDto> elencoTipoVerifiche = getDbVerificaMgr().getElencoTipoVerifiche();
			if (elencoTipoVerifiche != null && elencoTipoVerifiche.size() > 0)
			{
				catList = MapDto.mapToTipoVerifiche(elencoTipoVerifiche);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::getElencoTipoVerifiche] END");
		}

		return catList;
	}

	public ArrayList<IdDescription> creaElencoTipoCessazione (String ruolo) throws ManagerException {
		log.debug("[SigitMgr::creaElencoTipoCessazione] BEGIN");
		ArrayList<IdDescription> risultato = new ArrayList<IdDescription>();
		//vengono recuperate tutte le tipologie di cessazioni
		try
		{
			if (GenericUtil.isNullOrEmpty(ruolo)) {
				return risultato;
			}
			List<SigitDTipoCessazioneDto> elencoTipiCessazione = getDbMgr().getSigitDTipoCessazioneDao().findAll();
			List<String> cessazioniPerRuolo = null;
			if (elencoTipiCessazione != null) {
				//se ruolo = responsabile/responsabile impresa -> solo voce Revoca
				//se ruolo = 3resp ->  revoca / rinuncia / decadenza
				//se ruolo = PA (super / validatore)-> revoca / rinuncia / decadenza
				if (Constants.RUOLO_RESPONSABILE_IMPRESA.equals(ruolo) || Constants.RUOLO_RESPONSABILE.equals(ruolo)) {
					cessazioniPerRuolo = Arrays.asList("REVOCA");
				}
				if (Constants.RUOLO_3RESPONSABILE.equals(ruolo)) {
					cessazioniPerRuolo = Arrays.asList("RINUNCIA", "DECADENZA", "REVOCA");
				}
				//ruolo pa
				//i ruoli Pa sono stati individuati a partire dalla tabella sigit_d_ruolo_pa
				if (Constants.RUOLO_ISPETTORE.equals(ruolo) || Constants.RUOLO_CONSULTATORE.equals(ruolo) || Constants.RUOLO_SUPER.equals(ruolo) || Constants.RUOLO_VALIDATORE.equals(ruolo)) {
					cessazioniPerRuolo = Arrays.asList("RINUNCIA", "DECADENZA", "REVOCA");
				}
				if (cessazioniPerRuolo != null) {
					for (SigitDTipoCessazioneDto datoDb : elencoTipiCessazione) {
						if (cessazioniPerRuolo.contains(StringUtils.upperCase(datoDb.getDesTipoCessazione()))) {
							IdDescription nuovaVoce = new IdDescription();
							nuovaVoce.setDescription(datoDb.getDesTipoCessazione());
							nuovaVoce.setId(datoDb.getIdTipoCessazione());
							risultato.add(nuovaVoce);
						}
					}
				}
			}

		} catch (SigitDTipoCessazioneDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::creaElencoTipoCessazione] END");
		}

		return risultato;

	}


	public ArrayList<IdDescription> getElencoStatoAccertamento() throws ManagerException {
		log.debug("[SigitMgr::getElencoStatoAccertamento] BEGIN");
		ArrayList<IdDescription> catList = new ArrayList<IdDescription>();
		try
		{
			List<SigitDStatoAccertamentoDto> elencoTipoVerifiche = getDbVerificaMgr().getElencoStatoAccertamento();
			if (elencoTipoVerifiche != null && elencoTipoVerifiche.size() > 0)
			{
				catList = MapDto.mapToStatoAccertamento(elencoTipoVerifiche);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::getElencoStatoAccertamento] END");
		}

		return catList;
	}

	public ArrayList<CodeDescription> getElencoCaricatori() throws ManagerException {
		ArrayList<CodeDescription> catList = new ArrayList<CodeDescription>();
		ArrayList<CodeDescription> catListSet = new ArrayList<CodeDescription>();

		Set<String> set1 = new HashSet<String>();

		catList.addAll(getElencoValidatoriCfPf(false));
		catList.addAll(getElencoIspettoriCfPf(false));

		if (!catList.isEmpty()) {
			for (CodeDescription element : catList) {
				if (!set1.contains(element.getCode())) {
					set1.add(element.getCode());
					catListSet.add(element);
				}
			}
		}

		return catListSet;
	}
	/*
	public ArrayList<CodeDescription> getElencoValidatori(boolean isCfKey) throws ManagerException {
		log.debug("[SigitMgr::getElencoValidatori] BEGIN");
		ArrayList<CodeDescription> catList = new ArrayList<CodeDescription>();
		try
		{
//			List<SigitTPersonaFisicaValidatoriDto> elencoValidatori = getDbVerificaMgr().getElencoValidatori();
			List<SigitTPersonaFisicaDaRuoloPADto> elencoValidatori = getDbVerificaMgr().getElencoPfDaRuolo(Constants.ID_RUOLO_PA_VALIDATORE);
			if (elencoValidatori != null && elencoValidatori.size() > 0)
			{
				catList = MapDto.mapToPFtoRuolo(elencoValidatori, isCfKey);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::getElencoValidatori] END");
		}

		return catList;
	}
*/
	public ArrayList<CodeDescription> getElencoValidatoriCfPf(boolean isSoloAttivi) throws ManagerException {
		log.debug("[SigitMgr::getElencoValidatori] BEGIN");
		ArrayList<CodeDescription> catList = new ArrayList<CodeDescription>();
		try
		{
//			List<SigitTPersonaFisicaValidatoriDto> elencoValidatori = getDbVerificaMgr().getElencoValidatori();
			List<SigitTPersonaFisicaDaRuoloPADto> elencoValidatori = getDbVerificaMgr().getElencoPfDaRuolo(Constants.ID_RUOLO_PA_VALIDATORE, isSoloAttivi);
			if (elencoValidatori != null && elencoValidatori.size() > 0)
			{
				catList = MapDto.mapToPFtoRuolo(elencoValidatori, true);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::getElencoValidatori] END");
		}

		return catList;
	}

	public ArrayList<CodeDescription> getElencoValidatoriIdPf(boolean isSoloAttivi) throws ManagerException {
		log.debug("[SigitMgr::getElencoValidatori] BEGIN");
		ArrayList<CodeDescription> catList = new ArrayList<CodeDescription>();
		try
		{
//			List<SigitTPersonaFisicaValidatoriDto> elencoValidatori = getDbVerificaMgr().getElencoValidatori();
			List<SigitTPersonaFisicaDaRuoloPADto> elencoValidatori = getDbVerificaMgr().getElencoPfDaRuolo(Constants.ID_RUOLO_PA_VALIDATORE, isSoloAttivi);
			if (elencoValidatori != null && elencoValidatori.size() > 0)
			{
				catList = MapDto.mapToPFtoRuolo(elencoValidatori, false);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::getElencoValidatori] END");
		}

		return catList;
	}

	/*
	public ArrayList<CodeDescription> getElencoValidatori() throws ManagerException {
		return getElencoValidatori(false);
	}
	*/

	/*
	public ArrayList<CodeDescription> getElencoIspettori() throws ManagerException {
		return getElencoIspettori(true);
	}

	public ArrayList<CodeDescription> getElencoIspettoriAttivi(boolean isCfKey) throws ManagerException {
		log.debug("[SigitMgr::getElencoIspettori] BEGIN");
		ArrayList<CodeDescription> catList = new ArrayList<CodeDescription>();
		try
		{
			List<SigitTPersonaFisicaDaRuoloPADto> elencoIspettori = getDbVerificaMgr().getElencoPfDaRuolo(Constants.ID_RUOLO_PA_ISPETTORE, true);
			if (elencoIspettori != null && elencoIspettori.size() > 0)
			{
				catList = MapDto.mapToPFtoRuolo(elencoIspettori, isCfKey);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::getElencoIspettori] END");
		}

		return catList;
	}
	*/

	public ArrayList<CodeDescription> getElencoIspettoriCfPf(boolean isSoloAttivi) throws ManagerException {
		log.debug("[SigitMgr::getElencoIspettori] BEGIN");
		ArrayList<CodeDescription> catList = new ArrayList<CodeDescription>();
		try
		{
			List<SigitTPersonaFisicaDaRuoloPADto> elencoIspettori = getDbVerificaMgr().getElencoPfDaRuolo(Constants.ID_RUOLO_PA_ISPETTORE, isSoloAttivi);
			if (elencoIspettori != null && elencoIspettori.size() > 0)
			{
				catList = MapDto.mapToPFtoRuolo(elencoIspettori, true);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::getElencoIspettori] END");
		}

		return catList;
	}


	public ArrayList<CodeDescription> getElencoIspettoriIdPf(boolean isSoloAttivi) throws ManagerException {
		log.debug("[SigitMgr::getElencoIspettori] BEGIN");
		ArrayList<CodeDescription> catList = new ArrayList<CodeDescription>();
		try
		{
			List<SigitTPersonaFisicaDaRuoloPADto> elencoIspettori = getDbVerificaMgr().getElencoPfDaRuolo(Constants.ID_RUOLO_PA_ISPETTORE, isSoloAttivi);
			if (elencoIspettori != null && elencoIspettori.size() > 0)
			{
				catList = MapDto.mapToPFtoRuolo(elencoIspettori, false);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::getElencoIspettori] END");
		}

		return catList;
	}

	public ArrayList<CodeDescription> getElencoTipoAnomalie() throws ManagerException {
		log.debug("[SigitMgr::getElencoTipoAnomalie] BEGIN");
		ArrayList<CodeDescription> anomList = new ArrayList<CodeDescription>();
		try
		{
			List<SigitDTipoAnomaliaDto> elencoTipoAnomalie = getDbAzioneMgr().getElencoTipoAnomalia();
			if (elencoTipoAnomalie != null && elencoTipoAnomalie.size() > 0)
			{
				anomList = MapDto.mapToTipoAnomalie(elencoTipoAnomalie);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::getElencoTipoAnomalie] END");
		}

		return anomList;
	}

	public ArrayList<IdDescription> getElencoTipoConclusioni() throws ManagerException {
		log.debug("[SigitMgr::getElencoTipoAnomalie] BEGIN");
		ArrayList<IdDescription> anomList = new ArrayList<IdDescription>();
		try
		{
			List<SigitDTipoConclusioneDto> elencoTipoConclusione = getDbVerificaMgr().getElencoTipoConclusione();
			if (elencoTipoConclusione != null && elencoTipoConclusione.size() > 0)
			{
				anomList = MapDto.mapToTipoConclusioni(elencoTipoConclusione);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::getElencoTipoAnomalie] END");
		}

		return anomList;
	}

	public ArrayList<IdDescription> getElencoStatiISpezione() throws ManagerException {
		log.debug("[SigitMgr::getElencoStatiISpezione] BEGIN");
		ArrayList<IdDescription> statoIspezioneList = new ArrayList<IdDescription>();
		try
		{
			List<SigitDStatoIspezioneDto> listaStatiIspezione = getDbIspezioneMgr().getElencoStatoIspezione();
			if (listaStatiIspezione != null && listaStatiIspezione.size() > 0)
			{
				statoIspezioneList = MapDto.mapToStatiIspezione(listaStatiIspezione);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::getElencoStatiISpezione] END");
		}

		return statoIspezioneList;
	}

	public ArrayList<IdDescription> getElencoStatiSanzione() throws ManagerException {
		log.debug("[SigitMgr::getElencoStatiSanzione] BEGIN");
		ArrayList<IdDescription> statoSanzioneList = new ArrayList<IdDescription>();
		try
		{
			List<SigitDStatoSanzioneDto> elencoStatiSanzione = getDbVerificaMgr().getElencoStatoSanzione();
			if (elencoStatiSanzione != null && elencoStatiSanzione.size() > 0)
			{
				statoSanzioneList = MapDto.mapToStatiSanzione(elencoStatiSanzione);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::getElencoStatiSanzione] END");
		}

		return statoSanzioneList;
	}

	public SigitVRicercaAllegatiDto cercaCampiBollino(Verifica verifica) throws ManagerException {
		log.debug("[SigitMgr::cercaCampiBollino] BEGIN");
		SigitVRicercaAllegatiDto risultatoBollino = null;
		try
		{
			FiltroRicercaAllegati filtro = new FiltroRicercaAllegati();
			filtro.setIdBollinoSigla(verifica.getSiglaBollino());
			filtro.setNumeroBollino(ConvertUtil.convertToInteger(verifica.getNumeroBollino()));
			filtro.setIdStatoAllegato(Constants.ID_STATO_RAPPORTO_INVIATO);

			List<SigitVRicercaAllegatiDto> listaAllegati = getDbMgr().cercaAllegatiByFiltro(filtro);

			if (listaAllegati != null && listaAllegati.size() == 1) {
				risultatoBollino = listaAllegati.get(0);
			}

		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
		finally {
			log.debug("[SigitMgr::cercaCampiBollino] END");
		}

		return risultatoBollino;

	}


	public List<Verifica> getElencoVerificheByFilter(RicercaVerificaFilter filter, Map<Integer, String> mappaTipiVerifica) throws ManagerException {
		log.debug("[SigitMgr::getElencoVerificheByFilter] BEGIN");
		List<Verifica> risultatoRicerca = new ArrayList<Verifica>();
		try
		{
			List<SigitTVerificaDto> elencoVerifiche = getDbVerificaMgr().getElencoVerificheByFilter(filter);

			//getDbMgr().validateResultSize(elencoVerifiche);

			if (elencoVerifiche != null) {
				for( SigitTVerificaDto entity : elencoVerifiche ) {
					Verifica dto =	MapDto.mapToVerifica(entity);
					if (mappaTipiVerifica != null) {
						dto.setDescrizioneTipoVerifica(mappaTipiVerifica.get(dto.getTipoVerifica()));
					}
					risultatoRicerca.add(dto);
				}
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
		finally {
			log.debug("[SigitMgr::getElencoVerificheByFilter] END");
		}

		return risultatoRicerca;
	}

	public void eliminaVerificaById(String idVerifica) throws ManagerException {
		log.debug("[SigitMgr::eliminaVerificaById] BEGIN");
		try
		{
			getDbVerificaMgr().eliminaVerificaById(ConvertUtil.convertToInteger(idVerifica));
		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
		finally {
			log.debug("[SigitMgr::eliminaVerificaById] END");
		}

	}

	@Transactional
	public void annullaAccertamento(String idAccertamento, UtenteLoggato utente) throws ManagerException {
		log.debug("[SigitMgr::annullaAccertamento] BEGIN");
		try
		{
			getDbVerificaMgr().annullaAccertamentoById(ConvertUtil.convertToInteger(idAccertamento), utente.getCodiceFiscale());

			getDbAzioneMgr().inserisciAzioneSimply("Annullato", Constants.ID_TIPO_AZIONE_ACCERTAMENTO, utente, ConvertUtil.convertToInteger(idAccertamento));

		} catch (DbManagerException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
		finally {
			log.debug("[SigitMgr::annullaAccertamento] END");
		}

	}

	@Transactional
	public void concludiAccertamento(Accertamento accertamento, String cfUtente) throws ManagerException {
		log.debug("[SigitMgr::concludiAccertamento] BEGIN");
		try
		{
			getDbVerificaMgr().concludiAccertamento(ConvertUtil.convertToInteger(accertamento.getIdentificativo()), accertamento.getIdTipoConclusione(), accertamento.getCodiceImpianto(), accertamento.getCodIstatProv(), cfUtente);

			// ** check che permette di rendere un accertamento sostitutivo di una ispezione ("Si tratta di ACCERTAMENTO sostitutivo dell'ispezione (attezione; se flaggato verra' riportato nella scheda 13 del libretto)")
			if (ConvertUtil.convertToBooleanAllways(accertamento.getFlgSostIspezione()))
			{

				// Devo rimappare l'esito ispezione
				// 1 = (1 positivo accertamento)
				// 0 = (2 negativo accertamento)

				Integer esito = null;

				if (accertamento.getIdTipoConclusione() == Constants.ID_ESITO_POSITIVO)
				{
					esito = Constants.SI_1;
				}
				else if (accertamento.getIdTipoConclusione() == Constants.ID_ESITO_NEGATIVO)
				{
					esito = Constants.NO_0;
				}
				else
				{
					throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
				}

				PersonaFisica pf = cercaPersonaFisicaByCF(accertamento.getCfUtenteCaricamento());
				accertamento.setIdValidatore(pf.getIdPersonaFisica());

				SigitTIspezione2018Pk accertamentoDbPk = getDbIspezioneMgr().inserisciIspezione2018(accertamento, esito);

				getDbIspezioneMgr().inserisciIspezIspetByAccert(accertamento, accertamentoDbPk.getIdIspezione2018(), cfUtente);
			}

		} catch (DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
		finally {
			log.debug("[SigitMgr::concludiAccertamento] END");
		}

	}

	@Transactional
	public void annullaIspezionePrimaParte(Ispezione2018 ispezione, UtenteLoggato utente, List<DettaglioAllegato> listaAllegati) throws ManagerException {
		log.debug("[SigitMgr::annullaIspezionePrimaParte] BEGIN");
		try
		{
			String identificativoIspezione = ispezione.getIdentificativoIspezione();

			SigitRIspezIspetDto ispezIspet = getDbMgr().cercaUltimoRIspezIspetByIdIspezione(identificativoIspezione);

			if (ispezIspet != null) {

				ispezIspet.setDataFine(DateUtil.getSqlCurrentDate());
				ispezIspet.setDataUltMod(DateUtil.getSqlDataCorrente());
				ispezIspet.setUtenteUltMod(utente.getCodiceFiscale());
				getDbMgr().getSigitRIspezIspetDao().updateColumnsAggiornaDataFine(ispezIspet);

			}

			//primo step: annullare ispezione
			getDbIspezioneMgr().annullaIspezione(ConvertUtil.convertToInteger(identificativoIspezione));

			//eliminazione dei rapporti di prova tipo bozza
			if (listaAllegati != null && !listaAllegati.isEmpty()) {
				for (DettaglioAllegato allegato : listaAllegati) {
					if (Constants.DESC_STATO_RAPPORTO_BOZZA.equalsIgnoreCase(allegato.getStatoAllegato())) {
						eliminaAllegatoRappProva(
								allegato.getIdAllegato(),
								utente.getCodiceFiscale(), Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(allegato.getIdTipoAllegato()) ? Constants.TIPO_COMPONENTE_GT :Constants.TIPO_COMPONENTE_GF);
					}

					if (Constants.DESC_STATO_RAPPORTO_INVIATO.equalsIgnoreCase(allegato.getStatoAllegato())) {
						modificaStatoAllegatoRappProva(
								allegato.getIdAllegato(),
								utente.getCodiceFiscale(), Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(allegato.getIdTipoAllegato()) ? Constants.TIPO_COMPONENTE_GT :Constants.TIPO_COMPONENTE_GF);
					}
				}
			}




			//secondo step: creare l'azione per annullamento ispezione
			String descrizioneAzioneIspezione = "Ispezione annullata da " + ConvertUtil.getStringByConcat(" ", utente.getDenominazione(), utente.getCodiceFiscale());
			getDbAzioneMgr().inserisciAzioneSimply(descrizioneAzioneIspezione, Constants.ID_TIPO_AZIONE_ISPEZIONE, utente, ConvertUtil.convertToInteger(identificativoIspezione));

			//creazione di una azione sull'origine dell'ispezione (verifica/accertamento)
			String descrizioneAzioneOrigineIspezione = "L'ispezione " + identificativoIspezione + " associata e' stata annullata";
			Integer origineIspezione = ispezione.getIdVerifica() == null || Constants.DATO_NON_DISPONIBILE_S.equals(ispezione.getIdVerifica()) ? ConvertUtil.convertToInteger(ispezione.getIdAccertamento()) : ConvertUtil.convertToInteger(ispezione.getIdVerifica());
			Integer tipoAzione = ispezione.getIdVerifica() == null || Constants.DATO_NON_DISPONIBILE_S.equals(ispezione.getIdVerifica()) ? Constants.ID_TIPO_AZIONE_ACCERTAMENTO : Constants.ID_TIPO_AZIONE_VERIFICA;
			getDbAzioneMgr().inserisciAzioneSimply(descrizioneAzioneOrigineIspezione, tipoAzione, utente, origineIspezione);

		} catch (DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		} catch (SigitRIspezIspetDaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[SigitMgr::annullaIspezionePrimaParte] END");
		}
	}

	@Transactional
	public void concludiIspezionePrimaParte(Ispezione2018 ispezione, ConclusioneIspezione2018 datiConclusione, UtenteLoggato utente, List<DettaglioAllegato> listaAllegati) throws ManagerException {
		log.debug("[SigitMgr::concludiIspezionePrimaParte] BEGIN");
		try
		{
			String identificativoIspezione = ispezione.getIdentificativoIspezione();


			//eliminazione dei rapporti di prova tipo bozza
			if (listaAllegati != null && !listaAllegati.isEmpty()) {
				for (DettaglioAllegato allegato : listaAllegati) {
					if (Constants.DESC_STATO_RAPPORTO_BOZZA.equalsIgnoreCase(allegato.getStatoAllegato())) {
						eliminaAllegatoRappProva(
								allegato.getIdAllegato(),
								utente.getCodiceFiscale(), Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(allegato.getIdTipoAllegato()) ? Constants.TIPO_COMPONENTE_GT :Constants.TIPO_COMPONENTE_GF);
					}
				}
			}



			//primo step: salvare i dati della conclusione dell'oggetto ispezione
			getDbIspezioneMgr().concludiIspezione(ConvertUtil.convertToInteger(identificativoIspezione), ConvertUtil.convertToBigDecimal(datiConclusione.getFlgEsito()), datiConclusione.getEnteCompetente(), datiConclusione.getNote());

			//secondo step: creare l'azione per conclusione ispezione
			String descrizioneAzioneIspezione = "Ispezione conclusa da " + ConvertUtil.getStringByConcat(" ", utente.getDenominazione(), utente.getCodiceFiscale());
			getDbAzioneMgr().inserisciAzioneSimply(descrizioneAzioneIspezione, Constants.ID_TIPO_AZIONE_ISPEZIONE, utente, ConvertUtil.convertToInteger(identificativoIspezione));

			//terzo step: impostazione della data fine sull'ispettore
			SigitRIspezIspetDto ispezIspet = getDbMgr().cercaUltimoRIspezIspetByIdIspezione(identificativoIspezione);

			if (ispezIspet != null) {

				ispezIspet.setDataFine(DateUtil.getSqlCurrentDate());
				ispezIspet.setDataUltMod(DateUtil.getSqlDataCorrente());
				ispezIspet.setUtenteUltMod(utente.getCodiceFiscale());
				getDbMgr().getSigitRIspezIspetDao().updateColumnsAggiornaDataFine(ispezIspet);

			}

			//quinto step: creazione di una azione sull'origine dell'ispezione (verifica/accertamento)
			if ((ispezione.getIdVerifica() == null || Constants.DATO_NON_DISPONIBILE_S.equals(ispezione.getIdVerifica())) && (ispezione.getIdAccertamento() == null || Constants.DATO_NON_DISPONIBILE_S.equals(ispezione.getIdAccertamento()))) {
				throw new DbManagerException (new Message( "l'ispezione non risulta associata ne' ad una verifica ne' ad un accertamento"));
			}

			String descrizioneAzioneOrigineIspezione = "L'ispezione " + identificativoIspezione + " associata e' stata conclusa";
			Integer origineIspezione = ispezione.getIdVerifica() == null || Constants.DATO_NON_DISPONIBILE_S.equals(ispezione.getIdVerifica()) ? ConvertUtil.convertToInteger(ispezione.getIdAccertamento()) : ConvertUtil.convertToInteger(ispezione.getIdVerifica());
			Integer tipoAzione = ispezione.getIdVerifica() == null || Constants.DATO_NON_DISPONIBILE_S.equals(ispezione.getIdVerifica()) ? Constants.ID_TIPO_AZIONE_ACCERTAMENTO : Constants.ID_TIPO_AZIONE_VERIFICA;
			getDbAzioneMgr().inserisciAzioneSimply(descrizioneAzioneOrigineIspezione, tipoAzione, utente, origineIspezione);


		} catch (DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		} catch (SigitRIspezIspetDaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::concludiIspezionePrimaParte] END");
		}

	}

	@Transactional
	public String annullaIspezioneSecondaParte(Ispezione2018 ispezione, UtenteLoggato utente) throws ManagerException {
		log.debug("[SigitMgr::annullaIspezioneSecondaParte] BEGIN");
		String risultato = null;
		try {
			//si controlla se lo stato dell'ispezione e' consolidato. solo in questo caso devono avvenire i passaggi sul libretto e sulle mail
			if (Constants.ID_STATO_ISPEZIONE_CONSOLIDATO == ConvertUtil.convertToInteger(ispezione.getIdStatoIspezione())) {
				risultato = consolidaLibrettoDaIspezione(Constants.ID_MOTIVO_CONSOLIDAMENTO_ANNULLAMENTO_ISP, ispezione, utente);
			} else {
				log.debug("[SigitMgr::annullaIspezioneSecondaParte] l'ispezione che si sta annullando non si trova in stato consolidato");
			}
		}catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.debug("Errore in annullaIspezioneSecondaParte",e);
			throw e;
		}
		return risultato;

	}

	private String consolidaLibrettoDaIspezione(Integer motivoConsolidamento, Ispezione2018 ispezione, UtenteLoggato utente) throws ManagerException {
		StringBuilder sbEmail = new StringBuilder();
		try {
			Integer idIspezione = ConvertUtil.convertToInteger(ispezione.getIdentificativoIspezione());
			//viene ricercato l'ultima versione consolidata del libretto
			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(ispezione.getCodiceImpianto(), Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			if(librettoList!=null && !librettoList.isEmpty())
			{
				SigitTLibrettoDto libretto = librettoList.get(0);
				log.debug("Libretto consolidato trovato: " + libretto.getIdLibretto());

				libretto.setIdLibretto(null);
				libretto.setFkStato(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_LIBRETTO_BOZZA));

				// Da replicare su tutti
				libretto.setCfRedattore(utente.getCodiceFiscale());

				log.debug("Inserimento libretto in bozza");

				getDbMgr().inserisciLibretto(libretto);

				log.debug("Ricerca impiantoDto");

				SigitTImpiantoDto impiantoDto = getDbMgr().cercaImpiantoDtoById(ispezione.getCodiceImpianto());

				if (Constants.ID_MOTIVO_CONSOLIDAMENTO_ANNULLAMENTO_ISP == motivoConsolidamento) {
					log.debug("Consolidamento libretto per motivo: annullamento ispezione consolidata");
				}

				if (Constants.ID_MOTIVO_CONSOLIDAMENTO_CARICAMENTO_ISP == motivoConsolidamento) {
					log.debug("Consolidamento libretto per motivo: consolidamento caricamento nuova ispezione ");
				}

				creaPdfEConsolidaLibretto(utente, impiantoDto, null, libretto, motivoConsolidamento);
			}


			//invio email
			sbEmail.append("\n\r");

			log.debug("Invio email al validatore assegnatario dell'accertamento/verifica");
			SigitTIspezione2018Dto  ispezioneDb = getDbIspezioneMgr().getSigitTIspezione2018Dao().findByPrimaryKey(new SigitTIspezione2018Pk(idIspezione));

//			Integer origine = getDbIspezioneMgr().getOrigineIspezioneDaDb(ispezioneDb, idIspezione);

			//data l'ispezione accedo alle info sulla persona fisica legata all'accertamento/verifica
			PersonaFisica validatore = getDbIspezioneMgr().findPersonaFisicaVerificaAccertamentoDaIspezione(ispezioneDb, idIspezione);

			// Se il CF e' INSERTAUTOMATICO vuol dire che e' frutto di ribaltamento, quindi non trovera' la Persona Fisica a cui mandare la mail
			if (!validatore.getCodiceFiscale().equalsIgnoreCase(Constants.CF_INSERTAUTOMATICO))
			{
				ResultInvioMail resultInvioMail = null;
				//prima mail
				resultInvioMail = inviaMailIspezione(validatore.getEmail(), ispezione.getCodiceImpianto(), ispezione.getIdentificativoIspezione(), motivoConsolidamento, utente);

				if (resultInvioMail.isPresentsOK())
				{
					sbEmail.append("E' stata inviata una mail al validatore assegnatario dell'accertamento/verifica ("+validatore.getEmail()+") ");
				}
				else if (resultInvioMail.isPresentsKO())
				{
					sbEmail.append("<font color=\"red\">Non e' stata inviata una mail al validatore assegnatario dell'accertamento/verifica ("+validatore.getEmail()+"), verificare l'indirizzo mail </font>");
				}

				String emailGruppo = getDbMgr().getSigitExtDao().findIndirizzoMailAbilitazioneByExample(null, null, ConvertUtil.convertToBigDecimal(validatore.getIdPersonaFisica()));
				//seconda mail
				resultInvioMail = inviaMailIspezione(emailGruppo, ispezione.getCodiceImpianto(), ispezione.getIdentificativoIspezione(), motivoConsolidamento, utente);

				if (resultInvioMail.isPresentsOK())
				{
					sbEmail.append("E' stata inviata una mail alla provincia su cui e' ubicato l'impianto oggetto dell'ispezione ("+emailGruppo+") ");
				}
				else if (resultInvioMail.isPresentsKO())
				{
					sbEmail.append("<font color=\"red\">Non e' stata inviata una mail alla provincia su cui e' ubicato l'impianto oggetto dell'ispezione ("+emailGruppo+"), verificare l'indirizzo mail </font>");
				}
			}
			else
			{
				sbEmail.append("<font color=\"red\">Non e' stata inviata una mail al validatore assegnatario dell'accertamento/verifica</font>");
				sbEmail.append("<font color=\"red\">Non e' stata inviata una mail alla provincia su cui e' ubicato l'impianto oggetto dell'ispezione</font>");
			}

			log.debug("Messaggio conclusione ispezione: " + sbEmail.toString());
			return sbEmail.toString();
		}catch (Exception e) {
				log.debug("Errore in concludiIspezioneSecondaParte",e);
				throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally{
			log.debug("[SigitMgr::concludiIspezioneSecondaParte] END");
		}

	}

	@Transactional
	public String concludiIspezioneSecondaParte(Ispezione2018 ispezione, ConclusioneIspezione2018 datiConclusione, UtenteLoggato utente) throws ManagerException {
		log.debug("[SigitMgr::concludiIspezioneSecondaParte] BEGIN");

		String risultato = null;
		try {
			risultato = consolidaLibrettoDaIspezione(Constants.ID_MOTIVO_CONSOLIDAMENTO_CARICAMENTO_ISP, ispezione, utente);
		}catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.debug("Errore in concludiIspezioneSecondaParte",e);
			throw e;
		}
		return risultato;
	}


	public String associaIspezione(String identificativoIspezione, String idIspettore, UtenteLoggato utente) throws ManagerException {
		log.debug("[SigitMgr::associaIspezione] BEGIN");
		StringBuilder sbEmail = new StringBuilder();

		try {

			String emailDestinatario = getDbIspezioneMgr().associaIspezione(identificativoIspezione, idIspettore, utente);

			if (emailDestinatario != null) {
				log.debug("SigitMgr::associaIspezione: fase invio mail START");
				log.debug("desctinatario: " + emailDestinatario);
				try {
					String oggetto = "CIT - notifica assegnazione ispezione " + identificativoIspezione;
					StringBuffer testoHtml = new StringBuffer();

					testoHtml.append("L'utente " + utente.getDenominazione() + " " + utente.getCodiceFiscale());
					testoHtml.append(" Le ha assegnato l'ispezione "+identificativoIspezione);
					log.debug("TESTO: \n"+testoHtml);
					log.debug("inviaMailAssociaA: STOP");
					ResultInvioMail resultInvioMail = getServiziMgr().sendMail(emailDestinatario, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));

					sbEmail.append("<BR>");

					if (resultInvioMail.isPresentsOK())
					{
						sbEmail.append("E' stata inviata una mail all'ispettore ("+emailDestinatario+") ");
					}
					else if (resultInvioMail.isPresentsKO())
					{
						sbEmail.append("<font color=\"red\">Non e' stata inviata una mail all'ispettore ("+emailDestinatario+"), verificare l'indirizzo mail </font>");
					}
				} catch (ServiceException e) {
					log.error("Errore invio email associa a...", e);
					throw new ManagerException(e, new Message(e.getMessage()));
				}
			} else {
				sbEmail.append("<BR><font color=\"red\">Non e' stata apportata alcuna variazione dell'ispettore, verificare il dato inserito </font>");
			}


		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		} catch (Exception e) {
			throw new ManagerException(e, new Message(Messages.ERROR_INVIO_MAIL));
		}
		finally {
			log.debug("[SigitMgr::associaIspezione] END");
		}

		return sbEmail.toString();
	}


	public String associaAccertamento(String idAccertamento, Integer idValidatore, UtenteLoggato utente) throws ManagerException {
		log.debug("[SigitMgr::associaAccertamento] BEGIN");

		StringBuilder sbEmail = new StringBuilder();

		try
		{
			SigitTPersonaFisicaDto validatore = getDbMgr().cercaTPersonaFisicaById(idValidatore);
			getDbAzioneMgr().associaAccertamento(ConvertUtil.convertToInteger(idAccertamento), validatore, utente);

			ResultInvioMail resultInvioMail = inviaMailAssociaA(idAccertamento, validatore.getEmail(), utente);

			sbEmail.append("<BR>");

			if (resultInvioMail.isPresentsOK())
			{
				sbEmail.append("E' stata inviata una mail al validatore ("+validatore.getEmail()+") ");
			}
			else if (resultInvioMail.isPresentsKO())
			{
				sbEmail.append("<font color=\"red\">Non e' stata inviata una mail al validatore ("+validatore.getEmail()+"), verificare l'indirizzo mail </font>");
			}

		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		} catch (Exception e) {
			throw new ManagerException(e, new Message(Messages.ERROR_INVIO_MAIL));
		}
		finally {
			log.debug("[SigitMgr::associaAccertamento] END");

		}
		return sbEmail.toString();

	}

	@Transactional
	public void sbloccaNomina3R(String idAccertamento, String codiceImpianto, UtenteLoggato utente) throws ManagerException {
		log.debug("[SigitMgr::sbloccaNomina3R] BEGIN");
		try
		{
			getDbMgr().aggiornaImpiantoSblocca3R(codiceImpianto, utente.getCodiceFiscale(), false);

			getDbAzioneMgr().inserisciAzioneSimply("Sblocco nomina Terza Responsabilita'", Constants.ID_TIPO_AZIONE_ACCERTAMENTO, utente, ConvertUtil.convertToInteger(idAccertamento));

		} catch (DbManagerException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
		finally {
			log.debug("[SigitMgr::sbloccaNomina3R] END");
		}

	}

	public List<Accertamento> getElencoAccertamentiByFilter(RicercaAccertamentoFilter filter, Map<Integer, String> mappaStatoAccertamento,
			Map<String, String> mappaTipoAnomalieVerifica, Map<String, String> mappaElencoProvincePiemIstat) throws ManagerException {
		log.debug("[SigitMgr::getElencoAccertamentiByFilter] BEGIN");
		List<Accertamento> risultatoRicerca = new ArrayList<Accertamento>();
		try
		{
			List<SigitTAccertamentoDto> elencoAccertamenti = getDbVerificaMgr().getElencoAccertamentiByFilter(filter);

			//getDbMgr().validateResultSize(elencoAccertamenti);

			if (elencoAccertamenti != null) {
				for( SigitTAccertamentoDto entity : elencoAccertamenti ) {
					Accertamento dto =	MapDto.mapToAccertamento(entity, null);
					if (mappaStatoAccertamento != null) {
						dto.setDescStatoAccertamento(mappaStatoAccertamento.get(dto.getIdStatoAccertamento()));
					}

					if (mappaTipoAnomalieVerifica != null) {
						dto.setDescTipoAnomalia(mappaTipoAnomalieVerifica.get(dto.getIdTipoAnomalia()));
					}

					if (mappaElencoProvincePiemIstat != null) {
						dto.setSiglaProv(mappaElencoProvincePiemIstat.get(dto.getCodIstatProv()));
					}

					if(GenericUtil.isNotNullOrEmpty(dto.getCodIstatCom())) {
						ArrayList<CodeDescription> comuni= getServiziMgr().getListaComuniByIstatProvincia(GenericUtil.getCodIstatProvByCodIstatComune(dto.getCodIstatCom()));
						if(GenericUtil.isNotNullOrEmpty(comuni)){
							String descCom = GenericUtil.getDescriptionByCod(dto.getCodIstatCom(), comuni);
							dto.setDenomComune(descCom);
						}
					}

					risultatoRicerca.add(dto);
				}
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		} catch (ServiceException e) {
			e.printStackTrace();
		} finally {
			log.debug("[SigitMgr::getElencoAccertamentiByFilter] END");
		}

		return risultatoRicerca;
	}

	public Sveglia getSvegliaById(int idTipoAzione, String idAzione) throws ManagerException {
		log.debug("[SigitMgr::getSvegliaById] BEGIN");
		try
		{
			return getDbSvegliaMgr().getSvegliaById(idTipoAzione, ConvertUtil.convertToInteger(idAzione));
		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
		finally {
			log.debug("[SigitMgr::getSvegliaById] END");
		}
	}

	public void modificaSveglia(Sveglia sveglia, int idTipoAzione, String idAzione) throws ManagerException {
		log.debug("[SigitMgr::modificaSveglia] BEGIN");
		try
		{
			getDbSvegliaMgr().modificaSveglia(sveglia, idTipoAzione, idAzione);
		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
		finally {
			log.debug("[SigitMgr::modificaSveglia] END");
		}
	}

	public ArrayList<Sveglia> getSveglieByCfUtente(int idTipoAzione, String cfUtente) throws ManagerException {
		log.debug("[SigitMgr::getSveglieByCfUtente] BEGIN");
		try
		{
			return getDbSvegliaMgr().getSveglieAttiveByCfUtente(idTipoAzione, cfUtente);
		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
		finally {
			log.debug("[SigitMgr::getSveglieByCfUtente] END");
		}
	}

	public String salvaVerifica(Verifica verifica, UtenteLoggato utente) throws ManagerException {
		log.debug("[SigitMgr::salvaVerifica] BEGIN");
		String idVerifica = null;
		try
		{
			SigitTVerificaPk pk = getDbVerificaMgr().salvaVerifica(MapDto.mapToSigitTVerificaDto(verifica, utente));
			verifica.setIdentificativo(ConvertUtil.convertToString(pk.getIdVerifica()));
			idVerifica = verifica.getIdentificativo();
		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
		finally {
			log.debug("[SigitMgr::salvaVerifica] END");
		}
		return idVerifica;
	}


	private CodeDescription creaAutomatismiDecadenza(String codiceImpianto) throws ManagerException {
		return creaAutomatismiAccertamento(codiceImpianto, TipoVerificaEnum.DECADENZA3R.getIdDb(), null);
	}

	private CodeDescription creaAutomatismiInvioRee(String codiceImpianto, SigitTAllegatoDto allegatoDto) throws ManagerException {
		return creaAutomatismiAccertamento(codiceImpianto, TipoVerificaEnum.REE.getIdDb(), allegatoDto);
	}

	private CodeDescription creaAutomatismiAccertamento(String codiceImpianto, int idTipoVerifica, SigitTAllegatoDto allegatoDto) throws ManagerException {
		log.debug("[SigitMgr::creaAutomatismiAccertamento] BEGIN");

		try
		{
			UtenteLoggato utenteAuto = new UtenteLoggato();
			utenteAuto.setCodiceFiscale("INSERTAUTOMATICO");
//			utenteAuto.setDenominazione("INSERIMENTO AUTOMATICO");

			Verifica verificaAuto = new Verifica();
			verificaAuto.setTipoVerifica(idTipoVerifica);
			verificaAuto.setCodiceImpianto(codiceImpianto);

			if (allegatoDto != null)
			{
				// Nel caso di "Avvio automatico accertamento" per invio REE
				verificaAuto.setIdAllegato(ConvertUtil.convertToString(allegatoDto.getIdAllegato()));
				verificaAuto.setSiglaBollino(allegatoDto.getFkSiglaBollino());
				verificaAuto.setNumeroBollino(ConvertUtil.convertToString(allegatoDto.getFkNumeroBollino()));
			}

			verificaAuto.setDataCaricamento(DateUtil.getDataCorrenteFormat());
			String idVerifica = salvaVerifica(verificaAuto, utenteAuto);
			log.debug("[SigitMgr::creaAutomatismiAccertamento] salvataggio verifica");

			Azione azioneAuto = new Azione();
			azioneAuto.setFkAzione(ConvertUtil.convertToInteger(idVerifica));

			if (idTipoVerifica == TipoVerificaEnum.DECADENZA3R.getIdDb())
			{
				azioneAuto.setDescrizione("Creazione automatica di verifica per decadenza 3 RESP");
			}
			else if (idTipoVerifica == TipoVerificaEnum.REE.getIdDb())
			{
				azioneAuto.setDescrizione("Creazione automatica di verifica su impianto che non puo' funzionare ai fini della sicurezza");
			}

			inserisciAzioneEDocumento(Constants.ID_TIPO_AZIONE_VERIFICA, azioneAuto, null, utenteAuto);
			log.debug("[SigitMgr::creaAutomatismiAccertamento] salvataggio azione");

			SigitVRicercaImpiantiDto impiantoEntity = getDbMgr().cercaImpiantoByCodImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
			log.debug("[SigitMgr::creaAutomatismiAccertamento] ricerca impianto");

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
			log.debug("[SigitMgr::creaAutomatismiAccertamento] salvataggio accertamento");

			if (idTipoVerifica == TipoVerificaEnum.DECADENZA3R.getIdDb())
			{
				getDbMgr().aggiornaImpiantoSblocca3R(codiceImpianto, utenteAuto.getCodiceFiscale(), true);
				log.debug("[SigitMgr::creaAutomatismiAccertamento] salvataggio impianto");
			}

			//String indirizzoMail = getDbMgr().getSigitExtDao().findIndirizzoMailAbilitazioneByExample(ruoloUtenteLoggato, impiantoEntity.getIstatComune());
			String indirizzoMail = getDbMgr().cercaIndirizzoMailAbilitazioneValidatore(GenericUtil.getCodIstatProvByCodIstatComune(impiantoEntity.getIstatComune()), Constants.ID_RUOLO_PA_VALIDATORE);
			log.debug("[SigitMgr::creaAutomatismiAccertamento] manca invio mail");

			CodeDescription risultato = new CodeDescription();
			risultato.setCode(identificativoAccertamento);
			risultato.setDescription(indirizzoMail);

			return risultato;

		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
//		catch (SigitExtDaoException e2) {
//			throw new ManagerException(e2, e2.getMessage() == null ? new Message(Messages.ERROR_RECUPERO_DB) : new Message(e2.getMessage()));
//		}
		finally {
			log.debug("[SigitMgr::creaAutomatismiAccertamento] END");
		}
	}

	public Verifica getVerificaDaId(String idVerifica, Map<Integer, String> mappaTipiVerifica, boolean complete) throws ManagerException {
		log.debug("[SigitMgr::getVerificaDaId] BEGIN");
		Verifica verifica = null;
		try {
			SigitExtVerificaDto verificaEntity = getDbVerificaMgr().getVerificaById(ConvertUtil.convertToInteger(idVerifica));
			verifica = MapDto.mapToVerifica(verificaEntity);
			if (mappaTipiVerifica != null) {
				verifica.setDescrizioneTipoVerifica(mappaTipiVerifica.get(verifica.getTipoVerifica()));
			}
			if (complete) {
				if (!GenericUtil.isNullOrEmpty(verifica.getCodiceImpianto()) && !Constants.DATO_NON_DISPONIBILE_S.equals(verifica.getCodiceImpianto())) {
					ricercaImpiantoPerVerifica(verifica, false);
				}
				if (!GenericUtil.isNullOrEmpty(verifica.getNumeroBollino()) && !Constants.DATO_NON_DISPONIBILE_S.equals(verifica.getNumeroBollino())
						&& !GenericUtil.isNullOrEmpty(verifica.getSiglaBollino() != null)) {
					ricercaBollinoPerVerifica(verifica, false);
				}
				if (!GenericUtil.isNullOrEmpty(verifica.getIdDatoDistributore()) && !Constants.DATO_NON_DISPONIBILE_S.equals(verifica.getIdDatoDistributore())) {
					ricercaDistributorePerVerifica(verifica, false);
				}
			}

		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
		finally {
			log.debug("[SigitMgr::getVerificaDaId] END");
		}
		return verifica;
	}

	public List<Ispezione2018> findIspezioniConsByCodImpianto(Integer codiceImpianto) throws ManagerException {
		log.debug("[SigitMgr::findIspezioniConsByCodImpianto] BEGIN");

		List<Ispezione2018> listaRisultati = new ArrayList<Ispezione2018>();

		try
		{
			List<SigitVRicercaIspezioniConsByCodiceImpiantoDto> listIspezioniDb = getDbMgr().getSigitVRicercaIspezioniDao().findConsByCodiceImpianto(codiceImpianto);

			IspezioneFilter filter = new IspezioneFilter();
			filter.setCodiceImpianto(codiceImpianto);
			filter.setIdStatoIspezione(Constants.ID_STATO_ISPEZIONE_CONSOLIDATO);

			String elencoIspezioni = null;

			for (SigitVRicercaIspezioniConsByCodiceImpiantoDto sigitVRicercaIspezioniConsByCodiceImpiantoDto : listIspezioniDb) {

				if (elencoIspezioni == null)
				{
					elencoIspezioni = ConvertUtil.convertToString(sigitVRicercaIspezioniConsByCodiceImpiantoDto.getIdIspezione2018());
				}
				else
				{
					elencoIspezioni += ", "+sigitVRicercaIspezioniConsByCodiceImpiantoDto.getIdIspezione2018();
				}
			}

			filter.setElencoIdIspezione2018(elencoIspezioni);

			List<SigitVRicercaIspezioniDto> listIspezioniDettDb = getDbMgr().getSigitVRicercaIspezioniDao().findConsDettRappProvaByFilter(filter);

			Ispezione2018 ispezione = null;
			for (SigitVRicercaIspezioniConsByCodiceImpiantoDto ispezioneDb : listIspezioniDb) {
				ispezione = new Ispezione2018();
				// MAX (ID_ISPEZ_ISPET) as ID_ISPEZ_ISPET, ID_ISPEZIONE_2018, DT_CREAZIONE, ENTE_COMPETENTE, NOTE, FLG_ESITO
				ispezione.setIdentificativoIspezione(ConvertUtil.convertToString(ispezioneDb.getIdIspezione2018()));
				ispezione.setDataCreazione(ConvertUtil.convertToString(ispezioneDb.getDtCreazione()));
				ispezione.setEnteCompetente(ispezioneDb.getEnteCompetente());
				ispezione.setNote(ispezioneDb.getNote());

				Boolean esitoBoolean = ConvertUtil.convertToBoolean(ispezioneDb.getFlgEsito());
				ispezione.setEsito(esitoBoolean == null ? "" : esitoBoolean ? PositivoNegativoEnum.POSITIVO.getDescrizione() : PositivoNegativoEnum.NEGATIVO.getDescrizione());

				for (SigitVRicercaIspezioniDto sigitVRicercaIspezioniDto : listIspezioniDettDb) {

					if (ispezioneDb.getIdIspezione2018().intValue() == sigitVRicercaIspezioniDto.getIdIspezione2018().intValue())
					{
						String etichettaCorrente = ConvertUtil.getStringByConcat(": ",
								ConvertUtil.convertToString(sigitVRicercaIspezioniDto.getDataControllo()),
								sigitVRicercaIspezioniDto.getElencoApparecchiature());
						ispezione.getRapportiDesc().add(etichettaCorrente);
						ispezione.getRapportiId().add(ConvertUtil.convertToLong(sigitVRicercaIspezioniDto.getIdAllegato()));
					}
				}

				listaRisultati.add(ispezione);
			}

			return listaRisultati;

		}
		catch (SigitVRicercaIspezioniDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::findIspezioniConsByCodImpianto] END");
		}
	}

	public List<Ispezione2018> findIspezioniByFilter(RicercaIspezioni2018 ricercaIspezioni,
			Map<Integer, String> mappaStatoIspezione,
			Map<String, String> mappaElencoProvincePiemIstat) throws ManagerException {
		log.debug("[SigitMgr::findIspezioniByFilter] BEGIN");
		List<Ispezione2018> output = new ArrayList<Ispezione2018>();
		RicercaIspezioniFilter filter = RicercaIspezioniFilter.getByRicercaIspezione2018(ricercaIspezioni);
		try {
			List<SigitVRicercaIspezioniDto> lista = getDbIspezioneMgr().findIspezioniByFilter(filter);
			if (lista != null) {

				Integer maxNumRighe = getDbMgr().cercaConfigValueNumerico(Constants.MAX_RIGHE_RIC_AVANZATA_IMPIANTI);
				log.debug("MAX num righe da visualizzare = " + maxNumRighe);

				BigDecimal lastIdIspezione2018 = null;
				for (SigitVRicercaIspezioniDto ispezioneDb : lista) {

					if (output.size() == maxNumRighe)
					{
						//throw new ValidationManagerException(new Message(Messages.I002, Message.INFO));
						// Se supero il numero max di righe da visualizzare, esco e visualizzo solo una porzione di risultati
						break;
					}

					if (!ispezioneDb.getIdIspezione2018().equals(lastIdIspezione2018))
					{
						// E' un'ispezione ancora NON presente nella lista, quindi l'aggiungo
						lastIdIspezione2018 = ispezioneDb.getIdIspezione2018();
						output.add(MapDto.mapToRisultatoRicercaIspezione(ispezioneDb, mappaStatoIspezione, mappaElencoProvincePiemIstat));
					}
					// else se � un'ispezione gia' presente nella lista lo scarto

				}
			}

			return output;

		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
		finally {
			log.debug("[SigitMgr::findIspezioniByFilter] END");
		}
	}

	public void ricercaImpiantoPerIspezione(RicercaImpiantoDaAssociare ricerca) throws ManagerException {
		log.debug("[SigitMgr::ricercaImpiantoPerIspezione] BEGIN");
		Integer codiceImpianto = ConvertUtil.convertToInteger(ricerca.getCodiceImpianto());
		SigitVTotImpiantoCercaUbicazioneImpiantoDto impianto = getDbMgr().cercaUbicazioneImpianto(codiceImpianto);
		Responsabile responsabile = cercaResponsabileAttivoByIdImpianto(codiceImpianto);
		if (impianto != null) {

			ricerca.setCodIstatProv(GenericUtil.getCodIstatProvByCodIstatComune(impianto.getIstatComune()));
			String ubicazioneImpianto =  MapDto.getRisultatoImpianto(impianto);
			ricerca.setRicercaEseguita(true);
			ricerca.setUbicazione(!GenericUtil.isNullOrEmpty(ubicazioneImpianto) ? "localizzazione: " + ubicazioneImpianto : "");
			if (responsabile != null) {
				ricerca.setResponsabile(ConvertUtil.getStringByConcat(" ", responsabile.getNome(), responsabile.getCognome(), responsabile.getCodiceFiscale()));
			}
		} else {
			ricerca.setRicercaEseguita(false);
			ricerca.setCodIstatProv(null);
			ricerca.setUbicazione(null);
			ricerca.setResponsabile(null);
			throw new ManagerException(new Message(Messages.ERROR_CODICE_IMPIANTO_NON_ESISTE));
		}

	}

	public void ricercaImpiantoPerAccertamento(it.csi.sigit.sigitwebn.dto.accertamento.RicercaImpiantoDaAssociare ricerca) throws ManagerException {
		log.debug("[SigitMgr::ricercaImpiantoPerAccertamento] BEGIN");
		Integer codiceImpianto = ConvertUtil.convertToInteger(ricerca.getCodiceImpianto());
		SigitVTotImpiantoCercaUbicazioneImpiantoDto impianto = getDbMgr().cercaUbicazioneImpianto(codiceImpianto);
		Responsabile responsabile = cercaResponsabileAttivoByIdImpianto(codiceImpianto);
		if (impianto != null) {
			String ubicazioneImpianto =  MapDto.getRisultatoImpianto(impianto);
			ricerca.setRicercaEseguita(true);
			ricerca.setCodIstatProv(GenericUtil.getCodIstatProvByCodIstatComune(impianto.getIstatComune()));
			ricerca.setUbicazione(!GenericUtil.isNullOrEmpty(ubicazioneImpianto) ? "localizzazione: " + ubicazioneImpianto : "");
			if (responsabile != null) {
				ricerca.setResponsabile(ConvertUtil.getStringByConcat(" ", responsabile.getNome(), responsabile.getCognome(), responsabile.getCodiceFiscale()));
			}
		} else {
			ricerca.setRicercaEseguita(false);
			ricerca.setUbicazione(null);
			ricerca.setResponsabile(null);
			throw new ManagerException(new Message(Messages.ERROR_CODICE_IMPIANTO_NON_ESISTE));
		}

	}

	@Transactional
	public void associaImpiantoAdIspezione(String codiceImpianto, String codIstatProv, String idIspezione, UtenteLoggato utente) throws ManagerException {
		log.debug("[SigitMgr::associaImpiantoAdIspezione] BEGIN");
			//si recupera l'ispezione da aggiornare
			Integer idIspezioneInt = ConvertUtil.convertToInteger(idIspezione);
			SigitTIspezione2018Dto ispezione = null;
			try {
				ispezione = getDbIspezioneMgr().caricaIspezioneDaId(idIspezioneInt);
				ispezione.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
				ispezione.setIstatProvCompetenza(codIstatProv);
				getDbIspezioneMgr().getSigitTIspezione2018Dao().update(ispezione);

				//una volta aggiornata l'ispezione si passa alla creazione dell'azione
				getDbAzioneMgr().inserisciAzioneSimply("valorizzato codice impianto " + codiceImpianto,
						Constants.ID_TIPO_AZIONE_ISPEZIONE, utente, idIspezioneInt);

				//si deve andare in cascata su sigit_r_ispez_ispet
				/*
				SigitRIspezIspetDto ispezIspet = new SigitRIspezIspetDto();
				ispezIspet.setIdIspezione2018(ispezione.getIdIspezione2018());
				ispezIspet.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
				ispezIspet.setDataUltMod(DateUtil.getSqlDataCorrente());
				ispezIspet.setUtenteUltMod(utente.getCodiceFiscale());

				getDbMgr().getSigitRIspezIspetDao().customUpdaterAggiornaCodiceImpianto(ispezIspet, null);
				*/
				/*
				if (ispezione.getFkImpRuoloPfpgIspettore() != null && ConvertUtil.convertToInteger(ispezione.getFkImpRuoloPfpgIspettore()) != 0) {

					SigitRImpRuoloPfpgDto ispettore = getDbMgr().getSigitRImpRuoloPfpgDao().findByPrimaryKey(new SigitRImpRuoloPfpgPk(ispezione.getFkImpRuoloPfpgIspettore()));
					ispettore.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));

					SigitRIspezIspetDto ispezIspet = new SigitRIspezIspetDto();
					ispezIspet.setIdIspezione2018(ispezione.getIdIspezione2018());
					ispezIspet.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
					ispezIspet.setDataUltMod(DateUtil.getSqlDataCorrente());
					ispezIspet.setUtenteUltMod(utente.getCodiceFiscale());

					getDbMgr().getSigitRIspezIspetDao().customUpdaterAggiornaCodiceImpianto(ispezIspet, null);;

				}
				*/

			} catch (DbManagerException e) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

				throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
			} catch (SigitTIspezione2018DaoException e) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
//			catch (SigitRIspezIspetDaoException e) {
//				throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
//			}

	}

	@Transactional
	public void associaImpiantoAdAccertamento(String codiceImpianto, String istatProv, String idAccertamento, UtenteLoggato utente) throws ManagerException {
		log.debug("[SigitMgr::associaImpiantoAdAccertamento] BEGIN");
		//si recupera l'accertamento da aggiornare
		Integer idIspezioneInt = ConvertUtil.convertToInteger(idAccertamento);
		SigitTAccertamentoDto accertamento = null;
		try {
			accertamento = getDbVerificaMgr().getAccertamentoById(ConvertUtil.convertToInteger(idAccertamento));

			accertamento.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
			accertamento.setIstatProvCompetenza(ReplaceSpecialCharUtils.sanitize(istatProv));
			getDbVerificaMgr().getSigitTAccertamentoDao().update(accertamento);

			//una volta aggiornata l'ispezione si passa alla creazione dell'azione
			getDbAzioneMgr().inserisciAzioneSimply("valorizzato codice impianto " + codiceImpianto,
					Constants.ID_TIPO_AZIONE_ACCERTAMENTO, utente, idIspezioneInt);



		} catch (DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		} catch (SigitTAccertamentoDaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[SigitMgr::associaImpiantoAdAccertamento] END");

	}

	public void ricercaImpiantoPerVerifica(Verifica verifica, boolean valida) throws ManagerException {
		ricercaImpiantoPerVerifica(verifica, valida, null);
	}
	
	public void ricercaImpiantoPerVerifica(Verifica verifica, boolean valida, String istatAbilitazione) throws ManagerException {
		if (valida) {
			getValidationMgr().validazioneFormaleRicercaCampiVerifiche(verifica,
					RicercaCampoVerificaEnum.RICERCA_IMPIANTO);
		}
		//SUPERATA LA VALIDAZIONE SI ESEGUE LA RICERCA DELL'IMPIANTO
		SigitVTotImpiantoCercaUbicazioneImpiantoDto impianto = getDbMgr().cercaUbicazioneImpianto(ConvertUtil.convertToInteger(verifica.getCodiceImpianto()));
		
		if (impianto != null) {
			
			checkCompetenzaImpianto(impianto.getIstatComune(), istatAbilitazione);
			
			String ubicazioneImpianto =  MapDto.getRisultatoImpianto(impianto);
			verifica.setRisultatoImpianto(!GenericUtil.isNullOrEmpty(ubicazioneImpianto) ? "localizzazione: " + ubicazioneImpianto : "");
		} else {
			throw new ManagerException(new Message(Messages.ERROR_CODICE_IMPIANTO_NON_ESISTE));
		}

	}

	private void checkCompetenzaImpianto(String istatImpianto, String istatAbilitazione) throws ManagerException {

		log.debug("Stampo rpv - istatAbilitazione: "+istatAbilitazione);
		log.debug("Stampo rpv - istatImpianto: "+istatImpianto);


		if (istatAbilitazione != null)
		{
			if (istatAbilitazione.length() > 5) {
				// e' presente il comune
				String codIstatComune = GenericUtil.getCodIstatComuneByIstatAbilitazione(istatAbilitazione);
				log.debug("Stampo rpv - codIstatComuneAbil: "+codIstatComune);
				log.debug("Stampo rpv - istatImpianto: "+istatImpianto);

				if (!istatImpianto.equalsIgnoreCase(codIstatComune))
				{
					log.debug("Stampo rpv - Rilancio eccezione (comune) ERROR_IMPIANTO_NO_COMPETENZA");

					throw new ManagerException(new Message(Messages.ERROR_IMPIANTO_NO_COMPETENZA));
				}
			}
			else
			{
				// e' presente la provincia
				String codIstatProv = GenericUtil.getCodIstatProvByIstatAbilitazione(istatAbilitazione);
				log.debug("Stampo rpv - codIstatProv: "+codIstatProv);
				String istatProvImpianto = GenericUtil.getCodIstatProvByCodIstatComune(istatImpianto);
				log.debug("Stampo rpv - istatProvImpianto: "+istatProvImpianto);

				if (!istatProvImpianto.equals(codIstatProv))
				{

					log.debug("Stampo rpv - Rilancio eccezione (provincia) ERROR_IMPIANTO_NO_COMPETENZA");
					throw new ManagerException(new Message(Messages.ERROR_IMPIANTO_NO_COMPETENZA));
				}
			}
		}
	}

	public void ricercaImpiantoPerAccertamento(Accertamento accertamento, boolean valida) throws ManagerException {
		if (valida) {
			getValidationMgr().validazioneFormaleConfermaAccertamentoCampiVerifiche(accertamento,
					RicercaCampoAccertamentoEnum.RICERCA_IMPIANTO);
		}
		//SUPERATA LA VALIDAZIONE SI ESEGUE LA RICERCA DELL'IMPIANTO
		SigitVTotImpiantoCercaUbicazioneImpiantoDto impianto = getDbMgr().cercaUbicazioneImpianto(ConvertUtil.convertToInteger(accertamento.getCodiceImpiantoNew()));
		if (impianto != null) {
			String ubicazioneImpianto =  MapDto.getRisultatoImpianto(impianto);
			accertamento.setCodiceImpianto(ConvertUtil.convertToString(impianto.getCodiceImpianto()));
			accertamento.setCodIstatProv(GenericUtil.getCodIstatProvByCodIstatComune(impianto.getIstatComune()));

			accertamento.setRisultatoImpianto(!GenericUtil.isNullOrEmpty(ubicazioneImpianto) ? "localizzazione: " + ubicazioneImpianto : "");
		} else {
			throw new ManagerException(new Message(Messages.ERROR_CODICE_IMPIANTO_NON_ESISTE));
		}

	}

	public void ricercaBollinoPerVerifica(Verifica verifica, boolean valida) throws ManagerException {
		ricercaBollinoPerVerifica(verifica, valida, null);
	}
	
	public void ricercaBollinoPerVerifica(Verifica verifica, boolean valida, String istatAbilitazione) throws ManagerException {
		if (valida) {
			getValidationMgr().validazioneFormaleRicercaCampiVerifiche(verifica,
					RicercaCampoVerificaEnum.RICERCA_BOLLINO);
		}

		//SUPERATA LA VALIDAZIONE SI ESEGUE LA RICERCA DEL BOLLINO
		SigitVRicercaAllegatiDto risultatoBollino = cercaCampiBollino(verifica);
		if (risultatoBollino != null) {
			
			try
			{
				if (istatAbilitazione != null)
				{
					String istatImpianto = getImpiantoByCodice(ConvertUtil.convertToString(risultatoBollino.getCodiceImpianto())).getIstatComune();
					
					checkCompetenzaImpianto(istatImpianto, istatAbilitazione);
				}
			}
			catch (ServiceException ex)
			{
				// Non si dovrebbe mai verificare
				throw new ManagerException(new Message(Messages.ERROR_BOLLINO_NON_ESISTE));
			}
				
			verifica.setRisultatoBollinoExtended(MapDto.getRisultatoBollinoExtended(risultatoBollino));
			verifica.setIdAllegato(ConvertUtil.convertToString(risultatoBollino.getIdAllegato()));
			verifica.setCodiceImpianto(ConvertUtil.convertToString(risultatoBollino.getCodiceImpianto())); //il codice impianto viene recuperato dal bollino ricercato

			String indirizzo = MapDto.getIndirizzoCompleto(risultatoBollino.getComuneImpianto(), risultatoBollino.getIndirizzoUnitaImmob(), risultatoBollino.getCivicoUnitaImmob(), risultatoBollino.getSiglaProvImpianto());
			verifica.setRisultatoImpianto("localizzazione: " + indirizzo); // setto il RisultatoImpianto per baypassare la validazione, altrimenti trova il codice impianto settato ed il risoltato no, quindi penssa che l'utente non l'abbia cercato
		} else {
			throw new ManagerException(new Message(Messages.ERROR_BOLLINO_NON_ESISTE));
		}
	}
	
	public void ricercaDistributorePerVerifica(Verifica verifica, boolean valida) throws ManagerException {
		ricercaDistributorePerVerifica(verifica, valida, null);
	}

	public void ricercaDistributorePerVerifica(Verifica verifica, boolean valida, String istatAbilitazione) throws ManagerException {
		if (valida) {
			getValidationMgr().validazioneFormaleRicercaCampiVerifiche(verifica,
					RicercaCampoVerificaEnum.RICERCA_DISTRIBUTORE);
		}

		//SUPERATA LA VALIDAZIONE SI ESEGUE LA RICERCA DEL DISTRIBUTORE
		SigitTDatoDistribDto risultato = getDbMgr().cercaDatoDistributore(ConvertUtil.convertToInteger(verifica.getIdDatoDistributore()));
		if (risultato == null) {
			throw new ManagerException(new Message(Messages.ERROR_DATO_DISTRIBUTORE_NON_ESISTE));
		}
		
		checkCompetenzaImpianto(risultato.getIstatComune(), istatAbilitazione);
		
		SigitTImportDistribRicevutaByIdImportDistribDto distribDto = getDbMgr().cercaImportRicevutaByIdDistr(risultato.getFkImportDistrib());

		String descComuneDatoDistributore = "";

		try {
			Comune comuneDatoDistributore = getServiziMgr().getComuneDaCodiceIstat(risultato.getIstatComune());

			if (comuneDatoDistributore != null && GenericUtil.isNotNullOrEmpty(comuneDatoDistributore.getNome())) {

				descComuneDatoDistributore = comuneDatoDistributore.getNome();

			} else {
				descComuneDatoDistributore = risultato.getIstatComune();
			}

		} catch (Exception e) {
			log.error("Errore durante la decodifica del codice istat del comune del dato distributore", e);
			descComuneDatoDistributore = risultato.getIstatComune();
		}

		verifica.setRisultatoDatoDistributore(MapDto.getRisultatoDistributore(risultato, distribDto, descComuneDatoDistributore));
	}

	public Accertamento getAccertamentoDaId(String idAccertamento, Map<Integer, String> mappaStatoAccertamento, Map<Integer, String> mappaTipoConclusione) throws ManagerException {
		log.debug("[SigitMgr::getAccertamentoDaId] BEGIN");
		Accertamento accertamento = null;
		try {
			SigitTAccertamentoDto accertamentoEntity = getDbVerificaMgr().getAccertamentoById(ConvertUtil.convertToInteger(idAccertamento));
			SigitVRicercaImpiantiDto impiantoEntity = null;
			if (GenericUtil.isNotNullOrEmpty(accertamentoEntity.getCodiceImpianto()))
			{
				impiantoEntity = getDbMgr().cercaImpiantoByCodImpianto(accertamentoEntity.getCodiceImpianto());
			}

			accertamento = MapDto.mapToAccertamento(accertamentoEntity, impiantoEntity);

			log.debug("[SigitMgr::getAccertamentoDaId] - mappaStatoAccertamento: "+mappaStatoAccertamento);

			if (mappaStatoAccertamento != null) {
				log.debug("[SigitMgr::getAccertamentoDaId] - accertamento.getIdStatoAccertamento(): "+accertamento.getIdStatoAccertamento());
				log.debug("[SigitMgr::getAccertamentoDaId] - mappaStatoAccertamento.get(accertamento.getIdStatoAccertamento()): "+mappaStatoAccertamento.get(accertamento.getIdStatoAccertamento()));

				accertamento.setDescStatoAccertamento(mappaStatoAccertamento.get(accertamento.getIdStatoAccertamento()));
			}

			if(GenericUtil.isNotNullOrEmpty(accertamento.getCodIstatCom())) {
				ArrayList<CodeDescription> comuni= getServiziMgr().getListaComuniByIstatProvincia(GenericUtil.getCodIstatProvByCodIstatComune(accertamento.getCodIstatCom()));
				if(GenericUtil.isNotNullOrEmpty(comuni)){
					String descCom = GenericUtil.getDescriptionByCod(accertamento.getCodIstatCom(), comuni);
					accertamento.setDenomComune(descCom);
				}
			}

			if(GenericUtil.isNotNullOrEmpty(accertamento.getSiglaProv())){
				if(GenericUtil.isNotNullOrEmpty(accertamento.getCodIstatProv())) {
					Provincia provincia = getServiziMgr().getProvinciaDaCodiceIstatOrSigla(accertamento.getCodIstatProv());
					if(GenericUtil.isNotNullOrEmpty(provincia)) {
						String siglaProv = provincia.getSigla().toUpperCase();
						accertamento.setSiglaProv(siglaProv);
					}
				}
			}

			log.debug("[SigitMgr::getAccertamentoDaId] - mappaTipoConclusione: "+mappaTipoConclusione);
			if (mappaTipoConclusione != null) {
				log.debug("[SigitMgr::getAccertamentoDaId] - accertamento.getIdTipoConclusione(): "+accertamento.getIdTipoConclusione());
				log.debug("[SigitMgr::getAccertamentoDaId] - mappaTipoConclusione.get(accertamento.getIdTipoConclusione()): "+mappaTipoConclusione.get(accertamento.getIdTipoConclusione()));

				accertamento.setDescTipoConclusione(mappaTipoConclusione.get(accertamento.getIdTipoConclusione()));
			}

			if (log.isDebugEnabled())
			{
				GenericUtil.stampa(accertamento, true, 3);
			}


		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		} catch (ServiceException e) {
			e.printStackTrace();
		} finally {
			log.debug("[SigitMgr::getAccertamentoDaId] END");
		}
		return accertamento;
	}

	public ArrayList<IspezioneAccertamento> getIspezioniByIdAccertamento(String idAccertamento, Map<Integer, String> mappaStatoIspezione) throws ManagerException {
		log.debug("[SigitMgr::getIspezioniByIdAccertamento] BEGIN");
		ArrayList<IspezioneAccertamento> risultatoRicerca = new ArrayList<IspezioneAccertamento>();
		try {
			SigitTIspezione2018Dto ispezione = new SigitTIspezione2018Dto();
			ispezione.setFkAccertamento(ConvertUtil.convertToInteger(idAccertamento));
			List<SigitTIspezione2018Dto> elencoIspezioni = getDbMgr().cercaIspezione2018(ispezione);

			for (SigitTIspezione2018Dto sigitTIspezione2018Dto : elencoIspezioni) {
				risultatoRicerca.add(MapDto.mapToIspezioneAccertamento(sigitTIspezione2018Dto, mappaStatoIspezione));
			}

			if (log.isDebugEnabled())
				GenericUtil.stampa(elencoIspezioni, true, 3);

		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
		finally {
			log.debug("[SigitMgr::getIspezioniByIdAccertamento] END");
		}
		return risultatoRicerca;
	}

//	public ArrayList<SanzioneAccertamento> getSanzioniByIdAccertamento(String idAccertamento, Map<Integer, String> mappaStatoSanzione) throws ManagerException {
//		log.debug("[SigitMgr::getSanzioniByIdAccertamento] BEGIN");
//		ArrayList<SanzioneAccertamento> risultatoRicerca = new ArrayList<SanzioneAccertamento>();
//		try {
//			SigitTSanzioneDto sanzione = new SigitTSanzioneDto();
//			sanzione.setFkAccertamento(ConvertUtil.convertToInteger(idAccertamento));
//			List<SigitTSanzioneDto> elencoSanzioni = getDbMgr().cercaSanzione(sanzione);
//
//			for (SigitTSanzioneDto sigitTSanzioneDto : elencoSanzioni) {
//				risultatoRicerca.add(MapDto.mapToSanzioneAccertamento(sigitTSanzioneDto, mappaStatoSanzione));
//			}
//
//			GenericUtil.stampa(elencoSanzioni, true, 3);
//
//		} catch (DbManagerException e) {
//			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
//		}
//		finally {
//			log.debug("[SigitMgr::getSanzioniByIdAccertamento] END");
//		}
//		return risultatoRicerca;
//	}

	public ArrayList<Sanzione> getSanzioniByIdIspezione(String idIspezione, Map<Integer, String> mappaStatoSanzione) throws ManagerException {
		log.debug("[SigitMgr::getSanzioniByIdIspezione] BEGIN");
		SigitTSanzioneDto sanzione = new SigitTSanzioneDto();
		sanzione.setFkIspezione2018(ConvertUtil.convertToInteger(idIspezione));
		return getSanzioneDaOrigine(sanzione, mappaStatoSanzione);
	}

	public ArrayList<Sanzione> getSanzioniByIdAccertamento(String idAccertamento, Map<Integer, String> mappaStatoSanzione) throws ManagerException {
		log.debug("[SigitMgr::getSanzioniByIdAccertamento] BEGIN");
		SigitTSanzioneDto sanzione = new SigitTSanzioneDto();
		sanzione.setFkAccertamento(ConvertUtil.convertToInteger(idAccertamento));
		return getSanzioneDaOrigine(sanzione, mappaStatoSanzione);
	}

	private ArrayList<Sanzione> getSanzioneDaOrigine(SigitTSanzioneDto input, Map<Integer, String> mappaStatoSanzione) throws ManagerException {

		log.debug("[SigitMgr::getSanzioneDaOrigine] BEGIN");
		ArrayList<Sanzione> risultatoRicerca = new ArrayList<Sanzione>();
		try {
			List<SigitTSanzioneDto> elencoSanzioni = getDbMgr().cercaSanzione(input);
			for (SigitTSanzioneDto sigitTSanzioneDto : elencoSanzioni) {
				risultatoRicerca.add(MapDto.mapToSanzione(sigitTSanzioneDto, mappaStatoSanzione, null, null));
			}

			if (log.isDebugEnabled())
				GenericUtil.stampa(elencoSanzioni, true, 3);

		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
		finally {
			log.debug("[SigitMgr::getSanzioneDaOrigine] END");
		}
		return risultatoRicerca;

	}


	public Sanzione getSanzionePerDettaglioDaId(Integer idSanzione, Map<Integer, String> mappaStatoSanzione) throws ManagerException {
		log.debug("[SigitMgr::getSanzionePerDettaglioDaId] BEGIN");
		Sanzione risultato = null;
		try {
			SigitTSanzioneDto outDb = getDbMgr().cercaSanzioneDaId(idSanzione);
			SigitTPersonaFisicaDto fisica = null;
			SigitTPersonaGiuridicaDto giuridica = null;

			if (outDb != null && outDb.getFkPfSanzionata() != null) {
				fisica = getDbMgr().cercaTPersonaFisicaById(ConvertUtil.convertToInteger(outDb.getFkPfSanzionata()));
			}

			if (outDb != null && outDb.getFkPgSanzionata() != null) {
				giuridica = getDbMgr().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(outDb.getFkPgSanzionata()));
			}

			risultato = MapDto.mapToSanzione(outDb, mappaStatoSanzione, fisica, giuridica);
		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
		finally {
			log.debug("[SigitMgr::getSanzionePerDettaglioDaId] END");
		}

		return risultato;
	}



	public DatiInserimentoSanzione getSanzionePerNotificaDaId(Integer idSanzione) throws ManagerException {
		log.debug("[SigitMgr::getSanzionePerNotificaDaId] BEGIN");
		DatiInserimentoSanzione risultato = null;
		try {
			SigitTSanzioneDto outDb = getDbMgr().cercaSanzioneDaId(idSanzione);
			SigitTPersonaFisicaDto fisica = null;
			SigitTPersonaGiuridicaDto giuridica = null;
			if (outDb != null && outDb.getFkPfSanzionata() != null) {
				fisica = getDbMgr().cercaTPersonaFisicaById(ConvertUtil.convertToInteger(outDb.getFkPfSanzionata()));
			}

			if (outDb != null && outDb.getFkPgSanzionata() != null) {
				giuridica = getDbMgr().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(outDb.getFkPgSanzionata()));
			}

			risultato = MapDto.mapToDatiInserimentoSanzione(outDb, fisica, giuridica);

		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		}
		finally {
			log.debug("[SigitMgr::getSanzionePerNotificaDaId] END");
		}

		return risultato;
	}


	public ArrayList<RisultatoRicerca> getSanzioniDaRicerca(RicercaSanzioni input, Map<Integer, String> mappaStatoSanzione) throws ManagerException {
		log.debug("[SigitMgr::getSanzioniDaRicerca] BEGIN");

		ArrayList<RisultatoRicerca> risultatoRicerca = new ArrayList<RisultatoRicerca>();

		try {
			List<SigitTSanzioneDto> elencoSanzioni = getDbMgr().getElencoSanzioniByFilter(RicercaSanzioniFilter.getByRicercaSanzioni(input));

			if (elencoSanzioni != null) {
				for (SigitTSanzioneDto sigitTSanzioneDto : elencoSanzioni) {
					RisultatoRicerca risultato = MapDto.mapToRisultatoRicercaSanzione(sigitTSanzioneDto, mappaStatoSanzione);
					if (sigitTSanzioneDto.getFkPfSanzionata() != null) {
						SigitTPersonaFisicaDto pf = getDbMgr().getSigitTPersonaFisicaDao().findByPrimaryKey(new SigitTPersonaFisicaPk(sigitTSanzioneDto.getFkPfSanzionata()));
						risultato.setSanzionato(pf.getCodiceFiscale());
					}

					if (sigitTSanzioneDto.getFkPgSanzionata() != null) {
						SigitTPersonaGiuridicaDto pg = getDbMgr().getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(sigitTSanzioneDto.getFkPgSanzionata()));
						risultato.setSanzionato(pg.getCodiceFiscale());
					}

					risultatoRicerca.add(risultato);
				}
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::getSanzioniDaRicerca] END");
		}
		return risultatoRicerca;
	}




	@Transactional
	public String salvaAccertamento(Accertamento accertamento, Map<String, String> mappaTipoAnomalieVerifica, UtenteLoggato utente) throws ManagerException {
		log.debug("[SigitMgr::salvaAccertamento] BEGIN");
		String idAccertamento = null;
		try
		{
			SigitTAccertamentoDto dto = null;
			if (GenericUtil.isNotNullOrEmpty(accertamento.getIdentificativo()))
			{
				dto = getDbVerificaMgr().getAccertamentoById(ConvertUtil.convertToInteger(accertamento.getIdentificativo()));

				if (accertamento.getIdTipoAnomalia() != null && ConvertUtil.convertToBigInteger(accertamento.getIdTipoAnomalia()).intValue() != dto.getFkTipoAnomalia().intValue())
				{
					StringBuffer sbDescr = new StringBuffer("Variazione Tipo anomalia ");

					if (mappaTipoAnomalieVerifica != null)
					{
						if (GenericUtil.isNotNullOrEmpty(dto.getFkTipoAnomalia()) && dto.getFkTipoAnomalia() != Constants.DATO_NON_DISPONIBILE)
						{
							sbDescr.append(" da " + mappaTipoAnomalieVerifica.get(ConvertUtil.convertToString(dto.getFkTipoAnomalia())));
						}

						sbDescr.append(" a " + mappaTipoAnomalieVerifica.get(accertamento.getIdTipoAnomalia()));
					}

					getDbAzioneMgr().inserisciAzioneSimply(sbDescr.toString(), Constants.ID_TIPO_AZIONE_ACCERTAMENTO, utente, ConvertUtil.convertToInteger(accertamento.getIdentificativo()));

				}
			}
			else
			{
				dto = new SigitTAccertamentoDto();
			}
			SigitTAccertamentoDto accertamentoDto = MapDto.mapToSigitTAccertamentoDto(accertamento, dto, utente);
			if(accertamentoDto.getSiglaProvCompetenza()==null){
					if(accertamentoDto.getIstatProvCompetenza()!=null) {
						Provincia provincia = getServiziMgr().getProvinciaDaCodiceIstatOrSigla(accertamentoDto.getIstatProvCompetenza());
						String siglaProv = provincia.getSigla().toUpperCase();
						accertamentoDto.setSiglaProvCompetenza(ReplaceSpecialCharUtils.sanitize(siglaProv));
					}
			}

			SigitTAccertamentoPk pk = getDbVerificaMgr().salvaAccertamento(accertamentoDto);
			accertamento.setIdentificativo(ConvertUtil.convertToString(pk.getIdAccertamento()));
			idAccertamento = accertamento.getIdentificativo();
		} catch (DbManagerException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		} catch (ServiceException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		} finally {
			log.debug("[SigitMgr::salvaAccertamento] END");
		}
		return idAccertamento;
	}


	// METODI DI PROVA TRANSAZIONALITA'
	public void provaInviaAllegatoTrans()throws ManagerException {
		log.debug("[SigitMgr::provaInviaAllegatoTrans] START");
		try {

			log.debug("PRIMA di provaPrimoMetodoTrans()");

			provaPrimoMetodoTrans();

			log.debug("DOPO di provaPrimoMetodoTrans");

			log.debug("PRIMA di provaSecondoMetodoTrans");

			provaSecondoMetodoTrans();

			log.debug("DOPO di provaSecondoMetodoTrans");

		}
		catch (ManagerException e) {

			log.debug("#### SONO NELLA GESTIONE ECCEZIONE #### ");
			log.error(e.getCause(), e);

			throw e;
		}
		log.debug("[SigitMgr::provaInviaAllegatoTrans] END");
	}

	@Transactional
	public void provaPrimoMetodoTrans()throws ManagerException {
		log.debug("[SigitMgr::provaPrimoMetodoTrans] START");
		try {

//			 BEPPE - DA TOGLIERE - SERVE X SIMULARE TRANSAZIONALITA
			if (false)
				throw new ServiceException("PROVA BEPPE - provaPrimoMetodoTrans");

		} catch (ServiceException e) {
            log.debug("@@@@@@@@ ENTRO Exception @@@@@@@@");
			try
            {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
            catch (Exception x)
            {
                log.debug("####### ENTRO Exception ROLLBACK #######");
                log.error(x);
                log.debug("####### ESCO Exception ROLLBACK #######");

            }
            log.debug("@@@@@@@@ DOPO ROLLBACK @@@@@@@@");

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}

		log.debug("[SigitMgr::provaPrimoMetodoTrans] END");
	}

	@Transactional
	public void provaSecondoMetodoTrans()throws ManagerException {
		log.debug("[SigitMgr::provaSecondoMetodoTrans] START");
		try {

//			 BEPPE - DA TOGLIERE - SERVE X SIMULARE TRANSAZIONALITA
			if (true)
				throw new ServiceException("PROVA BEPPE - provaSecondoMetodoTrans");

		} catch (ServiceException e) {
            log.debug("@@@@@@@@ ENTRO Exception @@@@@@@@");
			try
            {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
            catch (Exception x)
            {
                log.debug("####### ENTRO Exception ROLLBACK #######");
                log.error(x);
                log.debug("####### ESCO Exception ROLLBACK #######");

            }
            log.debug("@@@@@@@@ DOPO ROLLBACK @@@@@@@@");

            throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}

		log.debug("[SigitMgr::provaSecondoMetodoTrans] END");
	}

	protected ConnectorMgr sigitMgrTrans;

	public ConnectorMgr getSigitMgrTrans() {
		return sigitMgrTrans;
	}

	public void setSigitMgrTrans(ConnectorMgr sigitMgrTrans) {
		this.sigitMgrTrans = sigitMgrTrans;
	}


	public ArrayList<Integer> costruisciListaAutodichiarazioniContratto(String tipoAutodichiarazione, Integer idContratto)
			throws DbManagerException {
		log.debug("[SigitMgr::costruisciListaAutodichiarazioniContratto] START");

		ArrayList<Integer> elencoIdSelezionati = new ArrayList<Integer>();
		if (idContratto != null) {
			List<SigitRContr2019AutodichiarDto> autodichiarazioniContratto = getDbMgr()
					.cercaListaAutodichiarazioniContratto(
							idContratto, null, tipoAutodichiarazione);
			if (autodichiarazioniContratto != null) {
				for (SigitRContr2019AutodichiarDto autod : autodichiarazioniContratto) {
					elencoIdSelezionati.add(autod.getIdAutodichiarazione());
				}
			}
		}
		return elencoIdSelezionati;
	}

	/*
	public Integer contaContratti2019ByFilter(String codiceImpianto, String dataInizio, String dataFine) throws ManagerException {
		log.debug("[SigitMgr::contaContratti2019ByFilter] START");

		Integer conta = 0;

		try {
			ContrattoFilter filter = new ContrattoFilter();
			filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
			filter.setDataDal(ConvertUtil.convertToDate(dataInizio));
			filter.setDataAl(ConvertUtil.convertToDate(dataFine));

			List<SigitTContratto2019Dto> listaContratti = getDbMgr().getSigitTContratto2019Dao().findByFilter(filter);
			if (listaContratti != null) {
				conta = listaContratti.size();
			}
		} catch (SigitTContratto2019DaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} catch (Exception e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} finally {
			log.debug("[SigitMgr::contaContratti2019ByFilter] END");
		}

		return conta;


	}
	*/


	public SigitVRicerca3ResponsabileByFkPgPfRowDto contaContratti2019ByFilter(boolean isTacitoRinnovo, String codiceImpianto, String dataInizio, String dataFine, Integer idContratto) throws ManagerException {
		log.debug("[SigitMgr::contaContratti2019ByFilter] START");

		SigitVRicerca3ResponsabileByFkPgPfRowDto terzoRespAttivo = null;

		try {
			if (isTacitoRinnovo) {
				terzoRespAttivo = getDbMgr().cerca3ResponsabileByPfPgDataFine(null,
						codiceImpianto, false, dataInizio,
						null, idContratto);

			} else {
				terzoRespAttivo = getDbMgr().cerca3ResponsabileByPfPgDataFine(null,
						codiceImpianto, false, dataInizio,
						dataFine, idContratto);

			}

		} catch (Exception e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} finally {
			log.debug("[SigitMgr::contaContratti2019ByFilter] END");
		}

		return terzoRespAttivo;


	}

	//sezione dedicata alle ispezioni
	public Ispezione2018 inserisciIspezione(Ispezione2018 input) throws ManagerException {

		try {
			SigitTIspezione2018Pk pk = getDbIspezioneMgr().inserisciIspezione2018(input);

			input.setIdentificativoIspezione(ConvertUtil.convertToString(pk.getIdIspezione2018()));

			return input;

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}


	}

	public void modificaIspezioneDaDettaglio(Ispezione2018 input, UtenteLoggato utente) throws ManagerException {
		//Integer idIspezione = ConvertUtil.convertToInteger(input.getIdentificativoIspezione());
		try {
			//SigitTIspezione2018Dto ispezioneOld = getDbIspezioneMgr().caricaIspezioneDaId(idIspezione);
			//si verifica se produrre l'azione di cambiamento supervisore
			//boolean modificaIspettore = !StringUtils.equals(input.getCfSecondoIspettore(), ispezioneOld.getCfIspettoreSecondario());

			getDbIspezioneMgr().modificaIspezioneDaDettaglio(input);
			//eliminato creazione azione automatica
//			boolean primaAssegnazione = false;
//
//			if (modificaIspettore) {
//
//				PersonaFisica ispettoreOld = null;
//				PersonaFisica ispettoreNew = null;
//
//				//viene recuperata la pf associata al cf
//				if (!GenericUtil.isNullOrEmpty(ispezioneOld.getCfIspettoreSecondario())) {
//					//non si tratta di una prima ispezione. puo' essere ricercata la persona fisica
//					ispettoreOld = getDbMgr().cercaPersonaFisicaByCF(ispezioneOld.getCfIspettoreSecondario());
//					primaAssegnazione = true;
//				}
//
//				ispettoreNew = getDbMgr().cercaPersonaFisicaByCF(input.getCfSecondoIspettore());
//				String descrizioneIspettoreNew = ConvertUtil.getStringByConcat(" ", ispettoreNew.getNome(), ispettoreNew.getCognome(), ispettoreNew.getCodiceFiscale());
//				String descrizioneAzione = null;
//				if (primaAssegnazione) {
//					descrizioneAzione = "Variazione utente assegnatario a " + descrizioneIspettoreNew;
//				} else {
//					descrizioneAzione = "Variazione secondo ispettore da " +  ConvertUtil.getStringByConcat(" ", ispettoreOld.getNome(), ispettoreOld.getCognome(), ispettoreOld.getCodiceFiscale())
//					+ " a " + descrizioneIspettoreNew;
//				}
//
//
//				getDbAzioneMgr().inserisciAzioneSimply(descrizioneAzione, Constants.ID_TIPO_AZIONE_ISPEZIONE, utente, idIspezione);
//			}


		} catch (DbManagerException e) {

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}

	}

	public Ispezione2018 caricaIspezioneDaId(String idIspezione, boolean caricaImpianto, boolean caricaIspettore) throws ManagerException {
		log.debug("[SigitMgr::caricaIspezioneDaId] START");
		try {
			SigitTIspezione2018Dto ispezioneDb = getDbIspezioneMgr().caricaIspezioneDaId(ConvertUtil.convertToInteger(idIspezione));
			SigitVTotImpiantoCercaUbicazioneImpiantoDto datiImpianto = null;
			//SigitRImpRuoloPfpgGenericPfByFilterDto ispettore = null;
			SigitTPersonaFisicaDto ispettore = null;
			SigitRIspezIspetDto ispezIspet = null;
			Map<Integer, String> mappaStatoIspezione = null;
			SigitTDatoDistribDto datoDistrib = null;
			String indirizzoDatoDistrib = null;
			String datoDistributoreAnnoRiferimentoDatiUtente = null;
			Ispezione2018 output = null;

			ArrayList<IdDescription> idDescription = getElencoStatiISpezione();
			if (idDescription != null) {
				mappaStatoIspezione = new HashMap<Integer, String>();
				for(IdDescription element : idDescription) {
					mappaStatoIspezione.put(element.getId(), element.getDescription());
				}
			}

			if (ispezioneDb != null) {
				//se devono essere caricate le info aggiuntive dell'impianto (la localizzazione)
				if (ispezioneDb.getCodiceImpianto() != null && ispezioneDb.getCodiceImpianto().intValue() != 0 && caricaImpianto) {
					datiImpianto =  getDbMgr().cercaUbicazioneImpianto(ConvertUtil.convertToInteger(ispezioneDb.getCodiceImpianto()));
				}

				if ((ispezioneDb.getCodiceImpianto() == null || ispezioneDb.getCodiceImpianto().intValue() == 0)
						&& ispezioneDb.getFkVerifica() != null) {
					SigitTVerificaDto verifica = null;
					if(ispezioneDb.getFkVerifica()!=0)
						verifica = getDbVerificaMgr().getVerificaById(ispezioneDb.getFkVerifica());
					else {
						SigitTAccertamentoDto acc = getDbMgr().getSigitTAccertamentoDao().findByPrimaryKey(new SigitTAccertamentoPk(ispezioneDb.getFkAccertamento()));
						if (acc != null) {
							verifica = getDbVerificaMgr().getVerificaById(acc.getFkVerifica());
						}
					}
					if (verifica != null) {
						datoDistrib = getDbMgr().cercaDatoDistributore(verifica.getFkDatoDistrib());

						indirizzoDatoDistrib = getIndirizzoCompletoByIstatComuneIndirizzoCivico(datoDistrib.getIstatComune(), datoDistrib.getDug(), datoDistrib.getIndirizzo(), datoDistrib
								.getCivico());

						datoDistributoreAnnoRiferimentoDatiUtente = MapDto.getdatoDistributoreAnnoRiferimentoDatiUtente(datoDistrib);
					}
				}


//				BEPPE
//				questo non esiste pi�, devio fare una query su sigit_t_ispez_ispet prendendo quello con data inizio pi� recente
//				where id_ispezione_2018 = ispezione attuale
				//se devono essere caricate le info dell'ispettore
				ispezIspet = getDbMgr().cercaUltimoRIspezIspetByIdIspezione(idIspezione);

				if (ispezIspet != null)
				{
					// Cerco la persona fisica ispettore
					ispettore = getDbMgr().cercaTPersonaFisicaById(ConvertUtil.convertToInteger(ispezIspet.getFkPersonaFisica()));

				}

				/*
				if (ispezioneDb.getFkImpRuoloPfpgIspettore() != null && caricaIspettore) {
					RicercaImpiantiSoggettoFilter ricercaIspettore = new RicercaImpiantiSoggettoFilter();
					ricercaIspettore.setIdImpRuoloPfpg(ispezioneDb.getFkImpRuoloPfpgIspettore());

					List<SigitRImpRuoloPfpgGenericPfByFilterDto> ispettori = getDbMgr().getSigitRImpRuoloPfpgDao().findGenericPfByFilter(ricercaIspettore);
					if (ispettori != null) {
						ispettore = ispettori.get(0);
					}
				}
				output = MapDto.mapToIspezione2018(ispezioneDb, mappaStatoIspezione, datiImpianto, ispettore);
				*/

				output = MapDto.mapToIspezione2018(ispezioneDb, mappaStatoIspezione, datiImpianto, ispezIspet, ispettore, datoDistrib, indirizzoDatoDistrib, datoDistributoreAnnoRiferimentoDatiUtente);

			}

			return output;

		} catch (Exception e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} finally {
			log.debug("[SigitMgr::caricaIspezioneDaId] END");
		}

	}

	//sezione dedicata alle ispezioni
	public SigitTRappIspezGtDto cercaRappIspezioneGtByIdIspez(BigDecimal idIspezione) throws ManagerException {

		try {
			return getDbIspezioneMgr().getSigitTRappIspezioneGt(idIspezione);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}


	public List<SigitTDettIspezGtDto> cercaDettIspezioneListGtByIdIspez(BigDecimal idIspezione, BigDecimal progressivo) throws ManagerException {

		try {
			return getDbIspezioneMgr().getSigitTDettIspezioneGtList(idIspezione, progressivo);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	public SigitTRappIspezGfDto cercaRappIspezioneGfByIdIspez(BigDecimal idIspezione) throws ManagerException {

		try {
			return getDbIspezioneMgr().getSigitTRappIspezioneGf(idIspezione);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	public List<SigitTDettIspezGfDto> cercaDettIspezioneListGfByIdIspez(BigDecimal idIspezione, BigDecimal progressivo) throws ManagerException {

		try {
			return getDbIspezioneMgr().getSigitTDettIspezioneGfList(idIspezione, progressivo);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}



	public DatiGTCommon cercaDatiAllegato1Common(DettaglioAllegato ispezione) throws ManagerException {

		try {

			DettaglioAllegato dettAllegato = new DettaglioAllegato();

			dettAllegato.setIdAllegato(ispezione.getIdAllegato());
			dettAllegato.setCodiceImpianto(ispezione.getCodiceImpianto());
			dettAllegato.setDataControllo(ispezione.getDataControllo());

			return getDbMgr()
					.getDettaglioAllegato1Common(dettAllegato);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	public DatiGFCommon cercaDatiAllegato2Common(DettaglioAllegato ispezione) throws ManagerException {

		try {

			DettaglioAllegato dettAllegato = new DettaglioAllegato();

			dettAllegato.setIdAllegato(ispezione.getIdAllegato());
			dettAllegato.setCodiceImpianto(ispezione.getCodiceImpianto());
			dettAllegato.setDataControllo(ispezione.getDataControllo());

			return getDbMgr()
					.getDettaglioAllegato2Common(dettAllegato);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	public DatiSCCommon cercaDatiAllegato3Common(DettaglioAllegato ispezione) throws ManagerException {

		try {

			DettaglioAllegato dettAllegato = new DettaglioAllegato();

			dettAllegato.setIdAllegato(ispezione.getIdAllegato());
			dettAllegato.setCodiceImpianto(ispezione.getCodiceImpianto());
			dettAllegato.setDataControllo(ispezione.getDataControllo());

			return getDbMgr()
					.getDettaglioAllegato3Common(dettAllegato);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	public DatiCGCommon cercaDatiAllegato4Common(DettaglioAllegato ispezione) throws ManagerException {

		try {

			DettaglioAllegato dettAllegato = new DettaglioAllegato();

			dettAllegato.setIdAllegato(ispezione.getIdAllegato());
			dettAllegato.setCodiceImpianto(ispezione.getCodiceImpianto());
			dettAllegato.setDataControllo(ispezione.getDataControllo());

			return getDbMgr()
					.getDettaglioAllegato4Common(dettAllegato);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}


	public List<String> recuperaApparecchiatureDaAllegato (Integer idAllegato, String tipoComponente) throws ManagerException {
		try {
			List<String> apparecchiatureFunz = new ArrayList<String>();
			List<Object> listaAllegatiRelazionati = getDbMgr().cercaListaRAllegatiComById(idAllegato, tipoComponente);


			if (listaAllegatiRelazionati != null) {
				for (Object obj : listaAllegatiRelazionati) {
					if (Constants.TIPO_COMPONENTE_GT.equals(tipoComponente)) {
						SigitRAllegatoCompGtDto allegato = (SigitRAllegatoCompGtDto) obj;
						apparecchiatureFunz.add(ConvertUtil.convertToString(allegato.getProgressivo()));
					} else if (Constants.TIPO_COMPONENTE_SC.equals(tipoComponente)) {
						SigitRAllegatoCompScDto allegato = (SigitRAllegatoCompScDto) obj;
						apparecchiatureFunz.add(ConvertUtil.convertToString(allegato.getProgressivo()));
					} else if (Constants.TIPO_COMPONENTE_CG.equals(tipoComponente)) {
						SigitRAllegatoCompCgDto allegato = (SigitRAllegatoCompCgDto) obj;
						apparecchiatureFunz.add(ConvertUtil.convertToString(allegato.getProgressivo()));
					} else if (Constants.TIPO_COMPONENTE_GF.equals(tipoComponente)) {
						SigitRAllegatoCompGfDto allegato = (SigitRAllegatoCompGfDto) obj;
						apparecchiatureFunz.add(ConvertUtil.convertToString(allegato.getProgressivo()));
					}
				}
			}

			return apparecchiatureFunz;
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}


	/*
	public SigitTAllegatoDto cercaAllegatoById(Integer idAllegato) throws ManagerException {

		try {
			return getDbMgr()
					.cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(idAllegato));

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	public List<SigitVSk4GtDto> cercaAllegatoCompGtById(Integer idAllegato) throws ManagerException {

		try {
			return getDbMgr()
					.getCompGtByIdAllegato(idAllegato);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}
	*/

	public void salvaSanzioneDaDettaglio (Sanzione sanzione) throws ManagerException {
		log.debug("[SigitMgr::salvaSanzioneDaDettaglio] BEGIN");
		try {
			SigitTSanzioneDto sanzioneExample = new SigitTSanzioneDto();
			sanzioneExample.setIdSanzione(sanzione.getIdSanzione());
			sanzioneExample.setNote(ReplaceSpecialCharUtils.sanitize(sanzione.getNote()));

			getDbMgr().getSigitTSanzioneDao().updateColumnsNote(sanzioneExample);
		} catch (SigitTSanzioneDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}finally {
			log.debug("[SigitMgr::salvaSanzioneDaDettaglio] END");
		}
	}


	@Transactional
	public Integer inserisciSanzioneTrans(DatiInserimentoSanzione sanzione, UtenteLoggato utente) throws DbManagerException {
		log.debug("[SigitMgr::inserisciSanzioneTrans] BEGIN");
		try {
			//viene prima inserita la persona fisica/giuridica
			sanzione = getDbMgr().inserisciModificaSanzionato(sanzione, utente.getCodiceFiscale());
			sanzione.setDataCreazione(DateUtil.getDataCorrenteFormat());
			//la sanzione viene impiegata per inserire i dati nel db
			SigitTSanzionePk idSanzione = getDbMgr().getSigitTSanzioneDao().insert(MapDto.mapToSigitTSanzioneDTO(sanzione, Constants.ID_STATO_SANZIONE_BOZZA));

			// Nel caso in cui il RUOLO sia VALIDATORE o ISPETTORE, bisogna aggiungere anche un record nelle AZIONI per ricordare chi ha creato la sanzione
			if (GenericUtil.checkValidRole(utente, Arrays.asList(Constants.RUOLO_VALIDATORE, Constants.RUOLO_ISPETTORE), true, true)) {
				getDbAzioneMgr().inserisciAzioneSimply("Creazione sanzione", Constants.ID_TIPO_AZIONE_SANZIONE, utente, idSanzione.getIdSanzione());
			}

			return idSanzione.getIdSanzione();
		}
		catch(DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
		finally {
			log.debug("[SigitMgr::inserisciSanzioneTrans] END");
		}
	}


	@Transactional
	public void pagaSanzioneTrans(String dataPagamento, Integer idSanzione, UtenteLoggato utente) throws DbManagerException {
		log.debug("[SigitMgr::pagaSanzioneTrans] BEGIN");
		try {
			//viene salvata la modifica del pagamento
			getDbMgr().pagaSanzione(dataPagamento, idSanzione);

			//viene creata quindi l'azione di pagamento
			String descrizioneAzione = "Pagamento sanzione il " + dataPagamento;
			getDbAzioneMgr().inserisciAzioneSimply(descrizioneAzione, Constants.ID_TIPO_AZIONE_SANZIONE, utente, idSanzione);

		} catch(DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		} finally {
			log.debug("[SigitMgr::pagaSanzioneTrans] END");
		}
	}


	@Transactional
	public String annullaSanzioneTrans(boolean validatore,  Sanzione sanzione, UtenteLoggato utente) throws ManagerException {
		log.debug("[SigitMgr::annullaSanzioneTrans] BEGIN");
		StringBuilder sbEmail = new StringBuilder();

		try {
			//si procede all'annullamento della sanzione
			String mailResponsabile = getDbMgr().annullaSanzione(sanzione);

			//viene creata l'azione di annullamento
			String descAzione = "Sanzione annullata da " + ConvertUtil.getStringByConcat(" ", utente.getDenominazione(), utente.getCodiceFiscale());
			getDbAzioneMgr().inserisciAzioneSimply(descAzione, Constants.ID_TIPO_AZIONE_SANZIONE, utente, sanzione.getIdSanzione());

			//viene preparata la mail da inviare al responsabile della sanzione
			if (!GenericUtil.isNullOrEmpty(mailResponsabile)) {
				//viene inviata la mail

				log.debug("SigitMgr::annullaSanzioneTrans: fase invio mail START");
				log.debug("destinatario: " + mailResponsabile);
				try {
					String oggetto = "CIT - notifica annullamento sanzione " + sanzione.getIdSanzione();
					StringBuffer testoHtml = new StringBuffer();

					testoHtml.append(" La sanzione in oggetto e' stata annullata");
					log.debug("TESTO: \n"+testoHtml);
					log.debug("annullaSanzioneTrans: STOP");
					ResultInvioMail resultInvioMail = getServiziMgr().sendMail(mailResponsabile, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));

					sbEmail.append("<BR>");
					String destinazioneMail = validatore? "al validatore" : "all'ispettore";

					if (resultInvioMail.isPresentsOK())
					{
						sbEmail.append("E' stata inviata una mail " + destinazioneMail + " ("+mailResponsabile+") ");
					}
					else if (resultInvioMail.isPresentsKO())
					{
						sbEmail.append("<font color=\"red\">Non e' stata inviata una mail " + destinazioneMail + " ("+mailResponsabile+"), verificare l'indirizzo mail </font>");
					}
				} catch (ServiceException e) {
					log.error("Errore invio email associa a...", e);
					throw new ManagerException(e, new Message(e.getMessage()));
				}

			}

		} catch (DbManagerException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_INVIO_MAIL));
		}
		finally {
			log.debug("[SigitMgr::annullaSanzioneTrans] END");
		}

		return sbEmail.toString();

	}



	@Transactional
	public String associaSanzioneTrans(boolean validatore, Sanzione sanzione, UtenteLoggato utente) throws ManagerException {
		log.debug("[SigitMgr::associaSanzioneTrans] BEGIN");
		StringBuilder sbEmail = new StringBuilder();

		try {

			Integer idResponsabileNew = validatore ? sanzione.getIdValidatoreScelto() : sanzione.getIdIspettoreScelto();

			PersonaFisica pfResponsabileNew =  getDbMgr().cercaPersonaFisicaById(idResponsabileNew);

			//String descrizioneResponsabileNew = getDbMgr().cercaTPersonaFisicaById((idPersonaGiuridica)mappaValidatoriIstruttori.get(cfResponsabileNew);

			String emailDestinatario = getDbMgr().associaSanzione(validatore, sanzione, pfResponsabileNew, utente);

			if (emailDestinatario != null) {
				log.debug("SigitMgr::associaSanzioneTrans: fase invio mail START");
				log.debug("destinatario: " + emailDestinatario);
				try {
					String oggetto = "CIT - notifica assegnazione sanzione " + sanzione.getIdSanzione();
					StringBuffer testoHtml = new StringBuffer();

					testoHtml.append("L'utente " + utente.getDenominazione() + " " + utente.getCodiceFiscale());
					testoHtml.append(" Le ha assegnato la sanzione "+sanzione.getIdSanzione());
					log.debug("TESTO: \n"+testoHtml);
					log.debug("inviaMailAssociaA: STOP");
					ResultInvioMail resultInvioMail = getServiziMgr().sendMail(emailDestinatario, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));

					sbEmail.append("<BR>");
					String destinazioneMail = validatore? "al validatore" : "all'ispettore";

					if (resultInvioMail.isPresentsOK())
					{
						sbEmail.append("E' stata inviata una mail " + destinazioneMail + " ("+emailDestinatario+") ");
					}
					else if (resultInvioMail.isPresentsKO())
					{
						sbEmail.append("<font color=\"red\">Non e' stata inviata una mail " + destinazioneMail + " ("+emailDestinatario+"), verificare l'indirizzo mail </font>");
					}
				} catch (ServiceException e) {
					log.error("Errore invio email associa a...", e);
					throw new ManagerException(e, new Message(e.getMessage()));
				}
			} else {
				sbEmail.append("<font color=\"red\">Non e' stata apportata alcuna variazione del responsabile, verificare il dato inserito </font>");
			}


		} catch (DbManagerException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, e.getMsg() == null ? new Message(Messages.ERROR_RECUPERO_DB) : e.getMsg());
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_INVIO_MAIL));
		}
		finally {
			log.debug("[SigitMgr::associaSanzione] END");
		}

		return sbEmail.toString();
	}



	@Transactional
	public void notificaSanzioneTrans(DatiInserimentoSanzione sanzione, UtenteLoggato utente) throws DbManagerException {
		log.debug("[SigitMgr::notificaSanzioneTrans] BEGIN");
		try {
			//viene prima inserita la persona fisica/giuridica
			sanzione = getDbMgr().inserisciModificaSanzionato(sanzione, utente.getCodiceFiscale());

			//vengono eseguite le update sull'oggetto sanzione
			SigitTSanzioneDto entityToUpdate = MapDto.mapToSigitTSanzioneDTO(sanzione, Constants.ID_STATO_SANZIONE_COMUNICATA);
			entityToUpdate.setDtComunicazione(DateUtil.getSqlCurrentDate());

			getDbMgr().getSigitTSanzioneDao().update(entityToUpdate);

			SigitTPersonaFisicaDto sanzionatoFisico = null;
			//viene creata l'azione
			if(sanzione.getIdSanzionatoFisico() != null && sanzione.getIdSanzionatoFisico() != 0) {
				sanzionatoFisico = getDbMgr().cercaTPersonaFisicaById(sanzione.getIdSanzionatoFisico());
			}

			SigitTPersonaGiuridicaDto sanzionatoGiuridico = null;
			if (sanzione.getIdSanzionatoGiuridico() != null && sanzione.getIdSanzionatoGiuridico() != 0) {
				sanzionatoGiuridico = getDbMgr().cercaTPersonaGiuridicaById(sanzione.getIdSanzionatoGiuridico());
			}

			String infoSanzionato = MapDto.creaInfoSanzionato(sanzionatoFisico, sanzionatoGiuridico);

			String descrizioneAzione = "Notifica sanzione a " + infoSanzionato;
			getDbAzioneMgr().inserisciAzioneSimply(descrizioneAzione, Constants.ID_TIPO_AZIONE_SANZIONE, utente, sanzione.getIdSanzione());


		} catch(DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		} catch (SigitTSanzioneDaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::notificaSanzioneTrans] END");
		}
	}


	public ArrayList<Abilitazione> getElencoAbilitazioniByFilter(Abilitazione filterAbil) throws ManagerException {
		try {

			 ArrayList<Abilitazione> listAbilitazioni = null;

			SigitRPfRuoloPaDto filter = new SigitRPfRuoloPaDto();
			if (filterAbil != null)
			{
				if (GenericUtil.isNotNullOrEmpty(filterAbil.getIdRuoloPa()))
				{
					filter.setIdRuoloPa(filterAbil.getIdRuoloPa());
				}

				if (GenericUtil.isNotNullOrEmpty(filterAbil.getIdPersonaFisica()))
				{
					filter.setIdPersonaFisica(ConvertUtil.convertToBigDecimal(filterAbil.getIdPersonaFisica()));
				}

				if (GenericUtil.isNotNullOrEmpty(filterAbil.getIstatAbilitazione()))
				{
					filter.setIstatAbilitazione(ReplaceSpecialCharUtils.sanitize(filterAbil.getIstatAbilitazione()));
				}
			}

			List<SigitRPfRuoloPaByExampleDto> elencoAbilitazioni = getDbMgr()
					.getElencoAbilitazioniByFilter(filter);

			if (elencoAbilitazioni != null && elencoAbilitazioni.size() > 0)
			{
				listAbilitazioni = MapDto.mapToListaAbilitazioni(elencoAbilitazioni);
			}

			return listAbilitazioni;

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	public void cessaAbilitazione(Abilitazione abilitazione) throws ManagerException {

		try {

			SigitRPfRuoloPaDto ruoloPa = MapDto.mapToSigitRPfRuoloPaDto(abilitazione);

			ruoloPa.setDataFine(DateUtil.getSqlCurrentDate());

			getDbMgr()
					.cessaAbilitazione(ruoloPa);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	public void cessaProprietario(Proprietario proprietario, UtenteLoggato utente) throws ManagerException {

		try {

			getDbMgr()
					.cessaProprietario(proprietario, utente.getCodiceFiscale());

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	public void aggiornaMailAbilitazione(Abilitazione abilitazione, String newMail) throws ManagerException {

		try {

			SigitTAbilitazioneDto abilitazioneDto = MapDto.mapToSigitTAbilitazioneDto(abilitazione);
			abilitazioneDto.setMailComunicazione(newMail);

			getDbMgr()
					.aggiornaMailAbilitazione(abilitazioneDto);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	public void salvaAbilitazione(Abilitazione abilitazione) throws ManagerException {

		try {

			SigitRPfRuoloPaDto ruoloPa = MapDto.mapToSigitRPfRuoloPaDto(abilitazione);
			ruoloPa.setDataInizio(DateUtil.getSqlCurrentDate());

			SigitTAbilitazioneDto abilitazioneDto = MapDto.mapToSigitTAbilitazioneDto(abilitazione);

			getDbMgr()
					.salvaAbilitazione(ruoloPa, abilitazioneDto);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	public ArrayList<CodeDescription> getElencoUtentiPa() throws ManagerException {
		log.debug("[SigitMgr::getElencoUtentiPa] BEGIN");
		ArrayList<CodeDescription> utList = new ArrayList<CodeDescription>();
		try
		{
			List<SigitTPersonaFisicaDaRuoloPADto> elencoUtentiPa = getDbVerificaMgr().getElencoPfDaRuolo(null, false);
			if (elencoUtentiPa != null && elencoUtentiPa.size() > 0)
			{
				utList = MapDto.mapToPFtoRuolo(elencoUtentiPa, false);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::getElencoUtentiPa] END");
		}

		return utList;
	}

	public ArrayList<CodeDescription> getElencoUtentiPaByCf(String cf) throws ManagerException {
		log.debug("[SigitMgr::getElencoUtentiPaByCf] BEGIN");
		ArrayList<CodeDescription> utList = new ArrayList<CodeDescription>();
		try
		{
			PersonaFisica pf = cercaPersonaFisicaByCF(cf);

			if (pf != null)
			{
				CodeDescription cd = new CodeDescription();
				cd.setCode(ConvertUtil.convertToString(pf.getIdPersonaFisica()));
				cd.setDescription(ConvertUtil.getStringByConcat(" ", pf.getCognome(), pf.getNome(), pf.getCodiceFiscale()));
				utList.add(cd);
			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::getElencoUtentiPaByCf] END");
		}

		return utList;
	}

	@Transactional
	public void archiviaLogStorico(SigitWrkLogDto wrkLog) throws ManagerException {

		try {

			getDbMgr().salvaLogStorico(MapDto.mapToSigitWrkLogPrecDto(wrkLog));

			getDbMgr().eliminaWrkLogById(wrkLog.getIdLog());

		}
		catch (DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}

	}

	@Transactional
	public void eliminaLibrettoStorico(SigitSLibrettoDto libretto) throws ManagerException {

		try {

			getDbMgr().eliminaSLibrettoById(libretto.getIdLibretto());

			// Non dovrebbe mai succedere, ma nel caso non mi blocco
			if (GenericUtil.isNotNullOrEmpty(libretto.getUidIndex()))
			{
				getServiziMgr().indexDeleteContentByUid(libretto.getUidIndex());
			}
		}
		catch (DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		catch (ServiceException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	@Transactional
	public void archiviaLibrettoStorico(SigitTLibrettoDto libretto) throws ManagerException {

		try {

			getDbMgr().salvaLibrettoStorico(MapDto.mapToSigitSLibrettoDto(libretto));

			getDbMgr().eliminaTLibrettoTxtById(libretto.getIdLibretto());

			getDbMgr().eliminaTLibrettoById(libretto.getIdLibretto());


		}
		catch (DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}

	}

	@Transactional
	public void archiviaLogAccessoStorico(SigitLAccessoDto logAccesso) throws ManagerException {

		try {

			getDbMgr().salvaLogAccessoStorico(MapDto.mapToSigitSAccessoDto(logAccesso));

			getDbMgr().eliminaLogAccessoByPk(logAccesso.getDtAccesso(), logAccesso.getCodiceFiscale());

		}
		catch (DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}

	}

	public ArrayList<IdDescription> cercaPersonaGiuridica(PersonaGiuridica pg, boolean flgIsAttivi) throws ManagerException {
		log.debug("[SigitMgr::cercaPersonaGiuridica] BEGIN");
		PersonaGiuridica obj = null;

		ArrayList<IdDescription> dtoList = new ArrayList<IdDescription>();

		try {

			List<SigitTPersonaGiuridicaDto> dtoPgList = getDbMgr().cercaPersonaGiuridica(pg, flgIsAttivi);

			if (dtoPgList != null && dtoPgList.size() > 0)
			{
				dtoList = MapDto.mapToImpresa(dtoPgList);
			}
		}
		finally {
			log.debug("[SigitMgr::cercaPersonaGiuridica] END");
		}
		return dtoList;
	}

	@Transactional
	public int effettuaSubentroMassivo(Integer idPgAttuale, Integer idPgSubentro, Integer idTipoSubentro, String cfUtenteLoggato) throws ManagerException {
		log.debug("[SigitMgr::effettuaSubentroMassivo] BEGIN");
		PersonaGiuridica obj = null;

		int numSubentri = 0;

		try {

			if (idTipoSubentro.intValue() == TipoSubentroEnum.IMPRESA.getId())
			{
				numSubentri = effettuaSubentroMassivoManutentore(idPgAttuale, idPgSubentro, cfUtenteLoggato);
			}
			else if (idTipoSubentro.intValue() == TipoSubentroEnum.RESPONSABILE_IMPRESA.getId())
			{
				numSubentri = effettuaSubentroMassivoRespImpresa(idPgAttuale, idPgSubentro, cfUtenteLoggato);
			}

		}
		catch (ManagerException ex)
		{
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw ex;
		}
		finally {
			log.debug("[SigitMgr::effettuaSubentroMassivo] END");
		}
		return numSubentri;
	}

	/*
	public Integer effettuaSubentroMassivoInstallatore(Integer idPgAttuale, Integer idPgSubentro, String cfUtenteLoggato) throws ManagerException {
		log.debug("[SigitMgr::effettuaSubentroMassivoInstallatore] BEGIN");

		int numSubentri = 0;
		try {
			FiltroRicercaPfPg filter = new FiltroRicercaPfPg();
			filter.setIdPersonaGiuridica(ConvertUtil.convertToBigDecimal(idPgAttuale));
			filter.setIdRuolo(ConvertUtil.convertToString(Constants.ID_RUOLO_INSTALLATORE));
			filter.setIsEscludiDataOdierna(true);
			// Recupero la lista da subentrare
			List<SigitRImpRuoloPfpgDto> installatoriList = getDbMgr().getSigitRImpRuoloPfpgDao().findAttiviByFilter(filter);

			if (log.isDebugEnabled())
				GenericUtil.stampa(installatoriList, true, 3);

			for (SigitRImpRuoloPfpgDto sigitRImpRuoloPfpgDto : installatoriList) {

				sigitRImpRuoloPfpgDto.setDataFine(DateUtil.getSqlYesterdayDate());
				sigitRImpRuoloPfpgDto.setUtenteUltMod(cfUtenteLoggato);
				sigitRImpRuoloPfpgDto.setDataUltMod(DateUtil.getSqlDataCorrente());

				// Modifico l'installatore precedente
				getDbMgr().getSigitRImpRuoloPfpgDao().update(sigitRImpRuoloPfpgDto);

				// Devo inserire tutti i nuovi installatori
				sigitRImpRuoloPfpgDto.setFkPersonaGiuridica(ConvertUtil.convertToBigDecimal(idPgSubentro));
				sigitRImpRuoloPfpgDto.setDataInizio(DateUtil.getSqlCurrentDate());
				sigitRImpRuoloPfpgDto.setDataFine(null);

				//sigitRImpRuoloPfpgDto.setUtenteUltMod(cfUtenteLoggato);
				//sigitRImpRuoloPfpgDto.setDataUltMod(DateUtil.getSqlDataCorrente());

				// Inserisco l'installatore che subentra
				getDbMgr().getSigitRImpRuoloPfpgDao().insert(sigitRImpRuoloPfpgDto);

				numSubentri++;
			}

			return numSubentri;

		}
		catch (SigitRImpRuoloPfpgDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::effettuaSubentroMassivoInstallatore] END");
		}
	}
	*/

	public Integer effettuaSubentroMassivoRespImpresa(Integer idPgAttuale, Integer idPgSubentro, String cfUtenteLoggato) throws ManagerException {
		log.debug("[SigitMgr::effettuaSubentroMassivoRespImpresa] BEGIN");

		int numSubentri = 0;

		try {
			FiltroRicercaPfPg filter = new FiltroRicercaPfPg();
			filter.setIdPersonaGiuridica(ConvertUtil.convertToBigDecimal(idPgAttuale));
			filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO));
			filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE));
			filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE));
			filter.setIsEscludiDataOdierna(true);

			// Recupero la lista da subentrare
			List<SigitRImpRuoloPfpgDto> respImpresaList = getDbMgr().getSigitRImpRuoloPfpgDao().findAttiviByFilter(filter);

			if (log.isDebugEnabled())
				GenericUtil.stampa(respImpresaList, true, 3);

			for (SigitRImpRuoloPfpgDto sigitRImpRuoloPfpgDto : respImpresaList) {

				sigitRImpRuoloPfpgDto.setDataFine(DateUtil.getSqlYesterdayDate());
				sigitRImpRuoloPfpgDto.setUtenteUltMod(cfUtenteLoggato);
				sigitRImpRuoloPfpgDto.setDataUltMod(DateUtil.getSqlDataCorrente());

				// Modifico il responsabile impresa precedente
				getDbMgr().getSigitRImpRuoloPfpgDao().update(sigitRImpRuoloPfpgDto);

				// Devo inserire tutti i nuovi installatori
				sigitRImpRuoloPfpgDto.setFkPersonaGiuridica(ConvertUtil.convertToBigDecimal(idPgSubentro));
				sigitRImpRuoloPfpgDto.setDataInizio(DateUtil.getSqlCurrentDate());
				sigitRImpRuoloPfpgDto.setDataFine(null);

				//sigitRImpRuoloPfpgDto.setUtenteUltMod(cfUtenteLoggato);
				//sigitRImpRuoloPfpgDto.setDataUltMod(DateUtil.getSqlDataCorrente());

				// Inserisco il responsabile impresa che subentra
				getDbMgr().getSigitRImpRuoloPfpgDao().insert(sigitRImpRuoloPfpgDto);

				numSubentri++;
			}

			return numSubentri;

		}
		catch (SigitRImpRuoloPfpgDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::effettuaSubentroMassivoRespImpresa] END");
		}
	}

	public Integer effettuaSubentroMassivoManutentore(Integer idPgAttuale, Integer idPgSubentro, String cfUtenteLoggato) throws ManagerException {
		log.debug("[SigitMgr::effettuaSubentroMassivoManutentore] BEGIN");

		int numSubentri = 0;

		try {
			FiltroRicercaPfPg filter = new FiltroRicercaPfPg();
			filter.setIdPersonaGiuridica(ConvertUtil.convertToBigDecimal(idPgAttuale));
			filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_MANUTENTORE_ALL_1));
			filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_MANUTENTORE_ALL_2));
			filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_MANUTENTORE_ALL_3));
			filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_MANUTENTORE_ALL_4));
			filter.setIsEscludiDataOdierna(true);

			// Recupero la lista da subentrare
			List<SigitRComp4ManutDto> respManutentoreList = getDbMgr().getSigitRComp4ManutDao().findAttiviByFilterSubentro(filter);

			if (log.isDebugEnabled())
				GenericUtil.stampa(respManutentoreList, true, 3);


			for (SigitRComp4ManutDto sigitRComp4ManutDto : respManutentoreList) {

				sigitRComp4ManutDto.setDataFine(DateUtil.getSqlYesterdayDate());
				sigitRComp4ManutDto.setUtenteUltMod(cfUtenteLoggato);
				sigitRComp4ManutDto.setDataUltMod(DateUtil.getSqlDataCorrente());

				// Modifico il responsabile impresa precedente
				getDbMgr().getSigitRComp4ManutDao().update(sigitRComp4ManutDto);

				// Devo inserire tutti i nuovi installatori
				sigitRComp4ManutDto.setFkPersonaGiuridica(ConvertUtil.convertToBigDecimal(idPgSubentro));
				sigitRComp4ManutDto.setDataInizio(DateUtil.getSqlCurrentDate());
				sigitRComp4ManutDto.setDataFine(null);

				//sigitRComp4ManutDto.setUtenteUltMod(cfUtenteLoggato);
				//sigitRComp4ManutDto.setDataUltMod(DateUtil.getSqlDataCorrente());

				// Inserisco il responsabile impresa che subentra
				getDbMgr().getSigitRComp4ManutDao().insert(sigitRComp4ManutDto);

				numSubentri++;
			}

			return numSubentri;

		}
		catch (SigitRComp4ManutDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[SigitMgr::effettuaSubentroMassivoManutentore] END");
		}

	}

	public void impostaComuneSuRicercaImpianti(ArrayList<CodeDescription> comuni, RicercaImpianti ricImp, String istatAbilitazione) throws ManagerException {
		String codIstatComune = GenericUtil.getCodIstatComuneByIstatAbilitazione(istatAbilitazione);

		if (GenericUtil.getDescriptionByCod(codIstatComune, comuni) == null) {
			Message message = new Message("Abilitazione su comune non presente tra i comuni trovati dal servizio di toponomastica", Message.FATAL);
			throw new ManagerException(message);
		}

		ricImp.setIdComune(codIstatComune);
	}

	public ArrayList<CodeDescription> impostaProvinciaSuRicercaImpianti(RicercaImpianti ricImp, String istatAbilitazione)
			throws ServiceException {
		String codIstatProv = GenericUtil.getCodIstatProvByIstatAbilitazione(istatAbilitazione);
		Provincia provincia = getServiziMgr().getProvinciaDaCodiceIstatOrSigla(codIstatProv);
		String siglaProv = provincia.getSigla().toUpperCase();
		ricImp.setIdProvincia(siglaProv);
		ArrayList<CodeDescription> comuni = (ArrayList<CodeDescription>) getServiziMgr()
				.getListaComuniByIstatProvincia(siglaProv);

		return comuni;
	}


	public String getDescrizioneAbilitazioneDaCodIstat(String istatAbilitazione) throws ServiceException {

		String descrAbilitazione = null;

		int istatAbilitazioneLength = istatAbilitazione.length();

		if (istatAbilitazioneLength == 5 || istatAbilitazioneLength == 8) {
			istatAbilitazione = istatAbilitazione.substring(2);
			istatAbilitazioneLength -= 2;
		}

		switch (istatAbilitazioneLength) {
			case 2:
				descrAbilitazione = Constants.ABILITAZIONE_REGIONE_PIEMONTE;
				break;
			case 3:
				Provincia provincia = getServiziMgr().getProvinciaDaCodiceIstatOrSigla(istatAbilitazione);
				descrAbilitazione = Constants.ABILITAZIONE_PROVINCIA + GenericUtil.capitalizeToLowerCase(provincia.getNome());
				break;
			case 6:
				Comune comune = getServiziMgr().getComuneDaCodiceIstat(istatAbilitazione);
				descrAbilitazione = Constants.ABILITAZIONE_COMUNE + GenericUtil.capitalizeToLowerCase(comune.getNome());
				break;
		}

		return descrAbilitazione;
	}

	public SigitTImpiantoDto getImpiantoByCodice(String codiceImpianto) throws ServiceException  {
		log.debug("[SigitMgr::getImpiantoByCodice] BEGIN");
		try {
			return getDbMgr().getSigitTImpiantoDao().findByPrimaryKey(new SigitTImpiantoPk(
					ConvertUtil.convertToBigDecimal(codiceImpianto)));
		}catch (Exception e) {
				log.error("Errore getImpiantoByCodice",e);
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[SigitMgr::getImpiantoByCodice] END");
		}
	}

	public Integer getIdStatoImpiantoByCodiceImp(String codiceImpianto) throws ServiceException {
		SigitTImpiantoDto impiantoDto = getImpiantoByCodice(codiceImpianto);
		return ConvertUtil.convertToInteger(impiantoDto.getFkStato());
	}

	public SigitDStatoImpDto getDescStatoImpiantoByIdStato(Integer idStato) throws ServiceException {
		log.debug("[SigitMgr::getDescStatoImpiantoById] BEGIN");
		try {
			return getDbMgr().getSigitDStatoImpDao().
					findByPrimaryKey(new SigitDStatoImpPk(ConvertUtil.convertToBigDecimal(idStato)));
		}catch (Exception e) {
				log.error("Errore getDescStatoImpiantoById",e);
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[SigitMgr::getDescStatoImpiantoById] END");
		}
	}

	public DettaglioDocumento getReeAllegatoDettaglioDocumento(DettaglioAllegato dettaglio, boolean isBozza) {
		DettaglioDocumento allegato = null;

		if (dettaglio.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_1)) {
			allegato = getReeBuilder().generaReeGt(dettaglio, false, isBozza);
		}
		else if (dettaglio.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_1B)) {
			allegato = getReeBuilder().generaReeGtB(dettaglio, false, isBozza);
		}
		else if (dettaglio.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_2)) {
			allegato = getReeBuilder().generaReeGf(dettaglio, false, isBozza);
		}
		else if (dettaglio.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_3)) {
			allegato = getReeBuilder().generaReeSc(dettaglio, false, isBozza);
		}
		else if (dettaglio.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_4)) {
			 allegato = getReeBuilder().generaReeCg(dettaglio, false, isBozza);
		}

		return allegato;
	}

	public String getSiglaProvinciaByIstatAbilitazione(String istatAbilitazione) throws ServiceException  {
		String codIstatProv = GenericUtil.getCodIstatProvByIstatAbilitazione(istatAbilitazione);
		Provincia provincia = getServiziMgr().getProvinciaDaCodiceIstatOrSigla(codIstatProv);
		return provincia.getSigla().toUpperCase();
	}

	public String getComumeByIstatAbilitazione(String istatAbilitazione) throws ServiceException {
		String codIstatComune = GenericUtil.getCodIstatComuneByIstatAbilitazione(istatAbilitazione);
		Comune comune = getServiziMgr().getComuneDaCodiceIstat(codIstatComune);
		return comune.getNome().toUpperCase();
	}

	public ArrayList<String> filtraCodiciImpiantoVisibiliDaProprietario(ArrayList<String> codiciDaFiltrare) throws ManagerException {
		log.debug("[SigitMgr::filtraCodiciImpiantoVisibiliDaProprietario] START");
		ArrayList<String> codiciFiltrati = new ArrayList<String>();

		ImpiantoFilter filter = new ImpiantoFilter();
		filter.setFlagVisuProprietario(ConvertUtil.convertToBigDecimal(true));
		filter.setListaCodiciImpianto(codiciDaFiltrare);

		try {

			List<SigitTImpiantoDto> impiantiFiltrati = getDbMgr().cercaImpiantiDtoByFiltro(filter);

			for (SigitTImpiantoDto impianto : impiantiFiltrati) {
				codiciFiltrati.add(impianto.getCodiceImpianto().toString());
			}

			return codiciFiltrati;

		} catch (Exception e) {
			log.error("Errore filtraCodiciImpiantoVisibiliDaProprietario",e);
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[SigitMgr::filtraCodiciImpiantoVisibiliDaProprietario] END");
		}
	}

	public String getCodiceImpiantoFromXmlReeManutenzione (String fileName, Reader xmlReader, byte[] theXml) throws ValidationManagerException {

		String codiceImpianto = null;
		try {

			if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_II.toLowerCase()))
			{
				log.debug("lettura xml dell'allegato 2");
				XmlValidator.validate(xmlReader, new InputStreamReader(GenericUtil.getFileInClassPath(Constants.XML_IMPORT_ALLEGATO_II_SCHEMA_DIR)));
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument document = MapDto.mapToImportMODIIDocument(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RichiestaDocument.Richiesta richiesta = document.getMODII().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();

			}
			else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_IIB.toLowerCase()))
			{
				log.debug("lettura xml dell'allegato 2B");
				log.debug(Constants.XML_IMPORT_ALLEGATO_IIB_SCHEMA_DIR);
				XmlValidator.validate(xmlReader, new InputStreamReader(GenericUtil.getFileInClassPath(Constants.XML_IMPORT_ALLEGATO_IIB_SCHEMA_DIR)));
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.MODIIBDocument document = MapDto.mapToImportMODIIBDocument(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.RichiestaDocument.Richiesta richiesta = document.getMODIIB().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();

			}
			else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_III.toLowerCase()))
			{
				log.debug("lettura xml dell'allegato 3");
				XmlValidator.validate(xmlReader, new InputStreamReader(GenericUtil.getFileInClassPath(Constants.XML_IMPORT_ALLEGATO_III_SCHEMA_DIR)));
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument document = MapDto.mapToImportMODIIIDocument(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RichiestaDocument.Richiesta richiesta = document.getMODIII().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();
			}
			else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_IV.toLowerCase()))
			{
				log.debug("lettura xml dell'allegato 4");
				XmlValidator.validate(xmlReader, new InputStreamReader(GenericUtil.getFileInClassPath(Constants.XML_IMPORT_ALLEGATO_IV_SCHEMA_DIR)));
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument document = MapDto.mapToImportMODIVDocument(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RichiestaDocument.Richiesta richiesta = document.getMODIV().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();
			}
			else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_V.toLowerCase()))
			{
				log.debug("lettura xml dell'allegato 5");
				XmlValidator.validate(xmlReader, new InputStreamReader(GenericUtil.getFileInClassPath(Constants.XML_IMPORT_ALLEGATO_V_SCHEMA_DIR)));
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument document = MapDto.mapToImportMODVDocument(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RichiestaDocument.Richiesta richiesta = document.getMODV().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();
			}
			else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_MANUT_GT.toLowerCase()))
			{
				log.debug("lettura xml della manutenzione GT");
				XmlValidator.validate(xmlReader, new InputStreamReader(GenericUtil.getFileInClassPath(Constants.XML_IMPORT_MANUT_GT_SCHEMA_DIR)));
				it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegt.data.MANUTENZIONEDocument document = MapDto.mapToImportMANUTENZIONEGTDocument(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegt.data.RichiestaDocument.Richiesta richiesta = document.getMANUTENZIONE().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();
			}
			else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_MANUT_GF.toLowerCase()))
			{
				log.debug("lettura xml della manutenzione GF");
				XmlValidator.validate(xmlReader, new InputStreamReader(GenericUtil.getFileInClassPath(Constants.XML_IMPORT_MANUT_GF_SCHEMA_DIR)));
				it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegf.data.MANUTENZIONEDocument document = MapDto.mapToImportMANUTENZIONEGFDocument(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegf.data.RichiestaDocument.Richiesta richiesta = document.getMANUTENZIONE().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();
			}
			else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_MANUT_SC.toLowerCase()))
			{
				log.debug("lettura xml della manutenzione SC");
				XmlValidator.validate(xmlReader, new InputStreamReader(GenericUtil.getFileInClassPath(Constants.XML_IMPORT_MANUT_SC_SCHEMA_DIR)));
				it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionesc.data.MANUTENZIONEDocument document = MapDto.mapToImportMANUTENZIONESCDocument(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionesc.data.RichiestaDocument.Richiesta richiesta = document.getMANUTENZIONE().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();
			}
			else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_MANUT_CG.toLowerCase()))
			{
				log.debug("lettura xml della manutenzione CG");
				XmlValidator.validate(xmlReader, new InputStreamReader(GenericUtil.getFileInClassPath(Constants.XML_IMPORT_MANUT_CG_SCHEMA_DIR)));
				it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionecg.data.MANUTENZIONEDocument document = MapDto.mapToImportMANUTENZIONECGDocument(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionecg.data.RichiestaDocument.Richiesta richiesta = document.getMANUTENZIONE().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();
			}
			else {
				throw new ValidationManagerException(new Message(Messages.ERROR_NOME_FILE_IMPORT_XML_MASSIVO));
			}

			return codiceImpianto;

		}  catch (XmlValidatorException e) {
			log.debug("errore validazione xml", e);
			throw new ValidationManagerException(new Message(Messages.S098, fileName));
		}
	}

	public String getTipoImportXmlManutenzioneReeFromXmlFilename(String fileName) throws ValidationManagerException {
		String tipoImport = null;

		if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_II.toLowerCase()))
		{
			tipoImport = TipoImportAllegatoEnum.ALLEGATOII.tipoImportLabel;
		}
		else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_IIB.toLowerCase()))
		{
			tipoImport = TipoImportAllegatoEnum.ALLEGATOIIB.tipoImportLabel;
		}
		else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_III.toLowerCase()))
		{
			tipoImport = TipoImportAllegatoEnum.ALLEGATOIII.tipoImportLabel;
		}
		else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_IV.toLowerCase()))
		{
			tipoImport = TipoImportAllegatoEnum.ALLEGATOIV.tipoImportLabel;
		}
		else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_V.toLowerCase()))
		{
			tipoImport = TipoImportAllegatoEnum.ALLEGATOV.tipoImportLabel;
		}
		else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_MANUT_GT.toLowerCase()))
		{
			tipoImport = TipoImportAllegatoEnum.MANUT_GT.tipoImportLabel;
		}
		else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_MANUT_GF.toLowerCase()))
		{
			tipoImport = TipoImportAllegatoEnum.MANUT_GF.tipoImportLabel;
		}
		else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_MANUT_SC.toLowerCase()))
		{
			tipoImport = TipoImportAllegatoEnum.MANUT_SC.tipoImportLabel;
		}
		else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_MANUT_CG.toLowerCase()))
		{
			tipoImport = TipoImportAllegatoEnum.MANUT_CG.tipoImportLabel;
		}
		else {
			throw new ValidationManagerException(new Message(Messages.ERROR_NOME_FILE_IMPORT_XML_MASSIVO));
		}

		return tipoImport;
	}

	public ArrayList<IdDescription> getTipiVerificaInserimentoIspezioniMassive() throws ManagerException {
		log.debug("[SigitMgr::getTipiVerificaInserimentoIspezioniMassive] START");

		try {

			List<SigitDTipoVerificaDto> tipiVerifica = new ArrayList<SigitDTipoVerificaDto>();

			SigitDTipoVerificaDto tipoVerificaImpianto = getDbVerificaMgr().getTipoVerificaById(Constants.ID_TIPO_VERIFICA_IMPIANTO);
			SigitDTipoVerificaDto tipoVerificaDatoDistributore = getDbVerificaMgr().getTipoVerificaById(Constants.ID_TIPO_VERIFICA_DATO_DISTRIBUTORE);
			tipiVerifica.add(tipoVerificaImpianto);
			tipiVerifica.add(tipoVerificaDatoDistributore);

			GenericUtil.stampa(MapDto.mapToTipoVerifiche(tipiVerifica), true, 4);

			for (IdDescription desc: MapDto.mapToTipoVerifiche(tipiVerifica)) {
				GenericUtil.stampa(desc, true, 3);
			}

			return MapDto.mapToTipoVerifiche(tipiVerifica);

		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[SigitMgr::getTipiVerificaInserimentoIspezioniMassive] END");
		}
	}

	public List<String> inserimentoIspezioniMassive(List<String> elencoValore, int idTipoVerifica, boolean isIspezionePagamento, UtenteLoggato utenteLoggato) {
		log.debug("[SigitMgr::inserimentoIspezioniMassive] START");

		List<String> valoriConErroriList = new ArrayList<String>();

		for (String valore : elencoValore) {

			try {
				Ispezione2018 ispezione = null;

				switch (idTipoVerifica) {
				case Constants.ID_TIPO_VERIFICA_IMPIANTO :
					SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(valore);

					ispezione = getDbMgr().inserisciIspezioneMassivaImpianto(impianto, isIspezionePagamento, utenteLoggato);

					break;
				case Constants.ID_TIPO_VERIFICA_DATO_DISTRIBUTORE :
					SigitTDatoDistribDto datoDistrib = getDbMgr().cercaDatoDistributore(ConvertUtil.convertToInteger(valore));

					ispezione = getDbMgr().inserisciIspezioneMassivaDatoDistributore(datoDistrib, isIspezionePagamento, utenteLoggato);

					break;
				default:
					throw new Exception(Messages.ERROR_TIPO_VERIFICA_NON_VALIDO_INSERIMENTO_ISPEZIONI_MASSIVE);
				}

				ispezione = caricaIspezioneDaId(ispezione.getIdentificativoIspezione(), true, true);

				getServiziMgr().sendMailInserisciIspezione(ispezione);

			} catch(Exception e) {
				log.error(e);
				valoriConErroriList.add(valore);
			}
		}

		elencoValore.removeAll(valoriConErroriList);

		log.debug("[SigitMgr::inserimentoIspezioniMassive] END");

		return valoriConErroriList;
	}

	public String getIndirizzoCompletoByIstatComuneIndirizzoCivico(String istatComune, String dug, String indirizzo, String civico) throws ServiceException {
		Comune comuneDatoDistrib = null;
		if (istatComune != null)
			comuneDatoDistrib = getServiziMgr().getComuneDaCodiceIstat(istatComune);

		String indirizzoParziale = MapDto.getIndirizzoByDugIndirizzo(dug, indirizzo);
		
		Provincia provincia = getServiziMgr().getProvinciaById(comuneDatoDistrib.getIdProvincia());
		
		return comuneDatoDistrib != null ? MapDto.getIndirizzoCompleto(comuneDatoDistrib.getNome(), indirizzoParziale, civico, provincia.getSigla()) : "";
		//return comuneDatoDistrib != null ? MapDto.getIndirizzoCompleto(comuneDatoDistrib.getNome(), indirizzoParziale, civico, comuneDatoDistrib.getProvComune().getSiglaProvincia()) : "";
	}

	public DistributoreMan getDistributoreManFromSigitTDatoDistrib(SigitTDatoDistribDto datoDistrib) throws ServiceException {

		Comune comuneForn = getServiziMgr().getComuneDaCodiceIstat(datoDistrib.getIstatComune());

		String siglaProvinciaForn = getServiziMgr().getProvinciaById(comuneForn.getIdProvincia()).getSigla();
		//String siglaProvinciaForn = comuneForn.getProvComune().getSiglaProvincia();

		String siglaProvinciaFatt = null;

		if (datoDistrib.getIstatComuneFatt() != null) {

			Comune comuneFatt = getServiziMgr().getComuneDaCodiceIstat(datoDistrib.getIstatComuneFatt());
			siglaProvinciaFatt = getServiziMgr().getProvinciaById(comuneFatt.getIdProvincia()).getSigla();
			//siglaProvinciaFatt = comuneFatt.getProvComune().getSiglaProvincia();
		}

		return MapDto.mapToDistributoreMan(datoDistrib, siglaProvinciaForn, siglaProvinciaFatt);

	}

	@Transactional
	public void uploadRapportoProvaFirmato(DettaglioAllegato allegato, File fileRappProvaFirmato, String nomeFile, UtenteLoggato utenteLoggato) throws ManagerException {
		log.debug("[SigitMgr::uploadRapportoProvaFirmato] BEGIN");

		try {

			SigitTAllegatoDto allegatoDto = getDbMgr().cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(allegato.getIdAllegato()));

			SigitTImpiantoDto impiantoDto = getDbMgr().cercaImpiantoDtoById(allegato.getCodiceImpianto());

			String nomeAllegato = getNomeRappProvaFirmato(allegatoDto.getFkTipoDocumento(), ConvertUtil.convertToBigDecimal(allegato.getCodiceImpianto()),
					allegatoDto.getDataControllo(), allegatoDto.getIdAllegato(), FilenameUtils.getExtension(nomeFile));

			Metadati metadati = MapDto.mapMetadatiAllegati(impiantoDto, allegatoDto, Constants.COD_REA_ISPETTORE);

			String uidIndexFirmato = allegatoDto.getUidIndexFirmato();

			if (GenericUtil.isNotNullOrEmpty(uidIndexFirmato)) {
				getServiziMgr().indexDeleteContentByUid(uidIndexFirmato);
			}

			byte[] byteArrayRappProvaFirmato = FileUtils.readFileToByteArray(fileRappProvaFirmato);

			String uidRappProvaFirmato = getServiziMgr().indexUploadFileNew(nomeAllegato, byteArrayRappProvaFirmato, metadati, Constants.INDEX_FOLDER_ISPEZIONI, false);

			allegatoDto.setUidIndexFirmato(ReplaceSpecialCharUtils.sanitize(uidRappProvaFirmato));
			allegatoDto.setNomeAllegatoFirmato(ReplaceSpecialCharUtils.sanitize(nomeAllegato));
			allegatoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
			allegatoDto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(utenteLoggato.getCodiceFiscale()));

			getDbMgr().aggiornaAllegato(allegatoDto);

		} catch (ServiceException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} catch (ManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_UPDATE_DB));

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new ManagerException(e, new Message(Messages.ERROR_GENERICO));

		} finally{
			log.debug("[SigitMgr::uploadRapportoProvaFirmato] END");
		}
	}

	public String getMsgInvioRee(DettaglioAllegato dettaglioAllegato, SigitVRicercaAllegatiDto allegatoDto,
			ResultInvioMail resultInvioMail) throws ValidationManagerException {
		String msg = Messages.INFO_ALLEGATO_INVIATO_CORRETTAMENTE;

		if (getValidationMgr().isImpiantoSenzaValvoleTermostatiche(dettaglioAllegato.getDataControllo(),
				allegatoDto.getCodiceImpianto(), false)) {
			msg += Messages.INFO_ALLEGATO_INVIATO_IMP_NON_VALVOLE;
		}

		if (!ConvertUtil.convertToBooleanAllways(allegatoDto.getFFlgPuoFunzionare())) {
			msg += Messages.INFO_ALLEGATO_INVIATO_NON_SICURO;
		}

		msg = GenericUtil.getMsgFormatterHtml(resultInvioMail, msg);
		return msg;
	}

	public ArrayList<IdDescription> getIdDescriptionStelle() throws DbManagerException {
		return MapDto.mapStelleDtoListToIdDescriptionList(getDbMgr().findAllStelle());
	}

	public ArrayList<IdDescription> getIdDescriptionTipo1B() throws DbManagerException {
		return MapDto.mapTipo1BDtoListToIdDescriptionList(getDbMgr().findAllTipo1B());
	}

	public ArrayList<IdDescription> getIdDescriptionAriaComburente() throws DbManagerException {
		return MapDto.mapAriaComburenteDtoListToIdDescriptionList(getDbMgr().findAllAriaComburente());
	}

	public ArrayList<IdDescription> getIdDescriptionControlloAria() throws DbManagerException {
		return MapDto.mapControlloAriaDtoListToIdDescriptionList(getDbMgr().findAllControlloAria());
	}

	public ArrayList<IdDescription> getIdDescriptionTipoCaricCombu() throws DbManagerException {
		return MapDto.mapTipoCaricCombuDtoListToIdDescriptionList(getDbMgr().findAllTipoCaricCombu());
	}

	public void aggiungiCoordinateAdImpianto(Impianto impianto) {
		log.debug("[SigitMgr::aggiungiCoordinateAdImpianto] START");
		try {

			String indirizzoSitad = impianto.getImpLocIndirizzoSitad();

			StringBuilder indirizzoBuilder = new StringBuilder();
			indirizzoBuilder.append(impianto.getImpLocDescComune()).append(" ");
			if (indirizzoSitad != null) {
				indirizzoBuilder.append(indirizzoSitad);
			} else {
				indirizzoBuilder.append(impianto.getImpLocIndirizzoNoStrad());
			}
			indirizzoBuilder.append(" ").append(impianto.getImpLocCivico());

			List<Double> coordinate = getServiziMgr().getLOCCSICoordinates(indirizzoBuilder.toString());

			impianto.setCoordLng(coordinate.get(0));
			impianto.setCoordLat(coordinate.get(1));

		} catch (Exception e) {
			log.error("Errore durante il recupero delle coordinate", e);

			impianto.setCoordLng(0.0);
			impianto.setCoordLat(0.0);
		} finally{
			log.debug("[SigitMgr::aggiungiCoordinateAdImpianto] END");
		}
	}

	public void aggiornaCoordinateImpianti() throws DbManagerException, ServiceException, ParseException {

		String dataAggiornaCoord = getDbMgr().cercaConfigValue(Constants.CHIAVE_CONFIG_DATA_AGGIORNAMENTO_COORDINATE).getValoreConfigChar();

		List<SigitTImpiantoAggiornamentoCoordinateDto> impiantiSenzaCoordinate = getDbMgr().findImpiantiConCoordinateDaAggiornare(true);

		for (SigitTImpiantoAggiornamentoCoordinateDto impianto : impiantiSenzaCoordinate) {
			aggiornaCoordinateImpianto(impianto);
		}

		if (impiantiSenzaCoordinate.isEmpty()) {
			List<SigitTImpiantoAggiornamentoCoordinateDto> impiantiDaAggiornare = getDbMgr().findImpiantiConCoordinateDaAggiornare(dataAggiornaCoord);

			for (SigitTImpiantoAggiornamentoCoordinateDto impianto : impiantiDaAggiornare) {
				aggiornaCoordinateImpianto(impianto);
			}
		}
	}

	private void aggiornaCoordinateImpianto(SigitTImpiantoAggiornamentoCoordinateDto impianto) throws DbManagerException, ServiceException {
		SigitTImpiantoDto impiantoDto = getDbMgr().cercaImpiantoDtoById(ConvertUtil.convertToString(impianto.getImpiantiCodiceImpianto()));

		try {

			String indirizzoSitad = impianto.getImmobiliIndirizzoSitad();

			StringBuilder indirizzoBuilder = new StringBuilder();
			indirizzoBuilder.append(impianto.getImpiantiDenominazioneComune()).append(" ");
			if (indirizzoSitad != null) {
				indirizzoBuilder.append(indirizzoSitad);
			} else {
				indirizzoBuilder.append(impianto.getImmobiliIndirizzoNonTrovato());
			}
			indirizzoBuilder.append(" ").append(impianto.getImmobiliCivico());

			List<Double> coordinate = getServiziMgr().getLOCCSICoordinates(indirizzoBuilder.toString());

			impiantoDto.setCoordXLongDd(coordinate.get(0));
			impiantoDto.setCoordYLatDd(coordinate.get(1));


		} catch (Exception e) {
			log.error("Errore durante il recupero delle coordinate", e);

			impiantoDto.setCoordXLongDd(0.0);
			impiantoDto.setCoordYLatDd(0.0);
		}

		getDbMgr().aggiornaImpianto(impiantoDto);
	}

	public ArrayList<CodeDescription> impostaProvinciaSuRicercaAccertamenti(RicercaAccertamento ricAcc, String istatAbilitazione) throws ServiceException {
		String codIstatProv = GenericUtil.getCodIstatProvByIstatAbilitazione(istatAbilitazione);
		Provincia provincia = getServiziMgr().getProvinciaDaCodiceIstatOrSigla(codIstatProv);
		String siglaProv = provincia.getSigla().toUpperCase();
		ricAcc.setIstatProvincia(codIstatProv);
		return getServiziMgr()
				.getListaComuniByIstatProvincia(siglaProv);
	}

	public void impostaComuneSuRicercaAccertamenti(ArrayList<CodeDescription> comuni, RicercaAccertamento ricAcc, String istatAbilitazione) throws ManagerException {
		String codIstatComune = GenericUtil.getCodIstatComuneByIstatAbilitazione(istatAbilitazione);

		if (GenericUtil.getDescriptionByCod(codIstatComune, comuni) == null) {
			Message message = new Message("Abilitazione su comune non presente tra i comuni trovati dal servizio di toponomastica", Message.FATAL);
			throw new ManagerException(message);
		}

		ricAcc.setIstatComune(codIstatComune);
	}

	public ArrayList<CodeDescription> impostaProvinciaSuRicercaIspezioni(RicercaIspezioni2018 ricIspez, String istatAbilitazione) throws ServiceException {
		String codIstatProv = GenericUtil.getCodIstatProvByIstatAbilitazione(istatAbilitazione);
		Provincia provincia = getServiziMgr().getProvinciaDaCodiceIstatOrSigla(codIstatProv);
		String siglaProv = provincia.getSigla().toUpperCase();
		ricIspez.setIstatProvincia(codIstatProv);
		return getServiziMgr()
				.getListaComuniByIstatProvincia(siglaProv);
	}

	public void impostaComuneSuRicercaIspezioni(ArrayList<CodeDescription> comuni, RicercaIspezioni2018 ricIspez, String istatAbilitazione) throws ManagerException {
		String codIstatComune = GenericUtil.getCodIstatComuneByIstatAbilitazione(istatAbilitazione);

		if (GenericUtil.getDescriptionByCod(codIstatComune, comuni) == null) {
			Message message = new Message("Abilitazione su comune non presente tra i comuni trovati dal servizio di toponomastica", Message.FATAL);
			throw new ManagerException(message);
		}

		ricIspez.setIstatComune(codIstatComune);
	}

	public ArrayList<CodeDescription> impostaProvinciaSuInserisciAccertamento(Accertamento acc, String istatAbilitazione) throws ServiceException {
		String codIstatProv = GenericUtil.getCodIstatProvByIstatAbilitazione(istatAbilitazione);
		Provincia provincia = getServiziMgr().getProvinciaDaCodiceIstatOrSigla(codIstatProv);
		String siglaProv = provincia.getSigla().toUpperCase();
		acc.setCodIstatProv(codIstatProv);
		return getServiziMgr()
				.getListaComuniByIstatProvincia(siglaProv);
	}

	public void impostaComuneSuInserisciAccertamento(ArrayList<CodeDescription> comuni, Accertamento acc, String istatAbilitazione) throws ManagerException {
		String codIstatComune = GenericUtil.getCodIstatComuneByIstatAbilitazione(istatAbilitazione);

		if (GenericUtil.getDescriptionByCod(codIstatComune, comuni) == null) {
			Message message = new Message("Abilitazione su comune non presente tra i comuni trovati dal servizio di toponomastica", Message.FATAL);
			throw new ManagerException(message);
		}

		acc.setCodIstatCom(codIstatComune);
	}

	public void impostaComuneSuDettaglioIspezioni(ArrayList<CodeDescription> comuni, Ispezione2018 ispez, String istatAbilitazione) throws ManagerException {
		String codIstatComune = GenericUtil.getCodIstatComuneByIstatAbilitazione(istatAbilitazione);

		if (GenericUtil.getDescriptionByCod(codIstatComune, comuni) == null) {
			Message message = new Message("Abilitazione su comune non presente tra i comuni trovati dal servizio di toponomastica", Message.FATAL);
			throw new ManagerException(message);
		}

		ispez.setCodIstatCom(codIstatComune);
	}

	public ArrayList<CodeDescription> impostaProvinciaSuDettaglioIspezioni(Ispezione2018 ispez, String istatAbilitazione) throws ServiceException {
		String codIstatProv = GenericUtil.getCodIstatProvByIstatAbilitazione(istatAbilitazione);
		Provincia provincia = getServiziMgr().getProvinciaDaCodiceIstatOrSigla(codIstatProv);
		String siglaProv = provincia.getSigla().toUpperCase();
		ispez.setCodIstatProv(codIstatProv);
		return getServiziMgr()
				.getListaComuniByIstatProvincia(siglaProv);
	}

	public void createExportXls(FileInputStream inputStream, String[] fields, String[] headers, List<? extends Object> ris,File file)
			throws IntrospectionException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, IOException {
		int rowNum = 0;

		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sh = wb.getSheetAt(0);
		Row row = sh.createRow(0);
		XSSFFont font= wb.createFont();
		font.setFontName("Arial");
		font.setColor(IndexedColors.DARK_BLUE.getIndex());
		font.setBold(true);
		font.setItalic(false);
		CellStyle style = wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setFont(font);

		for(int i=0;i<headers.length;i++){
			Cell cell = row.createCell(i);
			cell.setCellStyle(style);
			cell.setCellValue(headers[i]);
		}
		rowNum++;
		Method[] methods = null;

		if(ris!=null && !ris.isEmpty())
			methods = ris.get(0).getClass().getMethods();

		for(Object elem:ris){
			row = sh.createRow(rowNum);
			for(int i=0;i<fields.length;i++){
				for(Method method:methods) {
					if(method.getName().toLowerCase(Locale.ROOT).contains("get") &&
							method.getName().toLowerCase(Locale.ROOT).contains(fields[i].toLowerCase(Locale.ROOT))){
						row.createCell(i).setCellValue(method.invoke(elem)!=null?method.invoke(elem).toString().trim():"");
					}
				}
			}
			rowNum++;
		}

		row = sh.getRow(0);
		for(int colNum = 0; colNum<row.getLastCellNum();colNum++)
			sh.autoSizeColumn(colNum);

		try (FileOutputStream outputStream = new FileOutputStream(file)) {
			wb.write(outputStream);
		}
	}

	public boolean leggiPdfReeFirmato(File file, SigitTAllegatoDto allegato) throws IOException {
		PdfReader reader = null;
		reader = new PdfReader(FileUtils.readFileToByteArray(file));
		PdfTextExtractor textExtractor = new PdfTextExtractor(reader);
		String text = textExtractor.getTextFromPage(1);
		String idAllegato = StringUtils.substringBetween(text, "id_allegato:", "#");
		log.debug("-----------------------------id allegato" +idAllegato+"----------------------------");
		return idAllegato != null && idAllegato.equals(allegato.getIdAllegato().toString());
	}

	public File estraiDocumento(DettaglioAllegato dettaglioAllegato, SigitTAllegatoDto allegato, File file, SigitTImpiantoDto impianto) throws IOException {
		EnvelopedContent envelope = new EnvelopedContent();
		envelope.setData(FileUtils.readFileToByteArray(file));
		envelope.setStore(false);
		Document doc = getServiziMgr().extractDocument(envelope);
		if(doc!=null) {
			File extractedFile = Files.createTempFile("file", ".pdf").toFile();
			FileUtils.writeByteArrayToFile(extractedFile, doc.getBuffer());
			return extractedFile;
		}else
			throw new FileNotFoundException();
	}
}