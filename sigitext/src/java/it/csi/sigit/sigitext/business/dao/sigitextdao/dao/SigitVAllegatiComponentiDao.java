package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.AllegatiCompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVAllegatiComponentiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitVAllegatiComponentiDaoException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitVAllegatiComponenti.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVAllegatiComponentiDao {

	/** 
	 * Implementazione del finder allegatiByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVAllegatiComponentiDto> findAllegatiByFilter(AllegatiCompFilter input)
			throws SigitVAllegatiComponentiDaoException;

	/** 
	 * Implementazione del finder allegatiByIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVAllegatiComponentiDto> findAllegatiByIdAllegato(BigDecimal input)
			throws SigitVAllegatiComponentiDaoException;

	/** 
	 * Implementazione del finder allegatiDataContrSysdateByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVAllegatiComponentiDto> findAllegatiDataContrSysdateByFilter(AllegatiCompFilter input)
			throws SigitVAllegatiComponentiDaoException;

}
