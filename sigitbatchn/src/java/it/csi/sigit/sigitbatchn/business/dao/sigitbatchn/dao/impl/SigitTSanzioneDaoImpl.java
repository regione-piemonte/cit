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

/*PROTECTED REGION ID(R1235677459) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTSanzione.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byCodiceFiscale (datagen::CustomFinder)
 *   - accertamentiByUtentiNonAttivi (datagen::CustomFinder)
 *   - ispezione2018ByUtentiNonAttivi (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTSanzioneDaoImpl extends AbstractDAO implements SigitTSanzioneDao {
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

	protected SigitTSanzioneDaoRowMapper byCodiceFiscaleRowMapper = new SigitTSanzioneDaoRowMapper(null,
			SigitTSanzioneDto.class, this);

	protected SigitTSanzioneDaoRowMapper accertamentiByUtentiNonAttiviRowMapper = new SigitTSanzioneDaoRowMapper(null,
			SigitTSanzioneAccertamentiByUtentiNonAttiviDto.class, this);

	protected SigitTSanzioneDaoRowMapper ispezione2018ByUtentiNonAttiviRowMapper = new SigitTSanzioneDaoRowMapper(null,
			SigitTSanzioneIspezione2018ByUtentiNonAttiviDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_SANZIONE";
	}

	/** 
	 * Implementazione del finder byCodiceFiscale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTSanzioneDto> findByCodiceFiscale(java.lang.String input) throws SigitTSanzioneDaoException {
		LOG.debug("[SigitTSanzioneDaoImpl::findByCodiceFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_SANZIONE,FK_STATO_SANZIONE,FK_ISPEZIONE_2018,FK_ACCERTAMENTO,FK_PF_SANZIONATA,FK_PG_SANZIONATA,MOTIVAZIONE_SANZIONE,VALORE_SANZIONE,DT_CREAZIONE,DT_COMUNICAZIONE,DT_PAGAMENTO,NOTE,MOTIVO_ANNULLAMENTO,DT_ANNULLAMENTO,CF_RESPONSABILE,DENOM_UT_RESPONSABILE,DT_SVEGLIA,NOTE_SVEGLIA ");
		sql.append(" FROM SIGIT_T_SANZIONE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1177745216) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("cf_responsabile = :codice_fiscale AND dt_sveglia <= NOW() AND fk_stato_sanzione IN (1,2)");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-2025477078) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codice_fiscale", input);

		/*PROTECTED REGION END*/
		List<SigitTSanzioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceFiscaleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTSanzioneDaoImpl::findByCodiceFiscale] esecuzione query", ex);
			throw new SigitTSanzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTSanzioneDaoImpl", "findByCodiceFiscale", "esecuzione query", sql.toString());
			LOG.debug("[SigitTSanzioneDaoImpl::findByCodiceFiscale] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder accertamentiByUtentiNonAttivi con Qdef
		 * @generated
		 */

	public List<SigitTSanzioneAccertamentiByUtentiNonAttiviDto> findAccertamentiByUtentiNonAttivi(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTSanzioneDto input)
			throws SigitTSanzioneDaoException {
		LOG.debug("[SigitTSanzioneDaoImpl::findAccertamentiByUtentiNonAttivi] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT S.ID_SANZIONE, S.CF_RESPONSABILE, S.DENOM_UT_RESPONSABILE, S.DT_SVEGLIA, S.NOTE_SVEGLIA, A.ID_RUOLO_PA, A.ISTAT_ABILITAZIONE, A.MAIL_COMUNICAZIONE");

		sql.append(
				" FROM SIGIT_R_PF_RUOLO_PA R, SIGIT_T_PERSONA_FISICA P, SIGIT_T_SANZIONE S, SIGIT_T_ABILITAZIONE A, SIGIT_T_ACCERTAMENTO ACC");

		sql.append(" WHERE ");

		sql.append(
				"R.ID_PERSONA_FISICA = P.ID_PERSONA_FISICA AND ACC.ID_ACCERTAMENTO = S.FK_ACCERTAMENTO AND P.CODICE_FISCALE = S.CF_RESPONSABILE AND R.ID_RUOLO_PA = A.ID_RUOLO_PA AND R.ISTAT_ABILITAZIONE = A.ISTAT_ABILITAZIONE");

		sql.append(" AND ");

		sql.append(
				"A.id_ruolo_pa =  4 AND R.data_fine is not null AND S.dt_sveglia <= NOW() AND S.fk_stato_sanzione IN (1,2)");
		/*PROTECTED REGION ID(R646062891) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:
		sql.append("ORDER BY  A.ID_RUOLO_PA ASC, A.ISTAT_ABILITAZIONE ASC, A.MAIL_COMUNICAZIONE ASC");
		//paramMap.addValue("param", input);

		/*PROTECTED REGION END*/

		List<SigitTSanzioneAccertamentiByUtentiNonAttiviDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, accertamentiByUtentiNonAttiviRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTSanzioneDaoImpl::findAccertamentiByUtentiNonAttivi] ERROR esecuzione query", ex);
			throw new SigitTSanzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTSanzioneDaoImpl", "findAccertamentiByUtentiNonAttivi", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTSanzioneDaoImpl::findAccertamentiByUtentiNonAttivi] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder ispezione2018ByUtentiNonAttivi con Qdef
		 * @generated
		 */

	public List<SigitTSanzioneIspezione2018ByUtentiNonAttiviDto> findIspezione2018ByUtentiNonAttivi(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTSanzioneDto input)
			throws SigitTSanzioneDaoException {
		LOG.debug("[SigitTSanzioneDaoImpl::findIspezione2018ByUtentiNonAttivi] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT S.ID_SANZIONE, S.CF_RESPONSABILE, S.DENOM_UT_RESPONSABILE, S.DT_SVEGLIA, S.NOTE_SVEGLIA, A.ID_RUOLO_PA, A.ISTAT_ABILITAZIONE, A.MAIL_COMUNICAZIONE");

		sql.append(
				" FROM SIGIT_R_PF_RUOLO_PA R, SIGIT_T_PERSONA_FISICA P, SIGIT_T_SANZIONE S, SIGIT_T_ABILITAZIONE A, SIGIT_T_ISPEZIONE_2018 I");

		sql.append(" WHERE ");

		sql.append(
				"R.ID_PERSONA_FISICA = P.ID_PERSONA_FISICA AND I.ID_ISPEZIONE_2018 = S.FK_ISPEZIONE_2018 AND P.CODICE_FISCALE = S.CF_RESPONSABILE AND R.ID_RUOLO_PA = A.ID_RUOLO_PA AND R.ISTAT_ABILITAZIONE = A.ISTAT_ABILITAZIONE");

		sql.append(" AND ");

		sql.append(
				"A.id_ruolo_pa = 2 AND R.data_fine is not null AND S.dt_sveglia <= NOW() AND S.fk_stato_sanzione IN (1,2)");
		/*PROTECTED REGION ID(R-790625494) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:
		sql.append("ORDER BY  A.ID_RUOLO_PA ASC, A.ISTAT_ABILITAZIONE ASC, A.MAIL_COMUNICAZIONE ASC");
		//paramMap.addValue("param", input);

		/*PROTECTED REGION END*/

		List<SigitTSanzioneIspezione2018ByUtentiNonAttiviDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ispezione2018ByUtentiNonAttiviRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTSanzioneDaoImpl::findIspezione2018ByUtentiNonAttivi] ERROR esecuzione query", ex);
			throw new SigitTSanzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTSanzioneDaoImpl", "findIspezione2018ByUtentiNonAttivi", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTSanzioneDaoImpl::findIspezione2018ByUtentiNonAttivi] END");
		}
		return list;
	}

}
