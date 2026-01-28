package it.csi.citpwa.model.sigitext;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DatiRapProvaWebGf implements Serializable {

    private static final long serialVersionUID = 2432633587077761276L;

    private BigDecimal s1cFlgReeInviato;
    private BigDecimal s5aFlgIsolamCanaliDistrib;
    private BigDecimal s5aFlgIsolamReteDistrib;
    private BigDecimal s2eFlgTrattH2oNonRich;
    private BigDecimal s3dFlgCoibentazioniIdonee;
    private BigDecimal s3aFlgLocaleIntIdoneo;
    private BigDecimal s3bFlgLineeElettrIdonee;
    private BigDecimal s4dFlgLibUsoPresente;
    private BigDecimal s3cFlgVentilazAdeguate;
    private BigDecimal s5aFlgSostituzSistemiReg;
    private BigDecimal s5aFlgSostituzMacchineReg;
    private BigDecimal s4aFlgLibImpPresente;
    private BigDecimal s4cFlgConformitaPresente;
    private BigDecimal s4bFlgLibCompilato;
    private BigDecimal s1lFlgDelega;
    private String s1cSiglaBollino;
    private String s1lDenomDelegato;
    private BigDecimal s1ePotTermicaMaxKw;
    private Long s1eDtPrimaInstallazione;
    private Long s1cDataRee;
    private BigDecimal s1cNumBollino;
    private BigDecimal s1cFlgReeBollino;
    private String s1cSiglaBollino2;
    private String s1cSiglaBollino3;
    private String s1cFlgSiglaBollino;
    private BigDecimal s5bFlgNoIntervConv;
    private BigDecimal s5bFlgRelazDettaglio;
    private BigDecimal s5bFlgRelazDettaglioSucc;
    private BigDecimal s5bFlgValutazNonEseguita;
    private String s5bMotivoRelazNonEseg;
    private BigDecimal s5cFlgDimensCorretto;
    private BigDecimal s5cFlgDimensNonCorretto;
    private BigDecimal s5cFlgDimensNonControll;
    private BigDecimal s5cFlgDimensRelazSucces;
    private String fOsservazioni;
    private String fRaccomandazioni;
    private String fPrescrizioni;
    private Integer idDettIspezGf;
    private String fkTipoComponente;
    private Integer progressivo;
    private Integer codiceImpianto;
    private Long dataInstall;

    private BigDecimal s6hFlgInverter;
    private BigDecimal s6nFlgFugaDiretta;
    private BigDecimal s6nFlgFugaIndiretta;

    private Integer s7aFkFrequenzaManut;
    private String s7aFrequenzaManutaltro;
    private BigDecimal s7aFlgManutEffettuata;
    private Long s7aDataUltimaManut;
    private BigDecimal s7bFlgRegistroApparecc;
    private BigDecimal s7cFlgReePresente;
    private Long s7cDataRee;
    private BigDecimal s7cFlgOsservazioni;
    private BigDecimal s7cFlgRaccomand;
    private BigDecimal s7cFlgPrescr;

    private List<Circuito> circuiti = new ArrayList<>();

    public Integer getIdDettIspezGf() {
        return idDettIspezGf;
    }

    public void setIdDettIspezGf(Integer idDettIspezGf) {
        this.idDettIspezGf = idDettIspezGf;
    }

    public String getFkTipoComponente() {
        return fkTipoComponente;
    }

    public void setFkTipoComponente(String fkTipoComponente) {
        this.fkTipoComponente = fkTipoComponente;
    }

    public Integer getProgressivo() {
        return progressivo;
    }

    public void setProgressivo(Integer progressivo) {
        this.progressivo = progressivo;
    }

    public Integer getCodiceImpianto() {
        return codiceImpianto;
    }

    public void setCodiceImpianto(Integer codiceImpianto) {
        this.codiceImpianto = codiceImpianto;
    }

    public Long getDataInstall() {
        return dataInstall;
    }

    public void setDataInstall(Long dataInstall) {
        this.dataInstall = dataInstall;
    }

    public List<Circuito> getCircuiti() {
        return circuiti;
    }

    public void setCircuiti(List<Circuito> circuiti) {
        this.circuiti = circuiti;
    }

    public Integer getS7aFkFrequenzaManut() {
        return s7aFkFrequenzaManut;
    }
    public void setS7aFkFrequenzaManut(Integer s7aFkFrequenzaManut) {
        this.s7aFkFrequenzaManut = s7aFkFrequenzaManut;
    }
    public String getS7aFrequenzaManutaltro() {
        return s7aFrequenzaManutaltro;
    }
    public void setS7aFrequenzaManutaltro(String s7aFrequenzaManutaltro) {
        this.s7aFrequenzaManutaltro = s7aFrequenzaManutaltro;
    }
    public BigDecimal getS7aFlgManutEffettuata() {
        return s7aFlgManutEffettuata;
    }
    public void setS7aFlgManutEffettuata(BigDecimal s7aFlgManutEffettuata) {
        this.s7aFlgManutEffettuata = s7aFlgManutEffettuata;
    }
    public Long getS7aDataUltimaManut() {
        return s7aDataUltimaManut;
    }
    public void setS7aDataUltimaManut(Long s7aDataUltimaManut) {
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
    public Long getS7cDataRee() {
        return s7cDataRee;
    }
    public void setS7cDataRee(Long s7cDataRee) {
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
    public String getS1cFlgSiglaBollino() {
        return s1cFlgSiglaBollino;
    }
    public void setS1cFlgSiglaBollino(String s1cFlgSiglaBollino) {
        this.s1cFlgSiglaBollino = s1cFlgSiglaBollino;
    }
    public String getS1cSiglaBollino3() {
        return s1cSiglaBollino3;
    }
    public void setS1cSiglaBollino3(String s1cSiglaBollino3) {
        this.s1cSiglaBollino3 = s1cSiglaBollino3;
    }
    public BigDecimal getS1cFlgReeInviato() {
        return s1cFlgReeInviato;
    }
    public void setS1cFlgReeInviato(BigDecimal s1cFlgReeInviato) {
        this.s1cFlgReeInviato = s1cFlgReeInviato;
    }
    public BigDecimal getS5aFlgIsolamCanaliDistrib() {
        return s5aFlgIsolamCanaliDistrib;
    }
    public void setS5aFlgIsolamCanaliDistrib(BigDecimal s5aFlgIsolamCanaliDistrib) {
        this.s5aFlgIsolamCanaliDistrib = s5aFlgIsolamCanaliDistrib;
    }
    public BigDecimal getS5aFlgIsolamReteDistrib() {
        return s5aFlgIsolamReteDistrib;
    }
    public void setS5aFlgIsolamReteDistrib(BigDecimal s5aFlgIsolamReteDistrib) {
        this.s5aFlgIsolamReteDistrib = s5aFlgIsolamReteDistrib;
    }
    public BigDecimal getS2eFlgTrattH2oNonRich() {
        return s2eFlgTrattH2oNonRich;
    }
    public void setS2eFlgTrattH2oNonRich(BigDecimal s2eFlgTrattH2oNonRich) {
        this.s2eFlgTrattH2oNonRich = s2eFlgTrattH2oNonRich;
    }
    public BigDecimal getS3dFlgCoibentazioniIdonee() {
        return s3dFlgCoibentazioniIdonee;
    }
    public void setS3dFlgCoibentazioniIdonee(BigDecimal s3dFlgCoibentazioniIdonee) {
        this.s3dFlgCoibentazioniIdonee = s3dFlgCoibentazioniIdonee;
    }
    public BigDecimal getS3aFlgLocaleIntIdoneo() {
        return s3aFlgLocaleIntIdoneo;
    }
    public void setS3aFlgLocaleIntIdoneo(BigDecimal s3aFlgLocaleIntIdoneo) {
        this.s3aFlgLocaleIntIdoneo = s3aFlgLocaleIntIdoneo;
    }
    public BigDecimal getS3bFlgLineeElettrIdonee() {
        return s3bFlgLineeElettrIdonee;
    }
    public void setS3bFlgLineeElettrIdonee(BigDecimal s3bFlgLineeElettrIdonee) {
        this.s3bFlgLineeElettrIdonee = s3bFlgLineeElettrIdonee;
    }
    public BigDecimal getS4dFlgLibUsoPresente() {
        return s4dFlgLibUsoPresente;
    }
    public void setS4dFlgLibUsoPresente(BigDecimal s4dFlgLibUsoPresente) {
        this.s4dFlgLibUsoPresente = s4dFlgLibUsoPresente;
    }
    public BigDecimal getS3cFlgVentilazAdeguate() {
        return s3cFlgVentilazAdeguate;
    }
    public void setS3cFlgVentilazAdeguate(BigDecimal s3cFlgVentilazAdeguate) {
        this.s3cFlgVentilazAdeguate = s3cFlgVentilazAdeguate;
    }
    public BigDecimal getS5aFlgSostituzSistemiReg() {
        return s5aFlgSostituzSistemiReg;
    }
    public void setS5aFlgSostituzSistemiReg(BigDecimal s5aFlgSostituzSistemiReg) {
        this.s5aFlgSostituzSistemiReg = s5aFlgSostituzSistemiReg;
    }
    public BigDecimal getS5aFlgSostituzMacchineReg() {
        return s5aFlgSostituzMacchineReg;
    }
    public void setS5aFlgSostituzMacchineReg(BigDecimal s5aFlgSostituzMacchineReg) {
        this.s5aFlgSostituzMacchineReg = s5aFlgSostituzMacchineReg;
    }
    public BigDecimal getS4aFlgLibImpPresente() {
        return s4aFlgLibImpPresente;
    }
    public void setS4aFlgLibImpPresente(BigDecimal s4aFlgLibImpPresente) {
        this.s4aFlgLibImpPresente = s4aFlgLibImpPresente;
    }
    public BigDecimal getS4cFlgConformitaPresente() {
        return s4cFlgConformitaPresente;
    }
    public void setS4cFlgConformitaPresente(BigDecimal s4cFlgConformitaPresente) {
        this.s4cFlgConformitaPresente = s4cFlgConformitaPresente;
    }
    public BigDecimal getS4bFlgLibCompilato() {
        return s4bFlgLibCompilato;
    }
    public void setS4bFlgLibCompilato(BigDecimal s4bFlgLibCompilato) {
        this.s4bFlgLibCompilato = s4bFlgLibCompilato;
    }
    public BigDecimal getS1lFlgDelega() {
        return s1lFlgDelega;
    }
    public void setS1lFlgDelega(BigDecimal s1lFlgDelega) {
        this.s1lFlgDelega = s1lFlgDelega;
    }
    public String getS1cSiglaBollino() {
        return s1cSiglaBollino;
    }
    public void setS1cSiglaBollino(String s1cSiglaBollino) {
        this.s1cSiglaBollino = s1cSiglaBollino;
    }
    public String getS1lDenomDelegato() {
        return s1lDenomDelegato;
    }
    public void setS1lDenomDelegato(String s1lDenomDelegato) {
        this.s1lDenomDelegato = s1lDenomDelegato;
    }
    public BigDecimal getS1ePotTermicaMaxKw() {
        return s1ePotTermicaMaxKw;
    }
    public void setS1ePotTermicaMaxKw(BigDecimal s1ePotTermicaMaxKw) {
        this.s1ePotTermicaMaxKw = s1ePotTermicaMaxKw;
    }
    public Long getS1eDtPrimaInstallazione() {
        return s1eDtPrimaInstallazione;
    }
    public void setS1eDtPrimaInstallazione(Long s1eDtPrimaInstallazione) {
        this.s1eDtPrimaInstallazione = s1eDtPrimaInstallazione;
    }
    public Long getS1cDataRee() {
        return s1cDataRee;
    }
    public void setS1cDataRee(Long s1cDataRee) {
        this.s1cDataRee = s1cDataRee;
    }
    public BigDecimal getS1cNumBollino() {
        return s1cNumBollino;
    }
    public void setS1cNumBollino(BigDecimal s1cNumBollino) {
        this.s1cNumBollino = s1cNumBollino;
    }
    public BigDecimal getS1cFlgReeBollino() {
        return s1cFlgReeBollino;
    }
    public void setS1cFlgReeBollino(BigDecimal s1cFlgReeBollino) {
        this.s1cFlgReeBollino = s1cFlgReeBollino;
    }
    public String getS1cSiglaBollino2() {
        return s1cSiglaBollino2;
    }
    public void setS1cSiglaBollino2(String s1cSiglaBollino2) {
        this.s1cSiglaBollino2 = s1cSiglaBollino2;
    }
    public BigDecimal getS5bFlgNoIntervConv() {
        return s5bFlgNoIntervConv;
    }
    public void setS5bFlgNoIntervConv(BigDecimal s5bFlgNoIntervConv) {
        this.s5bFlgNoIntervConv = s5bFlgNoIntervConv;
    }
    public BigDecimal getS5bFlgRelazDettaglio() {
        return s5bFlgRelazDettaglio;
    }
    public void setS5bFlgRelazDettaglio(BigDecimal s5bFlgRelazDettaglio) {
        this.s5bFlgRelazDettaglio = s5bFlgRelazDettaglio;
    }
    public BigDecimal getS5bFlgRelazDettaglioSucc() {
        return s5bFlgRelazDettaglioSucc;
    }
    public void setS5bFlgRelazDettaglioSucc(BigDecimal s5bFlgRelazDettaglioSucc) {
        this.s5bFlgRelazDettaglioSucc = s5bFlgRelazDettaglioSucc;
    }
    public BigDecimal getS5bFlgValutazNonEseguita() {
        return s5bFlgValutazNonEseguita;
    }
    public void setS5bFlgValutazNonEseguita(BigDecimal s5bFlgValutazNonEseguita) {
        this.s5bFlgValutazNonEseguita = s5bFlgValutazNonEseguita;
    }
    public String getS5bMotivoRelazNonEseg() {
        return s5bMotivoRelazNonEseg;
    }
    public void setS5bMotivoRelazNonEseg(String s5bMotivoRelazNonEseg) {
        this.s5bMotivoRelazNonEseg = s5bMotivoRelazNonEseg;
    }
    public BigDecimal getS5cFlgDimensCorretto() {
        return s5cFlgDimensCorretto;
    }
    public void setS5cFlgDimensCorretto(BigDecimal s5cFlgDimensCorretto) {
        this.s5cFlgDimensCorretto = s5cFlgDimensCorretto;
    }
    public BigDecimal getS5cFlgDimensNonCorretto() {
        return s5cFlgDimensNonCorretto;
    }
    public void setS5cFlgDimensNonCorretto(BigDecimal s5cFlgDimensNonCorretto) {
        this.s5cFlgDimensNonCorretto = s5cFlgDimensNonCorretto;
    }
    public BigDecimal getS5cFlgDimensNonControll() {
        return s5cFlgDimensNonControll;
    }
    public void setS5cFlgDimensNonControll(BigDecimal s5cFlgDimensNonControll) {
        this.s5cFlgDimensNonControll = s5cFlgDimensNonControll;
    }
    public BigDecimal getS5cFlgDimensRelazSucces() {
        return s5cFlgDimensRelazSucces;
    }
    public void setS5cFlgDimensRelazSucces(BigDecimal s5cFlgDimensRelazSucces) {
        this.s5cFlgDimensRelazSucces = s5cFlgDimensRelazSucces;
    }
    public String getfOsservazioni() {
        return fOsservazioni;
    }
    public void setfOsservazioni(String fOsservazioni) {
        this.fOsservazioni = fOsservazioni;
    }
    public String getfRaccomandazioni() {
        return fRaccomandazioni;
    }
    public void setfRaccomandazioni(String fRaccomandazioni) {
        this.fRaccomandazioni = fRaccomandazioni;
    }
    public String getfPrescrizioni() {
        return fPrescrizioni;
    }
    public void setfPrescrizioni(String fPrescrizioni) {
        this.fPrescrizioni = fPrescrizioni;
    }
}
