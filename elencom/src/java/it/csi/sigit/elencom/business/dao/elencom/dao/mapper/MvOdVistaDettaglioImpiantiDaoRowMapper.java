package it.csi.sigit.elencom.business.dao.elencom.dao.mapper;

import it.csi.sigit.elencom.business.dao.elencom.dto.*;
import it.csi.sigit.elencom.business.dao.elencom.dao.*;
import it.csi.sigit.elencom.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.elencom.business.dao.elencom.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO MvOdVistaDettaglioImpiantiDao
 * @generated
 */
public class MvOdVistaDettaglioImpiantiDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	MvOdVistaDettaglioImpiantiDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public MvOdVistaDettaglioImpiantiDaoRowMapper(String[] columnsToRead, Class dtoClass,
			MvOdVistaDettaglioImpiantiDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (MvOdVistaDettaglioImpiantiDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return MvOdVistaDettaglioImpiantiDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof MvOdVistaDettaglioImpiantiDto) {
			return mapRow_internal((MvOdVistaDettaglioImpiantiDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public MvOdVistaDettaglioImpiantiDto mapRow_internal(MvOdVistaDettaglioImpiantiDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		MvOdVistaDettaglioImpiantiDto dto = objectToFill;

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [DENOMINAZIONE_COMUNE]
		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE_COMUNE") != null)
			dto.setDenominazioneComune(rs.getString("DENOMINAZIONE_COMUNE"));

		// colonna [DENOMINAZIONE_PROVINCIA]
		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE_PROVINCIA") != null)
			dto.setDenominazioneProvincia(rs.getString("DENOMINAZIONE_PROVINCIA"));

		// colonna [L1_2_FK_CATEGORIA]
		if (mapAllColumns || columnsToReadMap.get("L1_2_FK_CATEGORIA") != null)
			dto.setL12FkCategoria(rs.getString("L1_2_FK_CATEGORIA"));

		// colonna [L1_2_VOL_RISC_M3]
		if (mapAllColumns || columnsToReadMap.get("L1_2_VOL_RISC_M3") != null)
			dto.setL12VolRiscM3(rs.getBigDecimal("L1_2_VOL_RISC_M3"));

		// colonna [L1_2_VOL_RAFF_M3]
		if (mapAllColumns || columnsToReadMap.get("L1_2_VOL_RAFF_M3") != null)
			dto.setL12VolRaffM3(rs.getBigDecimal("L1_2_VOL_RAFF_M3"));

		// colonna [l1_3_pot_h2o_kw]
		if (mapAllColumns || columnsToReadMap.get("l1_3_pot_h2o_kw") != null)
			dto.setL13PotH2oKw(rs.getBigDecimal("l1_3_pot_h2o_kw"));

		// colonna [l1_3_pot_clima_inv_kw]
		if (mapAllColumns || columnsToReadMap.get("l1_3_pot_clima_inv_kw") != null)
			dto.setL13PotClimaInvKw(rs.getBigDecimal("l1_3_pot_clima_inv_kw"));

		// colonna [l1_3_pot_clima_est_kw]
		if (mapAllColumns || columnsToReadMap.get("l1_3_pot_clima_est_kw") != null)
			dto.setL13PotClimaEstKw(rs.getBigDecimal("l1_3_pot_clima_est_kw"));

		// colonna [tipo_componente]
		if (mapAllColumns || columnsToReadMap.get("tipo_componente") != null)
			dto.setTipoComponente(rs.getString("tipo_componente"));

		// colonna [progressivo]
		if (mapAllColumns || columnsToReadMap.get("progressivo") != null)
			dto.setProgressivo(rs.getBigDecimal("progressivo"));

		// colonna [data_install]
		if (mapAllColumns || columnsToReadMap.get("data_install") != null)
			dto.setDataInstall(rs.getDate("data_install"));

		// colonna [des_marca]
		if (mapAllColumns || columnsToReadMap.get("des_marca") != null)
			dto.setDesMarca(rs.getString("des_marca"));

		// colonna [des_combustibile]
		if (mapAllColumns || columnsToReadMap.get("des_combustibile") != null)
			dto.setDesCombustibile(rs.getString("des_combustibile"));

		// colonna [des_dettaglio]
		if (mapAllColumns || columnsToReadMap.get("des_dettaglio") != null)
			dto.setDesDettaglio(rs.getString("des_dettaglio"));

		// colonna [potenza]
		if (mapAllColumns || columnsToReadMap.get("potenza") != null)
			dto.setPotenza(rs.getBigDecimal("potenza"));

		// colonna [rendimento_perc]
		if (mapAllColumns || columnsToReadMap.get("rendimento_perc") != null)
			dto.setRendimentoPerc(rs.getBigDecimal("rendimento_perc"));

		// colonna [data_controllo]
		if (mapAllColumns || columnsToReadMap.get("data_controllo") != null)
			dto.setDataControllo(rs.getDate("data_controllo"));

		// colonna [e_nox_ppm]
		if (mapAllColumns || columnsToReadMap.get("e_nox_ppm") != null)
			dto.setENoxPpm(rs.getBigDecimal("e_nox_ppm"));

		// colonna [e_nox_mg_kwh]
		if (mapAllColumns || columnsToReadMap.get("e_nox_mg_kwh") != null)
			dto.setENoxMgKwh(rs.getBigDecimal("e_nox_mg_kwh"));

		// colonna [e_n_modulo_termico]
		if (mapAllColumns || columnsToReadMap.get("e_n_modulo_termico") != null)
			dto.setENModuloTermico(rs.getBigDecimal("e_n_modulo_termico"));

		// colonna [flg_no_opendata]
		if (mapAllColumns || columnsToReadMap.get("flg_no_opendata") != null)
			dto.setFlgNoOpendata(rs.getBigDecimal("flg_no_opendata"));

		// colonna [indirizzo_unita_immob]
		if (mapAllColumns || columnsToReadMap.get("indirizzo_unita_immob") != null)
			dto.setIndirizzoUnitaImmob(rs.getString("indirizzo_unita_immob"));

		// colonna [civico]
		if (mapAllColumns || columnsToReadMap.get("civico") != null)
			dto.setCivico(rs.getString("civico"));

		// colonna [sezione]
		if (mapAllColumns || columnsToReadMap.get("sezione") != null)
			dto.setSezione(rs.getString("sezione"));

		// colonna [foglio]
		if (mapAllColumns || columnsToReadMap.get("foglio") != null)
			dto.setFoglio(rs.getString("foglio"));

		// colonna [particella]
		if (mapAllColumns || columnsToReadMap.get("particella") != null)
			dto.setParticella(rs.getString("particella"));

		// colonna [subalterno]
		if (mapAllColumns || columnsToReadMap.get("subalterno") != null)
			dto.setSubalterno(rs.getString("subalterno"));

		// colonna [pod_elettrico]
		if (mapAllColumns || columnsToReadMap.get("pod_elettrico") != null)
			dto.setPodElettrico(rs.getString("pod_elettrico"));

		// colonna [pdr_gas]
		if (mapAllColumns || columnsToReadMap.get("pdr_gas") != null)
			dto.setPdrGas(rs.getString("pdr_gas"));

		// colonna [e_nox_mg_nm3]
		if (mapAllColumns || columnsToReadMap.get("e_nox_mg_nm3") != null)
			dto.setENoxMgNm3(rs.getBigDecimal("e_nox_mg_nm3"));

		// colonna [coord_x_long_dd]
		if (mapAllColumns || columnsToReadMap.get("coord_x_long_dd") != null)
			dto.setCoordXLongDd(rs.getBigDecimal("coord_x_long_dd"));

		// colonna [coord_y_lat_dd]
		if (mapAllColumns || columnsToReadMap.get("coord_y_lat_dd") != null)
			dto.setCoordYLatDd(rs.getBigDecimal("coord_y_lat_dd"));

		// colonna [flg_tipo_impianto]
		if (mapAllColumns || columnsToReadMap.get("flg_tipo_impianto") != null)
			dto.setFlgTipoImpianto(rs.getString("flg_tipo_impianto"));

		return dto;
	}

}
