/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.impl;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.SigitExtDao;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.mapper.SigitExtComponenteDaoRowMapper;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.mapper.SigitExtContrattoImpDaoRowMapper;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitExtContrattoImpDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter.ContrattoFilter;
import it.csi.sigit.sigitbatchn.business.dao.util.Constants;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitExtComponenteDto;
import it.csi.sigit.sigitbatchn.business.util.GenericUtil;
import it.csi.util.performance.StopWatch;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Implemenrazione del DAO sigitExt
 * @generated
 */
public class SigitExtDaoImpl extends AbstractDAO implements SigitExtDao {
	protected static final Logger log = Logger
			.getLogger(Constants.APPLICATION_CODE);
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

	protected SigitExtContrattoImpDaoRowMapper contrattiImpiantoRowMapper = new SigitExtContrattoImpDaoRowMapper(
			null, SigitExtContrattoImpDto.class, this);

	protected SigitExtComponenteDaoRowMapper componentiByFiltroRowMapper = new SigitExtComponenteDaoRowMapper(
			null, SigitExtComponenteDto.class, this);
	
	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "EXT";
	}

	
	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitExtContrattoImpDto> findStoriaContrattiImpiantoOld(ContrattoFilter input) throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findStoriaContrattiImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT A.CODICE_IMPIANTO, A.FK_RUOLO, DR.DES_RUOLO,");
		sql.append("	IC.ID_CONTRATTO, IC.DATA_CARICAMENTO, IC.DATA_REVOCA, C.FK_PG_3_RESP, ");
		sql.append("	FK_PG_RESPONSABILE, FK_PF_RESPONSABILE, C.DATA_INIZIO AS DATA_INIZIO_CONTRATTO, C.DATA_FINE AS DATA_FINE_CONTRATTO, FLG_TACITO_RINNOVO,");
		sql.append("	COALESCE(PG.CODICE_FISCALE, PF.CODICE_FISCALE) AS RESP_CODICE_FISCALE,");
		sql.append("	COALESCE(PG.DENOMINAZIONE,  PF.COGNOME) AS RESP_DENOMINAZIONE,");
		sql.append("	PF.NOME AS RESP_NOME,");
		sql.append("	PG3R.DENOMINAZIONE AS TERZO_RESP_DENOMINAZIONE, PG3R.SIGLA_REA AS TERZO_RESP_SIGLA_REA,");
		sql.append("	PG3R.NUMERO_REA AS TERZO_RESP_NUMERO_REA, PG3R.CODICE_FISCALE AS CODICE_FISCALE_3_RESP,");
		sql.append("	PG3R.COMUNE AS DENOM_COMUNE_3_RESP, PG3R.SIGLA_PROV AS SIGLA_PROV_3_RESP, PG3R.PROVINCIA AS DENOM_PROVINCIA_3_RESP, ");
		sql.append("	IMP.DENOMINAZIONE_COMUNE as DENOM_COMUNE_IMPIANTO,	IMP.DENOMINAZIONE_PROVINCIA AS DENOM_PROV_IMPIANTO,	IMP.SIGLA_PROVINCIA AS SIGLA_PROV_IMPIANTO ");
		sql.append("FROM SIGIT_R_IMP_RUOLO_PFPG A ");
		sql.append("	JOIN SIGIT_T_IMPIANTO IMP ON IMP.CODICE_IMPIANTO = A.CODICE_IMPIANTO ");
		sql.append("	JOIN SIGIT_R_IMPIANTO_CONTRATTO IC ON A.CODICE_IMPIANTO = IC.CODICE_IMPIANTO");
		sql.append("	JOIN SIGIT_T_CONTRATTO C ON IC.ID_CONTRATTO = C.ID_CONTRATTO");
		sql.append("	JOIN SIGIT_D_RUOLO DR ON DR.ID_RUOLO = A.FK_RUOLO");
		sql.append("	LEFT JOIN SIGIT_T_PERSONA_GIURIDICA PG ON PG.ID_PERSONA_GIURIDICA = C.FK_PG_RESPONSABILE");
		sql.append("	LEFT JOIN SIGIT_T_PERSONA_FISICA PF ON PF.ID_PERSONA_FISICA = C.FK_PF_RESPONSABILE");
		sql.append("	JOIN SIGIT_T_PERSONA_GIURIDICA PG3R ON PG3R.ID_PERSONA_GIURIDICA = C.FK_PG_3_RESP ");
		sql.append("WHERE A.CODICE_IMPIANTO = :codiceImpianto");
		sql.append("	AND (A.FK_PERSONA_FISICA = C.FK_PF_RESPONSABILE");
		sql.append("	OR A.FK_PERSONA_GIURIDICA = C.FK_PG_RESPONSABILE)");
		sql.append("	AND C.DATA_INIZIO BETWEEN A.DATA_INIZIO AND COALESCE(A.DATA_FINE,CURRENT_DATE)");
		
		if(input.getDataDal()!=null)
		{
			sql.append(" AND C.DATA_INIZIO <= :dataControllo");
			sql.append(" AND ((IC.DATA_REVOCA IS NULL AND FLG_TACITO_RINNOVO = 1 OR IC.DATA_REVOCA >= :dataControllo)");
			sql.append(" OR ");
			sql.append(" IC.DATA_REVOCA IS NULL"); 
			sql.append(" AND FLG_TACITO_RINNOVO = 0"); 
			sql.append(" AND c.data_fine >= :dataControllo)");
		}
		
		sql.append(" ORDER BY C.DATA_INIZIO DESC");
		
		paramMap.addValue("codiceImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("dataControllo", input.getDataDal(), java.sql.Types.DATE);
		
		List<SigitExtContrattoImpDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap,
					contrattiImpiantoRowMapper);
			
		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findStoriaContrattiImpianto] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findStoriaContrattiImpianto",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findStoriaContrattiImpianto] END");
		}
		return list;
	}
	
	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitExtContrattoImpDto> findStoriaContrattiImpiantoNew(ContrattoFilter input) throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findStoriaContrattiImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT A.CODICE_IMPIANTO, A.FK_RUOLO, DR.DES_RUOLO,");
		sql.append("	IC.ID_CONTRATTO, IC.ID_TIPO_COMPONENTE, IC.PROGRESSIVO, IC.DATA_CARICAMENTO, IC.DATA_REVOCA, C.FK_PG_3_RESP, ");
		sql.append("	FK_PG_RESPONSABILE, FK_PF_RESPONSABILE, C.DATA_INIZIO AS DATA_INIZIO_CONTRATTO, C.DATA_FINE AS DATA_FINE_CONTRATTO, FLG_TACITO_RINNOVO,");
		sql.append("	COALESCE(PG.CODICE_FISCALE, PF.CODICE_FISCALE) AS RESP_CODICE_FISCALE,");
		sql.append("	COALESCE(PG.DENOMINAZIONE,  PF.COGNOME) AS RESP_DENOMINAZIONE,");
		sql.append("	PF.NOME AS RESP_NOME,");
		sql.append("	PG3R.DENOMINAZIONE AS TERZO_RESP_DENOMINAZIONE, PG3R.SIGLA_REA AS TERZO_RESP_SIGLA_REA,");
		sql.append("	PG3R.NUMERO_REA AS TERZO_RESP_NUMERO_REA, PG3R.CODICE_FISCALE AS CODICE_FISCALE_3_RESP,");
		sql.append("	PG3R.COMUNE AS DENOM_COMUNE_3_RESP, PG3R.SIGLA_PROV AS SIGLA_PROV_3_RESP, PG3R.PROVINCIA AS DENOM_PROVINCIA_3_RESP, ");
		sql.append("	IMP.DENOMINAZIONE_COMUNE as DENOM_COMUNE_IMPIANTO,	IMP.DENOMINAZIONE_PROVINCIA AS DENOM_PROV_IMPIANTO,	IMP.SIGLA_PROVINCIA AS SIGLA_PROV_IMPIANTO ");
		sql.append("FROM SIGIT_R_IMP_RUOLO_PFPG A ");
		sql.append("	JOIN SIGIT_T_IMPIANTO IMP ON IMP.CODICE_IMPIANTO = A.CODICE_IMPIANTO ");
		sql.append("	JOIN SIGIT_R_COMP4_CONTRATTO IC ON A.CODICE_IMPIANTO = IC.CODICE_IMPIANTO");
		sql.append("	JOIN SIGIT_T_CONTRATTO C ON IC.ID_CONTRATTO = C.ID_CONTRATTO");
		sql.append("	JOIN SIGIT_D_RUOLO DR ON DR.ID_RUOLO = A.FK_RUOLO");
		sql.append("	LEFT JOIN SIGIT_T_PERSONA_GIURIDICA PG ON PG.ID_PERSONA_GIURIDICA = C.FK_PG_RESPONSABILE");
		sql.append("	LEFT JOIN SIGIT_T_PERSONA_FISICA PF ON PF.ID_PERSONA_FISICA = C.FK_PF_RESPONSABILE");
		sql.append("	JOIN SIGIT_T_PERSONA_GIURIDICA PG3R ON PG3R.ID_PERSONA_GIURIDICA = C.FK_PG_3_RESP ");
		sql.append("WHERE A.CODICE_IMPIANTO = :codiceImpianto");
		
		
		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoComponente()))
		{
			sql.append(" AND IC.ID_TIPO_COMPONENTE = :idTipoComp");
		}
		
		if (GenericUtil.isNotNullOrEmpty(input.getComponente()))
		{
			sql.append(" AND IC.PROGRESSIVO = :progressivo");
		}
		
		sql.append("	AND (A.FK_PERSONA_FISICA = C.FK_PF_RESPONSABILE");
		sql.append("	OR A.FK_PERSONA_GIURIDICA = C.FK_PG_RESPONSABILE)");
		sql.append("	AND C.DATA_INIZIO BETWEEN A.DATA_INIZIO AND COALESCE(A.DATA_FINE,CURRENT_DATE)");
		
		if(input.getDataDal()!=null)
		{
			
			sql.append(" AND C.DATA_INIZIO <= :dataControllo ");
			sql.append(" AND ( ");
			sql.append(" (FLG_TACITO_RINNOVO = 1  AND (IC.DATA_REVOCA IS NULL OR IC.DATA_REVOCA >= :dataControllo)) ");
			sql.append(" OR    (FLG_TACITO_RINNOVO = 0 AND ((IC.DATA_REVOCA IS NULL AND C.DATA_FINE >= :dataControllo) ");
			sql.append(" OR ( ((IC.DATA_REVOCA >= :dataControllo AND IC.DATA_REVOCA <= C.DATA_FINE) ");
			sql.append(" OR (C.DATA_FINE >= :dataControllo AND C.DATA_FINE <= IC.DATA_REVOCA)) ");
			sql.append(" AND IC.DATA_REVOCA IS NOT NULL)))) ");
					        
			/*
			sql.append(" AND C.DATA_INIZIO <= :dataControllo");

			sql.append(" AND ( ");
			sql.append(" (FLG_TACITO_RINNOVO = 1  AND (IC.DATA_REVOCA IS NULL OR IC.DATA_REVOCA >= :dataControllo)) ");
			sql.append(" OR (FLG_TACITO_RINNOVO = 0 AND ((IC.DATA_REVOCA IS NULL AND C.DATA_FINE >= :dataControllo) ");
			sql.append(" OR ((IC.DATA_REVOCA >= :dataControllo AND IC.DATA_REVOCA <= C.DATA_FINE) ");
			sql.append(" OR (C.DATA_FINE >= :dataControllo AND C.DATA_FINE<=IC.DATA_REVOCA)))) ");
			sql.append(" ) ");
			*/
			
		}
		
		sql.append(" ORDER BY C.DATA_INIZIO ASC, IC.DATA_REVOCA ASC, C.DATA_FINE ASC, IC.ID_CONTRATTO DESC, IC.ID_TIPO_COMPONENTE ASC, IC.PROGRESSIVO ASC ");
		
		paramMap.addValue("codiceImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);

		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoComponente()))
		{
			paramMap.addValue("idTipoComp", input.getIdTipoComponente(), java.sql.Types.VARCHAR);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getComponente()))
		{
			paramMap.addValue("progressivo", input.getComponente(), java.sql.Types.NUMERIC);
		}
		
		paramMap.addValue("dataControllo", input.getDataDal(), java.sql.Types.DATE);
		
		List<SigitExtContrattoImpDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap,
					contrattiImpiantoRowMapper);
			
		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findStoriaContrattiImpianto] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findStoriaContrattiImpianto",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findStoriaContrattiImpianto] END");
		}
		return list;
	}
	
	/** 
	 * Implementazione del finder findComponentiByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitExtComponenteDto> findComponentiByFilter(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter.CompFilter input, String nomeTabellaComp)
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findComponentiByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT cm.ID_R_COMP4_MANUT, cm.FK_PERSONA_GIURIDICA,c.ID_TIPO_COMPONENTE,c.PROGRESSIVO,m.DES_MARCA,comp.MODELLO ");
		sql.append("FROM SIGIT_T_COMP4 c, SIGIT_R_COMP4_MANUT cm, " + nomeTabellaComp + " comp, SIGIT_D_MARCA m ");
		sql.append("WHERE ");
		sql.append("c.CODICE_IMPIANTO = cm.CODICE_IMPIANTO ");
		sql.append("AND c.ID_TIPO_COMPONENTE = cm.ID_TIPO_COMPONENTE ");
		sql.append("AND c.PROGRESSIVO = cm.PROGRESSIVO ");
		//sql.append("AND c.DATA_INSTALL = cm.DATA_INSTALL ");
		
		sql.append("AND c.CODICE_IMPIANTO = comp.CODICE_IMPIANTO ");
		sql.append("AND c.ID_TIPO_COMPONENTE = comp.ID_TIPO_COMPONENTE "); 
		sql.append("AND c.PROGRESSIVO = comp.PROGRESSIVO "); 
		
		sql.append("AND comp.FK_MARCA = m.ID_MARCA ");
		
		sql.append("AND c.CODICE_IMPIANTO = :codImpianto ");
		sql.append("AND c.ID_TIPO_COMPONENTE = :tipoComp ");

//		log.debug("#### Stampo la lista combustibili: "+input.getListCombustibile());
//		
//		if (input.getListCombustibile() != null
//				&& !input.getListCombustibile().isEmpty()) {
//			sql.append(" AND comp.FK_COMBUSTIBILE IN  (");
//			boolean aggVirg = false;
//			for (String progr : input.getListCombustibile()) {
//				if (aggVirg)
//					sql.append(", ");
//				sql.append(progr);
//				aggVirg = true;
//			}
//			sql.append(") ");
//		}
		
		sql.append("AND :dataRapporto BETWEEN comp.DATA_INSTALL AND COALESCE(comp.DATA_DISMISS, :dataRapporto) ");
		
		if (GenericUtil.isNotNullOrEmpty(input.getIdPersonaGiuridica()))
		{
			sql.append(" AND cm.FK_PERSONA_GIURIDICA = :idPersonaGiuridica ");
		}
		
		//mettere la persona giuridica = sigit_r_comp4_manut
		sql.append("AND cm.DATA_FINE IS NULL ");
		sql.append("ORDER BY PROGRESSIVO ASC, comp.DATA_INSTALL DESC ");
		
		paramMap.addValue("codImpianto", input.getCodImpianto(),
				java.sql.Types.NUMERIC);

		paramMap.addValue("tipoComp", input.getTipoComponente(),
				java.sql.Types.VARCHAR);
		
		paramMap.addValue("dataRapporto", input.getDataInstallazione(),
				java.sql.Types.DATE);
		
		if (GenericUtil.isNotNullOrEmpty(input.getIdPersonaGiuridica()))
		{
			paramMap.addValue("idPersonaGiuridica", input.getIdPersonaGiuridica(),
					java.sql.Types.NUMERIC);
		}
		
		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		List<SigitExtComponenteDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap,
					componentiByFiltroRowMapper);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findComponentiByFilter] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findComponentiByFilter",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findComponentiByFilter] END");
		}
		return list;
	}
}
