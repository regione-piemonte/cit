package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTCompUtDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompUtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompUtPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompUtDaoException;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/*PROTECTED REGION ID(R-239222859) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTCompUt.
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
public class SigitTCompUtDaoImpl extends AbstractDAO implements SigitTCompUtDao {
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
	 * Metodo di inserimento del DAO sigitTCompUt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompUtPk
	 * @generated
	 */

	public SigitTCompUtPk insert(SigitTCompUtDto dto)

	{
		LOG.debug("[SigitTCompUtDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DATA_INSTALL,PORTATA_MANDATA_LS,PORTATA_RIPRESA_LS,POTENZA_MANDATA_KW,POTENZA_RIPRESA_KW ) VALUES (  :CODICE_IMPIANTO , :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DATA_INSTALL , :PORTATA_MANDATA_LS , :PORTATA_RIPRESA_LS , :POTENZA_MANDATA_KW , :POTENZA_RIPRESA_KW  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSTALL]
		params.addValue("DATA_INSTALL", dto.getDataInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [PORTATA_MANDATA_LS]
		params.addValue("PORTATA_MANDATA_LS", dto.getPortataMandataLs(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [PORTATA_RIPRESA_LS]
		params.addValue("PORTATA_RIPRESA_LS", dto.getPortataRipresaLs(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [POTENZA_MANDATA_KW]
		params.addValue("POTENZA_MANDATA_KW", dto.getPotenzaMandataKw(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [POTENZA_RIPRESA_KW]
		params.addValue("POTENZA_RIPRESA_KW", dto.getPotenzaRipresaKw(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTCompUtDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Custom deleter in the SIGIT_T_COMP_UT table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompUtDaoException {
		LOG.debug("[SigitTCompUtDaoImpl::customDeleterByCodImpianto] START");
		/*PROTECTED REGION ID(R-269566858) ENABLED START*/
		//***scrivere la custom query
		final String sql = "DELETE FROM " + getTableName() + " WHERE CODICE_IMPIANTO = :codImpianto";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter, java.sql.Types.NUMERIC);
		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTCompUtDaoImpl::customDeleterByCodImpianto] END");
	}

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_COMP_UT";
	}

}
