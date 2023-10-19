package it.csi.sigit.sigitweba.business.dao.sigitweba.dao.mapper;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.impl.*;
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

		if (dtoInstance instanceof SigitRPfPgDelegaByIdPersonaFisicaDto) {
			return mapRow_internal((SigitRPfPgDelegaByIdPersonaFisicaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof SigitRPfPgDelegaByCodiceFiscalePFDto) {
			return mapRow_internal((SigitRPfPgDelegaByCodiceFiscalePFDto) dtoInstance, rs, row);
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
	 * Metodo specifico di mapping relativo al DTO custom SigitRPfPgDelegaByIdPersonaFisicaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRPfPgDelegaByIdPersonaFisicaDto
	 * @generated
	 */

	public SigitRPfPgDelegaByIdPersonaFisicaDto mapRow_internal(SigitRPfPgDelegaByIdPersonaFisicaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		SigitRPfPgDelegaByIdPersonaFisicaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_FISICA") != null)
			dto.setAIdPersonaFisica(rs.getBigDecimal("ID_PERSONA_FISICA"));

		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_GIURIDICA") != null)
			dto.setAIdPersonaGiuridica(rs.getBigDecimal("ID_PERSONA_GIURIDICA"));

		if (mapAllColumns || columnsToReadMap.get("FLG_DELEGA") != null)
			dto.setAFlgDelega(rs.getString("FLG_DELEGA"));

		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO") != null)
			dto.setADataInizio(rs.getDate("DATA_INIZIO"));

		if (mapAllColumns || columnsToReadMap.get("DATA_FINE") != null)
			dto.setADataFine(rs.getDate("DATA_FINE"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE") != null)
			dto.setBDenominazione(rs.getString("DENOMINAZIONE"));

		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setBCodiceFiscale(rs.getString("CODICE_FISCALE"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_SITAD") != null)
			dto.setBIndirizzoSitad(rs.getString("INDIRIZZO_SITAD"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_NON_TROVATO") != null)
			dto.setBIndirizzoNonTrovato(rs.getString("INDIRIZZO_NON_TROVATO"));

		if (mapAllColumns || columnsToReadMap.get("SIGLA_PROV") != null)
			dto.setBSiglaProv(rs.getString("SIGLA_PROV"));

		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE") != null)
			dto.setBIstatComune(rs.getString("ISTAT_COMUNE"));

		if (mapAllColumns || columnsToReadMap.get("COMUNE") != null)
			dto.setBComune(rs.getString("COMUNE"));

		if (mapAllColumns || columnsToReadMap.get("PROVINCIA") != null)
			dto.setBProvincia(rs.getString("PROVINCIA"));

		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setBCivico(rs.getString("CIVICO"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setBCap(rs.getString("CAP"));

		if (mapAllColumns || columnsToReadMap.get("EMAIL") != null)
			dto.setBEmail(rs.getString("EMAIL"));

		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO_ATTIVITA") != null)
			dto.setBDataInizioAttivita(rs.getDate("DATA_INIZIO_ATTIVITA"));

		if (mapAllColumns || columnsToReadMap.get("DATA_CESSAZIONE") != null)
			dto.setBDataCessazione(rs.getDate("DATA_CESSAZIONE"));

		if (mapAllColumns || columnsToReadMap.get("SIGLA_REA") != null)
			dto.setBSiglaRea(rs.getString("SIGLA_REA"));

		if (mapAllColumns || columnsToReadMap.get("NUMERO_REA") != null)
			dto.setBNumeroRea(rs.getBigDecimal("NUMERO_REA"));

		if (mapAllColumns || columnsToReadMap.get("FLG_AMMINISTRATORE") != null)
			dto.setBFlgAmministratore(rs.getBigDecimal("FLG_AMMINISTRATORE"));

		if (mapAllColumns || columnsToReadMap.get("FLG_TERZO_RESPONSABILE") != null)
			dto.setBFlgTerzoResponsabile(rs.getBigDecimal("FLG_TERZO_RESPONSABILE"));

		if (mapAllColumns || columnsToReadMap.get("RUOLOACCRED") != null)
			dto.setRuoloAccred(rs.getBigDecimal("ruoloAccred"));

		if (mapAllColumns || columnsToReadMap.get("TIPODM") != null)
			dto.setTipoDm(rs.getString("tipoDm"));

		if (mapAllColumns || columnsToReadMap.get("FK_L2") != null)
			dto.setBFkL2(rs.getBigDecimal("FK_L2"));

		if (mapAllColumns || columnsToReadMap.get("FLG_DM37_LETTERAC") != null)
			dto.setBFlgDm37Letterac(rs.getBigDecimal("FLG_DM37_LETTERAC"));

		if (mapAllColumns || columnsToReadMap.get("FLG_DM37_LETTERAD") != null)
			dto.setBFlgDm37Letterad(rs.getBigDecimal("FLG_DM37_LETTERAD"));

		if (mapAllColumns || columnsToReadMap.get("FLG_DM37_LETTERAE") != null)
			dto.setBFlgDm37Letterae(rs.getBigDecimal("FLG_DM37_LETTERAE"));

		if (mapAllColumns || columnsToReadMap.get("FLG_FGAS") != null)
			dto.setBFlgFgas(rs.getBigDecimal("FLG_FGAS"));

		if (mapAllColumns || columnsToReadMap.get("FLG_CONDUTTORE") != null)
			dto.setBFlgConduttore(rs.getBigDecimal("FLG_CONDUTTORE"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SOGG_INCARICATO") != null)
			dto.setBFlgSoggIncaricato(rs.getBigDecimal("FLG_SOGG_INCARICATO"));

		if (mapAllColumns || columnsToReadMap.get("DELEGA_SOGG_INCARICATO") != null)
			dto.setBDelegaSoggIncaricato(rs.getString("DELEGA_SOGG_INCARICATO"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom SigitRPfPgDelegaByCodiceFiscalePFDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitRPfPgDelegaByCodiceFiscalePFDto
	 * @generated
	 */

	public SigitRPfPgDelegaByCodiceFiscalePFDto mapRow_internal(SigitRPfPgDelegaByCodiceFiscalePFDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		SigitRPfPgDelegaByCodiceFiscalePFDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_FISICA") != null)
			dto.setAIdPersonaFisica(rs.getBigDecimal("ID_PERSONA_FISICA"));

		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA_GIURIDICA") != null)
			dto.setAIdPersonaGiuridica(rs.getBigDecimal("ID_PERSONA_GIURIDICA"));

		if (mapAllColumns || columnsToReadMap.get("FLG_DELEGA") != null)
			dto.setAFlgDelega(rs.getString("FLG_DELEGA"));

		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO") != null)
			dto.setADataInizio(rs.getDate("DATA_INIZIO"));

		if (mapAllColumns || columnsToReadMap.get("DATA_FINE") != null)
			dto.setADataFine(rs.getDate("DATA_FINE"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE") != null)
			dto.setBDenominazione(rs.getString("DENOMINAZIONE"));

		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setBCodiceFiscale(rs.getString("CODICE_FISCALE"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_SITAD") != null)
			dto.setBIndirizzoSitad(rs.getString("INDIRIZZO_SITAD"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_NON_TROVATO") != null)
			dto.setBIndirizzoNonTrovato(rs.getString("INDIRIZZO_NON_TROVATO"));

		if (mapAllColumns || columnsToReadMap.get("SIGLA_PROV") != null)
			dto.setBSiglaProv(rs.getString("SIGLA_PROV"));

		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE") != null)
			dto.setBIstatComune(rs.getString("ISTAT_COMUNE"));

		if (mapAllColumns || columnsToReadMap.get("COMUNE") != null)
			dto.setBComune(rs.getString("COMUNE"));

		if (mapAllColumns || columnsToReadMap.get("PROVINCIA") != null)
			dto.setBProvincia(rs.getString("PROVINCIA"));

		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setBCivico(rs.getString("CIVICO"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setBCap(rs.getString("CAP"));

		if (mapAllColumns || columnsToReadMap.get("EMAIL") != null)
			dto.setBEmail(rs.getString("EMAIL"));

		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO_ATTIVITA") != null)
			dto.setBDataInizioAttivita(rs.getDate("DATA_INIZIO_ATTIVITA"));

		if (mapAllColumns || columnsToReadMap.get("DATA_CESSAZIONE") != null)
			dto.setBDataCessazione(rs.getDate("DATA_CESSAZIONE"));

		if (mapAllColumns || columnsToReadMap.get("SIGLA_REA") != null)
			dto.setBSiglaRea(rs.getString("SIGLA_REA"));

		if (mapAllColumns || columnsToReadMap.get("NUMERO_REA") != null)
			dto.setBNumeroRea(rs.getBigDecimal("NUMERO_REA"));

		if (mapAllColumns || columnsToReadMap.get("FLG_AMMINISTRATORE") != null)
			dto.setBFlgAmministratore(rs.getBigDecimal("FLG_AMMINISTRATORE"));

		if (mapAllColumns || columnsToReadMap.get("FLG_TERZO_RESPONSABILE") != null)
			dto.setBFlgTerzoResponsabile(rs.getBigDecimal("FLG_TERZO_RESPONSABILE"));

		if (mapAllColumns || columnsToReadMap.get("FLG_DISTRIBUTORE") != null)
			dto.setBFlgDistributore(rs.getBigDecimal("FLG_DISTRIBUTORE"));

		if (mapAllColumns || columnsToReadMap.get("FLG_CAT") != null)
			dto.setBFlgCat(rs.getBigDecimal("FLG_CAT"));

		if (mapAllColumns || columnsToReadMap.get("RUOLOACCRED") != null)
			dto.setRuoloAccred(rs.getBigDecimal("ruoloAccred"));

		if (mapAllColumns || columnsToReadMap.get("TIPODM") != null)
			dto.setTipoDm(rs.getString("tipoDm"));

		if (mapAllColumns || columnsToReadMap.get("FK_L2") != null)
			dto.setBFkL2(rs.getBigDecimal("FK_L2"));

		if (mapAllColumns || columnsToReadMap.get("FLG_INDIRIZZO_ESTERO") != null)
			dto.setBFlgIndirizzoEstero(rs.getBigDecimal("FLG_INDIRIZZO_ESTERO"));

		if (mapAllColumns || columnsToReadMap.get("STATO_ESTERO") != null)
			dto.setBStatoEstero(rs.getString("STATO_ESTERO"));

		if (mapAllColumns || columnsToReadMap.get("CITTA_ESTERO") != null)
			dto.setBCittaEstero(rs.getString("CITTA_ESTERO"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_ESTERO") != null)
			dto.setBIndirizzoEstero(rs.getString("INDIRIZZO_ESTERO"));

		if (mapAllColumns || columnsToReadMap.get("CAP_ESTERO") != null)
			dto.setBCapEstero(rs.getString("CAP_ESTERO"));

		if (mapAllColumns || columnsToReadMap.get("FK_STATO_PG") != null)
			dto.setBFkStatoPg((Integer) rs.getObject("FK_STATO_PG"));

		if (mapAllColumns || columnsToReadMap.get("DES_STATO_PG") != null)
			dto.setDDesStatoPg(rs.getString("DES_STATO_PG"));

		if (mapAllColumns || columnsToReadMap.get("FLG_DM37_LETTERAC") != null)
			dto.setBFlgDm37Letterac(rs.getBigDecimal("FLG_DM37_LETTERAC"));

		if (mapAllColumns || columnsToReadMap.get("FLG_DM37_LETTERAD") != null)
			dto.setBFlgDm37Letterad(rs.getBigDecimal("FLG_DM37_LETTERAD"));

		if (mapAllColumns || columnsToReadMap.get("FLG_DM37_LETTERAE") != null)
			dto.setBFlgDm37Letterae(rs.getBigDecimal("FLG_DM37_LETTERAE"));

		if (mapAllColumns || columnsToReadMap.get("FLG_FGAS") != null)
			dto.setBFlgFgas(rs.getBigDecimal("FLG_FGAS"));

		if (mapAllColumns || columnsToReadMap.get("FLG_CONDUTTORE") != null)
			dto.setBFlgConduttore(rs.getBigDecimal("FLG_CONDUTTORE"));

		if (mapAllColumns || columnsToReadMap.get("FLG_SOGG_INCARICATO") != null)
			dto.setBFlgSoggIncaricato(rs.getBigDecimal("FLG_SOGG_INCARICATO"));

		if (mapAllColumns || columnsToReadMap.get("DELEGA_SOGG_INCARICATO") != null)
			dto.setBDelegaSoggIncaricato(rs.getString("DELEGA_SOGG_INCARICATO"));

		if (mapAllColumns || columnsToReadMap.get("PEC") != null)
			dto.setBPec(rs.getString("PEC"));

		if (mapAllColumns || columnsToReadMap.get("TELEFONO") != null)
			dto.setBTelefono(rs.getString("TELEFONO"));

		return dto;
	}

}
