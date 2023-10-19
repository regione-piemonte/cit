/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter;



import it.csi.sigit.sigitext.business.util.ConvertUtil;

import java.sql.Date;
import java.util.List;

public class AllegatiCompFilter {

	private String codImpianto;
	private Integer idContratto;
	private Integer idImpRuoloPfPg;
	private Date dataControllo;
	private Integer idAllegato;
	
	private List<Integer> statiRappEqual; 
	private List<Integer> statiRappNotEqual; 
	private CompFilter componente;
	
	private Date inizioIntervalloDataControllo;
	private Date fineIntervalloDataControllo;
	
	public AllegatiCompFilter()
	{
		
	}
	
	public AllegatiCompFilter(List<Integer> statiRapp, CompFilter componente) {
		this.statiRappEqual = statiRapp;
		this.componente = componente;
		this.codImpianto = ConvertUtil.convertToString(componente.getCodImpianto());
	}

	public AllegatiCompFilter(Integer idPg3R, Integer idAllegato)
	{
		this.idContratto = idPg3R;
		this.idAllegato = idAllegato;
	}
	
	public AllegatiCompFilter(String codImpianto, Integer idContratto, Date dataControllo)
	{
		this.codImpianto = codImpianto;
		this.idContratto = idContratto;
		this.dataControllo = dataControllo;
	}

	public AllegatiCompFilter(String codImpianto, Integer idImpRuoloPfPg)
	{
		this.codImpianto = codImpianto;
		this.idImpRuoloPfPg = idImpRuoloPfPg;
	}
	
	
	public Integer getIdContratto() {
		return idContratto;
	}

	public void setIdContratto(Integer idContratto) {
		this.idContratto = idContratto;
	}

	public String getCodImpianto() {
		return codImpianto;
	}

	public void setCodImpianto(String codImpianto) {
		this.codImpianto = codImpianto;
	}

	public Date getDataControllo() {
		return dataControllo;
	}

	public void setDataControllo(Date dataControllo) {
		this.dataControllo = dataControllo;
	}

	public Integer getIdAllegato() {
		return idAllegato;
	}

	public void setIdAllegato(Integer idAllegato) {
		this.idAllegato = idAllegato;
	}

	public Integer getIdImpRuoloPfPg() {
		return idImpRuoloPfPg;
	}

	public void setIdImpRuoloPfPg(Integer idImpRuoloPfPg) {
		this.idImpRuoloPfPg = idImpRuoloPfPg;
	}

	public List<Integer> getStatiRappEqual() {
		return statiRappEqual;
	}

	public void setStatiRappEqual(List<Integer> statiRappEqual) {
		this.statiRappEqual = statiRappEqual;
	}

	public CompFilter getComponente() {
		return componente;
	}

	public void setComponente(CompFilter componente) {
		this.componente = componente;
	}

	public List<Integer> getStatiRappNotEqual() {
		return statiRappNotEqual;
	}

	public void setStatiRappNotEqual(List<Integer> statiRappNotEqual) {
		this.statiRappNotEqual = statiRappNotEqual;
	}

	public Date getInizioIntervalloDataControllo() {
		return inizioIntervalloDataControllo;
	}

	public void setInizioIntervalloDataControllo(Date inizioIntervalloDataControllo) {
		this.inizioIntervalloDataControllo = inizioIntervalloDataControllo;
	}

	public Date getFineIntervalloDataControllo() {
		return fineIntervalloDataControllo;
	}

	public void setFineIntervalloDataControllo(Date fineIntervalloDataControllo) {
		this.fineIntervalloDataControllo = fineIntervalloDataControllo;
	}
	
	
	
	
	
}
