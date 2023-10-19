package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTRappTipo4Dao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTRappTipo4DaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo4Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo4Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTRappTipo4DaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R-1605518621) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTRappTipo4.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER:
 * - (insert di default)
 * - FINDERS:
 * <p>
 * --
 * - UPDATERS:
 * <p>
 * --
 * - DELETERS:
 * <p>
 * --
 * <p>
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 *
 * @generated
 */
public class SigitTRappTipo4DaoImpl extends AbstractDAO implements SigitTRappTipo4Dao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	/**
	 * Il DAO utilizza JDBC template per l'implementazione delle query.
	 *
	 * @generated
	 */
	protected NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 *
	 * @generated
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Metodo di inserimento del DAO sigitTRappTipo4. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 *
	 * @param dto
	 * @return SigitTRappTipo4Pk
	 * @generated
	 */

	public SigitTRappTipo4Pk insert(SigitTRappTipo4Dto dto) {
		LOG.debug("[SigitTRappTipo4DaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ALLEGATO,D_FLG_LUOGO_IDONEO,D_FLG_VENTILAZ_ADEG,D_FLG_VENTILAZ_LIBERA,D_FLG_LINEA_ELETT_IDONEA,D_FLG_CAMINO_IDONEO,D_FLG_CAPSULA_IDONEA,D_FLG_CIRC_IDR_IDONEO,D_FLG_CIRC_OLIO_IDONEO,D_FLG_CIRC_COMB_IDONEO,D_FLG_FUNZ_SCAMB_IDONEA,F_FLG_ADOZIONE_VALVOLE,F_FLG_ISOLAMENTO_RETE,F_FLG_SISTEMA_TRATT_H2O,F_FLG_SOST_SISTEMA_REGOLAZ,C_FLG_TRATT_CLIMA_NON_RICHIEST ) VALUES (  :ID_ALLEGATO , :D_FLG_LUOGO_IDONEO , :D_FLG_VENTILAZ_ADEG , :D_FLG_VENTILAZ_LIBERA , :D_FLG_LINEA_ELETT_IDONEA , :D_FLG_CAMINO_IDONEO , :D_FLG_CAPSULA_IDONEA , :D_FLG_CIRC_IDR_IDONEO , :D_FLG_CIRC_OLIO_IDONEO , :D_FLG_CIRC_COMB_IDONEO , :D_FLG_FUNZ_SCAMB_IDONEA , :F_FLG_ADOZIONE_VALVOLE , :F_FLG_ISOLAMENTO_RETE , :F_FLG_SISTEMA_TRATT_H2O , :F_FLG_SOST_SISTEMA_REGOLAZ , :C_FLG_TRATT_CLIMA_NON_RICHIEST  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_LUOGO_IDONEO]
		params.addValue("D_FLG_LUOGO_IDONEO", dto.getDFlgLuogoIdoneo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_VENTILAZ_ADEG]
		params.addValue("D_FLG_VENTILAZ_ADEG", dto.getDFlgVentilazAdeg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_VENTILAZ_LIBERA]
		params.addValue("D_FLG_VENTILAZ_LIBERA", dto.getDFlgVentilazLibera(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_LINEA_ELETT_IDONEA]
		params.addValue("D_FLG_LINEA_ELETT_IDONEA", dto.getDFlgLineaElettIdonea(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_CAMINO_IDONEO]
		params.addValue("D_FLG_CAMINO_IDONEO", dto.getDFlgCaminoIdoneo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_CAPSULA_IDONEA]
		params.addValue("D_FLG_CAPSULA_IDONEA", dto.getDFlgCapsulaIdonea(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_CIRC_IDR_IDONEO]
		params.addValue("D_FLG_CIRC_IDR_IDONEO", dto.getDFlgCircIdrIdoneo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_CIRC_OLIO_IDONEO]
		params.addValue("D_FLG_CIRC_OLIO_IDONEO", dto.getDFlgCircOlioIdoneo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_CIRC_COMB_IDONEO]
		params.addValue("D_FLG_CIRC_COMB_IDONEO", dto.getDFlgCircCombIdoneo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_FUNZ_SCAMB_IDONEA]
		params.addValue("D_FLG_FUNZ_SCAMB_IDONEA", dto.getDFlgFunzScambIdonea(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_ADOZIONE_VALVOLE]
		params.addValue("F_FLG_ADOZIONE_VALVOLE", dto.getFFlgAdozioneValvole(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_ISOLAMENTO_RETE]
		params.addValue("F_FLG_ISOLAMENTO_RETE", dto.getFFlgIsolamentoRete(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_SISTEMA_TRATT_H2O]
		params.addValue("F_FLG_SISTEMA_TRATT_H2O", dto.getFFlgSistemaTrattH2o(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_SOST_SISTEMA_REGOLAZ]
		params.addValue("F_FLG_SOST_SISTEMA_REGOLAZ", dto.getFFlgSostSistemaRegolaz(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [C_FLG_TRATT_CLIMA_NON_RICHIEST]
		params.addValue("C_FLG_TRATT_CLIMA_NON_RICHIEST", dto.getCFlgTrattClimaNonRichiest(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTRappTipo4DaoImpl::insert] END");
		return dto.createPk();

	}

	public void delete(SigitTRappTipo4Pk pk) throws SigitTRappTipo4DaoException {
		LOG.debug("[SigitTRappTipo4DaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ALLEGATO = :ID_ALLEGATO ";
		if (pk == null) {
			LOG.error("[SigitTRappTipo4DaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTRappTipo4DaoException("Chiave primaria non impostata");
		}
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.NUMERIC);
		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTRappTipo4DaoImpl::delete] END");
	}

	protected SigitTRappTipo4DaoRowMapper findByPrimaryKeyRowMapper = new SigitTRappTipo4DaoRowMapper(null, SigitTRappTipo4Dto.class, this);

	public SigitTRappTipo4Dto findByPrimaryKey(SigitTRappTipo4Pk pk) throws SigitTRappTipo4DaoException {
		LOG.debug("[SigitTRappTipo4DaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALLEGATO,D_FLG_LUOGO_IDONEO,D_FLG_VENTILAZ_ADEG,D_FLG_VENTILAZ_LIBERA,D_FLG_LINEA_ELETT_IDONEA,D_FLG_CAMINO_IDONEO,D_FLG_CAPSULA_IDONEA,D_FLG_CIRC_IDR_IDONEO,D_FLG_CIRC_OLIO_IDONEO,D_FLG_CIRC_COMB_IDONEO,D_FLG_FUNZ_SCAMB_IDONEA,F_FLG_ADOZIONE_VALVOLE,F_FLG_ISOLAMENTO_RETE,F_FLG_SISTEMA_TRATT_H2O,F_FLG_SOST_SISTEMA_REGOLAZ,C_FLG_TRATT_CLIMA_NON_RICHIEST FROM "
						+ getTableName() + " WHERE ID_ALLEGATO = :ID_ALLEGATO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.NUMERIC);

		List<SigitTRappTipo4Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTRappTipo4DaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTRappTipo4DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTRappTipo4DaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTRappTipo4DaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * Restituisce il nome della tabella su cui opera il DAO
	 *
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_RAPP_TIPO4";
	}

}
