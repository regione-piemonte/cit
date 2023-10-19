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

import it.csi.citpwa.model.xsd.controllo1.DatiManutentore;
import it.csi.citpwa.util.ObjectConverter;

public class DatiManutentoreModel {

	public static ObjectConverter<DatiManutentore, DatiManutentoreModel> tipo1DtoToModel = new ObjectConverter<>(u -> {
		DatiManutentoreModel model = new DatiManutentoreModel();
		model.setCodiceFiscale(u.getCodiceFiscale());
		model.setNumeroREA(u.getNumeroREA());
		model.setSiglaREA(u.getSiglaREA());
		return model;
	});

	public static ObjectConverter<DatiManutentoreModel, DatiManutentore> tipo1ModelToDto = new ObjectConverter<>(u -> {
		DatiManutentore dto = new DatiManutentore();
		dto.setCodiceFiscale(u.getCodiceFiscale());
		dto.setNumeroREA(u.getNumeroREA());
		dto.setSiglaREA(u.getSiglaREA());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo1B.DatiManutentore, DatiManutentoreModel> tipo1BDtoToModel = new ObjectConverter<>(u -> {
		DatiManutentoreModel model = new DatiManutentoreModel();
		model.setCodiceFiscale(u.getCodiceFiscale());
		model.setNumeroREA(u.getNumeroREA());
		model.setSiglaREA(u.getSiglaREA());
		return model;
	});

	public static ObjectConverter<DatiManutentoreModel, it.csi.citpwa.model.xsd.controllo1B.DatiManutentore> tipo1BModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo1B.DatiManutentore dto = new it.csi.citpwa.model.xsd.controllo1B.DatiManutentore();
		dto.setCodiceFiscale(u.getCodiceFiscale());
		dto.setNumeroREA(u.getNumeroREA());
		dto.setSiglaREA(u.getSiglaREA());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo2.DatiManutentore, DatiManutentoreModel> tipo2DtoToModel = new ObjectConverter<>(u -> {
		DatiManutentoreModel model = new DatiManutentoreModel();
		model.setCodiceFiscale(u.getCodiceFiscale());
		model.setNumeroREA(u.getNumeroREA());
		model.setSiglaREA(u.getSiglaREA());
		return model;
	});

	public static ObjectConverter<DatiManutentoreModel, it.csi.citpwa.model.xsd.controllo2.DatiManutentore> tipo2ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo2.DatiManutentore dto = new it.csi.citpwa.model.xsd.controllo2.DatiManutentore();
		dto.setCodiceFiscale(u.getCodiceFiscale());
		dto.setNumeroREA(u.getNumeroREA());
		dto.setSiglaREA(u.getSiglaREA());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo3.DatiManutentore, DatiManutentoreModel> tipo3DtoToModel = new ObjectConverter<>(u -> {
		DatiManutentoreModel model = new DatiManutentoreModel();
		model.setCodiceFiscale(u.getCodiceFiscale());
		model.setNumeroREA(u.getNumeroREA());
		model.setSiglaREA(u.getSiglaREA());
		return model;
	});

	public static ObjectConverter<DatiManutentoreModel, it.csi.citpwa.model.xsd.controllo3.DatiManutentore> tipo3ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo3.DatiManutentore dto = new it.csi.citpwa.model.xsd.controllo3.DatiManutentore();
		dto.setCodiceFiscale(u.getCodiceFiscale());
		dto.setNumeroREA(u.getNumeroREA());
		dto.setSiglaREA(u.getSiglaREA());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo4.DatiManutentore, DatiManutentoreModel> tipo4DtoToModel = new ObjectConverter<>(u -> {
		DatiManutentoreModel model = new DatiManutentoreModel();
		model.setCodiceFiscale(u.getCodiceFiscale());
		model.setNumeroREA(u.getNumeroREA());
		model.setSiglaREA(u.getSiglaREA());
		return model;
	});

	public static ObjectConverter<DatiManutentoreModel, it.csi.citpwa.model.xsd.controllo4.DatiManutentore> tipo4ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo4.DatiManutentore dto = new it.csi.citpwa.model.xsd.controllo4.DatiManutentore();
		dto.setCodiceFiscale(u.getCodiceFiscale());
		dto.setNumeroREA(u.getNumeroREA());
		dto.setSiglaREA(u.getSiglaREA());
		return dto;
	});

	protected String siglaREA;
	protected String numeroREA;
	protected String codiceFiscale;

	public DatiManutentoreModel() {
	}

	public DatiManutentoreModel(String siglaREA, String numeroREA, String codiceFiscale) {
		this.siglaREA = siglaREA;
		this.numeroREA = numeroREA;
		this.codiceFiscale = codiceFiscale;
	}

	public String getSiglaREA() {
		return siglaREA;
	}

	public void setSiglaREA(String value) {
		this.siglaREA = value;
	}

	public String getNumeroREA() {
		return numeroREA;
	}

	public void setNumeroREA(String value) {
		this.numeroREA = value;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String value) {
		this.codiceFiscale = value;
	}

	@Override
	public String toString() {
		return "DatiManutentoreModel{" + "siglaREA='" + siglaREA + '\'' + ", numeroREA='" + numeroREA + '\'' + ", codiceFiscale='" + codiceFiscale + '\'' + '}';
	}
}
