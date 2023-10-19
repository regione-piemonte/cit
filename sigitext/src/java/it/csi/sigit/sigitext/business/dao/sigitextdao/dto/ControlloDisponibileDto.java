package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ControlloDisponibileDto {
	public BigDecimal idRComp4Manut;
	public BigDecimal fkPersonaGiuridica;
	public String idTipoComponente;
	public BigDecimal progressivo;
	public String descMarca;
	public String modello;
	private Date dataInstall;
	private String matricola;
	private String descDettaglio;
	private Integer potTermica;
	private String descCombustibile;
	private Integer potTermicaRaff;
	private Integer potTermicaRisc;
	private String alimentazione;
	private Integer coMin;
	private Integer coMax;

	private Integer nModuli;

	private String cfPIvaImpresa;
	private String siglaReaImpresa;
	private String numeroReaImpresa;

	public ControlloDisponibileDto(BigDecimal idRComp4Manut, BigDecimal fkPersonaGiuridica, String idTipoComponente, BigDecimal progressivo, String descMarca, String modello, Date dataInstall, String matricola, String descDettaglio, Integer potTermica, String descCombustibile, Integer potTermicaRaff, Integer potTermicaRisc, String alimentazione, Integer coMin, Integer coMax, Integer nModuli, String cfPIvaImpresa, String siglaReaImpresa, String numeroReaImpresa) {
		this.idRComp4Manut = idRComp4Manut;
		this.fkPersonaGiuridica = fkPersonaGiuridica;
		this.idTipoComponente = idTipoComponente;
		this.progressivo = progressivo;
		this.descMarca = descMarca;
		this.modello = modello;
		this.dataInstall = dataInstall;
		this.matricola = matricola;
		this.descDettaglio = descDettaglio;
		this.potTermica = potTermica;
		this.descCombustibile = descCombustibile;
		this.potTermicaRaff = potTermicaRaff;
		this.potTermicaRisc = potTermicaRisc;
		this.alimentazione = alimentazione;
		this.coMin = coMin;
		this.coMax = coMax;
		this.nModuli = nModuli;
		this.cfPIvaImpresa = cfPIvaImpresa;
		this.siglaReaImpresa = siglaReaImpresa;
		this.numeroReaImpresa = numeroReaImpresa;
	}

	public ControlloDisponibileDto() {
	}

	public BigDecimal getIdRComp4Manut() {
		return idRComp4Manut;
	}

	public void setIdRComp4Manut(BigDecimal idRComp4Manut) {
		this.idRComp4Manut = idRComp4Manut;
	}

	public BigDecimal getFkPersonaGiuridica() {
		return fkPersonaGiuridica;
	}

	public void setFkPersonaGiuridica(BigDecimal fkPersonaGiuridica) {
		this.fkPersonaGiuridica = fkPersonaGiuridica;
	}

	public String getIdTipoComponente() {
		return idTipoComponente;
	}

	public void setIdTipoComponente(String idTipoComponente) {
		this.idTipoComponente = idTipoComponente;
	}

	public BigDecimal getProgressivo() {
		return progressivo;
	}

	public void setProgressivo(BigDecimal progressivo) {
		this.progressivo = progressivo;
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

	public Date getDataInstall() {
		return dataInstall;
	}

	public void setDataInstall(Date dataInstall) {
		this.dataInstall = dataInstall;
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
		return "ControlloDisponibileDto{" + "idRComp4Manut=" + idRComp4Manut + ", fkPersonaGiuridica=" + fkPersonaGiuridica + ", idTipoComponente='" + idTipoComponente + '\'' + ", progressivo="
				+ progressivo + ", descMarca='" + descMarca + '\'' + ", modello='" + modello + '\'' + ", dataInstall=" + dataInstall + ", matricola='" + matricola + '\'' + ", descDettaglio='"
				+ descDettaglio + '\'' + ", potTermica=" + potTermica + ", descCombustibile='" + descCombustibile + '\'' + ", potTermicaRaff=" + potTermicaRaff + ", potTermicaRisc=" + potTermicaRisc
				+ ", alimentazione='" + alimentazione + '\'' + ", coMin=" + coMin + ", coMax=" + coMax + ", nModuli=" + nModuli + ", cfPIvaImpresa='" + cfPIvaImpresa + '\'' + ", siglaReaImpresa='"
				+ siglaReaImpresa + '\'' + ", numeroReaImpresa='" + numeroReaImpresa + '\'' + '}';
	}
}
