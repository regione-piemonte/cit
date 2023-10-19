package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTAzioneContrattoDao
 * @generated
 */
public class SigitTAzioneContrattoDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTAzioneContrattoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTAzioneContrattoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTAzioneContrattoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTAzioneContrattoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTAzioneContrattoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTAzioneContrattoDto) {
			return mapRow_internal((SigitTAzioneContrattoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTAzioneContrattoDto mapRow_internal(SigitTAzioneContrattoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTAzioneContrattoDto dto = objectToFill;

		// colonna [ID_CONTRATTO]
		if (mapAllColumns || columnsToReadMap.get("ID_CONTRATTO") != null)
			dto.setIdContratto((Integer) rs.getObject("ID_CONTRATTO"));

		// colonna [DT_AZIONE]
		if (mapAllColumns || columnsToReadMap.get("DT_AZIONE") != null)
			dto.setDtAzione(rs.getTimestamp("DT_AZIONE"));

		// colonna [CF_UTENTE_AZIONE]
		if (mapAllColumns || columnsToReadMap.get("CF_UTENTE_AZIONE") != null)
			dto.setCfUtenteAzione(rs.getString("CF_UTENTE_AZIONE"));

		// colonna [DESCRIZIONE_AZIONE]
		if (mapAllColumns || columnsToReadMap.get("DESCRIZIONE_AZIONE") != null)
			dto.setDescrizioneAzione(rs.getString("DESCRIZIONE_AZIONE"));

		// colonna [OLD_DATA_FINE]
		if (mapAllColumns || columnsToReadMap.get("OLD_DATA_FINE") != null)
			dto.setOldDataFine(rs.getDate("OLD_DATA_FINE"));

		return dto;
	}

}
