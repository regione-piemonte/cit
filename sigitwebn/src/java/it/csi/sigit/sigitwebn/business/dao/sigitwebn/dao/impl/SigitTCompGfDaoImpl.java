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

/*PROTECTED REGION ID(R-496298431) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTCompGf.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byExample (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *   - byCodImpianto (datagen::CustomDeleter)
 *   - byFilter (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTCompGfDaoImpl extends AbstractDAO implements SigitTCompGfDao {
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
	 * Metodo di inserimento del DAO sigitTCompGf. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompGfPk
	 * @generated
	 */

	public SigitTCompGfPk insert(SigitTCompGfDto dto)

	{
		LOG.debug("[SigitTCompGfDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CODICE_IMPIANTO,FK_DETTAGLIO_GF,FLG_SORGENTE_EXT,FLG_FLUIDO_UTENZE,FLUIDO_FRIGORIGENO,N_CIRCUITI,RAFFRESCAMENTO_EER,RAFF_POTENZA_KW,RAFF_POTENZA_ASS,RISCALDAMENTO_COP,RISC_POTENZA_KW,RISC_POTENZA_ASS_KW,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,FK_COMBUSTIBILE,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,NOTE,TEMPO_MANUT_ANNI,ID_FONTE_EN_SFRUTTATA ) VALUES (  :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :CODICE_IMPIANTO , :FK_DETTAGLIO_GF , :FLG_SORGENTE_EXT , :FLG_FLUIDO_UTENZE , :FLUIDO_FRIGORIGENO , :N_CIRCUITI , :RAFFRESCAMENTO_EER , :RAFF_POTENZA_KW , :RAFF_POTENZA_ASS , :RISCALDAMENTO_COP , :RISC_POTENZA_KW , :RISC_POTENZA_ASS_KW , :DATA_DISMISS , :FLG_DISMISSIONE , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :FK_MARCA , :FK_COMBUSTIBILE , :MATRICOLA , :MODELLO , :POTENZA_TERMICA_KW , :NOTE , :TEMPO_MANUT_ANNI , :ID_FONTE_EN_SFRUTTATA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_DETTAGLIO_GF]
		params.addValue("FK_DETTAGLIO_GF", dto.getFkDettaglioGf(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SORGENTE_EXT]
		params.addValue("FLG_SORGENTE_EXT", dto.getFlgSorgenteExt(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_FLUIDO_UTENZE]
		params.addValue("FLG_FLUIDO_UTENZE", dto.getFlgFluidoUtenze(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLUIDO_FRIGORIGENO]
		params.addValue("FLUIDO_FRIGORIGENO", dto.getFluidoFrigorigeno(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [N_CIRCUITI]
		params.addValue("N_CIRCUITI", dto.getNCircuiti(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [RAFFRESCAMENTO_EER]
		params.addValue("RAFFRESCAMENTO_EER", dto.getRaffrescamentoEer(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [RAFF_POTENZA_KW]
		params.addValue("RAFF_POTENZA_KW", dto.getRaffPotenzaKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [RAFF_POTENZA_ASS]
		params.addValue("RAFF_POTENZA_ASS", dto.getRaffPotenzaAss(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [RISCALDAMENTO_COP]
		params.addValue("RISCALDAMENTO_COP", dto.getRiscaldamentoCop(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [RISC_POTENZA_KW]
		params.addValue("RISC_POTENZA_KW", dto.getRiscPotenzaKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [RISC_POTENZA_ASS_KW]
		params.addValue("RISC_POTENZA_ASS_KW", dto.getRiscPotenzaAssKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_DISMISS]
		params.addValue("DATA_DISMISS", dto.getDataDismiss(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FLG_DISMISSIONE]
		params.addValue("FLG_DISMISSIONE", dto.getFlgDismissione(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_MARCA]
		params.addValue("FK_MARCA", dto.getFkMarca(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_COMBUSTIBILE]
		params.addValue("FK_COMBUSTIBILE", dto.getFkCombustibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MATRICOLA]
		params.addValue("MATRICOLA", dto.getMatricola(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MODELLO]
		params.addValue("MODELLO", dto.getModello(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [POTENZA_TERMICA_KW]
		params.addValue("POTENZA_TERMICA_KW", dto.getPotenzaTermicaKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TEMPO_MANUT_ANNI]
		params.addValue("TEMPO_MANUT_ANNI", dto.getTempoManutAnni(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_FONTE_EN_SFRUTTATA]
		params.addValue("ID_FONTE_EN_SFRUTTATA", dto.getIdFonteEnSfruttata(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTCompGfDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_COMP_GF table.
	 * @generated
	 */
	public void update(SigitTCompGfDto dto) throws SigitTCompGfDaoException {
		LOG.debug("[SigitTCompGfDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_DETTAGLIO_GF = :FK_DETTAGLIO_GF ,FLG_SORGENTE_EXT = :FLG_SORGENTE_EXT ,FLG_FLUIDO_UTENZE = :FLG_FLUIDO_UTENZE ,FLUIDO_FRIGORIGENO = :FLUIDO_FRIGORIGENO ,N_CIRCUITI = :N_CIRCUITI ,RAFFRESCAMENTO_EER = :RAFFRESCAMENTO_EER ,RAFF_POTENZA_KW = :RAFF_POTENZA_KW ,RAFF_POTENZA_ASS = :RAFF_POTENZA_ASS ,RISCALDAMENTO_COP = :RISCALDAMENTO_COP ,RISC_POTENZA_KW = :RISC_POTENZA_KW ,RISC_POTENZA_ASS_KW = :RISC_POTENZA_ASS_KW ,DATA_DISMISS = :DATA_DISMISS ,FLG_DISMISSIONE = :FLG_DISMISSIONE ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,FK_MARCA = :FK_MARCA ,FK_COMBUSTIBILE = :FK_COMBUSTIBILE ,MATRICOLA = :MATRICOLA ,MODELLO = :MODELLO ,POTENZA_TERMICA_KW = :POTENZA_TERMICA_KW ,NOTE = :NOTE ,TEMPO_MANUT_ANNI = :TEMPO_MANUT_ANNI ,ID_FONTE_EN_SFRUTTATA = :ID_FONTE_EN_SFRUTTATA  WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND DATA_INSTALL = :DATA_INSTALL  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (dto.getIdTipoComponente() == null || dto.getProgressivo() == null || dto.getDataInstall() == null
				|| dto.getCodiceImpianto() == null) {
			LOG.error("[SigitTCompGfDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTCompGfDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_DETTAGLIO_GF]
		params.addValue("FK_DETTAGLIO_GF", dto.getFkDettaglioGf(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SORGENTE_EXT]
		params.addValue("FLG_SORGENTE_EXT", dto.getFlgSorgenteExt(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_FLUIDO_UTENZE]
		params.addValue("FLG_FLUIDO_UTENZE", dto.getFlgFluidoUtenze(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLUIDO_FRIGORIGENO]
		params.addValue("FLUIDO_FRIGORIGENO", dto.getFluidoFrigorigeno(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [N_CIRCUITI]
		params.addValue("N_CIRCUITI", dto.getNCircuiti(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [RAFFRESCAMENTO_EER]
		params.addValue("RAFFRESCAMENTO_EER", dto.getRaffrescamentoEer(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [RAFF_POTENZA_KW]
		params.addValue("RAFF_POTENZA_KW", dto.getRaffPotenzaKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [RAFF_POTENZA_ASS]
		params.addValue("RAFF_POTENZA_ASS", dto.getRaffPotenzaAss(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [RISCALDAMENTO_COP]
		params.addValue("RISCALDAMENTO_COP", dto.getRiscaldamentoCop(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [RISC_POTENZA_KW]
		params.addValue("RISC_POTENZA_KW", dto.getRiscPotenzaKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [RISC_POTENZA_ASS_KW]
		params.addValue("RISC_POTENZA_ASS_KW", dto.getRiscPotenzaAssKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_DISMISS]
		params.addValue("DATA_DISMISS", dto.getDataDismiss(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FLG_DISMISSIONE]
		params.addValue("FLG_DISMISSIONE", dto.getFlgDismissione(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_MARCA]
		params.addValue("FK_MARCA", dto.getFkMarca(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_COMBUSTIBILE]
		params.addValue("FK_COMBUSTIBILE", dto.getFkCombustibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MATRICOLA]
		params.addValue("MATRICOLA", dto.getMatricola(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MODELLO]
		params.addValue("MODELLO", dto.getModello(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [POTENZA_TERMICA_KW]
		params.addValue("POTENZA_TERMICA_KW", dto.getPotenzaTermicaKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TEMPO_MANUT_ANNI]
		params.addValue("TEMPO_MANUT_ANNI", dto.getTempoManutAnni(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_FONTE_EN_SFRUTTATA]
		params.addValue("ID_FONTE_EN_SFRUTTATA", dto.getIdFonteEnSfruttata(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompGfDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_COMP_GF table.
	 * @generated
	 */

	public void delete(SigitTCompGfPk pk) throws SigitTCompGfDaoException {
		LOG.debug("[SigitTCompGfDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND DATA_INSTALL = :DATA_INSTALL  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (pk == null) {
			LOG.error("[SigitTCompGfDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTCompGfDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", pk.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", pk.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", pk.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompGfDaoImpl::delete] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_GF table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTCompGfDaoException {
		LOG.debug("[SigitTCompGfDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R194013676) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompGfDaoImpl::customDeleterByCodImpianto] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_GF table.
	 * @generated
	 */
	public void customDeleterByFilter(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompGfDaoException {
		LOG.debug("[SigitTCompGfDaoImpl::customDeleterByFilter] START");
		/*PROTECTED REGION ID(R-1853408149) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";
		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("ID_TIPO_COMPONENTE", filter.getTipoComponente(), java.sql.Types.VARCHAR);

		params.addValue("PROGRESSIVO", filter.getProgressivo(), java.sql.Types.NUMERIC);

		params.addValue("CODICE_IMPIANTO", filter.getCodImpianto(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompGfDaoImpl::customDeleterByFilter] END");
	}

	protected SigitTCompGfDaoRowMapper findByPrimaryKeyRowMapper = new SigitTCompGfDaoRowMapper(null,
			SigitTCompGfDto.class, this);

	protected SigitTCompGfDaoRowMapper byExampleRowMapper = new SigitTCompGfDaoRowMapper(null, SigitTCompGfDto.class,
			this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_COMP_GF";
	}

	/** 
	 * Returns all rows from the SIGIT_T_COMP_GF table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTCompGfDto findByPrimaryKey(SigitTCompGfPk pk) throws SigitTCompGfDaoException {
		LOG.debug("[SigitTCompGfDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CODICE_IMPIANTO,FK_DETTAGLIO_GF,FLG_SORGENTE_EXT,FLG_FLUIDO_UTENZE,FLUIDO_FRIGORIGENO,N_CIRCUITI,RAFFRESCAMENTO_EER,RAFF_POTENZA_KW,RAFF_POTENZA_ASS,RISCALDAMENTO_COP,RISC_POTENZA_KW,RISC_POTENZA_ASS_KW,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,FK_COMBUSTIBILE,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,NOTE,TEMPO_MANUT_ANNI,ID_FONTE_EN_SFRUTTATA FROM "
						+ getTableName()
						+ " WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND DATA_INSTALL = :DATA_INSTALL  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", pk.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", pk.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", pk.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		List<SigitTCompGfDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompGfDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTCompGfDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompGfDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompGfDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompGfDto> findByExample(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitTCompGfDaoException {
		LOG.debug("[SigitTCompGfDaoImpl::findByExample] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CODICE_IMPIANTO,FK_DETTAGLIO_GF,FLG_SORGENTE_EXT,FLG_FLUIDO_UTENZE,FLUIDO_FRIGORIGENO,N_CIRCUITI,RAFFRESCAMENTO_EER,RAFF_POTENZA_KW,RAFF_POTENZA_ASS,RISCALDAMENTO_COP,RISC_POTENZA_KW,RISC_POTENZA_ASS_KW,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,FK_COMBUSTIBILE,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,NOTE,TEMPO_MANUT_ANNI,ID_FONTE_EN_SFRUTTATA ");
		sql.append(" FROM SIGIT_T_COMP_GF");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1854403147) ENABLED START*/
		sql.append(" 1 = 1 ");

		if (input.getCodImpianto() != null) {
			sql.append(" AND CODICE_IMPIANTO = :codiceImpianto");
		}

		if (input.getProgressivo() != null) {
			sql.append(" AND PROGRESSIVO = :progressivo");
		}

		if (input.getDataInstallazione() != null) {
			sql.append(" AND DATA_INSTALL = :dataInstall");
		}

		sql.append(" AND ID_TIPO_COMPONENTE = '" + it.csi.sigit.sigitwebn.util.Constants.TIPO_COMPONENTE_GF + "'");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-771358931) ENABLED START*/
		if (input.getCodImpianto() != null) {
			paramMap.addValue("codiceImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		}

		if (input.getDataInstallazione() != null) {
			paramMap.addValue("dataInstall", input.getDataInstallazione(), java.sql.Types.DATE);
		}

		if (input.getProgressivo() != null) {
			paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);
		}

		sql.append(" ORDER BY PROGRESSIVO ASC, DATA_INSTALL DESC");

		/*PROTECTED REGION END*/
		List<SigitTCompGfDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byExampleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompGfDaoImpl::findByExample] esecuzione query", ex);
			throw new SigitTCompGfDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompGfDaoImpl", "findByExample", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompGfDaoImpl::findByExample] END");
		}
		return list;
	}

}
