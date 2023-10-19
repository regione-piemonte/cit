/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.pdf;

import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.pdf.ModuloBuilder;
import it.csi.sigit.sigitwebn.dto.BaseSessionAwareDTO;
import it.csi.sigit.sigitwebn.dto.index.DettaglioAllegatoIndex;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.BaseAction;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.CommandExecutionException;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ICommand;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.Messages;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class RecuperaLibretto extends BaseAction<BaseSessionAwareDTO> {

	
	private static final long serialVersionUID = 1L;
	private BaseSessionAwareDTO model;
	private InputStream inputStream;
	private String inputName;
	private String contentDisposition;
	private String contentType;
	
	private ModuloBuilder moduloBuilder;

	
	private ServiziMgr serviziMgr;

	private HttpServletRequest request;
	
	public HttpServletRequest getServletRequest() {
		return request;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public String execute()
	{
		
		String contentType = "application/download";
		String contentDisp = "attachment;filename=";
		LOG.debug("ricerco libretto");
		try
		{
			//HttpServletRequest request = ServletActionContext.getRequest();
			//GenericUtil.stampaParametriRequest(request);
			
			String idImpianto = (String)session.get(Constants.SESSIONE_VAR_ID_IMPIANTO);
			LOG.debug("idImpianto: " + idImpianto);
			
			DettaglioAllegatoIndex allegato = getServiziMgr().getLibrettoIndex(idImpianto);

			// E' un test di marge tra 2 file pdf
			//DettaglioAllegatoIndex allegato = getServiziMgr().getLibrettoIndexMARGE(idImpianto);
			
			
			if(allegato!=null)
			{
				byte[] libretto = allegato.getFile(); 

				//String fileName = "allegato.pdf";
				String fileName = allegato.getNomeAllegato();
				
				setInputStream(new ByteArrayInputStream(libretto));
				LOG.debug("libretto aggiunto");
				setContentDisposition(contentDisp + fileName);
				setContentType(contentType);
				return "downloadFile";
			}
			
			
			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_RECUPERO_SERVIZIO, Message.ERROR));
			return "KO";


		}
		catch (ServiceException ex)
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

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}


	public String getContentDisposition() {
		return contentDisposition;
	}


	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}


	public String getContentType() {
		return contentType;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}


	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}
	
	public ModuloBuilder getModuloBuilder() {
		return moduloBuilder;
	}
	public void setModuloBuilder(ModuloBuilder moduloBuilder) {
		this.moduloBuilder = moduloBuilder;
	}
	
}
