package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTRappIspezGfDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTRappIspezGfDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappIspezGfDto;

/**
 * RowMapper specifico del DAO SigitTRappIspezGfDao
 * @generated
 */
public class SigitTRappIspezGfDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTRappIspezGfDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTRappIspezGfDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTRappIspezGfDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTRappIspezGfDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTRappIspezGfDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTRappIspezGfDto) {
			return mapRow_internal((SigitTRappIspezGfDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTRappIspezGfDto mapRow_internal(SigitTRappIspezGfDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTRappIspezGfDto dto = objectToFill;

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

		// colonna [S1E_POT_TERMICA_MAX_KW]
		if (mapAllColumns || columnsToReadMap.get("S1E_POT_TERMICA_MAX_KW") != null)
			dto.setS1ePotTermicaMaxKw(rs.getBigDecimal("S1E_POT_TERMICA_MAX_KW"));

		// colonna [S1L_DENOM_DELEGATO]
		if (mapAllColumns || columnsToReadMap.get("S1L_DENOM_DELEGATO") != null)
			dto.setS1lDenomDelegato(rs.getString("S1L_DENOM_DELEGATO"));

		// colonna [S1L_FLG_DELEGA]
		if (mapAllColumns || columnsToReadMap.get("S1L_FLG_DELEGA") != null)
			dto.setS1lFlgDelega(rs.getBigDecimal("S1L_FLG_DELEGA"));

		// colonna [S2E_FLG_TRATT_H2O_NON_RICH]
		if (mapAllColumns || columnsToReadMap.get("S2E_FLG_TRATT_H2O_NON_RICH") != null)
			dto.setS2eFlgTrattH2oNonRich(rs.getBigDecimal("S2E_FLG_TRATT_H2O_NON_RICH"));

		// colonna [S3A_FLG_LOCALE_INT_IDONEO]
		if (mapAllColumns || columnsToReadMap.get("S3A_FLG_LOCALE_INT_IDONEO") != null)
			dto.setS3aFlgLocaleIntIdoneo(rs.getBigDecimal("S3A_FLG_LOCALE_INT_IDONEO"));

		// colonna [S3B_FLG_LINEE_ELETTR_IDONEE]
		if (mapAllColumns || columnsToReadMap.get("S3B_FLG_LINEE_ELETTR_IDONEE") != null)
			dto.setS3bFlgLineeElettrIdonee(rs.getBigDecimal("S3B_FLG_LINEE_ELETTR_IDONEE"));

		// colonna [S3C_FLG_VENTILAZ_ADEGUATE]
		if (mapAllColumns || columnsToReadMap.get("S3C_FLG_VENTILAZ_ADEGUATE") != null)
			dto.setS3cFlgVentilazAdeguate(rs.getBigDecimal("S3C_FLG_VENTILAZ_ADEGUATE"));

		// colonna [S3D_FLG_COIBENTAZIONI_IDONEE]
		if (mapAllColumns || columnsToReadMap.get("S3D_FLG_COIBENTAZIONI_IDONEE") != null)
			dto.setS3dFlgCoibentazioniIdonee(rs.getBigDecimal("S3D_FLG_COIBENTAZIONI_IDONEE"));

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

		// colonna [S5A_FLG_SOSTITUZ_MACCHINE_REG]
		if (mapAllColumns || columnsToReadMap.get("S5A_FLG_SOSTITUZ_MACCHINE_REG") != null)
			dto.setS5aFlgSostituzMacchineReg(rs.getBigDecimal("S5A_FLG_SOSTITUZ_MACCHINE_REG"));

		// colonna [S5A_FLG_SOSTITUZ_SISTEMI_REG]
		if (mapAllColumns || columnsToReadMap.get("S5A_FLG_SOSTITUZ_SISTEMI_REG") != null)
			dto.setS5aFlgSostituzSistemiReg(rs.getBigDecimal("S5A_FLG_SOSTITUZ_SISTEMI_REG"));

		// colonna [S5A_FLG_ISOLAM_RETE_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("S5A_FLG_ISOLAM_RETE_DISTRIB") != null)
			dto.setS5aFlgIsolamReteDistrib(rs.getBigDecimal("S5A_FLG_ISOLAM_RETE_DISTRIB"));

		// colonna [S5A_FLG_ISOLAM_CANALI_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("S5A_FLG_ISOLAM_CANALI_DISTRIB") != null)
			dto.setS5aFlgIsolamCanaliDistrib(rs.getBigDecimal("S5A_FLG_ISOLAM_CANALI_DISTRIB"));

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
