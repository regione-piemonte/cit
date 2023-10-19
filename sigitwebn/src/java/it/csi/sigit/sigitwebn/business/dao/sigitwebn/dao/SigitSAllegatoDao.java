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
 * Interfaccia pubblica del DAO sigitSAllegato.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitSAllegatoDao {

	/**
	 * Metodo di inserimento del DAO sigitSAllegato. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitSAllegatoPk
	 * @generated
	 */

	public SigitSAllegatoPk insert(SigitSAllegatoDto dto)

	;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_S_ALLEGATO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitSAllegatoDto> findAll() throws SigitSAllegatoDaoException;

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitSAllegatoDto> findByCodiceImpianto(java.lang.Integer input) throws SigitSAllegatoDaoException;

	/** 
	 * Returns all rows from the SIGIT_S_ALLEGATO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitSAllegatoDto findByPrimaryKey(SigitSAllegatoPk pk) throws SigitSAllegatoDaoException;

}
