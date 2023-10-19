package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTCompGtDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTCompGtDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompGtCompletoDto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTCompGtDao
 *
 * @generated
 */
public class SigitTCompGtCompletoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 *
	 * @generated
	 */
	SigitTCompGtDaoImpl dao;

	/**
	 * costruttore
	 *
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *                      incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTCompGtCompletoDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTCompGtDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTCompGtDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 *
	 * @param rs
	 * @param row
	 * @return SigitTCompGtCompletoDto
	 * @throws SQLException
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTCompGtCompletoDto) {
			return mapRow_internal((SigitTCompGtCompletoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTCompGtCompletoDto mapRow_internal(SigitTCompGtCompletoDto objectToFill, ResultSet rs, int row) throws SQLException {
		SigitTCompGtCompletoDto dto = objectToFill;

		// colonna [ID_TIPO_COMPONENTE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_COMPONENTE") != null)
			dto.setIdTipoComponente(rs.getString("ID_TIPO_COMPONENTE"));

		// colonna [PROGRESSIVO]
		if (mapAllColumns || columnsToReadMap.get("PROGRESSIVO") != null)
			dto.setProgressivo(rs.getBigDecimal("PROGRESSIVO"));

		// colonna [DATA_INSTALL]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSTALL") != null)
			dto.setDataInstall(rs.getDate("DATA_INSTALL"));

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [FK_FLUIDO]
		if (mapAllColumns || columnsToReadMap.get("FK_FLUIDO") != null)
			dto.setFkFluido(rs.getBigDecimal("FK_FLUIDO"));

		// colonna [FK_DETTAGLIO_GT]
		if (mapAllColumns || columnsToReadMap.get("FK_DETTAGLIO_GT") != null)
			dto.setFkDettaglioGt(rs.getBigDecimal("FK_DETTAGLIO_GT"));

		// colonna [RENDIMENTO_PERC]
		if (mapAllColumns || columnsToReadMap.get("RENDIMENTO_PERC") != null)
			dto.setRendimentoPerc(rs.getBigDecimal("RENDIMENTO_PERC"));

		// colonna [N_MODULI]
		if (mapAllColumns || columnsToReadMap.get("N_MODULI") != null)
			dto.setNModuli(rs.getBigDecimal("N_MODULI"));

		// colonna [DATA_DISMISS]
		if (mapAllColumns || columnsToReadMap.get("DATA_DISMISS") != null)
			dto.setDataDismiss(rs.getDate("DATA_DISMISS"));

		// colonna [FLG_DISMISSIONE]
		if (mapAllColumns || columnsToReadMap.get("FLG_DISMISSIONE") != null)
			dto.setFlgDismissione(rs.getBigDecimal("FLG_DISMISSIONE"));

		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		// colonna [FK_MARCA]
		if (mapAllColumns || columnsToReadMap.get("FK_MARCA") != null)
			dto.setFkMarca(rs.getBigDecimal("FK_MARCA"));

		if (mapAllColumns || columnsToReadMap.get("DES_DETTAGLIO_GT") != null)
			dto.setDescDettaglioGt(rs.getString("DES_DETTAGLIO_GT"));

		if (mapAllColumns || columnsToReadMap.get("DES_FLUIDO") != null)
			dto.setDescFluido(rs.getString("DES_FLUIDO"));

		if (mapAllColumns || columnsToReadMap.get("DES_COMBUSTIBILE") != null)
			dto.setDescCombustibile(rs.getString("DES_COMBUSTIBILE"));

		if (mapAllColumns || columnsToReadMap.get("DES_MARCA") != null)
			dto.setDescMarca(rs.getString("DES_MARCA"));

		// colonna [FK_COMBUSTIBILE]
		if (mapAllColumns || columnsToReadMap.get("FK_COMBUSTIBILE") != null)
			dto.setFkCombustibile(rs.getBigDecimal("FK_COMBUSTIBILE"));

		// colonna [MATRICOLA]
		if (mapAllColumns || columnsToReadMap.get("MATRICOLA") != null)
			dto.setMatricola(rs.getString("MATRICOLA"));

		// colonna [MODELLO]
		if (mapAllColumns || columnsToReadMap.get("MODELLO") != null)
			dto.setModello(rs.getString("MODELLO"));

		// colonna [POTENZA_TERMICA_KW]
		if (mapAllColumns || columnsToReadMap.get("POTENZA_TERMICA_KW") != null)
			dto.setPotenzaTermicaKw(rs.getBigDecimal("POTENZA_TERMICA_KW"));

		// colonna [NOTE]
		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("NOTE"));

		// colonna [TEMPO_MANUT_ANNI]
		if (mapAllColumns || columnsToReadMap.get("TEMPO_MANUT_ANNI") != null)
			dto.setTempoManutAnni(rs.getBigDecimal("TEMPO_MANUT_ANNI"));

		// colonna [MEDI_IMP_ORE_OPERATIVE]
		if (mapAllColumns || columnsToReadMap.get("MEDI_IMP_ORE_OPERATIVE") != null)
			dto.setMediImpOreOperative(rs.getBigDecimal("MEDI_IMP_ORE_OPERATIVE"));

		// colonna [ID_TIPO_CANNA_FUMARIA]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_CANNA_FUMARIA") != null)
			dto.setIdTipoCannaFumaria(rs.getBigDecimal("ID_TIPO_CANNA_FUMARIA"));

		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setCf(rs.getString("CODICE_FISCALE"));

		if (mapAllColumns || columnsToReadMap.get("NUMERO_REA") != null)
			dto.setNumeroRea(rs.getString("NUMERO_REA"));

		if (mapAllColumns || columnsToReadMap.get("SIGLA_REA") != null)
			dto.setSiglaRea(rs.getString("SIGLA_REA"));
		return dto;
	}

}
