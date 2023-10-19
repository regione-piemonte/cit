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
 * Interfaccia pubblica del DAO sigitDTipoVerifica.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitDTipoVerificaDao {

	/** 
	 * Returns all rows from the SIGIT_D_TIPO_VERIFICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDTipoVerificaDto findByPrimaryKey(SigitDTipoVerificaPk pk) throws SigitDTipoVerificaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_TIPO_VERIFICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDTipoVerificaDto> findAll() throws SigitDTipoVerificaDaoException;

}
