package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTAzioneComp4Dao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTAzioneComp4DaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzioneComp4Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTAzioneComp4Dao
 * @generated
 */
public class SigitTAzioneComp4DaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTAzioneComp4DaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTAzioneComp4DaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTAzioneComp4Dao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTAzioneComp4DaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTAzioneComp4Dto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTAzioneComp4Dto) {
			return mapRow_internal((SigitTAzioneComp4Dto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTAzioneComp4Dto mapRow_internal(SigitTAzioneComp4Dto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTAzioneComp4Dto dto = objectToFill;

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [ID_TIPO_COMPONENTE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_COMPONENTE") != null)
			dto.setIdTipoComponente(rs.getString("ID_TIPO_COMPONENTE"));

		// colonna [PROGRESSIVO]
		if (mapAllColumns || columnsToReadMap.get("PROGRESSIVO") != null)
			dto.setProgressivo(rs.getBigDecimal("PROGRESSIVO"));

		// colonna [DT_INSTALL]
		if (mapAllColumns || columnsToReadMap.get("DT_INSTALL") != null)
			dto.setDtInstall(rs.getDate("DT_INSTALL"));

		// colonna [DT_AZIONE]
		if (mapAllColumns || columnsToReadMap.get("DT_AZIONE") != null)
			dto.setDtAzione(rs.getTimestamp("DT_AZIONE"));

		// colonna [CF_UTENTE_AZIONE]
		if (mapAllColumns || columnsToReadMap.get("CF_UTENTE_AZIONE") != null)
			dto.setCfUtenteAzione(rs.getString("CF_UTENTE_AZIONE"));

		// colonna [DESCRIZIONE_AZIONE]
		if (mapAllColumns || columnsToReadMap.get("DESCRIZIONE_AZIONE") != null)
			dto.setDescrizioneAzione(rs.getString("DESCRIZIONE_AZIONE"));

		return dto;
	}

}
