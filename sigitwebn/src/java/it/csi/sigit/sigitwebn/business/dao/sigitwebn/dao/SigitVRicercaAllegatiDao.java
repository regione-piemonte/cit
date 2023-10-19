package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import it.csi.sigit.sigitwebn.business.dao.util.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO sigitVRicercaAllegati.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVRicercaAllegatiDao {

	/** 
	 * Restituisce tutte le righe della tabella VISTA_RICERCA_ALLEGATI.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findAll() throws SigitVRicercaAllegatiDaoException;

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findByCodiceImpianto(java.lang.String input)
			throws SigitVRicercaAllegatiDaoException;

	/** 
	 * Implementazione del finder byFiltriUtente
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findByFiltriUtente(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaAllegati input)
			throws SigitVRicercaAllegatiDaoException;

	/** 
	 * Implementazione del finder byIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findByIdAllegato(java.lang.String input)
			throws SigitVRicercaAllegatiDaoException;

	/** 
	 * Implementazione del finder inviatiByCodImpiantoOrderedByData
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findInviatiByCodImpiantoOrderedByData(Integer input)
			throws SigitVRicercaAllegatiDaoException;

	/** 
	 * Implementazione del finder manutByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findManutByCodImpianto(Integer input)
			throws SigitVRicercaAllegatiDaoException;

	/** 
	 * Implementazione del finder reeByCodImpiantoOrderedByData
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiDto> findReeByCodImpiantoOrderedByData(Integer input)
			throws SigitVRicercaAllegatiDaoException;

	/** 
		 * Implementazione del finder byCodiceImpiantoCountVerifiche con Qdef
		 * @generated
		 */

	public List<SigitVRicercaAllegatiByCodiceImpiantoCountVerificheDto> findByCodiceImpiantoCountVerifiche(
			java.lang.String input) throws SigitVRicercaAllegatiDaoException;

}
