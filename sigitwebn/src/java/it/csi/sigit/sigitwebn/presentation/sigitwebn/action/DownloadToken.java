/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.dto.BaseSessionAwareDTO;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.Messages;

public class DownloadToken extends BaseAction<BaseSessionAwareDTO> {
	
	private static final long serialVersionUID = 1L;
	private BaseSessionAwareDTO model;
	private InputStream inputStream;
	private String inputName;
	private String contentDisposition;
	private String contentType;
	
	@Override
	public String execute() {
		String contentType = "application/download";
		String contentDisp = "attachment;filename=";
		try {
			File file = (File) session.get(Constants.SESSIONE_VAR_TOKEN);

			if (file.exists()) {
				String fileName = file.getName();
				FileInputStream f = new FileInputStream(file);
				setInputStream(f);
				setContentDisposition(contentDisp + fileName);
				setContentType(contentType);
				file.delete();
				return "downloadFile";
			}
			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_RECUPERO_SERVIZIO, Message.ERROR));
			return "KO";
		} catch (Exception e) {
			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_RECUPERO_SERVIZIO, Message.ERROR));
			LOG.error(e);
			return "KO";
		}
		
	}

	@SuppressWarnings("rawtypes")
	public Class modelClass() {
		return getClass();
	}

	@Override
	public BaseSessionAwareDTO getModel() {
		return this.model;
	}

	@Override
	public void setModel(BaseSessionAwareDTO t) {
		this.model = t;
	}

	@Override
	protected void dumpModel(boolean pre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doBeforeEventCommand() throws CommandExecutionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doAfterEventCommand() throws CommandExecutionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ICommand initCommand(String moduleName, String panelName, String widgName, String eventName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {
		// TODO Auto-generated method stub
		
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

}
