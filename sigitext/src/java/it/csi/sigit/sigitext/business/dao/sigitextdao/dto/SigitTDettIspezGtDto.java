package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class SigitTDettIspezGtDto {

    private SigitTDettIspezGtPk sigitTDettIspezGtPk;
    private BigDecimal fkAllegato;
    private String fkTipoComponente;
    private BigDecimal progressivo;
    private BigDecimal codiceImpianto;
    private Date dataInstall;
    private String s8aNModuloTermico;
    private Timestamp dataUltMod;        
    private String utenteUltMod;
    private Timestamp controlloWeb;
    private String s9aFlgMonossidoCarb;       
    private String s9bFlgFumosita;        
    private BigDecimal s9cRendMinCombustPerc;
    private BigDecimal s8eRendCombPerc;
    private BigDecimal s9cFlgRendCombustSuff;   
    private BigDecimal s9dOssidiAzotoLimMgKwH;
    private BigDecimal s8eNoxMgKwH;
    private String s9dFlgOssidiAzoto;    
    private BigDecimal s9eFlgRispettoNormativa;
    private BigDecimal s9eFlgNoRispetto7a;
    private BigDecimal s9eFlgNoRispetto7b;
    private BigDecimal s9eFlgNoRispetto9a;
    private BigDecimal s9eFlgNoRispetto9b;
    private BigDecimal s9eFlgNoRispetto9c;
    private BigDecimal s9eFlgNoRispetto9d;
    private String s6dFlgEvacuFumi;
    private BigDecimal s6kBruciatoreDaKw;
    private BigDecimal s6kBruciatoreAKw;
    private BigDecimal s6lPortataCombM3H;    
    private String s6lPortataCombKgH;
    private BigDecimal s6iFlgTipoB;
    private BigDecimal s6iFlgTipoC;
    private String s6jFkClassDpr66096;        
    private BigDecimal s6kPotTermFocolKw;    
    private BigDecimal s6lPotTermFocolKw;
    private BigDecimal s7bFlgReePresente;
    private Date s7bDataRee;
    private BigDecimal s7bFlgOsservazioni;
    private BigDecimal s7bFlgRaccomand;
    private BigDecimal s7bFlgPrescr;
    private Date s7aDataUltimaManut;
    private Integer s7aFkFrequenzaManut;
    private String s7aFrequenzaManutAltro;
    private BigDecimal s7aFlgManutEffettuata;
    private BigDecimal s8bFumoMis1;
    private BigDecimal s8bFumoMis2;
    private BigDecimal s8bFumoMis3;
    private String s8cMarcaStrumMisura;
    private String s8cModelloStrumMisura;
    private String s8cMatricolaStrumMisura;
    private BigDecimal s8dTempFluidoMandataC;
    private BigDecimal s8eIndiceAria;
    private BigDecimal s8dTempAriaC;
    private BigDecimal s8eFumiSecchiNoAriaPpm;
    private BigDecimal s8dTempFumiC;
    private BigDecimal s8eQsPerc;
    private BigDecimal s8dO2Perc;          
    private BigDecimal s8eEtPerc;
    private BigDecimal s8dCo2Perc;
    private BigDecimal s8dCoFumiSecchiPpm;
    private BigDecimal s8dNoMgKwH;        
    private BigDecimal idDettIspezGt;        
    
	public BigDecimal getIdDettIspezGt() {
		return idDettIspezGt;
	}
	public void setIdDettIspezGt(BigDecimal idDettIspezGt) {
		this.idDettIspezGt = idDettIspezGt;
	}
	public BigDecimal getS8dNoMgKwH() {
		return s8dNoMgKwH;
	}
	public void setS8dNoMgKwH(BigDecimal s8dNoMgKwH) {
		this.s8dNoMgKwH = s8dNoMgKwH;
	}
	public BigDecimal getS8dCoFumiSecchiPpm() {
		return s8dCoFumiSecchiPpm;
	}
	public void setS8dCoFumiSecchiPpm(BigDecimal s8dCoFumiSecchiPpm) {
		this.s8dCoFumiSecchiPpm = s8dCoFumiSecchiPpm;
	}
	public BigDecimal getS8dCo2Perc() {
		return s8dCo2Perc;
	}
	public void setS8dCo2Perc(BigDecimal s8dCo2Perc) {
		this.s8dCo2Perc = s8dCo2Perc;
	}
	public BigDecimal getS8dTempFluidoMandataC() {
		return s8dTempFluidoMandataC;
	}
	public void setS8dTempFluidoMandataC(BigDecimal s8dTempFluidoMandataC) {
		this.s8dTempFluidoMandataC = s8dTempFluidoMandataC;
	}
	public BigDecimal getS8eIndiceAria() {
		return s8eIndiceAria;
	}
	public void setS8eIndiceAria(BigDecimal s8eIndiceAria) {
		this.s8eIndiceAria = s8eIndiceAria;
	}
	public BigDecimal getS8dTempAriaC() {
		return s8dTempAriaC;
	}
	public void setS8dTempAriaC(BigDecimal bigDecimal) {
		this.s8dTempAriaC = bigDecimal;
	}
	public BigDecimal getS8eFumiSecchiNoAriaPpm() {
		return s8eFumiSecchiNoAriaPpm;
	}
	public void setS8eFumiSecchiNoAriaPpm(BigDecimal s8eFumiSecchiNoAriaPpm) {
		this.s8eFumiSecchiNoAriaPpm = s8eFumiSecchiNoAriaPpm;
	}
	public BigDecimal getS8dTempFumiC() {
		return s8dTempFumiC;
	}
	public void setS8dTempFumiC(BigDecimal s8dTempFumiC) {
		this.s8dTempFumiC = s8dTempFumiC;
	}
	public BigDecimal getS8eQsPerc() {
		return s8eQsPerc;
	}
	public void setS8eQsPerc(BigDecimal s8eQsPerc) {
		this.s8eQsPerc = s8eQsPerc;
	}
	public BigDecimal getS8dO2Perc() {
		return s8dO2Perc;
	}
	public void setS8dO2Perc(BigDecimal s8dO2Perc) {
		this.s8dO2Perc = s8dO2Perc;
	}
	public BigDecimal getS8eEtPerc() {
		return s8eEtPerc;
	}
	public void setS8eEtPerc(BigDecimal s8eEtPerc) {
		this.s8eEtPerc = s8eEtPerc;
	}
	public BigDecimal getS8bFumoMis1() {
		return s8bFumoMis1;
	}
	public void setS8bFumoMis1(BigDecimal s8bFumoMis1) {
		this.s8bFumoMis1 = s8bFumoMis1;
	}
	public BigDecimal getS8bFumoMis2() {
		return s8bFumoMis2;
	}
	public void setS8bFumoMis2(BigDecimal s8bFumoMis2) {
		this.s8bFumoMis2 = s8bFumoMis2;
	}
	public BigDecimal getS8bFumoMis3() {
		return s8bFumoMis3;
	}
	public void setS8bFumoMis3(BigDecimal s8bFumoMis3) {
		this.s8bFumoMis3 = s8bFumoMis3;
	}
	public String getS8cMarcaStrumMisura() {
		return s8cMarcaStrumMisura;
	}
	public void setS8cMarcaStrumMisura(String s8cMarcaStrumMisura) {
		this.s8cMarcaStrumMisura = s8cMarcaStrumMisura;
	}
	public String getS8cModelloStrumMisura() {
		return s8cModelloStrumMisura;
	}
	public void setS8cModelloStrumMisura(String s8cModelloStrumMisura) {
		this.s8cModelloStrumMisura = s8cModelloStrumMisura;
	}
	public String getS8cMatricolaStrumMisura() {
		return s8cMatricolaStrumMisura;
	}
	public void setS8cMatricolaStrumMisura(String s8cMatricolaStrumMisura) {
		this.s8cMatricolaStrumMisura = s8cMatricolaStrumMisura;
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
	public BigDecimal getS7bFlgReePresente() {
		return s7bFlgReePresente;
	}
	public void setS7bFlgReePresente(BigDecimal s7bFlgReePresente) {
		this.s7bFlgReePresente = s7bFlgReePresente;
	}
	public Date getS7bDataRee() {
		return s7bDataRee;
	}
	public void setS7bDataRee(Date s7bDataRee) {
		this.s7bDataRee = s7bDataRee;
	}
	public BigDecimal getS7bFlgOsservazioni() {
		return s7bFlgOsservazioni;
	}
	public void setS7bFlgOsservazioni(BigDecimal s7bFlgOsservazioni) {
		this.s7bFlgOsservazioni = s7bFlgOsservazioni;
	}
	public BigDecimal getS7bFlgRaccomand() {
		return s7bFlgRaccomand;
	}
	public void setS7bFlgRaccomand(BigDecimal s7bFlgRaccomand) {
		this.s7bFlgRaccomand = s7bFlgRaccomand;
	}
	public BigDecimal getS7bFlgPrescr() {
		return s7bFlgPrescr;
	}
	public void setS7bFlgPrescr(BigDecimal s7bFlgPrescr) {
		this.s7bFlgPrescr = s7bFlgPrescr;
	}
	public BigDecimal getS6lPotTermFocolKw() {
		return s6lPotTermFocolKw;
	}
	public void setS6lPotTermFocolKw(BigDecimal s6lPotTermFocolKw) {
		this.s6lPotTermFocolKw = s6lPotTermFocolKw;
	}
	public BigDecimal getS6kPotTermFocolKw() {
		return s6kPotTermFocolKw;
	}
	public void setS6kPotTermFocolKw(BigDecimal s6kPotTermFocolKw) {
		this.s6kPotTermFocolKw = s6kPotTermFocolKw;
	}
	public BigDecimal getS6iFlgTipoB() {
		return s6iFlgTipoB;
	}
	public void setS6iFlgTipoB(BigDecimal s6iFlgTipoB) {
		this.s6iFlgTipoB = s6iFlgTipoB;
	}
	public BigDecimal getS6iFlgTipoC() {
		return s6iFlgTipoC;
	}
	public void setS6iFlgTipoC(BigDecimal s6iFlgTipoC) {
		this.s6iFlgTipoC = s6iFlgTipoC;
	}
	public String getS6jFkClassDpr66096() {
		return s6jFkClassDpr66096;
	}
	public void setS6jFkClassDpr66096(String s6jFkClassDpr66096) {
		this.s6jFkClassDpr66096 = s6jFkClassDpr66096;
	}
	public String getS6lPortataCombKgH() {
		return s6lPortataCombKgH;
	}
	public void setS6lPortataCombKgH(String s6lPortataCombKgH) {
		this.s6lPortataCombKgH = s6lPortataCombKgH;
	}
	public BigDecimal getS6lPortataCombM3H() {
		return s6lPortataCombM3H;
	}
	public void setS6lPortataCombM3H(BigDecimal s6lPortataCombM3H) {
		this.s6lPortataCombM3H = s6lPortataCombM3H;
	}
	public String getS6dFlgEvacuFumi() {
		return s6dFlgEvacuFumi;
	}
	public void setS6dFlgEvacuFumi(String s6dFlgEvacuFumi) {
		this.s6dFlgEvacuFumi = s6dFlgEvacuFumi;
	}
	public BigDecimal getS6kBruciatoreDaKw() {
		return s6kBruciatoreDaKw;
	}
	public void setS6kBruciatoreDaKw(BigDecimal s6kBruciatoreDaKw) {
		this.s6kBruciatoreDaKw = s6kBruciatoreDaKw;
	}
	public BigDecimal getS6kBruciatoreAKw() {
		return s6kBruciatoreAKw;
	}
	public void setS6kBruciatoreAKw(BigDecimal s6kBruciatoreAKw) {
		this.s6kBruciatoreAKw = s6kBruciatoreAKw;
	}
	public BigDecimal getS9eFlgRispettoNormativa() {
		return s9eFlgRispettoNormativa;
	}
	public void setS9eFlgRispettoNormativa(BigDecimal s9eFlgRispettoNormativa) {
		this.s9eFlgRispettoNormativa = s9eFlgRispettoNormativa;
	}
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
	public String getS9dFlgOssidiAzoto() {
		return s9dFlgOssidiAzoto;
	}
	public void setS9dFlgOssidiAzoto(String s9dFlgOssidiAzoto) {
		this.s9dFlgOssidiAzoto = s9dFlgOssidiAzoto;
	}
	public BigDecimal getS8eNoxMgKwH() {
		return s8eNoxMgKwH;
	}
	public void setS8eNoxMgKwH(BigDecimal s8eNoxMgKwH) {
		this.s8eNoxMgKwH = s8eNoxMgKwH;
	}
	public BigDecimal getS9dOssidiAzotoLimMgKwH() {
		return s9dOssidiAzotoLimMgKwH;
	}
	public void setS9dOssidiAzotoLimMgKwH(BigDecimal s9dOssidiAzotoLimMgKwH) {
		this.s9dOssidiAzotoLimMgKwH = s9dOssidiAzotoLimMgKwH;
	}
	public BigDecimal getS9cFlgRendCombustSuff() {
		return s9cFlgRendCombustSuff;
	}
	public void setS9cFlgRendCombustSuff(BigDecimal s9cFlgRendCombustSuff) {
		this.s9cFlgRendCombustSuff = s9cFlgRendCombustSuff;
	}
	public BigDecimal getS8eRendCombPerc() {
		return s8eRendCombPerc;
	}
	public void setS8eRendCombPerc(BigDecimal s8eRendCombPerc) {
		this.s8eRendCombPerc = s8eRendCombPerc;
	}
	public BigDecimal getS9cRendMinCombustPerc() {
		return s9cRendMinCombustPerc;
	}
	public void setS9cRendMinCombustPerc(BigDecimal s9cRendMinCombustPerc) {
		this.s9cRendMinCombustPerc = s9cRendMinCombustPerc;
	}
	public String getS9bFlgFumosita() {
		return s9bFlgFumosita;
	}
	public void setS9bFlgFumosita(String s9bFlgFumosita) {
		this.s9bFlgFumosita = s9bFlgFumosita;
	}
	public String getS9aFlgMonossidoCarb() {
		return s9aFlgMonossidoCarb;
	}
	public void setS9aFlgMonossidoCarb(String s9aFlgMonossidoCarb) {
		this.s9aFlgMonossidoCarb = s9aFlgMonossidoCarb;
	}
	public Timestamp getControlloWeb() {
		return controlloWeb;
	}
	public void setControlloWeb(Timestamp controlloWeb) {
		this.controlloWeb = controlloWeb;
	}
	public SigitTDettIspezGtPk getSigitTDettIspezGtPk() {
		return sigitTDettIspezGtPk;
	}
	public void setSigitTDettIspezGtPk(SigitTDettIspezGtPk sigitTDettIspezGtPk) {
		this.sigitTDettIspezGtPk = sigitTDettIspezGtPk;
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
	public String getS8aNModuloTermico() {
		return s8aNModuloTermico;
	}
	public void setS8aNModuloTermico(String s8aNModuloTermico) {
		this.s8aNModuloTermico = s8aNModuloTermico;
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
    
    
}
