package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVTotImpiantoCercaUbicazioneImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVTotImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitVTotImpiantoDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitVTotImpianto.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVTotImpiantoDao {

	/** 
	 * Implementazione del finder responsabiliAttiviByCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVTotImpiantoDto> findResponsabiliAttiviByCodiceImpianto(Integer input)
			throws SigitVTotImpiantoDaoException;

	public List<SigitVTotImpiantoDto> findProprietariAttiviByCodiceImpianto(Integer input)
			throws SigitVTotImpiantoDaoException;
	/** 
	 * Implementazione del finder responsabiliAttiviAllaDataByCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVTotImpiantoDto> findResponsabiliAttiviAllaDataByCodiceImpianto(
			it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.ResponsabileFilter input)
			throws SigitVTotImpiantoDaoException;

	public List<SigitVTotImpiantoCercaUbicazioneImpiantoDto> findCercaUbicazioneImpianto(java.lang.Integer input)
			throws SigitVTotImpiantoDaoException;
}
