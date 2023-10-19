package it.csi.sigit.elencom.business.dao.elencom.dao.mapper;

import it.csi.sigit.elencom.business.dao.elencom.dto.*;
import it.csi.sigit.elencom.business.dao.elencom.dao.*;
import it.csi.sigit.elencom.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.elencom.business.dao.elencom.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTFormazioneDao
 * @generated
 */
public class SigitTFormazioneDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTFormazioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTFormazioneDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTFormazioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTFormazioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTFormazioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTFormazioneDto) {
			return mapRow_internal((SigitTFormazioneDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTFormazioneDto mapRow_internal(SigitTFormazioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTFormazioneDto dto = objectToFill;

		// colonna [DATA_CORSO]
		if (mapAllColumns || columnsToReadMap.get("DATA_CORSO") != null)
			dto.setDataCorso(rs.getDate("DATA_CORSO"));

		// colonna [ID_PERSONA_FISICA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_FISICA") != null)
			dto.setIdPersonaFisica(rs.getBigDecimal("ID_PERSONA_FISICA"));

		// colonna [DES_CORSO]
		if (mapAllColumns || columnsToReadMap.get("DES_CORSO") != null)
			dto.setDesCorso(rs.getString("DES_CORSO"));

		return dto;
	}

}
