package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitRPfPgDelegaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitRPfPgDelegaDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfPgDelegaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfPgDelegaFindByPfDto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitRPfPgDelegaDao
 * @generated
 */
public class SigitRPfPgDelegaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitRPfPgDelegaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitRPfPgDelegaDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitRPfPgDelegaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitRPfPgDelegaDaoImpl) dao;
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

		if (dtoInstance instanceof SigitRPfPgDelegaDto) {
			return mapRow_internal((SigitRPfPgDelegaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof SigitRPfPgDelegaFindByPfDto) {
			return mapRow_internal((SigitRPfPgDelegaFindByPfDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitRPfPgDelegaDto mapRow_internal(SigitRPfPgDelegaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitRPfPgDelegaDto dto = objectToFill;

		// colonna [ID_PERSONA_FISICA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_FISICA") != null)
			dto.setIdPersonaFisica(rs.getBigDecimal("ID_PERSONA_FISICA"));

		// colonna [ID_PERSONA_GIURIDICA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_GIURIDICA") != null)
			dto.setIdPersonaGiuridica(rs.getBigDecimal("ID_PERSONA_GIURIDICA"));

		// colonna [DATA_INIZIO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO") != null)
			dto.setDataInizio(rs.getDate("DATA_INIZIO"));

		// colonna [FK_RUOLO_ACCRED]
		if (mapAllColumns || columnsToReadMap.get("FK_RUOLO_ACCRED") != null)
			dto.setFkRuoloAccred(rs.getBigDecimal("FK_RUOLO_ACCRED"));

		// colonna [FK_TIPO_DM]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_DM") != null)
			dto.setFkTipoDm(rs.getString("FK_TIPO_DM"));

		// colonna [FLG_DELEGA]
		if (mapAllColumns || columnsToReadMap.get("FLG_DELEGA") != null)
			dto.setFlgDelega(rs.getString("FLG_DELEGA"));

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

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitRPfPgDelegaFindByPfDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRPfPgDelegaFindByPfDto
	 * @generated
	 */

	public SigitRPfPgDelegaFindByPfDto mapRow_internal(SigitRPfPgDelegaFindByPfDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitRPfPgDelegaFindByPfDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_FISICA") != null)
			dto.setPfPgDelegaIdPersonaFisica(rs.getBigDecimal("ID_PERSONA_FISICA"));

		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_GIURIDICA") != null)
			dto.setPgIdPersonaGiuridica(rs.getBigDecimal("ID_PERSONA_GIURIDICA"));

		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setPgCodiceFiscale(rs.getString("CODICE_FISCALE"));

		if (mapAllColumns || columnsToReadMap.get("SIGLA_REA") != null)
			dto.setPgSiglaRea(rs.getString("SIGLA_REA"));

		if (mapAllColumns || columnsToReadMap.get("NUMERO_REA") != null)
			dto.setPgNumeroRea(rs.getBigDecimal("NUMERO_REA"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE") != null)
			dto.setPgDenominazione(rs.getString("DENOMINAZIONE"));

		if (mapAllColumns || columnsToReadMap.get("DATA_CESSAZIONE") != null)
			dto.setPgDataCessazione(rs.getDate("DATA_CESSAZIONE"));

		if (mapAllColumns || columnsToReadMap.get("FK_STATO_PG") != null)
			dto.setPgFkStatoPg((Integer) rs.getObject("FK_STATO_PG"));

		if (mapAllColumns || columnsToReadMap.get("DES_STATO_PG") != null)
			dto.setStatoPgDesStatoPg(rs.getString("DES_STATO_PG"));

		if (mapAllColumns || columnsToReadMap.get("FLG_DM37_LETTERAC") != null)
			dto.setPgFlgDm37Letterac(rs.getBigDecimal("FLG_DM37_LETTERAC"));

		if (mapAllColumns || columnsToReadMap.get("FLG_AMMINISTRATORE") != null)
			dto.setPgFlgAmministratore(rs.getBigDecimal("FLG_AMMINISTRATORE"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SOGG_INCARICATO") != null)
			dto.setPgFlgSoggIncaricato(rs.getBigDecimal("FLG_SOGG_INCARICATO"));

		if (mapAllColumns || columnsToReadMap.get("FLG_TERZO_RESPONSABILE") != null)
			dto.setPgFlgTerzoResponsabile(rs.getBigDecimal("FLG_TERZO_RESPONSABILE"));

		if (mapAllColumns || columnsToReadMap.get("FLG_DISTRIBUTORE") != null)
			dto.setPgFlgDistributore(rs.getBigDecimal("FLG_DISTRIBUTORE"));

		if (mapAllColumns || columnsToReadMap.get("FLG_CAT") != null)
			dto.setPgFlgCat(rs.getBigDecimal("FLG_CAT"));
		return dto;
	}

}
