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

/*PROTECTED REGION ID(R-1282985437) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implemenrazione del DAO sigitTAllRespTxt
 * @generated
 */
public class SigitTAllRespTxtDaoImpl extends AbstractDAO
		implements
			SigitTAllRespTxtDao {
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
	 * Metodo di inserimento del DAO sigitTAllRespTxt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAllRespTxtPk
	 * @generated
	 */

	public SigitTAllRespTxtPk insert(SigitTAllRespTxtDto dto)

	{
		log.debug("[SigitTAllRespTxtDaoImpl::insert] START");
		final String sql = "INSERT INTO "
				+ getTableName()
				+ " ( 	DATA_CONTROLLO,ID_IMP_RUOLO_PFPG,ID_ALLEGATO,XML_ALLEGATO ) VALUES (  :DATA_CONTROLLO , :ID_IMP_RUOLO_PFPG , :ID_ALLEGATO , :XML_ALLEGATO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("DATA_CONTROLLO", dto.getDataControllo(),
				java.sql.Types.DATE);

		params.addValue("ID_IMP_RUOLO_PFPG", dto.getIdImpRuoloPfpg(),
				java.sql.Types.NUMERIC);

		params.addValue("ID_ALLEGATO", dto.getIdAllegato(),
				java.sql.Types.NUMERIC);

		params.addValue("XML_ALLEGATO", dto.getXmlAllegato(),
				java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		log.debug("[SigitTAllRespTxtDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_ALLRESP_TXT table.
	 * @generated
	 */
	public void update(SigitTAllRespTxtDto dto)
			throws SigitTAllRespTxtDaoException {
		log.debug("[SigitTAllRespTxtDaoImpl::update] START");
		final String sql = "UPDATE "
				+ getTableName()
				+ " SET XML_ALLEGATO = :XML_ALLEGATO  WHERE DATA_CONTROLLO = :DATA_CONTROLLO  AND ID_IMP_RUOLO_PFPG = :ID_IMP_RUOLO_PFPG  AND ID_ALLEGATO = :ID_ALLEGATO ";

		if (dto.getDataControllo() == null || dto.getIdImpRuoloPfpg() == null
				|| dto.getIdAllegato() == null) {
			log.error("[SigitTAllRespTxtDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTAllRespTxtDaoException(
					"Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("DATA_CONTROLLO", dto.getDataControllo(),
				java.sql.Types.DATE);

		params.addValue("ID_IMP_RUOLO_PFPG", dto.getIdImpRuoloPfpg(),
				java.sql.Types.NUMERIC);

		params.addValue("ID_ALLEGATO", dto.getIdAllegato(),
				java.sql.Types.NUMERIC);

		params.addValue("XML_ALLEGATO", dto.getXmlAllegato(),
				java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		log.debug("[SigitTAllRespTxtDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_ALLRESP_TXT table.
	 * @generated
	 */

	public void delete(SigitTAllRespTxtPk pk)
			throws SigitTAllRespTxtDaoException {
		log.debug("[SigitTAllRespTxtDaoImpl::delete] START");
		final String sql = "DELETE FROM "
				+ getTableName()
				+ " WHERE DATA_CONTROLLO = :DATA_CONTROLLO  AND ID_IMP_RUOLO_PFPG = :ID_IMP_RUOLO_PFPG  AND ID_ALLEGATO = :ID_ALLEGATO ";

		if (pk == null) {
			log.error("[SigitTAllRespTxtDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTAllRespTxtDaoException(
					"Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("DATA_CONTROLLO", pk.getDataControllo(),
				java.sql.Types.DATE);

		params.addValue("ID_IMP_RUOLO_PFPG", pk.getIdImpRuoloPfpg(),
				java.sql.Types.NUMERIC);

		params.addValue("ID_ALLEGATO", pk.getIdAllegato(),
				java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		log.debug("[SigitTAllRespTxtDaoImpl::delete] END");
	}

	protected SigitTAllRespTxtDaoRowMapper findByPrimaryKeyRowMapper = new SigitTAllRespTxtDaoRowMapper(
			null, SigitTAllRespTxtDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_ALLRESP_TXT";
	}

	/** 
	 * Returns all rows from the SIGIT_T_ALLRESP_TXT table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTAllRespTxtDto findByPrimaryKey(SigitTAllRespTxtPk pk)
			throws SigitTAllRespTxtDaoException {
		log.debug("[SigitTAllRespTxtDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT DATA_CONTROLLO,ID_IMP_RUOLO_PFPG,ID_ALLEGATO,XML_ALLEGATO FROM "
						+ getTableName()
						+ " WHERE DATA_CONTROLLO = :DATA_CONTROLLO  AND ID_IMP_RUOLO_PFPG = :ID_IMP_RUOLO_PFPG  AND ID_ALLEGATO = :ID_ALLEGATO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("DATA_CONTROLLO", pk.getDataControllo(),
				java.sql.Types.DATE);

		params.addValue("ID_IMP_RUOLO_PFPG", pk.getIdImpRuoloPfpg(),
				java.sql.Types.NUMERIC);

		params.addValue("ID_ALLEGATO", pk.getIdAllegato(),
				java.sql.Types.NUMERIC);

		List<SigitTAllRespTxtDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params,
					findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			log.error(
					"[SigitTAllRespTxtDaoImpl::findByPrimaryKey] ERROR esecuzione query",
					ex);
			throw new SigitTAllRespTxtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAllRespTxtDaoImpl",
					"findByPrimaryKey", "esecuzione query", sql.toString());
			log.debug("[SigitTAllRespTxtDaoImpl::findByPrimaryKey] END");
		}
		return list.size() == 0 ? null : list.get(0);
	}

}
