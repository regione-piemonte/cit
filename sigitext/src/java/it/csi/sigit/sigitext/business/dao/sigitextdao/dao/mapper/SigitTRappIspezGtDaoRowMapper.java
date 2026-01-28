package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTRappIspezGtDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTRappIspezGtDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappIspezGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappIspezGtPk;

public class SigitTRappIspezGtDaoRowMapper  extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 *
	 * @generated
	 */
	SigitTRappIspezGtDaoImpl dao;

	/**
	 * costruttore
	 *
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *                      incomplete, esempio distinct, custom select...) nella classe padre
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
	 * @return SigitTRappDettaglioDto
	 * @throws SQLException
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTRappIspezGtDto) {
			return mapRow_internal((SigitTRappIspezGtDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTRappIspezGtDto mapRow_internal(SigitTRappIspezGtDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitTRappIspezGtDto dto = objectToFill;

		// colonna [ID_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("ID_ALLEGATO") != null ) {
			SigitTRappIspezGtPk sigitTRappIspezGtPk = new SigitTRappIspezGtPk();
			sigitTRappIspezGtPk.setIdAllegato(rs.getBigDecimal("ID_ALLEGATO"));
		}
		if (mapAllColumns || columnsToReadMap.get("S1C_FLG_REE_INVIATO") != null )
			dto.setS1cFlgReeInviato(rs.getInt("S1C_FLG_REE_INVIATO"));
		if (mapAllColumns || columnsToReadMap.get("S1C_FLG_REE_BOLLINO") != null )
			dto.setS1cFlgReeBollino(rs.getInt("S1C_FLG_REE_BOLLINO"));			
		if (mapAllColumns || columnsToReadMap.get("S1C_SIGLA_BOLLINO") != null )
			dto.setS1cSiglaBollino(rs.getString("S1C_SIGLA_BOLLINO"));
		if (mapAllColumns || columnsToReadMap.get("S1C_NUM_BOLLINO") != null )
			dto.setS1cNumBollino(rs.getBigDecimal("S1C_NUM_BOLLINO"));
		if (mapAllColumns || columnsToReadMap.get("S1E_DT_PRIMA_INSTALLAZIONE") != null )
			dto.setS1eDtPrimaInstallazione(rs.getDate("S1E_DT_PRIMA_INSTALLAZIONE"));
		if (mapAllColumns || columnsToReadMap.get("S1E_POT_FOCOLARE_KW") != null )
			dto.setS1ePotFocolareKw(rs.getBigDecimal("S1E_POT_FOCOLARE_KW"));
		if (mapAllColumns || columnsToReadMap.get("S1E_POT_UTILE_KW") != null )
			dto.setS1ePotUtileKw(rs.getBigDecimal("S1E_POT_UTILE_KW"));
		if (mapAllColumns || columnsToReadMap.get("S1L_DENOM_DELEGATO") != null )
			dto.setS1lDenomDelegato(rs.getString("S1L_DENOM_DELEGATO"));
		if (mapAllColumns || columnsToReadMap.get("S1L_FLG_DELEGA") != null )
			dto.setS1lFlgDelega(rs.getInt("S1L_FLG_DELEGA"));
		if (mapAllColumns || columnsToReadMap.get("S2B1_FLG_TERMO_CONTAB") != null )
			dto.setS2b1FlgTermoContab(rs.getInt("S2B1_FLG_TERMO_CONTAB"));
		if (mapAllColumns || columnsToReadMap.get("S2B2_FLG_UNI_10200") != null )
			dto.setS2b2FlgUni10200(rs.getInt("S2B2_FLG_UNI_10200"));
		if (mapAllColumns || columnsToReadMap.get("S2F_FLG_TRATT_CLIMA_NON_RICH") != null )
			dto.setS2fFlgTrattClimaNonRich(rs.getInt("S2F_FLG_TRATT_CLIMA_NON_RICH"));
		if (mapAllColumns || columnsToReadMap.get("S2F_FLG_TRATT_ACS_NON_RICH") != null )
			dto.setS2fFlgTrattAcsNonRich(rs.getInt("S2F_FLG_TRATT_ACS_NON_RICH"));
		if (mapAllColumns || columnsToReadMap.get("S3A_FLG_LOCALE_INT_IDONEO") != null )
			dto.setS3aFlgLocaleIntIdoneo(rs.getInt("S3A_FLG_LOCALE_INT_IDONEO"));
		if (mapAllColumns || columnsToReadMap.get("S3B_FLG_GEN_EXT_IDONEO") != null )
			dto.setS3bFlgGenExtIdoneo(rs.getInt("S3B_FLG_GEN_EXT_IDONEO"));
		if (mapAllColumns || columnsToReadMap.get("S3C_FLG_VENTILAZ_SUFF") != null )
			dto.setS3cFlgVentilazSuff(rs.getInt("S3C_FLG_VENTILAZ_SUFF"));
		if (mapAllColumns || columnsToReadMap.get("S3D_FLG_EVAC_FUMI_IDONEO") != null )
			dto.setS3dFlgEvacFumiIdoneo(rs.getInt("S3D_FLG_EVAC_FUMI_IDONEO"));
		if (mapAllColumns || columnsToReadMap.get("S3E_FLG_CARTELLI_PRESENTI") != null )
			dto.setS3eFlgCartelliPresenti(rs.getInt("S3E_FLG_CARTELLI_PRESENTI"));
		if (mapAllColumns || columnsToReadMap.get("S3F_FLG_ESTINZ_PRESENTI") != null )
			dto.setS3fFlgEstinzPresenti(rs.getInt("S3F_FLG_ESTINZ_PRESENTI"));
		if (mapAllColumns || columnsToReadMap.get("S3G_FLG_INTERR_GEN_PRESENTI") != null )
			dto.setS3gFlgInterrGenPresenti(rs.getInt("S3G_FLG_INTERR_GEN_PRESENTI"));
		if (mapAllColumns || columnsToReadMap.get("S3H_FLG_RUBIN_PRESENTE") != null )
			dto.setS3hFlgRubinPresente(rs.getInt("S3H_FLG_RUBIN_PRESENTE"));
		if (mapAllColumns || columnsToReadMap.get("S3I_FLG_ASSENZA_PERD_COMB") != null )
			dto.setS3iFlgAssenzaPerdComb(rs.getInt("S3I_FLG_ASSENZA_PERD_COMB"));
		if (mapAllColumns || columnsToReadMap.get("S3J_FLG_TEMP_AMB_FUNZ") != null )
			dto.setS3jFlgTempAmbFunz(rs.getInt("S3J_FLG_TEMP_AMB_FUNZ"));
		if (mapAllColumns || columnsToReadMap.get("S3K_FLG_DM_1_12_1975") != null )
			dto.setS3kFlgDm1121975(rs.getInt("S3K_FLG_DM_1_12_1975"));
		if (mapAllColumns || columnsToReadMap.get("S4A_FLG_LIB_IMP_PRESENTE") != null )
			dto.setS4aFlgLibImpPresente(rs.getInt("S4A_FLG_LIB_IMP_PRESENTE"));
		if (mapAllColumns || columnsToReadMap.get("S4B_FLG_LIB_COMPILATO") != null )
			dto.setS4bFlgLibCompilato(rs.getInt("S4B_FLG_LIB_COMPILATO"));
		if (mapAllColumns || columnsToReadMap.get("S4C_FLG_CONFORMITA_PRESENTE") != null )
			dto.setS4cFlgConformitaPresente(rs.getInt("S4C_FLG_CONFORMITA_PRESENTE"));
		if (mapAllColumns || columnsToReadMap.get("S4D_FLG_LIB_USO_PRESENTE") != null )
			dto.setS4dFlgLibUsoPresente(rs.getInt("S4D_FLG_LIB_USO_PRESENTE"));
		if (mapAllColumns || columnsToReadMap.get("S4E_FLG_PRATICA_VVF_PRESENTE") != null )
			dto.setS4eFlgPraticaVvfPresente(rs.getInt("S4E_FLG_PRATICA_VVF_PRESENTE"));
		if (mapAllColumns || columnsToReadMap.get("S4F_FLG_PRATICA_INAIL_PRESENTE") != null )
			dto.setS4fFlgPraticaInailPresente(rs.getInt("S4F_FLG_PRATICA_INAIL_PRESENTE"));
		if (mapAllColumns || columnsToReadMap.get("S4G_FLG_DM12_1975") != null )
			dto.setS4gFlgDm121975(rs.getInt("S4G_FLG_DM12_1975"));
		if (mapAllColumns || columnsToReadMap.get("S4G_MATRICOLA_DM_1_12_1975") != null )
			dto.setS4gMatricolaDm1121975(rs.getString("S4G_MATRICOLA_DM_1_12_1975"));
		if (mapAllColumns || columnsToReadMap.get("S5A_FLG_ADOZIONE_VALVOLE_TERM") != null )
			dto.setS5aFlgAdozioneValvoleTerm(rs.getInt("S5A_FLG_ADOZIONE_VALVOLE_TERM"));
		if (mapAllColumns || columnsToReadMap.get("S5A_FLG_ISOLAMENTE_RETE") != null )
			dto.setS5aFlgIsolamenteRete(rs.getInt("S5A_FLG_ISOLAMENTE_RETE"));
		if (mapAllColumns || columnsToReadMap.get("S5A_FLG_ADOZ_SIST_TRATTAM_H2O") != null )
			dto.setS5aFlgAdozSistTrattamH2o(rs.getInt("S5A_FLG_ADOZ_SIST_TRATTAM_H2O"));
		if (mapAllColumns || columnsToReadMap.get("S5A_FLG_SOSTITUZ_SIST_REGOLAZ") != null )
			dto.setS5aFlgSostituzSistRegolaz(rs.getInt("S5A_FLG_SOSTITUZ_SIST_REGOLAZ"));
		if (mapAllColumns || columnsToReadMap.get("S5B_FLG_NO_INTERV_CONV") != null )
			dto.setS5bFlgNoIntervConv(rs.getInt("S5B_FLG_NO_INTERV_CONV"));
		if (mapAllColumns || columnsToReadMap.get("S5B_FLG_RELAZ_DETTAGLIO") != null )
			dto.setS5bFlgRelazDettaglio(rs.getInt("S5B_FLG_RELAZ_DETTAGLIO"));
		if (mapAllColumns || columnsToReadMap.get("S5B_FLG_RELAZ_DETTAGLIO_SUCC") != null )
			dto.setS5bFlgRelazDettaglioSucc(rs.getInt("S5B_FLG_RELAZ_DETTAGLIO_SUCC"));
		if (mapAllColumns || columnsToReadMap.get("S5B_FLG_VALUTAZ_NON_ESEGUITA") != null )
			dto.setS5bFlgValutazNonEseguita(rs.getInt("S5B_FLG_VALUTAZ_NON_ESEGUITA"));
		if (mapAllColumns || columnsToReadMap.get("S5B_MOTIVO_RELAZ_NON_ESEG") != null )
			dto.setS5bMotivoRelazNonEseg(rs.getString("S5B_MOTIVO_RELAZ_NON_ESEG"));
		if (mapAllColumns || columnsToReadMap.get("S5C_FLG_DIMENS_CORRETTO") != null )
			dto.setS5cFlgDimensCorretto(rs.getInt("S5C_FLG_DIMENS_CORRETTO"));
		if (mapAllColumns || columnsToReadMap.get("S5C_FLG_DIMENS_NON_CONTROLL") != null )
			dto.setS5cFlgDimensNonControll(rs.getInt("S5C_FLG_DIMENS_NON_CONTROLL"));
		if (mapAllColumns || columnsToReadMap.get("S5C_FLG_DIMENS_RELAZ_SUCCES") != null )
			dto.setS5cFlgDimensRelazSucces(rs.getInt("S5C_FLG_DIMENS_RELAZ_SUCCES"));
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null )
			dto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null )
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));
		if (mapAllColumns || columnsToReadMap.get("S1C_DATA_REE") != null )
			dto.setS1cDataRee(rs.getDate("S1C_DATA_REE"));
		if (mapAllColumns || columnsToReadMap.get("S5C_FLG_DIMENS_NON_CORRETTO") != null )
			dto.setS5cFlgDimensNonCorretto(rs.getInt("S5C_FLG_DIMENS_NON_CORRETTO"));

		return dto;
	}

}
