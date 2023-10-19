/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.manager.db;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitDStatoIspezioneDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitExtDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTDettIspezGfDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTDettIspezGtDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTIspezione2018Dao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTRappIspezGfDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTRappIspezGtDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitVRicercaIspezioniDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitWrkConfigDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDStatoIspezioneDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitExtIspezione2018Dto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRImpRuoloPfpgDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRImpRuoloPfpgPk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRIspezIspetDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRIspezIspetPk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAccertamentoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAzioneDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGfDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGtDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTIspezione2018Dto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTIspezione2018Pk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaFisicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTRappIspezGfDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTRappIspezGfPk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTRappIspezGtDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTRappIspezGtPk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTVerificaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicercaIspezioniDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitWrkConfigDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDStatoIspezioneDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitRImpRuoloPfpgDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitRIspezIspetDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTDettIspezGfDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTDettIspezGtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTIspezione2018DaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTRappControlloDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTRappIspezGfDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTRappIspezGtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVRicercaIspezioniDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitWrkConfigDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaIspezioniFilter;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.dto.accertamento.Accertamento;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaFisica;
import it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.DateUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.ReplaceSpecialCharUtils;
import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class DbIspezioneMgr {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager.db");
	private SigitTIspezione2018Dao sigitTIspezione2018Dao;
	private SigitWrkConfigDao sigitWrkConfigDao = null;
	private SigitExtDao sigitExtDao = null;
	private SigitDStatoIspezioneDao sigitDStatoIspezioneDao;
	protected DbMgr dbMgr;
	private DbAzioneMgr dbAzioneMgr;
	private DbVerificaMgr dbVerificaMgr;
	private SigitTRappIspezGtDao sigitTRappIspezGtDao;
	private SigitTDettIspezGtDao sigitTDettIspezGtDao;
	private SigitTRappIspezGfDao sigitTRappIspezGfDao;
	private SigitTDettIspezGfDao sigitTDettIspezGfDao;
	
	
	public DbVerificaMgr getDbVerificaMgr() {
		return dbVerificaMgr;
	}
	public void setDbVerificaMgr(DbVerificaMgr dbVerificaMgr) {
		this.dbVerificaMgr = dbVerificaMgr;
	}
	public DbAzioneMgr getDbAzioneMgr() {
		return dbAzioneMgr;
	}
	public void setDbAzioneMgr(DbAzioneMgr dbAzioneMgr) {
		this.dbAzioneMgr = dbAzioneMgr;
	}
	public DbMgr getDbMgr() {
		return dbMgr;
	}
	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}
	public SigitDStatoIspezioneDao getSigitDStatoIspezioneDao() {
		return sigitDStatoIspezioneDao;
	}
	public void setSigitDStatoIspezioneDao(SigitDStatoIspezioneDao sigitDStatoIspezioneDao) {
		this.sigitDStatoIspezioneDao = sigitDStatoIspezioneDao;
	}
	public SigitExtDao getSigitExtDao() {
		return sigitExtDao;
	}
	public void setSigitExtDao(SigitExtDao sigitExtDao) {
		this.sigitExtDao = sigitExtDao;
	}
	public SigitWrkConfigDao getSigitWrkConfigDao() {
		return sigitWrkConfigDao;
	}
	public void setSigitWrkConfigDao(SigitWrkConfigDao sigitWrkConfigDao) {
		this.sigitWrkConfigDao = sigitWrkConfigDao;
	}
	public SigitTIspezione2018Dao getSigitTIspezione2018Dao() {
		return sigitTIspezione2018Dao;
	}
	public void setSigitTIspezione2018Dao(SigitTIspezione2018Dao sigitTIspezione2018Dao) {
		this.sigitTIspezione2018Dao = sigitTIspezione2018Dao;
	}
	
	
	public SigitTRappIspezGtDao getSigitTRappIspezGtDao() {
		return sigitTRappIspezGtDao;
	}
	public void setSigitTRappIspezGtDao(SigitTRappIspezGtDao sigitTRappIspezGtDao) {
		this.sigitTRappIspezGtDao = sigitTRappIspezGtDao;
	}
	public SigitTDettIspezGtDao getSigitTDettIspezGtDao() {
		return sigitTDettIspezGtDao;
	}
	public void setSigitTDettIspezGtDao(SigitTDettIspezGtDao sigitTDettIspezGtDao) {
		this.sigitTDettIspezGtDao = sigitTDettIspezGtDao;
	}
	
	public SigitTRappIspezGfDao getSigitTRappIspezGfDao() {
		return sigitTRappIspezGfDao;
	}
	public void setSigitTRappIspezGfDao(SigitTRappIspezGfDao sigitTRappIspezGfDao) {
		this.sigitTRappIspezGfDao = sigitTRappIspezGfDao;
	}
	public SigitTDettIspezGfDao getSigitTDettIspezGfDao() {
		return sigitTDettIspezGfDao;
	}
	public void setSigitTDettIspezGfDao(SigitTDettIspezGfDao sigitTDettIspezGfDao) {
		this.sigitTDettIspezGfDao = sigitTDettIspezGfDao;
	}
	
	/**
	 * DAO per accedere alla tabella VISTA_RICERCA_ISPEZIONI
	 */
	private SigitVRicercaIspezioniDao sigitVRicercaIspezioniDao = null;
	
	public SigitVRicercaIspezioniDao getSigitVRicercaIspezioniDao() {
		return sigitVRicercaIspezioniDao;
	}

	public void setSigitVRicercaIspezioniDao(
			SigitVRicercaIspezioniDao sigitVRicercaIspezioniDao) {
		this.sigitVRicercaIspezioniDao = sigitVRicercaIspezioniDao;
	}
	public SigitTIspezione2018Dto caricaIspezioneDaId (Integer idIspezione) throws DbManagerException {
		log.debug("[DbIspezioneMgr::caricaIspezioneDaId] BEGIN");
		
		SigitTIspezione2018Dto ispezione;
		try {
			ispezione = getSigitTIspezione2018Dao().findByPrimaryKey(new SigitTIspezione2018Pk(idIspezione));
		} catch (SigitTIspezione2018DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}finally {
			log.debug("[DbIspezioneMgr::caricaIspezioneDaId] END");
		}
		
		return ispezione;
		
	}
	
	
	public SigitTIspezione2018Pk inserisciIspezione2018(Ispezione2018 ispezione) throws DbManagerException {
		log.debug("[DbIspezioneMgr::inserisciIspezione2018] BEGIN");
		try {
			
			//nell'inserimento dell'ispezione viene settato lo stato bozza
			SigitTIspezione2018Dto nuovaIspezione = new SigitTIspezione2018Dto();
			nuovaIspezione.setFkStatoIspezione(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_ISPEZIONE_BOZZA));
			nuovaIspezione.setDtCreazione(DateUtil.getSqlDataCorrente());
			nuovaIspezione.setFkAccertamento(ConvertUtil.convertToInteger(ispezione.getIdAccertamento()));
			nuovaIspezione.setFkVerifica(ConvertUtil.convertToInteger(ispezione.getIdVerifica()));
			nuovaIspezione.setNote(ReplaceSpecialCharUtils.sanitize(ispezione.getNote()));
			
			if (GenericUtil.isNullOrEmpty(ispezione.getCodiceImpianto())) {
				ispezione.setCodiceImpianto("0");
			}
			
			nuovaIspezione.setCodiceImpianto(ConvertUtil.convertToBigDecimal(ispezione.getCodiceImpianto()));
			log.debug("#################-istat prov: "+ispezione.getCodIstatProv());
			nuovaIspezione.setIstatProvCompetenza(ReplaceSpecialCharUtils.sanitize(ispezione.getCodIstatProv()));
			log.debug("##################-istat com: "+ispezione.getCodIstatCom());
			nuovaIspezione.setIstatComuneCompetenza(ReplaceSpecialCharUtils.sanitize(ispezione.getCodIstatCom()));
			nuovaIspezione.setFlgIspPagamento(ConvertUtil.convertToBigDecimal(ispezione.getFlgIspPagamento()));
			
			return getSigitTIspezione2018Dao().insert(nuovaIspezione);
			
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbIspezioneMgr::inserisciIspezione2018] END");
		}
	}
	
	public SigitTIspezione2018Pk inserisciIspezione2018(Accertamento accertamento, int esito) throws DbManagerException {
		log.debug("[DbIspezioneMgr::inserisciIspezione2018] BEGIN");
		try {
			
			SigitTIspezione2018Dto nuovaIspezione = new SigitTIspezione2018Dto();
			nuovaIspezione.setFkStatoIspezione(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_ISPEZIONE_CONSOLIDATO));
			nuovaIspezione.setDtCreazione(DateUtil.getSqlDataCorrente());
			nuovaIspezione.setFkAccertamento(ConvertUtil.convertToInteger(accertamento.getIdentificativo()));
			nuovaIspezione.setFkVerifica(0);
			nuovaIspezione.setNote("Accertamento documentale");
			
			nuovaIspezione.setCodiceImpianto(ConvertUtil.convertToBigDecimal(accertamento.getCodiceImpianto()));
			nuovaIspezione.setIstatProvCompetenza(ReplaceSpecialCharUtils.sanitize(accertamento.getCodIstatProv()));
			nuovaIspezione.setIstatComuneCompetenza(ReplaceSpecialCharUtils.sanitize(accertamento.getCodIstatCom()));
			log.debug("#################-istat prov: "+accertamento.getCodIstatProv());
			log.debug("#################-istat com: "+accertamento.getCodIstatProv());
			nuovaIspezione.setEnteCompetente("PROVINCIA");
			nuovaIspezione.setFlgEsito(ConvertUtil.convertToBigDecimal(esito));
			nuovaIspezione.setDtConclusione(DateUtil.getSqlDataCorrente());
			nuovaIspezione.setFlgAccSostitutivo(ConvertUtil.convertToBigDecimal(Constants.SI_1));
			nuovaIspezione.setFlgIspPagamento(ConvertUtil.convertToBigDecimal(Constants.NO_0));

			return getSigitTIspezione2018Dao().insert(nuovaIspezione);
			
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbIspezioneMgr::inserisciIspezione2018] END");
		}
	}
	
	public SigitRIspezIspetPk inserisciIspezIspetByAccert(Accertamento accertamento, Integer idIspezione2018, String cfUtenteLoggato) throws DbManagerException {
		log.debug("[DbIspezioneMgr::inserisciIspezIspetByAccert] BEGIN");
		try {
			
			SigitRIspezIspetDto ispezIspet = new SigitRIspezIspetDto();
			ispezIspet.setFkRuolo(ConvertUtil.convertToBigDecimal(Constants.ID_RUOLO_ISPETTORE_VALIDATORE));
			ispezIspet.setDataInizio(DateUtil.getSqlCurrentDate());
			ispezIspet.setDataFine(DateUtil.getSqlCurrentDate());
			ispezIspet.setFkPersonaFisica(ConvertUtil.convertToBigDecimal(accertamento.getIdValidatore()));
			ispezIspet.setDataUltMod(DateUtil.getSqlDataCorrente());
			ispezIspet.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteLoggato));
			ispezIspet.setIdIspezione2018(idIspezione2018);

			return getDbMgr().getSigitRIspezIspetDao().insert(ispezIspet);
			
		}
		catch(Exception e) {

			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbIspezioneMgr::inserisciIspezIspetByAccert] END");
		}
	}
	
	 public void modificaIspezioneDaDettaglio(Ispezione2018 ispezione) throws DbManagerException {
		log.debug("[DbIspezioneMgr::modificaIspezioneDaDettaglio] BEGIN");
		try {
			
		 SigitTIspezione2018Dto example = new SigitTIspezione2018Dto();
		 example.setCfIspettoreSecondario(ReplaceSpecialCharUtils.sanitize(ispezione.getCfSecondoIspettore()));
		 example.setFlgIspPagamento(ConvertUtil.convertToBigDecimal(ispezione.getFlgIspPagamento()));
		 example.setNote(ReplaceSpecialCharUtils.sanitize(ispezione.getNote()));
		 example.setIdIspezione2018(ConvertUtil.convertToInteger(ispezione.getIdentificativoIspezione()));
		 example.setIstatComuneCompetenza(ReplaceSpecialCharUtils.sanitize(ispezione.getCodIstatCom()));
		 example.setIstatProvCompetenza(ReplaceSpecialCharUtils.sanitize(ispezione.getCodIstatProv()));
		 getSigitTIspezione2018Dao().updateColumnsModificaIspezioneDaDettaglio(example);
		} catch (SigitTIspezione2018DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[DbIspezioneMgr::modificaIspezioneDaDettaglio] END");
		}
	 }
	
	public void concludiIspezione(Integer idIspezione, BigDecimal esito, String enteCompetente, String note) throws DbManagerException {
		log.debug("[DbIspezioneMgr::concludiIspezione] BEGIN");
		
		try {
			SigitTIspezione2018Dto ispezione = getSigitTIspezione2018Dao().findByPrimaryKey(new SigitTIspezione2018Pk(idIspezione));
			
			ispezione.setFkStatoIspezione(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_ISPEZIONE_CONSOLIDATO));
			ispezione.setDtConclusione(DateUtil.getSqlDataCorrente());
			ispezione.setEnteCompetente(enteCompetente);
			ispezione.setNote(note);
			ispezione.setFlgEsito(esito);
			ispezione.setDtSveglia(null);
			ispezione.setNoteSveglia(null);
			
			getSigitTIspezione2018Dao().update(ispezione);
		} catch (SigitTIspezione2018DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}  finally {
			log.debug("[DbIspezioneMgr::concludiIspezione] END");
		}
	}
	
	
	public void annullaIspezione(Integer idIspezione) throws DbManagerException {
		log.debug("[DbIspezioneMgr::annullaIspezione] BEGIN");
		
		try {
			SigitTIspezione2018Dto ispezione = getSigitTIspezione2018Dao().findByPrimaryKey(new SigitTIspezione2018Pk(idIspezione));
			
			ispezione.setFkStatoIspezione(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_ISPEZIONE_ANNULLATO));
			ispezione.setDtSveglia(null);
			ispezione.setNoteSveglia(null);
			
			getSigitTIspezione2018Dao().update(ispezione);
		} catch (SigitTIspezione2018DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}  finally {
			log.debug("[DbIspezioneMgr::concludiIspezione] END");
		}
	}
	
	
	public List<SigitExtIspezione2018Dto> findIspezioniByFilterOLD(RicercaIspezioniFilter filter) throws ManagerException {
		log.debug("[DbIspezioneMgr::findIspezioniByFilterOLD] BEGIN");
		
		try {
			List<SigitExtIspezione2018Dto> ispezioni = getSigitExtDao().findIspezioni2018ByFilter(filter);
			
			if (ispezioni != null && ispezioni.size() > 0) {
				validateResultSize(ispezioni.size(), Constants.MAX_RIGHE);
			}
			
			return ispezioni;
		} catch (SigitExtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}  finally {
			log.debug("[DbIspezioneMgr::findIspezioniByFilterOLD] END");
		}
		
	}
	
	public List<SigitVRicercaIspezioniDto> findIspezioniByFilter(RicercaIspezioniFilter filter) throws ManagerException {
		log.debug("[DbIspezioneMgr::findIspezioniByFilter] BEGIN");
		
		try {
			// Questa query ritorna dei dati duplicati (in base a quanti elementi trova su SIGIT_R_ISPEZ_ISPET, 
			// nel metodo di rimappaggio dati devo escludere gli id_ispez_ispet pi� vecchi, devo prendere solo l'ultimo
			// per questo motivo il calcolo del totale risultati devo spostarlo, perch� questo potrebbe non essere corretto
			List<SigitVRicercaIspezioniDto> ispezioni = getSigitVRicercaIspezioniDao().findByIspezioneFilter(filter);
			
//			if (ispezioni != null && ispezioni.size() > 0) {
//				validateResultSize(ispezioni.size(), Constants.MAX_RIGHE);
//			}
			
			return ispezioni;
		} catch (SigitVRicercaIspezioniDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}  finally {
			log.debug("[DbIspezioneMgr::findIspezioniByFilter] END");
		}
		
	}
	
	private void validateResultSize(Integer count, String filter) throws ValidationManagerException, DbManagerException {
		log.debug("[DbIspezioneMgr::validateResultSize] BEGIN");
		List<SigitWrkConfigDto> configDtoList = null;
		long maxSize;

		try {
			configDtoList = getSigitWrkConfigDao().findByChiaveConfig(filter);
			if(configDtoList.size() > 0) {
				maxSize = configDtoList.get(0).getValoreConfigNum().longValue();
				log.debug("Dimensione max risultati: " + maxSize);
				if((count == null) || (count.intValue() > maxSize)) {
					throw new ValidationManagerException(new Message(Messages.I002, Message.INFO));
				}
			}
		}
		catch(SigitWrkConfigDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbIspezioneMgr::validateResultSize] END");
		}
	}
	
	public List<SigitDStatoIspezioneDto> getElencoStatoIspezione() throws DbManagerException {
		log.debug("[DbIspezioneMgr::getElencoStatoIspezione] BEGIN");
		try {
			return getSigitDStatoIspezioneDao().findAll();
		} catch (SigitDStatoIspezioneDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbIspezioneMgr::getElencoStatoIspezione] END");
		}
		
	}
	
	@Transactional
	public String associaIspezione(String identificativoIspezione, String idIspettoreNew, UtenteLoggato utente) throws DbManagerException {
		log.debug("[DbAzioneMgr::associaIspezione] BEGIN");
		try {
			
			SigitRIspezIspetDto ispezIspetOld = getDbMgr().cercaUltimoRIspezIspetByIdIspezione(identificativoIspezione);

			boolean primaAssegnazione = ispezIspetOld == null || ispezIspetOld.getFkPersonaFisica() == null;
			
			SigitTPersonaFisicaDto nuovoAssegnatario = getDbMgr().cercaTPersonaFisicaById(ConvertUtil.convertToInteger(idIspettoreNew));
			SigitTPersonaFisicaDto vecchioAssegnatario = null; //verra' valorizzato solo se esiste gia' l'fk_persona_fisica
			//SigitRImpRuoloPfpgDto ispettore = null;
			//SigitRImpRuoloPfpgPk pkIspettore = null;
			StringBuffer sbDescr = new StringBuffer("Variazione utente assegnatario ");
			
			if (!primaAssegnazione) {

				//esiste gia' la riga associata all'ispezione. su questa riga va eseguita la modifica sulla data fine
				if (ispezIspetOld.getDataFine() == null)
				{
					ispezIspetOld.setDataFine(DateUtil.getSqlCurrentDate());
					ispezIspetOld.setDataUltMod(DateUtil.getSqlDataCorrente());
					ispezIspetOld.setUtenteUltMod(utente.getCodiceFiscale());
					getDbMgr().getSigitRIspezIspetDao().updateColumnsAggiornaDataFine(ispezIspetOld);
				}

				if (ispezIspetOld.getFkPersonaFisica() != null)
				{
					// bisogna preparare la mail per il vecchio Ispettore
					vecchioAssegnatario = getDbMgr().cercaTPersonaFisicaById(ConvertUtil.convertToInteger(ispezIspetOld.getFkPersonaFisica()));
	
					sbDescr.append(" da " + ConvertUtil.getStringByConcat(" ", vecchioAssegnatario.getNome(), vecchioAssegnatario.getCognome()));
					sbDescr.append(" ("+vecchioAssegnatario.getCodiceFiscale()+")");
				}
			} 


			SigitTIspezione2018Dto ispezione = getSigitTIspezione2018Dao().findByPrimaryKey(new SigitTIspezione2018Pk(ConvertUtil.convertToInteger(identificativoIspezione)));

			SigitRIspezIspetDto ispezIspetNew = new SigitRIspezIspetDto();
			//ispezIspetNew.setCodiceImpianto(ispezione.getCodiceImpianto());
			ispezIspetNew.setFkRuolo(ConvertUtil.convertToBigDecimal(Constants.ID_RUOLO_ISPETTORE));
			ispezIspetNew.setDataInizio(DateUtil.getSqlCurrentDate());
			ispezIspetNew.setDataFine(null); //ruolo attivo (verra' disattivato con il concludi ispezione)
			ispezIspetNew.setFkPersonaFisica(ConvertUtil.convertToBigDecimal(idIspettoreNew));
			ispezIspetNew.setDataUltMod(DateUtil.getSqlDataCorrente());
			ispezIspetNew.setUtenteUltMod(utente.getCodiceFiscale());
			ispezIspetNew.setIdIspezione2018(ispezione.getIdIspezione2018());

			getDbMgr().getSigitRIspezIspetDao().insert(ispezIspetNew);

			// bisogna preparare la mail per il nuovo Ispettore

			sbDescr.append(" a " + ConvertUtil.getStringByConcat(" ", nuovoAssegnatario.getNome(), nuovoAssegnatario.getCognome()));
			sbDescr.append(" ("+nuovoAssegnatario.getCodiceFiscale()+")");

			getDbAzioneMgr().inserisciAzioneSimply(sbDescr.toString(), Constants.ID_TIPO_AZIONE_ISPEZIONE, utente, ispezione.getIdIspezione2018());

			
			return nuovoAssegnatario.getEmail();
			
		} catch (DbManagerException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitRIspezIspetDaoException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTIspezione2018DaoException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbIspezioneMgr::associaIspezione] END");
		}	
	}
	
	@Transactional
	public String associaIspezioneOLD(String identificativoIspezione, String idIspettore, UtenteLoggato utente) throws DbManagerException {
		log.debug("[DbAzioneMgr::associaIspezione] BEGIN");
		/*
		try {
			SigitTIspezione2018Dto ispezioneDb = caricaIspezioneDaId(ConvertUtil.convertToInteger(identificativoIspezione));
			boolean variazioneAssegnatario = false;
			
			
			boolean primaAssegnazione = ispezioneDb.getFkImpRuoloPfpgIspettore() == null;
			
			SigitTPersonaFisicaDto nuovoAssegnatario = getDbMgr().cercaTPersonaFisicaById(ConvertUtil.convertToInteger(idIspettore));
			SigitTPersonaFisicaDto vecchioAssegnatario = null; //verra' valorizzato solo se esiste gia' l'imp_ruolo_pf_pg
			SigitRImpRuoloPfpgDto ispettore = null;
			SigitRImpRuoloPfpgPk pkIspettore = null;
			StringBuffer sbDescr = new StringBuffer("Variazione utente assegnatario ");
			if (!primaAssegnazione) {
				//esiste gia' la riga associata all'ispezione. su questa riga va eseguita la modifica
				pkIspettore = new SigitRImpRuoloPfpgPk(ispezioneDb.getFkImpRuoloPfpgIspettore());
				ispettore = getDbMgr().getSigitRImpRuoloPfpgDao().findByPrimaryKey(pkIspettore);
				
				//poiche' la riga sull'imp_ruolo resta sempre la stessa e subisce solo degli update una volta creata, la variazione si ha solo se e' cambiata l'id della persona fisica
				if (!nuovoAssegnatario.getIdPersonaFisica().equals(ispettore.getFkPersonaFisica())) {
					variazioneAssegnatario = true;
					vecchioAssegnatario = getDbMgr().cercaTPersonaFisicaById(ConvertUtil.convertToInteger(ispettore.getFkPersonaFisica()));
					
					//la modifica sul db viene fatta solo per la pf
					ispettore.setDataUltMod(DateUtil.getSqlDataCorrente());
					ispettore.setUtenteUltMod(utente.getCodiceFiscale());
					ispettore.setFkPersonaFisica(ConvertUtil.convertToBigDecimal(idIspettore));
					
					getDbMgr().getSigitRImpRuoloPfpgDao().update(ispettore);
					
					sbDescr.append(" da " + ConvertUtil.getStringByConcat(" ", vecchioAssegnatario.getNome(), vecchioAssegnatario.getCognome()));
					sbDescr.append(" ("+vecchioAssegnatario.getCodiceFiscale()+")");
				} else {
					//non c'e' nessuna variazione da notificare
					variazioneAssegnatario = false;
				}
				
			} else {
				//non esiste la riga associata all'ispezione. viene quindi creata
				ispettore = new SigitRImpRuoloPfpgDto();
				ispettore.setFkRuolo(ConvertUtil.convertToBigDecimal(Constants.ID_RUOLO_ISPETTORE));
				ispettore.setCodiceImpianto(ispezioneDb.getCodiceImpianto());
				ispettore.setDataInizio(DateUtil.getSqlCurrentDate());
				ispettore.setDataFine(null); //ruolo attivo (verra' disattivato con il concludi ispezione)
				ispettore.setFkPersonaFisica(ConvertUtil.convertToBigDecimal(idIspettore));
				ispettore.setDataUltMod(DateUtil.getSqlDataCorrente());
				ispettore.setUtenteUltMod(utente.getCodiceFiscale());
				
				pkIspettore = getDbMgr().getSigitRImpRuoloPfpgDao().insert(ispettore);
				
				ispezioneDb.setFkImpRuoloPfpgIspettore(pkIspettore.getIdImpRuoloPfpg());
				//viene quindi aggiornata l'ispezione su questo campo
				getSigitTIspezione2018Dao().update(ispezioneDb);
				
				variazioneAssegnatario = true;
			}
			
			if (variazioneAssegnatario) {
				sbDescr.append(" a " + ConvertUtil.getStringByConcat(" ", nuovoAssegnatario.getNome(), nuovoAssegnatario.getCognome()));
				sbDescr.append(" ("+nuovoAssegnatario.getCodiceFiscale()+")");
				
				getDbAzioneMgr().inserisciAzioneSimply(sbDescr.toString(), Constants.ID_TIPO_AZIONE_ISPEZIONE, utente, ispezioneDb.getIdIspezione2018());
			}
			
			return variazioneAssegnatario ? nuovoAssegnatario.getEmail() : null;
			
			
		} catch (DbManagerException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitRImpRuoloPfpgDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTIspezione2018DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbIspezioneMgr::associaIspezione] END");
		}	
			*/

		return null;
	}
	
	public Integer getOrigineIspezioneDaDb (SigitTIspezione2018Dto ispezioneDb, Integer idIspezione) throws DbManagerException {
		log.debug("[DbIspezioneMgr::getOrigineIspezione] START"); 
		if (ispezioneDb == null) {
			try {
				ispezioneDb = getSigitTIspezione2018Dao().findByPrimaryKey(new SigitTIspezione2018Pk(idIspezione));
			} catch (SigitTIspezione2018DaoException e) {
				throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
			}
		}
		
		if (ispezioneDb != null) {
			if (ispezioneDb.getFkAccertamento() != null && ispezioneDb.getFkAccertamento().intValue() != 0) {
				log.debug("[DbIspezioneMgr::getOrigineIspezione] origine da accertamento");
				return Constants.ID_TIPO_AZIONE_ACCERTAMENTO;
			}
			
			if (ispezioneDb.getFkVerifica() != null && ispezioneDb.getFkVerifica().intValue() != 0) {
				log.debug("[DbIspezioneMgr::getOrigineIspezione] origine da verifica");
				return Constants.ID_TIPO_AZIONE_VERIFICA;
			}
		}
		
		return null;
	}
	
	public PersonaFisica findPersonaFisicaVerificaAccertamentoDaIspezione (SigitTIspezione2018Dto ispezioneDb, Integer idIspezione) throws DbManagerException {
		log.debug("[DbIspezioneMgr::findPersonaFisicaVerificaAccertamentoDaIspezione] START");
		
		PersonaFisica risultato = null;
		try {
			String cfValidatoreOrigine = null;
			if (ispezioneDb == null) {
				try {
					ispezioneDb = getSigitTIspezione2018Dao().findByPrimaryKey(new SigitTIspezione2018Pk(idIspezione));
				} catch (SigitTIspezione2018DaoException e) {
					throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
				}
			}
			
			if (ispezioneDb != null) {
				//si distingue se si tratta di origine accertamento o verifica
				Integer origine = getOrigineIspezioneDaDb(ispezioneDb, idIspezione);
				if (Constants.ID_TIPO_AZIONE_ACCERTAMENTO == origine) {
					log.debug("[DbIspezioneMgr::findPersonaFisicaVerificaAccertamentoDaIspezione] origine da accertamento");
					//si recupera l'accertamento
					SigitTAccertamentoDto accertamentoOrigine = getDbVerificaMgr().getAccertamentoById(ispezioneDb.getFkAccertamento());
					cfValidatoreOrigine = accertamentoOrigine.getCfUtenteAssegn();
					
				}
				
				if (Constants.ID_TIPO_AZIONE_VERIFICA == origine) {
					log.debug("[DbIspezioneMgr::findPersonaFisicaVerificaAccertamentoDaIspezione] origine da verifica");
					//si recupera la verifica
					SigitTVerificaDto verificaOrigine = getDbVerificaMgr().getVerificaById(ispezioneDb.getFkVerifica());
					cfValidatoreOrigine = verificaOrigine.getCfUtenteCaricamento();
				}
				
				// Se il CF e' INSERTAUTOMATICO vuol dire che e' frutto di ribaltamento quindi non trovera' la Persona Fisica
				if (!cfValidatoreOrigine.equalsIgnoreCase(Constants.CF_INSERTAUTOMATICO))
				{
					//noto il cf si recupera la persona
					risultato = getDbMgr().cercaPersonaFisicaByCF(cfValidatoreOrigine);
				}
				else
				{
					risultato = new PersonaFisica();
					risultato.setCodiceFiscale(Constants.CF_INSERTAUTOMATICO);
				}
				
			}
		
		} finally {
			log.debug("[DbIspezioneMgr::findPersonaFisicaVerificaAccertamentoDaIspezione] END");
		}
		return risultato;	
		
	}
	
	
	
	public SigitTRappIspezGtDto getSigitTRappIspezioneGt(BigDecimal idAllegato) throws ManagerException {
		log.debug("[DbIspezioneMgr::getSigitTRappIspezioneGt] BEGIN");
		
		try {
			return getSigitTRappIspezGtDao().findByPrimaryKey(new SigitTRappIspezGtPk(idAllegato));
			
		} catch (SigitTRappIspezGtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}  finally {
			log.debug("[DbIspezioneMgr::getSigitTRappIspezioneGt] END");
		}
		
	}
	
	public List<SigitTDettIspezGtDto> getSigitTDettIspezioneGtList(BigDecimal idAllegato, BigDecimal progressivo) throws DbManagerException {
		log.debug("[DbIspezioneMgr::getSigitTDettIspezioneGtList] BEGIN");
		try {
			SigitTDettIspezGtDto dto = new SigitTDettIspezGtDto();
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));
			
			return getSigitTDettIspezGtDao().findByExample(dto);
		} catch (SigitTDettIspezGtDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbIspezioneMgr::getSigitTDettIspezioneGtList] END");
		}
		
	}

	public SigitTRappIspezGfDto getSigitTRappIspezioneGf(BigDecimal idAllegato) throws ManagerException {
		log.debug("[DbIspezioneMgr::getSigitTRappIspezioneGf] BEGIN");
		
		try {
			return getSigitTRappIspezGfDao().findByPrimaryKey(new SigitTRappIspezGfPk(idAllegato));
			
		} catch (SigitTRappIspezGfDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}  finally {
			log.debug("[DbIspezioneMgr::getSigitTRappIspezioneGf] END");
		}
		
	}
	
	public List<SigitTDettIspezGfDto> getSigitTDettIspezioneGfList(BigDecimal idAllegato, BigDecimal progressivo) throws DbManagerException {
		log.debug("[DbIspezioneMgr::getSigitTDettIspezioneGfList] BEGIN");
		try {
			SigitTDettIspezGfDto dto = new SigitTDettIspezGfDto();
			dto.setProgressivo(ConvertUtil.convertToBigDecimal(progressivo));
			dto.setFkAllegato(ConvertUtil.convertToBigDecimal(idAllegato));
			
			return getSigitTDettIspezGfDao().findByExample(dto);
		} catch (SigitTDettIspezGfDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbIspezioneMgr::getSigitTDettIspezioneGfList] END");
		}
		
	}

}
