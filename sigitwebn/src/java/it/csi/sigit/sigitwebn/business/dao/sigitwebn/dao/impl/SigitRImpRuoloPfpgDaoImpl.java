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

/*PROTECTED REGION ID(R942554433) ENABLED START*/
import java.math.BigDecimal;

import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRImpRuoloPfpg.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byCodiceImpianto (datagen::CustomFinder)
 *   - manutentoriByCodiceImpianto (datagen::CustomFinder)
 *   - byRuoloConUtente (datagen::CustomFinder)
 *   - attiviByFilter (datagen::CustomFinder)
 *   - ruoloAttivoPgByCodImpiantoRuoloFunz (datagen::CustomFinder)
 *   - ruoloAttivoPfByCodImpiantoRuoloFunz (datagen::CustomFinder)
 *   - respImpRespAttivoPgByCodImpianto (datagen::CustomFinder)
 *   - respImpRespAttivoPfByCodImpianto (datagen::CustomFinder)
 *   - ruoloAttivoPgByCodImpiantoRuolo (datagen::CustomFinder)
 *   - genericByFilter (datagen::CustomFinder)
 *   - genericPfByFilter (datagen::CustomFinder)
 *   - soloAttiviByFilter (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - subentroRespImpResp (datagen::CustomUpdater)
 *   - subentroPropImpProp (datagen::CustomUpdater)
 *   - subentroInstManut (datagen::CustomUpdater)
 *   - flgPrimoCaricatore (datagen::UpdateColumns)
 *   - terminaRiga (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *   - byCodImpianto (datagen::CustomDeleter)
 *   - byFilter (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRImpRuoloPfpgDaoImpl extends AbstractDAO implements SigitRImpRuoloPfpgDao {
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
	 * Metodo di inserimento del DAO sigitRImpRuoloPfpg. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRImpRuoloPfpgPk
	 * @generated
	 */

	public SigitRImpRuoloPfpgPk insert(SigitRImpRuoloPfpgDto dto)

	{
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE ) VALUES (  :ID_IMP_RUOLO_PFPG , :FK_RUOLO , :CODICE_IMPIANTO , :DATA_INIZIO , :DATA_FINE , :FK_PERSONA_FISICA , :FK_PERSONA_GIURIDICA , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :FLG_PRIMO_CARICATORE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_IMP_RUOLO_PFPG]
		params.addValue("ID_IMP_RUOLO_PFPG", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_RUOLO]
		params.addValue("FK_RUOLO", dto.getFkRuolo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_PERSONA_FISICA]
		params.addValue("FK_PERSONA_FISICA", dto.getFkPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_PERSONA_GIURIDICA]
		params.addValue("FK_PERSONA_GIURIDICA", dto.getFkPersonaGiuridica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_PRIMO_CARICATORE]
		params.addValue("FLG_PRIMO_CARICATORE", dto.getFlgPrimoCaricatore(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdImpRuoloPfpg(newKey);
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */
	public void update(SigitRImpRuoloPfpgDto dto) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_RUOLO = :FK_RUOLO ,CODICE_IMPIANTO = :CODICE_IMPIANTO ,DATA_INIZIO = :DATA_INIZIO ,DATA_FINE = :DATA_FINE ,FK_PERSONA_FISICA = :FK_PERSONA_FISICA ,FK_PERSONA_GIURIDICA = :FK_PERSONA_GIURIDICA ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,FLG_PRIMO_CARICATORE = :FLG_PRIMO_CARICATORE  WHERE ID_IMP_RUOLO_PFPG = :ID_IMP_RUOLO_PFPG ";

		if (dto.getIdImpRuoloPfpg() == null) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitRImpRuoloPfpgDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_IMP_RUOLO_PFPG]
		params.addValue("ID_IMP_RUOLO_PFPG", dto.getIdImpRuoloPfpg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_RUOLO]
		params.addValue("FK_RUOLO", dto.getFkRuolo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_PERSONA_FISICA]
		params.addValue("FK_PERSONA_FISICA", dto.getFkPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_PERSONA_GIURIDICA]
		params.addValue("FK_PERSONA_GIURIDICA", dto.getFkPersonaGiuridica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_PRIMO_CARICATORE]
		params.addValue("FLG_PRIMO_CARICATORE", dto.getFlgPrimoCaricatore(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::update] END");
	}

	/** 
	 * Custom updater in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */
	public void customUpdaterSubentroRespImpResp(SigitRImpRuoloPfpgDto filter, java.lang.Object value)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::customUpdaterSubentroRespImpResp] START");
		/*PROTECTED REGION ID(R1931016304) ENABLED START*/
		//***scrivere la custom query

		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE SIGIT_R_IMP_RUOLO_PFPG SET ");
		sql.append(" DATA_FINE = CURRENT_DATE-1 ");
		sql.append(" WHERE ID_IMP_RUOLO_PFPG in ");
		sql.append(" (SELECT ID_IMP_RUOLO_PFPG ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG pfpg, SIGIT_D_RUOLO r ");
		sql.append(" WHERE pfpg.FK_RUOLO = r.ID_RUOLO ");
		sql.append(" AND (pfpg.DATA_FINE IS NULL OR pfpg.DATA_FINE = CURRENT_DATE) ");
		sql.append(" AND CODICE_IMPIANTO = :codImpianto ");
		sql.append(" AND r.RUOLO_FUNZ IN ('" + Constants.RUOLO_RESPONSABILE + "', '"
				+ Constants.RUOLO_RESPONSABILE_IMPRESA + "')) ");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter.getCodiceImpianto());

		/*PROTECTED REGION END*/

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::customUpdaterSubentroRespImpResp] END");
	}

	/** 
	 * Custom updater in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */
	public void customUpdaterSubentroPropImpProp(SigitRImpRuoloPfpgDto filter, java.lang.Object value)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::customUpdaterSubentroPropImpProp] START");
		/*PROTECTED REGION ID(R916539344) ENABLED START*/
		//***scrivere la custom query
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE SIGIT_R_IMP_RUOLO_PFPG SET ");
		sql.append(" DATA_FINE = CURRENT_DATE-1 ");
		sql.append(" WHERE ID_IMP_RUOLO_PFPG in ");
		sql.append(" (SELECT ID_IMP_RUOLO_PFPG ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG pfpg, SIGIT_D_RUOLO r ");
		sql.append(" WHERE pfpg.FK_RUOLO = r.ID_RUOLO ");
		sql.append(" AND (pfpg.DATA_FINE IS NULL OR pfpg.DATA_FINE = CURRENT_DATE) ");
		sql.append(" AND CODICE_IMPIANTO = :codImpianto ");
		sql.append(" AND r.RUOLO_FUNZ IN ('" + Constants.RUOLO_PROPRIETARIO + "', '"
				+ Constants.RUOLO_PROPRIETARIO_IMPRESA + "')) ");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter.getCodiceImpianto());
		/*PROTECTED REGION END*/

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::customUpdaterSubentroPropImpProp] END");
	}

	/** 
	 * Custom updater in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */
	public void customUpdaterSubentroInstManut(SigitRImpRuoloPfpgDto filter, java.lang.Object value)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::customUpdaterSubentroInstManut] START");
		/*PROTECTED REGION ID(R-1333847351) ENABLED START*/
		//***scrivere la custom query
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE SIGIT_R_IMP_RUOLO_PFPG SET ");
		sql.append(" DATA_FINE = CURRENT_DATE-1, ");
		sql.append(" UTENTE_ULT_MOD = :utUltMod, ");
		sql.append(" DATA_ULT_MOD = :dataUltMod ");
		sql.append(" WHERE FK_RUOLO = :idRuolo ");
		sql.append(" AND CODICE_IMPIANTO = :codImpianto ");
		//sql.append(" AND DATA_FINE IS NULL ");
		sql.append(
				" AND (DATA_FINE IS NULL OR (DATA_FINE is not null AND current_date >= DATA_INIZIO AND current_date <= DATA_FINE)) ");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter.getCodiceImpianto());
		params.addValue("idRuolo", filter.getFkRuolo());
		params.addValue("utUltMod", filter.getUtenteUltMod());
		params.addValue("dataUltMod", filter.getDataUltMod());

		/*PROTECTED REGION END*/

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::customUpdaterSubentroInstManut] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */
	public void updateColumnsFlgPrimoCaricatore(SigitRImpRuoloPfpgDto dto) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::updateColumnsFlgPrimoCaricatore] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FLG_PRIMO_CARICATORE = :FLG_PRIMO_CARICATORE ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD  WHERE ID_IMP_RUOLO_PFPG = :ID_IMP_RUOLO_PFPG ";

		if (dto.getIdImpRuoloPfpg() == null) {
			LOG.error(
					"[SigitRImpRuoloPfpgDaoImpl::updateColumnsFlgPrimoCaricatore] ERROR chiave primaria non impostata");
			throw new SigitRImpRuoloPfpgDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FLG_PRIMO_CARICATORE]
		params.addValue("FLG_PRIMO_CARICATORE", dto.getFlgPrimoCaricatore(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_IMP_RUOLO_PFPG]
		params.addValue("ID_IMP_RUOLO_PFPG", dto.getIdImpRuoloPfpg(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::updateColumnsFlgPrimoCaricatore] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */
	public void updateColumnsTerminaRiga(SigitRImpRuoloPfpgDto dto) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::updateColumnsTerminaRiga] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,DATA_ULT_MOD = :DATA_ULT_MOD ,DATA_FINE = :DATA_FINE  WHERE ID_IMP_RUOLO_PFPG = :ID_IMP_RUOLO_PFPG ";

		if (dto.getIdImpRuoloPfpg() == null) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::updateColumnsTerminaRiga] ERROR chiave primaria non impostata");
			throw new SigitRImpRuoloPfpgDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [ID_IMP_RUOLO_PFPG]
		params.addValue("ID_IMP_RUOLO_PFPG", dto.getIdImpRuoloPfpg(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::updateColumnsTerminaRiga] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */

	public void delete(SigitRImpRuoloPfpgPk pk) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_IMP_RUOLO_PFPG = :ID_IMP_RUOLO_PFPG ";

		if (pk == null) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitRImpRuoloPfpgDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_IMP_RUOLO_PFPG]
		params.addValue("ID_IMP_RUOLO_PFPG", pk.getIdImpRuoloPfpg(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::delete] END");
	}

	/** 
	 * Custom deleter in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R1617132236) ENABLED START*/
		//***scrivere la custom query
		final StringBuilder sql = new StringBuilder("DELETE FROM " + getTableName() + " WHERE ");
		sql.append(" CODICE_IMPIANTO = :codImpianto");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::customDeleterByCodImpianto] END");
	}

	/** 
	 * Custom deleter in the SIGIT_R_IMP_RUOLO_PFPG table.
	 * @generated
	 */
	public void customDeleterByFilter(SigitRImpRuoloPfpgDto filter) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::customDeleterByFilter] START");
		/*PROTECTED REGION ID(R-981131381) ENABLED START*/
		StringBuilder sql = new StringBuilder(
				"DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto ");
		MapSqlParameterSource params = new MapSqlParameterSource();

		if (filter.getFkRuolo() != null)
			sql.append(" AND FK_RUOLO = :ruolo");

		params.addValue("codImpianto", filter.getCodiceImpianto(), java.sql.Types.NUMERIC);
		params.addValue("ruolo", filter.getFkRuolo(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::customDeleterByFilter] END");
	}

	protected SigitRImpRuoloPfpgDaoRowMapper findByPrimaryKeyRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(null,
			SigitRImpRuoloPfpgDto.class, this);

	protected SigitRImpRuoloPfpgDaoRowMapper byCodiceImpiantoRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(null,
			SigitRImpRuoloPfpgDto.class, this);

	protected SigitRImpRuoloPfpgDaoRowMapper manutentoriByCodiceImpiantoRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(
			null, SigitRImpRuoloPfpgManutentoriByCodiceImpiantoDto.class, this);

	protected SigitRImpRuoloPfpgDaoRowMapper byRuoloConUtenteRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(null,
			SigitRImpRuoloPfpgDto.class, this);

	protected SigitRImpRuoloPfpgDaoRowMapper attiviByFilterRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(null,
			SigitRImpRuoloPfpgDto.class, this);

	protected SigitRImpRuoloPfpgDaoRowMapper ruoloAttivoPgByCodImpiantoRuoloFunzRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(
			null, SigitRImpRuoloPfpgDto.class, this);

	protected SigitRImpRuoloPfpgDaoRowMapper ruoloAttivoPfByCodImpiantoRuoloFunzRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(
			null, SigitRImpRuoloPfpgDto.class, this);

	protected SigitRImpRuoloPfpgDaoRowMapper respImpRespAttivoPgByCodImpiantoRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(
			null, SigitRImpRuoloPfpgDto.class, this);

	protected SigitRImpRuoloPfpgDaoRowMapper respImpRespAttivoPfByCodImpiantoRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(
			null, SigitRImpRuoloPfpgDto.class, this);

	protected SigitRImpRuoloPfpgDaoRowMapper ruoloAttivoPgByCodImpiantoRuoloRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(
			null, SigitRImpRuoloPfpgDto.class, this);

	protected SigitRImpRuoloPfpgDaoRowMapper genericByFilterRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(null,
			SigitRImpRuoloPfpgGenericByFilterDto.class, this);

	protected SigitRImpRuoloPfpgDaoRowMapper genericPfByFilterRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(null,
			SigitRImpRuoloPfpgGenericPfByFilterDto.class, this);

	protected SigitRImpRuoloPfpgDaoRowMapper soloAttiviByFilterRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(null,
			SigitRImpRuoloPfpgDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_IMP_RUOLO_PFPG";
	}

	/** 
	 * Returns all rows from the SIGIT_R_IMP_RUOLO_PFPG table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRImpRuoloPfpgDto findByPrimaryKey(SigitRImpRuoloPfpgPk pk) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE FROM "
						+ getTableName() + " WHERE ID_IMP_RUOLO_PFPG = :ID_IMP_RUOLO_PFPG ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_IMP_RUOLO_PFPG]
		params.addValue("ID_IMP_RUOLO_PFPG", pk.getIdImpRuoloPfpg(), java.sql.Types.NUMERIC);

		List<SigitRImpRuoloPfpgDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findByCodiceImpianto(java.lang.Integer input)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R2010227017) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_IMPIANTO = :idImpianto");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1226908135) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findByCodiceImpianto] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findByCodiceImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByCodiceImpianto] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder manutentoriByCodiceImpianto con Qdef
		 * @generated
		 */

	public List<SigitRImpRuoloPfpgManutentoriByCodiceImpiantoDto> findManutentoriByCodiceImpianto(
			java.lang.Integer input) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findManutentoriByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT pg.CODICE_FISCALE, pg.SIGLA_REA, pg.NUMERO_REA, pg.DENOMINAZIONE, td.DES_TIPO_DOCUMENTO");

		sql.append(
				" FROM SIGIT_R_IMP_RUOLO_PFPG ir, SIGIT_T_PERSONA_GIURIDICA pg, SIGIT_R_RUOLO_TIPODOC rtd, SIGIT_D_TIPO_DOCUMENTO td");

		sql.append(" WHERE ");

		sql.append(
				"ir.FK_PERSONA_GIURIDICA = pg.ID_PERSONA_GIURIDICA AND ir.FK_RUOLO = rtd.ID_RUOLO AND rtd.ID_TIPO_DOCUMENTO = td.ID_TIPO_DOCUMENTO");

		sql.append(" AND ");

		sql.append("1=1");
		/*PROTECTED REGION ID(R-341480159) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" AND ir.CODICE_IMPIANTO = :idImpianto");
		sql.append(" AND ir.FK_RUOLO IN (" + Constants.ID_RUOLO_MANUTENTORE_ALL_1 + ","
				+ Constants.ID_RUOLO_MANUTENTORE_ALL_2 + "," + Constants.ID_RUOLO_MANUTENTORE_ALL_3 + ","
				+ Constants.ID_RUOLO_MANUTENTORE_ALL_4 + ")");
		sql.append(" AND ir.DATA_FINE IS NULL");

		paramMap.addValue("idImpianto", input);

		//paramMap.addValue("param", input);

		/*PROTECTED REGION END*/

		List<SigitRImpRuoloPfpgManutentoriByCodiceImpiantoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, manutentoriByCodiceImpiantoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findManutentoriByCodiceImpianto] ERROR esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findManutentoriByCodiceImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findManutentoriByCodiceImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byRuoloConUtente
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findByRuoloConUtente(
			it.csi.sigit.sigitwebn.dto.allegati.FiltroRicercaCodiciImpianto input)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByRuoloConUtente] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R2126768093) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		log.debug("fraaaaaaaaaaaaaaaaaaaaa --> input.getIdRuolo().size(): " + input.getIdRuolo().size());
		String ruolo = "";
		if (input.getIdRuolo().size() == 1) {
			ruolo = input.getIdRuolo().get(0);
		} else {
			for (String s : input.getIdRuolo()) {
				ruolo += s + ",";
			}
			ruolo = ruolo.substring(0, (ruolo.length() - 1));
			log.debug("fraaaaaaaaaaaaaaaaaaaaa --> ho + ruoli ---> RUOLO: " + ruolo);
			log.debug("fraaaaaaaaaaaaaaaaaaaaa --> ho + ruoli ---> RUOLO: " + ruolo.length());
			ruolo = ruolo.substring(0, (ruolo.length() - 1));
		}

		log.debug("fraaaaaaaaaaaaaaaaaaaaa -->RUOLO: " + ruolo);
		log.debug("fraaaaaaaaaaaaaaaaaaaaa -->input.getIdPersonaGiuridica(): " + input.getIdPersonaGiuridica());
		log.debug("fraaaaaaaaaaaaaaaaaaaaa -->input.getIdPersonaFisica(): " + input.getIdPersonaFisica());
		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		if (input.getDescrizioneRuoloFunzionale().equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)
				|| input.getDescrizioneRuoloFunzionale().equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO_IMPRESA)) {
			sql.append(" FK_PERSONA_GIURIDICA = :idPersonaGiuridica");
			if (!"".equals(ruolo))
				sql.append(" AND FK_RUOLO IN (").append(ruolo).append(")");
			sql.append(" AND DATA_FINE IS NULL");
		}
		if (input.getDescrizioneRuoloFunzionale().equalsIgnoreCase(Constants.RUOLO_RESPONSABILE)
				|| input.getDescrizioneRuoloFunzionale().equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO)) {
			sql.append(" FK_PERSONA_FISICA = :idPersonaFisica");
			if (!"".equals(ruolo))
				sql.append(" AND FK_RUOLO IN (").append(ruolo).append(")");
			sql.append(" AND DATA_FINE IS NULL");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1909102075) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input.getDescrizioneRuoloFunzionale().equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)
				|| input.getDescrizioneRuoloFunzionale().equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO_IMPRESA)) {
			paramMap.addValue("idPersonaGiuridica", new BigDecimal(input.getIdPersonaGiuridica()));
		}

		if (input.getDescrizioneRuoloFunzionale().equalsIgnoreCase(Constants.RUOLO_RESPONSABILE)
				|| input.getDescrizioneRuoloFunzionale().equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO)) {
			paramMap.addValue("idPersonaFisica", new BigDecimal(input.getIdPersonaFisica()));
		}

		/*PROTECTED REGION END*/
		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byRuoloConUtenteRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findByRuoloConUtente] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findByRuoloConUtente", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByRuoloConUtente] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder attiviByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findAttiviByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaPfPg input)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findAttiviByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R279095556) ENABLED START*/

		sql.append(" DATA_FINE IS NULL");

		if (input.getCodiceImpianto() != null) {
			sql.append(" AND CODICE_IMPIANTO = :codImpianto");
		}

		if (input.getIdRuolo() != null) {
			sql.append(" AND FK_RUOLO = :ruolo");
		}

		if (input.getIdRuoloList() != null && !input.getIdRuoloList().isEmpty()) {
			sql.append(" AND FK_RUOLO IN (" + ConvertUtil.getStringByList(input.getIdRuoloList()) + ")");
		}

		if (input.getIdPersonaFisica() != null) {
			sql.append(" AND FK_PERSONA_FISICA = :fkFisica");
		}

		if (input.getIdPersonaGiuridica() != null) {
			sql.append(" AND FK_PERSONA_GIURIDICA = :fkGiuridica");
		}

		if (input.getIsEscludiDataOdierna()) {
			sql.append(" AND DATA_INIZIO <> CURRENT_DATE ");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R942591422) ENABLED START*/
		if (input.getCodiceImpianto() != null) {
			paramMap.addValue("codImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);
		}
		if (input.getIdRuolo() != null) {
			paramMap.addValue("ruolo", input.getIdRuolo(), java.sql.Types.NUMERIC);
		}

		if (input.getIdPersonaFisica() != null) {
			paramMap.addValue("fkFisica", input.getIdPersonaFisica(), java.sql.Types.NUMERIC);
		}

		if (input.getIdPersonaGiuridica() != null) {
			paramMap.addValue("fkGiuridica", input.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);
		}

		/*PROTECTED REGION END*/
		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attiviByFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findAttiviByFilter] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findAttiviByFilter", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findAttiviByFilter] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder ruoloAttivoPgByCodImpiantoRuoloFunz
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findRuoloAttivoPgByCodImpiantoRuoloFunz(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.PersonaRuoloFilter input)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findRuoloAttivoPgByCodImpiantoRuoloFunz] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R1886331675) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,FLG_PRIMO_CARICATORE,pfpg.DATA_ULT_MOD,pfpg.UTENTE_ULT_MOD ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-8863635) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG pfpg, SIGIT_D_RUOLO r");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-492136915) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		sql.append(" pfpg.FK_RUOLO = r.ID_RUOLO");
		sql.append(" AND CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND FK_PERSONA_GIURIDICA = :persGiuridica");
		sql.append(" AND r.RUOLO_FUNZ = :ruoloFunz");
		sql.append(" AND DATA_INIZIO <= CURRENT_DATE");
		sql.append(" AND COALESCE(DATA_FINE,CURRENT_DATE) >= CURRENT_DATE");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1490778699) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodiceImpianto());
		paramMap.addValue("persGiuridica", input.getIdPersonaGiuridica());
		paramMap.addValue("ruoloFunz", input.getRuoloFunz());

		/*PROTECTED REGION END*/
		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ruoloAttivoPgByCodImpiantoRuoloFunzRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findRuoloAttivoPgByCodImpiantoRuoloFunz] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findRuoloAttivoPgByCodImpiantoRuoloFunz",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findRuoloAttivoPgByCodImpiantoRuoloFunz] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder ruoloAttivoPfByCodImpiantoRuoloFunz
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findRuoloAttivoPfByCodImpiantoRuoloFunz(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.PersonaRuoloFilter input)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findRuoloAttivoPfByCodImpiantoRuoloFunz] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R253527676) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,FLG_PRIMO_CARICATORE,pfpg.DATA_ULT_MOD,pfpg.UTENTE_ULT_MOD ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1959163890) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG pfpg, SIGIT_D_RUOLO r, SIGIT_T_PERSONA_FISICA pf");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-821902676) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		sql.append(" pfpg.FK_RUOLO = r.ID_RUOLO");
		sql.append(" AND pfpg.FK_PERSONA_FISICA = pf.ID_PERSONA_FISICA");

		sql.append(" AND CODICE_IMPIANTO = :codImpianto");

		if (GenericUtil.isNotNullOrEmpty(input.getCfPersonaFisica())) {
			sql.append(" AND pf.CODICE_FISCALE = :codiceFiscale");
			paramMap.addValue("codiceFiscale", input.getCfPersonaFisica());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getRuoloFunz())) {
			sql.append(" AND r.RUOLO_FUNZ = :ruoloFunz");
			paramMap.addValue("ruoloFunz", input.getRuoloFunz());
		}

		if (input.getIdImpRuoloPfpg() != null) {
			sql.append(" AND r.ID_IMP_RUOLO_PFPG = :idImpRuoloPFPG");
			paramMap.addValue("idImpRuoloPFPG", input.getIdImpRuoloPfpg());
		}

		sql.append(" AND DATA_INIZIO <= CURRENT_DATE");
		sql.append(" AND COALESCE(DATA_FINE,CURRENT_DATE) >= CURRENT_DATE");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1171384598) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodiceImpianto());

		/*PROTECTED REGION END*/
		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ruoloAttivoPfByCodImpiantoRuoloFunzRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findRuoloAttivoPfByCodImpiantoRuoloFunz] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findRuoloAttivoPfByCodImpiantoRuoloFunz",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findRuoloAttivoPfByCodImpiantoRuoloFunz] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder respImpRespAttivoPgByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findRespImpRespAttivoPgByCodImpianto(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.PersonaRuoloFilter input)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findRespImpRespAttivoPgByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-1160361012) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,FLG_PRIMO_CARICATORE,pfpg.DATA_ULT_MOD,pfpg.UTENTE_ULT_MOD ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-834379426) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG pfpg, SIGIT_D_RUOLO r");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-313322660) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" pfpg.FK_RUOLO = r.ID_RUOLO");
		sql.append(" AND CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND FK_PERSONA_GIURIDICA = :persGiuridica");
		sql.append(" AND r.RUOLO_FUNZ IN ('" + Constants.RUOLO_RESPONSABILE + "','"
				+ Constants.RUOLO_RESPONSABILE_IMPRESA + "')");
		sql.append(" AND DATA_FINE IS NULL ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-242504090) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodiceImpianto());
		paramMap.addValue("persGiuridica", input.getIdPersonaGiuridica());

		/*PROTECTED REGION END*/
		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, respImpRespAttivoPgByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findRespImpRespAttivoPgByCodImpianto] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findRespImpRespAttivoPgByCodImpianto",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findRespImpRespAttivoPgByCodImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder respImpRespAttivoPfByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findRespImpRespAttivoPfByCodImpianto(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.PersonaRuoloFilter input)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findRespImpRespAttivoPfByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-1853462709) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,FLG_PRIMO_CARICATORE,pfpg.DATA_ULT_MOD,pfpg.UTENTE_ULT_MOD ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1795993443) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG pfpg, SIGIT_D_RUOLO r, SIGIT_T_PERSONA_FISICA pf");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-58586115) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" pfpg.FK_RUOLO = r.ID_RUOLO");
		sql.append(" AND pfpg.FK_PERSONA_FISICA = pf.ID_PERSONA_FISICA");

		sql.append(" AND CODICE_IMPIANTO = :codImpianto");

		sql.append(" AND pf.CODICE_FISCALE = :codiceFiscale");

		sql.append(" AND r.RUOLO_FUNZ IN ('" + Constants.RUOLO_RESPONSABILE + "','"
				+ Constants.RUOLO_RESPONSABILE_IMPRESA + "')");
		sql.append(" AND DATA_FINE IS NULL ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-935605787) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodiceImpianto());
		paramMap.addValue("codiceFiscale", input.getCfPersonaFisica());

		/*PROTECTED REGION END*/
		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, respImpRespAttivoPfByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findRespImpRespAttivoPfByCodImpianto] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findRespImpRespAttivoPfByCodImpianto",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findRespImpRespAttivoPfByCodImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder ruoloAttivoPgByCodImpiantoRuolo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findRuoloAttivoPgByCodImpiantoRuolo(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.PersonaRuoloFilter input)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findRuoloAttivoPgByCodImpiantoRuolo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R566846578) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" CODICE_IMPIANTO = :codImpianto");
		if (GenericUtil.isNotNullOrEmpty(input.getIdPersonaGiuridica())) {
			sql.append(" AND FK_PERSONA_GIURIDICA = :persGiuridica");
		}
		sql.append(" AND FK_RUOLO = :idRuolo");
		sql.append(" AND DATA_FINE IS NULL "); // CHIEDERE

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1272938512) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodiceImpianto());
		if (GenericUtil.isNotNullOrEmpty(input.getIdPersonaGiuridica())) {
			paramMap.addValue("persGiuridica", input.getIdPersonaGiuridica());
		}
		paramMap.addValue("idRuolo", input.getIdRuolo());

		/*PROTECTED REGION END*/
		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ruoloAttivoPgByCodImpiantoRuoloRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findRuoloAttivoPgByCodImpiantoRuolo] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findRuoloAttivoPgByCodImpiantoRuolo",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findRuoloAttivoPgByCodImpiantoRuolo] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder genericByFilter con Qdef
		 * @generated
		 */

	public List<SigitRImpRuoloPfpgGenericByFilterDto> findGenericByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaImpiantiSoggettoFilter input)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findGenericByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT impRuoloPfPg.ID_IMP_RUOLO_PFPG as idImpRuoloPgPf, impRuoloPfPg.CODICE_IMPIANTO as codiceImpianto, impRuoloPfPg.DATA_INIZIO as dataInizio, impRuoloPfPg.DATA_FINE as dataFine, impRuoloPfPg.FK_PERSONA_FISICA as idPersonaFisica, impRuoloPfPg.FK_PERSONA_GIURIDICA as idPersonaGiuridica, ruolo.DES_RUOLO as desRuolo, ruolo.RUOLO_FUNZ as ruoloFunz");

		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG impRuoloPfPg, SIGIT_D_RUOLO ruolo");

		sql.append(" WHERE ");

		sql.append("ruolo.ID_RUOLO = impRuoloPfPg.FK_RUOLO");

		sql.append(" AND ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R1106210340) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" AND impRuoloPfPg.CODICE_IMPIANTO = :codiceImpianto");

		if (input.getIdPersonaFisica() != null) {
			sql.append(" AND impRuoloPfPg.FK_PERSONA_FISICA = :idPersonaFisica");
		}

		if (input.getIdPersonaGiuridica() != null) {
			sql.append(" AND impRuoloPfPg.FK_PERSONA_GIURIDICA = :idPersonaGiuridica");
		}

		if (input.getListaRuoliInclusi() != null && !input.getListaRuoliInclusi().isEmpty()) {
			if (input.getListaRuoliInclusi().size() == 1) {
				sql.append(" AND ruolo.RUOLO_FUNZ = " + input.getListaRuoliInclusi().get(0));
			} else {
				sql.append(" AND ruolo.RUOLO_FUNZ IN (" + ConvertUtil.getStringByList(input.getListaRuoliInclusi())
						+ ")");;
			}
		}

		//se c'e' la data inizio e data fine allora si stanno cercando i ruoli che hanno un'intersezione col periodo
		//se invece c'e' solo la data inizio allora si stanno cercando i ruoli che hanno l'input compreso nella loro validita'
		if (input.getDataInizio() != null) {
			if (input.getDataFine() != null) {
				sql.append(
						" AND impRuoloPfPg.DATA_INIZIO <= :dataFine AND COALESCE(impRuoloPfPg.DATA_FINE, :dataInizio) >= :dataInizio");
			} else {
				sql.append(
						" AND :dataInizio BETWEEN  impRuoloPfPg.DATA_INIZIO AND COALESCE(impRuoloPfPg.DATA_FINE, :dataInizio)");
			}
		}

		//paramMap.addValue("param", input);
		paramMap.addValue("codiceImpianto", input.getCodiceImpianto());

		if (input.getIdPersonaFisica() != null) {
			paramMap.addValue("idPersonaFisica", input.getIdPersonaFisica());
		}

		if (input.getIdPersonaGiuridica() != null) {
			paramMap.addValue("idPersonaGiuridica", input.getIdPersonaGiuridica());
		}

		if (input.getDataInizio() != null) {
			paramMap.addValue("dataInizio", input.getDataInizio());
		}

		if (input.getDataFine() != null) {
			paramMap.addValue("dataFine", input.getDataFine());
		}

		/*PROTECTED REGION END*/

		List<SigitRImpRuoloPfpgGenericByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, genericByFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findGenericByFilter] ERROR esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findGenericByFilter", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findGenericByFilter] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder genericPfByFilter con Qdef
		 * @generated
		 */

	public List<SigitRImpRuoloPfpgGenericPfByFilterDto> findGenericPfByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaImpiantiSoggettoFilter input)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findGenericPfByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT impRuoloPfPg.ID_IMP_RUOLO_PFPG as idImpRuoloPgPf, impRuoloPfPg.CODICE_IMPIANTO as codiceImpianto, impRuoloPfPg.DATA_INIZIO as dataInizio, impRuoloPfPg.DATA_FINE as dataFine, impRuoloPfPg.FK_PERSONA_FISICA as idPersonaFisica, pf.NOME as nome, pf.COGNOME as cognome, pf.CODICE_FISCALE as codiceFiscale");

		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG impRuoloPfPg, SIGIT_T_PERSONA_FISICA pf");

		sql.append(" WHERE ");

		sql.append("pf.ID_PERSONA_FISICA = impRuoloPfPg.FK_PERSONA_FISICA");

		sql.append(" AND ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R1182383610) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:
		if (input.getCodiceImpianto() != null) {
			sql.append(" AND impRuoloPfPg.CODICE_IMPIANTO = :codiceImpianto");
		}

		if (input.getIdPersonaFisica() != null) {
			sql.append(" AND impRuoloPfPg.FK_PERSONA_FISICA = :idPersonaFisica");
		}

		if (input.getListaRuoliInclusi() != null && !input.getListaRuoliInclusi().isEmpty()) {
			if (input.getListaRuoliInclusi().size() == 1) {
				sql.append(" AND ruolo.RUOLO_FUNZ = " + input.getListaRuoliInclusi().get(0));
			} else {
				sql.append(" AND ruolo.RUOLO_FUNZ IN (" + ConvertUtil.getStringByList(input.getListaRuoliInclusi())
						+ ")");;
			}
		}

		//se c'e' la data inizio e data fine allora si stanno cercando i ruoli che hanno un'intersezione col periodo
		//se invece c'e' solo la data inizio allora si stanno cercando i ruoli che hanno l'input compreso nella loro validita'
		if (input.getDataInizio() != null) {
			if (input.getDataFine() != null) {
				sql.append(
						" AND impRuoloPfPg.DATA_INIZIO <= :dataFine AND COALESCE(impRuoloPfPg.DATA_FINE, :dataInizio) >= :dataInizio");
			} else {
				sql.append(
						" AND :dataInizio BETWEEN  impRuoloPfPg.DATA_INIZIO AND COALESCE(impRuoloPfPg.DATA_FINE, :dataInizio)");
			}
		}

		if (input.getIdImpRuoloPfpg() != null) {
			sql.append(" AND impRuoloPfPg.ID_IMP_RUOLO_PFPG = :idImpRuoloPfpg");
			paramMap.addValue("idImpRuoloPfpg", input.getIdImpRuoloPfpg());
		}

		if (input.getCodiceImpianto() != null) {
			paramMap.addValue("codiceImpianto", input.getCodiceImpianto());
		}

		if (input.getIdPersonaFisica() != null) {
			paramMap.addValue("idPersonaFisica", input.getIdPersonaFisica());
		}

		if (input.getDataInizio() != null) {
			paramMap.addValue("dataInizio", input.getDataInizio());
		}

		if (input.getDataFine() != null) {
			paramMap.addValue("dataFine", input.getDataFine());
		}

		/*PROTECTED REGION END*/

		List<SigitRImpRuoloPfpgGenericPfByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, genericPfByFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findGenericPfByFilter] ERROR esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findGenericPfByFilter", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findGenericPfByFilter] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder soloAttiviByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findSoloAttiviByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaPfPg input)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findSoloAttiviByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1694328957) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		//sql.append(" DATA_FINE IS NULL");
		sql.append(
				" (DATA_FINE IS NULL OR (DATA_FINE is not null AND current_date >= DATA_INIZIO AND current_date <= DATA_FINE)) ");

		if (input.getCodiceImpianto() != null) {
			sql.append(" AND CODICE_IMPIANTO = :codImpianto");
		}

		if (input.getIdRuolo() != null) {
			sql.append(" AND FK_RUOLO = :ruolo");
		}

		if (input.getIdRuoloList() != null && !input.getIdRuoloList().isEmpty()) {
			sql.append(" AND FK_RUOLO IN (" + ConvertUtil.getStringByList(input.getIdRuoloList()) + ")");
		}

		if (input.getIdPersonaFisica() != null) {
			sql.append(" AND FK_PERSONA_FISICA = :fkFisica");
		}

		if (input.getIdPersonaGiuridica() != null) {
			sql.append(" AND FK_PERSONA_GIURIDICA = :fkGiuridica");
		}

		if (input.getIsEscludiDataOdierna()) {
			sql.append(" AND DATA_INIZIO <> CURRENT_DATE ");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-104026337) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input.getCodiceImpianto() != null) {
			paramMap.addValue("codImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);
		}
		if (input.getIdRuolo() != null) {
			paramMap.addValue("ruolo", input.getIdRuolo(), java.sql.Types.NUMERIC);
		}

		if (input.getIdPersonaFisica() != null) {
			paramMap.addValue("fkFisica", input.getIdPersonaFisica(), java.sql.Types.NUMERIC);
		}

		if (input.getIdPersonaGiuridica() != null) {
			paramMap.addValue("fkGiuridica", input.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);
		}

		/*PROTECTED REGION END*/
		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, soloAttiviByFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findSoloAttiviByFilter] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findSoloAttiviByFilter", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findSoloAttiviByFilter] END");
		}
		return list;
	}

}
