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
 * Interfaccia pubblica del DAO sigitTCodiceBoll.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCodiceBollDao {

	/**
	 * Metodo di inserimento del DAO sigitTCodiceBoll. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCodiceBollPk
	 * @generated
	 */

	public SigitTCodiceBollPk insert(SigitTCodiceBollDto dto)

	;

	/** 
	 * Returns all rows from the SIGIT_T_CODICE_BOLL table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTCodiceBollDto findByPrimaryKey(SigitTCodiceBollPk pk) throws SigitTCodiceBollDaoException;

	/** 
	 * Implementazione del finder byIdTransazioneBoll
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCodiceBollDto> findByIdTransazioneBoll(java.lang.Long input) throws SigitTCodiceBollDaoException;

	/** 
	 * Implementazione del finder byNumeroBollino
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCodiceBollDto> findByNumeroBollino(java.lang.Integer input) throws SigitTCodiceBollDaoException;

	/** 
		 * Implementazione del finder byNumeroBollinoPerPotenzaPrezzo con Qdef
		 * @generated
		 */

	public List<SigitTCodiceBollByNumeroBollinoPerPotenzaPrezzoDto> findByNumeroBollinoPerPotenzaPrezzo(
			SigitTCodiceBollDto input) throws SigitTCodiceBollDaoException;

	/** 
	 * Implementazione del finder byNumeroBollinoDataControllo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCodiceBollDto> findByNumeroBollinoDataControllo(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.TransazioneFilter input)
			throws SigitTCodiceBollDaoException;

}
