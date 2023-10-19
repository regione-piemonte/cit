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

/*PROTECTED REGION ID(R-820089169) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRComp4ManutAll.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - byComp (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *   - byIdAllegato (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRComp4ManutAllDaoImpl extends AbstractDAO implements SigitRComp4ManutAllDao {
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
	 * Metodo di inserimento del DAO sigitRComp4ManutAll. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRComp4ManutAllPk
	 * @generated
	 */

	public SigitRComp4ManutAllPk insert(SigitRComp4ManutAllDto dto)

	{
		LOG.debug("[SigitRComp4ManutAllDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ALLEGATO,ID_R_COMP4_MANUT ) VALUES (  :ID_ALLEGATO , :ID_R_COMP4_MANUT  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_R_COMP4_MANUT]
		params.addValue("ID_R_COMP4_MANUT", dto.getIdRComp4Manut(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitRComp4ManutAllDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the SIGIT_R_COMP4MANUT_ALL table.
	 * @generated
	 */

	public void delete(SigitRComp4ManutAllPk pk) throws SigitRComp4ManutAllDaoException {
		LOG.debug("[SigitRComp4ManutAllDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_ALLEGATO = :ID_ALLEGATO  AND ID_R_COMP4_MANUT = :ID_R_COMP4_MANUT ";

		if (pk == null) {
			LOG.error("[SigitRComp4ManutAllDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitRComp4ManutAllDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_R_COMP4_MANUT]
		params.addValue("ID_R_COMP4_MANUT", pk.getIdRComp4Manut(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRComp4ManutAllDaoImpl::delete] END");
	}

	/** 
	 * Custom deleter in the SIGIT_R_COMP4MANUT_ALL table.
	 * @generated
	 */
	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitRComp4ManutAllDaoException {
		LOG.debug("[SigitRComp4ManutAllDaoImpl::customDeleterByIdAllegato] START");
		/*PROTECTED REGION ID(R1550067490) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ALLEGATO = :idAllegato";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idAllegato", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRComp4ManutAllDaoImpl::customDeleterByIdAllegato] END");
	}

	protected SigitRComp4ManutAllDaoRowMapper byCompRowMapper = new SigitRComp4ManutAllDaoRowMapper(null,
			SigitRComp4ManutAllDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_COMP4MANUT_ALL";
	}

	/** 
	 * Implementazione del finder byComp
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRComp4ManutAllDto> findByComp(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitRComp4ManutAllDaoException {
		LOG.debug("[SigitRComp4ManutAllDaoImpl::findByComp] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R1313040695) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append("SELECT manutAll.ID_ALLEGATO, manutAll.ID_R_COMP4_MANUT ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R178249097) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_R_COMP4MANUT_ALL as manutAll, SIGIT_R_COMP4_MANUT as manut");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1013390481) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("manutAll.ID_R_COMP4_MANUT = manut.ID_R_COMP4_MANUT ");

		sql.append("AND manut.CODICE_IMPIANTO = :codiceImpianto ");

		sql.append("AND manut.ID_TIPO_COMPONENTE = :idTipoComponente ");

		sql.append("AND manut.PROGRESSIVO = :progressivo ");

		sql.append("ORDER BY manutAll.ID_ALLEGATO DESC");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-2064069679) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codiceImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);

		paramMap.addValue("idTipoComponente", input.getTipoComponente(), java.sql.Types.VARCHAR);

		paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitRComp4ManutAllDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCompRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRComp4ManutAllDaoImpl::findByComp] esecuzione query", ex);
			throw new SigitRComp4ManutAllDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRComp4ManutAllDaoImpl", "findByComp", "esecuzione query", sql.toString());
			LOG.debug("[SigitRComp4ManutAllDaoImpl::findByComp] END");
		}
		return list;
	}

}
