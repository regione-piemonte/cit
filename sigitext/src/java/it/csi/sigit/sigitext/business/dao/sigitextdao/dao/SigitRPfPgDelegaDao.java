package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfPgDelegaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfPgDelegaFindByPfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRPfPgDelegaDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitRPfPgDelega.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRPfPgDelegaDao {

	/** 
		 * Implementazione del finder findByPf con Qdef
		 * @generated
		 */

	public List<SigitRPfPgDelegaFindByPfDto> findFindByPf(Integer input) throws SigitRPfPgDelegaDaoException;
	public List<SigitRPfPgDelegaDto> findFindByPg(Integer input) throws SigitRPfPgDelegaDaoException;
	List<SigitRPfPgDelegaDto> findByPfAndPg(Integer idPersonaFisica, Integer idPersonaGiuridica) throws SigitRPfPgDelegaDaoException;
	void insert(SigitRPfPgDelegaDto dto) throws SigitRPfPgDelegaDaoException;
	List<SigitRPfPgDelegaDto> findFindByIdPersonaFisica(Integer input) throws SigitRPfPgDelegaDaoException;
	void update(SigitRPfPgDelegaDto dto) throws SigitRPfPgDelegaDaoException;
}
