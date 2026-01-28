package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.ConsumoPodPdrFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDatoDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDatoDistribPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDatoDistribDaoException;
import it.csi.sigit.sigitext.dto.sigitext.ConsumoPodPdr;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

/**
 * Interfaccia pubblica del DAO sigitTDatoDistrib.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTDatoDistribDao {

	/**
	 * Metodo di inserimento del DAO sigitTDatoDistrib. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDatoDistribPk
	 * @generated
	 */

	public SigitTDatoDistribPk insert(SigitTDatoDistribDto dto)

	;

	/** 
	 * Deletes a single row in the SIGIT_T_DATO_DISTRIB table.
	 * @generated
	 */

	public void delete(SigitTDatoDistribPk pk) throws SigitTDatoDistribDaoException;

	/**
	 * Metodo di ricerca del DAO sigitTDatoDistrib per codice pod o pdr. Al termine dell'esecuzione il metodo
	 * ritorna un vettore di oggetti ConsumoPodPdr.
	 * 
	 * @param filter
	 * @return List<SigitTDatoDistribDto> 
	 * @throws SigitTDatoDistribDaoException 
	 * @generated
	 */
	public List<SigitTDatoDistribDto> findConsumiByPodPdr(ConsumoPodPdrFilter filter)  throws SigitTDatoDistribDaoException, SigitextException;

	public SigitTDatoDistribDto findByPrimaryKey(SigitTDatoDistribPk sigitTDatoDistribPk) throws SigitTDatoDistribDaoException;

	public List<SigitTDatoDistribDto> findDatiFornitoreByIdImportDistrib(SigitTDatoDistribPk sigitTDatoDistribPk) throws SigitTDatoDistribDaoException;

}
