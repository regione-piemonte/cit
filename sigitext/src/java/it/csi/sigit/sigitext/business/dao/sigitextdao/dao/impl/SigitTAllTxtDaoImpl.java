package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;


import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTAllTxtDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTAllTxtDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllTxtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllTxtPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTAllTxtDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R-150179837) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTAllTxt.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:\
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTAllTxtDaoImpl extends AbstractDAO implements SigitTAllTxtDao {
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
	 * Metodo di inserimento del DAO sigitTAllTxt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAllTxtPk
	 * @generated
	 */

	public SigitTAllTxtPk insert(SigitTAllTxtDto dto)

	{
		LOG.debug("[SigitTAllTxtDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ALLEGATO,XML_ALLEGATO ) VALUES (  :ID_ALLEGATO , :XML_ALLEGATO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [XML_ALLEGATO]
		params.addValue("XML_ALLEGATO", dto.getXmlAllegato(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTAllTxtDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_ALL_TXT table.
	 * @generated
	 */
	public void update(SigitTAllTxtDto dto) throws SigitTAllTxtDaoException {
		LOG.debug("[SigitTAllTxtDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET XML_ALLEGATO = :XML_ALLEGATO  WHERE ID_ALLEGATO = :ID_ALLEGATO ";

		if (dto.getIdAllegato() == null) {
			LOG.error("[SigitTAllTxtDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTAllTxtDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [XML_ALLEGATO]
		params.addValue("XML_ALLEGATO", dto.getXmlAllegato(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAllTxtDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_ALL_TXT table.
	 * @generated
	 */

	public void delete(SigitTAllTxtPk pk) throws SigitTAllTxtDaoException {
		LOG.debug("[SigitTAllTxtDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ALLEGATO = :ID_ALLEGATO ";

		if (pk == null) {
			LOG.error("[SigitTAllTxtDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTAllTxtDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAllTxtDaoImpl::delete] END");
	}

	protected SigitTAllTxtDaoRowMapper findByPrimaryKeyRowMapper = new SigitTAllTxtDaoRowMapper(null,
			SigitTAllTxtDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_ALL_TXT";
	}

	/** 
	 * Returns all rows from the SIGIT_T_ALL_TXT table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTAllTxtDto findByPrimaryKey(SigitTAllTxtPk pk) throws SigitTAllTxtDaoException {
		LOG.debug("[SigitTAllTxtDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALLEGATO,XML_ALLEGATO FROM " + getTableName() + " WHERE ID_ALLEGATO = :ID_ALLEGATO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.NUMERIC);

		List<SigitTAllTxtDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTAllTxtDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTAllTxtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAllTxtDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTAllTxtDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
