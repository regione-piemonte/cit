/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.manager.db;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitDTipoAnomaliaDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitDTipoAzioneDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTAccertamentoDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTAzioneDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTDocAzioneDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTIspezione2018Dao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoAnomaliaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoAzioneDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoVerificaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAccertamentoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAccertamentoPk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAzioneDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAzionePk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocAzioneDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocAzionePk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTIspezione2018Dto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaFisicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDTipoAnomaliaDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDTipoVerificaDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTAccertamentoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTDocAzioneDaoException;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.DateUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.ReplaceSpecialCharUtils;

public class DbAzioneMgr {
	
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager.db");
	
	private SigitTAccertamentoDao sigitTAccertamentoDao;
	private SigitTAzioneDao sigitTAzioneDao;
	private SigitDTipoAzioneDao sigitDTipoAzioneDao;
	private SigitTDocAzioneDao sigitTDocAzioneDao;
	private SigitDTipoAnomaliaDao sigitDTipoAnomaliaDao;
	
	
	public SigitTAzioneDao getSigitTAzioneDao() {
		return sigitTAzioneDao;
	}

	public void setSigitTAzioneDao(SigitTAzioneDao sigitTAzioneDao) {
		this.sigitTAzioneDao = sigitTAzioneDao;
	}
	
	public SigitTAccertamentoDao getSigitTAccertamentoDao() {
		return sigitTAccertamentoDao;
	}

	public void setSigitTAccertamentoDao(SigitTAccertamentoDao sigitTAccertamentoDao) {
		this.sigitTAccertamentoDao = sigitTAccertamentoDao;
	}

	public SigitDTipoAzioneDao getSigitDTipoAzioneDao() {
		return sigitDTipoAzioneDao;
	}

	public void setSigitDTipoAzioneDao(SigitDTipoAzioneDao sigitDTipoAzioneDao) {
		this.sigitDTipoAzioneDao = sigitDTipoAzioneDao;
	}

	public SigitTDocAzioneDao getSigitTDocAzioneDao() {
		return sigitTDocAzioneDao;
	}

	public void setSigitTDocAzioneDao(SigitTDocAzioneDao sigitTDocAzioneDao) {
		this.sigitTDocAzioneDao = sigitTDocAzioneDao;
	}
	
	public SigitDTipoAnomaliaDao getSigitDTipoAnomaliaDao() {
		return sigitDTipoAnomaliaDao;
	}

	public void setSigitDTipoAnomaliaDao(SigitDTipoAnomaliaDao sigitDTipoAnomaliaDao) {
		this.sigitDTipoAnomaliaDao = sigitDTipoAnomaliaDao;
	}
	
	
	public SigitTAzionePk inserisciAzioneSimply(String descrizioneAzione, Integer tipoAzione, UtenteLoggato utente, Integer origine) throws DbManagerException {
		SigitTAzioneDto azione = new SigitTAzioneDto();
				
		azione.setDescrizioneAzione(ReplaceSpecialCharUtils.sanitize(descrizioneAzione));
		azione.setDtAzione(DateUtil.getSqlCurrentDate());
		azione.setCfUtenteAzione(ReplaceSpecialCharUtils.sanitize(utente.getCodiceFiscale()));
		azione.setDenomUtenteAzione(ReplaceSpecialCharUtils.sanitize(utente.getDenominazione()));
		azione.setFkTipoAzione(tipoAzione);
		if (Constants.ID_TIPO_AZIONE_ISPEZIONE == tipoAzione) {
			azione.setFkIspezione2018(origine);
		} else if (Constants.ID_TIPO_AZIONE_ACCERTAMENTO == tipoAzione) {
			azione.setFkAccertamento(origine);
		} else if (Constants.ID_TIPO_AZIONE_SANZIONE == tipoAzione) {
			azione.setFkSanzione(origine);
		} else if (Constants.ID_TIPO_AZIONE_VERIFICA == tipoAzione) {
			azione.setFkVerifica(origine);
		}
		
		return inserisciOModificaAzione(azione);
	}
	
	public SigitTAzionePk inserisciOModificaAzione(SigitTAzioneDto azione) throws DbManagerException {
		log.debug("[DbAzioneMgr::inserisciOModificaAzione] BEGIN");
		//PREPARAZIONE SALVATAGGIO AZIONE
		if (azione.getFkAccertamento() == null) {
			azione.setFkAccertamento(0);
		}
		if (azione.getFkIspezione2018() == null) {
			azione.setFkIspezione2018(0);
		}
		if (azione.getFkSanzione() == null) {
			azione.setFkSanzione(0);
		}
		if (azione.getFkVerifica() == null) {
			azione.setFkVerifica(0);
		}
		SigitTAzionePk risultato = null;
		try {
			if (azione.getIdAzione() == null) {
				risultato = getSigitTAzioneDao().insert(azione);
			} else {
				getSigitTAzioneDao().update(azione);
				risultato = new SigitTAzionePk(azione.getIdAzione());
			}
		}catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbAzioneMgr::inserisciOModificaAzione] END");
		}
		
		return risultato;
	}
	
	public List<SigitTAzioneDto> cercaAzione(SigitTAzioneDto azione) throws DbManagerException {
		log.debug("[DbAzioneMgr::cercaAzione] BEGIN");
		List<SigitTAzioneDto> output = null;
		try {
			output = getSigitTAzioneDao().findByExample(azione);
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbAzioneMgr::cercaAzione] END");
		}
		
		return output;
	}
	
	public SigitTAzioneDto cercaAzioneById(Integer idAzione) throws DbManagerException {
		log.debug("[DbAzioneMgr::cercaAzioneById] BEGIN");
		SigitTAzioneDto output = null;
		try {
			SigitTAzionePk pk = new SigitTAzionePk(idAzione);
			output = getSigitTAzioneDao().findByPrimaryKey(pk);
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbAzioneMgr::cercaAzioneById] END");
		}
		
		return output;
	}
	
	public SigitTDocAzioneDto cercaDocAzioneByIdAzione (Integer idAzione) throws DbManagerException {
		log.debug("[DbAzioneMgr::cercaDocAzioneByIdAzione] BEGIN");
		List<SigitTDocAzioneDto> lista = null;
		SigitTDocAzioneDto risultato = null;
		try {
			lista = getSigitTDocAzioneDao().findByIdAzione(idAzione);
			if (lista != null && !lista.isEmpty()) {
				risultato = lista.get(0);
			}
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbAzioneMgr::cercaDocAzioneByIdAzione] END");
		}
		
		return risultato;
	}
	
	public SigitTDocAzioneDto cercaDocAzioneById (Integer idDocAzione) throws DbManagerException {
		log.debug("[DbAzioneMgr::cercaDocAzioneById] BEGIN");
		SigitTDocAzioneDto risultato = null;
		try {
			SigitTDocAzionePk pk = new SigitTDocAzionePk(idDocAzione);
			risultato = getSigitTDocAzioneDao().findByPrimaryKey(pk);
		} catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbAzioneMgr::cercaDocAzioneById] END");
		}
		
		return risultato;
		
	}
	
	public SigitTDocAzionePk inserisciDocAzione(SigitTDocAzioneDto docAzione) throws DbManagerException {
		log.debug("[DbAzioneMgr::inserisciDocAzione] BEGIN");
		try {
			return getSigitTDocAzioneDao().insert(docAzione);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbAzioneMgr::inserisciDocAzione] BEGIN");
		}
	}
	
	public void aggiornaTDocAzione(SigitTDocAzioneDto dto) throws DbManagerException {
		log.debug("[DbAzioneMgr::aggiornaTDocAzione] BEGIN");
		try {
			  getSigitTDocAzioneDao().updateColumnsAggiornaNomeUid(dto);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbAzioneMgr::aggiornaTDocAzione] END");
		}
	}
	
	public SigitDTipoAzioneDto getTipoAzioneByCode(String codice) throws DbManagerException {
		log.debug("[DbAzioneMgr::getTipoAzioneByCode] BEGIN");
		SigitDTipoAzioneDto risultato = null;
		try {
			
			List<SigitDTipoAzioneDto>  lista = getSigitDTipoAzioneDao().findByCodice(codice);
			if (lista != null && !lista.isEmpty()) {
				risultato = lista.get(0);
			}
		} catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbAzioneMgr::aggiornaTDocAzione] END");
		}
		return risultato;
	}

	public List<SigitDTipoAnomaliaDto> getElencoTipoAnomalia() throws DbManagerException {
		log.debug("[DbAzioneMgr::getElencoTipoAnomalia] BEGIN");
			try {
				return getSigitDTipoAnomaliaDao().findAll();
			} catch (SigitDTipoAnomaliaDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			} finally {
				log.debug("[DbAzioneMgr::getElencoTipoAnomalia] END");
			}
		
	}
	

	
	@Transactional
	public void associaAccertamento(Integer idAccertamento, SigitTPersonaFisicaDto validatore, UtenteLoggato utente) throws DbManagerException {
		log.debug("[DbAzioneMgr::associaAccertamento] BEGIN");
		
		try {
			SigitTAccertamentoDto accertamento = getSigitTAccertamentoDao().findByPrimaryKey(new SigitTAccertamentoPk(idAccertamento));
			
			
			StringBuffer sbDescr = new StringBuffer("Variazione utente assegnatario ");
			
			if (GenericUtil.isNotNullOrEmpty(accertamento.getCfUtenteAssegn()))
			{
				sbDescr.append(" da " + accertamento.getDenomUtenteAssegn());
				sbDescr.append(" ("+accertamento.getCfUtenteAssegn()+")");
			}
			
			sbDescr.append(" a " + validatore.getNome());
			sbDescr.append(" " + validatore.getCognome());
			sbDescr.append(" ("+validatore.getCodiceFiscale()+")");
			
			inserisciAzioneSimply(sbDescr.toString(), Constants.ID_TIPO_AZIONE_ACCERTAMENTO, utente, idAccertamento);

			accertamento.setCfUtenteAssegn(validatore.getCodiceFiscale());
			accertamento.setDenomUtenteAssegn(validatore.getNome() + " " + validatore.getCognome());

			getSigitTAccertamentoDao().update(accertamento);

		}
		catch (SigitTAccertamentoDaoException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}  finally {
			log.debug("[DbAzioneMgr::associaAccertamento] END");
		}
	}
	
}
