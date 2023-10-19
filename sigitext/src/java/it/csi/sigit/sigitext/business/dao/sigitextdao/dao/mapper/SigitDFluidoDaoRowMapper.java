package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDFluidoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitDFluidoDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDFluidoDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SigitDFluidoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	SigitDFluidoDaoImpl dao;

	public SigitDFluidoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDFluidoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDFluidoDaoImpl) dao;
	}

	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();
		if (dtoInstance instanceof SigitDFluidoDto) {
			return mapRow_internal((SigitDFluidoDto) dtoInstance, rs, row);
		}
		return dtoInstance;
	}

	public SigitDFluidoDto mapRow_internal(SigitDFluidoDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitDFluidoDto dto = objectToFill;
		// colonna [ID_FLUIDO]
		if (mapAllColumns || columnsToReadMap.get("ID_FLUIDO") != null)
			dto.setIdFluido(rs.getBigDecimal("ID_FLUIDO"));
		// colonna [DES_FLUIDO]
		if (mapAllColumns || columnsToReadMap.get("DES_FLUIDO") != null)
			dto.setDesFluido(rs.getString("DES_FLUIDO"));
		return dto;
	}

}
