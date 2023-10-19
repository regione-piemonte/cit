package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo1Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo1Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDettTipo1DaoException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTDettTipo1.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTDettTipo1Dao {

	/**
	 * Metodo di inserimento del DAO sigitTDettTipo1. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDettTipo1Pk
	 * @generated
	 */

	public SigitTDettTipo1Pk insert(SigitTDettTipo1Dto dto);

	public List<SigitTDettTipo1Dto> findByAllegatoCodImpianto(SigitTDettTipo1Dto input)
			throws SigitTDettTipo1DaoException;

	void customDeleterByIdAllegato(BigDecimal idAllegato) throws SigitTDettTipo1DaoException;

	void update(SigitTDettTipo1Dto sigitTDettTipo1Dto) throws SigitTDettTipo1DaoException;
}
