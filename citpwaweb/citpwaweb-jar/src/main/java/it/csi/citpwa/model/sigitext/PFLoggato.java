/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model.sigitext;

public class PFLoggato {
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
