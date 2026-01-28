package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTAzioneContrattoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzioneContrattoDto;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

public class SigitTAzioneContrattoDaoImpl extends AbstractDAO implements SigitTAzioneContrattoDao {
	
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

	@Override
	public void insert(SigitTAzioneContrattoDto dto) throws SigitextException {
		LOG.debug("[SigitTAzioneContrattoDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	id_contratto,dt_azione,cf_utente_azione,descrizione_azione,old_data_fine ) VALUES (  :id_contratto , :dt_azione , :cf_utente_azione , :descrizione_azione , :old_data_fine  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("id_contratto", dto.getId_contratto(), java.sql.Types.NUMERIC);

		params.addValue("cf_utente_azione", dto.getCf_utente_azione(), java.sql.Types.VARCHAR);

		params.addValue("old_data_fine", dto.getOld_data_fine(), java.sql.Types.DATE);

		params.addValue("dt_azione", dto.getDt_azione(), java.sql.Types.TIMESTAMP);

		params.addValue("descrizione_azione", dto.getDescrizione_azione(), java.sql.Types.VARCHAR);


		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SigitTAzioneContrattoDaoImpl::insert] END");
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "sigit_t_azione_contratto";
	}

}
