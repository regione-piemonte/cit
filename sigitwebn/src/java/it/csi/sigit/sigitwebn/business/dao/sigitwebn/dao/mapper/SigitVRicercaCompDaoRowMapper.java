package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitVRicercaCompDao
 * @generated
 */
public class SigitVRicercaCompDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitVRicercaCompDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitVRicercaCompDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitVRicercaCompDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitVRicercaCompDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitVRicercaCompDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitVRicercaCompDto) {
			return mapRow_internal((SigitVRicercaCompDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof SigitVRicercaCompComponentiByFilterDto) {
			return mapRow_internal((SigitVRicercaCompComponentiByFilterDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitVRicercaCompDto mapRow_internal(SigitVRicercaCompDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitVRicercaCompDto dto = objectToFill;

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [ID_TIPO_COMPONENTE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_COMPONENTE") != null)
			dto.setIdTipoComponente(rs.getString("ID_TIPO_COMPONENTE"));

		// colonna [PROGRESSIVO]
		if (mapAllColumns || columnsToReadMap.get("PROGRESSIVO") != null)
			dto.setProgressivo(rs.getBigDecimal("PROGRESSIVO"));

		// colonna [FK_MARCA]
		if (mapAllColumns || columnsToReadMap.get("FK_MARCA") != null)
			dto.setFkMarca(rs.getBigDecimal("FK_MARCA"));

		// colonna [FK_COMBUSTIBILE]
		if (mapAllColumns || columnsToReadMap.get("FK_COMBUSTIBILE") != null)
			dto.setFkCombustibile(rs.getBigDecimal("FK_COMBUSTIBILE"));

		// colonna [MODELLO]
		if (mapAllColumns || columnsToReadMap.get("MODELLO") != null)
			dto.setModello(rs.getString("MODELLO"));

		// colonna [POTENZA_TERMICA_KW]
		if (mapAllColumns || columnsToReadMap.get("POTENZA_TERMICA_KW") != null)
			dto.setPotenzaTermicaKw(rs.getBigDecimal("POTENZA_TERMICA_KW"));

		// colonna [DATA_INSTALL]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSTALL") != null)
			dto.setDataInstall(rs.getDate("DATA_INSTALL"));

		// colonna [MATRICOLA]
		if (mapAllColumns || columnsToReadMap.get("MATRICOLA") != null)
			dto.setMatricola(rs.getString("MATRICOLA"));

		// colonna [DATA_DISMISS]
		if (mapAllColumns || columnsToReadMap.get("DATA_DISMISS") != null)
			dto.setDataDismiss(rs.getDate("DATA_DISMISS"));

		// colonna [FLG_DISMISSIONE]
		if (mapAllColumns || columnsToReadMap.get("FLG_DISMISSIONE") != null)
			dto.setFlgDismissione(rs.getBigDecimal("FLG_DISMISSIONE"));

		// colonna [RENDIMENTO_PERC]
		if (mapAllColumns || columnsToReadMap.get("RENDIMENTO_PERC") != null)
			dto.setRendimentoPerc(rs.getBigDecimal("RENDIMENTO_PERC"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitVRicercaCompComponentiByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitVRicercaCompComponentiByFilterDto
	 * @generated
	 */

	public SigitVRicercaCompComponentiByFilterDto mapRow_internal(SigitVRicercaCompComponentiByFilterDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		SigitVRicercaCompComponentiByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_COMPONENTE") != null)
			dto.setRcIdTipoComponente(rs.getString("ID_TIPO_COMPONENTE"));

		if (mapAllColumns || columnsToReadMap.get("PROGRESSIVO") != null)
			dto.setRcProgressivo(rs.getBigDecimal("PROGRESSIVO"));

		if (mapAllColumns || columnsToReadMap.get("DES_MARCA") != null)
			dto.setMDesMarca(rs.getString("DES_MARCA"));

		if (mapAllColumns || columnsToReadMap.get("MODELLO") != null)
			dto.setRcModello(rs.getString("MODELLO"));

		return dto;
	}

}
