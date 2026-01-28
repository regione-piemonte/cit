package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompCgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompCgPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRAllegatoCompCgDaoException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitRAllegatoCompCg.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRAllegatoCompCgDao {

	/**
	 * Metodo di inserimento del DAO sigitRAllegatoCompCg. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRAllegatoCompCgPk
	 * @generated
	 */

	public SigitRAllegatoCompCgPk insert(SigitRAllegatoCompCgDto dto);

	public List<SigitRAllegatoCompCgDto> findByFilter(CompFilter input) throws SigitRAllegatoCompCgDaoException;

	void customDeleterByIdAllegato(BigDecimal idAllegato) throws SigitRAllegatoCompCgDaoException;

	public void updateColumnsResponsabile(SigitRAllegatoCompCgDto dto) throws SigitRAllegatoCompCgDaoException;
	
	public List<SigitRAllegatoCompCgDto> findByCodiceImpianto(Integer codiceImpianto) throws SigitRAllegatoCompCgDaoException;
	
	public void delete(BigDecimal idAllegato) throws SigitRAllegatoCompCgDaoException;
}
