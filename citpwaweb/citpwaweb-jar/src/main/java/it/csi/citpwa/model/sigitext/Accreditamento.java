package it.csi.citpwa.model.sigitext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Accreditamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Persona persona;
	private List<DatiImpresa> datiImpresaList;
	private List<DatiDelega> datiDelegaList;
	private List<DatiIncarico> datiIncaricoList;
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public List<DatiImpresa> getDatiImpresaList() {
		if(datiImpresaList == null) {
			datiImpresaList = new ArrayList<>();
		}
		
		return datiImpresaList;
	}
	public void setDatiImpresaList(List<DatiImpresa> datiImpresaList) {
		this.datiImpresaList = datiImpresaList;
	}
	public List<DatiDelega> getDatiDelegaList() {
		if(datiDelegaList == null) {
			datiDelegaList = new ArrayList<>();
		}
		return datiDelegaList;
	}
	public void setDatiDelegaList(List<DatiDelega> datiDelegaList) {
		this.datiDelegaList = datiDelegaList;
	}
	public List<DatiIncarico> getDatiIncaricoList() {
		if(datiIncaricoList == null) {
			datiIncaricoList = new ArrayList<>();
		}
		return datiIncaricoList;
	}
	public void setDatiIncaricoList(List<DatiIncarico> datiIncaricoList) {
		this.datiIncaricoList = datiIncaricoList;
	}
}
