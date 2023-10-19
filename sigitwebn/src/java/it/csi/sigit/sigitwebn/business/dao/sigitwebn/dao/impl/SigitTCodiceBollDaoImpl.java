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

/*PROTECTED REGION ID(R-1292484315) ENABLED START*/
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTCodiceBoll.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byIdTransazioneBoll (datagen::CustomFinder)
 *   - byNumeroBollino (datagen::CustomFinder)
 *   - byNumeroBollinoPerPotenzaPrezzo (datagen::CustomFinder)
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

	/**
	 * Metodo di inserimento del DAO sigitTCodiceBoll. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCodiceBollPk
	 * @generated
	 */

	public SigitTCodiceBollPk insert(SigitTCodiceBollDto dto)

	{
		LOG.debug("[SigitTCodiceBollDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	SIGLA_BOLLINO,NUMERO_BOLLINO,FK_TRANSAZIONE_BOLL,FK_POTENZA,FK_PREZZO,FK_DT_INIZIO_ACQUISTO,FLG_PREGRESSO,DT_INSERIMENTO ) VALUES (  :SIGLA_BOLLINO , :NUMERO_BOLLINO , :FK_TRANSAZIONE_BOLL , :FK_POTENZA , :FK_PREZZO , :FK_DT_INIZIO_ACQUISTO , :FLG_PREGRESSO , :DT_INSERIMENTO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [SIGLA_BOLLINO]
		params.addValue("SIGLA_BOLLINO", dto.getSiglaBollino(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NUMERO_BOLLINO]
		params.addValue("NUMERO_BOLLINO", dto.getNumeroBollino(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TRANSAZIONE_BOLL]
		params.addValue("FK_TRANSAZIONE_BOLL", dto.getFkTransazioneBoll(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_POTENZA]
		params.addValue("FK_POTENZA", dto.getFkPotenza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_PREZZO]
		params.addValue("FK_PREZZO", dto.getFkPrezzo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_DT_INIZIO_ACQUISTO]
		params.addValue("FK_DT_INIZIO_ACQUISTO", dto.getFkDtInizioAcquisto(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FLG_PREGRESSO]
		params.addValue("FLG_PREGRESSO", dto.getFlgPregresso(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_INSERIMENTO]
		params.addValue("DT_INSERIMENTO", dto.getDtInserimento(), java.sql.Types.TIMESTAMP);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTCodiceBollDaoImpl::insert] END");
		return dto.createPk();

	}

	protected SigitTCodiceBollDaoRowMapper findByPrimaryKeyRowMapper = new SigitTCodiceBollDaoRowMapper(null,
			SigitTCodiceBollDto.class, this);

	protected SigitTCodiceBollDaoRowMapper byIdTransazioneBollRowMapper = new SigitTCodiceBollDaoRowMapper(null,
			SigitTCodiceBollDto.class, this);

	protected SigitTCodiceBollDaoRowMapper byNumeroBollinoRowMapper = new SigitTCodiceBollDaoRowMapper(null,
			SigitTCodiceBollDto.class, this);

	protected SigitTCodiceBollDaoRowMapper byNumeroBollinoPerPotenzaPrezzoRowMapper = new SigitTCodiceBollDaoRowMapper(
			null, SigitTCodiceBollByNumeroBollinoPerPotenzaPrezzoDto.class, this);

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
	 * Returns all rows from the SIGIT_T_CODICE_BOLL table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTCodiceBollDto findByPrimaryKey(SigitTCodiceBollPk pk) throws SigitTCodiceBollDaoException {
		LOG.debug("[SigitTCodiceBollDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT SIGLA_BOLLINO,NUMERO_BOLLINO,FK_TRANSAZIONE_BOLL,FK_POTENZA,FK_PREZZO,FK_DT_INIZIO_ACQUISTO,FLG_PREGRESSO,DT_INSERIMENTO FROM "
						+ getTableName()
						+ " WHERE SIGLA_BOLLINO = :SIGLA_BOLLINO  AND NUMERO_BOLLINO = :NUMERO_BOLLINO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [SIGLA_BOLLINO]
		params.addValue("SIGLA_BOLLINO", pk.getSiglaBollino(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NUMERO_BOLLINO]
		params.addValue("NUMERO_BOLLINO", pk.getNumeroBollino(), java.sql.Types.NUMERIC);

		List<SigitTCodiceBollDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTCodiceBollDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTCodiceBollDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCodiceBollDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCodiceBollDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byIdTransazioneBoll
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCodiceBollDto> findByIdTransazioneBoll(java.lang.Long input) throws SigitTCodiceBollDaoException {
		LOG.debug("[SigitTCodiceBollDaoImpl::findByIdTransazioneBoll] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT SIGLA_BOLLINO,NUMERO_BOLLINO,FK_TRANSAZIONE_BOLL,FK_POTENZA,FK_PREZZO,FK_DT_INIZIO_ACQUISTO,FLG_PREGRESSO,DT_INSERIMENTO ");
		sql.append(" FROM SIGIT_T_CODICE_BOLL");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-2099719895) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("FK_TRANSAZIONE_BOLL = :idTransazione");

		sql.append(" ORDER BY NUMERO_BOLLINO ASC ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R213756473) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idTransazione", input);

		/*PROTECTED REGION END*/
		List<SigitTCodiceBollDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdTransazioneBollRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCodiceBollDaoImpl::findByIdTransazioneBoll] esecuzione query", ex);
			throw new SigitTCodiceBollDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCodiceBollDaoImpl", "findByIdTransazioneBoll", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTCodiceBollDaoImpl::findByIdTransazioneBoll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byNumeroBollino
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCodiceBollDto> findByNumeroBollino(java.lang.Integer input) throws SigitTCodiceBollDaoException {
		LOG.debug("[SigitTCodiceBollDaoImpl::findByNumeroBollino] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT SIGLA_BOLLINO,NUMERO_BOLLINO,FK_TRANSAZIONE_BOLL,FK_POTENZA,FK_PREZZO,FK_DT_INIZIO_ACQUISTO,FLG_PREGRESSO,DT_INSERIMENTO ");
		sql.append(" FROM SIGIT_T_CODICE_BOLL");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1227301734) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("NUMERO_BOLLINO = :numeroBollino");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1488915688) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("numeroBollino", input);

		/*PROTECTED REGION END*/
		List<SigitTCodiceBollDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byNumeroBollinoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCodiceBollDaoImpl::findByNumeroBollino] esecuzione query", ex);
			throw new SigitTCodiceBollDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCodiceBollDaoImpl", "findByNumeroBollino", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCodiceBollDaoImpl::findByNumeroBollino] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byNumeroBollinoPerPotenzaPrezzo con Qdef
		 * @generated
		 */

	public List<SigitTCodiceBollByNumeroBollinoPerPotenzaPrezzoDto> findByNumeroBollinoPerPotenzaPrezzo(
			SigitTCodiceBollDto input) throws SigitTCodiceBollDaoException {
		LOG.debug("[SigitTCodiceBollDaoImpl::findByNumeroBollinoPerPotenzaPrezzo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT tCodiceBollino.FK_TRANSAZIONE_BOLL as fkTransazioneBoll, tCodiceBollino.SIGLA_BOLLINO as siglaBollino, tCodiceBollino.NUMERO_BOLLINO as numeroBollino, tCodiceBollino.FK_POTENZA as fkPotenza, tCodiceBollino.FK_PREZZO as fkPrezzo, tCodiceBollino.FK_DT_INIZIO_ACQUISTO as fkDataInizioAcquisto");

		sql.append(" FROM SIGIT_T_CODICE_BOLL tCodiceBollino");

		sql.append(" WHERE ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R-773760018) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		if (input.getNumeroBollino() != null) {
			sql.append(" AND tCodiceBollino.NUMERO_BOLLINO = :idNumeroBollino");
			paramMap.addValue("idNumeroBollino", input.getNumeroBollino());

		}
		if (GenericUtil.isNotNullOrEmpty(input.getSiglaBollino())) {
			sql.append(" AND tCodiceBollino.SIGLA_BOLLINO = :siglaBollino ");
			paramMap.addValue("siglaBollino", input.getSiglaBollino());
		}

		sql.append(" AND rPotenzaPrezzo.DT_INIZIO_USO <= CURRENT_DATE ");
		sql.append(" AND ( rPotenzaPrezzo.DT_FINE_USO IS NULL OR rPotenzaPrezzo.DT_FINE_USO >= CURRENT_DATE) ");

		/*PROTECTED REGION END*/

		List<SigitTCodiceBollByNumeroBollinoPerPotenzaPrezzoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byNumeroBollinoPerPotenzaPrezzoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTCodiceBollDaoImpl::findByNumeroBollinoPerPotenzaPrezzo] ERROR esecuzione query", ex);
			throw new SigitTCodiceBollDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCodiceBollDaoImpl", "findByNumeroBollinoPerPotenzaPrezzo", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTCodiceBollDaoImpl::findByNumeroBollinoPerPotenzaPrezzo] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byNumeroBollinoDataControllo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCodiceBollDto> findByNumeroBollinoDataControllo(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.TransazioneFilter input)
			throws SigitTCodiceBollDaoException {
		LOG.debug("[SigitTCodiceBollDaoImpl::findByNumeroBollinoDataControllo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT SIGLA_BOLLINO,NUMERO_BOLLINO,FK_TRANSAZIONE_BOLL,FK_POTENZA,FK_PREZZO,FK_DT_INIZIO_ACQUISTO,FLG_PREGRESSO,DT_INSERIMENTO ");
		/*PROTECTED REGION ID(R839703234) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_CODICE_BOLL cb, SIGIT_R_TRANS_ACQ_BOLL_QTA ab, SIGIT_R_POTENZA_PREZZO pp");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R43632248) ENABLED START*/
		// personalizzare la query SQL relativa al finder

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
		/*PROTECTED REGION ID(R-2061803830) ENABLED START*/
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
