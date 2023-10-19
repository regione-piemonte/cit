package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitRComp4ManutAllDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitRComp4ManutAllDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRComp4ManutAllDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRComp4ManutAllPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRComp4ManutAllDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R1580411299) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRComp4ManutAll.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER:
 * - (insert di default)
 * - FINDERS:
 * <p>
 * --
 * - UPDATERS:
 * <p>
 * --
 * - DELETERS:
 * <p>
 * --
 * <p>
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 *
 * @generated
 */
public class SigitRComp4ManutAllDaoImpl extends AbstractDAO implements SigitRComp4ManutAllDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	/**
	 * Il DAO utilizza JDBC template per l'implementazione delle query.
	 *
	 * @generated
	 */
	protected NamedParameterJdbcTemplate jdbcTemplate;

	protected SigitRComp4ManutAllDaoRowMapper byCompRowMapper = new SigitRComp4ManutAllDaoRowMapper(null, SigitRComp4ManutAllDto.class, this);

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 *
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

	public SigitRComp4ManutAllPk insert(SigitRComp4ManutAllDto dto) {
		LOG.debug("[SigitRComp4ManutAllDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName() + " ( 	ID_ALLEGATO,ID_R_COMP4_MANUT ) VALUES (  :ID_ALLEGATO , :ID_R_COMP4_MANUT  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_R_COMP4_MANUT]
		params.addValue("ID_R_COMP4_MANUT", dto.getIdRComp4Manut(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitRComp4ManutAllDaoImpl::insert] END");
		return dto.createPk();

	}

	public List<SigitRComp4ManutAllDto> findByComp(CompFilter input) throws SigitRComp4ManutAllDaoException {
		LOG.debug("[SigitRComp4ManutAllDaoImpl::findByComp] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		sql.append("SELECT manutAll.ID_ALLEGATO, manutAll.ID_R_COMP4_MANUT ");
		sql.append(" FROM SIGIT_R_COMP4MANUT_ALL as manutAll, SIGIT_R_COMP4_MANUT as manut");
		sql.append(" WHERE ");
		sql.append("manutAll.ID_R_COMP4_MANUT = manut.ID_R_COMP4_MANUT ");

		sql.append("AND manut.CODICE_IMPIANTO = :codiceImpianto ");

		sql.append("AND manut.ID_TIPO_COMPONENTE = :idTipoComponente ");

		sql.append("AND manut.PROGRESSIVO = :progressivo ");

		sql.append("ORDER BY manutAll.ID_ALLEGATO DESC");

		paramMap.addValue("codiceImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);

		paramMap.addValue("idTipoComponente", input.getTipoComponente(), java.sql.Types.VARCHAR);

		paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);

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

	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitRComp4ManutAllDaoException {
		LOG.debug("[SigitRComp4ManutAllDaoImpl::customDeleterByIdAllegato] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ALLEGATO = :idAllegato";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idAllegato", filter);
		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRComp4ManutAllDaoImpl::customDeleterByIdAllegato] END");
	}

	public String getTableName() {
		return "SIGIT_R_COMP4MANUT_ALL";
	}

}
