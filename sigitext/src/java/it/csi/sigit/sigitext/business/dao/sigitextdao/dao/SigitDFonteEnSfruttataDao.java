package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDFonteEnSfruttataDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDFonteEnSfruttataPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDFonteEnSfruttataDaoException;

import java.util.List;

public interface SigitDFonteEnSfruttataDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_FONTE_EN_SFRUTTATA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDFonteEnSfruttataDto> findAll() throws SigitDFonteEnSfruttataDaoException;

	/** 
	 * Returns all rows from the SIGIT_D_FONTE_EN_SFRUTTATA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDFonteEnSfruttataDto findByPrimaryKey(SigitDFonteEnSfruttataPk pk)
			throws SigitDFonteEnSfruttataDaoException;

}
