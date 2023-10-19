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
 * Interfaccia pubblica del DAO sigitRAllegatoCompSc.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRAllegatoCompScDao {

	/**
	 * Metodo di inserimento del DAO sigitRAllegatoCompSc. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRAllegatoCompScPk
	 * @generated
	 */

	public SigitRAllegatoCompScPk insert(SigitRAllegatoCompScDto dto)

	;

	/** 
	 * Updates selected columns in the SIGIT_R_ALLEGATO_COMP_SC table.
	 * @generated
	 */
	public void updateColumnsResponsabile(SigitRAllegatoCompScDto dto) throws SigitRAllegatoCompScDaoException;

	/** 
	 * Deletes a single row in the SIGIT_R_ALLEGATO_COMP_SC table.
	 * @generated
	 */

	public void delete(SigitRAllegatoCompScPk pk) throws SigitRAllegatoCompScDaoException;

	/** 
	 * Custom deleter in the SIGIT_R_ALLEGATO_COMP_SC table.
	 * @generated
	 */
	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitRAllegatoCompScDaoException;

	/** 
	 * Returns all rows from the SIGIT_R_ALLEGATO_COMP_SC table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRAllegatoCompScDto findByPrimaryKey(SigitRAllegatoCompScPk pk) throws SigitRAllegatoCompScDaoException;

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRAllegatoCompScDto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitRAllegatoCompScDaoException;

}
