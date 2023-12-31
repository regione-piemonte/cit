package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitVRicercaAllegatiDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitVRicercaAllegatiDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitVRicercaAllegatiDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.sigit.sigitext.business.util.ConvertUtil;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R1679301379) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitVRicercaAllegati.
 * Il DAO implementa le seguenti operazioni:
 * - FINDERS:
 * - inviatiByCodImpiantoOrderedByData (datagen::CustomFinder)
 * - manutByCodImpianto (datagen::CustomFinder)
 * - UPDATERS:
 * <p>
 * --
 * - DELETERS:
 * <p>
 * --
 * <p>
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 *
 * @generated
 */
public class SigitVRicercaAllegatiDaoImpl extends AbstractDAO implements SigitVRicercaAllegatiDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	/**
	 * Il DAO utilizza JDBC template per l'implementazione delle query.
	 *
	 * @generated
	 */
	protected NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 *
	 * @generated
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	protected SigitVRicercaAllegatiDaoRowMapper inviatiByCodImpiantoOrderedByDataRowMapper = new SigitVRicercaAllegatiDaoRowMapper(null, SigitVRicercaAllegatiDto.class, this);

	protected SigitVRicercaAllegatiDaoRowMapper manutByCodImpiantoRowMapper = new SigitVRicercaAllegatiDaoRowMapper(null, SigitVRicercaAllegatiDto.class, this);

	protected SigitVRicercaAllegatiDaoRowMapper byIdAllegatoRowMapper = new SigitVRicercaAllegatiDaoRowMapper(null, SigitVRicercaAllegatiDto.class, this);

	/**
	 * Restituisce il nome della tabella su cui opera il DAO
	 *
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "VISTA_RICERCA_ALLEGATI";
	}

	/**
	 * Implementazione del finder inviatiByCodImpiantoOrderedByData
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findInviatiByCodImpiantoOrderedByData(Integer input) throws SigitVRicercaAllegatiDaoException {
		LOG.debug("[SigitVRicercaAllegatiDaoImpl::findInviatiByCodImpiantoOrderedByData] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_ISPEZ_ISPET,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1539449480) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND FK_STATO_RAPP = '" + Constants.ID_STATO_RAPPORTO_INVIATO + "'");
		sql.append(" AND FK_TIPO_DOCUMENTO IN (" + Constants.ALLEGATO_TIPO_1 + "," + Constants.ALLEGATO_TIPO_1B + "," + Constants.ALLEGATO_TIPO_2 + "," + Constants.ALLEGATO_TIPO_3 + ","
				+ Constants.ALLEGATO_TIPO_4 + ") ");

		/*PROTECTED REGION END*/

		sql.append(" ORDER BY DATA_CONTROLLO DESC"); /*PROTECTED REGION ID(R-353407374) ENABLED START*/
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
			stopWatch.dumpElapsed("SigitVRicercaAllegatiDaoImpl", "findInviatiByCodImpiantoOrderedByData", "esecuzione query", sql.toString());
			LOG.debug("[SigitVRicercaAllegatiDaoImpl::findInviatiByCodImpiantoOrderedByData] END");
		}
		return list;
	}

	/**
	 * Implementazione del finder manutByCodImpianto
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findManutByCodImpianto(Integer input) throws SigitVRicercaAllegatiDaoException {
		LOG.debug("[SigitVRicercaAllegatiDaoImpl::findManutByCodImpianto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_ISPEZ_ISPET,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1214615803) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" CODICE_IMPIANTO = :codImpianto");

		sql.append(" AND ((FK_TIPO_DOCUMENTO IN (" + Constants.ALLEGATO_TIPO_1 + "," + Constants.ALLEGATO_TIPO_1B + "," + Constants.ALLEGATO_TIPO_2 + "," + Constants.ALLEGATO_TIPO_3 + ","
				+ Constants.ALLEGATO_TIPO_4 + ") AND FK_STATO_RAPP = '" + Constants.ID_STATO_RAPPORTO_INVIATO + "')");

		sql.append(" OR FK_TIPO_DOCUMENTO IN (" + Constants.MANUTENZIONE_GT + "," + Constants.MANUTENZIONE_GF + "," + Constants.MANUTENZIONE_SC + "," + Constants.MANUTENZIONE_CG + ")) ");

		sql.append(" AND FK_STATO_RAPP = '" + Constants.ID_STATO_RAPPORTO_INVIATO + "'");
		//sql.append(" AND FK_TIPO_DOCUMENTO IN ("+Constants.MANUTENZIONE_GT+","+Constants.MANUTENZIONE_GF+","+Constants.MANUTENZIONE_SC+","+Constants.MANUTENZIONE_CG+") ");

		/*PROTECTED REGION END*/

		sql.append(" ORDER BY DATA_CONTROLLO DESC"); /*PROTECTED REGION ID(R1126502021) ENABLED START*/
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
			stopWatch.dumpElapsed("SigitVRicercaAllegatiDaoImpl", "findManutByCodImpianto", "esecuzione query", sql.toString());
			LOG.debug("[SigitVRicercaAllegatiDaoImpl::findManutByCodImpianto] END");
		}
		return list;
	}

	@Override
	public List<SigitVRicercaAllegatiDto> findControlliByCodImpiantoOrdered(Integer input, String ordinamento, Integer limit) throws SigitVRicercaAllegatiDaoException {
		LOG.debug("[SigitVRicercaAllegatiDaoImpl::findControlliByCodImpiantoOrdered] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_ISPEZ_ISPET,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI");
		sql.append(" WHERE ");
		sql.append(" CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND FK_TIPO_DOCUMENTO IN (" + Constants.ALLEGATO_TIPO_1 + "," + Constants.ALLEGATO_TIPO_1B + "," + Constants.ALLEGATO_TIPO_2 + "," + Constants.ALLEGATO_TIPO_3 + ","
				+ Constants.ALLEGATO_TIPO_4 + "," + Constants.MANUTENZIONE_CG + "," + Constants.MANUTENZIONE_GT + "," + Constants.MANUTENZIONE_GF + "," + Constants.MANUTENZIONE_SC + ") ");

		sql.append(" ORDER BY ").append(ordinamento);
		if (limit != null)
			sql.append(" LIMIT ").append(limit);

		paramMap.addValue("codImpianto", input);

		List<SigitVRicercaAllegatiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, inviatiByCodImpiantoOrderedByDataRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiDaoImpl::findControlliByCodImpiantoOrdered] esecuzione query", ex);
			throw new SigitVRicercaAllegatiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiDaoImpl", "findControlliByCodImpiantoOrdered", "esecuzione query", sql.toString());
			LOG.debug("[SigitVRicercaAllegatiDaoImpl::findControlliByCodImpiantoOrdered] END");
		}
		return list;
	}

	public List<SigitVRicercaAllegatiDto> findByIdAllegato(java.lang.String input) throws SigitVRicercaAllegatiDaoException {
		LOG.debug("[SigitVRicercaAllegatiDaoImpl::findByIdAllegato] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		sql.append("SELECT ID_ALLEGATO,FK_STATO_RAPP,FK_ISPEZ_ISPET,FK_TIPO_DOCUMENTO,FK_SIGLA_BOLLINO,FK_NUMERO_BOLLINO,DATA_CONTROLLO,B_FLG_LIBRETTO_USO,B_FLG_DICHIAR_CONFORM,B_FLG_LIB_IMP,B_FLG_LIB_COMPL,F_OSSERVAZIONI,F_RACCOMANDAZIONI,F_PRESCRIZIONI,F_FLG_PUO_FUNZIONARE,F_INTERVENTO_ENTRO,F_ORA_ARRIVO,F_ORA_PARTENZA,F_DENOMINAZ_TECNICO,F_FLG_FIRMA_TECNICO,F_FLG_FIRMA_RESPONSABILE,DATA_INVIO,DATA_RESPINTA,NOME_ALLEGATO,DATA_ULT_MOD,UTENTE_ULT_MOD,DES_RUOLO,RUOLO_FUNZ,ID_PERSONA_GIURIDICA,PG_DENOMINAZIONE,PG_CODICE_FISCALE,PG_SIGLA_REA,PG_NUMERO_REA,CODICE_IMPIANTO,COMUNE_IMPIANTO,SIGLA_PROV_IMPIANTO,INDIRIZZO_UNITA_IMMOB,CIVICO_UNITA_IMMOB,DES_TIPO_DOCUMENTO,DES_STATO_RAPP,FLG_CONTROLLO_BOZZA,UID_INDEX,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO,ELENCO_COMBUSTIBILI,ELENCO_APPARECCHIATURE,FK_PG_CAT,PG_FK_STATO_PG,ID_TIPO_MANUTENZIONE,DES_TIPO_MANUTENZIONE,ALTRO_DESCR,UID_INDEX_FIRMATO,NOME_ALLEGATO_FIRMATO ");
		sql.append(" FROM VISTA_RICERCA_ALLEGATI");
		sql.append(" WHERE ");
		sql.append("ID_ALLEGATO = :idAllegato");
		paramMap.addValue("idAllegato", ConvertUtil.convertToInteger(input));
		List<SigitVRicercaAllegatiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAllegatoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitVRicercaAllegatiDaoImpl::findByIdAllegato] esecuzione query", ex);
			throw new SigitVRicercaAllegatiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitVRicercaAllegatiDaoImpl", "findByIdAllegato", "esecuzione query", sql.toString());
			LOG.debug("[SigitVRicercaAllegatiDaoImpl::findByIdAllegato] END");
		}
		return list;
	}
}
