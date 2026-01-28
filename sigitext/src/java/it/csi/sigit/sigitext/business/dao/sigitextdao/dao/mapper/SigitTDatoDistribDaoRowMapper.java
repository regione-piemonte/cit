package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTDatoDistribDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTDatoDistribDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDatoDistribDto;

/**
 * RowMapper specifico del DAO SigitTDatoDistribDao
 * @generated
 */
public class SigitTDatoDistribDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTDatoDistribDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTDatoDistribDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTDatoDistribDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTDatoDistribDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTDatoDistribDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTDatoDistribDto) {
			return mapRow_internal((SigitTDatoDistribDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTDatoDistribDto mapRow_internal(SigitTDatoDistribDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTDatoDistribDto dto = objectToFill;

		// colonna [ID_DATO_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("ID_DATO_DISTRIB") != null)
			dto.setIdDatoDistrib(rs.getInt("ID_DATO_DISTRIB"));

		// colonna [FK_TIPO_CONTRATTO]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_CONTRATTO") != null)
			dto.setFkTipoContratto((Integer) rs.getObject("FK_TIPO_CONTRATTO"));

		// colonna [FK_IMPORT_DISTRIB]
		if (mapAllColumns || columnsToReadMap.get("FK_IMPORT_DISTRIB") != null)
			dto.setFkImportDistrib((Integer) rs.getObject("FK_IMPORT_DISTRIB"));

		// colonna [FK_CATEGORIA_UTIL]
		if (mapAllColumns || columnsToReadMap.get("FK_CATEGORIA_UTIL") != null)
			dto.setFkCategoriaUtil(rs.getString("FK_CATEGORIA_UTIL"));

		// colonna [FK_COMBUSTIBILE]
		if (mapAllColumns || columnsToReadMap.get("FK_COMBUSTIBILE") != null)
			dto.setFkCombustibile(rs.getBigDecimal("FK_COMBUSTIBILE"));

		// colonna [CODICE_ASSENZA_CATAST]
		if (mapAllColumns || columnsToReadMap.get("CODICE_ASSENZA_CATAST") != null)
			dto.setCodiceAssenzaCatast((Integer) rs.getObject("CODICE_ASSENZA_CATAST"));

		// colonna [FK_UNITA_MISURA]
		if (mapAllColumns || columnsToReadMap.get("FK_UNITA_MISURA") != null)
			dto.setFkUnitaMisura(rs.getString("FK_UNITA_MISURA"));

		// colonna [FLG_PF_PG]
		if (mapAllColumns || columnsToReadMap.get("FLG_PF_PG") != null)
			dto.setFlgPfPg(rs.getString("FLG_PF_PG"));

		// colonna [COGNOME_DENOM]
		if (mapAllColumns || columnsToReadMap.get("COGNOME_DENOM") != null)
			dto.setCognomeDenom(rs.getString("COGNOME_DENOM"));

		// colonna [NOME]
		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("NOME"));

		// colonna [CF_PIVA]
		if (mapAllColumns || columnsToReadMap.get("CF_PIVA") != null)
			dto.setCfPiva(rs.getString("CF_PIVA"));

		// colonna [ANNO_RIF]
		if (mapAllColumns || columnsToReadMap.get("ANNO_RIF") != null)
			dto.setAnnoRif(rs.getBigDecimal("ANNO_RIF"));

		// colonna [NR_MESI_FATTUR]
		if (mapAllColumns || columnsToReadMap.get("NR_MESI_FATTUR") != null)
			dto.setNrMesiFattur(rs.getBigDecimal("NR_MESI_FATTUR"));

		// colonna [DUG]
		if (mapAllColumns || columnsToReadMap.get("DUG") != null)
			dto.setDug(rs.getString("DUG"));

		// colonna [INDIRIZZO]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO") != null)
			dto.setIndirizzo(rs.getString("INDIRIZZO"));

		// colonna [CIVICO]
		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("CIVICO"));

		// colonna [CAP]
		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("CAP"));

		// colonna [ISTAT_COMUNE]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE") != null)
			dto.setIstatComune(rs.getString("ISTAT_COMUNE"));

		// colonna [POD_PDR]
		if (mapAllColumns || columnsToReadMap.get("POD_PDR") != null)
			dto.setPodPdr(rs.getString("POD_PDR"));

		// colonna [CONSUMO_ANNO]
		if (mapAllColumns || columnsToReadMap.get("CONSUMO_ANNO") != null)
			dto.setConsumoAnno(rs.getBigDecimal("CONSUMO_ANNO"));

		// colonna [CONSUMO_MENSILE]
		if (mapAllColumns || columnsToReadMap.get("CONSUMO_MENSILE") != null)
			dto.setConsumoMensile(rs.getBigDecimal("CONSUMO_MENSILE"));

		// colonna [MESE_RIFERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("MESE_RIFERIMENTO") != null)
			dto.setMeseRiferimento(rs.getBigDecimal("MESE_RIFERIMENTO"));

		// colonna [CONSUMO_GIORNALIERO]
		if (mapAllColumns || columnsToReadMap.get("CONSUMO_GIORNALIERO") != null)
			dto.setConsumoGiornaliero(rs.getBigDecimal("CONSUMO_GIORNALIERO"));

		// colonna [GIORNO_RIFERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("GIORNO_RIFERIMENTO") != null)
			dto.setGiornoRiferimento(rs.getDate("GIORNO_RIFERIMENTO"));

		// colonna [VOLUMETRIA]
		if (mapAllColumns || columnsToReadMap.get("VOLUMETRIA") != null)
			dto.setVolumetria(rs.getBigDecimal("VOLUMETRIA"));

		// colonna [FLG_PF_PG_FATT]
		if (mapAllColumns || columnsToReadMap.get("FLG_PF_PG_FATT") != null)
			dto.setFlgPfPgFatt(rs.getString("FLG_PF_PG_FATT"));

		// colonna [COGNOME_DENOM_FATT]
		if (mapAllColumns || columnsToReadMap.get("COGNOME_DENOM_FATT") != null)
			dto.setCognomeDenomFatt(rs.getString("COGNOME_DENOM_FATT"));

		// colonna [NOME_FATT]
		if (mapAllColumns || columnsToReadMap.get("NOME_FATT") != null)
			dto.setNomeFatt(rs.getString("NOME_FATT"));

		// colonna [CF_PIVA_FATT]
		if (mapAllColumns || columnsToReadMap.get("CF_PIVA_FATT") != null)
			dto.setCfPivaFatt(rs.getString("CF_PIVA_FATT"));

		// colonna [DUG_FATT]
		if (mapAllColumns || columnsToReadMap.get("DUG_FATT") != null)
			dto.setDugFatt(rs.getString("DUG_FATT"));

		// colonna [INDIRIZZO_FATT]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_FATT") != null)
			dto.setIndirizzoFatt(rs.getString("INDIRIZZO_FATT"));

		// colonna [CIVICO_FATT]
		if (mapAllColumns || columnsToReadMap.get("CIVICO_FATT") != null)
			dto.setCivicoFatt(rs.getString("CIVICO_FATT"));

		// colonna [CAP_FATT]
		if (mapAllColumns || columnsToReadMap.get("CAP_FATT") != null)
			dto.setCapFatt(rs.getString("CAP_FATT"));

		// colonna [ISTAT_COMUNE_FATT]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE_FATT") != null)
			dto.setIstatComuneFatt(rs.getString("ISTAT_COMUNE_FATT"));

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getInt("CODICE_IMPIANTO"));
		
		return dto;
	}

}
