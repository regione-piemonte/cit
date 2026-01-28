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

import it.csi.citpwa.model.xsd.controllo1.Portata;
import it.csi.citpwa.model.xsd.controllo1.RowFumi;
import it.csi.citpwa.model.xsd.controllo1B.UM;
import it.csi.citpwa.util.Constants;
import it.csi.citpwa.util.DateUtil;
import it.csi.citpwa.util.ObjectConverter;
import org.apache.commons.lang3.StringUtils;

import javax.xml.datatype.DatatypeConfigurationException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;

public class RowFumiModel {

	public static ObjectConverter<RowFumi, RowFumiModel> tipo1DtoToModel = new ObjectConverter<>(u -> {
		RowFumiModel model = new RowFumiModel();
		model.setTempFumi(u.getAETempFumi());
		model.setTempAria(u.getAETempAria());
		model.setO2(u.getAEO2());
		model.setCo2(u.getAECO2());
		model.setBacharach1(u.getAEBacharach1());
		model.setBacharach2(u.getAEBacharach2());
		model.setBacharach3(u.getAEBacharach3());
		model.setcOcorretto(u.getAECOcorretto());
		model.setRendimCombu(u.getAERendimCombu());
		model.setRendimentoLegge(u.getAERendimentoLegge());
		model.setNox(u.getAENox());
		model.setModuloTermico(u.getAEModuloTermico());
		model.setPortataCombu(u.getAEPortataCombu() != null ? u.getAEPortataCombu().value() : "");
		model.setValorePortata(u.getAEValorePortata());
		model.setCoFumiSecchi(u.getAECOfumiSecchi());
		
		if (u.isAERispettoIndBacharach() == null)
			model.setRispettoIndBacharach(BigInteger.TWO);
		else 
			model.setRispettoIndBacharach(Boolean.TRUE.equals(u.isAERispettoIndBacharach()) ? BigInteger.ONE : BigInteger.ZERO);
	
		if (u.isAEMinimo() == null)
			model.setMinimo(BigInteger.TWO);		
		else 
			model.setMinimo(Boolean.TRUE.equals(u.isAEMinimo()) ? BigInteger.ONE : BigInteger.ZERO);
			
		return model;
	});

	public static ObjectConverter<RowFumiModel, RowFumi> tipo1ModelToDto = new ObjectConverter<>(u -> {
		RowFumi dto = new RowFumi();
		dto.setAETempFumi(u.getTempFumi());
		dto.setAETempAria(u.getTempAria());
		dto.setAEO2(u.getO2());
		dto.setAECO2(u.getCo2());
		dto.setAEBacharach1(u.getBacharach1());
		dto.setAEBacharach2(u.getBacharach2());
		dto.setAEBacharach3(u.getBacharach3());
		dto.setAECOcorretto(u.getcOcorretto());
		dto.setAERendimCombu(u.getRendimCombu());
		dto.setAERendimentoLegge(u.getRendimentoLegge());
		dto.setAENox(u.getNox());
		dto.setAEModuloTermico(u.getModuloTermico());
		dto.setAEPortataCombu(!StringUtils.isEmpty(u.getPortataCombu())?Portata.fromValue(u.getPortataCombu()):null);
		dto.setAEValorePortata(u.getValorePortata());
		dto.setAECOfumiSecchi(u.getCoFumiSecchi());
		if (BigInteger.ZERO.equals(u.getRispettoIndBacharach()))
			dto.setAERispettoIndBacharach(false);
		else if (BigInteger.ONE.equals(u.getRispettoIndBacharach()))
			dto.setAERispettoIndBacharach(true);
		if (BigInteger.ZERO.equals(u.getMinimo()))
			dto.setAEMinimo(false);
		else if (BigInteger.ONE.equals(u.getMinimo()))
			dto.setAEMinimo(true);
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo1B.RowFumi, RowFumiModel> tipo1BDtoToModel = new ObjectConverter<>(u -> {
		RowFumiModel model = new RowFumiModel();
		model.setTempFumi(u.getAETempFumi());
		model.setTempAria(u.getAETempAria());
		model.setO2(u.getAEO2());
		model.setCo2(u.getAECO2());
		model.setcOcorretto(u.getAECOcorretto());
		model.setRendimCombu(u.getAERendimCombu());
		model.setRendimentoLegge(u.getAERendimentoLegge());
		model.setNox(u.getAENox());
		model.setModuloTermico(u.getAEModuloTermico());
		//tipo1B
		model.setParticolato(u.getAEParticolato());
		model.setNoxUM(u.getAENoxUM() != null ? u.getAENoxUM().value() : "");
		return model;
	});

	public static ObjectConverter<RowFumiModel, it.csi.citpwa.model.xsd.controllo1B.RowFumi> tipo1BModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo1B.RowFumi dto = new it.csi.citpwa.model.xsd.controllo1B.RowFumi();
		dto.setAETempFumi(u.getTempFumi());
		dto.setAETempAria(u.getTempAria());
		dto.setAEO2(u.getO2());
		dto.setAECO2(u.getCo2());
		dto.setAECOcorretto(u.getcOcorretto());
		dto.setAERendimCombu(u.getRendimCombu());
		dto.setAERendimentoLegge(u.getRendimentoLegge());
		dto.setAENox(u.getNox());
		dto.setAEModuloTermico(u.getModuloTermico());
		//tipo1B
		dto.setAEParticolato(u.getParticolato());
		dto.setAENoxUM(u.getNoxUM() != null ? UM.fromValue(u.getNoxUM()) : null);
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo2.RowFumi, RowFumiModel> tipo2DtoToModel = new ObjectConverter<>(u -> {
		RowFumiModel model = new RowFumiModel();
		model.setSurrisc(u.getAESurrisc());
		model.setSottoRaffr(u.getAESottoRaffr());
		model.setCondens(u.getAECondens());
		model.setEvaporaz(u.getAEEvaporaz());
		model.setIngLatoEst(u.getAEIngLatoEst());
		model.setUscLatoEst(u.getAEUscLatoEst());
		model.setIngLatoUtenze(u.getAEIngLatoUtenze());
		model.setUscLatoUtenze(u.getAEUscLatoUtenze());
		model.setNumCircuito(u.getAENumCircuito());
		model.setTuscFluido(u.getAETuscFluido());
		model.setTbulboUmido(u.getAETbulboUmido());
		model.setTingFluidoSorg(u.getAETingFluidoSorg());
		model.setTuscFluidoSorg(u.getAETuscFluidoSorg());
		model.setTingFluidoMacc(u.getAETingFluidoMacc());
		model.setTuscFluidoMacc(u.getAETuscFluidoMacc());
		model.setPotenzaAss(u.getAEPotenzaAss());
		model.setFiltriPuliti(u.isAEFiltriPuliti());
		model.setVerifica(u.isAEVerifica());
		try {
			model.setDataRipristino(DateUtil.xmlGregorianCalendarToString(u.getAEDataRipristino(), Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			model.setDataRipristino(null);
		}
		return model;
	});

	public static ObjectConverter<RowFumiModel, it.csi.citpwa.model.xsd.controllo2.RowFumi> tipo2ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo2.RowFumi dto = new it.csi.citpwa.model.xsd.controllo2.RowFumi();
		dto.setAESurrisc(u.getSurrisc());
		dto.setAESottoRaffr(u.getSottoRaffr());
		dto.setAECondens(u.getCondens());
		dto.setAEEvaporaz(u.getEvaporaz());
		dto.setAEIngLatoEst(u.getIngLatoEst());
		dto.setAEUscLatoEst(u.getUscLatoEst());
		dto.setAEIngLatoUtenze(u.getIngLatoUtenze());
		dto.setAEUscLatoUtenze(u.getUscLatoUtenze());
		dto.setAENumCircuito(u.getNumCircuito());
		dto.setAETuscFluido(u.getTuscFluido());
		dto.setAETbulboUmido(u.getTbulboUmido());
		dto.setAETingFluidoSorg(u.getTingFluidoSorg());
		dto.setAETuscFluidoSorg(u.getTuscFluidoSorg());
		dto.setAETingFluidoMacc(u.getTingFluidoMacc());
		dto.setAETuscFluidoMacc(u.getTuscFluidoMacc());
		dto.setAEPotenzaAss(u.getPotenzaAss());
		dto.setAEFiltriPuliti(u.getFiltriPuliti());
		dto.setAEVerifica(u.isVerifica());
		try {
			dto.setAEDataRipristino(DateUtil.stringToXMLGregorianCalendar(u.getDataRipristino(),Constants.FORMAT));
		} catch (ParseException | DatatypeConfigurationException e) {
			dto.setAEDataRipristino(null);
		}
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo3.RowFumi, RowFumiModel> tipo3DtoToModel = new ObjectConverter<>(u -> {
		RowFumiModel model = new RowFumiModel();
		model.setTempEst(u.getAETempEst());
		model.setTempMandPrim(u.getAETempMandPrim());
		model.setTempRitPrim(u.getAETempRitPrim());
		model.setPotenzaTerm(u.getAEPotenzaTerm());
		model.setPortataFluido(u.getAEPortataFluido());
		model.setTempMandSecond(u.getAETempMandSecond());
		model.setTempRitSecond(u.getAETempRitSecond());
		return model;
	});

	public static ObjectConverter<RowFumiModel, it.csi.citpwa.model.xsd.controllo3.RowFumi> tipo3ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo3.RowFumi dto = new it.csi.citpwa.model.xsd.controllo3.RowFumi();
		dto.setAETempEst(u.getTempEst());
		dto.setAETempMandPrim(u.getTempMandPrim());
		dto.setAETempRitPrim(u.getTempRitPrim());
		dto.setAEPotenzaTerm(u.getPotenzaTerm());
		dto.setAEPortataFluido(u.getPortataFluido());
		dto.setAETempMandSecond(u.getTempMandSecond());
		dto.setAETempRitSecond(u.getTempRitSecond());
		return dto;
	});

	public static ObjectConverter<it.csi.citpwa.model.xsd.controllo4.RowFumi, RowFumiModel> tipo4DtoToModel = new ObjectConverter<>(u -> {
		RowFumiModel model = new RowFumiModel();
		model.setTempAriaCombur(u.getAETempAriaCombur());
		model.setTempAcquaUsc(u.getAETempAcquaUsc());
		model.setTempAcquaIng(u.getAETempAcquaIng());
		model.setPotenzaMorsetti(u.getAEPotenzaMorsetti());
		model.setTempH2Omotore(u.getAETempH2Omotore());
		model.setTempFumiAvalle(u.getAETempFumiAvalle());
		model.setTempFumiAmonte(u.getAETempFumiAmonte());
		model.setSovraFreqSoglia1(u.getAESovraFreqSoglia1());
		model.setSovraFreqSoglia2(u.getAESovraFreqSoglia2());
		model.setSovraFreqSoglia3(u.getAESovraFreqSoglia3());
		model.setSovraFreqTempo1(u.getAESovraFreqTempo1());
		model.setSovraFreqTempo2(u.getAESovraFreqTempo2());
		model.setSovraFreqTempo3(u.getAESovraFreqTempo3());
		model.setSottoFreqSoglia1(u.getAESottoFreqSoglia1());
		model.setSottoFreqSoglia2(u.getAESottoFreqSoglia2());
		model.setSottoFreqSoglia3(u.getAESottoFreqSoglia3());
		model.setSottoFreqTempo1(u.getAESottoFreqTempo1());
		model.setSottoFreqTempo2(u.getAESottoFreqTempo2());
		model.setSottoFreqTempo3(u.getAESottoFreqTempo3());
		model.setSovraTensSoglia1(u.getAESovraTensSoglia1());
		model.setSovraTensSoglia2(u.getAESovraTensSoglia2());
		model.setSovraTensSoglia3(u.getAESovraTensSoglia3());
		model.setSovraTensTempo1(u.getAESovraTensTempo1());
		model.setSovraTensTempo2(u.getAESovraTensTempo2());
		model.setSovraTensTempo3(u.getAESovraTensTempo3());
		model.setSottoTensSoglia1(u.getAESottoTensSoglia1());
		model.setSottoTensSoglia2(u.getAESottoTensSoglia2());
		model.setSottoTensSoglia3(u.getAESottoTensSoglia3());
		model.setSottoTensTempo1(u.getAESottoTensTempo1());
		model.setSottoTensTempo2(u.getAESottoTensTempo2());
		model.setSottoTensTempo3(u.getAESottoTensTempo3());
		return model;
	});

	public static ObjectConverter<RowFumiModel, it.csi.citpwa.model.xsd.controllo4.RowFumi> tipo4ModelToDto = new ObjectConverter<>(u -> {
		it.csi.citpwa.model.xsd.controllo4.RowFumi dto = new it.csi.citpwa.model.xsd.controllo4.RowFumi();
		dto.setAETempAriaCombur(u.getTempAriaCombur());
		dto.setAETempAcquaUsc(u.getTempAcquaUsc());
		dto.setAETempAcquaIng(u.getTempAcquaIng());
		dto.setAEPotenzaMorsetti(u.getPotenzaMorsetti());
		dto.setAETempH2Omotore(u.getTempH2Omotore());
		dto.setAETempFumiAvalle(u.getTempFumiAvalle());
		dto.setAETempFumiAmonte(u.getTempFumiAmonte());
		dto.setAESovraFreqSoglia1(u.getSovraFreqSoglia1());
		dto.setAESovraFreqSoglia2(u.getSovraFreqSoglia2());
		dto.setAESovraFreqSoglia3(u.getSovraFreqSoglia3());
		dto.setAESovraFreqTempo1(u.getSovraFreqTempo1());
		dto.setAESovraFreqTempo2(u.getSovraFreqTempo2());
		dto.setAESovraFreqTempo3(u.getSovraFreqTempo3());
		dto.setAESottoFreqSoglia1(u.getSottoFreqSoglia1());
		dto.setAESottoFreqSoglia2(u.getSottoFreqSoglia2());
		dto.setAESottoFreqSoglia3(u.getSottoFreqSoglia3());
		dto.setAESottoFreqTempo1(u.getSottoFreqTempo1());
		dto.setAESottoFreqTempo2(u.getSottoFreqTempo2());
		dto.setAESottoFreqTempo3(u.getSottoFreqTempo3());
		dto.setAESovraTensSoglia1(u.getSovraTensSoglia1());
		dto.setAESovraTensSoglia2(u.getSovraTensSoglia2());
		dto.setAESovraTensSoglia3(u.getSovraTensSoglia3());
		dto.setAESovraTensTempo1(u.getSovraTensTempo1());
		dto.setAESovraTensTempo2(u.getSovraTensTempo2());
		dto.setAESovraTensTempo3(u.getSovraTensTempo3());
		dto.setAESottoTensSoglia1(u.getSottoTensSoglia1());
		dto.setAESottoTensSoglia2(u.getSottoTensSoglia2());
		dto.setAESottoTensSoglia3(u.getSottoTensSoglia3());
		dto.setAESottoTensTempo1(u.getSottoTensTempo1());
		dto.setAESottoTensTempo2(u.getSottoTensTempo2());
		dto.setAESottoTensTempo3(u.getSottoTensTempo3());
		return dto;
	});
	protected BigDecimal tempFumi;
	protected BigDecimal tempAria;
	protected BigDecimal o2;
	protected BigDecimal co2;
	protected BigDecimal bacharach1;
	protected BigDecimal bacharach2;
	protected BigDecimal bacharach3;
	protected BigDecimal cOcorretto;
	protected BigDecimal rendimCombu;
	protected BigDecimal rendimentoLegge;
	protected BigDecimal nox;
	protected BigInteger moduloTermico;
	protected String portataCombu;
	protected BigDecimal valorePortata;
	protected BigDecimal coFumiSecchi;
	protected BigInteger rispettoIndBacharach;
	protected BigInteger minimo;

	//tipo 1B
	protected BigDecimal particolato;
	protected String noxUM;

	//tipo 2
	protected BigDecimal surrisc;
	protected BigDecimal sottoRaffr;
	protected BigDecimal condens;
	protected BigDecimal evaporaz;
	protected BigDecimal ingLatoEst;
	protected BigDecimal uscLatoEst;
	protected BigDecimal ingLatoUtenze;
	protected BigDecimal uscLatoUtenze;
	protected BigInteger numCircuito;
	protected BigDecimal tuscFluido;
	protected BigDecimal tbulboUmido;
	protected BigDecimal tingFluidoSorg;
	protected BigDecimal tuscFluidoSorg;
	protected BigDecimal tingFluidoMacc;
	protected BigDecimal tuscFluidoMacc;
	protected BigDecimal potenzaAss;
	protected Boolean filtriPuliti;
	protected boolean verifica;
	protected String dataRipristino;

	//TIPO3
	protected BigDecimal tempEst;
	protected BigDecimal tempMandPrim;
	protected BigDecimal tempRitPrim;
	protected BigDecimal potenzaTerm;
	protected BigDecimal portataFluido;
	protected BigDecimal tempMandSecond;
	protected BigDecimal tempRitSecond;
	//TIPO4
	protected BigDecimal tempAriaCombur;
	protected BigDecimal tempAcquaUsc;
	protected BigDecimal tempAcquaIng;
	protected BigDecimal potenzaMorsetti;
	protected BigDecimal tempH2Omotore;
	protected BigDecimal tempFumiAvalle;
	protected BigDecimal tempFumiAmonte;
	protected BigDecimal sovraFreqSoglia1;
	protected BigDecimal sovraFreqSoglia2;
	protected BigDecimal sovraFreqSoglia3;
	protected BigDecimal sovraFreqTempo1;
	protected BigDecimal sovraFreqTempo2;
	protected BigDecimal sovraFreqTempo3;
	protected BigDecimal sottoFreqSoglia1;
	protected BigDecimal sottoFreqSoglia2;
	protected BigDecimal sottoFreqSoglia3;
	protected BigDecimal sottoFreqTempo1;
	protected BigDecimal sottoFreqTempo2;
	protected BigDecimal sottoFreqTempo3;
	protected BigDecimal sovraTensSoglia1;
	protected BigDecimal sovraTensSoglia2;
	protected BigDecimal sovraTensSoglia3;
	protected BigDecimal sovraTensTempo1;
	protected BigDecimal sovraTensTempo2;
	protected BigDecimal sovraTensTempo3;
	protected BigDecimal sottoTensSoglia1;
	protected BigDecimal sottoTensSoglia2;
	protected BigDecimal sottoTensSoglia3;
	protected BigDecimal sottoTensTempo1;
	protected BigDecimal sottoTensTempo2;
	protected BigDecimal sottoTensTempo3;

	public RowFumiModel() {
	}

	public RowFumiModel(BigDecimal tempFumi, BigDecimal tempAria, BigDecimal o2, BigDecimal co2, BigDecimal bacharach1, BigDecimal bacharach2, BigDecimal bacharach3, BigDecimal cOcorretto, BigDecimal rendimCombu, BigDecimal rendimentoLegge, BigDecimal nox, BigInteger moduloTermico, String portataCombu, BigDecimal valorePortata, BigDecimal coFumiSecchi, BigInteger rispettoIndBacharach, BigInteger minimo, BigDecimal particolato, String noxUM, BigDecimal surrisc, BigDecimal sottoRaffr, BigDecimal condens, BigDecimal evaporaz, BigDecimal ingLatoEst, BigDecimal uscLatoEst, BigDecimal ingLatoUtenze, BigDecimal uscLatoUtenze, BigInteger numCircuito, BigDecimal tuscFluido, BigDecimal tbulboUmido, BigDecimal tingFluidoSorg, BigDecimal tuscFluidoSorg, BigDecimal tingFluidoMacc, BigDecimal tuscFluidoMacc, BigDecimal potenzaAss, Boolean filtriPuliti, boolean verifica, String dataRipristino, BigDecimal tempEst, BigDecimal tempMandPrim, BigDecimal tempRitPrim, BigDecimal potenzaTerm, BigDecimal portataFluido, BigDecimal tempMandSecond, BigDecimal tempRitSecond, BigDecimal tempAriaCombur, BigDecimal tempAcquaUsc, BigDecimal tempAcquaIng, BigDecimal potenzaMorsetti, BigDecimal tempH2Omotore, BigDecimal tempFumiAvalle, BigDecimal tempFumiAmonte, BigDecimal sovraFreqSoglia1, BigDecimal sovraFreqSoglia2, BigDecimal sovraFreqSoglia3, BigDecimal sovraFreqTempo1, BigDecimal sovraFreqTempo2, BigDecimal sovraFreqTempo3, BigDecimal sottoFreqSoglia1, BigDecimal sottoFreqSoglia2, BigDecimal sottoFreqSoglia3, BigDecimal sottoFreqTempo1, BigDecimal sottoFreqTempo2, BigDecimal sottoFreqTempo3, BigDecimal sovraTensSoglia1, BigDecimal sovraTensSoglia2, BigDecimal sovraTensSoglia3, BigDecimal sovraTensTempo1, BigDecimal sovraTensTempo2, BigDecimal sovraTensTempo3, BigDecimal sottoTensSoglia1, BigDecimal sottoTensSoglia2, BigDecimal sottoTensSoglia3, BigDecimal sottoTensTempo1, BigDecimal sottoTensTempo2, BigDecimal sottoTensTempo3) {
		this.tempFumi = tempFumi;
		this.tempAria = tempAria;
		this.o2 = o2;
		this.co2 = co2;
		this.bacharach1 = bacharach1;
		this.bacharach2 = bacharach2;
		this.bacharach3 = bacharach3;
		this.cOcorretto = cOcorretto;
		this.rendimCombu = rendimCombu;
		this.rendimentoLegge = rendimentoLegge;
		this.nox = nox;
		this.moduloTermico = moduloTermico;
		this.portataCombu = portataCombu;
		this.valorePortata = valorePortata;
		this.coFumiSecchi = coFumiSecchi;
		this.rispettoIndBacharach = rispettoIndBacharach;
		this.minimo = minimo;
		this.particolato = particolato;
		this.noxUM = noxUM;
		this.surrisc = surrisc;
		this.sottoRaffr = sottoRaffr;
		this.condens = condens;
		this.evaporaz = evaporaz;
		this.ingLatoEst = ingLatoEst;
		this.uscLatoEst = uscLatoEst;
		this.ingLatoUtenze = ingLatoUtenze;
		this.uscLatoUtenze = uscLatoUtenze;
		this.numCircuito = numCircuito;
		this.tuscFluido = tuscFluido;
		this.tbulboUmido = tbulboUmido;
		this.tingFluidoSorg = tingFluidoSorg;
		this.tuscFluidoSorg = tuscFluidoSorg;
		this.tingFluidoMacc = tingFluidoMacc;
		this.tuscFluidoMacc = tuscFluidoMacc;
		this.potenzaAss = potenzaAss;
		this.filtriPuliti = filtriPuliti;
		this.verifica = verifica;
		this.dataRipristino = dataRipristino;
		this.tempEst = tempEst;
		this.tempMandPrim = tempMandPrim;
		this.tempRitPrim = tempRitPrim;
		this.potenzaTerm = potenzaTerm;
		this.portataFluido = portataFluido;
		this.tempMandSecond = tempMandSecond;
		this.tempRitSecond = tempRitSecond;
		this.tempAriaCombur = tempAriaCombur;
		this.tempAcquaUsc = tempAcquaUsc;
		this.tempAcquaIng = tempAcquaIng;
		this.potenzaMorsetti = potenzaMorsetti;
		this.tempH2Omotore = tempH2Omotore;
		this.tempFumiAvalle = tempFumiAvalle;
		this.tempFumiAmonte = tempFumiAmonte;
		this.sovraFreqSoglia1 = sovraFreqSoglia1;
		this.sovraFreqSoglia2 = sovraFreqSoglia2;
		this.sovraFreqSoglia3 = sovraFreqSoglia3;
		this.sovraFreqTempo1 = sovraFreqTempo1;
		this.sovraFreqTempo2 = sovraFreqTempo2;
		this.sovraFreqTempo3 = sovraFreqTempo3;
		this.sottoFreqSoglia1 = sottoFreqSoglia1;
		this.sottoFreqSoglia2 = sottoFreqSoglia2;
		this.sottoFreqSoglia3 = sottoFreqSoglia3;
		this.sottoFreqTempo1 = sottoFreqTempo1;
		this.sottoFreqTempo2 = sottoFreqTempo2;
		this.sottoFreqTempo3 = sottoFreqTempo3;
		this.sovraTensSoglia1 = sovraTensSoglia1;
		this.sovraTensSoglia2 = sovraTensSoglia2;
		this.sovraTensSoglia3 = sovraTensSoglia3;
		this.sovraTensTempo1 = sovraTensTempo1;
		this.sovraTensTempo2 = sovraTensTempo2;
		this.sovraTensTempo3 = sovraTensTempo3;
		this.sottoTensSoglia1 = sottoTensSoglia1;
		this.sottoTensSoglia2 = sottoTensSoglia2;
		this.sottoTensSoglia3 = sottoTensSoglia3;
		this.sottoTensTempo1 = sottoTensTempo1;
		this.sottoTensTempo2 = sottoTensTempo2;
		this.sottoTensTempo3 = sottoTensTempo3;
	}

	public BigDecimal getTempFumi() {
		return tempFumi;
	}

	public void setTempFumi(BigDecimal tempFumi) {
		this.tempFumi = tempFumi;
	}

	public BigDecimal getTempAria() {
		return tempAria;
	}

	public void setTempAria(BigDecimal tempAria) {
		this.tempAria = tempAria;
	}

	public BigDecimal getO2() {
		return o2;
	}

	public void setO2(BigDecimal o2) {
		this.o2 = o2;
	}

	public BigDecimal getCo2() {
		return co2;
	}

	public void setCo2(BigDecimal co2) {
		this.co2 = co2;
	}

	public BigDecimal getBacharach1() {
		return bacharach1;
	}

	public void setBacharach1(BigDecimal bacharach1) {
		this.bacharach1 = bacharach1;
	}

	public BigDecimal getBacharach2() {
		return bacharach2;
	}

	public void setBacharach2(BigDecimal bacharach2) {
		this.bacharach2 = bacharach2;
	}

	public BigDecimal getBacharach3() {
		return bacharach3;
	}

	public void setBacharach3(BigDecimal bacharach3) {
		this.bacharach3 = bacharach3;
	}

	public BigDecimal getcOcorretto() {
		return cOcorretto;
	}

	public void setcOcorretto(BigDecimal cOcorretto) {
		this.cOcorretto = cOcorretto;
	}

	public BigDecimal getRendimCombu() {
		return rendimCombu;
	}

	public void setRendimCombu(BigDecimal rendimCombu) {
		this.rendimCombu = rendimCombu;
	}

	public BigDecimal getRendimentoLegge() {
		return rendimentoLegge;
	}

	public void setRendimentoLegge(BigDecimal rendimentoLegge) {
		this.rendimentoLegge = rendimentoLegge;
	}

	public BigDecimal getNox() {
		return nox;
	}

	public void setNox(BigDecimal nox) {
		this.nox = nox;
	}

	public BigInteger getModuloTermico() {
		return moduloTermico;
	}

	public void setModuloTermico(BigInteger moduloTermico) {
		this.moduloTermico = moduloTermico;
	}

	public String getPortataCombu() {
		return portataCombu;
	}

	public void setPortataCombu(String portataCombu) {
		this.portataCombu = portataCombu;
	}

	public BigDecimal getValorePortata() {
		return valorePortata;
	}

	public void setValorePortata(BigDecimal valorePortata) {
		this.valorePortata = valorePortata;
	}

	public BigDecimal getCoFumiSecchi() {
		return coFumiSecchi;
	}

	public void setCoFumiSecchi(BigDecimal coFumiSecchi) {
		this.coFumiSecchi = coFumiSecchi;
	}

	public BigInteger getRispettoIndBacharach() {
		return rispettoIndBacharach;
	}

	public void setRispettoIndBacharach(BigInteger rispettoIndBacharach) {
		this.rispettoIndBacharach = rispettoIndBacharach;
	}

	public BigInteger getMinimo() {
		return minimo;
	}

	public void setMinimo(BigInteger minimo) {
		this.minimo = minimo;
	}

	public BigDecimal getParticolato() {
		return particolato;
	}

	public void setParticolato(BigDecimal particolato) {
		this.particolato = particolato;
	}

	public String getNoxUM() {
		return noxUM;
	}

	public void setNoxUM(String noxUM) {
		this.noxUM = noxUM;
	}

	public BigDecimal getSurrisc() {
		return surrisc;
	}

	public void setSurrisc(BigDecimal surrisc) {
		this.surrisc = surrisc;
	}

	public BigDecimal getSottoRaffr() {
		return sottoRaffr;
	}

	public void setSottoRaffr(BigDecimal sottoRaffr) {
		this.sottoRaffr = sottoRaffr;
	}

	public BigDecimal getCondens() {
		return condens;
	}

	public void setCondens(BigDecimal condens) {
		this.condens = condens;
	}

	public BigDecimal getEvaporaz() {
		return evaporaz;
	}

	public void setEvaporaz(BigDecimal evaporaz) {
		this.evaporaz = evaporaz;
	}

	public BigDecimal getIngLatoEst() {
		return ingLatoEst;
	}

	public void setIngLatoEst(BigDecimal ingLatoEst) {
		this.ingLatoEst = ingLatoEst;
	}

	public BigDecimal getUscLatoEst() {
		return uscLatoEst;
	}

	public void setUscLatoEst(BigDecimal uscLatoEst) {
		this.uscLatoEst = uscLatoEst;
	}

	public BigDecimal getIngLatoUtenze() {
		return ingLatoUtenze;
	}

	public void setIngLatoUtenze(BigDecimal ingLatoUtenze) {
		this.ingLatoUtenze = ingLatoUtenze;
	}

	public BigDecimal getUscLatoUtenze() {
		return uscLatoUtenze;
	}

	public void setUscLatoUtenze(BigDecimal uscLatoUtenze) {
		this.uscLatoUtenze = uscLatoUtenze;
	}

	public BigInteger getNumCircuito() {
		return numCircuito;
	}

	public void setNumCircuito(BigInteger numCircuito) {
		this.numCircuito = numCircuito;
	}

	public BigDecimal getTuscFluido() {
		return tuscFluido;
	}

	public void setTuscFluido(BigDecimal tuscFluido) {
		this.tuscFluido = tuscFluido;
	}

	public BigDecimal getTbulboUmido() {
		return tbulboUmido;
	}

	public void setTbulboUmido(BigDecimal tbulboUmido) {
		this.tbulboUmido = tbulboUmido;
	}

	public BigDecimal getTingFluidoSorg() {
		return tingFluidoSorg;
	}

	public void setTingFluidoSorg(BigDecimal tingFluidoSorg) {
		this.tingFluidoSorg = tingFluidoSorg;
	}

	public BigDecimal getTuscFluidoSorg() {
		return tuscFluidoSorg;
	}

	public void setTuscFluidoSorg(BigDecimal tuscFluidoSorg) {
		this.tuscFluidoSorg = tuscFluidoSorg;
	}

	public BigDecimal getTingFluidoMacc() {
		return tingFluidoMacc;
	}

	public void setTingFluidoMacc(BigDecimal tingFluidoMacc) {
		this.tingFluidoMacc = tingFluidoMacc;
	}

	public BigDecimal getTuscFluidoMacc() {
		return tuscFluidoMacc;
	}

	public void setTuscFluidoMacc(BigDecimal tuscFluidoMacc) {
		this.tuscFluidoMacc = tuscFluidoMacc;
	}

	public BigDecimal getPotenzaAss() {
		return potenzaAss;
	}

	public void setPotenzaAss(BigDecimal potenzaAss) {
		this.potenzaAss = potenzaAss;
	}

	public Boolean getFiltriPuliti() {
		return filtriPuliti;
	}

	public void setFiltriPuliti(Boolean filtriPuliti) {
		this.filtriPuliti = filtriPuliti;
	}

	public boolean isVerifica() {
		return verifica;
	}

	public void setVerifica(boolean verifica) {
		this.verifica = verifica;
	}

	public String getDataRipristino() {
		return dataRipristino;
	}

	public void setDataRipristino(String dataRipristino) {
		this.dataRipristino = dataRipristino;
	}

	public BigDecimal getTempEst() {
		return tempEst;
	}

	public void setTempEst(BigDecimal tempEst) {
		this.tempEst = tempEst;
	}

	public BigDecimal getTempMandPrim() {
		return tempMandPrim;
	}

	public void setTempMandPrim(BigDecimal tempMandPrim) {
		this.tempMandPrim = tempMandPrim;
	}

	public BigDecimal getTempRitPrim() {
		return tempRitPrim;
	}

	public void setTempRitPrim(BigDecimal tempRitPrim) {
		this.tempRitPrim = tempRitPrim;
	}

	public BigDecimal getPotenzaTerm() {
		return potenzaTerm;
	}

	public void setPotenzaTerm(BigDecimal potenzaTerm) {
		this.potenzaTerm = potenzaTerm;
	}

	public BigDecimal getPortataFluido() {
		return portataFluido;
	}

	public void setPortataFluido(BigDecimal portataFluido) {
		this.portataFluido = portataFluido;
	}

	public BigDecimal getTempMandSecond() {
		return tempMandSecond;
	}

	public void setTempMandSecond(BigDecimal tempMandSecond) {
		this.tempMandSecond = tempMandSecond;
	}

	public BigDecimal getTempRitSecond() {
		return tempRitSecond;
	}

	public void setTempRitSecond(BigDecimal tempRitSecond) {
		this.tempRitSecond = tempRitSecond;
	}

	public BigDecimal getTempAriaCombur() {
		return tempAriaCombur;
	}

	public void setTempAriaCombur(BigDecimal tempAriaCombur) {
		this.tempAriaCombur = tempAriaCombur;
	}

	public BigDecimal getTempAcquaUsc() {
		return tempAcquaUsc;
	}

	public void setTempAcquaUsc(BigDecimal tempAcquaUsc) {
		this.tempAcquaUsc = tempAcquaUsc;
	}

	public BigDecimal getTempAcquaIng() {
		return tempAcquaIng;
	}

	public void setTempAcquaIng(BigDecimal tempAcquaIng) {
		this.tempAcquaIng = tempAcquaIng;
	}

	public BigDecimal getPotenzaMorsetti() {
		return potenzaMorsetti;
	}

	public void setPotenzaMorsetti(BigDecimal potenzaMorsetti) {
		this.potenzaMorsetti = potenzaMorsetti;
	}

	public BigDecimal getTempH2Omotore() {
		return tempH2Omotore;
	}

	public void setTempH2Omotore(BigDecimal tempH2Omotore) {
		this.tempH2Omotore = tempH2Omotore;
	}

	public BigDecimal getTempFumiAvalle() {
		return tempFumiAvalle;
	}

	public void setTempFumiAvalle(BigDecimal tempFumiAvalle) {
		this.tempFumiAvalle = tempFumiAvalle;
	}

	public BigDecimal getTempFumiAmonte() {
		return tempFumiAmonte;
	}

	public void setTempFumiAmonte(BigDecimal tempFumiAmonte) {
		this.tempFumiAmonte = tempFumiAmonte;
	}

	public BigDecimal getSovraFreqSoglia1() {
		return sovraFreqSoglia1;
	}

	public void setSovraFreqSoglia1(BigDecimal sovraFreqSoglia1) {
		this.sovraFreqSoglia1 = sovraFreqSoglia1;
	}

	public BigDecimal getSovraFreqSoglia2() {
		return sovraFreqSoglia2;
	}

	public void setSovraFreqSoglia2(BigDecimal sovraFreqSoglia2) {
		this.sovraFreqSoglia2 = sovraFreqSoglia2;
	}

	public BigDecimal getSovraFreqSoglia3() {
		return sovraFreqSoglia3;
	}

	public void setSovraFreqSoglia3(BigDecimal sovraFreqSoglia3) {
		this.sovraFreqSoglia3 = sovraFreqSoglia3;
	}

	public BigDecimal getSovraFreqTempo1() {
		return sovraFreqTempo1;
	}

	public void setSovraFreqTempo1(BigDecimal sovraFreqTempo1) {
		this.sovraFreqTempo1 = sovraFreqTempo1;
	}

	public BigDecimal getSovraFreqTempo2() {
		return sovraFreqTempo2;
	}

	public void setSovraFreqTempo2(BigDecimal sovraFreqTempo2) {
		this.sovraFreqTempo2 = sovraFreqTempo2;
	}

	public BigDecimal getSovraFreqTempo3() {
		return sovraFreqTempo3;
	}

	public void setSovraFreqTempo3(BigDecimal sovraFreqTempo3) {
		this.sovraFreqTempo3 = sovraFreqTempo3;
	}

	public BigDecimal getSottoFreqSoglia1() {
		return sottoFreqSoglia1;
	}

	public void setSottoFreqSoglia1(BigDecimal sottoFreqSoglia1) {
		this.sottoFreqSoglia1 = sottoFreqSoglia1;
	}

	public BigDecimal getSottoFreqSoglia2() {
		return sottoFreqSoglia2;
	}

	public void setSottoFreqSoglia2(BigDecimal sottoFreqSoglia2) {
		this.sottoFreqSoglia2 = sottoFreqSoglia2;
	}

	public BigDecimal getSottoFreqSoglia3() {
		return sottoFreqSoglia3;
	}

	public void setSottoFreqSoglia3(BigDecimal sottoFreqSoglia3) {
		this.sottoFreqSoglia3 = sottoFreqSoglia3;
	}

	public BigDecimal getSottoFreqTempo1() {
		return sottoFreqTempo1;
	}

	public void setSottoFreqTempo1(BigDecimal sottoFreqTempo1) {
		this.sottoFreqTempo1 = sottoFreqTempo1;
	}

	public BigDecimal getSottoFreqTempo2() {
		return sottoFreqTempo2;
	}

	public void setSottoFreqTempo2(BigDecimal sottoFreqTempo2) {
		this.sottoFreqTempo2 = sottoFreqTempo2;
	}

	public BigDecimal getSottoFreqTempo3() {
		return sottoFreqTempo3;
	}

	public void setSottoFreqTempo3(BigDecimal sottoFreqTempo3) {
		this.sottoFreqTempo3 = sottoFreqTempo3;
	}

	public BigDecimal getSovraTensSoglia1() {
		return sovraTensSoglia1;
	}

	public void setSovraTensSoglia1(BigDecimal sovraTensSoglia1) {
		this.sovraTensSoglia1 = sovraTensSoglia1;
	}

	public BigDecimal getSovraTensSoglia2() {
		return sovraTensSoglia2;
	}

	public void setSovraTensSoglia2(BigDecimal sovraTensSoglia2) {
		this.sovraTensSoglia2 = sovraTensSoglia2;
	}

	public BigDecimal getSovraTensSoglia3() {
		return sovraTensSoglia3;
	}

	public void setSovraTensSoglia3(BigDecimal sovraTensSoglia3) {
		this.sovraTensSoglia3 = sovraTensSoglia3;
	}

	public BigDecimal getSovraTensTempo1() {
		return sovraTensTempo1;
	}

	public void setSovraTensTempo1(BigDecimal sovraTensTempo1) {
		this.sovraTensTempo1 = sovraTensTempo1;
	}

	public BigDecimal getSovraTensTempo2() {
		return sovraTensTempo2;
	}

	public void setSovraTensTempo2(BigDecimal sovraTensTempo2) {
		this.sovraTensTempo2 = sovraTensTempo2;
	}

	public BigDecimal getSovraTensTempo3() {
		return sovraTensTempo3;
	}

	public void setSovraTensTempo3(BigDecimal sovraTensTempo3) {
		this.sovraTensTempo3 = sovraTensTempo3;
	}

	public BigDecimal getSottoTensSoglia1() {
		return sottoTensSoglia1;
	}

	public void setSottoTensSoglia1(BigDecimal sottoTensSoglia1) {
		this.sottoTensSoglia1 = sottoTensSoglia1;
	}

	public BigDecimal getSottoTensSoglia2() {
		return sottoTensSoglia2;
	}

	public void setSottoTensSoglia2(BigDecimal sottoTensSoglia2) {
		this.sottoTensSoglia2 = sottoTensSoglia2;
	}

	public BigDecimal getSottoTensSoglia3() {
		return sottoTensSoglia3;
	}

	public void setSottoTensSoglia3(BigDecimal sottoTensSoglia3) {
		this.sottoTensSoglia3 = sottoTensSoglia3;
	}

	public BigDecimal getSottoTensTempo1() {
		return sottoTensTempo1;
	}

	public void setSottoTensTempo1(BigDecimal sottoTensTempo1) {
		this.sottoTensTempo1 = sottoTensTempo1;
	}

	public BigDecimal getSottoTensTempo2() {
		return sottoTensTempo2;
	}

	public void setSottoTensTempo2(BigDecimal sottoTensTempo2) {
		this.sottoTensTempo2 = sottoTensTempo2;
	}

	public BigDecimal getSottoTensTempo3() {
		return sottoTensTempo3;
	}

	public void setSottoTensTempo3(BigDecimal sottoTensTempo3) {
		this.sottoTensTempo3 = sottoTensTempo3;
	}

	@Override
	public String toString() {
		return "RowFumiModel{" + "tempFumi=" + tempFumi + ", tempAria=" + tempAria + ", o2=" + o2 + ", co2=" + co2 + ", bacharach1=" + bacharach1 + ", bacharach2=" + bacharach2 + ", bacharach3="
				+ bacharach3 + ", cOcorretto=" + cOcorretto + ", rendimCombu=" + rendimCombu + ", rendimentoLegge=" + rendimentoLegge + ", nox=" + nox + ", moduloTermico=" + moduloTermico
				+ ", portataCombu='" + portataCombu + '\'' + ", valorePortata=" + valorePortata + ", coFumiSecchi=" + coFumiSecchi + ", rispettoIndBacharach=" + rispettoIndBacharach + ", minimo="
				+ minimo + ", particolato=" + particolato + ", noxUM='" + noxUM + '\'' + ", surrisc=" + surrisc + ", sottoRaffr=" + sottoRaffr + ", condens=" + condens + ", evaporaz=" + evaporaz
				+ ", ingLatoEst=" + ingLatoEst + ", uscLatoEst=" + uscLatoEst + ", ingLatoUtenze=" + ingLatoUtenze + ", uscLatoUtenze=" + uscLatoUtenze + ", numCircuito=" + numCircuito
				+ ", tuscFluido=" + tuscFluido + ", tbulboUmido=" + tbulboUmido + ", tingFluidoSorg=" + tingFluidoSorg + ", tuscFluidoSorg=" + tuscFluidoSorg + ", tingFluidoMacc=" + tingFluidoMacc
				+ ", tuscFluidoMacc=" + tuscFluidoMacc + ", potenzaAss=" + potenzaAss + ", filtriPuliti=" + filtriPuliti + ", verifica=" + verifica + ", dataRipristino='" + dataRipristino + '\''
				+ ", tempEst=" + tempEst + ", tempMandPrim=" + tempMandPrim + ", tempRitPrim=" + tempRitPrim + ", potenzaTerm=" + potenzaTerm + ", portataFluido=" + portataFluido + ", tempMandSecond="
				+ tempMandSecond + ", tempRitSecond=" + tempRitSecond + ", tempAriaCombur=" + tempAriaCombur + ", tempAcquaUsc=" + tempAcquaUsc + ", tempAcquaIng=" + tempAcquaIng
				+ ", potenzaMorsetti=" + potenzaMorsetti + ", tempH2Omotore=" + tempH2Omotore + ", tempFumiAvalle=" + tempFumiAvalle + ", tempFumiAmonte=" + tempFumiAmonte + ", sovraFreqSoglia1="
				+ sovraFreqSoglia1 + ", sovraFreqSoglia2=" + sovraFreqSoglia2 + ", sovraFreqSoglia3=" + sovraFreqSoglia3 + ", sovraFreqTempo1=" + sovraFreqTempo1 + ", sovraFreqTempo2="
				+ sovraFreqTempo2 + ", sovraFreqTempo3=" + sovraFreqTempo3 + ", sottoFreqSoglia1=" + sottoFreqSoglia1 + ", sottoFreqSoglia2=" + sottoFreqSoglia2 + ", sottoFreqSoglia3="
				+ sottoFreqSoglia3 + ", sottoFreqTempo1=" + sottoFreqTempo1 + ", sottoFreqTempo2=" + sottoFreqTempo2 + ", sottoFreqTempo3=" + sottoFreqTempo3 + ", sovraTensSoglia1=" + sovraTensSoglia1
				+ ", sovraTensSoglia2=" + sovraTensSoglia2 + ", sovraTensSoglia3=" + sovraTensSoglia3 + ", sovraTensTempo1=" + sovraTensTempo1 + ", sovraTensTempo2=" + sovraTensTempo2
				+ ", sovraTensTempo3=" + sovraTensTempo3 + ", sottoTensSoglia1=" + sottoTensSoglia1 + ", sottoTensSoglia2=" + sottoTensSoglia2 + ", sottoTensSoglia3=" + sottoTensSoglia3
				+ ", sottoTensTempo1=" + sottoTensTempo1 + ", sottoTensTempo2=" + sottoTensTempo2 + ", sottoTensTempo3=" + sottoTensTempo3 + '}';
	}
}
