package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.ClassDpr66096CITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.ClassDpr66096CITPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.CombustibileCITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.CombustibileCITPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.ClassDpr66096CITDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.CombustibileCITDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO CombustibileCIT.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface ClassDpr66096CITDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_COMBUSTIBILE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<ClassDpr66096CITDto> findAll() throws ClassDpr66096CITDaoException;

	/** 
	 * Returns all rows from the SIGIT_D_COMBUSTIBILE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public ClassDpr66096CITDto findByPrimaryKey(ClassDpr66096CITPk pk) throws ClassDpr66096CITDaoException;

}
