package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class SigitTDettIspezGfDto {

    private SigitTDettIspezGfPk sigitTDettIspezGfPk;
    private BigDecimal fkAllegato;
    private String fkTipoComponente;
    private BigDecimal progressivo;
    private BigDecimal codiceImpianto;
    private Date dataInstall;
    private String s8aNCircuito;
    private Timestamp dataUltMod;
    private String utenteUltMod;
    private BigDecimal s9aFlgVerificaSuperata;
    private BigDecimal S9bFlgRispettoNormativa;
    private BigDecimal s9cFlgNoRispetto7a;
    private BigDecimal s9cFlgNoRispetto7b;
    private BigDecimal s9cFlgNoRispetto8d;
    private BigDecimal s9cFlgNoRispetto9a;
    private BigDecimal s8bFlgProveRaffrescamento;
    private BigDecimal s8bFlgProveRiscaldamento;
    private BigDecimal s8cFlgFiltriPuliti;   
    private BigDecimal s8dFlgAssenzaPerditeGas;
    private String s8eMarcaStrumMisura;
    private String s8eModelloStrumMisura;
    private String s8eMatricolaStrumMisura;
    private BigDecimal s8fPotAssorbitaKw;
    private BigDecimal s8gFlgStrumentazioneFissa;
    private String s8hOperatoreDenominazione;
    private String s8iOperatoreNumIscriz;
    private BigDecimal s8jSurriscaldamentoK;
    private BigDecimal s8jTempSorgIngressoC;
    private BigDecimal s8jSottoraffreddamentoK;
    private BigDecimal s8jTempSorgUscitaC;
    private BigDecimal s8jTempCondensazioneC;
    private BigDecimal s8jTempIngressoFluidoC;
    private BigDecimal s8jTempEvaporazioneC;
    private BigDecimal s8jTempUscitaFluidoC;
    private Integer s7aFkFrequenzaManut;
    private String s7aFrequenzaManutAltro;
    private BigDecimal s7aFlgManutEffettuata;
    private Date s7aDataUltimaManut;
    private BigDecimal s7bFlgRegistroApparecc;
    private BigDecimal s7cFlgReePresente;
    private Date s7cDataRee;
    private BigDecimal s7cFlgOsservazioni;
    private BigDecimal s7cFlgRaccomand;
    private BigDecimal s7cFlgPrescr;
    private BigDecimal s6hFlgInverter;
    private BigDecimal s6nFlgFugaDiretta;
    private BigDecimal s6nFlgFugaIndiretta;
    private BigDecimal idDettIspezGf;        
    private Timestamp controlloWeb;
    
    private BigDecimal s9eFlgNoRispetto7a;
    private BigDecimal s9eFlgNoRispetto7b;
    
    private BigDecimal s9eFlgNoRispetto9a;
    private BigDecimal s9eFlgNoRispetto9b;
    private BigDecimal s9eFlgNoRispetto9c;
    private BigDecimal s9eFlgNoRispetto9d;
    
    
    
	public BigDecimal getS9eFlgNoRispetto7a() {
		return s9eFlgNoRispetto7a;
	}
	public void setS9eFlgNoRispetto7a(BigDecimal s9eFlgNoRispetto7a) {
		this.s9eFlgNoRispetto7a = s9eFlgNoRispetto7a;
	}
	public BigDecimal getS9eFlgNoRispetto7b() {
		return s9eFlgNoRispetto7b;
	}
	public void setS9eFlgNoRispetto7b(BigDecimal s9eFlgNoRispetto7b) {
		this.s9eFlgNoRispetto7b = s9eFlgNoRispetto7b;
	}
	public BigDecimal getS9eFlgNoRispetto9a() {
		return s9eFlgNoRispetto9a;
	}
	public void setS9eFlgNoRispetto9a(BigDecimal s9eFlgNoRispetto9a) {
		this.s9eFlgNoRispetto9a = s9eFlgNoRispetto9a;
	}
	public BigDecimal getS9eFlgNoRispetto9b() {
		return s9eFlgNoRispetto9b;
	}
	public void setS9eFlgNoRispetto9b(BigDecimal s9eFlgNoRispetto9b) {
		this.s9eFlgNoRispetto9b = s9eFlgNoRispetto9b;
	}
	public BigDecimal getS9eFlgNoRispetto9c() {
		return s9eFlgNoRispetto9c;
	}
	public void setS9eFlgNoRispetto9c(BigDecimal s9eFlgNoRispetto9c) {
		this.s9eFlgNoRispetto9c = s9eFlgNoRispetto9c;
	}
	public BigDecimal getS9eFlgNoRispetto9d() {
		return s9eFlgNoRispetto9d;
	}
	public void setS9eFlgNoRispetto9d(BigDecimal s9eFlgNoRispetto9d) {
		this.s9eFlgNoRispetto9d = s9eFlgNoRispetto9d;
	}
	public BigDecimal getIdDettIspezGf() {
		return idDettIspezGf;
	}
	public void setIdDettIspezGf(BigDecimal idDettIspezGf) {
		this.idDettIspezGf = idDettIspezGf;
	}
	public SigitTDettIspezGfPk getSigitTDettIspezGfPk() {
		return sigitTDettIspezGfPk;
	}
	public void setSigitTDettIspezGfPk(SigitTDettIspezGfPk sigitTDettIspezGfPk) {
		this.sigitTDettIspezGfPk = sigitTDettIspezGfPk;
	}
	public BigDecimal getFkAllegato() {
		return fkAllegato;
	}
	public void setFkAllegato(BigDecimal fkAllegato) {
		this.fkAllegato = fkAllegato;
	}
	public String getFkTipoComponente() {
		return fkTipoComponente;
	}
	public void setFkTipoComponente(String fkTipoComponente) {
		this.fkTipoComponente = fkTipoComponente;
	}
	public BigDecimal getProgressivo() {
		return progressivo;
	}
	public void setProgressivo(BigDecimal progressivo) {
		this.progressivo = progressivo;
	}
	public BigDecimal getCodiceImpianto() {
		return codiceImpianto;
	}
	public void setCodiceImpianto(BigDecimal codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}
	public Date getDataInstall() {
		return dataInstall;
	}
	public void setDataInstall(Date dataInstall) {
		this.dataInstall = dataInstall;
	}
	public String getS8aNCircuito() {
		return s8aNCircuito;
	}
	public void setS8aNCircuito(String s8aNCircuito) {
		this.s8aNCircuito = s8aNCircuito;
	}
	public Timestamp getDataUltMod() {
		return dataUltMod;
	}
	public void setDataUltMod(Timestamp dataUltMod) {
		this.dataUltMod = dataUltMod;
	}
	public String getUtenteUltMod() {
		return utenteUltMod;
	}
	public void setUtenteUltMod(String utenteUltMod) {
		this.utenteUltMod = utenteUltMod;
	}
	public BigDecimal getS9aFlgVerificaSuperata() {
		return s9aFlgVerificaSuperata;
	}
	public void setS9aFlgVerificaSuperata(BigDecimal s9aFlgVerificaSuperata) {
		this.s9aFlgVerificaSuperata = s9aFlgVerificaSuperata;
	}
	public BigDecimal getS9bFlgRispettoNormativa() {
		return S9bFlgRispettoNormativa;
	}
	public void setS9bFlgRispettoNormativa(BigDecimal s9bFlgRispettoNormativa) {
		S9bFlgRispettoNormativa = s9bFlgRispettoNormativa;
	}
	public BigDecimal getS9cFlgNoRispetto7a() {
		return s9cFlgNoRispetto7a;
	}
	public void setS9cFlgNoRispetto7a(BigDecimal s9cFlgNoRispetto7a) {
		this.s9cFlgNoRispetto7a = s9cFlgNoRispetto7a;
	}
	public BigDecimal getS9cFlgNoRispetto7b() {
		return s9cFlgNoRispetto7b;
	}
	public void setS9cFlgNoRispetto7b(BigDecimal s9cFlgNoRispetto7b) {
		this.s9cFlgNoRispetto7b = s9cFlgNoRispetto7b;
	}
	public BigDecimal getS9cFlgNoRispetto8d() {
		return s9cFlgNoRispetto8d;
	}
	public void setS9cFlgNoRispetto8d(BigDecimal s9cFlgNoRispetto8d) {
		this.s9cFlgNoRispetto8d = s9cFlgNoRispetto8d;
	}
	public BigDecimal getS9cFlgNoRispetto9a() {
		return s9cFlgNoRispetto9a;
	}
	public void setS9cFlgNoRispetto9a(BigDecimal s9cFlgNoRispetto9a) {
		this.s9cFlgNoRispetto9a = s9cFlgNoRispetto9a;
	}
	public BigDecimal getS8bFlgProveRaffrescamento() {
		return s8bFlgProveRaffrescamento;
	}
	public void setS8bFlgProveRaffrescamento(BigDecimal s8bFlgProveRaffrescamento) {
		this.s8bFlgProveRaffrescamento = s8bFlgProveRaffrescamento;
	}
	public BigDecimal getS8bFlgProveRiscaldamento() {
		return s8bFlgProveRiscaldamento;
	}
	public void setS8bFlgProveRiscaldamento(BigDecimal s8bFlgProveRiscaldamento) {
		this.s8bFlgProveRiscaldamento = s8bFlgProveRiscaldamento;
	}
	public BigDecimal getS8cFlgFiltriPuliti() {
		return s8cFlgFiltriPuliti;
	}
	public void setS8cFlgFiltriPuliti(BigDecimal s8cFlgFiltriPuliti) {
		this.s8cFlgFiltriPuliti = s8cFlgFiltriPuliti;
	}
	public BigDecimal getS8dFlgAssenzaPerditeGas() {
		return s8dFlgAssenzaPerditeGas;
	}
	public void setS8dFlgAssenzaPerditeGas(BigDecimal s8dFlgAssenzaPerditeGas) {
		this.s8dFlgAssenzaPerditeGas = s8dFlgAssenzaPerditeGas;
	}
	public String getS8eMarcaStrumMisura() {
		return s8eMarcaStrumMisura;
	}
	public void setS8eMarcaStrumMisura(String s8eMarcaStrumMisura) {
		this.s8eMarcaStrumMisura = s8eMarcaStrumMisura;
	}
	public String getS8eModelloStrumMisura() {
		return s8eModelloStrumMisura;
	}
	public void setS8eModelloStrumMisura(String s8eModelloStrumMisura) {
		this.s8eModelloStrumMisura = s8eModelloStrumMisura;
	}
	public String getS8eMatricolaStrumMisura() {
		return s8eMatricolaStrumMisura;
	}
	public void setS8eMatricolaStrumMisura(String s8eMatricolaStrumMisura) {
		this.s8eMatricolaStrumMisura = s8eMatricolaStrumMisura;
	}
	public BigDecimal getS8fPotAssorbitaKw() {
		return s8fPotAssorbitaKw;
	}
	public void setS8fPotAssorbitaKw(BigDecimal s8fPotAssorbitaKw) {
		this.s8fPotAssorbitaKw = s8fPotAssorbitaKw;
	}
	public BigDecimal getS8gFlgStrumentazioneFissa() {
		return s8gFlgStrumentazioneFissa;
	}
	public void setS8gFlgStrumentazioneFissa(BigDecimal s8gFlgStrumentazioneFissa) {
		this.s8gFlgStrumentazioneFissa = s8gFlgStrumentazioneFissa;
	}
	public String getS8hOperatoreDenominazione() {
		return s8hOperatoreDenominazione;
	}
	public void setS8hOperatoreDenominazione(String s8hOperatoreDenominazione) {
		this.s8hOperatoreDenominazione = s8hOperatoreDenominazione;
	}
	public String getS8iOperatoreNumIscriz() {
		return s8iOperatoreNumIscriz;
	}
	public void setS8iOperatoreNumIscriz(String s8iOperatoreNumIscriz) {
		this.s8iOperatoreNumIscriz = s8iOperatoreNumIscriz;
	}
	public BigDecimal getS8jSurriscaldamentoK() {
		return s8jSurriscaldamentoK;
	}
	public void setS8jSurriscaldamentoK(BigDecimal s8jSurriscaldamentoK) {
		this.s8jSurriscaldamentoK = s8jSurriscaldamentoK;
	}
	public BigDecimal getS8jTempSorgIngressoC() {
		return s8jTempSorgIngressoC;
	}
	public void setS8jTempSorgIngressoC(BigDecimal s8jTempSorgIngressoC) {
		this.s8jTempSorgIngressoC = s8jTempSorgIngressoC;
	}
	public BigDecimal getS8jSottoraffreddamentoK() {
		return s8jSottoraffreddamentoK;
	}
	public void setS8jSottoraffreddamentoK(BigDecimal s8jSottoraffreddamentoK) {
		this.s8jSottoraffreddamentoK = s8jSottoraffreddamentoK;
	}
	public BigDecimal getS8jTempSorgUscitaC() {
		return s8jTempSorgUscitaC;
	}
	public void setS8jTempSorgUscitaC(BigDecimal s8jTempSorgUscitaC) {
		this.s8jTempSorgUscitaC = s8jTempSorgUscitaC;
	}
	public BigDecimal getS8jTempCondensazioneC() {
		return s8jTempCondensazioneC;
	}
	public void setS8jTempCondensazioneC(BigDecimal s8jTempCondensazioneC) {
		this.s8jTempCondensazioneC = s8jTempCondensazioneC;
	}
	public BigDecimal getS8jTempIngressoFluidoC() {
		return s8jTempIngressoFluidoC;
	}
	public void setS8jTempIngressoFluidoC(BigDecimal s8jTempIngressoFluidoC) {
		this.s8jTempIngressoFluidoC = s8jTempIngressoFluidoC;
	}
	public BigDecimal getS8jTempEvaporazioneC() {
		return s8jTempEvaporazioneC;
	}
	public void setS8jTempEvaporazioneC(BigDecimal s8jTempEvaporazioneC) {
		this.s8jTempEvaporazioneC = s8jTempEvaporazioneC;
	}
	public BigDecimal getS8jTempUscitaFluidoC() {
		return s8jTempUscitaFluidoC;
	}
	public void setS8jTempUscitaFluidoC(BigDecimal s8jTempUscitaFluidoC) {
		this.s8jTempUscitaFluidoC = s8jTempUscitaFluidoC;
	}
	public Integer getS7aFkFrequenzaManut() {
		return s7aFkFrequenzaManut;
	}
	public void setS7aFkFrequenzaManut(Integer s7aFkFrequenzaManut) {
		this.s7aFkFrequenzaManut = s7aFkFrequenzaManut;
	}
	public String getS7aFrequenzaManutAltro() {
		return s7aFrequenzaManutAltro;
	}
	public void setS7aFrequenzaManutAltro(String s7aFrequenzaManutAltro) {
		this.s7aFrequenzaManutAltro = s7aFrequenzaManutAltro;
	}
	public BigDecimal getS7aFlgManutEffettuata() {
		return s7aFlgManutEffettuata;
	}
	public void setS7aFlgManutEffettuata(BigDecimal s7aFlgManutEffettuata) {
		this.s7aFlgManutEffettuata = s7aFlgManutEffettuata;
	}
	public Date getS7aDataUltimaManut() {
		return s7aDataUltimaManut;
	}
	public void setS7aDataUltimaManut(Date s7aDataUltimaManut) {
		this.s7aDataUltimaManut = s7aDataUltimaManut;
	}
	public BigDecimal getS7bFlgRegistroApparecc() {
		return s7bFlgRegistroApparecc;
	}
	public void setS7bFlgRegistroApparecc(BigDecimal s7bFlgRegistroApparecc) {
		this.s7bFlgRegistroApparecc = s7bFlgRegistroApparecc;
	}
	public BigDecimal getS7cFlgReePresente() {
		return s7cFlgReePresente;
	}
	public void setS7cFlgReePresente(BigDecimal s7cFlgReePresente) {
		this.s7cFlgReePresente = s7cFlgReePresente;
	}
	public Date getS7cDataRee() {
		return s7cDataRee;
	}
	public void setS7cDataRee(Date s7cDataRee) {
		this.s7cDataRee = s7cDataRee;
	}
	public BigDecimal getS7cFlgOsservazioni() {
		return s7cFlgOsservazioni;
	}
	public void setS7cFlgOsservazioni(BigDecimal s7cFlgOsservazioni) {
		this.s7cFlgOsservazioni = s7cFlgOsservazioni;
	}
	public BigDecimal getS7cFlgRaccomand() {
		return s7cFlgRaccomand;
	}
	public void setS7cFlgRaccomand(BigDecimal s7cFlgRaccomand) {
		this.s7cFlgRaccomand = s7cFlgRaccomand;
	}
	public BigDecimal getS7cFlgPrescr() {
		return s7cFlgPrescr;
	}
	public void setS7cFlgPrescr(BigDecimal s7cFlgPrescr) {
		this.s7cFlgPrescr = s7cFlgPrescr;
	}
	public BigDecimal getS6hFlgInverter() {
		return s6hFlgInverter;
	}
	public void setS6hFlgInverter(BigDecimal s6hFlgInverter) {
		this.s6hFlgInverter = s6hFlgInverter;
	}
	public BigDecimal getS6nFlgFugaDiretta() {
		return s6nFlgFugaDiretta;
	}
	public void setS6nFlgFugaDiretta(BigDecimal s6nFlgFugaDiretta) {
		this.s6nFlgFugaDiretta = s6nFlgFugaDiretta;
	}
	public BigDecimal getS6nFlgFugaIndiretta() {
		return s6nFlgFugaIndiretta;
	}
	public void setS6nFlgFugaIndiretta(BigDecimal s6nFlgFugaIndiretta) {
		this.s6nFlgFugaIndiretta = s6nFlgFugaIndiretta;
	}
	public Timestamp getControlloWeb() {
		return controlloWeb;
	}
	public void setControlloWeb(Timestamp controlloWeb) {
		this.controlloWeb = controlloWeb;		
	}



    
    
    
}
