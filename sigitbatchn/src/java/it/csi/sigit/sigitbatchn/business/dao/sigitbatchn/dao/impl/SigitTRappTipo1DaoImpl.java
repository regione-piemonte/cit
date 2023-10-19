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

/*PROTECTED REGION ID(R2136008783) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTRappTipo1.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTRappTipo1DaoImpl extends AbstractDAO implements SigitTRappTipo1Dao {
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
	 * Metodo di inserimento del DAO sigitTRappTipo1. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTRappTipo1Pk
	 * @generated
	 */

	public SigitTRappTipo1Pk insert(SigitTRappTipo1Dto dto)

	{
		LOG.debug("[SigitTRappTipo1DaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ALLEGATO,D_FLG_LOCALE_INT_IDONEO,D_FLG_GEN_EXT_IDONEO,D_FLG_APERTURE_LIBERE,D_FLG_APERTURE_ADEG,D_FLG_SCARICO_IDONEO,D_FLG_TEMP_AMB_FUNZ,D_FLG_ASSENZA_PERD_COMB,D_FLG_IDO_TEN_IMP_INT,F_FLG_ADOZIONE_VALVOLE_TERM,F_FLG_ISOLAMENTE_RETE,F_FLG_ADOZ_SIST_TRATTAM_H2O,F_FLG_SOSTITUZ_SIST_REGOLAZ,C_FLG_TRATT_CLIMA_NON_RICH,C_FLG_TRATT_ACS_NON_RICHIESTO,ID_STELLE,ID_TIPO_1B,ID_ARIA_COMBURENTE,ID_CONTROLLO_ARIA,ID_TIPO_CARIC_COMBU,D_1B_FLG_PULIZIA_CAMINO,E_1B_FLG_CALDAIA,E_1B_FLG_STUFA,E_1B_FLG_STUFA_ACCUMULO,E_1B_FLG_TERMOCUCINA,E_1B_FLG_CAMINETTO_APERTO,E_1B_FLG_CAMINETTO_CHIUSO,E_1B_FLG_INSERTO_CAMINETTO,E_1B_FLG_STUFA_ASSEMBLATA,E_1B_FLG_STUFA_PELLET,E_1B_FLG_MARCATURA_CE,E_1B_FLG_PLACCA_CAMINO ) VALUES (  :ID_ALLEGATO , :D_FLG_LOCALE_INT_IDONEO , :D_FLG_GEN_EXT_IDONEO , :D_FLG_APERTURE_LIBERE , :D_FLG_APERTURE_ADEG , :D_FLG_SCARICO_IDONEO , :D_FLG_TEMP_AMB_FUNZ , :D_FLG_ASSENZA_PERD_COMB , :D_FLG_IDO_TEN_IMP_INT , :F_FLG_ADOZIONE_VALVOLE_TERM , :F_FLG_ISOLAMENTE_RETE , :F_FLG_ADOZ_SIST_TRATTAM_H2O , :F_FLG_SOSTITUZ_SIST_REGOLAZ , :C_FLG_TRATT_CLIMA_NON_RICH , :C_FLG_TRATT_ACS_NON_RICHIESTO , :ID_STELLE , :ID_TIPO_1B , :ID_ARIA_COMBURENTE , :ID_CONTROLLO_ARIA , :ID_TIPO_CARIC_COMBU , :D_1B_FLG_PULIZIA_CAMINO , :E_1B_FLG_CALDAIA , :E_1B_FLG_STUFA , :E_1B_FLG_STUFA_ACCUMULO , :E_1B_FLG_TERMOCUCINA , :E_1B_FLG_CAMINETTO_APERTO , :E_1B_FLG_CAMINETTO_CHIUSO , :E_1B_FLG_INSERTO_CAMINETTO , :E_1B_FLG_STUFA_ASSEMBLATA , :E_1B_FLG_STUFA_PELLET , :E_1B_FLG_MARCATURA_CE , :E_1B_FLG_PLACCA_CAMINO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_LOCALE_INT_IDONEO]
		params.addValue("D_FLG_LOCALE_INT_IDONEO", dto.getDFlgLocaleIntIdoneo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_GEN_EXT_IDONEO]
		params.addValue("D_FLG_GEN_EXT_IDONEO", dto.getDFlgGenExtIdoneo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_APERTURE_LIBERE]
		params.addValue("D_FLG_APERTURE_LIBERE", dto.getDFlgApertureLibere(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_APERTURE_ADEG]
		params.addValue("D_FLG_APERTURE_ADEG", dto.getDFlgApertureAdeg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_SCARICO_IDONEO]
		params.addValue("D_FLG_SCARICO_IDONEO", dto.getDFlgScaricoIdoneo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_TEMP_AMB_FUNZ]
		params.addValue("D_FLG_TEMP_AMB_FUNZ", dto.getDFlgTempAmbFunz(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_ASSENZA_PERD_COMB]
		params.addValue("D_FLG_ASSENZA_PERD_COMB", dto.getDFlgAssenzaPerdComb(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_FLG_IDO_TEN_IMP_INT]
		params.addValue("D_FLG_IDO_TEN_IMP_INT", dto.getDFlgIdoTenImpInt(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_ADOZIONE_VALVOLE_TERM]
		params.addValue("F_FLG_ADOZIONE_VALVOLE_TERM", dto.getFFlgAdozioneValvoleTerm(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_ISOLAMENTE_RETE]
		params.addValue("F_FLG_ISOLAMENTE_RETE", dto.getFFlgIsolamenteRete(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_ADOZ_SIST_TRATTAM_H2O]
		params.addValue("F_FLG_ADOZ_SIST_TRATTAM_H2O", dto.getFFlgAdozSistTrattamH2o(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [F_FLG_SOSTITUZ_SIST_REGOLAZ]
		params.addValue("F_FLG_SOSTITUZ_SIST_REGOLAZ", dto.getFFlgSostituzSistRegolaz(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [C_FLG_TRATT_CLIMA_NON_RICH]
		params.addValue("C_FLG_TRATT_CLIMA_NON_RICH", dto.getCFlgTrattClimaNonRich(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [C_FLG_TRATT_ACS_NON_RICHIESTO]
		params.addValue("C_FLG_TRATT_ACS_NON_RICHIESTO", dto.getCFlgTrattAcsNonRichiesto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_STELLE]
		params.addValue("ID_STELLE", dto.getIdStelle(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_1B]
		params.addValue("ID_TIPO_1B", dto.getIdTipo1b(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_ARIA_COMBURENTE]
		params.addValue("ID_ARIA_COMBURENTE", dto.getIdAriaComburente(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_CONTROLLO_ARIA]
		params.addValue("ID_CONTROLLO_ARIA", dto.getIdControlloAria(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_CARIC_COMBU]
		params.addValue("ID_TIPO_CARIC_COMBU", dto.getIdTipoCaricCombu(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [D_1B_FLG_PULIZIA_CAMINO]
		params.addValue("D_1B_FLG_PULIZIA_CAMINO", dto.getD1bFlgPuliziaCamino(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_CALDAIA]
		params.addValue("E_1B_FLG_CALDAIA", dto.getE1bFlgCaldaia(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_STUFA]
		params.addValue("E_1B_FLG_STUFA", dto.getE1bFlgStufa(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_STUFA_ACCUMULO]
		params.addValue("E_1B_FLG_STUFA_ACCUMULO", dto.getE1bFlgStufaAccumulo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_TERMOCUCINA]
		params.addValue("E_1B_FLG_TERMOCUCINA", dto.getE1bFlgTermocucina(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_CAMINETTO_APERTO]
		params.addValue("E_1B_FLG_CAMINETTO_APERTO", dto.getE1bFlgCaminettoAperto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_CAMINETTO_CHIUSO]
		params.addValue("E_1B_FLG_CAMINETTO_CHIUSO", dto.getE1bFlgCaminettoChiuso(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_INSERTO_CAMINETTO]
		params.addValue("E_1B_FLG_INSERTO_CAMINETTO", dto.getE1bFlgInsertoCaminetto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_STUFA_ASSEMBLATA]
		params.addValue("E_1B_FLG_STUFA_ASSEMBLATA", dto.getE1bFlgStufaAssemblata(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_STUFA_PELLET]
		params.addValue("E_1B_FLG_STUFA_PELLET", dto.getE1bFlgStufaPellet(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_MARCATURA_CE]
		params.addValue("E_1B_FLG_MARCATURA_CE", dto.getE1bFlgMarcaturaCe(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [E_1B_FLG_PLACCA_CAMINO]
		params.addValue("E_1B_FLG_PLACCA_CAMINO", dto.getE1bFlgPlaccaCamino(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTRappTipo1DaoImpl::insert] END");
		return dto.createPk();

	}

	protected SigitTRappTipo1DaoRowMapper findByPrimaryKeyRowMapper = new SigitTRappTipo1DaoRowMapper(null,
			SigitTRappTipo1Dto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_RAPP_TIPO1";
	}

	/** 
	 * Returns all rows from the SIGIT_T_RAPP_TIPO1 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTRappTipo1Dto findByPrimaryKey(SigitTRappTipo1Pk pk) throws SigitTRappTipo1DaoException {
		LOG.debug("[SigitTRappTipo1DaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALLEGATO,D_FLG_LOCALE_INT_IDONEO,D_FLG_GEN_EXT_IDONEO,D_FLG_APERTURE_LIBERE,D_FLG_APERTURE_ADEG,D_FLG_SCARICO_IDONEO,D_FLG_TEMP_AMB_FUNZ,D_FLG_ASSENZA_PERD_COMB,D_FLG_IDO_TEN_IMP_INT,F_FLG_ADOZIONE_VALVOLE_TERM,F_FLG_ISOLAMENTE_RETE,F_FLG_ADOZ_SIST_TRATTAM_H2O,F_FLG_SOSTITUZ_SIST_REGOLAZ,C_FLG_TRATT_CLIMA_NON_RICH,C_FLG_TRATT_ACS_NON_RICHIESTO,ID_STELLE,ID_TIPO_1B,ID_ARIA_COMBURENTE,ID_CONTROLLO_ARIA,ID_TIPO_CARIC_COMBU,D_1B_FLG_PULIZIA_CAMINO,E_1B_FLG_CALDAIA,E_1B_FLG_STUFA,E_1B_FLG_STUFA_ACCUMULO,E_1B_FLG_TERMOCUCINA,E_1B_FLG_CAMINETTO_APERTO,E_1B_FLG_CAMINETTO_CHIUSO,E_1B_FLG_INSERTO_CAMINETTO,E_1B_FLG_STUFA_ASSEMBLATA,E_1B_FLG_STUFA_PELLET,E_1B_FLG_MARCATURA_CE,E_1B_FLG_PLACCA_CAMINO FROM "
						+ getTableName() + " WHERE ID_ALLEGATO = :ID_ALLEGATO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.NUMERIC);

		List<SigitTRappTipo1Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTRappTipo1DaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTRappTipo1DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTRappTipo1DaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTRappTipo1DaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
