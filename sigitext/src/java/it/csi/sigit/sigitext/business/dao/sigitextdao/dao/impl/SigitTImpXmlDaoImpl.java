package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTImpXmlDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImpXmlDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImpXmlPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTImpXmlDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/*PROTECTED REGION ID(R-267459537) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTImpXml.
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
public class SigitTImpXmlDaoImpl extends AbstractDAO implements SigitTImpXmlDao {
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
	 * Metodo di inserimento del DAO sigitTImpXml. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 *
	 * @param dto
	 * @return SigitTImpXmlPk
	 * @generated
	 */

	public SigitTImpXmlPk insert(SigitTImpXmlDto dto) {
		LOG.debug("[SigitTImpXmlDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName() + " ( 	ID_IMPORT,FILE_IMPORT ) VALUES (  :ID_IMPORT , :FILE_IMPORT  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_IMPORT]
		params.addValue("ID_IMPORT", dto.getIdImport(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FILE_IMPORT]
		params.addValue("FILE_IMPORT", dto.getFileImport(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTImpXmlDaoImpl::insert] END");
		return dto.createPk();
	}

	public void customDeleterByIdImport(java.lang.Integer filter) throws SigitTImpXmlDaoException {
		LOG.debug("[SigitTImpXmlDaoImpl::customDeleterByIdImport] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_IMPORT = :idImport";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idImport", filter);
		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTImpXmlDaoImpl::customDeleterByIdImport] END");
	}

	/**
	 * Restituisce il nome della tabella su cui opera il DAO
	 *
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_IMP_XML";
	}

}
