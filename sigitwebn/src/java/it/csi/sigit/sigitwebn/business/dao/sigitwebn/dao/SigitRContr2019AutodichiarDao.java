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
 * Interfaccia pubblica del DAO sigitRContr2019Autodichiar.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRContr2019AutodichiarDao {

	/**
	 * Metodo di inserimento del DAO sigitRContr2019Autodichiar. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRContr2019AutodichiarPk
	 * @generated
	 */

	public SigitRContr2019AutodichiarPk insert(SigitRContr2019AutodichiarDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_R_CONTR2019_AUTODICHIAR table.
	 * @generated
	 */
	public void update(SigitRContr2019AutodichiarDto dto) throws SigitRContr2019AutodichiarDaoException;

	/** 
	 * Deletes a single row in the SIGIT_R_CONTR2019_AUTODICHIAR table.
	 * @generated
	 */

	public void delete(SigitRContr2019AutodichiarPk pk) throws SigitRContr2019AutodichiarDaoException;

	/** 
	 * Returns all rows from the SIGIT_R_CONTR2019_AUTODICHIAR table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRContr2019AutodichiarDto findByPrimaryKey(SigitRContr2019AutodichiarPk pk)
			throws SigitRContr2019AutodichiarDaoException;

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRContr2019AutodichiarDto> findByExample(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRContr2019AutodichiarDto input)
			throws SigitRContr2019AutodichiarDaoException;

	/** 
		 * Implementazione del finder byExampleExtended con Qdef
		 * @generated
		 */

	public List<SigitRContr2019AutodichiarByExampleExtendedDto> findByExampleExtended(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRContr2019AutodichiarDto input)
			throws SigitRContr2019AutodichiarDaoException;

}
