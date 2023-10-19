package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitWrkLogPrecDao
 * @generated
 */
public class SigitWrkLogPrecDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitWrkLogPrecDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitWrkLogPrecDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitWrkLogPrecDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitWrkLogPrecDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitWrkLogPrecDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitWrkLogPrecDto) {
			return mapRow_internal((SigitWrkLogPrecDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitWrkLogPrecDto mapRow_internal(SigitWrkLogPrecDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitWrkLogPrecDto dto = objectToFill;

		// colonna [CODICE_FISCALE]
		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setCodiceFiscale(rs.getString("CODICE_FISCALE"));

		// colonna [DATA_OPERAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DATA_OPERAZIONE") != null)
			dto.setDataOperazione(rs.getTimestamp("DATA_OPERAZIONE"));

		// colonna [TBL_IMPATTATA]
		if (mapAllColumns || columnsToReadMap.get("TBL_IMPATTATA") != null)
			dto.setTblImpattata(rs.getString("TBL_IMPATTATA"));

		// colonna [ID_RECORD]
		if (mapAllColumns || columnsToReadMap.get("ID_RECORD") != null)
			dto.setIdRecord(rs.getString("ID_RECORD"));

		// colonna [TIPO_OPERAZIONE]
		if (mapAllColumns || columnsToReadMap.get("TIPO_OPERAZIONE") != null)
			dto.setTipoOperazione(rs.getString("TIPO_OPERAZIONE"));

		// colonna [ID_LOG]
		if (mapAllColumns || columnsToReadMap.get("ID_LOG") != null)
			dto.setIdLog((Integer) rs.getObject("ID_LOG"));

		return dto;
	}

}
