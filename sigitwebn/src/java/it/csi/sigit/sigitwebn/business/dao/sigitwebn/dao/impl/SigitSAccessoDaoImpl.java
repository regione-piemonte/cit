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

/*PROTECTED REGION ID(R-1119587697) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitSAccesso.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 
 *    --
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 *   - Old (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitSAccessoDaoImpl extends AbstractDAO implements SigitSAccessoDao {
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
	 * Metodo di inserimento del DAO sigitSAccesso. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitSAccessoPk
	 * @generated
	 */

	public SigitSAccessoPk insert(SigitSAccessoDto dto)

	{
		LOG.debug("[SigitSAccessoDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	DT_ACCESSO,CODICE_FISCALE,NOME,COGNOME,RUOLO ) VALUES (  :DT_ACCESSO , :CODICE_FISCALE , :NOME , :COGNOME , :RUOLO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DT_ACCESSO]
		params.addValue("DT_ACCESSO", dto.getDtAccesso(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOME]
		params.addValue("NOME", dto.getNome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COGNOME]
		params.addValue("COGNOME", dto.getCognome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [RUOLO]
		params.addValue("RUOLO", dto.getRuolo(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitSAccessoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Custom deleter in the SIGIT_S_ACCESSO table.
	 * @generated
	 */
	public void customDeleterOld(java.lang.Integer filter) throws SigitSAccessoDaoException {
		LOG.debug("[SigitSAccessoDaoImpl::customDeleterOld] START");
		/*PROTECTED REGION ID(R-1543465227) ENABLED START*/
		//***scrivere la custom query
		final StringBuffer sql = new StringBuffer("DELETE FROM " + getTableName() + " sAccesso WHERE ");
		MapSqlParameterSource params = new MapSqlParameterSource();

		sql.append(" EXISTS ");
		sql.append(" (SELECT 1 FROM SIGIT_S_ACCESSO sAccesso2 ");
		sql.append(
				" WHERE sAccesso.DT_ACCESSO = sAccesso2.DT_ACCESSO AND sAccesso.CODICE_FISCALE = sAccesso2.CODICE_FISCALE ");
		sql.append(" AND DATE_PART('year', DT_ACCESSO) < (DATE_PART('year', now()) - 4) ");
		sql.append(" ORDER BY DT_ACCESSO ASC ");
		sql.append(
				" LIMIT (SELECT VALORE_CONFIG_NUM FROM SIGIT_WRK_CONFIG WHERE CHIAVE_CONFIG='MAX_RECORDS_STORICIZZAZIONE')) ");
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitSAccessoDaoImpl::customDeleterOld] END");
	}

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_S_ACCESSO";
	}

}
