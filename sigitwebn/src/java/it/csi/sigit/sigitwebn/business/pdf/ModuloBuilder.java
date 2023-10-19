/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.pdf;

import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato;
import it.csi.sigit.sigitwebn.dto.common.UserInfo;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.XmlBeanUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

public class ModuloBuilder  implements Serializable {

	protected static final Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.pdf");
	
	private static final long serialVersionUID = 1L;

	private SigitMgr sigitMgr;
	private ServiziMgr serviziMgr;
	
	private String idImpianto;

	
	private String idRapportoDiControllo;
	private String idBollino;
	private String idCodiceImpianto;
	private String idAllegato;
	private Integer idImport;

	private String actionPageBack;

	private UserInfo userInfo = null;
	
	private String siglaProvinciaUser;
	private String enteUser;
	
	private UtenteLoggato utenteLoggato;
	private DettaglioAllegato dettaglioAllegato;
	

	public DettaglioAllegato getDettaglioAllegato() {
		return dettaglioAllegato;
	}

	public void setDettaglioAllegato(DettaglioAllegato dettaglioAllegato) {
		this.dettaglioAllegato = dettaglioAllegato;
	}

	public String getIdImpianto() {
		return idImpianto;
	}

	public void setIdImpianto(String idImpianto) {
		this.idImpianto = idImpianto;
	}

	public String getIdAllegato() {
		return idAllegato;
	}

	public void setIdAllegato(String idAllegato) {
		this.idAllegato = idAllegato;
	}

	
	public Integer getIdImport() {
		return idImport;
	}

	public void setIdImport(Integer idImport) {
		this.idImport = idImport;
	}

	public String getSiglaProvinciaUser() {
		return siglaProvinciaUser;
	}

	public void setSiglaProvinciaUser(String siglaProvinciaUser) {
		this.siglaProvinciaUser = siglaProvinciaUser;
	}

	public String getEnteUser() {
		return enteUser;
	}

	public void setEnteUser(String enteUser) {
		this.enteUser = enteUser;
	}
	
	public UtenteLoggato getUtenteLoggato() {
		return utenteLoggato;
	}

	public void setUtenteLoggato(UtenteLoggato utenteLoggato) {
		this.utenteLoggato = utenteLoggato;
	}
	
	

	public void setIdRapportoDiControllo(String idRapportoDiControllo){
		this.idRapportoDiControllo = idRapportoDiControllo;
	}
	
	public String getIdRapportoDiControllo(){
		return idRapportoDiControllo;
	}

	public void setIdBollino(String idBollino){
		this.idBollino = idBollino;
	}
	
	public String getIdBollino(){
		return idBollino;
	}

	public void setIdCodiceImpianto(String idCodiceImpianto){
		this.idCodiceImpianto = idCodiceImpianto;
	}
	
	public String getIdCodiceImpianto(){
		return idCodiceImpianto;
	}
	

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;	
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public String getActionPageBack() {
		return actionPageBack;
	}

	public void setActionPageBack(String actionPageBack) {
		this.actionPageBack = actionPageBack;
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

	/**
	 *  
	 * @return MODDocument
	 */
	
	/*
	public MODDocument mapXmlDatiLibretto(byte[] theXml){
		try {
			log.debug("[ModuloBuilder::mapXmlDatiLibretto] start");
			String theXmlString = ModolXFAReader.getXMLData(theXml, "data:MOD");
			//log.debug("theXmlString " + theXmlString);
			InputStream is = new ByteArrayInputStream(theXmlString.getBytes());
			MODDocument librettoDoc = MODDocument.Factory.parse(is);
			//Richiesta richiesta = librettoDoc.getMOD().getRichiesta();
			
			//GenericUtil.stampa(richiesta, false, 3);
			
			log.debug("[ModuloBuilder::mapXmlDatiLibretto] end");
			return librettoDoc;
		} catch (XmlException e) {
			return null;
		} catch (IOException e) {
			return null;
		} catch (ParserConfigurationException e) {
			return null;
		} catch (SAXException e) {
			return null;
		}		
	}
	*/
	/*
	public byte[] showLibretto(){
		log.debug("[ModuloBuilder::showLibretto] START");
		Applicazione app;
		Utente utente;
		XmlModel model;
		try {
			app = new Applicazione();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			utente = null;
			model = getXmlLibretto();
		
			return getServiziMgr().showModuloLibretto(app,utente,model);
		
		}catch(Exception e){
			log.error("Errore apertura file",e);
			return null;
		}finally{
			log.debug("[ModuloBuilder::showLibretto] END");
		}
	}
	*/
	/*
	public byte[] showLibrettoLight(){
		log.debug("[ModuloBuilder::showLibrettoLight] START");
		Applicazione app;
		Utente utente;
		XmlModel model;
		try {
			app = new Applicazione();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			utente = null;
			model = getXmlLibrettoLight();
			
			return getServiziMgr().showModuloLibrettoLight(app,utente,model);
			
		}catch(Exception e){
			log.error("Errore apertura file",e);
			return null;
		}finally{
			log.debug("[ModuloBuilder::showLibrettoLight] END");
		}
	}
	*/
	/*
	public byte[] showAllegato(){
		log.debug("[ModuloBuilder::showAllegato] START");
		Applicazione app;
		Utente utente;
		XmlModel model;
		try {
			app = new Applicazione();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			utente = null;
			
			UtenteLoggato utenteLoggato = getUtenteLoggato();

			model = getSigitMgr().inserisciAllegato(getDettaglioAllegato(), utenteLoggato);
			
			
			log.debug("xml creato");
			return getServiziMgr().showModuloAllegato(app,utente,model, getDettaglioAllegato().getIdTipoAllegato());
			
		}catch(Exception e){
			log.error(e.getMessage()+" - "+e.getMessage(),e);
			return null;
		}finally{
			log.debug("[ModuloBuilder::showAllegato] END");
		}
	}
	*/
	/*
	public byte[] showRicevutaAllegato(){
		log.debug("[ModuloBuilder::showRicevutaAllegato] START");
		Applicazione app;
		Utente utente;
		XmlModel model;
		try {
			app = new Applicazione();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			utente = null;
			model = getXmlRicevutaAllegato();
		
			return getServiziMgr().showModuloRicevutaAllegato(app,utente,model);
		
		}catch(Exception e){
			log.error(e.getMessage()+" - "+e.getMessage(),e);
			return null;
		}finally{
			log.debug("[ModuloBuilder::showRicevutaAllegato] END");
		}
	}
	*/
	
	public byte[] showZipListaLibrettoXml(){
		log.debug("[ModuloBuilder::showZipListaLibrettoXml] START");
		try {
		
			return getSigitMgr().creaZipListaLibrettoXmlByElCodImp(getIdCodiceImpianto());
		
		}catch(Exception e){
			log.error(e.getMessage()+" - "+e.getMessage(),e);
			return null;
		}finally{
			log.debug("[ModuloBuilder::showZipListaLibrettoXml] END");
		}
	}
	
	
	/*
	public byte[] showRicevutaImportDistrib(){
		log.debug("[ModuloBuilder::showRicevutaImportDistrib] START");
		Applicazione app;
		Utente utente;
		XmlModel model;
		try {
			app = new Applicazione();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			utente = null;
			model = getXmlRicevutaImportDistrib();
		
			return getServiziMgr().showModuloRicevutaImportDistrib(app,utente,model);
		
		}catch(Exception e){
			log.error(e.getMessage()+" - "+e.getMessage(),e);
			return null;
		}finally{
			log.debug("[ModuloBuilder::showRicevutaImportDistrib] END");
		}
	}
	*/
	/*
	private XmlModel getXmlLibretto(){
		log.debug("[ModuloBuilder::getXmlLibretto] START");

		//recupero il modello xml dal documento
		XmlModel model;
		try {
			model = new XmlModel();
			byte[] xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getLibretto(getIdImpianto()));
			//log.debug(new String(xmlByteArray,"UTF-8"));
			model.setXmlContent(xmlByteArray);
			return model;
		}catch(Exception e){
			log.error("Errore", e);
			return null;
		} finally{
			log.debug("[ModuloBuilder::getXmlLibretto] END");
		}
	}
	*/
	/*
	private XmlModel getXmlLibrettoLight(){
		log.debug("[ModuloBuilder::getXmlLibrettoLight] START");
		
		//recupero il modello xml dal documento
		XmlModel model;
		try {
			model = new XmlModel();
			byte[] xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getLibrettoLight(getIdImpianto()));
			//log.debug(new String(xmlByteArray,"UTF-8"));
			model.setXmlContent(xmlByteArray);
			return model;
		}catch(Exception e){
			log.error("Errore", e);
			return null;
		} finally{
			log.debug("[ModuloBuilder::getXmlLibrettoLight] END");
		}
	}
	*/
	/*
	private XmlModel getXmlAllegato(boolean isAllegatoInInsert){
		log.debug("[ModuloBuilder::getXmlAllegato] START");
		
		//recupero il modello xml dal documento
		XmlModel model;
		try {
			model = new XmlModel();
			byte[] xmlByteArray = null;
			
			if(Constants.ALLEGATO_TIPO_1.equals(getDettaglioAllegato().getIdTipoAllegato()))
				xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getAllegato(getDettaglioAllegato(),isAllegatoInInsert));
			if(Constants.ALLEGATO_TIPO_2.equals(getDettaglioAllegato().getIdTipoAllegato()))
				xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getAllegatoTipo2(getDettaglioAllegato(),isAllegatoInInsert));
			if(Constants.ALLEGATO_TIPO_3.equals(getDettaglioAllegato().getIdTipoAllegato()))
				xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getAllegatoTipo3(getDettaglioAllegato(),isAllegatoInInsert));
			if(Constants.ALLEGATO_TIPO_4.equals(getDettaglioAllegato().getIdTipoAllegato()))
				xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getAllegatoTipo4(getDettaglioAllegato(),isAllegatoInInsert));
			if(xmlByteArray == null)
				throw new ServiceException("xmlByteArray modulo non trovato");
			
			model.setXmlContent(xmlByteArray);
			return model;
		}catch(Exception e){
			log.error("Errore", e);
			return null;
		} finally{
			log.debug("[ModuloBuilder::getXmlAllegato] END");
			
		}
	}
	*/
	/*
	private XmlModel getXmlRicevutaAllegato(){
		log.debug("[ModuloBuilder::getXmlRicevutaAllegato] START");

		//recupero il modello xml dal documento
		XmlModel model;
		try {
			model = new XmlModel();
			byte[] xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getRicevutaAllegato(getIdAllegato(), getActionPageBack()));
			//log.debug(new String(xmlByteArray,"UTF-8"));
			model.setXmlContent(xmlByteArray);
			return model;
		}catch(Exception e){
			log.error("Errore", e);
			return null;
		} finally{
			log.debug("[ModuloBuilder::getXmlRicevutaAllegato] END");

		}
	}
	*/
	/*
	private XmlModel getXmlRicevutaImportDistrib(){
		log.debug("[ModuloBuilder::getXmlRicevutaImportDistrib] START");

		//recupero il modello xml dal documento
		XmlModel model;
		try {
			model = new XmlModel();
			byte[] xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getRicevutaImportDistrib(getIdImport(), getActionPageBack()));
			//log.debug(new String(xmlByteArray,"UTF-8"));
			model.setXmlContent(xmlByteArray);
			return model;
		}catch(Exception e){
			log.error("Errore", e);
			return null;
		} finally{
			log.debug("[ModuloBuilder::getXmlRicevutaImportDistrib] END");

		}
	}
	*/
	
	/**
	 * 
	 * @author 70140
	 * @param thePdf - Lo stream del PDF
	 * @return xml valorizzato
	 */
	// E' DEL SALVATAGGIO!!!!
	/*
	public byte[] getXmlFromPdf(byte[] thePdf){
		log.debug("[ModuloBuilder::getXmlFromPdf] START");

		Applicazione app;
		Utente utente;
		byte[] file;
		app = new Applicazione();
		app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
		utente = null;
		 try {
			file = getServiziMgr().getXmlFromModol(app,utente,thePdf); //recupero l'xml da modol
		} catch (ServiceException e) {
			log.error("Errore in getXmlFromPdf() - recupero dati xml da MODOL" + e.getMessage());
			return null;
		}
		log.debug("[ModuloBuilder::getXmlFromPdf] END");
		 return file;
	}
	*/
	
}