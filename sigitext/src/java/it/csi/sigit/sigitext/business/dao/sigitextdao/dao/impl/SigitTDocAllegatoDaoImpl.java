package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTDocAllegatoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTDocAllegatoDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAllegatoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAllegatoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDocAllegatoDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;

/*PROTECTED REGION ID(R-1967922705) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTDocAllegato.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byIdAllegato (datagen::CustomFinder)
  * - UPDATERS:
 *   - aggiornaNomeUid (datagen::UpdateColumns)
 *   - aggiornaEliminaDoc (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *   - byIdAllegatoDel (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTDocAllegatoDaoImpl extends AbstractDAO implements SigitTDocAllegatoDao {
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
	 * Metodo di inserimento del DAO sigitTDocAllegato. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDocAllegatoPk
	 * @generated
	 */

	public SigitTDocAllegatoPk insert(SigitTDocAllegatoDto dto)

	{
		LOG.debug("[SigitTDocAllegatoDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_DOC_ALLEGATO,FK_ALLEGATO,NOME_DOC_ORIGINALE,NOME_DOC,UID_INDEX,DESCRIZIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_UPLOAD,DATA_DELETE ) VALUES (  :ID_DOC_ALLEGATO , :FK_ALLEGATO , :NOME_DOC_ORIGINALE , :NOME_DOC , :UID_INDEX , :DESCRIZIONE , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :DATA_UPLOAD , :DATA_DELETE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DOC_ALLEGATO]
		params.addValue("ID_DOC_ALLEGATO", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ALLEGATO]
		params.addValue("FK_ALLEGATO", dto.getFkAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [NOME_DOC_ORIGINALE]
		params.addValue("NOME_DOC_ORIGINALE", dto.getNomeDocOriginale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOME_DOC]
		params.addValue("NOME_DOC", dto.getNomeDoc(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX]
		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DESCRIZIONE]
		params.addValue("DESCRIZIONE", dto.getDescrizione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_UPLOAD]
		params.addValue("DATA_UPLOAD", dto.getDataUpload(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_DELETE]
		params.addValue("DATA_DELETE", dto.getDataDelete(), java.sql.Types.TIMESTAMP);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdDocAllegato(newKey);
		LOG.debug("[SigitTDocAllegatoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the SIGIT_T_DOC_ALLEGATO table.
	 * @generated
	 */
	public void updateColumnsAggiornaNomeUid(SigitTDocAllegatoDto dto) throws SigitTDocAllegatoDaoException {
		LOG.debug("[SigitTDocAllegatoDaoImpl::updateColumnsAggiornaNomeUid] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET NOME_DOC = :NOME_DOC ,UID_INDEX = :UID_INDEX  WHERE ID_DOC_ALLEGATO = :ID_DOC_ALLEGATO ";

		if (dto.getIdDocAllegato() == null) {
			LOG.error("[SigitTDocAllegatoDaoImpl::updateColumnsAggiornaNomeUid] ERROR chiave primaria non impostata");
			throw new SigitTDocAllegatoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [NOME_DOC]
		params.addValue("NOME_DOC", dto.getNomeDoc(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX]
		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_DOC_ALLEGATO]
		params.addValue("ID_DOC_ALLEGATO", dto.getIdDocAllegato(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDocAllegatoDaoImpl::updateColumnsAggiornaNomeUid] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_DOC_ALLEGATO table.
	 * @generated
	 */
	public void updateColumnsAggiornaEliminaDoc(SigitTDocAllegatoDto dto) throws SigitTDocAllegatoDaoException {
		LOG.debug("[SigitTDocAllegatoDaoImpl::updateColumnsAggiornaEliminaDoc] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DATA_ULT_MOD = :DATA_ULT_MOD ,DATA_DELETE = :DATA_DELETE  WHERE ID_DOC_ALLEGATO = :ID_DOC_ALLEGATO ";

		if (dto.getIdDocAllegato() == null) {
			LOG.error(
					"[SigitTDocAllegatoDaoImpl::updateColumnsAggiornaEliminaDoc] ERROR chiave primaria non impostata");
			throw new SigitTDocAllegatoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_DELETE]
		params.addValue("DATA_DELETE", dto.getDataDelete(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [ID_DOC_ALLEGATO]
		params.addValue("ID_DOC_ALLEGATO", dto.getIdDocAllegato(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDocAllegatoDaoImpl::updateColumnsAggiornaEliminaDoc] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_DOC_ALLEGATO table.
	 * @generated
	 */

	public void delete(SigitTDocAllegatoPk pk) throws SigitTDocAllegatoDaoException {
		LOG.debug("[SigitTDocAllegatoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_DOC_ALLEGATO = :ID_DOC_ALLEGATO ";

		if (pk == null) {
			LOG.error("[SigitTDocAllegatoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTDocAllegatoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DOC_ALLEGATO]
		params.addValue("ID_DOC_ALLEGATO", pk.getIdDocAllegato(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDocAllegatoDaoImpl::delete] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_DOC_ALLEGATO table.
	 * @generated
	 */
	public void customDeleterByIdAllegatoDel(java.math.BigDecimal filter) throws SigitTDocAllegatoDaoException {
		LOG.debug("[SigitTDocAllegatoDaoImpl::customDeleterByIdAllegatoDel] START");
		/*PROTECTED REGION ID(R707298753) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE FK_ALLEGATO = :idAllegato";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idAllegato", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDocAllegatoDaoImpl::customDeleterByIdAllegatoDel] END");
	}

	protected SigitTDocAllegatoDaoRowMapper findByPrimaryKeyRowMapper = new SigitTDocAllegatoDaoRowMapper(null,
			SigitTDocAllegatoDto.class, this);

	protected SigitTDocAllegatoDaoRowMapper byIdAllegatoRowMapper = new SigitTDocAllegatoDaoRowMapper(null,
			SigitTDocAllegatoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DOC_ALLEGATO";
	}

	/** 
	 * Returns all rows from the SIGIT_T_DOC_ALLEGATO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTDocAllegatoDto findByPrimaryKey(SigitTDocAllegatoPk pk) throws SigitTDocAllegatoDaoException {
		LOG.debug("[SigitTDocAllegatoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_DOC_ALLEGATO,FK_ALLEGATO,NOME_DOC_ORIGINALE,NOME_DOC,UID_INDEX,DESCRIZIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_UPLOAD,DATA_DELETE FROM "
						+ getTableName() + " WHERE ID_DOC_ALLEGATO = :ID_DOC_ALLEGATO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DOC_ALLEGATO]
		params.addValue("ID_DOC_ALLEGATO", pk.getIdDocAllegato(), java.sql.Types.INTEGER);

		List<SigitTDocAllegatoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTDocAllegatoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTDocAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDocAllegatoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDocAllegatoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDocAllegatoDto> findByIdAllegato(Integer input) throws SigitTDocAllegatoDaoException {
		LOG.debug("[SigitTDocAllegatoDaoImpl::findByIdAllegato] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_DOC_ALLEGATO,FK_ALLEGATO,NOME_DOC_ORIGINALE,NOME_DOC,UID_INDEX,DESCRIZIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_UPLOAD,DATA_DELETE ");
		sql.append(" FROM SIGIT_T_DOC_ALLEGATO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-888896904) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" FK_ALLEGATO = :idAllegato ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-905436470) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idAllegato", input);

		/*PROTECTED REGION END*/
		List<SigitTDocAllegatoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAllegatoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTDocAllegatoDaoImpl::findByIdAllegato] esecuzione query", ex);
			throw new SigitTDocAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDocAllegatoDaoImpl", "findByIdAllegato", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDocAllegatoDaoImpl::findByIdAllegato] END");
		}
		return list;
	}
	
	@Override
	public SigitTDocAllegatoDto findByUidIndex(String uidIndex) throws SigitTDocAllegatoDaoException {
		LOG.debug("[SigitTDocAllegatoDaoImpl::findByUidIndex] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_DOC_ALLEGATO,FK_ALLEGATO,NOME_DOC_ORIGINALE,NOME_DOC,UID_INDEX,DESCRIZIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_UPLOAD,DATA_DELETE ");
		sql.append(" FROM SIGIT_T_DOC_ALLEGATO");
		sql.append(" WHERE ");
		sql.append(" UID_INDEX = :uidIndex ");

		paramMap.addValue("uidIndex", uidIndex);

		/*PROTECTED REGION END*/
		List<SigitTDocAllegatoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAllegatoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTDocAllegatoDaoImpl::findByUidIndex] esecuzione query", ex);
			throw new SigitTDocAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDocAllegatoDaoImpl", "findByUidIndex", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDocAllegatoDaoImpl::findByUidIndex] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}
	
	public void delete(BigDecimal idAllegato) throws SigitTDocAllegatoDaoException {

		LOG.debug("[SigitTDocAllegatoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE FK_ALLEGATO = :ID_ALLEGATO ";
		if (idAllegato == null) {
			LOG.error("[SigitTDocAllegatoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTDocAllegatoDaoException("Chiave primaria non impostata");
		}
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ID_ALLEGATO", idAllegato, java.sql.Types.NUMERIC);
		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDocAllegatoDaoImpl::delete] END");
		
	}

}
