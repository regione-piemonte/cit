/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.2 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.09.29 alle 03:15:24 PM CEST 
//

package it.csi.citpwa.model.xml.ree;

import it.csi.citpwa.model.xsd.controllo1.ControlloImpianto;
import it.csi.citpwa.util.ObjectConverter;

import java.math.BigInteger;

public class ControlloImpiantoModel {

	public static ObjectConverter<ControlloImpianto, ControlloImpiantoModel> tipo1DtoToModel = new ObjectConverter<>(u -> {
		ControlloImpiantoModel model = new ControlloImpiantoModel();
		model.setFlagInterno(u.getADFlagInterno());
		model.setFlagCanaleFumo(u.getADFlagCanaleFumo());
		model.setFlagEsterno(u.getADFlagEsterno());
		model.setFlagSistRegolaz(u.getADFlagSistRegolaz());
		model.setFlagAperture(u.getADFlagAperture());
		model.setFlagPerdite(u.getADFlagPerdite());
		model.setFlagDimensioni(u.getADFlagDimensioni());
		model.setFlagTenuta(u.getADFlagTenuta());
		return model;
	});

	public static ObjectConverter<ControlloImpiantoModel, ControlloImpianto> tipo1ModelToDto = new ObjectConverter<>(u -> {
		ControlloImpianto dto = new ControlloImpianto();
		dto.setADFlagInterno(u.getFlagInterno());
		dto.setADFlagCanaleFumo(u.getFlagCanaleFumo());
		dto.setADFlagEsterno(u.getFlagEsterno());
		dto.setADFlagSistRegolaz(u.getFlagSistRegolaz());
		dto.setADFlagAperture(u.getFlagAperture());
		dto.setADFlagPerdite(u.getFlagPerdite());
		dto.setADFlagDimensioni(u.getFlagDimensioni());
		dto.setADFlagTenuta(u.getFlagTenuta());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo1B.ControlloImpianto, ControlloImpiantoModel> tipo1BDtoToModel = new ObjectConverter<>(u -> {
		ControlloImpiantoModel model = new ControlloImpiantoModel();
		model.setFlagInterno(u.getADFlagInterno());
		model.setFlagCanaleFumo(u.getADFlagCanaleFumo());
		model.setFlagEsterno(u.getADFlagEsterno());
		model.setFlagSistRegolaz(u.getADFlagSistRegolaz());
		model.setFlagAperture(u.getADFlagAperture());
		model.setFlagPuliziaCamino(u.getADFlagPuliziaCamino());
		model.setFlagDimensioni(u.getADFlagDimensioni());
		model.setFlagTenuta(u.getADFlagTenuta());
		return model;
	});

	public static ObjectConverter<ControlloImpiantoModel, it.csi.citpwa.model.xsd.controllo1B.ControlloImpianto> tipo1BModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo1B.ControlloImpianto dto = new it.csi.citpwa.model.xsd.controllo1B.ControlloImpianto();
		dto.setADFlagInterno(u.getFlagInterno());
		dto.setADFlagCanaleFumo(u.getFlagCanaleFumo());
		dto.setADFlagEsterno(u.getFlagEsterno());
		dto.setADFlagSistRegolaz(u.getFlagSistRegolaz());
		dto.setADFlagAperture(u.getFlagAperture());
		dto.setADFlagPuliziaCamino(u.getFlagPuliziaCamino());
		dto.setADFlagDimensioni(u.getFlagDimensioni());
		dto.setADFlagTenuta(u.getFlagTenuta());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo2.ControlloImpianto, ControlloImpiantoModel> tipo2DtoToModel = new ObjectConverter<>(u -> {
		ControlloImpiantoModel model = new ControlloImpiantoModel();
		model.setFlagAperture(u.getADFlagAperture());
		model.setFlagDimensioni(u.getADFlagDimensioni());
		//Tipo2
		model.setFlagLocaleIdoneo(u.getADFlagLocaleIdoneo());
		model.setFlagCoibenIdonee(u.getADFlagCoibenIdonee());
		model.setFlagLineeIdonee(u.getADFlagLineeIdonee());
		return model;
	});

	public static ObjectConverter<ControlloImpiantoModel, it.csi.citpwa.model.xsd.controllo2.ControlloImpianto> tipo2ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo2.ControlloImpianto dto = new it.csi.citpwa.model.xsd.controllo2.ControlloImpianto();
		dto.setADFlagAperture(u.getFlagAperture());
		dto.setADFlagDimensioni(u.getFlagDimensioni());
		//Tipo2
		dto.setADFlagLocaleIdoneo(u.getFlagLocaleIdoneo());
		dto.setADFlagCoibenIdonee(u.getFlagCoibenIdonee());
		dto.setADFlagLineeIdonee(u.getFlagLineeIdonee());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo3.ControlloImpianto, ControlloImpiantoModel> tipo3DtoToModel = new ObjectConverter<>(u -> {
		ControlloImpiantoModel model = new ControlloImpiantoModel();
		model.setFlagLuogoIdoneo(u.getADFlagLuogoIdoneo());
		model.setFlagLineeIdonee(u.getADFlagLineeIdonee());
		model.setFlagStatoCoiben(u.getADFlagStatoCoiben());
		model.setFlagPerdite(u.getADFlagPerdite());
		return model;
	});

	public static ObjectConverter<ControlloImpiantoModel, it.csi.citpwa.model.xsd.controllo3.ControlloImpianto> tipo3ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo3.ControlloImpianto dto = new it.csi.citpwa.model.xsd.controllo3.ControlloImpianto();
		dto.setADFlagLuogoIdoneo(u.getFlagLuogoIdoneo());
		dto.setADFlagLineeIdonee(u.getFlagLineeIdonee());
		dto.setADFlagStatoCoiben(u.getFlagStatoCoiben());
		dto.setADFlagPerdite(u.getFlagPerdite());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo4.ControlloImpianto, ControlloImpiantoModel> tipo4DtoToModel = new ObjectConverter<>(u -> {
		ControlloImpiantoModel model = new ControlloImpiantoModel();
		model.setFlagLuogoIdoneo(u.getADFlagLuogoIdoneo());
		model.setFlagDimensioni(u.getADFlagDimensioni());
		model.setFlagAperture(u.getADFlagAperture());
		model.setFlagLineeIdonee(u.getADFlagLineeIdonee());
		model.setFlagCanaleFumo(u.getADFlagCanaleFumo());
		model.setFlagCapsulaInso(u.getADFlagCapsulaInso());
		model.setFlagTenutaIdraulica(u.getADFlagTenutaIdraulica());
		model.setFlagTenutaOlio(u.getADFlagTenutaOlio());
		model.setFlagTenutaAlimentaz(u.getADFlagTenutaAlimentaz());
		model.setFlagFunzionalita(u.getADFlagFunzionalita());
		return model;
	});

	public static ObjectConverter<ControlloImpiantoModel, it.csi.citpwa.model.xsd.controllo4.ControlloImpianto> tipo4ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo4.ControlloImpianto dto = new it.csi.citpwa.model.xsd.controllo4.ControlloImpianto();
		dto.setADFlagLuogoIdoneo(u.getFlagLuogoIdoneo());
		dto.setADFlagDimensioni(u.getFlagDimensioni());
		dto.setADFlagAperture(u.getFlagAperture());
		dto.setADFlagLineeIdonee(u.getFlagLineeIdonee());
		dto.setADFlagCanaleFumo(u.getFlagCanaleFumo());
		dto.setADFlagCapsulaInso(u.getFlagCapsulaInso());
		dto.setADFlagTenutaIdraulica(u.getFlagTenutaIdraulica());
		dto.setADFlagTenutaOlio(u.getFlagTenutaOlio());
		dto.setADFlagTenutaAlimentaz(u.getFlagTenutaAlimentaz());
		dto.setADFlagFunzionalita(u.getFlagFunzionalita());
		return dto;
	});

	protected BigInteger flagInterno;
	protected BigInteger flagCanaleFumo;
	protected BigInteger flagEsterno;
	protected BigInteger flagSistRegolaz;
	protected BigInteger flagAperture;
	protected BigInteger flagPerdite;
	protected BigInteger flagDimensioni;
	protected BigInteger flagTenuta;
	//TIPO1B
	protected BigInteger flagPuliziaCamino;
	//TIPO 2
	protected BigInteger flagLocaleIdoneo;
	protected BigInteger flagLineeIdonee;
	protected BigInteger flagCoibenIdonee;

	//TIPO 3
	protected BigInteger flagLuogoIdoneo;
	protected BigInteger flagStatoCoiben;

	//TIPO4
	protected BigInteger flagCapsulaInso;
	protected BigInteger flagTenutaIdraulica;
	protected BigInteger flagTenutaOlio;
	protected BigInteger flagTenutaAlimentaz;
	protected BigInteger flagFunzionalita;

	public ControlloImpiantoModel() {
	}

	public ControlloImpiantoModel(BigInteger flagInterno, BigInteger flagCanaleFumo, BigInteger flagEsterno, BigInteger flagSistRegolaz, BigInteger flagAperture, BigInteger flagPerdite, BigInteger flagDimensioni, BigInteger flagTenuta, BigInteger flagPuliziaCamino, BigInteger flagLocaleIdoneo, BigInteger flagLineeIdonee, BigInteger flagCoibenIdonee, BigInteger flagLuogoIdoneo, BigInteger flagStatoCoiben, BigInteger flagCapsulaInso, BigInteger flagTenutaIdraulica, BigInteger flagTenutaOlio, BigInteger flagTenutaAlimentaz, BigInteger flagFunzionalita) {
		this.flagInterno = flagInterno;
		this.flagCanaleFumo = flagCanaleFumo;
		this.flagEsterno = flagEsterno;
		this.flagSistRegolaz = flagSistRegolaz;
		this.flagAperture = flagAperture;
		this.flagPerdite = flagPerdite;
		this.flagDimensioni = flagDimensioni;
		this.flagTenuta = flagTenuta;
		this.flagPuliziaCamino = flagPuliziaCamino;
		this.flagLocaleIdoneo = flagLocaleIdoneo;
		this.flagLineeIdonee = flagLineeIdonee;
		this.flagCoibenIdonee = flagCoibenIdonee;
		this.flagLuogoIdoneo = flagLuogoIdoneo;
		this.flagStatoCoiben = flagStatoCoiben;
		this.flagCapsulaInso = flagCapsulaInso;
		this.flagTenutaIdraulica = flagTenutaIdraulica;
		this.flagTenutaOlio = flagTenutaOlio;
		this.flagTenutaAlimentaz = flagTenutaAlimentaz;
		this.flagFunzionalita = flagFunzionalita;
	}

	public BigInteger getFlagInterno() {
		return flagInterno;
	}

	public void setFlagInterno(BigInteger flagInterno) {
		this.flagInterno = flagInterno;
	}

	public BigInteger getFlagCanaleFumo() {
		return flagCanaleFumo;
	}

	public void setFlagCanaleFumo(BigInteger flagCanaleFumo) {
		this.flagCanaleFumo = flagCanaleFumo;
	}

	public BigInteger getFlagEsterno() {
		return flagEsterno;
	}

	public void setFlagEsterno(BigInteger flagEsterno) {
		this.flagEsterno = flagEsterno;
	}

	public BigInteger getFlagSistRegolaz() {
		return flagSistRegolaz;
	}

	public void setFlagSistRegolaz(BigInteger flagSistRegolaz) {
		this.flagSistRegolaz = flagSistRegolaz;
	}

	public BigInteger getFlagAperture() {
		return flagAperture;
	}

	public void setFlagAperture(BigInteger flagAperture) {
		this.flagAperture = flagAperture;
	}

	public BigInteger getFlagPerdite() {
		return flagPerdite;
	}

	public void setFlagPerdite(BigInteger flagPerdite) {
		this.flagPerdite = flagPerdite;
	}

	public BigInteger getFlagDimensioni() {
		return flagDimensioni;
	}

	public void setFlagDimensioni(BigInteger flagDimensioni) {
		this.flagDimensioni = flagDimensioni;
	}

	public BigInteger getFlagTenuta() {
		return flagTenuta;
	}

	public void setFlagTenuta(BigInteger flagTenuta) {
		this.flagTenuta = flagTenuta;
	}

	public BigInteger getFlagPuliziaCamino() {
		return flagPuliziaCamino;
	}

	public void setFlagPuliziaCamino(BigInteger flagPuliziaCamino) {
		this.flagPuliziaCamino = flagPuliziaCamino;
	}

	public BigInteger getFlagLocaleIdoneo() {
		return flagLocaleIdoneo;
	}

	public void setFlagLocaleIdoneo(BigInteger flagLocaleIdoneo) {
		this.flagLocaleIdoneo = flagLocaleIdoneo;
	}

	public BigInteger getFlagLineeIdonee() {
		return flagLineeIdonee;
	}

	public void setFlagLineeIdonee(BigInteger flagLineeIdonee) {
		this.flagLineeIdonee = flagLineeIdonee;
	}

	public BigInteger getFlagCoibenIdonee() {
		return flagCoibenIdonee;
	}

	public void setFlagCoibenIdonee(BigInteger flagCoibenIdonee) {
		this.flagCoibenIdonee = flagCoibenIdonee;
	}

	public BigInteger getFlagLuogoIdoneo() {
		return flagLuogoIdoneo;
	}

	public void setFlagLuogoIdoneo(BigInteger flagLuogoIdoneo) {
		this.flagLuogoIdoneo = flagLuogoIdoneo;
	}

	public BigInteger getFlagStatoCoiben() {
		return flagStatoCoiben;
	}

	public void setFlagStatoCoiben(BigInteger flagStatoCoiben) {
		this.flagStatoCoiben = flagStatoCoiben;
	}

	public BigInteger getFlagCapsulaInso() {
		return flagCapsulaInso;
	}

	public void setFlagCapsulaInso(BigInteger flagCapsulaInso) {
		this.flagCapsulaInso = flagCapsulaInso;
	}

	public BigInteger getFlagTenutaIdraulica() {
		return flagTenutaIdraulica;
	}

	public void setFlagTenutaIdraulica(BigInteger flagTenutaIdraulica) {
		this.flagTenutaIdraulica = flagTenutaIdraulica;
	}

	public BigInteger getFlagTenutaOlio() {
		return flagTenutaOlio;
	}

	public void setFlagTenutaOlio(BigInteger flagTenutaOlio) {
		this.flagTenutaOlio = flagTenutaOlio;
	}

	public BigInteger getFlagTenutaAlimentaz() {
		return flagTenutaAlimentaz;
	}

	public void setFlagTenutaAlimentaz(BigInteger flagTenutaAlimentaz) {
		this.flagTenutaAlimentaz = flagTenutaAlimentaz;
	}

	public BigInteger getFlagFunzionalita() {
		return flagFunzionalita;
	}

	public void setFlagFunzionalita(BigInteger flagFunzionalita) {
		this.flagFunzionalita = flagFunzionalita;
	}

	@Override
	public String toString() {
		return "ControlloImpiantoModel{" + "flagInterno=" + flagInterno + ", flagCanaleFumo=" + flagCanaleFumo + ", flagEsterno=" + flagEsterno + ", flagSistRegolaz=" + flagSistRegolaz
				+ ", flagAperture=" + flagAperture + ", flagPerdite=" + flagPerdite + ", flagDimensioni=" + flagDimensioni + ", flagTenuta=" + flagTenuta + ", flagPuliziaCamino=" + flagPuliziaCamino
				+ ", flagLocaleIdoneo=" + flagLocaleIdoneo + ", flagLineeIdonee=" + flagLineeIdonee + ", flagCoibenIdonee=" + flagCoibenIdonee + ", flagLuogoIdoneo=" + flagLuogoIdoneo
				+ ", flagStatoCoiben=" + flagStatoCoiben + ", flagCapsulaInso=" + flagCapsulaInso + ", flagTenutaIdraulica=" + flagTenutaIdraulica + ", flagTenutaOlio=" + flagTenutaOlio
				+ ", flagTenutaAlimentaz=" + flagTenutaAlimentaz + ", flagFunzionalita=" + flagFunzionalita + '}';
	}
}
