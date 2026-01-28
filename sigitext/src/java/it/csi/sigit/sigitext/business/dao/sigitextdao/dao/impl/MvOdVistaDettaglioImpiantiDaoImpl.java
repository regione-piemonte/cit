package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.MvOdVistaDettaglioImpiantiDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.MvOdVistaDettaglioImpiantiDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.MvOdVistaDettaglioImpiantiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.MvOdVistaDettaglioImpiantiDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.util.performance.StopWatch;

/*PROTECTED REGION ID(R-1285143669) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO mvOdVistaDettaglioImpianti.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByFilter (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class MvOdVistaDettaglioImpiantiDaoImpl extends AbstractDAO implements MvOdVistaDettaglioImpiantiDao {
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

	protected MvOdVistaDettaglioImpiantiDaoRowMapper findByFilterRowMapper = new MvOdVistaDettaglioImpiantiDaoRowMapper(
			null, MvOdVistaDettaglioImpiantiDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "MV_OD_VISTA_DETTAGLIO_IMPIANTI";
	}

	/** 
	 * Implementazione del finder findByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<MvOdVistaDettaglioImpiantiDto> findFindByFilter(MvOdVistaDettaglioImpiantiDto input)
			throws MvOdVistaDettaglioImpiantiDaoException {
		LOG.debug("[MvOdVistaDettaglioImpiantiDaoImpl::findFindByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,DENOMINAZIONE_COMUNE,DENOMINAZIONE_PROVINCIA,L1_2_FK_CATEGORIA,L1_2_VOL_RISC_M3,L1_2_VOL_RAFF_M3,l1_3_pot_h2o_kw,l1_3_pot_clima_inv_kw,l1_3_pot_clima_est_kw,tipo_componente,progressivo,data_install,des_marca,des_combustibile,des_dettaglio,potenza,rendimento_perc,data_controllo,e_nox_ppm,e_nox_mg_kwh,e_n_modulo_termico,flg_no_opendata,indirizzo_unita_immob,civico,sezione,foglio,particella,subalterno,pod_elettrico,pdr_gas,e_nox_mg_nm3,coord_x_long_dd,coord_y_lat_dd,flg_tipo_impianto ");
		sql.append(" FROM MV_OD_VISTA_DETTAGLIO_IMPIANTI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1751529778) ENABLED START*/
		sql.append("coord_x_long_dd = :coord_x_long_dd");
		sql.append(" and coord_y_lat_dd = :coord_y_lat_dd");
		sql.append(" AND tipo_componente=:tipo_componente");
		sql.append(" AND flg_no_opendata=:flg_no_opendata");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1414557350) ENABLED START*/
		paramMap.addValue("coord_x_long_dd", input.getCoordXLongDd());
		paramMap.addValue("coord_y_lat_dd", input.getCoordYLatDd());
		paramMap.addValue("tipo_componente", input.getTipoComponente());
		paramMap.addValue("flg_no_opendata", 0);
		/*PROTECTED REGION END*/
		List<MvOdVistaDettaglioImpiantiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[MvOdVistaDettaglioImpiantiDaoImpl::findFindByFilter] esecuzione query", ex);
			throw new MvOdVistaDettaglioImpiantiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("MvOdVistaDettaglioImpiantiDaoImpl", "findFindByFilter", "esecuzione query",
					sql.toString());
			LOG.debug("[MvOdVistaDettaglioImpiantiDaoImpl::findFindByFilter] END");
		}
		return list;
	}

}
