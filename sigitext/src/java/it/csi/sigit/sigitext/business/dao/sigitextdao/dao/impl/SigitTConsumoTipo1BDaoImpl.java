package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTConsumoTipo1BDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTConsumoTipo1BDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTConsumoTipo1BDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTConsumoTipo1BPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTConsumoTipo1BDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.sigit.sigitext.business.util.GenericUtil;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R-1423241437) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTConsumoTipo1B.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 
 *    --
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTConsumoTipo1BDaoImpl extends AbstractDAO implements SigitTConsumoTipo1BDao {
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
	 * Metodo di inserimento del DAO sigitTConsumoTipo1B. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTConsumoTipo1BPk
	 * @generated
	 */

	public SigitTConsumoTipo1BPk insert(SigitTConsumoTipo1BDto dto)

	{
		LOG.debug("[SigitTConsumoTipo1BDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_CONSUMO_TIPO1B,ESERCIZIO,LETTURA_INIZIALE,LETTURA_FINALE,CONSUMO,FK_ALLEGATO,ID_TIPO_CONSUMO_1B,ID_UNITA_MISURA ) VALUES (  :ID_CONSUMO_TIPO1B , :ESERCIZIO , :LETTURA_INIZIALE , :LETTURA_FINALE , :CONSUMO , :FK_ALLEGATO , :ID_TIPO_CONSUMO_1B , :ID_UNITA_MISURA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONSUMO_TIPO1B]
		params.addValue("ID_CONSUMO_TIPO1B", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ESERCIZIO]
		params.addValue("ESERCIZIO", dto.getEsercizio(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [LETTURA_INIZIALE]
		params.addValue("LETTURA_INIZIALE", dto.getLetturaIniziale(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [LETTURA_FINALE]
		params.addValue("LETTURA_FINALE", dto.getLetturaFinale(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CONSUMO]
		params.addValue("CONSUMO", dto.getConsumo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_ALLEGATO]
		params.addValue("FK_ALLEGATO", dto.getFkAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_CONSUMO_1B]
		params.addValue("ID_TIPO_CONSUMO_1B", dto.getIdTipoConsumo1b(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_UNITA_MISURA]
		params.addValue("ID_UNITA_MISURA", dto.getIdUnitaMisura(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdConsumoTipo1b(newKey);
		LOG.debug("[SigitTConsumoTipo1BDaoImpl::insert] END");
		return dto.createPk();

	}

	public void customDeleterDeleteByIdAllegato(java.math.BigDecimal filter) throws SigitTConsumoTipo1BDaoException {
		LOG.debug("[SigitTConsumoTipo1BDaoImpl::customDeleterDeleteByIdAllegato] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE FK_ALLEGATO = :fk_allegato";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("fk_allegato", filter);
		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTConsumoTipo1BDaoImpl::customDeleterDeleteByIdAllegato] END");
	}

	protected SigitTConsumoTipo1BDaoRowMapper byFilterRowMapper = new SigitTConsumoTipo1BDaoRowMapper(null,
			SigitTConsumoTipo1BDto.class, this);
	public List<SigitTConsumoTipo1BDto> findByFilter(SigitTConsumoTipo1BDto input)
			throws SigitTConsumoTipo1BDaoException {
		LOG.debug("[SigitTConsumoTipo1BDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_CONSUMO_TIPO1B,ESERCIZIO,LETTURA_INIZIALE,LETTURA_FINALE,CONSUMO,FK_ALLEGATO,ID_TIPO_CONSUMO_1B,ID_UNITA_MISURA ");
		sql.append(" FROM SIGIT_T_CONSUMO_TIPO1B");
		sql.append(" WHERE ");
		sql.append("1=1");
		if (GenericUtil.isNotNullOrEmpty(input.getFkAllegato())) {
			sql.append(" AND FK_ALLEGATO = :idAllegato");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoConsumo1b())) {
			sql.append(" AND ID_TIPO_CONSUMO_1B = :idTipoConsumo1B");
		}
		if (GenericUtil.isNotNullOrEmpty(input.getFkAllegato())) {
			paramMap.addValue("idAllegato", input.getFkAllegato());
		}
		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoConsumo1b())) {
			paramMap.addValue("idTipoConsumo1B", input.getIdTipoConsumo1b());
		}
		List<SigitTConsumoTipo1BDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTConsumoTipo1BDaoImpl::findByFilter] esecuzione query", ex);
			throw new SigitTConsumoTipo1BDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTConsumoTipo1BDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitTConsumoTipo1BDaoImpl::findByFilter] END");
		}
		return list;
	}

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_CONSUMO_TIPO1B";
	}

}
