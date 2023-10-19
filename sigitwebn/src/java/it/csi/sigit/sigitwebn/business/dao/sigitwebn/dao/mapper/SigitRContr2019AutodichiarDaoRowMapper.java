package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitRContr2019AutodichiarDao
 * @generated
 */
public class SigitRContr2019AutodichiarDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitRContr2019AutodichiarDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitRContr2019AutodichiarDaoRowMapper(String[] columnsToRead, Class dtoClass,
			SigitRContr2019AutodichiarDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitRContr2019AutodichiarDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRContr2019AutodichiarDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitRContr2019AutodichiarDto) {
			return mapRow_internal((SigitRContr2019AutodichiarDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof SigitRContr2019AutodichiarByExampleExtendedDto) {
			return mapRow_internal((SigitRContr2019AutodichiarByExampleExtendedDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitRContr2019AutodichiarDto mapRow_internal(SigitRContr2019AutodichiarDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		SigitRContr2019AutodichiarDto dto = objectToFill;

		// colonna [ID_CONTRATTO]
		if (mapAllColumns || columnsToReadMap.get("ID_CONTRATTO") != null)
			dto.setIdContratto((Integer) rs.getObject("ID_CONTRATTO"));

		// colonna [ID_AUTODICHIARAZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_AUTODICHIARAZIONE") != null)
			dto.setIdAutodichiarazione((Integer) rs.getObject("ID_AUTODICHIARAZIONE"));

		// colonna [FLG_NOMINA_CESSA]
		if (mapAllColumns || columnsToReadMap.get("FLG_NOMINA_CESSA") != null)
			dto.setFlgNominaCessa(rs.getString("FLG_NOMINA_CESSA"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitRContr2019AutodichiarByExampleExtendedDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRContr2019AutodichiarByExampleExtendedDto
	 * @generated
	 */

	public SigitRContr2019AutodichiarByExampleExtendedDto mapRow_internal(
			SigitRContr2019AutodichiarByExampleExtendedDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitRContr2019AutodichiarByExampleExtendedDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("DESAUTODICHIARAZIONE") != null)
			dto.setDesAutodichiarazione(rs.getString("desAutodichiarazione"));

		if (mapAllColumns || columnsToReadMap.get("IDAUTODICHIARAZIONE") != null)
			dto.setIdAutodichiarazione((Integer) rs.getObject("idAutodichiarazione"));

		return dto;
	}

}
