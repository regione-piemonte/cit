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

/*PROTECTED REGION ID(R-1953276785) ENABLED START*/
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.enumutil.UnitaMisuraNox;
import it.csi.sigit.sigitwebn.util.Constants;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVRicercaImpianti.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byImpiantoFilter (datagen::CustomFinder)
 *   - ImpiantiDaRicercaAvanzata (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitVRicercaImpiantiDaoImpl extends AbstractDAO implements SigitVRicercaImpiantiDao {
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

	protected SigitVRicercaImpiantiDaoRowMapper byImpiantoFilterRowMapper = new SigitVRicercaImpiantiDaoRowMapper(
			new String[]{"CODICE_IMPIANTO", "ISTAT_COMUNE", "DENOMINAZIONE_COMUNE", "SIGLA_PROVINCIA",
					"DENOMINAZIONE_PROVINCIA", "FK_STATO", "L1_3_POT_H2O_KW", "L1_3_POT_CLIMA_INV_KW",
					"L1_3_POT_CLIMA_EST_KW", "FLG_NOPDR", "INDIRIZZO_UNITA_IMMOB", "CIVICO", "SEZIONE", "FOGLIO",
					"PARTICELLA", "SUBALTERNO", "POD_ELETTRICO", "PDR_GAS", "DENOMINAZIONE_RESPONSABILE",
					"CODICE_FISCALE", "DATA_FINE_PFPG", "RUOLO_RESPONSABILE", "RUOLO_FUNZ", "DES_STATO",
					"FLG_VISU_PROPRIETARIO"},
			SigitVRicercaImpiantiDto.class, this);

	protected SigitVRicercaImpiantiDaoRowMapper ImpiantiDaRicercaAvanzataRowMapper = new SigitVRicercaImpiantiDaoRowMapper(
			null, SigitVRicercaImpiantiDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_RICERCA_IMPIANTI";
	}

	/** 
	 * Implementazione del finder byImpiantoFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaImpiantiDto> findByImpiantoFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImpiantoFilter input)
			throws SigitVRicercaImpiantiDaoException {
		LOG.debug("[SigitVRicercaImpiantiDaoImpl::findByImpiantoFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT DISTINCT CODICE_IMPIANTO,ISTAT_COMUNE,DENOMINAZIONE_COMUNE,SIGLA_PROVINCIA,DENOMINAZIONE_PROVINCIA,FK_STATO,L1_3_POT_H2O_KW,L1_3_POT_CLIMA_INV_KW,L1_3_POT_CLIMA_EST_KW,FLG_NOPDR,INDIRIZZO_UNITA_IMMOB,CIVICO,SEZIONE,FOGLIO,PARTICELLA,SUBALTERNO,POD_ELETTRICO,PDR_GAS,DENOMINAZIONE_RESPONSABILE,CODICE_FISCALE,DATA_FINE_PFPG,RUOLO_RESPONSABILE,RUOLO_FUNZ,DES_STATO,FLG_VISU_PROPRIETARIO ");
		/*PROTECTED REGION ID(R742345974) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM VISTA_RICERCA_IMPIANTI vri");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1320524484) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" 1=1 ");

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceImpianto())) {
			sql.append(" AND CODICE_IMPIANTO = :codiceImp");
			paramMap.addValue("codiceImp", input.getCodiceImpianto());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaProvincia())) {
			sql.append(" AND SIGLA_PROVINCIA = :provincia");
			paramMap.addValue("provincia", input.getSiglaProvincia());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaComune())) {
			sql.append(" AND ISTAT_COMUNE = :comune");
			paramMap.addValue("comune", input.getSiglaComune());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDescComune())) {
			sql.append(" AND UPPER(DENOMINAZIONE_COMUNE) LIKE UPPER('" + input.getDescComune() + "%') ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIndirizzo())) {
			sql.append(" AND UPPER(INDIRIZZO_UNITA_IMMOB) LIKE UPPER('%" + input.getIndirizzo() + "%') ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCivico())) {
			sql.append(" AND UPPER(CIVICO) LIKE UPPER('%" + input.getCivico() + "%') ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCfResponsabile())) {
			sql.append(" AND UPPER(CODICE_FISCALE) = UPPER(:cf)");
			paramMap.addValue("cf", input.getCfResponsabile());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCfProprietario())) {
			sql.append(" AND EXISTS ( select 1 FROM vista_tot_impianto vti WHERE ");
			sql.append(" vri.CODICE_IMPIANTO = vti.CODICE_IMPIANTO ");
			sql.append(" AND UPPER(CODICE_FISCALE) = UPPER(:cfp)");
			paramMap.addValue("cfp", input.getCfProprietario());
			List<Integer> ruoli = new ArrayList<Integer>(2);
			ruoli.add(Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO);
			ruoli.add(Constants.ID_RUOLO_PROPRIETARIO_PROPRIETARIO_IMPRESA);
			sql.append(" AND ID_RUOLO IN (" + ConvertUtil.getStringByList(ruoli) + ")");
			sql.append(" AND DATA_FINE_PFPG IS NULL");
			sql.append(" ) ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCf3Responsabile())) {
			sql.append(" AND UPPER(CODICE_FISCALE_3R) = UPPER(:cf3r)");
			paramMap.addValue("cf3r", input.getCf3Responsabile());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaRea()) || GenericUtil.isNotNullOrEmpty(input.getNumeroRea())
				|| GenericUtil.isNotNullOrEmpty(input.getCfDitta())) {
			sql.append(" AND EXISTS ( select 1 FROM vista_impianti_imprese vii WHERE ");
			sql.append(" vri.CODICE_IMPIANTO = vii.CODICE_IMPIANTO ");

			if (GenericUtil.isNotNullOrEmpty(input.getSiglaRea())) {
				sql.append(" AND SIGLA_REA = :siglaRea");
				paramMap.addValue("siglaRea", input.getSiglaRea());
			}

			if (GenericUtil.isNotNullOrEmpty(input.getNumeroRea())) {
				sql.append(" AND NUMERO_REA = :numeroRea");
				paramMap.addValue("numeroRea", input.getNumeroRea());
			}

			if (GenericUtil.isNotNullOrEmpty(input.getCfDitta())) {
				sql.append(" AND UPPER(CODICE_FISCALE) = UPPER(:cfImpresa)");
				paramMap.addValue("cfImpresa", input.getCfDitta());
			}

			sql.append(" ) ");

			//			codice_impianto in ( select codice_impianto from vista_impianti_imprese
			//					where numero_rea = 1119775 and sigla_rea = 'TO')
		}

		if (GenericUtil.isNotNullOrEmpty(input.getPod())) {
			sql.append(" AND UPPER(POD_ELETTRICO) = UPPER(:pod)");
			paramMap.addValue("pod", input.getPod());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getPdr())) {
			sql.append(" AND UPPER(PDR_GAS) = UPPER(:pdr)");
			paramMap.addValue("pdr", input.getPdr());
		}

		if (input.getFlagVisuProprietario() != null) {
			sql.append(" AND FLG_VISU_PROPRIETARIO = :flg_visu_proprietario");
			paramMap.addValue("flg_visu_proprietario", input.getFlagVisuProprietario());
		}

		/*
		if (GenericUtil.isNotNullOrEmpty(input.getSiglaRea())
				|| GenericUtil.isNotNullOrEmpty(input.getNumeroRea())
				|| GenericUtil.isNotNullOrEmpty(input.getCfDitta())) {
			sql.append(" AND CODICE_IMPIANTO IN ( select CODICE_IMPIANTO FROM vista_impianti_imprese WHERE ");
			sql.append(" 1=1 ");
		
			if (GenericUtil.isNotNullOrEmpty(input.getSiglaRea())) {
				sql.append(" AND SIGLA_REA = :siglaRea");
				paramMap.addValue("siglaRea", input.getSiglaRea());
			}
		
			if (GenericUtil.isNotNullOrEmpty(input.getNumeroRea())) {
				sql.append(" AND NUMERO_REA = :numeroRea");
				paramMap.addValue("numeroRea", input.getNumeroRea());
			}
		
			if (GenericUtil.isNotNullOrEmpty(input.getCfDitta())) {
				sql.append(" AND CODICE_FISCALE = :cfImpresa");
				paramMap.addValue("cfImpresa", input.getCfDitta());
			}
		
			sql.append(" ) ");
		
			//			codice_impianto in ( select codice_impianto from vista_impianti_imprese
			//					where numero_rea = 1119775 and sigla_rea = 'TO')
		}
		 */

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1132850178) ENABLED START*/
		sql.append(" LIMIT (SELECT VALORE_CONFIG_NUM FROM SIGIT_WRK_CONFIG WHERE CHIAVE_CONFIG='MAX_RIGHE') ");
		/*PROTECTED REGION END*/
		List<SigitVRicercaImpiantiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byImpiantoFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaImpiantiDaoImpl::findByImpiantoFilter] esecuzione query", ex);
			throw new SigitVRicercaImpiantiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaImpiantiDaoImpl", "findByImpiantoFilter", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVRicercaImpiantiDaoImpl::findByImpiantoFilter] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder ImpiantiDaRicercaAvanzata
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaImpiantiDto> findImpiantiDaRicercaAvanzata(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaAvanzataImpiantoFilter input)
			throws SigitVRicercaImpiantiDaoException {
		LOG.debug("[SigitVRicercaImpiantiDaoImpl::findImpiantiDaRicercaAvanzata] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R1075669515) ENABLED START*/
		sql.append(
				"SELECT DISTINCT I.CODICE_IMPIANTO,ISTAT_COMUNE,DENOMINAZIONE_COMUNE,SIGLA_PROVINCIA,DENOMINAZIONE_PROVINCIA,I.INDIRIZZO_UNITA_IMMOB,CIVICO,DENOMINAZIONE_RESPONSABILE,"
						+ "I.DENOMINAZIONE_3_RESPONSABILE,I.SIGLA_REA_3R,I.NUMERO_REA_3R,I.CODICE_FISCALE_3R,I.CODICE_FISCALE,I.DATA_FINE_PFPG,I.RUOLO_RESPONSABILE,I.RUOLO_FUNZ,"
						+ "I.SEZIONE, I.FOGLIO, I.PARTICELLA, I.SUBALTERNO, I.POD_ELETTRICO, I.PDR_GAS, I.FK_STATO,I.L1_3_POT_H2O_KW,I.L1_3_POT_CLIMA_INV_KW,I.L1_3_POT_CLIMA_EST_KW,I.FLG_NOPDR,"
						+ "FLG_TIPO_IMPIANTO, FLG_APPARECC_UI_EXT, FLG_CONTABILIZZAZIONE, DES_STATO, FLG_VISU_PROPRIETARIO ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-554957987) ENABLED START*/
		sql.append(" FROM VISTA_RICERCA_IMPIANTI I ");
		if (input.isRicercaImpresa())
			sql.append(" JOIN VISTA_IMPIANTI_IMPRESE II ON I.CODICE_IMPIANTO = II.CODICE_IMPIANTO ");

		if (input.isRicercaAllegati()) {
			sql.append(" JOIN VISTA_RICERCA_ALLEGATI A ON A.CODICE_IMPIANTO = I.CODICE_IMPIANTO ");

			if (GenericUtil.isNotNullOrEmpty(input.geteNoxDa()) || GenericUtil.isNotNullOrEmpty(input.geteNoxA())) {

				if (it.csi.sigit.sigitwebn.util.Constants.ALLEGATO_TIPO_1.equals(input.getTipoRapporto())
						|| it.csi.sigit.sigitwebn.util.Constants.ALLEGATO_TIPO_1B.equals(input.getTipoRapporto())) {
					sql.append(" JOIN SIGIT_T_DETT_TIPO1 DET ON DET.FK_ALLEGATO = A.ID_ALLEGATO  ");
				} else if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(input.getTipoRapporto())) {
					sql.append(" JOIN SIGIT_T_DETT_ISPEZ_GT DET ON DET.FK_ALLEGATO = A.ID_ALLEGATO  ");
				}
			}

			if (GenericUtil.isNotNullOrEmpty(input.getFlgVerificaAssociata())) {

				if (ConvertUtil.convertToBooleanAllways(input.getFlgVerificaAssociata())) {
					// CON VERIFICA
					sql.append(" INNER JOIN SIGIT_T_VERIFICA V ON A.id_allegato = V.fk_allegato ");
				} else {
					// SENZA VERIFICA
					sql.append(" LEFT JOIN SIGIT_T_VERIFICA V ON A.id_allegato = V.fk_allegato ");
				}
			}

		}

		if (input.isRicercaTerzoResp())
			sql.append(" JOIN VISTA_RICERCA_3_RESPONSABILE R ON R.CODICE_IMPIANTO = I.CODICE_IMPIANTO ");
		if (input.isRicercaComponenti())
			sql.append(" JOIN VISTA_RICERCA_COMP C ON C.CODICE_IMPIANTO = I.CODICE_IMPIANTO ");

		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoDocumento())) {
			sql.append(" JOIN SIGIT_T_DOC_AGGIUNTIVA D ON D.CODICE_IMPIANTO = I.CODICE_IMPIANTO  ");
		}

		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-241192643) ENABLED START*/

		sql.append(" 1=1 ");

		if (input.isRicercaAllegati() && GenericUtil.isNotNullOrEmpty(input.getFlgVerificaAssociata())
				&& !ConvertUtil.convertToBooleanAllways(input.getFlgVerificaAssociata())) {
			sql.append("AND V.fk_allegato IS NULL ");
		}

		if (input.isRicercaTerzoResp()) {
			sql.append(" AND coalesce(R.CODICE_FISCALE_3_RESP,'1') = coalesce(I.CODICE_FISCALE_3R,'1') ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceImpianto())) {
			sql.append(" AND I.CODICE_IMPIANTO = :codiceImp");
			paramMap.addValue("codiceImp", input.getCodiceImpianto(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaProvincia())) {
			sql.append(" AND SIGLA_PROVINCIA = :provincia");
			paramMap.addValue("provincia", input.getSiglaProvincia());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaComune())) {
			sql.append(" AND ISTAT_COMUNE = :comune");
			paramMap.addValue("comune", input.getSiglaComune());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDescComune())) {
			sql.append(" AND UPPER(DENOMINAZIONE_COMUNE) LIKE UPPER('" + input.getDescComune() + "%') ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIndirizzo())) {
			sql.append(" AND UPPER(INDIRIZZO_UNITA_IMMOB) LIKE UPPER('%" + input.getIndirizzo() + "%') ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCfResponsabile())) {
			sql.append(" AND UPPER(I.CODICE_FISCALE) = UPPER(:cf)");
			paramMap.addValue("cf", input.getCfResponsabile());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSezione())) {
			sql.append(" AND UPPER(I.SEZIONE) LIKE UPPER(:sezione)");
			paramMap.addValue("sezione", input.getSezione());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFoglio())) {
			sql.append(" AND UPPER(I.FOGLIO) LIKE UPPER(:foglio)");
			paramMap.addValue("foglio", input.getFoglio());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getParticella())) {
			sql.append(" AND UPPER(I.PARTICELLA) LIKE UPPER(:pcl)");
			paramMap.addValue("pcl", input.getParticella());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSubalterno())) {
			sql.append(" AND UPPER(I.SUBALTERNO) LIKE UPPER(:suba)");
			paramMap.addValue("suba", input.getSubalterno());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getPod())) {
			sql.append(" AND UPPER(I.POD_ELETTRICO) LIKE UPPER(:pod)");
			paramMap.addValue("pod", input.getPod());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getPdr())) {
			sql.append(" AND UPPER(I.PDR_GAS) LIKE UPPER(:pdr)");
			paramMap.addValue("pdr", input.getPdr());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getStatoImpianto())) {
			sql.append(" AND I.FK_STATO = :statoImp");
			paramMap.addValue("statoImp", ConvertUtil.convertToInteger(input.getStatoImpianto()),
					java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSenzaPdr()) && input.getSenzaPdr()) {
			sql.append(" AND I.FLG_NOPDR = 1 ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getPotenzaAcsDa())) {
			sql.append(" AND I.L1_3_POT_H2O_KW >= :potAcsDa");
			paramMap.addValue("potAcsDa", input.getPotenzaAcsDa(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getPotenzaAcsA())) {
			sql.append(" AND I.L1_3_POT_H2O_KW <= :potAcsA");
			paramMap.addValue("potAcsA", input.getPotenzaAcsA(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getPotenzaClimaEstDa())) {
			sql.append(" AND I.L1_3_POT_CLIMA_EST_KW >= :potEstDa");
			paramMap.addValue("potEstDa", input.getPotenzaClimaEstDa(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getPotenzaClimaEstA())) {
			sql.append(" AND I.L1_3_POT_CLIMA_EST_KW <= :potEstA");
			paramMap.addValue("potEstA", input.getPotenzaClimaEstA(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getPotenzaClimaInvDa())) {
			sql.append(" AND I.L1_3_POT_CLIMA_INV_KW >= :potInvDa");
			paramMap.addValue("potInvDa", input.getPotenzaClimaInvDa(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getPotenzaClimaInvA())) {
			sql.append(" AND I.L1_3_POT_CLIMA_INV_KW <= :potInvA");
			paramMap.addValue("potInvA", input.getPotenzaClimaInvA(), java.sql.Types.NUMERIC);
		}

		// NEW - INIZIO

		if (GenericUtil.isNotNullOrEmpty(input.getTipoImpianto())) {
			sql.append(" AND I.FLG_TIPO_IMPIANTO = :tipoImp");
			paramMap.addValue("tipoImp", input.getTipoImpianto());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFlgAppareccUiExt())) {

			sql.append(" AND I.FLG_APPARECC_UI_EXT = :flgAppExt");
			paramMap.addValue("flgAppExt", ConvertUtil.convertToBigDecimal(input.getFlgAppareccUiExt()),
					java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getFlgContabilizzatore())) {

			sql.append(" AND I.FLG_CONTABILIZZAZIONE = :flgContab");
			paramMap.addValue("flgContab", ConvertUtil.convertToBigDecimal(input.getFlgContabilizzatore()),
					java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdIncaricato())) {
			sql.append(" AND A.FK_PG_CAT = :idCAT");
			paramMap.addValue("idCAT", input.getIdIncaricato(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoDocumento())
				&& !input.getIdTipoDocumento().toString().equals(Constants.ID_TUTTE)) {
			sql.append(" AND D.FK_TIPO_DOCAGG = :idTipoDoc");
			paramMap.addValue("idTipoDoc", input.getIdTipoDocumento(), java.sql.Types.NUMERIC);
		}

		// NEW - FINE

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaRea())) {
			sql.append(" AND II.SIGLA_REA = :siglaRea");
			paramMap.addValue("siglaRea", input.getSiglaRea());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getNumeroRea())) {
			sql.append(" AND II.NUMERO_REA = :numeroRea");
			paramMap.addValue("numeroRea", input.getNumeroRea());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCfDitta())) {
			sql.append(" AND UPPER(II.CODICE_FISCALE) = UPPER(:cfImpresa)");
			paramMap.addValue("cfImpresa", input.getCfDitta());
		}

		if (input.isRicercaAllegati()) {
			sql.append(" AND FK_STATO_RAPP = " + Constants.ID_STATO_RAPPORTO_INVIATO);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getTipoRapporto())) {
			sql.append(" AND FK_TIPO_DOCUMENTO = :tipoRapporto");
			paramMap.addValue("tipoRapporto", input.getTipoRapporto(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSicurezzaImpianti())) {

			sql.append(" AND F_FLG_PUO_FUNZIONARE = :sicImpianti");
			paramMap.addValue("sicImpianti", ConvertUtil.convertToBigDecimal(input.getSicurezzaImpianti()),
					java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getConOsservazioni()) && input.getConOsservazioni()) {
			//sql.append(" AND F_OSSERVAZIONI IS NOT NULL");
			sql.append(" AND (F_OSSERVAZIONI IS NOT NULL AND TRIM(F_OSSERVAZIONI) != '') ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getConPrescrizioni()) && input.getConPrescrizioni()) {
			//sql.append(" AND F_PRESCRIZIONI IS NOT NULL");
			sql.append(" AND (F_PRESCRIZIONI IS NOT NULL AND TRIM(F_PRESCRIZIONI) != '') ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getConRaccomandazioni()) && input.getConRaccomandazioni()) {
			//sql.append(" AND F_RACCOMANDAZIONI IS NOT NULL");
			sql.append(" AND (F_RACCOMANDAZIONI IS NOT NULL AND TRIM(F_RACCOMANDAZIONI) != '') ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataControlloDa())) {
			sql.append(" AND DATA_CONTROLLO >= :dataControlloDa");
			paramMap.addValue("dataControlloDa", input.getDataControlloDa(), java.sql.Types.DATE);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataControlloA())) {
			sql.append(" AND DATA_CONTROLLO <= :dataControlloA");
			paramMap.addValue("dataControlloA", input.getDataControlloA(), java.sql.Types.DATE);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getInterventoManutentivoDa())) {
			sql.append(" AND F_INTERVENTO_ENTRO >= :intManDa");
			paramMap.addValue("intManDa", input.getInterventoManutentivoDa(), java.sql.Types.DATE);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getInterventoManutentivoA())) {
			sql.append(" AND F_INTERVENTO_ENTRO <= :intManA");
			paramMap.addValue("intManA", input.getInterventoManutentivoA(), java.sql.Types.DATE);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getNumGiorniInviatoDopoDataControllo())) {
			sql.append(
					" AND date_part('day', cast(DATA_INVIO as timestamp) - cast(DATA_CONTROLLO as timestamp)) > :numGiorniInviatoDopoDataControllo");
			paramMap.addValue("numGiorniInviatoDopoDataControllo", input.getNumGiorniInviatoDopoDataControllo(),
					java.sql.Types.NUMERIC);
		}

		log.debug("[SigitVRicercaImpiantiDaoImpl::findImpiantiDaRicercaAvanzata] - input.geteNoxDa(): "
				+ input.geteNoxDa());
		if (GenericUtil.isNotNullOrEmpty(input.geteNoxDa())) {
			log.debug("[SigitVRicercaImpiantiDaoImpl::findImpiantiDaRicercaAvanzata] - input.getTipoRapporto(): "
					+ input.getTipoRapporto());
			log.debug("[SigitVRicercaImpiantiDaoImpl::findImpiantiDaRicercaAvanzata] - input.getUnitaMisEnox(): "
					+ input.getUnitaMisEnox());
			log.debug("[SigitVRicercaImpiantiDaoImpl::findImpiantiDaRicercaAvanzata] - UnitaMisuraNox.PPM_0: "
					+ UnitaMisuraNox.PPM_0);
			log.debug("[SigitVRicercaImpiantiDaoImpl::findImpiantiDaRicercaAvanzata] - UnitaMisuraNox.MG_KWH_1: "
					+ UnitaMisuraNox.MG_KWH_1);
			log.debug(
					"[SigitVRicercaImpiantiDaoImpl::findImpiantiDaRicercaAvanzata] - UnitaMisuraNox.PPM_0.getCodice(): "
							+ UnitaMisuraNox.PPM_0.getCodice());
			log.debug(
					"[SigitVRicercaImpiantiDaoImpl::findImpiantiDaRicercaAvanzata] - UnitaMisuraNox.PPM_0.getDescrizione(): "
							+ UnitaMisuraNox.PPM_0.getDescrizione());

			if (Constants.ALLEGATO_TIPO_1.equals(input.getTipoRapporto())) {
				if (input.getUnitaMisEnox().equals(UnitaMisuraNox.PPM_0.getCodice())) {
					sql.append(" AND DET.E_NOX_PPM >= :noxDa");
				} else if (input.getUnitaMisEnox().equals(UnitaMisuraNox.MG_KWH_1.getCodice())) {
					sql.append(" AND DET.E_NOX_MG_KWH >= :noxDa");
				}
			} else if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(input.getTipoRapporto())) {
				sql.append(" AND DET.S8E_NOX_MG_KW_H >= :noxDa");
			}

			paramMap.addValue("noxDa", input.geteNoxDa(), java.sql.Types.NUMERIC);

		}

		log.debug("[SigitVRicercaImpiantiDaoImpl::findImpiantiDaRicercaAvanzata] - input.geteNoxA(): "
				+ input.geteNoxA());

		if (GenericUtil.isNotNullOrEmpty(input.geteNoxA())) {
			log.debug("[SigitVRicercaImpiantiDaoImpl::findImpiantiDaRicercaAvanzata] - input.getTipoRapporto(): "
					+ input.getTipoRapporto());
			log.debug("[SigitVRicercaImpiantiDaoImpl::findImpiantiDaRicercaAvanzata] - input.getUnitaMisEnox(): "
					+ input.getUnitaMisEnox());

			if (Constants.ALLEGATO_TIPO_1.equals(input.getTipoRapporto())) {
				if (input.getUnitaMisEnox().equals(UnitaMisuraNox.PPM_0.getCodice())) {
					sql.append(" AND DET.E_NOX_PPM <= :noxA");
				} else if (input.getUnitaMisEnox().equals(UnitaMisuraNox.MG_KWH_1.getCodice())) {
					sql.append(" AND DET.E_NOX_MG_KWH <= :noxA");
				}
			} else if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(input.getTipoRapporto())) {
				sql.append(" AND DET.S8E_NOX_MG_KW_H <= :noxA");
			}

			paramMap.addValue("noxA", input.geteNoxA(), java.sql.Types.NUMERIC);

		}

		if (GenericUtil.isNotNullOrEmpty(input.getSiglaBollino())) {
			sql.append(" AND A.FK_SIGLA_BOLLINO = :siglaBollino");
			paramMap.addValue("siglaBollino", input.getSiglaBollino(), java.sql.Types.VARCHAR);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getNumeroBollino())) {
			sql.append(" AND A.FK_NUMERO_BOLLINO = :nrBollino");
			paramMap.addValue("nrBollino", input.getNumeroBollino(), java.sql.Types.NUMERIC);
		}

		//componenti
		if (GenericUtil.isNotNullOrEmpty(input.getTipoComponente())) {
			sql.append(" AND C.ID_TIPO_COMPONENTE = :tipoComp");
			paramMap.addValue("tipoComp", input.getTipoComponente(), java.sql.Types.VARCHAR);
		}

		if (input.isRicercaComponenti() && !ConvertUtil.convertToBooleanAllways(input.getFlgDismesse())) {
			sql.append(" AND C.DATA_DISMISS IS NULL");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getMarca())) {
			sql.append(" AND C.FK_MARCA = :marca");
			paramMap.addValue("marca", input.getMarca(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCombustibile())) {
			sql.append(" AND C.FK_COMBUSTIBILE = :combustibile");
			paramMap.addValue("combustibile", input.getCombustibile(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getRendimentoPercDa())) {
			sql.append(" AND C.RENDIMENTO_PERC >= :rendimentoPercDa");
			paramMap.addValue("rendimentoPercDa", input.getRendimentoPercDa(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getRendimentoPercA())) {
			sql.append(" AND C.RENDIMENTO_PERC <= :rendimentoPercA");
			paramMap.addValue("rendimentoPercA", input.getRendimentoPercA(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getPotenzaTermicaDa())) {
			sql.append(" AND C.POTENZA_TERMICA_KW >= :potTermicaDa");
			paramMap.addValue("potTermicaDa", input.getPotenzaTermicaDa(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getPotenzaTermicaA())) {
			sql.append(" AND C.POTENZA_TERMICA_KW <= :potTermicaA");
			paramMap.addValue("potTermicaA", input.getPotenzaTermicaA(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataInstallazioneDa())) {
			sql.append(" AND C.DATA_INSTALL >= :dataInstallDa");
			paramMap.addValue("dataInstallDa", input.getDataInstallazioneDa(), java.sql.Types.DATE);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataInstallazioneA())) {
			sql.append(" AND C.DATA_INSTALL <= :dataInstallA");
			paramMap.addValue("dataInstallA", input.getDataInstallazioneA(), java.sql.Types.DATE);
		}

		//terzo responsabile
		if (GenericUtil.isNotNullOrEmpty(input.getCf3Responsabile())) {
			sql.append(" AND UPPER(R.CODICE_FISCALE_3_RESP) = (:cf3Resp)");
			paramMap.addValue("cf3Resp", input.getCf3Responsabile(), java.sql.Types.VARCHAR);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getGgInserimentoContratto())) {
			sql.append(" AND EXTRACT (DAY FROM (R.DATA_CARICAMENTO - R.DATA_INIZIO_CONTRATTO)) > :ggInsContr");
			paramMap.addValue("ggInsContr", input.getGgInserimentoContratto(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getGgRevoca())) {
			sql.append(" AND EXTRACT (DAY FROM (R.DATA_INSERIMENTO_CESSAZIONE - R.DATA_CESSAZIONE)) > :ggRevContr");
			paramMap.addValue("ggRevContr", input.getGgRevoca(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataInizioContrattoDa())) {
			sql.append(" AND R.DATA_INIZIO_CONTRATTO >= :dtInizioContrattoDa");
			paramMap.addValue("dtInizioContrattoDa", input.getDataInizioContrattoDa(), java.sql.Types.DATE);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataInizioContrattoA())) {
			sql.append(" AND R.DATA_INIZIO_CONTRATTO <= :dtInizioContrattoA");
			paramMap.addValue("dtInizioContrattoA", input.getDataInizioContrattoA(), java.sql.Types.DATE);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataFineContrattoDa())) {
			sql.append(" AND COALESCE(R.DATA_CESSAZIONE, R.DATA_FINE_CONTRATTO) >= :dtFineContrattoDa");
			paramMap.addValue("dtFineContrattoDa", input.getDataFineContrattoDa(), java.sql.Types.DATE);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataFineContrattoA())) {
			sql.append(" AND COALESCE(R.DATA_CESSAZIONE, R.DATA_FINE_CONTRATTO) <= :dtFineContrattoA");
			paramMap.addValue("dtFineContrattoA", input.getDataFineContrattoA(), java.sql.Types.DATE);
		}

		//		if (input.isRicercaComponenti()) {
		//			sql.append(" AND C.DATA_DISMISS IS NULL ");
		//		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1993526437) ENABLED START*/
		sql.append(
				" LIMIT (SELECT VALORE_CONFIG_NUM FROM SIGIT_WRK_CONFIG WHERE CHIAVE_CONFIG='MAX_RIGHE_RIC_AVZ_IMP') ");
		/*PROTECTED REGION END*/
		List<SigitVRicercaImpiantiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ImpiantiDaRicercaAvanzataRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaImpiantiDaoImpl::findImpiantiDaRicercaAvanzata] esecuzione query", ex);
			throw new SigitVRicercaImpiantiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaImpiantiDaoImpl", "findImpiantiDaRicercaAvanzata", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVRicercaImpiantiDaoImpl::findImpiantiDaRicercaAvanzata] END");
		}
		return list;
	}

}
