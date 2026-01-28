package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class SigitTRappIspezGtDto {

	private SigitTRappIspezGtPk sigitTRappIspezGtPk;
	private Integer s1cFlgReeInviato;
	private Integer s1cFlgReeBollino;
	private String s1cSiglaBollino;
	private BigDecimal s1cNumBollino;
	private Date s1eDtPrimaInstallazione;
	private BigDecimal s1ePotFocolareKw;
	private BigDecimal s1ePotUtileKw;
	private String s1lDenomDelegato;
	private Integer s1lFlgDelega;
	private Integer s2b1FlgTermoContab;
	private Integer s2b2FlgUni10200;
	private Integer s2fFlgTrattClimaNonRich;
	private Integer s2fFlgTrattAcsNonRich;
	private Integer s3aFlgLocaleIntIdoneo;
	private Integer s3bFlgGenExtIdoneo;
	private Integer s3cFlgVentilazSuff;
	private Integer s3dFlgEvacFumiIdoneo;
	private Integer s3eFlgCartelliPresenti;
	private Integer s3fFlgEstinzPresenti;
	private Integer s3gFlgInterrGenPresenti;
	private Integer s3hFlgRubinPresente;
	private Integer s3iFlgAssenzaPerdComb;
	private Integer s3jFlgTempAmbFunz;
	private Integer s3kFlgDm1121975;
	private Integer s4aFlgLibImpPresente;
	private Integer s4bFlgLibCompilato;
	private Integer s4cFlgConformitaPresente;
	private Integer s4dFlgLibUsoPresente;
	private Integer s4eFlgPraticaVvfPresente;
	private Integer s4fFlgPraticaInailPresente;
	private Integer s4gFlgDm121975;
	private String s4gMatricolaDm1121975;
	private Integer s5aFlgAdozioneValvoleTerm;
	private Integer s5aFlgIsolamenteRete;
	private Integer s5aFlgAdozSistTrattam_h2o;
	private Integer s5aFlgSostituzSistRegolaz;
	private Integer s5bFlgNoIntervConv;
	private Integer s5bFlgRelazDettaglio;
	private Integer s5bFlgRelazDettaglioSucc;
	private Integer s5bFlgValutazNonEseguita;
	private String s5bMotivoRelazNonEseg;
	private Integer s5cFlgDimensCorretto;
	private Integer s5cFlgDimensNonControll;
	private Integer s5cFlgDimensRelazSucces;
	private Timestamp dataUltMod;
	private String utenteUltMod;
	private Date s1cDataRee;
	private Integer s5cFlgDimensNonCorretto;
	private Integer s5aFlgAdozSistTrattamH2o;
	
	public String getUtenteUltMod() {
		return utenteUltMod;
	}
	public void setUtenteUltMod(String utenteUltMod) {
		this.utenteUltMod = utenteUltMod;
	}
	public Integer getS5cFlgDimensRelazSucces() {
		return s5cFlgDimensRelazSucces;
	}
	public void setS5cFlgDimensRelazSucces(Integer s5cFlgDimensRelazSucces) {
		this.s5cFlgDimensRelazSucces = s5cFlgDimensRelazSucces;
	}
	public Integer getS5cFlgDimensNonCorretto() {
		return s5cFlgDimensNonCorretto;
	}
	public void setS5cFlgDimensNonCorretto(Integer s5cFlgDimensNonCorretto) {
		this.s5cFlgDimensNonCorretto = s5cFlgDimensNonCorretto;
	}
	public Integer getS5cFlgDimensNonControll() {
		return s5cFlgDimensNonControll;
	}
	public void setS5cFlgDimensNonControll(Integer s5cFlgDimensNonControll) {
		this.s5cFlgDimensNonControll = s5cFlgDimensNonControll;
	}
	public Integer getS5cFlgDimensCorretto() {
		return s5cFlgDimensCorretto;
	}
	public void setS5cFlgDimensCorretto(Integer s5cFlgDimensCorretto) {
		this.s5cFlgDimensCorretto = s5cFlgDimensCorretto;
	}
	public String getS5bMotivoRelazNonEseg() {
		return s5bMotivoRelazNonEseg;
	}
	public void setS5bMotivoRelazNonEseg(String s5bMotivoRelazNonEseg) {
		this.s5bMotivoRelazNonEseg = s5bMotivoRelazNonEseg;
	}
	public Integer getS5bFlgValutazNonEseguita() {
		return s5bFlgValutazNonEseguita;
	}
	public void setS5bFlgValutazNonEseguita(Integer s5bFlgValutazNonEseguita) {
		this.s5bFlgValutazNonEseguita = s5bFlgValutazNonEseguita;
	}
	public Integer getS5bFlgRelazDettaglioSucc() {
		return s5bFlgRelazDettaglioSucc;
	}
	public void setS5bFlgRelazDettaglioSucc(Integer s5bFlgRelazDettaglioSucc) {
		this.s5bFlgRelazDettaglioSucc = s5bFlgRelazDettaglioSucc;
	}
	public Integer getS5bFlgRelazDettaglio() {
		return s5bFlgRelazDettaglio;
	}
	public void setS5bFlgRelazDettaglio(Integer s5bFlgRelazDettaglio) {
		this.s5bFlgRelazDettaglio = s5bFlgRelazDettaglio;
	}
	public Integer getS5bFlgNoIntervConv() {
		return s5bFlgNoIntervConv;
	}
	public void setS5bFlgNoIntervConv(Integer s5bFlgNoIntervConv) {
		this.s5bFlgNoIntervConv = s5bFlgNoIntervConv;
	}
	public Integer getS5aFlgSostituzSistRegolaz() {
		return s5aFlgSostituzSistRegolaz;
	}
	public void setS5aFlgSostituzSistRegolaz(Integer s5aFlgSostituzSistRegolaz) {
		this.s5aFlgSostituzSistRegolaz = s5aFlgSostituzSistRegolaz;
	}
	public Integer getS5aFlgIsolamenteRete() {
		return s5aFlgIsolamenteRete;
	}
	public void setS5aFlgIsolamenteRete(Integer s5aFlgIsolamenteRete) {
		this.s5aFlgIsolamenteRete = s5aFlgIsolamenteRete;
	}
	public Integer getS5aFlgAdozioneValvoleTerm() {
		return s5aFlgAdozioneValvoleTerm;
	}
	public void setS5aFlgAdozioneValvoleTerm(Integer s5aFlgAdozioneValvoleTerm) {
		this.s5aFlgAdozioneValvoleTerm = s5aFlgAdozioneValvoleTerm;
	}
	public Integer getS5aFlgAdozSistTrattam_h2o() {
		return s5aFlgAdozSistTrattam_h2o;
	}
	public void setS5aFlgAdozSistTrattam_h2o(Integer s5aFlgAdozSistTrattam_h2o) {
		this.s5aFlgAdozSistTrattam_h2o = s5aFlgAdozSistTrattam_h2o;
	}
	public String getS4gMatricolaDm1121975() {
		return s4gMatricolaDm1121975;
	}
	public void setS4gMatricolaDm1121975(String s4gMatricolaDm1121975) {
		this.s4gMatricolaDm1121975 = s4gMatricolaDm1121975;
	}
	public Integer getS4fFlgPraticaInailPresente() {
		return s4fFlgPraticaInailPresente;
	}
	public void setS4fFlgPraticaInailPresente(Integer s4fFlgPraticaInailPresente) {
		this.s4fFlgPraticaInailPresente = s4fFlgPraticaInailPresente;
	}
	public Integer getS4eFlgPraticaVvfPresente() {
		return s4eFlgPraticaVvfPresente;
	}
	public void setS4eFlgPraticaVvfPresente(Integer s4eFlgPraticaVvfPresente) {
		this.s4eFlgPraticaVvfPresente = s4eFlgPraticaVvfPresente;
	}
	public Integer getS4dFlgLibUsoPresente() {
		return s4dFlgLibUsoPresente;
	}
	public void setS4dFlgLibUsoPresente(Integer s4dFlgLibUsoPresente) {
		this.s4dFlgLibUsoPresente = s4dFlgLibUsoPresente;
	}
	public Integer getS4cFlgConformitaPresente() {
		return s4cFlgConformitaPresente;
	}
	public void setS4cFlgConformitaPresente(Integer s4cFlgConformitaPresente) {
		this.s4cFlgConformitaPresente = s4cFlgConformitaPresente;
	}
	public Integer getS4bFlgLibCompilato() {
		return s4bFlgLibCompilato;
	}
	public void setS4bFlgLibCompilato(Integer s4bFlgLibCompilato) {
		this.s4bFlgLibCompilato = s4bFlgLibCompilato;
	}
	public Integer getS4aFlgLibImpPresente() {
		return s4aFlgLibImpPresente;
	}
	public void setS4aFlgLibImpPresente(Integer s4aFlgLibImpPresente) {
		this.s4aFlgLibImpPresente = s4aFlgLibImpPresente;
	}
	public Integer getS3kFlgDm1121975() {
		return s3kFlgDm1121975;
	}
	public void setS3kFlgDm1121975(Integer s3kFlgDm1121975) {
		this.s3kFlgDm1121975 = s3kFlgDm1121975;
	}
	public Integer getS3jFlgTempAmbFunz() {
		return s3jFlgTempAmbFunz;
	}
	public void setS3jFlgTempAmbFunz(Integer s3jFlgTempAmbFunz) {
		this.s3jFlgTempAmbFunz = s3jFlgTempAmbFunz;
	}
	public Integer getS3iFlgAssenzaPerdComb() {
		return s3iFlgAssenzaPerdComb;
	}
	public void setS3iFlgAssenzaPerdComb(Integer s3iFlgAssenzaPerdComb) {
		this.s3iFlgAssenzaPerdComb = s3iFlgAssenzaPerdComb;
	}
	public Integer getS3hFlgRubinPresente() {
		return s3hFlgRubinPresente;
	}
	public void setS3hFlgRubinPresente(Integer s3hFlgRubinPresente) {
		this.s3hFlgRubinPresente = s3hFlgRubinPresente;
	}
	public Integer getS3gFlgInterrGenPresenti() {
		return s3gFlgInterrGenPresenti;
	}
	public void setS3gFlgInterrGenPresenti(Integer s3gFlgInterrGenPresenti) {
		this.s3gFlgInterrGenPresenti = s3gFlgInterrGenPresenti;
	}
	public Integer getS3fFlgEstinzPresenti() {
		return s3fFlgEstinzPresenti;
	}
	public void setS3fFlgEstinzPresenti(Integer s3fFlgEstinzPresenti) {
		this.s3fFlgEstinzPresenti = s3fFlgEstinzPresenti;
	}
	public Integer getS3eFlgCartelliPresenti() {
		return s3eFlgCartelliPresenti;
	}
	public void setS3eFlgCartelliPresenti(Integer s3eFlgCartelliPresenti) {
		this.s3eFlgCartelliPresenti = s3eFlgCartelliPresenti;
	}
	public Integer getS3dFlgEvacFumiIdoneo() {
		return s3dFlgEvacFumiIdoneo;
	}
	public void setS3dFlgEvacFumiIdoneo(Integer s3dFlgEvacFumiIdoneo) {
		this.s3dFlgEvacFumiIdoneo = s3dFlgEvacFumiIdoneo;
	}
	public Integer getS3cFlgVentilazSuff() {
		return s3cFlgVentilazSuff;
	}
	public void setS3cFlgVentilazSuff(Integer s3cFlgVentilazSuff) {
		this.s3cFlgVentilazSuff = s3cFlgVentilazSuff;
	}
	public Integer getS3bFlgGenExtIdoneo() {
		return s3bFlgGenExtIdoneo;
	}
	public void setS3bFlgGenExtIdoneo(Integer s3bFlgGenExtIdoneo) {
		this.s3bFlgGenExtIdoneo = s3bFlgGenExtIdoneo;
	}
	public Integer getS3aFlgLocaleIntIdoneo() {
		return s3aFlgLocaleIntIdoneo;
	}
	public void setS3aFlgLocaleIntIdoneo(Integer s3aFlgLocaleIntIdoneo) {
		this.s3aFlgLocaleIntIdoneo = s3aFlgLocaleIntIdoneo;
	}
	public Integer getS2fFlgTrattClimaNonRich() {
		return s2fFlgTrattClimaNonRich;
	}
	public void setS2fFlgTrattClimaNonRich(Integer s2fFlgTrattClimaNonRich) {
		this.s2fFlgTrattClimaNonRich = s2fFlgTrattClimaNonRich;
	}
	public Integer getS2fFlgTrattAcsNonRich() {
		return s2fFlgTrattAcsNonRich;
	}
	public void setS2fFlgTrattAcsNonRich(Integer s2fFlgTrattAcsNonRich) {
		this.s2fFlgTrattAcsNonRich = s2fFlgTrattAcsNonRich;
	}
	public Integer getS2b2FlgUni10200() {
		return s2b2FlgUni10200;
	}
	public void setS2b2FlgUni10200(Integer s2b2FlgUni10200) {
		this.s2b2FlgUni10200 = s2b2FlgUni10200;
	}
	public Integer getS2b1FlgTermoContab() {
		return s2b1FlgTermoContab;
	}
	public void setS2b1FlgTermoContab(Integer s2b1FlgTermoContab) {
		this.s2b1FlgTermoContab = s2b1FlgTermoContab;
	}
	public Integer getS1lFlgDelega() {
		return s1lFlgDelega;
	}
	public void setS1lFlgDelega(Integer s1lFlgDelega) {
		this.s1lFlgDelega = s1lFlgDelega;
	}
	public String getS1lDenomDelegato() {
		return s1lDenomDelegato;
	}
	public void setS1lDenomDelegato(String s1lDenomDelegato) {
		this.s1lDenomDelegato = s1lDenomDelegato;
	}
	public BigDecimal getS1ePotUtileKw() {
		return s1ePotUtileKw;
	}
	public void setS1ePotUtileKw(BigDecimal s1ePotUtileKw) {
		this.s1ePotUtileKw = s1ePotUtileKw;
	}
	public BigDecimal getS1ePotFocolareKw() {
		return s1ePotFocolareKw;
	}
	public void setS1ePotFocolareKw(BigDecimal s1ePotFocolareKw) {
		this.s1ePotFocolareKw = s1ePotFocolareKw;
	}
	public Date getS1eDtPrimaInstallazione() {
		return s1eDtPrimaInstallazione;
	}
	public void setS1eDtPrimaInstallazione(Date s1eDtPrimaInstallazione) {
		this.s1eDtPrimaInstallazione = s1eDtPrimaInstallazione;
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
	public Integer getS1cFlgReeInviato() {
		return s1cFlgReeInviato;
	}
	public void setS1cFlgReeInviato(Integer s1cFlgReeInviato) {
		this.s1cFlgReeInviato = s1cFlgReeInviato;
	}
	public Integer getS1cFlgReeBollino() {
		return s1cFlgReeBollino;
	}
	public void setS1cFlgReeBollino(Integer s1cFlgReeBollino) {
		this.s1cFlgReeBollino = s1cFlgReeBollino;
	}
	public Date getS1cDataRee() {
		return s1cDataRee;
	}
	public void setS1cDataRee(Date s1cDataRee) {
		this.s1cDataRee = s1cDataRee;
	}
			
	public Integer getS4gFlgDm121975() {
		return s4gFlgDm121975;
	}
	public void setS4gFlgDm121975(Integer s4gFlgDm121975) {
		this.s4gFlgDm121975 = s4gFlgDm121975;
	}
	public SigitTRappIspezGtPk getSigitTRappIspezGtPk() {
		return sigitTRappIspezGtPk;
	}
	public void setSigitTRappIspezGtPk(SigitTRappIspezGtPk sigitTRappIspezGtPk) {
		this.sigitTRappIspezGtPk = sigitTRappIspezGtPk;
	}
	public Timestamp getDataUltMod() {
		return dataUltMod;
	}
	public void setDataUltMod(Timestamp dataUltMod) {
		this.dataUltMod = dataUltMod;
	}
	
	public Integer getS5aFlgAdozSistTrattamH2o() {
		return s5aFlgAdozSistTrattamH2o;
	}
	public void setS5aFlgAdozSistTrattamH2o(Integer s5aFlgAdozSistTrattamH2o) {
		this.s5aFlgAdozSistTrattamH2o = s5aFlgAdozSistTrattamH2o;
	}
	@Override
	public String toString() {
		return "SigitTRappIspezGtDto [sigitTRappIspezGtPk=" + sigitTRappIspezGtPk + ", s1cFlgReeInviato="
				+ s1cFlgReeInviato + ", s1cFlgReeBollino=" + s1cFlgReeBollino + ", s1cSiglaBollino=" + s1cSiglaBollino
				+ ", s1cNumBollino=" + s1cNumBollino + ", s1eDtPrimaInstallazione=" + s1eDtPrimaInstallazione
				+ ", s1ePotFocolareKw=" + s1ePotFocolareKw + ", s1ePotUtileKw=" + s1ePotUtileKw + ", s1lDenomDelegato="
				+ s1lDenomDelegato + ", s1lFlgDelega=" + s1lFlgDelega + ", s2b1FlgTermoContab=" + s2b1FlgTermoContab
				+ ", s2b2FlgUni10200=" + s2b2FlgUni10200 + ", s2fFlgTrattClimaNonRich=" + s2fFlgTrattClimaNonRich
				+ ", s2fFlgTrattAcsNonRich=" + s2fFlgTrattAcsNonRich + ", s3aFlgLocaleIntIdoneo="
				+ s3aFlgLocaleIntIdoneo + ", s3bFlgGenExtIdoneo=" + s3bFlgGenExtIdoneo + ", s3cFlgVentilazSuff="
				+ s3cFlgVentilazSuff + ", s3dFlgEvacFumiIdoneo=" + s3dFlgEvacFumiIdoneo + ", s3eFlgCartelliPresenti="
				+ s3eFlgCartelliPresenti + ", s3fFlgEstinzPresenti=" + s3fFlgEstinzPresenti
				+ ", s3gFlgInterrGenPresenti=" + s3gFlgInterrGenPresenti + ", s3hFlgRubinPresente="
				+ s3hFlgRubinPresente + ", s3iFlgAssenzaPerdComb=" + s3iFlgAssenzaPerdComb + ", s3jFlgTempAmbFunz="
				+ s3jFlgTempAmbFunz + ", s3kFlgDm1121975=" + s3kFlgDm1121975 + ", s4aFlgLibImpPresente="
				+ s4aFlgLibImpPresente + ", s4bFlgLibCompilato=" + s4bFlgLibCompilato + ", s4cFlgConformitaPresente="
				+ s4cFlgConformitaPresente + ", s4dFlgLibUsoPresente=" + s4dFlgLibUsoPresente
				+ ", s4eFlgPraticaVvfPresente=" + s4eFlgPraticaVvfPresente + ", s4fFlgPraticaInailPresente="
				+ s4fFlgPraticaInailPresente + ", s4gFlgDm121975=" + s4gFlgDm121975 + ", s4gMatricolaDm1121975="
				+ s4gMatricolaDm1121975 + ", s5aFlgAdozioneValvoleTerm=" + s5aFlgAdozioneValvoleTerm
				+ ", s5aFlgIsolamenteRete=" + s5aFlgIsolamenteRete + ", s5aFlgAdozSistTrattam_h2o="
				+ s5aFlgAdozSistTrattam_h2o + ", s5aFlgSostituzSistRegolaz=" + s5aFlgSostituzSistRegolaz
				+ ", s5bFlgNoIntervConv=" + s5bFlgNoIntervConv + ", s5bFlgRelazDettaglio=" + s5bFlgRelazDettaglio
				+ ", s5bFlgRelazDettaglioSucc=" + s5bFlgRelazDettaglioSucc + ", s5bFlgValutazNonEseguita="
				+ s5bFlgValutazNonEseguita + ", s5bMotivoRelazNonEseg=" + s5bMotivoRelazNonEseg
				+ ", s5cFlgDimensCorretto=" + s5cFlgDimensCorretto + ", s5cFlgDimensNonControll="
				+ s5cFlgDimensNonControll + ", s5cFlgDimensRelazSucces=" + s5cFlgDimensRelazSucces + ", dataUltMod="
				+ dataUltMod + ", utenteUltMod=" + utenteUltMod + ", s1cDataRee=" + s1cDataRee
				+ ", s5cFlgDimensNonCorretto=" + s5cFlgDimensNonCorretto + ", s5aFlgAdozSistTrattamH2o="
				+ s5aFlgAdozSistTrattamH2o + "]";
	}
	
	
	
		
}
