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

/*PROTECTED REGION ID(R1565891823) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTDocAggiuntiva.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byCodImpIdTipoDocAgg (datagen::CustomFinder)
 *   - byCodImp (datagen::CustomFinder)
 *   - byCodImpDecod (datagen::CustomFinder)
  * - UPDATERS:
 *   - aggiornaNomeUid (datagen::UpdateColumns)
 *   - aggiornaEliminaDoc (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *   - byIdIspezione (datagen::CustomDeleter)
 *   - byCodImpDel (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTDocAggiuntivaDaoImpl extends AbstractDAO implements SigitTDocAggiuntivaDao {
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
	 * Metodo di inserimento del DAO sigitTDocAggiuntiva. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDocAggiuntivaPk
	 * @generated
	 */

	public SigitTDocAggiuntivaPk insert(SigitTDocAggiuntivaDto dto)

	{
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_DOC_AGGIUNTIVA,CODICE_IMPIANTO,FK_TIPO_DOCAGG,NOME_DOC_ORIGINALE,NOME_DOC,UID_INDEX,DES_ALTRO_TIPODOC,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_UPLOAD,DATA_DELETE ) VALUES (  :ID_DOC_AGGIUNTIVA , :CODICE_IMPIANTO , :FK_TIPO_DOCAGG , :NOME_DOC_ORIGINALE , :NOME_DOC , :UID_INDEX , :DES_ALTRO_TIPODOC , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :DATA_UPLOAD , :DATA_DELETE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DOC_AGGIUNTIVA]
		params.addValue("ID_DOC_AGGIUNTIVA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_DOCAGG]
		params.addValue("FK_TIPO_DOCAGG", dto.getFkTipoDocagg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [NOME_DOC_ORIGINALE]
		params.addValue("NOME_DOC_ORIGINALE", dto.getNomeDocOriginale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOME_DOC]
		params.addValue("NOME_DOC", dto.getNomeDoc(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX]
		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DES_ALTRO_TIPODOC]
		params.addValue("DES_ALTRO_TIPODOC", dto.getDesAltroTipodoc(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_UPLOAD]
		params.addValue("DATA_UPLOAD", dto.getDataUpload(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_DELETE]
		params.addValue("DATA_DELETE", dto.getDataDelete(), java.sql.Types.TIMESTAMP);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdDocAggiuntiva(newKey);
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the SIGIT_T_DOC_AGGIUNTIVA table.
	 * @generated
	 */
	public void updateColumnsAggiornaNomeUid(SigitTDocAggiuntivaDto dto) throws SigitTDocAggiuntivaDaoException {
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::updateColumnsAggiornaNomeUid] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET NOME_DOC = :NOME_DOC ,UID_INDEX = :UID_INDEX  WHERE ID_DOC_AGGIUNTIVA = :ID_DOC_AGGIUNTIVA ";

		if (dto.getIdDocAggiuntiva() == null) {
			LOG.error("[SigitTDocAggiuntivaDaoImpl::updateColumnsAggiornaNomeUid] ERROR chiave primaria non impostata");
			throw new SigitTDocAggiuntivaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [NOME_DOC]
		params.addValue("NOME_DOC", dto.getNomeDoc(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX]
		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_DOC_AGGIUNTIVA]
		params.addValue("ID_DOC_AGGIUNTIVA", dto.getIdDocAggiuntiva(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::updateColumnsAggiornaNomeUid] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_DOC_AGGIUNTIVA table.
	 * @generated
	 */
	public void updateColumnsAggiornaEliminaDoc(SigitTDocAggiuntivaDto dto) throws SigitTDocAggiuntivaDaoException {
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::updateColumnsAggiornaEliminaDoc] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DATA_ULT_MOD = :DATA_ULT_MOD ,DATA_DELETE = :DATA_DELETE  WHERE ID_DOC_AGGIUNTIVA = :ID_DOC_AGGIUNTIVA ";

		if (dto.getIdDocAggiuntiva() == null) {
			LOG.error(
					"[SigitTDocAggiuntivaDaoImpl::updateColumnsAggiornaEliminaDoc] ERROR chiave primaria non impostata");
			throw new SigitTDocAggiuntivaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_DELETE]
		params.addValue("DATA_DELETE", dto.getDataDelete(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [ID_DOC_AGGIUNTIVA]
		params.addValue("ID_DOC_AGGIUNTIVA", dto.getIdDocAggiuntiva(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::updateColumnsAggiornaEliminaDoc] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_DOC_AGGIUNTIVA table.
	 * @generated
	 */

	public void delete(SigitTDocAggiuntivaPk pk) throws SigitTDocAggiuntivaDaoException {
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_DOC_AGGIUNTIVA = :ID_DOC_AGGIUNTIVA ";

		if (pk == null) {
			LOG.error("[SigitTDocAggiuntivaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTDocAggiuntivaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DOC_AGGIUNTIVA]
		params.addValue("ID_DOC_AGGIUNTIVA", pk.getIdDocAggiuntiva(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::delete] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_DOC_AGGIUNTIVA table.
	 * @generated
	 */
	public void customDeleterByIdIspezione(java.math.BigDecimal filter) throws SigitTDocAggiuntivaDaoException {
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::customDeleterByIdIspezione] START");
		/*PROTECTED REGION ID(R-785206269) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE FK_IMP_RUOLO_PFPG = :idIspezione";
		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("idIspezione", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::customDeleterByIdIspezione] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_DOC_AGGIUNTIVA table.
	 * @generated
	 */
	public void customDeleterByCodImpDel(java.lang.Integer filter) throws SigitTDocAggiuntivaDaoException {
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::customDeleterByCodImpDel] START");
		/*PROTECTED REGION ID(R-947342263) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::customDeleterByCodImpDel] END");
	}

	protected SigitTDocAggiuntivaDaoRowMapper findByPrimaryKeyRowMapper = new SigitTDocAggiuntivaDaoRowMapper(null,
			SigitTDocAggiuntivaDto.class, this);

	protected SigitTDocAggiuntivaDaoRowMapper byCodImpIdTipoDocAggRowMapper = new SigitTDocAggiuntivaDaoRowMapper(null,
			SigitTDocAggiuntivaDto.class, this);

	protected SigitTDocAggiuntivaDaoRowMapper byCodImpRowMapper = new SigitTDocAggiuntivaDaoRowMapper(null,
			SigitTDocAggiuntivaDto.class, this);

	protected SigitTDocAggiuntivaDaoRowMapper byCodImpDecodRowMapper = new SigitTDocAggiuntivaDaoRowMapper(null,
			SigitTDocAggiuntivaByCodImpDecodDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DOC_AGGIUNTIVA";
	}

	/** 
	 * Returns all rows from the SIGIT_T_DOC_AGGIUNTIVA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTDocAggiuntivaDto findByPrimaryKey(SigitTDocAggiuntivaPk pk) throws SigitTDocAggiuntivaDaoException {
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_DOC_AGGIUNTIVA,CODICE_IMPIANTO,FK_TIPO_DOCAGG,NOME_DOC_ORIGINALE,NOME_DOC,UID_INDEX,DES_ALTRO_TIPODOC,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_UPLOAD,DATA_DELETE FROM "
						+ getTableName() + " WHERE ID_DOC_AGGIUNTIVA = :ID_DOC_AGGIUNTIVA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DOC_AGGIUNTIVA]
		params.addValue("ID_DOC_AGGIUNTIVA", pk.getIdDocAggiuntiva(), java.sql.Types.INTEGER);

		List<SigitTDocAggiuntivaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTDocAggiuntivaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTDocAggiuntivaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDocAggiuntivaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDocAggiuntivaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byCodImpIdTipoDocAgg
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDocAggiuntivaDto> findByCodImpIdTipoDocAgg(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocAggiuntivaDto input)
			throws SigitTDocAggiuntivaDaoException {
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::findByCodImpIdTipoDocAgg] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_DOC_AGGIUNTIVA,CODICE_IMPIANTO,FK_TIPO_DOCAGG,NOME_DOC_ORIGINALE,NOME_DOC,UID_INDEX,DES_ALTRO_TIPODOC,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_UPLOAD,DATA_DELETE ");
		sql.append(" FROM SIGIT_T_DOC_AGGIUNTIVA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1754173928) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_IMPIANTO = :codImpianto ");
		sql.append(" AND FK_TIPO_DOCAGG = :idTipoDocAgg ");
		sql.append(" AND DATA_DELETE IS NULL");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1959220438) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodiceImpianto());
		paramMap.addValue("idTipoDocAgg", input.getFkTipoDocagg());

		/*PROTECTED REGION END*/
		List<SigitTDocAggiuntivaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpIdTipoDocAggRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTDocAggiuntivaDaoImpl::findByCodImpIdTipoDocAgg] esecuzione query", ex);
			throw new SigitTDocAggiuntivaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDocAggiuntivaDaoImpl", "findByCodImpIdTipoDocAgg", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTDocAggiuntivaDaoImpl::findByCodImpIdTipoDocAgg] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodImp
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDocAggiuntivaDto> findByCodImp(java.lang.Integer input) throws SigitTDocAggiuntivaDaoException {
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::findByCodImp] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_DOC_AGGIUNTIVA,CODICE_IMPIANTO,FK_TIPO_DOCAGG,NOME_DOC_ORIGINALE,NOME_DOC,UID_INDEX,DES_ALTRO_TIPODOC,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_UPLOAD,DATA_DELETE ");
		sql.append(" FROM SIGIT_T_DOC_AGGIUNTIVA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R2067497600) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_IMPIANTO = :codImpianto ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R548479938) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitTDocAggiuntivaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTDocAggiuntivaDaoImpl::findByCodImp] esecuzione query", ex);
			throw new SigitTDocAggiuntivaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDocAggiuntivaDaoImpl", "findByCodImp", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDocAggiuntivaDaoImpl::findByCodImp] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byCodImpDecod con Qdef
		 * @generated
		 */

	public List<SigitTDocAggiuntivaByCodImpDecodDto> findByCodImpDecod(java.lang.Integer input)
			throws SigitTDocAggiuntivaDaoException {
		LOG.debug("[SigitTDocAggiuntivaDaoImpl::findByCodImpDecod] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT doc.ID_DOC_AGGIUNTIVA, doc.UID_INDEX, doc.NOME_DOC_ORIGINALE, doc.DES_ALTRO_TIPODOC, tipodoc.DES_TIPO_DOC_AGG, doc.DATA_UPLOAD, doc.DATA_DELETE");

		sql.append(" FROM SIGIT_T_DOC_AGGIUNTIVA doc, SIGIT_D_TIPO_DOC_AGG tipodoc");

		sql.append(" WHERE ");

		sql.append("doc.FK_TIPO_DOCAGG = tipodoc.ID_TIPO_DOC_AGG");

		sql.append(" AND ");

		sql.append("doc.CODICE_IMPIANTO = :codiceImpianto");
		/*PROTECTED REGION ID(R648771621) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" ORDER BY doc.DATA_ULT_MOD ");

		paramMap.addValue("codiceImpianto", input);

		/*PROTECTED REGION END*/

		List<SigitTDocAggiuntivaByCodImpDecodDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpDecodRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTDocAggiuntivaDaoImpl::findByCodImpDecod] ERROR esecuzione query", ex);
			throw new SigitTDocAggiuntivaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDocAggiuntivaDaoImpl", "findByCodImpDecod", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTDocAggiuntivaDaoImpl::findByCodImpDecod] END");
		}
		return list;
	}

}
