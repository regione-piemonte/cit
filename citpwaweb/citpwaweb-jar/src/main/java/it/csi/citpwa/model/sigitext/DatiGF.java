package it.csi.citpwa.model.sigitext;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class DatiGF {
	private String idTipoComponente;
	private Integer progressivo;
	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private Date dataInstall;
	private Integer codiceImpianto;
	private Integer fkDettaglioGf;
	private String desDettaglioGf;
	private String flgSorgenteExt;
	private String flgFluidoUtenze;
	private String fluidoFrigorigeno;
	private Integer nCircuiti;
	private String raffrescamentoEer;
	private BigDecimal raffPotenzaKw;
	private BigDecimal raffPotenzaAss;
	private String riscaldamentoCop;
	private BigDecimal riscPotenzaKw;
	private BigDecimal riscPotenzaAssKw;
	private Date dataDismiss;
	private Integer flgDismissione;
	private Date dataUltMod;
	private String utenteUltMod;
	private Integer fkMarca;

	private String desMarca;
	private Integer fkCombustibile;
	private String desCombustibile;
	private String matricola;
	private String modello;
	private BigDecimal potenzaTermicaKw;
	private String note;
	private Integer tempoManutAnni;
	private Integer idFonteEnSfruttata;
	private String desFonteEnSfruttata;
	private Date dataMinimaControllo;
	private Date dataMassimaControllo;

	private String cf;

	private String siglaRea;

	private String numeroRea;

	public DatiGF() {
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

	public Integer getFkDettaglioGf() {
		return fkDettaglioGf;
	}

	public void setFkDettaglioGf(Integer fkDettaglioGf) {
		this.fkDettaglioGf = fkDettaglioGf;
	}

	public String getDesDettaglioGf() {
		return desDettaglioGf;
	}

	public void setDesDettaglioGf(String desDettaglioGf) {
		this.desDettaglioGf = desDettaglioGf;
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

	public Integer getnCircuiti() {
		return nCircuiti;
	}

	public void setnCircuiti(Integer nCircuiti) {
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

	public String getDesMarca() {
		return desMarca;
	}

	public void setDesMarca(String desMarca) {
		this.desMarca = desMarca;
	}


	public void setFkCombustibile(Integer fkCombustibile) {
		this.fkCombustibile = fkCombustibile;
	}

	public String getDesCombustibile() {
		return desCombustibile;
	}

	public void setDesCombustibile(String desCombustibile) {
		this.desCombustibile = desCombustibile;
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

	public Integer getIdFonteEnSfruttata() {
		return idFonteEnSfruttata;
	}

	public void setIdFonteEnSfruttata(Integer idFonteEnSfruttata) {
		this.idFonteEnSfruttata = idFonteEnSfruttata;
	}

	public String getDesFonteEnSfruttata() {
		return desFonteEnSfruttata;
	}

	public void setDesFonteEnSfruttata(String desFonteEnSfruttata) {
		this.desFonteEnSfruttata = desFonteEnSfruttata;
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

	public Integer getFkCombustibile() {
		return fkCombustibile;
	}
}