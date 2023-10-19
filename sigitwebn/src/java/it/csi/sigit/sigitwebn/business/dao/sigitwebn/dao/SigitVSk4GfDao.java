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
 * Interfaccia pubblica del DAO sigitVSk4Gf.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVSk4GfDao {

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4GfDto> findByCodImpiantoOrdered(Integer input) throws SigitVSk4GfDaoException;

	/** 
	 * Implementazione del finder attiviByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4GfDto> findAttiviByCodImpianto(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVSk4GfDto input) throws SigitVSk4GfDaoException;

	/** 
	 * Implementazione del finder attiviByCodImpiantoProgressivi
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4GfDto> findAttiviByCodImpiantoProgressivi(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitVSk4GfDaoException;

	/** 
	 * Implementazione del finder byIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4GfDto> findByIdAllegato(java.lang.Integer input) throws SigitVSk4GfDaoException;

	/** 
	 * Implementazione del finder byIdAllegatoProgr
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4GfDto> findByIdAllegatoProgr(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitVSk4GfDaoException;

	/** 
	 * Implementazione del finder attiviByCodImpiantoFkPg
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4GfDto> findAttiviByCodImpiantoFkPg(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.AllegatiCompFilter input)
			throws SigitVSk4GfDaoException;

}
