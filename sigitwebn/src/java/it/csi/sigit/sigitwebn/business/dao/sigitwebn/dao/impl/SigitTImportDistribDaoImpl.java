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

/*PROTECTED REGION ID(R1678704975) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTImportDistrib.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byIdPersonaGiuridica (datagen::CustomFinder)
 *   - ricevutaByIdImportDistrib (datagen::CustomFinder)
  * - UPDATERS:
 *   - annullaImport (datagen::UpdateColumns)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTImportDistribDaoImpl extends AbstractDAO implements SigitTImportDistribDao {
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
	 * Metodo di inserimento del DAO sigitTImportDistrib. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTImportDistribPk
	 * @generated
	 */

	public SigitTImportDistribPk insert(SigitTImportDistribDto dto)

	{
		LOG.debug("[SigitTImportDistribDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_IMPORT_DISTRIB,FK_PERSONA_GIURIDICA,FK_STATO_DISTRIB,DATA_INIZIO_ELAB,DATA_FINE_ELAB,DATA_ANNULLAMENTO,NOME_FILE_IMPORT,UID_INDEX,ANNO_RIFERIMENTO,DATA_INVIO_MAIL_DISTRIB,DATA_INVIO_MAIL_ASSISTENZA,TOT_RECORD_ELABORATI,TOT_RECORD_SCARTATI,DATA_ULT_MOD,UTENTE_ULT_MOD,UTENTE_CARICAMENTO ) VALUES (  :ID_IMPORT_DISTRIB , :FK_PERSONA_GIURIDICA , :FK_STATO_DISTRIB , :DATA_INIZIO_ELAB , :DATA_FINE_ELAB , :DATA_ANNULLAMENTO , :NOME_FILE_IMPORT , :UID_INDEX , :ANNO_RIFERIMENTO , :DATA_INVIO_MAIL_DISTRIB , :DATA_INVIO_MAIL_ASSISTENZA , :TOT_RECORD_ELABORATI , :TOT_RECORD_SCARTATI , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :UTENTE_CARICAMENTO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_IMPORT_DISTRIB]
		params.addValue("ID_IMPORT_DISTRIB", dto.getIdImportDistrib(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PERSONA_GIURIDICA]
		params.addValue("FK_PERSONA_GIURIDICA", dto.getFkPersonaGiuridica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_STATO_DISTRIB]
		params.addValue("FK_STATO_DISTRIB", dto.getFkStatoDistrib(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO_ELAB]
		params.addValue("DATA_INIZIO_ELAB", dto.getDataInizioElab(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_FINE_ELAB]
		params.addValue("DATA_FINE_ELAB", dto.getDataFineElab(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_ANNULLAMENTO]
		params.addValue("DATA_ANNULLAMENTO", dto.getDataAnnullamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [NOME_FILE_IMPORT]
		params.addValue("NOME_FILE_IMPORT", dto.getNomeFileImport(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX]
		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ANNO_RIFERIMENTO]
		params.addValue("ANNO_RIFERIMENTO", dto.getAnnoRiferimento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INVIO_MAIL_DISTRIB]
		params.addValue("DATA_INVIO_MAIL_DISTRIB", dto.getDataInvioMailDistrib(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_INVIO_MAIL_ASSISTENZA]
		params.addValue("DATA_INVIO_MAIL_ASSISTENZA", dto.getDataInvioMailAssistenza(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [TOT_RECORD_ELABORATI]
		params.addValue("TOT_RECORD_ELABORATI", dto.getTotRecordElaborati(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TOT_RECORD_SCARTATI]
		params.addValue("TOT_RECORD_SCARTATI", dto.getTotRecordScartati(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UTENTE_CARICAMENTO]
		params.addValue("UTENTE_CARICAMENTO", dto.getUtenteCaricamento(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTImportDistribDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the SIGIT_T_IMPORT_DISTRIB table.
	 * @generated
	 */
	public void updateColumnsAnnullaImport(SigitTImportDistribDto dto) throws SigitTImportDistribDaoException {
		LOG.debug("[SigitTImportDistribDaoImpl::updateColumnsAnnullaImport] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_STATO_DISTRIB = :FK_STATO_DISTRIB ,DATA_ANNULLAMENTO = :DATA_ANNULLAMENTO ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD  WHERE ID_IMPORT_DISTRIB = :ID_IMPORT_DISTRIB ";

		if (dto.getIdImportDistrib() == null) {
			LOG.error("[SigitTImportDistribDaoImpl::updateColumnsAnnullaImport] ERROR chiave primaria non impostata");
			throw new SigitTImportDistribDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_STATO_DISTRIB]
		params.addValue("FK_STATO_DISTRIB", dto.getFkStatoDistrib(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_ANNULLAMENTO]
		params.addValue("DATA_ANNULLAMENTO", dto.getDataAnnullamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_IMPORT_DISTRIB]
		params.addValue("ID_IMPORT_DISTRIB", dto.getIdImportDistrib(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTImportDistribDaoImpl::updateColumnsAnnullaImport] END");
	}

	protected SigitTImportDistribDaoRowMapper findByPrimaryKeyRowMapper = new SigitTImportDistribDaoRowMapper(null,
			SigitTImportDistribDto.class, this);

	protected SigitTImportDistribDaoRowMapper byIdPersonaGiuridicaRowMapper = new SigitTImportDistribDaoRowMapper(null,
			SigitTImportDistribByIdPersonaGiuridicaDto.class, this);

	protected SigitTImportDistribDaoRowMapper ricevutaByIdImportDistribRowMapper = new SigitTImportDistribDaoRowMapper(
			null, SigitTImportDistribRicevutaByIdImportDistribDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_IMPORT_DISTRIB";
	}

	/** 
	 * Returns all rows from the SIGIT_T_IMPORT_DISTRIB table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTImportDistribDto findByPrimaryKey(SigitTImportDistribPk pk) throws SigitTImportDistribDaoException {
		LOG.debug("[SigitTImportDistribDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_IMPORT_DISTRIB,FK_PERSONA_GIURIDICA,FK_STATO_DISTRIB,DATA_INIZIO_ELAB,DATA_FINE_ELAB,DATA_ANNULLAMENTO,NOME_FILE_IMPORT,UID_INDEX,ANNO_RIFERIMENTO,DATA_INVIO_MAIL_DISTRIB,DATA_INVIO_MAIL_ASSISTENZA,TOT_RECORD_ELABORATI,TOT_RECORD_SCARTATI,DATA_ULT_MOD,UTENTE_ULT_MOD,UTENTE_CARICAMENTO FROM "
						+ getTableName() + " WHERE ID_IMPORT_DISTRIB = :ID_IMPORT_DISTRIB ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_IMPORT_DISTRIB]
		params.addValue("ID_IMPORT_DISTRIB", pk.getIdImportDistrib(), java.sql.Types.INTEGER);

		List<SigitTImportDistribDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTImportDistribDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTImportDistribDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImportDistribDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTImportDistribDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
		 * Implementazione del finder byIdPersonaGiuridica con Qdef
		 * @generated
		 */

	public List<SigitTImportDistribByIdPersonaGiuridicaDto> findByIdPersonaGiuridica(java.lang.Integer input)
			throws SigitTImportDistribDaoException {
		LOG.debug("[SigitTImportDistribDaoImpl::findByIdPersonaGiuridica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT id.ID_IMPORT_DISTRIB, id.DATA_INIZIO_ELAB, id.DATA_FINE_ELAB, id.NOME_FILE_IMPORT, id.ANNO_RIFERIMENTO, sd.DES_STATO_DISTRIB, id.DATA_ANNULLAMENTO, id.TOT_RECORD_ELABORATI, id.TOT_RECORD_SCARTATI");

		sql.append(" FROM SIGIT_T_IMPORT_DISTRIB id, SIGIT_D_STATO_DISTRIB sd");

		sql.append(" WHERE ");

		sql.append("id.FK_STATO_DISTRIB = sd.ID_STATO_DISTRIB");

		sql.append(" AND ");

		sql.append("id.fk_persona_giuridica = :idPersonoGiuridica");
		/*PROTECTED REGION ID(R1329267087) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" ORDER BY DATA_INIZIO_ELAB DESC");

		paramMap.addValue("idPersonoGiuridica", input);

		/*PROTECTED REGION END*/

		List<SigitTImportDistribByIdPersonaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdPersonaGiuridicaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTImportDistribDaoImpl::findByIdPersonaGiuridica] ERROR esecuzione query", ex);
			throw new SigitTImportDistribDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImportDistribDaoImpl", "findByIdPersonaGiuridica", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTImportDistribDaoImpl::findByIdPersonaGiuridica] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder ricevutaByIdImportDistrib con Qdef
		 * @generated
		 */

	public List<SigitTImportDistribRicevutaByIdImportDistribDto> findRicevutaByIdImportDistrib(java.lang.Integer input)
			throws SigitTImportDistribDaoException {
		LOG.debug("[SigitTImportDistribDaoImpl::findRicevutaByIdImportDistrib] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT id.ID_IMPORT_DISTRIB, id.DATA_INIZIO_ELAB, id.DATA_FINE_ELAB, id.NOME_FILE_IMPORT, id.ANNO_RIFERIMENTO, sd.DES_STATO_DISTRIB, id.DATA_ANNULLAMENTO, pg.SIGLA_REA, pg.NUMERO_REA, pg.COMUNE, pg.SIGLA_PROV, pg.INDIRIZZO_SITAD, pg.INDIRIZZO_NON_TROVATO, pg.CIVICO, pg.DENOMINAZIONE, pg.CODICE_FISCALE");

		sql.append(" FROM SIGIT_T_IMPORT_DISTRIB id, SIGIT_D_STATO_DISTRIB sd, SIGIT_T_PERSONA_GIURIDICA pg");

		sql.append(" WHERE ");

		sql.append("id.FK_STATO_DISTRIB = sd.ID_STATO_DISTRIB AND id.FK_PERSONA_GIURIDICA = pg.ID_PERSONA_GIURIDICA");

		sql.append(" AND ");

		sql.append("id.ID_IMPORT_DISTRIB = :idImportDistrib");
		/*PROTECTED REGION ID(R-1449092311) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idImportDistrib", input);

		/*PROTECTED REGION END*/

		List<SigitTImportDistribRicevutaByIdImportDistribDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ricevutaByIdImportDistribRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTImportDistribDaoImpl::findRicevutaByIdImportDistrib] ERROR esecuzione query", ex);
			throw new SigitTImportDistribDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImportDistribDaoImpl", "findRicevutaByIdImportDistrib", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTImportDistribDaoImpl::findRicevutaByIdImportDistrib] END");
		}
		return list;
	}

}
