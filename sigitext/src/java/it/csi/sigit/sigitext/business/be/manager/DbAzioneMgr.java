/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.be.manager;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTAzioneDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTDocAzioneDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzionePk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAzioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAzionePk;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.DateUtil;
import it.csi.sigit.sigitext.business.util.Messages;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggatoModel;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import org.apache.log4j.Logger;

public class DbAzioneMgr {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager.db");

	private SigitTAzioneDao sigitTAzioneDao;
	private SigitTDocAzioneDao sigitTDocAzioneDao;

	public SigitTAzioneDao getSigitTAzioneDao() {
		return sigitTAzioneDao;
	}

	public void setSigitTAzioneDao(SigitTAzioneDao sigitTAzioneDao) {
		this.sigitTAzioneDao = sigitTAzioneDao;
	}

	public SigitTDocAzioneDao getSigitTDocAzioneDao() {
		return sigitTDocAzioneDao;
	}

	public void setSigitTDocAzioneDao(SigitTDocAzioneDao sigitTDocAzioneDao) {
		this.sigitTDocAzioneDao = sigitTDocAzioneDao;
	}

	public SigitTAzionePk inserisciAzioneSimply(String descrizioneAzione, Integer tipoAzione, UtenteLoggatoModel utente, Integer origine) throws SigitextException {
		SigitTAzioneDto azione = new SigitTAzioneDto();

		azione.setDescrizioneAzione(descrizioneAzione);
		azione.setDtAzione(DateUtil.getSqlCurrentDate());
		azione.setCfUtenteAzione(utente.getCodiceFiscale());
		azione.setDenomUtenteAzione(utente.getDenominazione());
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

	public SigitTAzionePk inserisciOModificaAzione(SigitTAzioneDto azione) throws SigitextException {
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
		} catch (Exception e) {

			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbAzioneMgr::inserisciOModificaAzione] END");
		}

		return risultato;
	}

	public SigitTDocAzionePk inserisciDocAzione(SigitTDocAzioneDto docAzione) throws SigitextException {
		log.debug("[DbAzioneMgr::inserisciDocAzione] BEGIN");
		try {
			return getSigitTDocAzioneDao().insert(docAzione);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB);
		} finally {
			log.debug("[DbAzioneMgr::inserisciDocAzione] BEGIN");
		}
	}

	public void aggiornaTDocAzione(SigitTDocAzioneDto dto) throws SigitextException {
		log.debug("[DbAzioneMgr::aggiornaTDocAzione] BEGIN");
		try {
			getSigitTDocAzioneDao().updateColumnsAggiornaNomeUid(dto);
		} catch (Exception e) {
			throw new SigitextException(Messages.ERROR_INSERT_DB);
		} finally {
			log.debug("[DbAzioneMgr::aggiornaTDocAzione] END");
		}
	}
}
