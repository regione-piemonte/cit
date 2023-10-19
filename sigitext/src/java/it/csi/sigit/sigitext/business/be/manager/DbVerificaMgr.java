/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.be.manager;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitExtDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTAccertamentoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTVerificaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.RicercaAccertamentoFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAccertamentoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAccertamentoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTVerificaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTVerificaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTAccertamentoDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTVerificaDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.Messages;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

public class DbVerificaMgr {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager.db");

	private SigitTVerificaDao sigitTVerificaDao;
	private SigitTAccertamentoDao sigitTAccertamentoDao;
	private SigitExtDao sigitExtDao = null;

	public SigitExtDao getSigitExtDao() {
		return sigitExtDao;
	}

	public void setSigitExtDao(SigitExtDao sigitExtDao) {
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

	protected DbServiceImp dbServiceImp;

	public DbServiceImp getDbServiceImp() {
		return dbServiceImp;
	}

	public void setDbServiceImp(DbServiceImp DbServiceImp) {
		this.dbServiceImp = DbServiceImp;
	}

	public List<SigitTAccertamentoDto> getElencoAccertamentiByFilter(RicercaAccertamentoFilter filter) throws SigitextException {
		log.debug("[DbVerificaMgr::getElencoAccertamentiByFilter] BEGIN");
		try {
			return getSigitTAccertamentoDao().findByFilter(filter);
		} catch (SigitTAccertamentoDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbVerificaMgr::getElencoAccertamentiByFilter] END");
		}

	}

	public SigitTAccertamentoDto getAccertamentoById(Integer idAccertamento) throws SigitextException {
		log.debug("[DbVerificaMgr::getAccertamentoById] BEGIN");

		try {
			return getSigitTAccertamentoDao().findByPrimaryKey(new SigitTAccertamentoPk(idAccertamento));
		} catch (SigitTAccertamentoDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbVerificaMgr::getAccertamentoById] END");
		}

	}

	public void eliminaVerificaById(Integer idVerifica) throws SigitextException {
		log.debug("[DbVerificaMgr::eliminaVerificaById] BEGIN");

		try {
			getSigitTVerificaDao().delete(new SigitTVerificaPk(idVerifica));
		} catch (SigitTVerificaDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbVerificaMgr::eliminaVerificaById] END");
		}
	}

	public SigitTVerificaPk salvaVerifica(SigitTVerificaDto entity) throws SigitextException {
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
		} catch (SigitTVerificaDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbVerificaMgr::salvaVerifica] END");
		}
	}

	public SigitTAccertamentoPk salvaAccertamento(SigitTAccertamentoDto entity) throws SigitextException {
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
		} catch (SigitTAccertamentoDaoException e) {
			throw new SigitextException(Messages.ERROR_RECUPERO_DB);
		} finally {
			log.debug("[DbVerificaMgr::salvaAccertamento] END");
		}
	}
}
