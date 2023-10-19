package it.csi.sigit.sigitweba.business.dao.sigitweba.dao.impl;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.mapper.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.qbe.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.metadata.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import it.csi.sigit.sigitweba.business.dao.impl.*;
import it.csi.sigit.sigitweba.business.dao.util.*;
import it.csi.sigit.sigitweba.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R-77017361) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTStoricoVarStatoPg.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 
 *    --
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTStoricoVarStatoPgDaoImpl extends AbstractDAO implements SigitTStoricoVarStatoPgDao {
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
	 * Metodo di inserimento del DAO sigitTStoricoVarStatoPg. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTStoricoVarStatoPgPk
	 * @generated
	 */

	public SigitTStoricoVarStatoPgPk insert(SigitTStoricoVarStatoPgDto dto)

	{
		LOG.debug("[SigitTStoricoVarStatoPgDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	DT_EVENTO,ID_PERSONA_GIURIDICA,DT_INIZIO_VARIAZIONE,MOTIVO,STATO_PG_DA,STATO_PG_A,DATA_ULT_MOD,UTENTE_ULT_MOD ) VALUES (  :DT_EVENTO , :ID_PERSONA_GIURIDICA , :DT_INIZIO_VARIAZIONE , :MOTIVO , :STATO_PG_DA , :STATO_PG_A , :DATA_ULT_MOD , :UTENTE_ULT_MOD  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DT_EVENTO]
		params.addValue("DT_EVENTO", dto.getDtEvento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [ID_PERSONA_GIURIDICA]
		params.addValue("ID_PERSONA_GIURIDICA", dto.getIdPersonaGiuridica(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_INIZIO_VARIAZIONE]
		params.addValue("DT_INIZIO_VARIAZIONE", dto.getDtInizioVariazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [MOTIVO]
		params.addValue("MOTIVO", dto.getMotivo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [STATO_PG_DA]
		params.addValue("STATO_PG_DA", dto.getStatoPgDa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [STATO_PG_A]
		params.addValue("STATO_PG_A", dto.getStatoPgA(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_ULT_MOD]
		params.addValue("DATA_ULT_MOD", dto.getDataUltMod(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [UTENTE_ULT_MOD]
		params.addValue("UTENTE_ULT_MOD", dto.getUtenteUltMod(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTStoricoVarStatoPgDaoImpl::insert] END");
		return dto.createPk();

	}

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_STORICO_VAR_STATO_PG";
	}

}
