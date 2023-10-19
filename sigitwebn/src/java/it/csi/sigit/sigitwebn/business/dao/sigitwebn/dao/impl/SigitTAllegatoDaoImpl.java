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

/*PROTECTED REGION ID(R2066620887) ENABLED START*/
// aggiungere qui eventuali import custom. 
import java.math.BigDecimal;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTAllegato.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - byCodiceImpianto (datagen::CustomFinder)
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - controlloBollinoAssegnatoAltroImpianto (datagen::CustomFinder)
 *   - rappProvaByIdIspezione (datagen::CustomFinder)
 *   - rappProvaByIdAllegato (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - respingiAllegato (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
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
				+ " ( 	ID_ALLEGATO,FK_STATO_RAPP,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,CF_REDATTORE,UID_INDEX,F_FIRMA_TECNICO,F_FIRMA_RESPONSABILE,FLG_CONTROLLO_BOZZA,A_POTENZA_TERMICA_NOMINALE_MAX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,DATA_RESPINTA,MOTIVO_RESPINTA,FK_PG_CAT,ABCDF_CONTROLLOWEB,FK_TIPO_MANUTENZIONE,ALTRO_DESCR,FK_ISPEZ_ISPET,DT_INVIO_MEMO,MAIL_INVIO_MEMO,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO ) VALUES (  :ID_ALLEGATO , :FK_STATO_RAPP , :FK_TIPO_DOCUMENTO , :FK_SIGLA_BOLLINO , :FK_NUMERO_BOLLINO , :DATA_CONTROLLO , :B_FLG_LIBRETTO_USO , :B_FLG_DICHIAR_CONFORM , :B_FLG_LIB_IMP , :B_FLG_LIB_COMPL , :F_OSSERVAZIONI , :F_RACCOMANDAZIONI , :F_PRESCRIZIONI , :F_FLG_PUO_FUNZIONARE , :F_INTERVENTO_ENTRO , :F_ORA_ARRIVO , :F_ORA_PARTENZA , :F_DENOMINAZ_TECNICO , :F_FLG_FIRMA_TECNICO , :F_FLG_FIRMA_RESPONSABILE , :DATA_INVIO , :NOME_ALLEGATO , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :CF_REDATTORE , :UID_INDEX , :F_FIRMA_TECNICO , :F_FIRMA_RESPONSABILE , :FLG_CONTROLLO_BOZZA , :A_POTENZA_TERMICA_NOMINALE_MAX , :ELENCO_COMBUSTIBILI , :ELENCO_APPARECCHIATURE , :DATA_RESPINTA , :MOTIVO_RESPINTA , :FK_PG_CAT , :ABCDF_CONTROLLOWEB , :FK_TIPO_MANUTENZIONE , :ALTRO_DESCR , :FK_ISPEZ_ISPET , :DT_INVIO_MEMO , :MAIL_INVIO_MEMO , :UID_INDEX_FIRMATO , :NOME_ALLEGATO_FIRMATO  )";

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
				+ " SET FK_STATO_RAPP = :FK_STATO_RAPP ,FK_TIPO_DOCUMENTO = :FK_TIPO_DOCUMENTO ,FK_SIGLA_BOLLINO = :FK_SIGLA_BOLLINO ,FK_NUMERO_BOLLINO = :FK_NUMERO_BOLLINO ,DATA_CONTROLLO = :DATA_CONTROLLO ,B_FLG_LIBRETTO_USO = :B_FLG_LIBRETTO_USO ,B_FLG_DICHIAR_CONFORM = :B_FLG_DICHIAR_CONFORM ,B_FLG_LIB_IMP = :B_FLG_LIB_IMP ,B_FLG_LIB_COMPL = :B_FLG_LIB_COMPL ,F_OSSERVAZIONI = :F_OSSERVAZIONI ,F_RACCOMANDAZIONI = :F_RACCOMANDAZIONI ,F_PRESCRIZIONI = :F_PRESCRIZIONI ,F_FLG_PUO_FUNZIONARE = :F_FLG_PUO_FUNZIONARE ,F_INTERVENTO_ENTRO = :F_INTERVENTO_ENTRO ,F_ORA_ARRIVO = :F_ORA_ARRIVO ,F_ORA_PARTENZA = :F_ORA_PARTENZA ,F_DENOMINAZ_TECNICO = :F_DENOMINAZ_TECNICO ,F_FLG_FIRMA_TECNICO = :F_FLG_FIRMA_TECNICO ,F_FLG_FIRMA_RESPONSABILE = :F_FLG_FIRMA_RESPONSABILE ,DATA_INVIO = :DATA_INVIO ,NOME_ALLEGATO = :NOME_ALLEGATO ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,CF_REDATTORE = :CF_REDATTORE ,UID_INDEX = :UID_INDEX ,F_FIRMA_TECNICO = :F_FIRMA_TECNICO ,F_FIRMA_RESPONSABILE = :F_FIRMA_RESPONSABILE ,FLG_CONTROLLO_BOZZA = :FLG_CONTROLLO_BOZZA ,A_POTENZA_TERMICA_NOMINALE_MAX = :A_POTENZA_TERMICA_NOMINALE_MAX ,ELENCO_COMBUSTIBILI = :ELENCO_COMBUSTIBILI ,ELENCO_APPARECCHIATURE = :ELENCO_APPARECCHIATURE ,DATA_RESPINTA = :DATA_RESPINTA ,MOTIVO_RESPINTA = :MOTIVO_RESPINTA ,FK_PG_CAT = :FK_PG_CAT ,ABCDF_CONTROLLOWEB = :ABCDF_CONTROLLOWEB ,FK_TIPO_MANUTENZIONE = :FK_TIPO_MANUTENZIONE ,ALTRO_DESCR = :ALTRO_DESCR ,FK_ISPEZ_ISPET = :FK_ISPEZ_ISPET ,DT_INVIO_MEMO = :DT_INVIO_MEMO ,MAIL_INVIO_MEMO = :MAIL_INVIO_MEMO ,UID_INDEX_FIRMATO = :UID_INDEX_FIRMATO ,NOME_ALLEGATO_FIRMATO = :NOME_ALLEGATO_FIRMATO  WHERE ID_ALLEGATO = :ID_ALLEGATO ";

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

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAllegatoDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_ALLEGATO table.
	 * @generated
	 */
	public void updateColumnsRespingiAllegato(SigitTAllegatoDto dto) throws SigitTAllegatoDaoException {
		LOG.debug("[SigitTAllegatoDaoImpl::updateColumnsRespingiAllegato] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_STATO_RAPP = :FK_STATO_RAPP ,FK_SIGLA_BOLLINO = :FK_SIGLA_BOLLINO ,FK_NUMERO_BOLLINO = :FK_NUMERO_BOLLINO ,DATA_RESPINTA = :DATA_RESPINTA ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,MOTIVO_RESPINTA = :MOTIVO_RESPINTA  WHERE ID_ALLEGATO = :ID_ALLEGATO ";

		if (dto.getIdAllegato() == null) {
			LOG.error("[SigitTAllegatoDaoImpl::updateColumnsRespingiAllegato] ERROR chiave primaria non impostata");
			throw new SigitTAllegatoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_STATO_RAPP]
		params.addValue("FK_STATO_RAPP", dto.getFkStatoRapp(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_SIGLA_BOLLINO]
		params.addValue("FK_SIGLA_BOLLINO", dto.getFkSiglaBollino(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_NUMERO_BOLLINO]
		params.addValue("FK_NUMERO_BOLLINO", dto.getFkNumeroBollino(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_RESPINTA]
		params.addValue("DATA_RESPINTA", dto.getDataRespinta(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MOTIVO_RESPINTA]
		params.addValue("MOTIVO_RESPINTA", dto.getMotivoRespinta(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAllegatoDaoImpl::updateColumnsRespingiAllegato] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_ALLEGATO table.
	 * @generated
	 */

	public void delete(SigitTAllegatoPk pk) throws SigitTAllegatoDaoException {
		LOG.debug("[SigitTAllegatoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ALLEGATO = :ID_ALLEGATO ";

		if (pk == null) {
			LOG.error("[SigitTAllegatoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTAllegatoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAllegatoDaoImpl::delete] END");
	}

	protected SigitTAllegatoDaoRowMapper findAllRowMapper = new SigitTAllegatoDaoRowMapper(null,
			SigitTAllegatoDto.class, this);

	protected SigitTAllegatoDaoRowMapper byCodiceImpiantoRowMapper = new SigitTAllegatoDaoRowMapper(null,
			SigitTAllegatoDto.class, this);

	protected SigitTAllegatoDaoRowMapper findByPrimaryKeyRowMapper = new SigitTAllegatoDaoRowMapper(null,
			SigitTAllegatoDto.class, this);

	protected SigitTAllegatoDaoRowMapper controlloBollinoAssegnatoAltroImpiantoRowMapper = new SigitTAllegatoDaoRowMapper(
			null, SigitTAllegatoControlloBollinoAssegnatoAltroImpiantoDto.class, this);

	protected SigitTAllegatoDaoRowMapper rappProvaByIdIspezioneRowMapper = new SigitTAllegatoDaoRowMapper(null,
			SigitTAllegatoRappProvaByIdIspezioneDto.class, this);

	protected SigitTAllegatoDaoRowMapper rappProvaByIdAllegatoRowMapper = new SigitTAllegatoDaoRowMapper(null,
			SigitTAllegatoRappProvaByIdAllegatoDto.class, this);

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
	 * Restituisce tutte le righe della tabella SIGIT_T_ALLEGATO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAllegatoDto> findAll() throws SigitTAllegatoDaoException {
		LOG.debug("[SigitTAllegatoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,CF_REDATTORE,UID_INDEX,F_FIRMA_TECNICO,F_FIRMA_RESPONSABILE,FLG_CONTROLLO_BOZZA,A_POTENZA_TERMICA_NOMINALE_MAX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,DATA_RESPINTA,MOTIVO_RESPINTA,FK_PG_CAT,ABCDF_CONTROLLOWEB,FK_TIPO_MANUTENZIONE,ALTRO_DESCR,FK_ISPEZ_ISPET,DT_INVIO_MEMO,MAIL_INVIO_MEMO,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTAllegatoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTAllegatoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitTAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAllegatoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitTAllegatoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAllegatoDto> findByCodiceImpianto(java.lang.Integer input) throws SigitTAllegatoDaoException {
		LOG.debug("[SigitTAllegatoDaoImpl::findByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-2112772780) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_IMP_RUOLO_PFPG,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,XML_ALLEGATO,NOME_ALLEGATO,CF_REDATTORE,FLG_CONTROLLO_BOZZA,UID_INDEX,a.DATA_ULT_MOD,a.UTENTE_ULT_MOD ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R974683366) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_ALLEGATO a, SIGIT_R_IMP_RUOLO_PFPG r");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-66950956) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		sql.append(" a.FK_IMP_RUOLO_PFPG = r.ID_IMP_RUOLO_PFPG");
		sql.append(" AND CODICE_IMPIANTO = :codImpianto");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1194915858) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input);

		/*PROTECTED REGION END*/
		List<SigitTAllegatoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTAllegatoDaoImpl::findByCodiceImpianto] esecuzione query", ex);
			throw new SigitTAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAllegatoDaoImpl", "findByCodiceImpianto", "esecuzione query", sql.toString());
			LOG.debug("[SigitTAllegatoDaoImpl::findByCodiceImpianto] END");
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
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,CF_REDATTORE,UID_INDEX,F_FIRMA_TECNICO,F_FIRMA_RESPONSABILE,FLG_CONTROLLO_BOZZA,A_POTENZA_TERMICA_NOMINALE_MAX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,DATA_RESPINTA,MOTIVO_RESPINTA,FK_PG_CAT,ABCDF_CONTROLLOWEB,FK_TIPO_MANUTENZIONE,ALTRO_DESCR,FK_ISPEZ_ISPET,DT_INVIO_MEMO,MAIL_INVIO_MEMO,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO FROM "
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

	/** 
		 * Implementazione del finder controlloBollinoAssegnatoAltroImpianto con Qdef
		 * @generated
		 */

	public List<SigitTAllegatoControlloBollinoAssegnatoAltroImpiantoDto> findControlloBollinoAssegnatoAltroImpianto(
			SigitTAllegatoDto input) throws SigitTAllegatoDaoException {
		LOG.debug("[SigitTAllegatoDaoImpl::findControlloBollinoAssegnatoAltroImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT tAllegato.ID_ALLEGATO as idAllegato");

		sql.append(" FROM SIGIT_D_STATO_RAPP dStatoRapp, SIGIT_T_ALLEGATO tAllegato");

		sql.append(" WHERE ");

		sql.append("tAllegato.FK_STATO_RAPP = dStatoRapp.ID_STATO_RAPP");

		sql.append(" AND ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R1308642250) ENABLED START*///inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" AND tAllegato.FK_SIGLA_BOLLINO = :siglaBollino");
		sql.append(" AND dStatoRapp.DES_STATO_RAPP != :desStatoRapp");
		sql.append(" AND  tAllegato.FK_NUMERO_BOLLINO = :numeroBollino");
		if (input.getIdAllegato() != null)
			sql.append(" AND  tAllegato.ID_ALLEGATO != :idAllegato");

		paramMap.addValue("siglaBollino", Constants.SIGLA_BOLLINO_RP);
		paramMap.addValue("desStatoRapp", Constants.DESCRIZIONE_STATO_RAPP_RESPINTO);
		paramMap.addValue("numeroBollino", input.getFkNumeroBollino());
		if (input.getIdAllegato() != null)
			paramMap.addValue("idAllegato", input.getIdAllegato());

		/*PROTECTED REGION END*/

		List<SigitTAllegatoControlloBollinoAssegnatoAltroImpiantoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, controlloBollinoAssegnatoAltroImpiantoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTAllegatoDaoImpl::findControlloBollinoAssegnatoAltroImpianto] ERROR esecuzione query", ex);
			throw new SigitTAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAllegatoDaoImpl", "findControlloBollinoAssegnatoAltroImpianto",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitTAllegatoDaoImpl::findControlloBollinoAssegnatoAltroImpianto] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder rappProvaByIdIspezione con Qdef
		 * @generated
		 */

	public List<SigitTAllegatoRappProvaByIdIspezioneDto> findRappProvaByIdIspezione(java.lang.Integer input)
			throws SigitTAllegatoDaoException {
		LOG.debug("[SigitTAllegatoDaoImpl::findRappProvaByIdIspezione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT alle.DATA_CONTROLLO, alle.ID_ALLEGATO, alle.FK_TIPO_DOCUMENTO, doc.DES_TIPO_DOCUMENTO, sr.DES_STATO_RAPP, alle.F_OSSERVAZIONI, alle.F_RACCOMANDAZIONI, alle.F_PRESCRIZIONI, alle.ELENCO_APPARECCHIATURE, alle.UID_INDEX_FIRMATO");

		sql.append(
				" FROM SIGIT_T_ALLEGATO alle, SIGIT_D_TIPO_DOCUMENTO doc, SIGIT_D_STATO_RAPP sr, SIGIT_R_ISPEZ_ISPET impRuolo, SIGIT_T_ISPEZIONE_2018 isp");

		sql.append(" WHERE ");

		sql.append(
				"alle.FK_TIPO_DOCUMENTO = doc.ID_TIPO_DOCUMENTO AND alle.FK_STATO_RAPP = sr.ID_STATO_RAPP AND impRuolo.ID_ISPEZ_ISPET = alle.FK_ISPEZ_ISPET AND isp.ID_ISPEZIONE_2018 = impRuolo.ID_ISPEZIONE_2018");

		sql.append(" AND ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R-1116280208) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		//trattandosi di rapporti di prova, filtro il tipo documento sulla base del flag flg_visu_elenco_rapprova
		sql.append(" AND doc.flg_visu_elenco_rapprova = 1");

		sql.append(" AND isp.id_ispezione_2018 = :input");
		paramMap.addValue("input", input);

		/*PROTECTED REGION END*/

		List<SigitTAllegatoRappProvaByIdIspezioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, rappProvaByIdIspezioneRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTAllegatoDaoImpl::findRappProvaByIdIspezione] ERROR esecuzione query", ex);
			throw new SigitTAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAllegatoDaoImpl", "findRappProvaByIdIspezione", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTAllegatoDaoImpl::findRappProvaByIdIspezione] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder rappProvaByIdAllegato con Qdef
		 * @generated
		 */

	public List<SigitTAllegatoRappProvaByIdAllegatoDto> findRappProvaByIdAllegato(Integer input)
			throws SigitTAllegatoDaoException {
		LOG.debug("[SigitTAllegatoDaoImpl::findRappProvaByIdAllegato] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT alle.DATA_CONTROLLO, alle.ID_ALLEGATO, isp.ID_ISPEZIONE_2018, isp.CODICE_IMPIANTO, alle.FK_TIPO_DOCUMENTO, alle.F_OSSERVAZIONI, alle.F_RACCOMANDAZIONI, alle.F_PRESCRIZIONI, alle.ELENCO_APPARECCHIATURE, alle.UID_INDEX, alle.UID_INDEX_FIRMATO");

		sql.append(" FROM SIGIT_T_ALLEGATO alle, SIGIT_T_ISPEZIONE_2018 isp, SIGIT_R_ISPEZ_ISPET impRuolo");

		sql.append(" WHERE ");

		sql.append(
				"impRuolo.ID_ISPEZ_ISPET = alle.FK_ISPEZ_ISPET AND isp.ID_ISPEZIONE_2018 = impRuolo.ID_ISPEZIONE_2018");

		sql.append(" AND ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R-1101377795) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" AND alle.ID_ALLEGATO = :input");

		paramMap.addValue("input", input);

		/*PROTECTED REGION END*/

		List<SigitTAllegatoRappProvaByIdAllegatoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, rappProvaByIdAllegatoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTAllegatoDaoImpl::findRappProvaByIdAllegato] ERROR esecuzione query", ex);
			throw new SigitTAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAllegatoDaoImpl", "findRappProvaByIdAllegato", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTAllegatoDaoImpl::findRappProvaByIdAllegato] END");
		}
		return list;
	}

}
