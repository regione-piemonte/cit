/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitExtDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper.*;
//import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper.SigitExtDocAggiuntivaDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
//import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitExtDocAggiuntivaByCodImpiantoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ContrattoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaIspezioniFilter;
import it.csi.sigit.sigitwebn.business.dao.util.Constants;
import it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.util.performance.StopWatch;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

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
	 * @generated
	 */
	protected DataFieldMaxValueIncrementer incrementerImportDistrib;

	/**
	 * @generated
	 */
	protected DataFieldMaxValueIncrementer incrementerCodiceImpianto;

	/**
	 * @generated
	 */
	protected DataFieldMaxValueIncrementer incrementerGraffatura;
	
	/**
	 * @generated
	 */
	public void setIncrementerImportDistrib(DataFieldMaxValueIncrementer incrementerImportDistrib) {
		this.incrementerImportDistrib = incrementerImportDistrib;
	}

	/**
	 * @generated
	 */
	public void setIncrementerCodiceImpianto(DataFieldMaxValueIncrementer incrementerCodiceImpianto) {
		this.incrementerCodiceImpianto = incrementerCodiceImpianto;
	}


	public void setIncrementerGraffatura(DataFieldMaxValueIncrementer incrementerGraffatura) {
		this.incrementerGraffatura = incrementerGraffatura;
	}

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 * @generated
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	protected SigitExtRespImpDaoRowMapper responsabiliByCodiceImpiantoRowMapper = new SigitExtRespImpDaoRowMapper(
			null, SigitExtRespImpDto.class, this);

	protected SigitExtImpiantoDaoRowMapper impiantiByFiltroRowMapper = new SigitExtImpiantoDaoRowMapper(
			null, SigitExtImpiantoDto.class, this);
	
	protected SigitExtContrattoImpDaoRowMapper contrattiImpiantoRowMapper = new SigitExtContrattoImpDaoRowMapper(
			null, SigitExtContrattoImpDto.class, this);

	protected SigitExtComponenteDaoRowMapper componentiByFiltroRowMapper = new SigitExtComponenteDaoRowMapper(
			null, SigitExtComponenteDto.class, this);
	
//	protected SigitExtDocAggiuntivaDaoRowMapper documentazioneByFiltroRowMapper = new SigitExtDocAggiuntivaDaoRowMapper(
//			null, SigitExtDocAggiuntivaByCodImpiantoDto.class, this);
	
	protected SigitExtVerificaDaoRowMapper verificaByIdRowMapper = new SigitExtVerificaDaoRowMapper(
			null, SigitExtVerificaDto.class, this);
	
	protected SigitExtIspezione2018DaoRowMapper ispezione2018RowMapper = new SigitExtIspezione2018DaoRowMapper(
			null, SigitExtIspezione2018Dto.class, this);

	protected SigitExtIspezioniConCodImpiantoDtoRowMapper ispezioniConCodImpiantoRowMapper = new SigitExtIspezioniConCodImpiantoDtoRowMapper(
			null, SigitExtIspezioniConCodImpiantoDto.class, this);

	protected SigitExtIspezioniSenzaCodImpiantoDtoRowMapper ispezioniSenzaCodImpiantoRowMapper = new SigitExtIspezioniSenzaCodImpiantoDtoRowMapper(
			null, SigitExtIspezioniSenzaCodImpiantoDto.class, this);

	protected SigitExtIspezioniDtoRowMapper ispezioniRowMapper = new SigitExtIspezioniDtoRowMapper(
			null, SigitExtIspezioniDto.class, this);

	protected SigitExtGraffaturaDaoRowMapper GraffaturaRowMapper = new SigitExtGraffaturaDaoRowMapper(
			null, SigitExtIspezioniDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "EXT";
	}
	
	public BigDecimal getNextIdByTable (String tableName, String idColumnName) throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::getNextIdByTable] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append(" SELECT coalesce(max(" + idColumnName + "), 0) + 1 next_id from " + tableName);
		
		List<BigDecimal> list = null;
		
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.queryForList(sql.toString(), paramMap, BigDecimal.class);
			
			if (list != null && list.size() == 1) {
				return list.get(0);
			}

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::getNextIdByTable] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "getNextIdByTable",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::getNextIdByTable] END");
		}
		return null;
		
	}
	
	
	public String findIndirizzoMailAbilitazioneByExample (String ruolo, String istat, BigDecimal idPersonaFisica) throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findIndirizzoMailAbilitazioneByExample] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append(" SELECT mail_comunicazione");
		sql.append(" FROM SIGIT_T_ABILITAZIONE ab");
		sql.append(" JOIN SIGIT_D_RUOLO_PA ruo ON ab.id_ruolo_pa = ruo.id_ruolo_pa");
		sql.append(" JOIN SIGIT_R_PF_RUOLO_PA ruoPafis ON ruoPafis.id_ruolo_pa = ab.id_ruolo_pa AND ruoPafis.istat_abilitazione = ab.istat_abilitazione");
		sql.append(" WHERE 1 = 1");
		
		if (GenericUtil.isNotNullOrEmpty(ruolo)) {
			sql.append(" AND ruo.des_ruolo_pa = :ruolo");
			paramMap.addValue("ruolo", ruolo);
		}
		
		if (GenericUtil.isNotNullOrEmpty(istat)) {
			sql.append(" AND ab.istat_abilitazione = :istat");
			paramMap.addValue("istat", istat);
		}
		
		if (GenericUtil.isNotNullOrEmpty(idPersonaFisica)) {
			sql.append(" AND ruoPafis.id_persona_fisica = :idPersFisica");
			paramMap.addValue("idPersFisica", idPersonaFisica);
		}

		List<String> list = null;
		
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.queryForList(sql.toString(), paramMap, String.class);
			
			if (list != null && list.size() == 1) {
				return list.get(0);
			}

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findIndirizzoMailAbilitazioneByExample] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findIndirizzoMailAbilitazioneByExample",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findIndirizzoMailAbilitazioneByExample] END");
		}
		return null;
		
	}

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitExtRespImpDto> findResponsabiliByCodiceImpianto(java.lang.Integer input)
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findResponsabiliByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		//DCOSTA: mev reignegnerizzazione viste QUERY CHE DATO IL CODICE IMPIANTO INTERROGA LA TABELLA DI LINK IMPIANTO-RUOLO-PERSONA PER RECUPERARE TUTTE LE PERSONE LEGATE AD UN IMPIANTO SECONDO UN SET DI RUOLI
		sql.append(" SELECT ruolo.ID_IMP_RUOLO_PFPG, ruolo.FK_PERSONA_GIURIDICA, ruolo.FK_PERSONA_FISICA, pg.DENOMINAZIONE, pf.COGNOME, pf.NOME, ruolo.FK_RUOLO, dr.DES_RUOLO, ruolo.CODICE_IMPIANTO, ruolo.DATA_INIZIO, ruolo.DATA_FINE");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG ruolo");
		sql.append(" LEFT JOIN SIGIT_T_PERSONA_GIURIDICA pg ON pg.ID_PERSONA_GIURIDICA = ruolo.FK_PERSONA_GIURIDICA");
		sql.append(" LEFT JOIN SIGIT_T_PERSONA_FISICA pf ON pf.ID_PERSONA_FISICA = ruolo.FK_PERSONA_FISICA");
		sql.append(" JOIN SIGIT_D_RUOLO dr ON dr.ID_RUOLO = ruolo.FK_RUOLO");
		sql.append(" WHERE ruolo.FK_RUOLO IN ("+Constants.ID_RUOLO_AMMINISTRATORE+","+Constants.ID_RUOLO_PROPRIETARIO+","+Constants.ID_RUOLO_OCCUPANTE+","+Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE+","+Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO+","+Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE+")");

		sql.append(" AND ruolo.CODICE_IMPIANTO = :codiceImpianto");

		paramMap.addValue("codiceImpianto", input);

		sql.append(" ORDER BY ruolo.DATA_INIZIO ");
		
		List<SigitExtRespImpDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap,
					responsabiliByCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findResponsabiliByCodiceImpianto] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findResponsabiliByCodiceImpianto",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findResponsabiliByCodiceImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitExtRespImpDto findResponsabileAttivoByCodiceImpianto(java.lang.Integer input)
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findResponsabileAttivoByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		//DCOSTA:  mev reignegnerizzazione viste QUERY CHE DATO IL CODICE IMPIANTO INTERROGA LA TABELLA DI LINK IMPIANTO-RUOLO-PERSONA PER RECUPERARE IL RESPONSABILE ATTIVO LEGATO AD UN IMPIANTO SECONDO UN SET DI RUOLI
		sql.append(" SELECT ruolo.ID_IMP_RUOLO_PFPG, ruolo.FK_PERSONA_GIURIDICA, ruolo.FK_PERSONA_FISICA, pg.DENOMINAZIONE, pf.COGNOME, pf.NOME, ruolo.FK_RUOLO, dr.DES_RUOLO, ruolo.CODICE_IMPIANTO, ruolo.DATA_INIZIO, ruolo.DATA_FINE");
		sql.append(" FROM SIGIT_R_IMP_RUOLO_PFPG ruolo");
		sql.append(" LEFT JOIN SIGIT_T_PERSONA_GIURIDICA pg ON pg.ID_PERSONA_GIURIDICA = ruolo.FK_PERSONA_GIURIDICA");
		sql.append(" LEFT JOIN SIGIT_T_PERSONA_FISICA pf ON pf.ID_PERSONA_FISICA = ruolo.FK_PERSONA_FISICA");
		sql.append(" JOIN SIGIT_D_RUOLO dr ON dr.ID_RUOLO = ruolo.FK_RUOLO");
		sql.append(" WHERE ruolo.FK_RUOLO IN ("+Constants.ID_RUOLO_AMMINISTRATORE+","+Constants.ID_RUOLO_PROPRIETARIO+","+Constants.ID_RUOLO_OCCUPANTE+","+Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE+","+Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO+","+Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE+")");

		sql.append(" AND ruolo.CODICE_IMPIANTO = :codiceImpianto");

		paramMap.addValue("codiceImpianto", input);

		sql.append(" AND CURRENT_DATE BETWEEN ruolo.DATA_INIZIO AND COALESCE(ruolo.DATA_FINE,CURRENT_DATE) ");
		
		List<SigitExtRespImpDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap,
					responsabiliByCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findResponsabileAttivoByCodiceImpianto] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findResponsabileAttivoByCodiceImpianto",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findResponsabileAttivoByCodiceImpianto] END");
		}
		return list.size() == 0 ? null : list.get(0);
	}
	
	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	/*
	@SuppressWarnings("unchecked")
	public List<SigitExtContrattoImpDto> findStoriaContrattiImpianto(ContrattoFilter input) throws SigitExtDaoException {
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
	*/
	
	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	/*
	@SuppressWarnings("unchecked")
	public List<SigitExtDocAggiuntivaByCodImpiantoDto> findDocumentazioneByCodiceImpianto(java.lang.Integer input, boolean isIspezione)
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findDocumentazioneByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		
		sql.append(" SELECT da.ID_DOC_AGGIUNTIVA, da.UID_INDEX, da.NOME_DOC_ORIGINALE, rda.DES_TIPO_DOC_AGG, da.DES_ALTRO_TIPODOC, ");
		sql.append(" da.DATA_UPLOAD, da.DATA_DELETE, i.DATA_ISPEZIONE, i.ENTE_COMPETENTE, dsi.DES_STATO_ISPEZIONE, i.FK_STATO_ISPEZIONE, i.FLG_ESITO, da.DATA_ULT_MOD ");
		sql.append(" FROM SIGIT_T_DOC_AGGIUNTIVA da ");
		sql.append(" JOIN SIGIT_D_TIPO_DOC_AGG rda on rda.ID_TIPO_DOC_AGG = da.FK_TIPO_DOCAGG ");
		sql.append(" LEFT JOIN SIGIT_T_ISPEZIONE i ON i.ID_IMP_RUOLO_PFPG = da.FK_IMP_RUOLO_PFPG ");
		sql.append(" LEFT JOIN SIGIT_D_STATO_ISPEZIONE dsi ON dsi.ID_STATO_ISPEZIONE = i.FK_STATO_ISPEZIONE ");
		sql.append(" WHERE da.CODICE_IMPIANTO = :codiceImpianto ");

		if (!isIspezione)
		{
			sql.append(" EXCEPT "); 
			sql.append(" SELECT da.ID_DOC_AGGIUNTIVA, da.UID_INDEX, da.NOME_DOC_ORIGINALE, rda.DES_TIPO_DOC_AGG, da.DES_ALTRO_TIPODOC, ");
			sql.append(" da.DATA_UPLOAD, da.DATA_DELETE, i.DATA_ISPEZIONE, i.ENTE_COMPETENTE, dsi.DES_STATO_ISPEZIONE, i.FK_STATO_ISPEZIONE, i.FLG_ESITO, da.DATA_ULT_MOD ");
			sql.append(" FROM SIGIT_T_DOC_AGGIUNTIVA da ");
			sql.append(" JOIN SIGIT_D_TIPO_DOC_AGG rda on rda.ID_TIPO_DOC_AGG = da.FK_TIPO_DOCAGG ");
			sql.append(" LEFT JOIN SIGIT_T_ISPEZIONE i ON i.ID_IMP_RUOLO_PFPG = da.FK_IMP_RUOLO_PFPG ");
			sql.append(" LEFT JOIN SIGIT_D_STATO_ISPEZIONE dsi ON dsi.ID_STATO_ISPEZIONE = i.FK_STATO_ISPEZIONE ");
			sql.append(" WHERE da.CODICE_IMPIANTO = :codiceImpianto ");
			sql.append(" AND i.FK_STATO_ISPEZIONE in ("+Constants.ID_STATO_ISPEZIONE_BOZZA+","+Constants.ID_STATO_ISPEZIONE_ANNULLATO+")");

		}
		
		sql.append(" ORDER BY DATA_ULT_MOD ");
		
		paramMap.addValue("codiceImpianto", input);
		
		List<SigitExtDocAggiuntivaByCodImpiantoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap,
					documentazioneByFiltroRowMapper);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findDocumentazioneByCodiceImpianto] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findDocumentazioneByCodiceImpianto",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findDocumentazioneByCodiceImpianto] END");
		}
		return list;
	}
	*/
	
	@SuppressWarnings("unchecked")
	public List<SigitExtIspezione2018Dto> findIspezioni2018ByFilter(RicercaIspezioniFilter filter) throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findIspezioni2018ByFilter] START");
		
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		String query = "SELECT isp.ID_ISPEZIONE_2018, "
				+ " TMP.NOME, "
				+ " TMP.COGNOME, "
				+ " TMP.CODICE_FISCALE, "
				+ " isp.CF_ISPETTORE_SECONDARIO, "
				+ " isp.DT_CREAZIONE, "
				+ " isp.FK_STATO_ISPEZIONE, "
				+ " isp.ENTE_COMPETENTE, "
				+ " isp.NOTE, "
				+ " isp.CODICE_IMPIANTO, "
				+ " isp.FLG_ESITO "
				+ " FROM SIGIT_T_ISPEZIONE_2018 isp "
				+ " LEFT JOIN ( SELECT ispet.ID_ISPEZIONE_2018, "
								+ "	pers.NOME, pers.COGNOME,  pers.CODICE_FISCALE, pers.ID_PERSONA_FISICA "
								+ " FROM SIGIT_R_ISPEZ_ISPET ispet "
								+ " JOIN SIGIT_T_PERSONA_FISICA pers ON ispet.fk_persona_fisica = pers.id_persona_fisica "
								+ " WHERE ispet.fk_ruolo = "+ it.csi.sigit.sigitwebn.util.Constants.ID_RUOLO_ISPETTORE+") TMP"
				+ " ON isp.ID_ISPEZIONE_2018 = TMP.ID_ISPEZIONE_2018"
				+ " WHERE 1 = 1";
		
		if (GenericUtil.isNotNullOrEmpty(filter.getIdIspettore())) {
			query += " AND TMP.ID_PERSONA_FISICA = :idPersFis";
			paramMap.addValue("idPersFis", filter.getIdIspettore());
		}
		
		if (filter.getCodiceImpianto() != null) {
			query += " AND isp.CODICE_IMPIANTO = :codiceImpianto";
			paramMap.addValue("codiceImpianto", filter.getCodiceImpianto());
		}
		
		if (filter.getDataConclusioneA() != null) {
			query += " AND isp.dt_conclusione <= :dataConclusioneA";
			paramMap.addValue("dataConclusioneA", filter.getDataConclusioneA());
		}
		
		if (filter.getDataConclusioneDA() != null) {
			query += " AND isp.dt_conclusione >= :dataConclusioneDA";
			paramMap.addValue("dataConclusioneDA", filter.getDataConclusioneDA());
		}
		
		if (filter.getDataCreazioneA()!= null) {
			query += " AND isp.dt_creazione <= :dataCreazioneA";
			paramMap.addValue("dataCreazioneA", filter.getDataCreazioneA());
		}
		
		if (filter.getDataCreazioneDA()!= null) {
			query += " AND isp.dt_creazione >= :dataCreazioneDA";
			paramMap.addValue("dataCreazioneDA", filter.getDataCreazioneDA());
		}
		
		if (filter.isFlagNonAssegnato()) {
			query += " AND TMP.CODICE_FISCALE is null";
		}
		
		if (filter.getFlagEsitoIspezione() != null) {
			query += " AND isp.flg_esito = :esito";
			paramMap.addValue("esito", filter.getFlagEsitoIspezione());
		}
		
		if (filter.getIdentificativoIspezione() != null ) {
			query += " AND isp.ID_ISPEZIONE_2018 = :identificativo";
			paramMap.addValue("identificativo", filter.getIdentificativoIspezione());
		}
		
		if (filter.getIdStatoIspezione() != null) {
			query += " AND isp.fk_stato_ispezione = :statoIsp";
			paramMap.addValue("statoIsp", filter.getIdStatoIspezione());
		}
		//viene esclusa l'ispezione con id=0
		query += " AND isp.ID_ISPEZIONE_2018 <> 0";
		
		sql.append(query);
		
		List<SigitExtIspezione2018Dto> list = null;
		
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ispezione2018RowMapper);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findIspezioni2018ByFilter] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findIspezioni2018ByFilter",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findIspezioni2018ByFilter] END");
		}
		return list;
				
	}
	
	@SuppressWarnings("unchecked")
	public List<SigitExtVerificaDto> findVerificaById(SigitTVerificaPk id) throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findVerificaById] START");
		
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		String query = "SELECT ver.ID_VERIFICA,"
				+ " ver.FK_TIPO_VERIFICA,"
				+ " ver.FK_ALLEGATO,"
				+ " ver.FK_DATO_DISTRIB,"
				+ " ver.CODICE_IMPIANTO,"
				+ " ver.CF_UTENTE_CARICAMENTO,"
				+ " ver.DENOM_UTENTE_CARICAMENTO,"
				+ " ver.DT_CARICAMENTO,"
				+ " ver.SIGLA_BOLLINO,"
				+ " ver.NUMERO_BOLLINO,"
				+ " ver.DT_SVEGLIA,"
				+ " ver.NOTE_SVEGLIA,"
				+ " ver.NOTE, "
				+ " acc.id_accertamento, "
				+ " isp.id_ispezione_2018 "
				+ " FROM SIGIT_T_VERIFICA ver"
				+ " LEFT JOIN SIGIT_T_ACCERTAMENTO acc ON acc.fk_verifica = ver.id_verifica "
				+ " LEFT JOIN SIGIT_T_ISPEZIONE_2018 isp ON isp.fk_verifica = ver.id_verifica "
				//and isp.fk_stato_ispezione <> " + Constants.ID_STATO_ISPEZIONE_ANNULLATO
				+ " WHERE 1 = 1 "
				+ " AND ver.ID_VERIFICA = :ID_VERIFICA";
		
		sql.append(query);
		

		// valorizzazione paametro relativo a colonna [ID_VERIFICA]
		paramMap.addValue("ID_VERIFICA", id.getIdVerifica(), java.sql.Types.INTEGER);
		List<SigitExtVerificaDto> list = null;
		
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, verificaByIdRowMapper);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findVerificaById] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findVerificaById",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findVerificaById] END");
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
		//DCOSTA:  mev reignegnerizzazione viste QUERY CHE RECUPERA I CONTRATTI ASSOCIATI AD UN CERTO RESPONSABILE E TERZO RESPONSABILE
		//CON LA REIGNEGNERIZZAZIONE DELLE VISTE SOSTITUISCO SIGIT_T_CONTRATTO con SIGIT_T_CONTRATTO_2019
		//SPARISCONO I RIFERIMENTI A SIGIT_R_COMP4_CONTRATTO
		
		String query = "SELECT IMP.CODICE_IMPIANTO,"
				+ "	DR.ID_RUOLO, "
				+ " DR.DES_RUOLO, "
				+ " C.ID_CONTRATTO, "
				+ " C.DATA_CARICAMENTO,"
				+ " C.DATA_CESSAZIONE,"
				+ " C.DATA_INSERIMENTO_CESSAZIONE,"
				+ " C.FK_PG_3_RESP,"
				+ " C_RESP.FK_PERSONA_GIURIDICA,"
				+ " C_RESP.FK_PERSONA_FISICA,"
				+ " C.DATA_INIZIO AS DATA_INIZIO_CONTRATTO,"
				+ " C.DATA_FINE AS DATA_FINE_CONTRATTO,"
				+ " C.FLG_TACITO_RINNOVO,"
				+ " C.NOTE,"
				+ " CESS.ID_TIPO_CESSAZIONE,"
				+ " CESS.DES_TIPO_CESSAZIONE,"
				+ " C.MOTIVO_CESSAZIONE,"
				+ " COALESCE(PG_RESP.CODICE_FISCALE, PF_RESP.CODICE_FISCALE) AS RESP_CODICE_FISCALE,"
				+ " COALESCE(PG_RESP.DENOMINAZIONE,  PF_RESP.COGNOME) AS RESP_DENOMINAZIONE,"
				+ " PF_RESP.NOME AS RESP_NOME,"
				+ " PG3R.DENOMINAZIONE AS TERZO_RESP_DENOMINAZIONE,"
				+ " PG3R.SIGLA_REA AS TERZO_RESP_SIGLA_REA,"
				+ " PG3R.NUMERO_REA AS TERZO_RESP_NUMERO_REA,"
				+ " PG3R.CODICE_FISCALE AS CODICE_FISCALE_3_RESP,"
				+ " PG3R.COMUNE AS DENOM_COMUNE_3_RESP,"
				+ " PG3R.SIGLA_PROV AS SIGLA_PROV_3_RESP,"
				+ " PG3R.PROVINCIA AS DENOM_PROVINCIA_3_RESP,"
				+ " IMP.DENOMINAZIONE_COMUNE AS DENOM_COMUNE_IMPIANTO,"
				+ " IMP.DENOMINAZIONE_PROVINCIA AS DENOM_PROV_IMPIANTO,"
				+ " IMP.SIGLA_PROVINCIA AS SIGLA_PROV_IMPIANTO"
				+ " FROM SIGIT_T_CONTRATTO_2019 C"
				+ " JOIN SIGIT_T_IMPIANTO IMP ON C.CODICE_IMPIANTO = IMP.CODICE_IMPIANTO"
				+ " JOIN SIGIT_R_IMP_RUOLO_PFPG C_RESP ON C_RESP.ID_IMP_RUOLO_PFPG = C.FK_IMP_RUOLO_PFPG_RESP AND C_RESP.CODICE_IMPIANTO = C.CODICE_IMPIANTO"
				+ " JOIN SIGIT_D_RUOLO DR ON DR.ID_RUOLO = C_RESP.FK_RUOLO"
				+ " JOIN SIGIT_T_PERSONA_GIURIDICA PG3R ON PG3R.ID_PERSONA_GIURIDICA = C.FK_PG_3_RESP"
				+ " JOIN SIGIT_D_TIPO_CESSAZIONE CESS ON CESS.ID_TIPO_CESSAZIONE = C.FK_TIPO_CESSAZIONE"
				+ " LEFT JOIN SIGIT_T_PERSONA_GIURIDICA PG_RESP ON C_RESP.FK_PERSONA_GIURIDICA = PG_RESP.ID_PERSONA_GIURIDICA"
				+ " LEFT JOIN SIGIT_T_PERSONA_FISICA PF_RESP ON C_RESP.FK_PERSONA_FISICA = PF_RESP.ID_PERSONA_FISICA";
		sql.append(query);
		sql.append(" WHERE IMP.CODICE_IMPIANTO = :codiceImpianto");
		
		if(input.getDataDal()!=null)
		{
			
			sql.append(" AND C.DATA_INIZIO <= :dataControllo ");
			sql.append(" AND ( ");
			sql.append(" (C.FLG_TACITO_RINNOVO = 1  AND (C.DATA_CESSAZIONE IS NULL OR C.DATA_CESSAZIONE >= :dataControllo)) ");
			sql.append(" OR    (C.FLG_TACITO_RINNOVO = 0 AND ((C.DATA_CESSAZIONE IS NULL AND C.DATA_FINE >= :dataControllo) ");
			sql.append(" OR ( ((C.DATA_CESSAZIONE >= :dataControllo AND C.DATA_CESSAZIONE <= C.DATA_FINE) ");
			sql.append(" OR (C.DATA_FINE >= :dataControllo AND C.DATA_FINE <= C.DATA_CESSAZIONE)) ");
			sql.append(" AND C.DATA_CESSAZIONE IS NOT NULL)))) ");
					        
		}
		
		sql.append(" ORDER BY C.DATA_INIZIO ASC, C.DATA_CESSAZIONE ASC, C.DATA_FINE ASC, C.ID_CONTRATTO DESC");
		
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
	
	
	public BigDecimal getSeqTNumeroBollino() throws SigitExtDaoException
	{
		
		log.debug("[SigitExtDaoImpl::getSeqTNumeroBollino] START");
		java.math.BigDecimal newKey = null;
		try {
			newKey = java.math.BigDecimal.valueOf(incrementer
					.nextLongValue());

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::getSeqTNumeroBollino] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			log.debug("[SigitExtDaoImpl::getSeqTNumeroBollino] END");
		}
		
		return newKey;
	}
	
	public BigDecimal getSeqTImportDistrib() throws SigitExtDaoException
	{
		
		log.debug("[SigitExtDaoImpl::getSeqTImportDistrib] START");
		java.math.BigDecimal newKey = null;
		try {
			newKey = java.math.BigDecimal.valueOf(incrementerImportDistrib
					.nextLongValue());

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::getSeqTImportDistrib] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			log.debug("[SigitExtDaoImpl::getSeqTImportDistrib] END");
		}
		
		return newKey;
	}

	public BigDecimal getSeqTCodiceImpianto() throws SigitExtDaoException
	{
		log.debug("[SigitExtDaoImpl::getSeqTCodiceImpianto] START");
		java.math.BigDecimal newKey = null;
		try {
			newKey = java.math.BigDecimal.valueOf(incrementerCodiceImpianto
					.nextLongValue());

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::getSeqTCodiceImpianto] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			log.debug("[SigitExtDaoImpl::getSeqTCodiceImpianto] END");
		}
		
		return newKey;
	}

	public BigDecimal getSeqTGraffatura() throws SigitExtDaoException
	{

		java.math.BigDecimal newKey = null;
		try {
			newKey = java.math.BigDecimal.valueOf(incrementerGraffatura
					.nextLongValue());

		} catch (RuntimeException ex) {
			throw new SigitExtDaoException("Query failed", ex);
		}
		return newKey;
	}

	/** 
	 * Implementazione del finder byFiltriUtente
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Integer findByFiltriUtenteCount(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaAllegati input)
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findByFiltriUtenteCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT COUNT(*) ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI");
		sql.append(" WHERE ");
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("1 = 1 ");

		//***aggiungere tutte le condizioni

		//Recupero la lista dei codici impianto da mettere dentro la in della query per tipologia di utente
		String codiciImpianto = "";
		if (input.getElencoCodiciImpianto() != null
				&& input.getElencoCodiciImpianto().size() > 0) {
			for (String str : input.getElencoCodiciImpianto()) {
				codiciImpianto += str + ",";
			}
			log.debug("FRAAAAAAAAAAAAAAA --> codiciImpianto: " + codiciImpianto);

			codiciImpianto = codiciImpianto.substring(0, (codiciImpianto.length() - 1));
		}

		log.debug(" ----> FRAAAAA lista codici impianto: " + codiciImpianto);

		if (GenericUtil.isNotNullOrEmpty(input.getIdStatoAllegato())) {
			sql.append(" AND FK_STATO_RAPP = :idStatoAllegato");
			paramMap.addValue("idStatoAllegato", input.getIdStatoAllegato(),
					java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoDocumento())) {
			sql.append(" AND FK_TIPO_DOCUMENTO = :idTipoDocumento");
			paramMap.addValue("idTipoDocumento", input.getIdTipoDocumento(),
					java.sql.Types.NUMERIC);
		} else if (input.getListaTipoDocumento() != null && input.getListaTipoDocumento().size() > 0) {
			String elencoTipiDocumento = "";
			for (int i = 0; i < input.getListaTipoDocumento().size(); i++) {
				elencoTipiDocumento += input.getListaTipoDocumento().get(i);
				if (i < (input.getListaTipoDocumento().size() - 1) ) {
					elencoTipiDocumento += ",";
				}
			}
			sql.append(" AND FK_TIPO_DOCUMENTO IN (" + elencoTipiDocumento + ")");
		}

		//le date possono essere valorizzate singolarmente e non per forza a coppia
		if (GenericUtil.isNotNullOrEmpty(input.getDataControlloA())
				&& GenericUtil.isNotNullOrEmpty(input.getDataControlloDa())) {
			sql.append(" AND DATA_CONTROLLO >= :dataDa   AND DATA_CONTROLLO <= :dataA");
			paramMap.addValue("dataDa",
					ConvertUtil.convertToSqlDate(input.getDataControlloDa()),
					java.sql.Types.DATE);
			paramMap.addValue("dataA",
					ConvertUtil.convertToSqlDate(input.getDataControlloA()),
					java.sql.Types.DATE);
		} else {
			if (GenericUtil.isNotNullOrEmpty(input.getDataControlloA())) {
				sql.append(" AND DATA_CONTROLLO <= :dataA");
				paramMap.addValue(
						"dataA",
						ConvertUtil.convertToSqlDate(input.getDataControlloA()),
						java.sql.Types.DATE);
			}

			if (GenericUtil.isNotNullOrEmpty(input.getDataControlloDa())) {
				sql.append(" AND DATA_CONTROLLO >= :dataDa");
				paramMap.addValue("dataDa", ConvertUtil.convertToSqlDate(input
						.getDataControlloDa()), java.sql.Types.DATE);
			}
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSicurezzaImpianti())) {

			sql.append(" AND F_FLG_PUO_FUNZIONARE = :sicImpianti");
			
			paramMap.addValue("sicImpianti", ConvertUtil
					.convertToBigDecimal(input.getSicurezzaImpianti()),
					java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getConOsservazioni())
				&& input.getConOsservazioni()) {
			sql.append(" AND F_OSSERVAZIONI IS NOT NULL");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getConPrescrizioni())
				&& input.getConPrescrizioni()) {
			sql.append(" AND F_PRESCRIZIONI IS NOT NULL");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getConRaccomandazioni())
				&& input.getConRaccomandazioni()) {
			sql.append(" AND F_RACCOMANDAZIONI IS NOT NULL");
		}
		

		if (GenericUtil.isNotNullOrEmpty(input.getInterventoDa())
				&& GenericUtil.isNotNullOrEmpty(input.getInterventoA())) {
			sql.append(" AND F_INTERVENTO_ENTRO >= :dataInterventoDa  AND F_INTERVENTO_ENTRO <= :dataInterventoA");
			paramMap.addValue("dataInterventoDa",
					ConvertUtil.convertToSqlDate(input.getInterventoDa()),
					java.sql.Types.DATE);
			paramMap.addValue("dataInterventoA",
					ConvertUtil.convertToSqlDate(input.getInterventoA()),
					java.sql.Types.DATE);
		} else {
			if (GenericUtil.isNotNullOrEmpty(input.getInterventoDa())) {
				sql.append(" AND F_INTERVENTO_ENTRO <= :dataInterventoDa");
				paramMap.addValue("dataInterventoDa",
						ConvertUtil.convertToSqlDate(input.getInterventoDa()),
						java.sql.Types.DATE);
			}
			if (GenericUtil.isNotNullOrEmpty(input.getInterventoA())) {
				sql.append(" AND F_INTERVENTO_ENTRO <= :dataInterventoA");
				paramMap.addValue("dataInterventoA",
						ConvertUtil.convertToSqlDate(input.getInterventoA()),
						java.sql.Types.DATE);
			}
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdBollinoSigla())) {
			sql.append(" AND FK_SIGLA_BOLLINO = :idSiglaBollino");
			paramMap.addValue("idSiglaBollino", input.getIdBollinoSigla(),
					java.sql.Types.VARCHAR);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getNumeroBollino())) {
			sql.append(" AND FK_NUMERO_BOLLINO = :idNumeroBollino");
			paramMap.addValue("idNumeroBollino", input.getNumeroBollino(),
					java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdReaSigla())
				&& GenericUtil.isNotNullOrEmpty(input.getNumeroRea())) {
			sql.append(" AND PG_SIGLA_REA = :siglaRea");
			sql.append(" AND PG_NUMERO_REA = :numeroRea");
			paramMap.addValue("siglaRea", input.getIdReaSigla(),
					java.sql.Types.VARCHAR);
			paramMap.addValue("numeroRea", input.getNumeroRea(),
					java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceFiscale())) {
			sql.append(" AND PG_CODICE_FISCALE = :codiceFiscale");
			paramMap.addValue("codiceFiscale", input.getCodiceFiscale(),
					java.sql.Types.VARCHAR);
		}

		//manca la gestione dei ruoli.....................

		if (GenericUtil.isNotNullOrEmpty(input.getDescrizioneRuoloFunzionale())) {
			if (Constants.RUOLO_RESPONSABILE_IMPRESA.equalsIgnoreCase(input
					.getDescrizioneRuoloFunzionale())
					|| Constants.RUOLO_RESPONSABILE.equalsIgnoreCase(input
							.getDescrizioneRuoloFunzionale())
					|| Constants.RUOLO_3RESPONSABILE.equalsIgnoreCase(input
							.getDescrizioneRuoloFunzionale())) {
				if (!"".equals(codiciImpianto)) {
					sql.append(" AND CODICE_IMPIANTO IN (" + codiciImpianto
							+ ") ");
				}
			}
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceImpianto())) {
			sql.append(" AND CODICE_IMPIANTO = :codImpianto");
			paramMap.addValue("codImpianto", input.getCodiceImpianto(),
					java.sql.Types.NUMERIC);
		}

		//sql.append(" ORDER BY DATA_CONTROLLO DESC, ID_ALLEGATO DESC ");


		Integer count = null;
		
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findByFiltriUtenteCount] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl",
					"findByFiltriUtenteCount", "esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findByFiltriUtenteCount] END");
		}
		return count;
	}
	
	public Integer findByTransazioneImpFilterCount(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.TransazioneFilter input)
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findByTransazioneImpFilterCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT COUNT (*) ");

		sql.append("FROM ( ");
		
		sql.append(" SELECT tran.ID_TRANSAZIONE, pg.SIGLA_REA, pg.NUMERO_REA, pg.CODICE_FISCALE, pg.DENOMINAZIONE, tran.CF_UTENTE, tran.DATA_TRANSAZIONE, tran.IMPIANTO_DA, tran.IMPIANTO_A ");
		
		sql.append(" FROM SIGIT_T_TRANSAZIONE_IMP tran, SIGIT_T_PERSONA_GIURIDICA pg, SIGIT_T_CODICE_IMP codImp");

		sql.append(" WHERE ");

		sql.append("tran.FK_PERSONA_GIURIDICA = pg.ID_PERSONA_GIURIDICA AND tran.ID_TRANSAZIONE = codImp.FK_TRANSAZIONE");

		sql.append(" AND ");

		sql.append("1=1");

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceImpianto())) {
			sql.append(" AND codImp.CODICE_IMPIANTO = :codiceImpianto");
			paramMap.addValue("codiceImpianto", input.getCodiceImpianto());

		}

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaRea())
				&& GenericUtil.isNotNullOrEmpty(input.getNumeroRea())) {
			sql.append(" AND pg.SIGLA_REA = :siglaRea");
			sql.append(" AND pg.NUMERO_REA = :numeroRea");
			paramMap.addValue("siglaRea", input.getSiglaRea());
			paramMap.addValue("numeroRea", input.getNumeroRea());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceFiscale())) {
			sql.append(" AND UPPER(pg.CODICE_FISCALE) = UPPER(:codiceFiscale)");
			paramMap.addValue("codiceFiscale", input.getCodiceFiscale());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataAcquisizioneDa())) {
			sql.append(" AND tran.DATA_TRANSAZIONE >= :dataAcquisizioneDa");
			paramMap.addValue("dataAcquisizioneDa", input.getDataAcquisizioneDa(),
					java.sql.Types.DATE);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataAcquisizioneA())) {
			sql.append(" AND tran.DATA_TRANSAZIONE <= :dataAcquisizioneA");
			paramMap.addValue("dataAcquisizioneA", input.getDataAcquisizioneA(),
					java.sql.Types.DATE);
		}
		
		sql.append(" GROUP BY tran.ID_TRANSAZIONE, pg.SIGLA_REA, pg.NUMERO_REA, pg.CODICE_FISCALE, pg.DENOMINAZIONE, tran.CF_UTENTE, tran.DATA_TRANSAZIONE, tran.IMPIANTO_DA, tran.IMPIANTO_A");
		
		sql.append(" ) a "); 
		
		//sql.append(" ORDER BY tran.ID_TRANSAZIONE");


		Integer count = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);
		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findByTransazioneImpFilterCount] ERROR esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl",
					"findByTransazioneImpFilterCount", "esecuzione query",
					sql.toString());
			log.debug("[SigitExtDaoImpl::findByTransazioneImpFilterCount] END");
		}
		return count;
	}

	public Integer findByTransazioneBollFilterCount(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.TransazioneFilter input)
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findByTransazioneBollFilterCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT COUNT (*) ");

		sql.append(" FROM ( ");
		
		sql.append(" SELECT tran.ID_TRANSAZIONE_BOLL, pg.SIGLA_REA, pg.NUMERO_REA, pg.CODICE_FISCALE, pg.DENOMINAZIONE, tran.CF_UTENTE, tran.DATA_TRANSAZIONE, tran.BOLLINO_DA, tran.BOLLINO_A, tran.SIGLA_BOLLINO ");
		
		sql.append(" FROM SIGIT_T_TRANSAZIONE_BOLL tran, SIGIT_T_PERSONA_GIURIDICA pg, SIGIT_T_CODICE_BOLL cb");

		sql.append(" WHERE ");

		sql.append("tran.FK_PERSONA_GIURIDICA = pg.ID_PERSONA_GIURIDICA AND tran.ID_TRANSAZIONE_BOLL = cb.FK_TRANSAZIONE_BOLL");

		sql.append(" AND ");

		sql.append("1=1");

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaBollino())) {
			sql.append(" AND cb.SIGLA_BOLLINO = :siglaBollino");
			paramMap.addValue("siglaBollino", input.getSiglaBollino());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getNumeroBollino())) {
			sql.append(" AND cb.NUMERO_BOLLINO = :numeroBollino");
			paramMap.addValue("numeroBollino", input.getNumeroBollino());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaRea())
				&& GenericUtil.isNotNullOrEmpty(input.getNumeroRea())) {
			sql.append(" AND pg.SIGLA_REA = :siglaRea");
			sql.append(" AND pg.NUMERO_REA = :numeroRea");
			paramMap.addValue("siglaRea", input.getSiglaRea());
			paramMap.addValue("numeroRea", input.getNumeroRea());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceFiscale())) {
			sql.append(" AND UPPER(pg.CODICE_FISCALE) = UPPER(:codiceFiscale)");
			paramMap.addValue("codiceFiscale", input.getCodiceFiscale());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataAcquisizioneDa())) {
			sql.append(" AND tran.DATA_TRANSAZIONE >= :dataAcquisizioneDa");
			paramMap.addValue("dataAcquisizioneDa", input.getDataAcquisizioneDa(),
					java.sql.Types.DATE);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataAcquisizioneA())) {
			sql.append(" AND tran.DATA_TRANSAZIONE <= :dataAcquisizioneA");
			paramMap.addValue("dataAcquisizioneA", input.getDataAcquisizioneA(),
					java.sql.Types.DATE);
		}
		
		sql.append(" AND tran.ID_STATO_TRANSAZIONE = "
				+ Constants.TRANSAZIONE_MDP_OK);

		sql.append(" GROUP BY tran.ID_TRANSAZIONE_BOLL, pg.SIGLA_REA, pg.NUMERO_REA, pg.CODICE_FISCALE, pg.DENOMINAZIONE, tran.CF_UTENTE, tran.DATA_TRANSAZIONE, tran.BOLLINO_DA, tran.BOLLINO_A");
		
		sql.append(" ) a ");
		//sql.append(" ORDER BY tran.ID_TRANSAZIONE_BOLL");

		log.debug("STAMPO  QUERY DEL RECUPERO CODICI BOLLINI: " + sql);


		Integer count = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);
		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findByTransazioneBollFilterCount] ERROR esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl",
					"findByTransazioneBollFilterCount", "esecuzione query",
					sql.toString());
			log.debug("[SigitExtDaoImpl::findByTransazioneBollFilterCount] END");
		}
		return count;
	}
	
	
	@SuppressWarnings("unchecked")
	public Integer findCodImpiantoUtilizzatiByIdTransCount(
			java.lang.Integer input) throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findCodImpiantoUtilizzatiByIdTransCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append("SELECT COUNT (*) ");
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_CODICE_IMP ci, SIGIT_T_IMPIANTO i");
		sql.append(" WHERE ");
		// personalizzare la query SQL relativa al finder

		sql.append(" ci.CODICE_IMPIANTO = i.CODICE_IMPIANTO");

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" AND FK_TRANSAZIONE = :idTransazione");

		//***aggiungere tutte le condizioni

		paramMap.addValue("idTransazione", input);

		Integer count = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findCodImpiantoUtilizzatiByIdTransCount] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl",
					"findCodImpiantoUtilizzatiByIdTransCount", "esecuzione query",
					sql.toString());
			log.debug("[SigitExtDaoImpl::findCodImpiantoUtilizzatiByIdTransCount] END");
		}
		return count;
	}

	
	@SuppressWarnings("unchecked")
	public Integer findManutentoriByFilterCount(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findManutentoriByFilterCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		
		
		
		sql.append("SELECT COUNT (*) ");
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_R_COMP4_MANUT");
		sql.append(" WHERE ");
		// personalizzare la query SQL relativa al finder

		sql.append(" CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND ID_TIPO_COMPONENTE = :tipoComp");
		
		//sql.append(" AND :dataRapporto BETWEEN DATA_INSTALL AND COALESCE(DATA_FINE, :dataRapporto)");
		sql.append(" AND DATA_FINE IS NULL");

		if (input.getListProgressivi() != null
				&& !input.getListProgressivi().isEmpty()) {
			sql.append(" AND PROGRESSIVO IN  (");
			boolean aggVirg = false;
			for (String progr : input.getListProgressivi()) {
				if (aggVirg)
					sql.append(", ");
				sql.append(progr);
				aggVirg = true;
			}
			sql.append(") ");
		}
		
		
		sql.append(" GROUP BY FK_PERSONA_GIURIDICA ");

		paramMap.addValue("codImpianto", input.getCodImpianto(),
				java.sql.Types.NUMERIC);

		paramMap.addValue("tipoComp", input.getTipoComponente(),
				java.sql.Types.VARCHAR);
		
		paramMap.addValue("dataRapporto", input.getDataInstallazione(),
				java.sql.Types.DATE);

		/*
		 
	
	SELECT count (*)
	 FROM SIGIT_T_COMP4
	 WHERE  CODICE_IMPIANTO = 1611
	 AND ID_TIPO_COMPONENTE = 'GT' 
	 AND to_date('19/5/2015-0:0:0','DD/MM/YYYY HH24:MI:SS') 
	 BETWEEN DATA_INSTALL AND COALESCE(DATA_DISMISS, to_date('19/5/2015-0:0:0','DD/MM/YYYY HH24:MI:SS')) 
	 group by ID_TIPO_COMPONENTE
	 
		 */
		

		Integer count = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findManutentoriByFilterCount] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl",
					"findManutentoriByFilterCount", "esecuzione query",
					sql.toString());
			log.debug("[SigitExtDaoImpl::findManutentoriByFilterCount] END");
		}
		return count;
	}
	
	/** 
	 * Implementazione del finder findImpiantiByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitExtComponenteDto> findComponentiByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findComponentiByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT cm.ID_R_COMP4_MANUT, cm.FK_PERSONA_GIURIDICA,c.ID_TIPO_COMPONENTE,c.PROGRESSIVO,m.DES_MARCA,c.MODELLO ");
		sql.append("FROM SIGIT_T_COMP4 c, SIGIT_R_COMP4_MANUT cm, SIGIT_D_MARCA m ");
		sql.append("WHERE ");
		sql.append("c.CODICE_IMPIANTO = cm.CODICE_IMPIANTO ");
		sql.append("AND c.ID_TIPO_COMPONENTE = cm.ID_TIPO_COMPONENTE ");
		sql.append("AND c.PROGRESSIVO = cm.PROGRESSIVO ");
		//sql.append("AND c.DATA_INSTALL = cm.DATA_INSTALL ");
		sql.append("AND c.FK_MARCA = m.ID_MARCA ");
		
		sql.append("AND c.CODICE_IMPIANTO = :codImpianto ");
		sql.append("AND c.ID_TIPO_COMPONENTE = :tipoComp ");

		if (input.getListCombustibile() != null
				&& !input.getListCombustibile().isEmpty()) {
			sql.append(" AND c.FK_COMBUSTIBILE IN  (");
			boolean aggVirg = false;
			for (String progr : input.getListCombustibile()) {
				if (aggVirg)
					sql.append(", ");
				sql.append(progr);
				aggVirg = true;
			}
			sql.append(") ");
		}
		
		//sql.append("AND :dataRapporto BETWEEN c.DATA_INSTALL AND COALESCE(c.DATA_DISMISS, :dataRapporto) ");
		
		//mettere la persona giuridica = sigit_r_comp4_manut
		sql.append("AND cm.DATA_FINE IS NULL ");
		sql.append("ORDER BY PROGRESSIVO ASC, c.DATA_INSTALL DESC ");
		
		paramMap.addValue("codImpianto", input.getCodImpianto(),
				java.sql.Types.NUMERIC);

		paramMap.addValue("tipoComp", input.getTipoComponente(),
				java.sql.Types.VARCHAR);
		
		
		
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
	
	/** 
	 * Implementazione del finder findComponentiByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitExtComponenteDto> findComponentiByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input, String nomeTabellaComp)
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

		log.debug("#### Stampo la lista combustibili: "+input.getListCombustibile());
		
		if (input.getListCombustibile() != null
				&& !input.getListCombustibile().isEmpty()) {
			sql.append(" AND comp.FK_COMBUSTIBILE IN  (");
			boolean aggVirg = false;
			for (String progr : input.getListCombustibile()) {
				if (aggVirg)
					sql.append(", ");
				sql.append(progr);
				aggVirg = true;
			}
			sql.append(") ");
		}
		
		if (input.getListNotCombustibile() != null
				&& !input.getListNotCombustibile().isEmpty()) {
			sql.append(" AND comp.FK_COMBUSTIBILE NOT IN  (");
			boolean aggVirg = false;
			for (String progr : input.getListNotCombustibile()) {
				if (aggVirg)
					sql.append(", ");
				sql.append(progr);
				aggVirg = true;
			}
			sql.append(") ");
		}
		
		sql.append("AND :dataRapporto BETWEEN comp.DATA_INSTALL AND COALESCE(comp.DATA_DISMISS, :dataRapporto) ");
		
		if (GenericUtil.isNotNullOrEmpty(input.getIdPG()))
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
		
		if (GenericUtil.isNotNullOrEmpty(input.getIdPG()))
		{
			paramMap.addValue("idPersonaGiuridica", input.getIdPG(),
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


	public SigitTGraffaturaPk insertGraffaturaWithId(SigitTGraffaturaDto dto)

	{
		final String sql = "INSERT INTO SIGIT_T_GRAFFATURA ( 	ID_GRAFFATURA,CODICE_IMPIANTO,DT_INSERIMENTO,DT_CANCELLAZIONE,UTENTE_ULT_MOD ) VALUES (  :ID_GRAFFATURA , :CODICE_IMPIANTO , :DT_INSERIMENTO , :DT_CANCELLAZIONE , :UTENTE_ULT_MOD  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_GRAFFATURA]
		params.addValue("ID_GRAFFATURA", dto.getIdGraffatura(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_INSERIMENTO]
		params.addValue("DT_INSERIMENTO", dto.getDtInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DT_CANCELLAZIONE]
		params.addValue("DT_CANCELLAZIONE", dto.getDtCancellazione(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		return dto.createPk();

	}


	public SigitTGraffaturaPk insertGraffaturaAutoIncrement(SigitTGraffaturaDto dto) throws SigitExtDaoException {
		final String sql = "INSERT INTO SIGIT_T_GRAFFATURA ( 	ID_GRAFFATURA,CODICE_IMPIANTO,DT_INSERIMENTO,DT_CANCELLAZIONE,UTENTE_ULT_MOD ) VALUES (  :ID_GRAFFATURA , :CODICE_IMPIANTO , :DT_INSERIMENTO , :DT_CANCELLAZIONE , :UTENTE_ULT_MOD  )";

		MapSqlParameterSource params = new MapSqlParameterSource();
		dto.setIdGraffatura(getSeqTGraffatura());
		// valorizzazione paametro relativo a colonna [ID_GRAFFATURA]
		params.addValue("ID_GRAFFATURA", dto.getIdGraffatura(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_INSERIMENTO]
		params.addValue("DT_INSERIMENTO", dto.getDtInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DT_CANCELLAZIONE]
		params.addValue("DT_CANCELLAZIONE", dto.getDtCancellazione(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		return dto.createPk();

	}

	/** 
	 * Implementazione del finder findComponentiByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitExtComponenteDto> findComponentiSubentroByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input, String nomeTabellaComp)
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findComponentiSubentroByFilter] START");
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
		sql.append("AND cm.FK_PERSONA_GIURIDICA != :idPg ");

		// devo escludere i suoi????
//		if (GenericUtil.isNotNullOrEmpty(input.getIdPG()))
//		{
//			sql.append(" AND cm.FK_PERSONA_GIURIDICA = :idPersonaGiuridica");
//		}
		
		//mettere la persona giuridica = sigit_r_comp4_manut
		sql.append("AND cm.DATA_FINE IS NULL ");
		sql.append("AND comp.DATA_DISMISS IS NULL ");
		
		sql.append("ORDER BY PROGRESSIVO ASC, comp.DATA_INSTALL DESC ");
		
		paramMap.addValue("codImpianto", input.getCodImpianto(),
				java.sql.Types.NUMERIC);

		paramMap.addValue("tipoComp", input.getTipoComponente(),
				java.sql.Types.VARCHAR);
		
		paramMap.addValue("idPg", input.getIdPG(),
				java.sql.Types.NUMERIC);
		
		
		
		// devo escludere i suoi????
//		if (GenericUtil.isNotNullOrEmpty(input.getIdPG()))
//		{
//			paramMap.addValue("idPersonaGiuridica", input.getIdPG(),
//					java.sql.Types.NUMERIC);
//		}
		
		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		List<SigitExtComponenteDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap,
					componentiByFiltroRowMapper);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findComponentiSubentroByFilter] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findComponentiSubentroByFilter",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findComponentiSubentroByFilter] END");
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Integer findImpiantiByFilterCount(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImpiantoFilter input)
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findImpiantiByFilterCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT COUNT (*) ");
		
		sql.append(" FROM VISTA_RICERCA_IMPIANTI vri ");
		
		sql.append(" WHERE ");

		sql.append(" 1=1 ");

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceImpianto())) {
			sql.append(" AND CODICE_IMPIANTO = :codiceImp");
			paramMap.addValue("codiceImp", input.getCodiceImpianto());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaProvincia())) {
			sql.append(" AND SIGLA_PROVINCIA = :provincia");
			paramMap.addValue("provincia", input.getSiglaProvincia());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaComune())) {
			sql.append(" AND ISTAT_COMUNE = :comune");
			paramMap.addValue("comune", input.getSiglaComune());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIndirizzo())) {
			sql.append(" AND UPPER(INDIRIZZO_SITAD) LIKE UPPER('%"+input.getIndirizzo()+"%') ");
		}
		
		if (GenericUtil.isNotNullOrEmpty(input.getCfResponsabile())) {
			sql.append(" AND CODICE_FISCALE = :cf");
			paramMap.addValue("cf", input.getCfResponsabile());
		}
		
		if (GenericUtil.isNotNullOrEmpty(input.getCf3Responsabile())) {
			sql.append(" AND CODICE_FISCALE_3R = :cf3r");
			paramMap.addValue("cf3r", input.getCf3Responsabile());
		}
		
		if (GenericUtil.isNotNullOrEmpty(input.getSiglaRea())
				|| GenericUtil.isNotNullOrEmpty(input.getNumeroRea())
				|| GenericUtil.isNotNullOrEmpty(input.getCfDitta())) {
			sql.append(" AND EXISTS ( select 1 FROM vista_impianti_imprese vii WHERE ");
			sql.append(" vri.CODICE_IMPIANTO = vii.CODICE_IMPIANTO ");

			if (GenericUtil.isNotNullOrEmpty(input.getSiglaRea())) {
				sql.append(" AND SIGLA_REA = :siglaRea");
				paramMap.addValue("siglaRea", input.getSiglaRea());
			}

			if (GenericUtil.isNotNullOrEmpty(input.getNumeroRea())) {
				sql.append(" AND NUMERO_REA = :numeroRea");
				paramMap.addValue("numeroRea", input.getNumeroRea());
			}

			if (GenericUtil.isNotNullOrEmpty(input.getCfDitta())) {
				sql.append(" AND CODICE_FISCALE = :cfImpresa");
				paramMap.addValue("cfImpresa", input.getCfDitta());
			}

			sql.append(" ) ");

		}

		
		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		Integer count = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findImpiantiByFilterCount] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findImpiantiByFilterCount",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findImpiantiByFilterCount] END");
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public Integer findRapportiInviatiCatCount(
			Integer input)
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findRapportiInviatiCatCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT COUNT (*) ");
		
		sql.append(" FROM SIGIT_T_ALLEGATO ");
		
		sql.append(" WHERE ");

		sql.append(" FK_PG_CAT = :idCat ");

		paramMap.addValue("idCat", input);

		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		Integer count = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findRapportiInviatiCatCount] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findRapportiInviatiCatCount",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findRapportiInviatiCatCount] END");
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public Integer findLogDaStoricizzareCount()
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findLogDaStoricizzareCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT COUNT (*) ");
		
		sql.append(" FROM SIGIT_WRK_LOG ");
		
		sql.append(" WHERE ");

		sql.append(" DATE_PART('year', DATA_OPERAZIONE) <= DATE_PART('year', now())-2 ");

		/*
		SELECT COUNT(*)
		FROM SIGIT_WRK_LOG
		WHERE DATE_PART('year', DATA_OPERAZIONE) = date_part('year', now())-2;
		*/
		

		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		Integer count = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findLogDaStoricizzareCount] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findLogDaStoricizzareCount",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findLogDaStoricizzareCount] END");
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public Integer findLogDaCancellareCount()
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findLogDaCancellareCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT COUNT (*) ");
		
		sql.append(" FROM SIGIT_WRK_LOG_PREC ");
		
		sql.append(" WHERE ");

		sql.append(" DATE_PART('year', DATA_OPERAZIONE) <= DATE_PART('year', now())-3 ");

		/*
		SELECT COUNT(*)
		FROM SIGIT_WRK_LOG_PREC
		*/

		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		Integer count = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findLogDaCancellareCount] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findLogDaCancellareCount",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findLogDaCancellareCount] END");
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public Integer findLibrettiDaStoricizzareCount()
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findLibrettiDaStoricizzareCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT COUNT (*) ");
		
		sql.append(" FROM SIGIT_T_LIBRETTO ");
		
		sql.append(" WHERE ");

		sql.append(" DATE_PART('year', DATA_CONSOLIDAMENTO) <= DATE_PART('year', now())-6 ");

		/*
		SELECT COUNT(*) FROM SIGIT_T_LIBRETTO
		WHERE DATE_PART('year', DATA_CONSOLIDAMENTO) < date_part('year', now())- 4;
		*/

		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		Integer count = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findLibrettiDaStoricizzareCount] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findLibrettiDaStoricizzareCount",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findLibrettiDaStoricizzareCount] END");
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public Integer findLibrettiDaCancellareCount()
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findLibrettiDaCancellareCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT COUNT (*) ");
		
		sql.append(" FROM SIGIT_S_LIBRETTO ");
		
		sql.append(" WHERE ");

		sql.append(" DATE_PART('year', DATA_CONSOLIDAMENTO) <= DATE_PART('year', now())-11 ");
		
		/*
		SELECT COUNT(*) FROM SIGIT_S_LIBRETTO
		WHERE DATE_PART('year', DATA_CONSOLIDAMENTO) = date_part('year', now())- 10;
		*/

		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		Integer count = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findLibrettiDaCancellareCount] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findLibrettiDaCancellareCount",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findLibrettiDaCancellareCount] END");
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public Integer findLogAccessoDaStoricizzareCount()
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findLogAccessoDaStoricizzareCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT COUNT (*) ");
		
		sql.append(" FROM SIGIT_L_ACCESSO ");
		
		sql.append(" WHERE ");

		sql.append(" DATE_PART('year', DT_ACCESSO) < (DATE_PART('year', now()) - 1) ");

		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		Integer count = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findLogAccessoDaStoricizzareCount] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findLogAccessoDaStoricizzareCount",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findLogAccessoDaStoricizzareCount] END");
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public Integer findLogAccessoDaCancellareCount()
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findLogAccessoDaCancellareCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT COUNT (*) ");
		
		sql.append(" FROM SIGIT_S_ACCESSO ");
		
		sql.append(" WHERE ");

		sql.append(" DATE_PART('year', DT_ACCESSO) < (DATE_PART('year', now()) - 4) ");
		
		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		Integer count = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findLogAccessoDaCancellareCount] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findLogAccessoDaCancellareCount",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findLogAccessoDaCancellareCount] END");
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public Integer findImpiantiSenzaCoordinateCount() throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findImpiantiSenzaCoordinateCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT COUNT (*) ");
		
		sql.append(" FROM SIGIT_T_IMPIANTO ");
		
		sql.append(" WHERE ");

		sql.append(" COORD_X_LONG_DD IS NULL OR COORD_Y_LAT_DD IS NULL ");
		
		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		Integer count = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findImpiantiSenzaCoordinateCount] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findImpiantiSenzaCoordinateCount",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findImpiantiSenzaCoordinateCount] END");
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public Integer findImpiantiAggiornatiADataCount(String date) throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findImpiantiAggiornatiADataCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT COUNT (*) ");
		
		sql.append(" FROM SIGIT_T_IMPIANTO ");
		
		sql.append(" WHERE ");

		sql.append(" DATA_ULT_MOD < :data_aggiornamento::date ");

		paramMap.addValue("data_aggiornamento", date);
		
		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		Integer count = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findImpiantiAggiornatiADataCount] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findImpiantiAggiornatiADataCount",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findImpiantiAggiornatiADataCount] END");
		}
		return count;
	}
	
	/*
	@SuppressWarnings("unchecked")
	public Integer storicizzaLog()
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::storicizzaLog] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("INSERT INTO SIGIT_WRK_LOG_PREC ");
		
		sql.append(" SELECT * ");
		
		sql.append(" FROM SIGIT_WRK_LOG ");

		sql.append(" WHERE DATE_PART('year', DATA_OPERAZIONE) <= DATE_PART('year', now())-2 ");

		sql.append(" LIMIT (SELECT VALORE_CONFIG_NUM FROM SIGIT_WRK_CONFIG WHERE CHIAVE_CONFIG='MAX_RECORDS_STORICIZZAZIONE') ");
		
		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		Integer count = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::storicizzaLog] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "storicizzaLog",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::storicizzaLog] END");
		}
		return count;
	}
	*/

	/** 
	 * Implementazione del finder findIspezioniDettConCodImpiantoByListConImpianti
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitExtIspezioniConCodImpiantoDto> findIspezioniDettConCodImpiantoByListConImpianti(ArrayList<String> listCodImpianti)
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findIspezioniDettConCodImbiantoByListIdIspez] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("select codice_impianto, ruolo, id_responsabile, ");
		sql.append("cognome_denominazione, nome, codice_fiscale, indirizzo, ");
		sql.append("civico, cap, comune, provincia, email, sigla_rea, numero_rea ");
		sql.append("from ( ");
		sql.append("select ric_imp.codice_impianto, ric_imp.ruolo_funz ruolo, ric_imp.id_pf_responsabile id_responsabile, ");
		sql.append("pf.cognome cognome_denominazione, pf.nome, pf.codice_fiscale, COALESCE(pf.indirizzo_sitad, pf.indirizzo_non_trovato) indirizzo, ");
		sql.append("pf.civico, pf.cap, pf.comune, pf.provincia, pf.email, NULL sigla_rea, NULL numero_rea ");
		sql.append("from vista_ricerca_impianti ric_imp ");
		sql.append("join sigit_t_persona_fisica pf on pf.id_persona_fisica = ric_imp.id_pf_responsabile ");
		sql.append("union ");
		sql.append("select ric_imp.codice_impianto, ric_imp.ruolo_funz ruolo, ric_imp.id_pg_responsabile id_responsabile, ");
		sql.append("pg.denominazione cognome_denominazione, NULL nome, pg.codice_fiscale, COALESCE(pg.indirizzo_sitad, pg.indirizzo_non_trovato) indirizzo, ");
		sql.append("pg.civico, pg.cap, pg.comune, pg.provincia, pg.email, pg.sigla_rea, pg.numero_rea ");
		sql.append("from vista_ricerca_impianti ric_imp ");
		sql.append("join sigit_t_persona_giuridica pg on pg.id_persona_giuridica = ric_imp.id_pg_responsabile ");
		sql.append("union ");
		sql.append("select ric_imp.codice_impianto, 'Terzo Responsabile' ruolo, ric_imp.id_pg_3r id_responsabile, ");
		sql.append("pg3.denominazione cognome_denominazione, NULL nome, pg3.codice_fiscale, COALESCE(pg3.indirizzo_sitad, pg3.indirizzo_non_trovato) indirizzo, ");
		sql.append("pg3.civico, pg3.cap, pg3.comune, pg3.provincia, pg3.email, pg3.sigla_rea, pg3.numero_rea ");
		sql.append("from vista_ricerca_impianti ric_imp ");
		sql.append("join sigit_t_persona_giuridica pg3 on (pg3.id_persona_giuridica = ric_imp.id_pg_3r) ");
		sql.append("union ");
		sql.append("select imp_imp.codice_impianto, dr.des_ruolo ruolo, manut.id_persona_giuridica id_responsabile, ");
		sql.append("manut.denominazione cognome_denominazione, NULL nome, manut.codice_fiscale, COALESCE(manut.indirizzo_sitad, manut.indirizzo_non_trovato) indirizzo, ");
		sql.append("manut.civico, manut.cap, manut.comune, manut.provincia, manut.email, manut.sigla_rea, manut.numero_rea ");
		sql.append("from vista_impianti_imprese imp_imp ");
		sql.append("join sigit_d_ruolo dr on dr.id_ruolo = imp_imp.fk_ruolo ");
		sql.append("join sigit_t_persona_giuridica manut on (manut.numero_rea = imp_imp.numero_rea and manut.sigla_rea = imp_imp.sigla_rea and manut.codice_fiscale = imp_imp.codice_fiscale) ");
		sql.append("where fk_ruolo in ("+Constants.ID_RUOLO_MANUTENTORE_ALL_1+","+Constants.ID_RUOLO_MANUTENTORE_ALL_2+","+Constants.ID_RUOLO_MANUTENTORE_ALL_3+","+Constants.ID_RUOLO_MANUTENTORE_ALL_4+") ");
		sql.append(") a ");
		
		String elencoCodImpianti = "";
		for (int i = 0; i < listCodImpianti.size(); i++) {
			elencoCodImpianti += listCodImpianti.get(i);
			if (i < (listCodImpianti.size() - 1) ) {
				elencoCodImpianti += ",";
			}
		}
		sql.append(" where a.codice_impianto IN (" + elencoCodImpianti + ") ");
		
		sql.append("order by a.codice_impianto, ruolo, id_responsabile ");
		
		// devo escludere i suoi????
//		if (GenericUtil.isNotNullOrEmpty(input.getIdPG()))
//		{
//			paramMap.addValue("idPersonaGiuridica", input.getIdPG(),
//					java.sql.Types.NUMERIC);
//		}
		
		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		List<SigitExtIspezioniConCodImpiantoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap,
					ispezioniConCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findIspezioniDettConCodImbiantoByListIdIspez] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findIspezioniDettConCodImbiantoByListIdIspez",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findIspezioniDettConCodImbiantoByListIdIspez] END");
		}
		return list;
	}
	
	/** 
	 * Implementazione del finder findIspezioniDettSenzaCodImpiantoByListIdIspez
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitExtIspezioniSenzaCodImpiantoDto> findIspezioniDettSenzaCodImpiantoByListIdIspez(ArrayList<String> listIdIspezioni)
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findIspezioniDettSenzaCodImpiantoByListIdIspez] START");
		StringBuilder sql1 = new StringBuilder();
		StringBuilder sql2 = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		
		sql1.append("select i.id_ispezione_2018, d.flg_pf_pg, d.cognome_denom, d.nome, d.cf_piva, d.dug, d.indirizzo, d.civico, d.cap, d.istat_comune, ");
		sql2.append("select i.id_ispezione_2018, d.flg_pf_pg, d.cognome_denom, d.nome, d.cf_piva, d.dug, d.indirizzo, d.civico, d.cap, d.istat_comune, ");
		sql1.append("d.flg_pf_pg_fatt, d.cognome_denom_fatt, d.nome_fatt, d.cf_piva_fatt, d.dug_fatt, d.indirizzo_fatt, d.civico_fatt, d.cap_fatt, d.istat_comune_fatt, ");
		sql2.append("d.flg_pf_pg_fatt, d.cognome_denom_fatt, d.nome_fatt, d.cf_piva_fatt, d.dug_fatt, d.indirizzo_fatt, d.civico_fatt, d.cap_fatt, d.istat_comune_fatt, ");

		sql1.append("c.des_tipo_contratto_distrib, u.des_categoria_util, comb.des_combustibile, m.des_unita_misura, ");
		sql2.append("c.des_tipo_contratto_distrib, u.des_categoria_util, comb.des_combustibile, m.des_unita_misura, ");
		sql1.append("d.anno_rif, d.nr_mesi_fattur, d.consumo_anno, d.consumo_mensile ");
		sql2.append("d.anno_rif, d.nr_mesi_fattur, d.consumo_anno, d.consumo_mensile ");
		
		sql1.append("from sigit_t_ispezione_2018 i, sigit_t_verifica v, sigit_t_dato_distrib d, ");
		sql2.append("from sigit_t_ispezione_2018 i, sigit_t_verifica v, sigit_t_accertamento a, sigit_t_dato_distrib d, ");
		sql1.append("sigit_d_tipo_contratto_distrib c, sigit_d_categoria_util u, sigit_d_combustibile comb, sigit_d_unita_misura m");
		sql2.append("sigit_d_tipo_contratto_distrib c, sigit_d_categoria_util u, sigit_d_combustibile comb, sigit_d_unita_misura m");

		//sql.append("where i.id_ispezione_2018 IN (194,175,157,151,150,139,136,129,116,115,112,102) ");
		
		String elencoidIspezioni = "";
		for (int i = 0; i < listIdIspezioni.size(); i++) {
			elencoidIspezioni += listIdIspezioni.get(i);
			if (i < (listIdIspezioni.size() - 1) ) {
				elencoidIspezioni += ",";
			}
		}
		sql1.append(" where i.id_ispezione_2018 IN (" + elencoidIspezioni + ") ");
		sql2.append(" where i.id_ispezione_2018 IN (" + elencoidIspezioni + ") ");
		
		sql1.append("and i.fk_verifica <> 0 ");
		sql1.append("and v.id_verifica = i.fk_verifica ");
		
		sql2.append("and i.fk_verifica = 0 ");
		sql2.append("and a.id_accertamento = i.fk_accertamento ");
		sql2.append("and v.id_verifica = a.fk_verifica ");

		sql1.append("and v.fk_dato_distrib = d.id_dato_distrib ");
		sql2.append("and v.fk_dato_distrib = d.id_dato_distrib ");

		sql1.append("and d.fk_tipo_contratto = c.id_tipo_contratto_distrib ");
		sql2.append("and d.fk_tipo_contratto = c.id_tipo_contratto_distrib ");
		sql1.append("and d.fk_categoria_util = u.id_categoria_util ");
		sql2.append("and d.fk_categoria_util = u.id_categoria_util ");
		sql1.append("and d.fk_combustibile = comb.id_combustibile ");
		sql2.append("and d.fk_combustibile = comb.id_combustibile ");
		sql1.append("and d.fk_unita_misura = m.id_unita_misura ");
		sql2.append("and d.fk_unita_misura = m.id_unita_misura ");

		sql1.append("order by i.id_ispezione_2018 ");
		sql2.append("order by i.id_ispezione_2018 ");
		
		
		// devo escludere i suoi????
//		if (GenericUtil.isNotNullOrEmpty(input.getIdPG()))
//		{
//			paramMap.addValue("idPersonaGiuridica", input.getIdPG(),
//					java.sql.Types.NUMERIC);
//		}
		
		log.debug("STAMPO LA QUERY 1: " + sql1.toString());
		log.debug("STAMPO LA QUERY 2: " + sql2.toString());
		
		List<SigitExtIspezioniSenzaCodImpiantoDto> list = new ArrayList<SigitExtIspezioniSenzaCodImpiantoDto>();
		List<SigitExtIspezioniSenzaCodImpiantoDto> list1 = null;
		List<SigitExtIspezioniSenzaCodImpiantoDto> list2 = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list1 = jdbcTemplate.query(sql1.toString(), paramMap,
					ispezioniSenzaCodImpiantoRowMapper);
			
		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findIspezioniDettSenzaCodImpiantoByListIdIspez] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findIspezioniDettSenzaCodImpiantoByListIdIspez",
					"esecuzione query", sql1.toString());
			log.debug("[SigitExtDaoImpl::findIspezioniDettSenzaCodImpiantoByListIdIspez] END");
		}

		stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list2 = jdbcTemplate.query(sql2.toString(), paramMap,
					ispezioniSenzaCodImpiantoRowMapper);
			
		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findIspezioniDettSenzaCodImpiantoByListIdIspez] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findIspezioniDettSenzaCodImpiantoByListIdIspez",
					"esecuzione query", sql2.toString());
			log.debug("[SigitExtDaoImpl::findIspezioniDettSenzaCodImpiantoByListIdIspez] END");
		}
		
		list.addAll(list1);
		list.addAll(list2);

		return list;
	}
	
	/** 
	 * Implementazione del finder findIspezioniDettSenzaCodImpiantoByListIdIspez
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitExtIspezioniDto> findIspezioniDettByListIdIspez(ArrayList<String> listIdIspezioni)
			throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::findIspezioniDettByListIdIspez] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT ID_ISPEZIONE_2018,isp.CODICE_IMPIANTO,DES_STATO_ISPEZIONE,DT_CREAZIONE,FLG_ESITO,NOME,COGNOME, ");
		sql.append("CODICE_FISCALE,ISTAT_PROV_COMPETENZA, CF_ISPETTORE_SECONDARIO,FLG_ISP_PAGAMENTO, ");
		sql.append("COALESCE(u.indirizzo_sitad, u.indirizzo_non_trovato) AS INDIRIZZO_UNITA_IMMOB, u.CIVICO, imp.DENOMINAZIONE_COMUNE, imp.SIGLA_PROVINCIA, ");
		sql.append("imp.L1_3_POT_H2O_KW, imp.L1_3_POT_CLIMA_INV_KW, imp.L1_3_POT_CLIMA_EST_KW ");
		sql.append("FROM VISTA_RICERCA_ISPEZIONI AS isp ");
		sql.append("LEFT JOIN sigit_t_impianto AS imp ON isp.CODICE_IMPIANTO = imp.CODICE_IMPIANTO ");
		sql.append("LEFT JOIN sigit_t_unita_immobiliare AS u ON u.CODICE_IMPIANTO = imp.CODICE_IMPIANTO ");

		String elencoidIspezioni = "";
		for (int i = 0; i < listIdIspezioni.size(); i++) {
			elencoidIspezioni += listIdIspezioni.get(i);
			if (i < (listIdIspezioni.size() - 1) ) {
				elencoidIspezioni += ",";
			}
		}
		sql.append(" WHERE isp.ID_ISPEZIONE_2018 IN (" + elencoidIspezioni + ") ");

		//sql.append("WHERE 1 = 1 ");
		//sql.append("AND TRUNC(DT_CREAZIONE) >= to_date('1/11/2019-0:0:0','DD/MM/YYYY HH24:MI:SS') ");
		sql.append("AND ID_ISPEZIONE_2018 <> 0 ");
		sql.append("ORDER BY ID_ISPEZIONE_2018 DESC, ");
		sql.append("ID_ISPEZ_ISPET DESC ");
		
		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		List<SigitExtIspezioniDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap,
					ispezioniRowMapper);

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::findIspezioniDettByListIdIspez] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "findIspezioniDettByListIdIspez",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::findIspezioniDettByListIdIspez] END");
		}
		return list;
	}
	
	public BigDecimal getSeqTCodiceImpiantoMax() throws SigitExtDaoException {
		log.debug("[SigitExtDaoImpl::getSeqTCodiceImpiantoMax] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append(" SELECT currval('seq_t_codice_impianto') ");
		
		List<BigDecimal> list = null;
		
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.queryForList(sql.toString(), paramMap, BigDecimal.class);
			
			if (list != null && list.size() == 1) {
				return list.get(0);
			}

		} catch (RuntimeException ex) {
			log.error(
					"[SigitExtDaoImpl::getSeqTCodiceImpiantoMax] esecuzione query",
					ex);
			throw new SigitExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitExtDaoImpl", "getSeqTCodiceImpiantoMax",
					"esecuzione query", sql.toString());
			log.debug("[SigitExtDaoImpl::getSeqTCodiceImpiantoMax] END");
		}
		return null;
		
	}
}

