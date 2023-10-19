package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDTipoCessazioneDao
 * @generated
 */
public class SigitDTipoCessazioneDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDTipoCessazioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDTipoCessazioneDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDTipoCessazioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDTipoCessazioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDTipoCessazioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDTipoCessazioneDto) {
			return mapRow_internal((SigitDTipoCessazioneDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDTipoCessazioneDto mapRow_internal(SigitDTipoCessazioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDTipoCessazioneDto dto = objectToFill;

		// colonna [ID_TIPO_CESSAZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_CESSAZIONE") != null)
			dto.setIdTipoCessazione((Integer) rs.getObject("ID_TIPO_CESSAZIONE"));

		// colonna [DES_TIPO_CESSAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DES_TIPO_CESSAZIONE") != null)
			dto.setDesTipoCessazione(rs.getString("DES_TIPO_CESSAZIONE"));

		return dto;
	}

}
