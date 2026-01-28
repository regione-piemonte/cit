package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.CombustibileCITDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.FrequenzaManutCITDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.CombustibileCITDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.FrequenzaManutCITDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.CombustibileCITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.FrequenzaManutCITDto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO CombustibileCITDao
 * @generated
 */
public class FrequenzaManutCITDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	FrequenzaManutCITDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public FrequenzaManutCITDaoRowMapper(String[] columnsToRead, Class dtoClass, FrequenzaManutCITDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (FrequenzaManutCITDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return CombustibileCITDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof FrequenzaManutCITDto) {
			return mapRow_internal((FrequenzaManutCITDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public FrequenzaManutCITDto mapRow_internal(FrequenzaManutCITDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		FrequenzaManutCITDto dto = objectToFill;

		// colonna [ID_COMBUSTIBILE]
		if (mapAllColumns || columnsToReadMap.get("ID_FREQUENZA") != null)
			dto.setIdFrequenza(rs.getBigDecimal("ID_FREQUENZA"));

		// colonna [DES_COMBUSTIBILE]
		if (mapAllColumns || columnsToReadMap.get("DES_FREQUENZA") != null)
			dto.setDesFrequenza(rs.getString("DES_FREQUENZA"));

		return dto;
	}

}
