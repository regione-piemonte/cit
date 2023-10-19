package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDFonteEnSfruttataDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitDFonteEnSfruttataDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDFonteEnSfruttataDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDFonteEnSfruttataPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDFonteEnSfruttataDaoException;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

import static it.csi.sigit.sigitext.business.util.Constants.APPLICATION_CODE;

public class SigitDFonteEnSfruttataDaoImpl extends AbstractDAO implements SigitDFonteEnSfruttataDao {
	protected static final Logger LOG = Logger.getLogger(APPLICATION_CODE);
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

	protected SigitDFonteEnSfruttataDaoRowMapper findAllRowMapper = new SigitDFonteEnSfruttataDaoRowMapper(null,
			SigitDFonteEnSfruttataDto.class, this);

	protected SigitDFonteEnSfruttataDaoRowMapper findByPrimaryKeyRowMapper = new SigitDFonteEnSfruttataDaoRowMapper(
			null, SigitDFonteEnSfruttataDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_FONTE_EN_SFRUTTATA";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_FONTE_EN_SFRUTTATA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDFonteEnSfruttataDto> findAll() throws SigitDFonteEnSfruttataDaoException {
		LOG.debug("[SigitDFonteEnSfruttataDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_FONTE_EN_SFRUTTATA,DESC_FONTE_EN_SFRUTTATA FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDFonteEnSfruttataDto> list = null;

		StopWatch stopWatch = new StopWatch(APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDFonteEnSfruttataDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDFonteEnSfruttataDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDFonteEnSfruttataDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDFonteEnSfruttataDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_D_FONTE_EN_SFRUTTATA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDFonteEnSfruttataDto findByPrimaryKey(SigitDFonteEnSfruttataPk pk)
			throws SigitDFonteEnSfruttataDaoException {
		LOG.debug("[SigitDFonteEnSfruttataDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_FONTE_EN_SFRUTTATA,DESC_FONTE_EN_SFRUTTATA FROM "
				+ getTableName() + " WHERE ID_FONTE_EN_SFRUTTATA = :ID_FONTE_EN_SFRUTTATA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_FONTE_EN_SFRUTTATA]
		params.addValue("ID_FONTE_EN_SFRUTTATA", pk.getIdFonteEnSfruttata(), java.sql.Types.NUMERIC);

		List<SigitDFonteEnSfruttataDto> list = null;

		StopWatch stopWatch = new StopWatch(APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDFonteEnSfruttataDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDFonteEnSfruttataDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDFonteEnSfruttataDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitDFonteEnSfruttataDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
