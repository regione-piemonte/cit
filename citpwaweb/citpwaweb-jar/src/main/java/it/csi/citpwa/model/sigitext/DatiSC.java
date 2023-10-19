package it.csi.citpwa.model.sigitext;

import java.math.BigDecimal;
import java.util.Date;

public class DatiSC {
	private String idTipoComponente;
	private Integer progressivo;
	private Date dataInstall;
	private Integer codiceImpianto;
	private Date dataDismiss;
	private Integer flgDismissione;
	private Date dataUltMod;
	private String utenteUltMod;
	private Integer fkMarca;
	protected String descMarca;
	private String matricola;
	private String modello;
	private BigDecimal potenzaTermicaKw;
	private String note;
	private Integer tempoManutAnni;
	private Date dataMinimaControllo;
	private Date dataMassimaControllo;

	private String NomeProprietario;
	private String cfProprietario;

	private String cf;

	private String siglaRea;

	private String numeroRea;

	public DatiSC() {
	}

	public DatiSC(String idTipoComponente, Integer progressivo, Date dataInstall, Integer codiceImpianto, Date dataDismiss, Integer flgDismissione, Date dataUltMod, String utenteUltMod, Integer fkMarca, String descMarca, String matricola, String modello, BigDecimal potenzaTermicaKw, String note, Integer tempoManutAnni, Date dataMinimaControllo, Date dataMassimaControllo, String nomeProprietario, String cfProprietario) {
		this.idTipoComponente = idTipoComponente;
		this.progressivo = progressivo;
		this.dataInstall = dataInstall;
		this.codiceImpianto = codiceImpianto;
		this.dataDismiss = dataDismiss;
		this.flgDismissione = flgDismissione;
		this.dataUltMod = dataUltMod;
		this.utenteUltMod = utenteUltMod;
		this.fkMarca = fkMarca;
		this.descMarca = descMarca;
		this.matricola = matricola;
		this.modello = modello;
		this.potenzaTermicaKw = potenzaTermicaKw;
		this.note = note;
		this.tempoManutAnni = tempoManutAnni;
		this.dataMinimaControllo = dataMinimaControllo;
		this.dataMassimaControllo = dataMassimaControllo;
		NomeProprietario = nomeProprietario;
		this.cfProprietario = cfProprietario;
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

	public String getDescMarca() {
		return descMarca;
	}

	public void setDescMarca(String descMarca) {
		this.descMarca = descMarca;
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

	public String getNomeProprietario() {
		return NomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		NomeProprietario = nomeProprietario;
	}

	public String getCfProprietario() {
		return cfProprietario;
	}

	public void setCfProprietario(String cfProprietario) {
		this.cfProprietario = cfProprietario;
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

	@Override
	public String toString() {
		return "DatiSC{" + "idTipoComponente='" + idTipoComponente + '\'' + ", progressivo=" + progressivo + ", dataInstall=" + dataInstall + ", codiceImpianto=" + codiceImpianto + ", dataDismiss="
				+ dataDismiss + ", flgDismissione=" + flgDismissione + ", dataUltMod=" + dataUltMod + ", utenteUltMod='" + utenteUltMod + '\'' + ", fkMarca=" + fkMarca + ", descMarca='" + descMarca
				+ '\'' + ", matricola='" + matricola + '\'' + ", modello='" + modello + '\'' + ", potenzaTermicaKw=" + potenzaTermicaKw + ", note='" + note + '\'' + ", tempoManutAnni="
				+ tempoManutAnni + ", dataMinimaControllo=" + dataMinimaControllo + ", dataMassimaControllo=" + dataMassimaControllo + ", NomeProprietario='" + NomeProprietario + '\''
				+ ", cfProprietario='" + cfProprietario + '\'' + '}';
	}
}