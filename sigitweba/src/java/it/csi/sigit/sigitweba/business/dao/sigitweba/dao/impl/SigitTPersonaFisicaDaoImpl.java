package it.csi.sigit.sigitweba.business.dao.sigitweba.dao.impl;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.mapper.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.qbe.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.metadata.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import it.csi.sigit.sigitweba.business.dao.impl.*;
import it.csi.sigit.sigitweba.business.dao.util.*;
import it.csi.sigit.sigitweba.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R406195663) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTPersonaFisica.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findByCodFisc (datagen::CustomFinder)
 *   - findAll (datagen::FindAll)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTPersonaFisicaDaoImpl extends AbstractDAO implements SigitTPersonaFisicaDao {
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
	 * Metodo di inserimento del DAO sigitTPersonaFisica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTPersonaFisicaPk
	 * @generated
	 */

	public SigitTPersonaFisicaPk insert(SigitTPersonaFisicaDto dto)

	{
		LOG.debug("[SigitTPersonaFisicaDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PERSONA_FISICA,NOME,COGNOME,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,ISTAT_COMUNE,SIGLA_PROV,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,FLG_ACCREDITATO,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FLG_NEWSLETTER,FLG_GDPR ) VALUES (  :ID_PERSONA_FISICA , :NOME , :COGNOME , :CODICE_FISCALE , :FK_L2 , :INDIRIZZO_SITAD , :INDIRIZZO_NON_TROVATO , :ISTAT_COMUNE , :SIGLA_PROV , :COMUNE , :PROVINCIA , :CIVICO , :CAP , :EMAIL , :FLG_ACCREDITATO , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :FLG_INDIRIZZO_ESTERO , :STATO_ESTERO , :CITTA_ESTERO , :INDIRIZZO_ESTERO , :CAP_ESTERO , :FLG_NEWSLETTER , :FLG_GDPR  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [NOME]
		params.addValue("NOME", dto.getNome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COGNOME]
		params.addValue("COGNOME", dto.getCognome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_L2]
		params.addValue("FK_L2", dto.getFkL2(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_SITAD]
		params.addValue("INDIRIZZO_SITAD", dto.getIndirizzoSitad(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_NON_TROVATO]
		params.addValue("INDIRIZZO_NON_TROVATO", dto.getIndirizzoNonTrovato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE]
		params.addValue("ISTAT_COMUNE", dto.getIstatComune(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SIGLA_PROV]
		params.addValue("SIGLA_PROV", dto.getSiglaProv(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE]
		params.addValue("COMUNE", dto.getComune(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROVINCIA]
		params.addValue("PROVINCIA", dto.getProvincia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO]
		params.addValue("CIVICO", dto.getCivico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP]
		params.addValue("CAP", dto.getCap(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [EMAIL]
		params.addValue("EMAIL", dto.getEmail(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_ACCREDITATO]
		params.addValue("FLG_ACCREDITATO", dto.getFlgAccreditato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_INDIRIZZO_ESTERO]
		params.addValue("FLG_INDIRIZZO_ESTERO", dto.getFlgIndirizzoEstero(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [STATO_ESTERO]
		params.addValue("STATO_ESTERO", dto.getStatoEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CITTA_ESTERO]
		params.addValue("CITTA_ESTERO", dto.getCittaEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_ESTERO]
		params.addValue("INDIRIZZO_ESTERO", dto.getIndirizzoEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP_ESTERO]
		params.addValue("CAP_ESTERO", dto.getCapEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_NEWSLETTER]
		params.addValue("FLG_NEWSLETTER", dto.getFlgNewsletter(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_GDPR]
		params.addValue("FLG_GDPR", dto.getFlgGdpr(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdPersonaFisica(newKey);
		LOG.debug("[SigitTPersonaFisicaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_PERSONA_FISICA table.
	 * @generated
	 */
	public void update(SigitTPersonaFisicaDto dto) throws SigitTPersonaFisicaDaoException {
		LOG.debug("[SigitTPersonaFisicaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET NOME = :NOME ,COGNOME = :COGNOME ,CODICE_FISCALE = :CODICE_FISCALE ,FK_L2 = :FK_L2 ,INDIRIZZO_SITAD = :INDIRIZZO_SITAD ,INDIRIZZO_NON_TROVATO = :INDIRIZZO_NON_TROVATO ,ISTAT_COMUNE = :ISTAT_COMUNE ,SIGLA_PROV = :SIGLA_PROV ,COMUNE = :COMUNE ,PROVINCIA = :PROVINCIA ,CIVICO = :CIVICO ,CAP = :CAP ,EMAIL = :EMAIL ,FLG_ACCREDITATO = :FLG_ACCREDITATO ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,FLG_INDIRIZZO_ESTERO = :FLG_INDIRIZZO_ESTERO ,STATO_ESTERO = :STATO_ESTERO ,CITTA_ESTERO = :CITTA_ESTERO ,INDIRIZZO_ESTERO = :INDIRIZZO_ESTERO ,CAP_ESTERO = :CAP_ESTERO ,FLG_NEWSLETTER = :FLG_NEWSLETTER ,FLG_GDPR = :FLG_GDPR  WHERE ID_PERSONA_FISICA = :ID_PERSONA_FISICA ";

		if (dto.getIdPersonaFisica() == null) {
			LOG.error("[SigitTPersonaFisicaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTPersonaFisicaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", dto.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [NOME]
		params.addValue("NOME", dto.getNome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COGNOME]
		params.addValue("COGNOME", dto.getCognome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_L2]
		params.addValue("FK_L2", dto.getFkL2(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_SITAD]
		params.addValue("INDIRIZZO_SITAD", dto.getIndirizzoSitad(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_NON_TROVATO]
		params.addValue("INDIRIZZO_NON_TROVATO", dto.getIndirizzoNonTrovato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE]
		params.addValue("ISTAT_COMUNE", dto.getIstatComune(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SIGLA_PROV]
		params.addValue("SIGLA_PROV", dto.getSiglaProv(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE]
		params.addValue("COMUNE", dto.getComune(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROVINCIA]
		params.addValue("PROVINCIA", dto.getProvincia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO]
		params.addValue("CIVICO", dto.getCivico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP]
		params.addValue("CAP", dto.getCap(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [EMAIL]
		params.addValue("EMAIL", dto.getEmail(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_ACCREDITATO]
		params.addValue("FLG_ACCREDITATO", dto.getFlgAccreditato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_INDIRIZZO_ESTERO]
		params.addValue("FLG_INDIRIZZO_ESTERO", dto.getFlgIndirizzoEstero(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [STATO_ESTERO]
		params.addValue("STATO_ESTERO", dto.getStatoEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CITTA_ESTERO]
		params.addValue("CITTA_ESTERO", dto.getCittaEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_ESTERO]
		params.addValue("INDIRIZZO_ESTERO", dto.getIndirizzoEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP_ESTERO]
		params.addValue("CAP_ESTERO", dto.getCapEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_NEWSLETTER]
		params.addValue("FLG_NEWSLETTER", dto.getFlgNewsletter(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_GDPR]
		params.addValue("FLG_GDPR", dto.getFlgGdpr(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTPersonaFisicaDaoImpl::update] END");
	}

	protected SigitTPersonaFisicaDaoRowMapper findByPrimaryKeyRowMapper = new SigitTPersonaFisicaDaoRowMapper(null,
			SigitTPersonaFisicaDto.class, this);

	protected SigitTPersonaFisicaDaoRowMapper findByCodFiscRowMapper = new SigitTPersonaFisicaDaoRowMapper(null,
			SigitTPersonaFisicaDto.class, this);

	protected SigitTPersonaFisicaDaoRowMapper findAllRowMapper = new SigitTPersonaFisicaDaoRowMapper(null,
			SigitTPersonaFisicaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_PERSONA_FISICA";
	}

	/** 
	 * Returns all rows from the SIGIT_T_PERSONA_FISICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTPersonaFisicaDto findByPrimaryKey(SigitTPersonaFisicaPk pk) throws SigitTPersonaFisicaDaoException {
		LOG.debug("[SigitTPersonaFisicaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA_FISICA,NOME,COGNOME,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,ISTAT_COMUNE,SIGLA_PROV,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,FLG_ACCREDITATO,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FLG_NEWSLETTER,FLG_GDPR FROM "
						+ getTableName() + " WHERE ID_PERSONA_FISICA = :ID_PERSONA_FISICA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", pk.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		List<SigitTPersonaFisicaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaFisicaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTPersonaFisicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaFisicaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaFisicaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder findByCodFisc
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaFisicaDto> findFindByCodFisc(java.lang.String input)
			throws SigitTPersonaFisicaDaoException {
		LOG.debug("[SigitTPersonaFisicaDaoImpl::findFindByCodFisc] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_FISICA,NOME,COGNOME,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,ISTAT_COMUNE,SIGLA_PROV,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,FLG_ACCREDITATO,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FLG_NEWSLETTER,FLG_GDPR ");
		sql.append(" FROM SIGIT_T_PERSONA_FISICA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-720836725) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("CODICE_FISCALE = :cf");
		sql.append(" ORDER BY ID_PERSONA_FISICA DESC");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R9462173) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("cf", input);

		/*PROTECTED REGION END*/
		List<SigitTPersonaFisicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByCodFiscRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaFisicaDaoImpl::findFindByCodFisc] esecuzione query", ex);
			throw new SigitTPersonaFisicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaFisicaDaoImpl", "findFindByCodFisc", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTPersonaFisicaDaoImpl::findFindByCodFisc] END");
		}
		return list;
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_PERSONA_FISICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaFisicaDto> findAll() throws SigitTPersonaFisicaDaoException {
		LOG.debug("[SigitTPersonaFisicaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA_FISICA,NOME,COGNOME,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,ISTAT_COMUNE,SIGLA_PROV,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,FLG_ACCREDITATO,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FLG_NEWSLETTER,FLG_GDPR FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTPersonaFisicaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaFisicaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitTPersonaFisicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaFisicaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaFisicaDaoImpl::findAll] END");
		}
		return list;
	}

}
