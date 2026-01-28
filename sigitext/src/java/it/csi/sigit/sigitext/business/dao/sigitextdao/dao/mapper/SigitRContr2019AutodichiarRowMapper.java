package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitRContr2019AutodichiarDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitRContr2019AutodichiarDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRContr2019AutodichiarDto;

public class SigitRContr2019AutodichiarRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {
	
	SigitRContr2019AutodichiarDaoImpl dao;
	
	public SigitRContr2019AutodichiarRowMapper(String[] columnsToRead, Class dtoClass, SigitRContr2019AutodichiarDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitRContr2019AutodichiarDaoImpl) dao;
	}

	@Override
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitRContr2019AutodichiarDto) {
			return mapRowInternal((SigitRContr2019AutodichiarDto) dtoInstance, rs);
		}

		return dtoInstance;
	}

	private SigitRContr2019AutodichiarDto mapRowInternal(SigitRContr2019AutodichiarDto objectToFill, ResultSet rs) throws SQLException {
		SigitRContr2019AutodichiarDto dto = objectToFill;

		// colonna [ID_TIPO_DOC_AGG]
		if (mapAllColumns || columnsToReadMap.get("id_autodichiarazione") != null)
			dto.setId_autodichiarazione(rs.getInt("id_autodichiarazione"));
		
		if (mapAllColumns || columnsToReadMap.get("id_contratto") != null)
			dto.setId_contratto(rs.getInt("id_contratto"));

		// colonna [DESC_TIPO_DOC_AGG]
		if (mapAllColumns || columnsToReadMap.get("flg_nomina_cessa") != null)
			dto.setFlg_nomina_cessa(rs.getString("flg_nomina_cessa"));

		return dto;
	}

}
