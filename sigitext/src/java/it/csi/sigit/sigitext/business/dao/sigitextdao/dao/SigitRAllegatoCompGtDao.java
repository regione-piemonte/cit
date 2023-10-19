package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompGtPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRAllegatoCompGtDaoException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitRAllegatoCompGt.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRAllegatoCompGtDao {

	/**
	 * Metodo di inserimento del DAO sigitRAllegatoCompGt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRAllegatoCompGtPk
	 * @generated
	 */

	public SigitRAllegatoCompGtPk insert(SigitRAllegatoCompGtDto dto);

	List<SigitRAllegatoCompGtDto> findByFilter(CompFilter input) throws SigitRAllegatoCompGtDaoException;

	void customDeleterByIdAllegato(BigDecimal idAllegato) throws SigitRAllegatoCompGtDaoException;

	public void updateColumnsResponsabile(SigitRAllegatoCompGtDto dto) throws SigitRAllegatoCompGtDaoException;
}
