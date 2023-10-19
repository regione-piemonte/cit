package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.AllegatiCompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVSk4ScDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitVSk4ScDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitVSk4Sc.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVSk4ScDao {

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4ScDto> findByCodImpiantoOrdered(Integer input) throws SigitVSk4ScDaoException;

	/** 
	 * Implementazione del finder attiviByCodImpiantoFkPg
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4ScDto> findAttiviByCodImpiantoFkPg(AllegatiCompFilter input)
			throws SigitVSk4ScDaoException;

	/** 
	 * Implementazione del finder attiviByCodImpiantoProgressivi
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4ScDto> findAttiviByCodImpiantoProgressivi(CompFilter input) throws SigitVSk4ScDaoException;

	public List<SigitVSk4ScDto> findByIdAllegatoProgr(CompFilter input) throws SigitVSk4ScDaoException;

	public List<SigitVSk4ScDto> findByIdAllegato(Integer idAllegato) throws SigitVSk4ScDaoException;
}
