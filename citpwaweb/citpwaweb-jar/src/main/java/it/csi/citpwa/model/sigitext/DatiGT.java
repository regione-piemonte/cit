package it.csi.citpwa.model.sigitext;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class DatiGT {
	private String idTipoComponente;
	private Integer progressivo;
	private Date dataInstall;
	private Integer codiceImpianto;
	private Integer fkFluido;
	private Integer fkDettaglioGt;
	private BigDecimal rendimentoPerc;
	private Integer nModuli;
	private Date dataDismiss;
	private Integer flgDismissione;
	private Date dataUltMod;
	private String utenteUltMod;
	private Integer fkMarca;
	private Integer fkCombustibile;
	private String matricola;
	private String modello;
	private BigDecimal potenzaTermicaKw;
	private String note;
	private Integer tempoManutAnni;
	private Integer mediImpOreOperative;
	private Integer idTipocannaFumaria;
	private Date dataMinimaControllo;
	private Date dataMassimaControllo;

	protected String descMarca;
	protected String descFluido;
	protected String descDettaglioGt;
	protected String descCombustibile;

	private String cf;

	private String siglaRea;

	private String numeroRea;

	private String desFluido;
	private String desMarca;
	private String desDettaglioGt;

	public DatiGT() {
		//Not implemented
	}

	public String getIdTipoComponente() {
		return idTipoComponente;
	}

	public void setIdTipoComponente(String idTipoComponente) {
		this.idTipoComponente = idTipoComponente;
	}

	public Integer getProgressivo() {
		return progressivo;
	}

	public void setProgressivo(Integer progressivo) {
		this.progressivo = progressivo;
	}

	public Date getDataInstall() {
		return dataInstall;
	}

	public void setDataInstall(Date dataInstall) {
		this.dataInstall = dataInstall;
	}

	public Integer getCodiceImpianto() {
		return codiceImpianto;
	}

	public void setCodiceImpianto(Integer codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}

	public Integer getFkFluido() {
		return fkFluido;
	}

	public void setFkFluido(Integer fkFluido) {
		this.fkFluido = fkFluido;
	}

	public String getDescMarca() {
		return descMarca;
	}

	public void setDescMarca(String descMarca) {
		this.descMarca = descMarca;
	}

	public String getDescFluido() {
		return descFluido;
	}

	public void setDescFluido(String descFluido) {
		this.descFluido = descFluido;
	}

	public String getDescDettaglioGt() {
		return descDettaglioGt;
	}

	public void setDescDettaglioGt(String descDettaglioGt) {
		this.descDettaglioGt = descDettaglioGt;
	}

	public String getDescCombustibile() {
		return descCombustibile;
	}

	public void setDescCombustibile(String descCombustibile) {
		this.descCombustibile = descCombustibile;
	}

	public Integer getFkDettaglioGt() {
		return fkDettaglioGt;
	}

	public void setFkDettaglioGt(Integer fkDettaglioGt) {
		this.fkDettaglioGt = fkDettaglioGt;
	}

	public BigDecimal getRendimentoPerc() {
		return rendimentoPerc;
	}

	public void setRendimentoPerc(BigDecimal rendimentoPerc) {
		this.rendimentoPerc = rendimentoPerc;
	}

	public Integer getnModuli() {
		return nModuli;
	}

	public void setnModuli(Integer nModuli) {
		this.nModuli = nModuli;
	}

	public Date getDataDismiss() {
		return dataDismiss;
	}

	public void setDataDismiss(Date dataDismiss) {
		this.dataDismiss = dataDismiss;
	}

	public Integer getFlgDismissione() {
		return flgDismissione;
	}

	public void setFlgDismissione(Integer flgDismissione) {
		this.flgDismissione = flgDismissione;
	}

	public Date getDataUltMod() {
		return dataUltMod;
	}

	public void setDataUltMod(Date dataUltMod) {
		this.dataUltMod = dataUltMod;
	}

	public String getUtenteUltMod() {
		return utenteUltMod;
	}

	public void setUtenteUltMod(String utenteUltMod) {
		this.utenteUltMod = utenteUltMod;
	}

	public Integer getFkMarca() {
		return fkMarca;
	}

	public void setFkMarca(Integer fkMarca) {
		this.fkMarca = fkMarca;
	}

	public Integer getFkCombustibile() {
		return fkCombustibile;
	}

	public void setFkCombustibile(Integer fkCombustibile) {
		this.fkCombustibile = fkCombustibile;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public BigDecimal getPotenzaTermicaKw() {
		return potenzaTermicaKw;
	}

	public void setPotenzaTermicaKw(BigDecimal potenzaTermicaKw) {
		this.potenzaTermicaKw = potenzaTermicaKw;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getTempoManutAnni() {
		return tempoManutAnni;
	}

	public void setTempoManutAnni(Integer tempoManutAnni) {
		this.tempoManutAnni = tempoManutAnni;
	}

	public Integer getMediImpOreOperative() {
		return mediImpOreOperative;
	}

	public void setMediImpOreOperative(Integer mediImpOreOperative) {
		this.mediImpOreOperative = mediImpOreOperative;
	}

	public Integer getIdTipocannaFumaria() {
		return idTipocannaFumaria;
	}

	public void setIdTipocannaFumaria(Integer idTipocannaFumaria) {
		this.idTipocannaFumaria = idTipocannaFumaria;
	}

	public Date getDataMinimaControllo() {
		return dataMinimaControllo;
	}

	public void setDataMinimaControllo(Date dataMinimaControllo) {
		this.dataMinimaControllo = dataMinimaControllo;
	}

	public Date getDataMassimaControllo() {
		return dataMassimaControllo;
	}

	public void setDataMassimaControllo(Date dataMassimaControllo) {
		this.dataMassimaControllo = dataMassimaControllo;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getSiglaRea() {
		return siglaRea;
	}

	public void setSiglaRea(String siglaRea) {
		this.siglaRea = siglaRea;
	}

	public String getNumeroRea() {
		return numeroRea;
	}

	public void setNumeroRea(String numeroRea) {
		this.numeroRea = numeroRea;
	}

	public String getDesFluido() {
		return desFluido;
	}

	public void setDesFluido(String desFluido) {
		this.desFluido = desFluido;
	}

	public String getDesMarca() {
		return desMarca;
	}

	public void setDesMarca(String desMarca) {
		this.desMarca = desMarca;
	}

	public String getDesDettaglioGt() {
		return desDettaglioGt;
	}

	public void setDesDettaglioGt(String desDettaglioGt) {
		this.desDettaglioGt = desDettaglioGt;
	}

	@Override
	public String toString() {
		return "DatiGT{" + "idTipoComponente='" + idTipoComponente + '\'' + ", progressivo=" + progressivo + ", dataInstall=" + dataInstall + ", codiceImpianto=" + codiceImpianto + ", fkFluido="
				+ fkFluido + ", fkDettaglioGt=" + fkDettaglioGt + ", rendimentoPerc=" + rendimentoPerc + ", nModuli=" + nModuli + ", dataDismiss=" + dataDismiss + ", flgDismissione=" + flgDismissione
				+ ", dataUltMod=" + dataUltMod + ", utenteUltMod='" + utenteUltMod + '\'' + ", fkMarca=" + fkMarca + ", fkCombustibile=" + fkCombustibile + ", matricola='" + matricola + '\''
				+ ", modello='" + modello + '\'' + ", potenzaTermicaKw=" + potenzaTermicaKw + ", note='" + note + '\'' + ", tempoManutAnni=" + tempoManutAnni + ", mediImpOreOperative="
				+ mediImpOreOperative + ", idTipocannaFumaria=" + idTipocannaFumaria + ", dataPrimoControllo=" + dataMinimaControllo + ", dataUltimoControllo=" + dataMassimaControllo + ", descMarca='"
				+ descMarca + '\'' + ", descFluido='" + descFluido + '\'' + ", descDettaglioGt='" + descDettaglioGt + '\'' + ", descCombustibile='" + descCombustibile + '\'' + '}';
	}
}