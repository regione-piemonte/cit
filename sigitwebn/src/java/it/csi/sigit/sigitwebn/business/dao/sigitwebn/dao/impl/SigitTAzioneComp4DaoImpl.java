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

/*PROTECTED REGION ID(R1781571887) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitTAzioneComp4.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 
 *    --
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 *   - byComp4 (datagen::CustomDeleter)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SigitTAzioneComp4DaoImpl extends AbstractDAO implements SigitTAzioneComp4Dao {
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
	 * Metodo di inserimento del DAO sigitTAzioneComp4. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAzioneComp4Pk
	 * @generated
	 */

	public SigitTAzioneComp4Pk insert(SigitTAzioneComp4Dto dto)

	{
		LOG.debug("[SigitTAzioneComp4DaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	CODICE_IMPIANTO,ID_TIPO_COMPONENTE,PROGRESSIVO,DT_INSTALL,DT_AZIONE,CF_UTENTE_AZIONE,DESCRIZIONE_AZIONE ) VALUES (  :CODICE_IMPIANTO , :ID_TIPO_COMPONENTE , :PROGRESSIVO , :DT_INSTALL , :DT_AZIONE , :CF_UTENTE_AZIONE , :DESCRIZIONE_AZIONE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_IMPIANTO]
		params.addValue("CODICE_IMPIANTO", dto.getCodiceImpianto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_COMPONENTE]
		params.addValue("ID_TIPO_COMPONENTE", dto.getIdTipoComponente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DT_INSTALL]
		params.addValue("DT_INSTALL", dto.getDtInstall(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DT_AZIONE]
		params.addValue("DT_AZIONE", dto.getDtAzione(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [CF_UTENTE_AZIONE]
		params.addValue("CF_UTENTE_AZIONE", dto.getCfUtenteAzione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DESCRIZIONE_AZIONE]
		params.addValue("DESCRIZIONE_AZIONE", dto.getDescrizioneAzione(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTAzioneComp4DaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Custom deleter in the SIGIT_T_AZIONE_COMP4 table.
	 * @generated
	 */
	public void customDeleterByComp4(it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTComp4Pk filter)
			throws SigitTAzioneComp4DaoException {
		LOG.debug("[SigitTAzioneComp4DaoImpl::customDeleterByComp4] START");
		/*PROTECTED REGION ID(R36163953) ENABLED START*/
		//***scrivere la custom query
		final StringBuilder sql = new StringBuilder("DELETE FROM " + getTableName() + " WHERE ");

		sql.append(" CODICE_IMPIANTO = :codImpianto");
		sql.append(" AND ID_TIPO_COMPONENTE = :tipoComponente");
		sql.append(" AND PROGRESSIVO = :progressivo");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codImpianto", filter.getCodiceImpianto());
		params.addValue("tipoComponente", filter.getIdTipoComponente());
		params.addValue("progressivo", filter.getProgressivo());

		/*PROTECTED REGION END*/

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SigitTAzioneComp4DaoImpl::customDeleterByComp4] END");
	}

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_T_AZIONE_COMP4";
	}

}
