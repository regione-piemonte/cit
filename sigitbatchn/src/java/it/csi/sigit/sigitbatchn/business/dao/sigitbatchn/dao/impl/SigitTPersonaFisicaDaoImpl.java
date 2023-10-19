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

/*PROTECTED REGION ID(R985341935) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTPersonaFisica.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - emailPfImport (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTPersonaFisicaDaoImpl extends AbstractDAO implements SigitTPersonaFisicaDao {
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

	protected SigitTPersonaFisicaDaoRowMapper findByPrimaryKeyRowMapper = new SigitTPersonaFisicaDaoRowMapper(null,
			SigitTPersonaFisicaDto.class, this);

	protected SigitTPersonaFisicaDaoRowMapper emailPfImportRowMapper = new SigitTPersonaFisicaDaoRowMapper(null,
			SigitTPersonaFisicaEmailPfImportDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_PERSONA_FISICA";
	}

	/** 
	 * Returns all rows from the SIGIT_T_PERSONA_FISICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTPersonaFisicaDto findByPrimaryKey(SigitTPersonaFisicaPk pk) throws SigitTPersonaFisicaDaoException {
		LOG.debug("[SigitTPersonaFisicaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA_FISICA,NOME,COGNOME,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,ISTAT_COMUNE,SIGLA_PROV,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,FLG_ACCREDITATO,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FLG_NEWSLETTER,FLG_GDPR FROM "
						+ getTableName() + " WHERE ID_PERSONA_FISICA = :ID_PERSONA_FISICA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", pk.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		List<SigitTPersonaFisicaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaFisicaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTPersonaFisicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaFisicaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaFisicaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
		 * Implementazione del finder emailPfImport con Qdef
		 * @generated
		 */

	public List<SigitTPersonaFisicaEmailPfImportDto> findEmailPfImport(java.lang.Integer input)
			throws SigitTPersonaFisicaDaoException {
		LOG.debug("[SigitTPersonaFisicaDaoImpl::findEmailPfImport] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT pf.EMAIL");

		sql.append(" FROM SIGIT_T_IMPORT imp, SIGIT_T_PRE_IMPORT preImp, SIGIT_T_PERSONA_FISICA pf");

		sql.append(" WHERE ");

		sql.append("imp.FK_PRE_IMPORT = preImp.ID_PRE_IMPORT AND preImp.ID_PERSONA_FISICA = pf.ID_PERSONA_FISICA");

		sql.append(" AND ");

		sql.append("imp.ID_IMPORT =:idImport");
		/*PROTECTED REGION ID(R-506953284) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idImport", input);

		/*PROTECTED REGION END*/

		List<SigitTPersonaFisicaEmailPfImportDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, emailPfImportRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaFisicaDaoImpl::findEmailPfImport] ERROR esecuzione query", ex);
			throw new SigitTPersonaFisicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaFisicaDaoImpl", "findEmailPfImport", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTPersonaFisicaDaoImpl::findEmailPfImport] END");
		}
		return list;
	}

}
