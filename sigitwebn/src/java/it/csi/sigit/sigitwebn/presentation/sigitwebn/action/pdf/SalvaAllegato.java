/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.pdf;

import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.pdf.ModuloBuilder;
import it.csi.sigit.sigitwebn.dto.BaseSessionAwareDTO;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.BaseAction;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.CommandExecutionException;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ICommand;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.MapDto;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument;
import it.csi.sigit.sigitwebn.xml.allegato3.data.MODIIIDocument;
import it.csi.sigit.sigitwebn.xml.allegato4.data.MODIVDocument;
import it.csi.sigit.sigitwebn.xml.allegato5.data.MODVDocument;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Preparable;

public class SalvaAllegato extends BaseAction<BaseSessionAwareDTO> implements Preparable,ServletRequestAware {
	private static final long serialVersionUID = -6404426475248324227L;
	private BaseSessionAwareDTO model;
	private InputStream inputStream;
	private String inputName;
	private String contentDisposition;
	private String contentType;
	
	private ModuloBuilder moduloBuilder;

	private byte[] pdfStream;
	
	private ServiziMgr serviziMgr;
	private SigitMgr sigitMgr;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute()
	{
		byte[] datiXml = pdfStream;
		
		LOG.debug("STAMPO datiXml: "+datiXml);
		try
		{
			UtenteLoggato utenteLoggato = (UtenteLoggato) getSession().get(Constants.SESSIONE_VAR_UTENTE_LOGGATO);
			
			String tipoAllegato = request.getParameter("allegato");
			
			LOG.debug(" SALVA ALLEGATO AL RITORNO DA MODOL . TIPO DI ALLEGATO DA SALVARE: "+tipoAllegato);
			
			boolean isControllato = false;
			String idAllegato = null;
			if(Constants.ALLEGATO2_DA_MODOL.equals(tipoAllegato)){
				
				MODIIDocument allegatoII = MapDto.mapToMODIIDocument(datiXml);
				
				try
				{
					isControllato = allegatoII.getMODII().getRichiesta().getDatiModulo().getFlagControlloBozza();
				}catch(Exception e){}
				
				try{
					idAllegato = allegatoII.getMODII().getRichiesta().getDatiModulo().getIdAllegato();
					LOG.debug("idAllegato da XML TIPO1: " + idAllegato);
				}catch(Exception e){}
		
			}else if(Constants.ALLEGATO3_DA_MODOL.equals(tipoAllegato)){
				
				MODIIIDocument allegatoIII = MapDto.mapToMODIIIDocument(datiXml);
				
				try
				{
					isControllato = allegatoIII.getMODIII().getRichiesta().getDatiModulo().getFlagControlloBozza();
				}catch(Exception e){}
				
				try{
					idAllegato = allegatoIII.getMODIII().getRichiesta().getDatiModulo().getIdAllegato();
					LOG.debug("idAllegato da XML TIPO2: " + idAllegato);
				}catch(Exception e){}
				
			}else if(Constants.ALLEGATO4_DA_MODOL.equals(tipoAllegato)){
				MODIVDocument allegatoIV = MapDto.mapToMODIVDocument(datiXml);
				
				try
				{
					isControllato = allegatoIV.getMODIV().getRichiesta().getDatiModulo().getFlagControlloBozza();
				}catch(Exception e){}
				
				try{
					idAllegato = allegatoIV.getMODIV().getRichiesta().getDatiModulo().getIdAllegato();
					LOG.debug("idAllegato da XML TIPO3: " + idAllegato);
				}catch(Exception e){}
			}else if(Constants.ALLEGATO5_DA_MODOL.equals(tipoAllegato)){
				
				MODVDocument allegatoV = MapDto.mapToMODVDocument(datiXml);
				
				try
				{
					isControllato = allegatoV.getMODV().getRichiesta().getDatiModulo().getFlagControlloBozza();
				}catch(Exception e){}
				
				try{
					idAllegato = allegatoV.getMODV().getRichiesta().getDatiModulo().getIdAllegato();
					LOG.debug("idAllegato da XML TIPO4: " + idAllegato);
				}catch(Exception e){}
				
			}
			
			LOG.debug("utenteLOGgato: " + utenteLoggato.getCodiceFiscale());
			LOG.debug("idAllegato da XML: " + idAllegato);
			LOG.debug("isControllato da XML: " + isControllato);
			
	        if(GenericUtil.isNotNullOrEmpty(idAllegato))
	        {
	        	getSigitMgr().updateAllegato(ConvertUtil.convertToBigDecimal(idAllegato), datiXml, isControllato, utenteLoggato.getCodiceFiscale());
	        }
	        else
	        {
	        	LOG.info("Non ho trovato l'idAllegato nell'xml");
	        	session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_UPDATE_DB, Message.ERROR));
	        	return "KO";
	        }
	        
			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.INFO_SALVATAGGIO_CORRETTO, Message.INFO));
			LOG.debug("Salvataggio allegato effettuato. Inserito messaggio in sessione");
			return "OK";
		}
		catch (Exception ex)
		{
			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_UPDATE_DB, Message.ERROR));
			LOG.error("Errore salvataggio libretto",ex);
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
	
	private HttpServletRequest request;
	
	public HttpServletRequest getServletRequest() {
		return request;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
		
	private byte[] readBytesFromInputStream(InputStream is) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		final int FILE_BLOCK_SIZE = 16384; // Numero "magico". Preso dai
										   // sorgenti di ADOBE - DV
		byte[] buf = new byte[FILE_BLOCK_SIZE];

		int readed;
		try {
			while ((readed = is.read(buf)) != -1) {
				os.write(buf, 0, readed);
			}
			os.flush();
		} finally {
			is.close();
			os.close();
		}
		return os.toByteArray();
	}

	public void prepare() throws CommandExecutionException {
		try {
			LOG.debug("ENTRO NEL PREPARE!!!!!");
			
			LOG.debug("Stampo la request: "+getServletRequest());
			
			pdfStream = readBytesFromInputStream(getServletRequest().getInputStream());
			LOG.debug("Lettura byte pdf: "+pdfStream.length);
			//LOG.debug(new String(pdfStream,"UTF-8"));
		} catch (IOException e) {
			LOG.error("Errore: ", e);
		}
		catch (Exception e) {
			LOG.error("Errore: ", e);
		}
		
	}
	
	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}
	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
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
