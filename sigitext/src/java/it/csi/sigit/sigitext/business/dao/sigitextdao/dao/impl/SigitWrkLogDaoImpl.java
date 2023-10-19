package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitWrkLogDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitWrkLogDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitWrkLogPk;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/*PROTECTED REGION ID(R-1806529981) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitWrkLog.
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
public class SigitWrkLogDaoImpl extends AbstractDAO implements SigitWrkLogDao {
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
	 * Metodo di inserimento del DAO sigitWrkLog. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitWrkLogPk
	 * @generated
	 */

	public SigitWrkLogPk insert(SigitWrkLogDto dto)

	{
		LOG.debug("[SigitWrkLogDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_FISCALE,DATA_OPERAZIONE,TBL_IMPATTATA,ID_RECORD,TIPO_OPERAZIONE,ID_LOG ) VALUES (  :CODICE_FISCALE , :DATA_OPERAZIONE , :TBL_IMPATTATA , :ID_RECORD , :TIPO_OPERAZIONE , :ID_LOG  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_OPERAZIONE]
		params.addValue("DATA_OPERAZIONE", dto.getDataOperazione(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [TBL_IMPATTATA]
		params.addValue("TBL_IMPATTATA", dto.getTblImpattata(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_RECORD]
		params.addValue("ID_RECORD", dto.getIdRecord(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TIPO_OPERAZIONE]
		params.addValue("TIPO_OPERAZIONE", dto.getTipoOperazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_LOG]
		params.addValue("ID_LOG", newKey, java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdLog(newKey);
		LOG.debug("[SigitWrkLogDaoImpl::insert] END");
		return dto.createPk();

	}

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_WRK_LOG";
	}

}
