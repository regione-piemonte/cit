/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.manager;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

//import it.csi.modol.modolsrv.dto.Applicazione;
//import it.csi.modol.modolsrv.dto.Modulo;
//import it.csi.modol.modolsrv.dto.Utente;
//import it.csi.modol.modolsrv.dto.XmlModel;
//import it.csi.modol.modolsrv.dto.utility.RendererModalityExpert;
import it.csi.sigit.sigitbatchn.batch.reader.DataReader;
import it.csi.sigit.sigitbatchn.batch.reader.DataStringReader;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitDFluidoDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitRComp4ManutAllDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitRComp4ManutDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitRImpRuoloPfpgDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitRImpRuoloPfpgPk;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTAccertamentoByUtentiNonAttiviDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTAccertamentoDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTDettTipo1Dto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTDettTipo2Dto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTDettTipo3Dto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTDettTipo4Dto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImpXmlDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDistribDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTIspezione2018ByCodiceFiscaleDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTIspezione2018ByUtentiNonAttiviDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTLibrettoDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTLogDistribDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTPersonaFisicaDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTPersonaGiuridicaPk;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTRappTipo1Dto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTRappTipo1Pk;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTRappTipo2Dto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTRappTipo2Pk;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTRappTipo3Dto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTRappTipo3Pk;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTRappTipo4Dto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTRappTipo4Pk;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTSanzioneAccertamentiByUtentiNonAttiviDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTSanzioneDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTSanzioneIspezione2018ByUtentiNonAttiviDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTTrattH2ODto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTTrattH2OPk;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTUnitaImmobiliareDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTVerificaByUtentiNonAttiviDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTVerificaDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVCompCgDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVCompGfDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVCompGtDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVCompScDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVSk4CgDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVSk4GfDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVSk4GtDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVSk4ScDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVTotImpiantoDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.SigitTAllegatoDaoException;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.SigitTTrattH2ODaoException;
import it.csi.sigit.sigitbatchn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitbatchn.business.manager.util.ManagerException;
import it.csi.sigit.sigitbatchn.business.manager.util.Message;
import it.csi.sigit.sigitbatchn.business.manager.util.Messages;
import it.csi.sigit.sigitbatchn.business.manager.util.ServiceException;
import it.csi.sigit.sigitbatchn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitbatchn.business.pdf.RicevutaBuilder;
import it.csi.sigit.sigitbatchn.business.util.Constants;
import it.csi.sigit.sigitbatchn.business.util.ConvertUtil;
import it.csi.sigit.sigitbatchn.business.util.DateUtil;
import it.csi.sigit.sigitbatchn.business.util.GenericUtil;
import it.csi.sigit.sigitbatchn.business.util.InputAllegatiComp;
import it.csi.sigit.sigitbatchn.business.util.MapDto;
import it.csi.sigit.sigitbatchn.business.util.XmlBeanUtils;
import it.csi.sigit.sigitwebn.xml.allegato2.data.CheckListDocument.CheckList;
import it.csi.sigit.sigitwebn.xml.allegato2.data.ControlloImpiantoDocument.ControlloImpianto;
import it.csi.sigit.sigitwebn.xml.allegato2.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica;
import it.csi.sigit.sigitwebn.xml.allegato2.data.DatiAllegatoDocument.DatiAllegato.AllegatoII;
import it.csi.sigit.sigitwebn.xml.allegato2.data.DatiTecnicoDocument.DatiTecnico;
import it.csi.sigit.sigitwebn.xml.allegato2.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica;
import it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument;
import it.csi.sigit.sigitwebn.xml.allegato2.data.RowAllegatoIIDocument.RowAllegatoII;
import it.csi.sigit.sigitwebn.xml.allegato2.data.RowAllegatoIIDocument.RowAllegatoII.TabFumi;
import it.csi.sigit.sigitwebn.xml.allegato2.data.RowFumiDocument.RowFumi;
import it.csi.sigit.sigitwebn.xml.allegato3.data.DatiAllegatoDocument.DatiAllegato.AllegatoIII;
import it.csi.sigit.sigitwebn.xml.allegato3.data.MODIIIDocument;
import it.csi.sigit.sigitwebn.xml.allegato4.data.DatiAllegatoDocument.DatiAllegato.AllegatoIV;
import it.csi.sigit.sigitwebn.xml.allegato4.data.MODIVDocument;
import it.csi.sigit.sigitwebn.xml.allegato5.data.DatiAllegatoDocument.DatiAllegato.AllegatoV;
import it.csi.sigit.sigitwebn.xml.allegato5.data.MODVDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiIntestazioneDocument.DatiIntestazione;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RowAllegatoVDocument.RowAllegatoV;
import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.DatiFornituraCliente;
import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.UTENZEDISTComunicazione;
//import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.DatiFornituraClienteDocument.DatiFornituraCliente;
//import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.UTENZEDISTComunicazione;

/**
 * Manager generale del sigit, nel caso in cui bisogna chiamare vari servizi o servizi e DB
 * 
 */
public class SigitbatchMgr {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");

	
	
	/**
	 * Manager del DB
	 */
	protected DbMgr dbMgr;
	
	/**
	 * Manager del validation
	 */
	protected ValidationMgr validationMgr;
	
	/**
	 * Manager dei servizi
	 */
	protected ServiziMgr serviziMgr;
	
	protected RicevutaBuilder ricevutaBuilder;
	
	/**
	 * Restituisce il manager dei servizi
	 * 
	 * @return Manager dei servizi
	 */
	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	/**
	 * Imposta i manager dei servizi
	 * 
	 * @param serviziMgr Manager dei servizi
	 */
	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	/**
	 * Restituisce il manager del DB
	 * 
	 * @return Manager del DB
	 */
	public DbMgr getDbMgr() {
		return dbMgr;
	}

	/**
	 * Imposta i manager del DB
	 * 
	 * @param serviziMgr Manager del DB
	 */
	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}
	

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}
	
	public RicevutaBuilder getRicevutaBuilder() {
		return ricevutaBuilder;
	}

	public void setRicevutaBuilder(RicevutaBuilder ricevutaBuilder) {
		this.ricevutaBuilder = ricevutaBuilder;
	}

	public List<SigitTImportDto> getXmlDaImportare()
	{
		log.debug("[SigitbatchMgr::getXmlDaImportare] BEGIN");

		List<SigitTImportDto> dtoList = null;
		
		try {
			log.debug("[SigitbatchMgr::getXmlDaImportare] Step 1 – Recupero dati record");

			dtoList = getDbMgr().cercaXmlDaImportare();
			
		}
		catch (DbManagerException ex)
		{
			// E' DA GESTIRE

			log.error(ex);
		}
		
		
		log.debug("[SigitbatchMgr::getXmlDaImportare] END");

		return dtoList;

	}
	
	public List<SigitTImportDistribDto> getXmlDistributoriDaImportare()
	{
		log.debug("[SigitbatchMgr::getXmlDistributoriDaImportare] BEGIN");

		List<SigitTImportDistribDto> dtoList = null;
		
		try {
			log.debug("[SigitbatchMgr::getXmlDistributoriDaImportare] Step 1 – Recupero dati record");

			dtoList = getDbMgr().cercaXmlDistributoriDaImportare();
			
		}
		catch (DbManagerException ex)
		{
			// E' DA GESTIRE

			log.error(ex);
		}
		
		
		log.debug("[SigitbatchMgr::getXmlDistributoriDaImportare] END");

		return dtoList;

	}
	
	@Transactional
	public void gestisciInvioMailAssistenza(String dataInizioElaborazione) throws ManagerException
	{
		log.debug("[SigitbatchMgr::gestisciInvioMailAssistenza] BEGIN");

		List<SigitTImportDto> dtoList = null;
		
		try {
			log.debug("[SigitbatchMgr::getXmlDaImportare] Step 1 – Recupero dati record");

			dtoList = getDbMgr().cercaXmlDaInviareMailAssistenza();
			
			getDbMgr().modificaImportInvioMailAss();
			
			inviaMailAssistenza(dtoList, dataInizioElaborazione);
			
			
		}
		catch (DbManagerException ex)
		{
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			log.error(ex);
			throw ex;
		}
		
		
		log.debug("[SigitbatchMgr::gestisciInvioMailAssistenza] END");
	}
	
	@Transactional
	public void gestisciInvioMailAssistenzaDistrib(String dataInizioElaborazione) throws ManagerException
	{
		log.debug("[SigitbatchMgr::gestisciInvioMailAssistenzaDistrib] BEGIN");

		List<SigitTImportDistribDto> dtoList = null;
		
		try {
			log.debug("[SigitbatchMgr::gestisciInvioMailAssistenzaDistrib] Step 1 – Recupero dati record");

			dtoList = getDbMgr().cercaImportDistribDaInviareMailAssistenza();
			
			getDbMgr().modificaImportDistribInvioMailAss();
			
			inviaMailAssistenzaDistrib(dtoList, dataInizioElaborazione);
			
			
		}
		catch (DbManagerException ex)
		{
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			log.error(ex);
			throw ex;
		}
		
		
		log.debug("[SigitbatchMgr::gestisciInvioMailAssistenzaDistrib] END");
	}
	
	public SigitTImpXmlDto verificaXmlAllegato(String nomeFile, SigitTImportDto sigitTImportDto) throws ManagerException
	{
		log.debug("[SigitbatchMgr::verificaXmlAllegato] BEGIN");

		SigitTImpXmlDto impXml = null;
		
		try {
			impXml = getFileTxtDaImportare(sigitTImportDto.getIdImport());

			getValidationMgr().validazioneXmlImport(sigitTImportDto.getIdImport(), impXml.getFileImport(), nomeFile);
			
		}
		catch (ValidationManagerException ex)
		{
//			String msg = ex.getMessage();
//
//			System.out.println("Stampo il messaggio prima di settare il nome: "+msg);
//			msg = msg.replaceFirst("##valueNomeFile##", nomeFile);
//			System.out.println("Stampo il messaggio dopo aver settato il nome: "+msg);
//			
//			throw new ValidationManagerException(new Message(msg));
			
			throw ex;

		}
		catch (Exception ex)
		{
			
			throw new ManagerException(new Message(Messages.ERRORE_NON_PREVISTO_BATCH));
		}
		
		log.debug("[SigitbatchMgr::verificaXmlAllegato] END");

		return impXml;

	}
	
	
	public void gestisciXmlDistributore(String nomeFile, SigitTImportDistribDto sigitTImportDistribDto) throws ManagerException
	{
		log.debug("[SigitbatchMgr::gestisciXmlDistributore] BEGIN");

		
		try {
			List<DatiFornituraCliente> listForniture = getFileDistribDaImportare(sigitTImportDistribDto.getUidIndex());

			//List<DatiFornituraCliente> richiesta = getValidationMgr().validazioneXmlImportDistrib(indexFile);
			
			gestisciListaFornituraCliente(sigitTImportDistribDto.getIdImportDistrib(), listForniture);
			
			gestisciAvvenutoImportDistrib(sigitTImportDistribDto.getIdImportDistrib());
			
		}
		catch (Exception ex)
		{
			
			log.error("[SigitbatchMgr::gestisciXmlDistributore] ERROR ",ex);
			
			// gestisco l'eccezione sull'intero file
			String message = ex.getMessage().replaceFirst("##valueNomeFile##", nomeFile);
			getDbMgr().inserisciLogDistrib(sigitTImportDistribDto.getIdImportDistrib(), message);

			getDbMgr().aggiornaImportDistribRifiutato(sigitTImportDistribDto.getIdImportDistrib());
			
			gestisciFallimentoImportDistrib(sigitTImportDistribDto.getIdImportDistrib(), message);

		}
		
		
		log.debug("[SigitbatchMgr::gestisciXmlDistributore] END");


	}
	
	@Transactional
	public void gestisciListaFornituraCliente(Integer idImportDistrib, List<DatiFornituraCliente> listForniture) throws ManagerException
	{
		log.debug("[SigitbatchMgr::gestisciListaFornituraCliente] BEGIN");

		Integer countTot = null;
		Integer countTotScart = 0;
				
		try {

			if (listForniture != null && listForniture.size() > 0)
			{
				countTot = listForniture.size();
						
				for (DatiFornituraCliente datiFornituraCliente : listForniture) {
					
					try
					{
						getValidationMgr().validazioneFornituraClienteXmlImportDistrib(datiFornituraCliente);
						
						getDbMgr().inserisciFornituraClienteDistrib(idImportDistrib, datiFornituraCliente);
					}
					catch (ValidationManagerException ex)
					{
						// gestisco l'eccezione sulla singola fornitura
						
						countTotScart++;
						
						getDbMgr().inserisciLogDistrib(idImportDistrib, ex.getMessage());
					}
				}
				
				getDbMgr().aggiornaImportDistribInviato(idImportDistrib, countTot, countTotScart);
			}
			
		}
		catch (Exception ex)
		{
			log.error(ex);
			throw new ManagerException(new Message(Messages.ERRORE_NON_PREVISTO_BATCH));

		}
		
		
		log.debug("[SigitbatchMgr::gestisciListaFornituraCliente] END");

	}
	
	@Transactional
	public boolean importaXmlAllegato(SigitTImportDto sigitTImportDto, SigitTImpXmlDto impXml) throws ManagerException
	{
		log.debug("[SigitbatchMgr::importaXmlAllegato] BEGIN");

		boolean isFileCorretto = false;
		SigitTAllegatoDto allegatoDto = null;
		try {
			
			String nomeFile = sigitTImportDto.getNomeFileImport();
			String theXml = null;
			DataReader daReaderFile = null;
			
			daReaderFile = new DataStringReader(impXml.getFileImport());
			
			theXml = XmlBeanUtils.readFile(daReaderFile.getReader());
			
			String codCatasto = null;
			ArrayList<String> elencoProgressivi = new ArrayList<String>();
			
			SigitTPersonaGiuridicaDto pg = null;
			SigitTPersonaFisicaDto pfPreImport = getDbMgr().cercaPfPreImportById(sigitTImportDto.getFkPreImport());
			Integer idRuolo = null;

			String elencoApparecchiature = null;
			String elencoCombustibili = null;
			
			List<SigitVSk4GtDto> listCompGtDettDto = null;
			List<SigitVSk4GfDto> listCompGfDettDto = null;
			List<SigitVSk4ScDto> listCompScDettDto = null;
			List<SigitVSk4CgDto> listCompCgDettDto = null;
			if(GenericUtil.iniziaPer(nomeFile, Constants.DES_INIZIO_ALLEGATO_II))
			{
				log.debug("[ValidationMgr::validazioneXmlImport] Step XX – Recupero AllegatoII");
				
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument document = it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument.Factory.parse(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RichiestaDocument.Richiesta richiesta = document.getMODII().getRichiesta();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiManutentoreDocument.DatiManutentore manutentore = richiesta.getDatiManutentore();

				pg = getDbMgr().cercaPersonaGiuridica(manutentore.getCodiceFiscale(), manutentore.getSiglaREA(), ConvertUtil.convertToBigDecimal(manutentore.getNumeroREA()));

				//pfPreImport = getDbMgr().cercaPfPreImportById(sigitTImportDto.getFkPreImport());
				
				List<it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowAllegatoIIDocument.RowAllegatoII> listaRow = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();

				for (int i = 0; i < listaRow.size(); i++) {
					it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowAllegatoIIDocument.RowAllegatoII rowAllegatoII = listaRow.get(i);
					elencoProgressivi.add(ConvertUtil.convertToString(rowAllegatoII.getAENumGT()));
					
				}
				
				String idImpiantoRuoloPfPg = getDbMgr()
						.getIdImpiantoRuoloPfPg(
								richiesta.getDatiIntestazione().getCodiceCatasto(),
								pg.getIdPersonaGiuridica(),
								Constants.ALLEGATO_TIPO_1);

				codCatasto = richiesta.getDatiIntestazione().getCodiceCatasto();

				listCompGtDettDto = getDbMgr().getCompGtAttiviInDataProgressivi(codCatasto, ConvertUtil.convertToString(richiesta.getDatiIntestazione().getAFDataControllo()), elencoProgressivi);
				elencoCombustibili = MapDto.mapToElencoCombustibiliGt(listCompGtDettDto);
				elencoApparecchiature = MapDto.mapToElencoApparecchiatureVSkGt(listCompGtDettDto);

				allegatoDto = MapDto.mapToAllegato2(richiesta, idImpiantoRuoloPfPg, pfPreImport.getCodiceFiscale(), elencoCombustibili, elencoApparecchiature);
				idRuolo = Constants.ID_RUOLO_MANUTENTORE_ALL_1;

				
				
			}
			else if(GenericUtil.iniziaPer(nomeFile, Constants.DES_INIZIO_ALLEGATO_III))
			{
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.8 – Verifica obbligatorietà e formalità AllegatoIII");
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument document = it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument.Factory.parse(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RichiestaDocument.Richiesta richiesta = document.getMODIII().getRichiesta();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiManutentoreDocument.DatiManutentore manutentore = richiesta.getDatiManutentore();
				pg = getDbMgr().cercaPersonaGiuridica(manutentore.getCodiceFiscale(), manutentore.getSiglaREA(), ConvertUtil.convertToBigDecimal(manutentore.getNumeroREA()));

				//pfPreImport = getDbMgr().cercaPfPreImportById(sigitTImportDto.getFkPreImport());
				
				List<it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII> listaRow = richiesta.getDatiAllegato().getAllegatoIII().getRowAllegatoIIIList();

				for (int i = 0; i < listaRow.size(); i++) {
					it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII rowAllegatoIII = listaRow.get(i);
					elencoProgressivi.add(ConvertUtil.convertToString(rowAllegatoIII.getAENumGF()));
					
				}
				
				String idImpiantoRuoloPfPg = getDbMgr()
						.getIdImpiantoRuoloPfPg(
								richiesta.getDatiIntestazione().getCodiceCatasto(),
								pg.getIdPersonaGiuridica(),
								Constants.ALLEGATO_TIPO_2);
				
				codCatasto = richiesta.getDatiIntestazione().getCodiceCatasto();

				listCompGfDettDto = getDbMgr().getCompGfAttiviInDataProgressivi(codCatasto, ConvertUtil.convertToString(richiesta.getDatiIntestazione().getAFDataControllo()), elencoProgressivi);
				//elencoCombustibiliList = null;//GenericUtil.getElencoCombustibiliCompGf(listCompGfDettDto);
				elencoApparecchiature = MapDto.mapToElencoApparecchiatureVSkGf(listCompGfDettDto);
				
				allegatoDto = MapDto.mapToAllegato3(richiesta, idImpiantoRuoloPfPg, pfPreImport.getCodiceFiscale(), elencoApparecchiature);
				idRuolo = Constants.ID_RUOLO_MANUTENTORE_ALL_2;

			}
			else if(GenericUtil.iniziaPer(nomeFile, Constants.DES_INIZIO_ALLEGATO_IV))
			{
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.8 – Verifica obbligatorietà e formalità AllegatoIV");
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument document = it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument.Factory.parse(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RichiestaDocument.Richiesta richiesta = document.getMODIV().getRichiesta();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiManutentoreDocument.DatiManutentore manutentore = richiesta.getDatiManutentore();
				pg = getDbMgr().cercaPersonaGiuridica(manutentore.getCodiceFiscale(), manutentore.getSiglaREA(), ConvertUtil.convertToBigDecimal(manutentore.getNumeroREA()));
				//pfPreImport = getDbMgr().cercaPfPreImportById(sigitTImportDto.getFkPreImport());
				
				List<it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV> listaRow = richiesta.getDatiAllegato().getAllegatoIV().getRowAllegatoIVList();

				for (int i = 0; i < listaRow.size(); i++) {
					it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV rowAllegatoIV = listaRow.get(i);
					elencoProgressivi.add(ConvertUtil.convertToString(rowAllegatoIV.getAENumSC()));
					
				}
				
				String idImpiantoRuoloPfPg = getDbMgr()
						.getIdImpiantoRuoloPfPg(
								richiesta.getDatiIntestazione().getCodiceCatasto(),
								pg.getIdPersonaGiuridica(),
								Constants.ALLEGATO_TIPO_3);
				
				codCatasto = richiesta.getDatiIntestazione().getCodiceCatasto();

				listCompScDettDto = getDbMgr().getCompScAttiviInDataProgressivi(codCatasto, ConvertUtil.convertToString(richiesta.getDatiIntestazione().getAFDataControllo()), elencoProgressivi);
				//elencoCombustibiliList = null;//GenericUtil.getElencoCombustibiliCompSc(listCompScDettDto);
				elencoApparecchiature = MapDto.mapToElencoApparecchiatureVSkSc(listCompScDettDto);
				
				allegatoDto = MapDto.mapToAllegato4(richiesta, idImpiantoRuoloPfPg, pfPreImport.getCodiceFiscale(), elencoApparecchiature);
				idRuolo = Constants.ID_RUOLO_MANUTENTORE_ALL_3;

			}
			else if(GenericUtil.iniziaPer(nomeFile, Constants.DES_INIZIO_ALLEGATO_V))
			{
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.8 – Verifica obbligatorietà e formalità AllegatoV");
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument document = it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument.Factory.parse(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RichiestaDocument.Richiesta richiesta = document.getMODV().getRichiesta();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiManutentoreDocument.DatiManutentore manutentore = richiesta.getDatiManutentore();
				pg = getDbMgr().cercaPersonaGiuridica(manutentore.getCodiceFiscale(), manutentore.getSiglaREA(), ConvertUtil.convertToBigDecimal(manutentore.getNumeroREA()));
				//pfPreImport = getDbMgr().cercaPfPreImportById(sigitTImportDto.getFkPreImport());
				
				List<it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RowAllegatoVDocument.RowAllegatoV> listaRow = richiesta.getDatiAllegato().getAllegatoV().getRowAllegatoVList();

				for (int i = 0; i < listaRow.size(); i++) {
					it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RowAllegatoVDocument.RowAllegatoV rowAllegatoV = listaRow.get(i);
					elencoProgressivi.add(ConvertUtil.convertToString(rowAllegatoV.getAENumCG()));
					
				}
				
				String idImpiantoRuoloPfPg = getDbMgr()
						.getIdImpiantoRuoloPfPg(
								richiesta.getDatiIntestazione().getCodiceCatasto(),
								pg.getIdPersonaGiuridica(),
								Constants.ALLEGATO_TIPO_4);
				
				codCatasto = richiesta.getDatiIntestazione().getCodiceCatasto();

				listCompCgDettDto = getDbMgr().getCompCgAttiviInDataProgressivi(codCatasto, ConvertUtil.convertToString(richiesta.getDatiIntestazione().getAFDataControllo()), elencoProgressivi);
				//elencoCombustibiliList = null;//GenericUtil.getElencoCombustibiliCompCg(listCompCgDettDto);
				elencoApparecchiature = MapDto.mapToElencoApparecchiatureVSkCg(listCompCgDettDto);
				
				allegatoDto = MapDto.mapToAllegato5(richiesta, idImpiantoRuoloPfPg, pfPreImport.getCodiceFiscale(), elencoApparecchiature);
				idRuolo = Constants.ID_RUOLO_MANUTENTORE_ALL_4;

			}

			
			//List<SigitRComp4ManutDto> manAttivoAttuale = getDbMgr().cercaAttualiByRuolo(codiceImpianto, pg.getIdPersonaGiuridica(), idRuolo);

			
			// Qui inserisco l'xml dell'import 
			// Forse l'insert è da spostare nell'invio (quindi fare un insert globale e dell'xml globale e non dell'import)
			
			if (GenericUtil.isNotNullOrEmpty(sigitTImportDto.getFkPgCat()));
			{
				allegatoDto.setFkPgCat(ConvertUtil.convertToBigDecimal(sigitTImportDto.getFkPgCat()));
			}
			
			getDbMgr().inserisciAllegato(allegatoDto);
			
			log.debug("BEPPE - DEVO INSERIRE NELLA NUOVA TABELLA!!!!");

			log.debug("STAMPO allegatoDto.getFkTipoDocumento(): " +allegatoDto.getFkTipoDocumento());
			
			log.debug("Stampo la verifica: "+(Constants.ALLEGATO_TIPO_1.equals(allegatoDto.getFkTipoDocumento().toString())));
			/*
			if(Constants.ALLEGATO_TIPO_1.equals(allegatoDto.getFkTipoDocumento().toString()))
			{
				
				log.debug("ENTRO NELL?INSERIMNETO inserisciRAllegatoCompGt");
				
				for (SigitVSk4GtDto sigitVSk4GtDto : listCompGtDettDto) {

					getDbMgr().inserisciRAllegatoCompGt(allegatoDto.getIdAllegato(), sigitVSk4GtDto);
					
				}
				
			}
			else
			if(Constants.ALLEGATO_TIPO_2.equals(allegatoDto.getFkTipoDocumento().toString()))
			{
				for (SigitVSk4GfDto sigitVSk4GfDto : listCompGfDettDto) {

					getDbMgr().inserisciRAllegatoCompGf(allegatoDto.getIdAllegato(), sigitVSk4GfDto);
					
				}
			}
			else
			if(Constants.ALLEGATO_TIPO_3.equals(allegatoDto.getFkTipoDocumento().toString()))
			{
				for (SigitVSk4ScDto sigitVSk4ScDto : listCompScDettDto) {

					getDbMgr().inserisciRAllegatoCompSc(allegatoDto.getIdAllegato(), sigitVSk4ScDto);
					
				}
			}
			else
			if(Constants.ALLEGATO_TIPO_4.equals(allegatoDto.getFkTipoDocumento().toString()))
			{
				for (SigitVSk4CgDto sigitVSk4CgDto : listCompCgDettDto) {

					getDbMgr().inserisciRAllegatoCompCg(allegatoDto.getIdAllegato(), sigitVSk4CgDto);
					
				}
			}
			*/
			
			List<SigitRComp4ManutDto> comp4ManutList = getDbMgr().cercaAttualiByRuolo(codCatasto, pg.getIdPersonaGiuridica(), idRuolo, elencoProgressivi);
			
			SigitRComp4ManutAllDto comp4Manut = null;
			for (SigitRComp4ManutDto sigitRComp4ManutDto : comp4ManutList) {
				log.debug("sigitRComp4ManutDto: "+sigitRComp4ManutDto);
				comp4Manut = new SigitRComp4ManutAllDto();
				comp4Manut.setIdRComp4Manut(sigitRComp4ManutDto.getIdRComp4Manut());
				comp4Manut.setIdAllegato(allegatoDto.getIdAllegato());
				// Devo inserire su sigit_r_comp4manut_all
				getDbMgr().getSigitRComp4ManutAllDao().insert(comp4Manut);
			}
			
			// Setto l'ID allegato sulla tabella Import
			getDbMgr().settaIdAllegatoToImport(sigitTImportDto.getIdImport(), allegatoDto.getIdAllegato());
		
			getDbMgr().insertAllTxtAllegato(allegatoDto.getIdAllegato(), theXml);
			
//			byte[] thePdfAllegato = inviaAllegato(allegatoDto, impXml, codCatasto, pg);

			//byte[] thePdfRicevuta = showRicevutaAllegato(idAllegato);
			
			String msgAvviso = null;
			
			if (getValidationMgr().isImpiantoSenzaValvoleTermostatiche(
					allegatoDto.getDataControllo(),
					codCatasto)) {
				
				msgAvviso = Messages.A002;
			}
			
//			gestisciInvioMailImportOK(sigitTImportDto, thePdfAllegato, msgAvviso);
			
			//inviaMailFileImportCorretto(emailListDest, nomeFile, msg, thePdfAllegato, thePdfRicevuta);
			
		}
		catch (ManagerException ex)
		{
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			log.error("Eccezione", ex);
			//throw new ValidationManagerException(new Message(msg));
			throw ex;

		}
		catch (Exception ex)
		{
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			log.error("Eccezione", ex);
			
			throw new ManagerException(new Message(Messages.ERRORE_NON_PREVISTO_BATCH));

		}
		
		log.debug("[SigitbatchMgr::importaXmlAllegato] END");

		return isFileCorretto;

	}
	
	/*
	@Transactional
	public boolean importaXmlDistributore(SigitTImportDto sigitTImportDto, SigitTImpXmlDto impXml) throws ManagerException
	{
		log.debug("[SigitbatchMgr::importaXmlDistributore] BEGIN");

		boolean isFileCorretto = false;
		SigitTAllegatoDto allegatoDto = null;
		try {
			
			
			
			String nomeFile = sigitTImportDto.getNomeFileImport();
			String theXml = null;
			DataReader daReaderFile = null;
			
			daReaderFile = new DataStringReader(impXml.getFileImport());
			
			theXml = XmlBeanUtils.readFile(daReaderFile.getReader());
			
			String codCatasto = null;
			SigitTPersonaGiuridicaDto pg = null;
			if(GenericUtil.iniziaPer(nomeFile, Constants.DES_INIZIO_ALLEGATO_II))
			{
				log.debug("[ValidationMgr::validazioneXmlImport] Step XX – Recupero AllegatoII");
				
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument document = it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument.Factory.parse(theXml);

				
				log.debug("convertito xml in java");
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RichiestaDocument.Richiesta richiesta = document.getMODII().getRichiesta();
				
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiManutentoreDocument.DatiManutentore manutentore = richiesta.getDatiManutentore();

				pg = getDbMgr().cercaPersonaGiuridica(manutentore.getCodiceFiscale(), manutentore.getSiglaREA(), ConvertUtil.convertToBigDecimal(manutentore.getNumeroREA()));

				SigitTPersonaFisicaDto pfPreImport = getDbMgr().cercaPfPreImportById(sigitTImportDto.getFkPreImport());
				
				
				String idImpiantoRuoloPfPg = getDbMgr()
						.getIdImpiantoRuoloPfPg(
								richiesta.getDatiIntestazione().getCodiceCatasto(),
								pg.getIdPersonaGiuridica(),
								Constants.ALLEGATO_TIPO_1);
				
				allegatoDto = MapDto.mapToAllegato2(richiesta, idImpiantoRuoloPfPg, pfPreImport.getCodiceFiscale());
				codCatasto = richiesta.getDatiIntestazione().getCodiceCatasto();
			}
			else if(GenericUtil.iniziaPer(nomeFile, Constants.DES_INIZIO_ALLEGATO_III))
			{
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.8 – Verifica obbligatorietà e formalità AllegatoIII");
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument document = it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument.Factory.parse(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RichiestaDocument.Richiesta richiesta = document.getMODIII().getRichiesta();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiManutentoreDocument.DatiManutentore manutentore = richiesta.getDatiManutentore();

				pg = getDbMgr().cercaPersonaGiuridica(manutentore.getCodiceFiscale(), manutentore.getSiglaREA(), ConvertUtil.convertToBigDecimal(manutentore.getNumeroREA()));

				SigitTPersonaFisicaDto pfPreImport = getDbMgr().cercaPfPreImportById(sigitTImportDto.getFkPreImport());
				
				String idImpiantoRuoloPfPg = getDbMgr()
						.getIdImpiantoRuoloPfPg(
								richiesta.getDatiIntestazione().getCodiceCatasto(),
								pg.getIdPersonaGiuridica(),
								Constants.ALLEGATO_TIPO_2);
				
				allegatoDto = MapDto.mapToAllegato3(richiesta, idImpiantoRuoloPfPg, pfPreImport.getCodiceFiscale());
				codCatasto = richiesta.getDatiIntestazione().getCodiceCatasto();
			}
			else if(GenericUtil.iniziaPer(nomeFile, Constants.DES_INIZIO_ALLEGATO_IV))
			{
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.8 – Verifica obbligatorietà e formalità AllegatoIV");
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument document = it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument.Factory.parse(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RichiestaDocument.Richiesta richiesta = document.getMODIV().getRichiesta();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiManutentoreDocument.DatiManutentore manutentore = richiesta.getDatiManutentore();
				pg = getDbMgr().cercaPersonaGiuridica(manutentore.getCodiceFiscale(), manutentore.getSiglaREA(), ConvertUtil.convertToBigDecimal(manutentore.getNumeroREA()));
				SigitTPersonaFisicaDto pfPreImport = getDbMgr().cercaPfPreImportById(sigitTImportDto.getFkPreImport());
				
				String idImpiantoRuoloPfPg = getDbMgr()
						.getIdImpiantoRuoloPfPg(
								richiesta.getDatiIntestazione().getCodiceCatasto(),
								pg.getIdPersonaGiuridica(),
								Constants.ALLEGATO_TIPO_3);
				
				allegatoDto = MapDto.mapToAllegato4(richiesta, idImpiantoRuoloPfPg, pfPreImport.getCodiceFiscale());
				codCatasto = richiesta.getDatiIntestazione().getCodiceCatasto();
			}
			else if(GenericUtil.iniziaPer(nomeFile, Constants.DES_INIZIO_ALLEGATO_V))
			{
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.8 – Verifica obbligatorietà e formalità AllegatoV");
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument document = it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument.Factory.parse(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RichiestaDocument.Richiesta richiesta = document.getMODV().getRichiesta();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiManutentoreDocument.DatiManutentore manutentore = richiesta.getDatiManutentore();
				pg = getDbMgr().cercaPersonaGiuridica(manutentore.getCodiceFiscale(), manutentore.getSiglaREA(), ConvertUtil.convertToBigDecimal(manutentore.getNumeroREA()));
				SigitTPersonaFisicaDto pfPreImport = getDbMgr().cercaPfPreImportById(sigitTImportDto.getFkPreImport());
				
				String idImpiantoRuoloPfPg = getDbMgr()
						.getIdImpiantoRuoloPfPg(
								richiesta.getDatiIntestazione().getCodiceCatasto(),
								pg.getIdPersonaGiuridica(),
								Constants.ALLEGATO_TIPO_4);
				
				allegatoDto = MapDto.mapToAllegato5(richiesta, idImpiantoRuoloPfPg, pfPreImport.getCodiceFiscale());
				codCatasto = richiesta.getDatiIntestazione().getCodiceCatasto();
			}

			// Qui inserisco l'xml dell'import 
			// Forse l'insert è da spostare nell'invio (quindi fare un insert globale e dell'xml globale e non dell'import)
			BigDecimal idAllegato = getDbMgr().inserisciAllegato(allegatoDto);
			
			// Setto l'ID allegato sulla tabella Import
			getDbMgr().settaIdAllegatoToImport(sigitTImportDto.getIdImport(), idAllegato);
		
			getDbMgr().insertAllTxtAllegato(idAllegato, theXml);
			
			byte[] thePdfAllegato = inviaAllegato(allegatoDto, impXml, codCatasto, pg);

			//byte[] thePdfRicevuta = showRicevutaAllegato(idAllegato);
			
			gestisciInvioMailImportOK(sigitTImportDto, thePdfAllegato);
			
			//inviaMailFileImportCorretto(emailListDest, nomeFile, msg, thePdfAllegato, thePdfRicevuta);
			
		}
		catch (ManagerException ex)
		{
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			log.error("Eccezione", ex);
			//throw new ValidationManagerException(new Message(msg));
			throw ex;

		}
		catch (Exception ex)
		{
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			log.error("Eccezione", ex);
			
			throw new ManagerException(new Message(Messages.ERRORE_NON_PREVISTO_BATCH));

		}
		
		log.debug("[SigitbatchMgr::importaXmlDistributore] END");

		return isFileCorretto;

	}
	*/
	/*
	public byte[] inviaAllegato(SigitTAllegatoDto allegatoDto, SigitTImpXmlDto impXml, String codImpianto, SigitTPersonaGiuridicaDto dettaglioImpresaManutentrice)throws ManagerException {
		log.debug("[SigitMgr::inviaAllegato] START");
		//SigitTAllTxtDto fileAllegatoDto = null;
		SigitTImpiantoDto impiantoDto = null;
		String uid = null;
		String codiceRea = null;
		//it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument mod1 = null;
		MODIIDocument mod1 = null;
		MODIIIDocument mod2 = null;
		MODIVDocument mod3 = null;
		MODVDocument mod4 = null;
		
		MODIIDocument moduloAggiornato = null;
		
		byte[] thePdfAllegato = null;
		try {

			//recupero l'impianto associato all'allegato
			impiantoDto = getDbMgr().cercaImpiantoById(codImpianto);
			
//			SigitTAllegatoPk pk = new SigitTAllegatoPk();
//			pk.setIdAllegato(ConvertUtil.convertToBigDecimal(dettaglio.getIdAllegato()));
			//devo caricare l'oggetto Allegato dal DB perche' devo ottenere l'xml dell'allegato
			//allegatoDto = getDbMgr().getSigitTAllegatoDao().findByPrimaryKey(pk);
			
			//fileAllegatoDto = getDbMgr().getAllTxtAllegato(pk.getIdAllegato());
			
			//recupero l'allegato xml
			//byte[] allegato = XmlBeanUtils.readString(fileAllegatoDto.getXmlAllegato());
			
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 1 STEP ");
			
			//Parte comune a tutti i tipi di allegati, serve per istanziare un nuovo document da andare a popolare con i dati
			//aggiornati dal documento ottenuto utilizzando i dati dal db
			Applicazione app = new Applicazione();
			XmlModel xmlModel = new XmlModel();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			
			//vado a discernere quale allegato scegliere dall'fkTipoDocumento
			String tipoDocumento = this.getModelloModolAllegato(allegatoDto.getFkTipoDocumento().toString());
			Modulo modulo = getServiziMgr().cercaModulo(app, tipoDocumento);
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 1.2 STEP  allegatoDto.getFkTipoDocumento(): "+allegatoDto.getFkTipoDocumento());
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 1.3 STEP  modulo: "+modulo);
			//recupero l'oggetto che mi viene formattato dalla libreria di modol
			if(Constants.ALLEGATO_TIPO_1.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				
				
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument mod2Import = it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument.Factory.parse(impXml.getFileImport());
				log.debug("inviaAllegato - passo 1");
				mod1 = mapToModuloAllegato1(mod2Import, allegatoDto, dettaglioImpresaManutentrice);
				//mod2 è completo con i dati che si trovano sul db e i dati arrivati dall'xml dell'import massivo
				MapDto.mappaturaDatiAllegatoTipo1(mod1);
				log.debug("inviaAllegato - passo 2");
				xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(mod1));
				log.debug("inviaAllegato - passo 3");
				//trovo il codice REA
				String siglaRea = mod2Import.getMODII().getRichiesta().getDatiManutentore().getSiglaREA();
				String numeroRea = mod2Import.getMODII().getRichiesta().getDatiManutentore().getNumeroREA();
				codiceRea = siglaRea + "-" + numeroRea;				
				
			}else if(Constants.ALLEGATO_TIPO_2.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument mod2Import = it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument.Factory.parse(impXml.getFileImport());
				log.debug("inviaAllegato - passo 1");
				mod2 = mapToModuloAllegato2(mod2Import, allegatoDto, dettaglioImpresaManutentrice);
				//mod2 è completo con i dati che si trovano sul db e i dati arrivati dall'xml dell'import massivo
				log.debug("inviaAllegato - passo 2");
				MapDto.mappaturaDatiAllegatoTipo2(mod2);
				xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(mod2));
				log.debug("inviaAllegato - passo 3");
				//trovo il codice REA
				String siglaRea = mod2Import.getMODIII().getRichiesta().getDatiManutentore().getSiglaREA();
				String numeroRea = mod2Import.getMODIII().getRichiesta().getDatiManutentore().getNumeroREA();
				codiceRea = siglaRea + "-" + numeroRea;				
			}else if(Constants.ALLEGATO_TIPO_3.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument mod3Import = it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument.Factory.parse(impXml.getFileImport());
				log.debug("inviaAllegato - passo 1");
				mod3 = mapToModuloAllegato3(mod3Import, allegatoDto, dettaglioImpresaManutentrice);
				//mod3 è completo con i dati che si trovano sul db e i dati arrivati dall'xml dell'import massivo
				log.debug("inviaAllegato - passo 2");
				MapDto.mappaturaDatiAllegatoTipo3(mod3);
				xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(mod3));
				log.debug("inviaAllegato - passo 3");
				//trovo il codice REA
				String siglaRea = mod3Import.getMODIV().getRichiesta().getDatiManutentore().getSiglaREA();
				String numeroRea = mod3Import.getMODIV().getRichiesta().getDatiManutentore().getNumeroREA();
				codiceRea = siglaRea + "-" + numeroRea;
			}else if(Constants.ALLEGATO_TIPO_4.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument mod4Import = it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument.Factory.parse(impXml.getFileImport());
				log.debug("inviaAllegato - passo 1");
				mod4 = mapToModuloAllegato4(mod4Import, allegatoDto, dettaglioImpresaManutentrice);
				//mod4 è completo con i dati che si trovano sul db e i dati arrivati dall'xml dell'import massivo
				MapDto.mappaturaDatiAllegatoTipo4(mod4);
				log.debug("inviaAllegato - passo 2");
				xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(mod4));
				log.debug("inviaAllegato - passo 3");
				//trovo il codice REA
				String siglaRea = mod4Import.getMODV().getRichiesta().getDatiManutentore().getSiglaREA();
				String numeroRea = mod4Import.getMODV().getRichiesta().getDatiManutentore().getNumeroREA();
				codiceRea = siglaRea + "-" + numeroRea;
			}
			
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 6 STEP ");
			
			
			//quello che cambia e' xmlModel in base ai tipi di allegati che mi arrivano
			RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
			modulo = getServiziMgr().getModol().mergeModulo(app, null, modulo, xmlModel);
			
			//a questo punto recupero l'xml dal modulo aggiornato 
			thePdfAllegato = modulo.getDataContent();
			
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 7 STEP ");
			
			//mi preparo i dati da inviare ad index
			String nomeAllegato = getNomeAllegato(allegatoDto.getFkTipoDocumento(), 
					new BigDecimal(codImpianto), allegatoDto.getDataControllo(), allegatoDto.getIdAllegato());
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 8 STEP NOME ALLEGATO : "+nomeAllegato);
			Metadati metadati = MapDto.mapMetadatiAllegati(impiantoDto, allegatoDto, codiceRea);
			uid = getServiziMgr().indexUploadFile(nomeAllegato, thePdfAllegato, metadati);
			
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 9 STEP UID: "+uid);
	
			//setto i valori per fare l'update sul db per sigit_t_allegato
			allegatoDto.setDataInvio(DateUtil.getSqlCurrentDate());
			allegatoDto.setNomeAllegato(nomeAllegato);
			allegatoDto.setFkStatoRapp(new BigDecimal(Constants.ID_STATO_RAPPORTO_INVIATO));
			if(uid!=null)
			{
				allegatoDto.setUidIndex(uid);
			}
			
			//aggiorno pure il pdf appena spedito ad index
			
			//verificare che non lo si debba fare
			//allegatoDto.setXmlAllegato(thePdf); 
			
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 10 STEP  ");
			
			//chiamo l'aggiornamento per la tabella sigit_t_allegato
			getDbMgr().getSigitTAllegatoDao().update(allegatoDto);
			
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 11 STEP  ");
			
			//ADESSO eseguo il metodo per il salvataggio dei dati sul db che ho appena spediti ad index
			if(Constants.ALLEGATO_TIPO_1.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				salvaInfoDaXmlAllegato1(mod1, allegatoDto, impiantoDto, Constants.UTENTE_BATCH, codiceRea);
			}else if(Constants.ALLEGATO_TIPO_2.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				salvaInfoDaXmlAllegato2(mod2, allegatoDto, impiantoDto, Constants.UTENTE_BATCH, codiceRea);
			}else if(Constants.ALLEGATO_TIPO_3.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				salvaInfoDaXmlAllegato3(mod3, allegatoDto, impiantoDto, Constants.UTENTE_BATCH, codiceRea);
			}else if(Constants.ALLEGATO_TIPO_4.equalsIgnoreCase(allegatoDto.getFkTipoDocumento().toString())){
				salvaInfoDaXmlAllegato4(mod4, allegatoDto, impiantoDto, Constants.UTENTE_BATCH, codiceRea);
			}
			log.debug("FRAAAAAAAAAAAAAAAAAAAA 12 STEP  ");
		} 
		
		catch (SigitTAllegatoDaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} 
		catch (ServiceException e) {
			throw new ManagerException(e, new Message(Messages.ERRORE_NON_PREVISTO_BATCH));
		} catch (IOException e) {
			throw new ManagerException(e, new Message(Messages.ERRORE_NON_PREVISTO_BATCH));
		} catch (SystemException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} catch (UserException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		} 
		catch (XmlException e) {
			throw new ManagerException(e, new Message(Messages.ERRORE_NON_PREVISTO_BATCH));
		}
		catch (ManagerException e) {
			throw e;
		} catch (SigitTTrattH2ODaoException e) {
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[SigitMgr::inviaAllegato] END");
		return thePdfAllegato;
	}
	*/
	public void salvaInfoDaXmlAllegato1(MODIIDocument modAllegatoTipo1, 
			SigitTAllegatoDto allegato, SigitTImpiantoDto impianto, String cfUtenteLoggato, String codiceRea)throws ManagerException {
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] BEGIN");
		
		//aggiorniamo di nuovo la tabella SIGIT_T_ALLEGATO con gli altri elementi aggiuntivi sia dell'xml che le informazioni dell'utente
		it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta richiesta = modAllegatoTipo1.getMODII().getRichiesta();

		//sezione B.documentazione tecnica a corredo
		List<RowAllegatoII> allegatoIIList = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
		boolean flagControllo = false;
		try{
			for(RowAllegatoII allegatoII : allegatoIIList){
			
				//RowAllegatoII allegatoII = allegatoIIList.get(0);
				DocumentazioneTecnica documentazioneTecnica = allegatoII.getDocumentazioneTecnica();
				it.csi.sigit.sigitwebn.xml.allegato2.data.TrattamentoAcquaDocument.TrattamentoAcqua trattamentoAcqua = allegatoII.getTrattamentoAcqua();
				it.csi.sigit.sigitwebn.xml.allegato2.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = allegatoII.getDatiIdentificativi();
			
					
					if(documentazioneTecnica.getABFlagDichiarazConfNO()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.NO_0));
					}
					if(documentazioneTecnica.getABFlagDichiarazConfSI()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.SI_1));
					}
					if(documentazioneTecnica.getABFlagLibrettoCompNO()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.NO_0));
					}
					if(documentazioneTecnica.getABFlagLibrettoCompSI()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.SI_1));
					}
					if(documentazioneTecnica.getABFlagLibrettoImpNO()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.NO_0));
					}
					if(documentazioneTecnica.getABFlagLibrettoImpSI()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.SI_1));
					}
					if(documentazioneTecnica.getABFlagManutGenNO()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.NO_0));
					}
					if(documentazioneTecnica.getABFlagManutGenSI()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.SI_1));
					}
					
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> A. Dati identificativi ");
					try{
						if(GenericUtil.isNotNullOrEmpty(datiIdentificativi.getAAPotenzaTermicaNomTotMax())){
							allegato.setAPotenzaTermicaNominaleMax(datiIdentificativi.getAAPotenzaTermicaNomTotMax());
						}
					}catch (Exception e) {}
					
					
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> B. documentazione tecnica a corredo");
					
					//sezione F.check list
					CheckList checkList = allegatoII.getCheckList();
					log.debug("[F ]check list --> checkList.getAFOsservazioni(): "+checkList.getAFOsservazioni());
					if(GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni())){
						allegato.setFOsservazioni(checkList.getAFOsservazioni());
					}
					log.debug("[F ]check list --> checkList.getAFRaccomandazioni(): "+checkList.getAFRaccomandazioni());
					if(GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni())){
						allegato.setFRaccomandazioni(checkList.getAFRaccomandazioni());
					}
					log.debug("[F ]check list --> checkList.getAFPrescrizioni(): "+checkList.getAFPrescrizioni());
					if(GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni())){
						allegato.setFPrescrizioni(checkList.getAFPrescrizioni());
					}
					
					DatiTecnico datiTecnico = allegatoII.getDatiTecnico();
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpNO(): "+datiTecnico.getAFFlagFunzImpNO());
					if(datiTecnico.getAFFlagFunzImpNO()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpSI(): "+datiTecnico.getAFFlagFunzImpSI());
					if(datiTecnico.getAFFlagFunzImpSI()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.SI_1));
					}
					
					try{allegato.setFInterventoEntro(DateUtil.getSqlDate(datiTecnico.getAFDataIntervento()));}catch (Exception e) {}
					
					log.debug("[F ]check list --> datiTecnico.getAFOrarioArrivo(): "+datiTecnico.getAFOrarioArrivo());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioArrivo())){
						allegato.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
					}
					log.debug("[F ]check list --> datiTecnico.getAFOrarioPartenza(): "+datiTecnico.getAFOrarioPartenza());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioPartenza())){
						allegato.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
					}
					log.debug("[F ]check listcheck list --> datiTecnico.getAFNomeTecnico(): "+datiTecnico.getAFNomeTecnico());
					log.debug("[F ]check list --> datiTecnico.getAFCognomeTecnico(): "+datiTecnico.getAFCognomeTecnico());
					allegato.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));
					log.debug("[F ]check list --> datiTecnico.getAFFirmaTecnico(): "+datiTecnico.getAFFirmaTecnico());
					
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
						allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
						allegato.setFFirmaTecnico(datiTecnico.getAFFirmaTecnico());
					}else{
						allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
						allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
						allegato.setFFirmaResponsabile(datiTecnico.getAFFirmaResp());
					}else{
						allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
					}
					
					//Non so ancora cosa settare a livello di flg_controllo_bozza????
					allegato.setFlgControlloBozza(new BigDecimal(Constants.SI_1));
					allegato.setDataUltMod(DateUtil.getSqlDataCorrente());
					allegato.setUtenteUltMod(cfUtenteLoggato);
					
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> F.check list per  sigit_t_allegato");
					//aggiorno la tabella SIGIT_T_ALLEGATO
					if(!flagControllo){
						//faccio l'update altrimenti al secondo giro non mi riporta piu' i dati del primo e me li va a cancellare
						try {
							getDbMgr().getSigitTAllegatoDao().update(allegato);
						} catch (SigitTAllegatoDaoException e) {
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
							throw new ManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
						}
					}
					
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> update su  sigit_t_allegato");
					
					SigitTRappTipo1Dto rapportoTipo1 = new SigitTRappTipo1Dto();
					log.debug("[F ]check list --> checkList.getAFFlagValvole(): "+checkList.getAFFlagValvole());
					//attenzione parte legata a sigit_t_rapp_tipo1
					if(checkList.getAFFlagValvole()){
						rapportoTipo1.setFFlgAdozioneValvoleTerm(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setFFlgAdozioneValvoleTerm(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F ]check list --> checkList.getAFFlagIsolamento(): "+checkList.getAFFlagIsolamento());
					if(checkList.getAFFlagIsolamento()){
						rapportoTipo1.setFFlgIsolamenteRete(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setFFlgIsolamenteRete(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F ]check list --> checkList.getAFFlagSistTrattACS(): "+checkList.getAFFlagSistTrattACS());
					if(checkList.getAFFlagSistTrattACS()){
						rapportoTipo1.setFFlgAdozSistTrattamH2o(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setFFlgAdozSistTrattamH2o(new BigDecimal(Constants.NO_0));
					}
					log.debug("[F ]check list --> checkList.getAFFlagSistRegolaz(): "+checkList.getAFFlagSistRegolaz());
					if(checkList.getAFFlagSistRegolaz()){
						rapportoTipo1.setFFlgSostituzSistRegolaz(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setFFlgSostituzSistRegolaz(new BigDecimal(Constants.NO_0));
					}
					//Sezione C. trattamento dell'acqua
					if(trattamentoAcqua.getACFlagTrattH2ONR()){
						rapportoTipo1.setCFlgTrattClimaNonRich(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setCFlgTrattClimaNonRich(new BigDecimal(Constants.NO_0));
					}
					if(trattamentoAcqua.getACFlagTrattAcsNR()){
						rapportoTipo1.setCFlgTrattAcsNonRichiesto(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo1.setCFlgTrattAcsNonRichiesto(new BigDecimal(Constants.NO_0));
					}
					
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END -->  sezione F.check list legata a sigit_t_rapp_tipo1");
					
					//sezione D.controllo dell'impianto
					ControlloImpianto controlloImpianto = allegatoII.getControlloImpianto();
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagInternoSI(): "+controlloImpianto.getADFlagInternoSI());
					if(controlloImpianto.getADFlagInternoSI()){
						rapportoTipo1.setDFlgLocaleIntIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagInternoNO()){
						rapportoTipo1.setDFlgLocaleIntIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagInternoNC()){
						rapportoTipo1.setDFlgLocaleIntIdoneo(new BigDecimal(Constants.NC_2));
					}
					
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagEsternoSI(): "+controlloImpianto.getADFlagEsternoSI());
					if(controlloImpianto.getADFlagEsternoSI()){
						rapportoTipo1.setDFlgGenExtIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagEsternoNO()){
						rapportoTipo1.setDFlgGenExtIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagEsternoNC()){
						rapportoTipo1.setDFlgGenExtIdoneo(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagApertureSI(): "+controlloImpianto.getADFlagApertureSI());
					if(controlloImpianto.getADFlagApertureSI()){
						rapportoTipo1.setDFlgApertureLibere(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagApertureNO()){
						rapportoTipo1.setDFlgApertureLibere(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagApertureNC()){
						rapportoTipo1.setDFlgApertureLibere(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagDimensioniSI(): "+controlloImpianto.getADFlagDimensioniSI());
					if(controlloImpianto.getADFlagDimensioniSI()){
						rapportoTipo1.setDFlgApertureAdeg(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagDimensioniNO()){
						rapportoTipo1.setDFlgApertureAdeg(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagDimensioniNC()){
						rapportoTipo1.setDFlgApertureAdeg(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagCanaleFumoSI(): "+controlloImpianto.getADFlagCanaleFumoSI());
					if(controlloImpianto.getADFlagCanaleFumoSI()){
						rapportoTipo1.setDFlgScaricoIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagCanaleFumoNO()){
						rapportoTipo1.setDFlgScaricoIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagCanaleFumoNC()){
						rapportoTipo1.setDFlgScaricoIdoneo(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagSistRegolazSI(): "+controlloImpianto.getADFlagSistRegolazSI());
					if(controlloImpianto.getADFlagSistRegolazSI()){
						rapportoTipo1.setDFlgTempAmbFunz(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagSistRegolazNO()){
						rapportoTipo1.setDFlgTempAmbFunz(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagSistRegolazNC()){
						rapportoTipo1.setDFlgTempAmbFunz(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagPerditeSI(): "+controlloImpianto.getADFlagPerditeSI());
					if(controlloImpianto.getADFlagPerditeSI()){
						rapportoTipo1.setDFlgAssenzaPerdComb(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagPerditeNO()){
						rapportoTipo1.setDFlgAssenzaPerdComb(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagPerditeNC()){
						rapportoTipo1.setDFlgAssenzaPerdComb(new BigDecimal(Constants.NC_2));
					}
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagTenutaSI(): "+controlloImpianto.getADFlagTenutaSI());
					if(controlloImpianto.getADFlagTenutaSI()){
						rapportoTipo1.setDFlgIdoTenImpInt(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagTenutaNO()){
						rapportoTipo1.setDFlgIdoTenImpInt(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagTenutaNC()){
						rapportoTipo1.setDFlgIdoTenImpInt(new BigDecimal(Constants.NC_2));
					}
					
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END -->  sezione D.controllo dell'impianto legata a sigit_t_rapp_tipo1");
					
					//INSERISCO nella tabella SIGIT_RAPP_TIPO1
					rapportoTipo1.setIdAllegato(allegato.getIdAllegato());
					
					SigitTRappTipo1Pk pk = new SigitTRappTipo1Pk();
					pk.setIdAllegato(allegato.getIdAllegato());
					//devo controllare se ho un record presente sulla tabella o no
					SigitTRappTipo1Dto dettaglioRappTipo1 = getDbMgr().getSigitTRappTipo1Dao().findByPrimaryKey(pk);
					if(dettaglioRappTipo1!=null){
						log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] TROVATO RECORD SU sigit_t_rapp_tipo1");
						//non posso fare l'update perche' nelle pagine successive non mi riporta tutti i dati
						//getDbMgr().getSigitTRappTipo1Dao().update(rapportoTipo1);
					}
					else{
						getDbMgr().getSigitTRappTipo1Dao().insert(rapportoTipo1);
						log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> INSERT SU sigit_t_rapp_tipo1");
					}
						
				
					//sezione E.controllo e verifica energetica  del gruppo termico
					ControlloVerificaEnergetica controlloVerificaEnergetica = allegatoII.getControlloVerificaEnergetica();
					SigitTDettTipo1Dto sigitTDettTipo1Dto = new SigitTDettTipo1Dto();
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagClimatizInv(): "+controlloVerificaEnergetica.getAEFlagClimatizInv());
					if(controlloVerificaEnergetica.getAEFlagClimatizInv()){
						sigitTDettTipo1Dto.setEFlgClimaInverno(new BigDecimal(Constants.SI_1));
					}else{
						sigitTDettTipo1Dto.setEFlgClimaInverno(new BigDecimal(Constants.NO_0));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagProduzACS(): "+controlloVerificaEnergetica.getAEFlagProduzACS());
					if(controlloVerificaEnergetica.getAEFlagProduzACS()){
						sigitTDettTipo1Dto.setEFlgProduzAcs(new BigDecimal(Constants.SI_1));
					}else{
						sigitTDettTipo1Dto.setEFlgProduzAcs(new BigDecimal(Constants.NO_0));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagDispComandoSI(): "+controlloVerificaEnergetica.getAEFlagDispComandoSI());
					if(controlloVerificaEnergetica.getAEFlagDispComandoSI()){
						sigitTDettTipo1Dto.setEFlgDisposComando(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagDispComandoNO()){
						sigitTDettTipo1Dto.setEFlgDisposComando(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagDispComandoNC()){
						sigitTDettTipo1Dto.setEFlgDisposComando(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagDispSicuSI(): "+controlloVerificaEnergetica.getAEFlagDispSicuSI());
					if(controlloVerificaEnergetica.getAEFlagDispSicuSI()){
						sigitTDettTipo1Dto.setEFlgDisposSicurezza(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagDispSicuNO()){
						sigitTDettTipo1Dto.setEFlgDisposSicurezza(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagDispSicuNC()){
						sigitTDettTipo1Dto.setEFlgDisposSicurezza(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagValvSicuSI(): "+controlloVerificaEnergetica.getAEFlagValvSicuSI());
					if(controlloVerificaEnergetica.getAEFlagValvSicuSI()){
						sigitTDettTipo1Dto.setEFlgValvolaSicurezza(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagValvSicuNO()){
						sigitTDettTipo1Dto.setEFlgValvolaSicurezza(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagValvSicuNC()){
						sigitTDettTipo1Dto.setEFlgValvolaSicurezza(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagScambiatoreSI(): "+controlloVerificaEnergetica.getAEFlagScambiatoreSI());
					if(controlloVerificaEnergetica.getAEFlagScambiatoreSI()){
						sigitTDettTipo1Dto.setEFlgScambiatoreFumi(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagScambiatoreNO()){
						sigitTDettTipo1Dto.setEFlgScambiatoreFumi(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagScambiatoreNC()){
						sigitTDettTipo1Dto.setEFlgScambiatoreFumi(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagRiflussoSI(): "+controlloVerificaEnergetica.getAEFlagRiflussoSI());
					if(controlloVerificaEnergetica.getAEFlagRiflussoSI()){
						sigitTDettTipo1Dto.setEFlgRiflusso(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagRiflussoNO()){
						sigitTDettTipo1Dto.setEFlgRiflusso(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagRiflussoNC()){
						sigitTDettTipo1Dto.setEFlgRiflusso(new BigDecimal(Constants.NC_2));
					}
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagRisultatiSI(): "+controlloVerificaEnergetica.getAEFlagRisultatiSI());
					if(controlloVerificaEnergetica.getAEFlagRisultatiSI()){
						sigitTDettTipo1Dto.setEFlgUni103891(new BigDecimal(Constants.SI_1));
					}else if(controlloVerificaEnergetica.getAEFlagRisultatiNO()){
						sigitTDettTipo1Dto.setEFlgUni103891(new BigDecimal(Constants.NO_0));
					}else if(controlloVerificaEnergetica.getAEFlagRisultatiNC()){
						sigitTDettTipo1Dto.setEFlgUni103891(new BigDecimal(Constants.NC_2));
					}
					
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEPotenzaFocolare() ********************************************** ");
					
					try{sigitTDettTipo1Dto.setEPotTermFocolKw(ConvertUtil.convertToBigDecimal(controlloVerificaEnergetica.getAEPotenzaFocolare()));}catch (Exception e) {}
					
					if(controlloVerificaEnergetica.getAEFlagEvacFumiFORZ()){
						sigitTDettTipo1Dto.setEFlgEvacuFumi(Constants.FLAG_EVACUAZIONE_FUMI_FORZATA);
					}
					if(controlloVerificaEnergetica.getAEFlagEvacFumiNATU()){
						sigitTDettTipo1Dto.setEFlgEvacuFumi(Constants.FLAG_EVACUAZIONE_FUMI_NATURALE);
					}
					
					try{sigitTDettTipo1Dto.setL111AltroRiferimento(controlloVerificaEnergetica.getAEAltroRifNormativo());}catch (Exception e) {}
					
					log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEDepressCanaleFumo(): ++++++++++++++++++++++++++++++++++++++++++++ ");
					
					try{sigitTDettTipo1Dto.setEDeprCanaleFumoPa(ConvertUtil.convertToBigDecimal(controlloVerificaEnergetica.getAEDepressCanaleFumo()));}catch (Exception e) {}
					
					sigitTDettTipo1Dto.setCodiceImpianto(impianto.getCodiceImpianto());
					sigitTDettTipo1Dto.setFkAllegato(allegato.getIdAllegato());
					sigitTDettTipo1Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
					sigitTDettTipo1Dto.setUtenteUltMod(cfUtenteLoggato);
					sigitTDettTipo1Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_GT);
					
					try{sigitTDettTipo1Dto.setProgressivo(ConvertUtil.convertToBigDecimal(allegatoII.getAENumGT()));}catch (Exception e) {}
					
					try{sigitTDettTipo1Dto.setDataInstall(DateUtil.getSqlDate(allegatoII.getAEDataInstallaz()));}catch (Exception e) {}
					
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> sezione E.controllo e verifica energetica  del gruppo termico sigit_t_DETT_tipo1");
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] BEGIN --> sezione E.controllo e verifica energetica tab fumi del gruppo termico sigit_t_DETT_tipo1");
					TabFumi tabFumi = allegatoII.getTabFumi();
					List<RowFumi> rigaFumi = tabFumi.getRowFumiList();
					if(rigaFumi!=null && rigaFumi.size()>0){
						log.debug("FRAAAAAAAAAAAAAAA ---> rowfumi lunghezza lista da inserire : "+rigaFumi.size());
						int count = 0;
						 for(RowFumi dto : rigaFumi){
							 log.debug("FRAAAAAAAAAAAAAAA ---> rowfumi count : "+count);
							
							 try {sigitTDettTipo1Dto.setETempFumiC(dto.getAETempFumi());}catch (Exception e) {sigitTDettTipo1Dto.setETempFumiC(null);}
							 try {sigitTDettTipo1Dto.setETempAriaC(dto.getAETempAria());}catch (Exception e) {sigitTDettTipo1Dto.setETempAriaC(null);}
							 try {sigitTDettTipo1Dto.setEO2Perc(dto.getAEO2());}catch (Exception e) {sigitTDettTipo1Dto.setEO2Perc(null);}
							 try {sigitTDettTipo1Dto.setECo2Perc(dto.getAECO2());}catch (Exception e) {sigitTDettTipo1Dto.setECo2Perc(null);}

							 try{sigitTDettTipo1Dto.setEBacharachMin(ConvertUtil.convertToBigDecimal(dto.getAEBacharach1()));}catch (Exception e) {sigitTDettTipo1Dto.setEBacharachMin(null);}
							 try{sigitTDettTipo1Dto.setEBacharachMed(ConvertUtil.convertToBigDecimal(dto.getAEBacharach2()));}catch (Exception e) {sigitTDettTipo1Dto.setEBacharachMed(null);}
							 try{ sigitTDettTipo1Dto.setEBacharachMax(ConvertUtil.convertToBigDecimal(dto.getAEBacharach3()));}catch (Exception e) {sigitTDettTipo1Dto.setEBacharachMax(null);}

							 try {sigitTDettTipo1Dto.setECoCorrettoPpm(dto.getAECOcorretto());}catch (Exception e) {sigitTDettTipo1Dto.setECoCorrettoPpm(null);}

							 if (GenericUtil.isNotNullOrEmpty(sigitTDettTipo1Dto.getECoCorrettoPpm()) && sigitTDettTipo1Dto.getECoCorrettoPpm().doubleValue() <= new BigDecimal(1000).doubleValue())
							 {
								 sigitTDettTipo1Dto.setL111FlgCoMin1000(new BigDecimal(Constants.SI_1));
							 }
							 else
							 {
								 sigitTDettTipo1Dto.setL111FlgCoMin1000(new BigDecimal(Constants.NO_0));
							 }
							 
							 try {sigitTDettTipo1Dto.setERendCombPerc(dto.getAERendimCombu());}catch (Exception e) {sigitTDettTipo1Dto.setERendCombPerc(null);}
							 try {sigitTDettTipo1Dto.setERendMinLeggePerc(dto.getAERendimentoLegge());}catch (Exception e) {sigitTDettTipo1Dto.setERendMinLeggePerc(null);}
							 try {sigitTDettTipo1Dto.setENoxPpm(dto.getAENox());}catch (Exception e) {sigitTDettTipo1Dto.setENoxPpm(null);}
							 try{ sigitTDettTipo1Dto.setENModuloTermico(ConvertUtil.convertToInteger(dto.getAEModuloTermico()));}catch (Exception e) {sigitTDettTipo1Dto.setENModuloTermico(null);}

							 try{ sigitTDettTipo1Dto.setL111PortataCombustibileUm(dto.getAEPortataCombu());}catch (Exception e) {sigitTDettTipo1Dto.setL111PortataCombustibileUm(null);}
							 try{ sigitTDettTipo1Dto.setL111PortataCombustibile(ConvertUtil.convertToBigDecimal(dto.getAEValorePortata()));}catch (Exception e) {sigitTDettTipo1Dto.setL111PortataCombustibile(null);}
							 try{ sigitTDettTipo1Dto.setL111CoNoAriaPpm(ConvertUtil.convertToBigDecimal(dto.getAECOfumiSecchi()));}catch (Exception e) {sigitTDettTipo1Dto.setL111CoNoAriaPpm(null);}
							
							 log.debug("STAMPO getAERispettoIndBacharach: "+dto.getAERispettoIndBacharach());
								
							 
							 try{ 
								 if(Constants.SI.equalsIgnoreCase(dto.getAERispettoIndBacharach())){
									 sigitTDettTipo1Dto.setL111FlgRispettaBacharach(new BigDecimal(Constants.SI_1));
								 }
								 if(Constants.NO.equalsIgnoreCase(dto.getAERispettoIndBacharach())){
									 sigitTDettTipo1Dto.setL111FlgRispettaBacharach(new BigDecimal(Constants.NO_0));
								 }
							 }catch (Exception e) {

								 log.error(e);
								 sigitTDettTipo1Dto.setL111FlgRispettaBacharach(null);
							 }

							 log.debug("STAMPO getAEMinimo: "+dto.getAEMinimo());
							 
							 
							 try{ 
								 if(Constants.SI.equalsIgnoreCase(dto.getAEMinimo())){
									 sigitTDettTipo1Dto.setL111FlgRendMagRendMin(new BigDecimal(Constants.SI_1));
								 }

								 if(Constants.NO.equalsIgnoreCase(dto.getAEMinimo())){
									 sigitTDettTipo1Dto.setL111FlgRendMagRendMin(new BigDecimal(Constants.NO_0));
								 }
							 }catch (Exception e) {
								 log.error(e);
								 sigitTDettTipo1Dto.setL111FlgRendMagRendMin(null);

							 }
							 /*
							 try {sigitTDettTipo1Dto.setETempFumiC(dto.getAETempFumi());}catch (Exception e) {}
							 try {sigitTDettTipo1Dto.setETempAriaC(dto.getAETempAria());}catch (Exception e) {}
							 try {sigitTDettTipo1Dto.setEO2Perc(dto.getAEO2());}catch (Exception e) {}
							 try {sigitTDettTipo1Dto.setECo2Perc(dto.getAECO2());}catch (Exception e) {}
								 
							 try{sigitTDettTipo1Dto.setEBacharachMin(ConvertUtil.convertToString(dto.getAEBacharach1()));}catch (Exception e) {}
							 try{sigitTDettTipo1Dto.setEBacharachMed(ConvertUtil.convertToString(dto.getAEBacharach2()));}catch (Exception e) {}
							 try{ sigitTDettTipo1Dto.setEBacharachMax(ConvertUtil.convertToString(dto.getAEBacharach3()));}catch (Exception e) {}
							
							 try {sigitTDettTipo1Dto.setECoCorrettoPpm(dto.getAECOcorretto());}catch (Exception e) {}
							 try {sigitTDettTipo1Dto.setERendCombPerc(dto.getAERendimCombu());}catch (Exception e) {}
							 try {sigitTDettTipo1Dto.setERendMinLeggePerc(dto.getAERendimentoLegge());}catch (Exception e) {}
							 try {sigitTDettTipo1Dto.setENoxPpm(dto.getAENox());}catch (Exception e) {}
							 try{ sigitTDettTipo1Dto.setENModuloTermico(ConvertUtil.convertToString(dto.getAEModuloTermico()));}catch (Exception e) {}
							 
							 try{ sigitTDettTipo1Dto.setL111PortataCombustibileUm(dto.getAEPortataCombu());}catch (Exception e) {}
							 try{ sigitTDettTipo1Dto.setL111PortataCombustibile(ConvertUtil.convertToBigDecimal(dto.getAEValorePortata()));}catch (Exception e) {}
							 try{ sigitTDettTipo1Dto.setL111CoNoAriaPpm(ConvertUtil.convertToBigDecimal(dto.getAECOfumiSecchi()));}catch (Exception e) {}
							 try{ 
									 if(Constants.RENDIMENTO_MINIMO_SI.equalsIgnoreCase(dto.getAERispettoIndBacharach())){
										 sigitTDettTipo1Dto.setL111FlgRispettaBacharach(new BigDecimal(Constants.SI_1));
									 }
									 if(Constants.RENDIMENTO_MINIMO_NO.equalsIgnoreCase(dto.getAERispettoIndBacharach())){
										 sigitTDettTipo1Dto.setL111FlgRispettaBacharach(new BigDecimal(Constants.NO_0));
									 }
								 }catch (Exception e) {}
							 
							 	try{ 
									 if(Constants.RENDIMENTO_MINIMO_SI.equalsIgnoreCase(dto.getAEMinimo())){
										 sigitTDettTipo1Dto.setL111FlgRendMagRendMin(new BigDecimal(Constants.SI_1));
									 }
									 
									 if(Constants.RENDIMENTO_MINIMO_NO.equalsIgnoreCase(dto.getAEMinimo())){
										 sigitTDettTipo1Dto.setL111FlgRendMagRendMin(new BigDecimal(Constants.NO_0));
									 }
							     }catch (Exception e) {}
							*/
							 
							 //INSERISCO
							 getDbMgr().getSigitTDettTipo1Dao().insert(sigitTDettTipo1Dto);
							 count++;
						     
						 }
					}
					//traccio il primo giro del for con tutti i dati del pdf
					flagControllo = true;
				}
			
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> INSERT SU sigit_t_DETT_tipo1");
				//adesso devo aggiornare la parte di libretto che e' dedicata esclusivamente all'allegato
				//mi trovo l'ultimo libretto aggiornato e creo una copia di questo sulla tabella
				//dopodiche' mi vado a richiamare il metodo che scrive il libretto e lo consolida
				
				SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
				//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
				recordLibretto.setCfRedattore(cfUtenteLoggato);
				recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
				recordLibretto.setUtenteUltMod(cfUtenteLoggato);
				recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
				//inserisco
				getDbMgr().inserisciLibretto(recordLibretto);
				
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> INSERT SU sigit_t_libretto");
				//adesso eseguo i punti 4, 5, 6 dell'algoritmo A002_7 riferito al libretto
//				creaPdfEConsolidaLibretto(cfUtenteLoggato, impianto, codiceRea, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO);
			
		}catch(Exception e){
			log.error("[SigitMgr::salvaInfoDaXmlAllegato1] END ", e);
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));

		}
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END");
	}
	
	public void salvaInfoDaXmlAllegato2(MODIIIDocument modAllegatoTipo2, 
			SigitTAllegatoDto allegato, SigitTImpiantoDto impianto, String cfUtenteLoggato, String codiceRea)throws ManagerException {
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] BEGIN");
		
		//aggiorniamo di nuovo la tabella SIGIT_T_ALLEGATO con gli altri elementi aggiuntivi sia dell'xml che le informazioni dell'utente
		it.csi.sigit.sigitwebn.xml.allegato3.data.RichiestaDocument.Richiesta richiesta = modAllegatoTipo2.getMODIII().getRichiesta();
		
		//sezione B.documentazione tecnica a corredo
		List<it.csi.sigit.sigitwebn.xml.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII> allegatoIIIList = richiesta.getDatiAllegato().getAllegatoIII().getRowAllegatoIIIList();
		boolean flagControllo = false;
		try{
			log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] lubghezza rowAllegatiIII --> "+allegatoIIIList.size());
			for(it.csi.sigit.sigitwebn.xml.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII allegatoIII: allegatoIIIList){
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] entro nel for RowAllegatoIII");
				//RowAllegatoIII allegatoIII = allegatoIIIList.get(0);
				it.csi.sigit.sigitwebn.xml.allegato3.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = allegatoIII.getDocumentazioneTecnica();
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 1");
				it.csi.sigit.sigitwebn.xml.allegato3.data.TrattamentoAcquaDocument.TrattamentoAcqua trattamentoAcqua =  allegatoIII.getTrattamentoAcqua();
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 2");
				it.csi.sigit.sigitwebn.xml.allegato3.data.DatiIdentificativiDocument.DatiIdentificativi datiIdentificativi = allegatoIII.getDatiIdentificativi();
				
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 3");
				try{
					if(documentazioneTecnica.getABFlagDichiarazConfNO()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 4");
				try{
					if(documentazioneTecnica.getABFlagDichiarazConfSI()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 5");
				try{
					if(documentazioneTecnica.getABFlagLibrettoCompNO()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 6");
				try{
					if(documentazioneTecnica.getABFlagLibrettoCompSI()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 7");
				try{
					if(documentazioneTecnica.getABFlagLibrettoImpNO()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 8");
				try{
					if(documentazioneTecnica.getABFlagLibrettoImpSI()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 9");
				try{
					if(documentazioneTecnica.getABFlagManutGenNO()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] passo 10");
				try{
					if(documentazioneTecnica.getABFlagManutGenSI()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> A. Dati identificativi ");
				try{
					if(GenericUtil.isNotNullOrEmpty(datiIdentificativi.getAAPotenzaTermicaNomTotMax())){
						allegato.setAPotenzaTermicaNominaleMax(datiIdentificativi.getAAPotenzaTermicaNomTotMax());
					}
				}catch (Exception e) {}
				
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> B. documentazione tecnica a corredo");
			
				//sezione F.check list
				it.csi.sigit.sigitwebn.xml.allegato3.data.CheckListDocument.CheckList checkList = allegatoIII.getCheckList();
				log.debug("[F ]check list --> checkList.getAFOsservazioni(): "+checkList.getAFOsservazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni())){
					allegato.setFOsservazioni(checkList.getAFOsservazioni());
				}
				log.debug("[F]check list --> checkList.getAFRaccomandazioni(): "+checkList.getAFRaccomandazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni())){
					allegato.setFRaccomandazioni(checkList.getAFRaccomandazioni());
				}
				log.debug("[F ]check list --> checkList.getAFPrescrizioni(): "+checkList.getAFPrescrizioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni())){
					allegato.setFPrescrizioni(checkList.getAFPrescrizioni());
				}
				
				it.csi.sigit.sigitwebn.xml.allegato3.data.DatiTecnicoDocument.DatiTecnico datiTecnico = allegatoIII.getDatiTecnico();
				
				try{
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpNO(): "+datiTecnico.getAFFlagFunzImpNO());
					if(datiTecnico.getAFFlagFunzImpNO()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				
				try{
					log.debug("[F]check list --> datiTecnico.getAFFlagFunzImpSI(): "+datiTecnico.getAFFlagFunzImpSI());
					if(datiTecnico.getAFFlagFunzImpSI()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				
				try{allegato.setFInterventoEntro(DateUtil.getSqlDate(datiTecnico.getAFDataIntervento()));}catch (Exception e) {}
		
				
				try{
					log.debug("[F ]check list --> datiTecnico.getAFOrarioArrivo(): "+datiTecnico.getAFOrarioArrivo());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioArrivo())){
						allegato.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
					}
				}catch (Exception e) {}
				
				try{
					log.debug("[F]check list --> datiTecnico.getAFOrarioPartenza(): "+datiTecnico.getAFOrarioPartenza());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioPartenza())){
						allegato.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
					}
				}catch (Exception e) {}
				log.debug("[F ]check list --> datiTecnico.getAFNomeTecnico(): "+datiTecnico.getAFNomeTecnico());
				log.debug("[F]check list --> datiTecnico.getAFCognomeTecnico(): "+datiTecnico.getAFCognomeTecnico());
				allegato.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));
				
				try{
					log.debug("[F]check list --> datiTecnico.getAFFirmaTecnico(): "+datiTecnico.getAFFirmaTecnico());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
						allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
						allegato.setFFirmaTecnico(datiTecnico.getAFFirmaTecnico());
					}else{
						allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				
				
				try{
					log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
					if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
						allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
						allegato.setFFirmaResponsabile(datiTecnico.getAFFirmaResp());
					}else{
						allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				//Non so ancora cosa settare a livello di flg_controllo_bozza????
				allegato.setFlgControlloBozza(new BigDecimal(Constants.SI_1));
				allegato.setDataUltMod(DateUtil.getSqlDataCorrente());
				allegato.setUtenteUltMod(cfUtenteLoggato);
				
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> F.check list per  sigit_t_allegato");
				//aggiorno la tabella SIGIT_T_ALLEGATO
				if(!flagControllo){
					//solo al primo giro mi fai l'update perche' le ulteriori pagine non sono valorizzate per la sezione relativa allallegato
					try {
						getDbMgr().getSigitTAllegatoDao().update(allegato);
					} catch (SigitTAllegatoDaoException e) {
						throw new ManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
					}
				}
				
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> update su  sigit_t_allegato");
				
				SigitTRappTipo2Dto rapportoTipo2 = new SigitTRappTipo2Dto();
				
				//attenzione parte legata a sigit_t_rapp_tipo1
				try {
					log.debug("[F ]check list --> checkList.getAFFlagIsolamentoCanali(): "+checkList.getAFFlagIsolamentoCanali());
					if(checkList.getAFFlagIsolamentoCanali()){
						rapportoTipo2.setFFlgIsolDistribuzH2o(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo2.setFFlgIsolDistribuzH2o(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				
				
				try {
					log.debug("[F ]check list --> checkList.getAFFlagIsolamentoRete(): "+checkList.getAFFlagIsolamentoRete());
					if(checkList.getAFFlagIsolamentoRete()){
						rapportoTipo2.setFFlgIsolDistribuzAria(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo2.setFFlgIsolDistribuzAria(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				
				
				try {
					log.debug("[F ]check list --> checkList.getAFFlagSostGen1(): "+checkList.getAFFlagSostGen1());
					if(checkList.getAFFlagSostGen1()){
						rapportoTipo2.setFFlgSostituzGeneratori(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo2.setFFlgSostituzGeneratori(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				
				
				try {
					log.debug("[F ]check list --> checkList.getAFFlagSostGen2(): "+checkList.getAFFlagSostGen2());
					if(checkList.getAFFlagSostGen2()){
						rapportoTipo2.setFFlgSostituzSistemiReg(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo2.setFFlgSostituzSistemiReg(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				//SEZIONE C.TRATTAMENTO ACQUA
				try {
					if(trattamentoAcqua.getACFlagTrattH2ONR()){
						rapportoTipo2.setCFlgTrattClimaNonRichiest(new BigDecimal(Constants.SI_1));
					}else{
						rapportoTipo2.setCFlgTrattClimaNonRichiest(new BigDecimal(Constants.NO_0));
					}
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END -->  sezione F.check list legata a sigit_t_rapp_tipo1");
				}catch (Exception e) {}
				
				
				//sezione D.controllo dell'impianto
				it.csi.sigit.sigitwebn.xml.allegato3.data.ControlloImpiantoDocument.ControlloImpianto controlloImpianto = allegatoIII.getControlloImpianto();
				
				try {
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLocaleIdoneoSI(): "+controlloImpianto.getADFlagLocaleIdoneoSI());
					if(controlloImpianto.getADFlagLocaleIdoneoSI()){
						rapportoTipo2.setDFlgLocaleIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagLocaleIdoneoNO()){
						rapportoTipo2.setDFlgLocaleIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagLocaleIdoneoNC()){
						rapportoTipo2.setDFlgLocaleIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {}
			
				try {
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagDimensioniSI(): "+controlloImpianto.getADFlagDimensioniSI());
					if(controlloImpianto.getADFlagDimensioniSI()){
						rapportoTipo2.setDFlgApertureAdeg(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagDimensioniNO()){
						rapportoTipo2.setDFlgApertureAdeg(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagDimensioniNC()){
						rapportoTipo2.setDFlgApertureAdeg(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {}
				
				
				try {
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagApertureSI(): "+controlloImpianto.getADFlagApertureSI());
					if(controlloImpianto.getADFlagApertureSI()){
						rapportoTipo2.setDFlgApertureLibere(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagApertureNO()){
						rapportoTipo2.setDFlgApertureLibere(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagApertureNC()){
						rapportoTipo2.setDFlgApertureLibere(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {}
				
				
				try {
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLineeIdoneeSI(): "+controlloImpianto.getADFlagLineeIdoneeSI());
					if(controlloImpianto.getADFlagLineeIdoneeSI()){
						rapportoTipo2.setDFlgLineaElettIdonea(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagLineeIdoneeNO()){
						rapportoTipo2.setDFlgLineaElettIdonea(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagLineeIdoneeNC()){
						rapportoTipo2.setDFlgLineaElettIdonea(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {}
				
				
				try {
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagCoibenIdoneeSI(): "+controlloImpianto.getADFlagCoibenIdoneeSI());
					if(controlloImpianto.getADFlagCoibenIdoneeSI()){
						rapportoTipo2.setDFlgCoibIdonea(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagCoibenIdoneeNO()){
						rapportoTipo2.setDFlgCoibIdonea(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagCoibenIdoneeNC()){
						rapportoTipo2.setDFlgCoibIdonea(new BigDecimal(Constants.NC_2));
					}
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END -->  sezione D.controllo dell'impianto legata a sigit_t_rapp_tipo2");
				}catch (Exception e) {}
				
				
				//INSERISCO nella tabella SIGIT_RAPP_TIPO2
				rapportoTipo2.setIdAllegato(allegato.getIdAllegato());
				//controllo che non ci sia alcun record con questo id
				SigitTRappTipo2Pk pk = new SigitTRappTipo2Pk();
				pk.setIdAllegato(allegato.getIdAllegato());
				SigitTRappTipo2Dto dettaglioRapportoTipo2 = getDbMgr().getSigitTRappTipo2Dao().findByPrimaryKey(pk);
				if(dettaglioRapportoTipo2!=null){
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> UPDATE SU sigit_t_rapp_tipo2");
					//NON FACCIO ALCUN UPDATE PERCHE' AL SECONDO GIRO L'OGGETTO ROWALLEGATOIII NON HA TUTTI I CAMPI VALORIZZATI
				}else{
					getDbMgr().getSigitTRappTipo2Dao().insert(rapportoTipo2);
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> INSERT SU sigit_t_rapp_tipo2");
				}
				
				//sezione E.controllo e verifica energetica  del gruppo termico
				it.csi.sigit.sigitwebn.xml.allegato3.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVerificaEnergetica = allegatoIII.getControlloVerificaEnergetica();
				SigitTDettTipo2Dto sigitTDettTipo2Dto = new SigitTDettTipo2Dto();
				
				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagPerditeSI(): "+controlloVerificaEnergetica.getAEFlagPerditeSI());
				if(controlloVerificaEnergetica.getAEFlagPerditeSI()){
					sigitTDettTipo2Dto.setEFlgPerditaGas(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagPerditeNO()){
					sigitTDettTipo2Dto.setEFlgPerditaGas(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagPerditeNC()){
					sigitTDettTipo2Dto.setEFlgPerditaGas(new BigDecimal(Constants.NC_2));
				}
				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagRilevFugheDirettaSI(): "+controlloVerificaEnergetica.getAEFlagRilevFugheDirettaSI());
				if(controlloVerificaEnergetica.getAEFlagRilevFugheDirettaSI()){
					sigitTDettTipo2Dto.setEFlgLeakDetector(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagRilevFugheDirettaNO()){
					sigitTDettTipo2Dto.setEFlgLeakDetector(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagRilevFugheDirettaNC()){
					sigitTDettTipo2Dto.setEFlgLeakDetector(new BigDecimal(Constants.NC_2));
				}
				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaSI(): "+controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaSI());
				if(controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaSI()){
					sigitTDettTipo2Dto.setEFlgParamTermodinam(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaNO()){
					sigitTDettTipo2Dto.setEFlgParamTermodinam(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagRilevFugheInDirettaNO()){
					sigitTDettTipo2Dto.setEFlgParamTermodinam(new BigDecimal(Constants.NC_2));
				}
				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagScambPulitiSI(): "+controlloVerificaEnergetica.getAEFlagScambPulitiSI());
				if(controlloVerificaEnergetica.getAEFlagScambPulitiSI()){
					sigitTDettTipo2Dto.setEFlgIncrostazioni(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagScambPulitiNO()){
					sigitTDettTipo2Dto.setEFlgIncrostazioni(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagScambPulitiNC()){
					sigitTDettTipo2Dto.setEFlgIncrostazioni(new BigDecimal(Constants.NC_2));
				}
				
				if(controlloVerificaEnergetica.getAEFlagRaffr()){
					sigitTDettTipo2Dto.setEFlgModProva(Constants.FLAG_MODALITA_RAFFRESCAMENTO);
				}
				if(controlloVerificaEnergetica.getAEFlagRisc()){
					sigitTDettTipo2Dto.setEFlgModProva(Constants.FLAG_MODALITA_RISCALDAMENTO);
				}
				
				sigitTDettTipo2Dto.setCodiceImpianto(impianto.getCodiceImpianto());
				sigitTDettTipo2Dto.setFkAllegato(allegato.getIdAllegato());
				sigitTDettTipo2Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
				sigitTDettTipo2Dto.setUtenteUltMod(cfUtenteLoggato);
				sigitTDettTipo2Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_GF);
				try{sigitTDettTipo2Dto.setProgressivo(ConvertUtil.convertToBigDecimal(allegatoIII.getAENumGF()));}catch (Exception e) {}
				try{sigitTDettTipo2Dto.setDataInstall(DateUtil.getSqlDate(allegatoIII.getAEDataInstallaz()));}catch (Exception e) {}
				
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> sezione E.controllo e verifica energetica  del gruppo termico sigit_t_DETT_tipo2");
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] BEGIN --> sezione E.controllo e verifica energetica tab fumi del gruppo termico sigit_t_DETT_tipo1");
				it.csi.sigit.sigitwebn.xml.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII.TabFumi	tabFumi = allegatoIII.getTabFumi();
				List<it.csi.sigit.sigitwebn.xml.allegato3.data.RowFumiDocument.RowFumi> rigaFumi = tabFumi.getRowFumiList();
				if(rigaFumi!=null && rigaFumi.size()>0){
					log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO III LUNGHEZZA LISTA: "+rigaFumi.size());
					int count = 0;
					 for(it.csi.sigit.sigitwebn.xml.allegato3.data.RowFumiDocument.RowFumi dto : rigaFumi){
						 
						 log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO III count: "+count);
						 try{ sigitTDettTipo2Dto.setETSurriscC(dto.getAESurrisc());}catch (Exception e) {sigitTDettTipo2Dto.setETSurriscC(null);}
						 try{ sigitTDettTipo2Dto.setETSottorafC(dto.getAESottoRaffr());}catch (Exception e) {sigitTDettTipo2Dto.setETSurriscC(null);}
						 try{ sigitTDettTipo2Dto.setETCondensazioneC(dto.getAECondens());}catch (Exception e) {sigitTDettTipo2Dto.setETCondensazioneC(null);}
						 try{ sigitTDettTipo2Dto.setETEvaporazioneC(dto.getAEEvaporaz());}catch (Exception e) {sigitTDettTipo2Dto.setETEvaporazioneC(null);}
						 try{ sigitTDettTipo2Dto.setETInExtC(dto.getAEIngLatoEst());}catch (Exception e) {sigitTDettTipo2Dto.setETInExtC(null);}
						 try{ sigitTDettTipo2Dto.setETOutExtC(dto.getAEUscLatoEst());}catch (Exception e) {sigitTDettTipo2Dto.setETOutExtC(null);}
						 try{ sigitTDettTipo2Dto.setETInUtenzeC(dto.getAEIngLatoUtenze());}catch (Exception e) {sigitTDettTipo2Dto.setETInUtenzeC(null);}
						 try{ sigitTDettTipo2Dto.setETOutUtenzeC(dto.getAEUscLatoUtenze());}catch (Exception e) {sigitTDettTipo2Dto.setETOutUtenzeC(null);}
						 try{ sigitTDettTipo2Dto.setENCircuito(ConvertUtil.convertToString(dto.getAENumCircuito()));}catch (Exception e) {sigitTDettTipo2Dto.setENCircuito(null);}
						 
						 try{ sigitTDettTipo2Dto.setL112TorreTOutFluido(ConvertUtil.convertToBigDecimal(dto.getAETuscFluido()));}catch (Exception e) {sigitTDettTipo2Dto.setL112TorreTOutFluido(null);}
						 try{ sigitTDettTipo2Dto.setL112TorreTBulboUmido(ConvertUtil.convertToBigDecimal(dto.getAETbulboUmido()));}catch (Exception e) {sigitTDettTipo2Dto.setL112TorreTBulboUmido(null);}
						 try{ sigitTDettTipo2Dto.setL112ScambiatoreTInExt(ConvertUtil.convertToBigDecimal(dto.getAETingFluidoSorg()));}catch (Exception e) {sigitTDettTipo2Dto.setL112ScambiatoreTInExt(null);}
						 try{ sigitTDettTipo2Dto.setL112ScambiatoreTOutExt(ConvertUtil.convertToBigDecimal(dto.getAETuscFluidoSorg()));}catch (Exception e) {sigitTDettTipo2Dto.setL112ScambiatoreTOutExt(null);}
						 try{ sigitTDettTipo2Dto.setL112ScambiatTInMacchina(ConvertUtil.convertToBigDecimal(dto.getAETingFluidoMacc()));}catch (Exception e) {sigitTDettTipo2Dto.setL112ScambiatTInMacchina(null);}
						 try{ sigitTDettTipo2Dto.setL112ScambiatTOutMacchina(ConvertUtil.convertToBigDecimal(dto.getAETuscFluidoMacc()));}catch (Exception e) {sigitTDettTipo2Dto.setL112ScambiatTOutMacchina(null);}
						 try{ sigitTDettTipo2Dto.setL112PotenzaAssorbitaKw(ConvertUtil.convertToBigDecimal(dto.getAEPotenzaAss()));}catch (Exception e) {sigitTDettTipo2Dto.setL112PotenzaAssorbitaKw(null);}
						 
						 try{
							if(Constants.FILTRI_PULITI_SI.equalsIgnoreCase(dto.getAEFiltriPuliti()))
								sigitTDettTipo2Dto.setL112FlgPuliziaFiltri(new BigDecimal(Constants.SI_1));
							if(Constants.FILTRI_PULITI_NO.equalsIgnoreCase(dto.getAEFiltriPuliti()))
								sigitTDettTipo2Dto.setL112FlgPuliziaFiltri(new BigDecimal(Constants.NO_0)); 
							 }catch (Exception e) {
								 sigitTDettTipo2Dto.setL112FlgPuliziaFiltri(null);
							 }
						 
						 try{
							 if(Constants.VERIFICA_SUPERATA_SI.equalsIgnoreCase(dto.getAEVerifica()))
								sigitTDettTipo2Dto.setL112FlgVerificaSuperata(new BigDecimal(Constants.SI_1));
							 if(Constants.VERIFICA_SUPERATA_NO.equalsIgnoreCase(dto.getAEVerifica()))
							    sigitTDettTipo2Dto.setL112FlgVerificaSuperata(new BigDecimal(Constants.NO_0)); 
							 }catch (Exception e) {
								 sigitTDettTipo2Dto.setL112FlgVerificaSuperata(null);
							 }
						 
						 try{sigitTDettTipo2Dto.setL112DataRipristino(DateUtil.getSqlDate(dto.getAEDataRipristino()));}catch (Exception e) {sigitTDettTipo2Dto.setL112DataRipristino(null);}

						 /*
						 log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO III count: "+count);
						 try{ sigitTDettTipo2Dto.setETSurriscC(dto.getAESurrisc());}catch (Exception e) {}
						 try{ sigitTDettTipo2Dto.setETSottorafC(dto.getAESottoRaffr());}catch (Exception e) {}
						 try{ sigitTDettTipo2Dto.setETCondensazioneC(dto.getAECondens());}catch (Exception e) {}
						 try{ sigitTDettTipo2Dto.setETEvaporazioneC(dto.getAEEvaporaz());}catch (Exception e) {}
						 try{ sigitTDettTipo2Dto.setETInExtC(dto.getAEIngLatoEst());}catch (Exception e) {}
						 try{ sigitTDettTipo2Dto.setETOutExtC(dto.getAEUscLatoEst());}catch (Exception e) {}
						 try{ sigitTDettTipo2Dto.setETInUtenzeC(dto.getAEIngLatoUtenze());}catch (Exception e) {}
						 try{ sigitTDettTipo2Dto.setETOutUtenzeC(dto.getAEUscLatoUtenze());}catch (Exception e) {}
						 try{ sigitTDettTipo2Dto.setENCircuito(ConvertUtil.convertToString(dto.getAENumCircuito()));}catch (Exception e) {}
						 
						 try{ sigitTDettTipo2Dto.setL112TorreTOutFluido(ConvertUtil.convertToBigDecimal(dto.getAETuscFluido()));}catch (Exception e) {}
						 try{ sigitTDettTipo2Dto.setL112TorreTBulboUmido(ConvertUtil.convertToBigDecimal(dto.getAETbulboUmido()));}catch (Exception e) {}
						 try{ sigitTDettTipo2Dto.setL112ScambiatoreTInExt(ConvertUtil.convertToBigDecimal(dto.getAETingFluidoSorg()));}catch (Exception e) {}
						 try{ sigitTDettTipo2Dto.setL112ScambiatoreTOutExt(ConvertUtil.convertToBigDecimal(dto.getAETuscFluidoSorg()));}catch (Exception e) {}
						 try{ sigitTDettTipo2Dto.setL112ScambiatTInMacchina(ConvertUtil.convertToBigDecimal(dto.getAETingFluidoMacc()));}catch (Exception e) {}
						 try{ sigitTDettTipo2Dto.setL112ScambiatTOutMacchina(ConvertUtil.convertToBigDecimal(dto.getAETuscFluidoMacc()));}catch (Exception e) {}
						 try{ sigitTDettTipo2Dto.setL112PotenzaAssorbitaKw(ConvertUtil.convertToBigDecimal(dto.getAEPotenzaAss()));}catch (Exception e) {}
						 
						 try{
							if(Constants.FILTRI_PULITI_SI.equalsIgnoreCase(dto.getAEFiltriPuliti()))
								sigitTDettTipo2Dto.setL112FlgPuliziaFiltri(new BigDecimal(Constants.SI_1));
							if(Constants.FILTRI_PULITI_NO.equalsIgnoreCase(dto.getAEFiltriPuliti()))
								sigitTDettTipo2Dto.setL112FlgPuliziaFiltri(new BigDecimal(Constants.NO_0)); 
							 }catch (Exception e) {}
						 
						 try{
							 if(Constants.VERIFICA_SUPERATA_SI.equalsIgnoreCase(dto.getAEVerifica()))
								sigitTDettTipo2Dto.setL112FlgVerificaSuperata(new BigDecimal(Constants.SI_1));
							 if(Constants.VERIFICA_SUPERATA_NO.equalsIgnoreCase(dto.getAEVerifica()))
							    sigitTDettTipo2Dto.setL112FlgVerificaSuperata(new BigDecimal(Constants.NO_0)); 
							 }catch (Exception e) {}
						*/
						 
						 //INSERISCO
						 getDbMgr().getSigitTDettTipo2Dao().insert(sigitTDettTipo2Dto);
					 
						 count++;
					 }
				}
				//devo tracciaare il fatto che sono entrata la prima volta
				flagControllo = true;
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END dentro il for");
			}
		
			log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> INSERT SU sigit_t_DETT_tipo2");
			//adesso devo aggiornare la parte di libretto che e' dedicata esclusivamente all'allegato
			//mi trovo l'ultimo libretto aggiornato e creo una copia di questo sulla tabella
			//dopodiche' mi vado a richiamare il metodo che scrive il libretto e lo consolida
			
			SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
			//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
			recordLibretto.setCfRedattore(cfUtenteLoggato);
			recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
			recordLibretto.setUtenteUltMod(cfUtenteLoggato);
			recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
			//inserisco
			getDbMgr().inserisciLibretto(recordLibretto);
			
			log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END --> INSERT SU sigit_t_libretto");
			//adesso eseguo i punti 4, 5, 6 dell'algoritmo A002_7 riferito al libretto
//			this.creaPdfEConsolidaLibretto(cfUtenteLoggato, impianto, codiceRea, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO);
		}catch(Exception e){
			log.error("eccezione salvaInfoDaXmlAllegato2 --> "+e.getMessage(),e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END");
	}
	
	public void salvaInfoDaXmlAllegato3(MODIVDocument modAllegatoTipo3, 
			SigitTAllegatoDto allegato, SigitTImpiantoDto impianto, String cfUtenteLoggato, String codiceRea)throws ManagerException {
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] BEGIN");
		
		//aggiorniamo di nuovo la tabella SIGIT_T_ALLEGATO con gli altri elementi aggiuntivi sia dell'xml che le informazioni dell'utente
		it.csi.sigit.sigitwebn.xml.allegato4.data.RichiestaDocument.Richiesta richiesta = modAllegatoTipo3.getMODIV().getRichiesta();
		
		//sezione B.documentazione tecnica a corredo
		List<it.csi.sigit.sigitwebn.xml.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV> allegatoIVList = richiesta.getDatiAllegato().getAllegatoIV().getRowAllegatoIVList();
		boolean flagControllo = false;

		try{
			log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] lubghezza rowAllegatiIII --> "+allegatoIVList.size());
			for(it.csi.sigit.sigitwebn.xml.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV allegatoIV: allegatoIVList){
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] entro nel for RowAllegatoIV");

				//RowAllegatoIV allegatoIV = allegatoIVList.get(0);
				it.csi.sigit.sigitwebn.xml.allegato4.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = allegatoIV.getDocumentazioneTecnica();
				it.csi.sigit.sigitwebn.xml.allegato4.data.TrattamentoAcquaDocument.TrattamentoAcqua trattamentoAcqua =  allegatoIV.getTrattamentoAcqua();

				try{
					if(documentazioneTecnica.getABFlagDichiarazConfNO()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				
				try{
					if(documentazioneTecnica.getABFlagDichiarazConfSI()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				
				try{
					if(documentazioneTecnica.getABFlagLibrettoCompNO()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				
				try{
					if(documentazioneTecnica.getABFlagLibrettoCompSI()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				
				try{
					if(documentazioneTecnica.getABFlagLibrettoImpNO()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				
				try{
					if(documentazioneTecnica.getABFlagLibrettoImpSI()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				
				try{
					if(documentazioneTecnica.getABFlagManutGenNO()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}
				
				try{
					if(documentazioneTecnica.getABFlagManutGenSI()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}
				
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END --> B. documentazione tecnica a corredo");

				//sezione F.check list
				it.csi.sigit.sigitwebn.xml.allegato4.data.CheckListDocument.CheckList checkList = allegatoIV.getCheckList();
				log.debug("[F ]check list --> checkList.getAFOsservazioni(): "+checkList.getAFOsservazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni())){
					allegato.setFOsservazioni(checkList.getAFOsservazioni());
				}
				log.debug("[F]check list --> checkList.getAFRaccomandazioni(): "+checkList.getAFRaccomandazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni())){
					allegato.setFRaccomandazioni(checkList.getAFRaccomandazioni());
				}
				log.debug("[F ]check list --> checkList.getAFPrescrizioni(): "+checkList.getAFPrescrizioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni())){
					allegato.setFPrescrizioni(checkList.getAFPrescrizioni());
				}

				it.csi.sigit.sigitwebn.xml.allegato4.data.DatiTecnicoDocument.DatiTecnico datiTecnico = allegatoIV.getDatiTecnico();
				try{
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpNO(): "+datiTecnico.getAFFlagFunzImpNO());
				if(datiTecnico.getAFFlagFunzImpNO()){
					allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.NO_0));
				}
				}catch (Exception e) {}
				try{
					log.debug("[F]check list --> datiTecnico.getAFFlagFunzImpSI(): "+datiTecnico.getAFFlagFunzImpSI());
				if(datiTecnico.getAFFlagFunzImpSI()){
					allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.SI_1));
				}
			}catch (Exception e) {}
				try{allegato.setFInterventoEntro(DateUtil.getSqlDate(datiTecnico.getAFDataIntervento()));}catch (Exception e) {}

				
				try{
					log.debug("[F ]check list --> datiTecnico.getAFOrarioArrivo(): "+datiTecnico.getAFOrarioArrivo());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioArrivo())){
					allegato.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
				}
				}catch (Exception e) {}

				try{
					log.debug("[F]check list --> datiTecnico.getAFOrarioPartenza(): "+datiTecnico.getAFOrarioPartenza());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioPartenza())){
					allegato.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
				}
				}catch (Exception e) {}
				log.debug("[F ]check list --> datiTecnico.getAFNomeTecnico(): "+datiTecnico.getAFNomeTecnico());
				log.debug("[F]check list --> datiTecnico.getAFCognomeTecnico(): "+datiTecnico.getAFCognomeTecnico());
				allegato.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));
				try{
					log.debug("[F]check list --> datiTecnico.getAFFirmaTecnico(): "+datiTecnico.getAFFirmaTecnico());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
					allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
				}else{
					allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
				}
				}catch (Exception e) {}
				try{
					log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
					allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
				}else{
					allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
				}
			}catch (Exception e) {}
				//Non so ancora cosa settare a livello di flg_controllo_bozza????
				allegato.setFlgControlloBozza(new BigDecimal(Constants.SI_1));
				allegato.setDataUltMod(DateUtil.getSqlDataCorrente());
				allegato.setUtenteUltMod(cfUtenteLoggato);

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END --> F.check list per  sigit_t_allegato");
				//aggiorno la tabella SIGIT_T_ALLEGATO
				if(!flagControllo){
					//solo al primo giro mi fai l'update perche' le ulteriori pagine non sono valorizzate per la sezione relativa allallegato
					try {
						getDbMgr().getSigitTAllegatoDao().update(allegato);
					} catch (SigitTAllegatoDaoException e) {
						throw new ManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
					}
				}
				
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END --> update su  sigit_t_allegato");

				SigitTRappTipo3Dto rapportoTipo3 = new SigitTRappTipo3Dto();

				//SEZIONE C.TRATTAMENTO ACQUA
				try{
				if(trattamentoAcqua.getACFlagTrattH2ONR()){
					rapportoTipo3.setCFlgTrattClimaNonRichiest(new BigDecimal(Constants.SI_1));
				}else{
					rapportoTipo3.setCFlgTrattClimaNonRichiest(new BigDecimal(Constants.NO_0));
				}
				}catch (Exception e) {}
				
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END -->  sezione F.check list legata a sigit_t_rapp_tipo3");

				//sezione D.controllo dell'impianto
				it.csi.sigit.sigitwebn.xml.allegato4.data.ControlloImpiantoDocument.ControlloImpianto controlloImpianto = allegatoIV.getControlloImpianto();

				log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLuogoIdoneoSI(): "+controlloImpianto.getADFlagLuogoIdoneoSI());
				if(controlloImpianto.getADFlagLuogoIdoneoSI()){
					rapportoTipo3.setDFlgLocaleIdoneo(new BigDecimal(Constants.SI_1));
				}else if(controlloImpianto.getADFlagLuogoIdoneoNO()){
					rapportoTipo3.setDFlgLocaleIdoneo(new BigDecimal(Constants.NO_0));
				}else if(controlloImpianto.getADFlagLuogoIdoneoNC()){
					rapportoTipo3.setDFlgLocaleIdoneo(new BigDecimal(Constants.NC_2));
				}

				log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLineeIdoneeSI(): "+controlloImpianto.getADFlagLineeIdoneeSI());
				try{
				if(controlloImpianto.getADFlagLineeIdoneeSI()){
					rapportoTipo3.setDFlgLineaElettIdonea(new BigDecimal(Constants.SI_1));
				}else if(controlloImpianto.getADFlagLineeIdoneeNO()){
					rapportoTipo3.setDFlgLineaElettIdonea(new BigDecimal(Constants.NO_0));
				}else if(controlloImpianto.getADFlagLineeIdoneeNC()){
					rapportoTipo3.setDFlgLineaElettIdonea(new BigDecimal(Constants.NC_2));
				}
				}catch (Exception e) {}
				
				try{
				log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagCoibenIdoneeSI(): "+controlloImpianto.getADFlagStatoCoibenSI());
				if(controlloImpianto.getADFlagStatoCoibenSI()){
					rapportoTipo3.setDFlgCoibIdonea(new BigDecimal(Constants.SI_1));
				}else if(controlloImpianto.getADFlagStatoCoibenNO()){
					rapportoTipo3.setDFlgCoibIdonea(new BigDecimal(Constants.NO_0));
				}else if(controlloImpianto.getADFlagStatoCoibenNC()){
					rapportoTipo3.setDFlgCoibIdonea(new BigDecimal(Constants.NC_2));
				}
				}catch (Exception e) {}
				
				try{
				log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagPerditeSI(): "+controlloImpianto.getADFlagPerditeSI());
				if(controlloImpianto.getADFlagPerditeSI()){
					rapportoTipo3.setDFlgAssenzaPerdite(new BigDecimal(Constants.SI_1));
				}else if(controlloImpianto.getADFlagPerditeNO()){
					rapportoTipo3.setDFlgAssenzaPerdite(new BigDecimal(Constants.NO_0));
				}else if(controlloImpianto.getADFlagPerditeNC()){
					rapportoTipo3.setDFlgAssenzaPerdite(new BigDecimal(Constants.NC_2));
				}
				}catch (Exception e) {}
			
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END -->  sezione D.controllo dell'impianto legata a sigit_t_rapp_tipo2");

				//INSERISCO nella tabella SIGIT_RAPP_TIPO3
				rapportoTipo3.setIdAllegato(allegato.getIdAllegato());
				
				SigitTRappTipo3Pk pk = new SigitTRappTipo3Pk();
				pk.setIdAllegato(allegato.getIdAllegato());
				//devo controllare se ho un record presente sulla tabella o no
				SigitTRappTipo3Dto dettaglioRappTipo3 = getDbMgr().getSigitTRappTipo3Dao().findByPrimaryKey(pk);
				if(dettaglioRappTipo3!=null){
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] TROVATO RECORD SU sigit_t_rapp_tipo3");
					//non posso fare l'update perche' nelle pagine successive non mi riporta tutti i dati
					//getDbMgr().getSigitTRappTipo1Dao().update(rapportoTipo1);
				}
				else{
					getDbMgr().getSigitTRappTipo3Dao().insert(rapportoTipo3);
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END --> INSERT SU sigit_t_rapp_tipo3");
				}

				//sezione E.controllo e verifica energetica  del gruppo termico
				it.csi.sigit.sigitwebn.xml.allegato4.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVerificaEnergetica = allegatoIV.getControlloVerificaEnergetica();
				SigitTDettTipo3Dto sigitTDettTipo3Dto = new SigitTDettTipo3Dto();

				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagPotCompSI(): "+controlloVerificaEnergetica.getAEFlagPotCompSI());
				if(controlloVerificaEnergetica.getAEFlagPotCompSI()){
					sigitTDettTipo3Dto.setEFlgPotenzaCompatibile(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagPotCompNO()){
					sigitTDettTipo3Dto.setEFlgPotenzaCompatibile(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagPotCompNC()){
					sigitTDettTipo3Dto.setEFlgPotenzaCompatibile(new BigDecimal(Constants.NC_2));
				}

				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagStatoCoibenSI(): "+controlloVerificaEnergetica.getAEFlagStatoCoibenSI());
				if(controlloVerificaEnergetica.getAEFlagStatoCoibenSI()){
					sigitTDettTipo3Dto.setEFlgCoibIdonea(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagStatoCoibenNO()){
					sigitTDettTipo3Dto.setEFlgCoibIdonea(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagStatoCoibenNC()){
					sigitTDettTipo3Dto.setEFlgCoibIdonea(new BigDecimal(Constants.NC_2));
				}

				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagDispRegSI(): "+controlloVerificaEnergetica.getAEFlagDispRegSI());
				if(controlloVerificaEnergetica.getAEFlagDispRegSI()){
					sigitTDettTipo3Dto.setEFlgDispFunzionanti(new BigDecimal(Constants.SI_1));
				}else if(controlloVerificaEnergetica.getAEFlagDispRegNO()){
					sigitTDettTipo3Dto.setEFlgDispFunzionanti(new BigDecimal(Constants.NO_0));
				}else if(controlloVerificaEnergetica.getAEFlagDispRegNO()){
					sigitTDettTipo3Dto.setEFlgDispFunzionanti(new BigDecimal(Constants.NC_2));
				}

				sigitTDettTipo3Dto.setCodiceImpianto(impianto.getCodiceImpianto());
				sigitTDettTipo3Dto.setFkAllegato(allegato.getIdAllegato());
				sigitTDettTipo3Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
				sigitTDettTipo3Dto.setUtenteUltMod(cfUtenteLoggato);
				sigitTDettTipo3Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_SC);
				try{sigitTDettTipo3Dto.setProgressivo(ConvertUtil.convertToBigDecimal(allegatoIV.getAENumSC()));}catch (Exception e) {}
				try{sigitTDettTipo3Dto.setDataInstall(DateUtil.getSqlDate(allegatoIV.getAEDataInstallaz()));}catch (Exception e) {}

				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagClimatizInv(): "+controlloVerificaEnergetica.getAEFlagClimatizInv());
				if(controlloVerificaEnergetica.getAEFlagClimatizInv()){
					sigitTDettTipo3Dto.setEFlgClimaInverno(new BigDecimal(Constants.SI_1));
				}else{
					sigitTDettTipo3Dto.setEFlgClimaInverno(new BigDecimal(Constants.NO_0));
				}
				log.debug("[E ]controllo e verifica energetica  del gruppo termico --> controlloVerificaEnergetica.getAEFlagProduzACS(): "+controlloVerificaEnergetica.getAEFlagProduzACS());
				if(controlloVerificaEnergetica.getAEFlagProduzACS()){
					sigitTDettTipo3Dto.setEFlgProduzAcs(new BigDecimal(Constants.SI_1));
				}else{
					sigitTDettTipo3Dto.setEFlgProduzAcs(new BigDecimal(Constants.NO_0));
				}

				sigitTDettTipo3Dto.setFkFluidoAlimentaz(new BigDecimal(controlloVerificaEnergetica.getAECombustibile()));
				sigitTDettTipo3Dto.setFkFluido(new BigDecimal(controlloVerificaEnergetica.getAEFluidoVett()));


				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END --> sezione E.controllo e verifica energetica  del gruppo termico sigit_t_DETT_tipo3");
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] BEGIN --> sezione E.controllo e verifica energetica tab fumi del gruppo termico sigit_t_DETT_tipo3");
				it.csi.sigit.sigitwebn.xml.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV.TabFumi	tabFumi = allegatoIV.getTabFumi();
				List<it.csi.sigit.sigitwebn.xml.allegato4.data.RowFumiDocument.RowFumi> rigaFumi = tabFumi.getRowFumiList();
				if(rigaFumi!=null && rigaFumi.size()>0){
					log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO IV LUNGHEZZA LISTA: "+rigaFumi.size());
					for(it.csi.sigit.sigitwebn.xml.allegato4.data.RowFumiDocument.RowFumi dto : rigaFumi){

						try{ sigitTDettTipo3Dto.setETempExtC(dto.getAETempEst());}catch (Exception e) {sigitTDettTipo3Dto.setETempExtC(null);}

						try{ sigitTDettTipo3Dto.setETempMandPrimarioC(dto.getAETempMandPrim());}catch (Exception e) {sigitTDettTipo3Dto.setETempMandPrimarioC(null);}
						try{ sigitTDettTipo3Dto.setETempRitorPrimarioC(dto.getAETempRitPrim());}catch (Exception e) {sigitTDettTipo3Dto.setETempRitorPrimarioC(null);}
						try{ sigitTDettTipo3Dto.setEPotenzaTermKw(dto.getAEPotenzaTerm());}catch (Exception e) {sigitTDettTipo3Dto.setEPotenzaTermKw(null);}
						try{ sigitTDettTipo3Dto.setEPortFluidoM3H(dto.getAEPortataFluido());}catch (Exception e) {sigitTDettTipo3Dto.setEPortFluidoM3H(null);}
						try{ sigitTDettTipo3Dto.setETempMandSecondarioC(dto.getAETempMandSecond());}catch (Exception e) {sigitTDettTipo3Dto.setETempMandSecondarioC(null);}
						try{ sigitTDettTipo3Dto.setETempRitSecondarioC(dto.getAETempRitSecond());}catch (Exception e) {sigitTDettTipo3Dto.setETempRitSecondarioC(null);}

						/*
						try{ sigitTDettTipo3Dto.setETempExtC(dto.getAETempEst());}catch (Exception e) {}

						try{ sigitTDettTipo3Dto.setETempMandPrimarioC(dto.getAETempMandPrim());}catch (Exception e) {}
						try{ sigitTDettTipo3Dto.setETempRitorPrimarioC(dto.getAETempRitPrim());}catch (Exception e) {}
						try{ sigitTDettTipo3Dto.setEPotenzaTermKw(dto.getAEPotenzaTerm());}catch (Exception e) {}
						try{ sigitTDettTipo3Dto.setEPortFluidoM3H(dto.getAEPortataFluido());}catch (Exception e) {}
						try{ sigitTDettTipo3Dto.setETempMandSecondarioC(dto.getAETempMandSecond());}catch (Exception e) {}
						try{ sigitTDettTipo3Dto.setETempRitSecondarioC(dto.getAETempRitSecond());}catch (Exception e) {}
						*/
						
						//INSERISCO
						getDbMgr().getSigitTDettTipo3Dao().insert(sigitTDettTipo3Dto);
						log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END --> INSERT SU sigit_t_DETT_tipo3");

					}
				}
				//devo tracciaare il fatto che sono entrata la prima volta
				flagControllo = true;
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END dentro il for");
			}

		
		
		//adesso devo aggiornare la parte di libretto che e' dedicata esclusivamente all'allegato
		//mi trovo l'ultimo libretto aggiornato e creo una copia di questo sulla tabella
		//dopodiche' mi vado a richiamare il metodo che scrive il libretto e lo consolida
		
		SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
		//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
		recordLibretto.setCfRedattore(cfUtenteLoggato);
		recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
		recordLibretto.setUtenteUltMod(cfUtenteLoggato);
		recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
		//inserisco
		getDbMgr().inserisciLibretto(recordLibretto);
		
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END --> INSERT SU sigit_t_libretto");
		//adesso eseguo i punti 4, 5, 6 dell'algoritmo A002_7 riferito al libretto
//		this.creaPdfEConsolidaLibretto(cfUtenteLoggato, impianto, codiceRea, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO);
		
		}catch(Exception e){
			log.error("eccezione salvaInfoDaXmlAllegato3 --> "+e.getMessage(),e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END");
	}
	
	public void salvaInfoDaXmlAllegato4(MODVDocument modAllegatoTipo4, 
			SigitTAllegatoDto allegato, SigitTImpiantoDto impianto, String cfUtenteLoggato, String codiceRea)throws ManagerException {
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] BEGIN");

		//aggiorniamo di nuovo la tabella SIGIT_T_ALLEGATO con gli altri elementi aggiuntivi sia dell'xml che le informazioni dell'utente
		it.csi.sigit.sigitwebn.xml.allegato5.data.RichiestaDocument.Richiesta richiesta = modAllegatoTipo4.getMODV().getRichiesta();

		//sezione B.documentazione tecnica a corredo
		List<it.csi.sigit.sigitwebn.xml.allegato5.data.RowAllegatoVDocument.RowAllegatoV> allegatoVList = richiesta.getDatiAllegato().getAllegatoV().getRowAllegatoVList();
		boolean flagControllo = false;

		try{
			log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] lubghezza rowAllegatiV --> "+allegatoVList.size());
			for(it.csi.sigit.sigitwebn.xml.allegato5.data.RowAllegatoVDocument.RowAllegatoV allegatoV: allegatoVList){
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] entro nel for RowAllegatoV");

				it.csi.sigit.sigitwebn.xml.allegato5.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica documentazioneTecnica = allegatoV.getDocumentazioneTecnica();

				try{
					if(documentazioneTecnica.getABFlagDichiarazConfNO()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagDichiarazConfSI()){
						allegato.setBFlgDichiarConform(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagLibrettoCompNO()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagLibrettoCompSI()){
						allegato.setBFlgLibCompl(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagLibrettoImpNO()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagLibrettoImpSI()){
						allegato.setBFlgLibImp(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagManutGenNO()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					if(documentazioneTecnica.getABFlagManutGenSI()){
						allegato.setBFlgLibrettoUso(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato1] END --> B. documentazione tecnica a corredo");

				//sezione F.check list
				it.csi.sigit.sigitwebn.xml.allegato5.data.CheckListDocument.CheckList checkList = allegatoV.getCheckList();
				log.debug("[F ]check list --> checkList.getAFOsservazioni(): "+checkList.getAFOsservazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni())){
					allegato.setFOsservazioni(checkList.getAFOsservazioni());
				}
				log.debug("[F]check list --> checkList.getAFRaccomandazioni(): "+checkList.getAFRaccomandazioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni())){
					allegato.setFRaccomandazioni(checkList.getAFRaccomandazioni());
				}
				log.debug("[F ]check list --> checkList.getAFPrescrizioni(): "+checkList.getAFPrescrizioni());
				if(GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni())){
					allegato.setFPrescrizioni(checkList.getAFPrescrizioni());
				}

				it.csi.sigit.sigitwebn.xml.allegato5.data.DatiTecnicoDocument.DatiTecnico datiTecnico = allegatoV.getDatiTecnico();

				try{
					log.debug("[F ]check list --> datiTecnico.getAFFlagFunzImpNO(): "+datiTecnico.getAFFlagFunzImpNO());

					if(datiTecnico.getAFFlagFunzImpNO()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.NO_0));
					}
				}catch (Exception e) {}

				try{
					log.debug("[F]check list --> datiTecnico.getAFFlagFunzImpSI(): "+datiTecnico.getAFFlagFunzImpSI());
					if(datiTecnico.getAFFlagFunzImpSI()){
						allegato.setFFlgPuoFunzionare(new BigDecimal(Constants.SI_1));
					}
				}catch (Exception e) {}

				try{allegato.setFInterventoEntro(DateUtil.getSqlDate(datiTecnico.getAFDataIntervento()));}catch (Exception e) {}

				log.debug("[F ]check list --> datiTecnico.getAFOrarioArrivo(): "+datiTecnico.getAFOrarioArrivo());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioArrivo())){
					allegato.setFOraArrivo(datiTecnico.getAFOrarioArrivo());
				}
				log.debug("[F]check list --> datiTecnico.getAFOrarioPartenza(): "+datiTecnico.getAFOrarioPartenza());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFOrarioPartenza())){
					allegato.setFOraPartenza(datiTecnico.getAFOrarioPartenza());
				}
				log.debug("[F ]check list --> datiTecnico.getAFNomeTecnico(): "+datiTecnico.getAFNomeTecnico());
				log.debug("[F]check list --> datiTecnico.getAFCognomeTecnico(): "+datiTecnico.getAFCognomeTecnico());
				allegato.setFDenominazTecnico(ConvertUtil.formattaNominativo(datiTecnico.getAFNomeTecnico(), datiTecnico.getAFCognomeTecnico()));
				log.debug("[F]check list --> datiTecnico.getAFFirmaTecnico(): "+datiTecnico.getAFFirmaTecnico());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaTecnico())){
					allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.SI_1));
				}else{
					allegato.setFFlgFirmaTecnico(new BigDecimal(Constants.NO_0));
				}
				log.debug("[F]check list --> datiTecnico.getAFFirmaResp(): "+datiTecnico.getAFFirmaResp());
				if(GenericUtil.isNotNullOrEmpty(datiTecnico.getAFFirmaResp())){
					allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.SI_1));
				}else{
					allegato.setFFlgFirmaResponsabile(new BigDecimal(Constants.NO_0));
				}

				//Non so ancora cosa settare a livello di flg_controllo_bozza????
				allegato.setFlgControlloBozza(new BigDecimal(Constants.SI_1));
				allegato.setDataUltMod(DateUtil.getSqlDataCorrente());
				allegato.setUtenteUltMod(cfUtenteLoggato);


				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END --> F.check list per  sigit_t_allegato");
				//aggiorno la tabella SIGIT_T_ALLEGATO
				if(!flagControllo){
					//solo al primo giro mi fai l'update perche' le ulteriori pagine non sono valorizzate per la sezione relativa allallegato
					try {
						getDbMgr().getSigitTAllegatoDao().update(allegato);
					} catch (SigitTAllegatoDaoException e) {
						throw new ManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
					}
				}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] END --> update su  sigit_t_allegato");

				SigitTRappTipo4Dto rapportoTipo4 = new SigitTRappTipo4Dto();
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END -->  sezione F.check list legata a sigit_t_rapp_tipo1");

				//sezione D.controllo dell'impianto
				it.csi.sigit.sigitwebn.xml.allegato5.data.ControlloImpiantoDocument.ControlloImpianto controlloImpianto = allegatoV.getControlloImpianto();

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLuogoIdoneoSI(): "+controlloImpianto.getADFlagLuogoIdoneoSI());
					if(controlloImpianto.getADFlagLuogoIdoneoSI()){
						rapportoTipo4.setDFlgLuogoIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagLuogoIdoneoNO()){
						rapportoTipo4.setDFlgLuogoIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagLuogoIdoneoNC()){
						rapportoTipo4.setDFlgLuogoIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagDimensioniSI(): "+controlloImpianto.getADFlagDimensioniSI());
					if(controlloImpianto.getADFlagDimensioniSI()){
						rapportoTipo4.setDFlgVentilazAdeg(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagDimensioniNO()){
						rapportoTipo4.setDFlgVentilazAdeg(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagDimensioniNC()){
						rapportoTipo4.setDFlgVentilazAdeg(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagApertureSI(): "+controlloImpianto.getADFlagApertureSI());
					if(controlloImpianto.getADFlagApertureSI()){
						rapportoTipo4.setDFlgVentilazLibera(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagApertureNO()){
						rapportoTipo4.setDFlgVentilazLibera(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagApertureNC()){
						rapportoTipo4.setDFlgVentilazLibera(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagLineeIdoneeSI(): "+controlloImpianto.getADFlagLineeIdoneeSI());
					if(controlloImpianto.getADFlagLineeIdoneeSI()){
						rapportoTipo4.setDFlgLineaElettIdonea(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagLineeIdoneeNO()){
						rapportoTipo4.setDFlgLineaElettIdonea(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagLineeIdoneeNC()){
						rapportoTipo4.setDFlgLineaElettIdonea(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagCanaleFumoSI(): "+controlloImpianto.getADFlagCanaleFumoSI());
					if(controlloImpianto.getADFlagCanaleFumoSI()){
						rapportoTipo4.setDFlgCaminoIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagCanaleFumoNO()){
						rapportoTipo4.setDFlgCaminoIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagCanaleFumoNC()){
						rapportoTipo4.setDFlgCaminoIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagCapsulaInsoSI(): "+controlloImpianto.getADFlagCapsulaInsoSI());
					if(controlloImpianto.getADFlagCapsulaInsoSI()){
						rapportoTipo4.setDFlgCapsulaIdonea(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagCapsulaInsoNO()){
						rapportoTipo4.setDFlgCapsulaIdonea(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagCapsulaInsoNC()){
						rapportoTipo4.setDFlgCapsulaIdonea(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagTenutaIdraulicaSI(): "+controlloImpianto.getADFlagTenutaIdraulicaSI());
					if(controlloImpianto.getADFlagTenutaIdraulicaSI()){
						rapportoTipo4.setDFlgCircIdrIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagTenutaIdraulicaNO()){
						rapportoTipo4.setDFlgCircIdrIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagTenutaIdraulicaNC()){
						rapportoTipo4.setDFlgCircIdrIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagTenutaOlioSI(): "+controlloImpianto.getADFlagTenutaOlioSI());
					if(controlloImpianto.getADFlagTenutaOlioSI()){
						rapportoTipo4.setDFlgCircOlioIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagTenutaOlioNO()){
						rapportoTipo4.setDFlgCircOlioIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagTenutaOlioNC()){
						rapportoTipo4.setDFlgCircOlioIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {}


				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagTenutaAlimentazSI(): "+controlloImpianto.getADFlagTenutaAlimentazSI());
					if(controlloImpianto.getADFlagTenutaAlimentazSI()){
						rapportoTipo4.setDFlgCircCombIdoneo(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagTenutaAlimentazNO()){
						rapportoTipo4.setDFlgCircCombIdoneo(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagTenutaAlimentazNC()){
						rapportoTipo4.setDFlgCircCombIdoneo(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {}

				try
				{
					log.debug("[D ]controllo impianto --> controlloImpianto.getADFlagFunzionalitaSI(): "+controlloImpianto.getADFlagFunzionalitaSI());
					if(controlloImpianto.getADFlagFunzionalitaSI()){
						rapportoTipo4.setDFlgFunzScambIdonea(new BigDecimal(Constants.SI_1));
					}else if(controlloImpianto.getADFlagFunzionalitaNO()){
						rapportoTipo4.setDFlgFunzScambIdonea(new BigDecimal(Constants.NO_0));
					}else if(controlloImpianto.getADFlagFunzionalitaNC()){
						rapportoTipo4.setDFlgFunzScambIdonea(new BigDecimal(Constants.NC_2));
					}
				}catch (Exception e) {}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato2] END -->  sezione D.controllo dell'impianto legata a sigit_t_rapp_tipo2");

				//INSERISCO nella tabella SIGIT_RAPP_TIPO4
				rapportoTipo4.setIdAllegato(allegato.getIdAllegato());

				SigitTRappTipo4Pk pk = new SigitTRappTipo4Pk();
				pk.setIdAllegato(allegato.getIdAllegato());
				//devo controllare se ho un record presente sulla tabella o no
				SigitTRappTipo4Dto dettaglioRappTipo4 = getDbMgr().getSigitTRappTipo4Dao().findByPrimaryKey(pk);
				if(dettaglioRappTipo4!=null){
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] TROVATO RECORD SU sigit_t_rapp_tipo4");
					//non posso fare l'update perche' nelle pagine successive non mi riporta tutti i dati
				}
				else{
					getDbMgr().getSigitTRappTipo4Dao().insert(rapportoTipo4);
					log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] END --> INSERT SU sigit_t_rapp_tipo4");
				}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] END --> INSERT SU sigit_t_rapp_tipo4");

				//sezione E.controllo e verifica energetica  del gruppo termico
				it.csi.sigit.sigitwebn.xml.allegato5.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVerificaEnergetica = allegatoV.getControlloVerificaEnergetica();
				SigitTDettTipo4Dto sigitTDettTipo4Dto = new SigitTDettTipo4Dto();

				sigitTDettTipo4Dto.setCodiceImpianto(impianto.getCodiceImpianto());
				sigitTDettTipo4Dto.setFkAllegato(allegato.getIdAllegato());
				sigitTDettTipo4Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
				sigitTDettTipo4Dto.setUtenteUltMod(cfUtenteLoggato);
				sigitTDettTipo4Dto.setFkTipoComponente(Constants.TIPO_COMPONENTE_CG);
				try{sigitTDettTipo4Dto.setProgressivo(ConvertUtil.convertToBigDecimal(allegatoV.getAENumCG()));}catch (Exception e) {}
				try{sigitTDettTipo4Dto.setDataInstall(DateUtil.getSqlDate(allegatoV.getAEDataInstallaz()));}catch (Exception e) {}

				sigitTDettTipo4Dto.setFkFluido(new BigDecimal(controlloVerificaEnergetica.getAEFluidoVett()));

				try{sigitTDettTipo4Dto.setEPotenzaAssorbCombKw(allegatoV.getAEPotenzaAssorbita());}catch (Exception e) {}
				try{sigitTDettTipo4Dto.setEPotenzaTermBypassKw(allegatoV.getAEPotenzaTermByPass());}catch (Exception e) {}

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] END --> sezione E.controllo e verifica energetica  del gruppo termico sigit_t_DETT_tipo4");

				log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] BEGIN --> sezione E.controllo e verifica energetica tab fumi del gruppo termico sigit_t_DETT_tipo4");
				it.csi.sigit.sigitwebn.xml.allegato5.data.RowAllegatoVDocument.RowAllegatoV.TabFumi	tabFumi = allegatoV.getTabFumi();
				List<it.csi.sigit.sigitwebn.xml.allegato5.data.RowFumiDocument.RowFumi> rigaFumi = tabFumi.getRowFumiList();
				if(rigaFumi!=null && rigaFumi.size()>0){
					log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO V LUNGHEZZA LISTA: "+rigaFumi.size());
					int count = 0;
					for(it.csi.sigit.sigitwebn.xml.allegato5.data.RowFumiDocument.RowFumi dto : rigaFumi){
						
						log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO V count: "+count);

						try{ sigitTDettTipo4Dto.setETempAriaC(dto.getAETempAriaCombur());}catch (Exception e) {sigitTDettTipo4Dto.setETempAriaC(null);}

						try{ sigitTDettTipo4Dto.setETempH2oInC(dto.getAETempAriaIng());}catch (Exception e) {sigitTDettTipo4Dto.setETempH2oInC(null);}
						try{ sigitTDettTipo4Dto.setETempH2oOutC(dto.getAETempAriaUsc());}catch (Exception e) {sigitTDettTipo4Dto.setETempH2oOutC(null);}


						try{ sigitTDettTipo4Dto.setEPotenzaMorsettiKw(dto.getAEPotenzaMorsetti());}catch (Exception e) {sigitTDettTipo4Dto.setEPotenzaMorsettiKw(null);}
						try{ sigitTDettTipo4Dto.setETempH2oMotoreC(dto.getAETempH2Omotore());}catch (Exception e) {sigitTDettTipo4Dto.setETempH2oMotoreC(null);}
						try{ sigitTDettTipo4Dto.setETempFumiValleC(dto.getAETempFumiAvalle());}catch (Exception e) {sigitTDettTipo4Dto.setETempFumiValleC(null);}
						try{ sigitTDettTipo4Dto.setETempFumiMonteC(dto.getAETempFumiAmonte());}catch (Exception e) {sigitTDettTipo4Dto.setETempFumiMonteC(null);}

						try{ sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMin(dto.getAESovraFreqSoglia1());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMin(null);}
						try{ sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMed(dto.getAESovraFreqSoglia2());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMed(null);}
						try{ sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMax(dto.getAESovraFreqSoglia3());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMax(null);}

						try{ sigitTDettTipo4Dto.setL114SovrafreqTempoSMin(dto.getAESovraFreqTempo1());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovrafreqTempoSMin(null);}
						try{ sigitTDettTipo4Dto.setL114SovrafreqTempoSMed(dto.getAESovraFreqTempo2());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovrafreqTempoSMed(null);}
						try{ sigitTDettTipo4Dto.setL114SovrafreqTempoSMax(dto.getAESovraFreqTempo3());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovrafreqTempoSMax(null);}

						try{ sigitTDettTipo4Dto.setL114SottofreqSogliaHzMin(dto.getAESottoFreqSoglia1());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottofreqSogliaHzMin(null);}
						try{ sigitTDettTipo4Dto.setL114SottofreqSogliaHzMed(dto.getAESottoFreqSoglia2());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottofreqSogliaHzMed(null);}
						try{ sigitTDettTipo4Dto.setL114SottofreqSogliaHzMax(dto.getAESottoFreqSoglia3());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottofreqSogliaHzMax(null);}

						try{ sigitTDettTipo4Dto.setL114SottofreqTempoSMin(dto.getAESottoFreqTempo1());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottofreqTempoSMin(null);}
						try{ sigitTDettTipo4Dto.setL114SottofreqTempoSMed(dto.getAESottoFreqTempo2());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottofreqTempoSMed(null);}
						try{ sigitTDettTipo4Dto.setL114SottofreqTempoSMax(dto.getAESottoFreqTempo3());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottofreqTempoSMax(null);}

						try{ sigitTDettTipo4Dto.setL114SovratensSogliaVMin(dto.getAESovraTensSoglia1());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovratensSogliaVMin(null);}
						try{ sigitTDettTipo4Dto.setL114SovratensSogliaVMed(dto.getAESovraTensSoglia2());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovratensSogliaVMed(null);}
						try{ sigitTDettTipo4Dto.setL114SovratensSogliaVMax(dto.getAESovraTensSoglia3());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovratensSogliaVMax(null);}

						try{ sigitTDettTipo4Dto.setL114SovratensTempoSMin(dto.getAESovraTensTempo1());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovratensTempoSMin(null);}
						try{ sigitTDettTipo4Dto.setL114SovratensTempoSMed(dto.getAESovraTensTempo2());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovratensTempoSMed(null);}
						try{ sigitTDettTipo4Dto.setL114SovratensTempoSMax(dto.getAESovraTensTempo3());}catch (Exception e) {sigitTDettTipo4Dto.setL114SovratensTempoSMax(null);}

						try{ sigitTDettTipo4Dto.setL114SottotensSogliaVMin(dto.getAESottoTensSoglia1());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottotensSogliaVMin(null);}
						try{ sigitTDettTipo4Dto.setL114SottotensSogliaVMed(dto.getAESottoTensSoglia2());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottotensSogliaVMed(null);}
						try{ sigitTDettTipo4Dto.setL114SottotensSogliaVMax(dto.getAESottoTensSoglia3());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottotensSogliaVMax(null);}

						try{ sigitTDettTipo4Dto.setL114SottotensTempoSMin(dto.getAESottoTensTempo1());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottotensTempoSMin(null);}
						try{ sigitTDettTipo4Dto.setL114SottotensTempoSMed(dto.getAESottoTensTempo2());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottotensTempoSMed(null);}
						try{ sigitTDettTipo4Dto.setL114SottotensTempoSMax(dto.getAESottoTensTempo3());}catch (Exception e) {sigitTDettTipo4Dto.setL114SottotensTempoSMax(null);}
						
						/*
						log.debug("FRAAAAAAAAAAAAAAA ---> ROW FUMI ALLEGATO V count: "+count);

						try{ sigitTDettTipo4Dto.setETempAriaC(dto.getAETempAriaCombur());}catch (Exception e) {}

						try{ sigitTDettTipo4Dto.setETempH2oInC(dto.getAETempAriaIng());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setETempH2oOutC(dto.getAETempAriaUsc());}catch (Exception e) {}


						try{ sigitTDettTipo4Dto.setEPotenzaMorsettiKw(dto.getAEPotenzaMorsetti());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setETempH2oMotoreC(dto.getAETempH2Omotore());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setETempFumiValleC(dto.getAETempFumiAvalle());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setETempFumiMonteC(dto.getAETempFumiAmonte());}catch (Exception e) {}

						try{ sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMin(dto.getAESovraFreqSoglia1());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMed(dto.getAESovraFreqSoglia2());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setL114SovrafreqSogliaHzMax(dto.getAESovraFreqSoglia3());}catch (Exception e) {}

						try{ sigitTDettTipo4Dto.setL114SovrafreqTempoSMin(dto.getAESovraFreqTempo1());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setL114SovrafreqTempoSMed(dto.getAESovraFreqTempo2());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setL114SovrafreqTempoSMax(dto.getAESovraFreqTempo3());}catch (Exception e) {}

						try{ sigitTDettTipo4Dto.setL114SottofreqSogliaHzMin(dto.getAESottoFreqSoglia1());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setL114SottofreqSogliaHzMed(dto.getAESottoFreqSoglia2());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setL114SottofreqSogliaHzMax(dto.getAESottoFreqSoglia3());}catch (Exception e) {}

						try{ sigitTDettTipo4Dto.setL114SottofreqTempoSMin(dto.getAESottoFreqTempo1());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setL114SottofreqTempoSMed(dto.getAESottoFreqTempo2());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setL114SottofreqTempoSMax(dto.getAESottoFreqTempo3());}catch (Exception e) {}

						try{ sigitTDettTipo4Dto.setL114SovratensSogliaVMin(dto.getAESovraTensSoglia1());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setL114SovratensSogliaVMed(dto.getAESovraTensSoglia2());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setL114SovratensSogliaVMax(dto.getAESovraTensSoglia3());}catch (Exception e) {}

						try{ sigitTDettTipo4Dto.setL114SovratensTempoSMin(dto.getAESovraTensTempo1());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setL114SovratensTempoSMed(dto.getAESovraTensTempo2());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setL114SovratensTempoSMax(dto.getAESovraTensTempo3());}catch (Exception e) {}

						try{ sigitTDettTipo4Dto.setL114SottotensSogliaVMin(dto.getAESottoTensSoglia1());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setL114SottotensSogliaVMed(dto.getAESottoTensSoglia2());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setL114SottotensSogliaVMax(dto.getAESottoTensSoglia3());}catch (Exception e) {}

						try{ sigitTDettTipo4Dto.setL114SottotensTempoSMin(dto.getAESottoTensTempo1());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setL114SottotensTempoSMed(dto.getAESottoTensTempo2());}catch (Exception e) {}
						try{ sigitTDettTipo4Dto.setL114SottotensTempoSMax(dto.getAESottoTensTempo3());}catch (Exception e) {}
	
						*/
						
						//INSERISCO
						getDbMgr().getSigitTDettTipo4Dao().insert(sigitTDettTipo4Dto);

						count++;
					}
				}

				//devo tracciaare il fatto che sono entrata la prima volta
				flagControllo = true;
				log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END dentro il for");
			}

			log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] END --> INSERT SU sigit_t_DETT_tipo4");

			//adesso devo aggiornare la parte di libretto che e' dedicata esclusivamente all'allegato
			//mi trovo l'ultimo libretto aggiornato e creo una copia di questo sulla tabella
			//dopodiche' mi vado a richiamare il metodo che scrive il libretto e lo consolida

			SigitTLibrettoDto recordLibretto = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(impianto.getCodiceImpianto().toString());
			//aggiorno alcune cose di questo record trovato prima di inserirne uno nuovo
			recordLibretto.setCfRedattore(cfUtenteLoggato);
			recordLibretto.setDataUltMod(DateUtil.getSqlDataCorrente());
			recordLibretto.setUtenteUltMod(cfUtenteLoggato);
			recordLibretto.setDataConsolidamento(DateUtil.getSqlCurrentDate());
			//inserisco
			getDbMgr().inserisciLibretto(recordLibretto);

			log.debug("[SigitMgr::salvaInfoDaXmlAllegato4] END --> INSERT SU sigit_t_libretto");
			//adesso eseguo i punti 4, 5, 6 dell'algoritmo A002_7 riferito al libretto
//			this.creaPdfEConsolidaLibretto(cfUtenteLoggato, impianto, codiceRea, recordLibretto, Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO);

		}catch(Exception e){
			log.error("eccezione salvaInfoDaXmlAllegato3 --> "+e.getMessage(),e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));

		}
		log.debug("[SigitMgr::salvaInfoDaXmlAllegato3] END");
	}

	/**
	 * Crea l'xml a partire dai dati salvati sulle tabelle del db, crea il pdf definitivo in sola lettura e lo invia a INDEX, 
	 * <br/>storiccizza il libretto consolidato e consolida il libretto in bozza
	 * @param cfUtente
	 * @param impianto
	 * @param codiceRea
	 * @param libretto il libretto in bozza (da consolidare)
	 * @param motivoConsolidamento
	 * @throws ManagerException
	 */
	/*
	public void creaPdfEConsolidaLibretto(String cfUtente, SigitTImpiantoDto impianto, String codiceRea, SigitTLibrettoDto libretto, int motivoConsolidamento) throws ManagerException
	{
		boolean isRespAssente = false;
		try
		{
			String codiceImpianto = impianto.getCodiceImpianto().toString();
			String idLibretto = libretto.getIdLibretto().toString();
			
			//controllo responsabile attivo per motivo_consolidament = respinta
			if(Constants.ID_MOTIVO_CONSOLIDAMENTO_RESP_RAPP_CONTROLLO == motivoConsolidamento)
			{
				SigitVTotImpiantoDto respAttivo = getDbMgr().cercaResponsabileAttivoByCodImpianto(new Integer(codiceImpianto));
				if(respAttivo==null)
				{
					isRespAssente = true;
					throw new ManagerException(new Message("Responsabile impianto non presente."));

				}
			}
			MODDocument mod = getDbMgr().getModuloLibretto(codiceImpianto, idLibretto, true);
			//creare pdf finale non modificabile, e salvare su INDEX,
			Applicazione app = new Applicazione();
			XmlModel xmlModel = new XmlModel();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			
			Modulo modulo = getServiziMgr().cercaModulo(app, Constants.CODICE_MODULO_MODOL_LIBRETTO);

			mod.getMOD().getRichiesta().getDatiPrecompilati().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
			mod.getMOD().getRichiesta().getDatiSchedaIdentificativaImp().setL11DataIntervento(ConvertUtil.convertToXmlCalendar(impianto.getDataIntervento()));
			if(mod.getMOD().getRichiesta().getDatiRisultatiGT()!=null)
			{
				mod.getMOD().getRichiesta().getDatiRisultatiGT().setL111DescrAltro(impianto.getL111AltraNorma());
				if(GenericUtil.isNotNullOrEmpty(impianto.getL111AltraNorma()))
					mod.getMOD().getRichiesta().getDatiRisultatiGT().xsetL111FlagAltro(MapDto.getXmlBoolean(true));
				mod.getMOD().getRichiesta().getDatiRisultatiGT().xsetL111FlagNorma(MapDto.getXmlBoolean(ConvertUtil.convertToBooleanAllways(impianto.getL111FlgNormaUni103891())));
			}
			
			xmlModel.setXmlContent(XmlBeanUtils.extractByteArray(mod));
			log.debug("generato xml completo");
			RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
			modulo = getServiziMgr().getModol().mergeModulo(app, null, modulo, xmlModel);
			
			log.debug("merge effettuato");
			byte[] thePdf = modulo.getDataContent();
			String nome = getNomeFileLibretto(codiceImpianto, impianto.getDataIntervento(), idLibretto);
	
			log.debug("nome file libretto: " + nome);
			Metadati metadati = MapDto.mapMetadati(impianto, libretto, codiceRea);
			String uidIndex = getServiziMgr().indexUploadFile(nome.toString(), thePdf, metadati);
			log.debug("UID index: " + uidIndex);
			//storicizzare altri libretti consolidati
			libretto.setUtenteUltMod(cfUtente);
			
			getDbMgr().storicizzaLibretti(libretto);
			log.debug("libretti storicizzati");
			//consolidare libretto in bozza
			libretto.setFkMotivoConsolid(new BigDecimal(motivoConsolidamento));
			libretto.setFileIndex(nome);
			libretto.setUidIndex(uidIndex);
			getDbMgr().consolidaLibretto(libretto, mod.getMOD().getRichiesta().getDatiSchedaIdentificativaImp());
			log.debug("Aggiornamento xml su DB");
			getDbMgr().updateTxtLibretto(libretto.getIdLibretto(), XmlBeanUtils.readByteArray(xmlModel.getXmlContent()));
			log.debug("libretto consolidato");
		}
		catch (Exception e) {
			log.error("Errore in consolidamento:", e);
			
			if (isRespAssente)
			{
				throw new ManagerException(new Message(e.getMessage()));
			}
			else
			{
				throw new ManagerException(new Message("Errore durante il consolidamento, contattare l'amministrattore del sistema"));
			}
		}
	}
	*/
	private String getNomeFileLibretto(String codiceImpianto, Date dataIntervento, String idLibretto)
	{
		StringBuilder nome = new StringBuilder();
		nome.append(Constants.INDEX_FILE_PREFIX_LIBRETTO);
		nome.append("_");
		nome.append(codiceImpianto);
		nome.append("_");
		nome.append(ConvertUtil.convertToString(dataIntervento, ConvertUtil.FORMAT_DATE_UNDERSCORE));
		nome.append("_");
		nome.append(idLibretto);
		nome.append(".pdf");
		return nome.toString();
	}
	
	private String getNomeAllegato(BigDecimal idTipoAllegato, BigDecimal codiceImpianto, Date dataControllo, BigDecimal pkAllegato){
		StringBuilder nome = new StringBuilder();
		
		if(Constants.ALLEGATO_TIPO_1.equalsIgnoreCase(""+idTipoAllegato)){
			nome.append(Constants.DESC_ALLEGATO_TIPO_1);
		}else if(Constants.ALLEGATO_TIPO_2.equalsIgnoreCase(""+idTipoAllegato)){
			nome.append(Constants.DESC_ALLEGATO_TIPO_2);
		}else if(Constants.ALLEGATO_TIPO_3.equalsIgnoreCase(""+idTipoAllegato)){
			nome.append(Constants.DESC_ALLEGATO_TIPO_3);
		}else if(Constants.ALLEGATO_TIPO_4.equalsIgnoreCase(""+idTipoAllegato)){
			nome.append(Constants.DESC_ALLEGATO_TIPO_4);
		}
		nome.append("_");
		nome.append(codiceImpianto);
		nome.append("_");
		nome.append(ConvertUtil.convertToString(dataControllo, ConvertUtil.FORMAT_DATE_UNDERSCORE));
		nome.append("_");
		nome.append(pkAllegato);
		nome.append(".pdf");
		
		return nome.toString();
	}
	
	private String getNomeAllegatoRicevuta(BigDecimal idTipoAllegato, BigDecimal codiceImpianto, Date dataControllo, BigDecimal pkAllegato){
		StringBuilder nome = new StringBuilder();
		
		if(Constants.ALLEGATO_TIPO_1.equalsIgnoreCase(""+idTipoAllegato)){
			nome.append(Constants.DESC_ALLEGATO_TIPO_1);
		}else if(Constants.ALLEGATO_TIPO_2.equalsIgnoreCase(""+idTipoAllegato)){
			nome.append(Constants.DESC_ALLEGATO_TIPO_2);
		}else if(Constants.ALLEGATO_TIPO_3.equalsIgnoreCase(""+idTipoAllegato)){
			nome.append(Constants.DESC_ALLEGATO_TIPO_3);
		}else if(Constants.ALLEGATO_TIPO_4.equalsIgnoreCase(""+idTipoAllegato)){
			nome.append(Constants.DESC_ALLEGATO_TIPO_4);
		}
		nome.append("_");
		nome.append(codiceImpianto);
		nome.append("_");
		nome.append(ConvertUtil.convertToString(dataControllo, ConvertUtil.FORMAT_DATE_UNDERSCORE));
		nome.append("_");
		nome.append(pkAllegato);
		nome.append("_ricevuta.pdf");
		
		return nome.toString();
	}
	
	
	private String getModelloModolAllegato(String idTipoDocumento){
		String value = "";
		if(Constants.ALLEGATO_TIPO_1.equalsIgnoreCase(idTipoDocumento)){
			value = Constants.CODICE_MODULO_MODOL_ALLEGATO_II;
		}else if(Constants.ALLEGATO_TIPO_2.equalsIgnoreCase(idTipoDocumento)){
			value = Constants.CODICE_MODULO_MODOL_ALLEGATO_III;
		}else if(Constants.ALLEGATO_TIPO_3.equalsIgnoreCase(idTipoDocumento)){
			value = Constants.CODICE_MODULO_MODOL_ALLEGATO_IV;
		}else if(Constants.ALLEGATO_TIPO_4.equalsIgnoreCase(idTipoDocumento)){
			value = Constants.CODICE_MODULO_MODOL_ALLEGATO_V;
		}
		return value;
	}
	
	
	public SigitTImpXmlDto getFileTxtDaImportare(Integer idImport) throws ManagerException
	{
		log.debug("[SigitbatchMgr::getFileTxtDaImportare] BEGIN");

		SigitTImpXmlDto impXml = null;
		
		try {
			log.debug("[SigitbatchMgr::getFileTxtDaImportare] Step 1 – Recupero il file txt");

			//List<SigitTImportDto> dtoList = getDbMgr().cercaXmlDaImportare();
			
			impXml = getDbMgr().cercaFileTxtDaImportare(idImport);
			
		}
		catch (DbManagerException ex)
		{
			throw new ManagerException(ex, ex.getMsg());

		}
		
		log.debug("[SigitbatchMgr::getFileTxtDaImportare] END");

		return impXml;

	}
	
	public List<DatiFornituraCliente> getFileDistribDaImportare(String uidIndex) throws ManagerException
	{
		log.debug("[SigitbatchMgr::getFileDistribDaImportare] BEGIN");

		List<DatiFornituraCliente> listForniture = null;
		try {
			
			log.debug("[SigitbatchMgr::getFileDistribDaImportare] Step 1 – Recupero il file txt");

			//List<SigitTImportDto> dtoList = getDbMgr().cercaXmlDaImportare();
			
			log.debug("RECUPERO IL FILE DA MTOM");
//			indexFile = getServiziMgr().mtomDownloadFileNewVTD(uidIndex);
			//indexFile = getServiziMgr().mtomDownloadFileNew3(uidIndex); // FUNZIONA
			//indexFile = getServiziMgr().mtomDownloadFileNew4(uidIndex); // FUNZIONA
			UTENZEDISTComunicazione indexFile = getServiziMgr().mtomDownloadFile(uidIndex);
			
			if (indexFile != null && indexFile.getDatiFornituraCliente() != null && indexFile.getDatiFornituraCliente().size() > 0)
			{
				listForniture = indexFile.getDatiFornituraCliente();
			}
			log.debug("HO RECUPERATO IL FILE DA MTOM");
			
		}
		catch (ServiceException ex)
		{
			throw new ManagerException(ex, ex.getMsg());

		}
		
		log.debug("[SigitbatchMgr::getFileDistribDaImportare] END");

		return listForniture;

	}
	
	/*
	public void gestisciInvioMailImportOK(SigitTImportDto sigitTImportDto, byte[] thePdfAllegato, String avviso) throws ManagerException
	{
		log.debug("[SigitbatchMgr::gestisciInvioMailImportOK] BEGIN");
		
		try {
			log.debug("[SigitbatchMgr::gestisciInvioMailImportOK] Gestisco mail OK allegato");

			// Prendo l'oggetto aggiornato
			sigitTImportDto = getDbMgr().cercaImportById(sigitTImportDto.getIdImport());
			
			sigitTImportDto.setDataFine(DateUtil.getSqlDataCorrente());
			sigitTImportDto.setFlgEsito(ConvertUtil.convertToBigDecimal(Constants.ID_OK));
			
			String mailPfImport = getDbMgr().cercaMailPfImportatore(sigitTImportDto.getIdImport());
			String mailPgAllegato = getDbMgr().cercaMailPersonaGiuridicaById(sigitTImportDto.getFkPersonaGiuridica());
			
			log.debug("Stampo l'ID allegato: "+sigitTImportDto.getFkAllegato());
			ArrayList<String> emailList = new ArrayList<String>();
			
			if (GenericUtil.isNotNullOrEmpty(mailPfImport))
			{
				emailList.add(mailPfImport);
			}

			if (GenericUtil.isNotNullOrEmpty(mailPgAllegato))
			{

				emailList.add(mailPgAllegato);
			}

			if (emailList.size() > 0)
			{
				
				byte[] thePdfRicevuta = showRicevutaAllegato(sigitTImportDto.getFkAllegato());
				
				
				SigitVRicercaAllegatiDto allegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(sigitTImportDto.getFkAllegato());
				
				if (inviaMailFileImportCorretto(emailList, allegato, sigitTImportDto.getNomeFileImport(), thePdfAllegato, thePdfRicevuta, avviso))
				{
					// Se l'invio della mail è andato correttamente (almeno un indirizzo), aggiorno il dato
					sigitTImportDto.setDataInvioMailManut(DateUtil.getSqlDataCorrente());
				}
			}

			getDbMgr().modificaImport(sigitTImportDto);
			
		}
		catch (DbManagerException ex)
		{
			
			log.error(ex);
			throw ex;
		}
		catch (ServiceException ex)
		{
			
			log.error(ex);
			throw ex;
		}
		log.debug("[SigitbatchMgr::gestisciInvioMailImportOK] END");


	}
	*/
	
	@Transactional
	public void gestisciErroreAllegato(SigitTImportDto sigitTImportDto, String codErrorMsg) throws ManagerException
	{
		log.debug("[SigitbatchMgr::gestisciErroreAllegato] BEGIN");

		try {
			log.debug("[SigitbatchMgr::gestisciErroreAllegato] Gestisco errore allegato");

			String msg = GenericUtil.getStringaParametro(codErrorMsg, sigitTImportDto.getNomeFileImport()); 

			
			
			// Recupero nuovamento l'ID Import, perchè nella validazione potrebbe essere stato inserito l'fk_persona_giuridica
			
			
			// Prendo l'oggetto aggiornato
			sigitTImportDto = getDbMgr().cercaImportById(sigitTImportDto.getIdImport());
			
			// Setto i parametri per l'import fallito
			sigitTImportDto.setMsgErrore(msg);
			sigitTImportDto.setDataFine(DateUtil.getSqlDataCorrente());
			sigitTImportDto.setFlgEsito(ConvertUtil.convertToBigDecimal(Constants.ID_KO));
			
			String mailPfImport = getDbMgr().cercaMailPfImportatore(sigitTImportDto.getIdImport());
			String mailPgAllegato = getDbMgr().cercaMailPersonaGiuridicaById(sigitTImportDto.getFkPersonaGiuridica());

			log.debug("Stampo l'ID allegato: "+sigitTImportDto.getFkAllegato());
			ArrayList<String> emailList = new ArrayList<String>();
			
			if (GenericUtil.isNotNullOrEmpty(mailPfImport))
			{
				emailList.add(mailPfImport);
			}
			
			if (GenericUtil.isNotNullOrEmpty(mailPgAllegato))
			{
				emailList.add(mailPgAllegato);
			}
						
			if (emailList.size() > 0)
			{
				if (inviaMailFileImportErrato(emailList, sigitTImportDto.getNomeFileImport(), msg))
				{
					// Se l'invio della mail è andato correttamente (almeno un indirizzo), aggiorno il dato
					sigitTImportDto.setDataInvioMailManut(DateUtil.getSqlDataCorrente());
				}
			}
			
			getDbMgr().modificaImport(sigitTImportDto);
			
		}
		catch (DbManagerException ex)
		{
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			log.error(ex);
			throw ex;

		}
		catch (ServiceException ex)
		{
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			log.error(ex);
			throw ex;
		}
		log.debug("[SigitbatchMgr::gestisciErroreAllegato] END");


	}
	
	public void gestisciCancellazioneImportDistributori() throws ServiceException
	{
		log.debug("[SigitbatchMgr::gestisciCancellazioneImportDistributori] BEGIN");

		try {

			getDbMgr().cancellaSigitTRifCatastByImportDistribCanc();
			
			getDbMgr().cancellaSigitTDatoDistribByImportDistribCanc();;
			
		}
		catch (DbManagerException ex)
		{
			// E' DA GESTIRE
			log.error(ex);
			new ServiceException(new Message("Si e' verificato un errore nella cancellazione degli import: "+ex.getMessage()));
		}
		
		log.debug("[SigitbatchMgr::gestisciCancellazioneImportDistributori] END");


	}
	
	
	
	private boolean inviaMailFileImportErrato(ArrayList<String> emailListDest, String nomeFile, String msg) throws ServiceException
	{
		log.debug("[SigitbatchMgr::inviaMailFileImportErrato] START");
		
		log.debug("emailListDest: " + emailListDest);
		try {
			String oggetto = "CIT import massivo: fallito  caricamento file " + nomeFile;
			StringBuffer testoHtml = new StringBuffer();
			
			testoHtml.append("Import dell'allegato " + nomeFile);
			testoHtml.append(" e' fallito per il seguente motivo: </BR>");
			testoHtml.append(msg);
			testoHtml.append("</BR></BR>N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa email.");
			
			log.debug("TESTO: \n"+testoHtml);

			return getServiziMgr().sendMail(emailListDest, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		} catch (ServiceException e) {
			log.error("Errore invio email nomina terzo responsabile", e);
			throw e;
		}
		finally
		{
			log.debug("[SigitbatchMgr::inviaMailFileImportErrato] END");
		}

	}
	
	
	private boolean inviaMailFileImportCorretto(ArrayList<String> emailListDest, SigitVRicercaAllegatiDto vAllegato, String nomeFile, byte[] allegatoFile, byte[] ricevutaFile, String avviso) throws ServiceException
	{
		log.debug("[SigitbatchMgr::inviaMailFileImportCorretto] START");
		
		log.debug("desctinatari: " + emailListDest);
		
		try {
			
			String ubicazione = MapDto.getIndirizzoCompleto(vAllegato.getComuneImpianto(), vAllegato.getIndirizzoUnitaImmob(), null, vAllegato.getCivicoUnitaImmob(), vAllegato.getSiglaProvImpianto());
//			String codiceBollino = null;
//			if(GenericUtil.isNotNullOrEmpty(vAllegato.getFkNumeroBollino()))
//			{
//				codiceBollino = vAllegato.getFkSiglaBollino() + "-" + vAllegato.getFkNumeroBollino();
//			}
			
			
			String oggetto = "CIT import massivo: avvenuto caricamento file " + nomeFile;
			StringBuffer testoHtml = new StringBuffer();
			
			testoHtml.append("Import dell'allegato " + nomeFile + " avvenuto con successo. </BR></BR> ");
			testoHtml.append("Descrizione impianto<BR/>");

			testoHtml.append("Codice impianto: " + vAllegato.getCodiceImpianto() + "<BR/>");

			testoHtml.append("Localizzazione: " + ubicazione + "<BR/>");
			
			if (avviso != null)
			{
				testoHtml.append(avviso + "<BR/>");
			}

			testoHtml.append("<BR/>");

			testoHtml.append("</BR></BR>N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa email.");

			
			String nomeAllegato = getNomeAllegato(vAllegato.getFkTipoDocumento(), 
					vAllegato.getCodiceImpianto(), vAllegato.getDataControllo(), vAllegato.getIdAllegato());
			
			String nomeAllegatoRicevuta = getNomeAllegatoRicevuta(vAllegato.getFkTipoDocumento(), 
					vAllegato.getCodiceImpianto(), vAllegato.getDataControllo(), vAllegato.getIdAllegato());
			
			Hashtable<String, ByteArrayOutputStream> attachmentList = new Hashtable<String, ByteArrayOutputStream>();

			ByteArrayOutputStream outStreamAllPDF = new ByteArrayOutputStream();
			outStreamAllPDF.write(allegatoFile);

			ByteArrayOutputStream outStreamRicPDF = new ByteArrayOutputStream();
			outStreamRicPDF.write(ricevutaFile);
			
			attachmentList.put(nomeAllegato, outStreamAllPDF);
			attachmentList.put(nomeAllegatoRicevuta, outStreamRicPDF);

			log.debug("TESTO: \n"+testoHtml);
			return getServiziMgr().sendMail(emailListDest, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()), attachmentList);
		} catch (ServiceException e) {
			log.error("Errore invio email", e);
			throw e;
		}
		catch (IOException e) {
			log.error("Errore invio email", e);
			throw new ServiceException(new Message("Errore invio email - IOException"));
		}
		finally
		{
			log.debug("[SigitbatchMgr::inviaMailFileImportCorretto] END");
		}
	}
	
	private boolean inviaMailFileImportDistribCorretto(String emailDest, List<SigitTLogDistribDto> dtoErrorList, String nomeFile, byte[] thePdfRicevuta) throws ServiceException
	{
		log.debug("[SigitbatchMgr::inviaMailFileImportDistribCorretto] START");
		
		log.debug("desctinatario: " + emailDest);
		try {
			
			String oggetto = "CIT import dati distributori: avvenuto caricamento file " + nomeFile;
			StringBuffer testoHtml = new StringBuffer();
			
			testoHtml.append("Import dell'allegato " + nomeFile + " avvenuto con successo. </BR></BR> ");

			if (dtoErrorList != null && dtoErrorList.size() > 0)
			{
				testoHtml.append("Errori riscontrati: </BR> ");

				for (SigitTLogDistribDto error : dtoErrorList) {
					
					testoHtml.append(error.getMsgErrore() + "</BR>");
				}
			}
			
			testoHtml.append("</BR></BR>N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa email.");

			Hashtable<String, ByteArrayOutputStream> attachmentList = new Hashtable<String, ByteArrayOutputStream>();

			ByteArrayOutputStream outStreamRicPDF = new ByteArrayOutputStream();
			outStreamRicPDF.write(thePdfRicevuta);
			
//			InputStream inputStreamRicPDF = new ByteArrayInputStream(thePdfRicevuta); 
			
			
			int posEstens = nomeFile.toUpperCase().lastIndexOf(".XML");
			nomeFile = nomeFile.substring(0,posEstens);
			
			attachmentList.put(nomeFile+"_ricevuta.pdf", outStreamRicPDF);

			ArrayList<String> emailList = new ArrayList<String>();
			emailList.add(emailDest);
				
			return getServiziMgr().sendMail(emailList, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()), attachmentList);
		} catch (ServiceException e) {
			log.error("Errore invio email", e);
			throw e;
		}
		catch (IOException e) {
			log.error("Errore invio email", e);
			throw new ServiceException(new Message("Errore invio email - IOException"));
		}
		finally
		{
			log.debug("[SigitbatchMgr::inviaMailFileImportDistribCorretto] END");
		}
	}
	
	private void inviaMailAssistenza(List<SigitTImportDto> dtoList, String dataInizioElaborazione) throws ManagerException
	{
		log.debug("[SigitbatchMgr::inviaMailAssistenza] START");
		
		log.debug("dtoList: " + dtoList);
		try {
			
			String dataElaborazione = DateUtil.getDataCorrenteFormat();
			String oggetto = "CIT import massivo: report " + dataElaborazione;
			
			int countOk = 0;
			
			StringBuffer testoHtmlKo = new StringBuffer();
			//StringBuffer testoTxtKo =  new StringBuffer();
			
			for (SigitTImportDto dto : dtoList) {
				
				if (dto.getFlgEsito() != null)
				{
					
					if (ConvertUtil.convertToInteger(dto.getFlgEsito()).intValue() == Constants.ID_KO)
					{
						
						testoHtmlKo.append("<BR>");
						testoHtmlKo.append("IdImport: "+dto.getIdImport()+"<BR>");
						testoHtmlKo.append("Data inizio: "+dto.getDataInizio()+"<BR>");
						testoHtmlKo.append("Data fine: "+dto.getDataFine()+"<BR>");
						testoHtmlKo.append("Codice Impianto: "+dto.getCodiceImpianto()+"<BR>");
						testoHtmlKo.append("IdPreImport: "+dto.getFkPreImport()+"<BR>");
						testoHtmlKo.append("Messaggio: "+dto.getMsgErrore()+"<BR>");
						testoHtmlKo.append("Data invio mail manut: "+(dto.getDataInvioMailManut()!=null?dto.getDataInvioMailManut():"")+"<BR>");
						testoHtmlKo.append("<BR>");

						
//						testoTxtKo.append("IdImport: "+dto.getIdImport()+"\n");
//						testoTxtKo.append("Data inizio: "+dto.getDataInizio()+"\n");
//						testoTxtKo.append("Data fine: "+dto.getDataFine()+"\n");
//						testoTxtKo.append("Codice Impianto: "+dto.getCodiceImpianto()+"\n");
//						testoTxtKo.append("IdPreImport: "+dto.getFkPreImport()+"\n");
//						testoTxtKo.append("Messaggio: "+dto.getMsgErrore()+"\n");
//						testoTxtKo.append("Dat invio manut: "+dto.getDataInvioMailManut()+"\n");

					}
					else
					{
						
							countOk++;
						
					}
					
				}
				else
				{
					// Forse devo gestire il caso che non ci sia l'esito, non dovrebbe succedere
				}
				
			}
			
//			String codiceBollino = null;
//			if(GenericUtil.isNotNullOrEmpty(vAllegato.getFkNumeroBollino()))
//			{
//				codiceBollino = vAllegato.getFkSiglaBollino() + "-" + vAllegato.getFkNumeroBollino();
//			}
			
			
			
			StringBuffer testoHtml = new StringBuffer();
			//StringBuffer testoTxt =  new StringBuffer();
			
			
			testoHtml.append("ESITO ELABORAZIONE DEL "+dataElaborazione+"<BR><BR>");
			
			//String totImport = dtoList != null?ConvertUtil.convertToString(dtoList.size()):"ERRORE - NESSUN RISULTATO RITORNATO";
			testoHtml.append("Data inizio elaborazione: "+dataInizioElaborazione+"<BR>");
			testoHtml.append("Data fine elaborazione: "+DateUtil.getDataCorrenteCompletaFormat()+"<BR>");

			testoHtml.append("Totale import: "+dtoList.size()+"<BR>");
			testoHtml.append("Totale import OK: "+countOk+"<BR>");
			testoHtml.append("Totale import KO: "+(dtoList.size()-countOk)+"<BR>");
			
			if (testoHtmlKo.length() > 0)
			{
				// Esistono degli import KO
				testoHtml.append("<BR><BR>Dettaglio import KO<BR>");
				
				testoHtml.append(testoHtmlKo);
				//testoTxt.append(testoTxtKo);
				
			}
			
			String mailDest = getDbMgr().cercaConfigValueCarattere(Constants.BATCH_MAIL_IND_DEST);

			
			log.debug("TESTO: \n"+testoHtml);
			getServiziMgr().sendMail(mailDest, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		} 
		catch (DbManagerException e)
		{
			log.error("Errore recupero indirizzo email assistenza", e);
			throw e;
		}
		catch (ServiceException e) {
			log.error("Errore invio email", e);
			throw e;
		}
		
		log.debug("[SigitbatchMgr::inviaMailAssistenza] END");

	}

	private void inviaMailAssistenzaDistrib(List<SigitTImportDistribDto> dtoList, String dataInizioElaborazione) throws ManagerException
	{
		log.debug("[SigitbatchMgr::inviaMailAssistenzaDistrib] START");

		log.debug("dtoList: " + dtoList);
		try {

			String dataElaborazione = DateUtil.getDataCorrenteFormat();
			String oggetto = "CIT import dati distributori " + dataElaborazione;

			StringBuffer testoHtml = new StringBuffer();
			//StringBuffer testoTxtKo =  new StringBuffer();
			testoHtml.append("ESITO ELABORAZIONE DEL "+dataElaborazione+"<BR><BR>");

			for (SigitTImportDistribDto dto : dtoList) {


				testoHtml.append("<BR>---------------------------------------------<BR>");
				testoHtml.append("IdImport: "+dto.getIdImportDistrib()+"<BR>");
				testoHtml.append("Nome file: "+dto.getNomeFileImport()+"<BR>");
				testoHtml.append("Tot record elaborati: "+dto.getTotRecordElaborati()+"<BR>");
				testoHtml.append("Tot record scartati: "+dto.getTotRecordScartati()+"<BR>");

				List<SigitTLogDistribDto> dtoErrorList = getDbMgr().cercaSigitTLogDistribByIdImportDistrib(dto.getIdImportDistrib());

				if (dtoErrorList != null && dtoErrorList.size() > 0)
				{
					testoHtml.append("Errori riscontrati: </BR> ");

					for (SigitTLogDistribDto error : dtoErrorList) {

						testoHtml.append(error.getMsgErrore() + "</BR>");
					}
					testoHtml.append("</BR>");
				}


			}

			//String totImport = dtoList != null?ConvertUtil.convertToString(dtoList.size()):"ERRORE - NESSUN RISULTATO RITORNATO";
			testoHtml.append("<BR><BR>Data inizio elaborazione: "+dataInizioElaborazione+"<BR>");
			testoHtml.append("Data fine elaborazione: "+DateUtil.getDataCorrenteCompletaFormat()+"<BR>");


			String mailDest = getDbMgr().cercaConfigValueCarattere(Constants.BATCH_MAIL_IND_DEST);

			log.debug("TESTO: \n"+testoHtml);
			getServiziMgr().sendMail(mailDest, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		} 
		catch (DbManagerException e)
		{
			log.error("Errore recupero indirizzo email assistenza", e);
			throw e;
		}
		catch (ServiceException e) {
			log.error("Errore invio email", e);
			throw e;
		}

		log.debug("[SigitbatchMgr::inviaMailAssistenzaDistrib] END");

	}

	public void inviaMailAssistenzaCancellaDistrib(String msgError) throws ManagerException
	{
		log.debug("[SigitbatchMgr::inviaMailAssistenzaCancellaDistrib] START");

		log.debug("msgError: " + msgError);
		try {

			String dataElaborazione = DateUtil.getDataCorrenteFormat();
			String oggetto = "CIT cancellazione import dati distributori " + dataElaborazione + " - " + (msgError!=null?"KO":"OK");

			StringBuffer testoHtml = new StringBuffer();
			//StringBuffer testoTxtKo =  new StringBuffer();

			if (msgError != null)
			{
				testoHtml.append("Eccezione ricevuta: <BR>");
				testoHtml.append(msgError);
			}

			String mailDest = getDbMgr().cercaConfigValueCarattere(Constants.BATCH_MAIL_IND_DEST);

			log.debug("TESTO: \n"+testoHtml);
			getServiziMgr().sendMail(mailDest, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		} 
		catch (DbManagerException e)
		{
			log.error("Errore recupero indirizzo email assistenza", e);
			throw e;
		}
		catch (ServiceException e) {
			log.error("Errore invio email", e);
			throw e;
		}

		log.debug("[SigitbatchMgr::inviaMailAssistenzaCancellaDistrib] END");

	}
	
	private boolean inviaMailFileImportDistribErrato(String emailDest, String nomeFile, String msg) throws ManagerException
	{
		log.debug("[SigitbatchMgr::inviaMailFileImportDistribErrato] START");
		
		log.debug("emailDest: " + emailDest);
		try {
			String oggetto = "CIT import dati distributori: fallito  caricamento file " + nomeFile;
			StringBuffer testoHtml = new StringBuffer();
			
			testoHtml.append("Import dell'allegato " + nomeFile);
			testoHtml.append(" e' fallito per il seguente motivo: </BR>");
			testoHtml.append(msg);
			testoHtml.append("</BR></BR>N.B. Questo e' un messaggio inviato automaticamente. Si prega di non rispondere a questa email.");

			
			log.debug("TESTO: \n"+testoHtml);
			return getServiziMgr().sendMail(emailDest, oggetto, testoHtml.toString(), GenericUtil.getStringaTxtToHtml(testoHtml.toString()));
		} catch (ServiceException e) {
			log.error("Errore invio email import distributore", e);
			throw e;
		}
		finally
		{
			log.debug("[SigitbatchMgr::inviaMailFileImportDistribErrato] END");
		}
	}
	
	public boolean invioSvegliaUtenteAttivo(
			String emailDest,
			String codiceFiscale,
			List<SigitTVerificaDto> sveglieVerifiche,
			List<SigitTAccertamentoDto> sveglieAccertamento,
			List<SigitTIspezione2018ByCodiceFiscaleDto> sveglieIspezione2018,
			List<SigitTSanzioneDto> sveglieSanzioni
			) throws ManagerException
	{
		
		log.debug("[SigitbatchMgr::invioSvegliaUtenteAttivo] START");
		
		log.debug("emailDest: " + emailDest);
		try {
			String oggetto = "CIT: MEMO Sveglie";
			StringBuffer testoHtml = new StringBuffer();
			
			testoHtml.append("Qui di seguito le sveglie assegnate all' utente ");
			testoHtml.append(codiceFiscale);
			testoHtml.append(" scadute o in scadenza.<BR>");
			
			for (SigitTVerificaDto verifica : sveglieVerifiche ) {
				testoHtml.append("VERIFICA-");
				testoHtml.append(ConvertUtil.convertToString(verifica.getIdVerifica()));
				testoHtml.append(" -> ");
				testoHtml.append(ConvertUtil.convertToString(verifica.getDtSveglia()));
				testoHtml.append(" - " + verifica.getNoteSveglia()+"<BR>");
			}
			
			for (SigitTAccertamentoDto accertamento : sveglieAccertamento ) {
				testoHtml.append("ACCERTAMENTO-");
				testoHtml.append(ConvertUtil.convertToString(accertamento.getIdAccertamento()));
				testoHtml.append(" -> ");
				testoHtml.append(ConvertUtil.convertToString(accertamento.getDtSveglia()));
				testoHtml.append(" - " + accertamento.getNoteSveglia()+"<BR>");
			}
			
			for (SigitTIspezione2018ByCodiceFiscaleDto ispezione2018 : sveglieIspezione2018 ) {
				testoHtml.append("ISPEZIONE-");
				testoHtml.append(ConvertUtil.convertToString(ispezione2018.getIs_2018IdIspezione2018()));
				testoHtml.append(" -> ");
				testoHtml.append(ConvertUtil.convertToString(ispezione2018.getIs_2018DtSveglia()));
				testoHtml.append(" - " + ispezione2018.getIs_2018NoteSveglia()+"<BR>");
			}
			
			for (SigitTSanzioneDto sanzione : sveglieSanzioni ) {
				testoHtml.append("SANZIONE-");
				testoHtml.append(ConvertUtil.convertToString(sanzione.getIdSanzione()));
				testoHtml.append(" -> ");
				testoHtml.append(ConvertUtil.convertToString(sanzione.getDtSveglia()));
				testoHtml.append(" - " + sanzione.getNoteSveglia()+"<BR>");
			}
			
			
			String testoTxt = GenericUtil.getStringaTxtToHtml(testoHtml.toString());
			
			log.debug("TESTO: \n" + testoTxt);
			return getServiziMgr().sendMail(emailDest, oggetto, testoHtml.toString(), testoTxt);
		} catch (ServiceException e) {
			log.error("Errore invio email sveglia utente attivo" + emailDest, e);
			throw e;
		}
		finally
		{
			log.debug("[SigitbatchMgr::invioSvegliaUtenteAttivo] END");
		}
	}
		
	public List<String> invioSveglieUtentiNonAttivi(String oggetto, String tipoSveglia, List<?> sveglie) throws Exception {
		
		log.debug("[SigitbatchMgr::invioSveglieUtentiNonAttivi("+tipoSveglia+")] START");
		List<String> errors = new ArrayList<String>();
		try {
			
			Integer idRuoloPa = null;
			String instatAbilitazione = null;
			String mailComunicazione = null;
			
			StringBuffer testoHtml = new StringBuffer();
			for (int i = 0; i < sveglie.size(); i++) {
				Integer idRuoloPaCorrente = null;
				String istatAbilitazioneCorrente = "";
				String mailComunicazioneCorrente = "";
				Integer idSveglia = null;
				String denomUtenteCaricamento = "";
				String cfUtenteCaricamento = "";
				Date dtSveglia = null;
				String noteSveglia = "";
				Object sveglia = sveglie.get(i);
				String messaggioIntestazione = "";
				
				if (sveglia instanceof SigitTVerificaByUtentiNonAttiviDto) {
					SigitTVerificaByUtentiNonAttiviDto svegliaVerifica = (SigitTVerificaByUtentiNonAttiviDto) sveglia;
					idRuoloPaCorrente = svegliaVerifica.getAIdRuoloPa();
					istatAbilitazioneCorrente = svegliaVerifica.getAIstatAbilitazione();
					mailComunicazioneCorrente = svegliaVerifica.getAMailComunicazione();
					idSveglia = svegliaVerifica.getVIdVerifica();
					denomUtenteCaricamento = svegliaVerifica.getVDenomUtenteCaricamento();
					cfUtenteCaricamento = svegliaVerifica.getVCfUtenteCaricamento();
					dtSveglia = svegliaVerifica.getVDtSveglia();
					noteSveglia = svegliaVerifica.getVNoteSveglia();
					messaggioIntestazione = "VERIFICHE assegnate";
				}
				else if (sveglia instanceof SigitTAccertamentoByUtentiNonAttiviDto) {
					SigitTAccertamentoByUtentiNonAttiviDto svegliaAccertamento = (SigitTAccertamentoByUtentiNonAttiviDto) sveglia;
					idRuoloPaCorrente = svegliaAccertamento.getAIdRuoloPa();
					istatAbilitazioneCorrente = svegliaAccertamento.getAIstatAbilitazione();
					mailComunicazioneCorrente = svegliaAccertamento.getAMailComunicazione();
					idSveglia = svegliaAccertamento.getAccIdAccertamento();
					denomUtenteCaricamento = svegliaAccertamento.getAccDenomUtenteAssegn();
					cfUtenteCaricamento = svegliaAccertamento.getAccCfUtenteAssegn();
					dtSveglia = svegliaAccertamento.getAccDtSveglia();
					noteSveglia = svegliaAccertamento.getAccNoteSveglia();
					messaggioIntestazione = "ACCERTAMENTI assegnati";
				}
				else if (sveglia instanceof SigitTIspezione2018ByUtentiNonAttiviDto) {
					SigitTIspezione2018ByUtentiNonAttiviDto svegliaIspezione2018 = (SigitTIspezione2018ByUtentiNonAttiviDto) sveglia;
					idRuoloPaCorrente = svegliaIspezione2018.getAIdRuoloPa();
					istatAbilitazioneCorrente = svegliaIspezione2018.getAIstatAbilitazione();
					mailComunicazioneCorrente = svegliaIspezione2018.getAMailComunicazione();
					idSveglia = svegliaIspezione2018.getTIdIspezione2018();
					denomUtenteCaricamento = svegliaIspezione2018.getVNome() + " " + svegliaIspezione2018.getVCognome();
					cfUtenteCaricamento = svegliaIspezione2018.getVCodiceFiscale();
					dtSveglia = ConvertUtil.convertTimestampToDate(svegliaIspezione2018.getTDtSveglia());	
					noteSveglia = svegliaIspezione2018.getTNoteSveglia();
					messaggioIntestazione = "ISPEZIONI assegnate";
				}
				else if (sveglia instanceof SigitTSanzioneAccertamentiByUtentiNonAttiviDto) {
					SigitTSanzioneAccertamentiByUtentiNonAttiviDto svegliaSanzioneAccertamento = (SigitTSanzioneAccertamentiByUtentiNonAttiviDto) sveglia;
					idRuoloPaCorrente = svegliaSanzioneAccertamento.getAIdRuoloPa();
					istatAbilitazioneCorrente = svegliaSanzioneAccertamento.getAIstatAbilitazione();
					mailComunicazioneCorrente = svegliaSanzioneAccertamento.getAMailComunicazione();
					idSveglia = svegliaSanzioneAccertamento.getSIdSanzione();
					denomUtenteCaricamento = svegliaSanzioneAccertamento.getSDenomUtResponsabile();
					cfUtenteCaricamento = svegliaSanzioneAccertamento.getSCfResponsabile();
					dtSveglia = svegliaSanzioneAccertamento.getSDtSveglia();
					noteSveglia = svegliaSanzioneAccertamento.getSNoteSveglia();
					messaggioIntestazione = "SANZIONI legate ad ACCERTAMENTI assegnate";
				}
				else if (sveglia instanceof SigitTSanzioneIspezione2018ByUtentiNonAttiviDto) {
					SigitTSanzioneIspezione2018ByUtentiNonAttiviDto svegliaSanzioneIspezione = (SigitTSanzioneIspezione2018ByUtentiNonAttiviDto) sveglia;
					idRuoloPaCorrente = svegliaSanzioneIspezione.getAIdRuoloPa();
					istatAbilitazioneCorrente = svegliaSanzioneIspezione.getAIstatAbilitazione();
					mailComunicazioneCorrente = svegliaSanzioneIspezione.getAMailComunicazione();
					idSveglia = svegliaSanzioneIspezione.getSIdSanzione();
					denomUtenteCaricamento = svegliaSanzioneIspezione.getSDenomUtResponsabile();
					cfUtenteCaricamento = svegliaSanzioneIspezione.getSCfResponsabile();
					dtSveglia = svegliaSanzioneIspezione.getSDtSveglia();
					noteSveglia = svegliaSanzioneIspezione.getSNoteSveglia();
					messaggioIntestazione = "SANZIONI legate ad ISPEZIONI assegnate";
				} else {
					throw new Exception("Classe della sveglia non valida");
				}
				
				if (i == 0) {
					idRuoloPa = idRuoloPaCorrente;
					instatAbilitazione = istatAbilitazioneCorrente;
					mailComunicazione = mailComunicazioneCorrente;
				}
				
				if (!idRuoloPaCorrente.equals(idRuoloPa) || !istatAbilitazioneCorrente.equals(instatAbilitazione) || !mailComunicazioneCorrente.equals(mailComunicazione)) {
					try {
						String testoTxt = GenericUtil.getStringaTxtToHtml(testoHtml.toString());
						log.debug("TESTO: \n" + testoTxt);
						if (!getServiziMgr().sendMail(mailComunicazione, oggetto, testoHtml.toString(), testoTxt)) {
							errors.add("Errore invio sveglia "+ tipoSveglia +" per utenti non attivi a " + mailComunicazione);
						}
					} catch (ServiceException e) {
						errors.add("Errore invio sveglia "+ tipoSveglia +" per utenti non attivi a " + mailComunicazione +" : " + e.getMessage());;
					}
					
					idRuoloPa = idRuoloPaCorrente;
					instatAbilitazione = istatAbilitazioneCorrente;
					mailComunicazione = mailComunicazioneCorrente;
					
					log.debug("TESTO mail sveglia "+ tipoSveglia +": \n"+testoHtml);
					
					testoHtml = new StringBuffer();
					testoHtml.append("Qui di seguito le sveglie su ");
					testoHtml.append(messaggioIntestazione);
					testoHtml.append(" ad utenti non piu' attivi scadute o in scadenza.<BR>");
				}
				
				if (testoHtml.length() == 0) {
					testoHtml.append("Qui di seguito le sveglie su ");
					testoHtml.append(messaggioIntestazione);
					testoHtml.append(" ad utenti non piu' attivi scadute o in scadenza.<BR>");
				}
				
				testoHtml.append(tipoSveglia + "-");
				testoHtml.append(ConvertUtil.convertToString(idSveglia));
				testoHtml.append(" -> ");
				testoHtml.append(denomUtenteCaricamento != null ? denomUtenteCaricamento : " ");
				testoHtml.append(" (" + cfUtenteCaricamento + ")");
				testoHtml.append(" -> ");
				testoHtml.append(ConvertUtil.convertToString(dtSveglia));
				testoHtml.append(" - ");
				testoHtml.append(noteSveglia + "<BR>");
			}
			try {
				String testoTxt = GenericUtil.getStringaTxtToHtml(testoHtml.toString());
				log.debug("TESTO: \n" + testoTxt);
				if (!getServiziMgr().sendMail(mailComunicazione, oggetto, testoHtml.toString(), testoTxt)) {
					errors.add("Errore invio sveglia "+ tipoSveglia +" per utenti non attivi a " + mailComunicazione);
				}
			} catch (ServiceException e) {
				errors.add("Errore invio sveglia "+ tipoSveglia +" per utenti non attivi a " + mailComunicazione +" : " + e.getMessage());;
			}
		} catch (Exception e) {
			log.error("Errore invio email sveglia utente non attivo");
			throw e;
		}
		finally
		{
			log.debug("[SigitbatchMgr::invioSveglieUtentiNonAttivi("+tipoSveglia+")] END");
		}
		return errors; 
	}
	
	public List<String >invioSvegliaInterventiImpianto(List<String> emailsSveglia, SigitVRicercaAllegatiDto impianto, String elencoCompAttivi) throws Exception {
		log.debug("[SigitbatchMgr::invioSvegliaInterventiImpianto] START");
		List<String> errors = new ArrayList<String>();
		try {
				String oggetto = "CIT: MEMO Scadenza intervento sull’impianto termico";
				StringBuffer testoHtml = new StringBuffer();
				
				testoHtml.append("Con la presente si informa che per l' impianto ");
				testoHtml.append(ConvertUtil.convertToString(impianto.getCodiceImpianto()));
				testoHtml.append("<BR>Ubicato in ");
				testoHtml.append(impianto.getIndirizzoUnitaImmob());
				testoHtml.append(" , ");
				testoHtml.append(impianto.getCivicoUnitaImmob());
				testoHtml.append(" ");
				testoHtml.append(impianto.getComuneImpianto());
				testoHtml.append(" ");
				testoHtml.append(impianto.getSiglaProvImpianto());
				testoHtml.append("<BR>in base a quanto dichiarato dal manutentore nel corso dell' ultimo controllo");
				testoHtml.append("<BR>data controllo: ");
				testoHtml.append(ConvertUtil.convertToString(impianto.getDataControllo()));
				testoHtml.append(" tipo controllo: ");
				testoHtml.append(impianto.getDesTipoManutenzione());
				testoHtml.append("<BR>si raccomanda un intervento per le apparecchiature ");
				testoHtml.append(elencoCompAttivi);
				testoHtml.append("<BR>entro ");
				testoHtml.append(ConvertUtil.convertToString(impianto.getFInterventoEntro()));
				testoHtml.append("<BR><BR>Nel caso in cui l'intervento sulle apparecchiature "
					+ "sia già stato eseguito (prima della data di scadenza sopra indicata), "
					+ "si prega di non considerare questo messaggio. ");
				
				for (String email : emailsSveglia) {
					
					// Verifico che l'indirizzo mail non sia nullo o vuoto
					if (GenericUtil.isNotNullOrEmpty(email))
					{
						try {
							String testoTxt = GenericUtil.getStringaTxtToHtml(testoHtml.toString());
							log.debug("TESTO: \n" + testoTxt);
							if (!getServiziMgr().sendMail(email, oggetto, testoHtml.toString(), testoTxt)) {
								dbMgr.aggiornaAllegatoPerMancatoInvioMail(impianto.getIdAllegato());
								errors.add("Errore invio sveglia  interventi impianto "+ ConvertUtil.convertToString(impianto.getCodiceImpianto()) +" per utenti non attivi a " + email);
							}
							else {
								SigitTAllegatoDto allegatoDto = getDbMgr().cercaAllegatoById(impianto.getIdAllegato());
								allegatoDto.setDtInvioMemo(ConvertUtil.convertDateToTimestamp(new Date()));
								allegatoDto.setMailInvioMemo(email);
								getDbMgr().getSigitTAllegatoDao().update(allegatoDto);
							}
						} catch (ServiceException e) {
							errors.add("Errore invio sveglia  interventi impianto "+ ConvertUtil.convertToString(impianto.getCodiceImpianto()) +" per utenti non attivi a " + email +" : " + e.getMessage());
						}
					}
				}

		} catch (Exception e) {
			log.error("Errore invio email sveglia interventi impianto");
			throw e;
		}
		finally
		{
			log.debug("[SigitbatchMgr::invioSvegliaInterventiImpianto] END");
		}
		return errors;
	}
	
	@Transactional
	public void gestisciFallimentoImportDistrib(Integer idImportDistrib, String msg) throws ManagerException
	{
		log.debug("[SigitbatchMgr::gestisciFallimentoImportDistrib] BEGIN");

		try {
			log.debug("[SigitbatchMgr::gestisciFallimentoImportDistrib] Gestisco errore allegato");

			// recupero l'elemento aggiornato
			SigitTImportDistribDto sigitTImportDistribDto = getDbMgr().cercaSigitTImportDistribById(idImportDistrib);
			
			String mailPgImport = getDbMgr().cercaMailPersonaGiuridicaById(sigitTImportDistribDto.getFkPersonaGiuridica());

			if (GenericUtil.isNotNullOrEmpty(mailPgImport))
			{

				if (inviaMailFileImportDistribErrato(mailPgImport, sigitTImportDistribDto.getNomeFileImport(), msg))
				{

					sigitTImportDistribDto.setDataInvioMailDistrib(DateUtil.getSqlDataCorrente());
					getDbMgr().aggiornaImportDistribInvioMailDistr(idImportDistrib);
				}

			}
		}
		catch (DbManagerException ex)
		{
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			log.error(ex);
			throw ex;

		}
		catch (ServiceException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.error("Errore invio email", e);
			throw e;
		}

		log.debug("[SigitbatchMgr::gestisciFallimentoImportDistrib] END");


	}
	
	public void gestisciAvvenutoImportDistrib(Integer idImportDistrib)
	{
		log.debug("[SigitbatchMgr::gestisciAvvenutoImportDistrib] BEGIN");

		try {
			log.debug("[SigitbatchMgr::gestisciAvvenutoImportDistrib] Gestisco errore allegato");


			// recupero l'elemento aggiornato
			SigitTImportDistribDto sigitTImportDistribDto = getDbMgr().cercaSigitTImportDistribById(idImportDistrib);
			
			String mailPgImport = getDbMgr().cercaMailPersonaGiuridicaById(sigitTImportDistribDto.getFkPersonaGiuridica());
			
			if (GenericUtil.isNotNullOrEmpty(mailPgImport))
			{
				
			
					List<SigitTLogDistribDto> dtoErrorList = getDbMgr().cercaSigitTLogDistribByIdImportDistrib(idImportDistrib);
					
					
					byte[] thePdfRicevuta = showRicevutaImportDistrib(idImportDistrib);
	
					
					if (inviaMailFileImportDistribCorretto(mailPgImport, dtoErrorList, sigitTImportDistribDto.getNomeFileImport(), thePdfRicevuta))
					{
						sigitTImportDistribDto.setDataInvioMailDistrib(DateUtil.getSqlDataCorrente());
						getDbMgr().aggiornaImportDistribInvioMailDistr(idImportDistrib);
					}
				
			}
			
			
		}
		catch (DbManagerException ex)
		{
			// Se c'è un errore non faccio niente e vado avanti
			log.error(ex);
			
		}
		catch (ServiceException ex)
		{
			
			// Se c'è un errore non faccio niente e vado avanti
			log.error(ex);
			
		}
		catch (ManagerException ex)
		{
			
			// Se c'è un errore non faccio niente e vado avanti
			log.error(ex);
			
		}
		
		log.debug("[SigitbatchMgr::gestisciAvvenutoImportDistrib] END");


	}
	
	/*
	public byte[] showRicevutaAllegato(BigDecimal idAllegato){
		log.debug("[SigitbatchMgr::showRicevutaAllegato] START");
		Applicazione app;
		Utente utente;
		XmlModel model;
		try {
			app = new Applicazione();
			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
			utente = null;
			model = getXmlRicevutaAllegato(idAllegato);
		
			return getServiziMgr().showModuloRicevutaAllegato(app,utente,model);
		
		}catch(Exception e){
			log.error(e.getMessage()+" - "+e.getMessage(),e);
			return null;
		}finally{
			log.debug("[SigitbatchMgr::showRicevutaAllegato] END");
		}
	}
	*/
	/*
	private XmlModel getXmlRicevutaAllegato(BigDecimal idAllegato){
		log.debug("[SigitbatchMgr::getXmlRicevutaAllegato] START");

		//recupero il modello xml dal documento
		XmlModel model;
		try {
			model = new XmlModel();
			byte[] xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getRicevutaAllegato(idAllegato));
			//log.debug(new String(xmlByteArray,"UTF-8"));
			model.setXmlContent(xmlByteArray);
			return model;
		}catch(Exception e){
			log.error("Errore", e);
			return null;
		} finally{
			log.debug("[SigitbatchMgr::getXmlRicevutaAllegato] END");

		}
	}
	*/
	
	public byte[] showRicevutaImportDistrib(Integer idImportDistrib){
		log.debug("[SigitbatchMgr::showRicevutaImportDistrib] START");
//		Applicazione app;
//		Utente utente;
//		XmlModel model;
		try {
//			app = new Applicazione();
//			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
//			utente = null;
//			model = getXmlRicevutaImportDistrib(idImportDistrib);
		
//			return getServiziMgr().showModuloRicevutaImportDistrib(app,utente,model);
			return getRicevutaBuilder().generaRicevutaImportDistributore(idImportDistrib);
		
		}catch(Exception e){
			log.error(e.getMessage()+" - "+e.getMessage(),e);
			return null;
		}finally{
			log.debug("[SigitbatchMgr::showRicevutaImportDistrib] END");
		}
	}
	
	/*
	private XmlModel getXmlRicevutaImportDistrib(Integer idImportDistrib){
		log.debug("[SigitbatchMgr::getXmlRicevutaImportDistrib] START");

		//recupero il modello xml dal documento
		XmlModel model;
		try {
			model = new XmlModel();
			byte[] xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getRicevutaImportDistrib(idImportDistrib));
			//log.debug(new String(xmlByteArray,"UTF-8"));
			model.setXmlContent(xmlByteArray);
			return model;
		}catch(Exception e){
			log.error("Errore", e);
			return null;
		} finally{
			log.debug("[SigitbatchMgr::getXmlRicevutaImportDistrib] END");

		}
	}
	*/
	private MODIIDocument mapToModuloAllegato1(
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument mod1Import, SigitTAllegatoDto allegatoDto, SigitTPersonaGiuridicaDto dettaglioImpresaManutentrice) throws ManagerException, SigitTTrattH2ODaoException {
		MODIIDocument modDoc = MODIIDocument.Factory.newInstance();
		it.csi.sigit.sigitwebn.xml.allegato2.data.RichiestaDocument.Richiesta richiesta = modDoc.addNewMODII().addNewRichiesta();
		modDoc.getMODII().addNewSystem().addNewCatDig().setModuloEditabile(false);
		modDoc.getMODII().getSystem().getCatDig().setBtSalva(false);
		
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = mod1Import.getMODII().getRichiesta().getDatiIntestazione();
		richiesta.addNewDatiIntestazione().setCodiceBollino(datiIntestazione.getCodiceBollino());

		richiesta.addNewDatiModulo().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
		
		AllegatoII allegato = richiesta.addNewDatiAllegato().addNewAllegatoII();

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.CheckListDocument.CheckList importCheckList = mod1Import.getMODII().getRichiesta().getDatiAllegato().getCheckList();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.ControlloImpiantoDocument.ControlloImpianto impCi = mod1Import.getMODII().getRichiesta().getDatiAllegato().getControlloImpianto();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiIdentificativiDocument.DatiIdentificativi impDi = mod1Import.getMODII().getRichiesta().getDatiAllegato().getDatiIdentificativi();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiTecnicoDocument.DatiTecnico impDt = mod1Import.getMODII().getRichiesta().getDatiAllegato().getDatiTecnico();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica impDocT = mod1Import.getMODII().getRichiesta().getDatiAllegato().getDocumentazioneTecnica();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod1Import.getMODII().getRichiesta().getDatiAllegato().getTrattamentoAcqua();
		
		java.util.Date dataControllo = datiIntestazione.getAFDataControllo().getTime();
		String codImpianto = datiIntestazione.getCodiceCatasto();
		
		//SigitTPersonaGiuridicaDto dettaglioImpresaManutentrice = getDbMgr().cercaTPersonaGiuridicaById(idPersonaG);

		List<SigitVSk4GtDto> gtAttiviInData = getDbMgr().getCompGtAttiviInData(codImpianto, dataControllo, dettaglioImpresaManutentrice.getIdPersonaGiuridica());

		
		//in questo oggetto setto il 3resonsabile (se c'è) altrimenti il responsabile (trovato sopra)
		SigitTPersonaGiuridicaDto pg = null;
		// Se il responsabile e una PG
		SigitTPersonaGiuridicaDto pgResp = null;
		// Se il responsabile e una PF
		SigitTPersonaFisicaDto pf = null;

		//in questo oggetto setto il responsabile dell'impianto
		SigitVTotImpiantoDto vTotImpiantoResp = null;

		//in questo oggetto setto il 3resonsabile (se c'è) altrimenti il responsabile (trovato sopra)
		SigitVTotImpiantoDto vTotImpianto = null;
				
		// Cerco il responsabile alla data, mi servirà nel caso non ci sia il 3Responsabile
		SigitVTotImpiantoDto responsabileImp = getDbMgr().cercaResponsabileAttivoAllaDataImpianto(codImpianto, dataControllo);

		if (responsabileImp != null)
		{
			vTotImpiantoResp = responsabileImp;

			if(vTotImpiantoResp.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
				//è una persona giuridica
				pgResp = getDbMgr().cercaTPersonaGiuridicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());

			}else{
				//è una persona fisica
				pf = getDbMgr().cercaTPersonaFisicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());
			}
			
			//idRuoloResp = ConvertUtil.convertToString(responsabile.getIdRuolo());
		} 
		
		//dati locazione impianto
		List<SigitTUnitaImmobiliareDto> unitaImmobList = getDbMgr().getUnitaImmobiliariImpianto(new Integer(codImpianto));

		SigitTTrattH2ODto dettaglioTrattAcqua = getDbMgr().getSigitTTrattH2oDao().findByPrimaryKey(new SigitTTrattH2OPk(new BigDecimal(codImpianto)));
		
		for(it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowAllegatoIIDocument.RowAllegatoII all : mod1Import.getMODII().getRichiesta().getDatiAllegato().getAllegatoII().getRowAllegatoIIList())
		{
			BigInteger progressivo = all.getAENumGT();
			SigitVSk4GtDto gt = null;
			for(SigitVSk4GtDto gtDto : gtAttiviInData)
			{
				if(gtDto.getProgressivo().intValue() == progressivo.intValue())
					gt = gtDto;
			}
			if(gt==null)
				throw new ManagerException(new Message("i gruppi termici non corrispondono"));
			
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica cve = all.getControlloVerificaEnergetica();
			it.csi.sigit.sigitwebn.xml.allegato2.data.RowAllegatoIIDocument.RowAllegatoII allegatoII = allegato.addNewRowAllegatoII();
			it.csi.sigit.sigitwebn.xml.allegato2.data.RowAllegatoIIDocument.RowAllegatoII.TabFumi tabFumi = allegatoII.addNewTabFumi();
			
			allegatoII.setCodiceCatasto(codImpianto);
			
			MapDto.mapToRowFumiII(tabFumi, all.getTabFumi().getRowFumiList());
			
			// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
			List<SigitVTotImpiantoDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(codImpianto, allegatoDto.getDataControllo(), Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToString(progressivo));
			if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
			{
//				vTotImpianto = list3RespAttiviImpianto.get(0);
//				pg = getDbMgr().cercaTPersonaGiuridicaById(vTotImpianto.getIdPersonaGiuridica3r().intValue());
				
//				getDbMgr().aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), codImpianto, 
//						Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToBigDecimal(progressivo), gt.getDataInstall(),
//						null, vTotImpianto.getIdContratto());
			}
			else
			{
				vTotImpianto = vTotImpiantoResp;
				pg = pgResp;

				getDbMgr().aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), codImpianto, 
						Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToBigDecimal(progressivo), gt.getDataInstall(),
						vTotImpianto.getIdImpRuoloPfpg(), null);
			}
			
			//responsabile
			if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty())
			{
				if(Constants.ID_RUOLO_AMMINISTRATORE == vTotImpianto.getIdRuolo().intValue() ||
						Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE == vTotImpianto.getIdRuolo().intValue())
					allegatoII.xsetAA2FlagAmministr(MapDto.getXmlBoolean(true));
				if(Constants.ID_RUOLO_OCCUPANTE == vTotImpianto.getIdRuolo().intValue() ||
						Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE == vTotImpianto.getIdRuolo().intValue())
					allegatoII.xsetAA2FlagOccupante(MapDto.getXmlBoolean(true));
				if(Constants.ID_RUOLO_PROPRIETARIO == vTotImpianto.getIdRuolo().intValue() ||
						Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO == vTotImpianto.getIdRuolo().intValue())
					allegatoII.xsetAA2FlagProprietario(MapDto.getXmlBoolean(true));
			}
			else
			{
				allegatoII.xsetAA2FlagTerzoResp(MapDto.getXmlBoolean(true));
			}
			
			GenericUtil.stampa(pf, true, 3);
			
			// dati responsabile impianto
			if(pg != null)
			{
				allegatoII.setAA2RagSociale(pg.getDenominazione());
				allegatoII.setAA2Piva(pg.getCodiceFiscale());

				if (ConvertUtil.convertToBooleanAllways(pg.getFlgIndirizzoEstero()))
				{
					allegatoII.setAA2Indirizzo(pg.getIndirizzoEstero());
					allegatoII.setAA2Comune(GenericUtil.getStringValid(pg.getCittaEstero()) + " ("+GenericUtil.getStringValid(pg.getStatoEstero())+")");
					allegatoII.setAA2Prov(null);

				}
				else
				{
					allegatoII.setAA2Prov(pg.getSiglaProv());
					allegatoII.setAA2Comune(pg.getComune());
					allegatoII.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pg.getIndirizzoSitad()) ? pg.getIndirizzoSitad() : pg.getIndirizzoNonTrovato());
				}
				
				// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
				allegatoII.setAA2Civico(pg.getCivico());

			}
			else
			{
				allegatoII.setAA2Cf(pf.getCodiceFiscale());
				allegatoII.setAA2Cognome(pf.getCognome());
				allegatoII.setAA2Nome(pf.getNome());

				if (ConvertUtil.convertToBooleanAllways(pf.getFlgIndirizzoEstero()))
				{
					allegatoII.setAA2Indirizzo(pf.getIndirizzoEstero());
					allegatoII.setAA2Comune(GenericUtil.getStringValid(pf.getCittaEstero()) + " ("+GenericUtil.getStringValid(pf.getStatoEstero())+")");
					allegatoII.setAA2Prov(null);

				}
				else
				{
					allegatoII.setAA2Prov(pf.getSiglaProv());
					allegatoII.setAA2Comune(pf.getComune());
					allegatoII.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pf.getIndirizzoSitad()) ? pf.getIndirizzoSitad() : pf.getIndirizzoNonTrovato());
				}
				
				// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
				allegatoII.setAA2Civico(pf.getCivico());
							}
			
			//impresa manutentrice
			if(dettaglioImpresaManutentrice!=null){
				
				allegatoII.setAA3RagSociale(dettaglioImpresaManutentrice.getDenominazione());
				allegatoII.setAA3Piva(dettaglioImpresaManutentrice.getCodiceFiscale());

				if (ConvertUtil.convertToBooleanAllways(dettaglioImpresaManutentrice.getFlgIndirizzoEstero()))
				{
					allegatoII.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoEstero());
					allegatoII.setAA3Comune(GenericUtil.getStringValid(dettaglioImpresaManutentrice.getCittaEstero()) + " ("+GenericUtil.getStringValid(dettaglioImpresaManutentrice.getStatoEstero())+")");
					allegatoII.setAA3Prov(null);

				}
				else
				{
					allegatoII.setAA3Prov(dettaglioImpresaManutentrice.getSiglaProv());
					allegatoII.setAA3Comune(dettaglioImpresaManutentrice.getComune());
	
					if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoSitad()))
						allegatoII.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoSitad());
					else if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoNonTrovato()))
						allegatoII.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoNonTrovato());
				}
				
				// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
				allegatoII.setAA3Civico(dettaglioImpresaManutentrice.getCivico());
			}
			
			//catasto
			MapDto.mapSezCatastoII(allegatoII, vTotImpianto, unitaImmobList);
			//gruppo termici
			allegatoII.setAFDataControllo(ConvertUtil.convertDateToXmlCalendar(dataControllo));
			allegatoII.setAENumGT(progressivo);
			allegatoII.setAECombustibile(gt.getDesCombustibile());
			allegatoII.setAEDataInstallaz(ConvertUtil.convertDateToXmlCalendar(gt.getDataInstall()));
			allegatoII.setAEFabbricante(gt.getDesMarca());
			allegatoII.setAEMatricola(gt.getMatricola());
			allegatoII.setAEModello(gt.getModello());
			//allegatoII.setAENumGT(arg0);Circuiti(ConvertUtil.convertToBigInteger(gt.getNModuli()));
			
			allegatoII.setAEPotenzaNomUtile(gt.getPotenzaTermicaKw());
			
			if(Constants.ID_DETT_GT_GRUPPO_TERM_SING.equals(ConvertUtil.convertToString(gt.getFkDettaglioGt())));{
				allegatoII.xsetAEGTsingolo(MapDto.getXmlBoolean(true));
				allegatoII.xsetAEGTModulare(MapDto.getXmlBoolean(false));
				allegatoII.xsetAETupoRadiante(MapDto.getXmlBoolean(false));
				allegatoII.xsetAEGenAriaCalda(MapDto.getXmlBoolean(false));
			}
			if(Constants.ID_DETT_GT_GRUPPO_TERM_MOD.equals(ConvertUtil.convertToString(gt.getFkDettaglioGt()))){
				allegatoII.xsetAEGTModulare(MapDto.getXmlBoolean(true));
				allegatoII.xsetAEGTsingolo(MapDto.getXmlBoolean(false));
				allegatoII.xsetAETupoRadiante(MapDto.getXmlBoolean(false));
				allegatoII.xsetAEGenAriaCalda(MapDto.getXmlBoolean(false));
			}
			if(Constants.ID_DETT_GT_TUBO_RADIANTE.equals(ConvertUtil.convertToString(gt.getFkDettaglioGt()))){
				allegatoII.xsetAETupoRadiante(MapDto.getXmlBoolean(true));
				allegatoII.xsetAEGTModulare(MapDto.getXmlBoolean(false));
				allegatoII.xsetAEGTsingolo(MapDto.getXmlBoolean(false));
				allegatoII.xsetAEGenAriaCalda(MapDto.getXmlBoolean(false));
			}
			if(Constants.ID_DETT_GT_GEN_ARIA_CALDA.equals(ConvertUtil.convertToString(gt.getFkDettaglioGt()))){
				allegatoII.xsetAEGenAriaCalda(MapDto.getXmlBoolean(true));
				allegatoII.xsetAETupoRadiante(MapDto.getXmlBoolean(false));
				allegatoII.xsetAEGTModulare(MapDto.getXmlBoolean(false));
				allegatoII.xsetAEGTsingolo(MapDto.getXmlBoolean(false));
			}
			
			MapDto.mapToVerificaEnergeticaII(allegatoII.addNewControlloVerificaEnergetica(),cve, gt);
			MapDto.mapToChecklistII(allegatoII.addNewCheckList(), importCheckList);
			MapDto.maptoControlloImpiantoII(allegatoII.addNewControlloImpianto(),impCi);
			try{allegatoII.addNewDatiIdentificativi().setAAPotenzaTermicaNomTotMax(impDi.getAAPotenzaTermicaNomTotMax());}catch(Exception e){};
			MapDto.mapToDatiTecnicoII(allegatoII.addNewDatiTecnico(),impDt);
			MapDto.mapToDocumentazioneTecnicaII(allegatoII.addNewDocumentazioneTecnica(),impDocT);
			MapDto.mapToTrattamentoAcquaII(allegatoII.addNewTrattamentoAcqua(),impTa, dettaglioTrattAcqua);
		}
		return modDoc;
	}
	
	private MODIIIDocument mapToModuloAllegato2(
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument mod2Import, SigitTAllegatoDto allegatoDto, SigitTPersonaGiuridicaDto dettaglioImpresaManutentrice) throws ManagerException, SigitTTrattH2ODaoException {
		MODIIIDocument modDoc = MODIIIDocument.Factory.newInstance();
		it.csi.sigit.sigitwebn.xml.allegato3.data.RichiestaDocument.Richiesta richiesta = modDoc.addNewMODIII().addNewRichiesta();
		modDoc.getMODIII().addNewSystem().addNewCatDig().setModuloEditabile(false);
		modDoc.getMODIII().getSystem().getCatDig().setBtSalva(false);
		
		DatiIntestazione datiIntestazione = mod2Import.getMODIII().getRichiesta().getDatiIntestazione();
		richiesta.addNewDatiIntestazione().setCodiceBollino(datiIntestazione.getCodiceBollino());

		richiesta.addNewDatiModulo().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
		
		AllegatoIII allegato = richiesta.addNewDatiAllegato().addNewAllegatoIII();

		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.CheckListDocument.CheckList importCheckList = mod2Import.getMODIII().getRichiesta().getDatiAllegato().getCheckList();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.ControlloImpiantoDocument.ControlloImpianto impCi = mod2Import.getMODIII().getRichiesta().getDatiAllegato().getControlloImpianto();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiIdentificativiDocument.DatiIdentificativi impDi = mod2Import.getMODIII().getRichiesta().getDatiAllegato().getDatiIdentificativi();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiTecnicoDocument.DatiTecnico impDt = mod2Import.getMODIII().getRichiesta().getDatiAllegato().getDatiTecnico();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica impDocT = mod2Import.getMODIII().getRichiesta().getDatiAllegato().getDocumentazioneTecnica();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod2Import.getMODIII().getRichiesta().getDatiAllegato().getTrattamentoAcqua();
		
		java.util.Date dataControllo = datiIntestazione.getAFDataControllo().getTime();
		String codImpianto = datiIntestazione.getCodiceCatasto();
		
		//SigitTPersonaGiuridicaDto dettaglioImpresaManutentrice = getImpresaManutentrice(allegatoDto.getFkImpRuoloPfpg().toString());

		List<SigitVSk4GfDto> gfAttiviInData = getDbMgr().getCompGfAttiviInData(codImpianto, dataControllo, dettaglioImpresaManutentrice.getIdPersonaGiuridica());

		//in questo oggetto setto il 3resonsabile (se c'è) altrimenti il responsabile (trovato sopra)
		SigitTPersonaGiuridicaDto pg = null;
		// Se il responsabile e una PG
		SigitTPersonaGiuridicaDto pgResp = null;
		// Se il responsabile e una PF
		SigitTPersonaFisicaDto pf = null;

		//in questo oggetto setto il responsabile dell'impianto
		SigitVTotImpiantoDto vTotImpiantoResp = null;

		//in questo oggetto setto il 3resonsabile (se c'è) altrimenti il responsabile (trovato sopra)
		SigitVTotImpiantoDto vTotImpianto = null;


		// Cerco il responsabile alla data, mi servirà nel caso non ci sia il 3Responsabile
		SigitVTotImpiantoDto responsabileImp = getDbMgr().cercaResponsabileAttivoAllaDataImpianto(codImpianto, dataControllo);

		if (responsabileImp != null)
		{
			vTotImpiantoResp = responsabileImp;

			if(vTotImpiantoResp.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
				//è una persona giuridica
				pgResp = getDbMgr().cercaTPersonaGiuridicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());

			}else{
				//è una persona fisica
				pf = getDbMgr().cercaTPersonaFisicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());
			}

		} 

		/*
		boolean isTerzoResp = false;
		SigitVTotImpiantoDto responsabile = null;
		List<SigitVTotImpiantoDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpianto(codImpianto, dataControllo);
		if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty()){
			List<SigitVTotImpiantoDto> listResp = getDbMgr().cercaResponsabiliAttiviAllaDataByCodImpianto(codImpianto, ConvertUtil.convertToString(dataControllo));
			if(listResp!=null && !listResp.isEmpty()){
				responsabile = listResp.get(0);
			}
		}else{
			responsabile = list3RespAttiviImpianto.get(0);
			isTerzoResp = true;
		}
		
		SigitTPersonaGiuridicaDto pg = null;
		SigitTPersonaFisicaDto pf = null;
		if(isTerzoResp)
			pg = getDbMgr().cercaTPersonaGiuridicaById(responsabile.getIdPersonaGiuridica3r().intValue());
		else if(responsabile.getPfPg().equals("PF"))
		{
			pf = getDbMgr().cercaTPersonaFisicaById(responsabile.getIdPersonaFisica().intValue());
		}else{
			pg = getDbMgr().cercaTPersonaGiuridicaById(responsabile.getIdPersonaFisica().intValue());
		}
		*/
		
		//dati locazione impianto
		List<SigitTUnitaImmobiliareDto> unitaImmobList = getDbMgr().getUnitaImmobiliariImpianto(new Integer(codImpianto));

		SigitTTrattH2ODto dettaglioTrattAcqua = getDbMgr().getSigitTTrattH2oDao().findByPrimaryKey(new SigitTTrattH2OPk(new BigDecimal(codImpianto)));
		
		for(RowAllegatoIII all : mod2Import.getMODIII().getRichiesta().getDatiAllegato().getAllegatoIII().getRowAllegatoIIIList())
		{
			BigInteger progressivo = all.getAENumGF();
			SigitVSk4GfDto gf = null;
			for(SigitVSk4GfDto gfDto : gfAttiviInData)
			{
				if(gfDto.getProgressivo().intValue() == progressivo.intValue())
					gf = gfDto;
			}
			if(gf==null)
				throw new ManagerException(new Message("i gruppi frigo non corrispondono"));
			
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica cve = all.getControlloVerificaEnergetica();
			it.csi.sigit.sigitwebn.xml.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII allegatoIII = allegato.addNewRowAllegatoIII();
			it.csi.sigit.sigitwebn.xml.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII.TabFumi tabFumi = allegatoIII.addNewTabFumi();
			allegatoIII.setCodiceCatasto(codImpianto);
			MapDto.mapToRowFumiIII(tabFumi, all.getTabFumi().getRowFumiList());

			// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
			List<SigitVTotImpiantoDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(codImpianto, allegatoDto.getDataControllo(), Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToString(progressivo));
			if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
			{
//				vTotImpianto = list3RespAttiviImpianto.get(0);
//				pg = getDbMgr().cercaTPersonaGiuridicaById(vTotImpianto.getIdPersonaGiuridica3r().intValue());
//				
//				getDbMgr().aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), codImpianto, 
//						Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(progressivo), gf.getDataInstall(),
//						null, vTotImpianto.getIdContratto());
			}
			else
			{
				vTotImpianto = vTotImpiantoResp;
				pg = pgResp;
				
				getDbMgr().aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), codImpianto, 
						Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToBigDecimal(progressivo), gf.getDataInstall(),
						vTotImpianto.getIdImpRuoloPfpg(), null);	
			}

			//responsabile
			if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty())
			{
				if(Constants.ID_RUOLO_AMMINISTRATORE == vTotImpianto.getIdRuolo().intValue() ||
						Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE == vTotImpianto.getIdRuolo().intValue())
					allegatoIII.xsetAA2FlagAmministr(MapDto.getXmlBoolean(true));
				if(Constants.ID_RUOLO_OCCUPANTE == vTotImpianto.getIdRuolo().intValue() ||
						Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE == vTotImpianto.getIdRuolo().intValue())
					allegatoIII.xsetAA2FlagOccupante(MapDto.getXmlBoolean(true));
				if(Constants.ID_RUOLO_PROPRIETARIO == vTotImpianto.getIdRuolo().intValue() ||
						Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO == vTotImpianto.getIdRuolo().intValue())
					allegatoIII.xsetAA2FlagProprietario(MapDto.getXmlBoolean(true));
			}
			else
			{
				allegatoIII.xsetAA2FlagTerzoResp(MapDto.getXmlBoolean(true));
			}
			
			// dati responsabile impianto
			if(pg != null)
			{
				allegatoIII.setAA2RagSociale(pg.getDenominazione());
				allegatoIII.setAA2Piva(pg.getCodiceFiscale());
				
				
				if (ConvertUtil.convertToBooleanAllways(pg.getFlgIndirizzoEstero()))
				{
					allegatoIII.setAA2Indirizzo(pg.getIndirizzoEstero());
					allegatoIII.setAA2Comune(GenericUtil.getStringValid(pg.getCittaEstero()) + " ("+GenericUtil.getStringValid(pg.getStatoEstero())+")");
					allegatoIII.setAA2Prov(null);
				}
				else
				{
					allegatoIII.setAA2Prov(pg.getSiglaProv());
					allegatoIII.setAA2Comune(pg.getComune());
					allegatoIII.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pg.getIndirizzoSitad()) ? pg.getIndirizzoSitad() : pg.getIndirizzoNonTrovato());
				}

				// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
				allegatoIII.setAA2Civico(pg.getCivico());
							}
			else
			{

				allegatoIII.setAA2Cf(pf.getCodiceFiscale());
				allegatoIII.setAA2Cognome(pf.getCognome());
				allegatoIII.setAA2Nome(pf.getNome());

				if (ConvertUtil.convertToBooleanAllways(pf.getFlgIndirizzoEstero()))
				{
					allegatoIII.setAA2Indirizzo(pf.getIndirizzoEstero());
					allegatoIII.setAA2Comune(GenericUtil.getStringValid(pf.getCittaEstero()) + " ("+GenericUtil.getStringValid(pf.getStatoEstero())+")");
					allegatoIII.setAA2Prov(null);

				}
				else
				{
				
					allegatoIII.setAA2Prov(pf.getSiglaProv());
					allegatoIII.setAA2Comune(pf.getComune());
					allegatoIII.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pf.getIndirizzoSitad()) ? pf.getIndirizzoSitad() : pf.getIndirizzoNonTrovato());
				}
				
				// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
				allegatoIII.setAA2Civico(pf.getCivico());

			}
			
			//impresa manutentrice
			if(dettaglioImpresaManutentrice!=null){
				allegatoIII.setAA3RagSociale(dettaglioImpresaManutentrice.getDenominazione());
				allegatoIII.setAA3Piva(dettaglioImpresaManutentrice.getCodiceFiscale());

				if (ConvertUtil.convertToBooleanAllways(dettaglioImpresaManutentrice.getFlgIndirizzoEstero()))
				{
					allegatoIII.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoEstero());
					allegatoIII.setAA3Comune(GenericUtil.getStringValid(dettaglioImpresaManutentrice.getCittaEstero()) + " ("+GenericUtil.getStringValid(dettaglioImpresaManutentrice.getStatoEstero())+")");
					allegatoIII.setAA3Prov(null);

				}
				else
				{

					allegatoIII.setAA3Prov(dettaglioImpresaManutentrice.getSiglaProv());
					allegatoIII.setAA3Comune(dettaglioImpresaManutentrice.getComune());
	
					if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoSitad()))
						allegatoIII.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoSitad());
					else if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoNonTrovato()))
						allegatoIII.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoNonTrovato());
				}
				
				// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
				allegatoIII.setAA3Civico(dettaglioImpresaManutentrice.getCivico());
			}
			
			//catasto
			MapDto.mapSezCatastoIII(allegatoIII, vTotImpianto, unitaImmobList);
			//gruppo frigo
			allegatoIII.setAFDataControllo(ConvertUtil.convertDateToXmlCalendar(dataControllo));
			allegatoIII.setAENumGF(progressivo);
			allegatoIII.setAECombustibile(gf.getDesCombustibile());
			allegatoIII.setAEDataInstallaz(ConvertUtil.convertDateToXmlCalendar(gf.getDataInstall()));
			allegatoIII.setAEFabbricante(gf.getDesMarca());
			allegatoIII.setAEMatricola(gf.getMatricola());
			allegatoIII.setAEModello(gf.getModello());
			allegatoIII.setAENumCircuiti(ConvertUtil.convertToBigInteger(gf.getNCircuiti()));
			
			if(Constants.ID_DETT_GF_ASS_FIAMM_COMB.equals(ConvertUtil.convertToString(gf.getFkDettaglioGf()))){
				allegatoIII.xsetAEFlagFiamma(MapDto.getXmlBoolean(true));
				allegatoIII.xsetAEFlagAssorbimento(MapDto.getXmlBoolean(false));
				allegatoIII.xsetAEFlagCompress(MapDto.getXmlBoolean(false));
			}
			else if(Constants.ID_DETT_GF_ASS_REC_CALORE.equals(ConvertUtil.convertToString(gf.getFkDettaglioGf()))){
				allegatoIII.xsetAEFlagFiamma(MapDto.getXmlBoolean(false));
				allegatoIII.xsetAEFlagAssorbimento(MapDto.getXmlBoolean(true));
				allegatoIII.xsetAEFlagCompress(MapDto.getXmlBoolean(false));
			}
			else if(Constants.ID_DETT_GF_CICLO_COMPRESS.equals(ConvertUtil.convertToString(gf.getFkDettaglioGf()))){
				allegatoIII.xsetAEFlagFiamma(MapDto.getXmlBoolean(false));
				allegatoIII.xsetAEFlagAssorbimento(MapDto.getXmlBoolean(false));
				allegatoIII.xsetAEFlagCompress(MapDto.getXmlBoolean(true));
			}
			MapDto.mapToVerificaEnergeticaIII(allegatoIII.addNewControlloVerificaEnergetica(),cve, gf);
			MapDto.mapToChecklistIII(allegatoIII.addNewCheckList(), importCheckList);
			MapDto.maptoControlloImpiantoIII(allegatoIII.addNewControlloImpianto(),impCi);
			try{allegatoIII.addNewDatiIdentificativi().setAAPotenzaTermicaNomTotMax(impDi.getAAPotenzaTermicaNomTotMax());}catch(Exception e){};
			MapDto.mapToDatiTecnicoIII(allegatoIII.addNewDatiTecnico(),impDt);
			MapDto.mapToDocumentazioneTecnicaIII(allegatoIII.addNewDocumentazioneTecnica(),impDocT);
			MapDto.mapToTrattamentoAcquaIII(allegatoIII.addNewTrattamentoAcqua(),impTa, dettaglioTrattAcqua);
		}
		return modDoc;
	}
	
	private MODIVDocument mapToModuloAllegato3(
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument mod3Import, SigitTAllegatoDto allegatoDto, SigitTPersonaGiuridicaDto dettaglioImpresaManutentrice) throws ManagerException, SigitTTrattH2ODaoException {
		MODIVDocument modDoc = MODIVDocument.Factory.newInstance();
		it.csi.sigit.sigitwebn.xml.allegato4.data.RichiestaDocument.Richiesta richiesta = modDoc.addNewMODIV().addNewRichiesta();
		modDoc.getMODIV().addNewSystem().addNewCatDig().setModuloEditabile(false);
		modDoc.getMODIV().getSystem().getCatDig().setBtSalva(false);
		
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = mod3Import.getMODIV().getRichiesta().getDatiIntestazione();
		richiesta.addNewDatiIntestazione().setCodiceBollino(datiIntestazione.getCodiceBollino());
		
		richiesta.addNewDatiModulo().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
		
		AllegatoIV allegato = richiesta.addNewDatiAllegato().addNewAllegatoIV();
		
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.CheckListDocument.CheckList importCheckList = mod3Import.getMODIV().getRichiesta().getDatiAllegato().getCheckList();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.ControlloImpiantoDocument.ControlloImpianto impCi = mod3Import.getMODIV().getRichiesta().getDatiAllegato().getControlloImpianto();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiIdentificativiDocument.DatiIdentificativi impDi = mod3Import.getMODIV().getRichiesta().getDatiAllegato().getDatiIdentificativi();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiTecnicoDocument.DatiTecnico impDt = mod3Import.getMODIV().getRichiesta().getDatiAllegato().getDatiTecnico();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica impDocT = mod3Import.getMODIV().getRichiesta().getDatiAllegato().getDocumentazioneTecnica();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod3Import.getMODIV().getRichiesta().getDatiAllegato().getTrattamentoAcqua();
		
		java.util.Date dataControllo = datiIntestazione.getAFDataControllo().getTime();
		String codImpianto = datiIntestazione.getCodiceCatasto();
		
		//SigitTPersonaGiuridicaDto dettaglioImpresaManutentrice = getImpresaManutentrice(allegatoDto.getFkImpRuoloPfpg().toString());

		List<SigitVSk4ScDto> scAttiviInData = getDbMgr().getCompScAttiviInData(codImpianto, dataControllo, dettaglioImpresaManutentrice.getIdPersonaGiuridica());
		

		//in questo oggetto setto il 3resonsabile (se c'è) altrimenti il responsabile (trovato sopra)
		SigitTPersonaGiuridicaDto pg = null;
		// Se il responsabile e una PG
		SigitTPersonaGiuridicaDto pgResp = null;
		// Se il responsabile e una PF
		SigitTPersonaFisicaDto pf = null;

		//in questo oggetto setto il responsabile dell'impianto
		SigitVTotImpiantoDto vTotImpiantoResp = null;

		//in questo oggetto setto il 3resonsabile (se c'è) altrimenti il responsabile (trovato sopra)
		SigitVTotImpiantoDto vTotImpianto = null;
		

		// Cerco il responsabile alla data, mi servirà nel caso non ci sia il 3Responsabile
		SigitVTotImpiantoDto responsabileImp = getDbMgr().cercaResponsabileAttivoAllaDataImpianto(codImpianto, dataControllo);

		if (responsabileImp != null)
		{
			vTotImpiantoResp = responsabileImp;

			if(vTotImpiantoResp.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
				//è una persona giuridica
				pgResp = getDbMgr().cercaTPersonaGiuridicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());

			}else{
				//è una persona fisica
				pf = getDbMgr().cercaTPersonaFisicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());
			}
			
		} 
		/*
		boolean isTerzoResp = false;
		SigitVTotImpiantoDto responsabile = null;
		List<SigitVTotImpiantoDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpianto(codImpianto, dataControllo);
		if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty()){
			List<SigitVTotImpiantoDto> listResp = getDbMgr().cercaResponsabiliAttiviAllaDataByCodImpianto(codImpianto, ConvertUtil.convertToString(dataControllo));
			if(listResp!=null && !listResp.isEmpty()){
				responsabile = listResp.get(0);
			}
		}else{
			responsabile = list3RespAttiviImpianto.get(0);
			isTerzoResp = true;
		}
		
		SigitTPersonaGiuridicaDto pg = null;
		SigitTPersonaFisicaDto pf = null;
		if(isTerzoResp)
			pg = getDbMgr().cercaTPersonaGiuridicaById(responsabile.getIdPersonaGiuridica3r().intValue());
		else if(responsabile.getPfPg().equals("PF"))
		{
			pf = getDbMgr().cercaTPersonaFisicaById(responsabile.getIdPersonaFisica().intValue());
		}else{
			pg = getDbMgr().cercaTPersonaGiuridicaById(responsabile.getIdPersonaFisica().intValue());
		}
		*/
		
		//dati locazione impianto
		List<SigitTUnitaImmobiliareDto> unitaImmobList = getDbMgr().getUnitaImmobiliariImpianto(new Integer(codImpianto));
		
		SigitTTrattH2OPk pkTrattAcqua = new SigitTTrattH2OPk(new BigDecimal(codImpianto));
		SigitTTrattH2ODto dettaglioTrattAcqua = getDbMgr().getSigitTTrattH2oDao().findByPrimaryKey(pkTrattAcqua);
		
		for(RowAllegatoIV all : mod3Import.getMODIV().getRichiesta().getDatiAllegato().getAllegatoIV().getRowAllegatoIVList())
		{
			BigInteger progressivo = all.getAENumSC();
			SigitVSk4ScDto sc = null;
			for(SigitVSk4ScDto scDto : scAttiviInData)
			{
				if(scDto.getProgressivo().intValue() == progressivo.intValue())
					sc = scDto;
			}
			if(sc==null)
				throw new ManagerException(new Message("i scambiatori non corrispondono"));
			
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica cve = all.getControlloVerificaEnergetica();
			it.csi.sigit.sigitwebn.xml.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV allegatoIV = allegato.addNewRowAllegatoIV();
			it.csi.sigit.sigitwebn.xml.allegato4.data.RowFumiDocument.RowFumi rf = allegatoIV.addNewTabFumi().addNewRowFumi();
			MapDto.mapToRowFumiIV(rf, all.getTabFumi().getRowFumi());
			allegatoIV.setCodiceCatasto(codImpianto);

			// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
			List<SigitVTotImpiantoDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(codImpianto, allegatoDto.getDataControllo(), Constants.TIPO_COMPONENTE_SC, ConvertUtil.convertToString(progressivo));
			if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
			{
//				vTotImpianto = list3RespAttiviImpianto.get(0);
//				pg = getDbMgr().cercaTPersonaGiuridicaById(vTotImpianto.getIdPersonaGiuridica3r().intValue());
//				
//				getDbMgr().aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), codImpianto, 
//						Constants.TIPO_COMPONENTE_SC, ConvertUtil.convertToBigDecimal(progressivo), sc.getDataInstall(),
//						null, vTotImpianto.getIdContratto());
			}
			else
			{
				vTotImpianto = vTotImpiantoResp;
				pg = pgResp;
				
				getDbMgr().aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), codImpianto, 
						Constants.TIPO_COMPONENTE_SC, ConvertUtil.convertToBigDecimal(progressivo), sc.getDataInstall(),
						vTotImpianto.getIdImpRuoloPfpg(), null);	
			}


			//responsabile
			if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty())
			{
				if(Constants.ID_RUOLO_AMMINISTRATORE == vTotImpianto.getIdRuolo().intValue() ||
						Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE == vTotImpianto.getIdRuolo().intValue())
					allegatoIV.xsetAA2FlagAmministr(MapDto.getXmlBoolean(true));
				if(Constants.ID_RUOLO_OCCUPANTE == vTotImpianto.getIdRuolo().intValue() ||
						Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE == vTotImpianto.getIdRuolo().intValue())
					allegatoIV.xsetAA2FlagOccupante(MapDto.getXmlBoolean(true));
				if(Constants.ID_RUOLO_PROPRIETARIO == vTotImpianto.getIdRuolo().intValue() ||
						Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO == vTotImpianto.getIdRuolo().intValue())
					allegatoIV.xsetAA2FlagProprietario(MapDto.getXmlBoolean(true));
			}
			else
			{
				allegatoIV.xsetAA2FlagTerzoResp(MapDto.getXmlBoolean(true));
			}
			
			// dati responsabile impianto
			if(pg!=null)
			{
				allegatoIV.setAA2RagSociale(pg.getDenominazione());
				allegatoIV.setAA2Piva(pg.getCodiceFiscale());
			
				if (ConvertUtil.convertToBooleanAllways(pg.getFlgIndirizzoEstero()))
				{
					allegatoIV.setAA2Indirizzo(pg.getIndirizzoEstero());
					allegatoIV.setAA2Comune(GenericUtil.getStringValid(pg.getCittaEstero()) + " ("+GenericUtil.getStringValid(pg.getStatoEstero())+")");
					allegatoIV.setAA2Prov(null);
				}
				else
				{
					allegatoIV.setAA2Prov(pg.getSiglaProv());
					allegatoIV.setAA2Comune(pg.getComune());
					allegatoIV.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pg.getIndirizzoSitad()) ? pg.getIndirizzoSitad() : pg.getIndirizzoNonTrovato());
				}
				
				// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
				allegatoIV.setAA2Civico(pg.getCivico());
							}
			else
			{

				allegatoIV.setAA2Cf(pf.getCodiceFiscale());
				allegatoIV.setAA2Cognome(pf.getCognome());
				allegatoIV.setAA2Nome(pf.getNome());

				if (ConvertUtil.convertToBooleanAllways(pf.getFlgIndirizzoEstero()))
				{
					allegatoIV.setAA2Indirizzo(pf.getIndirizzoEstero());
					allegatoIV.setAA2Comune(GenericUtil.getStringValid(pf.getCittaEstero()) + " ("+GenericUtil.getStringValid(pf.getStatoEstero())+")");
					allegatoIV.setAA2Prov(null);

				}
				else
				{
					allegatoIV.setAA2Prov(pf.getSiglaProv());
					allegatoIV.setAA2Comune(pf.getComune());
					allegatoIV.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pf.getIndirizzoSitad()) ? pf.getIndirizzoSitad() : pf.getIndirizzoNonTrovato());
				}
				
				// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
				allegatoIV.setAA2Civico(pf.getCivico());


			}
			
			//impresa manutentrice
			if(dettaglioImpresaManutentrice!=null){
				allegatoIV.setAA3RagSociale(dettaglioImpresaManutentrice.getDenominazione());
				allegatoIV.setAA3Piva(dettaglioImpresaManutentrice.getCodiceFiscale());
				
				if (ConvertUtil.convertToBooleanAllways(dettaglioImpresaManutentrice.getFlgIndirizzoEstero()))
				{
					allegatoIV.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoEstero());
					allegatoIV.setAA3Comune(GenericUtil.getStringValid(dettaglioImpresaManutentrice.getCittaEstero()) + " ("+GenericUtil.getStringValid(dettaglioImpresaManutentrice.getStatoEstero())+")");
					allegatoIV.setAA3Prov(null);

				}
				else
				{
					allegatoIV.setAA3Prov(dettaglioImpresaManutentrice.getSiglaProv());
					allegatoIV.setAA3Comune(dettaglioImpresaManutentrice.getComune());
					if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoSitad()))
						allegatoIV.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoSitad());
					else if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoNonTrovato()))
						allegatoIV.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoNonTrovato());
				}
				
				// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
				allegatoIV.setAA3Civico(dettaglioImpresaManutentrice.getCivico());
			}
			
			//catasto
			MapDto.mapSezCatastoIV(allegatoIV, vTotImpianto, unitaImmobList);
			//scambiatore
			allegatoIV.setAFDataControllo(ConvertUtil.convertDateToXmlCalendar(dataControllo));
			allegatoIV.setAENumSC(progressivo);
			allegatoIV.setAEPotenzaTermNom(sc.getPotenzaTermicaKw());
			allegatoIV.setAEDataInstallaz(ConvertUtil.convertDateToXmlCalendar(sc.getDataInstall()));
			allegatoIV.setAEFabbricante(sc.getDesMarca());
			allegatoIV.setAEMatricola(sc.getMatricola());
			allegatoIV.setAEModello(sc.getModello());
			
			MapDto.mapToVerificaEnergeticaIV(allegatoIV.addNewControlloVerificaEnergetica(),cve);
			MapDto.mapToChecklistIV(allegatoIV.addNewCheckList(), importCheckList);
			MapDto.maptoControlloImpiantoIV(allegatoIV.addNewControlloImpianto(),impCi);
			try{allegatoIV.addNewDatiIdentificativi().setAAPotenzaTermicaNomTotMax(impDi.getAAPotenzaTermicaNomTotMax());}catch(Exception e){};
			MapDto.mapToDatiTecnicoIV(allegatoIV.addNewDatiTecnico(),impDt);
			MapDto.mapToDocumentazioneTecnicaIV(allegatoIV.addNewDocumentazioneTecnica(),impDocT);
			MapDto.mapToTrattamentoAcquaIV(allegatoIV.addNewTrattamentoAcqua(),impTa, dettaglioTrattAcqua);
		}
		
		List<SigitDFluidoDto> elencoFluidi = getDbMgr().getElencoFluidi();

		modDoc.getMODIV().getRichiesta().getDatiModulo().setElencoCombustibile(MapDto.mapToElencoCombustibileAllegato4(elencoFluidi));
		modDoc.getMODIV().getRichiesta().getDatiModulo().setElencoFluidoTermoVett(MapDto.mapToElencoFluidoAllegato4(elencoFluidi));
		return modDoc;
	}
	
	private MODVDocument mapToModuloAllegato4(
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument mod4Import, SigitTAllegatoDto allegatoDto, SigitTPersonaGiuridicaDto dettaglioImpresaManutentrice) throws ManagerException, SigitTTrattH2ODaoException {
		MODVDocument modDoc = MODVDocument.Factory.newInstance();
		it.csi.sigit.sigitwebn.xml.allegato5.data.RichiestaDocument.Richiesta richiesta = modDoc.addNewMODV().addNewRichiesta();
		modDoc.getMODV().addNewSystem().addNewCatDig().setModuloEditabile(false);
		modDoc.getMODV().getSystem().getCatDig().setBtSalva(false);
		
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiIntestazioneDocument.DatiIntestazione datiIntestazione = mod4Import.getMODV().getRichiesta().getDatiIntestazione();
		richiesta.addNewDatiIntestazione().setCodiceBollino(datiIntestazione.getCodiceBollino());
		
		richiesta.addNewDatiModulo().setStatoModulo(Constants.STATO_MODULO_DEFINITIVO);
		
		AllegatoV allegato = richiesta.addNewDatiAllegato().addNewAllegatoV();
		
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.CheckListDocument.CheckList importCheckList = mod4Import.getMODV().getRichiesta().getDatiAllegato().getCheckList();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.ControlloImpiantoDocument.ControlloImpianto impCi = mod4Import.getMODV().getRichiesta().getDatiAllegato().getControlloImpianto();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiIdentificativiDocument.DatiIdentificativi impDi = mod4Import.getMODV().getRichiesta().getDatiAllegato().getDatiIdentificativi();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiTecnicoDocument.DatiTecnico impDt = mod4Import.getMODV().getRichiesta().getDatiAllegato().getDatiTecnico();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica impDocT = mod4Import.getMODV().getRichiesta().getDatiAllegato().getDocumentazioneTecnica();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.TrattamentoAcquaDocument.TrattamentoAcqua impTa = mod4Import.getMODV().getRichiesta().getDatiAllegato().getTrattamentoAcqua();
		
		java.util.Date dataControllo = datiIntestazione.getAFDataControllo().getTime();
		String codImpianto = datiIntestazione.getCodiceCatasto();
		
		//SigitTPersonaGiuridicaDto dettaglioImpresaManutentrice = getImpresaManutentrice(allegatoDto.getFkImpRuoloPfpg().toString());

		List<SigitVSk4CgDto> scAttiviInData = getDbMgr().getCompCgAttiviInData(codImpianto, dataControllo, dettaglioImpresaManutentrice.getIdPersonaGiuridica());
		

		//in questo oggetto setto il 3resonsabile (se c'è) altrimenti il responsabile (trovato sopra)
		SigitTPersonaGiuridicaDto pg = null;
		// Se il responsabile e una PG
		SigitTPersonaGiuridicaDto pgResp = null;
		// Se il responsabile e una PF
		SigitTPersonaFisicaDto pf = null;

		//in questo oggetto setto il responsabile dell'impianto
		SigitVTotImpiantoDto vTotImpiantoResp = null;

		//in questo oggetto setto il 3resonsabile (se c'è) altrimenti il responsabile (trovato sopra)
		SigitVTotImpiantoDto vTotImpianto = null;
		

		// Cerco il responsabile alla data, mi servirà nel caso non ci sia il 3Responsabile
		SigitVTotImpiantoDto responsabileImp = getDbMgr().cercaResponsabileAttivoAllaDataImpianto(codImpianto, dataControllo);

		if (responsabileImp != null)
		{
			vTotImpiantoResp = responsabileImp;

			if(vTotImpiantoResp.getPfPg().equalsIgnoreCase(Constants.LABEL_PG)){
				//è una persona giuridica
				pgResp = getDbMgr().cercaTPersonaGiuridicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());

			}else{
				//è una persona fisica
				pf = getDbMgr().cercaTPersonaFisicaById(vTotImpiantoResp.getIdPersonaFisica().intValue());
			}
			
		} 
		
		/*
		boolean isTerzoResp = false;
		SigitVTotImpiantoDto responsabile = null;
		List<SigitVTotImpiantoDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpianto(codImpianto, dataControllo);
		if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty()){
			List<SigitVTotImpiantoDto> listResp = getDbMgr().cercaResponsabiliAttiviAllaDataByCodImpianto(codImpianto, ConvertUtil.convertToString(dataControllo));
			if(listResp!=null && !listResp.isEmpty()){
				responsabile = listResp.get(0);
			}
		}else{
			responsabile = list3RespAttiviImpianto.get(0);
			isTerzoResp = true;
		}
		
		SigitTPersonaGiuridicaDto pg = null;
		SigitTPersonaFisicaDto pf = null;
		if(isTerzoResp)
			pg = getDbMgr().cercaTPersonaGiuridicaById(responsabile.getIdPersonaGiuridica3r().intValue());
		else if(responsabile.getPfPg().equals("PF"))
		{
			pf = getDbMgr().cercaTPersonaFisicaById(responsabile.getIdPersonaFisica().intValue());
		}else{
			pg = getDbMgr().cercaTPersonaGiuridicaById(responsabile.getIdPersonaFisica().intValue());
		}
		*/
		
		//dati locazione impianto
		List<SigitTUnitaImmobiliareDto> unitaImmobList = getDbMgr().getUnitaImmobiliariImpianto(new Integer(codImpianto));
		
		SigitTTrattH2OPk pkTrattAcqua = new SigitTTrattH2OPk(new BigDecimal(codImpianto));
		SigitTTrattH2ODto dettaglioTrattAcqua = getDbMgr().getSigitTTrattH2oDao().findByPrimaryKey(pkTrattAcqua);
		
		for(RowAllegatoV all : mod4Import.getMODV().getRichiesta().getDatiAllegato().getAllegatoV().getRowAllegatoVList())
		{
			BigInteger progressivo = all.getAENumCG();
			SigitVSk4CgDto cg = null;
			for(SigitVSk4CgDto cgDto : scAttiviInData)
			{
				if(cgDto.getProgressivo().intValue() == progressivo.intValue())
					cg = cgDto;
			}
			if(cg==null)
				throw new ManagerException(new Message("i cogeneratori non corrispondono"));
			
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica cve = all.getControlloVerificaEnergetica();
			it.csi.sigit.sigitwebn.xml.allegato5.data.RowAllegatoVDocument.RowAllegatoV allegatoV = allegato.addNewRowAllegatoV();
			it.csi.sigit.sigitwebn.xml.allegato5.data.RowFumiDocument.RowFumi rf = allegatoV.addNewTabFumi().addNewRowFumi();
			MapDto.mapToRowFumiV(rf, all.getTabFumi().getRowFumi());
			allegatoV.setCodiceCatasto(codImpianto);

			// Devo settare il responsabile/3 responsabile per ogni singola apparecchiatura
			List<SigitVTotImpiantoDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(codImpianto, allegatoDto.getDataControllo(), Constants.TIPO_COMPONENTE_CG, ConvertUtil.convertToString(progressivo));
			if(list3RespAttiviImpianto != null && !list3RespAttiviImpianto.isEmpty())
			{
//				vTotImpianto = list3RespAttiviImpianto.get(0);
//				pg = getDbMgr().cercaTPersonaGiuridicaById(vTotImpianto.getIdPersonaGiuridica3r().intValue());
//				
//				getDbMgr().aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), codImpianto, 
//						Constants.TIPO_COMPONENTE_CG, ConvertUtil.convertToBigDecimal(progressivo), cg.getDataInstall(),
//						null, vTotImpianto.getIdContratto());
			}
			else
			{
				vTotImpianto = vTotImpiantoResp;
				pg = pgResp;
				
				getDbMgr().aggiornaRespRAllegatoComp(allegatoDto.getIdAllegato(), codImpianto, 
						Constants.TIPO_COMPONENTE_CG, ConvertUtil.convertToBigDecimal(progressivo), cg.getDataInstall(),
						vTotImpianto.getIdImpRuoloPfpg(), null);	
			}

			//responsabile
			if(list3RespAttiviImpianto==null || list3RespAttiviImpianto.isEmpty())
			{
				if(Constants.ID_RUOLO_AMMINISTRATORE == vTotImpianto.getIdRuolo().intValue() ||
						Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE == vTotImpianto.getIdRuolo().intValue())
					allegatoV.xsetAA2FlagAmministr(MapDto.getXmlBoolean(true));
				if(Constants.ID_RUOLO_OCCUPANTE == vTotImpianto.getIdRuolo().intValue() ||
						Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE == vTotImpianto.getIdRuolo().intValue())
					allegatoV.xsetAA2FlagOccupante(MapDto.getXmlBoolean(true));
				if(Constants.ID_RUOLO_PROPRIETARIO == vTotImpianto.getIdRuolo().intValue() ||
						Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO == vTotImpianto.getIdRuolo().intValue())
					allegatoV.xsetAA2FlagProprietario(MapDto.getXmlBoolean(true));
			}
			else
			{
				allegatoV.xsetAA2FlagTerzoResp(MapDto.getXmlBoolean(true));
			}
			
			// dati responsabile impianto
			if(pg != null)
			{
				allegatoV.setAA2RagSociale(pg.getDenominazione());
				allegatoV.setAA2Piva(pg.getCodiceFiscale());

				if (ConvertUtil.convertToBooleanAllways(pg.getFlgIndirizzoEstero()))
				{
					allegatoV.setAA2Indirizzo(pg.getIndirizzoEstero());
					allegatoV.setAA2Comune(GenericUtil.getStringValid(pg.getCittaEstero()) + " ("+GenericUtil.getStringValid(pg.getStatoEstero())+")");
					allegatoV.setAA2Prov(null);
				}
				else
				{
					allegatoV.setAA2Prov(pg.getSiglaProv());
					allegatoV.setAA2Comune(pg.getComune());
					allegatoV.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pg.getIndirizzoSitad()) ? pg.getIndirizzoSitad() : pg.getIndirizzoNonTrovato());
				}
				
				// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
				allegatoV.setAA2Civico(pg.getCivico());
			}
			else
			{

				allegatoV.setAA2Cf(pf.getCodiceFiscale());
				allegatoV.setAA2Cognome(pf.getCognome());
				allegatoV.setAA2Nome(pf.getNome());

				if (ConvertUtil.convertToBooleanAllways(pf.getFlgIndirizzoEstero()))
				{
					allegatoV.setAA2Indirizzo(pf.getIndirizzoEstero());
					allegatoV.setAA2Comune(GenericUtil.getStringValid(pf.getCittaEstero()) + " ("+GenericUtil.getStringValid(pf.getStatoEstero())+")");
					allegatoV.setAA2Prov(null);

				}
				else
				{
					allegatoV.setAA2Prov(pf.getSiglaProv());
					allegatoV.setAA2Comune(pf.getComune());
					allegatoV.setAA2Indirizzo(GenericUtil.isNotNullOrEmpty(pf.getIndirizzoSitad()) ? pf.getIndirizzoSitad() : pf.getIndirizzoNonTrovato());
				}
				
				// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
				allegatoV.setAA2Civico(pf.getCivico());

			}
			
			//impresa manutentrice
			if(dettaglioImpresaManutentrice!=null){
				allegatoV.setAA3RagSociale(dettaglioImpresaManutentrice.getDenominazione());
				allegatoV.setAA3Piva(dettaglioImpresaManutentrice.getCodiceFiscale());
				
				if (ConvertUtil.convertToBooleanAllways(dettaglioImpresaManutentrice.getFlgIndirizzoEstero()))
				{
					allegatoV.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoEstero());
					allegatoV.setAA3Comune(GenericUtil.getStringValid(dettaglioImpresaManutentrice.getCittaEstero()) + " ("+GenericUtil.getStringValid(dettaglioImpresaManutentrice.getStatoEstero())+")");
					allegatoV.setAA3Prov(null);

				}
				else
				{
					allegatoV.setAA3Prov(dettaglioImpresaManutentrice.getSiglaProv());
					allegatoV.setAA3Comune(dettaglioImpresaManutentrice.getComune());
					if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoSitad()))
						allegatoV.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoSitad());
					else if(GenericUtil.isNotNullOrEmpty(dettaglioImpresaManutentrice.getIndirizzoNonTrovato()))
						allegatoV.setAA3Indirizzo(dettaglioImpresaManutentrice.getIndirizzoNonTrovato());
				}
				
				// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
				allegatoV.setAA3Civico(dettaglioImpresaManutentrice.getCivico());

			}
			
			//catasto
			MapDto.mapSezCatastoV(allegatoV, vTotImpianto, unitaImmobList);
			//scambiatore
			allegatoV.setAFDataControllo(ConvertUtil.convertDateToXmlCalendar(dataControllo));
			allegatoV.setAENumCG(progressivo);
			allegatoV.setAEPotenzaTermica(cg.getPotenzaTermicaKw());
			allegatoV.setAEDataInstallaz(ConvertUtil.convertDateToXmlCalendar(cg.getDataInstall()));
			allegatoV.setAEFabbricante(cg.getDesMarca());
			allegatoV.setAEMatricola(cg.getMatricola());
			allegatoV.setAEModello(cg.getModello());
			allegatoV.setAECombustibile(cg.getDesCombustibile());
			if(cg.getCoMin()!=null)
				allegatoV.setAEEmissioniMonossido(cg.getCoMin() + "/" + cg.getCoMax());
			allegatoV.setAEPotenzaElettrica(cg.getPotenzaElettricaKw());
			allegatoV.setAETipologia(cg.getTipologia());
			allegatoV.setAEPotenzaAssorbita(cve.getAEPotenzaAssorbita());
			allegatoV.setAEPotenzaTermByPass(cve.getAEPotenzaTermByPass());
			allegatoV.addNewControlloVerificaEnergetica().setAEFluidoVett(cve.getAEFluidoVett());
			MapDto.mapToChecklistV(allegatoV.addNewCheckList(), importCheckList);
			MapDto.mapToControlloImpiantoV(allegatoV.addNewControlloImpianto(),impCi);
			try{allegatoV.addNewDatiIdentificativi().setAAPotenzaTermicaNomTotMax(impDi.getAAPotenzaTermicaNomTotMax());}catch(Exception e){};
			MapDto.mapToDatiTecnicoV(allegatoV.addNewDatiTecnico(),impDt);
			MapDto.mapToDocumentazioneTecnicaV(allegatoV.addNewDocumentazioneTecnica(),impDocT);
			MapDto.mapToTrattamentoAcquaV(allegatoV.addNewTrattamentoAcqua(),impTa, dettaglioTrattAcqua);
		}
		modDoc.getMODV().getRichiesta().getDatiModulo().setElencoFluidoTermoVett(MapDto.mapToElencoFluidoAllegato5(getDbMgr().getElencoFluidi()));
		return modDoc;
	}
	
	private SigitTPersonaGiuridicaDto getImpresaManutentrice(String idImpRuoloPfPg)throws ManagerException {
		log.debug("[ServiziMgr::getImpresaManutentrice] BEGIN");
		SigitTPersonaGiuridicaDto dettaglioPersonaGiuridica = null;
		try {
			SigitRImpRuoloPfpgPk pk = new SigitRImpRuoloPfpgPk();
			pk.setIdImpRuoloPfpg(new BigDecimal(idImpRuoloPfPg));
			SigitRImpRuoloPfpgDto dettaglioRuoloPfPg = getDbMgr().getSigitRImpRuoloPfpgDao().findByPrimaryKey(pk);
			SigitTPersonaGiuridicaPk pkg = new SigitTPersonaGiuridicaPk();
			pkg.setIdPersonaGiuridica(dettaglioRuoloPfPg.getFkPersonaGiuridica());
			dettaglioPersonaGiuridica = getDbMgr().getSigitTPersonaGiuridicaDao().findByPrimaryKey(pkg );
		} catch (Exception e) {
			throw new ManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}finally{
			log.debug("[ServiziMgr::getImpresaManutentrice] END");
		}
		return dettaglioPersonaGiuridica;
		
	}

	public String getElencoCompAttivi(InputAllegatiComp allegatiComp, String tipoDocumento) throws DbManagerException {
        
        if (tipoDocumento.equals(Constants.ALLEGATO_TIPO_1) || 
        	tipoDocumento.equals(Constants.ALLEGATO_TIPO_1B) ||
            tipoDocumento.equals(Constants.MANUTENZIONE_GRUPPI_TERMICI) || 
            tipoDocumento.equals(Constants.RAPPORTO_PROVA_GT)) {
            List<SigitVCompGtDto> compGtAttivi = getDbMgr().cercaAllegatoCompGtAttivo(allegatiComp);
            return MapDto.mapToElencoApparecchiatureCompGt(compGtAttivi);
            
        } else if (tipoDocumento.equals(Constants.ALLEGATO_TIPO_2) || 
            tipoDocumento.equals(Constants.MANUTENZIONE_GRUPPI_FRIGO) || 
            tipoDocumento.equals(Constants.RAPPORTO_PROVA_GF)) {
        	 List<SigitVCompGfDto> compGfAttivi = getDbMgr().cercaAllegatoCompGfAttivo(allegatiComp);
        	 return MapDto.mapToElencoApparecchiatureCompGf(compGfAttivi);
        	 
        } else if (tipoDocumento.equals(Constants.ALLEGATO_TIPO_3) || 
            tipoDocumento.equals(Constants.MANUTENZIONE_SCAMBIATORI)) {
        	 List<SigitVCompScDto> compScAttivi = getDbMgr().cercaAllegatoCompScAttivo(allegatiComp);
        	 return MapDto.mapToElencoApparecchiatureCompSc(compScAttivi);
        	 
        } else if (tipoDocumento.equals(Constants.ALLEGATO_TIPO_4) || 
            tipoDocumento.equals(Constants.MANUTENZIONE_COGENERATORI)) {
        	 List<SigitVCompCgDto> compCgAttivi = getDbMgr().cercaAllegatoCompCgAttivo(allegatiComp);
        	 return MapDto.mapToElencoApparecchiatureCompCg(compCgAttivi);
        }
        
        return null;
	}
}