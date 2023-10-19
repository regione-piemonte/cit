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

/*PROTECTED REGION ID(R1979073231) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitbatchn.business.util.Constants;

/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVRicercaAllegati.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - inviatiByCodImpiantoOrderedByData (datagen::CustomFinder)
 *   - byIdAllegato (datagen::CustomFinder)
 *   - inviatiByDaysInterval (datagen::CustomFinder)
 *   - inviatiByDaysIntervalPTU (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitVRicercaAllegatiDaoImpl extends AbstractDAO implements SigitVRicercaAllegatiDao {
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

	protected SigitVRicercaAllegatiDaoRowMapper inviatiByCodImpiantoOrderedByDataRowMapper = new SigitVRicercaAllegatiDaoRowMapper(
			null, SigitVRicercaAllegatiDto.class, this);

	protected SigitVRicercaAllegatiDaoRowMapper byIdAllegatoRowMapper = new SigitVRicercaAllegatiDaoRowMapper(null,
			SigitVRicercaAllegatiDto.class, this);

	protected SigitVRicercaAllegatiDaoRowMapper inviatiByDaysIntervalRowMapper = new SigitVRicercaAllegatiDaoRowMapper(
			null, SigitVRicercaAllegatiDto.class, this);

	protected SigitVRicercaAllegatiDaoRowMapper inviatiByDaysIntervalPTURowMapper = new SigitVRicercaAllegatiDaoRowMapper(
			null, SigitVRicercaAllegatiDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_RICERCA_ALLEGATI";
	}

	/** 
	 * Implementazione del finder inviatiByCodImpiantoOrderedByData
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findInviatiByCodImpiantoOrderedByData(Integer input)
			throws SigitVRicercaAllegatiDaoException {
		LOG.debug("[SigitVRicercaAllegatiDaoImpl::findInviatiByCodImpiantoOrderedByData] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_ISPEZ_ISPET,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,DT_INVIO_MEMO,MAIL_INVIO_MEMO,ID_LOG_MEMO_PTU ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1539449480) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND FK_STATO_RAPP = '" + Constants.ID_STATO_RAPPORTO_INVIATO + "'");

		/*PROTECTED REGION END*/

		sql.append(" ORDER BY DATA_CONTROLLO DESC"); /*PROTECTED REGION ID(R-353407374) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVRicercaAllegatiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, inviatiByCodImpiantoOrderedByDataRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiDaoImpl::findInviatiByCodImpiantoOrderedByData] esecuzione query", ex);
			throw new SigitVRicercaAllegatiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiDaoImpl", "findInviatiByCodImpiantoOrderedByData",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitVRicercaAllegatiDaoImpl::findInviatiByCodImpiantoOrderedByData] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findByIdAllegato(Integer input) throws SigitVRicercaAllegatiDaoException {
		LOG.debug("[SigitVRicercaAllegatiDaoImpl::findByIdAllegato] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_ISPEZ_ISPET,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,DT_INVIO_MEMO,MAIL_INVIO_MEMO,ID_LOG_MEMO_PTU ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-173154201) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("ID_ALLEGATO = :idAllegato");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-947926685) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idAllegato", input);

		/*PROTECTED REGION END*/
		List<SigitVRicercaAllegatiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAllegatoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiDaoImpl::findByIdAllegato] esecuzione query", ex);
			throw new SigitVRicercaAllegatiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiDaoImpl", "findByIdAllegato", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVRicercaAllegatiDaoImpl::findByIdAllegato] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder inviatiByDaysInterval
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findInviatiByDaysInterval(java.lang.Integer input)
			throws SigitVRicercaAllegatiDaoException {
		LOG.debug("[SigitVRicercaAllegatiDaoImpl::findInviatiByDaysInterval] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_ISPEZ_ISPET,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,DT_INVIO_MEMO,MAIL_INVIO_MEMO,ID_LOG_MEMO_PTU ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1818502509) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(
				"dt_invio_memo is null AND fk_stato_rapp=1 AND f_intervento_entro >= NOW() AND f_intervento_entro < (NOW() +  CAST(:interval_days AS INTERVAL))");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R663889181) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("interval_days", input + " days");

		/*PROTECTED REGION END*/
		List<SigitVRicercaAllegatiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, inviatiByDaysIntervalRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiDaoImpl::findInviatiByDaysInterval] esecuzione query", ex);
			throw new SigitVRicercaAllegatiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiDaoImpl", "findInviatiByDaysInterval", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVRicercaAllegatiDaoImpl::findInviatiByDaysInterval] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder inviatiByDaysIntervalPTU
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findInviatiByDaysIntervalPTU(java.lang.Integer input)
			throws SigitVRicercaAllegatiDaoException {
		LOG.debug("[SigitVRicercaAllegatiDaoImpl::findInviatiByDaysIntervalPTU] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_ISPEZ_ISPET,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,DT_INVIO_MEMO,MAIL_INVIO_MEMO,ID_LOG_MEMO_PTU ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1225716178) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(
				" fk_stato_rapp=1 AND f_intervento_entro >= NOW() AND f_intervento_entro < (NOW() +  CAST(:interval_days AS INTERVAL))");
		sql.append(" and id_log_memo_ptu IS NULL");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-532617896) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("interval_days", input + " days");

		/*PROTECTED REGION END*/
		List<SigitVRicercaAllegatiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, inviatiByDaysIntervalPTURowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiDaoImpl::findInviatiByDaysIntervalPTU] esecuzione query", ex);
			throw new SigitVRicercaAllegatiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiDaoImpl", "findInviatiByDaysIntervalPTU", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVRicercaAllegatiDaoImpl::findInviatiByDaysIntervalPTU] END");
		}
		return list;
	}

}
