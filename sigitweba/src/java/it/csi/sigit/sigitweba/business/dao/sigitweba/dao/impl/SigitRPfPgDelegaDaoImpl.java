package it.csi.sigit.sigitweba.business.dao.sigitweba.dao.impl;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.mapper.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.qbe.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.metadata.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import it.csi.sigit.sigitweba.business.dao.impl.*;
import it.csi.sigit.sigitweba.business.dao.util.*;
import it.csi.sigit.sigitweba.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R-931864445) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRPfPgDelega.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byIdPersonaFisica (datagen::CustomFinder)
 *   - byCodiceFiscalePF (datagen::CustomFinder)
 *   - attiveAccByIdPersonaGiuridica (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRPfPgDelegaDaoImpl extends AbstractDAO implements SigitRPfPgDelegaDao {
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
	 * Metodo di inserimento del DAO sigitRPfPgDelega. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRPfPgDelegaPk
	 * @generated
	 */

	public SigitRPfPgDelegaPk insert(SigitRPfPgDelegaDto dto)

	{
		LOG.debug("[SigitRPfPgDelegaDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PERSONA_FISICA,ID_PERSONA_GIURIDICA,DATA_INIZIO,FK_RUOLO_ACCRED,FK_TIPO_DM,FLG_DELEGA,DATA_FINE,DATA_ULT_MOD,UTENTE_ULT_MOD ) VALUES (  :ID_PERSONA_FISICA , :ID_PERSONA_GIURIDICA , :DATA_INIZIO , :FK_RUOLO_ACCRED , :FK_TIPO_DM , :FLG_DELEGA , :DATA_FINE , :DATA_ULT_MOD , :UTENTE_ULT_MOD  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", dto.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA]
		params.addValue("ID_PERSONA_GIURIDICA", dto.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_RUOLO_ACCRED]
		params.addValue("FK_RUOLO_ACCRED", dto.getFkRuoloAccred(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_DM]
		params.addValue("FK_TIPO_DM", dto.getFkTipoDm(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_DELEGA]
		params.addValue("FLG_DELEGA", dto.getFlgDelega(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitRPfPgDelegaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_R_PF_PG_DELEGA table.
	 * @generated
	 */
	public void update(SigitRPfPgDelegaDto dto) throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_RUOLO_ACCRED = :FK_RUOLO_ACCRED ,FK_TIPO_DM = :FK_TIPO_DM ,FLG_DELEGA = :FLG_DELEGA ,DATA_FINE = :DATA_FINE ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD  WHERE ID_PERSONA_FISICA = :ID_PERSONA_FISICA  AND ID_PERSONA_GIURIDICA = :ID_PERSONA_GIURIDICA  AND DATA_INIZIO = :DATA_INIZIO ";

		if (dto.getIdPersonaFisica() == null || dto.getIdPersonaGiuridica() == null || dto.getDataInizio() == null) {
			LOG.error("[SigitRPfPgDelegaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitRPfPgDelegaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", dto.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA]
		params.addValue("ID_PERSONA_GIURIDICA", dto.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_RUOLO_ACCRED]
		params.addValue("FK_RUOLO_ACCRED", dto.getFkRuoloAccred(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_DM]
		params.addValue("FK_TIPO_DM", dto.getFkTipoDm(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_DELEGA]
		params.addValue("FLG_DELEGA", dto.getFlgDelega(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRPfPgDelegaDaoImpl::update] END");
	}

	protected SigitRPfPgDelegaDaoRowMapper findByPrimaryKeyRowMapper = new SigitRPfPgDelegaDaoRowMapper(null,
			SigitRPfPgDelegaDto.class, this);

	protected SigitRPfPgDelegaDaoRowMapper byIdPersonaFisicaRowMapper = new SigitRPfPgDelegaDaoRowMapper(null,
			SigitRPfPgDelegaByIdPersonaFisicaDto.class, this);

	protected SigitRPfPgDelegaDaoRowMapper byCodiceFiscalePFRowMapper = new SigitRPfPgDelegaDaoRowMapper(null,
			SigitRPfPgDelegaByCodiceFiscalePFDto.class, this);

	protected SigitRPfPgDelegaDaoRowMapper attiveAccByIdPersonaGiuridicaRowMapper = new SigitRPfPgDelegaDaoRowMapper(
			null, SigitRPfPgDelegaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_PF_PG_DELEGA";
	}

	/** 
	 * Returns all rows from the SIGIT_R_PF_PG_DELEGA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRPfPgDelegaDto findByPrimaryKey(SigitRPfPgDelegaPk pk) throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA_FISICA,ID_PERSONA_GIURIDICA,DATA_INIZIO,FK_RUOLO_ACCRED,FK_TIPO_DM,FLG_DELEGA,DATA_FINE,DATA_ULT_MOD,UTENTE_ULT_MOD FROM "
						+ getTableName()
						+ " WHERE ID_PERSONA_FISICA = :ID_PERSONA_FISICA  AND ID_PERSONA_GIURIDICA = :ID_PERSONA_GIURIDICA  AND DATA_INIZIO = :DATA_INIZIO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", pk.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA]
		params.addValue("ID_PERSONA_GIURIDICA", pk.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", pk.getDataInizio(), java.sql.Types.DATE);

		List<SigitRPfPgDelegaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfPgDelegaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitRPfPgDelegaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfPgDelegaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPfPgDelegaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
		 * Implementazione del finder byIdPersonaFisica con Qdef
		 * @generated
		 */

	public List<SigitRPfPgDelegaByIdPersonaFisicaDto> findByIdPersonaFisica(java.math.BigDecimal input)
			throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::findByIdPersonaFisica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT A.ID_PERSONA_FISICA, A.ID_PERSONA_GIURIDICA, A.FLG_DELEGA, A.DATA_INIZIO, A.DATA_FINE, B.DENOMINAZIONE, B.CODICE_FISCALE, B.INDIRIZZO_SITAD, B.INDIRIZZO_NON_TROVATO, B.SIGLA_PROV, B.ISTAT_COMUNE, B.COMUNE, B.PROVINCIA, B.CIVICO, B.CAP, B.EMAIL, B.DATA_INIZIO_ATTIVITA, B.DATA_CESSAZIONE, B.SIGLA_REA, B.NUMERO_REA, B.FLG_AMMINISTRATORE, B.FLG_TERZO_RESPONSABILE, A.FK_RUOLO_ACCRED as ruoloAccred, A.FK_TIPO_DM as tipoDm, B.FK_L2, B.FLG_DM37_LETTERAC, B.FLG_DM37_LETTERAD, B.FLG_DM37_LETTERAE, B.FLG_FGAS, B.FLG_CONDUTTORE, B.FLG_SOGG_INCARICATO, B.DELEGA_SOGG_INCARICATO");

		sql.append(" FROM SIGIT_R_PF_PG_DELEGA A, SIGIT_T_PERSONA_GIURIDICA B");

		sql.append(" WHERE ");

		sql.append("A.ID_PERSONA_GIURIDICA = B.ID_PERSONA_GIURIDICA");

		sql.append(" AND ");

		sql.append("A.ID_PERSONA_FISICA = :idPersona");
		/*PROTECTED REGION ID(R-192308909) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPersona", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/

		List<SigitRPfPgDelegaByIdPersonaFisicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdPersonaFisicaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfPgDelegaDaoImpl::findByIdPersonaFisica] ERROR esecuzione query", ex);
			throw new SigitRPfPgDelegaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfPgDelegaDaoImpl", "findByIdPersonaFisica", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRPfPgDelegaDaoImpl::findByIdPersonaFisica] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byCodiceFiscalePF con Qdef
		 * @generated
		 */

	public List<SigitRPfPgDelegaByCodiceFiscalePFDto> findByCodiceFiscalePF(String input)
			throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::findByCodiceFiscalePF] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT A.ID_PERSONA_FISICA, A.ID_PERSONA_GIURIDICA, A.FLG_DELEGA, A.DATA_INIZIO, A.DATA_FINE, B.DENOMINAZIONE, B.CODICE_FISCALE, B.INDIRIZZO_SITAD, B.INDIRIZZO_NON_TROVATO, B.SIGLA_PROV, B.ISTAT_COMUNE, B.COMUNE, B.PROVINCIA, B.CIVICO, B.CAP, B.EMAIL, B.DATA_INIZIO_ATTIVITA, B.DATA_CESSAZIONE, B.SIGLA_REA, B.NUMERO_REA, B.FLG_AMMINISTRATORE, B.FLG_TERZO_RESPONSABILE, B.FLG_DISTRIBUTORE, B.FLG_CAT, A.FK_RUOLO_ACCRED as ruoloAccred, A.FK_TIPO_DM as tipoDm, B.FK_L2, B.FLG_INDIRIZZO_ESTERO, B.STATO_ESTERO, B.CITTA_ESTERO, B.INDIRIZZO_ESTERO, B.CAP_ESTERO, B.FK_STATO_PG, d.DES_STATO_PG, B.FLG_DM37_LETTERAC, B.FLG_DM37_LETTERAD, B.FLG_DM37_LETTERAE, B.FLG_FGAS, B.FLG_CONDUTTORE, B.FLG_SOGG_INCARICATO, B.DELEGA_SOGG_INCARICATO, B.PEC, B.TELEFONO");

		sql.append(
				" FROM SIGIT_R_PF_PG_DELEGA A, SIGIT_T_PERSONA_GIURIDICA B, SIGIT_T_PERSONA_FISICA C, SIGIT_D_STATO_PG d");

		sql.append(" WHERE ");

		sql.append(
				"A.ID_PERSONA_GIURIDICA = B.ID_PERSONA_GIURIDICA AND A.ID_PERSONA_FISICA = C.ID_PERSONA_FISICA AND B.FK_STATO_PG = d.ID_STATO_PG");

		sql.append(" AND ");

		sql.append("C.CODICE_FISCALE = :codFiscale");
		/*PROTECTED REGION ID(R-1508978251) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("codFiscale", input, java.sql.Types.VARCHAR);

		/*PROTECTED REGION END*/

		List<SigitRPfPgDelegaByCodiceFiscalePFDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceFiscalePFRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfPgDelegaDaoImpl::findByCodiceFiscalePF] ERROR esecuzione query", ex);
			throw new SigitRPfPgDelegaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfPgDelegaDaoImpl", "findByCodiceFiscalePF", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRPfPgDelegaDaoImpl::findByCodiceFiscalePF] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder attiveAccByIdPersonaGiuridica
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfPgDelegaDto> findAttiveAccByIdPersonaGiuridica(java.math.BigDecimal input)
			throws SigitRPfPgDelegaDaoException {
		LOG.debug("[SigitRPfPgDelegaDaoImpl::findAttiveAccByIdPersonaGiuridica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA_FISICA,ID_PERSONA_GIURIDICA,DATA_INIZIO,FK_RUOLO_ACCRED,FK_TIPO_DM,FLG_DELEGA,DATA_FINE,DATA_ULT_MOD,UTENTE_ULT_MOD ");
		sql.append(" FROM SIGIT_R_PF_PG_DELEGA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1391826655) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append("ID_PERSONA_GIURIDICA = :idPersonaG");
		sql.append(" AND FLG_DELEGA = '" + Constants.FLAG_ACCREDITAMENTO + "'");
		sql.append(" AND DATA_FINE IS NULL ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R683610823) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idPersonaG", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitRPfPgDelegaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attiveAccByIdPersonaGiuridicaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfPgDelegaDaoImpl::findAttiveAccByIdPersonaGiuridica] esecuzione query", ex);
			throw new SigitRPfPgDelegaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfPgDelegaDaoImpl", "findAttiveAccByIdPersonaGiuridica", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRPfPgDelegaDaoImpl::findAttiveAccByIdPersonaGiuridica] END");
		}
		return list;
	}

}
