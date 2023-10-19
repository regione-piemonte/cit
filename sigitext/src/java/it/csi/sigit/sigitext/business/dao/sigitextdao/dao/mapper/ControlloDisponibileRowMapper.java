package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.mapper;

import it.csi.sigit.sigitext.business.dao.impl.BaseDaoRowMapper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTComp4Dao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.impl.SigitTComp4DaoImpl;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.ControlloDisponibileDto;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SigitTComp4Dao
 *
 * @generated
 */
public class ControlloDisponibileRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	SigitTComp4DaoImpl dao;
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);

	public ControlloDisponibileRowMapper(String[] columnsToRead, Class dtoClass, SigitTComp4Dao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SigitTComp4DaoImpl) dao;
	}

	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof ControlloDisponibileDto) {
			return mapRow_internal((ControlloDisponibileDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public ControlloDisponibileDto mapRow_internal(ControlloDisponibileDto objectToFill, ResultSet rs, int row) throws SQLException {
		ControlloDisponibileDto dto = objectToFill;
		dto.setIdRComp4Manut(rs.getBigDecimal("ID_R_COMP4_MANUT"));
		dto.setIdTipoComponente(rs.getString("ID_TIPO_COMPONENTE"));
		dto.setProgressivo(rs.getBigDecimal("PROGRESSIVO"));
		dto.setFkPersonaGiuridica(rs.getBigDecimal("FK_PERSONA_GIURIDICA"));
		dto.setDescMarca(rs.getString("DES_MARCA"));
		dto.setModello(rs.getString("MODELLO"));
		dto.setMatricola(rs.getString("MATRICOLA"));
		dto.setPotTermica(rs.getInt("POTENZA_TERMICA_KW"));
		dto.setDataInstall(rs.getDate("DATA_INSTALL"));
		switch (dto.getIdTipoComponente()) {
			case it.csi.sigit.sigitext.business.util.Constants.TIPO_COMPONENTE_GT:
				dto.setDescDettaglio(rs.getString("DES_DETTAGLIO_GT"));
				dto.setDescCombustibile(rs.getString("DES_COMBUSTIBILE"));
				dto.setnModuli(rs.getInt("N_MODULI"));
				break;
			case it.csi.sigit.sigitext.business.util.Constants.TIPO_COMPONENTE_GF:
				dto.setDescDettaglio(rs.getString("DES_DETTAGLIO_GF"));
				dto.setPotTermicaRaff(rs.getInt("raff_potenza_kw"));
				dto.setPotTermicaRisc(rs.getInt("risc_potenza_kw"));
				dto.setnModuli(rs.getInt("N_CIRCUITI"));
				break;
			case it.csi.sigit.sigitext.business.util.Constants.TIPO_COMPONENTE_CG:
				dto.setCoMin(rs.getInt("CO_MIN"));
				dto.setCoMax(rs.getInt("CO_MAX"));
				dto.setAlimentazione(rs.getString("ALIMENTAZIONE"));
				dto.setDescDettaglio(rs.getString("TIPOLOGIA"));
				break;
		}
		dto.setCfPIvaImpresa(rs.getString("CODICE_FISCALE"));
		dto.setSiglaReaImpresa(rs.getString("SIGLA_REA"));
		dto.setNumeroReaImpresa(rs.getString("NUMERO_REA"));

		return dto;
	}

}
