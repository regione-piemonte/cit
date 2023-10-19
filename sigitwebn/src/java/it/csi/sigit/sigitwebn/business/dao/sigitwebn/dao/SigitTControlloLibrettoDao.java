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
 * Interfaccia pubblica del DAO sigitTControlloLibretto.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTControlloLibrettoDao {

	/**
	 * Metodo di inserimento del DAO sigitTControlloLibretto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTControlloLibrettoPk
	 * @generated
	 */

	public SigitTControlloLibrettoPk insert(SigitTControlloLibrettoDto dto)

	;

	/** 
	 * Updates selected columns in the SIGIT_T_CONTROLLO_LIBRETTO table.
	 * @generated
	 */
	public void updateColumnsAggiornaControlloScheda7(SigitTControlloLibrettoDto dto)
			throws SigitTControlloLibrettoDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_CONTROLLO_LIBRETTO table.
	 * @generated
	 */
	public void updateColumnsAggiornaControlloScheda5(SigitTControlloLibrettoDto dto)
			throws SigitTControlloLibrettoDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_CONTROLLO_LIBRETTO table.
	 * @generated
	 */
	public void updateColumnsAggiornaControlloScheda6(SigitTControlloLibrettoDto dto)
			throws SigitTControlloLibrettoDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_CONTROLLO_LIBRETTO table.
	 * @generated
	 */
	public void updateColumnsAggiornaControlloScheda1(SigitTControlloLibrettoDto dto)
			throws SigitTControlloLibrettoDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_CONTROLLO_LIBRETTO table.
	 * @generated
	 */

	public void delete(SigitTControlloLibrettoPk pk) throws SigitTControlloLibrettoDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_CONTROLLO_LIBRETTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTControlloLibrettoDto findByPrimaryKey(SigitTControlloLibrettoPk pk)
			throws SigitTControlloLibrettoDaoException;

}
