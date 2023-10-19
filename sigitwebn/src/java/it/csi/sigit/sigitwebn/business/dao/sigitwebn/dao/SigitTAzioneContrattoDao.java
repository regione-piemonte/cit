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
 * Interfaccia pubblica del DAO sigitTAzioneContratto.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTAzioneContrattoDao {

	/**
	 * Metodo di inserimento del DAO sigitTAzioneContratto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAzioneContrattoPk
	 * @generated
	 */

	public SigitTAzioneContrattoPk insert(SigitTAzioneContrattoDto dto)

	;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_AZIONE_CONTRATTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAzioneContrattoDto> findAll() throws SigitTAzioneContrattoDaoException;

}
