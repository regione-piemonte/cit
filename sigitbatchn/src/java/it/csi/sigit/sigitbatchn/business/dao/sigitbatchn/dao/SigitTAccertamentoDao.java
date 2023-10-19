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
 * Interfaccia pubblica del DAO sigitTAccertamento.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTAccertamentoDao {

	/** 
	 * Implementazione del finder byCodiceFiscale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAccertamentoDto> findByCodiceFiscale(java.lang.String input)
			throws SigitTAccertamentoDaoException;

	/** 
		 * Implementazione del finder byUtentiNonAttivi con Qdef
		 * @generated
		 */

	public List<SigitTAccertamentoByUtentiNonAttiviDto> findByUtentiNonAttivi(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTAccertamentoDto input)
			throws SigitTAccertamentoDaoException;

}
