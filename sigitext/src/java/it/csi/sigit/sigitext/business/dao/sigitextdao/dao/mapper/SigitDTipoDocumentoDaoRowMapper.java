package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDTipoDocumentoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitDTipoDocumentoDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoDocDto;

public class SigitDTipoDocumentoDaoRowMapper extends BaseDaoRowMapper
implements
org.springframework.jdbc.core.RowMapper{

	SigitDTipoDocumentoDaoImpl dao;
	
	public SigitDTipoDocumentoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDTipoDocumentoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDTipoDocumentoDaoImpl) dao;
	}

	@Override
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDTipoDocDto) {
			return mapRowInternal((SigitDTipoDocDto) dtoInstance, rs);
		}

		return dtoInstance;
	}

	private SigitDTipoDocDto mapRowInternal(SigitDTipoDocDto objectToFill, ResultSet rs) throws SQLException {
		SigitDTipoDocDto dto = objectToFill;

		// colonna [ID_TIPO_DOC_AGG]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_DOC_AGG") != null)
			dto.setIdTipoDoc(rs.getBigDecimal("ID_TIPO_DOC_AGG"));

		// colonna [DESC_TIPO_DOC_AGG]
		if (mapAllColumns || columnsToReadMap.get("des_tipo_doc_agg") != null)
			dto.setDescription(rs.getString("des_tipo_doc_agg"));

		return dto;
	}

}
