package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTImportXmlLibDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTImportXmlLibDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportXmlLibDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportXmlLibPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTImportXmlLibDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R1209344831) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTImportXmlLib.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTImportXmlLibDaoImpl extends AbstractDAO implements SigitTImportXmlLibDao {
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
	 * Metodo di inserimento del DAO sigitTImportXmlLib. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTImportXmlLibPk
	 * @generated
	 */

	public SigitTImportXmlLibPk insert(SigitTImportXmlLibDto dto)

	{
		LOG.debug("[SigitTImportXmlLibDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_IMPIANTO,XML_LIBRETTO,DATA_ULT_MOD,UTENTE_ULT_MOD ) VALUES (  :CODICE_IMPIANTO , :XML_LIBRETTO , :DATA_ULT_MOD , :UTENTE_ULT_MOD  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [XML_LIBRETTO]
		params.addValue("XML_LIBRETTO", dto.getXmlLibretto(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTImportXmlLibDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_IMPORT_XML_LIB table.
	 * @generated
	 */
	public void update(SigitTImportXmlLibDto dto) throws SigitTImportXmlLibDaoException {
		LOG.debug("[SigitTImportXmlLibDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET XML_LIBRETTO = :XML_LIBRETTO ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD  WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (dto.getCodiceImpianto() == null) {
			LOG.error("[SigitTImportXmlLibDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTImportXmlLibDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [XML_LIBRETTO]
		params.addValue("XML_LIBRETTO", dto.getXmlLibretto(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTImportXmlLibDaoImpl::update] END");
	}

	protected SigitTImportXmlLibDaoRowMapper findByPrimaryKeyRowMapper = new SigitTImportXmlLibDaoRowMapper(null,
			SigitTImportXmlLibDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_IMPORT_XML_LIB";
	}

	/** 
	 * Returns all rows from the SIGIT_T_IMPORT_XML_LIB table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTImportXmlLibDto findByPrimaryKey(SigitTImportXmlLibPk pk) throws SigitTImportXmlLibDaoException {
		LOG.debug("[SigitTImportXmlLibDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT CODICE_IMPIANTO,XML_LIBRETTO,DATA_ULT_MOD,UTENTE_ULT_MOD FROM " + getTableName()
						+ " WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		List<SigitTImportXmlLibDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTImportXmlLibDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTImportXmlLibDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImportXmlLibDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTImportXmlLibDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
