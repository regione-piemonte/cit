package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CodiceReaAndFiscaleFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.PersonaGiuridica;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTPersonaGiuridicaDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTPersonaGiuridica.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTPersonaGiuridicaDao {

	/** 
	 * Returns all rows from the SIGIT_T_PERSONA_GIURIDICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTPersonaGiuridicaDto findByPrimaryKey(SigitTPersonaGiuridicaPk pk)
			throws SigitTPersonaGiuridicaDaoException;

	public PersonaGiuridica findByPrimaryKeyDescStato(SigitTPersonaGiuridicaPk pk)
			throws SigitTPersonaGiuridicaDaoException;

	/** 
	 * Implementazione del finder byCodiceReaAndFiscale
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTPersonaGiuridicaDto> findByCodiceReaAndFiscale(CodiceReaAndFiscaleFilter input)
			throws SigitTPersonaGiuridicaDaoException;

	public List<SigitTPersonaGiuridicaDto> findByPiva(String piva) throws SigitTPersonaGiuridicaDaoException;

	public void update(SigitTPersonaGiuridicaDto dto) throws SigitTPersonaGiuridicaDaoException;

	public SigitTPersonaGiuridicaPk insert(SigitTPersonaGiuridicaDto dto) throws SigitTPersonaGiuridicaDaoException;


}
