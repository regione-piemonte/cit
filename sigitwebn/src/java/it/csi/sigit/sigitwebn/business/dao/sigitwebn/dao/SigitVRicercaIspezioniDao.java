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
 * Interfaccia pubblica del DAO sigitVRicercaIspezioni.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVRicercaIspezioniDao {

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaIspezioniDto> findByCodiceImpianto(Integer input)
			throws SigitVRicercaIspezioniDaoException;

	/** 
	 * Implementazione del finder byIdIspezione
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaIspezioniDto> findByIdIspezione(Integer input) throws SigitVRicercaIspezioniDaoException;

	/** 
	 * Implementazione del finder byIspezioneFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaIspezioniDto> findByIspezioneFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaIspezioniFilter input)
			throws SigitVRicercaIspezioniDaoException;

	/** 
	 * Implementazione del finder byIdIspezIspet
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaIspezioniDto> findByIdIspezIspet(Integer input) throws SigitVRicercaIspezioniDaoException;

	/** 
		 * Implementazione del finder consByCodiceImpianto con Qdef
		 * @generated
		 */

	public List<SigitVRicercaIspezioniConsByCodiceImpiantoDto> findConsByCodiceImpianto(Integer input)
			throws SigitVRicercaIspezioniDaoException;

	/** 
	 * Implementazione del finder consDettRappProvaByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaIspezioniDto> findConsDettRappProvaByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.IspezioneFilter input)
			throws SigitVRicercaIspezioniDaoException;

}
