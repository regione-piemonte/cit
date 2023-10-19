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

/*PROTECTED REGION ID(R-1415841265) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVTotImpianto.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - responsabiliAttiviByCodiceImpianto (datagen::CustomFinder)
 *   - terziResponsabiliAttiviByCodiceImpianto (datagen::CustomFinder)
 *   - cercaImpiantoPerAllegati (datagen::CustomFinder)
 *   - cercaUbicazioneImpianto (datagen::CustomFinder)
 *   - responsabiliAttiviAllaDataByCodiceImpianto (datagen::CustomFinder)
 *   - AttivoAllaDataByFilter (datagen::CustomFinder)
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

	protected SigitVTotImpiantoDaoRowMapper findAllRowMapper = new SigitVTotImpiantoDaoRowMapper(null,
			SigitVTotImpiantoDto.class, this);

	protected SigitVTotImpiantoDaoRowMapper responsabiliAttiviByCodiceImpiantoRowMapper = new SigitVTotImpiantoDaoRowMapper(
			new String[]{"CODICE_IMPIANTO", "SIGLA_PROVINCIA", "ISTAT_COMUNE", "DENOMINAZIONE_PROVINCIA",
					"DENOMINAZIONE_COMUNE", "INDIRIZZO_SITAD", "CIVICO", "FLG_PRINCIPALE", "PF_PG", "ID_PERSONA_FISICA",
					"NOME", "DENOMINAZIONE", "ID_RUOLO", "DES_RUOLO", "RUOLO_FUNZ", "CODICE_FISCALE", "SIGLA_REA",
					"NUMERO_REA", "ID_IMP_RUOLO_PFPG", "DATA_INIZIO_PFPG", "DATA_FINE_PFPG"},
			SigitVTotImpiantoDto.class, this);

	protected SigitVTotImpiantoDaoRowMapper terziResponsabiliAttiviByCodiceImpiantoRowMapper = new SigitVTotImpiantoDaoRowMapper(
			new String[]{"CODICE_IMPIANTO", "SIGLA_PROVINCIA", "ISTAT_COMUNE", "DENOMINAZIONE_PROVINCIA",
					"DENOMINAZIONE_COMUNE", "INDIRIZZO_SITAD", "CIVICO", "FLG_PRINCIPALE"},
			SigitVTotImpiantoDto.class, this);

	protected SigitVTotImpiantoDaoRowMapper cercaImpiantoPerAllegatiRowMapper = new SigitVTotImpiantoDaoRowMapper(null,
			SigitVTotImpiantoCercaImpiantoPerAllegatiDto.class, this);

	protected SigitVTotImpiantoDaoRowMapper cercaUbicazioneImpiantoRowMapper = new SigitVTotImpiantoDaoRowMapper(null,
			SigitVTotImpiantoCercaUbicazioneImpiantoDto.class, this);

	protected SigitVTotImpiantoDaoRowMapper responsabiliAttiviAllaDataByCodiceImpiantoRowMapper = new SigitVTotImpiantoDaoRowMapper(
			new String[]{"CODICE_IMPIANTO", "SIGLA_PROVINCIA", "ISTAT_COMUNE", "DENOMINAZIONE_PROVINCIA",
					"DENOMINAZIONE_COMUNE", "INDIRIZZO_SITAD", "CIVICO", "FLG_PRINCIPALE", "PF_PG", "ID_PERSONA_FISICA",
					"NOME", "DENOMINAZIONE", "ID_RUOLO", "DES_RUOLO", "RUOLO_FUNZ", "CODICE_FISCALE", "SIGLA_REA",
					"NUMERO_REA", "ID_IMP_RUOLO_PFPG", "DATA_INIZIO_PFPG", "DATA_FINE_PFPG"},
			SigitVTotImpiantoDto.class, this);

	protected SigitVTotImpiantoDaoRowMapper AttivoAllaDataByFilterRowMapper = new SigitVTotImpiantoDaoRowMapper(
			new String[]{"CODICE_IMPIANTO", "SIGLA_PROVINCIA", "ISTAT_COMUNE", "DENOMINAZIONE_PROVINCIA",
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
	 * Restituisce tutte le righe della tabella VISTA_TOT_IMPIANTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVTotImpiantoDto> findAll() throws SigitVTotImpiantoDaoException {
		LOG.debug("[SigitVTotImpiantoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT CODICE_IMPIANTO,DENOMINAZIONE_PROVINCIA,SIGLA_PROVINCIA,ISTAT_COMUNE,DENOMINAZIONE_COMUNE,INDIRIZZO_SITAD,CIVICO,FLG_PRINCIPALE,PF_PG,ID_PERSONA_FISICA,NOME,DENOMINAZIONE,ID_RUOLO,DES_RUOLO,RUOLO_FUNZ,CODICE_FISCALE,SIGLA_REA,NUMERO_REA,ID_IMP_RUOLO_PFPG,DATA_INIZIO_PFPG,DATA_FINE_PFPG,FLG_VISU_PROPRIETARIO FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitVTotImpiantoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitVTotImpiantoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitVTotImpiantoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVTotImpiantoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitVTotImpiantoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder responsabiliAttiviByCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVTotImpiantoDto> findResponsabiliAttiviByCodiceImpianto(java.lang.Integer input)
			throws SigitVTotImpiantoDaoException {
		LOG.debug("[SigitVTotImpiantoDaoImpl::findResponsabiliAttiviByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT DISTINCT CODICE_IMPIANTO,SIGLA_PROVINCIA,ISTAT_COMUNE,DENOMINAZIONE_PROVINCIA,DENOMINAZIONE_COMUNE,INDIRIZZO_SITAD,CIVICO,FLG_PRINCIPALE,PF_PG,ID_PERSONA_FISICA,NOME,DENOMINAZIONE,ID_RUOLO,DES_RUOLO,RUOLO_FUNZ,CODICE_FISCALE,SIGLA_REA,NUMERO_REA,ID_IMP_RUOLO_PFPG,DATA_INIZIO_PFPG,DATA_FINE_PFPG ");
		sql.append(" FROM VISTA_TOT_IMPIANTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1485985987) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		sql.append(" RUOLO_FUNZ IN ('" + Constants.RUOLO_RESPONSABILE + "', '"
		//+ Constants.RUOLO_AMMINISTRATORE + "', '"
				+ Constants.RUOLO_RESPONSABILE_IMPRESA + "')");
		//where ruolo_funz in ('RESPONSABILE', 'AMMINISTRATORE')

		sql.append(" AND CODICE_IMPIANTO = :codImpianto ");

		sql.append(" AND CURRENT_DATE BETWEEN DATA_INIZIO_PFPG AND COALESCE(DATA_FINE_PFPG,CURRENT_DATE)");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-298510881) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input);

		/*PROTECTED REGION END*/
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
	 * Implementazione del finder terziResponsabiliAttiviByCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVTotImpiantoDto> findTerziResponsabiliAttiviByCodiceImpianto(java.lang.Integer input)
			throws SigitVTotImpiantoDaoException {
		LOG.debug("[SigitVTotImpiantoDaoImpl::findTerziResponsabiliAttiviByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT DISTINCT CODICE_IMPIANTO,SIGLA_PROVINCIA,ISTAT_COMUNE,DENOMINAZIONE_PROVINCIA,DENOMINAZIONE_COMUNE,INDIRIZZO_SITAD,CIVICO,FLG_PRINCIPALE ");
		sql.append(" FROM VISTA_TOT_IMPIANTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-2085732897) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		sql.append(" CODICE_IMPIANTO = :codImpianto ");

		sql.append(" AND DATA_INIZIO_CONTRATTO <= CURRENT_DATE");
		sql.append(" AND DATA_REVOCA IS NULL ");
		sql.append(" AND (FLG_TACITO_RINNOVO=1 OR (FLG_TACITO_RINNOVO = 0 AND DATA_FINE_CONTRATTO > CURRENT_DATE)) ");

		//		sql.append(" AND DATA_INIZIO_3R <= CURRENT_DATE ");
		//		sql.append(" AND COALESCE(DATA_FINE_3R,CURRENT_DATE) >= CURRENT_DATE ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R647353411) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitVTotImpiantoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, terziResponsabiliAttiviByCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVTotImpiantoDaoImpl::findTerziResponsabiliAttiviByCodiceImpianto] esecuzione query", ex);
			throw new SigitVTotImpiantoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVTotImpiantoDaoImpl", "findTerziResponsabiliAttiviByCodiceImpianto",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitVTotImpiantoDaoImpl::findTerziResponsabiliAttiviByCodiceImpianto] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder cercaImpiantoPerAllegati con Qdef
		 * @generated
		 */

	public List<SigitVTotImpiantoCercaImpiantoPerAllegatiDto> findCercaImpiantoPerAllegati(java.lang.Integer input)
			throws SigitVTotImpiantoDaoException {
		LOG.debug("[SigitVTotImpiantoDaoImpl::findCercaImpiantoPerAllegati] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT vTotImpianto.CODICE_IMPIANTO as codiceImpianto, vTotImpianto.SIGLA_PROVINCIA as siglaProvincia, vTotImpianto.ISTAT_COMUNE as istatComune, vTotImpianto.DENOMINAZIONE_PROVINCIA as denominazioneProvincia, vTotImpianto.DENOMINAZIONE_COMUNE as denominazioneComune, vTotImpianto.INDIRIZZO_SITAD as indirizzo, vTotImpianto.CIVICO as civico, vTotImpianto.NOME as nome, vTotImpianto.DENOMINAZIONE as denominazione, vTotImpianto.DES_RUOLO as descRuolo, vTotImpianto.ID_PERSONA_FISICA as idPersonaFisica, vTotImpianto.PF_PG as pfPg, vTotImpianto.ID_RUOLO as idRuolo");

		sql.append(" FROM VISTA_TOT_IMPIANTO vTotImpianto");

		sql.append(" WHERE ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R592514845) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" AND RUOLO_FUNZ IN ('" + Constants.RUOLO_RESPONSABILE + "', '"
				+ Constants.RUOLO_RESPONSABILE_IMPRESA + "')");
		sql.append(" AND CODICE_IMPIANTO = :codImpianto ");
		sql.append(" AND DATA_FINE_PFPG IS NULL");
		sql.append(" AND FLG_PRINCIPALE = 1 ");
		sql.append(
				" GROUP BY vTotImpianto.CODICE_IMPIANTO, vTotImpianto.SIGLA_PROVINCIA, vTotImpianto.ISTAT_COMUNE, vTotImpianto.DENOMINAZIONE_PROVINCIA, vTotImpianto.DENOMINAZIONE_COMUNE, vTotImpianto.INDIRIZZO_SITAD, vTotImpianto.CIVICO, vTotImpianto.NOME, vTotImpianto.DENOMINAZIONE, vTotImpianto.DES_RUOLO, vTotImpianto.ID_PERSONA_FISICA, vTotImpianto.PF_PG, vTotImpianto.ID_RUOLO ");

		paramMap.addValue("codImpianto", input);

		/*PROTECTED REGION END*/

		List<SigitVTotImpiantoCercaImpiantoPerAllegatiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, cercaImpiantoPerAllegatiRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitVTotImpiantoDaoImpl::findCercaImpiantoPerAllegati] ERROR esecuzione query", ex);
			throw new SigitVTotImpiantoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVTotImpiantoDaoImpl", "findCercaImpiantoPerAllegati", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVTotImpiantoDaoImpl::findCercaImpiantoPerAllegati] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder cercaUbicazioneImpianto con Qdef
		 * @generated
		 */

	public List<SigitVTotImpiantoCercaUbicazioneImpiantoDto> findCercaUbicazioneImpianto(java.lang.Integer input)
			throws SigitVTotImpiantoDaoException {
		LOG.debug("[SigitVTotImpiantoDaoImpl::findCercaUbicazioneImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT vTotImpianto.CODICE_IMPIANTO as codiceImpianto, vTotImpianto.SIGLA_PROVINCIA as siglaProvincia, vTotImpianto.ISTAT_COMUNE as istatComune, vTotImpianto.DENOMINAZIONE_PROVINCIA as provincia, vTotImpianto.DENOMINAZIONE_COMUNE as comune, vTotImpianto.INDIRIZZO_SITAD as indirizzo, vTotImpianto.CIVICO as civico");

		sql.append(" FROM VISTA_TOT_IMPIANTO vTotImpianto");

		sql.append(" WHERE ");

		sql.append("1=1");
		/*PROTECTED REGION ID(R-772025140) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" AND vTotImpianto.CODICE_IMPIANTO = :codiceImpianto");
		sql.append(" AND FLG_PRINCIPALE = 1  ");
		paramMap.addValue("codiceImpianto", input);

		LOG.debug("[SigitVTotImpiantoDaoImpl::findCercaUbicazioneImpianto] query: " + sql);
		LOG.debug("[SigitVTotImpiantoDaoImpl::findCercaUbicazioneImpianto] input: " + input);

		/*PROTECTED REGION END*/

		List<SigitVTotImpiantoCercaUbicazioneImpiantoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, cercaUbicazioneImpiantoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitVTotImpiantoDaoImpl::findCercaUbicazioneImpianto] ERROR esecuzione query", ex);
			throw new SigitVTotImpiantoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVTotImpiantoDaoImpl", "findCercaUbicazioneImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVTotImpiantoDaoImpl::findCercaUbicazioneImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder responsabiliAttiviAllaDataByCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVTotImpiantoDto> findResponsabiliAttiviAllaDataByCodiceImpianto(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ResponsabileFilter input)
			throws SigitVTotImpiantoDaoException {
		LOG.debug("[SigitVTotImpiantoDaoImpl::findResponsabiliAttiviAllaDataByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT DISTINCT CODICE_IMPIANTO,SIGLA_PROVINCIA,ISTAT_COMUNE,DENOMINAZIONE_PROVINCIA,DENOMINAZIONE_COMUNE,INDIRIZZO_SITAD,CIVICO,FLG_PRINCIPALE,PF_PG,ID_PERSONA_FISICA,NOME,DENOMINAZIONE,ID_RUOLO,DES_RUOLO,RUOLO_FUNZ,CODICE_FISCALE,SIGLA_REA,NUMERO_REA,ID_IMP_RUOLO_PFPG,DATA_INIZIO_PFPG,DATA_FINE_PFPG ");
		sql.append(" FROM VISTA_TOT_IMPIANTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-493836275) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" RUOLO_FUNZ IN ('" + Constants.RUOLO_RESPONSABILE + "', '" + Constants.RUOLO_RESPONSABILE_IMPRESA
				+ "')");

		sql.append(" AND CODICE_IMPIANTO = :codImpianto ");
		sql.append(" AND :dataRapporto BETWEEN DATA_INIZIO_PFPG AND COALESCE(DATA_FINE_PFPG, :dataFine)");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1543458859) ENABLED START*/
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

	/** 
	 * Implementazione del finder AttivoAllaDataByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVTotImpiantoDto> findAttivoAllaDataByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImpiantoFilter input)
			throws SigitVTotImpiantoDaoException {
		LOG.debug("[SigitVTotImpiantoDaoImpl::findAttivoAllaDataByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT DISTINCT CODICE_IMPIANTO,SIGLA_PROVINCIA,ISTAT_COMUNE,DENOMINAZIONE_PROVINCIA,DENOMINAZIONE_COMUNE,INDIRIZZO_SITAD,CIVICO,FLG_PRINCIPALE,PF_PG,ID_PERSONA_FISICA,NOME,DENOMINAZIONE,ID_RUOLO,DES_RUOLO,RUOLO_FUNZ,CODICE_FISCALE,SIGLA_REA,NUMERO_REA,ID_IMP_RUOLO_PFPG,DATA_INIZIO_PFPG,DATA_FINE_PFPG ");
		sql.append(" FROM VISTA_TOT_IMPIANTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R897606546) ENABLED START*/
		sql.append(" ID_RUOLO = :idRuolo");

		sql.append(" AND CODICE_IMPIANTO = :codImpianto ");
		if (input.getIdPersonaGiuridica() != null) {
			sql.append(" AND ID_PERSONA_FISICA = :idPersonaGiuridica ");
		}
		sql.append(" AND :dataControllo BETWEEN DATA_INIZIO_PFPG AND COALESCE(DATA_FINE_PFPG, :dataControllo)");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1358404368) ENABLED START*/

		paramMap.addValue("idRuolo", input.getRuolo(), java.sql.Types.NUMERIC);
		if (input.getIdPersonaGiuridica() != null) {
			paramMap.addValue("idPersonaGiuridica", input.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);
		}
		paramMap.addValue("codImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("dataControllo", input.getDataControllo(), java.sql.Types.DATE);

		/*PROTECTED REGION END*/
		List<SigitVTotImpiantoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, AttivoAllaDataByFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVTotImpiantoDaoImpl::findAttivoAllaDataByFilter] esecuzione query", ex);
			throw new SigitVTotImpiantoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVTotImpiantoDaoImpl", "findAttivoAllaDataByFilter", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVTotImpiantoDaoImpl::findAttivoAllaDataByFilter] END");
		}
		return list;
	}

}
