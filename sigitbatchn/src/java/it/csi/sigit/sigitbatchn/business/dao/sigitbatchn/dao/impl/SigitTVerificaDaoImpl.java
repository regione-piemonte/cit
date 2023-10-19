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

/*PROTECTED REGION ID(R1572492339) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTVerifica.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byCodiceFiscale (datagen::CustomFinder)
 *   - byUtentiNonAttivi (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTVerificaDaoImpl extends AbstractDAO implements SigitTVerificaDao {
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

	protected SigitTVerificaDaoRowMapper byCodiceFiscaleRowMapper = new SigitTVerificaDaoRowMapper(null,
			SigitTVerificaDto.class, this);

	protected SigitTVerificaDaoRowMapper byUtentiNonAttiviRowMapper = new SigitTVerificaDaoRowMapper(null,
			SigitTVerificaByUtentiNonAttiviDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_VERIFICA";
	}

	/** 
	 * Implementazione del finder byCodiceFiscale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTVerificaDto> findByCodiceFiscale(java.lang.String input) throws SigitTVerificaDaoException {
		LOG.debug("[SigitTVerificaDaoImpl::findByCodiceFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_VERIFICA,FK_TIPO_VERIFICA,FK_ALLEGATO,FK_DATO_DISTRIB,CODICE_IMPIANTO,CF_UTENTE_CARICAMENTO,DENOM_UTENTE_CARICAMENTO,DT_CARICAMENTO,SIGLA_BOLLINO,NUMERO_BOLLINO,DT_SVEGLIA,NOTE_SVEGLIA,NOTE ");
		sql.append(" FROM SIGIT_T_VERIFICA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-307100080) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("cf_utente_caricamento = :codice_fiscale AND dt_sveglia <= NOW()");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-805281638) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codice_fiscale", input);

		/*PROTECTED REGION END*/
		List<SigitTVerificaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceFiscaleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTVerificaDaoImpl::findByCodiceFiscale] esecuzione query", ex);
			throw new SigitTVerificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTVerificaDaoImpl", "findByCodiceFiscale", "esecuzione query", sql.toString());
			LOG.debug("[SigitTVerificaDaoImpl::findByCodiceFiscale] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byUtentiNonAttivi con Qdef
		 * @generated
		 */

	public List<SigitTVerificaByUtentiNonAttiviDto> findByUtentiNonAttivi(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTVerificaDto input)
			throws SigitTVerificaDaoException {
		LOG.debug("[SigitTVerificaDaoImpl::findByUtentiNonAttivi] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT V.ID_VERIFICA, V.CF_UTENTE_CARICAMENTO, V.DENOM_UTENTE_CARICAMENTO, V.DT_SVEGLIA, V.NOTE_SVEGLIA, A.ID_RUOLO_PA, A.ISTAT_ABILITAZIONE, A.MAIL_COMUNICAZIONE");

		sql.append(" FROM SIGIT_R_PF_RUOLO_PA R, SIGIT_T_PERSONA_FISICA P, SIGIT_T_VERIFICA V, SIGIT_T_ABILITAZIONE A");

		sql.append(" WHERE ");

		sql.append(
				"R.ID_PERSONA_FISICA = P.ID_PERSONA_FISICA AND P.CODICE_FISCALE = V.CF_UTENTE_CARICAMENTO AND R.ID_RUOLO_PA = A.ID_RUOLO_PA AND R.ISTAT_ABILITAZIONE = A.ISTAT_ABILITAZIONE");

		sql.append(" AND ");

		sql.append("A.id_ruolo_pa = 4 AND R.data_fine is not null AND V.dt_sveglia <= NOW()");
		/*PROTECTED REGION ID(R167109163) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:
		sql.append("ORDER BY  A.ID_RUOLO_PA ASC, A.ISTAT_ABILITAZIONE ASC, A.MAIL_COMUNICAZIONE ASC");
		//paramMap.addValue("param", input);

		/*PROTECTED REGION END*/

		List<SigitTVerificaByUtentiNonAttiviDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byUtentiNonAttiviRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTVerificaDaoImpl::findByUtentiNonAttivi] ERROR esecuzione query", ex);
			throw new SigitTVerificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTVerificaDaoImpl", "findByUtentiNonAttivi", "esecuzione query", sql.toString());
			LOG.debug("[SigitTVerificaDaoImpl::findByUtentiNonAttivi] END");
		}
		return list;
	}

}
