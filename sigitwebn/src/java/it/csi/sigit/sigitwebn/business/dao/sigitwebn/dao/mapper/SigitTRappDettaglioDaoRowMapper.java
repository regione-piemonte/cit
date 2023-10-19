package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTRappDettaglioDao
 * @generated
 */
public class SigitTRappDettaglioDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SigitTRappDettaglioDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SigitTRappDettaglioDaoRowMapper(String[] columnsToRead, Class dtoClass, SigitTRappDettaglioDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTRappDettaglioDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SigitTRappDettaglioDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SigitTRappDettaglioDto) {
			return mapRow_internal((SigitTRappDettaglioDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SigitTRappDettaglioDto mapRow_internal(SigitTRappDettaglioDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SigitTRappDettaglioDto dto = objectToFill;

		// colonna [ID_RAPPORTO_DETTAGLIO]
		if (mapAllColumns || columnsToReadMap.get("ID_RAPPORTO_DETTAGLIO") != null)
			dto.setIdRapportoDettaglio(rs.getBigDecimal("ID_RAPPORTO_DETTAGLIO"));

		// colonna [FK_RAPPORTO_CONTROLLO]
		if (mapAllColumns || columnsToReadMap.get("FK_RAPPORTO_CONTROLLO") != null)
			dto.setFkRapportoControllo(rs.getBigDecimal("FK_RAPPORTO_CONTROLLO"));

		// colonna [FLG_PENDENZE]
		if (mapAllColumns || columnsToReadMap.get("FLG_PENDENZE") != null)
			dto.setFlgPendenze(rs.getBigDecimal("FLG_PENDENZE"));

		// colonna [FLG_SEZIONI]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZIONI") != null)
			dto.setFlgSezioni(rs.getBigDecimal("FLG_SEZIONI"));

		// colonna [FLG_CURVE]
		if (mapAllColumns || columnsToReadMap.get("FLG_CURVE") != null)
			dto.setFlgCurve(rs.getBigDecimal("FLG_CURVE"));

		// colonna [FLG_LUNGHEZZA]
		if (mapAllColumns || columnsToReadMap.get("FLG_LUNGHEZZA") != null)
			dto.setFlgLunghezza(rs.getBigDecimal("FLG_LUNGHEZZA"));

		// colonna [FLG_STATO_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_STATO_OK") != null)
			dto.setFlgStatoOk(rs.getBigDecimal("FLG_STATO_OK"));

		// colonna [FLG_SINGOLO]
		if (mapAllColumns || columnsToReadMap.get("FLG_SINGOLO") != null)
			dto.setFlgSingolo(rs.getBigDecimal("FLG_SINGOLO"));

		// colonna [FLG_A_PARETE]
		if (mapAllColumns || columnsToReadMap.get("FLG_A_PARETE") != null)
			dto.setFlgAParete(rs.getBigDecimal("FLG_A_PARETE"));

		// colonna [FLG_NO_RIFLUSSO]
		if (mapAllColumns || columnsToReadMap.get("FLG_NO_RIFLUSSO") != null)
			dto.setFlgNoRiflusso(rs.getBigDecimal("FLG_NO_RIFLUSSO"));

		// colonna [FLG_COIBENTAZIONI]
		if (mapAllColumns || columnsToReadMap.get("FLG_COIBENTAZIONI") != null)
			dto.setFlgCoibentazioni(rs.getBigDecimal("FLG_COIBENTAZIONI"));

		// colonna [FLG_NO_PERDITE]
		if (mapAllColumns || columnsToReadMap.get("FLG_NO_PERDITE") != null)
			dto.setFlgNoPerdite(rs.getBigDecimal("FLG_NO_PERDITE"));

		// colonna [FLG_CANNAFUMARIA_COLLETTIVA]
		if (mapAllColumns || columnsToReadMap.get("FLG_CANNAFUMARIA_COLLETTIVA") != null)
			dto.setFlgCannafumariaCollettiva(rs.getBigDecimal("FLG_CANNAFUMARIA_COLLETTIVA"));

		// colonna [FLG_UGELLI_PULITI]
		if (mapAllColumns || columnsToReadMap.get("FLG_UGELLI_PULITI") != null)
			dto.setFlgUgelliPuliti(rs.getBigDecimal("FLG_UGELLI_PULITI"));

		// colonna [FLG_ROMPITIRAGGIO_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_ROMPITIRAGGIO_OK") != null)
			dto.setFlgRompitiraggioOk(rs.getBigDecimal("FLG_ROMPITIRAGGIO_OK"));

		// colonna [FLG_SCAMBIATORE_PULITO]
		if (mapAllColumns || columnsToReadMap.get("FLG_SCAMBIATORE_PULITO") != null)
			dto.setFlgScambiatorePulito(rs.getBigDecimal("FLG_SCAMBIATORE_PULITO"));

		// colonna [FLG_FUNZIONAMENTO_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_FUNZIONAMENTO_OK") != null)
			dto.setFlgFunzionamentoOk(rs.getBigDecimal("FLG_FUNZIONAMENTO_OK"));

		// colonna [FLG_DISPOSITIVI_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_DISPOSITIVI_OK") != null)
			dto.setFlgDispositiviOk(rs.getBigDecimal("FLG_DISPOSITIVI_OK"));

		// colonna [FLG_ASSENZA_PERDITE_ACQUA]
		if (mapAllColumns || columnsToReadMap.get("FLG_ASSENZA_PERDITE_ACQUA") != null)
			dto.setFlgAssenzaPerditeAcqua(rs.getBigDecimal("FLG_ASSENZA_PERDITE_ACQUA"));

		// colonna [FLG_VALVOLA_SICUR_LIBERA]
		if (mapAllColumns || columnsToReadMap.get("FLG_VALVOLA_SICUR_LIBERA") != null)
			dto.setFlgValvolaSicurLibera(rs.getBigDecimal("FLG_VALVOLA_SICUR_LIBERA"));

		// colonna [FLG_VASO_ESP_CARICO]
		if (mapAllColumns || columnsToReadMap.get("FLG_VASO_ESP_CARICO") != null)
			dto.setFlgVasoEspCarico(rs.getBigDecimal("FLG_VASO_ESP_CARICO"));

		// colonna [FLG_SICUREZZA_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_SICUREZZA_OK") != null)
			dto.setFlgSicurezzaOk(rs.getBigDecimal("FLG_SICUREZZA_OK"));

		// colonna [FLG_NO_USURE_DEFORMAZIONI]
		if (mapAllColumns || columnsToReadMap.get("FLG_NO_USURE_DEFORMAZIONI") != null)
			dto.setFlgNoUsureDeformazioni(rs.getBigDecimal("FLG_NO_USURE_DEFORMAZIONI"));

		// colonna [FLG_CIRCUITO_ARIA_LIBERO]
		if (mapAllColumns || columnsToReadMap.get("FLG_CIRCUITO_ARIA_LIBERO") != null)
			dto.setFlgCircuitoAriaLibero(rs.getBigDecimal("FLG_CIRCUITO_ARIA_LIBERO"));

		// colonna [FLG_ACCOPP_GEN_OK]
		if (mapAllColumns || columnsToReadMap.get("FLG_ACCOPP_GEN_OK") != null)
			dto.setFlgAccoppGenOk(rs.getBigDecimal("FLG_ACCOPP_GEN_OK"));

		// colonna [FLG_FUNZIONAMENTO_CORRETTO]
		if (mapAllColumns || columnsToReadMap.get("FLG_FUNZIONAMENTO_CORRETTO") != null)
			dto.setFlgFunzionamentoCorretto(rs.getBigDecimal("FLG_FUNZIONAMENTO_CORRETTO"));

		// colonna [TEMP_FUMI]
		if (mapAllColumns || columnsToReadMap.get("TEMP_FUMI") != null)
			dto.setTempFumi(rs.getBigDecimal("TEMP_FUMI"));

		// colonna [TEMP_ARIA]
		if (mapAllColumns || columnsToReadMap.get("TEMP_ARIA") != null)
			dto.setTempAria(rs.getBigDecimal("TEMP_ARIA"));

		// colonna [O2]
		if (mapAllColumns || columnsToReadMap.get("O2") != null)
			dto.setO2(rs.getBigDecimal("O2"));

		// colonna [CO2]
		if (mapAllColumns || columnsToReadMap.get("CO2") != null)
			dto.setCo2(rs.getBigDecimal("CO2"));

		// colonna [BACHARACH]
		if (mapAllColumns || columnsToReadMap.get("BACHARACH") != null)
			dto.setBacharach(rs.getBigDecimal("BACHARACH"));

		// colonna [CO]
		if (mapAllColumns || columnsToReadMap.get("CO") != null)
			dto.setCo(rs.getBigDecimal("CO"));

		// colonna [REND_COMB]
		if (mapAllColumns || columnsToReadMap.get("REND_COMB") != null)
			dto.setRendComb(rs.getBigDecimal("REND_COMB"));

		// colonna [FLG_LIBRETTO_BRUCIATORE]
		if (mapAllColumns || columnsToReadMap.get("FLG_LIBRETTO_BRUCIATORE") != null)
			dto.setFlgLibrettoBruciatore(rs.getBigDecimal("FLG_LIBRETTO_BRUCIATORE"));

		// colonna [NOX]
		if (mapAllColumns || columnsToReadMap.get("NOX") != null)
			dto.setNox(rs.getBigDecimal("NOX"));

		// colonna [FLG_LIBRETTO_CALDAIA]
		if (mapAllColumns || columnsToReadMap.get("FLG_LIBRETTO_CALDAIA") != null)
			dto.setFlgLibrettoCaldaia(rs.getBigDecimal("FLG_LIBRETTO_CALDAIA"));

		// colonna [NOTE_DOCUMENTAZIONE]
		if (mapAllColumns || columnsToReadMap.get("NOTE_DOCUMENTAZIONE") != null)
			dto.setNoteDocumentazione(rs.getString("NOTE_DOCUMENTAZIONE"));

		// colonna [FLG_EV_LINEE_ELETTRICHE]
		if (mapAllColumns || columnsToReadMap.get("FLG_EV_LINEE_ELETTRICHE") != null)
			dto.setFlgEvLineeElettriche(rs.getBigDecimal("FLG_EV_LINEE_ELETTRICHE"));

		// colonna [FLG_EV_BRUCIATORE]
		if (mapAllColumns || columnsToReadMap.get("FLG_EV_BRUCIATORE") != null)
			dto.setFlgEvBruciatore(rs.getBigDecimal("FLG_EV_BRUCIATORE"));

		// colonna [FLG_EV_GENERATORE_CALORE]
		if (mapAllColumns || columnsToReadMap.get("FLG_EV_GENERATORE_CALORE") != null)
			dto.setFlgEvGeneratoreCalore(rs.getBigDecimal("FLG_EV_GENERATORE_CALORE"));

		// colonna [FLG_EV_CANALI_FUMO]
		if (mapAllColumns || columnsToReadMap.get("FLG_EV_CANALI_FUMO") != null)
			dto.setFlgEvCanaliFumo(rs.getBigDecimal("FLG_EV_CANALI_FUMO"));

		// colonna [FLG_CONTROLLO_REND]
		if (mapAllColumns || columnsToReadMap.get("FLG_CONTROLLO_REND") != null)
			dto.setFlgControlloRend(rs.getBigDecimal("FLG_CONTROLLO_REND"));

		// colonna [TIRAGGIO]
		if (mapAllColumns || columnsToReadMap.get("TIRAGGIO") != null)
			dto.setTiraggio(rs.getBigDecimal("TIRAGGIO"));

		// colonna [NOTE]
		if (mapAllColumns || columnsToReadMap.get("NOTE") != null)
			dto.setNote(rs.getString("NOTE"));

		// colonna [B_FLG_DICHIAR_CONFORM]
		if (mapAllColumns || columnsToReadMap.get("B_FLG_DICHIAR_CONFORM") != null)
			dto.setBFlgDichiarConform(rs.getBigDecimal("B_FLG_DICHIAR_CONFORM"));

		// colonna [F_RACCOMANDAZIONI]
		if (mapAllColumns || columnsToReadMap.get("F_RACCOMANDAZIONI") != null)
			dto.setFRaccomandazioni(rs.getString("F_RACCOMANDAZIONI"));

		// colonna [F_PRESCRIZIONI]
		if (mapAllColumns || columnsToReadMap.get("F_PRESCRIZIONI") != null)
			dto.setFPrescrizioni(rs.getString("F_PRESCRIZIONI"));

		return dto;
	}

}
