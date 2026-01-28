package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;


import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.MvOdVistaDettaglioImpiantiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.MvOdVistaDettaglioImpiantiDaoException;

/**
 * Interfaccia pubblica del DAO mvOdVistaDettaglioImpianti.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface MvOdVistaDettaglioImpiantiDao {

	/** 
	 * Implementazione del finder findByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<MvOdVistaDettaglioImpiantiDto> findFindByFilter(
			MvOdVistaDettaglioImpiantiDto input)
			throws MvOdVistaDettaglioImpiantiDaoException;

}
