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

/*PROTECTED REGION ID(R768784483) ENABLED START*/
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVCompGtDett.
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
public class SigitVCompGtDettDaoImpl extends AbstractDAO implements SigitVCompGtDettDao {
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

	protected SigitVCompGtDettDaoRowMapper byCodImpiantoOrderedRowMapper = new SigitVCompGtDettDaoRowMapper(null,
			SigitVCompGtDettDto.class, this);

	protected SigitVCompGtDettDaoRowMapper byCodImpProgrAllegatoOrderedRowMapper = new SigitVCompGtDettDaoRowMapper(
			null, SigitVCompGtDettDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_COMP_GT_DETT";
	}

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompGtDettDto> findByCodImpiantoOrdered(Integer input) throws SigitVCompGtDettDaoException {
		LOG.debug("[SigitVCompGtDettDaoImpl::findByCodImpiantoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,ID_DETT_TIPO1,FK_ALLEGATO,E_N_MODULO_TERMICO,E_POT_TERM_FOCOL_KW,E_FLG_CLIMA_INVERNO,E_FLG_PRODUZ_ACS,E_FLG_DISPOS_COMANDO,E_FLG_DISPOS_SICUREZZA,E_FLG_VALVOLA_SICUREZZA,E_FLG_SCAMBIATORE_FUMI,E_FLG_RIFLUSSO,E_FLG_UNI_10389_1,E_FLG_EVACU_FUMI,E_DEPR_CANALE_FUMO_PA,E_TEMP_FUMI_C,E_TEMP_ARIA_C,E_O2_PERC,E_CO2_PERC,E_BACHARACH_MIN,E_BACHARACH_MED,E_BACHARACH_MAX,E_CO_CORRETTO_PPM,E_REND_COMB_PERC,E_REND_MIN_LEGGE_PERC,E_NOX_PPM,E_NOX_MG_KWH,DATA_ULT_MOD_DETT,UTENTE_ULT_MOD_DETT,DATA_CONTROLLO,L11_1_PORTATA_COMBUSTIBILE,L11_1_PORTATA_COMBUSTIBILE_UM,L11_1_ALTRO_RIFERIMENTO,L11_1_CO_NO_ARIA_PPM,L11_1_FLG_RISPETTA_BACHARACH,L11_1_FLG_CO_MIN_1000,L11_1_FLG_REND_MAG_REND_MIN,SIGLA_REA,NUMERO_REA,ID_PERSONA_GIURIDICA,FK_RUOLO,FK_STATO_RAPP,E_NOX_MG_NM3 ");
		sql.append(" FROM VISTA_COMP_GT_DETT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1948608590) ENABLED START*/

		sql.append("CODICE_IMPIANTO = :codImpianto");
		sql.append(" ORDER BY PROGRESSIVO ASC, DATA_INSTALL DESC, DATA_CONTROLLO DESC, E_N_MODULO_TERMICO ASC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R603239632) ENABLED START*/

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVCompGtDettDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpiantoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVCompGtDettDaoImpl::findByCodImpiantoOrdered] esecuzione query", ex);
			throw new SigitVCompGtDettDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVCompGtDettDaoImpl", "findByCodImpiantoOrdered", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVCompGtDettDaoImpl::findByCodImpiantoOrdered] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodImpProgrAllegatoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompGtDettDto> findByCodImpProgrAllegatoOrdered(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitVCompGtDettDaoException {
		LOG.debug("[SigitVCompGtDettDaoImpl::findByCodImpProgrAllegatoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,ID_DETT_TIPO1,FK_ALLEGATO,E_N_MODULO_TERMICO,E_POT_TERM_FOCOL_KW,E_FLG_CLIMA_INVERNO,E_FLG_PRODUZ_ACS,E_FLG_DISPOS_COMANDO,E_FLG_DISPOS_SICUREZZA,E_FLG_VALVOLA_SICUREZZA,E_FLG_SCAMBIATORE_FUMI,E_FLG_RIFLUSSO,E_FLG_UNI_10389_1,E_FLG_EVACU_FUMI,E_DEPR_CANALE_FUMO_PA,E_TEMP_FUMI_C,E_TEMP_ARIA_C,E_O2_PERC,E_CO2_PERC,E_BACHARACH_MIN,E_BACHARACH_MED,E_BACHARACH_MAX,E_CO_CORRETTO_PPM,E_REND_COMB_PERC,E_REND_MIN_LEGGE_PERC,E_NOX_PPM,E_NOX_MG_KWH,DATA_ULT_MOD_DETT,UTENTE_ULT_MOD_DETT,DATA_CONTROLLO,L11_1_PORTATA_COMBUSTIBILE,L11_1_PORTATA_COMBUSTIBILE_UM,L11_1_ALTRO_RIFERIMENTO,L11_1_CO_NO_ARIA_PPM,L11_1_FLG_RISPETTA_BACHARACH,L11_1_FLG_CO_MIN_1000,L11_1_FLG_REND_MAG_REND_MIN,SIGLA_REA,NUMERO_REA,ID_PERSONA_GIURIDICA,FK_RUOLO,FK_STATO_RAPP,E_NOX_MG_NM3 ");
		sql.append(" FROM VISTA_COMP_GT_DETT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R491517170) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND PROGRESSIVO = :progressivo");
		sql.append(" AND FK_ALLEGATO = :idAllegato");
		sql.append(" ORDER BY DATA_INSTALL DESC, DATA_CONTROLLO DESC, E_N_MODULO_TERMICO ASC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1062273136) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);
		paramMap.addValue("idAllegato", input.getIdAllegato(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVCompGtDettDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpProgrAllegatoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVCompGtDettDaoImpl::findByCodImpProgrAllegatoOrdered] esecuzione query", ex);
			throw new SigitVCompGtDettDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVCompGtDettDaoImpl", "findByCodImpProgrAllegatoOrdered", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVCompGtDettDaoImpl::findByCodImpProgrAllegatoOrdered] END");
		}
		return list;
	}

}
