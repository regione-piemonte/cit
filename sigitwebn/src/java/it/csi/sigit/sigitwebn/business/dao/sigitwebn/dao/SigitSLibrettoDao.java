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
 * Interfaccia pubblica del DAO sigitSLibretto.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitSLibrettoDao {

	/**
	 * Metodo di inserimento del DAO sigitSLibretto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitSLibrettoPk
	 * @generated
	 */

	public SigitSLibrettoPk insert(SigitSLibrettoDto dto)

	;

	/** 
	 * Custom updater in the SIGIT_S_LIBRETTO table.
	 * @generated
	 */
	public void customUpdaterStoricizzaByCodImpianto(SigitSLibrettoDto filter, java.lang.Object value)
			throws SigitSLibrettoDaoException;

	/** 
	 * Deletes a single row in the SIGIT_S_LIBRETTO table.
	 * @generated
	 */

	public void delete(SigitSLibrettoPk pk) throws SigitSLibrettoDaoException;

	/** 
	 * Implementazione del finder daCancellare
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitSLibrettoDto> findDaCancellare(java.lang.Integer input) throws SigitSLibrettoDaoException;

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitSLibrettoDto> findByCodiceImpianto(java.lang.Integer input) throws SigitSLibrettoDaoException;

	/** 
		 * Implementazione del finder byCodiceImpiantoNonBozza con Qdef
		 * @generated
		 */

	public List<SigitSLibrettoByCodiceImpiantoNonBozzaDto> findByCodiceImpiantoNonBozza(java.lang.Integer input)
			throws SigitSLibrettoDaoException;

	/** 
	 * Implementazione del finder byLibrettoFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitSLibrettoDto> findByLibrettoFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.LibrettoFilter input)
			throws SigitSLibrettoDaoException;

}
