package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTDocContrattoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTDocContrattoDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocContrattoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocContrattoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDocContrattoDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.util.performance.StopWatch;

public class SigitTDocContrattoDaoImpl extends AbstractDAO implements SigitTDocContrattoDao {
	
	protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE);

	protected NamedParameterJdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	protected SigitTDocContrattoDaoRowMapper findSigitTDocContrattoByFkContrattoRowMapper = new SigitTDocContrattoDaoRowMapper(null, SigitTDocContrattoDto.class, this);

	@Override
	public SigitTDocContrattoPk insert(SigitTDocContrattoDto dto) {

		logger.debug("[SigitTDocContrattoDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " (ID_DOC_CONTRATTO,FK_CONTRATTO,NOME_DOC_ORIGINALE,NOME_DOC,DESCRIZIONE,DATA_UPLOAD,DATA_DELETE,UID_INDEX,DATA_ULT_MOD,UTENTE_ULT_MOD ) "
				+ "VALUES (  :ID_DOC_CONTRATTO , :FK_CONTRATTO , :NOME_DOC_ORIGINALE , :NOME_DOC , :DESCRIZIONE , :DATA_UPLOAD , :DATA_DELETE , :UID_INDEX , :DATA_ULT_MOD , :UTENTE_ULT_MOD )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("ID_DOC_CONTRATTO", newKey, java.sql.Types.NUMERIC);

		params.addValue("FK_CONTRATTO", dto.getFkContratto(), java.sql.Types.NUMERIC);

		params.addValue("NOME_DOC_ORIGINALE", dto.getNomeDocOriginale(), java.sql.Types.VARCHAR);

		params.addValue("NOME_DOC", dto.getNomeDoc(), java.sql.Types.VARCHAR);

		params.addValue("DESCRIZIONE", dto.getDescrizione(), java.sql.Types.VARCHAR);

		params.addValue("DATA_UPLOAD", dto.getDataUpload(), java.sql.Types.TIMESTAMP);

		params.addValue("DATA_DELETE", dto.getDataDelete(), java.sql.Types.TIMESTAMP);

		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);


		insert(jdbcTemplate, sql, params);

		dto.setIdDocContratto(newKey);
		logger.debug("[SigitTDocContrattoDaoImpl::insert] END");
		return dto.createPk();
	}

	@Override
	public String getTableName() {
		return "SIGIT_T_DOC_CONTRATTO";
	}

	@Override
	public List<SigitTDocContrattoDto> findSigitTDocContrattoByFkContratto(BigDecimal fkContratto) throws SigitTDocContrattoDaoException {
		logger.debug("[SigitTDocContrattoDaoImpl::insert] START");

		final String sql = "SELECT ID_DOC_CONTRATTO,FK_CONTRATTO,NOME_DOC_ORIGINALE,NOME_DOC,DESCRIZIONE,DATA_UPLOAD,DATA_DELETE,UID_INDEX,DATA_ULT_MOD,UTENTE_ULT_MOD FROM " + getTableName()
				+ " WHERE FK_CONTRATTO = :FK_CONTRATTO ORDER BY DATA_ULT_MOD DESC";

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("FK_CONTRATTO", fkContratto, java.sql.Types.NUMERIC);

		List<SigitTDocContrattoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql, params, findSigitTDocContrattoByFkContrattoRowMapper);

		} catch (RuntimeException ex) {
			logger.error("[SigitTDocContrattoDaoImpl::findSigitTDocContrattoByFkContratto] esecuzione query", ex);
			throw new SigitTDocContrattoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDocContrattoDaoImpl", "findSigitTDocContrattoByFkContratto", "esecuzione query", sql.toString());
			logger.debug("[SigitTDocContrattoDaoImpl::findSigitTDocContrattoByFkContratto] END");
		}
		return list;
	}
	
	@Override
	public SigitTDocContrattoDto findByUidIndex(String uidIndex) throws SigitTDocContrattoDaoException {
		logger.debug("[SigitTDocContrattoDaoImpl::findByUidIndex] START");

		final String sql = "SELECT ID_DOC_CONTRATTO,FK_CONTRATTO,NOME_DOC_ORIGINALE,NOME_DOC,DESCRIZIONE,DATA_UPLOAD,DATA_DELETE,UID_INDEX,DATA_ULT_MOD,UTENTE_ULT_MOD FROM " + getTableName()
				+ " WHERE UID_INDEX = :UID_INDEX";

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("UID_INDEX", uidIndex);

		List<SigitTDocContrattoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql, params, findSigitTDocContrattoByFkContrattoRowMapper);

		} catch (RuntimeException ex) {
			logger.error("[SigitTDocContrattoDaoImpl::findByUidIndex] esecuzione query", ex);
			throw new SigitTDocContrattoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDocContrattoDaoImpl", "findByUidIndex", "esecuzione query", sql.toString());
			logger.debug("[SigitTDocContrattoDaoImpl::findByUidIndex] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public void updateColumnsAggiornaEliminaDoc(SigitTDocContrattoDto dto) throws SigitTDocContrattoDaoException {
		logger.debug("[SigitTDocContrattoDaoImpl::updateColumnsAggiornaEliminaDoc] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DATA_ULT_MOD = :DATA_ULT_MOD ,DATA_DELETE = :DATA_DELETE  WHERE ID_DOC_CONTRATTO = :ID_DOC_CONTRATTO ";

		if (dto.getIdDocContratto() == null) {
			logger.error(
					"[SigitTDocContrattoDaoImpl::updateColumnsAggiornaEliminaDoc] ERROR chiave primaria non impostata");
			throw new SigitTDocContrattoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_DELETE]
		params.addValue("DATA_DELETE", dto.getDataDelete(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [ID_DOC_ALLEGATO]
		params.addValue("ID_DOC_CONTRATTO", dto.getIdDocContratto(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql, params);
		logger.debug("[SigitTDocContrattoDaoImpl::updateColumnsAggiornaEliminaDoc] END");
	}
	
	@Override
	public void updateUidIndex(Integer idDocContratto, String uidIndex, String nomeDoc) {

		logger.debug("[SigitTDocContrattoDaoImpl::updateUidIndex] START");

		final String sql = "UPDATE " + getTableName()
				+ " SET UID_INDEX = :UID_INDEX, NOME_DOC = :NOME_DOC "
				+ "WHERE ID_DOC_CONTRATTO = :ID_DOC_CONTRATTO";

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("ID_DOC_CONTRATTO", idDocContratto, java.sql.Types.NUMERIC);

		params.addValue("UID_INDEX", uidIndex, java.sql.Types.VARCHAR);
		
		params.addValue("NOME_DOC", nomeDoc, java.sql.Types.VARCHAR);


		update(jdbcTemplate, sql, params);

		logger.debug("[SigitTDocContrattoDaoImpl::updateUidIndex] END");
	}

}
