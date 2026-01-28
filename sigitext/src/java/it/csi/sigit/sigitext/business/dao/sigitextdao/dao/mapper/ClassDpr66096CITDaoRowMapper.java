package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.ClassDpr66096CITDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.CombustibileCITDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.ClassDpr66096CITDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.CombustibileCITDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.ClassDpr66096CITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.CombustibileCITDto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO CombustibileCITDao
 * @generated
 */
public class ClassDpr66096CITDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	ClassDpr66096CITDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public ClassDpr66096CITDaoRowMapper(String[] columnsToRead, Class dtoClass, ClassDpr66096CITDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (ClassDpr66096CITDaoImpl) dao;
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

		if (dtoInstance instanceof ClassDpr66096CITDto) {
			return mapRow_internal((ClassDpr66096CITDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public ClassDpr66096CITDto mapRow_internal(ClassDpr66096CITDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		ClassDpr66096CITDto dto = objectToFill;

		// colonna [ID_COMBUSTIBILE]
		if (mapAllColumns || columnsToReadMap.get("ID_CLASS") != null)
			dto.setIdClass(rs.getBigDecimal("ID_CLASS"));

		// colonna [DES_COMBUSTIBILE]
		if (mapAllColumns || columnsToReadMap.get("DES_CLASS") != null)
			dto.setDesClass(rs.getString("DES_CLASS"));

		return dto;
	}

}
