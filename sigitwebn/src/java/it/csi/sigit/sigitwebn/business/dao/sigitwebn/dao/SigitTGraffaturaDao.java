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
 * Interfaccia pubblica del DAO SigitTGraffatura.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTGraffaturaDao {

	/**
	 * Metodo di inserimento del DAO SigitTGraffatura. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTGraffaturaPk
	 * @generated
	 */

	public SigitTGraffaturaPk insert(SigitTGraffaturaDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_GRAFFATURA table.
	 * @generated
	 */
	public void update(SigitTGraffaturaDto dto) throws SigitTGraffaturaDaoException;

	/** 
	 * Implementazione del finder byCodiceImpiantoInattivo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTGraffaturaDto> findByCodiceImpiantoInattivo(java.lang.Integer input)
			throws SigitTGraffaturaDaoException;

	/** 
	 * Implementazione del finder byCodiceImpiantoAttivo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTGraffaturaDto> findByCodiceImpiantoAttivo(java.lang.Integer input)
			throws SigitTGraffaturaDaoException;

	/** 
	 * Implementazione del finder byIdGraffatura
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTGraffaturaDto> findByIdGraffatura(java.lang.Integer input) throws SigitTGraffaturaDaoException;

}
