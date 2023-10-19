package it.csi.sigit.elencom.business.dao.elencom.dao;

import it.csi.sigit.elencom.business.dao.elencom.dao.*;
import it.csi.sigit.elencom.business.dao.elencom.dto.*;
import it.csi.sigit.elencom.business.dao.elencom.qbe.*;
import it.csi.sigit.elencom.business.dao.elencom.metadata.*;
import it.csi.sigit.elencom.business.dao.elencom.exceptions.*;
import it.csi.sigit.elencom.business.dao.util.*;
import it.csi.sigit.elencom.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO sigitTFormazione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTFormazioneDao {

	/** 
	 * Implementazione del finder formazionePG
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTFormazioneDto> findFormazionePG(Integer input) throws SigitTFormazioneDaoException;

}
