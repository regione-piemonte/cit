package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitVCompCiDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitVCompCiDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVCompCiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitVCompCiDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R158646919) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVCompCi.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byCodImpiantoOrdered (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitVCompCiDaoImpl extends AbstractDAO implements SigitVCompCiDao {
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

	protected SigitVCompCiDaoRowMapper byCodImpiantoOrderedRowMapper = new SigitVCompCiDaoRowMapper(null,
			SigitVCompCiDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_COMP_CI";
	}

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompCiDto> findByCodImpiantoOrdered(
			it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter input)
			throws SigitVCompCiDaoException {
		LOG.debug("[SigitVCompCiDaoImpl::findByCodImpiantoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,DATA_INSTALL,PROGRESSIVO,DATA_DISMISS,MATRICOLA,FK_MARCA,DES_MARCA,MODELLO,LUNGHEZZA_CIRC_M,SUPERF_SCAMB_M2,PROF_INSTALL_M,FLG_DISMISSIONE ");
		sql.append(" FROM VISTA_COMP_CI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R829231500) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("CODICE_IMPIANTO = :codImpianto");

		if (input.getProgressivo() != null) {
			sql.append(" AND PROGRESSIVO = :progressivo");
		}

		sql.append(" ORDER BY PROGRESSIVO ASC, DATA_INSTALL DESC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R61258974) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);

		if (input.getProgressivo() != null) {
			paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);
		}

		/*PROTECTED REGION END*/
		List<SigitVCompCiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpiantoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVCompCiDaoImpl::findByCodImpiantoOrdered] esecuzione query", ex);
			throw new SigitVCompCiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVCompCiDaoImpl", "findByCodImpiantoOrdered", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVCompCiDaoImpl::findByCodImpiantoOrdered] END");
		}
		return list;
	}

}
