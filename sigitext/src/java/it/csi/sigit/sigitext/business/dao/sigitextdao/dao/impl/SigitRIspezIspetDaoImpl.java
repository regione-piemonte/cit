package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitRIspezIspetDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitRIspezIspetDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRIspezIspetDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRIspezIspetDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;

public class SigitRIspezIspetDaoImpl extends AbstractDAO implements SigitRIspezIspetDao {
	
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
	
	protected  SigitRIspezIspetDaoRowMapper sigitRIspezIspetDaoRowMapper = new  SigitRIspezIspetDaoRowMapper(null,
			SigitRIspezIspetDto.class, this);
	
	@Override
	public List<SigitRIspezIspetDto> findByFkPersonaFisica(BigDecimal fkPersonaFisica) throws SigitRIspezIspetDaoException {
		
		LOG.debug("[SigitRIspezIspetDaoImpl::findByFkPersonaFisica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_ISPEZ_ISPET, FK_RUOLO, DATA_INIZIO, DATA_FINE, FK_PERSONA_FISICA, FK_PERSONA_GIURIDICA, DATA_ULT_MOD, UTENTE_ULT_MOD, FLG_PRIMO_CARICATORE, ID_ISPEZIONE_2018" + 
				   " FROM SIGIT_R_ISPEZ_ISPET WHERE FK_PERSONA_FISICA = :fkPersonaFisica");
				
		paramMap.addValue("fkPersonaFisica", fkPersonaFisica);
		List<SigitRIspezIspetDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, sigitRIspezIspetDaoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRIspezIspetDaoImpl::findByFkPersonaFisica] ERROR esecuzione query", ex);
			throw new SigitRIspezIspetDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRIspezIspetDaoImpl", "findByFkPersonaFisica", "esecuzione query", sql.toString());
			LOG.debug("[SigitRIspezIspetDaoImpl::findByFkPersonaFisica] END");
		}
		return list;
		
	}
	
	@Override
	public List<SigitRIspezIspetDto> findByIdIspezione2018(BigDecimal idIspezione2018) throws SigitRIspezIspetDaoException {
		
		LOG.debug("[SigitRIspezIspetDaoImpl::findByFkPersonaFisica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_ISPEZ_ISPET, FK_RUOLO, DATA_INIZIO, DATA_FINE, FK_PERSONA_FISICA, FK_PERSONA_GIURIDICA, DATA_ULT_MOD, UTENTE_ULT_MOD, FLG_PRIMO_CARICATORE, ID_ISPEZIONE_2018" + 
				   " FROM SIGIT_R_ISPEZ_ISPET WHERE ID_ISPEZIONE_2018 = :idIspezione2018");
				
		paramMap.addValue("idIspezione2018", idIspezione2018);
		List<SigitRIspezIspetDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, sigitRIspezIspetDaoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRIspezIspetDaoImpl::findByFkPersonaFisica] ERROR esecuzione query", ex);
			throw new SigitRIspezIspetDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRIspezIspetDaoImpl", "findByFkPersonaFisica", "esecuzione query", sql.toString());
			LOG.debug("[SigitRIspezIspetDaoImpl::findByFkPersonaFisica] END");
		}
		return list;
		
	}	

	@Override
	public String getTableName() {	
		return "sigit_r_ispez_ispet";
	}

	@Override
	public void update(SigitRIspezIspetDto sigitRIspezIspetDto) throws SigitRIspezIspetDaoException {

		LOG.debug("[SigitRIspezIspetDaoImpl::update] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("UPDATE SIGIT_R_ISPEZ_ISPET " + 
				   " SET DATA_FINE = :dataFine WHERE ID_ISPEZIONE_2018 = :idIspezione2018");
				
		paramMap.addValue("dataFine", sigitRIspezIspetDto.getDataFine());
		paramMap.addValue("idIspezione2018", sigitRIspezIspetDto.getIdIspezione2018());
		
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			update(jdbcTemplate, sql.toString(), paramMap);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRIspezIspetDaoImpl::update] ERROR esecuzione query", ex);
			throw new SigitRIspezIspetDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRIspezIspetDaoImpl", "update", "esecuzione query", sql.toString());
			LOG.debug("[SigitRIspezIspetDaoImpl::update] END");
		}
				
	}

	@Override
	public Integer insert(SigitRIspezIspetDto sigitRIspezIspetDto) throws SigitRIspezIspetDaoException {

		LOG.debug("[SigitRIspezIspetDaoImpl::insert] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		sql.append("INSERT INTO SIGIT_R_ISPEZ_ISPET " + 
				" (ID_ISPEZ_ISPET, FK_RUOLO, DATA_INIZIO, FK_PERSONA_FISICA, DATA_ULT_MOD, UTENTE_ULT_MOD, ID_ISPEZIONE_2018) " + 
				" VALUES(:idIspezIspet, :fkRuolo, :dataInizio, :fkPersonaFisica, :dataUltMod, :utenteUltMod, :idIspezione2018) ");
		
				
		paramMap.addValue("idIspezIspet",newKey);
		paramMap.addValue("fkRuolo",sigitRIspezIspetDto.getFkRuolo());
		paramMap.addValue("dataInizio",sigitRIspezIspetDto.getDataInizio());
		paramMap.addValue("fkPersonaFisica",sigitRIspezIspetDto.getFkPersonaFisica());			
		paramMap.addValue("dataUltMod",sigitRIspezIspetDto.getDataUltMod());
		paramMap.addValue("utenteUltMod",sigitRIspezIspetDto.getUtenteUltMod());						
		paramMap.addValue("idIspezione2018", sigitRIspezIspetDto.getIdIspezione2018());
		
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			insert(jdbcTemplate, sql.toString(), paramMap);
			
			return newKey;
		} catch (RuntimeException ex) {
			LOG.error("[SigitRIspezIspetDaoImpl::insert] ERROR esecuzione query", ex);
			throw new SigitRIspezIspetDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRIspezIspetDaoImpl", "update", "esecuzione query", sql.toString());
			LOG.debug("[SigitRIspezIspetDaoImpl::insert] END");
		}
		
	}
	
	@Override
	public SigitRIspezIspetDto findByPrimaryKey(BigDecimal idIspezIspet ) throws SigitRIspezIspetDaoException {
		
		LOG.debug("[SigitRIspezIspetDaoImpl::findByPrimaryKey] START");
		
		SigitRIspezIspetDto sigitRIspezIspetDto = new SigitRIspezIspetDto();
		
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_ISPEZ_ISPET, FK_RUOLO, DATA_INIZIO, DATA_FINE, FK_PERSONA_FISICA, FK_PERSONA_GIURIDICA, DATA_ULT_MOD, UTENTE_ULT_MOD, FLG_PRIMO_CARICATORE, ID_ISPEZIONE_2018" + 
				   " FROM SIGIT_R_ISPEZ_ISPET WHERE ID_ISPEZ_ISPET = :ID_ISPEZ_ISPET");
				
		paramMap.addValue("ID_ISPEZ_ISPET", idIspezIspet);
		List<SigitRIspezIspetDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, sigitRIspezIspetDaoRowMapper);
			if(list!=null) {
				sigitRIspezIspetDto = list.get(0);
			}
		} catch (RuntimeException ex) {
			LOG.error("[SigitRIspezIspetDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitRIspezIspetDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRIspezIspetDaoImpl", "findByFkPersonaFisica", "esecuzione query", sql.toString());
			LOG.debug("[SigitRIspezIspetDaoImpl::findByPrimaryKey] END");
		}
		return sigitRIspezIspetDto;
		
	}

}
