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
 * Interfaccia pubblica del DAO sigitRAllegatoCompCg.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRAllegatoCompCgDao {

	/**
	 * Metodo di inserimento del DAO sigitRAllegatoCompCg. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRAllegatoCompCgPk
	 * @generated
	 */

	public SigitRAllegatoCompCgPk insert(SigitRAllegatoCompCgDto dto)

	;

	/** 
	 * Updates selected columns in the SIGIT_R_ALLEGATO_COMP_CG table.
	 * @generated
	 */
	public void updateColumnsResponsabile(SigitRAllegatoCompCgDto dto) throws SigitRAllegatoCompCgDaoException;

	/** 
	 * Deletes a single row in the SIGIT_R_ALLEGATO_COMP_CG table.
	 * @generated
	 */

	public void delete(SigitRAllegatoCompCgPk pk) throws SigitRAllegatoCompCgDaoException;

	/** 
	 * Custom deleter in the SIGIT_R_ALLEGATO_COMP_CG table.
	 * @generated
	 */
	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitRAllegatoCompCgDaoException;

	/** 
	 * Returns all rows from the SIGIT_R_ALLEGATO_COMP_CG table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRAllegatoCompCgDto findByPrimaryKey(SigitRAllegatoCompCgPk pk) throws SigitRAllegatoCompCgDaoException;

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRAllegatoCompCgDto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitRAllegatoCompCgDaoException;

}
