package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTAbilitazioneDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTAbilitazioneDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAbilitazioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAbilitazionePk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTAbilitazioneDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.GenericUtil;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class SigitTAbilitazioneDaoImpl extends AbstractDAO implements SigitTAbilitazioneDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	/**
	 * Il DAO utilizza JDBC template per l'implementazione delle query.
	 *
	 * @generated
	 */
	protected NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 *
	 * @generated
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Metodo di inserimento del DAO sigitTAbilitazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 *
	 * @param dto
	 * @return SigitTAbilitazionePk
	 * @generated
	 */

	public SigitTAbilitazionePk insert(SigitTAbilitazioneDto dto) {
		LOG.debug("[SigitTAbilitazioneDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName() + " ( 	ID_RUOLO_PA,ISTAT_ABILITAZIONE,MAIL_COMUNICAZIONE ) VALUES (  :ID_RUOLO_PA , :ISTAT_ABILITAZIONE , :MAIL_COMUNICAZIONE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RUOLO_PA]
		params.addValue("ID_RUOLO_PA", dto.getIdRuoloPa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ISTAT_ABILITAZIONE]
		params.addValue("ISTAT_ABILITAZIONE", dto.getIstatAbilitazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MAIL_COMUNICAZIONE]
		params.addValue("MAIL_COMUNICAZIONE", dto.getMailComunicazione(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTAbilitazioneDaoImpl::insert] END");
		return dto.createPk();

	}

	/**
	 * Updates a single row in the SIGIT_T_ABILITAZIONE table.
	 *
	 * @generated
	 */
	public void update(SigitTAbilitazioneDto dto) throws SigitTAbilitazioneDaoException {
		LOG.debug("[SigitTAbilitazioneDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName() + " SET MAIL_COMUNICAZIONE = :MAIL_COMUNICAZIONE  WHERE ID_RUOLO_PA = :ID_RUOLO_PA  AND ISTAT_ABILITAZIONE = :ISTAT_ABILITAZIONE ";

		if (dto.getIdRuoloPa() == null || dto.getIstatAbilitazione() == null) {
			LOG.error("[SigitTAbilitazioneDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTAbilitazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RUOLO_PA]
		params.addValue("ID_RUOLO_PA", dto.getIdRuoloPa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ISTAT_ABILITAZIONE]
		params.addValue("ISTAT_ABILITAZIONE", dto.getIstatAbilitazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MAIL_COMUNICAZIONE]
		params.addValue("MAIL_COMUNICAZIONE", dto.getMailComunicazione(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAbilitazioneDaoImpl::update] END");
	}

	protected SigitTAbilitazioneDaoRowMapper findByPrimaryKeyRowMapper = new SigitTAbilitazioneDaoRowMapper(null, SigitTAbilitazioneDto.class, this);

	protected SigitTAbilitazioneDaoRowMapper byExampleRowMapper = new SigitTAbilitazioneDaoRowMapper(null, SigitTAbilitazioneDto.class, this);

	protected SigitTAbilitazioneDaoRowMapper findAllRowMapper = new SigitTAbilitazioneDaoRowMapper(null, SigitTAbilitazioneDto.class, this);

	protected SigitTAbilitazioneDaoRowMapper comboIstatAbilitazioneRowMapper = new SigitTAbilitazioneDaoRowMapper(new String[] { "ISTAT_ABILITAZIONE" }, SigitTAbilitazioneDto.class, this);

	/**
	 * Restituisce il nome della tabella su cui opera il DAO
	 *
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_ABILITAZIONE";
	}

	/**
	 * Returns all rows from the SIGIT_T_ABILITAZIONE table that match the primary key criteria
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTAbilitazioneDto findByPrimaryKey(SigitTAbilitazionePk pk) throws SigitTAbilitazioneDaoException {
		LOG.debug("[SigitTAbilitazioneDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_RUOLO_PA,ISTAT_ABILITAZIONE,MAIL_COMUNICAZIONE FROM " + getTableName() + " WHERE ID_RUOLO_PA = :ID_RUOLO_PA  AND ISTAT_ABILITAZIONE = :ISTAT_ABILITAZIONE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RUOLO_PA]
		params.addValue("ID_RUOLO_PA", pk.getIdRuoloPa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ISTAT_ABILITAZIONE]
		params.addValue("ISTAT_ABILITAZIONE", pk.getIstatAbilitazione(), java.sql.Types.VARCHAR);

		List<SigitTAbilitazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTAbilitazioneDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTAbilitazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAbilitazioneDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTAbilitazioneDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * Implementazione del finder byExample
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAbilitazioneDto> findByExample(SigitTAbilitazioneDto input) throws SigitTAbilitazioneDaoException {
		LOG.debug("[SigitTAbilitazioneDaoImpl::findByExample] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_RUOLO_PA,ISTAT_ABILITAZIONE,MAIL_COMUNICAZIONE ");
		sql.append(" FROM SIGIT_T_ABILITAZIONE");
		sql.append(" WHERE ");

		sql.append(" 1 = 1");

		if (GenericUtil.isNotNullOrEmpty(input.getIdRuoloPa())) {
			sql.append(" AND ID_RUOLO_PA = :idRuolo");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIstatAbilitazione())) {
			sql.append(" AND ISTAT_ABILITAZIONE = :istatAbil");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdRuoloPa())) {
			paramMap.addValue("idRuolo", input.getIdRuoloPa());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIstatAbilitazione())) {
			paramMap.addValue("istatAbil", input.getIstatAbilitazione());
		}

		/*PROTECTED REGION END*/
		List<SigitTAbilitazioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byExampleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTAbilitazioneDaoImpl::findByExample] esecuzione query", ex);
			throw new SigitTAbilitazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAbilitazioneDaoImpl", "findByExample", "esecuzione query", sql.toString());
			LOG.debug("[SigitTAbilitazioneDaoImpl::findByExample] END");
		}
		return list;
	}

	/**
	 * Restituisce tutte le righe della tabella SIGIT_T_ABILITAZIONE.
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAbilitazioneDto> findAll() throws SigitTAbilitazioneDaoException {
		LOG.debug("[SigitTAbilitazioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_RUOLO_PA,ISTAT_ABILITAZIONE,MAIL_COMUNICAZIONE FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTAbilitazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTAbilitazioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitTAbilitazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAbilitazioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitTAbilitazioneDaoImpl::findAll] END");
		}
		return list;
	}

	/**
	 * Implementazione del finder comboIstatAbilitazione
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAbilitazioneDto> findComboIstatAbilitazione(java.lang.Integer input) throws SigitTAbilitazioneDaoException {
		LOG.debug("[SigitTAbilitazioneDaoImpl::findComboIstatAbilitazione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT DISTINCT ISTAT_ABILITAZIONE ");
		sql.append(" FROM SIGIT_T_ABILITAZIONE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1217723227) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("1 = 1");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1785849405) ENABLED START*/
		//***aggiungere tutte le condizioni

		//paramMap.addValue("nome", input);

		/*PROTECTED REGION END*/
		List<SigitTAbilitazioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, comboIstatAbilitazioneRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTAbilitazioneDaoImpl::findComboIstatAbilitazione] esecuzione query", ex);
			throw new SigitTAbilitazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAbilitazioneDaoImpl", "findComboIstatAbilitazione", "esecuzione query", sql.toString());
			LOG.debug("[SigitTAbilitazioneDaoImpl::findComboIstatAbilitazione] END");
		}
		return list;
	}

}
