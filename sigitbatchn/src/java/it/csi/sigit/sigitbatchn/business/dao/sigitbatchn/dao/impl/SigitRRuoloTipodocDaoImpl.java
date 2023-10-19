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

/*PROTECTED REGION ID(R1152216843) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitbatchn.business.util.ConvertUtil;

/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRRuoloTipodoc.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - verificaAllegatoSelezionato (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRRuoloTipodocDaoImpl extends AbstractDAO implements SigitRRuoloTipodocDao {
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

	protected SigitRRuoloTipodocDaoRowMapper verificaAllegatoSelezionatoRowMapper = new SigitRRuoloTipodocDaoRowMapper(
			null, SigitRRuoloTipodocDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_RUOLO_TIPODOC";
	}

	/** 
	 * Implementazione del finder verificaAllegatoSelezionato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRRuoloTipodocDto> findVerificaAllegatoSelezionato(java.lang.Integer input)
			throws SigitRRuoloTipodocDaoException {
		LOG.debug("[SigitRRuoloTipodocDaoImpl::findVerificaAllegatoSelezionato] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_RUOLO,ID_TIPO_DOCUMENTO ");
		sql.append(" FROM SIGIT_R_RUOLO_TIPODOC");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1964309974) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" ID_TIPO_DOCUMENTO = :idTipoDocumento");

		//		if (GenericUtil.isNotNullOrEmpty(input.getIdRuoloFunzionale()))
		//			sql.append(" AND ID_RUOLO = :idRuolo");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R888953300) ENABLED START*/
		//***aggiungere tutte le condizioni

		//		if (GenericUtil.isNotNullOrEmpty(input.getIdRuoloFunzionale()))
		//			paramMap.addValue("idRuolo",
		//					new BigDecimal(input.getIdRuoloFunzionale()));

		paramMap.addValue("idTipoDocumento", ConvertUtil.convertToBigDecimal(input));

		/*PROTECTED REGION END*/
		List<SigitRRuoloTipodocDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, verificaAllegatoSelezionatoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRRuoloTipodocDaoImpl::findVerificaAllegatoSelezionato] esecuzione query", ex);
			throw new SigitRRuoloTipodocDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRRuoloTipodocDaoImpl", "findVerificaAllegatoSelezionato", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRRuoloTipodocDaoImpl::findVerificaAllegatoSelezionato] END");
		}
		return list;
	}

}
