package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.impl;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.mapper.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import it.csi.sigit.sigitbatchn.business.dao.impl.*;
import it.csi.sigit.sigitbatchn.business.dao.util.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R830257815) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTAllegato.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - byCodiceBollino (datagen::CustomFinder)
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTAllegatoDaoImpl extends AbstractDAO implements SigitTAllegatoDao {
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
	 * Metodo di inserimento del DAO sigitTAllegato. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAllegatoPk
	 * @generated
	 */

	public SigitTAllegatoPk insert(SigitTAllegatoDto dto)

	{
		LOG.debug("[SigitTAllegatoDaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ALLEGATO,FK_STATO_RAPP,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,CF_REDATTORE,UID_INDEX,F_FIRMA_TECNICO,F_FIRMA_RESPONSABILE,FLG_CONTROLLO_BOZZA,A_POTENZA_TERMICA_NOMINALE_MAX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,DATA_RESPINTA,MOTIVO_RESPINTA,FK_PG_CAT,ABCDF_CONTROLLOWEB,FK_TIPO_MANUTENZIONE,ALTRO_DESCR,FK_ISPEZ_ISPET,DT_INVIO_MEMO,MAIL_INVIO_MEMO,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO,ID_LOG_MEMO_PTU ) VALUES (  :ID_ALLEGATO , :FK_STATO_RAPP , :FK_TIPO_DOCUMENTO , :FK_SIGLA_BOLLINO , :FK_NUMERO_BOLLINO , :DATA_CONTROLLO , :B_FLG_LIBRETTO_USO , :B_FLG_DICHIAR_CONFORM , :B_FLG_LIB_IMP , :B_FLG_LIB_COMPL , :F_OSSERVAZIONI , :F_RACCOMANDAZIONI , :F_PRESCRIZIONI , :F_FLG_PUO_FUNZIONARE , :F_INTERVENTO_ENTRO , :F_ORA_ARRIVO , :F_ORA_PARTENZA , :F_DENOMINAZ_TECNICO , :F_FLG_FIRMA_TECNICO , :F_FLG_FIRMA_RESPONSABILE , :DATA_INVIO , :NOME_ALLEGATO , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :CF_REDATTORE , :UID_INDEX , :F_FIRMA_TECNICO , :F_FIRMA_RESPONSABILE , :FLG_CONTROLLO_BOZZA , :A_POTENZA_TERMICA_NOMINALE_MAX , :ELENCO_COMBUSTIBILI , :ELENCO_APPARECCHIATURE , :DATA_RESPINTA , :MOTIVO_RESPINTA , :FK_PG_CAT , :ABCDF_CONTROLLOWEB , :FK_TIPO_MANUTENZIONE , :ALTRO_DESCR , :FK_ISPEZ_ISPET , :DT_INVIO_MEMO , :MAIL_INVIO_MEMO , :UID_INDEX_FIRMATO , :NOME_ALLEGATO_FIRMATO , :ID_LOG_MEMO_PTU  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_STATO_RAPP]
		params.addValue("FK_STATO_RAPP", dto.getFkStatoRapp(), java.sql.Types.NUMERIC);

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

		// valorizzazione paametro relativo a colonna [F_FIRMA_TECNICO]
		params.addValue("F_FIRMA_TECNICO", dto.getFFirmaTecnico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [F_FIRMA_RESPONSABILE]
		params.addValue("F_FIRMA_RESPONSABILE", dto.getFFirmaResponsabile(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_CONTROLLO_BOZZA]
		params.addValue("FLG_CONTROLLO_BOZZA", dto.getFlgControlloBozza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [A_POTENZA_TERMICA_NOMINALE_MAX]
		params.addValue("A_POTENZA_TERMICA_NOMINALE_MAX", dto.getAPotenzaTermicaNominaleMax(), java.sql.Types.NUMERIC);

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

		// valorizzazione paametro relativo a colonna [FK_ISPEZ_ISPET]
		params.addValue("FK_ISPEZ_ISPET", dto.getFkIspezIspet(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_INVIO_MEMO]
		params.addValue("DT_INVIO_MEMO", dto.getDtInvioMemo(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [MAIL_INVIO_MEMO]
		params.addValue("MAIL_INVIO_MEMO", dto.getMailInvioMemo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX_FIRMATO]
		params.addValue("UID_INDEX_FIRMATO", dto.getUidIndexFirmato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOME_ALLEGATO_FIRMATO]
		params.addValue("NOME_ALLEGATO_FIRMATO", dto.getNomeAllegatoFirmato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_LOG_MEMO_PTU]
		params.addValue("ID_LOG_MEMO_PTU", dto.getIdLogMemoPtu(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdAllegato(newKey);
		LOG.debug("[SigitTAllegatoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_ALLEGATO table.
	 * @generated
	 */
	public void update(SigitTAllegatoDto dto) throws SigitTAllegatoDaoException {
		LOG.debug("[SigitTAllegatoDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_STATO_RAPP = :FK_STATO_RAPP ,FK_TIPO_DOCUMENTO = :FK_TIPO_DOCUMENTO ,FK_SIGLA_BOLLINO = :FK_SIGLA_BOLLINO ,FK_NUMERO_BOLLINO = :FK_NUMERO_BOLLINO ,DATA_CONTROLLO = :DATA_CONTROLLO ,B_FLG_LIBRETTO_USO = :B_FLG_LIBRETTO_USO ,B_FLG_DICHIAR_CONFORM = :B_FLG_DICHIAR_CONFORM ,B_FLG_LIB_IMP = :B_FLG_LIB_IMP ,B_FLG_LIB_COMPL = :B_FLG_LIB_COMPL ,F_OSSERVAZIONI = :F_OSSERVAZIONI ,F_RACCOMANDAZIONI = :F_RACCOMANDAZIONI ,F_PRESCRIZIONI = :F_PRESCRIZIONI ,F_FLG_PUO_FUNZIONARE = :F_FLG_PUO_FUNZIONARE ,F_INTERVENTO_ENTRO = :F_INTERVENTO_ENTRO ,F_ORA_ARRIVO = :F_ORA_ARRIVO ,F_ORA_PARTENZA = :F_ORA_PARTENZA ,F_DENOMINAZ_TECNICO = :F_DENOMINAZ_TECNICO ,F_FLG_FIRMA_TECNICO = :F_FLG_FIRMA_TECNICO ,F_FLG_FIRMA_RESPONSABILE = :F_FLG_FIRMA_RESPONSABILE ,DATA_INVIO = :DATA_INVIO ,NOME_ALLEGATO = :NOME_ALLEGATO ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,CF_REDATTORE = :CF_REDATTORE ,UID_INDEX = :UID_INDEX ,F_FIRMA_TECNICO = :F_FIRMA_TECNICO ,F_FIRMA_RESPONSABILE = :F_FIRMA_RESPONSABILE ,FLG_CONTROLLO_BOZZA = :FLG_CONTROLLO_BOZZA ,A_POTENZA_TERMICA_NOMINALE_MAX = :A_POTENZA_TERMICA_NOMINALE_MAX ,ELENCO_COMBUSTIBILI = :ELENCO_COMBUSTIBILI ,ELENCO_APPARECCHIATURE = :ELENCO_APPARECCHIATURE ,DATA_RESPINTA = :DATA_RESPINTA ,MOTIVO_RESPINTA = :MOTIVO_RESPINTA ,FK_PG_CAT = :FK_PG_CAT ,ABCDF_CONTROLLOWEB = :ABCDF_CONTROLLOWEB ,FK_TIPO_MANUTENZIONE = :FK_TIPO_MANUTENZIONE ,ALTRO_DESCR = :ALTRO_DESCR ,FK_ISPEZ_ISPET = :FK_ISPEZ_ISPET ,DT_INVIO_MEMO = :DT_INVIO_MEMO ,MAIL_INVIO_MEMO = :MAIL_INVIO_MEMO ,UID_INDEX_FIRMATO = :UID_INDEX_FIRMATO ,NOME_ALLEGATO_FIRMATO = :NOME_ALLEGATO_FIRMATO ,ID_LOG_MEMO_PTU = :ID_LOG_MEMO_PTU  WHERE ID_ALLEGATO = :ID_ALLEGATO ";

		if (dto.getIdAllegato() == null) {
			LOG.error("[SigitTAllegatoDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTAllegatoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_STATO_RAPP]
		params.addValue("FK_STATO_RAPP", dto.getFkStatoRapp(), java.sql.Types.NUMERIC);

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

		// valorizzazione paametro relativo a colonna [F_FIRMA_TECNICO]
		params.addValue("F_FIRMA_TECNICO", dto.getFFirmaTecnico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [F_FIRMA_RESPONSABILE]
		params.addValue("F_FIRMA_RESPONSABILE", dto.getFFirmaResponsabile(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_CONTROLLO_BOZZA]
		params.addValue("FLG_CONTROLLO_BOZZA", dto.getFlgControlloBozza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [A_POTENZA_TERMICA_NOMINALE_MAX]
		params.addValue("A_POTENZA_TERMICA_NOMINALE_MAX", dto.getAPotenzaTermicaNominaleMax(), java.sql.Types.NUMERIC);

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

		// valorizzazione paametro relativo a colonna [FK_ISPEZ_ISPET]
		params.addValue("FK_ISPEZ_ISPET", dto.getFkIspezIspet(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_INVIO_MEMO]
		params.addValue("DT_INVIO_MEMO", dto.getDtInvioMemo(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [MAIL_INVIO_MEMO]
		params.addValue("MAIL_INVIO_MEMO", dto.getMailInvioMemo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [UID_INDEX_FIRMATO]
		params.addValue("UID_INDEX_FIRMATO", dto.getUidIndexFirmato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOME_ALLEGATO_FIRMATO]
		params.addValue("NOME_ALLEGATO_FIRMATO", dto.getNomeAllegatoFirmato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_LOG_MEMO_PTU]
		params.addValue("ID_LOG_MEMO_PTU", dto.getIdLogMemoPtu(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAllegatoDaoImpl::update] END");
	}

	protected SigitTAllegatoDaoRowMapper byCodiceBollinoRowMapper = new SigitTAllegatoDaoRowMapper(null,
			SigitTAllegatoDto.class, this);

	protected SigitTAllegatoDaoRowMapper findByPrimaryKeyRowMapper = new SigitTAllegatoDaoRowMapper(null,
			SigitTAllegatoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_ALLEGATO";
	}

	/** 
	 * Implementazione del finder byCodiceBollino
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAllegatoDto> findByCodiceBollino(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter.BollinoFilter input)
			throws SigitTAllegatoDaoException {
		LOG.debug("[SigitTAllegatoDaoImpl::findByCodiceBollino] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,CF_REDATTORE,UID_INDEX,F_FIRMA_TECNICO,F_FIRMA_RESPONSABILE,FLG_CONTROLLO_BOZZA,A_POTENZA_TERMICA_NOMINALE_MAX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,DATA_RESPINTA,MOTIVO_RESPINTA,FK_PG_CAT,ABCDF_CONTROLLOWEB,FK_TIPO_MANUTENZIONE,ALTRO_DESCR,FK_ISPEZ_ISPET,DT_INVIO_MEMO,MAIL_INVIO_MEMO,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO,ID_LOG_MEMO_PTU ");
		sql.append(" FROM SIGIT_T_ALLEGATO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1301815532) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" FK_SIGLA_BOLLINO = :siglaBollino");
		sql.append(" AND FK_NUMERO_BOLLINO = :numeroBollino");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1826462078) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("siglaBollino", input.getSiglaBollino());
		paramMap.addValue("numeroBollino", input.getNumeroBollino());

		/*PROTECTED REGION END*/
		List<SigitTAllegatoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceBollinoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTAllegatoDaoImpl::findByCodiceBollino] esecuzione query", ex);
			throw new SigitTAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAllegatoDaoImpl", "findByCodiceBollino", "esecuzione query", sql.toString());
			LOG.debug("[SigitTAllegatoDaoImpl::findByCodiceBollino] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_T_ALLEGATO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTAllegatoDto findByPrimaryKey(SigitTAllegatoPk pk) throws SigitTAllegatoDaoException {
		LOG.debug("[SigitTAllegatoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,CF_REDATTORE,UID_INDEX,F_FIRMA_TECNICO,F_FIRMA_RESPONSABILE,FLG_CONTROLLO_BOZZA,A_POTENZA_TERMICA_NOMINALE_MAX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,DATA_RESPINTA,MOTIVO_RESPINTA,FK_PG_CAT,ABCDF_CONTROLLOWEB,FK_TIPO_MANUTENZIONE,ALTRO_DESCR,FK_ISPEZ_ISPET,DT_INVIO_MEMO,MAIL_INVIO_MEMO,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO,ID_LOG_MEMO_PTU FROM "
						+ getTableName() + " WHERE ID_ALLEGATO = :ID_ALLEGATO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.NUMERIC);

		List<SigitTAllegatoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTAllegatoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAllegatoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTAllegatoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
