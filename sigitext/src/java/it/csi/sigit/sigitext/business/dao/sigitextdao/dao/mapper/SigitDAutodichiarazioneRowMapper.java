package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDAutodichiarazioneDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitDAutodichiarazioneDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDAutodichiarazioneDto;

public class SigitDAutodichiarazioneRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {
	
	SigitDAutodichiarazioneDaoImpl dao;
	
	public SigitDAutodichiarazioneRowMapper(String[] columnsToRead, Class dtoClass, SigitDAutodichiarazioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDAutodichiarazioneDaoImpl) dao;
	}

	@Override
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDAutodichiarazioneDto) {
			return mapRowInternal((SigitDAutodichiarazioneDto) dtoInstance, rs);
		}

		return dtoInstance;
	}

	private SigitDAutodichiarazioneDto mapRowInternal(SigitDAutodichiarazioneDto objectToFill, ResultSet rs) throws SQLException {
		SigitDAutodichiarazioneDto dto = objectToFill;

		// colonna [ID_TIPO_DOC_AGG]
		if (mapAllColumns || columnsToReadMap.get("id_autodichiarazione") != null)
			dto.setId_autodichiarazione(rs.getInt("id_autodichiarazione"));

		// colonna [DESC_TIPO_DOC_AGG]
		if (mapAllColumns || columnsToReadMap.get("des_autodichiarazione") != null)
			dto.setDes_autodichiarazione(rs.getString("des_autodichiarazione"));

		return dto;
	}

}
