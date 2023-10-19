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
 * Interfaccia pubblica del DAO sigitTmpLibretto.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTmpLibrettoDao {

	/** 
	 * Updates a single row in the SIGIT_TMP_LIBRETTO table.
	 * @generated
	 */
	public void update(SigitTmpLibrettoDto dto) throws SigitTmpLibrettoDaoException;

	/** 
	 * Implementazione del finder DaElaborare
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTmpLibrettoDto> findDaElaborare(String input) throws SigitTmpLibrettoDaoException;

}
