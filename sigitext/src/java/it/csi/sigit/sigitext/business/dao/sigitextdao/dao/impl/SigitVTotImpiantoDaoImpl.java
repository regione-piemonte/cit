package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitVTotImpiantoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitVTotImpiantoDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVTotImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitVTotImpiantoDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R93081347) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVTotImpianto.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - responsabiliAttiviByCodiceImpianto (datagen::CustomFinder)
 *   - responsabiliAttiviAllaDataByCodiceImpianto (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitVTotImpiantoDaoImpl extends AbstractDAO implements SigitVTotImpiantoDao {
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

	protected SigitVTotImpiantoDaoRowMapper responsabiliAttiviByCodiceImpiantoRowMapper = new SigitVTotImpiantoDaoRowMapper(
			new String[]{"CODICE_IMPIANTO", "DENOMINAZIONE_PROVINCIA", "SIGLA_PROVINCIA", "ISTAT_COMUNE",
					"DENOMINAZIONE_COMUNE", "INDIRIZZO_SITAD", "CIVICO", "FLG_PRINCIPALE", "PF_PG", "ID_PERSONA_FISICA",
					"NOME", "DENOMINAZIONE", "ID_RUOLO", "DES_RUOLO", "RUOLO_FUNZ", "CODICE_FISCALE", "SIGLA_REA",
					"NUMERO_REA", "ID_IMP_RUOLO_PFPG", "DATA_INIZIO_PFPG", "DATA_FINE_PFPG"},
			SigitVTotImpiantoDto.class, this);

	protected SigitVTotImpiantoDaoRowMapper responsabiliAttiviAllaDataByCodiceImpiantoRowMapper = new SigitVTotImpiantoDaoRowMapper(
			new String[]{"CODICE_IMPIANTO", "DENOMINAZIONE_PROVINCIA", "SIGLA_PROVINCIA", "ISTAT_COMUNE",
					"DENOMINAZIONE_COMUNE", "INDIRIZZO_SITAD", "CIVICO", "FLG_PRINCIPALE", "PF_PG", "ID_PERSONA_FISICA",
					"NOME", "DENOMINAZIONE", "ID_RUOLO", "DES_RUOLO", "RUOLO_FUNZ", "CODICE_FISCALE", "SIGLA_REA",
					"NUMERO_REA", "ID_IMP_RUOLO_PFPG", "DATA_INIZIO_PFPG", "DATA_FINE_PFPG"},
			SigitVTotImpiantoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_TOT_IMPIANTO";
	}

	/** 
	 * Implementazione del finder responsabiliAttiviByCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVTotImpiantoDto> findResponsabiliAttiviByCodiceImpianto(Integer input)
			throws SigitVTotImpiantoDaoException {
		LOG.debug("[SigitVTotImpiantoDaoImpl::findResponsabiliAttiviByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT DISTINCT CODICE_IMPIANTO,DENOMINAZIONE_PROVINCIA,SIGLA_PROVINCIA,ISTAT_COMUNE,DENOMINAZIONE_COMUNE,INDIRIZZO_SITAD,CIVICO,FLG_PRINCIPALE,PF_PG,ID_PERSONA_FISICA,NOME,DENOMINAZIONE,ID_RUOLO,DES_RUOLO,RUOLO_FUNZ,CODICE_FISCALE,SIGLA_REA,NUMERO_REA,ID_IMP_RUOLO_PFPG,DATA_INIZIO_PFPG,DATA_FINE_PFPG ");
		sql.append(" FROM VISTA_TOT_IMPIANTO");
		sql.append(" WHERE ");

		sql.append(" RUOLO_FUNZ IN ('" + Constants.RUOLO_RESPONSABILE + "', '"
				+ Constants.RUOLO_RESPONSABILE_IMPRESA + "')");

		sql.append(" AND CODICE_IMPIANTO = :codImpianto ");

		sql.append(" AND CURRENT_DATE BETWEEN DATA_INIZIO_PFPG AND COALESCE(DATA_FINE_PFPG,CURRENT_DATE)");

		paramMap.addValue("codImpianto", input);

		List<SigitVTotImpiantoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, responsabiliAttiviByCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVTotImpiantoDaoImpl::findResponsabiliAttiviByCodiceImpianto] esecuzione query", ex);
			throw new SigitVTotImpiantoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVTotImpiantoDaoImpl", "findResponsabiliAttiviByCodiceImpianto",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitVTotImpiantoDaoImpl::findResponsabiliAttiviByCodiceImpianto] END");
		}
		return list;
	}

	public List<SigitVTotImpiantoDto> findProprietariAttiviByCodiceImpianto(Integer input)
			throws SigitVTotImpiantoDaoException {
		LOG.debug("[SigitVTotImpiantoDaoImpl::findResponsabiliAttiviByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT DISTINCT CODICE_IMPIANTO,DENOMINAZIONE_PROVINCIA,SIGLA_PROVINCIA,ISTAT_COMUNE,DENOMINAZIONE_COMUNE,INDIRIZZO_SITAD,CIVICO,FLG_PRINCIPALE,PF_PG,ID_PERSONA_FISICA,NOME,DENOMINAZIONE,ID_RUOLO,DES_RUOLO,RUOLO_FUNZ,CODICE_FISCALE,SIGLA_REA,NUMERO_REA,ID_IMP_RUOLO_PFPG,DATA_INIZIO_PFPG,DATA_FINE_PFPG ");
		sql.append(" FROM VISTA_TOT_IMPIANTO");
		sql.append(" WHERE ");

		sql.append(" RUOLO_FUNZ IN ('" + Constants.RUOLO_PROPRIETARIO + "', '"
				+ Constants.RUOLO_PROPRIETARIO_IMPRESA + "')");

		sql.append(" AND CODICE_IMPIANTO = :codImpianto ");

		sql.append(" AND CURRENT_DATE BETWEEN DATA_INIZIO_PFPG AND COALESCE(DATA_FINE_PFPG,CURRENT_DATE)");

		paramMap.addValue("codImpianto", input);

		List<SigitVTotImpiantoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, responsabiliAttiviByCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVTotImpiantoDaoImpl::findResponsabiliAttiviByCodiceImpianto] esecuzione query", ex);
			throw new SigitVTotImpiantoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVTotImpiantoDaoImpl", "findResponsabiliAttiviByCodiceImpianto",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitVTotImpiantoDaoImpl::findResponsabiliAttiviByCodiceImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder responsabiliAttiviAllaDataByCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVTotImpiantoDto> findResponsabiliAttiviAllaDataByCodiceImpianto(
			it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.ResponsabileFilter input)
			throws SigitVTotImpiantoDaoException {
		LOG.debug("[SigitVTotImpiantoDaoImpl::findResponsabiliAttiviAllaDataByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT DISTINCT CODICE_IMPIANTO,DENOMINAZIONE_PROVINCIA,SIGLA_PROVINCIA,ISTAT_COMUNE,DENOMINAZIONE_COMUNE,INDIRIZZO_SITAD,CIVICO,FLG_PRINCIPALE,PF_PG,ID_PERSONA_FISICA,NOME,DENOMINAZIONE,ID_RUOLO,DES_RUOLO,RUOLO_FUNZ,CODICE_FISCALE,SIGLA_REA,NUMERO_REA,ID_IMP_RUOLO_PFPG,DATA_INIZIO_PFPG,DATA_FINE_PFPG ");
		sql.append(" FROM VISTA_TOT_IMPIANTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R951916905) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" RUOLO_FUNZ IN ('" + Constants.RUOLO_RESPONSABILE + "', '" + Constants.RUOLO_RESPONSABILE_IMPRESA
				+ "')");

		sql.append(" AND CODICE_IMPIANTO = :codImpianto ");
		sql.append(" AND :dataRapporto BETWEEN DATA_INIZIO_PFPG AND COALESCE(DATA_FINE_PFPG, :dataFine)");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-430460767) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodiceImpianto());
		paramMap.addValue("dataRapporto", input.getDataRapporto());
		paramMap.addValue("dataFine", input.getDataRapporto());

		/*PROTECTED REGION END*/
		List<SigitVTotImpiantoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, responsabiliAttiviAllaDataByCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVTotImpiantoDaoImpl::findResponsabiliAttiviAllaDataByCodiceImpianto] esecuzione query",
					ex);
			throw new SigitVTotImpiantoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVTotImpiantoDaoImpl", "findResponsabiliAttiviAllaDataByCodiceImpianto",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitVTotImpiantoDaoImpl::findResponsabiliAttiviAllaDataByCodiceImpianto] END");
		}
		return list;
	}

}
