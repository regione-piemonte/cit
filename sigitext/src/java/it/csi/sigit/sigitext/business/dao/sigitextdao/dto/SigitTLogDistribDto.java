package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

public class SigitTLogDistribDto extends SigitTLogDistribPk {

	private static final long serialVersionUID = 1L;
	
	protected Integer fkImportDistrib;
	

	public void setFkImportDistrib(Integer val) {
		
		fkImportDistrib = val;
	
	}

	public Integer getFkImportDistrib() {
		
		return fkImportDistrib;
	
	}
	
	protected String msgErrore;
	
	public void setMsgErrore(String val) {
		
		msgErrore = val;
		
	}
	
	public String getMsgErrore() {
		
		return msgErrore;
		
	}

	public SigitTLogDistribPk createPk() {
		return new SigitTLogDistribPk(idLogDistrib);
	}

	public boolean equals(Object other) {
		return super.equals(other);
	}

	public int hashCode() {
		return super.hashCode();
	}

}
