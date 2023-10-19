package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitRPfRuoloPaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitRPfRuoloPaDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfRuoloPaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfRuoloPaFindByPfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfRuoloPaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRPfRuoloPaDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R1606297155) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRPfRuoloPa.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPf (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRPfRuoloPaDaoImpl extends AbstractDAO implements SigitRPfRuoloPaDao {
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
	 * Metodo di inserimento del DAO sigitRPfRuoloPa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRPfRuoloPaPk
	 * @generated
	 */

	public SigitRPfRuoloPaPk insert(SigitRPfRuoloPaDto dto)

	{
		LOG.debug("[SigitRPfRuoloPaDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PERSONA_FISICA,ID_RUOLO_PA,ISTAT_ABILITAZIONE,DATA_INIZIO,DATA_FINE,NOTE,DESC_ABILITAZIONE ) VALUES (  :ID_PERSONA_FISICA , :ID_RUOLO_PA , :ISTAT_ABILITAZIONE , :DATA_INIZIO , :DATA_FINE , :NOTE , :DESC_ABILITAZIONE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", dto.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_RUOLO_PA]
		params.addValue("ID_RUOLO_PA", dto.getIdRuoloPa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ISTAT_ABILITAZIONE]
		params.addValue("ISTAT_ABILITAZIONE", dto.getIstatAbilitazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DESC_ABILITAZIONE]
		params.addValue("DESC_ABILITAZIONE", dto.getDescAbilitazione(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitRPfRuoloPaDaoImpl::insert] END");
		return dto.createPk();

	}

	protected SigitRPfRuoloPaDaoRowMapper findByPfRowMapper = new SigitRPfRuoloPaDaoRowMapper(null,
			SigitRPfRuoloPaFindByPfDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_PF_RUOLO_PA";
	}

	/** 
		 * Implementazione del finder findByPf con Qdef
		 * @generated
		 */

	public List<SigitRPfRuoloPaFindByPfDto> findFindByPf(Integer input) throws SigitRPfRuoloPaDaoException {
		LOG.debug("[SigitRPfRuoloPaDaoImpl::findFindByPf] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT rPfRuoloPa.ID_RUOLO_PA, dRuoloPa.DES_RUOLO_PA, rPfRuoloPa.ISTAT_ABILITAZIONE, rPfRuoloPa.DESC_ABILITAZIONE");

		sql.append(" FROM SIGIT_D_RUOLO_PA dRuoloPa, SIGIT_R_PF_RUOLO_PA rPfRuoloPa");

		sql.append(" WHERE ");

		sql.append("dRuoloPa.ID_RUOLO_PA = rPfRuoloPa.ID_RUOLO_PA");

		sql.append(" AND ");

		sql.append("rPfRuoloPa.id_persona_fisica=:idPersonaFisica");

		List<SigitRPfRuoloPaFindByPfDto> list = null;

		paramMap.addValue("idPersonaFisica",input);
		
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByPfRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfRuoloPaDaoImpl::findFindByPf] ERROR esecuzione query", ex);
			throw new SigitRPfRuoloPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfRuoloPaDaoImpl", "findFindByPf", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPfRuoloPaDaoImpl::findFindByPf] END");
		}
		return list;
	}

}
