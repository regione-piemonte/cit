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

/*PROTECTED REGION ID(R1239132607) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTUnitaImmobiliare.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byCodiceImpianto (datagen::CustomFinder)
 *   - unitaPrincipaleImpianto (datagen::CustomFinder)
 *   - principaleByFilter (datagen::CustomFinder)
 *   - principaleByCodiceImpianto (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - DaOnline (datagen::UpdateColumns)
 * - DELETERS:
 *   - byCodImpianto (datagen::CustomDeleter)
 *   - byCodImpiantoSecondarie (datagen::CustomDeleter)
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTUnitaImmobiliareDaoImpl extends AbstractDAO implements SigitTUnitaImmobiliareDao {
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
	 * Metodo di inserimento del DAO sigitTUnitaImmobiliare. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTUnitaImmobiliarePk
	 * @generated
	 */

	public SigitTUnitaImmobiliarePk insert(SigitTUnitaImmobiliareDto dto)

	{
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_UNITA_IMM,CODICE_IMPIANTO,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,CIVICO,CAP,SCALA,PALAZZO,INTERNO,NOTE,FLG_PRINCIPALE,SEZIONE,FOGLIO,PARTICELLA,SUBALTERNO,POD_ELETTRICO,PDR_GAS,DATA_ULT_MOD,UTENTE_ULT_MOD,L1_2_FLG_SINGOLA_UNITA,L1_2_FK_CATEGORIA,L1_2_VOL_RISC_M3,L1_2_VOL_RAFF_M3,FLG_NOPDR,FLG_NOACCATASTATO ) VALUES (  :ID_UNITA_IMM , :CODICE_IMPIANTO , :FK_L2 , :INDIRIZZO_SITAD , :INDIRIZZO_NON_TROVATO , :CIVICO , :CAP , :SCALA , :PALAZZO , :INTERNO , :NOTE , :FLG_PRINCIPALE , :SEZIONE , :FOGLIO , :PARTICELLA , :SUBALTERNO , :POD_ELETTRICO , :PDR_GAS , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :L1_2_FLG_SINGOLA_UNITA , :L1_2_FK_CATEGORIA , :L1_2_VOL_RISC_M3 , :L1_2_VOL_RAFF_M3 , :FLG_NOPDR , :FLG_NOACCATASTATO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_UNITA_IMM]
		params.addValue("ID_UNITA_IMM", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_L2]
		params.addValue("FK_L2", dto.getFkL2(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_SITAD]
		params.addValue("INDIRIZZO_SITAD", dto.getIndirizzoSitad(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_NON_TROVATO]
		params.addValue("INDIRIZZO_NON_TROVATO", dto.getIndirizzoNonTrovato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO]
		params.addValue("CIVICO", dto.getCivico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP]
		params.addValue("CAP", dto.getCap(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SCALA]
		params.addValue("SCALA", dto.getScala(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PALAZZO]
		params.addValue("PALAZZO", dto.getPalazzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INTERNO]
		params.addValue("INTERNO", dto.getInterno(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_PRINCIPALE]
		params.addValue("FLG_PRINCIPALE", dto.getFlgPrincipale(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [SEZIONE]
		params.addValue("SEZIONE", dto.getSezione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FOGLIO]
		params.addValue("FOGLIO", dto.getFoglio(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PARTICELLA]
		params.addValue("PARTICELLA", dto.getParticella(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SUBALTERNO]
		params.addValue("SUBALTERNO", dto.getSubalterno(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [POD_ELETTRICO]
		params.addValue("POD_ELETTRICO", dto.getPodElettrico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PDR_GAS]
		params.addValue("PDR_GAS", dto.getPdrGas(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L1_2_FLG_SINGOLA_UNITA]
		params.addValue("L1_2_FLG_SINGOLA_UNITA", dto.getL12FlgSingolaUnita(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_2_FK_CATEGORIA]
		params.addValue("L1_2_FK_CATEGORIA", dto.getL12FkCategoria(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L1_2_VOL_RISC_M3]
		params.addValue("L1_2_VOL_RISC_M3", dto.getL12VolRiscM3(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_2_VOL_RAFF_M3]
		params.addValue("L1_2_VOL_RAFF_M3", dto.getL12VolRaffM3(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_NOPDR]
		params.addValue("FLG_NOPDR", dto.getFlgNopdr(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_NOACCATASTATO]
		params.addValue("FLG_NOACCATASTATO", dto.getFlgNoaccatastato(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdUnitaImm(newKey);
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_UNITA_IMMOBILIARE table.
	 * @generated
	 */
	public void update(SigitTUnitaImmobiliareDto dto) throws SigitTUnitaImmobiliareDaoException {
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET CODICE_IMPIANTO = :CODICE_IMPIANTO ,FK_L2 = :FK_L2 ,INDIRIZZO_SITAD = :INDIRIZZO_SITAD ,INDIRIZZO_NON_TROVATO = :INDIRIZZO_NON_TROVATO ,CIVICO = :CIVICO ,CAP = :CAP ,SCALA = :SCALA ,PALAZZO = :PALAZZO ,INTERNO = :INTERNO ,NOTE = :NOTE ,FLG_PRINCIPALE = :FLG_PRINCIPALE ,SEZIONE = :SEZIONE ,FOGLIO = :FOGLIO ,PARTICELLA = :PARTICELLA ,SUBALTERNO = :SUBALTERNO ,POD_ELETTRICO = :POD_ELETTRICO ,PDR_GAS = :PDR_GAS ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,L1_2_FLG_SINGOLA_UNITA = :L1_2_FLG_SINGOLA_UNITA ,L1_2_FK_CATEGORIA = :L1_2_FK_CATEGORIA ,L1_2_VOL_RISC_M3 = :L1_2_VOL_RISC_M3 ,L1_2_VOL_RAFF_M3 = :L1_2_VOL_RAFF_M3 ,FLG_NOPDR = :FLG_NOPDR ,FLG_NOACCATASTATO = :FLG_NOACCATASTATO  WHERE ID_UNITA_IMM = :ID_UNITA_IMM ";

		if (dto.getIdUnitaImm() == null) {
			LOG.error("[SigitTUnitaImmobiliareDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTUnitaImmobiliareDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_UNITA_IMM]
		params.addValue("ID_UNITA_IMM", dto.getIdUnitaImm(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_L2]
		params.addValue("FK_L2", dto.getFkL2(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_SITAD]
		params.addValue("INDIRIZZO_SITAD", dto.getIndirizzoSitad(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_NON_TROVATO]
		params.addValue("INDIRIZZO_NON_TROVATO", dto.getIndirizzoNonTrovato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO]
		params.addValue("CIVICO", dto.getCivico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP]
		params.addValue("CAP", dto.getCap(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SCALA]
		params.addValue("SCALA", dto.getScala(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PALAZZO]
		params.addValue("PALAZZO", dto.getPalazzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INTERNO]
		params.addValue("INTERNO", dto.getInterno(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_PRINCIPALE]
		params.addValue("FLG_PRINCIPALE", dto.getFlgPrincipale(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [SEZIONE]
		params.addValue("SEZIONE", dto.getSezione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FOGLIO]
		params.addValue("FOGLIO", dto.getFoglio(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PARTICELLA]
		params.addValue("PARTICELLA", dto.getParticella(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SUBALTERNO]
		params.addValue("SUBALTERNO", dto.getSubalterno(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [POD_ELETTRICO]
		params.addValue("POD_ELETTRICO", dto.getPodElettrico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PDR_GAS]
		params.addValue("PDR_GAS", dto.getPdrGas(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L1_2_FLG_SINGOLA_UNITA]
		params.addValue("L1_2_FLG_SINGOLA_UNITA", dto.getL12FlgSingolaUnita(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_2_FK_CATEGORIA]
		params.addValue("L1_2_FK_CATEGORIA", dto.getL12FkCategoria(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L1_2_VOL_RISC_M3]
		params.addValue("L1_2_VOL_RISC_M3", dto.getL12VolRiscM3(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_2_VOL_RAFF_M3]
		params.addValue("L1_2_VOL_RAFF_M3", dto.getL12VolRaffM3(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_NOPDR]
		params.addValue("FLG_NOPDR", dto.getFlgNopdr(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_NOACCATASTATO]
		params.addValue("FLG_NOACCATASTATO", dto.getFlgNoaccatastato(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_UNITA_IMMOBILIARE table.
	 * @generated
	 */
	public void updateColumnsDaOnline(SigitTUnitaImmobiliareDto dto) throws SigitTUnitaImmobiliareDaoException {
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::updateColumnsDaOnline] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET CODICE_IMPIANTO = :CODICE_IMPIANTO ,FK_L2 = :FK_L2 ,INDIRIZZO_SITAD = :INDIRIZZO_SITAD ,INDIRIZZO_NON_TROVATO = :INDIRIZZO_NON_TROVATO ,CIVICO = :CIVICO ,CAP = :CAP ,SCALA = :SCALA ,PALAZZO = :PALAZZO ,INTERNO = :INTERNO ,NOTE = :NOTE ,FLG_PRINCIPALE = :FLG_PRINCIPALE ,SEZIONE = :SEZIONE ,FOGLIO = :FOGLIO ,PARTICELLA = :PARTICELLA ,SUBALTERNO = :SUBALTERNO ,POD_ELETTRICO = :POD_ELETTRICO ,PDR_GAS = :PDR_GAS ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,FLG_NOPDR = :FLG_NOPDR ,FLG_NOACCATASTATO = :FLG_NOACCATASTATO  WHERE ID_UNITA_IMM = :ID_UNITA_IMM ";

		if (dto.getIdUnitaImm() == null) {
			LOG.error("[SigitTUnitaImmobiliareDaoImpl::updateColumnsDaOnline] ERROR chiave primaria non impostata");
			throw new SigitTUnitaImmobiliareDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_UNITA_IMM]
		params.addValue("ID_UNITA_IMM", dto.getIdUnitaImm(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_L2]
		params.addValue("FK_L2", dto.getFkL2(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_SITAD]
		params.addValue("INDIRIZZO_SITAD", dto.getIndirizzoSitad(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_NON_TROVATO]
		params.addValue("INDIRIZZO_NON_TROVATO", dto.getIndirizzoNonTrovato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO]
		params.addValue("CIVICO", dto.getCivico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP]
		params.addValue("CAP", dto.getCap(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SCALA]
		params.addValue("SCALA", dto.getScala(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PALAZZO]
		params.addValue("PALAZZO", dto.getPalazzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INTERNO]
		params.addValue("INTERNO", dto.getInterno(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_PRINCIPALE]
		params.addValue("FLG_PRINCIPALE", dto.getFlgPrincipale(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [SEZIONE]
		params.addValue("SEZIONE", dto.getSezione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FOGLIO]
		params.addValue("FOGLIO", dto.getFoglio(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PARTICELLA]
		params.addValue("PARTICELLA", dto.getParticella(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SUBALTERNO]
		params.addValue("SUBALTERNO", dto.getSubalterno(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [POD_ELETTRICO]
		params.addValue("POD_ELETTRICO", dto.getPodElettrico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PDR_GAS]
		params.addValue("PDR_GAS", dto.getPdrGas(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_NOPDR]
		params.addValue("FLG_NOPDR", dto.getFlgNopdr(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_NOACCATASTATO]
		params.addValue("FLG_NOACCATASTATO", dto.getFlgNoaccatastato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_UNITA_IMM]
		params.addValue("ID_UNITA_IMM", dto.getIdUnitaImm(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::updateColumnsDaOnline] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_UNITA_IMMOBILIARE table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTUnitaImmobiliareDaoException {
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R-1816566261) ENABLED START*/
		//***scrivere la custom query
		final StringBuilder sql = new StringBuilder("DELETE FROM " + getTableName() + " WHERE ");

		sql.append(" CODICE_IMPIANTO = :codImpianto");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::customDeleterByCodImpianto] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_UNITA_IMMOBILIARE table.
	 * @generated
	 */
	public void customDeleterByCodImpiantoSecondarie(java.lang.Integer filter)
			throws SigitTUnitaImmobiliareDaoException {
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::customDeleterByCodImpiantoSecondarie] START");
		/*PROTECTED REGION ID(R1479390538) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE CODICE_IMPIANTO = :codImpianto AND flg_principale<>1";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::customDeleterByCodImpiantoSecondarie] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_UNITA_IMMOBILIARE table.
	 * @generated
	 */

	public void delete(SigitTUnitaImmobiliarePk pk) throws SigitTUnitaImmobiliareDaoException {
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_UNITA_IMM = :ID_UNITA_IMM ";

		if (pk == null) {
			LOG.error("[SigitTUnitaImmobiliareDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTUnitaImmobiliareDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_UNITA_IMM]
		params.addValue("ID_UNITA_IMM", pk.getIdUnitaImm(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::delete] END");
	}

	protected SigitTUnitaImmobiliareDaoRowMapper findByPrimaryKeyRowMapper = new SigitTUnitaImmobiliareDaoRowMapper(
			null, SigitTUnitaImmobiliareDto.class, this);

	protected SigitTUnitaImmobiliareDaoRowMapper byCodiceImpiantoRowMapper = new SigitTUnitaImmobiliareDaoRowMapper(
			null, SigitTUnitaImmobiliareDto.class, this);

	protected SigitTUnitaImmobiliareDaoRowMapper unitaPrincipaleImpiantoRowMapper = new SigitTUnitaImmobiliareDaoRowMapper(
			null, SigitTUnitaImmobiliareDto.class, this);

	protected SigitTUnitaImmobiliareDaoRowMapper principaleByFilterRowMapper = new SigitTUnitaImmobiliareDaoRowMapper(
			null, SigitTUnitaImmobiliareDto.class, this);

	protected SigitTUnitaImmobiliareDaoRowMapper principaleByCodiceImpiantoRowMapper = new SigitTUnitaImmobiliareDaoRowMapper(
			null, SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_UNITA_IMMOBILIARE";
	}

	/** 
	 * Returns all rows from the SIGIT_T_UNITA_IMMOBILIARE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTUnitaImmobiliareDto findByPrimaryKey(SigitTUnitaImmobiliarePk pk)
			throws SigitTUnitaImmobiliareDaoException {
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_UNITA_IMM,CODICE_IMPIANTO,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,CIVICO,CAP,SCALA,PALAZZO,INTERNO,NOTE,FLG_PRINCIPALE,SEZIONE,FOGLIO,PARTICELLA,SUBALTERNO,POD_ELETTRICO,PDR_GAS,DATA_ULT_MOD,UTENTE_ULT_MOD,L1_2_FLG_SINGOLA_UNITA,L1_2_FK_CATEGORIA,L1_2_VOL_RISC_M3,L1_2_VOL_RAFF_M3,FLG_NOPDR,FLG_NOACCATASTATO FROM "
						+ getTableName() + " WHERE ID_UNITA_IMM = :ID_UNITA_IMM ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_UNITA_IMM]
		params.addValue("ID_UNITA_IMM", pk.getIdUnitaImm(), java.sql.Types.NUMERIC);

		List<SigitTUnitaImmobiliareDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTUnitaImmobiliareDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTUnitaImmobiliareDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTUnitaImmobiliareDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTUnitaImmobiliareDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTUnitaImmobiliareDto> findByCodiceImpianto(java.lang.Integer input)
			throws SigitTUnitaImmobiliareDaoException {
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::findByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_UNITA_IMM,CODICE_IMPIANTO,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,CIVICO,CAP,SCALA,PALAZZO,INTERNO,NOTE,FLG_PRINCIPALE,SEZIONE,FOGLIO,PARTICELLA,SUBALTERNO,POD_ELETTRICO,PDR_GAS,DATA_ULT_MOD,UTENTE_ULT_MOD,L1_2_FLG_SINGOLA_UNITA,L1_2_FK_CATEGORIA,L1_2_VOL_RISC_M3,L1_2_VOL_RAFF_M3,FLG_NOPDR,FLG_NOACCATASTATO ");
		sql.append(" FROM SIGIT_T_UNITA_IMMOBILIARE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R300986568) ENABLED START*/
		sql.append(" CODICE_IMPIANTO = :codiceImpianto");

		sql.append(" ORDER BY ID_UNITA_IMM");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1621212794) ENABLED START*/

		paramMap.addValue("codiceImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitTUnitaImmobiliareDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTUnitaImmobiliareDaoImpl::findByCodiceImpianto] esecuzione query", ex);
			throw new SigitTUnitaImmobiliareDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTUnitaImmobiliareDaoImpl", "findByCodiceImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTUnitaImmobiliareDaoImpl::findByCodiceImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder unitaPrincipaleImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTUnitaImmobiliareDto> findUnitaPrincipaleImpianto(java.lang.Integer input)
			throws SigitTUnitaImmobiliareDaoException {
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::findUnitaPrincipaleImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_UNITA_IMM,CODICE_IMPIANTO,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,CIVICO,CAP,SCALA,PALAZZO,INTERNO,NOTE,FLG_PRINCIPALE,SEZIONE,FOGLIO,PARTICELLA,SUBALTERNO,POD_ELETTRICO,PDR_GAS,DATA_ULT_MOD,UTENTE_ULT_MOD,L1_2_FLG_SINGOLA_UNITA,L1_2_FK_CATEGORIA,L1_2_VOL_RISC_M3,L1_2_VOL_RAFF_M3,FLG_NOPDR,FLG_NOACCATASTATO ");
		sql.append(" FROM SIGIT_T_UNITA_IMMOBILIARE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-2133048132) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_IMPIANTO = :codImpianto AND FLG_PRINCIPALE = 1");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-819418874) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitTUnitaImmobiliareDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, unitaPrincipaleImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTUnitaImmobiliareDaoImpl::findUnitaPrincipaleImpianto] esecuzione query", ex);
			throw new SigitTUnitaImmobiliareDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTUnitaImmobiliareDaoImpl", "findUnitaPrincipaleImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTUnitaImmobiliareDaoImpl::findUnitaPrincipaleImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder principaleByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTUnitaImmobiliareDto> findPrincipaleByFilter(SigitTUnitaImmobiliareDto input)
			throws SigitTUnitaImmobiliareDaoException {
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::findPrincipaleByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_UNITA_IMM,CODICE_IMPIANTO,FK_L2,INDIRIZZO_SITAD,INDIRIZZO_NON_TROVATO,CIVICO,CAP,SCALA,PALAZZO,INTERNO,NOTE,FLG_PRINCIPALE,SEZIONE,FOGLIO,PARTICELLA,SUBALTERNO,POD_ELETTRICO,PDR_GAS,DATA_ULT_MOD,UTENTE_ULT_MOD,L1_2_FLG_SINGOLA_UNITA,L1_2_FK_CATEGORIA,L1_2_VOL_RISC_M3,L1_2_VOL_RAFF_M3,FLG_NOPDR,FLG_NOACCATASTATO ");
		sql.append(" FROM SIGIT_T_UNITA_IMMOBILIARE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-456417) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_IMPIANTO = :codImpianto");

		if (GenericUtil.isNotNullOrEmpty(input.getFkL2())) {

			// Devo anche verificare l'indirizzoSitad nel caso in cui l'indirizzo dell'impianto siasto aggiornato da PWA (quindi LOCCSI che non ha l'fkl2) 
			sql.append(" AND (FK_L2 = :fkL2 OR UPPER(indirizzo_sitad) = UPPER(:indirizzoSitad)) ");
			//sql.append(" AND FK_L2 = :fkL2");
		} else {
			sql.append(" AND UPPER(INDIRIZZO_NON_TROVATO) = UPPER(:indNonTrov)");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCivico())) {
			sql.append(" AND CIVICO = :civico");
		}

		sql.append(" AND FLG_PRINCIPALE = 1");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R866414851) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodiceImpianto());

		LOG.debug("findPrincipaleByFilter - fkL2: " + input.getFkL2());
		LOG.debug("findPrincipaleByFilter - indirizzoSitad: " + input.getIndirizzoSitad());

		if (GenericUtil.isNotNullOrEmpty(input.getFkL2())) {
			paramMap.addValue("fkL2", input.getFkL2());
			paramMap.addValue("indirizzoSitad", input.getIndirizzoSitad());
		} else {
			paramMap.addValue("indNonTrov", input.getIndirizzoNonTrovato());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCivico())) {
			paramMap.addValue("civico", input.getCivico());
		}

		/*PROTECTED REGION END*/
		List<SigitTUnitaImmobiliareDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, principaleByFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTUnitaImmobiliareDaoImpl::findPrincipaleByFilter] esecuzione query", ex);
			throw new SigitTUnitaImmobiliareDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTUnitaImmobiliareDaoImpl", "findPrincipaleByFilter", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTUnitaImmobiliareDaoImpl::findPrincipaleByFilter] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder principaleByCodiceImpianto con Qdef
		 * @generated
		 */

	public List<SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto> findPrincipaleByCodiceImpianto(
			java.lang.Integer input) throws SigitTUnitaImmobiliareDaoException {
		LOG.debug("[SigitTUnitaImmobiliareDaoImpl::findPrincipaleByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ui.ID_UNITA_IMM, ui.INDIRIZZO_SITAD, ui.INDIRIZZO_NON_TROVATO, ui.CIVICO, ui.CAP, ui.SCALA, ui.SEZIONE, ui.FOGLIO, ui.PARTICELLA, ui.SUBALTERNO, ui.POD_ELETTRICO, ui.PDR_GAS, ui.L1_2_FK_CATEGORIA, cat.DES_CATEGORIA, ui.L1_2_FLG_SINGOLA_UNITA, ui.L1_2_VOL_RISC_M3, ui.L1_2_VOL_RAFF_M3");

		sql.append(" FROM SIGIT_T_UNITA_IMMOBILIARE ui, SIGIT_D_CATEGORIA cat");

		sql.append(" WHERE ");

		sql.append("ui.L1_2_FK_CATEGORIA = cat.ID_CATEGORIA");

		sql.append(" AND ");

		sql.append("ui.CODICE_IMPIANTO = :codImpianto AND ui.FLG_PRINCIPALE = 1");
		/*PROTECTED REGION ID(R455669957) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("codImpianto", input);

		/*PROTECTED REGION END*/

		List<SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, principaleByCodiceImpiantoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTUnitaImmobiliareDaoImpl::findPrincipaleByCodiceImpianto] ERROR esecuzione query", ex);
			throw new SigitTUnitaImmobiliareDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTUnitaImmobiliareDaoImpl", "findPrincipaleByCodiceImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTUnitaImmobiliareDaoImpl::findPrincipaleByCodiceImpianto] END");
		}
		return list;
	}

}
