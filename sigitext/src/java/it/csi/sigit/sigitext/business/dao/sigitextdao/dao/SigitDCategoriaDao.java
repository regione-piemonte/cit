package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitext.dto.sigitext.Categoria;

public interface SigitDCategoriaDao {

	List<Categoria> getCategorie() throws SigitExtDaoException;
	
}
