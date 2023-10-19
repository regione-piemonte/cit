package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTDettIspezGtDao.
 * @generated
 */
public class SigitTDettIspezGtDto extends SigitTDettIspezGtPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_ALLEGATO
	 * @generated
	 */
	protected java.math.BigDecimal fkAllegato;

	/**
	 * Imposta il valore della proprieta' fkAllegato associata alla
	 * colonna FK_ALLEGATO.
	 * @generated
	 */
	public void setFkAllegato(java.math.BigDecimal val) {

		fkAllegato = val;

	}

	/**
	 * Legge il valore della proprieta' fkAllegato associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkAllegato() {

		return fkAllegato;

	}

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_COMPONENTE
	 * @generated
	 */
	protected String fkTipoComponente;

	/**
	 * Imposta il valore della proprieta' fkTipoComponente associata alla
	 * colonna FK_TIPO_COMPONENTE.
	 * @generated
	 */
	public void setFkTipoComponente(String val) {

		fkTipoComponente = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoComponente associata alla
	 * @generated
	 */
	public String getFkTipoComponente() {

		return fkTipoComponente;

	}

	/**
	 * store della proprieta' associata alla colonna PROGRESSIVO
	 * @generated
	 */
	protected java.math.BigDecimal progressivo;

	/**
	 * Imposta il valore della proprieta' progressivo associata alla
	 * colonna PROGRESSIVO.
	 * @generated
	 */
	public void setProgressivo(java.math.BigDecimal val) {

		progressivo = val;

	}

	/**
	 * Legge il valore della proprieta' progressivo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getProgressivo() {

		return progressivo;

	}

	/**
	 * store della proprieta' associata alla colonna CODICE_IMPIANTO
	 * @generated
	 */
	protected java.math.BigDecimal codiceImpianto;

	/**
	 * Imposta il valore della proprieta' codiceImpianto associata alla
	 * colonna CODICE_IMPIANTO.
	 * @generated
	 */
	public void setCodiceImpianto(java.math.BigDecimal val) {

		codiceImpianto = val;

	}

	/**
	 * Legge il valore della proprieta' codiceImpianto associata alla
	 * @generated
	 */
	public java.math.BigDecimal getCodiceImpianto() {

		return codiceImpianto;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INSTALL
	 * @generated
	 */
	protected java.sql.Date dataInstall;

	/**
	 * Imposta il valore della proprieta' dataInstall associata alla
	 * colonna DATA_INSTALL.
	 * @generated
	 */
	public void setDataInstall(java.sql.Date val) {

		if (val != null) {
			dataInstall = new java.sql.Date(val.getTime());
		} else {
			dataInstall = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInstall associata alla
	 * @generated
	 */
	public java.sql.Date getDataInstall() {

		if (dataInstall != null) {
			return new java.sql.Date(dataInstall.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna S6D_FLG_EVACU_FUMI
	 * @generated
	 */
	protected String s6dFlgEvacuFumi;

	/**
	 * Imposta il valore della proprieta' s6dFlgEvacuFumi associata alla
	 * colonna S6D_FLG_EVACU_FUMI.
	 * @generated
	 */
	public void setS6dFlgEvacuFumi(String val) {

		s6dFlgEvacuFumi = val;

	}

	/**
	 * Legge il valore della proprieta' s6dFlgEvacuFumi associata alla
	 * @generated
	 */
	public String getS6dFlgEvacuFumi() {

		return s6dFlgEvacuFumi;

	}

	/**
	 * store della proprieta' associata alla colonna S6I_FLG_TIPO_B
	 * @generated
	 */
	protected java.math.BigDecimal s6iFlgTipoB;

	/**
	 * Imposta il valore della proprieta' s6iFlgTipoB associata alla
	 * colonna S6I_FLG_TIPO_B.
	 * @generated
	 */
	public void setS6iFlgTipoB(java.math.BigDecimal val) {

		s6iFlgTipoB = val;

	}

	/**
	 * Legge il valore della proprieta' s6iFlgTipoB associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS6iFlgTipoB() {

		return s6iFlgTipoB;

	}

	/**
	 * store della proprieta' associata alla colonna S6I_FLG_TIPO_C
	 * @generated
	 */
	protected java.math.BigDecimal s6iFlgTipoC;

	/**
	 * Imposta il valore della proprieta' s6iFlgTipoC associata alla
	 * colonna S6I_FLG_TIPO_C.
	 * @generated
	 */
	public void setS6iFlgTipoC(java.math.BigDecimal val) {

		s6iFlgTipoC = val;

	}

	/**
	 * Legge il valore della proprieta' s6iFlgTipoC associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS6iFlgTipoC() {

		return s6iFlgTipoC;

	}

	/**
	 * store della proprieta' associata alla colonna S6J_FK_CLASS_DPR660_96
	 * @generated
	 */
	protected String s6jFkClassDpr66096;

	/**
	 * Imposta il valore della proprieta' s6jFkClassDpr66096 associata alla
	 * colonna S6J_FK_CLASS_DPR660_96.
	 * @generated
	 */
	public void setS6jFkClassDpr66096(String val) {

		s6jFkClassDpr66096 = val;

	}

	/**
	 * Legge il valore della proprieta' s6jFkClassDpr66096 associata alla
	 * @generated
	 */
	public String getS6jFkClassDpr66096() {

		return s6jFkClassDpr66096;

	}

	/**
	 * store della proprieta' associata alla colonna S6K_POT_TERM_FOCOL_KW
	 * @generated
	 */
	protected java.math.BigDecimal s6kPotTermFocolKw;

	/**
	 * Imposta il valore della proprieta' s6kPotTermFocolKw associata alla
	 * colonna S6K_POT_TERM_FOCOL_KW.
	 * @generated
	 */
	public void setS6kPotTermFocolKw(java.math.BigDecimal val) {

		s6kPotTermFocolKw = val;

	}

	/**
	 * Legge il valore della proprieta' s6kPotTermFocolKw associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS6kPotTermFocolKw() {

		return s6kPotTermFocolKw;

	}

	/**
	 * store della proprieta' associata alla colonna S6K_BRUCIATORE_DA_KW
	 * @generated
	 */
	protected java.math.BigDecimal s6kBruciatoreDaKw;

	/**
	 * Imposta il valore della proprieta' s6kBruciatoreDaKw associata alla
	 * colonna S6K_BRUCIATORE_DA_KW.
	 * @generated
	 */
	public void setS6kBruciatoreDaKw(java.math.BigDecimal val) {

		s6kBruciatoreDaKw = val;

	}

	/**
	 * Legge il valore della proprieta' s6kBruciatoreDaKw associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS6kBruciatoreDaKw() {

		return s6kBruciatoreDaKw;

	}

	/**
	 * store della proprieta' associata alla colonna S6K_BRUCIATORE_A_KW
	 * @generated
	 */
	protected java.math.BigDecimal s6kBruciatoreAKw;

	/**
	 * Imposta il valore della proprieta' s6kBruciatoreAKw associata alla
	 * colonna S6K_BRUCIATORE_A_KW.
	 * @generated
	 */
	public void setS6kBruciatoreAKw(java.math.BigDecimal val) {

		s6kBruciatoreAKw = val;

	}

	/**
	 * Legge il valore della proprieta' s6kBruciatoreAKw associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS6kBruciatoreAKw() {

		return s6kBruciatoreAKw;

	}

	/**
	 * store della proprieta' associata alla colonna S6L_PORTATA_COMB_M3_H
	 * @generated
	 */
	protected java.math.BigDecimal s6lPortataCombM3H;

	/**
	 * Imposta il valore della proprieta' s6lPortataCombM3H associata alla
	 * colonna S6L_PORTATA_COMB_M3_H.
	 * @generated
	 */
	public void setS6lPortataCombM3H(java.math.BigDecimal val) {

		s6lPortataCombM3H = val;

	}

	/**
	 * Legge il valore della proprieta' s6lPortataCombM3H associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS6lPortataCombM3H() {

		return s6lPortataCombM3H;

	}

	/**
	 * store della proprieta' associata alla colonna S6L_PORTATA_COMB_KG_H
	 * @generated
	 */
	protected String s6lPortataCombKgH;

	/**
	 * Imposta il valore della proprieta' s6lPortataCombKgH associata alla
	 * colonna S6L_PORTATA_COMB_KG_H.
	 * @generated
	 */
	public void setS6lPortataCombKgH(String val) {

		s6lPortataCombKgH = val;

	}

	/**
	 * Legge il valore della proprieta' s6lPortataCombKgH associata alla
	 * @generated
	 */
	public String getS6lPortataCombKgH() {

		return s6lPortataCombKgH;

	}

	/**
	 * store della proprieta' associata alla colonna S6L_POT_TERM_FOCOL_KW
	 * @generated
	 */
	protected java.math.BigDecimal s6lPotTermFocolKw;

	/**
	 * Imposta il valore della proprieta' s6lPotTermFocolKw associata alla
	 * colonna S6L_POT_TERM_FOCOL_KW.
	 * @generated
	 */
	public void setS6lPotTermFocolKw(java.math.BigDecimal val) {

		s6lPotTermFocolKw = val;

	}

	/**
	 * Legge il valore della proprieta' s6lPotTermFocolKw associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS6lPotTermFocolKw() {

		return s6lPotTermFocolKw;

	}

	/**
	 * store della proprieta' associata alla colonna S7A_FLG_MANUT_EFFETTUATA
	 * @generated
	 */
	protected java.math.BigDecimal s7aFlgManutEffettuata;

	/**
	 * Imposta il valore della proprieta' s7aFlgManutEffettuata associata alla
	 * colonna S7A_FLG_MANUT_EFFETTUATA.
	 * @generated
	 */
	public void setS7aFlgManutEffettuata(java.math.BigDecimal val) {

		s7aFlgManutEffettuata = val;

	}

	/**
	 * Legge il valore della proprieta' s7aFlgManutEffettuata associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS7aFlgManutEffettuata() {

		return s7aFlgManutEffettuata;

	}

	/**
	 * store della proprieta' associata alla colonna S7A_DATA_ULTIMA_MANUT
	 * @generated
	 */
	protected java.sql.Date s7aDataUltimaManut;

	/**
	 * Imposta il valore della proprieta' s7aDataUltimaManut associata alla
	 * colonna S7A_DATA_ULTIMA_MANUT.
	 * @generated
	 */
	public void setS7aDataUltimaManut(java.sql.Date val) {

		if (val != null) {
			s7aDataUltimaManut = new java.sql.Date(val.getTime());
		} else {
			s7aDataUltimaManut = null;
		}

	}

	/**
	 * Legge il valore della proprieta' s7aDataUltimaManut associata alla
	 * @generated
	 */
	public java.sql.Date getS7aDataUltimaManut() {

		if (s7aDataUltimaManut != null) {
			return new java.sql.Date(s7aDataUltimaManut.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna S7B_FLG_REE_PRESENTE
	 * @generated
	 */
	protected java.math.BigDecimal s7bFlgReePresente;

	/**
	 * Imposta il valore della proprieta' s7bFlgReePresente associata alla
	 * colonna S7B_FLG_REE_PRESENTE.
	 * @generated
	 */
	public void setS7bFlgReePresente(java.math.BigDecimal val) {

		s7bFlgReePresente = val;

	}

	/**
	 * Legge il valore della proprieta' s7bFlgReePresente associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS7bFlgReePresente() {

		return s7bFlgReePresente;

	}

	/**
	 * store della proprieta' associata alla colonna S7B_DATA_REE
	 * @generated
	 */
	protected java.sql.Date s7bDataRee;

	/**
	 * Imposta il valore della proprieta' s7bDataRee associata alla
	 * colonna S7B_DATA_REE.
	 * @generated
	 */
	public void setS7bDataRee(java.sql.Date val) {

		if (val != null) {
			s7bDataRee = new java.sql.Date(val.getTime());
		} else {
			s7bDataRee = null;
		}

	}

	/**
	 * Legge il valore della proprieta' s7bDataRee associata alla
	 * @generated
	 */
	public java.sql.Date getS7bDataRee() {

		if (s7bDataRee != null) {
			return new java.sql.Date(s7bDataRee.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna S7B_FLG_OSSERVAZIONI
	 * @generated
	 */
	protected java.math.BigDecimal s7bFlgOsservazioni;

	/**
	 * Imposta il valore della proprieta' s7bFlgOsservazioni associata alla
	 * colonna S7B_FLG_OSSERVAZIONI.
	 * @generated
	 */
	public void setS7bFlgOsservazioni(java.math.BigDecimal val) {

		s7bFlgOsservazioni = val;

	}

	/**
	 * Legge il valore della proprieta' s7bFlgOsservazioni associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS7bFlgOsservazioni() {

		return s7bFlgOsservazioni;

	}

	/**
	 * store della proprieta' associata alla colonna S7B_FLG_RACCOMAND
	 * @generated
	 */
	protected java.math.BigDecimal s7bFlgRaccomand;

	/**
	 * Imposta il valore della proprieta' s7bFlgRaccomand associata alla
	 * colonna S7B_FLG_RACCOMAND.
	 * @generated
	 */
	public void setS7bFlgRaccomand(java.math.BigDecimal val) {

		s7bFlgRaccomand = val;

	}

	/**
	 * Legge il valore della proprieta' s7bFlgRaccomand associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS7bFlgRaccomand() {

		return s7bFlgRaccomand;

	}

	/**
	 * store della proprieta' associata alla colonna S7B_FLG_PRESCR
	 * @generated
	 */
	protected java.math.BigDecimal s7bFlgPrescr;

	/**
	 * Imposta il valore della proprieta' s7bFlgPrescr associata alla
	 * colonna S7B_FLG_PRESCR.
	 * @generated
	 */
	public void setS7bFlgPrescr(java.math.BigDecimal val) {

		s7bFlgPrescr = val;

	}

	/**
	 * Legge il valore della proprieta' s7bFlgPrescr associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS7bFlgPrescr() {

		return s7bFlgPrescr;

	}

	/**
	 * store della proprieta' associata alla colonna S8A_N_MODULO_TERMICO
	 * @generated
	 */
	protected String s8aNModuloTermico;

	/**
	 * Imposta il valore della proprieta' s8aNModuloTermico associata alla
	 * colonna S8A_N_MODULO_TERMICO.
	 * @generated
	 */
	public void setS8aNModuloTermico(String val) {

		s8aNModuloTermico = val;

	}

	/**
	 * Legge il valore della proprieta' s8aNModuloTermico associata alla
	 * @generated
	 */
	public String getS8aNModuloTermico() {

		return s8aNModuloTermico;

	}

	/**
	 * store della proprieta' associata alla colonna S8B_FUMO_MIS_1
	 * @generated
	 */
	protected java.math.BigDecimal s8bFumoMis1;

	/**
	 * Imposta il valore della proprieta' s8bFumoMis1 associata alla
	 * colonna S8B_FUMO_MIS_1.
	 * @generated
	 */
	public void setS8bFumoMis1(java.math.BigDecimal val) {

		s8bFumoMis1 = val;

	}

	/**
	 * Legge il valore della proprieta' s8bFumoMis1 associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8bFumoMis1() {

		return s8bFumoMis1;

	}

	/**
	 * store della proprieta' associata alla colonna S8B_FUMO_MIS_2
	 * @generated
	 */
	protected java.math.BigDecimal s8bFumoMis2;

	/**
	 * Imposta il valore della proprieta' s8bFumoMis2 associata alla
	 * colonna S8B_FUMO_MIS_2.
	 * @generated
	 */
	public void setS8bFumoMis2(java.math.BigDecimal val) {

		s8bFumoMis2 = val;

	}

	/**
	 * Legge il valore della proprieta' s8bFumoMis2 associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8bFumoMis2() {

		return s8bFumoMis2;

	}

	/**
	 * store della proprieta' associata alla colonna S8B_FUMO_MIS_3
	 * @generated
	 */
	protected java.math.BigDecimal s8bFumoMis3;

	/**
	 * Imposta il valore della proprieta' s8bFumoMis3 associata alla
	 * colonna S8B_FUMO_MIS_3.
	 * @generated
	 */
	public void setS8bFumoMis3(java.math.BigDecimal val) {

		s8bFumoMis3 = val;

	}

	/**
	 * Legge il valore della proprieta' s8bFumoMis3 associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8bFumoMis3() {

		return s8bFumoMis3;

	}

	/**
	 * store della proprieta' associata alla colonna S8C_MARCA_STRUM_MISURA
	 * @generated
	 */
	protected String s8cMarcaStrumMisura;

	/**
	 * Imposta il valore della proprieta' s8cMarcaStrumMisura associata alla
	 * colonna S8C_MARCA_STRUM_MISURA.
	 * @generated
	 */
	public void setS8cMarcaStrumMisura(String val) {

		s8cMarcaStrumMisura = val;

	}

	/**
	 * Legge il valore della proprieta' s8cMarcaStrumMisura associata alla
	 * @generated
	 */
	public String getS8cMarcaStrumMisura() {

		return s8cMarcaStrumMisura;

	}

	/**
	 * store della proprieta' associata alla colonna S8C_MODELLO_STRUM_MISURA
	 * @generated
	 */
	protected String s8cModelloStrumMisura;

	/**
	 * Imposta il valore della proprieta' s8cModelloStrumMisura associata alla
	 * colonna S8C_MODELLO_STRUM_MISURA.
	 * @generated
	 */
	public void setS8cModelloStrumMisura(String val) {

		s8cModelloStrumMisura = val;

	}

	/**
	 * Legge il valore della proprieta' s8cModelloStrumMisura associata alla
	 * @generated
	 */
	public String getS8cModelloStrumMisura() {

		return s8cModelloStrumMisura;

	}

	/**
	 * store della proprieta' associata alla colonna S8C_MATRICOLA_STRUM_MISURA
	 * @generated
	 */
	protected String s8cMatricolaStrumMisura;

	/**
	 * Imposta il valore della proprieta' s8cMatricolaStrumMisura associata alla
	 * colonna S8C_MATRICOLA_STRUM_MISURA.
	 * @generated
	 */
	public void setS8cMatricolaStrumMisura(String val) {

		s8cMatricolaStrumMisura = val;

	}

	/**
	 * Legge il valore della proprieta' s8cMatricolaStrumMisura associata alla
	 * @generated
	 */
	public String getS8cMatricolaStrumMisura() {

		return s8cMatricolaStrumMisura;

	}

	/**
	 * store della proprieta' associata alla colonna S8D_TEMP_FLUIDO_MANDATA_C
	 * @generated
	 */
	protected java.math.BigDecimal s8dTempFluidoMandataC;

	/**
	 * Imposta il valore della proprieta' s8dTempFluidoMandataC associata alla
	 * colonna S8D_TEMP_FLUIDO_MANDATA_C.
	 * @generated
	 */
	public void setS8dTempFluidoMandataC(java.math.BigDecimal val) {

		s8dTempFluidoMandataC = val;

	}

	/**
	 * Legge il valore della proprieta' s8dTempFluidoMandataC associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8dTempFluidoMandataC() {

		return s8dTempFluidoMandataC;

	}

	/**
	 * store della proprieta' associata alla colonna S8D_TEMP_ARIA_C
	 * @generated
	 */
	protected java.math.BigDecimal s8dTempAriaC;

	/**
	 * Imposta il valore della proprieta' s8dTempAriaC associata alla
	 * colonna S8D_TEMP_ARIA_C.
	 * @generated
	 */
	public void setS8dTempAriaC(java.math.BigDecimal val) {

		s8dTempAriaC = val;

	}

	/**
	 * Legge il valore della proprieta' s8dTempAriaC associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8dTempAriaC() {

		return s8dTempAriaC;

	}

	/**
	 * store della proprieta' associata alla colonna S8D_TEMP_FUMI_C
	 * @generated
	 */
	protected java.math.BigDecimal s8dTempFumiC;

	/**
	 * Imposta il valore della proprieta' s8dTempFumiC associata alla
	 * colonna S8D_TEMP_FUMI_C.
	 * @generated
	 */
	public void setS8dTempFumiC(java.math.BigDecimal val) {

		s8dTempFumiC = val;

	}

	/**
	 * Legge il valore della proprieta' s8dTempFumiC associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8dTempFumiC() {

		return s8dTempFumiC;

	}

	/**
	 * store della proprieta' associata alla colonna S8D_O2_PERC
	 * @generated
	 */
	protected java.math.BigDecimal s8dO2Perc;

	/**
	 * Imposta il valore della proprieta' s8dO2Perc associata alla
	 * colonna S8D_O2_PERC.
	 * @generated
	 */
	public void setS8dO2Perc(java.math.BigDecimal val) {

		s8dO2Perc = val;

	}

	/**
	 * Legge il valore della proprieta' s8dO2Perc associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8dO2Perc() {

		return s8dO2Perc;

	}

	/**
	 * store della proprieta' associata alla colonna S8D_CO2_PERC
	 * @generated
	 */
	protected java.math.BigDecimal s8dCo2Perc;

	/**
	 * Imposta il valore della proprieta' s8dCo2Perc associata alla
	 * colonna S8D_CO2_PERC.
	 * @generated
	 */
	public void setS8dCo2Perc(java.math.BigDecimal val) {

		s8dCo2Perc = val;

	}

	/**
	 * Legge il valore della proprieta' s8dCo2Perc associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8dCo2Perc() {

		return s8dCo2Perc;

	}

	/**
	 * store della proprieta' associata alla colonna S8D_CO_FUMI_SECCHI_PPM
	 * @generated
	 */
	protected java.math.BigDecimal s8dCoFumiSecchiPpm;

	/**
	 * Imposta il valore della proprieta' s8dCoFumiSecchiPpm associata alla
	 * colonna S8D_CO_FUMI_SECCHI_PPM.
	 * @generated
	 */
	public void setS8dCoFumiSecchiPpm(java.math.BigDecimal val) {

		s8dCoFumiSecchiPpm = val;

	}

	/**
	 * Legge il valore della proprieta' s8dCoFumiSecchiPpm associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8dCoFumiSecchiPpm() {

		return s8dCoFumiSecchiPpm;

	}

	/**
	 * store della proprieta' associata alla colonna S8D_NO_MG_KW_H
	 * @generated
	 */
	protected java.math.BigDecimal s8dNoMgKwH;

	/**
	 * Imposta il valore della proprieta' s8dNoMgKwH associata alla
	 * colonna S8D_NO_MG_KW_H.
	 * @generated
	 */
	public void setS8dNoMgKwH(java.math.BigDecimal val) {

		s8dNoMgKwH = val;

	}

	/**
	 * Legge il valore della proprieta' s8dNoMgKwH associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8dNoMgKwH() {

		return s8dNoMgKwH;

	}

	/**
	 * store della proprieta' associata alla colonna S8E_INDICE_ARIA
	 * @generated
	 */
	protected java.math.BigDecimal s8eIndiceAria;

	/**
	 * Imposta il valore della proprieta' s8eIndiceAria associata alla
	 * colonna S8E_INDICE_ARIA.
	 * @generated
	 */
	public void setS8eIndiceAria(java.math.BigDecimal val) {

		s8eIndiceAria = val;

	}

	/**
	 * Legge il valore della proprieta' s8eIndiceAria associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8eIndiceAria() {

		return s8eIndiceAria;

	}

	/**
	 * store della proprieta' associata alla colonna S8E_FUMI_SECCHI_NO_ARIA_PPM
	 * @generated
	 */
	protected java.math.BigDecimal s8eFumiSecchiNoAriaPpm;

	/**
	 * Imposta il valore della proprieta' s8eFumiSecchiNoAriaPpm associata alla
	 * colonna S8E_FUMI_SECCHI_NO_ARIA_PPM.
	 * @generated
	 */
	public void setS8eFumiSecchiNoAriaPpm(java.math.BigDecimal val) {

		s8eFumiSecchiNoAriaPpm = val;

	}

	/**
	 * Legge il valore della proprieta' s8eFumiSecchiNoAriaPpm associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8eFumiSecchiNoAriaPpm() {

		return s8eFumiSecchiNoAriaPpm;

	}

	/**
	 * store della proprieta' associata alla colonna S8E_QS_PERC
	 * @generated
	 */
	protected java.math.BigDecimal s8eQsPerc;

	/**
	 * Imposta il valore della proprieta' s8eQsPerc associata alla
	 * colonna S8E_QS_PERC.
	 * @generated
	 */
	public void setS8eQsPerc(java.math.BigDecimal val) {

		s8eQsPerc = val;

	}

	/**
	 * Legge il valore della proprieta' s8eQsPerc associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8eQsPerc() {

		return s8eQsPerc;

	}

	/**
	 * store della proprieta' associata alla colonna S8E_ET_PERC
	 * @generated
	 */
	protected java.math.BigDecimal s8eEtPerc;

	/**
	 * Imposta il valore della proprieta' s8eEtPerc associata alla
	 * colonna S8E_ET_PERC.
	 * @generated
	 */
	public void setS8eEtPerc(java.math.BigDecimal val) {

		s8eEtPerc = val;

	}

	/**
	 * Legge il valore della proprieta' s8eEtPerc associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8eEtPerc() {

		return s8eEtPerc;

	}

	/**
	 * store della proprieta' associata alla colonna S8E_REND_COMB_PERC
	 * @generated
	 */
	protected java.math.BigDecimal s8eRendCombPerc;

	/**
	 * Imposta il valore della proprieta' s8eRendCombPerc associata alla
	 * colonna S8E_REND_COMB_PERC.
	 * @generated
	 */
	public void setS8eRendCombPerc(java.math.BigDecimal val) {

		s8eRendCombPerc = val;

	}

	/**
	 * Legge il valore della proprieta' s8eRendCombPerc associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8eRendCombPerc() {

		return s8eRendCombPerc;

	}

	/**
	 * store della proprieta' associata alla colonna S8E_NOX_MG_KW_H
	 * @generated
	 */
	protected java.math.BigDecimal s8eNoxMgKwH;

	/**
	 * Imposta il valore della proprieta' s8eNoxMgKwH associata alla
	 * colonna S8E_NOX_MG_KW_H.
	 * @generated
	 */
	public void setS8eNoxMgKwH(java.math.BigDecimal val) {

		s8eNoxMgKwH = val;

	}

	/**
	 * Legge il valore della proprieta' s8eNoxMgKwH associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8eNoxMgKwH() {

		return s8eNoxMgKwH;

	}

	/**
	 * store della proprieta' associata alla colonna S9A_FLG_MONOSSIDO_CARB
	 * @generated
	 */
	protected String s9aFlgMonossidoCarb;

	/**
	 * Imposta il valore della proprieta' s9aFlgMonossidoCarb associata alla
	 * colonna S9A_FLG_MONOSSIDO_CARB.
	 * @generated
	 */
	public void setS9aFlgMonossidoCarb(String val) {

		s9aFlgMonossidoCarb = val;

	}

	/**
	 * Legge il valore della proprieta' s9aFlgMonossidoCarb associata alla
	 * @generated
	 */
	public String getS9aFlgMonossidoCarb() {

		return s9aFlgMonossidoCarb;

	}

	/**
	 * store della proprieta' associata alla colonna S9B_FLG_FUMOSITA
	 * @generated
	 */
	protected String s9bFlgFumosita;

	/**
	 * Imposta il valore della proprieta' s9bFlgFumosita associata alla
	 * colonna S9B_FLG_FUMOSITA.
	 * @generated
	 */
	public void setS9bFlgFumosita(String val) {

		s9bFlgFumosita = val;

	}

	/**
	 * Legge il valore della proprieta' s9bFlgFumosita associata alla
	 * @generated
	 */
	public String getS9bFlgFumosita() {

		return s9bFlgFumosita;

	}

	/**
	 * store della proprieta' associata alla colonna S9C_REND_MIN_COMBUST_PERC
	 * @generated
	 */
	protected java.math.BigDecimal s9cRendMinCombustPerc;

	/**
	 * Imposta il valore della proprieta' s9cRendMinCombustPerc associata alla
	 * colonna S9C_REND_MIN_COMBUST_PERC.
	 * @generated
	 */
	public void setS9cRendMinCombustPerc(java.math.BigDecimal val) {

		s9cRendMinCombustPerc = val;

	}

	/**
	 * Legge il valore della proprieta' s9cRendMinCombustPerc associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS9cRendMinCombustPerc() {

		return s9cRendMinCombustPerc;

	}

	/**
	 * store della proprieta' associata alla colonna S9C_FLG_REND_COMBUST_SUFF
	 * @generated
	 */
	protected java.math.BigDecimal s9cFlgRendCombustSuff;

	/**
	 * Imposta il valore della proprieta' s9cFlgRendCombustSuff associata alla
	 * colonna S9C_FLG_REND_COMBUST_SUFF.
	 * @generated
	 */
	public void setS9cFlgRendCombustSuff(java.math.BigDecimal val) {

		s9cFlgRendCombustSuff = val;

	}

	/**
	 * Legge il valore della proprieta' s9cFlgRendCombustSuff associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS9cFlgRendCombustSuff() {

		return s9cFlgRendCombustSuff;

	}

	/**
	 * store della proprieta' associata alla colonna S9D_OSSIDI_AZOTO_LIM_MG_KW_H
	 * @generated
	 */
	protected java.math.BigDecimal s9dOssidiAzotoLimMgKwH;

	/**
	 * Imposta il valore della proprieta' s9dOssidiAzotoLimMgKwH associata alla
	 * colonna S9D_OSSIDI_AZOTO_LIM_MG_KW_H.
	 * @generated
	 */
	public void setS9dOssidiAzotoLimMgKwH(java.math.BigDecimal val) {

		s9dOssidiAzotoLimMgKwH = val;

	}

	/**
	 * Legge il valore della proprieta' s9dOssidiAzotoLimMgKwH associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS9dOssidiAzotoLimMgKwH() {

		return s9dOssidiAzotoLimMgKwH;

	}

	/**
	 * store della proprieta' associata alla colonna S9D_FLG_OSSIDI_AZOTO
	 * @generated
	 */
	protected String s9dFlgOssidiAzoto;

	/**
	 * Imposta il valore della proprieta' s9dFlgOssidiAzoto associata alla
	 * colonna S9D_FLG_OSSIDI_AZOTO.
	 * @generated
	 */
	public void setS9dFlgOssidiAzoto(String val) {

		s9dFlgOssidiAzoto = val;

	}

	/**
	 * Legge il valore della proprieta' s9dFlgOssidiAzoto associata alla
	 * @generated
	 */
	public String getS9dFlgOssidiAzoto() {

		return s9dFlgOssidiAzoto;

	}

	/**
	 * store della proprieta' associata alla colonna S9E_FLG_RISPETTO_NORMATIVA
	 * @generated
	 */
	protected java.math.BigDecimal s9eFlgRispettoNormativa;

	/**
	 * Imposta il valore della proprieta' s9eFlgRispettoNormativa associata alla
	 * colonna S9E_FLG_RISPETTO_NORMATIVA.
	 * @generated
	 */
	public void setS9eFlgRispettoNormativa(java.math.BigDecimal val) {

		s9eFlgRispettoNormativa = val;

	}

	/**
	 * Legge il valore della proprieta' s9eFlgRispettoNormativa associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS9eFlgRispettoNormativa() {

		return s9eFlgRispettoNormativa;

	}

	/**
	 * store della proprieta' associata alla colonna S9E_FLG_NO_RISPETTO_7A
	 * @generated
	 */
	protected java.math.BigDecimal s9eFlgNoRispetto7a;

	/**
	 * Imposta il valore della proprieta' s9eFlgNoRispetto7a associata alla
	 * colonna S9E_FLG_NO_RISPETTO_7A.
	 * @generated
	 */
	public void setS9eFlgNoRispetto7a(java.math.BigDecimal val) {

		s9eFlgNoRispetto7a = val;

	}

	/**
	 * Legge il valore della proprieta' s9eFlgNoRispetto7a associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS9eFlgNoRispetto7a() {

		return s9eFlgNoRispetto7a;

	}

	/**
	 * store della proprieta' associata alla colonna S9E_FLG_NO_RISPETTO_7B
	 * @generated
	 */
	protected java.math.BigDecimal s9eFlgNoRispetto7b;

	/**
	 * Imposta il valore della proprieta' s9eFlgNoRispetto7b associata alla
	 * colonna S9E_FLG_NO_RISPETTO_7B.
	 * @generated
	 */
	public void setS9eFlgNoRispetto7b(java.math.BigDecimal val) {

		s9eFlgNoRispetto7b = val;

	}

	/**
	 * Legge il valore della proprieta' s9eFlgNoRispetto7b associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS9eFlgNoRispetto7b() {

		return s9eFlgNoRispetto7b;

	}

	/**
	 * store della proprieta' associata alla colonna S9E_FLG_NO_RISPETTO_9A
	 * @generated
	 */
	protected java.math.BigDecimal s9eFlgNoRispetto9a;

	/**
	 * Imposta il valore della proprieta' s9eFlgNoRispetto9a associata alla
	 * colonna S9E_FLG_NO_RISPETTO_9A.
	 * @generated
	 */
	public void setS9eFlgNoRispetto9a(java.math.BigDecimal val) {

		s9eFlgNoRispetto9a = val;

	}

	/**
	 * Legge il valore della proprieta' s9eFlgNoRispetto9a associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS9eFlgNoRispetto9a() {

		return s9eFlgNoRispetto9a;

	}

	/**
	 * store della proprieta' associata alla colonna S9E_FLG_NO_RISPETTO_9B
	 * @generated
	 */
	protected java.math.BigDecimal s9eFlgNoRispetto9b;

	/**
	 * Imposta il valore della proprieta' s9eFlgNoRispetto9b associata alla
	 * colonna S9E_FLG_NO_RISPETTO_9B.
	 * @generated
	 */
	public void setS9eFlgNoRispetto9b(java.math.BigDecimal val) {

		s9eFlgNoRispetto9b = val;

	}

	/**
	 * Legge il valore della proprieta' s9eFlgNoRispetto9b associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS9eFlgNoRispetto9b() {

		return s9eFlgNoRispetto9b;

	}

	/**
	 * store della proprieta' associata alla colonna S9E_FLG_NO_RISPETTO_9C
	 * @generated
	 */
	protected java.math.BigDecimal s9eFlgNoRispetto9c;

	/**
	 * Imposta il valore della proprieta' s9eFlgNoRispetto9c associata alla
	 * colonna S9E_FLG_NO_RISPETTO_9C.
	 * @generated
	 */
	public void setS9eFlgNoRispetto9c(java.math.BigDecimal val) {

		s9eFlgNoRispetto9c = val;

	}

	/**
	 * Legge il valore della proprieta' s9eFlgNoRispetto9c associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS9eFlgNoRispetto9c() {

		return s9eFlgNoRispetto9c;

	}

	/**
	 * store della proprieta' associata alla colonna S9E_FLG_NO_RISPETTO_9D
	 * @generated
	 */
	protected java.math.BigDecimal s9eFlgNoRispetto9d;

	/**
	 * Imposta il valore della proprieta' s9eFlgNoRispetto9d associata alla
	 * colonna S9E_FLG_NO_RISPETTO_9D.
	 * @generated
	 */
	public void setS9eFlgNoRispetto9d(java.math.BigDecimal val) {

		s9eFlgNoRispetto9d = val;

	}

	/**
	 * Legge il valore della proprieta' s9eFlgNoRispetto9d associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS9eFlgNoRispetto9d() {

		return s9eFlgNoRispetto9d;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_ULT_MOD
	 * @generated
	 */
	protected java.sql.Timestamp dataUltMod;

	/**
	 * Imposta il valore della proprieta' dataUltMod associata alla
	 * colonna DATA_ULT_MOD.
	 * @generated
	 */
	public void setDataUltMod(java.sql.Timestamp val) {

		if (val != null) {
			dataUltMod = new java.sql.Timestamp(val.getTime());
		} else {
			dataUltMod = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataUltMod associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataUltMod() {

		if (dataUltMod != null) {
			return new java.sql.Timestamp(dataUltMod.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna UTENTE_ULT_MOD
	 * @generated
	 */
	protected String utenteUltMod;

	/**
	 * Imposta il valore della proprieta' utenteUltMod associata alla
	 * colonna UTENTE_ULT_MOD.
	 * @generated
	 */
	public void setUtenteUltMod(String val) {

		utenteUltMod = val;

	}

	/**
	 * Legge il valore della proprieta' utenteUltMod associata alla
	 * @generated
	 */
	public String getUtenteUltMod() {

		return utenteUltMod;

	}

	/**
	 * store della proprieta' associata alla colonna CONTROLLOWEB
	 * @generated
	 */
	protected java.sql.Timestamp controlloweb;

	/**
	 * Imposta il valore della proprieta' controlloweb associata alla
	 * colonna CONTROLLOWEB.
	 * @generated
	 */
	public void setControlloweb(java.sql.Timestamp val) {

		if (val != null) {
			controlloweb = new java.sql.Timestamp(val.getTime());
		} else {
			controlloweb = null;
		}

	}

	/**
	 * Legge il valore della proprieta' controlloweb associata alla
	 * @generated
	 */
	public java.sql.Timestamp getControlloweb() {

		if (controlloweb != null) {
			return new java.sql.Timestamp(controlloweb.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna S7A_FREQUENZA_MANUT_ALTRO
	 * @generated
	 */
	protected String s7aFrequenzaManutAltro;

	/**
	 * Imposta il valore della proprieta' s7aFrequenzaManutAltro associata alla
	 * colonna S7A_FREQUENZA_MANUT_ALTRO.
	 * @generated
	 */
	public void setS7aFrequenzaManutAltro(String val) {

		s7aFrequenzaManutAltro = val;

	}

	/**
	 * Legge il valore della proprieta' s7aFrequenzaManutAltro associata alla
	 * @generated
	 */
	public String getS7aFrequenzaManutAltro() {

		return s7aFrequenzaManutAltro;

	}

	/**
	 * store della proprieta' associata alla colonna S7A_FK_FREQUENZA_MANUT
	 * @generated
	 */
	protected Integer s7aFkFrequenzaManut;

	/**
	 * Imposta il valore della proprieta' s7aFkFrequenzaManut associata alla
	 * colonna S7A_FK_FREQUENZA_MANUT.
	 * @generated
	 */
	public void setS7aFkFrequenzaManut(Integer val) {

		s7aFkFrequenzaManut = val;

	}

	/**
	 * Legge il valore della proprieta' s7aFkFrequenzaManut associata alla
	 * @generated
	 */
	public Integer getS7aFkFrequenzaManut() {

		return s7aFkFrequenzaManut;

	}

	/**
	 * Crea una istanza di SigitTDettIspezGtPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTDettIspezGtPk
	 * @generated
	 */
	public SigitTDettIspezGtPk createPk() {
		return new SigitTDettIspezGtPk(idDettIspezGt);
	}

	/**
	 * la semantica dell'equals del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * @param other l'oggetto con cui effettuare il confronto
	 * @return true se i due oggetti sono semanticamente da considerarsi uguali
	 */
	public boolean equals(Object other) {
		return super.equals(other);
	}

	/**
	 * la semantica dell'hashCode del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * 
	 * @return int
	 */
	public int hashCode() {
		return super.hashCode();
	}

}
