/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.pdf;

import java.math.BigDecimal;
import java.util.List;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaFisicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTTrattH2ODto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTUnitaImmobiliareDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVSk4CgDto;

public class DatiCGCommon {
	
	private SigitTAllegatoDto allegatoDto;
	private SigitTImpiantoDto impiantoDto;
	private SigitTPersonaFisicaDto personaFisicaDto;
	private SigitTPersonaGiuridicaDto personaGiuridicaDto;
	private BigDecimal idImpRuoloPfpg;
	private boolean isTerzoResp;
	private int idRuolo;
	private List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare;
	private SigitTTrattH2ODto dettaglioTrattAcqua;
	List<SigitVSk4CgDto> sk4CgDtoList;
	
	public SigitTAllegatoDto getAllegatoDto() {
		return allegatoDto;
	}
	public void setAllegatoDto(SigitTAllegatoDto allegatoDto) {
		this.allegatoDto = allegatoDto;
	}
	public SigitTImpiantoDto getImpiantoDto() {
		return impiantoDto;
	}
	public void setImpiantoDto(SigitTImpiantoDto impiantoDto) {
		this.impiantoDto = impiantoDto;
	}
	public SigitTPersonaFisicaDto getPersonaFisicaDto() {
		return personaFisicaDto;
	}
	public void setPersonaFisicaDto(SigitTPersonaFisicaDto personaFisicaDto) {
		this.personaFisicaDto = personaFisicaDto;
	}
	public SigitTPersonaGiuridicaDto getPersonaGiuridicaDto() {
		return personaGiuridicaDto;
	}
	public void setPersonaGiuridicaDto(SigitTPersonaGiuridicaDto personaGiuridicaDto) {
		this.personaGiuridicaDto = personaGiuridicaDto;
	}
	public BigDecimal getIdImpRuoloPfpg() {
		return idImpRuoloPfpg;
	}
	public void setIdImpRuoloPfpg(BigDecimal idImpRuoloPfpg) {
		this.idImpRuoloPfpg = idImpRuoloPfpg;
	}
	public boolean isTerzoResp() {
		return isTerzoResp;
	}
	public void setTerzoResp(boolean isTerzoResp) {
		this.isTerzoResp = isTerzoResp;
	}
	public int getIdRuolo() {
		return idRuolo;
	}
	public void setIdRuolo(int idRuolo) {
		this.idRuolo = idRuolo;
	}
	public List<SigitTUnitaImmobiliareDto> getListaUnitaImmobiliare() {
		return listaUnitaImmobiliare;
	}
	public void setListaUnitaImmobiliare(List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare) {
		this.listaUnitaImmobiliare = listaUnitaImmobiliare;
	}
	public SigitTTrattH2ODto getDettaglioTrattAcqua() {
		return dettaglioTrattAcqua;
	}
	public void setDettaglioTrattAcqua(SigitTTrattH2ODto dettaglioTrattAcqua) {
		this.dettaglioTrattAcqua = dettaglioTrattAcqua;
	}
	public List<SigitVSk4CgDto> getSk4CgDtoList() {
		return sk4CgDtoList;
	}
	public void setSk4CgDtoList(List<SigitVSk4CgDto> sk4CgDtoList) {
		this.sk4CgDtoList = sk4CgDtoList;
	}
}
