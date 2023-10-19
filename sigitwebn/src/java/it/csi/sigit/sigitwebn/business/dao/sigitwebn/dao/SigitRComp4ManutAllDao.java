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
 * Interfaccia pubblica del DAO sigitRComp4ManutAll.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRComp4ManutAllDao {

	/**
	 * Metodo di inserimento del DAO sigitRComp4ManutAll. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRComp4ManutAllPk
	 * @generated
	 */

	public SigitRComp4ManutAllPk insert(SigitRComp4ManutAllDto dto)

	;

	/** 
	 * Deletes a single row in the SIGIT_R_COMP4MANUT_ALL table.
	 * @generated
	 */

	public void delete(SigitRComp4ManutAllPk pk) throws SigitRComp4ManutAllDaoException;

	/** 
	 * Custom deleter in the SIGIT_R_COMP4MANUT_ALL table.
	 * @generated
	 */
	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitRComp4ManutAllDaoException;

	/** 
	 * Implementazione del finder byComp
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRComp4ManutAllDto> findByComp(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitRComp4ManutAllDaoException;

}
