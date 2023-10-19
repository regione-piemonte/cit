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

/*PROTECTED REGION ID(R-98670481) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTDatoDistrib.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byIdImportDistrib (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 *   - byFkImportDistrib (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTDatoDistribDaoImpl extends AbstractDAO implements SigitTDatoDistribDao {
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
	 * Metodo di inserimento del DAO sigitTDatoDistrib. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDatoDistribPk
	 * @generated
	 */

	public SigitTDatoDistribPk insert(SigitTDatoDistribDto dto)

	{
		LOG.debug("[SigitTDatoDistribDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_DATO_DISTRIB,FK_TIPO_CONTRATTO,FK_IMPORT_DISTRIB,FK_CATEGORIA_UTIL,FK_COMBUSTIBILE,CODICE_ASSENZA_CATAST,FK_UNITA_MISURA,FLG_PF_PG,COGNOME_DENOM,NOME,CF_PIVA,ANNO_RIF,NR_MESI_FATTUR,DUG,INDIRIZZO,CIVICO,CAP,ISTAT_COMUNE,POD_PDR,CONSUMO_ANNO,CONSUMO_MENSILE,MESE_RIFERIMENTO,CONSUMO_GIORNALIERO,GIORNO_RIFERIMENTO,VOLUMETRIA,FLG_PF_PG_FATT,COGNOME_DENOM_FATT,NOME_FATT,CF_PIVA_FATT,DUG_FATT,INDIRIZZO_FATT,CIVICO_FATT,CAP_FATT,ISTAT_COMUNE_FATT ) VALUES (  :ID_DATO_DISTRIB , :FK_TIPO_CONTRATTO , :FK_IMPORT_DISTRIB , :FK_CATEGORIA_UTIL , :FK_COMBUSTIBILE , :CODICE_ASSENZA_CATAST , :FK_UNITA_MISURA , :FLG_PF_PG , :COGNOME_DENOM , :NOME , :CF_PIVA , :ANNO_RIF , :NR_MESI_FATTUR , :DUG , :INDIRIZZO , :CIVICO , :CAP , :ISTAT_COMUNE , :POD_PDR , :CONSUMO_ANNO , :CONSUMO_MENSILE , :MESE_RIFERIMENTO , :CONSUMO_GIORNALIERO , :GIORNO_RIFERIMENTO , :VOLUMETRIA , :FLG_PF_PG_FATT , :COGNOME_DENOM_FATT , :NOME_FATT , :CF_PIVA_FATT , :DUG_FATT , :INDIRIZZO_FATT , :CIVICO_FATT , :CAP_FATT , :ISTAT_COMUNE_FATT  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DATO_DISTRIB]
		params.addValue("ID_DATO_DISTRIB", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_CONTRATTO]
		params.addValue("FK_TIPO_CONTRATTO", dto.getFkTipoContratto(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_IMPORT_DISTRIB]
		params.addValue("FK_IMPORT_DISTRIB", dto.getFkImportDistrib(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_CATEGORIA_UTIL]
		params.addValue("FK_CATEGORIA_UTIL", dto.getFkCategoriaUtil(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_COMBUSTIBILE]
		params.addValue("FK_COMBUSTIBILE", dto.getFkCombustibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_ASSENZA_CATAST]
		params.addValue("CODICE_ASSENZA_CATAST", dto.getCodiceAssenzaCatast(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_UNITA_MISURA]
		params.addValue("FK_UNITA_MISURA", dto.getFkUnitaMisura(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_PF_PG]
		params.addValue("FLG_PF_PG", dto.getFlgPfPg(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COGNOME_DENOM]
		params.addValue("COGNOME_DENOM", dto.getCognomeDenom(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOME]
		params.addValue("NOME", dto.getNome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CF_PIVA]
		params.addValue("CF_PIVA", dto.getCfPiva(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ANNO_RIF]
		params.addValue("ANNO_RIF", dto.getAnnoRif(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [NR_MESI_FATTUR]
		params.addValue("NR_MESI_FATTUR", dto.getNrMesiFattur(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DUG]
		params.addValue("DUG", dto.getDug(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO]
		params.addValue("INDIRIZZO", dto.getIndirizzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO]
		params.addValue("CIVICO", dto.getCivico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP]
		params.addValue("CAP", dto.getCap(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE]
		params.addValue("ISTAT_COMUNE", dto.getIstatComune(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [POD_PDR]
		params.addValue("POD_PDR", dto.getPodPdr(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CONSUMO_ANNO]
		params.addValue("CONSUMO_ANNO", dto.getConsumoAnno(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CONSUMO_MENSILE]
		params.addValue("CONSUMO_MENSILE", dto.getConsumoMensile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MESE_RIFERIMENTO]
		params.addValue("MESE_RIFERIMENTO", dto.getMeseRiferimento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CONSUMO_GIORNALIERO]
		params.addValue("CONSUMO_GIORNALIERO", dto.getConsumoGiornaliero(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [GIORNO_RIFERIMENTO]
		params.addValue("GIORNO_RIFERIMENTO", dto.getGiornoRiferimento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [VOLUMETRIA]
		params.addValue("VOLUMETRIA", dto.getVolumetria(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_PF_PG_FATT]
		params.addValue("FLG_PF_PG_FATT", dto.getFlgPfPgFatt(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COGNOME_DENOM_FATT]
		params.addValue("COGNOME_DENOM_FATT", dto.getCognomeDenomFatt(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOME_FATT]
		params.addValue("NOME_FATT", dto.getNomeFatt(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CF_PIVA_FATT]
		params.addValue("CF_PIVA_FATT", dto.getCfPivaFatt(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DUG_FATT]
		params.addValue("DUG_FATT", dto.getDugFatt(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_FATT]
		params.addValue("INDIRIZZO_FATT", dto.getIndirizzoFatt(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO_FATT]
		params.addValue("CIVICO_FATT", dto.getCivicoFatt(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP_FATT]
		params.addValue("CAP_FATT", dto.getCapFatt(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE_FATT]
		params.addValue("ISTAT_COMUNE_FATT", dto.getIstatComuneFatt(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdDatoDistrib(newKey);
		LOG.debug("[SigitTDatoDistribDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Custom deleter in the SIGIT_T_DATO_DISTRIB table.
	 * @generated
	 */
	public void customDeleterByFkImportDistrib(java.lang.Integer filter) throws SigitTDatoDistribDaoException {
		LOG.debug("[SigitTDatoDistribDaoImpl::customDeleterByFkImportDistrib] START");
		/*PROTECTED REGION ID(R-751318407) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE " + "FK_IMPORT_DISTRIB = :fkImportDistrib";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("fkImportDistrib", filter);

		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTDatoDistribDaoImpl::customDeleterByFkImportDistrib] END");
	}

	protected SigitTDatoDistribDaoRowMapper findByPrimaryKeyRowMapper = new SigitTDatoDistribDaoRowMapper(null,
			SigitTDatoDistribDto.class, this);

	protected SigitTDatoDistribDaoRowMapper byIdImportDistribRowMapper = new SigitTDatoDistribDaoRowMapper(null,
			SigitTDatoDistribDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_DATO_DISTRIB";
	}

	/** 
	 * Returns all rows from the SIGIT_T_DATO_DISTRIB table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTDatoDistribDto findByPrimaryKey(SigitTDatoDistribPk pk) throws SigitTDatoDistribDaoException {
		LOG.debug("[SigitTDatoDistribDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_DATO_DISTRIB,FK_TIPO_CONTRATTO,FK_IMPORT_DISTRIB,FK_CATEGORIA_UTIL,FK_COMBUSTIBILE,CODICE_ASSENZA_CATAST,FK_UNITA_MISURA,FLG_PF_PG,COGNOME_DENOM,NOME,CF_PIVA,ANNO_RIF,NR_MESI_FATTUR,DUG,INDIRIZZO,CIVICO,CAP,ISTAT_COMUNE,POD_PDR,CONSUMO_ANNO,CONSUMO_MENSILE,MESE_RIFERIMENTO,CONSUMO_GIORNALIERO,GIORNO_RIFERIMENTO,VOLUMETRIA,FLG_PF_PG_FATT,COGNOME_DENOM_FATT,NOME_FATT,CF_PIVA_FATT,DUG_FATT,INDIRIZZO_FATT,CIVICO_FATT,CAP_FATT,ISTAT_COMUNE_FATT FROM "
						+ getTableName() + " WHERE ID_DATO_DISTRIB = :ID_DATO_DISTRIB ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DATO_DISTRIB]
		params.addValue("ID_DATO_DISTRIB", pk.getIdDatoDistrib(), java.sql.Types.INTEGER);

		List<SigitTDatoDistribDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTDatoDistribDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTDatoDistribDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDatoDistribDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTDatoDistribDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byIdImportDistrib
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDatoDistribDto> findByIdImportDistrib(Integer input) throws SigitTDatoDistribDaoException {
		LOG.debug("[SigitTDatoDistribDaoImpl::findByIdImportDistrib] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_DATO_DISTRIB,FK_TIPO_CONTRATTO,FK_IMPORT_DISTRIB,FK_CATEGORIA_UTIL,FK_COMBUSTIBILE,CODICE_ASSENZA_CATAST,FK_UNITA_MISURA,FLG_PF_PG,COGNOME_DENOM,NOME,CF_PIVA,ANNO_RIF,NR_MESI_FATTUR,DUG,INDIRIZZO,CIVICO,CAP,ISTAT_COMUNE,POD_PDR,CONSUMO_ANNO,CONSUMO_MENSILE,MESE_RIFERIMENTO,CONSUMO_GIORNALIERO,GIORNO_RIFERIMENTO,VOLUMETRIA,FLG_PF_PG_FATT,COGNOME_DENOM_FATT,NOME_FATT,CF_PIVA_FATT,DUG_FATT,INDIRIZZO_FATT,CIVICO_FATT,CAP_FATT,ISTAT_COMUNE_FATT ");
		sql.append(" FROM SIGIT_T_DATO_DISTRIB");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R435500353) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("FK_IMPORT_DISTRIB = :idImportDistrib");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1496172833) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idImportDistrib", input);

		/*PROTECTED REGION END*/
		List<SigitTDatoDistribDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdImportDistribRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTDatoDistribDaoImpl::findByIdImportDistrib] esecuzione query", ex);
			throw new SigitTDatoDistribDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTDatoDistribDaoImpl", "findByIdImportDistrib", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTDatoDistribDaoImpl::findByIdImportDistrib] END");
		}
		return list;
	}

}
