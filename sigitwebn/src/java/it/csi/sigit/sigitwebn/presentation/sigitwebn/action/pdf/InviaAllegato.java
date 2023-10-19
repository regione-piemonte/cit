/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.pdf;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVTotImpiantoDto;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ConnectorMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.pdf.ModuloBuilder;
import it.csi.sigit.sigitwebn.dto.BaseSessionAwareDTO;
import it.csi.sigit.sigitwebn.dto.accesso.Ruolo;
import it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato;
import it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicManutentore;
import it.csi.sigit.sigitwebn.dto.index.DettaglioAllegatoIndex;
import it.csi.sigit.sigitwebn.dto.index.DettaglioDocumento;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.BaseAction;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.CommandExecutionException;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ICommand;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.Validator;
import it.csi.sigit.sigitwebn.util.mail.ResultInvioMail;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InviaAllegato extends BaseAction<BaseSessionAwareDTO> {

	
	private static final long serialVersionUID = 1L;
	private BaseSessionAwareDTO model;
	
	private ServiziMgr serviziMgr;
	private DbMgr dbMgr;

	

	@Override
	public String execute()
	{
		
		String contentType = "application/download";
		String contentDisp = "attachment;filename=";
		LOG.debug("invio allegato");
		try
		{
			
			DettaglioAllegato dettaglioAllegato = (DettaglioAllegato)session.get(Constants.SESSIONE_VAR_DETT_ALLEGATO);
			LOG.debug("dettaglioAllegato: " + dettaglioAllegato);
			
			// Lo salvo, perche' dopo verra' sovrascritto il dato (con la ricerca del dettaglio)
			String arrivoDa = dettaglioAllegato.getArrivoDa()!=null?dettaglioAllegato.getArrivoDa():""; // dovrebbe essere sempre valorizzato
			
			if (LOG.isDebugEnabled())
			{
				LOG.debug("dettaglio allegato ricevuto:");
				GenericUtil.stampa(dettaglioAllegato, true, 3);
			}
			
			//vado a cercare il dettaglio dell'allegato con la primary Key
			dettaglioAllegato = getDbMgr()
					.getDettaglioAllegatoByIdAllegato(ConvertUtil.convertToInteger(dettaglioAllegato.getIdAllegato()), dettaglioAllegato.getCodiceImpianto());
			
			if (LOG.isDebugEnabled())
			{
				LOG.debug("dettaglio allegato ricercato:");
				GenericUtil.stampa(dettaglioAllegato, true, 3);
			}
			
			UtenteLoggato utenteLoggato = (UtenteLoggato)session.get(Constants.SESSIONE_VAR_UTENTE_LOGGATO);
			LOG.debug("utenteLoggato: "+utenteLoggato);
			
			// Recupero l'utente loggato per capire se e' un CAT
			Ruolo ruoloUtente = utenteLoggato.getRuolo();

			LOG.debug("ruoloUtente: "+ruoloUtente);

			// Ho centralizzato i controlli
			getValidationMgr().validazioneFormaleInviaAllegato(dettaglioAllegato, ruoloUtente);

			LOG.debug("dopo validazione");
			
			SigitVRicercaAllegatiDto allegatoDto = getDbMgr()
					.cercaSigitVRicercaAllegatiByIdAllegato(dettaglioAllegato.getIdAllegato());
			
			LOG.debug("allegatoDto: "+allegatoDto);

			
			Integer idStatoRapp = ConvertUtil.convertToInteger(allegatoDto.getFkStatoRapp());
			if (Constants.ID_STATO_RAPPORTO_INVIATO == idStatoRapp
					|| Constants.ID_STATO_RAPPORTO_RESPINTO == idStatoRapp) {

				
//				result.getGlobalErrors().add(Messages.S129);
//				
//				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
//						new Message(Messages.S129, Message.ERROR));
//
//				result.setResultCode(SALVAINVIAALLEGATO_OUTCOME_CODE__KO);
				
				throw new ManagerException(new Message(Messages.S129));
				
				//session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.S129, Message.ERROR));
				//return "KO";

				
			} else {
				
				LOG.debug("prima dell'invio");

				ResultInvioMail resultInvioMail = getConnectorMgr().inviaAllegatoTrans(dettaglioAllegato, ruoloUtente.getIdPgCat(),
						utenteLoggato);

				LOG.debug("dopo l'invio");

				// BUG - devo verificare che l'allegano non sia gia' in stato INVIATO, l'utente potrebbe aver fatto F5

				String msg = getSigitMgr().getMsgInvioRee(dettaglioAllegato, allegatoDto, resultInvioMail);
				
				session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(msg, Message.INFO));
				
				if (arrivoDa.equals(Constants.ARRIVO_DA_ALLEGATI))
				{
					return "OK_ALLEGATI";
				}
				else if (arrivoDa.equals(Constants.ARRIVO_DA_IMPIANTO))
				{
					return "OK_IMPIANTO";
				}
				else
				{
					// Non so dove ritornare
					return "KO";
				}

			}

		}
		catch (ManagerException ex)
		{
			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(ex.getMessage(), Message.ERROR));

			LOG.error("Eccezione ManagerException", ex);

			//ex.printStackTrace();
			return "KO";
		}
		catch (Exception ex)
		{
			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_RECUPERO_SERVIZIO, Message.ERROR));

			LOG.error("Eccezione Exception", ex);

			//ex.printStackTrace();
			return "KO";
		}
	}
	

	@SuppressWarnings("rawtypes")
	public Class modelClass() {
		return getClass();
	}

	public BaseSessionAwareDTO getModel() {
		return this.model;
	}

	public void setModel(BaseSessionAwareDTO t) {
		this.model = t;
	}

	@Override
	protected void dumpModel(boolean pre) {
		
	}

	@Override
	protected void doBeforeEventCommand() throws CommandExecutionException {
		
	}

	@Override
	protected void doAfterEventCommand() throws CommandExecutionException {
	}

	@Override
	protected ICommand initCommand(String moduleName, String panelName,
			String widgName, String eventName) {
		return null;
	}

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {
		
	}
	
	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}


	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	private ConnectorMgr connectorMgr;

	public ConnectorMgr getConnectorMgr() {
		return connectorMgr;
	}

	public void setConnectorMgr(ConnectorMgr connectorMgr) {
		this.connectorMgr = connectorMgr;
	}
	
	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}
	
	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}
	
	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}
}
