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
 * Interfaccia pubblica del DAO sigitRAllegatoCompGf.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRAllegatoCompGfDao {

	/**
	 * Metodo di inserimento del DAO sigitRAllegatoCompGf. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRAllegatoCompGfPk
	 * @generated
	 */

	public SigitRAllegatoCompGfPk insert(SigitRAllegatoCompGfDto dto)

	;

	/** 
	 * Updates selected columns in the SIGIT_R_ALLEGATO_COMP_GF table.
	 * @generated
	 */
	public void updateColumnsResponsabile(SigitRAllegatoCompGfDto dto) throws SigitRAllegatoCompGfDaoException;

	/** 
	 * Deletes a single row in the SIGIT_R_ALLEGATO_COMP_GF table.
	 * @generated
	 */

	public void delete(SigitRAllegatoCompGfPk pk) throws SigitRAllegatoCompGfDaoException;

	/** 
	 * Custom deleter in the SIGIT_R_ALLEGATO_COMP_GF table.
	 * @generated
	 */
	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitRAllegatoCompGfDaoException;

	/** 
	 * Returns all rows from the SIGIT_R_ALLEGATO_COMP_GF table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRAllegatoCompGfDto findByPrimaryKey(SigitRAllegatoCompGfPk pk) throws SigitRAllegatoCompGfDaoException;

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRAllegatoCompGfDto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitRAllegatoCompGfDaoException;

}
