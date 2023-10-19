package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDTipoManutenzioneDao
 * @generated
 */
public class SigitDTipoManutenzioneDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDTipoManutenzioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDTipoManutenzioneDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDTipoManutenzioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDTipoManutenzioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDTipoManutenzioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDTipoManutenzioneDto) {
			return mapRow_internal((SigitDTipoManutenzioneDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDTipoManutenzioneDto mapRow_internal(SigitDTipoManutenzioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDTipoManutenzioneDto dto = objectToFill;

		// colonna [ID_TIPO_MANUTENZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_MANUTENZIONE") != null)
			dto.setIdTipoManutenzione((Integer) rs.getObject("ID_TIPO_MANUTENZIONE"));

		// colonna [DES_TIPO_MANUTENZIONE]
		if (mapAllColumns || columnsToReadMap.get("DES_TIPO_MANUTENZIONE") != null)
			dto.setDesTipoManutenzione(rs.getString("DES_TIPO_MANUTENZIONE"));

		return dto;
	}

}
