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
 * Interfaccia pubblica del DAO sigitVRicercaImpianti.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVRicercaImpiantiDao {

	/** 
	 * Implementazione del finder byImpiantoFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaImpiantiDto> findByImpiantoFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImpiantoFilter input)
			throws SigitVRicercaImpiantiDaoException;

	/** 
	 * Implementazione del finder ImpiantiDaRicercaAvanzata
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaImpiantiDto> findImpiantiDaRicercaAvanzata(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaAvanzataImpiantoFilter input)
			throws SigitVRicercaImpiantiDaoException;

}
