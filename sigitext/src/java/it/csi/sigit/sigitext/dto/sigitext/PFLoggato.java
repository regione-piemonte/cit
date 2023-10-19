
package it.csi.sigit.sigitext.dto.sigitext;

public class PFLoggato implements java.io.Serializable {

	static final long serialVersionUID = 1;

	private String codiceFiscalePF = null;
	private String cognomePF = null;
	private String nomePF = null;

	public void setCodiceFiscalePF(String val) {
		codiceFiscalePF = val;
	}
	public String getCodiceFiscalePF() {
		return codiceFiscalePF;
	}
	public void setCognomePF(String val) {
		cognomePF = val;
	}
	public String getCognomePF() {
		return cognomePF;
	}
	public void setNomePF(String val) {
		nomePF = val;
	}
	public String getNomePF() {
		return nomePF;
	}
}
