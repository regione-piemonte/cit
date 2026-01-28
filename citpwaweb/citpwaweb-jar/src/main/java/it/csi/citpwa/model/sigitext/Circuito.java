package it.csi.citpwa.model.sigitext;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Circuito {
    private String s8aNCircuito;
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
    private BigDecimal s9aFlgVerificaSuperata;
    private BigDecimal s9bFlgRispettoNormativa;
    private BigDecimal s9cFlgNoRispetto7a;
    private BigDecimal s9cFlgNoRispetto7b;
    private BigDecimal s9cFlgNoRispetto8d;
    private BigDecimal s9cFlgNoRispetto9a;

    public String getS8aNCircuito() {
        return s8aNCircuito;
    }

    public void setS8aNCircuito(String s8aNCircuito) {
        this.s8aNCircuito = s8aNCircuito;
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

    public BigDecimal getS9aFlgVerificaSuperata() {
        return s9aFlgVerificaSuperata;
    }

    public void setS9aFlgVerificaSuperata(BigDecimal s9aFlgVerificaSuperata) {
        this.s9aFlgVerificaSuperata = s9aFlgVerificaSuperata;
    }

    public BigDecimal getS9bFlgRispettoNormativa() {
        return s9bFlgRispettoNormativa;
    }

    public void setS9bFlgRispettoNormativa(BigDecimal s9bFlgRispettoNormativa) {
        this.s9bFlgRispettoNormativa = s9bFlgRispettoNormativa;
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
}
