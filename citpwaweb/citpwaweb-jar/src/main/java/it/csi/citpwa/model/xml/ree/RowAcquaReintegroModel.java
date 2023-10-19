package it.csi.citpwa.model.xml.ree;

import it.csi.citpwa.model.xsd.controllo1B.RowAcquaReintegro;
import it.csi.citpwa.util.ObjectConverter;

import java.math.BigDecimal;
import java.math.BigInteger;

public class RowAcquaReintegroModel {

	public static ObjectConverter<RowAcquaReintegro, RowAcquaReintegroModel> tipo1BDtoToModel = new ObjectConverter<>(u -> {
		RowAcquaReintegroModel model = new RowAcquaReintegroModel();
		model.setUnitaMisura(u.getACUnitaMisura());
		model.setEsercizio(u.getACEsercizio());
		model.setLetturaIniziale(u.getACLetturaIniziale());
		model.setLetturaFinale(u.getACLetturaFinale());
		model.setConsumoTotale(u.getACConsumoTotale());
		return model;
	});

	public static ObjectConverter<RowAcquaReintegroModel, RowAcquaReintegro> tipo1BModelToDto = new ObjectConverter<>(u -> {
		RowAcquaReintegro dto = new RowAcquaReintegro();
		dto.setACUnitaMisura(u.getUnitaMisura());
		dto.setACEsercizio(u.getEsercizio());
		dto.setACLetturaIniziale(u.getLetturaIniziale());
		dto.setACLetturaFinale(u.getLetturaFinale());
		dto.setACConsumoTotale(u.getConsumoTotale());
		return dto;
	});

	protected int unitaMisura;
	protected BigInteger esercizio;
	protected BigInteger letturaIniziale;
	protected BigInteger letturaFinale;
	protected BigDecimal consumoTotale;

	public RowAcquaReintegroModel() {
	}

	public RowAcquaReintegroModel(int acUnitaMisura, BigInteger esercizio, BigInteger letturaIniziale, BigInteger letturaFinale, BigDecimal consumoTotale) {
		this.unitaMisura = acUnitaMisura;
		this.esercizio = esercizio;
		this.letturaIniziale = letturaIniziale;
		this.letturaFinale = letturaFinale;
		this.consumoTotale = consumoTotale;
	}

	public int getUnitaMisura() {
		return unitaMisura;
	}

	public void setUnitaMisura(int acUnitaMisura) {
		this.unitaMisura = acUnitaMisura;
	}

	public BigInteger getEsercizio() {
		return esercizio;
	}

	public void setEsercizio(BigInteger esercizio) {
		this.esercizio = esercizio;
	}

	public BigInteger getLetturaIniziale() {
		return letturaIniziale;
	}

	public void setLetturaIniziale(BigInteger letturaIniziale) {
		this.letturaIniziale = letturaIniziale;
	}

	public BigInteger getLetturaFinale() {
		return letturaFinale;
	}

	public void setLetturaFinale(BigInteger letturaFinale) {
		this.letturaFinale = letturaFinale;
	}

	public BigDecimal getConsumoTotale() {
		return consumoTotale;
	}

	public void setConsumoTotale(BigDecimal consumoTotale) {
		this.consumoTotale = consumoTotale;
	}

	@Override
	public String toString() {
		return "RowAcquaReintegroModel{" + "unitaMisura=" + unitaMisura + ", esercizio=" + esercizio + ", letturaIniziale=" + letturaIniziale + ", letturaFinale=" + letturaFinale
				+ ", consumoTotale=" + consumoTotale + '}';
	}
}
