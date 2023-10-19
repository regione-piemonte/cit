/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.pdf;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.*;

import java.util.List;

public class DatiGTCommon {

	SigitTImpiantoDto impiantoDto;
	List<SigitTUnitaImmobiliareDto> unitaImmobiliareList;
	SigitTAllegatoDto allegatoDto;
	List<SigitVSk4GtDto> sk4GtDtoList;
	SigitTPersonaGiuridicaDto personaGiuridicaDto;
	SigitTPersonaFisicaDto personaFisicaDto;
	SigitTTrattH2ODto dettaglioTrattAcquaDto;
	int ruolo;
	boolean isTerzoResp;
	
	
	
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
	public List<SigitVSk4GtDto> getSk4GtDtoList() {
		return sk4GtDtoList;
	}
	public void setSk4GtDtoList(List<SigitVSk4GtDto> sk4GtDtoList) {
		this.sk4GtDtoList = sk4GtDtoList;
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
	public void setDettaglioTrattAcquaDto(SigitTTrattH2ODto dettaglioTrattAcquaSto) {
		this.dettaglioTrattAcquaDto = dettaglioTrattAcquaSto;
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
