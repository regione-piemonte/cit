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
 * Interfaccia pubblica del DAO sigitRPfRuoloPa.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRPfRuoloPaDao {

	/**
	 * Metodo di inserimento del DAO sigitRPfRuoloPa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRPfRuoloPaPk
	 * @generated
	 */

	public SigitRPfRuoloPaPk insert(SigitRPfRuoloPaDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_R_PF_RUOLO_PA table.
	 * @generated
	 */
	public void update(SigitRPfRuoloPaDto dto) throws SigitRPfRuoloPaDaoException;

	/** 
	 * Updates selected columns in the SIGIT_R_PF_RUOLO_PA table.
	 * @generated
	 */
	public void updateColumnsCessaAbilitazione(SigitRPfRuoloPaDto dto) throws SigitRPfRuoloPaDaoException;

	/** 
	 * Returns all rows from the SIGIT_R_PF_RUOLO_PA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRPfRuoloPaDto findByPrimaryKey(SigitRPfRuoloPaPk pk) throws SigitRPfRuoloPaDaoException;

	/** 
		 * Implementazione del finder ByExample con Qdef
		 * @generated
		 */

	public List<SigitRPfRuoloPaByExampleDto> findByExample(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPfRuoloPaDto input)
			throws SigitRPfRuoloPaDaoException;

	/** 
		 * Implementazione del finder allActive con Qdef
		 * @generated
		 */

	public List<SigitRPfRuoloPaAllActiveDto> findAllActive(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPfRuoloPaDto input)
			throws SigitRPfRuoloPaDaoException;

	/** 
	 * Implementazione del finder allActiveDistinctIstatAbilitazioni
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfRuoloPaDto> findAllActiveDistinctIstatAbilitazioni(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPfRuoloPaDto input)
			throws SigitRPfRuoloPaDaoException;

	/** 
	 * Implementazione del finder allByIstatValidatore
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfRuoloPaDto> findAllByIstatValidatore(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPfRuoloPaDto input)
			throws SigitRPfRuoloPaDaoException;

}
