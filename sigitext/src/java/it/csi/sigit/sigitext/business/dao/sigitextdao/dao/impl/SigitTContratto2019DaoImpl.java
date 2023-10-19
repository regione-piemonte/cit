package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTContratto2019Dao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.ContrattoFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.PersonaRuoloFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTContratto2019DaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTContratto2019Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTContratto2019Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTContratto2019DaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.DateUtil;
import it.csi.sigit.sigitext.business.util.GenericUtil;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.math.BigDecimal;
import java.util.List;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTContratto2019.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byFilter (datagen::CustomFinder)
 *   - byId3Responsabile (datagen::CustomFinder)
 *   - byIdResponsabile (datagen::CustomFinder)
 *   - byCodImpSysdate (datagen::CustomFinder)
  * - UPDATERS:
 *   - perRevoca (datagen::UpdateColumns)
 *   - perProroga (datagen::UpdateColumns)
 * - DELETERS:
 *   - byCodImpianto (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTContratto2019DaoImpl extends AbstractDAO implements SigitTContratto2019Dao {
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
	 * Metodo di inserimento del DAO sigitTContratto2019. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTContratto2019Pk
	 * @generated
	 */

	public SigitTContratto2019Pk insert(SigitTContratto2019Dto dto)

	{
		LOG.debug("[SigitTContratto2019DaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_CONTRATTO,FK_PG_3_RESP,FK_IMP_RUOLO_PFPG_RESP,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FLG_TACITO_RINNOVO,DATA_CARICAMENTO,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_CESSAZIONE,DATA_INSERIMENTO_CESSAZIONE,MOTIVO_CESSAZIONE,FK_TIPO_CESSAZIONE,NOTE ) VALUES (  :ID_CONTRATTO , :FK_PG_3_RESP , :FK_IMP_RUOLO_PFPG_RESP , :CODICE_IMPIANTO , :DATA_INIZIO , :DATA_FINE , :FLG_TACITO_RINNOVO , :DATA_CARICAMENTO , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :DATA_CESSAZIONE , :DATA_INSERIMENTO_CESSAZIONE , :MOTIVO_CESSAZIONE , :FK_TIPO_CESSAZIONE , :NOTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONTRATTO]
		params.addValue("ID_CONTRATTO", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_PG_3_RESP]
		params.addValue("FK_PG_3_RESP", dto.getFkPg3Resp(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_IMP_RUOLO_PFPG_RESP]
		params.addValue("FK_IMP_RUOLO_PFPG_RESP", dto.getFkImpRuoloPfpgResp(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FLG_TACITO_RINNOVO]
		params.addValue("FLG_TACITO_RINNOVO", dto.getFlgTacitoRinnovo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_CARICAMENTO]
		params.addValue("DATA_CARICAMENTO", dto.getDataCaricamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_CESSAZIONE]
		params.addValue("DATA_CESSAZIONE", dto.getDataCessazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO_CESSAZIONE]
		params.addValue("DATA_INSERIMENTO_CESSAZIONE", dto.getDataInserimentoCessazione(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [MOTIVO_CESSAZIONE]
		params.addValue("MOTIVO_CESSAZIONE", dto.getMotivoCessazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_TIPO_CESSAZIONE]
		params.addValue("FK_TIPO_CESSAZIONE", dto.getFkTipoCessazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdContratto(newKey);
		LOG.debug("[SigitTContratto2019DaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the SIGIT_T_CONTRATTO_2019 table.
	 * @generated
	 */
	public void updateColumnsPerRevoca(SigitTContratto2019Dto dto) throws SigitTContratto2019DaoException {
		LOG.debug("[SigitTContratto2019DaoImpl::updateColumnsPerRevoca] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DATA_CESSAZIONE = :DATA_CESSAZIONE ,DATA_INSERIMENTO_CESSAZIONE = :DATA_INSERIMENTO_CESSAZIONE ,MOTIVO_CESSAZIONE = :MOTIVO_CESSAZIONE ,FK_TIPO_CESSAZIONE = :FK_TIPO_CESSAZIONE ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD  WHERE ID_CONTRATTO = :ID_CONTRATTO ";

		if (dto.getIdContratto() == null) {
			LOG.error("[SigitTContratto2019DaoImpl::updateColumnsPerRevoca] ERROR chiave primaria non impostata");
			throw new SigitTContratto2019DaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DATA_CESSAZIONE]
		params.addValue("DATA_CESSAZIONE", dto.getDataCessazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO_CESSAZIONE]
		params.addValue("DATA_INSERIMENTO_CESSAZIONE", dto.getDataInserimentoCessazione(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [MOTIVO_CESSAZIONE]
		params.addValue("MOTIVO_CESSAZIONE", dto.getMotivoCessazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_TIPO_CESSAZIONE]
		params.addValue("FK_TIPO_CESSAZIONE", dto.getFkTipoCessazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_CONTRATTO]
		params.addValue("ID_CONTRATTO", dto.getIdContratto(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTContratto2019DaoImpl::updateColumnsPerRevoca] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_CONTRATTO_2019 table.
	 * @generated
	 */
	public void updateColumnsPerProroga(SigitTContratto2019Dto dto) throws SigitTContratto2019DaoException {
		LOG.debug("[SigitTContratto2019DaoImpl::updateColumnsPerProroga] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FLG_TACITO_RINNOVO = :FLG_TACITO_RINNOVO ,DATA_FINE = :DATA_FINE  WHERE ID_CONTRATTO = :ID_CONTRATTO ";

		if (dto.getIdContratto() == null) {
			LOG.error("[SigitTContratto2019DaoImpl::updateColumnsPerProroga] ERROR chiave primaria non impostata");
			throw new SigitTContratto2019DaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FLG_TACITO_RINNOVO]
		params.addValue("FLG_TACITO_RINNOVO", dto.getFlgTacitoRinnovo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [ID_CONTRATTO]
		params.addValue("ID_CONTRATTO", dto.getIdContratto(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTContratto2019DaoImpl::updateColumnsPerProroga] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_CONTRATTO_2019 table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTContratto2019DaoException {
		LOG.debug("[SigitTContratto2019DaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R1628352222) ENABLED START*/
		final StringBuilder sql = new StringBuilder("DELETE FROM " + getTableName() + " WHERE ");

		sql.append(" CODICE_IMPIANTO = :codImpianto");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTContratto2019DaoImpl::customDeleterByCodImpianto] END");
	}

	protected SigitTContratto2019DaoRowMapper findByPrimaryKeyRowMapper = new SigitTContratto2019DaoRowMapper(null,
			SigitTContratto2019Dto.class, this);

	protected SigitTContratto2019DaoRowMapper byFilterRowMapper = new SigitTContratto2019DaoRowMapper(null,
			SigitTContratto2019Dto.class, this);

	protected SigitTContratto2019DaoRowMapper byId3ResponsabileRowMapper = new SigitTContratto2019DaoRowMapper(null,
			SigitTContratto2019Dto.class, this);

	protected SigitTContratto2019DaoRowMapper byIdResponsabileRowMapper = new SigitTContratto2019DaoRowMapper(null,
			SigitTContratto2019Dto.class, this);

	protected SigitTContratto2019DaoRowMapper byCodImpSysdateRowMapper = new SigitTContratto2019DaoRowMapper(null,
			SigitTContratto2019Dto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_CONTRATTO_2019";
	}

	/** 
	 * Returns all rows from the SIGIT_T_CONTRATTO_2019 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTContratto2019Dto findByPrimaryKey(SigitTContratto2019Pk pk) throws SigitTContratto2019DaoException {
		LOG.debug("[SigitTContratto2019DaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_CONTRATTO,FK_PG_3_RESP,FK_IMP_RUOLO_PFPG_RESP,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FLG_TACITO_RINNOVO,DATA_CARICAMENTO,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_CESSAZIONE,DATA_INSERIMENTO_CESSAZIONE,MOTIVO_CESSAZIONE,FK_TIPO_CESSAZIONE,NOTE FROM "
						+ getTableName() + " WHERE ID_CONTRATTO = :ID_CONTRATTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONTRATTO]
		params.addValue("ID_CONTRATTO", pk.getIdContratto(), java.sql.Types.NUMERIC);

		List<SigitTContratto2019Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTContratto2019DaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTContratto2019DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTContratto2019DaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTContratto2019DaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTContratto2019Dto> findByFilter(ContrattoFilter input)
			throws SigitTContratto2019DaoException {
		LOG.debug("[SigitTContratto2019DaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R524325321) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_CONTRATTO,FK_PG_3_RESP,FK_IMP_RUOLO_PFPG_RESP,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FLG_TACITO_RINNOVO,DATA_CARICAMENTO,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_CESSAZIONE,DATA_INSERIMENTO_CESSAZIONE,MOTIVO_CESSAZIONE,FK_TIPO_CESSAZIONE,NOTE ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1334968987) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_CONTRATTO_2019");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1782998593) ENABLED START*/
		sql.append(" 1 = 1 ");
		sql.append(" AND CODICE_IMPIANTO = :codImpianto");

		if (input.getIdPersonaGiuridica3Responsabile() != null) {
			sql.append(" AND FK_PG_3_RESP = :fkPg3Resp");
		}

		if (input.getDataDal() != null) {
			sql.append(" AND DATA_INIZIO <= :dataDal");
		}

		if (input.getDataAl() != null) {
			sql.append(
					" AND ((COALESCE(FLG_TACITO_RINNOVO, 0) = 1 AND DATA_CESSAZIONE IS NULL) OR (COALESCE(DATA_CESSAZIONE, DATA_FINE) >= :dataAl))");
		}

		sql.append(" ORDER BY data_inizio DESC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1442182243) ENABLED START*/

		paramMap.addValue("codImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);

		if (input.getIdPersonaGiuridica3Responsabile() != null) {
			paramMap.addValue("fkPg3Resp", input.getIdPersonaGiuridica3Responsabile());
		}

		if (input.getDataDal() != null) {
			paramMap.addValue("dataDal", input.getDataDal());
		}

		if (input.getDataAl() != null) {
			paramMap.addValue("dataAl", input.getDataAl());
		}

		/*PROTECTED REGION END*/
		List<SigitTContratto2019Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTContratto2019DaoImpl::findByFilter] esecuzione query", ex);
			throw new SigitTContratto2019DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTContratto2019DaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitTContratto2019DaoImpl::findByFilter] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byId3Responsabile
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTContratto2019Dto> findById3Responsabile(BigDecimal input)
			throws SigitTContratto2019DaoException {
		LOG.debug("[SigitTContratto2019DaoImpl::findById3Responsabile] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R1696771678) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_CONTRATTO,FK_PG_3_RESP,FK_IMP_RUOLO_PFPG_RESP,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FLG_TACITO_RINNOVO,DATA_CARICAMENTO,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_CESSAZIONE,DATA_INSERIMENTO_CESSAZIONE,MOTIVO_CESSAZIONE,FK_TIPO_CESSAZIONE,NOTE ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1962131344) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_CONTRATTO_2019");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-913893750) ENABLED START*/
		sql.append("FK_PG_3_RESP = :input");

		sql.append(" AND ( FLG_TACITO_RINNOVO = 1 OR DATA_FINE > :oggi )");

		/*PROTECTED REGION END*/

		sql.append(" ORDER BY DATA_INIZIO ASC"); /*PROTECTED REGION ID(R-1680338696) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("input", input);
		paramMap.addValue("oggi", DateUtil.getSqlCurrentDate());

		/*PROTECTED REGION END*/
		List<SigitTContratto2019Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byId3ResponsabileRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTContratto2019DaoImpl::findById3Responsabile] esecuzione query", ex);
			throw new SigitTContratto2019DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTContratto2019DaoImpl", "findById3Responsabile", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTContratto2019DaoImpl::findById3Responsabile] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byIdResponsabile
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTContratto2019Dto> findByIdResponsabile(PersonaRuoloFilter input)
			throws SigitTContratto2019DaoException {
		LOG.debug("[SigitTContratto2019DaoImpl::findByIdResponsabile] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-1345403959) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_CONTRATTO,FK_PG_3_RESP,FK_IMP_RUOLO_PFPG_RESP,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FLG_TACITO_RINNOVO,DATA_CARICAMENTO,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_CESSAZIONE,DATA_INSERIMENTO_CESSAZIONE,MOTIVO_CESSAZIONE,FK_TIPO_CESSAZIONE,NOTE ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1308314469) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_CONTRATTO_2019");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-2120407105) ENABLED START*/
		sql.append(" 1 = 1 ");

		if (GenericUtil.isNotNullOrEmpty(input.getIdResponsabile())) {
			sql.append(" AND FK_IMP_RUOLO_PFPG_RESP = :idResponsabile ");

		}
		/*
		else if (GenericUtil.isNotNullOrEmpty(input.getIdPersonaGiuridica())) {
			sql.append(" AND FK_PG_RESPONSABILE = :idPersonaG ");
		}
		 */

		if (input.getCodiceImpianto() != null) {
			sql.append(" AND CODICE_IMPIANTO = :codImpianto ");
		}

		/*PROTECTED REGION END*/

		sql.append(" ORDER BY DATA_INIZIO ASC"); /*PROTECTED REGION ID(R-427547037) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (GenericUtil.isNotNullOrEmpty(input.getIdResponsabile())) {
			paramMap.addValue("idResponsabile", input.getIdResponsabile());
		}
		/*
		if (GenericUtil.isNotNullOrEmpty(input.getIdPersonaFisica())) {
			paramMap.addValue("idPersonaF", input.getIdPersonaFisica());
		} else if (GenericUtil.isNotNullOrEmpty(input.getIdPersonaGiuridica())) {
			paramMap.addValue("idPersonaG", input.getIdPersonaGiuridica());
		}
		*/

		if (input.getCodiceImpianto() != null) {
			paramMap.addValue("codImpianto", input.getCodiceImpianto());
		}

		/*PROTECTED REGION END*/
		List<SigitTContratto2019Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdResponsabileRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTContratto2019DaoImpl::findByIdResponsabile] esecuzione query", ex);
			throw new SigitTContratto2019DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTContratto2019DaoImpl", "findByIdResponsabile", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTContratto2019DaoImpl::findByIdResponsabile] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodImpSysdate
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTContratto2019Dto> findByCodImpSysdate(BigDecimal input)
			throws SigitTContratto2019DaoException {
		LOG.debug("[SigitTContratto2019DaoImpl::findByCodImpSysdate] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_CONTRATTO,FK_PG_3_RESP,FK_IMP_RUOLO_PFPG_RESP,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FLG_TACITO_RINNOVO,DATA_CARICAMENTO,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_CESSAZIONE,DATA_INSERIMENTO_CESSAZIONE,MOTIVO_CESSAZIONE,FK_TIPO_CESSAZIONE,NOTE ");
		sql.append(" FROM SIGIT_T_CONTRATTO_2019");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1757696356) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_IMPIANTO = :codImpianto ");
		sql.append(" AND DATA_INIZIO = CURRENT_DATE");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-2068415706) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitTContratto2019Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpSysdateRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTContratto2019DaoImpl::findByCodImpSysdate] esecuzione query", ex);
			throw new SigitTContratto2019DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTContratto2019DaoImpl", "findByCodImpSysdate", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTContratto2019DaoImpl::findByCodImpSysdate] END");
		}
		return list;
	}

}
