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

/*PROTECTED REGION ID(R-956469489) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVSk4Cg.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byCodImpiantoOrdered (datagen::CustomFinder)
 *   - attiviByCodImpianto (datagen::CustomFinder)
 *   - attiviByCodImpiantoProgressivi (datagen::CustomFinder)
 *   - byIdAllegato (datagen::CustomFinder)
 *   - byIdAllegatoProgr (datagen::CustomFinder)
 *   - attiviByCodImpiantoFkPg (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitVSk4CgDaoImpl extends AbstractDAO implements SigitVSk4CgDao {
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

	protected SigitVSk4CgDaoRowMapper byCodImpiantoOrderedRowMapper = new SigitVSk4CgDaoRowMapper(null,
			SigitVSk4CgDto.class, this);

	protected SigitVSk4CgDaoRowMapper attiviByCodImpiantoRowMapper = new SigitVSk4CgDaoRowMapper(new String[]{
			"CODICE_IMPIANTO", "ID_TIPO_COMPONENTE", "PROGRESSIVO", "DATA_INSTALL", "DATA_DISMISS", "MATRICOLA",
			"FK_MARCA", "DES_MARCA", "ID_COMBUSTIBILE", "DES_COMBUSTIBILE", "MODELLO", "POTENZA_TERMICA_KW",
			"TIPOLOGIA", "POTENZA_ELETTRICA_KW", "TEMP_H2O_OUT_MIN", "TEMP_H2O_OUT_MAX", "TEMP_H2O_IN_MIN",
			"TEMP_H2O_IN_MAX", "TEMP_H2O_MOTORE_MIN", "TEMP_H2O_MOTORE_MAX", "TEMP_FUMI_VALLE_MIN",
			"TEMP_FUMI_VALLE_MAX", "TEMP_FUMI_MONTE_MIN", "TEMP_FUMI_MONTE_MAX", "CO_MIN", "CO_MAX"},
			SigitVSk4CgDto.class, this);

	protected SigitVSk4CgDaoRowMapper attiviByCodImpiantoProgressiviRowMapper = new SigitVSk4CgDaoRowMapper(
			new String[]{"CODICE_IMPIANTO", "ID_TIPO_COMPONENTE", "PROGRESSIVO", "DATA_INSTALL", "DATA_DISMISS",
					"MATRICOLA", "FK_MARCA", "DES_MARCA", "ID_COMBUSTIBILE", "DES_COMBUSTIBILE", "MODELLO",
					"POTENZA_TERMICA_KW", "TIPOLOGIA", "POTENZA_ELETTRICA_KW", "TEMP_H2O_OUT_MIN", "TEMP_H2O_OUT_MAX",
					"TEMP_H2O_IN_MIN", "TEMP_H2O_IN_MAX", "TEMP_H2O_MOTORE_MIN", "TEMP_H2O_MOTORE_MAX",
					"TEMP_FUMI_VALLE_MIN", "TEMP_FUMI_VALLE_MAX", "TEMP_FUMI_MONTE_MIN", "TEMP_FUMI_MONTE_MAX",
					"CO_MIN", "CO_MAX"},
			SigitVSk4CgDto.class, this);

	protected SigitVSk4CgDaoRowMapper byIdAllegatoRowMapper = new SigitVSk4CgDaoRowMapper(null, SigitVSk4CgDto.class,
			this);

	protected SigitVSk4CgDaoRowMapper byIdAllegatoProgrRowMapper = new SigitVSk4CgDaoRowMapper(null,
			SigitVSk4CgDto.class, this);

	protected SigitVSk4CgDaoRowMapper attiviByCodImpiantoFkPgRowMapper = new SigitVSk4CgDaoRowMapper(null,
			SigitVSk4CgDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_SK4_CG";
	}

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4CgDto> findByCodImpiantoOrdered(Integer input) throws SigitVSk4CgDaoException {
		LOG.debug("[SigitVSk4CgDaoImpl::findByCodImpiantoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,DATA_DISMISS,MATRICOLA,FK_MARCA,DES_MARCA,ID_COMBUSTIBILE,DES_COMBUSTIBILE,MODELLO,POTENZA_TERMICA_KW,DATA_ULT_MOD,UTENTE_ULT_MOD,TIPOLOGIA,POTENZA_ELETTRICA_KW,TEMP_H2O_OUT_MIN,TEMP_H2O_OUT_MAX,TEMP_H2O_IN_MIN,TEMP_H2O_IN_MAX,TEMP_H2O_MOTORE_MIN,TEMP_H2O_MOTORE_MAX,TEMP_FUMI_VALLE_MIN,TEMP_FUMI_VALLE_MAX,TEMP_FUMI_MONTE_MIN,TEMP_FUMI_MONTE_MAX,CO_MIN,CO_MAX,FLG_DISMISSIONE,DATA_CONTROLLO,ID_ALLEGATO,FK_TIPO_DOCUMENTO,DES_TIPO_DOCUMENTO ");
		sql.append(" FROM VISTA_SK4_CG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-2110081503) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("CODICE_IMPIANTO = :codImpianto");
		sql.append(" ORDER BY PROGRESSIVO ASC, DATA_INSTALL DESC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-107453375) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVSk4CgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpiantoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVSk4CgDaoImpl::findByCodImpiantoOrdered] esecuzione query", ex);
			throw new SigitVSk4CgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVSk4CgDaoImpl", "findByCodImpiantoOrdered", "esecuzione query", sql.toString());
			LOG.debug("[SigitVSk4CgDaoImpl::findByCodImpiantoOrdered] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder attiviByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4CgDto> findAttiviByCodImpianto(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVSk4CgDto input) throws SigitVSk4CgDaoException {
		LOG.debug("[SigitVSk4CgDaoImpl::findAttiviByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT DISTINCT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,DATA_DISMISS,MATRICOLA,FK_MARCA,DES_MARCA,ID_COMBUSTIBILE,DES_COMBUSTIBILE,MODELLO,POTENZA_TERMICA_KW,TIPOLOGIA,POTENZA_ELETTRICA_KW,TEMP_H2O_OUT_MIN,TEMP_H2O_OUT_MAX,TEMP_H2O_IN_MIN,TEMP_H2O_IN_MAX,TEMP_H2O_MOTORE_MIN,TEMP_H2O_MOTORE_MAX,TEMP_FUMI_VALLE_MIN,TEMP_FUMI_VALLE_MAX,TEMP_FUMI_MONTE_MIN,TEMP_FUMI_MONTE_MAX,CO_MIN,CO_MAX ");
		sql.append(" FROM VISTA_SK4_CG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1109509459) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("CODICE_IMPIANTO = :codImpianto");

		if (GenericUtil.isNotNullOrEmpty(input.getDataInstall())) {
			sql.append(" AND DATA_INSTALL <= :dataControllo");
			sql.append(" AND (DATA_DISMISS >= :dataControllo OR DATA_DISMISS IS NULL)");
		} else {
			sql.append(" AND DATA_INSTALL <= current_timestamp");
			sql.append(" AND (DATA_DISMISS >= current_timestamp OR DATA_DISMISS IS NULL)");
		}
		sql.append(" ORDER BY PROGRESSIVO ASC ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R845508917) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("dataControllo", input.getDataInstall(), java.sql.Types.DATE);

		/*PROTECTED REGION END*/
		List<SigitVSk4CgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attiviByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVSk4CgDaoImpl::findAttiviByCodImpianto] esecuzione query", ex);
			throw new SigitVSk4CgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVSk4CgDaoImpl", "findAttiviByCodImpianto", "esecuzione query", sql.toString());
			LOG.debug("[SigitVSk4CgDaoImpl::findAttiviByCodImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder attiviByCodImpiantoProgressivi
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4CgDto> findAttiviByCodImpiantoProgressivi(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitVSk4CgDaoException {
		LOG.debug("[SigitVSk4CgDaoImpl::findAttiviByCodImpiantoProgressivi] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT DISTINCT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,DATA_DISMISS,MATRICOLA,FK_MARCA,DES_MARCA,ID_COMBUSTIBILE,DES_COMBUSTIBILE,MODELLO,POTENZA_TERMICA_KW,TIPOLOGIA,POTENZA_ELETTRICA_KW,TEMP_H2O_OUT_MIN,TEMP_H2O_OUT_MAX,TEMP_H2O_IN_MIN,TEMP_H2O_IN_MAX,TEMP_H2O_MOTORE_MIN,TEMP_H2O_MOTORE_MAX,TEMP_FUMI_VALLE_MIN,TEMP_FUMI_VALLE_MAX,TEMP_FUMI_MONTE_MIN,TEMP_FUMI_MONTE_MAX,CO_MIN,CO_MAX ");
		sql.append(" FROM VISTA_SK4_CG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R895678526) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("CODICE_IMPIANTO = :codImpianto");

		sql.append(" AND :dataRapporto BETWEEN DATA_INSTALL AND COALESCE(DATA_DISMISS, :dataRapporto) ");

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

		sql.append(" ORDER BY PROGRESSIVO,  DATA_INSTALL ASC ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1418172988) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);

		paramMap.addValue("dataRapporto", input.getDataInstallazione(), java.sql.Types.DATE);

		/*PROTECTED REGION END*/
		List<SigitVSk4CgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attiviByCodImpiantoProgressiviRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVSk4CgDaoImpl::findAttiviByCodImpiantoProgressivi] esecuzione query", ex);
			throw new SigitVSk4CgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVSk4CgDaoImpl", "findAttiviByCodImpiantoProgressivi", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVSk4CgDaoImpl::findAttiviByCodImpiantoProgressivi] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4CgDto> findByIdAllegato(java.lang.Integer input) throws SigitVSk4CgDaoException {
		LOG.debug("[SigitVSk4CgDaoImpl::findByIdAllegato] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,DATA_DISMISS,MATRICOLA,FK_MARCA,DES_MARCA,ID_COMBUSTIBILE,DES_COMBUSTIBILE,MODELLO,POTENZA_TERMICA_KW,DATA_ULT_MOD,UTENTE_ULT_MOD,TIPOLOGIA,POTENZA_ELETTRICA_KW,TEMP_H2O_OUT_MIN,TEMP_H2O_OUT_MAX,TEMP_H2O_IN_MIN,TEMP_H2O_IN_MAX,TEMP_H2O_MOTORE_MIN,TEMP_H2O_MOTORE_MAX,TEMP_FUMI_VALLE_MIN,TEMP_FUMI_VALLE_MAX,TEMP_FUMI_MONTE_MIN,TEMP_FUMI_MONTE_MAX,CO_MIN,CO_MAX,FLG_DISMISSIONE,DATA_CONTROLLO,ID_ALLEGATO,FK_TIPO_DOCUMENTO,DES_TIPO_DOCUMENTO ");
		sql.append(" FROM VISTA_SK4_CG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1300450565) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("ID_ALLEGATO = :idAllegato");

		sql.append(" ORDER BY PROGRESSIVO ASC ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1755141667) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idAllegato", input);

		/*PROTECTED REGION END*/
		List<SigitVSk4CgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAllegatoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVSk4CgDaoImpl::findByIdAllegato] esecuzione query", ex);
			throw new SigitVSk4CgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVSk4CgDaoImpl", "findByIdAllegato", "esecuzione query", sql.toString());
			LOG.debug("[SigitVSk4CgDaoImpl::findByIdAllegato] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byIdAllegatoProgr
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4CgDto> findByIdAllegatoProgr(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitVSk4CgDaoException {
		LOG.debug("[SigitVSk4CgDaoImpl::findByIdAllegatoProgr] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,DATA_DISMISS,MATRICOLA,FK_MARCA,DES_MARCA,ID_COMBUSTIBILE,DES_COMBUSTIBILE,MODELLO,POTENZA_TERMICA_KW,DATA_ULT_MOD,UTENTE_ULT_MOD,TIPOLOGIA,POTENZA_ELETTRICA_KW,TEMP_H2O_OUT_MIN,TEMP_H2O_OUT_MAX,TEMP_H2O_IN_MIN,TEMP_H2O_IN_MAX,TEMP_H2O_MOTORE_MIN,TEMP_H2O_MOTORE_MAX,TEMP_FUMI_VALLE_MIN,TEMP_FUMI_VALLE_MAX,TEMP_FUMI_MONTE_MIN,TEMP_FUMI_MONTE_MAX,CO_MIN,CO_MAX,FLG_DISMISSIONE,DATA_CONTROLLO,ID_ALLEGATO,FK_TIPO_DOCUMENTO,DES_TIPO_DOCUMENTO ");
		sql.append(" FROM VISTA_SK4_CG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-79551825) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("ID_ALLEGATO = :idAllegato");

		sql.append(" AND PROGRESSIVO = :progressivo ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1585542797) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idAllegato", input.getIdAllegato(), java.sql.Types.NUMERIC);
		paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVSk4CgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAllegatoProgrRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVSk4CgDaoImpl::findByIdAllegatoProgr] esecuzione query", ex);
			throw new SigitVSk4CgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVSk4CgDaoImpl", "findByIdAllegatoProgr", "esecuzione query", sql.toString());
			LOG.debug("[SigitVSk4CgDaoImpl::findByIdAllegatoProgr] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder attiviByCodImpiantoFkPg
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4CgDto> findAttiviByCodImpiantoFkPg(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.AllegatiCompFilter input)
			throws SigitVSk4CgDaoException {
		LOG.debug("[SigitVSk4CgDaoImpl::findAttiviByCodImpiantoFkPg] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-214980385) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT c.CODICE_IMPIANTO,c.ID_TIPO_COMPONENTE,c.PROGRESSIVO,DATA_INSTALL,DATA_DISMISS,MATRICOLA,FK_MARCA,DES_MARCA,ID_COMBUSTIBILE,DES_COMBUSTIBILE,MODELLO,POTENZA_TERMICA_KW,c.DATA_ULT_MOD,c.UTENTE_ULT_MOD,TIPOLOGIA,POTENZA_ELETTRICA_KW,TEMP_H2O_OUT_MIN,TEMP_H2O_OUT_MAX,TEMP_H2O_IN_MIN,TEMP_H2O_IN_MAX,TEMP_H2O_MOTORE_MIN,TEMP_H2O_MOTORE_MAX,TEMP_FUMI_VALLE_MIN,TEMP_FUMI_VALLE_MAX,TEMP_FUMI_MONTE_MIN,TEMP_FUMI_MONTE_MAX,CO_MIN,CO_MAX,FLG_DISMISSIONE,DATA_CONTROLLO,ID_ALLEGATO,FK_TIPO_DOCUMENTO,DES_TIPO_DOCUMENTO ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1097328433) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM VISTA_SK4_CG c, SIGIT_R_COMP4_MANUT cm");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-559921175) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" c.CODICE_IMPIANTO = cm.CODICE_IMPIANTO ");
		sql.append(" AND c.ID_TIPO_COMPONENTE = cm.ID_TIPO_COMPONENTE ");
		sql.append(" AND c.PROGRESSIVO = cm.PROGRESSIVO ");

		sql.append(" AND c.CODICE_IMPIANTO = :codImpianto");

		if (GenericUtil.isNotNullOrEmpty(input.getDataControllo())) {
			sql.append(" AND DATA_INSTALL <= :dataControllo");
			sql.append(" AND (DATA_DISMISS >= :dataControllo OR DATA_DISMISS IS NULL)");
		} else {
			sql.append(" AND DATA_INSTALL <= current_timestamp");
			sql.append(" AND (DATA_DISMISS >= current_timestamp OR DATA_DISMISS IS NULL)");
		}

		sql.append(" AND cm.FK_PERSONA_GIURIDICA = :fkPg");

		sql.append(" ORDER BY c.PROGRESSIVO, DATA_INSTALL ASC ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R702876537) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("dataControllo", input.getDataControllo(), java.sql.Types.DATE);
		paramMap.addValue("fkPg", input.getIdImpRuoloPfPg(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVSk4CgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attiviByCodImpiantoFkPgRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVSk4CgDaoImpl::findAttiviByCodImpiantoFkPg] esecuzione query", ex);
			throw new SigitVSk4CgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVSk4CgDaoImpl", "findAttiviByCodImpiantoFkPg", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVSk4CgDaoImpl::findAttiviByCodImpiantoFkPg] END");
		}
		return list;
	}

}
