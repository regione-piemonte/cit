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

/*PROTECTED REGION ID(R880933391) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.Constants;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVRicercaAllegati.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - byCodiceImpianto (datagen::CustomFinder)
 *   - byFiltriUtente (datagen::CustomFinder)
 *   - byIdAllegato (datagen::CustomFinder)
 *   - inviatiByCodImpiantoOrderedByData (datagen::CustomFinder)
 *   - manutByCodImpianto (datagen::CustomFinder)
 *   - reeByCodImpiantoOrderedByData (datagen::CustomFinder)
 *   - byCodiceImpiantoCountVerifiche (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitVRicercaAllegatiDaoImpl extends AbstractDAO implements SigitVRicercaAllegatiDao {
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

	protected SigitVRicercaAllegatiDaoRowMapper findAllRowMapper = new SigitVRicercaAllegatiDaoRowMapper(null,
			SigitVRicercaAllegatiDto.class, this);

	protected SigitVRicercaAllegatiDaoRowMapper byCodiceImpiantoRowMapper = new SigitVRicercaAllegatiDaoRowMapper(null,
			SigitVRicercaAllegatiDto.class, this);

	protected SigitVRicercaAllegatiDaoRowMapper byFiltriUtenteRowMapper = new SigitVRicercaAllegatiDaoRowMapper(null,
			SigitVRicercaAllegatiDto.class, this);

	protected SigitVRicercaAllegatiDaoRowMapper byIdAllegatoRowMapper = new SigitVRicercaAllegatiDaoRowMapper(null,
			SigitVRicercaAllegatiDto.class, this);

	protected SigitVRicercaAllegatiDaoRowMapper inviatiByCodImpiantoOrderedByDataRowMapper = new SigitVRicercaAllegatiDaoRowMapper(
			null, SigitVRicercaAllegatiDto.class, this);

	protected SigitVRicercaAllegatiDaoRowMapper manutByCodImpiantoRowMapper = new SigitVRicercaAllegatiDaoRowMapper(
			null, SigitVRicercaAllegatiDto.class, this);

	protected SigitVRicercaAllegatiDaoRowMapper reeByCodImpiantoOrderedByDataRowMapper = new SigitVRicercaAllegatiDaoRowMapper(
			null, SigitVRicercaAllegatiDto.class, this);

	protected SigitVRicercaAllegatiDaoRowMapper byCodiceImpiantoCountVerificheRowMapper = new SigitVRicercaAllegatiDaoRowMapper(
			null, SigitVRicercaAllegatiByCodiceImpiantoCountVerificheDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_RICERCA_ALLEGATI";
	}

	/** 
	 * Restituisce tutte le righe della tabella VISTA_RICERCA_ALLEGATI.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findAll() throws SigitVRicercaAllegatiDaoException {
		LOG.debug("[SigitVRicercaAllegatiDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_ISPEZ_ISPET,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitVRicercaAllegatiDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitVRicercaAllegatiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitVRicercaAllegatiDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findByCodiceImpianto(java.lang.String input)
			throws SigitVRicercaAllegatiDaoException {
		LOG.debug("[SigitVRicercaAllegatiDaoImpl::findByCodiceImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_ISPEZ_ISPET,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R236060563) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_IMPIANTO = :codiceImpianto");
		sql.append(" AND FK_TIPO_DOCUMENTO IN (" + Constants.ALLEGATO_TIPO_1 + "," + Constants.ALLEGATO_TIPO_1B + ","
				+ Constants.ALLEGATO_TIPO_2 + "," + Constants.ALLEGATO_TIPO_3 + "," + Constants.ALLEGATO_TIPO_4 + ","
				+ Constants.ALLEGATO_G + "," + Constants.ALLEGATO_F + ") ");

		sql.append(" ORDER BY DATA_CONTROLLO DESC, ID_ALLEGATO DESC ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-391493361) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codiceImpianto", ConvertUtil.convertToInteger(input));

		/*PROTECTED REGION END*/
		List<SigitVRicercaAllegatiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiDaoImpl::findByCodiceImpianto] esecuzione query", ex);
			throw new SigitVRicercaAllegatiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiDaoImpl", "findByCodiceImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVRicercaAllegatiDaoImpl::findByCodiceImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byFiltriUtente
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findByFiltriUtente(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaAllegati input)
			throws SigitVRicercaAllegatiDaoException {
		LOG.debug("[SigitVRicercaAllegatiDaoImpl::findByFiltriUtente] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_ISPEZ_ISPET,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1253695754) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("1 = 1 ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R670701068) ENABLED START*/
		//***aggiungere tutte le condizioni

		//Recupero la lista dei codici impianto da mettere dentro la in della query per tipologia di utente
		String codiciImpianto = "";
		if (input.getElencoCodiciImpianto() != null && input.getElencoCodiciImpianto().size() > 0) {
			for (String str : input.getElencoCodiciImpianto()) {
				codiciImpianto += str + ",";
			}
			log.debug("FRAAAAAAAAAAAAAAA --> codiciImpianto: [" + codiciImpianto + "]");

			codiciImpianto = codiciImpianto.substring(0, (codiciImpianto.length() - 1));
		}

		log.debug(" ----> FRAAAAA lista codici impianto: [" + codiciImpianto + "]");

		//		sql.append(" AND FK_TIPO_DOCUMENTO IN (" + Constants.ALLEGATO_TIPO_1 + "," + Constants.ALLEGATO_TIPO_2 + ","
		//				+ Constants.ALLEGATO_TIPO_3 + "," + Constants.ALLEGATO_TIPO_4 + ") ");

		if (GenericUtil.isNotNullOrEmpty(input.getIdStatoAllegato())) {
			sql.append(" AND FK_STATO_RAPP = :idStatoAllegato");
			paramMap.addValue("idStatoAllegato", input.getIdStatoAllegato(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoDocumento())) {
			sql.append(" AND FK_TIPO_DOCUMENTO = :idTipoDocumento");
			paramMap.addValue("idTipoDocumento", input.getIdTipoDocumento(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIstatAbilitazione())) {
			if (input.getIstatAbilitazione().length() == 8) {
				sql.append(" AND COMUNE_IMPIANTO = :comuneImpianto");
				paramMap.addValue("comuneImpianto", input.getComuneImpianto(), java.sql.Types.VARCHAR);
			} else if (input.getIstatAbilitazione().length() == 5) {
				sql.append(" AND SIGLA_PROV_IMPIANTO = :siglaProvinciaImp");
				paramMap.addValue("siglaProvinciaImp", input.getSiglaProvImpianto(), java.sql.Types.VARCHAR);
			} else {
				//DO NOTHING
			}
		}

		//le date possono essere valorizzate singolarmente e non per forza a coppia
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

		//		if (GenericUtil.isNotNullOrEmpty(input.getImpiantiNonFunzionanti())) {
		//			log.debug("FLAG PUO' FUNZIONARE --> "
		//					+ input.getImpiantiNonFunzionanti());
		//			//� un numerico sul db (1,0)
		//			sql.append(" AND F_FLG_PUO_FUNZIONARE = :flgPuoFunzionare");
		//			if (Constants.TRUE.equalsIgnoreCase(input
		//					.getImpiantiNonFunzionanti()))
		//				paramMap.addValue("flgPuoFunzionare",
		//						Constants.PUO_FUNZIONARE_TRUE, java.sql.Types.NUMERIC);
		//			else
		//				paramMap.addValue("flgPuoFunzionare",
		//						Constants.PUO_FUNZIONARE_FALSE, java.sql.Types.NUMERIC);
		//		}

		/*
		if (GenericUtil.isNotNullOrEmpty(input.getImpiantiNonFunzionanti())
				&& Constants.TRUE.equalsIgnoreCase(input
						.getImpiantiNonFunzionanti())) {
		
			log.debug("FLAG PUO' FUNZIONARE --> "
					+ input.getImpiantiNonFunzionanti());
			//� un numerico sul db (1,0)
			sql.append(" AND F_FLG_PUO_FUNZIONARE = :flgPuoFunzionare");
		
			paramMap.addValue("flgPuoFunzionare",
					Constants.PUO_FUNZIONARE_FALSE, java.sql.Types.NUMERIC);
		
		}
		 */

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
					|| Constants.RUOLO_PROPRIETARIO_IMPRESA.equalsIgnoreCase(input.getDescrizioneRuoloFunzionale())
					|| Constants.RUOLO_PROPRIETARIO.equalsIgnoreCase(input.getDescrizioneRuoloFunzionale())
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
		List<SigitVRicercaAllegatiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFiltriUtenteRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiDaoImpl::findByFiltriUtente] esecuzione query", ex);
			throw new SigitVRicercaAllegatiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiDaoImpl", "findByFiltriUtente", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVRicercaAllegatiDaoImpl::findByFiltriUtente] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findByIdAllegato(java.lang.String input)
			throws SigitVRicercaAllegatiDaoException {
		LOG.debug("[SigitVRicercaAllegatiDaoImpl::findByIdAllegato] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_ISPEZ_ISPET,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-503521585) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("ID_ALLEGATO = :idAllegato");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1843703469) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idAllegato", ConvertUtil.convertToInteger(input));

		/*PROTECTED REGION END*/
		List<SigitVRicercaAllegatiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAllegatoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiDaoImpl::findByIdAllegato] esecuzione query", ex);
			throw new SigitVRicercaAllegatiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiDaoImpl", "findByIdAllegato", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVRicercaAllegatiDaoImpl::findByIdAllegato] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder inviatiByCodImpiantoOrderedByData
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findInviatiByCodImpiantoOrderedByData(Integer input)
			throws SigitVRicercaAllegatiDaoException {
		LOG.debug("[SigitVRicercaAllegatiDaoImpl::findInviatiByCodImpiantoOrderedByData] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_ISPEZ_ISPET,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-235272994) ENABLED START*/

		// METODO NON USATO - nel caso verificarlo

		sql.append(" CODICE_IMPIANTO = :codImpianto");

		//		sql.append(" AND FK_TIPO_DOCUMENTO IN (" + Constants.ALLEGATO_TIPO_1 + "," + Constants.ALLEGATO_TIPO_2 + ","
		//				+ Constants.ALLEGATO_TIPO_3 + "," + Constants.ALLEGATO_TIPO_4 + "," + Constants.MANUTENZIONE_GT + ","
		//				+ Constants.MANUTENZIONE_GF + "," + Constants.MANUTENZIONE_SC + "," + Constants.MANUTENZIONE_CG + ") ");

		sql.append(" AND FK_STATO_RAPP = '" + Constants.ID_STATO_RAPPORTO_INVIATO + "'");

		/*PROTECTED REGION END*/

		sql.append(" ORDER BY DATA_CONTROLLO DESC"); /*PROTECTED REGION ID(R-2117931740) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVRicercaAllegatiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, inviatiByCodImpiantoOrderedByDataRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiDaoImpl::findInviatiByCodImpiantoOrderedByData] esecuzione query", ex);
			throw new SigitVRicercaAllegatiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiDaoImpl", "findInviatiByCodImpiantoOrderedByData",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitVRicercaAllegatiDaoImpl::findInviatiByCodImpiantoOrderedByData] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder manutByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findManutByCodImpianto(Integer input)
			throws SigitVRicercaAllegatiDaoException {
		LOG.debug("[SigitVRicercaAllegatiDaoImpl::findManutByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_ISPEZ_ISPET,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R195289585) ENABLED START*/

		sql.append(" CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND ID_TIPO_MANUTENZIONE <> 0"); //tutto cio' che non e' manutenzione, appare nella ricerca allegati con id_tipo_manutenzione = 0
		sql.append(" AND ((FK_TIPO_DOCUMENTO IN (" + Constants.ALLEGATO_TIPO_1 + "," + Constants.ALLEGATO_TIPO_1B + ","
				+ Constants.ALLEGATO_TIPO_2 + "," + Constants.ALLEGATO_TIPO_3 + "," + Constants.ALLEGATO_TIPO_4
				+ ") AND FK_STATO_RAPP = '" + Constants.ID_STATO_RAPPORTO_INVIATO + "')");

		sql.append(" OR FK_TIPO_DOCUMENTO IN (" + Constants.MANUTENZIONE_GT + "," + Constants.MANUTENZIONE_GF + ","
				+ Constants.MANUTENZIONE_SC + "," + Constants.MANUTENZIONE_CG + ")) ");

		/*PROTECTED REGION END*/

		sql.append(" ORDER BY DATA_CONTROLLO DESC"); /*PROTECTED REGION ID(R-1655393679) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVRicercaAllegatiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, manutByCodImpiantoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiDaoImpl::findManutByCodImpianto] esecuzione query", ex);
			throw new SigitVRicercaAllegatiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiDaoImpl", "findManutByCodImpianto", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitVRicercaAllegatiDaoImpl::findManutByCodImpianto] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder reeByCodImpiantoOrderedByData
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findReeByCodImpiantoOrderedByData(Integer input)
			throws SigitVRicercaAllegatiDaoException {
		LOG.debug("[SigitVRicercaAllegatiDaoImpl::findReeByCodImpiantoOrderedByData] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_ISPEZ_ISPET,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-524013198) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND FK_TIPO_DOCUMENTO IN (" + Constants.ALLEGATO_TIPO_1 + "," + Constants.ALLEGATO_TIPO_1B + ","
				+ Constants.ALLEGATO_TIPO_2 + "," + Constants.ALLEGATO_TIPO_3 + "," + Constants.ALLEGATO_TIPO_4 + ") ");

		sql.append(" AND FK_STATO_RAPP = '" + Constants.ID_STATO_RAPPORTO_INVIATO + "'");
		/*PROTECTED REGION END*/

		sql.append(" ORDER BY DATA_CONTROLLO DESC"); /*PROTECTED REGION ID(R1816023824) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codImpianto", input, java.sql.Types.NUMERIC);

		/*PROTECTED REGION END*/
		List<SigitVRicercaAllegatiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, reeByCodImpiantoOrderedByDataRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiDaoImpl::findReeByCodImpiantoOrderedByData] esecuzione query", ex);
			throw new SigitVRicercaAllegatiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiDaoImpl", "findReeByCodImpiantoOrderedByData",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitVRicercaAllegatiDaoImpl::findReeByCodImpiantoOrderedByData] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byCodiceImpiantoCountVerifiche con Qdef
		 * @generated
		 */

	public List<SigitVRicercaAllegatiByCodiceImpiantoCountVerificheDto> findByCodiceImpiantoCountVerifiche(
			java.lang.String input) throws SigitVRicercaAllegatiDaoException {
		LOG.debug("[SigitVRicercaAllegatiDaoImpl::findByCodiceImpiantoCountVerifiche] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT tRicercaAllegati.ID_ALLEGATO as idallegato, tRicercaAllegati.DATA_CONTROLLO as datacontrollo, tRicercaAllegati.DES_TIPO_DOCUMENTO as descdocumento, tRicercaAllegati.DES_STATO_RAPP as descstatorapp, tRicercaAllegati.F_OSSERVAZIONI as osservazioni, tRicercaAllegati.F_RACCOMANDAZIONI as raccomandazioni, tRicercaAllegati.F_PRESCRIZIONI as prescrizioni, tRicercaAllegati.F_INTERVENTO_ENTRO as interv, tRicercaAllegati.ELENCO_APPARECCHIATURE as elencoapp, (SELECT COUNT(*) FROM SIGIT_T_VERIFICA v WHERE v.FK_ALLEGATO = tRicercaAllegati.ID_ALLEGATO) AS num_verifiche");

		sql.append(" FROM VISTA_RICERCA_ALLEGATI tRicercaAllegati");

		sql.append(" WHERE ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R-1989752085) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" AND CODICE_IMPIANTO = :codiceImpianto");
		sql.append(" AND FK_TIPO_DOCUMENTO IN (" + Constants.ALLEGATO_TIPO_1 + "," + Constants.ALLEGATO_TIPO_1B + ","
				+ Constants.ALLEGATO_TIPO_2 + "," + Constants.ALLEGATO_TIPO_3 + "," + Constants.ALLEGATO_TIPO_4 + ","
				+ Constants.ALLEGATO_G + "," + Constants.ALLEGATO_F + ") ");

		sql.append(" ORDER BY DATA_CONTROLLO DESC, ID_ALLEGATO DESC ");

		paramMap.addValue("codiceImpianto", ConvertUtil.convertToInteger(input));

		/*PROTECTED REGION END*/

		List<SigitVRicercaAllegatiByCodiceImpiantoCountVerificheDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceImpiantoCountVerificheRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiDaoImpl::findByCodiceImpiantoCountVerifiche] ERROR esecuzione query", ex);
			throw new SigitVRicercaAllegatiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiDaoImpl", "findByCodiceImpiantoCountVerifiche",
					"esecuzione query", sql.toString());
			LOG.debug("[SigitVRicercaAllegatiDaoImpl::findByCodiceImpiantoCountVerifiche] END");
		}
		return list;
	}

}
