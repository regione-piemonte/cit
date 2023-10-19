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

/*PROTECTED REGION ID(R316098191) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVSk4Sc.
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
public class SigitVSk4ScDaoImpl extends AbstractDAO implements SigitVSk4ScDao {
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

	protected SigitVSk4ScDaoRowMapper byCodImpiantoOrderedRowMapper = new SigitVSk4ScDaoRowMapper(null,
			SigitVSk4ScDto.class, this);

	protected SigitVSk4ScDaoRowMapper attiviByCodImpiantoRowMapper = new SigitVSk4ScDaoRowMapper(
			new String[]{"CODICE_IMPIANTO", "ID_TIPO_COMPONENTE", "PROGRESSIVO", "DATA_INSTALL", "MATRICOLA", "MODELLO",
					"POTENZA_TERMICA_KW", "FK_MARCA", "DES_MARCA", "DATA_DISMISS"},
			SigitVSk4ScDto.class, this);

	protected SigitVSk4ScDaoRowMapper attiviByCodImpiantoProgressiviRowMapper = new SigitVSk4ScDaoRowMapper(
			new String[]{"CODICE_IMPIANTO", "ID_TIPO_COMPONENTE", "PROGRESSIVO", "DATA_INSTALL", "DATA_DISMISS",
					"MATRICOLA", "MODELLO", "POTENZA_TERMICA_KW", "FK_MARCA", "DES_MARCA"},
			SigitVSk4ScDto.class, this);

	protected SigitVSk4ScDaoRowMapper byIdAllegatoRowMapper = new SigitVSk4ScDaoRowMapper(null, SigitVSk4ScDto.class,
			this);

	protected SigitVSk4ScDaoRowMapper byIdAllegatoProgrRowMapper = new SigitVSk4ScDaoRowMapper(null,
			SigitVSk4ScDto.class, this);

	protected SigitVSk4ScDaoRowMapper attiviByCodImpiantoFkPgRowMapper = new SigitVSk4ScDaoRowMapper(null,
			SigitVSk4ScDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_SK4_SC";
	}

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4ScDto> findByCodImpiantoOrdered(Integer input) throws SigitVSk4ScDaoException {
		LOG.debug("[SigitVSk4ScDaoImpl::findByCodImpiantoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,FLG_DISMISSIONE,DATA_DISMISS,DATA_ULT_MOD,UTENTE_ULT_MOD,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,FK_MARCA,DES_MARCA,DATA_CONTROLLO,ID_ALLEGATO,FK_TIPO_DOCUMENTO,DES_TIPO_DOCUMENTO ");
		sql.append(" FROM VISTA_SK4_SC");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-972202995) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("CODICE_IMPIANTO = :codImpianto");
		sql.append(" ORDER BY PROGRESSIVO ASC, DATA_INSTALL DESC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R807042005) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVSk4ScDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpiantoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVSk4ScDaoImpl::findByCodImpiantoOrdered] esecuzione query", ex);
			throw new SigitVSk4ScDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVSk4ScDaoImpl", "findByCodImpiantoOrdered", "esecuzione query", sql.toString());
			LOG.debug("[SigitVSk4ScDaoImpl::findByCodImpiantoOrdered] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder attiviByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4ScDto> findAttiviByCodImpianto(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVSk4ScDto input) throws SigitVSk4ScDaoException {
		LOG.debug("[SigitVSk4ScDaoImpl::findAttiviByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT DISTINCT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,FK_MARCA,DES_MARCA,DATA_DISMISS ");
		sql.append(" FROM VISTA_SK4_SC");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R728311617) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" CODICE_IMPIANTO = :codImpianto");

		if (GenericUtil.isNotNullOrEmpty(input.getDataInstall())) {
			sql.append(" AND DATA_INSTALL <= :dataControllo");
			sql.append(" AND (DATA_DISMISS >= :dataControllo OR DATA_DISMISS IS NULL)");
		} else {
			sql.append(" AND DATA_INSTALL <= current_timestamp");
			sql.append(" AND (DATA_DISMISS >= current_timestamp OR DATA_DISMISS IS NULL)");
		}
		sql.append(" ORDER BY PROGRESSIVO ASC ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1983387425) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("dataControllo", input.getDataInstall(), java.sql.Types.DATE);

		/*PROTECTED REGION END*/
		List<SigitVSk4ScDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attiviByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVSk4ScDaoImpl::findAttiviByCodImpianto] esecuzione query", ex);
			throw new SigitVSk4ScDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVSk4ScDaoImpl", "findAttiviByCodImpianto", "esecuzione query", sql.toString());
			LOG.debug("[SigitVSk4ScDaoImpl::findAttiviByCodImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder attiviByCodImpiantoProgressivi
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4ScDto> findAttiviByCodImpiantoProgressivi(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitVSk4ScDaoException {
		LOG.debug("[SigitVSk4ScDaoImpl::findAttiviByCodImpiantoProgressivi] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT DISTINCT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,DATA_DISMISS,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,FK_MARCA,DES_MARCA ");
		sql.append(" FROM VISTA_SK4_SC");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R79701802) ENABLED START*/
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
		/*PROTECTED REGION ID(R-943647656) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);

		paramMap.addValue("dataRapporto", input.getDataInstallazione(), java.sql.Types.DATE);

		/*PROTECTED REGION END*/
		List<SigitVSk4ScDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attiviByCodImpiantoProgressiviRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVSk4ScDaoImpl::findAttiviByCodImpiantoProgressivi] esecuzione query", ex);
			throw new SigitVSk4ScDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVSk4ScDaoImpl", "findAttiviByCodImpiantoProgressivi", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVSk4ScDaoImpl::findAttiviByCodImpiantoProgressivi] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4ScDto> findByIdAllegato(java.lang.Integer input) throws SigitVSk4ScDaoException {
		LOG.debug("[SigitVSk4ScDaoImpl::findByIdAllegato] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,FLG_DISMISSIONE,DATA_DISMISS,DATA_ULT_MOD,UTENTE_ULT_MOD,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,FK_MARCA,DES_MARCA,DATA_CONTROLLO,ID_ALLEGATO,FK_TIPO_DOCUMENTO,DES_TIPO_DOCUMENTO ");
		sql.append(" FROM VISTA_SK4_SC");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R673226481) ENABLED START*/
		sql.append("ID_ALLEGATO = :idAllegato");

		sql.append(" ORDER BY PROGRESSIVO ASC ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R275748209) ENABLED START*/

		paramMap.addValue("idAllegato", input);

		/*PROTECTED REGION END*/
		List<SigitVSk4ScDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAllegatoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVSk4ScDaoImpl::findByIdAllegato] esecuzione query", ex);
			throw new SigitVSk4ScDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVSk4ScDaoImpl", "findByIdAllegato", "esecuzione query", sql.toString());
			LOG.debug("[SigitVSk4ScDaoImpl::findByIdAllegato] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byIdAllegatoProgr
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4ScDto> findByIdAllegatoProgr(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitVSk4ScDaoException {
		LOG.debug("[SigitVSk4ScDaoImpl::findByIdAllegatoProgr] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,FLG_DISMISSIONE,DATA_DISMISS,DATA_ULT_MOD,UTENTE_ULT_MOD,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,FK_MARCA,DES_MARCA,DATA_CONTROLLO,ID_ALLEGATO,FK_TIPO_DOCUMENTO,DES_TIPO_DOCUMENTO ");
		sql.append(" FROM VISTA_SK4_SC");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R101131331) ENABLED START*/

		sql.append("ID_ALLEGATO = :idAllegato");

		sql.append(" AND PROGRESSIVO = :progressivo ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-279332257) ENABLED START*/

		paramMap.addValue("idAllegato", input.getIdAllegato(), java.sql.Types.NUMERIC);
		paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVSk4ScDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAllegatoProgrRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVSk4ScDaoImpl::findByIdAllegatoProgr] esecuzione query", ex);
			throw new SigitVSk4ScDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVSk4ScDaoImpl", "findByIdAllegatoProgr", "esecuzione query", sql.toString());
			LOG.debug("[SigitVSk4ScDaoImpl::findByIdAllegatoProgr] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder attiviByCodImpiantoFkPg
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4ScDto> findAttiviByCodImpiantoFkPg(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.AllegatiCompFilter input)
			throws SigitVSk4ScDaoException {
		LOG.debug("[SigitVSk4ScDaoImpl::findAttiviByCodImpiantoFkPg] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R539326667) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT c.CODICE_IMPIANTO,c.ID_TIPO_COMPONENTE,c.PROGRESSIVO,DATA_INSTALL,FLG_DISMISSIONE,DATA_DISMISS,c.DATA_ULT_MOD,c.UTENTE_ULT_MOD,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,FK_MARCA,DES_MARCA,DATA_CONTROLLO,ID_ALLEGATO,FK_TIPO_DOCUMENTO,DES_TIPO_DOCUMENTO ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-618085859) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM VISTA_SK4_SC c, SIGIT_R_COMP4_MANUT cm");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R2096810621) ENABLED START*/
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
		/*PROTECTED REGION ID(R1457183589) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("dataControllo", input.getDataControllo(), java.sql.Types.DATE);
		paramMap.addValue("fkPg", input.getIdImpRuoloPfPg(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVSk4ScDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attiviByCodImpiantoFkPgRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVSk4ScDaoImpl::findAttiviByCodImpiantoFkPg] esecuzione query", ex);
			throw new SigitVSk4ScDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVSk4ScDaoImpl", "findAttiviByCodImpiantoFkPg", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVSk4ScDaoImpl::findAttiviByCodImpiantoFkPg] END");
		}
		return list;
	}

}
