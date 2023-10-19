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

import it.csi.citpwa.model.xsd.controllo1.DatiIntestazione;
import it.csi.citpwa.util.Constants;
import it.csi.citpwa.util.DateUtil;
import it.csi.citpwa.util.ObjectConverter;

import javax.xml.datatype.DatatypeConfigurationException;
import java.text.ParseException;

public class DatiIntestazioneModel {

	public static ObjectConverter<DatiIntestazione, DatiIntestazioneModel> tipo1DtoToModel = new ObjectConverter<>(u -> {
		DatiIntestazioneModel model = new DatiIntestazioneModel();
		try {
			model.setDataControllo(DateUtil.xmlGregorianCalendarToString(u.getAFDataControllo(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			model.setDataControllo(null);
		}
		model.setCodiceBollino(u.getCodiceBollino());
		model.setCodiceCatasto(u.getCodiceCatasto());
		return model;
	});

	public static ObjectConverter<DatiIntestazioneModel, DatiIntestazione> tipo1ModelToDto = new ObjectConverter<>(u -> {
		DatiIntestazione dto = new DatiIntestazione();
		try {
			dto.setAFDataControllo(DateUtil.stringToXMLGregorianCalendar(u.getDataControllo(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			dto.setAFDataControllo(null);
		}
		dto.setCodiceBollino(u.getCodiceBollino());
		dto.setCodiceCatasto(u.getCodiceCatasto());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo1B.DatiIntestazione, DatiIntestazioneModel> tipo1BDtoToModel = new ObjectConverter<>(u -> {
		DatiIntestazioneModel model = new DatiIntestazioneModel();
		try {
			model.setDataControllo(DateUtil.xmlGregorianCalendarToString(u.getAFDataControllo(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			model.setDataControllo(null);
		}
		model.setCodiceBollino(u.getCodiceBollino());
		model.setCodiceCatasto(u.getCodiceCatasto());
		return model;
	});

	public static ObjectConverter<DatiIntestazioneModel, it.csi.citpwa.model.xsd.controllo1B.DatiIntestazione> tipo1BModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo1B.DatiIntestazione dto = new it.csi.citpwa.model.xsd.controllo1B.DatiIntestazione();
		try {
			dto.setAFDataControllo(DateUtil.stringToXMLGregorianCalendar(u.getDataControllo(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			dto.setAFDataControllo(null);
		}
		dto.setCodiceBollino(u.getCodiceBollino());
		dto.setCodiceCatasto(u.getCodiceCatasto());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo2.DatiIntestazione, DatiIntestazioneModel> tipo2DtoToModel = new ObjectConverter<>(u -> {
		DatiIntestazioneModel model = new DatiIntestazioneModel();
		try {
			model.setDataControllo(DateUtil.xmlGregorianCalendarToString(u.getAFDataControllo(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			model.setDataControllo(null);
		}
		model.setCodiceBollino(u.getCodiceBollino());
		model.setCodiceCatasto(u.getCodiceCatasto());
		return model;
	});

	public static ObjectConverter<DatiIntestazioneModel, it.csi.citpwa.model.xsd.controllo2.DatiIntestazione> tipo2ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo2.DatiIntestazione dto = new it.csi.citpwa.model.xsd.controllo2.DatiIntestazione();
		try {
			dto.setAFDataControllo(DateUtil.stringToXMLGregorianCalendar(u.getDataControllo(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			dto.setAFDataControllo(null);
		}
		dto.setCodiceBollino(u.getCodiceBollino());
		dto.setCodiceCatasto(u.getCodiceCatasto());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo3.DatiIntestazione, DatiIntestazioneModel> tipo3DtoToModel = new ObjectConverter<>(u -> {
		DatiIntestazioneModel model = new DatiIntestazioneModel();
		try {
			model.setDataControllo(DateUtil.xmlGregorianCalendarToString(u.getAFDataControllo(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			model.setDataControllo(null);
		}
		model.setCodiceBollino(u.getCodiceBollino());
		model.setCodiceCatasto(u.getCodiceCatasto());
		return model;
	});

	public static ObjectConverter<DatiIntestazioneModel, it.csi.citpwa.model.xsd.controllo3.DatiIntestazione> tipo3ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo3.DatiIntestazione dto = new it.csi.citpwa.model.xsd.controllo3.DatiIntestazione();
		try {
			dto.setAFDataControllo(DateUtil.stringToXMLGregorianCalendar(u.getDataControllo(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			dto.setAFDataControllo(null);
		}
		dto.setCodiceBollino(u.getCodiceBollino());
		dto.setCodiceCatasto(u.getCodiceCatasto());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo4.DatiIntestazione, DatiIntestazioneModel> tipo4DtoToModel = new ObjectConverter<>(u -> {
		DatiIntestazioneModel model = new DatiIntestazioneModel();
		try {
			model.setDataControllo(DateUtil.xmlGregorianCalendarToString(u.getAFDataControllo(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			model.setDataControllo(null);
		}
		model.setCodiceBollino(u.getCodiceBollino());
		model.setCodiceCatasto(u.getCodiceCatasto());
		return model;
	});

	public static ObjectConverter<DatiIntestazioneModel, it.csi.citpwa.model.xsd.controllo4.DatiIntestazione> tipo4ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo4.DatiIntestazione dto = new it.csi.citpwa.model.xsd.controllo4.DatiIntestazione();
		try {
			dto.setAFDataControllo(DateUtil.stringToXMLGregorianCalendar(u.getDataControllo(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			dto.setAFDataControllo(null);
		}
		dto.setCodiceBollino(u.getCodiceBollino());
		dto.setCodiceCatasto(u.getCodiceCatasto());
		return dto;
	});

	protected String codiceBollino;
	protected String codiceCatasto;
	protected String dataControllo;

	public DatiIntestazioneModel() {
	}

	public DatiIntestazioneModel(String codiceBollino, String codiceCatasto, String afDataControllo) {
		this.codiceBollino = codiceBollino;
		this.codiceCatasto = codiceCatasto;
		this.dataControllo = afDataControllo;
	}

	public String getCodiceBollino() {
		return codiceBollino;
	}

	public void setCodiceBollino(String value) {
		this.codiceBollino = value;
	}

	public String getCodiceCatasto() {
		return codiceCatasto;
	}

	public void setCodiceCatasto(String value) {
		this.codiceCatasto = value;
	}

	public String getDataControllo() {
		return dataControllo;
	}

	public void setDataControllo(String value) {
		this.dataControllo = value;
	}

	@Override
	public String toString() {
		return "DatiIntestazioneModel{" + "codiceBollino='" + codiceBollino + '\'' + ", codiceCatasto='" + codiceCatasto + '\'' + ", afDataControllo=" + dataControllo + '}';
	}
}
