package it.csi.citpwa.model.sigitext;

import java.util.List;

public class UpdateScModel {
	private List<DatiSC> datiSCList;
	private String codiceImpianto;
	private UtenteLoggato utenteLoggato;

	public UpdateScModel() {
	}

	public UpdateScModel(List<DatiSC> datiSCList, String codiceImpianto, UtenteLoggato utenteLoggato) {
		this.datiSCList = datiSCList;
		this.codiceImpianto = codiceImpianto;
		this.utenteLoggato = utenteLoggato;
	}

	public List<DatiSC> getDatiSCList() {
		return datiSCList;
	}

	public void setDatiSCList(List<DatiSC> datiSCList) {
		this.datiSCList = datiSCList;
	}

	public String getCodiceImpianto() {
		return codiceImpianto;
	}

	public void setCodiceImpianto(String codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}

	public UtenteLoggato getUtenteLoggato() {
		return utenteLoggato;
	}

	public void setUtenteLoggato(UtenteLoggato utenteLoggato) {
		this.utenteLoggato = utenteLoggato;
	}

	@Override
	public String toString() {
		return "UpdateScModel{" + "datiSCList=" + datiSCList + ", codiceImpianto='" + codiceImpianto + '\'' + ", utenteLoggato=" + utenteLoggato + '}';
	}
}
