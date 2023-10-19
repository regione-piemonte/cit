package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompGfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompGfPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRAllegatoCompGfDaoException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitRAllegatoCompGf.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRAllegatoCompGfDao {

	/**
	 * Metodo di inserimento del DAO sigitRAllegatoCompGf. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRAllegatoCompGfPk
	 * @generated
	 */

	public SigitRAllegatoCompGfPk insert(SigitRAllegatoCompGfDto dto);
	public List<SigitRAllegatoCompGfDto> findByFilter(CompFilter input) throws SigitRAllegatoCompGfDaoException;

	void customDeleterByIdAllegato(BigDecimal idAllegato) throws SigitRAllegatoCompGfDaoException;

	public void updateColumnsResponsabile(SigitRAllegatoCompGfDto dto) throws SigitRAllegatoCompGfDaoException;

}
