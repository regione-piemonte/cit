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

/*PROTECTED REGION ID(R215645713) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTDocContratto.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByExample (datagen::CustomFinder)
  * - UPDATERS:
 *   - aggiornaNomeUid (datagen::UpdateColumns)
 *   - aggiornaPerEliminazione (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTDocContrattoDaoImpl extends AbstractDAO implements SigitTDocContrattoDao {
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
	 * Metodo di inserimento del DAO sigitTDocContratto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDocContrattoPk
	 * @generated
	 */

	public SigitTDocContrattoPk insert(SigitTDocContrattoDto dto)

	{
		LOG.debug("[SigitTDocContrattoDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_DOC_CONTRATTO,FK_CONTRATTO,NOME_DOC_ORIGINALE,NOME_DOC,DESCRIZIONE,DATA_UPLOAD,DATA_DELETE,UID_INDEX,DATA_ULT_MOD,UTENTE_ULT_MOD ) VALUES (  :ID_DOC_CONTRATTO , :FK_CONTRATTO , :NOME_DOC_ORIGINALE , :NOME_DOC , :DESCRIZIONE , :DATA_UPLOAD , :DATA_DELETE , :UID_INDEX , :DATA_ULT_MOD , :UTENTE_ULT_MOD  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DOC_CONTRATTO]
		params.addValue("ID_DOC_CONTRATTO", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_CONTRATTO]
		params.addValue("FK_CONTRATTO", dto.getFkContratto(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOME_DOC_ORIGINALE]
		params.addValue("NOME_DOC_ORIGINALE", dto.getNomeDocOriginale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOME_DOC]
		params.addValue("NOME_DOC", dto.getNomeDoc(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DESCRIZIONE]
		params.addValue("DESCRIZIONE", dto.getDescrizione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_UPLOAD]
		params.addValue("DATA_UPLOAD", dto.getDataUpload(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_DELETE]
		params.addValue("DATA_DELETE", dto.getDataDelete(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UID_INDEX]
		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdDocContratto(newKey);
		LOG.debug("[SigitTDocContrattoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the SIGIT_T_DOC_CONTRATTO table.
	 * @generated
	 */
	public void updateColumnsAggiornaNomeUid(SigitTDocContrattoDto dto) throws SigitTDocContrattoDaoException {
		LOG.debug("[SigitTDocContrattoDaoImpl::updateColumnsAggiornaNomeUid] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET NOME_DOC = :NOME_DOC ,UID_INDEX = :UID_INDEX  WHERE ID_DOC_CONTRATTO = :ID_DOC_CONTRATTO ";

		if (dto.getIdDocContratto() == null) {
			LOG.error("[SigitTDocContrattoDaoImpl::updateColumnsAggiornaNomeUid] ERROR chiave primaria non impostata");
			throw new SigitTDocContrattoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [NOME_DOC]
		params.addValue("NOME_DOC", dto.getNomeDoc(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX]
		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_DOC_CONTRATTO]
		params.addValue("ID_DOC_CONTRATTO", dto.getIdDocContratto(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDocContrattoDaoImpl::updateColumnsAggiornaNomeUid] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_DOC_CONTRATTO table.
	 * @generated
	 */
	public void updateColumnsAggiornaPerEliminazione(SigitTDocContrattoDto dto) throws SigitTDocContrattoDaoException {
		LOG.debug("[SigitTDocContrattoDaoImpl::updateColumnsAggiornaPerEliminazione] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DATA_DELETE = :DATA_DELETE ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD  WHERE ID_DOC_CONTRATTO = :ID_DOC_CONTRATTO ";

		if (dto.getIdDocContratto() == null) {
			LOG.error(
					"[SigitTDocContrattoDaoImpl::updateColumnsAggiornaPerEliminazione] ERROR chiave primaria non impostata");
			throw new SigitTDocContrattoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DATA_DELETE]
		params.addValue("DATA_DELETE", dto.getDataDelete(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_DOC_CONTRATTO]
		params.addValue("ID_DOC_CONTRATTO", dto.getIdDocContratto(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDocContrattoDaoImpl::updateColumnsAggiornaPerEliminazione] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_DOC_CONTRATTO table.
	 * @generated
	 */

	public void delete(SigitTDocContrattoPk pk) throws SigitTDocContrattoDaoException {
		LOG.debug("[SigitTDocContrattoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_DOC_CONTRATTO = :ID_DOC_CONTRATTO ";

		if (pk == null) {
			LOG.error("[SigitTDocContrattoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTDocContrattoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DOC_CONTRATTO]
		params.addValue("ID_DOC_CONTRATTO", pk.getIdDocContratto(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDocContrattoDaoImpl::delete] END");
	}

	protected SigitTDocContrattoDaoRowMapper findByExampleRowMapper = new SigitTDocContrattoDaoRowMapper(null,
			SigitTDocContrattoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DOC_CONTRATTO";
	}

	/** 
	 * Implementazione del finder findByExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDocContrattoDto> findFindByExample(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocContrattoDto input)
			throws SigitTDocContrattoDaoException {
		LOG.debug("[SigitTDocContrattoDaoImpl::findFindByExample] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_DOC_CONTRATTO,FK_CONTRATTO,NOME_DOC_ORIGINALE,NOME_DOC,DESCRIZIONE,DATA_UPLOAD,DATA_DELETE,UID_INDEX,DATA_ULT_MOD,UTENTE_ULT_MOD ");
		sql.append(" FROM SIGIT_T_DOC_CONTRATTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-576754188) ENABLED START*/
		sql.append(" 1 = 1 ");

		//cerca in base all'id di contratto
		if (input.getFkContratto() != null) {
			sql.append(" AND  FK_CONTRATTO = :idContratto ");
			paramMap.addValue("idContratto", input.getFkContratto());
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R181053134) ENABLED START*/
		//***aggiungere tutte le condizioni

		/*PROTECTED REGION END*/
		List<SigitTDocContrattoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByExampleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTDocContrattoDaoImpl::findFindByExample] esecuzione query", ex);
			throw new SigitTDocContrattoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDocContrattoDaoImpl", "findFindByExample", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDocContrattoDaoImpl::findFindByExample] END");
		}
		return list;
	}

}
