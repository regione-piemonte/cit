package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDistribByIdPersonaGiuridicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDistribPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDistribRicevutaByIdImportDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTImportDistribDaoException;

import java.util.List;

public interface SigitTImportDistribDao {

	public SigitTImportDistribPk insert(SigitTImportDistribDto dto);

	public void updateColumnsAnnullaImport(SigitTImportDistribDto dto) throws SigitTImportDistribDaoException;

	public SigitTImportDistribDto findByPrimaryKey(SigitTImportDistribPk pk) throws SigitTImportDistribDaoException;

	public List<SigitTImportDistribByIdPersonaGiuridicaDto> findByIdPersonaGiuridica(java.lang.Integer input)
			throws SigitTImportDistribDaoException;

	public List<SigitTImportDistribRicevutaByIdImportDistribDto> findRicevutaByIdImportDistrib(java.lang.Integer input)
			throws SigitTImportDistribDaoException;

}