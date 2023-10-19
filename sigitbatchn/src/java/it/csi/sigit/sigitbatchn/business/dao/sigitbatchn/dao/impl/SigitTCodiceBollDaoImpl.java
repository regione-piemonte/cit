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

/*PROTECTED REGION ID(R-87393819) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTCodiceBoll.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byNumeroBollinoDataControllo (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTCodiceBollDaoImpl extends AbstractDAO implements SigitTCodiceBollDao {
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

	protected SigitTCodiceBollDaoRowMapper byNumeroBollinoDataControlloRowMapper = new SigitTCodiceBollDaoRowMapper(
			null, SigitTCodiceBollDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_CODICE_BOLL";
	}

	/** 
	 * Implementazione del finder byNumeroBollinoDataControllo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCodiceBollDto> findByNumeroBollinoDataControllo(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter.TransazioneFilter input)
			throws SigitTCodiceBollDaoException {
		LOG.debug("[SigitTCodiceBollDaoImpl::findByNumeroBollinoDataControllo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT SIGLA_BOLLINO,NUMERO_BOLLINO,FK_TRANSAZIONE_BOLL,FK_POTENZA,FK_PREZZO,FK_DT_INIZIO_ACQUISTO,FLG_PREGRESSO,DT_INSERIMENTO ");
		/*PROTECTED REGION ID(R1826363156) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_CODICE_BOLL cb, SIGIT_R_TRANS_ACQ_BOLL_QTA ab, SIGIT_R_POTENZA_PREZZO pp");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R792921758) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" cb.FK_TRANSAZIONE_BOLL = ab.ID_TRANSAZIONE_BOLL");
		sql.append(" AND cb.FK_POTENZA = ab.ID_POTENZA");
		sql.append(" AND cb.FK_PREZZO = ab.ID_PREZZO");
		sql.append(" AND cb.FK_DT_INIZIO_ACQUISTO = ab.DT_INIZIO_ACQUISTO");
		sql.append(" AND ab.ID_POTENZA = pp.ID_POTENZA");
		sql.append(" AND ab.ID_PREZZO = pp.ID_PREZZO");
		sql.append(" AND ab.DT_INIZIO_ACQUISTO = pp.DT_INIZIO_ACQUISTO");
		sql.append(" AND cb.SIGLA_BOLLINO = :siglaBollino");
		sql.append(" AND cb.NUMERO_BOLLINO = :numeroBollino");
		sql.append(" AND :dataControllo BETWEEN pp.DT_INIZIO_USO AND COALESCE(pp.DT_FINE_USO, CURRENT_DATE)");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1064343028) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("numeroBollino", input.getNumeroBollino());
		paramMap.addValue("siglaBollino", input.getSiglaBollino());
		paramMap.addValue("dataControllo", input.getDataControllo(), java.sql.Types.DATE);

		/*PROTECTED REGION END*/
		List<SigitTCodiceBollDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byNumeroBollinoDataControlloRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCodiceBollDaoImpl::findByNumeroBollinoDataControllo] esecuzione query", ex);
			throw new SigitTCodiceBollDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCodiceBollDaoImpl", "findByNumeroBollinoDataControllo", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTCodiceBollDaoImpl::findByNumeroBollinoDataControllo] END");
		}
		return list;
	}

}
