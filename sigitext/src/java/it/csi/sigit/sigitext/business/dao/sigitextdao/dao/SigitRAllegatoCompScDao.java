package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.math.BigDecimal;
import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompScDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompScPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRAllegatoCompScDaoException;

/**
 * Interfaccia pubblica del DAO sigitRAllegatoCompSc.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRAllegatoCompScDao {

	/**
	 * Metodo di inserimento del DAO sigitRAllegatoCompSc. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitRAllegatoCompScPk
	 * @generated
	 */

	public SigitRAllegatoCompScPk insert(SigitRAllegatoCompScDto dto);

	public List<SigitRAllegatoCompScDto> findByFilter(CompFilter input) throws SigitRAllegatoCompScDaoException;

	public void customDeleterByIdAllegato(BigDecimal idAllegato) throws SigitRAllegatoCompScDaoException;

	public void updateColumnsResponsabile(SigitRAllegatoCompScDto dto) throws SigitRAllegatoCompScDaoException;
	
	public List<SigitRAllegatoCompScDto> findByCodiceImpianto(Integer codiceImpianto) throws SigitRAllegatoCompScDaoException;
	
	public void delete(BigDecimal idAllegato) throws SigitRAllegatoCompScDaoException;
}
