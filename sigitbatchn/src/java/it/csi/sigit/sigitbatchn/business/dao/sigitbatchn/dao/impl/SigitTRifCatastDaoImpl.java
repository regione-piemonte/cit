package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.impl;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.mapper.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import it.csi.sigit.sigitbatchn.business.dao.impl.*;
import it.csi.sigit.sigitbatchn.business.dao.util.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R-1637913105) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTRifCatast.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - allByIdStatoImportDistrib (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTRifCatastDaoImpl extends AbstractDAO implements SigitTRifCatastDao {
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
	 * Metodo di inserimento del DAO sigitTRifCatast. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTRifCatastPk
	 * @generated
	 */

	public SigitTRifCatastPk insert(SigitTRifCatastDto dto)

	{
		LOG.debug("[SigitTRifCatastDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_RIF_CATAST,FK_DATO_DISTRIB,SEZIONE,FOGLIO,PARTICELLA,SUBALTERNO ) VALUES (  :ID_RIF_CATAST , :FK_DATO_DISTRIB , :SEZIONE , :FOGLIO , :PARTICELLA , :SUBALTERNO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RIF_CATAST]
		params.addValue("ID_RIF_CATAST", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_DATO_DISTRIB]
		params.addValue("FK_DATO_DISTRIB", dto.getFkDatoDistrib(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [SEZIONE]
		params.addValue("SEZIONE", dto.getSezione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FOGLIO]
		params.addValue("FOGLIO", dto.getFoglio(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PARTICELLA]
		params.addValue("PARTICELLA", dto.getParticella(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SUBALTERNO]
		params.addValue("SUBALTERNO", dto.getSubalterno(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdRifCatast(newKey);
		LOG.debug("[SigitTRifCatastDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the SIGIT_T_RIF_CATAST table.
	 * @generated
	 */

	public void delete(SigitTRifCatastPk pk) throws SigitTRifCatastDaoException {
		LOG.debug("[SigitTRifCatastDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_RIF_CATAST = :ID_RIF_CATAST ";

		if (pk == null) {
			LOG.error("[SigitTRifCatastDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTRifCatastDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RIF_CATAST]
		params.addValue("ID_RIF_CATAST", pk.getIdRifCatast(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTRifCatastDaoImpl::delete] END");
	}

	protected SigitTRifCatastDaoRowMapper allByIdStatoImportDistribRowMapper = new SigitTRifCatastDaoRowMapper(null,
			SigitTRifCatastAllByIdStatoImportDistribDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_RIF_CATAST";
	}

	/** 
		 * Implementazione del finder allByIdStatoImportDistrib con Qdef
		 * @generated
		 */

	public List<SigitTRifCatastAllByIdStatoImportDistribDto> findAllByIdStatoImportDistrib(java.lang.Integer[] input)
			throws SigitTRifCatastDaoException {
		LOG.debug("[SigitTRifCatastDaoImpl::findAllByIdStatoImportDistrib] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT rc.ID_RIF_CATAST");

		sql.append(" FROM SIGIT_T_IMPORT_DISTRIB id, SIGIT_T_DATO_DISTRIB dd, SIGIT_T_RIF_CATAST rc");

		sql.append(" WHERE ");

		sql.append("id.ID_IMPORT_DISTRIB = dd.FK_IMPORT_DISTRIB AND dd.ID_DATO_DISTRIB = rc.FK_DATO_DISTRIB");

		sql.append(" AND ");

		sql.append(
				"NOT EXISTS (select stv.FK_DATO_DiSTRIB from SIGIT_T_VERIFICA stv where stv.FK_DATO_DISTRIB = rc.FK_DATO_DISTRIB) AND id.FK_STATO_DISTRIB IN (");
		/*PROTECTED REGION ID(R-804487069) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		for (int i = 0; i < input.length; i++) {
			if (i != 0) {
				sql.append(",");
			}

			sql.append(input[i]);
		}
		sql.append(")");

		/*PROTECTED REGION END*/

		List<SigitTRifCatastAllByIdStatoImportDistribDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, allByIdStatoImportDistribRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTRifCatastDaoImpl::findAllByIdStatoImportDistrib] ERROR esecuzione query", ex);
			throw new SigitTRifCatastDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTRifCatastDaoImpl", "findAllByIdStatoImportDistrib", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTRifCatastDaoImpl::findAllByIdStatoImportDistrib] END");
		}
		return list;
	}

}
