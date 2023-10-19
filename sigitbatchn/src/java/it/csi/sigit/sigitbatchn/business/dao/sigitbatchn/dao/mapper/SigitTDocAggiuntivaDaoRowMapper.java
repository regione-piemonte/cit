package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.mapper;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTDocAggiuntivaDao
 * @generated
 */
public class SigitTDocAggiuntivaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTDocAggiuntivaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTDocAggiuntivaDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTDocAggiuntivaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTDocAggiuntivaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTDocAggiuntivaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTDocAggiuntivaDto) {
			return mapRow_internal((SigitTDocAggiuntivaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTDocAggiuntivaDto mapRow_internal(SigitTDocAggiuntivaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTDocAggiuntivaDto dto = objectToFill;

		// colonna [ID_DOC_AGGIUNTIVA]
		if (mapAllColumns || columnsToReadMap.get("ID_DOC_AGGIUNTIVA") != null)
			dto.setIdDocAggiuntiva((Integer) rs.getObject("ID_DOC_AGGIUNTIVA"));

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [FK_TIPO_DOCAGG]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_DOCAGG") != null)
			dto.setFkTipoDocagg(rs.getBigDecimal("FK_TIPO_DOCAGG"));

		// colonna [NOME_DOC_ORIGINALE]
		if (mapAllColumns || columnsToReadMap.get("NOME_DOC_ORIGINALE") != null)
			dto.setNomeDocOriginale(rs.getString("NOME_DOC_ORIGINALE"));

		// colonna [NOME_DOC]
		if (mapAllColumns || columnsToReadMap.get("NOME_DOC") != null)
			dto.setNomeDoc(rs.getString("NOME_DOC"));

		// colonna [UID_INDEX]
		if (mapAllColumns || columnsToReadMap.get("UID_INDEX") != null)
			dto.setUidIndex(rs.getString("UID_INDEX"));

		// colonna [DES_ALTRO_TIPODOC]
		if (mapAllColumns || columnsToReadMap.get("DES_ALTRO_TIPODOC") != null)
			dto.setDesAltroTipodoc(rs.getString("DES_ALTRO_TIPODOC"));

		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		// colonna [DATA_UPLOAD]
		if (mapAllColumns || columnsToReadMap.get("DATA_UPLOAD") != null)
			dto.setDataUpload(rs.getTimestamp("DATA_UPLOAD"));

		// colonna [DATA_DELETE]
		if (mapAllColumns || columnsToReadMap.get("DATA_DELETE") != null)
			dto.setDataDelete(rs.getTimestamp("DATA_DELETE"));

		return dto;
	}

}
