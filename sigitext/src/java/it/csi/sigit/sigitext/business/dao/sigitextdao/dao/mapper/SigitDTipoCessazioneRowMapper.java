package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDTipoCessazioneDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitDTipoCessazioneDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoCessazioneDto;

public class SigitDTipoCessazioneRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {
	
	SigitDTipoCessazioneDaoImpl dao;
	
	public SigitDTipoCessazioneRowMapper(String[] columnsToRead, Class dtoClass, SigitDTipoCessazioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDTipoCessazioneDaoImpl) dao;
	}

	@Override
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDTipoCessazioneDto) {
			return mapRowInternal((SigitDTipoCessazioneDto) dtoInstance, rs);
		}

		return dtoInstance;
	}

	private SigitDTipoCessazioneDto mapRowInternal(SigitDTipoCessazioneDto objectToFill, ResultSet rs) throws SQLException {
		SigitDTipoCessazioneDto dto = objectToFill;

		// colonna [ID_TIPO_DOC_AGG]
		if (mapAllColumns || columnsToReadMap.get("id_tipo_cessazione") != null)
			dto.setId_tipo_cessazione(rs.getInt("id_tipo_cessazione"));

		// colonna [DESC_TIPO_DOC_AGG]
		if (mapAllColumns || columnsToReadMap.get("des_tipo_cessazione") != null)
			dto.setDes_tipo_cessazione(rs.getString("des_tipo_cessazione"));

		return dto;
	}

}
