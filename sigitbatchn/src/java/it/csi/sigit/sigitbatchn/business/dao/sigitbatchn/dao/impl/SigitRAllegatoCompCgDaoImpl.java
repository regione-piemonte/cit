package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.impl;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.mapper.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import it.csi.sigit.sigitbatchn.business.dao.impl.*;
import it.csi.sigit.sigitbatchn.business.dao.util.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R-328767175) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO sigitRAllegatoCompCg.
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
public class SigitRAllegatoCompCgDaoImpl extends AbstractDAO implements SigitRAllegatoCompCgDao {
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
	 * Metodo di inserimento del DAO sigitRAllegatoCompCg. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRAllegatoCompCgPk
	 * @generated
	 */

	public SigitRAllegatoCompCgPk insert(SigitRAllegatoCompCgDto dto)

	{
		LOG.debug("[SigitRAllegatoCompCgDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ALLEGATO,ID_TIPO_COMPONENTE,PROGRESSIVO,CODICE_IMPIANTO,DATA_INSTALL,FK_IMP_RUOLO_PFPG,FK_CONTRATTO ) VALUES (  :ID_ALLEGATO , :ID_TIPO_COMPONENTE , :PROGRESSIVO , :CODICE_IMPIANTO , :DATA_INSTALL , :FK_IMP_RUOLO_PFPG , :FK_CONTRATTO  )";

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

		// valorizzazione paametro relativo a colonna [FK_IMP_RUOLO_PFPG]
		params.addValue("FK_IMP_RUOLO_PFPG", dto.getFkImpRuoloPfpg(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_CONTRATTO]
		params.addValue("FK_CONTRATTO", dto.getFkContratto(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitRAllegatoCompCgDaoImpl::insert] END");
		return dto.createPk();

	}

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_R_ALLEGATO_COMP_CG";
	}

}
