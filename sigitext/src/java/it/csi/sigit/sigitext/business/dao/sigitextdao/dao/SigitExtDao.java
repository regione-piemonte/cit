/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.ContrattoFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.ExtImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitExtContrattoImpDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitExtImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitExtIspezioniConCodImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitExtIspezioniDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitExtIspezioniSenzaCodImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitExtRespImpDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitExtVerificaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTVerificaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.ExtDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitext.dto.sigitext.ImpiantoFiltro;

/**
 * Interfaccia pubblica del DAO non rpesente sul DB.
 * 
 * @generated
 */
public interface SigitExtDao {

	public List<SigitExtContrattoImpDto> findStoriaContrattiImpiantoNew(ContrattoFilter input)
			throws SigitExtDaoException;

	public List<ExtImpiantoDto> findImpiantiByCodice(Integer input) throws ExtDaoException;

	public BigDecimal getSeqTNumeroBollino() throws SigitExtDaoException;

	public List<SigitExtImpiantoDto> findImpiantiByFiltro(ImpiantoFiltro input) throws SigitExtDaoException;

	public List<SigitExtImpiantoDto> findImpiantiByFiltroDuplicatiResponsabile(ImpiantoFiltro input) throws SigitExtDaoException;

	public List<SigitExtRespImpDto> findResponsabiliByCodiceImpianto(Integer idImpianto) throws SigitExtDaoException;

	public List<SigitExtIspezioniDto> findIspezioniDettByListIdIspez(ArrayList<String> listIdIspezioni)
			throws SigitExtDaoException;

	public List<SigitExtIspezioniConCodImpiantoDto> findIspezioniDettConCodImpiantoByListConImpianti(
			ArrayList<String> listCodImpianti) throws SigitExtDaoException;

	public List<SigitExtIspezioniSenzaCodImpiantoDto> findIspezioniDettSenzaCodImpiantoByListIdIspez(ArrayList<String> listIdIspezioni)
			throws SigitExtDaoException;

	public List<SigitExtVerificaDto> findVerificaById(SigitTVerificaPk sigitTVerificaPk) throws SigitExtDaoException;

}
