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

/*PROTECTED REGION ID(R-1740495007) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVCompGt.
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
public class SigitVCompGtDaoImpl extends AbstractDAO implements SigitVCompGtDao {
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

	protected SigitVCompGtDaoRowMapper byCodImpiantoOrderedRowMapper = new SigitVCompGtDaoRowMapper(null,
			SigitVCompGtDto.class, this);

	protected SigitVCompGtDaoRowMapper byIdAllegatoOrderedRowMapper = new SigitVCompGtDaoRowMapper(null,
			SigitVCompGtDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_COMP_GT";
	}

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompGtDto> findByCodImpiantoOrdered(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitVCompGtDaoException {
		LOG.debug("[SigitVCompGtDaoImpl::findByCodImpiantoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R1711847671) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,DATA_DISMISS,MATRICOLA,FK_MARCA,DES_MARCA,ID_COMBUSTIBILE,DES_COMBUSTIBILE,FK_FLUIDO,DES_FLUIDO,FK_DETTAGLIO_GT,DES_DETTAGLIO_GT,MODELLO,POTENZA_TERMICA_KW,DATA_ULT_MOD,UTENTE_ULT_MOD,RENDIMENTO_PERC,N_MODULI,FLG_DISMISSIONE ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-554295991) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM VISTA_COMP_GT");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-220670767) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("CODICE_IMPIANTO = :codImpianto");

		//sql.append(" AND DATA_INSTALL = :dataInstallazione");

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
		/*PROTECTED REGION ID(R-1665262703) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("dataInstallazione", input.getDataInstallazione(), java.sql.Types.DATE);

		LOG.debug("findByCodImpiantoOrdered - QUERY: codImpianto: " + input.getCodImpianto());
		LOG.debug("findByCodImpiantoOrdered - QUERY: dataInstallazione: " + input.getDataInstallazione());

		/*PROTECTED REGION END*/
		List<SigitVCompGtDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodImpiantoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVCompGtDaoImpl::findByCodImpiantoOrdered] esecuzione query", ex);
			throw new SigitVCompGtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVCompGtDaoImpl", "findByCodImpiantoOrdered", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVCompGtDaoImpl::findByCodImpiantoOrdered] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byIdAllegatoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVCompGtDto> findByIdAllegatoOrdered(java.lang.Integer input) throws SigitVCompGtDaoException {
		LOG.debug("[SigitVCompGtDaoImpl::findByIdAllegatoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-1365602540) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT v.CODICE_IMPIANTO,v.ID_TIPO_COMPONENTE,v.PROGRESSIVO,v.DATA_INSTALL,DATA_DISMISS,MATRICOLA,FK_MARCA,DES_MARCA,ID_COMBUSTIBILE,DES_COMBUSTIBILE,FK_FLUIDO,DES_FLUIDO,FK_DETTAGLIO_GT,DES_DETTAGLIO_GT,MODELLO,POTENZA_TERMICA_KW,DATA_ULT_MOD,UTENTE_ULT_MOD,RENDIMENTO_PERC,N_MODULI,FLG_DISMISSIONE ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-749676890) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM VISTA_COMP_GT v, SIGIT_R_ALLEGATO_COMP_GT t");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1982511340) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		sql.append(" v.CODICE_IMPIANTO = t.CODICE_IMPIANTO ");
		sql.append(" AND v.ID_TIPO_COMPONENTE = t.ID_TIPO_COMPONENTE ");
		sql.append(" AND v.PROGRESSIVO = t.PROGRESSIVO  ");
		sql.append(" AND v.DATA_INSTALL = t.DATA_INSTALL ");

		sql.append(" AND t.ID_ALLEGATO = :idAllegato ");

		sql.append(" ORDER BY PROGRESSIVO ASC ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-447745618) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idAllegato", input);

		/*PROTECTED REGION END*/
		List<SigitVCompGtDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAllegatoOrderedRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVCompGtDaoImpl::findByIdAllegatoOrdered] esecuzione query", ex);
			throw new SigitVCompGtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVCompGtDaoImpl", "findByIdAllegatoOrdered", "esecuzione query", sql.toString());
			LOG.debug("[SigitVCompGtDaoImpl::findByIdAllegatoOrdered] END");
		}
		return list;
	}

}
