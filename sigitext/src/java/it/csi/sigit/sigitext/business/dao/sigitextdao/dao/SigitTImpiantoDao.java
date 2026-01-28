package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImpiantoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTImpiantoDaoException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.math.BigDecimal;
import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTImpianto.
 * Espone le operazioni che possono essere eseguite per la gestione
 * della tabella [Table[TRANSIENT]]
 *
 * @generated
 */
public interface SigitTImpiantoDao {

	/**
	 * Updates a single row in the SIGIT_T_IMPIANTO table.
	 *
	 * @generated
	 */
	public void update(SigitTImpiantoDto dto) throws SigitTImpiantoDaoException;

	/**
	 * Returns all rows from the SIGIT_T_IMPIANTO table that match the primary key criteria
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTImpiantoDto findByPrimaryKey(SigitTImpiantoPk pk) throws SigitTImpiantoDaoException;

	/**
	 * Implementazione del finder findByIndirizzo
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTImpiantoDto> findFindByIndirizzo(it.csi.sigit.sigitext.dto.sigitext.IndirizzoFiltro input) throws SigitTImpiantoDaoException;

	public SigitTImpiantoPk insert(SigitTImpiantoDto dto);

	public BigDecimal getSeqTCodiceImpianto() throws SigitExtDaoException;

	public void updateColumnsUpdateDatiOnline(SigitTImpiantoDto dto) throws SigitTImpiantoDaoException;

	public void updateColumnsUpdateBloccoNomina3R(SigitTImpiantoDto dto) throws SigitTImpiantoDaoException;
	
	public SigitTImpiantoDto findByIstatComune(String istatComune) throws SigitTImpiantoDaoException;
}
