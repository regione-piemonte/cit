package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

public class SigitDDettaglioGtPk implements Serializable {

	private static final long serialVersionUID = 1L;

	protected java.math.BigDecimal idDettaglioGt;

	public void setIdDettaglioGt(java.math.BigDecimal val) {

		idDettaglioGt = val;

	}

	public java.math.BigDecimal getIdDettaglioGt() {

		return idDettaglioGt;

	}

	public SigitDDettaglioGtPk() {
		//empty constructor
	}

	public SigitDDettaglioGtPk(

			final java.math.BigDecimal idDettaglioGt

	) {

		this.setIdDettaglioGt(idDettaglioGt);

	}

	public boolean equals(Object _other) {
		if (_other == null) {
			return false;
		}

		if (_other == this) {
			return true;
		}

		if (!(_other instanceof SigitDDettaglioGtPk)) {
			return false;
		}

		final SigitDDettaglioGtPk _cast = (SigitDDettaglioGtPk) _other;

		if (idDettaglioGt == null ? _cast.getIdDettaglioGt() != null : !idDettaglioGt.equals(_cast.getIdDettaglioGt())) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		int _hashCode = 0;

		if (idDettaglioGt != null) {
			_hashCode = 29 * _hashCode + idDettaglioGt.hashCode();
		}

		return _hashCode;
	}

	public String toString() {
		StringBuilder ret = new StringBuilder();

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDDettaglioGtPk: ");
		ret.append("idDettaglioGt=" + idDettaglioGt);

		return ret.toString();
	}
}
