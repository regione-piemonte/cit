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

/*PROTECTED REGION ID(R-2038060529) ENABLED START*/
// aggiungere qui eventuali import custom.
import it.csi.sigit.sigitbatchn.business.util.GenericUtil;

/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTImportDistrib.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - daElaborare (datagen::CustomFinder)
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - daInviareMailAssistenza (datagen::CustomFinder)
 *   - ricevutaByIdImportDistrib (datagen::CustomFinder)
  * - UPDATERS:
 *   - aggiornaById (datagen::CustomUpdater)
 *   - aggiornaDataInvioMailAssistenza (datagen::CustomUpdater)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTImportDistribDaoImpl extends AbstractDAO implements SigitTImportDistribDao {
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
	 * Custom updater in the SIGIT_T_IMPORT_DISTRIB table.
	 * @generated
	 */
	public void customUpdaterAggiornaById(java.lang.Object filter,
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDistribDto value)
			throws SigitTImportDistribDaoException {
		LOG.debug("[SigitTImportDistribDaoImpl::customUpdaterAggiornaById] START");
		/*PROTECTED REGION ID(R2126507308) ENABLED START*/
		//***scrivere la custom query
		final StringBuffer sql = new StringBuffer("UPDATE " + getTableName() + " SET ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// Questa rga in realtà e' inutile, mi serve per poter gestire in maniera corretta gli AND delle righe successive
		sql.append(" ID_IMPORT_DISTRIB = :idImport");

		if (GenericUtil.isNotNullOrEmpty(value.getFkStatoDistrib())) {
			sql.append(" , FK_STATO_DISTRIB = :fkStato");
			params.addValue("fkStato", value.getFkStatoDistrib(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(value.getDataFineElab())) {
			sql.append(" , DATA_FINE_ELAB = :dataFine");
			params.addValue("dataFine", value.getDataFineElab(), java.sql.Types.TIMESTAMP);
		}

		if (GenericUtil.isNotNullOrEmpty(value.getDataInvioMailDistrib())) {
			sql.append(" , DATA_INVIO_MAIL_DISTRIB = :dataInvioDistrib");
			params.addValue("dataInvioDistrib", value.getDataInvioMailDistrib(), java.sql.Types.TIMESTAMP);
		}

		if (GenericUtil.isNotNullOrEmpty(value.getDataInvioMailAssistenza())) {
			sql.append(" , DATA_INVIO_MAIL_ASSISTENZA = :dataInvioAssist");
			params.addValue("dataInvioAssist", value.getDataInvioMailAssistenza(), java.sql.Types.TIMESTAMP);
		}

		if (GenericUtil.isNotNullOrEmpty(value.getTotRecordElaborati())) {
			sql.append(" , TOT_RECORD_ELABORATI = :totElab");
			params.addValue("totElab", value.getTotRecordElaborati(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(value.getTotRecordScartati())) {
			sql.append(" , TOT_RECORD_SCARTATI = :totScart");
			params.addValue("totScart", value.getTotRecordScartati(), java.sql.Types.NUMERIC);
		}

		sql.append(" WHERE ID_IMPORT_DISTRIB = :idImport");

		params.addValue("idImport", filter, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTImportDistribDaoImpl::customUpdaterAggiornaById] END");
	}

	/** 
	 * Custom updater in the SIGIT_T_IMPORT_DISTRIB table.
	 * @generated
	 */
	public void customUpdaterAggiornaDataInvioMailAssistenza(java.lang.Object filter, java.lang.Object value)
			throws SigitTImportDistribDaoException {
		LOG.debug("[SigitTImportDistribDaoImpl::customUpdaterAggiornaDataInvioMailAssistenza] START");
		/*PROTECTED REGION ID(R-1965975133) ENABLED START*/
		//***scrivere la custom query
		final StringBuffer sql = new StringBuffer("UPDATE " + getTableName() + " SET");

		sql.append(" DATA_INVIO_MAIL_ASSISTENZA = :dataInvioAssist");

		sql.append(" WHERE FK_STATO_DISTRIB IN (" + Constants.ID_STATO_IMP_DISTRIBUTORE_INVIATO + ","
				+ Constants.ID_STATO_IMP_DISTRIBUTORE_RIFIUTATO + ")");
		sql.append(" AND DATA_INVIO_MAIL_ASSISTENZA IS NULL ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("dataInvioAssist", value, java.sql.Types.TIMESTAMP);

		/*PROTECTED REGION END*/

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTImportDistribDaoImpl::customUpdaterAggiornaDataInvioMailAssistenza] END");
	}

	protected SigitTImportDistribDaoRowMapper daElaborareRowMapper = new SigitTImportDistribDaoRowMapper(null,
			SigitTImportDistribDto.class, this);

	protected SigitTImportDistribDaoRowMapper findByPrimaryKeyRowMapper = new SigitTImportDistribDaoRowMapper(null,
			SigitTImportDistribDto.class, this);

	protected SigitTImportDistribDaoRowMapper daInviareMailAssistenzaRowMapper = new SigitTImportDistribDaoRowMapper(
			null, SigitTImportDistribDto.class, this);

	protected SigitTImportDistribDaoRowMapper ricevutaByIdImportDistribRowMapper = new SigitTImportDistribDaoRowMapper(
			null, SigitTImportDistribRicevutaByIdImportDistribDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_IMPORT_DISTRIB";
	}

	/** 
	 * Implementazione del finder daElaborare
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTImportDistribDto> findDaElaborare(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDistribDto input)
			throws SigitTImportDistribDaoException {
		LOG.debug("[SigitTImportDistribDaoImpl::findDaElaborare] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMPORT_DISTRIB,FK_PERSONA_GIURIDICA,FK_STATO_DISTRIB,DATA_INIZIO_ELAB,DATA_FINE_ELAB,DATA_ANNULLAMENTO,NOME_FILE_IMPORT,UID_INDEX,ANNO_RIFERIMENTO,DATA_INVIO_MAIL_DISTRIB,DATA_INVIO_MAIL_ASSISTENZA,TOT_RECORD_ELABORATI,TOT_RECORD_SCARTATI,DATA_ULT_MOD,UTENTE_ULT_MOD,UTENTE_CARICAMENTO ");
		sql.append(" FROM SIGIT_T_IMPORT_DISTRIB");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R102476266) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("FK_STATO_DISTRIB = " + Constants.ID_STATO_IMP_DISTRIBUTORE_DA_ELABORARE);

		sql.append(" ORDER BY ID_IMPORT_DISTRIB");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-993316800) ENABLED START*/
		//***aggiungere tutte le condizioni

		/*PROTECTED REGION END*/
		List<SigitTImportDistribDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, daElaborareRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTImportDistribDaoImpl::findDaElaborare] esecuzione query", ex);
			throw new SigitTImportDistribDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImportDistribDaoImpl", "findDaElaborare", "esecuzione query", sql.toString());
			LOG.debug("[SigitTImportDistribDaoImpl::findDaElaborare] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_T_IMPORT_DISTRIB table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTImportDistribDto findByPrimaryKey(SigitTImportDistribPk pk) throws SigitTImportDistribDaoException {
		LOG.debug("[SigitTImportDistribDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_IMPORT_DISTRIB,FK_PERSONA_GIURIDICA,FK_STATO_DISTRIB,DATA_INIZIO_ELAB,DATA_FINE_ELAB,DATA_ANNULLAMENTO,NOME_FILE_IMPORT,UID_INDEX,ANNO_RIFERIMENTO,DATA_INVIO_MAIL_DISTRIB,DATA_INVIO_MAIL_ASSISTENZA,TOT_RECORD_ELABORATI,TOT_RECORD_SCARTATI,DATA_ULT_MOD,UTENTE_ULT_MOD,UTENTE_CARICAMENTO FROM "
						+ getTableName() + " WHERE ID_IMPORT_DISTRIB = :ID_IMPORT_DISTRIB ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_IMPORT_DISTRIB]
		params.addValue("ID_IMPORT_DISTRIB", pk.getIdImportDistrib(), java.sql.Types.INTEGER);

		List<SigitTImportDistribDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTImportDistribDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTImportDistribDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImportDistribDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTImportDistribDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder daInviareMailAssistenza
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTImportDistribDto> findDaInviareMailAssistenza(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDistribDto input)
			throws SigitTImportDistribDaoException {
		LOG.debug("[SigitTImportDistribDaoImpl::findDaInviareMailAssistenza] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMPORT_DISTRIB,FK_PERSONA_GIURIDICA,FK_STATO_DISTRIB,DATA_INIZIO_ELAB,DATA_FINE_ELAB,DATA_ANNULLAMENTO,NOME_FILE_IMPORT,UID_INDEX,ANNO_RIFERIMENTO,DATA_INVIO_MAIL_DISTRIB,DATA_INVIO_MAIL_ASSISTENZA,TOT_RECORD_ELABORATI,TOT_RECORD_SCARTATI,DATA_ULT_MOD,UTENTE_ULT_MOD,UTENTE_CARICAMENTO ");
		sql.append(" FROM SIGIT_T_IMPORT_DISTRIB");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1728789095) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("FK_STATO_DISTRIB IN (" + Constants.ID_STATO_IMP_DISTRIBUTORE_INVIATO + ","
				+ Constants.ID_STATO_IMP_DISTRIBUTORE_RIFIUTATO + ")");
		sql.append(" AND DATA_INVIO_MAIL_ASSISTENZA IS NULL ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-2117226653) ENABLED START*/
		//***aggiungere tutte le condizioni

		/*PROTECTED REGION END*/
		List<SigitTImportDistribDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, daInviareMailAssistenzaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTImportDistribDaoImpl::findDaInviareMailAssistenza] esecuzione query", ex);
			throw new SigitTImportDistribDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImportDistribDaoImpl", "findDaInviareMailAssistenza", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTImportDistribDaoImpl::findDaInviareMailAssistenza] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder ricevutaByIdImportDistrib con Qdef
		 * @generated
		 */

	public List<SigitTImportDistribRicevutaByIdImportDistribDto> findRicevutaByIdImportDistrib(java.lang.Integer input)
			throws SigitTImportDistribDaoException {
		LOG.debug("[SigitTImportDistribDaoImpl::findRicevutaByIdImportDistrib] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT id.ID_IMPORT_DISTRIB, id.DATA_INIZIO_ELAB, id.DATA_FINE_ELAB, id.NOME_FILE_IMPORT, id.ANNO_RIFERIMENTO, id.DATA_ANNULLAMENTO, sd.DES_STATO_DISTRIB, pg.SIGLA_REA, pg.NUMERO_REA, pg.COMUNE, pg.SIGLA_PROV, pg.INDIRIZZO_SITAD, pg.INDIRIZZO_NON_TROVATO, pg.CIVICO, pg.DENOMINAZIONE, pg.CODICE_FISCALE");

		sql.append(" FROM SIGIT_T_IMPORT_DISTRIB id, SIGIT_D_STATO_DISTRIB sd, SIGIT_T_PERSONA_GIURIDICA pg");

		sql.append(" WHERE ");

		sql.append("id.FK_STATO_DISTRIB = sd.ID_STATO_DISTRIB AND id.FK_PERSONA_GIURIDICA = pg.ID_PERSONA_GIURIDICA");

		sql.append(" AND ");

		sql.append("id.ID_IMPORT_DISTRIB = :idImportDistrib");
		/*PROTECTED REGION ID(R-1241123123) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idImportDistrib", input);

		/*PROTECTED REGION END*/

		List<SigitTImportDistribRicevutaByIdImportDistribDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ricevutaByIdImportDistribRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTImportDistribDaoImpl::findRicevutaByIdImportDistrib] ERROR esecuzione query", ex);
			throw new SigitTImportDistribDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImportDistribDaoImpl", "findRicevutaByIdImportDistrib", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTImportDistribDaoImpl::findRicevutaByIdImportDistrib] END");
		}
		return list;
	}

}
