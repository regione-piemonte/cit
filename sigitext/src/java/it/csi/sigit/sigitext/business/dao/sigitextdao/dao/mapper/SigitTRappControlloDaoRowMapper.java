package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTRappControlloDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTRappControlloDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappControlloDto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTRappControlloDao
 *
 * @generated
 */
public class SigitTRappControlloDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 *
	 * @generated
	 */
	SigitTRappControlloDaoImpl dao;

	/**
	 * costruttore
	 *
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *                      incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTRappControlloDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTRappControlloDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTRappControlloDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 *
	 * @param rs
	 * @param row
	 * @return SigitTRappControlloDto
	 * @throws SQLException
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTRappControlloDto) {
			return mapRow_internal((SigitTRappControlloDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTRappControlloDto mapRow_internal(SigitTRappControlloDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitTRappControlloDto dto = objectToFill;

		// colonna [ID_RAPPORTO_CONTROLLO]
		if (mapAllColumns || columnsToReadMap.get("ID_RAPPORTO_CONTROLLO") != null)
			dto.setIdRapportoControllo(rs.getBigDecimal("ID_RAPPORTO_CONTROLLO"));

		// colonna [FK_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("FK_ALLEGATO") != null)
			dto.setFkAllegato(rs.getBigDecimal("FK_ALLEGATO"));

		// colonna [NOTE_UFFICIO]
		if (mapAllColumns || columnsToReadMap.get("NOTE_UFFICIO") != null)
			dto.setNoteUfficio(rs.getString("NOTE_UFFICIO"));

		// colonna [FLG_LOCALE_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_LOCALE_OK") != null)
			dto.setFlgLocaleOk(rs.getBigDecimal("FLG_LOCALE_OK"));

		// colonna [FLG_AERAZIONE_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_AERAZIONE_OK") != null)
			dto.setFlgAerazioneOk(rs.getBigDecimal("FLG_AERAZIONE_OK"));

		// colonna [FLG_AERAZIONE_LIBERA]
		if (mapAllColumns || columnsToReadMap.get("FLG_AERAZIONE_LIBERA") != null)
			dto.setFlgAerazioneLibera(rs.getBigDecimal("FLG_AERAZIONE_LIBERA"));

		// colonna [FLG_ASSENZA_FUGHE_GAS]
		if (mapAllColumns || columnsToReadMap.get("FLG_ASSENZA_FUGHE_GAS") != null)
			dto.setFlgAssenzaFugheGas(rs.getBigDecimal("FLG_ASSENZA_FUGHE_GAS"));

		// colonna [FLG_EVACUAZIONE_FUMI]
		if (mapAllColumns || columnsToReadMap.get("FLG_EVACUAZIONE_FUMI") != null)
			dto.setFlgEvacuazioneFumi(rs.getBigDecimal("FLG_EVACUAZIONE_FUMI"));

		// colonna [FLG_RAPPORTO_CONTROLLO]
		if (mapAllColumns || columnsToReadMap.get("FLG_RAPPORTO_CONTROLLO") != null)
			dto.setFlgRapportoControllo(rs.getBigDecimal("FLG_RAPPORTO_CONTROLLO"));

		// colonna [FLG_CERTIFICAZIONE]
		if (mapAllColumns || columnsToReadMap.get("FLG_CERTIFICAZIONE") != null)
			dto.setFlgCertificazione(rs.getBigDecimal("FLG_CERTIFICAZIONE"));

		// colonna [FLG_PRATICA_ISPESL]
		if (mapAllColumns || columnsToReadMap.get("FLG_PRATICA_ISPESL") != null)
			dto.setFlgPraticaIspesl(rs.getBigDecimal("FLG_PRATICA_ISPESL"));

		// colonna [FLG_CERT_PREV_INCENDI]
		if (mapAllColumns || columnsToReadMap.get("FLG_CERT_PREV_INCENDI") != null)
			dto.setFlgCertPrevIncendi(rs.getBigDecimal("FLG_CERT_PREV_INCENDI"));

		// colonna [FLG_CENTRALETERMICA]
		if (mapAllColumns || columnsToReadMap.get("FLG_CENTRALETERMICA") != null)
			dto.setFlgCentraletermica(rs.getBigDecimal("FLG_CENTRALETERMICA"));

		return dto;
	}

}
