/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch.importmassivoallegati;

//import it.csi.sigit.common.business.dao.sigitweb.dao.SigitTImpiantoDao;
//import it.csi.sigit.common.business.dao.sigitweb.dto.SigitDPotenzaImpDto;
//import it.csi.sigit.common.business.dao.sigitweb.dto.SigitTAnomalieDto;
//import it.csi.sigit.common.business.dao.sigitweb.dto.SigitTImpiantoDto;
//import it.csi.sigit.common.business.dao.sigitweb.dto.SigitTImportDto;
//import it.csi.sigit.common.business.dao.sigitweb.dto.SigitTManutentoreDto;
//import it.csi.sigit.common.business.dao.sigitweb.dto.SigitTRappControlloDto;
//import it.csi.sigit.common.business.dao.util.CommonUserInfo;
//import it.csi.sigit.common.manager.ManagerException;
//import it.csi.sigit.common.manager.db.CommonDbMgr;
//import it.csi.sigit.common.manager.db.DbManagerException;
//import it.csi.sigit.common.manager.info.AllegatoInfo;
//import it.csi.sigit.common.manager.info.AltriEdificiInfo;
//import it.csi.sigit.common.manager.info.ApparecchiatureInfo;
//import it.csi.sigit.common.manager.info.IdentificazioneInfo;
//import it.csi.sigit.common.manager.info.ResponsabiliInfo;
//import it.csi.sigit.common.manager.messaggi.CommonMsgCodeEnum;
//import it.csi.sigit.common.manager.messaggi.Message;
//import it.csi.sigit.common.manager.servizi.CommonServiziMgr;
//import it.csi.sigit.common.manager.CommonSigitMgr;
//import it.csi.sigit.common.manager.servizi.ServiceException;
//import it.csi.sigit.common.util.ConvertUtil;
//import it.csi.sigit.common.util.CostantiApplicative;
//import it.csi.sigit.common.util.GenericUtil;
//import it.csi.sigit.common.util.MapDto;
//import it.csi.sigit.common.xml.validator.XmlValidator;
//import it.csi.sigit.common.xml.validator.XmlValidatorException;
import it.csi.sigit.sigitbatchn.batch.AbstractDataImport;
import it.csi.sigit.sigitbatchn.batch.BatchConf;
import it.csi.sigit.sigitbatchn.batch.BatchException;
import it.csi.sigit.sigitbatchn.batch.reader.DataReader;
import it.csi.sigit.sigitbatchn.business.manager.business.ImportMassivoAllegatiBusinessMgr;
import it.csi.sigit.sigitbatchn.business.manager.util.ManagerException;
//import it.csi.sigit.sigitbatch.business.manager.business.BusinessMgrException;
//import it.csi.sigit.sigitbatch.business.manager.business.ImportMassivoImpiantiBusinessMgr;
//import it.csi.sigit.sigitbatch.business.manager.messaggi.ImportMassivoImpiantiMsgCodeEnum;
//import it.csi.sigit.sigitbatchn.business.manager.validator.BatchValidatorMgr;
//import it.csi.sigit.sigitbatchn.business.manager.validator.BatchValidatorMgrException;
//import it.csi.sigit.sigitbatch.business.utility.ExceptionMessageBuilder;

//import it.csi.sitad.tpnm.entity.Via;



import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.XmlException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Import dati per import massivo impianti e allegati effettuato tramite XmlBean
 * 
 * @author 71845 - Marco Giacometto
 */
public class ImportMassivoAllegatiXmlBeanDataImport extends AbstractDataImport {
	/**
	 * Nome della classe
	 */
	private final static String CLASS_NAME = ImportMassivoAllegatiXmlBeanDataImport.class.getSimpleName();
	/**
	 * Percorso dello schema di ImportMassivoImpianti
	 */
	private final static String IMPORT_MASSIVO_IMPIANTI_SCHEMA_PATH = "META-INF/importImpianti.xsd";
	/**
	 * Fallimento
	 */
	private final static String FAILURE = "0";
	/**
	 * Successo
	 */
	private final static String SUCCESS = "1";
	/**
	 * Manager business
	 */
	private ImportMassivoAllegatiBusinessMgr businessMgr = null;
	/**
	 * Lista degli errori riscontrati
	 */
	private List<Errors> errorsList = null;
	/**
	 * Lista degi rapporto controllo importati
	 */
	private List<Importati> importatiList = null;
	/**
	 * Lista degi rapporto controllo inviati
	 */
	private List<Importati> inviatiList = null;
	/**
	 * Gestore delle validazioni dei batch
	 */
	//private BatchValidatorMgr batchValidationMgr = null;
	/**
	 * Gestore dei servizi common
	 */
	//private CommonSigitMgr commonSigitMgr = null;
	/**
	 * Gestore dei servizi
	 */
	//private CommonServiziMgr serviziMgr = null;
	/**
	 * Gestore del DB
	 */
	//private CommonDbMgr commonDbMgr = null;
	/**
	 * Informazioni sull'utente che effettua le operazioni
	 */
	//private CommonUserInfo userInfo = null;
	/**
	 * Mappatore di classi
	 */
	private Mapper mapper = null;
	/**
	 * Errori riscontrati durante l'import
	 */
	private Errors errors = null;
	/**
	 * Rapporto controllo importati (senza invio)
	 */
	private Importati importati = null;

	/**
	 * Rapporto controllo inviati
	 */
	private Importati inviati = null;

	/**
	 * Costruttore di un allegato F
	 */
	//private AllegatoFBuilder allegatoFBuilder = null;
	/**
	 * Costruttore di un allegato G
	 */
	//private AllegatoGBuilder allegatoGBuilder = null;
	/**
	 * Lista dei DTO degli import
	 */
	//private List<SigitTImportDto> dtoList = null;

	/**
	 * {@inheritDoc}
	 */
	public void importData(BatchConf conf, List<DataReader> dataReaderList) throws BatchException {
		
	}
	/*
	public void importData(BatchConf conf, List<DataReader> dataReaderList) throws BatchException {
		final String METHOD_NAME = "importData";
		String xmlContent = null;
		ElencoImpiantiDocument document = null;
		ElencoImpianti elencoImpianti = null;
		Message message = null;
		Manutentore manutentore = null;
		IdentificazioneImpianto identificazione = null;
		Integer currentCodiceImpianto = null;
		IdentificazioneInfo identificazioneInfo = null;
		List<Impianto> listaImpianti = null;
		Hashtable<BigInteger, Integer> coppieProgressivoId = null;
		DataReader xmlReader = null;
		SigitTImpiantoDto impiantoDB = null;
		SigitTImportDto dto = null;
		SigitTManutentoreDto manutentoreDB = null;
		int readerCounter;
		int totReaders;
		int index;
		boolean inserimentoImpianto;

		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
		totReaders = dataReaderList != null ? dataReaderList.size() : 0;
		readerCounter = 1;
		errorsList = new ArrayList<Errors>();
		importatiList = new ArrayList<Importati>();
		inviatiList = new ArrayList<Importati>();

		loggerHelper.debug(CLASS_NAME, METHOD_NAME, "dataReaderList " + dataReaderList);
		
		for(index = 0; index < dataReaderList.size(); index++) {
			// Le due liste dovrebbero avere gli stessi elementi nello stesso
			// ordine
			xmlReader = dataReaderList.get(index);
			dto = dtoList.get(index);
			dto.setDataInizioImport(new Date(System.currentTimeMillis()));
			dto.setFlgEsito(SUCCESS);
			try {
				loggerHelper.debug(CLASS_NAME, METHOD_NAME, "Validazione dell'XML " + getProgress(readerCounter, totReaders));
				XmlValidator.validate(xmlReader.getReader(),
						new InputStreamReader(GenericUtil.getFileInClassPath(IMPORT_MASSIVO_IMPIANTI_SCHEMA_PATH)));
				loggerHelper.debug(CLASS_NAME, METHOD_NAME, "Lettura dell'XML " + getProgress(readerCounter, totReaders));
				xmlContent = readFile(xmlReader.getReader());
				loggerHelper.debug(CLASS_NAME, METHOD_NAME, "Parsing dell'XML " + getProgress(readerCounter, totReaders));
				document = ElencoImpiantiDocument.Factory.parse(xmlContent);
				elencoImpianti = document.getElencoImpianti();
				listaImpianti = elencoImpianti.getImpiantoList();
				loggerHelper.info(CLASS_NAME, METHOD_NAME, listaImpianti.size() + " impianti da importare");
				for(Impianto impianto : listaImpianti) {

					identificazione = impianto.getIdentificazioneImpianto();

					SigitTAnomalieDto anomalia = getDbMgr().cercaAnomalia(ConvertUtil.convertToInteger(identificazione.getCodiceImpianto()));

					// Se non è presente l'anomalia posso processare l'impianto
					if (anomalia == null)
					{
						manutentore = impianto.getManutentore();

						currentCodiceImpianto = identificazione.getCodiceImpianto().intValue();
						loggerHelper.info(CLASS_NAME, METHOD_NAME, "Impianto " + currentCodiceImpianto);
						errors = null;
						importati = null;
						inviati = null;
						Rapporto rapporto = null;
						boolean isRapportoNew = false;
						try {
							loggerHelper.info(CLASS_NAME, METHOD_NAME, "Step 3.1 - validaManutentore");
							
							manutentoreDB = batchValidationMgr.validaManutentore(manutentore);
							
							loggerHelper.info(CLASS_NAME, METHOD_NAME, "Step 3.2 - validaPresenzaAllegati");
							
							batchValidationMgr.validaPresenzaAllegati(impianto);
							
							loggerHelper.info(CLASS_NAME, METHOD_NAME, "Step 3.3 - cercaImpianto");
							
							
							// Recupero l'impianto
							impiantoDB = businessMgr.cercaImpianto(currentCodiceImpianto);
							
							
							inserimentoImpianto = (impiantoDB == null);
							//inserimentoImpianto = !businessMgr.isModificaImpianto(currentCodiceImpianto);
							
							List<Apparecchiatura> listaApparecchiature = getElencoApparecchiature(impianto);
							List<Responsabile> listaResponsabili = getElencoResponsabili(impianto);
							List<AltriEdifici> listaAltriEdifici = getElencoAltriEdifici(impianto);
							List<AllegatoF> listaAllegatiF = getElencoAllegatiF(impianto);
							List<AllegatoG> listaAllegatiG = getElencoAllegatiG(impianto);
							
							identificazioneInfo = mapper.mapToIdentificazioneInfo(identificazione, manutentoreDB);
							
							SigitDPotenzaImpDto potenza = null;
							
							loggerHelper.info(CLASS_NAME, METHOD_NAME, "cercaPotenzaImpiantoById");
							
							// Cerco la categoria di potenza dell'impianto
							potenza = getDbMgr().cercaPotenzaImpiantoById(ConvertUtil.convertToInteger(identificazione.getPotenzaImpianto()));
							
							// Sono in modifica
							if (!inserimentoImpianto)
							{
								// Setto l'id impianto
								identificazioneInfo.setIdImpianto(impiantoDB.getIdImpianto());
								
								loggerHelper.info(CLASS_NAME, METHOD_NAME, "ATTENZIONE: setto come data assegnazione la data presa dal DB, perchè non è possibile modificare la data assegnazione!");
								//Setto la data assegnazione perchè non è possibile modificare la data assegnazione
								identificazioneInfo.setDataAssegnazione(ConvertUtil.convertToString(impiantoDB.getDataAssegnazione()));
								
								loggerHelper.info(CLASS_NAME, METHOD_NAME, "recuperaDataRapportoRiferimento");
								
								// Recupero la data rapporto (dell'XML) più piccola e la prendo come riferimento
								String dataRapportoRiferimento = getBatchValidatorMgr().recuperaDataRapportoRiferimento(listaAllegatiF, listaAllegatiG);
								
								loggerHelper.info(CLASS_NAME, METHOD_NAME, "Step 3.3.1 - verificaCoerenzaPotenzaImpianto");
								
								// Verifica la coerenza delle potenze delle apparecchiature dell'XML
								getBatchValidatorMgr().verificaCoerenzaPotenzaImpianto(
										identificazioneInfo.getIdImpianto(), 
										potenza,
										listaApparecchiature,
										dataRapportoRiferimento);
								
								loggerHelper.info(CLASS_NAME, METHOD_NAME, "Step 3.3.2 - verifica cambio fascia potenza impianto");
								// L'impianto ha cambiato potenza!
								if (identificazione.getPotenzaImpianto().intValue() != impiantoDB.getFkPotenza().intValue())
								{
									
									// se ci sono dei rapporto di controllo in stato BOZZA non è possibile modificare la potenza
									List<SigitTRappControlloDto> listRappControllo = getDbMgr().cercaRapportiControlloByImpiantoStato(ConvertUtil.convertToString(identificazioneInfo.getIdImpianto()), CostantiApplicative.STATO_RAPPORTO_BOZZA);
									if (listRappControllo != null && !listRappControllo.isEmpty())
									{
										Message m = msgMgr.getMessage(ImportMassivoImpiantiMsgCodeEnum.S104);
										throw new BatchValidatorMgrException("Non si può modificare la potenza", m);
									}
								}
								
								loggerHelper.info(CLASS_NAME, METHOD_NAME, "Step 3.3.3 - verificaCoerenzaDataImpiantoConDB");
								
								// Verifico che le ipotetiche apparecchiature presenti sul DB e non sull'XML siano coerenti con le date dell'impianto
								getBatchValidatorMgr().verificaCoerenzaDataImpiantoConDB(
										identificazioneInfo, listaApparecchiature, listaResponsabili, dataRapportoRiferimento);

								loggerHelper.info(CLASS_NAME, METHOD_NAME, "Step 3.3.4 - ciclo per verifica sul responsabile (controlli formali XML)");
								
								getBatchValidatorMgr().verificaResponsabili(identificazioneInfo.getIdImpianto(), getElencoResponsabili(impianto));

								loggerHelper.info(CLASS_NAME, METHOD_NAME, "Step 3.3.5 - verificaApparecchiature (controlli formali XML)");
								// Verificare le apparecchiature
								getBatchValidatorMgr().verificaApparecchiature(identificazioneInfo, listaApparecchiature);

							}
							
							String siglaProvinciaImpianto = getServiziMgr().getComuneByIstat(identificazione.getIstatComune()).getProvComune().getSiglaProvincia();

							
							if (listaAllegatiF != null)
							{
								for (int i = 0; i < listaAllegatiF.size(); i++) 
								{
									AllegatoF allegatoF = listaAllegatiF.get(i);

									// Devo recuperare se esiste un rapporto di controllo con la data del rapporto che si vuole inserire,
									// se esiste si deve settare l'id così si andrà in update

									AllegatoInfo allegatoInfo = new AllegatoInfo(); 
									allegatoInfo.setIdSiglaBollinoVerdeAllegato(allegatoF.getSiglaBollino());
									allegatoInfo.setBollinoVerde(ConvertUtil.convertToString(allegatoF.getNumeroBollino()));
									allegatoInfo.setDataControllo(ConvertUtil.convertToDate(allegatoF.getDataRapporto()));
									allegatoInfo.setDataControlloStringa(ConvertUtil.convertToString(allegatoF.getDataRapporto()));

									// devo vedere che non sia un allegato già presente sul DB (controllo la data rapporto)

									loggerHelper.info(CLASS_NAME, METHOD_NAME, "Step 3.3.6 - verificaIsAllegatoNuovo");
									if (impiantoDB != null)
									{
										//isRapportoNew = getBatchValidatorMgr().verificaIsAllegatoNuovo(allegatoInfo, impiantoDB.getIdImpianto());
										
										if(commonDbMgr.cercaRapportoControlloBySiglaNumeroBollino(allegatoInfo.getIdSiglaBollinoVerdeAllegato(), allegatoInfo.getBollinoVerde()) != null) 
										{
											isRapportoNew = false;
										}
										else
										{
											isRapportoNew = true;
										}
									}
									else
									{
										isRapportoNew = true;
									}
									
									
									
									Integer idRapportoControllo = getCommonSigitMgr().inviaAllegatoXML(userInfo, identificazione, manutentore, listaResponsabili, listaApparecchiature, listaAltriEdifici, allegatoF, null, 
											siglaProvinciaImpianto, null, potenza.getModello(), isRapportoNew);
									
									
									if (isRapportoNew)
									{
										// Se sono in questo punto, vuol dire che l'inserimento è andato a buon fine
										rapporto = new Rapporto();
										rapporto.setIdRapportoControllo(idRapportoControllo);
										rapporto.setDataRapportoControllo(allegatoInfo.getDataControllo());
										addRapportoControlloInviati(rapporto);
										//idRapportoControlloList.addIdRapportoControllo(idRapportoControllo);
										
									}
									else
									{
										// Se sono in questo punto, vuol dire che l'inserimento è andato a buon fine
										rapporto = new Rapporto();
										rapporto.setIdRapportoControllo(idRapportoControllo);
										rapporto.setDataRapportoControllo(allegatoInfo.getDataControllo());
										addRapportoControlloImportati(rapporto);
									}
									
									
								}
							}

							if (listaAllegatiG != null)
							{
								for (int i = 0; i < listaAllegatiG.size(); i++) 
								{
									AllegatoG allegatoG = listaAllegatiG.get(i);

									// Devo recuperare se esiste un rapporto di controllo con la data del rapporto che si vuole inserire,
									// se esiste si deve settare l'id così si andrà in update

									AllegatoInfo allegatoInfo = new AllegatoInfo(); 
									allegatoInfo.setIdSiglaBollinoVerdeAllegato(allegatoG.getSiglaBollino());
									allegatoInfo.setBollinoVerde(ConvertUtil.convertToString(allegatoG.getNumeroBollino()));
									allegatoInfo.setDataControllo(ConvertUtil.convertToDate(allegatoG.getDataRapporto()));
									allegatoInfo.setDataControlloStringa(ConvertUtil.convertToString(allegatoG.getDataRapporto()));

									// devo vedere che non sia un allegato già presente sul DB (controllo la data rapporto)

									
									// TOGLIERE ESCOMMENATRE L'ALTRO
									//boolean isAllegatoPresente = true;
									if (impiantoDB != null)
									{
										// isRapportoNew = getBatchValidatorMgr().verificaIsAllegatoNuovo(allegatoInfo, identificazioneInfo.getIdImpianto());
										if(commonDbMgr.cercaRapportoControlloBySiglaNumeroBollino(allegatoInfo.getIdSiglaBollinoVerdeAllegato(), allegatoInfo.getBollinoVerde()) != null) 
										{
											isRapportoNew = false;
										}
										else
										{
											isRapportoNew = true;
										}
									}
									else
									{
										isRapportoNew = true;
									}
									
									Integer idRapportoControllo = getCommonSigitMgr().inviaAllegatoXML(userInfo, identificazione, manutentore, listaResponsabili, listaApparecchiature, listaAltriEdifici, null, allegatoG, 
											siglaProvinciaImpianto, null, potenza.getModello(), isRapportoNew); // verificare se non bisogna settare l'ente
										
									if (isRapportoNew)
									{
										// Se sono in questo punto, vuol dire che l'inserimento è andato a buon fine
										
										//addIdRapportoControllo(idRapportoControllo);
										rapporto = new Rapporto();
										rapporto.setIdRapportoControllo(idRapportoControllo);
										rapporto.setDataRapportoControllo(allegatoInfo.getDataControllo());
										addRapportoControlloInviati(rapporto);
										
									}
									else
									{
										// Se sono in questo punto, vuol dire che l'inserimento è andato a buon fine
										rapporto = new Rapporto();
										rapporto.setIdRapportoControllo(idRapportoControllo);
										rapporto.setDataRapportoControllo(allegatoInfo.getDataControllo());
										addRapportoControlloImportati(rapporto);
									}

								}
							}


						}
						catch(BatchValidatorMgrException e) {
							loggerHelper.error(CLASS_NAME, METHOD_NAME, e.getMsg().getText(), e);
							addErrorMessage(currentCodiceImpianto, e);
						}
						catch(Exception e) {
							loggerHelper.error(CLASS_NAME, METHOD_NAME, "Errore non previsto", e);
							addErrorMessage(currentCodiceImpianto, e);
							
						}
						
						if(errors != null) {
							dto.setFlgEsito(FAILURE);
							//manutentoreDB = commonDbMgr.cercaManutentore(dto.getFkManutentore());
							
							errors.setIdManutentore(manutentoreDB.getIdManutentore());
							errors.setMailManutentore(manutentoreDB.getEmail());
							errorsList.add(errors);
						}
						
						//System.out.println("Stampo gli importati: "+importati);
						
						if (importati != null)
						{
							//manutentoreDB = commonDbMgr.cercaManutentore(dto.getFkManutentore());
							
							importati.setIdManutentore(manutentoreDB.getIdManutentore());
							importati.setMailManutentore(manutentoreDB.getEmail());
							importati.setCodiceImpianto(impianto.getIdentificazioneImpianto().getCodiceImpianto().intValue());
							importatiList.add(importati);
						}
						
						if (inviati != null)
						{
							//manutentoreDB = commonDbMgr.cercaManutentore(dto.getFkManutentore());
							
							inviati.setIdManutentore(manutentoreDB.getIdManutentore());
							inviati.setMailManutentore(manutentoreDB.getEmail());
							inviati.setCodiceImpianto(impianto.getIdentificazioneImpianto().getCodiceImpianto().intValue());
							inviatiList.add(inviati);
						}
					}
				}
			}
			catch(XmlException e) {
				dto.setFlgEsito(FAILURE);
				message = msgMgr.getMessage(ImportMassivoImpiantiMsgCodeEnum.S001);
				loggerHelper.error(CLASS_NAME, METHOD_NAME, message.getText() + " " + getProgress(readerCounter, totReaders), e);
				throw new BatchException(message.getText() + " " + getProgress(readerCounter, totReaders), e);
			}
			catch(XmlValidatorException e) {
				dto.setFlgEsito(FAILURE);
				message = msgMgr.getMessage(ImportMassivoImpiantiMsgCodeEnum.S002);
				loggerHelper.error(CLASS_NAME, METHOD_NAME, message.getText() + " " + getProgress(readerCounter, totReaders), e);
				throw new BatchException(message.getText() + " " + getProgress(readerCounter, totReaders), e);
			}
			catch(IOException e) {
				dto.setFlgEsito(FAILURE);
				loggerHelper.error(CLASS_NAME, METHOD_NAME, "Errore durante la lettura dell'XML " + getProgress(readerCounter, totReaders), e);
				throw new BatchException("Errore durante la lettura dell'XML " + getProgress(readerCounter, totReaders), e);
			}
			catch(Throwable e) {
				dto.setFlgEsito(FAILURE);
				loggerHelper.error(CLASS_NAME, METHOD_NAME, "Errore durante l'elaborazione dell'XML " + getProgress(readerCounter, totReaders), e);
				throw new BatchException("Errore durante l'elaborazione dell'XML " + getProgress(readerCounter, totReaders), e);
			}
			finally {
				loggerHelper.info(CLASS_NAME, METHOD_NAME, "Step 4 - salvaImportImpiantoMassivo");
				dto.setDataFineImport(new Date(System.currentTimeMillis()));
				try {
					commonDbMgr.salvaImportImpiantoMassivo(dto);
				}
				catch(DbException e) {
					loggerHelper.error(CLASS_NAME, METHOD_NAME,
							"Errore durante l'aggiornamento del DTO dell'XML " + getProgress(readerCounter, totReaders), e);
					throw new BatchException("Errore durante l'aggiornamento del DTO dell'XML " + getProgress(readerCounter, totReaders), e);
				}
			}
			readerCounter++;
		}
		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
	}
	*/
	
	/**
	 * Restituisce il messaggio associato ad una generica eccezione
	 * 
	 * @param e Eccezione per cui restituire il messaggio
	 * @return Messaggio associato all'eccezione
	 */
	private String getGenericExceptionMessage(Exception e) {
		// return(e == null ? null : e.getClass().getSimpleName() + ": " + e.getMessage());
		return(e == null ? null : e.getMessage());
	}

	/**
	 * Inserisce gli allegati associati ad un impianto
	 * 
	 * @param coppieProgressivoId Lista di coppie progressivo-Id delle
	 *            apparecchiature inserite
	 * @param identificazioneInfo Identificazione dell'impianto
	 * @param listaAllegatiF Lista degli allegati F
	 * @param listaAllegatiG Lista degli allegati G
	 */
	/*
	private void inserimentoAllegati(Hashtable<BigInteger, Integer> coppieProgressivoId, IdentificazioneInfo identificazioneInfo, Impianto impianto,
			List<AllegatoF> listaAllegatiF, List<AllegatoG> listaAllegatiG) {
		final String METHOD_NAME = "inserimentoAllegati";
		//AllegatoCommonInfo allegatoCommonInfo = null;
		AllegatoFDocument allegatoFDocument = null;
		AllegatoGDocument allegatoGDocument = null;
		Integer idImpianto = null;
		Integer idManutentore = null;
		Integer idRapportoControllo = null;

		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
		idImpianto = identificazioneInfo.getIdImpianto();
		idManutentore = new Integer(identificazioneInfo.getIdManutentore());
		
		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
	}
	 */
	/**
	 * Inserisce gli altri edifici associati ad un impianto
	 * 
	 * @param identificazione Identificazione dell'impianto
	 * @param listaAltriEdifici Lista di altri edifici da inserire
	 */
//	private void inserimentoAltriEdifici(IdentificazioneInfo identificazioneInfo, List<AltriEdifici> listaAltriEdifici) {
//		final String METHOD_NAME = "inserimentoAltriEdifici";
//		AltriEdificiInfo altriEdificiInfo = null;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		try {
//			loggerHelper.info(CLASS_NAME, METHOD_NAME,
//					"Eliminazione di tutti gli altri edifici non principali dell'impianto " + identificazioneInfo.getCodiceImpianto());
//			businessMgr.eliminaAltriEdifici(identificazioneInfo);
//		}
//		catch(BusinessMgrException e) {
//			addErrorMessage(identificazioneInfo.getCodiceImpianto(), e);
//		}
//		loggerHelper.info(CLASS_NAME, METHOD_NAME, "Inserimento di " + listaAltriEdifici.size() + " altri edifici");
//		for(AltriEdifici altriEdifici : listaAltriEdifici) {
//			altriEdificiInfo = mapper.mapToAltriEdificiInfo(altriEdifici, identificazioneInfo);
//			try {
//				loggerHelper.info(CLASS_NAME, METHOD_NAME, "Inserimento dell'altro edificio " + altriEdificiInfo);
//				businessMgr.inserisciAltroEdificio(altriEdificiInfo, identificazioneInfo);
//			}
//			catch(BusinessMgrException e) {
//				addErrorMessage(identificazioneInfo.getCodiceImpianto(), e);
//			}
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//	}


	/**
	 * Inserisce le apparecchiature associate ad un impianto
	 * 
	 * @param inserimentoImpianto Flag per indicare se si sta procedendo ad un
	 *            inserimento impianto
	 * @param identificazioneInfo Informazioni sull'identificazione
	 *            dell'impianto
	 * @param listaApparecchiature Lista delle apparecchiature da inserire
	 */
//	private void verificaApparecchiature(IdentificazioneInfo identificazioneInfo,
//			List<Apparecchiatura> listaApparecchiature) 
//			throws BatchException {
//		final String METHOD_NAME = "verificaApparecchiature";
//		ApparecchiatureInfo apparecchiaturaInfo = null;
//	//	Hashtable<BigInteger, Integer> coppieProgressivoId = null;
//		//Integer idApparecchiatura = null;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		if(listaApparecchiature != null) {
//			loggerHelper.info(CLASS_NAME, METHOD_NAME, listaApparecchiature.size() + " apparecchiature da importare");
//			//coppieProgressivoId = new Hashtable<BigInteger, Integer>();
//			
//			for(Apparecchiatura apparecchiatura : listaApparecchiature) {
//				apparecchiaturaInfo = mapper.mapToApparecchiaturaInfo(apparecchiatura);
//				try {
//					
//					businessMgr.verificaApparecchiatura(apparecchiaturaInfo, identificazioneInfo, listaApparecchiature);
//					
//					//loggerHelper.debug(CLASS_NAME, METHOD_NAME, "SETTO LE COPPIE: "+apparecchiaturaInfo.getNumeroApparecchiatura()+": "+idApparecchiatura+"\n");
//					
//					//coppieProgressivoId.put(apparecchiaturaInfo.getNumeroApparecchiatura(), idApparecchiatura);
//				}
//				catch(BusinessMgrException e) {
//					loggerHelper.error(e.getMessage());
//					e.printStackTrace();
//					//addErrorMessage(identificazioneInfo.getCodiceImpianto(), e);
//					throw new BatchException("Errore durante la verifica dell'apparecchiatura", e);
//				}
//			}
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
////		return coppieProgressivoId;
//	}


	/**
	 * Aggiunge un messaggio d'errore alla lista dei messaggi d'errore di un
	 * impianto
	 * 
	 * @param codiceImpianto Codice impianto a cui è associato il messaggio
	 *            d'errore
	 * @param exception Eccezione sollevata
	 * @return Lista aggiornata dei messaggi d'errore associati all'impianto
	 */
	private void addErrorMessage(Integer codiceImpianto, ManagerException exception) {
		if(errors == null) {
			errors = new Errors();
			errors.setCodiceImpianto(codiceImpianto);
		}
		//errors.addErrorMessage(retrieveErrorMessage(exception));
	}

	/**
	 * Aggiunge un messaggio d'errore alla lista dei messaggi d'errore di un
	 * impianto
	 * 
	 * @param codiceImpianto Codice impianto a cui è associato il messaggio
	 *            d'errore
	 * @param exception Eccezione sollevata
	 * @return Lista aggiornata dei messaggi d'errore associati all'impianto
	 */
	private void addErrorMessage(Integer codiceImpianto, Exception exception) {
		if(errors == null) {
			errors = new Errors();
			errors.setCodiceImpianto(codiceImpianto);
		}
		errors.addErrorMessage(getGenericExceptionMessage(exception));
	}

	/**
	 * Aggiunge un importato correttamente alla lista degli importati correttamente
	 * 
	 * @param idRapportoControllo
	 * @return Lista aggiornata degli importati correttamente
	 */
	private void addRapportoControlloImportati(Rapporto rapportoControllo) {
		if(importati == null) {
			importati = new Importati();
			
		}
		importati.addRapportoControllo(rapportoControllo);
	}
	
	/**
	 * Aggiunge un importato correttamente alla lista degli importati correttamente
	 * 
	 * @param idRapportoControllo
	 * @return Lista aggiornata degli importati correttamente
	 */
	private void addRapportoControlloInviati(Rapporto rapportoControllo) {
		if(inviati == null) {
			inviati = new Importati();
			
		}
		inviati.addRapportoControllo(rapportoControllo);
	}
	/**
	 * Cerca il primo messaggio disponibile nello stack delle eccezioni
	 * 
	 * @param exception Eccezione da cui partire per la ricerca
	 * @return Primo messaggio trovato, null se non trovato
	 */
	/*
	private String retrieveErrorMessage(ManagerException exception) {
		String errorMessage = null;
		ManagerException cause = null;
		ExceptionMessageBuilder builder = null;

		try {
			cause = exception;
			while(cause != null) {
				builder = new ExceptionMessageBuilder(cause);
				errorMessage = builder.getExceptionMessage();
				cause = (ManagerException) cause.getCause();
			}
		}
		catch(Exception ex) {
			// O la causa dell'eccezione non è un'eccezione ManagerException
			// (ClassCastException),
			// o si è arrivati alla fine della catena di eccezioni
			// (NullPointerException)
			// In ogni caso, se errorMessage non è stato impostato vuol dire che
			// non si è trovato il messaggio d'errore
		}
		return errorMessage;
	}
	*/
	
	/**
	 * Restituisce l'elenco degli allegati G
	 * 
	 * @param impianto Impianto da cui recuperare l'elenco
	 * @return Elenco degli allegati G
	 */
//	private List<AllegatoG> getElencoAllegatiG(Impianto impianto) {
//		return impianto.getElencoAllegatoG() != null ? impianto.getElencoAllegatoG().getAllegatoGList() : null;
//	}

	/**
	 * Restituisce l'elenco degli allegati F
	 * 
	 * @param impianto Impianto da cui recuperare l'elenco
	 * @return Elenco degli allegati F
	 */
//	private List<AllegatoF> getElencoAllegatiF(Impianto impianto) {
//		return impianto.getElencoAllegatoF() != null ? impianto.getElencoAllegatoF().getAllegatoFList() : null;
//	}

	/**
	 * Restituisce l'elenco degli altri edifici
	 * 
	 * @param impianto Impianto da cui recuperare l'elenco
	 * @return Elenco degli altri edifici
	 */
//	private List<AltriEdifici> getElencoAltriEdifici(Impianto impianto) {
//		return impianto.getElencoAltriEdifici() != null ? impianto.getElencoAltriEdifici().getAltriEdificiList() : null;
//	}

	/**
	 * Restituisce l'elenco delle apparecchiature
	 * 
	 * @param impianto Impianto da cui recuperare l'elenco
	 * @return Elenco delle apparecchiature
	 */
//	private List<Apparecchiatura> getElencoApparecchiature(Impianto impianto) {
//		return impianto.getElencoApparecchiature() != null ? impianto.getElencoApparecchiature().getApparecchiaturaList() : null;
//	}

	/**
	 * Restituisce l'elenco dei responsabili
	 * 
	 * @param impianto Impianto da cui recuperare l'elenco
	 * @return Elenco dei responsabili
	 */
//	private List<Responsabile> getElencoResponsabili(Impianto impianto) {
//		return impianto.getElencoResponsabili() != null ? impianto.getElencoResponsabili().getResponsabileList() : null;
//	}

	/**
	 * Restituisce il manager business
	 * 
	 * @return Manager business
	 */
	public ImportMassivoAllegatiBusinessMgr getBusinessMgr() {
		return businessMgr;
	}

	/**
	 * Imposta il manager business
	 * 
	 * @param businessMgr Manager business
	 */
	public void setBusinessMgr(ImportMassivoAllegatiBusinessMgr businessMgr) {
		this.businessMgr = businessMgr;
	}

	/**
	 * Imposta la lista degli errori riscontrati
	 * 
	 * @param errorsList Lista degli errori riscontrati
	 */
	public void setErrorsList(List<Errors> errorsList) {
		this.errorsList = errorsList;
	}

	/**
	 * Restituisce la lista degli errori riscontrati
	 * 
	 * @return Lista degli errori riscontrati
	 */
	public List<Errors> getErrorsList() {
		return errorsList;
	}

	
	/**
	 * Imposta la lista dei rapporti importati correttamente
	 * 
	 * @param idRapportoControlloList Lista dei rapporti importati correttamente
	 */
	public void setImportatiList(List<Importati> importatiList) {
		this.importatiList = importatiList;
	}

	/**
	 * Restituisce la lista dei rapporti importati correttamente
	 * 
	 * @return Lista dei rapporti importati correttamente
	 */
	public List<Importati> getImportatiList() {
		return importatiList;
	}

	/**
	 * Imposta la lista dei rapporti inviati correttamente
	 * 
	 * @param idRapportoControlloList Lista dei rapporti inviati correttamente
	 */
	public void setInviatiList(List<Importati> inviatiList) {
		this.inviatiList = inviatiList;
	}

	/**
	 * Restituisce la lista dei rapporti inviati correttamente
	 * 
	 * @return Lista dei rapporti inviati correttamente
	 */
	public List<Importati> getInviatiList() {
		return inviatiList;
	}

	
	/**
	 * Restituisce il gestore delle validazioni dei batch
	 * 
	 * @return Gestore delle validazioni dei batch
	 */
//	public BatchValidatorMgr getBatchValidatorMgr() {
//		return batchValidationMgr;
//	}

	/**
	 * Imposta il gestore delle validazioni dei batch
	 * 
	 * @param batchValidationMgr Gestore delle validazioni dei batch
	 */
//	public void setBatchValidatorMgr(BatchValidatorMgr batchValidationMgr) {
//		this.batchValidationMgr = batchValidationMgr;
//	}

	/**
	 * Restituisce il gestore dei servizi
	 * 
	 * @return Gestore dei servizi common
	 */
//	public CommonServiziMgr getServiziMgr() {
//		return serviziMgr;
//	}

	/**
	 * Imposta il gestore dei servizi
	 * 
	 * @param serviziMgr Gestore dei servizi
	 */
//	public void setServiziMgr(CommonServiziMgr commonServiziMgr) {
//		this.serviziMgr =commonServiziMgr;
//	}

	/**
	 * Restituisce il gestore dei servizi
	 * 
	 * @return Gestore dei servizi common
	 */
//	public CommonSigitMgr getCommonSigitMgr() {
//		return commonSigitMgr;
//	}

	/**
	 * Imposta il gestore dei servizi
	 * 
	 * @param commonSigitMgr Gestore dei servizi common
	 */
//	public void setCommonSigitMgr(CommonSigitMgr commonSigitMgr) {
//		this.commonSigitMgr =commonSigitMgr;
//	}

	/**
	 * Restituisce le informazioni sull'utente che effettua le operazioni
	 * 
	 * @return Informazioni sull'utente che effettua le operazioni
	 */
//	public CommonUserInfo getUserInfo() {
//		return userInfo;
//	}

	/**
	 * Restituisce le informazioni sull'utente che effettua le operazioni
	 * 
	 * @param userInfo Informazioni sull'utente che effettua le operazioni
	 */
//	public void setUserInfo(CommonUserInfo userInfo) {
//		this.userInfo = userInfo;
//	}

	/**
	 * Restituisce il mappatore di classi
	 * 
	 * @return Mappatore di classi
	 */
	public Mapper getMapper() {
		return mapper;
	}

	/**
	 * Imposta il mappatore di classi
	 * 
	 * @param mapper Mappatore di classi
	 */
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	/**
	 * Restituisce il gestore del DB
	 * 
	 * @return Gestore del DB
	 */
//	public CommonDbMgr getDbMgr() {
//		return commonDbMgr;
//	}

	/**
	 * Imposta il gestore del DB
	 * 
	 * @param dbMgr Gestore del DB
	 */
//	public void setDbMgr(CommonDbMgr commonDbMgr) {
//		this.commonDbMgr = commonDbMgr;
//	}

	/**
	 * Restituisce il costruttore di un allegato F
	 * 
	 * @return Costruttore di un allegato F
	 */
//	public AllegatoFBuilder getAllegatoFBuilder() {
//		return allegatoFBuilder;
//	}

	/**
	 * Imposta il costruttore di un allegato F
	 * 
	 * @param allegatoFBuilder Costruttore di un allegato F
	 */
//	public void setAllegatoFBuilder(AllegatoFBuilder allegatoFBuilder) {
//		this.allegatoFBuilder = allegatoFBuilder;
//	}

	/**
	 * Restituisce il costruttore di un allegato G
	 * 
	 * @return Costruttore di un allegato G
	 */
//	public AllegatoGBuilder getAllegatoGBuilder() {
//		return allegatoGBuilder;
//	}

	/**
	 * Imposta il costruttore di un allegato G
	 * 
	 * @param allegatoGBuilder Costruttore di un allegato G
	 */
//	public void setAllegatoGBuilder(AllegatoGBuilder allegatoGBuilder) {
//		this.allegatoGBuilder = allegatoGBuilder;
//	}

	/**
	 * Restituisce la lista dei DTO degli import
	 * 
	 * @return Lista dei DTO degli import
	 */
//	public List<SigitTImportDto> getDtoList() {
//		return dtoList;
//	}

	/**
	 * Imposta la lista dei DTO degli import
	 * 
	 * @param dtoList Lista dei DTO degli import
	 */
//	public void setDtoList(List<SigitTImportDto> dtoList) {
//		this.dtoList = dtoList;
//	}
}
