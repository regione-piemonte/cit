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

import it.csi.citpwa.model.xsd.controllo1.DocumentazioneTecnica;
import it.csi.citpwa.util.ObjectConverter;

public class DocumentazioneTecnicaModel {

	public static ObjectConverter<DocumentazioneTecnica, DocumentazioneTecnicaModel> tipo1DtoToModel = new ObjectConverter<>(u -> {
		DocumentazioneTecnicaModel model = new DocumentazioneTecnicaModel();
		model.setFlagDichiarazConf(u.isABFlagDichiarazConf());
		model.setFlagLibrettoComp(u.isABFlagLibrettoComp());
		model.setFlagLibrettoImp(u.isABFlagLibrettoImp());
		model.setFlagManutGen(u.isABFlagManutGen());
		return model;
	});

	public static ObjectConverter<DocumentazioneTecnicaModel, DocumentazioneTecnica> tipo1ModelToDto = new ObjectConverter<>(u -> {
		DocumentazioneTecnica dto = new DocumentazioneTecnica();
		dto.setABFlagDichiarazConf(u.isFlagDichiarazConf());
		dto.setABFlagLibrettoComp(u.isFlagLibrettoComp());
		dto.setABFlagLibrettoImp(u.isFlagLibrettoImp());
		dto.setABFlagManutGen(u.isFlagManutGen());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo1B.DocumentazioneTecnica, DocumentazioneTecnicaModel> tipo1BDtoToModel = new ObjectConverter<>(u -> {
		DocumentazioneTecnicaModel model = new DocumentazioneTecnicaModel();
		model.setFlagDichiarazConf(u.isABFlagDichiarazConf());
		model.setFlagLibrettoComp(u.isABFlagLibrettoComp());
		model.setFlagLibrettoImp(u.isABFlagLibrettoImp());
		model.setFlagManutGen(u.isABFlagManutGen());
		return model;
	});

	public static ObjectConverter<DocumentazioneTecnicaModel, it.csi.citpwa.model.xsd.controllo1B.DocumentazioneTecnica> tipo1BModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo1B.DocumentazioneTecnica dto = new it.csi.citpwa.model.xsd.controllo1B.DocumentazioneTecnica();
		dto.setABFlagDichiarazConf(u.isFlagDichiarazConf());
		dto.setABFlagLibrettoComp(u.isFlagLibrettoComp());
		dto.setABFlagLibrettoImp(u.isFlagLibrettoImp());
		dto.setABFlagManutGen(u.isFlagManutGen());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo2.DocumentazioneTecnica, DocumentazioneTecnicaModel> tipo2DtoToModel = new ObjectConverter<>(u -> {
		DocumentazioneTecnicaModel model = new DocumentazioneTecnicaModel();
		model.setFlagDichiarazConf(u.isABFlagDichiarazConf());
		model.setFlagLibrettoComp(u.isABFlagLibrettoComp());
		model.setFlagLibrettoImp(u.isABFlagLibrettoImp());
		model.setFlagManutGen(u.isABFlagManutGen());
		return model;
	});

	public static ObjectConverter<DocumentazioneTecnicaModel, it.csi.citpwa.model.xsd.controllo2.DocumentazioneTecnica> tipo2ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo2.DocumentazioneTecnica dto = new it.csi.citpwa.model.xsd.controllo2.DocumentazioneTecnica();
		dto.setABFlagDichiarazConf(u.isFlagDichiarazConf());
		dto.setABFlagLibrettoComp(u.isFlagLibrettoComp());
		dto.setABFlagLibrettoImp(u.isFlagLibrettoImp());
		dto.setABFlagManutGen(u.isFlagManutGen());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo3.DocumentazioneTecnica, DocumentazioneTecnicaModel> tipo3DtoToModel = new ObjectConverter<>(u -> {
		DocumentazioneTecnicaModel model = new DocumentazioneTecnicaModel();
		model.setFlagDichiarazConf(u.isABFlagDichiarazConf());
		model.setFlagLibrettoComp(u.isABFlagLibrettoComp());
		model.setFlagLibrettoImp(u.isABFlagLibrettoImp());
		model.setFlagManutGen(u.isABFlagManutGen());
		return model;
	});

	public static ObjectConverter<DocumentazioneTecnicaModel, it.csi.citpwa.model.xsd.controllo3.DocumentazioneTecnica> tipo3ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo3.DocumentazioneTecnica dto = new it.csi.citpwa.model.xsd.controllo3.DocumentazioneTecnica();
		dto.setABFlagDichiarazConf(u.isFlagDichiarazConf());
		dto.setABFlagLibrettoComp(u.isFlagLibrettoComp());
		dto.setABFlagLibrettoImp(u.isFlagLibrettoImp());
		dto.setABFlagManutGen(u.isFlagManutGen());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo4.DocumentazioneTecnica, DocumentazioneTecnicaModel> tipo4DtoToModel = new ObjectConverter<>(u -> {
		DocumentazioneTecnicaModel model = new DocumentazioneTecnicaModel();
		model.setFlagDichiarazConf(u.isABFlagDichiarazConf());
		model.setFlagLibrettoComp(u.isABFlagLibrettoComp());
		model.setFlagLibrettoImp(u.isABFlagLibrettoImp());
		model.setFlagManutGen(u.isABFlagManutGen());
		return model;
	});

	public static ObjectConverter<DocumentazioneTecnicaModel, it.csi.citpwa.model.xsd.controllo4.DocumentazioneTecnica> tipo4ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo4.DocumentazioneTecnica dto = new it.csi.citpwa.model.xsd.controllo4.DocumentazioneTecnica();
		dto.setABFlagDichiarazConf(u.isFlagDichiarazConf());
		dto.setABFlagLibrettoComp(u.isFlagLibrettoComp());
		dto.setABFlagLibrettoImp(u.isFlagLibrettoImp());
		dto.setABFlagManutGen(u.isFlagManutGen());
		return dto;
	});

	protected boolean flagDichiarazConf;
	protected boolean flagManutGen;
	protected boolean flagLibrettoImp;
	protected boolean flagLibrettoComp;

	public DocumentazioneTecnicaModel() {
	}

	public DocumentazioneTecnicaModel(boolean flagDichiarazConf, boolean flagManutGen, boolean flagLibrettoImp, boolean flagLibrettoComp) {
		this.flagDichiarazConf = flagDichiarazConf;
		this.flagManutGen = flagManutGen;
		this.flagLibrettoImp = flagLibrettoImp;
		this.flagLibrettoComp = flagLibrettoComp;
	}

	public boolean isFlagDichiarazConf() {
		return flagDichiarazConf;
	}

	public void setFlagDichiarazConf(boolean flagDichiarazConf) {
		this.flagDichiarazConf = flagDichiarazConf;
	}

	public boolean isFlagManutGen() {
		return flagManutGen;
	}

	public void setFlagManutGen(boolean flagManutGen) {
		this.flagManutGen = flagManutGen;
	}

	public boolean isFlagLibrettoImp() {
		return flagLibrettoImp;
	}

	public void setFlagLibrettoImp(boolean flagLibrettoImp) {
		this.flagLibrettoImp = flagLibrettoImp;
	}

	public boolean isFlagLibrettoComp() {
		return flagLibrettoComp;
	}

	public void setFlagLibrettoComp(boolean flagLibrettoComp) {
		this.flagLibrettoComp = flagLibrettoComp;
	}

	@Override
	public String toString() {
		return "DocumentazioneTecnicaModel{" + "flagDichiarazConf=" + flagDichiarazConf + ", flagManutGen=" + flagManutGen + ", flagLibrettoImp=" + flagLibrettoImp + ", flagLibrettoComp="
				+ flagLibrettoComp + '}';
	}
}
