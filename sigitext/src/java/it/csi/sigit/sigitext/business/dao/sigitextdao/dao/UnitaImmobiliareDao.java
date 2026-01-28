package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.UnitaImmobiliareDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.UnitaImmobiliareDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO UnitaImmobiliare.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface UnitaImmobiliareDao {

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<UnitaImmobiliareDto> findByCodiceImpianto(Integer input) throws UnitaImmobiliareDaoException, UnitaImmobiliareDaoException;
	
	
	@SuppressWarnings("unchecked")
	public UnitaImmobiliareDto findPrincipaleByCodiceImpianto(Integer input) throws UnitaImmobiliareDaoException, UnitaImmobiliareDaoException;

	/** 
	 * Implementazione del finder byPod
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<UnitaImmobiliareDto> findByPod(String input) throws UnitaImmobiliareDaoException;

	/** 
	 * Implementazione del finder byPdr
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<UnitaImmobiliareDto> findByPdr(String input) throws UnitaImmobiliareDaoException;

}
