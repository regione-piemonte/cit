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

/*PROTECTED REGION ID(R-1486111885) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTVerifica.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byExample (datagen::CustomFinder)
 *   - findAll (datagen::FindAll)
 *   - sveglieAttiveByCF (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - sveglia (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *   - byCodImpianto (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTVerificaDaoImpl extends AbstractDAO implements SigitTVerificaDao {
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
	 * Metodo di inserimento del DAO sigitTVerifica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTVerificaPk
	 * @generated
	 */

	public SigitTVerificaPk insert(SigitTVerificaDto dto)

	{
		LOG.debug("[SigitTVerificaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_VERIFICA,FK_TIPO_VERIFICA,FK_ALLEGATO,FK_DATO_DISTRIB,CODICE_IMPIANTO,CF_UTENTE_CARICAMENTO,DENOM_UTENTE_CARICAMENTO,DT_CARICAMENTO,SIGLA_BOLLINO,NUMERO_BOLLINO,DT_SVEGLIA,NOTE_SVEGLIA,NOTE ) VALUES (  :ID_VERIFICA , :FK_TIPO_VERIFICA , :FK_ALLEGATO , :FK_DATO_DISTRIB , :CODICE_IMPIANTO , :CF_UTENTE_CARICAMENTO , :DENOM_UTENTE_CARICAMENTO , :DT_CARICAMENTO , :SIGLA_BOLLINO , :NUMERO_BOLLINO , :DT_SVEGLIA , :NOTE_SVEGLIA , :NOTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_VERIFICA]
		params.addValue("ID_VERIFICA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_VERIFICA]
		params.addValue("FK_TIPO_VERIFICA", dto.getFkTipoVerifica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ALLEGATO]
		params.addValue("FK_ALLEGATO", dto.getFkAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_DATO_DISTRIB]
		params.addValue("FK_DATO_DISTRIB", dto.getFkDatoDistrib(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CF_UTENTE_CARICAMENTO]
		params.addValue("CF_UTENTE_CARICAMENTO", dto.getCfUtenteCaricamento(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DENOM_UTENTE_CARICAMENTO]
		params.addValue("DENOM_UTENTE_CARICAMENTO", dto.getDenomUtenteCaricamento(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DT_CARICAMENTO]
		params.addValue("DT_CARICAMENTO", dto.getDtCaricamento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [SIGLA_BOLLINO]
		params.addValue("SIGLA_BOLLINO", dto.getSiglaBollino(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NUMERO_BOLLINO]
		params.addValue("NUMERO_BOLLINO", dto.getNumeroBollino(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_SVEGLIA]
		params.addValue("DT_SVEGLIA", dto.getDtSveglia(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE_SVEGLIA]
		params.addValue("NOTE_SVEGLIA", dto.getNoteSveglia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdVerifica(newKey);
		LOG.debug("[SigitTVerificaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_VERIFICA table.
	 * @generated
	 */
	public void update(SigitTVerificaDto dto) throws SigitTVerificaDaoException {
		LOG.debug("[SigitTVerificaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_TIPO_VERIFICA = :FK_TIPO_VERIFICA ,FK_ALLEGATO = :FK_ALLEGATO ,FK_DATO_DISTRIB = :FK_DATO_DISTRIB ,CODICE_IMPIANTO = :CODICE_IMPIANTO ,CF_UTENTE_CARICAMENTO = :CF_UTENTE_CARICAMENTO ,DENOM_UTENTE_CARICAMENTO = :DENOM_UTENTE_CARICAMENTO ,DT_CARICAMENTO = :DT_CARICAMENTO ,SIGLA_BOLLINO = :SIGLA_BOLLINO ,NUMERO_BOLLINO = :NUMERO_BOLLINO ,DT_SVEGLIA = :DT_SVEGLIA ,NOTE_SVEGLIA = :NOTE_SVEGLIA ,NOTE = :NOTE  WHERE ID_VERIFICA = :ID_VERIFICA ";

		if (dto.getIdVerifica() == null) {
			LOG.error("[SigitTVerificaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTVerificaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_VERIFICA]
		params.addValue("ID_VERIFICA", dto.getIdVerifica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_VERIFICA]
		params.addValue("FK_TIPO_VERIFICA", dto.getFkTipoVerifica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ALLEGATO]
		params.addValue("FK_ALLEGATO", dto.getFkAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_DATO_DISTRIB]
		params.addValue("FK_DATO_DISTRIB", dto.getFkDatoDistrib(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CF_UTENTE_CARICAMENTO]
		params.addValue("CF_UTENTE_CARICAMENTO", dto.getCfUtenteCaricamento(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DENOM_UTENTE_CARICAMENTO]
		params.addValue("DENOM_UTENTE_CARICAMENTO", dto.getDenomUtenteCaricamento(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DT_CARICAMENTO]
		params.addValue("DT_CARICAMENTO", dto.getDtCaricamento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [SIGLA_BOLLINO]
		params.addValue("SIGLA_BOLLINO", dto.getSiglaBollino(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NUMERO_BOLLINO]
		params.addValue("NUMERO_BOLLINO", dto.getNumeroBollino(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_SVEGLIA]
		params.addValue("DT_SVEGLIA", dto.getDtSveglia(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE_SVEGLIA]
		params.addValue("NOTE_SVEGLIA", dto.getNoteSveglia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTVerificaDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_VERIFICA table.
	 * @generated
	 */
	public void updateColumnsSveglia(SigitTVerificaDto dto) throws SigitTVerificaDaoException {
		LOG.debug("[SigitTVerificaDaoImpl::updateColumnsSveglia] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DT_SVEGLIA = :DT_SVEGLIA ,NOTE_SVEGLIA = :NOTE_SVEGLIA  WHERE ID_VERIFICA = :ID_VERIFICA ";

		if (dto.getIdVerifica() == null) {
			LOG.error("[SigitTVerificaDaoImpl::updateColumnsSveglia] ERROR chiave primaria non impostata");
			throw new SigitTVerificaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DT_SVEGLIA]
		params.addValue("DT_SVEGLIA", dto.getDtSveglia(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE_SVEGLIA]
		params.addValue("NOTE_SVEGLIA", dto.getNoteSveglia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_VERIFICA]
		params.addValue("ID_VERIFICA", dto.getIdVerifica(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTVerificaDaoImpl::updateColumnsSveglia] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_VERIFICA table.
	 * @generated
	 */

	public void delete(SigitTVerificaPk pk) throws SigitTVerificaDaoException {
		LOG.debug("[SigitTVerificaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_VERIFICA = :ID_VERIFICA ";

		if (pk == null) {
			LOG.error("[SigitTVerificaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTVerificaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_VERIFICA]
		params.addValue("ID_VERIFICA", pk.getIdVerifica(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTVerificaDaoImpl::delete] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_VERIFICA table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTVerificaDaoException {
		LOG.debug("[SigitTVerificaDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R1107443301) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE ";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("parametro", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTVerificaDaoImpl::customDeleterByCodImpianto] END");
	}

	protected SigitTVerificaDaoRowMapper findByPrimaryKeyRowMapper = new SigitTVerificaDaoRowMapper(null,
			SigitTVerificaDto.class, this);

	protected SigitTVerificaDaoRowMapper byExampleRowMapper = new SigitTVerificaDaoRowMapper(null,
			SigitTVerificaDto.class, this);

	protected SigitTVerificaDaoRowMapper findAllRowMapper = new SigitTVerificaDaoRowMapper(null,
			SigitTVerificaDto.class, this);

	protected SigitTVerificaDaoRowMapper sveglieAttiveByCFRowMapper = new SigitTVerificaDaoRowMapper(null,
			SigitTVerificaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_VERIFICA";
	}

	/** 
	 * Returns all rows from the SIGIT_T_VERIFICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTVerificaDto findByPrimaryKey(SigitTVerificaPk pk) throws SigitTVerificaDaoException {
		LOG.debug("[SigitTVerificaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_VERIFICA,FK_TIPO_VERIFICA,FK_ALLEGATO,FK_DATO_DISTRIB,CODICE_IMPIANTO,CF_UTENTE_CARICAMENTO,DENOM_UTENTE_CARICAMENTO,DT_CARICAMENTO,SIGLA_BOLLINO,NUMERO_BOLLINO,DT_SVEGLIA,NOTE_SVEGLIA,NOTE FROM "
						+ getTableName() + " WHERE ID_VERIFICA = :ID_VERIFICA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_VERIFICA]
		params.addValue("ID_VERIFICA", pk.getIdVerifica(), java.sql.Types.INTEGER);

		List<SigitTVerificaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTVerificaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTVerificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTVerificaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTVerificaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTVerificaDto> findByExample(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaVerificaFilter input)
			throws SigitTVerificaDaoException {
		LOG.debug("[SigitTVerificaDaoImpl::findByExample] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-16714996) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_VERIFICA,FK_TIPO_VERIFICA,FK_ALLEGATO,FK_DATO_DISTRIB,CODICE_IMPIANTO,CF_UTENTE_CARICAMENTO,DENOM_UTENTE_CARICAMENTO,DT_CARICAMENTO,SIGLA_BOLLINO,NUMERO_BOLLINO,DT_SVEGLIA,NOTE_SVEGLIA,NOTE ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1351624546) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_VERIFICA");
		if (input.getIdValidatoreCaricamento() != null && !input.isRicercaAutomatiche()) {
			sql.append(
					" JOIN SIGIT_T_PERSONA_FISICA PF ON PF.CODICE_FISCALE = CF_UTENTE_CARICAMENTO AND PF.ID_PERSONA_FISICA = :iDValidatoreCaricamento ");
		}

		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R831947804) ENABLED START*/
		sql.append(" ID_VERIFICA > 0 ");

		if (input.getIdVerifica() != null) {
			sql.append(" AND ID_VERIFICA = :idVerifica");
		}

		if (input.getDataCreazioneDA() != null) {
			sql.append(" AND DT_CARICAMENTO >= :dataCreazioneDA");
		}

		if (input.getDataCreazioneA() != null) {
			sql.append(" AND DT_CARICAMENTO <= :dataCreazioneA");
		}

		if (input.getIdTipoVerifica() != null) {
			sql.append(" AND FK_TIPO_VERIFICA = :idTipoVerifica");
		}

		if (input.getCodiceImpianto() != null) {
			sql.append(" AND CODICE_IMPIANTO = :codiceImpianto");
		}

		if (input.getSiglaBollino() != null && !"".equals(input.getSiglaBollino())) {
			sql.append(" AND SIGLA_BOLLINO = :siglaBollino");
		}

		if (input.getNumeroBollino() != null) {
			sql.append(" AND NUMERO_BOLLINO = :numeroBollino");
		}

		if (input.getIdDatoDistributore() != null) {
			sql.append(" AND FK_DATO_DISTRIB = :idDatoDistributore");
		}

		if (input.isRicercaAutomatiche()) {
			sql.append(" AND CF_UTENTE_CARICAMENTO = 'INSERTAUTOMATICO'");
		}

		sql.append(" ORDER BY ID_VERIFICA DESC");

		sql.append(
				" LIMIT (SELECT VALORE_CONFIG_NUM FROM SIGIT_WRK_CONFIG WHERE CHIAVE_CONFIG='MAX_RIGHE_RIC_AVZ_IMP') ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R901141926) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input.getIdVerifica() != null) {
			paramMap.addValue("idVerifica", input.getIdVerifica(), java.sql.Types.NUMERIC);
		}

		if (input.getIdValidatoreCaricamento() != null && !input.isRicercaAutomatiche()) {
			paramMap.addValue("iDValidatoreCaricamento", input.getIdValidatoreCaricamento());
		}

		if (input.getDataCreazioneDA() != null) {
			paramMap.addValue("dataCreazioneDA", input.getDataCreazioneDA(), java.sql.Types.DATE);
		}

		if (input.getDataCreazioneA() != null) {
			paramMap.addValue("dataCreazioneA", input.getDataCreazioneA(), java.sql.Types.DATE);
		}

		if (input.getIdTipoVerifica() != null) {
			paramMap.addValue("idTipoVerifica", input.getIdTipoVerifica(), java.sql.Types.NUMERIC);
		}

		if (input.getCodiceImpianto() != null) {
			paramMap.addValue("codiceImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);
		}

		if (input.getSiglaBollino() != null && !"".equals(input.getSiglaBollino())) {
			paramMap.addValue("siglaBollino", input.getSiglaBollino());
		}

		if (input.getNumeroBollino() != null) {
			paramMap.addValue("numeroBollino", input.getNumeroBollino(), java.sql.Types.NUMERIC);
		}

		if (input.getIdDatoDistributore() != null) {
			paramMap.addValue("idDatoDistributore", input.getIdDatoDistributore(), java.sql.Types.NUMERIC);
		}

		/*PROTECTED REGION END*/
		List<SigitTVerificaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byExampleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTVerificaDaoImpl::findByExample] esecuzione query", ex);
			throw new SigitTVerificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTVerificaDaoImpl", "findByExample", "esecuzione query", sql.toString());
			LOG.debug("[SigitTVerificaDaoImpl::findByExample] END");
		}
		return list;
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_VERIFICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTVerificaDto> findAll() throws SigitTVerificaDaoException {
		LOG.debug("[SigitTVerificaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_VERIFICA,FK_TIPO_VERIFICA,FK_ALLEGATO,FK_DATO_DISTRIB,CODICE_IMPIANTO,CF_UTENTE_CARICAMENTO,DENOM_UTENTE_CARICAMENTO,DT_CARICAMENTO,SIGLA_BOLLINO,NUMERO_BOLLINO,DT_SVEGLIA,NOTE_SVEGLIA,NOTE FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTVerificaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTVerificaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitTVerificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTVerificaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitTVerificaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder sveglieAttiveByCF
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTVerificaDto> findSveglieAttiveByCF(java.lang.String input) throws SigitTVerificaDaoException {
		LOG.debug("[SigitTVerificaDaoImpl::findSveglieAttiveByCF] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_VERIFICA,FK_TIPO_VERIFICA,FK_ALLEGATO,FK_DATO_DISTRIB,CODICE_IMPIANTO,CF_UTENTE_CARICAMENTO,DENOM_UTENTE_CARICAMENTO,DT_CARICAMENTO,SIGLA_BOLLINO,NUMERO_BOLLINO,DT_SVEGLIA,NOTE_SVEGLIA,NOTE ");
		sql.append(" FROM SIGIT_T_VERIFICA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R200771325) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" DT_SVEGLIA IS NOT NULL");
		sql.append(" AND CF_UTENTE_CARICAMENTO = :cfUtente");
		sql.append(" ORDER BY DT_SVEGLIA DESC");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1485459739) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("cfUtente", input);

		/*PROTECTED REGION END*/
		List<SigitTVerificaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, sveglieAttiveByCFRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTVerificaDaoImpl::findSveglieAttiveByCF] esecuzione query", ex);
			throw new SigitTVerificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTVerificaDaoImpl", "findSveglieAttiveByCF", "esecuzione query", sql.toString());
			LOG.debug("[SigitTVerificaDaoImpl::findSveglieAttiveByCF] END");
		}
		return list;
	}

}
