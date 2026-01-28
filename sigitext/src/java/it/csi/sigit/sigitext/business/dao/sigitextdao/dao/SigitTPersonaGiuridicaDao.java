package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CodiceReaAndFiscaleFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.PersonaGiuridica;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaJoinSigitRPgPgNominaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTPersonaGiuridicaDaoException;
import it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException;

/**
 * Interfaccia pubblica del DAO sigitTPersonaGiuridica.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTPersonaGiuridicaDao {

	public SigitTPersonaGiuridicaDto findByPrimaryKey(SigitTPersonaGiuridicaPk pk)
			throws SigitTPersonaGiuridicaDaoException;

	public PersonaGiuridica findByPrimaryKeyDescStato(SigitTPersonaGiuridicaPk pk)
			throws SigitTPersonaGiuridicaDaoException;

	public List<SigitTPersonaGiuridicaDto> findByCodiceReaAndFiscale(CodiceReaAndFiscaleFilter input)
			throws SigitTPersonaGiuridicaDaoException;

	public List<SigitTPersonaGiuridicaDto> findByPiva(String piva) throws SigitTPersonaGiuridicaDaoException;

	public void update(SigitTPersonaGiuridicaDto dto) throws SigitTPersonaGiuridicaDaoException;

	public SigitTPersonaGiuridicaPk insert(SigitTPersonaGiuridicaDto dto) throws SigitTPersonaGiuridicaDaoException;
	
	List<String> getComuniPG() throws SigitExtDaoException;

	List<SigitTPersonaGiuridicaDto> getManutentori(String denominazione, String comune) throws SigitExtDaoException, SigitExcessiveResultsException;
	
	List<SigitTPersonaGiuridicaDto> getPersonaGiuridicaByCF(String codiceFiscale) throws SigitExtDaoException, SigitExcessiveResultsException;
	
	List<SigitTPersonaGiuridicaJoinSigitRPgPgNominaDto> getSigitTPersonaGiuridicaJoinSigitRPgPgNominaDtoByIdPersonaGiuridicaImpresa(Integer idPersonaGiuridicaImpresa) throws SigitExtDaoException;
	
	List<Map<String, Object>> getPersonaGiuridicaByFlgCatOne() throws SigitExtDaoException, SigitExcessiveResultsException;
	
	List<SigitTPersonaGiuridicaDto> getPersonaGiuridicaByCFAndCodiceRea(String codiceFiscale, String siglaRea, BigDecimal numeroRea) throws SigitExtDaoException, SigitExcessiveResultsException;

}
