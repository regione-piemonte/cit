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
 * Interfaccia pubblica del DAO sigitDTipoCannaFumaria.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitDTipoCannaFumariaDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_TIPO_CANNA_FUMARIA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoCannaFumariaDto> findAll() throws SigitDTipoCannaFumariaDaoException;

	/** 
	 * Returns all rows from the SIGIT_D_TIPO_CANNA_FUMARIA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDTipoCannaFumariaDto findByPrimaryKey(SigitDTipoCannaFumariaPk pk)
			throws SigitDTipoCannaFumariaDaoException;

}
