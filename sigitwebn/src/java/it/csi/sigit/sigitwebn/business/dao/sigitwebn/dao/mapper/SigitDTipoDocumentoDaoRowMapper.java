package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitDTipoDocumentoDao
 * @generated
 */
public class SigitDTipoDocumentoDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitDTipoDocumentoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitDTipoDocumentoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitDTipoDocumentoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitDTipoDocumentoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDTipoDocumentoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitDTipoDocumentoDto) {
			return mapRow_internal((SigitDTipoDocumentoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof SigitDTipoDocumentoByRuoloFunzionaleDto) {
			return mapRow_internal((SigitDTipoDocumentoByRuoloFunzionaleDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof SigitDTipoDocumentoByCodiceImpiantoDto) {
			return mapRow_internal((SigitDTipoDocumentoByCodiceImpiantoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitDTipoDocumentoDto mapRow_internal(SigitDTipoDocumentoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitDTipoDocumentoDto dto = objectToFill;

		// colonna [ID_TIPO_DOCUMENTO]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_DOCUMENTO") != null)
			dto.setIdTipoDocumento(rs.getBigDecimal("ID_TIPO_DOCUMENTO"));

		// colonna [DES_TIPO_DOCUMENTO]
		if (mapAllColumns || columnsToReadMap.get("DES_TIPO_DOCUMENTO") != null)
			dto.setDesTipoDocumento(rs.getString("DES_TIPO_DOCUMENTO"));

		// colonna [FLG_VISU_ELENCO_ALL]
		if (mapAllColumns || columnsToReadMap.get("FLG_VISU_ELENCO_ALL") != null)
			dto.setFlgVisuElencoAll(rs.getBigDecimal("FLG_VISU_ELENCO_ALL"));

		// colonna [FLG_RICERCA_ALL]
		if (mapAllColumns || columnsToReadMap.get("FLG_RICERCA_ALL") != null)
			dto.setFlgRicercaAll(rs.getBigDecimal("FLG_RICERCA_ALL"));

		// colonna [FLG_VISU_ELENCO_RAPPROVA]
		if (mapAllColumns || columnsToReadMap.get("FLG_VISU_ELENCO_RAPPROVA") != null)
			dto.setFlgVisuElencoRapprova(rs.getBigDecimal("FLG_VISU_ELENCO_RAPPROVA"));

		// colonna [FLG_VISU_ELENCO_MANUT]
		if (mapAllColumns || columnsToReadMap.get("FLG_VISU_ELENCO_MANUT") != null)
			dto.setFlgVisuElencoManut(rs.getBigDecimal("FLG_VISU_ELENCO_MANUT"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitDTipoDocumentoByRuoloFunzionaleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDTipoDocumentoByRuoloFunzionaleDto
	 * @generated
	 */

	public SigitDTipoDocumentoByRuoloFunzionaleDto mapRow_internal(SigitDTipoDocumentoByRuoloFunzionaleDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		SigitDTipoDocumentoByRuoloFunzionaleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDTIPODOCUMENTO") != null)
			dto.setIdTipoDocumento(rs.getBigDecimal("idTipoDocumento"));

		if (mapAllColumns || columnsToReadMap.get("DESCTIPODOCUMENTO") != null)
			dto.setDescTipoDocumento(rs.getString("descTipoDocumento"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitDTipoDocumentoByCodiceImpiantoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitDTipoDocumentoByCodiceImpiantoDto
	 * @generated
	 */

	public SigitDTipoDocumentoByCodiceImpiantoDto mapRow_internal(SigitDTipoDocumentoByCodiceImpiantoDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		SigitDTipoDocumentoByCodiceImpiantoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDTIPODOCUMENTO") != null)
			dto.setIdTipoDocumento(rs.getBigDecimal("idTipoDocumento"));

		if (mapAllColumns || columnsToReadMap.get("DESCTIPODOCUMENTO") != null)
			dto.setDescTipoDocumento(rs.getString("descTipoDocumento"));

		return dto;
	}

}
