package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTDatoDistribDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTLogDistribDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTDatoDistribDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTLogDistribDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDatoDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLogDistribDto;

public class SigitTLogDistribDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	SigitTLogDistribDaoImpl dao;

	public SigitTLogDistribDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTLogDistribDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTLogDistribDaoImpl) dao;
	}

	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTLogDistribDto) {
			return mapRow_internal((SigitTLogDistribDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTLogDistribDto mapRow_internal(SigitTLogDistribDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTLogDistribDto dto = objectToFill;

		// colonna [ID_LOG_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("ID_LOG_DISTRIB") != null)
			dto.setIdLogDistrib(rs.getInt("ID_LOG_DISTRIB"));

		// colonna [FK_IMPORT_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("FK_IMPORT_DISTRIB") != null)
			dto.setFkImportDistrib((Integer) rs.getObject("FK_IMPORT_DISTRIB"));

		// colonna [MSG_ERRORE]
		if (mapAllColumns || columnsToReadMap.get("MSG_ERRORE") != null)
			dto.setMsgErrore((String) rs.getObject("MSG_ERRORE"));

		return dto;
	}

}
