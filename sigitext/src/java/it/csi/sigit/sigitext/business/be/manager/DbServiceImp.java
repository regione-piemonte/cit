/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.be.manager;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.*;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.*;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.*;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.*;
import it.csi.sigit.sigitext.business.pdf.DettaglioIspezione;
import it.csi.sigit.sigitext.business.pdf.*;
import it.csi.sigit.sigitext.business.util.*;
import it.csi.sigit.sigitext.dto.sigitext.*;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.RowAcquaReintegroDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.UM;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.*;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L14ConsumiDocument.L14Consumi;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L14ConsumiDocument.L14Consumi.L141ConsumoCombustibile;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L14ConsumiDocument.L14Consumi.L142ConsumoEnergiaElettrica;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L14ConsumiDocument.L14Consumi.L143ConsumoAcqua;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L14ConsumiDocument.L14Consumi.L144ConsumoProdottiChimici;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L1SchedaIdentificativaDocument.L1SchedaIdentificativa;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L42BruciatoreSostituitoDocument.L42BruciatoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L48AltroGeneratoreSostituitoDocument.L48AltroGeneratoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.*;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L8SistemiAccumuloDocument.L8SistemiAccumulo;
import it.csi.sigit.sigitwebn.xml.libretto.data.*;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * Manager del DB
 *
 * @author 70140
 */
public class DbServiceImp {

	protected static final Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".SigitextManager==>");
	private CombustibileCITDao combustibileCITDao = null;
	private FluidoCITDao fluidoCITDao = null;
	private MarcaCITDao marcaCITDao = null;
	private UnitaMisuraCITDao unitaMisuraCITDao = null;

	private PotenzaImpDao potenzaImpDao = null;
	//private ExtDao extDao = null;
	private AllegatoDao allegatoDao = null;
	private UnitaImmobiliareDao unitaImmobiliareDao = null;
	private UserElencoWsDao userElencoWsDao = null;
	private RicercaAllegatiDao ricercaAllegatiDao = null;
	private WrkConfigDao wrkConfigDao = null;
	private SigitTCompGtDao sigittCompGtDao = null;
	private SigitTComp4Dao sigitTComp4Dao = null;
	private SigitRComp4ManutDao sigitRComp4ManutDao = null;
	private SigitTCompGfDao sigitTCompGfDao = null;
	private SigitTCompScDao sigitTCompScDao = null;
	private SigitTCompCgDao sigitTCompCgDao = null;
	private SigitTCompCsDao sigitTCompCsDao = null;
	private SigitTCompAgDao sigitTCompAgDao = null;
	private SigitWrkLogDao sigitWrkLogDao = null;
	private SigitTCompSrDao sigitTCompSrDao = null;
	private SigitTCompVrDao sigitTCompVrDao = null;
	private SigitTCompPoDao sigitTCompPoDao = null;
	private SigitTCompAcDao sigitTCompAcDao = null;
	private SigitTCompTeDao sigitTCompTeDao = null;
	private SigitTCompRvDao sigitTCompRvDao = null;
	private SigitTCompScxDao sigitTCompScxDao = null;
	private SigitTCompCiDao sigitTCompCiDao = null;
	private SigitTCompUtDao sigitTCompUtDao = null;
	private SigitTCompRcDao sigitTCompRcDao = null;
	private SigitTCompVmDao sigitTCompVmDao = null;
	private SigitTAzioneComp4Dao sigitTAzioneComp4Dao = null;
	private SigitRPfRuoloPaDao sigitRPfRuoloPaDao = null;
	private ConnectorManager connectorManager;
	private SigitDDettaglioGtDao sigitDDettaglioGtDao = null;
	private SigitDTipoCannaFumariaDao sigitDTipoCannaFumariaDao = null;
	private SigitWrkConfigDao sigitWrkConfigDao;
	private SigitDDettaglioGfDao sigitDDettaglioGfDao;

	private SigitDFonteEnSfruttataDao sigitDFonteEnSfruttataDao;

	private SigitVRicercaImpiantiDao sigitVRicercaImpiantiDao;

	public SigitVRicercaImpiantiDao getSigitVRicercaImpiantiDao() {
		return sigitVRicercaImpiantiDao;
	}

	public void setSigitVRicercaImpiantiDao(SigitVRicercaImpiantiDao sigitVRicercaImpiantiDao) {
		this.sigitVRicercaImpiantiDao = sigitVRicercaImpiantiDao;
	}

	public SigitWrkConfigDao getSigitWrkConfigDao() {
		return sigitWrkConfigDao;
	}

	public void setSigitWrkConfigDao(SigitWrkConfigDao sigitWrkConfigDao) {
		this.sigitWrkConfigDao = sigitWrkConfigDao;
	}

	public SigitDTipoCannaFumariaDao getSigitDTipoCannaFumariaDao() {
		return sigitDTipoCannaFumariaDao;
	}

	public void setSigitDTipoCannaFumariaDao(SigitDTipoCannaFumariaDao sigitDTipoCannaFumariaDao) {
		this.sigitDTipoCannaFumariaDao = sigitDTipoCannaFumariaDao;
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

	public ConnectorManager getConnectorManager() {
		return connectorManager;
	}

	public void setConnectorManager(ConnectorManager connectorManager) {
		this.connectorManager = connectorManager;
	}

	public CombustibileCITDao getCombustibileCITDao() {
		return combustibileCITDao;
	}

	public void setCombustibileCITDao(CombustibileCITDao combustibileCITDao) {

		this.combustibileCITDao = combustibileCITDao;
	}

	public FluidoCITDao getFluidoCITDao() {
		return fluidoCITDao;
	}

	public void setFluidoCITDao(FluidoCITDao fluidoCITDao) {
		this.fluidoCITDao = fluidoCITDao;
	}

	SigitDFluidoDao sigitDFluidoDao;

	public SigitDFluidoDao getSigitDFluidoDao() {
		return sigitDFluidoDao;
	}

	public void setSigitDFluidoDao(SigitDFluidoDao sigitDFluidoDao) {
		this.sigitDFluidoDao = sigitDFluidoDao;
	}

	public MarcaCITDao getMarcaCITDao() {
		return marcaCITDao;
	}

	public void setMarcaCITDao(MarcaCITDao marcaCITDao) {
		this.marcaCITDao = marcaCITDao;
	}

	public UnitaMisuraCITDao getUnitaMisuraCITDao() {
		return unitaMisuraCITDao;
	}

	public void setUnitaMisuraCITDao(UnitaMisuraCITDao unitaMisuraCITDao) {
		this.unitaMisuraCITDao = unitaMisuraCITDao;
	}

	public PotenzaImpDao getPotenzaImpDao() {
		return potenzaImpDao;
	}

	public void setPotenzaImpDao(PotenzaImpDao potenzaImpDao) {
		this.potenzaImpDao = potenzaImpDao;
	}

	public AllegatoDao getAllegatoDao() {
		return allegatoDao;
	}

	public void setAllegatoDao(AllegatoDao allegatoDao) {
		this.allegatoDao = allegatoDao;
	}

	public RicercaAllegatiDao getRicercaAllegatiDao() {
		return ricercaAllegatiDao;
	}

	public void setRicercaAllegatiDao(RicercaAllegatiDao ricercaAllegatiDao) {
		this.ricercaAllegatiDao = ricercaAllegatiDao;
	}

	public UnitaImmobiliareDao getUnitaImmobiliareDao() {
		return unitaImmobiliareDao;
	}

	public void setUnitaImmobiliareDao(UnitaImmobiliareDao unitaImmobiliareDao) {
		this.unitaImmobiliareDao = unitaImmobiliareDao;
	}

	public UserElencoWsDao getUserElencoWsDao() {
		return userElencoWsDao;
	}

	public void setUserElencoWsDao(UserElencoWsDao userElencoWsDao) {
		this.userElencoWsDao = userElencoWsDao;
	}

	public WrkConfigDao getWrkConfigDao() {
		return wrkConfigDao;
	}

	public void setWrkConfigDao(WrkConfigDao wrkConfigDao) {
		this.wrkConfigDao = wrkConfigDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_IMPIANTO
	 */
	private SigitTImpiantoDao sigitTImpiantoDao = null;

	public SigitTImpiantoDao getSigitTImpiantoDao() {
		return sigitTImpiantoDao;
	}

	public void setSigitTImpiantoDao(SigitTImpiantoDao sigitTImpiantoDao) {
		this.sigitTImpiantoDao = sigitTImpiantoDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_TRATT_H2O
	 */
	private SigitTTrattH2ODao sigitTTrattH2ODao = null;

	public SigitTTrattH2ODao getSigitTTrattH2ODao() {
		return sigitTTrattH2ODao;
	}

	public void setSigitTTrattH2ODao(SigitTTrattH2ODao sigitTTrattH2ODao) {
		this.sigitTTrattH2ODao = sigitTTrattH2ODao;
	}

	public SigitTCompGtDao getSigitTCompGtDao() {
		return sigittCompGtDao;
	}

	public void setSigitTCompGtDao(SigitTCompGtDao sigittCompGtDao) {
		this.sigittCompGtDao = sigittCompGtDao;
	}

	public SigitTComp4Dao getSigitTComp4Dao() {
		return sigitTComp4Dao;
	}

	public void setSigitTComp4Dao(SigitTComp4Dao sigitTComp4Dao) {
		this.sigitTComp4Dao = sigitTComp4Dao;
	}

	public SigitRComp4ManutDao getSigitRComp4ManutDao() {
		return sigitRComp4ManutDao;
	}

	public void setSigitRComp4ManutDao(SigitRComp4ManutDao sigitRComp4ManutDao) {
		this.sigitRComp4ManutDao = sigitRComp4ManutDao;
	}

	public SigitTCompGfDao getSigitTCompGfDao() {
		return sigitTCompGfDao;
	}

	public void setSigitTCompGfDao(SigitTCompGfDao sigitTCompGfDao) {
		this.sigitTCompGfDao = sigitTCompGfDao;
	}

	public SigitTCompScDao getSigitTCompScDao() {
		return sigitTCompScDao;
	}

	public SigitTCompAcDao getSigitTCompAcDao() {
		return sigitTCompAcDao;
	}

	public void setSigitTCompAcDao(SigitTCompAcDao sigitTCompAcDao) {
		this.sigitTCompAcDao = sigitTCompAcDao;
	}

	public void setSigitTCompScDao(SigitTCompScDao sigitTCompScDao) {
		this.sigitTCompScDao = sigitTCompScDao;
	}

	public SigitTCompCgDao getSigitTCompCgDao() {
		return sigitTCompCgDao;
	}

	public SigitTCompCsDao getSigitTCompCsDao() {
		return sigitTCompCsDao;
	}

	public void setSigitTCompCsDao(SigitTCompCsDao sigitTCompCsDao) {
		this.sigitTCompCsDao = sigitTCompCsDao;
	}

	public void setSigitTCompCgDao(SigitTCompCgDao sigitTCompCgDao) {
		this.sigitTCompCgDao = sigitTCompCgDao;
	}

	public SigitTCompAgDao getSigitTCompAgDao() {
		return sigitTCompAgDao;
	}

	public void setSigitTCompAgDao(SigitTCompAgDao sigitTCompAgDao) {
		this.sigitTCompAgDao = sigitTCompAgDao;
	}

	public SigitWrkLogDao getSigitWrkLogDao() {
		return sigitWrkLogDao;
	}

	public void setSigitWrkLogDao(SigitWrkLogDao sigitWrkLogDao) {
		this.sigitWrkLogDao = sigitWrkLogDao;
	}

	public SigitTCompSrDao getSigitTCompSrDao() {
		return sigitTCompSrDao;
	}

	public SigitTCompCiDao getSigitTCompCiDao() {
		return sigitTCompCiDao;
	}

	public void setSigitTCompCiDao(SigitTCompCiDao sigitTCompCiDao) {
		this.sigitTCompCiDao = sigitTCompCiDao;
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

	public SigitTCompPoDao getSigitTCompPoDao() {
		return sigitTCompPoDao;
	}

	public void setSigitTCompPoDao(SigitTCompPoDao sigitTCompPoDao) {
		this.sigitTCompPoDao = sigitTCompPoDao;
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

	private SigitVPfPgDao sigitVPfPgDao = null;

	public SigitVPfPgDao getSigitVPfPgDao() {
		return sigitVPfPgDao;
	}

	public void setSigitVPfPgDao(SigitVPfPgDao sigitVPfPgDao) {
		this.sigitVPfPgDao = sigitVPfPgDao;
	}

	private SigitTUnitaImmobiliareDao sigitTUnitaImmobiliareDao = null;

	public SigitTUnitaImmobiliareDao getSigitTUnitaImmobiliareDao() {
		return sigitTUnitaImmobiliareDao;
	}

	public void setSigitTUnitaImmobiliareDao(SigitTUnitaImmobiliareDao sigitTUnitaImmobiliareDao) {
		this.sigitTUnitaImmobiliareDao = sigitTUnitaImmobiliareDao;
	}

	/**
	 * DAO per accedere alla tabella VISTA_TOT_IMPIANTO
	 */
	private SigitVTotImpiantoDao sigitVTotImpiantoDao = null;

	public SigitVTotImpiantoDao getSigitVTotImpiantoDao() {
		return sigitVTotImpiantoDao;
	}

	public void setSigitVTotImpiantoDao(SigitVTotImpiantoDao sigitVTotImpiantoDao) {
		this.sigitVTotImpiantoDao = sigitVTotImpiantoDao;
	}

	/**
	 * DAO per accedere alla tabella VISTA_RICERCA_ALLEGATI
	 */
	private SigitVRicercaAllegatiDao sigitVRicercaAllegatiDao = null;

	public SigitVRicercaAllegatiDao getSigitVRicercaAllegatiDao() {
		return sigitVRicercaAllegatiDao;
	}

	public void setSigitVRicercaAllegatiDao(SigitVRicercaAllegatiDao sigitVRicercaAllegatiDao) {
		this.sigitVRicercaAllegatiDao = sigitVRicercaAllegatiDao;
	}

	/**
	 * DAO per accedere alla tabella VISTA_RICERCA_ISPEZIONI
	 */
	private SigitVRicercaIspezioniDao sigitVRicercaIspezioniDao = null;

	public SigitVRicercaIspezioniDao getSigitVRicercaIspezioniDao() {
		return sigitVRicercaIspezioniDao;
	}

	public void setSigitVRicercaIspezioniDao(SigitVRicercaIspezioniDao sigitVRicercaIspezioniDao) {
		this.sigitVRicercaIspezioniDao = sigitVRicercaIspezioniDao;
	}

	public SigitDFonteEnSfruttataDao getSigitDFonteEnSfruttataDao() {
		return sigitDFonteEnSfruttataDao;
	}

	public void setSigitDFonteEnSfruttataDao(SigitDFonteEnSfruttataDao sigitDFonteEnSfruttataDao) {
		this.sigitDFonteEnSfruttataDao = sigitDFonteEnSfruttataDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_EXT_DAO
	 */
	private SigitExtDao sigitExtDao = null;

	public SigitExtDao getSigitExtDao() {
		return sigitExtDao;
	}

	public void setSigitExtDao(SigitExtDao sigitExtDao) {
		this.sigitExtDao = sigitExtDao;
	}

	private SigitTCompBrRcDao sigitTCompBrRcDao;

	public SigitTCompBrRcDao getSigitTCompBrRcDao() {
		return sigitTCompBrRcDao;
	}

	public void setSigitTCompBrRcDao(SigitTCompBrRcDao sigitTCompBrRcDao) {
		this.sigitTCompBrRcDao = sigitTCompBrRcDao;
	}

	private SigitVCompCsDao sigitVCompCsDao;

	public SigitVCompCsDao getSigitVCompCsDao() {
		return sigitVCompCsDao;
	}

	public void setSigitVCompCsDao(SigitVCompCsDao sigitVCompCsDao) {
		this.sigitVCompCsDao = sigitVCompCsDao;
	}

	private SigitVCompAgDao sigitVCompAgDao;

	public SigitVCompAgDao getSigitVCompAgDao() {
		return sigitVCompAgDao;
	}

	public void setSigitVCompAgDao(SigitVCompAgDao sigitVCompAgDao) {
		this.sigitVCompAgDao = sigitVCompAgDao;
	}

	private SigitTCompXSempliceDao sigitTCompXSempliceDao;

	public SigitTCompXSempliceDao getSigitTCompXSempliceDao() {
		return sigitTCompXSempliceDao;
	}

	public void setSigitTCompXSempliceDao(SigitTCompXSempliceDao sigitTCompXSempliceDao) {
		this.sigitTCompXSempliceDao = sigitTCompXSempliceDao;
	}

	private SigitVCompSrDao sigitVCompSrDao;

	public SigitVCompSrDao getSigitVCompSrDao() {
		return sigitVCompSrDao;
	}

	public void setSigitVCompSrDao(SigitVCompSrDao sigitVCompSrDao) {
		this.sigitVCompSrDao = sigitVCompSrDao;
	}

	private SigitVCompVrDao sigitVCompVrDao;

	public SigitVCompVrDao getSigitVCompVrDao() {
		return sigitVCompVrDao;
	}

	public void setSigitVCompVrDao(SigitVCompVrDao sigitVCompVrDao) {
		this.sigitVCompVrDao = sigitVCompVrDao;
	}

	private SigitTCompVxDao sigitTCompVxDao;

	public SigitTCompVxDao getSigitTCompVxDao() {
		return sigitTCompVxDao;
	}

	public void setSigitTCompVxDao(SigitTCompVxDao sigitTCompVxDao) {
		this.sigitTCompVxDao = sigitTCompVxDao;
	}

	private SigitVCompPoDao sigitVCompPoDao;

	public SigitVCompPoDao getSigitVCompPoDao() {
		return sigitVCompPoDao;
	}

	public void setSigitVCompPoDao(SigitVCompPoDao sigitVCompPoDao) {
		this.sigitVCompPoDao = sigitVCompPoDao;
	}

	private SigitVCompAcDao sigitVCompAcDao;

	public SigitVCompAcDao getSigitVCompAcDao() {
		return sigitVCompAcDao;
	}

	public void setSigitVCompAcDao(SigitVCompAcDao sigitVCompAcDao) {
		this.sigitVCompAcDao = sigitVCompAcDao;
	}

	private SigitVCompTeDao sigitVCompTeDao;

	public SigitVCompTeDao getSigitVCompTeDao() {
		return sigitVCompTeDao;
	}

	public void setSigitVCompTeDao(SigitVCompTeDao sigitVCompTeDao) {
		this.sigitVCompTeDao = sigitVCompTeDao;
	}

	private SigitVCompRvDao sigitVCompRvDao;

	public SigitVCompRvDao getSigitVCompRvDao() {
		return sigitVCompRvDao;
	}

	public void setSigitVCompRvDao(SigitVCompRvDao sigitVCompRvDao) {
		this.sigitVCompRvDao = sigitVCompRvDao;
	}

	private SigitTCompXDao sigitTCompXDao;

	public SigitTCompXDao getSigitTCompXDao() {
		return sigitTCompXDao;
	}

	public void setSigitTCompXDao(SigitTCompXDao sigitTCompXDao) {
		this.sigitTCompXDao = sigitTCompXDao;
	}

	private SigitVCompCiDao sigitVCompCiDao;

	public SigitVCompCiDao getSigitVCompCiDao() {
		return sigitVCompCiDao;
	}

	public void setSigitVCompCiDao(SigitVCompCiDao sigitVCompCiDao) {
		this.sigitVCompCiDao = sigitVCompCiDao;
	}

	private SigitVCompUtDao sigitVCompUtDao;

	public SigitVCompUtDao getSigitVCompUtDao() {
		return sigitVCompUtDao;
	}

	public void setSigitVCompUtDao(SigitVCompUtDao sigitVCompUtDao) {
		this.sigitVCompUtDao = sigitVCompUtDao;
	}

	private SigitVCompRcDao sigitVCompRcDao;

	public SigitVCompRcDao getSigitVCompRcDao() {
		return sigitVCompRcDao;
	}

	public void setSigitVCompRcDao(SigitVCompRcDao sigitVCompRcDao) {
		this.sigitVCompRcDao = sigitVCompRcDao;
	}

	private SigitVCompVmDao sigitVCompVmDao;

	public SigitVCompVmDao getSigitVCompVmDao() {
		return sigitVCompVmDao;
	}

	public void setSigitVCompVmDao(SigitVCompVmDao sigitVCompVmDao) {
		this.sigitVCompVmDao = sigitVCompVmDao;
	}

	private SigitVSk4GtDao sigitVSk4GtDao;

	public SigitVSk4GtDao getSigitVSk4GtDao() {
		return sigitVSk4GtDao;
	}

	public void setSigitVSk4GtDao(SigitVSk4GtDao sigitVSk4GtDao) {
		this.sigitVSk4GtDao = sigitVSk4GtDao;
	}

	private SigitVSk4GfDao sigitVSk4GfDao;

	public void setSigitVSk4GfDao(SigitVSk4GfDao sigitVSk4GfDao) {
		this.sigitVSk4GfDao = sigitVSk4GfDao;
	}

	public SigitVSk4GfDao getSigitVSk4GfDao() {
		return sigitVSk4GfDao;
	}

	private SigitVSk4CgDao sigitVSk4CgDao;

	public void setSigitVSk4CgDao(SigitVSk4CgDao sigitVSk4CgDao) {
		this.sigitVSk4CgDao = sigitVSk4CgDao;
	}

	public SigitVSk4CgDao getSigitVSk4CgDao() {
		return sigitVSk4CgDao;
	}

	private SigitVSk4ScDao sigitVSk4ScDao;

	public void setSigitVSk4ScDao(SigitVSk4ScDao sigitVSk4ScDao) {
		this.sigitVSk4ScDao = sigitVSk4ScDao;
	}

	public SigitVSk4ScDao getSigitVSk4ScDao() {
		return sigitVSk4ScDao;
	}

	private SigitVCompGtDettDao sigitVCompGtDettDao;

	public SigitVCompGtDettDao getSigitVCompGtDettDao() {
		return sigitVCompGtDettDao;
	}

	public void setSigitVCompGtDettDao(SigitVCompGtDettDao sigitVCompGtDettDao) {
		this.sigitVCompGtDettDao = sigitVCompGtDettDao;
	}

	private SigitVCompGfDettDao sigitVCompGfDettDao;

	public SigitVCompGfDettDao getSigitVCompGfDettDao() {
		return sigitVCompGfDettDao;
	}

	public void setSigitVCompGfDettDao(SigitVCompGfDettDao sigitVCompGfDettDao) {
		this.sigitVCompGfDettDao = sigitVCompGfDettDao;
	}

	private SigitVCompScDettDao sigitVCompScDettDao;

	public SigitVCompScDettDao getSigitVCompScDettDao() {
		return sigitVCompScDettDao;
	}

	public void setSigitVCompScDettDao(SigitVCompScDettDao sigitVCompScDettDao) {
		this.sigitVCompScDettDao = sigitVCompScDettDao;
	}

	private SigitVCompCgDettDao sigitVCompCgDettDao;

	public SigitVCompCgDettDao getSigitVCompCgDettDao() {
		return sigitVCompCgDettDao;
	}

	public void setSigitVCompCgDettDao(SigitVCompCgDettDao sigitVCompCgDettDao) {
		this.sigitVCompCgDettDao = sigitVCompCgDettDao;
	}

	private SigitTConsumoDao sigitTConsumoDao;

	public SigitTConsumoDao getSigitTConsumoDao() {
		return sigitTConsumoDao;
	}

	public void setSigitTConsumoDao(SigitTConsumoDao sigitTConsumoDao) {
		this.sigitTConsumoDao = sigitTConsumoDao;
	}

	private SigitTConsumo14_4Dao sigitTConsumo144Dao;

	public SigitTConsumo14_4Dao getSigitTConsumo144Dao() {
		return sigitTConsumo144Dao;
	}

	public void setSigitTConsumo144Dao(SigitTConsumo14_4Dao sigitTConsumo144Dao) {
		this.sigitTConsumo144Dao = sigitTConsumo144Dao;
	}

	private SigitTControlloLibrettoDao sigitTControlloLibrettoDao;

	public SigitTControlloLibrettoDao getSigitTControlloLibrettoDao() {
		return sigitTControlloLibrettoDao;
	}

	public void setSigitTControlloLibrettoDao(SigitTControlloLibrettoDao sigitTControlloLibrettoDao) {
		this.sigitTControlloLibrettoDao = sigitTControlloLibrettoDao;
	}

	private SigitRImpRuoloPfpgDao sigitRImpRuoloPfpgDao;

	public SigitRImpRuoloPfpgDao getSigitRImpRuoloPfpgDao() {
		return sigitRImpRuoloPfpgDao;
	}

	public void setSigitRImpRuoloPfpgDao(SigitRImpRuoloPfpgDao sigitRImpRuoloPfpgDao) {
		this.sigitRImpRuoloPfpgDao = sigitRImpRuoloPfpgDao;
	}

	private SigitTLibrettoDao sigitTLibrettoDao;

	public SigitTLibrettoDao getSigitTLibrettoDao() {
		return sigitTLibrettoDao;
	}

	public void setSigitTLibrettoDao(SigitTLibrettoDao sigitTLibrettoDao) {
		this.sigitTLibrettoDao = sigitTLibrettoDao;
	}

	private SigitTLibTxtDao sigitTLibTxtDao;

	public SigitTLibTxtDao getSigitTLibTxtDao() {
		return sigitTLibTxtDao;
	}

	public void setSigitTLibTxtDao(SigitTLibTxtDao sigitTLibTxtDao) {
		this.sigitTLibTxtDao = sigitTLibTxtDao;
	}

	private SigitDStelleDao sigitDStelleDao;

	public void setSigitDStelleDao(SigitDStelleDao sigitDStelleDao) {
		this.sigitDStelleDao = sigitDStelleDao;
	}

	public SigitDStelleDao getSigitDStelleDao() {
		return sigitDStelleDao;
	}

	private SigitDTipo1BDao sigitDTipo1BDao;

	public SigitDTipo1BDao getSigitDTipo1BDao() {
		return sigitDTipo1BDao;
	}

	public void setSigitDTipo1BDao(SigitDTipo1BDao sigitDTipo1BDao) {
		this.sigitDTipo1BDao = sigitDTipo1BDao;
	}

	private SigitDControlloAriaDao sigitDControlloAriaDao;

	public SigitDControlloAriaDao getSigitDControlloAriaDao() {
		return sigitDControlloAriaDao;
	}

	public void setSigitDControlloAriaDao(SigitDControlloAriaDao sigitDControlloAriaDao) {
		this.sigitDControlloAriaDao = sigitDControlloAriaDao;
	}

	private SigitDAriaComburenteDao sigitDAriaComburenteDao;

	public SigitDAriaComburenteDao getSigitDAriaComburenteDao() {
		return sigitDAriaComburenteDao;
	}

	public void setSigitDAriaComburenteDao(SigitDAriaComburenteDao sigitDAriaComburenteDao) {
		this.sigitDAriaComburenteDao = sigitDAriaComburenteDao;
	}

	private SigitTImportXmlLibDao sigitTImportXmlLibDao;

	public SigitTImportXmlLibDao getSigitTImportXmlLibDao() {
		return sigitTImportXmlLibDao;
	}

	public void setSigitTImportXmlLibDao(SigitTImportXmlLibDao sigitTImportXmlLibDao) {
		this.sigitTImportXmlLibDao = sigitTImportXmlLibDao;
	}

	private SigitTPreImportDao sigitTPreImportDao;

	public SigitTPreImportDao getSigitTPreImportDao() {
		return sigitTPreImportDao;
	}

	public void setSigitTPreImportDao(SigitTPreImportDao sigitTPreImportDao) {
		this.sigitTPreImportDao = sigitTPreImportDao;
	}

	private SigitTPersonaGiuridicaDao sigitTPersonaGiuridicaDao;

	public SigitTPersonaGiuridicaDao getSigitTPersonaGiuridicaDao() {
		return sigitTPersonaGiuridicaDao;
	}

	public void setSigitTPersonaGiuridicaDao(SigitTPersonaGiuridicaDao sigitTPersonaGiuridicaDao) {
		this.sigitTPersonaGiuridicaDao = sigitTPersonaGiuridicaDao;
	}

	private SigitTPersonaFisicaDao sigitTPersonaFisicaDao;

	public SigitTPersonaFisicaDao getSigitTPersonaFisicaDao() {
		return sigitTPersonaFisicaDao;
	}

	public void setSigitTPersonaFisicaDao(SigitTPersonaFisicaDao sigitTPersonaFisicaDao) {
		this.sigitTPersonaFisicaDao = sigitTPersonaFisicaDao;
	}

	private SigitTImportDao sigitTImportDao;

	public SigitTImportDao getSigitTImportDao() {
		return sigitTImportDao;
	}

	public void setSigitTImportDao(SigitTImportDao sigitTImportDao) {
		this.sigitTImportDao = sigitTImportDao;
	}

	private SigitTImpXmlDao sigitTImpXmlDao;

	public SigitTImpXmlDao getSigitTImpXmlDao() {
		return sigitTImpXmlDao;
	}

	public void setSigitTImpXmlDao(SigitTImpXmlDao sigitTImpXmlDao) {
		this.sigitTImpXmlDao = sigitTImpXmlDao;
	}

	private SigitTAllegatoDao sigitTAllegato;

	public SigitTAllegatoDao getSigitTAllegatoDao() {
		return sigitTAllegato;
	}

	public void setSigitTAllegatoDao(SigitTAllegatoDao sigitTAllegato) {
		this.sigitTAllegato = sigitTAllegato;
	}

	private SigitRComp4ManutAllDao sigitRComp4ManutAll;

	public SigitRComp4ManutAllDao getSigitRComp4ManutAllDao() {
		return sigitRComp4ManutAll;
	}

	public void setSigitRComp4ManutAllDao(SigitRComp4ManutAllDao sigitRComp4ManutAll) {
		this.sigitRComp4ManutAll = sigitRComp4ManutAll;
	}

	private SigitRAllegatoCompGtDao sigitRAllegatoCompGt;

	public SigitRAllegatoCompGtDao getSigitRAllegatoCompGtDao() {
		return sigitRAllegatoCompGt;
	}

	public void setSigitRAllegatoCompGtDao(SigitRAllegatoCompGtDao sigitRAllegatoCompGt) {
		this.sigitRAllegatoCompGt = sigitRAllegatoCompGt;
	}

	private SigitRAllegatoCompGfDao sigitRAllegatoCompGf;

	public SigitRAllegatoCompGfDao getSigitRAllegatoCompGfDao() {
		return sigitRAllegatoCompGf;
	}

	public void setSigitRAllegatoCompGfDao(SigitRAllegatoCompGfDao sigitRAllegatoCompGf) {
		this.sigitRAllegatoCompGf = sigitRAllegatoCompGf;
	}

	private SigitRAllegatoCompScDao sigitRAllegatoCompSc;

	public SigitRAllegatoCompScDao getSigitRAllegatoCompScDao() {
		return sigitRAllegatoCompSc;
	}

	public void setSigitRAllegatoCompScDao(SigitRAllegatoCompScDao sigitRAllegatoCompSc) {
		this.sigitRAllegatoCompSc = sigitRAllegatoCompSc;
	}

	private SigitRAllegatoCompCgDao sigitRAllegatoCompCg;

	public SigitRAllegatoCompCgDao getSigitRAllegatoCompCgDao() {
		return sigitRAllegatoCompCg;
	}

	public void setSigitRAllegatoCompCgDao(SigitRAllegatoCompCgDao sigitRAllegatoCompCg) {
		this.sigitRAllegatoCompCg = sigitRAllegatoCompCg;
	}

	private SigitTDettTipo1Dao sigitTDettTipo1;

	public SigitTDettTipo1Dao getSigitTDettTipo1Dao() {
		return sigitTDettTipo1;
	}

	public void setSigitTDettTipo1Dao(SigitTDettTipo1Dao sigitTDettTipo1) {
		this.sigitTDettTipo1 = sigitTDettTipo1;
	}

	private SigitTDettTipo2Dao sigitTDettTipo2;

	public SigitTDettTipo2Dao getSigitTDettTipo2Dao() {
		return sigitTDettTipo2;
	}

	public void setSigitTDettTipo2Dao(SigitTDettTipo2Dao sigitTDettTipo2) {
		this.sigitTDettTipo2 = sigitTDettTipo2;
	}

	private SigitTDettTipo3Dao sigitTDettTipo3;

	public SigitTDettTipo3Dao getSigitTDettTipo3Dao() {
		return sigitTDettTipo3;
	}

	public void setSigitTDettTipo3Dao(SigitTDettTipo3Dao sigitTDettTipo3) {
		this.sigitTDettTipo3 = sigitTDettTipo3;
	}

	private SigitTDettTipo4Dao sigitTDettTipo4;

	public SigitTDettTipo4Dao getSigitTDettTipo4Dao() {
		return sigitTDettTipo4;
	}

	public void setSigitTDettTipo4Dao(SigitTDettTipo4Dao sigitTDettTipo4) {
		this.sigitTDettTipo4 = sigitTDettTipo4;
	}

	private SigitTCodiceBollDao sigitTCodiceBoll;

	public SigitTCodiceBollDao getSigitTCodiceBollDao() {
		return sigitTCodiceBoll;
	}

	public void setSigitTCodiceBollDao(SigitTCodiceBollDao sigitTCodiceBoll) {
		this.sigitTCodiceBoll = sigitTCodiceBoll;
	}

	private SigitTRappTipo1Dao sigitTRappTipo1Dao;

	public SigitTRappTipo1Dao getSigitTRappTipo1Dao() {
		return sigitTRappTipo1Dao;
	}

	public void setSigitTRappTipo1Dao(SigitTRappTipo1Dao sigitTRappTipo1Dao) {
		this.sigitTRappTipo1Dao = sigitTRappTipo1Dao;
	}

	private SigitTRappTipo2Dao sigitTRappTipo2Dao;

	public SigitTRappTipo2Dao getSigitTRappTipo2Dao() {
		return sigitTRappTipo2Dao;
	}

	public void setSigitTRappTipo2Dao(SigitTRappTipo2Dao sigitTRappTipo2Dao) {
		this.sigitTRappTipo2Dao = sigitTRappTipo2Dao;
	}

	private SigitTRappTipo3Dao sigitTRappTipo3Dao;

	public SigitTRappTipo3Dao getSigitTRappTipo3Dao() {
		return sigitTRappTipo3Dao;
	}

	public void setSigitTRappTipo3Dao(SigitTRappTipo3Dao sigitTRappTipo3Dao) {
		this.sigitTRappTipo3Dao = sigitTRappTipo3Dao;
	}

	private SigitTRappTipo4Dao sigitTRappTipo4Dao;

	public SigitTRappTipo4Dao getSigitTRappTipo4Dao() {
		return sigitTRappTipo4Dao;
	}

	public void setSigitTRappTipo4Dao(SigitTRappTipo4Dao sigitTRappTipo4Dao) {
		this.sigitTRappTipo4Dao = sigitTRappTipo4Dao;
	}

	private SigitSLibrettoDao sigitSLibrettoDao;

	public SigitSLibrettoDao getSigitSLibrettoDao() {
		return sigitSLibrettoDao;
	}

	public void setSigitSLibrettoDao(SigitSLibrettoDao sigitSLibrettoDao) {
		this.sigitSLibrettoDao = sigitSLibrettoDao;
	}

	private SigitTUserWSDao sigitTUserWSDao;

	public SigitTUserWSDao getSigitTUserWSDao() {
		return sigitTUserWSDao;
	}

	public void setSigitTUserWSDao(SigitTUserWSDao sigitTUserWSDao) {
		this.sigitTUserWSDao = sigitTUserWSDao;
	}

	private SigitLAccessoDao sigitLAccessoDao;

	public SigitLAccessoDao getSigitLAccessoDao() {
		return sigitLAccessoDao;
	}

	public void setSigitLAccessoDao(SigitLAccessoDao sigitLAccessoDao) {
		this.sigitLAccessoDao = sigitLAccessoDao;
	}

	private SigitTElencoWsDao sigitTElencoWsDao;

	public SigitTElencoWsDao getSigitTElencoWsDao() {
		return sigitTElencoWsDao;
	}

	public void setSigitTElencoWsDao(SigitTElencoWsDao sigitTElencoWsDao) {
		this.sigitTElencoWsDao = sigitTElencoWsDao;
	}

	private SigitTConsumoTipo1BDao sigitTConsumoTipo1BDao;

	public SigitTConsumoTipo1BDao getSigitTConsumoTipo1BDao() {
		return sigitTConsumoTipo1BDao;
	}

	public SigitRPfRuoloPaDao getSigitRPfRuoloPaDao() {
		return sigitRPfRuoloPaDao;
	}

	public void setSigitRPfRuoloPaDao(SigitRPfRuoloPaDao sigitRPfRuoloPaDao) {
		this.sigitRPfRuoloPaDao = sigitRPfRuoloPaDao;
	}

	private SigitRPfPgDelegaDao sigitRPfPgDelegaDao;

	public SigitRPfPgDelegaDao getSigitRPfPgDelegaDao() {
		return sigitRPfPgDelegaDao;
	}

	private SigitRPgPgNominaDao sigitRPgPgNominaDao;

	public SigitRPgPgNominaDao getSigitRPgPgNominaDao() {
		return sigitRPgPgNominaDao;
	}

	public void setSigitRPgPgNominaDao(SigitRPgPgNominaDao sigitRPgPgNominaDao) {
		this.sigitRPgPgNominaDao = sigitRPgPgNominaDao;
	}

	public void setSigitRPfPgDelegaDao(SigitRPfPgDelegaDao sigitRPfPgDelegaDao) {
		this.sigitRPfPgDelegaDao = sigitRPfPgDelegaDao;
	}

	public void setSigitTConsumoTipo1BDao(SigitTConsumoTipo1BDao sigitTConsumoTipo1BDao) {
		this.sigitTConsumoTipo1BDao = sigitTConsumoTipo1BDao;
	}

	private SigitDStatoImpiantoDao sigitDStatoImpiantoDao;

	public SigitDStatoImpiantoDao getSigitDStatoImpiantoDao() {
		return sigitDStatoImpiantoDao;
	}

	private SigitTStoricoVariazStatoDao sigitTStoricoVariazStatoDao = null;

	public SigitTStoricoVariazStatoDao getSigitTStoricoVariazStatoDao() {
		return sigitTStoricoVariazStatoDao;
	}

	public SigitTDocAllegatoDao sigitTDocAllegatoDao;

	public SigitTDocAllegatoDao getSigitTDocAllegatoDao() {
		return sigitTDocAllegatoDao;
	}

	public void setSigitTDocAllegatoDao(SigitTDocAllegatoDao sigitTDocAllegatoDao) {
		this.sigitTDocAllegatoDao = sigitTDocAllegatoDao;
	}

	private SigitTRappControlloDao sigitTRappControlloDao = null;

	public SigitTRappControlloDao getSigitTRappControlloDao() {
		return sigitTRappControlloDao;
	}

	public void setSigitTRappControlloDao(SigitTRappControlloDao sigitTRappControlloDao) {
		this.sigitTRappControlloDao = sigitTRappControlloDao;
	}

	public void setSigitTStoricoVariazStatoDao(SigitTStoricoVariazStatoDao sigitTStoricoVariazStatoDao) {
		this.sigitTStoricoVariazStatoDao = sigitTStoricoVariazStatoDao;
	}

	public void setSigitDStatoImpiantoDao(SigitDStatoImpiantoDao sigitDStatoImpiantoDao) {
		this.sigitDStatoImpiantoDao = sigitDStatoImpiantoDao;
	}

	public SigitTAzioneComp4Dao getSigitTAzioneComp4Dao() {
		return sigitTAzioneComp4Dao;
	}

	public void setSigitTAzioneComp4Dao(SigitTAzioneComp4Dao sigitTAzioneComp4Dao) {
		this.sigitTAzioneComp4Dao = sigitTAzioneComp4Dao;
	}

	private SigitTAllTxtDao sigitTAllTxtDao = null;

	public SigitTAllTxtDao getSigitTAllTxtDao() {
		return sigitTAllTxtDao;
	}

	public void setSigitTAllTxtDao(SigitTAllTxtDao sigitTAllTxtDao) {
		this.sigitTAllTxtDao = sigitTAllTxtDao;
	}

	private SigitTRappDettaglioDao sigitTRappDettaglioDao = null;

	public SigitTRappDettaglioDao getSigitTRappDettaglioDao() {
		return sigitTRappDettaglioDao;
	}

	private SigitTImportDistribDao sigitTImportDistribDao;

	public SigitTImportDistribDao getSigitTImportDistribDao() {
		return sigitTImportDistribDao;
	}

	public void setSigitTImportDistribDao(SigitTImportDistribDao sigitTImportDistribDao) {
		this.sigitTImportDistribDao = sigitTImportDistribDao;
	}

	public void setSigitTRappDettaglioDao(SigitTRappDettaglioDao sigitTRappDettaglioDao) {
		this.sigitTRappDettaglioDao = sigitTRappDettaglioDao;
	}

	private SigitDUnitaMisuraDao sigitDUnitaMisuraDao;

	public SigitDUnitaMisuraDao getSigitDUnitaMisuraDao() {
		return sigitDUnitaMisuraDao;
	}

	public void setSigitDUnitaMisuraDao(SigitDUnitaMisuraDao sigitDUnitaMisuraDao) {
		this.sigitDUnitaMisuraDao = sigitDUnitaMisuraDao;
	}

	private SigitTAbilitazioneDao sigitTAbilitazioneDao;

	public SigitTAbilitazioneDao getSigitTAbilitazioneDao() {
		return sigitTAbilitazioneDao;
	}

	public void setSigitTAbilitazioneDao(SigitTAbilitazioneDao sigitTAbilitazioneDao) {
		this.sigitTAbilitazioneDao = sigitTAbilitazioneDao;
	}

	private SigitTDocAggiuntivaDao sigitTDocAggiuntivaDao;

	public SigitTDocAggiuntivaDao getSigitTDocAggiuntivaDao() {
		return sigitTDocAggiuntivaDao;
	}

	public void setSigitTDocAggiuntivaDao(SigitTDocAggiuntivaDao sigitTDocAggiuntivaDao) {
		this.sigitTDocAggiuntivaDao = sigitTDocAggiuntivaDao;
	}

	private SigitVAllegatiComponentiDao sigitVAllegatiComponentiDao = null;

	public SigitVAllegatiComponentiDao getSigitVAllegatiComponentiDao() {
		return sigitVAllegatiComponentiDao;
	}

	public void setSigitVAllegatiComponentiDao(SigitVAllegatiComponentiDao sigitVAllegatiComponentiDao) {
		this.sigitVAllegatiComponentiDao = sigitVAllegatiComponentiDao;
	}

	private SigitTContratto2019Dao sigitTContratto2019Dao = null;

	public SigitTContratto2019Dao getSigitTContratto2019Dao() {
		return sigitTContratto2019Dao;
	}

	public void setSigitTContratto2019Dao(SigitTContratto2019Dao sigitTContratto2019Dao) {
		this.sigitTContratto2019Dao = sigitTContratto2019Dao;
	}

	//private void compilaScheda1Libretto(Richiesta richiesta, SigitTLibrettoDto libretto, SigitTImpiantoDto impianto) throws SigitextException
	private void compilaScheda1Libretto(RichiestaDocument.Richiesta richiesta, SigitTImpiantoDto impianto) throws SigitextException {
		log.debug("[DbServiceImp:::compilaScheda1Libretto] - START");
		List<SigitTUnitaImmobiliareDto> unitaImmobList = getUnitaImmobiliariImpianto(impianto.getCodiceImpianto().intValue());

		List<SigitTUnitaImmobiliareDto> unitaImmobSecondarie = new ArrayList<SigitTUnitaImmobiliareDto>();
		SigitTUnitaImmobiliareDto unitaImmobPrincipale = new SigitTUnitaImmobiliareDto();

		for (SigitTUnitaImmobiliareDto ui : unitaImmobList) {
			if (ConvertUtil.convertToBooleanAllways(ui.getFlgPrincipale()))
				unitaImmobPrincipale = ui;
			else
				unitaImmobSecondarie.add(ui);
		}
		log.debug("unita immob secondarie: " + unitaImmobSecondarie.size());

		richiesta.setDatiSchedaIdentificativaImp(DatiSchedaIdentificativaImpDocument.DatiSchedaIdentificativaImp.Factory.newInstance());
		DatiSchedaIdentificativaImpDocument.DatiSchedaIdentificativaImp datiImpianto = richiesta.getDatiSchedaIdentificativaImp();
		MapDto.mapToSchedaIdentificativaImpianto(datiImpianto, impianto, unitaImmobPrincipale);
		MapDto.mapToDatiPrecompilati(richiesta.getDatiPrecompilati(), unitaImmobPrincipale, impianto, unitaImmobSecondarie);

		log.debug("[DbServiceImp:::compilaScheda1Libretto] - END");
	}

	/**
	 * Popola il modulo con i dati del responsabile impianto, e il terzo responsabile
	 *
	 * @param codImpiantoInt
	 * @param richiesta
	 * @param compGtImpiantoDett
	 * @param compGfImpiantoDett
	 * @param compScImpiantoDett
	 * @param compCgImpiantoDett
	 * @throws ServiceException
	 * @throws SigitVRicercaAllegatiDaoException
	 */
	public void compilaDatiResponsabiliEControlliLibretto(Integer codImpiantoInt, RichiestaDocument.Richiesta richiesta, List<SigitVCompGtDettDto> compGtImpiantoDett, List<SigitVCompGfDettDto> compGfImpiantoDett, List<SigitVCompScDettDto> compScImpiantoDett, List<SigitVCompCgDettDto> compCgImpiantoDett)
			throws SigitextException, SigitVRicercaAllegatiDaoException, SigitVRicercaIspezioniDaoException {
		log.debug("[DbServiceImp::compilaDatiResponsabiliLibretto] START");
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
			List<SigitVTotImpiantoDto> propAttivi = getSigitVTotImpiantoDao().findProprietariAttiviByCodiceImpianto(codImpiantoInt);
			SigitTPersonaGiuridicaDto personaGiutidicaDto = null;
			SigitTPersonaFisicaDto personaFisicaDto = null;
			if (respAttivi != null && !respAttivi.isEmpty()) {
				if ("PG".equals(respAttivi.get(0).getPfPg())) {
					personaGiutidicaDto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(respAttivi.get(0).getIdPersonaFisica()));
					MapDto.mapResponsabileImpianto(richiesta.getDatiPrecompilati(), respAttivi.get(0), personaGiutidicaDto, personaFisicaDto);
				} else {
					personaFisicaDto = getSigitTPersonaFisicaDao().findByPrimaryKey(new SigitTPersonaFisicaPk(respAttivi.get(0).getIdPersonaFisica()));
					MapDto.mapResponsabileImpianto(richiesta.getDatiPrecompilati(), respAttivi.get(0), personaGiutidicaDto, personaFisicaDto);

				}
			}
			if (propAttivi != null && !propAttivi.isEmpty()) {
				if ("PG".equals(propAttivi.get(0).getPfPg())) {
					personaGiutidicaDto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(propAttivi.get(0).getIdPersonaFisica()));
					MapDto.mapProprietarioImpianto(richiesta.getDatiPrecompilati(), propAttivi.get(0), personaGiutidicaDto, personaFisicaDto);
				} else {
					personaFisicaDto = getSigitTPersonaFisicaDao().findByPrimaryKey(new SigitTPersonaFisicaPk(propAttivi.get(0).getIdPersonaFisica()));
					MapDto.mapProprietarioImpianto(richiesta.getDatiPrecompilati(), propAttivi.get(0), personaGiutidicaDto, personaFisicaDto);
				}
			}

			//TERZO RESPONSABILE
			log.debug("Ricerca contratti impianto");
			ContrattoFilter filterContratti = new ContrattoFilter();
			filterContratti.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpiantoInt));
			List<SigitExtContrattoImpDto> contratti = getSigitExtDao().findStoriaContrattiImpiantoNew(filterContratti);
			richiesta.getDatiPrecompilati().setSezNomine(DatiPrecompilatiDocument.DatiPrecompilati.SezNomine.Factory.newInstance());
			MapDto.mapToSezNomine(contratti, richiesta.getDatiPrecompilati().getSezNomine());
		} catch (SigitVTotImpiantoDaoException | SigitTPersonaGiuridicaDaoException | SigitTPersonaFisicaDaoException e) {
			log.error("Errore (responsabili) compilaDatiResponsabiliLibretto", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} catch (SigitExtDaoException e) {
			log.error("Errore (contratti) compilaDatiResponsabiliLibretto", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::compilaDatiResponsabiliLibretto] END");
		}

		//11.1 - Dati risultati GT
		//MapDto.mapToDatiRisultatiGT(richiesta.getDatiRisultatiGT(), compGtImpiantoDett);
		MapDto.mapToDatiRisultatiGT(richiesta.addNewDatiRisultatiGT().addNewSezGruppiTermici(), compGtImpiantoDett);

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
		List<SigitVRicercaIspezioniConsByCodiceImpiantoDto> listIspezioniDb = getSigitVRicercaIspezioniDao().findConsByCodiceImpianto(codImpiantoInt);

		//List<SigitVRicercaIspezioniDto> listIspezioni = getSigitVRicercaIspezioniDao().findByIspezioneFilter(new IspezioneFilter(codImpiantoInt, Constants.ID_STATO_ISPEZIONE_CONSOLIDATO));

		IspezioneFilter filter = new IspezioneFilter();
		filter.setCodiceImpianto(codImpiantoInt);
		filter.setIdStatoIspezione(Constants.ID_STATO_ISPEZIONE_CONSOLIDATO);

		String elencoIspezioni = null;

		for (SigitVRicercaIspezioniConsByCodiceImpiantoDto sigitVRicercaIspezioniConsByCodiceImpiantoDto : listIspezioniDb) {

			if (elencoIspezioni == null) {
				elencoIspezioni = ConvertUtil.convertToString(sigitVRicercaIspezioniConsByCodiceImpiantoDto.getIdIspezione2018());
			} else {
				elencoIspezioni += ", " + sigitVRicercaIspezioniConsByCodiceImpiantoDto.getIdIspezione2018();
			}
		}

		filter.setElencoIdIspezione2018(elencoIspezioni);

		List<SigitVRicercaIspezioniDto> listIspezioniDettDb = getSigitVRicercaIspezioniDao().findConsDettRappProvaByFilter(filter);
		DatiRisultatiIspezDocument.DatiRisultatiIspez.SezRisultati sezInterventi = richiesta.addNewDatiRisultatiIspez().addNewSezRisultati();

		String elencoIdAllegati = null;
		SigitVRicercaIspezioniDto ispezIspet = null;
		List<SigitVRicercaIspezioniDto> ispezIspetList = null;

		for (SigitVRicercaIspezioniConsByCodiceImpiantoDto ispezioneDb : listIspezioniDb) {

			// Ripulisco l'elenco degli allegati
			elencoIdAllegati = null;
			ispezIspet = null;

			ispezIspetList = getSigitVRicercaIspezioniDao().findByIdIspezIspet(ConvertUtil.convertToInteger(ispezioneDb.getMax_id_ispez_ispet()));

			if (ispezIspetList != null && ispezIspetList.size() > 0) {
				// Sicuramente ce ne solo 1
				ispezIspet = ispezIspetList.get(0);
			}

			//			ispezione = new Ispezione2018();
			//			// MAX (ID_ISPEZ_ISPET) as ID_ISPEZ_ISPET, ID_ISPEZIONE_2018, DT_CREAZIONE, ENTE_COMPETENTE, NOTE, FLG_ESITO
			//			ispezione.setIdentificativoIspezione(ConvertUtil.convertToString(ispezioneDb.getIdIspezione2018()));
			//			ispezione.setDataCreazione(ConvertUtil.convertToString(ispezioneDb.getDtCreazione()));
			//			ispezione.setEnteCompetente(ispezioneDb.getEnteCompetente());
			//			ispezione.setNote(ispezioneDb.getNote());
			//
			//			Boolean esitoBoolean = ConvertUtil.convertToBoolean(ispezioneDb.getFlgEsito());
			//			ispezione.setEsito(esitoBoolean == null ? "" : esitoBoolean ? PositivoNegativoEnum.POSITIVO.getDescrizione() : PositivoNegativoEnum.NEGATIVO.getDescrizione());

			for (SigitVRicercaIspezioniDto sigitVRicercaIspezioniDto : listIspezioniDettDb) {

				if (ispezioneDb.getIdIspezione2018().intValue() == sigitVRicercaIspezioniDto.getIdIspezione2018().intValue()) {
					//					String etichettaCorrente = ConvertUtil.getStringByConcat(": ",
					//							ConvertUtil.convertToString(sigitVRicercaIspezioniDto.getDataControllo()),
					//							sigitVRicercaIspezioniDto.getElencoApparecchiature());
					//					ispezione.getRapportiDesc().add(etichettaCorrente);
					//					ispezione.getRapportiId().add(ConvertUtil.convertToLong(sigitVRicercaIspezioniDto.getIdAllegato()));

					if (elencoIdAllegati != null) {
						elencoIdAllegati += ", " + sigitVRicercaIspezioniDto.getIdAllegato();
					} else {
						elencoIdAllegati = ConvertUtil.convertToString(sigitVRicercaIspezioniDto.getIdAllegato());
					}
				}
			}

			sezInterventi.getRowRisultatiIspezList().add(MapDto.mapToIspezioneControllo(ispezioneDb, ispezIspet, elencoIdAllegati));

			//listaRisultati.add(ispezione);
		}

		//MapDto.mapToDatiIspezioni(richiesta.addNewDatiRisultatiIspez().addNewSezRisultati(), listIspezioni);

		//15 - interventi di manutenzione
		List<SigitVRicercaAllegatiDto> listManutenzioni = getSigitVRicercaAllegatiDao().findManutByCodImpianto(codImpiantoInt);
		MapDto.mapToDatiManutenzioni(richiesta.addNewDatiInterventiManutenzione().addNewSezInterventi(), listManutenzioni);

	}

	private void compilaScheda14Libretto(Integer codImpianto, RichiestaDocument.Richiesta richiesta) throws NumberFormatException, SigitTConsumo14_4DaoException, SigitTConsumoDaoException {
		log.debug("[DbServiceImp:::compilaScheda14Libretto] - START");
		richiesta.setDatiConsumoCombu(DatiConsumoCombuDocument.DatiConsumoCombu.Factory.newInstance());
		richiesta.setDatiConsumoEE(DatiConsumoEEDocument.DatiConsumoEE.Factory.newInstance());
		richiesta.setDatiConsumoH2O(DatiConsumoH2ODocument.DatiConsumoH2O.Factory.newInstance());
		richiesta.setDatiConsumoProdottiChimici(DatiConsumoProdottiChimiciDocument.DatiConsumoProdottiChimici.Factory.newInstance());

		//14.1 - Combustibile
		SigitTConsumoDto inputCons = new SigitTConsumoDto();
		inputCons.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
		inputCons.setFkTipoConsumo(Constants.TIPO_CONSUMO_CB);
		List<SigitTConsumoDto> cbList = getSigitTConsumoDao().findByCodImpiantoAndTipo(inputCons);
		//la lista cbList, dovrebbe essere ordinata per tipo_combustibile, bisogna fare la rottura per ogni tipo
		if (cbList != null && !cbList.isEmpty())
			MapDto.mapToSchedaCombustibile(richiesta.getDatiConsumoCombu().addNewSezCombu(), cbList);

		//14.2 - Energia elettrica
		inputCons.setFkTipoConsumo(Constants.TIPO_CONSUMO_EE);
		List<SigitTConsumoDto> eeList = getSigitTConsumoDao().findByCodImpiantoAndTipo(inputCons);
		if (eeList != null && !eeList.isEmpty())
			MapDto.mapToSchedaEnergiaElettrica(richiesta.getDatiConsumoEE().addNewSezConsumo(), eeList);

		//14.3 - Acqua
		inputCons.setFkTipoConsumo(Constants.TIPO_CONSUMO_H2O);
		List<SigitTConsumoDto> h2oList = getSigitTConsumoDao().findByCodImpiantoAndTipo(inputCons);
		if (h2oList != null && !h2oList.isEmpty())
			MapDto.mapToSchedaAcquaImpianto(richiesta.getDatiConsumoH2O(), h2oList);

		//14.4 - Prodotti chimici
		List<SigitTConsumo14_4Dto> pcList = getSigitTConsumo144Dao().findByCodImpianto(codImpianto);
		if (pcList != null && !pcList.isEmpty())
			MapDto.mapToSchedaProdottiChimici(richiesta.getDatiConsumoProdottiChimici().addNewSezConsumo(), pcList);

		log.debug("[DbServiceImp:::compilaScheda14Libretto] - END");
	}

	public SigitTControlloLibrettoDto getControlloLibretto(Integer codiceImpianto) throws SigitextException {
		log.debug("[DbServiceImp::getControlloLibretto] BEGIN");
		try {
			return getSigitTControlloLibrettoDao().findByPrimaryKey(new SigitTControlloLibrettoPk(ConvertUtil.convertToBigDecimal(codiceImpianto)));
		} catch (SigitTControlloLibrettoDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::getControlloLibretto] END");
		}
	}

	public List<SigitTUnitaImmobiliareDto> getUnitaImmobiliariImpianto(Integer codImpianto) throws SigitextException {
		log.debug("[DbServiceImp::getUnitaImmobiliariImpianto] BEGIN");
		try {
			return getSigitTUnitaImmobiliareDao().findByCodiceImpianto(codImpianto);
		} catch (SigitTUnitaImmobiliareDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::getUnitaImmobiliariImpianto] END");
		}
	}

	public List<SigitRImpRuoloPfpgDto> getResponsabiliImpiantoAttivi(Integer codiceImpianto) throws SigitRImpRuoloPfpgDaoException {
		return getSigitRImpRuoloPfpgDao().findRespImpAttivoByCodImpianto(codiceImpianto);
	}

	public List<SigitVCompGtDettDto> getCompGtDett(Integer codImpianto) throws SigitVCompGtDettDaoException {
		return getSigitVCompGtDettDao().findByCodImpiantoOrdered(codImpianto);
	}

	public List<SigitVSk4GtDto> getCompSk4Gt(Integer codImpianto) throws SigitVSk4GtDaoException {
		return getSigitVSk4GtDao().findByCodImpiantoOrdered(codImpianto);
	}

	public List<SigitVCompGfDettDto> getCompGfDett(Integer codImpianto) throws SigitVCompGfDettDaoException {
		return getSigitVCompGfDettDao().findByCodImpiantoOrdered(codImpianto);
	}

	public List<SigitVSk4GfDto> getCompSk4Gf(Integer codImpianto) throws SigitVSk4GfDaoException {
		return getSigitVSk4GfDao().findByCodImpiantoOrdered(codImpianto);
	}

	public List<SigitVCompScDettDto> getCompScDett(Integer codImpianto) throws SigitVCompScDettDaoException {
		return getSigitVCompScDettDao().findByCodImpiantoOrdered(codImpianto);
	}

	public List<SigitVSk4ScDto> getCompSk4Sc(Integer codImpianto) throws SigitVSk4ScDaoException {
		return getSigitVSk4ScDao().findByCodImpiantoOrdered(codImpianto);
	}

	public List<SigitVCompCgDettDto> getCompCgDett(Integer codImpianto) throws SigitVCompCgDettDaoException {
		return getSigitVCompCgDettDao().findByCodImpiantoOrdered(codImpianto);
	}

	public List<SigitVSk4CgDto> getCompSk4Cg(Integer codImpianto) throws SigitVSk4CgDaoException {
		return getSigitVSk4CgDao().findByCodImpiantoOrdered(codImpianto);
	}

	public MarcaCITDto getMarcaCITByPrimaryKey(BigDecimal marcaCITPk) throws MarcaCITDaoException {

		if (marcaCITPk == null) {
			return null;
		}

		return getMarcaCITDao().findByPrimaryKey(new MarcaCITPk(marcaCITPk));
	}

	public CombustibileCITDto getCombustibileCITByPrimaryKey(BigDecimal combustibileCITPk) throws CombustibileCITDaoException {

		if (combustibileCITPk == null) {
			return null;
		}

		return getCombustibileCITDao().findByPrimaryKey(new CombustibileCITPk(combustibileCITPk));
	}

	public UnitaMisuraCITDto getUnitaMisuraCITByPrimaryKey(String unitaMisuraCITPk) throws UnitaMisuraCITDaoException {

		if (unitaMisuraCITPk == null) {
			return null;
		}

		return getUnitaMisuraCITDao().findByPrimaryKey(new UnitaMisuraCITPk(unitaMisuraCITPk));
	}

	public FluidoCITDto getFluidoCITByPrimaryKey(BigDecimal fluidoCITPk) throws SigitextException {

		if (fluidoCITPk == null) {
			return null;
		}

		try {
			return getFluidoCITDao().findByPrimaryKey(new FluidoCITPk(fluidoCITPk));
		} catch (FluidoCITDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		}

	}

	public List<SigitTLibrettoDto> cercaLibrettoByStato(Integer codImpianto, Integer idStato) throws SigitextException {
		log.debug("[DbServiceImp::cercaLibretto] BEGIN");
		try {

			return getSigitTLibrettoDao().findByLibrettoFilter(new LibrettoFilter(codImpianto, idStato));

		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::cercaLibretto] END");
		}
	}

	public SigitTLibTxtDto getTxtLibretto(BigDecimal idLibretto) throws SigitextException {
		log.debug("[DbServiceImp::getTxtLibretto] START");
		SigitTLibTxtPk pk = new SigitTLibTxtPk();
		pk.setIdLibretto(idLibretto);
		try {
			return getSigitTLibTxtDao().findByPrimaryKey(pk);
		} catch (SigitTLibTxtDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::getTxtLibretto] END");
		}
	}

	public SigitTImpiantoDto getImpiantoByCod(BigDecimal codImpianto) throws SigitextException {
		log.debug("[DbServiceImp::getImpiantoByCod] START");
		SigitTImpiantoPk pk = new SigitTImpiantoPk();
		pk.setCodiceImpianto(codImpianto);
		try {
			return getSigitTImpiantoDao().findByPrimaryKey(pk);
		} catch (SigitTImpiantoDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::getImpiantoByCod] END");
		}
	}

	public List<SigitTLibrettoDto> getLibrettoByCodImpianto(Integer codImpianto) throws SigitextException {
		log.debug("[DbServiceImp::getLibrettoByCodImpianto] BEGIN");
		try {

			return getSigitTLibrettoDao().findByCodImpianto(codImpianto);

		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::getLibrettoByCodImpianto] END");
		}
	}

	public SigitTImportXmlLibDto getImportXmlLibrettoByCodImpianto(BigDecimal codImpianto) throws SigitextException {
		log.debug("[DbServiceImp::getImportXmlLibrettoByCodImpianto] BEGIN");

		SigitTImportXmlLibPk pk = new SigitTImportXmlLibPk();
		pk.setCodiceImpianto(codImpianto);

		try {

			return getSigitTImportXmlLibDao().findByPrimaryKey(pk);

		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::getImportXmlLibrettoByCodImpianto] END");
		}
	}

	public void insertImportLibretto(BigDecimal codImpianto, byte[] xml, String codiceUtente) throws SigitextException {
		log.debug("[DbServiceImp:::insertImportLibretto] START");
		try {

			SigitTImportXmlLibDto dto = new SigitTImportXmlLibDto();

			dto.setCodiceImpianto(codImpianto);
			dto.setXmlLibretto(XmlBeanUtils.readByteArray(xml));
			dto.setDataUltMod(GenericUtil.getSqlCurrentDate());
			dto.setUtenteUltMod(codiceUtente);

			SigitTImportXmlLibDto dtoOld = getSigitTImportXmlLibDao().findByPrimaryKey(new SigitTImportXmlLibPk(codImpianto));
			if (dtoOld == null) {
				getSigitTImportXmlLibDao().insert(dto);
			} else {
				getSigitTImportXmlLibDao().update(dto);
			}
		} catch (IOException e) {
			log.error("Errore: ", e);
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} catch (Exception e) {
			log.error("Errore: ", e);
			throw new SigitextException(Messages.ERROR_INSERT_DB);
		} finally {
			log.debug("[DbServiceImp:::insertImportLibretto] END");
		}
	}

	@Transactional
	public void generaLibrettoImportNew(LibrettoDocument librettoDoc, String codImpianto, Integer idPersonaGiuridica, String cfUtente) throws SigitextException {
		log.debug("[DbServiceImp::generaLibrettoImportNew] BEGIN");
		try {

			cancellaListaComponentiAll(ConvertUtil.convertToInteger(codImpianto));
			consolidaLibrettoImport(librettoDoc, ConvertUtil.convertToBigDecimal(codImpianto), idPersonaGiuridica, cfUtente);

		} catch (Exception e) {
			log.error("Errore generaLibrettoImportNew", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new SigitextException(Messages.ERROR_RECUPERO_SERVIZIO, e);
		} finally {
			log.debug("[DbServiceImp::generaLibrettoImportNew] END");
		}
	}

	public void cancellaListaComponentiAll(Integer codiceImpianto) throws SigitextException {
		log.debug("[DbServiceImp::cancellaListaComponentiAll] END");
		try {

			getSigitTConsumoDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTConsumo144Dao().customDeleterByCodImpianto(codiceImpianto);

			getSigitTTrattH2ODao().customDeleterByCodImpianto(codiceImpianto);
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
			getSigitTCompGtDao().customDeleterByCodImpianto(codiceImpianto);

			getSigitRComp4ManutDao().customDeleterByCodImpianto(codiceImpianto);
			getSigitTComp4Dao().customDeleterByCodImpianto(codiceImpianto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::cancellaListaComponentiAll] END");
		}
	}

	public void consolidaLibrettoImport(LibrettoDocument librettoImport, BigDecimal codiceImpianto, Integer idPersonaGiuridica, String cfUtente) throws SigitextException {
		log.debug("[DbServiceImp::consolidaLibrettoImport] start");

		try {
			LibrettoCatastoDocument.LibrettoCatasto librettoCat = librettoImport.getLibretto().getLibrettoCatasto();

			SigitTImpiantoDto datiImpianto = consolidaScheda1LibrettoImp(codiceImpianto, librettoCat.getL1SchedaIdentificativa(), cfUtente);

			L2TrattamentoAcquaDocument.L2TrattamentoAcqua l2TrattamentoAcqua = librettoCat.getL2TrattamentoAcqua();

			if (l2TrattamentoAcqua != null) {
				consolidaTrattamentoH2oImp(codiceImpianto, l2TrattamentoAcqua);
			}

			L4Generatori l4Generatori = librettoCat.getL4Generatori();

			if (l4Generatori != null) {
				consolidaGTImp(codiceImpianto, l4Generatori.getL41GTList(), idPersonaGiuridica, cfUtente);
				consolidaBRImp(codiceImpianto, l4Generatori.getL42BRList(), l4Generatori.getL41GTList(), cfUtente);
				consolidaRCImp(codiceImpianto, l4Generatori.getL43RCList(), l4Generatori.getL41GTList(), cfUtente);
				consolidaGFImp(codiceImpianto, l4Generatori.getL44GFList(), idPersonaGiuridica, cfUtente);
				consolidaSCImp(codiceImpianto, l4Generatori.getL45SCList(), idPersonaGiuridica, cfUtente);
				consolidaCGImp(codiceImpianto, l4Generatori.getL46CGList(), idPersonaGiuridica, cfUtente);
				consolidaCSImp(codiceImpianto, l4Generatori.getL47CSList(), cfUtente);
				consolidaAGImp(codiceImpianto, l4Generatori.getL48AGList(), cfUtente);
			}

			L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione l5SistRegCont = librettoCat.getL5SistemiRegolazioneContabilizzazione();

			consolidaSistemiRegolazioneContabilizzazione(librettoCat, datiImpianto.getCodiceImpianto(), cfUtente);

			L8SistemiAccumulo l8SistAcc = librettoCat.getL8SistemiAccumulo();

			if (l8SistAcc != null && l8SistAcc.getL81ACList() != null && l8SistAcc.getL81ACList().size() > 0) {
				consolidaACImp(l8SistAcc.getL81ACList(), datiImpianto.getCodiceImpianto(), cfUtente);

			}

			L9AltriComponentiDocument.L9AltriComponenti l9AltriComponenti = librettoCat.getL9AltriComponenti();

			if (l9AltriComponenti != null) {
				consolidaTEImp(l9AltriComponenti.getL91TEList(), datiImpianto.getCodiceImpianto(), cfUtente);
				consolidaRVImp(l9AltriComponenti.getL92RVList(), datiImpianto.getCodiceImpianto(), cfUtente);
				consolidaSCXImp(l9AltriComponenti.getL93SCXList(), datiImpianto.getCodiceImpianto(), cfUtente);
				consolidaCIImp(l9AltriComponenti.getL94CIList(), datiImpianto.getCodiceImpianto(), cfUtente);
				consolidaUTImp(l9AltriComponenti.getL95UTList(), datiImpianto.getCodiceImpianto(), cfUtente);
				consolidaRCImp(l9AltriComponenti.getL96RCXList(), datiImpianto.getCodiceImpianto(), cfUtente);

			}

			L10VentilazioneDocument.L10Ventilazione l10Ventilazione = librettoCat.getL10Ventilazione();
			if (l10Ventilazione != null) {
				consolidaVMImp(l10Ventilazione.getL101VMList(), datiImpianto.getCodiceImpianto(), cfUtente);
			}

			L14Consumi l14Consumi = librettoCat.getL14Consumi();

			if (l14Consumi != null) {
				consolidaConsumoCombustibileImp(l14Consumi.getL141ConsumoCombustibileList(), datiImpianto.getCodiceImpianto(), cfUtente);
				consolidaConsumoEnergiaImp(l14Consumi.getL142ConsumoEnergiaElettrica(), datiImpianto.getCodiceImpianto(), cfUtente);
				consolidaConsumoH2OImp(l14Consumi.getL143ConsumoAcqua(), datiImpianto.getCodiceImpianto(), cfUtente);
				consolidaConsumoProdottiChimici(l14Consumi.getL144ConsumoProdottiChimici(), datiImpianto.getCodiceImpianto(), cfUtente);
			}
		} catch (SigitextException e1) {
			throw e1;
		} catch (Exception e1) {
			throw new SigitextException(Messages.ERROR_UPDATE_DB, e1);
		}

		log.debug("[DbServiceImp::consolidaLibrettoImport] end");
	}

	public SigitTImpiantoDto consolidaScheda1LibrettoImp(BigDecimal codImpianto, L1SchedaIdentificativa l1SchedaIdentificativa, String cfUtente) throws SigitextException {
		log.debug("[DbServiceImp::consolidaScheda1LibrettoImp] start");

		try {
			SigitTImpiantoDto datiImpianto = getSigitTImpiantoDao().findByPrimaryKey(new SigitTImpiantoPk(codImpianto));

			datiImpianto = MapDtoImport.mapToSigitTImpiantoImp(l1SchedaIdentificativa, datiImpianto, cfUtente);

			getSigitTImpiantoDao().update(datiImpianto);

			List<SigitTUnitaImmobiliareDto> unitaPrincipaleList = getSigitTUnitaImmobiliareDao().findUnitaPrincipaleImpianto(ConvertUtil.convertToInteger(codImpianto));
			SigitTUnitaImmobiliareDto uiPrincipale = new SigitTUnitaImmobiliareDto();
			if (unitaPrincipaleList != null && !unitaPrincipaleList.isEmpty()) {
				uiPrincipale = unitaPrincipaleList.get(0);
			}

			uiPrincipale = MapDtoImport.mapTosigitTUnitaImmobiliareImp(l1SchedaIdentificativa, uiPrincipale, cfUtente);

			getSigitTUnitaImmobiliareDao().update(uiPrincipale);

			return datiImpianto;

		} catch (SigitTImpiantoDaoException e) {
			throw new SigitextException(Messages.ERROR_UPDATE_DB, e);
		} catch (SigitTUnitaImmobiliareDaoException e) {
			throw new SigitextException(Messages.ERROR_UPDATE_DB, e);
		} finally {
			log.debug("[DbServiceImp::consolidaScheda1LibrettoImp] end");
		}
	}

	public void consolidaTrattamentoH2oImp(BigDecimal codImpianto, L2TrattamentoAcquaDocument.L2TrattamentoAcqua datiH) throws SigitextException {
		log.debug("[DbServiceImp::consolidaTrattamentoH2oImp] start");

		try {
			SigitTTrattH2ODto dto = MapDtoImport.getSigitTTrattH2oNew(codImpianto, datiH);
			getSigitTTrattH2ODao().insert(dto);

		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_UPDATE_DB, e);
		} finally {
			log.debug("[DbServiceImp::consolidaTrattamentoH2oImp] end");
		}
	}

	public void consolidaGTImp(BigDecimal codImpianto, List<L41GT> listGt, Integer idPersonaGiuridica, String cfUtente) throws SigitextException {
		log.debug("[DbServiceImp::consolidaGTImp] start");

		try {

			String GT = "GT";
			for (L41GT rowGT : listGt) {
				SigitTComp4Dto comp4 = MapDtoImport.getSigitTComp4New(codImpianto, rowGT);
				BigDecimal progressivo = comp4.getProgressivo();
				SigitTCompGtDto compGt = MapDtoImport.mapToRowGTNew(codImpianto, rowGT.getL41GruppoTermico(), progressivo, cfUtente);
				if (GenericUtil.isNullOrEmpty(compGt.getDataInstall()))
					continue;

				log.debug("progressivo: " + progressivo);

				SigitTCompGtPk pkCompGt = new SigitTCompGtPk();
				pkCompGt.setCodiceImpianto(codImpianto);
				pkCompGt.setDataInstall(compGt.getDataInstall());
				pkCompGt.setIdTipoComponente(GT);
				pkCompGt.setProgressivo(progressivo);

				SigitTComp4Pk pkComp4 = new SigitTComp4Pk();
				pkComp4.setCodiceImpianto(pkCompGt.getCodiceImpianto());
				pkComp4.setIdTipoComponente(pkCompGt.getIdTipoComponente());
				pkComp4.setProgressivo(pkCompGt.getProgressivo());

				getSigitTComp4Dao().insert(comp4);

				log.debug("inserisco GT");
				getSigitTCompGtDao().insert(compGt);

				SigitRComp4ManutDto comp4ManutFilter = new SigitRComp4ManutDto();
				comp4ManutFilter.setCodiceImpianto(pkCompGt.getCodiceImpianto());
				comp4ManutFilter.setIdTipoComponente(pkCompGt.getIdTipoComponente());
				comp4ManutFilter.setProgressivo(pkCompGt.getProgressivo());

				List<SigitRComp4ManutDto> comp4ManutList = getSigitRComp4ManutDao().findAttiviByFilter(comp4ManutFilter);

				log.debug("STAMPO comp4ManutList: " + comp4ManutList);

				if (comp4ManutList == null || comp4ManutList.size() == 0) {
					SigitRComp4ManutDto comp4Manut = MapDtoImport.getSigitRComp4ManutNew(codImpianto, rowGT.getL41GruppoTermico(), idPersonaGiuridica, Constants.ID_RUOLO_MANUTENTORE_ALL_1, progressivo, cfUtente);
					getSigitRComp4ManutDao().insert(comp4Manut);
				}

				List<String> dateInstallazione = new ArrayList<String>();
				dateInstallazione.add(ConvertUtil.convertToString(compGt.getDataInstall()));
				List<L41GruppoTermicoSostituitoDocument.L41GruppoTermicoSostituito> gtSostituiteList = rowGT.getL41GruppoTermicoSostituitoList();
				log.debug("consolodamento GT sotituite");
				if (gtSostituiteList != null)
					for (L41GruppoTermicoSostituitoDocument.L41GruppoTermicoSostituito rowGTSost : gtSostituiteList) {

						SigitTCompGtDto compGtSost = MapDtoImport.mapToRowGTSostNew(codImpianto, rowGTSost, progressivo, cfUtente);

						log.debug("inserisco gt sost");
						getSigitTCompGtDao().insert(compGtSost);
					}
			}
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_UPDATE_DB, e);
		}

		log.debug("[DbServiceImp::consolidaGTImp] end");

	}

	public void consolidaBRImp(BigDecimal codImpianto, List<L42BR> listBr, List<L41GT> listGt, String cfUtente) throws SigitextException {
		log.debug("[DbServiceImp::consolidaBRImp] start");
		try {
			String BR = "BR";
			List<String> progressivi = new ArrayList<String>();
			for (L42BR rowBR : listBr) {
				String progressivoGt = null;
				try {
					progressivoGt = ConvertUtil.convertToString(rowBR.getL42GtCollegato());
				} catch (Exception e) {
					continue;
				}

				log.debug("progressivoGt: " + progressivoGt);

				L41GT gt = getGtFromList(listGt, progressivoGt);
				if (gt == null) {
					log.error("Non trovato il GT " + progressivoGt + " per il BR");
					throw new SigitextException("Si e' verificato un errore ");
				}
				SigitTCompBrRcDto compBr = MapDtoImport.getSigitTCompBrRcNew(rowBR.getL42Bruciatore(), rowBR.getL42Numero(), codImpianto, gt);
				if (GenericUtil.isNullOrEmpty(compBr.getDataInstall()))
					continue;
				BigDecimal progressivoBr = compBr.getProgressivoBrRc();
				progressivi.add(progressivoBr.toString());
				log.debug("progressivo BR: " + progressivoBr + ", data inst: " + ConvertUtil.convertToString(compBr.getDataInstall()));

				log.debug("inserisco nuovo BR");
				getSigitTCompBrRcDao().insert(compBr);

				List<L42BruciatoreSostituito> brSostituiteList = rowBR.getL42BruciatoreSostituitoList();
				log.debug("consolidamento BR sostituite");
				if (brSostituiteList != null)
					for (L42BruciatoreSostituito rowBRSost : brSostituiteList) {
						SigitTCompBrRcDto compBrSost = MapDtoImport.getSigitTCompBrRcSostNew(rowBRSost, progressivoBr, codImpianto, gt);
						log.debug("data install: " + ConvertUtil.convertToString(compBrSost.getDataInstall()));

						log.debug("inserisco br sost");
						getSigitTCompBrRcDao().insert(compBrSost);
					}
				log.debug("Controllo sezioni BR sost eliminate");
			}

		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_UPDATE_DB, e);
		}

		log.debug("[DbServiceImp::consolidaBRImp] end");

	}

	private L41GT getGtFromList(List<L41GT> gt, String progressivo) {
		log.debug("getGtFromList");

		log.debug("progressivo: " + progressivo);

		for (L41GT rowGT : gt) {
			log.debug("rowGT.getL41Numero(): " + rowGT.getL41Numero());

			if (progressivo.equals(ConvertUtil.convertToString(rowGT.getL41Numero())))
				return rowGT;
		}
		return null;
	}

	public void consolidaRCImp(BigDecimal codImpianto, List<L43RC> listRc, List<L41GT> listGt, String cfUtente) throws SigitextException {
		log.debug("[DbServiceImp::consolidaRCImp] start");
		try {
			String RC = "RC";
			List<String> progressivi = new ArrayList<String>();
			for (L43RC rowRc : listRc) {
				String progressivoGt = null;
				try {
					progressivoGt = ConvertUtil.convertToString(rowRc.getL43GtCollegato());
				} catch (Exception e) {
					continue;
				}
				L41GT gt = getGtFromList(listGt, progressivoGt);
				if (gt == null) {
					log.error("Non trovato il GT " + progressivoGt + " per RC");
					throw new SigitextException("Si e' verificato un errore ");
				}
				SigitTCompBrRcDto compRc = MapDtoImport.getSigitTCompBrRcNew(rowRc.getL43Recuperatore(), rowRc.getL43Numero(), codImpianto, gt);
				if (GenericUtil.isNullOrEmpty(compRc.getDataInstall()))
					continue;
				BigDecimal progressivoBr = compRc.getProgressivoBrRc();
				progressivi.add(progressivoBr.toString());
				log.debug("progressivo RC: " + progressivoBr + ", data inst: " + ConvertUtil.convertToString(compRc.getDataInstall()));

				log.debug("inserisco nuovo RC");
				getSigitTCompBrRcDao().insert(compRc);

				List<L43RecuperatoreSostituitoDocument.L43RecuperatoreSostituito> rcSostituiteList = rowRc.getL43RecuperatoreSostituitoList();
				log.debug("consolidamento RC sotituite");
				if (rcSostituiteList != null)
					for (L43RecuperatoreSostituitoDocument.L43RecuperatoreSostituito rowRCSost : rcSostituiteList) {
						SigitTCompBrRcDto compBrSost = MapDtoImport.getSigitTCompBrRcSostNew(rowRCSost, progressivoBr, codImpianto, gt);
						log.debug("data install: " + ConvertUtil.convertToString(compBrSost.getDataInstall()));

						log.debug("inserisco RC sost");
						getSigitTCompBrRcDao().insert(compBrSost);
					}
			}

		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_UPDATE_DB, e);
		}

		log.debug("[DbServiceImp::consolidaRCImp] end");

	}

	public void consolidaGFImp(BigDecimal codImpianto, List<L44GF> listGf, Integer idPersonaGiuridica, String cfUtente) throws SigitextException {
		log.debug("[DbServiceImp::consolidaGFImp] start");
		List<String> progressivi = new ArrayList<String>();
		try {

			String GF = "GF";
			for (L44GF rowGF : listGf) {

				SigitTComp4Dto comp4 = MapDtoImport.getSigitTComp4New(codImpianto, rowGF);
				BigDecimal progressivo = comp4.getProgressivo();
				SigitTCompGfDto compGf = MapDtoImport.mapToRowGFNew(codImpianto, rowGF.getL44GruppoFrigo(), progressivo, cfUtente);
				if (GenericUtil.isNullOrEmpty(compGf.getDataInstall()))
					continue;

				getSigitTComp4Dao().insert(comp4);

				log.debug("inserisco GF");
				getSigitTCompGfDao().insert(compGf);

				SigitRComp4ManutDto comp4Manut = MapDtoImport.getSigitRComp4ManutNew(codImpianto, rowGF.getL44GruppoFrigo(), idPersonaGiuridica, Constants.ID_RUOLO_MANUTENTORE_ALL_2, progressivo, cfUtente);
				getSigitRComp4ManutDao().insert(comp4Manut);

				List<L44GruppoFrigoSostituitoDocument.L44GruppoFrigoSostituito> gfSostituiteList = rowGF.getL44GruppoFrigoSostituitoList();
				log.debug("consolodamento GF sotituite");
				if (gfSostituiteList != null)
					for (L44GruppoFrigoSostituitoDocument.L44GruppoFrigoSostituito rowGFSost : gfSostituiteList) {

						SigitTCompGfDto compGfSost = MapDtoImport.mapToRowGFSostNew(codImpianto, rowGFSost, progressivo, cfUtente);
						log.debug("inserisco GF sost");

						getSigitTCompGfDao().insert(compGfSost);
					}
				log.debug("Controllo sezioni GF sost eliminate");
			}
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_UPDATE_DB, e);
		}

		log.debug("[DbServiceImp::consolidaGFImp] end");
	}

	public void consolidaSCImp(BigDecimal codImpianto, List<L45SC> listSc, Integer idPersonaGiuridica, String cfUtente) throws SigitextException {
		log.debug("[DbServiceImp::consolidaSCImp] start");
		List<String> progressivi = new ArrayList<String>();
		try {

			String SC = "SC";
			for (L45SC rowSC : listSc) {

				SigitTComp4Dto comp4 = MapDtoImport.getSigitTComp4New(codImpianto, rowSC);
				BigDecimal progressivo = comp4.getProgressivo();
				SigitTCompScDto compScDto = MapDtoImport.mapToRowSCNew(codImpianto, rowSC.getL45Scambiatore(), progressivo, cfUtente);
				if (GenericUtil.isNullOrEmpty(compScDto.getDataInstall()))
					continue;

				log.debug("progressivo: " + progressivo + ", data inst: " + ConvertUtil.convertToString(compScDto.getDataInstall()));

				getSigitTComp4Dao().insert(comp4);
				log.debug("inserisco SC");
				getSigitTCompScDao().insert(compScDto);
				SigitRComp4ManutDto comp4Manut = MapDtoImport.getSigitRComp4ManutNew(codImpianto, rowSC.getL45Scambiatore(), idPersonaGiuridica, Constants.ID_RUOLO_MANUTENTORE_ALL_3, progressivo, cfUtente);
				getSigitRComp4ManutDao().insert(comp4Manut);

				List<L45ScambiatoreSostituitoDocument.L45ScambiatoreSostituito> scSostituiteList = rowSC.getL45ScambiatoreSostituitoList();

				log.debug("consolodamento SC sotituite");
				if (scSostituiteList != null)
					for (L45ScambiatoreSostituitoDocument.L45ScambiatoreSostituito rowSCSost : scSostituiteList) {

						SigitTCompScDto compSCSost = MapDtoImport.mapToRowSCSostNew(codImpianto, rowSCSost, progressivo, cfUtente);
						log.debug("inserisco SC sost");

						getSigitTCompScDao().insert(compSCSost);
					}
			}
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_UPDATE_DB, e);
		}
		log.debug("[DbServiceImp::consolidaSCImp] end");

	}

	public void consolidaCGImp(BigDecimal codImpianto, List<L46CG> listCg, Integer idPersonaGiuridica, String cfUtente) throws SigitextException {
		log.debug("[DbServiceImp::consolidaCGImp] start");
		List<String> progressivi = new ArrayList<String>();
		try {

			String CG = "CG";
			for (L46CG rowCG : listCg) {

				SigitTComp4Dto comp4 = MapDtoImport.getSigitTComp4New(codImpianto, rowCG);
				BigDecimal progressivo = comp4.getProgressivo();
				SigitTCompCgDto compCg = MapDtoImport.getSigitTCompCgNew(codImpianto, rowCG.getL46Cogeneratore(), progressivo, cfUtente);
				if (GenericUtil.isNullOrEmpty(compCg.getDataInstall()))
					continue;

				log.debug("progressivo: " + progressivo + ", data inst: " + ConvertUtil.convertToString(compCg.getDataInstall()));
				getSigitTComp4Dao().insert(comp4);

				log.debug("inserisco CG");
				getSigitTCompCgDao().insert(compCg);

				SigitRComp4ManutDto comp4Manut = MapDtoImport.getSigitRComp4ManutNew(codImpianto, rowCG.getL46Cogeneratore(), idPersonaGiuridica, Constants.ID_RUOLO_MANUTENTORE_ALL_4, progressivo, cfUtente);
				getSigitRComp4ManutDao().insert(comp4Manut);

				List<L46CogeneratoreSostituitoDocument.L46CogeneratoreSostituito> gfSostituiteList = rowCG.getL46CogeneratoreSostituitoList();

				log.debug("consolodamento CG sotituite");
				if (gfSostituiteList != null)
					for (L46CogeneratoreSostituitoDocument.L46CogeneratoreSostituito rowCGSost : gfSostituiteList) {

						SigitTCompCgDto compCgSost = MapDtoImport.getSigitTCompCgSostNew(codImpianto, rowCGSost, progressivo, cfUtente);

						log.debug("inserisco CG sost");

						getSigitTCompCgDao().insert(compCgSost);
					}
			}
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_UPDATE_DB, e);
		}
		log.debug("[DbServiceImp::consolidaCGImp] end");

	}

	public void consolidaCSImp(BigDecimal codImpianto, List<L47CS> listCs, String cfUtente) throws SigitextException {
		log.debug("[DbServiceImp::consolidaCSImp] start");
		List<String> progressivi = new ArrayList<String>();

		try {
			String CS = "CS";

			for (L47CS rowCS : listCs) {

				BigDecimal progressivo = ConvertUtil.convertToBigDecimal(rowCS.getL47Numero());

				SigitTCompCsDto compCsDto = MapDtoImport.getSigitTCompCsDtoNew(codImpianto, rowCS.getL47CampoSolareTermico(), progressivo, cfUtente);

				if (GenericUtil.isNullOrEmpty(compCsDto.getDataInstall()))
					continue;
				progressivi.add(progressivo.toString());

				log.debug("progressivo: " + progressivo);

				SigitTComp4Dto comp4 = MapDtoImport.getSigitTComp4New(codImpianto, rowCS);
				getSigitTComp4Dao().insert(comp4);

				log.debug("inserisco CS");
				getSigitTCompCsDao().insert(compCsDto);

				List<L47CampoSolareTermicoSostituitoDocument.L47CampoSolareTermicoSostituito> csSostituiteList = rowCS.getL47CampoSolareTermicoSostituitoList();

				if (csSostituiteList != null) {
					for (L47CampoSolareTermicoSostituitoDocument.L47CampoSolareTermicoSostituito csVar : csSostituiteList) {
						SigitTCompCsDto csVarDto = MapDtoImport.getSigitTCompCsDtoSostNew(codImpianto, csVar, progressivo, cfUtente);
						log.debug("inserisco CS sost");

						getSigitTCompCsDao().insert(csVarDto);
					}

				} else
					log.debug("Nessuna variazione CS");
			}
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_UPDATE_DB, e);
		}
		log.debug("[DbServiceImp::consolidaCSImp] end");

	}

	public void consolidaAGImp(BigDecimal codImpianto, List<L48AG> listAg, String cfUtente) throws SigitextException {
		log.debug("[DbServiceImp::consolidaAGImp] start");
		List<String> progressivi = new ArrayList<String>();

		try {
			String AG = "AG";

			for (L48AG rowAG : listAg) {

				BigDecimal progressivo = ConvertUtil.convertToBigDecimal(rowAG.getL48Numero());
				SigitTCompAgDto compAgDto = MapDtoImport.getSigitTCompAgNew(codImpianto, rowAG.getL48AltroGeneratore(), progressivo, cfUtente);

				if (GenericUtil.isNullOrEmpty(compAgDto.getDataInstall()))
					continue;

				log.debug("progressivo: " + progressivo);

				SigitTComp4Dto comp4 = MapDtoImport.getSigitTComp4New(codImpianto, rowAG);
				getSigitTComp4Dao().insert(comp4);

				log.debug("inserisco AG");
				getSigitTCompAgDao().insert(compAgDto);

				List<L48AltroGeneratoreSostituito> agSostituiteList = rowAG.getL48AltroGeneratoreSostituitoList();

				log.debug("consolodamento AG sotituite");
				if (agSostituiteList != null)
					for (L48AltroGeneratoreSostituito rowAGSost : agSostituiteList) {

						SigitTCompAgDto compAGSost = MapDtoImport.getSigitTCompAgSostNew(codImpianto, rowAGSost, progressivo, cfUtente);

						getSigitTCompAgDao().insert(compAGSost);

					}
			}

		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_UPDATE_DB, e);
		}

		log.debug("[DbServiceImp::consolidaAGImp] end");

	}

	public void consolidaSistemiRegolazioneContabilizzazione(LibrettoCatastoDocument.LibrettoCatasto librettoCat, BigDecimal codImpianto, String cfUtente) throws SigitextException {
		log.debug("[DbServiceImp::consolidaSistemiRegolazione] START");
		try {
			log.debug("cancellazione sigit_t_compx_semplice");

			getSigitTCompXSempliceDao().customDeleterByCodImpianto(new Integer(codImpianto.intValue()));
			getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_compx_semplice", "codice_impianto=" + codImpianto));

			L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione datiSchedaSistemiRegolaz = librettoCat.getL5SistemiRegolazioneContabilizzazione();
			if (datiSchedaSistemiRegolaz != null) {
				log.debug("Consolidamento scheda 5");

				SigitTCompXSempliceDto dtoXsemplice = new SigitTCompXSempliceDto();

				log.debug("Consolidamento scheda 5: regolazione primaria");
				boolean isValvoleRegolazione = false;

				if (datiSchedaSistemiRegolaz.getL51VRList() != null && datiSchedaSistemiRegolaz.getL51VRList().size() > 0) {
					isValvoleRegolazione = true;
				}

				dtoXsemplice = MapDtoImport.getSigitTCompxSempliceNew(datiSchedaSistemiRegolaz, isValvoleRegolazione, cfUtente);

				consolidaSRImp(datiSchedaSistemiRegolaz.getL51SRList(), codImpianto, cfUtente);
				consolidaVRImp(datiSchedaSistemiRegolaz.getL51VRList(), codImpianto, cfUtente);

				dtoXsemplice.setCodiceImpianto(codImpianto);

				log.debug("Consolidamento scheda 5: regolazione singolo ambiente di zona");
				MapDtoImport.getSigitTCompxSempliceNew(datiSchedaSistemiRegolaz, dtoXsemplice);

				L6SistemiDistribuzioneDocument.L6SistemiDistribuzione datiSchedaSistemiDistrib = librettoCat.getL6SistemiDistribuzione();
				if (datiSchedaSistemiDistrib != null) {
					log.debug("Consolidamento scheda 6: sistemi di distribuzione");
					MapDtoImport.getSigitTCompXSempliceNew(dtoXsemplice, datiSchedaSistemiDistrib);

					consolidaVXImp(datiSchedaSistemiDistrib.getL63VXList(), codImpianto, cfUtente);
					consolidaPOImp(datiSchedaSistemiDistrib.getL64POList(), codImpianto, cfUtente);
				}

				L7SistemiEmissioneDocument.L7SistemiEmissione datiSchedaSistemaEmissione = librettoCat.getL7SistemiEmissione();

				if (datiSchedaSistemaEmissione != null) {
					log.debug("Consolidamento scheda 7: sistema emissione");
					MapDtoImport.getSigitTCompxSempliceNew(datiSchedaSistemaEmissione, dtoXsemplice);
				}
				log.debug("inserimento compx_semplice");
				getSigitTCompXSempliceDao().insert(dtoXsemplice);
			}
		} catch (Exception e) {
			log.error("Errore ", e);
			throw new SigitextException(Messages.ERROR_UPDATE_DB, e);
		} finally {
			log.debug("[DbServiceImp::consolidaSistemiRegolazione] END");
		}

	}

	private void consolidaSRImp(List<L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione.L51SR> srList, BigDecimal codImpianto, String cfUtente)
			throws SigitTCompSrDaoException, SigitTCompXDaoException {
		log.debug("[DbServiceImp::consolidaSRImp] start");

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_sr", "codice_impianto=" + codImpianto));

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto=" + codImpianto + "&tipo_componente=SR"));

		if (srList != null) {
			log.debug("Consolidamento scheda 5: regolazione primaria - SR");

			if (srList != null)
				for (L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione.L51SR rowSR : srList) {
					SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowSR.getL51SistemaRegolazione(), codImpianto, rowSR.getL51Numero(), cfUtente);
					if (compX != null && compX.getDataInstall() != null) {
						log.debug("Inserimento COMP SR");
						SigitTCompSrDto compSr = MapDtoImport.getSigitTCompSRNew(rowSR.getL51SistemaRegolazione(), codImpianto, rowSR.getL51Numero());

						getSigitTCompXDao().insert(compX);
						getSigitTCompSrDao().insert(compSr);
					}
					log.debug("Inserimento sezione sostituite");
					List<L51SistemaRegolazioneSostituitoDocument.L51SistemaRegolazioneSostituito> rowSRsostList = rowSR.getL51SistemaRegolazioneSostituitoList();
					if (rowSRsostList != null)
						for (L51SistemaRegolazioneSostituitoDocument.L51SistemaRegolazioneSostituito rowSRsost : rowSRsostList) {
							SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowSRsost, codImpianto, rowSR.getL51Numero(), cfUtente);
							SigitTCompSrDto xSrDto = MapDtoImport.getSigitTCompSRNew(rowSRsost, codImpianto, rowSR.getL51Numero());

							getSigitTCompXDao().insert(xSostDto);
							getSigitTCompSrDao().insert(xSrDto);
						}
				}
		}

		log.debug("[DbServiceImp::consolidaSRImp] end");

	}

	private void consolidaVRImp(List<L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione.L51VR> vrList, BigDecimal codImpianto, String cfUtente)
			throws SigitTCompXDaoException, SigitTCompVrDaoException {
		log.debug("[DbServiceImp::consolidaTrattamentoH2oImp] start");

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_vr", "codice_impianto=" + codImpianto));

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto=" + codImpianto + "&tipo_componente=VR"));

		if (vrList != null) {
			log.debug("Consolidamento scheda 5: regolazione primaria - VR");

			if (vrList != null)
				for (L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione.L51VR rowVR : vrList) {
					SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowVR.getL51ValvolaRegolazione(), codImpianto, rowVR.getL51Numero(), cfUtente);
					if (compX != null && compX.getDataInstall() != null) {
						log.debug("Inserimento COMP VR");
						SigitTCompVrDto compVr = MapDtoImport.getSigitTCompVRNew(rowVR.getL51ValvolaRegolazione(), codImpianto, rowVR.getL51Numero());

						getSigitTCompXDao().insert(compX);
						getSigitTCompVrDao().insert(compVr);
					}

					log.debug("Inserimento sezione sostituite");
					List<L51ValvolaRegolazioneSostituitoDocument.L51ValvolaRegolazioneSostituito> rowVRsostList = rowVR.getL51ValvolaRegolazioneSostituitoList();

					if (rowVRsostList != null)
						for (L51ValvolaRegolazioneSostituitoDocument.L51ValvolaRegolazioneSostituito rowVRsost : rowVRsostList) {
							SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowVRsost, codImpianto, rowVR.getL51Numero(), cfUtente);
							SigitTCompVrDto xVrDto = MapDtoImport.getSigitTCompVRNew(rowVRsost, codImpianto, rowVR.getL51Numero());

							getSigitTCompXDao().insert(xSostDto);
							getSigitTCompVrDao().insert(xVrDto);
						}
				}
		}

		log.debug("[DbServiceImp::consolidaVRImp] end");
	}

	private void consolidaVXImp(List<L6SistemiDistribuzioneDocument.L6SistemiDistribuzione.L63VX> srList, BigDecimal codImpianto, String cfUtente)
			throws SigitTCompXDaoException, SigitTCompVxDaoException {

		log.debug("[DbServiceImp::consolidaVXImp] start");

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_vx", "codice_impianto=" + codImpianto));

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto=" + codImpianto + "&tipo_componente=VX"));

		if (srList != null) {
			log.debug("Consolidamento scheda 6: vasi - VX");

			if (srList != null)
				for (L6SistemiDistribuzioneDocument.L6SistemiDistribuzione.L63VX rowVX : srList) {
					SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowVX.getL63VasoEspansione(), codImpianto, rowVX.getL63Numero(), cfUtente);
					if (compX != null && compX.getProgressivo() != null) {
						log.debug("Inserimento COMP VX");
						SigitTCompVxDto compVx = MapDtoImport.getSigitTCompVXNew(rowVX.getL63VasoEspansione(), codImpianto, rowVX.getL63Numero());

						getSigitTCompXDao().insert(compX);
						getSigitTCompVxDao().insert(compVx);
					}
				}
		}

		log.debug("[DbServiceImp::consolidaVXImp] end");

	}

	private void consolidaPOImp(List<L6SistemiDistribuzioneDocument.L6SistemiDistribuzione.L64PO> srList, BigDecimal codImpianto, String cfUtente)
			throws SigitTCompPoDaoException, SigitTCompXDaoException {

		log.debug("[DbServiceImp::consolidaPOImp] start");

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_po", "codice_impianto=" + codImpianto));

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto=" + codImpianto + "&tipo_componente=SR"));

		if (srList != null) {
			log.debug("Consolidamento scheda 6: regolazione primaria - PO");

			if (srList != null)
				for (L6SistemiDistribuzioneDocument.L6SistemiDistribuzione.L64PO rowPO : srList) {
					SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowPO.getL64Pompa(), codImpianto, rowPO.getL64Numero(), cfUtente);

					if (compX != null && compX.getDataInstall() != null) {
						log.debug("Inserimento COMP PO");
						SigitTCompPoDto compVr = MapDtoImport.getSigitTCompPONew(rowPO.getL64Pompa(), codImpianto, rowPO.getL64Numero());

						getSigitTCompXDao().insert(compX);
						getSigitTCompPoDao().insert(compVr);
					}

					List<L64PompaSostituitoDocument.L64PompaSostituito> rowPOsostList = rowPO.getL64PompaSostituitoList();

					if (rowPOsostList != null) {
						log.debug("Inserimento sezione sostituite");

						if (rowPOsostList != null)
							for (L64PompaSostituitoDocument.L64PompaSostituito rowVRsost : rowPOsostList) {

								SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowVRsost, codImpianto, rowPO.getL64Numero(), cfUtente);
								SigitTCompPoDto xPoDto = MapDtoImport.getSigitTCompPONew(rowVRsost, codImpianto, rowPO.getL64Numero());

								getSigitTCompXDao().insert(xSostDto);
								getSigitTCompPoDao().insert(xPoDto);
							}
					}
				}
		}

		log.debug("[DbServiceImp::consolidaPOImp] end");

	}

	public void consolidaACImp(List<L8SistemiAccumuloDocument.L8SistemiAccumulo.L81AC> acList, BigDecimal codImpianto, String cfUtente) throws SigitTCompAcDaoException, SigitTCompXDaoException {

		log.debug("[DbServiceImp::consolidaACImp] start");

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_ac", "codice_impianto=" + codImpianto));

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto=" + codImpianto + "&tipo_componente=AC"));

		if (acList != null) {
			if (acList != null) {
				log.debug("Consolidamento scheda 8: AC");
				if (acList != null)
					for (L8SistemiAccumuloDocument.L8SistemiAccumulo.L81AC rowAC : acList) {
						SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowAC.getL81Accumulo(), codImpianto, rowAC.getL81Numero(), cfUtente);
						if (compX != null && compX.getDataInstall() != null) {
							log.debug("Inserimento COMP AC");
							//salvataggio
							SigitTCompAcDto compAc = MapDtoImport.getSigitTCompACNew(rowAC.getL81Accumulo(), codImpianto, rowAC.getL81Numero());
							getSigitTCompXDao().insert(compX);
							getSigitTCompAcDao().insert(compAc);
						}

						log.debug("Inserimento sezione sostituite");
						List<L81AccumuloSostituitoDocument.L81AccumuloSostituito> rowACsostList = rowAC.getL81AccumuloSostituitoList();
						if (rowACsostList != null)
							for (L81AccumuloSostituitoDocument.L81AccumuloSostituito rowACsost : rowACsostList) {
								String progressivo = ConvertUtil.convertToString(rowAC.getL81Numero());
								SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowACsost, codImpianto, progressivo, cfUtente);
								SigitTCompAcDto xAcDto = MapDtoImport.getSigitTCompACNew(rowACsost, codImpianto, progressivo);

								getSigitTCompXDao().insert(xSostDto);
								getSigitTCompAcDao().insert(xAcDto);
							}
					}
			}
		}
		log.debug("[DbServiceImp::consolidaACImp] end");
	}

	public void consolidaTEImp(List<L9AltriComponentiDocument.L9AltriComponenti.L91TE> acList, BigDecimal codImpianto, String cfUtente) throws SigitTCompXDaoException, SigitTCompTeDaoException {

		log.debug("[DbServiceImp::consolidaTEImp] start");

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_te", "codice_impianto=" + codImpianto));

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto=" + codImpianto + "&tipo_componente=TE"));

		if (acList != null) {
			if (acList != null) {
				log.debug("Consolidamento scheda 9: TE");
				if (acList != null)
					for (L9AltriComponentiDocument.L9AltriComponenti.L91TE rowTE : acList) {
						SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowTE.getL91Torre(), codImpianto, rowTE.getL91Numero(), cfUtente);
						if (compX != null && compX.getDataInstall() != null) {
							log.debug("Inserimento COMP TE");
							//salvataggio
							SigitTCompTeDto compTe = MapDtoImport.getSigitTCompTENew(rowTE.getL91Torre(), codImpianto, rowTE.getL91Numero());

							getSigitTCompXDao().insert(compX);
							getSigitTCompTeDao().insert(compTe);
						}
						log.debug("Inserimento sezione sostituite");
						List<L91TorreSostituitoDocument.L91TorreSostituito> rowTEsostList = rowTE.getL91TorreSostituitoList();
						if (rowTEsostList != null)
							for (L91TorreSostituitoDocument.L91TorreSostituito rowTEsost : rowTEsostList) {
								String progressivo = ConvertUtil.convertToString(rowTE.getL91Numero());
								SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowTEsost, codImpianto, progressivo, cfUtente);
								SigitTCompTeDto xTeDto = MapDtoImport.getSigitTCompTENew(rowTEsost, codImpianto, progressivo);

								getSigitTCompXDao().insert(xSostDto);
								getSigitTCompTeDao().insert(xTeDto);
							}
					}
			}
		}

		log.debug("[DbServiceImp::consolidaTEImp] end");

	}

	public void consolidaRVImp(List<L9AltriComponentiDocument.L9AltriComponenti.L92RV> acList, BigDecimal codImpianto, String cfUtente) throws SigitTCompRvDaoException, SigitTCompXDaoException {

		log.debug("[DbServiceImp::consolidaRVImp] start");

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_rv", "codice_impianto=" + codImpianto));

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto=" + codImpianto + "&tipo_componente=RV"));
		if (acList != null) {
			if (acList != null) {
				log.debug("Consolidamento scheda 9: RV");

				if (acList != null)
					for (L9AltriComponentiDocument.L9AltriComponenti.L92RV rowRV : acList) {
						SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowRV.getL92Raffreddatore(), codImpianto, rowRV.getL92Numero(), cfUtente);
						if (compX != null && compX.getDataInstall() != null) {
							log.debug("Inserimento COMP RV");
							//salvataggio
							SigitTCompRvDto compTe = MapDtoImport.getSigitTCompRVNew(rowRV.getL92Raffreddatore(), codImpianto, rowRV.getL92Numero());

							getSigitTCompXDao().insert(compX);
							getSigitTCompRvDao().insert(compTe);
						}

						log.debug("Inserimento sezione sostituite");
						List<L92RaffreddatoreSostituitoDocument.L92RaffreddatoreSostituito> rowRVsostList = rowRV.getL92RaffreddatoreSostituitoList();
						if (rowRVsostList != null)
							for (L92RaffreddatoreSostituitoDocument.L92RaffreddatoreSostituito rowRVsost : rowRVsostList) {
								String progressivo = ConvertUtil.convertToString(rowRV.getL92Numero());
								SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowRVsost, codImpianto, progressivo, cfUtente);
								SigitTCompRvDto xTeDto = MapDtoImport.getSigitTCompRVNew(rowRVsost, codImpianto, progressivo);

								getSigitTCompXDao().insert(xSostDto);
								getSigitTCompRvDao().insert(xTeDto);
							}
					}
			}
		}

		log.debug("[DbServiceImp::consolidaRVImp] end");

	}

	public void consolidaSCXImp(List<L9AltriComponentiDocument.L9AltriComponenti.L93SCX> acList, BigDecimal codImpianto, String cfUtente) throws SigitTCompScxDaoException, SigitTCompXDaoException {

		log.debug("[DbServiceImp::consolidaSCXImp] start");

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_scx", "codice_impianto=" + codImpianto));

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto=" + codImpianto + "&tipo_componente=SCX"));

		if (acList != null) {
			if (acList != null) {
				log.debug("Consolidamento scheda 9: SC");

				for (L9AltriComponentiDocument.L9AltriComponenti.L93SCX rowSC : acList) {
					SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowSC.getL93ScambiatoreIntermedio(), codImpianto, rowSC.getL93Numero(), cfUtente);
					if (compX != null && compX.getDataInstall() != null) {
						log.debug("Inserimento COMP SC");
						//salvataggio
						SigitTCompScxDto compSc = MapDtoImport.getSigitTCompSCXNew(rowSC.getL93ScambiatoreIntermedio(), codImpianto, rowSC.getL93Numero());

						getSigitTCompXDao().insert(compX);
						getSigitTCompScxDao().insert(compSc);
					}

					log.debug("Inserimento sezione sostituite");
					List<L93ScambiatoreIntermedioSostituitoDocument.L93ScambiatoreIntermedioSostituito> rowSCsostList = rowSC.getL93ScambiatoreIntermedioSostituitoList();
					if (rowSCsostList != null)
						for (L93ScambiatoreIntermedioSostituitoDocument.L93ScambiatoreIntermedioSostituito rowSCsost : rowSCsostList) {
							String progressivo = ConvertUtil.convertToString(rowSC.getL93Numero());
							SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowSCsost, codImpianto, progressivo, cfUtente);
							SigitTCompScxDto xScDto = MapDtoImport.getSigitTCompSCXNew(rowSCsost, codImpianto, progressivo);

							getSigitTCompXDao().insert(xSostDto);
							getSigitTCompScxDao().insert(xScDto);
						}
				}
			}
		}

		log.debug("[DbServiceImp::consolidaSCXImp] end");

	}

	public void consolidaCIImp(List<L9AltriComponentiDocument.L9AltriComponenti.L94CI> acList, BigDecimal codImpianto, String cfUtente) throws SigitTCompCiDaoException, SigitTCompXDaoException {

		log.debug("[DbServiceImp::consolidaCIImp] start");

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_ci", "codice_impianto=" + codImpianto));

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto=" + codImpianto + "&tipo_componente=CI"));
		if (acList != null) {
			if (acList != null) {
				log.debug("Consolidamento scheda 9: CI");

				if (acList != null)
					for (L9AltriComponentiDocument.L9AltriComponenti.L94CI rowSC : acList) {
						SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowSC.getL94Circuito(), codImpianto, rowSC.getL94Numero(), cfUtente);
						if (compX != null && compX.getDataInstall() != null) {
							log.debug("Inserimento COMP CI");
							//salvataggio
							SigitTCompCiDto compCi = MapDtoImport.getSigitTCompCINew(rowSC.getL94Circuito(), codImpianto, rowSC.getL94Numero());

							getSigitTCompXDao().insert(compX);
							getSigitTCompCiDao().insert(compCi);
						}

						log.debug("Inserimento sezione sostituite");
						List<L94CircuitoSostituitoDocument.L94CircuitoSostituito> rowCIsostList = rowSC.getL94CircuitoSostituitoList();
						if (rowCIsostList != null) {
							for (L94CircuitoSostituitoDocument.L94CircuitoSostituito rowCIsost : rowCIsostList) {
								String progressivo = ConvertUtil.convertToString(rowSC.getL94Numero());
								SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowCIsost, codImpianto, progressivo, cfUtente);
								SigitTCompCiDto xCiDto = MapDtoImport.getSigitTCompCINew(rowCIsost, codImpianto, progressivo);
								getSigitTCompXDao().insert(xSostDto);
								getSigitTCompCiDao().insert(xCiDto);
							}
						}
					}
			}
		}

		log.debug("[DbServiceImp::consolidaCIImp] end");

	}

	public void consolidaUTImp(List<L9AltriComponentiDocument.L9AltriComponenti.L95UT> acList, BigDecimal codImpianto, String cfUtente) throws SigitTCompXDaoException, SigitTCompUtDaoException {

		log.debug("[DbServiceImp::consolidaUTImp] start");

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_ut", "codice_impianto=" + codImpianto));

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto=" + codImpianto + "&tipo_componente=UT"));
		if (acList != null) {
			if (acList != null) {
				log.debug("Consolidamento scheda 9: UT");
				if (acList != null)
					for (L9AltriComponentiDocument.L9AltriComponenti.L95UT rowUT : acList) {
						SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowUT.getL95UnitaTrattAria(), codImpianto, rowUT.getL95Numero(), cfUtente);
						if (compX != null && compX.getDataInstall() != null) {
							log.debug("Inserimento COMP UT");
							SigitTCompUtDto compUt = MapDtoImport.getSigitTCompUTNew(rowUT.getL95UnitaTrattAria(), codImpianto, rowUT.getL95Numero());

							getSigitTCompXDao().insert(compX);
							getSigitTCompUtDao().insert(compUt);
						}
						log.debug("Inserimento sezione sostituite");
						List<L95UnitaTrattAriaSostituitoDocument.L95UnitaTrattAriaSostituito> rowCIsostList = rowUT.getL95UnitaTrattAriaSostituitoList();
						if (rowCIsostList != null)
							for (L95UnitaTrattAriaSostituitoDocument.L95UnitaTrattAriaSostituito rowUTsost : rowCIsostList) {
								String progressivo = ConvertUtil.convertToString(rowUT.getL95Numero());
								SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowUTsost, codImpianto, progressivo, cfUtente);
								SigitTCompUtDto xUtDto = MapDtoImport.getSigitTCompUTNew(rowUTsost, codImpianto, progressivo);

								getSigitTCompXDao().insert(xSostDto);
								getSigitTCompUtDao().insert(xUtDto);
							}
					}
			}
		}

		log.debug("[DbServiceImp::consolidaUTImp] end");

	}

	public void consolidaRCImp(List<L9AltriComponentiDocument.L9AltriComponenti.L96RCX> rowRCList, BigDecimal codImpianto, String cfUtente) throws SigitTCompXDaoException, SigitTCompRcDaoException {

		log.debug("[DbServiceImp::consolidaRCImp] start");

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_rc", "codice_impianto=" + codImpianto));

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto=" + codImpianto + "&tipo_componente=RC"));

		if (rowRCList != null) {
			if (rowRCList != null) {
				log.debug("Consolidamento scheda 9: RC");

				if (rowRCList != null)
					for (L9AltriComponentiDocument.L9AltriComponenti.L96RCX rowRC : rowRCList) {
						SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowRC.getL96RecuperatoreAriaAmb(), codImpianto, rowRC.getL96Numero(), cfUtente);
						if (compX != null && compX.getDataInstall() != null) {
							log.debug("Inserimento COMP RC");
							SigitTCompRcDto compRc = MapDtoImport.getSigitTCompRCNew(rowRC.getL96RecuperatoreAriaAmb(), codImpianto, rowRC.getL96Numero());

							getSigitTCompXDao().insert(compX);
							getSigitTCompRcDao().insert(compRc);
						}

						log.debug("Inserimento sezione sostituite");
						List<L96RecuperatoreAriaAmbSostituitoDocument.L96RecuperatoreAriaAmbSostituito> rowRCsostList = rowRC.getL96RecuperatoreAriaAmbSostituitoList();
						if (rowRCsostList != null)
							for (L96RecuperatoreAriaAmbSostituitoDocument.L96RecuperatoreAriaAmbSostituito rowRCsost : rowRCsostList) {
								String progressivo = ConvertUtil.convertToString(rowRC.getL96Numero());
								SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowRCsost, codImpianto, progressivo, cfUtente);
								SigitTCompRcDto xRcDto = MapDtoImport.getSigitTCompRCNew(rowRCsost, codImpianto, progressivo);

								getSigitTCompXDao().insert(xSostDto);
								getSigitTCompRcDao().insert(xRcDto);
							}
					}
			}
		}

		log.debug("[DbServiceImp::consolidaTrattamentoH2oImp] end");

	}

	public void consolidaVMImp(List<L10VentilazioneDocument.L10Ventilazione.L101VM> rowVMList, BigDecimal codImpianto, String cfUtente) throws SigitTCompXDaoException, SigitTCompVmDaoException {

		log.debug("[DbServiceImp::consolidaVMImp] start");

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_vm", "codice_impianto=" + codImpianto));

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto=" + codImpianto + "&tipo_componente=VM"));
		if (rowVMList != null) {

			if (rowVMList != null) {
				log.debug("Consolidamento scheda 10: VM");

				if (rowVMList != null)
					for (L10VentilazioneDocument.L10Ventilazione.L101VM rowVM : rowVMList) {
						SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowVM.getL101VentilazioneMeccanica(), codImpianto, rowVM.getL101Numero(), cfUtente);
						if (compX != null && compX.getDataInstall() != null) {
							log.debug("Inserimento COMP VM");
							SigitTCompVmDto compVm = MapDtoImport.getSigitTCompVMNew(rowVM.getL101VentilazioneMeccanica(), codImpianto, rowVM.getL101Numero());

							getSigitTCompXDao().insert(compX);
							getSigitTCompVmDao().insert(compVm);
						}

						log.debug("Inserimento sezione sostituite");
						List<L101VentilazioneMeccanicaSostituitoDocument.L101VentilazioneMeccanicaSostituito> rowVMsostList = rowVM.getL101VentilazioneMeccanicaSostituitoList();
						if (rowVMsostList != null)
							for (L101VentilazioneMeccanicaSostituitoDocument.L101VentilazioneMeccanicaSostituito rowVMsost : rowVMsostList) {
								String progressivo = ConvertUtil.convertToString(rowVM.getL101Numero());
								SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowVMsost, codImpianto, progressivo, cfUtente);
								SigitTCompVmDto xVmDto = MapDtoImport.getSigitTCompVMNew(rowVMsost, codImpianto, progressivo);

								getSigitTCompXDao().insert(xSostDto);
								getSigitTCompVmDao().insert(xVmDto);
							}
					}
			}
		}

		log.debug("[DbServiceImp::consolidaVMImp] end");

	}

	public void consolidaConsumoCombustibileImp(List<L141ConsumoCombustibile> rowCombuList, BigDecimal codImpianto, String cfUtente) throws SigitTConsumoDaoException {
		log.debug("[DbServiceImp::consolidaConsumoCombustibileImp] start");

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_consumo", "codice_impianto=" + codImpianto + "&tipo_consumo=14.1(CB)"));
		if (rowCombuList != null) {

			if (rowCombuList != null) {
				log.debug("Consolidamento scheda 14.1 : combustibile");

				if (rowCombuList != null)
					for (L141ConsumoCombustibile rowCombu : rowCombuList) {
						BigDecimal tipoCombustibile = null;
						BigDecimal unitaMisura = null;

						try {
							tipoCombustibile = ConvertUtil.convertToBigDecimal(rowCombu.getL141Combustibile());
						} catch (Exception e) {
						}

						try {
							unitaMisura = ConvertUtil.convertToBigDecimal(rowCombu.getL141UnitaMisura());
						} catch (Exception e) {
						}

						List<L141DatiConsumoCombustibileDocument.L141DatiConsumoCombustibile> rowConsumoList = rowCombu.getL141DatiConsumoCombustibileList();
						if (rowConsumoList != null)
							for (L141DatiConsumoCombustibileDocument.L141DatiConsumoCombustibile rowConsumo : rowConsumoList) {
								SigitTConsumoDto dto = MapDtoImport.getSigitTConsumoNew(rowConsumo, codImpianto, tipoCombustibile, unitaMisura, cfUtente);

								if (dto != null) {
									log.debug("Inserimento CONSUMO CB");
									getSigitTConsumoDao().insert(dto);
								}
							}
					}
			}
		}
		log.debug("[DbServiceImp::consolidaConsumoCombustibileImp] end");
	}

	public void consolidaConsumoEnergiaImp(L142ConsumoEnergiaElettrica rowEnergia, BigDecimal codImpianto, String cfUtente) throws SigitTConsumoDaoException {

		log.debug("[DbServiceImp::consolidaConsumoEnergiaImp] start");

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_consumo", "codice_impianto=" + codImpianto + "&tipo_consumo=14.2(EE)"));
		if (rowEnergia != null) {

			log.debug("Consolidamento scheda 14.2 : energia elettrica");
			List<L142DatiConsumoEnergiaElettricaDocument.L142DatiConsumoEnergiaElettrica> rowEnergiaList = rowEnergia.getL142DatiConsumoEnergiaElettricaList();
			if (rowEnergiaList != null)
				for (L142DatiConsumoEnergiaElettricaDocument.L142DatiConsumoEnergiaElettrica rowEE : rowEnergiaList) {
					SigitTConsumoDto dto = MapDtoImport.getSigitTConsumoNew(rowEE, codImpianto, cfUtente);
					if (GenericUtil.isNotNullOrEmpty(dto.getEsercizioDa()) || GenericUtil.isNotNullOrEmpty(dto.getEsercizioA()) || GenericUtil.isNotNullOrEmpty(dto.getConsumo())
							|| GenericUtil.isNotNullOrEmpty(dto.getLetturaFinale()) || GenericUtil.isNotNullOrEmpty(dto.getLetturaIniziale())) {
						log.debug("Inserimento CONSUMO EE");
						getSigitTConsumoDao().insert(dto);
					}
				}
		}

		log.debug("[DbServiceImp::consolidaConsumoEnergiaImp] end");
	}

	public void consolidaConsumoH2OImp(L143ConsumoAcqua sezH2O, BigDecimal codImpianto, String cfUtente) throws SigitTConsumoDaoException {

		log.debug("[DbServiceImp::consolidaConsumoH2OImp] start");

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_consumo", "codice_impianto=" + codImpianto + "&tipo_consumo=14.3(H2O)"));
		if (sezH2O != null) {
			String unitaMisura = ConvertUtil.convertToString(sezH2O.getL143UnitaMisura());

			if (sezH2O != null) {
				log.debug("Consolidamento scheda 14.3 : acqua");
				List<L143DatiConsumoAcquaDocument.L143DatiConsumoAcqua> rowH2OList = sezH2O.getL143DatiConsumoAcquaList();
				if (rowH2OList != null)
					for (L143DatiConsumoAcquaDocument.L143DatiConsumoAcqua rowH2O : rowH2OList) {
						SigitTConsumoDto dto = MapDtoImport.getSigitTConsumoNew(rowH2O, codImpianto, unitaMisura, cfUtente);
						if (GenericUtil.isNotNullOrEmpty(dto.getEsercizioDa()) || GenericUtil.isNotNullOrEmpty(dto.getEsercizioA()) || GenericUtil.isNotNullOrEmpty(dto.getConsumo())
								|| GenericUtil.isNotNullOrEmpty(dto.getLetturaFinale()) || GenericUtil.isNotNullOrEmpty(dto.getLetturaIniziale())) {
							log.debug("Inserimento CONSUMO H2O");
							getSigitTConsumoDao().insert(dto);
						}
					}
			}
		}

		log.debug("[DbServiceImp::consolidaConsumoH2OImp] end");

	}

	public void consolidaConsumoProdottiChimici(L144ConsumoProdottiChimici sezPC, BigDecimal codImpianto, String cfUtente) throws SigitTConsumo14_4DaoException {

		log.debug("[DbServiceImp::consolidaConsumoProdottiChimici] start");

		getSigitWrkLogDao().insert(MapDtoImport.mapToSigitWrkLogDto(cfUtente, "sigit_t_consumo_14_4", "codice_impianto=" + codImpianto));

		if (sezPC != null) {
			log.debug("Consolidamento scheda 14.4 : prodotti chimici");
			List<L144DatiConsumoProdottiChimiciDocument.L144DatiConsumoProdottiChimici> rowPCList = sezPC.getL144DatiConsumoProdottiChimiciList();
			if (rowPCList != null)
				for (L144DatiConsumoProdottiChimiciDocument.L144DatiConsumoProdottiChimici rowPC : rowPCList) {
					SigitTConsumo14_4Dto dto = MapDtoImport.getSigitTConsumo144New(rowPC, codImpianto, cfUtente);
					if (GenericUtil.isNotNullOrEmpty(dto.getEsercizioDa()) || GenericUtil.isNotNullOrEmpty(dto.getEsercizioA()) || GenericUtil.isNotNullOrEmpty(dto.getNomeProdotto())
							|| GenericUtil.isNotNullOrEmpty(dto.getQtaConsumata()) || GenericUtil.isNotNullOrEmpty(dto.getFlgAca()) || GenericUtil.isNotNullOrEmpty(dto.getFlgCircuitoAcs())
							|| GenericUtil.isNotNullOrEmpty(dto.getFlgCircuitoIt())) {
						log.debug("Inserimento CONSUMO prod chimici");
						getSigitTConsumo144Dao().insert(dto);
					}
				}
		}
		log.debug("[DbServiceImp::consolidaConsumoProdottiChimici] end");
	}

	public void inserisciPreImport(SigitTPreImportDto dto) throws SigitextException {
		log.debug("[DbServiceImp:::gestPreImport] START");
		try {
			getSigitTPreImportDao().insert(dto);
		} catch (Exception e) {
			log.error("Errore: ", e);
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp:::gestPreImport] END");
		}
	}

	public void aggiornaPreImport(SigitTPreImportDto dtoPreImport) throws SigitextException {
		log.debug("[DbServiceImp:::aggiornaPreImport] START");
		try {
			getSigitTPreImportDao().update(dtoPreImport);
		} catch (Exception e) {
			log.error("Errore: ", e);
			throw new SigitextException(Messages.ERROR_UPDATE_DB);
		} finally {
			log.debug("[DbServiceImp:::aggiornaPreImport] END");
		}
	}

	@Transactional
	public SigitTImportDto insertImport(ImportFilter importData) throws SigitextException {
		log.debug("[DbServiceImp:::insertImport] START");
		try {
			SigitTImportDto dto = MapDto.mapToSigitTImport(importData);
			getSigitTImportDao().insert(dto);
			SigitTImpXmlDto dtoXml = new SigitTImpXmlDto();
			dtoXml.setIdImport(dto.getIdImport());
			dtoXml.setFileImport(XmlBeanUtils.readByteArray(importData.getDatiXml()));
			getSigitTImpXmlDao().insert(dtoXml);
			return dto;

		} catch (Exception e) {
			log.error("Errore: ", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new SigitextException(Messages.ERROR_INSERT_DB);
		} finally {
			log.debug("[DbServiceImp:::insertImport] END");
		}
	}

	public void aggiornaImport(SigitTImportDto importDto, String msgError, Integer idAllegato) throws SigitextException {
		log.debug("[DbServiceImp:::aggiornaImport] START");
		try {

			importDto.setDataFine(DateUtil.getSqlDataCorrente());
			importDto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));
			if (GenericUtil.isNullOrEmpty(msgError)) {
				importDto.setFlgEsito(java.math.BigDecimal.ONE);
			} else {
				importDto.setFlgEsito(java.math.BigDecimal.ZERO);
				importDto.setMsgErrore(msgError.substring(0, (msgError.length() > Constants.MAX_1000_LEN ? Constants.MAX_1000_LEN : msgError.length())));
			}

			getSigitTImportDao().update(importDto);
		} catch (Exception e) {
			log.error("Errore: ", e);
			throw new SigitextException(Messages.ERROR_UPDATE_DB);
		} finally {
			log.debug("[DbServiceImp:::aggiornaImport] END");
		}
	}

	public List<SigitTPersonaGiuridicaDto> cercaPersonaGiuridica(String codiceFiscale, String siglaRea, BigDecimal numeroRea) throws SigitextException {
		log.debug("[DbServiceImp::cercaPersonaGiuridica] BEGIN");
		List<SigitTPersonaGiuridicaDto> dtoList = null;
		CodiceReaAndFiscaleFilter codiceReaFiscaleFilter = new CodiceReaAndFiscaleFilter(siglaRea, numeroRea, codiceFiscale);

		try {

			dtoList = getSigitTPersonaGiuridicaDao().findByCodiceReaAndFiscale(codiceReaFiscaleFilter);

		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		}
		log.debug("[DbServiceImp::cercaPersonaGiuridica] END");
		return dtoList;
	}

	public List<SigitVSk4GtDto> getCompGtAttiviInDataByIdPg(String codImpianto, Date dataControllo, BigDecimal idPersonaGiusridica) throws SigitextException {
		log.debug("[DbServiceImp::getCompGtAttiviInDataByIdPg] START");
		try {

			AllegatiCompFilter input = new AllegatiCompFilter();
			input.setCodImpianto(codImpianto);
			input.setDataControllo(ConvertUtil.convertToSqlDate(dataControllo));
			input.setIdImpRuoloPfPg(ConvertUtil.convertToInteger(idPersonaGiusridica));

			return getSigitVSk4GtDao().findAttiviByCodImpiantoFkPg(input);
		} catch (SigitVSk4GtDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::getCompGtAttiviInDataByIdPg] END");
		}
	}

	public List<SigitVSk4GtDto> getCompGtAttiviInDataProgressivi(String codImpianto, String dataControllo, List<String> listaProgressivi) throws SigitextException {
		log.debug("[DbServiceImp::getCompGtAttiviInDataProgressivi] START");
		try {
			CompFilter input = new CompFilter(ConvertUtil.convertToInteger(codImpianto), listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitVSk4GtDao().findAttiviByCodImpiantoProgressivi(input);
		} catch (SigitVSk4GtDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::getCompGtAttiviInDataProgressivi] END");
		}
	}

	public List<SigitVSk4GfDto> getCompGfAttiviInDataByIdPg(String codImpianto, Date dataControllo, BigDecimal idPersonaGiusridica) throws SigitextException {
		log.debug("[DbServiceImp::getCompGfAttiviInDataByIdPg] START");
		try {

			AllegatiCompFilter input = new AllegatiCompFilter();
			input.setCodImpianto(codImpianto);
			input.setDataControllo(ConvertUtil.convertToSqlDate(dataControllo));
			input.setIdImpRuoloPfPg(ConvertUtil.convertToInteger(idPersonaGiusridica));

			return getSigitVSk4GfDao().findAttiviByCodImpiantoFkPg(input);
		} catch (SigitVSk4GfDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::getCompGfAttiviInDataByIdPg] END");
		}
	}

	public List<SigitVSk4GfDto> getCompGfAttiviInDataProgressivi(String codImpianto, String dataControllo, List<String> listaProgressivi) throws SigitextException {
		log.debug("[DbServiceImp::getCompGfAttiviInDataProgressivi] START");
		try {
			CompFilter input = new CompFilter(ConvertUtil.convertToInteger(codImpianto), listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitVSk4GfDao().findAttiviByCodImpiantoProgressivi(input);
		} catch (SigitVSk4GfDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::getCompGfAttiviInDataProgressivi] END");
		}
	}

	public List<SigitVSk4ScDto> getCompScAttiviInDataByIdPg(String codImpianto, Date dataControllo, BigDecimal idPersonaGiusridica) throws SigitextException {
		log.debug("[DbServiceImp::getCompScAttiviInDataByIdPg] START");
		try {

			AllegatiCompFilter input = new AllegatiCompFilter();
			input.setCodImpianto(codImpianto);
			input.setDataControllo(ConvertUtil.convertToSqlDate(dataControllo));
			input.setIdImpRuoloPfPg(ConvertUtil.convertToInteger(idPersonaGiusridica));

			return getSigitVSk4ScDao().findAttiviByCodImpiantoFkPg(input);
		} catch (SigitVSk4ScDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::getCompScAttiviInDataByIdPg] END");
		}
	}

	public List<SigitVSk4ScDto> getCompScAttiviInDataProgressivi(String codImpianto, String dataControllo, List<String> listaProgressivi) throws SigitextException {
		log.debug("[DbServiceImp::getCompScAttiviInDataProgressivi] START");
		try {
			CompFilter input = new CompFilter(ConvertUtil.convertToInteger(codImpianto), listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitVSk4ScDao().findAttiviByCodImpiantoProgressivi(input);
		} catch (SigitVSk4ScDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::getCompScAttiviInDataProgressivi] END");
		}
	}

	public List<SigitVSk4CgDto> getCompCgAttiviInDataByIdPg(String codImpianto, Date dataControllo, BigDecimal idPersonaGiusridica) throws SigitextException {
		log.debug("[DbServiceImp::getCompCgAttiviInDataByIdPg] START");
		try {

			AllegatiCompFilter input = new AllegatiCompFilter();
			input.setCodImpianto(codImpianto);
			input.setDataControllo(ConvertUtil.convertToSqlDate(dataControllo));
			input.setIdImpRuoloPfPg(ConvertUtil.convertToInteger(idPersonaGiusridica));

			return getSigitVSk4CgDao().findAttiviByCodImpiantoFkPg(input);
		} catch (SigitVSk4CgDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::getCompCgAttiviInDataByIdPg] END");
		}
	}

	public List<SigitVSk4CgDto> getCompCgAttiviInDataProgressivi(String codImpianto, String dataControllo, List<String> listaProgressivi) throws SigitextException {
		log.debug("[DbServiceImp::getCompCgAttiviInDataProgressivi] START");
		try {
			CompFilter input = new CompFilter(ConvertUtil.convertToInteger(codImpianto), listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitVSk4CgDao().findAttiviByCodImpiantoProgressivi(input);
		} catch (SigitVSk4CgDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::getCompCgAttiviInDataProgressivi] END");
		}
	}

	public List<SigitRComp4ManutDto> cercaAttualiByRuolo(String codiceImpianto, BigDecimal idPersonaGiuridica, Integer idRuolo, ArrayList<String> progressivi) throws SigitextException {
		log.debug("[DbServiceImp::cercaAttualiByRuolo] START");
		try {
			CompFilter filter = new CompFilter();
			filter.setCodImpianto(ConvertUtil.convertToInteger(codiceImpianto));
			filter.setIdPG(ConvertUtil.convertToInteger(idPersonaGiuridica));
			filter.setIdRuolo(idRuolo);
			filter.setListProgressivi(progressivi);

			return getSigitRComp4ManutDao().findByPersonaGiuridicaCodImpianto(filter);

		} catch (SigitRComp4ManutDaoException e) {
			log.error("Errore: ", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::cercaAttualiByRuolo] END");
		}
	}

	public SigitVTotImpiantoDto cercaResponsabileAttivoByCodImpianto(Integer codImpianto) throws SigitextException {
		SigitVTotImpiantoDto responsabile = null;

		List<SigitVTotImpiantoDto> listResp = cercaResponsabiliAttiviByCodImpianto(codImpianto);
		if (listResp != null && !listResp.isEmpty()) {
			responsabile = listResp.get(0);
		}

		return responsabile;
	}

	public List<SigitExtRespImpDto> cercaResponsabileAttivoByCodImpiantoExt(Integer codImpianto) throws SigitextException {
		try {
			return getSigitExtDao().findResponsabiliByCodiceImpianto(codImpianto);
		} catch (SigitExtDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[cercaResponsabileAttivoByCodImpianto] END");
		}

	}

	public List<SigitVTotImpiantoDto> cercaResponsabiliAttiviByCodImpianto(Integer codImpianto) throws SigitextException {
		List<SigitVTotImpiantoDto> dtoList = null;
		log.debug("[DbServiceImp::cercaResponsabiliAttiviByCodImpianto] BEGIN");
		try {
			dtoList = getSigitVTotImpiantoDao().findResponsabiliAttiviByCodiceImpianto(codImpianto);
		} catch (SigitVTotImpiantoDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::cercaResponsabileAttivoByCodImpianto] END");
		}
		return dtoList;
	}

	public List<SigitVTotImpiantoDto> cercaResponsabiliAttiviAllaDataByCodImpianto(String codImpianto, String dataControllo) throws SigitextException {
		List<SigitVTotImpiantoDto> dtoList = null;
		log.debug("[DbServiceImp::cercaResponsabiliAttiviAllaDataByCodImpianto] BEGIN");
		try {
			ResponsabileFilter filter = new ResponsabileFilter(ConvertUtil.convertToInteger(codImpianto), ConvertUtil.convertToSqlDate(dataControllo));

			dtoList = getSigitVTotImpiantoDao().findResponsabiliAttiviAllaDataByCodiceImpianto(filter);

		} catch (SigitVTotImpiantoDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::cercaResponsabiliAttiviAllaDataByCodImpianto] END");
		}
		return dtoList;
	}

	public List<SigitExtContrattoImpDto> cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(String codImpianto, String dataControllo) throws SigitextException {
		List<SigitExtContrattoImpDto> dtoList = null;
		log.debug("[DbServiceImp::cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp] BEGIN");
		try {
			ContrattoFilter filter = new ContrattoFilter();
			filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filter.setDataDal(ConvertUtil.convertToSqlDate(dataControllo));

			dtoList = getSigitExtDao().findStoriaContrattiImpiantoNew(filter);
		} catch (SigitExtDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp] END");
		}
		return dtoList;
	}

	public Integer cercaPrimoResponsabileAttivoAllaDataByCodImpiantoApp(String codImpianto, String dataRapporto, ArrayList<String> listaProgressivi) throws SigitextException {
		// Cerco preventivamente il responsabile
		// nel caso in cui non ci sia il responsabile cerco per ogni apparecchiature se esiste un 3 responsabile
		// se anche per una sola apparecchiatura non e' presente il 3 responsabile rilancio l'eccezione

		List<SigitVTotImpiantoDto> listResp = cercaResponsabiliAttiviAllaDataByCodImpianto(codImpianto, dataRapporto);
		if (listResp != null && !listResp.isEmpty()) {
			return listResp.size();
		}

		// Nel caso in cui non ci sia il responsabile ricerco i 3 responsabile per ogni apparecchiatura
		for (String progressivo : listaProgressivi) {

			//dcosta: mev reingegnerizzazione viste. Invece di restituire List<SigitVTotImpiantoDto> verra' restituita List<SigitVRicerca3ResponsabileDto>
			List<SigitExtContrattoImpDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(codImpianto, dataRapporto);
			if (list3RespAttiviImpianto == null || list3RespAttiviImpianto.isEmpty()) {

				// Alla prima apparecchiatura che non ha il 3 responsabile (e se sono qui e' perche' non ha neanche il responsabile) esco
				return null;

			} else {
				return list3RespAttiviImpianto.size();
			}
		}
		return null;
	}

	public Integer cercaPrimoResponsabileAttivoAllaDataByCodImpiantoApp(String codImpianto, String dataRapporto) throws SigitextException {
		List<SigitVTotImpiantoDto> listResp = cercaResponsabiliAttiviAllaDataByCodImpianto(codImpianto, dataRapporto);
		if (listResp != null && !listResp.isEmpty()) {
			return listResp.size();
		}
		List<SigitExtContrattoImpDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(codImpianto, dataRapporto);
		if (list3RespAttiviImpianto == null || list3RespAttiviImpianto.isEmpty()) {
			// Alla prima apparecchiatura che non ha il 3 responsabile (e se sono qui e' perche' non ha neanche il responsabile) esco
			return null;
		} else {
			return list3RespAttiviImpianto.size();
		}
	}

	@Transactional
	public void salvaAllegatoImport(DettaglioAllegato dettaglioAllegato, byte[] xml) throws SigitextException {
		log.debug("[DbServiceImp::salvaAllegato] BEGIN");
		try {

			log.debug("STAMPO ALLEGATO ID_APPARECCHIATURE: " + dettaglioAllegato.getIdApparecchiatureFunz());

			List<SigitVSk4GtDto> listCompGtDettDto = null;
			List<SigitVSk4GfDto> listCompGfDettDto = null;
			List<SigitVSk4ScDto> listCompScDettDto = null;
			List<SigitVSk4CgDto> listCompCgDettDto = null;

			if (dettaglioAllegato.getIdApparecchiatureFunz() != null && dettaglioAllegato.getIdApparecchiatureFunz().size() > 0) {
				String elencoApparecchiature = null;
				String elencoCombustibili = null;

				if (Constants.ALLEGATO_TIPO_1.equals(dettaglioAllegato.getIdTipoAllegato()) || Constants.ALLEGATO_TIPO_1B.equals(dettaglioAllegato.getIdTipoAllegato())
						|| Constants.MANUTENZIONE_GT.equals(dettaglioAllegato.getIdTipoAllegato())) {
					listCompGtDettDto = getCompGtAttiviInDataProgressivi(dettaglioAllegato.getCodiceImpianto(), dettaglioAllegato.getDataControllo(), dettaglioAllegato.getIdApparecchiatureFunz());

					elencoCombustibili = MapDto.mapToElencoCombustibiliGt(listCompGtDettDto);
					elencoApparecchiature = MapDto.mapToElencoApparecchiatureGt(listCompGtDettDto);
				}

				if (Constants.ALLEGATO_TIPO_2.equals(dettaglioAllegato.getIdTipoAllegato()) || Constants.MANUTENZIONE_GF.equals(dettaglioAllegato.getIdTipoAllegato())) {

					listCompGfDettDto = getCompGfAttiviInDataProgressivi(dettaglioAllegato.getCodiceImpianto(), dettaglioAllegato.getDataControllo(), dettaglioAllegato.getIdApparecchiatureFunz());
					elencoApparecchiature = MapDto.mapToElencoApparecchiatureGf(listCompGfDettDto);
				}

				if (Constants.ALLEGATO_TIPO_3.equals(dettaglioAllegato.getIdTipoAllegato()) || Constants.MANUTENZIONE_SC.equals(dettaglioAllegato.getIdTipoAllegato())) {
					listCompScDettDto = getCompScAttiviInDataProgressivi(dettaglioAllegato.getCodiceImpianto(), dettaglioAllegato.getDataControllo(), dettaglioAllegato.getIdApparecchiatureFunz());
					elencoApparecchiature = MapDto.mapToElencoApparecchiatureSc(listCompScDettDto);
				}

				if (Constants.ALLEGATO_TIPO_4.equals(dettaglioAllegato.getIdTipoAllegato()) || Constants.MANUTENZIONE_CG.equals(dettaglioAllegato.getIdTipoAllegato())) {
					listCompCgDettDto = getCompCgAttiviInDataProgressivi(dettaglioAllegato.getCodiceImpianto(), dettaglioAllegato.getDataControllo(), dettaglioAllegato.getIdApparecchiatureFunz());
					elencoApparecchiature = MapDto.mapToElencoApparecchiatureCg(listCompCgDettDto);
				}

				dettaglioAllegato.setElencoApparecchiature(elencoApparecchiature);

				dettaglioAllegato.setElencoCombustibili(elencoCombustibili);
			}

			if (Constants.ALLEGATO_TIPO_1.equals(dettaglioAllegato.getIdTipoAllegato()) || Constants.ALLEGATO_TIPO_1B.equals(dettaglioAllegato.getIdTipoAllegato())
					|| Constants.ALLEGATO_TIPO_2.equals(dettaglioAllegato.getIdTipoAllegato()) || Constants.ALLEGATO_TIPO_3.equals(dettaglioAllegato.getIdTipoAllegato())
					|| Constants.ALLEGATO_TIPO_4.equals(dettaglioAllegato.getIdTipoAllegato())) {

				BigDecimal numBollino = salvaCodiceBollino();
				dettaglioAllegato.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
				dettaglioAllegato.setNumeroBollinoVerde(ConvertUtil.convertToString(numBollino));
				dettaglioAllegato.setCodiceBollino(MapDto.costruisciCodiceBollino(dettaglioAllegato.getSiglaBollino(), ConvertUtil.convertToBigDecimal(dettaglioAllegato.getNumeroBollinoVerde())));

				dettaglioAllegato.setIdStatoRapporto(Constants.ID_STATO_RAPPORTO_BOZZA);
				dettaglioAllegato.setIdTipoRapProva(Constants.ID_TIPO_MANUTENZIONE_REE);
			} else {
				dettaglioAllegato.setIdStatoRapporto(Constants.ID_STATO_RAPPORTO_INVIATO);
			}

			SigitTAllegatoDto allegatoDto = MapDto.mapToAllegatoDtoForInsert(dettaglioAllegato);

			inserisciAllegato(allegatoDto);
			if (Constants.ALLEGATO_TIPO_1.equals(dettaglioAllegato.getIdTipoAllegato()) || Constants.ALLEGATO_TIPO_1B.equals(dettaglioAllegato.getIdTipoAllegato())
					|| Constants.MANUTENZIONE_GT.equals(dettaglioAllegato.getIdTipoAllegato())) {

				Map<BigDecimal, SigitVSk4GtDto> mapCompGtDettDto = new HashMap<BigDecimal, SigitVSk4GtDto>();

				for (SigitVSk4GtDto sigitVSk4GtDto : listCompGtDettDto) {

					inserisciRAllegatoCompGt(allegatoDto.getIdAllegato(), sigitVSk4GtDto);

					mapCompGtDettDto.put(sigitVSk4GtDto.getProgressivo(), sigitVSk4GtDto);

				}

				if (Constants.ALLEGATO_TIPO_1.equals(dettaglioAllegato.getIdTipoAllegato())) {
					it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument mod2Import = MapDto.mapToImportMODIIDocument(xml);

					salvaAllegato1DaXml(mod2Import, dettaglioAllegato, allegatoDto, mapCompGtDettDto);

				} else if (Constants.ALLEGATO_TIPO_1B.equals(dettaglioAllegato.getIdTipoAllegato())) {
					it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.MODIIBDocument mod2BImport = MapDto.mapToImportMODIIBDocument(xml);

					salvaAllegato1BDaXml(mod2BImport, dettaglioAllegato, allegatoDto, mapCompGtDettDto);

				} else {
					it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegt.data.MANUTENZIONEDocument manutenzioneGtDocument = MapDto.mapToImportMANUTENZIONEGTDocument(xml);

					salvaManutenzioneGtDaXml(manutenzioneGtDocument, allegatoDto);
				}
			} else if (Constants.ALLEGATO_TIPO_2.equals(dettaglioAllegato.getIdTipoAllegato()) || Constants.MANUTENZIONE_GF.equals(dettaglioAllegato.getIdTipoAllegato())) {
				Map<BigDecimal, SigitVSk4GfDto> mapCompGfDettDto = new HashMap<BigDecimal, SigitVSk4GfDto>();

				for (SigitVSk4GfDto sigitVSk4GfDto : listCompGfDettDto) {

					inserisciRAllegatoCompGf(allegatoDto.getIdAllegato(), sigitVSk4GfDto);

					mapCompGfDettDto.put(sigitVSk4GfDto.getProgressivo(), sigitVSk4GfDto);
				}

				if (Constants.ALLEGATO_TIPO_2.equals(dettaglioAllegato.getIdTipoAllegato())) {

					it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument mod3Import = MapDto.mapToImportMODIIIDocument(xml);

					salvaAllegato2DaXml(mod3Import, dettaglioAllegato, allegatoDto, mapCompGfDettDto);
				} else {

					it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegf.data.MANUTENZIONEDocument manutenzioneGfDocument = MapDto.mapToImportMANUTENZIONEGFDocument(xml);

					salvaManutenzioneGfDaXml(manutenzioneGfDocument, allegatoDto);
				}
			} else if (Constants.ALLEGATO_TIPO_3.equals(dettaglioAllegato.getIdTipoAllegato()) || Constants.MANUTENZIONE_SC.equals(dettaglioAllegato.getIdTipoAllegato())) {
				Map<BigDecimal, SigitVSk4ScDto> mapCompScDettDto = new HashMap<BigDecimal, SigitVSk4ScDto>();

				for (SigitVSk4ScDto sigitVSk4ScDto : listCompScDettDto) {

					inserisciRAllegatoCompSc(allegatoDto.getIdAllegato(), sigitVSk4ScDto);

					mapCompScDettDto.put(sigitVSk4ScDto.getProgressivo(), sigitVSk4ScDto);
				}

				if (Constants.ALLEGATO_TIPO_3.equals(dettaglioAllegato.getIdTipoAllegato())) {

					it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument mod4Import = MapDto.mapToImportMODIVDocument(xml);

					salvaAllegato3DaXml(mod4Import, dettaglioAllegato, allegatoDto, mapCompScDettDto);

				} else {

					it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionesc.data.MANUTENZIONEDocument manutenzioneScDocument = MapDto.mapToImportMANUTENZIONESCDocument(xml);

					salvaManutenzioneScDaXml(manutenzioneScDocument, allegatoDto);
				}
			} else if (Constants.ALLEGATO_TIPO_4.equals(dettaglioAllegato.getIdTipoAllegato()) || Constants.MANUTENZIONE_CG.equals(dettaglioAllegato.getIdTipoAllegato())) {
				Map<BigDecimal, SigitVSk4CgDto> mapCompCgDettDto = new HashMap<BigDecimal, SigitVSk4CgDto>();

				for (SigitVSk4CgDto sigitVSk4CgDto : listCompCgDettDto) {

					inserisciRAllegatoCompCg(allegatoDto.getIdAllegato(), sigitVSk4CgDto);

					mapCompCgDettDto.put(sigitVSk4CgDto.getProgressivo(), sigitVSk4CgDto);
				}

				if (Constants.ALLEGATO_TIPO_4.equals(dettaglioAllegato.getIdTipoAllegato())) {
					it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument mod5Import = MapDto.mapToImportMODVDocument(xml);

					salvaAllegato4DaXml(mod5Import, dettaglioAllegato, allegatoDto, mapCompCgDettDto);
				} else {

					it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionecg.data.MANUTENZIONEDocument manutenzioneCgDocument = MapDto.mapToImportMANUTENZIONECGDocument(xml);

					salvaManutenzioneCgDaXml(manutenzioneCgDocument, allegatoDto);
				}
			}

			dettaglioAllegato.setIdAllegato(ConvertUtil.convertToInteger(allegatoDto.getIdAllegato()));

			log.debug("allegato.getIdCom4Manut(): " + dettaglioAllegato.getIdCom4Manut());

			SigitRComp4ManutAllDto comp4Manut = null;

			for (String fkManut : dettaglioAllegato.getIdCom4Manut()) {
				log.debug("fkManut: " + fkManut);
				comp4Manut = new SigitRComp4ManutAllDto();
				comp4Manut.setIdRComp4Manut(ConvertUtil.convertToInteger(fkManut));
				comp4Manut.setIdAllegato(allegatoDto.getIdAllegato());
				// Devo inserire su sigit_r_comp4manut_all
				getSigitRComp4ManutAllDao().insert(comp4Manut);
			}

		} catch (SigitextException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new SigitextException(e.getMessage(), e);
		} finally {
			log.debug("[DbServiceImp::salvaAllegato] END");
		}
	}

	public SigitTRappTipo2Dto cercaTRappTipo2ById(BigDecimal idAllegato) throws SigitextException {
		SigitTRappTipo2Dto dto = null;
		log.debug("[DbServiceImp::cercaTRappTipo2ById] BEGIN");
		try {
			dto = getSigitTRappTipo2Dao().findByPrimaryKey(new SigitTRappTipo2Pk(idAllegato));
		} catch (SigitTRappTipo2DaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaTRappTipo2ById] END");
		}
		return dto;
	}

	public BigDecimal salvaCodiceBollino() throws SigitextException {
		log.debug("[DbServiceImp::salvaCodiceBollino] BEGIN");

		try {

			BigDecimal numBollino = getSigitExtDao().getSeqTNumeroBollino();

			// Ritorna quante righe quante le potenze che sono state acquistate
			SigitTCodiceBollDto codiceBollDto = new SigitTCodiceBollDto();

			codiceBollDto.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
			codiceBollDto.setNumeroBollino(numBollino);
			codiceBollDto.setDtInserimento(DateUtil.getSqlDataCorrente());

			getSigitTCodiceBollDao().insert(codiceBollDto);

			return numBollino;
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::salvaCodiceBollino] END");
		}

	}

	public BigDecimal inserisciAllegato(SigitTAllegatoDto dto) throws SigitextException {
		log.debug("[DbServiceImp::inserisciAllegato] BEGIN");
		try {
			return getSigitTAllegatoDao().insert(dto).getIdAllegato();
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::inserisciAllegato] END");
		}
	}

	public void aggiornaAllegato(SigitTAllegatoDto dto) throws SigitextException {
		log.debug("[DbServiceImp::aggiornaAllegato] BEGIN");
		try {
			getSigitTAllegatoDao().update(dto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_UPDATE_DB, e);
		} finally {
			log.debug("[DbServiceImp::aggiornaAllegato] END");
		}
	}

	public void inserisciRAllegatoCompGt(BigDecimal idAllegato, SigitVSk4GtDto dtoT) throws SigitextException {
		log.debug("[DbServiceImp::inserisciRAllegatoCompGt] BEGIN");
		try {
			SigitRAllegatoCompGtDto dtoR = new SigitRAllegatoCompGtDto();
			dtoR.setIdAllegato(idAllegato);
			dtoR.setIdTipoComponente(dtoT.getIdTipoComponente());
			dtoR.setProgressivo(dtoT.getProgressivo());
			dtoR.setCodiceImpianto(dtoT.getCodiceImpianto());
			dtoR.setDataInstall(dtoT.getDataInstall());

			getSigitRAllegatoCompGtDao().insert(dtoR);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::inserisciRAllegatoCompGt] END");
		}
	}

	public void inserisciRAllegatoCompGf(BigDecimal idAllegato, SigitVSk4GfDto dtoT) throws SigitextException {
		log.debug("[DbServiceImp::inserisciRAllegatoCompGf] BEGIN");
		try {
			SigitRAllegatoCompGfDto dtoR = new SigitRAllegatoCompGfDto();
			dtoR.setIdAllegato(idAllegato);
			dtoR.setIdTipoComponente(dtoT.getIdTipoComponente());
			dtoR.setProgressivo(dtoT.getProgressivo());
			dtoR.setCodiceImpianto(dtoT.getCodiceImpianto());
			dtoR.setDataInstall(dtoT.getDataInstall());

			getSigitRAllegatoCompGfDao().insert(dtoR);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::inserisciRAllegatoCompGf] END");
		}
	}

	public void inserisciRAllegatoCompSc(BigDecimal idAllegato, SigitVSk4ScDto dtoT) throws SigitextException {
		log.debug("[DbServiceImp::inserisciRAllegatoCompSc] BEGIN");
		try {
			SigitRAllegatoCompScDto dtoR = new SigitRAllegatoCompScDto();
			dtoR.setIdAllegato(idAllegato);
			dtoR.setIdTipoComponente(dtoT.getIdTipoComponente());
			dtoR.setProgressivo(dtoT.getProgressivo());
			dtoR.setCodiceImpianto(dtoT.getCodiceImpianto());
			dtoR.setDataInstall(dtoT.getDataInstall());

			getSigitRAllegatoCompScDao().insert(dtoR);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::inserisciRAllegatoCompSc] END");
		}
	}

	public void inserisciRAllegatoCompCg(BigDecimal idAllegato, SigitVSk4CgDto dtoT) throws SigitextException {
		log.debug("[DbServiceImp::inserisciRAllegatoCompCg] BEGIN");
		try {
			SigitRAllegatoCompCgDto dtoR = new SigitRAllegatoCompCgDto();
			dtoR.setIdAllegato(idAllegato);
			dtoR.setIdTipoComponente(dtoT.getIdTipoComponente());
			dtoR.setProgressivo(dtoT.getProgressivo());
			dtoR.setCodiceImpianto(dtoT.getCodiceImpianto());
			dtoR.setDataInstall(dtoT.getDataInstall());

			getSigitRAllegatoCompCgDao().insert(dtoR);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::inserisciRAllegatoCompCg] END");
		}
	}

	public void inserisciTDettTipo1(SigitTDettTipo1Dto sigitTDettTipo1Dto, BigDecimal idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::inserisciTDettTipo1] BEGIN");
		try {
			if (sigitTDettTipo1Dto == null) {
				sigitTDettTipo1Dto = new SigitTDettTipo1Dto();
			}
			sigitTDettTipo1Dto.setFkAllegato(idAllegato);

			getSigitTDettTipo1Dao().insert(sigitTDettTipo1Dto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::inserisciTDettTipo1] END");
		}

	}

	public void inserisciTDettTipo2(SigitTDettTipo2Dto sigitTDettTipo2Dto, BigDecimal idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::inserisciTDettTipo2] BEGIN");
		try {
			if (sigitTDettTipo2Dto == null) {
				sigitTDettTipo2Dto = new SigitTDettTipo2Dto();
			}

			sigitTDettTipo2Dto.setFkAllegato(idAllegato);

			getSigitTDettTipo2Dao().insert(sigitTDettTipo2Dto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::inserisciTDettTipo2] END");
		}
	}

	public void inserisciTDettTipo3(SigitTDettTipo3Dto sigitTDettTipo3Dto, BigDecimal idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::inserisciTDettTipo3] BEGIN");
		try {
			if (sigitTDettTipo3Dto == null) {
				sigitTDettTipo3Dto = new SigitTDettTipo3Dto();
			}

			sigitTDettTipo3Dto.setFkAllegato(idAllegato);

			getSigitTDettTipo3Dao().insert(sigitTDettTipo3Dto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::inserisciTDettTipo3] END");
		}

	}

	public void inserisciTDettTipo4(SigitTDettTipo4Dto sigitTDettTipo4Dto, BigDecimal idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::inserisciTDettTipo4] BEGIN");
		try {
			if (sigitTDettTipo4Dto == null) {
				sigitTDettTipo4Dto = new SigitTDettTipo4Dto();
			}

			sigitTDettTipo4Dto.setFkAllegato(idAllegato);

			getSigitTDettTipo4Dao().insert(sigitTDettTipo4Dto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::inserisciTDettTipo4] END");
		}
	}

	public void inserisciTRappTipo1(SigitTRappTipo1Dto sigitTRappTipo1Dto, BigDecimal idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::inserisciTRappTipo1] BEGIN");
		try {
			if (sigitTRappTipo1Dto == null) {
				sigitTRappTipo1Dto = new SigitTRappTipo1Dto();
			}
			sigitTRappTipo1Dto.setIdAllegato(idAllegato);

			getSigitTRappTipo1Dao().insert(sigitTRappTipo1Dto);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::inserisciTRappTipo1] END");
		}
	}

	public void inserisciTRappTipo2(SigitTRappTipo2Dto sigitTRappTipo2Dto, BigDecimal idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::inserisciTRappTipo2] BEGIN");
		try {
			if (sigitTRappTipo2Dto == null) {
				sigitTRappTipo2Dto = new SigitTRappTipo2Dto();
			}
			sigitTRappTipo2Dto.setIdAllegato(idAllegato);

			getSigitTRappTipo2Dao().insert(sigitTRappTipo2Dto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::inserisciTRappTipo2] END");
		}

	}

	public void inserisciTRappTipo3(SigitTRappTipo3Dto sigitTRappTipo3Dto, BigDecimal idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::inserisciTRappTipo3] BEGIN");
		try {
			if (sigitTRappTipo3Dto == null) {
				sigitTRappTipo3Dto = new SigitTRappTipo3Dto();
			}
			sigitTRappTipo3Dto.setIdAllegato(idAllegato);

			getSigitTRappTipo3Dao().insert(sigitTRappTipo3Dto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::inserisciTRappTipo3] END");
		}
	}

	public void inserisciTRappTipo4(SigitTRappTipo4Dto sigitTRappTipo4Dto, BigDecimal idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::inserisciTRappTipo4] BEGIN");
		try {
			if (sigitTRappTipo4Dto == null) {
				sigitTRappTipo4Dto = new SigitTRappTipo4Dto();
			}
			sigitTRappTipo4Dto.setIdAllegato(idAllegato);

			getSigitTRappTipo4Dao().insert(sigitTRappTipo4Dto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::inserisciTRappTipo4] END");
		}
	}

	public void inserisciTConsumoTipo1B(SigitTConsumoTipo1BDto sigitTConsumoTipo1BDto, BigDecimal idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::inserisciTConsumoTipo1B] BEGIN");
		try {
			if (sigitTConsumoTipo1BDto == null) {
				sigitTConsumoTipo1BDto = new SigitTConsumoTipo1BDto();
			}
			sigitTConsumoTipo1BDto.setFkAllegato(idAllegato);

			getSigitTConsumoTipo1BDao().insert(sigitTConsumoTipo1BDto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::inserisciTConsumoTipo1B] END");
		}

	}

	public void salvaAllegato1DaXml(it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument mod1Import, DettaglioAllegato dettaglioAllegato, SigitTAllegatoDto allegatoDto, Map<BigDecimal, SigitVSk4GtDto> mapCompGtDettDto)
			throws SigitextException {
		log.debug("[DbServiceImp::salvaAllegato1DaXml] START");

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = mod1Import.getMODII().getRichiesta().getDatiAllegato()
				.getDatiIdentificativi();

		allegatoDto.setAPotenzaTermicaNominaleMax(datiIdentificativi.getAAPotenzaTermicaNomTotMax());

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = mod1Import.getMODII().getRichiesta().getDatiAllegato()
				.getDocumentazioneTecnica();

		allegatoDto.setBFlgDichiarConform(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagDichiarazConf()));
		allegatoDto.setBFlgLibrettoUso(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagManutGen()));
		allegatoDto.setBFlgLibCompl(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoComp()));
		allegatoDto.setBFlgLibImp(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoImp()));

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.CheckListDocument.CheckList importCheckList = mod1Import.getMODII().getRichiesta().getDatiAllegato().getCheckList();

		if (GenericUtil.isNotNullOrEmpty(importCheckList.getAFOsservazioni())) {
			allegatoDto.setFOsservazioni(importCheckList.getAFOsservazioni());
		}
		if (GenericUtil.isNotNullOrEmpty(importCheckList.getAFRaccomandazioni())) {
			allegatoDto.setFRaccomandazioni(importCheckList.getAFRaccomandazioni());
		}
		if (GenericUtil.isNotNullOrEmpty(importCheckList.getAFPrescrizioni())) {
			allegatoDto.setFPrescrizioni(importCheckList.getAFPrescrizioni());
		}

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiTecnicoDocument.DatiTecnico datiTecnico = mod1Import.getMODII().getRichiesta().getDatiAllegato().getDatiTecnico();

		allegatoDto.setFFlgPuoFunzionare(ConvertUtil.convertToBigDecimal(datiTecnico.getAFFlagFunzImp()));

		allegatoDto.setFInterventoEntro(ConvertUtil.convertToDate(datiTecnico.getAFDataIntervento()));

		allegatoDto.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
		allegatoDto.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
		allegatoDto.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));

		if (GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())) {
			allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
			allegatoDto.setFFirmaTecnico(datiTecnico.getAFFirmaTecnico());
		} else {
			allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
		}
		log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): " + datiTecnico.getAFFirmaResp());
		if (GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())) {
			allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
			allegatoDto.setFFirmaResponsabile(datiTecnico.getAFFirmaResp());
		} else {
			allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
		}

		aggiornaAllegato(allegatoDto);

		BigDecimal idAllegato = allegatoDto.getIdAllegato();

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.ControlloImpiantoDocument.ControlloImpianto importCi = mod1Import.getMODII().getRichiesta().getDatiAllegato().getControlloImpianto();

		SigitTRappTipo1Dto rapportoTipo1Dto = new SigitTRappTipo1Dto();

		//sezione D.controllo dell'impianto
		rapportoTipo1Dto.setDFlgLocaleIntIdoneo(new BigDecimal(importCi.getADFlagInterno()));
		rapportoTipo1Dto.setDFlgGenExtIdoneo(new BigDecimal(importCi.getADFlagEsterno()));
		rapportoTipo1Dto.setDFlgApertureLibere(new BigDecimal(importCi.getADFlagAperture()));

		rapportoTipo1Dto.setDFlgApertureAdeg(new BigDecimal(importCi.getADFlagDimensioni()));
		rapportoTipo1Dto.setDFlgScaricoIdoneo(new BigDecimal(importCi.getADFlagCanaleFumo()));
		rapportoTipo1Dto.setDFlgTempAmbFunz(new BigDecimal(importCi.getADFlagSistRegolaz()));
		rapportoTipo1Dto.setDFlgAssenzaPerdComb(new BigDecimal(importCi.getADFlagPerdite()));
		rapportoTipo1Dto.setDFlgIdoTenImpInt(new BigDecimal(importCi.getADFlagTenuta()));

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod1Import.getMODII().getRichiesta().getDatiAllegato().getTrattamentoAcqua();

		rapportoTipo1Dto.setCFlgTrattClimaNonRich(ConvertUtil.convertToBigDecimal(impTa.getACFlagTrattH2ONR()));
		rapportoTipo1Dto.setCFlgTrattAcsNonRichiesto(ConvertUtil.convertToBigDecimal(impTa.getACFlagTrattAcsNR()));

		for (it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowAllegatoIIDocument.RowAllegatoII all : mod1Import.getMODII().getRichiesta().getDatiAllegato().getAllegatoII()
				.getRowAllegatoIIList()) {

			BigInteger progressivo = all.getAENumGT();

			SigitVSk4GtDto compGt = mapCompGtDettDto.get(ConvertUtil.convertToBigDecimal(progressivo));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica importCve = all.getControlloVerificaEnergetica();

			for (it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowFumiDocument.RowFumi rowFumiImport : all.getTabFumi().getRowFumiList()) {

				SigitTDettTipo1Dto sigitTDettTipo1Dto = new SigitTDettTipo1Dto();

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
				sigitTDettTipo1Dto.setFkAllegato(idAllegato);
				sigitTDettTipo1Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
				sigitTDettTipo1Dto.setUtenteUltMod(dettaglioAllegato.getCodFiscaleUtenteLoggato());
				sigitTDettTipo1Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_GT);

				sigitTDettTipo1Dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
				sigitTDettTipo1Dto.setDataInstall(compGt.getDataInstall());

				sigitTDettTipo1Dto.setETempFumiC(rowFumiImport.getAETempFumi());
				sigitTDettTipo1Dto.setETempAriaC(rowFumiImport.getAETempAria());
				sigitTDettTipo1Dto.setEO2Perc(rowFumiImport.getAEO2());
				sigitTDettTipo1Dto.setECo2Perc(rowFumiImport.getAECO2());
				sigitTDettTipo1Dto.setEBacharachMin(rowFumiImport.getAEBacharach1());
				sigitTDettTipo1Dto.setEBacharachMed(rowFumiImport.getAEBacharach2());
				sigitTDettTipo1Dto.setEBacharachMax(rowFumiImport.getAEBacharach3());
				sigitTDettTipo1Dto.setECoCorrettoPpm(rowFumiImport.getAECOcorretto());
				sigitTDettTipo1Dto.setERendCombPerc(rowFumiImport.getAERendimCombu());
				sigitTDettTipo1Dto.setERendMinLeggePerc(rowFumiImport.getAERendimentoLegge());
				sigitTDettTipo1Dto.setENoxMgKwh(rowFumiImport.getAENox());
				sigitTDettTipo1Dto.setENModuloTermico(ConvertUtil.convertToInteger(rowFumiImport.getAEModuloTermico()));
				sigitTDettTipo1Dto.setL111PortataCombustibileUm(rowFumiImport.getAEPortataCombu().toString());
				sigitTDettTipo1Dto.setL111PortataCombustibile(rowFumiImport.getAEValorePortata());
				sigitTDettTipo1Dto.setL111CoNoAriaPpm(rowFumiImport.getAECOfumiSecchi());
				sigitTDettTipo1Dto.setL111FlgRispettaBacharach(ConvertUtil.convertToBigDecimal(rowFumiImport.getAERispettoIndBacharach()));
				sigitTDettTipo1Dto.setL111FlgRendMagRendMin(ConvertUtil.convertToBigDecimal(rowFumiImport.getAEMinimo()));

				inserisciTDettTipo1(sigitTDettTipo1Dto, idAllegato);
			}

		}

		rapportoTipo1Dto.setFFlgAdozioneValvoleTerm(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagValvole()));
		rapportoTipo1Dto.setFFlgIsolamenteRete(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagIsolamento()));
		rapportoTipo1Dto.setFFlgAdozSistTrattamH2o(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagSistTrattACS()));
		rapportoTipo1Dto.setFFlgSostituzSistRegolaz(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagSistRegolaz()));

		inserisciTRappTipo1(rapportoTipo1Dto, idAllegato);

		log.debug("[DbServiceImp::salvaAllegato1DaXml] END");
	}

	public void salvaAllegato1BDaXml(it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.MODIIBDocument mod1BImport, DettaglioAllegato dettaglioAllegato, SigitTAllegatoDto allegatoDto, Map<BigDecimal, SigitVSk4GtDto> mapCompGtDettDto)
			throws SigitextException {
		log.debug("[DbServiceImp::salvaAllegato1BDaXml] START");

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = mod1BImport.getMODIIB().getRichiesta().getDatiAllegato()
				.getDatiIdentificativi();

		allegatoDto.setAPotenzaTermicaNominaleMax(datiIdentificativi.getAAPotenzaTermicaNomTotMax());

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = mod1BImport.getMODIIB().getRichiesta().getDatiAllegato()
				.getDocumentazioneTecnica();

		allegatoDto.setBFlgDichiarConform(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagDichiarazConf()));
		allegatoDto.setBFlgLibrettoUso(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagManutGen()));
		allegatoDto.setBFlgLibCompl(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoComp()));
		allegatoDto.setBFlgLibImp(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoImp()));

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.CheckListDocument.CheckList importCheckList = mod1BImport.getMODIIB().getRichiesta().getDatiAllegato().getCheckList();

		if (GenericUtil.isNotNullOrEmpty(importCheckList.getAFOsservazioni())) {
			allegatoDto.setFOsservazioni(importCheckList.getAFOsservazioni());
		}
		if (GenericUtil.isNotNullOrEmpty(importCheckList.getAFRaccomandazioni())) {
			allegatoDto.setFRaccomandazioni(importCheckList.getAFRaccomandazioni());
		}
		if (GenericUtil.isNotNullOrEmpty(importCheckList.getAFPrescrizioni())) {
			allegatoDto.setFPrescrizioni(importCheckList.getAFPrescrizioni());
		}

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.DatiTecnicoDocument.DatiTecnico datiTecnico = mod1BImport.getMODIIB().getRichiesta().getDatiAllegato().getDatiTecnico();

		allegatoDto.setFFlgPuoFunzionare(ConvertUtil.convertToBigDecimal(datiTecnico.getAFFlagFunzImp()));

		allegatoDto.setFInterventoEntro(ConvertUtil.convertToDate(datiTecnico.getAFDataIntervento()));

		allegatoDto.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
		allegatoDto.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
		allegatoDto.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));

		if (GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())) {
			allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
			allegatoDto.setFFirmaTecnico(datiTecnico.getAFFirmaTecnico());
		} else {
			allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
		}
		log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): " + datiTecnico.getAFFirmaResp());
		if (GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())) {
			allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
			allegatoDto.setFFirmaResponsabile(datiTecnico.getAFFirmaResp());
		} else {
			allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
		}

		aggiornaAllegato(allegatoDto);

		BigDecimal idAllegato = allegatoDto.getIdAllegato();

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.ControlloImpiantoDocument.ControlloImpianto importCi = mod1BImport.getMODIIB().getRichiesta().getDatiAllegato().getControlloImpianto();

		SigitTRappTipo1Dto rapportoTipo1Dto = new SigitTRappTipo1Dto();

		//sezione D.controllo dell'impianto
		rapportoTipo1Dto.setDFlgLocaleIntIdoneo(new BigDecimal(importCi.getADFlagInterno()));
		rapportoTipo1Dto.setDFlgGenExtIdoneo(new BigDecimal(importCi.getADFlagEsterno()));
		rapportoTipo1Dto.setDFlgApertureLibere(new BigDecimal(importCi.getADFlagAperture()));

		rapportoTipo1Dto.setDFlgApertureAdeg(new BigDecimal(importCi.getADFlagDimensioni()));
		rapportoTipo1Dto.setDFlgScaricoIdoneo(new BigDecimal(importCi.getADFlagCanaleFumo()));
		rapportoTipo1Dto.setDFlgTempAmbFunz(new BigDecimal(importCi.getADFlagSistRegolaz()));
		rapportoTipo1Dto.setDFlgIdoTenImpInt(new BigDecimal(importCi.getADFlagTenuta()));
		rapportoTipo1Dto.setDFlgAssenzaPerdComb(new BigDecimal(importCi.getADFlagPuliziaCamino()));

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod1BImport.getMODIIB().getRichiesta().getDatiAllegato().getTrattamentoAcqua();

		rapportoTipo1Dto.setCFlgTrattClimaNonRich(ConvertUtil.convertToBigDecimal(impTa.getACFlagTrattH2ONR()));
		rapportoTipo1Dto.setCFlgTrattAcsNonRichiesto(ConvertUtil.convertToBigDecimal(impTa.getACFlagTrattAcsNR()));

		List<RowAcquaReintegroDocument.RowAcquaReintegro> rowAcquaReintegroList = impTa.getACAcquaReintegro().getRowAcquaReintegroList();
		List<SigitTConsumoTipo1BDto> consumoCombustibileDtoList = new ArrayList<>();
		for (it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.RowAllegatoIIBDocument.RowAllegatoIIB all : mod1BImport.getMODIIB().getRichiesta().getDatiAllegato().getAllegatoIIB()
				.getRowAllegatoIIBList()) {

			BigInteger progressivo = all.getAENumGT();

			SigitVSk4GtDto compGt = mapCompGtDettDto.get(ConvertUtil.convertToBigDecimal(progressivo));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica importCve = all.getControlloVerificaEnergetica();

			rapportoTipo1Dto.setE1bFlgCaldaia(ConvertUtil.convertToBigDecimal(importCve.getAEFlagCaldaia()));
			rapportoTipo1Dto.setE1bFlgStufa(ConvertUtil.convertToBigDecimal(importCve.getAEFlagStufa()));
			rapportoTipo1Dto.setE1bFlgStufaAccumulo(ConvertUtil.convertToBigDecimal(importCve.getAEFlagStufaAccumulo()));
			rapportoTipo1Dto.setE1bFlgTermocucina(ConvertUtil.convertToBigDecimal(importCve.getAEFlagTermocucina()));
			rapportoTipo1Dto.setE1bFlgCaminettoAperto(ConvertUtil.convertToBigDecimal(importCve.getAEFlagCaminoAperto()));
			rapportoTipo1Dto.setE1bFlgCaminettoChiuso(ConvertUtil.convertToBigDecimal(importCve.getAEFlagCaminoChiuso()));
			rapportoTipo1Dto.setE1bFlgInsertoCaminetto(ConvertUtil.convertToBigDecimal(importCve.getAEFlagInsertoCamino()));
			rapportoTipo1Dto.setE1bFlgStufaAssemblata(ConvertUtil.convertToBigDecimal(importCve.getAEFlagStufaAssemblata()));
			rapportoTipo1Dto.setE1bFlgStufaPellet(ConvertUtil.convertToBigDecimal(importCve.getAEFlagStufaPellet()));
			rapportoTipo1Dto.setIdStelle(ConvertUtil.convertToBigDecimal(MapDto.mapStellaXmlToStellaCit(importCve.getAEStelle())));
			rapportoTipo1Dto.setIdTipo1b(ConvertUtil.convertToBigDecimal(importCve.getAEApparecchiatura()));
			rapportoTipo1Dto.setE1bFlgMarcaturaCe(ConvertUtil.convertToBigDecimal(importCve.getAEFlagMarcaturaCEE()));
			rapportoTipo1Dto.setE1bFlgPlaccaCamino(ConvertUtil.convertToBigDecimal(importCve.getAEFlagPlaccaCamino()));
			rapportoTipo1Dto.setIdAriaComburente(ConvertUtil.convertToBigDecimal(importCve.getAEAriaComburente()));
			rapportoTipo1Dto.setIdControlloAria(ConvertUtil.convertToBigDecimal(importCve.getAEControlloAria()));
			rapportoTipo1Dto.setIdTipoCaricCombu(ConvertUtil.convertToBigDecimal(importCve.getAECarcaCombu()));

			for (it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.RowCombustibileDocument.RowCombustibile rowCombustibileImport : all.getTabCombustibile().getRowCombustibileList()) {
				SigitTConsumoTipo1BDto consumoTipo1BCombustibileDto = new SigitTConsumoTipo1BDto();
				consumoTipo1BCombustibileDto.setEsercizio(ConvertUtil.convertToBigDecimal(rowCombustibileImport.getAEEsercizio()));
				consumoTipo1BCombustibileDto.setConsumo(ConvertUtil.convertToBigDecimal(rowCombustibileImport.getAEConsumoAnnuo()));
				consumoTipo1BCombustibileDto.setIdUnitaMisura(ConvertUtil.convertToString(rowCombustibileImport.getAEUnitaMisura()));
				consumoTipo1BCombustibileDto.setIdTipoConsumo1b(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_CONSUMO_1B_CONSUMO_BIOMASSA));
				consumoCombustibileDtoList.add(consumoTipo1BCombustibileDto);
			}

			for (it.csi.sigit.sigitwebn.xml.importmassivo.allegato2B.data.RowFumiDocument.RowFumi rowFumiImport : all.getTabFumi().getRowFumiList()) {

				SigitTDettTipo1Dto sigitTDettTipo1Dto = new SigitTDettTipo1Dto();

				sigitTDettTipo1Dto.setEFlgClimaInverno(ConvertUtil.convertToBigDecimal(importCve.getAEFlagClimatizInv()));
				sigitTDettTipo1Dto.setEFlgProduzAcs(ConvertUtil.convertToBigDecimal(importCve.getAEFlagProduzACS()));
				sigitTDettTipo1Dto.setE1bFlgCucina(ConvertUtil.convertToBigDecimal(importCve.getAEFlagCucina()));

				sigitTDettTipo1Dto.setEFlgDisposComando(ConvertUtil.convertToBigDecimal(importCve.getAEFlagDispComando()));
				sigitTDettTipo1Dto.setEFlgDisposSicurezza(ConvertUtil.convertToBigDecimal(importCve.getAEFlagDispSicu()));

				sigitTDettTipo1Dto.setEFlgValvolaSicurezza(ConvertUtil.convertToBigDecimal(importCve.getAEFlagValvSicu()));
				sigitTDettTipo1Dto.setEFlgScambiatoreFumi(ConvertUtil.convertToBigDecimal(importCve.getAEFlagScambiatore()));
				sigitTDettTipo1Dto.setEFlgRiflusso(ConvertUtil.convertToBigDecimal(importCve.getAEFlagRiflusso()));
				sigitTDettTipo1Dto.setEFlgUni103891(ConvertUtil.convertToBigDecimal(importCve.getAEFlagRisultati()));
				sigitTDettTipo1Dto.setE1bFlgUni103892(ConvertUtil.convertToBigDecimal(importCve.getAEFlagRisultati()));

				sigitTDettTipo1Dto.setEPotTermFocolKw(importCve.getAEPotenzaFocolare());
				sigitTDettTipo1Dto.setEFlgEvacuFumi(importCve.getAEFlagEvacFumi().toString());

				sigitTDettTipo1Dto.setL111AltroRiferimento(importCve.getAEAltroRifNormativo());
				sigitTDettTipo1Dto.setEDeprCanaleFumoPa(importCve.getAEDepressCanaleFumo());

				sigitTDettTipo1Dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getCodiceImpianto()));
				sigitTDettTipo1Dto.setFkAllegato(idAllegato);
				sigitTDettTipo1Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
				sigitTDettTipo1Dto.setUtenteUltMod(dettaglioAllegato.getCodFiscaleUtenteLoggato());
				sigitTDettTipo1Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_GT);

				sigitTDettTipo1Dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
				sigitTDettTipo1Dto.setDataInstall(compGt.getDataInstall());

				sigitTDettTipo1Dto.setETempFumiC(rowFumiImport.getAETempFumi());
				sigitTDettTipo1Dto.setETempAriaC(rowFumiImport.getAETempAria());
				sigitTDettTipo1Dto.setEO2Perc(rowFumiImport.getAEO2());
				sigitTDettTipo1Dto.setECo2Perc(rowFumiImport.getAECO2());
				sigitTDettTipo1Dto.setE1bParticolatoMgAlM3(rowFumiImport.getAEParticolato());
				sigitTDettTipo1Dto.setECoCorrettoPpm(rowFumiImport.getAECOcorretto());
				sigitTDettTipo1Dto.setERendCombPerc(rowFumiImport.getAERendimCombu());
				sigitTDettTipo1Dto.setERendMinLeggePerc(rowFumiImport.getAERendimentoLegge());
				UM.Enum um = rowFumiImport.getAENoxUM();
				if (um.equals(UM.MG_NM_3)) {
					sigitTDettTipo1Dto.setENoxMgNm3(rowFumiImport.getAENox());
				} else {
					sigitTDettTipo1Dto.setENoxMgKwh(rowFumiImport.getAENox());
				}
				sigitTDettTipo1Dto.setENModuloTermico(ConvertUtil.convertToInteger(rowFumiImport.getAEModuloTermico()));

				inserisciTDettTipo1(sigitTDettTipo1Dto, idAllegato);
			}

		}

		rapportoTipo1Dto.setFFlgAdozioneValvoleTerm(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagValvole()));
		rapportoTipo1Dto.setFFlgIsolamenteRete(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagIsolamento()));
		rapportoTipo1Dto.setFFlgAdozSistTrattamH2o(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagSistTrattACS()));
		rapportoTipo1Dto.setFFlgSostituzSistRegolaz(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagSistRegolaz()));

		inserisciTRappTipo1(rapportoTipo1Dto, idAllegato);

		for (RowAcquaReintegroDocument.RowAcquaReintegro rowAcquaReintegro : rowAcquaReintegroList) {
			SigitTConsumoTipo1BDto consumoTipo1BAcquaReintegroDto = new SigitTConsumoTipo1BDto();
			consumoTipo1BAcquaReintegroDto.setEsercizio(ConvertUtil.convertToBigDecimal(rowAcquaReintegro.getACEsercizio()));
			consumoTipo1BAcquaReintegroDto.setLetturaIniziale(ConvertUtil.convertToBigDecimal(rowAcquaReintegro.getACLetturaIniziale()));
			consumoTipo1BAcquaReintegroDto.setLetturaFinale(ConvertUtil.convertToBigDecimal(rowAcquaReintegro.getACLetturaFinale()));
			consumoTipo1BAcquaReintegroDto.setConsumo(ConvertUtil.convertToBigDecimal(rowAcquaReintegro.getACConsumoTotale()));
			consumoTipo1BAcquaReintegroDto.setIdUnitaMisura(ConvertUtil.convertToString(rowAcquaReintegro.getACUnitaMisura()));
			consumoTipo1BAcquaReintegroDto.setIdTipoConsumo1b(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_CONSUMO_1B_ACQUA_REINTEGRO));

			inserisciTConsumoTipo1B(consumoTipo1BAcquaReintegroDto, idAllegato);
		}

		for (SigitTConsumoTipo1BDto consumoCombu : consumoCombustibileDtoList) {
			inserisciTConsumoTipo1B(consumoCombu, idAllegato);
		}

		log.debug("[DbServiceImp::salvaAllegato1BDaXml] END");
	}

	public void salvaAllegato2DaXml(it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument mod2Import, DettaglioAllegato dettaglioAllegato, SigitTAllegatoDto allegatoDto, Map<BigDecimal, SigitVSk4GfDto> mapCompGfDettDto)
			throws SigitextException {
		log.debug("[DbServiceImp::salvaAllegato2DaXml] START");

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = mod2Import.getMODIII().getRichiesta().getDatiAllegato()
				.getDatiIdentificativi();

		allegatoDto.setAPotenzaTermicaNominaleMax(datiIdentificativi.getAAPotenzaTermicaNomTotMax());

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = mod2Import.getMODIII().getRichiesta().getDatiAllegato()
				.getDocumentazioneTecnica();

		allegatoDto.setBFlgDichiarConform(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagDichiarazConf()));
		allegatoDto.setBFlgLibrettoUso(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagManutGen()));
		allegatoDto.setBFlgLibCompl(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoComp()));
		allegatoDto.setBFlgLibImp(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoImp()));

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.CheckListDocument.CheckList importCheckList = mod2Import.getMODIII().getRichiesta().getDatiAllegato().getCheckList();

		if (GenericUtil.isNotNullOrEmpty(importCheckList.getAFOsservazioni())) {
			allegatoDto.setFOsservazioni(importCheckList.getAFOsservazioni());
		}
		if (GenericUtil.isNotNullOrEmpty(importCheckList.getAFRaccomandazioni())) {
			allegatoDto.setFRaccomandazioni(importCheckList.getAFRaccomandazioni());
		}
		if (GenericUtil.isNotNullOrEmpty(importCheckList.getAFPrescrizioni())) {
			allegatoDto.setFPrescrizioni(importCheckList.getAFPrescrizioni());
		}

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiTecnicoDocument.DatiTecnico datiTecnico = mod2Import.getMODIII().getRichiesta().getDatiAllegato().getDatiTecnico();

		allegatoDto.setFFlgPuoFunzionare(ConvertUtil.convertToBigDecimal(datiTecnico.getAFFlagFunzImp()));

		allegatoDto.setFInterventoEntro(ConvertUtil.convertToDate(datiTecnico.getAFDataIntervento()));

		allegatoDto.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
		allegatoDto.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
		allegatoDto.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));

		if (GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())) {
			allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
			allegatoDto.setFFirmaTecnico(datiTecnico.getAFFirmaTecnico());
		} else {
			allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
		}
		log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): " + datiTecnico.getAFFirmaResp());
		if (GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())) {
			allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
			allegatoDto.setFFirmaResponsabile(datiTecnico.getAFFirmaResp());
		} else {
			allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
		}

		aggiornaAllegato(allegatoDto);

		BigDecimal idAllegato = allegatoDto.getIdAllegato();

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.ControlloImpiantoDocument.ControlloImpianto importCi = mod2Import.getMODIII().getRichiesta().getDatiAllegato().getControlloImpianto();

		SigitTRappTipo2Dto rapportoTipo2 = new SigitTRappTipo2Dto();

		//sezione D.controllo dell'impianto
		rapportoTipo2.setDFlgLocaleIdoneo(new BigDecimal(importCi.getADFlagLocaleIdoneo()));
		rapportoTipo2.setDFlgApertureAdeg(new BigDecimal(importCi.getADFlagDimensioni()));
		rapportoTipo2.setDFlgApertureLibere(new BigDecimal(importCi.getADFlagAperture()));

		rapportoTipo2.setDFlgLineaElettIdonea(new BigDecimal(importCi.getADFlagLineeIdonee()));
		rapportoTipo2.setDFlgCoibIdonea(new BigDecimal(importCi.getADFlagCoibenIdonee()));

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod2Import.getMODIII().getRichiesta().getDatiAllegato().getTrattamentoAcqua();

		rapportoTipo2.setCFlgTrattClimaNonRichiest(ConvertUtil.convertToBigDecimal(impTa.getACFlagTrattH2ONR()));

		for (it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII all : mod2Import.getMODIII().getRichiesta().getDatiAllegato().getAllegatoIII()
				.getRowAllegatoIIIList()) {

			log.debug("Entro nel dettaglio RowAllegatoIII");

			BigDecimal progressivo = ConvertUtil.convertToBigDecimal(all.getAENumGF());

			SigitVSk4GfDto compGf = mapCompGfDettDto.get(progressivo);

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica importCve = all.getControlloVerificaEnergetica();

			for (it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowFumiDocument.RowFumi rowFumiImport : all.getTabFumi().getRowFumiList()) {

				SigitTDettTipo2Dto sigitTDettTipo2Dto = new SigitTDettTipo2Dto();

				sigitTDettTipo2Dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getCodiceImpianto()));
				sigitTDettTipo2Dto.setFkAllegato(idAllegato);
				sigitTDettTipo2Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
				sigitTDettTipo2Dto.setUtenteUltMod(dettaglioAllegato.getCodFiscaleUtenteLoggato());
				sigitTDettTipo2Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_GF);
				sigitTDettTipo2Dto.setProgressivo(progressivo);
				sigitTDettTipo2Dto.setDataInstall(compGf.getDataInstall());

				sigitTDettTipo2Dto.setEFlgModProva(importCve.getAEFlagModalita().toString());
				sigitTDettTipo2Dto.setEFlgPerditaGas(ConvertUtil.convertToBigDecimal(importCve.getAEFlagPerdite()));
				sigitTDettTipo2Dto.setEFlgLeakDetector(ConvertUtil.convertToBigDecimal(importCve.getAEFlagRilevFugheDiretta()));
				sigitTDettTipo2Dto.setEFlgParamTermodinam(ConvertUtil.convertToBigDecimal(importCve.getAEFlagRilevFugheInDiretta()));
				sigitTDettTipo2Dto.setEFlgIncrostazioni(ConvertUtil.convertToBigDecimal(importCve.getAEFlagScambPuliti()));

				sigitTDettTipo2Dto.setENCircuito(ConvertUtil.convertToString(rowFumiImport.getAENumCircuito()));
				sigitTDettTipo2Dto.setETSurriscC(rowFumiImport.getAESurrisc());
				sigitTDettTipo2Dto.setETSottorafC(rowFumiImport.getAESottoRaffr());
				sigitTDettTipo2Dto.setETCondensazioneC(rowFumiImport.getAECondens());
				sigitTDettTipo2Dto.setETEvaporazioneC(rowFumiImport.getAEEvaporaz());

				sigitTDettTipo2Dto.setETInExtC(rowFumiImport.getAEIngLatoEst());
				sigitTDettTipo2Dto.setETOutExtC(rowFumiImport.getAEUscLatoEst());

				sigitTDettTipo2Dto.setETInUtenzeC(rowFumiImport.getAEIngLatoUtenze());
				sigitTDettTipo2Dto.setETOutUtenzeC(rowFumiImport.getAEUscLatoUtenze());

				sigitTDettTipo2Dto.setL112TorreTOutFluido(rowFumiImport.getAETuscFluido());
				sigitTDettTipo2Dto.setL112TorreTBulboUmido(rowFumiImport.getAETbulboUmido());
				sigitTDettTipo2Dto.setL112ScambiatoreTInExt(rowFumiImport.getAETingFluidoSorg());
				sigitTDettTipo2Dto.setL112ScambiatoreTOutExt(rowFumiImport.getAETuscFluidoSorg());
				sigitTDettTipo2Dto.setL112ScambiatTInMacchina(rowFumiImport.getAETingFluidoMacc());
				sigitTDettTipo2Dto.setL112ScambiatTOutMacchina(rowFumiImport.getAETuscFluidoMacc());
				sigitTDettTipo2Dto.setL112PotenzaAssorbitaKw(rowFumiImport.getAEPotenzaAss());

				sigitTDettTipo2Dto.setL112FlgPuliziaFiltri(ConvertUtil.convertToBigDecimal(rowFumiImport.getAEFiltriPuliti()));
				sigitTDettTipo2Dto.setL112FlgVerificaSuperata(ConvertUtil.convertToBigDecimal(rowFumiImport.getAEVerifica()));

				// Beppe - correzione Jira SIGIT-597
				if (GenericUtil.isNotNullOrEmpty(rowFumiImport.getAEDataRipristino())) {
					sigitTDettTipo2Dto.setL112DataRipristino(DateUtil.getSqlDate(rowFumiImport.getAEDataRipristino()));
				}

				inserisciTDettTipo2(sigitTDettTipo2Dto, idAllegato);
			}

		}

		rapportoTipo2.setFFlgSostituzGeneratori(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagSostGen1()));
		rapportoTipo2.setFFlgSostituzSistemiReg(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagSostGen2()));
		rapportoTipo2.setFFlgIsolDistribuzH2o(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagIsolamentoRete()));
		rapportoTipo2.setFFlgIsolDistribuzAria(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagIsolamentoCanali()));

		inserisciTRappTipo2(rapportoTipo2, idAllegato);

		log.debug("[DbServiceImp::salvaAllegato2DaXml] END");
	}

	public void salvaAllegato3DaXml(it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument mod3Import, DettaglioAllegato dettaglioAllegato, SigitTAllegatoDto allegatoDto, Map<BigDecimal, SigitVSk4ScDto> mapCompScDettDto)
			throws SigitextException {
		log.debug("[DbServiceImp::salvaAllegato3DaXml] START");

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = mod3Import.getMODIV().getRichiesta().getDatiAllegato()
				.getDatiIdentificativi();

		allegatoDto.setAPotenzaTermicaNominaleMax(datiIdentificativi.getAAPotenzaTermicaNomTotMax());

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = mod3Import.getMODIV().getRichiesta().getDatiAllegato()
				.getDocumentazioneTecnica();

		allegatoDto.setBFlgDichiarConform(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagDichiarazConf()));
		allegatoDto.setBFlgLibrettoUso(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagManutGen()));
		allegatoDto.setBFlgLibCompl(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoComp()));
		allegatoDto.setBFlgLibImp(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoImp()));

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.CheckListDocument.CheckList importCheckList = mod3Import.getMODIV().getRichiesta().getDatiAllegato().getCheckList();

		if (GenericUtil.isNotNullOrEmpty(importCheckList.getAFOsservazioni())) {
			allegatoDto.setFOsservazioni(importCheckList.getAFOsservazioni());
		}
		if (GenericUtil.isNotNullOrEmpty(importCheckList.getAFRaccomandazioni())) {
			allegatoDto.setFRaccomandazioni(importCheckList.getAFRaccomandazioni());
		}
		if (GenericUtil.isNotNullOrEmpty(importCheckList.getAFPrescrizioni())) {
			allegatoDto.setFPrescrizioni(importCheckList.getAFPrescrizioni());
		}

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiTecnicoDocument.DatiTecnico datiTecnico = mod3Import.getMODIV().getRichiesta().getDatiAllegato().getDatiTecnico();

		allegatoDto.setFFlgPuoFunzionare(ConvertUtil.convertToBigDecimal(datiTecnico.getAFFlagFunzImp()));

		allegatoDto.setFInterventoEntro(ConvertUtil.convertToDate(datiTecnico.getAFDataIntervento()));

		allegatoDto.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
		allegatoDto.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
		allegatoDto.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));

		if (GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())) {
			allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
			allegatoDto.setFFirmaTecnico(datiTecnico.getAFFirmaTecnico());
		} else {
			allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
		}
		log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): " + datiTecnico.getAFFirmaResp());
		if (GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())) {
			allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
			allegatoDto.setFFirmaResponsabile(datiTecnico.getAFFirmaResp());
		} else {
			allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
		}

		aggiornaAllegato(allegatoDto);

		BigDecimal idAllegato = allegatoDto.getIdAllegato();

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.ControlloImpiantoDocument.ControlloImpianto importCi = mod3Import.getMODIV().getRichiesta().getDatiAllegato().getControlloImpianto();

		SigitTRappTipo3Dto rapportoTipo3 = new SigitTRappTipo3Dto();

		//sezione D.controllo dell'impianto
		rapportoTipo3.setDFlgLocaleIdoneo(new BigDecimal(importCi.getADFlagLuogoIdoneo()));
		rapportoTipo3.setDFlgLineaElettIdonea(new BigDecimal(importCi.getADFlagLineeIdonee()));
		rapportoTipo3.setDFlgCoibIdonea(new BigDecimal(importCi.getADFlagStatoCoiben()));
		rapportoTipo3.setDFlgAssenzaPerdite(new BigDecimal(importCi.getADFlagPerdite()));

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod3Import.getMODIV().getRichiesta().getDatiAllegato().getTrattamentoAcqua();

		rapportoTipo3.setCFlgTrattClimaNonRichiest(ConvertUtil.convertToBigDecimal(impTa.getACFlagTrattH2ONR()));
		rapportoTipo3.setCFlgTrattAcsNonRichiesto(ConvertUtil.convertToBigDecimal(impTa.getACFlagTrattAcsNR()));

		for (it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV all : mod3Import.getMODIV().getRichiesta().getDatiAllegato().getAllegatoIV()
				.getRowAllegatoIVList()) {

			BigDecimal progressivo = ConvertUtil.convertToBigDecimal(all.getAENumSC());

			SigitVSk4ScDto compSc = mapCompScDettDto.get(progressivo);

			SigitTDettTipo3Dto sigitTDettTipo3Dto = new SigitTDettTipo3Dto();
			sigitTDettTipo3Dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getCodiceImpianto()));
			sigitTDettTipo3Dto.setFkAllegato(idAllegato);
			sigitTDettTipo3Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_SC);
			sigitTDettTipo3Dto.setProgressivo(progressivo);
			sigitTDettTipo3Dto.setDataInstall(compSc.getDataInstall());
			sigitTDettTipo3Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
			sigitTDettTipo3Dto.setUtenteUltMod(dettaglioAllegato.getCodFiscaleUtenteLoggato());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica importCve = all.getControlloVerificaEnergetica();

			sigitTDettTipo3Dto.setEFlgClimaInverno(ConvertUtil.convertToBigDecimal(importCve.getAEFlagClimatizInv()));
			sigitTDettTipo3Dto.setEFlgProduzAcs(ConvertUtil.convertToBigDecimal(importCve.getAEFlagProduzACS()));

			sigitTDettTipo3Dto.setFkFluidoAlimentaz(new BigDecimal(importCve.getAECombustibile()));
			sigitTDettTipo3Dto.setFkFluido(new BigDecimal(importCve.getAEFluidoVett()));

			sigitTDettTipo3Dto.setEFlgPotenzaCompatibile(ConvertUtil.convertToBigDecimal(importCve.getAEFlagPotComp()));
			sigitTDettTipo3Dto.setEFlgCoibIdonea(ConvertUtil.convertToBigDecimal(importCve.getAEFlagStatoCoiben()));
			sigitTDettTipo3Dto.setEFlgDispFunzionanti(ConvertUtil.convertToBigDecimal(importCve.getAEFlagDispReg()));

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RowFumiDocument.RowFumi rowFumiImport = all.getTabFumi().getRowFumi();

			sigitTDettTipo3Dto.setETempExtC(rowFumiImport.getAETempEst());
			sigitTDettTipo3Dto.setETempMandPrimarioC(rowFumiImport.getAETempMandPrim());
			sigitTDettTipo3Dto.setETempRitorPrimarioC(rowFumiImport.getAETempRitPrim());
			sigitTDettTipo3Dto.setEPotenzaTermKw(rowFumiImport.getAEPotenzaTerm());
			sigitTDettTipo3Dto.setEPortFluidoM3H(rowFumiImport.getAEPortataFluido());
			sigitTDettTipo3Dto.setETempMandSecondarioC(rowFumiImport.getAETempMandSecond());
			sigitTDettTipo3Dto.setETempRitSecondarioC(rowFumiImport.getAETempRitSecond());

			inserisciTDettTipo3(sigitTDettTipo3Dto, idAllegato);
		}

		rapportoTipo3.setFFlgValvoleTermost(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagValvole()));
		rapportoTipo3.setFFlgVerificaParam(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagCurvaClim()));
		rapportoTipo3.setFFlgPerditeH2o(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagPerditaH2O()));
		rapportoTipo3.setFFlgInstallInvolucro(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagInvolucro()));

		inserisciTRappTipo3(rapportoTipo3, idAllegato);

		log.debug("[DbServiceImp::salvaAllegato3DaXml] END");
	}

	public void salvaAllegato4DaXml(it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument mod4Import, DettaglioAllegato dettaglioAllegato, SigitTAllegatoDto allegatoDto, Map<BigDecimal, SigitVSk4CgDto> mapCompCgDettDto)
			throws SigitextException {
		log.debug("[DbServiceImp::salvaAllegato4DaXml] START");

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = mod4Import.getMODV().getRichiesta().getDatiAllegato()
				.getDatiIdentificativi();

		allegatoDto.setAPotenzaTermicaNominaleMax(datiIdentificativi.getAAPotenzaTermicaNomTotMax());

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = mod4Import.getMODV().getRichiesta().getDatiAllegato()
				.getDocumentazioneTecnica();

		allegatoDto.setBFlgDichiarConform(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagDichiarazConf()));
		allegatoDto.setBFlgLibrettoUso(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagManutGen()));
		allegatoDto.setBFlgLibCompl(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoComp()));
		allegatoDto.setBFlgLibImp(ConvertUtil.convertToBigDecimal(documentazioneTecnica.getABFlagLibrettoImp()));

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.CheckListDocument.CheckList importCheckList = mod4Import.getMODV().getRichiesta().getDatiAllegato().getCheckList();

		if (GenericUtil.isNotNullOrEmpty(importCheckList.getAFOsservazioni())) {
			allegatoDto.setFOsservazioni(importCheckList.getAFOsservazioni());
		}
		if (GenericUtil.isNotNullOrEmpty(importCheckList.getAFRaccomandazioni())) {
			allegatoDto.setFRaccomandazioni(importCheckList.getAFRaccomandazioni());
		}
		if (GenericUtil.isNotNullOrEmpty(importCheckList.getAFPrescrizioni())) {
			allegatoDto.setFPrescrizioni(importCheckList.getAFPrescrizioni());
		}

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiTecnicoDocument.DatiTecnico datiTecnico = mod4Import.getMODV().getRichiesta().getDatiAllegato().getDatiTecnico();

		allegatoDto.setFFlgPuoFunzionare(ConvertUtil.convertToBigDecimal(datiTecnico.getAFFlagFunzImp()));

		allegatoDto.setFInterventoEntro(ConvertUtil.convertToDate(datiTecnico.getAFDataIntervento()));

		allegatoDto.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
		allegatoDto.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
		allegatoDto.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));

		if (GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())) {
			allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
			allegatoDto.setFFirmaTecnico(datiTecnico.getAFFirmaTecnico());
		} else {
			allegatoDto.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
		}
		log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): " + datiTecnico.getAFFirmaResp());
		if (GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())) {
			allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
			allegatoDto.setFFirmaResponsabile(datiTecnico.getAFFirmaResp());
		} else {
			allegatoDto.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
		}

		aggiornaAllegato(allegatoDto);

		BigDecimal idAllegato = allegatoDto.getIdAllegato();

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.ControlloImpiantoDocument.ControlloImpianto importCi = mod4Import.getMODV().getRichiesta().getDatiAllegato().getControlloImpianto();

		SigitTRappTipo4Dto rapportoTipo4 = new SigitTRappTipo4Dto();

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

		for (it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RowAllegatoVDocument.RowAllegatoV all : mod4Import.getMODV().getRichiesta().getDatiAllegato().getAllegatoV()
				.getRowAllegatoVList()) {
			BigDecimal progressivo = ConvertUtil.convertToBigDecimal(all.getAENumCG());

			SigitVSk4CgDto compCg = mapCompCgDettDto.get(progressivo);

			SigitTDettTipo4Dto sigitTDettTipo4Dto = new SigitTDettTipo4Dto();

			sigitTDettTipo4Dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getCodiceImpianto()));
			sigitTDettTipo4Dto.setFkAllegato(idAllegato);
			sigitTDettTipo4Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
			sigitTDettTipo4Dto.setUtenteUltMod(dettaglioAllegato.getCodFiscaleUtenteLoggato());
			sigitTDettTipo4Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_CG);
			sigitTDettTipo4Dto.setProgressivo(progressivo);
			sigitTDettTipo4Dto.setDataInstall(compCg.getDataInstall());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica importCve = all.getControlloVerificaEnergetica();

			sigitTDettTipo4Dto.setFkFluido(new BigDecimal(importCve.getAEFluidoVett()));

			sigitTDettTipo4Dto.setEPotenzaAssorbCombKw(importCve.getAEPotenzaAssorbita());
			sigitTDettTipo4Dto.setEPotenzaTermBypassKw(importCve.getAEPotenzaTermByPass());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RowFumiDocument.RowFumi rowFumiImport = all.getTabFumi().getRowFumi();

			sigitTDettTipo4Dto.setETempAriaC(rowFumiImport.getAETempAriaCombur());

			sigitTDettTipo4Dto.setETempH2oInC(rowFumiImport.getAETempAcquaIng());
			sigitTDettTipo4Dto.setETempH2oOutC(rowFumiImport.getAETempAcquaUsc());

			sigitTDettTipo4Dto.setEPotenzaMorsettiKw(rowFumiImport.getAEPotenzaMorsetti());
			sigitTDettTipo4Dto.setETempH2oMotoreC(rowFumiImport.getAETempH2Omotore());
			sigitTDettTipo4Dto.setETempFumiValleC(rowFumiImport.getAETempFumiAvalle());
			sigitTDettTipo4Dto.setETempFumiMonteC(rowFumiImport.getAETempFumiAmonte());

			sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMin(rowFumiImport.getAESovraFreqSoglia1());
			sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMed(rowFumiImport.getAESovraFreqSoglia2());
			sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMax(rowFumiImport.getAESovraFreqSoglia3());

			sigitTDettTipo4Dto.setL114SovrafreqTempoSMin(rowFumiImport.getAESovraFreqTempo1());
			sigitTDettTipo4Dto.setL114SovrafreqTempoSMed(rowFumiImport.getAESovraFreqTempo2());
			sigitTDettTipo4Dto.setL114SovrafreqTempoSMax(rowFumiImport.getAESovraFreqTempo3());

			sigitTDettTipo4Dto.setL114SottofreqSogliaHzMin(rowFumiImport.getAESottoFreqSoglia1());
			sigitTDettTipo4Dto.setL114SottofreqSogliaHzMed(rowFumiImport.getAESottoFreqSoglia2());
			sigitTDettTipo4Dto.setL114SottofreqSogliaHzMax(rowFumiImport.getAESottoFreqSoglia3());

			sigitTDettTipo4Dto.setL114SottofreqTempoSMin(rowFumiImport.getAESottoFreqTempo1());
			sigitTDettTipo4Dto.setL114SottofreqTempoSMed(rowFumiImport.getAESottoFreqTempo2());
			sigitTDettTipo4Dto.setL114SottofreqTempoSMax(rowFumiImport.getAESottoFreqTempo3());

			sigitTDettTipo4Dto.setL114SovratensSogliaVMin(rowFumiImport.getAESovraTensSoglia1());
			sigitTDettTipo4Dto.setL114SovratensSogliaVMed(rowFumiImport.getAESovraTensSoglia2());
			sigitTDettTipo4Dto.setL114SovratensSogliaVMax(rowFumiImport.getAESovraTensSoglia3());

			sigitTDettTipo4Dto.setL114SovratensTempoSMin(rowFumiImport.getAESovraTensTempo1());
			sigitTDettTipo4Dto.setL114SovratensTempoSMed(rowFumiImport.getAESovraTensTempo2());
			sigitTDettTipo4Dto.setL114SovratensTempoSMax(rowFumiImport.getAESovraTensTempo3());

			sigitTDettTipo4Dto.setL114SottotensSogliaVMin(rowFumiImport.getAESottoTensSoglia1());
			sigitTDettTipo4Dto.setL114SottotensSogliaVMed(rowFumiImport.getAESottoTensSoglia2());
			sigitTDettTipo4Dto.setL114SottotensSogliaVMax(rowFumiImport.getAESottoTensSoglia3());

			sigitTDettTipo4Dto.setL114SottotensTempoSMin(rowFumiImport.getAESottoTensTempo1());
			sigitTDettTipo4Dto.setL114SottotensTempoSMed(rowFumiImport.getAESottoTensTempo2());
			sigitTDettTipo4Dto.setL114SottotensTempoSMax(rowFumiImport.getAESottoTensTempo3());

			inserisciTDettTipo4(sigitTDettTipo4Dto, idAllegato);
		}

		rapportoTipo4.setFFlgAdozioneValvole(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagValvole()));
		rapportoTipo4.setFFlgIsolamentoRete(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagIsolamento()));
		rapportoTipo4.setFFlgSistemaTrattH2o(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagSistTrattACS()));
		rapportoTipo4.setFFlgSostSistemaRegolaz(ConvertUtil.convertToBigDecimal(importCheckList.getAFFlagSistRegolaz()));

		inserisciTRappTipo4(rapportoTipo4, idAllegato);

		log.debug("[DbServiceImp::salvaAllegato4DaXml] END");
	}

	public void salvaManutenzioneGtDaXml(it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegt.data.MANUTENZIONEDocument manutenzioneGtDocument, SigitTAllegatoDto allegatoDto)
			throws SigitextException {

		log.debug("[DbServiceImp::salvaManutenzioneGtDaXml] START");

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegt.data.RichiestaDocument.Richiesta richiesta = manutenzioneGtDocument.getMANUTENZIONE().getRichiesta();

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegt.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = richiesta.getDatiIntestazione();

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegt.data.DatiManutenzioneDocument.DatiManutenzione datiManutenzione = richiesta.getDatiManutenzione();

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegt.data.DatiTecnicoDocument.DatiTecnico datiTecnico = datiManutenzione.getDatiTecnico();

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegt.data.CheckListDocument.CheckList checkList = datiManutenzione.getCheckList();

		allegatoDto.setDataControllo(ConvertUtil.convertToDate(datiIntestazione.getAFDataControllo()));

		allegatoDto.setFkTipoManutenzione(ConvertUtil.convertToInteger(datiIntestazione.getTipoIntervento()));

		allegatoDto.setFOraArrivo(datiTecnico.getAFOrarioArrivo());

		allegatoDto.setFOraPartenza(datiTecnico.getAFOrarioPartenza());

		allegatoDto.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));

		allegatoDto.setFOsservazioni(checkList.getAFOsservazioni());

		allegatoDto.setFRaccomandazioni(checkList.getAFRaccomandazioni());

		allegatoDto.setFPrescrizioni(checkList.getAFPrescrizioni());

		allegatoDto.setFInterventoEntro(ConvertUtil.convertToDate(datiTecnico.getAFDataIntervento()));

		allegatoDto.setDataInvio(DateUtil.getSqlCurrentDate());

		aggiornaAllegato(allegatoDto);

		log.debug("[DbServiceImp::salvaManutenzioneGtDaXml] END");

	}

	public void salvaManutenzioneGfDaXml(it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegf.data.MANUTENZIONEDocument manutenzioneGfDocument, SigitTAllegatoDto allegatoDto)
			throws SigitextException {

		log.debug("[DbServiceImp::salvaManutenzioneGfDaXml] START");

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegf.data.RichiestaDocument.Richiesta richiesta = manutenzioneGfDocument.getMANUTENZIONE().getRichiesta();

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegf.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = richiesta.getDatiIntestazione();

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegf.data.DatiManutenzioneDocument.DatiManutenzione datiManutenzione = richiesta.getDatiManutenzione();

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegf.data.DatiTecnicoDocument.DatiTecnico datiTecnico = datiManutenzione.getDatiTecnico();

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionegf.data.CheckListDocument.CheckList checkList = datiManutenzione.getCheckList();

		allegatoDto.setDataControllo(ConvertUtil.convertToDate(datiIntestazione.getAFDataControllo()));

		allegatoDto.setFkTipoManutenzione(ConvertUtil.convertToInteger(datiIntestazione.getTipoIntervento()));

		allegatoDto.setFOraArrivo(datiTecnico.getAFOrarioArrivo());

		allegatoDto.setFOraPartenza(datiTecnico.getAFOrarioPartenza());

		allegatoDto.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));

		allegatoDto.setFOsservazioni(checkList.getAFOsservazioni());

		allegatoDto.setFRaccomandazioni(checkList.getAFRaccomandazioni());

		allegatoDto.setFPrescrizioni(checkList.getAFPrescrizioni());

		allegatoDto.setFInterventoEntro(ConvertUtil.convertToDate(datiTecnico.getAFDataIntervento()));

		allegatoDto.setDataInvio(DateUtil.getSqlCurrentDate());

		aggiornaAllegato(allegatoDto);

		log.debug("[DbServiceImp::salvaManutenzioneGfDaXml] END");
	}

	public void salvaManutenzioneScDaXml(it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionesc.data.MANUTENZIONEDocument manutenzioneScDocument, SigitTAllegatoDto allegatoDto)
			throws SigitextException {

		log.debug("[DbServiceImp::salvaManutenzioneScDaXml] START");

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionesc.data.RichiestaDocument.Richiesta richiesta = manutenzioneScDocument.getMANUTENZIONE().getRichiesta();

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionesc.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = richiesta.getDatiIntestazione();

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionesc.data.DatiManutenzioneDocument.DatiManutenzione datiManutenzione = richiesta.getDatiManutenzione();

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionesc.data.DatiTecnicoDocument.DatiTecnico datiTecnico = datiManutenzione.getDatiTecnico();

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionesc.data.CheckListDocument.CheckList checkList = datiManutenzione.getCheckList();

		allegatoDto.setDataControllo(ConvertUtil.convertToDate(datiIntestazione.getAFDataControllo()));

		allegatoDto.setFkTipoManutenzione(ConvertUtil.convertToInteger(datiIntestazione.getTipoIntervento()));

		allegatoDto.setFOraArrivo(datiTecnico.getAFOrarioArrivo());

		allegatoDto.setFOraPartenza(datiTecnico.getAFOrarioPartenza());

		allegatoDto.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));

		allegatoDto.setFOsservazioni(checkList.getAFOsservazioni());

		allegatoDto.setFRaccomandazioni(checkList.getAFRaccomandazioni());

		allegatoDto.setFPrescrizioni(checkList.getAFPrescrizioni());

		allegatoDto.setFInterventoEntro(ConvertUtil.convertToDate(datiTecnico.getAFDataIntervento()));

		allegatoDto.setDataInvio(DateUtil.getSqlCurrentDate());

		aggiornaAllegato(allegatoDto);

		log.debug("[DbServiceImp::salvaManutenzioneScDaXml] END");
	}

	public void salvaManutenzioneCgDaXml(it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionecg.data.MANUTENZIONEDocument manutenzioneCgDocument, SigitTAllegatoDto allegatoDto)
			throws SigitextException {

		log.debug("[DbServiceImp::salvaManutenzioneCgDaXml] START");

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionecg.data.RichiestaDocument.Richiesta richiesta = manutenzioneCgDocument.getMANUTENZIONE().getRichiesta();

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionecg.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = richiesta.getDatiIntestazione();

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionecg.data.DatiManutenzioneDocument.DatiManutenzione datiManutenzione = richiesta.getDatiManutenzione();

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionecg.data.DatiTecnicoDocument.DatiTecnico datiTecnico = datiManutenzione.getDatiTecnico();

		it.csi.sigit.sigitwebn.xml.importmassivo.manutenzionecg.data.CheckListDocument.CheckList checkList = datiManutenzione.getCheckList();

		allegatoDto.setDataControllo(ConvertUtil.convertToDate(datiIntestazione.getAFDataControllo()));

		allegatoDto.setFkTipoManutenzione(ConvertUtil.convertToInteger(datiIntestazione.getTipoIntervento()));

		allegatoDto.setFOraArrivo(datiTecnico.getAFOrarioArrivo());

		allegatoDto.setFOraPartenza(datiTecnico.getAFOrarioPartenza());

		allegatoDto.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));

		allegatoDto.setFOsservazioni(checkList.getAFOsservazioni());

		allegatoDto.setFRaccomandazioni(checkList.getAFRaccomandazioni());

		allegatoDto.setFPrescrizioni(checkList.getAFPrescrizioni());

		allegatoDto.setFInterventoEntro(ConvertUtil.convertToDate(datiTecnico.getAFDataIntervento()));

		allegatoDto.setDataInvio(DateUtil.getSqlCurrentDate());

		aggiornaAllegato(allegatoDto);

		log.debug("[DbServiceImp::salvaManutenzioneCgDaXml] END");
	}

	public void storicizzaLibretti(SigitTLibrettoDto filter) throws SigitextException {
		try {
			log.debug("Storicizzazione libretti consolidati");
			filter.setDataUltMod(DateUtil.getSqlDataCorrente());
			getSigitTLibrettoDao().customUpdaterStoricizzaByCodImpianto(filter, null);

			getSigitSLibrettoDao().customUpdaterStoricizzaByCodImpianto(MapDto.mapToSigitSLibrettoDto(filter), null);

		} catch (SigitTLibrettoDaoException e) {
			throw new SigitextException(Messages.ERROR_UPDATE_DB, e);
		} catch (SigitSLibrettoDaoException e) {
			throw new SigitextException(Messages.ERROR_UPDATE_DB, e);
		}
	}

	public void consolidaLibretto(SigitTLibrettoDto dto) throws SigitextException {
		log.debug("[DbServiceImp::consolidaLibretto] BEGIN");
		try {
			// BEPPE - SigitTLibrettoDto dto = MapDto.getSigitTLibretto(libretto, datiImp);
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());
			dto.setFkStato(new BigDecimal(Constants.ID_STATO_LIBRETTO_CONSOLIDATO));
			dto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
			getSigitTLibrettoDao().update(dto);
		} catch (SigitTLibrettoDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::consolidaLibretto] END");
		}
	}

	public void updateTxtLibretto(BigDecimal idLibretto, String txtLibretto) throws SigitextException {
		log.debug("[DbServiceImp::updateTxtLibretto] START");
		try {

			SigitTLibTxtDto dto = getSigitTLibTxtDao().findByPrimaryKey(new SigitTLibTxtPk(idLibretto));

			if (dto == null) {
				dto = new SigitTLibTxtDto();
				dto.setIdLibretto(idLibretto);
				dto.setXmlLibretto(txtLibretto);
				getSigitTLibTxtDao().insert(dto);
			} else {
				dto.setXmlLibretto(txtLibretto);
				getSigitTLibTxtDao().update(dto);

			}

		} catch (SigitTLibTxtDaoException e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::updateTxtLibretto] END");
		}
	}

	public void inserisciLibretto(SigitTLibrettoDto dto) throws SigitextException {
		log.debug("[DbServiceImp::inserisciLibretto] BEGIN");
		try {
			getSigitTLibrettoDao().insert(dto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::inserisciLibretto] END");
		}
	}

	public SigitTPersonaGiuridicaDto cercaPersonaGiuridicaById(BigDecimal idPersonaGiuridica) throws SigitextException {
		log.debug("[DbServiceImp::cercaPersonaGiuridicaById] BEGIN");

		SigitTPersonaGiuridicaPk personaGiuridicaPk = null;

		try {
			personaGiuridicaPk = new SigitTPersonaGiuridicaPk(idPersonaGiuridica);

			return getSigitTPersonaGiuridicaDao().findByPrimaryKey(personaGiuridicaPk);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::cercaPersonaGiuridicaById] END");
		}
	}

	public List<SigitTUserWSDto> cercaUtenteWSByUserWS(String userWS) throws SigitextException {
		log.debug("[DbServiceImp::cercaUtenteWSByUserWS] BEGIN - " + "userWS input: " + userWS);
		List<SigitTUserWSDto> utentiWS = null;

		try {
			utentiWS = getSigitTUserWSDao().findByUserWS(userWS);
			log.debug("utentiWS: " + utentiWS.size());
			return utentiWS;

		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);

		} finally {
			log.debug("[DbServiceImp::cercaUtenteWSByUserWS] END");
		}
	}

	public Boolean cercaConfigValueFlg(String chiave) throws SigitextException {
		SigitWrkConfigDto dto = null;
		log.debug("[DbServiceImp::cercaConfigValueFlg] BEGIN");
		dto = cercaConfigValue(chiave);
		log.debug("[DbServiceImp::cercaConfigValueFlg] END");
		return ConvertUtil.convertToBoolean(dto.getValoreFlag());
	}

	public SigitWrkConfigDto cercaConfigValue(String chiave) throws SigitextException {
		List<SigitWrkConfigDto> dtoList = null;
		SigitWrkConfigDto dto = null;
		log.debug("[DbServiceImp::getConfigValue] BEGIN");
		try {
			dtoList = getSigitWrkConfigDao().findByChiaveConfig(chiave);
			if ((dtoList != null) && (dtoList.size() > 0)) {
				dto = dtoList.get(0);
				log.debug("[DbServiceImp::getConfigValue] Trovato il DTO " + dto);
			} else {
				log.debug("[DbServiceImp::getConfigValue] Nessun DTO trovato");
			}
		} catch (SigitWrkConfigDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::getConfigValue] END");
		}
		return dto;
	}

	public List<SigitTPersonaFisicaDto> cercaPersonaFisicaByCodiceFiscale(String codiceFiscale) throws SigitextException {
		log.debug("[DbServiceImp::cercaPersonaFisicaByCodiceFiscale] BEGIN");

		List<SigitTPersonaFisicaDto> personeFisiche = null;

		try {
			personeFisiche = getSigitTPersonaFisicaDao().findByCodiceFiscale(codiceFiscale);

			return personeFisiche;

		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);

		} finally {
			log.debug("[DbServiceImp::cercaPersonaFisicaByCodiceFiscale] END");
		}
	}

	public List<SigitRComp4ManutDto> cercaManutentoriByPersonaGiuridicaCodiceImpiantoRuoloFunz(Integer idPersonaGiuridica, Integer codiceImpianto, String ruoloFunz) throws SigitextException {

		log.debug("[DbServiceImp::cercaManutentoriByPersonaGiuridicaCodiceImpiantoRuoloFunz] BEGIN");

		List<SigitRComp4ManutDto> manutentori = null;

		try {

			CompFilter compFilter = new CompFilter();
			compFilter.setCodImpianto(codiceImpianto);
			compFilter.setIdPG(idPersonaGiuridica);
			compFilter.setRuoloFunz(ruoloFunz);

			manutentori = getSigitRComp4ManutDao().findByRuoloFunzPersonaGiuridicaCodImpianto(compFilter);

			return manutentori;

		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);

		} finally {
			log.debug("[DbServiceImp::cercaManutentoriByPersonaGiuridicaCodiceImpiantoRuoloFunz] END");
		}
	}

	public List<SigitRImpRuoloPfpgDto> cercaAssociazioneImpresaImpiantoByPersonaGiuridicaCodiceImpiantoRuoloFunz(Integer idPersonaGiuridica, Integer codiceImpianto, String ruoloFunz)
			throws SigitextException {

		log.debug("[DbServiceImp::cercaAssociazioneImpresaImpiantoByPersonaGiuridicaCodiceImpiantoRuoloFunz] BEGIN");

		List<SigitRImpRuoloPfpgDto> assImpresaImpianto = null;

		try {

			CompFilter compFilter = new CompFilter();
			compFilter.setCodImpianto(codiceImpianto);
			compFilter.setIdPG(idPersonaGiuridica);
			compFilter.setRuoloFunz(ruoloFunz);

			assImpresaImpianto = getSigitRImpRuoloPfpgDao().findByRuoloFunzPersonaGiuridicaCodImpianto(compFilter);

			return assImpresaImpianto;

		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);

		} finally {
			log.debug("[DbServiceImp::cercaAssociazioneImpresaImpiantoByPersonaGiuridicaCodiceImpiantoRuoloFunz] END");
		}
	}

	public List<SigitTLibrettoDto> cercaLibrettoByUid(String uid) throws SigitextException {

		log.debug("[DbServiceImp::cercaLibrettoByUid] BEGIN");

		List<SigitTLibrettoDto> libretto = null;

		try {

			libretto = getSigitTLibrettoDao().findByUid(uid);

			return libretto;

		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);

		} finally {
			log.debug("[DbServiceImp::cercaLibrettoByUid] END");
		}
	}

	public void inserisciAccesso(SigitLAccessoDto dto) throws SigitextException {
		log.debug("[DbServiceImp::inserisciAccesso] BEGIN");
		try {
			getSigitLAccessoDao().insert(dto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB, e);
		} finally {
			log.debug("[DbServiceImp::inserisciAccesso] END");
		}
	}

	public SigitTElencoWsDto cercaWsByidWs(Integer idWs) throws SigitextException {
		log.debug("[DbServiceImp::cercaWsByidWs] BEGIN");
		try {
			SigitTElencoWsPk elencoWsPk = new SigitTElencoWsPk(idWs);

			return getSigitTElencoWsDao().findByPrimaryKey(elencoWsPk);
		} catch (SigitTElencoWsDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::cercaWsByidWs] END");
		}
	}

	public List<SigitExtImpiantoDto> ricercaImpiantoByFiltro(ImpiantoFiltro impiantoFiltro) throws SigitextException {
		log.debug("[DbServiceImp::ricercaImpiantoByFiltro] BEGIN");

		try {

			return getSigitExtDao().findImpiantiByFiltro(impiantoFiltro);
		} catch (Exception e) {
			log.error("Errore recupero dati dal server: ", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::ricercaImpiantoByFiltro] END");
		}
	}

	public MODDocument getModuloLibretto(Integer codImpianto, boolean isDefinitivo) throws SigitextException {
		log.debug("[DbServiceImp::getModuloLibretto] BEGIN");
		try {
			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(codImpianto));
			SigitTImpiantoDto impianto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);

			/*
			//quando creaiamo la bozza di un impianto ribaltato dal sigit, non avremmo il libretto
			SigitTLibrettoDto libretto = new SigitTLibrettoDto();
			if(idLibretto!=null)
			{
				SigitTLibrettoPk pkLibretto = new SigitTLibrettoPk();
				pkLibretto.setIdLibretto(new BigDecimal(idLibretto));
				libretto = getSigitTLibrettoDao().findByPrimaryKey(pkLibretto);
			}
			 */

			MODDocument modDoc = MODDocument.Factory.newInstance();
			modDoc.addNewMOD().addNewRichiesta().addNewDatiPrecompilati().addNewSezCatasto();

			RichiestaDocument.Richiesta richiesta = modDoc.getMOD().getRichiesta();
			DatiPrecompilatiDocument.DatiPrecompilati datiPrecompilati = richiesta.getDatiPrecompilati();

			// Le combo servono per adesso, altrimenti compaiono tutti i campi "Empty"
			datiPrecompilati.setElencoCombustibile(MapDto.mapToElencoCombustibile(getCombustibileCITDao().findAll()));
			datiPrecompilati.setElencoFabbricante(MapDto.mapToElencoFabbricante(getMarcaCITDao().findAll()));
			datiPrecompilati.setElencoFluidoTermoVett(MapDto.mapToElencoFluido(getFluidoCITDao().findAll()));
			datiPrecompilati.setElencoUM(MapDto.mapToElencoUnitaMisura(getUnitaMisuraCITDao().findAll()));

			compilaScheda1Libretto(richiesta, impianto);

			SigitTTrattH2OPk pkTrattAcq = new SigitTTrattH2OPk();
			pkTrattAcq.setCodiceImpianto(new BigDecimal(codImpianto));
			SigitTTrattH2ODto trattH2ODto = getSigitTTrattH2ODao().findByPrimaryKey(pkTrattAcq);
			if (trattH2ODto != null)
				MapDto.mapToSchedaTrattH2O(trattH2ODto, richiesta.addNewDatiSchedaTrattH2O());

			//GT
			List<SigitVSk4GtDto> comSk4GtImpianto = getCompSk4Gt(codImpianto);
			if (comSk4GtImpianto != null && !comSk4GtImpianto.isEmpty()) {
				MapDto.mapToSchedaGT(comSk4GtImpianto, richiesta.addNewDatiSchedaGT());
				setImpresaGt(comSk4GtImpianto, richiesta.getDatiSchedaGT());
			}
			//BR
			SigitTCompBrRcDto inputBrRc = new SigitTCompBrRcDto();
			inputBrRc.setCodiceImpianto(new BigDecimal(codImpianto));
			inputBrRc.setTipologiaBrRc(Constants.TIPO_COMPONENTE_BR);
			List<SigitTCompBrRcDto> compBrImpianto = getSigitTCompBrRcDao().findByTipoAndCodImpiantoOrdered(inputBrRc);
			if (compBrImpianto != null && !compBrImpianto.isEmpty())
				MapDto.mapToSchedaBR(compBrImpianto, richiesta.addNewDatiSchedaBR(), comSk4GtImpianto);
			//RC
			inputBrRc.setTipologiaBrRc(Constants.TIPO_COMPONENTE_RC);
			List<SigitTCompBrRcDto> compRcImpianto = getSigitTCompBrRcDao().findByTipoAndCodImpiantoOrdered(inputBrRc);
			if (compBrImpianto != null && !compRcImpianto.isEmpty())
				MapDto.mapToSchedaRC(compRcImpianto, richiesta.addNewDatiSchedaRC(), comSk4GtImpianto);
			//GF
			List<SigitVSk4GfDto> comSk4GfImpianto = getCompSk4Gf(codImpianto);
			if (comSk4GfImpianto != null && !comSk4GfImpianto.isEmpty()) {
				MapDto.mapToSchedaGF(comSk4GfImpianto, richiesta.addNewDatiSchedaGF());
				setImpresaGf(comSk4GfImpianto, richiesta.getDatiSchedaGF());
			}
			//SC
			List<SigitVSk4ScDto> comSk4ScImpianto = getCompSk4Sc(codImpianto);
			if (comSk4ScImpianto != null && !comSk4ScImpianto.isEmpty()) {
				MapDto.mapToSchedaSC(comSk4ScImpianto, richiesta.addNewDatiSchedaSC());
				setImpresaSc(comSk4ScImpianto, richiesta.getDatiSchedaSC());
			}
			//CG
			List<SigitVSk4CgDto> comSk4CgImpianto = getCompSk4Cg(codImpianto);
			if (comSk4CgImpianto != null && !comSk4CgImpianto.isEmpty()) {
				MapDto.mapToSchedaCG(comSk4CgImpianto, richiesta.addNewDatiSchedaCG());
				setImpresaCg(comSk4CgImpianto, richiesta.getDatiSchedaCG());
			}
			//CS
			List<SigitVCompCsDto> compCsImpianto = getSigitVCompCsDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if (compCsImpianto != null && !compCsImpianto.isEmpty())
				MapDto.mapToSchedaCS(compCsImpianto, richiesta.addNewDatiSchedaCS());
			//AG
			List<SigitVCompAgDto> compAgImpianto = getSigitVCompAgDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if (compAgImpianto != null && !compAgImpianto.isEmpty())
				MapDto.mapToSchedaAG(compAgImpianto, richiesta.addNewDatiSchedaAG());

			//5-7
			SigitTCompXSemplicePk pkXSemplice = new SigitTCompXSemplicePk();
			pkXSemplice.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			SigitTCompXSempliceDto compXSemplice = getSigitTCompXSempliceDao().findByPrimaryKey(pkXSemplice);
			if (compXSemplice != null) {
				//sez5
				MapDto.mapToSchedaSistemiRegolarizzazionePrimaria(richiesta.addNewDatiSchedaSistemiRegolaz().addNewRegolazionePrimaria(), compXSemplice);
				MapDto.mapToSchedaSistemiRegolarizzazioneSingoloAmbiente(richiesta.getDatiSchedaSistemiRegolaz().addNewRegolazioneSingoloAmb(), compXSemplice);
				//SR
				List<SigitVCompSrDto> srList = getSigitVCompSrDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
				if (srList != null && !srList.isEmpty())
					MapDto.mapToSchedaSR(richiesta.getDatiSchedaSistemiRegolaz().getRegolazionePrimaria().addNewSezSR(), srList);
				//sez6
				MapDto.mapToSchedaSistemiDistribuiti(richiesta.addNewDatiSchedaSistemiDistrib(), compXSemplice);
				//VR
				List<SigitVCompVrDto> vrList = getSigitVCompVrDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
				if (vrList != null && !vrList.isEmpty())
					MapDto.mapToSchedaVR(richiesta.getDatiSchedaSistemiRegolaz().getRegolazionePrimaria().addNewSezVR(), vrList);
				//VX
				List<SigitTCompVxDto> vxList = getSigitTCompVxDao().findByCodImpianto(codImpianto);
				if (vxList != null && !vxList.isEmpty())
					MapDto.mapToSchedaVX(richiesta.getDatiSchedaSistemiDistrib().addNewSezVasi(), vxList);
				//PO
				List<SigitVCompPoDto> poList = getSigitVCompPoDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
				if (poList != null && !poList.isEmpty())
					MapDto.mapToSchedaPO(richiesta.getDatiSchedaSistemiDistrib().addNewSezPO(), poList);
				//sez7
				MapDto.mapToSchedaSistemiEmissione(richiesta.addNewDatiSchedaSistemaEmissione(), compXSemplice);
			}
			//8 - AC
			List<SigitVCompAcDto> acList = getSigitVCompAcDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if (acList != null && !acList.isEmpty())
				MapDto.mapToSchedaAC(richiesta.addNewDatiSchedaSistemaAC().addNewSezAC(), acList);
			//9.1 - TE
			List<SigitVCompTeDto> teList = getSigitVCompTeDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if (teList != null && !teList.isEmpty())
				MapDto.mapToSchedaTE(richiesta.addNewDatiAltriComponentiTE().addNewSezTE(), teList);
			//9.2 - RV
			List<SigitVCompRvDto> rvList = getSigitVCompRvDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if (rvList != null && !rvList.isEmpty())
				MapDto.mapToSchedaRV(richiesta.addNewDatiAltriComponentiRV().addNewSezRV(), rvList);

			//9.3 - SC
			CompFilter filterSCX = new CompFilter();
			filterSCX.setCodImpianto(codImpianto);
			filterSCX.setTipoComponente(Constants.TIPO_COMPONENTE_SCX);
			List<SigitTCompXDto> scxList = getSigitTCompXDao().findByTipoAndCodImpiantoOrdered(filterSCX);
			if (scxList != null && !scxList.isEmpty())
				MapDto.mapToSchedaSCX(richiesta.addNewDatiAltriComponentiSC().addNewSezSC(), scxList);

			//9.4 - CI
			List<SigitVCompCiDto> ciList = getSigitVCompCiDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if (ciList != null && !ciList.isEmpty())
				MapDto.mapToSchedaCI(richiesta.addNewDatiAltriComponentiCI().addNewSezCI(), ciList);

			//9.5 - UT
			List<SigitVCompUtDto> utList = getSigitVCompUtDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if (utList != null && !utList.isEmpty())
				MapDto.mapToSchedaUT(richiesta.addNewDatiAltriComponentiUT().addNewSezUT(), utList);

			//9.6 - RC
			List<SigitVCompRcDto> rcList = getSigitVCompRcDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if (rcList != null && !rcList.isEmpty())
				MapDto.mapToSchedaRC(richiesta.addNewDatiAltriComponentiRC().addNewSezRC(), rcList);

			//10.1 - VM
			List<SigitVCompVmDto> vmList = getSigitVCompVmDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			if (vmList != null && !vmList.isEmpty())
				MapDto.mapToSchedaVM(richiesta.addNewDatiVentilazMeccanicaVM().addNewSezVM(), vmList);

			//			richiesta.addNewDatiRisultatiGT().xsetL111FlagNorma(MapDto.getXmlBoolean(ConvertUtil.convertToBooleanAllways(impianto.getL111FlgNormaUni103891())));
			//			richiesta.getDatiRisultatiGT().xsetL111FlagAltro(MapDto.getXmlBoolean(GenericUtil.isNotNullOrEmpty(impianto.getL111AltraNorma())));
			//			richiesta.getDatiRisultatiGT().setL111DescrAltro(impianto.getL111AltraNorma());

			List<SigitVCompGtDettDto> compGtImpiantoDett = getCompGtDett(codImpianto);
			List<SigitVCompGfDettDto> compGfImpiantoDett = getCompGfDett(codImpianto);
			List<SigitVCompScDettDto> compScImpiantoDett = getCompScDett(codImpianto);
			List<SigitVCompCgDettDto> compCgImpiantoDett = getCompCgDett(codImpianto);

			compilaDatiResponsabiliEControlliLibretto(codImpianto, richiesta, compGtImpiantoDett, compGfImpiantoDett, compScImpiantoDett, compCgImpiantoDett);

			/*
			if(richiesta.getDatiRisultatiGT()!=null)
			{

				if(GenericUtil.isNotNullOrEmpty(impianto.getL111AltraNorma()))
				{
					richiesta.getDatiRisultatiGT().setL111DescrAltro(impianto.getL111AltraNorma());
					richiesta.getDatiRisultatiGT().xsetL111FlagAltro(MapDto.getXmlBoolean(true));
				}

				richiesta.getDatiRisultatiGT().xsetL111FlagNorma(MapDto.getXmlBoolean(ConvertUtil.convertToBooleanAllways(impianto.getL111FlgNormaUni103891())));
			}
			*/

			compilaScheda14Libretto(codImpianto, richiesta);

			modDoc.getMOD().addNewSystem().addNewCatDig().setModuloEditabile(false);
			modDoc.getMOD().getSystem().getCatDig().setBtSalva(false);

			if (isDefinitivo) {
				datiPrecompilati.setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
			} else {
				datiPrecompilati.setStatoModulo(Constants.STATO_MODULO_BOZZA);
			}

			if (log.isDebugEnabled()) {
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				log.debug("STAMPO RESULT: " + modDoc);
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}

			return modDoc;

		} catch (Exception e) {
			log.error("Errore getLibretto", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::getModuloLibretto] END");
		}
	}

	private void setImpresaGt(List<SigitVSk4GtDto> compGtImpianto, DatiSchedaGTDocument.DatiSchedaGT datiSchedaGT) throws SigitRComp4ManutDaoException, SigitTPersonaGiuridicaDaoException {
		for (SigitVSk4GtDto gtdto : compGtImpianto) {
			SigitRComp4ManutDto comp4ManutFilter = new SigitRComp4ManutDto();
			comp4ManutFilter.setCodiceImpianto(gtdto.getCodiceImpianto());
			comp4ManutFilter.setIdTipoComponente(gtdto.getIdTipoComponente());
			comp4ManutFilter.setProgressivo(gtdto.getProgressivo());

			List<SigitRComp4ManutDto> comp4ManutList = getSigitRComp4ManutDao().findAttiviByFilter(comp4ManutFilter);
			if (comp4ManutList != null) {
				SigitTPersonaGiuridicaDto personaGiutidicaDto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(comp4ManutList.get(0).getFkPersonaGiuridica()));
				MapDto.mapImpresaGt(gtdto, datiSchedaGT, personaGiutidicaDto);
			}
		}
	}

	private void setImpresaGf(List<SigitVSk4GfDto> compGfImpianto, DatiSchedaGFDocument.DatiSchedaGF datiSchedaGF) throws SigitRComp4ManutDaoException, SigitTPersonaGiuridicaDaoException {
		for (SigitVSk4GfDto gtdto : compGfImpianto) {
			SigitRComp4ManutDto comp4ManutFilter = new SigitRComp4ManutDto();
			comp4ManutFilter.setCodiceImpianto(gtdto.getCodiceImpianto());
			comp4ManutFilter.setIdTipoComponente(gtdto.getIdTipoComponente());
			comp4ManutFilter.setProgressivo(gtdto.getProgressivo());

			List<SigitRComp4ManutDto> comp4ManutList = getSigitRComp4ManutDao().findAttiviByFilter(comp4ManutFilter);
			if (comp4ManutList != null) {
				SigitTPersonaGiuridicaDto personaGiutidicaDto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(comp4ManutList.get(0).getFkPersonaGiuridica()));
				MapDto.mapImpresaGf(gtdto, datiSchedaGF, personaGiutidicaDto);
			}
		}
	}

	private void setImpresaSc(List<SigitVSk4ScDto> compScImpianto, DatiSchedaSCDocument.DatiSchedaSC datiSchedaSC) throws SigitRComp4ManutDaoException, SigitTPersonaGiuridicaDaoException {
		for (SigitVSk4ScDto gtdto : compScImpianto) {
			SigitRComp4ManutDto comp4ManutFilter = new SigitRComp4ManutDto();
			comp4ManutFilter.setCodiceImpianto(gtdto.getCodiceImpianto());
			comp4ManutFilter.setIdTipoComponente(gtdto.getIdTipoComponente());
			comp4ManutFilter.setProgressivo(gtdto.getProgressivo());

			List<SigitRComp4ManutDto> comp4ManutList = getSigitRComp4ManutDao().findAttiviByFilter(comp4ManutFilter);
			if (comp4ManutList != null) {
				SigitTPersonaGiuridicaDto personaGiutidicaDto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(comp4ManutList.get(0).getFkPersonaGiuridica()));
				MapDto.mapImpresaSc(gtdto, datiSchedaSC, personaGiutidicaDto);
			}
		}
	}

	private void setImpresaCg(List<SigitVSk4CgDto> compCgImpianto, DatiSchedaCGDocument.DatiSchedaCG datiSchedaCg) throws SigitRComp4ManutDaoException, SigitTPersonaGiuridicaDaoException {
		for (SigitVSk4CgDto gtdto : compCgImpianto) {
			SigitRComp4ManutDto comp4ManutFilter = new SigitRComp4ManutDto();
			comp4ManutFilter.setCodiceImpianto(gtdto.getCodiceImpianto());
			comp4ManutFilter.setIdTipoComponente(gtdto.getIdTipoComponente());
			comp4ManutFilter.setProgressivo(gtdto.getProgressivo());

			List<SigitRComp4ManutDto> comp4ManutList = getSigitRComp4ManutDao().findAttiviByFilter(comp4ManutFilter);
			if (comp4ManutList != null) {
				SigitTPersonaGiuridicaDto personaGiutidicaDto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(comp4ManutList.get(0).getFkPersonaGiuridica()));
				MapDto.mapImpresaCG(gtdto, datiSchedaCg, personaGiutidicaDto);
			}
		}
	}

	public DatiLibretto getDatiLibretto(Integer codImpianto, boolean isDefinitivo) throws SigitextException {
		log.debug("[DbServiceImp::getDatiLibretto] BEGIN");
		DatiLibretto datiLibretto = new DatiLibretto();

		try {
			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(codImpianto));
			SigitTImpiantoDto impianto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);
			datiLibretto.setImpianto(impianto);

			// Le combo servono per adesso, altrimenti compaiono tutti i campi "Empty"
			datiLibretto.setElencoCombustibile(getCombustibileCITDao().findAll());
			datiLibretto.setElencoFabbricante(getMarcaCITDao().findAll());
			datiLibretto.setElencoFluidoTermoVett(getFluidoCITDao().findAll());
			datiLibretto.setElencoUM(getUnitaMisuraCITDao().findAll());

			List<SigitTUnitaImmobiliareDto> unitaImmobList = getUnitaImmobiliariImpianto(impianto.getCodiceImpianto().intValue());
			datiLibretto.setUnitaImmobiliList(unitaImmobList);

			SigitTTrattH2OPk pkTrattAcq = new SigitTTrattH2OPk();
			pkTrattAcq.setCodiceImpianto(new BigDecimal(codImpianto));
			SigitTTrattH2ODto trattH2ODto = getSigitTTrattH2ODao().findByPrimaryKey(pkTrattAcq);
			datiLibretto.setTrattH2O(trattH2ODto);

			//GT
			List<SigitVSk4GtDto> comSk4GtImpianto = getCompSk4Gt(codImpianto);
			datiLibretto.setComSk4GtImpianto(comSk4GtImpianto);

			//BR
			SigitTCompBrRcDto inputBrRc = new SigitTCompBrRcDto();
			inputBrRc.setCodiceImpianto(new BigDecimal(codImpianto));
			inputBrRc.setTipologiaBrRc(Constants.TIPO_COMPONENTE_BR);
			List<SigitTCompBrRcDto> compBrImpianto = getSigitTCompBrRcDao().findByTipoAndCodImpiantoOrdered(inputBrRc);
			datiLibretto.setCompBrImpianto(compBrImpianto);

			//RC
			inputBrRc.setTipologiaBrRc(Constants.TIPO_COMPONENTE_RC);
			List<SigitTCompBrRcDto> compRcImpianto = getSigitTCompBrRcDao().findByTipoAndCodImpiantoOrdered(inputBrRc);
			datiLibretto.setCompRcImpianto(compRcImpianto);

			//GF
			List<SigitVSk4GfDto> comSk4GfImpianto = getCompSk4Gf(codImpianto);
			datiLibretto.setComSk4GfImpianto(comSk4GfImpianto);

			//SC
			List<SigitVSk4ScDto> comSk4ScImpianto = getCompSk4Sc(codImpianto);
			datiLibretto.setComSk4ScImpianto(comSk4ScImpianto);

			//CG
			List<SigitVSk4CgDto> comSk4CgImpianto = getCompSk4Cg(codImpianto);
			datiLibretto.setComSk4CgImpianto(comSk4CgImpianto);

			//CS
			List<SigitVCompCsDto> compCsImpianto = getSigitVCompCsDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			datiLibretto.setCompCsImpianto(compCsImpianto);

			//AG
			List<SigitVCompAgDto> compAgImpianto = getSigitVCompAgDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			datiLibretto.setCompAgImpianto(compAgImpianto);

			//5-7
			SigitTCompXSemplicePk pkXSemplice = new SigitTCompXSemplicePk();
			pkXSemplice.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			SigitTCompXSempliceDto compXSemplice = getSigitTCompXSempliceDao().findByPrimaryKey(pkXSemplice);
			datiLibretto.setCompXSemplice(compXSemplice);

			//sez5

			//SR
			List<SigitVCompSrDto> srList = getSigitVCompSrDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			datiLibretto.setSrList(srList);

			//sez6

			//VR
			List<SigitVCompVrDto> vrList = getSigitVCompVrDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			datiLibretto.setVrList(vrList);

			//VX
			List<SigitTCompVxDto> vxList = getSigitTCompVxDao().findByCodImpianto(codImpianto);
			datiLibretto.setVxList(vxList);

			//PO
			List<SigitVCompPoDto> poList = getSigitVCompPoDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			datiLibretto.setPoList(poList);

			//sez7

			//8 - AC
			List<SigitVCompAcDto> acList = getSigitVCompAcDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			datiLibretto.setAcList(acList);

			//9.1 - TE
			List<SigitVCompTeDto> teList = getSigitVCompTeDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			datiLibretto.setTeList(teList);

			//9.2 - RV
			List<SigitVCompRvDto> rvList = getSigitVCompRvDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			datiLibretto.setRvList(rvList);

			//9.3 - SC
			CompFilter filterSCX = new CompFilter();
			filterSCX.setCodImpianto(codImpianto);
			filterSCX.setTipoComponente(Constants.TIPO_COMPONENTE_SCX);
			List<SigitTCompXDto> scxList = getSigitTCompXDao().findByTipoAndCodImpiantoOrdered(filterSCX);
			datiLibretto.setScxList(scxList);

			//9.4 - CI
			List<SigitVCompCiDto> ciList = getSigitVCompCiDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			datiLibretto.setCiList(ciList);

			//9.5 - UT
			List<SigitVCompUtDto> utList = getSigitVCompUtDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			datiLibretto.setUtList(utList);

			//9.6 - RC
			List<SigitVCompRcDto> rcList = getSigitVCompRcDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			datiLibretto.setRcList(rcList);

			//10.1 - VM
			List<SigitVCompVmDto> vmList = getSigitVCompVmDao().findByCodImpiantoOrdered(new CompFilter(codImpianto));
			datiLibretto.setVmList(vmList);

			//RESPONSABILE IMPIANTO (1.6)

			List<SigitVTotImpiantoDto> respAttivi = getSigitVTotImpiantoDao().findResponsabiliAttiviByCodiceImpianto(codImpianto);
			datiLibretto.setRespAttivi(respAttivi);

			//TERZO RESPONSABILE
			log.debug("Ricerca contratti impianto");
			ContrattoFilter filterContratti = new ContrattoFilter();
			filterContratti.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			List<SigitExtContrattoImpDto> contratti = getSigitExtDao().findStoriaContrattiImpiantoNew(filterContratti);
			datiLibretto.setContratti(contratti);

			//11.1 - Dati risultati GT
			List<SigitVCompGtDettDto> compGtImpiantoDett = getCompGtDett(codImpianto);
			datiLibretto.setCompGtImpiantoDett(compGtImpiantoDett);

			//11.2 - Dati risultati GF
			List<SigitVCompGfDettDto> compGfImpiantoDett = getCompGfDett(codImpianto);
			datiLibretto.setCompGfImpiantoDett(compGfImpiantoDett);

			//11.3 - Dati risultati SC
			List<SigitVCompScDettDto> compScImpiantoDett = getCompScDett(codImpianto);
			datiLibretto.setCompScImpiantoDett(compScImpiantoDett);

			//11.4 - Dati risultati CG
			List<SigitVCompCgDettDto> compCgImpiantoDett = getCompCgDett(codImpianto);
			datiLibretto.setCompCgImpiantoDett(compCgImpiantoDett);

			//12 - Interventi controllo efficenza
			List<SigitVRicercaAllegatiDto> listControlli = getSigitVRicercaAllegatiDao().findInviatiByCodImpiantoOrderedByData(codImpianto);
			datiLibretto.setListControlliEfficenza(listControlli);

			//13 - risultati ispezione
			List<SigitVRicercaIspezioniConsByCodiceImpiantoDto> listIspezioniDb = getSigitVRicercaIspezioniDao().findConsByCodiceImpianto(codImpianto);

			IspezioneFilter filter = new IspezioneFilter();
			filter.setCodiceImpianto(codImpianto);
			filter.setIdStatoIspezione(Constants.ID_STATO_ISPEZIONE_CONSOLIDATO);

			String elencoIspezioni = null;

			for (SigitVRicercaIspezioniConsByCodiceImpiantoDto sigitVRicercaIspezioniConsByCodiceImpiantoDto : listIspezioniDb) {

				if (elencoIspezioni == null) {
					elencoIspezioni = ConvertUtil.convertToString(sigitVRicercaIspezioniConsByCodiceImpiantoDto.getIdIspezione2018());
				} else {
					elencoIspezioni += ", " + sigitVRicercaIspezioniConsByCodiceImpiantoDto.getIdIspezione2018();
				}
			}

			filter.setElencoIdIspezione2018(elencoIspezioni);

			List<SigitVRicercaIspezioniDto> listIspezioniDettDb = getSigitVRicercaIspezioniDao().findConsDettRappProvaByFilter(filter);

			String elencoIdAllegati = null;
			SigitVRicercaIspezioniDto ispezIspet = null;
			List<SigitVRicercaIspezioniDto> ispezIspetList = null;

			List<DettaglioIspezione> dettaglioIspezioneList = new ArrayList<DettaglioIspezione>();

			for (SigitVRicercaIspezioniConsByCodiceImpiantoDto ispezioneDb : listIspezioniDb) {

				// Ripulisco l'elenco degli allegati
				elencoIdAllegati = null;
				ispezIspet = null;
				DettaglioIspezione dettaglioIspezione = new DettaglioIspezione();

				ispezIspetList = getSigitVRicercaIspezioniDao().findByIdIspezIspet(ConvertUtil.convertToInteger(ispezioneDb.getMax_id_ispez_ispet()));

				if (ispezIspetList != null && ispezIspetList.size() > 0) {
					// Sicuramente ce ne solo 1
					ispezIspet = ispezIspetList.get(0);
				}

				for (SigitVRicercaIspezioniDto sigitVRicercaIspezioniDto : listIspezioniDettDb) {

					if (ispezioneDb.getIdIspezione2018().intValue() == sigitVRicercaIspezioniDto.getIdIspezione2018().intValue()) {
						if (elencoIdAllegati != null) {
							elencoIdAllegati += ", " + sigitVRicercaIspezioniDto.getIdAllegato();
						} else {
							elencoIdAllegati = ConvertUtil.convertToString(sigitVRicercaIspezioniDto.getIdAllegato());
						}
					}
				}

				dettaglioIspezione.setIspezioneDb(ispezioneDb);
				dettaglioIspezione.setIspezIspet(ispezIspet);
				dettaglioIspezione.setElencoIdAllegati(elencoIdAllegati);

				dettaglioIspezioneList.add(dettaglioIspezione);
			}

			datiLibretto.setDettaglioIspezioneList(dettaglioIspezioneList);

			//15 - interventi di manutenzione
			List<SigitVRicercaAllegatiDto> listManutenzioni = getSigitVRicercaAllegatiDao().findManutByCodImpianto(codImpianto);
			datiLibretto.setManutenzioniList(listManutenzioni);

			//14.1 - Combustibile
			SigitTConsumoDto inputCons = new SigitTConsumoDto();
			inputCons.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			inputCons.setFkTipoConsumo(Constants.TIPO_CONSUMO_CB);
			List<SigitTConsumoDto> cbList = getSigitTConsumoDao().findByCodImpiantoAndTipo(inputCons);
			datiLibretto.setCombustibileList(cbList);
			//la lista cbList, dovrebbe essere ordinata per tipo_combustibile, bisogna fare la rottura per ogni tipo

			//14.2 - Energia elettrica
			inputCons.setFkTipoConsumo(Constants.TIPO_CONSUMO_EE);
			List<SigitTConsumoDto> eeList = getSigitTConsumoDao().findByCodImpiantoAndTipo(inputCons);
			datiLibretto.setEnergiaElettricaList(eeList);

			//14.3 - Acqua
			inputCons.setFkTipoConsumo(Constants.TIPO_CONSUMO_H2O);
			List<SigitTConsumoDto> h2oList = getSigitTConsumoDao().findByCodImpiantoAndTipo(inputCons);
			datiLibretto.setH2oList(h2oList);

			//14.4 - Prodotti chimici
			List<SigitTConsumo14_4Dto> pcList = getSigitTConsumo144Dao().findByCodImpianto(codImpianto);
			datiLibretto.setProdottiChimiciList(pcList);

			if (log.isDebugEnabled()) {
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				log.debug("STAMPO RESULT: " + datiLibretto);
				log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}

		} catch (Exception e) {
			log.error("Errore getDatiLibretto", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::getDatiLibretto] END");
		}

		return datiLibretto;
	}

	public int getNextIdSeqCodiceImpianto() throws SigitextException {
		log.debug("[SigitMgr:::getNextIdSeqCodiceImpianto] START");
		try {

			int nextId = 0;

			boolean trovato = false;

			// Devo ciclare fino a quando non trovo un codice impianto non usato
			while (!trovato) {
				nextId = ConvertUtil.convertToInteger(getSigitTImpiantoDao().getSeqTCodiceImpianto());
				if (cercaImpiantoDtoById(ConvertUtil.convertToString(nextId)) == null) {
					trovato = true;
				}
			}

			return nextId;
		} catch (SigitextException | SigitExtDaoException e) {
			log.error("Errore: ", e);
			throw new SigitextException("Errore recupero chiave impianto");
		} finally {
			log.debug("[SigitMgr:::getNextIdSeqCodiceImpianto] END");
		}
	}

	public SigitTImpiantoDto cercaImpiantoDtoById(String idImpianto) throws SigitextException {
		SigitTImpiantoDto dto = null;
		try {
			dto = getSigitTImpiantoDao().findByPrimaryKey(new SigitTImpiantoPk(ConvertUtil.convertToBigDecimal(idImpianto)));
		} catch (SigitTImpiantoDaoException e) {
			log.error("Errore: ", e);
			throw new SigitextException("Errore recupero impianto");
		} finally {
			log.debug("[DbServiceImp::cercaImpiantoDtoById] END");
		}

		return dto;
	}

	public int getMaxIdSeqCodiceImpianto() throws Exception {
		try {
			return ConvertUtil.convertToInteger(getSigitTImpiantoDao().getSeqTCodiceImpianto());
		} catch (SigitExtDaoException e) {
			log.error("Errore: ", e);
			throw new Exception();
		}
	}

	public DatiImpianto inserisciNuovoImpianto(DatiImpianto impianto, String descRuolo, UtenteLoggato utenteLoggato, Integer responsabilita) throws Exception {
		log.debug("[Inserisci nuovo impianto] BEGIN");
		try {
			BigDecimal idImpianto = null;
			String cfUtenteMod = utenteLoggato.getPfLoggato().getCodiceFiscalePF();

			if (GenericUtil.isNullOrEmpty(impianto.getCodiceImpianto())) {
				impianto.setCodiceImpianto(ConvertUtil.convertToString(getNextIdSeqCodiceImpianto()));
			}

			SigitTImpiantoPk impiantoPk = getSigitTImpiantoDao().insert(MapDto.mapToSigitTImpiantoDto(impianto, cfUtenteMod));
			idImpianto = impiantoPk.getCodiceImpianto();

			SigitTUnitaImmobiliarePk unitaImmobiliarePk = getSigitTUnitaImmobiliareDao().insert(MapDto.mapToSigitTUnitaImmobiliareDto(impianto, cfUtenteMod));

			BigDecimal idPersonaFisica = null;
			BigDecimal idPersonaGiuridica = null;
			if (descRuolo.equals(Constants.RUOLO_RESPONSABILE) || descRuolo.equals(Constants.RUOLO_PROPRIETARIO) || descRuolo.equals(Constants.RUOLO_ISPETTORE)
					|| descRuolo.equals(Constants.RUOLO_CONSULTATORE) || descRuolo.equals(Constants.RUOLO_SUPER) || descRuolo.equals(Constants.RUOLO_VALIDATORE)) {
				List<SigitTPersonaFisicaDto> personeFisiche = getSigitTPersonaFisicaDao().findByCodiceFiscale(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
				if (personeFisiche.size() == 1)
					idPersonaFisica = personeFisiche.get(0).getIdPersonaFisica();
				else if (personeFisiche.size() > 0) {
					log.error("Recuperate più persone fisiche con lo stesso codice fiscale");
					throw new SigitextException("Recuperate più persone fisiche con lo stesso codice fiscale");
				}
			} else {
				SigitTPersonaGiuridicaDto personaGiuridicaDto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(new BigDecimal(utenteLoggato.getRuoloLoggato()
						.getIdPersonaGiuridica())));
				if (personaGiuridicaDto != null)
					idPersonaGiuridica = personaGiuridicaDto.getIdPersonaGiuridica();
				else {
					log.error("nessuna persona giuridica trovata sul sistema");
					throw new SigitextException("nessuna persona giuridica trovata sul sistema");
				}

			}
			getSigitRImpRuoloPfpgDao().insert(MapDto.mapToSigitRImpRuoloPfpgDto(cfUtenteMod, idImpianto, idPersonaFisica, idPersonaGiuridica, Constants.ID_RUOLO_CARICATORE));
			if(responsabilita!=null) {
				getSigitRImpRuoloPfpgDao().insert(MapDto.mapToSigitRImpRuoloPfpgDto(cfUtenteMod, idImpianto, idPersonaFisica, idPersonaGiuridica, responsabilita));
			}
			if (responsabilita != null && (Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO == responsabilita || Constants.ID_RUOLO_PROPRIETARIO == responsabilita)) {
				if (responsabilita == Constants.ID_RUOLO_PROPRIETARIO) {
					getSigitRImpRuoloPfpgDao().insert(MapDto.mapToSigitRImpRuoloPfpgDto(cfUtenteMod, idImpianto, idPersonaFisica, idPersonaGiuridica, Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO));
				} else {
					getSigitRImpRuoloPfpgDao().insert(MapDto.mapToSigitRImpRuoloPfpgDto(cfUtenteMod, idImpianto, idPersonaFisica, idPersonaGiuridica, Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO_IMPRESA));
				}
			}
			return impianto;
		} catch (Exception e) {
			log.error("Errore inserimento impianto:", e);
			throw new Exception(e);
		}
	}

	public SigitTUnitaImmobiliareDto cercaSigitTUnitaImmobiliareByCodImpianto(String codImpianto) throws SigitextException {
		log.debug("[DbServiceImp::cercaSigitTUnitaImmobiliareByCodImpianto] BEGIN");
		try {

			SigitTUnitaImmobiliareDto unitaImmobiliareDto = null;
			List<SigitTUnitaImmobiliareDto> unitaImmobiliareDtoList = getSigitTUnitaImmobiliareDao().findUnitaPrincipaleImpianto(ConvertUtil.convertToInteger(codImpianto));

			if (unitaImmobiliareDtoList != null && unitaImmobiliareDtoList.size() == 1) {
				unitaImmobiliareDto = unitaImmobiliareDtoList.get(0);
			}

			return unitaImmobiliareDto;

		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaSigitTUnitaImmobiliareByCodImpianto] END");
		}
	}

	@Transactional
	public DatiImpianto updateImpianto(DatiImpianto impianto, String ruoloUtente, UtenteLoggato utenteLoggato) throws SigitextException {
		try {
			BigDecimal idImpianto = null;
			String cfUtenteMod = utenteLoggato.getPfLoggato().getCodiceFiscalePF();

			SigitTImpiantoDto impiantoDto = getImpiantoByCod(new BigDecimal(impianto.getCodiceImpianto()));
			// Sono in modifica
			getSigitTImpiantoDao().updateColumnsUpdateDatiOnline(MapDto.mapToSigitTImpiantoDto(impianto, cfUtenteMod));

			List<SigitTUnitaImmobiliareDto> unitaImmobiliareDto = getSigitTUnitaImmobiliareDao().findUnitaPrincipaleImpianto(Integer.parseInt(impianto.getCodiceImpianto()));
			if (GenericUtil.isNotNullOrEmpty(unitaImmobiliareDto)) {
				log.debug(unitaImmobiliareDto.size());
				getSigitTUnitaImmobiliareDao().updateColumnsDaOnline(MapDto.mapToSigitTUnitaImmobiliareDto(impianto, unitaImmobiliareDto.get(0), cfUtenteMod));
			}

			if (!impiantoDto.getFkStato().toString().equals(impianto.getStato()))
				getSigitTStoricoVariazStatoDao().insert(MapDto.mapToSigitTStoricoVariazStatoDto(impianto, impiantoDto, cfUtenteMod));

			return impianto;
		} catch (Exception e) {
			throw new SigitextException("Errore update impianto", e);
		}
	}

	public List<SigitVPfPgDto> cercaPersonaByCodiceFiscale(String codiceFiscale, boolean isImpresa) throws SigitextException {
		List<SigitVPfPgDto> dtoList = null;
		log.debug("[DbServiceImp::cercaPersonaByCodiceFiscale] BEGIN");
		try {

			CodiceReaAndFiscaleAndDenomFilter filter = new CodiceReaAndFiscaleAndDenomFilter();
			filter.setCodiceFiscale(codiceFiscale);
			filter.setIsImpresa(isImpresa);

			dtoList = getSigitVPfPgDao().findByCodiceFiscale(filter);

		} catch (Exception e) {
			log.debug("[DbServiceImp::cercaPersonaByCodiceFiscale] ERROR - ", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::cercaPersonaByCodiceFiscale] END");
		}
		return dtoList;
	}

	public Responsabile salvaResponsabile(Responsabile responsabile, String codiceImpianto, String cfUtenteMod) throws SigitextException {
		log.debug("[DbServiceImp::salvaResponsabile] BEGIN");
		try {

			if (!GenericUtil.isNullOrEmpty(responsabile.getIdResponsabile())) {
				FiltroRicercaPfPg filter = new FiltroRicercaPfPg();
				filter.setCodiceImpianto(codiceImpianto);
				if (responsabile.getFlgResponsabile()) {
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
				} else {
					if (responsabile.getFlgImpresa()) {
						filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO_IMPRESA));
						filter.setIdPersonaGiuridica(BigDecimal.valueOf(responsabile.getIdResponsabile()));
					} else {
						filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO));
						filter.setIdPersonaFisica(BigDecimal.valueOf(responsabile.getIdResponsabile()));
					}
				}
				List<SigitRImpRuoloPfpgDto> proprietariList = getSigitRImpRuoloPfpgDao().findAttiviByFilter(filter);
				log.debug("Proprietari list: " + proprietariList);
				if (proprietariList != null && proprietariList.size() != 0) {
					responsabile.setIdImpResp(proprietariList.get(0).getIdImpRuoloPfpg().intValue());
				}
			}

			if (GenericUtil.isNullOrEmpty(responsabile.getIdImpResp())) {
				Responsabile respoProprietario = null;
				boolean isProprietario = false;

				if (GenericUtil.isNullOrEmpty(responsabile.getIdResponsabile())) {
					if (responsabile.getFlgImpresa()) {
						SigitTPersonaGiuridicaPk personaGiuridica = getSigitTPersonaGiuridicaDao().insert(MapDto.mapToSigitTPersonaGiuridicaDto(responsabile, cfUtenteMod));
						responsabile.setIdResponsabile(ConvertUtil.convertToInteger(personaGiuridica.getIdPersonaGiuridica()));
					} else {
						SigitTPersonaFisicaPk personaFisica = getSigitTPersonaFisicaDao().insert(MapDto.mapToSigitTPersonaFisicaDto(responsabile, cfUtenteMod));
						responsabile.setIdResponsabile(ConvertUtil.convertToInteger(personaFisica.getIdPersonaFisica()));
					}
				} else {
					if (responsabile.getFlgImpresa()) {
						SigitTPersonaGiuridicaDto sigitTPersonaGiuridicaDto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(ConvertUtil.convertToBigDecimal(responsabile.getIdResponsabile())));
						getSigitTPersonaGiuridicaDao().update(MapDto.margeMapToSigitTPersonaGiuridicaDto(responsabile, sigitTPersonaGiuridicaDto, cfUtenteMod));
					} else {
						SigitTPersonaFisicaDto sigitTPersonaFisicaDto = getSigitTPersonaFisicaDao().findByPrimaryKey(new SigitTPersonaFisicaPk(ConvertUtil.convertToBigDecimal(responsabile.getIdResponsabile())));
						getSigitTPersonaFisicaDao().update(MapDto.margeMapToSigitTPersonaFisicaDto(responsabile, sigitTPersonaFisicaDto, cfUtenteMod));
					}
				}

				if (!ConvertUtil.convertToBooleanAllways(responsabile.getFlgResponsabile())) {
					int idRuoloProprietario = responsabile.getFlgImpresa() ? Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO_IMPRESA : Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO;
					responsabile.setIdTitolo(ConvertUtil.convertToString(idRuoloProprietario));
					isProprietario = true;
				} else {

					Responsabile responsabileTrovato = getResponsabileImpianto(codiceImpianto);

					// e' presente un vecchio proprietario da dismettere
					if (responsabileTrovato != null) {
						log.debug("Ho trovato un responsabile attivo");

						Date dataFine = DateUtil.getSqlDateMinusOneDay(ConvertUtil.convertToDate(responsabile.getDataInizioResp()));
						responsabileTrovato.setDataFineResp(ConvertUtil.convertToString(dataFine));
						cessaResponsabile(responsabileTrovato, cfUtenteMod);
						log.debug("Ho cessato il responsabile IdImpRuoloPfPg: " + responsabileTrovato.getIdImpResp());
					}

					int idRuolo = ConvertUtil.convertToInteger(responsabile.getIdTitolo());

					if (idRuolo == Constants.ID_RUOLO_PROPRIETARIO || idRuolo == Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO) {
						respoProprietario = new Responsabile();
						PropertyUtils.copyProperties(respoProprietario, responsabile);

						int idRuoloProprietario = 0;

						if (idRuolo == Constants.ID_RUOLO_PROPRIETARIO) {
							idRuoloProprietario = Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO;
						} else {
							idRuoloProprietario = Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO_IMPRESA;
						}

						respoProprietario.setIdTitolo(ConvertUtil.convertToString(idRuoloProprietario));
						respoProprietario.setFlgResponsabile(false);
						isProprietario = true;

					}
				}

				// Nel caso siamo in inserimento proprietario devo verificare che non ci sia gia' un proprietario attivo
				log.debug("Sto inserendo un proprietario? " + isProprietario);
				if (isProprietario) {
					Proprietario proprietario = getProprietarioImpianto(codiceImpianto);

					// e' presente un vecchio proprietario da dismettere
					if (proprietario != null) {
						log.debug("Ho trovato un proprietario attivo");

						Date dataFine = DateUtil.getSqlDateMinusOneDay(ConvertUtil.convertToDate(responsabile.getDataInizioResp()));
						proprietario.setDataFine(ConvertUtil.convertToString(dataFine));
						cessaProprietario(proprietario, cfUtenteMod);

						log.debug("Ho cessato il proprietario IdImpRuoloPfPg: " + proprietario.getIdImpRuoloPfPg());
					}

					if (respoProprietario != null) {
						log.debug("Sto inserendo un responsabile proprietario");
						getSigitRImpRuoloPfpgDao().insert(MapDto.mapToSigitRImpRuoloPfpgDto(respoProprietario, codiceImpianto, cfUtenteMod));
					}
				}

				log.debug("Sto inserendo effettivamente");
				SigitRImpRuoloPfpgPk impRuoloPfpgPk = getSigitRImpRuoloPfpgDao().insert(MapDto.mapToSigitRImpRuoloPfpgDto(responsabile, codiceImpianto, cfUtenteMod));
				log.debug(impRuoloPfpgPk);

				responsabile.setIdImpResp(ConvertUtil.convertToInteger(impRuoloPfpgPk.getIdImpRuoloPfpg()));
			} else {
				// Sono in modifica della persona
				if (responsabile.getFlgImpresa()) {
					SigitTPersonaGiuridicaDto sigitTPersonaGiuridicaDto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(ConvertUtil.convertToBigDecimal(responsabile.getIdResponsabile())));
					getSigitTPersonaGiuridicaDao().update(MapDto.margeMapToSigitTPersonaGiuridicaDto(responsabile, sigitTPersonaGiuridicaDto, cfUtenteMod));
				} else {
					SigitTPersonaFisicaDto sigitTPersonaFisicaDto = getSigitTPersonaFisicaDao().findByPrimaryKey(new SigitTPersonaFisicaPk(ConvertUtil.convertToBigDecimal(responsabile.getIdResponsabile())));
					getSigitTPersonaFisicaDao().update(MapDto.margeMapToSigitTPersonaFisicaDto(responsabile, sigitTPersonaFisicaDto, cfUtenteMod));
				}
				getSigitRImpRuoloPfpgDao().update(MapDto.mapToSigitRImpRuoloPfpgDto(responsabile, codiceImpianto, cfUtenteMod));

			}
			return responsabile;

		} catch (Exception e) {
			log.debug("[DbServiceImp::salvaResponsabile] error - ", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} finally {
			log.debug("[DbServiceImp::salvaResponsabile] END");
		}
	}

	public void cessaProprietario(Proprietario proprietario, String utenteUltMod) throws SigitextException {
		log.debug("[DbServiceImp::cessaProprietario] BEGIN");
		try {

			SigitRImpRuoloPfpgDto proprietarioDto = new SigitRImpRuoloPfpgDto();

			proprietarioDto.setIdImpRuoloPfpg(ConvertUtil.convertToBigDecimal(proprietario.getIdImpRuoloPfPg()));
			proprietarioDto.setDataFine(ConvertUtil.convertToSqlDate(proprietario.getDataFine()));

			proprietarioDto.setUtenteUltMod(utenteUltMod);
			proprietarioDto.setDataUltMod(DateUtil.getSqlDataCorrente());

			getSigitRImpRuoloPfpgDao().updateColumnsTerminaRiga(proprietarioDto);

		} catch (SigitRImpRuoloPfpgDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cessaProprietario] END");
		}
	}

	public void cessaResponsabile(Responsabile responsabile, String utenteUltMod) throws SigitextException {
		log.debug("[DbServiceImp::cessaProprietario] BEGIN");
		try {

			SigitRImpRuoloPfpgDto respDto = new SigitRImpRuoloPfpgDto();

			respDto.setIdImpRuoloPfpg(ConvertUtil.convertToBigDecimal(responsabile.getIdImpResp()));
			respDto.setDataFine(ConvertUtil.convertToSqlDate(responsabile.getDataFineResp()));

			respDto.setUtenteUltMod(utenteUltMod);
			respDto.setDataUltMod(DateUtil.getSqlDataCorrente());

			getSigitRImpRuoloPfpgDao().updateColumnsTerminaRiga(respDto);

		} catch (SigitRImpRuoloPfpgDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cessaProprietario] END");
		}
	}

	public Proprietario getProprietarioImpianto(String codiceImpianto) throws SigitextException {

		Proprietario proprietario = null;

		try {
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

				if (GenericUtil.isNotNullOrEmpty(proprietarioDto.getFkPersonaFisica())) {
					SigitTPersonaFisicaDto pfDto = cercaTPersonaFisicaById(ConvertUtil.convertToInteger(proprietarioDto.getFkPersonaFisica()));

					if (pfDto != null && GenericUtil.isNotNullOrEmpty(pfDto.getCognome())) {
						proprietario.setDenomCompleta(MapDto.costruisciCognomeNome(pfDto.getCognome(), pfDto.getNome()));
						proprietario.setIndirizzo(MapDto.getIndirizzoCompleto(pfDto.getComune(), pfDto.getIndirizzoSitad(), pfDto.getIndirizzoNonTrovato(), pfDto.getCivico(), pfDto.getSiglaProv()));
					}

				} else if (GenericUtil.isNotNullOrEmpty(proprietarioDto.getFkPersonaGiuridica())) {
					SigitTPersonaGiuridicaDto pgDto = cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(proprietarioDto.getFkPersonaGiuridica()));

					if (pgDto != null && GenericUtil.isNotNullOrEmpty(pgDto.getDenominazione())) {
						proprietario.setDenomCompleta(pgDto.getDenominazione());
						proprietario.setIndirizzo(MapDto.getIndirizzoCompleto(pgDto.getComune(), pgDto.getIndirizzoSitad(), pgDto.getIndirizzoNonTrovato(), pgDto.getCivico(), pgDto.getSiglaProv()));
					}
				}
			}
		} catch (SigitRImpRuoloPfpgDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} catch (SigitextException e) {
			throw e;
		}
		return proprietario;
	}

	public Responsabile getResponsabileImpianto(String codiceImpianto) throws SigitextException {

		Responsabile respo = null;

		try {
			FiltroRicercaPfPg filter = new FiltroRicercaPfPg();
			filter.setCodiceImpianto(codiceImpianto);
			filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE));
			filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE));
			filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO));
			filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_AMMINISTRATORE));
			filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_PROPRIETARIO));
			filter.addIdRuoloList(ConvertUtil.convertToString(Constants.ID_RUOLO_OCCUPANTE));

			List<SigitRImpRuoloPfpgDto> respoList;

			respoList = getSigitRImpRuoloPfpgDao().findAttiviByFilter(filter);

			if (respoList != null && !respoList.isEmpty()) {

				SigitRImpRuoloPfpgDto respoDto = respoList.get(0);

				respo = new Responsabile();

				respo.setIdImpResp(ConvertUtil.convertToInteger(respoDto.getIdImpRuoloPfpg()));
				respo.setDataInizioResp(ConvertUtil.convertToString(respoDto.getDataInizio()));

				if (GenericUtil.isNotNullOrEmpty(respoDto.getFkPersonaFisica())) {
					SigitTPersonaFisicaDto pfDto = cercaTPersonaFisicaById(ConvertUtil.convertToInteger(respoDto.getFkPersonaFisica()));

					if (pfDto != null && GenericUtil.isNotNullOrEmpty(pfDto.getCognome())) {
						respo.setDenomCompleta(MapDto.costruisciCognomeNome(pfDto.getCognome(), pfDto.getNome()));
						respo.setIndirizzo(MapDto.getIndirizzoCompleto(pfDto.getComune(), pfDto.getIndirizzoSitad(), pfDto.getIndirizzoNonTrovato(), pfDto.getCivico(), pfDto.getSiglaProv()));
					}

				} else if (GenericUtil.isNotNullOrEmpty(respoDto.getFkPersonaGiuridica())) {
					SigitTPersonaGiuridicaDto pgDto = cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(respoDto.getFkPersonaGiuridica()));

					if (pgDto != null && GenericUtil.isNotNullOrEmpty(pgDto.getDenominazione())) {
						respo.setDenomCompleta(pgDto.getDenominazione());
						respo.setIndirizzo(MapDto.getIndirizzoCompleto(pgDto.getComune(), pgDto.getIndirizzoSitad(), pgDto.getIndirizzoNonTrovato(), pgDto.getCivico(), pgDto.getSiglaProv()));
					}
				}
			}
		} catch (SigitRImpRuoloPfpgDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB, e);
		} catch (SigitextException e) {
			throw e;
		}
		return respo;
	}

	public SigitTPersonaFisicaDto cercaTPersonaFisicaById(Integer idPersonaF) throws SigitextException {
		SigitTPersonaFisicaDto dto = null;
		log.debug("[DbServiceImp::cercaTPersonaFisicaById] BEGIN");
		try {

			dto = getSigitTPersonaFisicaDao().findByPrimaryKey(new SigitTPersonaFisicaPk(ConvertUtil.convertToBigDecimal(idPersonaF)));

		} catch (SigitTPersonaFisicaDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaTPersonaFisicaById] END");
		}
		return dto;
	}

	public SigitTPersonaGiuridicaDto cercaTPersonaGiuridicaById(Integer idPersonaG) throws SigitextException {
		SigitTPersonaGiuridicaDto dto = null;
		log.debug("[DbServiceImp::cercaTPersonaGiuridicaById] BEGIN");
		try {

			dto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(ConvertUtil.convertToBigDecimal(idPersonaG)));

		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaTPersonaGiuridicaById] END");
		}
		return dto;
	}

	public List<SigitTCompGtCompletoDto> findCompGtByFilter(CompFilter filter) throws SigitextException {
		List<SigitTCompGtCompletoDto> dto = null;
		log.debug("[DbServiceImp::findCompGtByCodiceImpiantoProgressivo] BEGIN");
		try {
			dto = getSigitTCompGtDao().ricercaComponentiByFiltro(filter);
			log.debug(dto);
		} catch (SigitTCompGtDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::findCompGtByCodiceImpiantoProgressivo] END");
		}
		return dto;
	}

	public List<SigitTCompGfCompletoDto> findCompGfByFilter(CompFilter filter) throws SigitextException {
		List<SigitTCompGfCompletoDto> dto = null;
		log.debug("[DbServiceImp::findCompGfByFilter] BEGIN");
		try {
			dto = getSigitTCompGfDao().ricercaComponentiCompletoByFiltro(filter);
		} catch (SigitTCompGfDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::findCompGfByFilter] END");
		}
		return dto;
	}

	public List<SigitTCompScCompletoDto> findCompScByFilter(CompFilter filter) throws SigitextException {
		List<SigitTCompScCompletoDto> dto = null;
		log.debug("[DbServiceImp::findCompGfByFilter] BEGIN");
		try {
			dto = getSigitTCompScDao().ricercaComponentiCompletoByFiltro(filter);
		} catch (SigitTCompScDaoException e) {
			log.error("Errore recupero componenti SC: ", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::findCompGfByFilter] END");
		}
		return dto;
	}

	public List<SigitTCompCgCompletoDto> findCompCgByFilter(CompFilter filter) throws SigitextException {
		List<SigitTCompCgCompletoDto> dto = null;
		log.debug("[DbServiceImp::findCompCgByCodiceImpiantoProgressivo] BEGIN");
		try {
			dto = getSigitTCompCgDao().ricercaComponentiCompletoByFiltro(filter);
			log.debug(dto);
		} catch (SigitTCompCgDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::findCompCgByCodiceImpiantoProgressivo] END");
		}
		return dto;
	}

	public List<SigitRComp4ManutDto> findComp4ManutByFilter(CompFilter filter) throws SigitextException {
		List<SigitRComp4ManutDto> dto = null;
		log.debug("[DbServiceImp::findComp4ManutByFilter] BEGIN");
		try {
			dto = getSigitRComp4ManutDao().findByFilter(filter);
		} catch (SigitRComp4ManutDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::findComp4ManutByFilter] END");
		}
		return dto;
	}

	public void salvaAzioneComp4(SigitTComp4Pk comp4Pk, Date dataInstallCompAttiva, String cfUtente, String ruolo) throws SigitTComp4DaoException {

		//VIENE AGGIORNATA LA COMP4
		SigitTComp4Dto comp4 = aggiornaComp4DtControlloWeb(comp4Pk);

		if (Constants.RUOLO_VALIDATORE.equals(ruolo) || Constants.RUOLO_SUPER.equals(ruolo)) {
			SigitTAzioneComp4Dto azione = new SigitTAzioneComp4Dto();
			azione.setCfUtenteAzione(cfUtente);
			azione.setCodiceImpianto(comp4Pk.getCodiceImpianto());
			azione.setDescrizioneAzione("Dato aggiornato da utente " + ruolo);
			azione.setDtAzione(comp4.getDtControlloweb());
			azione.setDtInstall(new java.sql.Date(dataInstallCompAttiva.getTime()));
			azione.setIdTipoComponente(comp4Pk.getIdTipoComponente());
			azione.setProgressivo(comp4Pk.getProgressivo());

			getSigitTAzioneComp4Dao().insert(azione);
		}
	}

	public SigitTComp4Dto aggiornaComp4DtControlloWeb(SigitTComp4Pk comp4Pk) throws SigitTComp4DaoException {
		//VIENE AGGIORNATA LA COMP4
		SigitTComp4Dto comp4 = getSigitTComp4Dao().findByPrimaryKey(comp4Pk);
		comp4.setDtControlloweb(DateUtil.getSqlDataCorrente());
		getSigitTComp4Dao().update(comp4);
		return comp4;
	}

	public SigitTComp4Pk salvaComp4(BigDecimal codiceImpianto, BigDecimal progressivo, String idTipoComponente) throws SigitextException {
		SigitTComp4Pk pkComp4 = new SigitTComp4Pk();
		pkComp4.setCodiceImpianto(codiceImpianto);
		pkComp4.setIdTipoComponente(idTipoComponente);
		pkComp4.setProgressivo(progressivo);

		return salvaComp4(pkComp4);
	}

	private SigitTComp4Pk salvaComp4(SigitTComp4Pk pkComp4) throws SigitextException {
		try {
			// Vuol dire che sul db non esisteva questa componente (es. CS1)
			if (getSigitTComp4Dao().findByPrimaryKey(pkComp4) == null) {
				SigitTComp4Dto comp4 = MapDto.getSigitTComp4(pkComp4);
				pkComp4 = getSigitTComp4Dao().insert(comp4);
			}
		} catch (SigitTComp4DaoException e) {

			throw new SigitextException("");
		}
		return pkComp4;
	}

	public void insertComp4Manut(BigDecimal codImpianto, String tipoComponente, BigDecimal progressivo, Integer idPersonaGiuridica, String cfUtenteMod, Integer ruolo)
			throws SigitRComp4ManutDaoException {

		SigitRComp4ManutDto comp4ManutFilter = new SigitRComp4ManutDto();
		comp4ManutFilter.setCodiceImpianto(codImpianto);
		comp4ManutFilter.setIdTipoComponente(tipoComponente);
		comp4ManutFilter.setProgressivo(progressivo);

		List<SigitRComp4ManutDto> comp4ManutList = getSigitRComp4ManutDao().findAttiviByFilter(comp4ManutFilter);

		log.debug("STAMPO comp4ManutList: " + comp4ManutList);

		if (comp4ManutList == null || comp4ManutList.size() == 0) {
			SigitRComp4ManutDto comp4Manut = MapDto.getSigitRComp4Manut(codImpianto, tipoComponente, progressivo, ruolo, idPersonaGiuridica, cfUtenteMod);
			getSigitRComp4ManutDao().insert(comp4Manut);
		}
	}

	public void updateListComponentiGT(List<DatiGT> listToPersist, String codImpianto, String progressivo, String cfUtenteMod) throws SigitTCompGtDaoException {
		//viene recuperato lo stato dello storico presente sul db
		BigDecimal codImpiantoBigD = ConvertUtil.convertToBigDecimal(codImpianto);
		BigDecimal progressivoBigD = ConvertUtil.convertToBigDecimal(progressivo);

		List<SigitTCompGtCompletoDto> storicoPersisted = getSigitTCompGtDao().ricercaComponentiByFiltro(new CompFilter(Integer.parseInt(codImpianto), progressivo));

		if (storicoPersisted == null || storicoPersisted.isEmpty()) {
			log.debug("----------------STORICO PERSISTED NULL OR EMPTY----------------");
			//tutte le componenti nello storico sono da persistere
			if (listToPersist != null) {
				for (DatiGT compToPersist : listToPersist) {
					log.debug("----------------INSERT COMP TO PERSIST----------------");
					getSigitTCompGtDao().insert(MapDto.mapToSigitTCompGTDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
				}
			}
		} else {
			//costruisce una mappa in base alla data di installazione
			Map<String, SigitTCompGtCompletoDto> dizionarioCompDb = new HashMap<>();
			for (SigitTCompGtCompletoDto compDb : storicoPersisted) {
				log.debug("----------------creazione mappa----------------");
				log.debug("----------------" + ConvertUtil.convertToString(compDb.getDataInstall()) + "----------------");
				dizionarioCompDb.put(ConvertUtil.convertToString(compDb.getDataInstall()), compDb);
			}
			Set<String> persistedKeyToDelete = dizionarioCompDb.keySet(); //alla fine conterra' solo le chiavi che dovranno essere rimosse
			if (listToPersist != null) {
				log.info("------------------" + dizionarioCompDb.keySet() + "-----------------");
				for (DatiGT compToPersist : listToPersist) {
					if (dizionarioCompDb.get(ConvertUtil.convertToString(compToPersist.getDataInstall())) == null) {
						log.debug("----------------INSERISCO----------------");
						getSigitTCompGtDao().insert(MapDto.mapToSigitTCompGTDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
						persistedKeyToDelete.remove(ConvertUtil.convertToString(compToPersist.getDataInstall()));
					} else {
						//la componente era gia' stata persistita quindi viene eseguito un update
						log.debug("----------------UPDATE----------------");
						getSigitTCompGtDao().update(MapDto.mapToSigitTCompGTDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
						persistedKeyToDelete.remove(ConvertUtil.convertToString(compToPersist.getDataInstall()));
					}
				}
			}

			if (!persistedKeyToDelete.isEmpty()) {
				for (String keyToDelete : persistedKeyToDelete) {
					log.debug("----------------cancello----------------");
					log.debug("----------------" + keyToDelete + "----------------");
					SigitTCompGtPk pkToDelete = new SigitTCompGtPk(Constants.TIPO_COMPONENTE_GT, progressivoBigD, ConvertUtil.convertToSqlDate(keyToDelete), codImpiantoBigD);
					getSigitTCompGtDao().delete(pkToDelete);
				}
			}
		}
	}

	public void updateListComponentiGF(List<DatiGF> listToPersist, String codImpianto, String progressivo, String cfUtenteMod) throws SigitTCompGfDaoException {
		//viene recuperato lo stato dello storico presente sul db
		BigDecimal codImpiantoBigD = ConvertUtil.convertToBigDecimal(codImpianto);
		BigDecimal progressivoBigD = ConvertUtil.convertToBigDecimal(progressivo);

		List<SigitTCompGfCompletoDto> storicoPersisted = getSigitTCompGfDao().ricercaComponentiCompletoByFiltro(new CompFilter(Integer.parseInt(codImpianto), progressivo));

		if (storicoPersisted == null || storicoPersisted.isEmpty()) {
			log.debug("----------------STORICO PERSISTED NULL OR EMPTY----------------");
			//tutte le componenti nello storico sono da persistere
			if (listToPersist != null) {
				for (DatiGF compToPersist : listToPersist) {
					log.debug("----------------INSERT COMP TO PERSIST----------------");
					getSigitTCompGfDao().insert(MapDto.mapToSigitTCompGFDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
				}
			}
		} else {
			//costruisce una mappa in base alla data di installazione
			Map<String, SigitTCompGfCompletoDto> dizionarioCompDb = new HashMap<>();
			for (SigitTCompGfCompletoDto compDb : storicoPersisted) {
				log.debug("----------------creazione mappa----------------");
				log.debug("----------------" + ConvertUtil.convertToString(compDb.getDataInstall()) + "----------------");
				dizionarioCompDb.put(ConvertUtil.convertToString(compDb.getDataInstall()), compDb);
			}
			Set<String> persistedKeyToDelete = dizionarioCompDb.keySet(); //alla fine conterra' solo le chiavi che dovranno essere rimosse
			if (listToPersist != null) {
				log.info("------------------" + dizionarioCompDb.keySet() + "-----------------");
				for (DatiGF compToPersist : listToPersist) {
					if (dizionarioCompDb.get(ConvertUtil.convertToString(compToPersist.getDataInstall())) == null) {
						log.debug("----------------INSERISCO----------------");
						getSigitTCompGfDao().insert(MapDto.mapToSigitTCompGFDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
						persistedKeyToDelete.remove(ConvertUtil.convertToString(compToPersist.getDataInstall()));
					} else {
						//la componente era gia' stata persistita quindi viene eseguito un update
						log.debug("----------------UPDATE----------------");
						getSigitTCompGfDao().update(MapDto.mapToSigitTCompGFDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
						persistedKeyToDelete.remove(ConvertUtil.convertToString(compToPersist.getDataInstall()));
					}
				}
			}

			if (!persistedKeyToDelete.isEmpty()) {
				for (String keyToDelete : persistedKeyToDelete) {
					log.debug("----------------cancello----------------");
					log.debug("----------------" + keyToDelete + "----------------");
					SigitTCompGfPk pkToDelete = new SigitTCompGfPk(Constants.TIPO_COMPONENTE_GF, progressivoBigD, ConvertUtil.convertToSqlDate(keyToDelete), codImpiantoBigD);
					getSigitTCompGfDao().delete(pkToDelete);
				}
			}
		}
	}

	public void updateListComponentiSC(List<DatiSC> listToPersist, String codImpianto, String progressivo, String cfUtenteMod) throws SigitTCompScDaoException {
		//viene recuperato lo stato dello storico presente sul db
		BigDecimal codImpiantoBigD = ConvertUtil.convertToBigDecimal(codImpianto);
		BigDecimal progressivoBigD = ConvertUtil.convertToBigDecimal(progressivo);

		List<SigitTCompScCompletoDto> storicoPersisted = getSigitTCompScDao().ricercaComponentiCompletoByFiltro(new CompFilter(Integer.parseInt(codImpianto), progressivo));

		if (storicoPersisted == null || storicoPersisted.isEmpty()) {
			log.debug("----------------STORICO PERSISTED NULL OR EMPTY----------------");
			//tutte le componenti nello storico sono da persistere
			if (listToPersist != null) {
				for (DatiSC compToPersist : listToPersist) {
					log.debug("----------------INSERT COMP TO PERSIST----------------");
					getSigitTCompScDao().insert(MapDto.mapToSigitTCompSCDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
				}
			}
		} else {
			//costruisce una mappa in base alla data di installazione
			Map<String, SigitTCompScCompletoDto> dizionarioCompDb = new HashMap<>();
			for (SigitTCompScCompletoDto compDb : storicoPersisted) {
				log.debug("----------------creazione mappa----------------");
				log.debug("----------------" + ConvertUtil.convertToString(compDb.getDataInstall()) + "----------------");
				dizionarioCompDb.put(ConvertUtil.convertToString(compDb.getDataInstall()), compDb);
			}
			Set<String> persistedKeyToDelete = dizionarioCompDb.keySet(); //alla fine conterra' solo le chiavi che dovranno essere rimosse
			if (listToPersist != null) {
				log.info("------------------" + dizionarioCompDb.keySet() + "-----------------");
				for (DatiSC compToPersist : listToPersist) {
					if (dizionarioCompDb.get(ConvertUtil.convertToString(compToPersist.getDataInstall())) == null) {
						log.debug("----------------INSERISCO----------------");
						getSigitTCompScDao().insert(MapDto.mapToSigitTCompSCDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
						persistedKeyToDelete.remove(ConvertUtil.convertToString(compToPersist.getDataInstall()));
					} else {
						//la componente era gia' stata persistita quindi viene eseguito un update
						log.debug("----------------UPDATE----------------");
						getSigitTCompScDao().update(MapDto.mapToSigitTCompSCDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
						persistedKeyToDelete.remove(ConvertUtil.convertToString(compToPersist.getDataInstall()));
					}
				}
			}

			if (!persistedKeyToDelete.isEmpty()) {
				for (String keyToDelete : persistedKeyToDelete) {
					log.debug("----------------cancello----------------");
					log.debug("----------------" + keyToDelete + "----------------");
					SigitTCompScPk pkToDelete = new SigitTCompScPk(Constants.TIPO_COMPONENTE_SC, progressivoBigD, ConvertUtil.convertToSqlDate(keyToDelete), codImpiantoBigD);
					getSigitTCompScDao().delete(pkToDelete);
				}
			}
		}
	}

	public void updateListComponentiCG(List<DatiCG> listToPersist, String codImpianto, String progressivo, String cfUtenteMod) throws SigitTCompCgDaoException {
		//viene recuperato lo stato dello storico presente sul db
		BigDecimal codImpiantoBigD = ConvertUtil.convertToBigDecimal(codImpianto);
		BigDecimal progressivoBigD = ConvertUtil.convertToBigDecimal(progressivo);

		List<SigitTCompCgCompletoDto> storicoPersisted = getSigitTCompCgDao().ricercaComponentiCompletoByFiltro(new CompFilter(Integer.parseInt(codImpianto), progressivo));

		if (storicoPersisted == null || storicoPersisted.isEmpty()) {
			log.debug("----------------STORICO PERSISTED NULL OR EMPTY----------------");
			//tutte le componenti nello storico sono da persistere
			if (listToPersist != null) {
				for (DatiCG compToPersist : listToPersist) {
					log.debug("----------------INSERT COMP TO PERSIST----------------");
					getSigitTCompCgDao().insert(MapDto.mapToSigitTCompCGDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
				}
			}
		} else {
			//costruisce una mappa in base alla data di installazione
			Map<String, SigitTCompCgCompletoDto> dizionarioCompDb = new HashMap<>();
			for (SigitTCompCgCompletoDto compDb : storicoPersisted) {
				log.debug("----------------creazione mappa----------------");
				log.debug("----------------" + ConvertUtil.convertToString(compDb.getDataInstall()) + "----------------");
				dizionarioCompDb.put(ConvertUtil.convertToString(compDb.getDataInstall()), compDb);
			}
			Set<String> persistedKeyToDelete = dizionarioCompDb.keySet(); //alla fine conterra' solo le chiavi che dovranno essere rimosse
			if (listToPersist != null) {
				log.info("------------------" + dizionarioCompDb.keySet() + "-----------------");
				for (DatiCG compToPersist : listToPersist) {
					if (dizionarioCompDb.get(ConvertUtil.convertToString(compToPersist.getDataInstall())) == null) {
						log.debug("----------------INSERICGO----------------");
						getSigitTCompCgDao().insert(MapDto.mapToSigitTCompCGDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
						persistedKeyToDelete.remove(ConvertUtil.convertToString(compToPersist.getDataInstall()));
					} else {
						//la componente era gia' stata persistita quindi viene eseguito un update
						log.debug("----------------UPDATE----------------");
						getSigitTCompCgDao().update(MapDto.mapToSigitTCompCGDto(compToPersist, codImpiantoBigD, progressivoBigD, cfUtenteMod));
						persistedKeyToDelete.remove(ConvertUtil.convertToString(compToPersist.getDataInstall()));
					}
				}
			}

			if (!persistedKeyToDelete.isEmpty()) {
				for (String keyToDelete : persistedKeyToDelete) {
					log.debug("----------------cancello----------------");
					log.debug("----------------" + keyToDelete + "----------------");
					SigitTCompCgPk pkToDelete = new SigitTCompCgPk(Constants.TIPO_COMPONENTE_CG, progressivoBigD, ConvertUtil.convertToSqlDate(keyToDelete), codImpiantoBigD);
					getSigitTCompCgDao().delete(pkToDelete);
				}
			}
		}
	}

	public SigitRImpRuoloPfpgDto getInstallatoreImpianto(String codiceImpianto) throws SigitRImpRuoloPfpgDaoException {

		FiltroRicercaPfPg filter = new FiltroRicercaPfPg();
		filter.setCodiceImpianto(codiceImpianto);
		filter.setIdRuolo(ConvertUtil.convertToString(Constants.ID_RUOLO_CARICATORE));

		List<SigitRImpRuoloPfpgDto> installatoriList = getSigitRImpRuoloPfpgDao().findAttiviByFilter(filter);
		if (installatoriList != null && !installatoriList.isEmpty()) {
			return installatoriList.get(0);
		}
		return null;
	}

	public List<SigitRComp4ManutAllDto> cercaComp4ManutAllByComp(CompFilter filter) throws SigitextException {
		List<SigitRComp4ManutAllDto> dtoList = null;
		log.debug("[DbServiceImp::cercaComp4ManutAllByComp] BEGIN");
		try {

			dtoList = getSigitRComp4ManutAllDao().findByComp(filter);

		} catch (SigitRComp4ManutAllDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaComp4ManutAllByComp] END");
		}
		return dtoList;
	}

	public SigitTAllegatoDto cercaSigitTAllegatoById(BigDecimal idAllegato) throws SigitextException {
		SigitTAllegatoDto dto = null;
		log.debug("[DbServiceImp::cercaSigitTAllegatoById] BEGIN");
		try {
			dto = this.getSigitTAllegatoDao().findByPrimaryKey(new SigitTAllegatoPk(idAllegato));
		} catch (SigitTAllegatoDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {

			log.debug("[DbServiceImp::cercaSigitTAllegatoById] END");
		}
		return dto;
	}

	public void verificaBRRCByGT(String codiceImpiantoGT, String dataInstallazioneGT, String progressivoGT) throws SigitextException {
		log.debug("[DbServiceImp::verificaBRRCByGT] START");
		List<SigitTCompBrRcDto> listaDtos = cercaCompBRRCByGT(codiceImpiantoGT, progressivoGT, dataInstallazioneGT);

		if (listaDtos != null && listaDtos.size() > 0) {
			throw new SigitextException(Messages.S224_2);
		}
	}

	public List<SigitTCompBrRcDto> cercaCompBRRCByGT(String codImpianto, String progressivo, String dataInstallazione) throws SigitextException {
		List<SigitTCompBrRcDto> listaDb = null;
		log.debug("[DbServiceImp::cercaCompBRRCByGT] BEGIN");
		try {
			CompFilter filtroGT = new CompFilter();
			filtroGT.setCodImpianto(Integer.parseInt(codImpianto));
			filtroGT.setProgressivo(progressivo);
			filtroGT.setDataInstallazione(ConvertUtil.convertToSqlDate(dataInstallazione));
			listaDb = getSigitTCompBrRcDao().findBrRcLegateAGt(filtroGT);
			return listaDb;
		} catch (SigitTCompBrRcDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaCompBRRCByGT] END");
		}
	}

	public List<SigitVRicercaAllegatiDto> cercaControlliOrdinati(String codImpianto, String ordinamento, Integer numRighe) throws SigitextException {
		List<SigitVRicercaAllegatiDto> listaDb = null;
		log.debug("[DbServiceImp::cercaControlliOrdinati] BEGIN");
		try {
			listaDb = getSigitVRicercaAllegatiDao().findControlliByCodImpiantoOrdered(Integer.parseInt(codImpianto), ordinamento, numRighe);
			return listaDb;
		} catch (SigitVRicercaAllegatiDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaControlliOrdinati] END");
		}
	}

	@Transactional
	public void cancellaComponenteGT(Integer codiceImpianto, String progressivo, String tipoComponente, String cfUtente) throws SigitextException {
		log.debug("[DbServiceImp::cancellaComponenteGT] START");
		try {
			CompFilter compGt = new CompFilter();
			compGt.setCodImpianto(codiceImpianto);
			compGt.setProgressivo(progressivo);
			compGt.setTipoComponente(tipoComponente);
			List<SigitTComp4Dto> comp4 = getSigitTComp4Dao().findComponentiCancellate(compGt);
			getSigitTAzioneComp4Dao().customDeleterByComp4(new SigitTComp4Pk(ConvertUtil.convertToBigDecimal(codiceImpianto), Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToBigDecimal(progressivo)));
			getSigitTCompGtDao().delete(compGt);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_gt", "codice_impianto=" + codiceImpianto + "&progressivo=" + progressivo));
			cancellaListaComponentiGTAll(comp4, cfUtente);
		} catch (Exception e) {
			log.error("Errore: ", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new SigitextException(Messages.ERROR_INSERT_DB);
		} finally {
			log.debug("[DbServiceImp::cancellaComponenteGT] END");
		}
	}

	private void cancellaListaComponentiGTAll(List<SigitTComp4Dto> componentiCancellate, String cfUtente) throws SigitTComp4DaoException, SigitTCompGtDaoException, SigitRComp4ManutDaoException {
		if (componentiCancellate != null && !componentiCancellate.isEmpty()) {
			log.debug("ci sono sezioni da cancellare");
			for (SigitTComp4Dto compToDel : componentiCancellate) {
				getSigitTCompGtDao().customDeleterByFilter(MapDto.getCompFilter(compToDel));
				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_gt", "codice_impianto=" + compToDel.getCodiceImpianto() + "&progressivo=" + compToDel.getProgressivo()));
				getSigitRComp4ManutDao().customDeleterByFilter(MapDto.getSigitrComp4ManutPk(compToDel));
				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_r_comp4_manut",
						"codice_impianto=" + compToDel.getCodiceImpianto() + "&tipo=GT&&progressivo=" + compToDel.getProgressivo()));
				getSigitTComp4Dao().delete(MapDto.getSigittComp4Pk(compToDel));
				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
						"codice_impianto=" + compToDel.getCodiceImpianto() + "&tipi=GT&progressivo=" + compToDel.getProgressivo()));
			}
		} else
			log.debug("NON ci sono sezioni da cancellare");
	}

	@Transactional
	public void cancellaComponenteGF(Integer codiceImpianto, String progressivo, String tipoComponente, String cfUtente) throws SigitextException {
		log.debug("[DbServiceImp::cancellaComponenteGT] START");
		try {
			CompFilter compGt = new CompFilter();
			compGt.setCodImpianto(codiceImpianto);
			compGt.setProgressivo(progressivo);
			compGt.setTipoComponente(tipoComponente);
			List<SigitTComp4Dto> comp4 = getSigitTComp4Dao().findComponentiCancellate(compGt);
			getSigitTAzioneComp4Dao().customDeleterByComp4(new SigitTComp4Pk(ConvertUtil.convertToBigDecimal(codiceImpianto), Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(progressivo)));
			getSigitTCompGfDao().delete(compGt);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_gf", "codice_impianto=" + codiceImpianto + "&progressivo=" + progressivo));
			cancellaListaComponentiGFAll(comp4, cfUtente);
		} catch (Exception e) {
			log.error("Errore: ", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new SigitextException(Messages.ERROR_INSERT_DB);
		} finally {
			log.debug("[DbServiceImp::cancellaComponenteGT] END");
		}
	}

	private void cancellaListaComponentiGFAll(List<SigitTComp4Dto> componentiCancellate, String cfUtente) throws SigitTComp4DaoException, SigitRComp4ManutDaoException, SigitTCompGfDaoException {
		if (componentiCancellate != null && !componentiCancellate.isEmpty()) {
			log.debug("ci sono sezioni da cancellare");
			for (SigitTComp4Dto compToDel : componentiCancellate) {
				getSigitTCompGfDao().customDeleterByFilter(MapDto.getCompFilter(compToDel));
				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_gf", "codice_impianto=" + compToDel.getCodiceImpianto() + "&progressivo=" + compToDel.getProgressivo()));
				getSigitRComp4ManutDao().customDeleterByFilter(MapDto.getSigitrComp4ManutPk(compToDel));
				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_r_comp4_manut",
						"codice_impianto=" + compToDel.getCodiceImpianto() + "&tipo=" + compToDel.getIdTipoComponente() + "&&progressivo=" + compToDel.getProgressivo()));
				getSigitTComp4Dao().delete(MapDto.getSigittComp4Pk(compToDel));
				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
						"codice_impianto=" + compToDel.getCodiceImpianto() + "&tipi=" + compToDel.getIdTipoComponente() + "&progressivo=" + compToDel.getProgressivo()));
			}
		} else
			log.debug("NON ci sono sezioni da cancellare");
	}

	@Transactional
	public void cancellaComponenteSC(Integer codiceImpianto, String progressivo, String tipoComponente, String cfUtente) throws SigitextException {
		log.debug("[DbServiceImp::cancellaComponenteGT] START");
		try {
			CompFilter compGt = new CompFilter();
			compGt.setCodImpianto(codiceImpianto);
			compGt.setProgressivo(progressivo);
			compGt.setTipoComponente(tipoComponente);
			getSigitTCompScDao().delete(compGt);
			List<SigitTComp4Dto> comp4 = getSigitTComp4Dao().findComponentiCancellate(compGt);
			getSigitTAzioneComp4Dao().customDeleterByComp4(new SigitTComp4Pk(ConvertUtil.convertToBigDecimal(codiceImpianto), Constants.TIPO_COMPONENTE_SC, ConvertUtil.convertToBigDecimal(progressivo)));
			getSigitTCompScDao().delete(compGt);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_sc", "codice_impianto=" + codiceImpianto + "&progressivo=" + progressivo));
			cancellaListaComponentiSCAll(comp4, cfUtente);
		} catch (Exception e) {
			log.error("Errore: ", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new SigitextException(Messages.ERROR_INSERT_DB);
		} finally {
			log.debug("[DbServiceImp::cancellaComponenteGT] END");
		}
	}

	private void cancellaListaComponentiSCAll(List<SigitTComp4Dto> componentiCancellate, String cfUtente) throws SigitRComp4ManutDaoException, SigitTComp4DaoException, SigitTCompScDaoException {
		if (componentiCancellate != null && !componentiCancellate.isEmpty()) {
			log.debug("ci sono sezioni da cancellare");
			for (SigitTComp4Dto compToDel : componentiCancellate) {
				getSigitTCompScDao().customDeleterByFilter(MapDto.getCompFilter(compToDel));
				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_sc", "codice_impianto=" + compToDel.getCodiceImpianto() + "&progressivo=" + compToDel.getProgressivo()));
				getSigitRComp4ManutDao().customDeleterByFilter(MapDto.getSigitrComp4ManutPk(compToDel));
				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_r_comp4_manut",
						"codice_impianto=" + compToDel.getCodiceImpianto() + "&tipo=" + compToDel.getIdTipoComponente() + "&progressivo=" + compToDel.getProgressivo()));
				getSigitTComp4Dao().delete(MapDto.getSigittComp4Pk(compToDel));
				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
						"codice_impianto=" + compToDel.getCodiceImpianto() + "&tipi=" + compToDel.getIdTipoComponente() + "&progressivo=" + compToDel.getProgressivo()));
			}
		} else
			log.debug("NON ci sono sezioni da cancellare");
	}

	@Transactional
	public void cancellaComponenteCG(Integer codiceImpianto, String progressivo, String tipoComponente, String cfUtente) throws SigitextException {
		log.debug("[DbServiceImp::cancellaComponenteCg] START");
		try {
			CompFilter compCg = new CompFilter();
			compCg.setCodImpianto(codiceImpianto);
			compCg.setProgressivo(progressivo);
			compCg.setTipoComponente(tipoComponente);
			getSigitTCompCgDao().delete(compCg);
			List<SigitTComp4Dto> comp4 = getSigitTComp4Dao().findComponentiCancellate(compCg);
			getSigitTAzioneComp4Dao().customDeleterByComp4(new SigitTComp4Pk(ConvertUtil.convertToBigDecimal(codiceImpianto), Constants.TIPO_COMPONENTE_CG, ConvertUtil.convertToBigDecimal(progressivo)));
			getSigitTCompCgDao().delete(compCg);
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_cg", "codice_impianto=" + codiceImpianto + "&progressivo=" + progressivo));
			cancellaListaComponentiCGAll(comp4, cfUtente);
		} catch (Exception e) {
			log.error("Errore: ", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new SigitextException(Messages.ERROR_INSERT_DB);
		} finally {
			log.debug("[DbServiceImp::cancellaComponenteCg] END");
		}
	}

	private void cancellaListaComponentiCGAll(List<SigitTComp4Dto> componentiCancellate, String cfUtente) throws SigitRComp4ManutDaoException, SigitTComp4DaoException, SigitTCompCgDaoException {
		if (componentiCancellate != null && !componentiCancellate.isEmpty()) {
			log.debug("ci sono sezioni da cancellare");
			for (SigitTComp4Dto compToDel : componentiCancellate) {
				getSigitTCompCgDao().customDeleterByFilter(MapDto.getCompFilter(compToDel));
				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_cg", "codice_impianto=" + compToDel.getCodiceImpianto() + "&progressivo=" + compToDel.getProgressivo()));
				getSigitRComp4ManutDao().customDeleterByFilter(MapDto.getSigitrComp4ManutPk(compToDel));
				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_r_comp4_manut",
						"codice_impianto=" + compToDel.getCodiceImpianto() + "&tipo=" + compToDel.getIdTipoComponente() + "&progressivo=" + compToDel.getProgressivo()));
				getSigitTComp4Dao().delete(MapDto.getSigittComp4Pk(compToDel));
				getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp4",
						"codice_impianto=" + compToDel.getCodiceImpianto() + "&tipi=" + compToDel.getIdTipoComponente() + "&progressivo=" + compToDel.getProgressivo()));
			}
		} else
			log.debug("NON ci sono sezioni da cancellare");
	}

	public SigitVRicercaAllegatiDto cercaSigitVRicercaAllegatiByIdAllegato(String idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::cercaSigitVRicercaAllegatiByIdAllegato] BEGIN");
		SigitVRicercaAllegatiDto allegatoDto = null;
		try {
			List<SigitVRicercaAllegatiDto> allegatoDtoList = getSigitVRicercaAllegatiDao().findByIdAllegato(idAllegato);
			if (allegatoDtoList != null && allegatoDtoList.size() >= 1) {
				allegatoDto = allegatoDtoList.get(0);
			}
			return allegatoDto;
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaSigitVRicercaAllegatiByIdAllegato] END");
		}
	}

	public it.csi.sigit.sigitext.dto.sigitext.DettaglioIspezione getDettaglioIspezioneByIdIspezIspet(Integer idIspezIspet) throws SigitextException {
		log.debug("[DbServiceImp::getDettaglioIspezioneByIdIspezIspet] BEGIN");
		it.csi.sigit.sigitext.dto.sigitext.DettaglioIspezione ispezione = null;
		try {
			List<SigitVRicercaIspezioniDto> ispezioniList = getSigitVRicercaIspezioniDao().findByIdIspezIspet(idIspezIspet);
			SigitVRicercaIspezioniDto ispezioneDto = null;
			if (ispezioniList != null && ispezioniList.size() == 1) {
				ispezioneDto = ispezioniList.get(0);
				ispezione = MapDto.mapToDettaglioIspezione(ispezioneDto);
			}
		} catch (SigitVRicercaIspezioniDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::getDettaglioIspezioneByIdIspezIspet] END");
		}
		return ispezione;
	}

	public List<ControlloDisponibile> getControlliDisponibili(String codiceImpianto, String tipoComponente, String tipoControllo, Date dataControllo, Integer idPersonaGiuridica)
			throws SigitextException {
		log.debug("[DbServiceImp::getControlliDisponibili] BEGIN");
		List<ControlloDisponibile> controlloModelList = null;
		try {
			List<ControlloDisponibileDto> controlloDisponibile = getSigitTComp4Dao().getControlliDisponibili(codiceImpianto, tipoComponente, dataControllo, idPersonaGiuridica);
			if (controlloDisponibile != null) {
				controlloModelList = MapDto.mapToControlloDisponibile(controlloDisponibile, dataControllo, tipoControllo);
			}
		} catch (SigitTComp4DaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::getControlliDisponibili] END");
		}
		return controlloModelList;
	}

	public List<SigitVPfPgDto> cercaPersonaByCodiceReaAndFiscale(String siglaRea, BigDecimal numeroRea, String codiceFiscale, boolean isImpresa) throws SigitextException {
		List<SigitVPfPgDto> dtoList = null;
		log.debug("[DbServiceImp::cercaPersonaByCodiceReaAndFiscale] BEGIN");
		try {
			CodiceReaAndFiscaleAndDenomFilter filter = new CodiceReaAndFiscaleAndDenomFilter();
			filter.setSiglaRea(siglaRea);
			filter.setNumeroRea(numeroRea);
			filter.setCodiceFiscale(codiceFiscale);

			filter.setIsImpresa(isImpresa);

			dtoList = getSigitVPfPgDao().findByCodiceReaAndFiscale(filter);

		} catch (SigitVPfPgDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaPersonaByCodiceReaAndFiscale] END");
		}
		return dtoList;
	}

	public List<SigitDStelleDto> findAllStelle() throws SigitextException {
		log.debug("DbServiceImp::findAllStelle - START");
		try {
			return getSigitDStelleDao().findAll();
		} catch (Exception e) {
			log.error("Errore recupero dati dal DB: ", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("DbServiceImp::findAllStelle - END");
		}
	}

	public List<SigitDTipo1BDto> findSigitDTipo1BAll() throws SigitextException {
		log.debug("DbServiceImp::findSigitDTipo1BAll - START");
		try {
			return getSigitDTipo1BDao().findAll();
		} catch (Exception e) {
			log.error("Errore recupero dati dal DB: ", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("DbServiceImp::findSigitDTipo1BAll - END");
		}

	}

	public List<SigitDControlloAriaDto> findSigitDControlloAriaAll() throws SigitextException {
		log.debug("DbServiceImp::findSigitDControlloAriaAll - START");
		try {
			return getSigitDControlloAriaDao().findAll();
		} catch (Exception e) {
			log.error("Errore recupero dati dal DB: ", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("DbServiceImp::findSigitDControlloAriaAll - END");
		}
	}

	public List<SigitDAriaComburenteDto> findSigitDAriaComburenteAll() throws SigitextException {
		log.debug("DbServiceImp::findSigitDAriaComburenteAll - START");
		try {
			return getSigitDAriaComburenteDao().findAll();
		} catch (Exception e) {
			log.error("Errore recupero dati dal DB: ", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("DbServiceImp::findSigitDAriaComburenteAll - END");
		}
	}

	public SigitTComp4Dto cercaUltimoComponente(String codiceImpianto, String tipoComponente) throws SigitextException {
		log.debug("DbServiceImp::cercaUltimoComponente - START");
		SigitTComp4Dto last = null;
		try {
			List<SigitTComp4Dto> list = getSigitTComp4Dao().getAllOrderedByProgrDesc(codiceImpianto, tipoComponente);
			if (list != null && list.size() > 0) {
				last = list.get(0);
			}
		} catch (Exception e) {
			log.error("Errore recupero dati dal DB: ", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("DbServiceImp::cercaUltimoComponente - END");
		}
		return last;
	}

	public List<SigitTDocAllegatoDto> cercaElencoDocumentiPerIdAllegato(Integer idAllegato) throws SigitextException {
		List<SigitTDocAllegatoDto> dtoList = null;
		log.debug("[DbServiceImp::cercaElencoDocumentiPerIdAllegato] BEGIN");
		try {
			dtoList = this.getSigitTDocAllegatoDao().findByIdAllegato(idAllegato);
		} catch (SigitTDocAllegatoDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {

			log.debug("[DbServiceImp::cercaElencoDocumentiPerIdAllegato] END");
		}
		return dtoList;
	}

	public void eliminaAllegato(BigDecimal idAllegato, String cfUtenteMod) throws SigitextException {
		log.debug("[DbServiceImp::eliminaAllegato] BEGIN");
		try {
			eliminaDettaglioAllegato(idAllegato);
			getSigitRComp4ManutAllDao().customDeleterByIdAllegato(idAllegato);
			List<SigitTImportDto> importList = getSigitTImportDao().findByIdAllegato(idAllegato);
			if (importList != null && importList.size() > 0) {
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

		} catch (Exception e) {
			log.error("[DbServiceImp::eliminaAllegato] errore eliminazione allegato", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::eliminaAllegato] END");
		}
	}

	public void eliminaDettaglioAllegato(BigDecimal idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::eliminaDettaglioAllegato] BEGIN");
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

		} catch (Exception e) {
			log.error("[DbServiceImp::eliminaDettaglioAllegato] errore eliminazione allegato", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::eliminaDettaglioAllegato] END");
		}
	}

	public void salvaLogEliminaAllegato(String idAllegato, String cfUtenteMod) throws SigitextException {
		log.debug("[DbServiceImp::salvaLogEliminaAllegato] BEGIN");
		try {
			getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtenteMod, "sigit_t_allegato", "id_allegato = " + idAllegato));
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::salvaLogEliminaAllegato] END");
		}
	}

	public SigitTImportDistribRicevutaByIdImportDistribDto cercaImportRicevutaByIdDistr(Integer idImportDistrib) throws SigitextException {

		SigitTImportDistribRicevutaByIdImportDistribDto risImportDistrib = null;

		log.debug("[DbServiceImp::cercaImportRicevutaByIdDistr] BEGIN");
		try {

			List<SigitTImportDistribRicevutaByIdImportDistribDto> dtoList = getSigitTImportDistribDao().findRicevutaByIdImportDistrib(idImportDistrib);

			if (dtoList != null && dtoList.size() > 0) {
				// Ho fatto la riceca per chiave, quindi sicuramente ne trovera' uno solo
				risImportDistrib = dtoList.get(0);
			}

		} catch (SigitTImportDistribDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaImportRicevutaByIdDistr] END");
		}

		return risImportDistrib;
	}

	public DatiGTCommon getDettaglioAllegato1Common(DettaglioAllegato dettaglio) throws SigitextException {
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

			if (responsabile != null) {
				if (responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)) {
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				} else {
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica);
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToInteger(responsabile.getIdRuolo());
			}

			// Devo recupera tutti i progressivi per cui devo fare l'allegato
			List<SigitVSk4GtDto> dtoList = getCompGtByIdAllegato(ConvertUtil.convertToInteger(ConvertUtil.convertToString(dettaglio.getIdAllegato())));

			// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp2(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());

			SigitVRicerca3ResponsabileDto responsabile2 = null;
			if (list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty()) {
				responsabile2 = list3RespAttiviImpianto.get(0);
				isTerzoResp = true;

				SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
				pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
				pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				idRuolo = ConvertUtil.convertToInteger(responsabile.getIdRuolo());

			} else {
				//vTotImpianto = vTotImpiantoResp;
				pg = pgResp;
				idRuolo = idRuoloResp;

			}

			for (SigitVSk4GtDto sk4Gt : dtoList) {

				if (list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty()) {
					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(), Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToBigDecimal(sk4Gt.getProgressivo()), sk4Gt.getDataInstall(), null, responsabile2.getIdContratto());

				} else {
					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(), Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToBigDecimal(sk4Gt.getProgressivo()), sk4Gt.getDataInstall(), idImpRuoloPfpg, null);
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

		} catch (SigitTAllegatoDaoException | SigitTImpiantoDaoException | SigitTPersonaGiuridicaDaoException | SigitTPersonaFisicaDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		}

		return allegato1Common;
	}

	public SigitVTotImpiantoDto cercaResponsabileAttivoAllaDataImpianto(Integer codImpianto, java.sql.Date data) throws SigitextException {
		log.debug("[DbServiceImp:::cercaResponsabileAttivoAllaDataImpianto] START");
		SigitVTotImpiantoDto responsabile = null;
		ResponsabileFilter input = new ResponsabileFilter();
		input.setCodiceImpianto(codImpianto);
		input.setDataRapporto(data);
		List<SigitVTotImpiantoDto> listResp;
		try {
			listResp = getSigitVTotImpiantoDao().findResponsabiliAttiviAllaDataByCodiceImpianto(input);
			if (listResp != null && !listResp.isEmpty()) {
				responsabile = listResp.get(0);
			}
		} catch (SigitVTotImpiantoDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp:::cercaResponsabileAttivoAllaDataImpianto] END");
		}
		return responsabile;
	}

	public SigitTTrattH2ODto cercaSigitTTrattH2OByCodImpianto(BigDecimal codImpianto) throws SigitextException {
		log.debug("[DbServiceImp::cercaSigitTTrattH2OByCodImpianto] BEGIN");
		try {
			return getSigitTTrattH2ODao().findByPrimaryKey(new SigitTTrattH2OPk(codImpianto));
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaSigitTTrattH2OByCodImpianto] END");
		}
	}

	public List<SigitVSk4GtDto> getCompGtByIdAllegato(Integer idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::getCompGtByIdAllegato] START");
		try {
			return getSigitVSk4GtDao().findByIdAllegato(idAllegato);
		} catch (SigitVSk4GtDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::getCompGtByIdAllegato] END");
		}
	}

	public List<SigitVRicerca3ResponsabileDto> cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp2(String codImpianto, String dataRapporto) throws SigitextException {
		List<SigitVRicerca3ResponsabileDto> dtoList = null;
		log.debug("[DbServiceImp::cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp] BEGIN");
		try {
			ContrattoFilter filter = new ContrattoFilter();
			filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filter.setDataDal(ConvertUtil.convertToSqlDate(dataRapporto));

			dtoList = MapDto.convertToListTotImpianto(getSigitExtDao().findStoriaContrattiImpiantoNew(filter));
		} catch (SigitExtDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp] END");
		}
		return dtoList;
	}

	public void aggiornaRespRAllegatoComp(BigDecimal idAllegato, String codImpianto, String dataRapporto, String idTipoComponente, BigDecimal componente, java.sql.Date dataInstallazione, BigDecimal idImpRuoloPfPg, BigDecimal idContratto)
			throws SigitextException {
		log.debug("[DbServiceImp::aggiornaStatoTransazioneBoll] BEGIN");
		try {

			if (idTipoComponente.equals(Constants.TIPO_COMPONENTE_GT)) {
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
			} else if (idTipoComponente.equals(Constants.TIPO_COMPONENTE_GF)) {
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
			} else if (idTipoComponente.equals(Constants.TIPO_COMPONENTE_SC)) {
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
			} else if (idTipoComponente.equals(Constants.TIPO_COMPONENTE_CG)) {
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
		} catch (Exception e) {

			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::aggiornaStatoTransazioneBoll] END");
		}
	}

	public SigitTRappTipo1Dto cercaTRappTipo1ById(BigDecimal idAllegato) throws SigitextException {
		SigitTRappTipo1Dto dto = null;
		log.debug("[DbServiceImp::cercaTRappTipo1ById] BEGIN");
		try {
			dto = getSigitTRappTipo1Dao().findByPrimaryKey(new SigitTRappTipo1Pk(idAllegato));
		} catch (SigitTRappTipo1DaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaTRappTipo1ById] END");
		}
		return dto;
	}

	public List<SigitTDettTipo1Dto> getDettTipo1(String codImpianto, Integer progressivo, String idAllegato) throws SigitextException {

		log.debug("[DbServiceImp::getDettTipo1] BEGIN");

		List<SigitTDettTipo1Dto> dtoList = null;

		try {

			SigitTDettTipo1Dto dto = new SigitTDettTipo1Dto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));

			dtoList = getSigitTDettTipo1Dao().findByAllegatoCodImpianto(dto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::getDettTipo1] END");
		}

		return dtoList;
	}

	public DatiGFCommon getDettaglioAllegato2Common(DettaglioAllegato dettaglio) throws SigitextException {
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
			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()), ConvertUtil.convertToSqlDate(dettaglio.getDataControllo()));
			SigitTTrattH2ODto dettaglioTrattAcqua = cercaSigitTTrattH2OByCodImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			if (responsabile != null) {
				if (responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)) {
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				} else {
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica);
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToInteger(responsabile.getIdRuolo());
			}

			// Devo recupera tutti i progressivi per cui devo fare l'allegato
			List<SigitVSk4GfDto> dtoList = getCompGfByIdAllegato(dettaglio.getIdAllegato());

			// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp2(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());

			SigitVRicerca3ResponsabileDto responsabile2 = null;
			if (list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty()) {
				responsabile2 = list3RespAttiviImpianto.get(0);
				isTerzoResp = true;

				SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
				pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
				pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				idRuolo = ConvertUtil.convertToInteger(responsabile.getIdRuolo());

			} else {
				//vTotImpianto = vTotImpiantoResp;
				pg = pgResp;
				idRuolo = idRuoloResp;

			}

			for (SigitVSk4GfDto sk4Gf : dtoList) {

				if (list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty()) {
					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(), Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(sk4Gf.getProgressivo()), sk4Gf.getDataInstall(), null, responsabile2.getIdContratto());

				} else {
					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(), Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(sk4Gf.getProgressivo()), sk4Gf.getDataInstall(), idImpRuoloPfpg, null);
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

		} catch (SigitTAllegatoDaoException | SigitTImpiantoDaoException | SigitTPersonaGiuridicaDaoException | SigitTPersonaFisicaDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		}

		return allegato1Common;
	}

	public List<SigitVSk4GfDto> getCompGfByIdAllegato(Integer idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::getCompGfByIdAllegato] START");
		try {
			return getSigitVSk4GfDao().findByIdAllegato(idAllegato);
		} catch (SigitVSk4GfDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::getCompGfByIdAllegato] END");
		}
	}

	public SigitTDettTipo1Dto getDettTipo1(String codImpianto, Integer progressivo, String idAllegato, Integer numModulo) throws SigitextException {
		log.debug("[DbServiceImp::getDettTipo1] BEGIN");

		SigitTDettTipo1Dto dtoRes = null;
		try {
			List<SigitTDettTipo1Dto> dtoList = null;

			SigitTDettTipo1Dto dto = new SigitTDettTipo1Dto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));
			dto.setENModuloTermico(numModulo);

			dtoList = getSigitTDettTipo1Dao().findByAllegatoCodImpianto(dto);

			if (dtoList != null && dtoList.size() > 0) {
				dtoRes = dtoList.get(0);
			}

		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::getDettTipo1] END");
		}
		return dtoRes;
	}

	public List<SigitTConsumoTipo1BDto> findConsumiTipo1ByIdAllegato(BigDecimal idAllegato) throws SigitextException {
		SigitTConsumoTipo1BDto filter = new SigitTConsumoTipo1BDto();
		filter.setFkAllegato(idAllegato);
		return findConsumiTipo1ByFilter(filter);
	}

	public List<SigitTConsumoTipo1BDto> findConsumiTipo1ByIdAllegatoIdTipoConsumo(BigDecimal idAllegato, int idTipoConsumo) throws SigitextException {
		SigitTConsumoTipo1BDto filter = new SigitTConsumoTipo1BDto();
		filter.setFkAllegato(idAllegato);
		filter.setIdTipoConsumo1b(ConvertUtil.convertToBigDecimal(idTipoConsumo));
		return findConsumiTipo1ByFilter(filter);
	}

	public List<SigitTConsumoTipo1BDto> findConsumiTipo1ByFilter(SigitTConsumoTipo1BDto filter) throws SigitextException {
		log.debug("DbServiceImp::findConsumiTipo1ByFilter - START");
		try {
			return getSigitTConsumoTipo1BDao().findByFilter(filter);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("DbServiceImp::findConsumiTipo1ByFilter - END");
		}
	}

	public List<SigitTDettTipo2Dto> getDettTipo2(String codImpianto, Integer progressivo, String idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::getDettTipo2] BEGIN");

		List<SigitTDettTipo2Dto> dtoList = null;

		try {

			SigitTDettTipo2Dto dto = new SigitTDettTipo2Dto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));
			//dto.setENCircuito(numCircuito);

			dtoList = getSigitTDettTipo2Dao().findByAllegatoCodImpianto(dto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::getDettTipo2] END");
		}

		return dtoList;
	}

	public SigitTDettTipo2Dto getDettTipo2(String codImpianto, Integer progressivo, String idAllegato, String numCircuito) throws SigitextException {
		log.debug("[DbServiceImp::getDettTipo2] BEGIN");

		SigitTDettTipo2Dto dtoRes = null;
		try {
			List<SigitTDettTipo2Dto> dtoList = null;

			SigitTDettTipo2Dto dto = new SigitTDettTipo2Dto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));
			dto.setENCircuito(numCircuito);

			dtoList = getSigitTDettTipo2Dao().findByAllegatoCodImpianto(dto);

			if (dtoList != null && dtoList.size() > 0) {
				dtoRes = dtoList.get(0);
			}
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::getDettTipo2] END");
		}

		return dtoRes;
	}

	public DatiSCCommon getDettaglioAllegato3Common(DettaglioAllegato dettaglio) throws SigitextException {
		DatiSCCommon allegato3Common = new DatiSCCommon();
		try {
			SigitTAllegatoDto allegatoDto = null;
			SigitTImpiantoDto impiantoDto = null;
			List<SigitTUnitaImmobiliareDto> unitaImmobiliareList = null;
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
			unitaImmobiliareList = this.getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()));
			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto()), ConvertUtil.convertToSqlDate(dettaglio.getDataControllo()));
			SigitTTrattH2ODto dettaglioTrattAcqua = cercaSigitTTrattH2OByCodImpianto(new BigDecimal(dettaglio.getCodiceImpianto()));

			if (responsabile != null) {
				if (responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)) {
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				} else {
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica);
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToInteger(responsabile.getIdRuolo());
			}

			// Devo recupera tutti i progressivi per cui devo fare l'allegato
			List<SigitVSk4ScDto> dtoList = getCompScByIdAllegato(ConvertUtil.convertToInteger(ConvertUtil.convertToString(dettaglio.getIdAllegato())));

			// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp2(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());

			SigitVRicerca3ResponsabileDto responsabile2 = null;
			if (list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty()) {
				responsabile2 = list3RespAttiviImpianto.get(0);
				isTerzoResp = true;

				SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
				pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
				pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				idRuolo = ConvertUtil.convertToInteger(responsabile.getIdRuolo());

			} else {
				//vTotImpianto = vTotImpiantoResp;
				pg = pgResp;
				idRuolo = idRuoloResp;

			}

			for (SigitVSk4ScDto sk4Sc : dtoList) {

				if (list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty()) {
					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(), Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(sk4Sc.getProgressivo()), sk4Sc.getDataInstall(), null, responsabile2.getIdContratto());

				} else {
					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(), Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(sk4Sc.getProgressivo()), sk4Sc.getDataInstall(), idImpRuoloPfpg, null);
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

		} catch (SigitTAllegatoDaoException | SigitTImpiantoDaoException | SigitTPersonaGiuridicaDaoException | SigitTPersonaFisicaDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		}

		return allegato3Common;
	}

	public DatiCGCommon getDettaglioAllegato4Common(DettaglioAllegato dettaglio) throws SigitextException {
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

			if (responsabile != null) {
				if (responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)) {
					//e' una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					pgResp = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				} else {
					//e' una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					pf = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica);
				}

				idImpRuoloPfpg = responsabile.getIdImpRuoloPfpg();
				idRuoloResp = ConvertUtil.convertToInteger(responsabile.getIdRuolo());
			}
			List<SigitVSk4CgDto> dtoList = getCompCgByIdAllegato(ConvertUtil.convertToInteger(ConvertUtil.convertToString(dettaglio.getIdAllegato())));

			for (SigitVSk4CgDto sk4Cg : dtoList) {

				List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp2(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());
				if (list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty()) {
					SigitVRicerca3ResponsabileDto responsabile2 = list3RespAttiviImpianto.get(0);
					isTerzoResp = true;

					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile2.getFkPg3Resp());
					pg = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
					idRuolo = ConvertUtil.convertToInteger(responsabile.getIdRuolo());

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(), Constants.TIPO_COMPONENTE_CG, ConvertUtil.convertToBigDecimal(sk4Cg.getProgressivo()), sk4Cg.getDataInstall(), null, responsabile2.getIdContratto());
				} else {
					pg = pgResp;
					idRuolo = idRuoloResp;

					aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), dettaglio.getCodiceImpianto(), dettaglio.getDataControllo(), Constants.TIPO_COMPONENTE_CG, ConvertUtil.convertToBigDecimal(sk4Cg.getProgressivo()), sk4Cg.getDataInstall(), idImpRuoloPfpg, null);
				}

				log.debug("idRuolo: " + idRuolo);

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

		} catch (SigitTAllegatoDaoException | SigitTImpiantoDaoException | SigitTPersonaGiuridicaDaoException | SigitTPersonaFisicaDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		}
		return allegato4Common;
	}

	public SigitTRappTipo3Dto cercaTRappTipo3ById(BigDecimal idAllegato) throws SigitextException {
		SigitTRappTipo3Dto dto = null;
		log.debug("[DbServiceImp::cercaTRappTipo3ById] BEGIN");
		try {
			dto = getSigitTRappTipo3Dao().findByPrimaryKey(new SigitTRappTipo3Pk(idAllegato));
		} catch (SigitTRappTipo3DaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaTRappTipo3ById] END");
		}
		return dto;
	}

	public SigitVSk4ScDto getCompScByIdAllegatoProgr(Integer idAllegato, String progressivo) throws SigitextException {
		SigitVSk4ScDto dto = null;
		log.debug("[DbServiceImp::getCompScByIdAllegatoProgr] BEGIN");
		try {
			CompFilter input = new CompFilter();
			input.setIdAllegato(idAllegato);
			input.setProgressivo(progressivo);

			List<SigitVSk4ScDto> gtList = getSigitVSk4ScDao().findByIdAllegatoProgr(input);
			if (gtList != null && gtList.size() > 0) {
				dto = gtList.get(0);
			}
		} catch (SigitVSk4ScDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::getCompScByIdAllegatoProgr] END");
		}
		return dto;
	}

	public List<SigitVSk4ScDto> getCompScByIdAllegato(Integer idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::getCompScByIdAllegato] START");
		try {
			return getSigitVSk4ScDao().findByIdAllegato(idAllegato);
		} catch (SigitVSk4ScDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::getCompScByIdAllegato] END");
		}
	}

	public List<SigitVSk4CgDto> getCompCgByIdAllegato(Integer idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::getCompCgByIdAllegato] START");
		try {
			return getSigitVSk4CgDao().findByIdAllegato(idAllegato);
		} catch (SigitVSk4CgDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::getCompCgByIdAllegato] END");
		}
	}

	public List<SigitTDettTipo3Dto> getDettTipo3(String codImpianto, Integer progressivo, String idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::getDettTipo3] BEGIN");
		List<SigitTDettTipo3Dto> dtoList = null;
		try {
			SigitTDettTipo3Dto dto = new SigitTDettTipo3Dto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));
			dtoList = getSigitTDettTipo3Dao().findByAllegatoCodImpianto(dto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::getDettTipo3] END");
		}
		return dtoList;
	}

	public List<SigitTDettTipo4Dto> getDettTipo4(String codImpianto, Integer progressivo, String idAllegato) throws SigitextException {
		log.debug("[DbServiceImp::getDettTipo4] BEGIN");
		List<SigitTDettTipo4Dto> dtoList = null;
		try {
			SigitTDettTipo4Dto dto = new SigitTDettTipo4Dto();
			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));
			dtoList = getSigitTDettTipo4Dao().findByAllegatoCodImpianto(dto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::getDettTipo4] END");
		}
		return dtoList;
	}

	public SigitDFluidoDto getFluidoById(Integer idFluido) throws SigitextException {
		log.debug("[DbServiceImp::getFluidoById] START");
		try {
			return getSigitDFluidoDao().findByPrimaryKey(new SigitDFluidoPk(ConvertUtil.convertToBigDecimal(idFluido)));
		} catch (SigitDFluidoDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::getFluidoById] END");
		}
	}

	public SigitTRappTipo4Dto cercaTRappTipo4ById(BigDecimal idAllegato) throws SigitextException {
		SigitTRappTipo4Dto dto = null;
		log.debug("[DbServiceImp::cercaTRappTipo4ById] BEGIN");
		try {
			dto = getSigitTRappTipo4Dao().findByPrimaryKey(new SigitTRappTipo4Pk(idAllegato));
		} catch (SigitTRappTipo4DaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaTRappTipo4ById] END");
		}
		return dto;
	}

	public SigitDUnitaMisuraDto getUnitaMisuraById(Integer idUnitaMisura) throws SigitextException {
		log.debug("[DbServiceImp::getUnitaMisuraById] START");
		try {
			return getSigitDUnitaMisuraDao().findByPrimaryKey(new SigitDUnitaMisuraPk(ConvertUtil.convertToString(idUnitaMisura)));
		} catch (SigitDUnitaMisuraDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::getUnitaMisuraById] END");
		}
	}

	public String cercaConfigValueCarattere(String chiave) throws SigitextException {
		SigitWrkConfigDto dto = null;
		log.debug("[DbServiceImp::cercaConfigValueCarattere] BEGIN");
		log.debug("[DbServiceImp::cercaConfigValueCarattere] chiave: " + chiave);
		dto = cercaConfigValue(chiave);
		log.debug("[DbServiceImp::cercaConfigValueCarattere] dto.getValoreConfigChar(): " + dto.getValoreConfigChar());
		log.debug("[DbServiceImp::cercaConfigValueCarattere] END");
		return dto.getValoreConfigChar();
	}

	public SigitVRicercaImpiantiDto cercaImpiantoByCodImpianto(BigDecimal codImpianto) throws SigitextException {

		log.debug("[DbServiceImp::cercaImpiantoByCodImpianto] BEGIN");
		SigitVRicercaImpiantiDto dto = null;
		try {
			ImpiantoFilter filter = new ImpiantoFilter();
			filter.setCodiceImpianto(ConvertUtil.convertToInteger(codImpianto));
			List<SigitVRicercaImpiantiDto> dtoList = getSigitVRicercaImpiantiDao().findByImpiantoFilter(filter);

			if (dtoList != null && dtoList.size() > 0) {
				dto = dtoList.get(0);
			}
		} catch (SigitVRicercaImpiantiDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaImpiantoByCodImpianto] END");
		}
		return dto;
	}

	public PersonaFisica cercaPersonaFisicaById(Integer idPersonaF) throws SigitextException {
		PersonaFisica obj = null;
		SigitTPersonaFisicaDto dto = null;
		log.debug("[DbServiceImp::cercaPersonaFisicaById] BEGIN");
		try {

			//dto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(ConvertUtil.convertToBigDecimal(idPersonaG)));
			dto = cercaTPersonaFisicaById2(idPersonaF);

			obj = MapDto.mapToPersonaFisica(dto);

		} finally {
			log.debug("[DbServiceImp::cercaPersonaFisicaById] END");
		}
		return obj;
	}

	public void aggiornaImpiantoSblocca3R(String codiceImpianto, String cfUtenteMod, boolean blocca) throws SigitextException {
		log.debug("[DbServiceImp::aggiornaImpiantoSblocca3R] BEGIN");
		try {
			SigitTImpiantoDto impianto = new SigitTImpiantoDto();
			impianto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
			impianto.setDataUltMod(DateUtil.getSqlDataCorrente());
			impianto.setUtenteUltMod(cfUtenteMod);
			impianto.setFlgBloccoNomina3r(ConvertUtil.convertToBigDecimal(blocca));
			getSigitTImpiantoDao().updateColumnsUpdateBloccoNomina3R(impianto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::aggiornaImpiantoSblocca3R] END");
		}
	}

	public String cercaIndirizzoMailAbilitazioneValidatore(String istatAbilitazione, int idRuloPa) throws SigitextException {
		log.debug("[DbAzioneMgr::cercaIndirizzoMailAbilitazioneValidatore] BEGIN");
		try {
			String mail = null;

			SigitTAbilitazioneDto filter = new SigitTAbilitazioneDto();
			filter.setIdRuoloPa(idRuloPa);
			filter.setIstatAbilitazione(Constants.COD_ISTAT_PIEMONTE + istatAbilitazione);
			List<SigitTAbilitazioneDto> abilitazioni = getSigitTAbilitazioneDao().findByExample(filter);
			if (abilitazioni != null && !abilitazioni.isEmpty() && abilitazioni.get(0) != null && abilitazioni.get(0).getMailComunicazione() != null) {
				mail = abilitazioni.get(0).getMailComunicazione();
			}
			return mail;
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbAzioneMgr::cercaIndirizzoMailAbilitazioneValidatore] END");
		}

	}

	public List<SigitTDocAggiuntivaDto> cercaDocumentoAggDerogaByCodImpianto(BigDecimal codImpianto) throws SigitextException {
		log.debug("[DbServiceImp::cercaDocumentoAggDerogaByCodImpianto] BEGIN");
		try {
			SigitTDocAggiuntivaDto filter = new SigitTDocAggiuntivaDto();
			filter.setCodiceImpianto(codImpianto);
			filter.setFkTipoDocagg(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_DOC_DEROGA));
			return getSigitTDocAggiuntivaDao().findByCodImpIdTipoDocAgg(filter);
		} catch (Exception e) {
			log.error("[DbServiceImp::cercaDocumentoAggDerogaByCodImpianto] ERRORE: ", e);
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaDocumentoAggDerogaByCodImpianto] END");
		}
	}

	public SigitTPersonaFisicaDto cercaTPersonaFisicaById2(Integer idPersonaF) throws SigitextException {
		SigitTPersonaFisicaDto dto = null;
		log.debug("[DbServiceImp::cercaTPersonaFisicaById] BEGIN");
		try {
			dto = getSigitTPersonaFisicaDao().findByPrimaryKey(new SigitTPersonaFisicaPk(ConvertUtil.convertToBigDecimal(idPersonaF)));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaTPersonaFisicaById] END");
		}
		return dto;
	}

	public SigitTLibrettoDto cercaSigitTLibrettoConsolidatoByCodImpianto(String codImpianto) throws SigitextException {
		log.debug("[DbServiceImp::cercaSigitTLibrettoByCodImpianto] BEGIN");
		try {
			SigitTLibrettoDto librettoDto = null;
			List<SigitTLibrettoDto> librettoDtoList = cercaLibrettoByStato(ConvertUtil.convertToInteger(codImpianto), Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			if (librettoDtoList != null && librettoDtoList.size() >= 1) {
				librettoDto = librettoDtoList.get(0);
			} else {
				List<SigitSLibrettoDto> librettoSDtoList = getSigitSLibrettoDao().findByLibrettoFilter(new LibrettoFilter(ConvertUtil.convertToInteger(codImpianto), Constants.ID_STATO_LIBRETTO_CONSOLIDATO));
				if (librettoSDtoList != null && librettoSDtoList.size() >= 1) {
					librettoDto = MapDto.mapToSigitTLibrettoDto(librettoSDtoList.get(0));
				}
			}
			return librettoDto;
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaSigitTLibrettoByCodImpianto] END");
		}
	}

	public SigitTControlloLibrettoDto findControlloLibretto(String codiceImpianto) throws SigitextException {
		log.debug("[DbServiceImp::findControlloLibretto] BEGIN");
		SigitTControlloLibrettoDto controlloLibDto = null;
		try {
			controlloLibDto = getSigitTControlloLibrettoDao().findByPrimaryKey(new SigitTControlloLibrettoPk(ConvertUtil.convertToBigDecimal(codiceImpianto)));
			if (controlloLibDto == null) {
				controlloLibDto = new SigitTControlloLibrettoDto();
			}
		} catch (SigitTControlloLibrettoDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::findControlloLibretto] END");
		}
		return controlloLibDto;
	}

	public List<SigitTComp4Dto> cercaTComp4NonControllateByCodImp(String codiceImpianto) throws SigitextException {
		List<SigitTComp4Dto> dtoList = null;
		log.debug("[DbServiceImp::cercaTComp4NonControllateByCodImp] BEGIN");
		try {
			dtoList = getSigitTComp4Dao().findNonControllateByCodImp(ConvertUtil.convertToInteger(codiceImpianto));
		} catch (SigitTComp4DaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaTComp4NonControllateByCodImp] END");
		}
		return dtoList;
	}

	public List<SigitVAllegatiComponentiDto> cercaAllegatiByFilterAttivoByCodImpianto(String codImpianto, Integer idRuoloPfpg) throws SigitextException {
		List<SigitVAllegatiComponentiDto> dtoList = null;
		log.debug("[DbServiceImp::cerca3RespAllCompByFilterAttivoByCodImpianto] BEGIN");
		try {
			AllegatiCompFilter filter = new AllegatiCompFilter(codImpianto, idRuoloPfpg);
			dtoList = getSigitVAllegatiComponentiDao().findAllegatiByFilter(filter);
		} catch (SigitVAllegatiComponentiDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cerca3RespAllCompByFilterAttivoByCodImpianto] END");
		}
		return dtoList;
	}

	public List<SigitTContratto2019Dto> cercaContrattiByImpRuoloPfpg(String codiceImpianto, Integer idImpResp) throws SigitextException {
		List<SigitTContratto2019Dto> dtoList = null;
		log.debug("[DbServiceImp::cercaContrattiByImpRuoloPfpg] BEGIN");
		try {
			PersonaRuoloFilter filter = new PersonaRuoloFilter();
			filter.setIdResponsabile(idImpResp);
			;
			filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
			dtoList = getSigitTContratto2019Dao().findByIdResponsabile(filter);
		} catch (SigitTContratto2019DaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbServiceImp::cercaContrattiByImpRuoloPfpg] END");
		}

		return dtoList;
	}
}

