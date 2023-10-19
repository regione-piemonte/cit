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
 * Interfaccia pubblica del DAO sigitTAbilitazione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTAbilitazioneDao {

	/**
	 * Metodo di inserimento del DAO sigitTAbilitazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAbilitazionePk
	 * @generated
	 */

	public SigitTAbilitazionePk insert(SigitTAbilitazioneDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_ABILITAZIONE table.
	 * @generated
	 */
	public void update(SigitTAbilitazioneDto dto) throws SigitTAbilitazioneDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_ABILITAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTAbilitazioneDto findByPrimaryKey(SigitTAbilitazionePk pk) throws SigitTAbilitazioneDaoException;

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAbilitazioneDto> findByExample(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAbilitazioneDto input)
			throws SigitTAbilitazioneDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_ABILITAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAbilitazioneDto> findAll() throws SigitTAbilitazioneDaoException;

	/** 
	 * Implementazione del finder comboIstatAbilitazione
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAbilitazioneDto> findComboIstatAbilitazione(java.lang.Integer input)
			throws SigitTAbilitazioneDaoException;

}
