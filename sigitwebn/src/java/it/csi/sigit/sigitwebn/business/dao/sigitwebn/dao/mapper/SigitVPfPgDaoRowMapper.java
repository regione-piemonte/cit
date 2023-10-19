package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitVPfPgDao
 * @generated
 */
public class SigitVPfPgDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitVPfPgDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitVPfPgDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitVPfPgDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitVPfPgDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitVPfPgDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitVPfPgDto) {
			return mapRow_internal((SigitVPfPgDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitVPfPgDto mapRow_internal(SigitVPfPgDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitVPfPgDto dto = objectToFill;

		// colonna [ID_PERSONA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA") != null)
			dto.setIdPersona(rs.getBigDecimal("ID_PERSONA"));

		// colonna [PF_PG]
		if (mapAllColumns || columnsToReadMap.get("PF_PG") != null)
			dto.setPfPg(rs.getString("PF_PG"));

		// colonna [NOME]
		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("NOME"));

		// colonna [DENOMINAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE") != null)
			dto.setDenominazione(rs.getString("DENOMINAZIONE"));

		// colonna [SIGLA_REA]
		if (mapAllColumns || columnsToReadMap.get("SIGLA_REA") != null)
			dto.setSiglaRea(rs.getString("SIGLA_REA"));

		// colonna [NUMERO_REA]
		if (mapAllColumns || columnsToReadMap.get("NUMERO_REA") != null)
			dto.setNumeroRea(rs.getBigDecimal("NUMERO_REA"));

		// colonna [CODICE_FISCALE]
		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setCodiceFiscale(rs.getString("CODICE_FISCALE"));

		// colonna [FK_L2]
		if (mapAllColumns || columnsToReadMap.get("FK_L2") != null)
			dto.setFkL2(rs.getBigDecimal("FK_L2"));

		// colonna [INDIRIZZO_SITAD]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_SITAD") != null)
			dto.setIndirizzoSitad(rs.getString("INDIRIZZO_SITAD"));

		// colonna [INDIRIZZO_NON_TROVATO]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_NON_TROVATO") != null)
			dto.setIndirizzoNonTrovato(rs.getString("INDIRIZZO_NON_TROVATO"));

		// colonna [SIGLA_PROV]
		if (mapAllColumns || columnsToReadMap.get("SIGLA_PROV") != null)
			dto.setSiglaProv(rs.getString("SIGLA_PROV"));

		// colonna [ISTAT_COMUNE]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE") != null)
			dto.setIstatComune(rs.getString("ISTAT_COMUNE"));

		// colonna [COMUNE]
		if (mapAllColumns || columnsToReadMap.get("COMUNE") != null)
			dto.setComune(rs.getString("COMUNE"));

		// colonna [PROVINCIA]
		if (mapAllColumns || columnsToReadMap.get("PROVINCIA") != null)
			dto.setProvincia(rs.getString("PROVINCIA"));

		// colonna [CIVICO]
		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("CIVICO"));

		// colonna [CAP]
		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("CAP"));

		// colonna [EMAIL]
		if (mapAllColumns || columnsToReadMap.get("EMAIL") != null)
			dto.setEmail(rs.getString("EMAIL"));

		// colonna [DATA_INIZIO_ATTIVITA]
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO_ATTIVITA") != null)
			dto.setDataInizioAttivita(rs.getDate("DATA_INIZIO_ATTIVITA"));

		// colonna [DATA_CESSAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DATA_CESSAZIONE") != null)
			dto.setDataCessazione(rs.getDate("DATA_CESSAZIONE"));

		// colonna [FLG_INDIRIZZO_ESTERO]
		if (mapAllColumns || columnsToReadMap.get("FLG_INDIRIZZO_ESTERO") != null)
			dto.setFlgIndirizzoEstero(rs.getBigDecimal("FLG_INDIRIZZO_ESTERO"));

		// colonna [STATO_ESTERO]
		if (mapAllColumns || columnsToReadMap.get("STATO_ESTERO") != null)
			dto.setStatoEstero(rs.getString("STATO_ESTERO"));

		// colonna [CITTA_ESTERO]
		if (mapAllColumns || columnsToReadMap.get("CITTA_ESTERO") != null)
			dto.setCittaEstero(rs.getString("CITTA_ESTERO"));

		// colonna [INDIRIZZO_ESTERO]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_ESTERO") != null)
			dto.setIndirizzoEstero(rs.getString("INDIRIZZO_ESTERO"));

		// colonna [CAP_ESTERO]
		if (mapAllColumns || columnsToReadMap.get("CAP_ESTERO") != null)
			dto.setCapEstero(rs.getString("CAP_ESTERO"));

		return dto;
	}

}
