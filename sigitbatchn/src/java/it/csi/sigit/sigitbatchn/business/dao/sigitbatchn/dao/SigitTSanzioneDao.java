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
 * Interfaccia pubblica del DAO sigitTSanzione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTSanzioneDao {

	/** 
	 * Implementazione del finder byCodiceFiscale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTSanzioneDto> findByCodiceFiscale(java.lang.String input) throws SigitTSanzioneDaoException;

	/** 
		 * Implementazione del finder accertamentiByUtentiNonAttivi con Qdef
		 * @generated
		 */

	public List<SigitTSanzioneAccertamentiByUtentiNonAttiviDto> findAccertamentiByUtentiNonAttivi(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTSanzioneDto input)
			throws SigitTSanzioneDaoException;

	/** 
		 * Implementazione del finder ispezione2018ByUtentiNonAttivi con Qdef
		 * @generated
		 */

	public List<SigitTSanzioneIspezione2018ByUtentiNonAttiviDto> findIspezione2018ByUtentiNonAttivi(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTSanzioneDto input)
			throws SigitTSanzioneDaoException;

}
