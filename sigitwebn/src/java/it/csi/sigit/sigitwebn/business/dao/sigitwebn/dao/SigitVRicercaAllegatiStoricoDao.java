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
 * Interfaccia pubblica del DAO sigitVRicercaAllegatiStorico.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVRicercaAllegatiStoricoDao {

	/** 
	 * Restituisce tutte le righe della tabella VISTA_RICERCA_ALLEGATI_STORICO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiStoricoDto> findAll() throws SigitVRicercaAllegatiStoricoDaoException;

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiStoricoDto> findByCodiceImpianto(java.lang.String input)
			throws SigitVRicercaAllegatiStoricoDaoException;

	/** 
	 * Implementazione del finder byFiltriUtente
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiStoricoDto> findByFiltriUtente(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaAllegati input)
			throws SigitVRicercaAllegatiStoricoDaoException;

	/** 
	 * Implementazione del finder byIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiStoricoDto> findByIdAllegato(java.lang.String input)
			throws SigitVRicercaAllegatiStoricoDaoException;

	/** 
	 * Implementazione del finder inviatiByCodImpiantoOrderedByData
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiStoricoDto> findInviatiByCodImpiantoOrderedByData(Integer input)
			throws SigitVRicercaAllegatiStoricoDaoException;

	/** 
	 * Implementazione del finder manutByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiStoricoDto> findManutByCodImpianto(Integer input)
			throws SigitVRicercaAllegatiStoricoDaoException;

	/** 
	 * Implementazione del finder reeByCodImpiantoOrderedByData
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaAllegatiStoricoDto> findReeByCodImpiantoOrderedByData(Integer input)
			throws SigitVRicercaAllegatiStoricoDaoException;

}
