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

/*PROTECTED REGION ID(R-873736881) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTDettTipo1.
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
public class SigitTDettTipo1DaoImpl extends AbstractDAO implements SigitTDettTipo1Dao {
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
	 * Metodo di inserimento del DAO sigitTDettTipo1. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDettTipo1Pk
	 * @generated
	 */

	public SigitTDettTipo1Pk insert(SigitTDettTipo1Dto dto)

	{
		LOG.debug("[SigitTDettTipo1DaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_DETT_TIPO1,FK_ALLEGATO,CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,E_N_MODULO_TERMICO,E_POT_TERM_FOCOL_KW,E_FLG_CLIMA_INVERNO,E_FLG_PRODUZ_ACS,E_FLG_DISPOS_COMANDO,E_FLG_DISPOS_SICUREZZA,E_FLG_VALVOLA_SICUREZZA,E_FLG_SCAMBIATORE_FUMI,E_FLG_RIFLUSSO,E_FLG_UNI_10389_1,E_FLG_EVACU_FUMI,E_DEPR_CANALE_FUMO_PA,E_TEMP_FUMI_C,E_TEMP_ARIA_C,E_O2_PERC,E_CO2_PERC,E_CO_CORRETTO_PPM,E_REND_COMB_PERC,E_REND_MIN_LEGGE_PERC,E_NOX_PPM,DATA_ULT_MOD,UTENTE_ULT_MOD,L11_1_PORTATA_COMBUSTIBILE,L11_1_CO_NO_ARIA_PPM,L11_1_FLG_RISPETTA_BACHARACH,L11_1_FLG_CO_MIN_1000,L11_1_FLG_REND_MAG_REND_MIN,L11_1_PORTATA_COMBUSTIBILE_UM,L11_1_ALTRO_RIFERIMENTO,E_BACHARACH_MIN,E_BACHARACH_MED,E_BACHARACH_MAX,E_CONTROLLOWEB,E_NOX_MG_KWH,E_1B_FLG_CUCINA,E_1B_FLG_UNI_10389_2,E_1B_PARTICOLATO_MG_AL_M3,E_NOX_MG_NM3 ) VALUES (  :ID_DETT_TIPO1 , :FK_ALLEGATO , :CODICE_IMPIANTO , :FK_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :E_N_MODULO_TERMICO , :E_POT_TERM_FOCOL_KW , :E_FLG_CLIMA_INVERNO , :E_FLG_PRODUZ_ACS , :E_FLG_DISPOS_COMANDO , :E_FLG_DISPOS_SICUREZZA , :E_FLG_VALVOLA_SICUREZZA , :E_FLG_SCAMBIATORE_FUMI , :E_FLG_RIFLUSSO , :E_FLG_UNI_10389_1 , :E_FLG_EVACU_FUMI , :E_DEPR_CANALE_FUMO_PA , :E_TEMP_FUMI_C , :E_TEMP_ARIA_C , :E_O2_PERC , :E_CO2_PERC , :E_CO_CORRETTO_PPM , :E_REND_COMB_PERC , :E_REND_MIN_LEGGE_PERC , :E_NOX_PPM , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :L11_1_PORTATA_COMBUSTIBILE , :L11_1_CO_NO_ARIA_PPM , :L11_1_FLG_RISPETTA_BACHARACH , :L11_1_FLG_CO_MIN_1000 , :L11_1_FLG_REND_MAG_REND_MIN , :L11_1_PORTATA_COMBUSTIBILE_UM , :L11_1_ALTRO_RIFERIMENTO , :E_BACHARACH_MIN , :E_BACHARACH_MED , :E_BACHARACH_MAX , :E_CONTROLLOWEB , :E_NOX_MG_KWH , :E_1B_FLG_CUCINA , :E_1B_FLG_UNI_10389_2 , :E_1B_PARTICOLATO_MG_AL_M3 , :E_NOX_MG_NM3  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DETT_TIPO1]
		params.addValue("ID_DETT_TIPO1", newKey, java.sql.Types.NUMERIC);

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

		// valorizzazione paametro relativo a colonna [E_N_MODULO_TERMICO]
		params.addValue("E_N_MODULO_TERMICO", dto.getENModuloTermico(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [E_POT_TERM_FOCOL_KW]
		params.addValue("E_POT_TERM_FOCOL_KW", dto.getEPotTermFocolKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_CLIMA_INVERNO]
		params.addValue("E_FLG_CLIMA_INVERNO", dto.getEFlgClimaInverno(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_PRODUZ_ACS]
		params.addValue("E_FLG_PRODUZ_ACS", dto.getEFlgProduzAcs(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_DISPOS_COMANDO]
		params.addValue("E_FLG_DISPOS_COMANDO", dto.getEFlgDisposComando(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_DISPOS_SICUREZZA]
		params.addValue("E_FLG_DISPOS_SICUREZZA", dto.getEFlgDisposSicurezza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_VALVOLA_SICUREZZA]
		params.addValue("E_FLG_VALVOLA_SICUREZZA", dto.getEFlgValvolaSicurezza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_SCAMBIATORE_FUMI]
		params.addValue("E_FLG_SCAMBIATORE_FUMI", dto.getEFlgScambiatoreFumi(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_RIFLUSSO]
		params.addValue("E_FLG_RIFLUSSO", dto.getEFlgRiflusso(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_UNI_10389_1]
		params.addValue("E_FLG_UNI_10389_1", dto.getEFlgUni103891(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_EVACU_FUMI]
		params.addValue("E_FLG_EVACU_FUMI", dto.getEFlgEvacuFumi(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_DEPR_CANALE_FUMO_PA]
		params.addValue("E_DEPR_CANALE_FUMO_PA", dto.getEDeprCanaleFumoPa(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_FUMI_C]
		params.addValue("E_TEMP_FUMI_C", dto.getETempFumiC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_ARIA_C]
		params.addValue("E_TEMP_ARIA_C", dto.getETempAriaC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_O2_PERC]
		params.addValue("E_O2_PERC", dto.getEO2Perc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_CO2_PERC]
		params.addValue("E_CO2_PERC", dto.getECo2Perc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_CO_CORRETTO_PPM]
		params.addValue("E_CO_CORRETTO_PPM", dto.getECoCorrettoPpm(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_REND_COMB_PERC]
		params.addValue("E_REND_COMB_PERC", dto.getERendCombPerc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_REND_MIN_LEGGE_PERC]
		params.addValue("E_REND_MIN_LEGGE_PERC", dto.getERendMinLeggePerc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_NOX_PPM]
		params.addValue("E_NOX_PPM", dto.getENoxPpm(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L11_1_PORTATA_COMBUSTIBILE]
		params.addValue("L11_1_PORTATA_COMBUSTIBILE", dto.getL111PortataCombustibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_1_CO_NO_ARIA_PPM]
		params.addValue("L11_1_CO_NO_ARIA_PPM", dto.getL111CoNoAriaPpm(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_1_FLG_RISPETTA_BACHARACH]
		params.addValue("L11_1_FLG_RISPETTA_BACHARACH", dto.getL111FlgRispettaBacharach(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_1_FLG_CO_MIN_1000]
		params.addValue("L11_1_FLG_CO_MIN_1000", dto.getL111FlgCoMin1000(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_1_FLG_REND_MAG_REND_MIN]
		params.addValue("L11_1_FLG_REND_MAG_REND_MIN", dto.getL111FlgRendMagRendMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_1_PORTATA_COMBUSTIBILE_UM]
		params.addValue("L11_1_PORTATA_COMBUSTIBILE_UM", dto.getL111PortataCombustibileUm(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L11_1_ALTRO_RIFERIMENTO]
		params.addValue("L11_1_ALTRO_RIFERIMENTO", dto.getL111AltroRiferimento(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_BACHARACH_MIN]
		params.addValue("E_BACHARACH_MIN", dto.getEBacharachMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_BACHARACH_MED]
		params.addValue("E_BACHARACH_MED", dto.getEBacharachMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_BACHARACH_MAX]
		params.addValue("E_BACHARACH_MAX", dto.getEBacharachMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_CONTROLLOWEB]
		params.addValue("E_CONTROLLOWEB", dto.getEControlloweb(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [E_NOX_MG_KWH]
		params.addValue("E_NOX_MG_KWH", dto.getENoxMgKwh(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_CUCINA]
		params.addValue("E_1B_FLG_CUCINA", dto.getE1bFlgCucina(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_UNI_10389_2]
		params.addValue("E_1B_FLG_UNI_10389_2", dto.getE1bFlgUni103892(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_PARTICOLATO_MG_AL_M3]
		params.addValue("E_1B_PARTICOLATO_MG_AL_M3", dto.getE1bParticolatoMgAlM3(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_NOX_MG_NM3]
		params.addValue("E_NOX_MG_NM3", dto.getENoxMgNm3(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdDettTipo1(newKey);
		LOG.debug("[SigitTDettTipo1DaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_DETT_TIPO1 table.
	 * @generated
	 */
	public void update(SigitTDettTipo1Dto dto) throws SigitTDettTipo1DaoException {
		LOG.debug("[SigitTDettTipo1DaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_ALLEGATO = :FK_ALLEGATO ,CODICE_IMPIANTO = :CODICE_IMPIANTO ,FK_TIPO_COMPONENTE = :FK_TIPO_COMPONENTE ,PROGRESSIVO = :PROGRESSIVO ,DATA_INSTALL = :DATA_INSTALL ,E_N_MODULO_TERMICO = :E_N_MODULO_TERMICO ,E_POT_TERM_FOCOL_KW = :E_POT_TERM_FOCOL_KW ,E_FLG_CLIMA_INVERNO = :E_FLG_CLIMA_INVERNO ,E_FLG_PRODUZ_ACS = :E_FLG_PRODUZ_ACS ,E_FLG_DISPOS_COMANDO = :E_FLG_DISPOS_COMANDO ,E_FLG_DISPOS_SICUREZZA = :E_FLG_DISPOS_SICUREZZA ,E_FLG_VALVOLA_SICUREZZA = :E_FLG_VALVOLA_SICUREZZA ,E_FLG_SCAMBIATORE_FUMI = :E_FLG_SCAMBIATORE_FUMI ,E_FLG_RIFLUSSO = :E_FLG_RIFLUSSO ,E_FLG_UNI_10389_1 = :E_FLG_UNI_10389_1 ,E_FLG_EVACU_FUMI = :E_FLG_EVACU_FUMI ,E_DEPR_CANALE_FUMO_PA = :E_DEPR_CANALE_FUMO_PA ,E_TEMP_FUMI_C = :E_TEMP_FUMI_C ,E_TEMP_ARIA_C = :E_TEMP_ARIA_C ,E_O2_PERC = :E_O2_PERC ,E_CO2_PERC = :E_CO2_PERC ,E_CO_CORRETTO_PPM = :E_CO_CORRETTO_PPM ,E_REND_COMB_PERC = :E_REND_COMB_PERC ,E_REND_MIN_LEGGE_PERC = :E_REND_MIN_LEGGE_PERC ,E_NOX_PPM = :E_NOX_PPM ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,L11_1_PORTATA_COMBUSTIBILE = :L11_1_PORTATA_COMBUSTIBILE ,L11_1_CO_NO_ARIA_PPM = :L11_1_CO_NO_ARIA_PPM ,L11_1_FLG_RISPETTA_BACHARACH = :L11_1_FLG_RISPETTA_BACHARACH ,L11_1_FLG_CO_MIN_1000 = :L11_1_FLG_CO_MIN_1000 ,L11_1_FLG_REND_MAG_REND_MIN = :L11_1_FLG_REND_MAG_REND_MIN ,L11_1_PORTATA_COMBUSTIBILE_UM = :L11_1_PORTATA_COMBUSTIBILE_UM ,L11_1_ALTRO_RIFERIMENTO = :L11_1_ALTRO_RIFERIMENTO ,E_BACHARACH_MIN = :E_BACHARACH_MIN ,E_BACHARACH_MED = :E_BACHARACH_MED ,E_BACHARACH_MAX = :E_BACHARACH_MAX ,E_CONTROLLOWEB = :E_CONTROLLOWEB ,E_NOX_MG_KWH = :E_NOX_MG_KWH ,E_1B_FLG_CUCINA = :E_1B_FLG_CUCINA ,E_1B_FLG_UNI_10389_2 = :E_1B_FLG_UNI_10389_2 ,E_1B_PARTICOLATO_MG_AL_M3 = :E_1B_PARTICOLATO_MG_AL_M3 ,E_NOX_MG_NM3 = :E_NOX_MG_NM3  WHERE ID_DETT_TIPO1 = :ID_DETT_TIPO1 ";

		if (dto.getIdDettTipo1() == null) {
			LOG.error("[SigitTDettTipo1DaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTDettTipo1DaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DETT_TIPO1]
		params.addValue("ID_DETT_TIPO1", dto.getIdDettTipo1(), java.sql.Types.NUMERIC);

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

		// valorizzazione paametro relativo a colonna [E_N_MODULO_TERMICO]
		params.addValue("E_N_MODULO_TERMICO", dto.getENModuloTermico(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [E_POT_TERM_FOCOL_KW]
		params.addValue("E_POT_TERM_FOCOL_KW", dto.getEPotTermFocolKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_CLIMA_INVERNO]
		params.addValue("E_FLG_CLIMA_INVERNO", dto.getEFlgClimaInverno(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_PRODUZ_ACS]
		params.addValue("E_FLG_PRODUZ_ACS", dto.getEFlgProduzAcs(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_DISPOS_COMANDO]
		params.addValue("E_FLG_DISPOS_COMANDO", dto.getEFlgDisposComando(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_DISPOS_SICUREZZA]
		params.addValue("E_FLG_DISPOS_SICUREZZA", dto.getEFlgDisposSicurezza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_VALVOLA_SICUREZZA]
		params.addValue("E_FLG_VALVOLA_SICUREZZA", dto.getEFlgValvolaSicurezza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_SCAMBIATORE_FUMI]
		params.addValue("E_FLG_SCAMBIATORE_FUMI", dto.getEFlgScambiatoreFumi(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_RIFLUSSO]
		params.addValue("E_FLG_RIFLUSSO", dto.getEFlgRiflusso(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_UNI_10389_1]
		params.addValue("E_FLG_UNI_10389_1", dto.getEFlgUni103891(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_EVACU_FUMI]
		params.addValue("E_FLG_EVACU_FUMI", dto.getEFlgEvacuFumi(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_DEPR_CANALE_FUMO_PA]
		params.addValue("E_DEPR_CANALE_FUMO_PA", dto.getEDeprCanaleFumoPa(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_FUMI_C]
		params.addValue("E_TEMP_FUMI_C", dto.getETempFumiC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_ARIA_C]
		params.addValue("E_TEMP_ARIA_C", dto.getETempAriaC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_O2_PERC]
		params.addValue("E_O2_PERC", dto.getEO2Perc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_CO2_PERC]
		params.addValue("E_CO2_PERC", dto.getECo2Perc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_CO_CORRETTO_PPM]
		params.addValue("E_CO_CORRETTO_PPM", dto.getECoCorrettoPpm(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_REND_COMB_PERC]
		params.addValue("E_REND_COMB_PERC", dto.getERendCombPerc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_REND_MIN_LEGGE_PERC]
		params.addValue("E_REND_MIN_LEGGE_PERC", dto.getERendMinLeggePerc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_NOX_PPM]
		params.addValue("E_NOX_PPM", dto.getENoxPpm(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L11_1_PORTATA_COMBUSTIBILE]
		params.addValue("L11_1_PORTATA_COMBUSTIBILE", dto.getL111PortataCombustibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_1_CO_NO_ARIA_PPM]
		params.addValue("L11_1_CO_NO_ARIA_PPM", dto.getL111CoNoAriaPpm(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_1_FLG_RISPETTA_BACHARACH]
		params.addValue("L11_1_FLG_RISPETTA_BACHARACH", dto.getL111FlgRispettaBacharach(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_1_FLG_CO_MIN_1000]
		params.addValue("L11_1_FLG_CO_MIN_1000", dto.getL111FlgCoMin1000(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_1_FLG_REND_MAG_REND_MIN]
		params.addValue("L11_1_FLG_REND_MAG_REND_MIN", dto.getL111FlgRendMagRendMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_1_PORTATA_COMBUSTIBILE_UM]
		params.addValue("L11_1_PORTATA_COMBUSTIBILE_UM", dto.getL111PortataCombustibileUm(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L11_1_ALTRO_RIFERIMENTO]
		params.addValue("L11_1_ALTRO_RIFERIMENTO", dto.getL111AltroRiferimento(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_BACHARACH_MIN]
		params.addValue("E_BACHARACH_MIN", dto.getEBacharachMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_BACHARACH_MED]
		params.addValue("E_BACHARACH_MED", dto.getEBacharachMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_BACHARACH_MAX]
		params.addValue("E_BACHARACH_MAX", dto.getEBacharachMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_CONTROLLOWEB]
		params.addValue("E_CONTROLLOWEB", dto.getEControlloweb(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [E_NOX_MG_KWH]
		params.addValue("E_NOX_MG_KWH", dto.getENoxMgKwh(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_CUCINA]
		params.addValue("E_1B_FLG_CUCINA", dto.getE1bFlgCucina(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_UNI_10389_2]
		params.addValue("E_1B_FLG_UNI_10389_2", dto.getE1bFlgUni103892(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_PARTICOLATO_MG_AL_M3]
		params.addValue("E_1B_PARTICOLATO_MG_AL_M3", dto.getE1bParticolatoMgAlM3(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_NOX_MG_NM3]
		params.addValue("E_NOX_MG_NM3", dto.getENoxMgNm3(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDettTipo1DaoImpl::update] END");
	}

	/** 
	 * Custom updater in the SIGIT_T_DETT_TIPO1 table.
	 * @generated
	 */
	public void customUpdaterAggiornaDatiComuni(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettTipo1Dto filter, java.lang.Object value)
			throws SigitTDettTipo1DaoException {
		LOG.debug("[SigitTDettTipo1DaoImpl::customUpdaterAggiornaDatiComuni] START");
		/*PROTECTED REGION ID(R1053789055) ENABLED START*/
		//***scrivere la custom query

		final StringBuffer sql = new StringBuffer("UPDATE " + getTableName());
		sql.append(
				" SET E_POT_TERM_FOCOL_KW = :E_POT_TERM_FOCOL_KW ,E_FLG_CLIMA_INVERNO = :E_FLG_CLIMA_INVERNO ,E_FLG_PRODUZ_ACS = :E_FLG_PRODUZ_ACS ,E_1B_FLG_CUCINA = :E_1B_FLG_CUCINA ,E_FLG_EVACU_FUMI = :E_FLG_EVACU_FUMI ,E_DEPR_CANALE_FUMO_PA = :E_DEPR_CANALE_FUMO_PA ,E_FLG_DISPOS_COMANDO = :E_FLG_DISPOS_COMANDO ,E_FLG_DISPOS_SICUREZZA = :E_FLG_DISPOS_SICUREZZA ,E_FLG_VALVOLA_SICUREZZA = :E_FLG_VALVOLA_SICUREZZA ,E_FLG_SCAMBIATORE_FUMI = :E_FLG_SCAMBIATORE_FUMI ,E_FLG_RIFLUSSO = :E_FLG_RIFLUSSO ,E_FLG_UNI_10389_1 = :E_FLG_UNI_10389_1 , E_1B_FLG_UNI_10389_2 = :E_1B_FLG_UNI_10389_2, L11_1_ALTRO_RIFERIMENTO = :L11_1_ALTRO_RIFERIMENTO ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD  ");
		sql.append(" WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ");
		sql.append(" AND FK_ALLEGATO = :FK_ALLEGATO ");
		sql.append(" AND PROGRESSIVO = :PROGRESSIVO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [E_POT_TERM_FOCOL_KW]
		params.addValue("E_POT_TERM_FOCOL_KW", filter.getEPotTermFocolKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_CLIMA_INVERNO]
		params.addValue("E_FLG_CLIMA_INVERNO", filter.getEFlgClimaInverno(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_PRODUZ_ACS]
		params.addValue("E_FLG_PRODUZ_ACS", filter.getEFlgProduzAcs(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_CUCINA]
		params.addValue("E_1B_FLG_CUCINA", filter.getE1bFlgCucina(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_EVACU_FUMI]
		params.addValue("E_FLG_EVACU_FUMI", filter.getEFlgEvacuFumi(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [E_DEPR_CANALE_FUMO_PA]
		params.addValue("E_DEPR_CANALE_FUMO_PA", filter.getEDeprCanaleFumoPa(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_DISPOS_COMANDO]
		params.addValue("E_FLG_DISPOS_COMANDO", filter.getEFlgDisposComando(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_DISPOS_SICUREZZA]
		params.addValue("E_FLG_DISPOS_SICUREZZA", filter.getEFlgDisposSicurezza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_VALVOLA_SICUREZZA]
		params.addValue("E_FLG_VALVOLA_SICUREZZA", filter.getEFlgValvolaSicurezza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_SCAMBIATORE_FUMI]
		params.addValue("E_FLG_SCAMBIATORE_FUMI", filter.getEFlgScambiatoreFumi(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_RIFLUSSO]
		params.addValue("E_FLG_RIFLUSSO", filter.getEFlgRiflusso(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_FLG_UNI_10389_1]
		params.addValue("E_FLG_UNI_10389_1", filter.getEFlgUni103891(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_UNI_10389_2]
		params.addValue("E_1B_FLG_UNI_10389_2", filter.getE1bFlgUni103892(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_1_ALTRO_RIFERIMENTO]
		params.addValue("L11_1_ALTRO_RIFERIMENTO", filter.getL111AltroRiferimento(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", filter.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", filter.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_ALLEGATO]
		params.addValue("FK_ALLEGATO", filter.getFkAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", filter.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", filter.getProgressivo(), java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDettTipo1DaoImpl::customUpdaterAggiornaDatiComuni] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_DETT_TIPO1 table.
	 * @generated
	 */
	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitTDettTipo1DaoException {
		LOG.debug("[SigitTDettTipo1DaoImpl::customDeleterByIdAllegato] START");
		/*PROTECTED REGION ID(R-607710763) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE FK_ALLEGATO = :idAllegato";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idAllegato", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDettTipo1DaoImpl::customDeleterByIdAllegato] END");
	}

	protected SigitTDettTipo1DaoRowMapper findAllRowMapper = new SigitTDettTipo1DaoRowMapper(null,
			SigitTDettTipo1Dto.class, this);

	protected SigitTDettTipo1DaoRowMapper findByPrimaryKeyRowMapper = new SigitTDettTipo1DaoRowMapper(null,
			SigitTDettTipo1Dto.class, this);

	protected SigitTDettTipo1DaoRowMapper byAllegatoCodImpiantoRowMapper = new SigitTDettTipo1DaoRowMapper(null,
			SigitTDettTipo1Dto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DETT_TIPO1";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_DETT_TIPO1.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettTipo1Dto> findAll() throws SigitTDettTipo1DaoException {
		LOG.debug("[SigitTDettTipo1DaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_DETT_TIPO1,FK_ALLEGATO,CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,E_N_MODULO_TERMICO,E_POT_TERM_FOCOL_KW,E_FLG_CLIMA_INVERNO,E_FLG_PRODUZ_ACS,E_FLG_DISPOS_COMANDO,E_FLG_DISPOS_SICUREZZA,E_FLG_VALVOLA_SICUREZZA,E_FLG_SCAMBIATORE_FUMI,E_FLG_RIFLUSSO,E_FLG_UNI_10389_1,E_FLG_EVACU_FUMI,E_DEPR_CANALE_FUMO_PA,E_TEMP_FUMI_C,E_TEMP_ARIA_C,E_O2_PERC,E_CO2_PERC,E_CO_CORRETTO_PPM,E_REND_COMB_PERC,E_REND_MIN_LEGGE_PERC,E_NOX_PPM,DATA_ULT_MOD,UTENTE_ULT_MOD,L11_1_PORTATA_COMBUSTIBILE,L11_1_CO_NO_ARIA_PPM,L11_1_FLG_RISPETTA_BACHARACH,L11_1_FLG_CO_MIN_1000,L11_1_FLG_REND_MAG_REND_MIN,L11_1_PORTATA_COMBUSTIBILE_UM,L11_1_ALTRO_RIFERIMENTO,E_BACHARACH_MIN,E_BACHARACH_MED,E_BACHARACH_MAX,E_CONTROLLOWEB,E_NOX_MG_KWH,E_1B_FLG_CUCINA,E_1B_FLG_UNI_10389_2,E_1B_PARTICOLATO_MG_AL_M3,E_NOX_MG_NM3 FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTDettTipo1Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTDettTipo1DaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitTDettTipo1DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDettTipo1DaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDettTipo1DaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_T_DETT_TIPO1 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTDettTipo1Dto findByPrimaryKey(SigitTDettTipo1Pk pk) throws SigitTDettTipo1DaoException {
		LOG.debug("[SigitTDettTipo1DaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_DETT_TIPO1,FK_ALLEGATO,CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,E_N_MODULO_TERMICO,E_POT_TERM_FOCOL_KW,E_FLG_CLIMA_INVERNO,E_FLG_PRODUZ_ACS,E_FLG_DISPOS_COMANDO,E_FLG_DISPOS_SICUREZZA,E_FLG_VALVOLA_SICUREZZA,E_FLG_SCAMBIATORE_FUMI,E_FLG_RIFLUSSO,E_FLG_UNI_10389_1,E_FLG_EVACU_FUMI,E_DEPR_CANALE_FUMO_PA,E_TEMP_FUMI_C,E_TEMP_ARIA_C,E_O2_PERC,E_CO2_PERC,E_CO_CORRETTO_PPM,E_REND_COMB_PERC,E_REND_MIN_LEGGE_PERC,E_NOX_PPM,DATA_ULT_MOD,UTENTE_ULT_MOD,L11_1_PORTATA_COMBUSTIBILE,L11_1_CO_NO_ARIA_PPM,L11_1_FLG_RISPETTA_BACHARACH,L11_1_FLG_CO_MIN_1000,L11_1_FLG_REND_MAG_REND_MIN,L11_1_PORTATA_COMBUSTIBILE_UM,L11_1_ALTRO_RIFERIMENTO,E_BACHARACH_MIN,E_BACHARACH_MED,E_BACHARACH_MAX,E_CONTROLLOWEB,E_NOX_MG_KWH,E_1B_FLG_CUCINA,E_1B_FLG_UNI_10389_2,E_1B_PARTICOLATO_MG_AL_M3,E_NOX_MG_NM3 FROM "
						+ getTableName() + " WHERE ID_DETT_TIPO1 = :ID_DETT_TIPO1 ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DETT_TIPO1]
		params.addValue("ID_DETT_TIPO1", pk.getIdDettTipo1(), java.sql.Types.NUMERIC);

		List<SigitTDettTipo1Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTDettTipo1DaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTDettTipo1DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDettTipo1DaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDettTipo1DaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byAllegatoCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettTipo1Dto> findByAllegatoCodImpianto(SigitTDettTipo1Dto input)
			throws SigitTDettTipo1DaoException {
		LOG.debug("[SigitTDettTipo1DaoImpl::findByAllegatoCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_DETT_TIPO1,FK_ALLEGATO,CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,E_N_MODULO_TERMICO,E_POT_TERM_FOCOL_KW,E_FLG_CLIMA_INVERNO,E_FLG_PRODUZ_ACS,E_FLG_DISPOS_COMANDO,E_FLG_DISPOS_SICUREZZA,E_FLG_VALVOLA_SICUREZZA,E_FLG_SCAMBIATORE_FUMI,E_FLG_RIFLUSSO,E_FLG_UNI_10389_1,E_FLG_EVACU_FUMI,E_DEPR_CANALE_FUMO_PA,E_TEMP_FUMI_C,E_TEMP_ARIA_C,E_O2_PERC,E_CO2_PERC,E_CO_CORRETTO_PPM,E_REND_COMB_PERC,E_REND_MIN_LEGGE_PERC,E_NOX_PPM,DATA_ULT_MOD,UTENTE_ULT_MOD,L11_1_PORTATA_COMBUSTIBILE,L11_1_CO_NO_ARIA_PPM,L11_1_FLG_RISPETTA_BACHARACH,L11_1_FLG_CO_MIN_1000,L11_1_FLG_REND_MAG_REND_MIN,L11_1_PORTATA_COMBUSTIBILE_UM,L11_1_ALTRO_RIFERIMENTO,E_BACHARACH_MIN,E_BACHARACH_MED,E_BACHARACH_MAX,E_CONTROLLOWEB,E_NOX_MG_KWH,E_1B_FLG_CUCINA,E_1B_FLG_UNI_10389_2,E_1B_PARTICOLATO_MG_AL_M3,E_NOX_MG_NM3 ");
		sql.append(" FROM SIGIT_T_DETT_TIPO1");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R180471985) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" 1 = 1 ");
		if (input.getFkAllegato() != null) {
			sql.append(" AND FK_ALLEGATO = :idAllegato ");
		}

		if (input.getCodiceImpianto() != null) {
			sql.append(" AND CODICE_IMPIANTO = :idCodiceImpianto ");
		}

		if (input.getProgressivo() != null) {
			sql.append(" AND PROGRESSIVO = :progressivo ");
		}

		if (input.getENModuloTermico() != null) {
			sql.append(" AND E_N_MODULO_TERMICO = :numModulo ");
		}

		sql.append(" ORDER BY PROGRESSIVO, E_N_MODULO_TERMICO ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-2114739279) ENABLED START*/
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

		if (input.getENModuloTermico() != null) {
			paramMap.addValue("numModulo", input.getENModuloTermico());
		}

		/*PROTECTED REGION END*/
		List<SigitTDettTipo1Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAllegatoCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTDettTipo1DaoImpl::findByAllegatoCodImpianto] esecuzione query", ex);
			throw new SigitTDettTipo1DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDettTipo1DaoImpl", "findByAllegatoCodImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTDettTipo1DaoImpl::findByAllegatoCodImpianto] END");
		}
		return list;
	}

}
