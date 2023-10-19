package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTLogDistribDao
 * @generated
 */
public class SigitTLogDistribDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTLogDistribDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTLogDistribDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTLogDistribDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTLogDistribDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTLogDistribDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTLogDistribDto) {
			return mapRow_internal((SigitTLogDistribDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTLogDistribDto mapRow_internal(SigitTLogDistribDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTLogDistribDto dto = objectToFill;

		// colonna [ID_LOG_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("ID_LOG_DISTRIB") != null)
			dto.setIdLogDistrib((Integer) rs.getObject("ID_LOG_DISTRIB"));

		// colonna [FK_IMPORT_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("FK_IMPORT_DISTRIB") != null)
			dto.setFkImportDistrib((Integer) rs.getObject("FK_IMPORT_DISTRIB"));

		// colonna [MSG_ERRORE]
		if (mapAllColumns || columnsToReadMap.get("MSG_ERRORE") != null)
			dto.setMsgErrore(rs.getString("MSG_ERRORE"));

		return dto;
	}

}
