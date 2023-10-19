package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitVAllegatiComponentiDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitVAllegatiComponentiDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVAllegatiComponentiDto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitVAllegatiComponentiDao
 * @generated
 */
public class SigitVAllegatiComponentiDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitVAllegatiComponentiDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitVAllegatiComponentiDaoRowMapper(String[] columnsToRead, Class dtoClass,
			SigitVAllegatiComponentiDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitVAllegatiComponentiDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitVAllegatiComponentiDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitVAllegatiComponentiDto) {
			return mapRow_internal((SigitVAllegatiComponentiDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitVAllegatiComponentiDto mapRow_internal(SigitVAllegatiComponentiDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitVAllegatiComponentiDto dto = objectToFill;

		// colonna [ID_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("ID_ALLEGATO") != null)
			dto.setIdAllegato(rs.getBigDecimal("ID_ALLEGATO"));

		// colonna [ID_TIPO_COMPONENTE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_COMPONENTE") != null)
			dto.setIdTipoComponente(rs.getString("ID_TIPO_COMPONENTE"));

		// colonna [PROGRESSIVO]
		if (mapAllColumns || columnsToReadMap.get("PROGRESSIVO") != null)
			dto.setProgressivo(rs.getBigDecimal("PROGRESSIVO"));

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [DATA_INSTALL]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSTALL") != null)
			dto.setDataInstall(rs.getDate("DATA_INSTALL"));

		// colonna [FK_IMP_RUOLO_PFPG]
		if (mapAllColumns || columnsToReadMap.get("FK_IMP_RUOLO_PFPG") != null)
			dto.setFkImpRuoloPfpg(rs.getBigDecimal("FK_IMP_RUOLO_PFPG"));

		// colonna [FK_CONTRATTO]
		if (mapAllColumns || columnsToReadMap.get("FK_CONTRATTO") != null)
			dto.setFkContratto(rs.getBigDecimal("FK_CONTRATTO"));

		// colonna [FK_STATO_RAPP]
		if (mapAllColumns || columnsToReadMap.get("FK_STATO_RAPP") != null)
			dto.setFkStatoRapp(rs.getBigDecimal("FK_STATO_RAPP"));

		// colonna [DES_STATO_RAPP]
		if (mapAllColumns || columnsToReadMap.get("DES_STATO_RAPP") != null)
			dto.setDesStatoRapp(rs.getString("DES_STATO_RAPP"));

		// colonna [DATA_CONTROLLO]
		if (mapAllColumns || columnsToReadMap.get("DATA_CONTROLLO") != null)
			dto.setDataControllo(rs.getDate("DATA_CONTROLLO"));

		return dto;
	}

}
