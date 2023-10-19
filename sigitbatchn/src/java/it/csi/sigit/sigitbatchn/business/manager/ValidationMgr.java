/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.manager;

import it.csi.sigit.sigitbatchn.batch.reader.DataReader;
import it.csi.sigit.sigitbatchn.batch.reader.DataStringReader;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitRComp4ManutDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitRImpRuoloPfpgDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTCodiceBollByFilterDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTCodiceBollDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTCompXSempliceDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTDocAggiuntivaDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTLibrettoDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTTrattH2ODto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVCompCgDettDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVCompGfDettDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVCompGtDettDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVCompScDettDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVSk4CgDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVSk4GfDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVSk4GtDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVSk4ScDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVTotImpiantoDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter.ImpiantoFilter;
import it.csi.sigit.sigitbatchn.business.manager.util.ManagerException;
import it.csi.sigit.sigitbatchn.business.manager.util.Messages;
import it.csi.sigit.sigitbatchn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitbatchn.business.util.Constants;
import it.csi.sigit.sigitbatchn.business.util.ConvertUtil;
import it.csi.sigit.sigitbatchn.business.util.DateUtil;
import it.csi.sigit.sigitbatchn.business.util.GenericUtil;
import it.csi.sigit.sigitbatchn.business.util.MapDto;
import it.csi.sigit.sigitbatchn.business.util.ModolXFAReader;
import it.csi.sigit.sigitbatchn.business.util.XmlBeanUtils;
import it.csi.sigit.sigitbatchn.business.util.XmlValidator;
import it.csi.sigit.sigitbatchn.business.util.XmlValidatorException;
import it.csi.sigit.sigitbatchn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowAllegatoIIDocument.RowAllegatoII;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RowAllegatoVDocument.RowAllegatoV;
import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.ConsumiFornitura;
import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.ConsumoGiornaliero;
import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.DatiClienteFatturazione;
import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.DatiFatturazione;
import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.DatiFornitura;
import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.DatiFornituraCliente;
import it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.PeriodoFornitura;
import it.csi.sigit.sigitbatchn.business.manager.util.Message;

import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
//import org.hamcrest.core.IsNot;

public class ValidationMgr {
	
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");

	
//	public ValidationMgr() {
//		
//	}
//
//	private void addMissingRequiredFieldError(String fname, ExecResults r) {
//		r.getFldErrors().put("" + fname, Messages.ERROR_CAMPO_ABBIGATORIO);
//	}
//
//	private void addFormatRequiredNumberFieldError(String fname, ExecResults r) {
//		r.getFldErrors().put("" + fname,  Messages.ERROR_SOLO_NUMERICI);
//	}
//	
//	private void addFormatRequiredFieldError(String fname, String error, ExecResults r) {
//		r.getFldErrors().put("" + fname, error);
//	}
//	
//	private void addGlobalErrors(String error, ExecResults r) {
//		r.getGlobalErrors().add(error);
//	}
//	
//	private void addGlobalMessages(String error, ExecResults r) {
//		r.getGlobalMessages().add(error);
//	}
//	
	
	/**
	 * Manager del DB
	 */
	protected DbMgr dbMgr;
	
	/**
	 * Manager dei servizi
	 */
	protected ServiziMgr serviziMgr;
	
	/**
	 * Manager dell'applicativo
	 */
	//protected SigitbatchMgr sigitbatchMgr;
	
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
	 * @param dbMgr Manager del DB
	 */
	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}
	
	/**
	 * Imposta i manager dei Servizi
	 * 
	 * @param serviziMgr Manager dei Servizi
	 */
	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}
	
	/**
	 * Restituisce il manager dei Servizi
	 * 
	 * @return Manager dei Servizi
	 */
	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}


	/**
	 * Imposta i manager dell'applicativo
	 * 
	 * @param dbMgr Manager dell'applicativo
	 */
//	public void setSigitbatchMgr(SigitbatchMgr sigitbatchMgr) {
//		this.sigitbatchMgr = sigitbatchMgr;
//	}
	
	/**
	 * Restituisce il manager dell'applicativo
	 * 
	 * @return Manager dell'applicativo
	 */
//	public SigitbatchMgr getSigitbatchMgr() {
//		return sigitbatchMgr;
//	}
	
	/**
	 * @param per il controllo del codice fiscale
	 */
	
	private static char carattere[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
		'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
		'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
		'8', '9' };
	
	private static int valore_pari[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
		12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 0, 1, 2, 3,
		4, 5, 6, 7, 8, 9 };
	private static int valore_dispari[] = { 1, 0, 5, 7, 9, 13, 15, 17, 19, 21,
		2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24, 23, 1, 0, 5,
		7, 9, 13, 15, 17, 19, 21 };

	private static final char carattere_di_controllo[] = { 'A', 'B', 'C', 'D',
		'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
		'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	
	
	/*
	public boolean verificaNomeAllegato(String nomeFile) throws ValidationManagerException
	{
		log.debug("[ValidationMgr::verificaNomeAllegato] BEGIN");

		boolean isNomeCorretto = false;
		
		log.debug("[ValidationMgr::verificaNomeAllegato] Step 2 – Verifiche preliminari");
		
		if (GenericUtil.isNotNullOrEmpty(nomeFile) &&
				(nomeFile.startsWith(Constants.DES_INIZIO_ALLEGATO_II) ||
						nomeFile.startsWith(Constants.DES_INIZIO_ALLEGATO_III) ||
						nomeFile.startsWith(Constants.DES_INIZIO_ALLEGATO_IV) ||
						nomeFile.startsWith(Constants.DES_INIZIO_ALLEGATO_V)))
		{
			isNomeCorretto = true;
		}
		
		log.debug("[ValidationMgr::verificaNomeAllegato] END");

		return isNomeCorretto;
	}
	
	public boolean verificaValiditaFormaleFile(String nomeFile) throws ValidationManagerException
	{
		log.debug("[ValidationMgr::verificaNomeAllegato] BEGIN");

		boolean isNomeCorretto = false;
		
		log.debug("[ValidationMgr::verificaNomeAllegato] Step 2 – Verifiche preliminari");
		
		if (GenericUtil.isNotNullOrEmpty(nomeFile) &&
				(nomeFile.startsWith(Constants.DES_INIZIO_ALLEGATO_II) ||
						nomeFile.startsWith(Constants.DES_INIZIO_ALLEGATO_III) ||
						nomeFile.startsWith(Constants.DES_INIZIO_ALLEGATO_IV) ||
						nomeFile.startsWith(Constants.DES_INIZIO_ALLEGATO_V)))
		{
			isNomeCorretto = true;
		}
		
		log.debug("[ValidationMgr::verificaNomeAllegato] END");

		return isNomeCorretto;
	}
	
	public boolean validazioneStrutturaXmlImport(String readFile, String nomeFile)
	{
		log.debug("validazioneStrutturaXmlImport START");
		
		boolean isFileCorretto = false;
		
		String schemasDir = "schemaorg_apache_xmlbeans/src/src/adobe/Schemas/";
		String all2Schema = schemasDir + "Import-AllegatoII-1.0.0.xsd";
		String all3Schema = schemasDir + "Import-AllegatoIII-1.0.0.xsd";
		String all4Schema = schemasDir + "Import-AllegatoIV-1.0.0.xsd";
		String all5Schema = schemasDir + "Import-AllegatoV-1.0.0.xsd";
		
		log.debug("nome file: " + readFile);
		try{

			InputStreamReader xmlSchemaReader = null;
			
			if(nomeFile.startsWith(Constants.DES_INIZIO_ALLEGATO_II))
			{
				log.debug("lettura xml dell'allegato 2");
				xmlSchemaReader = new InputStreamReader(GenericUtil.getFileInClassPath(all2Schema));
				
			}
			else if(nomeFile.startsWith(Constants.DES_INIZIO_ALLEGATO_III))
			{
				log.debug("lettura xml dell'allegato 3");
				xmlSchemaReader = new InputStreamReader(GenericUtil.getFileInClassPath(all3Schema));
			}
			else if(nomeFile.startsWith(Constants.DES_INIZIO_ALLEGATO_IV))
			{
				log.debug("lettura xml dell'allegato 4");
				xmlSchemaReader = new InputStreamReader(GenericUtil.getFileInClassPath(all4Schema));
			}
			else if(nomeFile.startsWith(Constants.DES_INIZIO_ALLEGATO_V))
			{
				log.debug("lettura xml dell'allegato 5");
				xmlSchemaReader = new InputStreamReader(GenericUtil.getFileInClassPath(all5Schema));
			}
			
			XmlValidator.validate(readFile, xmlSchemaReader);
			isFileCorretto = true;

			
		} catch (XmlValidatorException e) {
			log.debug("errore validazione xml", e);
			
		} 
		finally
		{
			log.debug("validazioneStrutturaXmlImport END");
		}
		return isFileCorretto;
	}
	*/
	
	public void validazioneXmlImport(Integer idImport, String readFile, String nomeFile) throws ValidationManagerException
	{
		log.debug("validazioneXmlImport START");
		
		try
		{
			String schemasDir = "schemaorg_apache_xmlbeans/src/src/adobe/Schemas/";
			String all2Schema = schemasDir + "Import-AllegatoII-1.0.0.xsd";
			String all3Schema = schemasDir + "Import-AllegatoIII-1.0.0.xsd";
			String all4Schema = schemasDir + "Import-AllegatoIV-1.0.0.xsd";
			String all5Schema = schemasDir + "Import-AllegatoV-1.0.0.xsd";
			
			String theXml = null;
			DataReader daReaderFile = null;
			
			daReaderFile = new DataStringReader(readFile);
			
			theXml = XmlBeanUtils.readFile(daReaderFile.getReader());
			
			String codiceImpianto = null;
			String siglaRea = null;
			String numeroRea = null;
			String codiceFiscale = null;
			String codiceBollino = null;

			Calendar dataControllo = null;
			Calendar dataIntervento = null;
			Integer idRuolo = null;
			String tipoAllegato="";
			
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RichiestaDocument.Richiesta richiestaAll2 = null;
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RichiestaDocument.Richiesta richiestaAll3 = null;
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RichiestaDocument.Richiesta richiestaAll4 = null;
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RichiestaDocument.Richiesta richiestaAll5 = null;

			InputStreamReader xmlSchemaReader = null;

			if(GenericUtil.iniziaPer(nomeFile, Constants.DES_INIZIO_ALLEGATO_II))
			{
				log.debug("lettura xml dell'allegato 2");

				log.debug("[ValidationMgr::validazioneXmlImport] Step 2 – Verifiche preliminari - verifica struttura");
				xmlSchemaReader = new InputStreamReader(GenericUtil.getFileInClassPath(all2Schema));
				XmlValidator.validate(readFile, xmlSchemaReader);

				MODIIDocument document = MODIIDocument.Factory.parse(theXml);

				log.debug("convertito xml in java");
				richiestaAll2 = document.getMODII().getRichiesta();
				
				codiceImpianto = richiestaAll2.getDatiIntestazione().getCodiceCatasto();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiManutentoreDocument.DatiManutentore manutentore = richiestaAll2.getDatiManutentore();
				siglaRea = manutentore.getSiglaREA();
				numeroRea = manutentore.getNumeroREA();
				codiceFiscale = manutentore.getCodiceFiscale();
				codiceBollino = richiestaAll2.getDatiIntestazione().getCodiceBollino();
				dataControllo = richiestaAll2.getDatiIntestazione().getAFDataControllo();
				dataIntervento = richiestaAll2.getDatiAllegato().getDatiTecnico().getAFDataIntervento();
				idRuolo = Constants.ID_RUOLO_MANUTENTORE_ALL_1;
				tipoAllegato = Constants.DES_DOC_TIPO_1;
			}
			else if(GenericUtil.iniziaPer(nomeFile, Constants.DES_INIZIO_ALLEGATO_III))
			{
				log.debug("lettura xml dell'allegato 3");

				log.debug("[ValidationMgr::validazioneXmlImport] Step 2 – Verifiche preliminari - verifica struttura");
				xmlSchemaReader = new InputStreamReader(GenericUtil.getFileInClassPath(all3Schema));
				XmlValidator.validate(readFile, xmlSchemaReader);

				MODIIIDocument document = MODIIIDocument.Factory.parse(theXml);

				log.debug("convertito xml in java");
				richiestaAll3 = document.getMODIII().getRichiesta();
				
				codiceImpianto = richiestaAll3.getDatiIntestazione().getCodiceCatasto();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiManutentoreDocument.DatiManutentore manutentore = richiestaAll3.getDatiManutentore();
				siglaRea = manutentore.getSiglaREA();
				numeroRea = manutentore.getNumeroREA();
				codiceFiscale = manutentore.getCodiceFiscale();
				codiceBollino = richiestaAll3.getDatiIntestazione().getCodiceBollino();

				dataControllo = richiestaAll3.getDatiIntestazione().getAFDataControllo();
				dataIntervento = richiestaAll3.getDatiAllegato().getDatiTecnico().getAFDataIntervento();
				idRuolo = Constants.ID_RUOLO_MANUTENTORE_ALL_2;
				tipoAllegato = Constants.DES_DOC_TIPO_2;
			}
			else if(GenericUtil.iniziaPer(nomeFile, Constants.DES_INIZIO_ALLEGATO_IV))
			{
				log.debug("lettura xml dell'allegato 4");

				log.debug("[ValidationMgr::validazioneXmlImport] Step 2 – Verifiche preliminari - verifica struttura");
				xmlSchemaReader = new InputStreamReader(GenericUtil.getFileInClassPath(all4Schema));
				XmlValidator.validate(readFile, xmlSchemaReader);

				MODIVDocument document = MODIVDocument.Factory.parse(theXml);

				log.debug("convertito xml in java");
				richiestaAll4 = document.getMODIV().getRichiesta();
				codiceImpianto = richiestaAll4.getDatiIntestazione().getCodiceCatasto();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiManutentoreDocument.DatiManutentore manutentore = richiestaAll4.getDatiManutentore();
				siglaRea = manutentore.getSiglaREA();
				numeroRea = manutentore.getNumeroREA();
				codiceFiscale = manutentore.getCodiceFiscale();
				codiceBollino = richiestaAll4.getDatiIntestazione().getCodiceBollino();

				dataControllo = richiestaAll4.getDatiIntestazione().getAFDataControllo();
				dataIntervento = richiestaAll4.getDatiAllegato().getDatiTecnico().getAFDataIntervento();
				idRuolo = Constants.ID_RUOLO_MANUTENTORE_ALL_3;
				tipoAllegato = Constants.DES_DOC_TIPO_3;
			}
			else if(GenericUtil.iniziaPer(nomeFile, Constants.DES_INIZIO_ALLEGATO_V))
			{
				log.debug("lettura xml dell'allegato 5");

				log.debug("[ValidationMgr::validazioneXmlImport] Step 2 – Verifiche preliminari - verifica struttura");
				xmlSchemaReader = new InputStreamReader(GenericUtil.getFileInClassPath(all5Schema));
				XmlValidator.validate(readFile, xmlSchemaReader);

				MODVDocument document = MODVDocument.Factory.parse(theXml);

				log.debug("convertito xml in java");
				richiestaAll5 = document.getMODV().getRichiesta();
				codiceImpianto = richiestaAll5.getDatiIntestazione().getCodiceCatasto();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiManutentoreDocument.DatiManutentore manutentore = richiestaAll5.getDatiManutentore();
				siglaRea = manutentore.getSiglaREA();
				numeroRea = manutentore.getNumeroREA();
				codiceFiscale = manutentore.getCodiceFiscale();
				codiceBollino = richiestaAll5.getDatiIntestazione().getCodiceBollino();

				dataControllo = richiestaAll5.getDatiIntestazione().getAFDataControllo();
				dataIntervento = richiestaAll5.getDatiAllegato().getDatiTecnico().getAFDataIntervento();
				idRuolo = Constants.ID_RUOLO_MANUTENTORE_ALL_4;
				tipoAllegato = Constants.DES_DOC_TIPO_4;
			}
			else
			{
				log.debug("[ValidationMgr::verificaNomeAllegato] Step 2 – Verifiche preliminari - verifica nome");

				log.debug("Nome file non conosciuto");
				throw new ValidationManagerException(new Message(Messages.S097));
			}
			
			log.debug("[ValidationMgr::verificaXmlAllegato] Step 3 – Verifiche contenuto XML");

//			Verificare che il manutentore indicato (tag siglaREA, numeroREA, codiceFiscale) esista su SIGIT_T_PERSONA_GIURIDICA
			SigitTPersonaGiuridicaDto pg = getDbMgr().cercaPersonaGiuridica(codiceFiscale, siglaRea, ConvertUtil.convertToBigDecimal(numeroRea));
			if(pg==null)
			{
				log.debug("Persona giuridica non trovata");
				throw new ValidationManagerException(new Message(Messages.S100, MapDto.getCodiceRea(siglaRea, ConvertUtil.convertToInteger(numeroRea))));
			}
			else
			{
				// Setto l'ID persona giuridica del rapporto // E' FUORI LA TRANSAZIONE
				getDbMgr().settaIdPersonaGiuridicaToImport(idImport, pg.getIdPersonaGiuridica());
			}

			
			List<SigitTLibrettoDto> librettoConsolidato = getDbMgr().cercaLibrettoByStato(codiceImpianto, Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			if(librettoConsolidato==null || librettoConsolidato.isEmpty())
			{
				log.debug("Libretto consolidato non trovato");
				throw new ValidationManagerException(new Message(Messages.S099, codiceImpianto));
			}

			log.debug("[ValidationMgr::verificaXmlAllegato] Step 3.2.2 – data controllo futura");

			// Verifico che la data controllo non sia futura
			if (ConvertUtil.convertToDate(dataControllo).getTime() > System.currentTimeMillis()) {
				throw new ValidationManagerException(new Message(Messages.S113, ConvertUtil.convertToString(dataControllo)));

			}
			
			
			log.debug("[ValidationMgr::verificaXmlAllegato] Step 3.2.3 – data intervento minore di data controllo");
			verificaDataIntervento(ConvertUtil.convertToString(dataControllo),
					ConvertUtil.convertToString(dataIntervento));

						
			log.debug("[ValidationMgr::verificaXmlAllegato] Step 3.3.1 – Manutentore cessato");
			
			if (pg.getFkStatoPg().intValue() == Constants.ID_STATO_IMPRESA_RADIATA
					|| pg.getFkStatoPg().intValue() == Constants.ID_STATO_IMPRESA_SOSPESA) {
				
				throw new ValidationManagerException(new Message(Messages.S111, MapDto.getCodiceRea(siglaRea, ConvertUtil.convertToInteger(numeroRea)), pg.getCodiceFiscale()));
			}
			else if (pg.getFkStatoPg().intValue() == Constants.ID_STATO_IMPRESA_CESSATA)
			{
				// Punto 3.3.1 
				//controllo se il manutentore indicato non abbia l'attività cessata
				verificaDataCessazioneAttivita(ConvertUtil.convertToString(dataControllo),
						ConvertUtil.convertToString(pg.getDataCessazione()));
			}
			
			// Punto 3.4 
//			Verificare che il manutentore indicato (tag siglaREA, numeroREA, codiceFiscale) abbia una associazione attiva alla data attuale
//			su SIGIT_R_IMP_RUOLO_PFPG per il codice impianto indicato (tag codiceCatasto) e per il tipo allegato indicato
			List<SigitRComp4ManutDto> manAttivoAttuale = getDbMgr().cercaAttualiByRuolo(codiceImpianto, pg.getIdPersonaGiuridica(), idRuolo);
			
			if(manAttivoAttuale==null || manAttivoAttuale.isEmpty())
			{
				log.debug("Manutentore non attivo alla data attuale");
				String msg = Messages.S101.replaceFirst("##valueCodImpianto##", codiceImpianto)
						//.replaceFirst("##valueDataControllo##", ConvertUtil.convertToString(dataControllo))
						.replaceFirst("##valueTipoAllegato##", tipoAllegato);
				throw new ValidationManagerException(new Message(msg, MapDto.getCodiceRea(siglaRea, ConvertUtil.convertToInteger(numeroRea))));
			}
			
			
			// Punto 3.5 
			if (!validazioneCodiceBollino(codiceBollino))
			{
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.5 – Verifica codice bollino");

				throw new ValidationManagerException(new Message(Messages.S102, codiceBollino));
			}
			
			// Punto 3.6
//			if (!isCodiceBollinoDelManutentore(codiceBollino, pg.getIdPersonaGiuridica()))
//			{
//				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.6 – Verifica se codice bollino e' del manutentore");
//
//				throw new ValidationManagerException(new Message(Messages.S103, codiceBollino, MapDto.getCodiceRea(siglaRea, ConvertUtil.convertToInteger(numeroRea))));
//			}
			
			// Punto 3.7
			if (!isCodiceBollinoLibero(codiceBollino))
			{
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.7 – Verifica se codice bollino libero");

				throw new ValidationManagerException(new Message(Messages.S104, codiceBollino));
			}
			
			/*
			if (!isCodiceBollinoValidoDataControllo(codiceBollino, ConvertUtil.convertToString(dataControllo)))
			{
				throw new ValidationManagerException(new Message(Messages.S110, codiceBollino));
			}
			*/
			
			// Punto 3.8
			if(GenericUtil.iniziaPer(nomeFile, Constants.DES_INIZIO_ALLEGATO_II))
			{
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.8 – Verifica obbligatorietà e formalità AllegatoII");
				
				validazioneFormaleAllegatoII(richiestaAll2, pg.getIdPersonaGiuridica());

			}
			else if(GenericUtil.iniziaPer(nomeFile, Constants.DES_INIZIO_ALLEGATO_III))
			{
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.8 – Verifica obbligatorietà e formalità AllegatoIII");

				validazioneFormaleAllegatoIII(richiestaAll3, pg.getIdPersonaGiuridica());
				
			}
			else if(GenericUtil.iniziaPer(nomeFile, Constants.DES_INIZIO_ALLEGATO_IV))
			{
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.8 – Verifica obbligatorietà e formalità AllegatoIV");

				validazioneFormaleAllegatoIV(richiestaAll4, pg.getIdPersonaGiuridica());
				
			}
			else if(GenericUtil.iniziaPer(nomeFile, Constants.DES_INIZIO_ALLEGATO_V))
			{
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.8 – Verifica obbligatorietà e formalità AllegatoV");

				validazioneFormaleAllegatoV(richiestaAll5, pg.getIdPersonaGiuridica());
			}
		}
		catch (IOException e) 
		{
			log.debug("errore validazione xml", e);
			throw new ValidationManagerException(new Message(Messages.S096));
				
		}
		catch (XmlValidatorException e) {
			log.debug("errore validazione xml", e);
			throw new ValidationManagerException(new Message(Messages.S098));
		} 
		catch (XmlException e) 
		{
			log.debug("errore validazione xml", e);
			throw new ValidationManagerException(new Message(Messages.S098));
	
		}
		catch (ValidationManagerException e) 
		{
			log.debug("errore validazione xml", e);
			throw e;
				
		}
		catch (DbManagerException e) {
			log.error("Errore: ", e);
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally
		{
			log.debug("validazioneXmlImport END");
		}
		
		// DA TOGLIERE
		//throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
	}

	public boolean isNessunResponsabileByCodImpiantoApp(String codImpianto, Date dataRapporto, String idTipoAllegato, ArrayList<String> listaProgressivi) throws ValidationManagerException {
		
		try {
			SigitVTotImpiantoDto responsabile = getDbMgr().cercaPrimoResponsabileAttivoAllaDataByCodImpiantoApp(codImpianto, dataRapporto, idTipoAllegato, listaProgressivi);
			
			return responsabile == null;
			
		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		
	}
	

//	public static it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument mapToImportMODIIDocument(byte[] theXml){
//		try {
//			log.debug("[MapDto::mapToImportMODIIDocument] start");
//			String theXmlString = ModolXFAReader.getXMLData(theXml, "MODII");
//			InputStream is = new ByteArrayInputStream(XmlBeanUtils.readString(theXmlString));
//			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument allegatoDoc = it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument.Factory.parse(is);
//			log.debug("[MapDto::mapToImportMODIIDocument] end");
//			return allegatoDoc;
//		} catch (Exception e) {
//			log.error("Errore mapToImportMODIIDocument - Exception",e);
//			return null;
//		}		
//	}
	
	/*
	public static it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.UTENZEDISTComunicazioneDocument mapToImportMODBeppe(byte[] theXml){
		try {
			log.debug("[MapDto::mapToImportMODIIDocument] start");
			String theXmlString = ModolXFAReader.getXMLData(theXml, "UTENZEDIST_Comunicazione");
			InputStream is = new ByteArrayInputStream(XmlBeanUtils.readString(theXmlString));
			it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.UTENZEDISTComunicazioneDocument allegatoDoc = 
					it.csi.sigit.sigitwebn.xml.importmassivo.utenzedistributori.data.UTENZEDISTComunicazioneDocument.Factory.parse(is);
			log.debug("[MapDto::mapToImportMODIIDocument] end");
			return allegatoDoc;
		} catch (Exception e) {
			log.error("Errore mapToImportMODIIDocument - Exception",e);
			return null;
		}		
	}
	*/
	
	/*
	public List<DatiFornituraCliente> validazioneXmlImportDistrib(byte[] theXmlByte) throws ValidationManagerException
	{
		log.debug("validazioneXmlImportDistrib START");
		
		try
		{
			String schemasDir = "schemaorg_apache_xmlbeans/src/src/adobe/Schemas/";
			String all2Schema = schemasDir + "Import-Utenze-Distributori-1.0.0.xsd";
			

//			FileReader fileReader = new FileReader(file);

			
//			Reader targetReader = new StringReader(new String(initialArray));
//			    targetReader.close();
			String readFile = new String(theXmlByte);
			
			
			//it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RichiestaDocument.Richiesta richiestaAll2 = null;

			log.debug("lettura xml dell'import distributori");

			log.debug("[ValidationMgr::validazioneXmlImportDistrib] Step 1 – Verifiche preliminari - verifica struttura");
			InputStreamReader  xmlSchemaReader = new InputStreamReader(GenericUtil.getFileInClassPath(all2Schema));
			XmlValidator.validate(readFile, xmlSchemaReader);

			DataReader daReaderFile = new DataStringReader(readFile);

			String theXml = XmlBeanUtils.readFile(daReaderFile.getReader());
			
			UTENZEDISTComunicazioneDocument utenzeDistributori = UTENZEDISTComunicazioneDocument.Factory.parse(theXml);
			
			return utenzeDistributori.getUTENZEDISTComunicazione().getDatiFornituraClienteList();
			
		}
		catch (IOException e) 
		{
			log.debug("errore validazione xml", e);
			throw new ValidationManagerException(new Message(Messages.S096));
				
		}
		catch (XmlValidatorException e) {
			log.debug("errore validazione xml", e);
			throw new ValidationManagerException(new Message(Messages.S098));
		} 
		catch (XmlException e) 
		{
			log.debug("errore validazione xml", e);
			throw new ValidationManagerException(new Message(Messages.S098));
	
		}
		
		finally
		{
			log.debug("validazioneXmlImportDistrib END");
		}
		
		// DA TOGLIERE
		//throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
	}
	*/
	
	public void validazioneFornituraClienteXmlImportDistrib(DatiFornituraCliente fornituraCliente) throws ValidationManagerException
	{
		log.debug("validazioneFornituraClienteXmlImportDistrib START");
		
		
		try
		{
			if (fornituraCliente != null)
			{
				boolean isPg = fornituraCliente.getDatiCliente().getPfPg().toString().equals(Constants.LABEL_PG);
				
				if (isPg)
				{
					controlloPIVA(fornituraCliente.getDatiCliente().getCfPiva());
				}
				else
				{
					controlloCf(fornituraCliente.getDatiCliente().getCfPiva());
				}
				
				//dcosta: inserita nuova gestione con datiFatturazione
				DatiFatturazione datiFatturazione = fornituraCliente.getDatiFatturazione();
				if (datiFatturazione != null) {
					DatiClienteFatturazione clienteFatturazione = datiFatturazione.getDatiClienteFatturazione();
					isPg = Constants.LABEL_PG.equals(clienteFatturazione.getPfPg());
					if (isPg)
					{
						controlloPIVA(clienteFatturazione.getCfPiva());
					}
					else
					{
						controlloCf(clienteFatturazione.getCfPiva());
					}
				}
				
				DatiFornitura datiFornitura = fornituraCliente.getDatiFornitura();
				if (datiFornitura != null) {
					//CONTROLLO SU ANNO RIFERIMENTO
					PeriodoFornitura periodoFornitura = datiFornitura.getPeriodoFornitura();
					if (periodoFornitura != null) {
						String annoFornitura = periodoFornitura.getAnnoRiferimento() != null ?  periodoFornitura.getAnnoRiferimento().toString() : null;
						if (annoFornitura != null) {
							checkIsNotValidYear(annoFornitura);
							
							checkAnnoFuturo(annoFornitura);
						}
					}
					
					//CONTROLLO SU GIORNO RIFERIMENTO
					ConsumiFornitura consumiFornitura = datiFornitura.getConsumiFornitura();
					String pattern =  "yyyy-MM-dd";
					if (consumiFornitura != null) {
						ConsumoGiornaliero consumoGiornaliero = consumiFornitura.getConsumoGiornaliero();
						if (consumoGiornaliero != null) {
							String giornoRiferimento = consumoGiornaliero.getGiornoRiferimento() != null ? consumoGiornaliero.getGiornoRiferimento().toString() : null;
							chekIsNotValidDate(giornoRiferimento, pattern);
//							chekIsNotValidDate(giornoRiferimento);
							if (!DateUtil.checkDateOrder(giornoRiferimento, DateUtil.getDataCorrenteFormat(pattern), true, pattern)
//									dataGiornoRiferimento != null && dataGiornoRiferimento.after(new Date())
									) {
								throw new ValidationManagerException(new Message(Messages.S116_bis, giornoRiferimento));
							}
						}
					}
				}
			}
		}
		
		finally
		{
			log.debug("validazioneFornituraClienteXmlImportDistrib END");
		}
	}
	
	
	private boolean validazioneCodiceBollino(String codiceBollino)
	{
		boolean isCorrect = false;
		
		if (GenericUtil.isNotNullOrEmpty(codiceBollino))
		{
			//int index = codiceBollino.indexOf(Constants.SIGLA_BOLLINO_RP+Constants.INTERVAL_SEP);
			
			//System.out.println("Stampo index: "+index);
			
			if (codiceBollino.toUpperCase().startsWith(Constants.SIGLA_BOLLINO_RP+Constants.INTERVAL_SEP))
			{
				String numeroBollino = codiceBollino.substring(3);

				//System.out.println("Stampo il numero bollino: "+numeroBollino);

				isCorrect = GenericUtil.isNumero(numeroBollino);
				
			}
		}
		
		return isCorrect;
	}
	
	/**
	 * Controllo che in caso di manutentore con attività cessata, la data di controllo non sia successiva alla data di cessata attività
	  * @param String dataControllo
	  * @param String dataCessazione
	  * @throws ValidationManagerException la data di controllo è precedende a quella di ritiro
	 */
	private void verificaDataCessazioneAttivita(String dataControllo, String dataCessazione) throws ValidationManagerException {

		//cerco l'eventuale data cessazione dell'attività del manutentore

		//PersonaGiuridica personaGiuridica = getDbMgr().cercaPersonaGiuridicaById(idPersonaGiuridica);
		if(GenericUtil.isNotNullOrEmpty(dataCessazione)){
			//vuol dire che la ditta ha cessato l'attivita
			boolean flag = DateUtil.checkDateOrder(dataCessazione, dataControllo, true);

			if(flag){
				throw new ValidationManagerException(new Message(Messages.S052,dataCessazione));
			}
		}
	}
	
	/**
	 * Controllo che in caso di intervento sia successiva alla data controllo
	  * @param String dataControllo
	  * @param String dataIntervento
	  * @throws ValidationManagerException la data di intervento è precedente a quella del rapporto
	 */
	private void verificaDataIntervento(String dataControllo, String dataIntervento) throws ValidationManagerException {

		//cerco l'eventuale data cessazione dell'attività del manutentore

		//PersonaGiuridica personaGiuridica = getDbMgr().cercaPersonaGiuridicaById(idPersonaGiuridica);
		if(GenericUtil.isNotNullOrEmpty(dataIntervento)){
			//vuol dire che la ditta ha cessato l'attivita
			boolean flag = DateUtil.checkDateOrder(dataIntervento, dataControllo, false);

			if(flag){
				throw new ValidationManagerException(new Message(Messages.S114,dataIntervento,dataControllo));
			}
		}
	}
	/*
	private boolean isCodiceBollinoDelManutentore(String codiceBollino, BigDecimal idManutentore) throws ValidationManagerException
	{
		log.debug("[ValidationMgr::isCodiceBollinoDelManutentore] BEGIN");

		boolean isCorrect = false;
		try
		{
			if (GenericUtil.isNotNullOrEmpty(codiceBollino))
			{
				//int index = codiceBollino.indexOf(Constants.SIGLA_BOLLINO_RP+Constants.INTERVAL_SEP);
				
				//System.out.println("Stampo index: "+index);
				
				String siglaBollino = codiceBollino.substring(0,2);
				String numeroBollino = codiceBollino.substring(3);
				
				List<SigitTCodiceBollByFilterDto> dtoList = getDbMgr().cercaCodiceBollinoManutentore(siglaBollino, new ConvertUtil().convertToInteger(numeroBollino), idManutentore);
				
				isCorrect = (dtoList != null && dtoList.size() > 0);
				
			}
		}
		catch (DbManagerException e) {
			log.error("Errore: ", e);
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		log.debug("[ValidationMgr::isCodiceBollinoDelManutentore] END");

		return isCorrect;
	}
	*/
	private boolean isCodiceBollinoLibero(String codiceBollino) throws ValidationManagerException
	{
		log.debug("[ValidationMgr::isCodiceBollinoLibero] BEGIN");

		boolean isLibero = false;
		try
		{
			if (GenericUtil.isNotNullOrEmpty(codiceBollino))
			{
				//int index = codiceBollino.indexOf(Constants.SIGLA_BOLLINO_RP+Constants.INTERVAL_SEP);
				
				//System.out.println("Stampo index: "+index);
				
				String siglaBollino = codiceBollino.substring(0,2);
				String numeroBollino = codiceBollino.substring(3);
				
				List<SigitTAllegatoDto> dtoList = getDbMgr().cercaAllegatoByCodiceBollino(siglaBollino, new ConvertUtil().convertToInteger(numeroBollino));
				
				isLibero = (dtoList == null || dtoList.size() == 0);
				
			}
		}
		catch (DbManagerException e) {
			log.error("Errore: ", e);
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		
		log.debug("[ValidationMgr::isCodiceBollinoLibero] BEGIN");

		return isLibero;
	}
	
	/**
	 * Controllo che il codice bollino sia in corso di validà alla data controllo
	  * @param String siglaBollino
	  * @param String numeroBollino
	  * @param String dataControllo
	  * @throws ValidationManagerException il codice bollino non è valido alla data controllo 
	 */
	private boolean isCodiceBollinoValidoDataControllo(String codiceBollino, String dataControllo) throws ValidationManagerException {
		boolean isValido = false;
		try {
			if (GenericUtil.isNotNullOrEmpty(codiceBollino))
			{
				String siglaBollino = codiceBollino.substring(0,2);
				String numeroBollino = codiceBollino.substring(3);
				
				List<SigitTCodiceBollDto> dtoList = getDbMgr().cercaCodiceBollInDataControllo(siglaBollino, numeroBollino, dataControllo);
				
				isValido = (dtoList != null && dtoList.size() > 0);
				
			}
		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		
		return isValido;
	}
	
	private void validazioneFormaleAllegatoII(it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RichiestaDocument.Richiesta richiesta, BigDecimal idPersonaGiuridica) throws ValidationManagerException
	{
		log.debug("[ValidationMgr::validazioneFormaleAllegatoII] BEGIN");

		try
		{

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiIntestazioneDocument.DatiIntestazione intestazione = richiesta.getDatiIntestazione();
			String codImpianto = intestazione.getCodiceCatasto();
			Date dataControllo = ConvertUtil.convertToDate(intestazione.getAFDataControllo());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiAllegatoDocument.DatiAllegato allegato = richiesta.getDatiAllegato();

			checkDecimali(allegato.getDatiIdentificativi().getAAPotenzaTermicaNomTotMax(), 6, 2, "A_A_potenzaTermicaNomTotMax");

			//it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica doc = richiesta.getDatiAllegato().getDocumentazioneTecnica();


			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.ControlloImpiantoDocument.ControlloImpianto contrImp = richiesta.getDatiAllegato().getControlloImpianto();

			
			//System.out.println("\n\nSTAMPO IL A_D_flagInterno: "+contrImp.getADFlagInterno()+"\n\n");
			
			check3Flag(contrImp.getADFlagInterno(), "A_D_flagInterno");
			check3Flag(contrImp.getADFlagCanaleFumo(), "A_D_flagCanaleFumo");
			check3Flag(contrImp.getADFlagEsterno(), "A_D_flagEsterno");
			check3Flag(contrImp.getADFlagSistRegolaz(), "A_D_flagSistRegolaz");

			check3Flag(contrImp.getADFlagAperture(), "A_D_flagAperture");
			check3Flag(contrImp.getADFlagPerdite(), "A_D_flagPerdite");
			check3Flag(contrImp.getADFlagDimensioni(), "A_D_flagDimensioni");
			check3Flag(contrImp.getADFlagTenuta(), "A_D_flagTenuta");



			SigitTTrattH2ODto dettaglioTrattAcqua = getDbMgr().cercaTrattAcquaByCodiceImpianto(codImpianto);

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.TrattamentoAcquaDocument.TrattamentoAcqua trattAcqua = richiesta.getDatiAllegato().getTrattamentoAcqua();


			
			if (!(ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAssente()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaFiltr()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAddolc()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaChimico())))
			{
				
				
				if (!trattAcqua.getACFlagTrattH2ONR())
				{
					// Questo valore deve essere true!

					throw new ValidationManagerException(new Message(Messages.S105, "A_C_flagTrattH2ONR"));
				}
			}

			if (!(ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsAssente()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsFiltr()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsAddolc()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsChimico())))
			{
				if (!trattAcqua.getACFlagTrattAcsNR())
				{
					// Questo valore deve essere true!

					throw new ValidationManagerException(new Message(Messages.S105, "A_C_flagTrattAcsNR"));
				}
			}

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.CheckListDocument.CheckList checkList = richiesta.getDatiAllegato().getCheckList();

			if (GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni()) && 
					(checkList.getAFOsservazioni().length() > Constants.MAX_1000))
			{
				checkList.setAFOsservazioni(checkList.getAFOsservazioni().substring(0, Constants.MAX_1000));
			}
			
			if (GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni()) && 
					(checkList.getAFRaccomandazioni().length() > Constants.MAX_1000))
			{
				checkList.setAFRaccomandazioni(checkList.getAFRaccomandazioni().substring(0, Constants.MAX_1000));
			}
			
			if (GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni()) && 
					(checkList.getAFPrescrizioni().length() > Constants.MAX_1000))
			{
				checkList.setAFPrescrizioni(checkList.getAFPrescrizioni().substring(0, Constants.MAX_1000));
			}

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiTecnicoDocument.DatiTecnico datiTecnico = richiesta.getDatiAllegato().getDatiTecnico();

			if (GenericUtil.isNullOrEmpty(datiTecnico.getAFNomeTecnico()))
			{
				throw new ValidationManagerException(new Message(Messages.S105, "A_F_nomeTecnico"));
			}
			
			if (GenericUtil.isNullOrEmpty(datiTecnico.getAFCognomeTecnico()))
			{
				throw new ValidationManagerException(new Message(Messages.S105, "A_F_cognomeTecnico"));
			}
			
			//it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowAllegatoIIDocument.RowAllegatoII rowAllegatoII = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
			List<RowAllegatoII> listaRow = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
			List<SigitVSk4GtDto> listGt = getDbMgr().getCompGtAttiviInData(codImpianto, dataControllo, idPersonaGiuridica);

			
			if (listaRow == null || listGt == null)
			{
				throw new ValidationManagerException(new Message(Messages.S105, "rowAllegatoII"));
			}
			
			/*
			else if (listaRow.size() != listGt.size())
			{
				
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.8 – Il numero dei row XML non corrisponde con il numero dei GT sul DB");

				// Non corrispondono le righe
				throw new ValidationManagerException(new Message(Messages.S106, codImpianto));
			}
			*/
			
			ArrayList<String> listaProgressivi = new ArrayList<String>();
			
			
			ArrayList<BigDecimal> moduliTermiciList = new ArrayList<BigDecimal>();
			// Ciclo per tutte le righe GT dell'xml
			for (int i = 0; i < listaRow.size(); i++) {
				RowAllegatoII rowAllegatoII = listaRow.get(i);
				SigitVSk4GtDto gt = null;
				
				moduliTermiciList.clear();

				boolean isTrovato = false;
				
				for (int z = 0; z < listGt.size(); z++) {
					gt = listGt.get(z);
					if (rowAllegatoII.getAENumGT().intValue() == gt.getProgressivo().intValue())
					{
						// Vuol dire che go trovato la riga anche sul DB
						isTrovato = true;
						
						// Aggiungo il rpogressivo alla lista, mi serve per verificare se esiste ilr esponsabile/3responsabile
						listaProgressivi.add(ConvertUtil.convertToString(rowAllegatoII.getAENumGT()));

						break;
					}
				}
				
				if (!isTrovato)
				{
					// Il numero del GT non è corretto
					throw new ValidationManagerException(new Message(Messages.S105, "A_E_numGT"));

				}

				List<it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowFumiDocument.RowFumi> listFumi = rowAllegatoII.getTabFumi().getRowFumiList();

				int nModuliDb = GenericUtil.isNotNullOrEmpty(gt.getNModuli())?gt.getNModuli().intValue() : 1;

				if (listFumi.size() != nModuliDb)
				{
					log.debug("[ValidationMgr::validazioneXmlImport] Step 3.10 – Il numero dei row fumi XML non corrisponde con il numero di row fumi del DB");

					// Non corrispondono le righe
					throw new ValidationManagerException(new Message(Messages.S107, codImpianto));
				}
				
				boolean potTermSup10KW = gt.getPotenzaTermicaKw().doubleValue() > 10;

				for (int j = 0; j < listFumi.size(); j++) {
					it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowFumiDocument.RowFumi rowFumi = listFumi.get(j);
					
					
					if (potTermSup10KW)
					{
						if (GenericUtil.isNullOrEmpty(rowFumi.getAETempFumi()))
						{
							throw new ValidationManagerException(new Message(Messages.S105, "A_E_tempFumi"));
						}


						if (GenericUtil.isNullOrEmpty(rowFumi.getAETempAria()))
						{
							throw new ValidationManagerException(new Message(Messages.S105, "A_E_tempAria"));

						}

						if (GenericUtil.isNullOrEmpty(rowFumi.getAEO2()))
						{
							throw new ValidationManagerException(new Message(Messages.S105, "A_E_O2"));

						}

						if (GenericUtil.isNullOrEmpty(rowFumi.getAECO2()))
						{
							throw new ValidationManagerException(new Message(Messages.S105, "A_E_CO2"));

						}

						if (GenericUtil.isNullOrEmpty(rowFumi.getAECOcorretto()))
						{
							throw new ValidationManagerException(new Message(Messages.S105, "A_E_COcorretto"));

						}

						if (GenericUtil.isNullOrEmpty(rowFumi.getAERendimCombu()))
						{
							throw new ValidationManagerException(new Message(Messages.S105, "A_E_rendimCombu"));

						}

						if (GenericUtil.isNullOrEmpty(rowFumi.getAERendimentoLegge()))
						{
							throw new ValidationManagerException(new Message(Messages.S105, "A_E_rendimentoLegge"));

						}

						if (GenericUtil.isNullOrEmpty(rowFumi.getAENox()))
						{
							throw new ValidationManagerException(new Message(Messages.S105, "A_E_nox"));

						}
					}

					if (GenericUtil.isNotNullOrEmpty(rowFumi.getAETempFumi()))
					{
						checkDecimali(rowFumi.getAETempFumi(), 4, 2, "A_E_tempFumi");
						
						//System.out.println("\n\nSTAMPO  TEMPERATURA FUMI: "+rowFumi.getAETempFumi());
					}

					if (GenericUtil.isNotNullOrEmpty(rowFumi.getAETempAria()))
					{
						checkDecimali(rowFumi.getAETempAria(), 4, 2, "A_E_tempAria");
						//System.out.println("\n\nSTAMPO  TEMPERATURA ARIA: "+rowFumi.getAETempAria());

					}

					if (GenericUtil.isNotNullOrEmpty(rowFumi.getAEO2()))
					{
						checkPercentuale(rowFumi.getAEO2(), "A_E_O2");
					}

					if (GenericUtil.isNotNullOrEmpty(rowFumi.getAECO2()))
					{
						checkPercentuale(rowFumi.getAECO2(), "A_E_CO2");
					}

					
					//La percentuale può essere maggiore del 100%
//					if (GenericUtil.isNotNullOrEmpty(rowFumi.getAERendimCombu()))
//					{
//						checkPercentuale(rowFumi.getAERendimCombu(), "A_E_rendimCombu");
//					}
//
//					if (GenericUtil.isNotNullOrEmpty(rowFumi.getAERendimentoLegge()))
//					{
//						checkPercentuale(rowFumi.getAERendimentoLegge(), "A_E_rendimentoLegge");
//					}

					if (GenericUtil.isNullOrEmpty(rowFumi.getAEModuloTermico()))
					{
						throw new ValidationManagerException(new Message(Messages.S105, "A_E_moduloTermico"));

					}
					
					if (moduliTermiciList.contains(rowFumi.getAEModuloTermico()))
					{
						// Il numero del modulo non è corretto, è già presente lo stesso numero A_E_moduloTermico
						throw new ValidationManagerException(new Message(Messages.S105, "A_E_moduloTermico"));
					}
					else
					{
						moduliTermiciList.add(rowFumi.getAEModuloTermico());
					}
					
//					else if (rowFumi.getAEModuloTermico().intValue()-1 != j)
//					{
//						// Il numero del modulo non è corretto
//						throw new ValidationManagerException(new Message(Messages.S105, "A_E_moduloTermico"));
//					}


					if (GenericUtil.isNotNullOrEmpty(rowFumi.getAEPortataCombu()))
					{
						if (!(rowFumi.getAEPortataCombu().equalsIgnoreCase(Constants.DES_M3H) ||
								rowFumi.getAEPortataCombu().equalsIgnoreCase(Constants.DES_KGH)))
						{
							throw new ValidationManagerException(new Message(Messages.S108));
						}
					}


					if (GenericUtil.isNotNullOrEmpty(rowFumi.getAEValorePortata()))
					{
						checkDecimali(rowFumi.getAEValorePortata(), 4, 2, "A_E_valorePortata");
						
						if (GenericUtil.isNullOrEmpty(rowFumi.getAEPortataCombu()))
						{
							throw new ValidationManagerException(new Message(Messages.S109));
						}
					}


					if (GenericUtil.isNotNullOrEmpty(rowFumi.getAECOfumiSecchi()))
					{
						checkDecimali(rowFumi.getAECOfumiSecchi(), 4, 2, "A_E_COfumiSecchi");
					}

				}

				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVEner = rowAllegatoII.getControlloVerificaEnergetica();

				checkDecimali(controlloVEner.getAEPotenzaFocolare(), 6, 2, "A_E_potenzaFocolare");


				if (!(controlloVEner.getAEFlagClimatizInv() ||
						controlloVEner.getAEFlagProduzACS()))
				{
					throw new ValidationManagerException(new Message(Messages.S105, "A_E_flagClimatizInv e/o A_E_flagProduzACS"));

				}

				check3Flag(controlloVEner.getAEFlagDispComando(), "A_E_flagDispComando");
				check3Flag(controlloVEner.getAEFlagDispSicu(), "A_E_flagDispSicu");
				check3Flag(controlloVEner.getAEFlagValvSicu(), "A_E_flagValvSicu");
				check3Flag(controlloVEner.getAEFlagScambiatore(), "A_E_flagScambiatore");
				check3Flag(controlloVEner.getAEFlagRiflusso(), "A_E_flagRiflusso");
				check3Flag(controlloVEner.getAEFlagRisultati(), "A_E_flagRisultati");
				
				// DA TESTARE IL SALVATAGGIO DETT tipo 1
				if (GenericUtil.isNotNullOrEmpty(controlloVEner.getAEAltroRifNormativo()) && 
						(controlloVEner.getAEAltroRifNormativo().length() > Constants.MAX_100))
				{
					controlloVEner.setAEAltroRifNormativo(controlloVEner.getAEAltroRifNormativo().substring(0, Constants.MAX_100));
				}

				if (!(controlloVEner.getAEFlagEvacFumi().equalsIgnoreCase(Constants.COD_NATURALE) ||
						controlloVEner.getAEFlagEvacFumi().equalsIgnoreCase(Constants.COD_FORZATA)))
				{
					throw new ValidationManagerException(new Message(Messages.S105, "A_E_flagEvacFumi"));
				}

				if (GenericUtil.isNotNullOrEmpty(controlloVEner.getAEDepressCanaleFumo()))
				{
					checkDecimali(controlloVEner.getAEDepressCanaleFumo(), 5, 2, "A_E_depressCanaleFumo");
				}

			}
			
			// Devo verificare che per tutte le componenti esista il responsabile/3responsabile
			if (isNessunResponsabileByCodImpiantoApp(codImpianto, dataControllo, Constants.TIPO_COMPONENTE_GT, listaProgressivi))
			{
				throw new ValidationManagerException(new Message(Messages.S112, ConvertUtil.convertToString(dataControllo)));
			}
		}
		catch (ValidationManagerException e)
		{
			throw e;
		}
		catch (Exception e)
		{
			log.error("Errore: ", e);
			throw new ValidationManagerException(new Message(Messages.ERRORE_NON_PREVISTO_BATCH));
		}

		log.debug("[ValidationMgr::validazioneFormaleAllegatoII] END");

	}

	private void validazioneFormaleAllegatoIII(it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RichiestaDocument.Richiesta richiesta, BigDecimal idPersonaGiuridica) throws ValidationManagerException
	{
		log.debug("[ValidationMgr::validazioneFormaleAllegatoIII] BEGIN");

		try
		{

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiIntestazioneDocument.DatiIntestazione intestazione = richiesta.getDatiIntestazione();
			String codImpianto = intestazione.getCodiceCatasto();
			Date dataControllo = ConvertUtil.convertToDate(intestazione.getAFDataControllo());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiAllegatoDocument.DatiAllegato allegato = richiesta.getDatiAllegato();

			// Le date bisogna verificarle?????

			checkDecimali(allegato.getDatiIdentificativi().getAAPotenzaTermicaNomTotMax(), 6, 2, "A_A_potenzaTermicaNomTotMax"); ;

			//it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica doc = richiesta.getDatiAllegato().getDocumentazioneTecnica();


			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.ControlloImpiantoDocument.ControlloImpianto contrImp = richiesta.getDatiAllegato().getControlloImpianto();

			//sezione c. tRATTAMENTO DELL'ACQUA
			SigitTTrattH2ODto dettaglioTrattAcqua = getDbMgr().cercaTrattAcquaByCodiceImpianto(codImpianto);
			//		getL23FlgTrattClimaAssente
			//		getL23FlgTrattClimaFiltr
			//		getL23FlgTrattClimaAddolc
			//		getL23FlgTrattClimaChimico
			//		
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.TrattamentoAcquaDocument.TrattamentoAcqua trattAcqua = richiesta.getDatiAllegato().getTrattamentoAcqua();

			if (!(ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAssente()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaFiltr()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAddolc()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaChimico())))
			{
				if (!trattAcqua.getACFlagTrattH2ONR())
				{
					// Questo valore deve essere true!

					throw new ValidationManagerException(new Message(Messages.S105, "A_C_flagTrattH2ONR"));
				}
			}
			
			check3Flag(contrImp.getADFlagLocaleIdoneo(), "A_D_flagLocaleIdoneo");
			check3Flag(contrImp.getADFlagDimensioni(), "A_D_flagDimensioni");
			check3Flag(contrImp.getADFlagAperture(), "A_D_flagAperture");
			check3Flag(contrImp.getADFlagLineeIdonee(), "A_D_flagLineeIdonee");
			check3Flag(contrImp.getADFlagCoibenIdonee(), "A_D_flagCoibenIdonee");

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.CheckListDocument.CheckList checkList = richiesta.getDatiAllegato().getCheckList();

			if (GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni()) && 
					(checkList.getAFOsservazioni().length() > Constants.MAX_1000))
			{
				checkList.setAFOsservazioni(checkList.getAFOsservazioni().substring(0, Constants.MAX_1000));
			}
			
			if (GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni()) && 
					(checkList.getAFRaccomandazioni().length() > Constants.MAX_1000))
			{
				checkList.setAFRaccomandazioni(checkList.getAFRaccomandazioni().substring(0, Constants.MAX_1000));
			}
			
			if (GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni()) && 
					(checkList.getAFPrescrizioni().length() > Constants.MAX_1000))
			{
				checkList.setAFPrescrizioni(checkList.getAFPrescrizioni().substring(0, Constants.MAX_1000));
			}

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiTecnicoDocument.DatiTecnico datiTecnico = richiesta.getDatiAllegato().getDatiTecnico();

			if (GenericUtil.isNullOrEmpty(datiTecnico.getAFNomeTecnico()))
			{
				throw new ValidationManagerException(new Message(Messages.S105, "A_F_nomeTecnico"));
			}
			
			if (GenericUtil.isNullOrEmpty(datiTecnico.getAFCognomeTecnico()))
			{
				throw new ValidationManagerException(new Message(Messages.S105, "A_F_cognomeTecnico"));
			}
			
			//it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowAllegatoIIDocument.RowAllegatoII rowAllegatoII = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
			List<RowAllegatoIII> listaRow = richiesta.getDatiAllegato().getAllegatoIII().getRowAllegatoIIIList();

			List<SigitVSk4GfDto> listGf = getDbMgr()
					.getCompGfAttiviInData(codImpianto, dataControllo, idPersonaGiuridica);

			
			if (listaRow == null || listGf == null)
			{
				// Ci vuole unS MSG specifico?
				throw new ValidationManagerException(new Message(Messages.S105, "rowAllegatoIII"));
			}
			/*
			else if (listaRow.size() != listGf.size())
			{
				
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.8 – Il numero dei row XML non corrisponde con il numero dei GT sul DB");

				// Non corrispondono le righe
				throw new ValidationManagerException(new Message(Messages.S106, codImpianto));
			}
			*/
			
			ArrayList<BigInteger> numCircuitoList = new ArrayList<BigInteger>();
			ArrayList<String> listaProgressivi = new ArrayList<String>();

			for (int i = 0; i < listaRow.size(); i++) {
				RowAllegatoIII rowAllegatoIII = listaRow.get(i);
				
				numCircuitoList.clear();
				
				boolean isTrovato = false;
				SigitVSk4GfDto gf = null;
				for (int z = 0; z < listGf.size(); z++) {
					gf = listGf.get(z);
					if (rowAllegatoIII.getAENumGF().intValue() == gf.getProgressivo().intValue())
					{
						isTrovato = true;
						
						// Aggiungo il rpogressivo alla lista, mi serve per verificare se esiste ilr esponsabile/3responsabile
						listaProgressivi.add(ConvertUtil.convertToString(rowAllegatoIII.getAENumGF()));

						break;
					}
				}
				
				if (!isTrovato)
				{
					// Il numero del GF non è corretto
					throw new ValidationManagerException(new Message(Messages.S105, "A_E_numGF"));

				}

				List<it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowFumiDocument.RowFumi> listFumi = rowAllegatoIII.getTabFumi().getRowFumiList();

				int nCircuitiDb = GenericUtil.isNotNullOrEmpty(gf.getNCircuiti())?gf.getNCircuiti().intValue() : 1;

				if (listFumi.size() != nCircuitiDb)
				{
					log.debug("[ValidationMgr::validazioneXmlImport] Step 3.10 – Il numero dei row fumi XML non corrisponde con il numero di row fumi del DB");

					// Non corrispondono le righe
					throw new ValidationManagerException(new Message(Messages.S107, codImpianto));
				}
				
				for (int j = 0; j < listFumi.size(); j++) {
					it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowFumiDocument.RowFumi rowFumi = listFumi.get(j);
					
					checkDecimali(rowFumi.getAESurrisc(), 5, 2, "A_E_surrisc");
					checkDecimali(rowFumi.getAESottoRaffr(), 5, 2, "A_E_sottoRaffr");
					checkDecimali(rowFumi.getAECondens(), 5, 2, "A_E_condens");
					checkDecimali(rowFumi.getAEEvaporaz(), 5, 2, "A_E_evaporaz");
					checkDecimali(rowFumi.getAEIngLatoEst(), 5, 2, "A_E_ingLatoEst");
					checkDecimali(rowFumi.getAEUscLatoEst(), 5, 2, "A_E_uscLatoEst");
					checkDecimali(rowFumi.getAEIngLatoUtenze(), 5, 2, "A_E_ingLatoUtenze");
					checkDecimali(rowFumi.getAEUscLatoUtenze(), 5, 2, "A_E_uscLatoUtenze");

					
					if (numCircuitoList.contains(rowFumi.getAENumCircuito()))
					{
						// Il numero del modulo non è corretto, è già presente lo stesso numero A_E_numCircuito
						throw new ValidationManagerException(new Message(Messages.S105, "A_E_numCircuito"));
					}
					else
					{
						numCircuitoList.add(rowFumi.getAENumCircuito());
					}
					
					if (GenericUtil.isNotNullOrEmpty(rowFumi.getAETbulboUmido()))
					{
						checkDecimali(rowFumi.getAETbulboUmido(), 5, 2, "A_E_TbulboUmido");
					}

					if (GenericUtil.isNotNullOrEmpty(rowFumi.getAETingFluidoSorg()))
					{
						checkDecimali(rowFumi.getAETingFluidoSorg(), 5, 2, "A_E_TingFluidoSorg");
					}

					if (GenericUtil.isNotNullOrEmpty(rowFumi.getAETuscFluidoSorg()))
					{
						checkDecimali(rowFumi.getAETuscFluidoSorg(), 5, 2, "A_E_TuscFluidoSorg");
					}

					if (GenericUtil.isNotNullOrEmpty(rowFumi.getAETingFluidoMacc()))
					{
						checkDecimali(rowFumi.getAETingFluidoMacc(), 5, 2, "A_E_TingFluidoMacc");
					}
					
					if (GenericUtil.isNotNullOrEmpty(rowFumi.getAETuscFluidoMacc()))
					{
						checkDecimali(rowFumi.getAETuscFluidoMacc(), 5, 2, "A_E_TuscFluidoMacc");
					}

					if (GenericUtil.isNotNullOrEmpty(rowFumi.getAEPotenzaAss()))
					{
						checkDecimali(rowFumi.getAEPotenzaAss(), 5, 2, "A_E_potenzaAss");
					}
					
					if (GenericUtil.isNotNullOrEmpty(rowFumi.getAEVerifica()) && 
							!rowFumi.getAEVerifica() && GenericUtil.isNullOrEmpty(rowFumi.getAEDataRipristino()))
					{
						throw new ValidationManagerException(new Message(Messages.S105, "A_E_dataRipristino"));
					}

				}

				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVEner = rowAllegatoIII.getControlloVerificaEnergetica();

				
				if (!(controlloVEner.getAEFlagModalita().equalsIgnoreCase(Constants.COD_RAFFRESCAMENTO) ||
						controlloVEner.getAEFlagModalita().equalsIgnoreCase(Constants.COD_RISCALDAMENTO)))
				{
					throw new ValidationManagerException(new Message(Messages.S105, "A_E_flagModalita"));
				}

				check3Flag(controlloVEner.getAEFlagPerdite(), "A_E_flagPerdite");
				check3Flag(controlloVEner.getAEFlagRilevFugheDiretta(), "A_E_flagRilevFugheDiretta");
				check3Flag(controlloVEner.getAEFlagRilevFugheInDiretta(), "A_E_flagRilevFugheInDiretta");
				check3Flag(controlloVEner.getAEFlagScambPuliti(), "A_E_flagScambPuliti");


			}

			// Devo verificare che per tutte le componenti esista il responsabile/3responsabile
			if (isNessunResponsabileByCodImpiantoApp(codImpianto, dataControllo, Constants.TIPO_COMPONENTE_GF, listaProgressivi))
			{
				throw new ValidationManagerException(new Message(Messages.S112, ConvertUtil.convertToString(dataControllo)));
			}
		}
		catch (ValidationManagerException e)
		{
			throw e;
		}
		catch (Exception e)
		{
			log.error("Errore: ", e);
			throw new ValidationManagerException(new Message(Messages.ERRORE_NON_PREVISTO_BATCH));
		}

		log.debug("[ValidationMgr::validazioneFormaleAllegatoIII] END");

	}

	private void validazioneFormaleAllegatoIV(it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RichiestaDocument.Richiesta richiesta, BigDecimal idPersonaGiuridica) throws ValidationManagerException
	{
		log.debug("[ValidationMgr::validazioneFormaleAllegatoIV] BEGIN");

		try
		{

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiIntestazioneDocument.DatiIntestazione intestazione = richiesta.getDatiIntestazione();
			String codImpianto = intestazione.getCodiceCatasto();
			Date dataControllo = ConvertUtil.convertToDate(intestazione.getAFDataControllo());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiAllegatoDocument.DatiAllegato allegato = richiesta.getDatiAllegato();

			// Le date bisogna verificarle?????

			checkDecimali(allegato.getDatiIdentificativi().getAAPotenzaTermicaNomTotMax(), 6, 2, "A_A_potenzaTermicaNomTotMax"); ;

			//it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica doc = richiesta.getDatiAllegato().getDocumentazioneTecnica();


			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.ControlloImpiantoDocument.ControlloImpianto contrImp = richiesta.getDatiAllegato().getControlloImpianto();

			
			check3Flag(contrImp.getADFlagLuogoIdoneo(), "A_D_flagLuogoIdoneo");
			check3Flag(contrImp.getADFlagLineeIdonee(), "A_D_flagLineeIdonee");
			check3Flag(contrImp.getADFlagStatoCoiben(), "A_D_flagStatoCoiben");
			check3Flag(contrImp.getADFlagPerdite(), "A_D_flagPerdite");

			//sezione c. tRATTAMENTO DELL'ACQUA
			SigitTTrattH2ODto dettaglioTrattAcqua = getDbMgr().cercaTrattAcquaByCodiceImpianto(codImpianto);
			//		getL23FlgTrattClimaAssente
			//		getL23FlgTrattClimaFiltr
			//		getL23FlgTrattClimaAddolc
			//		getL23FlgTrattClimaChimico
			//		
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.TrattamentoAcquaDocument.TrattamentoAcqua trattAcqua = richiesta.getDatiAllegato().getTrattamentoAcqua();

			if (!(ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAssente()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaFiltr()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAddolc()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaChimico())))
			{
				if (!trattAcqua.getACFlagTrattH2ONR())
				{
					// Questo valore deve essere true!

					throw new ValidationManagerException(new Message(Messages.S105, "A_C_flagTrattH2ONR"));
				}
			}

			if (!(ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsAssente()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsFiltr()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsAddolc()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsChimico())))
			{
				if (!trattAcqua.getACFlagTrattAcsNR())
				{
					// Questo valore deve essere true!

					throw new ValidationManagerException(new Message(Messages.S105, "A_C_flagTrattAcsNR"));
				}
			}

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.CheckListDocument.CheckList checkList = richiesta.getDatiAllegato().getCheckList();
			if (GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni()) && 
					(checkList.getAFOsservazioni().length() > Constants.MAX_1000))
			{
				checkList.setAFOsservazioni(checkList.getAFOsservazioni().substring(0, Constants.MAX_1000));
			}
			
			if (GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni()) && 
					(checkList.getAFRaccomandazioni().length() > Constants.MAX_1000))
			{
				checkList.setAFRaccomandazioni(checkList.getAFRaccomandazioni().substring(0, Constants.MAX_1000));
			}
			
			if (GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni()) && 
					(checkList.getAFPrescrizioni().length() > Constants.MAX_1000))
			{
				checkList.setAFPrescrizioni(checkList.getAFPrescrizioni().substring(0, Constants.MAX_1000));
			}

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiTecnicoDocument.DatiTecnico datiTecnico = richiesta.getDatiAllegato().getDatiTecnico();

			if (GenericUtil.isNullOrEmpty(datiTecnico.getAFNomeTecnico()))
			{
				throw new ValidationManagerException(new Message(Messages.S105, "A_F_nomeTecnico"));
			}
			
			if (GenericUtil.isNullOrEmpty(datiTecnico.getAFCognomeTecnico()))
			{
				throw new ValidationManagerException(new Message(Messages.S105, "A_F_cognomeTecnico"));
			}

			//it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowAllegatoIIDocument.RowAllegatoII rowAllegatoII = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
			List<RowAllegatoIV> listaRow = richiesta.getDatiAllegato().getAllegatoIV().getRowAllegatoIVList();
			List<SigitVSk4ScDto> listSc = getDbMgr().getCompScAttiviInData(codImpianto, dataControllo, idPersonaGiuridica);

			
			if (listaRow == null || listSc == null)
			{
				// Ci vuole unS MSG specifico?
				throw new ValidationManagerException(new Message(Messages.S105, "rowAllegatoIV"));
			}
			/*
			else if (listaRow.size() != listSc.size())
			{
				
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.8 – Il numero dei row XML non corrisponde con il numero dei SC sul DB");

				// Non corrispondono le righe
				throw new ValidationManagerException(new Message(Messages.S106, codImpianto));
			}
			*/
			
			ArrayList<String> listaProgressivi = new ArrayList<String>();

			for (int i = 0; i < listaRow.size(); i++) {
				RowAllegatoIV rowAllegatoIV = listaRow.get(i);

				SigitVSk4ScDto sc = null;

				boolean isTrovato = false;
				for (int z = 0; z < listSc.size(); z++) {
					sc = listSc.get(z);
					if (rowAllegatoIV.getAENumSC().intValue() == sc.getProgressivo().intValue())
					{
						isTrovato = true;
						
						// Aggiungo il rpogressivo alla lista, mi serve per verificare se esiste ilr esponsabile/3responsabile
						listaProgressivi.add(ConvertUtil.convertToString(rowAllegatoIV.getAENumSC()));
						
						break;
					}
				}
				
				if (!isTrovato)
				{
					// Il numero del SC non è corretto
					throw new ValidationManagerException(new Message(Messages.S105, "A_E_numSC"));

				}

				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RowFumiDocument.RowFumi rowFumi = rowAllegatoIV.getTabFumi().getRowFumi();


				checkDecimali(rowFumi.getAETempEst(), 4, 2, "A_E_tempEst");
				checkDecimali(rowFumi.getAETempMandPrim(), 4, 2, "A_E_tempMandPrim");
				checkDecimali(rowFumi.getAETempRitPrim(), 3, 2, "A_E_tempRitPrim");
				checkDecimali(rowFumi.getAEPotenzaTerm(), 3, 2, "A_E_potenzaTerm");
				checkDecimali(rowFumi.getAEPortataFluido(), 3, 2, "A_E_portataFluido");
				checkDecimali(rowFumi.getAETempMandSecond(), 3, 2, "A_E_tempMandSecond");
				checkDecimali(rowFumi.getAETempRitSecond(), 3, 2, "A_E_tempRitSecond");

				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVEner = rowAllegatoIV.getControlloVerificaEnergetica();

				//checkDecimali(controlloVEner.getAEPotenzaFocolare(), 6, 2, "A_E_potenzaFocolare");


				if (!(controlloVEner.getAEFlagClimatizInv() ||
						controlloVEner.getAEFlagProduzACS()))
				{
					throw new ValidationManagerException(new Message(Messages.S105, "A_E_flagClimatizInv-A_E_flagProduzACS"));

				}

				if (!GenericUtil.checkValideNumber(controlloVEner.getAECombustibile()) || 
						getDbMgr().cercaFluidoById(controlloVEner.getAECombustibile()) == null)
				{
					// Il codice fluido è inesistente
					throw new ValidationManagerException(new Message(Messages.S105, "A_E_combustibile"));

				}
				
				if (!GenericUtil.checkValideNumber(controlloVEner.getAEFluidoVett()) || 
						getDbMgr().cercaFluidoById(controlloVEner.getAEFluidoVett()) == null)
				{
					// Il codice fluido è inesistente
					throw new ValidationManagerException(new Message(Messages.S105, "A_E_fluidoVett"));

				}
				
				check3Flag(controlloVEner.getAEFlagPotComp(), "A_E_flagPotComp");
				check3Flag(controlloVEner.getAEFlagStatoCoiben(), "A_E_flagStatoCoiben");
				check3Flag(controlloVEner.getAEFlagDispReg(), "A_E_flagDispReg");
				
			}
			
			// Devo verificare che per tutte le componenti esista il responsabile/3responsabile
			if (isNessunResponsabileByCodImpiantoApp(codImpianto, dataControllo, Constants.TIPO_COMPONENTE_SC, listaProgressivi))
			{
				throw new ValidationManagerException(new Message(Messages.S112, ConvertUtil.convertToString(dataControllo)));
			}
		}
		catch (ValidationManagerException e)
		{
			throw e;
		}
		catch (Exception e)
		{
			log.error("Errore: ", e);
			throw new ValidationManagerException(new Message(Messages.ERRORE_NON_PREVISTO_BATCH));
		}

		log.debug("[ValidationMgr::validazioneFormaleAllegatoIV] END");

	}
	

	private void validazioneFormaleAllegatoV(it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RichiestaDocument.Richiesta richiesta, BigDecimal idPersonaGiuridica) throws ValidationManagerException
	{
		log.debug("[ValidationMgr::validazioneFormaleAllegatoV] BEGIN");

		try
		{

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiIntestazioneDocument.DatiIntestazione intestazione = richiesta.getDatiIntestazione();
			String codImpianto = intestazione.getCodiceCatasto();
			Date dataControllo = ConvertUtil.convertToDate(intestazione.getAFDataControllo());

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiAllegatoDocument.DatiAllegato allegato = richiesta.getDatiAllegato();

			// Le date bisogna verificarle?????

			checkDecimali(allegato.getDatiIdentificativi().getAAPotenzaTermicaNomTotMax(), 6, 2, "A_A_potenzaTermicaNomTotMax"); ;

			//it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica doc = richiesta.getDatiAllegato().getDocumentazioneTecnica();


			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.ControlloImpiantoDocument.ControlloImpianto contrImp = richiesta.getDatiAllegato().getControlloImpianto();

			check3Flag(contrImp.getADFlagLuogoIdoneo(), "A_D_flagLuogoIdoneo");
			check3Flag(contrImp.getADFlagDimensioni(), "A_D_flagDimensioni");
			check3Flag(contrImp.getADFlagAperture(), "A_D_flagAperture");
			check3Flag(contrImp.getADFlagLineeIdonee(), "A_D_flagLineeIdonee");

			check3Flag(contrImp.getADFlagCanaleFumo(), "A_D_flagCanaleFumo");
			check3Flag(contrImp.getADFlagCapsulaInso(), "A_D_flagCapsulaInso");
			check3Flag(contrImp.getADFlagTenutaIdraulica(), "A_D_flagTenutaIdraulica");
			check3Flag(contrImp.getADFlagTenutaOlio(), "A_D_flagTenutaOlio");
			check3Flag(contrImp.getADFlagTenutaAlimentaz(), "A_D_flagTenutaAlimentaz");


			//sezione c. tRATTAMENTO DELL'ACQUA
			SigitTTrattH2ODto dettaglioTrattAcqua = getDbMgr().cercaTrattAcquaByCodiceImpianto(codImpianto);
			//		getL23FlgTrattClimaAssente
			//		getL23FlgTrattClimaFiltr
			//		getL23FlgTrattClimaAddolc
			//		getL23FlgTrattClimaChimico
			//		
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.TrattamentoAcquaDocument.TrattamentoAcqua trattAcqua = richiesta.getDatiAllegato().getTrattamentoAcqua();

			if (!(ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAssente()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaFiltr()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAddolc()) ||
					ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaChimico())))
			{
				if (!trattAcqua.getACFlagTrattH2ONR())
				{
					// Questo valore deve essere true!

					throw new ValidationManagerException(new Message(Messages.S105, "A_C_flagTrattH2ONR"));
				}
			}

			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.CheckListDocument.CheckList checkList = richiesta.getDatiAllegato().getCheckList();
			
			if (GenericUtil.isNotNullOrEmpty(checkList.getAFOsservazioni()) && 
					(checkList.getAFOsservazioni().length() > Constants.MAX_1000))
			{
				checkList.setAFOsservazioni(checkList.getAFOsservazioni().substring(0, Constants.MAX_1000));
			}
			
			if (GenericUtil.isNotNullOrEmpty(checkList.getAFRaccomandazioni()) && 
					(checkList.getAFRaccomandazioni().length() > Constants.MAX_1000))
			{
				checkList.setAFRaccomandazioni(checkList.getAFRaccomandazioni().substring(0, Constants.MAX_1000));
			}
			
			if (GenericUtil.isNotNullOrEmpty(checkList.getAFPrescrizioni()) && 
					(checkList.getAFPrescrizioni().length() > Constants.MAX_1000))
			{
				checkList.setAFPrescrizioni(checkList.getAFPrescrizioni().substring(0, Constants.MAX_1000));
			}
			
			it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiTecnicoDocument.DatiTecnico datiTecnico = richiesta.getDatiAllegato().getDatiTecnico();

			if (GenericUtil.isNullOrEmpty(datiTecnico.getAFNomeTecnico()))
			{
				throw new ValidationManagerException(new Message(Messages.S105, "A_F_nomeTecnico"));
			}
			
			if (GenericUtil.isNullOrEmpty(datiTecnico.getAFCognomeTecnico()))
			{
				throw new ValidationManagerException(new Message(Messages.S105, "A_F_cognomeTecnico"));
			}

			//it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowAllegatoIIDocument.RowAllegatoII rowAllegatoII = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();
			List<RowAllegatoV> listaRow = richiesta.getDatiAllegato().getAllegatoV().getRowAllegatoVList();
			List<SigitVSk4CgDto> listCg = getDbMgr().getCompCgAttiviInData(codImpianto, dataControllo, idPersonaGiuridica);

			if (listaRow == null || listCg == null)
			{
				// Ci vuole unS MSG specifico?
				throw new ValidationManagerException(new Message(Messages.S105, "rowAllegatoV"));
			}
			/*
			else if (listaRow.size() != listCg.size())
			{

				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.8 – Il numero dei row XML non corrisponde con il numero dei CG sul DB");

				// Non corrispondono le righe
				throw new ValidationManagerException(new Message(Messages.S106, codImpianto));
			}
			*/
			
			ArrayList<String> listaProgressivi = new ArrayList<String>();
			
			for (int i = 0; i < listaRow.size(); i++) {
				RowAllegatoV rowAllegatoV = listaRow.get(i);

				SigitVSk4CgDto cg = null;

				boolean isTrovato = false;
				for (int z = 0; z < listCg.size(); z++) {
					cg = listCg.get(z);
					if (rowAllegatoV.getAENumCG().intValue() == cg.getProgressivo().intValue())
					{
						isTrovato = true;
						
						// Aggiungo il rpogressivo alla lista, mi serve per verificare se esiste ilr esponsabile/3responsabile
						listaProgressivi.add(ConvertUtil.convertToString(rowAllegatoV.getAENumCG()));
						
						break;
					}
				}
				
				if (!isTrovato)
				{
					// Il numero del CG non è corretto
					throw new ValidationManagerException(new Message(Messages.S105, "A_E_numCG"));

				}

				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RowFumiDocument.RowFumi rowFumi = rowAllegatoV.getTabFumi().getRowFumi();


				checkDecimali(rowFumi.getAETempAriaCombur(), 4, 2, "A_E_tempAriaCombur");
				checkDecimali(rowFumi.getAETempAcquaUsc(), 4, 2, "A_E_tempAcquaUsc");
				checkDecimali(rowFumi.getAETempAcquaIng(), 3, 2, "A_E_tempAcquaIng");
				checkDecimali(rowFumi.getAEPotenzaMorsetti(), 3, 2, "A_E_potenzaMorsetti");
				checkDecimali(rowFumi.getAETempH2Omotore(), 3, 2, "A_E_tempH2Omotore");
				checkDecimali(rowFumi.getAETempFumiAvalle(), 3, 2, "A_E_tempFumiAvalle");
				checkDecimali(rowFumi.getAETempFumiAmonte(), 3, 2, "A_E_tempFumiAmonte");

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESovraFreqSoglia1()))
				{
					checkDecimali(rowFumi.getAESovraFreqSoglia1(), 3, 2, "A_E_sovraFreqSoglia1");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESovraFreqSoglia2()))
				{
					checkDecimali(rowFumi.getAESovraFreqSoglia2(), 3, 2, "A_E_sovraFreqSoglia2");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESovraFreqSoglia3()))
				{
					checkDecimali(rowFumi.getAESovraFreqSoglia3(), 3, 2, "A_E_sovraFreqSoglia3");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESovraFreqTempo1()))
				{
					checkDecimali(rowFumi.getAESovraFreqTempo1(), 3, 2, "A_E_sovraFreqTempo1");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESovraFreqTempo2()))
				{
					checkDecimali(rowFumi.getAESovraFreqTempo2(), 3, 2, "A_E_sovraFreqTempo2");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESovraFreqTempo3()))
				{
					checkDecimali(rowFumi.getAESovraFreqTempo3(), 3, 2, "A_E_sovraFreqTempo3");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESottoFreqSoglia1()))
				{
					checkDecimali(rowFumi.getAESottoFreqSoglia1(), 3, 2, "A_E_sottoFreqSoglia1");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESottoFreqSoglia2()))
				{
					checkDecimali(rowFumi.getAESottoFreqSoglia2(), 3, 2, "A_E_sottoFreqSoglia2");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESottoFreqSoglia3()))
				{
					checkDecimali(rowFumi.getAESottoFreqSoglia3(), 3, 2, "A_E_sottoFreqSoglia3");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESottoFreqTempo1()))
				{
					checkDecimali(rowFumi.getAESottoFreqTempo1(), 3, 2, "A_E_sottoFreqTempo1");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESottoFreqTempo2()))
				{
					checkDecimali(rowFumi.getAESottoFreqTempo2(), 3, 2, "A_E_sottoFreqTempo2");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESottoFreqTempo3()))
				{
					checkDecimali(rowFumi.getAESottoFreqTempo3(), 3, 2, "A_E_sottoFreqTempo3");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESovraTensSoglia1()))
				{
					checkDecimali(rowFumi.getAESovraTensSoglia1(), 3, 2, "A_E_sovraTensSoglia1");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESovraTensSoglia2()))
				{
					checkDecimali(rowFumi.getAESovraTensSoglia2(), 3, 2, "A_E_sovraTensSoglia2");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESovraTensSoglia3()))
				{
					checkDecimali(rowFumi.getAESovraTensSoglia3(), 3, 2, "A_E_sovraTensSoglia3");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESovraTensTempo1()))
				{
					checkDecimali(rowFumi.getAESovraTensTempo1(), 3, 2, "A_E_sovraTensTempo1");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESovraTensTempo2()))
				{
					checkDecimali(rowFumi.getAESovraTensTempo2(), 3, 2, "A_E_sovraTensTempo2");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESovraTensTempo3()))
				{
					checkDecimali(rowFumi.getAESovraTensTempo3(), 3, 2, "A_E_sovraTensTempo3");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESottoTensSoglia1()))
				{
					checkDecimali(rowFumi.getAESottoTensSoglia1(), 3, 2, "A_E_sottoTensSoglia1");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESottoTensSoglia2()))
				{
					checkDecimali(rowFumi.getAESottoTensSoglia2(), 3, 2, "A_E_sottoTensSoglia2");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESottoTensSoglia3()))
				{
					checkDecimali(rowFumi.getAESottoTensSoglia3(), 3, 2, "A_E_sottoTensSoglia3");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESottoTensTempo1()))
				{
					checkDecimali(rowFumi.getAESottoTensTempo1(), 3, 2, "A_E_sottoTensTempo1");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESottoTensTempo2()))
				{
					checkDecimali(rowFumi.getAESottoTensTempo2(), 3, 2, "A_E_sottoTensTempo2");
				}

				if (GenericUtil.isNotNullOrEmpty(rowFumi.getAESottoTensTempo3()))
				{
					checkDecimali(rowFumi.getAESottoTensTempo3(), 3, 2, "A_E_sottoTensTempo3");
				}

				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVEner = rowAllegatoV.getControlloVerificaEnergetica();


				if (!GenericUtil.checkValideNumber(controlloVEner.getAEFluidoVett()) || 
						getDbMgr().cercaFluidoById(controlloVEner.getAEFluidoVett()) == null)
				{
					// Il codice fluido è inesistente
					throw new ValidationManagerException(new Message(Messages.S105, "A_E_fluidoVett"));

				}

				checkDecimali(controlloVEner.getAEPotenzaAssorbita(), 5, 2, "A_E_potenzaAssorbita");
				checkDecimali(controlloVEner.getAEPotenzaTermByPass(), 5, 2, "A_E_potenzaTermByPass");

			}
			
			// Devo verificare che per tutte le componenti esista il responsabile/3responsabile
			if (isNessunResponsabileByCodImpiantoApp(codImpianto, dataControllo, Constants.TIPO_COMPONENTE_CG, listaProgressivi))
			{
				throw new ValidationManagerException(new Message(Messages.S112, ConvertUtil.convertToString(dataControllo)));
			}
		}
		catch (ValidationManagerException e)
		{
			throw e;
		}
		catch (Exception e)
		{
			log.error("Errore: ", e);
			throw new ValidationManagerException(new Message(Messages.ERRORE_NON_PREVISTO_BATCH));
		}

		log.debug("[ValidationMgr::validazioneFormaleAllegatoV] END");

	}

	/**
	 * Verifica se un valore e' numerico
	 * 
	 * @param number Numero da verificare
	 * @param maxLength Numero massimo di cifre ammesse
	 * @param numberField Campo associato al nome
	 * @return Restituisce il numero convertito in long
	 * @throws ValidationManagerException Il valore non e' un numero
	 */
	protected long checkNumber(String number, int minLenght, int maxLenght, String numberTag) throws ValidationManagerException {
		ValidationManagerException ex = null;
		long value;

		value = 0;
		if(StringUtils.isNotBlank(number)) {
			
			try
			{
			
			if(!StringUtils.isNumeric(number)) {
				throw new ValidationManagerException(new Message(Messages.S105, numberTag));
			}
			checkNumeroIntero(number, numberTag);
			if(number.length() < minLenght) {
				
				throw new ValidationManagerException(new Message(Messages.S105, numberTag));
			}
			if(number.length() > maxLenght) {
				
				throw new ValidationManagerException(new Message(Messages.S105, numberTag));
			}
			value = new BigDecimal(number).longValue();
			if(value < 0) {
				throw new ValidationManagerException(new Message(Messages.S105, numberTag));
			}
			}
			catch (ValidationManagerException valEx)
			{
				
				throw new ValidationManagerException(new Message(Messages.S105, numberTag));			
				
			}
		}
		
		return value;
	}
	
	
	/**
	 * Verifica se un numero e' in formato intero. CHK9
	 * 
	 * @param numeroDaVerificare Numero da verificare
	 * @param numberField Campo associato al nome
	 * @return Numero convertito in intero
	 * @throws ValidationManagerException Il numero non e' informato intero
	 */
	protected long checkNumeroIntero(String numeroDaVerificare, String numberTag) throws ValidationManagerException {
		ValidationManagerException ex = null;
		long numero;

		try {
			numero = new BigDecimal(numeroDaVerificare).longValue();
		}
		catch(NumberFormatException e) {
			throw new ValidationManagerException(new Message(Messages.S105, numberTag));

		}
		return numero;
	}
	
	/**
	 * Verifica i decimali presenti in un numero (MODIFICATO, arrotonda al numero di decimali)
	 * 
	 * @param number Numero da verificare (accetta numeri decimali sia con la
	 *            virgola che con il punto come separatore dei decimali)
	 * @param numeroCifreIntere Numero massimo di interi che devono essere
	 *            presenti
	 * @param numeroCifreDecimali Numero massimo di decimali che devono essere
	 *            presenti
	 * @param numberField Campo associato al nome
	 * @throws ValidationManagerException Il numero contiene un numero errato di
	 *             decimali
	 */
	public void checkDecimali(BigDecimal number, int numeroCifreIntere, int numeroCifreDecimali, String numberTag) throws ValidationManagerException {
		
		//number = number.setScale(numeroCifreDecimali, BigDecimal.ROUND_HALF_UP);

		checkDecimali(ConvertUtil.convertToString(number), numeroCifreIntere, numeroCifreDecimali, numberTag);
	}
	
	/**
	 * Verifica i decimali presenti in un numero
	 * 
	 * @param number Numero da verificare (accetta numeri decimali sia con la
	 *            virgola che con il punto come separatore dei decimali)
	 * @param numeroCifreIntere Numero massimo di interi che devono essere
	 *            presenti
	 * @param numeroCifreDecimali Numero massimo di decimali che devono essere
	 *            presenti
	 * @param numberField Campo associato al nome
	 * @throws ValidationManagerException Il numero contiene un numero errato di
	 *             decimali
	 */
	public void checkDecimali(String number, int numeroCifreIntere, int numeroCifreDecimali, String numberTag) throws ValidationManagerException {
		ValidationManagerException ex = null;
		Pattern p = null;
		Matcher m = null;
		String regExpr = null;
		String nextTokenDot = null;
		String nextTokenComma = null;
		int index;

		regExpr = "[+,-]?\\d{1," + numeroCifreIntere + "}+";
		nextTokenDot = "|[+,-]?\\d{1," + numeroCifreIntere + "}+\\.\\d";
		nextTokenComma = "|[+,-]?\\d{1," + numeroCifreIntere + "}+,\\d";
		for(index = 0; index < numeroCifreDecimali; index++) {
			regExpr += nextTokenDot + nextTokenComma;
			nextTokenDot += "\\d";
			nextTokenComma += "\\d";
		}
		p = Pattern.compile(regExpr);
		m = p.matcher(number);
		if(!m.matches()) {
			
			throw new ValidationManagerException(new Message(Messages.S105, numberTag));

		}
	}
	
	/**
	 * Verifica i decimali presenti in un numero
	 * 
	 * @param number Numero da verificare (accetta numeri decimali sia con la
	 *            virgola che con il punto come separatore dei decimali)
	 * @param numeroCifreIntere Numero massimo di interi che devono essere
	 *            presenti
	 * @param numeroCifreDecimali Numero massimo di decimali che devono essere
	 *            presenti
	 * @param numberField Campo associato al nome
	 * @throws ValidationManagerException Il numero contiene un numero errato di
	 *             decimali
	 */
	public void checkPercentuale(BigDecimal number, String numberTag) throws ValidationManagerException {
		ValidationManagerException ex = null;
		
		if (number.doubleValue() > 100)
		{
			throw new ValidationManagerException(new Message(Messages.S105, numberTag));
		}

	}
	
	/**
	 * Verifica se un flag  e' 0=NO; 1=SI; 2=NC
	 * 
	 * @param flgDaVerificare Flag da verificare
	 * @param flgTag Campo associato al nome
	 * @throws ValidationManagerException Il flag non e' quello atteso
	 */
	protected void check3Flag(BigInteger flgDaVerificare, String flgTag) throws ValidationManagerException {

		if (flgDaVerificare != null)
		{
			int flg = flgDaVerificare.intValue();
	
			//System.out.println("STAMPO IL FLAG ("+flgTag+"): "+flg);
			
			if (flg != 0 &&
					flg != 1 &&
					flg != 2)
			{
				throw new ValidationManagerException(new Message(Messages.S105, flgTag));
	
			}
		}
	}
	
	
	private void checkCodiceFiscalePartitaIva(String codiceFiscale) throws ValidationManagerException {
//		ValidationManagerException ex = null;
		
		if (GenericUtil.isNotNullOrEmpty(codiceFiscale))
		{
			
			if (codiceFiscale.length() == Constants.PARTITA_IVA_LEN)
			{
				controlloPIVA(codiceFiscale);
			}
			else
			{
				controlloCf(codiceFiscale);
			}
			
			
//			if(codiceFiscale.length() > Constants.CODICE_FISCALE_LEN) {
//				ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_CODICE_FISCALE));
//				ex.addField(codiceFiscaleField);
//				throw ex;
//			}
			
			
		}
	}
	
	private void controlloCf(String codFiscale) throws ValidationManagerException{
		ValidationManagerException ex = null;
		char caratt;
		boolean ok = false;
		int controllo = -1;
		int resto;
		int sum_pari = 0;
		int sum_dispari = 0;
		// per l'ulteriore controllo del carattere finale
		int restoTwo = 0;
		String codiceFiscale = codFiscale!=null?codFiscale.toUpperCase():"";
		
		//log.debug("CODICE_FISCALE: "+codFiscale);

		if ((codFiscale != null) && (codFiscale.length() == 16)) {
			
			codFiscale = codFiscale.toUpperCase();
			for (int i = 1; i <= 15; i++) {
				int row;
				caratt = codFiscale.charAt(0);
				codFiscale = codFiscale.substring(1);

				for (row = 1; row <= 36; row++) {
					if (carattere[row - 1] == caratt) {
						if ((i / 2) * 2 == i) {
							sum_pari = sum_pari + valore_pari[row - 1];
							break;
						} else {
							sum_dispari = sum_dispari + valore_dispari[row - 1];
							break;
						}
					}
				}
				// Occorre controllare se l'utente ha inserito caratteri non
				// alfanumerici,
				// perché in alcuni casi, con probabilità minima ma non nulla,
				// il metodo
				// potrebbe non restituire il messaggio di errore
				if (row > 36) {
					// Il carattere non corrisponde a nessun valore salvato
					// nell'array
					// 'carattere', per cui viene creato il messaggio di errore
					// e si
					// forza l'uscita dal metodo, per non eseguire altro codice
					// a questo
					// punto inutile
					ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_CODICE_FISCALE, codFiscale));
					throw ex;
				}
			}

			resto = (sum_pari + sum_dispari) - ((sum_pari + sum_dispari) / 26)
					* 26;
			caratt = codFiscale.charAt(0);

			for (int row = 1; row <= 36; row++) {
				if (carattere[row - 1] == caratt) {
					controllo = valore_pari[row - 1];
					break;
				}
			}
			/**
			 * ci sono alcuni casi in cui fare affidamemto al controllo di
			 * seguito non è sufficiente per il corretto controllo del codice
			 * fiscale allora aggiungo io un controllo utilizzando il carattere
			 * di controllo finale del codice fiscale
			 */
			if (controllo == resto)
				ok = true;

			/**
			 * a questo punto visto che questo controllo non è molto preciso
			 * vado a fare il controllo dell'ultimo carattere ma fuori allora
			 * devo prendere il resto che è stato trovato precedentemente
			 */
			restoTwo = resto;

			if (ok) {
				/**
				 * agginta di francesca in data 17/01/2006 perchè non funziona il
				 * controllo sopra per il codice fiscale: mrlmfsc97s20c351 faccio
				 * l'ulteriore controllo del carattere finale di controllo
				 */
				
				if (carattere_di_controllo[restoTwo] == codiceFiscale.charAt(15))
					ok = true;
				else
					ok = false;
			}
		}

		if (!ok) {
//			log.debug("ERROR_FORMALE_CODICE_FISCALE - codFiscale: "+codFiscale);
//			log.debug("ERROR_FORMALE_CODICE_FISCALE - codiceFiscale: "+codiceFiscale);

			ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_CODICE_FISCALE, codiceFiscale));
			
			//log.debug("ERROR_FORMALE_CODICE_FISCALE MSG: "+ex.getMsg());
			
			//log.error("Errore codFiscale: "+codiceFiscale);

			throw ex;
		}
	}
	
	
	private void controlloPIVA(String partitaIva) throws ValidationManagerException {
		boolean ok = false;
		int somma = 0;
		ValidationManagerException ex = null;
		//log.debug("PARTITA_IVA: "+partitaIva);

		if (isValidateCurrency(partitaIva) && (partitaIva != null) && (partitaIva.length() == 11)) {
			for (int i = 0; i <= 8; i += 2) {
				somma += partitaIva.charAt(i) - '0';
			}

			for (int i = 1; i <= 9; i += 2) {
				int temp = (partitaIva.charAt(i) - '0') * 2;
				if (temp > 9)
					temp -= 9;
				somma += temp;
			}

			if ((10 - somma % 10) % 10 == partitaIva.charAt(10) - '0') {
				ok = true;
			}
		}

		if (!ok)
		{
			//log.debug("ERROR_PARTITA_IVA: "+partitaIva);
			ex = new ValidationManagerException(new Message(Messages.ERROR_PARTITA_IVA, partitaIva));
			
			//log.error("Errore partitaIva: "+partitaIva);
			
			throw ex;
		}
	}
	
	
	public void checkIsNotValidYear(String s) throws ValidationManagerException {
		ValidationManagerException ex = null;
		if(!Pattern.compile("^(19|20)[0-9][0-9]").matcher(s).find()) {
			// The string is not valid.
			ex = new ValidationManagerException(new Message(Messages.S115));
			throw ex;
		}
	}
	
	public Date chekIsNotValidDate(String date, String pattern) throws ValidationManagerException {
		Date risultato = null;
		ValidationManagerException ex = null;
		try {
			risultato = ConvertUtil.convertToDate(date, pattern);
		} catch (Exception e) {
			ex = new ValidationManagerException(new Message(Messages.S116));
			throw ex;
		}
//		boolean valida = DateUtil.checkValideDate(date);
//		if (!valida) {
//			ex = new ValidationManagerException(new Message(Messages.S116));
//			throw ex;
//		}
		return risultato;
	}
	
	public void checkAnnoFuturo (String s) throws ValidationManagerException {
		ValidationManagerException ex = null;
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		if (currentYear < Integer.parseInt(s)) {
			ex = new ValidationManagerException(new Message(Messages.S115_bis, s));
			throw ex;
		}
	}
	
	public boolean isValidateCurrency(String field) throws ValidationManagerException{
		boolean isValidate = false;
		if (field == null || field.length() == 0)
			return isValidate;
		try {
			Double.parseDouble(field);
			isValidate = true;
			return isValidate;
		} catch (NumberFormatException nfEx) {
			return isValidate;
		}
	}
	
	/**
	 * Controllo se l'impianto è privo di valcole termostatiche
	  * @param Integer idPgAllegato
	  * @param Integer idPgUtente
	  * @throws ValidationManagerException 
	 */

	public boolean isImpiantoSenzaValvoleTermostatiche(Date dataControllo, String codImpianto) throws ValidationManagerException {

		try
		{
			SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoById(codImpianto);
			List<SigitTDocAggiuntivaDto> docAgg = getDbMgr().cercaDocumentoAggDerogaByCodImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			boolean isDeroga = (docAgg != null && docAgg.size() > 0);
			//SigitTCompXSempliceDto compX = getDbMgr().cercaSigitTCompXSempliceByCodImpianto(codImpianto);

			String dataMaxValvole = getDbMgr().cercaConfigValueCarattere(
					Constants.DATA_MAX_INST_VALVOLE);
			/*
			try
			{
				log.debug("dataMaxValvole: "+dataMaxValvole);
				log.debug("dataControllo: "+dataControllo);
				log.debug("GenericUtil.isNotNullOrEmpty(impianto.getFlgTipoImpianto()): "+GenericUtil.isNotNullOrEmpty(impianto.getFlgTipoImpianto()));
				log.debug("impianto.getFlgTipoImpianto().equalsIgnoreCase(Constants.COD_TIPO_IMPIANTO_CENTRALIZZATO): "+impianto.getFlgTipoImpianto().equalsIgnoreCase(Constants.COD_TIPO_IMPIANTO_CENTRALIZZATO));
				log.debug("DateUtil.checkDateOrder(dataMaxValvole, dataControllo, false): "+DateUtil.checkDateOrder(dataMaxValvole, dataControllo, false));
				log.debug("compX != null: "+compX != null);
				log.debug("GenericUtil.isNotNullOrEmpty(compX.getL52FlgValvoleTermo()): "+GenericUtil.isNotNullOrEmpty(compX.getL52FlgValvoleTermo()));
				log.debug("compX.getL52FlgValvoleTermo().equalsIgnoreCase(Constants.FLAG_ASSENTE): "+compX.getL52FlgValvoleTermo().equalsIgnoreCase(Constants.FLAG_ASSENTE));
				log.debug("!isDeroga: "+!isDeroga);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			*/
			
			if (GenericUtil.isNotNullOrEmpty(impianto.getFlgTipoImpianto()) && 
					impianto.getFlgTipoImpianto().equalsIgnoreCase(Constants.COD_TIPO_IMPIANTO_CENTRALIZZATO) &&
					DateUtil.checkDateOrder(dataMaxValvole, ConvertUtil.convertToString(dataControllo), false) &&
					!ConvertUtil.convertToBoolean(impianto.getFlgContabilizzazione()) &&
					!isDeroga)
			{
				log.debug("RETURN TRUE");
				return true;
			}
			else
			{
				log.debug("RETURN FALSE");
				return false;
			}
		}
		catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		
	}
	
	
}

