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

/*PROTECTED REGION ID(R-1176454757) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;

/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVRicerca3Responsabile.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byFkPgPf (datagen::CustomFinder)
 *   - byFkPgPfConta (datagen::CustomFinder)
 *   - byFkPgPfRow (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitVRicerca3ResponsabileDaoImpl extends AbstractDAO implements SigitVRicerca3ResponsabileDao {
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

	protected SigitVRicerca3ResponsabileDaoRowMapper byFkPgPfRowMapper = new SigitVRicerca3ResponsabileDaoRowMapper(
			null, SigitVRicerca3ResponsabileDto.class, this);

	protected SigitVRicerca3ResponsabileDaoRowMapper byFkPgPfContaRowMapper = new SigitVRicerca3ResponsabileDaoRowMapper(
			null, SigitVRicerca3ResponsabileByFkPgPfContaDto.class, this);

	protected SigitVRicerca3ResponsabileDaoRowMapper byFkPgPfRowRowMapper = new SigitVRicerca3ResponsabileDaoRowMapper(
			null, SigitVRicerca3ResponsabileByFkPgPfRowDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_RICERCA_3_RESPONSABILE";
	}

	/** 
	 * Implementazione del finder byFkPgPf
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicerca3ResponsabileDto> findByFkPgPf(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicerca3ResponsabileDto input)
			throws SigitVRicerca3ResponsabileDaoException {
		LOG.debug("[SigitVRicerca3ResponsabileDaoImpl::findByFkPgPf] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_CONTRATTO,CODICE_IMPIANTO,FK_RUOLO,DES_RUOLO,DATA_CARICAMENTO,DATA_CESSAZIONE,DATA_INSERIMENTO_CESSAZIONE,FK_PG_3_RESP,FK_IMP_RUOLO_PFPG_RESP,DATA_INIZIO_CONTRATTO,DATA_FINE_CONTRATTO,FLG_TACITO_RINNOVO,RESP_CODICE_FISCALE,RESP_DENOMINAZIONE,RESP_NOME,TERZO_RESP_DENOMINAZIONE,TERZO_RESP_SIGLA_REA,TERZO_RESP_NUMERO_REA,CODICE_FISCALE_3_RESP,DENOM_COMUNE_3_RESP,SIGLA_PROV_3_RESP,DENOM_PROVINCIA_3_RESP,DENOM_COMUNE_IMPIANTO,DENOM_PROV_IMPIANTO,SIGLA_PROV_IMPIANTO ");
		sql.append(" FROM VISTA_RICERCA_3_RESPONSABILE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1793900592) ENABLED START*/

		//dcosta: mev reingegnerizzazione viste: la query seguente deve essere dismessa a favore di findByFkPgPfConta. Con la mev ci si limita per il momento
		//a commentare la parte di codice che da errore a causa della revisione delle viste. questa query non verra' mai piu' richiamata fino a nuovo ordine
		//		if (GenericUtil.isNotNullOrEmpty(input.getFkPfResponsabile())) {
		//			sql.append(" FK_PF_RESPONSABILE = :idPf ");
		//
		//		} else if (GenericUtil.isNotNullOrEmpty(input.getFkPgResponsabile())) {
		//			sql.append(" FK_PG_RESPONSABILE = :idPg ");
		//
		//		}
		//dcosta: fine parte di codice errata

		sql.append(" AND CODICE_IMPIANTO = :codImpianto ");

		if (GenericUtil.isNotNullOrEmpty(input.getDataFineContratto())) {
			sql.append(" AND (DATA_INIZIO_CONTRATTO > :dataFine ");

			sql.append(" OR DATA_INIZIO_CONTRATTO < :dataInizio) ");
		} else {
			sql.append(" AND DATA_INIZIO_CONTRATTO < :dataInizio ");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R656907282) ENABLED START*/

		//dcosta: mev reingegnerizzazione viste: la query seguente deve essere dismessa a favore di findByFkPgPfConta. Con la mev ci si limita per il momento
		//a commentare la parte di codice che da errore a causa della revisione delle viste. questa query non verra' mai piu' richiamata fino a nuovo ordine
		//		if (GenericUtil.isNotNullOrEmpty(input.getFkPfResponsabile())) {
		//			paramMap.addValue("idPf", input.getFkPfResponsabile());
		//		} else if (GenericUtil.isNotNullOrEmpty(input.getFkPgResponsabile())) {
		//			paramMap.addValue("idPg", input.getFkPgResponsabile());
		//
		//		}
		//dcosta: fine parte di codice errata

		paramMap.addValue("codImpianto", input.getCodiceImpianto());

		// uso il parametro DataInizioContratto impropriamente (per comodità), in realtà è l'inizio responsabilità del responsabile 
		paramMap.addValue("dataInizio", input.getDataInizioContratto());

		if (GenericUtil.isNotNullOrEmpty(input.getDataFineContratto())) {
			// uso il parametro DataFineContratto impropriamente (per comodità), in realtà è la fine responsabilità del responsabile 
			paramMap.addValue("dataFine", input.getDataFineContratto());
		}

		/*PROTECTED REGION END*/
		List<SigitVRicerca3ResponsabileDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFkPgPfRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicerca3ResponsabileDaoImpl::findByFkPgPf] esecuzione query", ex);
			throw new SigitVRicerca3ResponsabileDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicerca3ResponsabileDaoImpl", "findByFkPgPf", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVRicerca3ResponsabileDaoImpl::findByFkPgPf] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFkPgPfConta con Qdef
		 * @generated
		 */

	public List<SigitVRicerca3ResponsabileByFkPgPfContaDto> findByFkPgPfConta(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.TerzoResponsabileFilter input)
			throws SigitVRicerca3ResponsabileDaoException {
		LOG.debug("[SigitVRicerca3ResponsabileDaoImpl::findByFkPgPfConta] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT COUNT(codice_impianto) AS contaResp");

		sql.append(" FROM VISTA_RICERCA_3_RESPONSABILE VRicerca3Responsabile, SIGIT_R_IMP_RUOLO_PFPG impRuoloPfPg");

		sql.append(" WHERE ");

		sql.append("VRicerca3Responsabile.FK_IMP_RUOLO_PFPG_RESP = impRuoloPfPg.ID_IMP_RUOLO_PFPG");

		sql.append(" AND ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R-1328846799) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		//dcosta: mev reingegnerizzazione viste: la query serve a sovrascrivere findByFkPgPf che quindi non dovra' piu' essere richiamata
		if (GenericUtil.isNotNullOrEmpty(input.getFkPfResponsabile())) {
			sql.append(" impRuoloPfPg.fk_persona_fisica = :idPf ");

		} else if (GenericUtil.isNotNullOrEmpty(input.getFkPgResponsabile())) {
			sql.append(" impRuoloPfPg.fk_persona_giuridica = :idPg ");

		}

		sql.append(" AND VRicerca3Responsabile.CODICE_IMPIANTO = :codImpianto ");

		if (GenericUtil.isNotNullOrEmpty(input.getDataFineContratto())) {
			sql.append(" AND (DATA_INIZIO_CONTRATTO <= :dataFine ");

			sql.append(" AND DATA_FINE_CONTRATTO >= :dataInizio) ");
		} else {
			sql.append(
					" AND :dataInizio BETWEEN DATA_INIZIO_CONTRATTO AND COALESCE(DATA_FINE_CONTRATTO, :dataInizio) ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFkPfResponsabile())) {
			paramMap.addValue("idPf", input.getFkPfResponsabile());
		} else if (GenericUtil.isNotNullOrEmpty(input.getFkPgResponsabile())) {
			paramMap.addValue("idPg", input.getFkPgResponsabile());

		}

		paramMap.addValue("codImpianto", input.getCodiceImpianto());

		// uso il parametro DataInizioContratto impropriamente (per comodità), in realtà è l'inizio responsabilità del responsabile 
		paramMap.addValue("dataInizio", input.getDataInizioContratto());

		if (GenericUtil.isNotNullOrEmpty(input.getDataFineContratto())) {
			// uso il parametro DataFineContratto impropriamente (per comodità), in realtà è la fine responsabilità del responsabile 
			paramMap.addValue("dataFine", input.getDataFineContratto());
		}

		/*PROTECTED REGION END*/

		List<SigitVRicerca3ResponsabileByFkPgPfContaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFkPgPfContaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicerca3ResponsabileDaoImpl::findByFkPgPfConta] ERROR esecuzione query", ex);
			throw new SigitVRicerca3ResponsabileDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicerca3ResponsabileDaoImpl", "findByFkPgPfConta", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVRicerca3ResponsabileDaoImpl::findByFkPgPfConta] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFkPgPfRow con Qdef
		 * @generated
		 */

	public List<SigitVRicerca3ResponsabileByFkPgPfRowDto> findByFkPgPfRow(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.TerzoResponsabileFilter input)
			throws SigitVRicerca3ResponsabileDaoException {
		LOG.debug("[SigitVRicerca3ResponsabileDaoImpl::findByFkPgPfRow] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT VRicerca3Responsabile.RESP_DENOMINAZIONE as denominazioneResp, VRicerca3Responsabile.TERZO_RESP_DENOMINAZIONE as denominazione3Resp, VRicerca3Responsabile.DATA_INIZIO_CONTRATTO as dataInizioContratto, VRicerca3Responsabile.DATA_FINE_CONTRATTO as dataFineContratto, VRicerca3Responsabile.DATA_CESSAZIONE as dataCessazione, VRicerca3Responsabile.FLG_TACITO_RINNOVO as flgTacitoRinnovo");

		sql.append(" FROM VISTA_RICERCA_3_RESPONSABILE VRicerca3Responsabile, SIGIT_R_IMP_RUOLO_PFPG impRuoloPfPg");

		sql.append(" WHERE ");

		sql.append("VRicerca3Responsabile.FK_IMP_RUOLO_PFPG_RESP = impRuoloPfPg.ID_IMP_RUOLO_PFPG");

		sql.append(" AND ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R-847765412) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		//dcosta: mev reingegnerizzazione viste: la query serve a sovrascrivere findByFkPgPf che quindi non dovra' piu' essere richiamata
		if (GenericUtil.isNotNullOrEmpty(input.getFkPfResponsabile())) {
			sql.append(" AND impRuoloPfPg.fk_persona_fisica = :idPf ");
			paramMap.addValue("idPf", input.getFkPfResponsabile());

		} else if (GenericUtil.isNotNullOrEmpty(input.getFkPgResponsabile())) {
			sql.append(" AND impRuoloPfPg.fk_persona_giuridica = :idPg ");
			paramMap.addValue("idPg", input.getFkPgResponsabile());

		}

		sql.append(" AND VRicerca3Responsabile.CODICE_IMPIANTO = :codImpianto ");
		paramMap.addValue("codImpianto", input.getCodiceImpianto());

		/*
		//se ho sia data inizio che fine nell'input allora sto cercando i contratti che hanno una intersezione col periodo
		if (GenericUtil.isNotNullOrEmpty(input.getDataFineContratto())) {
			sql.append(" AND (DATA_INIZIO_CONTRATTO <= :dataFine ");
		
			//sql.append(" AND COALESCE(DATA_FINE_CONTRATTO, :dataInizio) >= :dataInizio) ");
			sql.append(" AND COALESCE(DATA_CESSAZIONE, DATA_FINE_CONTRATTO) >= :dataInizio) ");
			paramMap.addValue("dataFine", input.getDataFineContratto());
		} else {
			//se ho solo la data inizio sto cercando i contratti che hanno il parametro incluso nella loro validita'
			sql.append(
					" AND :dataInizio BETWEEN DATA_INIZIO_CONTRATTO AND COALESCE(DATA_FINE_CONTRATTO, :dataInizio) ");
		}
		*/

		sql.append(" AND ((FLG_TACITO_RINNOVO = 1 AND COALESCE(DATA_CESSAZIONE, current_date+1) >= :dataInizio) ");
		sql.append(" OR (COALESCE(DATA_CESSAZIONE, DATA_FINE_CONTRATTO) >= :dataInizio)) ");

		if (GenericUtil.isNotNullOrEmpty(input.getDataFineContratto())) {
			sql.append(" AND DATA_INIZIO_CONTRATTO <= :dataFine ");

			paramMap.addValue("dataFine", input.getDataFineContratto());

		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdContratto())) {
			sql.append(" AND ID_CONTRATTO != :idContratto ");

			paramMap.addValue("idContratto", input.getIdContratto());

		}

		// uso il parametro DataInizioContratto impropriamente (per comodità), in realtà è l'inizio responsabilità del responsabile 
		paramMap.addValue("dataInizio", input.getDataInizioContratto());

		/*PROTECTED REGION END*/

		List<SigitVRicerca3ResponsabileByFkPgPfRowDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFkPgPfRowRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicerca3ResponsabileDaoImpl::findByFkPgPfRow] ERROR esecuzione query", ex);
			throw new SigitVRicerca3ResponsabileDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicerca3ResponsabileDaoImpl", "findByFkPgPfRow", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVRicerca3ResponsabileDaoImpl::findByFkPgPfRow] END");
		}
		return list;
	}

}
