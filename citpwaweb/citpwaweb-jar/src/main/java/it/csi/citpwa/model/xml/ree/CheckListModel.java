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

import it.csi.citpwa.model.xsd.controllo1.CheckList;
import it.csi.citpwa.util.ObjectConverter;

public class CheckListModel {

	public static ObjectConverter<CheckList, CheckListModel> tipo1DtoToModel = new ObjectConverter<>(u -> {
		CheckListModel model = new CheckListModel();
		model.setFlagIsolamento(u.isAFFlagIsolamento());
		model.setFlagSistRegolaz(u.isAFFlagSistRegolaz());
		model.setFlagSistTrattACS(u.isAFFlagSistTrattACS());
		model.setOsservazioni(u.getAFOsservazioni());
		model.setRaccomandazioni(u.getAFRaccomandazioni());
		model.setFlagValvole(u.isAFFlagValvole());
		model.setPrescrizioni(u.getAFPrescrizioni());
		return model;
	});

	public static ObjectConverter<CheckListModel, CheckList> tipo1ModelToDto = new ObjectConverter<>(u -> {
		CheckList dto = new CheckList();
		dto.setAFFlagIsolamento(u.isFlagIsolamento());
		dto.setAFFlagSistRegolaz(u.isFlagSistRegolaz());
		dto.setAFFlagSistTrattACS(u.isFlagSistTrattACS());
		dto.setAFOsservazioni(u.getOsservazioni());
		dto.setAFRaccomandazioni(u.getRaccomandazioni());
		dto.setAFFlagValvole(u.isFlagValvole());
		dto.setAFPrescrizioni(u.getPrescrizioni());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo1B.CheckList, CheckListModel> tipo1BDtoToModel = new ObjectConverter<>(u -> {
		CheckListModel model = new CheckListModel();
		model.setFlagIsolamento(u.isAFFlagIsolamento());
		model.setFlagSistRegolaz(u.isAFFlagSistRegolaz());
		model.setFlagSistTrattACS(u.isAFFlagSistTrattACS());
		model.setOsservazioni(u.getAFOsservazioni());
		model.setRaccomandazioni(u.getAFRaccomandazioni());
		model.setFlagValvole(u.isAFFlagValvole());
		model.setPrescrizioni(u.getAFPrescrizioni());
		return model;
	});

	public static ObjectConverter<CheckListModel, it.csi.citpwa.model.xsd.controllo1B.CheckList> tipo1BModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo1B.CheckList dto = new it.csi.citpwa.model.xsd.controllo1B.CheckList();
		dto.setAFFlagIsolamento(u.isFlagIsolamento());
		dto.setAFFlagSistRegolaz(u.isFlagSistRegolaz());
		dto.setAFFlagSistTrattACS(u.isFlagSistTrattACS());
		dto.setAFOsservazioni(u.getOsservazioni());
		dto.setAFRaccomandazioni(u.getRaccomandazioni());
		dto.setAFFlagValvole(u.isFlagValvole());
		dto.setAFPrescrizioni(u.getPrescrizioni());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo2.CheckList, CheckListModel> tipo2DtoToModel = new ObjectConverter<>(u -> {
		CheckListModel model = new CheckListModel();
		model.setOsservazioni(u.getAFOsservazioni());
		model.setRaccomandazioni(u.getAFRaccomandazioni());
		model.setPrescrizioni(u.getAFPrescrizioni());
		//tipo 2
		model.setFlagSostGen1(u.isAFFlagSostGen1());
		model.setFlagSostGen2(u.isAFFlagSostGen2());
		model.setFlagIsolamentoRete(u.isAFFlagIsolamentoRete());
		model.setFlagIsolamentoCanali(u.isAFFlagIsolamentoCanali());
		return model;
	});

	public static ObjectConverter<CheckListModel, it.csi.citpwa.model.xsd.controllo2.CheckList> tipo2ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo2.CheckList dto = new it.csi.citpwa.model.xsd.controllo2.CheckList();
		dto.setAFOsservazioni(u.getOsservazioni());
		dto.setAFRaccomandazioni(u.getRaccomandazioni());
		dto.setAFPrescrizioni(u.getPrescrizioni());
		//tipo2
		dto.setAFFlagSostGen1(u.isFlagSostGen1());
		dto.setAFFlagSostGen2(u.isFlagSostGen2());
		dto.setAFFlagIsolamentoRete(u.isFlagIsolamentoRete());
		dto.setAFFlagIsolamentoCanali(u.isFlagIsolamentoCanali());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo3.CheckList, CheckListModel> tipo3DtoToModel = new ObjectConverter<>(u -> {
		CheckListModel model = new CheckListModel();
		model.setFlagValvole(u.isAFFlagValvole());
		model.setFlagCurvaClim(u.isAFFlagCurvaClim());
		model.setFlagPerditaH2O(u.isAFFlagPerditaH2O());
		model.setFlagInvolucro(u.isAFFlagInvolucro());
		model.setOsservazioni(u.getAFOsservazioni());
		model.setRaccomandazioni(u.getAFRaccomandazioni());
		model.setPrescrizioni(u.getAFPrescrizioni());
		return model;
	});

	public static ObjectConverter<CheckListModel, it.csi.citpwa.model.xsd.controllo3.CheckList> tipo3ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo3.CheckList dto = new it.csi.citpwa.model.xsd.controllo3.CheckList();
		dto.setAFFlagValvole(u.isFlagValvole());
		dto.setAFFlagCurvaClim(u.isFlagCurvaClim());
		dto.setAFFlagPerditaH2O(u.isFlagPerditaH2O());
		dto.setAFFlagInvolucro(u.isFlagInvolucro());
		dto.setAFOsservazioni(u.getOsservazioni());
		dto.setAFRaccomandazioni(u.getRaccomandazioni());
		dto.setAFPrescrizioni(u.getPrescrizioni());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo4.CheckList, CheckListModel> tipo4DtoToModel = new ObjectConverter<>(u -> {
		CheckListModel model = new CheckListModel();
		model.setFlagValvole(u.isAFFlagValvole());
		model.setFlagIsolamento(u.isAFFlagIsolamento());
		model.setFlagSistTrattACS(u.isAFFlagSistTrattACS());
		model.setFlagSistRegolaz(u.isAFFlagSistRegolaz());
		model.setOsservazioni(u.getAFOsservazioni());
		model.setRaccomandazioni(u.getAFRaccomandazioni());
		model.setPrescrizioni(u.getAFPrescrizioni());
		return model;
	});

	public static ObjectConverter<CheckListModel, it.csi.citpwa.model.xsd.controllo4.CheckList> tipo4ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo4.CheckList dto = new it.csi.citpwa.model.xsd.controllo4.CheckList();
		dto.setAFFlagIsolamento(u.isFlagIsolamento());
		dto.setAFFlagSistRegolaz(u.isFlagSistRegolaz());
		dto.setAFFlagSistTrattACS(u.isFlagSistTrattACS());
		dto.setAFOsservazioni(u.getOsservazioni());
		dto.setAFRaccomandazioni(u.getRaccomandazioni());
		dto.setAFFlagValvole(u.isFlagValvole());
		dto.setAFPrescrizioni(u.getPrescrizioni());
		return dto;
	});

	protected boolean flagValvole;
	protected boolean flagIsolamento;
	protected boolean flagSistTrattACS;
	protected boolean flagSistRegolaz;
	protected String osservazioni;
	protected String raccomandazioni;
	protected String prescrizioni;

	//TIPO 2
	protected boolean flagSostGen1;
	protected boolean flagSostGen2;
	protected boolean flagIsolamentoRete;
	protected boolean flagIsolamentoCanali;

	//TIPO 3

	protected boolean flagCurvaClim;
	protected boolean flagPerditaH2O;
	protected boolean flagInvolucro;

	public CheckListModel() {
	}

	public CheckListModel(boolean flagValvole, boolean flagIsolamento, boolean flagSistTrattACS, boolean flagSistRegolaz, String osservazioni, String raccomandazioni, String prescrizioni, boolean flagSostGen1, boolean flagSostGen2, boolean flagIsolamentoRete, boolean flagIsolamentoCanali, boolean flagCurvaClim, boolean flagPerditaH2O, boolean flagInvolucro) {
		this.flagValvole = flagValvole;
		this.flagIsolamento = flagIsolamento;
		this.flagSistTrattACS = flagSistTrattACS;
		this.flagSistRegolaz = flagSistRegolaz;
		this.osservazioni = osservazioni;
		this.raccomandazioni = raccomandazioni;
		this.prescrizioni = prescrizioni;
		this.flagSostGen1 = flagSostGen1;
		this.flagSostGen2 = flagSostGen2;
		this.flagIsolamentoRete = flagIsolamentoRete;
		this.flagIsolamentoCanali = flagIsolamentoCanali;
		this.flagCurvaClim = flagCurvaClim;
		this.flagPerditaH2O = flagPerditaH2O;
		this.flagInvolucro = flagInvolucro;
	}

	public boolean isFlagValvole() {
		return flagValvole;
	}

	public void setFlagValvole(boolean flagValvole) {
		this.flagValvole = flagValvole;
	}

	public boolean isFlagIsolamento() {
		return flagIsolamento;
	}

	public void setFlagIsolamento(boolean flagIsolamento) {
		this.flagIsolamento = flagIsolamento;
	}

	public boolean isFlagSistTrattACS() {
		return flagSistTrattACS;
	}

	public void setFlagSistTrattACS(boolean flagSistTrattACS) {
		this.flagSistTrattACS = flagSistTrattACS;
	}

	public boolean isFlagSistRegolaz() {
		return flagSistRegolaz;
	}

	public void setFlagSistRegolaz(boolean flagSistRegolaz) {
		this.flagSistRegolaz = flagSistRegolaz;
	}

	public String getOsservazioni() {
		return osservazioni;
	}

	public void setOsservazioni(String osservazioni) {
		this.osservazioni = osservazioni;
	}

	public String getRaccomandazioni() {
		return raccomandazioni;
	}

	public void setRaccomandazioni(String raccomandazioni) {
		this.raccomandazioni = raccomandazioni;
	}

	public String getPrescrizioni() {
		return prescrizioni;
	}

	public void setPrescrizioni(String prescrizioni) {
		this.prescrizioni = prescrizioni;
	}

	public boolean isFlagSostGen1() {
		return flagSostGen1;
	}

	public void setFlagSostGen1(boolean flagSostGen1) {
		this.flagSostGen1 = flagSostGen1;
	}

	public boolean isFlagSostGen2() {
		return flagSostGen2;
	}

	public void setFlagSostGen2(boolean flagSostGen2) {
		this.flagSostGen2 = flagSostGen2;
	}

	public boolean isFlagIsolamentoRete() {
		return flagIsolamentoRete;
	}

	public void setFlagIsolamentoRete(boolean flagIsolamentoRete) {
		this.flagIsolamentoRete = flagIsolamentoRete;
	}

	public boolean isFlagIsolamentoCanali() {
		return flagIsolamentoCanali;
	}

	public void setFlagIsolamentoCanali(boolean flagIsolamentoCanali) {
		this.flagIsolamentoCanali = flagIsolamentoCanali;
	}

	public boolean isFlagCurvaClim() {
		return flagCurvaClim;
	}

	public void setFlagCurvaClim(boolean flagCurvaClim) {
		this.flagCurvaClim = flagCurvaClim;
	}

	public boolean isFlagPerditaH2O() {
		return flagPerditaH2O;
	}

	public void setFlagPerditaH2O(boolean flagPerditaH2O) {
		this.flagPerditaH2O = flagPerditaH2O;
	}

	public boolean isFlagInvolucro() {
		return flagInvolucro;
	}

	public void setFlagInvolucro(boolean flagInvolucro) {
		this.flagInvolucro = flagInvolucro;
	}

	@Override
	public String toString() {
		return "CheckListModel{" + "flagValvole=" + flagValvole + ", flagIsolamento=" + flagIsolamento + ", flagSistTrattACS=" + flagSistTrattACS + ", flagSistRegolaz=" + flagSistRegolaz
				+ ", osservazioni='" + osservazioni + '\'' + ", raccomandazioni='" + raccomandazioni + '\'' + ", prescrizioni='" + prescrizioni + '\'' + ", flagSostGen1=" + flagSostGen1
				+ ", flagSostGen2=" + flagSostGen2 + ", flagIsolamentoRete=" + flagIsolamentoRete + ", flagIsolamentoCanali=" + flagIsolamentoCanali + ", flagCurvaClim=" + flagCurvaClim
				+ ", flagPerditaH2O=" + flagPerditaH2O + ", flagInvolucro=" + flagInvolucro + '}';
	}
}
