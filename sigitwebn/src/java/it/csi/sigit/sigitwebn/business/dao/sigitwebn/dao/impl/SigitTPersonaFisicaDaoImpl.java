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

/*PROTECTED REGION ID(R407140143) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTPersonaFisica.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byCodFisc (datagen::CustomFinder)
 *   - delegatiValidiByIdPersonaGiuridica (datagen::CustomFinder)
 *   - validatori (datagen::CustomFinder)
 *   - DaRuoloPA (datagen::CustomFinder)
 *   - byFilter (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
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

	/** 
	 * Deletes a single row in the SIGIT_T_PERSONA_FISICA table.
	 * @generated
	 */

	public void delete(SigitTPersonaFisicaPk pk) throws SigitTPersonaFisicaDaoException {
		LOG.debug("[SigitTPersonaFisicaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_PERSONA_FISICA = :ID_PERSONA_FISICA ";

		if (pk == null) {
			LOG.error("[SigitTPersonaFisicaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTPersonaFisicaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", pk.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTPersonaFisicaDaoImpl::delete] END");
	}

	protected SigitTPersonaFisicaDaoRowMapper findByPrimaryKeyRowMapper = new SigitTPersonaFisicaDaoRowMapper(null,
			SigitTPersonaFisicaDto.class, this);

	protected SigitTPersonaFisicaDaoRowMapper findAllRowMapper = new SigitTPersonaFisicaDaoRowMapper(null,
			SigitTPersonaFisicaDto.class, this);

	protected SigitTPersonaFisicaDaoRowMapper byCodFiscRowMapper = new SigitTPersonaFisicaDaoRowMapper(null,
			SigitTPersonaFisicaDto.class, this);

	protected SigitTPersonaFisicaDaoRowMapper delegatiValidiByIdPersonaGiuridicaRowMapper = new SigitTPersonaFisicaDaoRowMapper(
			null, SigitTPersonaFisicaDto.class, this);

	protected SigitTPersonaFisicaDaoRowMapper validatoriRowMapper = new SigitTPersonaFisicaDaoRowMapper(null,
			SigitTPersonaFisicaValidatoriDto.class, this);

	protected SigitTPersonaFisicaDaoRowMapper DaRuoloPARowMapper = new SigitTPersonaFisicaDaoRowMapper(null,
			SigitTPersonaFisicaDaRuoloPADto.class, this);

	protected SigitTPersonaFisicaDaoRowMapper byFilterRowMapper = new SigitTPersonaFisicaDaoRowMapper(null,
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

	/** 
	 * Implementazione del finder byCodFisc
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaFisicaDto> findByCodFisc(java.lang.String input) throws SigitTPersonaFisicaDaoException {
		LOG.debug("[SigitTPersonaFisicaDaoImpl::findByCodFisc] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_FISICA,NOME,COGNOME,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,ISTAT_COMUNE,SIGLA_PROV,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,FLG_ACCREDITATO,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FLG_NEWSLETTER,FLG_GDPR ");
		sql.append(" FROM SIGIT_T_PERSONA_FISICA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-477399791) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_FISCALE = :codFiscale");
		sql.append(" ORDER BY ID_PERSONA_FISICA DESC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1033927855) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codFiscale", input);

		/*PROTECTED REGION END*/
		List<SigitTPersonaFisicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodFiscRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaFisicaDaoImpl::findByCodFisc] esecuzione query", ex);
			throw new SigitTPersonaFisicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaFisicaDaoImpl", "findByCodFisc", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaFisicaDaoImpl::findByCodFisc] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder delegatiValidiByIdPersonaGiuridica
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaFisicaDto> findDelegatiValidiByIdPersonaGiuridica(java.math.BigDecimal input)
			throws SigitTPersonaFisicaDaoException {
		LOG.debug("[SigitTPersonaFisicaDaoImpl::findDelegatiValidiByIdPersonaGiuridica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R897635680) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT pf.ID_PERSONA_FISICA,NOME,COGNOME,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,FLG_ACCREDITATO,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FLG_NEWSLETTER,pf.DATA_ULT_MOD,pf.UTENTE_ULT_MOD,FLG_GDPR ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-211009550) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_PERSONA_FISICA pf, SIGIT_R_PF_PG_DELEGA del");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1831274312) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" pf.ID_PERSONA_FISICA = del.ID_PERSONA_FISICA ");
		sql.append(" AND del.DATA_FINE IS NULL");
		sql.append(" AND del.ID_PERSONA_GIURIDICA = :idPeronaGiuridica");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1815492602) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idPeronaGiuridica", input);

		/*PROTECTED REGION END*/
		List<SigitTPersonaFisicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, delegatiValidiByIdPersonaGiuridicaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaFisicaDaoImpl::findDelegatiValidiByIdPersonaGiuridica] esecuzione query", ex);
			throw new SigitTPersonaFisicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaFisicaDaoImpl", "findDelegatiValidiByIdPersonaGiuridica",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaFisicaDaoImpl::findDelegatiValidiByIdPersonaGiuridica] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder validatori con Qdef
		 * @generated
		 */

	public List<SigitTPersonaFisicaValidatoriDto> findValidatori(java.lang.String input)
			throws SigitTPersonaFisicaDaoException {
		LOG.debug("[SigitTPersonaFisicaDaoImpl::findValidatori] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT pf.ID_PERSONA_FISICA, pf.NOME, pf.COGNOME, pf.CODICE_FISCALE");

		sql.append(" FROM SIGIT_T_PERSONA_FISICA pf, SIGIT_R_PF_RUOLO_PA ruolo");

		sql.append(" WHERE ");

		sql.append("pf.ID_PERSONA_FISICA = ruolo.ID_PERSONA_FISICA");

		sql.append(" AND ");

		sql.append("ruolo.id_ruolo_pa = 4");
		/*PROTECTED REGION ID(R1641742832) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" AND ruolo.DATA_FINE IS NULL");

		sql.append(" GROUP BY pf.ID_PERSONA_FISICA, pf.NOME, pf.COGNOME ");
		sql.append(" ORDER BY pf.COGNOME, pf.NOME ");
		//paramMap.addValue("param", input);

		/*PROTECTED REGION END*/

		List<SigitTPersonaFisicaValidatoriDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, validatoriRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaFisicaDaoImpl::findValidatori] ERROR esecuzione query", ex);
			throw new SigitTPersonaFisicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaFisicaDaoImpl", "findValidatori", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaFisicaDaoImpl::findValidatori] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder DaRuoloPA con Qdef
		 * @generated
		 */

	public List<SigitTPersonaFisicaDaRuoloPADto> findDaRuoloPA(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.PersonaRuoloFilter input)
			throws SigitTPersonaFisicaDaoException {
		LOG.debug("[SigitTPersonaFisicaDaoImpl::findDaRuoloPA] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT pf.ID_PERSONA_FISICA, pf.NOME, pf.COGNOME, pf.CODICE_FISCALE");

		sql.append(" FROM SIGIT_T_PERSONA_FISICA pf, SIGIT_R_PF_RUOLO_PA ruolo");

		sql.append(" WHERE ");

		sql.append("pf.ID_PERSONA_FISICA = ruolo.ID_PERSONA_FISICA");

		sql.append(" AND ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R-1087795834) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		if (input.getIdRuolo() != null) {
			sql.append(" AND ruolo.id_ruolo_pa = :ruolo");
			paramMap.addValue("ruolo", input.getIdRuolo());
		}

		if (input.isSoloAttivi()) {
			sql.append(" AND ruolo.DATA_FINE IS NULL");
		}

		//sql.append(" AND ruolo.data_fine IS NULL");

		sql.append(" GROUP BY pf.ID_PERSONA_FISICA, pf.NOME, pf.COGNOME, pf.CODICE_FISCALE");

		sql.append(" ORDER BY pf.COGNOME, pf.NOME ");
		/*PROTECTED REGION END*/

		List<SigitTPersonaFisicaDaRuoloPADto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, DaRuoloPARowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaFisicaDaoImpl::findDaRuoloPA] ERROR esecuzione query", ex);
			throw new SigitTPersonaFisicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaFisicaDaoImpl", "findDaRuoloPA", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaFisicaDaoImpl::findDaRuoloPA] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaFisicaDto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaPersonaGiuridicaFisicaFilter input)
			throws SigitTPersonaFisicaDaoException {
		LOG.debug("[SigitTPersonaFisicaDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R1555820602) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_PERSONA_FISICA,NOME,COGNOME,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,ISTAT_COMUNE,SIGLA_PROV,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,FLG_ACCREDITATO,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FLG_NEWSLETTER,FLG_GDPR ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R8669516) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_PERSONA_FISICA");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R51390766) ENABLED START*/
		sql.append(" 1 = 1 ");

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceFiscale())) {
			sql.append(" AND  CODICE_FISCALE = :codiceFiscale ");
			paramMap.addValue("codiceFiscale", input.getCodiceFiscale().toUpperCase());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getNome())) {
			sql.append(" AND  UPPER(NOME) LIKE :nome ");
			paramMap.addValue("nome", "%" + input.getNome().toUpperCase() + "%");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCognomeDenominazione())) {
			sql.append(" AND  UPPER(COGNOME) LIKE :cognome ");
			paramMap.addValue("cognome", "%" + input.getCognomeDenominazione().toUpperCase() + "%");
		}

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1821289772) ENABLED START*/
		//***aggiungere tutte le condizioni

		/*PROTECTED REGION END*/
		List<SigitTPersonaFisicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaFisicaDaoImpl::findByFilter] esecuzione query", ex);
			throw new SigitTPersonaFisicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaFisicaDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaFisicaDaoImpl::findByFilter] END");
		}
		return list;
	}

}
