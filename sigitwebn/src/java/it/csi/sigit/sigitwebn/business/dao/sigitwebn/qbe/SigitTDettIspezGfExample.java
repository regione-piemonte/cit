package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTDettIspezGfDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTDettIspezGfExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idDettIspezGf;

	/**
	 * @generated
	 */
	public void setIdDettIspezGf(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idDettIspezGf = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdDettIspezGf() {
		return idDettIspezGf;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkAllegato;

	/**
	 * @generated
	 */
	public void setFkAllegato(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkAllegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkAllegato() {
		return fkAllegato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkTipoComponente;

	/**
	 * @generated
	 */
	public void setFkTipoComponente(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkTipoComponente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkTipoComponente() {
		return fkTipoComponente;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk progressivo;

	/**
	 * @generated
	 */
	public void setProgressivo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		progressivo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getProgressivo() {
		return progressivo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk codiceImpianto;

	/**
	 * @generated
	 */
	public void setCodiceImpianto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		codiceImpianto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCodiceImpianto() {
		return codiceImpianto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataInstall;

	/**
	 * @generated
	 */
	public void setDataInstall(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataInstall = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataInstall() {
		return dataInstall;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s6hFlgInverter;

	/**
	 * @generated
	 */
	public void setS6hFlgInverter(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s6hFlgInverter = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS6hFlgInverter() {
		return s6hFlgInverter;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s6nFlgFugaDiretta;

	/**
	 * @generated
	 */
	public void setS6nFlgFugaDiretta(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s6nFlgFugaDiretta = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS6nFlgFugaDiretta() {
		return s6nFlgFugaDiretta;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s6nFlgFugaIndiretta;

	/**
	 * @generated
	 */
	public void setS6nFlgFugaIndiretta(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s6nFlgFugaIndiretta = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS6nFlgFugaIndiretta() {
		return s6nFlgFugaIndiretta;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7aFkFrequenzaManut;

	/**
	 * @generated
	 */
	public void setS7aFkFrequenzaManut(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7aFkFrequenzaManut = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7aFkFrequenzaManut() {
		return s7aFkFrequenzaManut;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7aFlgManutEffettuata;

	/**
	 * @generated
	 */
	public void setS7aFlgManutEffettuata(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7aFlgManutEffettuata = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7aFlgManutEffettuata() {
		return s7aFlgManutEffettuata;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7aDataUltimaManut;

	/**
	 * @generated
	 */
	public void setS7aDataUltimaManut(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7aDataUltimaManut = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7aDataUltimaManut() {
		return s7aDataUltimaManut;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7bFlgRegistroApparecc;

	/**
	 * @generated
	 */
	public void setS7bFlgRegistroApparecc(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7bFlgRegistroApparecc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7bFlgRegistroApparecc() {
		return s7bFlgRegistroApparecc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7cFlgReePresente;

	/**
	 * @generated
	 */
	public void setS7cFlgReePresente(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7cFlgReePresente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7cFlgReePresente() {
		return s7cFlgReePresente;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7cDataRee;

	/**
	 * @generated
	 */
	public void setS7cDataRee(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7cDataRee = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7cDataRee() {
		return s7cDataRee;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7cFlgOsservazioni;

	/**
	 * @generated
	 */
	public void setS7cFlgOsservazioni(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7cFlgOsservazioni = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7cFlgOsservazioni() {
		return s7cFlgOsservazioni;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7cFlgRaccomand;

	/**
	 * @generated
	 */
	public void setS7cFlgRaccomand(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7cFlgRaccomand = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7cFlgRaccomand() {
		return s7cFlgRaccomand;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7cFlgPrescr;

	/**
	 * @generated
	 */
	public void setS7cFlgPrescr(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7cFlgPrescr = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7cFlgPrescr() {
		return s7cFlgPrescr;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8bFlgProveRiscaldamento;

	/**
	 * @generated
	 */
	public void setS8bFlgProveRiscaldamento(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8bFlgProveRiscaldamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8bFlgProveRiscaldamento() {
		return s8bFlgProveRiscaldamento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8bFlgProveRaffrescamento;

	/**
	 * @generated
	 */
	public void setS8bFlgProveRaffrescamento(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8bFlgProveRaffrescamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8bFlgProveRaffrescamento() {
		return s8bFlgProveRaffrescamento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8cFlgFiltriPuliti;

	/**
	 * @generated
	 */
	public void setS8cFlgFiltriPuliti(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8cFlgFiltriPuliti = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8cFlgFiltriPuliti() {
		return s8cFlgFiltriPuliti;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8dFlgAssenzaPerditeGas;

	/**
	 * @generated
	 */
	public void setS8dFlgAssenzaPerditeGas(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8dFlgAssenzaPerditeGas = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8dFlgAssenzaPerditeGas() {
		return s8dFlgAssenzaPerditeGas;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8eMarcaStrumMisura;

	/**
	 * @generated
	 */
	public void setS8eMarcaStrumMisura(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8eMarcaStrumMisura = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8eMarcaStrumMisura() {
		return s8eMarcaStrumMisura;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8eModelloStrumMisura;

	/**
	 * @generated
	 */
	public void setS8eModelloStrumMisura(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8eModelloStrumMisura = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8eModelloStrumMisura() {
		return s8eModelloStrumMisura;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8eMatricolaStrumMisura;

	/**
	 * @generated
	 */
	public void setS8eMatricolaStrumMisura(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8eMatricolaStrumMisura = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8eMatricolaStrumMisura() {
		return s8eMatricolaStrumMisura;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8fPotAssorbitaKw;

	/**
	 * @generated
	 */
	public void setS8fPotAssorbitaKw(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8fPotAssorbitaKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8fPotAssorbitaKw() {
		return s8fPotAssorbitaKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8gFlgStrumentazioneFissa;

	/**
	 * @generated
	 */
	public void setS8gFlgStrumentazioneFissa(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8gFlgStrumentazioneFissa = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8gFlgStrumentazioneFissa() {
		return s8gFlgStrumentazioneFissa;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8hOperatoreDenominazione;

	/**
	 * @generated
	 */
	public void setS8hOperatoreDenominazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8hOperatoreDenominazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8hOperatoreDenominazione() {
		return s8hOperatoreDenominazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8iOperatoreNumIscriz;

	/**
	 * @generated
	 */
	public void setS8iOperatoreNumIscriz(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8iOperatoreNumIscriz = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8iOperatoreNumIscriz() {
		return s8iOperatoreNumIscriz;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8jSurriscaldamentoK;

	/**
	 * @generated
	 */
	public void setS8jSurriscaldamentoK(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8jSurriscaldamentoK = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8jSurriscaldamentoK() {
		return s8jSurriscaldamentoK;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8jSottoraffreddamentoK;

	/**
	 * @generated
	 */
	public void setS8jSottoraffreddamentoK(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8jSottoraffreddamentoK = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8jSottoraffreddamentoK() {
		return s8jSottoraffreddamentoK;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8jTempCondensazioneC;

	/**
	 * @generated
	 */
	public void setS8jTempCondensazioneC(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8jTempCondensazioneC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8jTempCondensazioneC() {
		return s8jTempCondensazioneC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8jTempEvaporazioneC;

	/**
	 * @generated
	 */
	public void setS8jTempEvaporazioneC(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8jTempEvaporazioneC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8jTempEvaporazioneC() {
		return s8jTempEvaporazioneC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8jTempSorgIngressoC;

	/**
	 * @generated
	 */
	public void setS8jTempSorgIngressoC(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8jTempSorgIngressoC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8jTempSorgIngressoC() {
		return s8jTempSorgIngressoC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8jTempSorgUscitaC;

	/**
	 * @generated
	 */
	public void setS8jTempSorgUscitaC(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8jTempSorgUscitaC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8jTempSorgUscitaC() {
		return s8jTempSorgUscitaC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8jTempIngressoFluidoC;

	/**
	 * @generated
	 */
	public void setS8jTempIngressoFluidoC(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8jTempIngressoFluidoC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8jTempIngressoFluidoC() {
		return s8jTempIngressoFluidoC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8jTempUscitaFluidoC;

	/**
	 * @generated
	 */
	public void setS8jTempUscitaFluidoC(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8jTempUscitaFluidoC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8jTempUscitaFluidoC() {
		return s8jTempUscitaFluidoC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9aFlgVerificaSuperata;

	/**
	 * @generated
	 */
	public void setS9aFlgVerificaSuperata(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9aFlgVerificaSuperata = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9aFlgVerificaSuperata() {
		return s9aFlgVerificaSuperata;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9bFlgRispettoNormativa;

	/**
	 * @generated
	 */
	public void setS9bFlgRispettoNormativa(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9bFlgRispettoNormativa = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9bFlgRispettoNormativa() {
		return s9bFlgRispettoNormativa;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9cFlgNoRispetto7a;

	/**
	 * @generated
	 */
	public void setS9cFlgNoRispetto7a(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9cFlgNoRispetto7a = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9cFlgNoRispetto7a() {
		return s9cFlgNoRispetto7a;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9cFlgNoRispetto7b;

	/**
	 * @generated
	 */
	public void setS9cFlgNoRispetto7b(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9cFlgNoRispetto7b = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9cFlgNoRispetto7b() {
		return s9cFlgNoRispetto7b;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9cFlgNoRispetto8d;

	/**
	 * @generated
	 */
	public void setS9cFlgNoRispetto8d(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9cFlgNoRispetto8d = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9cFlgNoRispetto8d() {
		return s9cFlgNoRispetto8d;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9cFlgNoRispetto9a;

	/**
	 * @generated
	 */
	public void setS9cFlgNoRispetto9a(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9cFlgNoRispetto9a = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9cFlgNoRispetto9a() {
		return s9cFlgNoRispetto9a;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7aFrequenzaManutAltro;

	/**
	 * @generated
	 */
	public void setS7aFrequenzaManutAltro(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7aFrequenzaManutAltro = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7aFrequenzaManutAltro() {
		return s7aFrequenzaManutAltro;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8aNCircuito;

	/**
	 * @generated
	 */
	public void setS8aNCircuito(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8aNCircuito = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8aNCircuito() {
		return s8aNCircuito;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataUltMod;

	/**
	 * @generated
	 */
	public void setDataUltMod(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataUltMod = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataUltMod() {
		return dataUltMod;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk utenteUltMod;

	/**
	 * @generated
	 */
	public void setUtenteUltMod(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		utenteUltMod = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getUtenteUltMod() {
		return utenteUltMod;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk controlloweb;

	/**
	 * @generated
	 */
	public void setControlloweb(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		controlloweb = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getControlloweb() {
		return controlloweb;
	}

}
