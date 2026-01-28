package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitRPfRuoloPaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitRPfRuoloPaDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfRuoloPaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfRuoloPaFindByPfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfRuoloPaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRPfRuoloPaDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.sigit.sigitext.dto.Assegnatario;
import it.csi.util.performance.StopWatch;

/*PROTECTED REGION ID(R1606297155) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRPfRuoloPa.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPf (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitRPfRuoloPaDaoImpl extends AbstractDAO implements SigitRPfRuoloPaDao {
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
	 * Metodo di inserimento del DAO sigitRPfRuoloPa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRPfRuoloPaPk
	 * @generated
	 */

	public SigitRPfRuoloPaPk insert(SigitRPfRuoloPaDto dto)

	{
		LOG.debug("[SigitRPfRuoloPaDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PERSONA_FISICA,ID_RUOLO_PA,ISTAT_ABILITAZIONE,DATA_INIZIO,DATA_FINE,NOTE,DESC_ABILITAZIONE ) VALUES (  :ID_PERSONA_FISICA , :ID_RUOLO_PA , :ISTAT_ABILITAZIONE , :DATA_INIZIO , :DATA_FINE , :NOTE , :DESC_ABILITAZIONE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA_FISICA]
		params.addValue("ID_PERSONA_FISICA", dto.getIdPersonaFisica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_RUOLO_PA]
		params.addValue("ID_RUOLO_PA", dto.getIdRuoloPa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ISTAT_ABILITAZIONE]
		params.addValue("ISTAT_ABILITAZIONE", dto.getIstatAbilitazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DESC_ABILITAZIONE]
		params.addValue("DESC_ABILITAZIONE", dto.getDescAbilitazione(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitRPfRuoloPaDaoImpl::insert] END");
		return dto.createPk();

	}

	protected SigitRPfRuoloPaDaoRowMapper findByPfRowMapper = new SigitRPfRuoloPaDaoRowMapper(null,
			SigitRPfRuoloPaFindByPfDto.class, this);

	protected SigitRPfRuoloPaDaoRowMapper allByIstatValidatoreRowMapper = new SigitRPfRuoloPaDaoRowMapper(
			new String[]{"DESC_ABILITAZIONE"}, SigitRPfRuoloPaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_PF_RUOLO_PA";
	}

	/** 
		 * Implementazione del finder findByPf con Qdef
		 * @generated
		 */

	public List<SigitRPfRuoloPaFindByPfDto> findFindByPf(Integer input) throws SigitRPfRuoloPaDaoException {
		LOG.debug("[SigitRPfRuoloPaDaoImpl::findFindByPf] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT rPfRuoloPa.ID_RUOLO_PA, dRuoloPa.DES_RUOLO_PA, rPfRuoloPa.ISTAT_ABILITAZIONE, rPfRuoloPa.DESC_ABILITAZIONE");

		sql.append(" FROM SIGIT_D_RUOLO_PA dRuoloPa, SIGIT_R_PF_RUOLO_PA rPfRuoloPa");

		sql.append(" WHERE ");

		sql.append("dRuoloPa.ID_RUOLO_PA = rPfRuoloPa.ID_RUOLO_PA");

		sql.append(" AND ");

		sql.append("rPfRuoloPa.id_persona_fisica=:idPersonaFisica");

		List<SigitRPfRuoloPaFindByPfDto> list = null;

		paramMap.addValue("idPersonaFisica",input);
		
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByPfRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfRuoloPaDaoImpl::findFindByPf] ERROR esecuzione query", ex);
			throw new SigitRPfRuoloPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfRuoloPaDaoImpl", "findFindByPf", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPfRuoloPaDaoImpl::findFindByPf] END");
		}
		return list;
	}
	
	public List<Assegnatario> findAllAssegnatario() throws SigitRPfRuoloPaDaoException {
		LOG.debug("[SigitRPfRuoloPaDaoImpl::findAllAssegnatario] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT distinct rPfRuoloPa.ID_RUOLO_PA, rPfRuoloPa.id_persona_fisica,tpf.nome , tpf.cognome , tpf.codice_fiscale , dRuoloPa.DES_RUOLO_PA, rPfRuoloPa.ISTAT_ABILITAZIONE");

		sql.append(" FROM SIGIT_R_PF_RUOLO_PA rPfRuoloPa, SIGIT_D_RUOLO_PA dRuoloPa, sigit_t_persona_fisica tpf");

		sql.append(" WHERE ");

		sql.append("dRuoloPa.ID_RUOLO_PA = rPfRuoloPa.ID_RUOLO_PA");

		sql.append(" AND ");

		sql.append("tpf.id_persona_fisica = rPfRuoloPa.id_persona_fisica ");				
		
		sql.append(" AND rPfRuoloPa.id_ruolo_pa in (2,4) ");

		List<Assegnatario> list = null;		
		
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, new RowMapper<Assegnatario>() {

				@Override
				public Assegnatario mapRow(ResultSet rs, int arg1) throws SQLException {
				
					Assegnatario assegnatario = new Assegnatario();
					assegnatario.setCodicefiscale(rs.getString("codice_fiscale"));
					assegnatario.setCognome(rs.getString("cognome"));
					assegnatario.setDesRuoloPa(rs.getString("DES_RUOLO_PA"));
					assegnatario.setIdPersonaFisica(rs.getInt("id_persona_fisica"));
					assegnatario.setIdRuoloPa(rs.getInt("ID_RUOLO_PA"));
					assegnatario.setIstatAbilitazione(rs.getString("ISTAT_ABILITAZIONE"));
					assegnatario.setNome(rs.getString("nome"));
					return assegnatario;
				}
				
			});
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfRuoloPaDaoImpl::findAllAssegnatario] ERROR esecuzione query", ex);
			throw new SigitRPfRuoloPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfRuoloPaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPfRuoloPaDaoImpl::findAllAssegnatario] END");
		}
		return list;
	}
	
	public List<Assegnatario> findAllIspettori() throws SigitRPfRuoloPaDaoException {
		LOG.debug("[SigitRPfRuoloPaDaoImpl::findAllIspettori] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT distinct rPfRuoloPa.ID_RUOLO_PA, rPfRuoloPa.id_persona_fisica,tpf.nome , tpf.cognome , tpf.codice_fiscale , dRuoloPa.DES_RUOLO_PA, rPfRuoloPa.ISTAT_ABILITAZIONE, "
				+ "rPfRuoloPa.DATA_FINE");

		sql.append(" FROM SIGIT_R_PF_RUOLO_PA rPfRuoloPa, SIGIT_D_RUOLO_PA dRuoloPa, sigit_t_persona_fisica tpf");

		sql.append(" WHERE ");
		
		sql.append(" 1=1 ");

		sql.append(" AND dRuoloPa.ID_RUOLO_PA = rPfRuoloPa.ID_RUOLO_PA");

		sql.append(" AND ");

		sql.append("tpf.id_persona_fisica = rPfRuoloPa.id_persona_fisica ");				
		
		sql.append(" AND rPfRuoloPa.id_ruolo_pa in (2) ");

		List<Assegnatario> list = null;		
		
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, new RowMapper<Assegnatario>() {

				@Override
				public Assegnatario mapRow(ResultSet rs, int arg1) throws SQLException {
				
					Assegnatario assegnatario = new Assegnatario();
					assegnatario.setCodicefiscale(rs.getString("codice_fiscale"));
					assegnatario.setCognome(rs.getString("cognome"));
					assegnatario.setDesRuoloPa(rs.getString("DES_RUOLO_PA"));
					assegnatario.setIdPersonaFisica(rs.getInt("id_persona_fisica"));
					assegnatario.setIdRuoloPa(rs.getInt("ID_RUOLO_PA"));
					assegnatario.setIstatAbilitazione(rs.getString("ISTAT_ABILITAZIONE"));
					assegnatario.setNome(rs.getString("nome"));
					Date datafine = rs.getDate("DATA_FINE");
					if(datafine!=null) {
						assegnatario.setDataFine(datafine.getTime());
					}
					return assegnatario;
				}
				
			});
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfRuoloPaDaoImpl::findAllAssegnatario] ERROR esecuzione query", ex);
			throw new SigitRPfRuoloPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfRuoloPaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitRPfRuoloPaDaoImpl::findAllAssegnatario] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder allByIstatValidatore
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfRuoloPaDto> findAllByIstatValidatore(SigitRPfRuoloPaDto input)
			throws SigitRPfRuoloPaDaoException {
		LOG.debug("[SigitRPfRuoloPaDaoImpl::findAllByIstatValidatore] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT DISTINCT DESC_ABILITAZIONE ");
		sql.append(" FROM SIGIT_R_PF_RUOLO_PA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R2140857280) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		log.debug(input.getIstatAbilitazione());
		log.debug(input.getIdRuoloPa());
		sql.append("istat_abilitazione = :istat");
		sql.append(" AND id_ruolo_pa = :id");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1472337278) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("istat", input.getIstatAbilitazione());
		paramMap.addValue("id", input.getIdRuoloPa());

		/*PROTECTED REGION END*/
		List<SigitRPfRuoloPaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, allByIstatValidatoreRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfRuoloPaDaoImpl::findAllByIstatValidatore] esecuzione query", ex);
			throw new SigitRPfRuoloPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfRuoloPaDaoImpl", "findAllByIstatValidatore", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRPfRuoloPaDaoImpl::findAllByIstatValidatore] END");
		}
		return list;
	}

	@Override
	public void closeCaricatoriImpiantoSigitRImpRuoloPfpg(Integer codiceImpianto, String utenteUltimaModifica) throws SigitRPfRuoloPaDaoException {
		// TODO Auto-generated method stub
//		update sigit_r_imp_ruolo_pfpg set data_fine = (now() - INTERVAL '1 DAYS'), utente_ult_mod = :utenteUltMod , data_ult_mod = now()
//				where codice_impianto = :codiceImpianto and fk_ruolo = 3 and ( data_fine is null or data_fine > now());
		
		LOG.debug("[SigitRPfRuoloPaDaoImpl::closeCaricatoriImpiantoSigitRImpRuoloPfpg] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("update sigit_r_imp_ruolo_pfpg set data_fine = (now() - INTERVAL '1 DAYS'), utente_ult_mod = :utenteUltMod , data_ult_mod = now() ");
		sql.append(" where codice_impianto = :codiceImpianto and fk_ruolo = 3 and ( data_fine is null or data_fine > now()); ");
		paramMap.addValue("utenteUltMod", utenteUltimaModifica);
		paramMap.addValue("codiceImpianto", codiceImpianto);

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			jdbcTemplate.update(sql.toString(), paramMap);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRPfRuoloPaDaoImpl::closeCaricatoriImpiantoSigitRImpRuoloPfpg] esecuzione query", ex);
			throw new SigitRPfRuoloPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitRPfRuoloPaDaoImpl", "findAllByIstatValidatore", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitRPfRuoloPaDaoImpl::closeCaricatoriImpiantoSigitRImpRuoloPfpg] END");
		}
	
	}
}
