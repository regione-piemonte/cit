package it.csi.sigit.sigitweba.business.dao.sigitweba.dao;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.qbe.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.metadata.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import it.csi.sigit.sigitweba.business.dao.util.*;
import it.csi.sigit.sigitweba.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO sigitDDm.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitDDmDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_DM37_2008.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDDmDto> findAll() throws SigitDDmDaoException;

}
