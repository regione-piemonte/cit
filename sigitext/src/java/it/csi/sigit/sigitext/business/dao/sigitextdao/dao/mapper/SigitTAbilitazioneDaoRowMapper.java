package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTAbilitazioneDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTAbilitazioneDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAbilitazioneDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SigitTAbilitazioneDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 *
	 * @generated
	 */
	SigitTAbilitazioneDaoImpl dao;

	/**
	 * costruttore
	 *
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *                      incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTAbilitazioneDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTAbilitazioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTAbilitazioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 *
	 * @param rs
	 * @param row
	 * @return SigitTAbilitazioneDto
	 * @throws SQLException
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTAbilitazioneDto) {
			return mapRow_internal((SigitTAbilitazioneDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTAbilitazioneDto mapRow_internal(SigitTAbilitazioneDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitTAbilitazioneDto dto = objectToFill;

		// colonna [ID_RUOLO_PA]
		if (mapAllColumns || columnsToReadMap.get("ID_RUOLO_PA") != null)
			dto.setIdRuoloPa((Integer) rs.getObject("ID_RUOLO_PA"));

		// colonna [ISTAT_ABILITAZIONE]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_ABILITAZIONE") != null)
			dto.setIstatAbilitazione(rs.getString("ISTAT_ABILITAZIONE"));

		// colonna [MAIL_COMUNICAZIONE]
		if (mapAllColumns || columnsToReadMap.get("MAIL_COMUNICAZIONE") != null)
			dto.setMailComunicazione(rs.getString("MAIL_COMUNICAZIONE"));

		return dto;
	}

}
