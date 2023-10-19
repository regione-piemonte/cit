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

/*PROTECTED REGION ID(R-1439719735) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRComp4Manut.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byPersonaGiuridicaCodImpianto (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRComp4ManutDaoImpl extends AbstractDAO implements SigitRComp4ManutDao {
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

	protected SigitRComp4ManutDaoRowMapper byPersonaGiuridicaCodImpiantoRowMapper = new SigitRComp4ManutDaoRowMapper(
			null, SigitRComp4ManutDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_COMP4_MANUT";
	}

	/** 
	 * Implementazione del finder byPersonaGiuridicaCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRComp4ManutDto> findByPersonaGiuridicaCodImpianto(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter.CompFilter input)
			throws SigitRComp4ManutDaoException {
		LOG.debug("[SigitRComp4ManutDaoImpl::findByPersonaGiuridicaCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_R_COMP4_MANUT,FK_PERSONA_GIURIDICA,CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INIZIO,DATA_FINE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_RUOLO ");
		sql.append(" FROM SIGIT_R_COMP4_MANUT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1981733715) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("  DATA_FINE IS NULL");
		if (input.getIdPersonaGiuridica() != null)
			sql.append(" AND FK_PERSONA_GIURIDICA = :idPersonaGiuridica");
		if (input.getCodImpianto() != null)
			sql.append(" AND CODICE_IMPIANTO = :codiceImpianto");
		if (input.getIdRuolo() != null)
			sql.append(" AND FK_RUOLO = :idRuolo");

		if (input.getListProgressivi() != null && !input.getListProgressivi().isEmpty()) {
			sql.append(" AND PROGRESSIVO IN  (");
			boolean aggVirg = false;
			for (String progr : input.getListProgressivi()) {
				if (aggVirg)
					sql.append(", ");
				sql.append(progr);
				aggVirg = true;
			}
			sql.append(") ");
		}
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1429089271) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input.getIdPersonaGiuridica() != null)
			paramMap.addValue("idPersonaGiuridica", input.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);
		if (input.getCodImpianto() != null)
			paramMap.addValue("codiceImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		if (input.getIdRuolo() != null)
			paramMap.addValue("idRuolo", input.getIdRuolo(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitRComp4ManutDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byPersonaGiuridicaCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRComp4ManutDaoImpl::findByPersonaGiuridicaCodImpianto] esecuzione query", ex);
			throw new SigitRComp4ManutDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRComp4ManutDaoImpl", "findByPersonaGiuridicaCodImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRComp4ManutDaoImpl::findByPersonaGiuridicaCodImpianto] END");
		}
		return list;
	}

}
