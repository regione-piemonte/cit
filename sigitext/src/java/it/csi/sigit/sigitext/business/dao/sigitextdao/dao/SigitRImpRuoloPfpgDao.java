package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.FiltroRicercaPfPg;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRImpRuoloPfpgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRImpRuoloPfpgPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRImpRuoloPfpgDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitRImpRuoloPfpg.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRImpRuoloPfpgDao {

	/** 
	 * Implementazione del finder respImpAttivoByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findRespImpAttivoByCodImpianto(Integer input) throws SigitRImpRuoloPfpgDaoException;
	
	public List<SigitRImpRuoloPfpgDto> findRespImpByCodImpianto(Integer input) throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Implementazione del finder byRuoloFunzPersonaGiuridicaCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findByRuoloFunzPersonaGiuridicaCodImpianto(
			it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter input)
			throws SigitRImpRuoloPfpgDaoException, SigitRImpRuoloPfpgDaoException;

	public SigitRImpRuoloPfpgPk insert(SigitRImpRuoloPfpgDto dto);

	public void update(SigitRImpRuoloPfpgDto dto) throws SigitRImpRuoloPfpgDaoException;

	List<SigitRImpRuoloPfpgDto> findAttiviByFilter(FiltroRicercaPfPg filter) throws SigitRImpRuoloPfpgDaoException;

	public void updateColumnsTerminaRiga(SigitRImpRuoloPfpgDto dto) throws SigitRImpRuoloPfpgDaoException;
	
	List<SigitRImpRuoloPfpgDto> findByPrimaryKey(SigitRImpRuoloPfpgPk pk) throws SigitRImpRuoloPfpgDaoException;
	
	Integer checkResponsabileImpresa(Integer codiceImpianto, Integer idPersona, String ruoloFunz) throws SigitRImpRuoloPfpgDaoException;
	Integer checkResponsabile(Integer codiceImpianto, String cfPersona) throws SigitRImpRuoloPfpgDaoException;
	Integer checkProprietario(Integer codiceImpianto, String cfPersona) throws SigitRImpRuoloPfpgDaoException;
	
	List<SigitRImpRuoloPfpgDto> findAttiviByCodiceImpianto(Integer codiceImpianto) throws SigitRImpRuoloPfpgDaoException;
	List<SigitRImpRuoloPfpgDto> findByCodiceImpiantoAndRuolo(Integer codiceImpianto) throws SigitRImpRuoloPfpgDaoException;
	List<SigitRImpRuoloPfpgDto> findSigitRImpRuoloPfpgByCodiceImpiantoEDataFineOggiONull(Integer codiceImpianto) throws SigitRImpRuoloPfpgDaoException;

}
