package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTUnitaImmobiliareDao
 * @generated
 */
public class SigitTUnitaImmobiliareDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTUnitaImmobiliareDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTUnitaImmobiliareDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTUnitaImmobiliareDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTUnitaImmobiliareDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTUnitaImmobiliareDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTUnitaImmobiliareDto) {
			return mapRow_internal((SigitTUnitaImmobiliareDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto) {
			return mapRow_internal((SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTUnitaImmobiliareDto mapRow_internal(SigitTUnitaImmobiliareDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTUnitaImmobiliareDto dto = objectToFill;

		// colonna [ID_UNITA_IMM]
		if (mapAllColumns || columnsToReadMap.get("ID_UNITA_IMM") != null)
			dto.setIdUnitaImm(rs.getBigDecimal("ID_UNITA_IMM"));

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [FK_L2]
		if (mapAllColumns || columnsToReadMap.get("FK_L2") != null)
			dto.setFkL2(rs.getBigDecimal("FK_L2"));

		// colonna [INDIRIZZO_SITAD]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_SITAD") != null)
			dto.setIndirizzoSitad(rs.getString("INDIRIZZO_SITAD"));

		// colonna [INDIRIZZO_NON_TROVATO]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_NON_TROVATO") != null)
			dto.setIndirizzoNonTrovato(rs.getString("INDIRIZZO_NON_TROVATO"));

		// colonna [CIVICO]
		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("CIVICO"));

		// colonna [CAP]
		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("CAP"));

		// colonna [SCALA]
		if (mapAllColumns || columnsToReadMap.get("SCALA") != null)
			dto.setScala(rs.getString("SCALA"));

		// colonna [PALAZZO]
		if (mapAllColumns || columnsToReadMap.get("PALAZZO") != null)
			dto.setPalazzo(rs.getString("PALAZZO"));

		// colonna [INTERNO]
		if (mapAllColumns || columnsToReadMap.get("INTERNO") != null)
			dto.setInterno(rs.getString("INTERNO"));

		// colonna [NOTE]
		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("NOTE"));

		// colonna [FLG_PRINCIPALE]
		if (mapAllColumns || columnsToReadMap.get("FLG_PRINCIPALE") != null)
			dto.setFlgPrincipale(rs.getBigDecimal("FLG_PRINCIPALE"));

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

		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		// colonna [L1_2_FLG_SINGOLA_UNITA]
		if (mapAllColumns || columnsToReadMap.get("L1_2_FLG_SINGOLA_UNITA") != null)
			dto.setL12FlgSingolaUnita(rs.getBigDecimal("L1_2_FLG_SINGOLA_UNITA"));

		// colonna [L1_2_FK_CATEGORIA]
		if (mapAllColumns || columnsToReadMap.get("L1_2_FK_CATEGORIA") != null)
			dto.setL12FkCategoria(rs.getString("L1_2_FK_CATEGORIA"));

		// colonna [L1_2_VOL_RISC_M3]
		if (mapAllColumns || columnsToReadMap.get("L1_2_VOL_RISC_M3") != null)
			dto.setL12VolRiscM3(rs.getBigDecimal("L1_2_VOL_RISC_M3"));

		// colonna [L1_2_VOL_RAFF_M3]
		if (mapAllColumns || columnsToReadMap.get("L1_2_VOL_RAFF_M3") != null)
			dto.setL12VolRaffM3(rs.getBigDecimal("L1_2_VOL_RAFF_M3"));

		// colonna [FLG_NOPDR]
		if (mapAllColumns || columnsToReadMap.get("FLG_NOPDR") != null)
			dto.setFlgNopdr(rs.getBigDecimal("FLG_NOPDR"));

		// colonna [FLG_NOACCATASTATO]
		if (mapAllColumns || columnsToReadMap.get("FLG_NOACCATASTATO") != null)
			dto.setFlgNoaccatastato(rs.getBigDecimal("FLG_NOACCATASTATO"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto
	 * @generated
	 */

	public SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto mapRow_internal(
			SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTUnitaImmobiliarePrincipaleByCodiceImpiantoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_UNITA_IMM") != null)
			dto.setUiIdUnitaImm(rs.getBigDecimal("ID_UNITA_IMM"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_SITAD") != null)
			dto.setUiIndirizzoSitad(rs.getString("INDIRIZZO_SITAD"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_NON_TROVATO") != null)
			dto.setUiIndirizzoNonTrovato(rs.getString("INDIRIZZO_NON_TROVATO"));

		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setUiCivico(rs.getString("CIVICO"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setUiCap(rs.getString("CAP"));

		if (mapAllColumns || columnsToReadMap.get("SCALA") != null)
			dto.setUiScala(rs.getString("SCALA"));

		if (mapAllColumns || columnsToReadMap.get("SEZIONE") != null)
			dto.setUiSezione(rs.getString("SEZIONE"));

		if (mapAllColumns || columnsToReadMap.get("FOGLIO") != null)
			dto.setUiFoglio(rs.getString("FOGLIO"));

		if (mapAllColumns || columnsToReadMap.get("PARTICELLA") != null)
			dto.setUiParticella(rs.getString("PARTICELLA"));

		if (mapAllColumns || columnsToReadMap.get("SUBALTERNO") != null)
			dto.setUiSubalterno(rs.getString("SUBALTERNO"));

		if (mapAllColumns || columnsToReadMap.get("POD_ELETTRICO") != null)
			dto.setUiPodElettrico(rs.getString("POD_ELETTRICO"));

		if (mapAllColumns || columnsToReadMap.get("PDR_GAS") != null)
			dto.setUiPdrGas(rs.getString("PDR_GAS"));

		if (mapAllColumns || columnsToReadMap.get("L1_2_FK_CATEGORIA") != null)
			dto.setUiL12FkCategoria(rs.getString("L1_2_FK_CATEGORIA"));

		if (mapAllColumns || columnsToReadMap.get("DES_CATEGORIA") != null)
			dto.setCatDesCategoria(rs.getString("DES_CATEGORIA"));

		if (mapAllColumns || columnsToReadMap.get("L1_2_FLG_SINGOLA_UNITA") != null)
			dto.setUiL12FlgSingolaUnita(rs.getBigDecimal("L1_2_FLG_SINGOLA_UNITA"));

		if (mapAllColumns || columnsToReadMap.get("L1_2_VOL_RISC_M3") != null)
			dto.setUiL12VolRiscM3(rs.getBigDecimal("L1_2_VOL_RISC_M3"));

		if (mapAllColumns || columnsToReadMap.get("L1_2_VOL_RAFF_M3") != null)
			dto.setUiL12VolRaffM3(rs.getBigDecimal("L1_2_VOL_RAFF_M3"));

		return dto;
	}

}
