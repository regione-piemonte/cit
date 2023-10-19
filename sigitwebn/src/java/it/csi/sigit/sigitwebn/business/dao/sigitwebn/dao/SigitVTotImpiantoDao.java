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
 * Interfaccia pubblica del DAO sigitVTotImpianto.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVTotImpiantoDao {

	/** 
	 * Restituisce tutte le righe della tabella VISTA_TOT_IMPIANTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVTotImpiantoDto> findAll() throws SigitVTotImpiantoDaoException;

	/** 
	 * Implementazione del finder responsabiliAttiviByCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVTotImpiantoDto> findResponsabiliAttiviByCodiceImpianto(java.lang.Integer input)
			throws SigitVTotImpiantoDaoException;

	/** 
	 * Implementazione del finder terziResponsabiliAttiviByCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVTotImpiantoDto> findTerziResponsabiliAttiviByCodiceImpianto(java.lang.Integer input)
			throws SigitVTotImpiantoDaoException;

	/** 
		 * Implementazione del finder cercaImpiantoPerAllegati con Qdef
		 * @generated
		 */

	public List<SigitVTotImpiantoCercaImpiantoPerAllegatiDto> findCercaImpiantoPerAllegati(java.lang.Integer input)
			throws SigitVTotImpiantoDaoException;

	/** 
		 * Implementazione del finder cercaUbicazioneImpianto con Qdef
		 * @generated
		 */

	public List<SigitVTotImpiantoCercaUbicazioneImpiantoDto> findCercaUbicazioneImpianto(java.lang.Integer input)
			throws SigitVTotImpiantoDaoException;

	/** 
	 * Implementazione del finder responsabiliAttiviAllaDataByCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVTotImpiantoDto> findResponsabiliAttiviAllaDataByCodiceImpianto(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ResponsabileFilter input)
			throws SigitVTotImpiantoDaoException;

	/** 
	 * Implementazione del finder AttivoAllaDataByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVTotImpiantoDto> findAttivoAllaDataByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImpiantoFilter input)
			throws SigitVTotImpiantoDaoException;

}
