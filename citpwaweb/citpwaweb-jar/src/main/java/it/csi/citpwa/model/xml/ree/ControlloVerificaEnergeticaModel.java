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

import it.csi.citpwa.model.xsd.controllo1.ControlloVerificaEnergetica;
import it.csi.citpwa.model.xsd.controllo1.FumiFN;
import it.csi.citpwa.model.xsd.controllo2.ModalitaRaRi;
import it.csi.citpwa.util.ObjectConverter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ControlloVerificaEnergeticaModel {

	public static ObjectConverter<ControlloVerificaEnergetica, ControlloVerificaEnergeticaModel> tipo1DtoToModel = new ObjectConverter<>(u -> {
		ControlloVerificaEnergeticaModel model = new ControlloVerificaEnergeticaModel();
		model.setPotenzaFocolare(u.getAEPotenzaFocolare());
		model.setFlagClimatizInv(u.isAEFlagClimatizInv());
		model.setFlagProduzACS(u.isAEFlagProduzACS());
		model.setFlagDispComando(u.getAEFlagDispComando());
		model.setFlagDispSicu(u.getAEFlagDispSicu());
		model.setFlagValvSicu(u.getAEFlagValvSicu());
		model.setFlagScambiatore(u.getAEFlagScambiatore());
		model.setFlagRiflusso(u.getAEFlagRiflusso());
		model.setFlagRisultati(u.getAEFlagRisultati());
		model.setAltroRifNormativo(u.getAEAltroRifNormativo());
		model.setFlagEvacFumi(u.getAEFlagEvacFumi() != null ? u.getAEFlagEvacFumi().value() : "");
		model.setDepressCanaleFumo(u.getAEDepressCanaleFumo());
		return model;
	});

	public static ObjectConverter<ControlloVerificaEnergeticaModel, ControlloVerificaEnergetica> tipo1ModelToDto = new ObjectConverter<>(u -> {
		ControlloVerificaEnergetica dto = new ControlloVerificaEnergetica();
		dto.setAEPotenzaFocolare(u.getPotenzaFocolare());
		dto.setAEFlagClimatizInv(u.isFlagClimatizInv());
		dto.setAEFlagProduzACS(u.isFlagProduzACS());
		dto.setAEFlagDispComando(u.getFlagDispComando());
		dto.setAEFlagDispSicu(u.getFlagDispSicu());
		dto.setAEFlagValvSicu(u.getFlagValvSicu());
		dto.setAEFlagScambiatore(u.getFlagScambiatore());
		dto.setAEFlagRiflusso(u.getFlagRiflusso());
		dto.setAEFlagRisultati(u.getFlagRisultati());
		dto.setAEAltroRifNormativo(u.getAltroRifNormativo());
		dto.setAEFlagEvacFumi(!StringUtils.isEmpty(u.getFlagEvacFumi()) ? FumiFN.fromValue(u.getFlagEvacFumi()) : null);
		dto.setAEDepressCanaleFumo(u.getDepressCanaleFumo());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo1B.ControlloVerificaEnergetica, ControlloVerificaEnergeticaModel> tipo1BDtoToModel = new ObjectConverter<>(u -> {
		ControlloVerificaEnergeticaModel model = new ControlloVerificaEnergeticaModel();
		model.setPotenzaFocolare(u.getAEPotenzaFocolare());
		model.setFlagClimatizInv(u.isAEFlagClimatizInv());
		model.setFlagProduzACS(u.isAEFlagProduzACS());
		model.setFlagDispComando(u.getAEFlagDispComando());
		model.setFlagDispSicu(u.getAEFlagDispSicu());
		model.setFlagValvSicu(u.getAEFlagValvSicu());
		model.setFlagScambiatore(u.getAEFlagScambiatore());
		model.setFlagRiflusso(u.getAEFlagRiflusso());
		model.setFlagRisultati(u.getAEFlagRisultati());
		model.setAltroRifNormativo(u.getAEAltroRifNormativo());
		model.setFlagEvacFumi(u.getAEFlagEvacFumi() != null ? u.getAEFlagEvacFumi().value() : "");
		model.setDepressCanaleFumo(u.getAEDepressCanaleFumo());
		//solo tipo 1 B
		model.setFlagCaldaia(u.isAEFlagCaldaia());
		model.setFlagStufa(u.isAEFlagStufa());
		model.setFlagStufaAccumulo(u.isAEFlagStufaAccumulo());
		model.setFlagTermocucina(u.isAEFlagTermocucina());
		model.setFlagCaminoAperto(u.isAEFlagCaminoAperto());
		model.setFlagCaminoChiuso(u.isAEFlagCaminoChiuso());
		model.setFlagInsertoCamino(u.isAEFlagInsertoCamino());
		model.setFlagStufaAssemblata(u.isAEFlagStufaAssemblata());
		model.setFlagStufaPellet(u.isAEFlagStufaPellet());
		model.setStelle(u.getAEStelle());
		model.setApparecchiatura(u.getAEApparecchiatura());
		model.setFlagCucina(u.isAEFlagCucina());
		model.setFlagMarcaturaCEE(u.isAEFlagMarcaturaCEE());
		model.setFlagPlaccaCamino(u.isAEFlagPlaccaCamino());
		model.setAriaComburente(u.getAEAriaComburente());
		model.setControlloAria(u.getAEControlloAria());
		model.setCarcaCombu(u.getAECarcaCombu());
		return model;
	});

	public static ObjectConverter<ControlloVerificaEnergeticaModel, it.csi.citpwa.model.xsd.controllo1B.ControlloVerificaEnergetica> tipo1BModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo1B.ControlloVerificaEnergetica dto = new it.csi.citpwa.model.xsd.controllo1B.ControlloVerificaEnergetica();
		dto.setAEPotenzaFocolare(u.getPotenzaFocolare());
		dto.setAEFlagClimatizInv(u.isFlagClimatizInv());
		dto.setAEFlagProduzACS(u.isFlagProduzACS());
		dto.setAEFlagDispComando(u.getFlagDispComando());
		dto.setAEFlagDispSicu(u.getFlagDispSicu());
		dto.setAEFlagValvSicu(u.getFlagValvSicu());
		dto.setAEFlagScambiatore(u.getFlagScambiatore());
		dto.setAEFlagRiflusso(u.getFlagRiflusso());
		dto.setAEFlagRisultati(u.getFlagRisultati());
		dto.setAEAltroRifNormativo(u.getAltroRifNormativo());
		dto.setAEFlagEvacFumi(!StringUtils.isEmpty(u.getFlagEvacFumi()) ? it.csi.citpwa.model.xsd.controllo1B.FumiFN.fromValue(u.getFlagEvacFumi()) : null);
		dto.setAEDepressCanaleFumo(u.getDepressCanaleFumo());
		//solo tipo 1 B
		dto.setAEFlagCaldaia(u.isFlagCaldaia());
		dto.setAEFlagStufa(u.isFlagStufa());
		dto.setAEFlagStufaAccumulo(u.isFlagStufaAccumulo());
		dto.setAEFlagTermocucina(u.isFlagTermocucina());
		dto.setAEFlagCaminoAperto(u.isFlagCaminoAperto());
		dto.setAEFlagCaminoChiuso(u.isFlagCaminoChiuso());
		dto.setAEFlagInsertoCamino(u.isFlagInsertoCamino());
		dto.setAEFlagStufaAssemblata(u.isFlagStufaAssemblata());
		dto.setAEFlagStufaPellet(u.isFlagStufaPellet());
		dto.setAEStelle(u.getStelle());
		dto.setAEApparecchiatura(u.getApparecchiatura());
		dto.setAEFlagCucina(u.isFlagCucina());
		dto.setAEFlagMarcaturaCEE(u.isFlagMarcaturaCEE());
		dto.setAEFlagPlaccaCamino(u.isFlagPlaccaCamino());
		dto.setAEAriaComburente(u.getAriaComburente());
		if (u.getControlloAria() != 0) {
			dto.setAEControlloAria(u.getControlloAria());
		}
		if (u.getCarcaCombu() != 0) {
			dto.setAECarcaCombu(u.getCarcaCombu());
		}
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo2.ControlloVerificaEnergetica, ControlloVerificaEnergeticaModel> tipo2DtoToModel = new ObjectConverter<>(u -> {
		ControlloVerificaEnergeticaModel model = new ControlloVerificaEnergeticaModel();
		model.setFlagModalita(u.getAEFlagModalita() != null ? u.getAEFlagModalita().toString() : null);
		model.setFlagPerdite(u.getAEFlagPerdite());
		model.setFlagRilevFugheDiretta(u.getAEFlagRilevFugheDiretta());
		model.setFlagRilevFugheInDiretta(u.getAEFlagRilevFugheInDiretta());
		model.setFlagScambPuliti(u.getAEFlagScambPuliti());
		return model;
	});

	public static ObjectConverter<ControlloVerificaEnergeticaModel, it.csi.citpwa.model.xsd.controllo2.ControlloVerificaEnergetica> tipo2ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo2.ControlloVerificaEnergetica dto = new it.csi.citpwa.model.xsd.controllo2.ControlloVerificaEnergetica();
		dto.setAEFlagModalita(u.getFlagModalita() != null ? ModalitaRaRi.valueOf(u.getFlagModalita()) : null);
		dto.setAEFlagPerdite(u.getFlagPerdite());
		dto.setAEFlagRilevFugheDiretta(u.getFlagRilevFugheDiretta());
		dto.setAEFlagRilevFugheInDiretta(u.getFlagRilevFugheInDiretta());
		dto.setAEFlagScambPuliti(u.getFlagScambPuliti());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo3.ControlloVerificaEnergetica, ControlloVerificaEnergeticaModel> tipo3DtoToModel = new ObjectConverter<>(u -> {
		ControlloVerificaEnergeticaModel model = new ControlloVerificaEnergeticaModel();
		model.setFlagClimatizInv(u.isAEFlagClimatizInv());
		model.setFlagProduzACS(u.isAEFlagProduzACS());
		model.setCombustibile(u.getAECombustibile());
		model.setFluidoVett(u.getAEFluidoVett());
		model.setFlagPotComp(u.getAEFlagPotComp());
		model.setFlagStatoCoiben(u.getAEFlagStatoCoiben());
		model.setFlagDispReg(u.getAEFlagDispReg());
		return model;
	});

	public static ObjectConverter<ControlloVerificaEnergeticaModel, it.csi.citpwa.model.xsd.controllo3.ControlloVerificaEnergetica> tipo3ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo3.ControlloVerificaEnergetica dto = new it.csi.citpwa.model.xsd.controllo3.ControlloVerificaEnergetica();
		dto.setAEFlagClimatizInv(u.isFlagClimatizInv());
		dto.setAEFlagProduzACS(u.isFlagProduzACS());
		dto.setAECombustibile(u.getCombustibile());
		dto.setAEFluidoVett(u.getFluidoVett());
		dto.setAEFlagPotComp(u.getFlagPotComp());
		dto.setAEFlagStatoCoiben(u.getFlagStatoCoiben());
		dto.setAEFlagDispReg(u.getFlagDispReg());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo4.ControlloVerificaEnergetica, ControlloVerificaEnergeticaModel> tipo4DtoToModel = new ObjectConverter<>(u -> {
		ControlloVerificaEnergeticaModel model = new ControlloVerificaEnergeticaModel();
		model.setFluidoVett(u.getAEFluidoVett());
		model.setPotenzaAssorbita(u.getAEPotenzaAssorbita());
		model.setPotenzaTermByPass(u.getAEPotenzaTermByPass());
		return model;
	});

	public static ObjectConverter<ControlloVerificaEnergeticaModel, it.csi.citpwa.model.xsd.controllo4.ControlloVerificaEnergetica> tipo4ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo4.ControlloVerificaEnergetica dto = new it.csi.citpwa.model.xsd.controllo4.ControlloVerificaEnergetica();
		dto.setAEFluidoVett(u.getFluidoVett());
		dto.setAEPotenzaAssorbita(u.getPotenzaAssorbita());
		dto.setAEPotenzaTermByPass(u.getPotenzaTermByPass());
		return dto;
	});

	protected BigDecimal potenzaFocolare;
	protected boolean flagClimatizInv;
	protected boolean flagProduzACS;
	protected BigInteger flagDispComando;
	protected BigInteger flagDispSicu;
	protected BigInteger flagValvSicu;
	protected BigInteger flagScambiatore;
	protected BigInteger flagRiflusso;
	protected BigInteger flagRisultati;
	protected String altroRifNormativo;
	protected String flagEvacFumi;
	protected BigDecimal depressCanaleFumo;

	//solo tipo 1 B
	protected boolean flagCaldaia;
	protected boolean flagStufa;
	protected boolean flagStufaAccumulo;
	protected boolean flagTermocucina;
	protected boolean flagCaminoAperto;
	protected boolean flagCaminoChiuso;
	protected boolean flagInsertoCamino;
	protected boolean flagStufaAssemblata;
	protected boolean flagStufaPellet;
	protected int stelle;
	protected int apparecchiatura;
	protected boolean flagCucina;
	protected boolean flagMarcaturaCEE;
	protected boolean flagPlaccaCamino;
	protected int ariaComburente;
	protected int controlloAria;
	protected int carcaCombu;

	//Tipo 2
	protected String flagModalita;
	protected BigInteger flagPerdite;
	protected BigInteger flagRilevFugheDiretta;
	protected BigInteger flagRilevFugheInDiretta;
	protected BigInteger flagScambPuliti;

	//TIPO 3
	protected String combustibile;
	protected String fluidoVett;
	protected BigInteger flagPotComp;
	protected BigInteger flagStatoCoiben;
	protected BigInteger flagDispReg;

	//TIPO 4
	protected BigDecimal potenzaAssorbita;
	protected BigDecimal potenzaTermByPass;

	public ControlloVerificaEnergeticaModel() {
	}

	public ControlloVerificaEnergeticaModel(BigDecimal potenzaFocolare, boolean flagClimatizInv, boolean flagProduzACS, BigInteger flagDispComando, BigInteger flagDispSicu, BigInteger flagValvSicu, BigInteger flagScambiatore, BigInteger flagRiflusso, BigInteger flagRisultati, String altroRifNormativo, String flagEvacFumi, BigDecimal depressCanaleFumo, boolean flagCaldaia, boolean flagStufa, boolean flagStufaAccumulo, boolean flagTermocucina, boolean flagCaminoAperto, boolean flagCaminoChiuso, boolean flagInsertoCamino, boolean flagStufaAssemblata, boolean flagStufaPellet, int stelle, int apparecchiatura, boolean flagCucina, boolean flagMarcaturaCEE, boolean flagPlaccaCamino, int ariaComburente, int controlloAria, int carcaCombu, String flagModalita, BigInteger flagPerdite, BigInteger flagRilevFugheDiretta, BigInteger flagRilevFugheInDiretta, BigInteger flagScambPuliti, String combustibile, String fluidoVett, BigInteger flagPotComp, BigInteger flagStatoCoiben, BigInteger flagDispReg, BigDecimal potenzaAssorbita, BigDecimal potenzaTermByPass) {
		this.potenzaFocolare = potenzaFocolare;
		this.flagClimatizInv = flagClimatizInv;
		this.flagProduzACS = flagProduzACS;
		this.flagDispComando = flagDispComando;
		this.flagDispSicu = flagDispSicu;
		this.flagValvSicu = flagValvSicu;
		this.flagScambiatore = flagScambiatore;
		this.flagRiflusso = flagRiflusso;
		this.flagRisultati = flagRisultati;
		this.altroRifNormativo = altroRifNormativo;
		this.flagEvacFumi = flagEvacFumi;
		this.depressCanaleFumo = depressCanaleFumo;
		this.flagCaldaia = flagCaldaia;
		this.flagStufa = flagStufa;
		this.flagStufaAccumulo = flagStufaAccumulo;
		this.flagTermocucina = flagTermocucina;
		this.flagCaminoAperto = flagCaminoAperto;
		this.flagCaminoChiuso = flagCaminoChiuso;
		this.flagInsertoCamino = flagInsertoCamino;
		this.flagStufaAssemblata = flagStufaAssemblata;
		this.flagStufaPellet = flagStufaPellet;
		this.stelle = stelle;
		this.apparecchiatura = apparecchiatura;
		this.flagCucina = flagCucina;
		this.flagMarcaturaCEE = flagMarcaturaCEE;
		this.flagPlaccaCamino = flagPlaccaCamino;
		this.ariaComburente = ariaComburente;
		this.controlloAria = controlloAria;
		this.carcaCombu = carcaCombu;
		this.flagModalita = flagModalita;
		this.flagPerdite = flagPerdite;
		this.flagRilevFugheDiretta = flagRilevFugheDiretta;
		this.flagRilevFugheInDiretta = flagRilevFugheInDiretta;
		this.flagScambPuliti = flagScambPuliti;
		this.combustibile = combustibile;
		this.fluidoVett = fluidoVett;
		this.flagPotComp = flagPotComp;
		this.flagStatoCoiben = flagStatoCoiben;
		this.flagDispReg = flagDispReg;
		this.potenzaAssorbita = potenzaAssorbita;
		this.potenzaTermByPass = potenzaTermByPass;
	}

	public BigDecimal getPotenzaFocolare() {
		return potenzaFocolare;
	}

	public void setPotenzaFocolare(BigDecimal potenzaFocolare) {
		this.potenzaFocolare = potenzaFocolare;
	}

	public boolean isFlagClimatizInv() {
		return flagClimatizInv;
	}

	public void setFlagClimatizInv(boolean flagClimatizInv) {
		this.flagClimatizInv = flagClimatizInv;
	}

	public boolean isFlagProduzACS() {
		return flagProduzACS;
	}

	public void setFlagProduzACS(boolean flagProduzACS) {
		this.flagProduzACS = flagProduzACS;
	}

	public BigInteger getFlagDispComando() {
		return flagDispComando;
	}

	public void setFlagDispComando(BigInteger flagDispComando) {
		this.flagDispComando = flagDispComando;
	}

	public BigInteger getFlagDispSicu() {
		return flagDispSicu;
	}

	public void setFlagDispSicu(BigInteger flagDispSicu) {
		this.flagDispSicu = flagDispSicu;
	}

	public BigInteger getFlagValvSicu() {
		return flagValvSicu;
	}

	public void setFlagValvSicu(BigInteger flagValvSicu) {
		this.flagValvSicu = flagValvSicu;
	}

	public BigInteger getFlagScambiatore() {
		return flagScambiatore;
	}

	public void setFlagScambiatore(BigInteger flagScambiatore) {
		this.flagScambiatore = flagScambiatore;
	}

	public BigInteger getFlagRiflusso() {
		return flagRiflusso;
	}

	public void setFlagRiflusso(BigInteger flagRiflusso) {
		this.flagRiflusso = flagRiflusso;
	}

	public BigInteger getFlagRisultati() {
		return flagRisultati;
	}

	public void setFlagRisultati(BigInteger flagRisultati) {
		this.flagRisultati = flagRisultati;
	}

	public String getAltroRifNormativo() {
		return altroRifNormativo;
	}

	public void setAltroRifNormativo(String altroRifNormativo) {
		this.altroRifNormativo = altroRifNormativo;
	}

	public String getFlagEvacFumi() {
		return flagEvacFumi;
	}

	public void setFlagEvacFumi(String flagEvacFumi) {
		this.flagEvacFumi = flagEvacFumi;
	}

	public BigDecimal getDepressCanaleFumo() {
		return depressCanaleFumo;
	}

	public void setDepressCanaleFumo(BigDecimal depressCanaleFumo) {
		this.depressCanaleFumo = depressCanaleFumo;
	}

	public boolean isFlagCaldaia() {
		return flagCaldaia;
	}

	public void setFlagCaldaia(boolean flagCaldaia) {
		this.flagCaldaia = flagCaldaia;
	}

	public boolean isFlagStufa() {
		return flagStufa;
	}

	public void setFlagStufa(boolean flagStufa) {
		this.flagStufa = flagStufa;
	}

	public boolean isFlagStufaAccumulo() {
		return flagStufaAccumulo;
	}

	public void setFlagStufaAccumulo(boolean flagStufaAccumulo) {
		this.flagStufaAccumulo = flagStufaAccumulo;
	}

	public boolean isFlagTermocucina() {
		return flagTermocucina;
	}

	public void setFlagTermocucina(boolean flagTermocucina) {
		this.flagTermocucina = flagTermocucina;
	}

	public boolean isFlagCaminoAperto() {
		return flagCaminoAperto;
	}

	public void setFlagCaminoAperto(boolean flagCaminoAperto) {
		this.flagCaminoAperto = flagCaminoAperto;
	}

	public boolean isFlagCaminoChiuso() {
		return flagCaminoChiuso;
	}

	public void setFlagCaminoChiuso(boolean flagCaminoChiuso) {
		this.flagCaminoChiuso = flagCaminoChiuso;
	}

	public boolean isFlagInsertoCamino() {
		return flagInsertoCamino;
	}

	public void setFlagInsertoCamino(boolean flagInsertoCamino) {
		this.flagInsertoCamino = flagInsertoCamino;
	}

	public boolean isFlagStufaAssemblata() {
		return flagStufaAssemblata;
	}

	public void setFlagStufaAssemblata(boolean flagStufaAssemblata) {
		this.flagStufaAssemblata = flagStufaAssemblata;
	}

	public boolean isFlagStufaPellet() {
		return flagStufaPellet;
	}

	public void setFlagStufaPellet(boolean flagStufaPellet) {
		this.flagStufaPellet = flagStufaPellet;
	}

	public int getStelle() {
		return stelle;
	}

	public void setStelle(int stelle) {
		this.stelle = stelle;
	}

	public int getApparecchiatura() {
		return apparecchiatura;
	}

	public void setApparecchiatura(int apparecchiatura) {
		this.apparecchiatura = apparecchiatura;
	}

	public boolean isFlagCucina() {
		return flagCucina;
	}

	public void setFlagCucina(boolean flagCucina) {
		this.flagCucina = flagCucina;
	}

	public boolean isFlagMarcaturaCEE() {
		return flagMarcaturaCEE;
	}

	public void setFlagMarcaturaCEE(boolean flagMarcaturaCEE) {
		this.flagMarcaturaCEE = flagMarcaturaCEE;
	}

	public boolean isFlagPlaccaCamino() {
		return flagPlaccaCamino;
	}

	public void setFlagPlaccaCamino(boolean flagPlaccaCamino) {
		this.flagPlaccaCamino = flagPlaccaCamino;
	}

	public int getAriaComburente() {
		return ariaComburente;
	}

	public void setAriaComburente(int ariaComburente) {
		this.ariaComburente = ariaComburente;
	}

	public int getControlloAria() {
		return controlloAria;
	}

	public void setControlloAria(int controlloAria) {
		this.controlloAria = controlloAria;
	}

	public int getCarcaCombu() {
		return carcaCombu;
	}

	public void setCarcaCombu(int carcaCombu) {
		this.carcaCombu = carcaCombu;
	}

	public String getFlagModalita() {
		return flagModalita;
	}

	public void setFlagModalita(String flagModalita) {
		this.flagModalita = flagModalita;
	}

	public BigInteger getFlagPerdite() {
		return flagPerdite;
	}

	public void setFlagPerdite(BigInteger flagPerdite) {
		this.flagPerdite = flagPerdite;
	}

	public BigInteger getFlagRilevFugheDiretta() {
		return flagRilevFugheDiretta;
	}

	public void setFlagRilevFugheDiretta(BigInteger flagRilevFugheDiretta) {
		this.flagRilevFugheDiretta = flagRilevFugheDiretta;
	}

	public BigInteger getFlagRilevFugheInDiretta() {
		return flagRilevFugheInDiretta;
	}

	public void setFlagRilevFugheInDiretta(BigInteger flagRilevFugheInDiretta) {
		this.flagRilevFugheInDiretta = flagRilevFugheInDiretta;
	}

	public BigInteger getFlagScambPuliti() {
		return flagScambPuliti;
	}

	public void setFlagScambPuliti(BigInteger flagScambPuliti) {
		this.flagScambPuliti = flagScambPuliti;
	}

	public String getCombustibile() {
		return combustibile;
	}

	public void setCombustibile(String combustibile) {
		this.combustibile = combustibile;
	}

	public String getFluidoVett() {
		return fluidoVett;
	}

	public void setFluidoVett(String fluidoVett) {
		this.fluidoVett = fluidoVett;
	}

	public BigInteger getFlagPotComp() {
		return flagPotComp;
	}

	public void setFlagPotComp(BigInteger flagPotComp) {
		this.flagPotComp = flagPotComp;
	}

	public BigInteger getFlagStatoCoiben() {
		return flagStatoCoiben;
	}

	public void setFlagStatoCoiben(BigInteger flagStatoCoiben) {
		this.flagStatoCoiben = flagStatoCoiben;
	}

	public BigInteger getFlagDispReg() {
		return flagDispReg;
	}

	public void setFlagDispReg(BigInteger flagDispReg) {
		this.flagDispReg = flagDispReg;
	}

	public BigDecimal getPotenzaAssorbita() {
		return potenzaAssorbita;
	}

	public void setPotenzaAssorbita(BigDecimal potenzaAssorbita) {
		this.potenzaAssorbita = potenzaAssorbita;
	}

	public BigDecimal getPotenzaTermByPass() {
		return potenzaTermByPass;
	}

	public void setPotenzaTermByPass(BigDecimal potenzaTermByPass) {
		this.potenzaTermByPass = potenzaTermByPass;
	}

	@Override
	public String toString() {
		return "ControlloVerificaEnergeticaModel{" + "potenzaFocolare=" + potenzaFocolare + ", flagClimatizInv=" + flagClimatizInv + ", flagProduzACS=" + flagProduzACS + ", flagDispComando="
				+ flagDispComando + ", flagDispSicu=" + flagDispSicu + ", flagValvSicu=" + flagValvSicu + ", flagScambiatore=" + flagScambiatore + ", flagRiflusso=" + flagRiflusso + ", flagRisultati="
				+ flagRisultati + ", altroRifNormativo='" + altroRifNormativo + '\'' + ", flagEvacFumi='" + flagEvacFumi + '\'' + ", depressCanaleFumo=" + depressCanaleFumo + ", flagCaldaia="
				+ flagCaldaia + ", flagStufa=" + flagStufa + ", flagStufaAccumulo=" + flagStufaAccumulo + ", flagTermocucina=" + flagTermocucina + ", flagCaminoAperto=" + flagCaminoAperto
				+ ", flagCaminoChiuso=" + flagCaminoChiuso + ", flagInsertoCamino=" + flagInsertoCamino + ", flagStufaAssemblata=" + flagStufaAssemblata + ", flagStufaPellet=" + flagStufaPellet
				+ ", stelle=" + stelle + ", apparecchiatura=" + apparecchiatura + ", flagCucina=" + flagCucina + ", flagMarcaturaCEE=" + flagMarcaturaCEE + ", flagPlaccaCamino=" + flagPlaccaCamino
				+ ", ariaComburente=" + ariaComburente + ", controlloAria=" + controlloAria + ", carcaCombu=" + carcaCombu + ", flagModalita='" + flagModalita + '\'' + ", flagPerdite=" + flagPerdite
				+ ", flagRilevFugheDiretta=" + flagRilevFugheDiretta + ", flagRilevFugheInDiretta=" + flagRilevFugheInDiretta + ", flagScambPuliti=" + flagScambPuliti + ", combustibile='"
				+ combustibile + '\'' + ", fluidoVett='" + fluidoVett + '\'' + ", flagPotComp=" + flagPotComp + ", flagStatoCoiben=" + flagStatoCoiben + ", flagDispReg=" + flagDispReg
				+ ", potenzaAssorbita=" + potenzaAssorbita + ", potenzaTermByPass=" + potenzaTermByPass + '}';
	}
}
