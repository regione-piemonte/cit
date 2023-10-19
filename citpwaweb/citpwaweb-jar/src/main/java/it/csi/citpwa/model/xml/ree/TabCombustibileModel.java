package it.csi.citpwa.model.xml.ree;

import java.util.ArrayList;
import java.util.List;

public class TabCombustibileModel {

	protected List<RowCombustibileModel> rowCombustibile;

	public TabCombustibileModel() {
	}

	public TabCombustibileModel(List<RowCombustibileModel> rowCombustibile) {
		this.rowCombustibile = rowCombustibile;
	}

	public List<RowCombustibileModel> getRowCombustibile() {
		if (this.rowCombustibile == null) {
			this.rowCombustibile = new ArrayList<>();
		}
		return this.rowCombustibile;
	}

	public void setRowCombustibile(List<RowCombustibileModel> rowCombustibile) {
		this.rowCombustibile = rowCombustibile;
	}

	@Override
	public String toString() {
		return "TabCombustibileModel{" + "rowCombustibile=" + rowCombustibile + '}';
	}
}
