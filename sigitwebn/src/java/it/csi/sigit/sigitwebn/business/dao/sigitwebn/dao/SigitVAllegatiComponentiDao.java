package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import it.csi.sigit.sigitwebn.business.dao.util.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO sigitVAllegatiComponenti.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVAllegatiComponentiDao {

	/** 
	 * Implementazione del finder allegatiByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVAllegatiComponentiDto> findAllegatiByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.AllegatiCompFilter input)
			throws SigitVAllegatiComponentiDaoException;

	/** 
	 * Implementazione del finder allegatiByIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVAllegatiComponentiDto> findAllegatiByIdAllegato(java.math.BigDecimal input)
			throws SigitVAllegatiComponentiDaoException;

	/** 
	 * Implementazione del finder allegatiDataContrSysdateByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVAllegatiComponentiDto> findAllegatiDataContrSysdateByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.AllegatiCompFilter input)
			throws SigitVAllegatiComponentiDaoException;

}
