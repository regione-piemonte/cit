package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTCodiceBollDao
 * @generated
 */
public class SigitTCodiceBollDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTCodiceBollDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTCodiceBollDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTCodiceBollDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTCodiceBollDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTCodiceBollDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTCodiceBollDto) {
			return mapRow_internal((SigitTCodiceBollDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof SigitTCodiceBollByNumeroBollinoPerPotenzaPrezzoDto) {
			return mapRow_internal((SigitTCodiceBollByNumeroBollinoPerPotenzaPrezzoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTCodiceBollDto mapRow_internal(SigitTCodiceBollDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTCodiceBollDto dto = objectToFill;

		// colonna [SIGLA_BOLLINO]
		if (mapAllColumns || columnsToReadMap.get("SIGLA_BOLLINO") != null)
			dto.setSiglaBollino(rs.getString("SIGLA_BOLLINO"));

		// colonna [NUMERO_BOLLINO]
		if (mapAllColumns || columnsToReadMap.get("NUMERO_BOLLINO") != null)
			dto.setNumeroBollino(rs.getBigDecimal("NUMERO_BOLLINO"));

		// colonna [FK_TRANSAZIONE_BOLL]
		if (mapAllColumns || columnsToReadMap.get("FK_TRANSAZIONE_BOLL") != null)
			dto.setFkTransazioneBoll(rs.getBigDecimal("FK_TRANSAZIONE_BOLL"));

		// colonna [FK_POTENZA]
		if (mapAllColumns || columnsToReadMap.get("FK_POTENZA") != null)
			dto.setFkPotenza(rs.getBigDecimal("FK_POTENZA"));

		// colonna [FK_PREZZO]
		if (mapAllColumns || columnsToReadMap.get("FK_PREZZO") != null)
			dto.setFkPrezzo(rs.getBigDecimal("FK_PREZZO"));

		// colonna [FK_DT_INIZIO_ACQUISTO]
		if (mapAllColumns || columnsToReadMap.get("FK_DT_INIZIO_ACQUISTO") != null)
			dto.setFkDtInizioAcquisto(rs.getDate("FK_DT_INIZIO_ACQUISTO"));

		// colonna [FLG_PREGRESSO]
		if (mapAllColumns || columnsToReadMap.get("FLG_PREGRESSO") != null)
			dto.setFlgPregresso(rs.getBigDecimal("FLG_PREGRESSO"));

		// colonna [DT_INSERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DT_INSERIMENTO") != null)
			dto.setDtInserimento(rs.getTimestamp("DT_INSERIMENTO"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitTCodiceBollByNumeroBollinoPerPotenzaPrezzoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTCodiceBollByNumeroBollinoPerPotenzaPrezzoDto
	 * @generated
	 */

	public SigitTCodiceBollByNumeroBollinoPerPotenzaPrezzoDto mapRow_internal(
			SigitTCodiceBollByNumeroBollinoPerPotenzaPrezzoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTCodiceBollByNumeroBollinoPerPotenzaPrezzoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("FKTRANSAZIONEBOLL") != null)
			dto.setFkTransazioneBoll(rs.getBigDecimal("fkTransazioneBoll"));

		if (mapAllColumns || columnsToReadMap.get("SIGLABOLLINO") != null)
			dto.setSiglaBollino(rs.getString("siglaBollino"));

		if (mapAllColumns || columnsToReadMap.get("NUMEROBOLLINO") != null)
			dto.setNumeroBollino(rs.getBigDecimal("numeroBollino"));

		if (mapAllColumns || columnsToReadMap.get("FKPOTENZA") != null)
			dto.setFkPotenza(rs.getBigDecimal("fkPotenza"));

		if (mapAllColumns || columnsToReadMap.get("FKPREZZO") != null)
			dto.setFkPrezzo(rs.getBigDecimal("fkPrezzo"));

		if (mapAllColumns || columnsToReadMap.get("FKDATAINIZIOACQUISTO") != null)
			dto.setFkDataInizioAcquisto(rs.getDate("fkDataInizioAcquisto"));

		return dto;
	}

}
