package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDDettaglioGtDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitDDettaglioGtDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDDettaglioGtDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SigitDDettaglioGtDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	SigitDDettaglioGtDaoImpl dao;

	public SigitDDettaglioGtDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDDettaglioGtDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDDettaglioGtDaoImpl) dao;
	}

	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDDettaglioGtDto) {
			return mapRow_internal((SigitDDettaglioGtDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDDettaglioGtDto mapRow_internal(SigitDDettaglioGtDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitDDettaglioGtDto dto = objectToFill;

		// colonna [ID_DETTAGLIO_GT]
		if (mapAllColumns || columnsToReadMap.get("ID_DETTAGLIO_GT") != null)
			dto.setIdDettaglioGt(rs.getBigDecimal("ID_DETTAGLIO_GT"));

		// colonna [DES_DETTAGLIO_GT]
		if (mapAllColumns || columnsToReadMap.get("DES_DETTAGLIO_GT") != null)
			dto.setDesDettaglioGt(rs.getString("DES_DETTAGLIO_GT"));

		return dto;
	}

}
