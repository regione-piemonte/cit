/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter.ContrattoFilter;

import java.math.BigDecimal;
import java.util.*;

/**
 * Interfaccia pubblica del DAO non rpesente sul DB.
 * @generated
 */
public interface SigitExtDao {


	public List<SigitExtContrattoImpDto> findStoriaContrattiImpiantoOld(ContrattoFilter input) throws SigitExtDaoException;

	public List<SigitExtContrattoImpDto> findStoriaContrattiImpiantoNew(ContrattoFilter input) throws SigitExtDaoException;
	
	public List<SigitExtComponenteDto> findComponentiByFilter(
			it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter.CompFilter input, String nomeTabellaComp)
			throws SigitExtDaoException;
	
}
