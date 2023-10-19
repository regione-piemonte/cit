package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTRappTipo1Dao
 * @generated
 */
public class SigitTRappTipo1DaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTRappTipo1DaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTRappTipo1DaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTRappTipo1Dao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTRappTipo1DaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTRappTipo1Dto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTRappTipo1Dto) {
			return mapRow_internal((SigitTRappTipo1Dto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTRappTipo1Dto mapRow_internal(SigitTRappTipo1Dto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTRappTipo1Dto dto = objectToFill;

		// colonna [ID_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("ID_ALLEGATO") != null)
			dto.setIdAllegato(rs.getBigDecimal("ID_ALLEGATO"));

		// colonna [D_FLG_LOCALE_INT_IDONEO]
		if (mapAllColumns || columnsToReadMap.get("D_FLG_LOCALE_INT_IDONEO") != null)
			dto.setDFlgLocaleIntIdoneo(rs.getBigDecimal("D_FLG_LOCALE_INT_IDONEO"));

		// colonna [D_FLG_GEN_EXT_IDONEO]
		if (mapAllColumns || columnsToReadMap.get("D_FLG_GEN_EXT_IDONEO") != null)
			dto.setDFlgGenExtIdoneo(rs.getBigDecimal("D_FLG_GEN_EXT_IDONEO"));

		// colonna [D_FLG_APERTURE_LIBERE]
		if (mapAllColumns || columnsToReadMap.get("D_FLG_APERTURE_LIBERE") != null)
			dto.setDFlgApertureLibere(rs.getBigDecimal("D_FLG_APERTURE_LIBERE"));

		// colonna [D_FLG_APERTURE_ADEG]
		if (mapAllColumns || columnsToReadMap.get("D_FLG_APERTURE_ADEG") != null)
			dto.setDFlgApertureAdeg(rs.getBigDecimal("D_FLG_APERTURE_ADEG"));

		// colonna [D_FLG_SCARICO_IDONEO]
		if (mapAllColumns || columnsToReadMap.get("D_FLG_SCARICO_IDONEO") != null)
			dto.setDFlgScaricoIdoneo(rs.getBigDecimal("D_FLG_SCARICO_IDONEO"));

		// colonna [D_FLG_TEMP_AMB_FUNZ]
		if (mapAllColumns || columnsToReadMap.get("D_FLG_TEMP_AMB_FUNZ") != null)
			dto.setDFlgTempAmbFunz(rs.getBigDecimal("D_FLG_TEMP_AMB_FUNZ"));

		// colonna [D_FLG_ASSENZA_PERD_COMB]
		if (mapAllColumns || columnsToReadMap.get("D_FLG_ASSENZA_PERD_COMB") != null)
			dto.setDFlgAssenzaPerdComb(rs.getBigDecimal("D_FLG_ASSENZA_PERD_COMB"));

		// colonna [D_FLG_IDO_TEN_IMP_INT]
		if (mapAllColumns || columnsToReadMap.get("D_FLG_IDO_TEN_IMP_INT") != null)
			dto.setDFlgIdoTenImpInt(rs.getBigDecimal("D_FLG_IDO_TEN_IMP_INT"));

		// colonna [F_FLG_ADOZIONE_VALVOLE_TERM]
		if (mapAllColumns || columnsToReadMap.get("F_FLG_ADOZIONE_VALVOLE_TERM") != null)
			dto.setFFlgAdozioneValvoleTerm(rs.getBigDecimal("F_FLG_ADOZIONE_VALVOLE_TERM"));

		// colonna [F_FLG_ISOLAMENTE_RETE]
		if (mapAllColumns || columnsToReadMap.get("F_FLG_ISOLAMENTE_RETE") != null)
			dto.setFFlgIsolamenteRete(rs.getBigDecimal("F_FLG_ISOLAMENTE_RETE"));

		// colonna [F_FLG_ADOZ_SIST_TRATTAM_H2O]
		if (mapAllColumns || columnsToReadMap.get("F_FLG_ADOZ_SIST_TRATTAM_H2O") != null)
			dto.setFFlgAdozSistTrattamH2o(rs.getBigDecimal("F_FLG_ADOZ_SIST_TRATTAM_H2O"));

		// colonna [F_FLG_SOSTITUZ_SIST_REGOLAZ]
		if (mapAllColumns || columnsToReadMap.get("F_FLG_SOSTITUZ_SIST_REGOLAZ") != null)
			dto.setFFlgSostituzSistRegolaz(rs.getBigDecimal("F_FLG_SOSTITUZ_SIST_REGOLAZ"));

		// colonna [C_FLG_TRATT_CLIMA_NON_RICH]
		if (mapAllColumns || columnsToReadMap.get("C_FLG_TRATT_CLIMA_NON_RICH") != null)
			dto.setCFlgTrattClimaNonRich(rs.getBigDecimal("C_FLG_TRATT_CLIMA_NON_RICH"));

		// colonna [C_FLG_TRATT_ACS_NON_RICHIESTO]
		if (mapAllColumns || columnsToReadMap.get("C_FLG_TRATT_ACS_NON_RICHIESTO") != null)
			dto.setCFlgTrattAcsNonRichiesto(rs.getBigDecimal("C_FLG_TRATT_ACS_NON_RICHIESTO"));

		// colonna [ID_STELLE]
		if (mapAllColumns || columnsToReadMap.get("ID_STELLE") != null)
			dto.setIdStelle(rs.getBigDecimal("ID_STELLE"));

		// colonna [ID_TIPO_1B]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_1B") != null)
			dto.setIdTipo1b(rs.getBigDecimal("ID_TIPO_1B"));

		// colonna [ID_ARIA_COMBURENTE]
		if (mapAllColumns || columnsToReadMap.get("ID_ARIA_COMBURENTE") != null)
			dto.setIdAriaComburente(rs.getBigDecimal("ID_ARIA_COMBURENTE"));

		// colonna [ID_CONTROLLO_ARIA]
		if (mapAllColumns || columnsToReadMap.get("ID_CONTROLLO_ARIA") != null)
			dto.setIdControlloAria(rs.getBigDecimal("ID_CONTROLLO_ARIA"));

		// colonna [ID_TIPO_CARIC_COMBU]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_CARIC_COMBU") != null)
			dto.setIdTipoCaricCombu(rs.getBigDecimal("ID_TIPO_CARIC_COMBU"));

		// colonna [D_1B_FLG_PULIZIA_CAMINO]
		if (mapAllColumns || columnsToReadMap.get("D_1B_FLG_PULIZIA_CAMINO") != null)
			dto.setD1bFlgPuliziaCamino(rs.getBigDecimal("D_1B_FLG_PULIZIA_CAMINO"));

		// colonna [E_1B_FLG_CALDAIA]
		if (mapAllColumns || columnsToReadMap.get("E_1B_FLG_CALDAIA") != null)
			dto.setE1bFlgCaldaia(rs.getBigDecimal("E_1B_FLG_CALDAIA"));

		// colonna [E_1B_FLG_STUFA]
		if (mapAllColumns || columnsToReadMap.get("E_1B_FLG_STUFA") != null)
			dto.setE1bFlgStufa(rs.getBigDecimal("E_1B_FLG_STUFA"));

		// colonna [E_1B_FLG_STUFA_ACCUMULO]
		if (mapAllColumns || columnsToReadMap.get("E_1B_FLG_STUFA_ACCUMULO") != null)
			dto.setE1bFlgStufaAccumulo(rs.getBigDecimal("E_1B_FLG_STUFA_ACCUMULO"));

		// colonna [E_1B_FLG_TERMOCUCINA]
		if (mapAllColumns || columnsToReadMap.get("E_1B_FLG_TERMOCUCINA") != null)
			dto.setE1bFlgTermocucina(rs.getBigDecimal("E_1B_FLG_TERMOCUCINA"));

		// colonna [E_1B_FLG_CAMINETTO_APERTO]
		if (mapAllColumns || columnsToReadMap.get("E_1B_FLG_CAMINETTO_APERTO") != null)
			dto.setE1bFlgCaminettoAperto(rs.getBigDecimal("E_1B_FLG_CAMINETTO_APERTO"));

		// colonna [E_1B_FLG_CAMINETTO_CHIUSO]
		if (mapAllColumns || columnsToReadMap.get("E_1B_FLG_CAMINETTO_CHIUSO") != null)
			dto.setE1bFlgCaminettoChiuso(rs.getBigDecimal("E_1B_FLG_CAMINETTO_CHIUSO"));

		// colonna [E_1B_FLG_INSERTO_CAMINETTO]
		if (mapAllColumns || columnsToReadMap.get("E_1B_FLG_INSERTO_CAMINETTO") != null)
			dto.setE1bFlgInsertoCaminetto(rs.getBigDecimal("E_1B_FLG_INSERTO_CAMINETTO"));

		// colonna [E_1B_FLG_STUFA_ASSEMBLATA]
		if (mapAllColumns || columnsToReadMap.get("E_1B_FLG_STUFA_ASSEMBLATA") != null)
			dto.setE1bFlgStufaAssemblata(rs.getBigDecimal("E_1B_FLG_STUFA_ASSEMBLATA"));

		// colonna [E_1B_FLG_STUFA_PELLET]
		if (mapAllColumns || columnsToReadMap.get("E_1B_FLG_STUFA_PELLET") != null)
			dto.setE1bFlgStufaPellet(rs.getBigDecimal("E_1B_FLG_STUFA_PELLET"));

		// colonna [E_1B_FLG_MARCATURA_CE]
		if (mapAllColumns || columnsToReadMap.get("E_1B_FLG_MARCATURA_CE") != null)
			dto.setE1bFlgMarcaturaCe(rs.getBigDecimal("E_1B_FLG_MARCATURA_CE"));

		// colonna [E_1B_FLG_PLACCA_CAMINO]
		if (mapAllColumns || columnsToReadMap.get("E_1B_FLG_PLACCA_CAMINO") != null)
			dto.setE1bFlgPlaccaCamino(rs.getBigDecimal("E_1B_FLG_PLACCA_CAMINO"));

		return dto;
	}

}
