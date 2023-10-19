/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.pdf;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVTotImpiantoDto;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.business.pdf.ModuloBuilder;
import it.csi.sigit.sigitwebn.dto.BaseSessionAwareDTO;
import it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicManutentore;
import it.csi.sigit.sigitwebn.dto.index.DettaglioAllegatoIndex;
import it.csi.sigit.sigitwebn.dto.index.DettaglioDocumento;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.BaseAction;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.CommandExecutionException;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ICommand;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.Validator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsolidaLibretto extends BaseAction<BaseSessionAwareDTO> {

	
	private static final long serialVersionUID = 1L;
	private BaseSessionAwareDTO model;
	
	private ServiziMgr serviziMgr;


	@Override
	public String execute()
	{
		
		String contentType = "application/download";
		String contentDisp = "attachment;filename=";
		LOG.debug("ricerco libretto");
		try
		{
			String idImpianto = (String)session.get(Constants.SESSIONE_VAR_ID_IMPIANTO);
			LOG.debug("idImpianto: " + idImpianto);



			UtenteLoggato utenteLoggato = (UtenteLoggato)session.get(Constants.SESSIONE_VAR_UTENTE_LOGGATO);;
			Integer idPersonaGiuridica = utenteLoggato.getRuolo().getIdPersonaGiuridica();

			LOG.debug("ID PERSONA GIURIDICA: " + idPersonaGiuridica);
			
			try
			{
				getValidationMgr().verificaLibrettoWeb(idImpianto);
			}
			catch (ValidationManagerException e)
			{
				session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(e.getMessage(), Message.ERROR));
				return "KO_VERIFICHE";
			}
			
			String descrizioneRuolo = utenteLoggato.getRuolo().getDescRuolo();
			int motivoConsolidamento = Constants.ID_MOTIVO_CONSOLIDAMENTO_ESP_UTENTE;
			if (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)
					|| descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE))
			{
				motivoConsolidamento = Constants.ID_MOTIVO_CONSOLIDAMENTO_COMP_SCHEDA_1_14;
			} 

			getSigitMgr().consolidaLibrettoTrans(utenteLoggato, utenteLoggato.getRuolo().getCodiceRea(), idImpianto, motivoConsolidamento);

			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.INFO_LIBRETTO_CONSOLIDATO_CORRETTAMENTE, Message.INFO));

			//					ArrayList<RisultatoRicManutentore> manutentoriList = getDbMgr()
			//							.cercaManutentoriByIdImpiantoNew(ConvertUtil.convertToInteger(idImpianto));
			//
			//					LOG.debug("@@@PRIMA del settaggio manutentoriList (1): " + manutentoriList);

			//theModel.setAppDataelencoManutentori(manutentoriList);

			//theModel.getAppDataimpianto().setLibIsModifica(ConvertUtil.convertToString(false));
			//theModel.getAppDataimpianto().setLibDataRilascio(ConvertUtil.convertToString(new Date()));

			return "OK";
			

		}
		catch (ManagerException ex)
		{
			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(ex.getMessage(), Message.ERROR));

			LOG.error(ex);
			return "KO";
		}
		catch (Exception ex)
		{
			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_RECUPERO_SERVIZIO, Message.ERROR));

			LOG.error(ex);
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

	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}
	
	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}
}
