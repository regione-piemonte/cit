package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

public interface SigitDStatoRappDao {
	
	String getDesStatoRappById(Integer idStatoRapp) throws SigitextException;

}
