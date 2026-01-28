package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTDettIspezGfDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTDettIspezGfDaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettIspezGfDto;

/**
 * RowMapper specifico del DAO SigitTDettIspezGfDao
 * @generated
 */
public class SigitTDettIspezGfDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTDettIspezGfDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTDettIspezGfDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTDettIspezGfDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTDettIspezGfDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTDettIspezGfDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTDettIspezGfDto) {
			return mapRow_internal((SigitTDettIspezGfDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTDettIspezGfDto mapRow_internal(SigitTDettIspezGfDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTDettIspezGfDto dto = objectToFill;

		// colonna [ID_DETT_ISPEZ_GF]
		if (mapAllColumns || columnsToReadMap.get("ID_DETT_ISPEZ_GF") != null)
			dto.setIdDettIspezGf(rs.getBigDecimal("ID_DETT_ISPEZ_GF"));

		// colonna [FK_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("FK_ALLEGATO") != null)
			dto.setFkAllegato(rs.getBigDecimal("FK_ALLEGATO"));

		// colonna [FK_TIPO_COMPONENTE]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_COMPONENTE") != null)
			dto.setFkTipoComponente(rs.getString("FK_TIPO_COMPONENTE"));

		// colonna [PROGRESSIVO]
		if (mapAllColumns || columnsToReadMap.get("PROGRESSIVO") != null)
			dto.setProgressivo(rs.getBigDecimal("PROGRESSIVO"));

		// colonna [CODICE_IMPIANTO]
		if (mapAllColumns || columnsToReadMap.get("CODICE_IMPIANTO") != null)
			dto.setCodiceImpianto(rs.getBigDecimal("CODICE_IMPIANTO"));

		// colonna [DATA_INSTALL]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSTALL") != null)
			dto.setDataInstall(rs.getDate("DATA_INSTALL"));

		// colonna [S6H_FLG_INVERTER]
		if (mapAllColumns || columnsToReadMap.get("S6H_FLG_INVERTER") != null)
			dto.setS6hFlgInverter(rs.getBigDecimal("S6H_FLG_INVERTER"));

		// colonna [S6N_FLG_FUGA_DIRETTA]
		if (mapAllColumns || columnsToReadMap.get("S6N_FLG_FUGA_DIRETTA") != null)
			dto.setS6nFlgFugaDiretta(rs.getBigDecimal("S6N_FLG_FUGA_DIRETTA"));

		// colonna [S6N_FLG_FUGA_INDIRETTA]
		if (mapAllColumns || columnsToReadMap.get("S6N_FLG_FUGA_INDIRETTA") != null)
			dto.setS6nFlgFugaIndiretta(rs.getBigDecimal("S6N_FLG_FUGA_INDIRETTA"));

		// colonna [S7A_FK_FREQUENZA_MANUT]
		if (mapAllColumns || columnsToReadMap.get("S7A_FK_FREQUENZA_MANUT") != null)
			dto.setS7aFkFrequenzaManut((Integer) rs.getObject("S7A_FK_FREQUENZA_MANUT"));

		// colonna [S7A_FLG_MANUT_EFFETTUATA]
		if (mapAllColumns || columnsToReadMap.get("S7A_FLG_MANUT_EFFETTUATA") != null)
			dto.setS7aFlgManutEffettuata(rs.getBigDecimal("S7A_FLG_MANUT_EFFETTUATA"));

		// colonna [S7A_DATA_ULTIMA_MANUT]
		if (mapAllColumns || columnsToReadMap.get("S7A_DATA_ULTIMA_MANUT") != null)
			dto.setS7aDataUltimaManut(rs.getDate("S7A_DATA_ULTIMA_MANUT"));

		// colonna [S7B_FLG_REGISTRO_APPARECC]
		if (mapAllColumns || columnsToReadMap.get("S7B_FLG_REGISTRO_APPARECC") != null)
			dto.setS7bFlgRegistroApparecc(rs.getBigDecimal("S7B_FLG_REGISTRO_APPARECC"));

		// colonna [S7C_FLG_REE_PRESENTE]
		if (mapAllColumns || columnsToReadMap.get("S7C_FLG_REE_PRESENTE") != null)
			dto.setS7cFlgReePresente(rs.getBigDecimal("S7C_FLG_REE_PRESENTE"));

		// colonna [S7C_DATA_REE]
		if (mapAllColumns || columnsToReadMap.get("S7C_DATA_REE") != null)
			dto.setS7cDataRee(rs.getDate("S7C_DATA_REE"));

		// colonna [S7C_FLG_OSSERVAZIONI]
		if (mapAllColumns || columnsToReadMap.get("S7C_FLG_OSSERVAZIONI") != null)
			dto.setS7cFlgOsservazioni(rs.getBigDecimal("S7C_FLG_OSSERVAZIONI"));

		// colonna [S7C_FLG_RACCOMAND]
		if (mapAllColumns || columnsToReadMap.get("S7C_FLG_RACCOMAND") != null)
			dto.setS7cFlgRaccomand(rs.getBigDecimal("S7C_FLG_RACCOMAND"));

		// colonna [S7C_FLG_PRESCR]
		if (mapAllColumns || columnsToReadMap.get("S7C_FLG_PRESCR") != null)
			dto.setS7cFlgPrescr(rs.getBigDecimal("S7C_FLG_PRESCR"));

		// colonna [S8B_FLG_PROVE_RISCALDAMENTO]
		if (mapAllColumns || columnsToReadMap.get("S8B_FLG_PROVE_RISCALDAMENTO") != null)
			dto.setS8bFlgProveRiscaldamento(rs.getBigDecimal("S8B_FLG_PROVE_RISCALDAMENTO"));

		// colonna [S8B_FLG_PROVE_RAFFRESCAMENTO]
		if (mapAllColumns || columnsToReadMap.get("S8B_FLG_PROVE_RAFFRESCAMENTO") != null)
			dto.setS8bFlgProveRaffrescamento(rs.getBigDecimal("S8B_FLG_PROVE_RAFFRESCAMENTO"));

		// colonna [S8C_FLG_FILTRI_PULITI]
		if (mapAllColumns || columnsToReadMap.get("S8C_FLG_FILTRI_PULITI") != null)
			dto.setS8cFlgFiltriPuliti(rs.getBigDecimal("S8C_FLG_FILTRI_PULITI"));

		// colonna [S8D_FLG_ASSENZA_PERDITE_GAS]
		if (mapAllColumns || columnsToReadMap.get("S8D_FLG_ASSENZA_PERDITE_GAS") != null)
			dto.setS8dFlgAssenzaPerditeGas(rs.getBigDecimal("S8D_FLG_ASSENZA_PERDITE_GAS"));

		// colonna [S8E_MARCA_STRUM_MISURA]
		if (mapAllColumns || columnsToReadMap.get("S8E_MARCA_STRUM_MISURA") != null)
			dto.setS8eMarcaStrumMisura(rs.getString("S8E_MARCA_STRUM_MISURA"));

		// colonna [S8E_MODELLO_STRUM_MISURA]
		if (mapAllColumns || columnsToReadMap.get("S8E_MODELLO_STRUM_MISURA") != null)
			dto.setS8eModelloStrumMisura(rs.getString("S8E_MODELLO_STRUM_MISURA"));

		// colonna [S8E_MATRICOLA_STRUM_MISURA]
		if (mapAllColumns || columnsToReadMap.get("S8E_MATRICOLA_STRUM_MISURA") != null)
			dto.setS8eMatricolaStrumMisura(rs.getString("S8E_MATRICOLA_STRUM_MISURA"));

		// colonna [S8F_POT_ASSORBITA_KW]
		if (mapAllColumns || columnsToReadMap.get("S8F_POT_ASSORBITA_KW") != null)
			dto.setS8fPotAssorbitaKw(rs.getBigDecimal("S8F_POT_ASSORBITA_KW"));

		// colonna [S8G_FLG_STRUMENTAZIONE_FISSA]
		if (mapAllColumns || columnsToReadMap.get("S8G_FLG_STRUMENTAZIONE_FISSA") != null)
			dto.setS8gFlgStrumentazioneFissa(rs.getBigDecimal("S8G_FLG_STRUMENTAZIONE_FISSA"));

		// colonna [S8H_OPERATORE_DENOMINAZIONE]
		if (mapAllColumns || columnsToReadMap.get("S8H_OPERATORE_DENOMINAZIONE") != null)
			dto.setS8hOperatoreDenominazione(rs.getString("S8H_OPERATORE_DENOMINAZIONE"));

		// colonna [S8I_OPERATORE_NUM_ISCRIZ]
		if (mapAllColumns || columnsToReadMap.get("S8I_OPERATORE_NUM_ISCRIZ") != null)
			dto.setS8iOperatoreNumIscriz(rs.getString("S8I_OPERATORE_NUM_ISCRIZ"));

		// colonna [S8J_SURRISCALDAMENTO_K]
		if (mapAllColumns || columnsToReadMap.get("S8J_SURRISCALDAMENTO_K") != null)
			dto.setS8jSurriscaldamentoK(rs.getBigDecimal("S8J_SURRISCALDAMENTO_K"));

		// colonna [S8J_SOTTORAFFREDDAMENTO_K]
		if (mapAllColumns || columnsToReadMap.get("S8J_SOTTORAFFREDDAMENTO_K") != null)
			dto.setS8jSottoraffreddamentoK(rs.getBigDecimal("S8J_SOTTORAFFREDDAMENTO_K"));

		// colonna [S8J_TEMP_CONDENSAZIONE_C]
		if (mapAllColumns || columnsToReadMap.get("S8J_TEMP_CONDENSAZIONE_C") != null)
			dto.setS8jTempCondensazioneC(rs.getBigDecimal("S8J_TEMP_CONDENSAZIONE_C"));

		// colonna [S8J_TEMP_EVAPORAZIONE_C]
		if (mapAllColumns || columnsToReadMap.get("S8J_TEMP_EVAPORAZIONE_C") != null)
			dto.setS8jTempEvaporazioneC(rs.getBigDecimal("S8J_TEMP_EVAPORAZIONE_C"));

		// colonna [S8J_TEMP_SORG_INGRESSO_C]
		if (mapAllColumns || columnsToReadMap.get("S8J_TEMP_SORG_INGRESSO_C") != null)
			dto.setS8jTempSorgIngressoC(rs.getBigDecimal("S8J_TEMP_SORG_INGRESSO_C"));

		// colonna [S8J_TEMP_SORG_USCITA_C]
		if (mapAllColumns || columnsToReadMap.get("S8J_TEMP_SORG_USCITA_C") != null)
			dto.setS8jTempSorgUscitaC(rs.getBigDecimal("S8J_TEMP_SORG_USCITA_C"));

		// colonna [S8J_TEMP_INGRESSO_FLUIDO_C]
		if (mapAllColumns || columnsToReadMap.get("S8J_TEMP_INGRESSO_FLUIDO_C") != null)
			dto.setS8jTempIngressoFluidoC(rs.getBigDecimal("S8J_TEMP_INGRESSO_FLUIDO_C"));

		// colonna [S8J_TEMP_USCITA_FLUIDO_C]
		if (mapAllColumns || columnsToReadMap.get("S8J_TEMP_USCITA_FLUIDO_C") != null)
			dto.setS8jTempUscitaFluidoC(rs.getBigDecimal("S8J_TEMP_USCITA_FLUIDO_C"));

		// colonna [S9A_FLG_VERIFICA_SUPERATA]
		if (mapAllColumns || columnsToReadMap.get("S9A_FLG_VERIFICA_SUPERATA") != null)
			dto.setS9aFlgVerificaSuperata(rs.getBigDecimal("S9A_FLG_VERIFICA_SUPERATA"));

		// colonna [S9B_FLG_RISPETTO_NORMATIVA]
		if (mapAllColumns || columnsToReadMap.get("S9B_FLG_RISPETTO_NORMATIVA") != null)
			dto.setS9bFlgRispettoNormativa(rs.getBigDecimal("S9B_FLG_RISPETTO_NORMATIVA"));

		// colonna [S9C_FLG_NO_RISPETTO_7A]
		if (mapAllColumns || columnsToReadMap.get("S9C_FLG_NO_RISPETTO_7A") != null)
			dto.setS9cFlgNoRispetto7a(rs.getBigDecimal("S9C_FLG_NO_RISPETTO_7A"));

		// colonna [S9C_FLG_NO_RISPETTO_7B]
		if (mapAllColumns || columnsToReadMap.get("S9C_FLG_NO_RISPETTO_7B") != null)
			dto.setS9cFlgNoRispetto7b(rs.getBigDecimal("S9C_FLG_NO_RISPETTO_7B"));

		// colonna [S9C_FLG_NO_RISPETTO_8D]
		if (mapAllColumns || columnsToReadMap.get("S9C_FLG_NO_RISPETTO_8D") != null)
			dto.setS9cFlgNoRispetto8d(rs.getBigDecimal("S9C_FLG_NO_RISPETTO_8D"));

		// colonna [S9C_FLG_NO_RISPETTO_9A]
		if (mapAllColumns || columnsToReadMap.get("S9C_FLG_NO_RISPETTO_9A") != null)
			dto.setS9cFlgNoRispetto9a(rs.getBigDecimal("S9C_FLG_NO_RISPETTO_9A"));

		// colonna [S7A_FREQUENZA_MANUT_ALTRO]
		if (mapAllColumns || columnsToReadMap.get("S7A_FREQUENZA_MANUT_ALTRO") != null)
			dto.setS7aFrequenzaManutAltro(rs.getString("S7A_FREQUENZA_MANUT_ALTRO"));

		// colonna [S8A_N_CIRCUITO]
		if (mapAllColumns || columnsToReadMap.get("S8A_N_CIRCUITO") != null)
			dto.setS8aNCircuito(rs.getString("S8A_N_CIRCUITO"));

		// colonna [DATA_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("DATA_ULT_MOD") != null)
			dto.setDataUltMod(rs.getTimestamp("DATA_ULT_MOD"));

		// colonna [UTENTE_ULT_MOD]
		if (mapAllColumns || columnsToReadMap.get("UTENTE_ULT_MOD") != null)
			dto.setUtenteUltMod(rs.getString("UTENTE_ULT_MOD"));

		// colonna [CONTROLLOWEB]
		if (mapAllColumns || columnsToReadMap.get("CONTROLLOWEB") != null) {
			dto.setControlloWeb(rs.getTimestamp("CONTROLLOWEB"));
		}
		
		return dto;
	}

}
