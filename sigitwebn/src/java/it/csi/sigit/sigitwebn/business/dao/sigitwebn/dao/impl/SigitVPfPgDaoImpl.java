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

/*PROTECTED REGION ID(R999727235) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVPfPg.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - byCodiceFiscale (datagen::CustomFinder)
 *   - byDenominazione (datagen::CustomFinder)
 *   - byCodiceRea (datagen::CustomFinder)
 *   - byCodiceReaAndFiscale (datagen::CustomFinder)
 *   - byFilter (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitVPfPgDaoImpl extends AbstractDAO implements SigitVPfPgDao {
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

	protected SigitVPfPgDaoRowMapper findAllRowMapper = new SigitVPfPgDaoRowMapper(null, SigitVPfPgDto.class, this);

	protected SigitVPfPgDaoRowMapper byCodiceFiscaleRowMapper = new SigitVPfPgDaoRowMapper(null, SigitVPfPgDto.class,
			this);

	protected SigitVPfPgDaoRowMapper byDenominazioneRowMapper = new SigitVPfPgDaoRowMapper(null, SigitVPfPgDto.class,
			this);

	protected SigitVPfPgDaoRowMapper byCodiceReaRowMapper = new SigitVPfPgDaoRowMapper(null, SigitVPfPgDto.class, this);

	protected SigitVPfPgDaoRowMapper byCodiceReaAndFiscaleRowMapper = new SigitVPfPgDaoRowMapper(null,
			SigitVPfPgDto.class, this);

	protected SigitVPfPgDaoRowMapper byFilterRowMapper = new SigitVPfPgDaoRowMapper(null, SigitVPfPgDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_PF_PG";
	}

	/** 
	 * Restituisce tutte le righe della tabella VISTA_PF_PG.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findAll() throws SigitVPfPgDaoException {
		LOG.debug("[SigitVPfPgDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA,PF_PG,NOME,DENOMINAZIONE,SIGLA_REA,NUMERO_REA,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitVPfPgDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitVPfPgDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitVPfPgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVPfPgDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitVPfPgDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceFiscale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findByCodiceFiscale(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleAndDenomFilter input)
			throws SigitVPfPgDaoException {
		LOG.debug("[SigitVPfPgDaoImpl::findByCodiceFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA,PF_PG,NOME,DENOMINAZIONE,SIGLA_REA,NUMERO_REA,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO ");
		sql.append(" FROM VISTA_PF_PG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R54612734) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" UPPER(CODICE_FISCALE) = UPPER(:codFiscale)");
		sql.append(" AND PF_PG = :pfPg");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1721408764) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codFiscale", input.getCodiceFiscale());
		paramMap.addValue("pfPg", input.getIsImpresa() ? Constants.LABEL_PG : Constants.LABEL_PF);

		/*PROTECTED REGION END*/
		List<SigitVPfPgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceFiscaleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVPfPgDaoImpl::findByCodiceFiscale] esecuzione query", ex);
			throw new SigitVPfPgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVPfPgDaoImpl", "findByCodiceFiscale", "esecuzione query", sql.toString());
			LOG.debug("[SigitVPfPgDaoImpl::findByCodiceFiscale] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byDenominazione
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findByDenominazione(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleAndDenomFilter input)
			throws SigitVPfPgDaoException {
		LOG.debug("[SigitVPfPgDaoImpl::findByDenominazione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA,PF_PG,NOME,DENOMINAZIONE,SIGLA_REA,NUMERO_REA,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO ");
		sql.append(" FROM VISTA_PF_PG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1583474896) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" UPPER(DENOMINAZIONE) = UPPER(:denominazione)");
		sql.append(" AND PF_PG = :pfPg");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1571321998) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("denominazione", input.getDenominazione());
		paramMap.addValue("pfPg", input.getIsImpresa() ? Constants.LABEL_PG : Constants.LABEL_PF);

		/*PROTECTED REGION END*/
		List<SigitVPfPgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byDenominazioneRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVPfPgDaoImpl::findByDenominazione] esecuzione query", ex);
			throw new SigitVPfPgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVPfPgDaoImpl", "findByDenominazione", "esecuzione query", sql.toString());
			LOG.debug("[SigitVPfPgDaoImpl::findByDenominazione] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceRea
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findByCodiceRea(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleAndDenomFilter input)
			throws SigitVPfPgDaoException {
		LOG.debug("[SigitVPfPgDaoImpl::findByCodiceRea] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA,PF_PG,NOME,DENOMINAZIONE,SIGLA_REA,NUMERO_REA,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO ");
		sql.append(" FROM VISTA_PF_PG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R924666213) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" SIGLA_REA = :siglaRea");
		sql.append(" AND NUMERO_REA = :numeroRea");
		sql.append(" AND PF_PG = :pfPg");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-519554691) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("siglaRea", input.getSiglaRea());
		paramMap.addValue("numeroRea", input.getNumeroRea());
		paramMap.addValue("pfPg", input.getIsImpresa() ? Constants.LABEL_PG : Constants.LABEL_PF);

		/*PROTECTED REGION END*/
		List<SigitVPfPgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceReaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVPfPgDaoImpl::findByCodiceRea] esecuzione query", ex);
			throw new SigitVPfPgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVPfPgDaoImpl", "findByCodiceRea", "esecuzione query", sql.toString());
			LOG.debug("[SigitVPfPgDaoImpl::findByCodiceRea] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceReaAndFiscale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findByCodiceReaAndFiscale(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleAndDenomFilter input)
			throws SigitVPfPgDaoException {
		LOG.debug("[SigitVPfPgDaoImpl::findByCodiceReaAndFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA,PF_PG,NOME,DENOMINAZIONE,SIGLA_REA,NUMERO_REA,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO ");
		sql.append(" FROM VISTA_PF_PG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-774947499) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" SIGLA_REA = :siglaRea");
		sql.append(" AND NUMERO_REA = :numeroRea");
		sql.append(" AND CODICE_FISCALE = :codFiscale");
		sql.append(" AND PF_PG = :pfPg");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1667972211) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("siglaRea", input.getSiglaRea());
		paramMap.addValue("numeroRea", input.getNumeroRea());
		paramMap.addValue("pfPg", input.getIsImpresa() ? Constants.LABEL_PG : Constants.LABEL_PF);
		paramMap.addValue("codFiscale", input.getCodiceFiscale());

		/*PROTECTED REGION END*/
		List<SigitVPfPgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceReaAndFiscaleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVPfPgDaoImpl::findByCodiceReaAndFiscale] esecuzione query", ex);
			throw new SigitVPfPgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVPfPgDaoImpl", "findByCodiceReaAndFiscale", "esecuzione query", sql.toString());
			LOG.debug("[SigitVPfPgDaoImpl::findByCodiceReaAndFiscale] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleAndDenomFilter input)
			throws SigitVPfPgDaoException {
		LOG.debug("[SigitVPfPgDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA,PF_PG,NOME,DENOMINAZIONE,SIGLA_REA,NUMERO_REA,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO ");
		sql.append(" FROM VISTA_PF_PG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R619023082) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" PF_PG = :pfPg");

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaRea()))
			sql.append(" AND SIGLA_REA = :siglaRea");

		if (GenericUtil.isNotNullOrEmpty(input.getNumeroRea()))
			sql.append(" AND NUMERO_REA = :numeroRea");

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceFiscale()))
			sql.append(" AND UPPER(CODICE_FISCALE) = UPPER(:codFiscale)");

		if (GenericUtil.isNotNullOrEmpty(input.getDenominazione()))
			sql.append(" AND UPPER(DENOMINAZIONE) LIKE UPPER(:denominazione)");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1404557160) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("pfPg", input.getIsImpresa() ? Constants.LABEL_PG : Constants.LABEL_PF);

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaRea()))
			paramMap.addValue("siglaRea", input.getSiglaRea());

		if (GenericUtil.isNotNullOrEmpty(input.getNumeroRea()))
			paramMap.addValue("numeroRea", input.getNumeroRea());

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceFiscale()))
			paramMap.addValue("codFiscale", input.getCodiceFiscale());

		if (GenericUtil.isNotNullOrEmpty(input.getDenominazione()))
			paramMap.addValue("denominazione", "%" + input.getDenominazione() + "%");

		/*PROTECTED REGION END*/
		List<SigitVPfPgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVPfPgDaoImpl::findByFilter] esecuzione query", ex);
			throw new SigitVPfPgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVPfPgDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitVPfPgDaoImpl::findByFilter] END");
		}
		return list;
	}

}
