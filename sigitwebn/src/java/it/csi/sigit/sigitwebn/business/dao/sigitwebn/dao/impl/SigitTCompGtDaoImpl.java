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

/*PROTECTED REGION ID(R119933405) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTCompGt.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - componentiCancellate (datagen::CustomFinder)
 *   - findByExample (datagen::CustomFinder)
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
public class SigitTCompGtDaoImpl extends AbstractDAO implements SigitTCompGtDao {
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
	 * Metodo di inserimento del DAO sigitTCompGt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompGtPk
	 * @generated
	 */

	public SigitTCompGtPk insert(SigitTCompGtDto dto)

	{
		LOG.debug("[SigitTCompGtDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CODICE_IMPIANTO,FK_FLUIDO,FK_DETTAGLIO_GT,RENDIMENTO_PERC,N_MODULI,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,FK_COMBUSTIBILE,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,NOTE,TEMPO_MANUT_ANNI,MEDI_IMP_ORE_OPERATIVE,ID_TIPO_CANNA_FUMARIA ) VALUES (  :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :CODICE_IMPIANTO , :FK_FLUIDO , :FK_DETTAGLIO_GT , :RENDIMENTO_PERC , :N_MODULI , :DATA_DISMISS , :FLG_DISMISSIONE , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :FK_MARCA , :FK_COMBUSTIBILE , :MATRICOLA , :MODELLO , :POTENZA_TERMICA_KW , :NOTE , :TEMPO_MANUT_ANNI , :MEDI_IMP_ORE_OPERATIVE , :ID_TIPO_CANNA_FUMARIA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_FLUIDO]
		params.addValue("FK_FLUIDO", dto.getFkFluido(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_DETTAGLIO_GT]
		params.addValue("FK_DETTAGLIO_GT", dto.getFkDettaglioGt(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [RENDIMENTO_PERC]
		params.addValue("RENDIMENTO_PERC", dto.getRendimentoPerc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [N_MODULI]
		params.addValue("N_MODULI", dto.getNModuli(), java.sql.Types.NUMERIC);

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

		// valorizzazione paametro relativo a colonna [MEDI_IMP_ORE_OPERATIVE]
		params.addValue("MEDI_IMP_ORE_OPERATIVE", dto.getMediImpOreOperative(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_CANNA_FUMARIA]
		params.addValue("ID_TIPO_CANNA_FUMARIA", dto.getIdTipoCannaFumaria(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTCompGtDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_COMP_GT table.
	 * @generated
	 */
	public void update(SigitTCompGtDto dto) throws SigitTCompGtDaoException {
		LOG.debug("[SigitTCompGtDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_FLUIDO = :FK_FLUIDO ,FK_DETTAGLIO_GT = :FK_DETTAGLIO_GT ,RENDIMENTO_PERC = :RENDIMENTO_PERC ,N_MODULI = :N_MODULI ,DATA_DISMISS = :DATA_DISMISS ,FLG_DISMISSIONE = :FLG_DISMISSIONE ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,FK_MARCA = :FK_MARCA ,FK_COMBUSTIBILE = :FK_COMBUSTIBILE ,MATRICOLA = :MATRICOLA ,MODELLO = :MODELLO ,POTENZA_TERMICA_KW = :POTENZA_TERMICA_KW ,NOTE = :NOTE ,TEMPO_MANUT_ANNI = :TEMPO_MANUT_ANNI ,MEDI_IMP_ORE_OPERATIVE = :MEDI_IMP_ORE_OPERATIVE ,ID_TIPO_CANNA_FUMARIA = :ID_TIPO_CANNA_FUMARIA  WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND DATA_INSTALL = :DATA_INSTALL  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (dto.getIdTipoComponente() == null || dto.getProgressivo() == null || dto.getDataInstall() == null
				|| dto.getCodiceImpianto() == null) {
			LOG.error("[SigitTCompGtDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTCompGtDaoException("Chiave primaria non impostata");
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

		// valorizzazione paametro relativo a colonna [FK_FLUIDO]
		params.addValue("FK_FLUIDO", dto.getFkFluido(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_DETTAGLIO_GT]
		params.addValue("FK_DETTAGLIO_GT", dto.getFkDettaglioGt(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [RENDIMENTO_PERC]
		params.addValue("RENDIMENTO_PERC", dto.getRendimentoPerc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [N_MODULI]
		params.addValue("N_MODULI", dto.getNModuli(), java.sql.Types.NUMERIC);

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

		// valorizzazione paametro relativo a colonna [MEDI_IMP_ORE_OPERATIVE]
		params.addValue("MEDI_IMP_ORE_OPERATIVE", dto.getMediImpOreOperative(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_CANNA_FUMARIA]
		params.addValue("ID_TIPO_CANNA_FUMARIA", dto.getIdTipoCannaFumaria(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompGtDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_COMP_GT table.
	 * @generated
	 */

	public void delete(SigitTCompGtPk pk) throws SigitTCompGtDaoException {
		LOG.debug("[SigitTCompGtDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND DATA_INSTALL = :DATA_INSTALL  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (pk == null) {
			LOG.error("[SigitTCompGtDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTCompGtDaoException("Chiave primaria non impostata");
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
		LOG.debug("[SigitTCompGtDaoImpl::delete] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_GT table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTCompGtDaoException {
		LOG.debug("[SigitTCompGtDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R-1792771974) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompGtDaoImpl::customDeleterByCodImpianto] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_GT table.
	 * @generated
	 */
	public void customDeleterByFilter(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompGtDaoException {
		LOG.debug("[SigitTCompGtDaoImpl::customDeleterByFilter] START");
		/*PROTECTED REGION ID(R-468988643) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND CODICE_IMPIANTO = :CODICE_IMPIANTO ";
		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("ID_TIPO_COMPONENTE", filter.getTipoComponente(), java.sql.Types.VARCHAR);

		params.addValue("PROGRESSIVO", filter.getProgressivo(), java.sql.Types.NUMERIC);

		params.addValue("CODICE_IMPIANTO", filter.getCodImpianto(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompGtDaoImpl::customDeleterByFilter] END");
	}

	protected SigitTCompGtDaoRowMapper findByPrimaryKeyRowMapper = new SigitTCompGtDaoRowMapper(null,
			SigitTCompGtDto.class, this);

	protected SigitTCompGtDaoRowMapper componentiCancellateRowMapper = new SigitTCompGtDaoRowMapper(null,
			SigitTCompGtDto.class, this);

	protected SigitTCompGtDaoRowMapper findByExampleRowMapper = new SigitTCompGtDaoRowMapper(null,
			SigitTCompGtDto.class, this);

	protected SigitTCompGtDaoRowMapper byExampleRowMapper = new SigitTCompGtDaoRowMapper(null, SigitTCompGtDto.class,
			this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_COMP_GT";
	}

	/** 
	 * Returns all rows from the SIGIT_T_COMP_GT table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTCompGtDto findByPrimaryKey(SigitTCompGtPk pk) throws SigitTCompGtDaoException {
		LOG.debug("[SigitTCompGtDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CODICE_IMPIANTO,FK_FLUIDO,FK_DETTAGLIO_GT,RENDIMENTO_PERC,N_MODULI,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,FK_COMBUSTIBILE,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,NOTE,TEMPO_MANUT_ANNI,MEDI_IMP_ORE_OPERATIVE,ID_TIPO_CANNA_FUMARIA FROM "
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

		List<SigitTCompGtDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompGtDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTCompGtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompGtDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompGtDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder componentiCancellate
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompGtDto> findComponentiCancellate(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitTCompGtDaoException {
		LOG.debug("[SigitTCompGtDaoImpl::findComponentiCancellate] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CODICE_IMPIANTO,FK_FLUIDO,FK_DETTAGLIO_GT,RENDIMENTO_PERC,N_MODULI,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,FK_COMBUSTIBILE,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,NOTE,TEMPO_MANUT_ANNI,MEDI_IMP_ORE_OPERATIVE,ID_TIPO_CANNA_FUMARIA ");
		sql.append(" FROM SIGIT_T_COMP_GT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-473672172) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("CODICE_IMPIANTO = :codImpianto");

		sql.append(" AND ID_TIPO_COMPONENTE = :tipoComponente");

		if (GenericUtil.isNotNullOrEmpty(input.getProgressivo()))
			sql.append(" AND PROGRESSIVO = :progressivo");

		if (input.getListDateInstallazione() != null && !input.getListDateInstallazione().isEmpty()) {
			sql.append(" AND TO_CHAR(DATA_INSTALL,'DD/MM/YYYY') NOT IN  (");
			boolean aggVirg = false;
			for (String data : input.getListDateInstallazione()) {
				if (aggVirg)
					sql.append(", ");
				sql.append(" '" + data + "'");
				aggVirg = true;
			}
			sql.append(") ");
		}

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

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-918371666) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input.getCodImpianto(), java.sql.Types.NUMERIC);
		paramMap.addValue("tipoComponente", input.getTipoComponente(), java.sql.Types.VARCHAR);
		paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitTCompGtDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, componentiCancellateRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompGtDaoImpl::findComponentiCancellate] esecuzione query", ex);
			throw new SigitTCompGtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompGtDaoImpl", "findComponentiCancellate", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTCompGtDaoImpl::findComponentiCancellate] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder findByExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompGtDto> findFindByExample(SigitTCompGtPk input) throws SigitTCompGtDaoException {
		LOG.debug("[SigitTCompGtDaoImpl::findFindByExample] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CODICE_IMPIANTO,FK_FLUIDO,FK_DETTAGLIO_GT,RENDIMENTO_PERC,N_MODULI,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,FK_COMBUSTIBILE,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,NOTE,TEMPO_MANUT_ANNI,MEDI_IMP_ORE_OPERATIVE,ID_TIPO_CANNA_FUMARIA ");
		sql.append(" FROM SIGIT_T_COMP_GT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-841416850) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		sql.append("1 = 1");

		if (input.getCodiceImpianto() != null) {
			sql.append(" AND CODICE_IMPIANTO = :codiceImpianto");
		}

		if (input.getDataInstall() != null) {
			sql.append(" AND DATA_INSTALL = :dataInstall");
		}

		if (input.getIdTipoComponente() != null) {
			sql.append(" AND ID_TIPO_COMPONENTE = :idTipoComponente");
		}

		if (input.getProgressivo() != null) {
			sql.append(" AND PROGRESSIVO = :progressivo");
		}

		sql.append(" ORDER BY CODICE_IMPIANTO, ID_TIPO_COMPONENTE, PROGRESSIVO ASC, DATA_INSTALL DESC");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R566445204) ENABLED START*/
		//***aggiungere tutte le condizioni
		if (input.getCodiceImpianto() != null) {
			paramMap.addValue("codiceImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);
		}

		if (input.getDataInstall() != null) {
			paramMap.addValue("dataInstall", input.getDataInstall(), java.sql.Types.DATE);
		}

		if (input.getIdTipoComponente() != null) {
			paramMap.addValue("idTipoComponente", input.getIdTipoComponente());
		}

		if (input.getProgressivo() != null) {
			paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);
		}

		/*PROTECTED REGION END*/
		List<SigitTCompGtDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByExampleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompGtDaoImpl::findFindByExample] esecuzione query", ex);
			throw new SigitTCompGtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompGtDaoImpl", "findFindByExample", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompGtDaoImpl::findFindByExample] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompGtDto> findByExample(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitTCompGtDaoException {
		LOG.debug("[SigitTCompGtDaoImpl::findByExample] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CODICE_IMPIANTO,FK_FLUIDO,FK_DETTAGLIO_GT,RENDIMENTO_PERC,N_MODULI,DATA_DISMISS,FLG_DISMISSIONE,DATA_ULT_MOD,UTENTE_ULT_MOD,FK_MARCA,FK_COMBUSTIBILE,MATRICOLA,MODELLO,POTENZA_TERMICA_KW,NOTE,TEMPO_MANUT_ANNI,MEDI_IMP_ORE_OPERATIVE,ID_TIPO_CANNA_FUMARIA ");
		sql.append(" FROM SIGIT_T_COMP_GT");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1695977369) ENABLED START*/
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

		if (input.getListCombustibile() != null && !input.getListCombustibile().isEmpty()) {
			sql.append(" AND FK_COMBUSTIBILE IN  (");
			boolean aggVirg = false;
			for (String progr : input.getListCombustibile()) {
				if (aggVirg) {
					sql.append(", ");
				}
				sql.append(progr);
				aggVirg = true;
			}
			sql.append(") ");
		}

		sql.append(" AND ID_TIPO_COMPONENTE = '" + it.csi.sigit.sigitwebn.util.Constants.TIPO_COMPONENTE_GT + "'");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-155127109) ENABLED START*/
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
		List<SigitTCompGtDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byExampleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTCompGtDaoImpl::findByExample] esecuzione query", ex);
			throw new SigitTCompGtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTCompGtDaoImpl", "findByExample", "esecuzione query", sql.toString());
			LOG.debug("[SigitTCompGtDaoImpl::findByExample] END");
		}
		return list;
	}

}
