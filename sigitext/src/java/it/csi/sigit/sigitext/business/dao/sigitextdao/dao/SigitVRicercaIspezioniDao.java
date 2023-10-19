package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicercaIspezioniConsByCodiceImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicercaIspezioniDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitVRicercaIspezioniDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitVRicercaIspezioni.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVRicercaIspezioniDao {

	/** 
	 * Implementazione del finder byIspezioneFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaIspezioniDto> findByIspezioneFilter(
			it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.IspezioneFilter input)
			throws SigitVRicercaIspezioniDaoException;

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
			it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.IspezioneFilter input)
			throws SigitVRicercaIspezioniDaoException;

	/** 
	 * Implementazione del finder byIdIspezIspet
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicercaIspezioniDto> findByIdIspezIspet(Integer input) throws SigitVRicercaIspezioniDaoException;

}
