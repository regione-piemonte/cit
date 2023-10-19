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
 * Interfaccia pubblica del DAO sigitRPfRuoloPa.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRPfRuoloPaDao {

	/** 
	 * Implementazione del finder IdUtentiPAAttivi
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRPfRuoloPaDto> findIdUtentiPAAttivi(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitRPfRuoloPaDto input)
			throws SigitRPfRuoloPaDaoException;

}
