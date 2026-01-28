package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDCategoriaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitDCategoriaDaoImpl;
import it.csi.sigit.sigitext.dto.sigitext.Categoria;

/**
 * RowMapper specifico del DAO SigitDCategoriaDao
 * @generated
 */
@SuppressWarnings("rawtypes")
public class SigitDCategoriaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDCategoriaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDCategoriaDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDCategoriaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDCategoriaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDCategoriaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof Categoria) {
			return mapRowInternal((Categoria) dtoInstance, rs);
		}

		return dtoInstance;
	}

	public Categoria mapRowInternal(Categoria objectToFill, ResultSet rs)
			throws SQLException {
		Categoria dto = objectToFill;

		// colonna [ID_ARIA_COMBURENTE]
		if (mapAllColumns || columnsToReadMap.get("ID_CATEGORIA") != null)
			dto.setIdCategoria(rs.getString("ID_CATEGORIA"));

		// colonna [DESC_ARIA_COMBURENTE]
		if (mapAllColumns || columnsToReadMap.get("DES_CATEGORIA") != null)
			dto.setDesCategoria(rs.getString("DES_CATEGORIA"));

		return dto;
	}

}
