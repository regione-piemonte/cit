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

/*PROTECTED REGION ID(R788523463) ENABLED START*/
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVCompGfDett.
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
public class SigitVCompGfDettDaoImpl extends AbstractDAO implements SigitVCompGfDettDao {
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

	protected SigitVCompGfDettDaoRowMapper byCodImpiantoOrderedRowMapper = new SigitVCompGfDettDaoRowMapper(null,
			SigitVCompGfDettDto.class, this);

	protected SigitVCompGfDettDaoRowMapper byCodImpProgrAllegatoOrderedRowMapper = new SigitVCompGfDettDaoRowMapper(
			null, SigitVCompGfDettDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_COMP_GF_DETT";
	}

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompGfDettDto> findByCodImpiantoOrdered(Integer input) throws SigitVCompGfDettDaoException {
		LOG.debug("[SigitVCompGfDettDaoImpl::findByCodImpiantoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,ID_DETT_TIPO2,FK_ALLEGATO,E_N_CIRCUITO,E_FLG_MOD_PROVA,E_FLG_PERDITA_GAS,E_FLG_LEAK_DETECTOR,E_FLG_PARAM_TERMODINAM,E_FLG_INCROSTAZIONI,E_T_SURRISC_C,E_T_SOTTORAF_C,E_T_CONDENSAZIONE_C,E_T_EVAPORAZIONE_C,E_T_IN_EXT_C,E_T_OUT_EXT_C,E_T_IN_UTENZE_C,E_T_OUT_UTENZE_C,DATA_ULT_MOD_DETT,UTENTE_ULT_MOD_DETT,DATA_CONTROLLO,L11_2_TORRE_T_OUT_FLUIDO,L11_2_TORRE_T_BULBO_UMIDO,L11_2_SCAMBIATORE_T_IN_EXT,L11_2_SCAMBIATORE_T_OUT_EXT,L11_2_SCAMBIAT_T_IN_MACCHINA,L11_2_SCAMBIAT_T_OUT_MACCHINA,L11_2_POTENZA_ASSORBITA_KW,L11_2_FLG_PULIZIA_FILTRI,L11_2_FLG_VERIFICA_SUPERATA,L11_2_DATA_RIPRISTINO,SIGLA_REA,NUMERO_REA,ID_PERSONA_GIURIDICA,FK_RUOLO,FK_STATO_RAPP ");
		sql.append(" FROM VISTA_COMP_GF_DETT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R386921636) ENABLED START*/

		sql.append("CODICE_IMPIANTO = :codImpianto");
		sql.append(" ORDER BY PROGRESSIVO ASC, DATA_INSTALL DESC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-9767394) ENABLED START*/

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVCompGfDettDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpiantoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVCompGfDettDaoImpl::findByCodImpiantoOrdered] esecuzione query", ex);
			throw new SigitVCompGfDettDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVCompGfDettDaoImpl", "findByCodImpiantoOrdered", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVCompGfDettDaoImpl::findByCodImpiantoOrdered] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodImpProgrAllegatoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompGfDettDto> findByCodImpProgrAllegatoOrdered(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitVCompGfDettDaoException {
		LOG.debug("[SigitVCompGfDettDaoImpl::findByCodImpProgrAllegatoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,ID_DETT_TIPO2,FK_ALLEGATO,E_N_CIRCUITO,E_FLG_MOD_PROVA,E_FLG_PERDITA_GAS,E_FLG_LEAK_DETECTOR,E_FLG_PARAM_TERMODINAM,E_FLG_INCROSTAZIONI,E_T_SURRISC_C,E_T_SOTTORAF_C,E_T_CONDENSAZIONE_C,E_T_EVAPORAZIONE_C,E_T_IN_EXT_C,E_T_OUT_EXT_C,E_T_IN_UTENZE_C,E_T_OUT_UTENZE_C,DATA_ULT_MOD_DETT,UTENTE_ULT_MOD_DETT,DATA_CONTROLLO,L11_2_TORRE_T_OUT_FLUIDO,L11_2_TORRE_T_BULBO_UMIDO,L11_2_SCAMBIATORE_T_IN_EXT,L11_2_SCAMBIATORE_T_OUT_EXT,L11_2_SCAMBIAT_T_IN_MACCHINA,L11_2_SCAMBIAT_T_OUT_MACCHINA,L11_2_POTENZA_ASSORBITA_KW,L11_2_FLG_PULIZIA_FILTRI,L11_2_FLG_VERIFICA_SUPERATA,L11_2_DATA_RIPRISTINO,SIGLA_REA,NUMERO_REA,ID_PERSONA_GIURIDICA,FK_RUOLO,FK_STATO_RAPP ");
		sql.append(" FROM VISTA_COMP_GF_DETT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1679179748) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND PROGRESSIVO = :progressivo");
		sql.append(" AND FK_ALLEGATO = :idAllegato");
		sql.append(" ORDER BY DATA_INSTALL DESC, DATA_CONTROLLO DESC, TO_NUMBER(E_N_CIRCUITO) ASC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1395528414) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);
		paramMap.addValue("idAllegato", input.getIdAllegato(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVCompGfDettDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpProgrAllegatoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVCompGfDettDaoImpl::findByCodImpProgrAllegatoOrdered] esecuzione query", ex);
			throw new SigitVCompGfDettDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVCompGfDettDaoImpl", "findByCodImpProgrAllegatoOrdered", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVCompGfDettDaoImpl::findByCodImpProgrAllegatoOrdered] END");
		}
		return list;
	}

}
