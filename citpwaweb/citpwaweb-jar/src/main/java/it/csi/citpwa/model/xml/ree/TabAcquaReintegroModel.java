package it.csi.citpwa.model.xml.ree;

import java.util.ArrayList;
import java.util.List;

public class TabAcquaReintegroModel {

	protected List<RowAcquaReintegroModel> rowAcquaReintegro;

	public TabAcquaReintegroModel() {
	}

	public TabAcquaReintegroModel(List<RowAcquaReintegroModel> rowAcquaReintegro) {
		this.rowAcquaReintegro = rowAcquaReintegro;
	}

	public List<RowAcquaReintegroModel> getRowAcquaReintegro() {
		if (rowAcquaReintegro == null) {
			rowAcquaReintegro = new ArrayList<>();
		}
		return rowAcquaReintegro;
	}

	public void setRowAcquaReintegro(List<RowAcquaReintegroModel> rowAcquaReintegro) {
		this.rowAcquaReintegro = rowAcquaReintegro;
	}

	@Override
	public String toString() {
		return "TabAcquaReintegroModel{" + "rowAcquaReintegro=" + rowAcquaReintegro + '}';
	}
}
