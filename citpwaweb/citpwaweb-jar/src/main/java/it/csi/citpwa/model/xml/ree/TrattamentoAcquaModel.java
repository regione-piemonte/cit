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

import it.csi.citpwa.model.xsd.controllo1.TrattamentoAcqua;
import it.csi.citpwa.util.ObjectConverter;

public class TrattamentoAcquaModel {

	public static ObjectConverter<TrattamentoAcqua, TrattamentoAcquaModel> tipo1DtoToModel = new ObjectConverter<>(u -> {
		TrattamentoAcquaModel model = new TrattamentoAcquaModel();
		model.setFlagTrattAcsNR(!u.isACFlagTrattAcsNR());
		model.setFlagTrattH2ONR(!u.isACFlagTrattH2ONR());
		return model;
	});

	public static ObjectConverter<TrattamentoAcquaModel, TrattamentoAcqua> tipo1ModelToDto = new ObjectConverter<>(u -> {
		TrattamentoAcqua dto = new TrattamentoAcqua();
		dto.setACFlagTrattAcsNR(!u.isFlagTrattAcsNR());
		dto.setACFlagTrattH2ONR(!u.isFlagTrattH2ONR());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo1B.TrattamentoAcqua, TrattamentoAcquaModel> tipo1BDtoToModel = new ObjectConverter<>(u -> {
		TrattamentoAcquaModel model = new TrattamentoAcquaModel();
		model.setFlagTrattAcsNR(!u.isACFlagTrattAcsNR());
		model.setFlagTrattH2ONR(!u.isACFlagTrattH2ONR());
		return model;
	});

	public static ObjectConverter<TrattamentoAcquaModel, it.csi.citpwa.model.xsd.controllo1B.TrattamentoAcqua> tipo1BModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo1B.TrattamentoAcqua dto = new it.csi.citpwa.model.xsd.controllo1B.TrattamentoAcqua();
		dto.setACFlagTrattAcsNR(!u.isFlagTrattAcsNR());
		dto.setACFlagTrattH2ONR(!u.isFlagTrattH2ONR());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo2.TrattamentoAcqua, TrattamentoAcquaModel> tipo2DtoToModel = new ObjectConverter<>(u -> {
		TrattamentoAcquaModel model = new TrattamentoAcquaModel();
		model.setFlagTrattH2ONR(!u.isACFlagTrattH2ONR());
		return model;
	});

	public static ObjectConverter<TrattamentoAcquaModel, it.csi.citpwa.model.xsd.controllo2.TrattamentoAcqua> tipo2ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo2.TrattamentoAcqua dto = new it.csi.citpwa.model.xsd.controllo2.TrattamentoAcqua();
		dto.setACFlagTrattH2ONR(!u.isFlagTrattH2ONR());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo3.TrattamentoAcqua, TrattamentoAcquaModel> tipo3DtoToModel = new ObjectConverter<>(u -> {
		TrattamentoAcquaModel model = new TrattamentoAcquaModel();
		model.setFlagTrattAcsNR(!u.isACFlagTrattAcsNR());
		model.setFlagTrattH2ONR(!u.isACFlagTrattH2ONR());
		return model;
	});

	public static ObjectConverter<TrattamentoAcquaModel, it.csi.citpwa.model.xsd.controllo3.TrattamentoAcqua> tipo3ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo3.TrattamentoAcqua dto = new it.csi.citpwa.model.xsd.controllo3.TrattamentoAcqua();
		dto.setACFlagTrattAcsNR(!u.isFlagTrattAcsNR());
		dto.setACFlagTrattH2ONR(!u.isFlagTrattH2ONR());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo4.TrattamentoAcqua, TrattamentoAcquaModel> tipo4DtoToModel = new ObjectConverter<>(u -> {
		TrattamentoAcquaModel model = new TrattamentoAcquaModel();
		model.setFlagTrattH2ONR(!u.isACFlagTrattH2ONR());
		return model;
	});

	public static ObjectConverter<TrattamentoAcquaModel, it.csi.citpwa.model.xsd.controllo4.TrattamentoAcqua> tipo4ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo4.TrattamentoAcqua dto = new it.csi.citpwa.model.xsd.controllo4.TrattamentoAcqua();
		dto.setACFlagTrattH2ONR(!u.isFlagTrattH2ONR());
		return dto;
	});

	protected boolean flagTrattH2ONR;
	protected boolean flagTrattAcsNR;

	protected TabAcquaReintegroModel tabAcquaReintegro;

	public TrattamentoAcquaModel() {
	}

	public TrattamentoAcquaModel(boolean flagTrattH2ONR, boolean flagTrattAcsNR, TabAcquaReintegroModel tabAcquaReintegro) {
		this.flagTrattH2ONR = flagTrattH2ONR;
		this.flagTrattAcsNR = flagTrattAcsNR;
		this.tabAcquaReintegro = tabAcquaReintegro;
	}

	public boolean isFlagTrattH2ONR() {
		return flagTrattH2ONR;
	}

	public void setFlagTrattH2ONR(boolean flagTrattH2ONR) {
		this.flagTrattH2ONR = flagTrattH2ONR;
	}

	public boolean isFlagTrattAcsNR() {
		return flagTrattAcsNR;
	}

	public void setFlagTrattAcsNR(boolean flagTrattAcsNR) {
		this.flagTrattAcsNR = flagTrattAcsNR;
	}

	public TabAcquaReintegroModel getTabAcquaReintegro() {
		return tabAcquaReintegro;
	}

	public void setTabAcquaReintegro(TabAcquaReintegroModel tabAcquaReintegro) {
		this.tabAcquaReintegro = tabAcquaReintegro;
	}

	@Override
	public String toString() {
		return "TrattamentoAcquaModel{" + "flagTrattH2ONR=" + flagTrattH2ONR + ", flagTrattAcsNR=" + flagTrattAcsNR + ", tabAcquaReintegro=" + tabAcquaReintegro + '}';
	}
}
