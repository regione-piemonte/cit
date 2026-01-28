/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.be.manager;

import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CodiceReaAndFiscaleFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.*;

import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTPersonaGiuridicaDaoException;
import it.csi.sigit.sigitext.business.util.ConvertUtil;
import it.csi.sigit.sigitext.business.util.MapDto;
import it.csi.sigit.sigitext.business.util.mail.ResultInvioMail;
import it.csi.sigit.sigitext.dto.sigitext.DettaglioAllegato;
import it.csi.sigit.sigitext.dto.sigitext.DettaglioPersonaGiuridica;
import it.csi.sigit.sigitext.dto.sigitext.Persona;
import it.csi.sigit.sigitext.dto.sigitext.TipoImportAllegatoEnum;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import it.csi.sigit.sigitext.business.util.Constants;
import org.apache.log4j.Logger;

import javax.xml.rpc.ServiceException;
import java.util.List;

public class ConnectorManager {

	protected static final Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".SigitextManager==>");

	SigitextManager sigitextManager = new SigitextManager();

	public ServiceManager getServiceManager() {
		return (ServiceManager) SpringApplicationContextHelper.getBean("serviceManager");

	}

	public void setSigitextManager(SigitextManager sigitextManager) {
		this.sigitextManager = sigitextManager;
	}

	private DbServiceImp serviceDb;

	public DbServiceImp getDbServiceImp() {
		return serviceDb;
	}

	public void setDbServiceImp(DbServiceImp serviceDb) {
		this.serviceDb = serviceDb;
	}

	public void salvaAllegatoImportTrans(DettaglioAllegato dettaglioAllegato, byte[] xml, String tipoControllo, SigitTLibrettoDto libretto, String cfUtente) throws SigitextException {
		log.debug("ConnectorManager::salvaAllegatoImportTrans - START");
		ResultInvioMail resultInvioMail = null;
		try {
			getDbServiceImp().salvaAllegatoImport(dettaglioAllegato, xml);

			TipoImportAllegatoEnum tipoImport = TipoImportAllegatoEnum.valueOfLabel(tipoControllo);

			if (tipoImport == TipoImportAllegatoEnum.MANUT_GT || tipoImport == TipoImportAllegatoEnum.MANUT_GF || tipoImport == TipoImportAllegatoEnum.MANUT_SC
					|| tipoImport == TipoImportAllegatoEnum.MANUT_CG) {

				getServiceManager().consolidaLibrettoTrans(cfUtente, libretto, dettaglioAllegato.getCodiceReaPg(), Constants.MOTIVO_CONSOLIDAMENTO_NUOVA_MANUTENZIONE);
				SigitVRicercaAllegatiDto vAllegato = getDbServiceImp().cercaSigitVRicercaAllegatiByIdAllegato(dettaglioAllegato.getIdAllegato().toString());

				List<SigitExtContrattoImpDto> list3RespAttiviImpianto = getDbServiceImp().cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglioAllegato.getCodiceImpianto(), dettaglioAllegato.getDataControllo());

				SigitTPersonaGiuridicaDto pg3Resp = null;
				DettaglioPersonaGiuridica personaGiuridica = null;
				if (list3RespAttiviImpianto != null && list3RespAttiviImpianto.size() > 0) {
					SigitExtContrattoImpDto vTot3Responsabile = list3RespAttiviImpianto.get(0);
					pg3Resp = getDbServiceImp().cercaPersonaGiuridicaById(vTot3Responsabile.getFkPg3Resp());
					personaGiuridica = MapDto.mapToDettaglioPersonaGiuridica(pg3Resp);
				}

				String emailResponsabile = getServiceManager().cercaEMailResponsabileAttivoAllaDataByCodImpianto(dettaglioAllegato.getCodiceImpianto(), dettaglioAllegato.getDataControllo());
				CodiceReaAndFiscaleFilter codiceReaAndFiscaleFilter = new CodiceReaAndFiscaleFilter();
				codiceReaAndFiscaleFilter.setCodiceFiscale(dettaglioAllegato.getCodiceFiscalePg());
				List<SigitTPersonaGiuridicaDto> manutentore = getDbServiceImp().getSigitTPersonaGiuridicaDao().findByCodiceReaAndFiscale(codiceReaAndFiscaleFilter);

				if (manutentore != null)
					resultInvioMail = getServiceManager().sendMailInserisciManutenzione(vAllegato, manutentore.get(0), emailResponsabile, personaGiuridica);
			}
		}catch (SigitextException e) {
			log.debug("errore validazione xml", e);
			throw e;
		} catch (SigitTPersonaGiuridicaDaoException | ServiceException e) {
			throw new SigitextException(e.getMessage());
		} finally {
			log.debug("ConnectorManager::salvaAllegatoImportTrans - END");
		}
	}

	public ResultInvioMail inviaAllegatoTrans(DettaglioAllegato dettaglio, Integer idPg, String cf) throws SigitextException {
		log.debug("[ConnectorMgr::inviaAllegatoTrans] START");
		ResultInvioMail resultInvioMail = null;
		try {
			resultInvioMail = getServiceManager().inviaAllegatoNow(dettaglio, cf, idPg);
			getServiceManager().inviaAllegatoLibretto(dettaglio.getCodiceImpianto(), ConvertUtil.convertToInteger(dettaglio.getPersonaGiuridica()
					.getIdPersonaGiuridica()), Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO, cf, false);
		} catch (SigitextException e) {
			throw e;
		} finally {
			log.debug("[ConnectorMgr::inviaAllegatoTrans] END");
		}
		return resultInvioMail;
	}
}
