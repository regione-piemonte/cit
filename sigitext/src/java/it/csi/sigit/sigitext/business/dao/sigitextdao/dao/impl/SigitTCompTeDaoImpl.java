package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTCompTeDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompTeDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompTePk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompTeDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/*PROTECTED REGION ID(R803849177) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTCompTe.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 
 *    --
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 *   - ByCodImpianto (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTCompTeDaoImpl extends AbstractDAO implements SigitTCompTeDao {
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
	 * Metodo di inserimento del DAO sigitTCompTe. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompTePk
	 * @generated
	 */

	public SigitTCompTePk insert(SigitTCompTeDto dto)

	{
		LOG.debug("[SigitTCompTeDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,CAPACITA_L,NUM_VENTILATORI,TIPO_VENTILATORI ) VALUES (  :CODICE_IMPIANTO , :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :CAPACITA_L , :NUM_VENTILATORI , :TIPO_VENTILATORI  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [CAPACITA_L]
		params.addValue("CAPACITA_L", dto.getCapacitaL(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [NUM_VENTILATORI]
		params.addValue("NUM_VENTILATORI", dto.getNumVentilatori(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [TIPO_VENTILATORI]
		params.addValue("TIPO_VENTILATORI", dto.getTipoVentilatori(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTCompTeDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_TE table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompTeDaoException {
		LOG.debug("[SigitTCompTeDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R-197558556) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompTeDaoImpl::customDeleterByCodImpianto] END");
	}

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_COMP_TE";
	}

}
