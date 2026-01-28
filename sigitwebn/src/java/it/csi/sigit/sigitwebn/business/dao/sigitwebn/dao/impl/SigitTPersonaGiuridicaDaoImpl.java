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

/*PROTECTED REGION ID(R1990779303) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTPersonaGiuridica.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byCodiceRea (datagen::CustomFinder)
 *   - byCodiceFiscale (datagen::CustomFinder)
 *   - byCodiceReaAndFiscale (datagen::CustomFinder)
 *   - byCodiceImpianto (datagen::CustomFinder)
 *   - acquisitoCodImpByCodiceImpianto (datagen::CustomFinder)
 *   - catValidi (datagen::CustomFinder)
 *   - cat (datagen::CustomFinder)
 *   - byParam (datagen::CustomFinder)
 *   - incarichiCatAttivi (datagen::CustomFinder)
 *   - byFilter (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
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

	/** 
	 * Deletes a single row in the SIGIT_T_PERSONA_GIURIDICA table.
	 * @generated
	 */

	public void delete(SigitTPersonaGiuridicaPk pk) throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_PERSONA_GIURIDICA = :ID_PERSONA_GIURIDICA ";

		if (pk == null) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTPersonaGiuridicaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA]
		params.addValue("ID_PERSONA_GIURIDICA", pk.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::delete] END");
	}

	protected SigitTPersonaGiuridicaDaoRowMapper findByPrimaryKeyRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(
			null, SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper findAllRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(null,
			SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper byCodiceReaRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(null,
			SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper byCodiceFiscaleRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(null,
			SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper byCodiceReaAndFiscaleRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(
			null, SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper byCodiceImpiantoRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(
			null, SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper acquisitoCodImpByCodiceImpiantoRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(
			null, SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper catValidiRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(null,
			SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper catRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(null,
			SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper byParamRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(null,
			SigitTPersonaGiuridicaByParamDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper incarichiCatAttiviRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(
			null, SigitTPersonaGiuridicaDto.class, this);

	protected SigitTPersonaGiuridicaDaoRowMapper byFilterRowMapper = new SigitTPersonaGiuridicaDaoRowMapper(null,
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
	 * Restituisce tutte le righe della tabella SIGIT_T_PERSONA_GIURIDICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findAll() throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN,PEC,TELEFONO FROM "
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

	/** 
	 * Implementazione del finder byCodiceRea
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findByCodiceRea(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleFilter input)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByCodiceRea] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN,PEC,TELEFONO ");
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1911127827) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" SIGLA_REA = :siglaRea");
		sql.append(" AND NUMERO_REA = :numeroRea");

		if (input.isFlgDm37LetteraC()) {
			sql.append(" AND FLG_DM37_LETTERAC = :flgDm37LetteraC ");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-4015729) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("siglaRea", input.getSiglaRea());
		paramMap.addValue("numeroRea", input.getNumeroRea());

		if (input.isFlgDm37LetteraC()) {
			paramMap.addValue("flgDm37LetteraC", Constants.SI_1);
		}

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
	public List<SigitTPersonaGiuridicaDto> findByCodiceFiscale(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleFilter input)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByCodiceFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN,PEC,TELEFONO ");
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-327220820) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" UPPER(CODICE_FISCALE) = UPPER(:codFiscale)");

		if (input.isFlgDm37LetteraC()) {
			sql.append(" AND FLG_DM37_LETTERAC = :flgDm37LetteraC ");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-673347050) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codFiscale", input.getCodiceFiscale());

		if (input.isFlgDm37LetteraC()) {
			paramMap.addValue("flgDm37LetteraC", Constants.SI_1);
		}

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
	 * Implementazione del finder byCodiceReaAndFiscale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findByCodiceReaAndFiscale(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleFilter input)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByCodiceReaAndFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN,PEC,TELEFONO ");
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1978748541) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
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

		if (input.isFlgDm37LetteraC()) {
			sql.append(" AND FLG_DM37_LETTERAC = :flgDm37LetteraC ");
		}

		if (input.isFlgSoloAttivi()) {
			sql.append(" AND FK_STATO_PG = 1 ");
			sql.append(" AND DATA_CESSAZIONE IS NULL ");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-331098849) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaRea())) {
			paramMap.addValue("siglaRea", input.getSiglaRea());
		}
		if (GenericUtil.isNotNullOrEmpty(input.getNumeroRea())) {
			paramMap.addValue("numeroRea", input.getNumeroRea());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceFiscale())) {
			paramMap.addValue("codFiscale", input.getCodiceFiscale());
		}

		if (input.isFlgDm37LetteraC()) {
			paramMap.addValue("flgDm37LetteraC", Constants.SI_1);
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
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findByCodiceReaAndFiscale", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByCodiceReaAndFiscale] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findByCodiceImpianto(java.lang.Integer input)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R34940524) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_DM37_LETTERAC,FLG_AMMINISTRATORE,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG, pg.DATA_ULT_MOD,pg.UTENTE_ULT_MOD ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1589208062) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA pg, SIGIT_R_IMP_RUOLO_PFPG pfpg");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1803445436) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		sql.append(" ID_PERSONA_GIURIDICA = pfpg.FK_PERSONA_GIURIDICA ");

		//		sql.append(" AND pfpg.FK_RUOLO IN ("
		//				+ Constants.ID_RUOLO_AMMINISTRATORE + ","
		//				+ Constants.ID_RUOLO_PROPRIETARIO + ","
		//				+ Constants.ID_RUOLO_OCCUPANTE + ")");

		sql.append(" AND pfpg.FK_RUOLO = " + Constants.ID_RUOLO_CARICATORE);
		sql.append(" AND pfpg.DATA_FINE IS NULL ");

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" AND pfpg.CODICE_IMPIANTO = :codiceImpianto");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R952797446) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codiceImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitTPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findByCodiceImpianto] esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findByCodiceImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByCodiceImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder acquisitoCodImpByCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findAcquisitoCodImpByCodiceImpianto(java.lang.Integer input)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findAcquisitoCodImpByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-1586533406) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_DM37_LETTERAC,FLG_AMMINISTRATORE,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,pg.DATA_ULT_MOD,pg.UTENTE_ULT_MOD ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1471319796) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA pg, SIGIT_T_TRANSAZIONE_IMP ti, SIGIT_T_CODICE_IMP ci ");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1851090810) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		sql.append(" ci.FK_TRANSAZIONE = ti.ID_TRANSAZIONE");
		sql.append(" AND ti.FK_PERSONA_GIURIDICA = pg.ID_PERSONA_GIURIDICA");

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" AND ci.CODICE_IMPIANTO = :codImpianto");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-668676484) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitTPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, acquisitoCodImpByCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findAcquisitoCodImpByCodiceImpianto] esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findAcquisitoCodImpByCodiceImpianto",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findAcquisitoCodImpByCodiceImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder catValidi
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findCatValidi(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto input)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findCatValidi] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN,PEC,TELEFONO ");
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1994270098) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" FLG_CAT = 1 AND DATA_CESSAZIONE IS NULL ");
		/*PROTECTED REGION END*/

		sql.append(" ORDER BY DENOMINAZIONE ASC"); /*PROTECTED REGION ID(R-1721572624) ENABLED START*/
		//***aggiungere tutte le condizioni

		/*PROTECTED REGION END*/
		List<SigitTPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, catValidiRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findCatValidi] esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findCatValidi", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findCatValidi] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder cat
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findCat(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto input)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findCat] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN,PEC,TELEFONO ");
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1240925819) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" FLG_CAT = 1 ");
		/*PROTECTED REGION END*/

		sql.append(" ORDER BY DENOMINAZIONE ASC"); /*PROTECTED REGION ID(R1066569053) ENABLED START*/
		//***aggiungere tutte le condizioni

		/*PROTECTED REGION END*/
		List<SigitTPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, catRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findCat] esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findCat", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findCat] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byParam con Qdef
		 * @generated
		 */

	public List<SigitTPersonaGiuridicaByParamDto> findByParam(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto input)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByParam] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT pg.ID_PERSONA_GIURIDICA, pg.DENOMINAZIONE, pg.CODICE_FISCALE, pg.SIGLA_REA, pg.NUMERO_REA, pg.FLG_DM37_LETTERAC, pg.FLG_AMMINISTRATORE, pg.FLG_TERZO_RESPONSABILE, pg.FLG_DISTRIBUTORE, pg.FLG_CAT, ds.DES_STATO_PG, pg.FLG_SOGG_INCARICATO");

		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA pg, SIGIT_D_STATO_PG ds");

		sql.append(" WHERE ");

		sql.append("pg.FK_STATO_PG = ds.ID_STATO_PG");

		sql.append(" AND ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R-1242475545) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceFiscale())) {
			sql.append(" AND UPPER(CODICE_FISCALE) = UPPER(:codFiscale)");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaRea())) {
			sql.append(" AND SIGLA_REA = :siglaRea");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getNumeroRea())) {
			sql.append(" AND NUMERO_REA = :numeroRea");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDenominazione())) {
			sql.append(" AND UPPER(denominazione) like UPPER('%" + input.getDenominazione() + "%')");
		}

		//		if (GenericUtil.isNotNullOrEmpty(input.getFlgInstallatore())) {
		//			sql.append(" AND FLG_INSTALLATORE = :flgInstallatore");
		//		}
		//
		//		if (GenericUtil.isNotNullOrEmpty(input.getFlgManutentore())) {
		//			sql.append(" AND FLG_MANUTENTORE = :flgManutentore");
		//		}

		if (GenericUtil.isNotNullOrEmpty(input.getFlgDm37Letterac())) {
			sql.append(" AND FLG_DM37_LETTERAC = :flgDm37LetteraC");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFlgTerzoResponsabile())) {
			sql.append(" AND FLG_TERZO_RESPONSABILE = :flgTerzoResponsabile");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFlgDistributore())) {
			sql.append(" AND FLG_DISTRIBUTORE = :flgDistributore");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFlgAmministratore())) {
			sql.append(" AND (FLG_AMMINISTRATORE = :flgAmministratore");
			sql.append(" OR FLG_SOGG_INCARICATO = :flgSoggIncaricato)");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFlgCat())) {
			sql.append(" AND FLG_CAT = :flgCat");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFkStatoPg())) {
			sql.append(" AND FK_STATO_PG = :flgStatoPg");
		}

		sql.append(" ORDER BY DENOMINAZIONE ASC");

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceFiscale())) {
			paramMap.addValue("codFiscale", input.getCodiceFiscale());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaRea())) {
			paramMap.addValue("siglaRea", input.getSiglaRea());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getNumeroRea())) {
			paramMap.addValue("numeroRea", input.getNumeroRea());
		}

		//		if (GenericUtil.isNotNullOrEmpty(input.getDenominazione())) {
		//			paramMap.addValue("denom", input.getDenominazione());
		//		}

		//		if (GenericUtil.isNotNullOrEmpty(input.getFlgInstallatore())) {
		//			paramMap.addValue("flgInstallatore", Constants.SI_1);
		//		}
		//
		//		if (GenericUtil.isNotNullOrEmpty(input.getFlgManutentore())) {
		//			paramMap.addValue("flgManutentore", Constants.SI_1);
		//		}

		if (GenericUtil.isNotNullOrEmpty(input.getFlgDm37Letterac())) {
			paramMap.addValue("flgDm37LetteraC", Constants.SI_1);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFlgTerzoResponsabile())) {
			paramMap.addValue("flgTerzoResponsabile", Constants.SI_1);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFlgDistributore())) {
			paramMap.addValue("flgDistributore", Constants.SI_1);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFlgAmministratore())) {
			paramMap.addValue("flgAmministratore", Constants.SI_1);
			paramMap.addValue("flgSoggIncaricato", Constants.SI_1);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFlgCat())) {
			paramMap.addValue("flgCat", Constants.SI_1);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFkStatoPg())) {
			paramMap.addValue("flgStatoPg", input.getFkStatoPg());
		}

		sql.append(
				" LIMIT (SELECT VALORE_CONFIG_NUM FROM SIGIT_WRK_CONFIG WHERE CHIAVE_CONFIG='MAX_RIGHE_RIC_AVZ_IMP') ");

		/*PROTECTED REGION END*/

		List<SigitTPersonaGiuridicaByParamDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byParamRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findByParam] ERROR esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findByParam", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByParam] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder incarichiCatAttivi
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findIncarichiCatAttivi(java.lang.Integer input)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findIncarichiCatAttivi] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG,DT_AGG_DICHIARAZIONE,FLG_DM37_LETTERAC,FLG_DM37_LETTERAD,FLG_DM37_LETTERAE,FLG_FGAS,FLG_CONDUTTORE,FLG_SOGG_INCARICATO,DELEGA_SOGG_INCARICATO,DT_CREAZIONE_TOKEN,DT_SCADENZA_TOKEN,TOKEN,PEC,TELEFONO ");
		/*PROTECTED REGION ID(R1487940774) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA pg, SIGIT_R_PG_PG_NOMINA nom ");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1335840492) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		sql.append(" pg.ID_PERSONA_GIURIDICA = nom.ID_PERSONA_GIURIDICA_IMPRESA ");

		sql.append(" AND DATA_FINE IS NULL ");

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" AND nom.ID_PERSONA_GIURIDICA_CAT = :idPgCat");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1875785810) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idPgCat", input);

		/*PROTECTED REGION END*/
		List<SigitTPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, incarichiCatAttiviRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findIncarichiCatAttivi] esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findIncarichiCatAttivi", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findIncarichiCatAttivi] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaPersonaGiuridicaFisicaFilter input)
			throws SigitTPersonaGiuridicaDaoException {
		LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-810774740) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_PERSONA_GIURIDICA,DENOMINAZIONE,CODICE_FISCALE,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,SIGLA_PROV,ISTAT_COMUNE,COMUNE,PROVINCIA,CIVICO,CAP,EMAIL,DATA_INIZIO_ATTIVITA,DATA_CESSAZIONE,SIGLA_REA,NUMERO_REA,FLG_DM37_LETTERAC,FLG_AMMINISTRATORE,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_TERZO_RESPONSABILE,FLG_DISTRIBUTORE,FLG_CAT,FLG_INDIRIZZO_ESTERO,STATO_ESTERO,CITTA_ESTERO,INDIRIZZO_ESTERO,CAP_ESTERO,FK_STATO_PG ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R949222590) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_PERSONA_GIURIDICA");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-856235012) ENABLED START*/

		sql.append(" 1 = 1 ");

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceFiscale())) {
			sql.append(" AND  CODICE_FISCALE = :codiceFiscale ");
			paramMap.addValue("codiceFiscale", input.getCodiceFiscale().toUpperCase());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCognomeDenominazione())) {
			sql.append(" AND  UPPER(DENOMINAZIONE) LIKE :cognome ");
			paramMap.addValue("cognome", "%" + input.getCognomeDenominazione().toUpperCase() + "%");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R107082182) ENABLED START*/
		//***aggiungere tutte le condizioni

		/*PROTECTED REGION END*/
		List<SigitTPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTPersonaGiuridicaDaoImpl::findByFilter] esecuzione query", ex);
			throw new SigitTPersonaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTPersonaGiuridicaDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitTPersonaGiuridicaDaoImpl::findByFilter] END");
		}
		return list;
	}

}
