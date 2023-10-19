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

/*PROTECTED REGION ID(R81234807) ENABLED START*/
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.Constants;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVRicercaAllegatiStorico.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - byCodiceImpianto (datagen::CustomFinder)
 *   - byFiltriUtente (datagen::CustomFinder)
 *   - byIdAllegato (datagen::CustomFinder)
 *   - inviatiByCodImpiantoOrderedByData (datagen::CustomFinder)
 *   - manutByCodImpianto (datagen::CustomFinder)
 *   - reeByCodImpiantoOrderedByData (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitVRicercaAllegatiStoricoDaoImpl extends AbstractDAO implements SigitVRicercaAllegatiStoricoDao {
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

	protected SigitVRicercaAllegatiStoricoDaoRowMapper findAllRowMapper = new SigitVRicercaAllegatiStoricoDaoRowMapper(
			null, SigitVRicercaAllegatiStoricoDto.class, this);

	protected SigitVRicercaAllegatiStoricoDaoRowMapper byCodiceImpiantoRowMapper = new SigitVRicercaAllegatiStoricoDaoRowMapper(
			null, SigitVRicercaAllegatiStoricoDto.class, this);

	protected SigitVRicercaAllegatiStoricoDaoRowMapper byFiltriUtenteRowMapper = new SigitVRicercaAllegatiStoricoDaoRowMapper(
			null, SigitVRicercaAllegatiStoricoDto.class, this);

	protected SigitVRicercaAllegatiStoricoDaoRowMapper byIdAllegatoRowMapper = new SigitVRicercaAllegatiStoricoDaoRowMapper(
			null, SigitVRicercaAllegatiStoricoDto.class, this);

	protected SigitVRicercaAllegatiStoricoDaoRowMapper inviatiByCodImpiantoOrderedByDataRowMapper = new SigitVRicercaAllegatiStoricoDaoRowMapper(
			null, SigitVRicercaAllegatiStoricoDto.class, this);

	protected SigitVRicercaAllegatiStoricoDaoRowMapper manutByCodImpiantoRowMapper = new SigitVRicercaAllegatiStoricoDaoRowMapper(
			null, SigitVRicercaAllegatiStoricoDto.class, this);

	protected SigitVRicercaAllegatiStoricoDaoRowMapper reeByCodImpiantoOrderedByDataRowMapper = new SigitVRicercaAllegatiStoricoDaoRowMapper(
			null, SigitVRicercaAllegatiStoricoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_RICERCA_ALLEGATI_STORICO";
	}

	/** 
	 * Restituisce tutte le righe della tabella VISTA_RICERCA_ALLEGATI_STORICO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiStoricoDto> findAll() throws SigitVRicercaAllegatiStoricoDaoException {
		LOG.debug("[SigitVRicercaAllegatiStoricoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_IMP_RUOLO_PFPG,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitVRicercaAllegatiStoricoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiStoricoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitVRicercaAllegatiStoricoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiStoricoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitVRicercaAllegatiStoricoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiStoricoDto> findByCodiceImpianto(java.lang.String input)
			throws SigitVRicercaAllegatiStoricoDaoException {
		LOG.debug("[SigitVRicercaAllegatiStoricoDaoImpl::findByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_IMP_RUOLO_PFPG,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI_STORICO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R609818788) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_IMPIANTO = :codiceImpianto");
		sql.append(" AND FK_TIPO_DOCUMENTO IN (" + Constants.ALLEGATO_TIPO_1 + "," + Constants.ALLEGATO_TIPO_1B + ","
				+ Constants.ALLEGATO_TIPO_2 + "," + Constants.ALLEGATO_TIPO_3 + "," + Constants.ALLEGATO_TIPO_4 + ","
				+ Constants.ALLEGATO_G + "," + Constants.ALLEGATO_F + ") ");

		sql.append(" ORDER BY DATA_CONTROLLO DESC, ID_ALLEGATO DESC ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1689890274) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codiceImpianto", ConvertUtil.convertToInteger(input));

		/*PROTECTED REGION END*/
		List<SigitVRicercaAllegatiStoricoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiStoricoDaoImpl::findByCodiceImpianto] esecuzione query", ex);
			throw new SigitVRicercaAllegatiStoricoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiStoricoDaoImpl", "findByCodiceImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVRicercaAllegatiStoricoDaoImpl::findByCodiceImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byFiltriUtente
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiStoricoDto> findByFiltriUtente(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaAllegati input)
			throws SigitVRicercaAllegatiStoricoDaoException {
		LOG.debug("[SigitVRicercaAllegatiStoricoDaoImpl::findByFiltriUtente] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_IMP_RUOLO_PFPG,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI_STORICO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1173506119) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("1 = 1 ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1395452197) ENABLED START*/
		//***aggiungere tutte le condizioni

		//Recupero la lista dei codici impianto da mettere dentro la in della query per tipologia di utente
		String codiciImpianto = "";
		if (input.getElencoCodiciImpianto() != null && input.getElencoCodiciImpianto().size() > 0) {
			for (String str : input.getElencoCodiciImpianto()) {
				codiciImpianto += str + ",";
			}

			codiciImpianto = codiciImpianto.substring(0, (codiciImpianto.length() - 1));
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdStatoAllegato())) {
			sql.append(" AND FK_STATO_RAPP = :idStatoAllegato");
			paramMap.addValue("idStatoAllegato", input.getIdStatoAllegato(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoDocumento())) {
			sql.append(" AND FK_TIPO_DOCUMENTO = :idTipoDocumento");
			paramMap.addValue("idTipoDocumento", input.getIdTipoDocumento(), java.sql.Types.NUMERIC);
		}

		//le date possono essere valorizzate singolarmente e non per forza a coppia
		if (GenericUtil.isNotNullOrEmpty(input.getDataControlloA())
				&& GenericUtil.isNotNullOrEmpty(input.getDataControlloDa())) {
			sql.append(" AND DATA_CONTROLLO >= :dataDa   AND DATA_CONTROLLO <= :dataA");
			paramMap.addValue("dataDa", ConvertUtil.convertToSqlDate(input.getDataControlloDa()), java.sql.Types.DATE);
			paramMap.addValue("dataA", ConvertUtil.convertToSqlDate(input.getDataControlloA()), java.sql.Types.DATE);
		} else {
			if (GenericUtil.isNotNullOrEmpty(input.getDataControlloA())) {
				sql.append(" AND DATA_CONTROLLO <= :dataA");
				paramMap.addValue("dataA", ConvertUtil.convertToSqlDate(input.getDataControlloA()),
						java.sql.Types.DATE);
			}

			if (GenericUtil.isNotNullOrEmpty(input.getDataControlloDa())) {
				sql.append(" AND DATA_CONTROLLO >= :dataDa");
				paramMap.addValue("dataDa", ConvertUtil.convertToSqlDate(input.getDataControlloDa()),
						java.sql.Types.DATE);
			}
		}

		if (GenericUtil.isNotNullOrEmpty(input.getSicurezzaImpianti())) {

			sql.append(" AND F_FLG_PUO_FUNZIONARE = :sicImpianti");

			paramMap.addValue("sicImpianti", ConvertUtil.convertToBigDecimal(input.getSicurezzaImpianti()),
					java.sql.Types.NUMERIC);
		}

		if (ConvertUtil.convertToBooleanAllways(input.getConOsservazioni())) {
			//sql.append(" AND F_OSSERVAZIONI IS NOT NULL");
			sql.append(" AND (F_OSSERVAZIONI IS NOT NULL AND TRIM(F_OSSERVAZIONI) != '') ");
		}

		if (ConvertUtil.convertToBooleanAllways(input.getConPrescrizioni())) {
			//sql.append(" AND F_PRESCRIZIONI IS NOT NULL");
			sql.append(" AND (F_PRESCRIZIONI IS NOT NULL AND TRIM(F_PRESCRIZIONI) != '') ");
		}

		if (ConvertUtil.convertToBooleanAllways(input.getConRaccomandazioni())) {
			//sql.append(" AND F_RACCOMANDAZIONI IS NOT NULL");
			sql.append(" AND (F_RACCOMANDAZIONI IS NOT NULL AND TRIM(F_RACCOMANDAZIONI) != '') ");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getInterventoDa())
				&& GenericUtil.isNotNullOrEmpty(input.getInterventoA())) {
			sql.append(" AND F_INTERVENTO_ENTRO >= :dataInterventoDa  AND F_INTERVENTO_ENTRO <= :dataInterventoA");
			paramMap.addValue("dataInterventoDa", ConvertUtil.convertToSqlDate(input.getInterventoDa()),
					java.sql.Types.DATE);
			paramMap.addValue("dataInterventoA", ConvertUtil.convertToSqlDate(input.getInterventoA()),
					java.sql.Types.DATE);
		} else {
			if (GenericUtil.isNotNullOrEmpty(input.getInterventoDa())) {
				sql.append(" AND F_INTERVENTO_ENTRO <= :dataInterventoDa");
				paramMap.addValue("dataInterventoDa", ConvertUtil.convertToSqlDate(input.getInterventoDa()),
						java.sql.Types.DATE);
			}
			if (GenericUtil.isNotNullOrEmpty(input.getInterventoA())) {
				sql.append(" AND F_INTERVENTO_ENTRO <= :dataInterventoA");
				paramMap.addValue("dataInterventoA", ConvertUtil.convertToSqlDate(input.getInterventoA()),
						java.sql.Types.DATE);
			}
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdBollinoSigla())) {
			sql.append(" AND FK_SIGLA_BOLLINO = :idSiglaBollino");
			paramMap.addValue("idSiglaBollino", input.getIdBollinoSigla(), java.sql.Types.VARCHAR);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getNumeroBollino())) {
			sql.append(" AND FK_NUMERO_BOLLINO = :idNumeroBollino");
			paramMap.addValue("idNumeroBollino", input.getNumeroBollino(), java.sql.Types.NUMERIC);
		}

		log.debug("SETTO LA QUERY siglaRea: " + input.getIdReaSigla());
		log.debug("SETTO LA QUERY numeroRea: " + input.getNumeroRea());

		if (GenericUtil.isNotNullOrEmpty(input.getIdReaSigla()) && GenericUtil.isNotNullOrEmpty(input.getNumeroRea())) {
			sql.append(" AND PG_SIGLA_REA = :siglaRea");
			sql.append(" AND PG_NUMERO_REA = :numeroRea");
			paramMap.addValue("siglaRea", input.getIdReaSigla(), java.sql.Types.VARCHAR);
			paramMap.addValue("numeroRea", input.getNumeroRea(), java.sql.Types.NUMERIC);

			log.debug("#### STO SETTANDO: " + sql);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceFiscale())) {
			sql.append(" AND PG_CODICE_FISCALE = :codiceFiscale");
			paramMap.addValue("codiceFiscale", input.getCodiceFiscale(), java.sql.Types.VARCHAR);
		}

		//manca la gestione dei ruoli.....................

		if (GenericUtil.isNotNullOrEmpty(input.getDescrizioneRuoloFunzionale())) {
			if (Constants.RUOLO_RESPONSABILE_IMPRESA.equalsIgnoreCase(input.getDescrizioneRuoloFunzionale())
					|| Constants.RUOLO_RESPONSABILE.equalsIgnoreCase(input.getDescrizioneRuoloFunzionale())
					|| Constants.RUOLO_3RESPONSABILE.equalsIgnoreCase(input.getDescrizioneRuoloFunzionale())) {
				if (!"".equals(codiciImpianto)) {
					sql.append(" AND CODICE_IMPIANTO IN (" + codiciImpianto + ") ");
				}
			}
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceImpianto())) {
			sql.append(" AND CODICE_IMPIANTO = :codImpianto");
			paramMap.addValue("codImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);
		}

		sql.append(" ORDER BY DATA_CONTROLLO DESC, ID_ALLEGATO DESC ");
		sql.append(" LIMIT (SELECT VALORE_CONFIG_NUM FROM SIGIT_WRK_CONFIG WHERE CHIAVE_CONFIG='MAX_RIGHE') ");

		/*PROTECTED REGION END*/
		List<SigitVRicercaAllegatiStoricoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFiltriUtenteRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiStoricoDaoImpl::findByFiltriUtente] esecuzione query", ex);
			throw new SigitVRicercaAllegatiStoricoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiStoricoDaoImpl", "findByFiltriUtente", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVRicercaAllegatiStoricoDaoImpl::findByFiltriUtente] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiStoricoDto> findByIdAllegato(java.lang.String input)
			throws SigitVRicercaAllegatiStoricoDaoException {
		LOG.debug("[SigitVRicercaAllegatiStoricoDaoImpl::findByIdAllegato] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_IMP_RUOLO_PFPG,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI_STORICO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R2006263904) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("ID_ALLEGATO = :idAllegato");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1349764638) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idAllegato", ConvertUtil.convertToInteger(input));

		/*PROTECTED REGION END*/
		List<SigitVRicercaAllegatiStoricoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAllegatoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiStoricoDaoImpl::findByIdAllegato] esecuzione query", ex);
			throw new SigitVRicercaAllegatiStoricoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiStoricoDaoImpl", "findByIdAllegato", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVRicercaAllegatiStoricoDaoImpl::findByIdAllegato] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder inviatiByCodImpiantoOrderedByData
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiStoricoDto> findInviatiByCodImpiantoOrderedByData(Integer input)
			throws SigitVRicercaAllegatiStoricoDaoException {
		LOG.debug("[SigitVRicercaAllegatiStoricoDaoImpl::findInviatiByCodImpiantoOrderedByData] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_IMP_RUOLO_PFPG,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI_STORICO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1621618707) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND FK_STATO_RAPP = '" + Constants.ID_STATO_RAPPORTO_INVIATO + "'");
		/*PROTECTED REGION END*/

		sql.append(" ORDER BY DATA_CONTROLLO DESC"); /*PROTECTED REGION ID(R-2144975883) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVRicercaAllegatiStoricoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, inviatiByCodImpiantoOrderedByDataRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiStoricoDaoImpl::findInviatiByCodImpiantoOrderedByData] esecuzione query",
					ex);
			throw new SigitVRicercaAllegatiStoricoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiStoricoDaoImpl", "findInviatiByCodImpiantoOrderedByData",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitVRicercaAllegatiStoricoDaoImpl::findInviatiByCodImpiantoOrderedByData] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder manutByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiStoricoDto> findManutByCodImpianto(Integer input)
			throws SigitVRicercaAllegatiStoricoDaoException {
		LOG.debug("[SigitVRicercaAllegatiStoricoDaoImpl::findManutByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_IMP_RUOLO_PFPG,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI_STORICO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1400309054) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		sql.append(" CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND ID_TIPO_MANUTENZIONE <> 0"); //tutto cio' che non e' manutenzione, appare nella ricerca allegati con id_tipo_manutenzione = 0
		sql.append(" AND ((FK_TIPO_DOCUMENTO IN (" + Constants.ALLEGATO_TIPO_1 + "," + Constants.ALLEGATO_TIPO_1B + ","
				+ Constants.ALLEGATO_TIPO_2 + "," + Constants.ALLEGATO_TIPO_3 + "," + Constants.ALLEGATO_TIPO_4
				+ ") AND FK_STATO_RAPP = '" + Constants.ID_STATO_RAPPORTO_INVIATO + "')");

		sql.append(" OR FK_TIPO_DOCUMENTO IN (" + Constants.MANUTENZIONE_GT + "," + Constants.MANUTENZIONE_GF + ","
				+ Constants.MANUTENZIONE_SC + "," + Constants.MANUTENZIONE_CG + ")) ");

		/*PROTECTED REGION END*/

		sql.append(" ORDER BY DATA_CONTROLLO DESC"); /*PROTECTED REGION ID(R420656064) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVRicercaAllegatiStoricoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, manutByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiStoricoDaoImpl::findManutByCodImpianto] esecuzione query", ex);
			throw new SigitVRicercaAllegatiStoricoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiStoricoDaoImpl", "findManutByCodImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVRicercaAllegatiStoricoDaoImpl::findManutByCodImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder reeByCodImpiantoOrderedByData
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiStoricoDto> findReeByCodImpiantoOrderedByData(Integer input)
			throws SigitVRicercaAllegatiStoricoDaoException {
		LOG.debug("[SigitVRicercaAllegatiStoricoDaoImpl::findReeByCodImpiantoOrderedByData] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_IMP_RUOLO_PFPG,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI_STORICO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R508042241) ENABLED START*/
		sql.append(" CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND FK_TIPO_DOCUMENTO IN (" + Constants.ALLEGATO_TIPO_1 + "," + Constants.ALLEGATO_TIPO_1B + ","
				+ Constants.ALLEGATO_TIPO_2 + "," + Constants.ALLEGATO_TIPO_3 + "," + Constants.ALLEGATO_TIPO_4 + ") ");

		sql.append(" AND FK_STATO_RAPP = '" + Constants.ID_STATO_RAPPORTO_INVIATO + "'");
		/*PROTECTED REGION END*/

		sql.append(" ORDER BY DATA_CONTROLLO DESC"); /*PROTECTED REGION ID(R-549995935) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVRicercaAllegatiStoricoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, reeByCodImpiantoOrderedByDataRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiStoricoDaoImpl::findReeByCodImpiantoOrderedByData] esecuzione query", ex);
			throw new SigitVRicercaAllegatiStoricoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiStoricoDaoImpl", "findReeByCodImpiantoOrderedByData",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitVRicercaAllegatiStoricoDaoImpl::findReeByCodImpiantoOrderedByData] END");
		}
		return list;
	}

}
