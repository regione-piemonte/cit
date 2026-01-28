package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitRIspezIspetDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTIspezione2018Dao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTPersonaFisicaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTIspezione2018DaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTIspezione2018Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTIspezione2018Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaFisicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.DaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTIspezione2018DaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.dto.sigitext.DatiIspezione;
import it.csi.util.performance.StopWatch;

/*PROTECTED REGION ID(R-736750737) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTIspezione2018.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byExample (datagen::CustomFinder)
 *   - validaByIdAccertamento (datagen::CustomFinder)
 *   - sveglieAttiveByCF (datagen::CustomFinder)
 *   - bozzaByIdAccertamento (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - modificaIspezioneDaDettaglio (datagen::UpdateColumns)
 *   - impostaSveglia (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTIspezione2018DaoImpl extends AbstractDAO implements SigitTIspezione2018Dao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	/**
	 * Il DAO utilizza JDBC template per l'implementazione delle query.
	 * @generated
	 */
	protected NamedParameterJdbcTemplate jdbcTemplate;
	
	private SigitRIspezIspetDao sigitRIspezIspetDao;		
	
	private SigitTPersonaFisicaDao sigitTPersonaFisicaDao;		

	public SigitTPersonaFisicaDao getSigitTPersonaFisicaDao() {
		return sigitTPersonaFisicaDao;
	}

	public void setSigitTPersonaFisicaDao(SigitTPersonaFisicaDao sigitTPersonaFisicaDao) {
		this.sigitTPersonaFisicaDao = sigitTPersonaFisicaDao;
	}

	public SigitRIspezIspetDao getSigitRIspezIspetDao() {
		return sigitRIspezIspetDao;
	}

	public void setSigitRIspezIspetDao(SigitRIspezIspetDao sigitRIspezIspetDao) {
		this.sigitRIspezIspetDao = sigitRIspezIspetDao;
	}

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 * @generated
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Metodo di inserimento del DAO sigitTIspezione2018. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTIspezione2018Pk
	 * @generated
	 */

	public SigitTIspezione2018Pk insert(SigitTIspezione2018Dto dto)

	{
		LOG.debug("[SigitTIspezione2018DaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ISPEZIONE_2018,FK_STATO_ISPEZIONE,FK_VERIFICA,FK_ACCERTAMENTO,CODICE_IMPIANTO,CF_ISPETTORE_SECONDARIO,ENTE_COMPETENTE,FLG_ESITO,DT_SVEGLIA,NOTE_SVEGLIA,NOTE,ISTAT_PROV_COMPETENZA,FLG_ACC_SOSTITUTIVO,DT_CREAZIONE,DT_CONCLUSIONE,FLG_ISP_PAGAMENTO,ISTAT_COMUNE_COMPETENZA ) VALUES (  :ID_ISPEZIONE_2018 , :FK_STATO_ISPEZIONE , :FK_VERIFICA , :FK_ACCERTAMENTO , :CODICE_IMPIANTO , :CF_ISPETTORE_SECONDARIO , :ENTE_COMPETENTE , :FLG_ESITO , :DT_SVEGLIA , :NOTE_SVEGLIA , :NOTE , :ISTAT_PROV_COMPETENZA , :FLG_ACC_SOSTITUTIVO , :DT_CREAZIONE , :DT_CONCLUSIONE , :FLG_ISP_PAGAMENTO , :ISTAT_COMUNE_COMPETENZA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ISPEZIONE_2018]
		params.addValue("ID_ISPEZIONE_2018", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_STATO_ISPEZIONE]
		params.addValue("FK_STATO_ISPEZIONE", dto.getFkStatoIspezione(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_VERIFICA]
		params.addValue("FK_VERIFICA", dto.getFkVerifica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ACCERTAMENTO]
		params.addValue("FK_ACCERTAMENTO", dto.getFkAccertamento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CF_ISPETTORE_SECONDARIO]
		params.addValue("CF_ISPETTORE_SECONDARIO", dto.getCfIspettoreSecondario(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ENTE_COMPETENTE]
		params.addValue("ENTE_COMPETENTE", dto.getEnteCompetente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_ESITO]
		params.addValue("FLG_ESITO", dto.getFlgEsito(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_SVEGLIA]
		params.addValue("DT_SVEGLIA", dto.getDtSveglia(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [NOTE_SVEGLIA]
		params.addValue("NOTE_SVEGLIA", dto.getNoteSveglia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_PROV_COMPETENZA]
		params.addValue("ISTAT_PROV_COMPETENZA", dto.getIstatProvCompetenza(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_ACC_SOSTITUTIVO]
		params.addValue("FLG_ACC_SOSTITUTIVO", dto.getFlgAccSostitutivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_CREAZIONE]
		params.addValue("DT_CREAZIONE", dto.getDtCreazione(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DT_CONCLUSIONE]
		params.addValue("DT_CONCLUSIONE", dto.getDtConclusione(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FLG_ISP_PAGAMENTO]
		params.addValue("FLG_ISP_PAGAMENTO", dto.getFlgIspPagamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE_COMPETENZA]
		params.addValue("ISTAT_COMUNE_COMPETENZA", dto.getIstatComuneCompetenza(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdIspezione2018(newKey);
		LOG.debug("[SigitTIspezione2018DaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_ISPEZIONE_2018 table.
	 * @generated
	 */
	public void update(SigitTIspezione2018Dto dto) throws SigitTIspezione2018DaoException {
		LOG.debug("[SigitTIspezione2018DaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_STATO_ISPEZIONE = :FK_STATO_ISPEZIONE ,FK_VERIFICA = :FK_VERIFICA ,FK_ACCERTAMENTO = :FK_ACCERTAMENTO ,CODICE_IMPIANTO = :CODICE_IMPIANTO ,CF_ISPETTORE_SECONDARIO = :CF_ISPETTORE_SECONDARIO ,ENTE_COMPETENTE = :ENTE_COMPETENTE ,FLG_ESITO = :FLG_ESITO ,DT_SVEGLIA = :DT_SVEGLIA ,NOTE_SVEGLIA = :NOTE_SVEGLIA ,NOTE = :NOTE ,ISTAT_PROV_COMPETENZA = :ISTAT_PROV_COMPETENZA ,FLG_ACC_SOSTITUTIVO = :FLG_ACC_SOSTITUTIVO ,DT_CREAZIONE = :DT_CREAZIONE ,DT_CONCLUSIONE = :DT_CONCLUSIONE ,FLG_ISP_PAGAMENTO = :FLG_ISP_PAGAMENTO ,ISTAT_COMUNE_COMPETENZA = :ISTAT_COMUNE_COMPETENZA  WHERE ID_ISPEZIONE_2018 = :ID_ISPEZIONE_2018 ";

		if (dto.getIdIspezione2018() == null) {
			LOG.error("[SigitTIspezione2018DaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTIspezione2018DaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ISPEZIONE_2018]
		params.addValue("ID_ISPEZIONE_2018", dto.getIdIspezione2018(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_STATO_ISPEZIONE]
		params.addValue("FK_STATO_ISPEZIONE", dto.getFkStatoIspezione(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_VERIFICA]
		params.addValue("FK_VERIFICA", dto.getFkVerifica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ACCERTAMENTO]
		params.addValue("FK_ACCERTAMENTO", dto.getFkAccertamento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CF_ISPETTORE_SECONDARIO]
		params.addValue("CF_ISPETTORE_SECONDARIO", dto.getCfIspettoreSecondario(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ENTE_COMPETENTE]
		params.addValue("ENTE_COMPETENTE", dto.getEnteCompetente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_ESITO]
		params.addValue("FLG_ESITO", dto.getFlgEsito(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_SVEGLIA]
		params.addValue("DT_SVEGLIA", dto.getDtSveglia(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [NOTE_SVEGLIA]
		params.addValue("NOTE_SVEGLIA", dto.getNoteSveglia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_PROV_COMPETENZA]
		params.addValue("ISTAT_PROV_COMPETENZA", dto.getIstatProvCompetenza(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_ACC_SOSTITUTIVO]
		params.addValue("FLG_ACC_SOSTITUTIVO", dto.getFlgAccSostitutivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_CREAZIONE]
		params.addValue("DT_CREAZIONE", dto.getDtCreazione(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DT_CONCLUSIONE]
		params.addValue("DT_CONCLUSIONE", dto.getDtConclusione(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FLG_ISP_PAGAMENTO]
		params.addValue("FLG_ISP_PAGAMENTO", dto.getFlgIspPagamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE_COMPETENZA]
		params.addValue("ISTAT_COMUNE_COMPETENZA", dto.getIstatComuneCompetenza(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTIspezione2018DaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_ISPEZIONE_2018 table.
	 * @generated
	 */
	public void updateColumnsModificaIspezioneDaDettaglio(SigitTIspezione2018Dto dto)
			throws SigitTIspezione2018DaoException {
		LOG.debug("[SigitTIspezione2018DaoImpl::updateColumnsModificaIspezioneDaDettaglio] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET NOTE = :NOTE ,CF_ISPETTORE_SECONDARIO = :CF_ISPETTORE_SECONDARIO ,FLG_ISP_PAGAMENTO = :FLG_ISP_PAGAMENTO  WHERE ID_ISPEZIONE_2018 = :ID_ISPEZIONE_2018 ";

		if (dto.getIdIspezione2018() == null) {
			LOG.error(
					"[SigitTIspezione2018DaoImpl::updateColumnsModificaIspezioneDaDettaglio] ERROR chiave primaria non impostata");
			throw new SigitTIspezione2018DaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CF_ISPETTORE_SECONDARIO]
		params.addValue("CF_ISPETTORE_SECONDARIO", dto.getCfIspettoreSecondario(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_ISP_PAGAMENTO]
		params.addValue("FLG_ISP_PAGAMENTO", dto.getFlgIspPagamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_ISPEZIONE_2018]
		params.addValue("ID_ISPEZIONE_2018", dto.getIdIspezione2018(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTIspezione2018DaoImpl::updateColumnsModificaIspezioneDaDettaglio] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_ISPEZIONE_2018 table.
	 * @generated
	 */
	public void updateColumnsImpostaSveglia(SigitTIspezione2018Dto dto) throws SigitTIspezione2018DaoException {
		LOG.debug("[SigitTIspezione2018DaoImpl::updateColumnsImpostaSveglia] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DT_SVEGLIA = :DT_SVEGLIA ,NOTE_SVEGLIA = :NOTE_SVEGLIA  WHERE ID_ISPEZIONE_2018 = :ID_ISPEZIONE_2018 ";

		if (dto.getIdIspezione2018() == null) {
			LOG.error("[SigitTIspezione2018DaoImpl::updateColumnsImpostaSveglia] ERROR chiave primaria non impostata");
			throw new SigitTIspezione2018DaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DT_SVEGLIA]
		params.addValue("DT_SVEGLIA", dto.getDtSveglia(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [NOTE_SVEGLIA]
		params.addValue("NOTE_SVEGLIA", dto.getNoteSveglia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_ISPEZIONE_2018]
		params.addValue("ID_ISPEZIONE_2018", dto.getIdIspezione2018(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTIspezione2018DaoImpl::updateColumnsImpostaSveglia] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_ISPEZIONE_2018 table.
	 * @generated
	 */

	public void delete(SigitTIspezione2018Pk pk) throws SigitTIspezione2018DaoException {
		LOG.debug("[SigitTIspezione2018DaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ISPEZIONE_2018 = :ID_ISPEZIONE_2018 ";

		if (pk == null) {
			LOG.error("[SigitTIspezione2018DaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTIspezione2018DaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ISPEZIONE_2018]
		params.addValue("ID_ISPEZIONE_2018", pk.getIdIspezione2018(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTIspezione2018DaoImpl::delete] END");
	}

	protected SigitTIspezione2018DaoRowMapper findByPrimaryKeyRowMapper = new SigitTIspezione2018DaoRowMapper(null,
			SigitTIspezione2018Dto.class, this);

	protected SigitTIspezione2018DaoRowMapper findAllRowMapper = new SigitTIspezione2018DaoRowMapper(null,
			SigitTIspezione2018Dto.class, this);

	protected SigitTIspezione2018DaoRowMapper byExampleRowMapper = new SigitTIspezione2018DaoRowMapper(null,
			SigitTIspezione2018Dto.class, this);

	protected SigitTIspezione2018DaoRowMapper validaByIdAccertamentoRowMapper = new SigitTIspezione2018DaoRowMapper(
			null, SigitTIspezione2018Dto.class, this);

	protected SigitTIspezione2018DaoRowMapper sveglieAttiveByCFRowMapper = new SigitTIspezione2018DaoRowMapper(null,
			SigitTIspezione2018Dto.class, this);

	protected SigitTIspezione2018DaoRowMapper bozzaByIdAccertamentoRowMapper = new SigitTIspezione2018DaoRowMapper(null,
			SigitTIspezione2018Dto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_ISPEZIONE_2018";
	}

	/** 
	 * Returns all rows from the SIGIT_T_ISPEZIONE_2018 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTIspezione2018Dto findByPrimaryKey(SigitTIspezione2018Pk pk) throws SigitTIspezione2018DaoException {
		LOG.debug("[SigitTIspezione2018DaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ISPEZIONE_2018,FK_STATO_ISPEZIONE,FK_VERIFICA,FK_ACCERTAMENTO,CODICE_IMPIANTO,CF_ISPETTORE_SECONDARIO,ENTE_COMPETENTE,FLG_ESITO,DT_SVEGLIA,NOTE_SVEGLIA,NOTE,ISTAT_PROV_COMPETENZA,FLG_ACC_SOSTITUTIVO,DT_CREAZIONE,DT_CONCLUSIONE,FLG_ISP_PAGAMENTO,ISTAT_COMUNE_COMPETENZA FROM "
						+ getTableName() + " WHERE ID_ISPEZIONE_2018 = :ID_ISPEZIONE_2018 ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ISPEZIONE_2018]
		params.addValue("ID_ISPEZIONE_2018", pk.getIdIspezione2018(), java.sql.Types.INTEGER);

		List<SigitTIspezione2018Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTIspezione2018DaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTIspezione2018DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTIspezione2018DaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTIspezione2018DaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_ISPEZIONE_2018.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTIspezione2018Dto> findAll() throws SigitTIspezione2018DaoException {
		LOG.debug("[SigitTIspezione2018DaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ISPEZIONE_2018,FK_STATO_ISPEZIONE,FK_VERIFICA,FK_ACCERTAMENTO,CODICE_IMPIANTO,CF_ISPETTORE_SECONDARIO,ENTE_COMPETENTE,FLG_ESITO,DT_SVEGLIA,NOTE_SVEGLIA,NOTE,ISTAT_PROV_COMPETENZA,FLG_ACC_SOSTITUTIVO,DT_CREAZIONE,DT_CONCLUSIONE,FLG_ISP_PAGAMENTO,ISTAT_COMUNE_COMPETENZA FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<SigitTIspezione2018Dto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTIspezione2018DaoImpl::findAll] ERROR esecuzione query", ex);
			throw new SigitTIspezione2018DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTIspezione2018DaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[SigitTIspezione2018DaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTIspezione2018Dto> getElencoIspezioni(
			DatiIspezione input)
			throws DaoException {
		LOG.debug("[SigitTIspezione2018DaoImpl::getElencoIspezioni] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT distinct STI.ID_ISPEZIONE_2018,STI.FK_STATO_ISPEZIONE,STI.FK_VERIFICA,STI.FK_ACCERTAMENTO,STI.CODICE_IMPIANTO,"
				+ "STI.CF_ISPETTORE_SECONDARIO,STI.ENTE_COMPETENTE,STI.FLG_ESITO,STI.DT_SVEGLIA,STI.NOTE_SVEGLIA,STI.NOTE,STI.ISTAT_PROV_COMPETENZA,STI.FLG_ACC_SOSTITUTIVO,STI.DT_CREAZIONE,"
				+ "STI.DT_CONCLUSIONE,STI.FLG_ISP_PAGAMENTO,STI.ISTAT_COMUNE_COMPETENZA ");
		sql.append(" FROM SIGIT_T_ISPEZIONE_2018 STI");
		if(input.getDenomUtenteAssegn()!=null || input.getCfUtenteAssegn()!=null) { 
			sql.append(" JOIN SIGIT_R_ISPEZ_ISPET SRI ON (STI.ID_ISPEZIONE_2018 = SRI.ID_ISPEZIONE_2018) ");
		}
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R103911766) ENABLED START*/
		sql.append(" 1 = 1 ");

		if ((input.getNonAssegnato()!=null && input.getNonAssegnato())) {
			sql.append(" AND STI.ID_ISPEZIONE_2018 NOT IN (SELECT SRI.ID_ISPEZIONE_2018 FROM  SIGIT_R_ISPEZ_ISPET SRI) "); 			
		}
		
		if(input.getNonAssegnato()!=null && input.getDenomUtenteAssegn()!=null && input.getCfUtenteAssegn()!=null) {
			
			return new ArrayList<>();
			
		}
		
		SigitTPersonaFisicaDto sigitTPersonaFisicaDto = new SigitTPersonaFisicaDto();
		
		if(input.getDenomUtenteAssegn()!=null || input.getCfUtenteAssegn()!=null) {
						
			sql.append(" AND SRI.FK_PERSONA_FISICA = :FK_PERSONA_FISICA ");		
			
			if(input.getDenomUtenteAssegn() != null) {						
					
					sigitTPersonaFisicaDto = sigitTPersonaFisicaDao.findByDenominazione(input.getDenomUtenteAssegn());								
			}
			
			if(input.getCfUtenteAssegn() != null) {
												
				List<SigitTPersonaFisicaDto> listSigitTPersonaFisicaDto = sigitTPersonaFisicaDao.findByCodiceFiscale(input.getCfUtenteAssegn());
				if( listSigitTPersonaFisicaDto!=null && listSigitTPersonaFisicaDto.size()>0) {
					sigitTPersonaFisicaDto = listSigitTPersonaFisicaDto.get(0);
				}		
				
			}															
		}				
		
		if (input.getIdIspezione2018() != null) {
			sql.append(" AND STI.ID_ISPEZIONE_2018 = :idIspezione2018");
		}
		
		if (input.getFkVerifica() != null) {
			sql.append(" AND FK_VERIFICA = :fkVerifica");
		}

		if (input.getFkAccertamento() != null) {
			sql.append(" AND FK_ACCERTAMENTO = :fkAccertamento");
		}
		
		if (input.getFkStatoIspezione() != null) {
			sql.append(" AND FK_STATO_ISPEZIONE = :fkStatoIspezione");
		}
		
		if (input.getFlgEsito() != null) {
			sql.append(" AND FLG_ESITO = :flgEsito");
		}
		
		if (input.getCodiceImpianto() != null) {
			sql.append(" AND CODICE_IMPIANTO = :codiceImpianto");
		}
		
		if (input.getIstatProvCompetenza() != null) {
			sql.append(" AND ISTAT_PROV_COMPETENZA = :istatProvCompetenza");
		}
		
		if (input.getIstatComuneCompetenza() != null) {
			sql.append(" AND ISTAT_COMUNE_COMPETENZA = :istatComuneCompetenza");
		}
		
		if (input.getFlgIspPagamento() != null) {
			sql.append(" AND FLG_ISP_PAGAMENTO = :flgIspPagamento");
		}
		
		if(input.getDtConclusioneDa()!=null && input.getDtConclusioneA()==null) {
			sql.append(" AND DT_CONCLUSIONE >= :dtConclusioneDa");			
		}
		if(input.getDtConclusioneA()!=null && input.getDtConclusioneDa()==null) {
			sql.append(" AND DT_CONCLUSIONE <= :dtConclusioneA");			
		}
		if(input.getDtConclusioneDa()!=null && input.getDtConclusioneA()!=null) {
			sql.append(" AND DT_CONCLUSIONE >= :dtConclusioneDa AND DT_CONCLUSIONE <= :dtConclusioneA");			
		}
		if(input.getDtCreazioneDa()!=null && input.getDtCreazioneA()==null) {
			sql.append(" AND DT_CREAZIONE >= :dtCreazioneDa");			
		}			
		if(input.getDtCreazioneA()!=null && input.getDtCreazioneDa()==null) {
			sql.append(" AND DT_CREAZIONE <= :dtCreazioneA");			
		}
		if(input.getDtCreazioneDa()!=null && input.getDtCreazioneA()!=null) {
			sql.append(" AND DT_CREAZIONE >= :dtCreazioneDa AND DT_CREAZIONE <= :dtCreazioneA");			
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-193138772) ENABLED START*/
		
		if((input.getDenomUtenteAssegn()!=null || input.getCfUtenteAssegn()!=null) && sigitTPersonaFisicaDto != null) {
			paramMap.addValue("FK_PERSONA_FISICA", sigitTPersonaFisicaDto.getIdPersonaFisica(), java.sql.Types.INTEGER);
		}		
		
		if (input.getIdIspezione2018() != null) {
			paramMap.addValue("idIspezione2018", input.getIdIspezione2018(), java.sql.Types.INTEGER);
		}

		if (input.getFkVerifica() != null) {
			paramMap.addValue("fkVerifica", input.getFkVerifica(), java.sql.Types.INTEGER);
		}

		if (input.getFkAccertamento() != null) {
			paramMap.addValue("fkAccertamento", input.getFkAccertamento(), java.sql.Types.INTEGER);
		}
		
		if (input.getFkStatoIspezione() != null) {
			paramMap.addValue("fkStatoIspezione", input.getFkStatoIspezione(), java.sql.Types.INTEGER);
		}
		
		if (input.getFlgEsito() != null) {
			paramMap.addValue("flgEsito", input.getFlgEsito(), java.sql.Types.INTEGER);
		}
		
		if (input.getCodiceImpianto() != null) {
			paramMap.addValue("codiceImpianto", input.getCodiceImpianto(), java.sql.Types.INTEGER);
		}
		
		if (input.getIstatProvCompetenza() != null) {
			paramMap.addValue("istatProvCompetenza", input.getIstatProvCompetenza(), java.sql.Types.VARCHAR);
		}
		
		if (input.getIstatComuneCompetenza() != null) {
			paramMap.addValue("istatComuneCompetenza", input.getIstatComuneCompetenza(), java.sql.Types.VARCHAR);
		}
		
		if (input.getFlgIspPagamento() != null) {
			paramMap.addValue("flgIspPagamento", input.getFlgIspPagamento(), java.sql.Types.INTEGER);
		}
		
		if(input.getDtConclusioneDa()!=null) {
			paramMap.addValue("dtConclusioneDa", new Date(input.getDtConclusioneDa()), java.sql.Types.DATE);			
		}
		if(input.getDtConclusioneA()!=null) {
			paramMap.addValue("dtConclusioneA", new Date(input.getDtConclusioneA()), java.sql.Types.DATE);			
		}
		
		if(input.getDtCreazioneDa()!=null) {
			paramMap.addValue("dtCreazioneDa", new Date(input.getDtCreazioneDa()), java.sql.Types.DATE);
		}			
		if(input.getDtCreazioneA()!=null) {
			paramMap.addValue("dtCreazioneA", new Date(input.getDtCreazioneA()), java.sql.Types.DATE);			
		}

		/*PROTECTED REGION END*/
		List<SigitTIspezione2018Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byExampleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTIspezione2018DaoImpl::findByExample] esecuzione query", ex);
			throw new SigitTIspezione2018DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTIspezione2018DaoImpl", "findByExample", "esecuzione query", sql.toString());
			LOG.debug("[SigitTIspezione2018DaoImpl::getElencoIspezioni] END");
		}
		return list;
	}
	
	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTIspezione2018Dto> findByExample(
			SigitTIspezione2018Dto input)
			throws SigitTIspezione2018DaoException {
		LOG.debug("[SigitTIspezione2018DaoImpl::findByExample] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ISPEZIONE_2018,FK_STATO_ISPEZIONE,FK_VERIFICA,FK_ACCERTAMENTO,CODICE_IMPIANTO,CF_ISPETTORE_SECONDARIO,ENTE_COMPETENTE,FLG_ESITO,DT_SVEGLIA,NOTE_SVEGLIA,NOTE,ISTAT_PROV_COMPETENZA,FLG_ACC_SOSTITUTIVO,DT_CREAZIONE,DT_CONCLUSIONE,FLG_ISP_PAGAMENTO,ISTAT_COMUNE_COMPETENZA ");
		sql.append(" FROM SIGIT_T_ISPEZIONE_2018");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R103911766) ENABLED START*/
		sql.append(" 1 = 1 ");

		if (input.getFkVerifica() != null) {
			sql.append(" AND FK_VERIFICA = :fkVerifica");
		}

		if (input.getFkAccertamento() != null) {
			sql.append(" AND FK_ACCERTAMENTO = :fkAccertamento");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-193138772) ENABLED START*/

		if (input.getFkVerifica() != null) {
			paramMap.addValue("fkVerifica", input.getFkVerifica(), java.sql.Types.INTEGER);
		}

		if (input.getFkAccertamento() != null) {
			paramMap.addValue("fkAccertamento", input.getFkAccertamento(), java.sql.Types.INTEGER);
		}

		/*PROTECTED REGION END*/
		List<SigitTIspezione2018Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byExampleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTIspezione2018DaoImpl::findByExample] esecuzione query", ex);
			throw new SigitTIspezione2018DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTIspezione2018DaoImpl", "findByExample", "esecuzione query", sql.toString());
			LOG.debug("[SigitTIspezione2018DaoImpl::findByExample] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder validaByIdAccertamento
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTIspezione2018Dto> findValidaByIdAccertamento(java.lang.Integer input)
			throws SigitTIspezione2018DaoException {
		LOG.debug("[SigitTIspezione2018DaoImpl::findValidaByIdAccertamento] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ISPEZIONE_2018,FK_STATO_ISPEZIONE,FK_VERIFICA,FK_ACCERTAMENTO,CODICE_IMPIANTO,CF_ISPETTORE_SECONDARIO,ENTE_COMPETENTE,FLG_ESITO,DT_SVEGLIA,NOTE_SVEGLIA,NOTE,ISTAT_PROV_COMPETENZA,FLG_ACC_SOSTITUTIVO,DT_CREAZIONE,DT_CONCLUSIONE,FLG_ISP_PAGAMENTO,ISTAT_COMUNE_COMPETENZA ");
		sql.append(" FROM SIGIT_T_ISPEZIONE_2018");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R2028291014) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" FK_ACCERTAMENTO = :fkAccertamento");
		sql.append(" AND FK_STATO_ISPEZIONE != " + Constants.ID_STATO_ISPEZIONE_ANNULLATO);
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-666924228) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("fkAccertamento", input);

		/*PROTECTED REGION END*/
		List<SigitTIspezione2018Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, validaByIdAccertamentoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTIspezione2018DaoImpl::findValidaByIdAccertamento] esecuzione query", ex);
			throw new SigitTIspezione2018DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTIspezione2018DaoImpl", "findValidaByIdAccertamento", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTIspezione2018DaoImpl::findValidaByIdAccertamento] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder sveglieAttiveByCF
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTIspezione2018Dto> findSveglieAttiveByCF(java.lang.String input)
			throws SigitTIspezione2018DaoException {
		LOG.debug("[SigitTIspezione2018DaoImpl::findSveglieAttiveByCF] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-1377337263) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT isp.ID_ISPEZIONE_2018,FK_STATO_ISPEZIONE,FK_VERIFICA,FK_ACCERTAMENTO,isp.CODICE_IMPIANTO,CF_ISPETTORE_SECONDARIO,DT_CREAZIONE,ENTE_COMPETENTE,FLG_ESITO,DT_SVEGLIA,NOTE_SVEGLIA,NOTE, DT_CONCLUSIONE,ISTAT_PROV_COMPETENZA,FLG_ACC_SOSTITUTIVO,FLG_ISP_PAGAMENTO,ISTAT_COMUNE_COMPETENZA ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R582152995) ENABLED START*/
		if (input != null) {
			//sql.append(" FROM SIGIT_T_ISPEZIONE_2018 isp, SIGIT_R_IMP_RUOLO_PFPG imp, SIGIT_T_PERSONA_FISICA pf");
			sql.append(" FROM SIGIT_T_ISPEZIONE_2018 isp, SIGIT_R_ISPEZ_ISPET ispet, SIGIT_T_PERSONA_FISICA pf");

		} else {
			sql.append(" FROM SIGIT_T_ISPEZIONE_2018 isp");
		}

		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R649509431) ENABLED START*/

		sql.append(" 1 = 1 ");

		sql.append(" AND isp.ID_ISPEZIONE_2018 <> 0");

		//le ispezioni da restituire se c'e' il cf in input sono:
		//- quelle assegnate e con una sveglia

		//le ispezioni da restituire se non c'e' il cf in input sono:
		//- quelle non assegnate

		//(come per gli accertamenti)

		if (input != null) {
			sql.append(" AND isp.ID_ISPEZIONE_2018 = ispet.ID_ISPEZIONE_2018");
			sql.append(" AND ispet.FK_PERSONA_FISICA = pf.ID_PERSONA_FISICA");
			sql.append(" AND pf.CODICE_FISCALE = :cfUtente");
			sql.append(" AND DT_SVEGLIA IS NOT NULL");
		} else {
			sql.append(" AND NOT EXISTS (");
			sql.append(" SELECT ispet.ID_ISPEZIONE_2018");
			sql.append(" FROM SIGIT_R_ISPEZ_ISPET ispet ");
			sql.append(" WHERE ispet.ID_ISPEZIONE_2018 = isp.ID_ISPEZIONE_2018)");

			sql.append(" AND FK_STATO_ISPEZIONE = " + Constants.ID_STATO_ISPEZIONE_BOZZA);

		}

		sql.append(" ORDER BY DT_SVEGLIA DESC, isp.ID_ISPEZIONE_2018 DESC");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-459480341) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input != null) {
			paramMap.addValue("cfUtente", input);
		}

		/*PROTECTED REGION END*/
		List<SigitTIspezione2018Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, sveglieAttiveByCFRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTIspezione2018DaoImpl::findSveglieAttiveByCF] esecuzione query", ex);
			throw new SigitTIspezione2018DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTIspezione2018DaoImpl", "findSveglieAttiveByCF", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTIspezione2018DaoImpl::findSveglieAttiveByCF] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder bozzaByIdAccertamento
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTIspezione2018Dto> findBozzaByIdAccertamento(java.lang.Integer input)
			throws SigitTIspezione2018DaoException {
		LOG.debug("[SigitTIspezione2018DaoImpl::findBozzaByIdAccertamento] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ISPEZIONE_2018,FK_STATO_ISPEZIONE,FK_VERIFICA,FK_ACCERTAMENTO,CODICE_IMPIANTO,CF_ISPETTORE_SECONDARIO,ENTE_COMPETENTE,FLG_ESITO,DT_SVEGLIA,NOTE_SVEGLIA,NOTE,ISTAT_PROV_COMPETENZA,FLG_ACC_SOSTITUTIVO,DT_CREAZIONE,DT_CONCLUSIONE,FLG_ISP_PAGAMENTO,ISTAT_COMUNE_COMPETENZA ");
		sql.append(" FROM SIGIT_T_ISPEZIONE_2018");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-912127073) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" FK_ACCERTAMENTO = :fkAccertamento");
		sql.append(" AND FK_STATO_ISPEZIONE = " + Constants.ID_STATO_ISPEZIONE_BOZZA);

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1625571709) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("fkAccertamento", input);

		/*PROTECTED REGION END*/
		List<SigitTIspezione2018Dto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, bozzaByIdAccertamentoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTIspezione2018DaoImpl::findBozzaByIdAccertamento] esecuzione query", ex);
			throw new SigitTIspezione2018DaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTIspezione2018DaoImpl", "findBozzaByIdAccertamento", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTIspezione2018DaoImpl::findBozzaByIdAccertamento] END");
		}
		return list;
	}

}
