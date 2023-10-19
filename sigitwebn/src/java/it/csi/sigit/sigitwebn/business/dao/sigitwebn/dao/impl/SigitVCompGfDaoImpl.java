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

/*PROTECTED REGION ID(R1938240453) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVCompGf.
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
public class SigitVCompGfDaoImpl extends AbstractDAO implements SigitVCompGfDao {
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

	protected SigitVCompGfDaoRowMapper byCodImpiantoOrderedRowMapper = new SigitVCompGfDaoRowMapper(null,
			SigitVCompGfDto.class, this);

	protected SigitVCompGfDaoRowMapper byIdAllegatoOrderedRowMapper = new SigitVCompGfDaoRowMapper(null,
			SigitVCompGfDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_COMP_GF";
	}

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompGfDto> findByCodImpiantoOrdered(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitVCompGfDaoException {
		LOG.debug("[SigitVCompGfDaoImpl::findByCodImpiantoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-25177787) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CODICE_IMPIANTO,FK_DETTAGLIO_GF,FLG_SORGENTE_EXT,FLG_FLUIDO_UTENZE,FLUIDO_FRIGORIGENO,N_CIRCUITI,RAFFRESCAMENTO_EER,RAFF_POTENZA_KW,RAFF_POTENZA_ASS,RISCALDAMENTO_COP,RISC_POTENZA_KW,RISC_POTENZA_ASS_KW,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,DES_MARCA,ID_COMBUSTIBILE,DES_COMBUSTIBILE,MATRICOLA,MODELLO,POTENZA_TERMICA_KW ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R458420503) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM VISTA_COMP_GF");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1108769475) ENABLED START*/

		sql.append("CODICE_IMPIANTO = :codImpianto");

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
		/*PROTECTED REGION ID(R892679135) ENABLED START*/

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("dataInstallazione", input.getDataInstallazione(), java.sql.Types.DATE);

		LOG.debug("findByCodImpiantoOrdered - QUERY: codImpianto: " + input.getCodImpianto());
		LOG.debug("findByCodImpiantoOrdered - QUERY: dataInstallazione: " + input.getDataInstallazione());

		/*PROTECTED REGION END*/
		List<SigitVCompGfDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpiantoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVCompGfDaoImpl::findByCodImpiantoOrdered] esecuzione query", ex);
			throw new SigitVCompGfDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVCompGfDaoImpl", "findByCodImpiantoOrdered", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVCompGfDaoImpl::findByCodImpiantoOrdered] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byIdAllegatoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompGfDto> findByIdAllegatoOrdered(java.lang.Integer input) throws SigitVCompGfDaoException {
		LOG.debug("[SigitVCompGfDaoImpl::findByIdAllegatoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-36162298) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT v.ID_TIPO_COMPONENTE,v.PROGRESSIVO,v.DATA_INSTALL,v.CODICE_IMPIANTO,FK_DETTAGLIO_GF,FLG_SORGENTE_EXT,FLG_FLUIDO_UTENZE,FLUIDO_FRIGORIGENO,N_CIRCUITI,RAFFRESCAMENTO_EER,RAFF_POTENZA_KW,RAFF_POTENZA_ASS,RISCALDAMENTO_COP,RISC_POTENZA_KW,RISC_POTENZA_ASS_KW,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,DES_MARCA,ID_COMBUSTIBILE,DES_COMBUSTIBILE,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,DES_DETTAGLIO_GF ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-717008616) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM VISTA_COMP_GF v, SIGIT_R_ALLEGATO_COMP_GF t");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-969794846) ENABLED START*/

		sql.append(" v.CODICE_IMPIANTO = t.CODICE_IMPIANTO ");
		sql.append(" AND v.ID_TIPO_COMPONENTE = t.ID_TIPO_COMPONENTE ");
		sql.append(" AND v.PROGRESSIVO = t.PROGRESSIVO  ");
		sql.append(" AND v.DATA_INSTALL = t.DATA_INSTALL ");
		sql.append(" AND t.ID_ALLEGATO = :idAllegato ");
		sql.append(" ORDER BY PROGRESSIVO ASC ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R881694624) ENABLED START*/

		paramMap.addValue("idAllegato", input);

		/*PROTECTED REGION END*/
		List<SigitVCompGfDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAllegatoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVCompGfDaoImpl::findByIdAllegatoOrdered] esecuzione query", ex);
			throw new SigitVCompGfDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVCompGfDaoImpl", "findByIdAllegatoOrdered", "esecuzione query", sql.toString());
			LOG.debug("[SigitVCompGfDaoImpl::findByIdAllegatoOrdered] END");
		}
		return list;
	}

}
