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

/*PROTECTED REGION ID(R-1303128049) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTAzioneContratto.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findAll (datagen::FindAll)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTAzioneContrattoDaoImpl extends AbstractDAO implements SigitTAzioneContrattoDao {
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
	 * Metodo di inserimento del DAO sigitTAzioneContratto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAzioneContrattoPk
	 * @generated
	 */

	public SigitTAzioneContrattoPk insert(SigitTAzioneContrattoDto dto)

	{
		LOG.debug("[SigitTAzioneContrattoDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_CONTRATTO,DT_AZIONE,CF_UTENTE_AZIONE,DESCRIZIONE_AZIONE,OLD_DATA_FINE ) VALUES (  :ID_CONTRATTO , :DT_AZIONE , :CF_UTENTE_AZIONE , :DESCRIZIONE_AZIONE , :OLD_DATA_FINE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONTRATTO]
		params.addValue("ID_CONTRATTO", dto.getIdContratto(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DT_AZIONE]
		params.addValue("DT_AZIONE", dto.getDtAzione(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [CF_UTENTE_AZIONE]
		params.addValue("CF_UTENTE_AZIONE", dto.getCfUtenteAzione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DESCRIZIONE_AZIONE]
		params.addValue("DESCRIZIONE_AZIONE", dto.getDescrizioneAzione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [OLD_DATA_FINE]
		params.addValue("OLD_DATA_FINE", dto.getOldDataFine(), java.sql.Types.DATE);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTAzioneContrattoDaoImpl::insert] END");
		return dto.createPk();

	}

	protected SigitTAzioneContrattoDaoRowMapper findAllRowMapper = new SigitTAzioneContrattoDaoRowMapper(null,
			SigitTAzioneContrattoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_AZIONE_CONTRATTO";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_AZIONE_CONTRATTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAzioneContrattoDto> findAll() throws SigitTAzioneContrattoDaoException {
		LOG.debug("[SigitTAzioneContrattoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_CONTRATTO,DT_AZIONE,CF_UTENTE_AZIONE,DESCRIZIONE_AZIONE,OLD_DATA_FINE FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTAzioneContrattoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTAzioneContrattoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitTAzioneContrattoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAzioneContrattoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitTAzioneContrattoDaoImpl::findAll] END");
		}
		return list;
	}

}
