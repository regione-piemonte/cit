package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTIspezione2018Dao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTIspezione2018DaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTIspezione2018Dto;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTIspezione2018Dao
 * @generated
 */
public class SigitTIspezione2018DaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTIspezione2018DaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTIspezione2018DaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTIspezione2018Dao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTIspezione2018DaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTIspezione2018Dto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTIspezione2018Dto) {
			return mapRow_internal((SigitTIspezione2018Dto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTIspezione2018Dto mapRow_internal(SigitTIspezione2018Dto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTIspezione2018Dto dto = objectToFill;

		// colonna [ID_ISPEZIONE_2018]
		if (mapAllColumns || columnsToReadMap.get("ID_ISPEZIONE_2018") != null)
			dto.setIdIspezione2018((Integer) rs.getObject("ID_ISPEZIONE_2018"));

		// colonna [FK_STATO_ISPEZIONE]
		if (mapAllColumns || columnsToReadMap.get("FK_STATO_ISPEZIONE") != null)
			dto.setFkStatoIspezione(rs.getBigDecimal("FK_STATO_ISPEZIONE"));

		// colonna [FK_VERIFICA]
		if (mapAllColumns || columnsToReadMap.get("FK_VERIFICA") != null)
			dto.setFkVerifica((Integer) rs.getObject("FK_VERIFICA"));

		// colonna [FK_ACCERTAMENTO]
		if (mapAllColumns || columnsToReadMap.get("FK_ACCERTAMENTO") != null)
			dto.setFkAccertamento((Integer) rs.getObject("FK_ACCERTAMENTO"));

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [CF_ISPETTORE_SECONDARIO]
		if (mapAllColumns || columnsToReadMap.get("CF_ISPETTORE_SECONDARIO") != null)
			dto.setCfIspettoreSecondario(rs.getString("CF_ISPETTORE_SECONDARIO"));

		// colonna [ENTE_COMPETENTE]
		if (mapAllColumns || columnsToReadMap.get("ENTE_COMPETENTE") != null)
			dto.setEnteCompetente(rs.getString("ENTE_COMPETENTE"));

		// colonna [FLG_ESITO]
		if (mapAllColumns || columnsToReadMap.get("FLG_ESITO") != null)
			dto.setFlgEsito(rs.getBigDecimal("FLG_ESITO"));

		// colonna [DT_SVEGLIA]
		if (mapAllColumns || columnsToReadMap.get("DT_SVEGLIA") != null)
			dto.setDtSveglia(rs.getTimestamp("DT_SVEGLIA"));

		// colonna [NOTE_SVEGLIA]
		if (mapAllColumns || columnsToReadMap.get("NOTE_SVEGLIA") != null)
			dto.setNoteSveglia(rs.getString("NOTE_SVEGLIA"));

		// colonna [NOTE]
		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("NOTE"));

		// colonna [ISTAT_PROV_COMPETENZA]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_PROV_COMPETENZA") != null)
			dto.setIstatProvCompetenza(rs.getString("ISTAT_PROV_COMPETENZA"));

		// colonna [FLG_ACC_SOSTITUTIVO]
		if (mapAllColumns || columnsToReadMap.get("FLG_ACC_SOSTITUTIVO") != null)
			dto.setFlgAccSostitutivo(rs.getBigDecimal("FLG_ACC_SOSTITUTIVO"));

		// colonna [DT_CREAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DT_CREAZIONE") != null)
			dto.setDtCreazione(rs.getTimestamp("DT_CREAZIONE"));

		// colonna [DT_CONCLUSIONE]
		if (mapAllColumns || columnsToReadMap.get("DT_CONCLUSIONE") != null)
			dto.setDtConclusione(rs.getTimestamp("DT_CONCLUSIONE"));

		// colonna [FLG_ISP_PAGAMENTO]
		if (mapAllColumns || columnsToReadMap.get("FLG_ISP_PAGAMENTO") != null)
			dto.setFlgIspPagamento(rs.getBigDecimal("FLG_ISP_PAGAMENTO"));

		// colonna [ISTAT_COMUNE_COMPETENZA]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE_COMPETENZA") != null)
			dto.setIstatComuneCompetenza(rs.getString("ISTAT_COMUNE_COMPETENZA"));

		return dto;
	}

}
