package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

/**
 * Data transfer object relativo al DAO SigitDDettaglioGtDao.
 *
 * @generated
 */
public class SigitDDettaglioGtDto extends SigitDDettaglioGtPk {

	private static final long serialVersionUID = 1L;

	protected String desDettaglioGt;

	public void setDesDettaglioGt(String val) {

		desDettaglioGt = val;

	}

	public String getDesDettaglioGt() {

		return desDettaglioGt;

	}

	public SigitDDettaglioGtPk createPk() {
		return new SigitDDettaglioGtPk(idDettaglioGt);
	}

	public boolean equals(Object other) {
		return super.equals(other);
	}

	public int hashCode() {
		return super.hashCode();
	}

}
