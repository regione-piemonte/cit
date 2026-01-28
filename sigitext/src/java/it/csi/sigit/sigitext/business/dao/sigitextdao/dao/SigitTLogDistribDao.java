package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.ConsumoPodPdrFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDatoDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDatoDistribPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLogDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLogDistribPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDatoDistribDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTLogDistribDaoException;
import it.csi.sigit.sigitext.dto.sigitext.ConsumoPodPdr;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

public interface SigitTLogDistribDao {

	public List<SigitTLogDistribDto> findByPrimaryKey(SigitTLogDistribPk sigitTLogDistribPk) throws SigitTLogDistribDaoException;

	public List<SigitTLogDistribDto> findByFkImportDistrib(Integer fkImportDistrib) throws SigitTLogDistribDaoException;

}
