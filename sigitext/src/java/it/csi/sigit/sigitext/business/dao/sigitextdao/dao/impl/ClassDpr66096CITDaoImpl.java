package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.ClassDpr66096CITDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.CombustibileCITDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.ClassDpr66096CITDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.CombustibileCITDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.ClassDpr66096CITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.ClassDpr66096CITPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.CombustibileCITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.CombustibileCITPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.ClassDpr66096CITDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.CombustibileCITDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R1179506403) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO CombustibileCIT.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class ClassDpr66096CITDaoImpl extends AbstractDAO implements ClassDpr66096CITDao {
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

	protected ClassDpr66096CITDaoRowMapper findAllRowMapper = new ClassDpr66096CITDaoRowMapper(
			new String[]{"ID_CLASS", "DES_CLASS"}, ClassDpr66096CITDto.class, this);

	protected ClassDpr66096CITDaoRowMapper findByPrimaryKeyRowMapper = new ClassDpr66096CITDaoRowMapper(null,
			ClassDpr66096CITDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_CLASS_DPR660_96";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_COMBUSTIBILE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<ClassDpr66096CITDto> findAll() throws ClassDpr66096CITDaoException {
		LOG.debug("[ClassDpr66096CITDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT DISTINCT ID_CLASS,DES_CLASS FROM " + getTableName());

		sql.append(" ORDER BY ID_CLASS ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<ClassDpr66096CITDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[ClassDpr66096CITDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new ClassDpr66096CITDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("ClassDpr66096CITDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[ClassDpr66096CITDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_D_COMBUSTIBILE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public ClassDpr66096CITDto findByPrimaryKey(ClassDpr66096CITPk pk) throws ClassDpr66096CITDaoException {
		LOG.debug("[ClassDpr66096CITDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_CLASS,DES_CLASS FROM " + getTableName()
				+ " WHERE ID_CLASS = :ID_CLASS ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_COMBUSTIBILE]
		params.addValue("ID_CLASS", pk.getIdClass(), java.sql.Types.NUMERIC);

		List<ClassDpr66096CITDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[ClassDpr66096CITDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new ClassDpr66096CITDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("ClassDpr66096CITDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[ClassDpr66096CITDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
