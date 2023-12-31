package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.mapper;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitRAllegatoCompScDao
 * @generated
 */
public class SigitRAllegatoCompScDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitRAllegatoCompScDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitRAllegatoCompScDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitRAllegatoCompScDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitRAllegatoCompScDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRAllegatoCompScDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitRAllegatoCompScDto) {
			return mapRow_internal((SigitRAllegatoCompScDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitRAllegatoCompScDto mapRow_internal(SigitRAllegatoCompScDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitRAllegatoCompScDto dto = objectToFill;

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

		// colonna [BUTTA_FK_R_PG]
		if (mapAllColumns || columnsToReadMap.get("BUTTA_FK_R_PG") != null)
			dto.setButtaFkRPg(rs.getBigDecimal("BUTTA_FK_R_PG"));

		// colonna [BUTTA_FK_3R_PG]
		if (mapAllColumns || columnsToReadMap.get("BUTTA_FK_3R_PG") != null)
			dto.setButtaFk3rPg(rs.getBigDecimal("BUTTA_FK_3R_PG"));

		// colonna [BUTTA_FK_R_PF]
		if (mapAllColumns || columnsToReadMap.get("BUTTA_FK_R_PF") != null)
			dto.setButtaFkRPf(rs.getBigDecimal("BUTTA_FK_R_PF"));

		// colonna [BUTTA_FK_3RESP]
		if (mapAllColumns || columnsToReadMap.get("BUTTA_FK_3RESP") != null)
			dto.setButtaFk3resp(rs.getBigDecimal("BUTTA_FK_3RESP"));

		// colonna [BUTTA_FK_RESP]
		if (mapAllColumns || columnsToReadMap.get("BUTTA_FK_RESP") != null)
			dto.setButtaFkResp(rs.getBigDecimal("BUTTA_FK_RESP"));

		// colonna [FK_IMP_RUOLO_PFPG]
		if (mapAllColumns || columnsToReadMap.get("FK_IMP_RUOLO_PFPG") != null)
			dto.setFkImpRuoloPfpg(rs.getBigDecimal("FK_IMP_RUOLO_PFPG"));

		// colonna [FK_CONTRATTO]
		if (mapAllColumns || columnsToReadMap.get("FK_CONTRATTO") != null)
			dto.setFkContratto(rs.getBigDecimal("FK_CONTRATTO"));

		return dto;
	}

}
