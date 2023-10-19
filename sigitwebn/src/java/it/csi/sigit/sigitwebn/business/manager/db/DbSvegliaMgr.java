/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.manager.db;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTAccertamentoDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTIspezione2018Dao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTSanzioneDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.SigitTVerificaDao;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAccertamentoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAccertamentoPk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTIspezione2018Dto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTIspezione2018Pk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTSanzioneDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTSanzionePk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTVerificaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTVerificaPk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicercaImpiantiDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTAccertamentoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTIspezione2018DaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTSanzioneDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTVerificaDaoException;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.dto.azioni.Sveglia;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.MapDto;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.ReplaceSpecialCharUtils;

public class DbSvegliaMgr {
	
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager.db");
	private SigitTVerificaDao sigitTVerificaDao;
	private SigitTAccertamentoDao sigitTAccertamentoDao;
	private SigitTIspezione2018Dao sigitTIspezione2018Dao;
	protected DbMgr dbMgr;
	private SigitTSanzioneDao sigitTSanzioneDao;
	
	
	
	
	public SigitTSanzioneDao getSigitTSanzioneDao() {
		return sigitTSanzioneDao;
	}
	public void setSigitTSanzioneDao(SigitTSanzioneDao sigitTSanzioneDao) {
		this.sigitTSanzioneDao = sigitTSanzioneDao;
	}
	public SigitTIspezione2018Dao getSigitTIspezione2018Dao() {
		return sigitTIspezione2018Dao;
	}
	public void setSigitTIspezione2018Dao(SigitTIspezione2018Dao sigitTIspezione2018Dao) {
		this.sigitTIspezione2018Dao = sigitTIspezione2018Dao;
	}
	public DbMgr getDbMgr() {
		return dbMgr;
	}
	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
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




	public ArrayList<Sveglia> getSveglieAttiveByCfUtente(int tipoAzione, String cfUtente) throws DbManagerException {
		log.debug("[DbVerificaMgr::getSveglieAttiveByCfUtente] BEGIN");
		
		ArrayList<Sveglia> sveglie = new ArrayList<Sveglia>();
		try {
			
			switch (tipoAzione) {
	        case Constants.ID_TIPO_AZIONE_VERIFICA:
	        	List<SigitTVerificaDto> verifiche = getSigitTVerificaDao().findSveglieAttiveByCF(cfUtente);
	        	sveglie = MapDto.mapToSveglieVerifica(verifiche);
	            break;
	        case Constants.ID_TIPO_AZIONE_ACCERTAMENTO:  
	        	List<SigitTAccertamentoDto> accertamenti = null;
	        	if (cfUtente != null)
	        	{
	    			// sto cercando gli accertamenti assegnati
	        		accertamenti = getSigitTAccertamentoDao().findSveglieAttiveByCF(cfUtente);
	        		sveglie = MapDto.mapToSveglieAccertamento(accertamenti);
	        	}
	        	else
	        	{
	    			// sto cercando gli accertamenti NON assegnati
	        		accertamenti = getSigitTAccertamentoDao().findSveglieAttiveByCF(null);
	        		
	        		for (SigitTAccertamentoDto sigitTAccertamentoDto : accertamenti) {
		    			
	        			SigitVRicercaImpiantiDto impiantoEntity = null;
	        			if (GenericUtil.isNotNullOrEmpty(sigitTAccertamentoDto.getCodiceImpianto()) && 
	        					sigitTAccertamentoDto.getCodiceImpianto().intValue() != Constants.COD_IMPIANTO_VUOTO)
		    			{
	        				impiantoEntity = getDbMgr().cercaImpiantoByCodImpianto(sigitTAccertamentoDto.getCodiceImpianto());
		    			}
        				sveglie.add(MapDto.mapToSvegliaAccertamento(sigitTAccertamentoDto, impiantoEntity));
					}
	        	}
	            break;
	        case Constants.ID_TIPO_AZIONE_ISPEZIONE:  

	        	List<SigitTIspezione2018Dto> ispezioni = null;
	        	if (cfUtente != null)
	        	{
	    			// sto cercando le ispezioni assegnate
	        		ispezioni = getSigitTIspezione2018Dao().findSveglieAttiveByCF(cfUtente);
	        		sveglie = MapDto.mapToSveglieIspezione(ispezioni);
	        	}
	        	else
	        	{
	    			// sto cercando le ispezioni NON assegnate
	        		ispezioni = getSigitTIspezione2018Dao().findSveglieAttiveByCF(null);
	        		
	        		for (SigitTIspezione2018Dto sigitTIspezione2018Dto : ispezioni) {
		    			
	        			SigitVRicercaImpiantiDto impiantoEntity = null;
	        			if (GenericUtil.isNotNullOrEmpty(sigitTIspezione2018Dto.getCodiceImpianto())  && 
	        					sigitTIspezione2018Dto.getCodiceImpianto().intValue() != Constants.COD_IMPIANTO_VUOTO)
		    			{
	        				impiantoEntity = getDbMgr().cercaImpiantoByCodImpianto(sigitTIspezione2018Dto.getCodiceImpianto());
		    			}
        				sveglie.add(MapDto.mapToSvegliaIspezione(sigitTIspezione2018Dto, impiantoEntity));
	        		}
	        	}
	        	break;
	        case Constants.ID_TIPO_AZIONE_SANZIONE:  
	        	
	        	List<SigitTSanzioneDto> sanzioni = getSigitTSanzioneDao().findSveglieAttiveByCF(cfUtente);
	        	sveglie = MapDto.mapToSveglieSanzione(sanzioni);
	        	
	        	break;
	        	
			}
			
		} catch (SigitTVerificaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		catch (SigitTAccertamentoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} 
		catch (SigitTIspezione2018DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} 
		catch (SigitTSanzioneDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbVerificaMgr::getSveglieAttiveByCfUtente] END");
		}
		
		return sveglie;
		
	}
	
	public Sveglia getSvegliaById(int tipoAzione, int idAzione) throws DbManagerException {
		log.debug("[DbVerificaMgr::modificaSveglia] BEGIN");
		
		Sveglia sveglia = new Sveglia();
		String prefissoIdentificativo = "";
		try {
			
			switch (tipoAzione) {
	        case Constants.ID_TIPO_AZIONE_VERIFICA:
	        	SigitTVerificaDto verifica = getSigitTVerificaDao().findByPrimaryKey(new SigitTVerificaPk(idAzione));
	        	sveglia.setDataSveglia(ConvertUtil.convertToString(verifica.getDtSveglia()));
	        	sveglia.setNoteSveglia(verifica.getNoteSveglia());
	        	prefissoIdentificativo = "VERIFICA-";
	            break;
	        case Constants.ID_TIPO_AZIONE_ACCERTAMENTO:  
	        	SigitTAccertamentoDto accertamento = getSigitTAccertamentoDao().findByPrimaryKey(new SigitTAccertamentoPk(idAzione));
	        	sveglia.setDataSveglia(ConvertUtil.convertToString(accertamento.getDtSveglia()));
	        	sveglia.setNoteSveglia(accertamento.getNoteSveglia());
	        	prefissoIdentificativo = "ACCERTAMENTO-";
	            break;
	        case Constants.ID_TIPO_AZIONE_ISPEZIONE:  
	        	SigitTIspezione2018Dto ispezione = getSigitTIspezione2018Dao().findByPrimaryKey(new SigitTIspezione2018Pk(idAzione));
	        	sveglia.setDataSveglia(ConvertUtil.convertToString(ispezione.getDtSveglia()));
	        	sveglia.setNoteSveglia(ispezione.getNoteSveglia());
	        	prefissoIdentificativo = "ISPEZIONE-";
	            break;
	        case Constants.ID_TIPO_AZIONE_SANZIONE:  
	        	SigitTSanzioneDto sanzione = getSigitTSanzioneDao().findByPrimaryKey(new SigitTSanzionePk(idAzione));
	        	sveglia.setDataSveglia(ConvertUtil.convertToString(sanzione.getDtSveglia()));
	        	sveglia.setNoteSveglia(sanzione.getNoteSveglia());
	        	prefissoIdentificativo = "SANZIONE-";
	            break;
			}
			
        	sveglia.setIdentificativoExtended(prefissoIdentificativo + ConvertUtil.convertToString(idAzione));
			
		} catch (SigitTVerificaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		catch (SigitTAccertamentoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTIspezione2018DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTSanzioneDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} finally {
			log.debug("[DbVerificaMgr::modificaSveglia] END");
		}
		
		return sveglia;
		
	}
	
	
	public void modificaSveglia (Sveglia sveglia, int tipoAzione, String idAzione) throws DbManagerException {
		log.debug("[DbVerificaMgr::modificaSveglia] BEGIN");
		try {
			
			switch (tipoAzione) {
	        case Constants.ID_TIPO_AZIONE_VERIFICA:
	        	SigitTVerificaDto verifica = new SigitTVerificaDto();
	        	verifica.setDtSveglia(ConvertUtil.convertToSqlDate(sveglia.getDataSveglia()));
	        	verifica.setNoteSveglia(ReplaceSpecialCharUtils.sanitize(sveglia.getNoteSveglia()));
	        	verifica.setIdVerifica(ConvertUtil.convertToInteger(idAzione));
				getSigitTVerificaDao().updateColumnsSveglia(verifica);
	            break;
	        case Constants.ID_TIPO_AZIONE_ACCERTAMENTO:  
	        	SigitTAccertamentoDto accertamento = new SigitTAccertamentoDto();
	        	accertamento.setDtSveglia(ConvertUtil.convertToSqlDate(sveglia.getDataSveglia()));
	        	accertamento.setNoteSveglia(ReplaceSpecialCharUtils.sanitize(sveglia.getNoteSveglia()));
	        	accertamento.setIdAccertamento(ConvertUtil.convertToInteger(idAzione));
				getSigitTAccertamentoDao().updateColumnsSveglia(accertamento);
	            break;
	        case Constants.ID_TIPO_AZIONE_ISPEZIONE:  
	            SigitTIspezione2018Dto ispezione = new SigitTIspezione2018Dto();
	            ispezione.setDtSveglia(ConvertUtil.convertToSqlTimestamp(sveglia.getDataSveglia()));
	            ispezione.setNoteSveglia(ReplaceSpecialCharUtils.sanitize(sveglia.getNoteSveglia()));
	            ispezione.setIdIspezione2018(ConvertUtil.convertToInteger(idAzione));
	            getSigitTIspezione2018Dao().updateColumnsImpostaSveglia(ispezione);
	            
	        case Constants.ID_TIPO_AZIONE_SANZIONE:  
	        	 SigitTSanzioneDto sanzione = new SigitTSanzioneDto();
	        	 sanzione.setDtSveglia(ConvertUtil.convertToSqlDate(sveglia.getDataSveglia()));
	        	 sanzione.setNoteSveglia(ReplaceSpecialCharUtils.sanitize(sveglia.getNoteSveglia()));
	        	 sanzione.setIdSanzione(ConvertUtil.convertToInteger(idAzione));
		         getSigitTSanzioneDao().updateColumnsInfoSveglia(sanzione);
	            break;
			}
			
			
		} catch (SigitTVerificaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTAccertamentoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTIspezione2018DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTSanzioneDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}  finally {
			log.debug("[DbVerificaMgr::modificaSveglia] END");
		}
		
	}

}
