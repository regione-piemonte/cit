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
 * Interfaccia pubblica del DAO sigitRAllegatoCompGt.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRAllegatoCompGtDao {

	/**
	 * Metodo di inserimento del DAO sigitRAllegatoCompGt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRAllegatoCompGtPk
	 * @generated
	 */

	public SigitRAllegatoCompGtPk insert(SigitRAllegatoCompGtDto dto)

	;

	/** 
	 * Updates selected columns in the SIGIT_R_ALLEGATO_COMP_GT table.
	 * @generated
	 */
	public void updateColumnsResponsabile(SigitRAllegatoCompGtDto dto) throws SigitRAllegatoCompGtDaoException;

	/** 
	 * Deletes a single row in the SIGIT_R_ALLEGATO_COMP_GT table.
	 * @generated
	 */

	public void delete(SigitRAllegatoCompGtPk pk) throws SigitRAllegatoCompGtDaoException;

	/** 
	 * Custom deleter in the SIGIT_R_ALLEGATO_COMP_GT table.
	 * @generated
	 */
	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitRAllegatoCompGtDaoException;

	/** 
	 * Returns all rows from the SIGIT_R_ALLEGATO_COMP_GT table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRAllegatoCompGtDto findByPrimaryKey(SigitRAllegatoCompGtPk pk) throws SigitRAllegatoCompGtDaoException;

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRAllegatoCompGtDto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitRAllegatoCompGtDaoException;

}
