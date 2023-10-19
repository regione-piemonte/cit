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
 * Interfaccia pubblica del DAO sigitVPfPg.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVPfPgDao {

	/** 
	 * Restituisce tutte le righe della tabella VISTA_PF_PG.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findAll() throws SigitVPfPgDaoException;

	/** 
	 * Implementazione del finder byCodiceFiscale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findByCodiceFiscale(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleAndDenomFilter input)
			throws SigitVPfPgDaoException;

	/** 
	 * Implementazione del finder byDenominazione
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findByDenominazione(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleAndDenomFilter input)
			throws SigitVPfPgDaoException;

	/** 
	 * Implementazione del finder byCodiceRea
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findByCodiceRea(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleAndDenomFilter input)
			throws SigitVPfPgDaoException;

	/** 
	 * Implementazione del finder byCodiceReaAndFiscale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findByCodiceReaAndFiscale(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleAndDenomFilter input)
			throws SigitVPfPgDaoException;

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleAndDenomFilter input)
			throws SigitVPfPgDaoException;

}
