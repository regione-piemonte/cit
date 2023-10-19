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
 * Interfaccia pubblica del DAO sigitTAllegato.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTAllegatoDao {

	/**
	 * Metodo di inserimento del DAO sigitTAllegato. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAllegatoPk
	 * @generated
	 */

	public SigitTAllegatoPk insert(SigitTAllegatoDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_ALLEGATO table.
	 * @generated
	 */
	public void update(SigitTAllegatoDto dto) throws SigitTAllegatoDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_ALLEGATO table.
	 * @generated
	 */
	public void updateColumnsRespingiAllegato(SigitTAllegatoDto dto) throws SigitTAllegatoDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_ALLEGATO table.
	 * @generated
	 */

	public void delete(SigitTAllegatoPk pk) throws SigitTAllegatoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_ALLEGATO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAllegatoDto> findAll() throws SigitTAllegatoDaoException;

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAllegatoDto> findByCodiceImpianto(java.lang.Integer input) throws SigitTAllegatoDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_ALLEGATO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTAllegatoDto findByPrimaryKey(SigitTAllegatoPk pk) throws SigitTAllegatoDaoException;

	/** 
		 * Implementazione del finder controlloBollinoAssegnatoAltroImpianto con Qdef
		 * @generated
		 */

	public List<SigitTAllegatoControlloBollinoAssegnatoAltroImpiantoDto> findControlloBollinoAssegnatoAltroImpianto(
			SigitTAllegatoDto input) throws SigitTAllegatoDaoException;

	/** 
		 * Implementazione del finder rappProvaByIdIspezione con Qdef
		 * @generated
		 */

	public List<SigitTAllegatoRappProvaByIdIspezioneDto> findRappProvaByIdIspezione(java.lang.Integer input)
			throws SigitTAllegatoDaoException;

	/** 
		 * Implementazione del finder rappProvaByIdAllegato con Qdef
		 * @generated
		 */

	public List<SigitTAllegatoRappProvaByIdAllegatoDto> findRappProvaByIdAllegato(Integer input)
			throws SigitTAllegatoDaoException;

}
