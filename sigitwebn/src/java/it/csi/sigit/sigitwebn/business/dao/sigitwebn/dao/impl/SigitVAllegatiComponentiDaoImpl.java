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

/*PROTECTED REGION ID(R-85605465) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVAllegatiComponenti.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - allegatiByFilter (datagen::CustomFinder)
 *   - allegatiByIdAllegato (datagen::CustomFinder)
 *   - allegatiDataContrSysdateByFilter (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitVAllegatiComponentiDaoImpl extends AbstractDAO implements SigitVAllegatiComponentiDao {
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

	protected SigitVAllegatiComponentiDaoRowMapper allegatiByFilterRowMapper = new SigitVAllegatiComponentiDaoRowMapper(
			null, SigitVAllegatiComponentiDto.class, this);

	protected SigitVAllegatiComponentiDaoRowMapper allegatiByIdAllegatoRowMapper = new SigitVAllegatiComponentiDaoRowMapper(
			null, SigitVAllegatiComponentiDto.class, this);

	protected SigitVAllegatiComponentiDaoRowMapper allegatiDataContrSysdateByFilterRowMapper = new SigitVAllegatiComponentiDaoRowMapper(
			null, SigitVAllegatiComponentiDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_ALLEGATI_COMPONENTI";
	}

	/** 
	 * Implementazione del finder allegatiByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVAllegatiComponentiDto> findAllegatiByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.AllegatiCompFilter input)
			throws SigitVAllegatiComponentiDaoException {
		LOG.debug("[SigitVAllegatiComponentiDaoImpl::findAllegatiByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,ID_TIPO_COMPONENTE,PROGRESSIVO,CODICE_IMPIANTO,DATA_INSTALL,FK_IMP_RUOLO_PFPG,FK_CONTRATTO,FK_STATO_RAPP,DES_STATO_RAPP,DATA_CONTROLLO ");
		sql.append(" FROM VISTA_ALLEGATI_COMPONENTI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-24533105) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" CODICE_IMPIANTO = :codImpianto ");

		if (GenericUtil.isNotNullOrEmpty(input.getIdContratto())) {
			sql.append(" AND FK_CONTRATTO = :idContratto ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdImpRuoloPfPg())) {
			sql.append(" AND FK_IMP_RUOLO_PFPG = :idImpRuoloPfpg ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataControllo())) {
			sql.append(" AND DATA_CONTROLLO > :dataControllo");
		}

		if ((input.getStatiRappNotEqual() == null || input.getStatiRappNotEqual().isEmpty())
				&& (input.getStatiRappEqual() == null || input.getStatiRappEqual().isEmpty())) {
			//se nessuna delle due liste e' settata viene scelta la gestione di default
			sql.append(" AND FK_STATO_RAPP != " + Constants.ID_STATO_RAPPORTO_BOZZA); //gestione default
		}

		if (input.getStatiRappNotEqual() != null && !input.getStatiRappNotEqual().isEmpty()) {
			sql.append(" AND FK_STATO_RAPP NOT IN (" + ConvertUtil.getStringByList(input.getStatiRappNotEqual()) + ")");
		}

		if (input.getStatiRappEqual() != null && !input.getStatiRappEqual().isEmpty()) {
			sql.append(" AND FK_STATO_RAPP IN (" + ConvertUtil.getStringByList(input.getStatiRappEqual()) + ")");
		}

		if (input.getComponente() != null) {
			CompFilter filtroComponente = input.getComponente();

			if (GenericUtil.isNotNullOrEmpty(filtroComponente.getProgressivo())) {
				sql.append(" AND PROGRESSIVO = :progressivo ");
			}

			if (GenericUtil.isNotNullOrEmpty(filtroComponente.getDataInstallazione())) {
				sql.append(" AND DATA_INSTALL = :dataInstallazione ");
			}

			if (GenericUtil.isNotNullOrEmpty(filtroComponente.getTipoComponente())) {
				sql.append(" AND ID_TIPO_COMPONENTE = :tipoComponente ");
			}

		}

		//nb: il controllo sull'intervallo di tempo in cui deve essere compresa la data controllo ha senso solo se ci sono entrambi gli estremi dell'intervallo
		if (input.getInizioIntervalloDataControllo() != null && input.getFineIntervalloDataControllo() != null) {
			//si controlla che la data controllo sia inclusa in questo intervallo
			sql.append(" AND DATA_CONTROLLO BETWEEN :dataInizioControllo AND :dataFineControllo");
		}

		/*PROTECTED REGION END*/

		sql.append(" ORDER BY DATA_CONTROLLO ASC"); /*PROTECTED REGION ID(R120037523) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);

		if (GenericUtil.isNotNullOrEmpty(input.getIdContratto())) {
			paramMap.addValue("idContratto", input.getIdContratto(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdImpRuoloPfPg())) {
			paramMap.addValue("idImpRuoloPfpg", input.getIdImpRuoloPfPg(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataControllo())) {
			paramMap.addValue("dataControllo", input.getDataControllo(), java.sql.Types.DATE);
		}

		if (input.getComponente() != null) {
			CompFilter filtroComponente = input.getComponente();

			if (GenericUtil.isNotNullOrEmpty(filtroComponente.getProgressivo())) {
				paramMap.addValue("progressivo", filtroComponente.getProgressivo(), java.sql.Types.NUMERIC);
			}

			if (GenericUtil.isNotNullOrEmpty(filtroComponente.getDataInstallazione())) {
				paramMap.addValue("dataInstallazione", filtroComponente.getDataInstallazione(), java.sql.Types.DATE);
			}

			if (GenericUtil.isNotNullOrEmpty(filtroComponente.getTipoComponente())) {
				paramMap.addValue("tipoComponente", filtroComponente.getTipoComponente());
			}

		}

		if (input.getInizioIntervalloDataControllo() != null && input.getFineIntervalloDataControllo() != null) {
			paramMap.addValue("dataInizioControllo", input.getInizioIntervalloDataControllo());
			paramMap.addValue("dataFineControllo", input.getFineIntervalloDataControllo());
		}

		/*PROTECTED REGION END*/
		List<SigitVAllegatiComponentiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, allegatiByFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVAllegatiComponentiDaoImpl::findAllegatiByFilter] esecuzione query", ex);
			throw new SigitVAllegatiComponentiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVAllegatiComponentiDaoImpl", "findAllegatiByFilter", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVAllegatiComponentiDaoImpl::findAllegatiByFilter] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder allegatiByIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVAllegatiComponentiDto> findAllegatiByIdAllegato(java.math.BigDecimal input)
			throws SigitVAllegatiComponentiDaoException {
		LOG.debug("[SigitVAllegatiComponentiDaoImpl::findAllegatiByIdAllegato] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,ID_TIPO_COMPONENTE,PROGRESSIVO,CODICE_IMPIANTO,DATA_INSTALL,FK_IMP_RUOLO_PFPG,FK_CONTRATTO,FK_STATO_RAPP,DES_STATO_RAPP,DATA_CONTROLLO ");
		sql.append(" FROM VISTA_ALLEGATI_COMPONENTI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-280690037) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("  ID_ALLEGATO = :idAllegato ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R769107223) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idAllegato", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVAllegatiComponentiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, allegatiByIdAllegatoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVAllegatiComponentiDaoImpl::findAllegatiByIdAllegato] esecuzione query", ex);
			throw new SigitVAllegatiComponentiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVAllegatiComponentiDaoImpl", "findAllegatiByIdAllegato", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVAllegatiComponentiDaoImpl::findAllegatiByIdAllegato] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder allegatiDataContrSysdateByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVAllegatiComponentiDto> findAllegatiDataContrSysdateByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.AllegatiCompFilter input)
			throws SigitVAllegatiComponentiDaoException {
		LOG.debug("[SigitVAllegatiComponentiDaoImpl::findAllegatiDataContrSysdateByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,ID_TIPO_COMPONENTE,PROGRESSIVO,CODICE_IMPIANTO,DATA_INSTALL,FK_IMP_RUOLO_PFPG,FK_CONTRATTO,FK_STATO_RAPP,DES_STATO_RAPP,DATA_CONTROLLO ");
		sql.append(" FROM VISTA_ALLEGATI_COMPONENTI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1112202004) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_IMPIANTO = :codImpianto ");

		sql.append(" AND DATA_CONTROLLO = CURRENT_DATE");

		if (input.getComponente() != null) {
			CompFilter filtroComponente = input.getComponente();

			if (filtroComponente.getListProgressivi() != null && !filtroComponente.getListProgressivi().isEmpty()) {
				sql.append(" AND PROGRESSIVO IN  (");
				boolean aggVirg = false;
				for (String progr : filtroComponente.getListProgressivi()) {
					if (aggVirg)
						sql.append(", ");
					sql.append(progr);
					aggVirg = true;
				}
				sql.append(") ");
			}

			if (GenericUtil.isNotNullOrEmpty(filtroComponente.getTipoComponente())) {
				sql.append(" AND ID_TIPO_COMPONENTE = :tipoComponente ");
			}

		}

		/*PROTECTED REGION END*/

		sql.append(" ORDER BY DATA_CONTROLLO ASC"); /*PROTECTED REGION ID(R999087534) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);

		if (input.getComponente() != null) {
			CompFilter filtroComponente = input.getComponente();

			if (GenericUtil.isNotNullOrEmpty(filtroComponente.getTipoComponente())) {
				paramMap.addValue("tipoComponente", filtroComponente.getTipoComponente());
			}

		}

		/*PROTECTED REGION END*/
		List<SigitVAllegatiComponentiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, allegatiDataContrSysdateByFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVAllegatiComponentiDaoImpl::findAllegatiDataContrSysdateByFilter] esecuzione query", ex);
			throw new SigitVAllegatiComponentiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVAllegatiComponentiDaoImpl", "findAllegatiDataContrSysdateByFilter",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitVAllegatiComponentiDaoImpl::findAllegatiDataContrSysdateByFilter] END");
		}
		return list;
	}

}
