/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.manager;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter.BollinoFilter;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter.CodiceReaAndFiscaleFilter;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter.CompFilter;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter.ContrattoFilter;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter.LibrettoFilter;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter.ResponsabileFilter;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter.TransazioneFilter;
import it.csi.sigit.sigitbatchn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitbatchn.business.manager.util.ManagerException;
import it.csi.sigit.sigitbatchn.business.manager.util.Message;
import it.csi.sigit.sigitbatchn.business.manager.util.Messages;
import it.csi.sigit.sigitbatchn.business.manager.util.ServiceException;
import it.csi.sigit.sigitbatchn.business.util.Constants;
import it.csi.sigit.sigitbatchn.business.util.ConvertUtil;
import it.csi.sigit.sigitbatchn.business.util.DateUtil;
import it.csi.sigit.sigitbatchn.business.util.GenericUtil;
import it.csi.sigit.sigitbatchn.business.util.InputAllegatiComp;
import it.csi.sigit.sigitbatchn.business.util.MapDto;
//import it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument;
//import it.csi.sigit.sigitwebn.xml.allegato2.data.RowAllegatoIIDocument.RowAllegatoII;
import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.DatiFornituraCliente;
import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.EstremiCatastali;
//import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.DatiFornituraClienteDocument.DatiFornituraCliente;
//import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.EstremiCatastaliDocument.EstremiCatastali;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoCombuDocument.DatiConsumoCombu;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoEEDocument.DatiConsumoEE;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoH2ODocument.DatiConsumoH2O;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoProdottiChimiciDocument.DatiConsumoProdottiChimici;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiPrecompilatiDocument.DatiPrecompilati;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiPrecompilatiDocument.DatiPrecompilati.SezNomine;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaIdentificativaImpDocument.DatiSchedaIdentificativaImp;
import it.csi.sigit.sigitwebn.xml.libretto.data.MODDocument;
import it.csi.sigit.sigitwebn.xml.libretto.data.RichiestaDocument.Richiesta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import weblogic.messaging.common.IDFactory;

/**
 * Manager del DB
 *
 * @author 70140
 */
public class DbMgr {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");

	// Definizione dei DAO

	/**
	 * DAO per accedere alla tabella SIGIT_T_IMPORT
	 */
	private SigitTImportDao sigitTImportDao = null;

	public SigitTImportDao getSigitTImportDao() {
		return sigitTImportDao;
	}

	public void setSigitTImportDao(SigitTImportDao sigitTImportDao) {
		this.sigitTImportDao = sigitTImportDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_IMP_XML
	 */
	private SigitTImpXmlDao sigitTImpXmlDao = null;

	public SigitTImpXmlDao getSigitTImpXmlDao() {
		return sigitTImpXmlDao;
	}

	public void setSigitTImpXmlDao(SigitTImpXmlDao sigitTImpXmlDao) {
		this.sigitTImpXmlDao = sigitTImpXmlDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_PERSONA_FISICA
	 */
	private SigitTPersonaFisicaDao sigitTPersonaFisicaDao = null;

	public SigitTPersonaFisicaDao getSigitTPersonaFisicaDao() {
		return sigitTPersonaFisicaDao;
	}

	public void setSigitTPersonaFisicaDao(SigitTPersonaFisicaDao sigitTPersonaFisicaDao) {
		this.sigitTPersonaFisicaDao = sigitTPersonaFisicaDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_PERSONA_GIURIDICA
	 */
	private SigitTPersonaGiuridicaDao sigitTPersonaGiuridicaDao = null;

	public SigitTPersonaGiuridicaDao getSigitTPersonaGiuridicaDao() {
		return sigitTPersonaGiuridicaDao;
	}

	public void setSigitTPersonaGiuridicaDao(SigitTPersonaGiuridicaDao sigitTPersonaGiuridicaDao) {
		this.sigitTPersonaGiuridicaDao = sigitTPersonaGiuridicaDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_LIBRETTO
	 */
	private SigitTLibrettoDao sigitTLibrettoDao = null;

	public SigitTLibrettoDao getSigitTLibrettoDao() {
		return sigitTLibrettoDao;
	}

	public void setSigitTLibrettoDao(SigitTLibrettoDao sigitTLibrettoDao) {
		this.sigitTLibrettoDao = sigitTLibrettoDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_CONSUMO
	 */
	private SigitTConsumoDao sigitTConsumoDao = null;

	public SigitTConsumoDao getSigitTConsumoDao() {
		return sigitTConsumoDao;
	}

	public void setSigitTConsumoDao(SigitTConsumoDao sigitTConsumoDao) {
		this.sigitTConsumoDao = sigitTConsumoDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_CONSUMO14_4
	 */
	private SigitTConsumo14_4Dao sigitTConsumo14_4Dao = null;

	public SigitTConsumo14_4Dao getSigitTConsumo144Dao() {
		return sigitTConsumo14_4Dao;
	}

	public void setSigitTConsumo144Dao(SigitTConsumo14_4Dao sigitTConsumo14_4Dao) {
		this.sigitTConsumo14_4Dao = sigitTConsumo14_4Dao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_LIB_TXT
	 */
	private SigitTLibTxtDao sigitTLibTxtDao = null;

	public SigitTLibTxtDao getSigitTLibTxtDao() {
		return sigitTLibTxtDao;
	}

	public void setSigitTLibTxtDao(SigitTLibTxtDao sigitTLibTxtDao) {
		this.sigitTLibTxtDao = sigitTLibTxtDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_CODICE_BOLL
	 */
	private SigitTCodiceBollDao sigitTCodiceBollDao = null;

	public SigitTCodiceBollDao getSigitTCodiceBollDao() {
		return sigitTCodiceBollDao;
	}

	public void setSigitTCodiceBollDao(SigitTCodiceBollDao sigitTCodiceBollDao) {
		this.sigitTCodiceBollDao = sigitTCodiceBollDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_ALLEGATO
	 */
	private SigitTAllegatoDao sigitTAllegatoDao = null;

	public SigitTAllegatoDao getSigitTAllegatoDao() {
		return sigitTAllegatoDao;
	}

	public void setSigitTAllegatoDao(SigitTAllegatoDao sigitTAllegatoDao) {
		this.sigitTAllegatoDao = sigitTAllegatoDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_RICERCA_ALLEGATI
	 */
	private SigitVRicercaAllegatiDao sigitVRicercaAllegatiDao = null;

	public SigitVRicercaAllegatiDao getSigitVRicercaAllegatiDao() {
		return sigitVRicercaAllegatiDao;
	}

	public void setSigitVRicercaAllegatiDao(SigitVRicercaAllegatiDao sigitVRicercaAllegatiDao) {
		this.sigitVRicercaAllegatiDao = sigitVRicercaAllegatiDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_ALL_TXT
	 */
	private SigitTAllTxtDao sigitTAllTxtDao = null;

	public SigitTAllTxtDao getSigitTAllTxtDao() {
		return sigitTAllTxtDao;
	}

	public void setSigitTAllTxtDao(SigitTAllTxtDao sigitTAllTxtDao) {
		this.sigitTAllTxtDao = sigitTAllTxtDao;
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
	 * DAO per accedere alla tabella SIGIT_T_PRE_IMPORT
	 */
	private SigitTPreImportDao sigitTPreImportDao = null;

	public SigitTPreImportDao getSigitTPreImportDao() {
		return sigitTPreImportDao;
	}

	public void setSigitTPreImportDao(SigitTPreImportDao sigitTPreImportDao) {
		this.sigitTPreImportDao = sigitTPreImportDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_TRATT_H2O
	 */
	private SigitTTrattH2ODao sigitTTrattH2ODao = null;

	public SigitTTrattH2ODao getSigitTTrattH2oDao() {
		return sigitTTrattH2ODao;
	}

	public void setSigitTTrattH2oDao(SigitTTrattH2ODao sigitTTrattH2ODao) {
		this.sigitTTrattH2ODao = sigitTTrattH2ODao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_UNITA_IMMOBILIARE
	 */
	private SigitTUnitaImmobiliareDao sigitTUnitaImmobiliareDao = null;

	public SigitTUnitaImmobiliareDao getSigitTUnitaImmobiliareDao() {
		return sigitTUnitaImmobiliareDao;
	}

	public void setSigitTUnitaImmobiliareDao(SigitTUnitaImmobiliareDao sigitTUnitaImmobiliareDao) {
		this.sigitTUnitaImmobiliareDao = sigitTUnitaImmobiliareDao;
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
	 * DAO per accedere alla tabella SIGIT_R_IMP_RUOLO_PF_PG
	 */
	private SigitRImpRuoloPfpgDao sigitRImpRuoloPfpgDao = null;

	public SigitRImpRuoloPfpgDao getSigitRImpRuoloPfpgDao() {
		return sigitRImpRuoloPfpgDao;
	}

	public void setSigitRImpRuoloPfpgDao(SigitRImpRuoloPfpgDao sigitRImpRuoloPfpgDao) {
		this.sigitRImpRuoloPfpgDao = sigitRImpRuoloPfpgDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_DETT_TIPO1
	 */
	private SigitTDettTipo1Dao sigitTDettTipo1Dao = null;

	public SigitTDettTipo1Dao getSigitTDettTipo1Dao() {
		return sigitTDettTipo1Dao;
	}

	public void setSigitTDettTipo1Dao(SigitTDettTipo1Dao sigitTDettTipo1Dao) {
		this.sigitTDettTipo1Dao = sigitTDettTipo1Dao;
	}

	private SigitTDettTipo2Dao sigitTDettTipo2Dao = null;
	private SigitTDettTipo3Dao sigitTDettTipo3Dao = null;
	private SigitTDettTipo4Dao sigitTDettTipo4Dao = null;

	public SigitTDettTipo2Dao getSigitTDettTipo2Dao() {
		return sigitTDettTipo2Dao;
	}

	public void setSigitTDettTipo2Dao(SigitTDettTipo2Dao sigitTDettTipo2Dao) {
		this.sigitTDettTipo2Dao = sigitTDettTipo2Dao;
	}

	public SigitTDettTipo3Dao getSigitTDettTipo3Dao() {
		return sigitTDettTipo3Dao;
	}

	public void setSigitTDettTipo3Dao(SigitTDettTipo3Dao sigitTDettTipo3Dao) {
		this.sigitTDettTipo3Dao = sigitTDettTipo3Dao;
	}

	public SigitTDettTipo4Dao getSigitTDettTipo4Dao() {
		return sigitTDettTipo4Dao;
	}

	public void setSigitTDettTipo4Dao(SigitTDettTipo4Dao sigitTDettTipo4Dao) {
		this.sigitTDettTipo4Dao = sigitTDettTipo4Dao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_RAPP_TIPO1
	 */
	private SigitTRappTipo1Dao sigitTRappTipo1Dao = null;

	public SigitTRappTipo1Dao getSigitTRappTipo1Dao() {
		return sigitTRappTipo1Dao;
	}

	public void setSigitTRappTipo1Dao(SigitTRappTipo1Dao sigitTRappTipo1Dao) {
		this.sigitTRappTipo1Dao = sigitTRappTipo1Dao;
	}

	private SigitTRappTipo2Dao sigitTRappTipo2Dao = null;

	public SigitTRappTipo2Dao getSigitTRappTipo2Dao() {
		return sigitTRappTipo2Dao;
	}

	public void setSigitTRappTipo2Dao(SigitTRappTipo2Dao sigitTRappTipo2Dao) {
		this.sigitTRappTipo2Dao = sigitTRappTipo2Dao;
	}

	private SigitTRappTipo3Dao sigitTRappTipo3Dao = null;
	private SigitTRappTipo4Dao sigitTRappTipo4Dao = null;

	public SigitTRappTipo3Dao getSigitTRappTipo3Dao() {
		return sigitTRappTipo3Dao;
	}

	public void setSigitTRappTipo3Dao(SigitTRappTipo3Dao sigitTRappTipo3Dao) {
		this.sigitTRappTipo3Dao = sigitTRappTipo3Dao;
	}

	public SigitTRappTipo4Dao getSigitTRappTipo4Dao() {
		return sigitTRappTipo4Dao;
	}

	public void setSigitTRappTipo4Dao(SigitTRappTipo4Dao sigitTRappTipo4Dao) {
		this.sigitTRappTipo4Dao = sigitTRappTipo4Dao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_COMP_BR_RC
	 */
	private SigitTCompBrRcDao sigitTCompBrRcDao = null;

	public SigitTCompBrRcDao getSigitTCompBrRcDao() {
		return sigitTCompBrRcDao;
	}

	public void setSigitTCompBrRcDao(SigitTCompBrRcDao sigitTCompBrRcDao) {
		this.sigitTCompBrRcDao = sigitTCompBrRcDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_GF_DETT
	 */
	private SigitVCompGfDettDao sigitVCompGfDettDao = null;

	public SigitVCompGfDettDao getSigitVCompGfDettDao() {
		return sigitVCompGfDettDao;
	}

	public void setSigitVCompGfDettDao(SigitVCompGfDettDao sigitVCompGfDettDao) {
		this.sigitVCompGfDettDao = sigitVCompGfDettDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_CG_DETT
	 */
	private SigitVCompCgDettDao sigitVCompCgDettDao = null;

	public SigitVCompCgDettDao getSigitVCompCgDettDao() {
		return sigitVCompCgDettDao;
	}

	public void setSigitVCompCgDettDao(SigitVCompCgDettDao sigitVCompCgDettDao) {
		this.sigitVCompCgDettDao = sigitVCompCgDettDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_SC_DETT
	 */
	private SigitVCompScDettDao sigitVCompScDettDao = null;

	public SigitVCompScDettDao getSigitVCompScDettDao() {
		return sigitVCompScDettDao;
	}

	public void setSigitVCompScDettDao(SigitVCompScDettDao sigitVCompScDettDao) {
		this.sigitVCompScDettDao = sigitVCompScDettDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_CS
	 */
	private SigitVCompCsDao sigitVCompCsDao = null;

	public SigitVCompCsDao getSigitVCompCsDao() {
		return sigitVCompCsDao;
	}

	public void setSigitVCompCsDao(SigitVCompCsDao sigitVCompCsDao) {
		this.sigitVCompCsDao = sigitVCompCsDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_AG
	 */
	private SigitVCompAgDao sigitVCompAgDao = null;

	public SigitVCompAgDao getSigitVCompAgDao() {
		return sigitVCompAgDao;
	}

	public void setSigitVCompAgDao(SigitVCompAgDao sigitVCompAgDao) {
		this.sigitVCompAgDao = sigitVCompAgDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_COMPX_SEMPLICE
	 */
	private SigitTCompXSempliceDao sigitTCompXSempliceDao = null;

	public SigitTCompXSempliceDao getSigitTCompXSempliceDao() {
		return sigitTCompXSempliceDao;
	}

	public void setSigitTCompXSempliceDao(SigitTCompXSempliceDao sigitTCompXSempliceDao) {
		this.sigitTCompXSempliceDao = sigitTCompXSempliceDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_SR
	 */
	private SigitVCompSrDao sigitVCompSrDao = null;

	public SigitVCompSrDao getSigitVCompSrDao() {
		return sigitVCompSrDao;
	}

	public void setSigitVCompSrDao(SigitVCompSrDao sigitVCompSrDao) {
		this.sigitVCompSrDao = sigitVCompSrDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_VR
	 */
	private SigitVCompVrDao sigitVCompVrDao = null;

	public SigitVCompVrDao getSigitVCompVrDao() {
		return sigitVCompVrDao;
	}

	public void setSigitVCompVrDao(SigitVCompVrDao sigitVCompVrDao) {
		this.sigitVCompVrDao = sigitVCompVrDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_VX
	 */
	private SigitTCompVxDao sigitTCompVxDao = null;

	public SigitTCompVxDao getSigitTCompVxDao() {
		return sigitTCompVxDao;
	}

	public void setSigitTCompVxDao(SigitTCompVxDao sigitTCompVxDao) {
		this.sigitTCompVxDao = sigitTCompVxDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_PO
	 */
	private SigitVCompPoDao sigitVCompPoDao = null;

	public SigitVCompPoDao getSigitVCompPoDao() {
		return sigitVCompPoDao;
	}

	public void setSigitVCompPoDao(SigitVCompPoDao sigitVCompPoDao) {
		this.sigitVCompPoDao = sigitVCompPoDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_AC
	 */
	private SigitVCompAcDao sigitVCompAcDao = null;

	public SigitVCompAcDao getSigitVCompAcDao() {
		return sigitVCompAcDao;
	}

	public void setSigitVCompAcDao(SigitVCompAcDao sigitVCompAcDao) {
		this.sigitVCompAcDao = sigitVCompAcDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_TE
	 */
	private SigitVCompTeDao sigitVCompTeDao = null;

	public SigitVCompTeDao getSigitVCompTeDao() {
		return sigitVCompTeDao;
	}

	public void setSigitVCompTeDao(SigitVCompTeDao sigitVCompTeDao) {
		this.sigitVCompTeDao = sigitVCompTeDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_RV
	 */
	private SigitVCompRvDao sigitVCompRvDao = null;

	public SigitVCompRvDao getSigitVCompRvDao() {
		return sigitVCompRvDao;
	}

	public void setSigitVCompRvDao(SigitVCompRvDao sigitVCompRvDao) {
		this.sigitVCompRvDao = sigitVCompRvDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_COMPX
	 */
	private SigitTCompXDao sigitTCompXDao = null;

	public SigitTCompXDao getSigitTCompXDao() {
		return sigitTCompXDao;
	}

	public void setSigitTCompXDao(SigitTCompXDao sigitTCompXDao) {
		this.sigitTCompXDao = sigitTCompXDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_CI
	 */
	private SigitVCompCiDao sigitVCompCiDao = null;

	public SigitVCompCiDao getSigitVCompCiDao() {
		return sigitVCompCiDao;
	}

	public void setSigitVCompCiDao(SigitVCompCiDao sigitVCompCiDao) {
		this.sigitVCompCiDao = sigitVCompCiDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_UT
	 */
	private SigitVCompUtDao sigitVCompUtDao = null;

	public SigitVCompUtDao getSigitVCompUtDao() {
		return sigitVCompUtDao;
	}

	public void setSigitVCompUtDao(SigitVCompUtDao sigitVCompUtDao) {
		this.sigitVCompUtDao = sigitVCompUtDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_RC
	 */
	private SigitVCompRcDao sigitVCompRcDao = null;

	public SigitVCompRcDao getSigitVCompRcDao() {
		return sigitVCompRcDao;
	}

	public void setSigitVCompRcDao(SigitVCompRcDao sigitVCompRcDao) {
		this.sigitVCompRcDao = sigitVCompRcDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_VM
	 */
	private SigitVCompVmDao sigitVCompVmDao = null;

	public SigitVCompVmDao getSigitVCompVmDao() {
		return sigitVCompVmDao;
	}

	public void setSigitVCompVmDao(SigitVCompVmDao sigitVCompVmDao) {
		this.sigitVCompVmDao = sigitVCompVmDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_D_COMBUSTIBILE
	 */
	private SigitDCombustibileDao sigitDCombustibileDao = null;

	public SigitDCombustibileDao getSigitDCombustibileDao() {
		return sigitDCombustibileDao;
	}

	public void setSigitDCombustibileDao(SigitDCombustibileDao sigitDCombustibileDao) {
		this.sigitDCombustibileDao = sigitDCombustibileDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_D_MARCA
	 */
	private SigitDMarcaDao sigitDMarcaDao = null;

	public SigitDMarcaDao getSigitDMarcaDao() {
		return sigitDMarcaDao;
	}

	public void setSigitDMarcaDao(SigitDMarcaDao sigitDMarcaDao) {
		this.sigitDMarcaDao = sigitDMarcaDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_D_FLUIDO
	 */
	private SigitDFluidoDao sigitDFluidoDao = null;

	public SigitDFluidoDao getSigitDFluidoDao() {
		return sigitDFluidoDao;
	}

	public void setSigitDFluidoDao(SigitDFluidoDao sigitDFluidoDao) {
		this.sigitDFluidoDao = sigitDFluidoDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_D_UNITA_MISURA
	 */
	private SigitDUnitaMisuraDao sigitDUnitaMisuraDao = null;

	public SigitDUnitaMisuraDao getSigitDUnitaMisuraDao() {
		return sigitDUnitaMisuraDao;
	}

	public void setSigitDUnitaMisuraDao(SigitDUnitaMisuraDao sigitDUnitaMisuraDao) {
		this.sigitDUnitaMisuraDao = sigitDUnitaMisuraDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_EXT
	 */
	private SigitExtDao sigitExtDao = null;

	public SigitExtDao getSigitExtDao() {
		return sigitExtDao;
	}

	public void setSigitExtDao(SigitExtDao sigitExtDao) {
		this.sigitExtDao = sigitExtDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_TOT_IMPIANTO
	 */
	private SigitVTotImpiantoDao sigitVTotImpiantoDao = null;

	public SigitVTotImpiantoDao getSigitVTotImpiantoDao() {
		return sigitVTotImpiantoDao;
	}

	public void setSigitVTotImpiantoDao(SigitVTotImpiantoDao sigitVTotImpiantoDao) {
		this.sigitVTotImpiantoDao = sigitVTotImpiantoDao;
	}

	//SigitVCompGtDettDto

	/**
	 * DAO per accedere alla tabella SIGIT_V_COMP_GT_DETT
	 */
	private SigitVCompGtDettDao sigitVCompGtDettDao = null;

	public SigitVCompGtDettDao getSigitVCompGtDettDao() {
		return sigitVCompGtDettDao;
	}

	public void setSigitVCompGtDettDao(SigitVCompGtDettDao sigitVCompGtDettDao) {
		this.sigitVCompGtDettDao = sigitVCompGtDettDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_WRK_CONFIG
	 */
	private SigitWrkConfigDao sigitWrkConfigDao = null;

	public SigitWrkConfigDao getSigitWrkConfigDao() {
		return sigitWrkConfigDao;
	}

	public void setSigitWrkConfigDao(SigitWrkConfigDao sigitWrkConfigDao) {
		this.sigitWrkConfigDao = sigitWrkConfigDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_IMPORT_DISTRIB
	 */
	private SigitTImportDistribDao sigitTImportDistribDao = null;

	public SigitTImportDistribDao getSigitTImportDistribDao() {
		return sigitTImportDistribDao;
	}

	public void setSigitTImportDistribDao(SigitTImportDistribDao sigitTImportDistribDao) {
		this.sigitTImportDistribDao = sigitTImportDistribDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_LOG_DISTRIB
	 */
	private SigitTLogDistribDao sigitTLogDistribDao = null;

	public SigitTLogDistribDao getSigitTLogDistribDao() {
		return sigitTLogDistribDao;
	}

	public void setSigitTLogDistribDao(SigitTLogDistribDao sigitTLogDistribDao) {
		this.sigitTLogDistribDao = sigitTLogDistribDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_DATO_DISTRIB
	 */
	private SigitTDatoDistribDao sigitTDatoDistribDao = null;

	public SigitTDatoDistribDao getSigitTDatoDistribDao() {
		return sigitTDatoDistribDao;
	}

	public void setSigitTDatoDistribDao(SigitTDatoDistribDao sigitTDatoDistribDao) {
		this.sigitTDatoDistribDao = sigitTDatoDistribDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_RIF_CATAST
	 */
	private SigitTRifCatastDao sigitTRifCatastDao = null;

	public SigitTRifCatastDao getSigitTRifCatastDao() {
		return sigitTRifCatastDao;
	}

	public void setSigitTRifCatastDao(SigitTRifCatastDao sigitTRifCatastDao) {
		this.sigitTRifCatastDao = sigitTRifCatastDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_R_COMP4_MANUT
	 */
	private SigitRComp4ManutDao sigitRComp4ManutDao = null;

	public SigitRComp4ManutDao getSigitRComp4ManutDao() {
		return sigitRComp4ManutDao;
	}

	public void setSigitRComp4ManutDao(SigitRComp4ManutDao sigitRComp4ManutDao) {
		this.sigitRComp4ManutDao = sigitRComp4ManutDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_R_COMP4MANUT_ALL
	 */
	private SigitRComp4ManutAllDao sigitRComp4ManutAllDao = null;

	public SigitRComp4ManutAllDao getSigitRComp4ManutAllDao() {
		return sigitRComp4ManutAllDao;
	}

	public void setSigitRComp4ManutAllDao(SigitRComp4ManutAllDao sigitRComp4ManutAllDao) {
		this.sigitRComp4ManutAllDao = sigitRComp4ManutAllDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_SK4_GT
	 */
	private SigitVSk4GtDao sigitVSk4GtDao = null;

	public SigitVSk4GtDao getSigitVSk4GtDao() {
		return sigitVSk4GtDao;
	}

	public void setSigitVSk4GtDao(SigitVSk4GtDao sigitVSk4GtDao) {
		this.sigitVSk4GtDao = sigitVSk4GtDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_SK4_CG
	 */
	private SigitVSk4CgDao sigitVSk4CgDao = null;

	public SigitVSk4CgDao getSigitVSk4CgDao() {
		return sigitVSk4CgDao;
	}

	public void setSigitVSk4CgDao(SigitVSk4CgDao sigitVSk4CgDao) {
		this.sigitVSk4CgDao = sigitVSk4CgDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_SK4_GF
	 */
	private SigitVSk4GfDao sigitVSk4GfDao = null;

	public SigitVSk4GfDao getSigitVSk4GfDao() {
		return sigitVSk4GfDao;
	}

	public void setSigitVSk4GfDao(SigitVSk4GfDao sigitVSk4GfDao) {
		this.sigitVSk4GfDao = sigitVSk4GfDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_V_SK4_SC
	 */
	private SigitVSk4ScDao sigitVSk4ScDao = null;

	public SigitVSk4ScDao getSigitVSk4ScDao() {
		return sigitVSk4ScDao;
	}

	public void setSigitVSk4ScDao(SigitVSk4ScDao sigitVSk4ScDao) {
		this.sigitVSk4ScDao = sigitVSk4ScDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_R_ALLEGATO_COMP_CG
	 */
	private SigitRAllegatoCompCgDao sigitRAllegatoCompCgDao = null;

	public SigitRAllegatoCompCgDao getSigitRAllegatoCompCgDao() {
		return sigitRAllegatoCompCgDao;
	}

	public void setSigitRAllegatoCompCgDao(SigitRAllegatoCompCgDao sigitRAllegatoCompCgDao) {
		this.sigitRAllegatoCompCgDao = sigitRAllegatoCompCgDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_R_ALLEGATO_COMP_GF
	 */
	private SigitRAllegatoCompGfDao sigitRAllegatoCompGfDao = null;

	public SigitRAllegatoCompGfDao getSigitRAllegatoCompGfDao() {
		return sigitRAllegatoCompGfDao;
	}

	public void setSigitRAllegatoCompGfDao(SigitRAllegatoCompGfDao sigitRAllegatoCompGfDao) {
		this.sigitRAllegatoCompGfDao = sigitRAllegatoCompGfDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_R_ALLEGATO_COMP_GT
	 */
	private SigitRAllegatoCompGtDao sigitRAllegatoCompGtDao = null;

	public SigitRAllegatoCompGtDao getSigitRAllegatoCompGtDao() {
		return sigitRAllegatoCompGtDao;
	}

	public void setSigitRAllegatoCompGtDao(SigitRAllegatoCompGtDao sigitRAllegatoCompGtDao) {
		this.sigitRAllegatoCompGtDao = sigitRAllegatoCompGtDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_R_ALLEGATO_COMP_SC
	 */
	private SigitRAllegatoCompScDao sigitRAllegatoCompScDao = null;

	public SigitRAllegatoCompScDao getSigitRAllegatoCompScDao() {
		return sigitRAllegatoCompScDao;
	}

	public void setSigitRAllegatoCompScDao(SigitRAllegatoCompScDao sigitRAllegatoCompScDao) {
		this.sigitRAllegatoCompScDao = sigitRAllegatoCompScDao;
	}

	private SigitTDocAggiuntivaDao sigitTDocAggiuntivaDao = null;

	public SigitTDocAggiuntivaDao getSigitTDocAggiuntivaDao() {
		return sigitTDocAggiuntivaDao;
	}

	public void setSigitTDocAggiuntivaDao(SigitTDocAggiuntivaDao sigitTDocAggiuntivaDao) {
		this.sigitTDocAggiuntivaDao = sigitTDocAggiuntivaDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_VERIFICA
	 */
	private SigitTVerificaDao sigitTVerificaDao = null;

	public SigitTVerificaDao getSigitTVerificaDao() {
		return sigitTVerificaDao;
	}

	public void setSigitTVerificaDao(SigitTVerificaDao sigitTVerificaDao) {
		this.sigitTVerificaDao = sigitTVerificaDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_ACCERTAMENTO
	 */
	private SigitTAccertamentoDao sigitTAccertamentoDao = null;

	public SigitTAccertamentoDao getSigitTAccertamentoDao() {
		return sigitTAccertamentoDao;
	}

	public void setSigitTAccertamentoDao(SigitTAccertamentoDao sigitTAccertamentoDao) {
		this.sigitTAccertamentoDao = sigitTAccertamentoDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_ISPEZIONE_2018
	 */
	private SigitTIspezione2018Dao sigitTIspezione2018Dao = null;

	public SigitTIspezione2018Dao getSigitTIspezione2018Dao() {
		return sigitTIspezione2018Dao;
	}

	public void setSigitTIspezione2018Dao(SigitTIspezione2018Dao sigitTIspezione2018Dao) {
		this.sigitTIspezione2018Dao = sigitTIspezione2018Dao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_SANZIONE
	 */
	private SigitTSanzioneDao sigitTSanzioneDao = null;

	public SigitTSanzioneDao getSigitTSanzioneDao() {
		return sigitTSanzioneDao;
	}

	public void setSigitTSanzioneDao(SigitTSanzioneDao sigitTSanzioneDao) {
		this.sigitTSanzioneDao = sigitTSanzioneDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_R_PF_RUOLO_PA
	 */
	private SigitRPfRuoloPaDao sigitRPfRuoloPaDao = null;

	public SigitRPfRuoloPaDao getSigitRPfRuoloPaDao() {
		return sigitRPfRuoloPaDao;
	}

	public void setSigitRPfRuoloPaDao(SigitRPfRuoloPaDao sigitRPfRuoloPaDao) {
		this.sigitRPfRuoloPaDao = sigitRPfRuoloPaDao;
	}

	/**
	 * DAO per accedere alla tabella VISTA_RICERCA_3_RESPONSABILE
	 */
	private SigitVRicerca3ResponsabileDao sigitVRicerca3ResponsabileDao = null;

	public SigitVRicerca3ResponsabileDao getSigitVRicerca3ResponsabileDao() {
		return sigitVRicerca3ResponsabileDao;
	}

	public void setSigitVRicerca3ResponsabileDao(SigitVRicerca3ResponsabileDao sigitVRicerca3ResponsabileDao) {
		this.sigitVRicerca3ResponsabileDao = sigitVRicerca3ResponsabileDao;
	}

	/**
	 * DAO per accedere alla tabella SIGIT_T_WRK_LOG_MEMO
	 */
	private SigitWrkLogMemoDao sigitWrkLogMemoDao = null;

	public SigitWrkLogMemoDao getSigitWrkLogMemoDao() {
		return sigitWrkLogMemoDao;
	}

	public void setSigitWrkLogMemoDao(SigitWrkLogMemoDao sigitWrkLogMemoDao) {
		this.sigitWrkLogMemoDao = sigitWrkLogMemoDao;
	}

	private SigitWrkLogMemoTuDao sigitWrkLogMemoTuDao = null;

	public SigitWrkLogMemoTuDao getSigitWrkLogMemoTuDao() {
		return sigitWrkLogMemoTuDao;
	}

	public void setSigitWrkLogMemoTuDao(SigitWrkLogMemoTuDao sigitWrkLogMemoDao) {
		this.sigitWrkLogMemoTuDao = sigitWrkLogMemoDao;
	}

	private SigitVCompCgDao sigitVCompCgDao = null;

	public SigitVCompCgDao getSigitVCompCgDao() {
		return sigitVCompCgDao;
	}

	public void setSigitVCompCgDao(SigitVCompCgDao sigitVCompCgDao) {
		this.sigitVCompCgDao = sigitVCompCgDao;
	}

	private SigitVCompGfDao sigitVCompGfDao = null;

	public SigitVCompGfDao getSigitVCompGfDao() {
		return sigitVCompGfDao;
	}

	public void setSigitVCompGfDao(SigitVCompGfDao sigitVCompGfDao) {
		this.sigitVCompGfDao = sigitVCompGfDao;
	}

	private SigitVCompGtDao sigitVCompGtDao = null;

	public SigitVCompGtDao getSigitVCompGtDao() {
		return sigitVCompGtDao;
	}

	public void setSigitVCompGtDao(SigitVCompGtDao sigitVCompGtDao) {
		this.sigitVCompGtDao = sigitVCompGtDao;
	}

	private SigitVCompScDao sigitVCompScDao = null;

	public SigitVCompScDao getSigitVCompScDao() {
		return sigitVCompScDao;
	}

	public void setSigitVCompScDao(SigitVCompScDao sigitVCompScDao) {
		this.sigitVCompScDao = sigitVCompScDao;
	}

	/**
	 * Verifica del manager
	 */
	public void test() {
		log.debug("DBManager RAGGIUNTO CORRETTAMENTE");
	}

	// INIZIO METODI DI BUSINESS

	/**
	 * Restituisce l'elenco dei file da importare
	 *
	 * @return List la lista dei file da importare
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */

	public List<SigitTImportDto> cercaXmlDaImportare() throws DbManagerException {
		log.debug("[DbMgr::cercaXmlDaImportare] BEGIN");
		List<SigitTImportDto> dtoList = null;

		try {
			dtoList = getSigitTImportDao().findDaElaborare(null);

		} catch (SigitTImportDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaXmlDaImportare] END");
		}
		return dtoList;
	}

	/**
	 * Restituisce l'elenco dei file da importare
	 *
	 * @return List la lista dei file da importare
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */

	public List<SigitTImportDistribDto> cercaXmlDistributoriDaImportare() throws DbManagerException {
		log.debug("[DbMgr::cercaXmlDistributoriDaImportare] BEGIN");
		List<SigitTImportDistribDto> dtoList = null;

		try {
			dtoList = getSigitTImportDistribDao().findDaElaborare(null);
		} catch (SigitTImportDistribDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaXmlDistributoriDaImportare] END");
		}
		return dtoList;
	}

	public void inserisciLogDistrib(Integer idImportDistrib, String messaggioError) throws DbManagerException {
		log.debug("[DbMgr::inserisciLogDistrib] BEGIN");
		try {
			SigitTLogDistribDto dto = new SigitTLogDistribDto();
			dto.setFkImportDistrib(idImportDistrib);
			dto.setMsgErrore(messaggioError);

			getSigitTLogDistribDao().insert(dto);

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[DbMgr::inserisciLogDistrib] END");
		}

	}

	public void aggiornaImportDistribInviato(Integer idImportDistrib, Integer totElab, Integer totScart) throws DbManagerException {
		log.debug("[DbMgr::aggiornaImportDistribInviato] BEGIN");
		try {
			SigitTImportDistribDto dto = new SigitTImportDistribDto();
			dto.setIdImportDistrib(idImportDistrib);
			dto.setFkStatoDistrib(Constants.ID_STATO_IMP_DISTRIBUTORE_INVIATO);
			dto.setDataFineElab(DateUtil.getSqlDataCorrente());
			dto.setTotRecordElaborati(ConvertUtil.convertToBigDecimal(totElab));
			dto.setTotRecordScartati(ConvertUtil.convertToBigDecimal(totScart));

			getSigitTImportDistribDao().customUpdaterAggiornaById(idImportDistrib, dto);

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[DbMgr::aggiornaImportDistribInviato] END");
		}

	}

	public void aggiornaImportDistribRifiutato(Integer idImportDistrib) throws DbManagerException {
		log.debug("[DbMgr::aggiornaImportDistribRifiutato] BEGIN");
		try {
			SigitTImportDistribDto dto = new SigitTImportDistribDto();
			dto.setIdImportDistrib(idImportDistrib);
			dto.setFkStatoDistrib(Constants.ID_STATO_IMP_DISTRIBUTORE_RIFIUTATO);
			dto.setDataFineElab(DateUtil.getSqlDataCorrente());

			getSigitTImportDistribDao().customUpdaterAggiornaById(idImportDistrib, dto);

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[DbMgr::aggiornaImportDistribRifiutato] END");
		}

	}

	public void aggiornaImportDistribInvioMailDistr(Integer idImportDistrib) throws DbManagerException {
		log.debug("[DbMgr::aggiornaImportDistrib] BEGIN");
		try {
			SigitTImportDistribDto dto = new SigitTImportDistribDto();
			dto.setIdImportDistrib(idImportDistrib);
			dto.setDataInvioMailDistrib(DateUtil.getSqlDataCorrente());

			getSigitTImportDistribDao().customUpdaterAggiornaById(idImportDistrib, dto);

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[DbMgr::aggiornaImportDistrib] END");
		}

	}

	public SigitTImportDistribDto cercaSigitTImportDistribById(Integer idImportDistrib) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitTImportDistribById] BEGIN");
		SigitTImportDistribDto dto = null;

		try {
			dto = getSigitTImportDistribDao().findByPrimaryKey(new SigitTImportDistribPk(idImportDistrib));

		} catch (SigitTImportDistribDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaSigitTImportDistribById] END");
		}
		return dto;
	}

	public List<SigitTLogDistribDto> cercaSigitTLogDistribByIdImportDistrib(Integer idImportDistrib) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitTLogDistribByIdImportDistrib] BEGIN");
		List<SigitTLogDistribDto> dtoList = null;

		try {
			dtoList = getSigitTLogDistribDao().findByIdImportDistrib(idImportDistrib);

		} catch (SigitTLogDistribDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaSigitTLogDistribByIdImportDistrib] END");
		}
		return dtoList;
	}

	public SigitTImportDistribRicevutaByIdImportDistribDto cercaImportRicevutaByIdDistr(Integer idImportDistrib) throws DbManagerException {

		SigitTImportDistribRicevutaByIdImportDistribDto risImportDistrib = null;

		log.debug("[DbMgr::cercaImportRicevutaByIdDistr] BEGIN");
		try {

			List<SigitTImportDistribRicevutaByIdImportDistribDto> dtoList = getSigitTImportDistribDao().findRicevutaByIdImportDistrib(idImportDistrib);

			if (dtoList != null && dtoList.size() > 0) {
				// Ho fatto la riceca per chiave, quindi sicuramente ne troverà uno solo
				risImportDistrib = dtoList.get(0);
			}

		} catch (SigitTImportDistribDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaImportRicevutaByIdDistr] END");
		}

		return risImportDistrib;
	}

	public void inserisciFornituraClienteDistrib(Integer idImportDistrib, DatiFornituraCliente datiFornituraCliente) throws DbManagerException {
		log.debug("[DbMgr::inserisciFornituraClienteDistrib] BEGIN");
		try {

			SigitTDatoDistribDto dto = MapDto.mapToSigitTDatoDistribDto(idImportDistrib, datiFornituraCliente);

			SigitTDatoDistribPk datoDistriPk = getSigitTDatoDistribDao().insert(dto);
			Integer idDatoDistrib = datoDistriPk.getIdDatoDistrib();

			if (datiFornituraCliente.getDatiFornitura().getLocalizzazioneFornitura().getEstremiCatastali() != null) {
				List<EstremiCatastali> listEstremiCatast = datiFornituraCliente.getDatiFornitura().getLocalizzazioneFornitura().getEstremiCatastali();

				SigitTRifCatastDto dtoRifCat = null;

				for (EstremiCatastali estremiCatastali : listEstremiCatast) {
					dtoRifCat = MapDto.mapToSigitTRifCatastDto(idDatoDistrib, estremiCatastali);

					getSigitTRifCatastDao().insert(dtoRifCat);
				}

			}

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[DbMgr::inserisciFornituraClienteDistrib] END");
		}

	}

	/**
	 * Restituisce l'elenco degli import di cui bisogna mandare la mail all'assistenza
	 *
	 * @return List la lista dei file da inviare mail
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */

	public List<SigitTImportDto> cercaXmlDaInviareMailAssistenza() throws DbManagerException {
		log.debug("[DbMgr::cercaXmlDaInviareMailAssistenza] BEGIN");
		List<SigitTImportDto> dtoList = null;

		try {
			dtoList = getSigitTImportDao().findDaInviareMailAssistenza(null);

		} catch (SigitTImportDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaXmlDaInviareMailAssistenza] END");
		}
		return dtoList;
	}

	/**
	 * Restituisce l'elenco degli import di cui bisogna mandare la mail all'assistenza
	 *
	 * @return List la lista dei file da inviare mail
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */

	public List<SigitTImportDistribDto> cercaImportDistribDaInviareMailAssistenza() throws DbManagerException {
		log.debug("[DbMgr::cercaImportDistribDaInviareMailAssistenza] BEGIN");
		List<SigitTImportDistribDto> dtoList = null;

		try {
			dtoList = getSigitTImportDistribDao().findDaInviareMailAssistenza(null);

		} catch (SigitTImportDistribDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaImportDistribDaInviareMailAssistenza] END");
		}
		return dtoList;
	}

	public SigitDCombustibileDto cercaCombustibileById(String idCombustibile) throws DbManagerException {
		log.debug("[DbMgr::cercaCombustibileById] BEGIN");
		SigitDCombustibileDto dto = null;

		try {
			dto = getSigitDCombustibileDao().findByPrimaryKey(new SigitDCombustibilePk(ConvertUtil.convertToBigDecimal(idCombustibile)));

		} catch (SigitDCombustibileDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaCombustibileById] END");
		}
		return dto;
	}

	public SigitDFluidoDto cercaFluidoById(String idFluido) throws DbManagerException {
		log.debug("[DbMgr::cercaFluidoById] BEGIN");
		SigitDFluidoDto dto = null;

		try {
			dto = getSigitDFluidoDao().findByPrimaryKey(new SigitDFluidoPk(ConvertUtil.convertToBigDecimal(idFluido)));

		} catch (SigitDFluidoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaFluidoById] END");
		}
		return dto;
	}

	public SigitTImpXmlDto cercaFileTxtDaImportare(Integer idImport) throws DbManagerException {
		log.debug("[DbMgr::cercaFileTxtDaImportare] BEGIN");
		SigitTImpXmlDto dto = null;

		try {
			dto = getSigitTImpXmlDao().findByPrimaryKey(new SigitTImpXmlPk(idImport));

		} catch (SigitTImpXmlDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaFileTxtDaImportare] END");
		}
		return dto;
	}

	public void modificaImport(SigitTImportDto importDto) throws DbManagerException {

		log.debug("[DbMgr::modificaXmlDaImportare] BEGIN");

		try {
			getSigitTImportDao().update(importDto);
		} catch (SigitTImportDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::modificaXmlDaImportare] END");
		}

	}

	public void modificaImportInvioMailAss() throws DbManagerException {

		log.debug("[DbMgr::modificaImportInvioMailAss] BEGIN");

		try {
			getSigitTImportDao().customUpdaterAggiornaDataInvioMailAssistenza(null, DateUtil.getSqlDataCorrente());
		} catch (SigitTImportDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::modificaImportInvioMailAss] END");
		}

	}

	public void modificaImportDistribInvioMailAss() throws DbManagerException {

		log.debug("[DbMgr::modificaImportDistribInvioMailAss] BEGIN");

		try {
			getSigitTImportDistribDao().customUpdaterAggiornaDataInvioMailAssistenza(null, DateUtil.getSqlDataCorrente());
		} catch (SigitTImportDistribDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::modificaImportDistribInvioMailAss] END");
		}

	}

	public List<SigitTLibrettoDto> cercaLibrettoByStato(String codImpianto, Integer idStato) throws DbManagerException {
		log.debug("[DbMgr::cercaLibrettoByStato] BEGIN");
		try {

			List<SigitTLibrettoDto> librettoList = getSigitTLibrettoDao().findByLibrettoFilter(new LibrettoFilter(ConvertUtil.convertToInteger(codImpianto), idStato));

			return librettoList;
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaLibrettoByStato] END");
		}
	}

	/**
	 * Cerca un manutentore
	 *
	 * @param codiceFiscale Codice fiscale del manutentore
	 * @param siglaRea      Sigla REA
	 * @param numeroRea     Numero REA
	 * @return Manutentore associato al codice fiscale e/o al codice REA (Sigla +
	 * Numero)
	 * @throws DbManagerException Errore durante l'accesso ai dati
	 */
	public SigitTPersonaGiuridicaDto cercaPersonaGiuridica(String codiceFiscale, String siglaRea, BigDecimal numeroRea) throws DbManagerException {
		log.debug("[DbMgr::cercaInstManutPersonaGiuridica] BEGIN");
		SigitTPersonaGiuridicaDto dto = null;

		try {
			List<SigitTPersonaGiuridicaDto> dtoList = null;
			CodiceReaAndFiscaleFilter codiceReaFiscaleFilter = null;

			if (GenericUtil.isNotNullOrEmpty(codiceFiscale) && GenericUtil.isNotNullOrEmpty(siglaRea) && (numeroRea != null)) {
				// Ha selezionato sia CF che CodiceRea
				codiceReaFiscaleFilter = new CodiceReaAndFiscaleFilter(siglaRea, numeroRea, codiceFiscale);
				dtoList = getSigitTPersonaGiuridicaDao().findByCodiceReaAndFiscale(codiceReaFiscaleFilter);
			} else if (GenericUtil.isNotNullOrEmpty(codiceFiscale)) {
				// Ha selezionato solo il CF
				codiceReaFiscaleFilter = new CodiceReaAndFiscaleFilter(codiceFiscale);
				dtoList = getSigitTPersonaGiuridicaDao().findByCodiceFiscale(codiceReaFiscaleFilter);
			} else if (GenericUtil.isNotNullOrEmpty(siglaRea) && (numeroRea != null)) {
				// Ha selezionato solo il CodiceRea
				codiceReaFiscaleFilter = new CodiceReaAndFiscaleFilter(siglaRea, numeroRea);
				dtoList = getSigitTPersonaGiuridicaDao().findByCodiceRea(codiceReaFiscaleFilter);
			}

			if (dtoList != null && dtoList.size() > 0) {
				dto = dtoList.get(0);
			}
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaInstManutPersonaGiuridica] END");
		return dto;
	}

	/**
	 * Cerca un manutentore
	 *
	 * @param idPersonaGiuridica ID del manutentore
	 * @return Manutentore associato all'ID
	 * @throws DbManagerException Errore durante l'accesso ai dati
	 */
	public String cercaMailPersonaGiuridicaById(BigDecimal idPersonaGiuridica) throws DbManagerException {
		log.debug("[DbMgr::cercaMailPersonaGiuridicaById] BEGIN");
		String mail = null;

		try {

			SigitTPersonaGiuridicaDto dto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(idPersonaGiuridica));
			if (dto != null) {
				mail = dto.getEmail();
			}

		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaMailPersonaGiuridicaById] END");
		return mail;
	}

	//	public List<SigitVTotImpiantoDto> cercaAttiviAllDataByRuolo(ImpiantoFilter filter) throws DbManagerException
	//	{
	//		log.debug("[DbMgr::cercaAttiviAllDataByRuolo] START");
	//		try
	//		{
	//			return getSigitVTotImpiantoDao().findAttivoAllaDataByFilter(filter);
	//		} catch (SigitVTotImpiantoDaoException e) {
	//			log.error("Errore: ",e);
	//			throw new DbManagerException(new Message(Messages.ERROR_UPDATE_DB));
	//		}
	//		finally {
	//			log.debug("[DbMgr::cercaAttiviAllDataByRuolo] END");
	//		}
	//
	//	}

	public List<SigitRComp4ManutDto> cercaAttualiByRuolo(String codiceImpianto, BigDecimal idPersonaGiuridica, Integer idRuolo) throws DbManagerException {
		log.debug("[DbMgr::cercaAttualiByRuolo] START");
		try {
			/*
			SigitRImpRuoloPfpgDto filter = new SigitRImpRuoloPfpgDto();
			filter.setCodiceImpianto(new BigDecimal(codiceImpianto));
			filter.setFkPersonaGiuridica(idPersonaGiuridica);
			filter.setFkRuolo(ConvertUtil.convertToBigDecimal(idRuolo));
			
			return getSigitRImpRuoloPfpgDao().findByPersonaGiuridicaCodImpianto(filter);
			
			CompFilter filter = new CompFilter();
			filter.setCodImpianto(codiceImpianto);
			filter.setIdPersonaGiuridica(ConvertUtil.convertToInteger(idPersonaGiuridica));
			filter.setIdRuolo(idRuolo);
			*/

			return cercaAttualiByRuolo(codiceImpianto, idPersonaGiuridica, idRuolo, null);

		} catch (DbManagerException e) {
			log.error("Errore: ", e);
			throw e;
		} finally {
			log.debug("[DbMgr::cercaAttualiByRuolo] END");
		}

	}

	// Devo cercare con il progressivo
	public List<SigitRComp4ManutDto> cercaAttualiByRuolo(String codiceImpianto, BigDecimal idPersonaGiuridica, Integer idRuolo, ArrayList<String> progressivi) throws DbManagerException {
		log.debug("[DbMgr::cercaAttualiByRuolo] START");
		try {
			/*
			SigitRImpRuoloPfpgDto filter = new SigitRImpRuoloPfpgDto();
			filter.setCodiceImpianto(new BigDecimal(codiceImpianto));
			filter.setFkPersonaGiuridica(idPersonaGiuridica);
			filter.setFkRuolo(ConvertUtil.convertToBigDecimal(idRuolo));
			
			return getSigitRImpRuoloPfpgDao().findByPersonaGiuridicaCodImpianto(filter);
			*/
			CompFilter filter = new CompFilter();
			filter.setCodImpianto(codiceImpianto);
			filter.setIdPersonaGiuridica(ConvertUtil.convertToInteger(idPersonaGiuridica));
			filter.setIdRuolo(idRuolo);
			filter.setListProgressivi(progressivi);

			return getSigitRComp4ManutDao().findByPersonaGiuridicaCodImpianto(filter);

		} catch (SigitRComp4ManutDaoException e) {
			log.error("Errore: ", e);
			throw new DbManagerException(new Message(Messages.ERROR_UPDATE_DB));
		} finally {
			log.debug("[DbMgr::cercaAttualiByRuolo] END");
		}

	}

	public SigitTPersonaFisicaDto cercaPfPreImportById(Integer idPreImport) throws DbManagerException {
		log.debug("[DbMgr::cercaPfPreImportById] BEGIN");
		SigitTPersonaFisicaDto dtoPF = null;

		try {

			SigitTPreImportDto dtoPreImp = getSigitTPreImportDao().findByPrimaryKey(new SigitTPreImportPk(idPreImport));

			if (dtoPreImp != null)
				;
			{
				dtoPF = getSigitTPersonaFisicaDao().findByPrimaryKey(new SigitTPersonaFisicaPk(dtoPreImp.getIdPersonaFisica()));
			}
		} catch (SigitTPreImportDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[DbMgr::cercaPfPreImportById] END");
		return dtoPF;
	}

	public BigDecimal inserisciAllegato(SigitTAllegatoDto dto) throws DbManagerException {
		log.debug("[DbMgr::inserisciAllegato] BEGIN");
		SigitTAllegatoPk pk = null;
		try {
			pk = getSigitTAllegatoDao().insert(dto);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[DbMgr::inserisciAllegato] END");
		}

		return pk.getIdAllegato();
	}

	public void insertAllTxtAllegato(BigDecimal idAllegato, String txtAllegato) throws DbManagerException {
		log.debug("[DbMgr::insertAllTxtAllegato] START");
		try {
			SigitTAllTxtDto dto = new SigitTAllTxtDto();
			dto.setIdAllegato(idAllegato);
			dto.setXmlAllegato(txtAllegato);
			getSigitTAllTxtDao().insert(dto);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[DbMgr::insertAllTxtAllegato] END");
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
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[DbMgr::inserisciRAllegatoCompGt] END");
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
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[DbMgr::inserisciRAllegatoCompGf] END");
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
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[DbMgr::inserisciRAllegatoCompSc] END");
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
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[DbMgr::inserisciRAllegatoCompCg] END");
		}
	}

	public void settaIdAllegatoToImport(Integer idImport, BigDecimal idAllegato) throws DbManagerException {
		log.debug("[DbMgr::settaIdAllegatoToImport] START");
		try {
			SigitTImportDto dto = new SigitTImportDto();
			dto.setIdImport(idImport);
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));
			getSigitTImportDao().updateColumnsAggiornaIdAllegato(dto);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[DbMgr::settaIdAllegatoToImport] END");
		}
	}

	public void settaIdPersonaGiuridicaToImport(Integer idImport, BigDecimal idPersonaGiuridica) throws DbManagerException {
		log.debug("[DbMgr::settaIdPersonaGiuridicaToImport] START");
		try {
			SigitTImportDto dto = new SigitTImportDto();
			dto.setIdImport(idImport);
			dto.setFkPersonaGiuridica(idPersonaGiuridica);
			getSigitTImportDao().updateColumnsAggiornaIdPersGiuridica(dto);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[DbMgr::settaIdPersonaGiuridicaToImport] END");
		}
	}

	/*
	public List<SigitTCodiceBollByFilterDto> cercaCodiceBollinoManutentore(String siglaBollino, Integer numeroBollino, BigDecimal idPersonaGiuridica) throws DbManagerException
	{
		log.debug("[DbMgr::cercaCodiceBollinoManutentore] START");
		try
		{
			BollinoFilter filter = new BollinoFilter(siglaBollino, numeroBollino, idPersonaGiuridica);
			
			return getSigitTCodiceBollDao().findByFilter(filter);
		} catch (SigitTCodiceBollDaoException e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::cercaCodiceBollinoManutentore] END");
		}
		
	}
	*/
	public List<SigitTAllegatoDto> cercaAllegatoByCodiceBollino(String siglaBollino, Integer numeroBollino) throws DbManagerException {
		log.debug("[DbMgr::cercaAllegatoByCodiceBollino] START");
		try {
			BollinoFilter filter = new BollinoFilter(siglaBollino, numeroBollino);

			return getSigitTAllegatoDao().findByCodiceBollino(filter);
		} catch (SigitTAllegatoDaoException e) {
			log.error("Errore: ", e);
			throw new DbManagerException(new Message(Messages.ERROR_UPDATE_DB));
		} finally {
			log.debug("[DbMgr::cercaAllegatoByCodiceBollino] END");
		}

	}

	public List<SigitTCodiceBollDto> cercaCodiceBollInDataControllo(String siglaBollino, String numeroBollino, String dataControllo) throws DbManagerException {
		List<SigitTCodiceBollDto> list = null;
		log.debug("[DbMgr::cercaCodiceBollInDataControllo] BEGIN");
		try {

			TransazioneFilter filter = new TransazioneFilter();
			filter.setSiglaBollino(siglaBollino);
			filter.setNumeroBollino(ConvertUtil.convertToInteger(numeroBollino));
			filter.setDataControllo(ConvertUtil.convertToSqlDate(dataControllo));

			list = getSigitTCodiceBollDao().findByNumeroBollinoDataControllo(filter);

		} catch (SigitTCodiceBollDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaCodiceBollInDataControllo] END");
		}
		return list;
	}

	public SigitTImpiantoDto cercaImpiantoById(String codiceImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaImpiantoById] START");
		try {

			return getSigitTImpiantoDao().findByPrimaryKey(new SigitTImpiantoPk(ConvertUtil.convertToBigDecimal(codiceImpianto)));
		} catch (SigitTImpiantoDaoException e) {
			log.error("Errore: ", e);
			throw new DbManagerException(new Message(Messages.ERROR_UPDATE_DB));
		} finally {
			log.debug("[DbMgr::cercaImpiantoById] END");
		}

	}

	public SigitTTrattH2ODto cercaTrattAcquaByCodiceImpianto(String codImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaTrattAcquaByCodiceImpianto] START");
		try {

			return getSigitTTrattH2oDao().findByPrimaryKey(new SigitTTrattH2OPk(ConvertUtil.convertToBigDecimal(codImpianto)));

		} catch (SigitTTrattH2ODaoException e) {
			log.error("Errore: ", e);
			throw new DbManagerException(new Message(Messages.ERROR_UPDATE_DB));
		} finally {
			log.debug("[DbMgr::cercaTrattAcquaByCodiceImpianto] END");
		}

	}

	public List<SigitTDocAggiuntivaDto> cercaDocumentoAggDerogaByCodImpianto(BigDecimal codImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaDocumentoAggDerogaByCodImpianto] BEGIN");

		try {
			SigitTDocAggiuntivaDto filter = new SigitTDocAggiuntivaDto();
			filter.setCodiceImpianto(codImpianto);
			filter.setFkTipoDocagg(ConvertUtil.convertToBigDecimal(Constants.ID_TIPO_DOC_DEROGA));

			return getSigitTDocAggiuntivaDao().findByCodImpIdTipoDocAgg(filter);

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaDocumentoAggDerogaByCodImpianto] END");
		}
	}

	public SigitTCompXSempliceDto cercaSigitTCompXSempliceByCodImpianto(BigDecimal codImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitTCompXSempliceByCodImpianto] BEGIN");
		try {

			return getSigitTCompXSempliceDao().findByPrimaryKey(new SigitTCompXSemplicePk(codImpianto));

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaSigitTCompXSempliceByCodImpianto] END");
		}
	}
	
	/*
	public List<SigitVSk4GtDto> getCompGtAttiviInData(String codImpianto, Date dataControllo, BigDecimal idPersonaGiuridica) throws DbManagerException
	{
		log.debug("[DbMgr::getCompGtAttiviInData] START");
		try {
			
			SigitVSk4GtDto input = new SigitVSk4GtDto();
			input.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			input.setDataInstall(new java.sql.Date(dataControllo.getTime()));
			input.setIdPersonaGiuridica(idPersonaGiuridica);
			return getSigitVSk4GtDao().findAttiviByCodImpianto(input);
		} catch (SigitVSk4GtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompGtAttiviInData] END");
		}
	}
	*/

	public List<SigitVSk4GtDto> getDescGtAttiviInDataProgressivi(String codImpianto, String dataControllo, List<String> listaProgressivi) throws DbManagerException {
		log.debug("[DbMgr::getDescGtAttiviInDataProgressivi] START");
		try {
			CompFilter input = new CompFilter(codImpianto, listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitVSk4GtDao().findAppAttiviByCodImpiantoProgressivi(input);
		} catch (SigitVSk4GtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getDescGtAttiviInDataProgressivi] END");
		}
	}

	public List<SigitVSk4GtDto> getCompGtAttiviInDataProgressivi(String codImpianto, String dataControllo, List<String> listaProgressivi) throws DbManagerException {
		log.debug("[DbMgr::getCompGtAttiviInDataProgressivi] START");
		try {
			CompFilter input = new CompFilter(codImpianto, listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitVSk4GtDao().findAttiviByCodImpiantoProgressivi(input);
		} catch (SigitVSk4GtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getCompGtAttiviInDataProgressivi] END");
		}
	}
	
	/*
	public List<SigitVSk4GfDto> getCompGfAttiviInData(String codImpianto, Date dataControllo, BigDecimal idPersonaGiuridica) throws DbManagerException
	{
		log.debug("[DbMgr::getCompGfAttiviInData] START");
		try {
			SigitVCompGfDettDto input = new SigitVCompGfDettDto();
			input.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			input.setDataInstall(new java.sql.Date(dataControllo.getTime()));
			input.setIdPersonaGiuridica(idPersonaGiuridica);

			return getSigitVSk4GfDao().findAttiviByCodiceImpianto(input);
		} catch (SigitVSk4GfDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompGfAttiviInData] END");
		}
	}
	*/

	public List<SigitVSk4GfDto> getDescCompGfAttiviInDataProgressivi(String codImpianto, String dataControllo, List<String> listaProgressivi) throws DbManagerException {
		log.debug("[DbMgr::getDescCompGfAttiviInDataProgressivi] START");
		try {
			CompFilter input = new CompFilter(codImpianto, listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitVSk4GfDao().findAppAttiviByCodImpiantoProgressivi(input);
		} catch (SigitVSk4GfDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getDescCompGfAttiviInDataProgressivi] END");
		}
	}

	public List<SigitVSk4GfDto> getCompGfAttiviInDataProgressivi(String codImpianto, String dataControllo, List<String> listaProgressivi) throws DbManagerException {
		log.debug("[DbMgr::getCompGfAttiviInDataProgressivi] START");
		try {
			CompFilter input = new CompFilter(codImpianto, listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitVSk4GfDao().findAttiviByCodImpiantoProgressivi(input);
		} catch (SigitVSk4GfDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getCompGfAttiviInDataProgressivi] END");
		}
	}
	
	/*
	public List<SigitVSk4ScDto> getCompScAttiviInData(String codImpianto, Date dataControllo, BigDecimal idPersonaGiuridica ) throws DbManagerException
	{
		log.debug("[DbMgr::getCompScAttiviInData] START");
		try {
			SigitVSk4ScDto input = new SigitVSk4ScDto();
			input.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			input.setDataInstall(new java.sql.Date(dataControllo.getTime()));
			input.setIdPersonaGiuridica(idPersonaGiuridica);

			return getSigitVSk4ScDao().findAttiviByCodImpianto(input);
		} catch (SigitVSk4ScDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompScAttiviInData] END");
		}
	}
	*/

	public List<SigitVSk4ScDto> getDescCompScAttiviInDataProgressivi(String codImpianto, String dataControllo, List<String> listaProgressivi) throws DbManagerException {
		log.debug("[DbMgr::getDescCompScAttiviInDataProgressivi] START");
		try {
			CompFilter input = new CompFilter(codImpianto, listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitVSk4ScDao().findAppAttiviByCodImpiantoProgressivi(input);
		} catch (SigitVSk4ScDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getDescCompScAttiviInDataProgressivi] END");
		}
	}

	public List<SigitVSk4ScDto> getCompScAttiviInDataProgressivi(String codImpianto, String dataControllo, List<String> listaProgressivi) throws DbManagerException {
		log.debug("[DbMgr::getCompScAttiviInDataProgressivi] START");
		try {
			CompFilter input = new CompFilter(codImpianto, listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitVSk4ScDao().findAttiviByCodImpiantoProgressivi(input);
		} catch (SigitVSk4ScDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getCompScAttiviInDataProgressivi] END");
		}
	}
	
	/*	
	public List<SigitVSk4CgDto> getCompCgAttiviInData(String codImpianto, Date dataControllo, BigDecimal idPersonaGiuridica) throws DbManagerException
	{
		log.debug("[DbMgr::getCompCgAttiviInData] START");
		try {
			SigitVSk4CgDto input = new SigitVSk4CgDto();
			input.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			input.setDataInstall(new java.sql.Date(dataControllo.getTime()));
			input.setIdPersonaGiuridica(idPersonaGiuridica);

			return getSigitVSk4CgDao().findAttiviByCodImpianto(input);
		} catch (SigitVSk4CgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getCompCgAttiviInData] END");
		}
	}
	*/

	public List<SigitVSk4GtDto> getCompGtAttiviInData(String codImpianto, java.util.Date dataControllo, BigDecimal idPersonaGiuridica) throws ManagerException {
		log.debug("[SigitbatchMgr::getCompGtAttiviInData] START");
		try {

			List<String> listProgApp = cercaElencoProgressiviApparecchiature(codImpianto, dataControllo, idPersonaGiuridica, Constants.ALLEGATO_TIPO_1);

			return getCompGtAttiviInDataProgressivi(codImpianto, ConvertUtil.convertToString(dataControllo), listProgApp);
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[SigitbatchMgr::getCompGtAttiviInData] END");
		}
	}

	public List<SigitVSk4GfDto> getCompGfAttiviInData(String codImpianto, java.util.Date dataControllo, BigDecimal idPersonaGiuridica) throws ManagerException {
		log.debug("[SigitbatchMgr::getCompGfAttiviInData] START");
		try {

			List<String> listProgApp = cercaElencoProgressiviApparecchiature(codImpianto, dataControllo, idPersonaGiuridica, Constants.ALLEGATO_TIPO_2);

			return getCompGfAttiviInDataProgressivi(codImpianto, ConvertUtil.convertToString(dataControllo), listProgApp);
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[SigitbatchMgr::getCompGfAttiviInData] END");
		}
	}

	public List<SigitVSk4ScDto> getCompScAttiviInData(String codImpianto, java.util.Date dataControllo, BigDecimal idPersonaGiuridica) throws ManagerException {
		log.debug("[SigitbatchMgr::getCompScAttiviInData] START");
		try {

			List<String> listProgApp = cercaElencoProgressiviApparecchiature(codImpianto, dataControllo, idPersonaGiuridica, Constants.ALLEGATO_TIPO_3);

			return getCompScAttiviInDataProgressivi(codImpianto, ConvertUtil.convertToString(dataControllo), listProgApp);
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[SigitbatchMgr::getCompScAttiviInData] END");
		}
	}

	public List<SigitVSk4CgDto> getCompCgAttiviInData(String codImpianto, java.util.Date dataControllo, BigDecimal idPersonaGiuridica) throws ManagerException {
		log.debug("[SigitbatchMgr::getCompCgAttiviInData] START");
		try {

			List<String> listProgApp = cercaElencoProgressiviApparecchiature(codImpianto, dataControllo, idPersonaGiuridica, Constants.ALLEGATO_TIPO_4);

			return getCompCgAttiviInDataProgressivi(codImpianto, ConvertUtil.convertToString(dataControllo), listProgApp);
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[SigitbatchMgr::getCompCgAttiviInData] END");
		}
	}

	public List<SigitVSk4CgDto> getDescCompCgAttiviInDataProgressivi(String codImpianto, String dataControllo, List<String> listaProgressivi) throws DbManagerException {
		log.debug("[DbMgr::getDescCompCgAttiviInDataProgressivi] START");
		try {
			CompFilter input = new CompFilter(codImpianto, listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitVSk4CgDao().findAppAttiviByCodImpiantoProgressivi(input);
		} catch (SigitVSk4CgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getDescCompCgAttiviInDataProgressivi] END");
		}
	}

	public List<SigitVSk4CgDto> getCompCgAttiviInDataProgressivi(String codImpianto, String dataControllo, List<String> listaProgressivi) throws DbManagerException {
		log.debug("[DbMgr::getCompCgAttiviInDataProgressivi] START");
		try {
			CompFilter input = new CompFilter(codImpianto, listaProgressivi, ConvertUtil.convertToSqlDate(dataControllo));
			return getSigitVSk4CgDao().findAttiviByCodImpiantoProgressivi(input);
		} catch (SigitVSk4CgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getCompCgAttiviInDataProgressivi] END");
		}
	}

	public List<String> cercaElencoProgressiviApparecchiature(String codImpianto, java.util.Date dataControllo, BigDecimal idPersonaGiuridica, String idTipoDocumento) throws ManagerException {
		log.debug("[SigitMgr::cercaElencoProgressiviApparecchiature] BEGIN");
		List<String> listProgApparecchiature = null;
		try {

			if (GenericUtil.isNotNullOrEmpty(idTipoDocumento)) {
				int idTipoDoc = ConvertUtil.convertToInteger(idTipoDocumento).intValue();

				CompFilter filter = new CompFilter(codImpianto, ConvertUtil.convertToSqlDate(dataControllo), ConvertUtil.convertToInteger(idPersonaGiuridica));

				//List<SigitTComp4Dto> listApparecchiatureDto = getDbMgr().getSigitTComp4Dao().findByFilter(filter);

				List<SigitExtComponenteDto> listApparecchiatureDto = findComponentiByFilter(filter, idTipoDoc);

				if (listApparecchiatureDto != null && listApparecchiatureDto.size() > 0) {
					listProgApparecchiature = new ArrayList<String>();

					for (SigitExtComponenteDto sigitExtComponenteDto : listApparecchiatureDto) {
						listProgApparecchiature.add(ConvertUtil.convertToString(sigitExtComponenteDto.getProgressivo()));
					}
				}

			}
		} catch (DbManagerException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[SigitMgr::cercaElencoProgressiviApparecchiature] END");
		}

		return listProgApparecchiature;
	}

	public List<SigitExtComponenteDto> findComponentiByFilter(CompFilter filter, int idTipoDoc) throws DbManagerException {
		String nomeTabellaComp = null;
		List<SigitExtComponenteDto> listApparecchiatureDto = null;

		try {
			if (idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_1)) {
				nomeTabellaComp = "SIGIT_T_COMP_GT";
			} else if (idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_2)) {
				nomeTabellaComp = "SIGIT_T_COMP_GF";
			} else if (idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_3)) {
				nomeTabellaComp = "SIGIT_T_COMP_SC";
			} else if (idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_4)) {
				nomeTabellaComp = "SIGIT_T_COMP_CG";
			}

			listApparecchiatureDto = getSigitExtDao().findComponentiByFilter(filter, nomeTabellaComp);
		} catch (SigitExtDaoException e) {
			log.error("Errore: ", e);
			throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		return listApparecchiatureDto;
	}

	//	public SigitVCompGtDettDto getCompGtAttivoInDataProg(BigDecimal codImpianto, Date dataControllo, BigDecimal progressivo) throws DbManagerException
	//	{
	//		log.debug("[DbMgr::getCompGtAttivoInDataProg] START");
	//		SigitVCompGtDettDto dto = null;
	//		try {
	//			List<SigitVCompGtDettDto> dtoList = null;
	//			SigitVCompGtDettDto input = new SigitVCompGtDettDto();
	//			input.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
	//			input.setDataInstall(new java.sql.Date(dataControllo.getTime()));
	//			input.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
	//			dtoList = getSigitVCompGtDettDao().findAttiviByCodImpianto(input);
	//			if (dtoList != null && dtoList.size() == 1)
	//			{
	//				dto = dtoList.get(0);
	//			}
	//
	//		} catch (SigitVCompGtDettDaoException e) {
	//			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
	//		}
	//		finally {
	//			log.debug("[DbMgr::getCompGtAttivoInDataProg] END");
	//		}
	//		return dto;
	//	}

	/**
	 * Cerco l'fk_imp_ruolo_pfpg
	 *
	 * @param codice impianto
	 * @return id persona giuridica
	 * @throws DbManagerException Errore durante il recupero dei dati
	 * @throws
	 */

	public String getIdImpiantoRuoloPfPg(String codiceImpianto, BigDecimal idPersonaGiuridica, String idTipoDocumento) throws DbManagerException {
		String value = null;
		log.debug("[DbMgr::getIdImpiantoRuoloPfPg] BEGIN");
		try {
			//cerco il ruolo dalla tabella di relazione sigit_r_ruolo_tipodoc
			List<SigitRRuoloTipodocDto> rRuoloTipoDoc = this.getSigitRRuoloTipodocDao().findVerificaAllegatoSelezionato(ConvertUtil.convertToInteger(idTipoDocumento));

			SigitRImpRuoloPfpgDto input = new SigitRImpRuoloPfpgDto();
			input.setCodiceImpianto(new BigDecimal(codiceImpianto));
			input.setFkPersonaGiuridica(idPersonaGiuridica);
			if (rRuoloTipoDoc != null) {
				SigitRRuoloTipodocDto ruolo = rRuoloTipoDoc.get(0);
				input.setFkRuolo(ruolo.getIdRuolo());
			}
			//cerco un oggetto univoco 
			List<SigitRImpRuoloPfpgDto> dtoRImp = getSigitRImpRuoloPfpgDao().findByPersonaGiuridicaCodImpianto(input);
			if (dtoRImp != null && dtoRImp.size() > 0) {
				SigitRImpRuoloPfpgDto dto = dtoRImp.get(0);
				//recupero l'id 
				value = "" + dto.getIdImpRuoloPfpg();
			}
		} catch (SigitRImpRuoloPfpgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitRRuoloTipodocDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getIdImpiantoRuoloPfPg] END");
		}
		return value;
	}
	
	
	/*
	public MODIIDocument getModuloAllegatoTipo1(MODIIDocument modulo, SigitTAllegatoDto allegatoDto)throws DbManagerException {
		log.debug("[DbMgr::getModuloAllegatoTipo1] BEGIN");
		
		String codiceImpianto = null;
//		SigitTAllegatoDto allegatoDto = null;
		SigitTImpiantoDto impiantoDto =null;
		SigitRImpRuoloPfpgDto rImpRuoloPfPg = null;
		SigitTPersonaGiuridicaDto personaGiuridicaDto = null;
		SigitTPersonaFisicaDto personaFisicaDto = null;
		SigitTPersonaGiuridicaDto manutentore = null;
		String idRuolo = null;
		
		try {
			
			it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta richiesta = modulo.getMODII().getRichiesta();
			
			RowAllegatoII allegato = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIArray(0);
			
			// Recupero il codice impianto
			codiceImpianto = allegato.getCodiceCatasto();
			
			java.sql.Date dataControllo = ConvertUtil.convertToDate(allegato.getAFDataControllo());
			
			// BOLLINO
			richiesta.getDatiIntestazione().getCodiceBollino();
			
//			SigitTAllegatoPk pk = new SigitTAllegatoPk();
//			pk.setIdAllegato(new BigDecimal(dettaglio.getIdAllegato()));
			
			//trovo il dettaglio ALLEGATO
			//allegatoDto = getSigitTAllegatoDao().findByPrimaryKey(pk);
			
			SigitTImpiantoPk pkImpianto = new SigitTImpiantoPk();
			pkImpianto.setCodiceImpianto(new BigDecimal(codiceImpianto));
			
			//trovo il dettaglio IMPIANTO
			impiantoDto = getSigitTImpiantoDao().findByPrimaryKey(pkImpianto);
			
			//trovo l'unità immobiliare,dati locazione impianto
			List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare = getUnitaImmobiliariImpianto(ConvertUtil.convertToInteger(codiceImpianto));
			
//			SigitVTotImpiantoDto responsabile = cercaResponsabileAttivoAllaDataByCodImpianto(dettaglio.getCodiceImpianto(), dettaglio.getDataControllo());
			
			
			log.debug("[DbMgr::getModuloAllegatoTipo1] passo 1");
			
			
			List<SigitVTotImpiantoDto> listTerzoResp = cerca3ResponsabiliAttiviAllaDataByCodImpianto(codiceImpianto, dataControllo);
			
			log.debug("[DbMgr::getModuloAllegatoTipo1] passo 2");

			
			SigitVTotImpiantoDto responsabile = null;
			boolean isTerzoResp = false;
			if(listTerzoResp!=null && !listTerzoResp.isEmpty())
			{
				responsabile = listTerzoResp.get(0);
				isTerzoResp = true;
			}
			else
			{
				
				log.debug("[DbMgr::getModuloAllegatoTipo1] passo 3");

				responsabile = cercaResponsabileAttivoAllaDataImpianto(ConvertUtil.convertToInteger(codiceImpianto), dataControllo);
			}
			
			log.debug("[DbMgr::getModuloAllegatoTipo1] passo 4");

			
			//ne deve trovare solo UNO
			if(responsabile!=null){
				if(isTerzoResp)
				{
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaGiuridica3r());
					personaGiuridicaDto = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				}
				else if(responsabile.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
					//è una persona giuridica
					SigitTPersonaGiuridicaPk pkGiuridica = new SigitTPersonaGiuridicaPk();
					pkGiuridica.setIdPersonaGiuridica(responsabile.getIdPersonaFisica());
					personaGiuridicaDto = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridica);
				}else{
					//è una persona fisica
					SigitTPersonaFisicaPk pkFisica = new SigitTPersonaFisicaPk();
					pkFisica.setIdPersonaFisica(responsabile.getIdPersonaFisica());
					personaFisicaDto = this.getSigitTPersonaFisicaDao().findByPrimaryKey(pkFisica );
				}
				idRuolo = ""+responsabile.getIdRuolo();
			}else{
				throw new DbManagerException(new Message(Messages.ERROR_RECUPERO_DATI));
			}
			
			log.debug("[DbMgr::getModuloAllegatoTipo1] COMINCIO IL MAPPING DEI DATI");
			//comincio il mapping dei dati 
//			it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta richiesta = modulo.getMODII().getRichiesta();
//			//codice Bollino comune a tutte le pagine
//			richiesta.getDatiIntestazione().setCodiceBollino(ConvertUtil.formattaSiglaBollino(allegatoDto.getFkNumeroBollino()));
			//vado a lavorare sulle pagine del modulo
			List<RowAllegatoII> allegatoIIList = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
			
			log.debug("[DbMgr::getModuloAllegatoTipo1] passo 4.1 - allegatoIIList: "+allegatoIIList);

			
			List<SigitVCompGtDettDto> comGtDettList = getCompGtAttiviInData(codiceImpianto, dataControllo);
			
			//sezione c. tRATTAMENTO DELL'ACQUA
			SigitTTrattH2ODto dettaglioTrattAcqua = cercaTrattAcquaByCodiceImpianto(codiceImpianto);
			
			
			//int count = 1; //da cancellare
			//for(RowAllegatoII allegatoII : allegatoIIList){
			for (int i = 0; i < allegatoIIList.size(); i++) {
				
				RowAllegatoII allegatoII = allegatoIIList.get(i);
				
				SigitVCompGtDettDto comGtDett = comGtDettList.get(i);
			
				//log.debug("Quanti moduli di tipo allegatoII count: "+count);
				log.debug("idRuolo: "+idRuolo);
				
				log.debug("[DbMgr::getModuloAllegatoTipo1] passo 5");

				MapDto.mapToDatiPrecompilatiAllegato1(allegatoII, listaUnitaImmobiliare, impiantoDto);
				
				log.debug("[DbMgr::getModuloAllegatoTipo1] passo 6");

				MapDto.mapToDatiRespImpiantoAllegato1(allegatoII,personaGiuridicaDto,personaFisicaDto, idRuolo, isTerzoResp);
				log.debug("[DbMgr::getModuloAllegatoTipo1] passo 7");
				
				MapDto.mapToDatiPrecompilatiGtAllegato1(allegatoII, comGtDett);
				
				MapDto.mapToDatiPrecompilatiTratAcquaAllegato1(allegatoII, dettaglioTrattAcqua);

				//per cercare l'impresa manutentrice
				SigitRImpRuoloPfpgPk pkRimpRuoloPfPg = new SigitRImpRuoloPfpgPk();
				
				log.debug("[DbMgr::getModuloAllegatoTipo1] passo 8");

				
				pkRimpRuoloPfPg.setIdImpRuoloPfpg(allegatoDto.getFkImpRuoloPfpg());
				
				log.debug("[DbMgr::getModuloAllegatoTipo1] passo 9");

				rImpRuoloPfPg = this.getSigitRImpRuoloPfpgDao().findByPrimaryKey(pkRimpRuoloPfPg);
				
				log.debug("[DbMgr::getModuloAllegatoTipo1] passo 10");

				if(rImpRuoloPfPg.getFkPersonaGiuridica()!=null){
					SigitTPersonaGiuridicaPk pkGiuridicaManutentore = new SigitTPersonaGiuridicaPk();
					
					log.debug("[DbMgr::getModuloAllegatoTipo1] passo 11");

					pkGiuridicaManutentore.setIdPersonaGiuridica(rImpRuoloPfPg.getFkPersonaGiuridica());
					//ci deve essere se no c'è stato un errore nei dati
					//mi ricarico la persona giuridica con questo id
					 manutentore = this.getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkGiuridicaManutentore );
					 
					log.debug("[DbMgr::getModuloAllegatoTipo1] passo 12");

				}
				
				log.debug("[DbMgr::getModuloAllegatoTipo1] passo 13");

				
				//mapping dati dell'impresa manutentrice
				MapDto.mapToDatiImpresaManutentriceAllegato1(allegatoII, manutentore);
				
				log.debug("[DbMgr::getModuloAllegatoTipo1] passo 14");

				//count++; //da cancelare
			}
			
			log.debug("[DbMgr::getModuloAllegatoTipo1] passo 15");

			if(modulo.getMODII().getSystem()==null)
				modulo.getMODII().addNewSystem().addNewCatDig();
			if(modulo.getMODII().getSystem().getCatDig()==null)
				modulo.getMODII().getSystem().addNewCatDig();
			
			//definisce lo stato del modulo pdf ed è comune a tutte le pagine 
			richiesta.getDatiModulo().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);

			log.debug("[DbMgr::getModuloAllegatoTipo1] passo 16");

			modulo.getMODII().getSystem().getCatDig().setModuloEditabile(false);
			
			log.debug("[DbMgr::getModuloAllegatoTipo1] passo 17");

			
			log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			log.debug("STAMPO ALLEGATOII RESULT: "+modulo);
			log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			
			
//		} catch (SigitTAllegatoDaoException e) {
//			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitRImpRuoloPfpgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		
		log.debug("[DbMgr::getModuloAllegatoTipo1] END");
		return modulo;
	}
	*/

	public List<SigitTUnitaImmobiliareDto> getUnitaImmobiliariImpianto(Integer codImpianto) throws DbManagerException {
		log.debug("[DbMgr::getUnitaImmobiliariImpianto] BEGIN");
		try {
			return getSigitTUnitaImmobiliareDao().findByCodiceImpianto(codImpianto);
		} catch (SigitTUnitaImmobiliareDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} finally {
			log.debug("[DbMgr::getUnitaImmobiliariImpianto] END");
		}
	}

	public List<SigitVTotImpiantoDto> cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(String codImpianto, Date dataRapporto, String idTipoComponente, String componente) throws DbManagerException {
		List<SigitVTotImpiantoDto> dtoList = null;
		log.debug("[DbMgr::cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp] BEGIN");
		try {
			ContrattoFilter filter = new ContrattoFilter();
			filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			filter.setDataDal(dataRapporto);
			filter.setIdTipoComponente(idTipoComponente);
			filter.setComponente(componente);
			dtoList = MapDto.convertToListTotImpianto(getSigitExtDao().findStoriaContrattiImpiantoNew(filter));
		} catch (SigitExtDaoException e) {

			e.printStackTrace();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp] END");
		}
		return dtoList;
	}

	public void aggiornaRespRAllegatoComp(BigDecimal idAllegato, String codImpianto, String idTipoComponente, BigDecimal componente, java.sql.Date dataInstallazione, BigDecimal idImpRuoloPfPg, BigDecimal idContratto)
			throws DbManagerException {
		log.debug("[DbMgr::aggiornaStatoTransazioneBoll] BEGIN");
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

				getSigitRAllegatoCompGtDao().insert(dto);
				//getSigitRAllegatoCompGtDao().updateColumnsResponsabile(dto);
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

				getSigitRAllegatoCompGfDao().insert(dto);

				//getSigitRAllegatoCompGfDao().updateColumnsResponsabile(dto);
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

				getSigitRAllegatoCompScDao().insert(dto);

				//getSigitRAllegatoCompScDao().updateColumnsResponsabile(dto);
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

				getSigitRAllegatoCompCgDao().insert(dto);

				//getSigitRAllegatoCompCgDao().updateColumnsResponsabile(dto);
			}
		} catch (Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::aggiornaStatoTransazioneBoll] END");
		}
	}
	
	/*
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
	*/

	public SigitVTotImpiantoDto cercaResponsabileAttivoByCodImpianto(Integer codImpianto) throws DbManagerException {
		SigitVTotImpiantoDto responsabile = null;
		List<SigitVTotImpiantoDto> list3RespAttiviImpianto = cerca3ResponsabileAttivoByCodImpianto(codImpianto);
		if (list3RespAttiviImpianto == null || list3RespAttiviImpianto.isEmpty()) {
			List<SigitVTotImpiantoDto> listResp = cercaResponsabiliAttiviByCodImpianto(codImpianto);
			if (listResp != null && !listResp.isEmpty()) {
				responsabile = listResp.get(0);
			}
		} else {
			responsabile = list3RespAttiviImpianto.get(0);
		}

		return responsabile;
	}

	public List<SigitVTotImpiantoDto> cerca3ResponsabileAttivoByCodImpianto(Integer codImpianto) throws DbManagerException {
		List<SigitVTotImpiantoDto> dtoList = null;
		log.debug("[DbMgr::cerca3ResponsabileAttivoByCodImpianto] BEGIN");
		try {

			dtoList = getSigitVTotImpiantoDao().findTerziResponsabiliAttiviByCodiceImpianto(codImpianto);

		} catch (SigitVTotImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cerca3ResponsabileAttivoByCodImpianto] END");
		}
		return dtoList;
	}

	public List<SigitVTotImpiantoDto> cercaResponsabiliAttiviByCodImpianto(Integer codImpianto) throws DbManagerException {
		List<SigitVTotImpiantoDto> dtoList = null;
		log.debug("[DbMgr::cercaResponsabiliAttiviByCodImpianto] BEGIN");
		try {

			dtoList = getSigitVTotImpiantoDao().findResponsabiliAttiviByCodiceImpianto(codImpianto);

		} catch (SigitVTotImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaResponsabileAttivoByCodImpianto] END");
		}
		return dtoList;
	}

	/**
	 * Restituisce il modulo compilato con tutti i dati trovati sul db, da utilizzare quando si sta creando un libretto nuovo a partire da uno consolidato
	 *
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
			if (idLibretto != null) {
				SigitTLibrettoPk pkLibretto = new SigitTLibrettoPk();
				pkLibretto.setIdLibretto(new BigDecimal(idLibretto));
				libretto = getSigitTLibrettoDao().findByPrimaryKey(pkLibretto);
			}
			MODDocument modDoc = MODDocument.Factory.newInstance();
			modDoc.addNewMOD().addNewRichiesta().addNewDatiPrecompilati().addNewSezCatasto();

			Integer codImpiantoInt = new Integer(codImpianto);

			it.csi.sigit.sigitwebn.xml.libretto.data.RichiestaDocument.Richiesta richiesta = modDoc.getMOD().getRichiesta();
			DatiPrecompilati datiPrecompilati = richiesta.getDatiPrecompilati();

			datiPrecompilati.setElencoCombustibile(MapDto.mapToElencoCombustibile(getElencoCombustibile()));
			datiPrecompilati.setElencoFabbricante(MapDto.mapToElencoFabbricante(getElencoMarche()));
			datiPrecompilati.setElencoFluidoTermoVett(MapDto.mapToElencoFluido(getElencoFluidi()));
			datiPrecompilati.setElencoUM(MapDto.mapToElencoUnitaMisura(getElencoUnitaMisura()));

			compilaScheda1Libretto(richiesta, libretto, impianto);

			SigitTTrattH2OPk pkTrattAcq = new SigitTTrattH2OPk();
			pkTrattAcq.setCodiceImpianto(new BigDecimal(codImpianto));
			SigitTTrattH2ODto trattH2ODto = getSigitTTrattH2oDao().findByPrimaryKey(pkTrattAcq);
			if (trattH2ODto != null)
				MapDto.mapToSchedaTrattH2o(trattH2ODto, richiesta.addNewDatiSchedaTrattH2O());

			//GT
			List<SigitVSk4GtDto> compGtImpianto = getCompGt(codImpiantoInt);
			if (compGtImpianto != null && !compGtImpianto.isEmpty())
				MapDto.mapToSchedaGT(compGtImpianto, richiesta.addNewDatiSchedaGT());
			//BR
			SigitTCompBrRcDto inputBrRc = new SigitTCompBrRcDto();
			inputBrRc.setCodiceImpianto(new BigDecimal(codImpianto));
			inputBrRc.setTipologiaBrRc(Constants.TIPO_COMPONENTE_BR);
			List<SigitTCompBrRcDto> compBrImpianto = getSigitTCompBrRcDao().findByTipoAndCodImpiantoOrdered(inputBrRc);
			if (compBrImpianto != null && !compBrImpianto.isEmpty())
				MapDto.mapToSchedaBR(compBrImpianto, richiesta.addNewDatiSchedaBR(), compGtImpianto);
			//RC
			inputBrRc.setTipologiaBrRc(Constants.TIPO_COMPONENTE_RC);
			List<SigitTCompBrRcDto> compRcImpianto = getSigitTCompBrRcDao().findByTipoAndCodImpiantoOrdered(inputBrRc);
			if (compBrImpianto != null && !compRcImpianto.isEmpty())
				MapDto.mapToSchedaRC(compRcImpianto, richiesta.addNewDatiSchedaRC(), compGtImpianto);
			//GF
			List<SigitVSk4GfDto> compGfImpianto = getCompGf(codImpiantoInt);
			if (compGfImpianto != null && !compGfImpianto.isEmpty())
				MapDto.mapToSchedaGF(compGfImpianto, richiesta.addNewDatiSchedaGF());
			//SC
			List<SigitVSk4ScDto> compScImpianto = getCompSc(codImpiantoInt);
			if (compScImpianto != null && !compScImpianto.isEmpty())
				MapDto.mapToSchedaSC(compScImpianto, richiesta.addNewDatiSchedaSC());
			//CG
			List<SigitVSk4CgDto> compCgImpianto = getCompCg(codImpiantoInt);
			if (compCgImpianto != null && !compCgImpianto.isEmpty())
				MapDto.mapToSchedaCG(compCgImpianto, richiesta.addNewDatiSchedaCG());
			//CS
			List<SigitVCompCsDto> compCsImpianto = getSigitVCompCsDao().findByCodImpiantoOrdered(codImpiantoInt);
			if (compCsImpianto != null && !compCsImpianto.isEmpty())
				MapDto.mapToSchedaCS(compCsImpianto, richiesta.addNewDatiSchedaCS());
			//AG
			List<SigitVCompAgDto> compAgImpianto = getSigitVCompAgDao().findByCodImpiantoOrdered(codImpiantoInt);
			if (compAgImpianto != null && !compAgImpianto.isEmpty())
				MapDto.mapToSchedaAG(compAgImpianto, richiesta.addNewDatiSchedaAG());

			//5-7
			SigitTCompXSemplicePk pkXSemplice = new SigitTCompXSemplicePk();
			pkXSemplice.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpiantoInt));
			SigitTCompXSempliceDto compXSemplice = getSigitTCompXSempliceDao().findByPrimaryKey(pkXSemplice);
			if (compXSemplice != null) {
				//sez5
				MapDto.mapToSchedaSistemiRegolarizzazionePrimaria(richiesta.addNewDatiSchedaSistemiRegolaz().addNewRegolazionePrimaria(), compXSemplice);
				MapDto.mapToSchedaSistemiRegolarizzazioneSingoloAmbiente(richiesta.getDatiSchedaSistemiRegolaz().addNewRegolazioneSingoloAmb(), compXSemplice);
				//SR
				List<SigitVCompSrDto> srList = getSigitVCompSrDao().findByCodImpiantoOrdered(codImpiantoInt);
				if (srList != null && !srList.isEmpty())
					MapDto.mapToSchedaSR(richiesta.getDatiSchedaSistemiRegolaz().getRegolazionePrimaria().addNewSezSR(), srList);
				//sez6
				MapDto.mapToSchedaSistemiDistribuiti(richiesta.addNewDatiSchedaSistemiDistrib(), compXSemplice);
				//VR
				List<SigitVCompVrDto> vrList = getSigitVCompVrDao().findByCodImpiantoOrdered(codImpiantoInt);
				if (vrList != null && !vrList.isEmpty())
					MapDto.mapToSchedaVR(richiesta.getDatiSchedaSistemiRegolaz().getRegolazionePrimaria().addNewSezVR(), vrList);
				//VX
				List<SigitTCompVxDto> vxList = getSigitTCompVxDao().findByCodImpianto(codImpiantoInt);
				if (vxList != null && !vxList.isEmpty())
					MapDto.mapToSchedaVX(richiesta.getDatiSchedaSistemiDistrib().addNewSezVasi(), vxList);
				//PO
				List<SigitVCompPoDto> poList = getSigitVCompPoDao().findByCodImpiantoOrdered(codImpiantoInt);
				if (poList != null && !poList.isEmpty())
					MapDto.mapToSchedaPO(richiesta.getDatiSchedaSistemiDistrib().addNewSezPO(), poList);
				//sez7
				MapDto.mapToSchedaSistemiEmissione(richiesta.addNewDatiSchedaSistemaEmissione(), compXSemplice);
			}
			//8 - AC
			List<SigitVCompAcDto> acList = getSigitVCompAcDao().findByCodImpiantoOrdered(codImpiantoInt);
			if (acList != null && !acList.isEmpty())
				MapDto.mapToSchedaAC(richiesta.addNewDatiSchedaSistemaAC().addNewSezAC(), acList);
			//9.1 - TE
			List<SigitVCompTeDto> teList = getSigitVCompTeDao().findByCodImpiantoOrdered(codImpiantoInt);
			if (teList != null && !teList.isEmpty())
				MapDto.mapToSchedaTE(richiesta.addNewDatiAltriComponentiTE().addNewSezTE(), teList);
			//9.2 - RV
			List<SigitVCompRvDto> rvList = getSigitVCompRvDao().findByCodImpiantoOrdered(codImpiantoInt);
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
			List<SigitVCompCiDto> ciList = getSigitVCompCiDao().findByCodImpiantoOrdered(codImpiantoInt);
			if (ciList != null && !ciList.isEmpty())
				MapDto.mapToSchedaCI(richiesta.addNewDatiAltriComponentiCI().addNewSezCI(), ciList);

			//9.5 - UT
			List<SigitVCompUtDto> utList = getSigitVCompUtDao().findByCodImpiantoOrdered(codImpiantoInt);
			if (utList != null && !utList.isEmpty())
				MapDto.mapToSchedaUT(richiesta.addNewDatiAltriComponentiUT().addNewSezUT(), utList);

			//9.6 - RC
			List<SigitVCompRcDto> rcList = getSigitVCompRcDao().findByCodImpiantoOrdered(codImpiantoInt);
			if (rcList != null && !rcList.isEmpty())
				MapDto.mapToSchedaRC(richiesta.addNewDatiAltriComponentiRC().addNewSezRC(), rcList);

			//10.1 - VM
			List<SigitVCompVmDto> vmList = getSigitVCompVmDao().findByCodImpiantoOrdered(codImpiantoInt);
			if (vmList != null && !vmList.isEmpty())
				MapDto.mapToSchedaVM(richiesta.addNewDatiVentilazMeccanicaVM().addNewSezVM(), vmList);

			richiesta.addNewDatiRisultatiGT().xsetL111FlagNorma(MapDto.getXmlBoolean(ConvertUtil.convertToBooleanAllways(impianto.getL111FlgNormaUni103891())));
			richiesta.getDatiRisultatiGT().xsetL111FlagAltro(MapDto.getXmlBoolean(GenericUtil.isNotNullOrEmpty(impianto.getL111AltraNorma())));
			richiesta.getDatiRisultatiGT().setL111DescrAltro(impianto.getL111AltraNorma());

			List<SigitVCompGtDettDto> compGtImpiantoDett = getCompGtDett(codImpiantoInt);
			List<SigitVCompGfDettDto> compGfImpiantoDett = getCompGfDett(codImpiantoInt);
			List<SigitVCompScDettDto> compScImpiantoDett = getCompScDett(codImpiantoInt);
			List<SigitVCompCgDettDto> compCgImpiantoDett = getCompCgDett(codImpiantoInt);

			compilaDatiResponsabiliEControlliLibretto(codImpiantoInt, richiesta, compGtImpiantoDett, compGfImpiantoDett, compScImpiantoDett, compCgImpiantoDett);

			compilaScheda14Libretto(codImpianto, richiesta);

			if (isDefinitivo) {
				datiPrecompilati.setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
				modDoc.getMOD().addNewSystem().addNewCatDig().setModuloEditabile(false);
				modDoc.getMOD().getSystem().getCatDig().setBtSalva(false);
			} else {
				datiPrecompilati.setStatoModulo(Constants.STATO_MODULO_BOZZA);
				modDoc.getMOD().addNewSystem().addNewCatDig().setModuloEditabile(true);
				modDoc.getMOD().getSystem().getCatDig().setBtSalva(true);
			}

			log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			log.debug("STAMPO RESULT: " + modDoc);
			log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

			return modDoc;

		} catch (Exception e) {
			log.error("Errore getLibretto", e);
			throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} finally {
			log.debug("[DbMgr::getModuloLibretto] END");
		}
	}

	private void compilaScheda1Libretto(Richiesta richiesta, SigitTLibrettoDto libretto, SigitTImpiantoDto impianto) throws DbManagerException {
		log.debug("[DbMgr:::compilaScheda1Libretto] - START");
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

		richiesta.setDatiSchedaIdentificativaImp(DatiSchedaIdentificativaImp.Factory.newInstance());
		DatiSchedaIdentificativaImp datiImpianto = richiesta.getDatiSchedaIdentificativaImp();
		MapDto.mapToSchedaIdentificativaImpianto(datiImpianto, libretto, impianto, unitaImmobPrincipale);
		MapDto.mapToDatiPrecompilati(richiesta.getDatiPrecompilati(), unitaImmobPrincipale, impianto, unitaImmobSecondarie);
		log.debug("[DbMgr:::compilaScheda1Libretto] - END");
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
	public void compilaDatiResponsabiliEControlliLibretto(Integer codImpiantoInt, Richiesta richiesta, List<SigitVCompGtDettDto> compGtImpiantoDett, List<SigitVCompGfDettDto> compGfImpiantoDett, List<SigitVCompScDettDto> compScImpiantoDett, List<SigitVCompCgDettDto> compCgImpiantoDett)
			throws ServiceException, SigitVRicercaAllegatiDaoException {
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
			if (respAttivi != null && !respAttivi.isEmpty()) {
				MapDto.mapResponsabileImpianto(richiesta.getDatiPrecompilati(), respAttivi.get(0));
			}

			//TERZO RESPONSABILE
			log.debug("Ricerca contratti impianto");
			ContrattoFilter filterContratti = new ContrattoFilter();
			filterContratti.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpiantoInt));
			List<SigitExtContrattoImpDto> contratti = getSigitExtDao().findStoriaContrattiImpiantoNew(filterContratti);
			richiesta.getDatiPrecompilati().setSezNomine(SezNomine.Factory.newInstance());
			MapDto.mapToSezNomine(contratti, richiesta.getDatiPrecompilati().getSezNomine());
		} catch (SigitVTotImpiantoDaoException e) {
			log.error("Errore (responsabili) compilaDatiResponsabiliLibretto", e);
			throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} catch (SigitExtDaoException e) {
			log.error("Errore (contratti) compilaDatiResponsabiliLibretto", e);
			throw new ServiceException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} finally {
			log.debug("[DbMgr::compilaDatiResponsabiliLibretto] END");
		}

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

		//TODO 13 - risultati ispezione
		//		richiesta.addNewDatiRisultatiIspez().addNewSezRisultati();
	}

	private void compilaScheda14Libretto(String codImpianto, Richiesta richiesta) throws NumberFormatException, SigitTConsumo14_4DaoException, SigitTConsumoDaoException {
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
		List<SigitTConsumo14_4Dto> pcList = getSigitTConsumo144Dao().findByCodImpianto(new Integer(codImpianto));
		if (pcList != null && !pcList.isEmpty())
			MapDto.mapToSchedaProdottiChimici(richiesta.getDatiConsumoProdottiChimici().addNewSezConsumo(), pcList);

		log.debug("[DbMgr:::compilaScheda14Libretto] - END");
	}

	public List<SigitVCompGtDettDto> getCompGtDett(Integer codImpiantoInt) throws SigitVCompGtDettDaoException {
		return getSigitVCompGtDettDao().findByCodImpiantoOrdered(codImpiantoInt);
	}

	public List<SigitVSk4GtDto> getCompGt(Integer codImpiantoInt) throws SigitVSk4GtDaoException {
		return getSigitVSk4GtDao().findByCodImpiantoOrdered(codImpiantoInt);
	}

	public List<SigitVCompGfDettDto> getCompGfDett(Integer codImpiantoInt) throws SigitVCompGfDettDaoException {
		return getSigitVCompGfDettDao().findByCodImpiantoOrdered(codImpiantoInt);
	}

	public List<SigitVSk4GfDto> getCompGf(Integer codImpiantoInt) throws SigitVSk4GfDaoException {
		return getSigitVSk4GfDao().findByCodImpiantoOrdered(codImpiantoInt);
	}

	public List<SigitVCompScDettDto> getCompScDett(Integer codImpiantoInt) throws SigitVCompScDettDaoException {
		return getSigitVCompScDettDao().findByCodImpiantoOrdered(codImpiantoInt);
	}

	public List<SigitVSk4ScDto> getCompSc(Integer codImpiantoInt) throws SigitVSk4ScDaoException {
		return getSigitVSk4ScDao().findByCodImpiantoOrdered(codImpiantoInt);
	}

	public List<SigitVCompCgDettDto> getCompCgDett(Integer codImpiantoInt) throws SigitVCompCgDettDaoException {
		return getSigitVCompCgDettDao().findByCodImpiantoOrdered(codImpiantoInt);
	}

	public List<SigitVSk4CgDto> getCompCg(Integer codImpiantoInt) throws SigitVSk4CgDaoException {
		return getSigitVSk4CgDao().findByCodImpiantoOrdered(codImpiantoInt);
	}

	public List<SigitDCombustibileDto> getElencoCombustibile() throws DbManagerException {
		log.debug("[DbMgr::getElencoCombustibile] START");
		try {
			return getSigitDCombustibileDao().findAll();
		} catch (SigitDCombustibileDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getElencoCombustibile] END");
		}
	}

	public List<SigitDMarcaDto> getElencoMarche() throws DbManagerException {
		log.debug("[DbMgr::getElencoMarche] START");
		try {
			return getSigitDMarcaDao().findAll();
		} catch (SigitDMarcaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getElencoMarche] END");
		}
	}

	public List<SigitDFluidoDto> getElencoFluidi() throws DbManagerException {
		log.debug("[DbMgr::getElencoFluidi] START");
		try {
			return getSigitDFluidoDao().findAll();
		} catch (SigitDFluidoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getElencoFluidi] END");
		}
	}

	public List<SigitDUnitaMisuraDto> getElencoUnitaMisura() throws DbManagerException {
		log.debug("[DbMgr::getElencoUnitaMisura] START");
		try {
			return getSigitDUnitaMisuraDao().findAll();
		} catch (SigitDUnitaMisuraDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getElencoUnitaMisura] END");
		}
	}

	public void consolidaLibretto(SigitTLibrettoDto dto, DatiSchedaIdentificativaImp datiImp) throws DbManagerException {
		log.debug("[DbMgr::consolidaLibretto] BEGIN");
		try {
			// BEPPE - SigitTLibrettoDto dto = MapDto.getSigitTLibretto(libretto, datiImp);
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());
			dto.setFkStato(new BigDecimal(Constants.ID_STATO_LIBRETTO_CONSOLIDATO));
			dto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
			getSigitTLibrettoDao().update(dto);
		} catch (SigitTLibrettoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::consolidaLibretto] END");
		}
	}

	public SigitTLibrettoDto cercaSigitTLibrettoConsolidatoByCodImpianto(String codImpianto) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitTLibrettoByCodImpianto] BEGIN");
		try {

			SigitTLibrettoDto librettoDto = null;
			List<SigitTLibrettoDto> librettoDtoList = cercaLibrettoByStato(codImpianto, Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			//(MapDto.mapToSigitTUnitaImmobiliareDto(impianto, cfUtenteMod));

			if (librettoDtoList != null && librettoDtoList.size() == 1) {
				librettoDto = librettoDtoList.get(0);
			}

			return librettoDto;

		} catch (Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaSigitTLibrettoByCodImpianto] END");
		}
	}

	public void inserisciLibretto(SigitTLibrettoDto dto) throws DbManagerException {
		log.debug("[DbMgr::inserisciLibretto] BEGIN");
		try {
			getSigitTLibrettoDao().insert(dto);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::inserisciLibretto] END");
		}
	}

	/**
	 * Passare in input all'oggetto filter, il codice impianto e l'utente
	 *
	 * @param filter
	 * @throws DbManagerException
	 */
	public void storicizzaLibretti(SigitTLibrettoDto filter) throws DbManagerException {
		try {
			log.debug("Storicizzazione libretti consolidati");
			filter.setDataUltMod(DateUtil.getSqlDataCorrente());
			getSigitTLibrettoDao().customUpdaterStoricizzaByCodImpianto(filter, null);
		} catch (SigitTLibrettoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
	}

	public void updateTxtLibretto(BigDecimal idLibretto, String txtLibretto) throws DbManagerException {
		log.debug("[DbMgr::updateTxtLibretto] START");
		try {
			SigitTLibTxtDto dto = new SigitTLibTxtDto();
			dto.setIdLibretto(idLibretto);
			dto.setXmlLibretto(txtLibretto);
			getSigitTLibTxtDao().update(dto);
		} catch (SigitTLibTxtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::updateTxtLibretto] END");
		}
	}

	public String cercaMailPfImportatore(Integer idImport) throws DbManagerException {
		String mail = null;

		log.debug("[DbMgr::cercaMailPfImportatore] BEGIN");

		try {
			List<SigitTPersonaFisicaEmailPfImportDto> dtoList = getSigitTPersonaFisicaDao().findEmailPfImport(idImport);

			if ((dtoList != null) && (dtoList.size() > 0)) {
				mail = dtoList.get(0).getPfEmail();
				log.debug("[DbMgr::cercaMailPfImportatore] Stampo la mail trovata: " + mail);
			} else {
				log.debug("[DbMgr::cercaMailPfImportatore] Nessun DTO trovato");
			}

		} catch (SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaPfImportatore] END");
		}

		return mail;
	}

	public SigitTImportDto cercaImportById(Integer idImport) throws DbManagerException {
		SigitTImportDto dto = null;

		log.debug("[DbMgr::cercaImportById] BEGIN");

		try {
			dto = getSigitTImportDao().findByPrimaryKey(new SigitTImportPk(idImport));

		} catch (SigitTImportDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaImportById] END");
		}

		return dto;
	}

	public SigitVRicercaAllegatiDto cercaSigitVRicercaAllegatiByIdAllegato(BigDecimal idAllegato) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitVRicercaAllegatiByIdAllegato] BEGIN");
		SigitVRicercaAllegatiDto allegatoDto = null;
		try {

			List<SigitVRicercaAllegatiDto> allegatoDtoList = getSigitVRicercaAllegatiDao().findByIdAllegato(ConvertUtil.convertToInteger(idAllegato));

			if (allegatoDtoList != null && allegatoDtoList.size() == 1) {
				allegatoDto = allegatoDtoList.get(0);
			}

			return allegatoDto;

		} catch (Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaSigitVRicercaAllegatiByIdAllegato] END");
		}
	}

	public SigitTPersonaGiuridicaDto cercaSigitTPersonaGiuridicaByIdImpRuoloPfpg(BigDecimal idImpRuoloPfpg) throws DbManagerException {
		log.debug("[DbMgr::cercaSigitTPersonaGiuridicaByIdImpRuoloPfpg] BEGIN");
		try {

			SigitRImpRuoloPfpgDto impRuoloPfpgDto = getSigitRImpRuoloPfpgDao().findByPrimaryKey(new SigitRImpRuoloPfpgPk(idImpRuoloPfpg));
			//(MapDto.mapToSigitTUnitaImmobiliareDto(impianto, cfUtenteMod));

			SigitTPersonaGiuridicaDto personaGiuridicaDto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(impRuoloPfpgDto.getFkPersonaGiuridica()));

			return personaGiuridicaDto;

		} catch (Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaSigitTPersonaGiuridicaByIdImpRuoloPfpg] END");
		}
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

		dto = cercaConfigValue(chiave);

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

			if ((dtoList != null) && (dtoList.size() > 0)) {
				dto = dtoList.get(0);
				log.debug("[DbMgr::getConfigValue] Trovato il DTO " + dto);
			} else {
				log.debug("[DbMgr::getConfigValue] Nessun DTO trovato");
			}
		} catch (SigitWrkConfigDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::getConfigValue] END");
		}
		return dto;
	}

	public SigitVTotImpiantoDto cercaResponsabileAttivoAllaDataImpianto(String codImpianto, Date dataRapporto) throws DbManagerException {
		SigitVTotImpiantoDto responsabile = null;

		log.debug("[DbMgr::cercaResponsabileAttivoAllaDataImpianto] BEGIN");
		try {
			ResponsabileFilter filter = new ResponsabileFilter(ConvertUtil.convertToInteger(codImpianto), ConvertUtil.convertToSqlDate(dataRapporto));

			List<SigitVTotImpiantoDto> listResp = getSigitVTotImpiantoDao().findResponsabiliAttiviAllaDataByCodiceImpianto(filter);
			if (listResp != null && !listResp.isEmpty()) {
				responsabile = listResp.get(0);
			}
		} catch (SigitVTotImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaResponsabileAttivoAllaDataImpianto] END");
		}
		return responsabile;
	}

	public SigitTPersonaGiuridicaDto cercaTPersonaGiuridicaById(Integer idPersonaG) throws DbManagerException {
		SigitTPersonaGiuridicaDto dto = null;
		log.debug("[DbMgr::cercaTPersonaGiuridicaById] BEGIN");
		try {

			dto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(ConvertUtil.convertToBigDecimal(idPersonaG)));

		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaTPersonaGiuridicaById] END");
		}
		return dto;
	}

	public SigitTPersonaFisicaDto cercaTPersonaFisicaById(Integer idPersonaF) throws DbManagerException {
		SigitTPersonaFisicaDto dto = null;
		log.debug("[DbMgr::cercaTPersonaFisicaById] BEGIN");
		try {
			dto = getSigitTPersonaFisicaDao().findByPrimaryKey(new SigitTPersonaFisicaPk(ConvertUtil.convertToBigDecimal(idPersonaF)));
		} catch (SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaTPersonaFisicaById] END");
		}
		return dto;
	}

	public void cancellaSigitTRifCatastByImportDistribCanc() throws DbManagerException {
		log.debug("[DbMgr::cancellaSigitTRifCatastByImportDistribCanc] BEGIN");
		try {

			Integer[] idStatoImportDistrib = new Integer[] { Constants.ID_STATO_IMP_DISTRIBUTORE_SOSTITUITO, Constants.ID_STATO_IMP_DISTRIBUTORE_ELIMINATO };

			// Recupero la lista dei riferimenti catastali collegati ad un import cancellato
			List<SigitTRifCatastAllByIdStatoImportDistribDto> dtoList = getSigitTRifCatastDao().findAllByIdStatoImportDistrib(idStatoImportDistrib);

			if (dtoList != null && dtoList.size() > 0) {

				log.debug("Ho cercato nella tabella SigitTRifCatast le occorrenze da cancellare: " + dtoList.size());

				// Cancello gli elemnti uno alla volta
				for (SigitTRifCatastAllByIdStatoImportDistribDto dto : dtoList) {
					getSigitTRifCatastDao().delete(new SigitTRifCatastPk(dto.getRcIdRifCatast()));
				}
			}

		} catch (SigitTRifCatastDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cancellaSigitTRifCatastByImportDistribCanc] END");
		}
	}

	public void cancellaSigitTDatoDistribByImportDistribCanc() throws DbManagerException {
		log.debug("[DbMgr::cancellaSigitTDatoDistribByImportDistribCanc] BEGIN");
		try {

			Integer[] idStatoImportDistrib = new Integer[] { Constants.ID_STATO_IMP_DISTRIBUTORE_SOSTITUITO, Constants.ID_STATO_IMP_DISTRIBUTORE_ELIMINATO };

			// Recupero la lista dei riferimenti catastali collegati ad un import cancellato
			List<SigitTDatoDistribAllByIdStatoImportDistribDto> dtoList = getSigitTDatoDistribDao().findAllByIdStatoImportDistrib(idStatoImportDistrib);

			if (dtoList != null && dtoList.size() > 0) {

				log.debug("Ho cercato nella tabella SigitTRifCatast le occorrenze da cancellare: " + dtoList.size());

				// Cancello gli elemnti uno alla volta
				for (SigitTDatoDistribAllByIdStatoImportDistribDto dto : dtoList) {
					getSigitTDatoDistribDao().delete(new SigitTDatoDistribPk(dto.getDdIdDatoDistrib()));
				}
			}

		} catch (SigitTDatoDistribDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cancellaSigitTDatoDistribByImportDistribCanc] END");
		}
	}

	public SigitVTotImpiantoDto cercaPrimoResponsabileAttivoAllaDataByCodImpiantoApp(String codImpianto, Date dataRapporto, String idTipoComponente, ArrayList<String> listaProgressivi)
			throws DbManagerException {
		SigitVTotImpiantoDto responsabile = null;

		// Cerco preventivamente il responsabile
		// nel caso in cui non ci sia il responsabile cerco per ogni apparecchiature se esiste un 3 responsabile
		// se anche per una sola apparecchiatura non è presente il 3 responsabile rilancio l'eccezione

		try {
			SigitVTotImpiantoDto resp = cercaResponsabileAttivoAllaDataImpianto(codImpianto, dataRapporto);

			if (resp != null) {
				log.debug("Ho trovato il responsabile");
				return resp;
			}

			// Nel caso in cui non ci sia il responsabile ricerco i 3 responsabile per ogni apparecchiatura
			for (String progressivo : listaProgressivi) {

				List<SigitVTotImpiantoDto> list3RespAttiviImpianto = cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(codImpianto, dataRapporto, idTipoComponente, progressivo);
				if (list3RespAttiviImpianto == null || list3RespAttiviImpianto.isEmpty()) {

					// Alla prima apparecchiatura che non ha il 3 responsabile (e se sono qui è perchè non ha neanche il responsabile) esco
					return null;

				} else {
					responsabile = list3RespAttiviImpianto.get(0);
				}
			}
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		return responsabile;

	}

	public List<SigitRImpRuoloPfpgDto> findResponsabileImpiantoAttivoByCodImpianto(Integer codImpianto) throws DbManagerException {
		List<SigitRImpRuoloPfpgDto> dtoList = null;
		log.debug("[DbMgr::findResponsabileImpiantoAttivoByCodImpianto] BEGIN");
		try {
			dtoList = getSigitRImpRuoloPfpgDao().findResponsabileAttivoByCodImpianto(codImpianto);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::findResponsabileImpiantoAttivoByCodImpianto] END");
		}
		return dtoList;
	}

	public List<SigitVRicercaAllegatiDto> findAllegatiInviatiByDaysInterval(Integer numberOfDays) throws DbManagerException {
		List<SigitVRicercaAllegatiDto> dtoList = null;
		log.debug("[DbMgr::findAllegatiInviatiByDaysInterval] BEGIN");
		try {
			dtoList = getSigitVRicercaAllegatiDao().findInviatiByDaysInterval(numberOfDays);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::findAllegatiInviatiByDaysInterval] END");
		}
		return dtoList;
	}

	public List<SigitVRicercaAllegatiDto> findAllegatiInviatiByDaysIntervalPTU(Integer numberOfDays) throws DbManagerException {
		List<SigitVRicercaAllegatiDto> dtoList = null;
		log.debug("[DbMgr::findAllegatiInviatiByDaysInterval] BEGIN");
		try {
			dtoList = getSigitVRicercaAllegatiDao().findInviatiByDaysIntervalPTU(numberOfDays);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::findAllegatiInviatiByDaysInterval] END");
		}
		return dtoList;
	}

	public List<SigitTVerificaDto> findVerificheByCodiceFiscale(String codiceFiscale) throws DbManagerException {
		List<SigitTVerificaDto> dtoList = null;
		log.debug("[DbMgr::findVerificheByCodiceFiscale] BEGIN");
		try {
			dtoList = getSigitTVerificaDao().findByCodiceFiscale(codiceFiscale);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::findVerificheByCodiceFiscale] END");
		}
		return dtoList;
	}

	public List<SigitTVerificaByUtentiNonAttiviDto> findVerificheByUtentiNonAttivi() throws DbManagerException {
		List<SigitTVerificaByUtentiNonAttiviDto> dtoList = null;
		log.debug("[DbMgr::findVerificheByUtentiNonAttivi] BEGIN");
		try {
			dtoList = getSigitTVerificaDao().findByUtentiNonAttivi(null);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::findVerificheByUtentiNonAttivi] END");
		}
		return dtoList;
	}

	public List<SigitTAccertamentoDto> findAccertamentiByCodiceFiscale(String codiceFiscale) throws DbManagerException {
		List<SigitTAccertamentoDto> dtoList = null;
		log.debug("[DbMgr::findAccertamentiByCodiceFiscale] BEGIN");
		try {
			dtoList = getSigitTAccertamentoDao().findByCodiceFiscale(codiceFiscale);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::findAccertamentiByCodiceFiscale] END");
		}
		return dtoList;
	}

	public List<SigitTAccertamentoByUtentiNonAttiviDto> findAccertamentiByUtentiNonAttivi() throws DbManagerException {
		List<SigitTAccertamentoByUtentiNonAttiviDto> dtoList = null;
		log.debug("[DbMgr::findAccertamentiByUtentiNonAttivi] BEGIN");
		try {
			dtoList = getSigitTAccertamentoDao().findByUtentiNonAttivi(null);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::findAccertamentiByUtentiNonAttivi] END");
		}
		return dtoList;
	}

	public List<SigitTIspezione2018ByCodiceFiscaleDto> findIspezioni2018ByCodiceFiscale(String codiceFiscale) throws DbManagerException {
		List<SigitTIspezione2018ByCodiceFiscaleDto> dtoList = null;
		log.debug("[DbMgr::findIspezioni2018ByCodiceFiscale] BEGIN");
		try {
			dtoList = getSigitTIspezione2018Dao().findByCodiceFiscale(codiceFiscale);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::findIspezioni2018ByCodiceFiscale] END");
		}
		return dtoList;
	}

	public List<SigitTIspezione2018ByUtentiNonAttiviDto> findIspezioni2018ByUtentiNonAttivi() throws DbManagerException {
		List<SigitTIspezione2018ByUtentiNonAttiviDto> dtoList = null;
		log.debug("[DbMgr::findAccertamentiByUtentiNonAttivi] BEGIN");
		try {
			dtoList = getSigitTIspezione2018Dao().findByUtentiNonAttivi(null);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::SigitTIspezione2018ByUtentiNonAttiviDto] END");
		}
		return dtoList;
	}

	public List<SigitTSanzioneDto> findSanzioniByCodiceFiscale(String codiceFiscale) throws DbManagerException {
		List<SigitTSanzioneDto> dtoList = null;
		log.debug("[DbMgr::findSanzioniByCodiceFiscale] BEGIN");
		try {
			dtoList = getSigitTSanzioneDao().findByCodiceFiscale(codiceFiscale);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::findSanzioniByCodiceFiscale] END");
		}
		return dtoList;
	}

	public List<SigitTSanzioneAccertamentiByUtentiNonAttiviDto> findSanzioniAccertamentiByUtentiNonAttivi() throws DbManagerException {
		List<SigitTSanzioneAccertamentiByUtentiNonAttiviDto> dtoList = null;
		log.debug("[DbMgr::findSanzioniAccertamentiByUtentiNonAttivi] BEGIN");
		try {
			dtoList = getSigitTSanzioneDao().findAccertamentiByUtentiNonAttivi(null);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::findSanzioniAccertamentiByUtentiNonAttivi] END");
		}
		return dtoList;
	}

	public List<SigitTSanzioneIspezione2018ByUtentiNonAttiviDto> findSanzioniIspezione2018ByUtentiNonAttivi() throws DbManagerException {
		List<SigitTSanzioneIspezione2018ByUtentiNonAttiviDto> dtoList = null;
		log.debug("[DbMgr::findSanzioniIspezione2018ByUtentiNonAttivi] BEGIN");
		try {
			dtoList = getSigitTSanzioneDao().findIspezione2018ByUtentiNonAttivi(null);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::findSanzioniIspezione2018ByUtentiNonAttivi] END");
		}
		return dtoList;
	}

	public List<SigitRPfRuoloPaDto> findIdUtentiPAAttivi() throws DbManagerException {
		List<SigitRPfRuoloPaDto> dtoList = null;
		log.debug("[DbMgr::findIdUtentiPAAttivi] BEGIN");
		try {
			dtoList = getSigitRPfRuoloPaDao().findIdUtentiPAAttivi(null);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::findIdUtentiPAAttivi] END");
		}
		return dtoList;
	}

	public List<SigitVRicerca3ResponsabileDto> findResponsabile3AttivoByCodImpianto(Integer codImpianto) throws DbManagerException {
		List<SigitVRicerca3ResponsabileDto> dtoList = null;
		log.debug("[DbMgr::findResponsabile3AttivoByCodImpianto] BEGIN");
		try {
			dtoList = getSigitVRicerca3ResponsabileDao().findResponsabile3AttivoByCodImpianto(codImpianto);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::findResponsabile3AttivoByCodImpianto] END");
		}
		return dtoList;
	}

	public SigitWrkLogMemoPk insertWrkLogMemo(SigitWrkLogMemoDto sigitWrkLogMemoDto) throws DbManagerException {
		SigitWrkLogMemoPk wrkLog = null;
		log.debug("[DbMgr::insertWrkLogMemo] BEGIN");
		try {
			wrkLog = getSigitWrkLogMemoDao().insert(sigitWrkLogMemoDto);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::insertWrkLogMemo] END");
		}
		return wrkLog;
	}

	public SigitWrkLogMemoTuPk insertWrkLogMemoTU(SigitWrkLogMemoTuDto sigitWrkLogMemoDto) throws DbManagerException {
		SigitWrkLogMemoTuPk wrkLog = null;
		log.debug("[DbMgr::insertWrkLogMemo] BEGIN");
		try {
			wrkLog = getSigitWrkLogMemoTuDao().insert(sigitWrkLogMemoDto);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::insertWrkLogMemo] END");
		}
		return wrkLog;
	}

	public SigitTAllegatoDto cercaAllegatoById(BigDecimal idAllegato) throws DbManagerException {
		SigitTAllegatoDto dto = null;
		log.debug("[DbMgr::cercaAllegatoById] BEGIN");
		try {
			dto = getSigitTAllegatoDao().findByPrimaryKey(new SigitTAllegatoPk(idAllegato));
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaAllegatoById] END");
		}
		return dto;
	}

	public List<SigitVCompCgDto> cercaAllegatoCompCgAttivo(InputAllegatiComp input) throws DbManagerException {
		List<SigitVCompCgDto> dto = null;
		log.debug("[DbMgr::cercaAllegatoCompCgAttivo] BEGIN");
		try {
			dto = getSigitVCompCgDao().findGetCompJoinAllegatoComp(input);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaAllegatoCompCgAttivo] END");
		}
		return dto;
	}

	public List<SigitVCompGfDto> cercaAllegatoCompGfAttivo(InputAllegatiComp input) throws DbManagerException {
		List<SigitVCompGfDto> dto = null;
		log.debug("[DbMgr::cercaAllegatoCompGfAttivo] BEGIN");
		try {
			dto = getSigitVCompGfDao().findGetCompJoinAllegatoComp(input);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaAllegatoCompGfAttivo] END");
		}
		return dto;
	}

	public List<SigitVCompGtDto> cercaAllegatoCompGtAttivo(InputAllegatiComp input) throws DbManagerException {
		List<SigitVCompGtDto> dto = null;
		log.debug("[DbMgr::cercaAllegatoCompGtAttivo] BEGIN");
		try {
			dto = getSigitVCompGtDao().findGetCompJoinAllegatoComp(input);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaAllegatoCompGtAttivo] END");
		}
		return dto;
	}

	public List<SigitVCompScDto> cercaAllegatoCompScAttivo(InputAllegatiComp input) throws DbManagerException {
		List<SigitVCompScDto> dto = null;
		log.debug("[DbMgr::cercaAllegatoCompScAttivo] BEGIN");
		try {
			dto = getSigitVCompScDao().findGetCompJoinAllegatoComp(input);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbMgr::cercaAllegatoCompScAttivo] END");
		}
		return dto;
	}

	public void aggiornaAllegatoPerMancatoInvioMail(BigDecimal idAllegato) throws DbManagerException {
		log.debug("[DbMgr::aggiornaAllegatoPerMancatoInvioMail] END");
		try {
			SigitTAllegatoDto sigitTAllegatoDto = cercaAllegatoById(idAllegato);
			sigitTAllegatoDto.setDtInvioMemo(ConvertUtil.convertDateToTimestamp(new Date()));
			getSigitTAllegatoDao().update(sigitTAllegatoDto);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} finally {
			log.debug("[DbMgr::aggiornaAllegatoPerMancatoInvioMail] END");
		}
	}
}
