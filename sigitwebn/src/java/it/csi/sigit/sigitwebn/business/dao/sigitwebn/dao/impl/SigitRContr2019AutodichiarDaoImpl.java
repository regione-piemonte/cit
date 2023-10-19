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

/*PROTECTED REGION ID(R-1667160169) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRContr2019Autodichiar.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byExample (datagen::CustomFinder)
 *   - byExampleExtended (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRContr2019AutodichiarDaoImpl extends AbstractDAO implements SigitRContr2019AutodichiarDao {
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
	 * Metodo di inserimento del DAO sigitRContr2019Autodichiar. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRContr2019AutodichiarPk
	 * @generated
	 */

	public SigitRContr2019AutodichiarPk insert(SigitRContr2019AutodichiarDto dto)

	{
		LOG.debug("[SigitRContr2019AutodichiarDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_CONTRATTO,ID_AUTODICHIARAZIONE,FLG_NOMINA_CESSA ) VALUES (  :ID_CONTRATTO , :ID_AUTODICHIARAZIONE , :FLG_NOMINA_CESSA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONTRATTO]
		params.addValue("ID_CONTRATTO", dto.getIdContratto(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AUTODICHIARAZIONE]
		params.addValue("ID_AUTODICHIARAZIONE", dto.getIdAutodichiarazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_NOMINA_CESSA]
		params.addValue("FLG_NOMINA_CESSA", dto.getFlgNominaCessa(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitRContr2019AutodichiarDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_R_CONTR2019_AUTODICHIAR table.
	 * @generated
	 */
	public void update(SigitRContr2019AutodichiarDto dto) throws SigitRContr2019AutodichiarDaoException {
		LOG.debug("[SigitRContr2019AutodichiarDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET  WHERE ID_CONTRATTO = :ID_CONTRATTO  AND ID_AUTODICHIARAZIONE = :ID_AUTODICHIARAZIONE  AND FLG_NOMINA_CESSA = :FLG_NOMINA_CESSA ";

		if (dto.getIdContratto() == null || dto.getIdAutodichiarazione() == null || dto.getFlgNominaCessa() == null) {
			LOG.error("[SigitRContr2019AutodichiarDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitRContr2019AutodichiarDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONTRATTO]
		params.addValue("ID_CONTRATTO", dto.getIdContratto(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AUTODICHIARAZIONE]
		params.addValue("ID_AUTODICHIARAZIONE", dto.getIdAutodichiarazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_NOMINA_CESSA]
		params.addValue("FLG_NOMINA_CESSA", dto.getFlgNominaCessa(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRContr2019AutodichiarDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_R_CONTR2019_AUTODICHIAR table.
	 * @generated
	 */

	public void delete(SigitRContr2019AutodichiarPk pk) throws SigitRContr2019AutodichiarDaoException {
		LOG.debug("[SigitRContr2019AutodichiarDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_CONTRATTO = :ID_CONTRATTO  AND ID_AUTODICHIARAZIONE = :ID_AUTODICHIARAZIONE  AND FLG_NOMINA_CESSA = :FLG_NOMINA_CESSA ";

		if (pk == null) {
			LOG.error("[SigitRContr2019AutodichiarDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitRContr2019AutodichiarDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONTRATTO]
		params.addValue("ID_CONTRATTO", pk.getIdContratto(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AUTODICHIARAZIONE]
		params.addValue("ID_AUTODICHIARAZIONE", pk.getIdAutodichiarazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_NOMINA_CESSA]
		params.addValue("FLG_NOMINA_CESSA", pk.getFlgNominaCessa(), java.sql.Types.VARCHAR);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRContr2019AutodichiarDaoImpl::delete] END");
	}

	protected SigitRContr2019AutodichiarDaoRowMapper findByPrimaryKeyRowMapper = new SigitRContr2019AutodichiarDaoRowMapper(
			null, SigitRContr2019AutodichiarDto.class, this);

	protected SigitRContr2019AutodichiarDaoRowMapper byExampleRowMapper = new SigitRContr2019AutodichiarDaoRowMapper(
			null, SigitRContr2019AutodichiarDto.class, this);

	protected SigitRContr2019AutodichiarDaoRowMapper byExampleExtendedRowMapper = new SigitRContr2019AutodichiarDaoRowMapper(
			null, SigitRContr2019AutodichiarByExampleExtendedDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_CONTR2019_AUTODICHIAR";
	}

	/** 
	 * Returns all rows from the SIGIT_R_CONTR2019_AUTODICHIAR table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRContr2019AutodichiarDto findByPrimaryKey(SigitRContr2019AutodichiarPk pk)
			throws SigitRContr2019AutodichiarDaoException {
		LOG.debug("[SigitRContr2019AutodichiarDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_CONTRATTO,ID_AUTODICHIARAZIONE,FLG_NOMINA_CESSA FROM "
				+ getTableName()
				+ " WHERE ID_CONTRATTO = :ID_CONTRATTO  AND ID_AUTODICHIARAZIONE = :ID_AUTODICHIARAZIONE  AND FLG_NOMINA_CESSA = :FLG_NOMINA_CESSA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONTRATTO]
		params.addValue("ID_CONTRATTO", pk.getIdContratto(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AUTODICHIARAZIONE]
		params.addValue("ID_AUTODICHIARAZIONE", pk.getIdAutodichiarazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_NOMINA_CESSA]
		params.addValue("FLG_NOMINA_CESSA", pk.getFlgNominaCessa(), java.sql.Types.VARCHAR);

		List<SigitRContr2019AutodichiarDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRContr2019AutodichiarDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitRContr2019AutodichiarDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRContr2019AutodichiarDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRContr2019AutodichiarDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRContr2019AutodichiarDto> findByExample(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRContr2019AutodichiarDto input)
			throws SigitRContr2019AutodichiarDaoException {
		LOG.debug("[SigitRContr2019AutodichiarDaoImpl::findByExample] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_CONTRATTO,ID_AUTODICHIARAZIONE,FLG_NOMINA_CESSA ");
		sql.append(" FROM SIGIT_R_CONTR2019_AUTODICHIAR");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R966291786) ENABLED START*/

		sql.append(" 1 = 1 ");

		if (!GenericUtil.isNullOrEmpty(input.getFlgNominaCessa())) {
			sql.append(" AND FLG_NOMINA_CESSA = :flgNominaCessa");
		}

		if (input.getIdAutodichiarazione() != null) {
			sql.append(" AND ID_AUTODICHIARAZIONE = :idAutodichiarazione");
		}

		if (input.getIdContratto() != null) {
			sql.append(" AND ID_CONTRATTO = :idContratto");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R770838072) ENABLED START*/
		//***aggiungere tutte le condizioni
		if (!GenericUtil.isNullOrEmpty(input.getFlgNominaCessa())) {
			paramMap.addValue("flgNominaCessa", input.getFlgNominaCessa());
		}

		if (input.getIdAutodichiarazione() != null) {
			paramMap.addValue("idAutodichiarazione", input.getIdAutodichiarazione());
		}

		if (input.getIdContratto() != null) {
			paramMap.addValue("idContratto", input.getIdContratto());
		}

		/*PROTECTED REGION END*/
		List<SigitRContr2019AutodichiarDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byExampleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRContr2019AutodichiarDaoImpl::findByExample] esecuzione query", ex);
			throw new SigitRContr2019AutodichiarDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRContr2019AutodichiarDaoImpl", "findByExample", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRContr2019AutodichiarDaoImpl::findByExample] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byExampleExtended con Qdef
		 * @generated
		 */

	public List<SigitRContr2019AutodichiarByExampleExtendedDto> findByExampleExtended(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRContr2019AutodichiarDto input)
			throws SigitRContr2019AutodichiarDaoException {
		LOG.debug("[SigitRContr2019AutodichiarDaoImpl::findByExampleExtended] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT autod.DES_AUTODICHIARAZIONE as desAutodichiarazione, autod.ID_AUTODICHIARAZIONE as idAutodichiarazione");

		sql.append(" FROM SIGIT_R_CONTR2019_AUTODICHIAR contr_aut, SIGIT_D_AUTODICHIARAZIONE autod");

		sql.append(" WHERE ");

		sql.append("contr_aut.ID_AUTODICHIARAZIONE = autod.ID_AUTODICHIARAZIONE");

		sql.append(" AND ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R-1980234347) ENABLED START*/

		//paramMap.addValue("param", input);
		if (!GenericUtil.isNullOrEmpty(input.getFlgNominaCessa())) {
			sql.append(" AND contr_aut.FLG_NOMINA_CESSA = :flgNominaCessa");
			paramMap.addValue("flgNominaCessa", input.getFlgNominaCessa());
		}

		if (input.getIdAutodichiarazione() != null) {
			sql.append(" AND contr_aut.ID_AUTODICHIARAZIONE = :idAutodichiarazione");
			paramMap.addValue("idAutodichiarazione", input.getIdAutodichiarazione());
		}

		if (input.getIdContratto() != null) {
			sql.append(" AND contr_aut.ID_CONTRATTO = :idContratto");
			paramMap.addValue("idContratto", input.getIdContratto());
		}

		/*PROTECTED REGION END*/

		List<SigitRContr2019AutodichiarByExampleExtendedDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byExampleExtendedRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRContr2019AutodichiarDaoImpl::findByExampleExtended] ERROR esecuzione query", ex);
			throw new SigitRContr2019AutodichiarDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRContr2019AutodichiarDaoImpl", "findByExampleExtended", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRContr2019AutodichiarDaoImpl::findByExampleExtended] END");
		}
		return list;
	}

}
