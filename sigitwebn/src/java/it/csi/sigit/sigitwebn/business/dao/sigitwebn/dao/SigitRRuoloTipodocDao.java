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
 * Interfaccia pubblica del DAO sigitRRuoloTipodoc.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRRuoloTipodocDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_R_RUOLO_TIPODOC.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRRuoloTipodocDto> findAll() throws SigitRRuoloTipodocDaoException;

	/** 
	 * Returns all rows from the SIGIT_R_RUOLO_TIPODOC table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRRuoloTipodocDto findByPrimaryKey(SigitRRuoloTipodocPk pk) throws SigitRRuoloTipodocDaoException;

	/** 
	 * Implementazione del finder verificaAllegatoSelezionato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRRuoloTipodocDto> findVerificaAllegatoSelezionato(
			it.csi.sigit.sigitwebn.dto.allegati.FiltroControlloInserisciAllegato input)
			throws SigitRRuoloTipodocDaoException;

}
