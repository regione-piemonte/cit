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

/*PROTECTED REGION ID(R1901916949) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRIspezIspet.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - byIdIspezione (datagen::CustomFinder)
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 *   - aggiornaDataFine (datagen::UpdateColumns)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRIspezIspetDaoImpl extends AbstractDAO implements SigitRIspezIspetDao {
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
	 * Metodo di inserimento del DAO sigitRIspezIspet. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRIspezIspetPk
	 * @generated
	 */

	public SigitRIspezIspetPk insert(SigitRIspezIspetDto dto)

	{
		LOG.debug("[SigitRIspezIspetDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ISPEZ_ISPET,FK_RUOLO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE,ID_ISPEZIONE_2018 ) VALUES (  :ID_ISPEZ_ISPET , :FK_RUOLO , :DATA_INIZIO , :DATA_FINE , :FK_PERSONA_FISICA , :FK_PERSONA_GIURIDICA , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :FLG_PRIMO_CARICATORE , :ID_ISPEZIONE_2018  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ISPEZ_ISPET]
		params.addValue("ID_ISPEZ_ISPET", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_RUOLO]
		params.addValue("FK_RUOLO", dto.getFkRuolo(), java.sql.Types.NUMERIC);

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

		// valorizzazione paametro relativo a colonna [ID_ISPEZIONE_2018]
		params.addValue("ID_ISPEZIONE_2018", dto.getIdIspezione2018(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdIspezIspet(newKey);
		LOG.debug("[SigitRIspezIspetDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the SIGIT_R_ISPEZ_ISPET table.
	 * @generated
	 */
	public void updateColumnsAggiornaDataFine(SigitRIspezIspetDto dto) throws SigitRIspezIspetDaoException {
		LOG.debug("[SigitRIspezIspetDaoImpl::updateColumnsAggiornaDataFine] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DATA_FINE = :DATA_FINE ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD  WHERE ID_ISPEZ_ISPET = :ID_ISPEZ_ISPET ";

		if (dto.getIdIspezIspet() == null) {
			LOG.error("[SigitRIspezIspetDaoImpl::updateColumnsAggiornaDataFine] ERROR chiave primaria non impostata");
			throw new SigitRIspezIspetDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_ISPEZ_ISPET]
		params.addValue("ID_ISPEZ_ISPET", dto.getIdIspezIspet(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRIspezIspetDaoImpl::updateColumnsAggiornaDataFine] END");
	}

	protected SigitRIspezIspetDaoRowMapper byIdIspezioneRowMapper = new SigitRIspezIspetDaoRowMapper(null,
			SigitRIspezIspetDto.class, this);

	protected SigitRIspezIspetDaoRowMapper findByPrimaryKeyRowMapper = new SigitRIspezIspetDaoRowMapper(null,
			SigitRIspezIspetDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_ISPEZ_ISPET";
	}

	/** 
	 * Implementazione del finder byIdIspezione
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRIspezIspetDto> findByIdIspezione(java.lang.Integer input) throws SigitRIspezIspetDaoException {
		LOG.debug("[SigitRIspezIspetDaoImpl::findByIdIspezione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ISPEZ_ISPET,FK_RUOLO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE,ID_ISPEZIONE_2018 ");
		sql.append(" FROM SIGIT_R_ISPEZ_ISPET");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1568072606) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("ID_ISPEZIONE_2018 = :idISpez2018");

		sql.append(" ORDER BY DATA_INIZIO DESC, ID_ISPEZ_ISPET DESC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-2048792988) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idISpez2018", input);

		/*PROTECTED REGION END*/
		List<SigitRIspezIspetDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdIspezioneRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRIspezIspetDaoImpl::findByIdIspezione] esecuzione query", ex);
			throw new SigitRIspezIspetDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRIspezIspetDaoImpl", "findByIdIspezione", "esecuzione query", sql.toString());
			LOG.debug("[SigitRIspezIspetDaoImpl::findByIdIspezione] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_R_ISPEZ_ISPET table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRIspezIspetDto findByPrimaryKey(SigitRIspezIspetPk pk) throws SigitRIspezIspetDaoException {
		LOG.debug("[SigitRIspezIspetDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ISPEZ_ISPET,FK_RUOLO,DATA_INIZIO,DATA_FINE,FK_PERSONA_FISICA,FK_PERSONA_GIURIDICA,DATA_ULT_MOD,UTENTE_ULT_MOD,FLG_PRIMO_CARICATORE,ID_ISPEZIONE_2018 FROM "
						+ getTableName() + " WHERE ID_ISPEZ_ISPET = :ID_ISPEZ_ISPET ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ISPEZ_ISPET]
		params.addValue("ID_ISPEZ_ISPET", pk.getIdIspezIspet(), java.sql.Types.NUMERIC);

		List<SigitRIspezIspetDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRIspezIspetDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitRIspezIspetDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRIspezIspetDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitRIspezIspetDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
