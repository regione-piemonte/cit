package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDTipoAzioneDao
 * @generated
 */
public class SigitDTipoAzioneDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDTipoAzioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDTipoAzioneDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDTipoAzioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDTipoAzioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDTipoAzioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDTipoAzioneDto) {
			return mapRow_internal((SigitDTipoAzioneDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDTipoAzioneDto mapRow_internal(SigitDTipoAzioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDTipoAzioneDto dto = objectToFill;

		// colonna [ID_TIPO_AZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_AZIONE") != null)
			dto.setIdTipoAzione((Integer) rs.getObject("ID_TIPO_AZIONE"));

		// colonna [DES_TIPO_AZIONE]
		if (mapAllColumns || columnsToReadMap.get("DES_TIPO_AZIONE") != null)
			dto.setDesTipoAzione(rs.getString("DES_TIPO_AZIONE"));

		return dto;
	}

}
