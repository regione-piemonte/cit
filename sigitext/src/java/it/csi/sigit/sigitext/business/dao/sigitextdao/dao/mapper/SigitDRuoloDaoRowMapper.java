package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDRuoloDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitDRuoloDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDRuoloDto;

public class SigitDRuoloDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper{
	
	
	SigitDRuoloDaoImpl dao;
	
	public SigitDRuoloDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDRuoloDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDRuoloDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDCategoriaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDRuoloDto) {
			return mapRowInternal((SigitDRuoloDto) dtoInstance, rs);
		}

		return dtoInstance;
	}

	public SigitDRuoloDto mapRowInternal(SigitDRuoloDto objectToFill, ResultSet rs) throws SQLException {
		SigitDRuoloDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_RUOLO") != null)
			dto.setIdRuolo(rs.getInt("ID_RUOLO"));

		if (mapAllColumns || columnsToReadMap.get("DES_RUOLO") != null)
			dto.setDesRuolo(rs.getString("DES_RUOLO"));
		
		if (mapAllColumns || columnsToReadMap.get("RUOLO_FUNZ") != null)
			dto.setRuoloFunz(rs.getString("RUOLO_FUNZ"));

		return dto;
	}

}
