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
 * Interfaccia pubblica del DAO sigitDRuolo.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitDRuoloDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_RUOLO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDRuoloDto> findAll() throws SigitDRuoloDaoException;

	/** 
	 * Returns all rows from the SIGIT_D_RUOLO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDRuoloDto findByPrimaryKey(SigitDRuoloPk pk) throws SigitDRuoloDaoException;

	/** 
	 * Implementazione del finder byDesRuolo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDRuoloDto> findByDesRuolo(java.lang.String input) throws SigitDRuoloDaoException;

	/** 
	 * Implementazione del finder byRuoloFunzionale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDRuoloDto> findByRuoloFunzionale(java.lang.String input) throws SigitDRuoloDaoException;

	/** 
	 * Implementazione del finder byRuoloFunzionaleCodImp
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDRuoloDto> findByRuoloFunzionaleCodImp(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.SubentroFilter input) throws SigitDRuoloDaoException;

}
