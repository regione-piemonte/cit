package it.csi.sigit.sigitwebn.presentation.uiutils;

import java.util.List;

/**
 * @generated
 */
public class TableArrangedData {

	//***numero totale dei record nella tabella
	private int numtot;
	//***elenco dei record della tabella
	private List<Object> elenco;
	//***elenco delle posizioni occupate dai record nella collection originale
	private List<DataPosition> positions;
	//***parametro che indica se deve essere resettato lo stato della tabella
	private boolean clearStatus;

	/**
	 * numTot
	 */
	public int getNumtot() {
		return numtot;
	}

	/**
	 * numTot
	 */
	public void setNumtot(int numtot) {
		this.numtot = numtot;
	}

	/**
	 * elenco
	 */
	public List<Object> getElenco() {
		return elenco;
	}

	/**
	 * elenco
	 */
	public void setElenco(List<Object> elenco) {
		this.elenco = elenco;
	}

	/**
	 * positions
	 */
	public List<DataPosition> getPositions() {
		return positions;
	}

	/**
	 * positions
	 */
	public void setPositions(List<DataPosition> positions) {
		this.positions = positions;
	}

	/**
	 * isClearStatus
	 */
	public boolean isClearStatus() {
		return clearStatus;
	}

	/**
	 * setclearStatus
	 */
	public void setClearStatus(boolean clearStatus) {
		this.clearStatus = clearStatus;
	}
}
