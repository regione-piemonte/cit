package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitVSk4GtDao
 * @generated
 */
public class SigitVSk4GtDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitVSk4GtDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitVSk4GtDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitVSk4GtDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitVSk4GtDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitVSk4GtDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitVSk4GtDto) {
			return mapRow_internal((SigitVSk4GtDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitVSk4GtDto mapRow_internal(SigitVSk4GtDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitVSk4GtDto dto = objectToFill;

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [ID_TIPO_COMPONENTE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_COMPONENTE") != null)
			dto.setIdTipoComponente(rs.getString("ID_TIPO_COMPONENTE"));

		// colonna [PROGRESSIVO]
		if (mapAllColumns || columnsToReadMap.get("PROGRESSIVO") != null)
			dto.setProgressivo(rs.getBigDecimal("PROGRESSIVO"));

		// colonna [DATA_INSTALL]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSTALL") != null)
			dto.setDataInstall(rs.getDate("DATA_INSTALL"));

		// colonna [DATA_DISMISS]
		if (mapAllColumns || columnsToReadMap.get("DATA_DISMISS") != null)
			dto.setDataDismiss(rs.getDate("DATA_DISMISS"));

		// colonna [MATRICOLA]
		if (mapAllColumns || columnsToReadMap.get("MATRICOLA") != null)
			dto.setMatricola(rs.getString("MATRICOLA"));

		// colonna [FK_MARCA]
		if (mapAllColumns || columnsToReadMap.get("FK_MARCA") != null)
			dto.setFkMarca(rs.getBigDecimal("FK_MARCA"));

		// colonna [DES_MARCA]
		if (mapAllColumns || columnsToReadMap.get("DES_MARCA") != null)
			dto.setDesMarca(rs.getString("DES_MARCA"));

		// colonna [ID_COMBUSTIBILE]
		if (mapAllColumns || columnsToReadMap.get("ID_COMBUSTIBILE") != null)
			dto.setIdCombustibile(rs.getBigDecimal("ID_COMBUSTIBILE"));

		// colonna [DES_COMBUSTIBILE]
		if (mapAllColumns || columnsToReadMap.get("DES_COMBUSTIBILE") != null)
			dto.setDesCombustibile(rs.getString("DES_COMBUSTIBILE"));

		// colonna [FK_FLUIDO]
		if (mapAllColumns || columnsToReadMap.get("FK_FLUIDO") != null)
			dto.setFkFluido(rs.getBigDecimal("FK_FLUIDO"));

		// colonna [DES_FLUIDO]
		if (mapAllColumns || columnsToReadMap.get("DES_FLUIDO") != null)
			dto.setDesFluido(rs.getString("DES_FLUIDO"));

		// colonna [FK_DETTAGLIO_GT]
		if (mapAllColumns || columnsToReadMap.get("FK_DETTAGLIO_GT") != null)
			dto.setFkDettaglioGt(rs.getBigDecimal("FK_DETTAGLIO_GT"));

		// colonna [DES_DETTAGLIO_GT]
		if (mapAllColumns || columnsToReadMap.get("DES_DETTAGLIO_GT") != null)
			dto.setDesDettaglioGt(rs.getString("DES_DETTAGLIO_GT"));

		// colonna [MODELLO]
		if (mapAllColumns || columnsToReadMap.get("MODELLO") != null)
			dto.setModello(rs.getString("MODELLO"));

		// colonna [POTENZA_TERMICA_KW]
		if (mapAllColumns || columnsToReadMap.get("POTENZA_TERMICA_KW") != null)
			dto.setPotenzaTermicaKw(rs.getBigDecimal("POTENZA_TERMICA_KW"));

		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		// colonna [RENDIMENTO_PERC]
		if (mapAllColumns || columnsToReadMap.get("RENDIMENTO_PERC") != null)
			dto.setRendimentoPerc(rs.getBigDecimal("RENDIMENTO_PERC"));

		// colonna [N_MODULI]
		if (mapAllColumns || columnsToReadMap.get("N_MODULI") != null)
			dto.setNModuli(rs.getBigDecimal("N_MODULI"));

		// colonna [FLG_DISMISSIONE]
		if (mapAllColumns || columnsToReadMap.get("FLG_DISMISSIONE") != null)
			dto.setFlgDismissione(rs.getBigDecimal("FLG_DISMISSIONE"));

		// colonna [DATA_CONTROLLO]
		if (mapAllColumns || columnsToReadMap.get("DATA_CONTROLLO") != null)
			dto.setDataControllo(rs.getDate("DATA_CONTROLLO"));

		// colonna [ID_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("ID_ALLEGATO") != null)
			dto.setIdAllegato(rs.getBigDecimal("ID_ALLEGATO"));

		// colonna [FK_TIPO_DOCUMENTO]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_DOCUMENTO") != null)
			dto.setFkTipoDocumento(rs.getBigDecimal("FK_TIPO_DOCUMENTO"));

		// colonna [DES_TIPO_DOCUMENTO]
		if (mapAllColumns || columnsToReadMap.get("DES_TIPO_DOCUMENTO") != null)
			dto.setDesTipoDocumento(rs.getString("DES_TIPO_DOCUMENTO"));

		// colonna [ID_TIPO_CANNA_FUMARIA]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_CANNA_FUMARIA") != null)
			dto.setIdTipoCannaFumaria(rs.getBigDecimal("ID_TIPO_CANNA_FUMARIA"));

		// colonna [MEDI_IMP_ORE_OPERATIVE]
		if (mapAllColumns || columnsToReadMap.get("MEDI_IMP_ORE_OPERATIVE") != null)
			dto.setMediImpOreOperative(rs.getBigDecimal("MEDI_IMP_ORE_OPERATIVE"));

		// colonna [DESC_TIPO_CANNA_FUMARIA]
		if (mapAllColumns || columnsToReadMap.get("DESC_TIPO_CANNA_FUMARIA") != null)
			dto.setDescTipoCannaFumaria(rs.getString("DESC_TIPO_CANNA_FUMARIA"));

		return dto;
	}

}
