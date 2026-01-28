package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

public class SigitTLogDistribPk implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Integer idLogDistrib;

	public void setIdLogDistrib(Integer val) {

		idLogDistrib = val;

	}

	public Integer getIdLogDistrib() {

		return idLogDistrib;

	}
	
	public SigitTLogDistribPk() {
		//empty constructor
	}

	public SigitTLogDistribPk(

			final Integer idLogDistrib

	) {

		this.setIdLogDistrib(idLogDistrib);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();

		ret.append("it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLogDistribPk: ");
		ret.append("idLogDistrib = " + idLogDistrib);

		return ret.toString();
	}
}
