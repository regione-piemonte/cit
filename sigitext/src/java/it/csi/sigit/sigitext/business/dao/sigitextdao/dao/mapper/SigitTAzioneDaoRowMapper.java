package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTAzioneDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTAzioneDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzioneDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SigitTAzioneDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTAzioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTAzioneDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTAzioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTAzioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTAzioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTAzioneDto) {
			return mapRow_internal((SigitTAzioneDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTAzioneDto mapRow_internal(SigitTAzioneDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitTAzioneDto dto = objectToFill;

		// colonna [ID_AZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_AZIONE") != null)
			dto.setIdAzione((Integer) rs.getObject("ID_AZIONE"));

		// colonna [DT_AZIONE]
		if (mapAllColumns || columnsToReadMap.get("DT_AZIONE") != null)
			dto.setDtAzione(rs.getDate("DT_AZIONE"));

		// colonna [FK_TIPO_AZIONE]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_AZIONE") != null)
			dto.setFkTipoAzione((Integer) rs.getObject("FK_TIPO_AZIONE"));

		// colonna [FK_VERIFICA]
		if (mapAllColumns || columnsToReadMap.get("FK_VERIFICA") != null)
			dto.setFkVerifica((Integer) rs.getObject("FK_VERIFICA"));

		// colonna [FK_ACCERTAMENTO]
		if (mapAllColumns || columnsToReadMap.get("FK_ACCERTAMENTO") != null)
			dto.setFkAccertamento((Integer) rs.getObject("FK_ACCERTAMENTO"));

		// colonna [FK_ISPEZIONE_2018]
		if (mapAllColumns || columnsToReadMap.get("FK_ISPEZIONE_2018") != null)
			dto.setFkIspezione2018((Integer) rs.getObject("FK_ISPEZIONE_2018"));

		// colonna [FK_SANZIONE]
		if (mapAllColumns || columnsToReadMap.get("FK_SANZIONE") != null)
			dto.setFkSanzione((Integer) rs.getObject("FK_SANZIONE"));

		// colonna [DESCRIZIONE_AZIONE]
		if (mapAllColumns || columnsToReadMap.get("DESCRIZIONE_AZIONE") != null)
			dto.setDescrizioneAzione(rs.getString("DESCRIZIONE_AZIONE"));

		// colonna [CF_UTENTE_AZIONE]
		if (mapAllColumns || columnsToReadMap.get("CF_UTENTE_AZIONE") != null)
			dto.setCfUtenteAzione(rs.getString("CF_UTENTE_AZIONE"));

		// colonna [DENOM_UTENTE_AZIONE]
		if (mapAllColumns || columnsToReadMap.get("DENOM_UTENTE_AZIONE") != null)
			dto.setDenomUtenteAzione(rs.getString("DENOM_UTENTE_AZIONE"));

		return dto;
	}

}
