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

/*PROTECTED REGION ID(R1661132719) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTRappIspezGf.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - deleteByIdAllegato (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTRappIspezGfDaoImpl extends AbstractDAO implements SigitTRappIspezGfDao {
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
	 * Metodo di inserimento del DAO sigitTRappIspezGf. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTRappIspezGfPk
	 * @generated
	 */

	public SigitTRappIspezGfPk insert(SigitTRappIspezGfDto dto)

	{
		LOG.debug("[SigitTRappIspezGfDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ALLEGATO,S1C_FLG_REE_INVIATO,S1C_FLG_REE_BOLLINO,S1C_SIGLA_BOLLINO,S1C_NUM_BOLLINO,S1E_DT_PRIMA_INSTALLAZIONE,S1E_POT_TERMICA_MAX_KW,S1L_DENOM_DELEGATO,S1L_FLG_DELEGA,S2E_FLG_TRATT_H2O_NON_RICH,S3A_FLG_LOCALE_INT_IDONEO,S3B_FLG_LINEE_ELETTR_IDONEE,S3C_FLG_VENTILAZ_ADEGUATE,S3D_FLG_COIBENTAZIONI_IDONEE,S4A_FLG_LIB_IMP_PRESENTE,S4B_FLG_LIB_COMPILATO,S4C_FLG_CONFORMITA_PRESENTE,S4D_FLG_LIB_USO_PRESENTE,S5A_FLG_SOSTITUZ_MACCHINE_REG,S5A_FLG_SOSTITUZ_SISTEMI_REG,S5A_FLG_ISOLAM_RETE_DISTRIB,S5A_FLG_ISOLAM_CANALI_DISTRIB,S5B_FLG_NO_INTERV_CONV,S5B_FLG_RELAZ_DETTAGLIO,S5B_FLG_RELAZ_DETTAGLIO_SUCC,S5B_FLG_VALUTAZ_NON_ESEGUITA,S5B_MOTIVO_RELAZ_NON_ESEG,S5C_FLG_DIMENS_CORRETTO,S5C_FLG_DIMENS_NON_CONTROLL,S5C_FLG_DIMENS_RELAZ_SUCCES,DATA_ULT_MOD,UTENTE_ULT_MOD,S1C_DATA_REE,S5C_FLG_DIMENS_NON_CORRETTO ) VALUES (  :ID_ALLEGATO , :S1C_FLG_REE_INVIATO , :S1C_FLG_REE_BOLLINO , :S1C_SIGLA_BOLLINO , :S1C_NUM_BOLLINO , :S1E_DT_PRIMA_INSTALLAZIONE , :S1E_POT_TERMICA_MAX_KW , :S1L_DENOM_DELEGATO , :S1L_FLG_DELEGA , :S2E_FLG_TRATT_H2O_NON_RICH , :S3A_FLG_LOCALE_INT_IDONEO , :S3B_FLG_LINEE_ELETTR_IDONEE , :S3C_FLG_VENTILAZ_ADEGUATE , :S3D_FLG_COIBENTAZIONI_IDONEE , :S4A_FLG_LIB_IMP_PRESENTE , :S4B_FLG_LIB_COMPILATO , :S4C_FLG_CONFORMITA_PRESENTE , :S4D_FLG_LIB_USO_PRESENTE , :S5A_FLG_SOSTITUZ_MACCHINE_REG , :S5A_FLG_SOSTITUZ_SISTEMI_REG , :S5A_FLG_ISOLAM_RETE_DISTRIB , :S5A_FLG_ISOLAM_CANALI_DISTRIB , :S5B_FLG_NO_INTERV_CONV , :S5B_FLG_RELAZ_DETTAGLIO , :S5B_FLG_RELAZ_DETTAGLIO_SUCC , :S5B_FLG_VALUTAZ_NON_ESEGUITA , :S5B_MOTIVO_RELAZ_NON_ESEG , :S5C_FLG_DIMENS_CORRETTO , :S5C_FLG_DIMENS_NON_CONTROLL , :S5C_FLG_DIMENS_RELAZ_SUCCES , :DATA_ULT_MOD , :UTENTE_ULT_MOD , :S1C_DATA_REE , :S5C_FLG_DIMENS_NON_CORRETTO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1C_FLG_REE_INVIATO]
		params.addValue("S1C_FLG_REE_INVIATO", dto.getS1cFlgReeInviato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1C_FLG_REE_BOLLINO]
		params.addValue("S1C_FLG_REE_BOLLINO", dto.getS1cFlgReeBollino(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1C_SIGLA_BOLLINO]
		params.addValue("S1C_SIGLA_BOLLINO", dto.getS1cSiglaBollino(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S1C_NUM_BOLLINO]
		params.addValue("S1C_NUM_BOLLINO", dto.getS1cNumBollino(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1E_DT_PRIMA_INSTALLAZIONE]
		params.addValue("S1E_DT_PRIMA_INSTALLAZIONE", dto.getS1eDtPrimaInstallazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [S1E_POT_TERMICA_MAX_KW]
		params.addValue("S1E_POT_TERMICA_MAX_KW", dto.getS1ePotTermicaMaxKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1L_DENOM_DELEGATO]
		params.addValue("S1L_DENOM_DELEGATO", dto.getS1lDenomDelegato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S1L_FLG_DELEGA]
		params.addValue("S1L_FLG_DELEGA", dto.getS1lFlgDelega(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S2E_FLG_TRATT_H2O_NON_RICH]
		params.addValue("S2E_FLG_TRATT_H2O_NON_RICH", dto.getS2eFlgTrattH2oNonRich(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3A_FLG_LOCALE_INT_IDONEO]
		params.addValue("S3A_FLG_LOCALE_INT_IDONEO", dto.getS3aFlgLocaleIntIdoneo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3B_FLG_LINEE_ELETTR_IDONEE]
		params.addValue("S3B_FLG_LINEE_ELETTR_IDONEE", dto.getS3bFlgLineeElettrIdonee(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3C_FLG_VENTILAZ_ADEGUATE]
		params.addValue("S3C_FLG_VENTILAZ_ADEGUATE", dto.getS3cFlgVentilazAdeguate(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3D_FLG_COIBENTAZIONI_IDONEE]
		params.addValue("S3D_FLG_COIBENTAZIONI_IDONEE", dto.getS3dFlgCoibentazioniIdonee(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S4A_FLG_LIB_IMP_PRESENTE]
		params.addValue("S4A_FLG_LIB_IMP_PRESENTE", dto.getS4aFlgLibImpPresente(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S4B_FLG_LIB_COMPILATO]
		params.addValue("S4B_FLG_LIB_COMPILATO", dto.getS4bFlgLibCompilato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S4C_FLG_CONFORMITA_PRESENTE]
		params.addValue("S4C_FLG_CONFORMITA_PRESENTE", dto.getS4cFlgConformitaPresente(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S4D_FLG_LIB_USO_PRESENTE]
		params.addValue("S4D_FLG_LIB_USO_PRESENTE", dto.getS4dFlgLibUsoPresente(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5A_FLG_SOSTITUZ_MACCHINE_REG]
		params.addValue("S5A_FLG_SOSTITUZ_MACCHINE_REG", dto.getS5aFlgSostituzMacchineReg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5A_FLG_SOSTITUZ_SISTEMI_REG]
		params.addValue("S5A_FLG_SOSTITUZ_SISTEMI_REG", dto.getS5aFlgSostituzSistemiReg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5A_FLG_ISOLAM_RETE_DISTRIB]
		params.addValue("S5A_FLG_ISOLAM_RETE_DISTRIB", dto.getS5aFlgIsolamReteDistrib(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5A_FLG_ISOLAM_CANALI_DISTRIB]
		params.addValue("S5A_FLG_ISOLAM_CANALI_DISTRIB", dto.getS5aFlgIsolamCanaliDistrib(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5B_FLG_NO_INTERV_CONV]
		params.addValue("S5B_FLG_NO_INTERV_CONV", dto.getS5bFlgNoIntervConv(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5B_FLG_RELAZ_DETTAGLIO]
		params.addValue("S5B_FLG_RELAZ_DETTAGLIO", dto.getS5bFlgRelazDettaglio(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5B_FLG_RELAZ_DETTAGLIO_SUCC]
		params.addValue("S5B_FLG_RELAZ_DETTAGLIO_SUCC", dto.getS5bFlgRelazDettaglioSucc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5B_FLG_VALUTAZ_NON_ESEGUITA]
		params.addValue("S5B_FLG_VALUTAZ_NON_ESEGUITA", dto.getS5bFlgValutazNonEseguita(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5B_MOTIVO_RELAZ_NON_ESEG]
		params.addValue("S5B_MOTIVO_RELAZ_NON_ESEG", dto.getS5bMotivoRelazNonEseg(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S5C_FLG_DIMENS_CORRETTO]
		params.addValue("S5C_FLG_DIMENS_CORRETTO", dto.getS5cFlgDimensCorretto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5C_FLG_DIMENS_NON_CONTROLL]
		params.addValue("S5C_FLG_DIMENS_NON_CONTROLL", dto.getS5cFlgDimensNonControll(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5C_FLG_DIMENS_RELAZ_SUCCES]
		params.addValue("S5C_FLG_DIMENS_RELAZ_SUCCES", dto.getS5cFlgDimensRelazSucces(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S1C_DATA_REE]
		params.addValue("S1C_DATA_REE", dto.getS1cDataRee(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [S5C_FLG_DIMENS_NON_CORRETTO]
		params.addValue("S5C_FLG_DIMENS_NON_CORRETTO", dto.getS5cFlgDimensNonCorretto(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTRappIspezGfDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_RAPP_ISPEZ_GF table.
	 * @generated
	 */
	public void update(SigitTRappIspezGfDto dto) throws SigitTRappIspezGfDaoException {
		LOG.debug("[SigitTRappIspezGfDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET S1C_FLG_REE_INVIATO = :S1C_FLG_REE_INVIATO ,S1C_FLG_REE_BOLLINO = :S1C_FLG_REE_BOLLINO ,S1C_SIGLA_BOLLINO = :S1C_SIGLA_BOLLINO ,S1C_NUM_BOLLINO = :S1C_NUM_BOLLINO ,S1E_DT_PRIMA_INSTALLAZIONE = :S1E_DT_PRIMA_INSTALLAZIONE ,S1E_POT_TERMICA_MAX_KW = :S1E_POT_TERMICA_MAX_KW ,S1L_DENOM_DELEGATO = :S1L_DENOM_DELEGATO ,S1L_FLG_DELEGA = :S1L_FLG_DELEGA ,S2E_FLG_TRATT_H2O_NON_RICH = :S2E_FLG_TRATT_H2O_NON_RICH ,S3A_FLG_LOCALE_INT_IDONEO = :S3A_FLG_LOCALE_INT_IDONEO ,S3B_FLG_LINEE_ELETTR_IDONEE = :S3B_FLG_LINEE_ELETTR_IDONEE ,S3C_FLG_VENTILAZ_ADEGUATE = :S3C_FLG_VENTILAZ_ADEGUATE ,S3D_FLG_COIBENTAZIONI_IDONEE = :S3D_FLG_COIBENTAZIONI_IDONEE ,S4A_FLG_LIB_IMP_PRESENTE = :S4A_FLG_LIB_IMP_PRESENTE ,S4B_FLG_LIB_COMPILATO = :S4B_FLG_LIB_COMPILATO ,S4C_FLG_CONFORMITA_PRESENTE = :S4C_FLG_CONFORMITA_PRESENTE ,S4D_FLG_LIB_USO_PRESENTE = :S4D_FLG_LIB_USO_PRESENTE ,S5A_FLG_SOSTITUZ_MACCHINE_REG = :S5A_FLG_SOSTITUZ_MACCHINE_REG ,S5A_FLG_SOSTITUZ_SISTEMI_REG = :S5A_FLG_SOSTITUZ_SISTEMI_REG ,S5A_FLG_ISOLAM_RETE_DISTRIB = :S5A_FLG_ISOLAM_RETE_DISTRIB ,S5A_FLG_ISOLAM_CANALI_DISTRIB = :S5A_FLG_ISOLAM_CANALI_DISTRIB ,S5B_FLG_NO_INTERV_CONV = :S5B_FLG_NO_INTERV_CONV ,S5B_FLG_RELAZ_DETTAGLIO = :S5B_FLG_RELAZ_DETTAGLIO ,S5B_FLG_RELAZ_DETTAGLIO_SUCC = :S5B_FLG_RELAZ_DETTAGLIO_SUCC ,S5B_FLG_VALUTAZ_NON_ESEGUITA = :S5B_FLG_VALUTAZ_NON_ESEGUITA ,S5B_MOTIVO_RELAZ_NON_ESEG = :S5B_MOTIVO_RELAZ_NON_ESEG ,S5C_FLG_DIMENS_CORRETTO = :S5C_FLG_DIMENS_CORRETTO ,S5C_FLG_DIMENS_NON_CONTROLL = :S5C_FLG_DIMENS_NON_CONTROLL ,S5C_FLG_DIMENS_RELAZ_SUCCES = :S5C_FLG_DIMENS_RELAZ_SUCCES ,DATA_ULT_MOD = :DATA_ULT_MOD ,UTENTE_ULT_MOD = :UTENTE_ULT_MOD ,S1C_DATA_REE = :S1C_DATA_REE ,S5C_FLG_DIMENS_NON_CORRETTO = :S5C_FLG_DIMENS_NON_CORRETTO  WHERE ID_ALLEGATO = :ID_ALLEGATO ";

		if (dto.getIdAllegato() == null) {
			LOG.error("[SigitTRappIspezGfDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTRappIspezGfDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1C_FLG_REE_INVIATO]
		params.addValue("S1C_FLG_REE_INVIATO", dto.getS1cFlgReeInviato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1C_FLG_REE_BOLLINO]
		params.addValue("S1C_FLG_REE_BOLLINO", dto.getS1cFlgReeBollino(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1C_SIGLA_BOLLINO]
		params.addValue("S1C_SIGLA_BOLLINO", dto.getS1cSiglaBollino(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S1C_NUM_BOLLINO]
		params.addValue("S1C_NUM_BOLLINO", dto.getS1cNumBollino(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1E_DT_PRIMA_INSTALLAZIONE]
		params.addValue("S1E_DT_PRIMA_INSTALLAZIONE", dto.getS1eDtPrimaInstallazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [S1E_POT_TERMICA_MAX_KW]
		params.addValue("S1E_POT_TERMICA_MAX_KW", dto.getS1ePotTermicaMaxKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S1L_DENOM_DELEGATO]
		params.addValue("S1L_DENOM_DELEGATO", dto.getS1lDenomDelegato(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S1L_FLG_DELEGA]
		params.addValue("S1L_FLG_DELEGA", dto.getS1lFlgDelega(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S2E_FLG_TRATT_H2O_NON_RICH]
		params.addValue("S2E_FLG_TRATT_H2O_NON_RICH", dto.getS2eFlgTrattH2oNonRich(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3A_FLG_LOCALE_INT_IDONEO]
		params.addValue("S3A_FLG_LOCALE_INT_IDONEO", dto.getS3aFlgLocaleIntIdoneo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3B_FLG_LINEE_ELETTR_IDONEE]
		params.addValue("S3B_FLG_LINEE_ELETTR_IDONEE", dto.getS3bFlgLineeElettrIdonee(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3C_FLG_VENTILAZ_ADEGUATE]
		params.addValue("S3C_FLG_VENTILAZ_ADEGUATE", dto.getS3cFlgVentilazAdeguate(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S3D_FLG_COIBENTAZIONI_IDONEE]
		params.addValue("S3D_FLG_COIBENTAZIONI_IDONEE", dto.getS3dFlgCoibentazioniIdonee(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S4A_FLG_LIB_IMP_PRESENTE]
		params.addValue("S4A_FLG_LIB_IMP_PRESENTE", dto.getS4aFlgLibImpPresente(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S4B_FLG_LIB_COMPILATO]
		params.addValue("S4B_FLG_LIB_COMPILATO", dto.getS4bFlgLibCompilato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S4C_FLG_CONFORMITA_PRESENTE]
		params.addValue("S4C_FLG_CONFORMITA_PRESENTE", dto.getS4cFlgConformitaPresente(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S4D_FLG_LIB_USO_PRESENTE]
		params.addValue("S4D_FLG_LIB_USO_PRESENTE", dto.getS4dFlgLibUsoPresente(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5A_FLG_SOSTITUZ_MACCHINE_REG]
		params.addValue("S5A_FLG_SOSTITUZ_MACCHINE_REG", dto.getS5aFlgSostituzMacchineReg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5A_FLG_SOSTITUZ_SISTEMI_REG]
		params.addValue("S5A_FLG_SOSTITUZ_SISTEMI_REG", dto.getS5aFlgSostituzSistemiReg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5A_FLG_ISOLAM_RETE_DISTRIB]
		params.addValue("S5A_FLG_ISOLAM_RETE_DISTRIB", dto.getS5aFlgIsolamReteDistrib(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5A_FLG_ISOLAM_CANALI_DISTRIB]
		params.addValue("S5A_FLG_ISOLAM_CANALI_DISTRIB", dto.getS5aFlgIsolamCanaliDistrib(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5B_FLG_NO_INTERV_CONV]
		params.addValue("S5B_FLG_NO_INTERV_CONV", dto.getS5bFlgNoIntervConv(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5B_FLG_RELAZ_DETTAGLIO]
		params.addValue("S5B_FLG_RELAZ_DETTAGLIO", dto.getS5bFlgRelazDettaglio(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5B_FLG_RELAZ_DETTAGLIO_SUCC]
		params.addValue("S5B_FLG_RELAZ_DETTAGLIO_SUCC", dto.getS5bFlgRelazDettaglioSucc(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5B_FLG_VALUTAZ_NON_ESEGUITA]
		params.addValue("S5B_FLG_VALUTAZ_NON_ESEGUITA", dto.getS5bFlgValutazNonEseguita(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5B_MOTIVO_RELAZ_NON_ESEG]
		params.addValue("S5B_MOTIVO_RELAZ_NON_ESEG", dto.getS5bMotivoRelazNonEseg(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S5C_FLG_DIMENS_CORRETTO]
		params.addValue("S5C_FLG_DIMENS_CORRETTO", dto.getS5cFlgDimensCorretto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5C_FLG_DIMENS_NON_CONTROLL]
		params.addValue("S5C_FLG_DIMENS_NON_CONTROLL", dto.getS5cFlgDimensNonControll(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [S5C_FLG_DIMENS_RELAZ_SUCCES]
		params.addValue("S5C_FLG_DIMENS_RELAZ_SUCCES", dto.getS5cFlgDimensRelazSucces(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [S1C_DATA_REE]
		params.addValue("S1C_DATA_REE", dto.getS1cDataRee(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [S5C_FLG_DIMENS_NON_CORRETTO]
		params.addValue("S5C_FLG_DIMENS_NON_CORRETTO", dto.getS5cFlgDimensNonCorretto(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTRappIspezGfDaoImpl::update] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_RAPP_ISPEZ_GF table.
	 * @generated
	 */
	public void customDeleterDeleteByIdAllegato(java.lang.Integer filter) throws SigitTRappIspezGfDaoException {
		LOG.debug("[SigitTRappIspezGfDaoImpl::customDeleterDeleteByIdAllegato] START");
		/*PROTECTED REGION ID(R-1726182981) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ALLEGATO = :idAllegato";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idAllegato", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTRappIspezGfDaoImpl::customDeleterDeleteByIdAllegato] END");
	}

	protected SigitTRappIspezGfDaoRowMapper findByPrimaryKeyRowMapper = new SigitTRappIspezGfDaoRowMapper(null,
			SigitTRappIspezGfDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_RAPP_ISPEZ_GF";
	}

	/** 
	 * Returns all rows from the SIGIT_T_RAPP_ISPEZ_GF table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTRappIspezGfDto findByPrimaryKey(SigitTRappIspezGfPk pk) throws SigitTRappIspezGfDaoException {
		LOG.debug("[SigitTRappIspezGfDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALLEGATO,S1C_FLG_REE_INVIATO,S1C_FLG_REE_BOLLINO,S1C_SIGLA_BOLLINO,S1C_NUM_BOLLINO,S1E_DT_PRIMA_INSTALLAZIONE,S1E_POT_TERMICA_MAX_KW,S1L_DENOM_DELEGATO,S1L_FLG_DELEGA,S2E_FLG_TRATT_H2O_NON_RICH,S3A_FLG_LOCALE_INT_IDONEO,S3B_FLG_LINEE_ELETTR_IDONEE,S3C_FLG_VENTILAZ_ADEGUATE,S3D_FLG_COIBENTAZIONI_IDONEE,S4A_FLG_LIB_IMP_PRESENTE,S4B_FLG_LIB_COMPILATO,S4C_FLG_CONFORMITA_PRESENTE,S4D_FLG_LIB_USO_PRESENTE,S5A_FLG_SOSTITUZ_MACCHINE_REG,S5A_FLG_SOSTITUZ_SISTEMI_REG,S5A_FLG_ISOLAM_RETE_DISTRIB,S5A_FLG_ISOLAM_CANALI_DISTRIB,S5B_FLG_NO_INTERV_CONV,S5B_FLG_RELAZ_DETTAGLIO,S5B_FLG_RELAZ_DETTAGLIO_SUCC,S5B_FLG_VALUTAZ_NON_ESEGUITA,S5B_MOTIVO_RELAZ_NON_ESEG,S5C_FLG_DIMENS_CORRETTO,S5C_FLG_DIMENS_NON_CONTROLL,S5C_FLG_DIMENS_RELAZ_SUCCES,DATA_ULT_MOD,UTENTE_ULT_MOD,S1C_DATA_REE,S5C_FLG_DIMENS_NON_CORRETTO FROM "
						+ getTableName() + " WHERE ID_ALLEGATO = :ID_ALLEGATO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.NUMERIC);

		List<SigitTRappIspezGfDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTRappIspezGfDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTRappIspezGfDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTRappIspezGfDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTRappIspezGfDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
