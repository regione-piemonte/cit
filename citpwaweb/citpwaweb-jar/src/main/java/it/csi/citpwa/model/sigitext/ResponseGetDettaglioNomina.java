package it.csi.citpwa.model.sigitext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResponseGetDettaglioNomina implements Serializable {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private List<DatiImpresa> datiImpresa;
	private List<DatiContratto> datiContratto;
	private List<DatiImpianto> datiImpianto;
	private List<Persona> persona;
	private List<DatiAffidamento> datiAffidamento;
	private List<Autodichiarazione> autodichiarazione;
	
	public List<DatiImpresa> getDatiImpresa() {
		if(datiImpresa == null) {
			datiImpresa = new ArrayList<>();
		}
		return datiImpresa;
	}
	public void setDatiImpresa(List<DatiImpresa> datiImpresa) {
		this.datiImpresa = datiImpresa;
	}
	public List<DatiContratto> getDatiContratto() {
		if(datiContratto == null) {
			datiContratto = new ArrayList<>();
		}
		return datiContratto;
	}
	public void setDatiContratto(List<DatiContratto> datiContratto) {
		this.datiContratto = datiContratto;
	}
	public List<DatiImpianto> getDatiImpianto() {
		if(datiImpianto == null) {
			datiImpianto = new ArrayList<>();
		}
		return datiImpianto;
	}
	public void setDatiImpianto(List<DatiImpianto> datiImpianto) {
		this.datiImpianto = datiImpianto;
	}
	public List<Persona> getPersona() {
		if(persona == null) {
			persona = new ArrayList<>();
		}
		return persona;
	}
	public void setPersona(List<Persona> persona) {
		this.persona = persona;
	}
	public List<DatiAffidamento> getDatiAffidamento() {
		if(datiAffidamento == null) {
			datiAffidamento = new ArrayList<>();
		}
		return datiAffidamento;
	}
	public void setDatiAffidamento(List<DatiAffidamento> datiAffidamento) {
		this.datiAffidamento = datiAffidamento;
	}
	public List<Autodichiarazione> getAutodichiarazione(){
		if(autodichiarazione == null) {
			autodichiarazione = new ArrayList<>();
		}
		return autodichiarazione;
	}
	public void setAutodichiarazione(List<Autodichiarazione> autodichiarazione) {
		this.autodichiarazione = autodichiarazione;
	}
	
	
	
}
