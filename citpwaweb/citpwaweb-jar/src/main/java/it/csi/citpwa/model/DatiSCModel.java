package it.csi.citpwa.model;

import it.csi.citpwa.model.sigitext.DatiSC;
import it.csi.citpwa.util.Constants;
import it.csi.citpwa.util.ObjectConverter;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatiSCModel {
	private String idTipoComponente;
	private Integer progressivo;
	private String dataInstall;
	private Integer codiceImpianto;
	private String dataDismiss;
	private Integer flgDismissione;
	private String dataUltMod;
	private String utenteUltMod;
	private Integer fkMarca;
	protected String descMarca;
	private String matricola;
	private String modello;
	private BigDecimal potenzaTermicaKw;
	private String note;
	private Integer tempoManutAnni;
	private String dataMinimaControllo;
	private String dataMassimaControllo;

	private String nomeProprietario;
	private String cfProprietario;

	private String cf;

	private String siglaRea;

	private String numeroRea;

	public static ObjectConverter<DatiSC, DatiSCModel> dtoToModel = new ObjectConverter<>(u -> {
		DatiSCModel model = new DatiSCModel();
		SimpleDateFormat format = new SimpleDateFormat(Constants.FORMAT);
		model.setIdTipoComponente(u.getIdTipoComponente());
		model.setProgressivo(u.getProgressivo());
		model.setDataInstall(u.getDataInstall() != null ? format.format(u.getDataInstall()) : null);
		model.setCodiceImpianto(u.getCodiceImpianto());
		model.setDataDismiss(u.getDataDismiss() != null ? format.format(u.getDataDismiss()) : null);
		model.setFlgDismissione(u.getFlgDismissione());
		model.setDataUltMod(u.getDataUltMod() != null ? format.format(u.getDataUltMod()) : null);
		model.setUtenteUltMod(u.getUtenteUltMod());
		model.setFkMarca(u.getFkMarca());
		model.setMatricola(u.getMatricola());
		model.setModello(u.getModello());
		model.setPotenzaTermicaKw(u.getPotenzaTermicaKw());
		model.setNote(u.getNote());
		model.setTempoManutAnni(u.getTempoManutAnni());
		model.setDataMinimaControllo(u.getDataMinimaControllo() != null ? format.format(u.getDataMinimaControllo()) : null);
		model.setDataMassimaControllo(u.getDataMassimaControllo() != null ? format.format(u.getDataMassimaControllo()) : null);
		model.setDescMarca(u.getDescMarca());
		model.setNomeProprietario(u.getNomeProprietario());
		model.setCfProprietario(u.getCfProprietario());
		model.setCf(u.getCf());
		model.setNumeroRea(u.getNumeroRea());
		model.setSiglaRea(u.getSiglaRea());
		return model;
	});

	public static ObjectConverter<DatiSCModel, DatiSC> modelToDto = new ObjectConverter<>(u -> {
		DatiSC dto = new DatiSC();
		SimpleDateFormat format = new SimpleDateFormat(Constants.FORMAT);
		dto.setIdTipoComponente(u.getIdTipoComponente());
		dto.setProgressivo(u.getProgressivo());
		try {
			dto.setDataInstall(u.getDataInstall() != null ? format.parse(u.getDataInstall()) : null);
		} catch (ParseException e) {
			dto.setDataInstall(null);
		}
		dto.setCodiceImpianto(u.getCodiceImpianto());
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
		dto.setMatricola(u.getMatricola());
		dto.setModello(u.getModello());
		dto.setPotenzaTermicaKw(u.getPotenzaTermicaKw());
		dto.setNote(u.getNote());
		dto.setTempoManutAnni(u.getTempoManutAnni());
		dto.setDescMarca(u.getDescMarca());
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

		dto.setNomeProprietario(u.getNomeProprietario());
		dto.setCfProprietario(u.getCfProprietario());
		dto.setCf(u.getCf());
		dto.setNumeroRea(u.getNumeroRea());
		dto.setSiglaRea(u.getSiglaRea());
		return dto;
	});

	public DatiSCModel() {
	}

	public DatiSCModel(String idTipoComponente, Integer progressivo, String dataInstall, Integer codiceImpianto, String dataDismiss, Integer flgDismissione, String dataUltMod, String utenteUltMod, Integer fkMarca, String descMarca, String matricola, String modello, BigDecimal potenzaTermicaKw, String note, Integer tempoManutAnni, String dataMinimaControllo, String dataMassimaControllo, String nomeProprietario, String cfProprietario) {
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
		this.nomeProprietario = nomeProprietario;
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

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
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
		return "DatiSCModel{" + "idTipoComponente='" + idTipoComponente + '\'' + ", progressivo=" + progressivo + ", dataInstall='" + dataInstall + '\'' + ", codiceImpianto=" + codiceImpianto
				+ ", dataDismiss='" + dataDismiss + '\'' + ", flgDismissione=" + flgDismissione + ", dataUltMod='" + dataUltMod + '\'' + ", utenteUltMod='" + utenteUltMod + '\'' + ", fkMarca="
				+ fkMarca + ", descMarca='" + descMarca + '\'' + ", matricola='" + matricola + '\'' + ", modello='" + modello + '\'' + ", potenzaTermicaKw=" + potenzaTermicaKw + ", note='" + note
				+ '\'' + ", tempoManutAnni=" + tempoManutAnni + ", dataMinimaControllo='" + dataMinimaControllo + '\'' + ", dataMassimaControllo='" + dataMassimaControllo + '\''
				+ ", NomeProprietario='" + nomeProprietario + '\'' + ", cfProprietario='" + cfProprietario + '\'' + '}';
	}
}