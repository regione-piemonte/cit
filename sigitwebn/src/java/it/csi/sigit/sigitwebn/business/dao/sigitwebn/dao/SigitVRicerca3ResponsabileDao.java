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
 * Interfaccia pubblica del DAO sigitVRicerca3Responsabile.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitVRicerca3ResponsabileDao {

	/** 
	 * Implementazione del finder byFkPgPf
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVRicerca3ResponsabileDto> findByFkPgPf(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicerca3ResponsabileDto input)
			throws SigitVRicerca3ResponsabileDaoException;

	/** 
		 * Implementazione del finder byFkPgPfConta con Qdef
		 * @generated
		 */

	public List<SigitVRicerca3ResponsabileByFkPgPfContaDto> findByFkPgPfConta(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.TerzoResponsabileFilter input)
			throws SigitVRicerca3ResponsabileDaoException;

	/** 
		 * Implementazione del finder byFkPgPfRow con Qdef
		 * @generated
		 */

	public List<SigitVRicerca3ResponsabileByFkPgPfRowDto> findByFkPgPfRow(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.TerzoResponsabileFilter input)
			throws SigitVRicerca3ResponsabileDaoException;

}
