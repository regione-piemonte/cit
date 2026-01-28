package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResponseGetElencoDocumenti implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<DocumentiAssociatiContratto> documentiAssociatiContratto; 
	private List<DocumentiAggiuntiviImpianto> documentiAggiuntiviImpianto; 
	private List<DocumentiAzioni> documentiAzioni; 
	private List<DocumentiAllegatiImpianto> documentiAllegatiImpianto;
	
	public List<DocumentiAssociatiContratto> getDocumentiAssociatiContratto() {
		if(documentiAssociatiContratto == null) {
			documentiAssociatiContratto = new ArrayList<>();
		}
		return documentiAssociatiContratto;
	}
	public void setDocumentiAssociatiContratto(List<DocumentiAssociatiContratto> documentiAssociatiContratto) {
		this.documentiAssociatiContratto = documentiAssociatiContratto;
	}
	public List<DocumentiAggiuntiviImpianto> getDocumentiAggiuntiviImpianto() {
		if(documentiAggiuntiviImpianto == null) {
			documentiAggiuntiviImpianto = new ArrayList<>();
		}
		return documentiAggiuntiviImpianto;
	}
	public void setDocumentiAggiuntiviImpianto(List<DocumentiAggiuntiviImpianto> documentiAggiuntiviImpianto) {
		this.documentiAggiuntiviImpianto = documentiAggiuntiviImpianto;
	}
	public List<DocumentiAzioni> getDocumentiAzioni() {
		if(documentiAzioni == null) {
			documentiAzioni = new ArrayList<>();
		}
		return documentiAzioni;
	}
	public void setDocumentiAzioni(List<DocumentiAzioni> documentiAzioni) {
		this.documentiAzioni = documentiAzioni;
	}
	public List<DocumentiAllegatiImpianto> getDocumentiAllegatiImpianto() {
		if(documentiAllegatiImpianto == null) {
			documentiAllegatiImpianto = new ArrayList<>();
		}
		return documentiAllegatiImpianto;
	}
	public void setDocumentiAllegatiImpianto(List<DocumentiAllegatiImpianto> documentiReeImpianto) {
		this.documentiAllegatiImpianto = documentiReeImpianto;
	} 
	
}
