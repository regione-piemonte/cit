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

/*PROTECTED REGION ID(R-158548945) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTIspezione2018.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byCodiceFiscale (datagen::CustomFinder)
 *   - byUtentiNonAttivi (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTIspezione2018DaoImpl extends AbstractDAO implements SigitTIspezione2018Dao {
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

	protected SigitTIspezione2018DaoRowMapper byCodiceFiscaleRowMapper = new SigitTIspezione2018DaoRowMapper(null,
			SigitTIspezione2018ByCodiceFiscaleDto.class, this);

	protected SigitTIspezione2018DaoRowMapper byUtentiNonAttiviRowMapper = new SigitTIspezione2018DaoRowMapper(null,
			SigitTIspezione2018ByUtentiNonAttiviDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_ISPEZIONE_2018";
	}

	/** 
		 * Implementazione del finder byCodiceFiscale con Qdef
		 * @generated
		 */

	public List<SigitTIspezione2018ByCodiceFiscaleDto> findByCodiceFiscale(java.lang.String input)
			throws SigitTIspezione2018DaoException {
		LOG.debug("[SigitTIspezione2018DaoImpl::findByCodiceFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT is_2018.ID_ISPEZIONE_2018, is_2018.DT_SVEGLIA, is_2018.NOTE_SVEGLIA");

		sql.append(" FROM SIGIT_T_ISPEZIONE_2018 is_2018, VISTA_RICERCA_ISPEZIONI ric_isp");

		sql.append(" WHERE ");

		sql.append("ric_isp.ID_ISPEZIONE_2018 = is_2018.ID_ISPEZIONE_2018");

		sql.append(" AND ");

		sql.append(
				"ric_isp.codice_fiscale = :codice_fiscale AND is_2018.dt_sveglia <= NOW() AND is_2018.fk_stato_ispezione = 1");
		/*PROTECTED REGION ID(R1272533372) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("codice_fiscale", input);

		/*PROTECTED REGION END*/

		List<SigitTIspezione2018ByCodiceFiscaleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceFiscaleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTIspezione2018DaoImpl::findByCodiceFiscale] ERROR esecuzione query", ex);
			throw new SigitTIspezione2018DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTIspezione2018DaoImpl", "findByCodiceFiscale", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTIspezione2018DaoImpl::findByCodiceFiscale] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byUtentiNonAttivi con Qdef
		 * @generated
		 */

	public List<SigitTIspezione2018ByUtentiNonAttiviDto> findByUtentiNonAttivi(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTIspezione2018Dto input)
			throws SigitTIspezione2018DaoException {
		LOG.debug("[SigitTIspezione2018DaoImpl::findByUtentiNonAttivi] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT T.ID_ISPEZIONE_2018, V.NOME, V.COGNOME, V.CODICE_FISCALE, T.DT_SVEGLIA, T.NOTE_SVEGLIA, A.ID_RUOLO_PA, A.ISTAT_ABILITAZIONE, A.MAIL_COMUNICAZIONE");

		sql.append(
				" FROM SIGIT_R_PF_RUOLO_PA R, SIGIT_T_PERSONA_FISICA P, SIGIT_T_ISPEZIONE_2018 T, SIGIT_T_ABILITAZIONE A, VISTA_RICERCA_ISPEZIONI V");

		sql.append(" WHERE ");

		sql.append(
				"R.ID_PERSONA_FISICA = P.ID_PERSONA_FISICA AND V.ID_ISPEZIONE_2018 = T.ID_ISPEZIONE_2018 AND P.CODICE_FISCALE = V.CODICE_FISCALE AND R.ID_RUOLO_PA = A.ID_RUOLO_PA AND R.ISTAT_ABILITAZIONE = A.ISTAT_ABILITAZIONE");

		sql.append(" AND ");

		sql.append(
				"A.id_ruolo_pa = 2 AND R.data_fine is not null AND T.dt_sveglia <= NOW() AND T.fk_stato_ispezione = 1");
		/*PROTECTED REGION ID(R-747388315) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:
		sql.append(" ORDER BY  A.ID_RUOLO_PA ASC, A.ISTAT_ABILITAZIONE ASC, A.MAIL_COMUNICAZIONE ASC");
		//paramMap.addValue("param", input);

		/*PROTECTED REGION END*/

		List<SigitTIspezione2018ByUtentiNonAttiviDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byUtentiNonAttiviRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTIspezione2018DaoImpl::findByUtentiNonAttivi] ERROR esecuzione query", ex);
			throw new SigitTIspezione2018DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTIspezione2018DaoImpl", "findByUtentiNonAttivi", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTIspezione2018DaoImpl::findByUtentiNonAttivi] END");
		}
		return list;
	}

}
