package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class SigitTRappIspezGfDto {
	
	private SigitTRappIspezGfPk sigitTRappIspezGfPk;
	private BigDecimal s1cFlgReeInviato;
	private BigDecimal s1cFlgReeBollino;
	private String s1cSiglaBollino;
	private BigDecimal s1cNumBollino;
	private Date s1eDtPrimaInstallazione;
	private BigDecimal s1ePotTermicaMaxKw;
	private String s1lDenomDelegato;
	private BigDecimal s1lFlgDelega;
	private BigDecimal s2eFlgTrattH2oNonRich;
	private BigDecimal s3aFlgLocaleIntIdoneo;
	private BigDecimal s3bFlgLineeElettrIdonee;
	private BigDecimal s3cFlgVentilazAdeguate;
	private BigDecimal s3dFlgCoibentazioniIdonee;
	private BigDecimal s4aFlgLibImpPresente;
	private BigDecimal s4bFlgLibCompilato;
	private BigDecimal s4cFlgConformitaPresente;
	private BigDecimal s4dFlgLibUsoPresente;
	private BigDecimal s5aFlgSostituzMacchineReg;
	private BigDecimal s5aFlgSostituzSistemiReg;
	private BigDecimal s5aFlgIsolamReteDistrib;
	private BigDecimal s5aFlgIsolamCanaliDistrib;
	private BigDecimal s5bFlgNoIntervConv;
	private BigDecimal s5bFlgRelazDettaglio;
	private BigDecimal s5bFlgRelazDettaglioSucc;
	private BigDecimal s5bFlgValutazNonEseguita;
	private String s5bMotivoRelazNonEseg;
	private BigDecimal s5cFlgDimensCorretto;
	private BigDecimal s5cFlgDimensNonControll;
	private BigDecimal s5cFlgDimensRelazSucces;
	private Timestamp dataUltMod;
	private String utenteUltMod;
	private Date s1cDataRee;
	private BigDecimal s5cFlgDimensNonCorretto;
	private BigDecimal idAllegato;	
	private BigDecimal s2fFlgTrattClimaNonRich;
	
	
	
	public BigDecimal getS2fFlgTrattClimaNonRich() {
		return s2fFlgTrattClimaNonRich;
	}
	public void setS2fFlgTrattClimaNonRich(BigDecimal s2fFlgTrattClimaNonRich) {
		this.s2fFlgTrattClimaNonRich = s2fFlgTrattClimaNonRich;
	}
	public BigDecimal getIdAllegato() {
		return idAllegato;
	}
	public void setIdAllegato(BigDecimal idAllegato) {
		this.idAllegato = idAllegato;
	}
	public SigitTRappIspezGfPk getSigitTRappIspezGfPk() {
		return sigitTRappIspezGfPk;
	}
	public void setSigitTRappIspezGfPk(SigitTRappIspezGfPk sigitTRappIspezGfPk) {
		this.sigitTRappIspezGfPk = sigitTRappIspezGfPk;
	}
	public BigDecimal getS1cFlgReeInviato() {
		return s1cFlgReeInviato;
	}
	public void setS1cFlgReeInviato(BigDecimal s1cFlgReeInviato) {
		this.s1cFlgReeInviato = s1cFlgReeInviato;
	}
	public BigDecimal getS1cFlgReeBollino() {
		return s1cFlgReeBollino;
	}
	public void setS1cFlgReeBollino(BigDecimal s1cFlgReeBollino) {
		this.s1cFlgReeBollino = s1cFlgReeBollino;
	}
	public String getS1cSiglaBollino() {
		return s1cSiglaBollino;
	}
	public void setS1cSiglaBollino(String s1cSiglaBollino) {
		this.s1cSiglaBollino = s1cSiglaBollino;
	}
	public BigDecimal getS1cNumBollino() {
		return s1cNumBollino;
	}
	public void setS1cNumBollino(BigDecimal s1cNumBollino) {
		this.s1cNumBollino = s1cNumBollino;
	}
	public Date getS1eDtPrimaInstallazione() {
		return s1eDtPrimaInstallazione;
	}
	public void setS1eDtPrimaInstallazione(Date s1eDtPrimaInstallazione) {
		this.s1eDtPrimaInstallazione = s1eDtPrimaInstallazione;
	}
	public BigDecimal getS1ePotTermicaMaxKw() {
		return s1ePotTermicaMaxKw;
	}
	public void setS1ePotTermicaMaxKw(BigDecimal s1ePotTermicaMaxKw) {
		this.s1ePotTermicaMaxKw = s1ePotTermicaMaxKw;
	}
	public String getS1lDenomDelegato() {
		return s1lDenomDelegato;
	}
	public void setS1lDenomDelegato(String s1lDenomDelegato) {
		this.s1lDenomDelegato = s1lDenomDelegato;
	}
	public BigDecimal getS1lFlgDelega() {
		return s1lFlgDelega;
	}
	public void setS1lFlgDelega(BigDecimal s1lFlgDelega) {
		this.s1lFlgDelega = s1lFlgDelega;
	}
	public BigDecimal getS2eFlgTrattH2oNonRich() {
		return s2eFlgTrattH2oNonRich;
	}
	public void setS2eFlgTrattH2oNonRich(BigDecimal s2eFlgTrattH2oNonRich) {
		this.s2eFlgTrattH2oNonRich = s2eFlgTrattH2oNonRich;
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
	public BigDecimal getS3cFlgVentilazAdeguate() {
		return s3cFlgVentilazAdeguate;
	}
	public void setS3cFlgVentilazAdeguate(BigDecimal s3cFlgVentilazAdeguate) {
		this.s3cFlgVentilazAdeguate = s3cFlgVentilazAdeguate;
	}
	public BigDecimal getS3dFlgCoibentazioniIdonee() {
		return s3dFlgCoibentazioniIdonee;
	}
	public void setS3dFlgCoibentazioniIdonee(BigDecimal s3dFlgCoibentazioniIdonee) {
		this.s3dFlgCoibentazioniIdonee = s3dFlgCoibentazioniIdonee;
	}
	public BigDecimal getS4aFlgLibImpPresente() {
		return s4aFlgLibImpPresente;
	}
	public void setS4aFlgLibImpPresente(BigDecimal s4aFlgLibImpPresente) {
		this.s4aFlgLibImpPresente = s4aFlgLibImpPresente;
	}
	public BigDecimal getS4bFlgLibCompilato() {
		return s4bFlgLibCompilato;
	}
	public void setS4bFlgLibCompilato(BigDecimal s4bFlgLibCompilato) {
		this.s4bFlgLibCompilato = s4bFlgLibCompilato;
	}
	public BigDecimal getS4cFlgConformitaPresente() {
		return s4cFlgConformitaPresente;
	}
	public void setS4cFlgConformitaPresente(BigDecimal s4cFlgConformitaPresente) {
		this.s4cFlgConformitaPresente = s4cFlgConformitaPresente;
	}
	public BigDecimal getS4dFlgLibUsoPresente() {
		return s4dFlgLibUsoPresente;
	}
	public void setS4dFlgLibUsoPresente(BigDecimal s4dFlgLibUsoPresente) {
		this.s4dFlgLibUsoPresente = s4dFlgLibUsoPresente;
	}
	public BigDecimal getS5aFlgSostituzMacchineReg() {
		return s5aFlgSostituzMacchineReg;
	}
	public void setS5aFlgSostituzMacchineReg(BigDecimal s5aFlgSostituzMacchineReg) {
		this.s5aFlgSostituzMacchineReg = s5aFlgSostituzMacchineReg;
	}
	public BigDecimal getS5aFlgSostituzSistemiReg() {
		return s5aFlgSostituzSistemiReg;
	}
	public void setS5aFlgSostituzSistemiReg(BigDecimal s5aFlgSostituzSistemiReg) {
		this.s5aFlgSostituzSistemiReg = s5aFlgSostituzSistemiReg;
	}
	public BigDecimal getS5aFlgIsolamReteDistrib() {
		return s5aFlgIsolamReteDistrib;
	}
	public void setS5aFlgIsolamReteDistrib(BigDecimal s5aFlgIsolamReteDistrib) {
		this.s5aFlgIsolamReteDistrib = s5aFlgIsolamReteDistrib;
	}
	public BigDecimal getS5aFlgIsolamCanaliDistrib() {
		return s5aFlgIsolamCanaliDistrib;
	}
	public void setS5aFlgIsolamCanaliDistrib(BigDecimal s5aFlgIsolamCanaliDistrib) {
		this.s5aFlgIsolamCanaliDistrib = s5aFlgIsolamCanaliDistrib;
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
	public Date getS1cDataRee() {
		return s1cDataRee;
	}
	public void setS1cDataRee(Date s1cDataRee) {
		this.s1cDataRee = s1cDataRee;
	}
	public BigDecimal getS5cFlgDimensNonCorretto() {
		return s5cFlgDimensNonCorretto;
	}
	public void setS5cFlgDimensNonCorretto(BigDecimal s5cFlgDimensNonCorretto) {
		this.s5cFlgDimensNonCorretto = s5cFlgDimensNonCorretto;
	}
	@Override
	public String toString() {
		return "SigitTRappIspezGf [sigitTRappIspezGfPk=" + sigitTRappIspezGfPk + ", s1cFlgReeInviato=" + s1cFlgReeInviato
				+ ", s1cFlgReeBollino=" + s1cFlgReeBollino + ", s1cSiglaBollino=" + s1cSiglaBollino
				+ ", s1cNumBollino=" + s1cNumBollino + ", s1eBtPrimaInstallazione=" + s1eDtPrimaInstallazione
				+ ", s1ePotTermicaMaxKw=" + s1ePotTermicaMaxKw + ", s1lDenomDelegato=" + s1lDenomDelegato
				+ ", s1lFlgBelega=" + s1lFlgDelega + ", s2eFlgTrattH2oNonRich=" + s2eFlgTrattH2oNonRich
				+ ", s3aFlgLocaleIntIdoneo=" + s3aFlgLocaleIntIdoneo + ", s3bFlgLineeElettrIdonee="
				+ s3bFlgLineeElettrIdonee + ", s3cFlgVentilazAdeguate=" + s3cFlgVentilazAdeguate
				+ ", s3dFlgCoibentazioniIdonee=" + s3dFlgCoibentazioniIdonee + ", s4aFlgLibImpPresente="
				+ s4aFlgLibImpPresente + ", s4bFlgLibCompilato=" + s4bFlgLibCompilato
				+ ", s4cFlgConformitaPresente=" + s4cFlgConformitaPresente + ", s4dFlgLibUsoPresente="
				+ s4dFlgLibUsoPresente + ", s5aFlgSostituzMacchineReg=" + s5aFlgSostituzMacchineReg
				+ ", s5aFlgSostituzSistemiReg=" + s5aFlgSostituzSistemiReg + ", s5aFlgIsolamReteDistrib="
				+ s5aFlgIsolamReteDistrib + ", s5aFlgIsolamCanaliDistrib=" + s5aFlgIsolamCanaliDistrib
				+ ", s5bFlgNoIntervConv=" + s5bFlgNoIntervConv + ", s5bFlgRelazBettaglio="
				+ s5bFlgRelazDettaglio + ", s5bFlgRelazDettaglioSucc=" + s5bFlgRelazDettaglioSucc
				+ ", s5bFlgValutazNonEseguita=" + s5bFlgValutazNonEseguita + ", s5bMotivoRelazNonEseg="
				+ s5bMotivoRelazNonEseg + ", s5cFlgDimensCorretto=" + s5cFlgDimensCorretto
				+ ", s5cFlgDimensNonControll=" + s5cFlgDimensNonControll + ", s5cFlgDimensRelazSucces="
				+ s5cFlgDimensRelazSucces + ", dataUltMod=" + dataUltMod + ", utenteUltMod=" + utenteUltMod
				+ ", s1cDataRee=" + s1cDataRee + ", s5cFlgDimensNonCorretto=" + s5cFlgDimensNonCorretto
				+ "]";
	}
	
	

}
