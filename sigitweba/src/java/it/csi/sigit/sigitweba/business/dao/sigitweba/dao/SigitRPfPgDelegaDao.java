package it.csi.sigit.sigitweba.business.dao.sigitweba.dao;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.qbe.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.metadata.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import it.csi.sigit.sigitweba.business.dao.util.*;
import it.csi.sigit.sigitweba.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO sigitRPfPgDelega.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRPfPgDelegaDao {

	/**
	 * Metodo di inserimento del DAO sigitRPfPgDelega. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRPfPgDelegaPk
	 * @generated
	 */

	public SigitRPfPgDelegaPk insert(SigitRPfPgDelegaDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_R_PF_PG_DELEGA table.
	 * @generated
	 */
	public void update(SigitRPfPgDelegaDto dto) throws SigitRPfPgDelegaDaoException;

	/** 
	 * Returns all rows from the SIGIT_R_PF_PG_DELEGA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRPfPgDelegaDto findByPrimaryKey(SigitRPfPgDelegaPk pk) throws SigitRPfPgDelegaDaoException;

	/** 
		 * Implementazione del finder byIdPersonaFisica con Qdef
		 * @generated
		 */

	public List<SigitRPfPgDelegaByIdPersonaFisicaDto> findByIdPersonaFisica(java.math.BigDecimal input)
			throws SigitRPfPgDelegaDaoException;

	/** 
		 * Implementazione del finder byCodiceFiscalePF con Qdef
		 * @generated
		 */

	public List<SigitRPfPgDelegaByCodiceFiscalePFDto> findByCodiceFiscalePF(String input)
			throws SigitRPfPgDelegaDaoException;

	/** 
	 * Implementazione del finder attiveAccByIdPersonaGiuridica
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfPgDelegaDto> findAttiveAccByIdPersonaGiuridica(java.math.BigDecimal input)
			throws SigitRPfPgDelegaDaoException;

}
