/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.util;

public class InputAllegatiComp {

	private Integer codiceImpianto;
	private Integer idAllegato;

	public Integer getCodiceImpianto() {
		return codiceImpianto;
	}

	public void setCodiceImpianto(Integer codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}

	public Integer getIdAllegato() {
		return idAllegato;
	}

	public void setIdAllegato(Integer idAllegato) {
		this.idAllegato = idAllegato;
	}

	@Override
	public String toString() {
		return "InputAllegatiComp [codiceImpianto=" + codiceImpianto + ", idAllegato=" + idAllegato + "]";
	}

}
