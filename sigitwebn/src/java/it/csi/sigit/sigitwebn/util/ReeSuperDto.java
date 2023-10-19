/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.PropertyUtils;

import it.csi.sigit.sigitwebn.dto.ree.Tipo1;
import it.csi.sigit.sigitwebn.dto.ree.Tipo2;
import it.csi.sigit.sigitwebn.dto.ree.Tipo3;
import it.csi.sigit.sigitwebn.dto.ree.Tipo4;

public class ReeSuperDto {

	private String potenzaTermicaNomMax;
	
	private String responsabileImpianto;
	
	private String impresaManutInstal;
	
	private Integer flgDichiarConform;
	
	private Integer flgLibImp;
	
	private Integer flgLibrettoUso;
	
	private Integer flgLibCompl;
	
	private String durezzaH2OFr;
	
	private String descTrattClima;
	
	private String descTrattAcs;
	
	private String osservazioni;
	
	private String raccomandazioni;
	
	private String prescrizioni;
	
	private Integer flgPuoFunzionare;
	
	private String interventoEntro;
	
	private String oraArrivo;
	
	private String oraPartenza;
	
	private String denominazTecnico;
	
	public static Tipo1 getTipo1(ReeSuperDto input) {
		Tipo1 output = new Tipo1();
		if (input == null) {
			return output;
		}
		try {
			PropertyUtils.copyProperties(output, input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static Tipo2 getTipo2(ReeSuperDto input) {
		Tipo2 output = new Tipo2();
		if (input == null) {
			return output;
		}
		try {
			PropertyUtils.copyProperties(output, input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static Tipo3 getTipo3(ReeSuperDto input) {
		Tipo3 output = new Tipo3();
		if (input == null) {
			return output;
		}
		try {
			PropertyUtils.copyProperties(output, input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static Tipo4 getTipo4(ReeSuperDto input) {
		Tipo4 output = new Tipo4();
		if (input == null) {
			return output;
		}
		try {
			PropertyUtils.copyProperties(output, input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static ReeSuperDto getByTipo1(Tipo1 input) {
		ReeSuperDto output = new ReeSuperDto();
		if (input == null) {
			return output;
		}
		try {
			PropertyUtils.copyProperties(output, input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
		
	}
	
	public static ReeSuperDto getByTipo2(Tipo2 input) {
		ReeSuperDto output = new ReeSuperDto();
		if (input == null) {
			return output;
		}
		try {
			PropertyUtils.copyProperties(output, input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
		
	}
	
	public static ReeSuperDto getByTipo3(Tipo3 input) {
		ReeSuperDto output = new ReeSuperDto();
		if (input == null) {
			return output;
		}
		try {
			PropertyUtils.copyProperties(output, input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
		
	}

	public static ReeSuperDto getByTipo4(Tipo4 input) {
		ReeSuperDto output = new ReeSuperDto();
		if (input == null) {
			return output;
		}
		try {
			PropertyUtils.copyProperties(output, input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
		
	}
	
	public String getPotenzaTermicaNomMax() {
		return potenzaTermicaNomMax;
	}

	public void setPotenzaTermicaNomMax(String potenzaTermicaNomMax) {
		this.potenzaTermicaNomMax = potenzaTermicaNomMax;
	}

	public String getResponsabileImpianto() {
		return responsabileImpianto;
	}

	public void setResponsabileImpianto(String responsabileImpianto) {
		this.responsabileImpianto = responsabileImpianto;
	}

	public String getImpresaManutInstal() {
		return impresaManutInstal;
	}

	public void setImpresaManutInstal(String impresaManutInstal) {
		this.impresaManutInstal = impresaManutInstal;
	}

	public Integer getFlgDichiarConform() {
		return flgDichiarConform;
	}

	public void setFlgDichiarConform(Integer flgDichiarConform) {
		this.flgDichiarConform = flgDichiarConform;
	}

	public Integer getFlgLibImp() {
		return flgLibImp;
	}

	public void setFlgLibImp(Integer flgLibImp) {
		this.flgLibImp = flgLibImp;
	}

	public Integer getFlgLibrettoUso() {
		return flgLibrettoUso;
	}

	public void setFlgLibrettoUso(Integer flgLibrettoUso) {
		this.flgLibrettoUso = flgLibrettoUso;
	}

	public Integer getFlgLibCompl() {
		return flgLibCompl;
	}

	public void setFlgLibCompl(Integer flgLibCompl) {
		this.flgLibCompl = flgLibCompl;
	}

	public String getDurezzaH2OFr() {
		return durezzaH2OFr;
	}

	public void setDurezzaH2OFr(String durezzaH2OFr) {
		this.durezzaH2OFr = durezzaH2OFr;
	}

	public String getDescTrattClima() {
		return descTrattClima;
	}

	public void setDescTrattClima(String descTrattClima) {
		this.descTrattClima = descTrattClima;
	}

	public String getDescTrattAcs() {
		return descTrattAcs;
	}

	public void setDescTrattAcs(String descTrattAcs) {
		this.descTrattAcs = descTrattAcs;
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

	public Integer getFlgPuoFunzionare() {
		return flgPuoFunzionare;
	}

	public void setFlgPuoFunzionare(Integer flgPuoFunzionare) {
		this.flgPuoFunzionare = flgPuoFunzionare;
	}

	public String getInterventoEntro() {
		return interventoEntro;
	}

	public void setInterventoEntro(String interventoEntro) {
		this.interventoEntro = interventoEntro;
	}

	public String getOraArrivo() {
		return oraArrivo;
	}

	public void setOraArrivo(String oraArrivo) {
		this.oraArrivo = oraArrivo;
	}

	public String getOraPartenza() {
		return oraPartenza;
	}

	public void setOraPartenza(String oraPartenza) {
		this.oraPartenza = oraPartenza;
	}

	public String getPrescrizioni() {
		return prescrizioni;
	}

	public void setPrescrizioni(String prescrizioni) {
		this.prescrizioni = prescrizioni;
	}

	public String getDenominazTecnico() {
		return denominazTecnico;
	}

	public void setDenominazTecnico(String denominazTecnico) {
		this.denominazTecnico = denominazTecnico;
	}

	
	
	
}
