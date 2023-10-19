package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitRAllegatoCompScDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper.SigitRAllegatoCompScDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompScDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompScPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRAllegatoCompGtDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRAllegatoCompScDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.sigit.sigitext.business.util.GenericUtil;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/*PROTECTED REGION ID(R-140185275) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRAllegatoCompSc.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER:
 * - (insert di default)
 * - FINDERS:
 * <p>
 * --
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
public class SigitRAllegatoCompScDaoImpl extends AbstractDAO implements SigitRAllegatoCompScDao {
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

	/**
	 * Metodo di inserimento del DAO sigitRAllegatoCompSc. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 *
	 * @param dto
	 * @return SigitRAllegatoCompScPk
	 * @generated
	 */

	public SigitRAllegatoCompScPk insert(SigitRAllegatoCompScDto dto) {
		LOG.debug("[SigitRAllegatoCompScDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ALLEGATO,ID_TIPO_COMPONENTE,PROGRESSIVO,CODICE_IMPIANTO,DATA_INSTALL,BUTTA_FK_R_PG,BUTTA_FK_3R_PG,BUTTA_FK_R_PF,BUTTA_FK_3RESP,BUTTA_FK_RESP,FK_IMP_RUOLO_PFPG,FK_CONTRATTO ) VALUES (  :ID_ALLEGATO , :ID_TIPO_COMPONENTE , :PROGRESSIVO , :CODICE_IMPIANTO , :DATA_INSTALL , :BUTTA_FK_R_PG , :BUTTA_FK_3R_PG , :BUTTA_FK_R_PF , :BUTTA_FK_3RESP , :BUTTA_FK_RESP , :FK_IMP_RUOLO_PFPG , :FK_CONTRATTO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [BUTTA_FK_R_PG]
		params.addValue("BUTTA_FK_R_PG", dto.getButtaFkRPg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [BUTTA_FK_3R_PG]
		params.addValue("BUTTA_FK_3R_PG", dto.getButtaFk3rPg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [BUTTA_FK_R_PF]
		params.addValue("BUTTA_FK_R_PF", dto.getButtaFkRPf(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [BUTTA_FK_3RESP]
		params.addValue("BUTTA_FK_3RESP", dto.getButtaFk3resp(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [BUTTA_FK_RESP]
		params.addValue("BUTTA_FK_RESP", dto.getButtaFkResp(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_IMP_RUOLO_PFPG]
		params.addValue("FK_IMP_RUOLO_PFPG", dto.getFkImpRuoloPfpg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_CONTRATTO]
		params.addValue("FK_CONTRATTO", dto.getFkContratto(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitRAllegatoCompScDaoImpl::insert] END");
		return dto.createPk();

	}

	protected SigitRAllegatoCompScDaoRowMapper byFilterRowMapper = new SigitRAllegatoCompScDaoRowMapper(null, SigitRAllegatoCompScDto.class, this);

	@Override
	public List<SigitRAllegatoCompScDto> findByFilter(CompFilter input) throws SigitRAllegatoCompScDaoException {
		LOG.debug("[SigitRAllegatoCompScDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_ALLEGATO,ID_TIPO_COMPONENTE,PROGRESSIVO,CODICE_IMPIANTO,DATA_INSTALL,BUTTA_FK_R_PG,BUTTA_FK_3R_PG,BUTTA_FK_R_PF,BUTTA_FK_3RESP,BUTTA_FK_RESP,FK_IMP_RUOLO_PFPG,FK_CONTRATTO ");
		sql.append(" FROM SIGIT_R_ALLEGATO_COMP_SC");
		sql.append(" WHERE ");
		sql.append("ID_ALLEGATO = :idAllegato");
		if (GenericUtil.isNotNullOrEmpty(input.getProgressivo())) {
			sql.append(" AND PROGRESSIVO = :progressivo");
		}

		paramMap.addValue("idAllegato", input.getIdAllegato());
		if (GenericUtil.isNotNullOrEmpty(input.getProgressivo())) {
			paramMap.addValue("progressivo", input.getProgressivo(), java.sql.Types.NUMERIC);
		}

		List<SigitRAllegatoCompScDto> list = null;
		try {
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[SigitRAllegatoCompScDaoImpl::findByFilter] esecuzione query", ex);
			throw new SigitRAllegatoCompScDaoException("Query failed", ex);
		} finally {
			LOG.debug("[SigitRAllegatoCompScDaoImpl::findByFilter] END");
		}
		return list;
	}

	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitRAllegatoCompScDaoException {
		LOG.debug("[SigitRAllegatoCompScDaoImpl::customDeleterByIdAllegato] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ALLEGATO = :idAllegato";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idAllegato", filter);
		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRAllegatoCompScDaoImpl::customDeleterByIdAllegato] END");
	}

	public void updateColumnsResponsabile(SigitRAllegatoCompScDto dto) throws SigitRAllegatoCompScDaoException {
		LOG.debug("[SigitRAllegatoCompScDaoImpl::updateColumnsResponsabile] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_IMP_RUOLO_PFPG = :FK_IMP_RUOLO_PFPG ,FK_CONTRATTO = :FK_CONTRATTO  WHERE ID_ALLEGATO = :ID_ALLEGATO  AND ID_TIPO_COMPONENTE = :ID_TIPO_COMPONENTE  AND PROGRESSIVO = :PROGRESSIVO  AND CODICE_IMPIANTO = :CODICE_IMPIANTO  AND DATA_INSTALL = :DATA_INSTALL ";

		if (dto.getIdAllegato() == null || dto.getIdTipoComponente() == null || dto.getProgressivo() == null || dto.getCodiceImpianto() == null || dto.getDataInstall() == null) {
			LOG.error("[SigitRAllegatoCompScDaoImpl::updateColumnsResponsabile] ERROR chiave primaria non impostata");
			throw new SigitRAllegatoCompScDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_IMP_RUOLO_PFPG]
		params.addValue("FK_IMP_RUOLO_PFPG", dto.getFkImpRuoloPfpg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_CONTRATTO]
		params.addValue("FK_CONTRATTO", dto.getFkContratto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", dto.getIdAllegato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitRAllegatoCompScDaoImpl::updateColumnsResponsabile] END");
	}

	/**
	 * Restituisce il nome della tabella su cui opera il DAO
	 *
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_ALLEGATO_COMP_SC";
	}

}
