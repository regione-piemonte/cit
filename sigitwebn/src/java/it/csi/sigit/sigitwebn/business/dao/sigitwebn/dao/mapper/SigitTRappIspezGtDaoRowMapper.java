package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTRappIspezGtDao
 * @generated
 */
public class SigitTRappIspezGtDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTRappIspezGtDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTRappIspezGtDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTRappIspezGtDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTRappIspezGtDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTRappIspezGtDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTRappIspezGtDto) {
			return mapRow_internal((SigitTRappIspezGtDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTRappIspezGtDto mapRow_internal(SigitTRappIspezGtDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTRappIspezGtDto dto = objectToFill;

		// colonna [ID_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("ID_ALLEGATO") != null)
			dto.setIdAllegato(rs.getBigDecimal("ID_ALLEGATO"));

		// colonna [S1C_FLG_REE_INVIATO]
		if (mapAllColumns || columnsToReadMap.get("S1C_FLG_REE_INVIATO") != null)
			dto.setS1cFlgReeInviato(rs.getBigDecimal("S1C_FLG_REE_INVIATO"));

		// colonna [S1C_FLG_REE_BOLLINO]
		if (mapAllColumns || columnsToReadMap.get("S1C_FLG_REE_BOLLINO") != null)
			dto.setS1cFlgReeBollino(rs.getBigDecimal("S1C_FLG_REE_BOLLINO"));

		// colonna [S1C_SIGLA_BOLLINO]
		if (mapAllColumns || columnsToReadMap.get("S1C_SIGLA_BOLLINO") != null)
			dto.setS1cSiglaBollino(rs.getString("S1C_SIGLA_BOLLINO"));

		// colonna [S1C_NUM_BOLLINO]
		if (mapAllColumns || columnsToReadMap.get("S1C_NUM_BOLLINO") != null)
			dto.setS1cNumBollino(rs.getBigDecimal("S1C_NUM_BOLLINO"));

		// colonna [S1E_DT_PRIMA_INSTALLAZIONE]
		if (mapAllColumns || columnsToReadMap.get("S1E_DT_PRIMA_INSTALLAZIONE") != null)
			dto.setS1eDtPrimaInstallazione(rs.getDate("S1E_DT_PRIMA_INSTALLAZIONE"));

		// colonna [S1E_POT_FOCOLARE_KW]
		if (mapAllColumns || columnsToReadMap.get("S1E_POT_FOCOLARE_KW") != null)
			dto.setS1ePotFocolareKw(rs.getBigDecimal("S1E_POT_FOCOLARE_KW"));

		// colonna [S1E_POT_UTILE_KW]
		if (mapAllColumns || columnsToReadMap.get("S1E_POT_UTILE_KW") != null)
			dto.setS1ePotUtileKw(rs.getBigDecimal("S1E_POT_UTILE_KW"));

		// colonna [S1L_DENOM_DELEGATO]
		if (mapAllColumns || columnsToReadMap.get("S1L_DENOM_DELEGATO") != null)
			dto.setS1lDenomDelegato(rs.getString("S1L_DENOM_DELEGATO"));

		// colonna [S1L_FLG_DELEGA]
		if (mapAllColumns || columnsToReadMap.get("S1L_FLG_DELEGA") != null)
			dto.setS1lFlgDelega(rs.getBigDecimal("S1L_FLG_DELEGA"));

		// colonna [S2B1_FLG_TERMO_CONTAB]
		if (mapAllColumns || columnsToReadMap.get("S2B1_FLG_TERMO_CONTAB") != null)
			dto.setS2b1FlgTermoContab(rs.getBigDecimal("S2B1_FLG_TERMO_CONTAB"));

		// colonna [S2B2_FLG_UNI_10200]
		if (mapAllColumns || columnsToReadMap.get("S2B2_FLG_UNI_10200") != null)
			dto.setS2b2FlgUni10200(rs.getBigDecimal("S2B2_FLG_UNI_10200"));

		// colonna [S2F_FLG_TRATT_CLIMA_NON_RICH]
		if (mapAllColumns || columnsToReadMap.get("S2F_FLG_TRATT_CLIMA_NON_RICH") != null)
			dto.setS2fFlgTrattClimaNonRich(rs.getBigDecimal("S2F_FLG_TRATT_CLIMA_NON_RICH"));

		// colonna [S2F_FLG_TRATT_ACS_NON_RICH]
		if (mapAllColumns || columnsToReadMap.get("S2F_FLG_TRATT_ACS_NON_RICH") != null)
			dto.setS2fFlgTrattAcsNonRich(rs.getBigDecimal("S2F_FLG_TRATT_ACS_NON_RICH"));

		// colonna [S3A_FLG_LOCALE_INT_IDONEO]
		if (mapAllColumns || columnsToReadMap.get("S3A_FLG_LOCALE_INT_IDONEO") != null)
			dto.setS3aFlgLocaleIntIdoneo(rs.getBigDecimal("S3A_FLG_LOCALE_INT_IDONEO"));

		// colonna [S3B_FLG_GEN_EXT_IDONEO]
		if (mapAllColumns || columnsToReadMap.get("S3B_FLG_GEN_EXT_IDONEO") != null)
			dto.setS3bFlgGenExtIdoneo(rs.getBigDecimal("S3B_FLG_GEN_EXT_IDONEO"));

		// colonna [S3C_FLG_VENTILAZ_SUFF]
		if (mapAllColumns || columnsToReadMap.get("S3C_FLG_VENTILAZ_SUFF") != null)
			dto.setS3cFlgVentilazSuff(rs.getBigDecimal("S3C_FLG_VENTILAZ_SUFF"));

		// colonna [S3D_FLG_EVAC_FUMI_IDONEO]
		if (mapAllColumns || columnsToReadMap.get("S3D_FLG_EVAC_FUMI_IDONEO") != null)
			dto.setS3dFlgEvacFumiIdoneo(rs.getBigDecimal("S3D_FLG_EVAC_FUMI_IDONEO"));

		// colonna [S3E_FLG_CARTELLI_PRESENTI]
		if (mapAllColumns || columnsToReadMap.get("S3E_FLG_CARTELLI_PRESENTI") != null)
			dto.setS3eFlgCartelliPresenti(rs.getBigDecimal("S3E_FLG_CARTELLI_PRESENTI"));

		// colonna [S3F_FLG_ESTINZ_PRESENTI]
		if (mapAllColumns || columnsToReadMap.get("S3F_FLG_ESTINZ_PRESENTI") != null)
			dto.setS3fFlgEstinzPresenti(rs.getBigDecimal("S3F_FLG_ESTINZ_PRESENTI"));

		// colonna [S3G_FLG_INTERR_GEN_PRESENTI]
		if (mapAllColumns || columnsToReadMap.get("S3G_FLG_INTERR_GEN_PRESENTI") != null)
			dto.setS3gFlgInterrGenPresenti(rs.getBigDecimal("S3G_FLG_INTERR_GEN_PRESENTI"));

		// colonna [S3H_FLG_RUBIN_PRESENTE]
		if (mapAllColumns || columnsToReadMap.get("S3H_FLG_RUBIN_PRESENTE") != null)
			dto.setS3hFlgRubinPresente(rs.getBigDecimal("S3H_FLG_RUBIN_PRESENTE"));

		// colonna [S3I_FLG_ASSENZA_PERD_COMB]
		if (mapAllColumns || columnsToReadMap.get("S3I_FLG_ASSENZA_PERD_COMB") != null)
			dto.setS3iFlgAssenzaPerdComb(rs.getBigDecimal("S3I_FLG_ASSENZA_PERD_COMB"));

		// colonna [S3J_FLG_TEMP_AMB_FUNZ]
		if (mapAllColumns || columnsToReadMap.get("S3J_FLG_TEMP_AMB_FUNZ") != null)
			dto.setS3jFlgTempAmbFunz(rs.getBigDecimal("S3J_FLG_TEMP_AMB_FUNZ"));

		// colonna [S3K_FLG_DM_1_12_1975]
		if (mapAllColumns || columnsToReadMap.get("S3K_FLG_DM_1_12_1975") != null)
			dto.setS3kFlgDm1121975(rs.getBigDecimal("S3K_FLG_DM_1_12_1975"));

		// colonna [S4A_FLG_LIB_IMP_PRESENTE]
		if (mapAllColumns || columnsToReadMap.get("S4A_FLG_LIB_IMP_PRESENTE") != null)
			dto.setS4aFlgLibImpPresente(rs.getBigDecimal("S4A_FLG_LIB_IMP_PRESENTE"));

		// colonna [S4B_FLG_LIB_COMPILATO]
		if (mapAllColumns || columnsToReadMap.get("S4B_FLG_LIB_COMPILATO") != null)
			dto.setS4bFlgLibCompilato(rs.getBigDecimal("S4B_FLG_LIB_COMPILATO"));

		// colonna [S4C_FLG_CONFORMITA_PRESENTE]
		if (mapAllColumns || columnsToReadMap.get("S4C_FLG_CONFORMITA_PRESENTE") != null)
			dto.setS4cFlgConformitaPresente(rs.getBigDecimal("S4C_FLG_CONFORMITA_PRESENTE"));

		// colonna [S4D_FLG_LIB_USO_PRESENTE]
		if (mapAllColumns || columnsToReadMap.get("S4D_FLG_LIB_USO_PRESENTE") != null)
			dto.setS4dFlgLibUsoPresente(rs.getBigDecimal("S4D_FLG_LIB_USO_PRESENTE"));

		// colonna [S4E_FLG_PRATICA_VVF_PRESENTE]
		if (mapAllColumns || columnsToReadMap.get("S4E_FLG_PRATICA_VVF_PRESENTE") != null)
			dto.setS4eFlgPraticaVvfPresente(rs.getBigDecimal("S4E_FLG_PRATICA_VVF_PRESENTE"));

		// colonna [S4F_FLG_PRATICA_INAIL_PRESENTE]
		if (mapAllColumns || columnsToReadMap.get("S4F_FLG_PRATICA_INAIL_PRESENTE") != null)
			dto.setS4fFlgPraticaInailPresente(rs.getBigDecimal("S4F_FLG_PRATICA_INAIL_PRESENTE"));

		// colonna [S4G_FLG_DM12_1975]
		if (mapAllColumns || columnsToReadMap.get("S4G_FLG_DM12_1975") != null)
			dto.setS4gFlgDm121975(rs.getBigDecimal("S4G_FLG_DM12_1975"));

		// colonna [S4G_MATRICOLA_DM_1_12_1975]
		if (mapAllColumns || columnsToReadMap.get("S4G_MATRICOLA_DM_1_12_1975") != null)
			dto.setS4gMatricolaDm1121975(rs.getString("S4G_MATRICOLA_DM_1_12_1975"));

		// colonna [S5A_FLG_ADOZIONE_VALVOLE_TERM]
		if (mapAllColumns || columnsToReadMap.get("S5A_FLG_ADOZIONE_VALVOLE_TERM") != null)
			dto.setS5aFlgAdozioneValvoleTerm(rs.getBigDecimal("S5A_FLG_ADOZIONE_VALVOLE_TERM"));

		// colonna [S5A_FLG_ISOLAMENTE_RETE]
		if (mapAllColumns || columnsToReadMap.get("S5A_FLG_ISOLAMENTE_RETE") != null)
			dto.setS5aFlgIsolamenteRete(rs.getBigDecimal("S5A_FLG_ISOLAMENTE_RETE"));

		// colonna [S5A_FLG_ADOZ_SIST_TRATTAM_H2O]
		if (mapAllColumns || columnsToReadMap.get("S5A_FLG_ADOZ_SIST_TRATTAM_H2O") != null)
			dto.setS5aFlgAdozSistTrattamH2o(rs.getBigDecimal("S5A_FLG_ADOZ_SIST_TRATTAM_H2O"));

		// colonna [S5A_FLG_SOSTITUZ_SIST_REGOLAZ]
		if (mapAllColumns || columnsToReadMap.get("S5A_FLG_SOSTITUZ_SIST_REGOLAZ") != null)
			dto.setS5aFlgSostituzSistRegolaz(rs.getBigDecimal("S5A_FLG_SOSTITUZ_SIST_REGOLAZ"));

		// colonna [S5B_FLG_NO_INTERV_CONV]
		if (mapAllColumns || columnsToReadMap.get("S5B_FLG_NO_INTERV_CONV") != null)
			dto.setS5bFlgNoIntervConv(rs.getBigDecimal("S5B_FLG_NO_INTERV_CONV"));

		// colonna [S5B_FLG_RELAZ_DETTAGLIO]
		if (mapAllColumns || columnsToReadMap.get("S5B_FLG_RELAZ_DETTAGLIO") != null)
			dto.setS5bFlgRelazDettaglio(rs.getBigDecimal("S5B_FLG_RELAZ_DETTAGLIO"));

		// colonna [S5B_FLG_RELAZ_DETTAGLIO_SUCC]
		if (mapAllColumns || columnsToReadMap.get("S5B_FLG_RELAZ_DETTAGLIO_SUCC") != null)
			dto.setS5bFlgRelazDettaglioSucc(rs.getBigDecimal("S5B_FLG_RELAZ_DETTAGLIO_SUCC"));

		// colonna [S5B_FLG_VALUTAZ_NON_ESEGUITA]
		if (mapAllColumns || columnsToReadMap.get("S5B_FLG_VALUTAZ_NON_ESEGUITA") != null)
			dto.setS5bFlgValutazNonEseguita(rs.getBigDecimal("S5B_FLG_VALUTAZ_NON_ESEGUITA"));

		// colonna [S5B_MOTIVO_RELAZ_NON_ESEG]
		if (mapAllColumns || columnsToReadMap.get("S5B_MOTIVO_RELAZ_NON_ESEG") != null)
			dto.setS5bMotivoRelazNonEseg(rs.getString("S5B_MOTIVO_RELAZ_NON_ESEG"));

		// colonna [S5C_FLG_DIMENS_CORRETTO]
		if (mapAllColumns || columnsToReadMap.get("S5C_FLG_DIMENS_CORRETTO") != null)
			dto.setS5cFlgDimensCorretto(rs.getBigDecimal("S5C_FLG_DIMENS_CORRETTO"));

		// colonna [S5C_FLG_DIMENS_NON_CONTROLL]
		if (mapAllColumns || columnsToReadMap.get("S5C_FLG_DIMENS_NON_CONTROLL") != null)
			dto.setS5cFlgDimensNonControll(rs.getBigDecimal("S5C_FLG_DIMENS_NON_CONTROLL"));

		// colonna [S5C_FLG_DIMENS_RELAZ_SUCCES]
		if (mapAllColumns || columnsToReadMap.get("S5C_FLG_DIMENS_RELAZ_SUCCES") != null)
			dto.setS5cFlgDimensRelazSucces(rs.getBigDecimal("S5C_FLG_DIMENS_RELAZ_SUCCES"));

		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		// colonna [S1C_DATA_REE]
		if (mapAllColumns || columnsToReadMap.get("S1C_DATA_REE") != null)
			dto.setS1cDataRee(rs.getDate("S1C_DATA_REE"));

		// colonna [S5C_FLG_DIMENS_NON_CORRETTO]
		if (mapAllColumns || columnsToReadMap.get("S5C_FLG_DIMENS_NON_CORRETTO") != null)
			dto.setS5cFlgDimensNonCorretto(rs.getBigDecimal("S5C_FLG_DIMENS_NON_CORRETTO"));

		return dto;
	}

}
