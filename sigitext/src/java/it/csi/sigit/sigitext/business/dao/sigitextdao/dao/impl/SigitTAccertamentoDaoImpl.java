package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTAccertamentoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.RicercaAccertamentoFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitTAccertamentoDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAccertamentoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAccertamentoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTAccertamentoDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.ConvertUtil;
import it.csi.sigit.sigitext.business.util.GenericUtil;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class SigitTAccertamentoDaoImpl extends AbstractDAO implements SigitTAccertamentoDao {
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
	 * Metodo di inserimento del DAO sigitTAccertamento. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAccertamentoPk
	 * @generated
	 */

	public SigitTAccertamentoPk insert(SigitTAccertamentoDto dto)

	{
		LOG.debug("[SigitTAccertamentoDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ACCERTAMENTO,FK_VERIFICA,FK_STATO_ACCERTAMENTO,CODICE_IMPIANTO,CF_UTENTE_ASSEGN,DT_CREAZIONE,DT_CONCLUSIONE,FK_TIPO_CONCLUSIONE,FK_TIPO_ANOMALIA,DT_SVEGLIA,NOTE_SVEGLIA,NOTE,SIGLA_PROV_COMPETENZA,ISTAT_PROV_COMPETENZA,DENOM_UTENTE_ASSEGN,ISTAT_COMUNE_COMPETENZA ) VALUES (  :ID_ACCERTAMENTO , :FK_VERIFICA , :FK_STATO_ACCERTAMENTO , :CODICE_IMPIANTO , :CF_UTENTE_ASSEGN , :DT_CREAZIONE , :DT_CONCLUSIONE , :FK_TIPO_CONCLUSIONE , :FK_TIPO_ANOMALIA , :DT_SVEGLIA , :NOTE_SVEGLIA , :NOTE , :SIGLA_PROV_COMPETENZA , :ISTAT_PROV_COMPETENZA , :DENOM_UTENTE_ASSEGN , :ISTAT_COMUNE_COMPETENZA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ACCERTAMENTO]
		params.addValue("ID_ACCERTAMENTO", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_VERIFICA]
		params.addValue("FK_VERIFICA", dto.getFkVerifica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_STATO_ACCERTAMENTO]
		params.addValue("FK_STATO_ACCERTAMENTO", dto.getFkStatoAccertamento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CF_UTENTE_ASSEGN]
		params.addValue("CF_UTENTE_ASSEGN", dto.getCfUtenteAssegn(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DT_CREAZIONE]
		params.addValue("DT_CREAZIONE", dto.getDtCreazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DT_CONCLUSIONE]
		params.addValue("DT_CONCLUSIONE", dto.getDtConclusione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_TIPO_CONCLUSIONE]
		params.addValue("FK_TIPO_CONCLUSIONE", dto.getFkTipoConclusione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_ANOMALIA]
		params.addValue("FK_TIPO_ANOMALIA", dto.getFkTipoAnomalia(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DT_SVEGLIA]
		params.addValue("DT_SVEGLIA", dto.getDtSveglia(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE_SVEGLIA]
		params.addValue("NOTE_SVEGLIA", dto.getNoteSveglia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SIGLA_PROV_COMPETENZA]
		params.addValue("SIGLA_PROV_COMPETENZA", dto.getSiglaProvCompetenza(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_PROV_COMPETENZA]
		params.addValue("ISTAT_PROV_COMPETENZA", dto.getIstatProvCompetenza(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DENOM_UTENTE_ASSEGN]
		params.addValue("DENOM_UTENTE_ASSEGN", dto.getDenomUtenteAssegn(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE_COMPETENZA]
		params.addValue("ISTAT_COMUNE_COMPETENZA", dto.getIstatComuneCompetenza(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdAccertamento(newKey);
		LOG.debug("[SigitTAccertamentoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the SIGIT_T_ACCERTAMENTO table.
	 * @generated
	 */
	public void update(SigitTAccertamentoDto dto) throws SigitTAccertamentoDaoException {
		LOG.debug("[SigitTAccertamentoDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_VERIFICA = :FK_VERIFICA ,FK_STATO_ACCERTAMENTO = :FK_STATO_ACCERTAMENTO ,CODICE_IMPIANTO = :CODICE_IMPIANTO ,CF_UTENTE_ASSEGN = :CF_UTENTE_ASSEGN ,DT_CREAZIONE = :DT_CREAZIONE ,DT_CONCLUSIONE = :DT_CONCLUSIONE ,FK_TIPO_CONCLUSIONE = :FK_TIPO_CONCLUSIONE ,FK_TIPO_ANOMALIA = :FK_TIPO_ANOMALIA ,DT_SVEGLIA = :DT_SVEGLIA ,NOTE_SVEGLIA = :NOTE_SVEGLIA ,NOTE = :NOTE ,SIGLA_PROV_COMPETENZA = :SIGLA_PROV_COMPETENZA ,ISTAT_PROV_COMPETENZA = :ISTAT_PROV_COMPETENZA ,DENOM_UTENTE_ASSEGN = :DENOM_UTENTE_ASSEGN ,ISTAT_COMUNE_COMPETENZA = :ISTAT_COMUNE_COMPETENZA  WHERE ID_ACCERTAMENTO = :ID_ACCERTAMENTO ";

		if (dto.getIdAccertamento() == null) {
			LOG.error("[SigitTAccertamentoDaoImpl::update] ERROR chiave primaria non impostata");
			throw new SigitTAccertamentoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ACCERTAMENTO]
		params.addValue("ID_ACCERTAMENTO", dto.getIdAccertamento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_VERIFICA]
		params.addValue("FK_VERIFICA", dto.getFkVerifica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_STATO_ACCERTAMENTO]
		params.addValue("FK_STATO_ACCERTAMENTO", dto.getFkStatoAccertamento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CF_UTENTE_ASSEGN]
		params.addValue("CF_UTENTE_ASSEGN", dto.getCfUtenteAssegn(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DT_CREAZIONE]
		params.addValue("DT_CREAZIONE", dto.getDtCreazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DT_CONCLUSIONE]
		params.addValue("DT_CONCLUSIONE", dto.getDtConclusione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_TIPO_CONCLUSIONE]
		params.addValue("FK_TIPO_CONCLUSIONE", dto.getFkTipoConclusione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_ANOMALIA]
		params.addValue("FK_TIPO_ANOMALIA", dto.getFkTipoAnomalia(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DT_SVEGLIA]
		params.addValue("DT_SVEGLIA", dto.getDtSveglia(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE_SVEGLIA]
		params.addValue("NOTE_SVEGLIA", dto.getNoteSveglia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SIGLA_PROV_COMPETENZA]
		params.addValue("SIGLA_PROV_COMPETENZA", dto.getSiglaProvCompetenza(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_PROV_COMPETENZA]
		params.addValue("ISTAT_PROV_COMPETENZA", dto.getIstatProvCompetenza(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DENOM_UTENTE_ASSEGN]
		params.addValue("DENOM_UTENTE_ASSEGN", dto.getDenomUtenteAssegn(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE_COMPETENZA]
		params.addValue("ISTAT_COMUNE_COMPETENZA", dto.getIstatComuneCompetenza(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAccertamentoDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_ACCERTAMENTO table.
	 * @generated
	 */
	public void updateColumnsSveglia(SigitTAccertamentoDto dto) throws SigitTAccertamentoDaoException {
		LOG.debug("[SigitTAccertamentoDaoImpl::updateColumnsSveglia] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DT_SVEGLIA = :DT_SVEGLIA ,NOTE_SVEGLIA = :NOTE_SVEGLIA  WHERE ID_ACCERTAMENTO = :ID_ACCERTAMENTO ";

		if (dto.getIdAccertamento() == null) {
			LOG.error("[SigitTAccertamentoDaoImpl::updateColumnsSveglia] ERROR chiave primaria non impostata");
			throw new SigitTAccertamentoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DT_SVEGLIA]
		params.addValue("DT_SVEGLIA", dto.getDtSveglia(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE_SVEGLIA]
		params.addValue("NOTE_SVEGLIA", dto.getNoteSveglia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_ACCERTAMENTO]
		params.addValue("ID_ACCERTAMENTO", dto.getIdAccertamento(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAccertamentoDaoImpl::updateColumnsSveglia] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_ACCERTAMENTO table.
	 * @generated
	 */
	public void updateColumnsModifica(SigitTAccertamentoDto dto) throws SigitTAccertamentoDaoException {
		LOG.debug("[SigitTAccertamentoDaoImpl::updateColumnsModifica] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_TIPO_ANOMALIA = :FK_TIPO_ANOMALIA ,NOTE = :NOTE  WHERE ID_ACCERTAMENTO = :ID_ACCERTAMENTO ";

		if (dto.getIdAccertamento() == null) {
			LOG.error("[SigitTAccertamentoDaoImpl::updateColumnsModifica] ERROR chiave primaria non impostata");
			throw new SigitTAccertamentoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_TIPO_ANOMALIA]
		params.addValue("FK_TIPO_ANOMALIA", dto.getFkTipoAnomalia(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_ACCERTAMENTO]
		params.addValue("ID_ACCERTAMENTO", dto.getIdAccertamento(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAccertamentoDaoImpl::updateColumnsModifica] END");
	}

	/** 
	 * Updates selected columns in the SIGIT_T_ACCERTAMENTO table.
	 * @generated
	 */
	public void updateColumnsConcludi(SigitTAccertamentoDto dto) throws SigitTAccertamentoDaoException {
		LOG.debug("[SigitTAccertamentoDaoImpl::updateColumnsConcludi] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_TIPO_CONCLUSIONE = :FK_TIPO_CONCLUSIONE ,DT_CONCLUSIONE = :DT_CONCLUSIONE ,FK_STATO_ACCERTAMENTO = :FK_STATO_ACCERTAMENTO  WHERE ID_ACCERTAMENTO = :ID_ACCERTAMENTO ";

		if (dto.getIdAccertamento() == null) {
			LOG.error("[SigitTAccertamentoDaoImpl::updateColumnsConcludi] ERROR chiave primaria non impostata");
			throw new SigitTAccertamentoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_TIPO_CONCLUSIONE]
		params.addValue("FK_TIPO_CONCLUSIONE", dto.getFkTipoConclusione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DT_CONCLUSIONE]
		params.addValue("DT_CONCLUSIONE", dto.getDtConclusione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [FK_STATO_ACCERTAMENTO]
		params.addValue("FK_STATO_ACCERTAMENTO", dto.getFkStatoAccertamento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_ACCERTAMENTO]
		params.addValue("ID_ACCERTAMENTO", dto.getIdAccertamento(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAccertamentoDaoImpl::updateColumnsConcludi] END");
	}

	/** 
	 * Deletes a single row in the SIGIT_T_ACCERTAMENTO table.
	 * @generated
	 */

	public void delete(SigitTAccertamentoPk pk) throws SigitTAccertamentoDaoException {
		LOG.debug("[SigitTAccertamentoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ACCERTAMENTO = :ID_ACCERTAMENTO ";

		if (pk == null) {
			LOG.error("[SigitTAccertamentoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SigitTAccertamentoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ACCERTAMENTO]
		params.addValue("ID_ACCERTAMENTO", pk.getIdAccertamento(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAccertamentoDaoImpl::delete] END");
	}

	/** 
	 * Custom deleter in the SIGIT_T_ACCERTAMENTO table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTAccertamentoDaoException {
		LOG.debug("[SigitTAccertamentoDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R282344436) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE ";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("parametro", filter);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAccertamentoDaoImpl::customDeleterByCodImpianto] END");
	}

	protected SigitTAccertamentoDaoRowMapper findByPrimaryKeyRowMapper = new SigitTAccertamentoDaoRowMapper(null,
			SigitTAccertamentoDto.class, this);

	protected SigitTAccertamentoDaoRowMapper byExampleRowMapper = new SigitTAccertamentoDaoRowMapper(null,
			SigitTAccertamentoDto.class, this);

	protected SigitTAccertamentoDaoRowMapper byFilterRowMapper = new SigitTAccertamentoDaoRowMapper(null,
			SigitTAccertamentoDto.class, this);

	protected SigitTAccertamentoDaoRowMapper sveglieAttiveByCFRowMapper = new SigitTAccertamentoDaoRowMapper(null,
			SigitTAccertamentoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_ACCERTAMENTO";
	}

	/** 
	 * Returns all rows from the SIGIT_T_ACCERTAMENTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTAccertamentoDto findByPrimaryKey(SigitTAccertamentoPk pk) throws SigitTAccertamentoDaoException {
		LOG.debug("[SigitTAccertamentoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ACCERTAMENTO,FK_VERIFICA,FK_STATO_ACCERTAMENTO,CODICE_IMPIANTO,CF_UTENTE_ASSEGN,DT_CREAZIONE,DT_CONCLUSIONE,FK_TIPO_CONCLUSIONE,FK_TIPO_ANOMALIA,DT_SVEGLIA,NOTE_SVEGLIA,NOTE,SIGLA_PROV_COMPETENZA,ISTAT_PROV_COMPETENZA,DENOM_UTENTE_ASSEGN,ISTAT_COMUNE_COMPETENZA FROM "
						+ getTableName() + " WHERE ID_ACCERTAMENTO = :ID_ACCERTAMENTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ACCERTAMENTO]
		params.addValue("ID_ACCERTAMENTO", pk.getIdAccertamento(), java.sql.Types.INTEGER);

		List<SigitTAccertamentoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitTAccertamentoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new SigitTAccertamentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAccertamentoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SigitTAccertamentoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAccertamentoDto> findByExample(SigitTAccertamentoDto input)
			throws SigitTAccertamentoDaoException {
		LOG.debug("[SigitTAccertamentoDaoImpl::findByExample] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ACCERTAMENTO,FK_VERIFICA,FK_STATO_ACCERTAMENTO,CODICE_IMPIANTO,CF_UTENTE_ASSEGN,DT_CREAZIONE,DT_CONCLUSIONE,FK_TIPO_CONCLUSIONE,FK_TIPO_ANOMALIA,DT_SVEGLIA,NOTE_SVEGLIA,NOTE,SIGLA_PROV_COMPETENZA,ISTAT_PROV_COMPETENZA,DENOM_UTENTE_ASSEGN,ISTAT_COMUNE_COMPETENZA ");
		sql.append(" FROM SIGIT_T_ACCERTAMENTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1580482861) ENABLED START*/
		sql.append(" 1 = 1 ");

		if (input.getFkVerifica() != null) {
			sql.append(" AND FK_VERIFICA = :fkVerifica");
		}

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1664075083) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input.getFkVerifica() != null) {
			paramMap.addValue("fkVerifica", input.getFkVerifica(), java.sql.Types.INTEGER);
		}

		/*PROTECTED REGION END*/
		List<SigitTAccertamentoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byExampleRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTAccertamentoDaoImpl::findByExample] esecuzione query", ex);
			throw new SigitTAccertamentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAccertamentoDaoImpl", "findByExample", "esecuzione query", sql.toString());
			LOG.debug("[SigitTAccertamentoDaoImpl::findByExample] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAccertamentoDto> findByFilter(RicercaAccertamentoFilter input)
			throws SigitTAccertamentoDaoException {
		LOG.debug("[SigitTAccertamentoDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R1391011095) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append(
				"SELECT ID_ACCERTAMENTO,FK_VERIFICA,FK_STATO_ACCERTAMENTO,CODICE_IMPIANTO,CF_UTENTE_ASSEGN,DT_CREAZIONE,DT_CONCLUSIONE,FK_TIPO_CONCLUSIONE,FK_TIPO_ANOMALIA,DT_SVEGLIA,NOTE_SVEGLIA,NOTE,SIGLA_PROV_COMPETENZA,DENOM_UTENTE_ASSEGN,ISTAT_PROV_COMPETENZA,ISTAT_COMUNE_COMPETENZA ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1421667991) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM SIGIT_T_ACCERTAMENTO");

		if (input.getIdValidatoreCaricamento() != null) {
			sql.append(
					" JOIN SIGIT_T_PERSONA_FISICA PF ON PF.CODICE_FISCALE = CF_UTENTE_ASSEGN AND PF.ID_PERSONA_FISICA = :iDValidatoreCaricamento ");
		}

		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1339398991) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" ID_ACCERTAMENTO > 0 ");

		if (GenericUtil.isNotNullOrEmpty(input.getIdAccertamento())) {
			sql.append(" AND ID_ACCERTAMENTO = :idAccertamento");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataCreazioneDA())) {
			sql.append(" AND DT_CREAZIONE >= :dataCreazioneDA");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataCreazioneA())) {
			sql.append(" AND DT_CREAZIONE <= :dataCreazioneA");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataConclusioneDA())) {
			sql.append(" AND DT_CONCLUSIONE >= :dataConclusioneDA");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataConclusioneA())) {
			sql.append(" AND DT_CONCLUSIONE <= :dataConclusioneA");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdStatoAccertamento())) {
			sql.append(" AND FK_STATO_ACCERTAMENTO = :idStatoAccertamento");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoAnomalia())) {
			sql.append(" AND FK_TIPO_ANOMALIA = :idTipoAnomalia");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoConclusione())) {
			sql.append(" AND FK_TIPO_CONCLUSIONE = :idTipoConclusione");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceImpianto())) {
			sql.append(" AND CODICE_IMPIANTO = :codiceImpianto");
		}

		if (ConvertUtil.convertToBooleanAllways(input.isFlgNonAssegnato())) {
			sql.append(" AND CF_UTENTE_ASSEGN IS NULL");
		}else if(input.getCfUtenteAssegn() != null){
			sql.append(" AND CF_UTENTE_ASSEGN = :cfUtenteAssegn");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIstatProvincia())) {
			sql.append(" AND ISTAT_PROV_COMPETENZA = :istatProvincia");
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIstatComune())) {
			sql.append(" AND ISTAT_COMUNE_COMPETENZA = :istatComune");
		}

		sql.append(" ORDER BY ID_ACCERTAMENTO DESC");

		sql.append(
				" LIMIT (SELECT VALORE_CONFIG_NUM FROM SIGIT_WRK_CONFIG WHERE CHIAVE_CONFIG='MAX_RIGHE_RIC_AVZ_IMP') ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1986099279) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (GenericUtil.isNotNullOrEmpty(input.getIdAccertamento())) {
			paramMap.addValue("idAccertamento", input.getIdAccertamento(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdValidatoreCaricamento())) {
			paramMap.addValue("iDValidatoreCaricamento", input.getIdValidatoreCaricamento());
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataCreazioneDA())) {
			paramMap.addValue("dataCreazioneDA", input.getDataCreazioneDA(), java.sql.Types.DATE);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataCreazioneA())) {
			paramMap.addValue("dataCreazioneA", input.getDataCreazioneA(), java.sql.Types.DATE);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataConclusioneDA())) {
			paramMap.addValue("dataConclusioneDA", input.getDataConclusioneDA(), java.sql.Types.DATE);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getDataConclusioneA())) {
			paramMap.addValue("dataConclusioneA", input.getDataConclusioneA(), java.sql.Types.DATE);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdStatoAccertamento())) {
			paramMap.addValue("idStatoAccertamento", input.getIdStatoAccertamento(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoAnomalia())) {
			paramMap.addValue("idTipoAnomalia", input.getIdTipoAnomalia(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIdTipoConclusione())) {
			paramMap.addValue("idTipoConclusione", input.getIdTipoConclusione(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getCodiceImpianto())) {
			paramMap.addValue("codiceImpianto", input.getCodiceImpianto(), java.sql.Types.NUMERIC);
		}

		if (GenericUtil.isNotNullOrEmpty(input.getIstatProvincia())) {
			paramMap.addValue("istatProvincia", input.getIstatProvincia());

		}

		if (GenericUtil.isNotNullOrEmpty(input.getIstatComune())) {
			paramMap.addValue("istatComune", input.getIstatComune());

		}
		
		if(input.getCfUtenteAssegn() != null){
			paramMap.addValue("cfUtenteAssegn", input.getCfUtenteAssegn());
		}

		/*PROTECTED REGION END*/
		List<SigitTAccertamentoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTAccertamentoDaoImpl::findByFilter] esecuzione query", ex);
			throw new SigitTAccertamentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAccertamentoDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[SigitTAccertamentoDaoImpl::findByFilter] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder sveglieAttiveByCF
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAccertamentoDto> findSveglieAttiveByCF(java.lang.String input)
			throws SigitTAccertamentoDaoException {
		LOG.debug("[SigitTAccertamentoDaoImpl::findSveglieAttiveByCF] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_ACCERTAMENTO,FK_VERIFICA,FK_STATO_ACCERTAMENTO,CODICE_IMPIANTO,CF_UTENTE_ASSEGN,DT_CREAZIONE,DT_CONCLUSIONE,FK_TIPO_CONCLUSIONE,FK_TIPO_ANOMALIA,DT_SVEGLIA,NOTE_SVEGLIA,NOTE,SIGLA_PROV_COMPETENZA,ISTAT_PROV_COMPETENZA,DENOM_UTENTE_ASSEGN,ISTAT_COMUNE_COMPETENZA ");
		sql.append(" FROM SIGIT_T_ACCERTAMENTO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1441553650) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		sql.append(" ID_ACCERTAMENTO > 0 ");

		if (input != null) {
			// sto cercando gli accertamenti assegnati
			sql.append(" AND DT_SVEGLIA IS NOT NULL");
			sql.append(" AND CF_UTENTE_ASSEGN = :cfUtente");
		} else {
			// sto cercando gli accertamenti NON assegnati
			sql.append(" AND CF_UTENTE_ASSEGN IS NULL");
		}

		sql.append(" ORDER BY DT_SVEGLIA DESC, ID_ACCERTAMENTO DESC ");

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-857926412) ENABLED START*/
		//***aggiungere tutte le condizioni

		if (input != null) {
			paramMap.addValue("cfUtente", input);
		}

		/*PROTECTED REGION END*/
		List<SigitTAccertamentoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, sveglieAttiveByCFRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTAccertamentoDaoImpl::findSveglieAttiveByCF] esecuzione query", ex);
			throw new SigitTAccertamentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAccertamentoDaoImpl", "findSveglieAttiveByCF", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTAccertamentoDaoImpl::findSveglieAttiveByCF] END");
		}
		return list;
	}
	
	public String findIstatProvinciaBySiglaProvincia(String siglaProvincia) throws SigitTAccertamentoDaoException {
		LOG.debug("[SigitTAccertamentoDaoImpl::findIstatProvinciaBySiglaProvincia] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT distinct ISTAT_PROV_COMPETENZA FROM SIGIT_T_ACCERTAMENTO  WHERE SIGLA_PROV_COMPETENZA = :siglaProvincia and istat_prov_competenza is not null");
		
		log.debug("Execute query: " + sql);
		paramMap.addValue("siglaProvincia", siglaProvincia);

		/*PROTECTED REGION END*/
		String response = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			response = jdbcTemplate.queryForObject(sql.toString(), paramMap, String.class);

		} catch (RuntimeException ex) {
			LOG.error("[SigitTAccertamentoDaoImpl::findIstatProvinciaBySiglaProvincia] esecuzione query", ex);
			throw new SigitTAccertamentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SigitTAccertamentoDaoImpl", "findIstatProvinciaBySiglaProvincia", "esecuzione query",
					sql.toString());
			LOG.debug("[SigitTAccertamentoDaoImpl::findIstatProvinciaBySiglaProvincia] END");
		}
		return response;
	}

}
