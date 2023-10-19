/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.manager.db;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitDStatoAccertamentoDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitDStatoIspezioneDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitDStatoSanzioneDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitDTipoConclusioneDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitDTipoVerificaDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitExtDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTAccertamentoDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTIspezione2018Dao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTPersonaFisicaDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTSanzioneDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTVerificaDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitWrkConfigDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDStatoAccertamentoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDStatoIspezioneDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDStatoSanzioneDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoConclusioneDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoVerificaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoVerificaPk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitExtIspezione2018Dto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitExtVerificaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRImpRuoloPfpgPk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAccertamentoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAccertamentoPk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAzioneDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTIspezione2018Dto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTIspezione2018Pk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTIspezionePk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaFisicaDaRuoloPADto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaFisicaValidatoriDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTSanzioneDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTVerificaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTVerificaPk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicercaImpiantiDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitWrkConfigDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDStatoAccertamentoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDStatoIspezioneDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDStatoSanzioneDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDTipoConclusioneDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDTipoVerificaDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTAccertamentoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTIspezione2018DaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTPersonaFisicaDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTSanzioneDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTVerificaDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitWrkConfigDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.PersonaRuoloFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaAccertamentoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaIspezioniFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaVerificaFilter;
import it.csi.sigit.sigitwebn.business.gestisci_verifica.CPBECpGestVerifica.TipoVerificaEnum;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.dto.azioni.Sveglia;
import it.csi.sigit.sigitwebn.dto.ispezioni.DettaglioIspezione;
import it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.DateUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.MapDto;
import it.csi.sigit.sigitwebn.util.Messages;

public class DbVerificaMgr {
	
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager.db");
	
	private SigitDTipoVerificaDao sigitDTipoVerificaDao;
	private SigitTVerificaDao sigitTVerificaDao;
	private SigitTAccertamentoDao sigitTAccertamentoDao;
	private SigitDStatoAccertamentoDao sigitDStatoAccertamentoDao;
	private SigitDTipoConclusioneDao sigitDTipoConclusioneDao;
	private SigitTPersonaFisicaDao sigitTPersonaFisicaDao = null;
	private SigitExtDao sigitExtDao = null;
	private SigitDStatoSanzioneDao sigitDStatoSanzioneDao;
	
	public SigitExtDao getSigitExtDao() {
		return sigitExtDao;
	}

	public void setSigitExtDao(
			SigitExtDao sigitExtDao) {
		this.sigitExtDao = sigitExtDao;
	}

	
	
	public SigitTVerificaDao getSigitTVerificaDao() {
		return sigitTVerificaDao;
	}

	public void setSigitTVerificaDao(SigitTVerificaDao sigitTVerificaDao) {
		this.sigitTVerificaDao = sigitTVerificaDao;
	}

	public SigitTAccertamentoDao getSigitTAccertamentoDao() {
		return sigitTAccertamentoDao;
	}

	public void setSigitTAccertamentoDao(SigitTAccertamentoDao sigitTAccertamentoDao) {
		this.sigitTAccertamentoDao = sigitTAccertamentoDao;
	}

	public SigitDTipoVerificaDao getSigitDTipoVerificaDao() {
		return sigitDTipoVerificaDao;
	}

	public SigitDStatoAccertamentoDao getSigitDStatoAccertamentoDao() {
		return sigitDStatoAccertamentoDao;
	}

	public void setSigitDStatoAccertamentoDao(SigitDStatoAccertamentoDao sigitDStatoAccertamentoDao) {
		this.sigitDStatoAccertamentoDao = sigitDStatoAccertamentoDao;
	}

	public void setSigitDTipoVerificaDao(SigitDTipoVerificaDao sigitDTipoVerificaDao) {
		this.sigitDTipoVerificaDao = sigitDTipoVerificaDao;
	}
	
	
	
	public SigitDTipoConclusioneDao getSigitDTipoConclusioneDao() {
		return sigitDTipoConclusioneDao;
	}

	public void setSigitDTipoConclusioneDao(SigitDTipoConclusioneDao sigitDTipoConclusioneDao) {
		this.sigitDTipoConclusioneDao = sigitDTipoConclusioneDao;
	}

	public SigitTPersonaFisicaDao getSigitTPersonaFisicaDao() {
		return sigitTPersonaFisicaDao;
	}

	public void setSigitTPersonaFisicaDao(
			SigitTPersonaFisicaDao sigitTPersonaFisicaDao) {
		this.sigitTPersonaFisicaDao = sigitTPersonaFisicaDao;
	}
	

	public SigitDStatoSanzioneDao getSigitDStatoSanzioneDao() {
		return sigitDStatoSanzioneDao;
	}

	public void setSigitDStatoSanzioneDao(SigitDStatoSanzioneDao sigitDStatoSanzioneDao) {
		this.sigitDStatoSanzioneDao = sigitDStatoSanzioneDao;
	}

	protected DbMgr dbMgr;
	
	/**
	 * Restituisce il manager del DB
	 * 
	 * @return Manager del DB
	 */
	public DbMgr getDbMgr() {
		return dbMgr;
	}

	/**
	 * Imposta i manager del DB
	 * 
	 * @param serviziMgr Manager del DB
	 */
	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}
	
	public List<SigitDTipoVerificaDto> getElencoTipoVerifiche() throws DbManagerException {
		log.debug("[DbVerificaMgr::getElencoTipoVerifiche] BEGIN");
			try {
				return getSigitDTipoVerificaDao().findAll();
			} catch (SigitDTipoVerificaDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			} finally {
				log.debug("[DbVerificaMgr::getElencoTipoVerifiche] END");
			}
		
	}
	
	public List<SigitDStatoAccertamentoDto> getElencoStatoAccertamento() throws DbManagerException {
		log.debug("[DbVerificaMgr::getElencoStatoAccertamento] BEGIN");
			try {
				return getSigitDStatoAccertamentoDao().findAll();
			} catch (SigitDStatoAccertamentoDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			} finally {
				log.debug("[DbVerificaMgr::getElencoStatoAccertamento] END");
			}
		
	}
	
	public List<SigitDTipoConclusioneDto> getElencoTipoConclusione() throws DbManagerException {
		log.debug("[DbVerificaMgr::getElencoTipoConclusione] BEGIN");
			try {
				return getSigitDTipoConclusioneDao().findAll();
			} catch (SigitDTipoConclusioneDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			} finally {
				log.debug("[DbVerificaMgr::getElencoTipoConclusione] END");
			}
		
	}
	
	
	
	public List<SigitDStatoSanzioneDto> getElencoStatoSanzione() throws DbManagerException {
		log.debug("[DbVerificaMgr::getElencoStatoSanzione] BEGIN");
			try {
				return getSigitDStatoSanzioneDao().findAll();
			} catch (SigitDStatoSanzioneDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			} finally {
				log.debug("[DbVerificaMgr::getElencoStatoSanzione] END");
			}
		
	}
	
	public List<SigitTVerificaDto> getElencoVerificheByFilter(RicercaVerificaFilter filter) throws DbManagerException {
		log.debug("[DbVerificaMgr::getElencoVerificheByFilter] BEGIN");
		
		try {
			return getSigitTVerificaDao().findByExample(filter);
		} catch (SigitTVerificaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbVerificaMgr::getElencoVerificheByFilter] END");
		}
		
	}
	
	public List<SigitTAccertamentoDto> getElencoAccertamentiByFilter(RicercaAccertamentoFilter filter) throws DbManagerException {
		log.debug("[DbVerificaMgr::getElencoAccertamentiByFilter] BEGIN");
		
		try {
			return getSigitTAccertamentoDao().findByFilter(filter);
		} catch (SigitTAccertamentoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbVerificaMgr::getElencoAccertamentiByFilter] END");
		}
		
	}
	
	public SigitExtVerificaDto getVerificaById(Integer idVerifica) throws DbManagerException {
		log.debug("[DbVerificaMgr::getVerificaById] BEGIN");
		
		try {
//			SigitTVerificaDto verifica =  getSigitTVerificaDao().findByPrimaryKey(new SigitTVerificaPk(idVerifica));
			SigitExtVerificaDto verifica = null;
			List<SigitExtVerificaDto> verifiche = getSigitExtDao().findVerificaById(new SigitTVerificaPk(idVerifica));
			if (verifiche != null && verifiche.size()==1) {
				verifica = verifiche.get(0);
			}
			
			return verifica;
		} catch (SigitExtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}  finally {
			log.debug("[DbVerificaMgr::getVerificaById] END");
		}
		
	}

	public SigitTAccertamentoDto getAccertamentoById(Integer idAccertamento) throws DbManagerException {
		log.debug("[DbVerificaMgr::getAccertamentoById] BEGIN");
		
		try {
			return getSigitTAccertamentoDao().findByPrimaryKey(new SigitTAccertamentoPk(idAccertamento));
		} catch (SigitTAccertamentoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}  finally {
			log.debug("[DbVerificaMgr::getAccertamentoById] END");
		}
		
	}

	
	public void eliminaVerificaById(Integer idVerifica) throws DbManagerException {
		log.debug("[DbVerificaMgr::eliminaVerificaById] BEGIN");
		
		try {
			getSigitTVerificaDao().delete(new SigitTVerificaPk(idVerifica));
		}
		catch (SigitTVerificaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}  finally {
			log.debug("[DbVerificaMgr::eliminaVerificaById] END");
		}
	}
	
	public void annullaAccertamentoById(Integer idAccertamento, String cfAnnullamento) throws DbManagerException {
		log.debug("[DbVerificaMgr::annullaAccertamentoById] BEGIN");
		
		try {
			SigitTAccertamentoDto accertamento = getSigitTAccertamentoDao().findByPrimaryKey(new SigitTAccertamentoPk(idAccertamento));
			
			accertamento.setFkStatoAccertamento(Constants.ID_STATO_ACCERTAMENTO_ANNULLATO);
			accertamento.setDtSveglia(null);
			accertamento.setNoteSveglia(null);

			getSigitTAccertamentoDao().update(accertamento);
			
			//se l'accertamento che sto annullando e' associato a VERIFICA di tipo decandeza 3R allora set T_IMPANTO_flg_blocco_nomina=0
			//recupero la verifica se associata
			if (accertamento.getFkVerifica() != null) {
				SigitTVerificaDto verifica = getSigitTVerificaDao().findByPrimaryKey(new SigitTVerificaPk(accertamento.getFkVerifica()));
				if (TipoVerificaEnum.DECADENZA3R.getIdDb().equals(verifica.getFkTipoVerifica())) {
					getDbMgr().aggiornaImpiantoSblocca3R(ConvertUtil.convertToString(accertamento.getCodiceImpianto()), cfAnnullamento, false);
				}
			}
		}
		catch (SigitTAccertamentoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTVerificaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}  finally {
			log.debug("[DbVerificaMgr::annullaAccertamentoById] END");
		}
	}
	
	public void concludiAccertamento(Integer idAccertamento, Integer idTipoConclusione, String codiceImpiantoNew, String codIstatProv, String cfConclusione) throws DbManagerException {
		log.debug("[DbVerificaMgr::concludiAccertamento] BEGIN");
		
		try {
			
			SigitTAccertamentoDto accertamento = getSigitTAccertamentoDao().findByPrimaryKey(new SigitTAccertamentoPk(idAccertamento));
			
			accertamento.setFkStatoAccertamento(Constants.ID_STATO_ACCERTAMENTO_CONCLUSO);
			accertamento.setDtConclusione(DateUtil.getSqlCurrentDate());
			accertamento.setFkTipoConclusione(idTipoConclusione);
			
			if (GenericUtil.isNotNullOrEmpty(codiceImpiantoNew))
			{
				accertamento.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codiceImpiantoNew));
				accertamento.setIstatProvCompetenza(codIstatProv);
			}
			
			accertamento.setDtSveglia(null);
			accertamento.setNoteSveglia(null);
			
			getSigitTAccertamentoDao().update(accertamento);
			//se l'accertamento che sto concludendo e' associato a VERIFICA di tipo decandeza 3R allora set T_IMPANTO_flg_blocco_nomina=1
			//recupero la verifica se associata
			if (accertamento.getFkVerifica() != null) {
				SigitTVerificaDto verifica = getSigitTVerificaDao().findByPrimaryKey(new SigitTVerificaPk(accertamento.getFkVerifica()));
				if (TipoVerificaEnum.DECADENZA3R.getIdDb().equals(verifica.getFkTipoVerifica())) {
					getDbMgr().aggiornaImpiantoSblocca3R(ConvertUtil.convertToString(accertamento.getCodiceImpianto()), cfConclusione, false);
				}
			}
		}
		catch (SigitTAccertamentoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTVerificaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}  finally {
			log.debug("[DbVerificaMgr::concludiAccertamento] END");
		}
	}
	

	public SigitTVerificaPk salvaVerifica (SigitTVerificaDto entity) throws DbManagerException {
		log.debug("[DbVerificaMgr::salvaVerifica] BEGIN");
		//PREPARAZIONE AL SALVATAGGIO CON I DEFAULT
		if (entity.getCodiceImpianto() == null) {
			entity.setCodiceImpianto(new BigDecimal(0));
		}
		if (entity.getFkAllegato() == null) {
			entity.setFkAllegato(new BigDecimal(0));
		}
		if (entity.getFkDatoDistrib() == null) {
			entity.setFkDatoDistrib(0);
		}
		if (entity.getNumeroBollino() == null) {
			entity.setNumeroBollino(new BigDecimal(0));
		}
		if (entity.getSiglaBollino() == null) {
			entity.setSiglaBollino("");
		}
		try {
			if (entity.getIdVerifica() != null) {
				getSigitTVerificaDao().update(entity);
				return new SigitTVerificaPk(entity.getIdVerifica());
			} else {
				return getSigitTVerificaDao().insert(entity);
			}
		}catch (SigitTVerificaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}  finally {
			log.debug("[DbVerificaMgr::salvaVerifica] END");
		}
	}

	public SigitTAccertamentoPk salvaAccertamento (SigitTAccertamentoDto entity) throws DbManagerException {
		log.debug("[DbVerificaMgr::salvaAccertamento] BEGIN");
		//PREPARAZIONE AL SALVATAGGIO CON I DEFAULT
		if (entity.getCodiceImpianto() == null) {
			entity.setCodiceImpianto(new BigDecimal(0));
		}
		try {
			if (entity.getIdAccertamento() != null) {
				getSigitTAccertamentoDao().update(entity);
				return new SigitTAccertamentoPk(entity.getIdAccertamento());
			} else {

				entity.setFkTipoConclusione(Constants.DATO_NON_DISPONIBILE);
				entity.setFkStatoAccertamento(Constants.ID_STATO_ACCERTAMENTO_IN_CORSO);

				return getSigitTAccertamentoDao().insert(entity);
			}
		}catch (SigitTAccertamentoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}  finally {
			log.debug("[DbVerificaMgr::salvaAccertamento] END");
		}
	}
	
	public List<SigitTPersonaFisicaValidatoriDto> getElencoValidatori() throws DbManagerException {
		log.debug("[DbVerificaMgr::getElencoValidatori] BEGIN");
			try {
				return getSigitTPersonaFisicaDao().findValidatori(null);
			} catch (SigitTPersonaFisicaDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			} finally {
				log.debug("[DbVerificaMgr::getElencoValidatori] END");
			}
		
	}
	
	public List<SigitTPersonaFisicaDaRuoloPADto> getElencoPfDaRuolo(Integer idRuolo, boolean isSoloAttivi) throws DbManagerException {
		log.debug("[DbVerificaMgr::getElencoPfDaRuolo] BEGIN");
			try {
//				null; li ricerco tutti				
//				1;"Consultatore"
//				2;"Ispettore"
//				3;"Superuser"
//				4;"Validatore"

				PersonaRuoloFilter prFilter = new PersonaRuoloFilter();
				
				if (idRuolo != null)
				{
					prFilter.setIdRuolo(idRuolo);
				}
				
				prFilter.setSoloAttivi(isSoloAttivi);
				
				/*
				Integer inputPerQuery = null;
				if ("VALIDATORE".equalsIgnoreCase(ruolo)) {
					inputPerQuery = new Integer(4);
				} else if ("ISPETTORE".equalsIgnoreCase(ruolo)) {
					inputPerQuery = new Integer(2);
				} else if ("CONSULTATORE".equalsIgnoreCase(ruolo)) {
					inputPerQuery = new Integer(1);
				} else if ("SUPERUSER".equalsIgnoreCase(ruolo)) {
					inputPerQuery = new Integer(3);
				}
				*/
				
				
				return getSigitTPersonaFisicaDao().findDaRuoloPA(prFilter);
			} catch (SigitTPersonaFisicaDaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			} finally {
				log.debug("[DbVerificaMgr::getElencoValidatori] END");
			}
		
	}
	
	public SigitDTipoVerificaDto getTipoVerificaById(int id) throws DbManagerException {
		log.debug("[DbVerificaMgr::getTipoVerificaById] BEGIN");
		try {
			return getSigitDTipoVerificaDao().findByPrimaryKey(new SigitDTipoVerificaPk(id));
		} catch (SigitDTipoVerificaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbVerificaMgr::getTipoVerificaById] END");
		}
	}
	

}
