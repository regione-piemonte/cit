package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTStoricoVariazStatoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTStoricoVariazStatoDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTStoricoVariazStatoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTStoricoVariazStatoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTStoricoVariazStatoDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R1476748867) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTStoricoVariazStato.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER:
 * - (insert di default)
 * - FINDERS:
 * - findByCodiceImpianto (datagen::CustomFinder)
 * - UPDATERS:
 * <p>
 * --
 * - DELETERS:
 * - byCodiceImpianto (datagen::CustomDeleter)
 * <p>
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 *
 * @generated
 */
public class SigitTStoricoVariazStatoDaoImpl extends AbstractDAO implements SigitTStoricoVariazStatoDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	/**
	 * Il DAO utilizza JDBC template per l'implementazione delle query.
	 *
	 * @generated
	 */
	protected NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 *
	 * @generated
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Metodo di inserimento del DAO sigitTStoricoVariazStato. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 *
	 * @param dto
	 * @return SigitTStoricoVariazStatoPk
	 * @generated
	 */

	public SigitTStoricoVariazStatoPk insert(SigitTStoricoVariazStatoDto dto) {
		LOG.debug("[SigitTStoricoVariazStatoDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_IMPIANTO,DT_EVENTO,DT_INIZIO_VARIAZIONE,MOTIVO,STATO_DA,STATO_A,DATA_ULT_MOD,UTENTE_ULT_MOD ) VALUES (  :CODICE_IMPIANTO , :DT_EVENTO , :DT_INIZIO_VARIAZIONE , :MOTIVO , :STATO_DA , :STATO_A , :DATA_ULT_MOD , :UTENTE_ULT_MOD  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_EVENTO]
		params.addValue("DT_EVENTO", dto.getDtEvento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DT_INIZIO_VARIAZIONE]
		params.addValue("DT_INIZIO_VARIAZIONE", dto.getDtInizioVariazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [MOTIVO]
		params.addValue("MOTIVO", dto.getMotivo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [STATO_DA]
		params.addValue("STATO_DA", dto.getStatoDa(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [STATO_A]
		params.addValue("STATO_A", dto.getStatoA(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTStoricoVariazStatoDaoImpl::insert] END");
		return dto.createPk();

	}

	/**
	 * Custom deleter in the SIGIT_T_STORICO_VARIAZ_STATO table.
	 *
	 * @generated
	 */
	public void customDeleterByCodiceImpianto(Integer filter) throws SigitTStoricoVariazStatoDaoException {
		LOG.debug("[SigitTStoricoVariazStatoDaoImpl::customDeleterByCodiceImpianto] START");
		/*PROTECTED REGION ID(R-2121884950) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTStoricoVariazStatoDaoImpl::customDeleterByCodiceImpianto] END");
	}

	protected SigitTStoricoVariazStatoDaoRowMapper findByCodiceImpiantoRowMapper = new SigitTStoricoVariazStatoDaoRowMapper(null, SigitTStoricoVariazStatoDto.class, this);

	/**
	 * Restituisce il nome della tabella su cui opera il DAO
	 *
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_STORICO_VARIAZ_STATO";
	}

	/**
	 * Implementazione del finder findByCodiceImpianto
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTStoricoVariazStatoDto> findFindByCodiceImpianto(Integer input) throws SigitTStoricoVariazStatoDaoException {
		LOG.debug("[SigitTStoricoVariazStatoDaoImpl::findFindByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT CODICE_IMPIANTO,DT_EVENTO,DT_INIZIO_VARIAZIONE,MOTIVO,STATO_DA,STATO_A,DATA_ULT_MOD,UTENTE_ULT_MOD ");
		sql.append(" FROM SIGIT_T_STORICO_VARIAZ_STATO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-718515613) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("CODICE_IMPIANTO = :codice");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R81416255) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codice", input);

		/*PROTECTED REGION END*/
		List<SigitTStoricoVariazStatoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTStoricoVariazStatoDaoImpl::findFindByCodiceImpianto] esecuzione query", ex);
			throw new SigitTStoricoVariazStatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTStoricoVariazStatoDaoImpl", "findFindByCodiceImpianto", "esecuzione query", sql.toString());
			LOG.debug("[SigitTStoricoVariazStatoDaoImpl::findFindByCodiceImpianto] END");
		}
		return list;
	}

}
