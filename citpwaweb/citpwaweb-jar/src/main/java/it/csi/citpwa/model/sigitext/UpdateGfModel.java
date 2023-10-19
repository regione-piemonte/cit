package it.csi.citpwa.model.sigitext;

import java.util.List;

public class UpdateGfModel {
	private List<DatiGF> datiGFList;
	private String codiceImpianto;
	private UtenteLoggato utenteLoggato;

	public UpdateGfModel(List<DatiGF> datiGFList, String codiceImpianto, UtenteLoggato utenteLoggato) {
		this.datiGFList = datiGFList;
		this.codiceImpianto = codiceImpianto;
		this.utenteLoggato = utenteLoggato;
	}

	public UpdateGfModel() {
	}

	public List<DatiGF> getDatiGFList() {
		return datiGFList;
	}

	public void setDatiGFList(List<DatiGF> datiGFList) {
		this.datiGFList = datiGFList;
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
		return "UpdateGfModel{" + "datiGFList=" + datiGFList + ", codiceImpianto='" + codiceImpianto + '\'' + ", utenteLoggato=" + utenteLoggato + '}';
	}
}
