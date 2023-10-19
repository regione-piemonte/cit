package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.RicercaAllegatiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.RicercaAllegatiDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO RicercaAllegati.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface RicercaAllegatiDao {

	/** 
	 * Implementazione del finder inviatiByCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<RicercaAllegatiDto> findInviatiByCodiceImpianto(String input)
			throws RicercaAllegatiDaoException;

}
