package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import it.csi.sigit.sigitwebn.business.dao.impl.*;
import it.csi.sigit.sigitwebn.business.dao.util.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import java.util.Map;
import java.util.TreeMap;

/*PROTECTED REGION ID(R-417098165) ENABLED START*/
// aggiungere qui eventuali import custom. 
import java.math.BigDecimal;

import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRRuoloTipodoc.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - verificaAllegatoSelezionato (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRRuoloTipodocDaoImpl extends AbstractDAO implements SigitRRuoloTipodocDao {
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

	protected SigitRRuoloTipodocDaoRowMapper findAllRowMapper = new SigitRRuoloTipodocDaoRowMapper(null,
			SigitRRuoloTipodocDto.class, this);

	protected SigitRRuoloTipodocDaoRowMapper findByPrimaryKeyRowMapper = new SigitRRuoloTipodocDaoRowMapper(null,
			SigitRRuoloTipodocDto.class, this);

	protected SigitRRuoloTipodocDaoRowMapper verificaAllegatoSelezionatoRowMapper = new SigitRRuoloTipodocDaoRowMapper(
			null, SigitRRuoloTipodocDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_RUOLO_TIPODOC";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_R_RUOLO_TIPODOC.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRRuoloTipodocDto> findAll() throws SigitRRuoloTipodocDaoException {
		LOG.debug("[SigitRRuoloTipodocDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_RUOLO,ID_TIPO_DOCUMENTO FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitRRuoloTipodocDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRRuoloTipodocDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitRRuoloTipodocDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRRuoloTipodocDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitRRuoloTipodocDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_R_RUOLO_TIPODOC table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRRuoloTipodocDto findByPrimaryKey(SigitRRuoloTipodocPk pk) throws SigitRRuoloTipodocDaoException {
		LOG.debug("[SigitRRuoloTipodocDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_RUOLO,ID_TIPO_DOCUMENTO FROM " + getTableName()
				+ " WHERE ID_RUOLO = :ID_RUOLO  AND ID_TIPO_DOCUMENTO = :ID_TIPO_DOCUMENTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RUOLO]
		params.addValue("ID_RUOLO", pk.getIdRuolo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_DOCUMENTO]
		params.addValue("ID_TIPO_DOCUMENTO", pk.getIdTipoDocumento(), java.sql.Types.NUMERIC);

		List<SigitRRuoloTipodocDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRRuoloTipodocDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitRRuoloTipodocDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRRuoloTipodocDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitRRuoloTipodocDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder verificaAllegatoSelezionato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRRuoloTipodocDto> findVerificaAllegatoSelezionato(
			it.csi.sigit.sigitwebn.dto.allegati.FiltroControlloInserisciAllegato input)
			throws SigitRRuoloTipodocDaoException {
		LOG.debug("[SigitRRuoloTipodocDaoImpl::findVerificaAllegatoSelezionato] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_RUOLO,ID_TIPO_DOCUMENTO ");
		sql.append(" FROM SIGIT_R_RUOLO_TIPODOC");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R69103168) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" 1 = 1 ");
		if (GenericUtil.isNotNullOrEmpty(input.getIdRuoloFunzionale()))
			sql.append(" AND ID_RUOLO = :idRuolo");
		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoDocumento()))
			sql.append(" AND ID_TIPO_DOCUMENTO = :idTipoDocumento");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1272205310) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (GenericUtil.isNotNullOrEmpty(input.getIdRuoloFunzionale()))
			paramMap.addValue("idRuolo", new BigDecimal(input.getIdRuoloFunzionale()));
		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoDocumento()))
			paramMap.addValue("idTipoDocumento", new BigDecimal(input.getIdTipoDocumento().toString()));

		/*PROTECTED REGION END*/
		List<SigitRRuoloTipodocDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, verificaAllegatoSelezionatoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRRuoloTipodocDaoImpl::findVerificaAllegatoSelezionato] esecuzione query", ex);
			throw new SigitRRuoloTipodocDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRRuoloTipodocDaoImpl", "findVerificaAllegatoSelezionato", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRRuoloTipodocDaoImpl::findVerificaAllegatoSelezionato] END");
		}
		return list;
	}

}
