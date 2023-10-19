package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.ControlloDisponibileDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTComp4Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTComp4Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTComp4DaoException;

import java.util.Date;
import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTComp4.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTComp4Dao {
	public SigitTComp4Pk insert(SigitTComp4Dto dto);

	public void customDeleterByCodImpianto(Integer filter) throws SigitTComp4DaoException;

	public void update(SigitTComp4Dto dto) throws SigitTComp4DaoException;

	public SigitTComp4Dto findByPrimaryKey(SigitTComp4Pk pk) throws SigitTComp4DaoException;

	public void delete(SigitTComp4Pk pk) throws SigitTComp4DaoException;

	public List<ControlloDisponibileDto> getControlliDisponibili(String codiceImpianto,String idTipoComp, Date dataRapporto, Integer idPersonaGiuridica) throws SigitTComp4DaoException;

	List<SigitTComp4Dto> getAllOrderedByProgrDesc(String codiceImpianto, String tipoComponente) throws SigitTComp4DaoException;

	public List<SigitTComp4Dto> findComponentiCancellate(CompFilter input) throws SigitTComp4DaoException;

	public List<SigitTComp4Dto> findNonControllateByCodImp(Integer input) throws SigitTComp4DaoException;
}
