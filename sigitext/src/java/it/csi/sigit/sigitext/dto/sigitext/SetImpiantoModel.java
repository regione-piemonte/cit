/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.sigit.sigitext.dto.sigitext;

public class SetImpiantoModel {
	private UtenteLoggato utenteLoggato;
	private DatiImpianto datiImpianto;

	public SetImpiantoModel(UtenteLoggato utenteLoggato, DatiImpianto datiImpianto) {
		this.utenteLoggato = utenteLoggato;
		this.datiImpianto = datiImpianto;
	}

	public SetImpiantoModel() {
	}

	public UtenteLoggato getUtenteLoggato() {
		return utenteLoggato;
	}

	public void setUtenteLoggato(UtenteLoggato utenteLoggato) {
		this.utenteLoggato = utenteLoggato;
	}

	public DatiImpianto getDatiImpianto() {
		return datiImpianto;
	}

	public void setDatiImpianto(DatiImpianto datiImpianto) {
		this.datiImpianto = datiImpianto;
	}

	@Override
	public String toString() {
		return "SetImpiantoModel{" + "utenteLoggato=" + utenteLoggato + ", datiImpianto=" + datiImpianto + '}';
	}
}
