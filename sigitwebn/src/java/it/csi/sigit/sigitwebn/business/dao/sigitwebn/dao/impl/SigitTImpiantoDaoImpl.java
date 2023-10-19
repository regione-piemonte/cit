package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.impl;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.mapper.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import it.csi.sigit.sigitwebn.business.dao.impl.*;
import it.csi.sigit.sigitwebn.business.dao.util.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import java.util.Map;
import java.util.TreeMap;

/*PROTECTED REGION ID(R-880302993) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTImpianto.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
 *   - aggiornamentoCoordinate (datagen::CustomFinder)
 *   - byAccertamentoIstatComune (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - updateDatiOnline (datagen::UpdateColumns)
 *   - updateBloccoNomina3R (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTImpiantoDaoImpl extends AbstractDAO implements SigitTImpiantoDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	/**
	 * Il DAO utilizza JDBC template per l'implementazione delle query.
	 * @generated
	 */
	protected NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 * @generated
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Metodo di inserimento del DAO sigitTImpianto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTImpiantoPk
	 * @generated
	 */

	public SigitTImpiantoPk insert(SigitTImpiantoDto dto)

	{
		LOG.debug("[SigitTImpiantoDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_IMPIANTO,ISTAT_COMUNE,FK_STATO,DATA_ASSEGNAZIONE,DATA_DISMISSIONE,DENOMINAZIONE_COMUNE,SIGLA_PROVINCIA,DENOMINAZIONE_PROVINCIA,L1_3_POT_H2O_KW,L1_3_POT_CLIMA_INV_KW,L1_3_POT_CLIMA_EST_KW,L1_3_ALTRO,L1_4_FLG_H2O,L1_4_FLG_ARIA,L1_4_ALTRO,L1_5_FLG_GENERATORE,L1_5_FLG_POMPA,L1_5_FLG_FRIGO,L1_5_FLG_TELERISC,L1_5_FLG_TELERAFFR,L1_5_FLG_COGENERATORE,L1_5_ALTRO,L1_5_SUP_PANNELLI_SOL_M2,L1_5_ALTRO_INTEGRAZIONE,L1_5_ALTRO_INTEGR_POT_KW,L1_5_FLG_ALTRO_CLIMA_INV,L1_5_FLG_ALTRO_CLIMA_ESTATE,L1_5_FLG_ALTRO_ACS,L1_5_ALTRO_DESC,DATA_ULT_MOD,UTENTE_ULT_MOD,MOTIVAZIONE,PROPRIETARIO,DATA_INSERIMENTO,NOTE,FLG_TIPO_IMPIANTO,FLG_APPARECC_UI_EXT,FLG_CONTABILIZZAZIONE,DATA_INTERVENTO,FK_TIPO_INTERVENTO,L11_1_FLG_NORMA_UNI_10389_1,L11_1_ALTRA_NORMA,FLG_BLOCCO_NOMINA_3R,FLG_VISU_PROPRIETARIO,FLG_NO_OPENDATA,COORD_X_LONG_DD,COORD_Y_LAT_DD ) VALUES (  :CODICE_IMPIANTO , :ISTAT_COMUNE , :FK_STATO , :DATA_ASSEGNAZIONE , :DATA_DISMISSIONE , :DENOMINAZIONE_COMUNE , :SIGLA_PROVINCIA , :DENOMINAZIONE_PROVINCIA , :L1_3_POT_H2O_KW , :L1_3_POT_CLIMA_INV_KW , :L1_3_POT_CLIMA_EST_KW , :L1_3_ALTRO , :L1_4_FLG_H2O , :L1_4_FLG_ARIA , :L1_4_ALTRO , :L1_5_FLG_GENERATORE , :L1_5_FLG_POMPA , :L1_5_FLG_FRIGO , :L1_5_FLG_TELERISC , :L1_5_FLG_TELERAFFR , :L1_5_FLG_COGENERATORE , :L1_5_ALTRO , :L1_5_SUP_PANNELLI_SOL_M2 , :L1_5_ALTRO_INTEGRAZIONE , :L1_5_ALTRO_INTEGR_POT_KW , :L1_5_FLG_ALTRO_CLIMA_INV , :L1_5_FLG_ALTRO_CLIMA_ESTATE , :L1_5_FLG_ALTRO_ACS , :L1_5_ALTRO_DESC , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :MOTIVAZIONE , :PROPRIETARIO , :DATA_INSERIMENTO , :NOTE , :FLG_TIPO_IMPIANTO , :FLG_APPARECC_UI_EXT , :FLG_CONTABILIZZAZIONE , :DATA_INTERVENTO , :FK_TIPO_INTERVENTO , :L11_1_FLG_NORMA_UNI_10389_1 , :L11_1_ALTRA_NORMA , :FLG_BLOCCO_NOMINA_3R , :FLG_VISU_PROPRIETARIO , :FLG_NO_OPENDATA , :COORD_X_LONG_DD , :COORD_Y_LAT_DD  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE]
		params.addValue("ISTAT_COMUNE", dto.getIstatComune(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_STATO]
		params.addValue("FK_STATO", dto.getFkStato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ASSEGNAZIONE]
		params.addValue("DATA_ASSEGNAZIONE", dto.getDataAssegnazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_DISMISSIONE]
		params.addValue("DATA_DISMISSIONE", dto.getDataDismissione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DENOMINAZIONE_COMUNE]
		params.addValue("DENOMINAZIONE_COMUNE", dto.getDenominazioneComune(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SIGLA_PROVINCIA]
		params.addValue("SIGLA_PROVINCIA", dto.getSiglaProvincia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DENOMINAZIONE_PROVINCIA]
		params.addValue("DENOMINAZIONE_PROVINCIA", dto.getDenominazioneProvincia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L1_3_POT_H2O_KW]
		params.addValue("L1_3_POT_H2O_KW", dto.getL13PotH2oKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_3_POT_CLIMA_INV_KW]
		params.addValue("L1_3_POT_CLIMA_INV_KW", dto.getL13PotClimaInvKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_3_POT_CLIMA_EST_KW]
		params.addValue("L1_3_POT_CLIMA_EST_KW", dto.getL13PotClimaEstKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_3_ALTRO]
		params.addValue("L1_3_ALTRO", dto.getL13Altro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L1_4_FLG_H2O]
		params.addValue("L1_4_FLG_H2O", dto.getL14FlgH2o(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_4_FLG_ARIA]
		params.addValue("L1_4_FLG_ARIA", dto.getL14FlgAria(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_4_ALTRO]
		params.addValue("L1_4_ALTRO", dto.getL14Altro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_GENERATORE]
		params.addValue("L1_5_FLG_GENERATORE", dto.getL15FlgGeneratore(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_POMPA]
		params.addValue("L1_5_FLG_POMPA", dto.getL15FlgPompa(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_FRIGO]
		params.addValue("L1_5_FLG_FRIGO", dto.getL15FlgFrigo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_TELERISC]
		params.addValue("L1_5_FLG_TELERISC", dto.getL15FlgTelerisc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_TELERAFFR]
		params.addValue("L1_5_FLG_TELERAFFR", dto.getL15FlgTeleraffr(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_COGENERATORE]
		params.addValue("L1_5_FLG_COGENERATORE", dto.getL15FlgCogeneratore(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_ALTRO]
		params.addValue("L1_5_ALTRO", dto.getL15Altro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L1_5_SUP_PANNELLI_SOL_M2]
		params.addValue("L1_5_SUP_PANNELLI_SOL_M2", dto.getL15SupPannelliSolM2(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_ALTRO_INTEGRAZIONE]
		params.addValue("L1_5_ALTRO_INTEGRAZIONE", dto.getL15AltroIntegrazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L1_5_ALTRO_INTEGR_POT_KW]
		params.addValue("L1_5_ALTRO_INTEGR_POT_KW", dto.getL15AltroIntegrPotKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_ALTRO_CLIMA_INV]
		params.addValue("L1_5_FLG_ALTRO_CLIMA_INV", dto.getL15FlgAltroClimaInv(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_ALTRO_CLIMA_ESTATE]
		params.addValue("L1_5_FLG_ALTRO_CLIMA_ESTATE", dto.getL15FlgAltroClimaEstate(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_ALTRO_ACS]
		params.addValue("L1_5_FLG_ALTRO_ACS", dto.getL15FlgAltroAcs(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_ALTRO_DESC]
		params.addValue("L1_5_ALTRO_DESC", dto.getL15AltroDesc(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MOTIVAZIONE]
		params.addValue("MOTIVAZIONE", dto.getMotivazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROPRIETARIO]
		params.addValue("PROPRIETARIO", dto.getProprietario(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_TIPO_IMPIANTO]
		params.addValue("FLG_TIPO_IMPIANTO", dto.getFlgTipoImpianto(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_APPARECC_UI_EXT]
		params.addValue("FLG_APPARECC_UI_EXT", dto.getFlgAppareccUiExt(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_CONTABILIZZAZIONE]
		params.addValue("FLG_CONTABILIZZAZIONE", dto.getFlgContabilizzazione(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INTERVENTO]
		params.addValue("DATA_INTERVENTO", dto.getDataIntervento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_TIPO_INTERVENTO]
		params.addValue("FK_TIPO_INTERVENTO", dto.getFkTipoIntervento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_1_FLG_NORMA_UNI_10389_1]
		params.addValue("L11_1_FLG_NORMA_UNI_10389_1", dto.getL111FlgNormaUni103891(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_1_ALTRA_NORMA]
		params.addValue("L11_1_ALTRA_NORMA", dto.getL111AltraNorma(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_BLOCCO_NOMINA_3R]
		params.addValue("FLG_BLOCCO_NOMINA_3R", dto.getFlgBloccoNomina3r(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_VISU_PROPRIETARIO]
		params.addValue("FLG_VISU_PROPRIETARIO", dto.getFlgVisuProprietario(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_NO_OPENDATA]
		params.addValue("FLG_NO_OPENDATA", dto.getFlgNoOpendata(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [COORD_X_LONG_DD]
		params.addValue("COORD_X_LONG_DD", dto.getCoordXLongDd(), java.sql.Types.DOUBLE);

		// valorizzazione paametro relativo a colonna [COORD_Y_LAT_DD]
		params.addValue("COORD_Y_LAT_DD", dto.getCoordYLatDd(), java.sql.Types.DOUBLE);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTImpiantoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_IMPIANTO table.
	 * @generated
	 */
	public void update(SigitTImpiantoDto dto) throws SigitTImpiantoDaoException {
		LOG.debug("[SigitTImpiantoDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET ISTAT_COMUNE = :ISTAT_COMUNE ,FK_STATO = :FK_STATO ,DATA_ASSEGNAZIONE = :DATA_ASSEGNAZIONE ,DATA_DISMISSIONE = :DATA_DISMISSIONE ,DENOMINAZIONE_COMUNE = :DENOMINAZIONE_COMUNE ,SIGLA_PROVINCIA = :SIGLA_PROVINCIA ,DENOMINAZIONE_PROVINCIA = :DENOMINAZIONE_PROVINCIA ,L1_3_POT_H2O_KW = :L1_3_POT_H2O_KW ,L1_3_POT_CLIMA_INV_KW = :L1_3_POT_CLIMA_INV_KW ,L1_3_POT_CLIMA_EST_KW = :L1_3_POT_CLIMA_EST_KW ,L1_3_ALTRO = :L1_3_ALTRO ,L1_4_FLG_H2O = :L1_4_FLG_H2O ,L1_4_FLG_ARIA = :L1_4_FLG_ARIA ,L1_4_ALTRO = :L1_4_ALTRO ,L1_5_FLG_GENERATORE = :L1_5_FLG_GENERATORE ,L1_5_FLG_POMPA = :L1_5_FLG_POMPA ,L1_5_FLG_FRIGO = :L1_5_FLG_FRIGO ,L1_5_FLG_TELERISC = :L1_5_FLG_TELERISC ,L1_5_FLG_TELERAFFR = :L1_5_FLG_TELERAFFR ,L1_5_FLG_COGENERATORE = :L1_5_FLG_COGENERATORE ,L1_5_ALTRO = :L1_5_ALTRO ,L1_5_SUP_PANNELLI_SOL_M2 = :L1_5_SUP_PANNELLI_SOL_M2 ,L1_5_ALTRO_INTEGRAZIONE = :L1_5_ALTRO_INTEGRAZIONE ,L1_5_ALTRO_INTEGR_POT_KW = :L1_5_ALTRO_INTEGR_POT_KW ,L1_5_FLG_ALTRO_CLIMA_INV = :L1_5_FLG_ALTRO_CLIMA_INV ,L1_5_FLG_ALTRO_CLIMA_ESTATE = :L1_5_FLG_ALTRO_CLIMA_ESTATE ,L1_5_FLG_ALTRO_ACS = :L1_5_FLG_ALTRO_ACS ,L1_5_ALTRO_DESC = :L1_5_ALTRO_DESC ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,MOTIVAZIONE = :MOTIVAZIONE ,PROPRIETARIO = :PROPRIETARIO ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,NOTE = :NOTE ,FLG_TIPO_IMPIANTO = :FLG_TIPO_IMPIANTO ,FLG_APPARECC_UI_EXT = :FLG_APPARECC_UI_EXT ,FLG_CONTABILIZZAZIONE = :FLG_CONTABILIZZAZIONE ,DATA_INTERVENTO = :DATA_INTERVENTO ,FK_TIPO_INTERVENTO = :FK_TIPO_INTERVENTO ,L11_1_FLG_NORMA_UNI_10389_1 = :L11_1_FLG_NORMA_UNI_10389_1 ,L11_1_ALTRA_NORMA = :L11_1_ALTRA_NORMA ,FLG_BLOCCO_NOMINA_3R = :FLG_BLOCCO_NOMINA_3R ,FLG_VISU_PROPRIETARIO = :FLG_VISU_PROPRIETARIO ,FLG_NO_OPENDATA = :FLG_NO_OPENDATA ,COORD_X_LONG_DD = :COORD_X_LONG_DD ,COORD_Y_LAT_DD = :COORD_Y_LAT_DD  WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (dto.getCodiceImpianto() == null) {
			LOG.error("[SigitTImpiantoDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTImpiantoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE]
		params.addValue("ISTAT_COMUNE", dto.getIstatComune(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_STATO]
		params.addValue("FK_STATO", dto.getFkStato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ASSEGNAZIONE]
		params.addValue("DATA_ASSEGNAZIONE", dto.getDataAssegnazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_DISMISSIONE]
		params.addValue("DATA_DISMISSIONE", dto.getDataDismissione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DENOMINAZIONE_COMUNE]
		params.addValue("DENOMINAZIONE_COMUNE", dto.getDenominazioneComune(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SIGLA_PROVINCIA]
		params.addValue("SIGLA_PROVINCIA", dto.getSiglaProvincia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DENOMINAZIONE_PROVINCIA]
		params.addValue("DENOMINAZIONE_PROVINCIA", dto.getDenominazioneProvincia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L1_3_POT_H2O_KW]
		params.addValue("L1_3_POT_H2O_KW", dto.getL13PotH2oKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_3_POT_CLIMA_INV_KW]
		params.addValue("L1_3_POT_CLIMA_INV_KW", dto.getL13PotClimaInvKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_3_POT_CLIMA_EST_KW]
		params.addValue("L1_3_POT_CLIMA_EST_KW", dto.getL13PotClimaEstKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_3_ALTRO]
		params.addValue("L1_3_ALTRO", dto.getL13Altro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L1_4_FLG_H2O]
		params.addValue("L1_4_FLG_H2O", dto.getL14FlgH2o(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_4_FLG_ARIA]
		params.addValue("L1_4_FLG_ARIA", dto.getL14FlgAria(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_4_ALTRO]
		params.addValue("L1_4_ALTRO", dto.getL14Altro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_GENERATORE]
		params.addValue("L1_5_FLG_GENERATORE", dto.getL15FlgGeneratore(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_POMPA]
		params.addValue("L1_5_FLG_POMPA", dto.getL15FlgPompa(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_FRIGO]
		params.addValue("L1_5_FLG_FRIGO", dto.getL15FlgFrigo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_TELERISC]
		params.addValue("L1_5_FLG_TELERISC", dto.getL15FlgTelerisc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_TELERAFFR]
		params.addValue("L1_5_FLG_TELERAFFR", dto.getL15FlgTeleraffr(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_COGENERATORE]
		params.addValue("L1_5_FLG_COGENERATORE", dto.getL15FlgCogeneratore(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_ALTRO]
		params.addValue("L1_5_ALTRO", dto.getL15Altro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L1_5_SUP_PANNELLI_SOL_M2]
		params.addValue("L1_5_SUP_PANNELLI_SOL_M2", dto.getL15SupPannelliSolM2(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_ALTRO_INTEGRAZIONE]
		params.addValue("L1_5_ALTRO_INTEGRAZIONE", dto.getL15AltroIntegrazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [L1_5_ALTRO_INTEGR_POT_KW]
		params.addValue("L1_5_ALTRO_INTEGR_POT_KW", dto.getL15AltroIntegrPotKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_ALTRO_CLIMA_INV]
		params.addValue("L1_5_FLG_ALTRO_CLIMA_INV", dto.getL15FlgAltroClimaInv(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_ALTRO_CLIMA_ESTATE]
		params.addValue("L1_5_FLG_ALTRO_CLIMA_ESTATE", dto.getL15FlgAltroClimaEstate(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_FLG_ALTRO_ACS]
		params.addValue("L1_5_FLG_ALTRO_ACS", dto.getL15FlgAltroAcs(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L1_5_ALTRO_DESC]
		params.addValue("L1_5_ALTRO_DESC", dto.getL15AltroDesc(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MOTIVAZIONE]
		params.addValue("MOTIVAZIONE", dto.getMotivazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROPRIETARIO]
		params.addValue("PROPRIETARIO", dto.getProprietario(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_TIPO_IMPIANTO]
		params.addValue("FLG_TIPO_IMPIANTO", dto.getFlgTipoImpianto(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_APPARECC_UI_EXT]
		params.addValue("FLG_APPARECC_UI_EXT", dto.getFlgAppareccUiExt(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_CONTABILIZZAZIONE]
		params.addValue("FLG_CONTABILIZZAZIONE", dto.getFlgContabilizzazione(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INTERVENTO]
		params.addValue("DATA_INTERVENTO", dto.getDataIntervento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_TIPO_INTERVENTO]
		params.addValue("FK_TIPO_INTERVENTO", dto.getFkTipoIntervento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_1_FLG_NORMA_UNI_10389_1]
		params.addValue("L11_1_FLG_NORMA_UNI_10389_1", dto.getL111FlgNormaUni103891(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [L11_1_ALTRA_NORMA]
		params.addValue("L11_1_ALTRA_NORMA", dto.getL111AltraNorma(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_BLOCCO_NOMINA_3R]
		params.addValue("FLG_BLOCCO_NOMINA_3R", dto.getFlgBloccoNomina3r(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_VISU_PROPRIETARIO]
		params.addValue("FLG_VISU_PROPRIETARIO", dto.getFlgVisuProprietario(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_NO_OPENDATA]
		params.addValue("FLG_NO_OPENDATA", dto.getFlgNoOpendata(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [COORD_X_LONG_DD]
		params.addValue("COORD_X_LONG_DD", dto.getCoordXLongDd(), java.sql.Types.DOUBLE);

		// valorizzazione paametro relativo a colonna [COORD_Y_LAT_DD]
		params.addValue("COORD_Y_LAT_DD", dto.getCoordYLatDd(), java.sql.Types.DOUBLE);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTImpiantoDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_IMPIANTO table.
	 * @generated
	 */
	public void updateColumnsUpdateDatiOnline(SigitTImpiantoDto dto) throws SigitTImpiantoDaoException {
		LOG.debug("[SigitTImpiantoDaoImpl::updateColumnsUpdateDatiOnline] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET ISTAT_COMUNE = :ISTAT_COMUNE ,FK_STATO = :FK_STATO ,DATA_ASSEGNAZIONE = :DATA_ASSEGNAZIONE ,DATA_DISMISSIONE = :DATA_DISMISSIONE ,DENOMINAZIONE_COMUNE = :DENOMINAZIONE_COMUNE ,SIGLA_PROVINCIA = :SIGLA_PROVINCIA ,DENOMINAZIONE_PROVINCIA = :DENOMINAZIONE_PROVINCIA ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,MOTIVAZIONE = :MOTIVAZIONE ,PROPRIETARIO = :PROPRIETARIO ,NOTE = :NOTE ,FLG_TIPO_IMPIANTO = :FLG_TIPO_IMPIANTO ,FLG_APPARECC_UI_EXT = :FLG_APPARECC_UI_EXT ,FLG_CONTABILIZZAZIONE = :FLG_CONTABILIZZAZIONE ,FLG_VISU_PROPRIETARIO = :FLG_VISU_PROPRIETARIO ,COORD_X_LONG_DD = :COORD_X_LONG_DD ,COORD_Y_LAT_DD = :COORD_Y_LAT_DD  WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (dto.getCodiceImpianto() == null) {
			LOG.error("[SigitTImpiantoDaoImpl::updateColumnsUpdateDatiOnline] ERROR chiave primaria non impostata");
			throw new SigitTImpiantoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE]
		params.addValue("ISTAT_COMUNE", dto.getIstatComune(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_STATO]
		params.addValue("FK_STATO", dto.getFkStato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ASSEGNAZIONE]
		params.addValue("DATA_ASSEGNAZIONE", dto.getDataAssegnazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_DISMISSIONE]
		params.addValue("DATA_DISMISSIONE", dto.getDataDismissione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DENOMINAZIONE_COMUNE]
		params.addValue("DENOMINAZIONE_COMUNE", dto.getDenominazioneComune(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SIGLA_PROVINCIA]
		params.addValue("SIGLA_PROVINCIA", dto.getSiglaProvincia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DENOMINAZIONE_PROVINCIA]
		params.addValue("DENOMINAZIONE_PROVINCIA", dto.getDenominazioneProvincia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MOTIVAZIONE]
		params.addValue("MOTIVAZIONE", dto.getMotivazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROPRIETARIO]
		params.addValue("PROPRIETARIO", dto.getProprietario(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_TIPO_IMPIANTO]
		params.addValue("FLG_TIPO_IMPIANTO", dto.getFlgTipoImpianto(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_APPARECC_UI_EXT]
		params.addValue("FLG_APPARECC_UI_EXT", dto.getFlgAppareccUiExt(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_CONTABILIZZAZIONE]
		params.addValue("FLG_CONTABILIZZAZIONE", dto.getFlgContabilizzazione(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_VISU_PROPRIETARIO]
		params.addValue("FLG_VISU_PROPRIETARIO", dto.getFlgVisuProprietario(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [COORD_X_LONG_DD]
		params.addValue("COORD_X_LONG_DD", dto.getCoordXLongDd(), java.sql.Types.DOUBLE);

		// valorizzazione paametro relativo a colonna [COORD_Y_LAT_DD]
		params.addValue("COORD_Y_LAT_DD", dto.getCoordYLatDd(), java.sql.Types.DOUBLE);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTImpiantoDaoImpl::updateColumnsUpdateDatiOnline] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_IMPIANTO table.
	 * @generated
	 */
	public void updateColumnsUpdateBloccoNomina3R(SigitTImpiantoDto dto) throws SigitTImpiantoDaoException {
		LOG.debug("[SigitTImpiantoDaoImpl::updateColumnsUpdateBloccoNomina3R] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FLG_BLOCCO_NOMINA_3R = :FLG_BLOCCO_NOMINA_3R ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD  WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (dto.getCodiceImpianto() == null) {
			LOG.error("[SigitTImpiantoDaoImpl::updateColumnsUpdateBloccoNomina3R] ERROR chiave primaria non impostata");
			throw new SigitTImpiantoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FLG_BLOCCO_NOMINA_3R]
		params.addValue("FLG_BLOCCO_NOMINA_3R", dto.getFlgBloccoNomina3r(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTImpiantoDaoImpl::updateColumnsUpdateBloccoNomina3R] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_IMPIANTO table.
	 * @generated
	 */

	public void delete(SigitTImpiantoPk pk) throws SigitTImpiantoDaoException {
		LOG.debug("[SigitTImpiantoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ";

		if (pk == null) {
			LOG.error("[SigitTImpiantoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTImpiantoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTImpiantoDaoImpl::delete] END");
	}

	protected SigitTImpiantoDaoRowMapper findByPrimaryKeyRowMapper = new SigitTImpiantoDaoRowMapper(null,
			SigitTImpiantoDto.class, this);

	protected SigitTImpiantoDaoRowMapper findAllRowMapper = new SigitTImpiantoDaoRowMapper(null,
			SigitTImpiantoDto.class, this);

	protected SigitTImpiantoDaoRowMapper byFilterRowMapper = new SigitTImpiantoDaoRowMapper(null,
			SigitTImpiantoDto.class, this);

	protected SigitTImpiantoDaoRowMapper aggiornamentoCoordinateRowMapper = new SigitTImpiantoDaoRowMapper(null,
			SigitTImpiantoAggiornamentoCoordinateDto.class, this);

	protected SigitTImpiantoDaoRowMapper byAccertamentoIstatComuneRowMapper = new SigitTImpiantoDaoRowMapper(
			new String[]{"DENOMINAZIONE_COMUNE"}, SigitTImpiantoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_IMPIANTO";
	}

	/** 
	 * Returns all rows from the SIGIT_T_IMPIANTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTImpiantoDto findByPrimaryKey(SigitTImpiantoPk pk) throws SigitTImpiantoDaoException {
		LOG.debug("[SigitTImpiantoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT CODICE_IMPIANTO,ISTAT_COMUNE,FK_STATO,DATA_ASSEGNAZIONE,DATA_DISMISSIONE,DENOMINAZIONE_COMUNE,SIGLA_PROVINCIA,DENOMINAZIONE_PROVINCIA,L1_3_POT_H2O_KW,L1_3_POT_CLIMA_INV_KW,L1_3_POT_CLIMA_EST_KW,L1_3_ALTRO,L1_4_FLG_H2O,L1_4_FLG_ARIA,L1_4_ALTRO,L1_5_FLG_GENERATORE,L1_5_FLG_POMPA,L1_5_FLG_FRIGO,L1_5_FLG_TELERISC,L1_5_FLG_TELERAFFR,L1_5_FLG_COGENERATORE,L1_5_ALTRO,L1_5_SUP_PANNELLI_SOL_M2,L1_5_ALTRO_INTEGRAZIONE,L1_5_ALTRO_INTEGR_POT_KW,L1_5_FLG_ALTRO_CLIMA_INV,L1_5_FLG_ALTRO_CLIMA_ESTATE,L1_5_FLG_ALTRO_ACS,L1_5_ALTRO_DESC,DATA_ULT_MOD,UTENTE_ULT_MOD,MOTIVAZIONE,PROPRIETARIO,DATA_INSERIMENTO,NOTE,FLG_TIPO_IMPIANTO,FLG_APPARECC_UI_EXT,FLG_CONTABILIZZAZIONE,DATA_INTERVENTO,FK_TIPO_INTERVENTO,L11_1_FLG_NORMA_UNI_10389_1,L11_1_ALTRA_NORMA,FLG_BLOCCO_NOMINA_3R,FLG_VISU_PROPRIETARIO,FLG_NO_OPENDATA,COORD_X_LONG_DD,COORD_Y_LAT_DD FROM "
						+ getTableName() + " WHERE CODICE_IMPIANTO = :CODICE_IMPIANTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", pk.getCodiceImpianto(), java.sql.Types.NUMERIC);

		List<SigitTImpiantoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTImpiantoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTImpiantoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImpiantoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTImpiantoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_IMPIANTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTImpiantoDto> findAll() throws SigitTImpiantoDaoException {
		LOG.debug("[SigitTImpiantoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT CODICE_IMPIANTO,ISTAT_COMUNE,FK_STATO,DATA_ASSEGNAZIONE,DATA_DISMISSIONE,DENOMINAZIONE_COMUNE,SIGLA_PROVINCIA,DENOMINAZIONE_PROVINCIA,L1_3_POT_H2O_KW,L1_3_POT_CLIMA_INV_KW,L1_3_POT_CLIMA_EST_KW,L1_3_ALTRO,L1_4_FLG_H2O,L1_4_FLG_ARIA,L1_4_ALTRO,L1_5_FLG_GENERATORE,L1_5_FLG_POMPA,L1_5_FLG_FRIGO,L1_5_FLG_TELERISC,L1_5_FLG_TELERAFFR,L1_5_FLG_COGENERATORE,L1_5_ALTRO,L1_5_SUP_PANNELLI_SOL_M2,L1_5_ALTRO_INTEGRAZIONE,L1_5_ALTRO_INTEGR_POT_KW,L1_5_FLG_ALTRO_CLIMA_INV,L1_5_FLG_ALTRO_CLIMA_ESTATE,L1_5_FLG_ALTRO_ACS,L1_5_ALTRO_DESC,DATA_ULT_MOD,UTENTE_ULT_MOD,MOTIVAZIONE,PROPRIETARIO,DATA_INSERIMENTO,NOTE,FLG_TIPO_IMPIANTO,FLG_APPARECC_UI_EXT,FLG_CONTABILIZZAZIONE,DATA_INTERVENTO,FK_TIPO_INTERVENTO,L11_1_FLG_NORMA_UNI_10389_1,L11_1_ALTRA_NORMA,FLG_BLOCCO_NOMINA_3R,FLG_VISU_PROPRIETARIO,FLG_NO_OPENDATA,COORD_X_LONG_DD,COORD_Y_LAT_DD FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTImpiantoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTImpiantoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitTImpiantoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImpiantoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitTImpiantoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTImpiantoDto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImpiantoFilter input)
			throws SigitTImpiantoDaoException {
		LOG.debug("[SigitTImpiantoDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT CODICE_IMPIANTO,ISTAT_COMUNE,FK_STATO,DATA_ASSEGNAZIONE,DATA_DISMISSIONE,DENOMINAZIONE_COMUNE,SIGLA_PROVINCIA,DENOMINAZIONE_PROVINCIA,L1_3_POT_H2O_KW,L1_3_POT_CLIMA_INV_KW,L1_3_POT_CLIMA_EST_KW,L1_3_ALTRO,L1_4_FLG_H2O,L1_4_FLG_ARIA,L1_4_ALTRO,L1_5_FLG_GENERATORE,L1_5_FLG_POMPA,L1_5_FLG_FRIGO,L1_5_FLG_TELERISC,L1_5_FLG_TELERAFFR,L1_5_FLG_COGENERATORE,L1_5_ALTRO,L1_5_SUP_PANNELLI_SOL_M2,L1_5_ALTRO_INTEGRAZIONE,L1_5_ALTRO_INTEGR_POT_KW,L1_5_FLG_ALTRO_CLIMA_INV,L1_5_FLG_ALTRO_CLIMA_ESTATE,L1_5_FLG_ALTRO_ACS,L1_5_ALTRO_DESC,DATA_ULT_MOD,UTENTE_ULT_MOD,MOTIVAZIONE,PROPRIETARIO,DATA_INSERIMENTO,NOTE,FLG_TIPO_IMPIANTO,FLG_APPARECC_UI_EXT,FLG_CONTABILIZZAZIONE,DATA_INTERVENTO,FK_TIPO_INTERVENTO,L11_1_FLG_NORMA_UNI_10389_1,L11_1_ALTRA_NORMA,FLG_BLOCCO_NOMINA_3R,FLG_VISU_PROPRIETARIO,FLG_NO_OPENDATA,COORD_X_LONG_DD,COORD_Y_LAT_DD ");
		sql.append(" FROM SIGIT_T_IMPIANTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-607277216) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		ArrayList<String> listaCodiciImpianto = input.getListaCodiciImpianto();
		String codiciImpianto = "";
		if (listaCodiciImpianto != null && listaCodiciImpianto.size() > 0) {
			for (String str : listaCodiciImpianto) {
				codiciImpianto += str + ",";
			}

			codiciImpianto = codiciImpianto.substring(0, (codiciImpianto.length() - 1));
		}

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" 1=1 ");

		if (input.getFlagVisuProprietario() != null) {
			sql.append(" AND FLG_VISU_PROPRIETARIO = :flg_visu_proprietario");

		}

		if (GenericUtil.isNotNullOrEmpty(codiciImpianto)) {
			sql.append(" AND CODICE_IMPIANTO IN (" + codiciImpianto + ") ");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-765160734) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input.getFlagVisuProprietario() != null) {
			paramMap.addValue("flg_visu_proprietario", input.getFlagVisuProprietario());
		}

		/*PROTECTED REGION END*/
		List<SigitTImpiantoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTImpiantoDaoImpl::findByFilter] esecuzione query", ex);
			throw new SigitTImpiantoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImpiantoDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitTImpiantoDaoImpl::findByFilter] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder aggiornamentoCoordinate con Qdef
		 * @generated
		 */

	public List<SigitTImpiantoAggiornamentoCoordinateDto> findAggiornamentoCoordinate(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImpiantoAggiornamentoCoordinateFilter input)
			throws SigitTImpiantoDaoException {
		LOG.debug("[SigitTImpiantoDaoImpl::findAggiornamentoCoordinate] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT impianti.CODICE_IMPIANTO, impianti.ISTAT_COMUNE, impianti.DENOMINAZIONE_COMUNE, impianti.DENOMINAZIONE_PROVINCIA, impianti.SIGLA_PROVINCIA, immobili.INDIRIZZO_SITAD, immobili.INDIRIZZO_NON_TROVATO, immobili.CIVICO");

		sql.append(" FROM SIGIT_T_IMPIANTO impianti, SIGIT_T_UNITA_IMMOBILIARE immobili");

		sql.append(" WHERE ");

		sql.append("impianti.CODICE_IMPIANTO = immobili.CODICE_IMPIANTO");

		sql.append(" AND ");

		sql.append("immobili.FLG_PRINCIPALE = TRUE");
		/*PROTECTED REGION ID(R-963495648) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		if (ConvertUtil.convertToBooleanAllways(input.getSenzaCoordinateFlag())) {
			sql.append(" AND (impianti.COORD_X_LONG_DD IS NULL OR impianti.COORD_Y_LAT_DD IS NULL)");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getAggiornatiAData())) {
			sql.append(" AND impianti.DATA_ULT_MOD < :data_ult_mod::date ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getAggiornatiAData())) {
			paramMap.addValue("data_ult_mod", input.getAggiornatiAData());
		}

		sql.append(" LIMIT (SELECT VALORE_CONFIG_NUM FROM SIGIT_WRK_CONFIG WHERE CHIAVE_CONFIG='"
				+ Constants.CHIAVE_CONFIG_N_RECORD_AGGIORNA_COORD + "') ");

		/*PROTECTED REGION END*/

		List<SigitTImpiantoAggiornamentoCoordinateDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, aggiornamentoCoordinateRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTImpiantoDaoImpl::findAggiornamentoCoordinate] ERROR esecuzione query", ex);
			throw new SigitTImpiantoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImpiantoDaoImpl", "findAggiornamentoCoordinate", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTImpiantoDaoImpl::findAggiornamentoCoordinate] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byAccertamentoIstatComune
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTImpiantoDto> findByAccertamentoIstatComune(java.lang.String input)
			throws SigitTImpiantoDaoException {
		LOG.debug("[SigitTImpiantoDaoImpl::findByAccertamentoIstatComune] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT DISTINCT DENOMINAZIONE_COMUNE ");
		/*PROTECTED REGION ID(R307839956) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_IMPIANTO");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R735739814) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		sql.append("sigit_t_impianto.istat_comune = :istat");
		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-2081305764) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("istat", input);

		/*PROTECTED REGION END*/
		List<SigitTImpiantoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAccertamentoIstatComuneRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTImpiantoDaoImpl::findByAccertamentoIstatComune] esecuzione query", ex);
			throw new SigitTImpiantoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTImpiantoDaoImpl", "findByAccertamentoIstatComune", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTImpiantoDaoImpl::findByAccertamentoIstatComune] END");
		}
		return list;
	}

}
