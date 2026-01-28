package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfRuoloPaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfRuoloPaFindByPfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRPfRuoloPaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRPfRuoloPaDaoException;
import it.csi.sigit.sigitext.dto.Assegnatario;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitRPfRuoloPa.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRPfRuoloPaDao {

	/**
	 * Metodo di inserimento del DAO sigitRPfRuoloPa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRPfRuoloPaPk
	 * @generated
	 */

	public SigitRPfRuoloPaPk insert(SigitRPfRuoloPaDto dto)

	;

	/** 
		 * Implementazione del finder findByPf con Qdef
		 * @generated
		 */

	public List<SigitRPfRuoloPaFindByPfDto> findFindByPf(Integer input) throws SigitRPfRuoloPaDaoException;

	public List<SigitRPfRuoloPaDto> findAllByIstatValidatore(SigitRPfRuoloPaDto dto) throws SigitRPfRuoloPaDaoException;
	
	public List<Assegnatario> findAllAssegnatario() throws SigitRPfRuoloPaDaoException;

	void closeCaricatoriImpiantoSigitRImpRuoloPfpg(Integer codiceImpianto, String utenteUltimaModifica) throws SigitRPfRuoloPaDaoException;

	public List<Assegnatario> findAllIspettori() throws SigitRPfRuoloPaDaoException;

}
