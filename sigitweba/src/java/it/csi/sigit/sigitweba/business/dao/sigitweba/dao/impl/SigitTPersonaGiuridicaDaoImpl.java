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

/*PROTECTED REGION ID(R-193527737) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitweba.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTPersonaGiuridica.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byCodiceRea (datagen::CustomFinder)
 *   - byCodiceFiscale (datagen::CustomFinder)
 *   - byCodiceFiscaleCodRea (datagen::CustomFinder)
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

	/** 
	 * Updates a single row in the SIGIT_T_PERSONA_GIURIDICA table.
	 * @generated
	 */
	public void update(SigitTPersonaGiuridicaDto dto) throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DENOMINAZIONE = :DENOMINAZIONE ,CODICE_FISCALE = :CODICE_FISCALE ,FK_L2 = :FK_L2 ,INDIRIZZO_SITAD = :INDIRIZZO_SITAD ,INDIRIZZO_NON_TROVATO = :INDIRIZZO_NON_TROVATO ,SIGLA_PROV = :SIGLA_PROV ,ISTAT_COMUNE = :ISTAT_COMUNE ,COMUNE = :COMUNE ,PROVINCIA = :PROVINCIA ,CIVICO = :CIVICO ,CAP = :CAP ,EMAIL = :EMAIL ,DATA_INIZIO_ATTIVITA = :DATA_INIZIO_ATTIVITA ,DATA_CESSAZIONE = :DATA_CESSAZIONE ,SIGLA_REA = :SIGLA_REA ,NUMERO_REA = :NUMERO_REA ,FLG_AMMINISTRATORE = :FLG_AMMINISTRATORE ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,FLG_TERZO_RESPONSABILE = :FLG_TERZO_RESPONSABILE ,FLG_DISTRIBUTORE = :FLG_DISTRIBUTORE ,FLG_CAT = :FLG_CAT ,FLG_INDIRIZZO_ESTERO = :FLG_INDIRIZZO_ESTERO ,STATO_ESTERO = :STATO_ESTERO ,CITTA_ESTERO = :CITTA_ESTERO ,INDIRIZZO_ESTERO = :INDIRIZZO_ESTERO ,CAP_ESTERO = :CAP_ESTERO ,FK_STATO_PG = :FK_STATO_PG ,DT_AGG_DICHIARAZIONE = :DT_AGG_DICHIARAZIONE ,FLG_DM37_LETTERAC = :FLG_DM37_LETTERAC ,FLG_DM37_LETTERAD = :FLG_DM37_LETTERAD ,FLG_DM37_LETTERAE = :FLG_DM37_LETTERAE ,FLG_FGAS = :FLG_FGAS ,FLG_CONDUTTORE = :FLG_CONDUTTORE ,FLG_SOGG_INCARICATO = :FLG_SOGG_INCARICATO ,DELEGA_SOGG_INCARICATO = :DELEGA_SOGG_INCARICATO ,DT_CREAZIONE_TOKEN = :DT_CREAZIONE_TOKEN ,DT_SCADENZA_TOKEN = :DT_SCADENZA_TOKEN ,TOKEN = :TOKEN ,PEC = :PEC ,TELEFONO = :TELEFONO  WHERE ID_PERSONA_GIURIDICA = :ID_PERSONA_GIURIDICA ";

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

	protected SigitTPersonaGiuridicaDaoRowMapper findByPrimaryKeyRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(
			null, SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper byCodiceReaRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(null,
			SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper byCodiceFiscaleRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(null,
			SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper byCodiceFiscaleCodReaRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(
			null, SigitTPersonaGiuridicaDto.class, this);

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
	 * Returns all rows from the SIGIT_T_PERSONA_GIURIDICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTPersonaGiuridicaDto findByPrimaryKey(SigitTPersonaGiuridicaPk pk)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN,PEC,TELEFONO FROM "
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
	 * Implementazione del finder byCodiceRea
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findByCodiceRea(java.lang.String input)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByCodiceRea] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN,PEC,TELEFONO ");
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1911127814) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("SIGLA_REA = :siglaRea");
		sql.append(" AND NUMERO_REA = :numeroRea");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-4015742) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("siglaRea", input.substring(0, 2), java.sql.Types.VARCHAR);
		paramMap.addValue("numeroRea", input.substring(2), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitTPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceReaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findByCodiceRea] esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findByCodiceRea", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByCodiceRea] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceFiscale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findByCodiceFiscale(java.lang.String input)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByCodiceFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN,PEC,TELEFONO ");
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-327220833) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("UPPER(CODICE_FISCALE) = UPPER(:cf)");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-673347063) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("cf", input, java.sql.Types.VARCHAR);

		/*PROTECTED REGION END*/
		List<SigitTPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceFiscaleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findByCodiceFiscale] esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findByCodiceFiscale", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByCodiceFiscale] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceFiscaleCodRea
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findByCodiceFiscaleCodRea(
			it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaGiuridica input)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByCodiceFiscaleCodRea] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN,PEC,TELEFONO ");
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R2062822581) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("UPPER(CODICE_FISCALE) = UPPER(:cf)");
		if (GenericUtil.isNonNullOrEmpty(input.getSiglaRea())) {
			sql.append(" AND (SIGLA_REA = :siglaRea");
		} else {
			sql.append(" AND (SIGLA_REA is null");
		}
		if (GenericUtil.isNonNullOrEmpty(input.getNumeroRea())) {
			sql.append(" AND NUMERO_REA = :numeroRea");
		} else {
			sql.append(" AND NUMERO_REA is null");
		}
		sql.append(")");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R403554739) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("cf", input.getCodiceFiscale(), java.sql.Types.VARCHAR);
		if (GenericUtil.isNonNullOrEmpty(input.getSiglaRea())) {
			paramMap.addValue("siglaRea", input.getSiglaRea(), java.sql.Types.VARCHAR);
		}
		if (GenericUtil.isNonNullOrEmpty(input.getNumeroRea())) {
			paramMap.addValue("numeroRea", input.getNumeroRea(), java.sql.Types.NUMERIC);
		}
		/*PROTECTED REGION END*/
		List<SigitTPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceFiscaleCodReaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findByCodiceFiscaleCodRea] esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findByCodiceFiscaleCodRea", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByCodiceFiscaleCodRea] END");
		}
		return list;
	}

}
