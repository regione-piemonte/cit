package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.impl;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.mapper.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import it.csi.sigit.sigitbatchn.business.dao.impl.*;
import it.csi.sigit.sigitbatchn.business.dao.util.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R1212608019) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTLibretto.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - byLibrettoFilter (datagen::CustomFinder)
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 *   - storicizzaByCodImpianto (datagen::CustomUpdater)
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTLibrettoDaoImpl extends AbstractDAO implements SigitTLibrettoDao {
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
	 * Metodo di inserimento del DAO sigitTLibretto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTLibrettoPk
	 * @generated
	 */

	public SigitTLibrettoPk insert(SigitTLibrettoDto dto)

	{
		LOG.debug("[SigitTLibrettoDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_LIBRETTO,FK_STATO,FK_MOTIVO_CONSOLID,FK_TIPO_DOCUMENTO,DATA_CONSOLIDAMENTO,FILE_INDEX,UID_INDEX,CF_REDATTORE,FLG_CONTROLLO_BOZZA,DATA_ULT_MOD,UTENTE_ULT_MOD,CODICE_IMPIANTO ) VALUES (  :ID_LIBRETTO , :FK_STATO , :FK_MOTIVO_CONSOLID , :FK_TIPO_DOCUMENTO , :DATA_CONSOLIDAMENTO , :FILE_INDEX , :UID_INDEX , :CF_REDATTORE , :FLG_CONTROLLO_BOZZA , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :CODICE_IMPIANTO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LIBRETTO]
		params.addValue("ID_LIBRETTO", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_STATO]
		params.addValue("FK_STATO", dto.getFkStato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_MOTIVO_CONSOLID]
		params.addValue("FK_MOTIVO_CONSOLID", dto.getFkMotivoConsolid(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_DOCUMENTO]
		params.addValue("FK_TIPO_DOCUMENTO", dto.getFkTipoDocumento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_CONSOLIDAMENTO]
		params.addValue("DATA_CONSOLIDAMENTO", dto.getDataConsolidamento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FILE_INDEX]
		params.addValue("FILE_INDEX", dto.getFileIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX]
		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CF_REDATTORE]
		params.addValue("CF_REDATTORE", dto.getCfRedattore(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_CONTROLLO_BOZZA]
		params.addValue("FLG_CONTROLLO_BOZZA", dto.getFlgControlloBozza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdLibretto(newKey);
		LOG.debug("[SigitTLibrettoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Custom updater in the SIGIT_T_LIBRETTO table.
	 * @generated
	 */
	public void customUpdaterStoricizzaByCodImpianto(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTLibrettoDto filter, java.lang.Object value)
			throws SigitTLibrettoDaoException {
		LOG.debug("[SigitTLibrettoDaoImpl::customUpdaterStoricizzaByCodImpianto] START");
		/*PROTECTED REGION ID(R1529020969) ENABLED START*/
		//***scrivere la custom query
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_STATO = 3 ,  data_ult_mod = :dataUltMod, utente_ult_mod =  :utenteUltMod"
				+ " WHERE CODICE_IMPIANTO = :codImpianto AND FK_STATO = 2";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter.getCodiceImpianto(), java.sql.Types.NUMERIC);
		params.addValue("dataUltMod", filter.getDataUltMod(), java.sql.Types.TIMESTAMP);
		params.addValue("utenteUltMod", filter.getUtenteUltMod(), java.sql.Types.VARCHAR);
		/*PROTECTED REGION END*/

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTLibrettoDaoImpl::customUpdaterStoricizzaByCodImpianto] END");
	}

	/** 
	 * Updates a single row in the SIGIT_T_LIBRETTO table.
	 * @generated
	 */
	public void update(SigitTLibrettoDto dto) throws SigitTLibrettoDaoException {
		LOG.debug("[SigitTLibrettoDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_STATO = :FK_STATO ,FK_MOTIVO_CONSOLID = :FK_MOTIVO_CONSOLID ,FK_TIPO_DOCUMENTO = :FK_TIPO_DOCUMENTO ,DATA_CONSOLIDAMENTO = :DATA_CONSOLIDAMENTO ,FILE_INDEX = :FILE_INDEX ,UID_INDEX = :UID_INDEX ,CF_REDATTORE = :CF_REDATTORE ,FLG_CONTROLLO_BOZZA = :FLG_CONTROLLO_BOZZA ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,CODICE_IMPIANTO = :CODICE_IMPIANTO  WHERE ID_LIBRETTO = :ID_LIBRETTO ";

		if (dto.getIdLibretto() == null) {
			LOG.error("[SigitTLibrettoDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTLibrettoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LIBRETTO]
		params.addValue("ID_LIBRETTO", dto.getIdLibretto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_STATO]
		params.addValue("FK_STATO", dto.getFkStato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_MOTIVO_CONSOLID]
		params.addValue("FK_MOTIVO_CONSOLID", dto.getFkMotivoConsolid(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_DOCUMENTO]
		params.addValue("FK_TIPO_DOCUMENTO", dto.getFkTipoDocumento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_CONSOLIDAMENTO]
		params.addValue("DATA_CONSOLIDAMENTO", dto.getDataConsolidamento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FILE_INDEX]
		params.addValue("FILE_INDEX", dto.getFileIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX]
		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CF_REDATTORE]
		params.addValue("CF_REDATTORE", dto.getCfRedattore(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_CONTROLLO_BOZZA]
		params.addValue("FLG_CONTROLLO_BOZZA", dto.getFlgControlloBozza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTLibrettoDaoImpl::update] END");
	}

	protected SigitTLibrettoDaoRowMapper byLibrettoFilterRowMapper = new SigitTLibrettoDaoRowMapper(null,
			SigitTLibrettoDto.class, this);

	protected SigitTLibrettoDaoRowMapper findByPrimaryKeyRowMapper = new SigitTLibrettoDaoRowMapper(null,
			SigitTLibrettoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_LIBRETTO";
	}

	/** 
	 * Implementazione del finder byLibrettoFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTLibrettoDto> findByLibrettoFilter(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter.LibrettoFilter input)
			throws SigitTLibrettoDaoException {
		LOG.debug("[SigitTLibrettoDaoImpl::findByLibrettoFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_LIBRETTO,FK_STATO,FK_MOTIVO_CONSOLID,FK_TIPO_DOCUMENTO,DATA_CONSOLIDAMENTO,FILE_INDEX,UID_INDEX,CF_REDATTORE,FLG_CONTROLLO_BOZZA,DATA_ULT_MOD,UTENTE_ULT_MOD,CODICE_IMPIANTO ");
		sql.append(" FROM SIGIT_T_LIBRETTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1814504691) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND FK_STATO = :idStato");

		sql.append(" ORDER BY DATA_CONSOLIDAMENTO desc ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-290184323) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodiceImpianto());
		paramMap.addValue("idStato", input.getIdStatoLibretto());

		/*PROTECTED REGION END*/
		List<SigitTLibrettoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byLibrettoFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTLibrettoDaoImpl::findByLibrettoFilter] esecuzione query", ex);
			throw new SigitTLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTLibrettoDaoImpl", "findByLibrettoFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitTLibrettoDaoImpl::findByLibrettoFilter] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_T_LIBRETTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTLibrettoDto findByPrimaryKey(SigitTLibrettoPk pk) throws SigitTLibrettoDaoException {
		LOG.debug("[SigitTLibrettoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_LIBRETTO,FK_STATO,FK_MOTIVO_CONSOLID,FK_TIPO_DOCUMENTO,DATA_CONSOLIDAMENTO,FILE_INDEX,UID_INDEX,CF_REDATTORE,FLG_CONTROLLO_BOZZA,DATA_ULT_MOD,UTENTE_ULT_MOD,CODICE_IMPIANTO FROM "
						+ getTableName() + " WHERE ID_LIBRETTO = :ID_LIBRETTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LIBRETTO]
		params.addValue("ID_LIBRETTO", pk.getIdLibretto(), java.sql.Types.NUMERIC);

		List<SigitTLibrettoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTLibrettoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTLibrettoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTLibrettoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTLibrettoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
