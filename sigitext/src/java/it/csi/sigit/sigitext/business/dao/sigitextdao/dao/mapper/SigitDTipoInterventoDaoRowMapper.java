package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDTipoInterventoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitDTipoInterventoDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoInterventoDto;

public class SigitDTipoInterventoDaoRowMapper  extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	SigitDTipoInterventoDaoImpl dao;

	public SigitDTipoInterventoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDTipoInterventoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDTipoInterventoDaoImpl) dao;
	}

	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDTipoInterventoDto) {
			return mapRowInternal((SigitDTipoInterventoDto) dtoInstance, rs);
		}

		return dtoInstance;
	}

	public SigitDTipoInterventoDto mapRowInternal(SigitDTipoInterventoDto objectToFill, ResultSet rs) throws SQLException {
		SigitDTipoInterventoDto dto = objectToFill;

		// colonna [ID_DETTAGLIO_GT]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_INTERVENTO") != null)
			dto.setIdTipoIntervento(rs.getBigDecimal("ID_TIPO_INTERVENTO"));

		// colonna [DES_DETTAGLIO_GT]
		if (mapAllColumns || columnsToReadMap.get("DES_TIPO_INTERVENTO") != null)
			dto.setDesTipoIntervento(rs.getString("DES_TIPO_INTERVENTO"));

		return dto;
	}

}
