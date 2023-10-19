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

public class TabFumiModel {
	protected List<RowFumiModel> rowFumi;

	public TabFumiModel() {
	}

	public TabFumiModel(List<RowFumiModel> rowFumi) {
		this.rowFumi = rowFumi;
	}

	public List<RowFumiModel> getRowFumi() {
		if (rowFumi == null) {
			rowFumi = new ArrayList<RowFumiModel>();
		}
		return this.rowFumi;
	}

	public void setRowFumi(List<RowFumiModel> rowFumi) {
		this.rowFumi = rowFumi;
	}

	@Override
	public String toString() {
		return "TabFumi{" + "rowFumiModel=" + rowFumi + '}';
	}

}
