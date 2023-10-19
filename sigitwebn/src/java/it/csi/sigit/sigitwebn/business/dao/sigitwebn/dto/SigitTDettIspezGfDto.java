package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTDettIspezGfDao.
 * @generated
 */
public class SigitTDettIspezGfDto extends SigitTDettIspezGfPk {

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
	 * store della proprieta' associata alla colonna S6H_FLG_INVERTER
	 * @generated
	 */
	protected java.math.BigDecimal s6hFlgInverter;

	/**
	 * Imposta il valore della proprieta' s6hFlgInverter associata alla
	 * colonna S6H_FLG_INVERTER.
	 * @generated
	 */
	public void setS6hFlgInverter(java.math.BigDecimal val) {

		s6hFlgInverter = val;

	}

	/**
	 * Legge il valore della proprieta' s6hFlgInverter associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS6hFlgInverter() {

		return s6hFlgInverter;

	}

	/**
	 * store della proprieta' associata alla colonna S6N_FLG_FUGA_DIRETTA
	 * @generated
	 */
	protected java.math.BigDecimal s6nFlgFugaDiretta;

	/**
	 * Imposta il valore della proprieta' s6nFlgFugaDiretta associata alla
	 * colonna S6N_FLG_FUGA_DIRETTA.
	 * @generated
	 */
	public void setS6nFlgFugaDiretta(java.math.BigDecimal val) {

		s6nFlgFugaDiretta = val;

	}

	/**
	 * Legge il valore della proprieta' s6nFlgFugaDiretta associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS6nFlgFugaDiretta() {

		return s6nFlgFugaDiretta;

	}

	/**
	 * store della proprieta' associata alla colonna S6N_FLG_FUGA_INDIRETTA
	 * @generated
	 */
	protected java.math.BigDecimal s6nFlgFugaIndiretta;

	/**
	 * Imposta il valore della proprieta' s6nFlgFugaIndiretta associata alla
	 * colonna S6N_FLG_FUGA_INDIRETTA.
	 * @generated
	 */
	public void setS6nFlgFugaIndiretta(java.math.BigDecimal val) {

		s6nFlgFugaIndiretta = val;

	}

	/**
	 * Legge il valore della proprieta' s6nFlgFugaIndiretta associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS6nFlgFugaIndiretta() {

		return s6nFlgFugaIndiretta;

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
	 * store della proprieta' associata alla colonna S7B_FLG_REGISTRO_APPARECC
	 * @generated
	 */
	protected java.math.BigDecimal s7bFlgRegistroApparecc;

	/**
	 * Imposta il valore della proprieta' s7bFlgRegistroApparecc associata alla
	 * colonna S7B_FLG_REGISTRO_APPARECC.
	 * @generated
	 */
	public void setS7bFlgRegistroApparecc(java.math.BigDecimal val) {

		s7bFlgRegistroApparecc = val;

	}

	/**
	 * Legge il valore della proprieta' s7bFlgRegistroApparecc associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS7bFlgRegistroApparecc() {

		return s7bFlgRegistroApparecc;

	}

	/**
	 * store della proprieta' associata alla colonna S7C_FLG_REE_PRESENTE
	 * @generated
	 */
	protected java.math.BigDecimal s7cFlgReePresente;

	/**
	 * Imposta il valore della proprieta' s7cFlgReePresente associata alla
	 * colonna S7C_FLG_REE_PRESENTE.
	 * @generated
	 */
	public void setS7cFlgReePresente(java.math.BigDecimal val) {

		s7cFlgReePresente = val;

	}

	/**
	 * Legge il valore della proprieta' s7cFlgReePresente associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS7cFlgReePresente() {

		return s7cFlgReePresente;

	}

	/**
	 * store della proprieta' associata alla colonna S7C_DATA_REE
	 * @generated
	 */
	protected java.sql.Date s7cDataRee;

	/**
	 * Imposta il valore della proprieta' s7cDataRee associata alla
	 * colonna S7C_DATA_REE.
	 * @generated
	 */
	public void setS7cDataRee(java.sql.Date val) {

		if (val != null) {
			s7cDataRee = new java.sql.Date(val.getTime());
		} else {
			s7cDataRee = null;
		}

	}

	/**
	 * Legge il valore della proprieta' s7cDataRee associata alla
	 * @generated
	 */
	public java.sql.Date getS7cDataRee() {

		if (s7cDataRee != null) {
			return new java.sql.Date(s7cDataRee.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna S7C_FLG_OSSERVAZIONI
	 * @generated
	 */
	protected java.math.BigDecimal s7cFlgOsservazioni;

	/**
	 * Imposta il valore della proprieta' s7cFlgOsservazioni associata alla
	 * colonna S7C_FLG_OSSERVAZIONI.
	 * @generated
	 */
	public void setS7cFlgOsservazioni(java.math.BigDecimal val) {

		s7cFlgOsservazioni = val;

	}

	/**
	 * Legge il valore della proprieta' s7cFlgOsservazioni associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS7cFlgOsservazioni() {

		return s7cFlgOsservazioni;

	}

	/**
	 * store della proprieta' associata alla colonna S7C_FLG_RACCOMAND
	 * @generated
	 */
	protected java.math.BigDecimal s7cFlgRaccomand;

	/**
	 * Imposta il valore della proprieta' s7cFlgRaccomand associata alla
	 * colonna S7C_FLG_RACCOMAND.
	 * @generated
	 */
	public void setS7cFlgRaccomand(java.math.BigDecimal val) {

		s7cFlgRaccomand = val;

	}

	/**
	 * Legge il valore della proprieta' s7cFlgRaccomand associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS7cFlgRaccomand() {

		return s7cFlgRaccomand;

	}

	/**
	 * store della proprieta' associata alla colonna S7C_FLG_PRESCR
	 * @generated
	 */
	protected java.math.BigDecimal s7cFlgPrescr;

	/**
	 * Imposta il valore della proprieta' s7cFlgPrescr associata alla
	 * colonna S7C_FLG_PRESCR.
	 * @generated
	 */
	public void setS7cFlgPrescr(java.math.BigDecimal val) {

		s7cFlgPrescr = val;

	}

	/**
	 * Legge il valore della proprieta' s7cFlgPrescr associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS7cFlgPrescr() {

		return s7cFlgPrescr;

	}

	/**
	 * store della proprieta' associata alla colonna S8B_FLG_PROVE_RISCALDAMENTO
	 * @generated
	 */
	protected java.math.BigDecimal s8bFlgProveRiscaldamento;

	/**
	 * Imposta il valore della proprieta' s8bFlgProveRiscaldamento associata alla
	 * colonna S8B_FLG_PROVE_RISCALDAMENTO.
	 * @generated
	 */
	public void setS8bFlgProveRiscaldamento(java.math.BigDecimal val) {

		s8bFlgProveRiscaldamento = val;

	}

	/**
	 * Legge il valore della proprieta' s8bFlgProveRiscaldamento associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8bFlgProveRiscaldamento() {

		return s8bFlgProveRiscaldamento;

	}

	/**
	 * store della proprieta' associata alla colonna S8B_FLG_PROVE_RAFFRESCAMENTO
	 * @generated
	 */
	protected java.math.BigDecimal s8bFlgProveRaffrescamento;

	/**
	 * Imposta il valore della proprieta' s8bFlgProveRaffrescamento associata alla
	 * colonna S8B_FLG_PROVE_RAFFRESCAMENTO.
	 * @generated
	 */
	public void setS8bFlgProveRaffrescamento(java.math.BigDecimal val) {

		s8bFlgProveRaffrescamento = val;

	}

	/**
	 * Legge il valore della proprieta' s8bFlgProveRaffrescamento associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8bFlgProveRaffrescamento() {

		return s8bFlgProveRaffrescamento;

	}

	/**
	 * store della proprieta' associata alla colonna S8C_FLG_FILTRI_PULITI
	 * @generated
	 */
	protected java.math.BigDecimal s8cFlgFiltriPuliti;

	/**
	 * Imposta il valore della proprieta' s8cFlgFiltriPuliti associata alla
	 * colonna S8C_FLG_FILTRI_PULITI.
	 * @generated
	 */
	public void setS8cFlgFiltriPuliti(java.math.BigDecimal val) {

		s8cFlgFiltriPuliti = val;

	}

	/**
	 * Legge il valore della proprieta' s8cFlgFiltriPuliti associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8cFlgFiltriPuliti() {

		return s8cFlgFiltriPuliti;

	}

	/**
	 * store della proprieta' associata alla colonna S8D_FLG_ASSENZA_PERDITE_GAS
	 * @generated
	 */
	protected java.math.BigDecimal s8dFlgAssenzaPerditeGas;

	/**
	 * Imposta il valore della proprieta' s8dFlgAssenzaPerditeGas associata alla
	 * colonna S8D_FLG_ASSENZA_PERDITE_GAS.
	 * @generated
	 */
	public void setS8dFlgAssenzaPerditeGas(java.math.BigDecimal val) {

		s8dFlgAssenzaPerditeGas = val;

	}

	/**
	 * Legge il valore della proprieta' s8dFlgAssenzaPerditeGas associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8dFlgAssenzaPerditeGas() {

		return s8dFlgAssenzaPerditeGas;

	}

	/**
	 * store della proprieta' associata alla colonna S8E_MARCA_STRUM_MISURA
	 * @generated
	 */
	protected String s8eMarcaStrumMisura;

	/**
	 * Imposta il valore della proprieta' s8eMarcaStrumMisura associata alla
	 * colonna S8E_MARCA_STRUM_MISURA.
	 * @generated
	 */
	public void setS8eMarcaStrumMisura(String val) {

		s8eMarcaStrumMisura = val;

	}

	/**
	 * Legge il valore della proprieta' s8eMarcaStrumMisura associata alla
	 * @generated
	 */
	public String getS8eMarcaStrumMisura() {

		return s8eMarcaStrumMisura;

	}

	/**
	 * store della proprieta' associata alla colonna S8E_MODELLO_STRUM_MISURA
	 * @generated
	 */
	protected String s8eModelloStrumMisura;

	/**
	 * Imposta il valore della proprieta' s8eModelloStrumMisura associata alla
	 * colonna S8E_MODELLO_STRUM_MISURA.
	 * @generated
	 */
	public void setS8eModelloStrumMisura(String val) {

		s8eModelloStrumMisura = val;

	}

	/**
	 * Legge il valore della proprieta' s8eModelloStrumMisura associata alla
	 * @generated
	 */
	public String getS8eModelloStrumMisura() {

		return s8eModelloStrumMisura;

	}

	/**
	 * store della proprieta' associata alla colonna S8E_MATRICOLA_STRUM_MISURA
	 * @generated
	 */
	protected String s8eMatricolaStrumMisura;

	/**
	 * Imposta il valore della proprieta' s8eMatricolaStrumMisura associata alla
	 * colonna S8E_MATRICOLA_STRUM_MISURA.
	 * @generated
	 */
	public void setS8eMatricolaStrumMisura(String val) {

		s8eMatricolaStrumMisura = val;

	}

	/**
	 * Legge il valore della proprieta' s8eMatricolaStrumMisura associata alla
	 * @generated
	 */
	public String getS8eMatricolaStrumMisura() {

		return s8eMatricolaStrumMisura;

	}

	/**
	 * store della proprieta' associata alla colonna S8F_POT_ASSORBITA_KW
	 * @generated
	 */
	protected java.math.BigDecimal s8fPotAssorbitaKw;

	/**
	 * Imposta il valore della proprieta' s8fPotAssorbitaKw associata alla
	 * colonna S8F_POT_ASSORBITA_KW.
	 * @generated
	 */
	public void setS8fPotAssorbitaKw(java.math.BigDecimal val) {

		s8fPotAssorbitaKw = val;

	}

	/**
	 * Legge il valore della proprieta' s8fPotAssorbitaKw associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8fPotAssorbitaKw() {

		return s8fPotAssorbitaKw;

	}

	/**
	 * store della proprieta' associata alla colonna S8G_FLG_STRUMENTAZIONE_FISSA
	 * @generated
	 */
	protected java.math.BigDecimal s8gFlgStrumentazioneFissa;

	/**
	 * Imposta il valore della proprieta' s8gFlgStrumentazioneFissa associata alla
	 * colonna S8G_FLG_STRUMENTAZIONE_FISSA.
	 * @generated
	 */
	public void setS8gFlgStrumentazioneFissa(java.math.BigDecimal val) {

		s8gFlgStrumentazioneFissa = val;

	}

	/**
	 * Legge il valore della proprieta' s8gFlgStrumentazioneFissa associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8gFlgStrumentazioneFissa() {

		return s8gFlgStrumentazioneFissa;

	}

	/**
	 * store della proprieta' associata alla colonna S8H_OPERATORE_DENOMINAZIONE
	 * @generated
	 */
	protected String s8hOperatoreDenominazione;

	/**
	 * Imposta il valore della proprieta' s8hOperatoreDenominazione associata alla
	 * colonna S8H_OPERATORE_DENOMINAZIONE.
	 * @generated
	 */
	public void setS8hOperatoreDenominazione(String val) {

		s8hOperatoreDenominazione = val;

	}

	/**
	 * Legge il valore della proprieta' s8hOperatoreDenominazione associata alla
	 * @generated
	 */
	public String getS8hOperatoreDenominazione() {

		return s8hOperatoreDenominazione;

	}

	/**
	 * store della proprieta' associata alla colonna S8I_OPERATORE_NUM_ISCRIZ
	 * @generated
	 */
	protected String s8iOperatoreNumIscriz;

	/**
	 * Imposta il valore della proprieta' s8iOperatoreNumIscriz associata alla
	 * colonna S8I_OPERATORE_NUM_ISCRIZ.
	 * @generated
	 */
	public void setS8iOperatoreNumIscriz(String val) {

		s8iOperatoreNumIscriz = val;

	}

	/**
	 * Legge il valore della proprieta' s8iOperatoreNumIscriz associata alla
	 * @generated
	 */
	public String getS8iOperatoreNumIscriz() {

		return s8iOperatoreNumIscriz;

	}

	/**
	 * store della proprieta' associata alla colonna S8J_SURRISCALDAMENTO_K
	 * @generated
	 */
	protected java.math.BigDecimal s8jSurriscaldamentoK;

	/**
	 * Imposta il valore della proprieta' s8jSurriscaldamentoK associata alla
	 * colonna S8J_SURRISCALDAMENTO_K.
	 * @generated
	 */
	public void setS8jSurriscaldamentoK(java.math.BigDecimal val) {

		s8jSurriscaldamentoK = val;

	}

	/**
	 * Legge il valore della proprieta' s8jSurriscaldamentoK associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8jSurriscaldamentoK() {

		return s8jSurriscaldamentoK;

	}

	/**
	 * store della proprieta' associata alla colonna S8J_SOTTORAFFREDDAMENTO_K
	 * @generated
	 */
	protected java.math.BigDecimal s8jSottoraffreddamentoK;

	/**
	 * Imposta il valore della proprieta' s8jSottoraffreddamentoK associata alla
	 * colonna S8J_SOTTORAFFREDDAMENTO_K.
	 * @generated
	 */
	public void setS8jSottoraffreddamentoK(java.math.BigDecimal val) {

		s8jSottoraffreddamentoK = val;

	}

	/**
	 * Legge il valore della proprieta' s8jSottoraffreddamentoK associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8jSottoraffreddamentoK() {

		return s8jSottoraffreddamentoK;

	}

	/**
	 * store della proprieta' associata alla colonna S8J_TEMP_CONDENSAZIONE_C
	 * @generated
	 */
	protected java.math.BigDecimal s8jTempCondensazioneC;

	/**
	 * Imposta il valore della proprieta' s8jTempCondensazioneC associata alla
	 * colonna S8J_TEMP_CONDENSAZIONE_C.
	 * @generated
	 */
	public void setS8jTempCondensazioneC(java.math.BigDecimal val) {

		s8jTempCondensazioneC = val;

	}

	/**
	 * Legge il valore della proprieta' s8jTempCondensazioneC associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8jTempCondensazioneC() {

		return s8jTempCondensazioneC;

	}

	/**
	 * store della proprieta' associata alla colonna S8J_TEMP_EVAPORAZIONE_C
	 * @generated
	 */
	protected java.math.BigDecimal s8jTempEvaporazioneC;

	/**
	 * Imposta il valore della proprieta' s8jTempEvaporazioneC associata alla
	 * colonna S8J_TEMP_EVAPORAZIONE_C.
	 * @generated
	 */
	public void setS8jTempEvaporazioneC(java.math.BigDecimal val) {

		s8jTempEvaporazioneC = val;

	}

	/**
	 * Legge il valore della proprieta' s8jTempEvaporazioneC associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8jTempEvaporazioneC() {

		return s8jTempEvaporazioneC;

	}

	/**
	 * store della proprieta' associata alla colonna S8J_TEMP_SORG_INGRESSO_C
	 * @generated
	 */
	protected java.math.BigDecimal s8jTempSorgIngressoC;

	/**
	 * Imposta il valore della proprieta' s8jTempSorgIngressoC associata alla
	 * colonna S8J_TEMP_SORG_INGRESSO_C.
	 * @generated
	 */
	public void setS8jTempSorgIngressoC(java.math.BigDecimal val) {

		s8jTempSorgIngressoC = val;

	}

	/**
	 * Legge il valore della proprieta' s8jTempSorgIngressoC associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8jTempSorgIngressoC() {

		return s8jTempSorgIngressoC;

	}

	/**
	 * store della proprieta' associata alla colonna S8J_TEMP_SORG_USCITA_C
	 * @generated
	 */
	protected java.math.BigDecimal s8jTempSorgUscitaC;

	/**
	 * Imposta il valore della proprieta' s8jTempSorgUscitaC associata alla
	 * colonna S8J_TEMP_SORG_USCITA_C.
	 * @generated
	 */
	public void setS8jTempSorgUscitaC(java.math.BigDecimal val) {

		s8jTempSorgUscitaC = val;

	}

	/**
	 * Legge il valore della proprieta' s8jTempSorgUscitaC associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8jTempSorgUscitaC() {

		return s8jTempSorgUscitaC;

	}

	/**
	 * store della proprieta' associata alla colonna S8J_TEMP_INGRESSO_FLUIDO_C
	 * @generated
	 */
	protected java.math.BigDecimal s8jTempIngressoFluidoC;

	/**
	 * Imposta il valore della proprieta' s8jTempIngressoFluidoC associata alla
	 * colonna S8J_TEMP_INGRESSO_FLUIDO_C.
	 * @generated
	 */
	public void setS8jTempIngressoFluidoC(java.math.BigDecimal val) {

		s8jTempIngressoFluidoC = val;

	}

	/**
	 * Legge il valore della proprieta' s8jTempIngressoFluidoC associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8jTempIngressoFluidoC() {

		return s8jTempIngressoFluidoC;

	}

	/**
	 * store della proprieta' associata alla colonna S8J_TEMP_USCITA_FLUIDO_C
	 * @generated
	 */
	protected java.math.BigDecimal s8jTempUscitaFluidoC;

	/**
	 * Imposta il valore della proprieta' s8jTempUscitaFluidoC associata alla
	 * colonna S8J_TEMP_USCITA_FLUIDO_C.
	 * @generated
	 */
	public void setS8jTempUscitaFluidoC(java.math.BigDecimal val) {

		s8jTempUscitaFluidoC = val;

	}

	/**
	 * Legge il valore della proprieta' s8jTempUscitaFluidoC associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS8jTempUscitaFluidoC() {

		return s8jTempUscitaFluidoC;

	}

	/**
	 * store della proprieta' associata alla colonna S9A_FLG_VERIFICA_SUPERATA
	 * @generated
	 */
	protected java.math.BigDecimal s9aFlgVerificaSuperata;

	/**
	 * Imposta il valore della proprieta' s9aFlgVerificaSuperata associata alla
	 * colonna S9A_FLG_VERIFICA_SUPERATA.
	 * @generated
	 */
	public void setS9aFlgVerificaSuperata(java.math.BigDecimal val) {

		s9aFlgVerificaSuperata = val;

	}

	/**
	 * Legge il valore della proprieta' s9aFlgVerificaSuperata associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS9aFlgVerificaSuperata() {

		return s9aFlgVerificaSuperata;

	}

	/**
	 * store della proprieta' associata alla colonna S9B_FLG_RISPETTO_NORMATIVA
	 * @generated
	 */
	protected java.math.BigDecimal s9bFlgRispettoNormativa;

	/**
	 * Imposta il valore della proprieta' s9bFlgRispettoNormativa associata alla
	 * colonna S9B_FLG_RISPETTO_NORMATIVA.
	 * @generated
	 */
	public void setS9bFlgRispettoNormativa(java.math.BigDecimal val) {

		s9bFlgRispettoNormativa = val;

	}

	/**
	 * Legge il valore della proprieta' s9bFlgRispettoNormativa associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS9bFlgRispettoNormativa() {

		return s9bFlgRispettoNormativa;

	}

	/**
	 * store della proprieta' associata alla colonna S9C_FLG_NO_RISPETTO_7A
	 * @generated
	 */
	protected java.math.BigDecimal s9cFlgNoRispetto7a;

	/**
	 * Imposta il valore della proprieta' s9cFlgNoRispetto7a associata alla
	 * colonna S9C_FLG_NO_RISPETTO_7A.
	 * @generated
	 */
	public void setS9cFlgNoRispetto7a(java.math.BigDecimal val) {

		s9cFlgNoRispetto7a = val;

	}

	/**
	 * Legge il valore della proprieta' s9cFlgNoRispetto7a associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS9cFlgNoRispetto7a() {

		return s9cFlgNoRispetto7a;

	}

	/**
	 * store della proprieta' associata alla colonna S9C_FLG_NO_RISPETTO_7B
	 * @generated
	 */
	protected java.math.BigDecimal s9cFlgNoRispetto7b;

	/**
	 * Imposta il valore della proprieta' s9cFlgNoRispetto7b associata alla
	 * colonna S9C_FLG_NO_RISPETTO_7B.
	 * @generated
	 */
	public void setS9cFlgNoRispetto7b(java.math.BigDecimal val) {

		s9cFlgNoRispetto7b = val;

	}

	/**
	 * Legge il valore della proprieta' s9cFlgNoRispetto7b associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS9cFlgNoRispetto7b() {

		return s9cFlgNoRispetto7b;

	}

	/**
	 * store della proprieta' associata alla colonna S9C_FLG_NO_RISPETTO_8D
	 * @generated
	 */
	protected java.math.BigDecimal s9cFlgNoRispetto8d;

	/**
	 * Imposta il valore della proprieta' s9cFlgNoRispetto8d associata alla
	 * colonna S9C_FLG_NO_RISPETTO_8D.
	 * @generated
	 */
	public void setS9cFlgNoRispetto8d(java.math.BigDecimal val) {

		s9cFlgNoRispetto8d = val;

	}

	/**
	 * Legge il valore della proprieta' s9cFlgNoRispetto8d associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS9cFlgNoRispetto8d() {

		return s9cFlgNoRispetto8d;

	}

	/**
	 * store della proprieta' associata alla colonna S9C_FLG_NO_RISPETTO_9A
	 * @generated
	 */
	protected java.math.BigDecimal s9cFlgNoRispetto9a;

	/**
	 * Imposta il valore della proprieta' s9cFlgNoRispetto9a associata alla
	 * colonna S9C_FLG_NO_RISPETTO_9A.
	 * @generated
	 */
	public void setS9cFlgNoRispetto9a(java.math.BigDecimal val) {

		s9cFlgNoRispetto9a = val;

	}

	/**
	 * Legge il valore della proprieta' s9cFlgNoRispetto9a associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS9cFlgNoRispetto9a() {

		return s9cFlgNoRispetto9a;

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
	 * store della proprieta' associata alla colonna S8A_N_CIRCUITO
	 * @generated
	 */
	protected String s8aNCircuito;

	/**
	 * Imposta il valore della proprieta' s8aNCircuito associata alla
	 * colonna S8A_N_CIRCUITO.
	 * @generated
	 */
	public void setS8aNCircuito(String val) {

		s8aNCircuito = val;

	}

	/**
	 * Legge il valore della proprieta' s8aNCircuito associata alla
	 * @generated
	 */
	public String getS8aNCircuito() {

		return s8aNCircuito;

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
	 * Crea una istanza di SigitTDettIspezGfPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTDettIspezGfPk
	 * @generated
	 */
	public SigitTDettIspezGfPk createPk() {
		return new SigitTDettIspezGfPk(idDettIspezGf);
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
