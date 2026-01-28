package it.csi.citpwa.model.sigitext;

import java.io.Serializable;

public class Autodichiarazione implements Serializable {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idContratto;
	private Integer idAutodichiarazione;
	private String desAutodichiarazione;
	private String flgNominaCessa;
	
	
	public Integer getIdContratto() {
		return idContratto;
	}
	public void setIdContratto(Integer idContratto) {
		this.idContratto = idContratto;
	}
	public Integer getIdAutodichiarazione() {
		return idAutodichiarazione;
	}
	public void setIdAutodichiarazione(Integer idAutodichiarazione) {
		this.idAutodichiarazione = idAutodichiarazione;
	}
	public String getFlgNominaCessa() {
		return flgNominaCessa;
	}
	public void setFlgNominaCessa(String flgNominaCessa) {
		this.flgNominaCessa = flgNominaCessa;
	}
	public String getDesAutodichiarazione() {
		return desAutodichiarazione;
	}
	public void setDesAutodichiarazione(String desAutodichiarazione) {
		this.desAutodichiarazione = desAutodichiarazione;
	}
	
	
	
}
