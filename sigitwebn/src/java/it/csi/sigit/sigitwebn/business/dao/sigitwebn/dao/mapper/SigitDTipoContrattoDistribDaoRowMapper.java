package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDTipoContrattoDistribDao
 * @generated
 */
public class SigitDTipoContrattoDistribDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDTipoContrattoDistribDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDTipoContrattoDistribDaoRowMapper(String[] columnsToRead, Class dtoClass,
			SigitDTipoContrattoDistribDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDTipoContrattoDistribDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDTipoContrattoDistribDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDTipoContrattoDistribDto) {
			return mapRow_internal((SigitDTipoContrattoDistribDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDTipoContrattoDistribDto mapRow_internal(SigitDTipoContrattoDistribDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		SigitDTipoContrattoDistribDto dto = objectToFill;

		// colonna [ID_TIPO_CONTRATTO_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_CONTRATTO_DISTRIB") != null)
			dto.setIdTipoContrattoDistrib((Integer) rs.getObject("ID_TIPO_CONTRATTO_DISTRIB"));

		// colonna [DES_TIPO_CONTRATTO_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("DES_TIPO_CONTRATTO_DISTRIB") != null)
			dto.setDesTipoContrattoDistrib(rs.getString("DES_TIPO_CONTRATTO_DISTRIB"));

		return dto;
	}

}
