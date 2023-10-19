package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Data transfer object relativo al DAO SigitTCompGfDao.
 *
 * @generated
 */
public class SigitTCompGfCompletoDto extends SigitTCompGfPk {

	private static final long serialVersionUID = 1L;

	protected BigDecimal fkDettaglioGf;
	protected String flgSorgenteExt;
	protected String flgFluidoUtenze;
	protected String fluidoFrigorigeno;
	protected BigDecimal nCircuiti;
	protected String raffrescamentoEer;
	protected BigDecimal raffPotenzaKw;
	protected BigDecimal raffPotenzaAss;
	protected String riscaldamentoCop;
	protected BigDecimal riscPotenzaKw;
	protected BigDecimal riscPotenzaAssKw;
	protected Date dataDismiss;
	protected BigDecimal flgDismissione;
	protected Timestamp dataUltMod;
	protected String utenteUltMod;
	protected BigDecimal fkMarca;
	protected BigDecimal fkCombustibile;
	protected String matricola;
	protected String modello;
	protected BigDecimal potenzaTermicaKw;
	protected String note;
	protected BigDecimal tempoManutAnni;
	protected BigDecimal idFonteEnSfruttata;

	protected String desDettaglioGf;
	protected String desMarca;
	protected String desCombustibile;
	protected String desFonteEnSfruttata;

	private String cf;

	private String siglaRea;

	private String numeroRea;

	public SigitTCompGfCompletoDto() {
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

	public BigDecimal getFkDettaglioGf() {
		return fkDettaglioGf;
	}

	public void setFkDettaglioGf(BigDecimal fkDettaglioGf) {
		this.fkDettaglioGf = fkDettaglioGf;
	}

	public String getFlgSorgenteExt() {
		return flgSorgenteExt;
	}

	public void setFlgSorgenteExt(String flgSorgenteExt) {
		this.flgSorgenteExt = flgSorgenteExt;
	}

	public String getFlgFluidoUtenze() {
		return flgFluidoUtenze;
	}

	public void setFlgFluidoUtenze(String flgFluidoUtenze) {
		this.flgFluidoUtenze = flgFluidoUtenze;
	}

	public String getFluidoFrigorigeno() {
		return fluidoFrigorigeno;
	}

	public void setFluidoFrigorigeno(String fluidoFrigorigeno) {
		this.fluidoFrigorigeno = fluidoFrigorigeno;
	}

	public BigDecimal getnCircuiti() {
		return nCircuiti;
	}

	public void setnCircuiti(BigDecimal nCircuiti) {
		this.nCircuiti = nCircuiti;
	}

	public String getRaffrescamentoEer() {
		return raffrescamentoEer;
	}

	public void setRaffrescamentoEer(String raffrescamentoEer) {
		this.raffrescamentoEer = raffrescamentoEer;
	}

	public BigDecimal getRaffPotenzaKw() {
		return raffPotenzaKw;
	}

	public void setRaffPotenzaKw(BigDecimal raffPotenzaKw) {
		this.raffPotenzaKw = raffPotenzaKw;
	}

	public BigDecimal getRaffPotenzaAss() {
		return raffPotenzaAss;
	}

	public void setRaffPotenzaAss(BigDecimal raffPotenzaAss) {
		this.raffPotenzaAss = raffPotenzaAss;
	}

	public String getRiscaldamentoCop() {
		return riscaldamentoCop;
	}

	public void setRiscaldamentoCop(String riscaldamentoCop) {
		this.riscaldamentoCop = riscaldamentoCop;
	}

	public BigDecimal getRiscPotenzaKw() {
		return riscPotenzaKw;
	}

	public void setRiscPotenzaKw(BigDecimal riscPotenzaKw) {
		this.riscPotenzaKw = riscPotenzaKw;
	}

	public BigDecimal getRiscPotenzaAssKw() {
		return riscPotenzaAssKw;
	}

	public void setRiscPotenzaAssKw(BigDecimal riscPotenzaAssKw) {
		this.riscPotenzaAssKw = riscPotenzaAssKw;
	}

	public Date getDataDismiss() {
		return dataDismiss;
	}

	public void setDataDismiss(Date dataDismiss) {
		this.dataDismiss = dataDismiss;
	}

	public BigDecimal getFlgDismissione() {
		return flgDismissione;
	}

	public void setFlgDismissione(BigDecimal flgDismissione) {
		this.flgDismissione = flgDismissione;
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

	public BigDecimal getFkMarca() {
		return fkMarca;
	}

	public void setFkMarca(BigDecimal fkMarca) {
		this.fkMarca = fkMarca;
	}

	public BigDecimal getFkCombustibile() {
		return fkCombustibile;
	}

	public void setFkCombustibile(BigDecimal fkCombustibile) {
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

	public BigDecimal getTempoManutAnni() {
		return tempoManutAnni;
	}

	public void setTempoManutAnni(BigDecimal tempoManutAnni) {
		this.tempoManutAnni = tempoManutAnni;
	}

	public BigDecimal getIdFonteEnSfruttata() {
		return idFonteEnSfruttata;
	}

	public void setIdFonteEnSfruttata(BigDecimal idFonteEnSfruttata) {
		this.idFonteEnSfruttata = idFonteEnSfruttata;
	}

	public String getDesDettaglioGf() {
		return desDettaglioGf;
	}

	public void setDesDettaglioGf(String desDettaglioGf) {
		this.desDettaglioGf = desDettaglioGf;
	}

	public String getDesMarca() {
		return desMarca;
	}

	public void setDesMarca(String desMarca) {
		this.desMarca = desMarca;
	}

	public String getDesCombustibile() {
		return desCombustibile;
	}

	public void setDesCombustibile(String desCombustibile) {
		this.desCombustibile = desCombustibile;
	}

	public String getDesFonteEnSfruttata() {
		return desFonteEnSfruttata;
	}

	public void setDesFonteEnSfruttata(String desFonteEnSfruttata) {
		this.desFonteEnSfruttata = desFonteEnSfruttata;
	}

	public SigitTCompGfPk createPk() {
		return new SigitTCompGfPk(idTipoComponente, progressivo, dataInstall, codiceImpianto);
	}

	public boolean equals(Object other) {
		return super.equals(other);
	}

	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "SigitTCompGfCompletoDto{" + "fkDettaglioGf=" + fkDettaglioGf + ", flgSorgenteExt='" + flgSorgenteExt + '\'' + ", flgFluidoUtenze='" + flgFluidoUtenze + '\'' + ", fluidoFrigorigeno='"
				+ fluidoFrigorigeno + '\'' + ", nCircuiti=" + nCircuiti + ", raffrescamentoEer='" + raffrescamentoEer + '\'' + ", raffPotenzaKw=" + raffPotenzaKw + ", raffPotenzaAss=" + raffPotenzaAss
				+ ", riscaldamentoCop='" + riscaldamentoCop + '\'' + ", riscPotenzaKw=" + riscPotenzaKw + ", riscPotenzaAssKw=" + riscPotenzaAssKw + ", dataDismiss=" + dataDismiss
				+ ", flgDismissione=" + flgDismissione + ", dataUltMod=" + dataUltMod + ", utenteUltMod='" + utenteUltMod + '\'' + ", fkMarca=" + fkMarca + ", fkCombustibile=" + fkCombustibile
				+ ", matricola='" + matricola + '\'' + ", modello='" + modello + '\'' + ", potenzaTermicaKw=" + potenzaTermicaKw + ", note='" + note + '\'' + ", tempoManutAnni=" + tempoManutAnni
				+ ", idFonteEnSfruttata=" + idFonteEnSfruttata + ", desDettaglioGf='" + desDettaglioGf + '\'' + ", desMarca='" + desMarca + '\'' + ", desCombustibile='" + desCombustibile + '\''
				+ ", desFonteEnSfruttata='" + desFonteEnSfruttata + '\'' + ", idTipoComponente='" + idTipoComponente + '\'' + ", progressivo=" + progressivo + ", dataInstall=" + dataInstall
				+ ", codiceImpianto=" + codiceImpianto + "} " + super.toString();
	}
}
