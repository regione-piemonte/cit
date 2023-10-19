/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.manager.business;

//import it.csi.sigit.common.business.dao.sigitweb.dto.SigitRRespImpDto;
//import it.csi.sigit.common.business.dao.sigitweb.dto.SigitTApparecchiaturaDto;
//import it.csi.sigit.common.business.dao.sigitweb.dto.SigitTImpiantoDto;
//import it.csi.sigit.common.business.dao.sigitweb.dto.SigitTImportDto;
//import it.csi.sigit.common.business.dao.sigitweb.dto.SigitTRappControlloDto;
//import it.csi.sigit.common.business.dao.sigitweb.dto.SigitTUnitaImmobiliareDto;
//import it.csi.sigit.common.business.dao.util.CommonUserInfo;
//import it.csi.sigit.common.manager.ManagerException;
//import it.csi.sigit.common.manager.db.ConfigKeyEnum;
//import it.csi.sigit.common.manager.db.DbManagerException;
//import it.csi.sigit.common.manager.info.AltriEdificiInfo;
//import it.csi.sigit.common.manager.info.ApparecchiatureInfo;
//import it.csi.sigit.common.manager.info.IdentificazioneInfo;
//import it.csi.sigit.common.manager.info.ResponsabiliInfo;
//import it.csi.sigit.common.manager.info.SubentroInfo;
//import it.csi.sigit.common.manager.messaggi.Message;
//import it.csi.sigit.common.manager.validazione.CommonValidationMgr;
//import it.csi.sigit.common.manager.validazione.ValidationManagerException;
//import it.csi.sigit.common.util.ConvertUtil;
//import it.csi.sigit.common.util.GenericUtil;
//import it.csi.sigit.sigitbatch.batch.importmassivoimpianti.ImportMassivoImpiantiConf;
//import it.csi.sigit.sigitbatch.batch.importmassivoimpianti.Mapper;
//import it.csi.sigit.sigitbatch.business.manager.messaggi.ImportMassivoImpiantiMsgCodeEnum;
//import it.csi.sigit.sigitbatch.business.manager.validator.BatchValidatorMgr;
//import it.csi.sigit.sigitbatch.business.manager.validator.BatchValidatorMgrException;
//import it.csi.sigit.sigitweb.xml.allegatoF.CorpoDocument.Corpo;
//import it.csi.sigit.sigitweb.xml.ximport.ApparecchiaturaDocument.Apparecchiatura;
//import it.csi.sigit.sigitweb.xml.ximport.ResponsabileDocument.Responsabile;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDto;
import it.csi.sigit.sigitbatchn.business.util.Constants;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


/**
 * Helper per lo strato business per il batch Import Massivo Impianti e Allegati
 * 
 * @author 71845 - Marco Giacometto
 */
public class ImportMassivoAllegatiBusinessMgr { //extends AllegatiBusinessManager {
	/**
	 * Nome della classe
	 */
	final static String CLASS_NAME = ImportMassivoAllegatiBusinessMgr.class.getSimpleName();
	
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE+ ".business");

	/**
	 * Manager della validazione
	 */
//	private CommonValidationMgr validationMgr = null;
//
//	private BatchValidatorMgr batchValidatorMgr = null;
//
//	/**
//	 * Mappatore di classi
//	 */
//	private Mapper mapper = null;
//
//	/**
//	 * Legge la configurazione per il batch Import massivo impianti
//	 * 
//	 * @return Configurazione per il batch Import massivo impianti
//	 * @throws BusinessMgrException Errore durante la lettura della
//	 *             configurazione
//	 */
//	public ImportMassivoAllegatiConf readImportMassivoImpiantiConf() throws BusinessMgrException {
//		final String METHOD_NAME = "readImportMassivoImpiantiConf";
//		ImportMassivoAllegatiConf conf = null;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		conf = new ImportMassivoAllegatiConf();
//		readBatchConf(conf);
//		// Configurazione Mail
//		conf.setIndirizzoMailMittente(getConfigValue(ConfigKeyEnum.IMPORT_MASSIVO_IMPIANTI_MAIL_IND_MITT).getValoreConfigChar());
//		conf.setIndirizzoMailDestinatario(getConfigValue(ConfigKeyEnum.IMPORT_MASSIVO_IMPIANTI_MAIL_IND_DEST).getValoreConfigChar());
//		conf.setOggettoMail(getConfigValue(ConfigKeyEnum.IMPORT_MASSIVO_IMPIANTI_MAIL_OGGETTO).getValoreConfigChar());
//		conf.setTestoMailOk(getConfigValue(ConfigKeyEnum.IMPORT_MASSIVO_IMPIANTI_MAIL_OK).getValoreConfigChar());
//		conf.setTestoMailOkInviati(getConfigValue(ConfigKeyEnum.IMPORT_MASSIVO_IMPIANTI_MAIL_OK_INVIATI).getValoreConfigChar());
//		conf.setTestoMailKo(getConfigValue(ConfigKeyEnum.IMPORT_MASSIVO_IMPIANTI_MAIL_KO).getValoreConfigChar());
//
//		conf.setOggettoMailImportati(getConfigValue(ConfigKeyEnum.IMPORT_MASSIVO_IMPIANTI_MAIL_OGGETTO_IMPORTATI).getValoreConfigChar());
//		conf.setTestoMailOkImportati(getConfigValue(ConfigKeyEnum.IMPORT_MASSIVO_IMPIANTI_MAIL_OK_IMPORTATI).getValoreConfigChar());
//
//		loggerHelper.debug("Stampo conf.getOggettoMailImportati(): "+conf.getOggettoMailImportati());
//		loggerHelper.debug("Stampo conf.getTestoMailOkImportati: "+conf.getTestoMailOkImportati());
//		
//		loggerHelper.debug(CLASS_NAME, METHOD_NAME, conf.toString());
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//		return conf;
//	}
//
//	/**
//	 * Verifica se si sta effettuando una modifica di un impianto
//	 * 
//	 * @param codiceImpianto Codice impianto
//	 * @return True è una modifica, false altrimenti
//	 */
//	public boolean isModificaImpianto(Integer codiceImpianto) {
//		SigitTImpiantoDto dto = null;
//		boolean modifica;
//
//		modifica = false;
//		try {
//			dto = dbMgr.cercaImpiantoByCodiceImpianto(codiceImpianto.toString());
//			modifica = dto != null;
//		}
//		catch(DbManagerException e) {
//			e.printStackTrace();
//		}
//		return modifica;
//	}
//
//	/**
//	 * Verifica se un impianto è già assegnato ad un manutentore
//	 * 
//	 * @param codiceImpianto Codice dell'impianto da verificare
//	 * @return True l'impianto è già assegnato, false altrimenti
//	 */
//	public boolean esisteRelazioneImpiantoManutentore(BigInteger codiceImpianto) {
//		BigDecimal idManutentore = null;
//		boolean esiste;
//
//		try {
//			idManutentore = dbMgr.cercaIdManutentoreByCodiceImpianto(codiceImpianto.toString());
//			
//			esiste = idManutentore != null;
//		}
//		catch(DbManagerException e) {
//			esiste = false;
//		}
//		return esiste;
//	}
//
//	/**
//	 * Verifica se un impianto è associato ad un impianto
//	 * 
//	 * @param responsabile Responsabile da verificare
//	 * @param idImpianto Codice impianto
//	 * @return True il responsabile è associato all'impianto, false altrimenti
//	 */
//	public Integer responsabileAssociatoAdImpianti(Responsabile responsabile, Integer idImpianto) {
//		SigitRRespImpDto dto = null;
//		Integer idResponsabile = null;
//
//		try {
//			dto = dbMgr.cercaResponsabileImpianto(responsabile.getCodiceFiscaleRes(), responsabile.getDenominazioneRes(), idImpianto);
//			idResponsabile = (dto == null ? null : dto.getIdResponsabile());
//		}
//		catch(DbManagerException e) {
//		}
//		return idResponsabile;
//	}
//
//	/**
//	 * Verifica se sono presenti altri edifici
//	 * 
//	 * @param codiceImpianto Codice dell'impianto
//	 * @return True se sono presenti altri edifici, false altrimenti
//	 */
//	public boolean presentiAltriEdifici(Integer codiceImpianto) {
//		List<SigitTUnitaImmobiliareDto> listaDto = null;
//		boolean presenti;
//
//		presenti = false;
//		try {
//			listaDto = dbMgr.cercaAltriEdificiByCodiceImpianto(codiceImpianto.intValue());
//			presenti = (listaDto != null) && (listaDto.size() > 0);
//		}
//		catch(DbManagerException e) {
//		}
//		return presenti;
//	}
//
//	/**
//	 * Cerca l'Id L2 di un indirizzo
//	 * 
//	 * @param indirizzo Indirizzo da cercare
//	 * @param codiceIstatComune Codice ISTAT del Comune della via
//	 * @return L'Id L2 dell'indirizzo, null se non trovato
//	 */
//	/*
//	public Integer cercaIdL2(String indirizzo, String codiceIstatComune) {
//		final String METHOD_NAME = "cercaIdL2";
//		Integer idL2 = null;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		try {
//			loggerHelper.debug(CLASS_NAME, METHOD_NAME, "Ricerca dell'indirizzo " + indirizzo + " per il Comune " + codiceIstatComune);
//			idL2 = serviziMgr.topeGetIdL2ByNome(indirizzo, codiceIstatComune);
//		}
//		catch(ServiceException e) {
//		}
//		loggerHelper.debug(CLASS_NAME, METHOD_NAME, "Id L2 trovato: " + idL2);
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//		return idL2;
//	}
//	*/
//	
//	/**
//	 * Recupera gli import da elaborare
//	 * 
//	 * @return Lista di import da elaborare
//	 * @throws Exception Errore durante il recupero dei dati
//	 */
//	public List<SigitTImportDto> getImportDaElaborare() throws Exception {
//		List<SigitTImportDto> dtoList = null;
//
//		log.debug("[ImportMassivoAllegatiBusinessMgr::getImportDaElaborare] BEGIN");
//		
//		dtoList = dbMgr.cercaImportImpiantiMassivi();
//		
//		log.debug("[ImportMassivoAllegatiBusinessMgr::getImportDaElaborare] END");
//		return dtoList;
//	}
//
//	/**
//	 * Effettua il subentro di un manutentore in un impianto
//	 * 
//	 * @param codiceImpianto Codice impianto
//	 * @param siglaRea Sigla REA del manutentore
//	 * @param numeroRea Numero REA del manutentore
//	 * @return Id dell'impianto a cui si è subentrato
//	 * @throws BusinessMgrException Errore durante il subentro
//	 */
//	public Integer effettuaSubentro(BigInteger codiceImpianto, String siglaRea, String numeroRea) throws BusinessMgrException {
//		final String METHOD_NAME = "effettuaSubentro";
//		SubentroInfo subentroInfo = null;
//		Integer idImpianto = null;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		try {
//			subentroInfo = mapper.mapToSubentroInfo(codiceImpianto, siglaRea, numeroRea);
//			dbMgr.subentraImpianto(subentroInfo);
//			idImpianto = subentroInfo.getIdImpianto();
//		}
//		catch(DbManagerException e) {
//			loggerHelper.error(CLASS_NAME, METHOD_NAME, "Errore durante il salvataggio del subentro", e);
//			throw new BusinessMgrException(e);
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//		return idImpianto;
//	}
//
//	/**
//	 * Inserisce l'identificazione dell'impianto
//	 * 
//	 * @param userInfo Informazioni sull'utente che effettua l'inserimento
//	 * @param identificazioneInfo Informazioni sull'identificazione
//	 *            dell'impianto
//	 * @return Id dell'impianto
//	 * @throws BusinessMgrException Errore durante l'inserimento
//	 *             dell'identificazione dell'impianto
//	 */
//	public Integer inserisciIdentificazioneImpianto(CommonUserInfo userInfo, IdentificazioneInfo identificazioneInfo) throws BusinessMgrException {
//		final String METHOD_NAME = "inserisciIdentificazioneImpianto";
//		Integer idImpianto = null;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		try {
//			validationMgr.verificaInserimentoImpiantoIdentificazione(identificazioneInfo);
//			idImpianto = dbMgr.inserisciIdentificazioneImpianto(userInfo, identificazioneInfo);
//		}
//		catch(ValidationManagerException e) {
//			loggerHelper.error(CLASS_NAME, METHOD_NAME, "Errore durante la validazione dell'identificazione dell'impianto", e);
//			throw new BusinessMgrException(e);
//		}
//		catch(DbManagerException e) {
//			loggerHelper.error(CLASS_NAME, METHOD_NAME, "Errore durante il salvataggio dell'identificazione dell'impianto", e);
//			throw new BusinessMgrException(e);
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//		return idImpianto;
//	}
//
//	/**
//	 * Modifica l'identificazione dell'impianto
//	 * 
//	 * @param userInfo Informazioni sull'utente che effettua l'inserimento
//	 * @param identificazioneInfo Informazioni sull'identificazione
//	 *            dell'impianto
//	 * @return Id dell'impianto
//	 * @throws BusinessMgrException Errore durante la modifica
//	 *             dell'identificazione dell'impianto
//	 */
//	public void modificaIdentificazioneImpianto(CommonUserInfo userInfo, IdentificazioneInfo identificazioneInfo) throws BusinessMgrException {
//		final String METHOD_NAME = "modificaIdentificazioneImpianto";
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		try {
//			//validationMgr.verificaInserimentoImpiantoIdentificazione(identificazioneInfo);
//			dbMgr.modificaIdentificazioneImpianto(userInfo, identificazioneInfo);
//		}
//		/*
//		catch(ValidationManagerException e) {
//			loggerHelper.error(CLASS_NAME, METHOD_NAME, "Errore durante la validazione dell'identificazione dell'impianto", e);
//			throw new BusinessMgrException(e);
//		}
//		*/
//		catch(DbManagerException e) {
//			loggerHelper.error(CLASS_NAME, METHOD_NAME, "Errore durante il salvataggio dell'identificazione dell'impianto", e);
//			throw new BusinessMgrException(e);
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//	}
//
//	/**
//	 * Modifica l'identificazione dell'impianto
//	 * 
//	 * @param idImpianto id dell'impianto
//	 * @param idManutentore id del manutentore
//	 * @return se il manutentore è manutentore attivo dell'impianto passato
//	 * @throws BusinessMgrException Errore durante la modifica
//	 *             dell'identificazione dell'impianto
//	 */
//	public boolean isImpManutAttivo(Integer idImpianto, Integer idManutentore) throws BusinessMgrException {
//		final String METHOD_NAME = "modificaIdentificazioneImpianto";
//		boolean isImpManutAttivo = false;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		try {
//			//validationMgr.verificaInserimentoImpiantoIdentificazione(identificazioneInfo);
//			isImpManutAttivo = getDbMgr().isImpManutAttivo(idImpianto, idManutentore);
//		}
//		/*
//		catch(ValidationManagerException e) {
//			loggerHelper.error(CLASS_NAME, METHOD_NAME, "Errore durante la validazione dell'identificazione dell'impianto", e);
//			throw new BusinessMgrException(e);
//		}
//		*/
//		catch(DbManagerException e) {
//			loggerHelper.error(CLASS_NAME, METHOD_NAME, "Errore durante il reperimento dei dati", e);
//			throw new BusinessMgrException(e);
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//		return isImpManutAttivo;
//	}
//	/**
//	 * Inserisce un responsabile di impianto
//	 * 
//	 * @param info Informazioni sul responsabile
//	 * @param idImpianto Id dell'impianto a cui associare il responsabile
//	 * @return Id del responsabile inserito
//	 * @throws BusinessMgrException Errore durante l'inserimento del
//	 *             responsabile
//	 */
//	/*
//	public void verificaResponsabileImpianto(Responsabile responsabile, Integer idImpianto) throws BusinessMgrException {
//		final String METHOD_NAME = "verificaResponsabileImpianto";
//		//Integer idResponsabile = null;
//		//SigitRRespImpDto responsabileOld = null;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		try {
//			
//			ResponsabiliInfo responsabileInfo = mapper.mapToResponsabiliInfo(responsabile);
//			
//			GenericUtil.stampaVO(responsabileInfo, true);
//			
//			validationMgr.verificaInserimentoResponsabileImpianto(responsabileInfo, true);
//			
//			getBatchValidatorMgr().verificaResponsabileImpianto(responsabile, idImpianto);
//			
//		}
//		catch(ValidationManagerException e) {
//			loggerHelper.error(CLASS_NAME, METHOD_NAME, "Errore durante la validazione del responsabile dell'impianto", e);
//			throw new BusinessMgrException(e);
//		}
//		catch(ManagerException e) {
//			loggerHelper.error(CLASS_NAME, METHOD_NAME, "Errore durante la validazione del responsabile dell'impianto", e);
//			throw new BusinessMgrException(e);
//		}
//
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//		//return idResponsabile;
//	}
//	*/
//	
//	/**
//	 * Modifica il responsabile associato ad un impianto
//	 * 
//	 * @param info Informazioni sul responsabile
//	 * @param idImpianto Id dell'impianto a cui è associato il responsabile
//	 * @throws BusinessMgrException Errore durante la modifica del responsabile
//	 */
//	/*
//	public void modificaResponsabileImpianto(ResponsabiliInfo info, Integer idImpianto, String dataInstallazioneImpianto) throws BusinessMgrException {
//		final String METHOD_NAME = "modificaResponsabileImpianto";
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		try {
//			validationMgr.verificaModificaResponsabileImpianto(info, dataInstallazioneImpianto, ConvertUtil.convertToString(idImpianto));
//			dbMgr.modificaResponsabileImpianto(info);
//			
//			dbMgr.modificaLegameImpiantoResponsabile(info, idImpianto);
//		}
//		catch(ManagerException e) {
//			throw new BusinessMgrException(e);
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//	}
//	*/
//	/**
//	 * Inserisce un'apparecchiatura
//	 * 
//	 * @param apparecchiaturaInfo Informazioni sull'apparecchiatura
//	 * @param identificazioneInfo Informazioni sull'identificazione
//	 *            dell'impianto
//	 * @return Id dell'apparecchiatura inserita
//	 * @throws BusinessMgrException Errore durante l'inserimento dell'impianto
//	 */
//	/*
//	public Integer inserisciApparecchiatura(ApparecchiatureInfo apparecchiaturaInfo, IdentificazioneInfo identificazioneInfo)
//			throws BusinessMgrException {
//		final String METHOD_NAME = "inserisciApparecchiatura";
//		Integer id = null;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		try {
//			validationMgr.verificaApparecchiature(apparecchiaturaInfo, identificazioneInfo);
//			if(StringUtils.isEmpty(apparecchiaturaInfo.getDataInstallazione())) {
//				validationMgr.calcolaDataInstallazioneApparecchiatura(apparecchiaturaInfo, identificazioneInfo);
//			}
//			id = dbMgr.inserisciApparecchiatura(identificazioneInfo.getIdImpianto(), apparecchiaturaInfo);
//		}
//		catch(ManagerException e) {
//			throw new BusinessMgrException(e);
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//		return id;
//	}
//	*/
//
//	/**
//	 * Inserisce un'apparecchiatura
//	 * 
//	 * @param apparecchiaturaInfo Informazioni sull'apparecchiatura
//	 * @param identificazioneInfo Informazioni sull'identificazione
//	 *            dell'impianto
//	 * @return Id dell'apparecchiatura inserita
//	 * @throws BusinessMgrException Errore durante l'inserimento dell'impianto
//	 */
//	public void verificaApparecchiatura(ApparecchiatureInfo apparecchiaturaInfo, IdentificazioneInfo identificazioneInfo, 
//			List<Apparecchiatura> listaApparecchiature)	throws BusinessMgrException {
//		final String METHOD_NAME = "verificaApparecchiatura";
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		SigitTApparecchiaturaDto apparecchiaturaOld = null;
//		//Integer idApparecchiatura = null;
//		try {
//			
//			// devo verificare abbinata_a
//			if (apparecchiaturaInfo.getIdAbbinato() != null)
//			{
//				SigitTApparecchiaturaDto apparecchiaturaAbbinataA = getBatchValidatorMgr().verificaAbbinataA(identificazioneInfo.getIdImpianto(), apparecchiaturaInfo, listaApparecchiature);
//				
//				if (apparecchiaturaAbbinataA != null)
//				{
//					// Vuol dire che l'abbinataA è già presente sul DB
//					apparecchiaturaInfo.setIdAbbinato(ConvertUtil.convertToString(apparecchiaturaAbbinataA.getIdApparecc()));
//				}
//			}
//
//			if(StringUtils.isEmpty(apparecchiaturaInfo.getDataInstallazione())) {
//				validationMgr.calcolaDataInstallazioneApparecchiatura(apparecchiaturaInfo, identificazioneInfo);
//			}
//
//			validationMgr.verificaApparecchiature(apparecchiaturaInfo, identificazioneInfo);
//
//		}
//		catch(ManagerException e) {
//			throw new BusinessMgrException(e);
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//		//return idApparecchiatura;
//	}
//
//
//	/**
//	 * Modifica un'apparecchiatura
//	 * 
//	 * @param apparecchiaturaInfo Informazioni sull'apparecchiatura
//	 * @param identificazioneInfo Informazioni sull'identificazione
//	 *            dell'impianto
//	 * @throws BusinessMgrException Errore durante la modifica dell'impianto
//	 */
//	/*
//	public Integer modificaApparecchiatura(ApparecchiatureInfo apparecchiaturaInfo, IdentificazioneInfo identificazioneInfo)
//			throws BusinessMgrException {
//		final String METHOD_NAME = "modificaApparecchiatura";
//		Integer id = null;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		try {
//			id = dbMgr.cercaIdApparecchiatura(identificazioneInfo.getIdImpianto(), apparecchiaturaInfo);
//			if(id != null) {
//				loggerHelper.debug(CLASS_NAME, METHOD_NAME, "Apparecchiatura già presente");
//				validationMgr.verificaModificaApparecchiature(apparecchiaturaInfo);
//				dbMgr.modificaApparecchiatura(identificazioneInfo.getIdImpianto(), id, apparecchiaturaInfo);
//			}
//			else {
//				loggerHelper.debug(CLASS_NAME, METHOD_NAME, "Apparecchiatura non presente presente: verrà inserita");
//				id = inserisciApparecchiatura(apparecchiaturaInfo, identificazioneInfo);
//			}
//		}
//		catch(ManagerException e) {
//			throw new BusinessMgrException(e);
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//		return id;
//	}
//	*/
//	
//	/**
//	 * Elimina tutti gli altri edifici non principali associati ad un impianto
//	 * 
//	 * @param identificazioneInfo Informazioni sull'identificazione
//	 *            dell'impianto
//	 * @throws BusinessMgrException Errore durante l'eleiminazione degli altri
//	 *             edifici
//	 */
//	public void eliminaAltriEdifici(IdentificazioneInfo identificazioneInfo) throws BusinessMgrException {
//		final String METHOD_NAME = "eliminaAltriEdifici";
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		try {
//			dbMgr.eliminaAltriEdifici(identificazioneInfo.getIdImpianto(), false);
//		}
//		catch(DbManagerException e) {
//			throw new BusinessMgrException(e);
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//	}
//
//	/**
//	 * Inserisce un altro edificio associato ad un impianto
//	 * 
//	 * @param altriEdificiInfo Informazioni sull'altro edificio
//	 * @param identificazioneInfoInformazioni sull'identificazione dell'impianto
//	 * @throws BusinessMgrException Errore durante l'inserimento dell'altro
//	 *             edificio
//	 */
//	public void inserisciAltroEdificio(AltriEdificiInfo altriEdificiInfo, IdentificazioneInfo identificazioneInfo) throws BusinessMgrException {
//		final String METHOD_NAME = "inserisciAltroEdificio";
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		inserisciAltroEdificio(altriEdificiInfo, identificazioneInfo, false);
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//	}
//
//	/**
//	 * Inserisce un altro edificio associato ad un impianto
//	 * 
//	 * @param altriEdificiInfo Informazioni sull'altro edificio
//	 * @param identificazioneInfoInformazioni sull'identificazione dell'impianto
//	 * @param principale Flag per indicare se da impostare come indirizzo
//	 *            principale
//	 * @throws BusinessMgrException Errore durante l'inserimento dell'altro
//	 *             edificio
//	 */
//	public void inserisciAltroEdificio(AltriEdificiInfo altriEdificiInfo, IdentificazioneInfo identificazioneInfo, boolean principale)
//			throws BusinessMgrException {
//		final String METHOD_NAME = "inserisciAltroEdificio";
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		try {
//			dbMgr.inserisciAltroEdificio(identificazioneInfo.getIdImpianto(), altriEdificiInfo);
//		}
//		catch(DbManagerException e) {
//			throw new BusinessMgrException(e);
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//	}
//
//	/**
//	 * Inserisce un allegato
//	 * 
//	 * @param allegatoInfo Allegato da inserire
//	 * @param idImpianto Id dell'impianto a cui l'allegato è associato
//	 * @return Id dell'allegato inserito
//	 * @throws BusinessMgrException Errore durante l'inserimento dell'allegato
//	 */
//	/*
//	public Integer inserisciAllegato(AllegatoInfo allegatoInfo, String idImpianto) throws BusinessMgrException {
//		final String METHOD_NAME = "inserisciAllegato";
//		Integer idRapportoControllo = null;
//		ArrayList<Integer> list = null;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		if(allegatoInfo.getId() != null) {
//			try {
//				validationMgr.verificaDatiAllegato(allegatoInfo, idImpianto);
//				// Inserisco il rapporto di controllo
//				idRapportoControllo = dbMgr.inserisciRapportoControllo(allegatoInfo, idImpianto);
//				list = dbMgr.getIdApparecchiatureByImpianto(idImpianto);
//				// non si verificherà mai, ma il controllo lo metto lo stesso
//
//				// Inserisco i rapporti di controllo (vuoti)
//				if(list != null && !list.isEmpty()) {
//					for(Integer idApparecchiatura : list) {
//						dbMgr.inserisciRapportoDettaglio(idApparecchiatura, idRapportoControllo);
//					}
//				}
//			}
//			catch(ValidationManagerException e) {
//				throw new BusinessMgrException(e);
//			}
//			catch(DbManagerException e) {
//				throw new BusinessMgrException(e);
//			}
//		}
//		else {
//			// getdbMgr().modificaDatiRapportoControllo(dto, idImpianto);
//			idRapportoControllo = allegatoInfo.getId();
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//		return idRapportoControllo;
//	}
//	*/
//	
//	/**
//	 * Inserisce un rapporto di controllo "vuoto"
//	 * 
//	 * @param corpo Corpo dell'allegato da cui recuperare le informazioni da
//	 *            salvare
//	 * @param idRapportoControllo Id del rapporto di controllo
//	 * @return Id del rapporto di controllo
//	 * @throws DbManagerException Errore durante il salvataggio
//	 */
//	public Integer inserisciRapportoDettaglio(Corpo corpo, Integer idRapportoControllo) throws BusinessMgrException {
//		Integer id = null;
//
//		try {
//			id = dbMgr.inserisciRapportoDettaglio(corpo, idRapportoControllo);
//		}
//		catch(DbManagerException e) {
//			throw new BusinessMgrException(e);
//		}
//		return id;
//	}
//
//	/**
//	 * Inserisce un rapporto di controllo
//	 * 
//	 * @param allegatoF Allegato F da salvare
//	 * @param idImpianto Id dell'impianto
//	 * @param idManutentore Id del manutentore
//	 * @param coppieProgressivoId Coppie progressivo-Id apparecchiature
//	 * @return Id del rapporto di controllo
//	 * @throws BusinessMgrException Errore durante il recupero dei dati
//	 */
//	/*
//	public Integer salvaAllegato(AllegatoF allegatoF, Integer idImpianto, Integer idManutentore, Hashtable<BigInteger, Integer> coppieProgressivoId)
//			throws BusinessMgrException {
//		final String METHOD_NAME = "salvaAllegato";
//		Integer idRapportoControllo = null;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//
//		try {
//			idRapportoControllo = dbMgr.inserisciRapportoControllo(allegatoF, idImpianto, idManutentore);
//			dbMgr.inserisciRapportoDettaglio(allegatoF, idRapportoControllo, coppieProgressivoId);
//		}
//		catch(DbManagerException e) {
//			throw new BusinessMgrException(e);
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//		return idRapportoControllo;
//	}
//	*/
//	/**
//	 * Inserisce un rapporto di controllo
//	 * 
//	 * @param allegatoG Allegato G da salvare
//	 * @param idImpianto Id dell'impianto
//	 * @param idManutentore Id del manutentore
//	 * @param idApparecchiatura Id dell'apparecchiatura associata
//	 * @return Id del rapporto di controllo
//	 * @throws BusinessMgrException Errore durante il recupero dei dati
//	 */
//	/*
//	public Integer salvaAllegato(AllegatoG allegatoG, Integer idImpianto, Integer idManutentore, Integer idApparecchiatura)
//			throws BusinessMgrException {
//		final String METHOD_NAME = "salvaAllegato";
//		Integer idRapportoControllo = null;
//
//		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
//		try {
//			idRapportoControllo = dbMgr.inserisciRapportoControllo(allegatoG, idImpianto, idManutentore);
//			dbMgr.inserisciRapportoDettaglio(allegatoG, idRapportoControllo, idApparecchiatura);
//		}
//		catch(DbManagerException e) {
//			throw new BusinessMgrException(e);
//		}
//		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
//		return idRapportoControllo;
//	}
//*/
//	/**
//	 * Restituisce il manager della validazione
//	 * 
//	 * @return Manager della validazione
//	 */
//	public CommonValidationMgr getValidationMgr() {
//		return validationMgr;
//	}
//
//	/**
//	 * Imposta il manager della validazione
//	 * 
//	 * @param validationMgr Manager della validazione
//	 */
//	public void setValidationMgr(CommonValidationMgr validationMgr) {
//		this.validationMgr = validationMgr;
//	}
//
//	/**
//	 * Restituisce il manager della validazione batch
//	 * 
//	 * @return Manager della validazione batch
//	 */
//	public BatchValidatorMgr getBatchValidatorMgr() {
//		return batchValidatorMgr;
//	}
//
//	/**
//	 * Imposta il manager della validazione batch
//	 * 
//	 * @param validationMgr Manager della validazione batch
//	 */
//	public void setBatchValidatorMgr(BatchValidatorMgr batchValidatorMgr) {
//		this.batchValidatorMgr = batchValidatorMgr;
//	}
//
//	/**
//	 * Restituisce il mappatore di classi
//	 * 
//	 * @return Mappatore di classi
//	 */
//	public Mapper getMapper() {
//		return mapper;
//	}
//
//	/**
//	 * Imposta il mappatore di classi
//	 * 
//	 * @param mapper Mappatore di classi
//	 */
//	public void setMapper(Mapper mapper) {
//		this.mapper = mapper;
//	}
}
