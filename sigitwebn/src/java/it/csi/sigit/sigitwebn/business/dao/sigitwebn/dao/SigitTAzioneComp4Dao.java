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
 * Interfaccia pubblica del DAO sigitTAzioneComp4.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTAzioneComp4Dao {

	/**
	 * Metodo di inserimento del DAO sigitTAzioneComp4. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAzioneComp4Pk
	 * @generated
	 */

	public SigitTAzioneComp4Pk insert(SigitTAzioneComp4Dto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_AZIONE_COMP4 table.
	 * @generated
	 */
	public void customDeleterByComp4(it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTComp4Pk filter)
			throws SigitTAzioneComp4DaoException;

}
