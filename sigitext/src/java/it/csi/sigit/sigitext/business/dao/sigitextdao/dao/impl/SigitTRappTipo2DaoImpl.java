package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTRappTipo2Dao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTRappTipo2DaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo2Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo2Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTRappTipo2DaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R638464675) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTRappTipo2.
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
public class SigitTRappTipo2DaoImpl extends AbstractDAO implements SigitTRappTipo2Dao {
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
	 * Metodo di inserimento del DAO sigitTRappTipo2. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTRappTipo2Pk
	 * @generated
	 */

	public SigitTRappTipo2Pk insert(SigitTRappTipo2Dto dto)

	{
		LOG.debug("[SigitTRappTipo2DaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ALLEGATO,D_FLG_LOCALE_IDONEO,D_FLG_APERTURE_LIBERE,D_FLG_APERTURE_ADEG,D_FLG_LINEA_ELETT_IDONEA,F_FLG_SOSTITUZ_GENERATORI,F_FLG_SOSTITUZ_SISTEMI_REG,F_FLG_ISOL_DISTRIBUZ_H2O,F_FLG_ISOL_DISTRIBUZ_ARIA,C_FLG_TRATT_CLIMA_NON_RICHIEST,D_FLG_COIB_IDONEA ) VALUES (  :ID_ALLEGATO , :D_FLG_LOCALE_IDONEO , :D_FLG_APERTURE_LIBERE , :D_FLG_APERTURE_ADEG , :D_FLG_LINEA_ELETT_IDONEA , :F_FLG_SOSTITUZ_GENERATORI , :F_FLG_SOSTITUZ_SISTEMI_REG , :F_FLG_ISOL_DISTRIBUZ_H2O , :F_FLG_ISOL_DISTRIBUZ_ARIA , :C_FLG_TRATT_CLIMA_NON_RICHIEST , :D_FLG_COIB_IDONEA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_LOCALE_IDONEO]
		params.addValue("D_FLG_LOCALE_IDONEO", dto.getDFlgLocaleIdoneo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_APERTURE_LIBERE]
		params.addValue("D_FLG_APERTURE_LIBERE", dto.getDFlgApertureLibere(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_APERTURE_ADEG]
		params.addValue("D_FLG_APERTURE_ADEG", dto.getDFlgApertureAdeg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_LINEA_ELETT_IDONEA]
		params.addValue("D_FLG_LINEA_ELETT_IDONEA", dto.getDFlgLineaElettIdonea(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_SOSTITUZ_GENERATORI]
		params.addValue("F_FLG_SOSTITUZ_GENERATORI", dto.getFFlgSostituzGeneratori(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_SOSTITUZ_SISTEMI_REG]
		params.addValue("F_FLG_SOSTITUZ_SISTEMI_REG", dto.getFFlgSostituzSistemiReg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_ISOL_DISTRIBUZ_H2O]
		params.addValue("F_FLG_ISOL_DISTRIBUZ_H2O", dto.getFFlgIsolDistribuzH2o(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_ISOL_DISTRIBUZ_ARIA]
		params.addValue("F_FLG_ISOL_DISTRIBUZ_ARIA", dto.getFFlgIsolDistribuzAria(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [C_FLG_TRATT_CLIMA_NON_RICHIEST]
		params.addValue("C_FLG_TRATT_CLIMA_NON_RICHIEST", dto.getCFlgTrattClimaNonRichiest(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_COIB_IDONEA]
		params.addValue("D_FLG_COIB_IDONEA", dto.getDFlgCoibIdonea(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTRappTipo2DaoImpl::insert] END");
		return dto.createPk();

	}

	public void delete(SigitTRappTipo2Pk pk) throws SigitTRappTipo2DaoException {
		LOG.debug("[SigitTRappTipo2DaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ALLEGATO = :ID_ALLEGATO ";
		if (pk == null) {
			LOG.error("[SigitTRappTipo2DaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTRappTipo2DaoException("Chiave primaria non impostata");
		}
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.NUMERIC);
		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTRappTipo2DaoImpl::delete] END");
	}

	protected SigitTRappTipo2DaoRowMapper findByPrimaryKeyRowMapper = new SigitTRappTipo2DaoRowMapper(null,
			SigitTRappTipo2Dto.class, this);
	public SigitTRappTipo2Dto findByPrimaryKey(SigitTRappTipo2Pk pk) throws SigitTRappTipo2DaoException {
		LOG.debug("[SigitTRappTipo2DaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALLEGATO,D_FLG_LOCALE_IDONEO,D_FLG_APERTURE_LIBERE,D_FLG_APERTURE_ADEG,D_FLG_LINEA_ELETT_IDONEA,F_FLG_SOSTITUZ_GENERATORI,F_FLG_SOSTITUZ_SISTEMI_REG,F_FLG_ISOL_DISTRIBUZ_H2O,F_FLG_ISOL_DISTRIBUZ_ARIA,C_FLG_TRATT_CLIMA_NON_RICHIEST,D_FLG_COIB_IDONEA FROM "
						+ getTableName() + " WHERE ID_ALLEGATO = :ID_ALLEGATO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.NUMERIC);

		List<SigitTRappTipo2Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTRappTipo2DaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTRappTipo2DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTRappTipo2DaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTRappTipo2DaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_RAPP_TIPO2";
	}

}
