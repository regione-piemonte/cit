package it.csi.citpwa.model.sigitext;

import java.util.List;

public class UpdateGtModel {
	private List<DatiGT> datiGTList;
	private String codiceImpianto;
	private UtenteLoggato utenteLoggato;

	public UpdateGtModel(List<DatiGT> datiGTList, String codiceImpianto, UtenteLoggato utenteLoggato) {
		this.datiGTList = datiGTList;
		this.codiceImpianto = codiceImpianto;
		this.utenteLoggato = utenteLoggato;
	}

	public UpdateGtModel() {
	}

	public List<DatiGT> getDatiGTList() {
		return datiGTList;
	}

	public void setDatiGTList(List<DatiGT> datiGTList) {
		this.datiGTList = datiGTList;
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
		return "UpdateGtModel{" + "datiGTList=" + datiGTList + ", codiceImpianto='" + codiceImpianto + '\'' + ", utenteLoggato=" + utenteLoggato + '}';
	}
}
