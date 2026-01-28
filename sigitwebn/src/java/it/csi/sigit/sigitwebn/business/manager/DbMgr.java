/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.manager;



import freemarker.template.SimpleDate;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.AllegatiCompFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleAndDenomFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ContrattoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.DelegaFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaAllegati;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaPfPg;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImpiantoAggiornamentoCoordinateFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImpiantoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportDistribFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.IspezioneFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.LibrettoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.PersonaRuoloFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ResponsabileFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaAccertamentoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaAvanzataImpiantoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaImpiantiSoggettoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaPersonaGiuridicaFisicaFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaSanzioniFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaVerificaFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.SubentroFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.TerzoResponsabileFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.TransazioneFilter;
import it.csi.sigit.sigitwebn.business.manager.db.DbAzioneMgr;
import it.csi.sigit.sigitwebn.business.manager.db.DbIspezioneMgr;
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
import it.csi.sigit.sigitwebn.dto.ExecResults;
import it.csi.sigit.sigitwebn.dto.accesso.AbilitazioniRuoloFunz;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaFisica;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica;
import it.csi.sigit.sigitwebn.dto.accesso.Ruolo;
import it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato;
import it.csi.sigit.sigitwebn.dto.allegati.FiltroControlloInserisciAllegato;
import it.csi.sigit.sigitwebn.dto.allegati.FiltroRicercaCodiciImpianto;
import it.csi.sigit.sigitwebn.dto.back_office.Abilitazione;
import it.csi.sigit.sigitwebn.dto.back_office.RiepilogoStoricizzazione;
import it.csi.sigit.sigitwebn.dto.bollini.AcquistoBollini;
import it.csi.sigit.sigitwebn.dto.bollini.AcquistoBolliniQuantita;
import it.csi.sigit.sigitwebn.dto.bollini.TransazioneApp;
import it.csi.sigit.sigitwebn.dto.bollini.TransazioneBollini;
import it.csi.sigit.sigitwebn.dto.codici_impianto.AcquisizioneCodici;
import it.csi.sigit.sigitwebn.dto.common.CodeDescription;
import it.csi.sigit.sigitwebn.dto.common.IdDescription;
import it.csi.sigit.sigitwebn.dto.delega.Delegato;
import it.csi.sigit.sigitwebn.dto.distributori.DettaglioImportDistributori;
import it.csi.sigit.sigitwebn.dto.distributori.Distributore;
import it.csi.sigit.sigitwebn.dto.distributori.DistributoreMan;
import it.csi.sigit.sigitwebn.dto.impianto.*;
import it.csi.sigit.sigitwebn.dto.impresa.RicercaImprese;
import it.csi.sigit.sigitwebn.dto.incarico.Incaricato;
import it.csi.sigit.sigitwebn.dto.ispezioni.DettaglioIspezione;
import it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteAC;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteAG;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteBRRC;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteCG;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteCI;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteCS;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteGF;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteGT;
import it.csi.sigit.sigitwebn.dto.libretto.ComponentePO;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteRC;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteRV;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteSC;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteSCX;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteSR;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteTE;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteUT;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteVM;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteVR;
import it.csi.sigit.sigitwebn.dto.libretto.Consumo;
import it.csi.sigit.sigitwebn.dto.libretto.DatiExtra;
import it.csi.sigit.sigitwebn.dto.libretto.PkTabellaEdit;
import it.csi.sigit.sigitwebn.dto.libretto.Scheda1;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGF;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGFDett;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGFDettCircuito;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGT;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGTDett;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGTDettModulo;
import it.csi.sigit.sigitwebn.dto.ree.Tipo1;
import it.csi.sigit.sigitwebn.dto.ree.Tipo1Consumo;
import it.csi.sigit.sigitwebn.dto.ree.Tipo1Dett;
import it.csi.sigit.sigitwebn.dto.ree.Tipo1DettModulo;
import it.csi.sigit.sigitwebn.dto.ree.Tipo2;
import it.csi.sigit.sigitwebn.dto.ree.Tipo2Dett;
import it.csi.sigit.sigitwebn.dto.ree.Tipo2DettCircuito;
import it.csi.sigit.sigitwebn.dto.ree.Tipo3;
import it.csi.sigit.sigitwebn.dto.ree.Tipo3Dett;
import it.csi.sigit.sigitwebn.dto.ree.Tipo4;
import it.csi.sigit.sigitwebn.dto.ree.Tipo4Dett;
import it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti_graffati.CpRisRicImpiantoGraffatoModel;
import it.csi.sigit.sigitwebn.dto.sanzioni.DatiInserimentoSanzione;
import it.csi.sigit.sigitwebn.dto.subentro.Subentro;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.TerzoResponsabile;
import it.csi.sigit.sigitwebn.dto.userws.UserWs;
import it.csi.sigit.sigitwebn.dto.verifica.Verifica;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.DateUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.MapDto;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.ReeSuperDto;
import it.csi.sigit.sigitwebn.util.ReplaceSpecialCharUtils;
import it.csi.sigit.sigitwebn.util.XmlBeanUtils;
import it.csi.sigit.sigitwebn.util.enumutil.CondottoEvacuazioneFumiTipo1BEnum;
import it.csi.sigit.sigitwebn.util.enumutil.O2CO2Enum;
import it.csi.sigit.sigitwebn.util.enumutil.RegolareIrregolareEnum;
import it.csi.sigit.sigitwebn.util.enumutil.TipologiaTipo1BEnum;
import it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument;
import it.csi.sigit.sigitwebn.xml.allegato2.data.DatiIntestazioneDocument.DatiIntestazione;
import it.csi.sigit.sigitwebn.xml.allegato2.data.DatiModuloDocument.DatiModulo;
import it.csi.sigit.sigitwebn.xml.allegato2.data.RowAllegatoIIDocument.RowAllegatoII;
import it.csi.sigit.sigitwebn.xml.allegato3.data.MODIIIDocument;
import it.csi.sigit.sigitwebn.xml.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII;
import it.csi.sigit.sigitwebn.xml.allegato4.data.MODIVDocument;
import it.csi.sigit.sigitwebn.xml.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV;
import it.csi.sigit.sigitwebn.xml.allegato5.data.MODVDocument;
import it.csi.sigit.sigitwebn.xml.allegato5.data.RowAllegatoVDocument.RowAllegatoV;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L1SchedaIdentificativaDocument.L1SchedaIdentificativa;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiCIDocument.DatiAltriComponentiCI;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiCIDocument.DatiAltriComponentiCI.SezCI;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiRCDocument.DatiAltriComponentiRC;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiRCDocument.DatiAltriComponentiRC.SezRC;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiRVDocument.DatiAltriComponentiRV;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiRVDocument.DatiAltriComponentiRV.SezRV;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiSCDocument.DatiAltriComponentiSC;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiSCDocument.DatiAltriComponentiSC.SezSC;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiTEDocument.DatiAltriComponentiTE;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiTEDocument.DatiAltriComponentiTE.SezTE;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiUTDocument.DatiAltriComponentiUT;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiUTDocument.DatiAltriComponentiUT.SezUT;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoCombuDocument.DatiConsumoCombu;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoCombuDocument.DatiConsumoCombu.SezCombu;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoEEDocument.DatiConsumoEE;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoEEDocument.DatiConsumoEE.SezConsumo;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoH2ODocument.DatiConsumoH2O;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoProdottiChimiciDocument.DatiConsumoProdottiChimici;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiPrecompilatiDocument.DatiPrecompilati;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiPrecompilatiDocument.DatiPrecompilati.SezNomine;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaIdentificativaImpDocument.DatiSchedaIdentificativaImp;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaSistemaACDocument.DatiSchedaSistemaAC;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaSistemaACDocument.DatiSchedaSistemaAC.SezAC;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaSistemaEmissioneDocument.DatiSchedaSistemaEmissione;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaSistemiDistribDocument.DatiSchedaSistemiDistrib;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaSistemiDistribDocument.DatiSchedaSistemiDistrib.SezPO;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaSistemiDistribDocument.DatiSchedaSistemiDistrib.SezVasi;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaSistemiRegolazDocument.DatiSchedaSistemiRegolaz;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaTrattH2ODocument.DatiSchedaTrattH2O;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiVentilazMeccanicaVMDocument.DatiVentilazMeccanicaVM;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiVentilazMeccanicaVMDocument.DatiVentilazMeccanicaVM.SezVM;
import it.csi.sigit.sigitwebn.xml.libretto.data.MODDocument;
import it.csi.sigit.sigitwebn.xml.libretto.data.RegolazionePrimariaDocument.RegolazionePrimaria;
import it.csi.sigit.sigitwebn.xml.libretto.data.RegolazionePrimariaDocument.RegolazionePrimaria.SezSR;
import it.csi.sigit.sigitwebn.xml.libretto.data.RegolazionePrimariaDocument.RegolazionePrimaria.SezVR;
import it.csi.sigit.sigitwebn.xml.libretto.data.RegolazioneSingoloAmbDocument.RegolazioneSingoloAmb;
import it.csi.sigit.sigitwebn.xml.libretto.data.RichiestaDocument.Richiesta;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowACDocument.RowAC;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowACDocument.RowAC.SezACsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowACsostDocument.RowACsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowAGDocument.RowAG;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowAGDocument.RowAG.SezAGsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowAGsostDocument.RowAGsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowBRDocument.RowBR;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowBRDocument.RowBR.SezBRsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowBRsostDocument.RowBRsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCGDocument.RowCG;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCGDocument.RowCG.SezCGsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCGsostDocument.RowCGsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCIDocument.RowCI;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCIDocument.RowCI.SezCIsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCIsostDocument.RowCIsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCSDocument.RowCS;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCSDocument.RowCS.SezCSvariate;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCSvarDocument.RowCSvar;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCombuDocument.RowCombu;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowConsumoDocument.RowConsumo;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowConsumoEEDocument.RowConsumoEE;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowConsumoH2ODocument.RowConsumoH2O;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowConsumoPRODDocument.RowConsumoPROD;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowDateGTDocument;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowGFDocument.RowGF;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowGFDocument.RowGF.SezGFsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowGFsostDocument.RowGFsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowGTDocument.RowGT;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowGTDocument.RowGT.SezGTsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowGTsostDocument.RowGTsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowPODocument.RowPO;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowPODocument.RowPO.SezPOsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowPOsostDocument.RowPOsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowRCDocument.RowRC;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowRCDocument.RowRC.SezRCsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowRCcalDocument.RowRCcal;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowRCcalsostDocument.RowRCcalsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowRCsostDocument.RowRCsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowRVDocument.RowRV;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowRVDocument.RowRV.SezRVsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowRVsostDocument.RowRVsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowSCDocument.RowSC;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowSCDocument.RowSC.SezSCsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowSCcalDocument.RowSCcal;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowSCcalsostDocument.RowSCcalsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowSCsostDocument.RowSCsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowSRDocument.RowSR;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowSRDocument.RowSR.SezSRsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowSRsostDocument.RowSRsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowTEDocument.RowTE;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowTEDocument.RowTE.SezTEsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowTEsostDocument.RowTEsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowUTDocument.RowUT;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowUTDocument.RowUT.SezUTsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowUTsostDocument.RowUTsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowVMDocument.RowVM;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowVMDocument.RowVM.SezVMsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowVMsostDocument.RowVMsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowVRDocument.RowVR;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowVRDocument.RowVR.SezVRsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowVRsostDocument.RowVRsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowVasiDocument.RowVasi;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import it.csi.sitad.tpnm.entity.Indirizzo;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.bouncycastle.pqc.math.linearalgebra.BigEndianConversions;
import org.postgresql.util.PSQLException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.ctc.wstx.util.DataUtil;

/**
 * Manager del DB
 *
 * @author 70140
 */
public class DbMgr {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");

	// Definizione dei DAO

	private SigitDAutodichiarazioneDao sigitDAutodichiarazioneDao = null;


	public SigitDAutodichiarazioneDao getSigitDAutodichiarazioneDao() {
		return sigitDAutodichiarazioneDao;
	}

	public void setSigitDAutodichiarazioneDao(SigitDAutodichiarazioneDao sigitDAutodichiarazioneDao) {
		this.sigitDAutodichiarazioneDao = sigitDAutodichiarazioneDao;
	}

	private SigitRContr2019AutodichiarDao sigitRContr2019AutodichiarDao = null;

	public SigitRContr2019AutodichiarDao getSigitRContr2019AutodichiarDao() {
		return sigitRContr2019AutodichiarDao;
	}

	public void setSigitRContr2019AutodichiarDao(SigitRContr2019AutodichiarDao sigitRContr2019AutodichiarDao) {
		this.sigitRContr2019AutodichiarDao = sigitRContr2019AutodichiarDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_D_RUOLO
	 */
	private SigitDRuoloDao sigitDRuoloDao = null;

	public SigitDRuoloDao getSigitDRuoloDao() {
		return sigitDRuoloDao;
	}

	public void setSigitDRuoloDao(
			SigitDRuoloDao sigitDRuoloDao) {
		this.sigitDRuoloDao = sigitDRuoloDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_D_RUOLO_PA
	 */
	private SigitDRuoloPaDao sigitDRuoloPaDao = null;

	public SigitDRuoloPaDao getSigitDRuoloPaDao() {
		return sigitDRuoloPaDao;
	}

	public void setSigitDRuoloPaDao(
			SigitDRuoloPaDao sigitDRuoloPaDao) {
		this.sigitDRuoloPaDao = sigitDRuoloPaDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_D_RUOLO_ACCRED
	 */
	private SigitDRuoloAccredDao sigitDRuoloAccredDao = null;

	public SigitDRuoloAccredDao getSigitDRuoloAccredDao() {
		return sigitDRuoloAccredDao;
	}

	public void setSigitDRuoloAccredDao(
			SigitDRuoloAccredDao sigitAccredDRuoloDao) {
		this.sigitDRuoloAccredDao = sigitDRuoloAccredDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_D_DM37_2008
	 */
	/*
	private SigitDDm37_2008Dao sigitDDm37_2008Dao = null;

	public SigitDDm37_2008Dao getSigitDDm37_2008Dao() {
		return sigitDDm37_2008Dao;
	}

	public void setSigitDDm37_2008Dao(
			SigitDDm37_2008Dao sigitDm37_2008Dao) {
		this.sigitDDm37_2008Dao = sigitDDm37_2008Dao;
	}
	*/

	/**
	 * DAO per accedere alla tabella SIGIT_T_PERSONA_FISICA
	 */
	private SigitTPersonaFisicaDao sigitTPersonaFisicaDao = null;

	public SigitTPersonaFisicaDao getSigitTPersonaFisicaDao() {
		return sigitTPersonaFisicaDao;
	}

	public void setSigitTPersonaFisicaDao(
			SigitTPersonaFisicaDao sigitTPersonaFisicaDao) {
		this.sigitTPersonaFisicaDao = sigitTPersonaFisicaDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_PERSONA_GIURIDICA
	 */
	private SigitTPersonaGiuridicaDao sigitTPersonaGiuridicaDao = null;

	public SigitTPersonaGiuridicaDao getSigitTPersonaGiuridicaDao() {
		return sigitTPersonaGiuridicaDao;
	}

	public void setSigitTPersonaGiuridicaDao(
			SigitTPersonaGiuridicaDao sigitTPersonaGiuridicaDao) {
		this.sigitTPersonaGiuridicaDao = sigitTPersonaGiuridicaDao;
	}

	private SigitDFrequenzaManutDao sigitDFrequenzaManutDao = null;
	private SigitDClassDPR660_96Dao sigitDClassDPR660_96Dao = null;


	public SigitDFrequenzaManutDao getSigitDFrequenzaManutDao() {
		return sigitDFrequenzaManutDao;
	}

	public void setSigitDFrequenzaManutDao(SigitDFrequenzaManutDao sigitDFrequenzaManutDao) {
		this.sigitDFrequenzaManutDao = sigitDFrequenzaManutDao;
	}

	public SigitDClassDPR660_96Dao getSigitDClassDPR660_96Dao() {
		return sigitDClassDPR660_96Dao;
	}

	public void setSigitDClassDPR660_96Dao(SigitDClassDPR660_96Dao sigitDClassDPR660_96Dao) {
		this.sigitDClassDPR660_96Dao = sigitDClassDPR660_96Dao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_STORICO_STATI_PG
	 */
	private SigitTStoricoVarStatoPgDao sigitTStoricoVarStatoPgDao = null;

	public SigitTStoricoVarStatoPgDao getSigitTStoricoVarStatoPgDao() {
		return sigitTStoricoVarStatoPgDao;
	}

	public void setSigitTStoricoVarStatoPgDao(
			SigitTStoricoVarStatoPgDao sigitTStoricoVarStatoPgDao) {
		this.sigitTStoricoVarStatoPgDao = sigitTStoricoVarStatoPgDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_D_STATO_PG
	 */
	private SigitDStatoPgDao sigitDStatoPgDao = null;

	public SigitDStatoPgDao getSigitDStatoPgDao() {
		return sigitDStatoPgDao;
	}

	public void setSigitDStatoPgDao(
			SigitDStatoPgDao sigitDStatoPgDao) {
		this.sigitDStatoPgDao = sigitDStatoPgDao;
	}


	/**
	 * DAO per accedere alla tabella SIGIT_R_PF_PG_DELEGA
	 */
	private SigitRPfPgDelegaDao sigitRPfPgDelegaDao = null;

	public SigitRPfPgDelegaDao getSigitRPfPgDelegaDao() {
		return sigitRPfPgDelegaDao;
	}

	public void setSigitRPfPgDelegaDao(
			SigitRPfPgDelegaDao sigitRPfPgDelegaDao) {
		this.sigitRPfPgDelegaDao = sigitRPfPgDelegaDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_R_PF__RUOLO_PA
	 */
	private SigitRPfRuoloPaDao sigitRPfRuoloPaDao = null;

	public SigitRPfRuoloPaDao getSigitRPfRuoloPaDao() {
		return sigitRPfRuoloPaDao;
	}

	public void setSigitRPfRuoloPaDao(
			SigitRPfRuoloPaDao sigitRPfRuoloPaDao) {
		this.sigitRPfRuoloPaDao = sigitRPfRuoloPaDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_R_PG_PG_NOMINA
	 */
	private SigitRPgPgNominaDao sigitRPgPgNominaDao = null;

	public SigitRPgPgNominaDao getSigitRPgPgNominaDao() {
		return sigitRPgPgNominaDao;
	}

	public void setSigitRPgPgNominaDao(
			SigitRPgPgNominaDao sigitRPgPgNominaDao) {
		this.sigitRPgPgNominaDao = sigitRPgPgNominaDao;
	}

//	/**
//	 * DAO per accedere alla tabella SIGIT_T_TERZO_RESPONSABILE
//	 */
//	private SigitTTerzoResponsabileDao sigitTTerzoResponsabileDao = null;
//
//	public SigitTTerzoResponsabileDao getSigitTTerzoResponsabileDao() {
//		return sigitTTerzoResponsabileDao;
//	}
//
//	public void setSigitTTerzoResponsabileDao(
//			SigitTTerzoResponsabileDao sigitTTerzoResponsabileDao) {
//		this.sigitTTerzoResponsabileDao = sigitTTerzoResponsabileDao;
//	}
//
	/**
	 * DAO per accedere alla tabella SIGIT_D_STATO_IMP
	 */
	private SigitDStatoImpDao sigitDStatoImpDao = null;

	public SigitDStatoImpDao getSigitDStatoImpDao() {
		return sigitDStatoImpDao;
	}

	public void setSigitDStatoImpDao(
			SigitDStatoImpDao sigitDStatoImpDao) {
		this.sigitDStatoImpDao = sigitDStatoImpDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_CODICE_IMP
	 */
	/*
	private SigitTCodiceImpDao sigitTCodiceImpDao = null;

	public SigitTCodiceImpDao getSigitTCodiceImpDao() {
		return sigitTCodiceImpDao;
	}

	public void setSigitTCodiceImpDao(
			SigitTCodiceImpDao sigitTCodiceImpDao) {
		this.sigitTCodiceImpDao = sigitTCodiceImpDao;
	}
	*/

	/**
	 * DAO per accedere alla tabella SIGIT_T_CODICE_BOLL
	 */
	private SigitTCodiceBollDao sigitTCodiceBollDao = null;

	public SigitTCodiceBollDao getSigitTCodiceBollDao() {
		return sigitTCodiceBollDao;
	}

	public void setSigitTCodiceBollDao(
			SigitTCodiceBollDao sigitTCodiceBollDao) {
		this.sigitTCodiceBollDao = sigitTCodiceBollDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_IMPIANTO
	 */
	private SigitTImpiantoDao sigitTImpiantoDao = null;

	public SigitTImpiantoDao getSigitTImpiantoDao() {
		return sigitTImpiantoDao;
	}

	public void setSigitTImpiantoDao(
			SigitTImpiantoDao sigitTImpiantoDao) {
		this.sigitTImpiantoDao = sigitTImpiantoDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_UNITA_IMMOBILIARE
	 */
	private SigitTUnitaImmobiliareDao sigitTUnitaImmobiliareDao = null;

	public SigitTUnitaImmobiliareDao getSigitTUnitaImmobiliareDao() {
		return sigitTUnitaImmobiliareDao;
	}

	public void setSigitTUnitaImmobiliareDao(
			SigitTUnitaImmobiliareDao sigitTUnitaImmobiliareDao) {
		this.sigitTUnitaImmobiliareDao = sigitTUnitaImmobiliareDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_R_IMP_RUOLO_PFPG
	 */
	private SigitRImpRuoloPfpgDao sigitRImpRuoloPfpgDao = null;

	public SigitRImpRuoloPfpgDao getSigitRImpRuoloPfpgDao() {
		return sigitRImpRuoloPfpgDao;
	}

	public void setSigitRImpRuoloPfpgDao(
			SigitRImpRuoloPfpgDao sigitRImpRuoloPfpgDao) {
		this.sigitRImpRuoloPfpgDao = sigitRImpRuoloPfpgDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_R_ISPEZ_ISPET
	 */
	private SigitRIspezIspetDao sigitRIspezIspetDao = null;

	public SigitRIspezIspetDao getSigitRIspezIspetDao() {
		return sigitRIspezIspetDao;
	}

	public void setSigitRIspezIspetDao(
			SigitRIspezIspetDao sigitRIspezIspetDao) {
		this.sigitRIspezIspetDao = sigitRIspezIspetDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_R_COMP4_MANUT
	 */
	private SigitRComp4ManutDao sigitRComp4ManutDao = null;

	public SigitRComp4ManutDao getSigitRComp4ManutDao() {
		return sigitRComp4ManutDao;
	}

	public void setSigitRComp4ManutDao(
			SigitRComp4ManutDao sigitRComp4ManutDao) {
		this.sigitRComp4ManutDao = sigitRComp4ManutDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_R_COMP4MANUT_ALL
	 */
	private SigitRComp4ManutAllDao sigitRComp4ManutAllDao = null;

	public SigitRComp4ManutAllDao getSigitRComp4ManutAllDao() {
		return sigitRComp4ManutAllDao;
	}

	public void setSigitRComp4ManutAllDao(
			SigitRComp4ManutAllDao sigitRComp4ManutAllDao) {
		this.sigitRComp4ManutAllDao = sigitRComp4ManutAllDao;
	}


	/**
	 * DAO per accedere alla tabella SIGIT_T_TRANSAZIONE_IMP
	 */
	/*
	private SigitTTransazioneImpDao sigitTTransazioneImpDao = null;

	public SigitTTransazioneImpDao getSigitTTransazioneImpDao() {
		return sigitTTransazioneImpDao;
	}

	public void setSigitTTransazioneImpDao(
			SigitTTransazioneImpDao sigitTTransazioneImpDao) {
		this.sigitTTransazioneImpDao = sigitTTransazioneImpDao;
	}
	*/

	/**
	 * DAO per accedere alla tabella SIGIT_T_TRANSAZIONE_BOLL
	 */
	/*
	private SigitTTransazioneBollDao sigitTTransazioneBollDao = null;

	public SigitTTransazioneBollDao getSigitTTransazioneBollDao() {
		return sigitTTransazioneBollDao;
	}

	public void setSigitTTransazioneBollDao(
			SigitTTransazioneBollDao sigitTTransazioneBollDao) {
		this.sigitTTransazioneBollDao = sigitTTransazioneBollDao;
	}
	*/

	/**
	 * DAO per accedere alla tabella SIGIT_R_TRANS_ACQ_BOLL_QTA
	 */
	/*
	private SigitRTransAcqBollQtaDao sigitRTransAcqBollQtaDao = null;

	public SigitRTransAcqBollQtaDao getSigitRTransAcqBollQtaDao() {
		return sigitRTransAcqBollQtaDao;
	}

	public void setSigitRTransAcqBollQtaDao(
			SigitRTransAcqBollQtaDao sigitRTransAcqBollQtaDao) {
		this.sigitRTransAcqBollQtaDao = sigitRTransAcqBollQtaDao;
	}
	*/

	/**
	 * DAO per accedere alla tabella SIGIT_T_LIBRETTO
	 */
	private SigitTLibrettoDao sigitTLibrettoDao = null;
	private SigitSLibrettoDao sigitSLibrettoDao = null;
	private SigitTLibTxtDao sigitTLibTxtDao;

	public SigitTLibTxtDao getSigitTLibTxtDao() {
		return sigitTLibTxtDao;
	}

	public void setSigitTLibTxtDao(SigitTLibTxtDao sigitTLibTxtDao) {
		this.sigitTLibTxtDao = sigitTLibTxtDao;
	}

	public SigitTLibrettoDao getSigitTLibrettoDao() {
		return sigitTLibrettoDao;
	}

	public void setSigitTLibrettoDao(
			SigitTLibrettoDao sigitTLibrettoDao) {
		this.sigitTLibrettoDao = sigitTLibrettoDao;
	}

	public SigitSLibrettoDao getSigitSLibrettoDao() {
		return sigitSLibrettoDao;
	}

	public void setSigitSLibrettoDao(
			SigitSLibrettoDao sigitSLibrettoDao) {
		this.sigitSLibrettoDao = sigitSLibrettoDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_ALLEGATO
	 */
	private SigitTAllegatoDao sigitTAllegatoDao = null;

	public SigitTAllegatoDao getSigitTAllegatoDao() {
		return sigitTAllegatoDao;
	}
	public void setSigitTAllegatoDao(
			SigitTAllegatoDao sigitTAllegatoDao) {
		this.sigitTAllegatoDao = sigitTAllegatoDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_S_ALLEGATO
	 */
	private SigitSAllegatoDao sigitSAllegatoDao = null;

	public SigitSAllegatoDao getSigitSAllegatoDao() {
		return sigitSAllegatoDao;
	}

	public void setSigitSAllegatoDao(
			SigitSAllegatoDao sigitSAllegatoDao) {
		this.sigitSAllegatoDao = sigitSAllegatoDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_ALL_TXT
	 */
	private SigitTAllTxtDao sigitTAllTxtDao = null;

	public SigitTAllTxtDao getSigitTAllTxtDao() {
		return sigitTAllTxtDao;
	}

	public void setSigitTAllTxtDao(
			SigitTAllTxtDao sigitTAllTxtDao) {
		this.sigitTAllTxtDao = sigitTAllTxtDao;
	}



	//////////////////////////////////////


	/**
	 * DAO per accedere alla tabella SIGIT_R_ALLEGATO_COMP_CG
	 */
	private SigitRAllegatoCompCgDao sigitRAllegatoCompCgDao = null;

	public SigitRAllegatoCompCgDao getSigitRAllegatoCompCgDao() {
		return sigitRAllegatoCompCgDao;
	}

	public void setSigitRAllegatoCompCgDao(
			SigitRAllegatoCompCgDao sigitRAllegatoCompCgDao) {
		this.sigitRAllegatoCompCgDao = sigitRAllegatoCompCgDao;
	}


	/**
	 * DAO per accedere alla tabella SIGIT_R_ALLEGATO_COMP_GF
	 */
	private SigitRAllegatoCompGfDao sigitRAllegatoCompGfDao = null;

	public SigitRAllegatoCompGfDao getSigitRAllegatoCompGfDao() {
		return sigitRAllegatoCompGfDao;
	}

	public void setSigitRAllegatoCompGfDao(
			SigitRAllegatoCompGfDao sigitRAllegatoCompGfDao) {
		this.sigitRAllegatoCompGfDao = sigitRAllegatoCompGfDao;
	}


	/**
	 * DAO per accedere alla tabella SIGIT_R_ALLEGATO_COMP_GT
	 */
	private SigitRAllegatoCompGtDao sigitRAllegatoCompGtDao = null;

	public SigitRAllegatoCompGtDao getSigitRAllegatoCompGtDao() {
		return sigitRAllegatoCompGtDao;
	}

	public void setSigitRAllegatoCompGtDao(
			SigitRAllegatoCompGtDao sigitRAllegatoCompGtDao) {
		this.sigitRAllegatoCompGtDao = sigitRAllegatoCompGtDao;
	}


	/**
	 * DAO per accedere alla tabella SIGIT_R_ALLEGATO_COMP_SC
	 */
	private SigitRAllegatoCompScDao sigitRAllegatoCompScDao = null;

	public SigitRAllegatoCompScDao getSigitRAllegatoCompScDao() {
		return sigitRAllegatoCompScDao;
	}

	public void setSigitRAllegatoCompScDao(
			SigitRAllegatoCompScDao sigitRAllegatoCompScDao) {
		this.sigitRAllegatoCompScDao = sigitRAllegatoCompScDao;
	}


	//////////////////////////////////////


	/**
	 * DAO per accedere alla tabella SIGIT_T_ALL_RESPINTO
	 */
	/*
	private SigitTAllRespintoDao sigitTAllRespintoDao = null;

	public SigitTAllRespintoDao getSigitTAllRespintoDao() {
		return sigitTAllRespintoDao;
	}

	public void setSigitTAllRespintoDao(
			SigitTAllRespintoDao sigitTAllRespintoDao) {
		this.sigitTAllRespintoDao = sigitTAllRespintoDao;
	}
	*/

	/**
	 * DAO per accedere alla tabella SIGIT_T_ALL_RESPTXT
	 */
	/*
	private SigitTAllRespTxtDao sigitTAllRespTxtDao = null;

	public SigitTAllRespTxtDao getSigitTAllRespTxtDao() {
		return sigitTAllRespTxtDao;
	}

	public void setSigitTAllRespTxtDao(
			SigitTAllRespTxtDao sigitTAllRespTxtDao) {
		this.sigitTAllRespTxtDao = sigitTAllRespTxtDao;
	}
	*/

	private SigitTAccertamentoDao sigitTAccertamentoDao = null;
	private SigitTIspezione2018Dao sigitTIspezione2018Dao = null;
	private SigitTSanzioneDao sigitTSanzioneDao = null;

	public SigitTAccertamentoDao getSigitTAccertamentoDao() {
		return sigitTAccertamentoDao;
	}

	public void setSigitTAccertamentoDao(SigitTAccertamentoDao sigitTAccertamentoDao) {
		this.sigitTAccertamentoDao = sigitTAccertamentoDao;
	}

	public SigitTIspezione2018Dao getSigitTIspezione2018Dao() {
		return sigitTIspezione2018Dao;
	}

	public void setSigitTIspezione2018Dao(SigitTIspezione2018Dao sigitTIspezione2018Dao) {
		this.sigitTIspezione2018Dao = sigitTIspezione2018Dao;
	}

	public SigitTSanzioneDao getSigitTSanzioneDao() {
		return sigitTSanzioneDao;
	}

	public void setSigitTSanzioneDao(SigitTSanzioneDao sigitTSanzioneDao) {
		this.sigitTSanzioneDao = sigitTSanzioneDao;
	}

//	/**
//	 * DAO per accedere alla tabella SIGIT_T_ISPEZIONE
//	 */
//	private SigitTIspezioneDao sigitTIspezioneDao = null;
//
//	public SigitTIspezioneDao getSigitTIspezioneDao() {
//		return sigitTIspezioneDao;
//	}
//
//	public void setSigitTIspezioneDao(
//			SigitTIspezioneDao sigitTIspezioneDao) {
//		this.sigitTIspezioneDao = sigitTIspezioneDao;
//	}

	/**
	 * DAO per accedere alla tabella SIGIT_WRK_CONFIG
	 */
	private SigitWrkConfigDao sigitWrkConfigDao = null;

	public SigitWrkConfigDao getSigitWrkConfigDao() {
		return sigitWrkConfigDao;
	}

	public void setSigitWrkConfigDao(
			SigitWrkConfigDao sigitWrkConfigDao) {
		this.sigitWrkConfigDao = sigitWrkConfigDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_WRK_RUOLO_FUNZ
	 */
	private SigitWrkRuoloFunzDao sigitWrkRuoloFunzDao = null;

	public SigitWrkRuoloFunzDao getSigitWrkRuoloFunzDao() {
		return sigitWrkRuoloFunzDao;
	}

	public void setSigitWrkRuoloFunzDao(
			SigitWrkRuoloFunzDao sigitWrkRuoloFunzDao) {
		this.sigitWrkRuoloFunzDao = sigitWrkRuoloFunzDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_WRK_LOG
	 */
	private SigitWrkLogDao sigitWrkLogDao = null;

	public SigitWrkLogDao getSigitWrkLogDao() {
		return sigitWrkLogDao;
	}

	public void setSigitWrkLogDao(
			SigitWrkLogDao sigitWrkLogDao) {
		this.sigitWrkLogDao = sigitWrkLogDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_WRK_LOG_PREC
	 */
	private SigitWrkLogPrecDao sigitWrkLogPrecDao = null;

	public SigitWrkLogPrecDao getSigitWrkLogPrecDao() {
		return sigitWrkLogPrecDao;
	}

	public void setSigitWrkLogPrecDao(
			SigitWrkLogPrecDao sigitWrkLogPrecDao) {
		this.sigitWrkLogPrecDao = sigitWrkLogPrecDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_EXT_DAO
	 */
	private SigitExtDao sigitExtDao = null;

	public SigitExtDao getSigitExtDao() {
		return sigitExtDao;
	}

	public void setSigitExtDao(
			SigitExtDao sigitExtDao) {
		this.sigitExtDao = sigitExtDao;
	}


	/**
	 * DAO per accedere alla tabella VISTA_PF_PG
	 */
	private SigitVPfPgDao sigitVPfPgDao = null;

	public SigitVPfPgDao getSigitVPfPgDao() {
		return sigitVPfPgDao;
	}

	public void setSigitVPfPgDao(
			SigitVPfPgDao sigitVPfPgDao) {
		this.sigitVPfPgDao = sigitVPfPgDao;
	}


	/**
	 * DAO per accedere alla tabella VISTA_ALLEGATI_COMPONENTI
	 */
	private SigitVAllegatiComponentiDao sigitVAllegatiComponentiDao = null;

	public SigitVAllegatiComponentiDao getSigitVAllegatiComponentiDao() {
		return sigitVAllegatiComponentiDao;
	}

	public void setSigitVAllegatiComponentiDao(
			SigitVAllegatiComponentiDao sigitVAllegatiComponentiDao) {
		this.sigitVAllegatiComponentiDao = sigitVAllegatiComponentiDao;
	}

	/**
	 * DAO per accedere alla tabella VISTA_TOT_IMPIANTO
	 */
	private SigitVTotImpiantoDao sigitVTotImpiantoDao = null;

	public SigitVTotImpiantoDao getSigitVTotImpiantoDao() {
		return sigitVTotImpiantoDao;
	}

	public void setSigitVTotImpiantoDao(
			SigitVTotImpiantoDao sigitVTotImpiantoDao) {
		this.sigitVTotImpiantoDao = sigitVTotImpiantoDao;
	}

	/**
	 * DAO per accedere alla tabella VISTA_POTENZA_PREZZO
	 */
	private SigitVPotenzaPrezzoDao sigitVPotenzaPrezzoDao = null;

	public SigitVPotenzaPrezzoDao getSigitVPotenzaPrezzoDao() {
		return sigitVPotenzaPrezzoDao;
	}

	public void setSigitVPotenzaPrezzoDao(
			SigitVPotenzaPrezzoDao sigitVPotenzaPrezzoDao) {
		this.sigitVPotenzaPrezzoDao = sigitVPotenzaPrezzoDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_D_STATO_RAPP
	 */
	private SigitDStatoRappDao sigitDStatoRappDao = null;

	public SigitDStatoRappDao getSigitDStatoRappDao() {
		return sigitDStatoRappDao;
	}

	public void setSigitDStatoRappDao(SigitDStatoRappDao sigitDStatoRappDao) {
		this.sigitDStatoRappDao = sigitDStatoRappDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_D_TIPO_INTERVENTO
	 */
	private SigitDTipoInterventoDao sigitDTipoInterventoDao = null;

	public SigitDTipoInterventoDao getSigitDTipoInterventoDao() {
		return sigitDTipoInterventoDao;
	}

	public void setSigitDTipoInterventoDao(SigitDTipoInterventoDao sigitDTipoInterventoDao) {
		this.sigitDTipoInterventoDao = sigitDTipoInterventoDao;
	}


	/**
	 * DAO per accedere alla tabella SIGIT_D_TIPO_DOCUMENTO
	 */
	private SigitDTipoDocumentoDao sigitDTipoDocumentoDao = null;


	public SigitDTipoDocumentoDao getSigitDTipoDocumentoDao() {
		return sigitDTipoDocumentoDao;
	}

	public void setSigitDTipoDocumentoDao(
			SigitDTipoDocumentoDao sigitDTipoDocumentoDao) {
		this.sigitDTipoDocumentoDao = sigitDTipoDocumentoDao;
	}


	/**
	 * DAO per accedere alla tabella SIGIT_D_TIPO_MANUTENZIONE
	 */
	private SigitDTipoManutenzioneDao sigitDTipoManutenzioneDao = null;


	public SigitDTipoManutenzioneDao getSigitDTipoManutenzioneDao() {
		return sigitDTipoManutenzioneDao;
	}

	public void setSigitDTipoManutenzioneDao(
			SigitDTipoManutenzioneDao sigitDTipoManutenzioneDao) {
		this.sigitDTipoManutenzioneDao = sigitDTipoManutenzioneDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_D_TIPO_DOC_AGG
	 */
	private SigitDTipoDocAggDao sigitDTipoDocAggDao = null;


	public SigitDTipoDocAggDao getSigitDTipoDocAggDao() {
		return sigitDTipoDocAggDao;
	}

	public void setSigitDTipoDocAggDao(
			SigitDTipoDocAggDao sigitDTipoDocAggDao) {
		this.sigitDTipoDocAggDao = sigitDTipoDocAggDao;
	}


	/**
	 * DAO per accedere alla tabella SIGIT_T_TRATT_H2O
	 */
	private SigitTTrattH2ODao sigitTTrattH2oDao = null;

	public SigitTTrattH2ODao getSigitTTrattH2oDao() {
		return sigitTTrattH2oDao;
	}

	public void setSigitTTrattH2oDao(SigitTTrattH2ODao sigitTTrattH2oDao) {
		this.sigitTTrattH2oDao = sigitTTrattH2oDao;
	}

	/**
	 * DAO per accedere alla tabella VISTA_RICERCA_COMP
	 */
	private SigitVRicercaCompDao sigitVRicercaCompDao = null;

	public SigitVRicercaCompDao getSigitVRicercaCompDao() {
		return sigitVRicercaCompDao;
	}

	public void setSigitVRicercaCompDao(
			SigitVRicercaCompDao sigitVRicercaCompDao) {
		this.sigitVRicercaCompDao = sigitVRicercaCompDao;
	}

	private SigitTComp4Dao sigitTComp4Dao;
	private SigitTCompGtDao sigittCompGtDao;
	private SigitTCompBrRcDao sigitTCompBrRcDao;
	private SigitTCompGfDao sigitTCompGfDao;
	private SigitTCompCgDao sigitTCompCgDao;
	private SigitTCompCsDao sigitTCompCsDao;
	private SigitTCompAgDao sigitTCompAgDao;
	private SigitTCompScDao sigitTCompScDao;
	private SigitVCompGtDettDao sigitVCompGtDettDao;
	private SigitVCompGfDettDao sigitVCompGfDettDao;
	private SigitVCompScDettDao sigitVCompScDettDao;
	private SigitVCompCgDettDao sigitVCompCgDettDao;
	private SigitVCompGtDao sigitVCompGtDao;
	private SigitVCompGfDao sigitVCompGfDao;
	private SigitVCompCgDao sigitVCompCgDao;
	//private SigitVCompGfDao sigitVCompGfDao;
	//private SigitVCompScDao sigitVCompScDao;
	private SigitVCompAgDao sigitVCompAgDao;
	private SigitVCompCsDao sigitVCompCsDao;
	private SigitDCombustibileDao sigitDCombustibileDao;
	private SigitDTipoCannaFumariaDao sigitDTipoCannaFumariaDao;
	private SigitDFonteEnSfruttataDao sigitDFonteEnSfruttataDao;
	private SigitDDettaglioVmDao sigitDDettaglioVmDao;
	private SigitDDettaglioGtDao sigitDDettaglioGtDao;
	private SigitDDettaglioGfDao sigitDDettaglioGfDao;
	private SigitDFluidoDao sigitDFluidoDao;
	private SigitDMarcaDao sigitDMarcaDao;
	private SigitDUnitaMisuraDao sigitDUnitaMisuraDao;
	private SigitTCompXDao sigitTCompXDao;
	private SigitTCompXSempliceDao sigitTCompXSempliceDao;
	private SigitTCompSrDao sigitTCompSrDao;
	private SigitTCompVrDao sigitTCompVrDao;
	private SigitTCompPoDao sigitTCompPoDao;
	private SigitTCompAcDao sigitTCompAcDao;
	private SigitTCompTeDao sigitTCompTeDao;
	private SigitTCompRvDao sigitTCompRvDao;
	private SigitTCompScxDao sigitTCompScxDao;
	private SigitTCompCiDao sigitTCompCiDao;
	private SigitTCompUtDao sigitTCompUtDao;
	private SigitTCompRcDao sigitTCompRcDao;
	private SigitTCompVmDao sigitTCompVmDao;
	private SigitTCompVxDao sigitTCompVxDao;
	private SigitTConsumoDao sigitTConsumoDao;
	private SigitTConsumo14_4Dao sigitTConsumo144Dao;
	private SigitVCompSrDao sigitVCompSrDao;
	private SigitVCompVrDao sigitVCompVrDao;
	private SigitVCompPoDao sigitVCompPoDao;
	private SigitVCompAcDao sigitVCompAcDao;
	private SigitVCompTeDao sigitVCompTeDao;
	private SigitVCompRvDao sigitVCompRvDao;
	private SigitVCompScxDao sigitVCompScxDao;
	private SigitVCompCiDao sigitVCompCiDao;
	private SigitVCompUtDao sigitVCompUtDao;
	private SigitVCompRcDao sigitVCompRcDao;
	private SigitVCompVmDao sigitVCompVmDao;

	private SigitTmpLibrettoDao sigitTmpLibrettoDao;

	private SigitTPreImportDao sigitTPreImportDao;
	private SigitTImportDao sigitTImportDao;
	private SigitTImpXmlDao sigitTImpXmlDao;

	private SigitVSk4GtDao sigitVSk4GtDao;
	private SigitVSk4GfDao sigitVSk4GfDao;
	private SigitVSk4CgDao sigitVSk4CgDao;
	private SigitVSk4ScDao sigitVSk4ScDao;
	private SigitVRicerca3ResponsabileDao sigitVRicerca3ResponsabileDao;
	private SigitTImportXmlLibDao sigitTImportXmlLibDao;

	private SigitTDocAggiuntivaDao sigitTDocAggiuntivaDao;
	private SigitTDocAllegatoDao sigitTDocAllegatoDao;

	private SigitTControlloLibrettoDao sigitTControlloLibrettoDao;

	private SigitDTipoContrattoDistribDao sigitDTipoContrattoDistribDao;
	private SigitDCategoriaUtilDao sigitDCategoriaUtilDao;

	public SigitTImpXmlDao getSigitTImpXmlDao() {
		return sigitTImpXmlDao;
	}

	public void setSigitTImpXmlDao(SigitTImpXmlDao sigitTImpXmlDao) {
		this.sigitTImpXmlDao = sigitTImpXmlDao;
	}

	public SigitTPreImportDao getSigitTPreImportDao() {
		return sigitTPreImportDao;
	}

	public void setSigitTPreImportDao(SigitTPreImportDao sigitTPreImportDao) {
		this.sigitTPreImportDao = sigitTPreImportDao;
	}

	public SigitTImportDao getSigitTImportDao() {
		return sigitTImportDao;
	}

	public void setSigitTImportDao(SigitTImportDao sigitTImportDao) {
		this.sigitTImportDao = sigitTImportDao;
	}

	public SigitTImportXmlLibDao getSigitTImportXmlLibDao() {
		return sigitTImportXmlLibDao;
	}

	public void setSigitTImportXmlLibDao(SigitTImportXmlLibDao sigitTImportXmlLibDao) {
		this.sigitTImportXmlLibDao = sigitTImportXmlLibDao;
	}

	public SigitTmpLibrettoDao getSigitTmpLibrettoDao() {
		return sigitTmpLibrettoDao;
	}

	public void setSigitTmpLibrettoDao(SigitTmpLibrettoDao sigitTmpLibrettoDao) {
		this.sigitTmpLibrettoDao = sigitTmpLibrettoDao;
	}

	public SigitVCompCiDao getSigitVCompCiDao() {
		return sigitVCompCiDao;
	}

	public void setSigitVCompCiDao(SigitVCompCiDao sigitVCompCiDao) {
		this.sigitVCompCiDao = sigitVCompCiDao;
	}

	public SigitVCompUtDao getSigitVCompUtDao() {
		return sigitVCompUtDao;
	}

	public void setSigitVCompUtDao(SigitVCompUtDao sigitVCompUtDao) {
		this.sigitVCompUtDao = sigitVCompUtDao;
	}

	public SigitVCompRcDao getSigitVCompRcDao() {
		return sigitVCompRcDao;
	}

	public void setSigitVCompRcDao(SigitVCompRcDao sigitVCompRcDao) {
		this.sigitVCompRcDao = sigitVCompRcDao;
	}

	public SigitVCompVmDao getSigitVCompVmDao() {
		return sigitVCompVmDao;
	}

	public void setSigitVCompVmDao(SigitVCompVmDao sigitVCompVmDao) {
		this.sigitVCompVmDao = sigitVCompVmDao;
	}

	public SigitVCompAcDao getSigitVCompAcDao() {
		return sigitVCompAcDao;
	}

	public void setSigitVCompAcDao(SigitVCompAcDao sigitVCompAcDao) {
		this.sigitVCompAcDao = sigitVCompAcDao;
	}

	public SigitVCompTeDao getSigitVCompTeDao() {
		return sigitVCompTeDao;
	}

	public void setSigitVCompTeDao(SigitVCompTeDao sigitVCompTeDao) {
		this.sigitVCompTeDao = sigitVCompTeDao;
	}

	public SigitVCompRvDao getSigitVCompRvDao() {
		return sigitVCompRvDao;
	}

	public void setSigitVCompRvDao(SigitVCompRvDao sigitVCompRvDao) {
		this.sigitVCompRvDao = sigitVCompRvDao;
	}

	public SigitVCompScxDao getSigitVCompScxDao() {
		return sigitVCompScxDao;
	}

	public void setSigitVCompScxDao(SigitVCompScxDao sigitVCompScxDao) {
		this.sigitVCompScxDao = sigitVCompScxDao;
	}

	public SigitVCompPoDao getSigitVCompPoDao() {
		return sigitVCompPoDao;
	}

	public void setSigitVCompPoDao(SigitVCompPoDao sigitVCompPoDao) {
		this.sigitVCompPoDao = sigitVCompPoDao;
	}

	public SigitVCompSrDao getSigitVCompSrDao() {
		return sigitVCompSrDao;
	}

	public void setSigitVCompSrDao(SigitVCompSrDao sigitVCompSrDao) {
		this.sigitVCompSrDao = sigitVCompSrDao;
	}

	public SigitVCompVrDao getSigitVCompVrDao() {
		return sigitVCompVrDao;
	}

	public void setSigitVCompVrDao(SigitVCompVrDao sigitVCompVrDao) {
		this.sigitVCompVrDao = sigitVCompVrDao;
	}

	public SigitTConsumoDao getSigitTConsumoDao() {
		return sigitTConsumoDao;
	}

	public void setSigitTConsumoDao(SigitTConsumoDao sigitTConsumoDao) {
		this.sigitTConsumoDao = sigitTConsumoDao;
	}

	public SigitTConsumo14_4Dao getSigitTConsumo144Dao() {
		return sigitTConsumo144Dao;
	}

	public void setSigitTConsumo144Dao(SigitTConsumo14_4Dao sigitTConsumo144Dao) {
		this.sigitTConsumo144Dao = sigitTConsumo144Dao;
	}

	public SigitTCompVxDao getSigitTCompVxDao() {
		return sigitTCompVxDao;
	}

	public void setSigitTCompVxDao(SigitTCompVxDao sigitTCompVxDao) {
		this.sigitTCompVxDao = sigitTCompVxDao;
	}

	public SigitTCompAcDao getSigitTCompAcDao() {
		return sigitTCompAcDao;
	}

	public void setSigitTCompAcDao(SigitTCompAcDao sigitTCompAcDao) {
		this.sigitTCompAcDao = sigitTCompAcDao;
	}

	public SigitTCompTeDao getSigitTCompTeDao() {
		return sigitTCompTeDao;
	}

	public void setSigitTCompTeDao(SigitTCompTeDao sigitTCompTeDao) {
		this.sigitTCompTeDao = sigitTCompTeDao;
	}

	public SigitTCompRvDao getSigitTCompRvDao() {
		return sigitTCompRvDao;
	}

	public void setSigitTCompRvDao(SigitTCompRvDao sigitTCompRvDao) {
		this.sigitTCompRvDao = sigitTCompRvDao;
	}

	public SigitTCompScxDao getSigitTCompScxDao() {
		return sigitTCompScxDao;
	}

	public void setSigitTCompScxDao(SigitTCompScxDao sigitTCompScxDao) {
		this.sigitTCompScxDao = sigitTCompScxDao;
	}

	public SigitTCompCiDao getSigitTCompCiDao() {
		return sigitTCompCiDao;
	}

	public void setSigitTCompCiDao(SigitTCompCiDao sigitTCompCiDao) {
		this.sigitTCompCiDao = sigitTCompCiDao;
	}

	public SigitTCompUtDao getSigitTCompUtDao() {
		return sigitTCompUtDao;
	}

	public void setSigitTCompUtDao(SigitTCompUtDao sigitTCompUtDao) {
		this.sigitTCompUtDao = sigitTCompUtDao;
	}

	public SigitTCompRcDao getSigitTCompRcDao() {
		return sigitTCompRcDao;
	}

	public void setSigitTCompRcDao(SigitTCompRcDao sigitTCompRcDao) {
		this.sigitTCompRcDao = sigitTCompRcDao;
	}

	public SigitTCompVmDao getSigitTCompVmDao() {
		return sigitTCompVmDao;
	}

	public void setSigitTCompVmDao(SigitTCompVmDao sigitTCompVmDao) {
		this.sigitTCompVmDao = sigitTCompVmDao;
	}

	public SigitTCompPoDao getSigitTCompPoDao() {
		return sigitTCompPoDao;
	}

	public void setSigitTCompPoDao(SigitTCompPoDao sigitTCompPoDao) {
		this.sigitTCompPoDao = sigitTCompPoDao;
	}

	public SigitTCompXDao getSigitTCompXDao() {
		return sigitTCompXDao;
	}

	public void setSigitTCompXDao(SigitTCompXDao sigitTCompXDao) {
		this.sigitTCompXDao = sigitTCompXDao;
	}

	public SigitTCompXSempliceDao getSigitTCompXSempliceDao() {
		return sigitTCompXSempliceDao;
	}

	public void setSigitTCompXSempliceDao(
			SigitTCompXSempliceDao sigitTCompXSempliceDao) {
		this.sigitTCompXSempliceDao = sigitTCompXSempliceDao;
	}

	public SigitTCompSrDao getSigitTCompSrDao() {
		return sigitTCompSrDao;
	}

	public void setSigitTCompSrDao(SigitTCompSrDao sigitTCompSrDao) {
		this.sigitTCompSrDao = sigitTCompSrDao;
	}

	public SigitTCompVrDao getSigitTCompVrDao() {
		return sigitTCompVrDao;
	}

	public void setSigitTCompVrDao(SigitTCompVrDao sigitTCompVrDao) {
		this.sigitTCompVrDao = sigitTCompVrDao;
	}

	public SigitDCombustibileDao getSigitDCombustibileDao() {
		return sigitDCombustibileDao;
	}

	public void setSigitDCombustibileDao(SigitDCombustibileDao sigitDCombustibileDao) {
		this.sigitDCombustibileDao = sigitDCombustibileDao;
	}

	public SigitDTipoCannaFumariaDao getSigitDTipoCannaFumariaDao() {
		return sigitDTipoCannaFumariaDao;
	}

	public void setSigitDTipoCannaFumariaDao(SigitDTipoCannaFumariaDao sigitDTipoCannaFumariaDao) {
		this.sigitDTipoCannaFumariaDao = sigitDTipoCannaFumariaDao;
	}

	public SigitDFonteEnSfruttataDao getSigitDFonteEnSfruttataDao() {
		return sigitDFonteEnSfruttataDao;
	}

	public void setSigitDFonteEnSfruttataDao(SigitDFonteEnSfruttataDao sigitDFonteEnSfruttataDao) {
		this.sigitDFonteEnSfruttataDao = sigitDFonteEnSfruttataDao;
	}


	public SigitDFluidoDao getSigitDFluidoDao() {
		return sigitDFluidoDao;
	}

	public void setSigitDFluidoDao(SigitDFluidoDao sigitDFluidoDao) {
		this.sigitDFluidoDao = sigitDFluidoDao;
	}

	public SigitDMarcaDao getSigitDMarcaDao() {
		return sigitDMarcaDao;
	}

	public void setSigitDMarcaDao(SigitDMarcaDao sigitDMarcaDao) {
		this.sigitDMarcaDao = sigitDMarcaDao;
	}

	public SigitDDettaglioVmDao getSigitDDettaglioVmDao() {
		return sigitDDettaglioVmDao;
	}

	public void setSigitDDettaglioVmDao(SigitDDettaglioVmDao sigitDDettaglioGtDao) {
		this.sigitDDettaglioVmDao = sigitDDettaglioGtDao;
	}

	public SigitDDettaglioGtDao getSigitDDettaglioGtDao() {
		return sigitDDettaglioGtDao;
	}

	public void setSigitDDettaglioGtDao(SigitDDettaglioGtDao sigitDDettaglioGtDao) {
		this.sigitDDettaglioGtDao = sigitDDettaglioGtDao;
	}

	public SigitDDettaglioGfDao getSigitDDettaglioGfDao() {
		return sigitDDettaglioGfDao;
	}

	public void setSigitDDettaglioGfDao(SigitDDettaglioGfDao sigitDDettaglioGfDao) {
		this.sigitDDettaglioGfDao = sigitDDettaglioGfDao;
	}

	public SigitVCompScDettDao getSigitVCompScDettDao() {
		return sigitVCompScDettDao;
	}

	public void setSigitVCompScDettDao(SigitVCompScDettDao sigitVCompScDettDao) {
		this.sigitVCompScDettDao = sigitVCompScDettDao;
	}

	public SigitVCompAgDao getSigitVCompAgDao() {
		return sigitVCompAgDao;
	}

	public void setSigitVCompAgDao(SigitVCompAgDao sigitVCompAgDao) {
		this.sigitVCompAgDao = sigitVCompAgDao;
	}

	public SigitVCompCsDao getSigitVCompCsDao() {
		return sigitVCompCsDao;
	}

	public void setSigitVCompCsDao(SigitVCompCsDao sigitVCompCsDao) {
		this.sigitVCompCsDao = sigitVCompCsDao;
	}

	public SigitVCompCgDettDao getSigitVCompCgDettDao() {
		return sigitVCompCgDettDao;
	}

	public void setSigitVCompCgDettDao(SigitVCompCgDettDao sigitVCompCgDettDao) {
		this.sigitVCompCgDettDao = sigitVCompCgDettDao;
	}

	public SigitVCompGfDettDao getSigitVCompGfDettDao() {
		return sigitVCompGfDettDao;
	}

	public void setSigitVCompGfDettDao(SigitVCompGfDettDao sigitVCompGfDettDao) {
		this.sigitVCompGfDettDao = sigitVCompGfDettDao;
	}

	public SigitVCompGtDettDao getSigitVCompGtDettDao() {
		return sigitVCompGtDettDao;
	}

	public void setSigitVCompGtDettDao(SigitVCompGtDettDao sigitVCompGtDettDao) {
		this.sigitVCompGtDettDao = sigitVCompGtDettDao;
	}

	public SigitVCompGtDao getSigitVCompGtDao() {
		return sigitVCompGtDao;
	}

	public void setSigitVCompGtDao(SigitVCompGtDao sigitVCompGtDao) {
		this.sigitVCompGtDao = sigitVCompGtDao;
	}



	public SigitVCompCgDao getSigitVCompCgDao() {
		return sigitVCompCgDao;
	}

	public void setSigitVCompCgDao(SigitVCompCgDao sigitVCompCgDao) {
		this.sigitVCompCgDao = sigitVCompCgDao;
	}

	/*
	public SigitVCompGfDao getSigitVCompGfDao() {
		return sigitVCompGfDao;
	}

	public void setSigitVCompGfDao(SigitVCompGfDao sigitVCompGfDao) {
		this.sigitVCompGfDao = sigitVCompGfDao;
	}


	public SigitVCompScDao getSigitVCompScDao() {
		return sigitVCompScDao;
	}

	public void setSigitVCompScDao(SigitVCompScDao sigitVCompScDao) {
		this.sigitVCompScDao = sigitVCompScDao;
	}
	*/












	public SigitVSk4GtDao getSigitVSk4GtDao() {
		return sigitVSk4GtDao;
	}

	public void setSigitVSk4GtDao(SigitVSk4GtDao sigitVSk4GtDao) {
		this.sigitVSk4GtDao = sigitVSk4GtDao;
	}

	public void setSigitVSk4GfDao(SigitVSk4GfDao sigitVSk4GfDao) {
		this.sigitVSk4GfDao = sigitVSk4GfDao;
	}

	public SigitVSk4GfDao getSigitVSk4GfDao() {
		return sigitVSk4GfDao;
	}

	public void setSigitVSk4CgDao(SigitVSk4CgDao sigitVSk4CgDao) {
		this.sigitVSk4CgDao = sigitVSk4CgDao;
	}

	public SigitVSk4CgDao getSigitVSk4CgDao() {
		return sigitVSk4CgDao;
	}

	public void setSigitVSk4ScDao(SigitVSk4ScDao sigitVSk4ScDao) {
		this.sigitVSk4ScDao = sigitVSk4ScDao;
	}

	public SigitVSk4ScDao getSigitVSk4ScDao() {
		return sigitVSk4ScDao;
	}

	public SigitTCompScDao getSigitTCompScDao() {
		return sigitTCompScDao;
	}

	public void setSigitTCompScDao(SigitTCompScDao sigitTCompScDao) {
		this.sigitTCompScDao = sigitTCompScDao;
	}

	public SigitTCompAgDao getSigitTCompAgDao() {
		return sigitTCompAgDao;
	}

	public void setSigitTCompAgDao(SigitTCompAgDao sigitTCompAgDao) {
		this.sigitTCompAgDao = sigitTCompAgDao;
	}

	public SigitTCompCsDao getSigitTCompCsDao() {
		return sigitTCompCsDao;
	}

	public void setSigitTCompCsDao(SigitTCompCsDao sigitTCompCsDao) {
		this.sigitTCompCsDao = sigitTCompCsDao;
	}

	public SigitTCompCgDao getSigitTCompCgDao() {
		return sigitTCompCgDao;
	}

	public void setSigitTCompCgDao(SigitTCompCgDao sigitTCompCgDao) {
		this.sigitTCompCgDao = sigitTCompCgDao;
	}

	public SigitTCompGfDao getSigitTCompGfDao() {
		return sigitTCompGfDao;
	}

	public void setSigitTCompGfDao(SigitTCompGfDao sigitTCompGfDao) {
		this.sigitTCompGfDao = sigitTCompGfDao;
	}

	public SigitTComp4Dao getSigitTComp4Dao() {
		return sigitTComp4Dao;
	}

	public void setSigitTComp4Dao(SigitTComp4Dao sigitTComp4Dao) {
		this.sigitTComp4Dao = sigitTComp4Dao;
	}

	public SigitTCompGtDao getSigittCompGtDao() {
		return sigittCompGtDao;
	}

	public void setSigittCompGtDao(SigitTCompGtDao sigittCompGtDao) {
		this.sigittCompGtDao = sigittCompGtDao;
	}


	public SigitTCompBrRcDao getSigitTCompBrRcDao() {
		return sigitTCompBrRcDao;
	}

	public void setSigitTCompBrRcDao(SigitTCompBrRcDao sigitTCompBrRcDao) {
		this.sigitTCompBrRcDao = sigitTCompBrRcDao;
	}

	public SigitDUnitaMisuraDao getSigitDUnitaMisuraDao() {
		return sigitDUnitaMisuraDao;
	}

	public void setSigitDUnitaMisuraDao(SigitDUnitaMisuraDao sigitDUnitaMisuraDao) {
		this.sigitDUnitaMisuraDao = sigitDUnitaMisuraDao;
	}


	public SigitVRicerca3ResponsabileDao getSigitVRicerca3ResponsabileDao() {
		return sigitVRicerca3ResponsabileDao;
	}

	public void setSigitVRicerca3ResponsabileDao(SigitVRicerca3ResponsabileDao sigitVRicerca3ResponsabileDao) {
		this.sigitVRicerca3ResponsabileDao = sigitVRicerca3ResponsabileDao;
	}

	public SigitTDocAggiuntivaDao getSigitTDocAggiuntivaDao() {
		return sigitTDocAggiuntivaDao;
	}

	public void setSigitTDocAggiuntivaDao(SigitTDocAggiuntivaDao sigitTDocAggiuntivaDao) {
		this.sigitTDocAggiuntivaDao = sigitTDocAggiuntivaDao;
	}

	public SigitTDocAllegatoDao getSigitTDocAllegatoDao() {
		return sigitTDocAllegatoDao;
	}

	public void setSigitTDocAllegatoDao(SigitTDocAllegatoDao sigitTDocAllegatoDao) {
		this.sigitTDocAllegatoDao = sigitTDocAllegatoDao;
	}

	public SigitTControlloLibrettoDao getSigitTControlloLibrettoDao() {
		return sigitTControlloLibrettoDao;
	}

	public void setSigitTControlloLibrettoDao(SigitTControlloLibrettoDao sigitTControlloLibrettoDao) {
		this.sigitTControlloLibrettoDao = sigitTControlloLibrettoDao;
	}


	public SigitDTipoContrattoDistribDao getSigitDTipoContrattoDistribDao() {
		return sigitDTipoContrattoDistribDao;
	}

	public void setSigitDTipoContrattoDistribDao(SigitDTipoContrattoDistribDao sigitDTipoContrattoDistribDao) {
		this.sigitDTipoContrattoDistribDao = sigitDTipoContrattoDistribDao;
	}

	public SigitDCategoriaUtilDao getSigitDCategoriaUtilDao() {
		return sigitDCategoriaUtilDao;
	}

	public void setSigitDCategoriaUtilDao(SigitDCategoriaUtilDao sigitDCategoriaUtilDao) {
		this.sigitDCategoriaUtilDao = sigitDCategoriaUtilDao;
	}

	/**
	 * DAO per accedere alla tabella VISTA_RICERCA_ALLEGATI
	 */
	private SigitVRicercaAllegatiDao sigitVRicercaAllegatiDao = null;

	public SigitVRicercaAllegatiDao getSigitVRicercaAllegatiDao() {
		return sigitVRicercaAllegatiDao;
	}

	public void setSigitVRicercaAllegatiDao(
			SigitVRicercaAllegatiDao sigitVRicercaAllegatiDao) {
		this.sigitVRicercaAllegatiDao = sigitVRicercaAllegatiDao;
	}

	/**
	 * DAO per accedere alla tabella VISTA_RICERCA_ALLEGATI_STORICO
	 */
	private SigitVRicercaAllegatiStoricoDao sigitVRicercaAllegatiStoricoDao = null;

	public SigitVRicercaAllegatiStoricoDao getSigitVRicercaAllegatiStoricoDao() {
		return sigitVRicercaAllegatiStoricoDao;
	}

	public void setSigitVRicercaAllegatiStoricoDao(
			SigitVRicercaAllegatiStoricoDao sigitVRicercaAllegatiStoricoDao) {
		this.sigitVRicercaAllegatiStoricoDao = sigitVRicercaAllegatiStoricoDao;
	}

	/**
	 * DAO per accedere alla tabella VISTA_RICERCA_ISPEZIONI
	 */
	private SigitVRicercaIspezioniDao sigitVRicercaIspezioniDao = null;

	public SigitVRicercaIspezioniDao getSigitVRicercaIspezioniDao() {
		return sigitVRicercaIspezioniDao;
	}

	public void setSigitVRicercaIspezioniDao(
			SigitVRicercaIspezioniDao sigitVRicercaIspezioniDao) {
		this.sigitVRicercaIspezioniDao = sigitVRicercaIspezioniDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_DETT_TIPO1
	 */
	private SigitTDettTipo1Dao sigitTDettTipo1Dao = null;

	public SigitTDettTipo1Dao getSigitTDettTipo1Dao() {
		return sigitTDettTipo1Dao;
	}

	public void setSigitTDettTipo1Dao(
			SigitTDettTipo1Dao sigitTDettTipo1Dao) {
		this.sigitTDettTipo1Dao = sigitTDettTipo1Dao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_DETT_TIPO2
	 */
	private SigitTDettTipo2Dao sigitTDettTipo2Dao = null;

	public SigitTDettTipo2Dao getSigitTDettTipo2Dao() {
		return sigitTDettTipo2Dao;
	}

	public void setSigitTDettTipo2Dao(
			SigitTDettTipo2Dao sigitTDettTipo2Dao) {
		this.sigitTDettTipo2Dao = sigitTDettTipo2Dao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_DETT_TIPO3
	 */
	private SigitTDettTipo3Dao sigitTDettTipo3Dao = null;

	public SigitTDettTipo3Dao getSigitTDettTipo3Dao() {
		return sigitTDettTipo3Dao;
	}

	public void setSigitTDettTipo3Dao(
			SigitTDettTipo3Dao sigitTDettTipo3Dao) {
		this.sigitTDettTipo3Dao = sigitTDettTipo3Dao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_DETT_TIPO4
	 */
	private SigitTDettTipo4Dao sigitTDettTipo4Dao = null;

	public SigitTDettTipo4Dao getSigitTDettTipo4Dao() {
		return sigitTDettTipo4Dao;
	}

	public void setSigitTDettTipo4Dao(
			SigitTDettTipo4Dao sigitTDettTipo4Dao) {
		this.sigitTDettTipo4Dao = sigitTDettTipo4Dao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_RAPP_TIPO1
	 */
	private SigitTRappTipo1Dao sigitTRappTipo1Dao = null;

	public SigitTRappTipo1Dao getSigitTRappTipo1Dao() {
		return sigitTRappTipo1Dao;
	}

	public void setSigitTRappTipo1Dao(
			SigitTRappTipo1Dao sigitTRappTipo1Dao) {
		this.sigitTRappTipo1Dao = sigitTRappTipo1Dao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_RAPP_TIPO2
	 */
	private SigitTRappTipo2Dao sigitTRappTipo2Dao = null;

	public SigitTRappTipo2Dao getSigitTRappTipo2Dao() {
		return sigitTRappTipo2Dao;
	}

	public void setSigitTRappTipo2Dao(
			SigitTRappTipo2Dao sigitTRappTipo2Dao) {
		this.sigitTRappTipo2Dao = sigitTRappTipo2Dao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_RAPP_TIPO3
	 */
	private SigitTRappTipo3Dao sigitTRappTipo3Dao = null;

	public SigitTRappTipo3Dao getSigitTRappTipo3Dao() {
		return sigitTRappTipo3Dao;
	}

	public void setSigitTRappTipo3Dao(
			SigitTRappTipo3Dao sigitTRappTipo3Dao) {
		this.sigitTRappTipo3Dao = sigitTRappTipo3Dao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_RAPP_TIPO4
	 */
	private SigitTRappTipo4Dao sigitTRappTipo4Dao = null;

	public SigitTRappTipo4Dao getSigitTRappTipo4Dao() {
		return sigitTRappTipo4Dao;
	}

	public void setSigitTRappTipo4Dao(
			SigitTRappTipo4Dao sigitTRappTipo4Dao) {
		this.sigitTRappTipo4Dao = sigitTRappTipo4Dao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_R_RUOLO_TIPODOC
	 */
	private SigitRRuoloTipodocDao sigitRRuoloTipodocDao = null;

	public SigitRRuoloTipodocDao getSigitRRuoloTipodocDao() {
		return sigitRRuoloTipodocDao;
	}

	public void setSigitRRuoloTipodocDao(SigitRRuoloTipodocDao sigitRRuoloTipodocDao) {
		this.sigitRRuoloTipodocDao = sigitRRuoloTipodocDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_STORICO_VARIAZ_STATO
	 */
	private SigitTStoricoVariazStatoDao sigitTStoricoVariazStatoDao = null;

	public SigitTStoricoVariazStatoDao getSigitTStoricoVariazStatoDao() {
		return sigitTStoricoVariazStatoDao;
	}

	public void setSigitTStoricoVariazStatoDao(SigitTStoricoVariazStatoDao sigitTStoricoVariazStatoDao) {
		this.sigitTStoricoVariazStatoDao = sigitTStoricoVariazStatoDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_RAPP_CONTROLLO
	 */
	private SigitTRappControlloDao sigitTRappControlloDao = null;

	public SigitTRappControlloDao getSigitTRappControlloDao() {
		return sigitTRappControlloDao;
	}

	public void setSigitTRappControlloDao(SigitTRappControlloDao sigitTRappControlloDao) {
		this.sigitTRappControlloDao = sigitTRappControlloDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_RAPP_DETTAGLIO
	 */
	private SigitTRappDettaglioDao sigitTRappDettaglioDao = null;

	public SigitTRappDettaglioDao getSigitTRappDettaglioDao() {
		return sigitTRappDettaglioDao;
	}

	public void setSigitTRappDettaglioDao(SigitTRappDettaglioDao sigitTRappDettaglioDao) {
		this.sigitTRappDettaglioDao = sigitTRappDettaglioDao;
	}


	/**
	 * DAO per accedere alla tabella SIGIT_T_CONTRATTO
	 */
	/*
	private SigitTContrattoDao sigitTContrattoDao = null;

	public SigitTContrattoDao getSigitTContrattoDao() {
		return sigitTContrattoDao;
	}

	public void setSigitTContrattoDao(
			SigitTContrattoDao sigitTContrattoDao) {
		this.sigitTContrattoDao = sigitTContrattoDao;
	}
	*/
	private SigitTContratto2019Dao sigitTContratto2019Dao = null;

	public SigitTContratto2019Dao getSigitTContratto2019Dao() {
		return sigitTContratto2019Dao;
	}

	public void setSigitTContratto2019Dao(
			SigitTContratto2019Dao sigitTContratto2019Dao) {
		this.sigitTContratto2019Dao = sigitTContratto2019Dao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_R_COMP4_CONTRATTO
	 */
	/*
	private SigitRComp4ContrattoDao sigitRComp4ContrattoDao = null;

	public SigitRComp4ContrattoDao getSigitRComp4ContrattoDao() {
		return sigitRComp4ContrattoDao;
	}

	public void setSigitRComp4ContrattoDao(
			SigitRComp4ContrattoDao sigitRComp4ContrattoDao) {
		this.sigitRComp4ContrattoDao = sigitRComp4ContrattoDao;
	}
	*/

	/**
	 * DAO per accedere alla tabella SIGIT_V_RICERCA_IMPIANTI
	 */
	private SigitVRicercaImpiantiDao sigitVRicercaImpiantiDao = null;

	public SigitVRicercaImpiantiDao getSigitVRicercaImpiantiDao() {
		return sigitVRicercaImpiantiDao;
	}

	public void setSigitVRicercaImpiantiDao(
			SigitVRicercaImpiantiDao sigitVRicercaImpiantiDao) {
		this.sigitVRicercaImpiantiDao = sigitVRicercaImpiantiDao;
	}

	private SigitDTipoComponenteDao sigitDTipoComponenteDao;

	public SigitDTipoComponenteDao getSigitDTipoComponenteDao() {
		return sigitDTipoComponenteDao;
	}

	public void setSigitDTipoComponenteDao(
			SigitDTipoComponenteDao sigitDTipoComponenteDao) {
		this.sigitDTipoComponenteDao = sigitDTipoComponenteDao;
	}


	private SigitTImportDistribDao sigitTImportDistribDao;

	public SigitTImportDistribDao getSigitTImportDistribDao() {
		return sigitTImportDistribDao;
	}

	public void setSigitTImportDistribDao(
			SigitTImportDistribDao sigitTImportDistribDao) {
		this.sigitTImportDistribDao = sigitTImportDistribDao;
	}

	private SigitTLogDistribDao sigitTLogDistribDao;

	public SigitTLogDistribDao getSigitTLogDistribDao() {
		return sigitTLogDistribDao;
	}

	public void setSigitTLogDistribDao(
			SigitTLogDistribDao sigitTLogDistribDao) {
		this.sigitTLogDistribDao = sigitTLogDistribDao;
	}

	private SigitTDatoDistribDao sigitTDatoDistribDao;

	public SigitTDatoDistribDao getSigitTDatoDistribDao() {
		return sigitTDatoDistribDao;
	}

	public void setSigitTDatoDistribDao(
			SigitTDatoDistribDao sigitTDatoDistribDao) {
		this.sigitTDatoDistribDao = sigitTDatoDistribDao;
	}

	private SigitTRifCatastDao sigitTRifCatastDao;

	public SigitTRifCatastDao getSigitTRifCatastDao() {
		return sigitTRifCatastDao;
	}

	public void setSigitTRifCatastDao(
			SigitTRifCatastDao sigitTRifCatastDao) {
		this.sigitTRifCatastDao = sigitTRifCatastDao;
	}

	private SigitDCategoriaDao sigitDCategoriaDao;

	public SigitDCategoriaDao getSigitDCategoriaDao() {
		return sigitDCategoriaDao;
	}

	public void setSigitDCategoriaDao(
			SigitDCategoriaDao sigitDCategoriaDao) {
		this.sigitDCategoriaDao = sigitDCategoriaDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_RAPP_ISPEZ_GT
	 */
	private SigitTRappIspezGtDao sigitTRappIspezGtDao = null;
	private SigitTRappIspezGfDao sigitTRappIspezGfDao = null;

	public SigitTRappIspezGfDao getSigitTRappIspezGfDao() {
		return sigitTRappIspezGfDao;
	}

	public void setSigitTRappIspezGfDao(SigitTRappIspezGfDao sigitTRappIspezGfDao) {
		this.sigitTRappIspezGfDao = sigitTRappIspezGfDao;
	}

	public SigitTRappIspezGtDao getSigitTRappIspezGtDao() {
		return sigitTRappIspezGtDao;
	}

	public void setSigitTRappIspezGtDao(
			SigitTRappIspezGtDao sigitTRappIspezGtDao) {
		this.sigitTRappIspezGtDao = sigitTRappIspezGtDao;
	}

	private SigitTDettIspezGfDao sigitTDettIspezGfDao = null;


	public SigitTDettIspezGfDao getSigitTDettIspezGfDao() {
		return sigitTDettIspezGfDao;
	}

	public void setSigitTDettIspezGfDao(SigitTDettIspezGfDao sigitTDettIspezGfDao) {
		this.sigitTDettIspezGfDao = sigitTDettIspezGfDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_DETT_ISPEZ_GT
	 */
	private SigitTDettIspezGtDao sigitTDettIspezGtDao = null;

	public SigitTDettIspezGtDao getSigitTDettIspezGtDao() {
		return sigitTDettIspezGtDao;
	}

	public void setSigitTDettIspezGtDao(
			SigitTDettIspezGtDao sigitTDettIspezGtDao) {
		this.sigitTDettIspezGtDao = sigitTDettIspezGtDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_ABILITAZIONE
	 */
	private SigitTAbilitazioneDao sigitTAbilitazioneDao = null;

	public SigitTAbilitazioneDao getSigitTAbilitazioneDao() {
		return sigitTAbilitazioneDao;
	}

	public void setSigitTAbilitazioneDao(
			SigitTAbilitazioneDao sigitTAbilitazioneDao) {
		this.sigitTAbilitazioneDao = sigitTAbilitazioneDao;
	}

	private SigitTGraffaturaDao sigitTGraffaturaDao;

	public SigitTGraffaturaDao getSigitTGraffaturaDao() {
		return sigitTGraffaturaDao;
	}

	public void setSigitTGraffaturaDao(SigitTGraffaturaDao sigitTGraffaturaDao) {
		this.sigitTGraffaturaDao = sigitTGraffaturaDao;
	}

	private SigitTUserWsDao sigitTUserWsDao;

	public SigitTUserWsDao getSigitTUserWsDao() {
		return sigitTUserWsDao;
	}

	public void setSigitTUserWsDao(SigitTUserWsDao sigitTUserWsDao) {
		this.sigitTUserWsDao = sigitTUserWsDao;
	}

	private SigitLAccessoDao sigitLAccessoDao;

	public SigitLAccessoDao getSigitLAccessoDao() {
		return sigitLAccessoDao;
	}

	public void setSigitLAccessoDao(SigitLAccessoDao sigitLAccessoDao) {
		this.sigitLAccessoDao = sigitLAccessoDao;
	}

	private SigitSAccessoDao sigitSAccessoDao;

	public SigitSAccessoDao getSigitSAccessoDao() {
		return sigitSAccessoDao;
	}

	public void setSigitSAccessoDao(SigitSAccessoDao sigitSAccessoDao) {
		this.sigitSAccessoDao = sigitSAccessoDao;
	}

	private SigitTConsumoTipo1BDao sigitTConsumoTipo1BDao;

	public SigitTConsumoTipo1BDao getSigitTConsumoTipo1BDao() {
		return sigitTConsumoTipo1BDao;
	}

	public void setSigitTConsumoTipo1BDao(SigitTConsumoTipo1BDao sigitTConsumoTipo1BDao) {
		this.sigitTConsumoTipo1BDao = sigitTConsumoTipo1BDao;
	}

	private SigitDStelleDao sigitDStelleDao;

	public SigitDStelleDao getSigitDStelleDao() {
		return sigitDStelleDao;
	}

	public void setSigitDStelleDao(SigitDStelleDao sigitDStelleDao) {
		this.sigitDStelleDao = sigitDStelleDao;
	}

	private SigitDTipo1BDao sigitDTipo1BDao;

	public SigitDTipo1BDao getSigitDTipo1BDao() {
		return sigitDTipo1BDao;
	}

	public void setSigitDTipo1BDao(SigitDTipo1BDao sigitDTipo1BDao) {
		this.sigitDTipo1BDao = sigitDTipo1BDao;
	}

	private SigitDAriaComburenteDao sigitDAriaComburenteDao;

	public SigitDAriaComburenteDao getSigitDAriaComburenteDao() {
		return sigitDAriaComburenteDao;
	}

	public void setSigitDAriaComburenteDao(SigitDAriaComburenteDao sigitDAriaComburenteDao) {
		this.sigitDAriaComburenteDao = sigitDAriaComburenteDao;
	}

	private SigitDControlloAriaDao sigitDControlloAriaDao;

	public SigitDControlloAriaDao getSigitDControlloAriaDao() {
		return sigitDControlloAriaDao;
	}

	public void setSigitDControlloAriaDao(SigitDControlloAriaDao sigitDControlloAriaDao) {
		this.sigitDControlloAriaDao = sigitDControlloAriaDao;
	}

	private SigitDTipoCaricCombuDao sigitDTipoCaricCombuDao;

	public SigitDTipoCaricCombuDao getSigitDTipoCaricCombuDao() {
		return sigitDTipoCaricCombuDao;
	}

	public void setSigitDTipoCaricCombuDao(SigitDTipoCaricCombuDao sigitDTipoCaricCombuDao) {
		this.sigitDTipoCaricCombuDao = sigitDTipoCaricCombuDao;
	}

	private DbVerificaMgr dbVerificaMgr;

	public DbVerificaMgr getDbVerificaMgr() {
		return dbVerificaMgr;
	}

	public void setDbVerificaMgr(DbVerificaMgr dbVerificaMgr) {
		this.dbVerificaMgr = dbVerificaMgr;
	}

	private DbIspezioneMgr dbIspezioneMgr;

	public DbIspezioneMgr getDbIspezioneMgr() {
		return dbIspezioneMgr;
	}

	public void setDbIspezioneMgr(DbIspezioneMgr dbIspezioneMgr) {
		this.dbIspezioneMgr = dbIspezioneMgr;
	}

	/**
	 * Verifica del manager
	 */
	public void test() {
		log.debug("DBManager RAGGIUNTO CORRETTAMENTE");
	}

	// INIZIO METODI DI BUSINESS

	/**
	 * Restituisce l'id ruolo passando la descrizione
	 *
	 * @param descRuolo descrizione del ruolo
	 * @return Integer l'id del ruolo
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */

	public Integer cercaIdRuoloByDesc(String descRuolo) throws DbManagerException {
		Integer obj = null;
		List<SigitDRuoloDto> dtoList = null;
		log.debug("[DbMgr::cercaIdRuoloByDesc] BEGIN");
		try {
			dtoList = getSigitDRuoloDao().findByDesRuolo(descRuolo);

			if((dtoList != null) && (dtoList.size() > 0)) {
				obj = ConvertUtil.convertToInteger(dtoList.get(0).getIdRuolo());
			}

		}
		catch(SigitDRuoloDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaIdRuoloByDesc] END");
		}
		return obj;
	}

	/**
	 * Restituisce l'id ruolo passando la descrizione funzionale
	 *
	 * @param descRuolo descrizione del ruolo funzionale
	 * @return ArrayList<Integer> l'id del ruolo
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */

	public ArrayList<BigDecimal> cercaIdRuoloByDescRuoloFunzionale(String descRuolo) throws DbManagerException {
		ArrayList<BigDecimal> obj = new ArrayList<BigDecimal>();
		List<SigitDRuoloDto> dtoList = null;
		log.debug("[DbMgr::cercaIdRuoloByDescRuoloFunzionale] BEGIN");
		try {
			dtoList = getSigitDRuoloDao().findByRuoloFunzionale(descRuolo);

			for(SigitDRuoloDto dto : dtoList){
				obj.add(dto.getIdRuolo());
			}

		}
		catch(SigitDRuoloDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaIdRuoloByDescRuoloFunzionale] END");
		}
		return obj;
	}

	/**
	 * Restituisce la descrizione del ruolo
	 *
	 * @param idRuolo id del ruolo
	 * @return String la descrizione del ruolo
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */

	public String cercaDescRuoloById(Integer idRuolo) throws DbManagerException {
		String obj = null;
		SigitDRuoloDto dto = null;
		log.debug("[DbMgr::cercaDescRuoloById] BEGIN");
		try {
			dto = getSigitDRuoloDao().findByPrimaryKey(new SigitDRuoloPk(ConvertUtil.convertToBigDecimal(idRuolo)));

			if(dto != null) {
				obj = dto.getDesRuolo();
			}

		}
		catch(SigitDRuoloDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaDescRuoloById] END");
		}
		return obj;
	}

	public ArrayList<CodeDescription> cercaListaRuoloByDescRuoloFunzionale(String descRuoloFunz) throws DbManagerException {
		log.debug("[DbMgr::cercaListaRuoloByDescRuoloFunzionale] BEGIN");
		try {

			return MapDto.mapToCodeDescription(getSigitDRuoloDao().findByRuoloFunzionale(descRuoloFunz));

		}
		catch(SigitDRuoloDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaRuoloByDescRuoloFunzionale] END");
		}
	}

	public ArrayList<IdDescription> cercaListaRuoloPa() throws DbManagerException {
		log.debug("[DbMgr::cercaListaRuoloPa] BEGIN");
		try {

			return MapDto.mapToIdDescriptionRuoloPa(getSigitDRuoloPaDao().findAll());

		}
		catch(SigitDRuoloPaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaRuoloPa] END");
		}
	}

	public ArrayList<CodeDescription> cercaListaUtentiPa() throws DbManagerException {
		log.debug("[DbMgr::cercaListaUtentiPa] BEGIN");
		try {

			return MapDto.mapToCodeDescriptionRuoloAcc(getSigitDRuoloAccredDao().findAll());

		}
		catch(SigitDRuoloAccredDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaUtentiPa] END");
		}
	}

	public ArrayList<CodeDescription> cercaListaIstatAbilitazione() throws DbManagerException {
		log.debug("[DbMgr::cercaListaIstatAbilitazione] BEGIN");
		try {

			return MapDto.mapToCodeDescriptionAbilitazione(getSigitRPfRuoloPaDao().findAllActiveDistinctIstatAbilitazioni(null));

		} catch (SigitRPfRuoloPaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaIstatAbilitazione] END");
		}
	}

	public ArrayList<CodeDescription> cercaListaRuoliAccred() throws DbManagerException {
		log.debug("[DbMgr::cercaListaTipiDm] BEGIN");
		try {

			return MapDto.mapToCodeDescriptionRuoloAcc(getSigitDRuoloAccredDao().findAll());

		}
		catch(SigitDRuoloAccredDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaRuoliAccred] END");
		}
	}

	public List<SigitTLibTxtByCodImpiantiDto> cercaListaLibrettoXmlByElCodImp(String elencoCodImp) throws DbManagerException {
		log.debug("[DbMgr::cercaListaLibrettoXmlByElCodImp] BEGIN");
		try {

			return getSigitTLibTxtDao().findByCodImpianti(elencoCodImp);

		}
		catch(SigitTLibTxtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaLibrettoXmlByElCodImp] END");
		}
	}

	/*
	public ArrayList<CodeDescription> cercaListaTipiDm() throws DbManagerException {
		log.debug("[DbMgr::cercaListaTipiDm] BEGIN");
		try {

			return MapDto.mapToCodeDescriptionDM(getSigitDDm37_2008Dao().findAll());

		}
		catch(SigitDDm37_2008DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaTipiDm] END");
		}
	}
	*/

	public ArrayList<CodeDescription> cercaListaRuoloByDescRuoloFunzionaleCodImpianto(String descRuoloFunz, String codImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaListaRuoloByDescRuoloFunzionaleCodImpianto] BEGIN");
		try {

			SubentroFilter filter = new SubentroFilter(descRuoloFunz, ConvertUtil.convertToInteger(codImpianto));
			return MapDto.mapToCodeDescription(getSigitDRuoloDao().findByRuoloFunzionaleCodImp(filter));

		}
		catch(SigitDRuoloDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaRuoloByDescRuoloFunzionaleCodImpianto] END");
		}
	}

	public AbilitazioniRuoloFunz cercaAbilitazioniRuoloFunzByDescRuolo(String descRuolo) throws DbManagerException {
		SigitWrkRuoloFunzDto dto = null;
		log.debug("[DbMgr::cercaAbilitazioniRuoloFunzByDescRuolo] BEGIN");
		try {

			dto = getSigitWrkRuoloFunzDao().findByPrimaryKey(new SigitWrkRuoloFunzPk(descRuolo));

		}
		catch(SigitWrkRuoloFunzDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaAbilitazioniRuoloFunzByDescRuolo] END");
		}
		return MapDto.mapToAbilitazioniRuoloFunz(dto);

	}

	/**
	 * Restituisce le informazioni della persona fisica
	 *
	 * @param cf Codice Fiscale della persona
	 * @return PersonaFisica persona fisica
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */

	public PersonaFisica cercaPersonaFisicaByCF(String cf) throws DbManagerException {
		PersonaFisica obj = null;
		List<SigitTPersonaFisicaDto> dtoList = null;
		log.debug("[DbMgr::cercaPersonaFisicaByCF] BEGIN");
		try {
			dtoList = getSigitTPersonaFisicaDao().findByCodFisc(cf);

			if((dtoList != null) && (dtoList.size() > 0)) {
				obj = MapDto.mapToPersonaFisica(dtoList.get(0));
			}

		}
		catch(SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaFisicaByCF] END");
		}
		return obj;
	}

	public List<PersonaFisica> cercaPersonaFisicaByFilter(RicercaPersonaGiuridicaFisicaFilter input) throws DbManagerException {
		List<SigitTPersonaFisicaDto> dtoList = null;
		List<PersonaFisica> risultato = new ArrayList<PersonaFisica>();
		log.debug("[DbMgr::cercaPersonaFisicaByFilter] BEGIN");
		try {
			dtoList = getSigitTPersonaFisicaDao().findByFilter(input);

			if(dtoList != null) {
				for (SigitTPersonaFisicaDto dtoDb : dtoList) {
					PersonaFisica nuovaPf = MapDto.mapToPersonaFisica( dtoDb);
					risultato.add(nuovaPf);
				}
			}

		} catch(SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaFisicaByFilter] END");
		}

		return risultato;
	}


	public List<PersonaGiuridica> cercaPersonaGiuridicaByFilter(RicercaPersonaGiuridicaFisicaFilter input) throws DbManagerException {
		List<SigitTPersonaGiuridicaDto> dtoList = null;
		List<PersonaGiuridica> risultato = new ArrayList<PersonaGiuridica>();
		log.debug("[DbMgr::cercaPersonaGiuridicaByFilter] BEGIN");
		try {
			dtoList = getSigitTPersonaGiuridicaDao().findByFilter(input);

			if(dtoList != null) {
				for (SigitTPersonaGiuridicaDto dtoDb : dtoList) {
					PersonaGiuridica nuovaPf = MapDto.mapToPersonaGiuridica( dtoDb);
					risultato.add(nuovaPf);
				}
			}

		} catch(SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaGiuridicaByFilter] END");
		}

		return risultato;
	}

	/**
	 * Restituisce le informazioni della persona fisica
	 *
	 * @param idPersonaF id della persona
	 * @return PersonaGiuridica persona fisica
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */

	public PersonaFisica cercaPersonaFisicaById(Integer idPersonaF) throws DbManagerException {
		PersonaFisica obj = null;
		SigitTPersonaFisicaDto dto = null;
		log.debug("[DbMgr::cercaPersonaFisicaById] BEGIN");
		try {

			//dto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(ConvertUtil.convertToBigDecimal(idPersonaG)));
			dto = cercaTPersonaFisicaById(idPersonaF);

			obj = MapDto.mapToPersonaFisica(dto);

		}
		finally {
			log.debug("[DbMgr::cercaPersonaFisicaById] END");
		}
		return obj;
	}


	/**
	 * Restituisce le informazioni della persona fisica
	 *
	 * @param idPersonaF id della persona
	 * @return SigitTPersonaFisicaDto persona fisica
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */

	public SigitTPersonaFisicaDto cercaTPersonaFisicaById(Integer idPersonaF) throws DbManagerException {
		SigitTPersonaFisicaDto dto = null;
		log.debug("[DbMgr::cercaTPersonaFisicaById] BEGIN");
		try {

			dto = getSigitTPersonaFisicaDao().findByPrimaryKey(new SigitTPersonaFisicaPk(ConvertUtil.convertToBigDecimal(idPersonaF)));

		}
		catch(SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaTPersonaFisicaById] END");
		}
		return dto;
	}

	/**
	 * Restituisce le informazioni della persona giuridica
	 *
	 * @param idPersonaG id della persona
	 * @return PersonaGiuridica persona giuridica
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */

	public PersonaGiuridica cercaPersonaGiuridicaById(Integer idPersonaG) throws DbManagerException {
		PersonaGiuridica obj = null;
		SigitTPersonaGiuridicaDto dto = null;
		log.debug("[DbMgr::cercaPersonaGiuridicaById] BEGIN");
		try {

			//dto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(ConvertUtil.convertToBigDecimal(idPersonaG)));
			dto = cercaTPersonaGiuridicaById(idPersonaG);

			obj = MapDto.mapToPersonaGiuridica(dto);

		}
		finally {
			log.debug("[DbMgr::cercaPersonaGiuridicaById] END");
		}
		return obj;
	}

	/**
	 * Restituisce le informazioni della persona giuridica
	 *
	 * @param idPersonaG id della persona
	 * @return SigitTPersonaGiuridicaDto persona giuridica
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */

	public SigitTPersonaGiuridicaDto cercaTPersonaGiuridicaById(Integer idPersonaG) throws DbManagerException {
		SigitTPersonaGiuridicaDto dto = null;
		log.debug("[DbMgr::cercaTPersonaGiuridicaById] BEGIN");
		try {

			dto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(ConvertUtil.convertToBigDecimal(idPersonaG)));

		}
		catch(SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaTPersonaGiuridicaById] END");
		}
		return dto;
	}

	/**
	 * Restituisce le informazioni del responsabile
	 *
	 * @param id della persona giuridica
	 * @return Responsabile responsabile
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */

	/*public Responsabile cercaResponsabilePersonaGiuridicaById(String idPersonaG) throws DbManagerException {
		Responsabile obj = null;
		SigitTPersonaGiuridicaDto dto = null;
		log.debug("[DbMgr::cercaPersonaGiuridicaById] BEGIN");
		try {

			dto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(ConvertUtil.convertToBigDecimal(idPersonaG)));

		}
		catch(SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaGiuridicaById] END");
		}
		return obj;
	}*/

	/**
	 * Restituisce le informazioni del responsabile
	 *
	 * @param cf Codice Fiscale della persona
	 * @return PersonaFisica persona fisica
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */

	public ArrayList<RisultatoRicResponsabile> cercaResponsabiliByIdImpianto(Integer idImpianto) throws DbManagerException {

		ArrayList<RisultatoRicResponsabile> risRicResp = new ArrayList<RisultatoRicResponsabile>();

		log.debug("[DbMgr::cercaResponsabiliByIdImpianto] BEGIN");
		try {

			List<SigitExtRespImpDto> dtoList = getSigitExtDao().findResponsabiliByCodiceImpianto(idImpianto);

			for (SigitExtRespImpDto sigitExtRespImpDto : dtoList) {
				risRicResp.add(MapDto.mapToRisultatoRicResponsabile(sigitExtRespImpDto));
			}

		}
		catch(SigitExtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaResponsabiliByIdImpianto] END");
		}
		return risRicResp;
	}



	/**
	 * Restituisce le informazioni del responsabile
	 *
	 * @param cf Codice Fiscale della persona
	 * @return PersonaFisica persona fisica
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */

	public RisultatoRicResponsabile cercaResponsabileAttivoByIdImpianto(Integer idImpianto) throws DbManagerException {

		RisultatoRicResponsabile risRicResp = null;

		log.debug("[DbMgr::cercaResponsabileAttivoByIdImpianto] BEGIN");
		try {

			SigitExtRespImpDto dto = getSigitExtDao().findResponsabileAttivoByCodiceImpianto(idImpianto);

			if (dto != null)
			{
				risRicResp = MapDto.mapToRisultatoRicResponsabile(dto);
			}
		}
		catch(SigitExtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaResponsabileAttivoByIdImpianto] END");
		}
		return risRicResp;
	}


	/*
	public ArrayList<RisultatoRicManutentore> cercaManutentoriByIdImpianto(Integer idImpianto) throws DbManagerException {

		ArrayList<RisultatoRicManutentore> risRicResp = new ArrayList<RisultatoRicManutentore>();

		log.debug("[DbMgr::cercaManutentoriByIdImpianto] BEGIN");
		try {

			List<SigitRImpRuoloPfpgManutentoriByCodiceImpiantoDto> dtoList = getSigitRImpRuoloPfpgDao().findManutentoriByCodiceImpianto(idImpianto);

			for (SigitRImpRuoloPfpgManutentoriByCodiceImpiantoDto sigitRImpRuoloPfpgDto : dtoList) {
				risRicResp.add(MapDto.mapToRisultatoRicManutentore(sigitRImpRuoloPfpgDto));
			}

		}
		catch(SigitRImpRuoloPfpgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaManutentoriByIdImpianto] END");
		}
		return risRicResp;
	}
	*/

	public ArrayList<RisultatoRicManutentore> cercaManutentoriByIdImpiantoNew(Integer idImpianto) throws DbManagerException {

		ArrayList<RisultatoRicManutentore> risRicResp = new ArrayList<RisultatoRicManutentore>();

		log.debug("[DbMgr::cercaManutentoriByIdImpiantoNew] BEGIN");
		try {

			List<SigitRComp4ManutManutentoriByCodiceImpiantoDto> dtoList = getSigitRComp4ManutDao().findManutentoriByCodiceImpianto(idImpianto);

			if (dtoList != null && !dtoList.isEmpty())
			{
				String chiaveManut= null;
				String chiaveManutNew = null;
				String elencoComp = "";

				RisultatoRicManutentore ricManutentore = null;
				for (SigitRComp4ManutManutentoriByCodiceImpiantoDto dto : dtoList) {

					chiaveManutNew = dto.getCmFkPersonaGiuridica()+"-"+dto.getCmIdTipoComponente();

					if (chiaveManut == null)
					{
						ricManutentore = MapDto.mapToRisultatoRicManutentoreNew(dto);
						chiaveManut = dto.getCmFkPersonaGiuridica()+"-"+dto.getCmIdTipoComponente();
						//elencoComp = dto.getCmIdTipoComponente()+dto.getCmProgressivo();

					}

					if (!chiaveManut.equals(chiaveManutNew))
					{
						ricManutentore.setComponente(elencoComp);
						risRicResp.add(ricManutentore);
						chiaveManut = chiaveManutNew;
						ricManutentore = MapDto.mapToRisultatoRicManutentoreNew(dto);
						elencoComp = "";
					}
					else if (GenericUtil.isNotNullOrEmpty(elencoComp))
					{
						elencoComp += ",";
					}

					elencoComp += dto.getCmIdTipoComponente()+"-"+dto.getCmProgressivo();

				}

				ricManutentore.setComponente(elencoComp);
				risRicResp.add(ricManutentore);
			}

		}
		catch(SigitRComp4ManutDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaManutentoriByIdImpiantoNew] END");
		}
		return risRicResp;
	}

	public Integer cercaCodiciImpiantoByFiltroCount(TransazioneFilter filter) throws ManagerException {
		log.debug("[DbMgr::cercaCodiciImpiantoByFiltroCount] BEGIN");
		Integer count = null;
		try {

			//dtoList = getSigitTTransazioneImpDao().findByTransazioneFilter(filter);
			count = getSigitExtDao().findByTransazioneImpFilterCount(filter);

			validateResultSize(count, Constants.MAX_RIGHE);

//			if (dtoList != null)
//			{
//				count = dtoList.size();
//			}

		}
		catch(SigitExtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaCodiciImpiantoByFiltroCount] END");
		}
		return count;
	}

	/*
	public List<SigitTTransazioneImpByTransazioneFilterDto> cercaCodiciImpiantoByFiltro(TransazioneFilter filter) throws DbManagerException {
		List<SigitTTransazioneImpByTransazioneFilterDto> dtoList = null;
		log.debug("[DbMgr::cercaCodiciImpiantoByFiltro] BEGIN");
		try {

			dtoList = getSigitTTransazioneImpDao().findByTransazioneFilter(filter);

			// Non controllo se ci sono troppi risultati, mi da problemi quando ritorno dall'inserimento (potrebbe superare)
			//validateResultSize(dtoList, Constants.MAX_RIGHE);

		}
		catch(SigitTTransazioneImpDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaCodiciImpiantoByFiltro] END");
		}
		return dtoList;
	}
	*/

	public Integer cercaBolliniByFiltroCount(TransazioneFilter filter) throws ManagerException {
//		List<SigitTTransazioneBollByTransazioneFilterDto> dtoList = null;
		log.debug("[DbMgr::cercaBolliniByFiltroCount] BEGIN");
		Integer count = null;
		try {

			//dtoList = getSigitTTransazioneBollDao().findByTransazioneFilter(filter);
			count = getSigitExtDao().findByTransazioneBollFilterCount(filter);

			validateResultSize(count, Constants.MAX_RIGHE);

//			if (dtoList != null)
//			{
//				count = dtoList.size();
//			}

		}
		catch(SigitExtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaBolliniByFiltroCount] END");
		}
		return count;
	}

	/*
	public List<SigitTTransazioneBollByTransazioneFilterDto> cercaBolliniByFiltro(TransazioneFilter filter) throws DbManagerException {
		List<SigitTTransazioneBollByTransazioneFilterDto> dtoList = null;
		log.debug("[DbMgr::cercaBolliniByFiltro] BEGIN");
		try {

			dtoList = getSigitTTransazioneBollDao().findByTransazioneFilter(filter);

		}
		catch(SigitTTransazioneBollDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaBolliniByFiltro] END");
		}
		return dtoList;
	}
	*/

	public List<SigitVPotenzaPrezzoDto> cercaPrezziBollino() throws DbManagerException {
		List<SigitVPotenzaPrezzoDto> dtoList = null;
		log.debug("[DbMgr::cercaPrezziBollino] BEGIN");
		try {

			dtoList = getSigitVPotenzaPrezzoDao().findAll();

		}
		catch(SigitVPotenzaPrezzoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPrezziBollino] END");
		}
		return dtoList;
	}



	public Integer cercaImpiantoByFiltroCount(ImpiantoFilter filter) throws ManagerException {
		log.debug("[DbMgr::cercaImpiantoByFiltroCount] BEGIN");
		Integer count = 0;
		try {

			//dtoList = getSigitExtDao().findImpiantiByFilter(filter);

			count = getSigitExtDao().findImpiantiByFilterCount(filter);


			validateResultSize(count, Constants.MAX_RIGHE);

//			if (dtoList != null)
//			{
//				count = dtoList.size();
//			}

		}
		catch(SigitExtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaImpiantoByFiltroCount] END");
		}
		return count;
	}

	public List<SigitVRicercaImpiantiDto> cercaImpiantoByFiltro(ImpiantoFilter filter) throws DbManagerException {
		List<SigitVRicercaImpiantiDto> dtoList = null;
		log.debug("[DbMgr::cercaImpiantoByFiltro] BEGIN");
		try {

			dtoList = getSigitVRicercaImpiantiDao().findByImpiantoFilter(filter);

		}
		catch(SigitVRicercaImpiantiDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaImpiantoByFiltro] END");
		}
		return dtoList;
	}

	public List<SigitVRicercaImpiantiDto> cercaImpiantoByFiltroJWT(ImpiantoFilter filter) throws DbManagerException {
		List<SigitVRicercaImpiantiDto> dtoList = null;
		log.debug("[DbMgr::cercaImpiantoByFiltro] BEGIN");
		try {

			dtoList = getSigitVRicercaImpiantiDao().findByImpiantoFilter(filter);

		}
		catch(SigitVRicercaImpiantiDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaImpiantoByFiltro] END");
		}
		return dtoList;
	}

	public List<SigitVRicercaImpiantiDto> ricercaAvanzataImpiantoByFiltro(RicercaAvanzataImpiantoFilter filter) throws DbManagerException {
		List<SigitVRicercaImpiantiDto> dtoList = null;
		log.debug("[DbMgr::ricercaAvanzataImpiantoByFiltro] BEGIN");
		try {
			dtoList = getSigitVRicercaImpiantiDao().findImpiantiDaRicercaAvanzata(filter);
		}
		catch(SigitVRicercaImpiantiDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::ricercaAvanzataImpiantoByFiltro] END");
		}
		return dtoList;
	}

	public SigitVRicercaImpiantiDto cercaImpiantoByCodImpianto(BigDecimal codImpianto) throws DbManagerException {

		log.debug("[DbMgr::cercaImpiantoByCodImpianto] BEGIN");
		SigitVRicercaImpiantiDto dto = null;
		try {
			ImpiantoFilter filter = new ImpiantoFilter();
			filter.setCodiceImpianto(ConvertUtil.convertToInteger(codImpianto));
			List<SigitVRicercaImpiantiDto> dtoList = getSigitVRicercaImpiantiDao().findByImpiantoFilter(filter);

			if (dtoList != null && dtoList.size() > 0)
			{
				dto = dtoList.get(0);
			}
		}
		catch(SigitVRicercaImpiantiDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaImpiantoByCodImpianto] END");
		}
		return dto;
	}


	public List<SigitVTotImpiantoDto> cercaResponsabiliAttiviByCodImpianto(Integer codImpianto) throws DbManagerException {
		List<SigitVTotImpiantoDto> dtoList = null;
		log.debug("[DbMgr::cercaResponsabiliAttiviByCodImpianto] BEGIN");
		try {

			dtoList = getSigitVTotImpiantoDao().findResponsabiliAttiviByCodiceImpianto(codImpianto);

		}
		catch(SigitVTotImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaResponsabileAttivoByCodImpianto] END");
		}
		return dtoList;
	}

	public List<SigitVTotImpiantoDto> cercaResponsabiliAttiviAllaDataByCodImpianto(String codImpianto, String dataRapporto) throws DbManagerException {
		List<SigitVTotImpiantoDto> dtoList = null;
		log.debug("[DbMgr::cercaResponsabiliAttiviAllaDataByCodImpianto] BEGIN");
		try {
			ResponsabileFilter filter = new ResponsabileFilter(ConvertUtil.convertToInteger(codImpianto), ConvertUtil.convertToSqlDate(dataRapporto));

			dtoList = getSigitVTotImpiantoDao().findResponsabiliAttiviAllaDataByCodiceImpianto(filter);

		}
		catch(SigitVTotImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaResponsabiliAttiviAllaDataByCodImpianto] END");
		}
		return dtoList;
	}

	//dcosta: mev reigengnerizzazione viste: il metodo si occupa semplicemente di contare le righe che rispettano i filtri in input
	public SigitVRicerca3ResponsabileByFkPgPfRowDto cerca3ResponsabileByPfPgDataFine(Integer pfPg, String codImp, Boolean isImpresa, String dataInizio, String dataFine, Integer idContratto) throws DbManagerException {
		List<SigitVRicerca3ResponsabileByFkPgPfRowDto> dtoList = null;
		log.debug("[DbMgr::cerca3ResponsabileByPfPgDataFine] BEGIN");
		try {
			TerzoResponsabileFilter input = new TerzoResponsabileFilter();
			//dcosta: mev reigengnerizzazione viste: nella vista_ricerca_3_responsabile non c'e' pi� il collegamento con persona fisica/giuridica ma con la r_imp_ruolo_pfpg
			//per questo motivo viene sostituito il dto SigitVRicerca3ResponsabileDto con TerzoResponsabileFilter che contiene piu' campi
			//SigitVRicerca3ResponsabileDto input = new SigitVRicerca3ResponsabileDto();
			if (pfPg != null) {

				if (isImpresa)
				{
					input.setFkPgResponsabile(ConvertUtil.convertToBigDecimal(pfPg));

				}
				else
				{
					input.setFkPfResponsabile(ConvertUtil.convertToBigDecimal(pfPg));
				}
			}


			input.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImp));

			// uso il parametro DataInizioContratto impropriamente (per comodita'), in realta' e' l'inizio responsabilita' del responsabile
			input.setDataInizioContratto(ConvertUtil.convertToSqlDate(dataInizio));

			// uso il parametro DataFineContratto impropriamente (per comodita'), in realta' e' la fine responsabilita' del responsabile
			input.setDataFineContratto(ConvertUtil.convertToSqlDate(dataFine));

			if (GenericUtil.isNotNullOrEmpty(idContratto))
			{
				input.setIdContratto(ConvertUtil.convertToBigDecimal(idContratto));
			}

			//dcosta: mev reigengnerizzazione viste: invocata nuova query
//			dtoList = getSigitVRicerca3ResponsabileDao().findByFkPgPf(input);
			dtoList = getSigitVRicerca3ResponsabileDao().findByFkPgPfRow(input);

			if (dtoList != null && !dtoList.isEmpty()) {
				return dtoList.get(0);
			}

			return null;

		}
		catch(SigitVRicerca3ResponsabileDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cerca3ResponsabileByPfPgDataFine] END");
		}
	}

	/*
	public List<SigitVRicerca3ResponsabileDto> cerca3ResponsabileByCodImpiantoOld(String codImpianto) throws DbManagerException {
		List<SigitVRicerca3ResponsabileDto> dtoList = null;
		log.debug("[DbMgr::cerca3ResponsabileByCodImpianto] BEGIN");
		try {
			dtoList = getSigitVRicerca3ResponsabileDao().findByCodImpianto(ConvertUtil.convertToBigDecimal(codImpianto));

		}
		catch(SigitVRicerca3ResponsabileDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cerca3ResponsabileByCodImpianto] END");
		}
		return dtoList;
	}
	*/

	public List<SigitExtContrattoImpDto> cerca3ResponsabileByCodImpianto(String codImpianto) throws DbManagerException {
		List<SigitExtContrattoImpDto> dtoList = null;
		log.debug("[DbMgr::cerca3ResponsabileByCodImpianto] BEGIN");
		try {
			ContrattoFilter filterContratti = new ContrattoFilter();
			filterContratti.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dtoList = getSigitExtDao().findStoriaContrattiImpiantoNew(filterContratti);
			//dtoList = getSigitVRicerca3ResponsabileDao().findByCodImpianto(ConvertUtil.convertToBigDecimal(codImpianto));

		}
		catch(SigitExtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cerca3ResponsabileByCodImpianto] END");
		}
		return dtoList;
	}




	public List<SigitVTotImpiantoDto> cerca3ResponsabileAttivoByCodImpianto(Integer codImpianto) throws DbManagerException {
		List<SigitVTotImpiantoDto> dtoList = null;
		log.debug("[DbMgr::cerca3ResponsabileAttivoByCodImpianto] BEGIN");
		try {

			dtoList = getSigitVTotImpiantoDao().findTerziResponsabiliAttiviByCodiceImpianto(codImpianto);

		}
		catch(SigitVTotImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cerca3ResponsabileAttivoByCodImpianto] END");
		}
		return dtoList;
	}

	public List<SigitVAllegatiComponentiDto> cerca3RespAllCompByFilterAttivoByCodImpianto(String codImpianto, Integer idContrattoSelez, String dataRevoca) throws DbManagerException {
		List<SigitVAllegatiComponentiDto> dtoList = null;
		log.debug("[DbMgr::cerca3RespAllCompByFilterAttivoByCodImpianto] BEGIN");
		try {

			AllegatiCompFilter filter = new AllegatiCompFilter(codImpianto, idContrattoSelez, ConvertUtil.convertToSqlDate(dataRevoca));

			filter.setStatiRappEqual(new ArrayList<Integer>());
			filter.getStatiRappEqual().add(Constants.ID_STATO_RAPPORTO_INVIATO);


			dtoList = getSigitVAllegatiComponentiDao().findAllegatiByFilter(filter);
		}
		catch(SigitVAllegatiComponentiDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cerca3RespAllCompByFilterAttivoByCodImpianto] END");
		}
		return dtoList;
	}

	public Integer contaAllegatiCompByFilter(CompFilter compFilter, List<Integer> statiREEIn ) throws DbManagerException {
		log.debug("[DbMgr::contaAllegatiCompByFilter] BEGIN");
		List<SigitVAllegatiComponentiDto> dtoList = cercaAllegatiCompByFilter(compFilter, statiREEIn);

		log.debug("[DbMgr::contaAllegatiCompByFilter] END");
		if (dtoList != null) {
			return dtoList.size();
		} else {
			return 0;
		}
	}

	public List<SigitVAllegatiComponentiDto> cercaAllegatiCompByFilter(CompFilter compFilter, List<Integer> statiREEIn ) throws DbManagerException {
		log.debug("[DbMgr::cercaAllegatiCompByFilter] BEGIN");
		List<SigitVAllegatiComponentiDto> dtoList = null;
		try {
			AllegatiCompFilter filter = new AllegatiCompFilter(statiREEIn, compFilter);
			dtoList = getSigitVAllegatiComponentiDao().findAllegatiByFilter(filter);
		}catch(SigitVAllegatiComponentiDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaAllegatiCompByFilter] END");
		}

		return dtoList;
	}

	public List<SigitVAllegatiComponentiDto> cercaAllegatiCompSysdateByFilter(Subentro subentro) throws DbManagerException {
		log.debug("[DbMgr::cercaAllegatiCompByFilter] BEGIN");
		List<SigitVAllegatiComponentiDto> dtoList = null;
		try {

			AllegatiCompFilter input = new AllegatiCompFilter();
			input.setCodImpianto(subentro.getImpCodImpianto());

			if (subentro.getIdApparecchiature() != null && subentro.getIdApparecchiature().size() > 0)
			{
				String descTipoComp = null;
				int tipoSub = subentro.getIdTipoSubentro().intValue();

				if (tipoSub == Constants.ID_RUOLO_MANUTENTORE_ALL_1)
				{
					descTipoComp = Constants.TIPO_COMPONENTE_GT;
				} else if (tipoSub == Constants.ID_RUOLO_MANUTENTORE_ALL_2)
				{
					descTipoComp = Constants.TIPO_COMPONENTE_GF;
				} else if (tipoSub == Constants.ID_RUOLO_MANUTENTORE_ALL_3)
				{
					descTipoComp = Constants.TIPO_COMPONENTE_SC;
				} else if (tipoSub == Constants.ID_RUOLO_MANUTENTORE_ALL_4)
				{
					descTipoComp = Constants.TIPO_COMPONENTE_CG;
				}

				CompFilter inputComp = new CompFilter();
				inputComp.setTipoComponente(descTipoComp);
				inputComp.setListProgressivi(subentro.getIdApparecchiature());

				input.setComponente(inputComp);
			}

			dtoList = getSigitVAllegatiComponentiDao().findAllegatiDataContrSysdateByFilter(input);

		}catch(SigitVAllegatiComponentiDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaAllegatiCompByFilter] END");
		}

		return dtoList;
	}

	public List<SigitTContratto2019Dto> cercaContrattiSysdateByCodImpiantoFilter(String codImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaContrattiSysdateByCodImpiantoFilter] BEGIN");
		List<SigitTContratto2019Dto> dtoList = null;
		try {


			dtoList = getSigitTContratto2019Dao().findByCodImpSysdate(ConvertUtil.convertToBigDecimal(codImpianto));

		}catch(SigitTContratto2019DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaContrattiSysdateByCodImpiantoFilter] END");
		}

		return dtoList;
	}

	public List<SigitVAllegatiComponentiDto> cercaAllegatiByFilterAttivoByCodImpianto(String codImpianto, Integer idRuoloPfpg) throws DbManagerException {
		List<SigitVAllegatiComponentiDto> dtoList = null;
		log.debug("[DbMgr::cerca3RespAllCompByFilterAttivoByCodImpianto] BEGIN");
		try {

			AllegatiCompFilter filter = new AllegatiCompFilter(codImpianto, idRuoloPfpg);

			dtoList = getSigitVAllegatiComponentiDao().findAllegatiByFilter(filter);
		}
		catch(SigitVAllegatiComponentiDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cerca3RespAllCompByFilterAttivoByCodImpianto] END");
		}
		return dtoList;
	}

//	public List<SigitVTotImpiantoDto> cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(String codImpianto, String dataRapporto, String idTipoComponente, String componente) throws DbManagerException {
//		//DCOSTA: METODO PRIMA DELLA REINGEGNERIZZAZIONE DELLE VISTE
//		List<SigitVTotImpiantoDto> dtoList = null;
//		log.debug("[DbMgr::cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp] BEGIN");
//		try {
//			ContrattoFilter filter = new ContrattoFilter();
//			filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
//			filter.setDataDal(ConvertUtil.convertToSqlDate(dataRapporto));
//			filter.setIdTipoComponente(idTipoComponente);
//			filter.setComponente(componente);
//
//			dtoList = MapDto.convertToListTotImpianto(getSigitExtDao().findStoriaContrattiImpiantoNew(filter));
//		} catch (SigitExtDaoException e) {
//			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
//		}
//		finally {
//			log.debug("[DbMgr::cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp] END");
//		}
//		return dtoList;
//	}

	public List<SigitVRicerca3ResponsabileDto> cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(String codImpianto, String dataRapporto) throws DbManagerException {
		List<SigitVRicerca3ResponsabileDto> dtoList = null;
		log.debug("[DbMgr::cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp] BEGIN");
		try {
			ContrattoFilter filter = new ContrattoFilter();
			filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filter.setDataDal(ConvertUtil.convertToSqlDate(dataRapporto));

			dtoList = MapDto.convertToListTotImpianto(getSigitExtDao().findStoriaContrattiImpiantoNew(filter));
		} catch (SigitExtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp] END");
		}
		return dtoList;
	}


	//dcosta: mev reingegnerizzazione viste. Invece di restituire SigitVTotImpiantoDto verr� restituito Integer poiche' gli usi di questa query servono solo a contare i risultati
	public Integer cercaPrimoResponsabileAttivoAllaDataByCodImpiantoApp(String codImpianto, String dataRapporto, ArrayList<String> listaProgressivi) throws DbManagerException
	{
		// Cerco preventivamente il responsabile
		// nel caso in cui non ci sia il responsabile cerco per ogni apparecchiature se esiste un 3 responsabile
		// se anche per una sola apparecchiatura non e' presente il 3 responsabile rilancio l'eccezione

		List<SigitVTotImpiantoDto> listResp = cercaResponsabiliAttiviAllaDataByCodImpianto(codImpianto, dataRapporto);
		if(listResp!=null && !listResp.isEmpty()){
			return listResp.size();
		}

		// Nel caso in cui non ci sia il responsabile ricerco i 3 responsabile per ogni apparecchiatura
		for (String progressivo : listaProgressivi) {

			//dcosta: mev reingegnerizzazione viste. Invece di restituire List<SigitVTotImpiantoDto> verr� restituita List<SigitVRicerca3ResponsabileDto>
			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(codImpianto, dataRapporto);
			if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty()){

				// Alla prima apparecchiatura che non ha il 3 responsabile (e se sono qui e' perche' non ha neanche il responsabile) esco
				return null;

			}else{
				return list3RespAttiviImpianto.size();
			}
		}
		return null;
	}

	public SigitVTotImpiantoDto cercaResponsabileAttivoByCodImpianto(Integer codImpianto) throws DbManagerException
	{
		SigitVTotImpiantoDto responsabile = null;

		List<SigitVTotImpiantoDto> listResp = cercaResponsabiliAttiviByCodImpianto(codImpianto);
		if(listResp!=null && !listResp.isEmpty()){
			responsabile = listResp.get(0);
		}

		return responsabile;
	}

	/*
	public SigitVTotImpiantoDto cercaResponsabileAttivoByCodImpiantoOLD(Integer codImpianto) throws DbManagerException
	{
		SigitVTotImpiantoDto responsabile = null;
		List<SigitVTotImpiantoDto> list3RespAttiviImpianto = cerca3ResponsabileAttivoByCodImpianto(codImpianto);
		if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty()){
			List<SigitVTotImpiantoDto> listResp = cercaResponsabiliAttiviByCodImpianto(codImpianto);
			if(listResp!=null && !listResp.isEmpty()){
				responsabile = listResp.get(0);
			}
		}else{
			responsabile = list3RespAttiviImpianto.get(0);
		}

		return responsabile;
	}
	*/

	public SigitVTotImpiantoDto cercaResponsabileAttivoAllaDataImpianto(Integer codImpianto, java.sql.Date data) throws DbManagerException
	{
		log.debug("[DbMgr:::cercaResponsabileAttivoAllaDataImpianto] START");
		SigitVTotImpiantoDto responsabile = null;
		ResponsabileFilter input = new ResponsabileFilter();
		input.setCodiceImpianto(codImpianto);
		input.setDataRapporto(data);
		List<SigitVTotImpiantoDto> listResp;
		try {
			listResp = getSigitVTotImpiantoDao().findResponsabiliAttiviAllaDataByCodiceImpianto(input);
			if(listResp!=null && !listResp.isEmpty()){
				responsabile = listResp.get(0);
			}
		} catch (SigitVTotImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally{
			log.debug("[DbMgr:::cercaResponsabileAttivoAllaDataImpianto] END");
		}
		return responsabile;
	}

	/*
	public List<SigitTCodiceImpDto> cercaCodiciImpiantoLiberiByIdTrans(Integer idTransazione) throws DbManagerException {
		List<SigitTCodiceImpDto> dtoList = null;
		log.debug("[DbMgr::cercaCodiciImpiantoLiberiByIdTrans] BEGIN");
		try {

			dtoList = getSigitTCodiceImpDao().findCodImpiantoLiberiByIdTrans(idTransazione);

		}
		catch(SigitTCodiceImpDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaCodiciImpiantoLiberiByIdTrans] END");
		}
		return dtoList;
	}
	*/

	public Integer cercaCodiciImpiantoUtilizzatiByIdTransCount(Integer idtransazione) throws DbManagerException {
		Integer count = null;
		log.debug("[DbMgr::cercaCodiciImpiantoUtilizzatiByIdTransCount] BEGIN");
		try {

			//dtoList = getSigitTCodiceImpDao().findCodImpiantoUtilizzatiByIdTrans(idtransazione);
			count = getSigitExtDao().findCodImpiantoUtilizzatiByIdTransCount(idtransazione);
//			if (dtoList != null)
//			{
//				// Recupero il totale dei codici impianti utilizzati per idTransazione
//				count = dtoList.size();
//			}

		}
		catch(SigitExtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaCodiciImpiantoUtilizzatiByIdTransCount] END");
		}
		return count;
	}

//	/**
//	 * Cerca un manutentore nel DB
//	 *
//	 * @param codiceFiscale Codice fiscale dell'installatore
//	 * @param siglaRea Sigla REA dell'installatore
//	 * @param numeroRea Numero REA dell'installatore
//	 * @return PersonaGiuridica trovata, null se non trovato
//	 * @throws DbManagerException Errore durante il recupero della
//	 *             persona giuridica
//	 */
//	public PersonaGiuridica cercaPersonaGiuridica(String codiceFiscale, String siglaRea, String numeroRea) throws DbManagerException {
//		PersonaGiuridica obj = null;
//
//		SigitTPersonaGiuridicaDto dto = null;
//		BigDecimal numRea = null;
//
//		if(!StringUtils.isBlank(numeroRea)) {
//			numRea = new BigDecimal(numeroRea);
//		}
//
//		try {
//			dto = cercaPersonaGiuridica(codiceFiscale, siglaRea, numRea);
//
//			if (dto != null)
//			{
//				obj = MapDto.mapToPersonaGiuridica(dto);
//			}
//		}
//		catch(DbManagerException e) {
//			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
//		}
//		return obj;
//	}

	/**
	 * Cerca un manutentore
	 *
	 * @param codiceFiscale Codice fiscale del manutentore
	 * @param siglaRea Sigla REA
	 * @param numeroRea Numero REA
	 * @return Manutentore associato al codice fiscale e/o al codice REA (Sigla +
	 *         Numero)
	 * @throws DbManagerException Errore durante l'accesso ai dati
	 */
	public List<SigitTPersonaGiuridicaDto> cercaPersonaGiuridica(String codiceFiscale, String siglaRea, BigDecimal numeroRea) throws DbManagerException {
		return cercaPersonaGiuridica(codiceFiscale, siglaRea, numeroRea, false);
	}

	/**
	 * Cerca un manutentore
	 *
	 * @param codiceFiscale Codice fiscale del manutentore
	 * @param siglaRea Sigla REA
	 * @param numeroRea Numero REA
	 * @return Manutentore associato al codice fiscale e/o al codice REA (Sigla +
	 *         Numero)
	 * @throws DbManagerException Errore durante l'accesso ai dati
	 */
	public List<SigitTPersonaGiuridicaDto> cercaPersonaGiuridica(String codiceFiscale, String siglaRea, BigDecimal numeroRea, boolean flgDm37LetteraC) throws DbManagerException {
		log.debug("[DbMgr::cercaPersonaGiuridica] BEGIN");
		List<SigitTPersonaGiuridicaDto> dtoList = null;
		CodiceReaAndFiscaleFilter codiceReaFiscaleFilter = null;

		try {
			if (GenericUtil.isNotNullOrEmpty(codiceFiscale) && GenericUtil.isNotNullOrEmpty(siglaRea) && (numeroRea != null))
			{
				// Ha selezionato sia CF che CodiceRea
				codiceReaFiscaleFilter = new CodiceReaAndFiscaleFilter(siglaRea, numeroRea, codiceFiscale, flgDm37LetteraC);
				dtoList = getSigitTPersonaGiuridicaDao().findByCodiceReaAndFiscale(codiceReaFiscaleFilter);
			}
			else if(GenericUtil.isNotNullOrEmpty(codiceFiscale))
			{
				// Ha selezionato solo il CF
				codiceReaFiscaleFilter = new CodiceReaAndFiscaleFilter(codiceFiscale, flgDm37LetteraC);
				dtoList = getSigitTPersonaGiuridicaDao().findByCodiceFiscale(codiceReaFiscaleFilter);
			}
			else if(GenericUtil.isNotNullOrEmpty(siglaRea) && (numeroRea != null))
			{
				// Ha selezionato solo il CodiceRea
				codiceReaFiscaleFilter = new CodiceReaAndFiscaleFilter(siglaRea, numeroRea, flgDm37LetteraC);
				dtoList = getSigitTPersonaGiuridicaDao().findByCodiceRea(codiceReaFiscaleFilter);
			}

		}
		catch(SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaPersonaGiuridica] END");
		return dtoList;
	}

	/**
	 * Cerca le imprese in base ai parametri di ricerca
	 *
	 * @param impresa Impresa da ricercare
	 * @return Imprese
	 * @throws DbManagerException Errore durante l'accesso ai dati
	 */

	public List<SigitTPersonaGiuridicaByParamDto> cercaImpreseByParam(RicercaImprese ricImpresa) throws DbManagerException {
		log.debug("[DbMgr::cercaPersonaGiuridica] BEGIN");
		List<SigitTPersonaGiuridicaByParamDto> dtoList = null;

		try {

			SigitTPersonaGiuridicaDto impresaFilter = new SigitTPersonaGiuridicaDto();

			if (GenericUtil.isNotNullOrEmpty(ricImpresa.getCodiceFiscale()))
			{
				impresaFilter.setCodiceFiscale(ricImpresa.getCodiceFiscale());
			}

			if (GenericUtil.isNotNullOrEmpty(ricImpresa.getSiglaRea()))
			{
				impresaFilter.setSiglaRea(ricImpresa.getSiglaRea());
			}

			if (GenericUtil.isNotNullOrEmpty(ricImpresa.getNumeroRea()))
			{
				impresaFilter.setNumeroRea(ConvertUtil.convertToBigDecimal(ricImpresa.getNumeroRea()));
			}

			if (GenericUtil.isNotNullOrEmpty(ricImpresa.getDenominazione()))
			{
				impresaFilter.setDenominazione(ricImpresa.getDenominazione());
			}

			if (GenericUtil.isNotNullOrEmpty(ricImpresa.getDescRuolo()))
			{
				String descRuolo = ricImpresa.getDescRuolo();

//				if (descRuolo.equals(Constants.RUOLO_INSTALLATORE))
//				{
//					impresaFilter.setFlgInstallatore(ConvertUtil.convertToBigDecimal(true));
//				}
				if (descRuolo.equals(Constants.RUOLO_IMPRESA))
				{
					impresaFilter.setFlgDm37Letterac(ConvertUtil.convertToBigDecimal(true));
				}
				else if (descRuolo.equals(Constants.RUOLO_3RESPONSABILE))
				{
					impresaFilter.setFlgTerzoResponsabile(ConvertUtil.convertToBigDecimal(true));
				}
				else if (descRuolo.equals(Constants.RUOLO_DISTRIBUTORE))
				{
					impresaFilter.setFlgDistributore(ConvertUtil.convertToBigDecimal(true));
				}
				else if (descRuolo.equals(Constants.RUOLO_AMMINISTRATORE))
				{
					impresaFilter.setFlgAmministratore(ConvertUtil.convertToBigDecimal(true));
				}
				else if (descRuolo.equals(Constants.RUOLO_CAT))
				{
					impresaFilter.setFlgCat(ConvertUtil.convertToBigDecimal(true));
				}
			}



			if (GenericUtil.isNotNullOrEmpty(ricImpresa.getIdStatoPg()))
			{
				impresaFilter.setFkStatoPg(ricImpresa.getIdStatoPg());
			}

			dtoList = getSigitTPersonaGiuridicaDao().findByParam(impresaFilter);

		}
		catch(SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaPersonaGiuridica] END");
		return dtoList;
	}

	/**
	 * Cerca le imprese in base ai parametri di ricerca
	 *
	 * @param impresa Cat
	 * @return Imprese
	 * @throws DbManagerException Errore durante l'accesso ai dati
	 */

	public List<SigitTPersonaGiuridicaDto> cercaIncarichiAttiviCat(Integer idCat) throws DbManagerException {
		log.debug("[DbMgr::cercaIncarichiAttiviCat] BEGIN");
		List<SigitTPersonaGiuridicaDto> dtoList = null;

		try {

			dtoList = getSigitTPersonaGiuridicaDao().findIncarichiCatAttivi(idCat);

		}
		catch(SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaIncarichiAttiviCat] END");
		return dtoList;
	}

	public Integer cercaTotRapportiInviatiCat(Integer idCat) throws DbManagerException {
		log.debug("[DbMgr::cercaTotRapportiInviatiCat] BEGIN");
		Integer count = null;

		try {

			count = getSigitExtDao().findRapportiInviatiCatCount(idCat);

		}
		catch(SigitExtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaTotRapportiInviatiCat] END");
		return count;
	}

	/**
	 * Cerca un amministratore
	 *
	 * @param codiceFiscale Codice fiscale dell'amministratore
	 * @throws DbManagerException Errore durante l'accesso ai dati
	 */
	public List<SigitTPersonaGiuridicaDto> cercaPersonaGiuridicaByCodiceFiscale(String codiceFiscale) throws DbManagerException {
		log.debug("[DbMgr::cercaPersonaGiuridicaByCodiceFiscale] BEGIN");
		List<SigitTPersonaGiuridicaDto> dtoList = null;

		try {
			CodiceReaAndFiscaleFilter codiceReaFiscaleFilter = new CodiceReaAndFiscaleFilter(codiceFiscale);
			dtoList = getSigitTPersonaGiuridicaDao().findByCodiceFiscale(codiceReaFiscaleFilter);
		}
		catch(SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaPersonaGiuridicaByCodiceFiscale] END");
		return dtoList;
	}


	/**
	 * Cerca codici impianto per RESPONSABILE O/E AMMINISTRATORE
	 *
	 * @param idPersonaGiuridica del 3 reponsabile
	 * @throws DbManagerException Errore durante l'accesso ai dati
	 * @throws
	 */
	public List<SigitRImpRuoloPfpgDto> cercaCodiciImpiantoResponsabileAmministratore(FiltroRicercaCodiciImpianto filtro) throws DbManagerException {
		log.debug("[DbMgr::cercaCodiciImpiantoResponsabileAmministratore] BEGIN");
		List<SigitRImpRuoloPfpgDto> dtoList = null;
		try {

			dtoList = this.getSigitRImpRuoloPfpgDao().findByRuoloConUtente(filtro);

		}
		catch(SigitRImpRuoloPfpgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaCodiciImpiantoResponsabileAmministratore] END");
		return dtoList;
	}

	public List<SigitRImpRuoloPfpgDto> cercaResponsabileImpresa(Integer idPersonaGiuridica) throws DbManagerException {
		log.debug("[DbMgr::cercaResponsabileImpresa] BEGIN");
		List<SigitRImpRuoloPfpgDto> dtoList = null;
		try {
			FiltroRicercaCodiciImpianto filtro = new FiltroRicercaCodiciImpianto();
			filtro.setDescrizioneRuoloFunzionale(Constants.RUOLO_RESPONSABILE_IMPRESA);
			filtro.setIdPersonaGiuridica(idPersonaGiuridica.toString());
			filtro.setIdRuolo(new ArrayList<String>());
			filtro.getIdRuolo().add(ConvertUtil.convertToString(Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE));
			filtro.getIdRuolo().add(ConvertUtil.convertToString(Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO));
			filtro.getIdRuolo().add(ConvertUtil.convertToString(Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE));
			dtoList = getSigitRImpRuoloPfpgDao().findByRuoloConUtente(filtro);
		}
		catch(SigitRImpRuoloPfpgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaResponsabileImpresa] END");
		return dtoList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<SigitRPfPgDelegaDto> cercaPersonaGiuDelByIdPersFis(Integer idPersonaF) throws DbManagerException {
		List<SigitRPfPgDelegaDto> dtoList = null;
		log.debug("[DbMgr::cercaPGiuDelByIdPersFis] BEGIN");
		try {

			dtoList = getSigitRPfPgDelegaDao().findValideByIdPersonaFisica(idPersonaF);

		}
		catch(SigitRPfPgDelegaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPGiuDelByIdPersFis] END");
		}
		return (ArrayList<SigitRPfPgDelegaDto>) convertToArrayList(dtoList);
	}

	public ArrayList<Delegato> cercaPersonaFisDelByIdPersGiu(Integer idPersonaG) throws DbManagerException {

		ArrayList<Delegato> risRicResp = new ArrayList<Delegato>();

		log.debug("[DbMgr::cercaPersonaFisDelByIdPersGiu] BEGIN");
		try {

			List<SigitRPfPgDelegaPersonaFisicaByIdPersonaGiuridicaDto> dtoList = getSigitRPfPgDelegaDao().findPersonaFisicaByIdPersonaGiuridica(idPersonaG);

			for (SigitRPfPgDelegaPersonaFisicaByIdPersonaGiuridicaDto sigitRImpRuoloPfpgDto : dtoList) {
				risRicResp.add(MapDto.mapToDelegato(sigitRImpRuoloPfpgDto));
			}
		}
		catch(SigitRPfPgDelegaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaFisDelByIdPersGiu] END");
		}
		return risRicResp;
	}

	public ArrayList<Incaricato> cercaPersonaGiuIncByIdPersGiu(Integer idPersonaG) throws DbManagerException {

		ArrayList<Incaricato> risRicResp = new ArrayList<Incaricato>();

		log.debug("[DbMgr::cercaPersonaGiuIncByIdPersGiu] BEGIN");
		try {

			List<SigitRPgPgNominaPersonaGiuridicaCatByIdPersonaGiuridicaDto> dtoList = getSigitRPgPgNominaDao().findPersonaGiuridicaCatByIdPersonaGiuridica(idPersonaG);

			for (SigitRPgPgNominaPersonaGiuridicaCatByIdPersonaGiuridicaDto sigitRPgPgNominaDto : dtoList) {
				risRicResp.add(MapDto.mapToIncaricoCat(sigitRPgPgNominaDto));
			}
		}
		catch(SigitRPgPgNominaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaGiuIncByIdPersGiu] END");
		}
		return risRicResp;
	}

	public List<SigitTPersonaGiuridicaDto> cercaPersonaGiuCatAttivi() throws DbManagerException {

		List<SigitTPersonaGiuridicaDto> dtoList = null;

		log.debug("[DbMgr::cercaPersonaGiuIncByIdPersGiu] BEGIN");
		try {

			dtoList = getSigitTPersonaGiuridicaDao().findCatValidi(null);

		}
		catch(SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaGiuIncByIdPersGiu] END");
		}
		return dtoList;
	}

	public List<SigitTPersonaGiuridicaDto> cercaPersonaGiuCat() throws DbManagerException {

		List<SigitTPersonaGiuridicaDto> dtoList = null;

		log.debug("[DbMgr::cercaPersonaGiuCat] BEGIN");
		try {

			dtoList = getSigitTPersonaGiuridicaDao().findCat(null);

		}
		catch(SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaGiuCat] END");
		}
		return dtoList;
	}

	public ArrayList<DettaglioImportDistributori> cercaElencoImportByIdDistr(Integer idPersonaG) throws DbManagerException {

		ArrayList<DettaglioImportDistributori> risElencoImport = new ArrayList<DettaglioImportDistributori>();

		log.debug("[DbMgr::cercaElencoImportByIdDistr] BEGIN");
		try {

			List<SigitTImportDistribByIdPersonaGiuridicaDto> dtoList = getSigitTImportDistribDao().findByIdPersonaGiuridica(idPersonaG);

			for (SigitTImportDistribByIdPersonaGiuridicaDto sigitTImportDistribByIdPgDto : dtoList) {
				risElencoImport.add(MapDto.mapToImportDistributori(sigitTImportDistribByIdPgDto));
			}
		}
		catch(SigitTImportDistribDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaElencoImportByIdDistr] END");
		}

		return risElencoImport;
	}

	public void salvaImportDistributore(ImportDistribFilter dataFile, String utenteUltMod) throws DbManagerException {
		log.debug("[DbMgr::salvaImportDistributore] BEGIN");

		try {

			SigitTImportDistribDto codiceBollDto = MapDto.getSigitTImportDistribDto(dataFile, utenteUltMod);

			getSigitTImportDistribDao().insert(codiceBollDto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaImportDistributore] END");
		}

	}

	@Transactional
	public void salvaImportSostituzioneDistributore(ImportDistribFilter dataFile, String utenteUltMod) throws DbManagerException {
		log.debug("[DbMgr::salvaImportSostituzioneDistributore] BEGIN");

		try {

			SigitTImportDistribDto codiceBollDto = MapDto.getSigitTImportDistribDto(dataFile, utenteUltMod);

			getSigitTImportDistribDao().insert(codiceBollDto);

			SigitTImportDistribDto impDistrSost = new SigitTImportDistribDto();
			impDistrSost.setIdImportDistrib(dataFile.getIdImportSostituzione());
			impDistrSost.setFkStatoDistrib(Constants.ID_STATO_IMP_DISTRIBUTORE_SOSTITUITO);
			impDistrSost.setDataAnnullamento(DateUtil.getSqlDataCorrente());

			impDistrSost.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(utenteUltMod));
			impDistrSost.setDataUltMod(DateUtil.getSqlDataCorrente());

			// Modifico l'import sostituito
			getSigitTImportDistribDao().updateColumnsAnnullaImport(impDistrSost);

			// Elimino i valori dell'import sostituito
			getSigitTRifCatastDao().customDeleterByIdImportDistrib(dataFile.getIdImportSostituzione());
//			getSigitTDatoDistribDao().customDeleterByFkImportDistrib(dataFile.getIdImportSostituzione());

		}
		catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaImportSostituzioneDistributore] END");
		}

	}

	public SigitTDatoDistribDto cercaDatoDistributore(Integer idDatoDistributore) throws DbManagerException {
		log.debug("[DbMgr::cercaDatoDistributore] BEGIN");
		SigitTDatoDistribDto risultato = null;

		try {
			risultato = getSigitTDatoDistribDao().findByPrimaryKey(new SigitTDatoDistribPk(idDatoDistributore));
		}
		catch(SigitTDatoDistribDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaDatoDistributore] END");
		return risultato;
	}

	public SigitTImportDistribDto cercaImportDistributore(Integer idImportDistributore) throws DbManagerException {
		log.debug("[DbMgr::cercaImportDistributore] BEGIN");
		SigitTImportDistribDto risultato = null;

		try {
			risultato = getSigitTImportDistribDao().findByPrimaryKey(new SigitTImportDistribPk(idImportDistributore));
		} catch(SigitTImportDistribDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaImportDistributore] END");
		return risultato;
	}

	public List<SigitTDatoDistribDto> cercaDatiDistributoreByIdImportDistributore(Integer idImportDistributore) throws DbManagerException {
		log.debug("[DbMgr::cercaDatiDistributoreByIdImportDistributore] BEGIN");
		List<SigitTDatoDistribDto> distributori = null;

		try {
			distributori = getSigitTDatoDistribDao().findByIdImportDistrib(idImportDistributore);
		}
		catch(SigitTDatoDistribDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaDatiDistributoreByIdImportDistributore] END");
		return distributori;
	}

	@Transactional
	public void annullaImportDistributore(Integer idImport, String utenteUltMod) throws DbManagerException {
		log.debug("[DbMgr::annullaImportDistributore] BEGIN");
 
		try {

			SigitTImportDistribDto impDistrSost = new SigitTImportDistribDto();
			impDistrSost.setIdImportDistrib(idImport);
			impDistrSost.setFkStatoDistrib(Constants.ID_STATO_IMP_DISTRIBUTORE_ELIMINATO);
			impDistrSost.setDataAnnullamento(DateUtil.getSqlDataCorrente());
			impDistrSost.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(utenteUltMod));
			impDistrSost.setDataUltMod(DateUtil.getSqlDataCorrente());



			// Modifico l'import sostituito
			getSigitTImportDistribDao().updateColumnsAnnullaImport(impDistrSost);

			// Elimino i valori dell'import sostituito
//			getSigitTRifCatastDao().customDeleterByIdImportDistrib(idImport);
//			getSigitTDatoDistribDao().customDeleterByFkImportDistrib(idImport);

		}
		catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::annullaImportDistributore] END");
		}

	}

	public List<SigitTLogDistribDto> cercaErroriImportDistributoriByIdImport(Integer idImport) throws DbManagerException {
		List<SigitTLogDistribDto> dtoList = null;
		log.debug("[DbMgr::cercaErroriImportDistributoriByIdImport] BEGIN");
		try {

			dtoList = getSigitTLogDistribDao().findByIdImportDistrib(idImport);

			return dtoList;
		}
		catch(SigitTLogDistribDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaErroriImportDistributoriByIdImport] END");
		}
	}

	public SigitTImportDistribRicevutaByIdImportDistribDto cercaImportRicevutaByIdDistr(Integer idImportDistrib) throws DbManagerException {

		SigitTImportDistribRicevutaByIdImportDistribDto risImportDistrib = null;

		log.debug("[DbMgr::cercaImportRicevutaByIdDistr] BEGIN");
		try {

			List<SigitTImportDistribRicevutaByIdImportDistribDto> dtoList = getSigitTImportDistribDao().findRicevutaByIdImportDistrib(idImportDistrib);

			if (dtoList != null && dtoList.size() > 0)
			{
				// Ho fatto la riceca per chiave, quindi sicuramente ne trovera' uno solo
				risImportDistrib = dtoList.get(0);
			}

		}
		catch(SigitTImportDistribDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaImportRicevutaByIdDistr] END");
		}

		return risImportDistrib;
	}


	@SuppressWarnings("unchecked")
	public ArrayList<SigitRPfPgDelegaDto> cercaSigitRPfPgDelegaAttByFilter(SigitRPfPgDelegaDto filter) throws DbManagerException {
		List<SigitRPfPgDelegaDto> dtoList = null;
		log.debug("[DbMgr::cercaSigitRPfPgDelegaAttByIdPersonaGiuridicaFisica] BEGIN");
		try {
			dtoList = getSigitRPfPgDelegaDao().findAttivaByFilter(filter);
		}
		catch(SigitRPfPgDelegaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitRPfPgDelegaAttByIdPersonaGiuridicaFisica] END");
		}
		return (ArrayList<SigitRPfPgDelegaDto>) convertToArrayList(dtoList);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<SigitRPgPgNominaDto> cercaSigitRPgPgIncaricoAttByIdPersonaGiuridicaCat(Integer idPersonaGCat) throws DbManagerException {
		List<SigitRPgPgNominaDto> dtoList = null;
		log.debug("[DbMgr::cercaSigitRPgPgIncaricoAttByIdPersonaGiuridicaCat] BEGIN");
		try {
			dtoList = getSigitRPgPgNominaDao().findAttivaByIdPersonaGiuridicaCat(idPersonaGCat);

		}
		catch(SigitRPgPgNominaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitRPgPgIncaricoAttByIdPersonaGiuridicaCat] END");
		}
		return (ArrayList<SigitRPgPgNominaDto>) convertToArrayList(dtoList);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<SigitRPgPgNominaDto> cercaSigitRPgPgIncaricoAttByIdPersonaGiuridicaImpGiuridicaCat(Integer idPersonaGImp, String idPersonaGCat) throws DbManagerException {
		List<SigitRPgPgNominaDto> dtoList = null;
		log.debug("[DbMgr::cercaSigitRPgPgIncaricoAttByIdPersonaGiuridicaImpGiuridicaCat] BEGIN");
		try {
			SigitRPgPgNominaDto filter = new SigitRPgPgNominaDto();
			filter.setIdPersonaGiuridicaCat(ConvertUtil.convertToBigDecimal(idPersonaGCat));
			filter.setIdPersonaGiuridicaImpresa(ConvertUtil.convertToBigDecimal(idPersonaGImp));

			dtoList = getSigitRPgPgNominaDao().findAttivaByIdPersonaGiuridicaImpGiuridicaCat(filter);

		}
		catch(SigitRPgPgNominaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitRPgPgIncaricoAttByIdPersonaGiuridicaImpGiuridicaCat] END");
		}
		return (ArrayList<SigitRPgPgNominaDto>) convertToArrayList(dtoList);
	}

	public SigitRPgPgNominaDto cercaSigitRPgPgNominaById(Integer idPersonaGImp, String idPersonaGCat) throws DbManagerException {
		SigitRPgPgNominaDto dto = null;
		log.debug("[DbMgr::cercaSigitRPgPgNominaById] BEGIN");
		try {
			SigitRPgPgNominaPk pk = new SigitRPgPgNominaPk(ConvertUtil.convertToBigDecimal(idPersonaGCat), ConvertUtil.convertToBigDecimal(idPersonaGImp), DateUtil.getSqlCurrentDate());

			dto = getSigitRPgPgNominaDao().findByPrimaryKey(pk);

		}
		catch(SigitRPgPgNominaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitRPgPgNominaById] END");
		}
		return dto;
	}

	public SigitRPfPgDelegaDto cercaSigitRPfPgDelegaAttByIdPersonaGiuridicaCFFisica(Integer idPersonaG, String CFPersonaF) throws DbManagerException {
		SigitRPfPgDelegaDto dto = null;
		log.debug("[DbMgr::cercaSigitRPfPgDelegaAttByIdPersonaGiuridicaCFFisica] BEGIN");
		try {

			List<SigitRPfPgDelegaDto> dtoList = getSigitRPfPgDelegaDao().findAttivaByIdPersonaGiuridicaCFFisica(new DelegaFilter(idPersonaG, CFPersonaF));

			// Ne dovrebbe trovare uno solo di attivo
			if (dtoList != null && dtoList.size() == 1)
			{
				dto = dtoList.get(0);
			}

			return dto;
		}
		catch(SigitRPfPgDelegaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitRPfPgDelegaAttByIdPersonaGiuridicaCFFisica] END");
		}
	}

	public SigitRPfPgDelegaDto cercaSigitRPfPgDelegaById(Integer idPersonaG, String idPersonaF) throws DbManagerException {
		SigitRPfPgDelegaDto dto = null;
		log.debug("[DbMgr::cercaSigitRPfPgDelegaById] BEGIN");
		try {
			SigitRPfPgDelegaDto filter = new SigitRPfPgDelegaDto();
			filter.setIdPersonaGiuridica(ConvertUtil.convertToBigDecimal(idPersonaG));
			filter.setIdPersonaFisica(ConvertUtil.convertToBigDecimal(idPersonaF));

			SigitRPfPgDelegaPk pk = new SigitRPfPgDelegaPk(ConvertUtil.convertToBigDecimal(idPersonaF), ConvertUtil.convertToBigDecimal(idPersonaG), DateUtil.getSqlCurrentDate());

			dto = getSigitRPfPgDelegaDao().findByPrimaryKey(pk);

		}
		catch(SigitRPfPgDelegaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitRPfPgDelegaById] END");
		}
		return dto;
	}

	public void cessaDelega(String chiaveDelegato, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::cessaDelega] BEGIN");
		try {

			SigitRPfPgDelegaDto dto = MapDto.getSigitRPfPgDelega(chiaveDelegato, cfUtenteMod);

			getSigitRPfPgDelegaDao().updateColumnsCessaDelega(dto);

		}
		catch(SigitRPfPgDelegaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cessaDelega] END");
		}
	}

	public void cessaIncarico(String chiaveIncaricato, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::cessaIncarico] BEGIN");
		try {

			SigitRPgPgNominaDto dto = MapDto.getSigitRPgPgNomina(chiaveIncaricato, cfUtenteMod);

			getSigitRPgPgNominaDao().updateColumnsCessaIncarico(dto);

		}
		catch(SigitRPgPgNominaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cessaIncarico] END");
		}
	}


	@SuppressWarnings("unchecked")
	public ArrayList<SigitTPersonaFisicaDto> cercaPersonaFisDelValidiByIdPersGiu(BigDecimal idPersonaG) throws DbManagerException {
		List<SigitTPersonaFisicaDto> dtoList = null;
		log.debug("[DbMgr::cercaPersonaFisDelByIdPersGiu] BEGIN");
		try {

			dtoList = getSigitTPersonaFisicaDao().findDelegatiValidiByIdPersonaGiuridica(idPersonaG);

		}
		catch(SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaFisDelByIdPersGiu] END");
		}
		return (ArrayList<SigitTPersonaFisicaDto>) convertToArrayList(dtoList);
	}

	/*
	@SuppressWarnings("unchecked")
	public ArrayList<SigitTTerzoResponsabileDto> cercaTerzoResponsabile(Integer idPersonaG) throws DbManagerException {
		List<SigitTTerzoResponsabileDto> dtoList = null;
		log.debug("[DbMgr::cercaTerzoResponsabile] BEGIN");
		try {

			dtoList = getSigitTTerzoResponsabileDao().findAttivoByIdPersonaGiuridica(idPersonaG);

		}
		catch(SigitTTerzoResponsabileDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaTerzoResponsabile] END");
		}
		return (ArrayList<SigitTTerzoResponsabileDto>) convertToArrayList(dtoList);
	}
	*/

	/*
	public List<SigitTContrattoDto> cercaContrattoById3RespAndCodImpianto(BigDecimal idImpianto, Integer idPersonaG) throws DbManagerException {
		List<SigitTContrattoDto> dtoList = null;
		log.debug("[DbMgr::cercaContrattoById3RespAndCodImpianto] BEGIN");
		try {
			PersonaRuoloFilter filter = new PersonaRuoloFilter();
			filter.setCodiceImpianto(idImpianto);
			filter.setIdPersonaGiuridica(idPersonaG);

			dtoList = getSigitTContrattoDao().findAttivoById3RespCodImp(filter);
		}
		catch(SigitTContrattoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaContrattoById3RespAndCodImpianto] END");
		}

		return dtoList;
	}
	*/


	public List<SigitTContratto2019Dto> cercaContrattiByImpRuoloPfpg(String codiceImpianto, Integer idImpResp) throws DbManagerException {
		List<SigitTContratto2019Dto> dtoList = null;
		log.debug("[DbMgr::cercaContrattiByImpRuoloPfpg] BEGIN");
		try {
			PersonaRuoloFilter filter = new PersonaRuoloFilter();

			filter.setIdResponsabile(idImpResp);;
			filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));

			/*
			if (GenericUtil.isNotNullOrEmpty(impRuoloPfpg.getFkPersonaFisica()))
			{
				filter.setIdPersonaFisica(ConvertUtil.convertToInteger(impRuoloPfpg.getFkPersonaFisica()));
			}
			else if (GenericUtil.isNotNullOrEmpty(impRuoloPfpg.getFkPersonaGiuridica()))
			{
				filter.setIdPersonaGiuridica(ConvertUtil.convertToInteger(impRuoloPfpg.getFkPersonaGiuridica()));
			}
			*/

			dtoList = getSigitTContratto2019Dao().findByIdResponsabile(filter);
		}
		catch(SigitTContratto2019DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaContrattiByImpRuoloPfpg] END");
		}

		return dtoList;
	}

	public List<SigitTContratto2019Dto> cercaContrattiAttiviByCodImp(String codiceImpianto) throws DbManagerException {
		List<SigitTContratto2019Dto> dtoList = null;
		log.debug("[DbMgr::cercaContrattiAttiviByCodImp] BEGIN");
		try {
			ContrattoFilter filter = new ContrattoFilter();

			filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
			filter.setDataAl(DateUtil.getSqlDataCorrente());

			dtoList = getSigitTContratto2019Dao().findByFilter(filter);
		}
		catch(SigitTContratto2019DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaContrattiAttiviByCodImp] END");
		}

		return dtoList;
	}

	public List<SigitTContratto2019Dto> cercaContrattiAttiviByCodImpAndIdPg3Resp(BigDecimal codiceImpianto, BigDecimal idPersonaGiuridica3Responsabile) throws DbManagerException {
		List<SigitTContratto2019Dto> dtoList = null;
		log.debug("[DbMgr::cercaContrattiAttiviByCodImpAndIdPg3Resp] BEGIN");
		try {
			ContrattoFilter filter = new ContrattoFilter();

			filter.setCodiceImpianto(codiceImpianto);
			filter.setIdPersonaGiuridica3Responsabile(idPersonaGiuridica3Responsabile);
			filter.setDataAl(DateUtil.getSqlDataCorrente());

			dtoList = getSigitTContratto2019Dao().findByFilter(filter);
		}
		catch(SigitTContratto2019DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaContrattiAttiviByCodImpAndIdPg3Resp] END");
		}

		return dtoList;
	}


	public List<SigitVAllegatiComponentiDto> cercaAllegatoByIdAllegato(BigDecimal idAllegato) throws DbManagerException {
		List<SigitVAllegatiComponentiDto> dtoList = null;
		log.debug("[DbMgr::cercaAllegatoById3RespAndIdAllegato] BEGIN");
		try {

			dtoList = getSigitVAllegatiComponentiDao().findAllegatiByIdAllegato(idAllegato);
		}
		catch(SigitVAllegatiComponentiDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaAllegatoById3RespAndIdAllegato] END");
		}

		return dtoList;
	}


	public SigitTContratto2019Dto cercaContrattoById(BigDecimal idContratto) throws DbManagerException {
		log.debug("[DbMgr::cercaContrattoById] BEGIN");
		try {

			return getSigitTContratto2019Dao().findByPrimaryKey(new SigitTContratto2019Pk(idContratto));
		}
		catch(SigitTContratto2019DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaContrattoById] END");
		}

	}

	public SigitTContratto2019Dto cercaContratto2019ById(Integer idContratto) throws DbManagerException {
		log.debug("[DbMgr::cercaContratto2019ById] BEGIN");
		try {

			return getSigitTContratto2019Dao().findByPrimaryKey(new SigitTContratto2019Pk(ConvertUtil.convertToBigDecimal(idContratto)));
		}
		catch(SigitTContratto2019DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaContratto2019ById] END");
		}

	}


	/*
	public List<SigitTPersonaGiuridicaDto> cercaPersonaGiuridicaByCodiceRea(String siglaRea, BigDecimal numeroRea) throws DbManagerException {
		log.debug("[DbMgr::cercaPersonaGiuridicaByCodiceRea] BEGIN");
		List<SigitTPersonaGiuridicaDto> dtoList = null;
		SigitTPersonaGiuridicaDto dto = null;

		try {
			CodiceReaFilter codiceReaFilter = new CodiceReaFilter(siglaRea, numeroRea);
			dtoList = getSigitTPersonaGiuridicaDao().findByCodiceRea(codiceReaFilter);
		}
		catch(SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaPersonaGiuridicaByCodiceRea] END");
		return dtoList;
	}
	*/

	@SuppressWarnings("unchecked")
	public ArrayList<SigitVPfPgDto> cercaPersonaByFilter(String siglaRea, BigDecimal numeroRea, String codiceFiscale, String denominazione, boolean isImpresa) throws DbManagerException {
		List<SigitVPfPgDto> dtoList = null;
		log.debug("[DbMgr::cercaPersonaByFilter] BEGIN");
		try {
			CodiceReaAndFiscaleAndDenomFilter filter = new CodiceReaAndFiscaleAndDenomFilter();
			filter.setSiglaRea(siglaRea);
			filter.setNumeroRea(numeroRea);

			filter.setCodiceFiscale(codiceFiscale);

			filter.setDenominazione(denominazione);

			filter.setIsImpresa(isImpresa);

			dtoList = getSigitVPfPgDao().findByFilter(filter);

		}
		catch(SigitVPfPgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaByFilter] END");
		}
		return (ArrayList<SigitVPfPgDto>) convertToArrayList(dtoList);
	}


	@SuppressWarnings("unchecked")
	public ArrayList<SigitVPfPgDto> cercaPersonaByCodiceRea(String siglaRea, BigDecimal numeroRea, boolean isImpresa) throws DbManagerException {
		List<SigitVPfPgDto> dtoList = null;
		log.debug("[DbMgr::cercaPersonaByCodicerea] BEGIN");
		try {
			CodiceReaAndFiscaleAndDenomFilter filter = new CodiceReaAndFiscaleAndDenomFilter();
			filter.setSiglaRea(siglaRea);
			filter.setNumeroRea(numeroRea);
			filter.setIsImpresa(isImpresa);

			dtoList = getSigitVPfPgDao().findByCodiceRea(filter);

		}
		catch(SigitVPfPgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaByCodicerea] END");
		}
		return (ArrayList<SigitVPfPgDto>) convertToArrayList(dtoList);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<SigitVPfPgDto> cercaPersonaByCodiceFiscale(String codiceFiscale, boolean isImpresa) throws DbManagerException {
		List<SigitVPfPgDto> dtoList = null;
		log.debug("[DbMgr::cercaPersonaByCodiceFiscale] BEGIN");
		try {

			CodiceReaAndFiscaleAndDenomFilter filter = new CodiceReaAndFiscaleAndDenomFilter();
			filter.setCodiceFiscale(codiceFiscale);
			filter.setIsImpresa(isImpresa);

			dtoList = getSigitVPfPgDao().findByCodiceFiscale(filter);

		}
		catch(SigitVPfPgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaByCodiceFiscale] END");
		}
		return (ArrayList<SigitVPfPgDto>) convertToArrayList(dtoList);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<SigitVPfPgDto> cercaPersonaByCodiceReaAndFiscale(String siglaRea, BigDecimal numeroRea, String codiceFiscale, boolean isImpresa) throws DbManagerException {
		List<SigitVPfPgDto> dtoList = null;
		log.debug("[DbMgr::cercaPersonaByCodiceReaAndFiscale] BEGIN");
		try {
			CodiceReaAndFiscaleAndDenomFilter filter = new CodiceReaAndFiscaleAndDenomFilter();
			filter.setSiglaRea(siglaRea);
			filter.setNumeroRea(numeroRea);
			filter.setCodiceFiscale(codiceFiscale);

			filter.setIsImpresa(isImpresa);


			dtoList = getSigitVPfPgDao().findByCodiceReaAndFiscale(filter);

		}
		catch(SigitVPfPgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaByCodiceReaAndFiscale] END");
		}
		return (ArrayList<SigitVPfPgDto>) convertToArrayList(dtoList);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<SigitVPfPgDto> cercaPersonaByDenominazione(String denominazione, boolean isImpresa) throws DbManagerException {
		List<SigitVPfPgDto> dtoList = null;
		log.debug("[DbMgr::cercaPersonaByDenominazione] BEGIN");
		try {

			CodiceReaAndFiscaleAndDenomFilter filter = new CodiceReaAndFiscaleAndDenomFilter();
			filter.setDenominazione(denominazione);
			filter.setIsImpresa(isImpresa);

			dtoList = getSigitVPfPgDao().findByDenominazione(filter);

		}
		catch(SigitVPfPgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaByDenominazione] END");
		}
		return (ArrayList<SigitVPfPgDto>) convertToArrayList(dtoList);
	}

	/**
	 * Restituisce la descrizione del ruolo
	 *
	 * @param idRuolo id del ruolo
	 * @return String la descrizione del ruolo
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */
	/*
	public List<SigitTCodiceImpByCodiceImpiantoDto> cercaCodiceImpianto(Integer codiceImpianto) throws DbManagerException {
		List<SigitTCodiceImpByCodiceImpiantoDto> dtoList = null;
		log.debug("[DbMgr::cercaCodiceImpianto] BEGIN");
		try {
			dtoList = getSigitTCodiceImpDao().findByCodiceImpianto(codiceImpianto);
		}
		catch(SigitTCodiceImpDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaCodiceImpianto] END");
		}
		return dtoList;
	}
	*/

	/**
	 * Restituisce la descrizione del ruolo
	 *
	 * @param idRuolo id del ruolo
	 * @return String la descrizione del ruolo
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */

	public SigitTImpiantoDto cercaImpiantoDtoById(String idImpianto) throws DbManagerException {
		SigitTImpiantoDto dto = null;
		log.debug("[DbMgr::cercaImpiantoDtoById] BEGIN");
		try {
			dto = getSigitTImpiantoDao().findByPrimaryKey(new SigitTImpiantoPk(ConvertUtil.convertToBigDecimal(idImpianto)));
		}
		catch(SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaImpiantoDtoById] END");
		}

		return dto;
	}


	/*
	public Integer cercaCodiciImpiantoCount(RicercaCodImpianto ricImp) throws DbManagerException {
		Integer count = null;
		log.debug("[DbMgr::cercaCodiciImpiantoCount] BEGIN");
		try {

			count = getSigitTTerzoResponsabileDao().findAttivoByIdPersonaGiuridica(idPersonaG);

		}
		catch(SigitTTerzoResponsabileDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaCodiciImpiantoCount] END");
		}
		return count;
	}

	public Integer cercaCodiciImpianto(RicercaCodImpianto ricImp) throws DbManagerException {
		Integer count = null;
		log.debug("[DbMgr::cercaCodiciImpiantoCount] BEGIN");
		try {

			count = getSigitTTerzoResponsabileDao().findAttivoByIdPersonaGiuridica(idPersonaG);

		}
		catch(SigitTTerzoResponsabileDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaCodiciImpiantoCount] END");
		}
		return count;
	}
	*/

	public ArrayList<CodeDescription> cercaListaStatiImpianto() throws DbManagerException {
		log.debug("[DbMgr::cercaListaStatiImpianto] BEGIN");
		try {

			return MapDto.mapStatiImpianto(getSigitDStatoImpDao().findAll());

		}
		catch(SigitDStatoImpDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaStatiImpianto] END");
		}
	}


	public ArrayList<CodeDescription> cercaListaStatiPg() throws DbManagerException {
		log.debug("[DbMgr::cercaListaStatiPg] BEGIN");
		try {

			return MapDto.mapStatiPg(getSigitDStatoPgDao().findAll());

		}
		catch(SigitDStatoPgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaStatiPg] END");
		}
	}

	/**
	 * carica la combo delgi stati degli allegati
	 * @return ArrayList<CodeDescription>
	 * @throws DbManagerException
	 */
	public ArrayList<CodeDescription> cercaListaStatiAllegato() throws DbManagerException {
		log.debug("[DbMgr::cercaListaStatiAllegato] BEGIN");
		try {
			return MapDto.mapStatiAllegato(sigitDStatoRappDao.findAll());
		}
		catch (SigitDStatoRappDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaStatiAllegato] END");
		}
	}

	public ArrayList<CodeDescription> cercaListaTipoAllegati() throws DbManagerException {
		log.debug("[DbMgr::cercaListaTipoAllegati] BEGIN");
		try {
			String input = new String();
			return MapDto.mapTipoAllegato(sigitDTipoDocumentoDao.findByFlgRicercaAllegati(input));
		}
		catch (SigitDTipoDocumentoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaTipoAllegati] END");
		}
	}


	public ArrayList<CodeDescription> cercaListaTipiDocumentoProfilato(String codiceImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaListaTipiDocumentoProfilato] BEGIN");
		ArrayList<CodeDescription> lista = new ArrayList<CodeDescription>();
		try {

			lista = MapDto.mapTipoDocumentoByManutentori(getSigitDTipoDocumentoDao().findByCodiceImpianto(ConvertUtil.convertToInteger(codiceImpianto)));

			for (CodeDescription tipoDocumento : lista) {
				if (tipoDocumento.getCode().equals(Constants.ALLEGATO_TIPO_1)) {

					CompFilter compFilter = new CompFilter(codiceImpianto);
					compFilter.setListCombustibile(ConvertUtil.convertIntegerArrayToStringList(Constants.ID_TIPO_COMBUSIBILE_BIOMASSA_ARRAY));

					List<SigitTCompGtDto> compGtList = findCompGtByFilter(compFilter);

					if (!compGtList.isEmpty()) {
						SigitDTipoDocumentoDto tipoDocumentoRee1B = getSigitDTipoDocumentoDao().findByPrimaryKey(new SigitDTipoDocumentoPk(new BigDecimal(Constants.ALLEGATO_TIPO_1B)));
						lista.add(1, MapDto.mapToCodeDescription(tipoDocumentoRee1B));
					}

					break;
				}
			}

			/* if(Constants.RUOLO_MANUTENTORE.equalsIgnoreCase(ruolo)){
				 lista = MapDto.mapTipoDocumento(sigitDTipoDocumentoDao.findByRuoloFunzionale(ruolo));
			 }else{
				 lista = MapDto.mapTipoAllegato(sigitDTipoDocumentoDao.findByFlgVisualizzaAllegati(ruolo));
			 }*/
		}
		catch (SigitDTipoDocumentoDaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaTipiDocumentoProfilato] END");
		}
		return lista;
	}

	public ArrayList<CodeDescription> cercaListaTipiIntervento() throws DbManagerException {
		log.debug("[DbMgr::cercaListaTipiIntervento] BEGIN");
		ArrayList<CodeDescription> lista = new ArrayList<CodeDescription>();
		try {

			lista = MapDto.mapTipoManutenzione(getSigitDTipoManutenzioneDao().findForCombo(null));

			/* if(Constants.RUOLO_MANUTENTORE.equalsIgnoreCase(ruolo)){
				 lista = MapDto.mapTipoDocumento(sigitDTipoDocumentoDao.findByRuoloFunzionale(ruolo));
			 }else{
				 lista = MapDto.mapTipoAllegato(sigitDTipoDocumentoDao.findByFlgVisualizzaAllegati(ruolo));
			 }*/
		}
		catch (SigitDTipoManutenzioneDaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaTipiIntervento] END");
		}
		return lista;
	}

	public ArrayList<CodeDescription> cercaListaTipiDocumentoRapProva() throws DbManagerException {
		log.debug("[DbMgr::cercaListaTipiDocumentoProfilato] BEGIN");
		ArrayList<CodeDescription> lista = new ArrayList<CodeDescription>();
		try {

			lista = MapDto.mapTipoAllegato(getSigitDTipoDocumentoDao().findByFlgVisualizzaAllegati(null));

		}
		catch (SigitDTipoDocumentoDaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaTipiDocumentoProfilato] END");
		}
		return lista;
	}

	public ArrayList<CodeDescription> cercaListaTipiManutenzione() throws DbManagerException {
		log.debug("[DbMgr::cercaListaTipiManutenzione] BEGIN");
		ArrayList<CodeDescription> lista = new ArrayList<CodeDescription>();
		try {

			lista = MapDto.mapTipoAllegato(getSigitDTipoDocumentoDao().findByFlgVisualizzaManutenzioni(null));

		}
		catch (SigitDTipoDocumentoDaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaTipiManutenzione] END");
		}
		return lista;
	}

	public BigDecimal cercaIdTransazioneCodBollinoAssegnatoAdUtente(Integer numeroBollino, Integer idPersonaGiuridica, String siglaBollino) throws DbManagerException {
		log.debug("[DbMgr::cercaIdTransazioneCodBollinoAssegnatoAdUtente] BEGIN");

		BigDecimal idTransazione = null;
		try
		{

			TransazioneFilter filter = new TransazioneFilter(siglaBollino, numeroBollino, idPersonaGiuridica);

			// Modifico il metodo, perche' come era fatto non verificava la persona giuridica dei bollini, sul WEB
			// essendoci la copmbo non dovrebbero esserci problemi, ma sull'import si.
			// Modifico il metodo per tutti

			/*
			List<SigitTCodiceBollByNumeroBollinoPgDto> bollinoList = getSigitTCodiceBollDao().findByNumeroBollinoPg(filter);

			if (bollinoList != null && bollinoList.size() > 0 && bollinoList.get(0).getIdTransazione() != null)
			{
				idTransazione = bollinoList.get(0).getIdTransazione();
			}
			*/

			/*
			SigitTCodiceBollPk pk = new SigitTCodiceBollPk();
			pk.setNumeroBollino(new BigDecimal(ConvertUtil.convertToString(numeroBollino)));
			pk.setSiglaBollino(siglaBollino);

			SigitTCodiceBollDto dettCodiceBolllino = getSigitTCodiceBollDao().findByPrimaryKey(pk );
			//se ho trovato un bollino vado a vedere se e' della persona che si e' loggata
			if(dettCodiceBolllino!=null){
				SigitTTransazioneBollPk pkTransazione = new SigitTTransazioneBollPk();
				pkTransazione.setIdTransazioneBoll(dettCodiceBolllino.getFkTransazioneBoll());
				dettaglioTransazione = getSigitTTransazioneBollDao().findByPrimaryKey(pkTransazione);
			}

			if(dettaglioTransazione!=null)
				dataTransazione = dettaglioTransazione.getDataTransazione();
			*/
		}
//		catch (SigitTCodiceBollDaoException e) {
//			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
//		}
		finally {
			log.debug("[DbMgr::cercaIdTransazioneCodBollinoAssegnatoAdUtente] END");
		}
		return idTransazione;
	}

	@Transactional
	public Impianto salvaImpiantoResponsabile(Impianto impianto, Responsabile responsabile, UtenteLoggato utenteLoggato) throws DbManagerException {
		log.debug("[DbMgr::salvaImpiantoResponsabile] BEGIN");

		try {

			impianto = salvaImpianto(impianto, null, utenteLoggato);
			salvaResponsabile(responsabile, impianto.getImpCodImpianto(), utenteLoggato.getCodiceFiscale());

		}
		catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaImpiantoResponsabile] END");
		}

		return impianto;
	}

	@Transactional
	public Impianto salvaImpiantoTrans(Impianto impianto, String descRuolo, UtenteLoggato utenteLoggato) throws DbManagerException {
		log.debug("[DbMgr::salvaImpiantoTrans] BEGIN");
		try {
			return salvaImpianto(impianto, descRuolo, utenteLoggato);
		}
		catch(DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw e;
		}
		finally {
			log.debug("[DbMgr::salvaImpiantoTrans] END");
		}
	}

	public void aggiornaImpiantoSblocca3R(String codiceImpianto, String cfUtenteMod, boolean blocca) throws DbManagerException {
		log.debug("[DbMgr::aggiornaImpiantoSblocca3R] BEGIN");
		try {
			SigitTImpiantoDto impianto = new SigitTImpiantoDto();
			impianto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
			impianto.setDataUltMod(DateUtil.getSqlDataCorrente());
			impianto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
			impianto.setFlgBloccoNomina3r(ConvertUtil.convertToBigDecimal(blocca));
			getSigitTImpiantoDao().updateColumnsUpdateBloccoNomina3R(impianto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::aggiornaImpiantoSblocca3R] END");
		}
	}

	public Impianto salvaImpianto(Impianto impianto, String descRuolo, UtenteLoggato utenteLoggato) throws DbManagerException {
		log.debug("[DbMgr::salvaImpianto] BEGIN");
		try {
			BigDecimal idImpianto = null;
			String cfUtenteMod = utenteLoggato.getCodiceFiscale();
			if (log.isDebugEnabled())
				GenericUtil.stampa(impianto, true, 3);

			boolean isPrimoCaricamento = false;

			if (GenericUtil.isNullOrEmpty(impianto.getImpId()))
			{
				isPrimoCaricamento = true;

				/*
				if (Constants.RUOLO_ISPETTORE.equalsIgnoreCase(descRuolo) &&
						GenericUtil.isNullOrEmpty(impianto.getImpCodImpianto()))
				{
					// Recupero i codici impianto liberi assegnati al ruolo ispettore
					List<SigitTTransazioneImpByElencoCodiciImpiantoByPersGiuridicaDto> listCodImpiantoLiberi = getSigitTTransazioneImpDao().findByElencoCodiciImpiantoByPersGiuridica(Constants.ID_PG_RUOLO_ISPETTORE);
					if (listCodImpiantoLiberi != null && listCodImpiantoLiberi.size() > 0)
					{
						// Esisistono dei codici impianto liberi assegnati al ruolo ispettore
						idImpianto = listCodImpiantoLiberi.get(0).getCiCodiceImpianto();
					}
					else
					{
						// NON esisistono dei codici impianto liberi assegnati al ruolo ispettore
						// devo inserirlo
						AcquisizioneCodici acquisizioneCodici = new AcquisizioneCodici();
						acquisizioneCodici.setDataConsegna(DateUtil.getDataCorrenteFormat());
						acquisizioneCodici.setIdInstallatore(Constants.ID_PG_RUOLO_ISPETTORE);
						acquisizioneCodici.setQuantita(Constants.NUM_COD_IMPIANTO_ISPETTORE);

						// Inserisco il codice impianto
						salvaAcquisizioneCodici(acquisizioneCodici, cfUtenteMod);

						// Recupero il codice impianto libero (appena inserito) assegnati al ruolo ispettore
						listCodImpiantoLiberi = getSigitTTransazioneImpDao().findByElencoCodiciImpiantoByPersGiuridica(Constants.ID_PG_RUOLO_ISPETTORE);
						idImpianto = listCodImpiantoLiberi.get(0).getCiCodiceImpianto();
					}

					impianto.setImpCodImpianto(ConvertUtil.convertToString(idImpianto));
				}
				*/

				if (GenericUtil.isNullOrEmpty(impianto.getImpCodImpianto())) {

					// Se l'utente non ha settato il codice impianto setto il codice impianto preso dalla sequence
					impianto.setImpCodImpianto(ConvertUtil.convertToString(getNextIdSeqCodiceImpianto()));
				}

				// Sono in inserimento
				SigitTImpiantoPk impiantoPk = getSigitTImpiantoDao().insert(MapDto.mapToSigitTImpiantoDto(impianto, true, cfUtenteMod));

				idImpianto = impiantoPk.getCodiceImpianto();
				//impianto.setImpId(ConvertUtil.convertToInteger(impiantoPk.getCodiceImpianto()));

				SigitTUnitaImmobiliarePk unitaImmobiliarePk = getSigitTUnitaImmobiliareDao().insert(MapDto.mapToSigitTUnitaImmobiliareDto(impianto, idImpianto, cfUtenteMod));

				getSigitRImpRuoloPfpgDao().insert(MapDto.mapToSigitRImpRuoloPfpgDto(impianto, idImpianto, utenteLoggato));

				impianto.setImpId(ConvertUtil.convertToInteger(impiantoPk.getCodiceImpianto()));
				impianto.setImpIdUnitaImm(ConvertUtil.convertToInteger(unitaImmobiliarePk.getIdUnitaImm()));
				impianto.setImpIdStatoImpOld(null);

			}
			else
			{


				if (GenericUtil.isNotNullOrEmpty(impianto.getInstPrimoCaricatore()))
				{
					// Modifico il campo installatore primo caricatore
					SigitRImpRuoloPfpgDto installatore = cercaInstallatoreImpianto(impianto.getImpCodImpianto(), ConvertUtil.convertToBigDecimal(impianto.getInstId()));
					getSigitRImpRuoloPfpgDao().updateColumnsFlgPrimoCaricatore(MapDto.mapToSigitRImpRuoloPfpgDto(installatore, impianto.getInstPrimoCaricatore(), cfUtenteMod));
				}

				// Sono in modifica
				getSigitTImpiantoDao().updateColumnsUpdateDatiOnline(MapDto.mapToSigitTImpiantoDto(impianto, false, cfUtenteMod));
				getSigitTUnitaImmobiliareDao().updateColumnsDaOnline(MapDto.mapToSigitTUnitaImmobiliareDto(impianto, null, cfUtenteMod));
			}

			if (isPrimoCaricamento || !impianto.getImpIdStatoImp().equalsIgnoreCase(impianto.getImpIdStatoImpOld()))
			{

				// E' cambiato lo stato impianto, devo aggiornare la tabella sigit_t_storico_variaz_stato
				getSigitTStoricoVariazStatoDao().insert(MapDto.mapToSigitTStoricoVariazStatoDto(impianto, cfUtenteMod));

			}

			return impianto;
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaImpianto] END");
		}
	}



	public Scheda1 salvaLibrettoScheda1(Scheda1 scheda1, String cfUtenteMod, String codiceImpianto, boolean isScheda1Present) throws DbManagerException, ManagerException {
		log.debug("[DbMgr::salvaLibrettoScheda1] BEGIN");

		try {

			if (log.isDebugEnabled())
				GenericUtil.stampa(scheda1, true, 3);

			/*
			// devo verificare che esista un libretto in stato consolidato o in bozza
			List<SigitTLibrettoDto> librettoBozzaDtoList = cercaLibrettoByStato(codiceImpianto,Constants.ID_STATO_LIBRETTO_BOZZA);
			List<SigitTLibrettoDto> librettoConsolidatoDtoList = cercaLibrettoByStato(codiceImpianto,Constants.ID_STATO_LIBRETTO_CONSOLIDATO);

			if (GenericUtil.isNullOrEmpty(librettoConsolidatoDtoList) && GenericUtil.isNullOrEmpty(librettoBozzaDtoList)) {
				throw new ManagerException(new Message(Messages.S163));
			}

			if (!GenericUtil.isNullOrEmpty(librettoBozzaDtoList) && librettoBozzaDtoList.size()!=0) {
				SigitTLibrettoDto librettoBozza = librettoBozzaDtoList.get(0);
				// Sono in aggiornamento bozza
				getSigitTLibrettoDao().update(MapDto.mapToSigitTLibrettoDto(scheda1, cfUtenteMod,librettoBozza));
				log.debug("[DANIELE    salvaLibrettoScheda1] BOZZA UPDATE OK");
			}

			if (!GenericUtil.isNullOrEmpty(librettoConsolidatoDtoList) && librettoConsolidatoDtoList.size()!=0) {
				SigitTLibrettoDto librettoConsolidato = librettoConsolidatoDtoList.get(0);
				// Sono in aggiornamento consolidato
				getSigitTLibrettoDao().update(MapDto.mapToSigitTLibrettoDto(scheda1, cfUtenteMod,librettoConsolidato));
				log.debug("[DANIELE    salvaLibrettoScheda1] CONSOLIDATO UPDATE OK");
			}
			*/

			// recupero l'unita' immobiliare principale associata all'impianto
			List<SigitTUnitaImmobiliareDto> unitaImmobiliareListDto = getSigitTUnitaImmobiliareDao().findUnitaPrincipaleImpianto(ConvertUtil.convertToInteger(codiceImpianto));

			log.debug("[DANIELE    unitaImmobiliareDto] RECUPERO OK");

			// se diverso da null aggiornamento unita' immobiliare altrimenti e' un nuovo inserimento
			if (unitaImmobiliareListDto != null && unitaImmobiliareListDto.get(0)!= null && unitaImmobiliareListDto.size()!=0){
				SigitTUnitaImmobiliareDto unitaImmobiliareDto = new SigitTUnitaImmobiliareDto();
				unitaImmobiliareDto = unitaImmobiliareListDto.get(0);
				getSigitTUnitaImmobiliareDao().update(MapDto.mapToSigitTUnitaImmobiliareDto(scheda1,cfUtenteMod,unitaImmobiliareDto));
			} else{
				Impianto impianto = cercaImpiantoById(codiceImpianto);
				getSigitTUnitaImmobiliareDao().insert(MapDto.mapToSigitTUnitaImmobiliareDto(impianto,ConvertUtil.convertToBigDecimal(codiceImpianto),cfUtenteMod));
			}

			log.debug("[DANIELE    impiantoDto] RECUPERO OK");

			SigitTImpiantoDto impiantoDto = cercaImpiantoDtoById(codiceImpianto);
			impiantoDto.setDataIntervento(ConvertUtil.convertToSqlDate(scheda1.getDataIntervento()));
			impiantoDto.setFkTipoIntervento(ConvertUtil.convertToBigDecimal(scheda1.getIdTipoIntervento()));

			//1.3
			impiantoDto.setL13PotH2oKw(ConvertUtil.convertToBigDecimal(scheda1.getPotenzaUtileProduzioneACS()));
			impiantoDto.setL13PotClimaInvKw(ConvertUtil.convertToBigDecimal(scheda1.getPotenzaUtileClimatInvernale()));
			impiantoDto.setL13PotClimaEstKw(ConvertUtil.convertToBigDecimal(scheda1.getPotenzaUtileClimatEstiva()));
			impiantoDto.setL13Altro(ReplaceSpecialCharUtils.sanitize(scheda1.getPotenzaUtileAltro()));

			//1.4
			impiantoDto.setL14FlgH2o(ConvertUtil.convertToBigDecimal(scheda1.getFlagTipologiaFluidoAcqua() ? Constants.SI_1: Constants.NO_0));
			impiantoDto.setL14FlgAria(ConvertUtil.convertToBigDecimal(scheda1.getFlagTipologiaFluidoAria() ? Constants.SI_1: Constants.NO_0));
			impiantoDto.setL14Altro(ReplaceSpecialCharUtils.sanitize(scheda1.getTipologiaFluidoAltro()));

			//1.5
			impiantoDto.setL15FlgGeneratore(ConvertUtil.convertToBigDecimal(scheda1.getFlagGeneratoreCombustione() ? Constants.SI_1: Constants.NO_0));
			impiantoDto.setL15FlgPompa(ConvertUtil.convertToBigDecimal(scheda1.getFlagPompaDiCalore() ? Constants.SI_1: Constants.NO_0));
			impiantoDto.setL15FlgFrigo(ConvertUtil.convertToBigDecimal(scheda1.getFlagGeneratoreMacchinaFrigorifera() ? Constants.SI_1: Constants.NO_0));
			impiantoDto.setL15FlgTelerisc(ConvertUtil.convertToBigDecimal(scheda1.getFlagGeneratoreTeleriscaldamento() ? Constants.SI_1: Constants.NO_0));
			impiantoDto.setL15FlgTeleraffr(ConvertUtil.convertToBigDecimal(scheda1.getFlagGeneratoreTeleraffrescamento() ? Constants.SI_1: Constants.NO_0));
			impiantoDto.setL15FlgCogeneratore(ConvertUtil.convertToBigDecimal(scheda1.getFlagCogenerazioneTrigenerazione() ? Constants.SI_1: Constants.NO_0));
			impiantoDto.setL15Altro(ReplaceSpecialCharUtils.sanitize(scheda1.getAltroTipoGeneratori()));

			impiantoDto.setL15SupPannelliSolM2(ConvertUtil.convertToBigDecimal(scheda1.getTotaleSuperficieLorda()));
			impiantoDto.setL15AltroIntegrazione(ReplaceSpecialCharUtils.sanitize(scheda1.getAltraIntegrazione()));
			impiantoDto.setL15AltroIntegrPotKw(ConvertUtil.convertToBigDecimal(scheda1.getPotenzaUtileAltraIntegrazione()));
			impiantoDto.setL15FlgAltroClimaInv(ConvertUtil.convertToBigDecimal(scheda1.getFlagTipoGeneratoriClimatInvernale() ? Constants.SI_1: Constants.NO_0));
			impiantoDto.setL15FlgAltroClimaEstate(ConvertUtil.convertToBigDecimal(scheda1.getFlagTipoGeneratoriClimatEstiva() ? Constants.SI_1: Constants.NO_0));
			impiantoDto.setL15FlgAltroAcs(ConvertUtil.convertToBigDecimal(scheda1.getFlagTipologiaGeneratoriProdACS() ? Constants.SI_1: Constants.NO_0));
			impiantoDto.setL15AltroDesc(ReplaceSpecialCharUtils.sanitize(scheda1.getAltroTipologiaGeneratori()));

			impiantoDto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
			impiantoDto.setDataUltMod(DateUtil.getSqlDataCorrente());

			getSigitTImpiantoDao().update(impiantoDto);

			if (!isScheda1Present)
			{
				SigitTControlloLibrettoDto controlloLib = new SigitTControlloLibrettoDto();
				controlloLib.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
				controlloLib.setFlgL1Controlloweb(ConvertUtil.convertToBigDecimal(Constants.SI_1));
				controlloLib.setUtenteUltAgg(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
				controlloLib.setDtUltMod(DateUtil.getSqlDataCorrente());

				// E' un caso che non si dovrebbe verificare in futuro, ma al primo rilascio,
				// il flag isScheda1Present sar� false ma in realta' esistera' la riga sul DB, nel caso di impianti con libretti in stato consolidato/storicizzato
				// ma abbiamo impostato il flag Scheda1 a false per constringerli a completare la scheda
				SigitTControlloLibrettoDto controlloLibPrese = getSigitTControlloLibrettoDao().findByPrimaryKey(new SigitTControlloLibrettoPk(controlloLib.getCodiceImpianto()));

				if (controlloLibPrese == null)
				{
					// devo fare insert
					getSigitTControlloLibrettoDao().insert(controlloLib);
				}
				else
				{
					// devo fare update
					getSigitTControlloLibrettoDao().updateColumnsAggiornaControlloScheda1(controlloLib);
				}

			}

			return scheda1;
		}
		catch(ManagerException e) {
			throw new ManagerException(new Message(Messages.S163));
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLibrettoScheda1] END");
		}
	}

	/*
	@Transactional
	public ArrayList<Consumo> salvaLibrettoScheda14_1_Trans(ArrayList<Consumo> listaConsumi, String descRuolo, String cfUtenteMod,String codiceImpianto, it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda14_1.CpGestLibScheda14_1Model theModel) throws DbManagerException, ManagerException {
		log.debug("[DbMgr::salvaLibrettoScheda14_1_Trans] BEGIN");
		try {
			return salvaLibrettoScheda14_1(listaConsumi,descRuolo,cfUtenteMod,codiceImpianto,theModel);
		}
		catch(DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw e;
		}
		finally {
			log.debug("[DbMgr::salvaLibrettoScheda14_1_Trans] END");
		}
	}


	@Transactional
	public void salvaLibrettoScheda1_extra(ArrayList<DatiExtra> listDatiExtra, ArrayList<PkTabellaEdit> listPkChiavi, ArrayList<String> listPkChiaviCancellare, String codiceImpianto, String cfUtenteMod) throws DbManagerException, ManagerException {
		log.debug("[DbMgr::salvaLibrettoScheda1_extra] BEGIN");
		try {

			DatiExtra datoExtra;
			PkTabellaEdit pkChiave;

			SigitTUnitaImmobiliareDto tUnitaImm = null;
			for (int i = 0; i < listDatiExtra.size(); i++) {

				datoExtra = listDatiExtra.get(i);
				pkChiave = listPkChiavi.get(i);

				if (pkChiave != null && pkChiave.getIdDb() != null)
				{
					// oggetto di cui bisogna fare l'update
					log.debug("[DbMgr::salvaLibrettoScheda1_extra] - UPDATE: "+datoExtra.getIndice() + " - " + datoExtra.getIdUnitaImm() + " - " + datoExtra.getPod() + " - " + datoExtra.getPdr());

					datoExtra.setIdUnitaImm(ConvertUtil.convertToInteger(pkChiave.getIdDb()));

					tUnitaImm = MapDto.getUnitaImmobiliareSecondarie(datoExtra, pkChiave.getIdDb(), codiceImpianto, cfUtenteMod);
					getSigitTUnitaImmobiliareDao().update(tUnitaImm);

				}
				else
				{
					// testConsumoWeb - oggetto di cui bisogna fare l'insert
					log.debug("[DbMgr::salvaLibrettoScheda1_extra] - INSERT: "+datoExtra.getIndice() + " - " + datoExtra.getPod() + " - " + datoExtra.getPdr());

					tUnitaImm = MapDto.getUnitaImmobiliareSecondarie(datoExtra, null, codiceImpianto, cfUtenteMod);
					getSigitTUnitaImmobiliareDao().insert(tUnitaImm);
				}
			}

			for (String pkChiaveCancellare : listPkChiaviCancellare) {

				log.debug("[DbMgr::salvaLibrettoScheda1_extra] - DELETE: "+pkChiaveCancellare);

				getSigitTUnitaImmobiliareDao().delete(new SigitTUnitaImmobiliarePk(ConvertUtil.convertToBigDecimal(pkChiaveCancellare)));

			}

		}
		catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLibrettoScheda1_extra] END");
		}
	}
	*/

	public void salvaLibrettoScheda1_extra(ArrayList<DatiExtra> listDatiExtra, ArrayList<PkTabellaEdit> listPkChiavi, ArrayList<Integer> listPkChiaviCancellare, String codiceImpianto, String cfUtenteMod) throws DbManagerException, ManagerException {
		log.debug("[DbMgr::salvaLibrettoScheda1_extra] BEGIN");
		try {

			DatiExtra datoExtra;
			PkTabellaEdit pkChiave;

			SigitTUnitaImmobiliareDto tUnitaImm = null;
			//SigitTUnitaImmobiliarePk tUnitaImmPk = null;

			for (int i = 0; i < listDatiExtra.size(); i++) {

				datoExtra = listDatiExtra.get(i);
				pkChiave = listPkChiavi.get(i);

				if (GenericUtil.isNullOrEmpty(datoExtra.getSezione()) &&
						GenericUtil.isNullOrEmpty(datoExtra.getFoglio()) &&
						GenericUtil.isNullOrEmpty(datoExtra.getParticella()) &&
						GenericUtil.isNullOrEmpty(datoExtra.getSubalterno()) &&
						GenericUtil.isNullOrEmpty(datoExtra.getPod()) &&
						GenericUtil.isNullOrEmpty(datoExtra.getPdr()))
				{
					// Vuol dire che l'utente ha messo una riga completamente vuota
					// nel caso in cui sia un riga senza idDb vuol dire che ha fatto l'inserimento (quindi sul DB non c'e' e non devo fare niente)
					// nel caso in cui sia un riga con idDb vuol dire che ha cancellato i dati di una riga gia' presente (quindi devo cancellarla dal DB)

					if (pkChiave != null && pkChiave.getIdDb() != null)
					{
						getSigitTUnitaImmobiliareDao().delete(new SigitTUnitaImmobiliarePk(ConvertUtil.convertToBigDecimal(pkChiave.getIdDb())));
						getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_unita_immobiliare", "id_unita_imm="+pkChiave.getIdDb()));
					}
				}
				else
				{
					if (pkChiave != null && pkChiave.getIdDb() != null)
					{


						// oggetto di cui bisogna fare l'update
						log.debug("[DbMgr::salvaLibrettoScheda1_extra] - UPDATE: "+datoExtra.getIndice() + " - " + datoExtra.getIdUnitaImm() + " - " + datoExtra.getPod() + " - " + datoExtra.getPdr());

						datoExtra.setIdUnitaImm(pkChiave.getIdDb());

						tUnitaImm = MapDto.getUnitaImmobiliareSecondarie(datoExtra, pkChiave.getIdDb(), codiceImpianto, cfUtenteMod);
						getSigitTUnitaImmobiliareDao().update(tUnitaImm);

					}
					else
					{
						// testConsumoWeb - oggetto di cui bisogna fare l'insert
						log.debug("[DbMgr::salvaLibrettoScheda1_extra] - INSERT: "+datoExtra.getIndice() + " - " + datoExtra.getPod() + " - " + datoExtra.getPdr());

						tUnitaImm = MapDto.getUnitaImmobiliareSecondarie(datoExtra, null, codiceImpianto, cfUtenteMod);
						getSigitTUnitaImmobiliareDao().insert(tUnitaImm);
						//tUnitaImm.setIdUnitaImm(tUnitaImmPk.getIdUnitaImm());
					}
				}
			}

			if (listPkChiaviCancellare != null)
			{
				for (Integer pkChiaveCancellare : listPkChiaviCancellare) {

					log.debug("[DbMgr::salvaLibrettoScheda1_extra] - DELETE: "+pkChiaveCancellare);

					getSigitTUnitaImmobiliareDao().delete(new SigitTUnitaImmobiliarePk(ConvertUtil.convertToBigDecimal(pkChiaveCancellare)));
					getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_unita_immobiliare", "id_unita_imm="+pkChiaveCancellare));

				}
			}

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLibrettoScheda1_extra] END");
		}
	}

	public void salvaLibrettoScheda14_1(ArrayList<Consumo> listDati, ArrayList<Integer> listPkChiaviCancellare, String codiceImpianto, String cfUtenteMod) throws DbManagerException, ManagerException {

		log.debug("[DbMgr::salvaLibrettoScheda14_1] BEGIN");
		try {

			Consumo consumo;

			SigitTConsumoDto consumoEntity = null;

			for (int i = 0; i < listDati.size(); i++) {

				consumo = listDati.get(i);

				if (GenericUtil.isNullOrEmpty(consumo.getEsercizioDa()) &&
						GenericUtil.isNullOrEmpty(consumo.getEsercizioA()) &&
						GenericUtil.isNullOrEmpty(consumo.getCombustibile()) &&
						GenericUtil.isNullOrEmpty(consumo.getUnitaMisura()) &&
						GenericUtil.isNullOrEmpty(consumo.getAcquisti()) &&
						GenericUtil.isNullOrEmpty(consumo.getLetturaIniziale()) &&
						GenericUtil.isNullOrEmpty(consumo.getLetturaFinale()) &&
						GenericUtil.isNullOrEmpty(consumo.getConsumo()))
				{

					// Vuol dire che l'utente ha messo una riga completamente vuota
					// nel caso in cui sia un riga senza idDb vuol dire che ha fatto l'inserimento (quindi sul DB non c'e' e non devo fare niente)
					// nel caso in cui sia un riga con idDb vuol dire che ha cancellato i dati di una riga gia' presente (quindi devo cancellarla dal DB)

					if (consumo.getIdConsumo() != null)
					{
						listPkChiaviCancellare.add(consumo.getIdConsumo());
					}
				}
				else
				{
					if (consumo.getIdConsumo() != null)
					{
						// oggetto di cui bisogna fare l'update
						log.debug("[DbMgr::salvaLibrettoScheda14_1] - UPDATE: "+consumo.getIndice() + " - " + consumo.getIdConsumo() + " - " + consumo.getEsercizioDa() + " - " + consumo.getEsercizioA());

						consumoEntity = MapDto.mapToSigitTConsumoCombustibileDto(consumo, consumo.getIdConsumo(), codiceImpianto, cfUtenteMod);
						getSigitTConsumoDao().update(consumoEntity);

					}
					else
					{
						// testConsumoWeb - oggetto di cui bisogna fare l'insert
						log.debug("[DbMgr::salvaLibrettoScheda14_1] - INSERT: "+consumo.getIndice() + " - " + consumo.getEsercizioDa() + " - " + consumo.getEsercizioA());

						consumoEntity = MapDto.mapToSigitTConsumoCombustibileDto(consumo, null, codiceImpianto, cfUtenteMod);
						getSigitTConsumoDao().insert(consumoEntity);
						//tUnitaImm.setIdUnitaImm(tUnitaImmPk.getIdUnitaImm());
					}
				}
			}

			if (listPkChiaviCancellare != null)
			{
				for (Integer pkChiaveCancellare : listPkChiaviCancellare) {

					log.debug("[DbMgr::salvaLibrettoScheda14_1] - DELETE: "+pkChiaveCancellare);

					getSigitTConsumoDao().delete(new SigitTConsumoPk(ConvertUtil.convertToBigDecimal(pkChiaveCancellare)));
					getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_consumo", "id_consumo="+pkChiaveCancellare));

				}
			}

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLibrettoScheda14_1] END");
		}
	}

	/*
	public ArrayList<Consumo> salvaLibrettoScheda14_1_OLD(ArrayList<Consumo> listaConsumi, String cfUtenteMod, String descRuolo,String codiceImpianto) throws DbManagerException, ManagerException {
		log.debug("[DbMgr::salvaLibrettoScheda14_1] BEGIN");

		try {


			// Cancello tutti i consumi combustibile per codice impianto
			getSigitTConsumoDao().customDeleterCombuByCodImpianto(ConvertUtil.convertToInteger(codiceImpianto));

			// insert dei nuovi consumi
			for(Consumo consumo : listaConsumi){

				log.debug("[DbMgr::salvaLibrettoScheda14_1] - consumo.getLetturaIniziale(): "+consumo.getLetturaIniziale());
				log.debug("[DbMgr::salvaLibrettoScheda14_1] - consumo.getLetturaFinale(): "+consumo.getLetturaFinale());
				log.debug("[DbMgr::salvaLibrettoScheda14_1] - consumo.getConsumo(): "+consumo.getConsumo());


				if (GenericUtil.isNotNullOrEmpty(consumo.getEsercizioDa()) ||
						GenericUtil.isNotNullOrEmpty(consumo.getEsercizioA()) ||
						GenericUtil.isNotNullOrEmpty(consumo.getCombustibile()) ||
						GenericUtil.isNotNullOrEmpty(consumo.getUnitaMisura()) ||
						GenericUtil.isNotNullOrEmpty(consumo.getAcquisti()) ||
						GenericUtil.isNotNullOrEmpty(consumo.getLetturaIniziale()) ||
						GenericUtil.isNotNullOrEmpty(consumo.getLetturaFinale()) ||
						GenericUtil.isNotNullOrEmpty(consumo.getConsumo()))
				{
					// Se non entro qua vuol dire che l'utente ha messo una riga completamente vuota, quindi non la inserisco

					consumo.setLetturaIniziale(consumo.getLetturaIniziale().replaceAll("[.]",""));
					consumo.setLetturaFinale(consumo.getLetturaFinale().replaceAll("[.]",""));
					consumo.setConsumo(consumo.getConsumo().replaceAll("[.]",""));
					getSigitTConsumoDao().insert(MapDto.mapToSigitTConsumoCombustibileDto(consumo,ConvertUtil.convertToBigDecimal(codiceImpianto),cfUtenteMod));

				}
			}

			return listaConsumi;
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLibrettoScheda14_1] END");
		}
	}
	*/

	public void salvaLibrettoScheda14_2(ArrayList<Consumo> listDatiExtra, ArrayList<Integer> listPkChiaviCancellare, String codiceImpianto, String cfUtenteMod) throws DbManagerException, ManagerException {
		log.debug("[DbMgr::salvaLibrettoScheda14_2] BEGIN");
		try {

			Consumo consumo;
			PkTabellaEdit pkChiave;

			SigitTConsumoDto consumoEntity = null;

			for (int i = 0; i < listDatiExtra.size(); i++) {

				consumo = listDatiExtra.get(i);

				if (GenericUtil.isNullOrEmpty(consumo.getEsercizioDa()) &&
						GenericUtil.isNullOrEmpty(consumo.getEsercizioA()) &&
						GenericUtil.isNullOrEmpty(consumo.getLetturaIniziale()) &&
						GenericUtil.isNullOrEmpty(consumo.getLetturaFinale()) &&
						GenericUtil.isNullOrEmpty(consumo.getConsumo()))
				{

					// Vuol dire che l'utente ha messo una riga completamente vuota
					// nel caso in cui sia un riga senza idDb vuol dire che ha fatto l'inserimento (quindi sul DB non c'e' e non devo fare niente)
					// nel caso in cui sia un riga con idDb vuol dire che ha cancellato i dati di una riga gia' presente (quindi devo cancellarla dal DB)

					if (consumo.getIdConsumo() != null)
					{
						listPkChiaviCancellare.add(consumo.getIdConsumo());
					}
				}
				else
				{
					if (consumo.getIdConsumo() != null)
					{
						// oggetto di cui bisogna fare l'update
						log.debug("[DbMgr::salvaLibrettoScheda14_2] - UPDATE: "+consumo.getIndice() + " - " + consumo.getIdConsumo() + " - " + consumo.getEsercizioDa() + " - " + consumo.getEsercizioA());

						consumoEntity = MapDto.mapToSigitTConsumoElettricoDto(consumo, consumo.getIdConsumo(), codiceImpianto, cfUtenteMod);
						getSigitTConsumoDao().update(consumoEntity);

					}
					else
					{
						// testConsumoWeb - oggetto di cui bisogna fare l'insert
						log.debug("[DbMgr::salvaLibrettoScheda14_2] - INSERT: "+consumo.getIndice() + " - " + consumo.getEsercizioDa() + " - " + consumo.getEsercizioA());

						consumoEntity = MapDto.mapToSigitTConsumoElettricoDto(consumo, null, codiceImpianto, cfUtenteMod);
						getSigitTConsumoDao().insert(consumoEntity);
						//tUnitaImm.setIdUnitaImm(tUnitaImmPk.getIdUnitaImm());
					}
				}
			}

			if (listPkChiaviCancellare != null)
			{
				for (Integer pkChiaveCancellare : listPkChiaviCancellare) {

					log.debug("[DbMgr::salvaLibrettoScheda14_2] - DELETE: "+pkChiaveCancellare);

					getSigitTConsumoDao().delete(new SigitTConsumoPk(ConvertUtil.convertToBigDecimal(pkChiaveCancellare)));
					getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_consumo", "id_consumo="+pkChiaveCancellare));

				}
			}

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLibrettoScheda14_2] END");
		}
	}

	/*
	public ArrayList<Consumo> salvaLibrettoScheda14_2(ArrayList<Consumo> listaConsumi, String cfUtenteMod, String descRuolo,String codiceImpianto) throws DbManagerException, ManagerException {
		log.debug("[DbMgr::salvaLibrettoScheda14_2] BEGIN");

		try {


			// Cancello tutti i consumi combustibile per codice impianto
			getSigitTConsumoDao().customDeleterEnergiaByCodImpianto(ConvertUtil.convertToInteger(codiceImpianto));

			// insert dei nuovi consumi
			for(Consumo consumo : listaConsumi){

				if (GenericUtil.isNotNullOrEmpty(consumo.getEsercizioDa()) ||
						GenericUtil.isNotNullOrEmpty(consumo.getEsercizioA()) ||
						GenericUtil.isNotNullOrEmpty(consumo.getLetturaIniziale()) ||
						GenericUtil.isNotNullOrEmpty(consumo.getLetturaFinale()) ||
						GenericUtil.isNotNullOrEmpty(consumo.getConsumo()))
				{
					// Se non entro qua vuol dire che l'utente ha messo una riga completamente vuota, quindi non la inserisco

					consumo.setLetturaIniziale(consumo.getLetturaIniziale().replaceAll("[.]",""));
					consumo.setLetturaFinale(consumo.getLetturaFinale().replaceAll("[.]",""));
					consumo.setConsumo(consumo.getConsumo().replaceAll("[.]",""));
					getSigitTConsumoDao().insert(MapDto.mapToSigitTConsumoElettricoDto(consumo,ConvertUtil.convertToBigDecimal(codiceImpianto),cfUtenteMod));
				}
			}

			return listaConsumi;
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLibrettoScheda14_2] END");
		}
	}
	*/

	public void salvaLibrettoScheda14_3(ArrayList<Consumo> listDatiExtra, ArrayList<Integer> listPkChiaviCancellare, String codiceImpianto, String cfUtenteMod) throws DbManagerException, ManagerException {
		log.debug("[DbMgr::salvaLibrettoScheda14_3] BEGIN");
		try {

			Consumo consumo;

			SigitTConsumoDto consumoEntity = null;

			for (int i = 0; i < listDatiExtra.size(); i++) {

				consumo = listDatiExtra.get(i);

				if (GenericUtil.isNullOrEmpty(consumo.getEsercizioDa()) &&
						GenericUtil.isNullOrEmpty(consumo.getEsercizioA()) &&
						GenericUtil.isNullOrEmpty(consumo.getUnitaMisura()) &&
						GenericUtil.isNullOrEmpty(consumo.getLetturaIniziale()) &&
						GenericUtil.isNullOrEmpty(consumo.getLetturaFinale()) &&
						GenericUtil.isNullOrEmpty(consumo.getConsumo()))
				{
					// Vuol dire che l'utente ha messo una riga completamente vuota
					// nel caso in cui sia un riga senza idDb vuol dire che ha fatto l'inserimento (quindi sul DB non c'e' e non devo fare niente)
					// nel caso in cui sia un riga con idDb vuol dire che ha cancellato i dati di una riga gia' presente (quindi devo cancellarla dal DB)

					if (consumo.getIdConsumo() != null)
					{
						listPkChiaviCancellare.add(consumo.getIdConsumo());
					}
				}
				else
				{
					if (consumo.getIdConsumo() != null)
					{
						// oggetto di cui bisogna fare l'update
						log.debug("[DbMgr::salvaLibrettoScheda14_3] - UPDATE: "+consumo.getIndice() + " - " + consumo.getIdConsumo() + " - " + consumo.getEsercizioDa() + " - " + consumo.getEsercizioA());

						consumoEntity = MapDto.mapToSigitTConsumoAcquaDto(consumo, consumo.getIdConsumo(), codiceImpianto, cfUtenteMod);
						getSigitTConsumoDao().update(consumoEntity);

					}
					else
					{
						// testConsumoWeb - oggetto di cui bisogna fare l'insert
						log.debug("[DbMgr::salvaLibrettoScheda14_3] - INSERT: "+consumo.getIndice() + " - " + consumo.getEsercizioDa() + " - " + consumo.getEsercizioA());

						consumoEntity = MapDto.mapToSigitTConsumoAcquaDto(consumo, null, codiceImpianto, cfUtenteMod);
						getSigitTConsumoDao().insert(consumoEntity);
						//tUnitaImm.setIdUnitaImm(tUnitaImmPk.getIdUnitaImm());
					}
				}
			}

			if (listPkChiaviCancellare != null)
			{
				for (Integer pkChiaveCancellare : listPkChiaviCancellare) {

					log.debug("[DbMgr::salvaLibrettoScheda14_3] - DELETE: "+pkChiaveCancellare);

					getSigitTConsumoDao().delete(new SigitTConsumoPk(ConvertUtil.convertToBigDecimal(pkChiaveCancellare)));
					getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_consumo", "id_consumo="+pkChiaveCancellare));

				}
			}

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLibrettoScheda14_3] END");
		}
	}

	public Proprietario getProprietarioImpianto(String codiceImpianto) throws DbManagerException {

		Proprietario proprietario = null;

		try
		{
			FiltroRicercaPfPg filter = new FiltroRicercaPfPg();
			filter.setCodiceImpianto(codiceImpianto);
			filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO));
			filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO_IMPRESA));

			List<SigitRImpRuoloPfpgDto> proprietariList;

			proprietariList = getSigitRImpRuoloPfpgDao().findAttiviByFilter(filter);

			if (proprietariList != null && !proprietariList.isEmpty()) {

				SigitRImpRuoloPfpgDto proprietarioDto = proprietariList.get(0);

				proprietario = new Proprietario();

				proprietario.setIdImpRuoloPfPg(ConvertUtil.convertToInteger(proprietarioDto.getIdImpRuoloPfpg()));
				proprietario.setDataInizio(ConvertUtil.convertToString(proprietarioDto.getDataInizio()));

				if (GenericUtil.isNotNullOrEmpty(proprietarioDto.getFkPersonaFisica()))
				{
					SigitTPersonaFisicaDto pfDto = cercaTPersonaFisicaById(ConvertUtil.convertToInteger(proprietarioDto.getFkPersonaFisica()));

					if (pfDto != null && GenericUtil.isNotNullOrEmpty(pfDto.getCognome()))
					{
						proprietario.setDenomCompleta(MapDto.costruisciCognomeNome(pfDto.getCognome(), pfDto.getNome()));
						proprietario.setIndirizzo(MapDto.getIndirizzoCompleto(pfDto.getComune(), pfDto.getIndirizzoSitad(), pfDto.getIndirizzoNonTrovato(), pfDto.getCivico(), pfDto.getSiglaProv()));
					}

				}
				else if (GenericUtil.isNotNullOrEmpty(proprietarioDto.getFkPersonaGiuridica()))
				{
					SigitTPersonaGiuridicaDto pgDto = cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(proprietarioDto.getFkPersonaGiuridica()));

					if (pgDto != null && GenericUtil.isNotNullOrEmpty(pgDto.getDenominazione()))
					{
						proprietario.setDenomCompleta(pgDto.getDenominazione());
						proprietario.setIndirizzo(MapDto.getIndirizzoCompleto(pgDto.getComune(), pgDto.getIndirizzoSitad(), pgDto.getIndirizzoNonTrovato(), pgDto.getCivico(), pgDto.getSiglaProv()));
					}
				}
			}
		}
		catch (SigitRImpRuoloPfpgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (DbManagerException e) {
			throw e;
		}
		return proprietario;
	}

	public void salvaLibrettoScheda14_4(ArrayList<Consumo> listDatiExtra, ArrayList<Integer> listPkChiaviCancellare, String codiceImpianto, String cfUtenteMod) throws DbManagerException, ManagerException {
		log.debug("[DbMgr::salvaLibrettoScheda14_4] BEGIN");
		try {

			Consumo consumo;

			SigitTConsumo14_4Dto consumoEntity = null;

			for (int i = 0; i < listDatiExtra.size(); i++) {

				consumo = listDatiExtra.get(i);

				if (GenericUtil.isNullOrEmpty(consumo.getEsercizioDa()) &&
						GenericUtil.isNullOrEmpty(consumo.getEsercizioA()) &&
						GenericUtil.isNullOrEmpty(consumo.getFlgCircuitoImpTer()) &&
						GenericUtil.isNullOrEmpty(consumo.getFlgCircuitoAcs()) &&
						GenericUtil.isNullOrEmpty(consumo.getFlgCircuitoAltri()) &&
						GenericUtil.isNullOrEmpty(consumo.getNomeProdotto()) &&
						GenericUtil.isNullOrEmpty(consumo.getUnitaMisura()) &&
						GenericUtil.isNullOrEmpty(consumo.getConsumo()))
				{

					// Vuol dire che l'utente ha messo una riga completamente vuota
					// nel caso in cui sia un riga senza idDb vuol dire che ha fatto l'inserimento (quindi sul DB non c'e' e non devo fare niente)
					// nel caso in cui sia un riga con idDb vuol dire che ha cancellato i dati di una riga gia' presente (quindi devo cancellarla dal DB)

					if (consumo.getIdConsumo() != null)
					{
						listPkChiaviCancellare.add(consumo.getIdConsumo());
					}
				}
				else
				{
					if (consumo.getIdConsumo() != null)
					{
						// oggetto di cui bisogna fare l'update
						log.debug("[DbMgr::salvaLibrettoScheda14_4] - UPDATE: "+consumo.getIndice() + " - " + consumo.getIdConsumo() + " - " + consumo.getEsercizioDa() + " - " + consumo.getEsercizioA());

						consumoEntity = MapDto.mapToSigitTProdottiChimiciDto(consumo, consumo.getIdConsumo(), codiceImpianto, cfUtenteMod);
						getSigitTConsumo144Dao().update(consumoEntity);

					}
					else
					{
						// testConsumoWeb - oggetto di cui bisogna fare l'insert
						log.debug("[DbMgr::salvaLibrettoScheda14_4] - INSERT: "+consumo.getIndice() + " - " + consumo.getEsercizioDa() + " - " + consumo.getEsercizioA());

						consumoEntity = MapDto.mapToSigitTProdottiChimiciDto(consumo, null, codiceImpianto, cfUtenteMod);
						getSigitTConsumo144Dao().insert(consumoEntity);
						//tUnitaImm.setIdUnitaImm(tUnitaImmPk.getIdUnitaImm());
					}
				}
			}

			if (listPkChiaviCancellare != null)
			{
				for (Integer pkChiaveCancellare : listPkChiaviCancellare) {

					log.debug("[DbMgr::salvaLibrettoScheda14_4] - DELETE: "+pkChiaveCancellare);

					getSigitTConsumo144Dao().delete(new SigitTConsumo14_4Pk(ConvertUtil.convertToBigDecimal(pkChiaveCancellare)));
					getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_consumo_14_4", "id_consumo_h2o="+pkChiaveCancellare));

				}
			}

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLibrettoScheda14_4] END");
		}
	}

	/*
	public ArrayList<Consumo> salvaLibrettoScheda14_3(ArrayList<Consumo> listaConsumi, String cfUtenteMod, String descRuolo,String codiceImpianto) throws DbManagerException, ManagerException {
		log.debug("[DbMgr::salvaLibrettoScheda14_3] BEGIN");

		try {


			// Cancello tutti i consumi combustibile per codice impianto
			getSigitTConsumoDao().customDeleterAcquaByCodImpianto(ConvertUtil.convertToInteger(codiceImpianto));

			// insert dei nuovi consumi
			for(Consumo consumo : listaConsumi){

				if (GenericUtil.isNotNullOrEmpty(consumo.getEsercizioDa()) ||
						GenericUtil.isNotNullOrEmpty(consumo.getEsercizioA()) ||
						GenericUtil.isNotNullOrEmpty(consumo.getUnitaMisura()) ||
						GenericUtil.isNotNullOrEmpty(consumo.getLetturaIniziale()) ||
						GenericUtil.isNotNullOrEmpty(consumo.getLetturaFinale()) ||
						GenericUtil.isNotNullOrEmpty(consumo.getConsumo()))
				{
					// Se non entro qua vuol dire che l'utente ha messo una riga completamente vuota, quindi non la inserisco

					consumo.setLetturaIniziale(consumo.getLetturaIniziale().replaceAll("[.]",""));
					consumo.setLetturaFinale(consumo.getLetturaFinale().replaceAll("[.]",""));
					consumo.setConsumo(consumo.getConsumo().replaceAll("[.]",""));
					getSigitTConsumoDao().insert(MapDto.mapToSigitTConsumoAcquaDto(consumo,ConvertUtil.convertToBigDecimal(codiceImpianto),cfUtenteMod));

				}
			}

			return listaConsumi;
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLibrettoScheda14_3] END");
		}
	}
	*/

	public Impianto cercaImpiantoById(String idImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaImpiantoById] BEGIN");
		try {
			log.info("[DbMgr::cercaImpiantoById] idImpianto: "+idImpianto);

			Impianto impianto = null;
			log.debug("cerco impianto");
			SigitTImpiantoDto impiantoDto = getSigitTImpiantoDao().findByPrimaryKey(new SigitTImpiantoPk(ConvertUtil.convertToBigDecimal(idImpianto)));

			log.debug("cerco pg");
			//SigitTPersonaGiuridicaDto personaGiuridicaDto = cercaPersonaGiuridicaByCodImpianto(idImpianto);

			log.debug("cerco installatore");
			SigitRImpRuoloPfpgDto installatore = getInstallatoreImpianto(idImpianto);
			SigitTPersonaGiuridicaDto caricatorePG = null;
			SigitTPersonaFisicaDto caricatorePF = null;

			if (installatore != null)
			{
				if (installatore.getFkPersonaGiuridica() != null)
				{
					caricatorePG = cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(installatore.getFkPersonaGiuridica()));
				}
				else if (installatore.getFkPersonaFisica() != null)
				{
					caricatorePF = cercaTPersonaFisicaById(ConvertUtil.convertToInteger(installatore.getFkPersonaFisica()));
				}
			}


//			SigitRImpRuoloPfpgDto installatore = cercaInstallatoreImpianto(idImpianto, personaGiuridicaDto.getIdPersonaGiuridica());
//			boolean isPrimoInstallatore = false;
//			if (installatore != null)
//			{
//				isPrimoInstallatore = ConvertUtil.convertToBooleanAllways(installatore.getFlgPrimoCaricatore());
//			}

			log.debug("cerco ui");
			SigitTUnitaImmobiliareDto unitaImmobiliareDto = cercaSigitTUnitaImmobiliareByCodImpianto(ReplaceSpecialCharUtils.sanitize(idImpianto));

			log.debug("cerco libretto");
			List<SigitTLibrettoDto> librettoListDto = cercaLibretto(idImpianto);
			String dataConsolidamento = null;
			boolean isInModifica = false;

			if (librettoListDto != null)
			{
				//log.debug("STAMPO LIBRETTO LIST: "+librettoListDto);

				for (SigitTLibrettoDto sigitTLibrettoDto : librettoListDto) {

					if (sigitTLibrettoDto.getFkStato().intValue() == Constants.ID_STATO_LIBRETTO_CONSOLIDATO.intValue() && dataConsolidamento == null)
					{
						dataConsolidamento = ConvertUtil.convertToString(sigitTLibrettoDto.getDataConsolidamento());
					}

					if (sigitTLibrettoDto.getFkStato().intValue() == Constants.ID_STATO_LIBRETTO_BOZZA.intValue())
					{
						isInModifica = true;
					}
				}

			}

			log.debug("STAMPO isInModifica: "+isInModifica);

			if (log.isDebugEnabled())
			{
				GenericUtil.stampa(impiantoDto, true, 3);
				//GenericUtil.stampa(personaGiuridicaDto, true, 3);
				GenericUtil.stampa(unitaImmobiliareDto, true, 3);
			}

			//if (impiantoDto != null && personaGiuridicaDto != null && unitaImmobiliareDto != null)
			if (impiantoDto != null && unitaImmobiliareDto != null)
			{

				Proprietario proprietario = getProprietarioImpianto(idImpianto);

				//impianto = MapDto.mapToImpianto(impiantoDto, personaGiuridicaDto, unitaImmobiliareDto, proprietario, isPrimoInstallatore, dataConsolidamento, isInModifica);
				impianto = MapDto.mapToImpianto(impiantoDto, caricatorePG, caricatorePF, unitaImmobiliareDto, proprietario, dataConsolidamento, isInModifica);
			}
			else
			{
				throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DB));
			}

			if (log.isDebugEnabled())
				GenericUtil.stampa(impianto, true, 3);

			return impianto;

		}
		catch(Exception e) {
			log.error("Errore cercando l'impianto",e);
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaImpiantoById] END");
		}
	}

	public SigitRImpRuoloPfpgDto getInstallatoreImpianto(String codiceImpianto) throws SigitRImpRuoloPfpgDaoException {

		FiltroRicercaPfPg filter = new FiltroRicercaPfPg();
		filter.setCodiceImpianto(ReplaceSpecialCharUtils.sanitize(codiceImpianto));
		filter.setIdRuolo(ConvertUtil.convertToString(Constants.ID_RUOLO_CARICATORE));

		List<SigitRImpRuoloPfpgDto> installatoriList = getSigitRImpRuoloPfpgDao().findSoloAttiviByFilter(filter);
		if (installatoriList != null && !installatoriList.isEmpty()) {
			return installatoriList.get(0);
		}
		return null;
	}

	public SigitRImpRuoloPfpgDto cercaInstallatoreImpianto(String codImpianto, BigDecimal idPersonaGiuridica) throws DbManagerException {

		log.debug("[DbMgr::cercaInstallatoreImpianto] BEGIN");
		SigitRImpRuoloPfpgDto dto = null;
		try {

			PersonaRuoloFilter filter = new PersonaRuoloFilter();
			filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filter.setIdPersonaGiuridica(ConvertUtil.convertToInteger(idPersonaGiuridica));
			filter.setIdRuolo(Constants.ID_RUOLO_CARICATORE);

			List<SigitRImpRuoloPfpgDto> installatoreList = getSigitRImpRuoloPfpgDao().findRuoloAttivoPgByCodImpiantoRuolo(filter);
			if (installatoreList != null && installatoreList.size() == 1)
			{
				dto = installatoreList.get(0);
			}

		}
		catch(SigitRImpRuoloPfpgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaInstallatoreImpianto] END");
		}
		return dto;
	}

	public SigitVTotImpiantoCercaUbicazioneImpiantoDto cercaUbicazioneImpianto(Integer codImpianto) throws DbManagerException {

		log.debug("[DbMgr::cercaUbicazioneImpianto] BEGIN");
		SigitVTotImpiantoCercaUbicazioneImpiantoDto dto = null;
		try {

			List<SigitVTotImpiantoCercaUbicazioneImpiantoDto> dtoList  = getSigitVTotImpiantoDao().findCercaUbicazioneImpianto(codImpianto);

			// L'indirizzo dell'impianto e' univoco
			if(dtoList!=null && dtoList.size() > 0) {
				dto = dtoList.get(0);
			}
		}
		catch(SigitVTotImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaUbicazioneImpianto] END");
		}
		return dto;
	}

	public List<SigitVTotImpiantoCercaImpiantoPerAllegatiDto> cercaImpiantoPerAllegati(Integer codImpianto) throws DbManagerException {
		List<SigitVTotImpiantoCercaImpiantoPerAllegatiDto> dtoList = null;
		log.debug("[DbMgr::cercaImpiantoPerAllegati] BEGIN");
		try {

			dtoList = getSigitVTotImpiantoDao().findCercaImpiantoPerAllegati(codImpianto);

		}
		catch(SigitVTotImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaImpiantoPerAllegati] END");
		}
		return dtoList;
	}

	public List<SigitVRicercaAllegatiDto> cercaElencoAllegatiPerImpianto(String codImpianto) throws DbManagerException {
		List<SigitVRicercaAllegatiDto> dtoList = null;
		log.debug("[DbMgr::cercaElencoAllegatiPerImpianto] BEGIN");
			try {

				dtoList = this.getSigitVRicercaAllegatiDao().findByCodiceImpianto(codImpianto);

			} catch (SigitVRicercaAllegatiDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally{

				log.debug("[DbMgr::cercaElencoAllegatiPerImpianto] END");
			}
			return dtoList;
	}

	public List<SigitVRicercaAllegatiByCodiceImpiantoCountVerificheDto> cercaElencoAllegatiPerImpiantoCountVerifiche(String codImpianto) throws DbManagerException {
		List<SigitVRicercaAllegatiByCodiceImpiantoCountVerificheDto> dtoList = null;
		log.debug("[DbMgr::cercaElencoAllegatiPerImpiantoCountVerifiche] BEGIN");
			try {

				dtoList = this.getSigitVRicercaAllegatiDao().findByCodiceImpiantoCountVerifiche(codImpianto);

			} catch (SigitVRicercaAllegatiDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally{

				log.debug("[DbMgr::cercaElencoAllegatiPerImpiantoCountVerifiche] END");
			}
			return dtoList;
	}

	public List<SigitVRicercaAllegatiStoricoDto> cercaElencoStoricoAllegatiPerImpianto(String codImpianto) throws DbManagerException {
		List<SigitVRicercaAllegatiStoricoDto> dtoList = null;
		log.debug("[DbMgr::cercaElencoStoricoAllegatiPerImpianto] BEGIN");
			try {

				dtoList = this.getSigitVRicercaAllegatiStoricoDao().findByCodiceImpianto(codImpianto);

			} catch (SigitVRicercaAllegatiStoricoDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally{

				log.debug("[DbMgr::cercaElencoStoricoAllegatiPerImpianto] END");
			}
			return dtoList;
	}

	public List<SigitVRicercaAllegatiDto> cercaElencoAllegatiPerCancImpianto(String codImpianto) throws DbManagerException {
		List<SigitVRicercaAllegatiDto> dtoList = null;
		log.debug("[DbMgr::cercaElencoAllegatiPerImpianto] BEGIN");
			try {
				FiltroRicercaAllegati filtro = new FiltroRicercaAllegati();
				filtro.setCodiceImpianto(ConvertUtil.convertToInteger(codImpianto));

				dtoList = this.getSigitVRicercaAllegatiDao().findByFiltriUtente(filtro);

			} catch (SigitVRicercaAllegatiDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally{

				log.debug("[DbMgr::cercaElencoAllegatiPerImpianto] END");
			}
			return dtoList;
	}

	public List<SigitTDocAggiuntivaByCodImpDecodDto> cercaElencoDocumentiPerImpianto(Integer codImpianto) throws DbManagerException {
		List<SigitTDocAggiuntivaByCodImpDecodDto> dtoList = null;
		log.debug("[DbMgr::cercaElencoDocumentiPerImpianto] BEGIN");
			try {

				dtoList = this.getSigitTDocAggiuntivaDao().findByCodImpDecod(codImpianto);
			} catch (SigitTDocAggiuntivaDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally{

				log.debug("[DbMgr::cercaElencoDocumentiPerImpianto] END");
			}
			return dtoList;
	}

	public List<SigitTDocAllegatoDto> cercaElencoDocumentiPerIdAllegato(Integer idAllegato) throws DbManagerException {
		List<SigitTDocAllegatoDto> dtoList = null;
		log.debug("[DbMgr::cercaElencoDocumentiPerIdAllegato] BEGIN");
			try {

				dtoList = this.getSigitTDocAllegatoDao().findByIdAllegato(idAllegato);
			} catch (SigitTDocAllegatoDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally{

				log.debug("[DbMgr::cercaElencoDocumentiPerIdAllegato] END");
			}
			return dtoList;
	}

	public List<SigitVRicercaIspezioniDto> cercaElencoIspezioniPerImpianto(Integer codImpianto) throws DbManagerException {
		List<SigitVRicercaIspezioniDto> dtoList = null;
		log.debug("[DbMgr::cercaElencoIspezioniPerImpianto] BEGIN");
			try {

				dtoList = this.getSigitVRicercaIspezioniDao().findByCodiceImpianto(codImpianto);

			} catch (SigitVRicercaIspezioniDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally{

				log.debug("[DbMgr::cercaElencoIspezioniPerImpianto] END");
			}
			return dtoList;
	}

	public List<SigitTAllegatoRappProvaByIdIspezioneDto> cercaElencoRapProvaPerIspezione(Integer idIspezione) throws DbManagerException {
		List<SigitTAllegatoRappProvaByIdIspezioneDto> dtoList = null;
		log.debug("[DbMgr::cercaElencoRapProvaPerIspezione] BEGIN");
			try {

				dtoList = this.getSigitTAllegatoDao().findRappProvaByIdIspezione(idIspezione);

			} catch (SigitTAllegatoDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally{

				log.debug("[DbMgr::cercaElencoRapProvaPerIspezione] END");
			}
			return dtoList;
	}

	public SigitTAllegatoRappProvaByIdAllegatoDto cercaRappProvaByIdAllegato(Integer idAllegato) throws DbManagerException {
		SigitTAllegatoRappProvaByIdAllegatoDto dto = null;
		log.debug("[DbMgr::SigitTAllegatoRappProvaByIdAllegatoDto] BEGIN");
			try {

				List<SigitTAllegatoRappProvaByIdAllegatoDto> dtoList = this.getSigitTAllegatoDao().findRappProvaByIdAllegato(idAllegato);

				if (dtoList != null && dtoList.size() != 0) {
					dto = dtoList.get(0);
				}

			} catch (SigitTAllegatoDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally{

				log.debug("[DbMgr::SigitTAllegatoRappProvaByIdAllegatoDto] END");
			}
			return dto;
	}

	public SigitTAllegatoDto cercaSigitTAllegatoById(BigDecimal idAllegato) throws DbManagerException {
		SigitTAllegatoDto dto = null;
		log.debug("[DbMgr::cercaSigitTAllegatoById] BEGIN");
			try {

				dto = this.getSigitTAllegatoDao().findByPrimaryKey(new SigitTAllegatoPk(idAllegato));

			} catch (SigitTAllegatoDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally{

				log.debug("[DbMgr::cercaSigitTAllegatoById] END");
			}
			return dto;
	}

	public SigitTAllTxtDto cercaSigitTAllTxtById(BigDecimal idAllegato) throws DbManagerException {
		SigitTAllTxtDto dto = null;
		log.debug("[DbMgr::cercaSigitTAllTxtById] BEGIN");
			try {

				dto = this.getSigitTAllTxtDao().findByPrimaryKey(new SigitTAllTxtPk(idAllegato));

			} catch (SigitTAllTxtDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally{

				log.debug("[DbMgr::cercaSigitTAllTxtById] END");
			}
			return dto;
	}

	/*
	public List<SigitTAllegatoDto> cercaSigitTAllegatoByCodImpianto(String codImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitTAllegatoByCodImpianto] BEGIN");
		try {

			List<SigitTAllegatoDto> allegatoDtoList = getSigitTAllegatoDao().findByCodiceImpianto(ConvertUtil.convertToInteger(codImpianto));

			return allegatoDtoList;

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitTAllegatoByCodImpianto] END");
		}
	}
	*/

	public SigitVRicercaAllegatiDto cercaSigitVRicercaAllegatiByIdAllegato(String idAllegato) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitVRicercaAllegatiByIdAllegato] BEGIN");
		SigitVRicercaAllegatiDto allegatoDto = null;
		try {

			List<SigitVRicercaAllegatiDto> allegatoDtoList = getSigitVRicercaAllegatiDao().findByIdAllegato(idAllegato);

			if (allegatoDtoList != null && allegatoDtoList.size() == 1)
			{
				allegatoDto = allegatoDtoList.get(0);
			}

			return allegatoDto;

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitVRicercaAllegatiByIdAllegato] END");
		}
	}

	public SigitVRicercaAllegatiStoricoDto cercaSigitVRicercaAllegatiStoricoByIdAllegato(String idAllegato) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitVRicercaAllegatiStoricoByIdAllegato] BEGIN");
		SigitVRicercaAllegatiStoricoDto allegatoDto = null;
		try {

			List<SigitVRicercaAllegatiStoricoDto> allegatoDtoList = getSigitVRicercaAllegatiStoricoDao().findByIdAllegato(idAllegato);

			if (allegatoDtoList != null && allegatoDtoList.size() == 1)
			{
				allegatoDto = allegatoDtoList.get(0);
			}

			return allegatoDto;

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitVRicercaAllegatiStoricoByIdAllegato] END");
		}
	}

	/*
	public SigitTCodiceImpDto cercaSigitTCodiceImpById(BigDecimal codImpianto) throws DbManagerException {
		SigitTCodiceImpDto dto = null;
		log.debug("[DbMgr::cercaSigitTCodiceImpById] BEGIN");
			try {

				dto = this.getSigitTCodiceImpDao().findByPrimaryKey(new SigitTCodiceImpPk(codImpianto));

			} catch (SigitTCodiceImpDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
			finally{

				log.debug("[DbMgr::cercaSigitTCodiceImpById] END");
			}
			return dto;
	}
	*/

	public SigitTUnitaImmobiliareDto cercaSigitTUnitaImmobiliareByCodImpianto(String codImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitTUnitaImmobiliareByCodImpianto] BEGIN");
		try {

			SigitTUnitaImmobiliareDto unitaImmobiliareDto = null;
			List<SigitTUnitaImmobiliareDto> unitaImmobiliareDtoList = getSigitTUnitaImmobiliareDao().findUnitaPrincipaleImpianto(ConvertUtil.convertToInteger(codImpianto));
					//(MapDto.mapToSigitTUnitaImmobiliareDto(impianto, cfUtenteMod));

			if (unitaImmobiliareDtoList != null && unitaImmobiliareDtoList.size() == 1)
			{
				unitaImmobiliareDto = unitaImmobiliareDtoList.get(0);
			}

			return unitaImmobiliareDto;

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitTUnitaImmobiliareByCodImpianto] END");
		}
	}

	public SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto cercaSigitTUnitaImmobiliareDecodByCodImpianto(String codImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitTUnitaImmobiliareDecodByCodImpianto] BEGIN");
		try {

			SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto unitaImmobiliareDto = null;
			List<SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto> unitaImmobiliareDtoList = getSigitTUnitaImmobiliareDao().findPrincipaleByCodiceImpianto(ConvertUtil.convertToInteger(codImpianto));
					//(MapDto.mapToSigitTUnitaImmobiliareDto(impianto, cfUtenteMod));

			if (unitaImmobiliareDtoList != null && unitaImmobiliareDtoList.size() == 1)
			{
				unitaImmobiliareDto = unitaImmobiliareDtoList.get(0);
			}

			return unitaImmobiliareDto;

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitTUnitaImmobiliareDecodByCodImpianto] END");
		}
	}


	public List<SigitTUnitaImmobiliareDto> cercaSigitTUnitaImmobiliareByFiltro(Subentro subentro) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitTUnitaImmobiliareByFiltro] BEGIN");
		try {

			List<SigitTUnitaImmobiliareDto> unitaImmobiliareDtoList = getSigitTUnitaImmobiliareDao().findPrincipaleByFilter(MapDto.mapToSigitTUnitaImmobiliareDto(subentro));

			return unitaImmobiliareDtoList;

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitTUnitaImmobiliareByFiltro] END");
		}
	}

	public List<SigitTUnitaImmobiliareDto> cercaSigitTUnitaImmobiliareByFiltro(TerzoResponsabile responsabile) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitTUnitaImmobiliareByFiltro] BEGIN");
		try {
			List<SigitTUnitaImmobiliareDto> unitaImmobiliareDtoList =
					getSigitTUnitaImmobiliareDao().findPrincipaleByFilter(MapDto.mapToSigitTUnitaImmobiliareDto(responsabile));
			return unitaImmobiliareDtoList;
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitTUnitaImmobiliareByFiltro] END");
		}
	}


	public SigitTLibrettoDto cercaSigitTLibrettoConsolidatoByCodImpianto(String codImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitTLibrettoByCodImpianto] BEGIN");
		try {

			SigitTLibrettoDto librettoDto = null;
			List<SigitTLibrettoDto> librettoDtoList = cercaLibrettoByStato(codImpianto, Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
					//(MapDto.mapToSigitTUnitaImmobiliareDto(impianto, cfUtenteMod));

			if (librettoDtoList != null && librettoDtoList.size() == 1)
			{
				librettoDto = librettoDtoList.get(0);
			}
			else
			{
				// Ricerco il libretto nei libretti storicizzati
				List<SigitSLibrettoDto> librettoSDtoList = getSigitSLibrettoDao().findByLibrettoFilter(new LibrettoFilter(ConvertUtil.convertToInteger(codImpianto), Constants.ID_STATO_LIBRETTO_CONSOLIDATO));

				if (librettoSDtoList != null && librettoSDtoList.size() == 1)
				{
					librettoDto = MapDto.mapToSigitTLibrettoDto(librettoSDtoList.get(0));
				}
			}


			return librettoDto;

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitTLibrettoByCodImpianto] END");
		}
	}


	public SigitRImpRuoloPfpgDto cercaSigitRImpRuoloPfpgByCodImpianto(String idImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitRImpRuoloPfpgByCodImpianto] BEGIN");
		try {

			SigitRImpRuoloPfpgDto impRuoloPfpgDto = null;
			List<SigitRImpRuoloPfpgDto> impRuoloPfpgDtoList = getSigitRImpRuoloPfpgDao().findByCodiceImpianto(ConvertUtil.convertToInteger(idImpianto));
					//(MapDto.mapToSigitTUnitaImmobiliareDto(impianto, cfUtenteMod));

			if (impRuoloPfpgDtoList != null && impRuoloPfpgDtoList.size() == 1)
			{
				impRuoloPfpgDto = impRuoloPfpgDtoList.get(0);
			}

			return impRuoloPfpgDto;

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitRImpRuoloPfpgByCodImpianto] END");
		}
	}

	public SigitRImpRuoloPfpgDto cercaSigitRImpRuoloPfpgById(BigDecimal idImpRuoloPfpg) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitRImpRuoloPfpgById] BEGIN");
		try {

			SigitRImpRuoloPfpgDto impRuoloPfpgDto = getSigitRImpRuoloPfpgDao().findByPrimaryKey(new SigitRImpRuoloPfpgPk(idImpRuoloPfpg));

			return impRuoloPfpgDto;

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitRImpRuoloPfpgById] END");
		}
	}

	public List<SigitRImpRuoloPfpgDto> cercaSigitRImpRuoloPfpgByRuoloFunzCodImpianto(BigDecimal idImpianto, Integer idPersonaGiuridica, String cfPersonaFisica, String ruoloFunzionale) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitRImpRuoloPfpgByRuoloFunzCodImpianto] BEGIN");
		try {

			List<SigitRImpRuoloPfpgDto> impRuoloPfpgDtoList = null;

			PersonaRuoloFilter filter = new PersonaRuoloFilter();
			filter.setCodiceImpianto(idImpianto);
			filter.setRuoloFunz(ReplaceSpecialCharUtils.sanitize(ruoloFunzionale));

			if (ruoloFunzionale.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)
				|| ruoloFunzionale.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO_IMPRESA)
				|| ruoloFunzionale.equalsIgnoreCase(Constants.RUOLO_3RESPONSABILE))
			{
				filter.setIdPersonaGiuridica(idPersonaGiuridica);
				impRuoloPfpgDtoList = getSigitRImpRuoloPfpgDao().findRuoloAttivoPgByCodImpiantoRuoloFunz(filter);

			}
			else if (ruoloFunzionale.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE)
					|| ruoloFunzionale.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO))
			{
				filter.setCfPersonaFisica(ReplaceSpecialCharUtils.sanitize(cfPersonaFisica));
				impRuoloPfpgDtoList = getSigitRImpRuoloPfpgDao().findRuoloAttivoPfByCodImpiantoRuoloFunz(filter);

			}

			return impRuoloPfpgDtoList;

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitRImpRuoloPfpgByRuoloFunzCodImpianto] END");
		}
	}

	public List<SigitRImpRuoloPfpgDto> cercaSigitRImpRuoloPfpgBySubentro(Subentro subentro, String descRuolo) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitRImpRuoloPfpgBySubentro] BEGIN");
		try {

			List<SigitRImpRuoloPfpgDto> impRuoloPfpgDtoList = null;

			PersonaRuoloFilter filter = new PersonaRuoloFilter();
			filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(subentro.getImpCodImpianto()));

			if (subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_AMMINISTRATORE ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_PROPRIETARIO ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_OCCUPANTE ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE)
			{
				if (descRuolo.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA))
				{
					filter.setIdPersonaGiuridica(subentro.getRespImpId());
					impRuoloPfpgDtoList = getSigitRImpRuoloPfpgDao().findRespImpRespAttivoPgByCodImpianto(filter);

				}
				else if (descRuolo.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE))
				{
					filter.setCfPersonaFisica(subentro.getRespImpCf());
					impRuoloPfpgDtoList = getSigitRImpRuoloPfpgDao().findRespImpRespAttivoPfByCodImpianto(filter);
				}
			}
			else if (subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_CARICATORE)
			{
				filter.setIdPersonaGiuridica(subentro.getRespImpId());
				filter.setIdRuolo(subentro.getIdTipoSubentro());
				impRuoloPfpgDtoList = getSigitRImpRuoloPfpgDao().findRuoloAttivoPgByCodImpiantoRuolo(filter);

			}
			else if (subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_1 ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_2 ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_3 ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_4)
			{
				filter.setIdPersonaGiuridica(subentro.getRespImpId());
				filter.setIdRuolo(subentro.getIdTipoSubentro());
				impRuoloPfpgDtoList = getSigitRImpRuoloPfpgDao().findRuoloAttivoPgByCodImpiantoRuolo(filter);

			}

			return impRuoloPfpgDtoList;

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitRImpRuoloPfpgBySubentro] END");
		}
	}

	@Transactional
	public void effettuaSubentro(Subentro subentro, String descRuolo, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::effettuaSubentro] BEGIN");
		try {

			SigitRImpRuoloPfpgDto dtoUpdate = new SigitRImpRuoloPfpgDto();
			dtoUpdate.setCodiceImpianto(ConvertUtil.convertToBigDecimal(subentro.getImpCodImpianto()));
			dtoUpdate.setUtenteUltMod(cfUtenteMod);
			dtoUpdate.setDataUltMod(DateUtil.getSqlDataCorrente());

			SigitRImpRuoloPfpgDto dto = new SigitRImpRuoloPfpgDto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(subentro.getImpCodImpianto()));
			dto.setDataInizio(DateUtil.getSqlCurrentDate());
			dto.setFkRuolo(ConvertUtil.convertToBigDecimal(subentro.getIdTipoSubentro()));

			if (subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_AMMINISTRATORE ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_PROPRIETARIO ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_OCCUPANTE ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO ||
					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO_IMPRESA)
			{
				// Modifico i ruoli vecchi
				if (subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_AMMINISTRATORE ||
						subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_PROPRIETARIO ||
						subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_OCCUPANTE ||
						subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE ||
						subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO ||
						subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE)
				{
					getSigitRImpRuoloPfpgDao().customUpdaterSubentroRespImpResp(dtoUpdate, null);
				} else if (subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO ||
						subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO_IMPRESA)
				{
					getSigitRImpRuoloPfpgDao().customUpdaterSubentroPropImpProp(dtoUpdate, null);
				}

				if (descRuolo.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA) ||
						descRuolo.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO_IMPRESA))
				{
					dto.setFkPersonaGiuridica(ConvertUtil.convertToBigDecimal(subentro.getRespImpId()));

				}
				else if (descRuolo.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE) ||
						descRuolo.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO))
				{
					dto.setFkPersonaFisica(ConvertUtil.convertToBigDecimal(subentro.getRespImpId()));
				}
			}
			else if (subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_CARICATORE)
			{
				dtoUpdate.setFkRuolo(ConvertUtil.convertToBigDecimal(subentro.getIdTipoSubentro()));

				getSigitRImpRuoloPfpgDao().customUpdaterSubentroInstManut(dtoUpdate, null);

				dto.setFkPersonaGiuridica(ConvertUtil.convertToBigDecimal(subentro.getRespImpId()));
				dto.setDataFine(DateUtil.addDaysToSqlDate(dto.getDataInizio(), Constants.CARICATORE_VALIDITY_DAYS));
			}
//			else if (subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_INSTALLATORE ||
//					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_1 ||
//					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_2 ||
//					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_3 ||
//					subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_4)
//			{
//				dtoUpdate.setFkRuolo(ConvertUtil.convertToBigDecimal(subentro.getIdTipoSubentro()));
//
//				getSigitRImpRuoloPfpgDao().customUpdaterSubentroInstManut(dtoUpdate, null);
//
//				dto.setFkPersonaGiuridica(ConvertUtil.convertToBigDecimal(subentro.getRespImpId()));
//
//			}

			dto.setUtenteUltMod(cfUtenteMod);
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());

			getSigitRImpRuoloPfpgDao().insert(dto);

		}
		catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::effettuaSubentro] END");
		}
	}

	@Transactional
	public void effettuaSubentroManutentore(Subentro subentro, String descRuolo, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::effettuaSubentroManutentore] BEGIN");
		try {


			String descTipoComp = null;
			int tipoSub = subentro.getIdTipoSubentro().intValue();

			if (tipoSub == Constants.ID_RUOLO_MANUTENTORE_ALL_1)
			{
				descTipoComp = Constants.TIPO_COMPONENTE_GT;
			} else if (tipoSub == Constants.ID_RUOLO_MANUTENTORE_ALL_2)
			{
				descTipoComp = Constants.TIPO_COMPONENTE_GF;
			} else if (tipoSub == Constants.ID_RUOLO_MANUTENTORE_ALL_3)
			{
				descTipoComp = Constants.TIPO_COMPONENTE_SC;
			} else if (tipoSub == Constants.ID_RUOLO_MANUTENTORE_ALL_4)
			{
				descTipoComp = Constants.TIPO_COMPONENTE_CG;
			}

			ArrayList<String> listaProgressivi = subentro.getIdApparecchiature();

			CompFilter filter = new CompFilter();
			filter.setCodImpianto(subentro.getImpCodImpianto());
			filter.setTipoComponente(descTipoComp);
			filter.setListProgressivi(listaProgressivi);

			if (log.isDebugEnabled())
				GenericUtil.stampa(filter, true, 3);

			// Faccio l'update
			getSigitRComp4ManutDao().customUpdaterPerSubentro(filter, cfUtenteMod);

			log.debug("Faccio l'update dei vecchi");

			// Faccio l'insert per ogni progressivo


//			SigitRComp4ManutDto comp4Manut = null;
//			for (String progressivo : listaProgressivi) {
//				comp4Manut = new SigitRComp4ManutDto();
//				comp4Manut.setFkPersonaGiuridica(ConvertUtil.convertToBigDecimal(subentro.getRespImpId()));
//				comp4Manut.setCodiceImpianto(ConvertUtil.convertToBigDecimal(subentro.getImpCodImpianto()));
//				comp4Manut.setIdTipoComponente(descTipoComp);
//				comp4Manut.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
//				comp4Manut.setFkRuolo(ConvertUtil.convertToBigDecimal(tipoSub));
//
//				comp4Manut.setDataInizio(DateUtil.getSqlCurrentDate());
//				comp4Manut.setDataUltMod(DateUtil.getSqlDataCorrente());
//				comp4Manut.setUtenteUltMod(cfUtenteMod);
//
//
//				getSigitRComp4ManutDao().insert(comp4Manut);
//			}

			log.debug("#### STAMPO subentro.getRespImpId(): "+subentro.getRespImpId());
			log.debug("#### STAMPO subentro.getImpCodImpianto(): "+subentro.getImpCodImpianto());

			SigitRComp4ManutDto comp4Manut = new SigitRComp4ManutDto();
			comp4Manut.setFkPersonaGiuridica(ConvertUtil.convertToBigDecimal(subentro.getRespImpId()));
			comp4Manut.setCodiceImpianto(ConvertUtil.convertToBigDecimal(subentro.getImpCodImpianto()));
			comp4Manut.setIdTipoComponente(descTipoComp);
			comp4Manut.setFkRuolo(ConvertUtil.convertToBigDecimal(tipoSub));

			comp4Manut.setDataInizio(DateUtil.getSqlCurrentDate());
			comp4Manut.setDataUltMod(DateUtil.getSqlDataCorrente());
			comp4Manut.setUtenteUltMod(cfUtenteMod);

			for (String progressivo : listaProgressivi) {

				log.debug("####STAMPO IL PROGRESSIVO: "+progressivo);

				comp4Manut.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));


				if (log.isDebugEnabled())
					GenericUtil.stampa(comp4Manut, true, 3);

				getSigitRComp4ManutDao().insert(comp4Manut);
			}

		}
		catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::effettuaSubentroManutentore] END");
		}
	}

	/*
	public List<SigitRImpRuoloPfpgDto> cercaSigitRImpRuoloByRuoloCodImpianto(String idImpianto, Integer ruolo)  throws DbManagerException {
		log.debug("[DbMgr::cercaSigitRImpRuoloByRuoloCodImpianto] BEGIN");
		try {

			List<SigitRImpRuoloPfpgDto> impRuoloPfpgDtoList = null;

			PersonaRuoloFilter filter = new PersonaRuoloFilter();
			filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(idImpianto));
			filter.setIdRuolo(ruolo);
			impRuoloPfpgDtoList = getSigitRImpRuoloPfpgDao().findRuoloAttivoPgByCodImpiantoRuolo(filter);

			return impRuoloPfpgDtoList;

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitRImpRuoloByRuoloCodImpianto] END");
		}
	}
	*/

	public SigitTPersonaGiuridicaDto cercaSigitTPersonaGiuridicaByIdImpRuoloPfpg(BigDecimal idImpRuoloPfpg) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitTPersonaGiuridicaByIdImpRuoloPfpg] BEGIN");
		try {

			SigitRImpRuoloPfpgDto impRuoloPfpgDto = getSigitRImpRuoloPfpgDao().findByPrimaryKey(new SigitRImpRuoloPfpgPk(idImpRuoloPfpg));
					//(MapDto.mapToSigitTUnitaImmobiliareDto(impianto, cfUtenteMod));

			SigitTPersonaGiuridicaDto personaGiuridicaDto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(impRuoloPfpgDto.getFkPersonaGiuridica()));

			return personaGiuridicaDto;

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitTPersonaGiuridicaByIdImpRuoloPfpg] END");
		}
	}

	public SigitTPersonaGiuridicaDto cercaSigitTPersonaGiuridicaAcqCodImpianto(String codImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitTPersonaGiuridicaByIdImpRuoloPfpg] BEGIN");
		try {

			List<SigitTPersonaGiuridicaDto> personaGiuridicaAcqCodImpiantoList = getSigitTPersonaGiuridicaDao().findAcquisitoCodImpByCodiceImpianto((ConvertUtil.convertToInteger(codImpianto)));

			return personaGiuridicaAcqCodImpiantoList.get(0);

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitTPersonaGiuridicaByIdImpRuoloPfpg] END");
		}
	}


	public SigitTPersonaGiuridicaDto cercaPersonaGiuridicaByCodImpianto(String idImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaPersonaGiuridicaByCodImpianto] BEGIN");
		try {

			SigitTPersonaGiuridicaDto personaGiuridicaDto = null;
			List<SigitTPersonaGiuridicaDto> personaGiuridicaDtoList = getSigitTPersonaGiuridicaDao().findByCodiceImpianto(ConvertUtil.convertToInteger(idImpianto));

			log.debug("STAMPO personaGiuridicaDtoList: "+personaGiuridicaDtoList);

			log.debug("STAMPO LA LUNGHEZZA: "+personaGiuridicaDtoList.size());

			if (personaGiuridicaDtoList != null && personaGiuridicaDtoList.size() == 1)
			{
				log.debug("HO TROVATO UNA SOLA PERSONA GIURIDICA!!!!\n\n");
				personaGiuridicaDto = personaGiuridicaDtoList.get(0);
			}

			return personaGiuridicaDto;

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaGiuridicaByCodImpianto] END");
		}
	}

	@Transactional
	public Responsabile salvaResponsabileTrans(Responsabile responsabile, String codiceImpianto, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaResponsabileTrans] BEGIN");
		try {
			return salvaResponsabile(responsabile, codiceImpianto, cfUtenteMod);

		}
		catch(DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw e;
		}
		finally {
			log.debug("[DbMgr::salvaResponsabileTrans] END");
		}
	}





	public Responsabile salvaResponsabile(Responsabile responsabile, String codiceImpianto, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaResponsabile] BEGIN");
		try {

			if (GenericUtil.isNullOrEmpty(responsabile.getIdImpResp()))
			{

				Responsabile respoProprietario = null;
				boolean isProprietario = false;
				// Sono in inserimento della relazione

				// responsabile.getIdResponsabile() == null vuol dire che non trovato un responsabile/proprietario dopo aver fatto la ricerca
				if (GenericUtil.isNullOrEmpty(responsabile.getIdResponsabile()))
				{
					// Sono in inserimento della persona
					if (responsabile.getFlgImpresa())
					{
						SigitTPersonaGiuridicaPk personaGiuridica = getSigitTPersonaGiuridicaDao().insert(MapDto.mapToSigitTPersonaGiuridicaDto(responsabile, cfUtenteMod));
						responsabile.setIdResponsabile(ConvertUtil.convertToInteger(personaGiuridica.getIdPersonaGiuridica()));
					}
					else
					{
						SigitTPersonaFisicaPk personaFisica = getSigitTPersonaFisicaDao().insert(MapDto.mapToSigitTPersonaFisicaDto(responsabile, cfUtenteMod));
						responsabile.setIdResponsabile(ConvertUtil.convertToInteger(personaFisica.getIdPersonaFisica()));
					}

				}
				else
				{
					// Sono in modifica della persona
					if (responsabile.getFlgImpresa())
					{

						SigitTPersonaGiuridicaDto sigitTPersonaGiuridicaDto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(ConvertUtil.convertToBigDecimal(responsabile.getIdResponsabile())));
						getSigitTPersonaGiuridicaDao().update(MapDto.margeMapToSigitTPersonaGiuridicaDto(responsabile, sigitTPersonaGiuridicaDto, cfUtenteMod));
					}
					else
					{
						SigitTPersonaFisicaDto sigitTPersonaFisicaDto = getSigitTPersonaFisicaDao().findByPrimaryKey(new SigitTPersonaFisicaPk(ConvertUtil.convertToBigDecimal(responsabile.getIdResponsabile())));
						getSigitTPersonaFisicaDao().update(MapDto.margeMapToSigitTPersonaFisicaDto(responsabile, sigitTPersonaFisicaDto, cfUtenteMod));
					}
				}


				// SOLO NEL CASO DI INSERIMENTO, se IdImpResp isNullOrEmpty vuol dire che sono in inserimento
				// Devo capire se e' un responsabile o un proprietario
				if (!ConvertUtil.convertToBooleanAllways(responsabile.getFlgResponsabile()))
				{
					// E' un proprietario

					// devo capire se PF o PG
					int idRuoloProprietario = responsabile.getFlgImpresa()?Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO_IMPRESA:Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO;
					responsabile.setIdTitolo(ConvertUtil.convertToString(idRuoloProprietario));
					isProprietario = true;
				}
				else
				{
					// E' un responsabile
					// devo capire se e' un PROPRIETARIO, in questo caso devo inserire una riga anche per proprietario
					int idRuolo = ConvertUtil.convertToInteger(responsabile.getIdTitolo());

					if (idRuolo == Constants.ID_RUOLO_PROPRIETARIO || idRuolo == Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO)
					{
						respoProprietario = new Responsabile();
						PropertyUtils.copyProperties(respoProprietario, responsabile);

						int idRuoloProprietario = 0;

						if (idRuolo == Constants.ID_RUOLO_PROPRIETARIO)
						{
							idRuoloProprietario = Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO;

						}
						else if (idRuolo == Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO)
						{
							idRuoloProprietario = Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO_IMPRESA;

						}

						respoProprietario.setIdTitolo(ConvertUtil.convertToString(idRuoloProprietario));
						isProprietario = true;

					}
				}


				// Nel caso siamo in inserimento proprietario devo verificare che non ci sia gia' un proprietario attivo
				log.debug("Sto inserendo un proprietario? "+isProprietario);
				if (isProprietario)
				{
					Proprietario proprietario = getProprietarioImpianto(codiceImpianto);

					// e' presente un vecchio proprietario da dismettere
					if (proprietario != null)
					{
						log.debug("Ho trovato un proprietario attivo");

						Date dataFine = DateUtil.getSqlDateMinusOneDay(ConvertUtil.convertToDate(responsabile.getDataInizioResp()));
						proprietario.setDataFine(ConvertUtil.convertToString(dataFine));
						cessaProprietario(proprietario, cfUtenteMod);

						log.debug("Ho cessato il proprietario IdImpRuoloPfPg: "+proprietario.getIdImpRuoloPfPg());

					}

					if (respoProprietario != null)
					{
						log.debug("Sto inserendo un responsabile proprietario");

						getSigitRImpRuoloPfpgDao().insert(MapDto.mapToSigitRImpRuoloPfpgDto(respoProprietario, codiceImpianto, cfUtenteMod));
					}

				}


				SigitRImpRuoloPfpgPk impRuoloPfpgPk = getSigitRImpRuoloPfpgDao().insert(MapDto.mapToSigitRImpRuoloPfpgDto(responsabile, codiceImpianto, cfUtenteMod));

				responsabile.setIdImpResp(ConvertUtil.convertToInteger(impRuoloPfpgPk.getIdImpRuoloPfpg()));
			}
			else
			{

				// Sono in modifica della persona
				if (responsabile.getFlgImpresa())
				{
					SigitTPersonaGiuridicaDto sigitTPersonaGiuridicaDto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(ConvertUtil.convertToBigDecimal(responsabile.getIdResponsabile())));
					getSigitTPersonaGiuridicaDao().update(MapDto.margeMapToSigitTPersonaGiuridicaDto(responsabile, sigitTPersonaGiuridicaDto, cfUtenteMod));
				}
				else
				{
					SigitTPersonaFisicaDto sigitTPersonaFisicaDto = getSigitTPersonaFisicaDao().findByPrimaryKey(new SigitTPersonaFisicaPk(ConvertUtil.convertToBigDecimal(responsabile.getIdResponsabile())));
					getSigitTPersonaFisicaDao().update(MapDto.margeMapToSigitTPersonaFisicaDto(responsabile, sigitTPersonaFisicaDto, cfUtenteMod));
				}

				getSigitRImpRuoloPfpgDao().update(MapDto.mapToSigitRImpRuoloPfpgDto(responsabile, codiceImpianto, cfUtenteMod));
			}
			return responsabile;

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaResponsabile] END");
		}
	}

	@Transactional
	public void modificaPersonaGiuridica(PersonaGiuridica pg, String utenteUltMod) throws DbManagerException
	{
		log.debug("[DbMgr::modificaPersonaGiuridica] BEGIN");
		try {

			SigitTPersonaGiuridicaDto dto = cercaTPersonaGiuridicaById(pg.getIdPersonaGiuridica());

			dto = MapDto.mapToSigitTPersonaGiuridicaDto(pg, dto, utenteUltMod);

			getSigitTPersonaGiuridicaDao().update(dto);

			if (GenericUtil.isNotNullOrEmpty(pg.getIdStatoPg())
					&& pg.getIdStatoPg().intValue() != pg.getIdStatoPgOld().intValue())
			{
				// Devo aggiornare anche la tabella SigitTStoricoVarStatoPg
				SigitTStoricoVarStatoPgDto statoPgDto = new SigitTStoricoVarStatoPgDto();

				statoPgDto.setIdPersonaGiuridica(ConvertUtil.convertToBigDecimal(pg.getIdPersonaGiuridica()));
				statoPgDto.setDtEvento(DateUtil.getSqlDataCorrente());
				statoPgDto.setStatoPgDa(pg.getIdStatoPgOld());
				statoPgDto.setStatoPgA(pg.getIdStatoPg());
				statoPgDto.setMotivo(GenericUtil.getStringSql(pg.getMotivoVariazione()));
				statoPgDto.setDtInizioVariazione(ConvertUtil.convertToSqlDate(pg.getDataVariazione()));
				statoPgDto.setUtenteUltMod(utenteUltMod);
				statoPgDto.setDataUltMod(DateUtil.getSqlDataCorrente());
				getSigitTStoricoVarStatoPgDao().insert(statoPgDto);
			}

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::modificaPersonaGiuridica] END");
		}
	}

	public List<SigitTStoricoVarStatoPgDto> cercaUltimoStoricoVarStatoPg(Integer idPg) throws DbManagerException {
		log.debug("[DbMgr::cercaUltimoStoricoVarStatoPg] BEGIN");
		SigitTStoricoVarStatoPgDto dto = null;
		try {
			List<SigitTStoricoVarStatoPgDto> dtoList = getSigitTStoricoVarStatoPgDao().findPiuRecenteByIdPg(idPg);


			return dtoList;
		}
		catch(SigitTStoricoVarStatoPgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaUltimoStoricoVarStatoPg] END");
		}
	}

	@Transactional
	public void eliminaResponsabile(RisultatoRicResponsabile responsabile, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::eliminaResponsabile] BEGIN");
		try {

			if (GenericUtil.isNotNullOrEmpty(responsabile.getIdImpResp()))
			{

				// devo cancellare la persona??????

				if (GenericUtil.isNullOrEmpty(responsabile.getIdPersona()))
				{

					// Sono in inserimento della persona
					if (responsabile.getIsImpresa().equalsIgnoreCase(Constants.LABEL_SI))
					{
						getSigitTPersonaGiuridicaDao().delete(new SigitTPersonaGiuridicaPk(ConvertUtil.convertToBigDecimal(responsabile.getIdPersona())));
					}
					else
					{
						getSigitTPersonaFisicaDao().delete(new SigitTPersonaFisicaPk(ConvertUtil.convertToBigDecimal(responsabile.getIdPersona())));
					}
				}

				getSigitRImpRuoloPfpgDao().delete(new SigitRImpRuoloPfpgPk(ConvertUtil.convertToBigDecimal(responsabile.getIdImpResp())));

				// Devo tracciare la cancellazione
				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_r_imp_ruolo_pfpg", "id_imp_ruolo_pfpg="+responsabile.getIdImpResp()));

			}

		}
		catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::eliminaResponsabile] END");
		}
	}

	/*
	public List<SigitTAllRespintoDto> getAllegatiRespintiImpianto(Integer codiceImpianto) throws ManagerException
	{
		log.debug("[DbMgr::getAllegatiRespintiImpianto] BEGIN");
		try {
			return getSigitTAllRespintoDao().findByCodImpianto(codiceImpianto);
		} catch (SigitTAllRespintoDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally{
			log.debug("[DbMgr::getAllegatiRespintiImpianto] END");
		}
	}
	*/

	public void eliminaImpianto(String codImpianto, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::eliminaImpianto] BEGIN");
		try {

			Integer codiceImpianto = ConvertUtil.convertToInteger(codImpianto);

			//getSigitTAllRespintoDao().customDeleterByCodImpianto(codiceImpianto);

			//elimina sigit_t_lib_txt - customDeleteByCodImpianto
			getSigitTLibTxtDao().customDeleterAllByCodImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			getSigitTLibrettoDao().customDeleterByCodImpianto(codiceImpianto);

//			getSigitRComp4ContrattoDao().customDeleterByCodImpianto(codiceImpianto);
//			getSigitTContrattoDao().customDeleterByCodImpianto(codiceImpianto);

			getSigitRImpRuoloPfpgDao().customDeleterByCodImpianto(codiceImpianto);

			getSigitTUnitaImmobiliareDao().customDeleterByCodImpianto(codiceImpianto);

			//cancellazione sigit_t_consumo/sigit_t_consumo_14_4
			getSigitTConsumoDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTConsumo144Dao().customDeleterByCodImpianto(codiceImpianto);
			//cancellazione sigit_t_storico_variaz_stato
			getSigitTStoricoVariazStatoDao().customDeleterByCodiceImpianto(codiceImpianto);

			getSigitTDocAggiuntivaDao().customDeleterByCodImpDel(codiceImpianto);

			getSigitTTrattH2oDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompXSempliceDao().customDeleterByCodImpianto(codiceImpianto);

			// Per cancellare getSigitTCompXDao
			getSigitTCompBrRcDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompSrDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompVxDao().customDeleterByCodImpianto(codiceImpianto);

			getSigitTCompVrDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompPoDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompAcDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompTeDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompRvDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompScxDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompCiDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompUtDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompRcDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompVmDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompXDao().customDeleterByCodImpianto(codiceImpianto);



			getSigitTCompGfDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompAgDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompCsDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompCgDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompScDao().customDeleterByCodImpianto(codiceImpianto);
			getSigittCompGtDao().customDeleterByCodImpianto(codiceImpianto);

			getSigitRComp4ManutDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTComp4Dao().customDeleterByCodImpianto(codiceImpianto);
			// Per adesso non eliminiamo il codice impianto dalla tabella sigit_t_import, in futuro valuteremo....

			getSigitTImportXmlLibDao().delete(new SigitTImportXmlLibPk(ConvertUtil.convertToBigDecimal(codiceImpianto)));

			getSigitTControlloLibrettoDao().delete(new SigitTControlloLibrettoPk(ConvertUtil.convertToBigDecimal(codiceImpianto)));

			getSigitTImpiantoDao().delete(new SigitTImpiantoPk(ConvertUtil.convertToBigDecimal(codiceImpianto)));

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_impianto", "codice_impianto="+codiceImpianto));

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::eliminaResponsabile] END");
		}
	}


	public void eliminaAllegato(BigDecimal idAllegato, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::eliminaAllegato] BEGIN");
		try {

			eliminaDettaglioAllegato(idAllegato);

			getSigitRComp4ManutAllDao().customDeleterByIdAllegato(idAllegato);

			List<SigitTImportDto> importList = getSigitTImportDao().findByIdAllegato(idAllegato);

			if (importList != null && importList.size() > 0)
			{
				Integer idImport = importList.get(0).getIdImport();
				getSigitTImpXmlDao().customDeleterByIdImport(idImport);

				getSigitTImportDao().delete(new SigitTImportPk(idImport));

			}

			getSigitTAllTxtDao().delete(new SigitTAllTxtPk(idAllegato));

			getSigitTConsumoTipo1BDao().customDeleterDeleteByIdAllegato(idAllegato);
			getSigitRAllegatoCompGtDao().customDeleterByIdAllegato(idAllegato);
			getSigitRAllegatoCompGfDao().customDeleterByIdAllegato(idAllegato);
			getSigitRAllegatoCompScDao().customDeleterByIdAllegato(idAllegato);
			getSigitRAllegatoCompCgDao().customDeleterByIdAllegato(idAllegato);

			getSigitTDocAllegatoDao().customDeleterByIdAllegatoDel(idAllegato);

			getSigitTAllegatoDao().delete(new SigitTAllegatoPk(idAllegato));

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::eliminaAllegato] END");
		}
	}

	/*
	public void annullaIspezioneGestAllegato(BigDecimal idAllegato, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::annullaIspezioneGestAllegato] BEGIN");
		try {

			respingiAllegato(idAllegato, cfUtenteMod);


			//eliminaDettaglioAllegato(idAllegato);

			//getSigitRComp4ManutAllDao().customDeleterByIdAllegato(idAllegato);

			//getSigitTAllTxtDao().delete(new SigitTAllTxtPk(idAllegato));

			//getSigitTAllegatoDao().delete(new SigitTAllegatoPk(idAllegato));

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::annullaIspezioneGestAllegato] END");
		}
	}
	*/

	public void respingiAllegato(BigDecimal idAllegato, String cfUtenteMod, String motivo) throws DbManagerException {
		log.debug("[DbMgr::respingiAllegato] BEGIN");
		try {

			// I dettagli non sono piu' da eliminare
			//eliminaDettaglioAllegato(idAllegato);

			//getSigitRComp4ManutAllDao().customDeleterByIdAllegato(idAllegato);

			// L'xml non e' piu' da eliminare
			//getSigitTAllTxtDao().delete(new SigitTAllTxtPk(idAllegato));

			SigitTAllegatoDto allegato = new SigitTAllegatoDto();
			allegato.setIdAllegato(idAllegato);
			allegato.setFkStatoRapp(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_RAPPORTO_RESPINTO));
			allegato.setFkSiglaBollino(null);
			allegato.setNomeAllegato(null);
			allegato.setDataRespinta(DateUtil.getSqlCurrentDate());
			allegato.setDataUltMod(DateUtil.getSqlDataCorrente());
			allegato.setUtenteUltMod(cfUtenteMod);
			allegato.setMotivoRespinta(GenericUtil.getStringSql(motivo));

			getSigitTAllegatoDao().updateColumnsRespingiAllegato(allegato);

			// Parte nuova
			getSigitTConsumoTipo1BDao().customDeleterDeleteByIdAllegato(idAllegato);
			getSigitTDettTipo1Dao().customDeleterByIdAllegato(idAllegato);
			getSigitTDettTipo2Dao().customDeleterByIdAllegato(idAllegato);
			getSigitTDettTipo3Dao().customDeleterByIdAllegato(idAllegato);
			getSigitTDettTipo4Dao().customDeleterByIdAllegato(idAllegato);

			getSigitTRappTipo1Dao().delete(new SigitTRappTipo1Pk(idAllegato));
			getSigitTRappTipo2Dao().delete(new SigitTRappTipo2Pk(idAllegato));
			getSigitTRappTipo3Dao().delete(new SigitTRappTipo3Pk(idAllegato));
			getSigitTRappTipo4Dao().delete(new SigitTRappTipo4Pk(idAllegato));

			getSigitRAllegatoCompGtDao().customDeleterByIdAllegato(idAllegato);
			getSigitRAllegatoCompGfDao().customDeleterByIdAllegato(idAllegato);
			getSigitRAllegatoCompScDao().customDeleterByIdAllegato(idAllegato);
			getSigitRAllegatoCompCgDao().customDeleterByIdAllegato(idAllegato);
			//getSigitTAllegatoDao().delete(new SigitTAllegatoPk(idAllegato));

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::respingiAllegato] END");
		}
	}

	public void respingiManutenzione(BigDecimal idAllegato, String cfUtenteMod, String motivo) throws DbManagerException {
		log.debug("[DbMgr::respingiAllegato] BEGIN");
		try {

			// I dettagli non sono piu' da eliminare
			//eliminaDettaglioAllegato(idAllegato);

			//getSigitRComp4ManutAllDao().customDeleterByIdAllegato(idAllegato);

			// L'xml non e' piu' da eliminare
			//getSigitTAllTxtDao().delete(new SigitTAllTxtPk(idAllegato));

			SigitTAllegatoDto allegato = new SigitTAllegatoDto();
			allegato.setIdAllegato(idAllegato);
			allegato.setFkStatoRapp(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_RAPPORTO_RESPINTO));
			allegato.setFkSiglaBollino(null);
			allegato.setNomeAllegato(null);
			allegato.setDataRespinta(DateUtil.getSqlCurrentDate());
			allegato.setDataUltMod(DateUtil.getSqlDataCorrente());
			allegato.setUtenteUltMod(cfUtenteMod);
			allegato.setMotivoRespinta(GenericUtil.getStringSql(motivo));

			getSigitTAllegatoDao().updateColumnsRespingiAllegato(allegato);

			getSigitRAllegatoCompGtDao().customDeleterByIdAllegato(idAllegato);
			getSigitRAllegatoCompGfDao().customDeleterByIdAllegato(idAllegato);
			getSigitRAllegatoCompScDao().customDeleterByIdAllegato(idAllegato);
			getSigitRAllegatoCompCgDao().customDeleterByIdAllegato(idAllegato);

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::respingiAllegato] END");
		}
	}

	public void eliminaDettaglioAllegato(BigDecimal idAllegato) throws DbManagerException {
		log.debug("[DbMgr::eliminaDettaglioAllegato] BEGIN");
		try {


			getSigitTRappDettaglioDao().customDeleterByIdAllegato(idAllegato);

			getSigitTDettTipo1Dao().customDeleterByIdAllegato(idAllegato);
			getSigitTDettTipo2Dao().customDeleterByIdAllegato(idAllegato);
			getSigitTDettTipo3Dao().customDeleterByIdAllegato(idAllegato);
			getSigitTDettTipo4Dao().customDeleterByIdAllegato(idAllegato);

			getSigitTConsumoTipo1BDao().customDeleterDeleteByIdAllegato(idAllegato);
			getSigitTRappControlloDao().customDeleterByIdAllegato(idAllegato);
			getSigitTRappTipo1Dao().delete(new SigitTRappTipo1Pk(idAllegato));
			getSigitTRappTipo2Dao().delete(new SigitTRappTipo2Pk(idAllegato));
			getSigitTRappTipo3Dao().delete(new SigitTRappTipo3Pk(idAllegato));
			getSigitTRappTipo4Dao().delete(new SigitTRappTipo4Pk(idAllegato));


		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::eliminaDettaglioAllegato] END");
		}
	}

//
//	public void eliminaIspezione(BigDecimal idIspezione, String cfUtenteMod) throws DbManagerException {
//		log.debug("[DbMgr::eliminaIspezione] BEGIN");
//		try {
//
//			getSigitTDocAggiuntivaDao().customDeleterByIdIspezione(idIspezione);
//			getSigitTIspezioneDao().delete(new SigitTIspezionePk(idIspezione));
//			getSigitRImpRuoloPfpgDao().delete(new SigitRImpRuoloPfpgPk(idIspezione));
//			salvaLog("sigit_t_ispezione", "id_imp_ruolo_pfpg = "+idIspezione, cfUtenteMod);
//		}
//		catch(Exception e) {
//
//			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
//		}
//		finally {
//			log.debug("[DbMgr::eliminaIspezione] END");
//		}
//	}



	public void salvaLogEliminaAllegato(String idAllegato, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaLogEliminaAllegato] BEGIN");
		try {

			salvaLog("sigit_t_allegato", "id_allegato = "+idAllegato, cfUtenteMod);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLogEliminaAllegato] END");
		}
	}

	public void salvaLog(String nomeTabella, String idRecord, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaLog] BEGIN");
		try {

			// Devo tracciare l'operazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, nomeTabella, idRecord));

		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLog] END");
		}
	}

	/*
	@Transactional
	public void salvaAcquisizioneCodiciTrans(AcquisizioneCodici acquisizioneCodici, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaAcquisizioneCodiciTrans] BEGIN");
		try {

			salvaAcquisizioneCodici(acquisizioneCodici, cfUtenteMod);

		}
		catch(DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw e;
		}
		finally {
			log.debug("[DbMgr::salvaAcquisizioneCodiciTrans] END");
		}
	}
	*/

	/*
	public void salvaAcquisizioneCodici(AcquisizioneCodici acquisizioneCodici, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaAcquisizioneCodici] BEGIN");
		try {

			int codImpTot = acquisizioneCodici.getQuantita();
			Integer codImpInizio = -1;
			Integer codImpFine = 0;

			// Inserisco la transazione
			SigitTTransazioneImpDto transazioneDto = MapDto.mapToSigitTtransazioneImpDto(acquisizioneCodici, cfUtenteMod);
			SigitTTransazioneImpPk transazionePk = getSigitTTransazioneImpDao().insert(transazioneDto);

			SigitTCodiceImpDto codiceImpDto = null;
			SigitTCodiceImpPk codiceImpPk = null;
			// Ciclo per inserire i codici impianto
			for (int i = 0; i < codImpTot; i++) {

				codiceImpDto = new SigitTCodiceImpDto();
				codiceImpDto.setFkTransazione(transazionePk.getIdTransazione());
				codiceImpDto.setFlgPregresso(ConvertUtil.convertToBigDecimal(Constants.NO_0));

				codiceImpPk = getSigitTCodiceImpDao().insert(codiceImpDto);

				if (codImpInizio < 0)
				{
					codImpInizio = ConvertUtil.convertToInteger(codiceImpPk.getCodiceImpianto());
				}

				codImpFine = ConvertUtil.convertToInteger(codiceImpPk.getCodiceImpianto());

			}

			transazioneDto.setImpiantoDa(ConvertUtil.convertToBigDecimal(codImpInizio));
			transazioneDto.setImpiantoA(ConvertUtil.convertToBigDecimal(codImpFine));

			getSigitTTransazioneImpDao().update(transazioneDto);

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaAcquisizioneCodici] END");
		}
	}
	*/

	/*
	@Transactional
	public void salvaTransazioneTrans(AcquistoBollini acquistoBoll, ArrayList<AcquistoBolliniQuantita> acquistoBollList, TransazioneApp transazioneApp, UtenteLoggato utenteLoggato) throws DbManagerException {
		log.debug("[DbMgr::salvaTransazioneTrans] BEGIN");
		try {

			salvaTransazione(acquistoBoll, acquistoBollList, transazioneApp, utenteLoggato);
		}
		catch(DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
		finally {
			log.debug("[DbMgr::salvaTransazioneTrans] END");
		}
	}
	*/

	/*
	public void salvaTransazione(AcquistoBollini acquistoBoll, ArrayList<AcquistoBolliniQuantita> acquistoBollList, TransazioneApp transazioneApp, UtenteLoggato utenteLoggato) throws DbManagerException {
		log.debug("[DbMgr::salvaTransazione] BEGIN");
		try {


			SigitTTransazioneBollPk transazioneBollPk = getSigitTTransazioneBollDao().insert(MapDto.mapToSigitTTransazioneBollDto(acquistoBoll, transazioneApp, utenteLoggato));

			Long idTransazione = ConvertUtil.convertToLong(transazioneBollPk.getIdTransazioneBoll());

			for (AcquistoBolliniQuantita acqBolliniQta : acquistoBollList) {

				if (acqBolliniQta.getQuantita() != null && acqBolliniQta.getQuantita() > 0)
				{
					SigitRTransAcqBollQtaDto transAcqBollQtaDto = MapDto.mapToSigitRTransAcqBollQtaDto(idTransazione, acqBolliniQta, utenteLoggato);

					getSigitRTransAcqBollQtaDao().insert(transAcqBollQtaDto);
					//transAcqBollQtaDto.setIdTransazioneBoll(val)


					if (transazioneApp == null)
					{
						// Vuol dire che sono gratuiti, quindi inserisco subito il SIGIT_T_CODICE_BOLLINO
						salvaCodiceBolliniOLD(transAcqBollQtaDto,acquistoBoll);
					}
				}
			}

			if (transazioneApp == null)
			{
//				transazioneBollDto.setBollinoDa(ConvertUtil.convertToBigDecimal(codBollInizio));
//				transazioneBollDto.setBollinoA(ConvertUtil.convertToBigDecimal(codBollFine));

				// devo recuperare il primo codice bollino e l'ultimo (della transazione)
				Long codBollInizio = null;
				Long codBollFine = new Long(0);
				List<SigitTCodiceBollDto> codiceBollList = getSigitTCodiceBollDao().findByIdTransazioneBoll(idTransazione);
				for (SigitTCodiceBollDto sigitTCodiceBollDto : codiceBollList) {

					if (codBollInizio == null)
					{
						codBollInizio = ConvertUtil.convertToLong(sigitTCodiceBollDto.getNumeroBollino());
					}

					codBollFine = ConvertUtil.convertToLong(sigitTCodiceBollDto.getNumeroBollino());
				}

				aggiornaStatoTransazioneBollOK(idTransazione, codBollInizio, codBollFine, utenteLoggato.getCodiceFiscale());
//				/getSigitTTransazioneBollDao().update(transazioneBollDto);

			}

			// Aggiorno lo stato con il codice OK
			//aggiornaStatoTransazione(idTransazione, Constants.TRANSAZIONE_MDP_OK, utenteLoggato);

			acquistoBoll.setIdTransazione(idTransazione);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaTransazione] END");
		}
	}
	*/

	/*
	public void aggiornaStatoTransazioneBollOK(Long idtransazione, Long numBollinoDa, Long numBollinoA, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::aggiornaStatoTransazioneBoll] BEGIN");
		try {

			SigitTTransazioneBollDto dto = new SigitTTransazioneBollDto();
			dto.setIdTransazioneBoll(ConvertUtil.convertToBigDecimal(idtransazione));
			dto.setIdStatoTransazione(ConvertUtil.convertToBigDecimal(Constants.TRANSAZIONE_MDP_OK));

			dto.setBollinoDa(ConvertUtil.convertToBigDecimal(numBollinoDa));
			dto.setBollinoA(ConvertUtil.convertToBigDecimal(numBollinoA));

			dto.setUtenteUltMod(cfUtenteMod);
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());

			getSigitTTransazioneBollDao().updateColumnsStatoTransazione(dto);
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::aggiornaStatoTransazioneBoll] END");
		}
	}

	public void aggiornaStatoTransazioneBoll(Long idtransazione, int newStatoTransazione, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::aggiornaStatoTransazioneBoll] BEGIN");
		try {

			SigitTTransazioneBollDto dto = new SigitTTransazioneBollDto();
			dto.setIdTransazioneBoll(ConvertUtil.convertToBigDecimal(idtransazione));
			dto.setIdStatoTransazione(ConvertUtil.convertToBigDecimal(newStatoTransazione));

			dto.setUtenteUltMod(cfUtenteMod);
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());

			getSigitTTransazioneBollDao().updateColumnsStatoTransazione(dto);

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::aggiornaStatoTransazioneBoll] END");
		}
	}

	public TransazioneBollini cercaStatoTransazioneDB(String numTransazione) throws DbManagerException {
		log.debug("[DbMgr::cercaStatoTransazione] BEGIN");

		TransazioneBollini transazioneBollini = null;

		try {

			List<SigitTTransazioneBollDto> dtolList = getSigitTTransazioneBollDao().findByNumTransazione(numTransazione);;

			if (dtolList != null && dtolList.size()  > 0)
			{
				// Sicuramente c'e' un solo risultato
				transazioneBollini = MapDto.mapToTransazioneBollini(dtolList.get(0));
			}
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaStatoTransazione] END");
		}
		return transazioneBollini;
	}
	*/
	/*
	@Transactional
	public void completaAcquistoBollini(Long idTransazione, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::completaAcquistoBollini] BEGIN");

		try {

			// Ritorna quante righe quante le potenze che sono state acquistate
			List<SigitRTransAcqBollQtaDto> transAcqBollDtoList = getSigitRTransAcqBollQtaDao().findByIdTransazioneBoll(idTransazione);

			for (SigitRTransAcqBollQtaDto sigitRTransAcqBollQtaDto : transAcqBollDtoList) {

				salvaCodiceBolliniOLD(sigitRTransAcqBollQtaDto,null);

			}

			// devo recuperare il primo codice bollino e l'ultimo (della transazione)
			Long codBollInizio = null;
			Long codBollFine = new Long(0);
			List<SigitTCodiceBollDto> codiceBollList = getSigitTCodiceBollDao().findByIdTransazioneBoll(idTransazione);
			for (SigitTCodiceBollDto sigitTCodiceBollDto : codiceBollList) {

				if (codBollInizio == null)
				{
					codBollInizio = ConvertUtil.convertToLong(sigitTCodiceBollDto.getNumeroBollino());
				}

				codBollFine = ConvertUtil.convertToLong(sigitTCodiceBollDto.getNumeroBollino());
			}


			// Aggiorno lo stato con il codice OK e passo da - a
			aggiornaStatoTransazioneBollOK(idTransazione, codBollInizio, codBollFine, cfUtenteMod);

		}
		catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::completaAcquistoBollini] END");
		}
	}
	*/

	/*
	public void salvaCodiceBolliniOLD(SigitRTransAcqBollQtaDto sigitRTransAcqBollQtaDto, AcquistoBollini acquistoBollino) throws DbManagerException {
		log.debug("[DbMgr::salvaCodiceBollini] BEGIN");


		try {

			// Ritorna quante righe quante le potenze che sono state acquistate

			SigitTCodiceBollDto codiceBollDto = null;

			int numBolliniPerPotenza = sigitRTransAcqBollQtaDto.getQuantita().intValue();
			for (int i = 0; i < numBolliniPerPotenza; i++) {

				BigDecimal numBollino = getSigitExtDao().getSeqTNumeroBollino();

				codiceBollDto = new SigitTCodiceBollDto();

				//codiceBollDto.setSiglaBollino(Constants.SIGLA_BOLLINO_RP); modificata logica

				//si e' pensato di farlo arrivare dal client, poiche' questo metodo e' utilizzato da due
				//direzioni differenti ho aggiunto l'else per gestire il secondo caso quando non ho l'oggetto aquista bollini
				log.debug("FRAAAAAAAAA SALVA CODICI BOLLINI SIGLA BOLLINO: "+acquistoBollino.getSiglaBollino());
				if(acquistoBollino!=null && acquistoBollino.getSiglaBollino()!=null)
					codiceBollDto.setSiglaBollino(acquistoBollino.getSiglaBollino());
				else{
					codiceBollDto.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
				}

				codiceBollDto.setNumeroBollino(numBollino);
				codiceBollDto.setFkTransazioneBoll(sigitRTransAcqBollQtaDto.getIdTransazioneBoll());

				log.debug("FRAAAAAAAAAAAAAAAAAA ---> ID TRANSAZIONE: "+sigitRTransAcqBollQtaDto.getIdTransazioneBoll());

				codiceBollDto.setFkTransazioneBoll(sigitRTransAcqBollQtaDto.getIdTransazioneBoll());
				codiceBollDto.setFkPotenza(sigitRTransAcqBollQtaDto.getIdPotenza());
				codiceBollDto.setFkPrezzo(sigitRTransAcqBollQtaDto.getIdPrezzo());
				codiceBollDto.setFkDtInizioAcquisto(sigitRTransAcqBollQtaDto.getDtInizioAcquisto());
				codiceBollDto.setFlgPregresso(ConvertUtil.convertToBigDecimal(Constants.NO_0));

				getSigitTCodiceBollDao().insert(codiceBollDto);

			}


		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaCodiceBollini] END");
		}

	}
	*/

	public BigDecimal salvaCodiceBollino() throws DbManagerException {
		log.debug("[DbMgr::salvaCodiceBollino] BEGIN");


		try {

			BigDecimal numBollino = getSigitExtDao().getSeqTNumeroBollino();

			// Ritorna quante righe quante le potenze che sono state acquistate
			SigitTCodiceBollDto codiceBollDto = new SigitTCodiceBollDto();

//			if(acquistoBollino!=null && acquistoBollino.getSiglaBollino()!=null)
//				codiceBollDto.setSiglaBollino(acquistoBollino.getSiglaBollino());
//			else{
//				codiceBollDto.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
//			}

			codiceBollDto.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
			codiceBollDto.setNumeroBollino(numBollino);
			codiceBollDto.setDtInserimento(DateUtil.getSqlDataCorrente());

			getSigitTCodiceBollDao().insert(codiceBollDto);

			return numBollino;
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaCodiceBollino] END");
		}

	}

//	public void aggiornaStatoIspezione(Integer idIspezione, int idStatoIspezione, String cfUtenteMod) throws DbManagerException {
//		log.debug("[DbMgr::aggiornaStatoIspezione] BEGIN");
//		try {
//
//			SigitTIspezioneDto dto = new SigitTIspezioneDto();
//			dto.setIdImpRuoloPfpg(ConvertUtil.convertToBigDecimal(idIspezione));
//			dto.setFkStatoIspezione(ConvertUtil.convertToBigDecimal(idStatoIspezione));
//			dto.setUtenteUltMod(cfUtenteMod);
//			dto.setDataUltMod(DateUtil.getSqlDataCorrente());
//
//			getSigitTIspezioneDao().updateColumnsStato(dto);
//
//		}
//		catch(Exception e) {
//
//			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
//		}
//		finally {
//			log.debug("[DbMgr::aggiornaStatoIspezione] END");
//		}
//	}

	public List<SigitTIspezione2018Dto> cercaIspezione2018(SigitTIspezione2018Dto ispezione) throws DbManagerException {
		log.debug("[DbMgr::cercaIspezione2018] BEGIN");
		List<SigitTIspezione2018Dto> output = null;
		try {
			output = getSigitTIspezione2018Dao().findByExample(ispezione);
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaIspezione2018] END");
		}

		return output;
	}

	public SigitTSanzioneDto cercaSanzioneDaId(Integer idSanzione) throws DbManagerException {
		log.debug("[DbMgr::cercaSanzioneDaId] BEGIN");
		SigitTSanzioneDto output = null;
		try {
			output = getSigitTSanzioneDao().findByPrimaryKey(new SigitTSanzionePk(idSanzione));
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaSanzioneDaId] END");
		}

		return output;
	}

	public List<SigitTSanzioneDto> cercaSanzione(SigitTSanzioneDto sanzione) throws DbManagerException {
		log.debug("[DbMgr::cercaSanzione] BEGIN");
		List<SigitTSanzioneDto> output = null;
		try {
			output = getSigitTSanzioneDao().findByExample(sanzione);
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSanzione] END");
		}

		return output;
	}

	public List<SigitTIspezione2018Dto> cercaIspezione2018ValidaByIdAccertamento(Integer idAccertamento) throws DbManagerException {
		log.debug("[DbMgr::cercaIspezione2018ValidaByIdAccertamento] BEGIN");
		List<SigitTIspezione2018Dto> output = null;
		try {
			output = getSigitTIspezione2018Dao().findValidaByIdAccertamento(idAccertamento);
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaIspezione2018ValidaByIdAccertamento] END");
		}

		return output;
	}


	public List<SigitTIspezione2018Dto> cercaIspezione2018BozzaByIdAccertamento(Integer idAccertamento) throws DbManagerException {
		log.debug("[DbMgr::cercaIspezione2018BozzaByIdAccertamento] BEGIN");
		List<SigitTIspezione2018Dto> output = null;
		try {
			output = getSigitTIspezione2018Dao().findBozzaByIdAccertamento(idAccertamento);
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaIspezione2018BozzaByIdAccertamento] END");
		}

		return output;
	}

	public List<SigitTSanzioneDto> cercaSanzioneValidaByIdAccertamento(Integer idAccertamento) throws DbManagerException {
		log.debug("[DbMgr::cercaSanzioneValidaByIdAccertamento] BEGIN");
		List<SigitTSanzioneDto> output = null;
		try {
			output = getSigitTSanzioneDao().findValidaByIdAccertamento(idAccertamento);
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSanzioneValidaByIdAccertamento] END");
		}

		return output;
	}

	public List<SigitTSanzioneDto> cercaSanzioneValidaByIdIspezione(Integer idIspezione) throws DbManagerException {
		log.debug("[DbMgr::cercaSanzioneValidaByIdIspezione] BEGIN");
		List<SigitTSanzioneDto> output = null;
		try {
			output = getSigitTSanzioneDao().findValidaByIdIspezione(idIspezione);
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSanzioneValidaByIdIspezione] END");
		}

		return output;
	}


	public List<SigitTAccertamentoDto> cercaAccertamento(SigitTAccertamentoDto accertamento) throws DbManagerException {
		log.debug("[DbMgr::cercaAccertamento] BEGIN");
		List<SigitTAccertamentoDto> output = null;
		try {
			output = getSigitTAccertamentoDao().findByExample(accertamento);
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaAccertamento] END");
		}

		return output;
	}




	/*
	public void annullaAllegatoIspezione(Integer idAllegato, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::aggiornaStatoAllegatoIspezione] BEGIN");
		try {

			SigitTAllegatoDto allegato = cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(idAllegato));

			//salvaAllegatoRespinto(MapDto.mapToSigittAllRespinto(allegato, cfUtenteMod));

			//SigitTAllTxtDto fileAllegato = cercaSigitTAllTxtById(ConvertUtil.convertToBigDecimal(idAllegato));

			//salvaFileAllegatoRespinto(MapDto.mapToSigitAllRespTxt(fileAllegato, allegato));

			annullaIspezioneGestAllegato(ConvertUtil.convertToBigDecimal(idAllegato), cfUtenteMod);

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::aggiornaStatoAllegatoIspezione] END");
		}
	}

	*/
	public void salvaLibretto(SigitTLibrettoDto dto, byte[] datiXml) throws DbManagerException {
		log.debug("[DbMgr::salvaLibretto] BEGIN");
		try {
			//se esiste gia', fare update, altrimenti insert
			Impianto impianto = cercaImpiantoById(dto.getCodiceImpianto().toString());
			String datiXmlSt = XmlBeanUtils.readByteArray(datiXml);
			List<SigitTLibrettoDto> librettoList = cercaLibrettoByStato(impianto.getImpCodImpianto(), Constants.ID_STATO_LIBRETTO_BOZZA);
			if (librettoList != null && librettoList.size() > 0)
			{
				if (librettoList.size() == 1)
				{
					BigDecimal idLibretto = librettoList.get(0).getIdLibretto();
					log.debug("trovato libretto in stato bozza: " + idLibretto);
					dto.setIdLibretto(idLibretto);
					getSigitTLibrettoDao().update(dto);
					updateTxtLibretto(idLibretto, datiXmlSt);
				}
				else
				{
					log.error("trovati piu' di un libretto in stato bozza");
					throw new ServiceException(Messages.ERROR_RECUPERO_SERVIZIO);
				}
			}
			else
			{
				log.debug("NON trovato libretto in stato bozza. Inserisco libretto nuovo ");
				getSigitTLibrettoDao().insert(dto);
				insertTxtLibretto(dto.getIdLibretto(), datiXmlSt);
			}
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLibretto] END");
		}
	}

	public void salvaLibrettoLight(SigitTLibrettoDto dto, String xmlDati) throws DbManagerException {
		log.debug("[DbMgr::salvaLibretto] BEGIN");
		try {
			//se esiste gia', fare update, altrimenti insert
			Impianto impianto = cercaImpiantoById(dto.getCodiceImpianto().toString());
			List<SigitTLibrettoDto> librettoList = cercaLibrettoByStato(impianto.getImpCodImpianto(), Constants.ID_STATO_LIBRETTO_BOZZA);
			if (librettoList != null && librettoList.size() > 0)
			{
				if (librettoList.size() == 1)
				{
					BigDecimal idLibretto = librettoList.get(0).getIdLibretto();
					log.debug("trovato libretto in stato bozza: " + idLibretto);
					dto.setIdLibretto(idLibretto);
					getSigitTLibrettoDao().update(dto);
				}
				else
				{
					log.error("trovati piu' di un libretto in stato bozza");
					throw new ServiceException(Messages.ERROR_RECUPERO_SERVIZIO);
				}
			}

			getSigitTLibrettoDao().insert(dto);
			insertTxtLibretto(dto.getIdLibretto(), xmlDati);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLibretto] END");
		}
	}

	/*
	public void salvaLibrettoWeb(SigitTLibrettoDto dto) throws DbManagerException {
		log.debug("[DbMgr::salvaLibrettoWeb] BEGIN");
		try {
			//se esiste gia', fare update, altrimenti insert
			Impianto impianto = cercaImpiantoById(dto.getCodiceImpianto().toString());
			List<SigitTLibrettoDto> librettoList = cercaLibrettoByStato(impianto.getImpCodImpianto(), Constants.ID_STATO_LIBRETTO_BOZZA);
			if (librettoList != null && librettoList.size() > 0)
			{
				if (librettoList.size() == 1)
				{
					BigDecimal idLibretto = librettoList.get(0).getIdLibretto();
					log.debug("trovato libretto in stato bozza: " + idLibretto);
					dto.setIdLibretto(idLibretto);
					getSigitTLibrettoDao().update(dto);
				}
				else
				{
					log.error("trovati piu' di un libretto in stato bozza");
					throw new ServiceException(Messages.ERROR_RECUPERO_SERVIZIO);
				}
			}

			getSigitTLibrettoDao().insert(dto);
			//insertTxtLibretto(dto.getIdLibretto(), xmlDati);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLibrettoWeb] END");
		}
	}
	*/

	public void inserisciLibretto(SigitTLibrettoDto dto) throws DbManagerException {
		log.debug("[DbMgr::inserisciLibretto] BEGIN");
		try {
			getSigitTLibrettoDao().insert(dto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciLibretto] END");
		}
	}

	public void inserisciDelega(Integer idPersonaG, String idPersonaF, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::inserisciDelega] BEGIN");
		try {

			SigitRPfPgDelegaDto delegatoDto = new SigitRPfPgDelegaDto();
			delegatoDto.setIdPersonaGiuridica(ConvertUtil.convertToBigDecimal(idPersonaG));
			delegatoDto.setIdPersonaFisica(ConvertUtil.convertToBigDecimal(idPersonaF));
			delegatoDto.setDataInizio(DateUtil.getSqlCurrentDate());
			delegatoDto.setFlgDelega(Constants.FLAG_ACCREDITATO_D);
			delegatoDto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
			delegatoDto.setDataUltMod(DateUtil.getSqlDataCorrente());

			getSigitRPfPgDelegaDao().insert(delegatoDto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciDelega] END");
		}
	}

	public void inserisciIncarico(Integer idPersonaGImp, String idPersonaGCat, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::inserisciIncarico] BEGIN");
		try {

			SigitRPgPgNominaDto delegatoDto = new SigitRPgPgNominaDto();
			delegatoDto.setIdPersonaGiuridicaCat(ConvertUtil.convertToBigDecimal(idPersonaGCat));
			delegatoDto.setIdPersonaGiuridicaImpresa(ConvertUtil.convertToBigDecimal(idPersonaGImp));
			delegatoDto.setDataInizio(DateUtil.getSqlCurrentDate());
			delegatoDto.setUtenteUltimaModifica(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
			delegatoDto.setDataUltimaModifica(DateUtil.getSqlCurrentDate());

			getSigitRPgPgNominaDao().insert(delegatoDto); 
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciIncarico] END");
		}
	}

	public BigDecimal inserisciAllegato(SigitTAllegatoDto dto) throws DbManagerException {
		log.debug("[DbMgr::inserisciAllegato] BEGIN");
		try {
			  return getSigitTAllegatoDao().insert(dto).getIdAllegato();
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciAllegato] END");
		}
	}



	public SigitTDocAggiuntivaPk inserisciTDocAggiuntiva(SigitTDocAggiuntivaDto dto) throws DbManagerException {
		log.debug("[DbMgr::inserisciTDocAggiuntiva] BEGIN");
		try {
			  return getSigitTDocAggiuntivaDao().insert(dto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciTDocAggiuntiva] END");
		}
	}

	public void aggiornaTDocAggiuntiva(SigitTDocAggiuntivaDto dto) throws DbManagerException {
		log.debug("[DbMgr::aggiornaTDocAggiuntiva] BEGIN");
		try {
			  getSigitTDocAggiuntivaDao().updateColumnsAggiornaNomeUid(dto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::aggiornaTDocAggiuntiva] END");
		}
	}

	public SigitTDocAllegatoPk inserisciTDocAllegato(SigitTDocAllegatoDto dto) throws DbManagerException {
		log.debug("[DbMgr::inserisciTDocAllegato] BEGIN");
		try {
			  return getSigitTDocAllegatoDao().insert(dto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciTDocAllegato] END");
		}
	}

	public void aggiornaTDocAllegato(SigitTDocAllegatoDto dto) throws DbManagerException {
		log.debug("[DbMgr::aggiornaTDocAllegato] BEGIN");
		try {
			  getSigitTDocAllegatoDao().updateColumnsAggiornaNomeUid(dto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::aggiornaTDocAllegato] END");
		}
	}

	public void inserisciTRappIspezGt(BigDecimal idAllegato, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::inserisciTRappIspezGt] BEGIN");
		try {
			SigitTRappIspezGtDto dtoR = new SigitTRappIspezGtDto();
			dtoR.setIdAllegato(idAllegato);
			dtoR.setUtenteUltMod(cfUtenteMod);
			dtoR.setDataUltMod(DateUtil.getSqlDataCorrente());

			getSigitTRappIspezGtDao().insert(dtoR);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciTRappIspezGt] END");
		}
	}

	public void inserisciTRappIspezGf(BigDecimal idAllegato, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::inserisciTRappIspezGf] BEGIN");
		try {
			SigitTRappIspezGfDto dtoR = new SigitTRappIspezGfDto();
			dtoR.setIdAllegato(idAllegato);
			dtoR.setUtenteUltMod(cfUtenteMod);
			dtoR.setDataUltMod(DateUtil.getSqlDataCorrente());

			getSigitTRappIspezGfDao().insert(dtoR);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciTRappIspezGf] END");
		}
	}


	public void inserisciRAllegatoCompGt(BigDecimal idAllegato, SigitVSk4GtDto dtoT) throws DbManagerException {
		log.debug("[DbMgr::inserisciRAllegatoCompGt] BEGIN");
		try {
			SigitRAllegatoCompGtDto dtoR = new SigitRAllegatoCompGtDto();
			dtoR.setIdAllegato(idAllegato);
			dtoR.setIdTipoComponente(dtoT.getIdTipoComponente());
			dtoR.setProgressivo(dtoT.getProgressivo());
			dtoR.setCodiceImpianto(dtoT.getCodiceImpianto());
			dtoR.setDataInstall(dtoT.getDataInstall());

			getSigitRAllegatoCompGtDao().insert(dtoR);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciRAllegatoCompGt] END");
		}
	}

	public void inserisciRAllegatoCompGtManut(BigDecimal idAllegato, SigitVSk4GtDto dtoT, BigDecimal idImpRuoloPfPg, BigDecimal idContratto) throws DbManagerException {
		log.debug("[DbMgr::inserisciRAllegatoCompGtManut] BEGIN");
		try {
			SigitRAllegatoCompGtDto dtoR = new SigitRAllegatoCompGtDto();
			dtoR.setIdAllegato(idAllegato);
			dtoR.setIdTipoComponente(ReplaceSpecialCharUtils.sanitize(dtoT.getIdTipoComponente()));
			dtoR.setProgressivo(dtoT.getProgressivo());
			dtoR.setCodiceImpianto(dtoT.getCodiceImpianto());
			dtoR.setDataInstall(dtoT.getDataInstall());

			if (idImpRuoloPfPg != null)
				dtoR.setFkImpRuoloPfpg(idImpRuoloPfPg);

			if (idContratto != null)
				dtoR.setFkContratto(idContratto);

			getSigitRAllegatoCompGtDao().insert(dtoR);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciRAllegatoCompGtManut] END");
		}

	}

	public void inserisciRAllegatoCompGf(BigDecimal idAllegato, SigitVSk4GfDto dtoT) throws DbManagerException {
		log.debug("[DbMgr::inserisciRAllegatoCompGf] BEGIN");
		try {
			SigitRAllegatoCompGfDto dtoR = new SigitRAllegatoCompGfDto();
			dtoR.setIdAllegato(idAllegato);
			dtoR.setIdTipoComponente(dtoT.getIdTipoComponente());
			dtoR.setProgressivo(dtoT.getProgressivo());
			dtoR.setCodiceImpianto(dtoT.getCodiceImpianto());
			dtoR.setDataInstall(dtoT.getDataInstall());

			getSigitRAllegatoCompGfDao().insert(dtoR);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciRAllegatoCompGf] END");
		}
	}

	public void inserisciRAllegatoCompGfManut(BigDecimal idAllegato, SigitVSk4GfDto dtoT, BigDecimal idImpRuoloPfPg, BigDecimal idContratto) throws DbManagerException {
		log.debug("[DbMgr::inserisciRAllegatoCompGfManut] BEGIN");
		try {
			SigitRAllegatoCompGfDto dtoR = new SigitRAllegatoCompGfDto();
			dtoR.setIdAllegato(idAllegato);
			dtoR.setIdTipoComponente(ReplaceSpecialCharUtils.sanitize(dtoT.getIdTipoComponente()));
			dtoR.setProgressivo(dtoT.getProgressivo());
			dtoR.setCodiceImpianto(dtoT.getCodiceImpianto());
			dtoR.setDataInstall(dtoT.getDataInstall());

			if (idImpRuoloPfPg != null)
				dtoR.setFkImpRuoloPfpg(idImpRuoloPfPg);

			if (idContratto != null)
				dtoR.setFkContratto(idContratto);

			getSigitRAllegatoCompGfDao().insert(dtoR);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciRAllegatoCompGfManut] END");
		}
	}

	public void inserisciRAllegatoCompSc(BigDecimal idAllegato, SigitVSk4ScDto dtoT) throws DbManagerException {
		log.debug("[DbMgr::inserisciRAllegatoCompSc] BEGIN");
		try {
			SigitRAllegatoCompScDto dtoR = new SigitRAllegatoCompScDto();
			dtoR.setIdAllegato(idAllegato);
			dtoR.setIdTipoComponente(dtoT.getIdTipoComponente());
			dtoR.setProgressivo(dtoT.getProgressivo());
			dtoR.setCodiceImpianto(dtoT.getCodiceImpianto());
			dtoR.setDataInstall(dtoT.getDataInstall());

			getSigitRAllegatoCompScDao().insert(dtoR);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciRAllegatoCompSc] END");
		}
	}

	public void inserisciRAllegatoCompScManut(BigDecimal idAllegato, SigitVSk4ScDto dtoT, BigDecimal idImpRuoloPfPg, BigDecimal idContratto) throws DbManagerException {
		log.debug("[DbMgr::inserisciRAllegatoCompScManut] BEGIN");
		try {
			SigitRAllegatoCompScDto dtoR = new SigitRAllegatoCompScDto();
			dtoR.setIdAllegato(idAllegato);
			dtoR.setIdTipoComponente(ReplaceSpecialCharUtils.sanitize(dtoT.getIdTipoComponente()));
			dtoR.setProgressivo(dtoT.getProgressivo());
			dtoR.setCodiceImpianto(dtoT.getCodiceImpianto());
			dtoR.setDataInstall(dtoT.getDataInstall());

			if (idImpRuoloPfPg != null)
				dtoR.setFkImpRuoloPfpg(idImpRuoloPfPg);

			if (idContratto != null)
				dtoR.setFkContratto(idContratto);

			getSigitRAllegatoCompScDao().insert(dtoR);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciRAllegatoCompScManut] END");
		}
	}

	public void inserisciRAllegatoCompCg(BigDecimal idAllegato, SigitVSk4CgDto dtoT) throws DbManagerException {
		log.debug("[DbMgr::inserisciRAllegatoCompCg] BEGIN");
		try {
			SigitRAllegatoCompCgDto dtoR = new SigitRAllegatoCompCgDto();
			dtoR.setIdAllegato(idAllegato);
			dtoR.setIdTipoComponente(dtoT.getIdTipoComponente());
			dtoR.setProgressivo(dtoT.getProgressivo());
			dtoR.setCodiceImpianto(dtoT.getCodiceImpianto());
			dtoR.setDataInstall(dtoT.getDataInstall());

			getSigitRAllegatoCompCgDao().insert(dtoR);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciRAllegatoCompCg] END");
		}
	}

	public void inserisciRAllegatoCompCgManut(BigDecimal idAllegato, SigitVSk4CgDto dtoT, BigDecimal idImpRuoloPfPg, BigDecimal idContratto) throws DbManagerException {
		log.debug("[DbMgr::inserisciRAllegatoCompCgManut] BEGIN");
		try {
			SigitRAllegatoCompCgDto dtoR = new SigitRAllegatoCompCgDto();
			dtoR.setIdAllegato(idAllegato);
			dtoR.setIdTipoComponente(ReplaceSpecialCharUtils.sanitize(dtoT.getIdTipoComponente()));
			dtoR.setProgressivo(dtoT.getProgressivo());
			dtoR.setCodiceImpianto(dtoT.getCodiceImpianto());
			dtoR.setDataInstall(dtoT.getDataInstall());

			if (idImpRuoloPfPg != null)
				dtoR.setFkImpRuoloPfpg(idImpRuoloPfPg);

			if (idContratto != null)
				dtoR.setFkContratto(idContratto);

			getSigitRAllegatoCompCgDao().insert(dtoR);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciRAllegatoCompCgManut] END");
		}
	}




	public void aggiornaAllegato(SigitTAllegatoDto dto) throws DbManagerException {
		log.debug("[DbMgr::aggiornaAllegato] BEGIN");
		try {
			getSigitTAllegatoDao().update(dto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::aggiornaAllegato] END");
		}
	}

//	@Transactional
//	public SigitTIspezionePk inserisciIspezione(DettaglioIspezione dettaglioIspezione, String cfUtenteMod) throws DbManagerException {
//		log.debug("[DbMgr::inserisciIspezione] BEGIN");
//		try {
//
//			SigitRImpRuoloPfpgPk sigitRImpRuoloPfpgPk = getSigitRImpRuoloPfpgDao().insert(MapDto.getSigitRImpRuoloPfpgDto(dettaglioIspezione, cfUtenteMod));
//
//			dettaglioIspezione.setIdIspezione(ConvertUtil.convertToInteger(sigitRImpRuoloPfpgPk.getIdImpRuoloPfpg()));
//
//
//			return getSigitTIspezioneDao().insert(MapDto.getSigitTIspezioneDto(dettaglioIspezione, cfUtenteMod));
//
//		}
//		catch(Exception e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//
//			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
//		}
//		finally {
//			log.debug("[DbMgr::inserisciIspezione] END");
//		}
//	}

//	public void modificaIspezione(DettaglioIspezione dettaglioIspezione, String cfUtenteMod) throws DbManagerException {
//		log.debug("[DbMgr::modificaIspezione] BEGIN");
//		try {
//
//			getSigitTIspezioneDao().update(MapDto.getSigitTIspezioneDto(dettaglioIspezione, cfUtenteMod));
//
//		}
//		catch(Exception e) {
//
//			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
//		}
//		finally {
//			log.debug("[DbMgr::modificaIspezione] END");
//		}
//	}

	public SigitTAllTxtDto getAllTxtAllegato(BigDecimal idAllegato) throws DbManagerException
	{
		log.debug("[DbMgr::getAllTxtAllegato] START");
		SigitTAllTxtPk pk = new SigitTAllTxtPk();
		pk.setIdAllegato(idAllegato);
		try {
			return getSigitTAllTxtDao().findByPrimaryKey(pk);
		} catch (SigitTAllTxtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getAllTxtAllegato] END");
		}
	}

	public void insertAllTxtAllegato(BigDecimal idAllegato, String txtAllegato) throws DbManagerException
	{
		log.debug("[DbMgr::insertAllTxtAllegato] START");
		try {
			//se l'allegato esiste gia', viene eseguita update
			SigitTAllTxtDto allegato = getSigitTAllTxtDao().findByPrimaryKey(new SigitTAllTxtPk(idAllegato));
			if (allegato != null && allegato.getIdAllegato() != null) {
				updateAllTxtAllegato(idAllegato, txtAllegato);
			} else {
				SigitTAllTxtDto dto = new SigitTAllTxtDto();
				dto.setIdAllegato(idAllegato);
				dto.setXmlAllegato(txtAllegato);
				getSigitTAllTxtDao().insert(dto);
			}
		} catch (SigitTAllTxtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::insertAllTxtAllegato] END");
		}
	}

	public void updateAllTxtAllegato(BigDecimal idAllegato, String txtAllegato) throws DbManagerException
	{
		log.debug("[DbMgr::updateAllTxtAllegato] START");
		try {
			SigitTAllTxtDto dto = new SigitTAllTxtDto();
			dto.setIdAllegato(idAllegato);
			dto.setXmlAllegato(txtAllegato);
			getSigitTAllTxtDao().update(dto);
		} catch (SigitTAllTxtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::updateAllTxtAllegato] END");
		}
	}

	/*
	public SigitTAllTxtDto getSigitTAllTxtDto(BigDecimal idAllegato) throws DbManagerException {
		log.debug("[DbMgr::getSigitTAllTxtDto] BEGIN");
		try {
			return getSigitTAllTxtDao().findByPrimaryKey(new SigitTAllTxtPk(idAllegato));
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::getSigitTAllTxtDto] END");
		}
	}

	public SigitTAllTxtDto inserisciFileAllegato(SigitTAllTxtDto allegatoFile) throws DbManagerException {
		log.debug("[DbMgr::cercaFileAllegato] BEGIN");
		try {
			return getSigitTAllTxtDao().findByPrimaryKey(new SigitTAllTxtPk(allegatoFile.getIdAllegato()));
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {xx
			log.debug("[DbMgr::cercaFileAllegato] END");
		}
	}

	public void aggiornaFileAllegato(SigitTAllTxtDto dto) throws DbManagerException {
		log.debug("[DbMgr::aggiornaFileAllegato] BEGIN");
		try {
			getSigitTAllTxtDao().update(dto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {xx
			log.debug("[DbMgr::aggiornaFileAllegato] END");
		}
	}
	*/

	@Transactional
	public void eliminaLibretto(Integer idImpianto, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::eliminaLibretto] BEGIN");
		try {

			//elimina sigit_t_lib_txt - customDeleteByCodImpianto
			getSigitTLibTxtDao().customDeleterBozzaByCodImpianto(ConvertUtil.convertToBigDecimal(idImpianto));
			getSigitTImportXmlLibDao().delete(new SigitTImportXmlLibPk(ConvertUtil.convertToBigDecimal(idImpianto)));
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_lib_txt", "codice_impianto="+idImpianto));
			getSigitTLibrettoDao().customDeleterBozzaByCodiceImpianto(idImpianto);
			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_libretto", "codice_impianto="+idImpianto));

		}
		catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::eliminaLibretto] END");
		}
	}

	public void eliminaDocumentoAgg(Integer idDocumento, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::eliminaDocumentoAgg] BEGIN");
		try {

			// E' una eliminazione logica
			SigitTDocAggiuntivaDto dto = new SigitTDocAggiuntivaDto();
			dto.setIdDocAggiuntiva(idDocumento);
			dto.setDataDelete(DateUtil.getSqlDataCorrente());
			dto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());

			getSigitTDocAggiuntivaDao().updateColumnsAggiornaEliminaDoc(dto);

//			getSigitTDocAggiuntivaDao().delete(new SigitTDocAggiuntivaPk(idDocumento));
//			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_doc_aggiuntiva", "id_doc_aggiuntiva="+idDocumento));
//
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::eliminaDocumentoAgg] END");
		}
	}

	public void eliminaDocumentoAllegato(Integer idDocumento, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::eliminaDocumentoAllegato] BEGIN");
		try {

			// E' una eliminazione logica
			SigitTDocAllegatoDto dto = new SigitTDocAllegatoDto();
			dto.setIdDocAllegato(idDocumento);
			dto.setDataDelete(DateUtil.getSqlDataCorrente());
			dto.setUtenteUltMod(cfUtenteMod);
			dto.setDataUltMod(DateUtil.getSqlCurrentDate());

			getSigitTDocAllegatoDao().updateColumnsAggiornaEliminaDoc(dto);

//			getSigitTDocAggiuntivaDao().delete(new SigitTDocAggiuntivaPk(idDocumento));
//			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_doc_aggiuntiva", "id_doc_aggiuntiva="+idDocumento));
//
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::eliminaDocumentoAllegato] END");
		}
	}

	public void consolidaLibretto(SigitTLibrettoDto dto) throws DbManagerException
	{
		log.debug("[DbMgr::consolidaLibretto] BEGIN");
		try {
			// BEPPE - SigitTLibrettoDto dto = MapDto.getSigitTLibretto(libretto, datiImp);
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());
			dto.setFkStato(new BigDecimal(Constants.ID_STATO_LIBRETTO_CONSOLIDATO));
			dto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
			getSigitTLibrettoDao().update(dto);
		} catch (SigitTLibrettoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally{
			log.debug("[DbMgr::consolidaLibretto] END");
		}
	}

	public List<SigitTLibrettoDto> cercaLibretto(String codiceImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaLibretto] BEGIN");
		try {

			List<SigitTLibrettoDto> librettoList = getSigitTLibrettoDao().findByCodiceImpianto(ConvertUtil.convertToInteger(codiceImpianto));

			return librettoList;
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaLibretto] END");
		}



	}

	public List<SigitTLibrettoDto> cercaLibrettoByStato(String codImpianto, Integer idStato) throws DbManagerException {
		log.debug("[DbMgr::cercaLibretto] BEGIN");
		try {

			List<SigitTLibrettoDto> librettoList = getSigitTLibrettoDao().findByLibrettoFilter(new LibrettoFilter(ConvertUtil.convertToInteger(codImpianto), idStato));

			return librettoList;
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaLibretto] END");
		}
	}

	public SigitTDocAggiuntivaDto cercaDocumentoAggById(Integer idDocumentoAgg) throws DbManagerException {
		log.debug("[DbMgr::cercaDocumentoAggById] BEGIN");

		SigitTDocAggiuntivaDto doc = null;
		try {

			doc = getSigitTDocAggiuntivaDao().findByPrimaryKey(new SigitTDocAggiuntivaPk(idDocumentoAgg));

			return doc;
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaDocumentoAggById] END");
		}
	}

	public List<SigitTDocAggiuntivaDto> cercaDocumentoAggDerogaByCodImpianto(BigDecimal codImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaDocumentoAggDerogaByCodImpianto] BEGIN");


		try {
			SigitTDocAggiuntivaDto filter = new SigitTDocAggiuntivaDto();
			filter.setCodiceImpianto(codImpianto);
			filter.setFkTipoDocagg(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_DOC_DEROGA));

			return getSigitTDocAggiuntivaDao().findByCodImpIdTipoDocAgg(filter);

		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaDocumentoAggDerogaByCodImpianto] END");
		}
	}

	public List<SigitTDocAggiuntivaDto> cercaDocumentoByCodImpianto(Integer codImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaDocumentoByCodImpianto] BEGIN");


		try {

			return getSigitTDocAggiuntivaDao().findByCodImp(codImpianto);

		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaDocumentoByCodImpianto] END");
		}
	}

	public SigitTCompXSempliceDto cercaSigitTCompXSempliceByCodImpianto(BigDecimal codImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitTCompXSempliceByCodImpianto] BEGIN");
		try {

			return getSigitTCompXSempliceDao().findByPrimaryKey(new SigitTCompXSemplicePk(codImpianto));

		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitTCompXSempliceByCodImpianto] END");
		}
	}


	public SigitTTrattH2ODto cercaSigitTTrattH2OByCodImpianto(BigDecimal codImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitTTrattH2OByCodImpianto] BEGIN");
		try {

			return getSigitTTrattH2oDao().findByPrimaryKey(new SigitTTrattH2OPk(codImpianto));

		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaSigitTTrattH2OByCodImpianto] END");
		}
	}

	public SigitTLibTxtDto getTxtLibretto(BigDecimal idLibretto) throws DbManagerException
	{
		log.debug("[DbMgr::getTxtLibretto] START");
		SigitTLibTxtPk pk = new SigitTLibTxtPk();
		pk.setIdLibretto(idLibretto);
		try {
			return getSigitTLibTxtDao().findByPrimaryKey(pk);
		} catch (SigitTLibTxtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getTxtLibretto] END");
		}
	}

	public void insertTxtLibretto(BigDecimal idLibretto, String txtLibretto) throws DbManagerException
	{
		log.debug("[DbMgr::salvaTxtLibretto] START");
		try {
			SigitTLibTxtDto dto = new SigitTLibTxtDto();
			dto.setIdLibretto(idLibretto);
			dto.setXmlLibretto(txtLibretto);
			getSigitTLibTxtDao().insert(dto);
		}
		finally {
			log.debug("[DbMgr::salvaTxtLibretto] END");
		}
	}

	public void updateTxtLibretto(BigDecimal idLibretto, String txtLibretto) throws DbManagerException
	{
		log.debug("[DbMgr::updateTxtLibretto] START");
		try {

			SigitTLibTxtDto dto = getSigitTLibTxtDao().findByPrimaryKey(new SigitTLibTxtPk(idLibretto));

			if (dto == null)
			{
				dto = new SigitTLibTxtDto();
				dto.setIdLibretto(idLibretto);
				dto.setXmlLibretto(txtLibretto);
				getSigitTLibTxtDao().insert(dto);
			}
			else
			{
				dto.setXmlLibretto(txtLibretto);
				getSigitTLibTxtDao().update(dto);

			}

		} catch (SigitTLibTxtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::updateTxtLibretto] END");
		}
	}

	public SigitTControlloLibrettoDto findControlloLibretto(String codiceImpianto) throws ManagerException {
		log.debug("[DbMgr::findControlloLibretto] BEGIN");

		SigitTControlloLibrettoDto controlloLibDto = null;
		try
		{

			controlloLibDto = getSigitTControlloLibrettoDao().findByPrimaryKey(new SigitTControlloLibrettoPk(ConvertUtil.convertToBigDecimal(codiceImpianto)));

			if (controlloLibDto == null)
			{
				controlloLibDto = new SigitTControlloLibrettoDto();
			}
		}
		catch (SigitTControlloLibrettoDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::findControlloLibretto] END");
		}
		return controlloLibDto;
	}



	public List<SigitTLibrettoByCodiceImpNonBozzaDto> findLibrettiNonBozza(String codImpianto) throws ManagerException {
		log.debug("[DbMgr::findLibrettiConsolidati] BEGIN");

		List<SigitTLibrettoByCodiceImpNonBozzaDto> libretti = null;
		try
		{

			libretti = getSigitTLibrettoDao().findByCodiceImpNonBozza(ConvertUtil.convertToInteger(codImpianto));

		}
		catch (SigitTLibrettoDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::findLibrettiConsolidati] END");
		}
		return libretti;
	}

	public List<SigitSLibrettoByCodiceImpiantoNonBozzaDto> findStoricoLibrettiConsNonBozza(String codImpianto) throws ManagerException {
		log.debug("[DbMgr::findStoricoLibrettiConsNonBozza] BEGIN");

		List<SigitSLibrettoByCodiceImpiantoNonBozzaDto> libretti = null;
		try
		{

			libretti = getSigitSLibrettoDao().findByCodiceImpiantoNonBozza(ConvertUtil.convertToInteger(codImpianto));

		}
		catch (SigitSLibrettoDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::findStoricoLibrettiConsNonBozza] END");
		}
		return libretti;
	}

	/*
	public void salvaAllegatoRespinto(SigitTAllRespintoDto dto) throws DbManagerException {
		log.debug("[DbMgr::salvaAllegatoRespinto] BEGIN");
		try {

			getSigitTAllRespintoDao().insert(dto);

		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaAllegatoRespinto] END");
		}
	}

	public void salvaFileAllegatoRespinto(SigitTAllRespTxtDto dto) throws DbManagerException {
		log.debug("[DbMgr::salvaFileAllegatoRespinto] BEGIN");
		try {

			getSigitTAllRespTxtDao().insert(dto);

		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaFileAllegatoRespinto] END");
		}
	}
	*/

	/**
	 * Legge un valore dalla configurazione
	 *
	 * @param chiave Chiave del valore
	 * @return Valore associato alla chiave
	 * @throws DbManagerException Errore durante la lettura della configurazione
	 */
	public SigitWrkConfigDto cercaConfigValue(String chiave) throws DbManagerException {
		List<SigitWrkConfigDto> dtoList = null;
		SigitWrkConfigDto dto = null;

		log.debug("[DbMgr::getConfigValue] BEGIN");
		try {
			dtoList = getSigitWrkConfigDao().findByChiaveConfig(chiave);

			if((dtoList != null) && (dtoList.size() > 0)) {
				dto = dtoList.get(0);
				log.debug("[DbMgr::getConfigValue] Trovato il DTO " + dto);
			}
			else
			{
				log.debug("[DbMgr::getConfigValue] Nessun DTO trovato");
			}
		}
		catch(SigitWrkConfigDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getConfigValue] END");
		}
		return dto;
	}

	/**
	 * Legge un valore dalla configurazione e ritorna il campo valore_config_char
	 *
	 * @param chiave Chiave del valore
	 * @return ValoreConfigChar associato alla chiave
	 * @throws DbManagerException Errore durante la lettura della configurazione
	 */
	public String cercaConfigValueCarattere(String chiave) throws DbManagerException {
		SigitWrkConfigDto dto = null;

		log.debug("[DbMgr::cercaConfigValueCarattere] BEGIN");


		log.debug("[DbMgr::cercaConfigValueCarattere] chiave: "+chiave);

		dto = cercaConfigValue(chiave);

		log.debug("[DbMgr::cercaConfigValueCarattere] dto.getValoreConfigChar(): "+dto.getValoreConfigChar());

		log.debug("[DbMgr::cercaConfigValueCarattere] END");

		return dto.getValoreConfigChar();
	}

	/**
	 * Legge un valore dalla configurazione e ritorna il campo valore_config_num
	 *
	 * @param chiave Chiave del valore
	 * @return ValoreConfigNum associato alla chiave
	 * @throws DbManagerException Errore durante la lettura della configurazione
	 */
	public Integer cercaConfigValueNumerico(String chiave) throws DbManagerException {
		SigitWrkConfigDto dto = null;

		log.debug("[DbMgr::cercaConfigValueNumerico] BEGIN");

		dto = cercaConfigValue(chiave);

		log.debug("[DbMgr::cercaConfigValueNumerico] END");

		return ConvertUtil.convertToInteger(dto.getValoreConfigNum());
	}

	/**
	 * Legge un valore dalla configurazione e ritorna il campo valore_config_flag
	 *
	 * @param chiave Chiave del valore
	 * @return ValoreConfigFlg associato alla chiave
	 * @throws DbManagerException Errore durante la lettura della configurazione
	 */
	public Boolean cercaConfigValueFlg(String chiave) throws DbManagerException {
		SigitWrkConfigDto dto = null;

		log.debug("[DbMgr::cercaConfigValueFlg] BEGIN");

		dto = cercaConfigValue(chiave);

		log.debug("[DbMgr::cercaConfigValueFlg] END");

		return ConvertUtil.convertToBoolean(dto.getValoreFlag());
	}


	/*
	public PersonaFisica salvaPersonaFisica(PersonaFisica persona) throws DbManagerException {
		SigitTPersonaFisicaDto dto = null;
		log.debug("[DbMgr::getPersonaFisicaByCF] BEGIN");
		try {

			//dto.createPk();

			dto = MapDto.mapToSigitTPersonaFisicaDto(persona);

			// DA TOGLIERE, lo metto perche' manca la sequence
			dto.setIdPersonaFisica(ConvertUtil.convertToBigDecimal(1));

			BigDecimal idPersona = getSigitTPersonaFisicaDao().insert(dto).getIdPersonaFisica();

			persona.setIdPersona(ConvertUtil.convertToString(idPersona));

		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getPersonaFisicaByCF] END");
		}
		return persona;
	}

	public PersonaFisica modificaPersonaFisica(PersonaFisica persona) throws DbManagerException {
		PersonaFisica obj = null;
		SigitTPersonaFisicaDto dto = null;
		log.debug("[DbMgr::getPersonaFisicaByCF] BEGIN");
		try {

			dto = MapDto.mapToSigitTPersonaFisicaDto(persona);
			getSigitTPersonaFisicaDao().update(dto);
		}
		catch(SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getPersonaFisicaByCF] END");
		}
		return obj;
	}
	*/

	/**
	 * @param dtoList
	 * @throws DbManagerException
	 */
	public void validateResultSize(List<?> dtoList) throws DbManagerException {
		validateResultSize(dtoList, Constants.MAX_RIGHE);
	}

	/**
	 * @param dtoLists
	 * @throws DbManagerException
	 */
	@SuppressWarnings("unused")
	private void validateResultSizeImpianti(List<?> dtoList) throws DbManagerException {
		log.debug("[DbMgr::validateResultSizeImpianti] BEGIN");
		validateResultSize(dtoList, Constants.MAX_RIGHE);
		log.debug("[DbMgr::validateResultSizeImpianti] END");
	}

	/**
	 * Valida la grandezza del risultato ottenuto
	 *
	 * @param dtoList Lista dei DTO da verificare
	 * @param filter Filtro da applicare
	 * @throws DbManagerException Il risultato eccede la dimensione massima
	 */
	private void validateResultSize(List<?> dtoList, String filter) throws DbManagerException {
		log.debug("[DbMgr::validateResultSize] BEGIN");
		List<SigitWrkConfigDto> configDtoList = null;
		long maxSize;

		try {
			configDtoList = getSigitWrkConfigDao().findByChiaveConfig(filter);
			if(configDtoList.size() > 0) {
				maxSize = configDtoList.get(0).getValoreConfigNum().longValue();
				log.debug("Dimensione max risultati: " + maxSize);
				if((dtoList != null) && (dtoList.size() > maxSize)) {
					throw new DbManagerException(new Message(Messages.I002, Message.INFO));
				}
			}
		}
		catch(SigitWrkConfigDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::validateResultSize] END");
		}
	}

	/**
	 * Valida la grandezza del risultato ottenuto
	 *
	 * @param dtoList Lista dei DTO da verificare
	 * @param filter Filtro da applicare
	 * @throws DbManagerException Il risultato eccede la dimensione massima
	 */
	private void validateResultSize(Integer count, String filter) throws ValidationManagerException, DbManagerException {
		log.debug("[DbMgr::validateResultSize] BEGIN");
		List<SigitWrkConfigDto> configDtoList = null;
		long maxSize;

		try {
			configDtoList = getSigitWrkConfigDao().findByChiaveConfig(filter);
			if(configDtoList.size() > 0) {
				maxSize = configDtoList.get(0).getValoreConfigNum().longValue();
				log.debug("Dimensione max risultati: " + maxSize);
				if((count == null) || (count.intValue() > maxSize)) {
					throw new ValidationManagerException(new Message(Messages.I002, Message.INFO));
				}
			}
		}
		catch(SigitWrkConfigDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::validateResultSize] END");
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ArrayList<?> convertToArrayList(List<?> list) {
		log.debug("[DbMgr::convertToArrayList] BEGIN");
		ArrayList<?> arrayList = null;

		if(list != null) {
			if(list instanceof ArrayList<?>) {
				arrayList = (ArrayList<?>) list;
			}
			else {
				arrayList = new ArrayList(list);
			}
		}
		log.debug("[DbMgr::convertToArrayList] END");
		return arrayList;
	}

	public void consolidaUnitaImmobiliareSecondarie(String idImpianto, Richiesta richiesta, String cfUtente) throws DbManagerException
	{
		log.debug("[DbMgr::consolidaUnitaImmobiliareSecondarie] BEGIN");

		//cancellare unita immobiliari secondarie per l'impianto, loggare su db
		try {
			getSigitTUnitaImmobiliareDao().customDeleterByCodImpiantoSecondarie(new Integer(idImpianto));
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_unita_immobiliare", "codice_impianto="+idImpianto+"&flg_principale<>1"));

			List<SigitTUnitaImmobiliareDto> dtoList = MapDto.getUnitaImmobiliareSecondarie(idImpianto, richiesta);
			int i=0;
			for (SigitTUnitaImmobiliareDto dto : dtoList) {
				if(i++==0) continue;//la prima unita' immobiliare, dovrebbe essere quella principale
				//inserire le nuove unita' immobiliari secondarie per l'impianto
				dto.setUtenteUltMod(cfUtente);
				getSigitTUnitaImmobiliareDao().insert(dto);
			}
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::consolidaUnitaImmobiliareSecondarie] END");
		}
	}

	public void consolidaUnitaImmobiliareSecondarieLight(String idImpianto, it.csi.sigit.sigitwebn.xml.librettoLight.data.RichiestaDocument.Richiesta richiesta, String cfUtente) throws DbManagerException
	{
		log.debug("[DbMgr::consolidaUnitaImmobiliareSecondarieLight] BEGIN");

		//cancellare unita immobiliari secondarie per l'impianto, loggare su db
		try {
			getSigitTUnitaImmobiliareDao().customDeleterByCodImpiantoSecondarie(new Integer(idImpianto));
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_unita_immobiliare", "codice_impianto="+idImpianto+"&flg_principale<>1"));

			List<SigitTUnitaImmobiliareDto> dtoList = MapDto.getUnitaImmobiliareSecondarieLight(idImpianto, richiesta);
			int i=0;
			for (SigitTUnitaImmobiliareDto dto : dtoList) {
				if(i++==0) continue;//la prima unita' immobiliare, dovrebbe essere quella principale
				//inserire le nuove unita' immobiliari secondarie per l'impianto
				dto.setUtenteUltMod(cfUtente);
				getSigitTUnitaImmobiliareDao().insert(dto);
			}
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::consolidaUnitaImmobiliareSecondarieLight] END");
		}
	}

	public void consolidaUnitaImmobiliarePrincipale(String idImpianto, Richiesta richiesta, String cfUtente, boolean checkCatasto) throws DbManagerException
	{
		log.debug("[DbMgr::consolidaUnitaImmobiliarePrincipale] BEGIN");

		try {
			List<SigitTUnitaImmobiliareDto> unitaPrincipaleList = getSigitTUnitaImmobiliareDao().findUnitaPrincipaleImpianto(new Integer(idImpianto));
			SigitTUnitaImmobiliareDto uiPrincipale = new SigitTUnitaImmobiliareDto();
			if(unitaPrincipaleList != null && !unitaPrincipaleList.isEmpty())
			{
				uiPrincipale = unitaPrincipaleList.get(0);
			}
			log.debug("Unita immob principale trovata: " + uiPrincipale.getIdUnitaImm());
			SigitTUnitaImmobiliareDto dto = MapDto.getUnitaImmobiliarePrincipale(uiPrincipale, richiesta.getDatiSchedaIdentificativaImp());
			//verifica catasto
			if(checkCatasto && GenericUtil.isNullOrEmpty(dto.getPodElettrico()))
				throw new DbManagerException(new Message("Completare i dati catastali prima di procedere", Message.ERROR));
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());
			dto.setUtenteUltMod(cfUtente);
			getSigitTUnitaImmobiliareDao().update(dto);
		} catch (NumberFormatException e) {
			log.error("Errore ",e);
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTUnitaImmobiliareDaoException e) {
			log.error("Errore ",e);
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::consolidaUnitaImmobiliarePrincipale] END");
		}
	}

	public void consolidaUnitaImmobiliarePrincipaleLight(String idImpianto, it.csi.sigit.sigitwebn.xml.librettoLight.data.RichiestaDocument.Richiesta richiesta, String cfUtente) throws DbManagerException
	{
		log.debug("[DbMgr::consolidaUnitaImmobiliarePrincipaleLight] BEGIN");

		try {
			List<SigitTUnitaImmobiliareDto> unitaPrincipaleList = getSigitTUnitaImmobiliareDao().findUnitaPrincipaleImpianto(new Integer(idImpianto));
			SigitTUnitaImmobiliareDto uiPrincipale = new SigitTUnitaImmobiliareDto();
			if(unitaPrincipaleList != null && !unitaPrincipaleList.isEmpty())
			{
				uiPrincipale = unitaPrincipaleList.get(0);
			}
			log.debug("Unita immob principale trovata: " + uiPrincipale.getIdUnitaImm());
			SigitTUnitaImmobiliareDto dto = MapDto.getUnitaImmobiliarePrincipaleLight(uiPrincipale, richiesta.getDatiSchedaIdentificativaImp());
			//verifica catasto
			if(GenericUtil.isNullOrEmpty(dto.getPodElettrico()))
				throw new DbManagerException(new Message("Completare i dati catastali prima di procedere", Message.ERROR));
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());
			dto.setUtenteUltMod(cfUtente);
			getSigitTUnitaImmobiliareDao().update(dto);
		} catch (NumberFormatException e) {
			log.error("Errore ",e);
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTUnitaImmobiliareDaoException e) {
			log.error("Errore ",e);
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::consolidaUnitaImmobiliarePrincipaleLight] END");
		}
	}

	public String getDescrizioneTipoAllegato(BigDecimal idTipoDocumento) throws DbManagerException {
		String obj = null;
		log.debug("[DbMgr::getDescrizioneTipoAllegato] BEGIN");

		try {
			SigitDTipoDocumentoPk pk = new SigitDTipoDocumentoPk();
			pk.setIdTipoDocumento(idTipoDocumento);

			SigitDTipoDocumentoDto dettaglio = this.getSigitDTipoDocumentoDao().findByPrimaryKey(pk);
			obj = dettaglio.getDesTipoDocumento();

		} catch (SigitDTipoDocumentoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getDescrizioneTipoAllegato] END");
		}
		return obj;
	}

	public String getDescrizioneStatoAllegato(BigDecimal idStatoRapporto) throws DbManagerException {
		String obj = null;
		log.debug("[DbMgr::getDescrizioneStatoAllegato] BEGIN");

		try {
			 SigitDStatoRappPk pk = new SigitDStatoRappPk();
			 pk.setIdStatoRapp(idStatoRapporto);
			 SigitDStatoRappDto dettaglio = this.getSigitDStatoRappDao().findByPrimaryKey(pk );
			 obj = dettaglio.getDesStatoRapp();

		} catch (SigitDStatoRappDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getDescrizioneStatoAllegato] END");
		}
		return obj;
	}

	public SigitTImpiantoDto consolidaDatiImpianto(String idImpianto, String cfUtente, DatiSchedaIdentificativaImp datiImpianto) throws DbManagerException
	{
		log.debug("[DbMgr::consolidaDatiImpianto] BEGIN");

		SigitTImpiantoPk pkImp = new SigitTImpiantoPk();
		pkImp.setCodiceImpianto(new BigDecimal(idImpianto));
		try {
			SigitTImpiantoDto impiantoDb = getSigitTImpiantoDao().findByPrimaryKey(pkImp);
			SigitTImpiantoDto impiantoDto = MapDto.getSigitTImpianto(impiantoDb, datiImpianto);
			impiantoDto.setUtenteUltMod(cfUtente);
			impiantoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
			getSigitTImpiantoDao().update(impiantoDto);
			return impiantoDto;
		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::consolidaDatiImpianto] END");
		}
	}

	public SigitTImpiantoDto consolidaDatiImpiantoLight(String idImpianto, String cfUtente, it.csi.sigit.sigitwebn.xml.librettoLight.data.DatiSchedaIdentificativaImpDocument.DatiSchedaIdentificativaImp datiImpianto) throws DbManagerException
	{
		log.debug("[DbMgr::consolidaDatiImpiantoLight] BEGIN");

		SigitTImpiantoPk pkImp = new SigitTImpiantoPk();
		pkImp.setCodiceImpianto(new BigDecimal(idImpianto));
		try {
			SigitTImpiantoDto impiantoDb = getSigitTImpiantoDao().findByPrimaryKey(pkImp);
			SigitTImpiantoDto impiantoDto = MapDto.getSigitTImpiantoLight(impiantoDb, datiImpianto);
			impiantoDto.setUtenteUltMod(cfUtente);
			impiantoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
			getSigitTImpiantoDao().update(impiantoDto);
			return impiantoDto;
		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::consolidaDatiImpiantoLight] END");
		}
	}

	public void consolidaTrattamentoH2o(String idImpianto, String cfUtente, DatiSchedaTrattH2O datiH) throws DbManagerException
	{
		log.debug("[DbMgr::consolidaTrattamentoH2o] BEGIN");

		SigitTTrattH2ODto dto = MapDto.getSigitTTrattH2o(idImpianto, datiH);
		try {
			SigitTTrattH2OPk pk = new SigitTTrattH2OPk();
			pk.setCodiceImpianto(new BigDecimal(idImpianto));
			if(getSigitTTrattH2oDao().findByPrimaryKey(pk)==null)
				getSigitTTrattH2oDao().insert(dto);
			else
				getSigitTTrattH2oDao().update(dto);
		} catch (SigitTTrattH2ODaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::consolidaTrattamentoH2o] END");
		}
	}

	/*
	public void verificaDataFineCompGT(RowGT rowGT, List<SigitVSk4GtDto> comSk4GtImpianto, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		verificaDataFineCompGTAll(rowGT, null, comSk4GtImpianto, codImpianto, progressivo);
	}

	public void verificaDataFineCompGTSost(RowGTsost rowGTSost, List<SigitVSk4GtDto> comSk4GtImpianto, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		verificaDataFineCompGTAll(null, rowGTSost, comSk4GtImpianto, codImpianto, progressivo);
	}

	private void verificaDataFineCompGTAll(RowGT rowGT, RowGTsost rowGTSost, List<SigitVSk4GtDto> comSk4GtImpianto, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		log.debug("[DbMgr::verificaDataFineCompGTAll] START");

		Date dataDismiss = null;
		Date dataInstall = null;
		boolean isAttivo = false;

		if (rowGT!=null)
		{
			try{dataDismiss = ConvertUtil.convertToDate(rowGT.getL41DataDismiss());}catch (Exception e) {}
			try{dataInstall = ConvertUtil.convertToDate(rowGT.getL41DataInstallaz());}catch (Exception e) {}
			isAttivo = true;
		}
		else
		{
			try{dataDismiss = ConvertUtil.convertToDate(rowGTSost.getL41DataDismiss());}catch (Exception e) {}
			try{dataInstall = ConvertUtil.convertToDate(rowGTSost.getL41DataInstallaz());}catch (Exception e) {}
		}



		try
		{
			// Verifico
			if (dataDismiss != null)
			{
				// devo recuperare la data controllo aggiornata
				for (SigitVSk4GtDto sigitVSk4GtDto : comSk4GtImpianto) {

					if (ConvertUtil.convertToInteger(sigitVSk4GtDto.getProgressivo()).intValue() ==	ConvertUtil.convertToInteger(progressivo) &&
							DateUtil.checkDateEqual(sigitVSk4GtDto.getDataInstall(), dataInstall))
					{
						if (sigitVSk4GtDto.getDataControllo() != null &&
								!DateUtil.checkDateOrder(sigitVSk4GtDto.getDataControllo(), dataDismiss, true))
						{

							throw new DbManagerException(new Message(
									Messages.S164, Constants.TIPO_COMPONENTE_GT,
									ConvertUtil.convertToString(progressivo)));
						}
					}

					break;

				}

				if (isAttivo)
				{
					SigitTContrattoDto contratto = cercaContrattoByCodImpTipoProgr(codImpianto, Constants.TIPO_COMPONENTE_GT, progressivo);

					if (contratto != null && !DateUtil.checkDateOrder(contratto.getDataInizio(), dataDismiss, true))
					{
						throw new DbManagerException(new Message(
								Messages.S165, Constants.TIPO_COMPONENTE_GT,
								ConvertUtil.convertToString(progressivo)));
					}
				}
			}


		}
		finally {
			log.debug("[DbMgr::verificaDataFineCompGTAll] END");
		}
	}
	*/
	/*
	public void verificaDataFineCompGF(RowGF rowGF, List<SigitVSk4GfDto> comSk4GfImpianto, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		verificaDataFineCompGFAll(rowGF, null, comSk4GfImpianto, codImpianto, progressivo);
	}

	public void verificaDataFineCompGFSost(RowGFsost rowGFSost, List<SigitVSk4GfDto> comSk4GfImpianto, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		verificaDataFineCompGFAll(null, rowGFSost, comSk4GfImpianto, codImpianto, progressivo);
	}

	private void verificaDataFineCompGFAll(RowGF rowGF, RowGFsost rowGFSost, List<SigitVSk4GfDto> comSk4GfImpianto, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		log.debug("[DbMgr::verificaDataFineCompGFAll] START");

		Date dataDismiss = null;
		Date dataInstall = null;
		boolean isAttivo = false;

		if (rowGF!=null)
		{
			try{dataDismiss = ConvertUtil.convertToDate(rowGF.getL44DataDismiss());}catch (Exception e) {}
			try{dataInstall = ConvertUtil.convertToDate(rowGF.getL44DataInstallaz());}catch (Exception e) {}
			isAttivo = true;
		}
		else
		{
			try{dataDismiss = ConvertUtil.convertToDate(rowGFSost.getL44DataDismiss());}catch (Exception e) {}
			try{dataInstall = ConvertUtil.convertToDate(rowGFSost.getL44DataInstallaz());}catch (Exception e) {}
		}



		try
		{
			// Verifico
			if (dataDismiss != null)
			{
				// devo recuperare la data controllo aggiornata
				for (SigitVSk4GfDto sigitVSk4GfDto : comSk4GfImpianto) {

					if (ConvertUtil.convertToInteger(sigitVSk4GfDto.getProgressivo()).intValue() ==	ConvertUtil.convertToInteger(progressivo) &&
							DateUtil.checkDateEqual(sigitVSk4GfDto.getDataInstall(), dataInstall))
					{
						if (sigitVSk4GfDto.getDataControllo() != null &&
								!DateUtil.checkDateOrder(sigitVSk4GfDto.getDataControllo(), dataDismiss, true))
						{

							throw new DbManagerException(new Message(
									Messages.S164, Constants.TIPO_COMPONENTE_GF,
									ConvertUtil.convertToString(progressivo)));
						}
					}

					break;

				}

				if (isAttivo)
				{
					SigitTContrattoDto contratto = cercaContrattoByCodImpTipoProgr(codImpianto, Constants.TIPO_COMPONENTE_GF, progressivo);

					if (contratto != null && !DateUtil.checkDateOrder(contratto.getDataInizio(), dataDismiss, true))
					{
						throw new DbManagerException(new Message(
								Messages.S165, Constants.TIPO_COMPONENTE_GF,
								ConvertUtil.convertToString(progressivo)));
					}
				}
			}


		}
		finally {
			log.debug("[DbMgr::verificaDataFineCompGFAll] END");
		}
	}
	*/

	/*
	public void verificaDataFineCompSC(RowSC rowSC, List<SigitVSk4ScDto> comSk4ScImpianto, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		verificaDataFineCompSCAll(rowSC, null, comSk4ScImpianto, codImpianto, progressivo);
	}

	public void verificaDataFineCompSCSost(RowSCsost rowSCSost, List<SigitVSk4ScDto> comSk4ScImpianto, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		verificaDataFineCompSCAll(null, rowSCSost, comSk4ScImpianto, codImpianto, progressivo);
	}


	private void verificaDataFineCompSCAll(RowSC rowSC, RowSCsost rowSCSost, List<SigitVSk4ScDto> comSk4ScImpianto, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		log.debug("[DbMgr::verificaDataFineCompSCAll] START");

		Date dataDismiss = null;
		Date dataInstall = null;
		boolean isAttivo = false;

		if (rowSC!=null)
		{
			try{dataDismiss = ConvertUtil.convertToDate(rowSC.getL45DataDismiss());}catch (Exception e) {}
			try{dataInstall = ConvertUtil.convertToDate(rowSC.getL45DataInstallaz());}catch (Exception e) {}
			isAttivo = true;
		}
		else
		{
			try{dataDismiss = ConvertUtil.convertToDate(rowSCSost.getL45DataDismiss());}catch (Exception e) {}
			try{dataInstall = ConvertUtil.convertToDate(rowSCSost.getL45DataInstallaz());}catch (Exception e) {}
		}



		try
		{
			// Verifico
			if (dataDismiss != null)
			{
				// devo recuperare la data controllo aggiornata
				for (SigitVSk4ScDto sigitVSk4ScDto : comSk4ScImpianto) {

					if (ConvertUtil.convertToInteger(sigitVSk4ScDto.getProgressivo()).intValue() ==	ConvertUtil.convertToInteger(progressivo) &&
							DateUtil.checkDateEqual(sigitVSk4ScDto.getDataInstall(), dataInstall))
					{
						if (sigitVSk4ScDto.getDataControllo() != null &&
								!DateUtil.checkDateOrder(sigitVSk4ScDto.getDataControllo(), dataDismiss, true))
						{

							throw new DbManagerException(new Message(
									Messages.S164, Constants.TIPO_COMPONENTE_SC,
									ConvertUtil.convertToString(progressivo)));
						}
					}

					break;

				}

				if (isAttivo)
				{
					SigitTContrattoDto contratto = cercaContrattoByCodImpTipoProgr(codImpianto, Constants.TIPO_COMPONENTE_SC, progressivo);

					if (contratto != null && !DateUtil.checkDateOrder(contratto.getDataInizio(), dataDismiss, true))
					{
						throw new DbManagerException(new Message(
								Messages.S165, Constants.TIPO_COMPONENTE_SC,
								ConvertUtil.convertToString(progressivo)));
					}
				}
			}


		}
		finally {
			log.debug("[DbMgr::verificaDataFineCompSCAll] END");
		}
	}
	*/

	/*
	public void verificaDataFineCompCG(RowCG rowCG, List<SigitVSk4CgDto> comSk4CgImpianto, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		verificaDataFineCompCGAll(rowCG, null, comSk4CgImpianto, codImpianto, progressivo);
	}

	public void verificaDataFineCompCGSost(RowCGsost rowCGSost, List<SigitVSk4CgDto> comSk4CgImpianto, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		verificaDataFineCompCGAll(null, rowCGSost, comSk4CgImpianto, codImpianto, progressivo);
	}

	private void verificaDataFineCompCGAll(RowCG rowCG, RowCGsost rowCGSost, List<SigitVSk4CgDto> comSk4CgImpianto, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		log.debug("[DbMgr::verificaDataFineCompCGAll] START");

		Date dataDismiss = null;
		Date dataInstall = null;
		boolean isAttivo = false;

		if (rowCG!=null)
		{
			try{dataDismiss = ConvertUtil.convertToDate(rowCG.getL46DataDismiss());}catch (Exception e) {}
			try{dataInstall = ConvertUtil.convertToDate(rowCG.getL46DataInstallaz());}catch (Exception e) {}
			isAttivo = true;
		}
		else
		{
			try{dataDismiss = ConvertUtil.convertToDate(rowCGSost.getL46DataDismiss());}catch (Exception e) {}
			try{dataInstall = ConvertUtil.convertToDate(rowCGSost.getL46DataInstallaz());}catch (Exception e) {}
		}



		try
		{
			// Verifico
			if (dataDismiss != null)
			{
				// devo recuperare la data controllo aggiornata
				for (SigitVSk4CgDto sigitVSk4CgDto : comSk4CgImpianto) {

					if (ConvertUtil.convertToInteger(sigitVSk4CgDto.getProgressivo()).intValue() ==	ConvertUtil.convertToInteger(progressivo) &&
							DateUtil.checkDateEqual(sigitVSk4CgDto.getDataInstall(), dataInstall))
					{
						if (sigitVSk4CgDto.getDataControllo() != null &&
								!DateUtil.checkDateOrder(sigitVSk4CgDto.getDataControllo(), dataDismiss, true))
						{

							throw new DbManagerException(new Message(
									Messages.S164, Constants.TIPO_COMPONENTE_CG,
									ConvertUtil.convertToString(progressivo)));
						}
					}

					break;

				}

				if (isAttivo)
				{
					SigitTContrattoDto contratto = cercaContrattoByCodImpTipoProgr(codImpianto, Constants.TIPO_COMPONENTE_CG, progressivo);

					if (contratto != null && !DateUtil.checkDateOrder(contratto.getDataInizio(), dataDismiss, true))
					{
						throw new DbManagerException(new Message(
								Messages.S165, Constants.TIPO_COMPONENTE_CG,
								ConvertUtil.convertToString(progressivo)));
					}
				}
			}


		}
		finally {
			log.debug("[DbMgr::verificaDataFineCompCGAll] END");
		}
	}
	*/

	/*
	public void verificaDataFineCompAG(RowAG rowAG, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		verificaDataFineCompAGAll(rowAG, null, codImpianto, progressivo);
	}

	public void verificaDataFineCompAGSost(RowAGsost rowGTSost, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		verificaDataFineCompAGAll(null, rowGTSost, codImpianto, progressivo);
	}

	private void verificaDataFineCompAGAll(RowAG rowAG, RowAGsost rowAGSost, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		log.debug("[DbMgr::verificaDataFineCompAGAll] START");

		Date dataDismiss = null;
		boolean isAttivo = false;

		if (rowAG!=null)
		{
			try{dataDismiss = ConvertUtil.convertToDate(rowAG.getL48DataDismiss());}catch (Exception e) {}
			isAttivo = true;
		}
		else
		{
			try{dataDismiss = ConvertUtil.convertToDate(rowAGSost.getL48DataDismiss());}catch (Exception e) {}
		}

		try
		{
			// Verifico
			if (dataDismiss != null)
			{

				if (isAttivo)
				{
					SigitTContrattoDto contratto = cercaContrattoByCodImpTipoProgr(codImpianto, Constants.TIPO_COMPONENTE_AG, progressivo);

					if (contratto != null && !DateUtil.checkDateOrder(contratto.getDataInizio(), dataDismiss, true))
					{
						throw new DbManagerException(new Message(
								Messages.S165, Constants.TIPO_COMPONENTE_AG,
								ConvertUtil.convertToString(progressivo)));
					}
				}
			}


		}
		finally {
			log.debug("[DbMgr::verificaDataFineCompAGAll] END");
		}
	}
	*/
	/*
	public void verificaDataFineCompCS(RowCS rowCS, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		verificaDataFineCompCSAll(rowCS, null, codImpianto, progressivo);
	}

	public void verificaDataFineCompCSSost(RowCSvar rowCSSost, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		verificaDataFineCompCSAll(null, rowCSSost, codImpianto, progressivo);
	}

	private void verificaDataFineCompCSAll(RowCS rowCS, RowCSvar rowCSSost, String codImpianto, BigDecimal progressivo) throws DbManagerException
	{
		log.debug("[DbMgr::verificaDataFineCompCSAll] START");

		Date dataDismiss = null;
		boolean isAttivo = false;

		if (rowCS!=null)
		{
			try{dataDismiss = ConvertUtil.convertToDate(rowCS.getL47DataDismissione());}catch (Exception e) {}
			isAttivo = true;
		}
		else
		{
			try{dataDismiss = ConvertUtil.convertToDate(rowCSSost.getL47DataDismissione());}catch (Exception e) {}
		}

		try
		{
			// Verifico
			if (dataDismiss != null)
			{

				if (isAttivo)
				{
					SigitTContrattoDto contratto = cercaContrattoByCodImpTipoProgr(codImpianto, Constants.TIPO_COMPONENTE_CS, progressivo);

					if (contratto != null && !DateUtil.checkDateOrder(contratto.getDataInizio(), dataDismiss, true))
					{
						throw new DbManagerException(new Message(
								Messages.S165, Constants.TIPO_COMPONENTE_CS,
								ConvertUtil.convertToString(progressivo)));
					}
				}
			}


		}
		finally {
			log.debug("[DbMgr::verificaDataFineCompCSAll] END");
		}
	}
	*/
	/*
	public void consolidaGT(String codImpianto, String cfUtente, List<RowGT> listGt, Integer idPersonaGiuridica) throws DbManagerException
	{
		log.debug("Consolidamento GT");
		//cancellare tutti i record BR_RC legati ai GT dell'impianto
		try {
			SigitTCompBrRcDto input = new SigitTCompBrRcDto();
			input.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			List<SigitTCompBrRcDto> brRcDaCancellare = getSigitTCompBrRcDao().findByTipoAndCodImpiantoOrdered(input);
			cancellaListaComponentiBrRc(brRcDaCancellare, cfUtente);
		} catch (SigitTCompBrRcDaoException e1) {
			throw new DbManagerException(e1, new Message(Messages.ERROR_UPDATE_DB));
		}

		List<String> progressivi = new ArrayList<String>();


		try {
			// Devo recuperare nuovamente la data controllo per fare della verifiche
			List<SigitVSk4GtDto> comSk4GtImpianto = getCompSk4Gt(ConvertUtil.convertToInteger(codImpianto));

			String GT = "GT";
			for (RowGT rowGT : listGt) {
				BigDecimal idImpianto = new BigDecimal(codImpianto);
				SigitTComp4Dto comp4 = MapDto.getSigitTComp4(idImpianto, rowGT);
				BigDecimal progressivo = comp4.getProgressivo();
				SigitTCompGtDto compGt = MapDto.getSigitTCompGt(idImpianto, rowGT, cfUtente);
				if(GenericUtil.isNullOrEmpty(compGt.getDataInstall()))
					continue;
				progressivi.add(progressivo.toString());

				log.debug("###PRIMA DELLA VERIFICA###");

				if (log.isDebugEnabled())
					GenericUtil.stampa(compGt, true, 3);

				// E' UNA VERIFICA - inizio
				verificaDataFineCompGT(rowGT, comSk4GtImpianto, codImpianto, progressivo);
				// E' UNA VERIFICA - fine




//				comp4.setUtenteUltMod(cfUtente);
//				comp4.setDataUltMod(DateUtil.getSqlDataCorrente());
//				log.debug("progressivo: " + progressivo+", data inst: "+ConvertUtil.convertToString(comp4.getDataInstall()));
				log.debug("progressivo: " + progressivo);

				SigitTCompGtPk pkCompGt = new SigitTCompGtPk();
				pkCompGt.setCodiceImpianto(idImpianto);
				pkCompGt.setDataInstall(compGt.getDataInstall());
				pkCompGt.setIdTipoComponente(GT);
				pkCompGt.setProgressivo(progressivo);

				SigitTComp4Pk pkComp4 = new SigitTComp4Pk();
				pkComp4.setCodiceImpianto(pkCompGt.getCodiceImpianto());
				pkComp4.setIdTipoComponente(pkCompGt.getIdTipoComponente());
				pkComp4.setProgressivo(pkCompGt.getProgressivo());

				// Vuol dire che sul db non esisteva questa componente (es. GT1)
				if(getSigitTComp4Dao().findByPrimaryKey(pkComp4)==null)
				{
					getSigitTComp4Dao().insert(comp4);

				}

				log.debug("###DOPO LA VERIFICA###");
				GenericUtil.stampa(compGt, true, 3);


				if(getSigittCompGtDao().findByPrimaryKey(pkCompGt)==null)
				{
					log.debug("inserisco GT");
					getSigittCompGtDao().insert(compGt);
				}
				else
				{

					log.debug("aggiorno GT");
					//getSigitTComp4Dao().update(comp4);
					getSigittCompGtDao().update(compGt);

				}


				SigitRComp4ManutDto comp4ManutFilter = new SigitRComp4ManutDto();
				comp4ManutFilter.setCodiceImpianto(pkCompGt.getCodiceImpianto());
				comp4ManutFilter.setIdTipoComponente(pkCompGt.getIdTipoComponente());
				comp4ManutFilter.setProgressivo(pkCompGt.getProgressivo());


				List<SigitRComp4ManutDto> comp4ManutList = getSigitRComp4ManutDao().findAttiviByFilter(comp4ManutFilter);

				log.debug("STAMPO comp4ManutList: "+comp4ManutList);

				if(comp4ManutList == null || comp4ManutList.size() == 0)
				{
					SigitRComp4ManutDto comp4Manut = MapDto.getSigitRComp4Manut(idImpianto, rowGT, idPersonaGiuridica, it.csi.sigit.sigitwebn.business.dao.util.Constants.ID_RUOLO_MANUTENTORE_ALL_1, cfUtente);
					getSigitRComp4ManutDao().insert(comp4Manut);
				}

				List<String> dateInstallazione = new ArrayList<String>();
				dateInstallazione.add(ConvertUtil.convertToString(compGt.getDataInstall()));
				SezGTsostituite gtSostituite = rowGT.getSezGTsostituite();
				log.debug("consolodamento GT sotituite");
				if(gtSostituite!=null)
				for (RowGTsost rowGTSost : gtSostituite.getRowGTsostList()) {

					// E' UNA VERIFICA - inizio
					verificaDataFineCompGTSost(rowGTSost, comSk4GtImpianto, codImpianto, progressivo);
					// E' UNA VERIFICA - fine

					SigitTCompGtDto compGtSost = MapDto.getSigitTCompGtSost(idImpianto, progressivo, rowGTSost, cfUtente);

					if(getSigittCompGtDao().findByPrimaryKey(MapDto.getSigittCompGtPk(compGtSost))==null)
					{
						log.debug("inserisco gt sost");
						//getSigitTComp4Dao().insert(comp4Sost);
						getSigittCompGtDao().insert(compGtSost);

					}
					else
					{
						log.debug("aggiorno gt sost");

						getSigittCompGtDao().update(compGtSost);


					}
					dateInstallazione.add(ConvertUtil.convertToString(compGtSost.getDataInstall()));
				}
				log.debug("Controllo sezioni eliminate");
				CompFilter filter = new CompFilter();
				filter.setCodImpianto(codImpianto);
				filter.setProgressivo(progressivo.toString());
				filter.setTipoComponente(GT);
				filter.setListDateInstallazione(dateInstallazione);

				// Mi faccio dare tutte le componente di un progressivo (es. GT1) non presenti nel modulo (ciclo per le date installazione)
				List<SigitTCompGtDto> componentiCancellate = getSigittCompGtDao().findComponentiCancellate(filter);

				cancellaListaComponentiGT(componentiCancellate, cfUtente);
			}
			//eliminazione delle sezioni GT cancellate e le sostituzioni
			log.debug("Controllo sezioni GT eliminate");
			CompFilter filtro = new CompFilter();
			filtro.setCodImpianto(codImpianto);
			filtro.setTipoComponente(GT);
			filtro.setListProgressivi(progressivi);
			log.debug("Num progressivi: "+progressivi.size());

			// Mi faccio dare tutte le componenti GT non presenti nel modulo (ciclo per i progressivi)
			List<SigitTComp4Dto> componentiGTCancellate = getSigitTComp4Dao().findComponentiCancellate(filtro);

			//cancellazione GT eliminate dal pdf
			cancellaListaComponentiGTAll(componentiGTCancellate, cfUtente);
		} catch (SigitTComp4DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitTCompGtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitRComp4ManutDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitVSk4GtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitTAzioneComp4DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}


		//aggiornare record della tabella: SIGIT_R_IMP_RUOLO_PFPG
		//XXX potenzialmente e' da commentare
		//aggiornaRuoloPfpg(progressivi, codImpianto, idPersonaGiuridica, cfUtente, it.csi.sigit.sigitwebn.business.dao.util.Constants.ID_RUOLO_MANUTENTORE_ALL_1);
	}
	*/
	private void cancellaListaComponentiGT(List<SigitTCompGtDto> componentiCancellate, String cfUtente) throws SigitTComp4DaoException, SigitTCompGtDaoException, SigitRComp4ManutDaoException, SigitTAzioneComp4DaoException
	{
		if(componentiCancellate!=null && !componentiCancellate.isEmpty())
		{
			log.debug("ci sono sezioni da cancellare");
			for (SigitTCompGtDto compToDel : componentiCancellate) {

				//vengono eliminate anche le azioni sul componente gt
				getSigitTAzioneComp4Dao().customDeleterByComp4(new SigitTComp4Pk(compToDel.getCodiceImpianto(), Constants.TIPO_COMPONENTE_GT, compToDel.getProgressivo()));

				getSigittCompGtDao().delete(MapDto.getSigittCompGtPk(compToDel));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_gt",
//						"codice_impianto="+codImpianto+"&progressivo="+compToDel.getProgressivo()+
//						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_gt",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&progressivo="+compToDel.getProgressivo()));

				//getSigitTComp4Dao().delete(MapDto.getSigittComp4Pk(compToDel));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
//						"codice_impianto="+codImpianto+"&tipi=GT&progressivo="+compToDel.getProgressivo()+
//						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
//						"codice_impianto="+codImpianto+"&tipi=GT&progressivo="+compToDel.getProgressivo()));

//				SigitRComp4ManutDto comp4Manut = new SigitRComp4ManutDto();
//				comp4Manut.setCodiceImpianto(compToDel.getCodiceImpianto());
//				comp4Manut.setDataInstall(compToDel.getDataInstall());
//				comp4Manut.setIdTipoComponente(compToDel.getIdTipoComponente());
//				comp4Manut.setProgressivo(compToDel.getProgressivo());
//
//				getSigitRComp4ManutDao().customDeleterByFilter(comp4Manut);

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_r_comp4_manut",
//						"codice_impianto="+codImpianto+"&tipo=GT&&progressivo="+compToDel.getProgressivo()+
//						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_r_comp4_manut",
//						"codice_impianto="+codImpianto+"&tipo=GT&&progressivo="+compToDel.getProgressivo()));

			}
		}
		else
			log.debug("NON ci sono sezioni da cancellare");
	}

	public void cancellaListaComponentiAll(Integer codiceImpianto) throws DbManagerException
	{
		try
		{
			getSigitTConsumoDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTConsumo144Dao().customDeleterByCodImpianto(codiceImpianto);

			getSigitTTrattH2oDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompXSempliceDao().customDeleterByCodImpianto(codiceImpianto);

			// Per cancellare getSigitTCompXDao
			getSigitTCompBrRcDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompSrDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompVxDao().customDeleterByCodImpianto(codiceImpianto);

			getSigitTCompVrDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompPoDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompAcDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompTeDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompRvDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompScxDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompCiDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompUtDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompRcDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompVmDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompXDao().customDeleterByCodImpianto(codiceImpianto);

			getSigitTCompGfDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompAgDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompCsDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompCgDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTCompScDao().customDeleterByCodImpianto(codiceImpianto);
			getSigittCompGtDao().customDeleterByCodImpianto(codiceImpianto);

			getSigitRComp4ManutDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTComp4Dao().customDeleterByCodImpianto(codiceImpianto);
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cancellaListaComponentiAll] END");
		}
	}

	private void cancellaListaComponentiGTAll(List<SigitTComp4Dto> componentiCancellate, String cfUtente) throws SigitTComp4DaoException, SigitTCompGtDaoException, SigitRComp4ManutDaoException
	{
		if(componentiCancellate!=null && !componentiCancellate.isEmpty())
		{
			log.debug("ci sono sezioni da cancellare");
			for (SigitTComp4Dto compToDel : componentiCancellate) {

				getSigittCompGtDao().customDeleterByFilter(MapDto.getCompFilter(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_gt",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&progressivo="+compToDel.getProgressivo()));

				getSigitRComp4ManutDao().customDeleterByFilter(MapDto.getSigitrComp4ManutPk(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_r_comp4_manut",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&tipo=GT&&progressivo="+compToDel.getProgressivo()));

				getSigitTComp4Dao().delete(MapDto.getSigittComp4Pk(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&tipi=GT&progressivo="+compToDel.getProgressivo()));


			}
		}
		else
			log.debug("NON ci sono sezioni da cancellare");
	}

	private void cancellaListaComponentiCSAll(List<SigitTComp4Dto> componentiCancellate, String cfUtente) throws SigitTComp4DaoException, SigitTCompCsDaoException
	{
		if(componentiCancellate!=null && !componentiCancellate.isEmpty())
		{
			log.debug("ci sono sezioni da cancellare");
			for (SigitTComp4Dto compToDel : componentiCancellate) {
				//SigitTCompCsPk pkCs = MapDto.getSigitTCompCsPk(compToDel);

				getSigitTCompCsDao().customDeleterByFilter(MapDto.getCompFilter(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_cs",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&tipo="+compToDel.getIdTipoComponente()+"&progressivo="+compToDel.getProgressivo()));

				getSigitTComp4Dao().delete(MapDto.getSigitTComp4Pk(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&tipo="+compToDel.getIdTipoComponente()+"&progressivo="+compToDel.getProgressivo()));


//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_cs",
//						"codice_impianto="+codImpianto+"&progressivo="+compToDel.getProgressivo()+
//						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_cs",
//						"codice_impianto="+codImpianto+"&progressivo="+compToDel.getProgressivo()));
//
//

			}
		}
		else
			log.debug("NON ci sono sezioni da cancellare");
	}

	private void cancellaListaComponentiCS(List<SigitTCompCsDto> componentiCancellate, String cfUtente) throws SigitTComp4DaoException, SigitTCompCsDaoException
	{
		if(componentiCancellate!=null && !componentiCancellate.isEmpty())
		{
			log.debug("ci sono sezioni da cancellare");
			for (SigitTCompCsDto compToDel : componentiCancellate) {

				getSigitTCompCsDao().delete(MapDto.getSigitTCompCSPk(compToDel));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_sc",
//						"codice_impianto="+codImpianto+"&progressivo="+compToDel.getProgressivo()+
//						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_cs",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&progressivo="+compToDel.getProgressivo()+
						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

				//getSigitTComp4Dao().delete(MapDto.getSigittComp4Pk(compToDel));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
//						"codice_impianto="+codImpianto+"&tipo=SC&&progressivo="+compToDel.getProgressivo()+
//						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
//						"codice_impianto="+codImpianto+"&tipo=SC&&progressivo="+compToDel.getProgressivo()));

			}
		}
		else
			log.debug("NON ci sono sezioni da cancellare");
	}
	/**
	 * Restituisce la riga GT con il progressivo specificato dalla lista in input
	 * @param gt
	 * @param progressivo
	 * @return
	 */
	private RowGT getGtFromList(List<RowGT> gt, String progressivo)
	{
		for (RowGT rowGT : gt) {
			if(progressivo.equals(rowGT.getL41NumGT().toString()))
				return rowGT;
		}
		return null;
	}

	/*
	public void consolidaBR(String codImpianto, String cfUtente, List<RowBR> listBr, List<RowGT> gtList) throws DbManagerException
	{
		log.debug("Consolidamento BR");
		try {
			String BR = "BR";
			List<String> progressivi = new ArrayList<String>();
			for (RowBR rowBR : listBr) {
				BigDecimal idImpianto = new BigDecimal(codImpianto);
				String progressivoGt = null;
				try
				{
					progressivoGt = rowBR.getL42NumGT().toString();
				}catch (Exception e) {continue;}
				RowGT gt = getGtFromList(gtList, progressivoGt);
				if(gt==null)
				{
					log.error("Non trovato il GT "+ progressivoGt + " per il BR");
					throw new DbManagerException(new Message("Si e' verificato un errore "));
				}
				SigitTCompBrRcDto compBr = MapDto.getSigitTCompBrRc(rowBR, idImpianto, gt);
				if(GenericUtil.isNullOrEmpty(compBr.getDataInstall()))
					continue;
				BigDecimal progressivoBr = compBr.getProgressivoBrRc();
				progressivi.add(progressivoBr.toString());
				log.debug("progressivo BR: " + progressivoBr+", data inst: " + ConvertUtil.convertToString(compBr.getDataInstall()));

				SigitTCompBrRcDto filterBrRc = new SigitTCompBrRcDto();
				filterBrRc.setCodiceImpianto(idImpianto);
				filterBrRc.setFkTipoComponente("GT");
				//FIX errore consolidamento libretto 02/12/2014
				try {filterBrRc.setFkDataInstall(ConvertUtil.convertToDate(gt.getL41DataInstallaz()));} catch (Exception e) {filterBrRc.setFkDataInstall(null);}
				filterBrRc.setFkProgressivo(ConvertUtil.convertToBigDecimal(gt.getL41NumGT()));
				filterBrRc.setDataInstall(compBr.getDataInstall());
				filterBrRc.setProgressivoBrRc(progressivoBr);
				filterBrRc.setTipologiaBrRc(BR);
				List<SigitTCompBrRcDto> listBrDb = getSigitTCompBrRcDao().findByFilter(filterBrRc);
				if(listBrDb==null || listBrDb.isEmpty())
				{
					log.debug("inserisco nuovo BR");
					getSigitTCompBrRcDao().insert(compBr);
				}
				else
				{
					log.debug("aggiorno BR");
					compBr.setIdCompBrRc(listBrDb.get(0).getIdCompBrRc());
					getSigitTCompBrRcDao().update(compBr);
				}
				List<String> dateInstallazione = new ArrayList<String>();
				dateInstallazione.add(ConvertUtil.convertToString(compBr.getDataInstall()));
				SezBRsostituite brSostituite = rowBR.getSezBRsostituite();
				log.debug("consolidamento BR sostituite");
				if(brSostituite!=null)
					for (RowBRsost rowBRSost : brSostituite.getRowBRsostList()) {
						SigitTCompBrRcDto compBrSost = MapDto.getSigitTCompBrSost(idImpianto, progressivoBr, rowBRSost, gt);
						log.debug("data install: " + ConvertUtil.convertToString(compBrSost.getDataInstall()));
						SigitTCompBrRcDto filterSost = new SigitTCompBrRcDto();
						filterSost.setCodiceImpianto(idImpianto);
						filterSost.setFkProgressivo(ConvertUtil.convertToBigDecimal(gt.getL41NumGT()));
						filterSost.setTipologiaBrRc(BR);
						filterSost.setProgressivoBrRc(progressivoBr);
						filterSost.setDataInstall(compBrSost.getDataInstall());

						List<SigitTCompBrRcDto> brSostList = getSigitTCompBrRcDao().findByFilter(filterSost);
						if(brSostList==null || brSostList.isEmpty())
						{
							log.debug("inserisco br sost");
							getSigitTCompBrRcDao().insert(compBrSost);
						}
						else
						{
							log.debug("aggiorno br sost");
							getSigitTCompBrRcDao().update(compBrSost);
						}
						dateInstallazione.add(ConvertUtil.convertToString(compBrSost.getDataInstall()));
					}
				log.debug("Controllo sezioni BR sost eliminate");
				CompFilter filterBrSost = new CompFilter();
				filterBrSost.setCodImpianto(codImpianto);
				filterBrSost.setProgressivo(progressivoBr.toString());
				filterBrSost.setTipoComponente(BR);
				filterBrSost.setListDateInstallazione(dateInstallazione);
				List<SigitTCompBrRcDto> componentiCancellate = getSigitTCompBrRcDao().findComponentiCancellate(filterBrSost);
				cancellaListaComponentiBrRc(componentiCancellate, cfUtente);
			}
			//eliminazione delle sezioni BR cancellate e le sostituzioni
			log.debug("Controllo sezioni BR eliminate");
			CompFilter filtroBr = new CompFilter();
			filtroBr.setCodImpianto(codImpianto);
			filtroBr.setTipoComponente(BR);
			filtroBr.setListProgressivi(progressivi);
			List<SigitTComp4Dto> componentiCancellate = getSigitTComp4Dao().findComponentiCancellate(filtroBr);

			cancellaListaComponentiBrRcAll(componentiCancellate, cfUtente);
		} catch (SigitTComp4DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitTCompBrRcDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
	}
	*/
	
	/*
	public void consolidaRC(String codImpianto, String cfUtente, List<RowRC> listRc, List<RowGT> gtList) throws DbManagerException
	{
		log.debug("Consolidamento RC");
		try {
			String RC = "RC";
			List<String> progressivi = new ArrayList<String>();
			for (RowRC rowRc : listRc) {
				BigDecimal idImpianto = new BigDecimal(codImpianto);
				String progressivoGt = null;
				try
				{
						progressivoGt = rowRc.getL43NumGT().toString();
				}
				catch(Exception e){
					continue;
				}
				RowGT gt = getGtFromList(gtList, progressivoGt);
				if(gt==null)
				{
					log.error("Non trovato il GT "+ progressivoGt + " per RC");
					throw new DbManagerException(new Message("Si e' verificato un errore "));
				}
				SigitTCompBrRcDto compRc = MapDto.getSigitTCompBrRc(rowRc, idImpianto, gt);
				if(GenericUtil.isNullOrEmpty(compRc.getDataInstall()))
					continue;
				BigDecimal progressivoBr = compRc.getProgressivoBrRc();
				progressivi.add(progressivoBr.toString());
				log.debug("progressivo RC: " + progressivoBr+", data inst: " + ConvertUtil.convertToString(compRc.getDataInstall()));

				SigitTCompBrRcDto filterBrRc = new SigitTCompBrRcDto();
				filterBrRc.setCodiceImpianto(idImpianto);
				filterBrRc.setFkTipoComponente("GT");
				try {filterBrRc.setFkDataInstall(ConvertUtil.convertToDate(gt.getL41DataInstallaz()));} catch (Exception e) {filterBrRc.setFkDataInstall(null);}
				filterBrRc.setFkProgressivo(ConvertUtil.convertToBigDecimal(gt.getL41NumGT()));
				filterBrRc.setDataInstall(compRc.getDataInstall());
				filterBrRc.setProgressivoBrRc(progressivoBr);
				filterBrRc.setTipologiaBrRc(RC);
				List<SigitTCompBrRcDto> listBrDb = getSigitTCompBrRcDao().findByFilter(filterBrRc);
				if(listBrDb==null || listBrDb.isEmpty())
				{
					log.debug("inserisco nuovo RC");
					getSigitTCompBrRcDao().insert(compRc);
				}
				else
				{
					log.debug("aggiorno RC");
					compRc.setIdCompBrRc(listBrDb.get(0).getIdCompBrRc());
					getSigitTCompBrRcDao().update(compRc);
				}
				List<String> dateInstallazione = new ArrayList<String>();
				dateInstallazione.add(ConvertUtil.convertToString(compRc.getDataInstall()));
				SezRCsostituite rcSostituite = rowRc.getSezRCsostituite();
				log.debug("consolidamento RC sotituite");
				if(rcSostituite!=null)
					for (RowRCsost rowRCSost : rcSostituite.getRowRCsostList()) {
						SigitTCompBrRcDto compBrSost = MapDto.getSigitTCompRcSost(idImpianto, progressivoBr, rowRCSost, gt);
						log.debug("data install: " + ConvertUtil.convertToString(compBrSost.getDataInstall()));
						log.debug("GT data install: " + gt.getL41DataInstallaz());
						SigitTCompBrRcDto filterSost = new SigitTCompBrRcDto();
						filterSost.setCodiceImpianto(idImpianto);
						filterSost.setFkProgressivo(ConvertUtil.convertToBigDecimal(gt.getL41NumGT()));
						filterSost.setTipologiaBrRc(RC);
						filterSost.setProgressivoBrRc(progressivoBr);
						filterSost.setDataInstall(compBrSost.getDataInstall());

						List<SigitTCompBrRcDto> brSostList = getSigitTCompBrRcDao().findByFilter(filterSost);
						if(brSostList==null || brSostList.isEmpty())
						{
							log.debug("inserisco RC sost");
							getSigitTCompBrRcDao().insert(compBrSost);
						}
						else
						{
							log.debug("aggiorno RC sost");
							getSigitTCompBrRcDao().update(compBrSost);
						}
						dateInstallazione.add(ConvertUtil.convertToString(compBrSost.getDataInstall()));
					}
				log.debug("Controllo sezioni RC sost eliminate");
				CompFilter filterBrSost = new CompFilter();
				filterBrSost.setCodImpianto(codImpianto);
				filterBrSost.setProgressivo(progressivoBr.toString());
				filterBrSost.setTipoComponente(RC);
				filterBrSost.setListDateInstallazione(dateInstallazione);
				List<SigitTCompBrRcDto> componentiCancellate = getSigitTCompBrRcDao().findComponentiCancellate(filterBrSost);
				cancellaListaComponentiBrRc(componentiCancellate, cfUtente);
			}
			//eliminazione delle sezioni RC cancellate e le sostituzioni
			log.debug("Controllo sezioni RC eliminate");
			CompFilter filtroBr = new CompFilter();
			filtroBr.setCodImpianto(codImpianto);
			filtroBr.setTipoComponente(RC);
			filtroBr.setListProgressivi(progressivi);
			List<SigitTComp4Dto> componentiCancellate = getSigitTComp4Dao().findComponentiCancellate(filtroBr);

			cancellaListaComponentiBrRcAll(componentiCancellate, cfUtente);

		} catch (SigitTComp4DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitTCompBrRcDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
	}
	*/

	private void cancellaListaComponentiBrRc(List<SigitTCompBrRcDto> componentiCancellate, String cfUtente) throws SigitTCompBrRcDaoException
	{
		if(componentiCancellate!=null && !componentiCancellate.isEmpty())
		{
			log.debug("ci sono sezioni BR_RC da cancellare");
			for (SigitTCompBrRcDto compToDel : componentiCancellate) {
				SigitTCompBrRcPk pk = MapDto.getSigitTCompBrBc(compToDel);

				getSigitTCompBrRcDao().delete(pk);

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_br_rc",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&tipo="+compToDel.getTipologiaBrRc()+"&progressivo="+compToDel.getFkProgressivo()+
						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));
			}
		}
		else
			log.debug("NON ci sono sezioni BR_RC da cancellare");
	}

	private void cancellaListaComponentiBrRcAll(List<SigitTComp4Dto> componentiCancellate, String cfUtente) throws SigitTCompBrRcDaoException, SigitTComp4DaoException
	{
		if(componentiCancellate!=null && !componentiCancellate.isEmpty())
		{
			log.debug("ci sono sezioni BR_RC da cancellare");
			for (SigitTComp4Dto compToDel : componentiCancellate) {
				//SigitTCompBrRcPk pk = MapDto.getSigitTCompBrBc(compToDel);

				getSigitTCompBrRcDao().customDeleterByFilterComp(MapDto.getCompFilter(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_br_rc",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&tipo="+compToDel.getIdTipoComponente()+"&progressivo="+compToDel.getProgressivo()));

				getSigitTComp4Dao().delete(MapDto.getSigittComp4Pk(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&tipi="+compToDel.getIdTipoComponente()+"&progressivo="+compToDel.getProgressivo()));
			}
		}
		else
			log.debug("NON ci sono sezioni BR_RC da cancellare");
	}

	/*
	public void consolidaGF(String codImpianto, String cfUtente, List<RowGF> listGf, Integer idPersonaGiuridica) throws DbManagerException
	{
		log.debug("Consolidamento GF");
		List<String> progressivi = new ArrayList<String>();
		try {
			// Devo recuperare nuovamente la data controllo per fare della verifiche
			List<SigitVSk4GfDto> comSk4GfImpianto = getCompSk4Gf(ConvertUtil.convertToInteger(codImpianto));

			String GF = "GF";
			for (RowGF rowGF : listGf) {
				BigDecimal idImpianto = new BigDecimal(codImpianto);
				SigitTComp4Dto comp4 = MapDto.getSigitTComp4(idImpianto, rowGF);
				SigitTCompGfDto compGf = MapDto.getSigitTCompGF(idImpianto, rowGF, cfUtente);
				if(GenericUtil.isNullOrEmpty(compGf.getDataInstall()))
					continue;
				BigDecimal progressivo = comp4.getProgressivo();
				progressivi.add(progressivo.toString());

				// E' UNA VERIFICA - inizio
				verificaDataFineCompGF(rowGF, comSk4GfImpianto, codImpianto, progressivo);
				// E' UNA VERIFICA - fine

//				comp4.setUtenteUltMod(cfUtente);
//				comp4.setDataUltMod(DateUtil.getSqlDataCorrente());
//				log.debug("progressivo: " + progressivo+", data inst: "+ConvertUtil.convertToString(comp4.getDataInstall()));
				log.debug("progressivo: " + progressivo);



				SigitTCompGfPk pkCompGf = new SigitTCompGfPk();
				pkCompGf.setCodiceImpianto(idImpianto);
				pkCompGf.setDataInstall(compGf.getDataInstall());
				pkCompGf.setIdTipoComponente(GF);
				pkCompGf.setProgressivo(progressivo);



				SigitTComp4Pk pkComp4 = new SigitTComp4Pk();
				pkComp4.setCodiceImpianto(pkCompGf.getCodiceImpianto());
				pkComp4.setIdTipoComponente(pkCompGf.getIdTipoComponente());
				pkComp4.setProgressivo(pkCompGf.getProgressivo());

				// Vuol dire che sul db non esisteva questa componente (es. GF1)
				if(getSigitTComp4Dao().findByPrimaryKey(pkComp4)==null)
				{
					getSigitTComp4Dao().insert(comp4);

				}

				if(getSigitTCompGfDao().findByPrimaryKey(pkCompGf)==null)
				{
					log.debug("inserisco GF");
					getSigitTCompGfDao().insert(compGf);
				}
				else
				{

					log.debug("aggiorno GF");
					getSigitTCompGfDao().update(compGf);

				}

				SigitRComp4ManutDto comp4ManutFilter = new SigitRComp4ManutDto();
				comp4ManutFilter.setCodiceImpianto(pkCompGf.getCodiceImpianto());
				comp4ManutFilter.setIdTipoComponente(pkCompGf.getIdTipoComponente());
				comp4ManutFilter.setProgressivo(pkCompGf.getProgressivo());


				List<SigitRComp4ManutDto> comp4ManutList = getSigitRComp4ManutDao().findAttiviByFilter(comp4ManutFilter);

				log.debug("STAMPO comp4ManutList: "+comp4ManutList);

				if(comp4ManutList == null || comp4ManutList.size() == 0)
				{
					SigitRComp4ManutDto comp4Manut = MapDto.getSigitRComp4Manut(idImpianto, rowGF, idPersonaGiuridica, it.csi.sigit.sigitwebn.business.dao.util.Constants.ID_RUOLO_MANUTENTORE_ALL_2, cfUtente);
					getSigitRComp4ManutDao().insert(comp4Manut);
				}

				List<String> dateInstallazione = new ArrayList<String>();
				dateInstallazione.add(ConvertUtil.convertToString(compGf.getDataInstall()));
				SezGFsostituite gfSostituite = rowGF.getSezGFsostituite();
				log.debug("consolodamento GF sotituite");
				if(gfSostituite!=null)
				for (RowGFsost rowGFSost : gfSostituite.getRowGFsostList()) {

					// E' UNA VERIFICA - inizio
					verificaDataFineCompGFSost(rowGFSost, comSk4GfImpianto, codImpianto, progressivo);
					// E' UNA VERIFICA - fine

					SigitTCompGfDto compGfSost = MapDto.getSigitTCompGFSost(idImpianto, rowGFSost, progressivo, cfUtente);

					if(getSigitTCompGfDao().findByPrimaryKey(MapDto.getSigittCompGfPk(compGfSost))==null)
					{
						log.debug("inserisco GF sost");

						getSigitTCompGfDao().insert(compGfSost);
					}
					else
					{
						log.debug("aggiorno GF sost");

						getSigitTCompGfDao().update(compGfSost);
					}
					dateInstallazione.add(ConvertUtil.convertToString(compGfSost.getDataInstall()));
				}
				log.debug("Controllo sezioni GF sost eliminate");
				CompFilter filter = new CompFilter();
				filter.setCodImpianto(codImpianto);
				filter.setProgressivo(progressivo.toString());
				filter.setTipoComponente(GF);
				filter.setListDateInstallazione(dateInstallazione);
				// Mi faccio dare tutte le componenti di un progressivo (es. GF1) non presenti nel modulo (ciclo per le date installazione)
				List<SigitTCompGfDto> componentiCancellate = getSigitTCompGfDao().findComponentiCancellate(filter);
				cancellaListaComponentiGF(componentiCancellate, cfUtente);
			}
			//eliminazione delle sezioni GF cancellate e le sostituzioni
			log.debug("Controllo sezioni GF eliminate");
			CompFilter filtro = new CompFilter();
			filtro.setCodImpianto(codImpianto);
			filtro.setTipoComponente(GF);
			filtro.setListProgressivi(progressivi);
			// Mi faccio dare tutte le componenti GF non presenti nel modulo (ciclo per i progressivi)
			List<SigitTComp4Dto> componentiGFCancellate = getSigitTComp4Dao().findComponentiCancellate(filtro);

			cancellaListaComponentiGFAll(componentiGFCancellate, cfUtente);

		} catch (SigitTComp4DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitRComp4ManutDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitTCompGfDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitVSk4GfDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitTAzioneComp4DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		//aggiornare record della tabella: SIGIT_R_IMP_RUOLO_PFPG
		//aggiornaRuoloPfpg(progressivi, codImpianto, idPersonaGiuridica, cfUtente, it.csi.sigit.sigitwebn.business.dao.util.Constants.ID_RUOLO_MANUTENTORE_ALL_2);

	}
	*/
	private void cancellaListaComponentiGF(List<SigitTCompGfDto> componentiCancellate, String cfUtente) throws SigitTCompGfDaoException, SigitTAzioneComp4DaoException
	{
		if(componentiCancellate!=null && !componentiCancellate.isEmpty())
		{
			log.debug("ci sono sezioni da cancellare");
			for (SigitTCompGfDto compToDel : componentiCancellate) {

//				getSigitTCompGfDao().delete(MapDto.getSigittCompGfPk(compToDel));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_gf",
//						"codice_impianto="+codImpianto+"&progressivo="+compToDel.getProgressivo()+
//						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_gf",
//						"codice_impianto="+codImpianto+"&progressivo="+compToDel.getProgressivo()));
//
//				getSigitTComp4Dao().delete(MapDto.getSigittComp4Pk(compToDel));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
//						"codice_impianto="+codImpianto+"&tipo=GF&progressivo="+compToDel.getProgressivo()+
//						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
//						"codice_impianto="+codImpianto+"&tipo=GF&progressivo="+compToDel.getProgressivo()));

				getSigitTAzioneComp4Dao().customDeleterByComp4(new SigitTComp4Pk(compToDel.getCodiceImpianto(), Constants.TIPO_COMPONENTE_GF, compToDel.getProgressivo()));

				getSigitTCompGfDao().delete(MapDto.getSigittCompGfPk(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_gf",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&progressivo="+compToDel.getProgressivo()+
						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_gf",
//						"codice_impianto="+codImpianto+"&progressivo="+compToDel.getProgressivo()));

			}
		}
		else
			log.debug("NON ci sono sezioni da cancellare");
	}

	private void cancellaListaComponentiGFAll(List<SigitTComp4Dto> componentiCancellate, String cfUtente) throws SigitTComp4DaoException, SigitRComp4ManutDaoException, SigitTCompGfDaoException
	{
		if(componentiCancellate!=null && !componentiCancellate.isEmpty())
		{
			log.debug("ci sono sezioni da cancellare");
			for (SigitTComp4Dto compToDel : componentiCancellate) {


				getSigitTCompGfDao().customDeleterByFilter(MapDto.getCompFilter(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_gf",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&progressivo="+compToDel.getProgressivo()));

				getSigitRComp4ManutDao().customDeleterByFilter(MapDto.getSigitrComp4ManutPk(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_r_comp4_manut",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&tipo="+compToDel.getIdTipoComponente()+"&&progressivo="+compToDel.getProgressivo()));

				getSigitTComp4Dao().delete(MapDto.getSigittComp4Pk(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&tipi="+compToDel.getIdTipoComponente()+"&progressivo="+compToDel.getProgressivo()));

			}
		}
		else
			log.debug("NON ci sono sezioni da cancellare");
	}

	private void cancellaListaComponentiSC(List<SigitTCompScDto> componentiCancellate, String cfUtente) throws SigitTComp4DaoException, SigitTCompScDaoException, SigitTAzioneComp4DaoException
	{
		if(componentiCancellate!=null && !componentiCancellate.isEmpty())
		{
			log.debug("ci sono sezioni da cancellare");
			for (SigitTCompScDto compToDel : componentiCancellate) {

				getSigitTAzioneComp4Dao().customDeleterByComp4(new SigitTComp4Pk(compToDel.getCodiceImpianto(), Constants.TIPO_COMPONENTE_SC, compToDel.getProgressivo()));

				getSigitTCompScDao().delete(MapDto.getSigitTCompSCPk(compToDel));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_sc",
//						"codice_impianto="+codImpianto+"&progressivo="+compToDel.getProgressivo()+
//						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_sc",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&progressivo="+compToDel.getProgressivo()+
						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

				//getSigitTComp4Dao().delete(MapDto.getSigittComp4Pk(compToDel));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
//						"codice_impianto="+codImpianto+"&tipo=SC&&progressivo="+compToDel.getProgressivo()+
//						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
//						"codice_impianto="+codImpianto+"&tipo=SC&&progressivo="+compToDel.getProgressivo()));

			}
		}
		else
			log.debug("NON ci sono sezioni da cancellare");
	}

	private void cancellaListaComponentiSCAll(List<SigitTComp4Dto> componentiCancellate, String cfUtente) throws SigitRComp4ManutDaoException, SigitTComp4DaoException, SigitTCompScDaoException
	{
		if(componentiCancellate!=null && !componentiCancellate.isEmpty())
		{
			log.debug("ci sono sezioni da cancellare");
			for (SigitTComp4Dto compToDel : componentiCancellate) {

				getSigitTCompScDao().customDeleterByFilter(MapDto.getCompFilter(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_sc",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&progressivo="+compToDel.getProgressivo()));

				getSigitRComp4ManutDao().customDeleterByFilter(MapDto.getSigitrComp4ManutPk(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_r_comp4_manut",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&tipo="+compToDel.getIdTipoComponente()+"&progressivo="+compToDel.getProgressivo()));

				getSigitTComp4Dao().delete(MapDto.getSigittComp4Pk(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&tipi="+compToDel.getIdTipoComponente()+"&progressivo="+compToDel.getProgressivo()));


			}
		}
		else
			log.debug("NON ci sono sezioni da cancellare");
	}

	/*
	public void consolidaSC(String codImpianto, String cfUtente, List<RowSC> listSc, Integer idPersonaGiuridica) throws DbManagerException
	{
		log.debug("Consolidamento SC");
		List<String> progressivi = new ArrayList<String>();
		try {
			// Devo recuperare nuovamente la data controllo per fare della verifiche
			List<SigitVSk4ScDto> comSk4ScImpianto = getCompSk4Sc(ConvertUtil.convertToInteger(codImpianto));

			String SC = "SC";
			for (RowSC rowSC : listSc) {
				BigDecimal idImpianto = new BigDecimal(codImpianto);
				SigitTComp4Dto comp4 = MapDto.getSigitTComp4(idImpianto, rowSC);
				SigitTCompScDto compScDto = MapDto.getSigitTCompSc(idImpianto, rowSC, cfUtente);
				if(GenericUtil.isNullOrEmpty(compScDto.getDataInstall()))
					continue;
				BigDecimal progressivo = comp4.getProgressivo();
				progressivi.add(progressivo.toString());

				// E' UNA VERIFICA - inizio
				verificaDataFineCompSC(rowSC, comSk4ScImpianto, codImpianto, progressivo);
				// E' UNA VERIFICA - fine

//				comp4.setUtenteUltMod(cfUtente);
//				comp4.setDataUltMod(DateUtil.getSqlDataCorrente());
				log.debug("progressivo: " + progressivo + ", data inst: " + ConvertUtil.convertToString(compScDto.getDataInstall()));

				SigitTCompScPk pkCompSc = new SigitTCompScPk();
				pkCompSc.setCodiceImpianto(idImpianto);
				pkCompSc.setDataInstall(compScDto.getDataInstall());
				pkCompSc.setIdTipoComponente(SC);
				pkCompSc.setProgressivo(progressivo);

				SigitTComp4Pk pkComp4 = new SigitTComp4Pk();
				pkComp4.setCodiceImpianto(pkCompSc.getCodiceImpianto());
				pkComp4.setIdTipoComponente(pkCompSc.getIdTipoComponente());
				pkComp4.setProgressivo(pkCompSc.getProgressivo());

				// Vuol dire che sul db non esisteva questa componente (es. SC1)
				if(getSigitTComp4Dao().findByPrimaryKey(pkComp4)==null)
				{
					getSigitTComp4Dao().insert(comp4);

				}



				if(getSigitTCompScDao().findByPrimaryKey(pkCompSc)==null)
				{
					log.debug("inserisco SC");
					getSigitTCompScDao().insert(compScDto);
				}
				else
				{

					log.debug("aggiorno SC");
					getSigitTCompScDao().update(compScDto);

				}


				SigitRComp4ManutDto comp4ManutFilter = new SigitRComp4ManutDto();
				comp4ManutFilter.setCodiceImpianto(pkCompSc.getCodiceImpianto());
				comp4ManutFilter.setIdTipoComponente(pkCompSc.getIdTipoComponente());
				comp4ManutFilter.setProgressivo(pkCompSc.getProgressivo());


				List<SigitRComp4ManutDto> comp4ManutList = getSigitRComp4ManutDao().findAttiviByFilter(comp4ManutFilter);

				log.debug("STAMPO comp4ManutList: "+comp4ManutList);

				if(comp4ManutList == null || comp4ManutList.size() == 0)
				{
					SigitRComp4ManutDto comp4Manut = MapDto.getSigitRComp4Manut(idImpianto, rowSC, idPersonaGiuridica, it.csi.sigit.sigitwebn.business.dao.util.Constants.ID_RUOLO_MANUTENTORE_ALL_3, cfUtente);
					getSigitRComp4ManutDao().insert(comp4Manut);
				}

				List<String> dateInstallazione = new ArrayList<String>();
				dateInstallazione.add(ConvertUtil.convertToString(compScDto.getDataInstall()));
				SezSCsostituite scSostituite = rowSC.getSezSCsostituite();
				log.debug("consolodamento SC sotituite");
				if(scSostituite!=null)
				for (RowSCsost rowSCSost : scSostituite.getRowSCsostList()) {

					// E' UNA VERIFICA - inizio
					verificaDataFineCompSCSost(rowSCSost, comSk4ScImpianto, codImpianto, progressivo);
					// E' UNA VERIFICA - fine

					SigitTCompScDto compSCSost = MapDto.getSigitTCompScSost(idImpianto, rowSCSost, progressivo, cfUtente);

					if(getSigitTCompScDao().findByPrimaryKey(MapDto.getSigitTCompSCPk(compSCSost))==null)
					{
						log.debug("inserisco SC sost");

						getSigitTCompScDao().insert(compSCSost);
					}
					else
					{
						log.debug("aggiorno SC sost");
						getSigitTCompScDao().update(compSCSost);
					}
					dateInstallazione.add(ConvertUtil.convertToString(compSCSost.getDataInstall()));
				}
				log.debug("Controllo sezioni eliminate");
				CompFilter filter = new CompFilter();
				filter.setCodImpianto(codImpianto);
				filter.setProgressivo(progressivo.toString());
				filter.setTipoComponente(SC);
				filter.setListDateInstallazione(dateInstallazione);

				// Mi faccio dare tutte le componenti di un progressivo (es. SC1) non presenti nel modulo (ciclo per le date installazione)
				List<SigitTCompScDto> componentiCancellate = getSigitTCompScDao().findComponentiCancellate(filter);
				cancellaListaComponentiSC(componentiCancellate, cfUtente);
			}
			//eliminazione delle sezioni SC cancellate e le sostituzioni
			log.debug("Controllo sezioni SC eliminate");
			CompFilter filtro = new CompFilter();
			filtro.setCodImpianto(codImpianto);
			filtro.setTipoComponente(SC);
			filtro.setListProgressivi(progressivi);
			// Mi faccio dare tutte le componenti SC non presenti nel modulo (ciclo per i progressivi)
			List<SigitTComp4Dto> componentiSCCancellate = getSigitTComp4Dao().findComponentiCancellate(filtro);

			//cancellazione SC eliminate dal pdf
			cancellaListaComponentiSCAll(componentiSCCancellate, cfUtente);
		} catch (SigitTComp4DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitRComp4ManutDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitTCompScDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitVSk4ScDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitTAzioneComp4DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		//aggiornare record della tabella: SIGIT_R_IMP_RUOLO_PFPG
		//aggiornaRuoloPfpg(progressivi, codImpianto, idPersonaGiuridica, cfUtente, it.csi.sigit.sigitwebn.business.dao.util.Constants.ID_RUOLO_MANUTENTORE_ALL_3);

	}
	*/
	/*
	public void consolidaCS(String codImpianto, String cfUtente, List<RowCS> listCs) throws DbManagerException
	{
		log.debug("Consolidamento CS");
		List<String> progressivi = new ArrayList<String>();

		try {
			String CS = "CS";
			//eliminazione delle sezioni CS cancellate e le sostituzioni

			for (RowCS rowCS : listCs) {
				BigDecimal idImpianto = new BigDecimal(codImpianto);
				SigitTCompCsDto compCsDto = MapDto.getSigitTCompCsDto(idImpianto, rowCS, cfUtente);
				if(GenericUtil.isNullOrEmpty(compCsDto.getDataInstall()))
					continue;
				BigDecimal progressivo = compCsDto.getProgressivo();
				progressivi.add(progressivo.toString());

				// E' UNA VERIFICA - inizio
				verificaDataFineCompCS(rowCS, codImpianto, progressivo);
				// E' UNA VERIFICA - fine

				log.debug("progressivo: " + progressivo);

				SigitTComp4Pk pkComp4 = new SigitTComp4Pk();
				pkComp4.setCodiceImpianto(compCsDto.getCodiceImpianto());
				pkComp4.setIdTipoComponente(compCsDto.getIdTipoComponente());
				pkComp4.setProgressivo(compCsDto.getProgressivo());

				// Vuol dire che sul db non esisteva questa componente (es. CS1)
				if(getSigitTComp4Dao().findByPrimaryKey(pkComp4)==null)
				{
					SigitTComp4Dto comp4 = MapDto.getSigitTComp4(idImpianto, rowCS);
					getSigitTComp4Dao().insert(comp4);

				}

				//CS
				if(getSigitTCompCsDao().findByPrimaryKey(compCsDto)==null)
				{
					log.debug("inserisco CS");
					getSigitTCompCsDao().insert(compCsDto);
				}
				else
				{

					log.debug("aggiorno CS");
					//getSigitTComp4Dao().update(comp4);
					getSigitTCompCsDao().update(compCsDto);

				}

				List<String> dateInstallazione = new ArrayList<String>();
				dateInstallazione.add(ConvertUtil.convertToString(compCsDto.getDataInstall()));
				SezCSvariate sezCSvariate = rowCS.getSezCSvariate();
				if(sezCSvariate!=null)
				{
					List<RowCSvar> csVarList = sezCSvariate.getRowCSvarList();
					if(csVarList!=null)
					for(RowCSvar csVar : csVarList)
					{

						// E' UNA VERIFICA - inizio
						verificaDataFineCompCSSost(csVar, codImpianto, progressivo);
						// E' UNA VERIFICA - fine


						SigitTCompCsDto csVarDto = MapDto.getSigitTCompCsDto(idImpianto, csVar, progressivo, cfUtente);

						if(getSigitTCompCsDao().findByPrimaryKey(MapDto.getSigitTCompCSPk(csVarDto))==null)
						{
							log.debug("inserisco CS sost");

							getSigitTCompCsDao().insert(csVarDto);
						}
						else
						{
							log.debug("aggiorno CS sost");
							getSigitTCompCsDao().update(csVarDto);
						}
						dateInstallazione.add(ConvertUtil.convertToString(csVarDto.getDataInstall()));



					}

					log.debug("Controllo sezioni eliminate");
					CompFilter filter = new CompFilter();
					filter.setCodImpianto(codImpianto);
					filter.setProgressivo(progressivo.toString());
					filter.setTipoComponente(CS);
					filter.setListDateInstallazione(dateInstallazione);

					// Mi faccio dare tutte le componenti di un progressivo (es. CS1) non presenti nel modulo (ciclo per le date installazione)
					List<SigitTCompCsDto> componentiCancellate = getSigitTCompCsDao().findComponentiCancellate(filter);
					cancellaListaComponentiCS(componentiCancellate, cfUtente);
				}
				else
					log.debug("Nessuna variazione CS");
			}

			log.debug("Eliminazione sezioni CS esistenti");
			CompFilter filtro = new CompFilter();
			filtro.setCodImpianto(codImpianto);
			filtro.setTipoComponente(CS);
			filtro.setListProgressivi(progressivi);

			// Mi faccio dare tutte le componenti CS non presenti nel modulo (ciclo per i progressivi)
			List<SigitTComp4Dto> componentiCSCancellate = getSigitTComp4Dao().findComponentiCancellate(filtro);

			cancellaListaComponentiCSAll(componentiCSCancellate, cfUtente);

		} catch (SigitTComp4DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitTCompCsDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
	}
	*/

	/*
	public void consolidaCG(String codImpianto, String cfUtente, List<RowCG> listCg, Integer idPersonaGiuridica) throws DbManagerException
	{
		log.debug("Consolidamento CG");
		List<String> progressivi = new ArrayList<String>();
		try {
			// Devo recuperare nuovamente la data controllo per fare della verifiche
			List<SigitVSk4CgDto> comSk4CgImpianto = getCompSk4Cg(ConvertUtil.convertToInteger(codImpianto));

			String CG = "CG";
			for (RowCG rowCG : listCg) {
				BigDecimal idImpianto = new BigDecimal(codImpianto);
				SigitTComp4Dto comp4 = MapDto.getSigitTComp4(idImpianto, rowCG);
				SigitTCompCgDto compCg = MapDto.getSigitTCompCg(idImpianto, rowCG, cfUtente);
				if(GenericUtil.isNullOrEmpty(compCg.getDataInstall()))
					continue;
				BigDecimal progressivo = comp4.getProgressivo();
				progressivi.add(progressivo.toString());

				// E' UNA VERIFICA - inizio
				verificaDataFineCompCG(rowCG, comSk4CgImpianto, codImpianto, progressivo);
				// E' UNA VERIFICA - fine

				log.debug("progressivo: " + progressivo+", data inst: "+ConvertUtil.convertToString(compCg.getDataInstall()));

				SigitTCompCgPk pkCompCg = new SigitTCompCgPk();
				pkCompCg.setCodiceImpianto(idImpianto);
				pkCompCg.setDataInstall(compCg.getDataInstall());
				pkCompCg.setIdTipoComponente(CG);
				pkCompCg.setProgressivo(progressivo);



				SigitTComp4Pk pkComp4 = new SigitTComp4Pk();
				pkComp4.setCodiceImpianto(pkCompCg.getCodiceImpianto());
				pkComp4.setIdTipoComponente(pkCompCg.getIdTipoComponente());
				pkComp4.setProgressivo(pkCompCg.getProgressivo());

				// Vuol dire che sul db non esisteva questa componente (es. CG1)
				if(getSigitTComp4Dao().findByPrimaryKey(pkComp4)==null)
				{
					getSigitTComp4Dao().insert(comp4);

				}


				if(getSigitTCompCgDao().findByPrimaryKey(pkCompCg)==null)
				{
					log.debug("inserisco CG");
					getSigitTCompCgDao().insert(compCg);
				}
				else
				{

					log.debug("aggiorno CG");
					getSigitTCompCgDao().update(compCg);

				}


				SigitRComp4ManutDto comp4ManutFilter = new SigitRComp4ManutDto();
				comp4ManutFilter.setCodiceImpianto(pkCompCg.getCodiceImpianto());
				comp4ManutFilter.setIdTipoComponente(pkCompCg.getIdTipoComponente());
				comp4ManutFilter.setProgressivo(pkCompCg.getProgressivo());


				List<SigitRComp4ManutDto> comp4ManutList = getSigitRComp4ManutDao().findAttiviByFilter(comp4ManutFilter);

				log.debug("STAMPO comp4ManutList: "+comp4ManutList);

				if(comp4ManutList == null || comp4ManutList.size() == 0)
				{
					SigitRComp4ManutDto comp4Manut = MapDto.getSigitRComp4Manut(idImpianto, rowCG, idPersonaGiuridica, it.csi.sigit.sigitwebn.business.dao.util.Constants.ID_RUOLO_MANUTENTORE_ALL_4, cfUtente);
					getSigitRComp4ManutDao().insert(comp4Manut);
				}

				List<String> dateInstallazione = new ArrayList<String>();
				dateInstallazione.add(ConvertUtil.convertToString(compCg.getDataInstall()));
				SezCGsostituite gfSostituite = rowCG.getSezCGsostituite();
				log.debug("consolodamento CG sotituite");
				if(gfSostituite!=null)
				for (RowCGsost rowCGSost : gfSostituite.getRowCGsostList()) {

					// E' UNA VERIFICA - inizio
					verificaDataFineCompCGSost(rowCGSost, comSk4CgImpianto, codImpianto, progressivo);
					// E' UNA VERIFICA - fine


					SigitTCompCgDto compCgSost = MapDto.getSigitTCompCgSost(idImpianto, rowCGSost, progressivo, cfUtente);

					if(getSigitTCompCgDao().findByPrimaryKey(MapDto.getSigittCompCgPk(compCgSost))==null)
					{
						log.debug("inserisco CG sost");

						getSigitTCompCgDao().insert(compCgSost);
						//XX INSERT COMP4MANUT mantenendo l'id_persona_giuridica vecchia

					}
					else
					{
						log.debug("aggiorno CG sost");

						getSigitTCompCgDao().update(compCgSost);
						//XX UPDATE COMP4MANUT, mantenendo l'id_persona_giuridica vecchia

					}
					dateInstallazione.add(ConvertUtil.convertToString(compCgSost.getDataInstall())); //VERIFICARE GLI ALTRI!!!!!!
				}
				log.debug("Controllo sezioni eliminate");
				CompFilter filter = new CompFilter();
				filter.setCodImpianto(codImpianto);
				filter.setProgressivo(progressivo.toString());
				filter.setTipoComponente(CG);
				filter.setListDateInstallazione(dateInstallazione);
				// Mi faccio dare tutte le componenti di un progressivo (es. CG1) non presenti nel modulo (ciclo per le date installazione)
				List<SigitTCompCgDto> componentiCancellate = getSigitTCompCgDao().findComponentiCancellate(filter);
				cancellaListaComponentiCG(componentiCancellate, cfUtente);
			}
			//eliminazione delle sezioni CG cancellate e le sostituzioni
			log.debug("Controllo sezioni CG eliminate");
			CompFilter filtro = new CompFilter();
			filtro.setCodImpianto(codImpianto);
			filtro.setTipoComponente(CG);
			filtro.setListProgressivi(progressivi);

			// Mi faccio dare tutte le componenti CG non presenti nel modulo (ciclo per i progressivi)
			List<SigitTComp4Dto> componentiCGCancellate = getSigitTComp4Dao().findComponentiCancellate(filtro);

			//cancellazione CG eliminate dal pdf
			cancellaListaComponentiCGAll(componentiCGCancellate, cfUtente);
		} catch (SigitTComp4DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitRComp4ManutDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitTCompCgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitVSk4CgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitTAzioneComp4DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		//aggiornare record della tabella: SIGIT_R_IMP_RUOLO_PFPG
		//XXX potenzialmente e' da commentare
		//aggiornaRuoloPfpg(progressivi, codImpianto, idPersonaGiuridica, cfUtente, it.csi.sigit.sigitwebn.business.dao.util.Constants.ID_RUOLO_MANUTENTORE_ALL_4);

	}
	*/

	@Transactional
	public void cancellaComponenteCG(CompFilter filtroDaCancellare, String cfUtente) throws DbManagerException {

		log.debug("[DbMgr::cancellaComponenteCG] START");
		try
		{
			SigitTCompCgDto compCg = new SigitTCompCgDto();
			compCg.setCodiceImpianto(ConvertUtil.convertToBigDecimal(filtroDaCancellare.getCodImpianto()));
			compCg.setProgressivo(ConvertUtil.convertToBigDecimal(filtroDaCancellare.getProgressivo()));

			cancellaListaComponentiCG(Arrays.asList(compCg), cfUtente);

			filtroDaCancellare.setTipoComponente(Constants.TIPO_COMPONENTE_CG);

			List<SigitTComp4Dto> comp4 = getSigitTComp4Dao().findComponentiCancellate(filtroDaCancellare);
			cancellaListaComponentiCGAll(comp4, cfUtente);
		} catch (Exception e) {
			log.error("Errore: ",e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(new Message(Messages.ERROR_INSERT_DB));
		}
		finally
		{
			log.debug("[DbMgr::cancellaComponenteCG] END");
		}
	}

	@Transactional
	public void cancellaComponenteGT(CompFilter filtroDaCancellare, String cfUtente) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponenteGT] START");
		try
		{
			SigitTCompGtDto compGt = new SigitTCompGtDto();
			compGt.setCodiceImpianto(ConvertUtil.convertToBigDecimal(filtroDaCancellare.getCodImpianto()));
			compGt.setProgressivo(ConvertUtil.convertToBigDecimal(filtroDaCancellare.getProgressivo()));

			cancellaListaComponentiGT(Arrays.asList(compGt), cfUtente);

			filtroDaCancellare.setTipoComponente(Constants.TIPO_COMPONENTE_GT);

			List<SigitTComp4Dto> comp4 = getSigitTComp4Dao().findComponentiCancellate(filtroDaCancellare);
			cancellaListaComponentiGTAll(comp4, cfUtente);
		} catch (Exception e) {
			log.error("Errore: ",e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(new Message(Messages.ERROR_INSERT_DB));
		}
		finally
		{
			log.debug("[DbMgr::cancellaComponenteGT] END");
		}
	}

	@Transactional
	public void cancellaComponenteSC(CompFilter filtroDaCancellare, String cfUtente) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponenteSC] START");
		try
		{
			SigitTCompScDto compSc = new SigitTCompScDto();
			compSc.setCodiceImpianto(ConvertUtil.convertToBigDecimal(filtroDaCancellare.getCodImpianto()));
			compSc.setProgressivo(ConvertUtil.convertToBigDecimal(filtroDaCancellare.getProgressivo()));

			cancellaListaComponentiSC(Arrays.asList(compSc), cfUtente);

			filtroDaCancellare.setTipoComponente(Constants.TIPO_COMPONENTE_SC);

			List<SigitTComp4Dto> comp4 = getSigitTComp4Dao().findComponentiCancellate(filtroDaCancellare);
			cancellaListaComponentiSCAll(comp4, cfUtente);
		} catch (Exception e) {
			log.error("Errore: ",e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(new Message(Messages.ERROR_INSERT_DB));
		}
		finally
		{
			log.debug("[DbMgr::cancellaComponenteSC] END");
		}
	}

	@Transactional
	public void cancellaComponenteGF(CompFilter filtroDaCancellare, String cfUtente) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponenteGF] START");
		try
		{
			SigitTCompGfDto compGf = new SigitTCompGfDto();
			compGf.setCodiceImpianto(ConvertUtil.convertToBigDecimal(filtroDaCancellare.getCodImpianto()));
			compGf.setProgressivo(ConvertUtil.convertToBigDecimal(filtroDaCancellare.getProgressivo()));

			cancellaListaComponentiGF(Arrays.asList(compGf), cfUtente);

			filtroDaCancellare.setTipoComponente(Constants.TIPO_COMPONENTE_GF);

			List<SigitTComp4Dto> comp4 = getSigitTComp4Dao().findComponentiCancellate(filtroDaCancellare);
			cancellaListaComponentiGFAll(comp4, cfUtente);
		} catch (Exception e) {
			log.error("Errore: ",e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(new Message(Messages.ERROR_INSERT_DB));
		}
		finally
		{
			log.debug("[DbMgr::cancellaComponenteGF] END");
		}
	}

	private void cancellaListaComponentiCG(List<SigitTCompCgDto> componentiCancellate, String cfUtente) throws SigitTComp4DaoException, SigitTCompCgDaoException, SigitTAzioneComp4DaoException
	{
		if(componentiCancellate!=null && !componentiCancellate.isEmpty())
		{
			log.debug("ci sono sezioni da cancellare");
			for (SigitTCompCgDto compToDel : componentiCancellate) {

				getSigitTAzioneComp4Dao().customDeleterByComp4(new SigitTComp4Pk(compToDel.getCodiceImpianto(), Constants.TIPO_COMPONENTE_CG, compToDel.getProgressivo()));

				getSigitTCompCgDao().delete(MapDto.getSigittCompCgPk(compToDel));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_cg",
//						"codice_impianto="+codImpianto+"&progressivo="+compToDel.getProgressivo()+
//						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_cg",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&progressivo="+compToDel.getProgressivo()+
						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

				//getSigitTComp4Dao().delete(MapDto.getSigittComp4Pk(compToDel));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
//						"codice_impianto="+codImpianto+"&tipo=CG&&progressivo="+compToDel.getProgressivo()+
//						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
//						"codice_impianto="+codImpianto+"&tipo=CG&&progressivo="+compToDel.getProgressivo()));



			}
		}
		else
			log.debug("NON ci sono sezioni da cancellare");
	}

	private void cancellaListaComponentiCGAll(List<SigitTComp4Dto> componentiCancellate, String cfUtente) throws SigitRComp4ManutDaoException, SigitTComp4DaoException, SigitTCompCgDaoException
	{
		if(componentiCancellate!=null && !componentiCancellate.isEmpty())
		{
			log.debug("ci sono sezioni da cancellare");
			for (SigitTComp4Dto compToDel : componentiCancellate) {

				getSigitTCompCgDao().customDeleterByFilter(MapDto.getCompFilter(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_cg",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&progressivo="+compToDel.getProgressivo()));

				getSigitRComp4ManutDao().customDeleterByFilter(MapDto.getSigitrComp4ManutPk(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_r_comp4_manut",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&tipo="+compToDel.getIdTipoComponente()+"&progressivo="+compToDel.getProgressivo()));

				getSigitTComp4Dao().delete(MapDto.getSigittComp4Pk(compToDel));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&tipi="+compToDel.getIdTipoComponente()+"&progressivo="+compToDel.getProgressivo()));


			}
		}
		else
			log.debug("NON ci sono sezioni da cancellare");
	}

	/*
	public void consolidaAG(String codImpianto, String cfUtente, List<RowAG> listAg) throws DbManagerException
	{
		log.debug("Consolidamento AG");
		List<String> progressivi = new ArrayList<String>();

		try {
			String AG = "AG";
			//eliminazione delle sezioni AG cancellate e le sostituzioni

			for (RowAG rowAG : listAg) {
				BigDecimal idImpianto = new BigDecimal(codImpianto);
				SigitTCompAgDto compAgDto = MapDto.getSigitTCompAg(idImpianto, rowAG, cfUtente);

				if(GenericUtil.isNullOrEmpty(compAgDto.getDataInstall()))
					continue;
				BigDecimal progressivo = compAgDto.getProgressivo();
				progressivi.add(progressivo.toString());

				// E' UNA VERIFICA - inizio
				verificaDataFineCompAG(rowAG, codImpianto, progressivo);
				// E' UNA VERIFICA - fine

				log.debug("progressivo: " + progressivo);


				SigitTComp4Pk pkComp4 = new SigitTComp4Pk();
				pkComp4.setCodiceImpianto(compAgDto.getCodiceImpianto());
				pkComp4.setIdTipoComponente(compAgDto.getIdTipoComponente());
				pkComp4.setProgressivo(compAgDto.getProgressivo());

				// Vuol dire che sul db non esisteva questa componente (es. CS1)
				if(getSigitTComp4Dao().findByPrimaryKey(pkComp4)==null)
				{
					SigitTComp4Dto comp4 = MapDto.getSigitTComp4(idImpianto, rowAG);
					getSigitTComp4Dao().insert(comp4);

				}


				//AG
				if(getSigitTCompAgDao().findByPrimaryKey(compAgDto)==null)
				{
					log.debug("inserisco AG");
					getSigitTCompAgDao().insert(compAgDto);
				}
				else
				{

					log.debug("aggiorno AG");
					//getSigitTComp4Dao().update(comp4);
					getSigitTCompAgDao().update(compAgDto);

				}

				List<String> dateInstallazione = new ArrayList<String>();
				dateInstallazione.add(ConvertUtil.convertToString(compAgDto.getDataInstall()));
				SezAGsostituite agSostituite = rowAG.getSezAGsostituite();
				log.debug("consolodamento AG sotituite");
				if(agSostituite!=null)
				for (RowAGsost rowAGSost : agSostituite.getRowAGsostList()) {

					// E' UNA VERIFICA - inizio
					verificaDataFineCompAGSost(rowAGSost, codImpianto, progressivo);
					// E' UNA VERIFICA - fine

					SigitTCompAgDto compAGSost = MapDto.getSigitTCompAgSost(idImpianto, rowAGSost, progressivo, cfUtente);

					if(getSigitTCompAgDao().findByPrimaryKey(MapDto.getSigitTCompAGPk(compAGSost))==null)
					{
						log.debug("inserisco AG sost");

						getSigitTCompAgDao().insert(compAGSost);
					}
					else
					{
						log.debug("aggiorno AG sost");
						getSigitTCompAgDao().update(compAGSost);
					}
					dateInstallazione.add(ConvertUtil.convertToString(compAGSost.getDataInstall()));
				}
				log.debug("Controllo sezioni eliminate");
				CompFilter filter = new CompFilter();
				filter.setCodImpianto(codImpianto);
				filter.setProgressivo(progressivo.toString());
				filter.setTipoComponente(AG);
				filter.setListDateInstallazione(dateInstallazione);

				// Mi faccio dare tutte le componenti di un progressivo (es. AG1) non presenti nel modulo (ciclo per le date installazione)
				List<SigitTCompAgDto> componentiCancellate = getSigitTCompAgDao().findComponentiCancellate(filter);
				cancellaListaComponentiAG(componentiCancellate, cfUtente);

			}

			log.debug("Eliminazione sezioni AG esistenti");
			CompFilter filtro = new CompFilter();
			filtro.setCodImpianto(codImpianto);
			filtro.setTipoComponente(AG);
			filtro.setListProgressivi(progressivi);

			// Mi faccio dare tutte le componenti AG non presenti nel modulo (ciclo per i progressivi)
			List<SigitTComp4Dto> componentiAGCancellate = getSigitTComp4Dao().findComponentiCancellate(filtro);


			cancellaListaComponentiAGAll(componentiAGCancellate, cfUtente);

		} catch (SigitTComp4DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitTCompAgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
	}
	*/
	private void cancellaListaComponentiAG(List<SigitTCompAgDto> componentiCancellate, String cfUtente) throws SigitTComp4DaoException, SigitTCompAgDaoException
	{
		if(componentiCancellate!=null && !componentiCancellate.isEmpty())
		{
			log.debug("ci sono sezioni da cancellare");
			for (SigitTCompAgDto compToDel : componentiCancellate) {

				getSigitTCompAgDao().delete(MapDto.getSigitTCompAGPk(compToDel));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_sc",
//						"codice_impianto="+codImpianto+"&progressivo="+compToDel.getProgressivo()+
//						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_ag",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&progressivo="+compToDel.getProgressivo()+
						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

				//getSigitTComp4Dao().delete(MapDto.getSigittComp4Pk(compToDel));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
//						"codice_impianto="+codImpianto+"&tipo=SC&&progressivo="+compToDel.getProgressivo()+
//						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
//						"codice_impianto="+codImpianto+"&tipo=SC&&progressivo="+compToDel.getProgressivo()));

			}
		}
		else
			log.debug("NON ci sono sezioni da cancellare");
	}

	private void cancellaListaComponentiAGAll(List<SigitTComp4Dto> componentiCancellate, String cfUtente) throws SigitTComp4DaoException, SigitTCompAgDaoException
	{
		if(componentiCancellate!=null && !componentiCancellate.isEmpty())
		{
			log.debug("ci sono sezioni da cancellare");
			for (SigitTComp4Dto compToDel : componentiCancellate) {

				getSigitTCompAgDao().customDeleterByFilter(MapDto.getCompFilter(compToDel));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_ag",
//						"codice_impianto="+codImpianto+"&progressivo="+compToDel.getProgressivo()+
//						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_ag",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&progressivo="+compToDel.getProgressivo()));

				getSigitTComp4Dao().delete(MapDto.getSigitTComp4Pk(compToDel));

//				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
//						"codice_impianto="+codImpianto+"&tipo=AG&progressivo="+compToDel.getProgressivo()+
//						"&dataInst="+ConvertUtil.convertToString(compToDel.getDataInstall())));

				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
						"codice_impianto="+compToDel.getCodiceImpianto()+"&tipo="+compToDel.getIdTipoComponente()+"&progressivo="+compToDel.getProgressivo()));
			}
		}
		else
			log.debug("NON ci sono sezioni da cancellare");
	}


	/*
	private void aggiornaRuoloPfpg(List<String> progressivi, String codImpianto, Integer idPersonaGiuridica, String cfUtente, int idRuolo) throws DbManagerException
	{
		log.debug("aggiornamento ruolo da SIGIT_R_IMP_RUOLO_PFPG per il ruolo: " + idRuolo);
		try {
			if(progressivi.isEmpty())
			{
				log.debug("Cancellazione ruolo " + idRuolo + " da SIGIT_R_IMP_RUOLO_PFPG");
				//cancelliamo tutti
				SigitRImpRuoloPfpgDto filter = new SigitRImpRuoloPfpgDto();
				filter.setCodiceImpianto(new BigDecimal(codImpianto));
				filter.setFkRuolo(new BigDecimal(idRuolo));
				getSigitRImpRuoloPfpgDao().customDeleterByFilter(filter);
				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_r_imp_ruolo_pfpg", "codice_impianto="+codImpianto+"&idRuolo="+idRuolo));
			}
			else
			{
				log.debug("aggiornamento/inserimento ruolo da SIGIT_R_IMP_RUOLO_PFPG");
				SigitRImpRuoloPfpgDto filterRuolo = new SigitRImpRuoloPfpgDto();
				filterRuolo.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
				filterRuolo.setFkRuolo(new BigDecimal(idRuolo));
				List<SigitRImpRuoloPfpgDto> manAttivi = getSigitRImpRuoloPfpgDao().findAttiviByFilter(filterRuolo);
				if(manAttivi==null || manAttivi.isEmpty())
				{
					log.debug("Inserisco ruolo attivo");
					SigitRImpRuoloPfpgDto ruoloNew = new SigitRImpRuoloPfpgDto();
					ruoloNew.setCodiceImpianto(new BigDecimal(codImpianto));
					ruoloNew.setDataInizio(DateUtil.getSqlCurrentDate());
					ruoloNew.setDataUltMod(DateUtil.getSqlDataCorrente());
					ruoloNew.setFkPersonaGiuridica(ConvertUtil.convertToBigDecimal(idPersonaGiuridica));
					ruoloNew.setFkRuolo(new BigDecimal(idRuolo));
					ruoloNew.setUtenteUltMod(cfUtente);
					getSigitRImpRuoloPfpgDao().insert(ruoloNew);
				}
			}
		} catch (SigitRImpRuoloPfpgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
	}
	*/

	/**
	 * Passare in input all'oggetto filter, il codice impianto e l'utente
	 * @param filter
	 * @throws DbManagerException
	 */
	public void storicizzaLibretti(SigitTLibrettoDto filter) throws DbManagerException
	{
		try {
			log.debug("Storicizzazione libretti consolidati");
			filter.setDataUltMod(DateUtil.getSqlDataCorrente());
			getSigitTLibrettoDao().customUpdaterStoricizzaByCodImpianto(filter, null);

			getSigitSLibrettoDao().customUpdaterStoricizzaByCodImpianto(MapDto.mapToSigitSLibrettoDto(filter), null);

		} catch (SigitTLibrettoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		catch (SigitSLibrettoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
	}

	public List<SigitTUnitaImmobiliareDto> getUnitaImmobiliariImpianto(Integer codImpianto) throws DbManagerException
	{
		log.debug("[DbMgr::getUnitaImmobiliariImpianto] BEGIN");
		try {
			return getSigitTUnitaImmobiliareDao().findByCodiceImpianto(codImpianto);
		} catch (SigitTUnitaImmobiliareDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally{
			log.debug("[DbMgr::getUnitaImmobiliariImpianto] END");
		}
	}

	/**
	 * Restituisce il modulo compilato con tutti i dati trovati sul db, da utilizzare quando si sta creando un libretto nuovo a partire da uno consolidato
	 * @param codImpianto
	 * @param idLibretto
	 * @return
	 * @throws ServiceException
	 */
	public MODDocument getModuloLibretto(String codImpianto, String idLibretto, boolean isDefinitivo) throws ServiceException {
		log.debug("[DbMgr::getModuloLibretto] BEGIN");
		try {
			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(codImpianto));
			SigitTImpiantoDto impianto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			//quando creaiamo la bozza di un impianto ribaltato dal sigit, non avremmo il libretto
			SigitTLibrettoDto libretto = new SigitTLibrettoDto();
			if(idLibretto!=null)
			{
				SigitTLibrettoPk pkLibretto = new SigitTLibrettoPk();
				pkLibretto.setIdLibretto(new BigDecimal(idLibretto));
				libretto = getSigitTLibrettoDao().findByPrimaryKey(pkLibretto);
			}
			MODDocument modDoc = MODDocument.Factory.newInstance();
			modDoc.addNewMOD().addNewRichiesta().addNewDatiPrecompilati().addNewSezCatasto();

			Integer codImpiantoInt = new Integer(codImpianto);

			Richiesta richiesta = modDoc.getMOD().getRichiesta();
			DatiPrecompilati datiPrecompilati = richiesta.getDatiPrecompilati();

			datiPrecompilati.setElencoCombustibile(MapDto.mapToElencoCombustibile(getElencoCombustibile()));
			datiPrecompilati.setElencoFabbricante(MapDto.mapToElencoFabbricante(getElencoMarche()));
			datiPrecompilati.setElencoFluidoTermoVett(MapDto.mapToElencoFluido(getElencoFluidi()));
			datiPrecompilati.setElencoUM(MapDto.mapToElencoUnitaMisura(getElencoUnitaMisura()));

			compilaScheda1Libretto(richiesta, libretto, impianto);

			SigitTTrattH2OPk pkTrattAcq = new SigitTTrattH2OPk();
			pkTrattAcq.setCodiceImpianto(new BigDecimal(codImpianto));
			SigitTTrattH2ODto trattH2ODto = getSigitTTrattH2oDao().findByPrimaryKey(pkTrattAcq);
			if(trattH2ODto!=null)
				MapDto.mapToSchedaTrattH2o(trattH2ODto, richiesta.addNewDatiSchedaTrattH2O());



			// Beppe

			//GT
			List<SigitVSk4GtDto> comSk4GtImpianto = getCompSk4Gt(codImpiantoInt);
			if(comSk4GtImpianto!=null && !comSk4GtImpianto.isEmpty())
				MapDto.mapToSchedaGT(comSk4GtImpianto, richiesta.addNewDatiSchedaGT());
			//BR
			SigitTCompBrRcDto inputBrRc = new SigitTCompBrRcDto();
			inputBrRc.setCodiceImpianto(new BigDecimal(codImpianto));
			inputBrRc.setTipologiaBrRc(Constants.TIPO_COMPONENTE_BR);
			List<SigitTCompBrRcDto> compBrImpianto = getSigitTCompBrRcDao().findByTipoAndCodImpiantoOrdered(inputBrRc);
			if(compBrImpianto!=null && !compBrImpianto.isEmpty())
				MapDto.mapToSchedaBR(compBrImpianto, richiesta.addNewDatiSchedaBR(), comSk4GtImpianto);
			//RC
			inputBrRc.setTipologiaBrRc(Constants.TIPO_COMPONENTE_RC);
			List<SigitTCompBrRcDto> compRcImpianto = getSigitTCompBrRcDao().findByTipoAndCodImpiantoOrdered(inputBrRc);
			if(compBrImpianto!=null && !compRcImpianto.isEmpty())
				MapDto.mapToSchedaRC(compRcImpianto, richiesta.addNewDatiSchedaRC(), comSk4GtImpianto);
			//GF
			List<SigitVSk4GfDto> comSk4GfImpianto = getCompSk4Gf(codImpiantoInt);
			if(comSk4GfImpianto!=null && !comSk4GfImpianto.isEmpty())
				MapDto.mapToSchedaGF(comSk4GfImpianto, richiesta.addNewDatiSchedaGF());
			//SC
			List<SigitVSk4ScDto> comSk4ScImpianto = getCompSk4Sc(codImpiantoInt);
			if(comSk4ScImpianto!=null && !comSk4ScImpianto.isEmpty())
				MapDto.mapToSchedaSC(comSk4ScImpianto, richiesta.addNewDatiSchedaSC());
			//CG
			List<SigitVSk4CgDto> comSk4CgImpianto = getCompSk4Cg(codImpiantoInt);
			if(comSk4CgImpianto!=null && !comSk4CgImpianto.isEmpty())
				MapDto.mapToSchedaCG(comSk4CgImpianto, richiesta.addNewDatiSchedaCG());
			//CS
			List<SigitVCompCsDto> compCsImpianto = getSigitVCompCsDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if(compCsImpianto!=null && !compCsImpianto.isEmpty())
				MapDto.mapToSchedaCS(compCsImpianto, richiesta.addNewDatiSchedaCS());
			//AG
			List<SigitVCompAgDto> compAgImpianto = getSigitVCompAgDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if(compAgImpianto!=null && !compAgImpianto.isEmpty())
				MapDto.mapToSchedaAG(compAgImpianto, richiesta.addNewDatiSchedaAG());

			//5-7
			SigitTCompXSemplicePk pkXSemplice = new SigitTCompXSemplicePk();
			pkXSemplice.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpiantoInt));
			SigitTCompXSempliceDto compXSemplice = getSigitTCompXSempliceDao().findByPrimaryKey(pkXSemplice);
			if(compXSemplice!=null)
			{
				//sez5
				MapDto.mapToSchedaSistemiRegolarizzazionePrimaria(richiesta.addNewDatiSchedaSistemiRegolaz().addNewRegolazionePrimaria(), compXSemplice);
				MapDto.mapToSchedaSistemiRegolarizzazioneSingoloAmbiente(richiesta.getDatiSchedaSistemiRegolaz().addNewRegolazioneSingoloAmb(), compXSemplice);
				//SR
				List<SigitVCompSrDto> srList = getSigitVCompSrDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
				if(srList!=null && !srList.isEmpty())
					MapDto.mapToSchedaSR(richiesta.getDatiSchedaSistemiRegolaz().getRegolazionePrimaria().addNewSezSR(), srList);
				//sez6
				MapDto.mapToSchedaSistemiDistribuiti(richiesta.addNewDatiSchedaSistemiDistrib(), compXSemplice);
				//VR
				List<SigitVCompVrDto> vrList = getSigitVCompVrDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
				if(vrList!=null && !vrList.isEmpty())
					MapDto.mapToSchedaVR(richiesta.getDatiSchedaSistemiRegolaz().getRegolazionePrimaria().addNewSezVR(), vrList);
				//VX
				List<SigitTCompVxDto> vxList = getSigitTCompVxDao().findByCodImpianto(codImpiantoInt);
				if(vxList!=null && !vxList.isEmpty())
					MapDto.mapToSchedaVX(richiesta.getDatiSchedaSistemiDistrib().addNewSezVasi(), vxList);
				//PO
				List<SigitVCompPoDto> poList = getSigitVCompPoDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
				if(poList!=null && !poList.isEmpty())
					MapDto.mapToSchedaPO(richiesta.getDatiSchedaSistemiDistrib().addNewSezPO(), poList);
				//sez7
				MapDto.mapToSchedaSistemiEmissione(richiesta.addNewDatiSchedaSistemaEmissione(), compXSemplice);
			}
			//8 - AC
			List<SigitVCompAcDto> acList = getSigitVCompAcDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if(acList!=null && !acList.isEmpty())
				MapDto.mapToSchedaAC(richiesta.addNewDatiSchedaSistemaAC().addNewSezAC(), acList);
			//9.1 - TE
			List<SigitVCompTeDto> teList = getSigitVCompTeDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if(teList!=null && !teList.isEmpty())
				MapDto.mapToSchedaTE(richiesta.addNewDatiAltriComponentiTE().addNewSezTE(), teList);
			//9.2 - RV
			List<SigitVCompRvDto> rvList = getSigitVCompRvDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if(rvList!=null && !rvList.isEmpty())
				MapDto.mapToSchedaRV(richiesta.addNewDatiAltriComponentiRV().addNewSezRV(), rvList);

			//9.3 - SC
			CompFilter filterSCX = new CompFilter();
			filterSCX.setCodImpianto(codImpianto);
			filterSCX.setTipoComponente(Constants.TIPO_COMPONENTE_SCX);
			List<SigitTCompXDto> scxList = getSigitTCompXDao().findByTipoAndCodImpiantoOrdered(filterSCX);
			if(scxList!=null && !scxList.isEmpty())
				MapDto.mapToSchedaSCX(richiesta.addNewDatiAltriComponentiSC().addNewSezSC(), scxList);

			//9.4 - CI
			List<SigitVCompCiDto> ciList = getSigitVCompCiDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if(ciList!=null && !ciList.isEmpty())
				MapDto.mapToSchedaCI(richiesta.addNewDatiAltriComponentiCI().addNewSezCI(), ciList);

			//9.5 - UT
			List<SigitVCompUtDto> utList = getSigitVCompUtDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if(utList!=null && !utList.isEmpty())
				MapDto.mapToSchedaUT(richiesta.addNewDatiAltriComponentiUT().addNewSezUT(), utList);

			//9.6 - RC
			List<SigitVCompRcDto> rcList = getSigitVCompRcDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if(rcList!=null && !rcList.isEmpty())
				MapDto.mapToSchedaRC(richiesta.addNewDatiAltriComponentiRC().addNewSezRC(), rcList);

			//10.1 - VM
			List<SigitVCompVmDto> vmList = getSigitVCompVmDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if(vmList!=null && !vmList.isEmpty())
				MapDto.mapToSchedaVM(richiesta.addNewDatiVentilazMeccanicaVM().addNewSezVM(), vmList);

			RowDateGTDocument.RowDateGT rowDateGT = richiesta.addNewDatiRisultatiGT().addNewSezGruppiTermici().addNewL111RowGT().addNewSezDateGT().addNewRowDateGT();
			rowDateGT.xsetL111FlagNorma(MapDto.getXmlBoolean(ConvertUtil.convertToBooleanAllways(impianto.getL111FlgNormaUni103891())));
			rowDateGT.xsetL111FlagAltro(MapDto.getXmlBoolean(GenericUtil.isNotNullOrEmpty(impianto.getL111AltraNorma())));
			rowDateGT.setL111DescrAltro(impianto.getL111AltraNorma());

			List<SigitVCompGtDettDto> compGtImpiantoDett = getCompGtDett(codImpiantoInt);
			List<SigitVCompGfDettDto> compGfImpiantoDett = getCompGfDett(codImpiantoInt);
			List<SigitVCompScDettDto> compScImpiantoDett = getCompScDett(codImpiantoInt);
			List<SigitVCompCgDettDto> compCgImpiantoDett = getCompCgDett(codImpiantoInt);

			compilaDatiResponsabiliEControlliLibretto(codImpiantoInt, richiesta, compGtImpiantoDett, compGfImpiantoDett, compScImpiantoDett, compCgImpiantoDett);

			compilaScheda14Libretto(codImpianto, richiesta);

			if(isDefinitivo)
			{
				datiPrecompilati.setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
				modDoc.getMOD().addNewSystem().addNewCatDig().setModuloEditabile(false);
				modDoc.getMOD().getSystem().getCatDig().setBtSalva(false);
			}
			else
			{
				datiPrecompilati.setStatoModulo(Constants.STATO_MODULO_BOZZA);
				modDoc.getMOD().addNewSystem().addNewCatDig().setModuloEditabile(true);
				modDoc.getMOD().getSystem().getCatDig().setBtSalva(true);
			}

	        if (log.isDebugEnabled())
	        {
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				log.debug("STAMPO RESULT: "+modDoc);
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	        }

			return modDoc;

		}catch (Exception e) {
				log.error("Errore getLibretto",e);
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[DbMgr::getModuloLibretto] END");
		}
	}

	public it.csi.sigit.sigitwebn.xml.librettoLight.data.MODDocument getModuloLibrettoLight(String codImpianto, String idLibretto) throws ServiceException {
		log.debug("[DbMgr::getModuloLibrettoLight] BEGIN");
		try {
			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(codImpianto));
			SigitTImpiantoDto impianto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			//quando creaiamo la bozza di un impianto ribaltato dal sigit, non avremmo il libretto
			SigitTLibrettoDto libretto = new SigitTLibrettoDto();
			if(idLibretto!=null)
			{
				SigitTLibrettoPk pkLibretto = new SigitTLibrettoPk();
				pkLibretto.setIdLibretto(new BigDecimal(idLibretto));
				libretto = getSigitTLibrettoDao().findByPrimaryKey(pkLibretto);
			}

			it.csi.sigit.sigitwebn.xml.librettoLight.data.MODDocument modDoc = it.csi.sigit.sigitwebn.xml.librettoLight.data.MODDocument.Factory.newInstance();
			modDoc.addNewMOD().addNewRichiesta().addNewDatiPrecompilati().addNewSezCatasto();

			Integer codImpiantoInt = new Integer(codImpianto);

			it.csi.sigit.sigitwebn.xml.librettoLight.data.RichiestaDocument.Richiesta richiesta = modDoc.getMOD().getRichiesta();
			it.csi.sigit.sigitwebn.xml.librettoLight.data.DatiPrecompilatiDocument.DatiPrecompilati datiPrecompilati = richiesta.getDatiPrecompilati();

			datiPrecompilati.setElencoCombustibile(MapDto.mapToElencoCombustibileLight(getElencoCombustibile()));
			datiPrecompilati.setElencoUM(MapDto.mapToElencoUnitaMisuraLight(getElencoUnitaMisura()));

			compilaScheda1LibrettoLight(richiesta, libretto, impianto);

			compilaDatiResponsabileLibrettoLight(codImpiantoInt, richiesta);

			compilaScheda14LibrettoLight(codImpianto, richiesta);

			datiPrecompilati.setStatoModulo(Constants.STATO_MODULO_BOZZA);
			modDoc.getMOD().addNewSystem().addNewCatDig().setModuloEditabile(true);
			modDoc.getMOD().getSystem().getCatDig().setBtSalva(true);

	        if (log.isDebugEnabled())
	        {
	        	log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				log.debug("STAMPO RESULT: "+modDoc);
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	        }

			return modDoc;
		}catch (Exception e) {
			log.error("Errore getLibretto",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[DbMgr::getModuloLibretto] END");
		}
	}

	/**
	 * Restituisce il modulo compilato con tutti i dati trovati sul db, da utilizzare quando si sta creando un libretto nuovo a partire da uno consolidato
	 * @param codImpianto
	 * @param idLibretto
	 * @return
	 * @throws ServiceException
	 */
	public MODDocument getModuloLibrettoImport(String codImpianto) throws ServiceException {
		log.debug("[DbMgr::getModuloLibrettoImport] BEGIN");
		try {

			MODDocument modDoc = MODDocument.Factory.newInstance();
			modDoc.addNewMOD().addNewRichiesta().addNewDatiPrecompilati().addNewSezCatasto();

			Integer codImpiantoInt = new Integer(codImpianto);

			Richiesta richiesta = modDoc.getMOD().getRichiesta();
			DatiPrecompilati datiPrecompilati = richiesta.getDatiPrecompilati();

			datiPrecompilati.setElencoCombustibile(MapDto.mapToElencoCombustibile(getElencoCombustibile()));
			datiPrecompilati.setElencoFabbricante(MapDto.mapToElencoFabbricante(getElencoMarche()));
			datiPrecompilati.setElencoFluidoTermoVett(MapDto.mapToElencoFluido(getElencoFluidi()));
			datiPrecompilati.setElencoUM(MapDto.mapToElencoUnitaMisura(getElencoUnitaMisura()));

			//DA RIVEDERE
			//compilaScheda1Libretto(richiesta, libretto, impianto);

			// Import
			//richiesta.addNewDatiRisultatiGT().xsetL111FlagNorma(MapDto.getXmlBoolean(ConvertUtil.convertToBooleanAllways(libretto.getL111FlgNormaUni103891())));
			//richiesta.getDatiRisultatiGT().xsetL111FlagAltro(MapDto.getXmlBoolean(GenericUtil.isNotNullOrEmpty(libretto.getL111AltraNorma())));
			//richiesta.getDatiRisultatiGT().setL111DescrAltro(libretto.getL111AltraNorma());

			// Questo non dovrebbe servire, perche' porendo per buono l'xml
//			List<SigitVCompGtDettDto> compGtImpiantoDett = getCompGtDett(codImpiantoInt);
//			List<SigitVCompGfDettDto> compGfImpiantoDett = getCompGfDett(codImpiantoInt);
//			List<SigitVCompScDettDto> compScImpiantoDett = getCompScDett(codImpiantoInt);
//			List<SigitVCompCgDettDto> compCgImpiantoDett = getCompCgDett(codImpiantoInt);

			// Questo e' da rivedere
			compilaDatiResponsabiliEControlliLibrettoImport(codImpiantoInt, richiesta);

			datiPrecompilati.setStatoModulo(Constants.STATO_MODULO_BOZZA);
			modDoc.getMOD().addNewSystem().addNewCatDig().setModuloEditabile(true);
			modDoc.getMOD().getSystem().getCatDig().setBtSalva(true);

	        if (log.isDebugEnabled())
	        {
	        	log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				log.debug("STAMPO RESULT: "+modDoc);
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	        }

			return modDoc;

		}catch (Exception e) {
				log.error("Errore getModuloLibrettoImport",e);
				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[DbMgr::getModuloLibrettoImport] END");
		}
	}

	private void compilaScheda1ImportLibretto(Richiesta richiesta, L1SchedaIdentificativa l1SchedaIdentificativa, SigitTImpiantoDto impianto) throws DbManagerException
	{
		log.debug("[DbMgr:::compilaScheda1Libretto] - START");
		List<SigitTUnitaImmobiliareDto> unitaImmobList = getUnitaImmobiliariImpianto(impianto.getCodiceImpianto().intValue());

		List<SigitTUnitaImmobiliareDto> unitaImmobSecondarie = new ArrayList<SigitTUnitaImmobiliareDto>();
		SigitTUnitaImmobiliareDto unitaImmobPrincipale = new SigitTUnitaImmobiliareDto();

		// Sull'IMPORT E' POSSIBILE CHE CI SIANO UI SECONDARIE?

		for (SigitTUnitaImmobiliareDto ui : unitaImmobList) {
			if(ConvertUtil.convertToBooleanAllways(ui.getFlgPrincipale()))
				unitaImmobPrincipale = ui;
			else
				unitaImmobSecondarie.add(ui);
		}
		log.debug("unita immob secondarie: " + unitaImmobSecondarie.size());

		richiesta.setDatiSchedaIdentificativaImp(DatiSchedaIdentificativaImp.Factory.newInstance());
		DatiSchedaIdentificativaImp datiImpianto = richiesta.getDatiSchedaIdentificativaImp();


		//MapDto.mapToSchedaIdentificativaImpianto(datiImpianto, libretto, impianto, unitaImmobPrincipale);

		// La secondaria non ci sono
		MapDto.mapToDatiPrecompilati(richiesta.getDatiPrecompilati(), unitaImmobPrincipale, impianto, unitaImmobSecondarie);

		log.debug("[DbMgr:::compilaScheda1Libretto] - END");
	}

	private void compilaScheda1Libretto(Richiesta richiesta, SigitTLibrettoDto libretto, SigitTImpiantoDto impianto) throws DbManagerException
	{
		log.debug("[DbMgr:::compilaScheda1Libretto] - START");
		List<SigitTUnitaImmobiliareDto> unitaImmobList = getUnitaImmobiliariImpianto(impianto.getCodiceImpianto().intValue());

		List<SigitTUnitaImmobiliareDto> unitaImmobSecondarie = new ArrayList<SigitTUnitaImmobiliareDto>();
		SigitTUnitaImmobiliareDto unitaImmobPrincipale = new SigitTUnitaImmobiliareDto();

		for (SigitTUnitaImmobiliareDto ui : unitaImmobList) {
			if(ConvertUtil.convertToBooleanAllways(ui.getFlgPrincipale()))
				unitaImmobPrincipale = ui;
			else
				unitaImmobSecondarie.add(ui);
		}
		log.debug("unita immob secondarie: " + unitaImmobSecondarie.size());

		richiesta.setDatiSchedaIdentificativaImp(DatiSchedaIdentificativaImp.Factory.newInstance());
		DatiSchedaIdentificativaImp datiImpianto = richiesta.getDatiSchedaIdentificativaImp();
		MapDto.mapToSchedaIdentificativaImpianto(datiImpianto, libretto, impianto, unitaImmobPrincipale);
		MapDto.mapToDatiPrecompilati(richiesta.getDatiPrecompilati(), unitaImmobPrincipale, impianto, unitaImmobSecondarie);

		log.debug("[DbMgr:::compilaScheda1Libretto] - END");
	}

	private void compilaScheda1LibrettoLight(it.csi.sigit.sigitwebn.xml.librettoLight.data.RichiestaDocument.Richiesta richiesta, SigitTLibrettoDto libretto, SigitTImpiantoDto impianto) throws DbManagerException
	{
		log.debug("[DbMgr:::compilaScheda1LibrettoLight] - START");
		List<SigitTUnitaImmobiliareDto> unitaImmobList = getUnitaImmobiliariImpianto(impianto.getCodiceImpianto().intValue());

		List<SigitTUnitaImmobiliareDto> unitaImmobSecondarie = new ArrayList<SigitTUnitaImmobiliareDto>();
		SigitTUnitaImmobiliareDto unitaImmobPrincipale = new SigitTUnitaImmobiliareDto();

		for (SigitTUnitaImmobiliareDto ui : unitaImmobList) {
			if(ConvertUtil.convertToBooleanAllways(ui.getFlgPrincipale()))
				unitaImmobPrincipale = ui;
			else
				unitaImmobSecondarie.add(ui);
		}
		log.debug("unita immob secondarie: " + unitaImmobSecondarie.size());

		richiesta.setDatiSchedaIdentificativaImp(it.csi.sigit.sigitwebn.xml.librettoLight.data.DatiSchedaIdentificativaImpDocument.DatiSchedaIdentificativaImp.Factory.newInstance());
		it.csi.sigit.sigitwebn.xml.librettoLight.data.DatiSchedaIdentificativaImpDocument.DatiSchedaIdentificativaImp datiImpianto = richiesta.getDatiSchedaIdentificativaImp();
		MapDto.mapToSchedaIdentificativaImpiantoLight(datiImpianto, libretto, impianto, unitaImmobPrincipale);
		MapDto.mapToDatiPrecompilatiLight(richiesta.getDatiPrecompilati(), unitaImmobPrincipale, impianto, unitaImmobSecondarie);
		log.debug("[DbMgr:::compilaScheda1Libretto] - END");
	}

	private void compilaScheda14Libretto(String codImpianto, Richiesta richiesta) throws NumberFormatException, SigitTConsumo14_4DaoException, SigitTConsumoDaoException
	{
		log.debug("[DbMgr:::compilaScheda14Libretto] - START");
		richiesta.setDatiConsumoCombu(DatiConsumoCombu.Factory.newInstance());
		richiesta.setDatiConsumoEE(DatiConsumoEE.Factory.newInstance());
		richiesta.setDatiConsumoH2O(DatiConsumoH2O.Factory.newInstance());
		richiesta.setDatiConsumoProdottiChimici(DatiConsumoProdottiChimici.Factory.newInstance());

		//14.1 - Combustibile
		SigitTConsumoDto inputCons = new SigitTConsumoDto();
		inputCons.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
		inputCons.setFkTipoConsumo(Constants.TIPO_CONSUMO_CB);
		List<SigitTConsumoDto> cbList = getSigitTConsumoDao().findByCodImpiantoAndTipo(inputCons);
		//la lista cbList, dovrebbe essere ordinata per tipo_combustibile, bisogna fare la rottura per ogni tipo
		if(cbList!=null && !cbList.isEmpty())
			MapDto.mapToSchedaCombustibile(richiesta.getDatiConsumoCombu().addNewSezCombu(), cbList);

		//14.2 - Energia elettrica
		inputCons.setFkTipoConsumo(Constants.TIPO_CONSUMO_EE);
		List<SigitTConsumoDto> eeList = getSigitTConsumoDao().findByCodImpiantoAndTipo(inputCons);
		if(eeList!=null && !eeList.isEmpty())
			MapDto.mapToSchedaEnergiaElettrica(richiesta.getDatiConsumoEE().addNewSezConsumo(), eeList);

		//14.3 - Acqua
		inputCons.setFkTipoConsumo(Constants.TIPO_CONSUMO_H2O);
		List<SigitTConsumoDto> h2oList = getSigitTConsumoDao().findByCodImpiantoAndTipo(inputCons);
		if(h2oList!=null && !h2oList.isEmpty())
			MapDto.mapToSchedaAcquaImpianto(richiesta.getDatiConsumoH2O(), h2oList);

		//14.4 - Prodotti chimici
		List<SigitTConsumo14_4Dto> pcList = getSigitTConsumo144Dao().findByCodImpianto(new Integer(codImpianto));
		if(pcList!=null && !pcList.isEmpty())
			MapDto.mapToSchedaProdottiChimici(richiesta.getDatiConsumoProdottiChimici().addNewSezConsumo(), pcList);

		log.debug("[DbMgr:::compilaScheda14Libretto] - END");
	}

	private void compilaScheda14LibrettoLight(String codImpianto, it.csi.sigit.sigitwebn.xml.librettoLight.data.RichiestaDocument.Richiesta richiesta) throws NumberFormatException, SigitTConsumo14_4DaoException, SigitTConsumoDaoException
	{
		log.debug("[DbMgr:::compilaScheda14Libretto] - START");
		richiesta.setDatiConsumoCombu(it.csi.sigit.sigitwebn.xml.librettoLight.data.DatiConsumoCombuDocument.DatiConsumoCombu.Factory.newInstance());
		richiesta.setDatiConsumoEE(it.csi.sigit.sigitwebn.xml.librettoLight.data.DatiConsumoEEDocument.DatiConsumoEE.Factory.newInstance());
		richiesta.setDatiConsumoH2O(it.csi.sigit.sigitwebn.xml.librettoLight.data.DatiConsumoH2ODocument.DatiConsumoH2O.Factory.newInstance());
		richiesta.setDatiConsumoProdottiChimici(it.csi.sigit.sigitwebn.xml.librettoLight.data.DatiConsumoProdottiChimiciDocument.DatiConsumoProdottiChimici.Factory.newInstance());

		//14.1 - Combustibile
		SigitTConsumoDto inputCons = new SigitTConsumoDto();
		inputCons.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
		inputCons.setFkTipoConsumo(Constants.TIPO_CONSUMO_CB);
		List<SigitTConsumoDto> cbList = getSigitTConsumoDao().findByCodImpiantoAndTipo(inputCons);
		//la lista cbList, dovrebbe essere ordinata per tipo_combustibile, bisogna fare la rottura per ogni tipo
		if(cbList!=null && !cbList.isEmpty())
			MapDto.mapToSchedaCombustibileLight(richiesta.getDatiConsumoCombu().addNewSezCombu(), cbList);

		//14.2 - Energia elettrica
		inputCons.setFkTipoConsumo(Constants.TIPO_CONSUMO_EE);
		List<SigitTConsumoDto> eeList = getSigitTConsumoDao().findByCodImpiantoAndTipo(inputCons);
		if(eeList!=null && !eeList.isEmpty())
			MapDto.mapToSchedaEnergiaElettricaLight(richiesta.getDatiConsumoEE().addNewSezConsumo(), eeList);

		//14.3 - Acqua
		inputCons.setFkTipoConsumo(Constants.TIPO_CONSUMO_H2O);
		List<SigitTConsumoDto> h2oList = getSigitTConsumoDao().findByCodImpiantoAndTipo(inputCons);
		if(h2oList!=null && !h2oList.isEmpty())
			MapDto.mapToSchedaAcquaImpiantoLight(richiesta.getDatiConsumoH2O(), h2oList);

		//14.4 - Prodotti chimici
		List<SigitTConsumo14_4Dto> pcList = getSigitTConsumo144Dao().findByCodImpianto(new Integer(codImpianto));
		if(pcList!=null && !pcList.isEmpty())
			MapDto.mapToSchedaProdottiChimiciLight(richiesta.getDatiConsumoProdottiChimici().addNewSezConsumo(), pcList);

		log.debug("[DbMgr:::compilaScheda14Libretto] - END");
	}

	/**
	 * Popola il modulo con i dati del responsabile impianto, e il terzo responsabile
	 * @param codImpiantoInt
	 * @param richiesta
	 * @param compGtImpiantoDett
	 * @param compGfImpiantoDett
	 * @param compScImpiantoDett
	 * @param compCgImpiantoDett
	 * @throws ServiceException
	 * @throws SigitVRicercaAllegatiDaoException
	 */
	public void compilaDatiResponsabiliEControlliLibretto(Integer codImpiantoInt, Richiesta richiesta, List<SigitVCompGtDettDto> compGtImpiantoDett, List<SigitVCompGfDettDto> compGfImpiantoDett, List<SigitVCompScDettDto> compScImpiantoDett, List<SigitVCompCgDettDto> compCgImpiantoDett) throws ServiceException, SigitVRicercaAllegatiDaoException, SigitVRicercaIspezioniDaoException
	{
		log.debug("[DbMgr::compilaDatiResponsabiliLibretto] START");
		richiesta.getDatiPrecompilati().setCodiceImpianto(codImpiantoInt.toString());
		richiesta.getDatiPrecompilati().setCodiceCatasto(codImpiantoInt.toString());

		//RESPONSABILE IMPIANTO (1.6)
		try {
			richiesta.getDatiPrecompilati().setL16Piva(null);
			richiesta.getDatiPrecompilati().setL16RagSociale(null);
			richiesta.getDatiPrecompilati().setL16Cf(null);
			richiesta.getDatiPrecompilati().setL16Nome(null);
			richiesta.getDatiPrecompilati().setL16Cognome(null);
			List<SigitVTotImpiantoDto> respAttivi = getSigitVTotImpiantoDao().findResponsabiliAttiviByCodiceImpianto(codImpiantoInt);
			if(respAttivi!=null && !respAttivi.isEmpty()) {
				MapDto.mapResponsabileImpianto(richiesta.getDatiPrecompilati(), respAttivi.get(0));
			}

		//TERZO RESPONSABILE
		log.debug("Ricerca contratti impianto");
		ContrattoFilter filterContratti = new ContrattoFilter();
		filterContratti.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpiantoInt));
		List<SigitExtContrattoImpDto> contratti = getSigitExtDao().findStoriaContrattiImpiantoNew(filterContratti);
		richiesta.getDatiPrecompilati().setSezNomine(SezNomine.Factory.newInstance());
		MapDto.mapToSezNomine(contratti,richiesta.getDatiPrecompilati().getSezNomine());
		} catch (SigitVTotImpiantoDaoException e) {
			log.error("Errore (responsabili) compilaDatiResponsabiliLibretto",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} catch (SigitExtDaoException e) {
			log.error("Errore (contratti) compilaDatiResponsabiliLibretto",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally{
			log.debug("[DbMgr::compilaDatiResponsabiliLibretto] END");
		}

		//11.1 - Dati risultati GT
		//MapDto.mapToDatiRisultatiGT(richiesta.getDatiRisultatiGT(), compGtImpiantoDett);
		MapDto.mapToDatiRisultatiGT(richiesta.getDatiRisultatiGT().addNewSezGruppiTermici(), compGtImpiantoDett);

		//11.2 - Dati risultati GF
		MapDto.mapToDatiRisultatiGF(richiesta.addNewDatiRisultatiGF().addNewSezMacchineFrigo(), compGfImpiantoDett);

		//11.3 - Dati risultati SC
		MapDto.mapToDatiRisultatiSC(richiesta.addNewDatiRisultatiSC().addNewSezScambiatori(), compScImpiantoDett);

		//11.4 - Dati risultati CG
		MapDto.mapToDatiRisultatiCG(richiesta.addNewDatiRisultatiCG().addNewSezCogen(), compCgImpiantoDett);

		//12 - Interventi controllo efficenza
		List<SigitVRicercaAllegatiDto> listControlli = getSigitVRicercaAllegatiDao().findReeByCodImpiantoOrderedByData(codImpiantoInt);
		MapDto.mapToDatiInterventiControllo(richiesta.addNewDatiInterventiControllo().addNewSezInterventi(), listControlli);

		//13 - risultati ispezione
		List<SigitVRicercaIspezioniDto> listIspezioni = null;//getSigitVRicercaIspezioniDao().findByIspezioneFilter(new IspezioneFilter(codImpiantoInt, Constants.ID_STATO_ISPEZIONE_CONSOLIDATO));
		MapDto.mapToDatiIspezioni(richiesta.addNewDatiRisultatiIspez().addNewSezRisultati(), listIspezioni);

	}

	public void compilaDatiResponsabileLibrettoLight(Integer codImpiantoInt, it.csi.sigit.sigitwebn.xml.librettoLight.data.RichiestaDocument.Richiesta richiesta) throws ServiceException
	{
		log.debug("[DbMgr::compilaDatiResponsabileLibrettoLight] START");
		richiesta.getDatiPrecompilati().setCodiceImpianto(codImpiantoInt.toString());
		richiesta.getDatiPrecompilati().setCodiceCatasto(codImpiantoInt.toString());

		//RESPONSABILE IMPIANTO (1.6)
		try {
			richiesta.getDatiPrecompilati().setL16Piva(null);
			richiesta.getDatiPrecompilati().setL16RagSociale(null);
			richiesta.getDatiPrecompilati().setL16Cf(null);
			richiesta.getDatiPrecompilati().setL16Nome(null);
			richiesta.getDatiPrecompilati().setL16Cognome(null);
			List<SigitVTotImpiantoDto> respAttivi = getSigitVTotImpiantoDao().findResponsabiliAttiviByCodiceImpianto(codImpiantoInt);
			if(respAttivi!=null && !respAttivi.isEmpty()) {
				MapDto.mapResponsabileImpianto(richiesta.getDatiPrecompilati(), respAttivi.get(0));
			}
		} catch (SigitVTotImpiantoDaoException e) {
			log.error("Errore (responsabili) compilaDatiResponsabiliLibretto",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally{
			log.debug("[DbMgr::compilaDatiResponsabiliLibretto] END");
		}
	}

	/**
	 * Popola il modulo con i dati del responsabile impianto, e il terzo responsabile
	 * @param codImpiantoInt
	 * @param richiesta
	 * @param compGtImpiantoDett
	 * @param compGfImpiantoDett
	 * @param compScImpiantoDett
	 * @param compCgImpiantoDett
	 * @throws ServiceException
	 * @throws SigitVRicercaAllegatiDaoException
	 */
	public void compilaDatiResponsabiliEControlliLibrettoImport(Integer codImpiantoInt, Richiesta richiesta) throws ServiceException, SigitVRicercaAllegatiDaoException, SigitVRicercaIspezioniDaoException
	{
		log.debug("[DbMgr::compilaDatiResponsabiliLibretto] START");
		richiesta.getDatiPrecompilati().setCodiceImpianto(codImpiantoInt.toString());
		richiesta.getDatiPrecompilati().setCodiceCatasto(codImpiantoInt.toString());

		//RESPONSABILE IMPIANTO (1.6)
		try {
			richiesta.getDatiPrecompilati().setL16Piva(null);
			richiesta.getDatiPrecompilati().setL16RagSociale(null);
			richiesta.getDatiPrecompilati().setL16Cf(null);
			richiesta.getDatiPrecompilati().setL16Nome(null);
			richiesta.getDatiPrecompilati().setL16Cognome(null);
			List<SigitVTotImpiantoDto> respAttivi = getSigitVTotImpiantoDao().findResponsabiliAttiviByCodiceImpianto(codImpiantoInt);
			if(respAttivi!=null && !respAttivi.isEmpty()) {
				MapDto.mapResponsabileImpianto(richiesta.getDatiPrecompilati(), respAttivi.get(0));
			}

		//TERZO RESPONSABILE
		log.debug("Ricerca contratti impianto");
		ContrattoFilter filterContratti = new ContrattoFilter();
		filterContratti.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpiantoInt));
		List<SigitExtContrattoImpDto> contratti = getSigitExtDao().findStoriaContrattiImpiantoNew(filterContratti);
		richiesta.getDatiPrecompilati().setSezNomine(SezNomine.Factory.newInstance());
		MapDto.mapToSezNomine(contratti,richiesta.getDatiPrecompilati().getSezNomine());
		} catch (SigitVTotImpiantoDaoException e) {
			log.error("Errore (responsabili) compilaDatiResponsabiliLibretto",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		} catch (SigitExtDaoException e) {
			log.error("Errore (contratti) compilaDatiResponsabiliLibretto",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}
		finally{
			log.debug("[DbMgr::compilaDatiResponsabiliLibretto] END");
		}
		/*
		//11.1 - Dati risultati GT
		MapDto.mapToDatiRisultatiGT(richiesta.getDatiRisultatiGT(), compGtImpiantoDett);

		//11.2 - Dati risultati GF
		MapDto.mapToDatiRisultatiGF(richiesta.addNewDatiRisultatiGF().addNewSezMacchineFrigo(), compGfImpiantoDett);

		//11.3 - Dati risultati SC
		MapDto.mapToDatiRisultatiSC(richiesta.addNewDatiRisultatiSC().addNewSezScambiatori(), compScImpiantoDett);

		//11.4 - Dati risultati CG
		MapDto.mapToDatiRisultatiCG(richiesta.addNewDatiRisultatiCG().addNewSezCogen(), compCgImpiantoDett);

		//12 - Interventi controllo efficenza
		List<SigitVRicercaAllegatiDto> listControlli = getSigitVRicercaAllegatiDao().findInviatiByCodImpiantoOrderedByData(codImpiantoInt);
		MapDto.mapToDatiInterventiControllo(richiesta.addNewDatiInterventiControllo().addNewSezInterventi(), listControlli);

		//13 - risultati ispezione
		List<SigitVRicercaIspezioniDto> listIspezioni = getSigitVRicercaIspezioniDao().findByIspezioneFilter(new IspezioneFilter(codImpiantoInt, Constants.ID_STATO_ISPEZIONE_CONSOLIDATO));
		MapDto.mapToDatiIspezioni(richiesta.addNewDatiRisultatiIspez().addNewSezRisultati(), listIspezioni);
		*/
	}

	public void compilaScheda1E14Libretto(Richiesta richiesta, SigitTLibrettoDto libretto, SigitTImpiantoDto impianto) throws DbManagerException, NumberFormatException, SigitTConsumo14_4DaoException, SigitTConsumoDaoException
	{
		log.debug("[DbMgr::compilaScheda1E14Libretto] START");
		//compila scheda 1
		compilaScheda1Libretto(richiesta, libretto, impianto);
		//compila scheda 14
		compilaScheda14Libretto(impianto.getCodiceImpianto().toString(), richiesta);
		log.debug("[DbMgr::compilaScheda1E14Libretto] END");
	}

	public void compilaScheda1E14LibrettoLight(it.csi.sigit.sigitwebn.xml.librettoLight.data.RichiestaDocument.Richiesta richiesta, SigitTLibrettoDto libretto, SigitTImpiantoDto impianto) throws DbManagerException, NumberFormatException, SigitTConsumo14_4DaoException, SigitTConsumoDaoException
	{
		log.debug("[DbMgr::compilaScheda1E14Libretto] START");
		//compila scheda 1
		compilaScheda1LibrettoLight(richiesta, libretto, impianto);
		//compila scheda 14
		compilaScheda14LibrettoLight(impianto.getCodiceImpianto().toString(), richiesta);
		log.debug("[DbMgr::compilaScheda1E14Libretto] END");
	}

	/*
	public List<SigitVRicercaAllegatiDto> getElencoAllegatiInviatiOrdinati(Integer codImpianto) throws DbManagerException
	{
		log.debug("[DbMgr::getElencoCombustibile] START");
		try {
			return getSigitVRicercaAllegatiDao().findInviatiByCodImpiantoOrderedByData(codImpianto);
		} catch (SigitVRicercaAllegatiDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getElencoCombustibile] END");
		}
	}
	*/

	public List<SigitDCombustibileDto> getElencoCombustibile() throws DbManagerException
	{
		log.debug("[DbMgr::getElencoCombustibile] START");
		try {
			return getSigitDCombustibileDao().findAll();
		} catch (SigitDCombustibileDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getElencoCombustibile] END");
		}
	}

	public List<SigitDCombustibileDto> getElencoCombustibileById(ArrayList<Integer> listaCombustibili) throws DbManagerException
	{
		log.debug("[DbMgr::getElencoCombustibileById] START");
		try {
			return getSigitDCombustibileDao().findByElencoId(listaCombustibili);
		} catch (SigitDCombustibileDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getElencoCombustibileById] END");
		}
	}

	public List<SigitDCombustibileDto> getElencoCombustibileNotInIdList(ArrayList<Integer> listaCombustibili) throws DbManagerException
	{
		log.debug("[DbMgr::getElencoCombustibileNotInIdList] START");
		try {
			return getSigitDCombustibileDao().findByNotInElencoId(listaCombustibili);
		} catch (SigitDCombustibileDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getElencoCombustibileNotInIdList] END");
		}
	}

	public SigitDCombustibileDto getCombustibileById(Integer idCombustibile) throws DbManagerException
	{
		log.debug("[DbMgr::getCombustibileById] START");
		try {
			return getSigitDCombustibileDao().findByPrimaryKey(new SigitDCombustibilePk(ConvertUtil.convertToBigDecimal(idCombustibile)));
		} catch (SigitDCombustibileDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCombustibileById] END");
		}
	}

	public List<SigitDTipoCannaFumariaDto> getElencoTipoCannaFumaria() throws DbManagerException
	{
		log.debug("[DbMgr::getElencoTipoCannaFumaria] START");
		try {
			return getSigitDTipoCannaFumariaDao().findAll();
		} catch (SigitDTipoCannaFumariaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getElencoTipoCannaFumaria] END");
		}
	}

	public List<SigitDFonteEnSfruttataDto> getElencoFonteEnergiaSfruttata() throws DbManagerException
	{
		log.debug("[DbMgr::getElencoFonteEnergiaSfruttata] START");
		try {
			return getSigitDFonteEnSfruttataDao().findAll();
		} catch (SigitDFonteEnSfruttataDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getElencoFonteEnergiaSfruttata] END");
		}
	}

	public List<SigitDMarcaDto> getElencoMarche() throws DbManagerException
	{
		log.debug("[DbMgr::getElencoMarche] START");
		try {
			return getSigitDMarcaDao().findAll();
		} catch (SigitDMarcaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getElencoMarche] END");
		}
	}

	public SigitDMarcaDto getMarcaById(Integer idMarca) throws DbManagerException
	{
		log.debug("[DbMgr::getMarcaById] START");
		try {
			return getSigitDMarcaDao().findByPrimaryKey(new SigitDMarcaPk(ConvertUtil.convertToBigDecimal(idMarca)));
		} catch (SigitDMarcaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getMarcaById] END");
		}
	}


	public List<SigitDFluidoDto> getElencoFluidi() throws DbManagerException
	{
		log.debug("[DbMgr::getElencoFluidi] START");
		try {
			return getSigitDFluidoDao().findAll();
		} catch (SigitDFluidoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getElencoFluidi] END");
		}
	}

	public SigitDFluidoDto getFluidoById(Integer idFluido) throws DbManagerException
	{
		log.debug("[DbMgr::getFluidoById] START");
		try {
			return getSigitDFluidoDao().findByPrimaryKey(new SigitDFluidoPk(ConvertUtil.convertToBigDecimal(idFluido)));
		} catch (SigitDFluidoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getFluidoById] END");
		}
	}

	public List<SigitDUnitaMisuraDto> getElencoUnitaMisura() throws DbManagerException
	{
		log.debug("[DbMgr::getElencoUnitaMisura] START");
		try {
			return getSigitDUnitaMisuraDao().findAll();
		} catch (SigitDUnitaMisuraDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getElencoUnitaMisura] END");
		}
	}

	public SigitDUnitaMisuraDto getUnitaMisuraById(Integer idUnitaMisura) throws DbManagerException
	{
		log.debug("[DbMgr::getUnitaMisuraById] START");
		try {
			return getSigitDUnitaMisuraDao().findByPrimaryKey(new SigitDUnitaMisuraPk(ConvertUtil.convertToString(idUnitaMisura)));
		} catch (SigitDUnitaMisuraDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getUnitaMisuraById] END");
		}
	}

	public List<SigitDTipoContrattoDistribDto> getElencoTipoContrattoDistrib() throws DbManagerException
	{
		log.debug("[DbMgr::getElencoTipoContrattoDistrib] START");
		try {
			return getSigitDTipoContrattoDistribDao().findAll();
		} catch (SigitDTipoContrattoDistribDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getElencoTipoContrattoDistrib] END");
		}
	}

	public List<SigitDCategoriaUtilDto> getElencoCategoriaUtil() throws DbManagerException
	{
		log.debug("[DbMgr::getElencoCategoriaUtil] START");
		try {
			return getSigitDCategoriaUtilDao().findAll();
		} catch (SigitDCategoriaUtilDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getElencoCategoriaUtil] END");
		}
	}

	public List<SigitDDettaglioVmDto> getElencoDettaglioVm() throws DbManagerException
	{
		log.debug("[DbMgr::getElencoDettaglioVm] START");
		try {
			return getSigitDDettaglioVmDao().findAll();
		} catch (SigitDDettaglioVmDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getElencoDettaglioVm] END");
		}
	}

	public List<SigitDDettaglioVmDto> getElencoDettaglioVmByDescrizione(String descrizione) throws DbManagerException
	{
		log.debug("[DbMgr::getElencoDettaglioVmByDescrizione] START");
		try {
			return getSigitDDettaglioVmDao().findByDescrizione(descrizione);
		} catch (SigitDDettaglioVmDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getElencoDettaglioVmByDescrizione] END");
		}
	}


	public List<SigitDDettaglioGtDto> getElencoDettaglioGt() throws DbManagerException
	{
		log.debug("[DbMgr::getElencoDettaglioGt] START");
		try {
			return getSigitDDettaglioGtDao().findAll();
		} catch (SigitDDettaglioGtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getElencoDettaglioGt] END");
		}
	}

	public List<SigitDDettaglioGfDto> getElencoDettaglioGf() throws DbManagerException
	{
		log.debug("[DbMgr::getElencoDettaglioGf] START");
		try {
			return getSigitDDettaglioGfDao().findAll();
		} catch (SigitDDettaglioGfDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getElencoDettaglioGf] END");
		}
	}

	public Integer cercaAllegatiByFiltroCount(FiltroRicercaAllegati filter) throws ManagerException {
		log.debug("[DbMgr::cercaAllegatiByFiltroCount] BEGIN");
		Integer count = null;
		try {

//			dtoList = this.getSigitVRicercaAllegatiDao().findByFiltriUtente(filter);

			count = this.getSigitExtDao().findByFiltriUtenteCount(filter);

			validateResultSize(count, Constants.MAX_RIGHE);

//			if (dtoList != null)
//			{
//				count = dtoList.size();
//			}

		}
		catch(SigitExtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaAllegatiByFiltroCount] END");
		}
		return count;
	}

	public List<SigitVRicercaAllegatiDto> cercaAllegatiByFiltro(FiltroRicercaAllegati filter) throws DbManagerException {
		List<SigitVRicercaAllegatiDto> dtoList = null;
		log.debug("[DbMgr::cercaAllegatiByFiltro] BEGIN");
		try {

			dtoList = this.getSigitVRicercaAllegatiDao().findByFiltriUtente(filter);

		}
		catch(SigitVRicercaAllegatiDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaAllegatiByFiltro] END");
		}
		return dtoList;
	}

	/**
	 * Mi serve conoscere lo stato del libretto
	 *
	 * @param codice impianto
	 * @return una lista di libretti ordinati per idLibretto descendente
	 * @throws DbManagerException Errore durante il recupero dei dati
	 * @throws
	 */

	public List<SigitTLibrettoDto> getListaLibrettiByCodiceImpianto(Integer codiceImpianto) throws DbManagerException {
		List<SigitTLibrettoDto> dtoList = null;
		log.debug("[DbMgr::getListaLibrettiByCodiceImpianto] BEGIN");
		try {
			dtoList = getSigitTLibrettoDao().findByCodiceImpOrderById(codiceImpianto);
		}
		catch(SigitTLibrettoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getListaLibrettiByCodiceImpianto] END");
		}
		return dtoList;
	}

	/*
	public List<SigitVTotImpiantoDto> getImpiantiByFilter(ImpiantoFilter filter) throws DbManagerException
	{
		log.debug("[DbMgr::getImpiantiByFilter] BEGIN");
		List<SigitVTotImpiantoDto> dtoList = null;;
		try {
			dtoList = getSigitVTotImpiantoDao().findByImpiantoFilter(filter);
		} catch (SigitVTotImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getImpiantiByFilter] END");
		}
		return dtoList;

	}
	*/

	/**
	 * Trovo il dettaglio dell'allegato mediante la sua chiave
	 *
	 * @param id allegato
	 * @return un dettaglio
	 * @throws DbManagerException Errore durante il recupero dei dati
	 * @throws
	 */

	public DettaglioAllegato getDettaglioAllegatoById(Integer idAllegato) throws DbManagerException {
		return getDettaglioAllegatoById(idAllegato, false);
	}

	/**
	 * Implementazione del metodo che trova il dettaglio dell'allegato mediante la sua chiave
	 *
	 * @param idAllegato
	 * @param valore booleano che indica se la ricerca dell'allegato vado o meno effettuata sulla tabella dello storico
	 * @return un dettaglio allegato
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */
	public DettaglioAllegato getDettaglioAllegatoById(Integer idAllegato, boolean storico) throws DbManagerException {
		DettaglioAllegato dett =  null;
		log.debug("[DbMgr::getDettaglioAllegatoById] BEGIN");
		try {
			//ottengo il dettaglio mediante la sua pk
			//SigitTAllegatoDto allegato = getSigitTAllegatoDao().findByPrimaryKey(new SigitTAllegatoPk(ConvertUtil.convertToBigDecimal(idAllegato)));
			if(!storico) {
				SigitVRicercaAllegatiDto allegato = cercaSigitVRicercaAllegatiByIdAllegato(ConvertUtil.convertToString(idAllegato));
				//vado a mappare l'oggetto che mi interessa
				dett = MapDto.mapToDettaglioAllegato(allegato);
			}
			else {
				SigitVRicercaAllegatiStoricoDto allegato = cercaSigitVRicercaAllegatiStoricoByIdAllegato(ConvertUtil.convertToString(idAllegato));
				dett = MapDto.mapToDettaglioAllegatoStorico(allegato);
			}

			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(dett.getIdTipoAllegato()) || Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equals(dett.getIdTipoAllegato())) {

				// I Rapporto di Prova non vengono storicizzati

				BigDecimal fkIspezIspet = null;
				//trattasi di rapporto di prova. viene recuperata l'ispezione

				SigitTAllegatoDto datoDb = getSigitTAllegatoDao().findByPrimaryKey(new SigitTAllegatoPk(ConvertUtil.convertToBigDecimal(idAllegato)));

				fkIspezIspet = datoDb.getFkIspezIspet();

				// Recupero l'ispezione
				SigitRIspezIspetDto ispezione = getSigitRIspezIspetDao().findByPrimaryKey(new SigitRIspezIspetPk(fkIspezIspet));

				dett.setIdIspezione2018(ispezione.getIdIspezione2018());

			}
		}
		catch(DbManagerException e) {
			throw e;
		}
		catch (SigitTAllegatoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		catch(SigitRIspezIspetDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getDettaglioAllegatoById] END");
		}
		return dett;
	}



	/*
	public DettaglioAllegato getDettaglioAllegatoReeById(Integer idAllegato) throws DbManagerException {
		DettaglioAllegato dett =  null;
		log.debug("[DbMgr::getDettaglioAllegatoReeById] BEGIN");
		try {
			//ottengo il dettaglio mediante la sua pk
			//SigitTAllegatoDto allegato = getSigitTAllegatoDao().findByPrimaryKey(new SigitTAllegatoPk(ConvertUtil.convertToBigDecimal(idAllegato)));

			SigitVRicercaAllegatiDto allegato = cercaSigitVRicercaAllegatiByIdAllegato(ConvertUtil.convertToString(idAllegato));

			String idTipoAllegato = ConvertUtil.convertToString(allegato.getFkTipoDocumento());

			ArrayList<String> progressivi = new ArrayList<String>();
			String elencoApparecchiature = null;


			// Per sicurezza vado a cercare i le singole componenti
			if(Constants.ALLEGATO_TIPO_1.equals(idTipoAllegato))
			{

				List<SigitRAllegatoCompGtDto> compGt = getSigitRAllegatoCompGtDao().findByIdAllegatoGt(idAllegato);



				for (SigitRAllegatoCompGtDto sigitRAllegatoCompGtDto : compGt) {

					progressivi.add(ConvertUtil.convertToString(sigitRAllegatoCompGtDto.getProgressivo()));

				}

				CompFilter filter = new CompFilter(ConvertUtil.convertToString(allegato.getCodiceImpianto()), progressivi, allegato.getDataControllo());

				List<SigitVCompGtDto> gtList = getSigitVCompGtDao().findByCodImpiantoOrdered(filter);

				elencoApparecchiature = MapDto.mapToElencoComponentiGt(gtList);



			}
			if(Constants.ALLEGATO_TIPO_2.equals(idTipoAllegato))
			{
			}
			if(Constants.ALLEGATO_TIPO_3.equals(idTipoAllegato))
			{
			}
			if(Constants.ALLEGATO_TIPO_4.equals(idTipoAllegato))
			{
			}


			//vado a mappare l'oggetto che mi interessa
			dett = MapDto.mapToDettaglioAllegatoRee(allegato, progressivi, elencoApparecchiature);
		}
		catch(SigitVCompGtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		catch(SigitRAllegatoCompGtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		catch(DbManagerException e) {
			throw e;
		}
		finally {
			log.debug("[DbMgr::getDettaglioAllegatoReeById] END");
		}
		return dett;
	}
	*/


	/**
	 * Trovo il dettaglio dell'allegato mediante la sua chiave
	 *
	 * @param id allegato
	 * @return un dettaglio
	 * @throws DbManagerException Errore durante il recupero dei dati
	 * @throws
	 */

	public DettaglioIspezione getDettaglioIspezioneById(Integer idIspezione) throws DbManagerException {
		log.debug("[DbMgr::getDettaglioIspezioneById] BEGIN");

		DettaglioIspezione ispezione = null;

		try {

			//ottengo il dettaglio mediante la sua pk
			//SigitTAllegatoDto allegato = getSigitTAllegatoDao().findByPrimaryKey(new SigitTAllegatoPk(ConvertUtil.convertToBigDecimal(idAllegato)));

			List<SigitVRicercaIspezioniDto> ispezioniList = getSigitVRicercaIspezioniDao().findByIdIspezione(idIspezione);
			SigitVRicercaIspezioniDto ispezioneDto = null;
			if (ispezioniList != null && ispezioniList.size() == 1)
			{
				ispezioneDto = ispezioniList.get(0);

				//vado a mappare l'oggetto che mi interessa
				ispezione = MapDto.mapToDettaglioIspezione(ispezioneDto);
			}


		}
		catch(SigitVRicercaIspezioniDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getDettaglioIspezioneById] END");
		}
		return ispezione;
	}

	/*
	public List<SigitTDocAggiuntivaDto> findDocIspezioneById(Integer idIspezione) throws DbManagerException {
		List<SigitTDocAggiuntivaDto> dtoList = null;
		log.debug("[DbMgr::findDocIspezioneById] BEGIN");
		try {
			//dtoList = getSigitTDocAggiuntivaDao().findByIdImpRuoloPfpg(idIspezione);
		}
		catch(SigitTDocAggiuntivaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::findDocIspezioneById] END");
		}
		return dtoList;
	}
	*/

	public DettaglioIspezione getDettaglioIspezioneByIdIspezIspet(Integer idIspezIspet) throws DbManagerException {
		log.debug("[DbMgr::getDettaglioIspezioneByIdIspezIspet] BEGIN");

		DettaglioIspezione ispezione = null;

		try {

			//ottengo il dettaglio mediante la sua pk
			//SigitTAllegatoDto allegato = getSigitTAllegatoDao().findByPrimaryKey(new SigitTAllegatoPk(ConvertUtil.convertToBigDecimal(idAllegato)));

			List<SigitVRicercaIspezioniDto> ispezioniList = getSigitVRicercaIspezioniDao().findByIdIspezIspet(idIspezIspet);
			SigitVRicercaIspezioniDto ispezioneDto = null;
			if (ispezioniList != null && ispezioniList.size() == 1)
			{
				ispezioneDto = ispezioniList.get(0);

				//vado a mappare l'oggetto che mi interessa
				ispezione = MapDto.mapToDettaglioIspezione(ispezioneDto);
			}


		}
		catch(SigitVRicercaIspezioniDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getDettaglioIspezioneByIdIspezIspet] END");
		}
		return ispezione;
	}

	/** DA VERIFICARE
	 * Trovo il dettaglio dell'allegato mediante la sua chiave
	 *
	 * @param id allegato
	 * @return un dettaglio
	 * @throws DbManagerException Errore durante il recupero dei dati
	 * @throws
	 */

	public DettaglioAllegato getDettaglioAllegatoByIdAllegato(Integer idAllegato, String codiceImpianto) throws DbManagerException {
		DettaglioAllegato dett =  null;
		log.debug("[DbMgr::getDettaglioAllegatoByIdAllegato] BEGIN");
//		String siglaBollino = null;
		try {
			//preparo l'oggetto in input
			//SigitTAllegatoPk pk = new SigitTAllegatoPk() ;
			//pk.setIdAllegato(new BigDecimal(ConvertUtil.convertToString(idAllegato)));
			//ottengo il dettaglio mediante la sua pk
			//SigitTAllegatoDto allegato = getSigitTAllegatoDao().findByPrimaryKey(pk);

			SigitVRicercaAllegatiDto allegato = cercaSigitVRicercaAllegatiByIdAllegato(ConvertUtil.convertToString(idAllegato));

			//cerco lo stato dell'allegato
			SigitDStatoRappPk pkStato = new SigitDStatoRappPk();
			pkStato.setIdStatoRapp(allegato.getFkStatoRapp());
			SigitDStatoRappDto dettaglioStato = this.getSigitDStatoRappDao().findByPrimaryKey(pkStato);
			//cerco il tipo di documento
			SigitDTipoDocumentoPk pkTipoDoc = new SigitDTipoDocumentoPk();
			pkTipoDoc.setIdTipoDocumento(allegato.getFkTipoDocumento());
			SigitDTipoDocumentoDto dettaglioTipoDoc = this.getSigitDTipoDocumentoDao().findByPrimaryKey(pkTipoDoc );

			/*
			//cerco la sigla del bollino dal numero che ho ricavato dall'allegato
			if(allegato.getFkNumeroBollino()!=null){
				List<SigitTCodiceBollDto> lista = this.getSigitTCodiceBollDao().findByNumeroBollino(ConvertUtil.convertToInteger(allegato.getFkNumeroBollino()));
				//ne devo avere solo uno
				if(lista!=null && lista.size()>0){
					SigitTCodiceBollDto codDto = lista.get(0);
					siglaBollino = codDto.getSiglaBollino();
				}
			}else{
				siglaBollino = Constants.SIGLA_BOLLINO_RP;
			}
			*/
			//vado a mappare l'oggetto che mi interessa

			dett = MapDto.mapToDettaglioAllegato(allegato, dettaglioStato.getDesStatoRapp(), dettaglioTipoDoc.getDesTipoDocumento(), codiceImpianto);
		}
		 catch (SigitDStatoRappDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitDTipoDocumentoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (DbManagerException e) {
			throw e;
		}


//		catch (SigitTCodiceBollDaoException e) {
//			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
//		}
		finally {
			log.debug("[DbMgr::getDettaglioAllegatoByIdAllegato] END");
		}
		return dett;
	}

	public List<SigitTAllegatoControlloBollinoAssegnatoAltroImpiantoDto> controlloBollinoAssegnatoAltroImpianto(String numeroBollino, String idAllegato ) throws DbManagerException {
		List<SigitTAllegatoControlloBollinoAssegnatoAltroImpiantoDto> dtoList = null;
		log.debug("[DbMgr::controlloBollinoAssegnatoAltroImpianto] BEGIN");
		try {
				SigitTAllegatoDto dto = new SigitTAllegatoDto();
				//perche' posso essere nell'inserimento
				if(GenericUtil.isNotNullOrEmpty(idAllegato))
					dto.setIdAllegato(new BigDecimal(idAllegato));
				//il controllo viene effettuato se lo hanno selezionato
				dto.setFkNumeroBollino(new BigDecimal(numeroBollino));
				dtoList = this.getSigitTAllegatoDao().findControlloBollinoAssegnatoAltroImpianto(dto );

		} catch (SigitTAllegatoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::controlloBollinoAssegnatoAltroImpianto] END");
		}
		return dtoList;
	}



	/**
	 * Cerco la data di assegnazione del codice impianto
	 *
	 * @param codice impianto
	 * @return un Impianto
	 * @throws DbManagerException Errore durante il recupero dei dati
	 * @throws
	 */

	/**
	 * Cerco il codice bollino riferito alla data controllo
	 *
	 * @param codice impianto
	 * @return un Impianto
	 * @throws DbManagerException Errore durante il recupero dei dati
	 * @throws
	 */

	public List<SigitTCodiceBollDto> getCodiceBollInDataControllo(String siglaBollino, String numeroBollino, String dataControllo) throws DbManagerException {
		List<SigitTCodiceBollDto> list = null;
		log.debug("[DbMgr::getCodiceBollInDataControllo] BEGIN");
		try {

			TransazioneFilter filter = new TransazioneFilter();
			filter.setSiglaBollino(siglaBollino);
			filter.setNumeroBollino(ConvertUtil.convertToInteger(numeroBollino));
			filter.setDataControllo(ConvertUtil.convertToSqlDate(dataControllo));

			list = getSigitTCodiceBollDao().findByNumeroBollinoDataControllo(filter);

		}
		catch (SigitTCodiceBollDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCodiceBollInDataControllo] END");
		}
		return list;
	}

	/*
	public int getManutentoriCount(String codImpianto, String tipoComponente, String dataControllo, List<String> listaProgressivi) throws DbManagerException
	{
		log.debug("[DbMgr::getManutentoriCount] START");
		try {
			CompFilter input = new CompFilter(codImpianto, tipoComponente, listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitExtDao().findManutentoriByFilterCount(input);
		} catch (SigitExtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getManutentoriCount] END");
		}
	}
	*/

	/*
	public List<SigitTAllegatoDto> cercaAllegatoByCodiceBollino(String siglaBollino, Integer numeroBollino) throws DbManagerException
	{
		log.debug("[DbMgr::cercaAllegatoByCodiceBollino] START");
		try
		{
			BollinoFilter filter = new BollinoFilter(siglaBollino, numeroBollino);

			return getSigitTAllegatoDao().findByCodiceBollino(filter);
		} catch (SigitTAllegatoDaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::cercaAllegatoByCodiceBollino] END");
		}

	}
	*/

	public List<SigitVSk4GtDto> getCompGtAttiviInData(String codImpianto, Date dataControllo) throws DbManagerException
	{
		log.debug("[DbMgr::getCompGtAttiviInData] START");
		try {
			SigitVSk4GtDto input = new SigitVSk4GtDto();
			input.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			input.setDataInstall(new java.sql.Date(dataControllo.getTime()));

			return getSigitVSk4GtDao().findAttiviByCodImpianto(input);
		} catch (SigitVSk4GtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompGtAttiviInData] END");
		}
	}

	public List<SigitVSk4GtDto> getCompGtAttiviInDataByIdPg(String codImpianto, Date dataControllo, BigDecimal idPersonaGiusridica) throws DbManagerException
	{
		log.debug("[DbMgr::getCompGtAttiviInDataByIdPg] START");
		try {

			AllegatiCompFilter input = new AllegatiCompFilter();
			input.setCodImpianto(codImpianto);
			input.setDataControllo(ConvertUtil.convertToSqlDate(dataControllo));
			input.setIdImpRuoloPfPg(ConvertUtil.convertToInteger(idPersonaGiusridica));

			return getSigitVSk4GtDao().findAttiviByCodImpiantoFkPg(input);
		} catch (SigitVSk4GtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompGtAttiviInDataByIdPg] END");
		}
	}

	public List<SigitVSk4GtDto> getCompGtAttiviInDataProgressivi(String codImpianto, String dataControllo, List<String> listaProgressivi) throws DbManagerException
	{
		log.debug("[DbMgr::getCompGtAttiviInDataProgressivi] START");
		try {
			CompFilter input = new CompFilter(codImpianto, listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitVSk4GtDao().findAttiviByCodImpiantoProgressivi(input);
		} catch (SigitVSk4GtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompGtAttiviInDataProgressivi] END");
		}
	}


	public List<SigitVSk4GtDto> getCompGtByIdAllegato(Integer idAllegato) throws DbManagerException
	{
		log.debug("[DbMgr::getCompGtByIdAllegato] START");
		try {
			return getSigitVSk4GtDao().findByIdAllegato(idAllegato);
		} catch (SigitVSk4GtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompGtByIdAllegato] END");
		}
	}

	public List<SigitVSk4GfDto> getCompGfByIdAllegato(Integer idAllegato) throws DbManagerException
	{
		log.debug("[DbMgr::getCompGfByIdAllegato] START");
		try {
			return getSigitVSk4GfDao().findByIdAllegato(idAllegato);
		} catch (SigitVSk4GfDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompGfByIdAllegato] END");
		}
	}

	public List<SigitVSk4ScDto> getCompScByIdAllegato(Integer idAllegato) throws DbManagerException
	{
		log.debug("[DbMgr::getCompScByIdAllegato] START");
		try {
			return getSigitVSk4ScDao().findByIdAllegato(idAllegato);
		} catch (SigitVSk4ScDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompScByIdAllegato] END");
		}
	}

	public List<SigitVSk4CgDto> getCompCgByIdAllegato(Integer idAllegato) throws DbManagerException
	{
		log.debug("[DbMgr::getCompCgByIdAllegato] START");
		try {
			return getSigitVSk4CgDao().findByIdAllegato(idAllegato);
		} catch (SigitVSk4CgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompCgByIdAllegato] END");
		}
	}
	public List<SigitVSk4GfDto> getCompGfAttiviInData(String codImpianto, Date dataControllo) throws DbManagerException
	{
		log.debug("[DbMgr::getCompGfAttiviInData] START");
		try {
			SigitVSk4GfDto input = new SigitVSk4GfDto();
			input.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			input.setDataInstall(new java.sql.Date(dataControllo.getTime()));
			return getSigitVSk4GfDao().findAttiviByCodImpianto(input);
		} catch (SigitVSk4GfDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompGfAttiviInData] END");
		}
	}

	public List<SigitVSk4GfDto> getCompGfAttiviInDataByIdPg(String codImpianto, Date dataControllo, BigDecimal idPersonaGiusridica) throws DbManagerException
	{
		log.debug("[DbMgr::getCompGfAttiviInDataByIdPg] START");
		try {

			AllegatiCompFilter input = new AllegatiCompFilter();
			input.setCodImpianto(codImpianto);
			input.setDataControllo(ConvertUtil.convertToSqlDate(dataControllo));
			input.setIdImpRuoloPfPg(ConvertUtil.convertToInteger(idPersonaGiusridica));

			return getSigitVSk4GfDao().findAttiviByCodImpiantoFkPg(input);
		} catch (SigitVSk4GfDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompGfAttiviInDataByIdPg] END");
		}
	}

	public List<SigitVSk4GfDto> getCompGfAttiviInDataProgressivi(String codImpianto, String dataControllo, List<String> listaProgressivi) throws DbManagerException
	{
		log.debug("[DbMgr::getCompGfAttiviInDataProgressivi] START");
		try {
			CompFilter input = new CompFilter(codImpianto, listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitVSk4GfDao().findAttiviByCodImpiantoProgressivi(input);
		} catch (SigitVSk4GfDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompGfAttiviInDataProgressivi] END");
		}
	}

	public List<SigitVSk4ScDto> getCompScAttiviInData(String codImpianto, Date dataControllo) throws DbManagerException
	{
		log.debug("[DbMgr::getCompScAttiviInData] START");
		try {
			SigitVSk4ScDto input = new SigitVSk4ScDto();
			input.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			input.setDataInstall(new java.sql.Date(dataControllo.getTime()));
			return getSigitVSk4ScDao().findAttiviByCodImpianto(input);
		} catch (SigitVSk4ScDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompScAttiviInData] END");
		}
	}

	public List<SigitVSk4ScDto> getCompScAttiviInDataByIdPg(String codImpianto, Date dataControllo, BigDecimal idPersonaGiusridica) throws DbManagerException
	{
		log.debug("[DbMgr::getCompScAttiviInDataByIdPg] START");
		try {

			AllegatiCompFilter input = new AllegatiCompFilter();
			input.setCodImpianto(codImpianto);
			input.setDataControllo(ConvertUtil.convertToSqlDate(dataControllo));
			input.setIdImpRuoloPfPg(ConvertUtil.convertToInteger(idPersonaGiusridica));

			return getSigitVSk4ScDao().findAttiviByCodImpiantoFkPg(input);
		} catch (SigitVSk4ScDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompScAttiviInDataByIdPg] END");
		}
	}

	public List<SigitVSk4ScDto> getCompScAttiviInDataProgressivi(String codImpianto, String dataControllo, List<String> listaProgressivi) throws DbManagerException
	{
		log.debug("[DbMgr::getCompScAttiviInDataProgressivi] START");
		try {
			CompFilter input = new CompFilter(codImpianto, listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitVSk4ScDao().findAttiviByCodImpiantoProgressivi(input);
		} catch (SigitVSk4ScDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompScAttiviInDataProgressivi] END");
		}
	}

	public List<SigitVSk4CgDto> getCompCgAttiviInData(String codImpianto, Date dataControllo) throws DbManagerException
	{
		log.debug("[DbMgr::getCompCgAttiviInData] START");
		try {
			SigitVSk4CgDto input = new SigitVSk4CgDto();
			input.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			input.setDataInstall(new java.sql.Date(dataControllo.getTime()));
			return getSigitVSk4CgDao().findAttiviByCodImpianto(input);
		} catch (SigitVSk4CgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompCgAttiviInData] END");
		}
	}

	public List<SigitVSk4CgDto> getCompCgAttiviInDataByIdPg(String codImpianto, Date dataControllo, BigDecimal idPersonaGiusridica) throws DbManagerException
	{
		log.debug("[DbMgr::getCompCgAttiviInDataByIdPg] START");
		try {

			AllegatiCompFilter input = new AllegatiCompFilter();
			input.setCodImpianto(codImpianto);
			input.setDataControllo(ConvertUtil.convertToSqlDate(dataControllo));
			input.setIdImpRuoloPfPg(ConvertUtil.convertToInteger(idPersonaGiusridica));

			return getSigitVSk4CgDao().findAttiviByCodImpiantoFkPg(input);
		} catch (SigitVSk4CgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompCgAttiviInDataByIdPg] END");
		}
	}

	public List<SigitVSk4CgDto> getCompCgAttiviInDataProgressivi(String codImpianto, String dataControllo, List<String> listaProgressivi) throws DbManagerException
	{
		log.debug("[DbMgr::getCompCgAttiviInDataProgressivi] START");
		try {
			CompFilter input = new CompFilter(codImpianto, listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitVSk4CgDao().findAttiviByCodImpiantoProgressivi(input);
		} catch (SigitVSk4CgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompCgAttiviInDataProgressivi] END");
		}
	}


	/**
	 * Cerco l'fk_imp_ruolo_pfpg
	 *
	 * @param codice impianto
	 * @return id persona giuridica
	 * @throws DbManagerException Errore durante il recupero dei dati
	 * @throws
	 */

	public String  getIdPersonaGiuridicaByAllegato(String codiceImpianto, Integer idPersonaGiuridica, Integer idTipoDocumento) throws DbManagerException {
		String value = null;
		log.debug("[DbMgr::getIdPersonaGiuridicaByAllegato] BEGIN");
		try {
			FiltroControlloInserisciAllegato inputR = new FiltroControlloInserisciAllegato();
			inputR.setIdTipoDocumento(idTipoDocumento);
			//cerco il ruolo dalla tabella di relazione sigit_r_ruolo_tipodoc
			List<SigitRRuoloTipodocDto> rRuoloTipoDoc = this.getSigitRRuoloTipodocDao().findVerificaAllegatoSelezionato(inputR);

//			SigitRImpRuoloPfpgDto input = new SigitRImpRuoloPfpgDto();
//			input.setCodiceImpianto(new BigDecimal(codiceImpianto));
//			input.setFkPersonaGiuridica(new BigDecimal(ConvertUtil.convertToString(idPersonaGiuridica)));
//			if(rRuoloTipoDoc!=null){
//				SigitRRuoloTipodocDto ruolo = rRuoloTipoDoc.get(0);
//				input.setFkRuolo(ruolo.getIdRuolo());
//			}
//
//
//			//cerco un oggetto univoco
//			List<SigitRImpRuoloPfpgDto> dtoRImp = getSigitRImpRuoloPfpgDao().findByPersonaGiuridicaCodImpianto(input);

			CompFilter filter = new CompFilter();
			filter.setCodImpianto(codiceImpianto);
			filter.setIdPG(idPersonaGiuridica);
			if(rRuoloTipoDoc!=null){
				SigitRRuoloTipodocDto ruolo = rRuoloTipoDoc.get(0);
				filter.setIdRuolo(ConvertUtil.convertToInteger(ruolo.getIdRuolo()));
			}

			List<SigitRComp4ManutDto> dtoRImp = getSigitRComp4ManutDao().findByPersonaGiuridicaCodImpianto(filter);
			if(dtoRImp!=null && dtoRImp.size()>0){
				SigitRComp4ManutDto dto = dtoRImp.get(0);
				//recupero l'id
				value = ConvertUtil.convertToString(dto.getFkPersonaGiuridica());
			}
		}
		catch (SigitRComp4ManutDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitRRuoloTipodocDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getIdPersonaGiuridicaByAllegato] END");
		}
		return value;
	}


	public void aggiornaRapportoControllo(SigitTAllegatoDto dto) throws DbManagerException {
		log.debug("[DbMgr::aggiornaRapportoControllo] BEGIN");
		try {

			getSigitTAllegatoDao().update(dto);

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::aggiornaRapportoControllo] END");
		}
	}

	public void aggiornaRespRAllegatoComp(BigDecimal idAllegato, String codImpianto, String dataRapporto,
			String idTipoComponente, BigDecimal componente, java.sql.Date dataInstallazione,
			BigDecimal idImpRuoloPfPg, BigDecimal idContratto) throws DbManagerException {
		log.debug("[DbMgr::aggiornaStatoTransazioneBoll] BEGIN");
		try {

			if (idTipoComponente.equals(Constants.TIPO_COMPONENTE_GT))
			{
				SigitRAllegatoCompGtDto dto = new SigitRAllegatoCompGtDto();
				dto.setIdAllegato(idAllegato);
				dto.setIdTipoComponente(idTipoComponente);
				dto.setProgressivo(componente);
				dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
				dto.setDataInstall(dataInstallazione);

				if (idImpRuoloPfPg != null)
					dto.setFkImpRuoloPfpg(idImpRuoloPfPg);

				if (idContratto != null)
					dto.setFkContratto(idContratto);

				getSigitRAllegatoCompGtDao().updateColumnsResponsabile(dto);
			}
			else if (idTipoComponente.equals(Constants.TIPO_COMPONENTE_GF))
			{
				SigitRAllegatoCompGfDto dto = new SigitRAllegatoCompGfDto();
				dto.setIdAllegato(idAllegato);
				dto.setIdTipoComponente(idTipoComponente);
				dto.setProgressivo(componente);
				dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
				dto.setDataInstall(dataInstallazione);

				if (idImpRuoloPfPg != null)
					dto.setFkImpRuoloPfpg(idImpRuoloPfPg);

				if (idContratto != null)
					dto.setFkContratto(idContratto);

				getSigitRAllegatoCompGfDao().updateColumnsResponsabile(dto);
			}
			else if (idTipoComponente.equals(Constants.TIPO_COMPONENTE_SC))
			{
				SigitRAllegatoCompScDto dto = new SigitRAllegatoCompScDto();
				dto.setIdAllegato(idAllegato);
				dto.setIdTipoComponente(idTipoComponente);
				dto.setProgressivo(componente);
				dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
				dto.setDataInstall(dataInstallazione);

				if (idImpRuoloPfPg != null)
					dto.setFkImpRuoloPfpg(idImpRuoloPfPg);

				if (idContratto != null)
					dto.setFkContratto(idContratto);

				getSigitRAllegatoCompScDao().updateColumnsResponsabile(dto);
			}
			else if (idTipoComponente.equals(Constants.TIPO_COMPONENTE_CG))
			{
				SigitRAllegatoCompCgDto dto = new SigitRAllegatoCompCgDto();
				dto.setIdAllegato(idAllegato);
				dto.setIdTipoComponente(idTipoComponente);
				dto.setProgressivo(componente);
				dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
				dto.setDataInstall(dataInstallazione);

				if (idImpRuoloPfPg != null)
					dto.setFkImpRuoloPfpg(idImpRuoloPfPg);

				if (idContratto != null)
					dto.setFkContratto(idContratto);

				getSigitRAllegatoCompCgDao().updateColumnsResponsabile(dto);
			}
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::aggiornaStatoTransazioneBoll] END");
		}
	}

	public MODIIDocument getModuloAllegatoTipo1Now(DettaglioAllegato dettaglio)throws DbManagerException {
		log.debug("[DbMgr::getModuloAllegatoTipo1Now] BEGIN");

		it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument modAllegato = it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument.Factory.newInstance();

		SigitTAllegatoDto allegatoDto = null;
		SigitTImpiantoDto impiantoDto =null;


		// Se il responsabile e una PG
		SigitTPersonaGiuridicaDto pgResp = null;
		// Se il responsabile e una PF
		SigitTPersonaFisicaDto pf = null;
		//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		SigitTPersonaGiuridicaDto pg = null;

		// qui setto l'idImpRuoloPfpg del responsabile
		BigDecimal idImpRuoloPfpg = null;

		boolean isTerzoResp = false;

		SigitTPersonaGiuridicaDto manutentore = null;
		DettaglioIspezione dettaglioIspezione = null;

		String idRuoloResp = null;
		//in questo oggetto setto l'id 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		String idRuolo = null;

		try {
			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(new BigDecimal(dettaglio.getIdAllegato()));

			//trovo il dettaglio ALLEGATO
			allegatoDto = getSigitTAllegatoDao().findByPrimaryKey(pk);

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			//trovo il dettaglio IMPIANTO
			impiantoDto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			//trovo l'unita' immobiliare,dati locazione impianto
			List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()), ConvertUtil.convertToSqlDate(dettaglio.getDataControllo()));

			//sezione c. TRATTAMENTO DELL'ACQUA
//			SigitTTrattH2OPk pkTrattAcqua = new SigitTTrattH2OPk();
//			pkTrattAcqua.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));
			SigitTTrattH2ODto dettaglioTrattAcqua = cercaSigitTTrattH2OByCodImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			if (responsabile != null)
			{
				if(responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				}else{
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica );
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToString(responsabile.getIdRuolo());
			}


			/*
			log.debug("[DbMgr::getModuloAllegatoTipo1Now] COMINCIO IL MAPPING DEI DATI");
			//comincio il mapping dei dati
			it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta richiesta = modulo.getMODII().getRichiesta();
			//codice Bollino comune a tutte le pagine
			richiesta.getDatiIntestazione().setCodiceBollino(ConvertUtil.formattaSiglaBollino(allegatoDto.getFkNumeroBollino()));
			//vado a lavorare sulle pagine del modulo
			List<RowAllegatoII> allegatoIIList = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
			*/
			//istanzio gli oggetti per modol

			it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument.MODII mod = modAllegato.addNewMODII();
			it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta richiesta = mod.addNewRichiesta();
			List<RowAllegatoII> listaRow = richiesta.addNewDatiAllegato().addNewAllegatoII().getRowAllegatoIIList();
			modAllegato.getMODII().addNewSystem().addNewCatDig();
			//dati che sono comuni e non ripetuti per ogni pagina
			DatiModulo datiModulo = richiesta.addNewDatiModulo();
			DatiIntestazione datiIntestazione = richiesta.addNewDatiIntestazione();
			datiIntestazione.setCodiceBollino(ConvertUtil.formattaSiglaBollino(ConvertUtil.convertToBigDecimal(dettaglio.getNumeroBollinoVerde())));

			datiModulo.setStatoModulo(Constants.STATO_MODULO_BOZZA);

			log.debug("[ServiziMgr::getAllegato] ****** INSERIMENTO *****  da.getIdAllegato(): "+dettaglio.getIdAllegato());
			//setto l'idAllegato dentro il modulo
			datiModulo.setIdAllegato(dettaglio.getIdAllegato());

			//bisogna creare tante pagine quanti sono i risultati della seguente lista
			RowAllegatoII allegatoII = null;

			// Devo recupera tutti i progressivi per cui devo fare l'allegato
			List<SigitVSk4GtDto> dtoList = getCompGtByIdAllegato(ConvertUtil.convertToInteger(dettaglio.getIdAllegato()));

			//for(RowAllegatoII allegatoII : allegatoIIList){
			for(SigitVSk4GtDto sk4Gt : dtoList){
				//log.debug("Quanti moduli di tipo allegatoII count: "+count);

				// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
				List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());

				if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
				{
					SigitVRicerca3ResponsabileDto responsabile2 = list3RespAttiviImpianto.get(0);
					isTerzoResp = true;

					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
					pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
					idRuolo = ""+responsabile.getIdRuolo();

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToBigDecimal(sk4Gt.getProgressivo()), sk4Gt.getDataInstall(),
							null, responsabile2.getIdContratto());

				}
				else
				{
					//vTotImpianto = vTotImpiantoResp;
					pg = pgResp;
					idRuolo = idRuoloResp;

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToBigDecimal(sk4Gt.getProgressivo()), sk4Gt.getDataInstall(),
							idImpRuoloPfpg, null);

				}


				log.debug("idRuolo: "+idRuolo);
				//MapDto.mapToDatiPrecompilatiAllegato1Now(allegatoII, listaUnitaImmobiliare, impiantoDto, allegatoDto);
				//MapDto.mapToDatiRespImpiantoAllegato1Now(allegatoII, pg, pf, idRuolo, isTerzoResp);
				SigitTRappTipo1Dto rappTipo1Dto = cercaTRappTipo1ById(allegatoDto.getIdAllegato());

				List<SigitTDettTipo1Dto> tDettTipo1List	= getDettTipo1(ConvertUtil.convertToString(sk4Gt.getCodiceImpianto()), ConvertUtil.convertToInteger(sk4Gt.getProgressivo()), dettaglio.getIdAllegato());

				// Passo il primo elemento del dettaglio, mi servono solo i dati generali che sono comuni a tutte le righe
				allegatoII = MapDto.mapToDatiAllegato1Now(sk4Gt, allegatoDto, rappTipo1Dto, tDettTipo1List.get(0), pg, pf, idRuolo, isTerzoResp, listaUnitaImmobiliare, impiantoDto, dettaglioTrattAcqua);

				if (GenericUtil.isNotNullOrEmpty(dettaglio.getIdIspezione()))
				{
					// Recupero l'ispezione
					dettaglioIspezione = getDettaglioIspezioneById(dettaglio.getIdIspezione());

					allegatoII.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
				}
				else
				{

					//manutentore = getImpresaManutentrice(ConvertUtil.convertToString(allegatoDto.getFkImpRuoloPfpg()));
					manutentore =  cercaTPersonaGiuridicaById(dettaglio.getIdPersonaGiuridica());

					//mapping dati dell'impresa manutentrice
					MapDto.mapToDatiImpresaManutentriceAllegato1(allegatoII, manutentore);
				}


//				List<SigitTDettTipo1Dto> tDettTipo1List = getDettTipo1(dettaglio.getCodiceImpianto(),
//						ConvertUtil.convertToInteger(sk4Gt.getProgressivo()), ConvertUtil.convertToString(allegatoDto.getIdAllegato()));

				 MapDto.mapToDatiAllegato1RowFumiNow(allegatoII, tDettTipo1List);

				 listaRow.add(allegatoII);

				//count++; //da cancelare
			}

			if(modAllegato.getMODII().getSystem()==null)
				modAllegato.getMODII().addNewSystem().addNewCatDig();
			if(modAllegato.getMODII().getSystem().getCatDig()==null)
				modAllegato.getMODII().getSystem().addNewCatDig();

			//definisce lo stato del modulo pdf ed e' comune a tutte le pagine
//		    if(isDefinitivo)
//			{
		    	richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
		    	modAllegato.getMODII().getSystem().getCatDig().setModuloEditabile(false);
//			}
//			else
//			{
//				richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_BOZZA);
//				modAllegato.getMODII().getSystem().getCatDig().setModuloEditabile(true);
//			}


		    	if (log.isDebugEnabled())
		    	{
		    		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		    		log.debug("STAMPO ALLEGATOII RESULT: "+modAllegato);
		    		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		    	}

		} catch (SigitTAllegatoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}

		log.debug("[DbMgr::getModuloAllegatoTipo1Now] END");

		//XXX

		return modAllegato;
	}











	public MODIIDocument getModuloAllegatoTipo1NowFattorComune(DettaglioAllegato dettaglio)throws DbManagerException {
		log.debug("[DbMgr::getModuloAllegatoTipo1NowFattorComune] BEGIN");

		it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument modAllegato = it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument.Factory.newInstance();

		//SigitTAllegatoDto allegatoDto = null;
		//SigitTImpiantoDto impiantoDto =null;

		// Se il responsabile e una PG
		//SigitTPersonaGiuridicaDto pgResp = null;
		// Se il responsabile e una PF
		//SigitTPersonaFisicaDto pf = null;
		//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		//SigitTPersonaGiuridicaDto pg = null;

		// qui setto l'idImpRuoloPfpg del responsabile
		//BigDecimal idImpRuoloPfpg = null;

		//boolean isTerzoResp = false;

		SigitTPersonaGiuridicaDto manutentore = null;
		DettaglioIspezione dettaglioIspezione = null;

		//Integer idRuoloResp = null;
		//in questo oggetto setto l'id 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		//Integer idRuolo = null;

		try {

			/*

			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(new BigDecimal(dettaglio.getIdAllegato()));

			//trovo il dettaglio ALLEGATO
			allegatoDto = getSigitTAllegatoDao().findByPrimaryKey(pk);



			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));
			*/

			//trovo il dettaglio IMPIANTO
			//impiantoDto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			//trovo l'unita' immobiliare,dati locazione impianto
			//List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			/*
			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()), ConvertUtil.convertToSqlDate(dettaglio.getDataControllo()));

			//sezione c. TRATTAMENTO DELL'ACQUA
//			SigitTTrattH2OPk pkTrattAcqua = new SigitTTrattH2OPk();
//			pkTrattAcqua.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));
			SigitTTrattH2ODto dettaglioTrattAcqua = cercaSigitTTrattH2OByCodImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			if (responsabile != null)
			{
				if(responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				}else{
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica );
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToInteger(responsabile.getIdRuolo());
			}
			*/

			/*
			log.debug("[DbMgr::getModuloAllegatoTipo1Now] COMINCIO IL MAPPING DEI DATI");
			//comincio il mapping dei dati
			it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta richiesta = modulo.getMODII().getRichiesta();
			//codice Bollino comune a tutte le pagine
			richiesta.getDatiIntestazione().setCodiceBollino(ConvertUtil.formattaSiglaBollino(allegatoDto.getFkNumeroBollino()));
			//vado a lavorare sulle pagine del modulo
			List<RowAllegatoII> allegatoIIList = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
			*/
			//istanzio gli oggetti per modol

			it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument.MODII mod = modAllegato.addNewMODII();
			it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta richiesta = mod.addNewRichiesta();
			List<RowAllegatoII> listaRow = richiesta.addNewDatiAllegato().addNewAllegatoII().getRowAllegatoIIList();
			modAllegato.getMODII().addNewSystem().addNewCatDig();
			//dati che sono comuni e non ripetuti per ogni pagina
			DatiModulo datiModulo = richiesta.addNewDatiModulo();
			DatiIntestazione datiIntestazione = richiesta.addNewDatiIntestazione();
			datiIntestazione.setCodiceBollino(ConvertUtil.formattaSiglaBollino(ConvertUtil.convertToBigDecimal(dettaglio.getNumeroBollinoVerde())));

			datiModulo.setStatoModulo(Constants.STATO_MODULO_BOZZA);

			log.debug("[ServiziMgr::getAllegato] ****** INSERIMENTO *****  da.getIdAllegato(): "+dettaglio.getIdAllegato());
			//setto l'idAllegato dentro il modulo
			datiModulo.setIdAllegato(dettaglio.getIdAllegato());

			//bisogna creare tante pagine quanti sono i risultati della seguente lista
			RowAllegatoII allegatoII = null;

			// Devo recupera tutti i progressivi per cui devo fare l'allegato
			//List<SigitVSk4GtDto> dtoList = getCompGtByIdAllegato(ConvertUtil.convertToInteger(dettaglio.getIdAllegato()));

			/*
			// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());

			SigitVRicerca3ResponsabileDto responsabile2 = null;
			if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
			{
				responsabile2 = list3RespAttiviImpianto.get(0);
				isTerzoResp = true;

				SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
				pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
				pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				idRuolo = ConvertUtil.convertToInteger(responsabile.getIdRuolo());

			}
			else
			{
				//vTotImpianto = vTotImpiantoResp;
				pg = pgResp;
				idRuolo = idRuoloResp;

			}

			for(SigitVSk4GtDto sk4Gt : dtoList){

				if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
				{
					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToBigDecimal(sk4Gt.getProgressivo()), sk4Gt.getDataInstall(),
							null, responsabile2.getIdContratto());

				}
				else
				{
					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToBigDecimal(sk4Gt.getProgressivo()), sk4Gt.getDataInstall(),
							idImpRuoloPfpg, null);
				}

			}


			DatiAllegato1Common allegato1Common = new DatiAllegato1Common();
			allegato1Common.setSk4GtDtoList(dtoList);
			allegato1Common.setPersonaGiuridicaDto(pg);
			allegato1Common.setPersonaFisicaDto(pf);
			allegato1Common.setDettaglioTrattAcquaSto(dettaglioTrattAcqua);
			allegato1Common.setRuolo(idRuolo);
			allegato1Common.setTerzoResp(isTerzoResp);

*/

			DatiGTCommon allegato1Common = getDettaglioAllegato1Common(dettaglio);

			// SigitTRappTipo1Dto rappTipo1Dto = cercaTRappTipo1ById(allegatoDto.getIdAllegato());
			SigitTRappTipo1Dto rappTipo1Dto = cercaTRappTipo1ById(ConvertUtil.convertToBigDecimal(dettaglio.getIdAllegato()));

			for(SigitVSk4GtDto sk4Gt : allegato1Common.getSk4GtDtoList()){
				//log.debug("Quanti moduli di tipo allegatoII count: "+count);

				List<SigitTDettTipo1Dto> tDettTipo1List	= getDettTipo1(ConvertUtil.convertToString(sk4Gt.getCodiceImpianto()), ConvertUtil.convertToInteger(sk4Gt.getProgressivo()), dettaglio.getIdAllegato());

				// Passo il primo elemento del dettaglio, mi servono solo i dati generali che sono comuni a tutte le righe
				allegatoII = MapDto.mapToDatiAllegato1NowFattorComune(allegato1Common, sk4Gt, rappTipo1Dto, tDettTipo1List.get(0));
				//allegatoII = MapDto.mapToDatiAllegato1Now(sk4Gt, allegatoDto, rappTipo1Dto, tDettTipo1List.get(0), pg, pf, idRuolo, isTerzoResp, listaUnitaImmobiliare, impiantoDto, dettaglioTrattAcqua);

				if (GenericUtil.isNotNullOrEmpty(dettaglio.getIdIspezione()))
				{
					// Recupero l'ispezione
					dettaglioIspezione = getDettaglioIspezioneById(dettaglio.getIdIspezione());

					allegatoII.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
				}
				else
				{

					//manutentore = getImpresaManutentrice(ConvertUtil.convertToString(allegatoDto.getFkImpRuoloPfpg()));
					manutentore =  cercaTPersonaGiuridicaById(dettaglio.getIdPersonaGiuridica());

					//mapping dati dell'impresa manutentrice
					MapDto.mapToDatiImpresaManutentriceAllegato1(allegatoII, manutentore);
				}


//				List<SigitTDettTipo1Dto> tDettTipo1List = getDettTipo1(dettaglio.getCodiceImpianto(),
//						ConvertUtil.convertToInteger(sk4Gt.getProgressivo()), ConvertUtil.convertToString(allegatoDto.getIdAllegato()));

				 MapDto.mapToDatiAllegato1RowFumiNow(allegatoII, tDettTipo1List);

				 listaRow.add(allegatoII);

				//count++; //da cancelare
			}

			if(modAllegato.getMODII().getSystem()==null)
				modAllegato.getMODII().addNewSystem().addNewCatDig();
			if(modAllegato.getMODII().getSystem().getCatDig()==null)
				modAllegato.getMODII().getSystem().addNewCatDig();

			//definisce lo stato del modulo pdf ed e' comune a tutte le pagine
//		    if(isDefinitivo)
//			{
		    	richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
		    	modAllegato.getMODII().getSystem().getCatDig().setModuloEditabile(false);
//			}
//			else
//			{
//				richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_BOZZA);
//				modAllegato.getMODII().getSystem().getCatDig().setModuloEditabile(true);
//			}


		    	if (log.isDebugEnabled())
		    	{
		    		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		    		log.debug("STAMPO ALLEGATOII RESULT: "+modAllegato);
		    		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		    	}

		} catch (DbManagerException e) {
			throw e;
		}

		log.debug("[DbMgr::getModuloAllegatoTipo1NowFattorComune] END");

		//XXX

		return modAllegato;
	}

	public MODIIIDocument getModuloAllegatoTipo2NowFattorComune(DettaglioAllegato dettaglio)throws DbManagerException {
		log.debug("[DbMgr::getModuloAllegatoTipo2Now] BEGIN");

		it.csi.sigit.sigitwebn.xml.allegato3.data.MODIIIDocument modAllegato = it.csi.sigit.sigitwebn.xml.allegato3.data.MODIIIDocument.Factory.newInstance();

		/*
		SigitTAllegatoDto allegatoDto = null;
		SigitTImpiantoDto impiantoDto =null;


		// Se il responsabile e una PG
		SigitTPersonaGiuridicaDto pgResp = null;
		// Se il responsabile e una PF
		SigitTPersonaFisicaDto pf = null;
		//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		SigitTPersonaGiuridicaDto pg = null;

		// qui setto l'idImpRuoloPfpg del responsabile
		BigDecimal idImpRuoloPfpg = null;

		boolean isTerzoResp = false;
		*/


		SigitTPersonaGiuridicaDto manutentore = null;
		DettaglioIspezione dettaglioIspezione = null;

		//String idRuoloResp = null;
		//in questo oggetto setto l'id 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		//String idRuolo = null;

		try {
			/*
			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(new BigDecimal(dettaglio.getIdAllegato()));

			//trovo il dettaglio ALLEGATO
			allegatoDto = getSigitTAllegatoDao().findByPrimaryKey(pk);

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			//trovo il dettaglio IMPIANTO
			impiantoDto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			//trovo l'unita' immobiliare,dati locazione impianto
			List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()), ConvertUtil.convertToSqlDate(dettaglio.getDataControllo()));

			//sezione c. TRATTAMENTO DELL'ACQUA
//			SigitTTrattH2OPk pkTrattAcqua = new SigitTTrattH2OPk();
//			pkTrattAcqua.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));
			SigitTTrattH2ODto dettaglioTrattAcqua = cercaSigitTTrattH2OByCodImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			if (responsabile != null)
			{
				if(responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				}else{
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica );
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToString(responsabile.getIdRuolo());
			}
			*/

			/*
			log.debug("[DbMgr::getModuloAllegatoTipo1Now] COMINCIO IL MAPPING DEI DATI");
			//comincio il mapping dei dati
			it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta richiesta = modulo.getMODII().getRichiesta();
			//codice Bollino comune a tutte le pagine
			richiesta.getDatiIntestazione().setCodiceBollino(ConvertUtil.formattaSiglaBollino(allegatoDto.getFkNumeroBollino()));
			//vado a lavorare sulle pagine del modulo
			List<RowAllegatoII> allegatoIIList = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
			*/
			//istanzio gli oggetti per modol

			it.csi.sigit.sigitwebn.xml.allegato3.data.MODIIIDocument.MODIII mod = modAllegato.addNewMODIII();
			it.csi.sigit.sigitwebn.xml.allegato3.data.RichiestaDocument.Richiesta richiesta = mod.addNewRichiesta();
			List<RowAllegatoIII> listaRow = richiesta.addNewDatiAllegato().addNewAllegatoIII().getRowAllegatoIIIList();
			modAllegato.getMODIII().addNewSystem().addNewCatDig();
			//dati che sono comuni e non ripetuti per ogni pagina
			it.csi.sigit.sigitwebn.xml.allegato3.data.DatiModuloDocument.DatiModulo datiModulo = richiesta.addNewDatiModulo();
			it.csi.sigit.sigitwebn.xml.allegato3.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = richiesta.addNewDatiIntestazione();
			datiIntestazione.setCodiceBollino(ConvertUtil.formattaSiglaBollino(ConvertUtil.convertToBigDecimal(dettaglio.getNumeroBollinoVerde())));

			datiModulo.setStatoModulo(Constants.STATO_MODULO_BOZZA);

			log.debug("[ServiziMgr::getAllegato] ****** INSERIMENTO *****  da.getIdAllegato(): "+dettaglio.getIdAllegato());
			//setto l'idAllegato dentro il modulo
			datiModulo.setIdAllegato(dettaglio.getIdAllegato());

			//bisogna creare tante pagine quanti sono i risultati della seguente lista
			RowAllegatoIII allegatoIII = null;

			// Devo recupera tutti i progressivi per cui devo fare l'allegato
			//List<SigitVSk4GfDto> dtoList = getCompGfByIdAllegato(ConvertUtil.convertToInteger(dettaglio.getIdAllegato()));

			//for(RowAllegatoII allegatoII : allegatoIIList){
			/*
			for(SigitVSk4GfDto sk4Gt : dtoList){
				//log.debug("Quanti moduli di tipo allegatoII count: "+count);

				// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
				List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());
				if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
				{
					SigitVRicerca3ResponsabileDto responsabile2 = list3RespAttiviImpianto.get(0);
					isTerzoResp = true;

					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
					pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
					idRuolo = ""+responsabile.getIdRuolo();

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(sk4Gt.getProgressivo()), sk4Gt.getDataInstall(),
							null, responsabile2.getIdContratto());

				}
				else
				{
					//vTotImpianto = vTotImpiantoResp;
					pg = pgResp;
					idRuolo = idRuoloResp;

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(sk4Gt.getProgressivo()), sk4Gt.getDataInstall(),
							idImpRuoloPfpg, null);

				}
				*/
				DatiGFCommon allegato2Common = getDettaglioAllegato2Common(dettaglio);


				//log.debug("idRuolo: "+idRuolo);
				//MapDto.mapToDatiPrecompilatiAllegato1Now(allegatoII, listaUnitaImmobiliare, impiantoDto, allegatoDto);
				//MapDto.mapToDatiRespImpiantoAllegato1Now(allegatoII, pg, pf, idRuolo, isTerzoResp);
				SigitTRappTipo2Dto rappTipo2Dto = cercaTRappTipo2ById(ConvertUtil.convertToBigDecimal(dettaglio.getIdAllegato()));

				for(SigitVSk4GfDto sk4Gf : allegato2Common.getSk4GfDtoList()){

				List<SigitTDettTipo2Dto> tDettTipo2List	= getDettTipo2(ConvertUtil.convertToString(sk4Gf.getCodiceImpianto()), ConvertUtil.convertToInteger(sk4Gf.getProgressivo()), dettaglio.getIdAllegato());

				// Passo il primo elemento del dettaglio, mi servono solo i dati generali che sono comuni a tutte le righe
				allegatoIII = MapDto.mapToDatiAllegato2NowFattorComune(allegato2Common, sk4Gf, rappTipo2Dto, tDettTipo2List.get(0));

				if (GenericUtil.isNotNullOrEmpty(dettaglio.getIdIspezione()))
				{
					// Recupero l'ispezione
					dettaglioIspezione = getDettaglioIspezioneById(dettaglio.getIdIspezione());

					allegatoIII.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
				}
				else
				{

					//manutentore = getImpresaManutentrice(ConvertUtil.convertToString(allegatoDto.getFkImpRuoloPfpg()));
					manutentore =  cercaTPersonaGiuridicaById(dettaglio.getIdPersonaGiuridica());

					//mapping dati dell'impresa manutentrice
					MapDto.mapToDatiImpresaManutentriceAllegato2(allegatoIII, manutentore);
				}


//				List<SigitTDettTipo1Dto> tDettTipo1List = getDettTipo1(dettaglio.getCodiceImpianto(),
//						ConvertUtil.convertToInteger(sk4Gt.getProgressivo()), ConvertUtil.convertToString(allegatoDto.getIdAllegato()));

				 MapDto.mapToDatiAllegato2RowFumiNow(allegatoIII, tDettTipo2List);

				 listaRow.add(allegatoIII);

				//count++; //da cancelare
			}

			if(modAllegato.getMODIII().getSystem()==null)
				modAllegato.getMODIII().addNewSystem().addNewCatDig();
			if(modAllegato.getMODIII().getSystem().getCatDig()==null)
				modAllegato.getMODIII().getSystem().addNewCatDig();

			//definisce lo stato del modulo pdf ed e' comune a tutte le pagine
//		    if(isDefinitivo)
//			{
		    	richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
		    	modAllegato.getMODIII().getSystem().getCatDig().setModuloEditabile(false);
//			}
//			else
//			{
//				richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_BOZZA);
//				modAllegato.getMODII().getSystem().getCatDig().setModuloEditabile(true);
//			}


		    	if (log.isDebugEnabled())
		    	{
		    		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		    		log.debug("STAMPO ALLEGATOII RESULT: "+modAllegato);
		    		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		    	}

		} catch (DbManagerException e) {
			throw e;
		}

		log.debug("[DbMgr::getModuloAllegatoTipo2Now] END");

		//XXX

		return modAllegato;
	}

	public DatiGTCommon getDettaglioAllegato1Common(DettaglioAllegato dettaglio) throws DbManagerException
	{
		DatiGTCommon allegato1Common = new DatiGTCommon();

		try {

			SigitTAllegatoDto allegatoDto = null;
			SigitTImpiantoDto impiantoDto = null;
			List<SigitTUnitaImmobiliareDto> unitaImmobiliareList = null;

			// Se il responsabile e una PG
			SigitTPersonaGiuridicaDto pgResp = null;
			// Se il responsabile e una PF
			SigitTPersonaFisicaDto pf = null;
			//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
			SigitTPersonaGiuridicaDto pg = null;

			// qui setto l'idImpRuoloPfpg del responsabile
			BigDecimal idImpRuoloPfpg = null;

			boolean isTerzoResp = false;

			//SigitTPersonaGiuridicaDto manutentore = null;
			//DettaglioIspezione dettaglioIspezione = null;

			Integer idRuoloResp = null;
			//in questo oggetto setto l'id 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
			Integer idRuolo = null;

			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(new BigDecimal(dettaglio.getIdAllegato()));

			//trovo il dettaglio ALLEGATO
			allegatoDto = getSigitTAllegatoDao().findByPrimaryKey(pk);

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			//trovo il dettaglio IMPIANTO
			impiantoDto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			//trovo l'unita' immobiliare,dati locazione impianto
			unitaImmobiliareList = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			//trovo l'unita' immobiliare,dati locazione impianto
			//List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()), ConvertUtil.convertToSqlDate(dettaglio.getDataControllo()));

			//sezione c. TRATTAMENTO DELL'ACQUA
//			SigitTTrattH2OPk pkTrattAcqua = new SigitTTrattH2OPk();
//			pkTrattAcqua.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));
			SigitTTrattH2ODto dettaglioTrattAcqua = cercaSigitTTrattH2OByCodImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			if (responsabile != null)
			{
				if(responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				}else{
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica );
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToInteger(responsabile.getIdRuolo());
			}

			// Devo recupera tutti i progressivi per cui devo fare l'allegato
			List<SigitVSk4GtDto> dtoList = getCompGtByIdAllegato(ConvertUtil.convertToInteger(dettaglio.getIdAllegato()));

			// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());

			SigitVRicerca3ResponsabileDto responsabile2 = null;
			if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
			{
				responsabile2 = list3RespAttiviImpianto.get(0);
				isTerzoResp = true;

				SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
				pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
				pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				idRuolo = ConvertUtil.convertToInteger(responsabile.getIdRuolo());

			}
			else
			{
				//vTotImpianto = vTotImpiantoResp;
				pg = pgResp;
				idRuolo = idRuoloResp;

			}

			for(SigitVSk4GtDto sk4Gt : dtoList){

				if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
				{
					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToBigDecimal(sk4Gt.getProgressivo()), sk4Gt.getDataInstall(),
							null, responsabile2.getIdContratto());

				}
				else
				{
					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToBigDecimal(sk4Gt.getProgressivo()), sk4Gt.getDataInstall(),
							idImpRuoloPfpg, null);
				}

			}

			allegato1Common.setImpiantoDto(impiantoDto);
			allegato1Common.setUnitaImmobiliareList(unitaImmobiliareList);
			allegato1Common.setAllegatoDto(allegatoDto);
			allegato1Common.setSk4GtDtoList(dtoList);
			allegato1Common.setPersonaGiuridicaDto(pg);
			allegato1Common.setPersonaFisicaDto(pf);
			allegato1Common.setDettaglioTrattAcquaDto(dettaglioTrattAcqua);
			allegato1Common.setRuolo(idRuolo);
			allegato1Common.setTerzoResp(isTerzoResp);


		} catch (SigitTAllegatoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}

		return allegato1Common;
	}


	public DatiGFCommon getDettaglioAllegato2Common(DettaglioAllegato dettaglio) throws DbManagerException
	{
		DatiGFCommon allegato1Common = new DatiGFCommon();

		try {

			SigitTAllegatoDto allegatoDto = null;
			SigitTImpiantoDto impiantoDto = null;
			List<SigitTUnitaImmobiliareDto> unitaImmobiliareList = null;

			// Se il responsabile e una PG
			SigitTPersonaGiuridicaDto pgResp = null;
			// Se il responsabile e una PF
			SigitTPersonaFisicaDto pf = null;
			//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
			SigitTPersonaGiuridicaDto pg = null;

			// qui setto l'idImpRuoloPfpg del responsabile
			BigDecimal idImpRuoloPfpg = null;

			boolean isTerzoResp = false;

			//SigitTPersonaGiuridicaDto manutentore = null;
			//DettaglioIspezione dettaglioIspezione = null;

			Integer idRuoloResp = null;
			//in questo oggetto setto l'id 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
			Integer idRuolo = null;

			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(new BigDecimal(dettaglio.getIdAllegato()));

			//trovo il dettaglio ALLEGATO
			allegatoDto = getSigitTAllegatoDao().findByPrimaryKey(pk);

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			//trovo il dettaglio IMPIANTO
			impiantoDto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			//trovo l'unita' immobiliare,dati locazione impianto
			unitaImmobiliareList = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			//trovo l'unita' immobiliare,dati locazione impianto
			//List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()), ConvertUtil.convertToSqlDate(dettaglio.getDataControllo()));

			//sezione c. TRATTAMENTO DELL'ACQUA
//			SigitTTrattH2OPk pkTrattAcqua = new SigitTTrattH2OPk();
//			pkTrattAcqua.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));
			SigitTTrattH2ODto dettaglioTrattAcqua = cercaSigitTTrattH2OByCodImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			if (responsabile != null)
			{
				if(responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				}else{
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica );
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToInteger(responsabile.getIdRuolo());
			}

			// Devo recupera tutti i progressivi per cui devo fare l'allegato
			List<SigitVSk4GfDto> dtoList = getCompGfByIdAllegato(ConvertUtil.convertToInteger(dettaglio.getIdAllegato()));

			// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());

			SigitVRicerca3ResponsabileDto responsabile2 = null;
			if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
			{
				responsabile2 = list3RespAttiviImpianto.get(0);
				isTerzoResp = true;

				SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
				pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
				pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				idRuolo = ConvertUtil.convertToInteger(responsabile.getIdRuolo());

			}
			else
			{
				//vTotImpianto = vTotImpiantoResp;
				pg = pgResp;
				idRuolo = idRuoloResp;

			}

			for(SigitVSk4GfDto sk4Gf : dtoList){

				if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
				{
					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(sk4Gf.getProgressivo()), sk4Gf.getDataInstall(),
							null, responsabile2.getIdContratto());

				}
				else
				{
					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(sk4Gf.getProgressivo()), sk4Gf.getDataInstall(),
							idImpRuoloPfpg, null);
				}

			}

			allegato1Common.setImpiantoDto(impiantoDto);
			allegato1Common.setUnitaImmobiliareList(unitaImmobiliareList);
			allegato1Common.setAllegatoDto(allegatoDto);
			allegato1Common.setSk4GfDtoList(dtoList);
			allegato1Common.setPersonaGiuridicaDto(pg);
			allegato1Common.setPersonaFisicaDto(pf);
			allegato1Common.setDettaglioTrattAcquaDto(dettaglioTrattAcqua);
			allegato1Common.setRuolo(idRuolo);
			allegato1Common.setTerzoResp(isTerzoResp);


		} catch (SigitTAllegatoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}

		return allegato1Common;
	}

	public DatiSCCommon getDettaglioAllegato3Common(DettaglioAllegato dettaglio) throws DbManagerException
	{
		DatiSCCommon allegato3Common = new DatiSCCommon();

		try {

			SigitTAllegatoDto allegatoDto = null;
			SigitTImpiantoDto impiantoDto = null;
			List<SigitTUnitaImmobiliareDto> unitaImmobiliareList = null;

			// Se il responsabile e una PG
			SigitTPersonaGiuridicaDto pgResp = null;
			// Se il responsabile e una PF
			SigitTPersonaFisicaDto pf = null;
			//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
			SigitTPersonaGiuridicaDto pg = null;

			// qui setto l'idImpRuoloPfpg del responsabile
			BigDecimal idImpRuoloPfpg = null;

			boolean isTerzoResp = false;

			//SigitTPersonaGiuridicaDto manutentore = null;
			//DettaglioIspezione dettaglioIspezione = null;

			Integer idRuoloResp = null;
			//in questo oggetto setto l'id 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
			Integer idRuolo = null;

			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(new BigDecimal(dettaglio.getIdAllegato()));

			//trovo il dettaglio ALLEGATO
			allegatoDto = getSigitTAllegatoDao().findByPrimaryKey(pk);

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			//trovo il dettaglio IMPIANTO
			impiantoDto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			//trovo l'unita' immobiliare,dati locazione impianto
			unitaImmobiliareList = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			//trovo l'unita' immobiliare,dati locazione impianto
			//List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()), ConvertUtil.convertToSqlDate(dettaglio.getDataControllo()));

			//sezione c. TRATTAMENTO DELL'ACQUA
//			SigitTTrattH2OPk pkTrattAcqua = new SigitTTrattH2OPk();
//			pkTrattAcqua.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));
			SigitTTrattH2ODto dettaglioTrattAcqua = cercaSigitTTrattH2OByCodImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			if (responsabile != null)
			{
				if(responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				}else{
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica );
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToInteger(responsabile.getIdRuolo());
			}

			// Devo recupera tutti i progressivi per cui devo fare l'allegato
			List<SigitVSk4ScDto> dtoList = getCompScByIdAllegato(ConvertUtil.convertToInteger(dettaglio.getIdAllegato()));

			// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());

			SigitVRicerca3ResponsabileDto responsabile2 = null;
			if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
			{
				responsabile2 = list3RespAttiviImpianto.get(0);
				isTerzoResp = true;

				SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
				pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
				pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				idRuolo = ConvertUtil.convertToInteger(responsabile.getIdRuolo());

			}
			else
			{
				//vTotImpianto = vTotImpiantoResp;
				pg = pgResp;
				idRuolo = idRuoloResp;

			}

			for(SigitVSk4ScDto sk4Sc : dtoList){

				if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
				{
					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(sk4Sc.getProgressivo()), sk4Sc.getDataInstall(),
							null, responsabile2.getIdContratto());

				}
				else
				{
					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(sk4Sc.getProgressivo()), sk4Sc.getDataInstall(),
							idImpRuoloPfpg, null);
				}

			}

			allegato3Common.setImpiantoDto(impiantoDto);
			allegato3Common.setUnitaImmobiliareList(unitaImmobiliareList);
			allegato3Common.setAllegatoDto(allegatoDto);
			allegato3Common.setSk4ScDtoList(dtoList);
			allegato3Common.setPersonaGiuridicaDto(pg);
			allegato3Common.setPersonaFisicaDto(pf);
			allegato3Common.setDettaglioTrattAcquaDto(dettaglioTrattAcqua);
			allegato3Common.setRuolo(idRuolo);
			allegato3Common.setTerzoResp(isTerzoResp);


		} catch (SigitTAllegatoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}

		return allegato3Common;
	}

	public DatiCGCommon getDettaglioAllegato4Common(DettaglioAllegato dettaglio) throws DbManagerException {
		DatiCGCommon allegato4Common = new DatiCGCommon();
		try {
			SigitTAllegatoDto allegatoDto = null;
			SigitTImpiantoDto impiantoDto = null;

			// Se il responsabile e una PG
			SigitTPersonaGiuridicaDto pgResp = null;
			// Se il responsabile e una PF
			SigitTPersonaFisicaDto pf = null;
			//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
			SigitTPersonaGiuridicaDto pg = null;

			// qui setto l'idImpRuoloPfpg del responsabile
			BigDecimal idImpRuoloPfpg = null;

			boolean isTerzoResp = false;

			Integer idRuoloResp = null;
			//in questo oggetto setto l'id 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
			Integer idRuolo = null;

			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(new BigDecimal(dettaglio.getIdAllegato()));

			//trovo il dettaglio ALLEGATO
			allegatoDto = getSigitTAllegatoDao().findByPrimaryKey(pk);

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			//trovo il dettaglio IMPIANTO
			impiantoDto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			//trovo l'unita' immobiliare,dati locazione impianto
			List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()), ConvertUtil.convertToSqlDate(dettaglio.getDataControllo()));

			//sezione c. TRATTAMENTO DELL'ACQUA
			SigitTTrattH2ODto dettaglioTrattAcqua = cercaSigitTTrattH2OByCodImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			if (responsabile != null)
			{
				if(responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				}else{
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica );
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToInteger(responsabile.getIdRuolo());
			}
			List<SigitVSk4CgDto> dtoList = getCompCgByIdAllegato(ConvertUtil.convertToInteger(dettaglio.getIdAllegato()));

			for(SigitVSk4CgDto sk4Cg : dtoList){

				List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());
				if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
				{
					SigitVRicerca3ResponsabileDto responsabile2 = list3RespAttiviImpianto.get(0);
					isTerzoResp = true;

					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
					pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
					idRuolo = ConvertUtil.convertToInteger(responsabile.getIdRuolo());

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_CG, ConvertUtil.convertToBigDecimal(sk4Cg.getProgressivo()), sk4Cg.getDataInstall(),
							null, responsabile2.getIdContratto());
				}
				else
				{
					pg = pgResp;
					idRuolo = idRuoloResp;

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_CG, ConvertUtil.convertToBigDecimal(sk4Cg.getProgressivo()), sk4Cg.getDataInstall(),
							idImpRuoloPfpg, null);
				}

				log.debug("idRuolo: "+idRuolo);

			}

			allegato4Common.setAllegatoDto(allegatoDto);
			allegato4Common.setDettaglioTrattAcqua(dettaglioTrattAcqua);
			allegato4Common.setIdImpRuoloPfpg(idImpRuoloPfpg);
			allegato4Common.setIdRuolo(idRuolo);
			allegato4Common.setImpiantoDto(impiantoDto);
			allegato4Common.setListaUnitaImmobiliare(listaUnitaImmobiliare);
			allegato4Common.setPersonaFisicaDto(pf);
			allegato4Common.setPersonaGiuridicaDto(pg);
			allegato4Common.setTerzoResp(isTerzoResp);
			allegato4Common.setSk4CgDtoList(dtoList);

		} catch (SigitTAllegatoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		return allegato4Common;
	}





	public MODIIDocument getModuloAllegatoTipo1(MODIIDocument modulo, DettaglioAllegato dettaglio, boolean isDefinitivo)throws DbManagerException {
		log.debug("[DbMgr::getModuloAllegatoTipo1] BEGIN");
		SigitTAllegatoDto allegatoDto = null;
		SigitTImpiantoDto impiantoDto =null;


		// Se il responsabile e una PG
		SigitTPersonaGiuridicaDto pgResp = null;
		// Se il responsabile e una PF
		SigitTPersonaFisicaDto pf = null;
		//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		SigitTPersonaGiuridicaDto pg = null;

		// qui setto l'idImpRuoloPfpg del responsabile
		BigDecimal idImpRuoloPfpg = null;

		boolean isTerzoResp = false;

		SigitTPersonaGiuridicaDto manutentore = null;
		DettaglioIspezione dettaglioIspezione = null;

		String idRuoloResp = null;
		//in questo oggetto setto l'id 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		String idRuolo = null;

		try {
			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(new BigDecimal(dettaglio.getIdAllegato()));

			//trovo il dettaglio ALLEGATO
			allegatoDto = getSigitTAllegatoDao().findByPrimaryKey(pk);

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			//trovo il dettaglio IMPIANTO
			impiantoDto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			//trovo l'unita' immobiliare,dati locazione impianto
			List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()), ConvertUtil.convertToSqlDate(dettaglio.getDataControllo()));

			if (responsabile != null)
			{
				if(responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				}else{
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica );
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToString(responsabile.getIdRuolo());
			}


			log.debug("[DbMgr::getModuloAllegatoTipo1] COMINCIO IL MAPPING DEI DATI");
			//comincio il mapping dei dati
			it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta richiesta = modulo.getMODII().getRichiesta();
			//codice Bollino comune a tutte le pagine
			richiesta.getDatiIntestazione().setCodiceBollino(ConvertUtil.formattaSiglaBollino(allegatoDto.getFkNumeroBollino()));
			//vado a lavorare sulle pagine del modulo
			List<RowAllegatoII> allegatoIIList = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
			//int count = 1; //da cancellare
			for(RowAllegatoII allegatoII : allegatoIIList){
				//log.debug("Quanti moduli di tipo allegatoII count: "+count);

				// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
				List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());
				if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
				{
					SigitVRicerca3ResponsabileDto responsabile2 = list3RespAttiviImpianto.get(0);
					isTerzoResp = true;

					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
					pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
					idRuolo = ""+responsabile.getIdRuolo();

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToBigDecimal(allegatoII.getAENumGT()), DateUtil.getSqlDate(allegatoII.getAEDataInstallaz()),
							null, responsabile2.getIdContratto());

				}
				else
				{
					//vTotImpianto = vTotImpiantoResp;
					pg = pgResp;
					idRuolo = idRuoloResp;

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToBigDecimal(allegatoII.getAENumGT()), DateUtil.getSqlDate(allegatoII.getAEDataInstallaz()),
							idImpRuoloPfpg, null);

				}


				log.debug("idRuolo: "+idRuolo);
				MapDto.mapToDatiPrecompilatiAllegato1(allegatoII, listaUnitaImmobiliare, impiantoDto, allegatoDto);
				MapDto.mapToDatiRespImpiantoAllegato1(allegatoII,pg,pf, idRuolo, isTerzoResp);


				if (GenericUtil.isNotNullOrEmpty(dettaglio.getIdIspezione()))
				{
					// Recupero l'ispezione
					dettaglioIspezione = getDettaglioIspezioneById(dettaglio.getIdIspezione());

					allegatoII.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
				}
				else
				{

					//manutentore = getImpresaManutentrice(ConvertUtil.convertToString(allegatoDto.getFkImpRuoloPfpg()));
					manutentore =  cercaTPersonaGiuridicaById(dettaglio.getIdPersonaGiuridica());

					//mapping dati dell'impresa manutentrice
					MapDto.mapToDatiImpresaManutentriceAllegato1(allegatoII, manutentore);
				}

				//count++; //da cancelare
			}

			if(modulo.getMODII().getSystem()==null)
				modulo.getMODII().addNewSystem().addNewCatDig();
			if(modulo.getMODII().getSystem().getCatDig()==null)
				modulo.getMODII().getSystem().addNewCatDig();

			//definisce lo stato del modulo pdf ed e' comune a tutte le pagine
		    if(isDefinitivo)
			{
		    	richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
		    	modulo.getMODII().getSystem().getCatDig().setModuloEditabile(false);
			}
			else
			{
				richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_BOZZA);
				modulo.getMODII().getSystem().getCatDig().setModuloEditabile(true);
			}


			log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			log.debug("STAMPO ALLEGATOII RESULT: "+modulo);
			log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


		} catch (SigitTAllegatoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}

		log.debug("[DbMgr::getModuloAllegatoTipo1] END");
		return modulo;
	}

	public MODIIIDocument getModuloAllegatoTipo2Now(DettaglioAllegato dettaglio)throws DbManagerException {
		log.debug("[DbMgr::getModuloAllegatoTipo2Now] BEGIN");

		it.csi.sigit.sigitwebn.xml.allegato3.data.MODIIIDocument modAllegato = it.csi.sigit.sigitwebn.xml.allegato3.data.MODIIIDocument.Factory.newInstance();

		SigitTAllegatoDto allegatoDto = null;
		SigitTImpiantoDto impiantoDto =null;


		// Se il responsabile e una PG
		SigitTPersonaGiuridicaDto pgResp = null;
		// Se il responsabile e una PF
		SigitTPersonaFisicaDto pf = null;
		//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		SigitTPersonaGiuridicaDto pg = null;

		// qui setto l'idImpRuoloPfpg del responsabile
		BigDecimal idImpRuoloPfpg = null;

		boolean isTerzoResp = false;

		SigitTPersonaGiuridicaDto manutentore = null;
		DettaglioIspezione dettaglioIspezione = null;

		String idRuoloResp = null;
		//in questo oggetto setto l'id 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		String idRuolo = null;

		try {
			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(new BigDecimal(dettaglio.getIdAllegato()));

			//trovo il dettaglio ALLEGATO
			allegatoDto = getSigitTAllegatoDao().findByPrimaryKey(pk);

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			//trovo il dettaglio IMPIANTO
			impiantoDto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			//trovo l'unita' immobiliare,dati locazione impianto
			List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()), ConvertUtil.convertToSqlDate(dettaglio.getDataControllo()));

			//sezione c. TRATTAMENTO DELL'ACQUA
//			SigitTTrattH2OPk pkTrattAcqua = new SigitTTrattH2OPk();
//			pkTrattAcqua.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));
			SigitTTrattH2ODto dettaglioTrattAcqua = cercaSigitTTrattH2OByCodImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			if (responsabile != null)
			{
				if(responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				}else{
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica );
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToString(responsabile.getIdRuolo());
			}


			/*
			log.debug("[DbMgr::getModuloAllegatoTipo1Now] COMINCIO IL MAPPING DEI DATI");
			//comincio il mapping dei dati
			it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta richiesta = modulo.getMODII().getRichiesta();
			//codice Bollino comune a tutte le pagine
			richiesta.getDatiIntestazione().setCodiceBollino(ConvertUtil.formattaSiglaBollino(allegatoDto.getFkNumeroBollino()));
			//vado a lavorare sulle pagine del modulo
			List<RowAllegatoII> allegatoIIList = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
			*/
			//istanzio gli oggetti per modol

			it.csi.sigit.sigitwebn.xml.allegato3.data.MODIIIDocument.MODIII mod = modAllegato.addNewMODIII();
			it.csi.sigit.sigitwebn.xml.allegato3.data.RichiestaDocument.Richiesta richiesta = mod.addNewRichiesta();
			List<RowAllegatoIII> listaRow = richiesta.addNewDatiAllegato().addNewAllegatoIII().getRowAllegatoIIIList();
			modAllegato.getMODIII().addNewSystem().addNewCatDig();
			//dati che sono comuni e non ripetuti per ogni pagina
			it.csi.sigit.sigitwebn.xml.allegato3.data.DatiModuloDocument.DatiModulo datiModulo = richiesta.addNewDatiModulo();
			it.csi.sigit.sigitwebn.xml.allegato3.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = richiesta.addNewDatiIntestazione();
			datiIntestazione.setCodiceBollino(ConvertUtil.formattaSiglaBollino(ConvertUtil.convertToBigDecimal(dettaglio.getNumeroBollinoVerde())));

			datiModulo.setStatoModulo(Constants.STATO_MODULO_BOZZA);

			log.debug("[ServiziMgr::getAllegato] ****** INSERIMENTO *****  da.getIdAllegato(): "+dettaglio.getIdAllegato());
			//setto l'idAllegato dentro il modulo
			datiModulo.setIdAllegato(dettaglio.getIdAllegato());

			//bisogna creare tante pagine quanti sono i risultati della seguente lista
			RowAllegatoIII allegatoIII = null;

			// Devo recupera tutti i progressivi per cui devo fare l'allegato
			List<SigitVSk4GfDto> dtoList = getCompGfByIdAllegato(ConvertUtil.convertToInteger(dettaglio.getIdAllegato()));

			//for(RowAllegatoII allegatoII : allegatoIIList){
			for(SigitVSk4GfDto sk4Gt : dtoList){
				//log.debug("Quanti moduli di tipo allegatoII count: "+count);

				// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
				List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());
				if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
				{
					SigitVRicerca3ResponsabileDto responsabile2 = list3RespAttiviImpianto.get(0);
					isTerzoResp = true;

					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
					pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
					idRuolo = ""+responsabile.getIdRuolo();

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(sk4Gt.getProgressivo()), sk4Gt.getDataInstall(),
							null, responsabile2.getIdContratto());

				}
				else
				{
					//vTotImpianto = vTotImpiantoResp;
					pg = pgResp;
					idRuolo = idRuoloResp;

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(sk4Gt.getProgressivo()), sk4Gt.getDataInstall(),
							idImpRuoloPfpg, null);

				}


				log.debug("idRuolo: "+idRuolo);
				//MapDto.mapToDatiPrecompilatiAllegato1Now(allegatoII, listaUnitaImmobiliare, impiantoDto, allegatoDto);
				//MapDto.mapToDatiRespImpiantoAllegato1Now(allegatoII, pg, pf, idRuolo, isTerzoResp);
				SigitTRappTipo2Dto rappTipo2Dto = cercaTRappTipo2ById(allegatoDto.getIdAllegato());

				List<SigitTDettTipo2Dto> tDettTipo2List	= getDettTipo2(ConvertUtil.convertToString(sk4Gt.getCodiceImpianto()), ConvertUtil.convertToInteger(sk4Gt.getProgressivo()), dettaglio.getIdAllegato());

				// Passo il primo elemento del dettaglio, mi servono solo i dati generali che sono comuni a tutte le righe
				allegatoIII = MapDto.mapToDatiAllegato2Now(sk4Gt, allegatoDto, rappTipo2Dto, tDettTipo2List.get(0), pg, pf, idRuolo, isTerzoResp, listaUnitaImmobiliare, impiantoDto, dettaglioTrattAcqua);

				if (GenericUtil.isNotNullOrEmpty(dettaglio.getIdIspezione()))
				{
					// Recupero l'ispezione
					dettaglioIspezione = getDettaglioIspezioneById(dettaglio.getIdIspezione());

					allegatoIII.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
				}
				else
				{

					//manutentore = getImpresaManutentrice(ConvertUtil.convertToString(allegatoDto.getFkImpRuoloPfpg()));
					manutentore =  cercaTPersonaGiuridicaById(dettaglio.getIdPersonaGiuridica());

					//mapping dati dell'impresa manutentrice
					MapDto.mapToDatiImpresaManutentriceAllegato2(allegatoIII, manutentore);
				}


//				List<SigitTDettTipo1Dto> tDettTipo1List = getDettTipo1(dettaglio.getCodiceImpianto(),
//						ConvertUtil.convertToInteger(sk4Gt.getProgressivo()), ConvertUtil.convertToString(allegatoDto.getIdAllegato()));

				 MapDto.mapToDatiAllegato2RowFumiNow(allegatoIII, tDettTipo2List);

				 listaRow.add(allegatoIII);

				//count++; //da cancelare
			}

			if(modAllegato.getMODIII().getSystem()==null)
				modAllegato.getMODIII().addNewSystem().addNewCatDig();
			if(modAllegato.getMODIII().getSystem().getCatDig()==null)
				modAllegato.getMODIII().getSystem().addNewCatDig();

			//definisce lo stato del modulo pdf ed e' comune a tutte le pagine
//		    if(isDefinitivo)
//			{
		    	richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
		    	modAllegato.getMODIII().getSystem().getCatDig().setModuloEditabile(false);
//			}
//			else
//			{
//				richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_BOZZA);
//				modAllegato.getMODII().getSystem().getCatDig().setModuloEditabile(true);
//			}


		    	if (log.isDebugEnabled())
		    	{
		    		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		    		log.debug("STAMPO ALLEGATOII RESULT: "+modAllegato);
		    		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		    	}

		} catch (SigitTAllegatoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}

		log.debug("[DbMgr::getModuloAllegatoTipo2Now] END");

		//XXX

		return modAllegato;
	}

	public MODIIIDocument getModuloAllegatoTipo2(MODIIIDocument modulo, DettaglioAllegato dettaglio, boolean isDefinitivo)throws DbManagerException {
		log.debug("[DbMgr::getModuloAllegatoTipo2] BEGIN");
		SigitTAllegatoDto allegatoDto = null;
		SigitTImpiantoDto impiantoDto = null;

		// Se il responsabile e una PG
		SigitTPersonaGiuridicaDto pgResp = null;
		// Se il responsabile e una PF
		SigitTPersonaFisicaDto pf = null;
		//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		SigitTPersonaGiuridicaDto pg = null;

		// qui setto l'idImpRuoloPfpg del responsabile
		BigDecimal idImpRuoloPfpg = null;

		boolean isTerzoResp = false;

//		SigitTPersonaGiuridicaDto personaGiuridicaDto = null;
//		SigitTPersonaFisicaDto personaFisicaDto = null;

		SigitTPersonaGiuridicaDto manutentore = null;
		DettaglioIspezione dettaglioIspezione = null;

		String idRuoloResp = null;
		//in questo oggetto setto l'id 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		String idRuolo = null;

		try {

			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(new BigDecimal(dettaglio.getIdAllegato()));

			//trovo il dettaglio ALLEGATO
			allegatoDto = getSigitTAllegatoDao().findByPrimaryKey(pk);

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			//trovo il dettaglio IMPIANTO
			impiantoDto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			//trovo l'unita' immobiliare,dati locazione impianto
			List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()), ConvertUtil.convertToSqlDate(dettaglio.getDataControllo()));

			if (responsabile != null)
			{
				if(responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				}else{
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica );
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToString(responsabile.getIdRuolo());

			}

			log.debug("[DbMgr::getModuloAllegatoTipo2] COMINCIO IL MAPPING DEI DATI");

			//comincio il mapping dei dati
			it.csi.sigit.sigitwebn.xml.allegato3.data.RichiestaDocument.Richiesta richiesta = modulo.getMODIII().getRichiesta();
			//codice Bollino comune a tutte le pagine
			richiesta.getDatiIntestazione().setCodiceBollino(ConvertUtil.formattaSiglaBollino(allegatoDto.getFkNumeroBollino()));
			//vado a lavorare sulle pagine del modulo
			List<it.csi.sigit.sigitwebn.xml.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII> allegatoIIIList = richiesta.getDatiAllegato().getAllegatoIII().getRowAllegatoIIIList();
			//definisce lo stato del modulo pdf ed e' comune a tutte le pagine

			//int count = 1; //da cancellare
			for(RowAllegatoIII allegatoIII : allegatoIIIList){
				//log.debug("Quanti moduli di tipo allegatoIII count: "+count);

				// Devo dettare il responsabile/3 responsabile per ogni singola apparecchiatura
				List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());
				if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
				{
					SigitVRicerca3ResponsabileDto responsabile2 = list3RespAttiviImpianto.get(0);
					isTerzoResp = true;

					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
					pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
					idRuolo = ""+responsabile.getIdRuolo();

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(allegatoIII.getAENumGF()), DateUtil.getSqlDate(allegatoIII.getAEDataInstallaz()),
							null, responsabile2.getIdContratto());
				}
				else
				{
					//vTotImpianto = vTotImpiantoResp;
					pg = pgResp;
					idRuolo = idRuoloResp;

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(allegatoIII.getAENumGF()), DateUtil.getSqlDate(allegatoIII.getAEDataInstallaz()),
							idImpRuoloPfpg, null);
				}


				log.debug("idRuolo: "+idRuolo);
				MapDto.mapToDatiPrecompilatiAllegato2(allegatoIII, listaUnitaImmobiliare, impiantoDto, allegatoDto);
				MapDto.mapToDatiRespImpiantoAllegato2(allegatoIII, pg, pf, idRuolo, isTerzoResp);

				if (GenericUtil.isNotNullOrEmpty(dettaglio.getIdIspezione()))
				{
					// Recupero l'ispezione
					dettaglioIspezione = getDettaglioIspezioneById(dettaglio.getIdIspezione());

					allegatoIII.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
				}
				else
				{

					//per cercare l'impresa manutentrice

					//manutentore = getImpresaManutentrice(ConvertUtil.convertToString(allegatoDto.getFkImpRuoloPfpg()));
					manutentore =  cercaTPersonaGiuridicaById(dettaglio.getIdPersonaGiuridica());

					//mapping dati dell'impresa manutentrice
					MapDto.mapToDatiImpresaManutentriceAllegato2(allegatoIII, manutentore);
				}

				//count++; //da cancelare
			}


			if(modulo.getMODIII().getSystem()==null)
				modulo.getMODIII().addNewSystem().addNewCatDig();
			if(modulo.getMODIII().getSystem().getCatDig()==null)
				modulo.getMODIII().getSystem().addNewCatDig();

			if(isDefinitivo)
			{
		    	richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
		    	modulo.getMODIII().getSystem().getCatDig().setModuloEditabile(false);
			}
			else
			{
				richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_BOZZA);
				modulo.getMODIII().getSystem().getCatDig().setModuloEditabile(true);
			}


			if (log.isDebugEnabled())
			{
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				log.debug("STAMPO ALLEGATOIII RESULT: "+modulo);
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}
		}catch (SigitTAllegatoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}


		log.debug("[DbMgr::getModuloAllegatoTipo2] END");
		return modulo;
	}


	public MODIVDocument getModuloAllegatoTipo3Now(DettaglioAllegato dettaglio)throws DbManagerException {
		log.debug("[DbMgr::getModuloAllegatoTipo3Now] BEGIN");

		it.csi.sigit.sigitwebn.xml.allegato4.data.MODIVDocument modAllegato = it.csi.sigit.sigitwebn.xml.allegato4.data.MODIVDocument.Factory.newInstance();

		SigitTAllegatoDto allegatoDto = null;
		SigitTImpiantoDto impiantoDto =null;


		// Se il responsabile e una PG
		SigitTPersonaGiuridicaDto pgResp = null;
		// Se il responsabile e una PF
		SigitTPersonaFisicaDto pf = null;
		//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		SigitTPersonaGiuridicaDto pg = null;

		// qui setto l'idImpRuoloPfpg del responsabile
		BigDecimal idImpRuoloPfpg = null;

		boolean isTerzoResp = false;

		SigitTPersonaGiuridicaDto manutentore = null;
		DettaglioIspezione dettaglioIspezione = null;

		String idRuoloResp = null;
		//in questo oggetto setto l'id 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		String idRuolo = null;

		try {
			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(new BigDecimal(dettaglio.getIdAllegato()));

			//trovo il dettaglio ALLEGATO
			allegatoDto = getSigitTAllegatoDao().findByPrimaryKey(pk);

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			//trovo il dettaglio IMPIANTO
			impiantoDto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			//trovo l'unita' immobiliare,dati locazione impianto
			List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()), ConvertUtil.convertToSqlDate(dettaglio.getDataControllo()));

			//sezione c. TRATTAMENTO DELL'ACQUA
//			SigitTTrattH2OPk pkTrattAcqua = new SigitTTrattH2OPk();
//			pkTrattAcqua.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));
			SigitTTrattH2ODto dettaglioTrattAcqua = cercaSigitTTrattH2OByCodImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			if (responsabile != null)
			{
				if(responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				}else{
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica );
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToString(responsabile.getIdRuolo());
			}

			//istanzio gli oggetti per modol

			it.csi.sigit.sigitwebn.xml.allegato4.data.MODIVDocument.MODIV mod = modAllegato.addNewMODIV();
			it.csi.sigit.sigitwebn.xml.allegato4.data.RichiestaDocument.Richiesta richiesta = mod.addNewRichiesta();
			List<RowAllegatoIV> listaRow = richiesta.addNewDatiAllegato().addNewAllegatoIV().getRowAllegatoIVList();
			modAllegato.getMODIV().addNewSystem().addNewCatDig();
			//dati che sono comuni e non ripetuti per ogni pagina
			it.csi.sigit.sigitwebn.xml.allegato4.data.DatiModuloDocument.DatiModulo datiModulo = richiesta.addNewDatiModulo();
			it.csi.sigit.sigitwebn.xml.allegato4.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = richiesta.addNewDatiIntestazione();

			datiIntestazione.setCodiceBollino(ConvertUtil.formattaSiglaBollino(ConvertUtil.convertToBigDecimal(dettaglio.getNumeroBollinoVerde())));

			datiModulo.setStatoModulo(Constants.STATO_MODULO_BOZZA);

			log.debug("[ServiziMgr::getAllegato] ****** INSERIMENTO *****  da.getIdAllegato(): "+dettaglio.getIdAllegato());
			//setto l'idAllegato dentro il modulo
			datiModulo.setIdAllegato(dettaglio.getIdAllegato());

			//bisogna creare tante pagine quanti sono i risultati della seguente lista
			RowAllegatoIV allegatoIV = null;

			// Devo recupera tutti i progressivi per cui devo fare l'allegato
			List<SigitVSk4ScDto> dtoList = getCompScByIdAllegato(ConvertUtil.convertToInteger(dettaglio.getIdAllegato()));

			for(SigitVSk4ScDto sk4Sc : dtoList){
				//log.debug("Quanti moduli di tipo allegatoII count: "+count);

				// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
				List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());
				if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
				{
					SigitVRicerca3ResponsabileDto responsabile2 = list3RespAttiviImpianto.get(0);
					isTerzoResp = true;

					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
					pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
					idRuolo = ""+responsabile.getIdRuolo();

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_SC, ConvertUtil.convertToBigDecimal(sk4Sc.getProgressivo()), sk4Sc.getDataInstall(),
							null, responsabile2.getIdContratto());

				}
				else
				{
					//vTotImpianto = vTotImpiantoResp;
					pg = pgResp;
					idRuolo = idRuoloResp;

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_SC, ConvertUtil.convertToBigDecimal(sk4Sc.getProgressivo()), sk4Sc.getDataInstall(),
							idImpRuoloPfpg, null);

				}


				log.debug("idRuolo: "+idRuolo);

				SigitTRappTipo3Dto rappTipo3Dto = cercaTRappTipo3ById(allegatoDto.getIdAllegato());

				List<SigitTDettTipo3Dto> tDettTipo3List	= getDettTipo3(ConvertUtil.convertToString(sk4Sc.getCodiceImpianto()), ConvertUtil.convertToInteger(sk4Sc.getProgressivo()), dettaglio.getIdAllegato());

				// Passo il primo elemento del dettaglio, mi servono solo i dati generali che sono comuni a tutte le righe
				allegatoIV = MapDto.mapToDatiAllegato3Now(sk4Sc, allegatoDto, rappTipo3Dto, tDettTipo3List.get(0), pg, pf, idRuolo, isTerzoResp, listaUnitaImmobiliare, impiantoDto, dettaglioTrattAcqua);

				if (GenericUtil.isNotNullOrEmpty(dettaglio.getIdIspezione()))
				{
					// Recupero l'ispezione
					dettaglioIspezione = getDettaglioIspezioneById(dettaglio.getIdIspezione());

					allegatoIV.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
				}
				else
				{

					//manutentore = getImpresaManutentrice(ConvertUtil.convertToString(allegatoDto.getFkImpRuoloPfpg()));
					manutentore =  cercaTPersonaGiuridicaById(dettaglio.getIdPersonaGiuridica());

					//mapping dati dell'impresa manutentrice
					MapDto.mapToDatiImpresaManutentriceAllegato3(allegatoIV, manutentore);
				}


//				List<SigitTDettTipo1Dto> tDettTipo1List = getDettTipo1(dettaglio.getCodiceImpianto(),
//						ConvertUtil.convertToInteger(sk4Gt.getProgressivo()), ConvertUtil.convertToString(allegatoDto.getIdAllegato()));

				 MapDto.mapToDatiAllegato3RowFumiNow(allegatoIV, tDettTipo3List);

				 listaRow.add(allegatoIV);

				//count++; //da cancelare
			}

			if(modAllegato.getMODIV().getSystem()==null)
				modAllegato.getMODIV().addNewSystem().addNewCatDig();
			if(modAllegato.getMODIV().getSystem().getCatDig()==null)
				modAllegato.getMODIV().getSystem().addNewCatDig();

			//definisce lo stato del modulo pdf ed e' comune a tutte le pagine
//		    if(isDefinitivo)
//			{
		    	richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
		    	modAllegato.getMODIV().getSystem().getCatDig().setModuloEditabile(false);
//			}
//			else
//			{
//				richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_BOZZA);
//				modAllegato.getMODII().getSystem().getCatDig().setModuloEditabile(true);
//			}


		    	if (log.isDebugEnabled())
		    	{
		    		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		    		log.debug("STAMPO ALLEGATOII RESULT: "+modAllegato);
		    		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		    	}

		} catch (SigitTAllegatoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}

		log.debug("[DbMgr::getModuloAllegatoTipo3Now] END");

		//XXX

		return modAllegato;
	}


	public MODIVDocument getModuloAllegatoTipo3(MODIVDocument modulo, DettaglioAllegato dettaglio, boolean isDefinitivo)throws DbManagerException {
		log.debug("[DbMgr::getModuloAllegatoTipo3] BEGIN");

		SigitTAllegatoDto allegatoDto = null;
		SigitTImpiantoDto impiantoDto = null;

		//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		SigitTPersonaGiuridicaDto pg = null;
		// Se il responsabile e una PG
		SigitTPersonaGiuridicaDto pgResp = null;
		// Se il responsabile e una PF
		SigitTPersonaFisicaDto pf = null;

		// qui setto l'idImpRuoloPfpg del responsabile
		BigDecimal idImpRuoloPfpg = null;

		boolean isTerzoResp = false;

//		SigitTPersonaGiuridicaDto personaGiuridicaDto = null;
//		SigitTPersonaFisicaDto personaFisicaDto = null;

		SigitTPersonaGiuridicaDto manutentore = null;
		DettaglioIspezione dettaglioIspezione = null;

		String idRuoloResp = null;
		//in questo oggetto setto l'id 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		String idRuolo = null;

		try {

			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(new BigDecimal(dettaglio.getIdAllegato()));

			//trovo il dettaglio ALLEGATO
			allegatoDto = getSigitTAllegatoDao().findByPrimaryKey(pk);

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			//trovo il dettaglio IMPIANTO
			impiantoDto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			//trovo l'unita' immobiliare,dati locazione impianto
			List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()), ConvertUtil.convertToSqlDate(dettaglio.getDataControllo()));

			if (responsabile != null)
			{
				if(responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				}else{
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica );
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToString(responsabile.getIdRuolo());

			}

			log.debug("[DbMgr::getModuloAllegatoTipo3] COMINCIO IL MAPPING DEI DATI");

			//comincio il mapping dei dati
			it.csi.sigit.sigitwebn.xml.allegato4.data.RichiestaDocument.Richiesta richiesta = modulo.getMODIV().getRichiesta();
			//codice Bollino comune a tutte le pagine
			richiesta.getDatiIntestazione().setCodiceBollino(ConvertUtil.formattaSiglaBollino(allegatoDto.getFkNumeroBollino()));
			//vado a lavorare sulle pagine del modulo
			List<it.csi.sigit.sigitwebn.xml.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV> allegatoIVList = richiesta.getDatiAllegato().getAllegatoIV().getRowAllegatoIVList();
			//definisce lo stato del modulo pdf ed e' comune a tutte le pagine

			//int count = 1; //da cancellare
			for(RowAllegatoIV allegatoIV : allegatoIVList){
				//log.debug("Quanti moduli di tipo allegatoIV count: "+count);


				// Devo dettare il responsabile/3 responsabile per ogni singola apparecchiatura
				List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());
				if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
				{
					SigitVRicerca3ResponsabileDto responsabile2 = list3RespAttiviImpianto.get(0);
					isTerzoResp = true;

					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
					pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
					idRuolo = ""+responsabile.getIdRuolo();

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_SC, ConvertUtil.convertToBigDecimal(allegatoIV.getAENumSC()), DateUtil.getSqlDate(allegatoIV.getAEDataInstallaz()),
							null, responsabile2.getIdContratto());
				}
				else
				{
					//vTotImpianto = vTotImpiantoResp;
					pg = pgResp;
					idRuolo = idRuoloResp;

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_SC, ConvertUtil.convertToBigDecimal(allegatoIV.getAENumSC()), DateUtil.getSqlDate(allegatoIV.getAEDataInstallaz()),
							idImpRuoloPfpg, null);
				}


				log.debug("idRuolo: "+idRuolo);
				MapDto.mapToDatiPrecompilatiAllegato3(allegatoIV, listaUnitaImmobiliare, impiantoDto, allegatoDto);
				MapDto.mapToDatiRespImpiantoAllegato3(allegatoIV, pg, pf, idRuolo, isTerzoResp);

				if (GenericUtil.isNotNullOrEmpty(dettaglio.getIdIspezione()))
				{
					// Recupero l'ispezione
					dettaglioIspezione = getDettaglioIspezioneById(dettaglio.getIdIspezione());

					allegatoIV.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
				}
				else
				{

					//per cercare l'impresa manutentrice

					//manutentore = getImpresaManutentrice(ConvertUtil.convertToString(allegatoDto.getFkImpRuoloPfpg()));
					manutentore =  cercaTPersonaGiuridicaById(dettaglio.getIdPersonaGiuridica());


					//mapping dati dell'impresa manutentrice
					MapDto.mapToDatiImpresaManutentriceAllegato3(allegatoIV, manutentore);
				}

				//count++; //da cancelare
			}

			// BEPPE - modifica SANDRO
			List<SigitDFluidoDto> elencoFluidi = getElencoFluidi();
			modulo.getMODIV().getRichiesta().getDatiModulo().setElencoCombustibile(MapDto.mapToElencoCombustibileAllegato4(elencoFluidi));
			modulo.getMODIV().getRichiesta().getDatiModulo().setElencoFluidoTermoVett(MapDto.mapToElencoFluidoAllegato4(elencoFluidi));

			if(modulo.getMODIV().getSystem()==null)
				modulo.getMODIV().addNewSystem().addNewCatDig();
			if(modulo.getMODIV().getSystem().getCatDig()==null)
				modulo.getMODIV().getSystem().addNewCatDig();

			if(isDefinitivo)
			{
		    	richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
		    	modulo.getMODIV().getSystem().getCatDig().setModuloEditabile(false);
			}
			else
			{
				richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_BOZZA);
				modulo.getMODIV().getSystem().getCatDig().setModuloEditabile(true);
			}


			if (log.isDebugEnabled())
			{
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				log.debug("STAMPO ALLEGATOIII RESULT: "+modulo);
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}
		}catch (SigitTAllegatoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}

		log.debug("[DbMgr::getModuloAllegatoTipo3] END");
		return modulo;
	}

	public MODVDocument getModuloAllegatoTipo4Now(DettaglioAllegato dettaglio)throws DbManagerException {
		log.debug("[DbMgr::getModuloAllegatoTipo4Now] BEGIN");

		it.csi.sigit.sigitwebn.xml.allegato5.data.MODVDocument modAllegato = it.csi.sigit.sigitwebn.xml.allegato5.data.MODVDocument.Factory.newInstance();

		SigitTAllegatoDto allegatoDto = null;
		SigitTImpiantoDto impiantoDto =null;


		// Se il responsabile e una PG
		SigitTPersonaGiuridicaDto pgResp = null;
		// Se il responsabile e una PF
		SigitTPersonaFisicaDto pf = null;
		//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		SigitTPersonaGiuridicaDto pg = null;

		// qui setto l'idImpRuoloPfpg del responsabile
		BigDecimal idImpRuoloPfpg = null;

		boolean isTerzoResp = false;

		SigitTPersonaGiuridicaDto manutentore = null;
		DettaglioIspezione dettaglioIspezione = null;

		String idRuoloResp = null;
		//in questo oggetto setto l'id 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		String idRuolo = null;

		try {
			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(new BigDecimal(dettaglio.getIdAllegato()));

			//trovo il dettaglio ALLEGATO
			allegatoDto = getSigitTAllegatoDao().findByPrimaryKey(pk);

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			//trovo il dettaglio IMPIANTO
			impiantoDto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			//trovo l'unita' immobiliare,dati locazione impianto
			List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()), ConvertUtil.convertToSqlDate(dettaglio.getDataControllo()));

			//sezione c. TRATTAMENTO DELL'ACQUA
//			SigitTTrattH2OPk pkTrattAcqua = new SigitTTrattH2OPk();
//			pkTrattAcqua.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));
			SigitTTrattH2ODto dettaglioTrattAcqua = cercaSigitTTrattH2OByCodImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			if (responsabile != null)
			{
				if(responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				}else{
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica );
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToString(responsabile.getIdRuolo());
			}


			/*
			log.debug("[DbMgr::getModuloAllegatoTipo1Now] COMINCIO IL MAPPING DEI DATI");
			//comincio il mapping dei dati
			it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta richiesta = modulo.getMODII().getRichiesta();
			//codice Bollino comune a tutte le pagine
			richiesta.getDatiIntestazione().setCodiceBollino(ConvertUtil.formattaSiglaBollino(allegatoDto.getFkNumeroBollino()));
			//vado a lavorare sulle pagine del modulo
			List<RowAllegatoII> allegatoIIList = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
			*/
			//istanzio gli oggetti per modol

			it.csi.sigit.sigitwebn.xml.allegato5.data.MODVDocument.MODV mod = modAllegato.addNewMODV();
			it.csi.sigit.sigitwebn.xml.allegato5.data.RichiestaDocument.Richiesta richiesta = mod.addNewRichiesta();
			List<RowAllegatoV> listaRow = richiesta.addNewDatiAllegato().addNewAllegatoV().getRowAllegatoVList();
			modAllegato.getMODV().addNewSystem().addNewCatDig();
			//dati che sono comuni e non ripetuti per ogni pagina
			it.csi.sigit.sigitwebn.xml.allegato5.data.DatiModuloDocument.DatiModulo datiModulo = richiesta.addNewDatiModulo();
			it.csi.sigit.sigitwebn.xml.allegato5.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = richiesta.addNewDatiIntestazione();
			datiIntestazione.setCodiceBollino(ConvertUtil.formattaSiglaBollino(ConvertUtil.convertToBigDecimal(dettaglio.getNumeroBollinoVerde())));

			datiModulo.setStatoModulo(Constants.STATO_MODULO_BOZZA);

			log.debug("[ServiziMgr::getAllegato] ****** INSERIMENTO *****  da.getIdAllegato(): "+dettaglio.getIdAllegato());
			//setto l'idAllegato dentro il modulo
			datiModulo.setIdAllegato(dettaglio.getIdAllegato());

			//bisogna creare tante pagine quanti sono i risultati della seguente lista
			RowAllegatoV allegatoV = null;

			// Devo recupera tutti i progressivi per cui devo fare l'allegato
			List<SigitVSk4CgDto> dtoList = getCompCgByIdAllegato(ConvertUtil.convertToInteger(dettaglio.getIdAllegato()));

			//for(RowAllegatoII allegatoII : allegatoIIList){
			for(SigitVSk4CgDto sk4Cg : dtoList){
				//log.debug("Quanti moduli di tipo allegatoII count: "+count);

				// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
				List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());
				if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
				{
					SigitVRicerca3ResponsabileDto responsabile2 = list3RespAttiviImpianto.get(0);
					isTerzoResp = true;

					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
					pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
					idRuolo = ""+responsabile.getIdRuolo();

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_CG, ConvertUtil.convertToBigDecimal(sk4Cg.getProgressivo()), sk4Cg.getDataInstall(),
							null, responsabile2.getIdContratto());

				}
				else
				{
					//vTotImpianto = vTotImpiantoResp;
					pg = pgResp;
					idRuolo = idRuoloResp;

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_CG, ConvertUtil.convertToBigDecimal(sk4Cg.getProgressivo()), sk4Cg.getDataInstall(),
							idImpRuoloPfpg, null);

				}


				log.debug("idRuolo: "+idRuolo);
				//MapDto.mapToDatiPrecompilatiAllegato1Now(allegatoII, listaUnitaImmobiliare, impiantoDto, allegatoDto);
				//MapDto.mapToDatiRespImpiantoAllegato1Now(allegatoII, pg, pf, idRuolo, isTerzoResp);
				SigitTRappTipo4Dto rappTipo4Dto = cercaTRappTipo4ById(allegatoDto.getIdAllegato());

				List<SigitTDettTipo4Dto> tDettTipo4List	= getDettTipo4(ConvertUtil.convertToString(sk4Cg.getCodiceImpianto()), ConvertUtil.convertToInteger(sk4Cg.getProgressivo()), dettaglio.getIdAllegato());

				// Passo il primo elemento del dettaglio, mi servono solo i dati generali che sono comuni a tutte le righe
				allegatoV = MapDto.mapToDatiAllegato4Now(sk4Cg, allegatoDto, rappTipo4Dto, tDettTipo4List.get(0), pg, pf, idRuolo, isTerzoResp, listaUnitaImmobiliare, impiantoDto, dettaglioTrattAcqua);

				if (GenericUtil.isNotNullOrEmpty(dettaglio.getIdIspezione()))
				{
					// Recupero l'ispezione
					dettaglioIspezione = getDettaglioIspezioneById(dettaglio.getIdIspezione());

					allegatoV.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
				}
				else
				{

					//manutentore = getImpresaManutentrice(ConvertUtil.convertToString(allegatoDto.getFkImpRuoloPfpg()));
					manutentore =  cercaTPersonaGiuridicaById(dettaglio.getIdPersonaGiuridica());

					//mapping dati dell'impresa manutentrice
					MapDto.mapToDatiImpresaManutentriceAllegato4(allegatoV, manutentore);
				}


//				List<SigitTDettTipo1Dto> tDettTipo1List = getDettTipo1(dettaglio.getCodiceImpianto(),
//						ConvertUtil.convertToInteger(sk4Gt.getProgressivo()), ConvertUtil.convertToString(allegatoDto.getIdAllegato()));

				 MapDto.mapToDatiAllegato4RowFumiNow(allegatoV, tDettTipo4List);

				 listaRow.add(allegatoV);

				//count++; //da cancelare
			}

			modAllegato.getMODV().getRichiesta().getDatiModulo().setElencoFluidoTermoVett(MapDto.mapToElencoFluidoAllegato5(getElencoFluidi()));

			if(modAllegato.getMODV().getSystem()==null)
				modAllegato.getMODV().addNewSystem().addNewCatDig();
			if(modAllegato.getMODV().getSystem().getCatDig()==null)
				modAllegato.getMODV().getSystem().addNewCatDig();

			//definisce lo stato del modulo pdf ed e' comune a tutte le pagine
//		    if(isDefinitivo)
//			{
		    	richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
		    	modAllegato.getMODV().getSystem().getCatDig().setModuloEditabile(false);
//			}
//			else
//			{
//				richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_BOZZA);
//				modAllegato.getMODII().getSystem().getCatDig().setModuloEditabile(true);
//			}


		    	if (log.isDebugEnabled())
		    	{
		    		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		    		log.debug("STAMPO ALLEGATOV RESULT: "+modAllegato);
		    		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		    	}

		} catch (SigitTAllegatoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}

		log.debug("[DbMgr::getModuloAllegatoTipo4Now] END");

		//XXX

		return modAllegato;
	}

	public MODVDocument getModuloAllegatoTipo4(MODVDocument modulo, DettaglioAllegato dettaglio, boolean isDefinitivo)throws DbManagerException {
		log.debug("[DbMgr::getModuloAllegatoTipo4] BEGIN");


		SigitTAllegatoDto allegatoDto = null;
		SigitTImpiantoDto impiantoDto = null;

		//in questo oggetto setto il 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		SigitTPersonaGiuridicaDto pg = null;
		// Se il responsabile e una PG
		SigitTPersonaGiuridicaDto pgResp = null;
		// Se il responsabile e una PF
		SigitTPersonaFisicaDto pf = null;

		// qui setto l'idImpRuoloPfpg del responsabile
		BigDecimal idImpRuoloPfpg = null;

		boolean isTerzoResp = false;

//		SigitTPersonaGiuridicaDto personaGiuridicaDto = null;
//		SigitTPersonaFisicaDto personaFisicaDto = null;

		SigitTPersonaGiuridicaDto manutentore = null;
		DettaglioIspezione dettaglioIspezione = null;

		String idRuoloResp = null;
		//in questo oggetto setto l'id 3resonsabile (se c'e') altrimenti il responsabile (trovato sopra)
		String idRuolo = null;

		try {

			SigitTAllegatoPk pk = new SigitTAllegatoPk();
			pk.setIdAllegato(new BigDecimal(dettaglio.getIdAllegato()));

			//trovo il dettaglio ALLEGATO
			allegatoDto = getSigitTAllegatoDao().findByPrimaryKey(pk);

			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			//trovo il dettaglio IMPIANTO
			impiantoDto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			//trovo l'unita' immobiliare,dati locazione impianto
			List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));

			// Cerco il responsabile alla data, mi servira' nel caso non ci sia il 3Responsabile
			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()), ConvertUtil.convertToSqlDate(dettaglio.getDataControllo()));

			if (responsabile != null)
			{
				if(responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				}else{
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica );
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToString(responsabile.getIdRuolo());

			}


			log.debug("[DbMgr::getModuloAllegatoTipo4] COMINCIO IL MAPPING DEI DATI");

			//comincio il mapping dei dati
			it.csi.sigit.sigitwebn.xml.allegato5.data.RichiestaDocument.Richiesta richiesta = modulo.getMODV().getRichiesta();
			//codice Bollino comune a tutte le pagine
			richiesta.getDatiIntestazione().setCodiceBollino(ConvertUtil.formattaSiglaBollino(allegatoDto.getFkNumeroBollino()));
			//vado a lavorare sulle pagine del modulo
			List<it.csi.sigit.sigitwebn.xml.allegato5.data.RowAllegatoVDocument.RowAllegatoV> allegatoVList = richiesta.getDatiAllegato().getAllegatoV().getRowAllegatoVList();
			//definisce lo stato del modulo pdf ed e' comune a tutte le pagine

			//int count = 1; //da cancellare
			for(RowAllegatoV allegatoV : allegatoVList){
				//log.debug("Quanti moduli di tipo allegatoV count: "+count);

				// Devo dettare il responsabile/3 responsabile per ogni singola apparecchiatura
				List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());
				if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
				{
					SigitVRicerca3ResponsabileDto responsabile2 = list3RespAttiviImpianto.get(0);
					isTerzoResp = true;

					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
					pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
					idRuolo = ""+responsabile.getIdRuolo();

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_CG, ConvertUtil.convertToBigDecimal(allegatoV.getAENumCG()), DateUtil.getSqlDate(allegatoV.getAEDataInstallaz()),
							null, responsabile2.getIdContratto());
				}
				else
				{
					//vTotImpianto = vTotImpiantoResp;
					pg = pgResp;
					idRuolo = idRuoloResp;

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(),
							Constants.TIPO_COMPONENTE_CG, ConvertUtil.convertToBigDecimal(allegatoV.getAENumCG()), DateUtil.getSqlDate(allegatoV.getAEDataInstallaz()),
							idImpRuoloPfpg, null);
				}

				log.debug("idRuolo: "+idRuolo);
				MapDto.mapToDatiPrecompilatiAllegato4(allegatoV, listaUnitaImmobiliare, impiantoDto, allegatoDto);
				MapDto.mapToDatiRespImpiantoAllegato4(allegatoV, pg, pf, idRuolo, isTerzoResp);

				if (GenericUtil.isNotNullOrEmpty(dettaglio.getIdIspezione()))
				{
					// Recupero l'ispezione
					dettaglioIspezione = getDettaglioIspezioneById(dettaglio.getIdIspezione());

					allegatoV.setAA3RagSociale(MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione));
				}
				else
				{

					//per cercare l'impresa manutentrice

					//manutentore = getImpresaManutentrice(ConvertUtil.convertToString(allegatoDto.getFkImpRuoloPfpg()));
					manutentore =  cercaTPersonaGiuridicaById(dettaglio.getIdPersonaGiuridica());


					//mapping dati dell'impresa manutentrice
					MapDto.mapToDatiImpresaManutentriceAllegato4(allegatoV, manutentore);
				}

				//count++; //da cancelare
			}


			if(modulo.getMODV().getSystem()==null)
				modulo.getMODV().addNewSystem().addNewCatDig();
			if(modulo.getMODV().getSystem().getCatDig()==null)
				modulo.getMODV().getSystem().addNewCatDig();

			if(isDefinitivo)
			{
		    	richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
		    	modulo.getMODV().getSystem().getCatDig().setModuloEditabile(false);
			}
			else
			{
				richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_BOZZA);
				modulo.getMODV().getSystem().getCatDig().setModuloEditabile(true);
			}


			if (log.isDebugEnabled())
			{
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				log.debug("STAMPO ALLEGATO_V RESULT: "+modulo);
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}
		}catch (SigitTAllegatoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}

		log.debug("[DbMgr::getModuloAllegatoTipo4] END");
		return modulo;
	}



	public void consolidaSistemiRegolazioneContabilizzazione(String idImpianto, String cfUtente, Richiesta richiesta) throws DbManagerException {
		log.debug("[DbMgr::consolidaSistemiRegolazione] START");
		try
		{
			log.debug("cancellazione sigit_t_compx_semplice");
			getSigitTCompXSempliceDao().customDeleterByCodImpianto(new Integer(idImpianto));
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_compx_semplice", "codice_impianto="+idImpianto));
			BigDecimal codImpianto = new BigDecimal(idImpianto);
			DatiSchedaSistemiRegolaz datiSchedaSistemiRegolaz = richiesta.getDatiSchedaSistemiRegolaz();
			if(datiSchedaSistemiRegolaz!=null)
			{
				log.debug("Consolidamento scheda 5");
				RegolazionePrimaria rp = datiSchedaSistemiRegolaz.getRegolazionePrimaria();
				SigitTCompXSempliceDto dtoXsemplice = new SigitTCompXSempliceDto();
				if(rp!=null)
				{
					log.debug("Consolidamento scheda 5: regolazione primaria");
					dtoXsemplice = MapDto.getSigitTCompxSemplice(rp, cfUtente);
					consolidaSR(rp.getSezSR(), codImpianto, cfUtente);
					consolidaVR(rp.getSezVR(), codImpianto, cfUtente);
				}
				dtoXsemplice.setCodiceImpianto(codImpianto);
				RegolazioneSingoloAmb rsa = datiSchedaSistemiRegolaz.getRegolazioneSingoloAmb();
				if(rsa!=null)
				{
					log.debug("Consolidamento scheda 5: regolazione singolo ambiente di zona");
					MapDto.getSigitTCompxSemplice(rsa, dtoXsemplice);
				}
				DatiSchedaSistemiDistrib datiSchedaSistemiDistrib = richiesta.getDatiSchedaSistemiDistrib();
				if(datiSchedaSistemiDistrib!=null)
				{
					log.debug("Consolidamento scheda 6: sistemi di distribuzione");
					MapDto.getSigitTCompXSemplice(dtoXsemplice , datiSchedaSistemiDistrib);
					consolidaVX(datiSchedaSistemiDistrib.getSezVasi(), codImpianto, cfUtente);
					consolidaPO(datiSchedaSistemiDistrib.getSezPO(), codImpianto, cfUtente);
				}
				DatiSchedaSistemaEmissione datiSchedaSistemaEmissione = richiesta.getDatiSchedaSistemaEmissione();
				if(datiSchedaSistemaEmissione!=null)
				{
					log.debug("Consolidamento scheda 7: sistema emissione");
					MapDto.getSigitTCompxSemplice(datiSchedaSistemaEmissione, dtoXsemplice);
				}
				log.debug("inserimento compx_semplice");
				getSigitTCompXSempliceDao().insert(dtoXsemplice);
			}
		} catch (Exception e) {
			log.error("Errore ", e);
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally{
			log.debug("[DbMgr::consolidaSistemiRegolazione] END");
		}

	}


	private void consolidaVX(SezVasi sezVX, BigDecimal codImpianto, String cfUtente) throws SigitTCompXDaoException, SigitTCompVxDaoException {
		log.debug("cancellazione VX");
		getSigitTCompVxDao().customDeleterByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_vx", "codice_impianto="+codImpianto));
		SigitTCompXDto filter = new SigitTCompXDto();
		filter.setCodiceImpianto(codImpianto);
		filter.setIdTipoComponente(Constants.TIPO_COMPONENTE_VX);
		getSigitTCompXDao().customDeleterByFilter(filter);
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente=VX"));

		if(sezVX!=null)
		{
			log.debug("Consolidamento scheda 6: vasi - VX");
			List<RowVasi> rowVXList = sezVX.getRowVasiList();
			if(rowVXList!=null)
				for (RowVasi rowVX : rowVXList) {
					SigitTCompXDto compX = MapDto.getSigitTCompX(rowVX, codImpianto);
					if(compX !=null && compX.getProgressivo()!=null)
					{
						log.debug("Inserimento COMP VX");
						SigitTCompVxDto compVx = MapDto.getSigitTCompVX(rowVX, codImpianto);
						compX.setUtenteUltMod(cfUtente);
						compX.setDataUltMod(DateUtil.getSqlDataCorrente());
						getSigitTCompXDao().insert(compX);
						getSigitTCompVxDao().insert(compVx);
					}
				}
		}
	}

	private void consolidaSR(SezSR sezSR, BigDecimal codImpianto, String cfUtente) throws SigitTCompSrDaoException, SigitTCompXDaoException
	{
		log.debug("cancellazione SR");
		getSigitTCompSrDao().customDeleterByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_sr", "codice_impianto="+codImpianto));
		SigitTCompXDto filter = new SigitTCompXDto();
		filter.setCodiceImpianto(codImpianto);
		filter.setIdTipoComponente(Constants.TIPO_COMPONENTE_SR);
		getSigitTCompXDao().customDeleterByFilter(filter);
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente=SR"));

		if(sezSR!=null)
		{
			log.debug("Consolidamento scheda 5: regolazione primaria - SR");
			List<RowSR> rowSRList = sezSR.getRowSRList();
			if(rowSRList!=null)
				for (RowSR rowSR : rowSRList) {
					SigitTCompXDto compX = MapDto.getSigitTCompX(rowSR, codImpianto);
					if(compX !=null && compX.getDataInstall()!=null)
					{
						log.debug("Inserimento COMP SR");
						SigitTCompSrDto compSr = MapDto.getSigitTCompSR(rowSR, codImpianto);
						compX.setUtenteUltMod(cfUtente);
						compX.setDataUltMod(DateUtil.getSqlDataCorrente());
						getSigitTCompXDao().insert(compX);
						getSigitTCompSrDao().insert(compSr);
					}
					SezSRsostituite sezSRsostituite = rowSR.getSezSRsostituite();
					if(sezSRsostituite!=null)
					{
						log.debug("Inserimento sezione sostituite");
						List<RowSRsost> rowSRsostList = sezSRsostituite.getRowSRsostList();
						if(rowSRsostList!=null)
							for (RowSRsost rowSRsost : rowSRsostList) {
								String progressivo = ConvertUtil.convertToString(rowSR.getL51NumSR());
								SigitTCompXDto xSostDto = MapDto.getSigitTCompX(rowSRsost, codImpianto, progressivo);
								SigitTCompSrDto xSrDto = MapDto.getSigitTCompSR(rowSRsost, codImpianto, progressivo);
								xSostDto.setUtenteUltMod(cfUtente);
								xSostDto.setDataUltMod(DateUtil.getSqlDataCorrente());
								getSigitTCompXDao().insert(xSostDto);
								getSigitTCompSrDao().insert(xSrDto);
							}
					}
				}
		}
	}

	private void consolidaVR(SezVR sezVR, BigDecimal codImpianto, String cfUtente) throws SigitTCompXDaoException, SigitTCompVrDaoException
	{
		getSigitTCompVrDao().customDeleterByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_vr", "codice_impianto="+codImpianto));
		SigitTCompXDto filter = new SigitTCompXDto();
		filter.setCodiceImpianto(codImpianto);
		filter.setIdTipoComponente(Constants.TIPO_COMPONENTE_VR);
		getSigitTCompXDao().customDeleterByFilter(filter);
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente=VR"));

		if(sezVR!=null)
		{
			log.debug("Consolidamento scheda 5: regolazione primaria - VR");
			List<RowVR> rowVRList = sezVR.getRowVRList();
			if(rowVRList!=null)
				for (RowVR rowVR : rowVRList) {
					SigitTCompXDto compX = MapDto.getSigitTCompX(rowVR, codImpianto);
					if(compX !=null && compX.getDataInstall()!=null)
					{
						log.debug("Inserimento COMP VR");
						SigitTCompVrDto compVr = MapDto.getSigitTCompVR(rowVR, codImpianto);
						compX.setUtenteUltMod(cfUtente);
						compX.setDataUltMod(DateUtil.getSqlDataCorrente());
						getSigitTCompXDao().insert(compX);
						getSigitTCompVrDao().insert(compVr);
					}
					SezVRsostituite sezVRsostituite = rowVR.getSezVRsostituite();
					if(sezVRsostituite!=null)
					{
						log.debug("Inserimento sezione sostituite");
						List<RowVRsost> rowVRsostList = sezVRsostituite.getRowVRsostList();
						if(rowVRsostList!=null)
							for (RowVRsost rowVRsost : rowVRsostList) {
								String progressivo = ConvertUtil.convertToString(rowVR.getL51NumVR());
								SigitTCompXDto xSostDto = MapDto.getSigitTCompX(rowVRsost, codImpianto, progressivo);
								SigitTCompVrDto xVrDto = MapDto.getSigitTCompVR(rowVRsost, codImpianto, progressivo);
								xSostDto.setUtenteUltMod(cfUtente);
								xSostDto.setDataUltMod(DateUtil.getSqlDataCorrente());
								getSigitTCompXDao().insert(xSostDto);
								getSigitTCompVrDao().insert(xVrDto);
							}
					}
				}
		}
	}

	private void consolidaPO(SezPO sezPO, BigDecimal codImpianto, String cfUtente) throws SigitTCompPoDaoException, SigitTCompXDaoException
	{
		getSigitTCompPoDao().customDeleterByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_po", "codice_impianto="+codImpianto));
		SigitTCompXDto filter = new SigitTCompXDto();
		filter.setCodiceImpianto(codImpianto);
		filter.setIdTipoComponente(Constants.TIPO_COMPONENTE_PO);
		getSigitTCompXDao().customDeleterByFilter(filter);
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente=SR"));

		if(sezPO!=null)
		{
			log.debug("Consolidamento scheda 6: regolazione primaria - PO");
			List<RowPO> rowPOList = sezPO.getRowPOList();
			if(rowPOList!=null)
				for (RowPO rowPO : rowPOList) {
					SigitTCompXDto compX = MapDto.getSigitTCompX(rowPO, codImpianto);
					if(compX !=null && compX.getDataInstall()!=null)
					{
						log.debug("Inserimento COMP PO");
						SigitTCompPoDto compVr = MapDto.getSigitTCompPO(rowPO, codImpianto);
						compX.setUtenteUltMod(cfUtente);
						compX.setDataUltMod(DateUtil.getSqlDataCorrente());
						getSigitTCompXDao().insert(compX);
						getSigitTCompPoDao().insert(compVr);
					}
					SezPOsostituite sezPOsostituite = rowPO.getSezPOsostituite();
					if(sezPOsostituite!=null)
					{
						log.debug("Inserimento sezione sostituite");
						List<RowPOsost> rowPOsostList = sezPOsostituite.getRowPOsostList();
						if(rowPOsostList!=null)
							for (RowPOsost rowVRsost : rowPOsostList) {
								String progressivo = ConvertUtil.convertToString(rowPO.getL64NumPO());
								SigitTCompXDto xSostDto = MapDto.getSigitTCompX(rowVRsost, codImpianto, progressivo);
								SigitTCompPoDto xPoDto = MapDto.getSigitTCompPO(rowVRsost, codImpianto, progressivo);
								xSostDto.setUtenteUltMod(cfUtente);
								xSostDto.setDataUltMod(DateUtil.getSqlDataCorrente());
								getSigitTCompXDao().insert(xSostDto);
								getSigitTCompPoDao().insert(xPoDto);
							}
					}
				}
		}
	}

	public void consolidaAC(String idImpianto, String cfUtente, DatiSchedaSistemaAC datiSchedaSistemaAC) throws SigitTCompAcDaoException, SigitTCompXDaoException {
		log.debug("consolidaAC: START");
		BigDecimal codImpianto = new BigDecimal(idImpianto);
		getSigitTCompAcDao().customDeleterByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_ac", "codice_impianto="+idImpianto));
		SigitTCompXDto filter = new SigitTCompXDto();
		filter.setCodiceImpianto(codImpianto);
		filter.setIdTipoComponente(Constants.TIPO_COMPONENTE_AC);
		getSigitTCompXDao().customDeleterByFilter(filter);
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+idImpianto+"&tipo_componente=AC"));
		if(datiSchedaSistemaAC !=null )
		{
			SezAC sezAC = datiSchedaSistemaAC.getSezAC();
			if(sezAC!=null)
			{
				log.debug("Consolidamento scheda 8: AC");
				List<RowAC> rowACList = sezAC.getRowACList();
				if(rowACList!=null)
					for (RowAC rowAC : rowACList) {
						SigitTCompXDto compX = MapDto.getSigitTCompX(rowAC, codImpianto);
						if(compX !=null && compX.getDataInstall()!=null)
						{
							log.debug("Inserimento COMP AC");
							//salvataggio
							SigitTCompAcDto compAc = MapDto.getSigitTCompAC(rowAC, codImpianto);
							compX.setUtenteUltMod(cfUtente);
							compX.setDataUltMod(DateUtil.getSqlDataCorrente());
							getSigitTCompXDao().insert(compX);
							getSigitTCompAcDao().insert(compAc);
						}
						SezACsostituite sezACsostituite = rowAC.getSezACsostituite();
						if(sezACsostituite!=null)
						{
							log.debug("Inserimento sezione sostituite");
							List<RowACsost> rowACsostList = sezACsostituite.getRowACsostList();
							if(rowACsostList!=null)
								for (RowACsost rowACsost : rowACsostList) {
									String progressivo = ConvertUtil.convertToString(rowAC.getL81NumAC());
									SigitTCompXDto xSostDto = MapDto.getSigitTCompX(rowACsost, codImpianto, progressivo);
									SigitTCompAcDto xAcDto = MapDto.getSigitTCompAC(rowACsost, codImpianto, progressivo);
									xSostDto.setUtenteUltMod(cfUtente);
									xSostDto.setDataUltMod(DateUtil.getSqlDataCorrente());
									getSigitTCompXDao().insert(xSostDto);
									getSigitTCompAcDao().insert(xAcDto);
								}
						}
					}
			}
		}
		log.debug("consolidaAC: END");
	}

	public void consolidaTE(String idImpianto, String cfUtente, DatiAltriComponentiTE datiAltriComponentiTE) throws SigitTCompXDaoException, SigitTCompTeDaoException {
		log.debug("consolidaTE: START");
		BigDecimal codImpianto = new BigDecimal(idImpianto);
		getSigitTCompTeDao().customDeleterByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_te", "codice_impianto="+idImpianto));
		SigitTCompXDto filter = new SigitTCompXDto();
		filter.setCodiceImpianto(codImpianto);
		filter.setIdTipoComponente(Constants.TIPO_COMPONENTE_TE);
		getSigitTCompXDao().customDeleterByFilter(filter);
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+idImpianto+"&tipo_componente=TE"));
		if(datiAltriComponentiTE !=null )
		{
			SezTE sezTE = datiAltriComponentiTE.getSezTE();
			if(sezTE!=null)
			{
				log.debug("Consolidamento scheda 9: TE");
				List<RowTE> rowTEList = sezTE.getRowTEList();
				if(rowTEList!=null)
					for (RowTE rowTE : rowTEList) {
						SigitTCompXDto compX = MapDto.getSigitTCompX(rowTE, codImpianto);
						if(compX !=null && compX.getDataInstall()!=null)
						{
							log.debug("Inserimento COMP TE");
							//salvataggio
							SigitTCompTeDto compTe = MapDto.getSigitTCompTE(rowTE, codImpianto);
							compX.setUtenteUltMod(cfUtente);
							compX.setDataUltMod(DateUtil.getSqlDataCorrente());
							getSigitTCompXDao().insert(compX);
							getSigitTCompTeDao().insert(compTe);
						}
						SezTEsostituite sezTEsostituite = rowTE.getSezTEsostituite();
						if(sezTEsostituite!=null)
						{
							log.debug("Inserimento sezione sostituite");
							List<RowTEsost> rowTEsostList = sezTEsostituite.getRowTEsostList();
							if(rowTEsostList!=null)
								for (RowTEsost rowTEsost : rowTEsostList) {
									String progressivo = ConvertUtil.convertToString(rowTE.getL91NumTE());
									SigitTCompXDto xSostDto = MapDto.getSigitTCompX(rowTEsost, codImpianto, progressivo);
									SigitTCompTeDto xTeDto = MapDto.getSigitTCompTE(rowTEsost, codImpianto, progressivo);
									xSostDto.setUtenteUltMod(cfUtente);
									xSostDto.setDataUltMod(DateUtil.getSqlDataCorrente());
									getSigitTCompXDao().insert(xSostDto);
									getSigitTCompTeDao().insert(xTeDto);
								}
						}
					}
			}
		}
	}

	public void consolidaRV(String idImpianto, String cfUtente, DatiAltriComponentiRV datiAltriComponentiRV) throws SigitTCompRvDaoException, SigitTCompXDaoException {
		BigDecimal codImpianto = new BigDecimal(idImpianto);
		getSigitTCompRvDao().customDeleterByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_rv", "codice_impianto="+idImpianto));
		SigitTCompXDto filter = new SigitTCompXDto();
		filter.setCodiceImpianto(codImpianto);
		filter.setIdTipoComponente(Constants.TIPO_COMPONENTE_RV);
		getSigitTCompXDao().customDeleterByFilter(filter);
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+idImpianto+"&tipo_componente=RV"));
		if(datiAltriComponentiRV !=null )
		{
			SezRV sezRV = datiAltriComponentiRV.getSezRV();
			if(sezRV!=null)
			{
				log.debug("Consolidamento scheda 9: RV");
				List<RowRV> rowRVList = sezRV.getRowRVList();
				if(rowRVList!=null)
					for (RowRV rowRV : rowRVList) {
						SigitTCompXDto compX = MapDto.getSigitTCompX(rowRV, codImpianto);
						if(compX !=null && compX.getDataInstall()!=null)
						{
							log.debug("Inserimento COMP RV");
							//salvataggio
							SigitTCompRvDto compTe = MapDto.getSigitTCompRV(rowRV, codImpianto);
							compX.setUtenteUltMod(cfUtente);
							compX.setDataUltMod(DateUtil.getSqlDataCorrente());
							getSigitTCompXDao().insert(compX);
							getSigitTCompRvDao().insert(compTe);
						}
						SezRVsostituite sezRVsostituite = rowRV.getSezRVsostituite();
						if(sezRVsostituite!=null)
						{
							log.debug("Inserimento sezione sostituite");
							List<RowRVsost> rowRVsostList = sezRVsostituite.getRowRVsostList();
							if(rowRVsostList!=null)
								for (RowRVsost rowRVsost : rowRVsostList) {
									String progressivo = ConvertUtil.convertToString(rowRV.getL92NumRV());
									SigitTCompXDto xSostDto = MapDto.getSigitTCompX(rowRVsost, codImpianto, progressivo);
									SigitTCompRvDto xTeDto = MapDto.getSigitTCompRV(rowRVsost, codImpianto, progressivo);
									xSostDto.setUtenteUltMod(cfUtente);
									xSostDto.setDataUltMod(DateUtil.getSqlDataCorrente());
									getSigitTCompXDao().insert(xSostDto);
									getSigitTCompRvDao().insert(xTeDto);
								}
						}
					}
			}
		}
	}

	public void consolidaSCX(String idImpianto, String cfUtente, DatiAltriComponentiSC datiAltriComponentiSC) throws SigitTCompScxDaoException, SigitTCompXDaoException {
		BigDecimal codImpianto = new BigDecimal(idImpianto);
		getSigitTCompScxDao().customDeleterByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_scx", "codice_impianto="+idImpianto));
		SigitTCompXDto filter = new SigitTCompXDto();
		filter.setCodiceImpianto(codImpianto);
		filter.setIdTipoComponente(Constants.TIPO_COMPONENTE_SCX);
		getSigitTCompXDao().customDeleterByFilter(filter);
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+idImpianto+"&tipo_componente=SCX"));
		if(datiAltriComponentiSC !=null )
		{
			SezSC sezSC = datiAltriComponentiSC.getSezSC();
			if(sezSC!=null)
			{
				log.debug("Consolidamento scheda 9: SC");
				List<RowSCcal> rowSCList = sezSC.getRowSCcalList();
				if(rowSCList!=null)
					for (RowSCcal rowSC : rowSCList) {
						SigitTCompXDto compX = MapDto.getSigitTCompX(rowSC, codImpianto);
						if(compX !=null && compX.getDataInstall()!=null)
						{
							log.debug("Inserimento COMP SC");
							//salvataggio
							SigitTCompScxDto compSc = MapDto.getSigitTCompSCX(rowSC, codImpianto);
							compX.setUtenteUltMod(cfUtente);
							compX.setDataUltMod(DateUtil.getSqlDataCorrente());
							getSigitTCompXDao().insert(compX);
							getSigitTCompScxDao().insert(compSc);
						}
						it.csi.sigit.sigitwebn.xml.libretto.data.RowSCcalDocument.RowSCcal.SezSCsostituite sezRVsostituite = rowSC.getSezSCsostituite();
						if(sezRVsostituite!=null)
						{
							log.debug("Inserimento sezione sostituite");
							List<RowSCcalsost> rowSCsostList = sezRVsostituite.getRowSCcalsostList();
							if(rowSCsostList!=null)
								for (RowSCcalsost rowSCsost : rowSCsostList) {
									String progressivo = ConvertUtil.convertToString(rowSC.getL93NumSC());
									SigitTCompXDto xSostDto = MapDto.getSigitTCompX(rowSCsost, codImpianto, progressivo);
									SigitTCompScxDto xScDto = MapDto.getSigitTCompSCX(rowSCsost, codImpianto, progressivo);
									xSostDto.setUtenteUltMod(cfUtente);
									xSostDto.setDataUltMod(DateUtil.getSqlDataCorrente());
									getSigitTCompXDao().insert(xSostDto);
									getSigitTCompScxDao().insert(xScDto);
								}
						}
					}
			}
		}
	}

	public void consolidaCI(String idImpianto, String cfUtente, DatiAltriComponentiCI datiAltriComponentiCI) throws SigitTCompCiDaoException, SigitTCompXDaoException{
		BigDecimal codImpianto = new BigDecimal(idImpianto);
		getSigitTCompCiDao().customDeleterByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_ci", "codice_impianto="+idImpianto));
		SigitTCompXDto filter = new SigitTCompXDto();
		filter.setCodiceImpianto(codImpianto);
		filter.setIdTipoComponente(Constants.TIPO_COMPONENTE_CI);
		getSigitTCompXDao().customDeleterByFilter(filter);
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+idImpianto+"&tipo_componente=CI"));
		if(datiAltriComponentiCI !=null)
		{
			SezCI sezSC = datiAltriComponentiCI.getSezCI();
			if(sezSC!=null)
			{
				log.debug("Consolidamento scheda 9: CI");
				List<RowCI> rowCIList = sezSC.getRowCIList();
				if(rowCIList!=null)
					for (RowCI rowSC : rowCIList) {
						SigitTCompXDto compX = MapDto.getSigitTCompX(rowSC, codImpianto);
						if(compX !=null && compX.getDataInstall()!=null)
						{
							log.debug("Inserimento COMP CI");
							//salvataggio
							SigitTCompCiDto compCi = MapDto.getSigitTCompCI(rowSC, codImpianto);
							compX.setUtenteUltMod(cfUtente);
							compX.setDataUltMod(DateUtil.getSqlDataCorrente());
							getSigitTCompXDao().insert(compX);
							getSigitTCompCiDao().insert(compCi);
						}
						SezCIsostituite sezCIsostituite = rowSC.getSezCIsostituite();
						if(sezCIsostituite!=null)
						{
							log.debug("Inserimento sezione sostituite");
							List<RowCIsost> rowCIsostList = sezCIsostituite.getRowCIsostList();
							if(rowCIsostList!=null)
								for (RowCIsost rowCIsost : rowCIsostList) {
									String progressivo = ConvertUtil.convertToString(rowSC.getL94NumCI());
									SigitTCompXDto xSostDto = MapDto.getSigitTCompX(rowCIsost, codImpianto, progressivo);
									SigitTCompCiDto xCiDto = MapDto.getSigitTCompCI(rowCIsost, codImpianto, progressivo);
									xSostDto.setUtenteUltMod(cfUtente);
									xSostDto.setDataUltMod(DateUtil.getSqlDataCorrente());
									getSigitTCompXDao().insert(xSostDto);
									getSigitTCompCiDao().insert(xCiDto);
								}
						}
					}
			}
		}
	}

	public void consolidaUT(String idImpianto, String cfUtente, DatiAltriComponentiUT datiAltriComponentiUT) throws SigitTCompXDaoException, SigitTCompUtDaoException {
		BigDecimal codImpianto = new BigDecimal(idImpianto);
		getSigitTCompUtDao().customDeleterByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_ut", "codice_impianto="+idImpianto));
		SigitTCompXDto filter = new SigitTCompXDto();
		filter.setCodiceImpianto(codImpianto);
		filter.setIdTipoComponente(Constants.TIPO_COMPONENTE_UT);
		getSigitTCompXDao().customDeleterByFilter(filter);
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+idImpianto+"&tipo_componente=UT"));
		if(datiAltriComponentiUT !=null)
		{
			SezUT sezUT = datiAltriComponentiUT.getSezUT();
			if(sezUT!=null)
			{
				log.debug("Consolidamento scheda 9: UT");
				List<RowUT> rowUTList = sezUT.getRowUTList();
				if(rowUTList!=null)
					for (RowUT rowUT : rowUTList) {
						SigitTCompXDto compX = MapDto.getSigitTCompX(rowUT, codImpianto);
						if(compX !=null && compX.getDataInstall()!=null)
						{
							log.debug("Inserimento COMP UT");
							SigitTCompUtDto compUt = MapDto.getSigitTCompUT(rowUT, codImpianto);
							compX.setUtenteUltMod(cfUtente);
							compX.setDataUltMod(DateUtil.getSqlDataCorrente());
							getSigitTCompXDao().insert(compX);
							getSigitTCompUtDao().insert(compUt);
						}
						SezUTsostituite sezUTsostituite = rowUT.getSezUTsostituite();
						if(sezUTsostituite!=null)
						{
							log.debug("Inserimento sezione sostituite");
							List<RowUTsost> rowCIsostList = sezUTsostituite.getRowUTsostList();
							if(rowCIsostList!=null)
								for (RowUTsost rowUTsost : rowCIsostList) {
									String progressivo = ConvertUtil.convertToString(rowUT.getL95NumUT());
									SigitTCompXDto xSostDto = MapDto.getSigitTCompX(rowUTsost, codImpianto, progressivo);
									SigitTCompUtDto xUtDto = MapDto.getSigitTCompUT(rowUTsost, codImpianto, progressivo);
									xSostDto.setUtenteUltMod(cfUtente);
									xSostDto.setDataUltMod(DateUtil.getSqlDataCorrente());
									getSigitTCompXDao().insert(xSostDto);
									getSigitTCompUtDao().insert(xUtDto);
								}
						}
					}
			}
		}
	}

	public void consolidaRC(String idImpianto, String cfUtente, DatiAltriComponentiRC datiAltriComponentiRC) throws SigitTCompXDaoException, SigitTCompRcDaoException {
		BigDecimal codImpianto = new BigDecimal(idImpianto);
		getSigitTCompRcDao().customDeleterByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_rc", "codice_impianto="+idImpianto));
		SigitTCompXDto filter = new SigitTCompXDto();
		filter.setCodiceImpianto(codImpianto);
		filter.setIdTipoComponente(Constants.TIPO_COMPONENTE_RCX);
		getSigitTCompXDao().customDeleterByFilter(filter);
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+idImpianto+"&tipo_componente=RC"));
		if(datiAltriComponentiRC !=null)
		{
			SezRC sezUT = datiAltriComponentiRC.getSezRC();
			if(sezUT!=null)
			{
				log.debug("Consolidamento scheda 9: RC");
				List<RowRCcal> rowRCList = sezUT.getRowRCcalList();
				if(rowRCList!=null)
					for (RowRCcal rowRC : rowRCList) {
						SigitTCompXDto compX = MapDto.getSigitTCompX(rowRC, codImpianto);
						if(compX !=null && compX.getDataInstall()!=null)
						{
							log.debug("Inserimento COMP RC");
							SigitTCompRcDto compRc = MapDto.getSigitTCompRC(rowRC, codImpianto);
							compX.setUtenteUltMod(cfUtente);
							compX.setDataUltMod(DateUtil.getSqlDataCorrente());
							getSigitTCompXDao().insert(compX);
							getSigitTCompRcDao().insert(compRc);
						}
						it.csi.sigit.sigitwebn.xml.libretto.data.RowRCcalDocument.RowRCcal.SezRCsostituite sezRcsostituite = rowRC.getSezRCsostituite();
						if(sezRcsostituite!=null)
						{
							log.debug("Inserimento sezione sostituite");
							List<RowRCcalsost> rowRCsostList = sezRcsostituite.getRowRCcalsostList();
							if(rowRCsostList!=null)
								for (RowRCcalsost rowRCsost : rowRCsostList) {
									String progressivo = ConvertUtil.convertToString(rowRC.getL96NumRC());
									SigitTCompXDto xSostDto = MapDto.getSigitTCompX(rowRCsost, codImpianto, progressivo);
									SigitTCompRcDto xRcDto = MapDto.getSigitTCompRC(rowRCsost, codImpianto, progressivo);
									xSostDto.setUtenteUltMod(cfUtente);
									xSostDto.setDataUltMod(DateUtil.getSqlDataCorrente());
									getSigitTCompXDao().insert(xSostDto);
									getSigitTCompRcDao().insert(xRcDto);
								}
						}
					}
			}
		}
	}

	public void consolidaVM(String idImpianto, String cfUtente, DatiVentilazMeccanicaVM datiVentilazMeccanicaVM) throws SigitTCompXDaoException, SigitTCompVmDaoException {
		BigDecimal codImpianto = new BigDecimal(idImpianto);
		getSigitTCompVmDao().customDeleterByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_vm", "codice_impianto="+idImpianto));
		SigitTCompXDto filter = new SigitTCompXDto();
		filter.setCodiceImpianto(codImpianto);
		filter.setIdTipoComponente(Constants.TIPO_COMPONENTE_VM);
		getSigitTCompXDao().customDeleterByFilter(filter);
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+idImpianto+"&tipo_componente=VM"));
		if(datiVentilazMeccanicaVM !=null)
		{
			SezVM sezVM = datiVentilazMeccanicaVM.getSezVM();
			if(sezVM!=null)
			{
				log.debug("Consolidamento scheda 10: VM");
				List<RowVM> rowVMList = sezVM.getRowVMList();
				if(rowVMList!=null)
					for (RowVM rowVM : rowVMList) {
						SigitTCompXDto compX = MapDto.getSigitTCompX(rowVM, codImpianto);
						if(compX !=null && compX.getDataInstall()!=null)
						{
							log.debug("Inserimento COMP VM");
							SigitTCompVmDto compVm = MapDto.getSigitTCompVM(rowVM, codImpianto);
							compX.setUtenteUltMod(cfUtente);
							compX.setDataUltMod(DateUtil.getSqlDataCorrente());
							getSigitTCompXDao().insert(compX);
							getSigitTCompVmDao().insert(compVm);
						}
						SezVMsostituite sezVmSostituite = rowVM.getSezVMsostituite();
						if(sezVmSostituite!=null)
						{
							log.debug("Inserimento sezione sostituite");
							List<RowVMsost> rowVMsostList = sezVmSostituite.getRowVMsostList();
							if(rowVMsostList!=null)
								for (RowVMsost rowVMsost : rowVMsostList) {
									String progressivo = ConvertUtil.convertToString(rowVM.getL101NumVM());
									SigitTCompXDto xSostDto = MapDto.getSigitTCompX(rowVMsost, codImpianto, progressivo);
									SigitTCompVmDto xVmDto = MapDto.getSigitTCompVM(rowVMsost, codImpianto, progressivo);
									xSostDto.setUtenteUltMod(cfUtente);
									xSostDto.setDataUltMod(DateUtil.getSqlDataCorrente());
									getSigitTCompXDao().insert(xSostDto);
									getSigitTCompVmDao().insert(xVmDto);
								}
						}
					}
			}
		}
	}

	public void consolidaConsumoCombustibile(String idImpianto, String cfUtente, DatiConsumoCombu datiConsumoCombu) throws SigitTConsumoDaoException {
		log.debug("consolidaConsumoCombustibile - START");
		BigDecimal codImpianto = new BigDecimal(idImpianto);
		getSigitTConsumoDao().customDeleterCombuByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_consumo", "codice_impianto="+idImpianto+"&tipo_consumo=14.1(CB)"));
		if(datiConsumoCombu !=null)
		{
			SezCombu sezCombu = datiConsumoCombu.getSezCombu();
			if(sezCombu!=null)
			{
				log.debug("Consolidamento scheda 14.1 : combustibile");
				List<RowCombu> rowCombuList = sezCombu.getRowCombuList();
				if(rowCombuList!=null)
					for (RowCombu rowCombu : rowCombuList) {
						BigDecimal tipoCombustibile = null;

						//DA SALVARE ANCHE TIPO COMBUSTIBILE E' NULL

						try{tipoCombustibile = ConvertUtil.convertToBigDecimal(rowCombu.getL141TipoCombu());}catch(Exception e){}

							List<RowConsumo> rowConsumoList = rowCombu.getSezRowConsumo().getRowConsumoList();
							if(rowConsumoList!=null)
							for (RowConsumo rowConsumo : rowConsumoList) {
								String unitaMisura = rowCombu.getL141UnitaMisura();
								if(GenericUtil.isNullOrEmpty(unitaMisura))
									unitaMisura = null;

									SigitTConsumoDto dto = MapDto.getSigitTConsumo(rowConsumo, codImpianto, tipoCombustibile, unitaMisura);

									if (dto != null)
									{
										log.debug("Inserimento CONSUMO CB");
										getSigitTConsumoDao().insert(dto);
									}
							}


						/*
						if(tipoCombustibile!=null)
						{
							List<RowConsumo> rowConsumoList = rowCombu.getSezRowConsumo().getRowConsumoList();
							if(rowConsumoList!=null)
							for (RowConsumo rowConsumo : rowConsumoList) {
								String unitaMisura = rowCombu.getL141UnitaMisura();
								if(GenericUtil.isNullOrEmpty(unitaMisura))
									unitaMisura = null;
								SigitTConsumoDto dto = MapDto.getSigitTConsumo(rowConsumo, codImpianto, tipoCombustibile, unitaMisura);
								log.debug("Inserimento CONSUMO CB");
								getSigitTConsumoDao().insert(dto);
							}
						}
						*/


					}
			}
		}
		log.debug("consolidaConsumoCombustibile - END");
	}

	public void consolidaConsumoCombustibileLight(String idImpianto, String cfUtente, it.csi.sigit.sigitwebn.xml.librettoLight.data.DatiConsumoCombuDocument.DatiConsumoCombu datiConsumoCombu) throws SigitTConsumoDaoException {
		log.debug("consolidaConsumoCombustibile - START");
		BigDecimal codImpianto = new BigDecimal(idImpianto);
		getSigitTConsumoDao().customDeleterCombuByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_consumo", "codice_impianto="+idImpianto+"&tipo_consumo=14.1(CB)"));
		if(datiConsumoCombu !=null)
		{
			it.csi.sigit.sigitwebn.xml.librettoLight.data.DatiConsumoCombuDocument.DatiConsumoCombu.SezCombu sezCombu = datiConsumoCombu.getSezCombu();
			if(sezCombu!=null)
			{
				log.debug("Consolidamento scheda 14.1 : combustibile");
				List<it.csi.sigit.sigitwebn.xml.librettoLight.data.RowCombuDocument.RowCombu> rowCombuList = sezCombu.getRowCombuList();
				if(rowCombuList!=null)
					for (it.csi.sigit.sigitwebn.xml.librettoLight.data.RowCombuDocument.RowCombu rowCombu : rowCombuList) {
						BigDecimal tipoCombustibile = null;
						try{tipoCombustibile = ConvertUtil.convertToBigDecimal(rowCombu.getL141TipoCombu());}catch(Exception e){}
//						if(tipoCombustibile!=null)
//						{
							List<it.csi.sigit.sigitwebn.xml.librettoLight.data.RowConsumoDocument.RowConsumo> rowConsumoList = rowCombu.getSezRowConsumo().getRowConsumoList();
							if(rowConsumoList!=null)
								for (it.csi.sigit.sigitwebn.xml.librettoLight.data.RowConsumoDocument.RowConsumo rowConsumo : rowConsumoList) {
									String unitaMisura = rowCombu.getL141UnitaMisura();
									if(GenericUtil.isNullOrEmpty(unitaMisura))
										unitaMisura = null;

									SigitTConsumoDto dto = MapDto.getSigitTConsumo(rowConsumo, codImpianto, tipoCombustibile, unitaMisura);
									if (dto != null)
									{
										log.debug("Inserimento CONSUMO CB");
										getSigitTConsumoDao().insert(dto);
									}
								}
						//}
					}
			}
			else
				log.debug("nessuna riga da inserire");
		}
		log.debug("consolidaConsumoCombustibile - END");
	}

	public void consolidaConsumoEnergia(String idImpianto, String cfUtente, DatiConsumoEE datiConsumoEE) throws SigitTConsumoDaoException {
		log.debug("consolidaConsumoEnergia : START");
		BigDecimal codImpianto = new BigDecimal(idImpianto);
		getSigitTConsumoDao().customDeleterEnergiaByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_consumo", "codice_impianto="+idImpianto+"&tipo_consumo=14.2(EE)"));
		if(datiConsumoEE !=null)
		{
			SezConsumo sezEE = datiConsumoEE.getSezConsumo();
			if(sezEE!=null)
			{
				log.debug("Consolidamento scheda 14.2 : energia elettrica");
				List<RowConsumoEE> rowEnergiaList = sezEE.getRowConsumoEEList();
				if(rowEnergiaList!=null)
					for (RowConsumoEE rowEE : rowEnergiaList) {
						SigitTConsumoDto dto = MapDto.getSigitTConsumo(rowEE, codImpianto);
						if(GenericUtil.isNotNullOrEmpty(dto.getEsercizioDa()) || GenericUtil.isNotNullOrEmpty(dto.getEsercizioA())
								|| GenericUtil.isNotNullOrEmpty(dto.getConsumo())
								|| GenericUtil.isNotNullOrEmpty(dto.getLetturaFinale())
								|| GenericUtil.isNotNullOrEmpty(dto.getLetturaIniziale()))
						{
							log.debug("Inserimento CONSUMO EE");
							getSigitTConsumoDao().insert(dto);
						}
					}
			}
		}
		log.debug("consolidaConsumoEnergia : END");
	}

	public void consolidaConsumoEnergiaLight(String idImpianto, String cfUtente, it.csi.sigit.sigitwebn.xml.librettoLight.data.DatiConsumoEEDocument.DatiConsumoEE datiConsumoEE) throws SigitTConsumoDaoException {
		BigDecimal codImpianto = new BigDecimal(idImpianto);
		getSigitTConsumoDao().customDeleterEnergiaByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_consumo", "codice_impianto="+idImpianto+"&tipo_consumo=14.2(EE)"));
		if(datiConsumoEE !=null)
		{
			it.csi.sigit.sigitwebn.xml.librettoLight.data.DatiConsumoEEDocument.DatiConsumoEE.SezConsumo sezEE = datiConsumoEE.getSezConsumo();
			if(sezEE!=null)
			{
				log.debug("Consolidamento scheda 14.2 : energia elettrica");
				List<it.csi.sigit.sigitwebn.xml.librettoLight.data.RowConsumoEEDocument.RowConsumoEE> rowEnergiaList = sezEE.getRowConsumoEEList();
				if(rowEnergiaList!=null)
					for (it.csi.sigit.sigitwebn.xml.librettoLight.data.RowConsumoEEDocument.RowConsumoEE rowEE : rowEnergiaList) {
						SigitTConsumoDto dto = MapDto.getSigitTConsumo(rowEE, codImpianto);
						if(GenericUtil.isNotNullOrEmpty(dto.getEsercizioDa()) || GenericUtil.isNotNullOrEmpty(dto.getEsercizioA())
								|| GenericUtil.isNotNullOrEmpty(dto.getConsumo())
								|| GenericUtil.isNotNullOrEmpty(dto.getLetturaFinale())
								|| GenericUtil.isNotNullOrEmpty(dto.getLetturaIniziale()))
						{
							log.debug("Inserimento CONSUMO EE light");
							getSigitTConsumoDao().insert(dto);
						}
					}
			}
		}
	}

	public void consolidaConsumoH2O(String idImpianto, String cfUtente, DatiConsumoH2O datiConsumoH2O) throws SigitTConsumoDaoException {
		BigDecimal codImpianto = new BigDecimal(idImpianto);
		getSigitTConsumoDao().customDeleterAcquaByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_consumo", "codice_impianto="+idImpianto+"&tipo_consumo=14.3(H2O)"));
		if(datiConsumoH2O !=null)
		{
			String unitaMisura = datiConsumoH2O.getL143UnitaMisura();
			if(GenericUtil.isNullOrEmpty(unitaMisura))
				unitaMisura = null;
			it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoH2ODocument.DatiConsumoH2O.SezConsumo sezH2O = datiConsumoH2O.getSezConsumo();
			if(sezH2O!=null)
			{
				log.debug("Consolidamento scheda 14.3 : acqua");
				List<RowConsumoH2O> rowH2OList = sezH2O.getRowConsumoH2OList();
				if(rowH2OList!=null)
					for (RowConsumoH2O rowH2O : rowH2OList) {
						SigitTConsumoDto dto = MapDto.getSigitTConsumo(rowH2O, codImpianto, unitaMisura);
						if(GenericUtil.isNotNullOrEmpty(dto.getEsercizioDa()) || GenericUtil.isNotNullOrEmpty(dto.getEsercizioA())
								|| GenericUtil.isNotNullOrEmpty(dto.getConsumo())
								|| GenericUtil.isNotNullOrEmpty(dto.getLetturaFinale())
								|| GenericUtil.isNotNullOrEmpty(dto.getLetturaIniziale()))
						{
							log.debug("Inserimento CONSUMO H2O");
							getSigitTConsumoDao().insert(dto);
						}
					}
			}
		}
	}

	public void consolidaConsumoH2OLight(String idImpianto, String cfUtente, it.csi.sigit.sigitwebn.xml.librettoLight.data.DatiConsumoH2ODocument.DatiConsumoH2O datiConsumoH2O) throws SigitTConsumoDaoException {
		BigDecimal codImpianto = new BigDecimal(idImpianto);
		getSigitTConsumoDao().customDeleterAcquaByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_consumo", "codice_impianto="+idImpianto+"&tipo_consumo=14.3(H2O)"));
		if(datiConsumoH2O !=null)
		{
			String unitaMisura = datiConsumoH2O.getL143UnitaMisura();
			if(GenericUtil.isNullOrEmpty(unitaMisura))
				unitaMisura = null;
			it.csi.sigit.sigitwebn.xml.librettoLight.data.DatiConsumoH2ODocument.DatiConsumoH2O.SezConsumo sezH2O = datiConsumoH2O.getSezConsumo();
			if(sezH2O!=null)
			{
				log.debug("Consolidamento scheda 14.3 : acqua");
				List<it.csi.sigit.sigitwebn.xml.librettoLight.data.RowConsumoH2ODocument.RowConsumoH2O> rowH2OList = sezH2O.getRowConsumoH2OList();
				if(rowH2OList!=null)
					for (it.csi.sigit.sigitwebn.xml.librettoLight.data.RowConsumoH2ODocument.RowConsumoH2O rowH2O : rowH2OList) {
						SigitTConsumoDto dto = MapDto.getSigitTConsumo(rowH2O, codImpianto, unitaMisura);
						if(GenericUtil.isNotNullOrEmpty(dto.getEsercizioDa()) || GenericUtil.isNotNullOrEmpty(dto.getEsercizioA())
								|| GenericUtil.isNotNullOrEmpty(dto.getConsumo())
								|| GenericUtil.isNotNullOrEmpty(dto.getLetturaFinale())
								|| GenericUtil.isNotNullOrEmpty(dto.getLetturaIniziale()))
						{
							log.debug("Inserimento CONSUMO H2O");
							getSigitTConsumoDao().insert(dto);
						}
					}
			}
		}
	}

	public void consolidaConsumoProdottiChimici(String idImpianto, String cfUtente, DatiConsumoProdottiChimici datiConsumoProdottiChimici) throws SigitTConsumo14_4DaoException {
		BigDecimal codImpianto = new BigDecimal(idImpianto);
		getSigitTConsumo144Dao().customDeleterByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_consumo_14_4", "codice_impianto="+idImpianto));
		if(datiConsumoProdottiChimici !=null)
		{
			it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoProdottiChimiciDocument.DatiConsumoProdottiChimici.SezConsumo sezPC = datiConsumoProdottiChimici.getSezConsumo();
			if(sezPC!=null)
			{
				log.debug("Consolidamento scheda 14.4 : prodotti chimici");
				List<RowConsumoPROD> rowPCList = sezPC.getRowConsumoPRODList();
				if(rowPCList!=null)
					for (RowConsumoPROD rowPC : rowPCList) {
						SigitTConsumo14_4Dto dto = MapDto.getSigitTConsumo144(rowPC, codImpianto, cfUtente);
						if(GenericUtil.isNotNullOrEmpty(dto.getEsercizioDa()) ||
								GenericUtil.isNotNullOrEmpty(dto.getEsercizioA())
								|| GenericUtil.isNotNullOrEmpty(dto.getNomeProdotto())
								|| GenericUtil.isNotNullOrEmpty(dto.getQtaConsumata())
								|| GenericUtil.isNotNullOrEmpty(dto.getFlgAca())
								|| GenericUtil.isNotNullOrEmpty(dto.getFlgCircuitoAcs())
								|| GenericUtil.isNotNullOrEmpty(dto.getFlgCircuitoIt()))
						{
							log.debug("Inserimento CONSUMO prod chimici");
							getSigitTConsumo144Dao().insert(dto);
						}
					}
			}
		}
	}

	public void consolidaConsumoProdottiChimiciLight(String idImpianto, String cfUtente, it.csi.sigit.sigitwebn.xml.librettoLight.data.DatiConsumoProdottiChimiciDocument.DatiConsumoProdottiChimici datiConsumoProdottiChimici) throws SigitTConsumo14_4DaoException {
		BigDecimal codImpianto = new BigDecimal(idImpianto);
		getSigitTConsumo144Dao().customDeleterByCodImpianto(codImpianto.intValue());
		getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_consumo_14_4", "codice_impianto="+idImpianto));
		if(datiConsumoProdottiChimici !=null)
		{
			it.csi.sigit.sigitwebn.xml.librettoLight.data.DatiConsumoProdottiChimiciDocument.DatiConsumoProdottiChimici.SezConsumo sezPC = datiConsumoProdottiChimici.getSezConsumo();
			if(sezPC!=null)
			{
				log.debug("Consolidamento scheda 14.4 : prodotti chimici");
				List<it.csi.sigit.sigitwebn.xml.librettoLight.data.RowConsumoPRODDocument.RowConsumoPROD> rowPCList = sezPC.getRowConsumoPRODList();
				if(rowPCList!=null)
					for (it.csi.sigit.sigitwebn.xml.librettoLight.data.RowConsumoPRODDocument.RowConsumoPROD rowPC : rowPCList) {
						SigitTConsumo14_4Dto dto = MapDto.getSigitTConsumo144(rowPC, codImpianto, cfUtente);
						if(GenericUtil.isNotNullOrEmpty(dto.getEsercizioDa()) ||
								GenericUtil.isNotNullOrEmpty(dto.getEsercizioA())
								|| GenericUtil.isNotNullOrEmpty(dto.getNomeProdotto())
								|| GenericUtil.isNotNullOrEmpty(dto.getQtaConsumata())
								|| GenericUtil.isNotNullOrEmpty(dto.getFlgAca())
								|| GenericUtil.isNotNullOrEmpty(dto.getFlgCircuitoAcs())
								|| GenericUtil.isNotNullOrEmpty(dto.getFlgCircuitoIt()))
						{
							log.debug("Inserimento CONSUMO prod chimici");
							getSigitTConsumo144Dao().insert(dto);
						}
					}
			}
		}
	}


	public List<SigitExtComponenteDto> findComponentiByFilter(CompFilter filter, int idTipoDoc) throws DbManagerException
	{
		String nomeTabellaComp = null;
		List<SigitExtComponenteDto> listApparecchiatureDto = null;

		try
		{
			if (idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_1) ||
				idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_1B) ||
				idTipoDoc == ConvertUtil.convertToInteger(Constants.RAPP_PROVA_ALLEGATO_TIPO_1))
			{
				nomeTabellaComp = "SIGIT_T_COMP_GT";
			}
			else if (idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_2) || idTipoDoc == ConvertUtil.convertToInteger(Constants.RAPP_PROVA_ALLEGATO_TIPO_2))
			{
				nomeTabellaComp = "SIGIT_T_COMP_GF";
			}
			else if (idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_3))
			{
				nomeTabellaComp = "SIGIT_T_COMP_SC";
			}
			else if (idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_4))
			{
				nomeTabellaComp = "SIGIT_T_COMP_CG";
			}

			listApparecchiatureDto = getSigitExtDao().findComponentiByFilter(filter, nomeTabellaComp);
		}
		catch (SigitExtDaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		return listApparecchiatureDto;
	}

	public List<SigitExtComponenteDto> findComponentiSubentroByFilter(CompFilter filter, int idTipoRuolo) throws DbManagerException
	{
		String nomeTabellaComp = null;
		List<SigitExtComponenteDto> listApparecchiatureDto = null;

		try
		{
			if (idTipoRuolo == Constants.ID_RUOLO_MANUTENTORE_ALL_1)
			{
				nomeTabellaComp = "SIGIT_T_COMP_GT";
			}
			else if (idTipoRuolo == Constants.ID_RUOLO_MANUTENTORE_ALL_2)
			{
				nomeTabellaComp = "SIGIT_T_COMP_GF";
			}
			else if (idTipoRuolo == Constants.ID_RUOLO_MANUTENTORE_ALL_3)
			{
				nomeTabellaComp = "SIGIT_T_COMP_SC";
			}
			else if (idTipoRuolo == Constants.ID_RUOLO_MANUTENTORE_ALL_4)
			{
				nomeTabellaComp = "SIGIT_T_COMP_CG";
			}

			listApparecchiatureDto = getSigitExtDao().findComponentiSubentroByFilter(filter, nomeTabellaComp);
		}
		catch (SigitExtDaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		return listApparecchiatureDto;
	}

	public List<SigitVRicercaCompComponentiByFilterDto> findComponentiTerzoResponsabileByFilter(CompFilter filter) throws DbManagerException
	{
		List<SigitVRicercaCompComponentiByFilterDto> listApparecchiatureDto = null;

		try
		{
			listApparecchiatureDto = getSigitVRicercaCompDao().findComponentiByFilter(filter);
		}
		catch (SigitVRicercaCompDaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		return listApparecchiatureDto;
	}

	public List<SigitVCompGtDettDto> getCompGtDett(Integer codImpiantoInt) throws SigitVCompGtDettDaoException
	{
		return getSigitVCompGtDettDao().findByCodImpiantoOrdered(codImpiantoInt);
	}

	public List<SigitVSk4GtDto> getCompSk4Gt(Integer codImpiantoInt) throws SigitVSk4GtDaoException
	{
		return getSigitVSk4GtDao().findByCodImpiantoOrdered(codImpiantoInt);
	}

	public List<SigitVCompGfDettDto> getCompGfDett(Integer codImpiantoInt) throws SigitVCompGfDettDaoException
	{
		return getSigitVCompGfDettDao().findByCodImpiantoOrdered(codImpiantoInt);
	}

	public List<SigitVSk4GfDto> getCompSk4Gf(Integer codImpiantoInt) throws SigitVSk4GfDaoException
	{
		return getSigitVSk4GfDao().findByCodImpiantoOrdered(codImpiantoInt);
	}

	public List<SigitVCompScDettDto> getCompScDett(Integer codImpiantoInt) throws SigitVCompScDettDaoException
	{
		return getSigitVCompScDettDao().findByCodImpiantoOrdered(codImpiantoInt);
	}

	public List<SigitVSk4ScDto> getCompSk4Sc(Integer codImpiantoInt) throws SigitVSk4ScDaoException
	{
		return getSigitVSk4ScDao().findByCodImpiantoOrdered(codImpiantoInt);
	}

	public List<SigitVCompCgDettDto> getCompCgDett(Integer codImpiantoInt) throws SigitVCompCgDettDaoException
	{
		return getSigitVCompCgDettDao().findByCodImpiantoOrdered(codImpiantoInt);
	}

	public List<SigitVSk4CgDto> getCompSk4Cg(Integer codImpiantoInt) throws SigitVSk4CgDaoException
	{
		return getSigitVSk4CgDao().findByCodImpiantoOrdered(codImpiantoInt);
	}

	/*
	public SigitTContrattoDto inserisciNuovoContratto(TerzoResponsabile resp, UtenteLoggato utente)
	{
		log.debug("[DbMgr::inserisciNuovoContratto] START");
		try{
			SigitTContrattoDto dto = MapDto.mapToSigitTContrattoDto(resp);
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());
			dto.setUtenteUltMod(utente.getCodiceFiscale());
			getSigitTContrattoDao().insert(dto);
			return dto;
		}
		finally {
			log.debug("[DbMgr::inserisciNuovoContratto] END");
		}
	}
	*/

	public SigitTContratto2019Dto inserisciNuovoContratto2019(TerzoResponsabile resp, UtenteLoggato utente) throws DbManagerException
	{
		log.debug("[DbMgr::inserisciNuovoContratto2019] START");
		try{
			//recupero fk_imp_ruolo_pfpg_resp (recuperare il dato dal responsabile attivo sull'impianto (ruolo='RESPONSABILE' o 'RESPONSABILE IMPRESA') alla data di inizio del contratto
			RicercaImpiantiSoggettoFilter filter = new RicercaImpiantiSoggettoFilter();
			filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(
					ReplaceSpecialCharUtils.sanitize(resp.getImpCodImpianto())));
			filter.setDataInizio(ConvertUtil.convertToSqlDate(resp.getDataInizioContratto()));
			filter.setListaRuoliInclusi(Arrays.asList("'"+Constants.RUOLO_RESPONSABILE+"'", "'"+Constants.RUOLO_RESPONSABILE_IMPRESA+"'"));

			List<SigitRImpRuoloPfpgGenericByFilterDto> listaImpRuolo = getSigitRImpRuoloPfpgDao().findGenericByFilter(filter);

			SigitTContratto2019Dto dto = MapDto.mapToSigitTContratto2019Dto(resp, listaImpRuolo!= null && listaImpRuolo.size() > 0 ? listaImpRuolo.get(0).getIdImpRuoloPgPf() : null);
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());
			dto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(utente.getCodiceFiscale()));
			dto.setDataCaricamento(DateUtil.getSqlDataCorrente());
			dto.setFkTipoCessazione(0);
			getSigitTContratto2019Dao().insert(dto);
			return dto;
		} catch (SigitRImpRuoloPfpgDaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciNuovoContratto2019] END");
		}
	}

	public void modificaContratto2019PerRevoca (Integer idContratto, Integer idTipoCessazioneSelezionata, String dataRevoca, String motivoCessazione, String codiceFiscaleUtente) throws DbManagerException {
		log.debug("[DbMgr::modificaContratto2019PerRevoca] START");
		try {
			SigitTContratto2019Dto contrattoDaPersistere = new SigitTContratto2019Dto();
			contrattoDaPersistere.setIdContratto(ConvertUtil.convertToBigDecimal(idContratto));
			contrattoDaPersistere.setDataCessazione(ConvertUtil.convertToSqlDate(dataRevoca));
			contrattoDaPersistere.setMotivoCessazione(motivoCessazione);
			contrattoDaPersistere.setDataInserimentoCessazione(DateUtil.getSqlDataCorrente());
			contrattoDaPersistere.setFkTipoCessazione(idTipoCessazioneSelezionata);
			contrattoDaPersistere.setUtenteUltMod(codiceFiscaleUtente);
			contrattoDaPersistere.setDataUltMod(DateUtil.getSqlDataCorrente());

			getSigitTContratto2019Dao().updateColumnsPerRevoca(contrattoDaPersistere);
		} catch (SigitTContratto2019DaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::modificaContratto2019PerRevoca] END");
		}



	}

	public void inserisciAutodichiarazioni3Resp(BigDecimal idContratto, List<Integer> elencoAutodichiarazioni, String tipoAutodichiarazione) throws DbManagerException {
		log.debug("[DbMgr::inserisciAutodichiarazioni3Resp] START");
		try{
			SigitRContr2019AutodichiarDto dto = null;

			for (Integer autodichiarazione : elencoAutodichiarazioni) {
				dto = new SigitRContr2019AutodichiarDto();

				dto.setIdContratto(ConvertUtil.convertToInteger(idContratto));
				dto.setIdAutodichiarazione(autodichiarazione);
				dto.setFlgNominaCessa(tipoAutodichiarazione); //N per la nomina - C per la cessazione

				getSigitRContr2019AutodichiarDao().insert(dto);
			}

		} catch (Exception e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciAutodichiarazioni3Resp] END");
		}
	}

	/*
	public SigitTContrattoDto cercaContrattoByCodImpTipoProgr(String codiceImpianto, String tipoComponente, BigDecimal progressivo) throws DbManagerException
	{
		log.debug("[DbMgr::cercaContrattoByCodImpTipoProgr] START");

		ContrattoFilter filter = new ContrattoFilter();
		filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
		filter.setIdTipoComponente(tipoComponente);
		filter.setComponente(ConvertUtil.convertToString(progressivo));

		try
		{
			List<SigitTContrattoDto> listCont = getSigitTContrattoDao().findByCodImpTipoProgr(filter);
			if(listCont != null && !listCont.isEmpty()){
				return listCont.get(0);
			}
			else return null;

		} catch (SigitTContrattoDaoException e)
		{
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::cercaContrattoByCodImpTipoProgr] END");
		}
	}
	*/

	public void verificaBRRCByGT (String codiceImpiantoGT, String dataInstallazioneGT, String progressivoGT) throws DbManagerException {
		log.debug("[DbMgr::verificaBRRCByGT] START");
		List<SigitTCompBrRcDto> listaDtos = cercaCompBRRCByGT(codiceImpiantoGT, progressivoGT, dataInstallazioneGT);

		if (listaDtos != null && listaDtos.size()>0) {
			throw new DbManagerException(new Message( Messages.S224_2,  Message.ERROR));
		}

	}



	public List<SigitTmpLibrettoDto> getLibrettiBozzaDaElaborare() throws ManagerException
	{
		log.debug("[DbMgr::getLibrettiBozzaDaElaborare] START");
		try
		{
			return getSigitTmpLibrettoDao().findDaElaborare(null);
		} catch (SigitTmpLibrettoDaoException e) {
			log.error("Errore: ",e);
			throw new ManagerException(new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::getLibrettiBozzaDaElaborare] END");
		}

	}

	public void salvaInfoLibrettoElaborato(SigitTmpLibrettoDto dto) throws ManagerException
	{
		log.debug("[DbMgr::salvaInfoLibrettoElaborato] START");
		try
		{
			getSigitTmpLibrettoDao().update(dto);
		} catch (SigitTmpLibrettoDaoException e) {
			log.error("Errore: ",e);
			throw new ManagerException(new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::salvaInfoLibrettoElaborato] END");
		}
	}

	/*
	public List<SigitVTotImpiantoDto> cercaAttiviAllDataByRuolo(ImpiantoFilter filter) throws DbManagerException
	{
		log.debug("[DbMgr::cercaAttiviAllDataByRuolo] START");
		try
		{
			return getSigitVTotImpiantoDao().findAttivoAllaDataByFilter(filter);
		} catch (SigitVTotImpiantoDaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::cercaAttiviAllDataByRuolo] END");
		}

	}
	*/

	public List<SigitRComp4ManutDto> cercaAttualiByRuolo(String codiceImpianto, BigDecimal idPersonaGiuridica, Integer idRuolo) throws DbManagerException
	{
		log.debug("[DbMgr::cercaAttualiByRuolo] START");
		try
		{

			CompFilter filter = new CompFilter();
			filter.setCodImpianto(codiceImpianto);
			filter.setIdPG(ConvertUtil.convertToInteger(idPersonaGiuridica));
			filter.setIdRuolo(idRuolo);

			return getSigitRComp4ManutDao().findByPersonaGiuridicaCodImpianto(filter);

			/*
			SigitRImpRuoloPfpgDto filter = new SigitRImpRuoloPfpgDto();
			filter.setCodiceImpianto(new BigDecimal(codiceImpianto));
			filter.setFkPersonaGiuridica(idPersonaGiuridica);
			filter.setFkRuolo(ConvertUtil.convertToBigDecimal(idRuolo));

			return getSigitRImpRuoloPfpgDao().findByPersonaGiuridicaCodImpianto(filter);
			*/

		} catch (SigitRComp4ManutDaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::cercaAttualiByRuolo] END");
		}

	}

	public List<SigitRComp4ManutDto> cercaAttualiByRuolo(String codiceImpianto, BigDecimal idPersonaGiuridica, Integer idRuolo, ArrayList<String> progressivi) throws DbManagerException
	{
		log.debug("[DbMgr::cercaAttualiByRuolo] START");
		try
		{

			CompFilter filter = new CompFilter();
			filter.setCodImpianto(codiceImpianto);
			filter.setIdPG(ConvertUtil.convertToInteger(idPersonaGiuridica));
			filter.setIdRuolo(idRuolo);
			filter.setListProgressivi(progressivi);

			return getSigitRComp4ManutDao().findByPersonaGiuridicaCodImpianto(filter);



		} catch (SigitRComp4ManutDaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::cercaAttualiByRuolo] END");
		}

	}


	public void inserisciPreImport(SigitTPreImportDto dto) throws DbManagerException
	{
		log.debug("[SigitMgr:::gestPreImport] START");
		try{
			getSigitTPreImportDao().insert(dto);
		} catch (Exception e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_INSERT_DB));
		}
		finally
		{
			log.debug("[SigitMgr:::gestPreImport] END");
		}
	}

	public void aggiornaPreImport(SigitTPreImportDto dto) throws DbManagerException
	{
		log.debug("[SigitMgr:::aggiornaPreImport] START");
		try{
			getSigitTPreImportDao().update(dto);
		} catch (Exception e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_UPDATE_DB));
		}
		finally
		{
			log.debug("[SigitMgr:::aggiornaPreImport] END");
		}
	}

	public void insertImportLibretto(BigDecimal codImpianto, String xml, String cfUtente) throws DbManagerException
	{
		log.debug("[SigitMgr:::insertImportLibretto] START");
		try{


			SigitTImportXmlLibDto dto = new SigitTImportXmlLibDto();

			dto.setCodiceImpianto(codImpianto);
			dto.setXmlLibretto(xml);
			dto.setDataUltMod(DateUtil.getSqlCurrentDate());
			dto.setUtenteUltMod(cfUtente);

			SigitTImportXmlLibDto dtoOld = getSigitTImportXmlLibDao().findByPrimaryKey(new SigitTImportXmlLibPk(codImpianto));
			if (dtoOld == null)
			{
				getSigitTImportXmlLibDao().insert(dto);
			}
			else
			{
				getSigitTImportXmlLibDao().update(dto);
			}
		} catch (Exception e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_INSERT_DB));
		}
		finally
		{
			log.debug("[SigitMgr:::insertImportLibretto] END");
		}
	}

	public void deleteImportLibretto(String codImpianto) throws DbManagerException
	{
		log.debug("[SigitMgr:::deleteImportLibretto] START");
		try{

			getSigitTImportXmlLibDao().delete(new SigitTImportXmlLibPk(ConvertUtil.convertToBigDecimal(codImpianto)));
		} catch (Exception e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_INSERT_DB));
		}
		finally
		{
			log.debug("[SigitMgr:::deleteImportLibretto] END");
		}
	}

	public SigitTImportXmlLibDto getImportLibrettoByIdImpianto(Integer idImpianto) throws DbManagerException
	{
		log.debug("[SigitMgr:::getImportLibrettoByIdImpianto] START");
		SigitTImportXmlLibDto importLibretto = null;
		try{


			importLibretto = getSigitTImportXmlLibDao().findByPrimaryKey(new SigitTImportXmlLibPk(ConvertUtil.convertToBigDecimal(idImpianto)));
		} catch (Exception e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_INSERT_DB));
		}
		finally
		{
			log.debug("[SigitMgr:::getImportLibrettoByIdImpianto] END");
		}

		return importLibretto;
	}

	@Transactional
	public Integer insertImport(ImportFilter importData, Integer idPgCat, Integer idPg) throws DbManagerException
	{
		log.debug("[SigitMgr:::insertImport] START");
		try{
			SigitTImportDto dto = MapDto.mapToSigitTImport(importData, idPgCat, idPg);
			getSigitTImportDao().insert(dto);
			SigitTImpXmlDto dtoXml = new SigitTImpXmlDto();
			dtoXml.setIdImport(dto.getIdImport());
			dtoXml.setFileImport(XmlBeanUtils.readByteArray(importData.getDatiXml()));
			return getSigitTImpXmlDao().insert(dtoXml).getIdImport();


		} catch (Exception e) {
			log.error("Errore: ",e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(new Message(Messages.ERROR_INSERT_DB));
		}
		finally
		{
			log.debug("[SigitMgr:::insertImport] END");
		}
	}

	public void aggiornaImport(Integer idImport, String msgError, BigDecimal idAllegato) throws DbManagerException
	{
		log.debug("[SigitMgr:::aggiornaImport] START");
		try{
			SigitTImportDto dto = getSigitTImportDao().findByPrimaryKey(new SigitTImportPk(idImport));

			dto.setDataFine(DateUtil.getSqlDataCorrente());
			dto.setFkAllegato(idAllegato);
			if (GenericUtil.isNullOrEmpty(msgError))
			{
				dto.setFlgEsito(java.math.BigDecimal.ONE);
			}
			else
			{
				dto.setFlgEsito(java.math.BigDecimal.ZERO);
				dto.setMsgErrore(msgError.substring(0, (msgError.length() > Constants.MAX_1000_LEN?Constants.MAX_1000_LEN:msgError.length())));
			}

			getSigitTImportDao().update(dto);
		} catch (Exception e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_INSERT_DB));
		}
		finally
		{
			log.debug("[SigitMgr:::aggiornaImport] END");
		}
	}

	public List<SigitDTipoComponenteDto> getElencoTipoComponente() throws DbManagerException
	{
		log.debug("[SigitMgr:::getElencoTipoComponente] START");
		try{
			return getSigitDTipoComponenteDao().findAllValide(null);
		} catch (Exception e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally
		{
			log.debug("[SigitMgr:::getElencoTipoComponente] END");
		}

	}

	public int getIdSeqImportDistrib() throws DbManagerException
	{
		log.debug("[SigitMgr:::getIdSeqImportDistrib] START");
		try{
			return ConvertUtil.convertToInteger(getSigitExtDao().getSeqTImportDistrib());
		} catch (SigitExtDaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally
		{
			log.debug("[SigitMgr:::getIdSeqImportDistrib] END");
		}

	}

	public int getNextIdSeqCodiceImpianto() throws DbManagerException
	{
		log.debug("[SigitMgr:::getNextIdSeqCodiceImpianto] START");
		try{

			int nextId = 0;

			boolean trovato = false;

			// Devo ciclare fino a quando non trovo un codice impianto non usato
			while (!trovato)
			{
		        nextId = ConvertUtil.convertToInteger(getSigitExtDao().getSeqTCodiceImpianto());
			    if (cercaImpiantoDtoById(ConvertUtil.convertToString(nextId)) == null)
			    {
			    	trovato = true;
			    }
			}

			return nextId;
		} catch (SigitExtDaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally
		{
			log.debug("[SigitMgr:::getNextIdSeqCodiceImpianto] END");
		}

	}

	public int getMaxIdSeqCodiceImpianto() throws DbManagerException
	{
		log.debug("[SigitMgr:::getIdSeqCodiceImpianto] START");
		try{
			return ConvertUtil.convertToInteger(getSigitExtDao().getSeqTCodiceImpianto());
		} catch (SigitExtDaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally
		{
			log.debug("[SigitMgr:::getIdSeqCodiceImpianto] END");
		}

	}

	/**
	 * carica la combo dei tipi intervento
	 * @return ArrayList<CodeDescription>
	 * @throws DbManagerException
	 */
	public ArrayList<CodeDescription> cercaTipoIntervento() throws DbManagerException {
		log.debug("[DbMgr::cercaTipoIntervento] BEGIN");
		try {

			List<SigitDTipoInterventoDto> tipoIntervento = getSigitDTipoInterventoDao().findAll();
			if(tipoIntervento==null){
				log.debug("[DbMgr::cercaTipoIntervento] elenco tipoIntervento NULL");
			} else{
				log.debug("[DbMgr::cercaTipoIntervento] elenco tipoIntervento NOT NULL " + tipoIntervento.size());
			}
			return MapDto.mapTipiIntervento(tipoIntervento);
		}
		catch (SigitDTipoInterventoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaTipoIntervento] END");
		}
	}

	/**
	 * carica la combo dei tipi intervento
	 * @return ArrayList<CodeDescription>
	 * @throws DbManagerException
	 */
	public ArrayList<CodeDescription> cercaCategoria() throws DbManagerException {
		log.debug("[DbMgr::cercaCategoria] BEGIN");
		try {
			return MapDto.mapCategoria(getSigitDCategoriaDao().findAll());
		}
		catch (SigitDCategoriaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaCategoria] END");
		}
	}

	@Transactional
	public void salvaComponenteAC(String codImpianto, ComponenteAC componente, ArrayList<ComponenteAC> compList, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaComponenteAC] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, componente.getProgrComponente());

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompAcDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_ac", "codice_impianto="+codImpianto+"&progressivo="+componente.getProgrComponente()));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_AC);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(componente.getProgrComponente()));

			getSigitTCompXDao().customDeleterByFilter(filterX);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_AC+"&progressivo="+componente.getProgrComponente()));

			BigDecimal codiceImpianto = ConvertUtil.convertToBigDecimal(codImpianto);

			// Devo aggiungere il componetente principale piu' tutte le sostituzioni
			getSigitTCompXDao().insert(MapDto.getSigitTCompX(componente, codiceImpianto, cfUtenteMod));
			getSigitTCompAcDao().insert(MapDto.getSigitTCompAC(componente, codiceImpianto));

			if (compList != null && compList.size() > 0)
			{
				for (ComponenteAC componenteAC : compList) {

					// Devo aggiungere il componetente principale piu' tutte le sostituzioni
					getSigitTCompXDao().insert(MapDto.getSigitTCompX(componenteAC, codiceImpianto, cfUtenteMod));
					getSigitTCompAcDao().insert(MapDto.getSigitTCompAC(componenteAC, codiceImpianto));
				}
			}


		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaComponenteAC] END");
		}
	}

	@Transactional
	public void cancellaComponenteAC(String codImpianto, String progressivo, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponenteAC] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, progressivo);

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompAcDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_ac", "codice_impianto="+codImpianto+"&progressivo="+progressivo));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_AC);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));

			// Cancello tutte le componenti di quel tipo con quel progressivo
			getSigitTCompXDao().customDeleterByFilter(filterX);
			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_AC+"&progressivo="+progressivo));

		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cancellaComponenteAC] END");
		}
	}

	@Transactional
	public void salvaComponenteTE(String codImpianto, ComponenteTE componente, ArrayList<ComponenteTE> compList, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaComponenteTE] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, componente.getProgrComponente());

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompTeDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_te", "codice_impianto="+codImpianto+"&progressivo="+componente.getProgrComponente()));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_TE);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(componente.getProgrComponente()));

			getSigitTCompXDao().customDeleterByFilter(filterX);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_TE+"&progressivo="+componente.getProgrComponente()));

			BigDecimal codiceImpianto = ConvertUtil.convertToBigDecimal(codImpianto);

			// Devo aggiungere il componetente principale piu' tutte le sostituzioni
			getSigitTCompXDao().insert(MapDto.getSigitTCompX(componente, codiceImpianto, cfUtenteMod));
			getSigitTCompTeDao().insert(MapDto.getSigitTCompTE(componente, codiceImpianto));

			if (compList != null && compList.size() > 0)
			{
				for (ComponenteTE componenteTE : compList) {

					// Devo aggiungere il componetente principale piu' tutte le sostituzioni
					getSigitTCompXDao().insert(MapDto.getSigitTCompX(componenteTE, codiceImpianto, cfUtenteMod));
					getSigitTCompTeDao().insert(MapDto.getSigitTCompTE(componenteTE, codiceImpianto));
				}
			}


		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaComponenteTE] END");
		}
	}

	@Transactional
	public void cancellaComponenteTE(String codImpianto, String progressivo, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponenteTE] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, progressivo);

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompTeDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_te", "codice_impianto="+codImpianto+"&progressivo="+progressivo));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_TE);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));

			// Cancello tutte le componenti di quel tipo con quel progressivo
			getSigitTCompXDao().customDeleterByFilter(filterX);
			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_TE+"&progressivo="+progressivo));

		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cancellaComponenteTE] END");
		}
	}




	/////////////////////////////////


	@Transactional
	public void salvaComponenteRV(String codImpianto, ComponenteRV componente, ArrayList<ComponenteRV> compList, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaComponenteRV] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, componente.getProgrComponente());

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompRvDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_rv", "codice_impianto="+codImpianto+"&progressivo="+componente.getProgrComponente()));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_RV);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(componente.getProgrComponente()));

			getSigitTCompXDao().customDeleterByFilter(filterX);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_RV+"&progressivo="+componente.getProgrComponente()));

			BigDecimal codiceImpianto = ConvertUtil.convertToBigDecimal(codImpianto);

			// Devo aggiungere il componetente principale piu' tutte le sostituzioni
			getSigitTCompXDao().insert(MapDto.getSigitTCompX(componente, codiceImpianto, cfUtenteMod));
			getSigitTCompRvDao().insert(MapDto.getSigitTCompRV(componente, codiceImpianto));

			if (compList != null && compList.size() > 0)
			{
				for (ComponenteRV componenteRV : compList) {

					// Devo aggiungere il componetente principale piu' tutte le sostituzioni
					getSigitTCompXDao().insert(MapDto.getSigitTCompX(componenteRV, codiceImpianto, cfUtenteMod));
					getSigitTCompRvDao().insert(MapDto.getSigitTCompRV(componenteRV, codiceImpianto));
				}
			}


		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaComponenteRV] END");
		}
	}

	@Transactional
	public void cancellaComponenteRV(String codImpianto, String progressivo, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponenteRV] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, progressivo);

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompRvDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_rv", "codice_impianto="+codImpianto+"&progressivo="+progressivo));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_RV);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));

			// Cancello tutte le componenti di quel tipo con quel progressivo
			getSigitTCompXDao().customDeleterByFilter(filterX);
			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_RV+"&progressivo="+progressivo));

		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cancellaComponenteRV] END");
		}
	}

	@Transactional
	public void salvaComponenteSCX(String codImpianto, ComponenteSCX componente, ArrayList<ComponenteSCX> compList, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaComponenteSCX] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, componente.getProgrComponente());

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompScxDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_scx", "codice_impianto="+codImpianto+"&progressivo="+componente.getProgrComponente()));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_SCX);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(componente.getProgrComponente()));

			getSigitTCompXDao().customDeleterByFilter(filterX);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_SCX+"&progressivo="+componente.getProgrComponente()));

			BigDecimal codiceImpianto = ConvertUtil.convertToBigDecimal(codImpianto);

			// Devo aggiungere il componetente principale piu' tutte le sostituzioni
			getSigitTCompXDao().insert(MapDto.getSigitTCompX(componente, codiceImpianto, cfUtenteMod));
			getSigitTCompScxDao().insert(MapDto.getSigitTCompSCX(componente, codiceImpianto));

			if (compList != null && compList.size() > 0)
			{
				for (ComponenteSCX componenteSCX : compList) {

					// Devo aggiungere il componetente principale piu' tutte le sostituzioni
					getSigitTCompXDao().insert(MapDto.getSigitTCompX(componenteSCX, codiceImpianto, cfUtenteMod));
					getSigitTCompScxDao().insert(MapDto.getSigitTCompSCX(componenteSCX, codiceImpianto));
				}
			}


		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaComponenteSCX] END");
		}
	}

	@Transactional
	public void cancellaComponenteSCX(String codImpianto, String progressivo, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponenteSCX] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, progressivo);

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompScxDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_scx", "codice_impianto="+codImpianto+"&progressivo="+progressivo));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_SCX);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));

			// Cancello tutte le componenti di quel tipo con quel progressivo
			getSigitTCompXDao().customDeleterByFilter(filterX);
			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_SCX+"&progressivo="+progressivo));

		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cancellaComponenteSCX] END");
		}
	}

	@Transactional
	public void salvaComponenteCI(String codImpianto, ComponenteCI componente, ArrayList<ComponenteCI> compList, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaComponenteCI] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, componente.getProgrComponente());

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompCiDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_ci", "codice_impianto="+codImpianto+"&progressivo="+componente.getProgrComponente()));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_CI);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(componente.getProgrComponente()));

			getSigitTCompXDao().customDeleterByFilter(filterX);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_CI+"&progressivo="+componente.getProgrComponente()));

			BigDecimal codiceImpianto = ConvertUtil.convertToBigDecimal(codImpianto);

			// Devo aggiungere il componetente principale piu' tutte le sostituzioni
			getSigitTCompXDao().insert(MapDto.getSigitTCompX(componente, codiceImpianto, cfUtenteMod));
			getSigitTCompCiDao().insert(MapDto.getSigitTCompCI(componente, codiceImpianto));

			if (compList != null && compList.size() > 0)
			{
				for (ComponenteCI componenteCI : compList) {

					// Devo aggiungere il componetente principale piu' tutte le sostituzioni
					getSigitTCompXDao().insert(MapDto.getSigitTCompX(componenteCI, codiceImpianto, cfUtenteMod));
					getSigitTCompCiDao().insert(MapDto.getSigitTCompCI(componenteCI, codiceImpianto));
				}
			}


		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaComponenteCI] END");
		}
	}

	@Transactional
	public void cancellaComponenteCI(String codImpianto, String progressivo, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponenteCI] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, progressivo);

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompCiDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_ci", "codice_impianto="+codImpianto+"&progressivo="+progressivo));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_CI);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));

			// Cancello tutte le componenti di quel tipo con quel progressivo
			getSigitTCompXDao().customDeleterByFilter(filterX);
			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_CI+"&progressivo="+progressivo));

		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cancellaComponenteCI] END");
		}
	}

	@Transactional
	public void salvaComponenteUT(String codImpianto, ComponenteUT componente, ArrayList<ComponenteUT> compList, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaComponenteUT] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, componente.getProgrComponente());

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompUtDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_ut", "codice_impianto="+codImpianto+"&progressivo="+componente.getProgrComponente()));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_UT);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(componente.getProgrComponente()));

			getSigitTCompXDao().customDeleterByFilter(filterX);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_UT+"&progressivo="+componente.getProgrComponente()));

			BigDecimal codiceImpianto = ConvertUtil.convertToBigDecimal(codImpianto);

			// Devo aggiungere il componetente principale piu' tutte le sostituzioni
			getSigitTCompXDao().insert(MapDto.getSigitTCompX(componente, codiceImpianto, cfUtenteMod));
			getSigitTCompUtDao().insert(MapDto.getSigitTCompUT(componente, codiceImpianto));

			if (compList != null && compList.size() > 0)
			{
				for (ComponenteUT componenteUT : compList) {

					// Devo aggiungere il componetente principale piu' tutte le sostituzioni
					getSigitTCompXDao().insert(MapDto.getSigitTCompX(componenteUT, codiceImpianto, cfUtenteMod));
					getSigitTCompUtDao().insert(MapDto.getSigitTCompUT(componenteUT, codiceImpianto));
				}
			}


		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaComponenteUT] END");
		}
	}

	@Transactional
	public void cancellaComponenteUT(String codImpianto, String progressivo, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponenteUT] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, progressivo);

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompUtDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_ut", "codice_impianto="+codImpianto+"&progressivo="+progressivo));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_UT);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));

			// Cancello tutte le componenti di quel tipo con quel progressivo
			getSigitTCompXDao().customDeleterByFilter(filterX);
			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_UT+"&progressivo="+progressivo));

		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cancellaComponenteUT] END");
		}
	}

	@Transactional
	public void salvaComponenteRC(String codImpianto, ComponenteRC componente, ArrayList<ComponenteRC> compList, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaComponenteRC] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, componente.getProgrComponente());

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompRcDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_rc", "codice_impianto="+codImpianto+"&progressivo="+componente.getProgrComponente()));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_RC);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(componente.getProgrComponente()));

			getSigitTCompXDao().customDeleterByFilter(filterX);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_RC+"&progressivo="+componente.getProgrComponente()));

			BigDecimal codiceImpianto = ConvertUtil.convertToBigDecimal(codImpianto);

			// Devo aggiungere il componetente principale piu' tutte le sostituzioni
			getSigitTCompXDao().insert(MapDto.getSigitTCompX(componente, codiceImpianto, cfUtenteMod));
			getSigitTCompRcDao().insert(MapDto.getSigitTCompRC(componente, codiceImpianto));

			if (compList != null && compList.size() > 0)
			{
				for (ComponenteRC componenteRC : compList) {

					// Devo aggiungere il componetente principale piu' tutte le sostituzioni
					getSigitTCompXDao().insert(MapDto.getSigitTCompX(componenteRC, codiceImpianto, cfUtenteMod));
					getSigitTCompRcDao().insert(MapDto.getSigitTCompRC(componenteRC, codiceImpianto));
				}
			}


		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaComponenteRC] END");
		}
	}

	@Transactional
	public void cancellaComponenteRC(String codImpianto, String progressivo, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponenteRC] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, progressivo);

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompRcDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_rc", "codice_impianto="+codImpianto+"&progressivo="+progressivo));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_RC);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));

			// Cancello tutte le componenti di quel tipo con quel progressivo
			getSigitTCompXDao().customDeleterByFilter(filterX);
			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_RC+"&progressivo="+progressivo));

		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cancellaComponenteRC] END");
		}
	}

	private SigitTAzioneComp4Dao sigitTAzioneComp4Dao;

	public SigitTAzioneComp4Dao getSigitTAzioneComp4Dao() {
		return sigitTAzioneComp4Dao;
	}

	public void setSigitTAzioneComp4Dao(SigitTAzioneComp4Dao sigitTAzioneComp4Dao) {
		this.sigitTAzioneComp4Dao = sigitTAzioneComp4Dao;
	}

	public SigitTComp4Dto aggiornaComp4DtControlloWeb(SigitTComp4Pk comp4Pk) throws SigitTComp4DaoException {
		//VIENE AGGIORNATA LA COMP4
		SigitTComp4Dto comp4 = getSigitTComp4Dao().findByPrimaryKey(comp4Pk);
		comp4.setDtControlloweb(DateUtil.getSqlDataCorrente());
		getSigitTComp4Dao().update(comp4);
		return comp4;
	}

	public void salvaAzioneComp4(SigitTComp4Pk comp4Pk, String dataInstallCompAttiva, String cfUtente, Ruolo ruolo) throws SigitTComp4DaoException {

		//VIENE AGGIORNATA LA COMP4
		SigitTComp4Dto comp4 = aggiornaComp4DtControlloWeb(comp4Pk);

		if (Constants.RUOLO_VALIDATORE.equals(ruolo.getDescRuolo()) || Constants.RUOLO_SUPER.equals(ruolo.getDescRuolo())) {
			SigitTAzioneComp4Dto azione = new SigitTAzioneComp4Dto();
			azione.setCfUtenteAzione(ReplaceSpecialCharUtils.sanitize(cfUtente));
			azione.setCodiceImpianto(comp4Pk.getCodiceImpianto());
			azione.setDescrizioneAzione("Dato aggiornato da utente " + 
					ReplaceSpecialCharUtils.sanitize(ruolo.getDescRuoloCompleto()));
			azione.setDtAzione(comp4.getDtControlloweb());
			azione.setDtInstall(ConvertUtil.convertToSqlDate(dataInstallCompAttiva));
			azione.setIdTipoComponente(ReplaceSpecialCharUtils.sanitize(comp4Pk.getIdTipoComponente()));
			azione.setProgressivo(comp4Pk.getProgressivo());

			getSigitTAzioneComp4Dao().insert(azione);
		}
	}

	public SigitTComp4Pk salvaComp4 (BigDecimal codiceImpianto, BigDecimal progressivo, String idTipoComponente) throws DbManagerException {
		SigitTComp4Pk pkComp4 = new SigitTComp4Pk();
		pkComp4.setCodiceImpianto(codiceImpianto);
		pkComp4.setIdTipoComponente(ReplaceSpecialCharUtils.sanitize(idTipoComponente));
		pkComp4.setProgressivo(progressivo);

		return salvaComp4(pkComp4);
	}

	private SigitTComp4Pk salvaComp4(SigitTComp4Pk pkComp4) throws DbManagerException {
		try {
			// Vuol dire che sul db non esisteva questa componente (es. CS1)
			if(getSigitTComp4Dao().findByPrimaryKey(pkComp4)==null)
			{
				SigitTComp4Dto comp4 = MapDto.getSigitTComp4(pkComp4);
				pkComp4 = getSigitTComp4Dao().insert(comp4);
			}
		}
		catch(SigitTComp4DaoException e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		return pkComp4;
	}


	/////////////////////////////////////////////

	@Transactional
	public void salvaComponenteCS(String codImpianto, ComponenteCS componente, ArrayList<ComponenteCS> compList, String cfUtenteMod, Boolean nuovaComponente) throws DbManagerException {
		log.debug("[DbMgr::salvaComponenteCS] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, componente.getProgrComponente());
			filter.setTipoComponente(Constants.TIPO_COMPONENTE_CS);

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompCsDao().customDeleterByFilter(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_cs", "codice_impianto="+codImpianto+"&progressivo="+componente.getProgrComponente()));

			/*
			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_CS);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(componente.getProgrComponente()));

			getSigitTCompXDao().customDeleterByFilter(filterX);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_CS+"&progressivo="+componente.getProgrComponente()));
			*/

			BigDecimal codiceImpianto = ConvertUtil.convertToBigDecimal(codImpianto);
			BigDecimal progressivo = ConvertUtil.convertToBigDecimal(componente.getProgrComponente());

			SigitTComp4Pk pkComp4 = null;
			//se si tratta di una nuova componente, contestualmente all'inserimento in compCs, ci deve essere l'inserimento anche in comp4
			if( nuovaComponente != null && nuovaComponente) {
				pkComp4 = salvaComp4(codiceImpianto, progressivo, Constants.TIPO_COMPONENTE_CS);
			} else {
				pkComp4 = new SigitTComp4Pk(codiceImpianto, Constants.TIPO_COMPONENTE_CS, progressivo);
			}
			//aggiornamento del timestamp per il controlloWeb
			aggiornaComp4DtControlloWeb(pkComp4);

			// Devo aggiungere il componetente principale piu' tutte le sostituzioni
			//getSigitTCompXDao().insert(MapDto.getSigitTCompX(componente, codiceImpianto, cfUtenteMod));
			getSigitTCompCsDao().insert(MapDto.getSigitTCompCS(componente, codiceImpianto, cfUtenteMod));

			if (compList != null && compList.size() > 0)
			{
				for (ComponenteCS componenteCS : compList) {

					// Devo aggiungere il componetente principale piu' tutte le sostituzioni
					//getSigitTCompXDao().insert(MapDto.getSigitTCompX(componenteCS, codiceImpianto, cfUtenteMod));
					getSigitTCompCsDao().insert(MapDto.getSigitTCompCS(componenteCS, codiceImpianto, cfUtenteMod));
					//N.B. non e' necessario aggiungere le comp4 anche per la lista di sostituzioni in quanto la comp4 tiene traccia delle componenti attive
					//e non dello storico delle sue sostituzioni

				}
			}


		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaComponenteCS] END");
		}
	}

	@Transactional
	public void cancellaComponenteCS(String codImpianto, String progressivo, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponenteCS] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, progressivo);
			filter.setTipoComponente(Constants.TIPO_COMPONENTE_CS);

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompCsDao().customDeleterByFilter(filter);

			SigitTComp4Pk pkComp4 = new SigitTComp4Pk(ConvertUtil.convertToBigDecimal(codImpianto), Constants.TIPO_COMPONENTE_CS, ConvertUtil.convertToBigDecimal(progressivo));

			//N.B. eliminando definitivamente la componente CS verra' eliminata anche la riga nella tabella comp4
			getSigitTComp4Dao().delete(pkComp4);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_cs", "codice_impianto="+codImpianto+"&progressivo="+progressivo));

			/*
			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_CS);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));

			// Cancello tutte le componenti di quel tipo con quel progressivo
			getSigitTCompXDao().customDeleterByFilter(filterX);
			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_CS+"&progressivo="+progressivo));
			*/

		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			Message msg = null;
			if (e instanceof DbManagerException) {
				msg = ((DbManagerException) e).getMsg();
			}
			throw new DbManagerException(e, msg == null? new Message(Messages.ERROR_RECUPERO_DB) : msg);
		}
		finally {
			log.debug("[DbMgr::cancellaComponenteCS] END");
		}
	}

	@Transactional
	public void cancellaComponenteBRRC(String codImpianto, String progressivo, String cfUtenteMod, String tipoComponente) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponenteBRRC] BEGIN -> codImpianto=" + codImpianto + ", progressivo=" + progressivo +", tipoComponente="+ tipoComponente);
		try {

			CompFilter filter = new CompFilter(codImpianto, progressivo);
			filter.setTipoComponente(tipoComponente);

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompBrRcDao().customDeleterByFilterComp(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_br_rc", "codice_impianto="+codImpianto+"&progressivo="+progressivo+"&tipo_componente="+tipoComponente));

		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			Message msg = null;
			if (e instanceof DbManagerException) {
				msg = ((DbManagerException) e).getMsg();
			}
			throw new DbManagerException(e, msg == null? new Message(Messages.ERROR_RECUPERO_DB) : msg);
		}
		finally {
			log.debug("[DbMgr::cancellaComponenteBRRC] END");
		}
	}


	public List<SigitTCompBrRcDto> cercaCompBRRCByGT(String codImpianto, String progressivo, String dataInstallazione) throws DbManagerException {
		List<SigitTCompBrRcDto> listaDb = null;
		log.debug("[DbMgr::cercaCompBRRCByGT] BEGIN");
		try {

			CompFilter filtroGT = new CompFilter(codImpianto, progressivo, ConvertUtil.convertToSqlDate(dataInstallazione));
			listaDb = getSigitTCompBrRcDao().findBrRcLegateAGt(filtroGT);
			return listaDb;

		}
		catch(SigitTCompBrRcDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaCompBRRCByGT] END");
		}
	}


	@Transactional
	public void salvaComponenteBRRC(String codImpianto, ComponenteBRRC componente, ArrayList<ComponenteBRRC> compList, String cfUtenteMod, String tipoComponente) throws DbManagerException {
		log.debug("[DbMgr::salvaComponenteBRRC] BEGIN");
		try {

			BigDecimal progressivo = ConvertUtil.convertToBigDecimal(GenericUtil.getProgrComponente(componente.getComponente()));

			CompFilter filter = new CompFilter(codImpianto, ConvertUtil.convertToString(progressivo));
			filter.setTipoComponente(ReplaceSpecialCharUtils.sanitize(tipoComponente));

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompBrRcDao().customDeleterByFilterComp(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_br_rc", "codice_impianto="+codImpianto+"&progressivo="+progressivo+"&tipo_componente="+tipoComponente));

			BigDecimal codiceImpianto = ConvertUtil.convertToBigDecimal(codImpianto);

			//n.b. se viene modificato il gt della componente in primo piano, la modifica va eseguita in cascata sullo storico
			List<SigitTCompGtDto> listGt = getSigittCompGtDao().findByExample(new CompFilter(codImpianto, componente.getGtCollegato()));
			if (listGt != null && !listGt.isEmpty()) {
				SigitTCompGtDto firstGt = listGt.get(0);
				BigDecimal fkProgressivo = firstGt.getProgressivo();
				java.sql.Date fkDataInstall = firstGt.getDataInstall();

				// Devo aggiungere il componetente principale piu' tutte le sostituzioni
				getSigitTCompBrRcDao().insert(MapDto.mapToSigitTCompBrRcDto(componente, codiceImpianto, fkProgressivo, fkDataInstall, progressivo, tipoComponente));

				if (compList != null && compList.size() > 0)
				{
					for (ComponenteBRRC componenteBrRc : compList) {
						//viene sovrascritto il gt con quello della componente in primo piano
						componenteBrRc.setGtCollegato(componente.getGtCollegato());
						getSigitTCompBrRcDao().insert(MapDto.mapToSigitTCompBrRcDto(componenteBrRc, codiceImpianto, fkProgressivo, fkDataInstall, progressivo, tipoComponente));
					}
				}
			}
		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaComponenteCS] END");
		}
	}

	public void insertComp4Manut (BigDecimal codImpianto, String tipoComponente, BigDecimal progressivo, Integer idPersonaGiuridica, String cfUtenteMod, Integer ruolo) throws SigitRComp4ManutDaoException {

		SigitRComp4ManutDto comp4ManutFilter = new SigitRComp4ManutDto();
		comp4ManutFilter.setCodiceImpianto(codImpianto);
		comp4ManutFilter.setIdTipoComponente(ReplaceSpecialCharUtils.sanitize(tipoComponente));
		comp4ManutFilter.setProgressivo(progressivo);

		List<SigitRComp4ManutDto> comp4ManutList = getSigitRComp4ManutDao().findAttiviByFilter(comp4ManutFilter);

		log.debug("STAMPO comp4ManutList: "+comp4ManutList);

		if(comp4ManutList == null || comp4ManutList.size() == 0)
		{
			SigitRComp4ManutDto comp4Manut = MapDto.getSigitRComp4Manut(codImpianto, tipoComponente, progressivo, ruolo, idPersonaGiuridica, cfUtenteMod);
			getSigitRComp4ManutDao().insert(comp4Manut);
		}
	}

	public void updateListComponentiCG (List<ComponenteCG> listToPersist, String codImpianto, String progressivo, String cfUtenteMod) throws SigitTCompCgDaoException {
		//viene recuperato lo stato dello storico presente sul db
		BigDecimal codImpiantoBigD = ConvertUtil.convertToBigDecimal(codImpianto);
		BigDecimal progressivoBigD = ConvertUtil.convertToBigDecimal(progressivo);

		List<SigitTCompCgDto> storicoPersisted = getSigitTCompCgDao().findByExample(new CompFilter(codImpianto, progressivo));

		if (storicoPersisted == null || storicoPersisted.isEmpty()) {
			//tutte le componenti nello storico sono da persistere
			if (listToPersist != null) {
				for (ComponenteCG compToPersist : listToPersist) {
					getSigitTCompCgDao().insert(MapDto.mapToSigitTCompCGDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
				}
			}
		} else {
			//costruisce una mappa in base alla data di installazione
			Map<String, SigitTCompCgDto> dizionarioCompDb = new HashMap<String, SigitTCompCgDto>();
			for (SigitTCompCgDto compDb : storicoPersisted) {
				dizionarioCompDb.put(ConvertUtil.convertToString(compDb.getDataInstall()), compDb);
			}
			Set<String> persistedKeyToDelete = dizionarioCompDb.keySet(); //alla fine conterra' solo le chiavi che dovranno essere rimosse
			if (listToPersist != null) {
				for (ComponenteCG compToPersist : listToPersist) {
					if (dizionarioCompDb.get(compToPersist.getDataInstallazione()) == null) {
						getSigitTCompCgDao().insert(MapDto.mapToSigitTCompCGDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
					} else {
						//la componente era gia' stata persistita quindi viene eseguito un update
						getSigitTCompCgDao().update(MapDto.mapToSigitTCompCGDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
						persistedKeyToDelete.remove(compToPersist.getDataInstallazione());
					}
				}
			}

			if (persistedKeyToDelete != null && !persistedKeyToDelete.isEmpty()) {
				for(String keyToDelete : persistedKeyToDelete) {
					SigitTCompCgPk pkToDelete = new SigitTCompCgPk(Constants.TIPO_COMPONENTE_CG, progressivoBigD, ConvertUtil.convertToSqlDate(keyToDelete), codImpiantoBigD);
					getSigitTCompCgDao().delete(pkToDelete);
				}
			}
		}
	}

	public void updateListComponentiGF (List<ComponenteGF> listToPersist, String codImpianto, String progressivo, String cfUtenteMod) throws SigitTCompGfDaoException {
		//viene recuperato lo stato dello storico presente sul db
		BigDecimal codImpiantoBigD = ConvertUtil.convertToBigDecimal(codImpianto);
		BigDecimal progressivoBigD = ConvertUtil.convertToBigDecimal(progressivo);

		List<SigitTCompGfDto> storicoPersisted = getSigitTCompGfDao().findByExample(new CompFilter(codImpianto, progressivo));

		if (storicoPersisted == null || storicoPersisted.isEmpty()) {
			//tutte le componenti nello storico sono da persistere
			if (listToPersist != null) {
				for (ComponenteGF compToPersist : listToPersist) {
					getSigitTCompGfDao().insert(MapDto.mapToSigitTCompGFDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
				}
			}
		} else {
			//costruisce una mappa in base alla data di installazione
			Map<String, SigitTCompGfDto> dizionarioCompDb = new HashMap<String, SigitTCompGfDto>();
			for (SigitTCompGfDto compDb : storicoPersisted) {
				dizionarioCompDb.put(ConvertUtil.convertToString(compDb.getDataInstall()), compDb);
			}
			Set<String> persistedKeyToDelete = dizionarioCompDb.keySet(); //alla fine conterra' solo le chiavi che dovranno essere rimosse
			if (listToPersist != null) {
				for (ComponenteGF compToPersist : listToPersist) {
					if (dizionarioCompDb.get(compToPersist.getDataInstallazione()) == null) {
						getSigitTCompGfDao().insert(MapDto.mapToSigitTCompGFDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
					} else {
						//la componente era gia' stata persistita quindi viene eseguito un update
						getSigitTCompGfDao().update(MapDto.mapToSigitTCompGFDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
						persistedKeyToDelete.remove(compToPersist.getDataInstallazione());
					}
				}
			}

			if (persistedKeyToDelete != null && !persistedKeyToDelete.isEmpty()) {
				for(String keyToDelete : persistedKeyToDelete) {
					SigitTCompGfPk pkToDelete = new SigitTCompGfPk(Constants.TIPO_COMPONENTE_GF, progressivoBigD, ConvertUtil.convertToSqlDate(keyToDelete), codImpiantoBigD);
					getSigitTCompGfDao().delete(pkToDelete);
				}
			}
		}
	}


	public void updateListComponentiSC (List<ComponenteSC> listToPersist, String codImpianto, String progressivo, String cfUtenteMod) throws SigitTCompScDaoException {
		//viene recuperato lo stato dello storico presente sul db
		BigDecimal codImpiantoBigD = ConvertUtil.convertToBigDecimal(codImpianto);
		BigDecimal progressivoBigD = ConvertUtil.convertToBigDecimal(progressivo);

		List<SigitTCompScDto> storicoPersisted = getSigitTCompScDao().findByExample(new CompFilter(codImpianto, progressivo));

		if (storicoPersisted == null || storicoPersisted.isEmpty()) {
			//tutte le componenti nello storico sono da persistere
			if (listToPersist != null) {
				for (ComponenteSC compToPersist : listToPersist) {
					getSigitTCompScDao().insert(MapDto.mapToSigitTCompSCDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
				}
			}
		} else {
			//costruisce una mappa in base alla data di installazione
			Map<String, SigitTCompScDto> dizionarioCompDb = new HashMap<String, SigitTCompScDto>();
			for (SigitTCompScDto compDb : storicoPersisted) {
				dizionarioCompDb.put(ConvertUtil.convertToString(compDb.getDataInstall()), compDb);
			}
			Set<String> persistedKeyToDelete = dizionarioCompDb.keySet(); //alla fine conterra' solo le chiavi che dovranno essere rimosse
			if (listToPersist != null) {
				for (ComponenteSC compToPersist : listToPersist) {
					if (dizionarioCompDb.get(compToPersist.getDataInstallazione()) == null) {
						getSigitTCompScDao().insert(MapDto.mapToSigitTCompSCDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
					} else {
						//la componente era gia' stata persistita quindi viene eseguito un update
						getSigitTCompScDao().update(MapDto.mapToSigitTCompSCDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
						persistedKeyToDelete.remove(compToPersist.getDataInstallazione());
					}
				}
			}

			if (persistedKeyToDelete != null && !persistedKeyToDelete.isEmpty()) {
				for(String keyToDelete : persistedKeyToDelete) {
					SigitTCompScPk pkToDelete = new SigitTCompScPk(Constants.TIPO_COMPONENTE_SC, progressivoBigD, ConvertUtil.convertToSqlDate(keyToDelete), codImpiantoBigD);
					getSigitTCompScDao().delete(pkToDelete);
				}
			}
		}
	}

	public void updateListComponentiGT (List<ComponenteGT> listToPersist, String codImpianto, String progressivo, String cfUtenteMod) throws SigitTCompGtDaoException {
		//viene recuperato lo stato dello storico presente sul db
		BigDecimal codImpiantoBigD = ConvertUtil.convertToBigDecimal(codImpianto);
		BigDecimal progressivoBigD = ConvertUtil.convertToBigDecimal(progressivo);


		List<SigitTCompGtDto> storicoPersisted = getSigittCompGtDao().findByExample(new CompFilter(codImpianto, progressivo));

		if (storicoPersisted == null || storicoPersisted.isEmpty()) {
			//tutte le componenti nello storico sono da persistere
			if (listToPersist != null) {
				for (ComponenteGT compToPersist : listToPersist) {
					 getSigittCompGtDao().insert(MapDto.mapToSigitTCompGTDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
				}
			}
		} else {
			//costruisce una mappa in base alla data di installazione
			Map<String, SigitTCompGtDto> dizionarioCompDb = new HashMap<String, SigitTCompGtDto>();
			for (SigitTCompGtDto compDb : storicoPersisted) {
				dizionarioCompDb.put(ConvertUtil.convertToString(compDb.getDataInstall()), compDb);
			}
			Set<String> persistedKeyToDelete = dizionarioCompDb.keySet(); //alla fine conterra' solo le chiavi che dovranno essere rimosse
			if (listToPersist != null) {
				for (ComponenteGT compToPersist : listToPersist) {
					if (dizionarioCompDb.get(compToPersist.getDataInstallazione()) == null) {
						getSigittCompGtDao().insert(MapDto.mapToSigitTCompGTDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
					} else {
						//la componente era gia' stata persistita quindi viene eseguito un update
						getSigittCompGtDao().update(MapDto.mapToSigitTCompGTDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
						persistedKeyToDelete.remove(compToPersist.getDataInstallazione());
					}
				}
			}

			if (persistedKeyToDelete != null && !persistedKeyToDelete.isEmpty()) {
				for(String keyToDelete : persistedKeyToDelete) {
					SigitTCompGtPk pkToDelete = new SigitTCompGtPk(Constants.TIPO_COMPONENTE_GT, progressivoBigD, ConvertUtil.convertToSqlDate(keyToDelete), codImpiantoBigD);
					getSigittCompGtDao().delete(pkToDelete);
				}
			}
		}
	}


	@Transactional
	public void salvaComponenteAG(String codImpianto, ComponenteAG componente, ArrayList<ComponenteAG> compList, String cfUtenteMod, Boolean nuovaComponente) throws DbManagerException {
		log.debug("[DbMgr::salvaComponenteAG] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, componente.getProgrComponente());
			filter.setTipoComponente(Constants.TIPO_COMPONENTE_AG);

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompAgDao().customDeleterByFilter(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_ag", "codice_impianto="+codImpianto+"&progressivo="+componente.getProgrComponente()));

			/*
			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_AG);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(componente.getProgrComponente()));

			getSigitTCompXDao().customDeleterByFilter(filterX);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_AG+"&progressivo="+componente.getProgrComponente()));
			*/

			BigDecimal codiceImpianto = ConvertUtil.convertToBigDecimal(codImpianto);
			BigDecimal progressivo = ConvertUtil.convertToBigDecimal(componente.getProgrComponente());

			SigitTComp4Pk pkComp4 = null;
			//se si tratta di una nuova componente, contestualmente all'inserimento in compAg, ci deve essere l'inserimento anche in comp4
			if( nuovaComponente != null && nuovaComponente) {
				pkComp4 = salvaComp4(codiceImpianto, progressivo, Constants.TIPO_COMPONENTE_AG);
			} else {
				pkComp4 = new SigitTComp4Pk(codiceImpianto, Constants.TIPO_COMPONENTE_AG, progressivo);
			}
			//aggiornamento del timestamp per il controlloWeb
			aggiornaComp4DtControlloWeb(pkComp4);

			// Devo aggiungere il componetente principale piu' tutte le sostituzioni
			//getSigitTCompXDao().insert(MapDto.getSigitTCompX(componente, codiceImpianto, cfUtenteMod));
			getSigitTCompAgDao().insert(MapDto.getSigitTCompAG(componente, codiceImpianto, cfUtenteMod));

			if (compList != null && compList.size() > 0)
			{
				for (ComponenteAG componenteAG : compList) {

					// Devo aggiungere il componetente principale piu' tutte le sostituzioni
					//getSigitTCompXDao().insert(MapDto.getSigitTCompX(componenteAG, codiceImpianto, cfUtenteMod));
					getSigitTCompAgDao().insert(MapDto.getSigitTCompAG(componenteAG, codiceImpianto, cfUtenteMod));
				}
			}


		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaComponenteAG] END");
		}
	}

	@Transactional
	public void cancellaComponenteAG(String codImpianto, String progressivo, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponenteAG] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, progressivo);
			filter.setTipoComponente(Constants.TIPO_COMPONENTE_AG);

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompAgDao().customDeleterByFilter(filter);

			SigitTComp4Pk pkComp4 = new SigitTComp4Pk(ConvertUtil.convertToBigDecimal(codImpianto), Constants.TIPO_COMPONENTE_AG, ConvertUtil.convertToBigDecimal(progressivo));

			//N.B. eliminando definitivamente la componente CS verra' eliminata anche la riga nella tabella comp4
			getSigitTComp4Dao().delete(pkComp4);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_ag", "codice_impianto="+codImpianto+"&progressivo="+progressivo));

			/*
			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_AG);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));

			// Cancello tutte le componenti di quel tipo con quel progressivo
			getSigitTCompXDao().customDeleterByFilter(filterX);
			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_AG+"&progressivo="+progressivo));
			*/

		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			Message msg = null;
			if (e instanceof DbManagerException) {
				msg = ((DbManagerException) e).getMsg();
			}
			throw new DbManagerException(e, msg == null? new Message(Messages.ERROR_RECUPERO_DB) : msg);

		}
		finally {
			log.debug("[DbMgr::cancellaComponenteAG] END");
		}
	}

	@Transactional
	public void salvaComponenteSR(String codImpianto, ComponenteSR componente, ArrayList<ComponenteSR> compList, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaComponenteSR] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, componente.getProgrComponente());

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompSrDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_sr", "codice_impianto="+codImpianto+"&progressivo="+componente.getProgrComponente()));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_SR);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(componente.getProgrComponente()));

			getSigitTCompXDao().customDeleterByFilter(filterX);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_SR+"&progressivo="+componente.getProgrComponente()));

			BigDecimal codiceImpianto = ConvertUtil.convertToBigDecimal(codImpianto);

			// Devo aggiungere il componetente principale piu' tutte le sostituzioni
			getSigitTCompXDao().insert(MapDto.getSigitTCompX(componente, codiceImpianto, cfUtenteMod));
			getSigitTCompSrDao().insert(MapDto.getSigitTCompSR(componente, codiceImpianto));

			if (compList != null && compList.size() > 0)
			{
				for (ComponenteSR componenteSR : compList) {

					// Devo aggiungere il componetente principale piu' tutte le sostituzioni
					getSigitTCompXDao().insert(MapDto.getSigitTCompX(componenteSR, codiceImpianto, cfUtenteMod));
					getSigitTCompSrDao().insert(MapDto.getSigitTCompSR(componenteSR, codiceImpianto));
				}
			}


		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaComponenteSR] END");
		}
	}

	@Transactional
	public void cancellaComponenteSR(String codImpianto, String progressivo, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponenteSR] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, progressivo);

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompSrDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_sr", "codice_impianto="+codImpianto+"&progressivo="+progressivo));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_SR);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));

			// Cancello tutte le componenti di quel tipo con quel progressivo
			getSigitTCompXDao().customDeleterByFilter(filterX);
			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_SR+"&progressivo="+progressivo));

		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cancellaComponenteSR] END");
		}
	}

	@Transactional
	public void salvaComponenteVR(String codImpianto, ComponenteVR componente, ArrayList<ComponenteVR> compList, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaComponenteVR] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, componente.getProgrComponente());

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompVrDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_vr", "codice_impianto="+codImpianto+"&progressivo="+componente.getProgrComponente()));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_VR);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(componente.getProgrComponente()));

			getSigitTCompXDao().customDeleterByFilter(filterX);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_VR+"&progressivo="+componente.getProgrComponente()));

			BigDecimal codiceImpianto = ConvertUtil.convertToBigDecimal(codImpianto);

			// Devo aggiungere il componetente principale piu' tutte le sostituzioni
			getSigitTCompXDao().insert(MapDto.getSigitTCompX(componente, codiceImpianto, cfUtenteMod));
			getSigitTCompVrDao().insert(MapDto.getSigitTCompVR(componente, codiceImpianto));

			// devo andare a modificare il campo l5_1_flg_valvole_regolazione della tabella sigit_t_compx_semplice
			// modificare se esiste, inserire se non esiste
			SigitTCompXSempliceDto compXSemplice = getSigitTCompXSempliceDao().findByPrimaryKey(new SigitTCompXSemplicePk(codiceImpianto));
			if (compXSemplice != null)
			{
				// devo aggiornare il campo, se modificato
				if (!ConvertUtil.convertToBooleanAllways(compXSemplice.getL51FlgValvoleRegolazione()))
				{
					compXSemplice.setL51FlgValvoleRegolazione(ConvertUtil.convertToBigDecimal(Constants.SI_1));
					compXSemplice.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
					compXSemplice.setDataUltMod(DateUtil.getSqlDataCorrente());
					getSigitTCompXSempliceDao().update(compXSemplice);
				}

			}
			else
			{
				// devo inserire la riga
				compXSemplice = new SigitTCompXSempliceDto();
				compXSemplice.setCodiceImpianto(codiceImpianto);
				compXSemplice.setL51FlgValvoleRegolazione(ConvertUtil.convertToBigDecimal(Constants.SI_1));
			}

			if (compList != null && compList.size() > 0)
			{
				for (ComponenteVR componenteVR : compList) {

					// Devo aggiungere il componetente principale piu' tutte le sostituzioni
					getSigitTCompXDao().insert(MapDto.getSigitTCompX(componenteVR, codiceImpianto, cfUtenteMod));
					getSigitTCompVrDao().insert(MapDto.getSigitTCompVR(componenteVR, codiceImpianto));
				}
			}


		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaComponenteVR] END");
		}
	}

	@Transactional
	public void cancellaComponenteVR(String codImpianto, String progressivo, boolean isUltimoCom, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponenteVR] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, progressivo);

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompVrDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_vr", "codice_impianto="+codImpianto+"&progressivo="+progressivo));

			if (isUltimoCom)
			{
				SigitTCompXSempliceDto compXSemplice = getSigitTCompXSempliceDao().findByPrimaryKey(new SigitTCompXSemplicePk(ConvertUtil.convertToBigDecimal(codImpianto)));
				compXSemplice.setL51FlgValvoleRegolazione(ConvertUtil.convertToBigDecimal(Constants.NO_0));
				compXSemplice.setUtenteUltMod(cfUtenteMod);
				compXSemplice.setDataUltMod(DateUtil.getSqlDataCorrente());
				getSigitTCompXSempliceDao().update(compXSemplice);
			}

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_VR);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));

			// Cancello tutte le componenti di quel tipo con quel progressivo
			getSigitTCompXDao().customDeleterByFilter(filterX);
			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_VR+"&progressivo="+progressivo));

		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cancellaComponenteVR] END");
		}
	}

	@Transactional
	public void salvaComponentePO(String codImpianto, ComponentePO componente, ArrayList<ComponentePO> compList, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaComponentePO] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, componente.getProgrComponente());

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompPoDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_po", "codice_impianto="+codImpianto+"&progressivo="+componente.getProgrComponente()));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_PO);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(componente.getProgrComponente()));

			getSigitTCompXDao().customDeleterByFilter(filterX);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_PO+"&progressivo="+componente.getProgrComponente()));

			BigDecimal codiceImpianto = ConvertUtil.convertToBigDecimal(codImpianto);

			// Devo aggiungere il componetente principale piu' tutte le sostituzioni
			getSigitTCompXDao().insert(MapDto.getSigitTCompX(componente, codiceImpianto, cfUtenteMod));
			getSigitTCompPoDao().insert(MapDto.getSigitTCompPO(componente, codiceImpianto));

			if (compList != null && compList.size() > 0)
			{
				for (ComponentePO componentePO : compList) {

					// Devo aggiungere il componetente principale piu' tutte le sostituzioni
					getSigitTCompXDao().insert(MapDto.getSigitTCompX(componentePO, codiceImpianto, cfUtenteMod));
					getSigitTCompPoDao().insert(MapDto.getSigitTCompPO(componentePO, codiceImpianto));
				}
			}


		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaComponentePO] END");
		}
	}

	@Transactional
	public void cancellaComponentePO(String codImpianto, String progressivo, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponentePO] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, progressivo);

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompPoDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_po", "codice_impianto="+codImpianto+"&progressivo="+progressivo));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_PO);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));

			// Cancello tutte le componenti di quel tipo con quel progressivo
			getSigitTCompXDao().customDeleterByFilter(filterX);
			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_PO+"&progressivo="+progressivo));

		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cancellaComponentePO] END");
		}
	}

	/////////////////////////////////

	@Transactional
	public void salvaComponenteVM(String codImpianto, ComponenteVM componente, ArrayList<ComponenteVM> compList, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaComponenteVM] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, componente.getProgrComponente());

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompVmDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_vm", "codice_impianto="+codImpianto+"&progressivo="+componente.getProgrComponente()));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_VM);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(componente.getProgrComponente()));

			getSigitTCompXDao().customDeleterByFilter(filterX);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_VM+"&progressivo="+componente.getProgrComponente()));

			BigDecimal codiceImpianto = ConvertUtil.convertToBigDecimal(codImpianto);

			// Devo aggiungere il componetente principale piu' tutte le sostituzioni
			getSigitTCompXDao().insert(MapDto.getSigitTCompX(componente, codiceImpianto, cfUtenteMod));
			getSigitTCompVmDao().insert(MapDto.getSigitTCompVM(componente, codiceImpianto));

			if (compList != null && compList.size() > 0)
			{
				for (ComponenteVM componenteVM : compList) {

					// Devo aggiungere il componetente principale piu' tutte le sostituzioni
					getSigitTCompXDao().insert(MapDto.getSigitTCompX(componenteVM, codiceImpianto, cfUtenteMod));
					getSigitTCompVmDao().insert(MapDto.getSigitTCompVM(componenteVM, codiceImpianto));
				}
			}


		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaComponenteVM] END");
		}
	}

	@Transactional
	public void cancellaComponenteVM(String codImpianto, String progressivo, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::cancellaComponenteVM] BEGIN");
		try {

			CompFilter filter = new CompFilter(codImpianto, progressivo);

			// Cancello tutte le componenti con quel progressivo
			getSigitTCompVmDao().customDeleterByCodImpiantoProgr(filter);

			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_vm", "codice_impianto="+codImpianto+"&progressivo="+progressivo));

			SigitTCompXDto filterX = new SigitTCompXDto();
			filterX.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filterX.setIdTipoComponente(Constants.TIPO_COMPONENTE_VM);
			filterX.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));

			// Cancello tutte le componenti di quel tipo con quel progressivo
			getSigitTCompXDao().customDeleterByFilter(filterX);
			// Devo tracciare la cancellazione
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente="+Constants.TIPO_COMPONENTE_VM+"&progressivo="+progressivo));

		}
		catch(Exception e) {

			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cancellaComponenteVM] END");
		}
	}

	/////////////////////////////////


	public List<SigitVCompGtDettDto> getCompGtProgrDett(String codImpianto, Integer progressivo, Integer idAllegato) throws DbManagerException
	{
		log.debug("[DbMgr::getCompGtProgrDett] BEGIN");

		List<SigitVCompGtDettDto> dtoList = null;

		try {
			CompFilter filter = new CompFilter(codImpianto, ConvertUtil.convertToString(progressivo), idAllegato);

			dtoList = getSigitVCompGtDettDao().findByCodImpProgrAllegatoOrdered(filter);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cancellaComponenteAC] END");
		}

		return dtoList;
	}

	public List<SigitVCompGfDettDto> getCompGfProgrDett(String codImpianto, Integer progressivo, Integer idAllegato) throws DbManagerException
	{
		log.debug("[DbMgr::getCompGfProgrDett] BEGIN");

		List<SigitVCompGfDettDto> dtoList = null;

		try {
			CompFilter filter = new CompFilter(codImpianto, ConvertUtil.convertToString(progressivo), idAllegato);

			dtoList = getSigitVCompGfDettDao().findByCodImpProgrAllegatoOrdered(filter);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cancellaComponenteAC] END");
		}

		return dtoList;
	}

	public List<SigitVCompScDettDto> getCompScProgrDett(String codImpianto, Integer progressivo, Integer idAllegato) throws DbManagerException
	{
		log.debug("[DbMgr::getCompScProgrDett] BEGIN");

		List<SigitVCompScDettDto> dtoList = null;

		try {
			CompFilter filter = new CompFilter(codImpianto, ConvertUtil.convertToString(progressivo), idAllegato);

			dtoList = getSigitVCompScDettDao().findByCodImpProgrAllegatoOrdered(filter);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cancellaComponenteAC] END");
		}

		return dtoList;
	}

	public List<SigitVCompCgDettDto> getCompCgProgrDett(String codImpianto, Integer progressivo, Integer idAllegato) throws DbManagerException
	{
		log.debug("[DbMgr::getCompCgProgrDett] BEGIN");

		List<SigitVCompCgDettDto> dtoList = null;

		try {
			CompFilter filter = new CompFilter(codImpianto, ConvertUtil.convertToString(progressivo), idAllegato);

			dtoList = getSigitVCompCgDettDao().findByCodImpProgrAllegatoOrdered(filter);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cancellaComponenteAC] END");
		}

		return dtoList;
	}

	public void inserisciTDettTipo2(BigDecimal idAllegato, SigitVSk4GfDto dtoT, int numeroCircuito, String cfUtenteLoggato)
	{
		SigitTDettTipo2Dto sigitTDettTipo2Dto = new SigitTDettTipo2Dto();
		sigitTDettTipo2Dto.setCodiceImpianto(dtoT.getCodiceImpianto());
		sigitTDettTipo2Dto.setFkAllegato(idAllegato);
		sigitTDettTipo2Dto.setFkTipoComponente(dtoT.getIdTipoComponente());
		sigitTDettTipo2Dto.setProgressivo(dtoT.getProgressivo());
		sigitTDettTipo2Dto.setDataInstall(dtoT.getDataInstall());
		sigitTDettTipo2Dto.setENCircuito(ConvertUtil.convertToString(numeroCircuito));
		sigitTDettTipo2Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
		sigitTDettTipo2Dto.setUtenteUltMod(cfUtenteLoggato);

		getSigitTDettTipo2Dao().insert(sigitTDettTipo2Dto);

	}

	public void inserisciTDettTipo1(BigDecimal idAllegato, SigitVSk4GtDto dtoT, int numeroModulo, String cfUtenteLoggato)
	{
		SigitTDettTipo1Dto sigitTDettTipo1Dto = new SigitTDettTipo1Dto();
		sigitTDettTipo1Dto.setCodiceImpianto(dtoT.getCodiceImpianto());
		sigitTDettTipo1Dto.setFkAllegato(idAllegato);
		sigitTDettTipo1Dto.setFkTipoComponente(dtoT.getIdTipoComponente());
		sigitTDettTipo1Dto.setProgressivo(dtoT.getProgressivo());
		sigitTDettTipo1Dto.setDataInstall(dtoT.getDataInstall());
		sigitTDettTipo1Dto.setENModuloTermico(numeroModulo);
		sigitTDettTipo1Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
		sigitTDettTipo1Dto.setUtenteUltMod(cfUtenteLoggato);

		getSigitTDettTipo1Dao().insert(sigitTDettTipo1Dto);

	}

	public void inserisciTRappTipo1(BigDecimal idAllegato)
	{
		SigitTRappTipo1Dto sigitTRappTipo1Dto = new SigitTRappTipo1Dto();
		sigitTRappTipo1Dto.setIdAllegato(idAllegato);

		getSigitTRappTipo1Dao().insert(sigitTRappTipo1Dto);

	}

	public void inserisciTRappTipo2(BigDecimal idAllegato)
	{
		SigitTRappTipo2Dto sigitTRappTipo2Dto = new SigitTRappTipo2Dto();
		sigitTRappTipo2Dto.setIdAllegato(idAllegato);

		getSigitTRappTipo2Dao().insert(sigitTRappTipo2Dto);

	}

	public void inserisciTDettTipo3(BigDecimal idAllegato, SigitVSk4ScDto dtoT, String cfUtenteLoggato)
	{
		SigitTDettTipo3Dto sigitTDettTipo3Dto = new SigitTDettTipo3Dto();
		sigitTDettTipo3Dto.setCodiceImpianto(dtoT.getCodiceImpianto());
		sigitTDettTipo3Dto.setFkAllegato(idAllegato);
		sigitTDettTipo3Dto.setFkTipoComponente(dtoT.getIdTipoComponente());
		sigitTDettTipo3Dto.setProgressivo(dtoT.getProgressivo());
		sigitTDettTipo3Dto.setDataInstall(dtoT.getDataInstall());
		sigitTDettTipo3Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
		sigitTDettTipo3Dto.setUtenteUltMod(cfUtenteLoggato);

		getSigitTDettTipo3Dao().insert(sigitTDettTipo3Dto);

	}

	public void inserisciTRappTipo3(BigDecimal idAllegato)
	{
		SigitTRappTipo3Dto sigitTRappTipo3Dto = new SigitTRappTipo3Dto();
		sigitTRappTipo3Dto.setIdAllegato(idAllegato);

		getSigitTRappTipo3Dao().insert(sigitTRappTipo3Dto);

	}


	public void inserisciTDettTipo4(BigDecimal idAllegato, SigitVSk4CgDto dtoT, String cfUtenteLoggato)
	{
		SigitTDettTipo4Dto sigitTDettTipo4Dto = new SigitTDettTipo4Dto();
		sigitTDettTipo4Dto.setCodiceImpianto(dtoT.getCodiceImpianto());
		sigitTDettTipo4Dto.setFkAllegato(idAllegato);
		sigitTDettTipo4Dto.setFkTipoComponente(dtoT.getIdTipoComponente());
		sigitTDettTipo4Dto.setProgressivo(dtoT.getProgressivo());
		sigitTDettTipo4Dto.setDataInstall(dtoT.getDataInstall());
		//sigitTDettTipo4Dto.setENModuloTermico(ConvertUtil.convertToString(numeroModulo));
		sigitTDettTipo4Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
		sigitTDettTipo4Dto.setUtenteUltMod(cfUtenteLoggato);

		getSigitTDettTipo4Dao().insert(sigitTDettTipo4Dto);

	}

	public void inserisciTRappTipo4(BigDecimal idAllegato)
	{
		SigitTRappTipo4Dto sigitTRappTipo4Dto = new SigitTRappTipo4Dto();
		sigitTRappTipo4Dto.setIdAllegato(idAllegato);

		getSigitTRappTipo4Dao().insert(sigitTRappTipo4Dto);

	}

	public List<SigitTDettIspezGtDto> getDettRappProvaGT(String codImpianto, Integer progressivo, String idAllegato) throws DbManagerException
	{
		log.debug("[DbMgr::getDettRappProvaGT] BEGIN");

		List<SigitTDettIspezGtDto> dtoList = null;
		try {


			SigitTDettIspezGtDto dto = new SigitTDettIspezGtDto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));

			dtoList = getSigitTDettIspezGtDao().findByExample(dto);

		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getDettRappProvaGT] END");
		}

		return dtoList;
	}

	public List<SigitTDettTipo1Dto> getDettTipo1(String codImpianto, Integer progressivo, String idAllegato) throws DbManagerException
	{

		log.debug("[DbMgr::getDettTipo1] BEGIN");

		List<SigitTDettTipo1Dto> dtoList = null;

		try {

			SigitTDettTipo1Dto dto = new SigitTDettTipo1Dto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));

			dtoList = getSigitTDettTipo1Dao().findByAllegatoCodImpianto(dto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getDettTipo1] END");
		}

		return dtoList;
	}

	public SigitTDettTipo1Dto getDettTipo1(String codImpianto, Integer progressivo, String idAllegato, Integer numModulo) throws DbManagerException
	{
		log.debug("[DbMgr::getDettTipo1] BEGIN");

		SigitTDettTipo1Dto dtoRes = null;
		try {
			List<SigitTDettTipo1Dto> dtoList = null;

			SigitTDettTipo1Dto dto = new SigitTDettTipo1Dto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));
			dto.setENModuloTermico(numModulo);

			dtoList = getSigitTDettTipo1Dao().findByAllegatoCodImpianto(dto);

			if (dtoList != null && dtoList.size() > 0)
			{
				dtoRes = dtoList.get(0);
			}

		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getDettTipo1] END");
		}

		return dtoRes;
	}

	public SigitTDettIspezGfDto getDettRappProvaGF(String codImpianto, Integer progressivo, String idAllegato, Integer numCircuito) throws DbManagerException
	{
		log.debug("[DbMgr::getDettRappProvaGF] BEGIN");

		SigitTDettIspezGfDto dtoRes = null;
		try {
			List<SigitTDettIspezGfDto> dtoList = null;

			SigitTDettIspezGfDto dto = new SigitTDettIspezGfDto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));
			dto.setS8aNCircuito(ConvertUtil.convertToString(numCircuito));

			dtoList = getSigitTDettIspezGfDao().findByExample(dto);

			if (dtoList != null && dtoList.size() > 0)
			{
				dtoRes = dtoList.get(0);
			}

		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getDettRappProvaGF] END");
		}

		return dtoRes;
	}


	public SigitTDettIspezGtDto getDettRappProvaGT(String codImpianto, Integer progressivo, String idAllegato, Integer numModulo) throws DbManagerException
	{
		log.debug("[DbMgr::getDettRappProvaGT] BEGIN");

		SigitTDettIspezGtDto dtoRes = null;
		try {
			List<SigitTDettIspezGtDto> dtoList = null;

			SigitTDettIspezGtDto dto = new SigitTDettIspezGtDto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));
			dto.setS8aNModuloTermico(ConvertUtil.convertToString(numModulo));

			dtoList = getSigitTDettIspezGtDao().findByExample(dto);

			if (dtoList != null && dtoList.size() > 0)
			{
				dtoRes = dtoList.get(0);
			}

		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getDettRappProvaGT] END");
		}

		return dtoRes;
	}

	public List<SigitTDettIspezGfDto> getDettRappProvaGF(String codImpianto, Integer progressivo, String idAllegato) throws DbManagerException
	{
		log.debug("[DbMgr::getDettRappProvaGF] BEGIN");

		List<SigitTDettIspezGfDto> dtoList = null;
		try {
			SigitTDettIspezGfDto dto = new SigitTDettIspezGfDto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));

			dtoList = getSigitTDettIspezGfDao().findByExample(dto);

		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::SigitTDettIspezGfDto] END");
		}

		return dtoList;
	}


	public List<SigitTDettTipo2Dto> getDettTipo2(String codImpianto, Integer progressivo, String idAllegato) throws DbManagerException
	{
		log.debug("[DbMgr::getDettTipo2] BEGIN");

		List<SigitTDettTipo2Dto> dtoList = null;

		try {

			SigitTDettTipo2Dto dto = new SigitTDettTipo2Dto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));
			//dto.setENCircuito(numCircuito);

			dtoList = getSigitTDettTipo2Dao().findByAllegatoCodImpianto(dto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getDettTipo2] END");
		}

		return dtoList;
	}


	public SigitTDettTipo2Dto getDettTipo2(String codImpianto, Integer progressivo, String idAllegato, String numCircuito) throws DbManagerException
	{
		log.debug("[DbMgr::getDettTipo2] BEGIN");


		SigitTDettTipo2Dto dtoRes = null;
		try {
			List<SigitTDettTipo2Dto> dtoList = null;

			SigitTDettTipo2Dto dto = new SigitTDettTipo2Dto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));
			dto.setENCircuito(numCircuito);

			dtoList = getSigitTDettTipo2Dao().findByAllegatoCodImpianto(dto);

			if (dtoList != null && dtoList.size() > 0)
			{
				dtoRes = dtoList.get(0);
			}
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getDettTipo2] END");
		}

		return dtoRes;
	}


	public List<SigitTDettTipo3Dto> getDettTipo3(String codImpianto, Integer progressivo, String idAllegato) throws DbManagerException
	{
		log.debug("[DbMgr::getDettTipo3] BEGIN");

		List<SigitTDettTipo3Dto> dtoList = null;

		try {

			SigitTDettTipo3Dto dto = new SigitTDettTipo3Dto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));

			dtoList = getSigitTDettTipo3Dao().findByAllegatoCodImpianto(dto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getDettTipo3] END");
		}

		return dtoList;
	}

	public List<SigitTDettTipo4Dto> getDettTipo4(String codImpianto, Integer progressivo, String idAllegato) throws DbManagerException
	{
		log.debug("[DbMgr::getDettTipo4] BEGIN");

		List<SigitTDettTipo4Dto> dtoList = null;

		try {

			SigitTDettTipo4Dto dto = new SigitTDettTipo4Dto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));

			dtoList = getSigitTDettTipo4Dao().findByAllegatoCodImpianto(dto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getDettTipo4] END");
		}

		return dtoList;
	}

	@Transactional
	public void salvaScheda7(SigitTCompXSempliceDto dto, boolean insert, String cfUtente) throws DbManagerException {
		log.debug("[DbMgr::salvaScheda7] BEGIN");
		try {

			if (insert) {
				getSigitTCompXSempliceDao().insert(dto);
			} else {
				getSigitTCompXSempliceDao().updateColumnsSez7(dto);
			}


			SigitTControlloLibrettoDto controlloLib = getSigitTControlloLibrettoDao().findByPrimaryKey(new SigitTControlloLibrettoPk(dto.getCodiceImpianto()));

			boolean insertControlloLib = false;
			if (controlloLib == null) {
				controlloLib = new SigitTControlloLibrettoDto();
				controlloLib.setCodiceImpianto(dto.getCodiceImpianto());
				insertControlloLib = true;
			}

			controlloLib.setFlgL7Controlloweb(ConvertUtil.convertToBigDecimal(Constants.SI_1));
			controlloLib.setUtenteUltAgg(ReplaceSpecialCharUtils.sanitize(cfUtente));
			controlloLib.setDtUltMod(DateUtil.getSqlDataCorrente());

			if (insertControlloLib) {
				getSigitTControlloLibrettoDao().insert(controlloLib);
			} else {
				getSigitTControlloLibrettoDao().updateColumnsAggiornaControlloScheda7(controlloLib);
			}

		} catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaScheda7] END");
		}
	}

	@Transactional
	public void salvaScheda5_2(SigitTCompXSempliceDto dto, boolean insert, String cfUtente) throws DbManagerException {
		log.debug("[DbMgr::salvaScheda5_2] BEGIN");
		try {

			if (insert) {
				getSigitTCompXSempliceDao().insert(dto);
			} else {
				getSigitTCompXSempliceDao().updateColumnsSez5(dto);
			}


			SigitTControlloLibrettoDto controlloLib = getSigitTControlloLibrettoDao().findByPrimaryKey(new SigitTControlloLibrettoPk(dto.getCodiceImpianto()));

			boolean insertControlloLibretto = false;
			if (controlloLib == null) {
				controlloLib = new SigitTControlloLibrettoDto();
				controlloLib.setCodiceImpianto(dto.getCodiceImpianto());
				insertControlloLibretto = true;
			}

			controlloLib.setFlgL5Controlloweb(ConvertUtil.convertToBigDecimal(Constants.SI_1));
			controlloLib.setUtenteUltAgg(ReplaceSpecialCharUtils.sanitize(cfUtente));
			controlloLib.setDtUltMod(DateUtil.getSqlDataCorrente());

			if (insertControlloLibretto) {
				getSigitTControlloLibrettoDao().insert(controlloLib);
			} else {
				getSigitTControlloLibrettoDao().updateColumnsAggiornaControlloScheda5(controlloLib);
			}

		} catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaScheda5_2] END");
		}
	}

	@Transactional
	public void salvaScheda6(SigitTCompXSempliceDto entity, Map<Integer, SigitTCompVxDto> entityVXRows, Map<Integer, SigitTCompXDto> entityXRows, boolean insert, String cfUtente) throws DbManagerException {
		log.debug("[DbMgr::salvaScheda6] BEGIN");
		try {
			if (insert) {
				getSigitTCompXSempliceDao().insert(entity);
			} else {
				getSigitTCompXSempliceDao().updateColumnsSez6(entity);
			}

			//cancellazione righe tabella figlia
			getSigitTCompVxDao().customDeleterByCodImpianto(ConvertUtil.convertToInteger(entity.getCodiceImpianto()));

			//cancellazione righe tabella madre
			SigitTCompXDto filter = new SigitTCompXDto();
			filter.setCodiceImpianto(entity.getCodiceImpianto());
			filter.setIdTipoComponente(Constants.TIPO_COMPONENTE_VX);
			getSigitTCompXDao().customDeleterByFilter(filter);

			//inserimento riga padre + riga figlia
			if (entityVXRows != null && !entityVXRows.isEmpty()) {
				for (Integer progressivo : entityVXRows.keySet()) {
					SigitTCompVxDto entityVx = entityVXRows.get(progressivo);
					SigitTCompXDto entityX = entityXRows.get(progressivo);
					getSigitTCompXDao().insert(entityX);
					getSigitTCompVxDao().insert(entityVx);
				}
			}

			SigitTControlloLibrettoDto controlloLib = getSigitTControlloLibrettoDao().findByPrimaryKey(new SigitTControlloLibrettoPk(entity.getCodiceImpianto()));

			boolean insertControlloLib = false;
			if (controlloLib == null) {
				controlloLib = new SigitTControlloLibrettoDto();
				controlloLib.setCodiceImpianto(entity.getCodiceImpianto());
				insertControlloLib = true;
			}

			controlloLib.setFlgL6Controlloweb(ConvertUtil.convertToBigDecimal(Constants.SI_1));
			controlloLib.setUtenteUltAgg(ReplaceSpecialCharUtils.sanitize(cfUtente));
			controlloLib.setDtUltMod(DateUtil.getSqlDataCorrente());

			if (insertControlloLib) {
				getSigitTControlloLibrettoDao().insert(controlloLib);
			} else {
				getSigitTControlloLibrettoDao().updateColumnsAggiornaControlloScheda6(controlloLib);
			}

		} catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaScheda6] END");
		}
	}

	@Transactional
	public void salvaScheda2(SigitTTrattH2ODto dto, boolean insert) throws DbManagerException {
		log.debug("[DbMgr::salvaScheda2] BEGIN");
		try {

//			boolean insert = getSigitTTrattH2oDao().findByPrimaryKey(new SigitTTrattH2OPk(dto.getCodiceImpianto())) == null;

			if (insert) {
				getSigitTTrattH2oDao().insert(dto);
			} else {
				getSigitTTrattH2oDao().update(dto);
			}

		} catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaScheda7] END");
		}
	}

	public SigitTRappIspezGtDto cercaTRappIspezGtById (BigDecimal idAllegato) throws DbManagerException {
		SigitTRappIspezGtDto dto = null;
		log.debug("[DbMgr::cercaTRappIspezGtById] BEGIN");
		try {

			dto = getSigitTRappIspezGtDao().findByPrimaryKey(new SigitTRappIspezGtPk(idAllegato));

		} catch (SigitTRappIspezGtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaTRappTipo1ById] END");
		}
		return dto;
	}

	public SigitTRappIspezGfDto cercaTRappIspezGfById (BigDecimal idAllegato) throws DbManagerException {
		SigitTRappIspezGfDto dto = null;
		log.debug("[DbMgr::cercaTRappIspezGfById] BEGIN");
		try {

			dto = getSigitTRappIspezGfDao().findByPrimaryKey(new SigitTRappIspezGfPk(idAllegato));

		} catch (SigitTRappIspezGfDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaTRappIspezGfById] END");
		}
		return dto;
	}


	public SigitTRappTipo1Dto cercaTRappTipo1ById(BigDecimal idAllegato) throws DbManagerException {
		SigitTRappTipo1Dto dto = null;
		log.debug("[DbMgr::cercaTRappTipo1ById] BEGIN");
		try {

			dto = getSigitTRappTipo1Dao().findByPrimaryKey(new SigitTRappTipo1Pk(idAllegato));

		}
		catch(SigitTRappTipo1DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaTRappTipo1ById] END");
		}
		return dto;
	}

	public SigitTRappTipo4Dto cercaTRappTipo4ById(BigDecimal idAllegato) throws DbManagerException {
		SigitTRappTipo4Dto dto = null;
		log.debug("[DbMgr::cercaTRappTipo4ById] BEGIN");
		try {

			dto = getSigitTRappTipo4Dao().findByPrimaryKey(new SigitTRappTipo4Pk(idAllegato));

		}
		catch(SigitTRappTipo4DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaTRappTipo4ById] END");
		}
		return dto;
	}

	public SigitTRappTipo3Dto cercaTRappTipo3ById(BigDecimal idAllegato) throws DbManagerException {
		SigitTRappTipo3Dto dto = null;
		log.debug("[DbMgr::cercaTRappTipo3ById] BEGIN");
		try {

			dto = getSigitTRappTipo3Dao().findByPrimaryKey(new SigitTRappTipo3Pk(idAllegato));

		}
		catch(SigitTRappTipo3DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaTRappTipo3ById] END");
		}
		return dto;
	}

	public SigitTRappTipo2Dto cercaTRappTipo2ById(BigDecimal idAllegato) throws DbManagerException {
		SigitTRappTipo2Dto dto = null;
		log.debug("[DbMgr::cercaTRappTipo2ById] BEGIN");
		try {

			dto = getSigitTRappTipo2Dao().findByPrimaryKey(new SigitTRappTipo2Pk(idAllegato));

		}
		catch(SigitTRappTipo2DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaTRappTipo2ById] END");
		}
		return dto;
	}

//	public List<SigitRAllegatoCompGtDto> cercaRAllegatoCompGtById(Integer idAllegato) throws DbManagerException {
//		List<SigitRAllegatoCompGtDto> dtoList = null;
//		log.debug("[DbMgr::cercaRAllegatoCompGtById] BEGIN");
//		try {
//
//			CompFilter filter = new CompFilter();
//			filter.setIdAllegato(idAllegato);
//			dtoList = getSigitRAllegatoCompGtDao().findByFilter(filter);
//
//
//		}
//		catch(SigitRAllegatoCompGtDaoException e) {
//			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
//		}
//		finally {
//			log.debug("[DbMgr::cercaRAllegatoCompGtById] END");
//		}
//		return dtoList;
//	}

	public SigitVSk4GtDto getCompGtByIdAllegatoProgr(Integer idAllegato, String progressivo) throws DbManagerException {
		SigitVSk4GtDto dto = null;
		log.debug("[DbMgr::getCompGtByIdAllegatoProgr] BEGIN");
		try {


//			CompFilter filter = new CompFilter(ConvertUtil.convertToString(allegatoCompGt.getCodiceImpianto()),
//					ConvertUtil.convertToString(allegatoCompGt.getProgressivo()), allegatoCompGt.getDataInstall());
//
//			List<SigitVCompGtDto> gtList = getSigitVCompGtDao().findByCodImpiantoOrdered(filter);

			CompFilter input = new CompFilter();
			input.setIdAllegato(idAllegato);
			input.setProgressivo(progressivo);

			List<SigitVSk4GtDto> gtList =  getSigitVSk4GtDao().findByIdAllegatoProgr(input);


			//List<SigitVSk4GtDto> gtList = getCompGtByIdAllegato(ConvertUtil.convertToString(allegatoCompGt.getCodiceImpianto()), allegatoCompGt.getDataInstall());

			if (gtList != null && gtList.size() > 0)
			{
				dto = gtList.get(0);
			}

		}
		catch(SigitVSk4GtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompGtByIdAllegatoProgr] END");
		}
		return dto;
	}


	public SigitVSk4GfDto getCompGfByIdAllegatoProgr(Integer idAllegato, String progressivo) throws DbManagerException {
		SigitVSk4GfDto dto = null;
		log.debug("[DbMgr::getCompGfByIdAllegatoProgr] BEGIN");
		try {


			CompFilter input = new CompFilter();
			input.setIdAllegato(idAllegato);
			input.setProgressivo(progressivo);

			List<SigitVSk4GfDto> gtList =  getSigitVSk4GfDao().findByIdAllegatoProgr(input);

			if (gtList != null && gtList.size() > 0)
			{
				dto = gtList.get(0);
			}

		}
		catch(SigitVSk4GfDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompGfByIdAllegatoProgr] END");
		}
		return dto;
	}

	public SigitVSk4ScDto getCompScByIdAllegatoProgr(Integer idAllegato, String progressivo) throws DbManagerException {
		SigitVSk4ScDto dto = null;
		log.debug("[DbMgr::getCompScByIdAllegatoProgr] BEGIN");
		try {


//			CompFilter filter = new CompFilter(ConvertUtil.convertToString(allegatoCompGt.getCodiceImpianto()),
//					ConvertUtil.convertToString(allegatoCompGt.getProgressivo()), allegatoCompGt.getDataInstall());
//
//			List<SigitVCompGtDto> gtList = getSigitVCompGtDao().findByCodImpiantoOrdered(filter);

			CompFilter input = new CompFilter();
			input.setIdAllegato(idAllegato);
			input.setProgressivo(progressivo);

			List<SigitVSk4ScDto> gtList =  getSigitVSk4ScDao().findByIdAllegatoProgr(input);


			//List<SigitVSk4GtDto> gtList = getCompGtByIdAllegato(ConvertUtil.convertToString(allegatoCompGt.getCodiceImpianto()), allegatoCompGt.getDataInstall());

			if (gtList != null && gtList.size() > 0)
			{
				dto = gtList.get(0);
			}

		}
		catch(SigitVSk4ScDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompScByIdAllegatoProgr] END");
		}
		return dto;
	}

	public Object getCompByIdAllegatoProgr(Integer idAllegato, String tipoComponente, String progressivo) throws DbManagerException {
		log.debug("[DbMgr::getCompByIdAllegatoProgr] " + tipoComponente + "BEGIN");

		CompFilter input = new CompFilter();
		input.setIdAllegato(idAllegato);
		input.setProgressivo(progressivo);
		List list = null;
		Object dto = null;
		try {
			if (Constants.TIPO_COMPONENTE_GT.equals(tipoComponente)) {
				list = getSigitVSk4GtDao().findByIdAllegatoProgr(input);
			} else if (Constants.TIPO_COMPONENTE_SC.equals(tipoComponente)) {
				list = getSigitVSk4ScDao().findByIdAllegatoProgr(input);
			} else if (Constants.TIPO_COMPONENTE_CG.equals(tipoComponente)) {
				list = getSigitVSk4CgDao().findByIdAllegatoProgr(input);
			} else if (Constants.TIPO_COMPONENTE_GF.equals(tipoComponente)) {
				list = getSigitVSk4GfDao().findByIdAllegatoProgr(input);
			}

			if (list != null && list.size() > 0)
			{
				dto = list.get(0);
			}
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompByIdAllegatoProgr] " + tipoComponente + "END");
		}
		return dto;
	}

	public List<Object> cercaListaRAllegatiComById (Integer idAllegato, String tipoComponente) throws DbManagerException {
		log.debug("[DbMgr::cercaListaRAllegatiComById: " + tipoComponente+ "] BEGIN");


		CompFilter filter = new CompFilter();
		filter.setIdAllegato(idAllegato);

		List dtoList = null;
		Object dto = null;

		try {
			if (Constants.TIPO_COMPONENTE_GT.equals(tipoComponente)) {
				dtoList = getSigitRAllegatoCompGtDao().findByFilter(filter);
			} else if (Constants.TIPO_COMPONENTE_SC.equals(tipoComponente)) {
				dtoList = getSigitRAllegatoCompScDao().findByFilter(filter);
			} else if (Constants.TIPO_COMPONENTE_CG.equals(tipoComponente)) {
				dtoList = getSigitRAllegatoCompCgDao().findByFilter(filter);
			} else if (Constants.TIPO_COMPONENTE_GF.equals(tipoComponente)) {
				dtoList = getSigitRAllegatoCompGfDao().findByFilter(filter);
			}

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaListaRAllegatiComById: " + tipoComponente+ "] END");
		}
		return dtoList;

	}

	public Object cercaRAllegatoComByIdProgr (Integer idAllegato, String tipoComponente, String progressivo) throws DbManagerException {
		log.debug("[DbMgr::cercaRAllegatoComByIdProgr: " + tipoComponente+ "] BEGIN");

		CompFilter filter = new CompFilter();
		filter.setIdAllegato(idAllegato);
		filter.setProgressivo(progressivo);

		List dtoList = null;
		Object dto = null;

		try {
			if (Constants.TIPO_COMPONENTE_GT.equals(tipoComponente)) {
				dtoList = getSigitRAllegatoCompGtDao().findByFilter(filter);
			} else if (Constants.TIPO_COMPONENTE_SC.equals(tipoComponente)) {
				dtoList = getSigitRAllegatoCompScDao().findByFilter(filter);
			} else if (Constants.TIPO_COMPONENTE_CG.equals(tipoComponente)) {
				dtoList = getSigitRAllegatoCompCgDao().findByFilter(filter);
			} else if (Constants.TIPO_COMPONENTE_GF.equals(tipoComponente)) {
				dtoList = getSigitRAllegatoCompGfDao().findByFilter(filter);
			}

			if (dtoList != null && dtoList.size() > 0)
			{
				dto = dtoList.get(0);
			}

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaRAllegatoComByIdProgr: " + tipoComponente+ "] END");
		}
		return dto;
	}


	public SigitVSk4CgDto getCompCgByIdAllegatoProgr(Integer idAllegato, String progressivo) throws DbManagerException {
		SigitVSk4CgDto dto = null;
		log.debug("[DbMgr::getCompCgByIdAllegatoProgr] BEGIN");
		try {


//			CompFilter filter = new CompFilter(ConvertUtil.convertToString(allegatoCompGt.getCodiceImpianto()),
//					ConvertUtil.convertToString(allegatoCompGt.getProgressivo()), allegatoCompGt.getDataInstall());
//
//			List<SigitVCompGtDto> gtList = getSigitVCompGtDao().findByCodImpiantoOrdered(filter);

			CompFilter input = new CompFilter();
			input.setIdAllegato(idAllegato);
			input.setProgressivo(progressivo);

			List<SigitVSk4CgDto> cgList =  getSigitVSk4CgDao().findByIdAllegatoProgr(input);


			//List<SigitVSk4GtDto> gtList = getCompGtByIdAllegato(ConvertUtil.convertToString(allegatoCompGt.getCodiceImpianto()), allegatoCompGt.getDataInstall());

			if (cgList != null && cgList.size() > 0)
			{
				dto = cgList.get(0);
			}

		}
		catch(SigitVSk4CgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompCgByIdAllegatoProgr] END");
		}
		return dto;
	}

	@Transactional
	public void salvaReeTipo1(Tipo1 tipo1, DettaglioAllegato dettaglioAllegato, ArrayList<Integer> consumiTipo1DaCancellare, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaReeTipo1] BEGIN");
		try {

			SigitTAllegatoDto allegatoDto = cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

			allegatoDto.setElencoApparecchiature(ReplaceSpecialCharUtils.sanitize(dettaglioAllegato.getElencoApparecchiature()));

			ReeSuperDto reeSuper = ReeSuperDto.getByTipo1(tipo1);
			popolaAllegatoDaReeSuper(reeSuper, allegatoDto);

			allegatoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
			allegatoDto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
			allegatoDto.setAbcdfControlloweb(DateUtil.getSqlDataCorrente());

			SigitTRappTipo1Dto rappTipo1 = cercaTRappTipo1ById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

			if (rappTipo1 == null)
			{
				rappTipo1 = new SigitTRappTipo1Dto();
			}

			rappTipo1.setCFlgTrattClimaNonRich(ConvertUtil.convertToBigDecimal(tipo1.getFlgTrattClimaNonRich()));
			rappTipo1.setCFlgTrattAcsNonRichiesto(ConvertUtil.convertToBigDecimal(tipo1.getFlgTrattAcsNonRichiesto()));

			rappTipo1.setDFlgLocaleIntIdoneo(ConvertUtil.convertToBigDecimal(tipo1.getFlgLocaleIntIdoneo()));
			rappTipo1.setDFlgGenExtIdoneo(ConvertUtil.convertToBigDecimal(tipo1.getFlgGenExtIdoneo()));
			rappTipo1.setDFlgApertureLibere(ConvertUtil.convertToBigDecimal(tipo1.getFlgApertureLibere()));
			rappTipo1.setDFlgApertureAdeg(ConvertUtil.convertToBigDecimal(tipo1.getFlgApertureAdeguate()));
			rappTipo1.setDFlgScaricoIdoneo(ConvertUtil.convertToBigDecimal(tipo1.getFlgScaricoIdoneo()));
			rappTipo1.setDFlgTempAmbFunz(ConvertUtil.convertToBigDecimal(tipo1.getFlgTempAmbFunz()));
			rappTipo1.setDFlgAssenzaPerdComb(ConvertUtil.convertToBigDecimal(tipo1.getFlgAssenzaPerdComb()));
			rappTipo1.setDFlgIdoTenImpInt(ConvertUtil.convertToBigDecimal(tipo1.getFlgIdoTenImpInt()));
			rappTipo1.setD1bFlgPuliziaCamino(ConvertUtil.convertToBigDecimal(tipo1.getFlgPuliziaCamino()));

			// Se non e' selezionato cosa succede?
			rappTipo1.setFFlgAdozioneValvoleTerm(ConvertUtil.convertToBigDecimal(tipo1.getFlgAdozioneValvoleTerm()));
			rappTipo1.setFFlgIsolamenteRete(ConvertUtil.convertToBigDecimal(tipo1.getFlgIsolamentoRete()));
			rappTipo1.setFFlgAdozSistTrattamH2o(ConvertUtil.convertToBigDecimal(tipo1.getFlgAdozSistTrattamH2O()));
			rappTipo1.setFFlgSostituzSistRegolaz(ConvertUtil.convertToBigDecimal(tipo1.getFlgSostituzSistRegolaz()));

			aggiornaAllegato(allegatoDto);

			// Sono in modifica
			getSigitTRappTipo1Dao().update(rappTipo1);

			salvaConsumiReeTipo1B(tipo1.getConsumi(), consumiTipo1DaCancellare, dettaglioAllegato.getIdAllegato());

		}
		catch(SigitTRappTipo1DaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		catch(DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw e;
		}
		finally {
			log.debug("[DbMgr::salvaReeTipo1] END");
		}
	}

	public void salvaConsumiReeTipo1B(ArrayList<Tipo1Consumo> listConsumi, ArrayList<Integer> listPkChiaviCancellare, String idAllegato) throws DbManagerException {

		log.debug("[DbMgr::salvaConsumiReeTipo1B] BEGIN");
		try {

			Tipo1Consumo tipo1Consumo;

			SigitTConsumoTipo1BDto consumoDto = null;

			for (int i = 0; i < listConsumi.size(); i++) {

				tipo1Consumo = listConsumi.get(i);

				if (GenericUtil.isNullOrEmpty(tipo1Consumo.getEsercizio()) &&
					GenericUtil.isNullOrEmpty(tipo1Consumo.getLetturaIniziale()) &&
					GenericUtil.isNullOrEmpty(tipo1Consumo.getLetturaFinale()) &&
					GenericUtil.isNullOrEmpty(tipo1Consumo.getConsumoFinale()) &&
					GenericUtil.isNullOrEmpty(tipo1Consumo.getIdUnitaMisura())) {

					// Vuol dire che l'utente ha messo una riga completamente vuota
					// nel caso in cui sia un riga senza idDb vuol dire che ha fatto l'inserimento (quindi sul DB non c'e' e non devo fare niente)
					// nel caso in cui sia un riga con idDb vuol dire che ha cancellato i dati di una riga gia' presente (quindi devo cancellarla dal DB)

					if (tipo1Consumo.getIdConsumo() != null) {
						if (listPkChiaviCancellare == null) {
							listPkChiaviCancellare = new ArrayList<Integer>();
						}
						listPkChiaviCancellare.add(tipo1Consumo.getIdConsumo());
					}
				}
				else {

					consumoDto = MapDto.mapToSigitTConsumoTipo1BDto(tipo1Consumo, ConvertUtil.convertToBigDecimal(idAllegato));

					if (tipo1Consumo.getIdConsumo() != null) {
						getSigitTConsumoTipo1BDao().update(consumoDto);
					}
					else {
						getSigitTConsumoTipo1BDao().insert(consumoDto);
					}
				}
			}

			if (listPkChiaviCancellare != null) {
				for (Integer pkChiaveCancellare : listPkChiaviCancellare) {
					getSigitTConsumoTipo1BDao().delete(new SigitTConsumoTipo1BPk(ConvertUtil.convertToBigDecimal(pkChiaveCancellare)));
				}
			}
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaConsumiReeTipo1B] END");
		}
	}


	@Transactional
	public void salvaRappProvaTipoGF(TipoGF tipoGF, DettaglioAllegato dettaglioAllegato, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaRappProvaTipoGF] BEGIN");

		try {
			SigitTAllegatoDto allegatoDto = cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));
			allegatoDto.setElencoApparecchiature(ReplaceSpecialCharUtils.sanitize(dettaglioAllegato.getElencoApparecchiature()));

			popolaAllegatoDaRappProvaSuper( dettaglioAllegato, allegatoDto);
			allegatoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
			allegatoDto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
			allegatoDto.setAbcdfControlloweb(DateUtil.getSqlDataCorrente());

			SigitTRappIspezGfDto rappGF = cercaTRappIspezGfById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

			if (rappGF == null)
			{
				rappGF = new SigitTRappIspezGfDto();
			}

			rappGF.setS1cFlgReeInviato(ConvertUtil.convertToBigDecimal(tipoGF.getS1cFlgReeInviato()));
			rappGF.setS1cFlgReeBollino(ConvertUtil.convertToBigDecimal(tipoGF.getS1cFlgReeBollino()));
			rappGF.setS1cSiglaBollino(ReplaceSpecialCharUtils.sanitize(tipoGF.getS1cSiglaBollino()));
			rappGF.setS1cNumBollino(ConvertUtil.convertToBigDecimal(tipoGF.getS1cNumBollino()));
			rappGF.setS1cDataRee(ConvertUtil.convertToSqlDate(tipoGF.getS1cDataRee()));
			rappGF.setS1eDtPrimaInstallazione(ConvertUtil.convertToSqlDate(tipoGF.getS1eDtPrimaInstallazione()));
			rappGF.setS1ePotTermicaMaxKw(ConvertUtil.convertToBigDecimal(tipoGF.getS1ePotTermicaMaxKw()));
			rappGF.setS1lDenomDelegato(ReplaceSpecialCharUtils.sanitize(tipoGF.getS1lDenomDelegat()));
			rappGF.setS1lFlgDelega(ConvertUtil.convertToBigDecimal(tipoGF.getS1lFlgDelega()));
			rappGF.setS2eFlgTrattH2oNonRich(ConvertUtil.convertToBigDecimal(tipoGF.getS2eFlgTrattH2ONonRich()));
			rappGF.setS3aFlgLocaleIntIdoneo(ConvertUtil.convertToBigDecimal(tipoGF.getS3aFlgLocaleIntIdoneo()));
			rappGF.setS3bFlgLineeElettrIdonee(ConvertUtil.convertToBigDecimal(tipoGF.getS3bFlgLineeElettrIdonee()));
			rappGF.setS3cFlgVentilazAdeguate(ConvertUtil.convertToBigDecimal(tipoGF.getS3cFlgVentilazAdeguate()));
			rappGF.setS3dFlgCoibentazioniIdonee(ConvertUtil.convertToBigDecimal(tipoGF.getS3dFlgCoibentazioniIdonee()));
			rappGF.setS4aFlgLibImpPresente(ConvertUtil.convertToBigDecimal(tipoGF.getS4aFlgLibImpPresente()));
			rappGF.setS4bFlgLibCompilato(ConvertUtil.convertToBigDecimal(tipoGF.getS4bFlgLibCompilato()));
			rappGF.setS4cFlgConformitaPresente(ConvertUtil.convertToBigDecimal(tipoGF.getS4cFlgConformitaPresente()));
			rappGF.setS4dFlgLibUsoPresente(ConvertUtil.convertToBigDecimal(tipoGF.getS4dFlgLibUsoPresente()));
			rappGF.setS5aFlgIsolamCanaliDistrib(ConvertUtil.convertToBigDecimal(tipoGF.getS5aFlgIsolamCanaliDistrib()));
			rappGF.setS5aFlgIsolamReteDistrib(ConvertUtil.convertToBigDecimal(tipoGF.getS5aFlgIsolamReteDistrib()));
			rappGF.setS5aFlgSostituzMacchineReg(ConvertUtil.convertToBigDecimal(tipoGF.getS5aFlgSostituzMacchineReg()));
			rappGF.setS5aFlgSostituzSistemiReg(ConvertUtil.convertToBigDecimal(tipoGF.getS5aFlgSostituzSistemiReg()));
			rappGF.setS5bFlgNoIntervConv(ConvertUtil.convertToBigDecimal(tipoGF.getS5bFlgNoIntervConv()));
			rappGF.setS5bFlgRelazDettaglio(ConvertUtil.convertToBigDecimal(tipoGF.getS5bFlgRelazDettaglio()));
			rappGF.setS5bFlgRelazDettaglioSucc(ConvertUtil.convertToBigDecimal(tipoGF.getS5bFlgRelazDettaglioSucc()));
			rappGF.setS5bFlgValutazNonEseguita(ConvertUtil.convertToBigDecimal(tipoGF.getS5bFlgValutazNonEseguita()));
			rappGF.setS5bMotivoRelazNonEseg(ReplaceSpecialCharUtils.sanitize(tipoGF.getS5bMotivoRelazNonEseg()));
			rappGF.setS5cFlgDimensCorretto(ConvertUtil.convertToBigDecimal(tipoGF.getS5cFlgDimensCorretto()));
			rappGF.setS5cFlgDimensNonControll(ConvertUtil.convertToBigDecimal(tipoGF.getS5cFlgDimensNonControll()));
			rappGF.setS5cFlgDimensNonCorretto(ConvertUtil.convertToBigDecimal(tipoGF.getS5cFlgDimensNonCorretto()));
			rappGF.setS5cFlgDimensRelazSucces(ConvertUtil.convertToBigDecimal(tipoGF.getS5cFlgDimensRelazSucces()));

			aggiornaAllegato(allegatoDto);

			// Sono in modifica
			getSigitTRappIspezGfDao().update(rappGF);


		} catch(SigitTRappIspezGfDaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		catch(DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
		finally {
			log.debug("[DbMgr::salvaReeTipo1] END");
		}


	}

	@Transactional
	public void salvaRappProvaTipoGT(TipoGT tipoGT, DettaglioAllegato dettaglioAllegato, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaRappProvaTipoGT] BEGIN");
		try {


			SigitTAllegatoDto allegatoDto = cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

			allegatoDto.setElencoApparecchiature(ReplaceSpecialCharUtils.sanitize(dettaglioAllegato.getElencoApparecchiature()));
			popolaAllegatoDaRappProvaSuper( dettaglioAllegato, allegatoDto);
			allegatoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
			allegatoDto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
			allegatoDto.setAbcdfControlloweb(DateUtil.getSqlDataCorrente());

			SigitTRappIspezGtDto rappGT = cercaTRappIspezGtById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

			if (rappGT == null)
			{
				rappGT = new SigitTRappIspezGtDto();
			}

			rappGT.setS1cDataRee(ConvertUtil.convertToSqlDate(tipoGT.getS1cDataRee()));
			rappGT.setS1cFlgReeBollino(ConvertUtil.convertToBigDecimal(tipoGT.getS1cFlgReeBollino()));
			rappGT.setS1cFlgReeInviato(ConvertUtil.convertToBigDecimal(tipoGT.getS1cFlgReeInviato()));
			rappGT.setS1cNumBollino(ConvertUtil.convertToBigDecimal(tipoGT.getS1cNumBollino()));
			rappGT.setS1cSiglaBollino(ReplaceSpecialCharUtils.sanitize(tipoGT.getS1cSiglaBollino()));
			rappGT.setS1eDtPrimaInstallazione(ConvertUtil.convertToSqlDate(tipoGT.getS1eDtPrimaInstallazione()));
			rappGT.setS1ePotFocolareKw(ConvertUtil.convertToBigDecimal(tipoGT.getS1ePotFocolareKw()));
			rappGT.setS1ePotUtileKw(ConvertUtil.convertToBigDecimal(tipoGT.getS1ePotUtileKw()));
			rappGT.setS1lDenomDelegato(ReplaceSpecialCharUtils.sanitize(tipoGT.getS1lDenomDelegat()));
			rappGT.setS1lFlgDelega(ConvertUtil.convertToBigDecimal(tipoGT.getS1lFlgDelega()));
			rappGT.setS2b1FlgTermoContab(ConvertUtil.convertToBigDecimal(tipoGT.getS2b1FlgTermoContab()));
			rappGT.setS2b2FlgUni10200(ConvertUtil.convertToBigDecimal(tipoGT.getS2b1FlgUni10200()));
			rappGT.setS2fFlgTrattAcsNonRich(ConvertUtil.convertToBigDecimal(tipoGT.getS2fFlgTrattAcsNonRich()));
			rappGT.setS2fFlgTrattClimaNonRich(ConvertUtil.convertToBigDecimal(tipoGT.getS2fFlgTrattClimaNonRich()));
			rappGT.setS3aFlgLocaleIntIdoneo(ConvertUtil.convertToBigDecimal(tipoGT.getS3aFlgLocaleIntIdoneo()));
			rappGT.setS3bFlgGenExtIdoneo(ConvertUtil.convertToBigDecimal(tipoGT.getS3bFlgGenExtIdoneo()));
			rappGT.setS3cFlgVentilazSuff(ConvertUtil.convertToBigDecimal(tipoGT.getS3cFlgVentilazSuff()));
			rappGT.setS3dFlgEvacFumiIdoneo(ConvertUtil.convertToBigDecimal(tipoGT.getS3dFlgEvacFumiIdoneo()));
			rappGT.setS3eFlgCartelliPresenti(ConvertUtil.convertToBigDecimal(tipoGT.getS3eFlgCartelliPresenti()));
			rappGT.setS3fFlgEstinzPresenti(ConvertUtil.convertToBigDecimal(tipoGT.getS3fFlgEstinzPresenti()));
			rappGT.setS3gFlgInterrGenPresenti(ConvertUtil.convertToBigDecimal(tipoGT.getS3gFlgInterrGenPresenti()));
			rappGT.setS3hFlgRubinPresente(ConvertUtil.convertToBigDecimal(tipoGT.getS3hFlgRubinPresente()));
			rappGT.setS3iFlgAssenzaPerdComb(ConvertUtil.convertToBigDecimal(tipoGT.getS3iFlgAssenzaPerdComb()));
			rappGT.setS3jFlgTempAmbFunz(ConvertUtil.convertToBigDecimal(tipoGT.getS3jFlgTempAmbFunz()));
			rappGT.setS3kFlgDm1121975(ConvertUtil.convertToBigDecimal(tipoGT.getS3kFlgDm_1_12_1975()));
			rappGT.setS4aFlgLibImpPresente(ConvertUtil.convertToBigDecimal(tipoGT.getS4aFlgLibImpPresente()));
			rappGT.setS4bFlgLibCompilato(ConvertUtil.convertToBigDecimal(tipoGT.getS4bFlgLibCompilato()));
			rappGT.setS4cFlgConformitaPresente(ConvertUtil.convertToBigDecimal(tipoGT.getS4cFlgConformitaPresente()));
			rappGT.setS4dFlgLibUsoPresente(ConvertUtil.convertToBigDecimal(tipoGT.getS4dFlgLibUsoPresente()));
			rappGT.setS4eFlgPraticaVvfPresente(ConvertUtil.convertToBigDecimal(tipoGT.getS4eFlgPraticaVvfPresente()));
			rappGT.setS4fFlgPraticaInailPresente(ConvertUtil.convertToBigDecimal(tipoGT.getS4fFlgPraticaInailPresente()));
			rappGT.setS4gFlgDm121975(ConvertUtil.convertToBigDecimal(tipoGT.getS4gFlgDm12_1975()));
			rappGT.setS4gMatricolaDm1121975(ReplaceSpecialCharUtils.sanitize(tipoGT.getS4gMatricolaDm_1_12_1975()));
			rappGT.setS5aFlgAdozioneValvoleTerm(ConvertUtil.convertToBigDecimal(tipoGT.getS5aFlgAdozioneValvoleTerm()));
			rappGT.setS5aFlgAdozSistTrattamH2o(ConvertUtil.convertToBigDecimal(tipoGT.getS5aFlgAdozSistTrattamH2o()));
			rappGT.setS5aFlgIsolamenteRete(ConvertUtil.convertToBigDecimal(tipoGT.getS5aFlgIsolamenteRete()));
			rappGT.setS5aFlgSostituzSistRegolaz(ConvertUtil.convertToBigDecimal(tipoGT.getS5aFlgSostituzSistRegolaz()));
			rappGT.setS5bFlgNoIntervConv(ConvertUtil.convertToBigDecimal(tipoGT.getS5bFlgNoIntervConv()));
			rappGT.setS5bFlgRelazDettaglio(ConvertUtil.convertToBigDecimal(tipoGT.getS5bFlgRelazDettaglio()));
			rappGT.setS5bFlgRelazDettaglioSucc(ConvertUtil.convertToBigDecimal(tipoGT.getS5bFlgRelazDettaglioSucc()));
			rappGT.setS5bFlgValutazNonEseguita(ConvertUtil.convertToBigDecimal(tipoGT.getS5bFlgValutazNonEseguita()));
			rappGT.setS5bMotivoRelazNonEseg(ReplaceSpecialCharUtils.sanitize(tipoGT.getS5bMotivoRelazNonEseg()));
			rappGT.setS5cFlgDimensCorretto(ConvertUtil.convertToBigDecimal(tipoGT.getS5cFlgDimensCorretto()));
			rappGT.setS5cFlgDimensNonControll(ConvertUtil.convertToBigDecimal(tipoGT.getS5cFlgDimensNonControll()));
			rappGT.setS5cFlgDimensNonCorretto(ConvertUtil.convertToBigDecimal(tipoGT.getS5cFlgDimensNonCorretto()));
			rappGT.setS5cFlgDimensRelazSucces(ConvertUtil.convertToBigDecimal(tipoGT.getS5cFlgDimensRelazSucces()));

			aggiornaAllegato(allegatoDto);

			// Sono in modifica
			getSigitTRappIspezGtDao().update(rappGT);


		}
		catch(SigitTRappIspezGtDaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		catch(DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw e;
		}
		finally {
			log.debug("[DbMgr::salvaReeTipo1] END");
		}
	}

	@Transactional
	public void salvaRappProvaTipoGF(TipoGFDett dett, TipoGFDettCircuito dettCircuito, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaRappProvaTipoGF] BEGIN");

		try {
			SigitTDettIspezGfDto dettDb = new SigitTDettIspezGfDto();
			dettDb.setCodiceImpianto(ConvertUtil.convertToBigDecimal(dett.getCodImpianto()));
			dettDb.setControlloweb(DateUtil.getSqlDataCorrente());
			dettDb.setDataInstall(ConvertUtil.convertToSqlDate(dett.getDataInstallazione()));
			dettDb.setDataUltMod(DateUtil.getSqlDataCorrente());
			dettDb.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
			dettDb.setFkAllegato(ConvertUtil.convertToBigDecimal(dett.getIdAllegato()));
			dettDb.setFkTipoComponente(Constants.TIPO_COMPONENTE_GF);
			dettDb.setProgressivo(ConvertUtil.convertToBigDecimal(dett.getProgressivo()));

			dettDb.setS6hFlgInverter(ConvertUtil.convertToBigDecimal(dett.getS6hFlgInverter()));
			dettDb.setS6nFlgFugaDiretta(ConvertUtil.convertToBigDecimal(dett.getS6nFlgFugaDiretta()));
			dettDb.setS6nFlgFugaIndiretta(ConvertUtil.convertToBigDecimal(dett.getS6nFlgFugaIndiretta()));
			dettDb.setS7aDataUltimaManut(ConvertUtil.convertToSqlDate(dett.getS7aDataUltimaManut()));
			dettDb.setS7aFkFrequenzaManut(ConvertUtil.convertToInteger(dett.getS7aFkFrequenzaManut()));
			dettDb.setS7aFlgManutEffettuata(ConvertUtil.convertToBigDecimal(dett.getS7FlgManutEffettuata()));
			dettDb.setS7aFrequenzaManutAltro(ReplaceSpecialCharUtils.sanitize(dett.getS7aFrequenzaManutAltro()));
			dettDb.setS7bFlgRegistroApparecc(ConvertUtil.convertToBigDecimal(dett.getS7bFlgRegistroApparecc()));
			dettDb.setS7cDataRee(ConvertUtil.convertToSqlDate(dett.getS7bDataRee()));
			dettDb.setS7cFlgOsservazioni(ConvertUtil.convertToBigDecimal(dett.getS7bFlgOsservazioni()));
			dettDb.setS7cFlgPrescr(ConvertUtil.convertToBigDecimal(dett.getS7bFlgPrescr()));
			dettDb.setS7cFlgRaccomand(ConvertUtil.convertToBigDecimal(dett.getS7bFlgRaccomand()));
			dettDb.setS7cFlgReePresente(ConvertUtil.convertToBigDecimal(dett.getS7cFlgReePresente()));

			dettDb.setS8aNCircuito(ReplaceSpecialCharUtils.sanitize(dettCircuito.getS8aNCircuito()));
			dettDb.setS8bFlgProveRaffrescamento(ConvertUtil.convertToBigDecimal(dettCircuito.getS8bFlgProveRaffrescamento()));
			dettDb.setS8bFlgProveRiscaldamento(ConvertUtil.convertToBigDecimal(dettCircuito.getS8bFlgProveRiscaldamento()));
			dettDb.setS8cFlgFiltriPuliti(ConvertUtil.convertToBigDecimal(dettCircuito.getS8cFlgFiltriPuliti()));
			dettDb.setS8dFlgAssenzaPerditeGas(ConvertUtil.convertToBigDecimal(dettCircuito.getS8dFlgAssenzaPerditeGas()));
			dettDb.setS8eMarcaStrumMisura(ReplaceSpecialCharUtils.sanitize(dettCircuito.getS8cMarcaStrumMisura()));
			dettDb.setS8eMatricolaStrumMisura(ReplaceSpecialCharUtils.sanitize(dettCircuito.getS8cMatricolaStrumMisura()));
			dettDb.setS8eModelloStrumMisura(ReplaceSpecialCharUtils.sanitize(dettCircuito.getS8cModelloStrumMisura()));
			dettDb.setS8fPotAssorbitaKw(ConvertUtil.convertToBigDecimal(dettCircuito.getS8fPotAssorbitaKw()));
			dettDb.setS8gFlgStrumentazioneFissa(ConvertUtil.convertToBigDecimal(dettCircuito.getS8gFlgStrumentazioneFissa()));
			dettDb.setS8hOperatoreDenominazione(ReplaceSpecialCharUtils.sanitize(dettCircuito.getS8hOperatoreDenominazione()));
			dettDb.setS8iOperatoreNumIscriz(ReplaceSpecialCharUtils.sanitize(dettCircuito.getS8iOperatoreNumIscriz()));
			dettDb.setS8jSottoraffreddamentoK(ConvertUtil.convertToBigDecimal(dettCircuito.getS8jSottoraffreddamentoK()));
			dettDb.setS8jSurriscaldamentoK(ConvertUtil.convertToBigDecimal(dettCircuito.getS8jSurriscaldamentok()));
			dettDb.setS8jTempCondensazioneC(ConvertUtil.convertToBigDecimal(dettCircuito.getS8jTempCondensazioneC()));
			dettDb.setS8jTempEvaporazioneC(ConvertUtil.convertToBigDecimal(dettCircuito.getS8jTempEvaporazioneC()));
			dettDb.setS8jTempIngressoFluidoC(ConvertUtil.convertToBigDecimal(dettCircuito.getS8jTempIngressoFluidoC()));
			dettDb.setS8jTempSorgIngressoC(ConvertUtil.convertToBigDecimal(dettCircuito.getS8jTempSorgIngressoC()));
			dettDb.setS8jTempSorgUscitaC(ConvertUtil.convertToBigDecimal(dettCircuito.getS8jTempSorgUscitaC()));
			dettDb.setS8jTempUscitaFluidoC(ConvertUtil.convertToBigDecimal(dettCircuito.getS8jTempUscitaFluidoC()));

			dettDb.setS9aFlgVerificaSuperata(ConvertUtil.convertToBigDecimal(dettCircuito.getS9verificaSuperata()));
			dettDb.setS9bFlgRispettoNormativa(ConvertUtil.convertToBigDecimal(dettCircuito.getS9eFlgRispettoNormativa()));
			dettDb.setS9cFlgNoRispetto7a(ConvertUtil.convertToBigDecimal(dettCircuito.getS9eFlgNoRispetto7a()));
			dettDb.setS9cFlgNoRispetto7b(ConvertUtil.convertToBigDecimal(dettCircuito.getS9eFlgNoRispetto7c()));
			dettDb.setS9cFlgNoRispetto8d(ConvertUtil.convertToBigDecimal(dettCircuito.getS9eFlgNoRispetto8d()));
			dettDb.setS9cFlgNoRispetto9a(ConvertUtil.convertToBigDecimal(dettCircuito.getS9eFlgNoRispetto9a()));

			dettDb.setIdDettIspezGf(ConvertUtil.convertToBigDecimal(dettCircuito.getIdDettGF()));

			getSigitTDettIspezGfDao().update(dettDb);

			getSigitTDettIspezGfDao().customUpdaterDettDettIspezGfComune(dettDb, dettDb);

		}  catch(SigitTDettIspezGfDaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaRappProvaTipoGF] END");
		}
	}

	@Transactional
	public void salvaRappProvaTipoGT(TipoGTDett dett, TipoGTDettModulo dettModulo, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaRappProvaTipoGT] BEGIN");

		try {

			//le informazioni di dett (legate alle sezioni 6/7) vanno persistite su tutti i dettagli
			SigitTDettIspezGtDto dettDb = new SigitTDettIspezGtDto();
			dettDb.setCodiceImpianto(ConvertUtil.convertToBigDecimal(dett.getCodImpianto()));
			dettDb.setControlloweb(DateUtil.getSqlDataCorrente());
			dettDb.setDataInstall(ConvertUtil.convertToSqlDate(dett.getDataInstallazione()));
			dettDb.setDataUltMod(DateUtil.getSqlDataCorrente());
			dettDb.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
			dettDb.setFkAllegato(ConvertUtil.convertToBigDecimal(dett.getIdAllegato()));
			dettDb.setFkTipoComponente(Constants.TIPO_COMPONENTE_GT);
			dettDb.setProgressivo(ConvertUtil.convertToBigDecimal(dett.getProgressivo()));

			dettDb.setS6dFlgEvacuFumi(ReplaceSpecialCharUtils.sanitize(dett.getS6dFlgEvacuFumi()));
			dettDb.setS6iFlgTipoB(ConvertUtil.convertToBigDecimal(dett.getS6iFlgTipoB()));
			dettDb.setS6iFlgTipoC(ConvertUtil.convertToBigDecimal(dett.getS6iFlgTipoC()));
			dettDb.setS6jFkClassDpr66096(GenericUtil.isNullOrEmpty(dett.getS6jFkClassDpr660_96()) ? null : ReplaceSpecialCharUtils.sanitize(dett.getS6jFkClassDpr660_96()));
			dettDb.setS6kBruciatoreAKw(ConvertUtil.convertToBigDecimal(dett.getS6kBruciatoreAKw()));
			dettDb.setS6kBruciatoreDaKw(ConvertUtil.convertToBigDecimal(dett.getS6kBruciatoreDaKw()));
			dettDb.setS6kPotTermFocolKw(ConvertUtil.convertToBigDecimal(dett.getS6kPotTermFocolKw()));
			dettDb.setS6lPortataCombKgH(GenericUtil.isNullOrEmpty(dett.getS6lPortataCombKgH()) ? null : ReplaceSpecialCharUtils.sanitize(dett.getS6lPortataCombKgH()));
			dettDb.setS6lPortataCombM3H(ConvertUtil.convertToBigDecimal(dett.getS6lPortataCombM3H()));
			dettDb.setS6lPotTermFocolKw(ConvertUtil.convertToBigDecimal(dett.getS6lPotTermFocolKw()));

			dettDb.setS7aDataUltimaManut(ConvertUtil.convertToSqlDate(dett.getS7aDataUltimaManut()));
			dettDb.setS7aFkFrequenzaManut(ConvertUtil.convertToInteger(dett.getS7aFkFrequenzaManut()));
			dettDb.setS7aFlgManutEffettuata(ConvertUtil.convertToBigDecimal(dett.getS7aFlgManutEffettuata()));
			dettDb.setS7aFrequenzaManutAltro(ReplaceSpecialCharUtils.sanitize(dett.getS7aFrequenzaManutAltro()));
			dettDb.setS7bDataRee(ConvertUtil.convertToSqlDate(dett.getS7bDataRee()));
			dettDb.setS7bFlgOsservazioni(ConvertUtil.convertToBigDecimal(dett.getS7bFlgOsservazioni()));
			dettDb.setS7bFlgPrescr(ConvertUtil.convertToBigDecimal(dett.getS7bFlgPrescr()));
			dettDb.setS7bFlgRaccomand(ConvertUtil.convertToBigDecimal(dett.getS7bFlgRaccomand()));
			dettDb.setS7bFlgReePresente(ConvertUtil.convertToBigDecimal(dett.getS7bFlgReePresente()));

			dettDb.setS8aNModuloTermico(ReplaceSpecialCharUtils.sanitize(dettModulo.getS8aNModuloTermico()));

			dettDb.setS8bFumoMis1(ConvertUtil.convertToBigDecimal(dettModulo.getS8bFumoMis1()));
			dettDb.setS8bFumoMis2(ConvertUtil.convertToBigDecimal(dettModulo.getS8bFumoMis2()));
			dettDb.setS8bFumoMis3(ConvertUtil.convertToBigDecimal(dettModulo.getS8bFumoMis3()));
			dettDb.setS8cMarcaStrumMisura(ReplaceSpecialCharUtils.sanitize(dettModulo.getS8cMarcaStrumMisura()));
			dettDb.setS8cMatricolaStrumMisura(ReplaceSpecialCharUtils.sanitize(dettModulo.getS8cMatricolaStrumMisura()));
			dettDb.setS8cModelloStrumMisura(ReplaceSpecialCharUtils.sanitize(dettModulo.getS8cModelloStrumMisura()));

			if (O2CO2Enum.O2.name().equals(dettModulo.getS8dSceltaPerc())) {
				dettDb.setS8dO2Perc(ConvertUtil.convertToBigDecimal(dettModulo.getS8dPerc()));
			} else if (O2CO2Enum.CO2.name().equals(dettModulo.getS8dSceltaPerc())) {
				dettDb.setS8dCo2Perc(ConvertUtil.convertToBigDecimal(dettModulo.getS8dPerc()));
			}

			dettDb.setS8dCoFumiSecchiPpm(ConvertUtil.convertToBigDecimal(dettModulo.getS8dCoFumiSecchiPpm()));
			dettDb.setS8dNoMgKwH(ConvertUtil.convertToBigDecimal(dettModulo.getS8dNoMgKwH()));
			dettDb.setS8dTempAriaC(ConvertUtil.convertToBigDecimal(dettModulo.getS8dTempAria_c()));
			dettDb.setS8dTempFluidoMandataC(ConvertUtil.convertToBigDecimal(dettModulo.getS8dTempFluidoMandataC()));
			dettDb.setS8dTempFumiC(ConvertUtil.convertToBigDecimal(dettModulo.getS8dTempFumiC()));

			dettDb.setS8eEtPerc(ConvertUtil.convertToBigDecimal(dettModulo.getS8eEtPerc()));
			dettDb.setS8eFumiSecchiNoAriaPpm(ConvertUtil.convertToBigDecimal(dettModulo.getS8eFumiSecchiNoAriaPpm()));

			if (GenericUtil.isNotNullOrEmpty(dettModulo.getS8eFumiSecchiNoAriaPpm())) {
				dettDb.setS9aFlgMonossidoCarb(new Double(1000).compareTo(ConvertUtil.convertToDouble(dettModulo.getS8eFumiSecchiNoAriaPpm())) > 0 ? RegolareIrregolareEnum.R.name() : RegolareIrregolareEnum.I.name());
			}

			dettDb.setS8eIndiceAria(ConvertUtil.convertToBigDecimal(dettModulo.getS8eIndiceAria()));
			dettDb.setS8eNoxMgKwH(ConvertUtil.convertToBigDecimal(dettModulo.getS8eNoxMgKwH()));
			dettDb.setS8eQsPerc(ConvertUtil.convertToBigDecimal(dettModulo.getS8eQsPerc()));
			dettDb.setS8eRendCombPerc(ConvertUtil.convertToBigDecimal(dettModulo.getS8eRendCombPerc()));


			dettDb.setS9bFlgFumosita(GenericUtil.isNullOrEmpty(dettModulo.getS9bFlgFumosita()) ? null : dettModulo.getS9bFlgFumosita());
			dettDb.setS9cFlgRendCombustSuff(ConvertUtil.convertToBigDecimal(dettModulo.getS9cFlgRendCombustSuff()));
			dettDb.setS9cRendMinCombustPerc(ConvertUtil.convertToBigDecimal(dettModulo.getS9cRendMinCombustPerc()));
			if (GenericUtil.isNotNullOrEmpty(dettModulo.getS9dFlgOssidiAzoto())) {
				dettDb.setS9dFlgOssidiAzoto(dettModulo.getS9dFlgOssidiAzoto());
			}

			dettDb.setS9dOssidiAzotoLimMgKwH(ConvertUtil.convertToBigDecimal(dettModulo.getS9dOssidiAzotoLimMgKwH()));
			dettDb.setS9eFlgNoRispetto7a(ConvertUtil.convertToBigDecimal(dettModulo.getS9eFlgNoRispetto7a()));
			dettDb.setS9eFlgNoRispetto7b(ConvertUtil.convertToBigDecimal(dettModulo.getS9eFlgNoRispetto7b()));
			dettDb.setS9eFlgNoRispetto9a(ConvertUtil.convertToBigDecimal(dettModulo.getS9eFlgNoRispetto9a()));
			dettDb.setS9eFlgNoRispetto9b(ConvertUtil.convertToBigDecimal(dettModulo.getS9eFlgNoRispetto9b()));
			dettDb.setS9eFlgNoRispetto9c(ConvertUtil.convertToBigDecimal(dettModulo.getS9eFlgNoRispetto9c()));
			dettDb.setS9eFlgNoRispetto9d(ConvertUtil.convertToBigDecimal(dettModulo.getS9eFlgNoRispetto9d()));
			dettDb.setS9eFlgRispettoNormativa(ConvertUtil.convertToBigDecimal(dettModulo.getS9eFlgRispettoNormativa()));

			dettDb.setIdDettIspezGt(ConvertUtil.convertToBigDecimal(dettModulo.getIdDettGT()));

			getSigitTDettIspezGtDao().update(dettDb);

			getSigitTDettIspezGtDao().customUpdaterDettDettIspezGtComune(dettDb, dettDb);

		} catch(SigitTDettIspezGtDaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaRappProvaTipoGT] END");
		}
	}

	@Transactional
	public void salvaReeTipo1Dett(Tipo1Dett tipo1Dett, Tipo1DettModulo tipo1DettModulo, ArrayList<Integer> consumiTipo1DaCancellare, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaReeTipo1Dett] BEGIN");

		try {
			Integer idAllegato = tipo1Dett.getIdAllegato();

			SigitTDettTipo1Dto dettTipo1 = new SigitTDettTipo1Dto();

			dettTipo1.setCodiceImpianto(ConvertUtil.convertToBigDecimal(tipo1Dett.getCodImpianto()));
			dettTipo1.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));
			dettTipo1.setProgressivo(ConvertUtil.convertToBigDecimal(tipo1Dett.getProgressivo()));
			dettTipo1.setFkTipoComponente(tipo1Dett.getIdTipoComponente());
			dettTipo1.setDataInstall(ConvertUtil.convertToSqlDate(tipo1Dett.getDataInstallazione()));

			dettTipo1.setEPotTermFocolKw(ConvertUtil.convertToBigDecimal(tipo1Dett.getPotTermFocolKw()));
			dettTipo1.setEFlgClimaInverno(ConvertUtil.convertToBigDecimal(tipo1Dett.getFlgClimaInverno()));
			dettTipo1.setEFlgProduzAcs(ConvertUtil.convertToBigDecimal(tipo1Dett.getFlgProduzAcs()));
			dettTipo1.setE1bFlgCucina(ConvertUtil.convertToBigDecimal(tipo1Dett.getFlgCucina()));

			dettTipo1.setEFlgEvacuFumi(tipo1Dett.getFlgEvacuFumi());

			dettTipo1.setEDeprCanaleFumoPa(ConvertUtil.convertToBigDecimal(tipo1Dett.getDeprCanaleFumoPa()));
			dettTipo1.setEFlgDisposComando(ConvertUtil.convertToBigDecimal(tipo1Dett.getFlgDisposComando()));
			dettTipo1.setEFlgDisposSicurezza(ConvertUtil.convertToBigDecimal(tipo1Dett.getFlgDisposSicurezza()));
			dettTipo1.setEFlgValvolaSicurezza(ConvertUtil.convertToBigDecimal(tipo1Dett.getFlgValvolaSicurezza()));
			dettTipo1.setEFlgScambiatoreFumi(ConvertUtil.convertToBigDecimal(tipo1Dett.getFlgScambiatoreFumi()));
			dettTipo1.setEFlgRiflusso(ConvertUtil.convertToBigDecimal(tipo1Dett.getFlgRiflusso()));
			dettTipo1.setEFlgUni103891(ConvertUtil.convertToBigDecimal(tipo1Dett.getFlgUni10389_1()));
			dettTipo1.setE1bFlgUni103892(ConvertUtil.convertToBigDecimal(tipo1Dett.getFlgUni10389_2()));

			dettTipo1.setL111AltroRiferimento(GenericUtil.getStringSql(ReplaceSpecialCharUtils.sanitize(tipo1Dett.getAltroRiferimento())));

			dettTipo1.setDataUltMod(DateUtil.getSqlDataCorrente());
			dettTipo1.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));


			getSigitTDettTipo1Dao().customUpdaterAggiornaDatiComuni(dettTipo1, null);

			// devo fare l'update di tutta la riga
			// setto la chiave
			dettTipo1.setIdDettTipo1(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getIdDettTipo1()));
			//dettTipo1.setFkTipoComponente(Constants.TIPO_COMPONENTE_GT);
			dettTipo1.setENModuloTermico(tipo1DettModulo.getNumModuloTermico());

			dettTipo1.setETempFumiC(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getTempFumiC()));

			dettTipo1.setETempAriaC(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getTempAriaC()));
			dettTipo1.setEO2Perc(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getO2Perc()));

			dettTipo1.setECo2Perc(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getCo2Perc()));

			dettTipo1.setE1bParticolatoMgAlM3(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getParticolatoPrimarioMgM3()));
			dettTipo1.setEBacharachMin(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getBacharachMin()));
			dettTipo1.setEBacharachMed(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getBacharachMed()));
			dettTipo1.setEBacharachMax(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getBacharachMax()));
			dettTipo1.setECoCorrettoPpm(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getCoCorrettoPpm()));

			dettTipo1.setL111FlgCoMin1000(null);

			if (GenericUtil.isNotNullOrEmpty(dettTipo1.getECoCorrettoPpm())) {
				if (dettTipo1.getECoCorrettoPpm().doubleValue() <= new BigDecimal(1000).doubleValue()) {
					dettTipo1.setL111FlgCoMin1000(new BigDecimal(Constants.SI_1));
				}
				else {
					dettTipo1.setL111FlgCoMin1000(new BigDecimal(Constants.NO_0));
				}
			}

			dettTipo1.setERendCombPerc(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getRendCombPerc()));
			dettTipo1.setERendMinLeggePerc(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getRendMinLeggePerc()));
			dettTipo1.setENoxMgKwh(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getNoxPpm()));
			dettTipo1.setENoxMgNm3(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getNoxMgNm3()));

			String portCombUmDesc = GenericUtil.getDescriptionByCod(tipo1DettModulo.getPortataCombUm(), GenericUtil.getComboPortataCombustibile());
			dettTipo1.setL111PortataCombustibileUm(portCombUmDesc);

			log.debug("Stampo la portCombUmDesc: "+portCombUmDesc);

			dettTipo1.setL111PortataCombustibile(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getPortataComb()));
			dettTipo1.setL111CoNoAriaPpm(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getCoNoAriaPpm()));

			dettTipo1.setL111FlgRispettaBacharach(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getFlgRispettaBacharac()));
			dettTipo1.setL111FlgRendMagRendMin(ConvertUtil.convertToBigDecimal(tipo1DettModulo.getFlgRendMagRendMin()));

			dettTipo1.setEControlloweb(DateUtil.getSqlDataCorrente());

				// Sono in modifica
			getSigitTDettTipo1Dao().update(dettTipo1);

			SigitTRappTipo1Dto rappTipo1Dto = cercaTRappTipo1ById(ConvertUtil.convertToBigDecimal(idAllegato));

			rappTipo1Dto.setE1bFlgCaldaia(BigDecimal.ZERO);
			rappTipo1Dto.setE1bFlgStufa(BigDecimal.ZERO);
			rappTipo1Dto.setE1bFlgStufaAccumulo(BigDecimal.ZERO);
			rappTipo1Dto.setE1bFlgTermocucina(BigDecimal.ZERO);
			rappTipo1Dto.setE1bFlgStufaAssemblata(BigDecimal.ZERO);
			rappTipo1Dto.setE1bFlgStufaPellet(BigDecimal.ZERO);
			rappTipo1Dto.setE1bFlgCaminettoAperto(BigDecimal.ZERO);
			rappTipo1Dto.setE1bFlgCaminettoChiuso(BigDecimal.ZERO);
			rappTipo1Dto.setE1bFlgInsertoCaminetto(BigDecimal.ZERO);

			try {

				TipologiaTipo1BEnum tipologiaEnum = TipologiaTipo1BEnum.getById(tipo1Dett.getTipologiaTipo1B());

				switch (tipologiaEnum) {
					case CALDAIA:
						rappTipo1Dto.setE1bFlgCaldaia(BigDecimal.ONE);
						break;
					case STUFA:
						rappTipo1Dto.setE1bFlgStufa(BigDecimal.ONE);
						break;
					case STUFA_ACCUMULO:
						rappTipo1Dto.setE1bFlgStufaAccumulo(BigDecimal.ONE);
						break;
					case STUFA_ASSEMBLATA:
						rappTipo1Dto.setE1bFlgStufaAssemblata(BigDecimal.ONE);
						break;
					case STUFA_PELLET:
						rappTipo1Dto.setE1bFlgStufaPellet(BigDecimal.ONE);
						break;
					case TERMOCUCINA:
						rappTipo1Dto.setE1bFlgTermocucina(BigDecimal.ONE);
						break;
					case CAMINETTO_APERTO:
						rappTipo1Dto.setE1bFlgCaminettoAperto(BigDecimal.ONE);
						break;
					case CAMINETTO_CHIUSO:
						rappTipo1Dto.setE1bFlgCaminettoChiuso(BigDecimal.ONE);
						break;
					case INSERTO_CAMINETTO:
						rappTipo1Dto.setE1bFlgInsertoCaminetto(BigDecimal.ONE);
						break;
				}
			} catch (Exception e) {
				log.warn("Tipologia tipo 1B non trovata durante salvataggio dettaglio tipo 1B");
			}

			/*rappTipo1Dto.setE1bFlgCaminettoAperto(BigDecimal.ZERO);
			rappTipo1Dto.setE1bFlgCaminettoChiuso(BigDecimal.ZERO);
			rappTipo1Dto.setE1bFlgInsertoCaminetto(BigDecimal.ZERO);

			try {

				CondottoEvacuazioneFumiTipo1BEnum condottoEnum = CondottoEvacuazioneFumiTipo1BEnum.getById(tipo1Dett.getCondottoEvacuazioneFiumi());

				switch (condottoEnum) {
					case CAMINETTO_APERTO:
						rappTipo1Dto.setE1bFlgCaminettoAperto(BigDecimal.ONE);
						break;
					case CAMINETTO_CHIUSO:
						rappTipo1Dto.setE1bFlgCaminettoChiuso(BigDecimal.ONE);
						break;
					case INSERTO_CAMINETTO:
						rappTipo1Dto.setE1bFlgInsertoCaminetto(BigDecimal.ONE);
						break;
				}
			} catch (Exception e) {
				log.warn("Condotto evacuazione fumi tipo 1B non trovato durante salvataggio dettaglio tipo 1B");
			}*/

			rappTipo1Dto.setIdStelle(ConvertUtil.convertToBigDecimal(tipo1Dett.getFkStelle()));
			rappTipo1Dto.setIdTipo1b(ConvertUtil.convertToBigDecimal(tipo1Dett.getFkTipo1B()));
			rappTipo1Dto.setIdAriaComburente(ConvertUtil.convertToBigDecimal(tipo1Dett.getFkAriaComburente()));
			rappTipo1Dto.setIdControlloAria(ConvertUtil.convertToBigDecimal(tipo1Dett.getFkControlloAriaComburente()));
			rappTipo1Dto.setIdTipoCaricCombu(ConvertUtil.convertToBigDecimal(tipo1Dett.getFkCaricamentoCombustibile()));
			rappTipo1Dto.setE1bFlgMarcaturaCe(ConvertUtil.convertToBigDecimal(tipo1Dett.getFlgMarcaturaCE()));
			rappTipo1Dto.setE1bFlgPlaccaCamino(ConvertUtil.convertToBigDecimal(tipo1Dett.getFlgPlaccaCamino()));

			getSigitTRappTipo1Dao().update(rappTipo1Dto);

			salvaConsumiReeTipo1B(tipo1Dett.getConsumiCombustibile(), consumiTipo1DaCancellare, ConvertUtil.convertToString(idAllegato));
		}
		catch(SigitTDettTipo1DaoException | SigitTRappTipo1DaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaReeTipo1Dett] END");
		}

	}

	@Transactional
	public void salvaReeTipo2(Tipo2 tipo2, DettaglioAllegato dettaglioAllegato, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaReeTipo2] BEGIN");
		try {

			SigitTAllegatoDto allegatoDto = cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));
			allegatoDto.setElencoApparecchiature(ReplaceSpecialCharUtils.sanitize(dettaglioAllegato.getElencoApparecchiature()));

			ReeSuperDto reeSuper = ReeSuperDto.getByTipo2(tipo2);
			popolaAllegatoDaReeSuper(reeSuper, allegatoDto);

			allegatoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
			allegatoDto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
			allegatoDto.setAbcdfControlloweb(DateUtil.getSqlDataCorrente());

			SigitTRappTipo2Dto rappTipo2 = cercaTRappTipo2ById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

			if (rappTipo2 == null)
			{
				rappTipo2 = new SigitTRappTipo2Dto();
			}

			rappTipo2.setCFlgTrattClimaNonRichiest(ConvertUtil.convertToBigDecimal(tipo2.getFlgTrattClimaNonRich()));

			rappTipo2.setDFlgLocaleIdoneo(ConvertUtil.convertToBigDecimal(tipo2.getFlgLocaleIntIdoneo()));
			rappTipo2.setDFlgApertureAdeg(ConvertUtil.convertToBigDecimal(tipo2.getFlgApertureAdeguate()));
			rappTipo2.setDFlgApertureLibere(ConvertUtil.convertToBigDecimal(tipo2.getFlgApertureLibere()));
			rappTipo2.setDFlgLineaElettIdonea(ConvertUtil.convertToBigDecimal(tipo2.getFlgLineaElettIdonea()));
			rappTipo2.setDFlgCoibIdonea(ConvertUtil.convertToBigDecimal(tipo2.getFlgCoibentIdonea()));

			// Se non e' selezionato cosa succede?
			rappTipo2.setFFlgSostituzGeneratori(ConvertUtil.convertToBigDecimal(tipo2.getFlgSostituzGeneratori()));
			rappTipo2.setFFlgSostituzSistemiReg(ConvertUtil.convertToBigDecimal(tipo2.getFlgSostituzRestemiReg()));
			rappTipo2.setFFlgIsolDistribuzH2o(ConvertUtil.convertToBigDecimal(tipo2.getFlgIsolDistribuzH2o()));
			rappTipo2.setFFlgIsolDistribuzAria(ConvertUtil.convertToBigDecimal(tipo2.getFlgIsolDistribuzAria()));

			aggiornaAllegato(allegatoDto);

			// Sono in modifica
			getSigitTRappTipo2Dao().update(rappTipo2);

			/*
			if (GenericUtil.isNullOrEmpty(rappTipo1.getIdAllegato()))
			{
				// Sono in inserimento
				rappTipo1.setIdAllegato(allegatoDto.getIdAllegato());
				getSigitTRappTipo1Dao().insert(rappTipo1);
			}
			else
			{

			}
			*/

		}
		catch(SigitTRappTipo2DaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		catch(DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw e;
		}
		finally {
			log.debug("[DbMgr::salvaReeTipo2] END");
		}
	}

	@Transactional
	public void salvaReeTipo2Dett(Tipo2Dett tipo2Dett, Tipo2DettCircuito tipo2DettCircuito, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaReeTipo2Dett] BEGIN");

		try {

			// Per sicurezza lo recupero
			SigitTDettTipo2Dto dettTipo2 = new SigitTDettTipo2Dto();

			dettTipo2.setCodiceImpianto(ConvertUtil.convertToBigDecimal(tipo2Dett.getCodImpianto()));
			dettTipo2.setFkAllegato(ConvertUtil.convertToBigDecimal(tipo2Dett.getIdAllegato()));
			dettTipo2.setProgressivo(ConvertUtil.convertToBigDecimal(tipo2Dett.getProgressivo()));
			dettTipo2.setFkTipoComponente(ReplaceSpecialCharUtils.sanitize(tipo2Dett.getIdTipoComponente()));
			dettTipo2.setDataInstall(ConvertUtil.convertToSqlDate(tipo2Dett.getDataInstallazione()));

			dettTipo2.setEFlgModProva(tipo2Dett.getFlgModProva());
			dettTipo2.setEFlgPerditaGas(ConvertUtil.convertToBigDecimal(tipo2Dett.getFlgPerditaGas()));
			dettTipo2.setEFlgLeakDetector(ConvertUtil.convertToBigDecimal(tipo2Dett.getFlgLeakDirector()));
			dettTipo2.setEFlgParamTermodinam(ConvertUtil.convertToBigDecimal(tipo2Dett.getFlgParamTermodinam()));
			dettTipo2.setEFlgIncrostazioni(ConvertUtil.convertToBigDecimal(tipo2Dett.getFlgIncrostazioni()));

			dettTipo2.setDataUltMod(DateUtil.getSqlDataCorrente());
			dettTipo2.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));


			getSigitTDettTipo2Dao().customUpdaterAggiornaDatiComuni(dettTipo2, null);

			// devo fare l'update di tutta la riga
			// setto la chiave
			dettTipo2.setIdDettTipo2(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getIdDettTipo2()));
			//dettTipo1.setFkTipoComponente(Constants.TIPO_COMPONENTE_GT);
			dettTipo2.setENCircuito(ConvertUtil.convertToString(tipo2DettCircuito.getNumCircuito()));

			dettTipo2.setETSurriscC(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getSurrisc()));
			dettTipo2.setETSottorafC(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getSottoraffredd()));
			dettTipo2.setETCondensazioneC(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getCondensazione()));

			dettTipo2.setETEvaporazioneC(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getEvaporazione()));
			dettTipo2.setETInExtC(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getInLatoEst()));
			dettTipo2.setETOutExtC(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getOutLatoEst()));
			dettTipo2.setETInUtenzeC(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getInLatoUtenze()));
			dettTipo2.setETOutUtenzeC(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getOutLatoUtenze()));

			dettTipo2.setL112TorreTOutFluido(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getTorreOutFluido()));
			dettTipo2.setL112TorreTBulboUmido(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getTorreBulboUmido()));
			dettTipo2.setL112ScambiatoreTInExt(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getScambiatoreInExt()));
			dettTipo2.setL112ScambiatoreTOutExt(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getScambiatoreOutExt()));
			dettTipo2.setL112ScambiatTInMacchina(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getScambiatoreInMacchina()));
			dettTipo2.setL112ScambiatTOutMacchina(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getScambiatoreOutMacchina()));
			dettTipo2.setL112PotenzaAssorbitaKw(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getPotenzaAssorbitaKw()));
			dettTipo2.setL112FlgPuliziaFiltri(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getFlgPulizaFiltri()));
			dettTipo2.setL112FlgVerificaSuperata(ConvertUtil.convertToBigDecimal(tipo2DettCircuito.getFlgVerificaSuperata()));
			dettTipo2.setL112DataRipristino(ConvertUtil.convertToSqlDate(tipo2DettCircuito.getDataRipristino()));

			dettTipo2.setEControlloweb(DateUtil.getSqlDataCorrente());

				// Sono in modifica
			getSigitTDettTipo2Dao().update(dettTipo2);


		}
		catch(SigitTDettTipo2DaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaReeTipo2Dett] END");
		}

	}


	private void popolaAllegatoDaRappProvaSuper (DettaglioAllegato allegatoClient, SigitTAllegatoDto allegatoDto) {
		if(GenericUtil.isNotNullOrEmpty(allegatoClient.getOsservazioni())){
			allegatoDto.setFOsservazioni(allegatoClient.getOsservazioni());
		}
		if(GenericUtil.isNotNullOrEmpty(allegatoClient.getRaccomandazioni())){
			allegatoDto.setFRaccomandazioni(allegatoClient.getRaccomandazioni());
		}
		if(GenericUtil.isNotNullOrEmpty(allegatoClient.getPrescrizioni())){
			allegatoDto.setFPrescrizioni(allegatoClient.getPrescrizioni());
		}
	}

	private void popolaAllegatoDaReeSuper(ReeSuperDto reeSuper, SigitTAllegatoDto allegatoDto) {

		allegatoDto.setAPotenzaTermicaNominaleMax(ConvertUtil.convertToBigDecimal(reeSuper.getPotenzaTermicaNomMax()));
		allegatoDto.setBFlgDichiarConform(ConvertUtil.convertToBigDecimal(reeSuper.getFlgDichiarConform()));
		allegatoDto.setBFlgLibImp(ConvertUtil.convertToBigDecimal(reeSuper.getFlgLibImp()));
		allegatoDto.setBFlgLibrettoUso(ConvertUtil.convertToBigDecimal(reeSuper.getFlgLibrettoUso()));
		allegatoDto.setBFlgLibCompl(ConvertUtil.convertToBigDecimal(reeSuper.getFlgLibCompl()));
		if(GenericUtil.isNotNullOrEmpty(reeSuper.getOsservazioni())){
			allegatoDto.setFOsservazioni(ReplaceSpecialCharUtils.sanitize(reeSuper.getOsservazioni()));
		}
		if(GenericUtil.isNotNullOrEmpty(reeSuper.getRaccomandazioni())){
			allegatoDto.setFRaccomandazioni(ReplaceSpecialCharUtils.sanitize(reeSuper.getRaccomandazioni()));
		}
		if(GenericUtil.isNotNullOrEmpty(reeSuper.getPrescrizioni())){
			allegatoDto.setFPrescrizioni(ReplaceSpecialCharUtils.sanitize(reeSuper.getPrescrizioni()));
		}
		allegatoDto.setFFlgPuoFunzionare(ConvertUtil.convertToBigDecimal(reeSuper.getFlgPuoFunzionare()));
		allegatoDto.setFInterventoEntro(ConvertUtil.convertToSqlDate(reeSuper.getInterventoEntro()));
		allegatoDto.setFOraArrivo(ReplaceSpecialCharUtils.sanitize(reeSuper.getOraArrivo()));
		allegatoDto.setFOraPartenza(ReplaceSpecialCharUtils.sanitize(reeSuper.getOraPartenza()));
		allegatoDto.setFDenominazTecnico(ReplaceSpecialCharUtils.sanitize(reeSuper.getDenominazTecnico()));

	}

	@Transactional
	public void salvaReeTipo3(Tipo3 tipo3, DettaglioAllegato dettaglioAllegato, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaReeTipo3] BEGIN");
		try {
			SigitTAllegatoDto allegatoDto = cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));
			allegatoDto.setElencoApparecchiature(ReplaceSpecialCharUtils.sanitize(dettaglioAllegato.getElencoApparecchiature()));

			ReeSuperDto reeSuper = ReeSuperDto.getByTipo3(tipo3);
			popolaAllegatoDaReeSuper(reeSuper, allegatoDto);

			allegatoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
			allegatoDto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
			allegatoDto.setAbcdfControlloweb(DateUtil.getSqlDataCorrente());

			SigitTRappTipo3Dto rappTipo3 = cercaTRappTipo3ById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

			if (rappTipo3 == null)
			{
				rappTipo3 = new SigitTRappTipo3Dto();
			}

			rappTipo3.setCFlgTrattClimaNonRichiest(ConvertUtil.convertToBigDecimal(tipo3.getFlgTrattClimaNonRich()));
			rappTipo3.setCFlgTrattAcsNonRichiesto(ConvertUtil.convertToBigDecimal(tipo3.getFlgTrattAcsNonRichiesto()));
			rappTipo3.setDFlgAssenzaPerdite(ConvertUtil.convertToBigDecimal(tipo3.getFlgAssenzaPerdite()));
			rappTipo3.setDFlgCoibIdonea(ConvertUtil.convertToBigDecimal(tipo3.getFlgCoibentIdonea()));
			rappTipo3.setDFlgLineaElettIdonea(ConvertUtil.convertToBigDecimal(tipo3.getFlgLineaElettIdonea()));
			rappTipo3.setDFlgLocaleIdoneo(ConvertUtil.convertToBigDecimal(tipo3.getFlgLocaleIntIdoneo()));
			rappTipo3.setFFlgInstallInvolucro(ConvertUtil.convertToBigDecimal(tipo3.getFlgInstallInvolucro()));
			rappTipo3.setFFlgPerditeH2o(ConvertUtil.convertToBigDecimal(tipo3.getFlgPerditeH2O()));
			rappTipo3.setFFlgValvoleTermost(ConvertUtil.convertToBigDecimal(tipo3.getFlgAdozioneValvoleTerm()));
			rappTipo3.setFFlgVerificaParam(ConvertUtil.convertToBigDecimal(tipo3.getFlgVerificaParam()));

			aggiornaAllegato(allegatoDto);

			getSigitTRappTipo3Dao().update(rappTipo3);

		} catch(SigitTRappTipo3DaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		catch(DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw e;
		}
		finally {
			log.debug("[DbMgr::salvaReeTipo3] END");
		}


	}

	@Transactional
	public void salvaReeTipo4(Tipo4 tipo4, DettaglioAllegato dettaglioAllegato, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaReeTipo4] BEGIN");
		try {


			SigitTAllegatoDto allegatoDto = cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));
			allegatoDto.setElencoApparecchiature(ReplaceSpecialCharUtils.sanitize(dettaglioAllegato.getElencoApparecchiature()));

			ReeSuperDto reeSuper = ReeSuperDto.getByTipo4(tipo4);
			popolaAllegatoDaReeSuper(reeSuper, allegatoDto);

			allegatoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
			allegatoDto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
			allegatoDto.setAbcdfControlloweb(DateUtil.getSqlDataCorrente());

			SigitTRappTipo4Dto rappTipo4 = cercaTRappTipo4ById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

			if (rappTipo4 == null)
			{
				rappTipo4 = new SigitTRappTipo4Dto();
			}

			rappTipo4.setCFlgTrattClimaNonRichiest(ConvertUtil.convertToBigDecimal(tipo4.getFlgTrattClimaNonRich()));
			//rappTipo4.setCFlgTrattAcsNonRichiesto(ConvertUtil.convertToBigDecimal(tipo4.getFlgTrattAcsNonRichiesto()));

			rappTipo4.setDFlgLuogoIdoneo(ConvertUtil.convertToBigDecimal(tipo4.getFlgLuogoIdoneo()));
			rappTipo4.setDFlgVentilazAdeg(ConvertUtil.convertToBigDecimal(tipo4.getFlgVentilazAdeg()));
			rappTipo4.setDFlgVentilazLibera(ConvertUtil.convertToBigDecimal(tipo4.getFlgVentilazLibera()));
			rappTipo4.setDFlgLineaElettIdonea(ConvertUtil.convertToBigDecimal(tipo4.getFlgLineaElettIdonea()));
			rappTipo4.setDFlgCaminoIdoneo(ConvertUtil.convertToBigDecimal(tipo4.getFlgCaminoIdoneo()));
			rappTipo4.setDFlgCapsulaIdonea(ConvertUtil.convertToBigDecimal(tipo4.getFlgCapsulaIdonea()));
			rappTipo4.setDFlgCircIdrIdoneo(ConvertUtil.convertToBigDecimal(tipo4.getFlgCircIdrIdoneo()));
			rappTipo4.setDFlgCircOlioIdoneo(ConvertUtil.convertToBigDecimal(tipo4.getFlgCircOlioIdoneo()));
			rappTipo4.setDFlgCircCombIdoneo(ConvertUtil.convertToBigDecimal(tipo4.getFlgCircCombIdoneo()));
			rappTipo4.setDFlgFunzScambIdonea(ConvertUtil.convertToBigDecimal(tipo4.getFlgFunzScambIdonea()));

			// Se non e' selezionato cosa succede?
			rappTipo4.setFFlgAdozioneValvole(ConvertUtil.convertToBigDecimal(tipo4.getFlgAdozioneValvoleTerm()));
			rappTipo4.setFFlgIsolamentoRete(ConvertUtil.convertToBigDecimal(tipo4.getFlgIsolamentoRete()));
			rappTipo4.setFFlgSistemaTrattH2o(ConvertUtil.convertToBigDecimal(tipo4.getFlgSistemaTrattH2O()));
			rappTipo4.setFFlgSostSistemaRegolaz(ConvertUtil.convertToBigDecimal(tipo4.getFlgSostSistemaRegolaz()));

			aggiornaAllegato(allegatoDto);

			// Sono in modifica
			getSigitTRappTipo4Dao().update(rappTipo4);

			/*
			if (GenericUtil.isNullOrEmpty(rappTipo4.getIdAllegato()))
			{
				// Sono in inserimento
				rappTipo4.setIdAllegato(allegatoDto.getIdAllegato());
				getSigitTRappTipo4Dao().insert(rappTipo4);
			}
			else
			{

			}
			*/

		}
		catch(SigitTRappTipo4DaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		catch(DbManagerException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw e;
		}
		finally {
			log.debug("[DbMgr::salvaReeTipo4] END");
		}
	}

	@Transactional
	public void salvaReeTipo3Dett(Tipo3Dett tipo3Dett, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaReeTipo3Dett] BEGIN");

		SigitTDettTipo3Dto dettTipo3 = new SigitTDettTipo3Dto();

		try {

			dettTipo3.setIdDettTipo3(ConvertUtil.convertToBigDecimal(tipo3Dett.getIdDettTipo3()));

			dettTipo3.setCodiceImpianto(ConvertUtil.convertToBigDecimal(tipo3Dett.getCodImpianto()));
			dettTipo3.setFkAllegato(ConvertUtil.convertToBigDecimal(tipo3Dett.getIdAllegato()));
			dettTipo3.setProgressivo(ConvertUtil.convertToBigDecimal(tipo3Dett.getProgressivo()));
			dettTipo3.setFkTipoComponente(ReplaceSpecialCharUtils.sanitize(tipo3Dett.getIdTipoComponente()));
			dettTipo3.setDataInstall(ConvertUtil.convertToSqlDate(tipo3Dett.getDataInstallazione()));

			dettTipo3.setFkFluido(ConvertUtil.convertToBigDecimal(tipo3Dett.getIdFluido()));
			dettTipo3.setFkFluidoAlimentaz(ConvertUtil.convertToBigDecimal(tipo3Dett.getFluidoAlimentazione()));
			dettTipo3.setEFlgClimaInverno(ConvertUtil.convertToBigDecimal(tipo3Dett.getFlgClimaInverno()));
			dettTipo3.setEFlgProduzAcs(ConvertUtil.convertToBigDecimal(tipo3Dett.getFlgProduzAcs()));
			dettTipo3.setEFlgPotenzaCompatibile(ConvertUtil.convertToBigDecimal(tipo3Dett.getFlgPotenzaCompatibile()));
			dettTipo3.setEFlgCoibIdonea(ConvertUtil.convertToBigDecimal(tipo3Dett.getFlgCoibIdonea()));
			dettTipo3.setEFlgDispFunzionanti(ConvertUtil.convertToBigDecimal(tipo3Dett.getFlgDispFunzionanti()));
			dettTipo3.setETempExtC(ConvertUtil.convertToBigDecimal(tipo3Dett.getTempExt()));
			dettTipo3.setETempMandPrimarioC(ConvertUtil.convertToBigDecimal(tipo3Dett.getTempMandPrimario()));
			dettTipo3.setETempRitorPrimarioC(ConvertUtil.convertToBigDecimal(tipo3Dett.getTempRitorPrimario()));
			dettTipo3.setEPotenzaTermKw(ConvertUtil.convertToBigDecimal(tipo3Dett.getPotenzaTermKw()));
			dettTipo3.setEPortFluidoM3H(ConvertUtil.convertToBigDecimal(tipo3Dett.getPortFluidoM3()));
			dettTipo3.setETempMandSecondarioC(ConvertUtil.convertToBigDecimal(tipo3Dett.getTempMandSecondario()));
			dettTipo3.setETempRitSecondarioC(ConvertUtil.convertToBigDecimal(tipo3Dett.getTempRitSecondario()));

			dettTipo3.setEControlloweb(DateUtil.getSqlDataCorrente());

			dettTipo3.setDataUltMod(DateUtil.getSqlDataCorrente());
			dettTipo3.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));

			getSigitTDettTipo3Dao().update(dettTipo3);
		} catch (SigitTDettTipo3DaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::salvaReeTipo3Dett] END");
		}

	}



	@Transactional
	public void salvaReeTipo4Dett(Tipo4Dett tipo4Dett, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::salvaReeTipo4Dett] BEGIN");

		try {

			// Per sicurezza lo recupero
			SigitTDettTipo4Dto dettTipo4 = new SigitTDettTipo4Dto();

			dettTipo4.setIdDettTipo4(ConvertUtil.convertToBigDecimal(tipo4Dett.getIdDettTipo4()));

			dettTipo4.setCodiceImpianto(ConvertUtil.convertToBigDecimal(tipo4Dett.getCodImpianto()));
			dettTipo4.setFkAllegato(ConvertUtil.convertToBigDecimal(tipo4Dett.getIdAllegato()));
			dettTipo4.setProgressivo(ConvertUtil.convertToBigDecimal(tipo4Dett.getProgressivo()));
			dettTipo4.setFkTipoComponente(ReplaceSpecialCharUtils.sanitize(tipo4Dett.getIdTipoComponente()));
			dettTipo4.setDataInstall(ConvertUtil.convertToSqlDate(tipo4Dett.getDataInstallazione()));

			dettTipo4.setFkFluido(ConvertUtil.convertToBigDecimal(tipo4Dett.getIdFluido()));

			dettTipo4.setEPotenzaAssorbCombKw(ConvertUtil.convertToBigDecimal(tipo4Dett.getPotenzaAssorbCombKw()));
			dettTipo4.setEPotenzaTermBypassKw(ConvertUtil.convertToBigDecimal(tipo4Dett.getPotenzaTermBypassKw()));


			dettTipo4.setETempAriaC(ConvertUtil.convertToBigDecimal(tipo4Dett.getTempAriaC()));
			dettTipo4.setETempH2oOutC(ConvertUtil.convertToBigDecimal(tipo4Dett.getTempH2oOutC()));
			dettTipo4.setETempH2oInC(ConvertUtil.convertToBigDecimal(tipo4Dett.getTempH2oInC()));

			dettTipo4.setEPotenzaMorsettiKw(ConvertUtil.convertToBigDecimal(tipo4Dett.getPotenzaMorsettiKw()));
			dettTipo4.setETempH2oMotoreC(ConvertUtil.convertToBigDecimal(tipo4Dett.getTempH2oMotoreC()));
			dettTipo4.setETempFumiValleC(ConvertUtil.convertToBigDecimal(tipo4Dett.getTempFumiValleC()));
			dettTipo4.setETempFumiMonteC(ConvertUtil.convertToBigDecimal(tipo4Dett.getTempFumiMonteC()));


			dettTipo4.setL114SovrafreqSogliaHzMin(ConvertUtil.convertToBigDecimal(tipo4Dett.getSovrafreqSogliaHzMin()));
			dettTipo4.setL114SovrafreqSogliaHzMed(ConvertUtil.convertToBigDecimal(tipo4Dett.getSovrafreqSogliaHzMed()));
			dettTipo4.setL114SovrafreqSogliaHzMax(ConvertUtil.convertToBigDecimal(tipo4Dett.getSovrafreqSogliaHzMax()));

			dettTipo4.setL114SovrafreqTempoSMin(ConvertUtil.convertToBigDecimal(tipo4Dett.getSovrafreqTempoSMin()));
			dettTipo4.setL114SovrafreqTempoSMed(ConvertUtil.convertToBigDecimal(tipo4Dett.getSovrafreqTempoSMed()));
			dettTipo4.setL114SovrafreqTempoSMax(ConvertUtil.convertToBigDecimal(tipo4Dett.getSovrafreqTempoSMax()));

			dettTipo4.setL114SottofreqSogliaHzMin(ConvertUtil.convertToBigDecimal(tipo4Dett.getSottofreqSogliaHzMin()));
			dettTipo4.setL114SottofreqSogliaHzMed(ConvertUtil.convertToBigDecimal(tipo4Dett.getSottofreqSogliaHzMed()));
			dettTipo4.setL114SottofreqSogliaHzMax(ConvertUtil.convertToBigDecimal(tipo4Dett.getSottofreqSogliaHzMax()));

			dettTipo4.setL114SottofreqTempoSMin(ConvertUtil.convertToBigDecimal(tipo4Dett.getSottofreqTempoSMin()));
			dettTipo4.setL114SottofreqTempoSMed(ConvertUtil.convertToBigDecimal(tipo4Dett.getSottofreqTempoSMed()));
			dettTipo4.setL114SottofreqTempoSMax(ConvertUtil.convertToBigDecimal(tipo4Dett.getSottofreqTempoSMax()));

			dettTipo4.setL114SovratensSogliaVMin(ConvertUtil.convertToBigDecimal(tipo4Dett.getSovratensSogliaVMin()));
			dettTipo4.setL114SovratensSogliaVMed(ConvertUtil.convertToBigDecimal(tipo4Dett.getSovratensSogliaVMed()));
			dettTipo4.setL114SovratensSogliaVMax(ConvertUtil.convertToBigDecimal(tipo4Dett.getSovratensSogliaVMax()));

			dettTipo4.setL114SovratensTempoSMin(ConvertUtil.convertToBigDecimal(tipo4Dett.getSovratensTempoSMin()));
			dettTipo4.setL114SovratensTempoSMed(ConvertUtil.convertToBigDecimal(tipo4Dett.getSovratensTempoSMed()));
			dettTipo4.setL114SovratensTempoSMax(ConvertUtil.convertToBigDecimal(tipo4Dett.getSovratensTempoSMax()));

			dettTipo4.setL114SottotensSogliaVMin(ConvertUtil.convertToBigDecimal(tipo4Dett.getSottotensSogliaVMin()));
			dettTipo4.setL114SottotensSogliaVMed(ConvertUtil.convertToBigDecimal(tipo4Dett.getSottotensSogliaVMed()));
			dettTipo4.setL114SottotensSogliaVMax(ConvertUtil.convertToBigDecimal(tipo4Dett.getSottotensSogliaVMax()));

			dettTipo4.setL114SottotensTempoSMin(ConvertUtil.convertToBigDecimal(tipo4Dett.getSottotensTempoSMin()));
			dettTipo4.setL114SottotensTempoSMed(ConvertUtil.convertToBigDecimal(tipo4Dett.getSottotensTempoSMed()));
			dettTipo4.setL114SottotensTempoSMax(ConvertUtil.convertToBigDecimal(tipo4Dett.getSottotensTempoSMax()));
			dettTipo4.setEControlloweb(DateUtil.getSqlDataCorrente());

			dettTipo4.setDataUltMod(DateUtil.getSqlDataCorrente());
			dettTipo4.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));


			getSigitTDettTipo4Dao().update(dettTipo4);

		}
		catch(SigitTDettTipo4DaoException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::salvaReeTipo4Dett] END");
		}

	}

	public void inserisciTDettIspezGt(BigDecimal idAllegato, SigitVSk4GtDto dtoT, String cfUtenteLoggato, int numeroModulo) throws DbManagerException
	{
		log.debug("[DbMgr::inserisciTDettIspezGt] BEGIN");
		try {
			SigitTDettIspezGtDto sigitTDettIspezGtDto = new SigitTDettIspezGtDto();
			sigitTDettIspezGtDto.setCodiceImpianto(dtoT.getCodiceImpianto());
			sigitTDettIspezGtDto.setFkAllegato(idAllegato);
			sigitTDettIspezGtDto.setFkTipoComponente(dtoT.getIdTipoComponente());
			sigitTDettIspezGtDto.setProgressivo(dtoT.getProgressivo());
			sigitTDettIspezGtDto.setDataInstall(dtoT.getDataInstall());
			sigitTDettIspezGtDto.setDataUltMod(DateUtil.getSqlDataCorrente());
			sigitTDettIspezGtDto.setUtenteUltMod(cfUtenteLoggato);
			sigitTDettIspezGtDto.setS8aNModuloTermico(ConvertUtil.convertToString(numeroModulo));

			//		sigitTDettIspezGtDto.setIdDettIspezGt(getSigitExtDao().getNextIdByTable("SIGIT_T_DETT_ISPEZ_GT", "id_dett_ispez_gt"));

			getSigitTDettIspezGtDao().insert(sigitTDettIspezGtDto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciTDettIspezGt] END");
		}
	}

	public void inserisciTDettIspezGf(BigDecimal idAllegato, SigitVSk4GfDto dtoT, String cfUtenteLoggato, int numCircuito) throws DbManagerException
	{
		log.debug("[DbMgr::inserisciTDettIspezGf] BEGIN");
		try {
			SigitTDettIspezGfDto sigitTDettIspezGfDto = new SigitTDettIspezGfDto();
			sigitTDettIspezGfDto.setCodiceImpianto(dtoT.getCodiceImpianto());
			sigitTDettIspezGfDto.setFkAllegato(idAllegato);
			sigitTDettIspezGfDto.setFkTipoComponente(dtoT.getIdTipoComponente());
			sigitTDettIspezGfDto.setProgressivo(dtoT.getProgressivo());
			sigitTDettIspezGfDto.setDataInstall(dtoT.getDataInstall());
			sigitTDettIspezGfDto.setDataUltMod(DateUtil.getSqlDataCorrente());
			sigitTDettIspezGfDto.setUtenteUltMod(cfUtenteLoggato);
			sigitTDettIspezGfDto.setS8aNCircuito(ConvertUtil.convertToString(numCircuito));


			//		sigitTDettIspezGfDto.setIdDettIspezGf(ConvertUtil.convertToInteger(getSigitExtDao().getNextIdByTable("SIGIT_T_DETT_ISPEZ_GF", "id_dett_ispez_gf")));

			getSigitTDettIspezGfDao().insert(sigitTDettIspezGfDto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciTDettIspezGf] END");
		}
	}

	public List<SigitTComp4Dto> cercaTComp4NonControllateByFilter(CompFilter filter) throws DbManagerException {
		List<SigitTComp4Dto> dtoList = null;
		log.debug("[DbMgr::cercaTComp4NonControllateByCodImp] BEGIN");
		try {


			dtoList = getSigitTComp4Dao().findNonControllateByFilter(filter);
		}
		catch(SigitTComp4DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaTComp4NonControllateByCodImp] END");
		}
		return dtoList;
	}

	//*****************************************SEZIONE DEDICATA ALLE VERIFICHE: INIZIO*********************************/
//	private SigitDTipoVerificaDao sigitDTipoVerificaDao;
//	private SigitTVerificaDao sigitTVerificaDao;
//	private SigitDTipoAzioneDao sigitDTipoAzioneDao;
//	private SigitTDocAzioneDao sigitTDocAzioneDao;



	public List<SigitTComp4Dto> cercaTComp4NonControllateByCodImp(String codiceImpianto) throws DbManagerException {
		List<SigitTComp4Dto> dtoList = null;
		log.debug("[DbMgr::cercaTComp4NonControllateByCodImp] BEGIN");
		try {

			dtoList = getSigitTComp4Dao().findNonControllateByCodImp(ConvertUtil.convertToInteger(codiceImpianto));
		}
		catch(SigitTComp4DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaTComp4NonControllateByCodImp] END");
		}
		return dtoList;
	}


	//*****************************************SEZIONE DEDICATA ALLE VERIFICHE: FINE*********************************/

	public List<IdDescription> cercaListaAutodichiarazioni() throws DbManagerException {
		log.debug("[DbMgr::cercaListaAutodichiarazioni] BEGIN");
		try {
			List<IdDescription> risultato = new ArrayList<IdDescription>();
			List<SigitDAutodichiarazioneDto> autodichiarazioniDb = getSigitDAutodichiarazioneDao().findAll();
			if (autodichiarazioniDb != null && !autodichiarazioniDb.isEmpty()) {
				for (SigitDAutodichiarazioneDto dto : autodichiarazioniDb) {
					IdDescription entry = new IdDescription();
					entry.setDescription(dto.getDesAutodichiarazione());
					entry.setId(dto.getIdAutodichiarazione());
					risultato.add(entry);
				}
			}

			return risultato;

		} catch (SigitDAutodichiarazioneDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaListaAutodichiarazioni] END");
		}
	}

	public List<SigitRContr2019AutodichiarDto> cercaListaAutodichiarazioniContratto( Integer idContratto, Integer idAutodichiarazione, String flg) throws DbManagerException {
		log.debug("[DbMgr::cercaListaAutodichiarazioniContratto] BEGIN");
		try {

			SigitRContr2019AutodichiarDto input = new SigitRContr2019AutodichiarDto();
			input.setIdContratto(idContratto);
			input.setIdAutodichiarazione(idAutodichiarazione);
			input.setFlgNominaCessa(flg);

			List<SigitRContr2019AutodichiarDto> risultato = getSigitRContr2019AutodichiarDao().findByExample(input);
			return risultato;
		} catch (SigitRContr2019AutodichiarDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}finally {
			log.debug("[DbMgr::cercaListaAutodichiarazioniContratto] END");
		}
	}


	public List<SigitRContr2019AutodichiarByExampleExtendedDto> cercaListaAutodichiarazioniContrattoExended( Integer idContratto, Integer idAutodichiarazione, String flg) throws DbManagerException {
		log.debug("[DbMgr::cercaListaAutodichiarazioniContrattoExended] BEGIN");
		try {

			SigitRContr2019AutodichiarDto input = new SigitRContr2019AutodichiarDto();
			input.setIdContratto(idContratto);
			input.setIdAutodichiarazione(idAutodichiarazione);
			input.setFlgNominaCessa(flg);

			List<SigitRContr2019AutodichiarByExampleExtendedDto> risultato = getSigitRContr2019AutodichiarDao().findByExampleExtended(input);
			return risultato;
		} catch (SigitRContr2019AutodichiarDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}finally {
			log.debug("[DbMgr::cercaListaAutodichiarazioniContrattoExended] END");
		}
	}

	private SigitDTipoCessazioneDao sigitDTipoCessazioneDao = null;


	public SigitDTipoCessazioneDao getSigitDTipoCessazioneDao() {
		return sigitDTipoCessazioneDao;
	}

	public void setSigitDTipoCessazioneDao(SigitDTipoCessazioneDao sigitDTipoCessazioneDao) {
		this.sigitDTipoCessazioneDao = sigitDTipoCessazioneDao;
	}

	private SigitTDocContrattoDao sigitTDocContrattoDao = null;

	public SigitTDocContrattoDao getSigitTDocContrattoDao() {
		return sigitTDocContrattoDao;
	}

	public void setSigitTDocContrattoDao(SigitTDocContrattoDao sigitTDocContrattoDao) {
		this.sigitTDocContrattoDao = sigitTDocContrattoDao;
	}

	public SigitTAzioneContrattoDao sigitTAzioneContrattoDao;


	public SigitTAzioneContrattoDao getSigitTAzioneContrattoDao() {
		return sigitTAzioneContrattoDao;
	}

	public void setSigitTAzioneContrattoDao(SigitTAzioneContrattoDao sigitTAzioneContrattoDao) {
		this.sigitTAzioneContrattoDao = sigitTAzioneContrattoDao;
	}

	public SigitTDocContrattoPk inserisciDocContratto(SigitTDocContrattoDto docContratto) throws DbManagerException {
		log.debug("[DbMgr::inserisciDocContratto] BEGIN");
		try {
			return getSigitTDocContrattoDao().insert(docContratto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciDocContratto] BEGIN");
		}
	}

	public void aggiornaTDocContrattoPerCreazione(SigitTDocContrattoDto dto) throws DbManagerException {
		log.debug("[DbAzioneMgr::aggiornaTDocContrattoPerCreazione] BEGIN");
		try {
			  getSigitTDocContrattoDao().updateColumnsAggiornaNomeUid(dto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbAzioneMgr::aggiornaTDocContrattoPerCreazione] END");
		}
	}

	public void aggiornaTDocContrattoPerEliminazione(SigitTDocContrattoDto dto) throws DbManagerException {
		log.debug("[DbAzioneMgr::aggiornaTDocContrattoPerEliminazione] BEGIN");
		try {
			  getSigitTDocContrattoDao().updateColumnsAggiornaPerEliminazione(dto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbAzioneMgr::aggiornaTDocContrattoPerEliminazione] END");
		}
	}


	public List<SigitTDocContrattoDto> cercaContratti2019 (SigitTDocContrattoDto example) throws DbManagerException {
		log.debug("[DbAzioneMgr::cercaContratti2019] BEGIN");
		try {
			return getSigitTDocContrattoDao().findFindByExample(example);
		} catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbAzioneMgr::cercaContratti2019] END");
		}


	}

	@Transactional
	public void salvaDistributoreManuale(DistributoreMan distrib, Distributore distributore, ArrayList<CodeDescription> indirizziForn, ArrayList<CodeDescription> indirizziFatt,String utenteUltMod) throws DbManagerException
	{
		log.debug("[DbMgr::salvaDistributoreManuale] BEGIN");
		try {

        	int idImport = getIdSeqImportDistrib();

			SigitTImportDistribDto dtoImport = new SigitTImportDistribDto();
			dtoImport.setIdImportDistrib(idImport);
			dtoImport.setFkPersonaGiuridica(ConvertUtil.convertToBigDecimal(distributore.getDistrId()));
			dtoImport.setAnnoRiferimento(ConvertUtil.convertToBigDecimal(distrib.getAnnoRiferimento()));
			dtoImport.setNomeFileImport(Constants.DESC_CARICAMENTO_MANUALE + " " + ReplaceSpecialCharUtils.sanitize(distrib.getCfPivaForn()));
			dtoImport.setDataInizioElab(DateUtil.getSqlDataCorrente());
			dtoImport.setDataFineElab(DateUtil.getSqlDataCorrente());
			dtoImport.setFkStatoDistrib(Constants.ID_STATO_IMP_DISTRIBUTORE_INVIATO);
			dtoImport.setTotRecordElaborati(new BigDecimal(1));
			dtoImport.setTotRecordScartati(new BigDecimal(0));
			dtoImport.setDataInvioMailAssistenza(DateUtil.getSqlDataCorrente());
			dtoImport.setUtenteCaricamento(ReplaceSpecialCharUtils.sanitize(utenteUltMod));
			dtoImport.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(utenteUltMod));
			dtoImport.setDataUltMod(DateUtil.getSqlDataCorrente());

			SigitTImportDistribPk dtoImportPk = getSigitTImportDistribDao().insert(dtoImport);

			log.debug("[DbMgr::salvaDistributoreManuale] idImportDistrib(): "+dtoImportPk.getIdImportDistrib());


			SigitTDatoDistribDto dtoDistrib = MapDto.mapToSigitTDatoDistribDto(distrib, indirizziForn, indirizziFatt, utenteUltMod);
			dtoDistrib.setFkImportDistrib(dtoImportPk.getIdImportDistrib());

			getSigitTDatoDistribDao().insert(dtoDistrib);



		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::salvaDistributoreManuale] END");
		}
	}

	public String cercaIndirizzoMailAbilitazioneValidatore(String istatAbilitazione, int idRuloPa) throws DbManagerException {
		log.debug("[DbAzioneMgr::cercaIndirizzoMailAbilitazioneValidatore] BEGIN");
		try {
			String mail = null;

			SigitTAbilitazioneDto filter = new SigitTAbilitazioneDto();
			filter.setIdRuoloPa(idRuloPa);
			filter.setIstatAbilitazione(Constants.COD_ISTAT_PIEMONTE+istatAbilitazione);


			List<SigitTAbilitazioneDto> abilitazioni = getSigitTAbilitazioneDao().findByExample(filter);

			if (abilitazioni != null && !abilitazioni.isEmpty() && abilitazioni.get(0) != null && abilitazioni.get(0).getMailComunicazione() != null)
			{
				mail = abilitazioni.get(0).getMailComunicazione();
			}

			return mail;
		} catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbAzioneMgr::cercaIndirizzoMailAbilitazioneValidatore] END");
		}


	}

	public ArrayList<String> cercaIndirizziMailAbilitazioneByRuolo(int idRuloPa) throws DbManagerException {
		log.debug("[DbAzioneMgr::cercaIndirizziMailAbilitazioneByRuolo] BEGIN");
		try {
			ArrayList<String> destinatari = null;

			SigitTAbilitazioneDto filter = new SigitTAbilitazioneDto();
			filter.setIdRuoloPa(idRuloPa);


			List<SigitTAbilitazioneDto> abilitazioni = getSigitTAbilitazioneDao().findByExample(filter);

			if (abilitazioni != null && !abilitazioni.isEmpty())
			{
				destinatari = new ArrayList<String>();
				for (SigitTAbilitazioneDto abilitazione : abilitazioni) {

					if (GenericUtil.isNotNullOrEmpty(abilitazione.getMailComunicazione()))
					{
						destinatari.add(abilitazione.getMailComunicazione());
					}

				}
			}

			return destinatari;
		} catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbAzioneMgr::cercaIndirizziMailAbilitazioneByRuolo] END");
		}


	}


	public SigitVCompGfDao getSigitVCompGfDao() {
		return sigitVCompGfDao;
	}

	public void setSigitVCompGfDao(SigitVCompGfDao sigitVCompGfDao) {
		this.sigitVCompGfDao = sigitVCompGfDao;
	}


	public List<SigitTSanzioneDto> getElencoSanzioniByFilter(RicercaSanzioniFilter filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoSanzioniByFilter] BEGIN");
		try {
			return getSigitTSanzioneDao().findByRicerca(filter);
		} catch (SigitTSanzioneDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getElencoSanzioniByFilter] END");
		}

	}

	public void pagaSanzione(String dataPagamento, Integer idSanzione) throws DbManagerException {
		log.debug("[DbMgr::pagaSanzione] BEGIN");
		try {
			SigitTSanzioneDto sanzioneDb = new SigitTSanzioneDto();
			sanzioneDb.setIdSanzione(idSanzione);
			sanzioneDb.setDtPagamento(ConvertUtil.convertToSqlDate(dataPagamento));
			sanzioneDb.setFkStatoSanzione(Constants.ID_STATO_SANZIONE_PAGATA);

			getSigitTSanzioneDao().updateColumnsPerPagamento(sanzioneDb);
		} catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::pagaSanzione] END");
		}
	}

	public DatiInserimentoSanzione inserisciModificaSanzionato(DatiInserimentoSanzione sanzione, String cfUtenteMod) throws DbManagerException {
		log.debug("[DbMgr::inserisciModificaSanzionato] BEGIN");
		try {

			//se nella sanzione sono settati gli id delle persone sanzionate, esse esistono gia' nel db e vanno solo modificate
			if (GenericUtil.isNullOrEmpty(sanzione.getIdSanzionatoFisico()) && GenericUtil.isNullOrEmpty(sanzione.getIdSanzionatoGiuridico())) {
				//trattasi di inserimento anche della persona fisica/giuridica

				if (sanzione.getFlgEnteImpresa()) {
					//si tratta di una impresa
					SigitTPersonaGiuridicaPk personaGiuridica = getSigitTPersonaGiuridicaDao().insert(MapDto.mapToSigitTPersonaGiuridicaDto(sanzione, cfUtenteMod, null));
					sanzione.setIdSanzionatoGiuridico(ConvertUtil.convertToInteger(personaGiuridica.getIdPersonaGiuridica()));
				} else {
					SigitTPersonaFisicaPk personaFisica = getSigitTPersonaFisicaDao().insert(MapDto.mapToSigitTPersonaFisicaDto(sanzione, cfUtenteMod, null));
					sanzione.setIdSanzionatoFisico(ConvertUtil.convertToInteger(personaFisica.getIdPersonaFisica()));
				}

			} else {

				if (sanzione.getFlgEnteImpresa()) {
					SigitTPersonaGiuridicaDto sigitTPersonaGiuridicaDto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(ConvertUtil.convertToBigDecimal(sanzione.getIdSanzionatoGiuridico())));
					getSigitTPersonaGiuridicaDao().update(MapDto.mapToSigitTPersonaGiuridicaDto(sanzione, cfUtenteMod, sigitTPersonaGiuridicaDto));
				} else {
					SigitTPersonaFisicaDto sigitTPersonaFisicaDto = getSigitTPersonaFisicaDao().findByPrimaryKey(new SigitTPersonaFisicaPk(ConvertUtil.convertToBigDecimal(sanzione.getIdSanzionatoFisico())));
					getSigitTPersonaFisicaDao().update(MapDto.mapToSigitTPersonaFisicaDto(sanzione, cfUtenteMod, sigitTPersonaFisicaDto));

				}

			}

			return sanzione;

		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::inserisciModificaSanzionato] END");
		}
	}


	public String annullaSanzione(it.csi.sigit.sigitwebn.dto.sanzioni.Sanzione sanzione) throws DbManagerException {
		log.debug("[DbMgr::annullaSanzione] BEGIN");
		try {
			SigitTSanzioneDto sanzioneDb = cercaSanzioneDaId(sanzione.getIdSanzione());

			//l'annullamento determina il settaggio delle info sulla sveglia
			sanzioneDb.setDtSveglia(null);
			sanzioneDb.setNoteSveglia(null);

			//il settaggio dello stato in annullata
			sanzioneDb.setFkStatoSanzione(Constants.ID_STATO_SANZIONE_ANNULLATA);

			//il settaggio del motivo sanzione
			sanzioneDb.setMotivoAnnullamento(sanzione.getDescMotivoAnnullamento());
			sanzioneDb.setDtAnnullamento(DateUtil.getSqlCurrentDate());

			getSigitTSanzioneDao().updateColumnsPerAnnullamento(sanzioneDb);

			if (!GenericUtil.isNullOrEmpty(sanzioneDb.getCfResponsabile())) {
				//viene quindi recuperata la mail del soggetto responsabile a cui inviare la notifica di annullamento della sanzione
				PersonaFisica responsabilePa = cercaPersonaFisicaByCF(sanzioneDb.getCfResponsabile());
				return responsabilePa.getEmail();
			} else {
				return null;
			}

		} catch (SigitTSanzioneDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::annullaSanzione] END");
		}
	}

	private DbAzioneMgr dbAzioneMgr;


	public DbAzioneMgr getDbAzioneMgr() {
		return dbAzioneMgr;
	}

	public void setDbAzioneMgr(DbAzioneMgr dbAzioneMgr) {
		this.dbAzioneMgr = dbAzioneMgr;
	}



	public String associaSanzione(boolean isValidatore, it.csi.sigit.sigitwebn.dto.sanzioni.Sanzione sanzione,
			PersonaFisica nuovoAssegnatario, UtenteLoggato utente) throws DbManagerException {
		log.debug("[DbMgr::associaSanzione] BEGIN");

		try {
			SigitTSanzioneDto sanzioneDb = cercaSanzioneDaId(sanzione.getIdSanzione());

			boolean variazioneAssegnatario = false;
			boolean primaAssegnazione = GenericUtil.isNullOrEmpty(sanzioneDb.getCfResponsabile());

			//PersonaFisica nuovoAssegnatario = cercaPersonaFisicaByCF(cfNuovo);

			StringBuffer sbDescr = new StringBuffer("Variazione utente assegnatario ");
			if (!primaAssegnazione) {
				if (!sanzioneDb.getCfResponsabile().equalsIgnoreCase(nuovoAssegnatario.getCodiceFiscale())) {
					variazioneAssegnatario = true;

					sbDescr.append(" da " + ConvertUtil.getStringByConcat(" ", sanzioneDb.getDenomUtResponsabile()));
					sbDescr.append(" (" + sanzioneDb.getCfResponsabile() + ")");
				} else {
					variazioneAssegnatario = false;
				}

			} else {

				variazioneAssegnatario = true;
			}

			if (variazioneAssegnatario) {

				sanzioneDb.setCfResponsabile(nuovoAssegnatario.getCodiceFiscale());
				sanzioneDb.setDenomUtResponsabile(nuovoAssegnatario.getDenominazione());

				getSigitTSanzioneDao().updateColumnsPerAssegnazione(sanzioneDb);

				sbDescr.append(" a " + ConvertUtil.getStringByConcat(" ", nuovoAssegnatario.getNome(),nuovoAssegnatario.getCognome()));
				sbDescr.append(" (" + nuovoAssegnatario.getCodiceFiscale() + ")");

				getDbAzioneMgr().inserisciAzioneSimply(sbDescr.toString(), Constants.ID_TIPO_AZIONE_SANZIONE, utente,sanzione.getIdSanzione());

			}

			return variazioneAssegnatario ? nuovoAssegnatario.getEmail() : null;
		} catch (DbManagerException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTSanzioneDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::associaSanzione] END");
		}

	}

	public List<SigitRPfRuoloPaByExampleDto> getElencoAbilitazioniByFilter(SigitRPfRuoloPaDto filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoAbilitazioniByFilter] BEGIN");
		try {

			return getSigitRPfRuoloPaDao().findByExample(filter);

		} catch (SigitRPfRuoloPaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getElencoAbilitazioniByFilter] END");
		}

	}

	public List<SigitRPfRuoloPaAllActiveDto> getElencoAbilitazioniAttiveByFilter(SigitRPfRuoloPaDto filter) throws DbManagerException {
		log.debug("[DbMgr::getElencoAbilitazioniAttiveByFilter] BEGIN");
		try {

			return getSigitRPfRuoloPaDao().findAllActive(filter);

		} catch (SigitRPfRuoloPaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getElencoAbilitazioniAttiveByFilter] END");
		}

	}

	public void cessaAbilitazione(SigitRPfRuoloPaDto ruoloPa) throws DbManagerException {
		log.debug("[DbMgr::cessaDelega] BEGIN");
		try {

			getSigitRPfRuoloPaDao().updateColumnsCessaAbilitazione(ruoloPa);

		}
		catch(SigitRPfRuoloPaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cessaDelega] END");
		}
	}

	public void cessaProprietario(Proprietario proprietario, String utenteUltMod) throws DbManagerException {
		log.debug("[DbMgr::cessaProprietario] BEGIN");
		try {

			SigitRImpRuoloPfpgDto proprietarioDto = new SigitRImpRuoloPfpgDto();

			proprietarioDto.setIdImpRuoloPfpg(ConvertUtil.convertToBigDecimal(proprietario.getIdImpRuoloPfPg()));
			proprietarioDto.setDataFine(ConvertUtil.convertToSqlDate(proprietario.getDataFine()));

			proprietarioDto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(utenteUltMod));
			proprietarioDto.setDataUltMod(DateUtil.getSqlDataCorrente());

			getSigitRImpRuoloPfpgDao().updateColumnsTerminaRiga(proprietarioDto);

		}
		catch(SigitRImpRuoloPfpgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cessaProprietario] END");
		}
	}

	public void aggiornaMailAbilitazione(SigitTAbilitazioneDto abilitazione) throws DbManagerException {
		log.debug("[DbMgr::cessaDelega] BEGIN");
		try {

			getSigitTAbilitazioneDao().update(abilitazione);

		}
		catch(SigitTAbilitazioneDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cessaDelega] END");
		}
	}

	@Transactional
	public void salvaAbilitazione(SigitRPfRuoloPaDto ruoloPa, SigitTAbilitazioneDto abilitazione) throws DbManagerException
	{
		log.debug("[DbMgr::salvaAbilitazione] BEGIN");
		try {

			SigitTAbilitazioneDto abilitazioneIsPres = getSigitTAbilitazioneDao().findByPrimaryKey(abilitazione.createPk());

			if (abilitazioneIsPres == null)
			{
				getSigitTAbilitazioneDao().insert(abilitazione);
			}

			getSigitRPfRuoloPaDao().insert(ruoloPa);

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::salvaAbilitazione] END");
		}
	}

	public RiepilogoStoricizzazione getRecordsLog(RiepilogoStoricizzazione riepilogo)  throws DbManagerException {
		log.debug("[DbMgr::getRecordsLog] BEGIN");
		try {

			Integer countStor = getSigitExtDao().findLogDaStoricizzareCount();
			Integer countCanc = getSigitExtDao().findLogDaCancellareCount();

			riepilogo.setLogStor(countStor);
			riepilogo.setLogCanc(countCanc);

			return riepilogo;

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getRecordsLog] END");
		}
	}

	public RiepilogoStoricizzazione getRecordsLibretti(RiepilogoStoricizzazione riepilogo)  throws DbManagerException {
		log.debug("[DbMgr::getRecordsLibretti] BEGIN");
		try {

			Integer countStor = getSigitExtDao().findLibrettiDaStoricizzareCount();
			Integer countCanc = getSigitExtDao().findLibrettiDaCancellareCount();

			riepilogo.setLibrettiStor(countStor);
			riepilogo.setLibrettiCanc(countCanc);

			return riepilogo;

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getRecordsLibretti] END");
		}
	}

	public RiepilogoStoricizzazione getRecordsLogAccesso(RiepilogoStoricizzazione riepilogo)  throws DbManagerException {
		log.debug("[DbMgr::getRecordsLibretti] BEGIN");
		try {

			Integer countStor = getSigitExtDao().findLogAccessoDaStoricizzareCount();
			Integer countCanc = getSigitExtDao().findLogAccessoDaCancellareCount();

			riepilogo.setLogAccessoStor(countStor);
			riepilogo.setLogAccessoCanc(countCanc);

			return riepilogo;

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getRecordsLibretti] END");
		}
	}

	public Integer getRecordsImpiantiSenzaCoordinate()  throws DbManagerException {
		log.debug("[DbMgr::getRecordsImpiantiSenzaCoordinate] BEGIN");
		try {
			return getSigitExtDao().findImpiantiSenzaCoordinateCount();
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getRecordsImpiantiSenzaCoordinate] END");
		}
	}

	public Integer getRecordsImpiantiAggiornatiAData(String date)  throws DbManagerException {
		log.debug("[DbMgr::getRecordsImpiantiAggiornatiAData] BEGIN");
		try {

			String dateCorrectFormat = convertConfigDateToSqlFormat(date);

			return getSigitExtDao().findImpiantiAggiornatiADataCount(dateCorrectFormat);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getRecordsImpiantiAggiornatiAData] END");
		}
	}

	/*
	// DA CANCELLARE
	@Transactional
	public void storicizzaLog()  throws DbManagerException {
		log.debug("[DbMgr::storicizzaLog] BEGIN");
		try {

			getSigitWrkLogPrecDao().customDeleterAll(null);

			getSigitExtDao().storicizzaLog();

			getSigitWrkLogDao().customDeleterOld(null);

			OLD
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::storicizzaLog] END");
		}
	}
	*/

	public void eliminaWrkLogPrecOld() throws DbManagerException {
		log.debug("[DbMgr::eliminaWrkLogPrec] BEGIN");
		try {

			getSigitWrkLogPrecDao().customDeleterOld(null);

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::eliminaWrkLogPrec] END");
		}
	}

	public List<SigitWrkLogDto> recuperaLogDaArchiviare() throws DbManagerException {
		log.debug("[DbMgr::recuperaLogDaArchiviare] BEGIN");
		try {

			List<SigitWrkLogDto> daArchiviareList = getSigitWrkLogDao().findDaArchiviare(null);

			return daArchiviareList;

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::recuperaLogDaArchiviare] END");
		}
	}

	public void salvaLogStorico(SigitWrkLogPrecDto logPrec) throws DbManagerException
	{
		log.debug("[DbMgr::salvaLogStorico] BEGIN");
		try {

			getSigitWrkLogPrecDao().insert(logPrec);

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLogStorico] END");
		}
	}

	public void eliminaWrkLogById(Integer idLog)  throws DbManagerException {
		log.debug("[DbMgr::eliminaWrkLogById] BEGIN");
		try {

			getSigitWrkLogDao().delete(new SigitWrkLogPk(idLog));

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::eliminaWrkLogById] END");
		}
	}

	public List<SigitSLibrettoDto> recuperaLibrettiDaCancellare()  throws DbManagerException {
		log.debug("[DbMgr::recuperaLibrettiDaCancellare] BEGIN");
		try {

			List<SigitSLibrettoDto> daCancellareList = getSigitSLibrettoDao().findDaCancellare(null);

			return daCancellareList;

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::recuperaLibrettiDaCancellare] END");
		}
	}

	public void eliminaSLibrettoById(BigDecimal idLibretto)  throws DbManagerException {
		log.debug("[DbMgr::eliminaSLibrettoById] BEGIN");
		try {

			getSigitSLibrettoDao().delete(new SigitSLibrettoPk(idLibretto));

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::eliminaSLibrettoById] END");
		}
	}

	public List<SigitTLibrettoDto> recuperaLibrettiDaArchiviare()  throws DbManagerException {
		log.debug("[DbMgr::recuperaLibrettiDaArchiviare] BEGIN");
		try {

			List<SigitTLibrettoDto> daArchiviareList = getSigitTLibrettoDao().findDaArchiviare(null);

			return daArchiviareList;

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::recuperaLibrettiDaArchiviare] END");
		}
	}

	public void salvaLibrettoStorico(SigitSLibrettoDto libretto) throws DbManagerException
	{
		log.debug("[DbMgr::salvaLibrettoStorico] BEGIN");
		try {

			getSigitSLibrettoDao().insert(libretto);

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLibrettoStorico] END");
		}
	}

	public void eliminaTLibrettoById(BigDecimal idLibretto)  throws DbManagerException {
		log.debug("[DbMgr::eliminaTLibrettoById] BEGIN");
		try {

			getSigitTLibrettoDao().delete(new SigitTLibrettoPk(idLibretto));

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::eliminaTLibrettoById] END");
		}
	}


	public void eliminaTLibrettoTxtById(BigDecimal idLibretto)  throws DbManagerException {
		log.debug("[DbMgr::eliminaTLibrettoTxtById] BEGIN");
		try {

			getSigitTLibTxtDao().delete(new SigitTLibTxtPk(idLibretto));

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::eliminaTLibrettoTxtById] END");
		}
	}

	public void eliminaLogAccessoOld() throws DbManagerException {
		log.debug("[DbMgr::eliminaLogAccessoOld] BEGIN");
		try {

			getSigitSAccessoDao().customDeleterOld(null);

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::eliminaLogAccessoOld] END");
		}
	}

	public List<SigitLAccessoDto> recuperaLogAccessoDaArchiviare() throws DbManagerException {
		log.debug("[DbMgr::recuperaLogAccessoDaArchiviare] BEGIN");
		try {

			List<SigitLAccessoDto> daArchiviareList = getSigitLAccessoDao().findDaArchiviare(null);

			return daArchiviareList;

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::recuperaLogAccessoDaArchiviare] END");
		}
	}

	public void salvaLogAccessoStorico(SigitSAccessoDto logAccessoDaArch) throws DbManagerException
	{
		log.debug("[DbMgr::salvaLogAccessoStorico] BEGIN");
		try {

			getSigitSAccessoDao().insert(logAccessoDaArch);

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::salvaLogAccessoStorico] END");
		}
	}

	public void eliminaLogAccessoByPk(Timestamp dtAccesso, String codiceFiscale)  throws DbManagerException {
		log.debug("[DbMgr::eliminaLogAccessoByPk] BEGIN");
		try {

			getSigitLAccessoDao().delete(new SigitLAccessoPk(dtAccesso, codiceFiscale));

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::eliminaLogAccessoByPk] END");
		}
	}

	public SigitRIspezIspetDto cercaUltimoRIspezIspetByIdIspezione(String idIspezione) throws DbManagerException {
		SigitRIspezIspetDto ispezIspet = null;
		try {
			List<SigitRIspezIspetDto> ispezIspetList = getSigitRIspezIspetDao().findByIdIspezione(ConvertUtil.convertToInteger(idIspezione));

			if (ispezIspetList != null && ispezIspetList.size() > 0)
			{
				// Prendo l'ispettore piu' recente
				ispezIspet = ispezIspetList.get(0);
			}

			return ispezIspet;
		} catch (SigitRIspezIspetDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
	}

	public List<SigitTPersonaGiuridicaDto> cercaPersonaGiuridica(PersonaGiuridica pg, boolean flgIsAttivi) throws DbManagerException {
		log.debug("[DbMgr::cercaPersonaGiuridica] BEGIN");
		List<SigitTPersonaGiuridicaDto> dtoList = null;

		try {
			CodiceReaAndFiscaleFilter ricImpresa = new CodiceReaAndFiscaleFilter(pg.getSiglaRea(), ConvertUtil.convertToBigDecimal(pg.getNumeroRea()), pg.getCodiceFiscale());
			ricImpresa.setFlgSoloAttivi(flgIsAttivi);

			dtoList = getSigitTPersonaGiuridicaDao().findByCodiceReaAndFiscale(ricImpresa);

		}
		catch(SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaPersonaGiuridica] END");
		return dtoList;
	}

	public List<SigitExtIspezioniDto> cercaIspezioniDett(ArrayList<String> listIdIspezioni) throws DbManagerException {
		log.debug("[DbMgr::cercaIspezioniDett] BEGIN");
		List<SigitExtIspezioniDto> dtoList = null;

		try {

			if (listIdIspezioni != null && listIdIspezioni.size() > 0)
			{
				dtoList = new ArrayList<SigitExtIspezioniDto>();
				// Questa query mi ritorna dei recodr duplicati, quindi devo escludere i doppioni
				List<SigitExtIspezioniDto> dtoListAll = getSigitExtDao().findIspezioniDettByListIdIspez(listIdIspezioni);

				Integer lastIdIspezione2018 = null;

				for (SigitExtIspezioniDto sigitExtIspezioniDto : dtoListAll) {

					if (!sigitExtIspezioniDto.getIdIspezione2018().equals(lastIdIspezione2018))
					{
						// E' un'ispezione ancora NON presente nella lista, quindi l'aggiungo
						lastIdIspezione2018 = sigitExtIspezioniDto.getIdIspezione2018();

						dtoList.add(sigitExtIspezioniDto);
					}
					// else se � un'ispezione gia' presente nella lista lo scarto

				}
			}

		}
		catch(SigitExtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaIspezioniDett] END");
		return dtoList;
	}


	public List<SigitExtIspezioniConCodImpiantoDto> cercaIspezioniDettConCodImpianto(ArrayList<String> listCodImpianti) throws DbManagerException {
		log.debug("[DbMgr::cercaIspezioniDettConCodImpianto] BEGIN");
		List<SigitExtIspezioniConCodImpiantoDto> dtoList = null;

		try {

			dtoList = getSigitExtDao().findIspezioniDettConCodImpiantoByListConImpianti(listCodImpianti);

		}
		catch(SigitExtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaIspezioniDettConCodImpianto] END");
		return dtoList;
	}

	public List<SigitExtIspezioniSenzaCodImpiantoDto> cercaIspezioniDettSenzaCodImpianto(ArrayList<String> listIdIspezioni) throws DbManagerException {
		log.debug("[DbMgr::cercaIspezioniDettSenzaCodImpianto] BEGIN");
		List<SigitExtIspezioniSenzaCodImpiantoDto> dtoList = null;

		try {

			dtoList = getSigitExtDao().findIspezioniDettSenzaCodImpiantoByListIdIspez(listIdIspezioni);

		}
		catch(SigitExtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaIspezioniDettSenzaCodImpianto] END");
		return dtoList;
	}

	public List<SigitTComp4Dto> cercaComp4ByImpiantoETipiComp(String codImpianto, List<String> listTipiComponente) throws DbManagerException {
		log.debug("[DbMgr::cercaComp4ByImpiantoETipiComp] BEGIN");
		List<SigitTComp4Dto> dtoList = null;

		try {

			CompFilter comp4Filter = new CompFilter();
			comp4Filter.setCodImpianto(codImpianto);
			comp4Filter.setListTipiComponente(listTipiComponente);

			dtoList = getSigitTComp4Dao().findByFilter(comp4Filter);

		}
		catch(SigitTComp4DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaComp4ByImpiantoETipiComp] END");
		return dtoList;
	}

	public SigitRPfRuoloPaDto cercaAbilitazioneRuoloPaByPrimaryKey(BigDecimal idPersonaFisica, Integer idRuoloPa, String istatAbilitazione) throws DbManagerException {
		log.debug("[DbMgr::cercaAbilitazioneRuoloPaByPrimaryKey] BEGIN");
		SigitRPfRuoloPaDto abilitazioneRuoloPa = null;
		SigitRPfRuoloPaPk pk = new SigitRPfRuoloPaPk(idPersonaFisica, idRuoloPa, istatAbilitazione, DateUtil.getSqlCurrentDate());

		try {
			abilitazioneRuoloPa = getSigitRPfRuoloPaDao().findByPrimaryKey(pk);
		} catch (SigitRPfRuoloPaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}

		log.debug("[DbMgr::cercaAbilitazioneRuoloPaByPrimaryKey] END");
		return abilitazioneRuoloPa;
	}

	public List<SigitTImpiantoDto> cercaImpiantiDtoByFiltro(ImpiantoFilter filter) throws DbManagerException {
		List<SigitTImpiantoDto> dtoList = null;
		log.debug("[DbMgr::cercaImpiantoByFiltro] BEGIN");
		try {

			dtoList = getSigitTImpiantoDao().findByFilter(filter);

		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaImpiantoByFiltro] END");
		}
		return dtoList;
	}

	public ArrayList<UserWs> getAllUserWs() throws DbManagerException {
		ArrayList<UserWs> dtoList = null;
		log.debug("[DbMgr::getAllUserWs] BEGIN");
		try {

			dtoList = MapDto.mapToUserWsList(getSigitTUserWsDao().findUserWsCustom(1));

		} catch (SigitTUserWsDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getAllUserWs] END");
		}
		return dtoList;
	}


	public List<SigitRComp4ManutAllDto> cercaComp4ManutAllByComp(CompFilter filter) throws DbManagerException {
		List<SigitRComp4ManutAllDto> dtoList = null;
		log.debug("[DbMgr::cercaComp4ManutAllByComp] BEGIN");
		try {

			dtoList = getSigitRComp4ManutAllDao().findByComp(filter);

		} catch (SigitRComp4ManutAllDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaComp4ManutAllByComp] END");
		}
		return dtoList;
	}

	public void aggiornaUserWs(SigitTUserWsDto userWsDto) throws DbManagerException {
		log.debug("[DbMgr::aggiornaUserWs] END");
		try {

			getSigitTUserWsDao().update(userWsDto);

		} catch (SigitTUserWsDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} finally {
			log.debug("[DbMgr::aggiornaUserWs] END");
		}
	}

	public void aggiornaPersonaGiuridicaDto(SigitTPersonaGiuridicaDto personaGiuridicaDto, String cfUtente) throws DbManagerException {
		log.debug("[DbMgr::aggiornaPersonaGiuridicaDto] START");
		try {
			personaGiuridicaDto.setUtenteUltMod(cfUtente);
			personaGiuridicaDto.setDataUltMod(DateUtil.getSqlDataCorrente());

			getSigitTPersonaGiuridicaDao().update(personaGiuridicaDto);

		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} finally {
			log.debug("[DbMgr::aggiornaPersonaGiuridicaDto] END");
		}
	}

	public void inserisciLogAccesso(SigitTPersonaFisicaDto personaFisica, String ruolo) throws DbManagerException {
		log.debug("[DbMgr::inserisciLogAccesso] START");
		try {
			SigitLAccessoDto accesso = new SigitLAccessoDto();
			accesso.setCodiceFiscale(ReplaceSpecialCharUtils.sanitize(personaFisica.getCodiceFiscale()));
			accesso.setNome(ReplaceSpecialCharUtils.sanitize(personaFisica.getNome().toUpperCase()));
			accesso.setCognome(ReplaceSpecialCharUtils.sanitize(personaFisica.getCognome().toUpperCase()));
			accesso.setRuolo(ReplaceSpecialCharUtils.sanitize(ruolo));
			accesso.setDtAccesso(DateUtil.getSqlDataCorrente());

			getSigitLAccessoDao().insert(accesso);

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[DbMgr::inserisciLogAccesso] END");
		}
	}

	@Transactional
	public Ispezione2018 inserisciIspezioneMassivaImpianto(SigitTImpiantoDto impianto, boolean isIspezionePagamento, UtenteLoggato utenteLoggato) throws DbManagerException {
		log.debug("DbMgr::inserisciIspezioneMassivaImpianto");
		try {

			SigitTVerificaDto verifica = new SigitTVerificaDto();

			verifica.setFkTipoVerifica(Constants.ID_TIPO_VERIFICA_IMPIANTO);
			verifica.setCodiceImpianto(impianto.getCodiceImpianto());
			verifica.setCfUtenteCaricamento(utenteLoggato.getCodiceFiscale());
			verifica.setDenomUtenteCaricamento(utenteLoggato.getDenominazione());
			verifica.setDtCaricamento(DateUtil.getSqlCurrentDate());
			verifica.setNote("creazione massiva");

			SigitTVerificaPk verificaPk = getDbVerificaMgr().salvaVerifica(verifica);

			Ispezione2018 ispezione = new Ispezione2018();
			ispezione.setIdVerifica(ConvertUtil.convertToString(verificaPk.getIdVerifica()));
			ispezione.setIdAccertamento("0");
			ispezione.setCodiceImpianto(ConvertUtil.convertToString(impianto.getCodiceImpianto()));
			ispezione.setCodIstatProv(GenericUtil.getCodIstatProvByCodIstatComune(impianto.getIstatComune()));
			ispezione.setFlgIspPagamento(isIspezionePagamento);

			SigitTIspezione2018Pk ispezione2018Pk = getDbIspezioneMgr().inserisciIspezione2018(ispezione);

			ispezione.setIdentificativoIspezione(ConvertUtil.convertToString(ispezione2018Pk.getIdIspezione2018()));

			return ispezione;

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("DbMgr::inserisciIspezioneMassivaImpianto");
		}
	}

	@Transactional
	public Ispezione2018 inserisciIspezioneMassivaDatoDistributore(SigitTDatoDistribDto datoDistrib, boolean isIspezionePagamento, UtenteLoggato utenteLoggato) throws DbManagerException {
		log.debug("DbMgr::inserisciIspezioneMassivaDatoDistributore");
		try {

			SigitTVerificaDto verifica = new SigitTVerificaDto();

			verifica.setFkTipoVerifica(Constants.ID_TIPO_VERIFICA_DATO_DISTRIBUTORE);
			verifica.setFkDatoDistrib(datoDistrib.getIdDatoDistrib());
			verifica.setCfUtenteCaricamento(utenteLoggato.getCodiceFiscale());
			verifica.setDenomUtenteCaricamento(utenteLoggato.getDenominazione());
			verifica.setDtCaricamento(DateUtil.getSqlCurrentDate());
			verifica.setNote("creazione massiva");

			SigitTVerificaPk verificaPk = getDbVerificaMgr().salvaVerifica(verifica);

			Ispezione2018 ispezione = new Ispezione2018();
			ispezione.setIdVerifica(ConvertUtil.convertToString(verificaPk.getIdVerifica()));
			ispezione.setIdAccertamento("0");
			ispezione.setCodiceImpianto("0");
			ispezione.setCodIstatProv(GenericUtil.getCodIstatProvByCodIstatComune(datoDistrib.getIstatComune()));
			ispezione.setFlgIspPagamento(isIspezionePagamento);

			SigitTIspezione2018Pk ispezione2018Pk = getDbIspezioneMgr().inserisciIspezione2018(ispezione);

			ispezione.setIdentificativoIspezione(ConvertUtil.convertToString(ispezione2018Pk.getIdIspezione2018()));

			return ispezione;

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("DbMgr::inserisciIspezioneMassivaDatoDistributore");
		}
	}

	public List<SigitTImpiantoAggiornamentoCoordinateDto> findImpiantiConCoordinateDaAggiornare(ImpiantoAggiornamentoCoordinateFilter filter) throws DbManagerException {
		log.debug("DbMgr::findImpiantiConCoordinateDaAggiornare - START");
		try {
			return getSigitTImpiantoDao().findAggiornamentoCoordinate(filter);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("DbMgr::findImpiantiConCoordinateDaAggiornare - END");
		}
	}

	public List<SigitTImpiantoAggiornamentoCoordinateDto> findImpiantiConCoordinateDaAggiornare(Boolean senzaCoordinateFlg) throws DbManagerException {
		ImpiantoAggiornamentoCoordinateFilter filter = new ImpiantoAggiornamentoCoordinateFilter();
		filter.setSenzaCoordinateFlag(senzaCoordinateFlg);

		return findImpiantiConCoordinateDaAggiornare(filter);
	}

	public List<SigitTImpiantoAggiornamentoCoordinateDto> findImpiantiConCoordinateDaAggiornare(String dataAggiornamento) throws DbManagerException, ParseException {
		ImpiantoAggiornamentoCoordinateFilter filter = new ImpiantoAggiornamentoCoordinateFilter();
		filter.setAggiornatiAData(convertConfigDateToSqlFormat(dataAggiornamento));

		return findImpiantiConCoordinateDaAggiornare(filter);
	}

	public void aggiornaImpianto(SigitTImpiantoDto impiantoDto) throws DbManagerException {
		log.debug("DbMgr::aggiornaImpianto - START");
		try {
			getSigitTImpiantoDao().update(impiantoDto);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} finally {
			log.debug("DbMgr::aggiornaImpianto - END");
		}
	}

	public List<SigitTCompGtDto> findCompGtByFilter(CompFilter compFilter) throws DbManagerException {
		log.debug("DbMgr::findCompGtByFilter - START");
		try {
			return getSigittCompGtDao().findByExample(compFilter);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("DbMgr::findCompGtByFilter - END");
		}
	}

	public List<SigitTConsumoTipo1BDto> findConsumiTipo1ByIdAllegato(BigDecimal idAllegato) throws DbManagerException {
		SigitTConsumoTipo1BDto filter = new SigitTConsumoTipo1BDto();
		filter.setFkAllegato(idAllegato);
		return findConsumiTipo1ByFilter(filter);
	}

	public List<SigitTConsumoTipo1BDto> findConsumiTipo1ByIdAllegatoIdTipoConsumo(BigDecimal idAllegato, int idTipoConsumo) throws DbManagerException {
		SigitTConsumoTipo1BDto filter = new SigitTConsumoTipo1BDto();
		filter.setFkAllegato(idAllegato);
		filter.setIdTipoConsumo1b(ConvertUtil.convertToBigDecimal(idTipoConsumo));
		return findConsumiTipo1ByFilter(filter);
	}


	public List<SigitTConsumoTipo1BDto> findConsumiTipo1ByFilter(SigitTConsumoTipo1BDto filter) throws DbManagerException {
		log.debug("DbMgr::findConsumiTipo1ByFilter - START");
		try {
			return getSigitTConsumoTipo1BDao().findByFilter(filter);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("DbMgr::findConsumiTipo1ByFilter - END");
		}
	}

	public List<SigitDStelleDto> findAllStelle() throws DbManagerException {
		log.debug("DbMgr::findAllStelle - START");
		try {
			return getSigitDStelleDao().findAll();
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("DbMgr::findAllStelle - END");
		}
	}

	public List<SigitDTipo1BDto> findAllTipo1B() throws DbManagerException {
		log.debug("DbMgr::findAllTipo1B - START");
		try {
			return getSigitDTipo1BDao().findAll();
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("DbMgr::findAllTipo1B - END");
		}
	}

	public List<SigitDAriaComburenteDto> findAllAriaComburente() throws DbManagerException {
		log.debug("DbMgr::findAllAriaComburente - START");
		try {
			return getSigitDAriaComburenteDao().findAll();
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("DbMgr::findAllAriaComburente - END");
		}
	}

	public List<SigitDControlloAriaDto> findAllControlloAria() throws DbManagerException {
		log.debug("DbMgr::findAllControlloAria - START");
		try {
			return getSigitDControlloAriaDao().findAll();
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("DbMgr::findAllControlloAria - END");
		}
	}

	public List<SigitDTipoCaricCombuDto> findAllTipoCaricCombu() throws DbManagerException {
		log.debug("DbMgr::findAllTipoCaricCombu - START");
		try {
			return getSigitDTipoCaricCombuDao().findAll();
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("DbMgr::findAllTipoCaricCombu - END");
		}
	}

	private String convertConfigDateToSqlFormat(String date) throws ParseException {
		Date dateObj = DateUtil.getDateFromString(date, "dd/MM/yyyy");

		String dateCorrectFormat = DateUtil.getStringFromDate(dateObj, "yyyy-MM-dd");
		return dateCorrectFormat;
	}

	public ArrayList<ElencoImpiantiGraffati> getElencoImpiantiGraffatiByCodImpianto(String codImpianto) throws DbManagerException {
		try {
			ArrayList<ElencoImpiantiGraffati> elencoImpiantiGraffatiList = null;
			List<SigitTGraffaturaDto> graffatureByCodice = getSigitTGraffaturaDao().findByCodiceImpiantoAttivo(Integer.parseInt(codImpianto));
			if(graffatureByCodice!=null && graffatureByCodice.size()!=0){
				List<SigitTGraffaturaDto> graffaturaDtoList = getSigitTGraffaturaDao().findByIdGraffatura(graffatureByCodice.get(0).getIdGraffatura().intValue());
				elencoImpiantiGraffatiList = mapGraffaturaToElencoGraffature(graffaturaDtoList);
			}
			return elencoImpiantiGraffatiList;
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("DbMgr::findAllTipoCaricCombu - END");
		}
	}

	private ArrayList<ElencoImpiantiGraffati> mapGraffaturaToElencoGraffature(List<SigitTGraffaturaDto> graffaturaDtoList) throws DbManagerException {
		ArrayList<ElencoImpiantiGraffati> elencoImpiantiGraffati = new ArrayList<>();
		for(SigitTGraffaturaDto dto:graffaturaDtoList){
			ElencoImpiantiGraffati model = new ElencoImpiantiGraffati();
			model.setCodiceImpianto(dto.getCodiceImpianto().toString());
			SigitVRicercaImpiantiDto ricercaImpiantiDto = cercaImpiantoByCodImpianto(dto.getCodiceImpianto());
			if(ricercaImpiantiDto!=null) {
				model.setIndirizzo(ReplaceSpecialCharUtils.sanitize(ricercaImpiantiDto.getIndirizzoUnitaImmob()));
				model.setDescComune(ReplaceSpecialCharUtils.sanitize(ricercaImpiantiDto.getDenominazioneComune()));
				model.setDenomResponsabile(ReplaceSpecialCharUtils.sanitize(ricercaImpiantiDto.getDenominazioneResponsabile()));
				model.setDenom3Responsabile(ReplaceSpecialCharUtils.sanitize(ricercaImpiantiDto.getDenominazione3Responsabile()));
			}
			model.setChiaveGraff(dto.getIdGraffatura()+"_"+dto.getCodiceImpianto()+"_"+dto.getDtInserimento());
			elencoImpiantiGraffati.add(model);
		}
		return elencoImpiantiGraffati;
	}

	public void deleteImpiantoGraffatura(String codiceImpianto,UtenteLoggato utenteLoggato) throws SigitTGraffaturaDaoException {
		List<SigitTGraffaturaDto> graffaturaList =
				getSigitTGraffaturaDao().findByCodiceImpiantoAttivo(Integer.parseInt(codiceImpianto));
		if(graffaturaList!=null  && graffaturaList.size()!=0){
			SigitTGraffaturaDto dto = graffaturaList.get(0);
			dto.setDtCancellazione(new Timestamp(new Date().getTime()));
			dto.setUtenteUltMod(utenteLoggato.getCodiceFiscale());
			getSigitTGraffaturaDao().update(dto);
		}
	}

	public void insertNewImpiantoGraffatura(Impianto impiantoApprofondito, Impianto impiantoSelez, UtenteLoggato utente, ExecResults result, String okCode, String koCode) {
		try {
			SigitTGraffaturaDto newGraffatura = new SigitTGraffaturaDto();
			List<SigitTGraffaturaDto> sigitTGraffaturaDtoList = getSigitTGraffaturaDao().findByCodiceImpiantoAttivo(Integer.parseInt(impiantoApprofondito.getImpCodImpianto()));
			List<SigitTGraffaturaDto> impiantoSelezList = getSigitTGraffaturaDao().findByCodiceImpiantoAttivo(Integer.parseInt(impiantoSelez.getImpCodImpianto()));

			if(impiantoSelezList==null || impiantoSelezList.size()==0){
				if (sigitTGraffaturaDtoList != null && sigitTGraffaturaDtoList.size() == 1) {
					newGraffatura.setIdGraffatura(sigitTGraffaturaDtoList.get(0).getIdGraffatura());
				}else{
					SigitTGraffaturaDto graffaturaParent = new SigitTGraffaturaDto();
					graffaturaParent.setCodiceImpianto(new BigDecimal(impiantoApprofondito.getImpCodImpianto()));
					graffaturaParent.setDtInserimento(new Timestamp(new Date().getTime()));
					graffaturaParent.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(utente.getCodiceFiscale()));
					SigitTGraffaturaPk pk = getSigitExtDao().insertGraffaturaAutoIncrement(graffaturaParent);
					newGraffatura.setIdGraffatura(pk.getIdGraffatura());
				}
				newGraffatura.setCodiceImpianto(new BigDecimal(impiantoSelez.getImpCodImpianto()));
				newGraffatura.setDtInserimento(new Timestamp(new Date().getTime()));
				newGraffatura.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(utente.getCodiceFiscale()));
				getSigitTGraffaturaDao().insert(newGraffatura);
				result.setResultCode(okCode);
			}else{
				List<SigitTGraffaturaDto> impiantiGraffati = getSigitTGraffaturaDao().
						findByIdGraffatura(impiantoSelezList.get(0).getIdGraffatura().intValue());
				if(impiantiGraffati!=null && impiantiGraffati.size()<=1){
					if (sigitTGraffaturaDtoList != null && sigitTGraffaturaDtoList.size() == 1) {
						newGraffatura.setIdGraffatura(sigitTGraffaturaDtoList.get(0).getIdGraffatura());
					}else{
						SigitTGraffaturaDto graffaturaParent = new SigitTGraffaturaDto();
						graffaturaParent.setCodiceImpianto(new BigDecimal(impiantoApprofondito.getImpCodImpianto()));
						graffaturaParent.setDtInserimento(new Timestamp(new Date().getTime()));
						graffaturaParent.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(utente.getCodiceFiscale()));
						SigitTGraffaturaPk pk = getSigitExtDao().insertGraffaturaAutoIncrement(graffaturaParent);
						newGraffatura.setIdGraffatura(pk.getIdGraffatura());
					}
					impiantiGraffati.get(0).setDtCancellazione(new Timestamp(new Date().getTime()));
					getSigitTGraffaturaDao().update(impiantiGraffati.get(0));
					newGraffatura.setCodiceImpianto(new BigDecimal(impiantoSelez.getImpCodImpianto()));
					newGraffatura.setDtInserimento(new Timestamp(new Date().getTime()));
					newGraffatura.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(utente.getCodiceFiscale()));
					getSigitTGraffaturaDao().insert(newGraffatura);
					result.setResultCode(okCode);
				}else{
					result.getGlobalErrors().add("Impianto selezionato già graffato con un altro impianto");
					result.setResultCode(koCode);
				}
			}
		} catch (SigitTGraffaturaDaoException | SigitExtDaoException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Storico> getStoricoVariazioniStatoByCodiceImpianto(String impCodImpianto) throws SigitTStoricoVariazStatoDaoException, SigitDStatoImpDaoException {
		List<SigitTStoricoVariazStatoDto> storicoVariazList = getSigitTStoricoVariazStatoDao().findFindByCodiceImpianto(Integer.parseInt(impCodImpianto));
		if(GenericUtil.isNotNullOrEmpty(storicoVariazList))
			return mapListSigitTStoricoToStoricoModel(storicoVariazList);
			else
				return new ArrayList<>();

	}

	private ArrayList<Storico> mapListSigitTStoricoToStoricoModel(List<SigitTStoricoVariazStatoDto> storicoVariazList) throws SigitDStatoImpDaoException {
		ArrayList<Storico> storicoList = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		for(SigitTStoricoVariazStatoDto dto:storicoVariazList){
			Storico storico = new Storico();
			storico.setCodiceImpianto(dto.getCodiceImpianto().toString());
			storico.setDataEvento(dto.getDtEvento()!=null?format.format(dto.getDtEvento()):null);
			storico.setDataVariazione(dto.getDtInizioVariazione()!=null?format.format(dto.getDtInizioVariazione()):null);

			if(dto.getStatoA()!=null) {
				SigitDStatoImpDto statoImpDto = getSigitDStatoImpDao().findByPrimaryKey(new SigitDStatoImpPk(dto.getStatoA()));
				storico.setStatoA(statoImpDto != null ? statoImpDto.getDesStato():"");
			}
			if(dto.getStatoDa()!=null) {
				SigitDStatoImpDto statoImpDto = getSigitDStatoImpDao().findByPrimaryKey(new SigitDStatoImpPk(dto.getStatoDa()));
				storico.setStatoDa(statoImpDto != null ? statoImpDto.getDesStato():"");
			}

			storico.setMotivo(dto.getMotivo());
			storicoList.add(storico);
		}
		return storicoList;
	}
}

