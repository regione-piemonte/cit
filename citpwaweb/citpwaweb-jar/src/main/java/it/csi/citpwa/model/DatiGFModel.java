package it.csi.citpwa.model;

import it.csi.citpwa.model.sigitext.DatiGF;
import it.csi.citpwa.util.Constants;
import it.csi.citpwa.util.ObjectConverter;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatiGFModel {

	public static ObjectConverter<DatiGF, DatiGFModel> dtoToModel = new ObjectConverter<>(u -> {
		DatiGFModel model = new DatiGFModel();
		SimpleDateFormat format = new SimpleDateFormat(Constants.FORMAT);
		model.setIdTipoComponente(u.getIdTipoComponente());
		model.setProgressivo(u.getProgressivo());
		model.setDataInstall(u.getDataInstall() != null ? format.format(u.getDataInstall()) : null);
		model.setCodiceImpianto(u.getCodiceImpianto());
		model.setFkDettaglioGf(u.getFkDettaglioGf());
		model.setnCircuiti(u.getnCircuiti());
		model.setDataDismiss(u.getDataDismiss() != null ? format.format(u.getDataDismiss()) : null);
		model.setFlgDismissione(u.getFlgDismissione());
		model.setDataUltMod(u.getDataUltMod() != null ? format.format(u.getDataUltMod()) : null);
		model.setUtenteUltMod(u.getUtenteUltMod());
		model.setFkMarca(u.getFkMarca());
		model.setFkCombustibile(u.getFkCombustibile());
		model.setMatricola(u.getMatricola());
		model.setModello(u.getModello());
		model.setPotenzaTermicaKw(u.getPotenzaTermicaKw());
		model.setNote(u.getNote());
		model.setTempoManutAnni(u.getTempoManutAnni());
		model.setDataMinimaControllo(u.getDataMinimaControllo() != null ? format.format(u.getDataMinimaControllo()) : null);
		model.setDataMassimaControllo(u.getDataMassimaControllo() != null ? format.format(u.getDataMassimaControllo()) : null);
		model.setDesCombustibile(u.getDesCombustibile());
		model.setDesMarca(u.getDesMarca());
		model.setDesDettaglioGf(u.getDesDettaglioGf());

		model.setFlgSorgenteExt(u.getFlgSorgenteExt());
		model.setFlgFluidoUtenze(u.getFlgFluidoUtenze());
		model.setFluidoFrigorigeno(u.getFluidoFrigorigeno());
		model.setRaffrescamentoEer(u.getRaffrescamentoEer());
		model.setRaffPotenzaKw(u.getRaffPotenzaKw());
		model.setRaffPotenzaAss(u.getRaffPotenzaAss());
		model.setRiscaldamentoCop(u.getRiscaldamentoCop());
		model.setRiscPotenzaAssKw(u.getRiscPotenzaAssKw());
		model.setRiscPotenzaKw(u.getRiscPotenzaKw());
		model.setDesFonteEnSfruttata(u.getDesFonteEnSfruttata());
		model.setIdFonteEnSfruttata(u.getIdFonteEnSfruttata());
		model.setCf(u.getCf());
		model.setNumeroRea(u.getNumeroRea());
		model.setSiglaRea(u.getSiglaRea());
		return model;
	});

	public static ObjectConverter<DatiGFModel, DatiGF> modelToDto = new ObjectConverter<>(u -> {
		DatiGF dto = new DatiGF();
		SimpleDateFormat format = new SimpleDateFormat(Constants.FORMAT);
		dto.setIdTipoComponente(u.getIdTipoComponente());
		dto.setProgressivo(u.getProgressivo());
		try {
			dto.setDataInstall(u.getDataInstall() != null ? format.parse(u.getDataInstall()) : null);
		} catch (ParseException e) {
			dto.setDataInstall(null);
		}
		dto.setCodiceImpianto(u.getCodiceImpianto());
		dto.setFkDettaglioGf(u.getFkDettaglioGf());
		dto.setnCircuiti(u.getnCircuiti());
		try {
			dto.setDataDismiss(u.getDataDismiss() != null ? format.parse(u.getDataDismiss()) : null);
		} catch (ParseException e) {
			dto.setDataDismiss(null);
		}
		dto.setFlgDismissione(u.getFlgDismissione());
		try {
			dto.setDataUltMod(u.getDataUltMod() != null ? format.parse(u.getDataUltMod()) : null);
		} catch (ParseException e) {
			dto.setDataUltMod(null);
		}
		dto.setUtenteUltMod(u.getUtenteUltMod());
		dto.setFkMarca(u.getFkMarca());
		dto.setFkCombustibile(u.getFkCombustibile());
		dto.setMatricola(u.getMatricola());
		dto.setModello(u.getModello());
		dto.setPotenzaTermicaKw(u.getPotenzaTermicaKw());
		dto.setNote(u.getNote());
		dto.setTempoManutAnni(u.getTempoManutAnni());
		dto.setDesCombustibile(u.getDesCombustibile());
		dto.setDesMarca(u.getDesMarca());
		dto.setDesDettaglioGf(u.getDesDettaglioGf());
		try {
			dto.setDataMinimaControllo(u.getDataMinimaControllo() != null ? format.parse(u.getDataMinimaControllo()) : null);
		} catch (ParseException e) {
			dto.setDataMinimaControllo(null);
		}
		try {
			dto.setDataMassimaControllo(u.getDataMassimaControllo() != null ? format.parse(u.getDataMassimaControllo()) : null);
		} catch (ParseException e) {
			dto.setDataMassimaControllo(null);
		}

		dto.setFlgSorgenteExt(u.getFlgSorgenteExt());
		dto.setFlgFluidoUtenze(u.getFlgFluidoUtenze());
		dto.setFluidoFrigorigeno(u.getFluidoFrigorigeno());
		dto.setRaffrescamentoEer(u.getRaffrescamentoEer());
		dto.setRaffPotenzaKw(u.getRaffPotenzaKw());
		dto.setRaffPotenzaAss(u.getRaffPotenzaAss());
		dto.setRiscaldamentoCop(u.getRiscaldamentoCop());
		dto.setRiscPotenzaAssKw(u.getRiscPotenzaAssKw());
		dto.setRiscPotenzaKw(u.getRiscPotenzaKw());
		dto.setDesFonteEnSfruttata(u.getDesFonteEnSfruttata());
		dto.setIdFonteEnSfruttata(u.getIdFonteEnSfruttata());
		dto.setCf(u.getCf());
		dto.setNumeroRea(u.getNumeroRea());
		dto.setSiglaRea(u.getSiglaRea());
		return dto;
	});

	private String idTipoComponente;
	private Integer progressivo;
	private String dataInstall;
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
	private String dataDismiss;
	private Integer flgDismissione;
	private String dataUltMod;
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
	private String dataMinimaControllo;
	private String dataMassimaControllo;

	private String cf;

	private String siglaRea;

	private String numeroRea;

	public DatiGFModel() {
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

	public String getDataInstall() {
		return dataInstall;
	}

	public void setDataInstall(String dataInstall) {
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

	public String getDataDismiss() {
		return dataDismiss;
	}

	public void setDataDismiss(String dataDismiss) {
		this.dataDismiss = dataDismiss;
	}

	public Integer getFlgDismissione() {
		return flgDismissione;
	}

	public void setFlgDismissione(Integer flgDismissione) {
		this.flgDismissione = flgDismissione;
	}

	public String getDataUltMod() {
		return dataUltMod;
	}

	public void setDataUltMod(String dataUltMod) {
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

	public Integer getFkCombustibile() {
		return fkCombustibile;
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

	public String getDataMinimaControllo() {
		return dataMinimaControllo;
	}

	public void setDataMinimaControllo(String dataMinimaControllo) {
		this.dataMinimaControllo = dataMinimaControllo;
	}

	public String getDataMassimaControllo() {
		return dataMassimaControllo;
	}

	public void setDataMassimaControllo(String dataMassimaControllo) {
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

	@Override
	public String toString() {
		return "DatiGFModel{" + "idTipoComponente='" + idTipoComponente + '\'' + ", progressivo=" + progressivo + ", dataInstall='" + dataInstall + '\'' + ", codiceImpianto=" + codiceImpianto
				+ ", fkDettaglioGf=" + fkDettaglioGf + ", desDettaglioGf='" + desDettaglioGf + '\'' + ", flgSorgenteExt='" + flgSorgenteExt + '\'' + ", flgFluidoUtenze='" + flgFluidoUtenze + '\''
				+ ", fluidoFrigorigeno='" + fluidoFrigorigeno + '\'' + ", nCircuiti=" + nCircuiti + ", raffrescamentoEer='" + raffrescamentoEer + '\'' + ", raffPotenzaKw=" + raffPotenzaKw
				+ ", raffPotenzaAss=" + raffPotenzaAss + ", riscaldamentoCop='" + riscaldamentoCop + '\'' + ", riscPotenzaKw=" + riscPotenzaKw + ", riscPotenzaAssKw=" + riscPotenzaAssKw
				+ ", dataDismiss='" + dataDismiss + '\'' + ", flgDismissione=" + flgDismissione + ", dataUltMod='" + dataUltMod + '\'' + ", utenteUltMod='" + utenteUltMod + '\'' + ", fkMarca="
				+ fkMarca + ", desMarca='" + desMarca + '\'' + ", fkCombustibile=" + fkCombustibile + ", desCombustibile='" + desCombustibile + '\'' + ", matricola='" + matricola + '\''
				+ ", modello='" + modello + '\'' + ", potenzaTermicaKw=" + potenzaTermicaKw + ", note='" + note + '\'' + ", tempoManutAnni=" + tempoManutAnni + ", idFonteEnSfruttata="
				+ idFonteEnSfruttata + ", desFonteEnSfruttata='" + desFonteEnSfruttata + '\'' + ", dataMinimaControllo='" + dataMinimaControllo + '\'' + ", dataMassimaControllo='"
				+ dataMassimaControllo + '\'' + '}';
	}
}
