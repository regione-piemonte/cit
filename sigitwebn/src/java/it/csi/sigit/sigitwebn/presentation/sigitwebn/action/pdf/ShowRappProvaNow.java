/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.pdf;

import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.pdf.IspezioneBuilder;
import it.csi.sigit.sigitwebn.business.pdf.ModuloBuilder;
import it.csi.sigit.sigitwebn.dto.BaseSessionAwareDTO;
import it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato;
import it.csi.sigit.sigitwebn.dto.index.DettaglioAllegatoIndex;
import it.csi.sigit.sigitwebn.dto.index.DettaglioDocumento;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.BaseAction;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.CommandExecutionException;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ICommand;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.Messages;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ShowRappProvaNow extends BaseAction<BaseSessionAwareDTO> {

	
	private static final long serialVersionUID = 1L;
	private BaseSessionAwareDTO model;
	private InputStream inputStream;
	private String inputName;
	private String contentDisposition;
	private String contentType;
	
	private ModuloBuilder moduloBuilder;
	private IspezioneBuilder ispezioneBuilder;
	
	private SigitMgr sigitMgr;


	@Override
	public String execute()
	{
		
		String contentType = "application/download";
		String contentDisp = "attachment;filename=";
		LOG.debug("ricerco rapporto di prova");
		try
		{
			DettaglioAllegato dettaglio = (DettaglioAllegato)session.get(Constants.SESSIONE_VAR_DETT_ALLEGATO);
			LOG.debug("dettaglioAllegato: " + dettaglio);
			
			LOG.debug("dettaglio.getIdTipoAllegato(): " + dettaglio.getIdTipoAllegato());
			
			DettaglioDocumento allegato = null;
			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(dettaglio.getIdTipoAllegato()))
			{
				allegato = getIspezioneBuilder().generaIspezioneGt(dettaglio, false, new Integer(Constants.ID_STATO_RAPPORTO_BOZZA).equals(dettaglio.getIdStatoRapporto()));
			}
			else if (Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equals(dettaglio.getIdTipoAllegato()))
			{
				allegato = getIspezioneBuilder().generaIspezioneGf(dettaglio, false, new Integer(Constants.ID_STATO_RAPPORTO_BOZZA).equals(dettaglio.getIdStatoRapporto()));
			}
			
			
			// CODICE GIUSTO
			//DettaglioDocumento allegato = getSigitMgr().getAllegatoPdfNow(dettaglio);

			
			// CODICE PROVA ITEXT
			LOG.debug("getIspezioneBuilder: " + getIspezioneBuilder());
			

			if(allegato!=null)
			{
				byte[] libretto = allegato.getFile(); 

				//String fileName = "allegato.pdf";
				String fileName = allegato.getNomeDocumento();
				
				setInputStream(new ByteArrayInputStream(libretto));
				LOG.debug("allegato generato");
				setContentDisposition(contentDisp + fileName);
				setContentType(contentType);
				return "downloadFile";
			}
			
			
			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_RECUPERO_SERVIZIO, Message.ERROR));
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
	
	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}


	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}
	
	public ModuloBuilder getModuloBuilder() {
		return moduloBuilder;
	}
	public void setModuloBuilder(ModuloBuilder moduloBuilder) {
		this.moduloBuilder = moduloBuilder;
	}
	
	public IspezioneBuilder getIspezioneBuilder() {
		return ispezioneBuilder;
	}
	public void setIspezioneBuilder(IspezioneBuilder ispezioneBuilder) {
		
		LOG.error("SETTO l'ISPEZIONE BUILDER: "+ispezioneBuilder);
		this.ispezioneBuilder = ispezioneBuilder;
	}
	
}
