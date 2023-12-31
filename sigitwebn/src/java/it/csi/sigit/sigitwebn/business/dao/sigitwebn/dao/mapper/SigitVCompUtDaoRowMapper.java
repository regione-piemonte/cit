package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitVCompUtDao
 * @generated
 */
public class SigitVCompUtDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitVCompUtDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitVCompUtDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitVCompUtDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitVCompUtDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitVCompUtDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitVCompUtDto) {
			return mapRow_internal((SigitVCompUtDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitVCompUtDto mapRow_internal(SigitVCompUtDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitVCompUtDto dto = objectToFill;

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [ID_TIPO_COMPONENTE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_COMPONENTE") != null)
			dto.setIdTipoComponente(rs.getString("ID_TIPO_COMPONENTE"));

		// colonna [DATA_INSTALL]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSTALL") != null)
			dto.setDataInstall(rs.getDate("DATA_INSTALL"));

		// colonna [PROGRESSIVO]
		if (mapAllColumns || columnsToReadMap.get("PROGRESSIVO") != null)
			dto.setProgressivo(rs.getBigDecimal("PROGRESSIVO"));

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

		// colonna [MODELLO]
		if (mapAllColumns || columnsToReadMap.get("MODELLO") != null)
			dto.setModello(rs.getString("MODELLO"));

		// colonna [PORTATA_MANDATA_LS]
		if (mapAllColumns || columnsToReadMap.get("PORTATA_MANDATA_LS") != null)
			dto.setPortataMandataLs(rs.getBigDecimal("PORTATA_MANDATA_LS"));

		// colonna [PORTATA_RIPRESA_LS]
		if (mapAllColumns || columnsToReadMap.get("PORTATA_RIPRESA_LS") != null)
			dto.setPortataRipresaLs(rs.getBigDecimal("PORTATA_RIPRESA_LS"));

		// colonna [POTENZA_MANDATA_KW]
		if (mapAllColumns || columnsToReadMap.get("POTENZA_MANDATA_KW") != null)
			dto.setPotenzaMandataKw(rs.getBigDecimal("POTENZA_MANDATA_KW"));

		// colonna [POTENZA_RIPRESA_KW]
		if (mapAllColumns || columnsToReadMap.get("POTENZA_RIPRESA_KW") != null)
			dto.setPotenzaRipresaKw(rs.getBigDecimal("POTENZA_RIPRESA_KW"));

		// colonna [FLG_DISMISSIONE]
		if (mapAllColumns || columnsToReadMap.get("FLG_DISMISSIONE") != null)
			dto.setFlgDismissione(rs.getBigDecimal("FLG_DISMISSIONE"));

		return dto;
	}

}
