package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTDocContrattoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTDocContrattoDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocContrattoDto;

public class SigitTDocContrattoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 *
	 * @generated
	 */
	SigitTDocContrattoDaoImpl dao;

	/**
	 * costruttore
	 *
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *                      incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTDocContrattoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTDocContrattoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTDocContrattoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 *
	 * @param rs
	 * @param row
	 * @return SigitTStoricoVariazStatoDto
	 * @throws SQLException
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTDocContrattoDto) {
			return mapRow_internal((SigitTDocContrattoDto) dtoInstance, rs);
		}

		return dtoInstance;
	}

	public SigitTDocContrattoDto mapRow_internal(SigitTDocContrattoDto objectToFill, ResultSet rs) throws SQLException {
		SigitTDocContrattoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_DOC_CONTRATTO") != null)
			dto.setIdDocContratto(rs.getBigDecimal("ID_DOC_CONTRATTO"));

		if (mapAllColumns || columnsToReadMap.get("FK_CONTRATTO") != null)
			dto.setFkContratto(rs.getBigDecimal("FK_CONTRATTO"));
		
		if (mapAllColumns || columnsToReadMap.get("NOME_DOC_ORIGINALE") != null)
			dto.setNomeDocOriginale(rs.getString("NOME_DOC_ORIGINALE"));
		
		if (mapAllColumns || columnsToReadMap.get("NOME_DOC") != null)
			dto.setNomeDoc(rs.getString("NOME_DOC"));
		
		if (mapAllColumns || columnsToReadMap.get("DESCRIZIONE") != null)
			dto.setDescrizione(rs.getString("DESCRIZIONE"));

		if (mapAllColumns || columnsToReadMap.get("DATA_UPLOAD") != null)
			dto.setDataUpload(rs.getDate("DATA_UPLOAD"));
		
		if (mapAllColumns || columnsToReadMap.get("DATA_DELETE") != null)
			dto.setDataDelete(rs.getDate("DATA_DELETE"));
		
		if (mapAllColumns || columnsToReadMap.get("UID_INDEX") != null)
			dto.setUidIndex(rs.getString("UID_INDEX"));
		
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getDate("DATA_ULT_MOD"));
		
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		return dto;
	}

}
