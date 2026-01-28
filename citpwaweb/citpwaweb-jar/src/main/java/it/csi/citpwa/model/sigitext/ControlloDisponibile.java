package it.csi.citpwa.model.sigitext;

import java.util.Date;

public class ControlloDisponibile {
	private String nomeComponente;
	private Date dataControllo;
	private String tipoControllo;
	private String tipoComponente;
	private Date dataInstall;
	private String descMarca;
	private String modello;
	private String matricola;
	private String descDettaglio;
	private Integer potTermica;
	private String descCombustibile;

	private String progressivo;

	private Integer potTermicaRaff;
	private Integer potTermicaRisc;

	private String alimentazione;

	private Integer coMin;
	private Integer coMax;

	private Integer nModuli;

	private String cfPIvaImpresa;
	private String siglaReaImpresa;
	private String numeroReaImpresa;

	public ControlloDisponibile() {
		//Not implemented
	}

	public String getNomeComponente() {
		return nomeComponente;
	}

	public void setNomeComponente(String nomeComponente) {
		this.nomeComponente = nomeComponente;
	}

	public Date getDataControllo() {
		return dataControllo;
	}

	public void setDataControllo(Date dataControllo) {
		this.dataControllo = dataControllo;
	}

	public String getTipoControllo() {
		return tipoControllo;
	}

	public void setTipoControllo(String tipoControllo) {
		this.tipoControllo = tipoControllo;
	}

	public String getTipoComponente() {
		return tipoComponente;
	}

	public void setTipoComponente(String tipoComponente) {
		this.tipoComponente = tipoComponente;
	}

	public String getProgressivo() {
		return progressivo;
	}

	public void setProgressivo(String progressivo) {
		this.progressivo = progressivo;
	}

	public Date getDataInstall() {
		return dataInstall;
	}

	public void setDataInstall(Date dataInstall) {
		this.dataInstall = dataInstall;
	}

	public String getDescMarca() {
		return descMarca;
	}

	public void setDescMarca(String descMarca) {
		this.descMarca = descMarca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getDescDettaglio() {
		return descDettaglio;
	}

	public void setDescDettaglio(String descDettaglio) {
		this.descDettaglio = descDettaglio;
	}

	public Integer getPotTermica() {
		return potTermica;
	}

	public void setPotTermica(Integer potTermica) {
		this.potTermica = potTermica;
	}

	public String getDescCombustibile() {
		return descCombustibile;
	}

	public void setDescCombustibile(String descCombustibile) {
		this.descCombustibile = descCombustibile;
	}

	public Integer getPotTermicaRaff() {
		return potTermicaRaff;
	}

	public void setPotTermicaRaff(Integer potTermicaRaff) {
		this.potTermicaRaff = potTermicaRaff;
	}

	public Integer getPotTermicaRisc() {
		return potTermicaRisc;
	}

	public void setPotTermicaRisc(Integer potTermicaRisc) {
		this.potTermicaRisc = potTermicaRisc;
	}

	public String getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}

	public Integer getCoMin() {
		return coMin;
	}

	public void setCoMin(Integer coMin) {
		this.coMin = coMin;
	}

	public Integer getCoMax() {
		return coMax;
	}

	public void setCoMax(Integer coMax) {
		this.coMax = coMax;
	}

	public Integer getnModuli() {
		return nModuli;
	}

	public void setnModuli(Integer nModuli) {
		this.nModuli = nModuli;
	}

	public String getCfPIvaImpresa() {
		return cfPIvaImpresa;
	}

	public void setCfPIvaImpresa(String cfPIvaImpresa) {
		this.cfPIvaImpresa = cfPIvaImpresa;
	}

	public String getSiglaReaImpresa() {
		return siglaReaImpresa;
	}

	public void setSiglaReaImpresa(String siglaReaImpresa) {
		this.siglaReaImpresa = siglaReaImpresa;
	}

	public String getNumeroReaImpresa() {
		return numeroReaImpresa;
	}

	public void setNumeroReaImpresa(String numeroReaImpresa) {
		this.numeroReaImpresa = numeroReaImpresa;
	}

	@Override
	public String toString() {
		return "ControlloDisponibile{" + "nomeComponente='" + nomeComponente + '\'' + ", dataControllo=" + dataControllo + ", tipoControllo='" + tipoControllo + '\'' + ", tipoComponente='"
				+ tipoComponente + '\'' + ", dataInstall=" + dataInstall + ", descMarca='" + descMarca + '\'' + ", modello='" + modello + '\'' + ", matricola='" + matricola + '\''
				+ ", descDettaglio='" + descDettaglio + '\'' + ", potTermica=" + potTermica + ", descCombustibile='" + descCombustibile + '\'' + ", progressivo='" + progressivo + '\''
				+ ", potTermicaRaff=" + potTermicaRaff + ", potTermicaRisc=" + potTermicaRisc + ", alimentazione='" + alimentazione + '\'' + ", coMin=" + coMin + ", coMax=" + coMax + ", nModuli="
				+ nModuli + ", cfPIvaImpresa='" + cfPIvaImpresa + '\'' + ", siglaReaImpresa='" + siglaReaImpresa + '\'' + ", numeroReaImpresa='" + numeroReaImpresa + '\'' + '}';
	}
}
