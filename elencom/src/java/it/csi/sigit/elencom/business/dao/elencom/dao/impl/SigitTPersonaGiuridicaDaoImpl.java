package it.csi.sigit.elencom.business.dao.elencom.dao.impl;

import it.csi.sigit.elencom.business.dao.elencom.dao.*;
import it.csi.sigit.elencom.business.dao.elencom.dao.mapper.*;
import it.csi.sigit.elencom.business.dao.elencom.dto.*;
import it.csi.sigit.elencom.business.dao.elencom.qbe.*;
import it.csi.sigit.elencom.business.dao.elencom.metadata.*;
import it.csi.sigit.elencom.business.dao.elencom.exceptions.*;
import it.csi.sigit.elencom.business.dao.impl.*;
import it.csi.sigit.elencom.business.dao.util.*;
import it.csi.sigit.elencom.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R-2119962361) ENABLED START*/
import org.apache.commons.lang.StringUtils;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTPersonaGiuridica.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - province (datagen::CustomFinder)
 *   - comuni (datagen::CustomFinder)
 *   - personaGiuridica (datagen::CustomFinder)
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTPersonaGiuridicaDaoImpl extends AbstractDAO implements SigitTPersonaGiuridicaDao {
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
	 * Metodo di inserimento del DAO sigitTPersonaGiuridica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTPersonaGiuridicaPk
	 * @generated
	 */

	public SigitTPersonaGiuridicaPk insert(SigitTPersonaGiuridicaDto dto)

	{
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO ) VALUES (  :ID_PERSONA_GIURIDICA , :DENOMINAZIONE , :CODICE_FISCALE , :FK_L2 , :INDIRIZZO_SITAD , :INDIRIZZO_NON_TROVATO , :SIGLA_PROV , :ISTAT_COMUNE , :COMUNE , :PROVINCIA , :CIVICO , :CAP , :EMAIL , :DATA_INIZIO_ATTIVITA , :DATA_CESSAZIONE , :SIGLA_REA , :NUMERO_REA , :FLG_AMMINISTRATORE , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :FLG_TERZO_RESPONSABILE , :FLG_DISTRIBUTORE , :FLG_CAT , :FLG_INDIRIZZO_ESTERO , :STATO_ESTERO , :CITTA_ESTERO , :INDIRIZZO_ESTERO , :CAP_ESTERO , :FK_STATO_PG , :DT_AGG_DICHIARAZIONE , :FLG_DM37_LETTERAC , :FLG_DM37_LETTERAD , :FLG_DM37_LETTERAE , :FLG_FGAS , :FLG_CONDUTTORE , :FLG_SOGG_INCARICATO , :DELEGA_SOGG_INCARICATO  )";

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

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_PERSONA_GIURIDICA table.
	 * @generated
	 */
	public void update(SigitTPersonaGiuridicaDto dto) throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DENOMINAZIONE = :DENOMINAZIONE ,CODICE_FISCALE = :CODICE_FISCALE ,FK_L2 = :FK_L2 ,INDIRIZZO_SITAD = :INDIRIZZO_SITAD ,INDIRIZZO_NON_TROVATO = :INDIRIZZO_NON_TROVATO ,SIGLA_PROV = :SIGLA_PROV ,ISTAT_COMUNE = :ISTAT_COMUNE ,COMUNE = :COMUNE ,PROVINCIA = :PROVINCIA ,CIVICO = :CIVICO ,CAP = :CAP ,EMAIL = :EMAIL ,DATA_INIZIO_ATTIVITA = :DATA_INIZIO_ATTIVITA ,DATA_CESSAZIONE = :DATA_CESSAZIONE ,SIGLA_REA = :SIGLA_REA ,NUMERO_REA = :NUMERO_REA ,FLG_AMMINISTRATORE = :FLG_AMMINISTRATORE ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,FLG_TERZO_RESPONSABILE = :FLG_TERZO_RESPONSABILE ,FLG_DISTRIBUTORE = :FLG_DISTRIBUTORE ,FLG_CAT = :FLG_CAT ,FLG_INDIRIZZO_ESTERO = :FLG_INDIRIZZO_ESTERO ,STATO_ESTERO = :STATO_ESTERO ,CITTA_ESTERO = :CITTA_ESTERO ,INDIRIZZO_ESTERO = :INDIRIZZO_ESTERO ,CAP_ESTERO = :CAP_ESTERO ,FK_STATO_PG = :FK_STATO_PG ,DT_AGG_DICHIARAZIONE = :DT_AGG_DICHIARAZIONE ,FLG_DM37_LETTERAC = :FLG_DM37_LETTERAC ,FLG_DM37_LETTERAD = :FLG_DM37_LETTERAD ,FLG_DM37_LETTERAE = :FLG_DM37_LETTERAE ,FLG_FGAS = :FLG_FGAS ,FLG_CONDUTTORE = :FLG_CONDUTTORE ,FLG_SOGG_INCARICATO = :FLG_SOGG_INCARICATO ,DELEGA_SOGG_INCARICATO = :DELEGA_SOGG_INCARICATO  WHERE ID_PERSONA_GIURIDICA = :ID_PERSONA_GIURIDICA ";

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

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::update] END");
	}

	protected SigitTPersonaGiuridicaDaoRowMapper provinceRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(
			new String[]{"SIGLA_PROV", "PROVINCIA"}, SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper comuniRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(
			new String[]{"ISTAT_COMUNE", "COMUNE"}, SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper personaGiuridicaRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(
			null, SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper findByPrimaryKeyRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(
			null, SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper findAllRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(null,
			SigitTPersonaGiuridicaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_PERSONA_GIURIDICA";
	}

	/** 
	 * Implementazione del finder province
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findProvince(String input) throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findProvince] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT DISTINCT SIGLA_PROV,PROVINCIA ");
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R310882584) ENABLED START*/
		sql.append(" (FLG_DM37_LETTERAC = 1 OR FLG_TERZO_RESPONSABILE = 1) ");
		sql.append(" AND SIGLA_PROV IS NOT NULL AND PROVINCIA IS NOT NULL ");
		/*PROTECTED REGION END*/

		sql.append(" ORDER BY "); /*PROTECTED REGION ID(R-295832704) ENABLED START*/
		sql.append(" PROVINCIA ASC");

		/*PROTECTED REGION END*/
		List<SigitTPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, provinceRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findProvince] esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findProvince", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findProvince] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder comuni
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findComuni(String input) throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findComuni] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT DISTINCT ISTAT_COMUNE,COMUNE ");
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R679983863) ENABLED START*/
		sql.append(" (FLG_DM37_LETTERAC = 1 OR FLG_TERZO_RESPONSABILE = 1) ");
		sql.append(" AND ISTAT_COMUNE IS NOT NULL AND COMUNE IS NOT NULL");
		sql.append(" AND SIGLA_PROV = :prov");
		/*PROTECTED REGION END*/

		sql.append(" ORDER BY "); /*PROTECTED REGION ID(R-1738594943) ENABLED START*/
		sql.append(" COMUNE ASC");

		paramMap.addValue("prov", input);

		/*PROTECTED REGION END*/
		List<SigitTPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, comuniRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findComuni] esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findComuni", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findComuni] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder personaGiuridica
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findPersonaGiuridica(
			it.csi.sigit.elencom.business.dao.elencom.dto.SigitTPersonaGiuridicaDto input)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findPersonaGiuridica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO ");
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-2020494583) ENABLED START*/
		sql.append(" (FLG_DM37_LETTERAC = 1 OR FLG_TERZO_RESPONSABILE = 1) ");

		if (input.getSiglaProv() != null && StringUtils.isNotEmpty(input.getSiglaProv()))
			sql.append(" AND SIGLA_PROV = :siglaProv");
		if (input.getIstatComune() != null && StringUtils.isNotEmpty(input.getIstatComune()))
			sql.append(" AND ISTAT_COMUNE = :idComune");
		if (input.getDenominazione() != null && StringUtils.isNotEmpty(input.getDenominazione()))
			sql.append(" AND UPPER(DENOMINAZIONE) LIKE '%' || UPPER(:nome) || '%'");

		// Recupero solo le attive
		sql.append(" AND FK_STATO_PG = " + Constants.ID_STATO_IMP_VALIDO);
		//sql.append(" AND CURRENT_DATE BETWEEN DATA_INIZIO_ATTIVITA AND COALESCE(DATA_CESSAZIONE,CURRENT_DATE) ");

		/*PROTECTED REGION END*/

		sql.append(" ORDER BY "); /*PROTECTED REGION ID(R445919151) ENABLED START*/
		sql.append(" DENOMINAZIONE");

		paramMap.addValue("siglaProv", input.getSiglaProv());
		paramMap.addValue("idComune", input.getIstatComune());
		paramMap.addValue("nome", input.getDenominazione());

		/*PROTECTED REGION END*/
		List<SigitTPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, personaGiuridicaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findPersonaGiuridica] esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findPersonaGiuridica", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findPersonaGiuridica] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_T_PERSONA_GIURIDICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTPersonaGiuridicaDto findByPrimaryKey(SigitTPersonaGiuridicaPk pk)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO FROM "
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
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_PERSONA_GIURIDICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findAll() throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTPersonaGiuridicaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findAll] END");
		}
		return list;
	}

}
