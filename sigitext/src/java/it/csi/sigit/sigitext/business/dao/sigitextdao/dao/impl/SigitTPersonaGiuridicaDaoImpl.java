package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*PROTECTED REGION END*/
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTPersonaGiuridicaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.PersonaGiuridicaDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTPersonaGiuridicaDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTPersonaGiuridicaJoinSigitRPgPgNominaDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.PersonaGiuridica;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaJoinSigitRPgPgNominaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTPersonaGiuridicaDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.sigit.sigitext.business.util.GenericUtil;
import it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException;
import it.csi.util.performance.StopWatch;

/**
 * Implementazione del DAO sigitTPersonaGiuridica.
 * Il DAO implementa le seguenti operazioni:
 * - FINDERS:
 * - findByPrimaryKey (datagen::FindByPK)
 * - byCodiceReaAndFiscale (datagen::CustomFinder)
 * - UPDATERS:
 * <p>
 * --
 * - DELETERS:
 * <p>
 * --
 * <p>
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 *
 * @generated
 */
public class SigitTPersonaGiuridicaDaoImpl extends AbstractDAO implements SigitTPersonaGiuridicaDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	protected static final String QUERY_VARS_SELECT = "ID_PERSONA_GIURIDICA,"
			+ "DENOMINAZIONE,"
			+ "CODICE_FISCALE,"
			+ "FK_L2,"
			+ "INDIRIZZO_SITAD,"
			+ "INDIRIZZO_NON_TROVATO,"
			+ "SIGLA_PROV,"
			+ "ISTAT_COMUNE,"
			+ "COMUNE,"
			+ "PROVINCIA,"
			+ "CIVICO,"
			+ "CAP,"
			+ "EMAIL,"
			+ "DATA_INIZIO_ATTIVITA,"
			+ "DATA_CESSAZIONE,"
			+ "SIGLA_REA,"
			+ "NUMERO_REA,"
			+ "FLG_AMMINISTRATORE,"
			+ "DATA_ULT_MOD,"
			+ "UTENTE_ULT_MOD,"
			+ "FLG_TERZO_RESPONSABILE,"
			+ "FLG_DISTRIBUTORE,"
			+ "FLG_CAT,"
			+ "FLG_INDIRIZZO_ESTERO,"
			+ "STATO_ESTERO,"
			+ "CITTA_ESTERO,"
			+ "INDIRIZZO_ESTERO,"
			+ "CAP_ESTERO,"
			+ "FK_STATO_PG,"
			+ "DT_AGG_DICHIARAZIONE,"
			+ "FLG_DM37_LETTERAC,"
			+ "FLG_DM37_LETTERAD,"
			+ "FLG_DM37_LETTERAE,"
			+ "FLG_FGAS,"
			+ "FLG_CONDUTTORE,"
			+ "FLG_SOGG_INCARICATO,"
			+ "DELEGA_SOGG_INCARICATO,"
			+ "DT_CREAZIONE_TOKEN,"
			+ "DT_SCADENZA_TOKEN,"
			+ "TOKEN,"
			+ "TELEFONO,"
			+ "PEC";
	
	protected static final String QUERY_VARS_SELECT_PERSONA_GIURIDICA = "sigit_t_persona_giuridica.ID_PERSONA_GIURIDICA,"
			+ "sigit_t_persona_giuridica.DENOMINAZIONE,"
			+ "sigit_t_persona_giuridica.CODICE_FISCALE,"
			+ "sigit_t_persona_giuridica.FK_L2,"
			+ "sigit_t_persona_giuridica.INDIRIZZO_SITAD,"
			+ "sigit_t_persona_giuridica.INDIRIZZO_NON_TROVATO,"
			+ "sigit_t_persona_giuridica.SIGLA_PROV,"
			+ "sigit_t_persona_giuridica.ISTAT_COMUNE,"
			+ "sigit_t_persona_giuridica.COMUNE,"
			+ "sigit_t_persona_giuridica.PROVINCIA,"
			+ "sigit_t_persona_giuridica.CIVICO,"
			+ "sigit_t_persona_giuridica.CAP,"
			+ "sigit_t_persona_giuridica.EMAIL,"
			+ "sigit_t_persona_giuridica.DATA_INIZIO_ATTIVITA,"
			+ "sigit_t_persona_giuridica.DATA_CESSAZIONE,"
			+ "sigit_t_persona_giuridica.SIGLA_REA,"
			+ "sigit_t_persona_giuridica.NUMERO_REA,"
			+ "sigit_t_persona_giuridica.FLG_AMMINISTRATORE,"
			+ "sigit_t_persona_giuridica.DATA_ULT_MOD,"
			+ "sigit_t_persona_giuridica.UTENTE_ULT_MOD,"
			+ "sigit_t_persona_giuridica.FLG_TERZO_RESPONSABILE,"
			+ "sigit_t_persona_giuridica.FLG_DISTRIBUTORE,"
			+ "sigit_t_persona_giuridica.FLG_CAT,"
			+ "sigit_t_persona_giuridica.FLG_INDIRIZZO_ESTERO,"
			+ "sigit_t_persona_giuridica.STATO_ESTERO,"
			+ "sigit_t_persona_giuridica.CITTA_ESTERO,"
			+ "sigit_t_persona_giuridica.INDIRIZZO_ESTERO,"
			+ "sigit_t_persona_giuridica.CAP_ESTERO,"
			+ "sigit_t_persona_giuridica.FK_STATO_PG,"
			+ "sigit_t_persona_giuridica.DT_AGG_DICHIARAZIONE,"
			+ "sigit_t_persona_giuridica.FLG_DM37_LETTERAC,"
			+ "sigit_t_persona_giuridica.FLG_DM37_LETTERAD,"
			+ "sigit_t_persona_giuridica.FLG_DM37_LETTERAE,"
			+ "sigit_t_persona_giuridica.FLG_FGAS,"
			+ "sigit_t_persona_giuridica.FLG_CONDUTTORE,"
			+ "sigit_t_persona_giuridica.FLG_SOGG_INCARICATO,"
			+ "sigit_t_persona_giuridica.DELEGA_SOGG_INCARICATO,"
			+ "sigit_t_persona_giuridica.DT_CREAZIONE_TOKEN,"
			+ "sigit_t_persona_giuridica.DT_SCADENZA_TOKEN,"
			+ "sigit_t_persona_giuridica.TOKEN,"
			+ "sigit_t_persona_giuridica.PEC,"
			+ "sigit_t_persona_giuridica.TELEFONO,"
			+ "sigit_t_persona_giuridica.TELEFONO,"
			+ "sigit_t_persona_giuridica.PEC";
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

	protected SigitTPersonaGiuridicaDaoRowMapper findByPrimaryKeyRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(null, SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper byCodiceReaAndFiscaleRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(null, SigitTPersonaGiuridicaDto.class, this);
	
	protected SigitTPersonaGiuridicaDaoRowMapper findByDenominazioneAndComuneRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(null, SigitTPersonaGiuridicaDto.class, this);

	protected PersonaGiuridicaDaoRowMapper findByPrimaryKeyDescRowMapper = new PersonaGiuridicaDaoRowMapper(null, PersonaGiuridica.class, this);
	
	protected SigitTPersonaGiuridicaJoinSigitRPgPgNominaDaoRowMapper findSigitTPersonaGiuridicaJoinSigitRPgPgNominaDaoRowMapper = new SigitTPersonaGiuridicaJoinSigitRPgPgNominaDaoRowMapper(null, SigitTPersonaGiuridicaJoinSigitRPgPgNominaDto.class, this);

	/**
	 * Restituisce il nome della tabella su cui opera il DAO
	 *
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_PERSONA_GIURIDICA";
	}

	/**
	 * Returns all rows from the SIGIT_T_PERSONA_GIURIDICA table that match the primary key criteria
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTPersonaGiuridicaDto findByPrimaryKey(SigitTPersonaGiuridicaPk pk) throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN,TELEFONO,PEC FROM "
						+ getTableName() + " WHERE ID_PERSONA_GIURIDICA = :ID_PERSONA_GIURIDICA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA]
		params.addValue("ID_PERSONA_GIURIDICA", pk.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);

		List<SigitTPersonaGiuridicaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PersonaGiuridica findByPrimaryKeyDescStato(SigitTPersonaGiuridicaPk pk) throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN,TELEFONO,PEC, sigit_d_stato_pg.des_stato_pg FROM "
						+ getTableName() + " JOIN SIGIT_D_STATO_PG ON " + getTableName() + ".FK_STATO_PG = SIGIT_D_STATO_PG.ID_STATO_PG WHERE ID_PERSONA_GIURIDICA = :ID_PERSONA_GIURIDICA");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA]
		params.addValue("ID_PERSONA_GIURIDICA", pk.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);

		List<PersonaGiuridica> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyDescRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * Implementazione del finder byCodiceReaAndFiscale
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findByCodiceReaAndFiscale(it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CodiceReaAndFiscaleFilter input)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByCodiceReaAndFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN,TELEFONO,PEC ");
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA");
		sql.append(" WHERE ");
		sql.append(" 1 = 1");
		if (GenericUtil.isNotNullOrEmpty(input.getSiglaRea())) {
			sql.append(" AND SIGLA_REA = :siglaRea");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getNumeroRea())) {
			sql.append(" AND NUMERO_REA = :numeroRea");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceFiscale())) {
			sql.append(" AND UPPER(CODICE_FISCALE) = UPPER(:codFiscale)");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaRea())) {
			paramMap.addValue("siglaRea", input.getSiglaRea());
		}
		if (GenericUtil.isNotNullOrEmpty(input.getNumeroRea())) {
			paramMap.addValue("numeroRea", input.getNumeroRea());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceFiscale())) {
			paramMap.addValue("codFiscale", input.getCodiceFiscale());
		}

		/*PROTECTED REGION END*/
		List<SigitTPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceReaAndFiscaleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findByCodiceReaAndFiscale] esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findByCodiceReaAndFiscale", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByCodiceReaAndFiscale] END");
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SigitTPersonaGiuridicaDto> findByPiva(String piva) throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByCodiceReaAndFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN,TELEFONO,PEC ");
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA");
		sql.append(" WHERE ");
		sql.append("UPPER(CODICE_FISCALE) = UPPER(:codFiscale)");
		paramMap.addValue("codFiscale", piva);
		List<SigitTPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceReaAndFiscaleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findByCodiceReaAndFiscale] esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findByCodiceReaAndFiscale", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByCodiceReaAndFiscale] END");
		}
		return list;
	}

	public void update(SigitTPersonaGiuridicaDto dto) throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DENOMINAZIONE = :DENOMINAZIONE ,"
				+ "CODICE_FISCALE = :CODICE_FISCALE ,"
				+ "FK_L2 = :FK_L2 ,"
				+ "INDIRIZZO_SITAD = :INDIRIZZO_SITAD ,"
				+ "INDIRIZZO_NON_TROVATO = :INDIRIZZO_NON_TROVATO ,"
				+ "SIGLA_PROV = :SIGLA_PROV ,"
				+ "ISTAT_COMUNE = :ISTAT_COMUNE ,"
				+ "COMUNE = :COMUNE ,"
				+ "PROVINCIA = :PROVINCIA ,"
				+ "CIVICO = :CIVICO ,"
				+ "CAP = :CAP ,"
				+ "EMAIL = :EMAIL ,"
				+ "DATA_INIZIO_ATTIVITA = :DATA_INIZIO_ATTIVITA ,"
				+ "DATA_CESSAZIONE = :DATA_CESSAZIONE ,"
				+ "SIGLA_REA = :SIGLA_REA ,"
				+ "NUMERO_REA = :NUMERO_REA ,"
				+ "FLG_AMMINISTRATORE = :FLG_AMMINISTRATORE ,"
				+ "DATA_ULT_MOD = :DATA_ULT_MOD ,"
				+ "UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,"
				+ "FLG_TERZO_RESPONSABILE = :FLG_TERZO_RESPONSABILE ,"
				+ "FLG_DISTRIBUTORE = :FLG_DISTRIBUTORE ,"
				+ "FLG_CAT = :FLG_CAT ,"
				+ "FLG_INDIRIZZO_ESTERO = :FLG_INDIRIZZO_ESTERO ,"
				+ "STATO_ESTERO = :STATO_ESTERO ,"
				+ "CITTA_ESTERO = :CITTA_ESTERO ,"
				+ "INDIRIZZO_ESTERO = :INDIRIZZO_ESTERO ,"
				+ "CAP_ESTERO = :CAP_ESTERO ,"
				+ "FK_STATO_PG = :FK_STATO_PG ,"
				+ "DT_AGG_DICHIARAZIONE = :DT_AGG_DICHIARAZIONE ,"
				+ "FLG_DM37_LETTERAC = :FLG_DM37_LETTERAC ,"
				+ "FLG_DM37_LETTERAD = :FLG_DM37_LETTERAD ,"
				+ "FLG_DM37_LETTERAE = :FLG_DM37_LETTERAE ,"
				+ "FLG_FGAS = :FLG_FGAS ,"
				+ "FLG_CONDUTTORE = :FLG_CONDUTTORE ,"
				+ "FLG_SOGG_INCARICATO = :FLG_SOGG_INCARICATO ,"
				+ "DELEGA_SOGG_INCARICATO = :DELEGA_SOGG_INCARICATO ,"
				+ "DT_CREAZIONE_TOKEN = :DT_CREAZIONE_TOKEN ,"
				+ "DT_SCADENZA_TOKEN = :DT_SCADENZA_TOKEN ,"
				+ "PEC = :PEC ,"
				+ "TELEFONO = :TELEFONO ,"
				+ "TOKEN = :TOKEN "
				+ "WHERE ID_PERSONA_GIURIDICA = :ID_PERSONA_GIURIDICA ";

		if (dto.getIdPersonaGiuridica() == null) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTPersonaGiuridicaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA]
		params.addValue("ID_PERSONA_GIURIDICA", dto.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DENOMINAZIONE]
		params.addValue("DENOMINAZIONE", dto.getDenominazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_L2]
		params.addValue("FK_L2", dto.getFkL2(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_SITAD]
		params.addValue("INDIRIZZO_SITAD", dto.getIndirizzoSitad(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_NON_TROVATO]
		params.addValue("INDIRIZZO_NON_TROVATO", dto.getIndirizzoNonTrovato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SIGLA_PROV]
		params.addValue("SIGLA_PROV", dto.getSiglaProv(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE]
		params.addValue("ISTAT_COMUNE", dto.getIstatComune(), java.sql.Types.VARCHAR);

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

		// valorizzazione paametro relativo a colonna [DATA_INIZIO_ATTIVITA]
		params.addValue("DATA_INIZIO_ATTIVITA", dto.getDataInizioAttivita(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_CESSAZIONE]
		params.addValue("DATA_CESSAZIONE", dto.getDataCessazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [SIGLA_REA]
		params.addValue("SIGLA_REA", dto.getSiglaRea(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NUMERO_REA]
		params.addValue("NUMERO_REA", dto.getNumeroRea(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_AMMINISTRATORE]
		params.addValue("FLG_AMMINISTRATORE", dto.getFlgAmministratore(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_TERZO_RESPONSABILE]
		params.addValue("FLG_TERZO_RESPONSABILE", dto.getFlgTerzoResponsabile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_DISTRIBUTORE]
		params.addValue("FLG_DISTRIBUTORE", dto.getFlgDistributore(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_CAT]
		params.addValue("FLG_CAT", dto.getFlgCat(), java.sql.Types.NUMERIC);

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

		// valorizzazione paametro relativo a colonna [FK_STATO_PG]
		params.addValue("FK_STATO_PG", dto.getFkStatoPg(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DT_AGG_DICHIARAZIONE]
		params.addValue("DT_AGG_DICHIARAZIONE", dto.getDtAggDichiarazione(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FLG_DM37_LETTERAC]
		params.addValue("FLG_DM37_LETTERAC", dto.getFlgDm37Letterac(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_DM37_LETTERAD]
		params.addValue("FLG_DM37_LETTERAD", dto.getFlgDm37Letterad(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_DM37_LETTERAE]
		params.addValue("FLG_DM37_LETTERAE", dto.getFlgDm37Letterae(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_FGAS]
		params.addValue("FLG_FGAS", dto.getFlgFgas(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_CONDUTTORE]
		params.addValue("FLG_CONDUTTORE", dto.getFlgConduttore(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SOGG_INCARICATO]
		params.addValue("FLG_SOGG_INCARICATO", dto.getFlgSoggIncaricato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DELEGA_SOGG_INCARICATO]
		params.addValue("DELEGA_SOGG_INCARICATO", dto.getDelegaSoggIncaricato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DT_CREAZIONE_TOKEN]
		params.addValue("DT_CREAZIONE_TOKEN", dto.getDtCreazioneToken(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DT_SCADENZA_TOKEN]
		params.addValue("DT_SCADENZA_TOKEN", dto.getDtScadenzaToken(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [TOKEN]
		params.addValue("TOKEN", dto.getToken(), java.sql.Types.VARCHAR);
		
		// valorizzazione paametro relativo a colonna [PEC]
		params.addValue("PEC", dto.getPec(), java.sql.Types.VARCHAR);
		
		// valorizzazione paametro relativo a colonna [TELEFONO]
		params.addValue("TELEFONO", dto.getTelefono(), java.sql.Types.VARCHAR);
				

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::update] END");
	}

	public SigitTPersonaGiuridicaPk insert(SigitTPersonaGiuridicaDto dto)

	{
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN,PEC,TELEFONO ) VALUES (  :ID_PERSONA_GIURIDICA , :DENOMINAZIONE , :CODICE_FISCALE , :FK_L2 , :INDIRIZZO_SITAD , :INDIRIZZO_NON_TROVATO , :SIGLA_PROV , :ISTAT_COMUNE , :COMUNE , :PROVINCIA , :CIVICO , :CAP , :EMAIL , :DATA_INIZIO_ATTIVITA , :DATA_CESSAZIONE , :SIGLA_REA , :NUMERO_REA , :FLG_AMMINISTRATORE , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :FLG_TERZO_RESPONSABILE , :FLG_DISTRIBUTORE , :FLG_CAT , :FLG_INDIRIZZO_ESTERO , :STATO_ESTERO , :CITTA_ESTERO , :INDIRIZZO_ESTERO , :CAP_ESTERO , :FK_STATO_PG , :DT_AGG_DICHIARAZIONE , :FLG_DM37_LETTERAC , :FLG_DM37_LETTERAD , :FLG_DM37_LETTERAE , :FLG_FGAS , :FLG_CONDUTTORE , :FLG_SOGG_INCARICATO , :DELEGA_SOGG_INCARICATO , :DT_CREAZIONE_TOKEN , :DT_SCADENZA_TOKEN , :TOKEN , :PEC , :TELEFONO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA]
		params.addValue("ID_PERSONA_GIURIDICA", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DENOMINAZIONE]
		params.addValue("DENOMINAZIONE", dto.getDenominazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_L2]
		params.addValue("FK_L2", dto.getFkL2(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_SITAD]
		params.addValue("INDIRIZZO_SITAD", dto.getIndirizzoSitad(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_NON_TROVATO]
		params.addValue("INDIRIZZO_NON_TROVATO", dto.getIndirizzoNonTrovato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SIGLA_PROV]
		params.addValue("SIGLA_PROV", dto.getSiglaProv(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE]
		params.addValue("ISTAT_COMUNE", dto.getIstatComune(), java.sql.Types.VARCHAR);

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

		// valorizzazione paametro relativo a colonna [DATA_INIZIO_ATTIVITA]
		params.addValue("DATA_INIZIO_ATTIVITA", dto.getDataInizioAttivita(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_CESSAZIONE]
		params.addValue("DATA_CESSAZIONE", dto.getDataCessazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [SIGLA_REA]
		params.addValue("SIGLA_REA", dto.getSiglaRea(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NUMERO_REA]
		params.addValue("NUMERO_REA", dto.getNumeroRea(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_AMMINISTRATORE]
		params.addValue("FLG_AMMINISTRATORE", dto.getFlgAmministratore(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_TERZO_RESPONSABILE]
		params.addValue("FLG_TERZO_RESPONSABILE", dto.getFlgTerzoResponsabile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_DISTRIBUTORE]
		params.addValue("FLG_DISTRIBUTORE", dto.getFlgDistributore(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_CAT]
		params.addValue("FLG_CAT", dto.getFlgCat(), java.sql.Types.NUMERIC);

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

		// valorizzazione paametro relativo a colonna [FK_STATO_PG]
		params.addValue("FK_STATO_PG", dto.getFkStatoPg(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DT_AGG_DICHIARAZIONE]
		params.addValue("DT_AGG_DICHIARAZIONE", dto.getDtAggDichiarazione(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FLG_DM37_LETTERAC]
		params.addValue("FLG_DM37_LETTERAC", dto.getFlgDm37Letterac(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_DM37_LETTERAD]
		params.addValue("FLG_DM37_LETTERAD", dto.getFlgDm37Letterad(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_DM37_LETTERAE]
		params.addValue("FLG_DM37_LETTERAE", dto.getFlgDm37Letterae(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_FGAS]
		params.addValue("FLG_FGAS", dto.getFlgFgas(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_CONDUTTORE]
		params.addValue("FLG_CONDUTTORE", dto.getFlgConduttore(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SOGG_INCARICATO]
		params.addValue("FLG_SOGG_INCARICATO", dto.getFlgSoggIncaricato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DELEGA_SOGG_INCARICATO]
		params.addValue("DELEGA_SOGG_INCARICATO", dto.getDelegaSoggIncaricato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DT_CREAZIONE_TOKEN]
		params.addValue("DT_CREAZIONE_TOKEN", dto.getDtCreazioneToken(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DT_SCADENZA_TOKEN]
		params.addValue("DT_SCADENZA_TOKEN", dto.getDtScadenzaToken(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [TOKEN]
		params.addValue("TOKEN", dto.getToken(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PEC]
		params.addValue("PEC", dto.getPec(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TELEFONO]
		params.addValue("TELEFONO", dto.getTelefono(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdPersonaGiuridica(newKey);
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::insert] END");
		return dto.createPk();

	}
	
	@Override
	public List<String> getComuniPG() throws SigitExtDaoException {
		String nomeMetodo = "getComuniPG";
		LOG.debug("[SigitExtDaoImpl::" + nomeMetodo + "] START");
		StringBuilder query = new StringBuilder("SELECT DISTINCT comune FROM sigit_t_persona_giuridica")
				.append(" WHERE comune IS NOT NULL AND fk_stato_pg = 1");
		List<String> result = new ArrayList<String>();
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			result = jdbcTemplate.queryForList(query.toString(), new MapSqlParameterSource(), String.class);
			Collections.sort(result);
		} catch (RuntimeException ex) {
			LOG.error("[SigitExtDaoImpl::" + nomeMetodo + "] esecuzione query", ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", nomeMetodo, "esecuzione query", query.toString());
			LOG.debug("[SigitExtDaoImpl::" + nomeMetodo + "] END");
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SigitTPersonaGiuridicaDto> getManutentori(String denominazione, String comune) throws SigitExtDaoException, SigitExcessiveResultsException {
		String nomeMetodo = "getManuntentori";
		LOG.debug("[SigitExtDaoImpl::" + nomeMetodo + "] START");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		StringBuilder select = new StringBuilder("SELECT ")
				.append(QUERY_VARS_SELECT),
				count = new StringBuilder("SELECT COUNT(*)");
		StringBuilder query = new StringBuilder(" FROM sigit_t_persona_giuridica WHERE")
				.append(" fk_stato_pg = '1'")
				.append(" AND (flg_dm37_letterac = 1")
				.append(" OR flg_dm37_letterad = 1")
				.append(" OR flg_dm37_letterae = 1")
				.append(" OR flg_terzo_responsabile = 1)");
		if(denominazione != null && !denominazione.trim().isEmpty()) {
			query.append(this.getLikeCondition("denominazione", false));
			paramMap.addValue("denominazione", denominazione);
		}
		if(comune != null && !comune.trim().isEmpty()) {
			query.append(this.getLikeCondition("comune", true));
			paramMap.addValue("comune", comune);
		}
		List<SigitTPersonaGiuridicaDto> result = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			count.append(query);
			select.append(query);
			stopWatch.start();
			int countQuery = jdbcTemplate.queryForInt(count.toString(), paramMap);
			int maxCount = Constants.MAX_COUNT_SQL;
			if(countQuery > maxCount) {
				throw new SigitExcessiveResultsException(Constants.getMessaggeErrorDefaultCount(countQuery, maxCount));
			}
			result = jdbcTemplate.query(select.toString(), paramMap, findByDenominazioneAndComuneRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitExtDaoImpl::" + nomeMetodo + "] esecuzione query", ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", nomeMetodo, "esecuzione query", query.toString());
			LOG.debug("[SigitExtDaoImpl::" + nomeMetodo + "] END");
		}
		return result;
	}
	
	public List<SigitTPersonaGiuridicaDto> getPersonaGiuridicaByCF(String codiceFiscale) throws SigitExtDaoException, SigitExcessiveResultsException {
		String nomeMetodo = "getPersonaGiuridicaByCF";
		LOG.debug("[SigitExtDaoImpl::" + nomeMetodo + "] START");
		
		List<SigitTPersonaGiuridicaDto> result = null;
		
		String queryString = "SELECT " 
				+ QUERY_VARS_SELECT_PERSONA_GIURIDICA
				+ " FROM sigit_r_pf_pg_delega "
				+ "LEFT OUTER JOIN sigit_t_persona_fisica "
				+ "ON sigit_r_pf_pg_delega.id_persona_fisica = sigit_t_persona_fisica.id_persona_fisica "
				+ "LEFT OUTER JOIN sigit_t_persona_giuridica "
				+ "ON sigit_r_pf_pg_delega.id_persona_giuridica = sigit_t_persona_giuridica.id_persona_giuridica "
				+ "WHERE sigit_t_persona_fisica.codice_fiscale = :codice_fiscale "
				+ "AND sigit_r_pf_pg_delega.data_fine IS NULL";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codice_fiscale", codiceFiscale, java.sql.Types.CHAR);
		
		try {
			result = jdbcTemplate.query(queryString, params, findByDenominazioneAndComuneRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitExtDaoImpl::" + nomeMetodo + "] esecuzione query", ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			LOG.debug("[SigitExtDaoImpl::" + nomeMetodo + "] END");
		}
		return result;
	}
	
	/***
	 * Se sigla rea e numero rea non vengono passati non sono aggiunti alla query
	 */
	public List<SigitTPersonaGiuridicaDto> getPersonaGiuridicaByCFAndCodiceRea(String codiceFiscale, String siglaRea, BigDecimal numeroRea) throws SigitExtDaoException, SigitExcessiveResultsException {
		String nomeMetodo = "getPersonaGiuridicaByCFAndCodiceRea";
		LOG.debug("[SigitExtDaoImpl::" + nomeMetodo + "] START");
		
		List<SigitTPersonaGiuridicaDto> result = null;
		
		String queryString = "SELECT " 
				+ QUERY_VARS_SELECT_PERSONA_GIURIDICA
				+ " FROM sigit_t_persona_giuridica "
				+ "WHERE codice_fiscale = :codice_fiscale ";
		if(siglaRea != null && numeroRea != null) {
			queryString = queryString + "AND sigla_rea = :siglaRea AND numero_rea = :numeroRea";
		}
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codice_fiscale", codiceFiscale, java.sql.Types.CHAR);
		if(siglaRea != null && numeroRea != null) {
			params.addValue("siglaRea", siglaRea, java.sql.Types.CHAR);
			params.addValue("numeroRea", numeroRea, java.sql.Types.NUMERIC);
		}
		
		try {
			result = jdbcTemplate.query(queryString, params, findByDenominazioneAndComuneRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitExtDaoImpl::" + nomeMetodo + "] esecuzione query", ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			LOG.debug("[SigitExtDaoImpl::" + nomeMetodo + "] END");
		}
		return result;
	}
	
	public List<SigitTPersonaGiuridicaJoinSigitRPgPgNominaDto> getSigitTPersonaGiuridicaJoinSigitRPgPgNominaDtoByIdPersonaGiuridicaImpresa(Integer idPersonaGiuridicaImpresa) throws SigitExtDaoException{
		String nomeMetodo = "getSigitTPersonaGiuridicaJoinSigitRPgPgNominaDtoByIdPersonaGiuridicaImpresa";
		LOG.debug("[SigitExtDaoImpl::" + nomeMetodo + "] START");
		
		List<SigitTPersonaGiuridicaJoinSigitRPgPgNominaDto> result = null;
		
		String queryString = "select sigit_r_pg_pg_nomina.id_persona_giuridica_impresa, sigit_r_pg_pg_nomina.id_persona_giuridica_cat, sigit_t_persona_giuridica.denominazione, sigit_t_persona_giuridica.codice_fiscale, sigit_r_pg_pg_nomina.data_inizio, sigit_r_pg_pg_nomina.data_fine "
				+ "from sigit_r_pg_pg_nomina "
				+ "left outer join sigit_t_persona_giuridica "
				+ "on sigit_r_pg_pg_nomina.id_persona_giuridica_cat = sigit_t_persona_giuridica.id_persona_giuridica "
				+ "where sigit_r_pg_pg_nomina.id_persona_giuridica_impresa = :id_persona_giuridica_impresa and sigit_r_pg_pg_nomina.data_fine is null";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_persona_giuridica_impresa", idPersonaGiuridicaImpresa, java.sql.Types.NUMERIC);
		
		try {
			result = jdbcTemplate.query(queryString, params, findSigitTPersonaGiuridicaJoinSigitRPgPgNominaDaoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitExtDaoImpl::" + nomeMetodo + "] esecuzione query", ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			LOG.debug("[SigitExtDaoImpl::" + nomeMetodo + "] END");
		}
		return result;
	}
	
	public List<Map<String, Object>> getPersonaGiuridicaByFlgCatOne() throws SigitExtDaoException, SigitExcessiveResultsException {
		String nomeMetodo = "getPersonaGiuridicaByFlgCatOne";
		LOG.debug("[SigitExtDaoImpl::" + nomeMetodo + "] START");
		
		List<Map<String, Object>> result = null;
		
		String queryString = "SELECT " 
				+ "denominazione, id_persona_giuridica "
				+ "FROM "
				+ getTableName()
				+ " WHERE flg_cat = :flg_cat "
				+ "AND data_cessazione IS NULL";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("flg_cat", 1, java.sql.Types.NUMERIC);
		
		try {
			result = jdbcTemplate.queryForList(queryString, params);
			
		} catch (RuntimeException ex) {
			LOG.error("[SigitExtDaoImpl::" + nomeMetodo + "] esecuzione query", ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			LOG.debug("[SigitExtDaoImpl::" + nomeMetodo + "] END");
		}
		return result;
	}
	
	private String getLikeCondition(String nome, boolean useEquals) {
		if(useEquals)
			return " AND UPPER(" + nome + ") = UPPER(:" + nome + ")";
		return " AND UPPER(" + nome + ") LIKE '%' || UPPER(:" + nome + ") || '%'" ;
	}
	
}


