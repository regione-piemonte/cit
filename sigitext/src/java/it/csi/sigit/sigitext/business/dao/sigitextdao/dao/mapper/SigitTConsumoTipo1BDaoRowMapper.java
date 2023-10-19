package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTConsumoTipo1BDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTConsumoTipo1BDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTConsumoTipo1BDto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTConsumoTipo1BDao
 * @generated
 */
public class SigitTConsumoTipo1BDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTConsumoTipo1BDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTConsumoTipo1BDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTConsumoTipo1BDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTConsumoTipo1BDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTConsumoTipo1BDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTConsumoTipo1BDto) {
			return mapRow_internal((SigitTConsumoTipo1BDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTConsumoTipo1BDto mapRow_internal(SigitTConsumoTipo1BDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTConsumoTipo1BDto dto = objectToFill;

		// colonna [ID_CONSUMO_TIPO1B]
		if (mapAllColumns || columnsToReadMap.get("ID_CONSUMO_TIPO1B") != null)
			dto.setIdConsumoTipo1b(rs.getBigDecimal("ID_CONSUMO_TIPO1B"));

		// colonna [ESERCIZIO]
		if (mapAllColumns || columnsToReadMap.get("ESERCIZIO") != null)
			dto.setEsercizio(rs.getBigDecimal("ESERCIZIO"));

		// colonna [LETTURA_INIZIALE]
		if (mapAllColumns || columnsToReadMap.get("LETTURA_INIZIALE") != null)
			dto.setLetturaIniziale(rs.getBigDecimal("LETTURA_INIZIALE"));

		// colonna [LETTURA_FINALE]
		if (mapAllColumns || columnsToReadMap.get("LETTURA_FINALE") != null)
			dto.setLetturaFinale(rs.getBigDecimal("LETTURA_FINALE"));

		// colonna [CONSUMO]
		if (mapAllColumns || columnsToReadMap.get("CONSUMO") != null)
			dto.setConsumo(rs.getBigDecimal("CONSUMO"));

		// colonna [FK_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("FK_ALLEGATO") != null)
			dto.setFkAllegato(rs.getBigDecimal("FK_ALLEGATO"));

		// colonna [ID_TIPO_CONSUMO_1B]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_CONSUMO_1B") != null)
			dto.setIdTipoConsumo1b(rs.getBigDecimal("ID_TIPO_CONSUMO_1B"));

		// colonna [ID_UNITA_MISURA]
		if (mapAllColumns || columnsToReadMap.get("ID_UNITA_MISURA") != null)
			dto.setIdUnitaMisura(rs.getString("ID_UNITA_MISURA"));

		return dto;
	}

}
