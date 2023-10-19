package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTComp4Dao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.ControlloDisponibileRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTComp4DaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.ControlloDisponibileDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTComp4Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTComp4Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTComp4DaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.sigit.sigitext.business.util.GenericUtil;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.Date;
import java.util.List;

/*PROTECTED REGION ID(R-1755676829) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTComp4.
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
 * - ByCodImpianto (datagen::CustomDeleter)
 * <p>
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 *
 * @generated
 */
public class SigitTComp4DaoImpl extends AbstractDAO implements SigitTComp4Dao {
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

	protected SigitTComp4DaoRowMapper componentiCancellateRowMapper = new SigitTComp4DaoRowMapper(null, SigitTComp4Dto.class, this);
	/**
	 * Metodo di inserimento del DAO sigitTComp4. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 *
	 * @param dto
	 * @return SigitTComp4Pk
	 * @generated
	 */

	protected SigitTComp4DaoRowMapper findByPrimaryKeyRowMapper = new SigitTComp4DaoRowMapper(null, SigitTComp4Dto.class, this);

	protected ControlloDisponibileRowMapper findByfilter = new ControlloDisponibileRowMapper(null, ControlloDisponibileDto.class, this);

	public SigitTComp4Pk insert(SigitTComp4Dto dto) {
		LOG.debug("[SigitTComp4DaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DT_CONTROLLOWEB ) VALUES (  :CODICE_IMPIANTO , :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DT_CONTROLLOWEB  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_CONTROLLOWEB]
		params.addValue("DT_CONTROLLOWEB", dto.getDtControlloweb(), java.sql.Types.TIMESTAMP);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTComp4DaoImpl::insert] END");
		return dto.createPk();

	}

	/**
	 * Custom deleter in the SIGIT_T_COMP4 table.
	 *
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTComp4DaoException {
		LOG.debug("[SigitTComp4DaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R-1625133861) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTComp4DaoImpl::customDeleterByCodImpianto] END");
	}

	public SigitTComp4Dto findByPrimaryKey(SigitTComp4Pk pk) throws SigitTComp4DaoException {
		LOG.debug("[SigitTComp4DaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DT_CONTROLLOWEB FROM " + getTableName()
				+ " WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO  AND ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", pk.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", pk.getProgressivo(), java.sql.Types.NUMERIC);

		List<SigitTComp4Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTComp4DaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTComp4DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTComp4DaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTComp4DaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	public void update(SigitTComp4Dto dto) throws SigitTComp4DaoException {
		LOG.debug("[SigitTComp4DaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DT_CONTROLLOWEB = :DT_CONTROLLOWEB  WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO  AND ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO ";

		if (dto.getCodiceImpianto() == null || dto.getIdTipoComponente() == null || dto.getProgressivo() == null) {
			LOG.error("[SigitTComp4DaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTComp4DaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_CONTROLLOWEB]
		params.addValue("DT_CONTROLLOWEB", dto.getDtControlloweb(), java.sql.Types.TIMESTAMP);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTComp4DaoImpl::update] END");
	}

	public void delete(SigitTComp4Pk pk) throws SigitTComp4DaoException {
		LOG.debug("[SigitTComp4DaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO  AND ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO ";

		if (pk == null) {
			LOG.error("[SigitTComp4DaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTComp4DaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", pk.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", pk.getProgressivo(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTComp4DaoImpl::delete] END");
	}

	@Override
	public List<ControlloDisponibileDto> getControlliDisponibili(String codiceImpianto, String idTipoComp, Date dataRapporto, Integer idPersonaGiuridica) throws SigitTComp4DaoException {
		LOG.debug("[SigitTComp4DaoImpl::getControlliDisponibili] START");
		StringBuilder sql = new StringBuilder("");
		switch (idTipoComp) {
			case it.csi.sigit.sigitext.business.util.Constants.TIPO_COMPONENTE_GT:
				sql.append("SELECT cm.ID_R_COMP4_MANUT, cm.FK_PERSONA_GIURIDICA, c.ID_TIPO_COMPONENTE,c.PROGRESSIVO, m.DES_MARCA, comp.MODELLO, d.des_dettaglio_gt, combu.des_combustibile, comp.n_moduli,comp.MATRICOLA, comp.potenza_termica_kw, comp.data_install, pg.codice_fiscale, pg.numero_rea, pg.sigla_rea ");
				sql.append("FROM SIGIT_T_COMP4 c join SIGIT_R_COMP4_MANUT cm on c.CODICE_IMPIANTO = cm.CODICE_IMPIANTO AND c.ID_TIPO_COMPONENTE = cm.ID_TIPO_COMPONENTE AND c.PROGRESSIVO = cm.PROGRESSIVO ");
				sql.append("join SIGIT_T_COMP_GT comp on c.CODICE_IMPIANTO = comp.CODICE_IMPIANTO AND c.ID_TIPO_COMPONENTE = comp.ID_TIPO_COMPONENTE AND c.PROGRESSIVO = comp.PROGRESSIVO ");
				sql.append("join SIGIT_T_PERSONA_GIURIDICA pg on pg.id_persona_giuridica = cm.fk_persona_giuridica ");
				sql.append("left join SIGIT_D_MARCA m on comp.FK_MARCA = m.ID_MARCA ");
				sql.append("left join SIGIT_D_DETTAGLIO_GT d on d.ID_DETTAGLIO_GT = comp.fk_dettaglio_gt ");
				sql.append("left join SIGIT_D_COMBUSTIBILE combu on combu.id_combustibile = comp.fk_combustibile ");
				sql.append("WHERE c.CODICE_IMPIANTO = :codImpianto AND c.ID_TIPO_COMPONENTE = :tipoComp AND :dataRapporto BETWEEN comp.DATA_INSTALL AND COALESCE(comp.DATA_DISMISS, :dataRapporto)");
				break;
			case it.csi.sigit.sigitext.business.util.Constants.TIPO_COMPONENTE_GF:
				sql.append("select cm.ID_R_COMP4_MANUT,cm.FK_PERSONA_GIURIDICA,c.ID_TIPO_COMPONENTE,c.PROGRESSIVO,m.DES_MARCA,comp.MODELLO,d.des_dettaglio_gf,comp.raff_potenza_kw,comp.risc_potenza_kw,comp.n_circuiti,comp.MATRICOLA, comp.potenza_termica_kw, comp.data_install, pg.codice_fiscale, pg.numero_rea, pg.sigla_rea ");
				sql.append("from SIGIT_T_COMP4 c join SIGIT_R_COMP4_MANUT cm on c.CODICE_IMPIANTO = cm.CODICE_IMPIANTO and c.ID_TIPO_COMPONENTE = cm.ID_TIPO_COMPONENTE and c.PROGRESSIVO = cm.PROGRESSIVO ");
				sql.append("join SIGIT_T_COMP_GF comp on c.CODICE_IMPIANTO = comp.CODICE_IMPIANTO and c.ID_TIPO_COMPONENTE = comp.ID_TIPO_COMPONENTE and c.PROGRESSIVO = comp.PROGRESSIVO ");
				sql.append("join SIGIT_T_PERSONA_GIURIDICA pg on pg.id_persona_giuridica = cm.fk_persona_giuridica ");
				sql.append("left join SIGIT_D_MARCA m on comp.FK_MARCA = m.ID_MARCA ");
				sql.append("left join SIGIT_D_DETTAGLIO_GF d on  d.ID_DETTAGLIO_GF = comp.fk_dettaglio_gf ");
				sql.append("where c.CODICE_IMPIANTO = :codImpianto and c.ID_TIPO_COMPONENTE = :tipoComp and :dataRapporto between comp.DATA_INSTALL and coalesce(comp.DATA_DISMISS, :dataRapporto)");
				break;
			case it.csi.sigit.sigitext.business.util.Constants.TIPO_COMPONENTE_SC:
				sql.append("select cm.ID_R_COMP4_MANUT,cm.FK_PERSONA_GIURIDICA,c.ID_TIPO_COMPONENTE,c.PROGRESSIVO,m.DES_MARCA,comp.MODELLO,comp.MATRICOLA, comp.potenza_termica_kw, comp.data_install, pg.codice_fiscale, pg.numero_rea, pg.sigla_rea ");
				sql.append("from SIGIT_T_COMP4 c join SIGIT_R_COMP4_MANUT cm on c.CODICE_IMPIANTO = cm.CODICE_IMPIANTO and c.ID_TIPO_COMPONENTE = cm.ID_TIPO_COMPONENTE and c.PROGRESSIVO = cm.PROGRESSIVO ");
				sql.append("join SIGIT_T_COMP_SC comp on c.CODICE_IMPIANTO = comp.CODICE_IMPIANTO and c.ID_TIPO_COMPONENTE = comp.ID_TIPO_COMPONENTE and c.PROGRESSIVO = comp.PROGRESSIVO ");
				sql.append("join SIGIT_T_PERSONA_GIURIDICA pg on pg.id_persona_giuridica = cm.fk_persona_giuridica ");
				sql.append("left join SIGIT_D_MARCA m on comp.FK_MARCA = m.ID_MARCA ");
				sql.append("where c.CODICE_IMPIANTO = :codImpianto and c.ID_TIPO_COMPONENTE = :tipoComp and :dataRapporto between comp.DATA_INSTALL and coalesce(comp.DATA_DISMISS, :dataRapporto)");
				break;
			case it.csi.sigit.sigitext.business.util.Constants.TIPO_COMPONENTE_CG:
				sql.append("select cm.ID_R_COMP4_MANUT,cm.FK_PERSONA_GIURIDICA,c.ID_TIPO_COMPONENTE,c.PROGRESSIVO,m.DES_MARCA,comp.MODELLO,comp.MATRICOLA, comp.potenza_termica_kw, comp.data_install, comp.co_min, comp.co_max, comp.alimentazione,comp.tipologia, pg.codice_fiscale, pg.numero_rea, pg.sigla_rea ");
				sql.append("from SIGIT_T_COMP4 c join SIGIT_R_COMP4_MANUT cm on c.CODICE_IMPIANTO = cm.CODICE_IMPIANTO and c.ID_TIPO_COMPONENTE = cm.ID_TIPO_COMPONENTE and c.PROGRESSIVO = cm.PROGRESSIVO ");
				sql.append("join SIGIT_T_COMP_CG comp on c.CODICE_IMPIANTO = comp.CODICE_IMPIANTO and c.ID_TIPO_COMPONENTE = comp.ID_TIPO_COMPONENTE and c.PROGRESSIVO = comp.PROGRESSIVO ");
				sql.append("join SIGIT_T_PERSONA_GIURIDICA pg on pg.id_persona_giuridica = cm.fk_persona_giuridica ");
				sql.append("left join SIGIT_D_MARCA m on comp.FK_MARCA = m.ID_MARCA ");
				sql.append("where c.CODICE_IMPIANTO = :codImpianto and c.ID_TIPO_COMPONENTE = :tipoComp and :dataRapporto between comp.DATA_INSTALL and coalesce(comp.DATA_DISMISS, :dataRapporto)");
				break;
		}
		if (idPersonaGiuridica != null) {
			sql.append(" AND cm.FK_PERSONA_GIURIDICA = :idPersonaGiuridica");
		}
		sql.append(" AND cm.DATA_FINE IS null ORDER BY PROGRESSIVO ASC, comp.DATA_INSTALL DESC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("codImpianto", codiceImpianto, java.sql.Types.NUMERIC);
		params.addValue("tipoComp", idTipoComp, Types.VARCHAR);
		params.addValue("dataRapporto", dataRapporto, Types.DATE);
		params.addValue("idPersonaGiuridica", idPersonaGiuridica, java.sql.Types.NUMERIC);

		List<ControlloDisponibileDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByfilter);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTComp4DaoImpl::getControlliDisponibili] ERROR esecuzione query", ex);
			throw new SigitTComp4DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTComp4DaoImpl", "getControlliDisponibili", "esecuzione query", sql.toString());
			LOG.debug("[SigitTComp4DaoImpl::getControlliDisponibili] END");
		}
		return list;
	}

	@Override
	public List<SigitTComp4Dto> getAllOrderedByProgrDesc(String codiceImpianto, String tipoComponente) throws SigitTComp4DaoException {
		LOG.debug("[SigitTComp4DaoImpl::getAllOrderedByProgrDesc] START");
		StringBuilder sql = new StringBuilder("");
		sql.append("Select * from ").append(getTableName()).append(" where codice_impianto = :cod and id_tipo_componente = :tipo");
		sql.append(" ORDER BY PROGRESSIVO DESC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("cod", codiceImpianto, java.sql.Types.NUMERIC);
		params.addValue("tipo", tipoComponente, Types.VARCHAR);

		List<SigitTComp4Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTComp4DaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTComp4DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTComp4DaoImpl", "getAllOrderedByProgrDesc", "esecuzione query", sql.toString());
			LOG.debug("[SigitTComp4DaoImpl::getAllOrderedByProgrDesc] END");
		}
		return list;
	}

	@Override
	public List<SigitTComp4Dto> findComponentiCancellate(CompFilter input) throws SigitTComp4DaoException {
		LOG.debug("[SigitTComp4DaoImpl::findComponentiCancellate] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DT_CONTROLLOWEB ");
		sql.append(" FROM SIGIT_T_COMP4");
		sql.append(" WHERE ");
		sql.append("CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND ID_TIPO_COMPONENTE = :tipoComponente");
		if (GenericUtil.isNotNullOrEmpty(input.getProgressivo()))
			sql.append(" AND PROGRESSIVO = :progressivo");
		if (input.getListProgressivi() != null && !input.getListProgressivi().isEmpty()) {
			sql.append(" AND PROGRESSIVO NOT IN  (");
			boolean aggVirg = false;
			for (String progr : input.getListProgressivi()) {
				if (aggVirg)
					sql.append(", ");
				sql.append(progr);
				aggVirg = true;
			}
			sql.append(") ");
		}
		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("tipoComponente", input.getTipoComponente(), java.sql.Types.VARCHAR);
		paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);
		List<SigitTComp4Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, componentiCancellateRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTComp4DaoImpl::findComponentiCancellate] esecuzione query", ex);
			throw new SigitTComp4DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTComp4DaoImpl", "findComponentiCancellate", "esecuzione query", sql.toString());
			LOG.debug("[SigitTComp4DaoImpl::findComponentiCancellate] END");
		}
		return list;
	}

	protected SigitTComp4DaoRowMapper nonControllateByCodImpRowMapper = new SigitTComp4DaoRowMapper(null, SigitTComp4Dto.class, this);
	@Override
	public List<SigitTComp4Dto> findNonControllateByCodImp(Integer input) throws SigitTComp4DaoException {
		LOG.debug("[SigitTComp4DaoImpl::findNonControllateByCodImp] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DT_CONTROLLOWEB ");
		sql.append(" FROM SIGIT_T_COMP4");
		sql.append(" WHERE ");
		sql.append(" CODICE_IMPIANTO = :codImpianto ");
		sql.append(" AND DT_CONTROLLOWEB is null ");
		sql.append(" ORDER BY ID_TIPO_COMPONENTE, PROGRESSIVO");
		paramMap.addValue("codImpianto", input);
		List<SigitTComp4Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, nonControllateByCodImpRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTComp4DaoImpl::findNonControllateByCodImp] esecuzione query", ex);
			throw new SigitTComp4DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTComp4DaoImpl", "findNonControllateByCodImp", "esecuzione query", sql.toString());
			LOG.debug("[SigitTComp4DaoImpl::findNonControllateByCodImp] END");
		}
		return list;
	}

	public String getTableName() {
		return "SIGIT_T_COMP4";
	}

}
