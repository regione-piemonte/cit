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
 * Interfaccia pubblica del DAO sigitDTipoDocumento.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitDTipoDocumentoDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_TIPO_DOCUMENTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoDocumentoDto> findAll() throws SigitDTipoDocumentoDaoException;

	/** 
	 * Returns all rows from the SIGIT_D_TIPO_DOCUMENTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDTipoDocumentoDto findByPrimaryKey(SigitDTipoDocumentoPk pk) throws SigitDTipoDocumentoDaoException;

	/** 
	 * Implementazione del finder byFlgVisualizzaAllegati
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoDocumentoDto> findByFlgVisualizzaAllegati(java.lang.String input)
			throws SigitDTipoDocumentoDaoException;

	/** 
		 * Implementazione del finder byRuoloFunzionale con Qdef
		 * @generated
		 */

	public List<SigitDTipoDocumentoByRuoloFunzionaleDto> findByRuoloFunzionale(java.lang.String input)
			throws SigitDTipoDocumentoDaoException;

	/** 
	 * Implementazione del finder byFlgRicercaAllegati
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoDocumentoDto> findByFlgRicercaAllegati(java.lang.String input)
			throws SigitDTipoDocumentoDaoException;

	/** 
		 * Implementazione del finder byCodiceImpianto con Qdef
		 * @generated
		 */

	public List<SigitDTipoDocumentoByCodiceImpiantoDto> findByCodiceImpianto(java.lang.Integer input)
			throws SigitDTipoDocumentoDaoException;

	/** 
	 * Implementazione del finder byFlgVisualizzaManutenzioni
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoDocumentoDto> findByFlgVisualizzaManutenzioni(java.lang.String input)
			throws SigitDTipoDocumentoDaoException;

}
