package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDFonteEnSfruttataDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitDFonteEnSfruttataDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDFonteEnSfruttataDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SigitDFonteEnSfruttataDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 *
	 * @generated
	 */
	SigitDFonteEnSfruttataDaoImpl dao;

	/**
	 * costruttore
	 *
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *                      incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDFonteEnSfruttataDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDFonteEnSfruttataDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDFonteEnSfruttataDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 *
	 * @param rs
	 * @param row
	 * @return SigitDFonteEnSfruttataDto
	 * @throws SQLException
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDFonteEnSfruttataDto) {
			return mapRow_internal((SigitDFonteEnSfruttataDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDFonteEnSfruttataDto mapRow_internal(SigitDFonteEnSfruttataDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitDFonteEnSfruttataDto dto = objectToFill;

		// colonna [ID_FONTE_EN_SFRUTTATA]
		if (mapAllColumns || columnsToReadMap.get("ID_FONTE_EN_SFRUTTATA") != null)
			dto.setIdFonteEnSfruttata(rs.getBigDecimal("ID_FONTE_EN_SFRUTTATA"));

		// colonna [DESC_FONTE_EN_SFRUTTATA]
		if (mapAllColumns || columnsToReadMap.get("DESC_FONTE_EN_SFRUTTATA") != null)
			dto.setDescFonteEnSfruttata(rs.getString("DESC_FONTE_EN_SFRUTTATA"));

		return dto;
	}

}
