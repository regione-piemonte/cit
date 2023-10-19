/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.pdf;

import java.util.List;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaFisicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTTrattH2ODto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTUnitaImmobiliareDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVSk4ScDto;

public class DatiSCCommon {

	private SigitTImpiantoDto impiantoDto;
	private List<SigitTUnitaImmobiliareDto> unitaImmobiliareList;
	private SigitTAllegatoDto allegatoDto;
	private List<SigitVSk4ScDto> sk4ScDtoList;
	private SigitTPersonaGiuridicaDto personaGiuridicaDto;
	private SigitTPersonaFisicaDto personaFisicaDto;
	private SigitTTrattH2ODto dettaglioTrattAcquaDto;
	private int ruolo;
	private boolean isTerzoResp;
	
	public SigitTImpiantoDto getImpiantoDto() {
		return impiantoDto;
	}
	
	public void setImpiantoDto(SigitTImpiantoDto impiantoDto) {
		this.impiantoDto = impiantoDto;
	}
	
	public List<SigitTUnitaImmobiliareDto> getUnitaImmobiliareList() {
		return unitaImmobiliareList;
	}
	
	public void setUnitaImmobiliareList(List<SigitTUnitaImmobiliareDto> unitaImmobiliareList) {
		this.unitaImmobiliareList = unitaImmobiliareList;
	}
	
	public SigitTAllegatoDto getAllegatoDto() {
		return allegatoDto;
	}
	
	public void setAllegatoDto(SigitTAllegatoDto allegatoDto) {
		this.allegatoDto = allegatoDto;
	}
	
	public List<SigitVSk4ScDto> getSk4ScDtoList() {
		return sk4ScDtoList;
	}
	
	public void setSk4ScDtoList(List<SigitVSk4ScDto> sk4ScDtoList) {
		this.sk4ScDtoList = sk4ScDtoList;
	}
	
	public SigitTPersonaGiuridicaDto getPersonaGiuridicaDto() {
		return personaGiuridicaDto;
	}
	
	public void setPersonaGiuridicaDto(SigitTPersonaGiuridicaDto personaGiuridicaDto) {
		this.personaGiuridicaDto = personaGiuridicaDto;
	}
	
	public SigitTPersonaFisicaDto getPersonaFisicaDto() {
		return personaFisicaDto;
	}
	
	public void setPersonaFisicaDto(SigitTPersonaFisicaDto personaFisicaDto) {
		this.personaFisicaDto = personaFisicaDto;
	}
	
	public SigitTTrattH2ODto getDettaglioTrattAcquaDto() {
		return dettaglioTrattAcquaDto;
	}
	
	public void setDettaglioTrattAcquaDto(SigitTTrattH2ODto dettaglioTrattAcquaDto) {
		this.dettaglioTrattAcquaDto = dettaglioTrattAcquaDto;
	}
	
	public int getRuolo() {
		return ruolo;
	}
	
	public void setRuolo(int ruolo) {
		this.ruolo = ruolo;
	}
	
	public boolean isTerzoResp() {
		return isTerzoResp;
	}
	
	public void setTerzoResp(boolean isTerzoResp) {
		this.isTerzoResp = isTerzoResp;
	}
	
}
