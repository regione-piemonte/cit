package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.math.BigDecimal;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImpXmlDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImpXmlPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTImpXmlDaoException;

/**
 * Interfaccia pubblica del DAO sigitTImpXml.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTImpXmlDao {

	/**
	 * Metodo di inserimento del DAO sigitTImpXml. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTImpXmlPk
	 * @generated
	 */

	public SigitTImpXmlPk insert(SigitTImpXmlDto dto)

	;

	void customDeleterByIdImport(Integer idImport) throws SigitTImpXmlDaoException;
	
	public void delete(BigDecimal idImport) throws SigitTImpXmlDaoException;
}
