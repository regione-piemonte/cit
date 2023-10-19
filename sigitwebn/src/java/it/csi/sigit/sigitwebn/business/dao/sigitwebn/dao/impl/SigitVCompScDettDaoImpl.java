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

/*PROTECTED REGION ID(R-38523031) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVCompScDett.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byCodImpiantoOrdered (datagen::CustomFinder)
 *   - byCodImpProgrAllegatoOrdered (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitVCompScDettDaoImpl extends AbstractDAO implements SigitVCompScDettDao {
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

	protected SigitVCompScDettDaoRowMapper byCodImpiantoOrderedRowMapper = new SigitVCompScDettDaoRowMapper(null,
			SigitVCompScDettDto.class, this);

	protected SigitVCompScDettDaoRowMapper byCodImpProgrAllegatoOrderedRowMapper = new SigitVCompScDettDaoRowMapper(
			null, SigitVCompScDettDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_COMP_SC_DETT";
	}

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompScDettDto> findByCodImpiantoOrdered(Integer input) throws SigitVCompScDettDaoException {
		LOG.debug("[SigitVCompScDettDaoImpl::findByCodImpiantoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,FK_ALLEGATO,FK_FLUIDO,FK_FLUIDO_ALIMENTAZ,E_FLUIDO_ALTRO,E_ALIMENTAZIONE_ALTRO,E_FLG_CLIMA_INVERNO,E_FLG_PRODUZ_ACS,E_FLG_POTENZA_COMPATIBILE,E_FLG_COIB_IDONEA,E_FLG_DISP_FUNZIONANTI,E_TEMP_EXT_C,E_TEMP_MAND_PRIMARIO_C,E_TEMP_RITOR_PRIMARIO_C,E_TEMP_MAND_SECONDARIO_C,E_TEMP_RIT_SECONDARIO_C,E_POTENZA_TERM_KW,E_PORT_FLUIDO_M3_H,DATA_ULT_MOD_DETT,UTENTE_ULT_MOD_DETT,DATA_CONTROLLO,SIGLA_REA,NUMERO_REA,ID_PERSONA_GIURIDICA,FK_RUOLO,FK_STATO_RAPP ");
		sql.append(" FROM VISTA_COMP_SC_DETT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-121089899) ENABLED START*/

		sql.append("CODICE_IMPIANTO = :codImpianto");
		sql.append(" ORDER BY PROGRESSIVO ASC, DATA_INSTALL DESC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1421744205) ENABLED START*/

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVCompScDettDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpiantoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVCompScDettDaoImpl::findByCodImpiantoOrdered] esecuzione query", ex);
			throw new SigitVCompScDettDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVCompScDettDaoImpl", "findByCodImpiantoOrdered", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVCompScDettDaoImpl::findByCodImpiantoOrdered] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodImpProgrAllegatoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompScDettDto> findByCodImpProgrAllegatoOrdered(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitVCompScDettDaoException {
		LOG.debug("[SigitVCompScDettDaoImpl::findByCodImpProgrAllegatoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,FK_ALLEGATO,FK_FLUIDO,FK_FLUIDO_ALIMENTAZ,E_FLUIDO_ALTRO,E_ALIMENTAZIONE_ALTRO,E_FLG_CLIMA_INVERNO,E_FLG_PRODUZ_ACS,E_FLG_POTENZA_COMPATIBILE,E_FLG_COIB_IDONEA,E_FLG_DISP_FUNZIONANTI,E_TEMP_EXT_C,E_TEMP_MAND_PRIMARIO_C,E_TEMP_RITOR_PRIMARIO_C,E_TEMP_MAND_SECONDARIO_C,E_TEMP_RIT_SECONDARIO_C,E_POTENZA_TERM_KW,E_PORT_FLUIDO_M3_H,DATA_ULT_MOD_DETT,UTENTE_ULT_MOD_DETT,DATA_CONTROLLO,SIGLA_REA,NUMERO_REA,ID_PERSONA_GIURIDICA,FK_RUOLO,FK_STATO_RAPP ");
		sql.append(" FROM VISTA_COMP_SC_DETT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-173008171) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND PROGRESSIVO = :progressivo");
		sql.append(" AND FK_ALLEGATO = :idAllegato");
		sql.append(" ORDER BY DATA_INSTALL DESC, DATA_CONTROLLO DESC ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-187722227) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);
		paramMap.addValue("idAllegato", input.getIdAllegato(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVCompScDettDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpProgrAllegatoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVCompScDettDaoImpl::findByCodImpProgrAllegatoOrdered] esecuzione query", ex);
			throw new SigitVCompScDettDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVCompScDettDaoImpl", "findByCodImpProgrAllegatoOrdered", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVCompScDettDaoImpl::findByCodImpProgrAllegatoOrdered] END");
		}
		return list;
	}

}
