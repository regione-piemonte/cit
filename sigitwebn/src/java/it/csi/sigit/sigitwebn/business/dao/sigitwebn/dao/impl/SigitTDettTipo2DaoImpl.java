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

/*PROTECTED REGION ID(R151755119) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTDettTipo2.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byAllegatoCodImpianto (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - aggiornaDatiComuni (datagen::CustomUpdater)
 * - DELETERS:
 *   - byIdAllegato (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTDettTipo2DaoImpl extends AbstractDAO implements SigitTDettTipo2Dao {
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
	 * Metodo di inserimento del DAO sigitTDettTipo2. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDettTipo2Pk
	 * @generated
	 */

	public SigitTDettTipo2Pk insert(SigitTDettTipo2Dto dto)

	{
		LOG.debug("[SigitTDettTipo2DaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_DETT_TIPO2,FK_ALLEGATO,CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,E_N_CIRCUITO,E_FLG_MOD_PROVA,E_FLG_PERDITA_GAS,E_FLG_LEAK_DETECTOR,E_FLG_PARAM_TERMODINAM,E_FLG_INCROSTAZIONI,E_T_SURRISC_C,E_T_SOTTORAF_C,E_T_CONDENSAZIONE_C,E_T_EVAPORAZIONE_C,E_T_IN_EXT_C,E_T_OUT_EXT_C,E_T_IN_UTENZE_C,E_T_OUT_UTENZE_C,DATA_ULT_MOD,UTENTE_ULT_MOD,L11_2_TORRE_T_OUT_FLUIDO,L11_2_TORRE_T_BULBO_UMIDO,L11_2_SCAMBIATORE_T_IN_EXT,L11_2_SCAMBIATORE_T_OUT_EXT,L11_2_SCAMBIAT_T_IN_MACCHINA,L11_2_SCAMBIAT_T_OUT_MACCHINA,L11_2_POTENZA_ASSORBITA_KW,L11_2_FLG_PULIZIA_FILTRI,L11_2_FLG_VERIFICA_SUPERATA,L11_2_DATA_RIPRISTINO,E_CONTROLLOWEB ) VALUES (  :ID_DETT_TIPO2 , :FK_ALLEGATO , :CODICE_IMPIANTO , :FK_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :E_N_CIRCUITO , :E_FLG_MOD_PROVA , :E_FLG_PERDITA_GAS , :E_FLG_LEAK_DETECTOR , :E_FLG_PARAM_TERMODINAM , :E_FLG_INCROSTAZIONI , :E_T_SURRISC_C , :E_T_SOTTORAF_C , :E_T_CONDENSAZIONE_C , :E_T_EVAPORAZIONE_C , :E_T_IN_EXT_C , :E_T_OUT_EXT_C , :E_T_IN_UTENZE_C , :E_T_OUT_UTENZE_C , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :L11_2_TORRE_T_OUT_FLUIDO , :L11_2_TORRE_T_BULBO_UMIDO , :L11_2_SCAMBIATORE_T_IN_EXT , :L11_2_SCAMBIATORE_T_OUT_EXT , :L11_2_SCAMBIAT_T_IN_MACCHINA , :L11_2_SCAMBIAT_T_OUT_MACCHINA , :L11_2_POTENZA_ASSORBITA_KW , :L11_2_FLG_PULIZIA_FILTRI , :L11_2_FLG_VERIFICA_SUPERATA , :L11_2_DATA_RIPRISTINO , :E_CONTROLLOWEB  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DETT_TIPO2]
		params.addValue("ID_DETT_TIPO2", newKey, java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_ALLEGATO]
		params.addValue("FK_ALLEGATO", dto.getFkAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_COMPONENTE]
		params.addValue("FK_TIPO_COMPONENTE", dto.getFkTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [E_N_CIRCUITO]
		params.addValue("E_N_CIRCUITO", dto.getENCircuito(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_FLG_MOD_PROVA]
		params.addValue("E_FLG_MOD_PROVA", dto.getEFlgModProva(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_FLG_PERDITA_GAS]
		params.addValue("E_FLG_PERDITA_GAS", dto.getEFlgPerditaGas(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_LEAK_DETECTOR]
		params.addValue("E_FLG_LEAK_DETECTOR", dto.getEFlgLeakDetector(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_PARAM_TERMODINAM]
		params.addValue("E_FLG_PARAM_TERMODINAM", dto.getEFlgParamTermodinam(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_INCROSTAZIONI]
		params.addValue("E_FLG_INCROSTAZIONI", dto.getEFlgIncrostazioni(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_T_SURRISC_C]
		params.addValue("E_T_SURRISC_C", dto.getETSurriscC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_T_SOTTORAF_C]
		params.addValue("E_T_SOTTORAF_C", dto.getETSottorafC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_T_CONDENSAZIONE_C]
		params.addValue("E_T_CONDENSAZIONE_C", dto.getETCondensazioneC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_T_EVAPORAZIONE_C]
		params.addValue("E_T_EVAPORAZIONE_C", dto.getETEvaporazioneC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_T_IN_EXT_C]
		params.addValue("E_T_IN_EXT_C", dto.getETInExtC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_T_OUT_EXT_C]
		params.addValue("E_T_OUT_EXT_C", dto.getETOutExtC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_T_IN_UTENZE_C]
		params.addValue("E_T_IN_UTENZE_C", dto.getETInUtenzeC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_T_OUT_UTENZE_C]
		params.addValue("E_T_OUT_UTENZE_C", dto.getETOutUtenzeC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L11_2_TORRE_T_OUT_FLUIDO]
		params.addValue("L11_2_TORRE_T_OUT_FLUIDO", dto.getL112TorreTOutFluido(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_TORRE_T_BULBO_UMIDO]
		params.addValue("L11_2_TORRE_T_BULBO_UMIDO", dto.getL112TorreTBulboUmido(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_SCAMBIATORE_T_IN_EXT]
		params.addValue("L11_2_SCAMBIATORE_T_IN_EXT", dto.getL112ScambiatoreTInExt(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_SCAMBIATORE_T_OUT_EXT]
		params.addValue("L11_2_SCAMBIATORE_T_OUT_EXT", dto.getL112ScambiatoreTOutExt(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_SCAMBIAT_T_IN_MACCHINA]
		params.addValue("L11_2_SCAMBIAT_T_IN_MACCHINA", dto.getL112ScambiatTInMacchina(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_SCAMBIAT_T_OUT_MACCHINA]
		params.addValue("L11_2_SCAMBIAT_T_OUT_MACCHINA", dto.getL112ScambiatTOutMacchina(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_POTENZA_ASSORBITA_KW]
		params.addValue("L11_2_POTENZA_ASSORBITA_KW", dto.getL112PotenzaAssorbitaKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_FLG_PULIZIA_FILTRI]
		params.addValue("L11_2_FLG_PULIZIA_FILTRI", dto.getL112FlgPuliziaFiltri(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_FLG_VERIFICA_SUPERATA]
		params.addValue("L11_2_FLG_VERIFICA_SUPERATA", dto.getL112FlgVerificaSuperata(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_DATA_RIPRISTINO]
		params.addValue("L11_2_DATA_RIPRISTINO", dto.getL112DataRipristino(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [E_CONTROLLOWEB]
		params.addValue("E_CONTROLLOWEB", dto.getEControlloweb(), java.sql.Types.TIMESTAMP);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdDettTipo2(newKey);
		LOG.debug("[SigitTDettTipo2DaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_DETT_TIPO2 table.
	 * @generated
	 */
	public void update(SigitTDettTipo2Dto dto) throws SigitTDettTipo2DaoException {
		LOG.debug("[SigitTDettTipo2DaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_ALLEGATO = :FK_ALLEGATO ,CODICE_IMPIANTO = :CODICE_IMPIANTO ,FK_TIPO_COMPONENTE = :FK_TIPO_COMPONENTE ,PROGRESSIVO = :PROGRESSIVO ,DATA_INSTALL = :DATA_INSTALL ,E_N_CIRCUITO = :E_N_CIRCUITO ,E_FLG_MOD_PROVA = :E_FLG_MOD_PROVA ,E_FLG_PERDITA_GAS = :E_FLG_PERDITA_GAS ,E_FLG_LEAK_DETECTOR = :E_FLG_LEAK_DETECTOR ,E_FLG_PARAM_TERMODINAM = :E_FLG_PARAM_TERMODINAM ,E_FLG_INCROSTAZIONI = :E_FLG_INCROSTAZIONI ,E_T_SURRISC_C = :E_T_SURRISC_C ,E_T_SOTTORAF_C = :E_T_SOTTORAF_C ,E_T_CONDENSAZIONE_C = :E_T_CONDENSAZIONE_C ,E_T_EVAPORAZIONE_C = :E_T_EVAPORAZIONE_C ,E_T_IN_EXT_C = :E_T_IN_EXT_C ,E_T_OUT_EXT_C = :E_T_OUT_EXT_C ,E_T_IN_UTENZE_C = :E_T_IN_UTENZE_C ,E_T_OUT_UTENZE_C = :E_T_OUT_UTENZE_C ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,L11_2_TORRE_T_OUT_FLUIDO = :L11_2_TORRE_T_OUT_FLUIDO ,L11_2_TORRE_T_BULBO_UMIDO = :L11_2_TORRE_T_BULBO_UMIDO ,L11_2_SCAMBIATORE_T_IN_EXT = :L11_2_SCAMBIATORE_T_IN_EXT ,L11_2_SCAMBIATORE_T_OUT_EXT = :L11_2_SCAMBIATORE_T_OUT_EXT ,L11_2_SCAMBIAT_T_IN_MACCHINA = :L11_2_SCAMBIAT_T_IN_MACCHINA ,L11_2_SCAMBIAT_T_OUT_MACCHINA = :L11_2_SCAMBIAT_T_OUT_MACCHINA ,L11_2_POTENZA_ASSORBITA_KW = :L11_2_POTENZA_ASSORBITA_KW ,L11_2_FLG_PULIZIA_FILTRI = :L11_2_FLG_PULIZIA_FILTRI ,L11_2_FLG_VERIFICA_SUPERATA = :L11_2_FLG_VERIFICA_SUPERATA ,L11_2_DATA_RIPRISTINO = :L11_2_DATA_RIPRISTINO ,E_CONTROLLOWEB = :E_CONTROLLOWEB  WHERE ID_DETT_TIPO2 = :ID_DETT_TIPO2 ";

		if (dto.getIdDettTipo2() == null) {
			LOG.error("[SigitTDettTipo2DaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTDettTipo2DaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DETT_TIPO2]
		params.addValue("ID_DETT_TIPO2", dto.getIdDettTipo2(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_ALLEGATO]
		params.addValue("FK_ALLEGATO", dto.getFkAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_TIPO_COMPONENTE]
		params.addValue("FK_TIPO_COMPONENTE", dto.getFkTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [E_N_CIRCUITO]
		params.addValue("E_N_CIRCUITO", dto.getENCircuito(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_FLG_MOD_PROVA]
		params.addValue("E_FLG_MOD_PROVA", dto.getEFlgModProva(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_FLG_PERDITA_GAS]
		params.addValue("E_FLG_PERDITA_GAS", dto.getEFlgPerditaGas(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_LEAK_DETECTOR]
		params.addValue("E_FLG_LEAK_DETECTOR", dto.getEFlgLeakDetector(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_PARAM_TERMODINAM]
		params.addValue("E_FLG_PARAM_TERMODINAM", dto.getEFlgParamTermodinam(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_INCROSTAZIONI]
		params.addValue("E_FLG_INCROSTAZIONI", dto.getEFlgIncrostazioni(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_T_SURRISC_C]
		params.addValue("E_T_SURRISC_C", dto.getETSurriscC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_T_SOTTORAF_C]
		params.addValue("E_T_SOTTORAF_C", dto.getETSottorafC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_T_CONDENSAZIONE_C]
		params.addValue("E_T_CONDENSAZIONE_C", dto.getETCondensazioneC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_T_EVAPORAZIONE_C]
		params.addValue("E_T_EVAPORAZIONE_C", dto.getETEvaporazioneC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_T_IN_EXT_C]
		params.addValue("E_T_IN_EXT_C", dto.getETInExtC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_T_OUT_EXT_C]
		params.addValue("E_T_OUT_EXT_C", dto.getETOutExtC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_T_IN_UTENZE_C]
		params.addValue("E_T_IN_UTENZE_C", dto.getETInUtenzeC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_T_OUT_UTENZE_C]
		params.addValue("E_T_OUT_UTENZE_C", dto.getETOutUtenzeC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L11_2_TORRE_T_OUT_FLUIDO]
		params.addValue("L11_2_TORRE_T_OUT_FLUIDO", dto.getL112TorreTOutFluido(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_TORRE_T_BULBO_UMIDO]
		params.addValue("L11_2_TORRE_T_BULBO_UMIDO", dto.getL112TorreTBulboUmido(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_SCAMBIATORE_T_IN_EXT]
		params.addValue("L11_2_SCAMBIATORE_T_IN_EXT", dto.getL112ScambiatoreTInExt(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_SCAMBIATORE_T_OUT_EXT]
		params.addValue("L11_2_SCAMBIATORE_T_OUT_EXT", dto.getL112ScambiatoreTOutExt(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_SCAMBIAT_T_IN_MACCHINA]
		params.addValue("L11_2_SCAMBIAT_T_IN_MACCHINA", dto.getL112ScambiatTInMacchina(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_SCAMBIAT_T_OUT_MACCHINA]
		params.addValue("L11_2_SCAMBIAT_T_OUT_MACCHINA", dto.getL112ScambiatTOutMacchina(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_POTENZA_ASSORBITA_KW]
		params.addValue("L11_2_POTENZA_ASSORBITA_KW", dto.getL112PotenzaAssorbitaKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_FLG_PULIZIA_FILTRI]
		params.addValue("L11_2_FLG_PULIZIA_FILTRI", dto.getL112FlgPuliziaFiltri(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_FLG_VERIFICA_SUPERATA]
		params.addValue("L11_2_FLG_VERIFICA_SUPERATA", dto.getL112FlgVerificaSuperata(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_2_DATA_RIPRISTINO]
		params.addValue("L11_2_DATA_RIPRISTINO", dto.getL112DataRipristino(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [E_CONTROLLOWEB]
		params.addValue("E_CONTROLLOWEB", dto.getEControlloweb(), java.sql.Types.TIMESTAMP);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDettTipo2DaoImpl::update] END");
	}

	/** 
	 * Custom updater in the SIGIT_T_DETT_TIPO2 table.
	 * @generated
	 */
	public void customUpdaterAggiornaDatiComuni(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettTipo2Dto filter, java.lang.Object value)
			throws SigitTDettTipo2DaoException {
		LOG.debug("[SigitTDettTipo2DaoImpl::customUpdaterAggiornaDatiComuni] START");
		/*PROTECTED REGION ID(R2023370078) ENABLED START*/
		//***scrivere la custom query
		final StringBuffer sql = new StringBuffer("UPDATE " + getTableName());
		sql.append(
				" SET E_FLG_MOD_PROVA = :E_FLG_MOD_PROVA ,E_FLG_PERDITA_GAS = :E_FLG_PERDITA_GAS ,E_FLG_LEAK_DETECTOR = :E_FLG_LEAK_DETECTOR , E_FLG_PARAM_TERMODINAM = :E_FLG_PARAM_TERMODINAM ,E_FLG_INCROSTAZIONI = :E_FLG_INCROSTAZIONI , DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ");
		sql.append(" WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ");
		sql.append(" AND FK_ALLEGATO = :FK_ALLEGATO ");
		sql.append(" AND PROGRESSIVO = :PROGRESSIVO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", filter.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [E_N_CIRCUITO]
		params.addValue("E_N_CIRCUITO", filter.getENCircuito(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_FLG_MOD_PROVA]
		params.addValue("E_FLG_MOD_PROVA", filter.getEFlgModProva(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_FLG_PERDITA_GAS]
		params.addValue("E_FLG_PERDITA_GAS", filter.getEFlgPerditaGas(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_LEAK_DETECTOR]
		params.addValue("E_FLG_LEAK_DETECTOR", filter.getEFlgLeakDetector(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_PARAM_TERMODINAM]
		params.addValue("E_FLG_PARAM_TERMODINAM", filter.getEFlgParamTermodinam(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_INCROSTAZIONI]
		params.addValue("E_FLG_INCROSTAZIONI", filter.getEFlgIncrostazioni(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", filter.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", filter.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", filter.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_ALLEGATO]
		params.addValue("FK_ALLEGATO", filter.getFkAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", filter.getProgressivo(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDettTipo2DaoImpl::customUpdaterAggiornaDatiComuni] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_DETT_TIPO2 table.
	 * @generated
	 */
	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitTDettTipo2DaoException {
		LOG.debug("[SigitTDettTipo2DaoImpl::customDeleterByIdAllegato] START");
		/*PROTECTED REGION ID(R-483637516) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE FK_ALLEGATO = :idAllegato";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idAllegato", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDettTipo2DaoImpl::customDeleterByIdAllegato] END");
	}

	protected SigitTDettTipo2DaoRowMapper findAllRowMapper = new SigitTDettTipo2DaoRowMapper(null,
			SigitTDettTipo2Dto.class, this);

	protected SigitTDettTipo2DaoRowMapper findByPrimaryKeyRowMapper = new SigitTDettTipo2DaoRowMapper(null,
			SigitTDettTipo2Dto.class, this);

	protected SigitTDettTipo2DaoRowMapper byAllegatoCodImpiantoRowMapper = new SigitTDettTipo2DaoRowMapper(null,
			SigitTDettTipo2Dto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DETT_TIPO2";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_DETT_TIPO2.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettTipo2Dto> findAll() throws SigitTDettTipo2DaoException {
		LOG.debug("[SigitTDettTipo2DaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_DETT_TIPO2,FK_ALLEGATO,CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,E_N_CIRCUITO,E_FLG_MOD_PROVA,E_FLG_PERDITA_GAS,E_FLG_LEAK_DETECTOR,E_FLG_PARAM_TERMODINAM,E_FLG_INCROSTAZIONI,E_T_SURRISC_C,E_T_SOTTORAF_C,E_T_CONDENSAZIONE_C,E_T_EVAPORAZIONE_C,E_T_IN_EXT_C,E_T_OUT_EXT_C,E_T_IN_UTENZE_C,E_T_OUT_UTENZE_C,DATA_ULT_MOD,UTENTE_ULT_MOD,L11_2_TORRE_T_OUT_FLUIDO,L11_2_TORRE_T_BULBO_UMIDO,L11_2_SCAMBIATORE_T_IN_EXT,L11_2_SCAMBIATORE_T_OUT_EXT,L11_2_SCAMBIAT_T_IN_MACCHINA,L11_2_SCAMBIAT_T_OUT_MACCHINA,L11_2_POTENZA_ASSORBITA_KW,L11_2_FLG_PULIZIA_FILTRI,L11_2_FLG_VERIFICA_SUPERATA,L11_2_DATA_RIPRISTINO,E_CONTROLLOWEB FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTDettTipo2Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTDettTipo2DaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitTDettTipo2DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDettTipo2DaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDettTipo2DaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_T_DETT_TIPO2 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTDettTipo2Dto findByPrimaryKey(SigitTDettTipo2Pk pk) throws SigitTDettTipo2DaoException {
		LOG.debug("[SigitTDettTipo2DaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_DETT_TIPO2,FK_ALLEGATO,CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,E_N_CIRCUITO,E_FLG_MOD_PROVA,E_FLG_PERDITA_GAS,E_FLG_LEAK_DETECTOR,E_FLG_PARAM_TERMODINAM,E_FLG_INCROSTAZIONI,E_T_SURRISC_C,E_T_SOTTORAF_C,E_T_CONDENSAZIONE_C,E_T_EVAPORAZIONE_C,E_T_IN_EXT_C,E_T_OUT_EXT_C,E_T_IN_UTENZE_C,E_T_OUT_UTENZE_C,DATA_ULT_MOD,UTENTE_ULT_MOD,L11_2_TORRE_T_OUT_FLUIDO,L11_2_TORRE_T_BULBO_UMIDO,L11_2_SCAMBIATORE_T_IN_EXT,L11_2_SCAMBIATORE_T_OUT_EXT,L11_2_SCAMBIAT_T_IN_MACCHINA,L11_2_SCAMBIAT_T_OUT_MACCHINA,L11_2_POTENZA_ASSORBITA_KW,L11_2_FLG_PULIZIA_FILTRI,L11_2_FLG_VERIFICA_SUPERATA,L11_2_DATA_RIPRISTINO,E_CONTROLLOWEB FROM "
						+ getTableName() + " WHERE ID_DETT_TIPO2 = :ID_DETT_TIPO2 ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DETT_TIPO2]
		params.addValue("ID_DETT_TIPO2", pk.getIdDettTipo2(), java.sql.Types.NUMERIC);

		List<SigitTDettTipo2Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTDettTipo2DaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTDettTipo2DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDettTipo2DaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDettTipo2DaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byAllegatoCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettTipo2Dto> findByAllegatoCodImpianto(SigitTDettTipo2Dto input)
			throws SigitTDettTipo2DaoException {
		LOG.debug("[SigitTDettTipo2DaoImpl::findByAllegatoCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_DETT_TIPO2,FK_ALLEGATO,CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,E_N_CIRCUITO,E_FLG_MOD_PROVA,E_FLG_PERDITA_GAS,E_FLG_LEAK_DETECTOR,E_FLG_PARAM_TERMODINAM,E_FLG_INCROSTAZIONI,E_T_SURRISC_C,E_T_SOTTORAF_C,E_T_CONDENSAZIONE_C,E_T_EVAPORAZIONE_C,E_T_IN_EXT_C,E_T_OUT_EXT_C,E_T_IN_UTENZE_C,E_T_OUT_UTENZE_C,DATA_ULT_MOD,UTENTE_ULT_MOD,L11_2_TORRE_T_OUT_FLUIDO,L11_2_TORRE_T_BULBO_UMIDO,L11_2_SCAMBIATORE_T_IN_EXT,L11_2_SCAMBIATORE_T_OUT_EXT,L11_2_SCAMBIAT_T_IN_MACCHINA,L11_2_SCAMBIAT_T_OUT_MACCHINA,L11_2_POTENZA_ASSORBITA_KW,L11_2_FLG_PULIZIA_FILTRI,L11_2_FLG_VERIFICA_SUPERATA,L11_2_DATA_RIPRISTINO,E_CONTROLLOWEB ");
		sql.append(" FROM SIGIT_T_DETT_TIPO2");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R304545232) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" 1 = 1 ");
		if (input.getFkAllegato() != null) {
			sql.append(" AND  FK_ALLEGATO = :idAllegato ");
		}
		if (input.getCodiceImpianto() != null) {
			sql.append(" AND  CODICE_IMPIANTO = :idCodiceImpianto ");
		}

		if (input.getProgressivo() != null) {
			sql.append(" AND PROGRESSIVO = :progressivo ");
		}

		if (input.getENCircuito() != null) {
			sql.append(" AND E_N_CIRCUITO = :numCircuito ");
		}

		sql.append(" ORDER BY PROGRESSIVO, TO_NUMBER(E_N_CIRCUITO) ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1731531378) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input.getFkAllegato() != null) {
			paramMap.addValue("idAllegato", input.getFkAllegato());
		}
		if (input.getCodiceImpianto() != null) {
			paramMap.addValue("idCodiceImpianto", input.getCodiceImpianto());
		}

		if (input.getProgressivo() != null) {
			paramMap.addValue("progressivo", input.getProgressivo());
		}

		if (input.getENCircuito() != null) {
			paramMap.addValue("numCircuito", input.getENCircuito());
		}

		/*PROTECTED REGION END*/
		List<SigitTDettTipo2Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAllegatoCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTDettTipo2DaoImpl::findByAllegatoCodImpianto] esecuzione query", ex);
			throw new SigitTDettTipo2DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDettTipo2DaoImpl", "findByAllegatoCodImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTDettTipo2DaoImpl::findByAllegatoCodImpianto] END");
		}
		return list;
	}

}
