package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTRappDettaglioDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTRappDettaglioDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/*PROTECTED REGION ID(R-611847473) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTRappDettaglio.
 * Il DAO implementa le seguenti operazioni:
 * - FINDERS:
 * <p>
 * --
 * - UPDATERS:
 * <p>
 * --
 * - DELETERS:
 * - byIdAllegato (datagen::CustomDeleter)
 * <p>
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 *
 * @generated
 */
public class SigitTRappDettaglioDaoImpl extends AbstractDAO implements SigitTRappDettaglioDao {
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
	 * Custom deleter in the SIGIT_T_RAPP_DETTAGLIO table.
	 *
	 * @generated
	 */
	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitTRappDettaglioDaoException {
		LOG.debug("[SigitTRappDettaglioDaoImpl::customDeleterByIdAllegato] START");
		/*PROTECTED REGION ID(R-301652171) ENABLED START*/
		//***scrivere la custom query
		final StringBuilder sql = new StringBuilder("DELETE FROM " + getTableName() + " WHERE ");

		sql.append(" FK_RAPPORTO_CONTROLLO IN");
		sql.append(" (SELECT ID_RAPPORTO_CONTROLLO ");
		sql.append(" FROM SIGIT_T_RAPP_CONTROLLO");
		sql.append(" WHERE FK_ALLEGATO = :idAllegato)");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idAllegato", filter);

		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTRappDettaglioDaoImpl::customDeleterByIdAllegato] END");
	}

	/**
	 * Restituisce il nome della tabella su cui opera il DAO
	 *
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_RAPP_DETTAGLIO";
	}

}
