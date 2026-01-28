package it.csi.citpwa.model.sigitext;

import java.math.BigDecimal;
import java.util.Date;

public class DatiCG {
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
	private Integer fkCombustibile;
	protected String descCombustibile;
	private String matricola;
	private String modello;
	private BigDecimal potenzaTermicaKw;
	private String note;
	private Integer tempoManutAnni;
	private Date dataMinimaControllo;
	private Date dataMassimaControllo;

	private String tipologia;
	private BigDecimal potenzaElettricaKw;
	private BigDecimal tempH2oOutMin;
	private BigDecimal tempH2oOutMax;
	private BigDecimal tempH2oInMin;
	private BigDecimal tempH2oInMax;
	private BigDecimal tempH2oMotoreMin;
	private BigDecimal tempH2oMotoreMax;
	private BigDecimal tempFumiValleMin;
	private BigDecimal tempFumiValleMax;
	private BigDecimal tempFumiMonteMin;
	private BigDecimal tempFumiMonteMax;
	private BigDecimal coMin;
	private BigDecimal coMax;
	private String alimentazione;

	private String cf;

	private String siglaRea;

	private String numeroRea;

	public DatiCG() {
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

	public Integer getFkCombustibile() {
		return fkCombustibile;
	}

	public void setFkCombustibile(Integer fkCombustibile) {
		this.fkCombustibile = fkCombustibile;
	}

	public String getDescCombustibile() {
		return descCombustibile;
	}

	public void setDescCombustibile(String descCombustibile) {
		this.descCombustibile = descCombustibile;
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

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public BigDecimal getPotenzaElettricaKw() {
		return potenzaElettricaKw;
	}

	public void setPotenzaElettricaKw(BigDecimal potenzaElettricaKw) {
		this.potenzaElettricaKw = potenzaElettricaKw;
	}

	public BigDecimal getTempH2oOutMin() {
		return tempH2oOutMin;
	}

	public void setTempH2oOutMin(BigDecimal tempH2oOutMin) {
		this.tempH2oOutMin = tempH2oOutMin;
	}

	public BigDecimal getTempH2oOutMax() {
		return tempH2oOutMax;
	}

	public void setTempH2oOutMax(BigDecimal tempH2oOutMax) {
		this.tempH2oOutMax = tempH2oOutMax;
	}

	public BigDecimal getTempH2oInMin() {
		return tempH2oInMin;
	}

	public void setTempH2oInMin(BigDecimal tempH2oInMin) {
		this.tempH2oInMin = tempH2oInMin;
	}

	public BigDecimal getTempH2oInMax() {
		return tempH2oInMax;
	}

	public void setTempH2oInMax(BigDecimal tempH2oInMax) {
		this.tempH2oInMax = tempH2oInMax;
	}

	public BigDecimal getTempH2oMotoreMin() {
		return tempH2oMotoreMin;
	}

	public void setTempH2oMotoreMin(BigDecimal tempH2oMotoreMin) {
		this.tempH2oMotoreMin = tempH2oMotoreMin;
	}

	public BigDecimal getTempH2oMotoreMax() {
		return tempH2oMotoreMax;
	}

	public void setTempH2oMotoreMax(BigDecimal tempH2oMotoreMax) {
		this.tempH2oMotoreMax = tempH2oMotoreMax;
	}

	public BigDecimal getTempFumiValleMin() {
		return tempFumiValleMin;
	}

	public void setTempFumiValleMin(BigDecimal tempFumiValleMin) {
		this.tempFumiValleMin = tempFumiValleMin;
	}

	public BigDecimal getTempFumiValleMax() {
		return tempFumiValleMax;
	}

	public void setTempFumiValleMax(BigDecimal tempFumiValleMax) {
		this.tempFumiValleMax = tempFumiValleMax;
	}

	public BigDecimal getTempFumiMonteMin() {
		return tempFumiMonteMin;
	}

	public void setTempFumiMonteMin(BigDecimal tempFumiMonteMin) {
		this.tempFumiMonteMin = tempFumiMonteMin;
	}

	public BigDecimal getTempFumiMonteMax() {
		return tempFumiMonteMax;
	}

	public void setTempFumiMonteMax(BigDecimal tempFumiMonteMax) {
		this.tempFumiMonteMax = tempFumiMonteMax;
	}

	public BigDecimal getCoMin() {
		return coMin;
	}

	public void setCoMin(BigDecimal coMin) {
		this.coMin = coMin;
	}

	public BigDecimal getCoMax() {
		return coMax;
	}

	public void setCoMax(BigDecimal coMax) {
		this.coMax = coMax;
	}

	public String getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
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
		return "DatiCG{" + "idTipoComponente='" + idTipoComponente + '\'' + ", progressivo=" + progressivo + ", dataInstall=" + dataInstall + ", codiceImpianto=" + codiceImpianto + ", dataDismiss="
				+ dataDismiss + ", flgDismissione=" + flgDismissione + ", dataUltMod=" + dataUltMod + ", utenteUltMod='" + utenteUltMod + '\'' + ", fkMarca=" + fkMarca + ", descMarca='" + descMarca
				+ '\'' + ", fkCombustibile=" + fkCombustibile + ", descCombustibile='" + descCombustibile + '\'' + ", matricola='" + matricola + '\'' + ", modello='" + modello + '\''
				+ ", potenzaTermicaKw=" + potenzaTermicaKw + ", note='" + note + '\'' + ", tempoManutAnni=" + tempoManutAnni + ", dataMinimaControllo=" + dataMinimaControllo
				+ ", dataMassimaControllo=" + dataMassimaControllo + ", tipologia='" + tipologia + '\'' + ", potenzaElettricaKw=" + potenzaElettricaKw + ", tempH2oOutMin=" + tempH2oOutMin
				+ ", tempH2oOutMax=" + tempH2oOutMax + ", tempH2oInMin=" + tempH2oInMin + ", tempH2oInMax=" + tempH2oInMax + ", tempH2oMotoreMin=" + tempH2oMotoreMin + ", tempH2oMotoreMax="
				+ tempH2oMotoreMax + ", tempFumiValleMin=" + tempFumiValleMin + ", tempFumiValleMax=" + tempFumiValleMax + ", tempFumiMonteMin=" + tempFumiMonteMin + ", tempFumiMonteMax="
				+ tempFumiMonteMax + ", coMin=" + coMin + ", coMax=" + coMax + ", alimentazione='" + alimentazione + '\'' + '}';
	}
}