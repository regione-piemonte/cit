package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDStatoAccertamentoDao
 * @generated
 */
public class SigitDStatoAccertamentoDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDStatoAccertamentoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDStatoAccertamentoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDStatoAccertamentoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDStatoAccertamentoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDStatoAccertamentoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDStatoAccertamentoDto) {
			return mapRow_internal((SigitDStatoAccertamentoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDStatoAccertamentoDto mapRow_internal(SigitDStatoAccertamentoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDStatoAccertamentoDto dto = objectToFill;

		// colonna [ID_STATO_ACCERTAMENTO]
		if (mapAllColumns || columnsToReadMap.get("ID_STATO_ACCERTAMENTO") != null)
			dto.setIdStatoAccertamento((Integer) rs.getObject("ID_STATO_ACCERTAMENTO"));

		// colonna [DES_STATO_ACCERTAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DES_STATO_ACCERTAMENTO") != null)
			dto.setDesStatoAccertamento(rs.getString("DES_STATO_ACCERTAMENTO"));

		return dto;
	}

}
