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

/*PROTECTED REGION ID(R-1205792165) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVRicerca3Responsabile.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - responsabile3AttivoByCodImpianto (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitVRicerca3ResponsabileDaoImpl extends AbstractDAO implements SigitVRicerca3ResponsabileDao {
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

	protected SigitVRicerca3ResponsabileDaoRowMapper responsabile3AttivoByCodImpiantoRowMapper = new SigitVRicerca3ResponsabileDaoRowMapper(
			null, SigitVRicerca3ResponsabileDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_RICERCA_3_RESPONSABILE";
	}

	/** 
	 * Implementazione del finder responsabile3AttivoByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicerca3ResponsabileDto> findResponsabile3AttivoByCodImpianto(java.lang.Integer input)
			throws SigitVRicerca3ResponsabileDaoException {
		LOG.debug("[SigitVRicerca3ResponsabileDaoImpl::findResponsabile3AttivoByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_CONTRATTO,CODICE_IMPIANTO,FK_RUOLO,DES_RUOLO,DATA_CARICAMENTO,DATA_CESSAZIONE,DATA_INSERIMENTO_CESSAZIONE,FK_PG_3_RESP,FK_IMP_RUOLO_PFPG_RESP,DATA_INIZIO_CONTRATTO,DATA_FINE_CONTRATTO,FLG_TACITO_RINNOVO,RESP_CODICE_FISCALE,RESP_DENOMINAZIONE,RESP_NOME,TERZO_RESP_DENOMINAZIONE,TERZO_RESP_SIGLA_REA,TERZO_RESP_NUMERO_REA,CODICE_FISCALE_3_RESP,DENOM_COMUNE_3_RESP,SIGLA_PROV_3_RESP,DENOM_PROVINCIA_3_RESP,DENOM_COMUNE_IMPIANTO,DENOM_PROV_IMPIANTO,SIGLA_PROV_IMPIANTO ");
		sql.append(" FROM VISTA_RICERCA_3_RESPONSABILE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1915528160) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		//TODO gestire flag tacito rinnovo
		sql.append("data_inizio_contratto <= NOW() ");
		sql.append(
				"AND  ( (flg_tacito_rinnovo = 0 AND COALESCE(data_cessazione, data_fine_contratto) > NOW()) OR (flg_tacito_rinnovo = 1 AND (data_cessazione IS NULL OR data_cessazione > NOW())) )");
		sql.append("AND codice_impianto = :codice_impianto");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-623282934) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codice_impianto", input);

		/*PROTECTED REGION END*/
		List<SigitVRicerca3ResponsabileDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, responsabile3AttivoByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicerca3ResponsabileDaoImpl::findResponsabile3AttivoByCodImpianto] esecuzione query", ex);
			throw new SigitVRicerca3ResponsabileDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicerca3ResponsabileDaoImpl", "findResponsabile3AttivoByCodImpianto",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitVRicerca3ResponsabileDaoImpl::findResponsabile3AttivoByCodImpianto] END");
		}
		return list;
	}

}
