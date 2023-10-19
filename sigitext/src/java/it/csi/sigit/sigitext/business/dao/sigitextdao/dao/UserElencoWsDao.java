package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.UserElencoWsByUtenteFunzionalitaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.UserElencoWsDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.UserElencoWsDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO userElencoWs.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface UserElencoWsDao {

	/** 
		 * Implementazione del finder byUtenteFunzionalita con Qdef
		 * @generated
		 */

	public List<UserElencoWsByUtenteFunzionalitaDto> findByUtenteFunzionalita(
			it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.UtenteFunzionalitaFilter input)
			throws UserElencoWsDaoException;

	/** 
	 * Implementazione del finder byIdUtenteAndIdFunzionalita
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<UserElencoWsDto> findByIdUtenteAndIdFunzionalita(
			it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.UtenteFunzionalitaFilter input)
			throws UserElencoWsDaoException;

}
