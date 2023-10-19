package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.AllegatoByCodiceImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.AllegatoDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO Allegato.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface AllegatoDao {

	/** 
		 * Implementazione del finder byCodiceImpianto con Qdef
		 * @generated
		 */

	public List<AllegatoByCodiceImpiantoDto> findByCodiceImpianto(Integer input) throws AllegatoDaoException;

}
