/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitweba.business.manager;


import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.SigitDDmDao;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.SigitDRuoloAccredDao;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.SigitRPfPgDelegaDao;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.SigitTFormazioneDao;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.SigitTPersonaFisicaDao;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.SigitTPersonaGiuridicaDao;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.SigitTStoricoVarStatoPgDao;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.SigitWrkConfigDao;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitRPfPgDelegaByCodiceFiscalePFDto;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitRPfPgDelegaByIdPersonaFisicaDto;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitRPfPgDelegaDto;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitTFormazioneDto;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitTPersonaFisicaDto;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitTPersonaGiuridicaPk;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitTStoricoVarStatoPgDto;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitWrkConfigDto;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.SigitTPersonaFisicaDaoException;
import it.csi.sigit.sigitweba.business.manager.util.DbManagerException;
import it.csi.sigit.sigitweba.business.manager.util.Message;
import it.csi.sigit.sigitweba.dto.accreditamento_tns.Formazione;
import it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaFisica;
import it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaGiuridica;
import it.csi.sigit.sigitweba.dto.common.CodeDescription;
import it.csi.sigit.sigitweba.util.Constants;
import it.csi.sigit.sigitweba.util.ConvertUtil;
import it.csi.sigit.sigitweba.util.DateUtil;
import it.csi.sigit.sigitweba.util.MapDto;
import it.csi.sigit.sigitweba.util.Messages;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Manager del DB
 * 
 * @author 70140
 */
public class DbMgr {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");

	// Definizione dei DAO

	/**
	 * DAO per accedere alla tabella SIGIT_T_PERSONA_FISICA
	 */
	private SigitTPersonaFisicaDao sigitTPersonaFisicaDao;
	private SigitTFormazioneDao sigitTFormazioneDao;
	private SigitRPfPgDelegaDao sigitRPfPgDelegaDao;
	private SigitTPersonaGiuridicaDao sigitTPersonaGiuridicaDao;
	private SigitDDmDao sigitDDmDao;
	private SigitDRuoloAccredDao sigitDRuoloAccredDao;
	private SigitTStoricoVarStatoPgDao sigitTStoricoVarStatoPgDao;
	
	private SigitWrkConfigDao sigitWrkConfigDao;
	
	public SigitTPersonaGiuridicaDao getSigitTPersonaGiuridicaDao() {
		return sigitTPersonaGiuridicaDao;
	}

	public void setSigitTPersonaGiuridicaDao(
			SigitTPersonaGiuridicaDao sigitTPersonaGiuridicaDao) {
		this.sigitTPersonaGiuridicaDao = sigitTPersonaGiuridicaDao;
	}

	public SigitRPfPgDelegaDao getSigitRPfPgDelegaDao() {
		return sigitRPfPgDelegaDao;
	}

	public void setSigitRPfPgDelegaDao(SigitRPfPgDelegaDao sigitRPfPgDelegaDao) {
		this.sigitRPfPgDelegaDao = sigitRPfPgDelegaDao;
	}

	public SigitTFormazioneDao getSigitTFormazioneDao() {
		return sigitTFormazioneDao;
	}

	public void setSigitTFormazioneDao(SigitTFormazioneDao sigitTFormazioneDao) {
		this.sigitTFormazioneDao = sigitTFormazioneDao;
	}

	public SigitTPersonaFisicaDao getSigitTPersonaFisicaDao() {
		return sigitTPersonaFisicaDao;
	}

	public void setSigitTPersonaFisicaDao(
			SigitTPersonaFisicaDao sigitTPersonaFisicaDao) {
		this.sigitTPersonaFisicaDao = sigitTPersonaFisicaDao;
	}

	public SigitTStoricoVarStatoPgDao getSigitTStoricoVarStatoPgDao() {
		return sigitTStoricoVarStatoPgDao;
	}

	public void setSigitTStoricoVarStatoPgDao(
			SigitTStoricoVarStatoPgDao sigitTStoricoVarStatoPgDao) {
		this.sigitTStoricoVarStatoPgDao = sigitTStoricoVarStatoPgDao;
	}
	/**
	 * Verifica del manager
	 */
	public void test() {
		log.debug("DBManager RAGGIUNTO CORRETTAMENTE");
	}

	// INIZIO METODI DI BUSINESS

	/**
	 * Restituisce le informazioni della persona fisica
	 * 
	 * @param cf Codice Fiscale della persona
	 * @return PersonaFisica persona fisica
	 * @throws DbManagerException Errore durante il recupero dei dati
	 */
	public PersonaFisica cercaPersonaFisicaByCF(String cf) throws DbManagerException {
		PersonaFisica obj = null;
		List<SigitTPersonaFisicaDto> dtoList = null;
		log.debug("[DbMgr::cercaPersonaFisicaByCF] BEGIN");
		try {
			dtoList = getSigitTPersonaFisicaDao().findFindByCodFisc(cf);
			
			if((dtoList != null) && (dtoList.size() > 0)) {
				obj = MapDto.mapToPersonaFisica(dtoList.get(0));
			}
		}
		catch(SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaFisicaByCF] END");
		}
		return obj;
	}

	public ArrayList<Formazione> cercaFormazioneByIdPersona(String idPersona) throws DbManagerException {
		List<SigitTFormazioneDto> dtoList = null;
		log.debug("[DbMgr::cercaFormazioneByIdPersona] BEGIN");
		try {
			dtoList = getSigitTFormazioneDao().findByIdPersona(new BigDecimal(idPersona));
			return MapDto.mapToFormazione(dtoList);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaFormazioneByIdPersona] END");
		}
	}

	public PersonaFisica salvaPersonaFisica(PersonaFisica persona, String cfUtMod) throws DbManagerException {
		SigitTPersonaFisicaDto dto = null;
		log.debug("[DbMgr::salvaPersonaFisica] BEGIN");
		try {
			
			dto = MapDto.mapToSigitTPersonaFisicaDto(persona, cfUtMod);
			BigDecimal idPersona = getSigitTPersonaFisicaDao().insert(dto).getIdPersonaFisica();
			persona.setIdPersona(ConvertUtil.convertToString(idPersona));
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::salvaPersonaFisica] END");
		}
		return persona;
	}
	
	public PersonaFisica modificaPersonaFisica(PersonaFisica persona, String cfUtMod) throws DbManagerException {
		PersonaFisica obj = null;
		SigitTPersonaFisicaDto dto = null;
		log.debug("[DbMgr::modificaPersonaFisica] BEGIN");
		try {
			
			dto = MapDto.mapToSigitTPersonaFisicaDto(persona, cfUtMod);
			getSigitTPersonaFisicaDao().update(dto);
		}
		catch(SigitTPersonaFisicaDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally {
			log.debug("[DbMgr::modificaPersonaFisica] END");
		}
		return obj;
	}
	
	public void salvaFormazione(Formazione formazione) throws DbManagerException
	{
		log.debug("[DbMgr::salvaFormazione] BEGIN");
		try {
			SigitTFormazioneDto dto = MapDto.mapToSigitTFormazioneDTO(formazione);
			getSigitTFormazioneDao().insert(dto);
		} catch (ParseException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::salvaFormazione] END");
		}
		
	}
	

	public ArrayList<PersonaGiuridica> getImpreseAssociate(String codiceFiscalePF) throws DbManagerException
	{
		log.debug("[DbMgr::getImpreseAssociate] BEGIN");
		try {
			List<SigitRPfPgDelegaByCodiceFiscalePFDto> list = getSigitRPfPgDelegaDao().findByCodiceFiscalePF(codiceFiscalePF);
			return MapDto.mapListToPersonaGiuridica(list);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally{
			log.debug("[DbMgr::getImpreseAssociate] END");
		}
	}
	
	public ArrayList<SigitRPfPgDelegaDto> cercaAssociazioneAPfPgValideByPg(String idPersona) throws DbManagerException {
		List<SigitRPfPgDelegaDto> dtoList = null;
		log.debug("[DbMgr::cercaAssociazioneAPfPgValideByPg] BEGIN");
		try {
			dtoList = getSigitRPfPgDelegaDao().findAttiveAccByIdPersonaGiuridica(new BigDecimal(idPersona));
			return (ArrayList<SigitRPfPgDelegaDto>) convertToArrayList(dtoList);
		}
		catch(Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaAssociazioneAPfPgValideByPg] END");
		}
	}
	
	@Transactional
	public void insertAssociazionePfPg(PersonaGiuridica pg, String utenteUltMod) throws DbManagerException
	{
		log.debug("[DbMgr::insertAssociazionePfPg] BEGIN");
		try {
			SigitTPersonaGiuridicaDto dto = MapDto.getSigitTPersonaGiuridica(pg, null);
			dto.setUtenteUltMod(utenteUltMod);
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());
			dto.setDtAggDichiarazione(DateUtil.getSqlDataCorrente());
			getSigitTPersonaGiuridicaDao().insert(dto);
			
			pg.setIdPersonaGiuridica(dto.getIdPersonaGiuridica().toString());
			System.out.println("ID PERSONA GIURIDICA: " + pg.getIdPersonaGiuridica());
			SigitRPfPgDelegaDto sigitPfPgDelega = MapDto.getSigitPfPgDelega(pg);
			sigitPfPgDelega.setDataUltMod(DateUtil.getSqlDataCorrente());
			sigitPfPgDelega.setUtenteUltMod(utenteUltMod);
			getSigitRPfPgDelegaDao().insert(sigitPfPgDelega);
			
			SigitTStoricoVarStatoPgDto dtoVarStato = MapDto.getSigitTStoricoVarStatoPg(pg, utenteUltMod, true);
			getSigitTStoricoVarStatoPgDao().insert(dtoVarStato);
			
			
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::insertAssociazionePfPg] END");
		}
	}

	@Transactional
	public void modificaPersonaGiuridica(PersonaGiuridica pg, String utenteUltMod) throws DbManagerException
	{
		log.debug("[DbMgr::modificaPersonaGiuridica] BEGIN");
		try {
			SigitTPersonaGiuridicaDto dto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(ConvertUtil.convertToBigDecimal(pg.getIdPersonaGiuridica())));
			dto = MapDto.getSigitTPersonaGiuridica(pg, dto);
			dto.setUtenteUltMod(utenteUltMod);
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());
			dto.setDtAggDichiarazione(DateUtil.getSqlDataCorrente());
			getSigitTPersonaGiuridicaDao().update(dto);
			
			SigitRPfPgDelegaDto dtoDelega = MapDto.getSigitPfPgDelega(pg);
			dtoDelega.setUtenteUltMod(utenteUltMod);
			dtoDelega.setDataUltMod(DateUtil.getSqlDataCorrente());
			getSigitRPfPgDelegaDao().update(dtoDelega);
			
			// La persona giuridica e' stata cessata
			if (pg.getIdStatoPg() != null && pg.getIdStatoPgOld().intValue() != Constants.ID_STATO_IMPRESA_CESSATA && pg.getIdStatoPg().intValue() == Constants.ID_STATO_IMPRESA_CESSATA)
			{
				SigitTStoricoVarStatoPgDto dtoVarStato = MapDto.getSigitTStoricoVarStatoPg(pg, utenteUltMod, false);
				getSigitTStoricoVarStatoPgDao().insert(dtoVarStato);
			}
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::modificaPersonaGiuridica] END");
		}
	}

	public void aggiungiLegameAPersonaGiuridica(PersonaGiuridica pg, String utenteUltMod) throws DbManagerException
	{
		log.debug("[DbMgr::aggiungiLegameAPersonaGiuridica] BEGIN");
		try {
			SigitTPersonaGiuridicaDto dto = getSigitTPersonaGiuridicaDao().findByPrimaryKey(new SigitTPersonaGiuridicaPk(ConvertUtil.convertToBigDecimal(pg.getIdPersonaGiuridica())));
			dto = MapDto.getSigitTPersonaGiuridica(pg, dto);
			dto.setUtenteUltMod(utenteUltMod);
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());
			dto.setDtAggDichiarazione(DateUtil.getSqlDataCorrente());
			getSigitTPersonaGiuridicaDao().update(dto);
			
			SigitRPfPgDelegaDto dtoDelega = MapDto.getSigitPfPgDelega(pg);
			dtoDelega.setUtenteUltMod(utenteUltMod);
			dtoDelega.setDataUltMod(DateUtil.getSqlDataCorrente());
			getSigitRPfPgDelegaDao().insert(dtoDelega);
			
			// La persona giuridica e' stata cessata
			if (pg.getIdStatoPg() != null && pg.getIdStatoPg().intValue() == Constants.ID_STATO_IMPRESA_CESSATA)
			{
				SigitTStoricoVarStatoPgDto dtoVarStato = MapDto.getSigitTStoricoVarStatoPg(pg, utenteUltMod, false);
				getSigitTStoricoVarStatoPgDao().insert(dtoVarStato);
			}			
		} catch (Exception e) {
			if(e instanceof DataIntegrityViolationException)
				throw new DbManagerException(e, new Message(Messages.ERROR_LEGAME_ESISTENTE));
			else
				throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::aggiungiLegameAPersonaGiuridica] END");
		}
	}

	public void cessaLegame(PersonaGiuridica pg, String uteUltMod) throws DbManagerException
	{
		log.debug("[DbMgr::cessaLegame] BEGIN");
		try {
			SigitRPfPgDelegaDto dto = MapDto.getSigitPfPgDelega(pg);
			dto.setDataFine(DateUtil.getSqlDate());
			dto.setUtenteUltMod(uteUltMod);
			dto.setDataUltMod(DateUtil.getSqlDataCorrente());
			getSigitRPfPgDelegaDao().update(dto);
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		}
		finally {
			log.debug("[DbMgr::cessaLegame] END");
		}
		
	}
	
	public ArrayList<CodeDescription> getRuoliAccred() throws DbManagerException
	{
		log.debug("[DbMgr::getRuoliAccred] BEGIN");
		try {
			return MapDto.mapRuoliAccred(getSigitDRuoloAccredDao().findAll());
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getRuoliAccred] END");
		}
	}

	public ArrayList<CodeDescription> getTipiDm() throws DbManagerException
	{
		log.debug("[DbMgr::getTipiDm] BEGIN");
		try {
			return MapDto.mapTipiDm(getSigitDDmDao().findAll());
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getTipiDm] END");
		}
	}

	public List<PersonaGiuridica> cercaPersonaGiuridicaByCodiceRea(String siglaRea, String numeroRea) throws DbManagerException
	{
		log.debug("[DbMgr::getTipiDm] BEGIN");
		try {
			return MapDto.getListPersonaGiuridica(getSigitTPersonaGiuridicaDao().findByCodiceRea(siglaRea.concat(numeroRea)));
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::getTipiDm] END");
		}
	}

	public List<PersonaGiuridica> cercaPersonaGiuridicaByCodiceFiscale(String codiceFiscale) throws DbManagerException
	{
		log.debug("[DbMgr::cercaPersonaGiuridicaByCodiceFiscale] BEGIN");
		try {
			return MapDto.getListPersonaGiuridica(getSigitTPersonaGiuridicaDao().findByCodiceFiscale(codiceFiscale));
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaGiuridicaByCodiceFiscale] END");
		}
	}
	
	public List<PersonaGiuridica> cercaPersonaGiuridicaByCodiceReaCodiceFiscale(PersonaGiuridica pg) throws DbManagerException
	{
		log.debug("[DbMgr::cercaPersonaGiuridicaByCodiceFiscale] BEGIN");
		try {
			return MapDto.getListPersonaGiuridica(getSigitTPersonaGiuridicaDao().findByCodiceFiscaleCodRea(pg));
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaPersonaGiuridicaByCodiceFiscale] END");
		}
	}

	public String cercaConfigValueCarattere(String chiave) throws DbManagerException
	{
		log.debug("[DbMgr::cercaConfigValueCarattere] BEGIN");
		try {
			return getSigitWrkConfigDao().findByChiaveConfig(chiave).get(0).getValoreConfigChar();
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaConfigValueCarattere] END");
		}
	}
	
	/**
	 * Legge un valore dalla configurazione e ritorna il campo valore_config_flag
	 * 
	 * @param chiave Chiave del valore
	 * @return ValoreConfigFlg associato alla chiave
	 * @throws DbManagerException Errore durante la lettura della configurazione
	 */
	public Boolean cercaConfigValueFlg(String chiave) throws DbManagerException {
		SigitWrkConfigDto dto = null;

		log.debug("[DbMgr::cercaConfigValueFlg] BEGIN");
		try {
			dto = getSigitWrkConfigDao().findByChiaveConfig(chiave).get(0);

			log.debug("[DbMgr::cercaConfigValueFlg] END");

			return ConvertUtil.convertToBoolean(dto.getValoreFlag());
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally {
			log.debug("[DbMgr::cercaConfigValueFlg] END");
		}
	}

	
	public SigitDDmDao getSigitDDmDao() {
		return sigitDDmDao;
	}

	public void setSigitDDmDao(SigitDDmDao sigitDDmDao) {
		this.sigitDDmDao = sigitDDmDao;
	}

	public SigitDRuoloAccredDao getSigitDRuoloAccredDao() {
		return sigitDRuoloAccredDao;
	}

	public void setSigitDRuoloAccredDao(SigitDRuoloAccredDao sigitDRuoloAccredDao) {
		this.sigitDRuoloAccredDao = sigitDRuoloAccredDao;
	}

	public SigitWrkConfigDao getSigitWrkConfigDao() {
		return sigitWrkConfigDao;
	}

	public void setSigitWrkConfigDao(SigitWrkConfigDao sigitWrkConfigDao) {
		this.sigitWrkConfigDao = sigitWrkConfigDao;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ArrayList<?> convertToArrayList(List<?> list) {
		log.debug("[DbMgr::convertToArrayList] BEGIN");
		ArrayList<?> arrayList = null;

		if(list != null) {
			if(list instanceof ArrayList<?>) {
				arrayList = (ArrayList<?>) list;
			}
			else {
				arrayList = new ArrayList(list);
			}
		}
		log.debug("[DbMgr::convertToArrayList] END");
		return arrayList;
	}
}