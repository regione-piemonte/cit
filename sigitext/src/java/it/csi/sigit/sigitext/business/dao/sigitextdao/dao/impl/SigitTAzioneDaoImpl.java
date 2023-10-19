package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTAzioneDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTAzioneDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzionePk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTAzioneDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class SigitTAzioneDaoImpl extends AbstractDAO implements SigitTAzioneDao {
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
	 * Metodo di inserimento del DAO sigitTAzione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAzionePk
	 * @generated
	 */

	public SigitTAzionePk insert(SigitTAzioneDto dto)

	{
		LOG.debug("[SigitTAzioneDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_AZIONE,DT_AZIONE,FK_TIPO_AZIONE,FK_VERIFICA,FK_ACCERTAMENTO,FK_ISPEZIONE_2018,FK_SANZIONE,DESCRIZIONE_AZIONE,CF_UTENTE_AZIONE,DENOM_UTENTE_AZIONE ) VALUES (  :ID_AZIONE , :DT_AZIONE , :FK_TIPO_AZIONE , :FK_VERIFICA , :FK_ACCERTAMENTO , :FK_ISPEZIONE_2018 , :FK_SANZIONE , :DESCRIZIONE_AZIONE , :CF_UTENTE_AZIONE , :DENOM_UTENTE_AZIONE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIONE]
		params.addValue("ID_AZIONE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DT_AZIONE]
		params.addValue("DT_AZIONE", dto.getDtAzione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_TIPO_AZIONE]
		params.addValue("FK_TIPO_AZIONE", dto.getFkTipoAzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_VERIFICA]
		params.addValue("FK_VERIFICA", dto.getFkVerifica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ACCERTAMENTO]
		params.addValue("FK_ACCERTAMENTO", dto.getFkAccertamento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ISPEZIONE_2018]
		params.addValue("FK_ISPEZIONE_2018", dto.getFkIspezione2018(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_SANZIONE]
		params.addValue("FK_SANZIONE", dto.getFkSanzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCRIZIONE_AZIONE]
		params.addValue("DESCRIZIONE_AZIONE", dto.getDescrizioneAzione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CF_UTENTE_AZIONE]
		params.addValue("CF_UTENTE_AZIONE", dto.getCfUtenteAzione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DENOM_UTENTE_AZIONE]
		params.addValue("DENOM_UTENTE_AZIONE", dto.getDenomUtenteAzione(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdAzione(newKey);
		LOG.debug("[SigitTAzioneDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_AZIONE table.
	 * @generated
	 */
	public void update(SigitTAzioneDto dto) throws SigitTAzioneDaoException {
		LOG.debug("[SigitTAzioneDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DT_AZIONE = :DT_AZIONE ,FK_TIPO_AZIONE = :FK_TIPO_AZIONE ,FK_VERIFICA = :FK_VERIFICA ,FK_ACCERTAMENTO = :FK_ACCERTAMENTO ,FK_ISPEZIONE_2018 = :FK_ISPEZIONE_2018 ,FK_SANZIONE = :FK_SANZIONE ,DESCRIZIONE_AZIONE = :DESCRIZIONE_AZIONE ,CF_UTENTE_AZIONE = :CF_UTENTE_AZIONE ,DENOM_UTENTE_AZIONE = :DENOM_UTENTE_AZIONE  WHERE ID_AZIONE = :ID_AZIONE ";

		if (dto.getIdAzione() == null) {
			LOG.error("[SigitTAzioneDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTAzioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIONE]
		params.addValue("ID_AZIONE", dto.getIdAzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DT_AZIONE]
		params.addValue("DT_AZIONE", dto.getDtAzione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_TIPO_AZIONE]
		params.addValue("FK_TIPO_AZIONE", dto.getFkTipoAzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_VERIFICA]
		params.addValue("FK_VERIFICA", dto.getFkVerifica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ACCERTAMENTO]
		params.addValue("FK_ACCERTAMENTO", dto.getFkAccertamento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ISPEZIONE_2018]
		params.addValue("FK_ISPEZIONE_2018", dto.getFkIspezione2018(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_SANZIONE]
		params.addValue("FK_SANZIONE", dto.getFkSanzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCRIZIONE_AZIONE]
		params.addValue("DESCRIZIONE_AZIONE", dto.getDescrizioneAzione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CF_UTENTE_AZIONE]
		params.addValue("CF_UTENTE_AZIONE", dto.getCfUtenteAzione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DENOM_UTENTE_AZIONE]
		params.addValue("DENOM_UTENTE_AZIONE", dto.getDenomUtenteAzione(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAzioneDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_AZIONE table.
	 * @generated
	 */

	public void delete(SigitTAzionePk pk) throws SigitTAzioneDaoException {
		LOG.debug("[SigitTAzioneDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_AZIONE = :ID_AZIONE ";

		if (pk == null) {
			LOG.error("[SigitTAzioneDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTAzioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIONE]
		params.addValue("ID_AZIONE", pk.getIdAzione(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAzioneDaoImpl::delete] END");
	}

	protected SigitTAzioneDaoRowMapper findByPrimaryKeyRowMapper = new SigitTAzioneDaoRowMapper(null,
			SigitTAzioneDto.class, this);

	protected SigitTAzioneDaoRowMapper byExampleRowMapper = new SigitTAzioneDaoRowMapper(null, SigitTAzioneDto.class,
			this);

	protected SigitTAzioneDaoRowMapper findAllRowMapper = new SigitTAzioneDaoRowMapper(null, SigitTAzioneDto.class,
			this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_AZIONE";
	}

	/** 
	 * Returns all rows from the SIGIT_T_AZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTAzioneDto findByPrimaryKey(SigitTAzionePk pk) throws SigitTAzioneDaoException {
		LOG.debug("[SigitTAzioneDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AZIONE,DT_AZIONE,FK_TIPO_AZIONE,FK_VERIFICA,FK_ACCERTAMENTO,FK_ISPEZIONE_2018,FK_SANZIONE,DESCRIZIONE_AZIONE,CF_UTENTE_AZIONE,DENOM_UTENTE_AZIONE FROM "
						+ getTableName() + " WHERE ID_AZIONE = :ID_AZIONE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIONE]
		params.addValue("ID_AZIONE", pk.getIdAzione(), java.sql.Types.INTEGER);

		List<SigitTAzioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTAzioneDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTAzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAzioneDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTAzioneDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAzioneDto> findByExample(SigitTAzioneDto input)
			throws SigitTAzioneDaoException {
		LOG.debug("[SigitTAzioneDaoImpl::findByExample] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_AZIONE,DT_AZIONE,FK_TIPO_AZIONE,FK_VERIFICA,FK_ACCERTAMENTO,FK_ISPEZIONE_2018,FK_SANZIONE,DESCRIZIONE_AZIONE,CF_UTENTE_AZIONE,DENOM_UTENTE_AZIONE ");
		sql.append(" FROM SIGIT_T_AZIONE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R324968941) ENABLED START*/
		sql.append(" 1 = 1 ");

		if (input.getFkVerifica() != null) {
			sql.append("AND FK_VERIFICA= :fkVerifica");
		}

		if (input.getFkAccertamento() != null) {
			sql.append("AND FK_ACCERTAMENTO= :fkAccertamento");
		}

		if (input.getFkIspezione2018() != null) {
			sql.append("AND FK_ISPEZIONE_2018= :fkIspezione");
		}

		if (input.getFkSanzione() != null) {
			sql.append("AND FK_SANZIONE= :fkSanzione");
		}

		sql.append(" ORDER BY ID_AZIONE DESC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1930300939) ENABLED START*/
		//***aggiungere tutte le condizioni
		if (input.getFkVerifica() != null) {
			paramMap.addValue("fkVerifica", input.getFkVerifica(), java.sql.Types.INTEGER);
		}

		if (input.getFkAccertamento() != null) {
			paramMap.addValue("fkAccertamento", input.getFkAccertamento(), java.sql.Types.INTEGER);
		}

		if (input.getFkIspezione2018() != null) {
			paramMap.addValue("fkIspezione", input.getFkIspezione2018(), java.sql.Types.INTEGER);
		}

		if (input.getFkSanzione() != null) {
			paramMap.addValue("fkSanzione", input.getFkSanzione(), java.sql.Types.INTEGER);
		}

		/*PROTECTED REGION END*/
		List<SigitTAzioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byExampleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTAzioneDaoImpl::findByExample] esecuzione query", ex);
			throw new SigitTAzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAzioneDaoImpl", "findByExample", "esecuzione query", sql.toString());
			LOG.debug("[SigitTAzioneDaoImpl::findByExample] END");
		}
		return list;
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_AZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAzioneDto> findAll() throws SigitTAzioneDaoException {
		LOG.debug("[SigitTAzioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AZIONE,DT_AZIONE,FK_TIPO_AZIONE,FK_VERIFICA,FK_ACCERTAMENTO,FK_ISPEZIONE_2018,FK_SANZIONE,DESCRIZIONE_AZIONE,CF_UTENTE_AZIONE,DENOM_UTENTE_AZIONE FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTAzioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTAzioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitTAzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAzioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitTAzioneDaoImpl::findAll] END");
		}
		return list;
	}

}
