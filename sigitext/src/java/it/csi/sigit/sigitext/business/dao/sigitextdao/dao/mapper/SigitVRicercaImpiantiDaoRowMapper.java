package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitVRicercaImpiantiDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitVRicercaImpiantiDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicercaImpiantiDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SigitVRicercaImpiantiDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {
	SigitVRicercaImpiantiDaoImpl dao;

	public SigitVRicercaImpiantiDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitVRicercaImpiantiDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitVRicercaImpiantiDaoImpl) dao;
	}

	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitVRicercaImpiantiDto) {
			return mapRow_internal((SigitVRicercaImpiantiDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitVRicercaImpiantiDto mapRow_internal(SigitVRicercaImpiantiDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitVRicercaImpiantiDto dto = objectToFill;

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [ISTAT_COMUNE]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE") != null)
			dto.setIstatComune(rs.getString("ISTAT_COMUNE"));

		// colonna [DENOMINAZIONE_COMUNE]
		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE_COMUNE") != null)
			dto.setDenominazioneComune(rs.getString("DENOMINAZIONE_COMUNE"));

		// colonna [SIGLA_PROVINCIA]
		if (mapAllColumns || columnsToReadMap.get("SIGLA_PROVINCIA") != null)
			dto.setSiglaProvincia(rs.getString("SIGLA_PROVINCIA"));

		// colonna [DENOMINAZIONE_PROVINCIA]
		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE_PROVINCIA") != null)
			dto.setDenominazioneProvincia(rs.getString("DENOMINAZIONE_PROVINCIA"));

		// colonna [FK_STATO]
		if (mapAllColumns || columnsToReadMap.get("FK_STATO") != null)
			dto.setFkStato(rs.getBigDecimal("FK_STATO"));

		// colonna [L1_3_POT_H2O_KW]
		if (mapAllColumns || columnsToReadMap.get("L1_3_POT_H2O_KW") != null)
			dto.setL13PotH2oKw(rs.getBigDecimal("L1_3_POT_H2O_KW"));

		// colonna [L1_3_POT_CLIMA_INV_KW]
		if (mapAllColumns || columnsToReadMap.get("L1_3_POT_CLIMA_INV_KW") != null)
			dto.setL13PotClimaInvKw(rs.getBigDecimal("L1_3_POT_CLIMA_INV_KW"));

		// colonna [L1_3_POT_CLIMA_EST_KW]
		if (mapAllColumns || columnsToReadMap.get("L1_3_POT_CLIMA_EST_KW") != null)
			dto.setL13PotClimaEstKw(rs.getBigDecimal("L1_3_POT_CLIMA_EST_KW"));

		// colonna [FLG_NOPDR]
		if (mapAllColumns || columnsToReadMap.get("FLG_NOPDR") != null)
			dto.setFlgNopdr(rs.getBigDecimal("FLG_NOPDR"));

		// colonna [INDIRIZZO_UNITA_IMMOB]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_UNITA_IMMOB") != null)
			dto.setIndirizzoUnitaImmob(rs.getString("INDIRIZZO_UNITA_IMMOB"));

		// colonna [CIVICO]
		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("CIVICO"));

		// colonna [SEZIONE]
		if (mapAllColumns || columnsToReadMap.get("SEZIONE") != null)
			dto.setSezione(rs.getString("SEZIONE"));

		// colonna [FOGLIO]
		if (mapAllColumns || columnsToReadMap.get("FOGLIO") != null)
			dto.setFoglio(rs.getString("FOGLIO"));

		// colonna [PARTICELLA]
		if (mapAllColumns || columnsToReadMap.get("PARTICELLA") != null)
			dto.setParticella(rs.getString("PARTICELLA"));

		// colonna [SUBALTERNO]
		if (mapAllColumns || columnsToReadMap.get("SUBALTERNO") != null)
			dto.setSubalterno(rs.getString("SUBALTERNO"));

		// colonna [POD_ELETTRICO]
		if (mapAllColumns || columnsToReadMap.get("POD_ELETTRICO") != null)
			dto.setPodElettrico(rs.getString("POD_ELETTRICO"));

		// colonna [PDR_GAS]
		if (mapAllColumns || columnsToReadMap.get("PDR_GAS") != null)
			dto.setPdrGas(rs.getString("PDR_GAS"));

		// colonna [ID_PF_RESPONSABILE]
		if (mapAllColumns || columnsToReadMap.get("ID_PF_RESPONSABILE") != null)
			dto.setIdPfResponsabile(rs.getBigDecimal("ID_PF_RESPONSABILE"));

		// colonna [ID_PG_RESPONSABILE]
		if (mapAllColumns || columnsToReadMap.get("ID_PG_RESPONSABILE") != null)
			dto.setIdPgResponsabile(rs.getBigDecimal("ID_PG_RESPONSABILE"));

		// colonna [DENOMINAZIONE_RESPONSABILE]
		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE_RESPONSABILE") != null)
			dto.setDenominazioneResponsabile(rs.getString("DENOMINAZIONE_RESPONSABILE"));

		// colonna [DENOMINAZIONE_3_RESPONSABILE]
		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE_3_RESPONSABILE") != null)
			dto.setDenominazione3Responsabile(rs.getString("DENOMINAZIONE_3_RESPONSABILE"));

		// colonna [SIGLA_REA_3R]
		if (mapAllColumns || columnsToReadMap.get("SIGLA_REA_3R") != null)
			dto.setSiglaRea3r(rs.getString("SIGLA_REA_3R"));

		// colonna [NUMERO_REA_3R]
		if (mapAllColumns || columnsToReadMap.get("NUMERO_REA_3R") != null)
			dto.setNumeroRea3r(rs.getBigDecimal("NUMERO_REA_3R"));

		// colonna [CODICE_FISCALE_3R]
		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE_3R") != null)
			dto.setCodiceFiscale3r(rs.getString("CODICE_FISCALE_3R"));

		// colonna [CODICE_FISCALE]
		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setCodiceFiscale(rs.getString("CODICE_FISCALE"));

		// colonna [DATA_FINE_PFPG]
		if (mapAllColumns || columnsToReadMap.get("DATA_FINE_PFPG") != null)
			dto.setDataFinePfpg(rs.getDate("DATA_FINE_PFPG"));

		// colonna [RUOLO_RESPONSABILE]
		if (mapAllColumns || columnsToReadMap.get("RUOLO_RESPONSABILE") != null)
			dto.setRuoloResponsabile(rs.getString("RUOLO_RESPONSABILE"));

		// colonna [RUOLO_FUNZ]
		if (mapAllColumns || columnsToReadMap.get("RUOLO_FUNZ") != null)
			dto.setRuoloFunz(rs.getString("RUOLO_FUNZ"));

		// colonna [FLG_TIPO_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("FLG_TIPO_IMPIANTO") != null)
			dto.setFlgTipoImpianto(rs.getString("FLG_TIPO_IMPIANTO"));

		// colonna [FLG_APPARECC_UI_EXT]
		if (mapAllColumns || columnsToReadMap.get("FLG_APPARECC_UI_EXT") != null)
			dto.setFlgAppareccUiExt(rs.getBigDecimal("FLG_APPARECC_UI_EXT"));

		// colonna [FLG_CONTABILIZZAZIONE]
		if (mapAllColumns || columnsToReadMap.get("FLG_CONTABILIZZAZIONE") != null)
			dto.setFlgContabilizzazione(rs.getBigDecimal("FLG_CONTABILIZZAZIONE"));

		// colonna [DES_STATO]
		if (mapAllColumns || columnsToReadMap.get("DES_STATO") != null)
			dto.setDesStato(rs.getString("DES_STATO"));

		// colonna [FLG_VISU_PROPRIETARIO]
		if (mapAllColumns || columnsToReadMap.get("FLG_VISU_PROPRIETARIO") != null)
			dto.setFlgVisuProprietario(rs.getBigDecimal("FLG_VISU_PROPRIETARIO"));

		return dto;
	}

}