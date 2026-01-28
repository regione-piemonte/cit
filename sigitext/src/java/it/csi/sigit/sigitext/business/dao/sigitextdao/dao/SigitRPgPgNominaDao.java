package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPgPgNominaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRPgPgNominaDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitRPgPgNomina.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRPgPgNominaDao {

	/** 
	 * Implementazione del finder findByPgCat
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPgPgNominaDto> findFindByPgCat(Integer input) throws SigitRPgPgNominaDaoException;
	
	void insert(SigitRPgPgNominaDto dto) throws SigitRPgPgNominaDaoException;
	
	void update(SigitRPgPgNominaDto dto) throws SigitRPgPgNominaDaoException;
	
	List<SigitRPgPgNominaDto> findSigitRPgPgNominaByPgCatAndPG(Integer idPersonaGiuridicaCat, Integer idPersonaGiuridica) throws SigitRPgPgNominaDaoException;

}
