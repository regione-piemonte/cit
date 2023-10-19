package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import it.csi.sigit.sigitbatchn.business.dao.util.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO sigitTIspezione2018.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTIspezione2018Dao {

	/** 
		 * Implementazione del finder byCodiceFiscale con Qdef
		 * @generated
		 */

	public List<SigitTIspezione2018ByCodiceFiscaleDto> findByCodiceFiscale(java.lang.String input)
			throws SigitTIspezione2018DaoException;

	/** 
		 * Implementazione del finder byUtentiNonAttivi con Qdef
		 * @generated
		 */

	public List<SigitTIspezione2018ByUtentiNonAttiviDto> findByUtentiNonAttivi(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTIspezione2018Dto input)
			throws SigitTIspezione2018DaoException;

}
