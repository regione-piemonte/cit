package it.csi.sigit.sigitext.dto.sigitext;

import java.util.List;

public class UpdateCgModel {
	private List<DatiCG> datiCGList;
	private String codiceImpianto;
	private UtenteLoggato utenteLoggato;

	public UpdateCgModel() {
	}

	public UpdateCgModel(List<DatiCG> datiCGList, String codiceImpianto, UtenteLoggato utenteLoggato) {
		this.datiCGList = datiCGList;
		this.codiceImpianto = codiceImpianto;
		this.utenteLoggato = utenteLoggato;
	}

	public List<DatiCG> getDatiCGList() {
		return datiCGList;
	}

	public void setDatiCGList(List<DatiCG> datiCGList) {
		this.datiCGList = datiCGList;
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
		return "UpdateCgModel{" + "datiCGList=" + datiCGList + ", codiceImpianto='" + codiceImpianto + '\'' + ", utenteLoggato=" + utenteLoggato + '}';
	}
}
