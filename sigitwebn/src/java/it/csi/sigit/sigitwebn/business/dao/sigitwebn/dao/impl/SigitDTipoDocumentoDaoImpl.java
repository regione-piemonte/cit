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

/*PROTECTED REGION ID(R836947791) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitDTipoDocumento.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byFlgVisualizzaAllegati (datagen::CustomFinder)
 *   - byRuoloFunzionale (datagen::CustomFinder)
 *   - byFlgRicercaAllegati (datagen::CustomFinder)
 *   - byCodiceImpianto (datagen::CustomFinder)
 *   - byFlgVisualizzaManutenzioni (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitDTipoDocumentoDaoImpl extends AbstractDAO implements SigitDTipoDocumentoDao {
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

	protected SigitDTipoDocumentoDaoRowMapper findAllRowMapper = new SigitDTipoDocumentoDaoRowMapper(null,
			SigitDTipoDocumentoDto.class, this);

	protected SigitDTipoDocumentoDaoRowMapper findByPrimaryKeyRowMapper = new SigitDTipoDocumentoDaoRowMapper(null,
			SigitDTipoDocumentoDto.class, this);

	protected SigitDTipoDocumentoDaoRowMapper byFlgVisualizzaAllegatiRowMapper = new SigitDTipoDocumentoDaoRowMapper(
			null, SigitDTipoDocumentoDto.class, this);

	protected SigitDTipoDocumentoDaoRowMapper byRuoloFunzionaleRowMapper = new SigitDTipoDocumentoDaoRowMapper(null,
			SigitDTipoDocumentoByRuoloFunzionaleDto.class, this);

	protected SigitDTipoDocumentoDaoRowMapper byFlgRicercaAllegatiRowMapper = new SigitDTipoDocumentoDaoRowMapper(null,
			SigitDTipoDocumentoDto.class, this);

	protected SigitDTipoDocumentoDaoRowMapper byCodiceImpiantoRowMapper = new SigitDTipoDocumentoDaoRowMapper(null,
			SigitDTipoDocumentoByCodiceImpiantoDto.class, this);

	protected SigitDTipoDocumentoDaoRowMapper byFlgVisualizzaManutenzioniRowMapper = new SigitDTipoDocumentoDaoRowMapper(
			null, SigitDTipoDocumentoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_D_TIPO_DOCUMENTO";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_TIPO_DOCUMENTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoDocumentoDto> findAll() throws SigitDTipoDocumentoDaoException {
		LOG.debug("[SigitDTipoDocumentoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_DOCUMENTO,DES_TIPO_DOCUMENTO,FLG_VISU_ELENCO_ALL,FLG_RICERCA_ALL,FLG_VISU_ELENCO_RAPPROVA,FLG_VISU_ELENCO_MANUT FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitDTipoDocumentoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoDocumentoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitDTipoDocumentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoDocumentoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitDTipoDocumentoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_D_TIPO_DOCUMENTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDTipoDocumentoDto findByPrimaryKey(SigitDTipoDocumentoPk pk) throws SigitDTipoDocumentoDaoException {
		LOG.debug("[SigitDTipoDocumentoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_DOCUMENTO,DES_TIPO_DOCUMENTO,FLG_VISU_ELENCO_ALL,FLG_RICERCA_ALL,FLG_VISU_ELENCO_RAPPROVA,FLG_VISU_ELENCO_MANUT FROM "
						+ getTableName() + " WHERE ID_TIPO_DOCUMENTO = :ID_TIPO_DOCUMENTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_DOCUMENTO]
		params.addValue("ID_TIPO_DOCUMENTO", pk.getIdTipoDocumento(), java.sql.Types.NUMERIC);

		List<SigitDTipoDocumentoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoDocumentoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitDTipoDocumentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoDocumentoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitDTipoDocumentoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byFlgVisualizzaAllegati
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoDocumentoDto> findByFlgVisualizzaAllegati(java.lang.String input)
			throws SigitDTipoDocumentoDaoException {
		LOG.debug("[SigitDTipoDocumentoDaoImpl::findByFlgVisualizzaAllegati] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_TIPO_DOCUMENTO,DES_TIPO_DOCUMENTO,FLG_VISU_ELENCO_ALL,FLG_RICERCA_ALL,FLG_VISU_ELENCO_RAPPROVA,FLG_VISU_ELENCO_MANUT ");
		sql.append(" FROM SIGIT_D_TIPO_DOCUMENTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1281046021) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		//sql.append(" 1 = 1");

		sql.append(" FLG_VISU_ELENCO_RAPPROVA = :flg");

		sql.append(" ORDER BY ID_TIPO_DOCUMENTO ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1938284765) ENABLED START*/
		//***aggiungere tutte le condizioni
		Integer flag = new Integer(1);
		paramMap.addValue("flg", flag);

		/*PROTECTED REGION END*/
		List<SigitDTipoDocumentoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFlgVisualizzaAllegatiRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoDocumentoDaoImpl::findByFlgVisualizzaAllegati] esecuzione query", ex);
			throw new SigitDTipoDocumentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoDocumentoDaoImpl", "findByFlgVisualizzaAllegati", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitDTipoDocumentoDaoImpl::findByFlgVisualizzaAllegati] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byRuoloFunzionale con Qdef
		 * @generated
		 */

	public List<SigitDTipoDocumentoByRuoloFunzionaleDto> findByRuoloFunzionale(java.lang.String input)
			throws SigitDTipoDocumentoDaoException {
		LOG.debug("[SigitDTipoDocumentoDaoImpl::findByRuoloFunzionale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT dTipoDocumento.ID_TIPO_DOCUMENTO as idTipoDocumento, dTipoDocumento.DES_TIPO_DOCUMENTO as descTipoDocumento");

		sql.append(
				" FROM SIGIT_D_TIPO_DOCUMENTO dTipoDocumento, SIGIT_D_RUOLO dRuolo, SIGIT_R_RUOLO_TIPODOC rRuoloTipoDocumento");

		sql.append(" WHERE ");

		sql.append(
				"dTipoDocumento.ID_TIPO_DOCUMENTO = rRuoloTipoDocumento.ID_TIPO_DOCUMENTO AND dRuolo.ID_RUOLO = rRuoloTipoDocumento.ID_RUOLO");

		sql.append(" AND ");

		sql.append("1=1");
		/*PROTECTED REGION ID(R1266227669) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:
		sql.append(" AND dRuolo.RUOLO_FUNZ = :ruolo");

		sql.append(" ORDER BY dTipoDocumento.ID_TIPO_DOCUMENTO ");

		paramMap.addValue("ruolo", input);

		/*PROTECTED REGION END*/

		List<SigitDTipoDocumentoByRuoloFunzionaleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byRuoloFunzionaleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoDocumentoDaoImpl::findByRuoloFunzionale] ERROR esecuzione query", ex);
			throw new SigitDTipoDocumentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoDocumentoDaoImpl", "findByRuoloFunzionale", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitDTipoDocumentoDaoImpl::findByRuoloFunzionale] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byFlgRicercaAllegati
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoDocumentoDto> findByFlgRicercaAllegati(java.lang.String input)
			throws SigitDTipoDocumentoDaoException {
		LOG.debug("[SigitDTipoDocumentoDaoImpl::findByFlgRicercaAllegati] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_TIPO_DOCUMENTO,DES_TIPO_DOCUMENTO,FLG_VISU_ELENCO_ALL,FLG_RICERCA_ALL,FLG_VISU_ELENCO_RAPPROVA,FLG_VISU_ELENCO_MANUT ");
		sql.append(" FROM SIGIT_D_TIPO_DOCUMENTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1752361132) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" FLG_RICERCA_ALL = :flg");

		sql.append(" ORDER BY ID_TIPO_DOCUMENTO ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-630815978) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("flg", Constants.SI_1);

		/*PROTECTED REGION END*/
		List<SigitDTipoDocumentoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFlgRicercaAllegatiRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoDocumentoDaoImpl::findByFlgRicercaAllegati] esecuzione query", ex);
			throw new SigitDTipoDocumentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoDocumentoDaoImpl", "findByFlgRicercaAllegati", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitDTipoDocumentoDaoImpl::findByFlgRicercaAllegati] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byCodiceImpianto con Qdef
		 * @generated
		 */

	public List<SigitDTipoDocumentoByCodiceImpiantoDto> findByCodiceImpianto(java.lang.Integer input)
			throws SigitDTipoDocumentoDaoException {
		LOG.debug("[SigitDTipoDocumentoDaoImpl::findByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT sigitDTipoDocumento.ID_TIPO_DOCUMENTO as idTipoDocumento, sigitDTipoDocumento.DES_TIPO_DOCUMENTO as descTipoDocumento");

		sql.append(" FROM SIGIT_D_TIPO_DOCUMENTO sigitDTipoDocumento, SIGIT_R_RUOLO_TIPODOC sigitRRuoloTipodoc");

		sql.append(" WHERE ");

		sql.append("sigitDTipoDocumento.ID_TIPO_DOCUMENTO = sigitRRuoloTipodoc.ID_TIPO_DOCUMENTO");

		sql.append(" AND ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R-1089897285) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" AND sigitRRuoloTipodoc.ID_RUOLO IN(")
				.append(" SELECT FK_RUOLO FROM SIGIT_R_COMP4_MANUT WHERE CODICE_IMPIANTO = :idCodiceImpianto")
				.append(" AND DATA_FINE IS NULL AND FK_RUOLO IN(").append(Constants.ID_RUOLO_MANUTENTORE_ALL_1)
				.append(",").append(Constants.ID_RUOLO_MANUTENTORE_ALL_2).append(",")
				.append(Constants.ID_RUOLO_MANUTENTORE_ALL_3).append(",").append(Constants.ID_RUOLO_MANUTENTORE_ALL_4)
				.append("))").append(" ORDER BY sigitDTipoDocumento.ID_TIPO_DOCUMENTO");

		paramMap.addValue("idCodiceImpianto", input, java.sql.Types.INTEGER);

		/*PROTECTED REGION END*/

		List<SigitDTipoDocumentoByCodiceImpiantoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpiantoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoDocumentoDaoImpl::findByCodiceImpianto] ERROR esecuzione query", ex);
			throw new SigitDTipoDocumentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoDocumentoDaoImpl", "findByCodiceImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitDTipoDocumentoDaoImpl::findByCodiceImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byFlgVisualizzaManutenzioni
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoDocumentoDto> findByFlgVisualizzaManutenzioni(java.lang.String input)
			throws SigitDTipoDocumentoDaoException {
		LOG.debug("[SigitDTipoDocumentoDaoImpl::findByFlgVisualizzaManutenzioni] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_TIPO_DOCUMENTO,DES_TIPO_DOCUMENTO,FLG_VISU_ELENCO_ALL,FLG_RICERCA_ALL,FLG_VISU_ELENCO_RAPPROVA,FLG_VISU_ELENCO_MANUT ");
		sql.append(" FROM SIGIT_D_TIPO_DOCUMENTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R794107403) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" FLG_VISU_ELENCO_MANUT = :flg");

		sql.append(" ORDER BY ID_TIPO_DOCUMENTO ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-271910505) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("flg", Constants.SI_1);

		/*PROTECTED REGION END*/
		List<SigitDTipoDocumentoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFlgVisualizzaManutenzioniRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitDTipoDocumentoDaoImpl::findByFlgVisualizzaManutenzioni] esecuzione query", ex);
			throw new SigitDTipoDocumentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitDTipoDocumentoDaoImpl", "findByFlgVisualizzaManutenzioni", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitDTipoDocumentoDaoImpl::findByFlgVisualizzaManutenzioni] END");
		}
		return list;
	}

}
