/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util;


import it.csi.sigit.sigitwebn.dto.accesso.Ruolo;
import it.csi.sigit.sigitwebn.dto.common.CodeDescription;
import it.csi.sigit.sigitwebn.dto.common.IdDescription;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L51SistemaRegolazioneSostituitoDocument.L51SistemaRegolazioneSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L51ValvolaRegolazioneSostituitoDocument.L51ValvolaRegolazioneSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione.L51SR;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione.L51VR;

import java.util.Comparator;

public class ComparatorUtil {
	
	public static Comparator<CodeDescription> compare(){
		Comparator<CodeDescription> result = new Comparator<CodeDescription>() {
			
			public int compare(CodeDescription o1, CodeDescription o2) {
				return o1.getDescription().compareToIgnoreCase(o2.getDescription());
			}
		};
		return result;
	}

	public static Comparator<IdDescription> compareDescriprionById(){
		Comparator<IdDescription> result = new Comparator<IdDescription>() {
			
			public int compare(IdDescription o1, IdDescription o2) {
				return o1.getDescription().compareToIgnoreCase(o2.getDescription());
			}
		};
		return result;
	}
	

	public static Comparator<CodeDescription> compareCode(){
		Comparator<CodeDescription> result = new Comparator<CodeDescription>() {
			
			public int compare(CodeDescription o1, CodeDescription o2) {
				return o1.getCode().compareToIgnoreCase(o2.getCode());
			}
		};
		return result;
	}
	
	public static Comparator<ComparatorDto> compareCamparatorDtoByData(){
		Comparator<ComparatorDto> result = new Comparator<ComparatorDto>() {
			
			public int compare(ComparatorDto o1, ComparatorDto o2) {
//				System.out.println("########");
//				System.out.println(o1.getData());
//				System.out.println(o2.getData());
				
				int i = o2.getData().compareTo(o1.getData()); 
				
//				System.out.println("ris: "+i);
//				System.out.println("########");

				return i;
			}
		};
		return result;
	}
	
	public static Comparator<ComparatorDto> compareCamparatorDtoByProgressivo(){
		Comparator<ComparatorDto> result = new Comparator<ComparatorDto>() {
			
			public int compare(ComparatorDto o1, ComparatorDto o2) {
//				System.out.println("########");
//				System.out.println(o1.getData());
//				System.out.println(o2.getData());
				
				int i = o1.getProgressivo().compareTo(o2.getProgressivo()); 
				
//				System.out.println("ris: "+i);
//				System.out.println("########");

				return i;
			}
		};
		return result;
	}
	
	public static Comparator<L51SistemaRegolazioneSostituito> compareL51SistRegSost(){
		Comparator<L51SistemaRegolazioneSostituito> result = new Comparator<L51SistemaRegolazioneSostituito>() {
			
			public int compare(L51SistemaRegolazioneSostituito o1, L51SistemaRegolazioneSostituito o2) {
				
				int i = ConvertUtil.convertToDate(o1.getL51DataInstallazione()).compareTo(ConvertUtil.convertToDate(o2.getL51DataInstallazione())); 
				
				return i;
			}
		};
		return result;
	}
	
	public static Comparator<L51ValvolaRegolazioneSostituito> compareL51ValvRegSost(){
		Comparator<L51ValvolaRegolazioneSostituito> result = new Comparator<L51ValvolaRegolazioneSostituito>() {
			
			public int compare(L51ValvolaRegolazioneSostituito o1, L51ValvolaRegolazioneSostituito o2) {
				return o1.getL51DataInstallazione().compareTo(o2.getL51DataInstallazione());
			}
		};
		return result;
	}
	
	public static Comparator<L51SR> compareL5SR(){
		Comparator<L51SR> result = new Comparator<L51SR>() {
			
			public int compare(L51SR o1, L51SR o2) {
				return o1.getL51Numero().compareTo(o2.getL51Numero());
			}
		};
		return result;
	}
	
	public static Comparator<L51VR> compareL5VR(){
		Comparator<L51VR> result = new Comparator<L51VR>() {
			
			public int compare(L51VR o1, L51VR o2) {
				return o1.getL51Numero().compareTo(o2.getL51Numero());
			}
		};
		return result;
	}
	
	public static Comparator<Ruolo> compareDenomDittaRuoli(){
		Comparator<Ruolo> result = new Comparator<Ruolo>() {
			
			public int compare(Ruolo o1, Ruolo o2) {
				return o1.getDenomDitta().compareTo(o2.getDenomDitta());
			}
		};
		return result;
	}
	
	public static Comparator<String> prova(){
		Comparator<String> result = new Comparator<String>() {
			
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		return result;
	}
}
