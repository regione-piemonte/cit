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

/*PROTECTED REGION ID(R1514768341) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitSAllegato.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - byCodiceImpianto (datagen::CustomFinder)
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitSAllegatoDaoImpl extends AbstractDAO implements SigitSAllegatoDao {
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
	 * Metodo di inserimento del DAO sigitSAllegato. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitSAllegatoPk
	 * @generated
	 */

	public SigitSAllegatoPk insert(SigitSAllegatoDto dto)

	{
		LOG.debug("[SigitSAllegatoDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ALLEGATO,FK_STATO_RAPP,FK_IMP_RUOLO_PFPG,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,CF_REDATTORE,UID_INDEX,FLG_CONTROLLO_BOZZA,A_POTENZA_TERMICA_NOMINALE_MAX,F_FIRMA_TECNICO,F_FIRMA_RESPONSABILE,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,DATA_RESPINTA,MOTIVO_RESPINTA,FK_PG_CAT,ABCDF_CONTROLLOWEB,FK_TIPO_MANUTENZIONE,ALTRO_DESCR,DT_INVIO_MEMO,MAIL_INVIO_MEMO,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO ) VALUES (  :ID_ALLEGATO , :FK_STATO_RAPP , :FK_IMP_RUOLO_PFPG , :FK_TIPO_DOCUMENTO , :FK_SIGLA_BOLLINO , :FK_NUMERO_BOLLINO , :DATA_CONTROLLO , :B_FLG_LIBRETTO_USO , :B_FLG_DICHIAR_CONFORM , :B_FLG_LIB_IMP , :B_FLG_LIB_COMPL , :F_OSSERVAZIONI , :F_RACCOMANDAZIONI , :F_PRESCRIZIONI , :F_FLG_PUO_FUNZIONARE , :F_INTERVENTO_ENTRO , :F_ORA_ARRIVO , :F_ORA_PARTENZA , :F_DENOMINAZ_TECNICO , :F_FLG_FIRMA_TECNICO , :F_FLG_FIRMA_RESPONSABILE , :DATA_INVIO , :NOME_ALLEGATO , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :CF_REDATTORE , :UID_INDEX , :FLG_CONTROLLO_BOZZA , :A_POTENZA_TERMICA_NOMINALE_MAX , :F_FIRMA_TECNICO , :F_FIRMA_RESPONSABILE , :ELENCO_COMBUSTIBILI , :ELENCO_APPARECCHIATURE , :DATA_RESPINTA , :MOTIVO_RESPINTA , :FK_PG_CAT , :ABCDF_CONTROLLOWEB , :FK_TIPO_MANUTENZIONE , :ALTRO_DESCR , :DT_INVIO_MEMO , :MAIL_INVIO_MEMO , :UID_INDEX_FIRMATO , :NOME_ALLEGATO_FIRMATO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_STATO_RAPP]
		params.addValue("FK_STATO_RAPP", dto.getFkStatoRapp(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_IMP_RUOLO_PFPG]
		params.addValue("FK_IMP_RUOLO_PFPG", dto.getFkImpRuoloPfpg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_DOCUMENTO]
		params.addValue("FK_TIPO_DOCUMENTO", dto.getFkTipoDocumento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_SIGLA_BOLLINO]
		params.addValue("FK_SIGLA_BOLLINO", dto.getFkSiglaBollino(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_NUMERO_BOLLINO]
		params.addValue("FK_NUMERO_BOLLINO", dto.getFkNumeroBollino(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_CONTROLLO]
		params.addValue("DATA_CONTROLLO", dto.getDataControllo(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [B_FLG_LIBRETTO_USO]
		params.addValue("B_FLG_LIBRETTO_USO", dto.getBFlgLibrettoUso(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [B_FLG_DICHIAR_CONFORM]
		params.addValue("B_FLG_DICHIAR_CONFORM", dto.getBFlgDichiarConform(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [B_FLG_LIB_IMP]
		params.addValue("B_FLG_LIB_IMP", dto.getBFlgLibImp(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [B_FLG_LIB_COMPL]
		params.addValue("B_FLG_LIB_COMPL", dto.getBFlgLibCompl(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_OSSERVAZIONI]
		params.addValue("F_OSSERVAZIONI", dto.getFOsservazioni(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [F_RACCOMANDAZIONI]
		params.addValue("F_RACCOMANDAZIONI", dto.getFRaccomandazioni(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [F_PRESCRIZIONI]
		params.addValue("F_PRESCRIZIONI", dto.getFPrescrizioni(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [F_FLG_PUO_FUNZIONARE]
		params.addValue("F_FLG_PUO_FUNZIONARE", dto.getFFlgPuoFunzionare(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_INTERVENTO_ENTRO]
		params.addValue("F_INTERVENTO_ENTRO", dto.getFInterventoEntro(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [F_ORA_ARRIVO]
		params.addValue("F_ORA_ARRIVO", dto.getFOraArrivo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [F_ORA_PARTENZA]
		params.addValue("F_ORA_PARTENZA", dto.getFOraPartenza(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [F_DENOMINAZ_TECNICO]
		params.addValue("F_DENOMINAZ_TECNICO", dto.getFDenominazTecnico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [F_FLG_FIRMA_TECNICO]
		params.addValue("F_FLG_FIRMA_TECNICO", dto.getFFlgFirmaTecnico(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_FIRMA_RESPONSABILE]
		params.addValue("F_FLG_FIRMA_RESPONSABILE", dto.getFFlgFirmaResponsabile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INVIO]
		params.addValue("DATA_INVIO", dto.getDataInvio(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOME_ALLEGATO]
		params.addValue("NOME_ALLEGATO", dto.getNomeAllegato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CF_REDATTORE]
		params.addValue("CF_REDATTORE", dto.getCfRedattore(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX]
		params.addValue("UID_INDEX", dto.getUidIndex(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_CONTROLLO_BOZZA]
		params.addValue("FLG_CONTROLLO_BOZZA", dto.getFlgControlloBozza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [A_POTENZA_TERMICA_NOMINALE_MAX]
		params.addValue("A_POTENZA_TERMICA_NOMINALE_MAX", dto.getAPotenzaTermicaNominaleMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FIRMA_TECNICO]
		params.addValue("F_FIRMA_TECNICO", dto.getFFirmaTecnico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [F_FIRMA_RESPONSABILE]
		params.addValue("F_FIRMA_RESPONSABILE", dto.getFFirmaResponsabile(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ELENCO_COMBUSTIBILI]
		params.addValue("ELENCO_COMBUSTIBILI", dto.getElencoCombustibili(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ELENCO_APPARECCHIATURE]
		params.addValue("ELENCO_APPARECCHIATURE", dto.getElencoApparecchiature(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_RESPINTA]
		params.addValue("DATA_RESPINTA", dto.getDataRespinta(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [MOTIVO_RESPINTA]
		params.addValue("MOTIVO_RESPINTA", dto.getMotivoRespinta(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_PG_CAT]
		params.addValue("FK_PG_CAT", dto.getFkPgCat(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ABCDF_CONTROLLOWEB]
		params.addValue("ABCDF_CONTROLLOWEB", dto.getAbcdfControlloweb(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_TIPO_MANUTENZIONE]
		params.addValue("FK_TIPO_MANUTENZIONE", dto.getFkTipoManutenzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ALTRO_DESCR]
		params.addValue("ALTRO_DESCR", dto.getAltroDescr(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DT_INVIO_MEMO]
		params.addValue("DT_INVIO_MEMO", dto.getDtInvioMemo(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [MAIL_INVIO_MEMO]
		params.addValue("MAIL_INVIO_MEMO", dto.getMailInvioMemo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX_FIRMATO]
		params.addValue("UID_INDEX_FIRMATO", dto.getUidIndexFirmato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOME_ALLEGATO_FIRMATO]
		params.addValue("NOME_ALLEGATO_FIRMATO", dto.getNomeAllegatoFirmato(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdAllegato(newKey);
		LOG.debug("[SigitSAllegatoDaoImpl::insert] END");
		return dto.createPk();

	}

	protected SigitSAllegatoDaoRowMapper findAllRowMapper = new SigitSAllegatoDaoRowMapper(null,
			SigitSAllegatoDto.class, this);

	protected SigitSAllegatoDaoRowMapper byCodiceImpiantoRowMapper = new SigitSAllegatoDaoRowMapper(null,
			SigitSAllegatoDto.class, this);

	protected SigitSAllegatoDaoRowMapper findByPrimaryKeyRowMapper = new SigitSAllegatoDaoRowMapper(null,
			SigitSAllegatoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_S_ALLEGATO";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_S_ALLEGATO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitSAllegatoDto> findAll() throws SigitSAllegatoDaoException {
		LOG.debug("[SigitSAllegatoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_IMP_RUOLO_PFPG,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,CF_REDATTORE,UID_INDEX,FLG_CONTROLLO_BOZZA,A_POTENZA_TERMICA_NOMINALE_MAX,F_FIRMA_TECNICO,F_FIRMA_RESPONSABILE,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,DATA_RESPINTA,MOTIVO_RESPINTA,FK_PG_CAT,ABCDF_CONTROLLOWEB,FK_TIPO_MANUTENZIONE,ALTRO_DESCR,DT_INVIO_MEMO,MAIL_INVIO_MEMO,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitSAllegatoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitSAllegatoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitSAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitSAllegatoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitSAllegatoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitSAllegatoDto> findByCodiceImpianto(java.lang.Integer input) throws SigitSAllegatoDaoException {
		LOG.debug("[SigitSAllegatoDaoImpl::findByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-929425483) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_IMP_RUOLO_PFPG,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,CF_REDATTORE,UID_INDEX,FLG_CONTROLLO_BOZZA,A_POTENZA_TERMICA_NOMINALE_MAX,F_FIRMA_TECNICO,F_FIRMA_RESPONSABILE,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,MOTIVO_RESPINTA,FK_PG_CAT,ABCDF_CONTROLLOWEB,FK_TIPO_MANUTENZIONE,ALTRO_DESCR,DATA_RESPINTA ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1999377287) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_S_ALLEGATO a, SIGIT_R_IMP_RUOLO_PFPG r");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1633789523) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" a.FK_IMP_RUOLO_PFPG = r.ID_IMP_RUOLO_PFPG");
		sql.append(" AND CODICE_IMPIANTO = :codImpianto");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-11568561) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitSAllegatoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitSAllegatoDaoImpl::findByCodiceImpianto] esecuzione query", ex);
			throw new SigitSAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitSAllegatoDaoImpl", "findByCodiceImpianto", "esecuzione query", sql.toString());
			LOG.debug("[SigitSAllegatoDaoImpl::findByCodiceImpianto] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_S_ALLEGATO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitSAllegatoDto findByPrimaryKey(SigitSAllegatoPk pk) throws SigitSAllegatoDaoException {
		LOG.debug("[SigitSAllegatoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_IMP_RUOLO_PFPG,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,CF_REDATTORE,UID_INDEX,FLG_CONTROLLO_BOZZA,A_POTENZA_TERMICA_NOMINALE_MAX,F_FIRMA_TECNICO,F_FIRMA_RESPONSABILE,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,DATA_RESPINTA,MOTIVO_RESPINTA,FK_PG_CAT,ABCDF_CONTROLLOWEB,FK_TIPO_MANUTENZIONE,ALTRO_DESCR,DT_INVIO_MEMO,MAIL_INVIO_MEMO,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO FROM "
						+ getTableName() + " WHERE ID_ALLEGATO = :ID_ALLEGATO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.NUMERIC);

		List<SigitSAllegatoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitSAllegatoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitSAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitSAllegatoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitSAllegatoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
