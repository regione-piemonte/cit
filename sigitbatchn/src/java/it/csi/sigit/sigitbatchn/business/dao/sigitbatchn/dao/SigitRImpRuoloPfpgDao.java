package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import it.csi.sigit.sigitbatchn.business.dao.util.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO sigitRImpRuoloPfpg.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitRImpRuoloPfpgDao {

	/** 
	 * Implementazione del finder byPersonaGiuridicaCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findByPersonaGiuridicaCodImpianto(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitRImpRuoloPfpgDto input)
			throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Returns all rows from the SIGIT_R_IMP_RUOLO_PFPG table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitRImpRuoloPfpgDto findByPrimaryKey(SigitRImpRuoloPfpgPk pk) throws SigitRImpRuoloPfpgDaoException;

	/** 
	 * Implementazione del finder responsabileAttivoByCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRImpRuoloPfpgDto> findResponsabileAttivoByCodImpianto(java.lang.Integer input)
			throws SigitRImpRuoloPfpgDaoException;

}
