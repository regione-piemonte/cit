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

import it.csi.citpwa.model.xsd.controllo1.DatiIdentificativi;
import it.csi.citpwa.util.ObjectConverter;

import java.math.BigDecimal;

public class DatiIdentificativiModel {

	public static ObjectConverter<DatiIdentificativi, DatiIdentificativiModel> tipo1DtoToModel = new ObjectConverter<>(u -> {
		DatiIdentificativiModel model = new DatiIdentificativiModel();
		model.setPotenzaTermicaNomTotMax(u.getAAPotenzaTermicaNomTotMax());
		return model;
	});

	public static ObjectConverter<DatiIdentificativiModel, DatiIdentificativi> tipo1ModelToDto = new ObjectConverter<>(u -> {
		DatiIdentificativi dto = new DatiIdentificativi();
		dto.setAAPotenzaTermicaNomTotMax(u.getPotenzaTermicaNomTotMax());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo1B.DatiIdentificativi, DatiIdentificativiModel> tipo1BDtoToModel = new ObjectConverter<>(u -> {
		DatiIdentificativiModel model = new DatiIdentificativiModel();
		model.setPotenzaTermicaNomTotMax(u.getAAPotenzaTermicaNomTotMax());
		return model;
	});

	public static ObjectConverter<DatiIdentificativiModel, it.csi.citpwa.model.xsd.controllo1B.DatiIdentificativi> tipo1BModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo1B.DatiIdentificativi dto = new it.csi.citpwa.model.xsd.controllo1B.DatiIdentificativi();
		dto.setAAPotenzaTermicaNomTotMax(u.getPotenzaTermicaNomTotMax());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo2.DatiIdentificativi, DatiIdentificativiModel> tipo2DtoToModel = new ObjectConverter<>(u -> {
		DatiIdentificativiModel model = new DatiIdentificativiModel();
		model.setPotenzaTermicaNomTotMax(u.getAAPotenzaTermicaNomTotMax());
		return model;
	});

	public static ObjectConverter<DatiIdentificativiModel, it.csi.citpwa.model.xsd.controllo2.DatiIdentificativi> tipo2ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo2.DatiIdentificativi dto = new it.csi.citpwa.model.xsd.controllo2.DatiIdentificativi();
		dto.setAAPotenzaTermicaNomTotMax(u.getPotenzaTermicaNomTotMax());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo3.DatiIdentificativi, DatiIdentificativiModel> tipo3DtoToModel = new ObjectConverter<>(u -> {
		DatiIdentificativiModel model = new DatiIdentificativiModel();
		model.setPotenzaTermicaNomTotMax(u.getAAPotenzaTermicaNomTotMax());
		return model;
	});

	public static ObjectConverter<DatiIdentificativiModel, it.csi.citpwa.model.xsd.controllo3.DatiIdentificativi> tipo3ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo3.DatiIdentificativi dto = new it.csi.citpwa.model.xsd.controllo3.DatiIdentificativi();
		dto.setAAPotenzaTermicaNomTotMax(u.getPotenzaTermicaNomTotMax());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo4.DatiIdentificativi, DatiIdentificativiModel> tipo4DtoToModel = new ObjectConverter<>(u -> {
		DatiIdentificativiModel model = new DatiIdentificativiModel();
		model.setPotenzaTermicaNomTotMax(u.getAAPotenzaTermicaNomTotMax());
		return model;
	});

	public static ObjectConverter<DatiIdentificativiModel, it.csi.citpwa.model.xsd.controllo4.DatiIdentificativi> tipo4ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo4.DatiIdentificativi dto = new it.csi.citpwa.model.xsd.controllo4.DatiIdentificativi();
		dto.setAAPotenzaTermicaNomTotMax(u.getPotenzaTermicaNomTotMax());
		return dto;
	});

	protected BigDecimal potenzaTermicaNomTotMax;

	public DatiIdentificativiModel() {
	}

	public DatiIdentificativiModel(BigDecimal aaPotenzaTermicaNomTotMax) {
		this.potenzaTermicaNomTotMax = aaPotenzaTermicaNomTotMax;
	}

	public BigDecimal getPotenzaTermicaNomTotMax() {
		return potenzaTermicaNomTotMax;
	}

	public void setPotenzaTermicaNomTotMax(BigDecimal value) {
		this.potenzaTermicaNomTotMax = value;
	}

	@Override
	public String toString() {
		return "DatiIdentificativiModel{" + "aaPotenzaTermicaNomTotMax=" + potenzaTermicaNomTotMax + '}';
	}
}
