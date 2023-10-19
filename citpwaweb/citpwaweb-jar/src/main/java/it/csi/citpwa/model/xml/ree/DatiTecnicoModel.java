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

import it.csi.citpwa.model.xsd.controllo1.DatiTecnico;
import it.csi.citpwa.util.Constants;
import it.csi.citpwa.util.DateUtil;
import it.csi.citpwa.util.ObjectConverter;

import javax.xml.datatype.DatatypeConfigurationException;
import java.text.ParseException;

public class DatiTecnicoModel {

	public static ObjectConverter<DatiTecnico, DatiTecnicoModel> tipo1DtoToModel = new ObjectConverter<>(u -> {
		DatiTecnicoModel model = new DatiTecnicoModel();
		model.setFlagFunzImp(u.isAFFlagFunzImp());
		try {
			model.setDataIntervento(DateUtil.xmlGregorianCalendarToString(u.getAFDataIntervento(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			model.setDataIntervento(null);
		}
		model.setOrarioArrivo(u.getAFOrarioArrivo());
		model.setOrarioPartenza(u.getAFOrarioPartenza());
		model.setNomeTecnico(u.getAFNomeTecnico());
		model.setCognomeTecnico(u.getAFCognomeTecnico());
		model.setFirmaTecnico(u.getAFFirmaTecnico());
		model.setFirmaResp(u.getAFFirmaResp());
		return model;
	});

	public static ObjectConverter<DatiTecnicoModel, DatiTecnico> tipo1ModelToDto = new ObjectConverter<>(u -> {
		DatiTecnico dto = new DatiTecnico();
		dto.setAFFlagFunzImp(u.isFlagFunzImp());
		try {
			dto.setAFDataIntervento(DateUtil.stringToXMLGregorianCalendar(u.getDataIntervento(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			dto.setAFDataIntervento(null);
		}
		dto.setAFOrarioArrivo(u.getOrarioArrivo());
		dto.setAFOrarioPartenza(u.getOrarioPartenza());
		dto.setAFNomeTecnico(u.getNomeTecnico());
		dto.setAFCognomeTecnico(u.getCognomeTecnico());
		dto.setAFFirmaTecnico(u.getFirmaTecnico());
		dto.setAFFirmaResp(u.getFirmaResp());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo1B.DatiTecnico, DatiTecnicoModel> tipo1BDtoToModel = new ObjectConverter<>(u -> {
		DatiTecnicoModel model = new DatiTecnicoModel();
		model.setFlagFunzImp(u.isAFFlagFunzImp());
		try {
			model.setDataIntervento(DateUtil.xmlGregorianCalendarToString(u.getAFDataIntervento(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			model.setDataIntervento(null);
		}
		model.setOrarioArrivo(u.getAFOrarioArrivo());
		model.setOrarioPartenza(u.getAFOrarioPartenza());
		model.setNomeTecnico(u.getAFNomeTecnico());
		model.setCognomeTecnico(u.getAFCognomeTecnico());
		model.setFirmaTecnico(u.getAFFirmaTecnico());
		model.setFirmaResp(u.getAFFirmaResp());
		return model;
	});

	public static ObjectConverter<DatiTecnicoModel, it.csi.citpwa.model.xsd.controllo1B.DatiTecnico> tipo1BModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo1B.DatiTecnico dto = new it.csi.citpwa.model.xsd.controllo1B.DatiTecnico();
		dto.setAFFlagFunzImp(u.isFlagFunzImp());
		try {
			dto.setAFDataIntervento(DateUtil.stringToXMLGregorianCalendar(u.getDataIntervento(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			dto.setAFDataIntervento(null);
		}
		dto.setAFOrarioArrivo(u.getOrarioArrivo());
		dto.setAFOrarioPartenza(u.getOrarioPartenza());
		dto.setAFNomeTecnico(u.getNomeTecnico());
		dto.setAFCognomeTecnico(u.getCognomeTecnico());
		dto.setAFFirmaTecnico(u.getFirmaTecnico());
		dto.setAFFirmaResp(u.getFirmaResp());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo2.DatiTecnico, DatiTecnicoModel> tipo2DtoToModel = new ObjectConverter<>(u -> {
		DatiTecnicoModel model = new DatiTecnicoModel();
		model.setFlagFunzImp(u.isAFFlagFunzImp());
		try {
			model.setDataIntervento(DateUtil.xmlGregorianCalendarToString(u.getAFDataIntervento(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			model.setDataIntervento(null);
		}
		model.setOrarioArrivo(u.getAFOrarioArrivo());
		model.setOrarioPartenza(u.getAFOrarioPartenza());
		model.setNomeTecnico(u.getAFNomeTecnico());
		model.setCognomeTecnico(u.getAFCognomeTecnico());
		model.setFirmaTecnico(u.getAFFirmaTecnico());
		model.setFirmaResp(u.getAFFirmaResp());
		return model;
	});

	public static ObjectConverter<DatiTecnicoModel, it.csi.citpwa.model.xsd.controllo2.DatiTecnico> tipo2ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo2.DatiTecnico dto = new it.csi.citpwa.model.xsd.controllo2.DatiTecnico();
		dto.setAFFlagFunzImp(u.isFlagFunzImp());
		try {
			dto.setAFDataIntervento(DateUtil.stringToXMLGregorianCalendar(u.getDataIntervento(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			dto.setAFDataIntervento(null);
		}
		dto.setAFOrarioArrivo(u.getOrarioArrivo());
		dto.setAFOrarioPartenza(u.getOrarioPartenza());
		dto.setAFNomeTecnico(u.getNomeTecnico());
		dto.setAFCognomeTecnico(u.getCognomeTecnico());
		dto.setAFFirmaTecnico(u.getFirmaTecnico());
		dto.setAFFirmaResp(u.getFirmaResp());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo3.DatiTecnico, DatiTecnicoModel> tipo3DtoToModel = new ObjectConverter<>(u -> {
		DatiTecnicoModel model = new DatiTecnicoModel();
		model.setFlagFunzImp(u.isAFFlagFunzImp());
		try {
			model.setDataIntervento(DateUtil.xmlGregorianCalendarToString(u.getAFDataIntervento(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			model.setDataIntervento(null);
		}
		model.setOrarioArrivo(u.getAFOrarioArrivo());
		model.setOrarioPartenza(u.getAFOrarioPartenza());
		model.setNomeTecnico(u.getAFNomeTecnico());
		model.setCognomeTecnico(u.getAFCognomeTecnico());
		model.setFirmaTecnico(u.getAFFirmaTecnico());
		model.setFirmaResp(u.getAFFirmaResp());
		return model;
	});

	public static ObjectConverter<DatiTecnicoModel, it.csi.citpwa.model.xsd.controllo3.DatiTecnico> tipo3ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo3.DatiTecnico dto = new it.csi.citpwa.model.xsd.controllo3.DatiTecnico();
		dto.setAFFlagFunzImp(u.isFlagFunzImp());
		try {
			dto.setAFDataIntervento(DateUtil.stringToXMLGregorianCalendar(u.getDataIntervento(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			dto.setAFDataIntervento(null);
		}
		dto.setAFOrarioArrivo(u.getOrarioArrivo());
		dto.setAFOrarioPartenza(u.getOrarioPartenza());
		dto.setAFNomeTecnico(u.getNomeTecnico());
		dto.setAFCognomeTecnico(u.getCognomeTecnico());
		dto.setAFFirmaTecnico(u.getFirmaTecnico());
		dto.setAFFirmaResp(u.getFirmaResp());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo4.DatiTecnico, DatiTecnicoModel> tipo4DtoToModel = new ObjectConverter<>(u -> {
		DatiTecnicoModel model = new DatiTecnicoModel();
		model.setFlagFunzImp(u.isAFFlagFunzImp());
		try {
			model.setDataIntervento(DateUtil.xmlGregorianCalendarToString(u.getAFDataIntervento(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			model.setDataIntervento(null);
		}
		model.setOrarioArrivo(u.getAFOrarioArrivo());
		model.setOrarioPartenza(u.getAFOrarioPartenza());
		model.setNomeTecnico(u.getAFNomeTecnico());
		model.setCognomeTecnico(u.getAFCognomeTecnico());
		model.setFirmaTecnico(u.getAFFirmaTecnico());
		model.setFirmaResp(u.getAFFirmaResp());
		return model;
	});

	public static ObjectConverter<DatiTecnicoModel, it.csi.citpwa.model.xsd.controllo4.DatiTecnico> tipo4ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo4.DatiTecnico dto = new it.csi.citpwa.model.xsd.controllo4.DatiTecnico();
		dto.setAFFlagFunzImp(u.isFlagFunzImp());
		try {
			dto.setAFDataIntervento(DateUtil.stringToXMLGregorianCalendar(u.getDataIntervento(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			dto.setAFDataIntervento(null);
		}
		dto.setAFOrarioArrivo(u.getOrarioArrivo());
		dto.setAFOrarioPartenza(u.getOrarioPartenza());
		dto.setAFNomeTecnico(u.getNomeTecnico());
		dto.setAFCognomeTecnico(u.getCognomeTecnico());
		dto.setAFFirmaTecnico(u.getFirmaTecnico());
		dto.setAFFirmaResp(u.getFirmaResp());
		return dto;
	});

	protected boolean flagFunzImp;
	protected String dataIntervento;
	protected String orarioArrivo;
	protected String orarioPartenza;
	protected String nomeTecnico;
	protected String cognomeTecnico;
	protected String firmaTecnico;
	protected String firmaResp;

	public DatiTecnicoModel() {
	}

	public DatiTecnicoModel(boolean flagFunzImp, String dataIntervento, String orarioArrivo, String orarioPartenza, String nomeTecnico, String cognomeTecnico, String firmaTecnico, String firmaResp) {
		this.flagFunzImp = flagFunzImp;
		this.dataIntervento = dataIntervento;
		this.orarioArrivo = orarioArrivo;
		this.orarioPartenza = orarioPartenza;
		this.nomeTecnico = nomeTecnico;
		this.cognomeTecnico = cognomeTecnico;
		this.firmaTecnico = firmaTecnico;
		this.firmaResp = firmaResp;
	}

	public boolean isFlagFunzImp() {
		return flagFunzImp;
	}

	public void setFlagFunzImp(boolean flagFunzImp) {
		this.flagFunzImp = flagFunzImp;
	}

	public String getDataIntervento() {
		return dataIntervento;
	}

	public void setDataIntervento(String dataIntervento) {
		this.dataIntervento = dataIntervento;
	}

	public String getOrarioArrivo() {
		return orarioArrivo;
	}

	public void setOrarioArrivo(String orarioArrivo) {
		this.orarioArrivo = orarioArrivo;
	}

	public String getOrarioPartenza() {
		return orarioPartenza;
	}

	public void setOrarioPartenza(String orarioPartenza) {
		this.orarioPartenza = orarioPartenza;
	}

	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}

	public String getCognomeTecnico() {
		return cognomeTecnico;
	}

	public void setCognomeTecnico(String cognomeTecnico) {
		this.cognomeTecnico = cognomeTecnico;
	}

	public String getFirmaTecnico() {
		return firmaTecnico;
	}

	public void setFirmaTecnico(String firmaTecnico) {
		this.firmaTecnico = firmaTecnico;
	}

	public String getFirmaResp() {
		return firmaResp;
	}

	public void setFirmaResp(String firmaResp) {
		this.firmaResp = firmaResp;
	}

	@Override
	public String toString() {
		return "DatiTecnicoModel{" + "flagFunzImp=" + flagFunzImp + ", dataIntervento='" + dataIntervento + '\'' + ", orarioArrivo='" + orarioArrivo + '\'' + ", orarioPartenza='" + orarioPartenza
				+ '\'' + ", nomeTecnico='" + nomeTecnico + '\'' + ", cognomeTecnico='" + cognomeTecnico + '\'' + ", firmaTecnico='" + firmaTecnico + '\'' + ", firmaResp='" + firmaResp + '\'' + '}';
	}
}
