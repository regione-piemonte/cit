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

/*PROTECTED REGION ID(R-623697071) ENABLED START*/
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRAllegatoCompSc.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byFilter (datagen::CustomFinder)
  * - UPDATERS:
 *   - responsabile (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *   - byIdAllegato (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRAllegatoCompScDaoImpl extends AbstractDAO implements SigitRAllegatoCompScDao {
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
	 * Metodo di inserimento del DAO sigitRAllegatoCompSc. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRAllegatoCompScPk
	 * @generated
	 */

	public SigitRAllegatoCompScPk insert(SigitRAllegatoCompScDto dto)

	{
		LOG.debug("[SigitRAllegatoCompScDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ALLEGATO,ID_TIPO_COMPONENTE,PROGRESSIVO,CODICE_IMPIANTO,DATA_INSTALL,FK_IMP_RUOLO_PFPG,FK_CONTRATTO ) VALUES (  :ID_ALLEGATO , :ID_TIPO_COMPONENTE , :PROGRESSIVO , :CODICE_IMPIANTO , :DATA_INSTALL , :FK_IMP_RUOLO_PFPG , :FK_CONTRATTO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_IMP_RUOLO_PFPG]
		params.addValue("FK_IMP_RUOLO_PFPG", dto.getFkImpRuoloPfpg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_CONTRATTO]
		params.addValue("FK_CONTRATTO", dto.getFkContratto(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitRAllegatoCompScDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the SIGIT_R_ALLEGATO_COMP_SC table.
	 * @generated
	 */
	public void updateColumnsResponsabile(SigitRAllegatoCompScDto dto) throws SigitRAllegatoCompScDaoException {
		LOG.debug("[SigitRAllegatoCompScDaoImpl::updateColumnsResponsabile] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_IMP_RUOLO_PFPG = :FK_IMP_RUOLO_PFPG ,FK_CONTRATTO = :FK_CONTRATTO  WHERE ID_ALLEGATO = :ID_ALLEGATO  AND ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND CODICE_IMPIANTO = :CODICE_IMPIANTO  AND DATA_INSTALL = :DATA_INSTALL ";

		if (dto.getIdAllegato() == null || dto.getIdTipoComponente() == null || dto.getProgressivo() == null
				|| dto.getCodiceImpianto() == null || dto.getDataInstall() == null) {
			LOG.error("[SigitRAllegatoCompScDaoImpl::updateColumnsResponsabile] ERROR chiave primaria non impostata");
			throw new SigitRAllegatoCompScDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_IMP_RUOLO_PFPG]
		params.addValue("FK_IMP_RUOLO_PFPG", dto.getFkImpRuoloPfpg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_CONTRATTO]
		params.addValue("FK_CONTRATTO", dto.getFkContratto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRAllegatoCompScDaoImpl::updateColumnsResponsabile] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_R_ALLEGATO_COMP_SC table.
	 * @generated
	 */

	public void delete(SigitRAllegatoCompScPk pk) throws SigitRAllegatoCompScDaoException {
		LOG.debug("[SigitRAllegatoCompScDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_ALLEGATO = :ID_ALLEGATO  AND ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND CODICE_IMPIANTO = :CODICE_IMPIANTO  AND DATA_INSTALL = :DATA_INSTALL ";

		if (pk == null) {
			LOG.error("[SigitRAllegatoCompScDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitRAllegatoCompScDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", pk.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", pk.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", pk.getDataInstall(), java.sql.Types.DATE);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRAllegatoCompScDaoImpl::delete] END");
	}

	/** 
	 * Custom deleter in the SIGIT_R_ALLEGATO_COMP_SC table.
	 * @generated
	 */
	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitRAllegatoCompScDaoException {
		LOG.debug("[SigitRAllegatoCompScDaoImpl::customDeleterByIdAllegato] START");
		/*PROTECTED REGION ID(R698694631) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ALLEGATO = :idAllegato";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idAllegato", filter);

		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRAllegatoCompScDaoImpl::customDeleterByIdAllegato] END");
	}

	protected SigitRAllegatoCompScDaoRowMapper findByPrimaryKeyRowMapper = new SigitRAllegatoCompScDaoRowMapper(null,
			SigitRAllegatoCompScDto.class, this);

	protected SigitRAllegatoCompScDaoRowMapper byFilterRowMapper = new SigitRAllegatoCompScDaoRowMapper(null,
			SigitRAllegatoCompScDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_ALLEGATO_COMP_SC";
	}

	/** 
	 * Returns all rows from the SIGIT_R_ALLEGATO_COMP_SC table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRAllegatoCompScDto findByPrimaryKey(SigitRAllegatoCompScPk pk) throws SigitRAllegatoCompScDaoException {
		LOG.debug("[SigitRAllegatoCompScDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALLEGATO,ID_TIPO_COMPONENTE,PROGRESSIVO,CODICE_IMPIANTO,DATA_INSTALL,FK_IMP_RUOLO_PFPG,FK_CONTRATTO FROM "
						+ getTableName()
						+ " WHERE ID_ALLEGATO = :ID_ALLEGATO  AND ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND CODICE_IMPIANTO = :CODICE_IMPIANTO  AND DATA_INSTALL = :DATA_INSTALL ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", pk.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", pk.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", pk.getDataInstall(), java.sql.Types.DATE);

		List<SigitRAllegatoCompScDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRAllegatoCompScDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitRAllegatoCompScDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRAllegatoCompScDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRAllegatoCompScDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRAllegatoCompScDto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitRAllegatoCompScDaoException {
		LOG.debug("[SigitRAllegatoCompScDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,ID_TIPO_COMPONENTE,PROGRESSIVO,CODICE_IMPIANTO,DATA_INSTALL,FK_IMP_RUOLO_PFPG,FK_CONTRATTO ");
		sql.append(" FROM SIGIT_R_ALLEGATO_COMP_SC");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1360301263) ENABLED START*/
		sql.append("ID_ALLEGATO = :idAllegato");

		if (GenericUtil.isNotNullOrEmpty(input.getProgressivo())) {
			sql.append(" AND PROGRESSIVO = :progressivo");
		}
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1660897585) ENABLED START*/

		paramMap.addValue("idAllegato", input.getIdAllegato());

		if (GenericUtil.isNotNullOrEmpty(input.getProgressivo())) {
			paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);
		}

		/*PROTECTED REGION END*/
		List<SigitRAllegatoCompScDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRAllegatoCompScDaoImpl::findByFilter] esecuzione query", ex);
			throw new SigitRAllegatoCompScDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRAllegatoCompScDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitRAllegatoCompScDaoImpl::findByFilter] END");
		}
		return list;
	}

}
