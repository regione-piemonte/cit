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

/*PROTECTED REGION ID(R1739521039) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVCompCg.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byCodImpiantoOrdered (datagen::CustomFinder)
 *   - byIdAllegatoOrdered (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitVCompCgDaoImpl extends AbstractDAO implements SigitVCompCgDao {
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

	protected SigitVCompCgDaoRowMapper byCodImpiantoOrderedRowMapper = new SigitVCompCgDaoRowMapper(null,
			SigitVCompCgDto.class, this);

	protected SigitVCompCgDaoRowMapper byIdAllegatoOrderedRowMapper = new SigitVCompCgDaoRowMapper(null,
			SigitVCompCgDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_COMP_CG";
	}

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompCgDto> findByCodImpiantoOrdered(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitVCompCgDaoException {
		LOG.debug("[SigitVCompCgDaoImpl::findByCodImpiantoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R1893682016) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,TIPOLOGIA,POTENZA_ELETTRICA_KW,TEMP_H2O_OUT_MIN,TEMP_H2O_OUT_MAX,TEMP_H2O_IN_MIN,TEMP_H2O_IN_MAX,TEMP_H2O_MOTORE_MIN,TEMP_H2O_MOTORE_MAX,TEMP_FUMI_VALLE_MIN,TEMP_FUMI_VALLE_MAX,TEMP_FUMI_MONTE_MIN,TEMP_FUMI_MONTE_MAX,CO_MIN,CO_MAX,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,DES_MARCA,ID_COMBUSTIBILE,DES_COMBUSTIBILE,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,NOTE,TEMPO_MANUT_ANNI ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1072707058) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM VISTA_COMP_CG");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1323183800) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("CODICE_IMPIANTO = :codImpianto");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1483428358) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input.getListProgressivi() != null && !input.getListProgressivi().isEmpty()) {
			sql.append(" AND PROGRESSIVO IN  (");
			boolean aggVirg = false;
			for (String progr : input.getListProgressivi()) {
				if (aggVirg)
					sql.append(", ");
				sql.append(progr);
				aggVirg = true;
			}
			sql.append(") ");
		}

		sql.append(" ORDER BY PROGRESSIVO ASC ");

		/*PROTECTED REGION END*/
		List<SigitVCompCgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpiantoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVCompCgDaoImpl::findByCodImpiantoOrdered] esecuzione query", ex);
			throw new SigitVCompCgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVCompCgDaoImpl", "findByCodImpiantoOrdered", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVCompCgDaoImpl::findByCodImpiantoOrdered] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byIdAllegatoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompCgDto> findByIdAllegatoOrdered(java.lang.Integer input) throws SigitVCompCgDaoException {
		LOG.debug("[SigitVCompCgDaoImpl::findByIdAllegatoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R1826851723) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT v.CODICE_IMPIANTO,v.ID_TIPO_COMPONENTE,v.PROGRESSIVO,v.DATA_INSTALL,TIPOLOGIA,POTENZA_ELETTRICA_KW,TEMP_H2O_OUT_MIN,TEMP_H2O_OUT_MAX,TEMP_H2O_IN_MIN,TEMP_H2O_IN_MAX,TEMP_H2O_MOTORE_MIN,TEMP_H2O_MOTORE_MAX,TEMP_FUMI_VALLE_MIN,TEMP_FUMI_VALLE_MAX,TEMP_FUMI_MONTE_MIN,TEMP_FUMI_MONTE_MAX,CO_MIN,CO_MAX,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,DES_MARCA,ID_COMBUSTIBILE,DES_COMBUSTIBILE,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,NOTE,TEMPO_MANUT_ANNI ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1103922397) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM VISTA_COMP_CG v, SIGIT_R_ALLEGATO_COMP_CG t");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-355508291) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" v.CODICE_IMPIANTO = t.CODICE_IMPIANTO ");
		sql.append(" AND v.ID_TIPO_COMPONENTE = t.ID_TIPO_COMPONENTE ");
		sql.append(" AND v.PROGRESSIVO = t.PROGRESSIVO  ");
		sql.append(" AND v.DATA_INSTALL = t.DATA_INSTALL ");

		sql.append(" AND t.ID_ALLEGATO = :idAllegato ");

		sql.append(" ORDER BY PROGRESSIVO ASC ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1550258651) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idAllegato", input);

		/*PROTECTED REGION END*/
		List<SigitVCompCgDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAllegatoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVCompCgDaoImpl::findByIdAllegatoOrdered] esecuzione query", ex);
			throw new SigitVCompCgDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVCompCgDaoImpl", "findByIdAllegatoOrdered", "esecuzione query", sql.toString());
			LOG.debug("[SigitVCompCgDaoImpl::findByIdAllegatoOrdered] END");
		}
		return list;
	}

}
