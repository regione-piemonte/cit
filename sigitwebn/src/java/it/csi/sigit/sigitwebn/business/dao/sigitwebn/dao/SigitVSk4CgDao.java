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
 * Interfaccia pubblica del DAO sigitVSk4Cg.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVSk4CgDao {

	/** 
	 * Implementazione del finder byCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4CgDto> findByCodImpiantoOrdered(Integer input) throws SigitVSk4CgDaoException;

	/** 
	 * Implementazione del finder attiviByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4CgDto> findAttiviByCodImpianto(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVSk4CgDto input) throws SigitVSk4CgDaoException;

	/** 
	 * Implementazione del finder attiviByCodImpiantoProgressivi
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4CgDto> findAttiviByCodImpiantoProgressivi(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitVSk4CgDaoException;

	/** 
	 * Implementazione del finder byIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4CgDto> findByIdAllegato(java.lang.Integer input) throws SigitVSk4CgDaoException;

	/** 
	 * Implementazione del finder byIdAllegatoProgr
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4CgDto> findByIdAllegatoProgr(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitVSk4CgDaoException;

	/** 
	 * Implementazione del finder attiviByCodImpiantoFkPg
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVSk4CgDto> findAttiviByCodImpiantoFkPg(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.AllegatiCompFilter input)
			throws SigitVSk4CgDaoException;

}
