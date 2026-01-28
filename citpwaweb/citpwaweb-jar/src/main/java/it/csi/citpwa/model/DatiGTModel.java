/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model;

import it.csi.citpwa.model.sigitext.DatiGT;
import it.csi.citpwa.util.Constants;
import it.csi.citpwa.util.ObjectConverter;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatiGTModel {
	private String idTipoComponente;
	private Integer progressivo;
	private String dataInstall;
	private Integer codiceImpianto;
	private Integer fkFluido;
	private Integer fkDettaglioGt;
	private BigDecimal rendimentoPerc;
	private Integer nModuli;
	private String dataDismiss;
	private Integer flgDismissione;
	private String dataUltMod;
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
	private String dataMinimaControllo;
	private String dataMassimaControllo;

	protected String descMarca;
	protected String descFluido;
	protected String descDettaglioGt;
	protected String descCombustibile;

	private String cf;

	private String siglaRea;

	private String numeroRea;

	public static ObjectConverter<DatiGT, DatiGTModel> dtoToModel = new ObjectConverter<>(u -> {
		DatiGTModel model = new DatiGTModel();
		SimpleDateFormat format = new SimpleDateFormat(Constants.FORMAT);
		model.setIdTipoComponente(u.getIdTipoComponente());
		model.setProgressivo(u.getProgressivo());
		model.setDataInstall(u.getDataInstall() != null ? format.format(u.getDataInstall()) : null);
		model.setCodiceImpianto(u.getCodiceImpianto());
		model.setFkFluido(u.getFkFluido());
		model.setFkDettaglioGt(u.getFkDettaglioGt());
		model.setRendimentoPerc(u.getRendimentoPerc());
		model.setnModuli(u.getnModuli());
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
		model.setMediImpOreOperative(u.getMediImpOreOperative());
		model.setIdTipocannaFumaria(u.getIdTipocannaFumaria());
		model.setDataMinimaControllo(u.getDataMinimaControllo() != null ? format.format(u.getDataMinimaControllo()) : null);
		model.setDataMassimaControllo(u.getDataMassimaControllo() != null ? format.format(u.getDataMassimaControllo()) : null);
		model.setDescCombustibile(u.getDescCombustibile());
		model.setDescMarca(u.getDescMarca());
		model.setDescDettaglioGt(u.getDescDettaglioGt());
		model.setDescFluido(u.getDescFluido());
		model.setCf(u.getCf());
		model.setNumeroRea(u.getNumeroRea());
		model.setSiglaRea(u.getSiglaRea());
		return model;
	});

	public static ObjectConverter<DatiGTModel, DatiGT
			> modelToDto = new ObjectConverter<>(u -> {
		DatiGT dto = new DatiGT();
		SimpleDateFormat format = new SimpleDateFormat(Constants.FORMAT);
		dto.setIdTipoComponente(u.getIdTipoComponente());
		dto.setProgressivo(u.getProgressivo());
		try {
			dto.setDataInstall(u.getDataInstall() != null ? format.parse(u.getDataInstall()) : null);
		} catch (ParseException e) {
			dto.setDataInstall(null);
		}
		dto.setCodiceImpianto(u.getCodiceImpianto());
		dto.setFkFluido(u.getFkFluido());
		dto.setFkDettaglioGt(u.getFkDettaglioGt());
		dto.setRendimentoPerc(u.getRendimentoPerc());
		dto.setnModuli(u.getnModuli());
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
		if(u.getMediImpOreOperative() != null) {
			dto.setMediImpOreOperative(u.getMediImpOreOperative());
		}
		dto.setIdTipocannaFumaria(u.getIdTipocannaFumaria());
		dto.setDescCombustibile(u.getDescCombustibile());
		dto.setDescMarca(u.getDescMarca());
		dto.setDescDettaglioGt(u.getDescDettaglioGt());
		dto.setDescFluido(u.getDescFluido());
		dto.setCf(u.getCf());
		dto.setNumeroRea(u.getNumeroRea());
		dto.setSiglaRea(u.getSiglaRea());
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
		return dto;
	});

	public DatiGTModel() {
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
		return "DatiGTModel{" + "idTipoComponente='" + idTipoComponente + '\'' + ", progressivo=" + progressivo + ", dataInstall='" + dataInstall + '\'' + ", codiceImpianto=" + codiceImpianto
				+ ", fkFluido=" + fkFluido + ", fkDettaglioGt=" + fkDettaglioGt + ", rendimentoPerc=" + rendimentoPerc + ", nModuli=" + nModuli + ", dataDismiss='" + dataDismiss + '\''
				+ ", flgDismissione=" + flgDismissione + ", dataUltMod='" + dataUltMod + '\'' + ", utenteUltMod='" + utenteUltMod + '\'' + ", fkMarca=" + fkMarca + ", fkCombustibile=" + fkCombustibile
				+ ", matricola='" + matricola + '\'' + ", modello='" + modello + '\'' + ", potenzaTermicaKw=" + potenzaTermicaKw + ", note='" + note + '\'' + ", tempoManutAnni=" + tempoManutAnni
				+ ", mediImpOreOperative=" + mediImpOreOperative + ", idTipocannaFumaria=" + idTipocannaFumaria + ", dataPrimoControllo='" + dataMinimaControllo + '\'' + ", dataUltimoControllo='"
				+ dataMassimaControllo + '\'' + ", descMarca='" + descMarca + '\'' + ", descFluido='" + descFluido + '\'' + ", descDettaglioGt='" + descDettaglioGt + '\'' + ", descCombustibile='"
				+ descCombustibile + '\'' + '}';
	}
}