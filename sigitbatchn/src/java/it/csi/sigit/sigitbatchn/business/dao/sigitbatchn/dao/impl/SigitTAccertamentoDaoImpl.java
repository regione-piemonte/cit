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

/*PROTECTED REGION ID(R-1151203247) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTAccertamento.
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
public class SigitTAccertamentoDaoImpl extends AbstractDAO implements SigitTAccertamentoDao {
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

	protected SigitTAccertamentoDaoRowMapper byCodiceFiscaleRowMapper = new SigitTAccertamentoDaoRowMapper(null,
			SigitTAccertamentoDto.class, this);

	protected SigitTAccertamentoDaoRowMapper byUtentiNonAttiviRowMapper = new SigitTAccertamentoDaoRowMapper(null,
			SigitTAccertamentoByUtentiNonAttiviDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_ACCERTAMENTO";
	}

	/** 
	 * Implementazione del finder byCodiceFiscale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAccertamentoDto> findByCodiceFiscale(java.lang.String input)
			throws SigitTAccertamentoDaoException {
		LOG.debug("[SigitTAccertamentoDaoImpl::findByCodiceFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ACCERTAMENTO,FK_VERIFICA,FK_STATO_ACCERTAMENTO,CODICE_IMPIANTO,CF_UTENTE_ASSEGN,DT_CREAZIONE,DT_CONCLUSIONE,FK_TIPO_CONCLUSIONE,FK_TIPO_ANOMALIA,DT_SVEGLIA,NOTE_SVEGLIA,NOTE,SIGLA_PROV_COMPETENZA,ISTAT_PROV_COMPETENZA,DENOM_UTENTE_ASSEGN,ISTAT_COMUNE_COMPETENZA ");
		sql.append(" FROM SIGIT_T_ACCERTAMENTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-2131834145) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("cf_utente_assegn = :codice_fiscale AND dt_sveglia <= NOW() AND fk_stato_accertamento = 1");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1537462805) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codice_fiscale", input);

		/*PROTECTED REGION END*/
		List<SigitTAccertamentoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceFiscaleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTAccertamentoDaoImpl::findByCodiceFiscale] esecuzione query", ex);
			throw new SigitTAccertamentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAccertamentoDaoImpl", "findByCodiceFiscale", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTAccertamentoDaoImpl::findByCodiceFiscale] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byUtentiNonAttivi con Qdef
		 * @generated
		 */

	public List<SigitTAccertamentoByUtentiNonAttiviDto> findByUtentiNonAttivi(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTAccertamentoDto input)
			throws SigitTAccertamentoDaoException {
		LOG.debug("[SigitTAccertamentoDaoImpl::findByUtentiNonAttivi] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT Acc.ID_ACCERTAMENTO, Acc.CF_UTENTE_ASSEGN, Acc.DENOM_UTENTE_ASSEGN, Acc.DT_SVEGLIA, Acc.NOTE_SVEGLIA, A.ID_RUOLO_PA, A.ISTAT_ABILITAZIONE, A.MAIL_COMUNICAZIONE");

		sql.append(
				" FROM SIGIT_R_PF_RUOLO_PA R, SIGIT_T_PERSONA_FISICA P, SIGIT_T_ACCERTAMENTO Acc, SIGIT_T_ABILITAZIONE A");

		sql.append(" WHERE ");

		sql.append(
				"R.ID_PERSONA_FISICA = P.ID_PERSONA_FISICA AND P.CODICE_FISCALE = Acc.CF_UTENTE_ASSEGN AND R.ID_RUOLO_PA = A.ID_RUOLO_PA AND R.ISTAT_ABILITAZIONE = A.ISTAT_ABILITAZIONE");

		sql.append(" AND ");

		sql.append(
				"A.id_ruolo_pa = 4 AND R.data_fine is not null AND ACC.dt_sveglia <= NOW() AND ACC.fk_stato_accertamento = 1");
		/*PROTECTED REGION ID(R140291772) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:
		sql.append(" ORDER BY  A.ID_RUOLO_PA ASC, A.ISTAT_ABILITAZIONE ASC, A.MAIL_COMUNICAZIONE ASC");
		//paramMap.addValue("param", input);

		/*PROTECTED REGION END*/

		List<SigitTAccertamentoByUtentiNonAttiviDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byUtentiNonAttiviRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTAccertamentoDaoImpl::findByUtentiNonAttivi] ERROR esecuzione query", ex);
			throw new SigitTAccertamentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAccertamentoDaoImpl", "findByUtentiNonAttivi", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTAccertamentoDaoImpl::findByUtentiNonAttivi] END");
		}
		return list;
	}

}
