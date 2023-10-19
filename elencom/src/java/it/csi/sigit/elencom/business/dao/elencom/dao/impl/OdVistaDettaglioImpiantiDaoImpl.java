package it.csi.sigit.elencom.business.dao.elencom.dao.impl;

import it.csi.sigit.elencom.business.dao.elencom.dao.*;
import it.csi.sigit.elencom.business.dao.elencom.dao.mapper.*;
import it.csi.sigit.elencom.business.dao.elencom.dto.*;
import it.csi.sigit.elencom.business.dao.elencom.qbe.*;
import it.csi.sigit.elencom.business.dao.elencom.metadata.*;
import it.csi.sigit.elencom.business.dao.elencom.exceptions.*;
import it.csi.sigit.elencom.business.dao.impl.*;
import it.csi.sigit.elencom.business.dao.util.*;
import it.csi.sigit.elencom.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R672623033) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO odVistaDettaglioImpianti.
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
public class OdVistaDettaglioImpiantiDaoImpl extends AbstractDAO implements OdVistaDettaglioImpiantiDao {
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

	protected OdVistaDettaglioImpiantiDaoRowMapper findByFilterRowMapper = new OdVistaDettaglioImpiantiDaoRowMapper(
			null, OdVistaDettaglioImpiantiDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "OD_VISTA_DETTAGLIO_IMPIANTI";
	}

	/** 
	 * Implementazione del finder findByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<OdVistaDettaglioImpiantiDto> findFindByFilter(
			it.csi.sigit.elencom.business.dao.elencom.dto.OdVistaDettaglioImpiantiDto input)
			throws OdVistaDettaglioImpiantiDaoException {
		LOG.debug("[OdVistaDettaglioImpiantiDaoImpl::findFindByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,DENOMINAZIONE_COMUNE,DENOMINAZIONE_PROVINCIA,L1_2_FK_CATEGORIA,L1_2_VOL_RISC_M3,L1_2_VOL_RAFF_M3,l1_3_pot_h2o_kw,l1_3_pot_clima_inv_kw,l1_3_pot_clima_est_kw,tipo_componente,progressivo,data_install,des_marca,des_combustibile,des_dettaglio,potenza,rendimento_perc,data_controllo,e_nox_ppm,e_nox_mg_kwh,e_n_modulo_termico,flg_no_opendata,indirizzo_unita_immob,civico,sezione,foglio,particella,subalterno,pod_elettrico,pdr_gas,e_nox_mg_nm3,coord_x_long_dd,coord_y_lat_dd,flg_tipo_impianto ");
		sql.append(" FROM OD_VISTA_DETTAGLIO_IMPIANTI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R450197545) ENABLED START*/
		sql.append("coord_x_long_dd = :coord_x_long_dd");
		sql.append(" and coord_y_lat_dd = :coord_y_lat_dd");
		sql.append(" AND tipo_componente=:tipo_componente");
		sql.append(" AND flg_no_opendata=:flg_no_opendata");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-272036209) ENABLED START*/
		paramMap.addValue("coord_x_long_dd", input.getCoordXLongDd());
		paramMap.addValue("coord_y_lat_dd", input.getCoordYLatDd());
		paramMap.addValue("tipo_componente", input.getTipoComponente());
		paramMap.addValue("flg_no_opendata", 0);

		/*PROTECTED REGION END*/
		List<OdVistaDettaglioImpiantiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[OdVistaDettaglioImpiantiDaoImpl::findFindByFilter] esecuzione query", ex);
			throw new OdVistaDettaglioImpiantiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("OdVistaDettaglioImpiantiDaoImpl", "findFindByFilter", "esecuzione query",
					sql.toString());
			LOG.debug("[OdVistaDettaglioImpiantiDaoImpl::findFindByFilter] END");
		}
		return list;
	}

}
