package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitRImpRuoloPfpgDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.FiltroRicercaPfPg;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitRImpRuoloPfpgDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRImpRuoloPfpgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRImpRuoloPfpgPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRImpRuoloPfpgDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.sigit.sigitext.business.util.ConvertUtil;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R-681761483) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRImpRuoloPfpg.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - respImpAttivoByCodImpianto (datagen::CustomFinder)
 *   - byRuoloFunzPersonaGiuridicaCodImpianto (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
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

	protected SigitRImpRuoloPfpgDaoRowMapper respImpAttivoByCodImpiantoRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(
			null, SigitRImpRuoloPfpgDto.class, this);

	protected SigitRImpRuoloPfpgDaoRowMapper byRuoloFunzPersonaGiuridicaCodImpiantoRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(
			null, SigitRImpRuoloPfpgDto.class, this);

	protected SigitRImpRuoloPfpgDaoRowMapper attiviByFilterRowMapper = new SigitRImpRuoloPfpgDaoRowMapper(null,
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
	 * Implementazione del finder respImpAttivoByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findRespImpAttivoByCodImpianto(Integer input)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findRespImpAttivoByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1136823091) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" CODICE_IMPIANTO = :codImpianto");

		sql.append(" AND FK_RUOLO IN (" + Constants.ID_RUOLO_PROPRIETARIO + "," + Constants.ID_RUOLO_OCCUPANTE + ","
				+ Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO + ","
				+ Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE + ","
				+ Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE + "," + Constants.ID_RUOLO_AMMINISTRATORE
				+ ")");

		sql.append(" AND DATA_INIZIO <= CURRENT_DATE");
		sql.append(" AND COALESCE(DATA_FINE,CURRENT_DATE) >= CURRENT_DATE");

		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findRespImpAttivoByCodImpianto] query: " + sql);

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1006663703) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, respImpAttivoByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findRespImpAttivoByCodImpianto] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findRespImpAttivoByCodImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findRespImpAttivoByCodImpianto] END");
		}
		return list;
	}
	
	public List<SigitRImpRuoloPfpgDto> findRespImpByCodImpianto(Integer input) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findRespImpByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1136823091) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" CODICE_IMPIANTO = :codImpianto");

		sql.append(" AND FK_RUOLO IN (" + Constants.ID_RUOLO_PROPRIETARIO + "," + Constants.ID_RUOLO_OCCUPANTE + ","
				+ Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO + ","
				+ Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE + ","
				+ Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE + "," + Constants.ID_RUOLO_AMMINISTRATORE
				+ ")");


		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findRespImpAttivoByCodImpianto] query: " + sql);

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1006663703) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, respImpAttivoByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findRespImpByCodImpianto] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findRespImpByCodImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findRespImpByCodImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byRuoloFunzPersonaGiuridicaCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findByRuoloFunzPersonaGiuridicaCodImpianto(
			it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter input)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByRuoloFunzPersonaGiuridicaCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE ");
		/*PROTECTED REGION ID(R2136489215) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG as impRuoloPfPg, SIGIT_D_RUOLO as ruolo");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1816894995) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("impRuoloPfPg.FK_RUOLO = ruolo.ID_RUOLO");
		//sql.append(" AND impRuoloPfPg.DATA_FINE IS NULL");
        sql.append(" AND (impRuoloPfPg.DATA_FINE IS NULL OR (impRuoloPfPg.DATA_FINE is not null AND current_date >= impRuoloPfPg.DATA_INIZIO AND current_date <= impRuoloPfPg.DATA_FINE)) ");		
        sql.append(" AND impRuoloPfPg.FK_PERSONA_GIURIDICA = :idPersonaGiuridica");
		sql.append(" AND impRuoloPfPg.CODICE_IMPIANTO = :codiceImpianto");
		sql.append(" AND ruolo.RUOLO_FUNZ = :ruoloFunz");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R614056247) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idPersonaGiuridica", input.getIdPG());
		paramMap.addValue("codiceImpianto", input.getCodImpianto());
		paramMap.addValue("ruoloFunz", input.getRuoloFunz());

		/*PROTECTED REGION END*/
		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byRuoloFunzPersonaGiuridicaCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findByRuoloFunzPersonaGiuridicaCodImpianto] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findByRuoloFunzPersonaGiuridicaCodImpianto",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByRuoloFunzPersonaGiuridicaCodImpianto] END");
		}
		return list;
	}

	@Override
	public SigitRImpRuoloPfpgPk insert(SigitRImpRuoloPfpgDto dto) {
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

	public List<SigitRImpRuoloPfpgDto> findAttiviByFilter(FiltroRicercaPfPg input)
			throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findAttiviByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R279095556) ENABLED START*/

		//sql.append(" DATA_FINE IS NULL");
		sql.append(" (DATA_FINE IS NULL OR (DATA_FINE is not null AND :inData >= DATA_INIZIO AND :inData <= DATA_FINE)) ");		

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
			sql.append(" AND DATA_INIZIO <> :inData ");
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

		paramMap.addValue("inData", input.getInData(), java.sql.Types.DATE);

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
	
	
	public List<SigitRImpRuoloPfpgDto> findAttiviByCodiceImpianto(Integer codiceImpianto) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findAttiviByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG");
		sql.append(" WHERE ");
		sql.append(" DATA_FINE IS NULL OR data_fine = current_date ");	
		sql.append(" AND CODICE_IMPIANTO = :codiceImpianto");

		
		paramMap.addValue("codiceImpianto", codiceImpianto, java.sql.Types.NUMERIC);

		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attiviByFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findAttiviByCodiceImpianto] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findAttiviByCodiceImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findAttiviByCodiceImpianto] END");
		}
		return list;
	}
	
	

	public List<SigitRImpRuoloPfpgDto> findSigitRImpRuoloPfpgByCodiceImpiantoEDataFineOggiONull(Integer codiceImpianto) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findAttiviByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG");
		sql.append(" WHERE ");
		sql.append(" (DATA_FINE IS NULL OR data_fine = current_date) ");	
		sql.append(" AND CODICE_IMPIANTO = :codiceImpianto");

		
		paramMap.addValue("codiceImpianto", codiceImpianto, java.sql.Types.NUMERIC);

		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attiviByFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findAttiviByCodiceImpianto] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findAttiviByCodiceImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findAttiviByCodiceImpianto] END");
		}
		return list;
	}

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
	
	public List<SigitRImpRuoloPfpgDto> findByPrimaryKey(SigitRImpRuoloPfpgPk pk) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByPrimaryKey] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG");
		sql.append(" WHERE ID_IMP_RUOLO_PFPG = :ID_IMP_RUOLO_PFPG");

		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByPrimaryKey] query: " + sql);


		paramMap.addValue("ID_IMP_RUOLO_PFPG", pk.getIdImpRuoloPfpg());

		/*PROTECTED REGION END*/
		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, respImpAttivoByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::findByPrimaryKey] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByPrimaryKey] END");
		}
		return list;
	}
	
	public Integer checkResponsabileImpresa(Integer codiceImpianto, Integer idPersona, String ruoloFunz) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::checkResponsabileImpresa] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("select count(*) from sigit_r_imp_ruolo_pfpg, sigit_d_ruolo ");
		sql.append("where sigit_d_ruolo.id_ruolo = sigit_r_imp_ruolo_pfpg.fk_ruolo ");
		sql.append("and sigit_r_imp_ruolo_pfpg.codice_impianto = :codiceImpianto ");
		sql.append("and sigit_r_imp_ruolo_pfpg.data_fine is null ");
		sql.append("and sigit_r_imp_ruolo_pfpg.fk_persona_giuridica = :idPersona ");
		sql.append("and sigit_d_ruolo.ruolo_funz = :ruoloFunz ");

		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::checkResponsabileImpresa] query: " + sql);


		paramMap.addValue("codiceImpianto", codiceImpianto);
		paramMap.addValue("idPersona", idPersona);
		paramMap.addValue("ruoloFunz", ruoloFunz);

		/*PROTECTED REGION END*/
		Integer result = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			result = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::checkResponsabileImpresa] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "checkResponsabileImpresa", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::checkResponsabileImpresa] END");
		}
		return result;
	}
	
	/**
	 * 
	 */
	public Integer checkResponsabile(Integer codiceImpianto, String cfPersona) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::checkResponsabile] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("select count(*) from sigit_r_imp_ruolo_pfpg, sigit_d_ruolo, sigit_t_persona_fisica ");
		sql.append("where sigit_d_ruolo.id_ruolo = sigit_r_imp_ruolo_pfpg.fk_ruolo ");
		sql.append("and sigit_r_imp_ruolo_pfpg.fk_persona_fisica = sigit_t_persona_fisica.id_persona_fisica ");
		sql.append("and sigit_r_imp_ruolo_pfpg.codice_impianto = :codiceImpianto ");
		sql.append("and sigit_r_imp_ruolo_pfpg.data_fine is null and sigit_t_persona_fisica.codice_fiscale = :idPersona ");
		sql.append("and sigit_d_ruolo.ruolo_funz in ('RESPONSABILE')");

		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::checkResponsabile] query: " + sql);


		paramMap.addValue("codiceImpianto", codiceImpianto);
		paramMap.addValue("idPersona", cfPersona);

		/*PROTECTED REGION END*/
		Integer result = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			result = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::checkResponsabile] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "checkResponsabile", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::checkResponsabile] END");
		}
		return result;
	}
	
	public Integer checkProprietario(Integer codiceImpianto, String cfPersona) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::checkProprietario] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("select count(*) from sigit_r_imp_ruolo_pfpg, sigit_d_ruolo, sigit_t_persona_fisica ");
		sql.append("where sigit_d_ruolo.id_ruolo = sigit_r_imp_ruolo_pfpg.fk_ruolo ");
		sql.append("and sigit_r_imp_ruolo_pfpg.fk_persona_fisica = sigit_t_persona_fisica.id_persona_fisica ");
		sql.append("and sigit_r_imp_ruolo_pfpg.codice_impianto = :codiceImpianto ");
		sql.append("and sigit_r_imp_ruolo_pfpg.data_fine is null and sigit_t_persona_fisica.codice_fiscale = :idPersona ");
		sql.append("and sigit_d_ruolo.ruolo_funz in ('PROPRIETARIO')");

		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::checkProprietario] query: " + sql);


		paramMap.addValue("codiceImpianto", codiceImpianto);
		paramMap.addValue("idPersona", cfPersona);

		/*PROTECTED REGION END*/
		Integer result = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			result = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRImpRuoloPfpgDaoImpl::checkProprietario] esecuzione query", ex);
			throw new SigitRImpRuoloPfpgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRImpRuoloPfpgDaoImpl", "checkProprietario", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRImpRuoloPfpgDaoImpl::checkProprietario] END");
		}
		return result;
	}
	
	
	public List<SigitRImpRuoloPfpgDto> findByCodiceImpiantoAndRuolo(Integer codiceImpianto) throws SigitRImpRuoloPfpgDaoException {
		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_IMP_RUOLO_PFPG,FK_RUOLO,CODICE_IMPIANTO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG");
		sql.append(" WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO");
		sql.append(" AND FK_RUOLO IN (4, 5, 10, 11, 12, 13)");
		sql.append(" AND DATA_FINE IS NULL");

		LOG.debug("[SigitRImpRuoloPfpgDaoImpl::findByCodiceImpianto] query: " + sql);


		paramMap.addValue("CODICE_IMPIANTO", codiceImpianto);

		/*PROTECTED REGION END*/
		List<SigitRImpRuoloPfpgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, respImpAttivoByCodImpiantoRowMapper);

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

}
