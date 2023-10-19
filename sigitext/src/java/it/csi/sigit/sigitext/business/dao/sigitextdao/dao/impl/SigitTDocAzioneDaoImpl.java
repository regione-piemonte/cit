package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTDocAzioneDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTDocAzioneDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAzioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAzionePk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDocAzioneDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class SigitTDocAzioneDaoImpl extends AbstractDAO implements SigitTDocAzioneDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	/**
	 * Il DAO utilizza JDBC template per l'implementazione delle query.
	 * @generated
	 */
	protected NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 * @generated
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Metodo di inserimento del DAO sigitTDocAzione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDocAzionePk
	 * @generated
	 */

	public SigitTDocAzionePk insert(SigitTDocAzioneDto dto)

	{
		LOG.debug("[SigitTDocAzioneDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_DOC_AZIONE,FK_AZIONE,NOME_DOC_ORIGINALE,NOME_DOC,UID_INDEX,DATA_ULT_MOD,UTENTE_ULT_MOD ) VALUES (  :ID_DOC_AZIONE , :FK_AZIONE , :NOME_DOC_ORIGINALE , :NOME_DOC , :UID_INDEX , :DATA_ULT_MOD , :UTENTE_ULT_MOD  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DOC_AZIONE]
		params.addValue("ID_DOC_AZIONE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIONE]
		params.addValue("FK_AZIONE", dto.getFkAzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOME_DOC_ORIGINALE]
		params.addValue("NOME_DOC_ORIGINALE", dto.getNomeDocOriginale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOME_DOC]
		params.addValue("NOME_DOC", dto.getNomeDoc(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX]
		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdDocAzione(newKey);
		LOG.debug("[SigitTDocAzioneDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_DOC_AZIONE table.
	 * @generated
	 */
	public void update(SigitTDocAzioneDto dto) throws SigitTDocAzioneDaoException {
		LOG.debug("[SigitTDocAzioneDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_AZIONE = :FK_AZIONE ,NOME_DOC_ORIGINALE = :NOME_DOC_ORIGINALE ,NOME_DOC = :NOME_DOC ,UID_INDEX = :UID_INDEX ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD  WHERE ID_DOC_AZIONE = :ID_DOC_AZIONE ";

		if (dto.getIdDocAzione() == null) {
			LOG.error("[SigitTDocAzioneDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTDocAzioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DOC_AZIONE]
		params.addValue("ID_DOC_AZIONE", dto.getIdDocAzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIONE]
		params.addValue("FK_AZIONE", dto.getFkAzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOME_DOC_ORIGINALE]
		params.addValue("NOME_DOC_ORIGINALE", dto.getNomeDocOriginale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOME_DOC]
		params.addValue("NOME_DOC", dto.getNomeDoc(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX]
		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDocAzioneDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_DOC_AZIONE table.
	 * @generated
	 */
	public void updateColumnsAggiornaNomeUid(SigitTDocAzioneDto dto) throws SigitTDocAzioneDaoException {
		LOG.debug("[SigitTDocAzioneDaoImpl::updateColumnsAggiornaNomeUid] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET NOME_DOC = :NOME_DOC ,UID_INDEX = :UID_INDEX  WHERE ID_DOC_AZIONE = :ID_DOC_AZIONE ";

		if (dto.getIdDocAzione() == null) {
			LOG.error("[SigitTDocAzioneDaoImpl::updateColumnsAggiornaNomeUid] ERROR chiave primaria non impostata");
			throw new SigitTDocAzioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [NOME_DOC]
		params.addValue("NOME_DOC", dto.getNomeDoc(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX]
		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_DOC_AZIONE]
		params.addValue("ID_DOC_AZIONE", dto.getIdDocAzione(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDocAzioneDaoImpl::updateColumnsAggiornaNomeUid] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_DOC_AZIONE table.
	 * @generated
	 */

	public void delete(SigitTDocAzionePk pk) throws SigitTDocAzioneDaoException {
		LOG.debug("[SigitTDocAzioneDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_DOC_AZIONE = :ID_DOC_AZIONE ";

		if (pk == null) {
			LOG.error("[SigitTDocAzioneDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTDocAzioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DOC_AZIONE]
		params.addValue("ID_DOC_AZIONE", pk.getIdDocAzione(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDocAzioneDaoImpl::delete] END");
	}

	protected SigitTDocAzioneDaoRowMapper findByPrimaryKeyRowMapper = new SigitTDocAzioneDaoRowMapper(null,
			SigitTDocAzioneDto.class, this);

	protected SigitTDocAzioneDaoRowMapper byIdAzioneRowMapper = new SigitTDocAzioneDaoRowMapper(null,
			SigitTDocAzioneDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DOC_AZIONE";
	}

	/** 
	 * Returns all rows from the SIGIT_T_DOC_AZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTDocAzioneDto findByPrimaryKey(SigitTDocAzionePk pk) throws SigitTDocAzioneDaoException {
		LOG.debug("[SigitTDocAzioneDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_DOC_AZIONE,FK_AZIONE,NOME_DOC_ORIGINALE,NOME_DOC,UID_INDEX,DATA_ULT_MOD,UTENTE_ULT_MOD FROM "
						+ getTableName() + " WHERE ID_DOC_AZIONE = :ID_DOC_AZIONE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DOC_AZIONE]
		params.addValue("ID_DOC_AZIONE", pk.getIdDocAzione(), java.sql.Types.INTEGER);

		List<SigitTDocAzioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTDocAzioneDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTDocAzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDocAzioneDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDocAzioneDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byIdAzione
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDocAzioneDto> findByIdAzione(java.lang.Integer input) throws SigitTDocAzioneDaoException {
		LOG.debug("[SigitTDocAzioneDaoImpl::findByIdAzione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_DOC_AZIONE,FK_AZIONE,NOME_DOC_ORIGINALE,NOME_DOC,UID_INDEX,DATA_ULT_MOD,UTENTE_ULT_MOD ");
		sql.append(" FROM SIGIT_T_DOC_AZIONE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R588243442) ENABLED START*/
		sql.append(" FK_AZIONE = :idAzione");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1936241296) ENABLED START*/

		paramMap.addValue("idAzione", input);

		/*PROTECTED REGION END*/
		List<SigitTDocAzioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAzioneRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTDocAzioneDaoImpl::findByIdAzione] esecuzione query", ex);
			throw new SigitTDocAzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDocAzioneDaoImpl", "findByIdAzione", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDocAzioneDaoImpl::findByIdAzione] END");
		}
		return list;
	}

}
