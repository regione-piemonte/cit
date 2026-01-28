package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitExtDaoException;

public interface SigitDStatoPgDao {
	
	String getDesStatoById(Integer idStato) throws SigitExtDaoException;

}
