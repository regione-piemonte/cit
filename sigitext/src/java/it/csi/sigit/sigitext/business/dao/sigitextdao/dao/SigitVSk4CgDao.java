package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVSk4CgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitVSk4CgDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitVSk4Cg.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVSk4CgDao {

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4CgDto> findByCodImpiantoOrdered(Integer input) throws SigitVSk4CgDaoException;

	/** 
	 * Implementazione del finder attiviByCodImpiantoFkPg
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4CgDto> findAttiviByCodImpiantoFkPg(
			it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.AllegatiCompFilter input)
			throws SigitVSk4CgDaoException;

	/** 
	 * Implementazione del finder attiviByCodImpiantoProgressivi
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4CgDto> findAttiviByCodImpiantoProgressivi(
			it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter input) throws SigitVSk4CgDaoException;

	public List<SigitVSk4CgDto> findByIdAllegato(Integer idAllegato) throws SigitVSk4CgDaoException;
}
