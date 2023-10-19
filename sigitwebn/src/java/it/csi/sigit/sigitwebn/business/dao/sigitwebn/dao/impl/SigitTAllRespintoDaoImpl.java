/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
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

/*PROTECTED REGION ID(R-1556032017) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implemenrazione del DAO sigitTAllRespinto
 * @generated
 */
public class SigitTAllRespintoDaoImpl extends AbstractDAO
		implements
			SigitTAllRespintoDao {
	protected static final Logger log = Logger
			.getLogger(Constants.APPLICATION_CODE);
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
	 * Metodo di inserimento del DAO sigitTAllRespinto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAllRespintoPk
	 * @generated
	 */

	public SigitTAllRespintoPk insert(SigitTAllRespintoDto dto)

	{
		log.debug("[SigitTAllRespintoDaoImpl::insert] START");
		final String sql = "INSERT INTO "
				+ getTableName()
				+ " ( 	DATA_CONTROLLO,ID_IMP_RUOLO_PFPG,FK_TIPO_DOCUMENTO,SIGLA_BOLLINO,NUMERO_BOLLINO,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_RESPINTA,DATA_INVIO,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_INTERVENTO_ENTRO,ID_ALLEGATO,UID_INDEX ) VALUES (  :DATA_CONTROLLO , :ID_IMP_RUOLO_PFPG , :FK_TIPO_DOCUMENTO , :SIGLA_BOLLINO , :NUMERO_BOLLINO , :NOME_ALLEGATO , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :DATA_RESPINTA , :DATA_INVIO , :F_OSSERVAZIONI , :F_RACCOMANDAZIONI , :F_PRESCRIZIONI , :F_INTERVENTO_ENTRO , :ID_ALLEGATO , :UID_INDEX  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("DATA_CONTROLLO", dto.getDataControllo(),
				java.sql.Types.DATE);

		params.addValue("ID_IMP_RUOLO_PFPG", dto.getIdImpRuoloPfpg(),
				java.sql.Types.NUMERIC);

		params.addValue("FK_TIPO_DOCUMENTO", dto.getFkTipoDocumento(),
				java.sql.Types.NUMERIC);

		params.addValue("SIGLA_BOLLINO", dto.getSiglaBollino(),
				java.sql.Types.VARCHAR);

		params.addValue("NUMERO_BOLLINO", dto.getNumeroBollino(),
				java.sql.Types.NUMERIC);

		params.addValue("NOME_ALLEGATO", dto.getNomeAllegato(),
				java.sql.Types.VARCHAR);

		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(),
				java.sql.Types.TIMESTAMP);

		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(),
				java.sql.Types.VARCHAR);

		params.addValue("DATA_RESPINTA", dto.getDataRespinta(),
				java.sql.Types.DATE);

		params.addValue("DATA_INVIO", dto.getDataInvio(), java.sql.Types.DATE);

		params.addValue("F_OSSERVAZIONI", dto.getFOsservazioni(),
				java.sql.Types.VARCHAR);

		params.addValue("F_RACCOMANDAZIONI", dto.getFRaccomandazioni(),
				java.sql.Types.VARCHAR);

		params.addValue("F_PRESCRIZIONI", dto.getFPrescrizioni(),
				java.sql.Types.VARCHAR);

		params.addValue("F_INTERVENTO_ENTRO", dto.getFInterventoEntro(),
				java.sql.Types.DATE);

		params.addValue("ID_ALLEGATO", dto.getIdAllegato(),
				java.sql.Types.NUMERIC);

		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		log.debug("[SigitTAllRespintoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Custom deleter in the SIGIT_T_ALL_RESPINTO table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter)
			throws SigitTAllRespintoDaoException {
		log.debug("[SigitTAllRespintoDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R-651440197) ENABLED START*/
		//***scrivere la custom query
		final StringBuilder sql = new StringBuilder("DELETE FROM "
				+ getTableName() + " WHERE ");

		sql.append(" ID_IMP_RUOLO_PFPG IN");
		sql.append(" (SELECT ID_IMP_RUOLO_PFPG ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG");
		sql.append(" WHERE CODICE_IMPIANTO = :codImpianto)");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		log.debug("[SigitTAllRespintoDaoImpl::customDeleterByCodImpianto] END");
	}

	protected SigitTAllRespintoDaoRowMapper findByPrimaryKeyRowMapper = new SigitTAllRespintoDaoRowMapper(
			null, SigitTAllRespintoDto.class, this);

	protected SigitTAllRespintoDaoRowMapper findAllRowMapper = new SigitTAllRespintoDaoRowMapper(
			null, SigitTAllRespintoDto.class, this);

	protected SigitTAllRespintoDaoRowMapper ByCodImpiantoRowMapper = new SigitTAllRespintoDaoRowMapper(
			null, SigitTAllRespintoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_ALL_RESPINTO";
	}

	/** 
	 * Returns all rows from the SIGIT_T_ALL_RESPINTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTAllRespintoDto findByPrimaryKey(SigitTAllRespintoPk pk)
			throws SigitTAllRespintoDaoException {
		log.debug("[SigitTAllRespintoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT DATA_CONTROLLO,ID_IMP_RUOLO_PFPG,FK_TIPO_DOCUMENTO,SIGLA_BOLLINO,NUMERO_BOLLINO,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_RESPINTA,DATA_INVIO,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_INTERVENTO_ENTRO,ID_ALLEGATO,UID_INDEX FROM "
						+ getTableName()
						+ " WHERE DATA_CONTROLLO = :DATA_CONTROLLO  AND ID_IMP_RUOLO_PFPG = :ID_IMP_RUOLO_PFPG  AND ID_ALLEGATO = :ID_ALLEGATO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("DATA_CONTROLLO", pk.getDataControllo(),
				java.sql.Types.DATE);

		params.addValue("ID_IMP_RUOLO_PFPG", pk.getIdImpRuoloPfpg(),
				java.sql.Types.NUMERIC);

		params.addValue("ID_ALLEGATO", pk.getIdAllegato(),
				java.sql.Types.NUMERIC);

		List<SigitTAllRespintoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params,
					findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			log.error(
					"[SigitTAllRespintoDaoImpl::findByPrimaryKey] ERROR esecuzione query",
					ex);
			throw new SigitTAllRespintoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAllRespintoDaoImpl",
					"findByPrimaryKey", "esecuzione query", sql.toString());
			log.debug("[SigitTAllRespintoDaoImpl::findByPrimaryKey] END");
		}
		return list.size() == 0 ? null : list.get(0);
	}

	/** 
	 * Returns all rows from the SIGIT_T_ALL_RESPINTO table that match the criteria ''.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAllRespintoDto> findAll()
			throws SigitTAllRespintoDaoException {
		log.debug("[SigitTAllRespintoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT DATA_CONTROLLO,ID_IMP_RUOLO_PFPG,FK_TIPO_DOCUMENTO,SIGLA_BOLLINO,NUMERO_BOLLINO,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_RESPINTA,DATA_INVIO,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_INTERVENTO_ENTRO,ID_ALLEGATO,UID_INDEX FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTAllRespintoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			log.error(
					"[SigitTAllRespintoDaoImpl::findAll] ERROR esecuzione query",
					ex);
			throw new SigitTAllRespintoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAllRespintoDaoImpl", "findAll",
					"esecuzione query", sql.toString());
			log.debug("[SigitTAllRespintoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder ByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAllRespintoDto> findByCodImpianto(Integer input)
			throws SigitTAllRespintoDaoException {
		log.debug("[SigitTAllRespintoDaoImpl::findByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT DATA_CONTROLLO,ID_IMP_RUOLO_PFPG,FK_TIPO_DOCUMENTO,SIGLA_BOLLINO,NUMERO_BOLLINO,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DATA_RESPINTA,DATA_INVIO,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_INTERVENTO_ENTRO,ID_ALLEGATO,UID_INDEX ");
		sql.append(" FROM SIGIT_T_ALL_RESPINTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R263704117) ENABLED START*/

		sql.append(" ID_IMP_RUOLO_PFPG IN");
		sql.append(" (SELECT ID_IMP_RUOLO_PFPG ");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG");
		sql.append(" WHERE CODICE_IMPIANTO = :codImpianto)");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R465456813) ENABLED START*/

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitTAllRespintoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap,
					ByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitTAllRespintoDaoImpl::findByCodImpianto] esecuzione query",
					ex);
			throw new SigitTAllRespintoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAllRespintoDaoImpl",
					"findByCodImpianto", "esecuzione query", sql.toString());
			log.debug("[SigitTAllRespintoDaoImpl::findByCodImpianto] END");
		}
		return list;
	}

}
