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

/*PROTECTED REGION ID(R-2092228177) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTDettTipo4.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byAllegatoCodImpianto (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - byIdAllegato (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTDettTipo4DaoImpl extends AbstractDAO implements SigitTDettTipo4Dao {
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
	 * Metodo di inserimento del DAO sigitTDettTipo4. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDettTipo4Pk
	 * @generated
	 */

	public SigitTDettTipo4Pk insert(SigitTDettTipo4Dto dto)

	{
		LOG.debug("[SigitTDettTipo4DaoImpl::insert] START");
		java.math.BigDecimal newKey = java.math.BigDecimal.valueOf(incrementer.nextLongValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_DETT_TIPO4,FK_ALLEGATO,CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,FK_FLUIDO,E_POTENZA_ASSORB_COMB_KW,E_POTENZA_TERM_BYPASS_KW,E_TEMP_ARIA_C,E_TEMP_H2O_OUT_C,E_TEMP_H2O_IN_C,E_POTENZA_MORSETTI_KW,E_TEMP_H2O_MOTORE_C,E_TEMP_FUMI_VALLE_C,E_TEMP_FUMI_MONTE_C,DATA_ULT_MOD,UTENTE_ULT_MOD,L11_4_SOVRAFREQ_SOGLIA_HZ_MIN,L11_4_SOVRAFREQ_SOGLIA_HZ_MED,L11_4_SOVRAFREQ_SOGLIA_HZ_MAX,L11_4_SOVRAFREQ_TEMPO_S_MIN,L11_4_SOVRAFREQ_TEMPO_S_MED,L11_4_SOVRAFREQ_TEMPO_S_MAX,L11_4_SOTTOFREQ_SOGLIA_HZ_MIN,L11_4_SOTTOFREQ_SOGLIA_HZ_MED,L11_4_SOTTOFREQ_SOGLIA_HZ_MAX,L11_4_SOTTOFREQ_TEMPO_S_MIN,L11_4_SOTTOFREQ_TEMPO_S_MED,L11_4_SOTTOFREQ_TEMPO_S_MAX,L11_4_SOVRATENS_SOGLIA_V_MIN,L11_4_SOVRATENS_SOGLIA_V_MED,L11_4_SOVRATENS_SOGLIA_V_MAX,L11_4_SOVRATENS_TEMPO_S_MIN,L11_4_SOVRATENS_TEMPO_S_MED,L11_4_SOVRATENS_TEMPO_S_MAX,L11_4_SOTTOTENS_SOGLIA_V_MIN,L11_4_SOTTOTENS_SOGLIA_V_MED,L11_4_SOTTOTENS_SOGLIA_V_MAX,L11_4_SOTTOTENS_TEMPO_S_MIN,L11_4_SOTTOTENS_TEMPO_S_MED,L11_4_SOTTOTENS_TEMPO_S_MAX,E_CONTROLLOWEB ) VALUES (  :ID_DETT_TIPO4 , :FK_ALLEGATO , :CODICE_IMPIANTO , :FK_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :FK_FLUIDO , :E_POTENZA_ASSORB_COMB_KW , :E_POTENZA_TERM_BYPASS_KW , :E_TEMP_ARIA_C , :E_TEMP_H2O_OUT_C , :E_TEMP_H2O_IN_C , :E_POTENZA_MORSETTI_KW , :E_TEMP_H2O_MOTORE_C , :E_TEMP_FUMI_VALLE_C , :E_TEMP_FUMI_MONTE_C , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :L11_4_SOVRAFREQ_SOGLIA_HZ_MIN , :L11_4_SOVRAFREQ_SOGLIA_HZ_MED , :L11_4_SOVRAFREQ_SOGLIA_HZ_MAX , :L11_4_SOVRAFREQ_TEMPO_S_MIN , :L11_4_SOVRAFREQ_TEMPO_S_MED , :L11_4_SOVRAFREQ_TEMPO_S_MAX , :L11_4_SOTTOFREQ_SOGLIA_HZ_MIN , :L11_4_SOTTOFREQ_SOGLIA_HZ_MED , :L11_4_SOTTOFREQ_SOGLIA_HZ_MAX , :L11_4_SOTTOFREQ_TEMPO_S_MIN , :L11_4_SOTTOFREQ_TEMPO_S_MED , :L11_4_SOTTOFREQ_TEMPO_S_MAX , :L11_4_SOVRATENS_SOGLIA_V_MIN , :L11_4_SOVRATENS_SOGLIA_V_MED , :L11_4_SOVRATENS_SOGLIA_V_MAX , :L11_4_SOVRATENS_TEMPO_S_MIN , :L11_4_SOVRATENS_TEMPO_S_MED , :L11_4_SOVRATENS_TEMPO_S_MAX , :L11_4_SOTTOTENS_SOGLIA_V_MIN , :L11_4_SOTTOTENS_SOGLIA_V_MED , :L11_4_SOTTOTENS_SOGLIA_V_MAX , :L11_4_SOTTOTENS_TEMPO_S_MIN , :L11_4_SOTTOTENS_TEMPO_S_MED , :L11_4_SOTTOTENS_TEMPO_S_MAX , :E_CONTROLLOWEB  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DETT_TIPO4]
		params.addValue("ID_DETT_TIPO4", newKey, java.sql.Types.NUMERIC);

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

		// valorizzazione paametro relativo a colonna [FK_FLUIDO]
		params.addValue("FK_FLUIDO", dto.getFkFluido(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_POTENZA_ASSORB_COMB_KW]
		params.addValue("E_POTENZA_ASSORB_COMB_KW", dto.getEPotenzaAssorbCombKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_POTENZA_TERM_BYPASS_KW]
		params.addValue("E_POTENZA_TERM_BYPASS_KW", dto.getEPotenzaTermBypassKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_ARIA_C]
		params.addValue("E_TEMP_ARIA_C", dto.getETempAriaC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_H2O_OUT_C]
		params.addValue("E_TEMP_H2O_OUT_C", dto.getETempH2oOutC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_H2O_IN_C]
		params.addValue("E_TEMP_H2O_IN_C", dto.getETempH2oInC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_POTENZA_MORSETTI_KW]
		params.addValue("E_POTENZA_MORSETTI_KW", dto.getEPotenzaMorsettiKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_H2O_MOTORE_C]
		params.addValue("E_TEMP_H2O_MOTORE_C", dto.getETempH2oMotoreC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_FUMI_VALLE_C]
		params.addValue("E_TEMP_FUMI_VALLE_C", dto.getETempFumiValleC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_FUMI_MONTE_C]
		params.addValue("E_TEMP_FUMI_MONTE_C", dto.getETempFumiMonteC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRAFREQ_SOGLIA_HZ_MIN]
		params.addValue("L11_4_SOVRAFREQ_SOGLIA_HZ_MIN", dto.getL114SovrafreqSogliaHzMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRAFREQ_SOGLIA_HZ_MED]
		params.addValue("L11_4_SOVRAFREQ_SOGLIA_HZ_MED", dto.getL114SovrafreqSogliaHzMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRAFREQ_SOGLIA_HZ_MAX]
		params.addValue("L11_4_SOVRAFREQ_SOGLIA_HZ_MAX", dto.getL114SovrafreqSogliaHzMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRAFREQ_TEMPO_S_MIN]
		params.addValue("L11_4_SOVRAFREQ_TEMPO_S_MIN", dto.getL114SovrafreqTempoSMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRAFREQ_TEMPO_S_MED]
		params.addValue("L11_4_SOVRAFREQ_TEMPO_S_MED", dto.getL114SovrafreqTempoSMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRAFREQ_TEMPO_S_MAX]
		params.addValue("L11_4_SOVRAFREQ_TEMPO_S_MAX", dto.getL114SovrafreqTempoSMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOFREQ_SOGLIA_HZ_MIN]
		params.addValue("L11_4_SOTTOFREQ_SOGLIA_HZ_MIN", dto.getL114SottofreqSogliaHzMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOFREQ_SOGLIA_HZ_MED]
		params.addValue("L11_4_SOTTOFREQ_SOGLIA_HZ_MED", dto.getL114SottofreqSogliaHzMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOFREQ_SOGLIA_HZ_MAX]
		params.addValue("L11_4_SOTTOFREQ_SOGLIA_HZ_MAX", dto.getL114SottofreqSogliaHzMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOFREQ_TEMPO_S_MIN]
		params.addValue("L11_4_SOTTOFREQ_TEMPO_S_MIN", dto.getL114SottofreqTempoSMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOFREQ_TEMPO_S_MED]
		params.addValue("L11_4_SOTTOFREQ_TEMPO_S_MED", dto.getL114SottofreqTempoSMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOFREQ_TEMPO_S_MAX]
		params.addValue("L11_4_SOTTOFREQ_TEMPO_S_MAX", dto.getL114SottofreqTempoSMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRATENS_SOGLIA_V_MIN]
		params.addValue("L11_4_SOVRATENS_SOGLIA_V_MIN", dto.getL114SovratensSogliaVMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRATENS_SOGLIA_V_MED]
		params.addValue("L11_4_SOVRATENS_SOGLIA_V_MED", dto.getL114SovratensSogliaVMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRATENS_SOGLIA_V_MAX]
		params.addValue("L11_4_SOVRATENS_SOGLIA_V_MAX", dto.getL114SovratensSogliaVMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRATENS_TEMPO_S_MIN]
		params.addValue("L11_4_SOVRATENS_TEMPO_S_MIN", dto.getL114SovratensTempoSMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRATENS_TEMPO_S_MED]
		params.addValue("L11_4_SOVRATENS_TEMPO_S_MED", dto.getL114SovratensTempoSMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRATENS_TEMPO_S_MAX]
		params.addValue("L11_4_SOVRATENS_TEMPO_S_MAX", dto.getL114SovratensTempoSMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOTENS_SOGLIA_V_MIN]
		params.addValue("L11_4_SOTTOTENS_SOGLIA_V_MIN", dto.getL114SottotensSogliaVMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOTENS_SOGLIA_V_MED]
		params.addValue("L11_4_SOTTOTENS_SOGLIA_V_MED", dto.getL114SottotensSogliaVMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOTENS_SOGLIA_V_MAX]
		params.addValue("L11_4_SOTTOTENS_SOGLIA_V_MAX", dto.getL114SottotensSogliaVMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOTENS_TEMPO_S_MIN]
		params.addValue("L11_4_SOTTOTENS_TEMPO_S_MIN", dto.getL114SottotensTempoSMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOTENS_TEMPO_S_MED]
		params.addValue("L11_4_SOTTOTENS_TEMPO_S_MED", dto.getL114SottotensTempoSMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOTENS_TEMPO_S_MAX]
		params.addValue("L11_4_SOTTOTENS_TEMPO_S_MAX", dto.getL114SottotensTempoSMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_CONTROLLOWEB]
		params.addValue("E_CONTROLLOWEB", dto.getEControlloweb(), java.sql.Types.TIMESTAMP);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdDettTipo4(newKey);
		LOG.debug("[SigitTDettTipo4DaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_DETT_TIPO4 table.
	 * @generated
	 */
	public void update(SigitTDettTipo4Dto dto) throws SigitTDettTipo4DaoException {
		LOG.debug("[SigitTDettTipo4DaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_ALLEGATO = :FK_ALLEGATO ,CODICE_IMPIANTO = :CODICE_IMPIANTO ,FK_TIPO_COMPONENTE = :FK_TIPO_COMPONENTE ,PROGRESSIVO = :PROGRESSIVO ,DATA_INSTALL = :DATA_INSTALL ,FK_FLUIDO = :FK_FLUIDO ,E_POTENZA_ASSORB_COMB_KW = :E_POTENZA_ASSORB_COMB_KW ,E_POTENZA_TERM_BYPASS_KW = :E_POTENZA_TERM_BYPASS_KW ,E_TEMP_ARIA_C = :E_TEMP_ARIA_C ,E_TEMP_H2O_OUT_C = :E_TEMP_H2O_OUT_C ,E_TEMP_H2O_IN_C = :E_TEMP_H2O_IN_C ,E_POTENZA_MORSETTI_KW = :E_POTENZA_MORSETTI_KW ,E_TEMP_H2O_MOTORE_C = :E_TEMP_H2O_MOTORE_C ,E_TEMP_FUMI_VALLE_C = :E_TEMP_FUMI_VALLE_C ,E_TEMP_FUMI_MONTE_C = :E_TEMP_FUMI_MONTE_C ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,L11_4_SOVRAFREQ_SOGLIA_HZ_MIN = :L11_4_SOVRAFREQ_SOGLIA_HZ_MIN ,L11_4_SOVRAFREQ_SOGLIA_HZ_MED = :L11_4_SOVRAFREQ_SOGLIA_HZ_MED ,L11_4_SOVRAFREQ_SOGLIA_HZ_MAX = :L11_4_SOVRAFREQ_SOGLIA_HZ_MAX ,L11_4_SOVRAFREQ_TEMPO_S_MIN = :L11_4_SOVRAFREQ_TEMPO_S_MIN ,L11_4_SOVRAFREQ_TEMPO_S_MED = :L11_4_SOVRAFREQ_TEMPO_S_MED ,L11_4_SOVRAFREQ_TEMPO_S_MAX = :L11_4_SOVRAFREQ_TEMPO_S_MAX ,L11_4_SOTTOFREQ_SOGLIA_HZ_MIN = :L11_4_SOTTOFREQ_SOGLIA_HZ_MIN ,L11_4_SOTTOFREQ_SOGLIA_HZ_MED = :L11_4_SOTTOFREQ_SOGLIA_HZ_MED ,L11_4_SOTTOFREQ_SOGLIA_HZ_MAX = :L11_4_SOTTOFREQ_SOGLIA_HZ_MAX ,L11_4_SOTTOFREQ_TEMPO_S_MIN = :L11_4_SOTTOFREQ_TEMPO_S_MIN ,L11_4_SOTTOFREQ_TEMPO_S_MED = :L11_4_SOTTOFREQ_TEMPO_S_MED ,L11_4_SOTTOFREQ_TEMPO_S_MAX = :L11_4_SOTTOFREQ_TEMPO_S_MAX ,L11_4_SOVRATENS_SOGLIA_V_MIN = :L11_4_SOVRATENS_SOGLIA_V_MIN ,L11_4_SOVRATENS_SOGLIA_V_MED = :L11_4_SOVRATENS_SOGLIA_V_MED ,L11_4_SOVRATENS_SOGLIA_V_MAX = :L11_4_SOVRATENS_SOGLIA_V_MAX ,L11_4_SOVRATENS_TEMPO_S_MIN = :L11_4_SOVRATENS_TEMPO_S_MIN ,L11_4_SOVRATENS_TEMPO_S_MED = :L11_4_SOVRATENS_TEMPO_S_MED ,L11_4_SOVRATENS_TEMPO_S_MAX = :L11_4_SOVRATENS_TEMPO_S_MAX ,L11_4_SOTTOTENS_SOGLIA_V_MIN = :L11_4_SOTTOTENS_SOGLIA_V_MIN ,L11_4_SOTTOTENS_SOGLIA_V_MED = :L11_4_SOTTOTENS_SOGLIA_V_MED ,L11_4_SOTTOTENS_SOGLIA_V_MAX = :L11_4_SOTTOTENS_SOGLIA_V_MAX ,L11_4_SOTTOTENS_TEMPO_S_MIN = :L11_4_SOTTOTENS_TEMPO_S_MIN ,L11_4_SOTTOTENS_TEMPO_S_MED = :L11_4_SOTTOTENS_TEMPO_S_MED ,L11_4_SOTTOTENS_TEMPO_S_MAX = :L11_4_SOTTOTENS_TEMPO_S_MAX ,E_CONTROLLOWEB = :E_CONTROLLOWEB  WHERE ID_DETT_TIPO4 = :ID_DETT_TIPO4 ";

		if (dto.getIdDettTipo4() == null) {
			LOG.error("[SigitTDettTipo4DaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTDettTipo4DaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DETT_TIPO4]
		params.addValue("ID_DETT_TIPO4", dto.getIdDettTipo4(), java.sql.Types.NUMERIC);

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

		// valorizzazione paametro relativo a colonna [FK_FLUIDO]
		params.addValue("FK_FLUIDO", dto.getFkFluido(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_POTENZA_ASSORB_COMB_KW]
		params.addValue("E_POTENZA_ASSORB_COMB_KW", dto.getEPotenzaAssorbCombKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_POTENZA_TERM_BYPASS_KW]
		params.addValue("E_POTENZA_TERM_BYPASS_KW", dto.getEPotenzaTermBypassKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_ARIA_C]
		params.addValue("E_TEMP_ARIA_C", dto.getETempAriaC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_H2O_OUT_C]
		params.addValue("E_TEMP_H2O_OUT_C", dto.getETempH2oOutC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_H2O_IN_C]
		params.addValue("E_TEMP_H2O_IN_C", dto.getETempH2oInC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_POTENZA_MORSETTI_KW]
		params.addValue("E_POTENZA_MORSETTI_KW", dto.getEPotenzaMorsettiKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_H2O_MOTORE_C]
		params.addValue("E_TEMP_H2O_MOTORE_C", dto.getETempH2oMotoreC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_FUMI_VALLE_C]
		params.addValue("E_TEMP_FUMI_VALLE_C", dto.getETempFumiValleC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_TEMP_FUMI_MONTE_C]
		params.addValue("E_TEMP_FUMI_MONTE_C", dto.getETempFumiMonteC(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRAFREQ_SOGLIA_HZ_MIN]
		params.addValue("L11_4_SOVRAFREQ_SOGLIA_HZ_MIN", dto.getL114SovrafreqSogliaHzMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRAFREQ_SOGLIA_HZ_MED]
		params.addValue("L11_4_SOVRAFREQ_SOGLIA_HZ_MED", dto.getL114SovrafreqSogliaHzMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRAFREQ_SOGLIA_HZ_MAX]
		params.addValue("L11_4_SOVRAFREQ_SOGLIA_HZ_MAX", dto.getL114SovrafreqSogliaHzMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRAFREQ_TEMPO_S_MIN]
		params.addValue("L11_4_SOVRAFREQ_TEMPO_S_MIN", dto.getL114SovrafreqTempoSMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRAFREQ_TEMPO_S_MED]
		params.addValue("L11_4_SOVRAFREQ_TEMPO_S_MED", dto.getL114SovrafreqTempoSMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRAFREQ_TEMPO_S_MAX]
		params.addValue("L11_4_SOVRAFREQ_TEMPO_S_MAX", dto.getL114SovrafreqTempoSMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOFREQ_SOGLIA_HZ_MIN]
		params.addValue("L11_4_SOTTOFREQ_SOGLIA_HZ_MIN", dto.getL114SottofreqSogliaHzMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOFREQ_SOGLIA_HZ_MED]
		params.addValue("L11_4_SOTTOFREQ_SOGLIA_HZ_MED", dto.getL114SottofreqSogliaHzMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOFREQ_SOGLIA_HZ_MAX]
		params.addValue("L11_4_SOTTOFREQ_SOGLIA_HZ_MAX", dto.getL114SottofreqSogliaHzMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOFREQ_TEMPO_S_MIN]
		params.addValue("L11_4_SOTTOFREQ_TEMPO_S_MIN", dto.getL114SottofreqTempoSMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOFREQ_TEMPO_S_MED]
		params.addValue("L11_4_SOTTOFREQ_TEMPO_S_MED", dto.getL114SottofreqTempoSMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOFREQ_TEMPO_S_MAX]
		params.addValue("L11_4_SOTTOFREQ_TEMPO_S_MAX", dto.getL114SottofreqTempoSMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRATENS_SOGLIA_V_MIN]
		params.addValue("L11_4_SOVRATENS_SOGLIA_V_MIN", dto.getL114SovratensSogliaVMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRATENS_SOGLIA_V_MED]
		params.addValue("L11_4_SOVRATENS_SOGLIA_V_MED", dto.getL114SovratensSogliaVMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRATENS_SOGLIA_V_MAX]
		params.addValue("L11_4_SOVRATENS_SOGLIA_V_MAX", dto.getL114SovratensSogliaVMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRATENS_TEMPO_S_MIN]
		params.addValue("L11_4_SOVRATENS_TEMPO_S_MIN", dto.getL114SovratensTempoSMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRATENS_TEMPO_S_MED]
		params.addValue("L11_4_SOVRATENS_TEMPO_S_MED", dto.getL114SovratensTempoSMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOVRATENS_TEMPO_S_MAX]
		params.addValue("L11_4_SOVRATENS_TEMPO_S_MAX", dto.getL114SovratensTempoSMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOTENS_SOGLIA_V_MIN]
		params.addValue("L11_4_SOTTOTENS_SOGLIA_V_MIN", dto.getL114SottotensSogliaVMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOTENS_SOGLIA_V_MED]
		params.addValue("L11_4_SOTTOTENS_SOGLIA_V_MED", dto.getL114SottotensSogliaVMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOTENS_SOGLIA_V_MAX]
		params.addValue("L11_4_SOTTOTENS_SOGLIA_V_MAX", dto.getL114SottotensSogliaVMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOTENS_TEMPO_S_MIN]
		params.addValue("L11_4_SOTTOTENS_TEMPO_S_MIN", dto.getL114SottotensTempoSMin(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOTENS_TEMPO_S_MED]
		params.addValue("L11_4_SOTTOTENS_TEMPO_S_MED", dto.getL114SottotensTempoSMed(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_4_SOTTOTENS_TEMPO_S_MAX]
		params.addValue("L11_4_SOTTOTENS_TEMPO_S_MAX", dto.getL114SottotensTempoSMax(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_CONTROLLOWEB]
		params.addValue("E_CONTROLLOWEB", dto.getEControlloweb(), java.sql.Types.TIMESTAMP);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDettTipo4DaoImpl::update] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_DETT_TIPO4 table.
	 * @generated
	 */
	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitTDettTipo4DaoException {
		LOG.debug("[SigitTDettTipo4DaoImpl::customDeleterByIdAllegato] START");
		/*PROTECTED REGION ID(R-235491022) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE FK_ALLEGATO = :idAllegato";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idAllegato", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDettTipo4DaoImpl::customDeleterByIdAllegato] END");
	}

	protected SigitTDettTipo4DaoRowMapper findAllRowMapper = new SigitTDettTipo4DaoRowMapper(null,
			SigitTDettTipo4Dto.class, this);

	protected SigitTDettTipo4DaoRowMapper findByPrimaryKeyRowMapper = new SigitTDettTipo4DaoRowMapper(null,
			SigitTDettTipo4Dto.class, this);

	protected SigitTDettTipo4DaoRowMapper byAllegatoCodImpiantoRowMapper = new SigitTDettTipo4DaoRowMapper(null,
			SigitTDettTipo4Dto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DETT_TIPO4";
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_DETT_TIPO4.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettTipo4Dto> findAll() throws SigitTDettTipo4DaoException {
		LOG.debug("[SigitTDettTipo4DaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_DETT_TIPO4,FK_ALLEGATO,CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,FK_FLUIDO,E_POTENZA_ASSORB_COMB_KW,E_POTENZA_TERM_BYPASS_KW,E_TEMP_ARIA_C,E_TEMP_H2O_OUT_C,E_TEMP_H2O_IN_C,E_POTENZA_MORSETTI_KW,E_TEMP_H2O_MOTORE_C,E_TEMP_FUMI_VALLE_C,E_TEMP_FUMI_MONTE_C,DATA_ULT_MOD,UTENTE_ULT_MOD,L11_4_SOVRAFREQ_SOGLIA_HZ_MIN,L11_4_SOVRAFREQ_SOGLIA_HZ_MED,L11_4_SOVRAFREQ_SOGLIA_HZ_MAX,L11_4_SOVRAFREQ_TEMPO_S_MIN,L11_4_SOVRAFREQ_TEMPO_S_MED,L11_4_SOVRAFREQ_TEMPO_S_MAX,L11_4_SOTTOFREQ_SOGLIA_HZ_MIN,L11_4_SOTTOFREQ_SOGLIA_HZ_MED,L11_4_SOTTOFREQ_SOGLIA_HZ_MAX,L11_4_SOTTOFREQ_TEMPO_S_MIN,L11_4_SOTTOFREQ_TEMPO_S_MED,L11_4_SOTTOFREQ_TEMPO_S_MAX,L11_4_SOVRATENS_SOGLIA_V_MIN,L11_4_SOVRATENS_SOGLIA_V_MED,L11_4_SOVRATENS_SOGLIA_V_MAX,L11_4_SOVRATENS_TEMPO_S_MIN,L11_4_SOVRATENS_TEMPO_S_MED,L11_4_SOVRATENS_TEMPO_S_MAX,L11_4_SOTTOTENS_SOGLIA_V_MIN,L11_4_SOTTOTENS_SOGLIA_V_MED,L11_4_SOTTOTENS_SOGLIA_V_MAX,L11_4_SOTTOTENS_TEMPO_S_MIN,L11_4_SOTTOTENS_TEMPO_S_MED,L11_4_SOTTOTENS_TEMPO_S_MAX,E_CONTROLLOWEB FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTDettTipo4Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTDettTipo4DaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitTDettTipo4DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDettTipo4DaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDettTipo4DaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the SIGIT_T_DETT_TIPO4 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTDettTipo4Dto findByPrimaryKey(SigitTDettTipo4Pk pk) throws SigitTDettTipo4DaoException {
		LOG.debug("[SigitTDettTipo4DaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_DETT_TIPO4,FK_ALLEGATO,CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,FK_FLUIDO,E_POTENZA_ASSORB_COMB_KW,E_POTENZA_TERM_BYPASS_KW,E_TEMP_ARIA_C,E_TEMP_H2O_OUT_C,E_TEMP_H2O_IN_C,E_POTENZA_MORSETTI_KW,E_TEMP_H2O_MOTORE_C,E_TEMP_FUMI_VALLE_C,E_TEMP_FUMI_MONTE_C,DATA_ULT_MOD,UTENTE_ULT_MOD,L11_4_SOVRAFREQ_SOGLIA_HZ_MIN,L11_4_SOVRAFREQ_SOGLIA_HZ_MED,L11_4_SOVRAFREQ_SOGLIA_HZ_MAX,L11_4_SOVRAFREQ_TEMPO_S_MIN,L11_4_SOVRAFREQ_TEMPO_S_MED,L11_4_SOVRAFREQ_TEMPO_S_MAX,L11_4_SOTTOFREQ_SOGLIA_HZ_MIN,L11_4_SOTTOFREQ_SOGLIA_HZ_MED,L11_4_SOTTOFREQ_SOGLIA_HZ_MAX,L11_4_SOTTOFREQ_TEMPO_S_MIN,L11_4_SOTTOFREQ_TEMPO_S_MED,L11_4_SOTTOFREQ_TEMPO_S_MAX,L11_4_SOVRATENS_SOGLIA_V_MIN,L11_4_SOVRATENS_SOGLIA_V_MED,L11_4_SOVRATENS_SOGLIA_V_MAX,L11_4_SOVRATENS_TEMPO_S_MIN,L11_4_SOVRATENS_TEMPO_S_MED,L11_4_SOVRATENS_TEMPO_S_MAX,L11_4_SOTTOTENS_SOGLIA_V_MIN,L11_4_SOTTOTENS_SOGLIA_V_MED,L11_4_SOTTOTENS_SOGLIA_V_MAX,L11_4_SOTTOTENS_TEMPO_S_MIN,L11_4_SOTTOTENS_TEMPO_S_MED,L11_4_SOTTOTENS_TEMPO_S_MAX,E_CONTROLLOWEB FROM "
						+ getTableName() + " WHERE ID_DETT_TIPO4 = :ID_DETT_TIPO4 ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DETT_TIPO4]
		params.addValue("ID_DETT_TIPO4", pk.getIdDettTipo4(), java.sql.Types.NUMERIC);

		List<SigitTDettTipo4Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTDettTipo4DaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTDettTipo4DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDettTipo4DaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDettTipo4DaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byAllegatoCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettTipo4Dto> findByAllegatoCodImpianto(SigitTDettTipo4Dto input)
			throws SigitTDettTipo4DaoException {
		LOG.debug("[SigitTDettTipo4DaoImpl::findByAllegatoCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_DETT_TIPO4,FK_ALLEGATO,CODICE_IMPIANTO,FK_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,FK_FLUIDO,E_POTENZA_ASSORB_COMB_KW,E_POTENZA_TERM_BYPASS_KW,E_TEMP_ARIA_C,E_TEMP_H2O_OUT_C,E_TEMP_H2O_IN_C,E_POTENZA_MORSETTI_KW,E_TEMP_H2O_MOTORE_C,E_TEMP_FUMI_VALLE_C,E_TEMP_FUMI_MONTE_C,DATA_ULT_MOD,UTENTE_ULT_MOD,L11_4_SOVRAFREQ_SOGLIA_HZ_MIN,L11_4_SOVRAFREQ_SOGLIA_HZ_MED,L11_4_SOVRAFREQ_SOGLIA_HZ_MAX,L11_4_SOVRAFREQ_TEMPO_S_MIN,L11_4_SOVRAFREQ_TEMPO_S_MED,L11_4_SOVRAFREQ_TEMPO_S_MAX,L11_4_SOTTOFREQ_SOGLIA_HZ_MIN,L11_4_SOTTOFREQ_SOGLIA_HZ_MED,L11_4_SOTTOFREQ_SOGLIA_HZ_MAX,L11_4_SOTTOFREQ_TEMPO_S_MIN,L11_4_SOTTOFREQ_TEMPO_S_MED,L11_4_SOTTOFREQ_TEMPO_S_MAX,L11_4_SOVRATENS_SOGLIA_V_MIN,L11_4_SOVRATENS_SOGLIA_V_MED,L11_4_SOVRATENS_SOGLIA_V_MAX,L11_4_SOVRATENS_TEMPO_S_MIN,L11_4_SOVRATENS_TEMPO_S_MED,L11_4_SOVRATENS_TEMPO_S_MAX,L11_4_SOTTOTENS_SOGLIA_V_MIN,L11_4_SOTTOTENS_SOGLIA_V_MED,L11_4_SOTTOTENS_SOGLIA_V_MAX,L11_4_SOTTOTENS_TEMPO_S_MIN,L11_4_SOTTOTENS_TEMPO_S_MED,L11_4_SOTTOTENS_TEMPO_S_MAX,E_CONTROLLOWEB ");
		sql.append(" FROM SIGIT_T_DETT_TIPO4");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R552691726) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" 1 = 1 ");
		if (input.getFkAllegato() != null) {
			sql.append(" AND  FK_ALLEGATO = :idAllegato ");
		}

		if (input.getProgressivo() != null) {
			sql.append(" AND PROGRESSIVO = :progressivo ");
		}

		if (input.getCodiceImpianto() != null) {
			sql.append(" AND  CODICE_IMPIANTO = :idCodiceImpianto ");
		}

		sql.append(" ORDER BY PROGRESSIVO ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R834138100) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input.getFkAllegato() != null) {
			paramMap.addValue("idAllegato", input.getFkAllegato());
		}

		if (input.getProgressivo() != null) {
			paramMap.addValue("progressivo", input.getProgressivo());
		}

		if (input.getCodiceImpianto() != null) {
			paramMap.addValue("idCodiceImpianto", input.getCodiceImpianto());
		}

		/*PROTECTED REGION END*/
		List<SigitTDettTipo4Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAllegatoCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTDettTipo4DaoImpl::findByAllegatoCodImpianto] esecuzione query", ex);
			throw new SigitTDettTipo4DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDettTipo4DaoImpl", "findByAllegatoCodImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTDettTipo4DaoImpl::findByAllegatoCodImpianto] END");
		}
		return list;
	}

}
