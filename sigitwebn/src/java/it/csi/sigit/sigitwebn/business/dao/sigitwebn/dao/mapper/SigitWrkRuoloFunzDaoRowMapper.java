package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitWrkRuoloFunzDao
 * @generated
 */
public class SigitWrkRuoloFunzDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitWrkRuoloFunzDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitWrkRuoloFunzDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitWrkRuoloFunzDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitWrkRuoloFunzDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitWrkRuoloFunzDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitWrkRuoloFunzDto) {
			return mapRow_internal((SigitWrkRuoloFunzDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitWrkRuoloFunzDto mapRow_internal(SigitWrkRuoloFunzDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitWrkRuoloFunzDto dto = objectToFill;

		// colonna [RUOLO]
		if (mapAllColumns || columnsToReadMap.get("RUOLO") != null)
			dto.setRuolo(rs.getString("RUOLO"));

		// colonna [FLG_ACQ_BOLLINO]
		if (mapAllColumns || columnsToReadMap.get("FLG_ACQ_BOLLINO") != null)
			dto.setFlgAcqBollino(rs.getBigDecimal("FLG_ACQ_BOLLINO"));

		// colonna [FLG_ACQ_COD_IMP]
		if (mapAllColumns || columnsToReadMap.get("FLG_ACQ_COD_IMP") != null)
			dto.setFlgAcqCodImp(rs.getBigDecimal("FLG_ACQ_COD_IMP"));

		// colonna [FLG_ACQ_BOLL_TRANS]
		if (mapAllColumns || columnsToReadMap.get("FLG_ACQ_BOLL_TRANS") != null)
			dto.setFlgAcqBollTrans(rs.getBigDecimal("FLG_ACQ_BOLL_TRANS"));

		// colonna [FLG_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("FLG_IMPIANTO") != null)
			dto.setFlgImpianto(rs.getBigDecimal("FLG_IMPIANTO"));

		// colonna [FLG_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("FLG_ALLEGATO") != null)
			dto.setFlgAllegato(rs.getBigDecimal("FLG_ALLEGATO"));

		// colonna [FLG_CONSULTAZIONE]
		if (mapAllColumns || columnsToReadMap.get("FLG_CONSULTAZIONE") != null)
			dto.setFlgConsultazione(rs.getBigDecimal("FLG_CONSULTAZIONE"));

		// colonna [FLG_ISPEZIONE]
		if (mapAllColumns || columnsToReadMap.get("FLG_ISPEZIONE") != null)
			dto.setFlgIspezione(rs.getBigDecimal("FLG_ISPEZIONE"));

		// colonna [FLG_IMPORT_MASS_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("FLG_IMPORT_MASS_ALLEGATO") != null)
			dto.setFlgImportMassAllegato(rs.getBigDecimal("FLG_IMPORT_MASS_ALLEGATO"));

		// colonna [FLG_SUBENTRO]
		if (mapAllColumns || columnsToReadMap.get("FLG_SUBENTRO") != null)
			dto.setFlgSubentro(rs.getBigDecimal("FLG_SUBENTRO"));

		// colonna [FLG_DELEGA]
		if (mapAllColumns || columnsToReadMap.get("FLG_DELEGA") != null)
			dto.setFlgDelega(rs.getBigDecimal("FLG_DELEGA"));

		// colonna [FLG_3RESPONSABILE]
		if (mapAllColumns || columnsToReadMap.get("FLG_3RESPONSABILE") != null)
			dto.setFlg3responsabile(rs.getBigDecimal("FLG_3RESPONSABILE"));

		// colonna [FLG_RIC_AVZ_IMPIANTI]
		if (mapAllColumns || columnsToReadMap.get("FLG_RIC_AVZ_IMPIANTI") != null)
			dto.setFlgRicAvzImpianti(rs.getBigDecimal("FLG_RIC_AVZ_IMPIANTI"));

		// colonna [FLG_DISTRIBUTORI]
		if (mapAllColumns || columnsToReadMap.get("FLG_DISTRIBUTORI") != null)
			dto.setFlgDistributori(rs.getBigDecimal("FLG_DISTRIBUTORI"));

		// colonna [FLG_INCARICHI_CAT]
		if (mapAllColumns || columnsToReadMap.get("FLG_INCARICHI_CAT") != null)
			dto.setFlgIncarichiCat(rs.getBigDecimal("FLG_INCARICHI_CAT"));

		// colonna [FLG_IMPRESA]
		if (mapAllColumns || columnsToReadMap.get("FLG_IMPRESA") != null)
			dto.setFlgImpresa(rs.getBigDecimal("FLG_IMPRESA"));

		// colonna [FLG_EXP_XML_MODOL]
		if (mapAllColumns || columnsToReadMap.get("FLG_EXP_XML_MODOL") != null)
			dto.setFlgExpXmlModol(rs.getBigDecimal("FLG_EXP_XML_MODOL"));

		return dto;
	}

}
