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
 * Interfaccia pubblica del DAO sigitRComp4Manut.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRComp4ManutDao {

	/**
	 * Metodo di inserimento del DAO sigitRComp4Manut. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRComp4ManutPk
	 * @generated
	 */

	public SigitRComp4ManutPk insert(SigitRComp4ManutDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_R_COMP4_MANUT table.
	 * @generated
	 */
	public void update(SigitRComp4ManutDto dto) throws SigitRComp4ManutDaoException;

	/** 
	 * Custom updater in the SIGIT_R_COMP4_MANUT table.
	 * @generated
	 */
	public void customUpdaterPerSubentro(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter,
			java.lang.Object value) throws SigitRComp4ManutDaoException;

	/** 
	 * Custom deleter in the SIGIT_R_COMP4_MANUT table.
	 * @generated
	 */
	public void customDeleterByFilter(SigitRComp4ManutDto filter) throws SigitRComp4ManutDaoException;

	/** 
	 * Custom deleter in the SIGIT_R_COMP4_MANUT table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitRComp4ManutDaoException;

	/** 
		 * Implementazione del finder manutentoriByCodiceImpianto con Qdef
		 * @generated
		 */

	public List<SigitRComp4ManutManutentoriByCodiceImpiantoDto> findManutentoriByCodiceImpianto(java.lang.Integer input)
			throws SigitRComp4ManutDaoException;

	/** 
	 * Implementazione del finder attiviByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRComp4ManutDto> findAttiviByFilter(SigitRComp4ManutDto input) throws SigitRComp4ManutDaoException;

	/** 
	 * Implementazione del finder byPersonaGiuridicaCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRComp4ManutDto> findByPersonaGiuridicaCodImpianto(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitRComp4ManutDaoException;

	/** 
	 * Implementazione del finder attiviByFilterSubentro
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRComp4ManutDto> findAttiviByFilterSubentro(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaPfPg input)
			throws SigitRComp4ManutDaoException;

}
