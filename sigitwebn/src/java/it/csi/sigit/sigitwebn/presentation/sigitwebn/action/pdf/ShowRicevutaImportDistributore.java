/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.pdf;

import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.pdf.ModuloBuilder;
import it.csi.sigit.sigitwebn.business.pdf.RicevutaBuilder;
import it.csi.sigit.sigitwebn.dto.BaseSessionAwareDTO;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.BaseAction;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.CommandExecutionException;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ICommand;
import it.csi.sigit.sigitwebn.util.Constants;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ShowRicevutaImportDistributore extends BaseAction<BaseSessionAwareDTO> {

	
	private static final long serialVersionUID = 1L;
	private BaseSessionAwareDTO model;
	private InputStream inputStream;
	private String inputName;
	private String contentDisposition;
	private String contentType;
	
	private ModuloBuilder moduloBuilder;

	
	private ServiziMgr serviziMgr;
	private RicevutaBuilder ricevutaBuilder;
	
	@Override
	public String execute()
	{
		
//		String contentType = "application/pdf";
//		String contentDisp = "inline;filename=ricevutaAllegato.pdf";
		
		String contentType = "application/download";
		String contentDisp = "attachment;filename=ricevutaImportDistributore.pdf";
		
		LOG.debug("creo la ricevuta");
		
		try
		{
			Integer idImport = (Integer)session.get(Constants.SESSIONE_VAR_ID_IMPORT_DISTRIB);
//			String actionPageBack = (String)session.get(Constants.SESSIONE_VAR_ACTION_PAGE_BACK);
			
			LOG.debug("idImport: " + idImport);
//			LOG.debug("actionPageBack: " + actionPageBack);
			
//			moduloBuilder.setIdImport(idImport);
//			moduloBuilder.setActionPageBack(actionPageBack);

//			byte[] ricevuta = getModuloBuilder().showRicevutaImportDistrib();
			byte[] ricevuta = getRicevutaBuilder().generaRicevutaImportDistributore(idImport);
			
			LOG.debug("STAMPO LA RICEVUTA: "+ricevuta);
			
			if(ricevuta!=null)
			{
				setInputStream(new ByteArrayInputStream(ricevuta));
				LOG.debug("ricevuta import");
				setContentDisposition(contentDisp);
				setContentType(contentType);
				return "downloadFile";
			}
			
			LOG.debug("MODULO NON TROVATO");
			
			return "KO";
		}
		catch (Exception ex)
		{
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

	public RicevutaBuilder getRicevutaBuilder() {
		return ricevutaBuilder;
	}
	public void setRicevutaBuilder(RicevutaBuilder ricevutaBuilder) {
		this.ricevutaBuilder = ricevutaBuilder;
	}
}
