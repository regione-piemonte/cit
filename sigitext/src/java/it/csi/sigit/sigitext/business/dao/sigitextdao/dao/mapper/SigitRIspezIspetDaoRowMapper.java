package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitRIspezIspetDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitRIspezIspetDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRIspezIspetDto;

/**
 * RowMapper specifico del DAO SigitRIspezIspetDao
 * @generated
 */
public class SigitRIspezIspetDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitRIspezIspetDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitRIspezIspetDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitRIspezIspetDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitRIspezIspetDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRPfPgDelegaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitRIspezIspetDto) {
			return mapRow_internal((SigitRIspezIspetDto) dtoInstance, rs);
		}

		return dtoInstance;
	}

	public SigitRIspezIspetDto mapRow_internal(SigitRIspezIspetDto objectToFill, ResultSet rs)
			throws SQLException {
		SigitRIspezIspetDto dto = objectToFill;

		// colonna [ID_ISPEZ_ISPET]
		if (mapAllColumns || columnsToReadMap.get("ID_ISPEZ_ISPET") != null)
			dto.setIdIspezIspet(rs.getBigDecimal("ID_ISPEZ_ISPET"));

		// colonna [ID_ISPEZIONE_2018]
		if (mapAllColumns || columnsToReadMap.get("ID_ISPEZIONE_2018") != null)
			dto.setIdIspezione2018(rs.getBigDecimal("ID_ISPEZIONE_2018"));

		// colonna [DATA_INIZIO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO") != null)
			dto.setDataInizio(rs.getDate("DATA_INIZIO"));

		// colonna [FK_PERSONA_FISICA]
		if (mapAllColumns || columnsToReadMap.get("FK_PERSONA_FISICA") != null)
			dto.setFkPersonaFisica(rs.getBigDecimal("FK_PERSONA_FISICA"));

		// colonna [FK_PERSONA_GIURIDICA]
		if (mapAllColumns || columnsToReadMap.get("FK_PERSONA_GIURIDICA") != null)
			dto.setFkPersonaGiuridica(rs.getBigDecimal("FK_PERSONA_GIURIDICA"));
	
		// colonna [FLG_PRIMO_CARICATORE]
		if (mapAllColumns || columnsToReadMap.get("FLG_PRIMO_CARICATORE") != null)
			dto.setFlgPrimoCaricatore(rs.getBigDecimal("FLG_PRIMO_CARICATORE"));
		
		// colonna [DATA_FINE]
		if (mapAllColumns || columnsToReadMap.get("DATA_FINE") != null)
			dto.setDataFine(rs.getDate("DATA_FINE"));

		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		return dto;
	}	

}
