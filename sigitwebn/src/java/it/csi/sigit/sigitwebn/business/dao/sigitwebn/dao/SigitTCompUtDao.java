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
 * Interfaccia pubblica del DAO sigitTCompUt.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompUtDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompUt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompUtPk
	 * @generated
	 */

	public SigitTCompUtPk insert(SigitTCompUtDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_UT table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompUtDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_UT table.
	 * @generated
	 */
	public void customDeleterByCodImpiantoProgr(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompUtDaoException;

	/** 
	 * Implementazione del finder ByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompUtDto> findByCodImpianto(Integer input) throws SigitTCompUtDaoException;

}
