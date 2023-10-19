/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model.xml.ree;

import java.util.ArrayList;
import java.util.List;

public class AllegatoModel {
	protected List<RowAllegatoModel> rowAllegato;

	public AllegatoModel() {
	}

	public AllegatoModel(List<RowAllegatoModel> rowAllegatoII) {
		this.rowAllegato = rowAllegatoII;
	}

	public List<RowAllegatoModel> getRowAllegato() {
		if (rowAllegato == null) {
			rowAllegato = new ArrayList<RowAllegatoModel>();
		}
		return this.rowAllegato;
	}

	public void setRowAllegatoII(List<RowAllegatoModel> rowAllegatoII) {
		this.rowAllegato = rowAllegatoII;
	}

	@Override
	public String toString() {
		return "Allegato{" + "rowAllegato=" + rowAllegato + '}';
	}
}
