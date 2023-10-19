package it.csi.sigit.sigitwebn.business.import_massivo;

import java.util.*;

import it.csi.sigit.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.dto.accesso.*;
import it.csi.sigit.sigitwebn.dto.codici_impianto.*;
import it.csi.sigit.sigitwebn.dto.common.*;
import it.csi.sigit.sigitwebn.dto.impianto.*;
import it.csi.sigit.sigitwebn.dto.main.*;
import it.csi.sigit.sigitwebn.dto.bollini.*;
import it.csi.sigit.sigitwebn.dto.allegati.*;
import it.csi.sigit.sigitwebn.dto.subentro.*;
import it.csi.sigit.sigitwebn.dto.delega.*;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.*;
import it.csi.sigit.sigitwebn.dto.ispezioni.*;
import it.csi.sigit.sigitwebn.dto.distributori.*;
import it.csi.sigit.sigitwebn.dto.incarico.*;
import it.csi.sigit.sigitwebn.dto.impresa.*;
import it.csi.sigit.sigitwebn.dto.documentazione.*;
import it.csi.sigit.sigitwebn.dto.libretto.*;
import it.csi.sigit.sigitwebn.dto.ree.*;
import it.csi.sigit.sigitwebn.dto.verifica.*;
import it.csi.sigit.sigitwebn.dto.accertamento.*;
import it.csi.sigit.sigitwebn.dto.azioni.*;
import it.csi.sigit.sigitwebn.dto.sanzioni.*;
import it.csi.sigit.sigitwebn.dto.rappprova.*;
import it.csi.sigit.sigitwebn.dto.back_office.*;
import it.csi.sigit.sigitwebn.dto.userws.*;

import org.apache.log4j.*;
import it.csi.sigit.sigitwebn.util.*;
import it.csi.sigit.sigitwebn.business.*;

/*PROTECTED REGION ID(R2076465583) ENABLED START*/
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;

import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettTipo1Dto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettTipo2Dto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettTipo3Dto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettTipo4Dto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTImportDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPreImportDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVSk4GtDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportFilter;
import it.csi.sigit.sigitext.dto.sigitext.TipoImportAllegatoEnum;

/*PROTECTED REGION END*/

public class CPBECpImportMassivo {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [allegato, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATO_CODE = "appDataallegato";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [ricercaImpianti, scope:USER_SESSION]
	public static final String APPDATA_RICERCAIMPIANTI_CODE = "appDataricercaImpianti";

	// ApplicationData: [paginaChiamanteImp, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEIMP_CODE = "appDatapaginaChiamanteImp";

	// ApplicationData: [reeMenuTree, scope:USER_SESSION]
	public static final String APPDATA_REEMENUTREE_CODE = "appDatareeMenuTree";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpImportMassivo";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo uploadFile definito in un ExecCommand del
	 * ContentPanel cpImportMassivo
	 */
	public ExecResults uploadFile(

			it.csi.sigit.sigitwebn.dto.import_massivo.CpImportMassivoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String UPLOADFILE_OUTCOME_CODE__REE = //NOSONAR  Reason:EIAS
				"REE"; //NOSONAR  Reason:EIAS
		final String UPLOADFILE_OUTCOME_CODE__MANUTENZIONE = //NOSONAR  Reason:EIAS
				"MANUTENZIONE"; //NOSONAR  Reason:EIAS
		final String UPLOADFILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1578430417) ENABLED START*/

			result.setResultCode(UPLOADFILE_OUTCOME_CODE__KO);

			log.debug("inizio import xml");
			File file = theModel.getWidg_fuImpMass();
			if (file == null) {
				throw new ValidationManagerException(new Message("Selezionare un file"));
			} else {

				log.debug("elaborazione file");
				String nomeFile = theModel.getWidg_fuImpMassFileName();

				try {
					if (file == null || !nomeFile.toUpperCase().endsWith(".XML")) {
						throw new ValidationManagerException(new Message(
								nomeFile + " " + Messages.S096.replaceFirst("##value##", Constants.ESTENSIONE_XML)));
					} else if (nomeFile.length() > Constants.MAX_NOME_FILE_LEN) {
						throw new ValidationManagerException(new Message(nomeFile + " " + Messages.S160
								.replaceFirst("##value##", ConvertUtil.convertToString(Constants.MAX_NOME_FILE_LEN))));
					} else {

						FileReader fileReader = new FileReader(file);
						log.debug("fileReader ok");
						String readFile = XmlBeanUtils.readFile(new FileReader(file));

						byte[] theXml = XmlBeanUtils.readString(readFile);

						Integer idPersonaGiuridica = theModel.getAppDatautenteLoggato().getRuolo()
								.getIdPersonaGiuridica();
						String codiceFiscale = theModel.getAppDatautenteLoggato().getCodiceFiscale();

						String codiceImpianto = getSigitMgr().getCodiceImpiantoFromXmlReeManutenzione(nomeFile,
								fileReader, theXml);

						String tipoControllo = getSigitMgr().getTipoImportXmlManutenzioneReeFromXmlFilename(nomeFile);

						Integer idAllegato = getServiziMgr().uploadXMLControllo(
								ConvertUtil.convertToInteger(codiceImpianto), tipoControllo, theXml, codiceFiscale,
								ConvertUtil.convertToString(idPersonaGiuridica));

						DettaglioAllegato dettaglioAllegato = getSigitMgr().gestisciAllegatoById(idAllegato);

						//setto il codice fiscale dell'utente loggato
						dettaglioAllegato
								.setCodFiscaleUtenteLoggato(ReplaceSpecialCharUtils.sanitize(
										theModel.getAppDatautenteLoggato().getCodiceFiscale()));

						//setto da dove sto arrivando
						dettaglioAllegato.setArrivoDa(Constants.ARRIVO_DA_IMPIANTO);

						if (log.isDebugEnabled())
							GenericUtil.stampa(dettaglioAllegato, true, 3);

						theModel.setAppDataallegato(dettaglioAllegato);

						//rimetto in sessione l'oggetto dettaglio allegato, mi serve nel caso in cui le verifiche diano errore, su GestisciRitornoAllegato riesco a sapere su cosa stavo lavorando
						theModel.getSession().put(Constants.SESSIONE_VAR_DETT_ALLEGATO, dettaglioAllegato);

						// Setto la pagina in cui sto andando, mi servirà nel caso ci sia necessità di ricaricare la pagina con un messaggio (es. invia allegato)
						theModel.getSession().put(Constants.SESSIONE_VAR_ALLEGATO_SEZIONE, "SEZIONE_ABCDF");

						IdentificativoImpianto identificativo = getSigitMgr()
								.cercaIdentificativoImpianto(dettaglioAllegato.getCodiceImpianto());

						theModel.setAppDataidentificativoImpianto(identificativo);

						// Questo serve nel caso l'utente prema indietro, va sul risultato allegati, se fa ancora indietro
						// decido che lo faccio andare alla ricerca impianto

						theModel.setAppDatapaginaChiamanteImp(Constants.PAG_RIS_RIC_IMPIANTI);
						RicercaImpianti ricImp = new RicercaImpianti();
						ricImp.setCodiceImpianto(
								ConvertUtil.convertToUDTPositiveInteger(dettaglioAllegato.getCodiceImpianto()));
						theModel.setAppDataricercaImpianti(ricImp);

						// Questo lo devo settare perchè serve sulla pagina di ritorno nel caso di KO
						theModel.setAppDataidImpiantoSelez(dettaglioAllegato.getCodiceImpianto());

						TipoImportAllegatoEnum tipoImport = TipoImportAllegatoEnum.valueOfLabel(tipoControllo);

						switch (tipoImport) {
							case ALLEGATOII :
							case ALLEGATOIIB :
								gestisciVerificaInvioImportTipo1(dettaglioAllegato, theXml,
										theModel.getAppDatautenteLoggato(), result);
								result.setResultCode(UPLOADFILE_OUTCOME_CODE__REE);
								break;
							case ALLEGATOIII :
								gestisciVerificaInvioImportTipo2(dettaglioAllegato, theXml,
										theModel.getAppDatautenteLoggato());
								result.setResultCode(UPLOADFILE_OUTCOME_CODE__REE);
								break;
							case ALLEGATOIV :
								gestisciVerificaInvioImportTipo3(dettaglioAllegato, theXml,
										theModel.getAppDatautenteLoggato());
								result.setResultCode(UPLOADFILE_OUTCOME_CODE__REE);
								break;
							case ALLEGATOV :
								gestisciVerificaInvioImportTipo4(dettaglioAllegato, theXml,
										theModel.getAppDatautenteLoggato());
								result.setResultCode(UPLOADFILE_OUTCOME_CODE__REE);
								break;
							default :
								result.setResultCode(UPLOADFILE_OUTCOME_CODE__MANUTENZIONE);
								result.getGlobalMessages().add("Manutenzione importata correttamente");
						}
					}

				} catch (ServiceException | ManagerException e) {
					log.error("Errore upload xml allegato: " + e.getMessage(), e);
					result.getGlobalErrors().add(e.getMessage());
				}
			}

			result.setModel(theModel);
			return result;

			/*
			 
			  
			log.debug("inizio import xml");
			List<File> fileList = theModel.getWidg_fuImpMass();
			if (fileList == null || fileList.isEmpty()) {
				result.getGlobalErrors().add("Selezionare almeno un file");
			} else {
				SigitTPreImportDto dtoPreImport = getSigitMgr().inserisciPreImport(theModel.getAppDatautenteLoggato());
				log.debug("elaborazione file");
				int elaboratiConSuccesso = 0;
				String erroriFile = "";
				int totalFiles = fileList.size();
				log.debug("Numero file arrivati: " + totalFiles);
				List<String> nomiFile = theModel.getWidg_fuImpMassFileName();
				List<String> contTypes = theModel.getWidg_fuImpMassContentType();
				for (String cType : contTypes) {
					log.debug(cType);
				}
				int i = 0;
				String msg = "";
			
				Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();
			
				for (File file : fileList) {
					String nomeFile = nomiFile.get(i++);
					try {
						if (file == null || !nomeFile.toUpperCase().endsWith(".XML")) {
							erroriFile += nomeFile + " "
									+ Messages.S096.replaceFirst("##value##", Constants.ESTENSIONE_XML) + "<br/>\n";
							continue;
						} else if (nomeFile.length() > Constants.MAX_NOME_FILE_LEN) {
							erroriFile += nomeFile + " " + Messages.S160.replaceFirst("##value##",
									ConvertUtil.convertToString(Constants.MAX_NOME_FILE_LEN)) + "<br/>\n";
							continue;
						}
			
						ImportFilter importData = getValidationMgr().validazioneXmlImport(file, nomeFile);
			
						importData.setIdPreImport(dtoPreImport.getIdPreImport());
			
						getDbMgr().insertImport(importData, ruolo.getIdPgCat());
			
						elaboratiConSuccesso++;
						msg += Messages.I012.replaceFirst("##value##", nomeFile) + "<br/>";
					} catch (ValidationManagerException vme) {
						erroriFile += vme.getMsg().getText() + "<br/>\n";
						log.error("Errore con il file " + nomeFile, vme);
					} catch (DbManagerException dbe) {
						erroriFile += file.getName() + " : " + dbe.getMsg().getText() + "<br/>\n";
						log.error("Errore con il file " + nomeFile, dbe);
					}
				}
				if (elaboratiConSuccesso > 0) {
					msg += "Sono stati elaborati con successo " + elaboratiConSuccesso + " file.";
					msg += "\n<br/> Per gli impianti schedulati nella notte, le notifiche mail verranno inviate al manutentore indicato nell'XML";
					result.getGlobalMessages().add(msg);
				} else
					result.getGlobalErrors().add("Nessun file e' stato elaborato con successo.");
				if (org.apache.commons.lang.StringUtils.isNotEmpty(erroriFile))
					result.getGlobalErrors().add(erroriFile);
				//salvataggio pre_import
				dtoPreImport.setNFile(totalFiles);
				dtoPreImport.setMsg(erroriFile);
				getDbMgr().aggiornaPreImport(dtoPreImport);
			}
			result.setResultCode(UPLOADFILE_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			 
			 */

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::uploadFile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpImportMassivo
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.import_massivo.CpImportMassivoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1741842340) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoImportMassivoAllegato(utente)) {
				result.setResultCode(ISRUOLOABILITATO_OUTCOME_CODE__OK);
			} else {
				GenericUtil.redirectToNotAllowedPage();
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isRuoloAbilitato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R736970783) ENABLED START*/
	private ValidationMgr validationMgr;
	private DbMgr dbMgr;
	private SigitMgr sigitMgr;
	private ServiziMgr serviziMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	public void gestisciVerificaInvioImportTipo1(DettaglioAllegato dettaglioAllegato, byte[] theXml,
			UtenteLoggato utenteLoggato, ExecResults result) throws ManagerException {
		log.debug("[SigitMgr::gestisciVerificaInvioImportTipo1] BEGIN");

		try {

			// Per ricondurre l'import alla situazione del web, recupero tutti i dati, faccio i controlli del web e salvo 

			// Riutilizzo il metodo usato da REE WEB, quindi mi crea la struttura vuota
			//BigDecimal idAllegato = getSigitMgr().salvaAllegato(dettaglioAllegato, utenteLoggato);

			// Devo ciclare per ogni Allegato ed inserirlo
			//dettaglioAllegato.setIdAllegato(ConvertUtil.convertToString(idAllegato));

			Tipo1 tipo1 = getSigitMgr().getAllegatoTipo1(dettaglioAllegato);
			StringBuffer msgError = new StringBuffer();
			String idAllegato = dettaglioAllegato.getIdAllegato();
			try {
				// Verifico i dati generali

				getValidationMgr().validazioneFormaleReeTipo1(tipo1, dettaglioAllegato, result);

				// Se le verifiche hanno dato esito positivo aggiorno il campo

				SigitTAllegatoDto allegatoDto = getDbMgr()
						.cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(idAllegato));

				allegatoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
				allegatoDto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(utenteLoggato.getCodiceFiscale()));
				allegatoDto.setAbcdfControlloweb(DateUtil.getSqlDataCorrente());

				// Valutare se fare un update puntuale per questi campi
				getDbMgr().aggiornaAllegato(allegatoDto);

			} catch (ValidationManagerException e) {
				// C'e' qualche dato non esatto quindi non devo aggiornare il campo AbcdfControlloweb, ma proseguo con i controlli
				log.debug("ValidationManagerException - validazioneFormaleReeTipo1: " + e.getMessageCompleto());
				msgError.append(e.getMessageCompleto());
			}

			List<String> idCompProgressiviList = dettaglioAllegato.getIdApparecchiatureFunz();

			for (String idCompProgressivo : idCompProgressiviList) {

				// Verifico i dati dettaglio

				Tipo1Dett tipo1Dett = getSigitMgr().caricaDatiReeTipo1Dett(idAllegato,
						ConvertUtil.convertToInteger(idCompProgressivo));

				try {

					List<SigitTDettTipo1Dto> tDettTipo1List = getDbMgr().getDettTipo1(
							dettaglioAllegato.getCodiceImpianto(), ConvertUtil.convertToInteger(idCompProgressivo),
							idAllegato);

					tipo1Dett = MapDto.mapToTipo1Dett(tipo1Dett, tDettTipo1List);

					// verifico che abbia compilato la scheda
					String idTipoAllegato = dettaglioAllegato.getIdTipoAllegato();
					getValidationMgr().validazioneFormaleReeTipo1Dett(tipo1Dett, idTipoAllegato, result);

					for (SigitTDettTipo1Dto sigitTDettTipo1Dto : tDettTipo1List) {

						// Ciclo per tutti i moduli 

						try {
							Tipo1DettModulo tipo1DettModulo = getSigitMgr().caricaDatiReeTipo1DettModulo(
									dettaglioAllegato.getCodiceImpianto(), idAllegato,
									ConvertUtil.convertToInteger(idCompProgressivo),
									sigitTDettTipo1Dto.getENModuloTermico());

							List<SigitVSk4GtDto> compGtListAllegato = null;

							if (idTipoAllegato.equals(Constants.ALLEGATO_TIPO_1B)) {
								compGtListAllegato = getDbMgr()
										.getCompGtByIdAllegato(ConvertUtil.convertToInteger(idAllegato));
							}

							getValidationMgr().validazioneFormaleReeTipo1DettModulo(tipo1DettModulo,
									tipo1Dett.getIdCombustibile(), idTipoAllegato, compGtListAllegato);

							// Faccio il salvataggio dei dati aggiornati
							// forse basterebbe fare un aggiornamento di 
							// dettTipo2.setEControlloweb(DateUtil.getSqlDataCorrente());
							// dettTipo2.setDataUltMod(DateUtil.getSqlDataCorrente());
							// dettTipo2.setUtenteUltMod(cfUtenteMod);
							getDbMgr().salvaReeTipo1Dett(tipo1Dett, tipo1DettModulo, null,
									utenteLoggato.getCodiceFiscale());

						} catch (ValidationManagerException e) {
							// C'e' qualche dato non esatto su Tipo1DettModulo, quindi non devo aggiornare il campo EControlloweb, ma proseguo con i controlli
							log.debug("ValidationManagerException - validazioneFormaleReeTipo1DettModulo: "
									+ e.getMessageCompleto());
							msgError.append(e.getMessageCompleto());

						}

					}
				} catch (ValidationManagerException e) {
					// C'e' qualche dato non esatto su Tipo1Dett
					// non eseguo la verifica dei singoli moduli
					log.debug("ValidationManagerException - validazioneFormaleReeTipo1Dett: " + e.getMessageCompleto());
					msgError.append(e.getMessageCompleto());

				}

			}

			//			getDbMgr().aggiornaImport(idImport, msgError.toString(),
			//					ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

		} catch (Exception e) {

			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[SigitMgr::gestisciVerificaInvioImportTipo1] END");
		}

	}

	public void gestisciVerificaInvioImportTipo2(DettaglioAllegato dettaglioAllegato, byte[] theXml,
			UtenteLoggato utenteLoggato) throws ManagerException {
		log.debug("[SigitMgr::gestisciVerificaInvioImportTipo2] BEGIN");

		try {

			// Per ricondurre l'import alla situazione del web, recupero tutti i dati, faccio i controlli del web e salvo 

			// Riutilizzo il metodo usato da REE WEB, quindi mi crea la struttura vuota
			//BigDecimal idAllegato = getSigitMgr().salvaAllegato(dettaglioAllegato, utenteLoggato);

			// Devo ciclare per ogni Allegato ed inserirlo
			//dettaglioAllegato.setIdAllegato(ConvertUtil.convertToString(idAllegato));

			Tipo2 tipo2 = getSigitMgr().getAllegatoTipo2(dettaglioAllegato);
			StringBuffer msgError = new StringBuffer();
			try {
				// Verifico i dati generali

				getValidationMgr().validazioneFormaleReeTipo2(tipo2, dettaglioAllegato.getCodiceImpianto(),
						dettaglioAllegato.getDataControllo());

				// Se le verifiche hanno dato esito positivo aggiorno il campo

				SigitTAllegatoDto allegatoDto = getDbMgr()
						.cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

				allegatoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
				allegatoDto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(utenteLoggato.getCodiceFiscale()));
				allegatoDto.setAbcdfControlloweb(DateUtil.getSqlDataCorrente());

				// Valutare se fare un update puntuale per questi campi
				getDbMgr().aggiornaAllegato(allegatoDto);

			} catch (ValidationManagerException e) {
				// C'e' qualche dato non esatto quindi non devo aggiornare il campo AbcdfControlloweb, ma proseguo con i controlli
				log.debug("ValidationManagerException - validazioneFormaleReeTipo2: " + e.getMessageCompleto());
				msgError.append(e.getMessageCompleto());
			}

			List<String> idCompProgressiviList = dettaglioAllegato.getIdApparecchiatureFunz();

			for (String idCompProgressivo : idCompProgressiviList) {

				// Verifico i dati dettaglio

				Tipo2Dett tipo2Dett = getSigitMgr().caricaDatiReeTipo2Dett(dettaglioAllegato.getIdAllegato(),
						ConvertUtil.convertToInteger(idCompProgressivo));

				try {

					List<SigitTDettTipo2Dto> tDettTipo2List = getDbMgr().getDettTipo2(
							dettaglioAllegato.getCodiceImpianto(), ConvertUtil.convertToInteger(idCompProgressivo),
							dettaglioAllegato.getIdAllegato());

					tipo2Dett = MapDto.mapToTipo2Dett(tipo2Dett, tDettTipo2List);

					// verifico che abbia compilato la scheda
					getValidationMgr().validazioneFormaleReeTipo2Dett(tipo2Dett);

					for (SigitTDettTipo2Dto sigitTDettTipo2Dto : tDettTipo2List) {

						// Ciclo per tutti i moduli 

						try {
							Tipo2DettCircuito tipo2DettCircuito = getSigitMgr().caricaDatiReeTipo2DettCircuito(
									dettaglioAllegato.getCodiceImpianto(), dettaglioAllegato.getIdAllegato(),
									ConvertUtil.convertToInteger(idCompProgressivo),
									sigitTDettTipo2Dto.getENCircuito());

							getValidationMgr().validazioneFormaleReeTipo2DettCircuito(tipo2DettCircuito,
									dettaglioAllegato.getDataControllo());

							//							sigitTDettTipo1Dto.setDataUltMod(DateUtil.getSqlDataCorrente());
							//							sigitTDettTipo1Dto.setUtenteUltMod(utenteLoggato.getCodiceFiscale());
							//							sigitTDettTipo1Dto.setEControlloweb(DateUtil.getSqlDataCorrente());

							// Faccio il salvataggio dei dati aggiornati
							// forse basterebbe fare un aggiornamento di 
							// dettTipo2.setEControlloweb(DateUtil.getSqlDataCorrente());
							// dettTipo2.setDataUltMod(DateUtil.getSqlDataCorrente());
							// dettTipo2.setUtenteUltMod(cfUtenteMod);
							getDbMgr().salvaReeTipo2Dett(tipo2Dett, tipo2DettCircuito,
									utenteLoggato.getCodiceFiscale());

						} catch (ValidationManagerException e) {
							// C'e' qualche dato non esatto su Tipo1DettModulo, quindi non devo aggiornare il campo EControlloweb, ma proseguo con i controlli
							log.debug("ValidationManagerException - validazioneFormaleReeTipo2DettCircuito: "
									+ e.getMessageCompleto());
							msgError.append(e.getMessageCompleto());

						}

					}
				} catch (ValidationManagerException e) {
					// C'e' qualche dato non esatto su Tipo1Dett
					// non eseguo la verifica dei singoli moduli
					log.debug("ValidationManagerException - validazioneFormaleReeTipo2Dett: " + e.getMessageCompleto());
					msgError.append(e.getMessageCompleto());

				}

			}

			//			getDbMgr().aggiornaImport(idImport, msgError.toString(),
			//					ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

		} catch (Exception e) {

			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[SigitMgr::gestisciVerificaInvioImportTipo2] END");
		}

	}

	public void gestisciVerificaInvioImportTipo3(DettaglioAllegato dettaglioAllegato, byte[] theXml,
			UtenteLoggato utenteLoggato) throws ManagerException {
		log.debug("[SigitMgr::gestisciVerificaInvioImportTipo3] BEGIN");

		try {

			// Per ricondurre l'import alla situazione del web, recupero tutti i dati, faccio i controlli del web e salvo 

			// Riutilizzo il metodo usato da REE WEB, quindi mi crea la struttura vuota
			//BigDecimal idAllegato = getSigitMgr().salvaAllegato(dettaglioAllegato, utenteLoggato);

			// Devo ciclare per ogni Allegato ed inserirlo
			//dettaglioAllegato.setIdAllegato(ConvertUtil.convertToString(idAllegato));

			Tipo3 tipo3 = getSigitMgr().getAllegatoTipo3(dettaglioAllegato);
			StringBuffer msgError = new StringBuffer();
			try {
				// Verifico i dati generali

				getValidationMgr().validazioneFormaleReeTipo3(tipo3, dettaglioAllegato.getCodiceImpianto(),
						dettaglioAllegato.getDataControllo());

				// Se le verifiche hanno dato esito positivo aggiorno il campo

				SigitTAllegatoDto allegatoDto = getDbMgr()
						.cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

				allegatoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
				allegatoDto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(utenteLoggato.getCodiceFiscale()));
				allegatoDto.setAbcdfControlloweb(DateUtil.getSqlDataCorrente());

				// Valutare se fare un update puntuale per questi campi
				getDbMgr().aggiornaAllegato(allegatoDto);

			} catch (ValidationManagerException e) {
				// C'e' qualche dato non esatto quindi non devo aggiornare il campo AbcdfControlloweb, ma proseguo con i controlli
				log.debug("ValidationManagerException - validazioneFormaleReeTipo3: " + e.getMessageCompleto());
				msgError.append(e.getMessageCompleto());
			}

			List<String> idCompProgressiviList = dettaglioAllegato.getIdApparecchiatureFunz();

			for (String idCompProgressivo : idCompProgressiviList) {

				// Verifico i dati dettaglio

				Tipo3Dett tipo3Dett = getSigitMgr().caricaDatiReeTipo3Dett(dettaglioAllegato.getIdAllegato(),
						ConvertUtil.convertToInteger(idCompProgressivo));

				try {

					List<SigitTDettTipo3Dto> tDettTipo3List = getDbMgr().getDettTipo3(
							dettaglioAllegato.getCodiceImpianto(), ConvertUtil.convertToInteger(idCompProgressivo),
							dettaglioAllegato.getIdAllegato());

					tipo3Dett = MapDto.mapToTipo3Dett(tipo3Dett,
							(tDettTipo3List != null && tDettTipo3List.size() > 0 ? tDettTipo3List.get(0) : null));

					// verifico che abbia compilato la scheda
					getValidationMgr().validazioneFormaleReeTipo3Dett(tipo3Dett);

					// Faccio il salvataggio dei dati aggiornati
					// forse basterebbe fare un aggiornamento di 
					// dettTipo2.setEControlloweb(DateUtil.getSqlDataCorrente());
					// dettTipo2.setDataUltMod(DateUtil.getSqlDataCorrente());
					// dettTipo2.setUtenteUltMod(cfUtenteMod);
					getDbMgr().salvaReeTipo3Dett(tipo3Dett, utenteLoggato.getCodiceFiscale());

				} catch (ValidationManagerException e) {
					// C'e' qualche dato non esatto su Tipo1Dett
					// non eseguo la verifica dei singoli moduli
					log.debug("ValidationManagerException - validazioneFormaleReeTipo3Dett: " + e.getMessageCompleto());
					msgError.append(e.getMessageCompleto());

				}

			}

			//			getDbMgr().aggiornaImport(idImport, msgError.toString(),
			//					ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

		} catch (Exception e) {

			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[SigitMgr::gestisciVerificaInvioImportTipo3] END");
		}

	}

	public void gestisciVerificaInvioImportTipo4(DettaglioAllegato dettaglioAllegato, byte[] theXml,
			UtenteLoggato utenteLoggato) throws ManagerException {
		log.debug("[SigitMgr::gestisciVerificaInvioImportTipo4] BEGIN");

		try {

			// Per ricondurre l'import alla situazione del web, recupero tutti i dati, faccio i controlli del web e salvo 

			// Riutilizzo il metodo usato da REE WEB, quindi mi crea la struttura vuota
			//BigDecimal idAllegato = getSigitMgr().salvaAllegato(dettaglioAllegato, utenteLoggato);

			// Devo ciclare per ogni Allegato ed inserirlo
			//dettaglioAllegato.setIdAllegato(ConvertUtil.convertToString(idAllegato));

			Tipo4 tipo4 = getSigitMgr().getAllegatoTipo4(dettaglioAllegato);
			StringBuffer msgError = new StringBuffer();
			try {
				// Verifico i dati generali

				getValidationMgr().validazioneFormaleReeTipo4(tipo4, dettaglioAllegato.getCodiceImpianto(),
						dettaglioAllegato.getDataControllo());

				// Se le verifiche hanno dato esito positivo aggiorno il campo

				SigitTAllegatoDto allegatoDto = getDbMgr()
						.cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

				allegatoDto.setDataUltMod(DateUtil.getSqlDataCorrente());
				allegatoDto.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(utenteLoggato.getCodiceFiscale()));
				allegatoDto.setAbcdfControlloweb(DateUtil.getSqlDataCorrente());

				// Valutare se fare un update puntuale per questi campi
				getDbMgr().aggiornaAllegato(allegatoDto);

			} catch (ValidationManagerException e) {
				// C'e' qualche dato non esatto quindi non devo aggiornare il campo AbcdfControlloweb, ma proseguo con i controlli
				log.debug("ValidationManagerException - validazioneFormaleReeTipo3: " + e.getMessageCompleto());
				msgError.append(e.getMessageCompleto());
			}

			List<String> idCompProgressiviList = dettaglioAllegato.getIdApparecchiatureFunz();

			for (String idCompProgressivo : idCompProgressiviList) {

				// Verifico i dati dettaglio

				Tipo4Dett tipo4Dett = getSigitMgr().caricaDatiReeTipo4Dett(dettaglioAllegato.getIdAllegato(),
						ConvertUtil.convertToInteger(idCompProgressivo));

				try {

					List<SigitTDettTipo4Dto> tDettTipo4List = getDbMgr().getDettTipo4(
							dettaglioAllegato.getCodiceImpianto(), ConvertUtil.convertToInteger(idCompProgressivo),
							dettaglioAllegato.getIdAllegato());

					tipo4Dett = MapDto.mapToTipo4Dett(tipo4Dett, tDettTipo4List);

					// verifico che abbia compilato la scheda
					getValidationMgr().validazioneFormaleReeTipo4Dett(tipo4Dett);

					// Faccio il salvataggio dei dati aggiornati
					// forse basterebbe fare un aggiornamento di 
					// dettTipo2.setEControlloweb(DateUtil.getSqlDataCorrente());
					// dettTipo2.setDataUltMod(DateUtil.getSqlDataCorrente());
					// dettTipo2.setUtenteUltMod(cfUtenteMod);
					getDbMgr().salvaReeTipo4Dett(tipo4Dett, utenteLoggato.getCodiceFiscale());

				} catch (ValidationManagerException e) {
					// C'e' qualche dato non esatto su Tipo1Dett
					// non eseguo la verifica dei singoli moduli
					log.debug("ValidationManagerException - validazioneFormaleReeTipo4Dett: " + e.getMessageCompleto());
					msgError.append(e.getMessageCompleto());

				}

			}

			//			getDbMgr().aggiornaImport(idImport, msgError.toString(),
			//					ConvertUtil.convertToBigDecimal(dettaglioAllegato.getIdAllegato()));

		} catch (Exception e) {

			throw new ManagerException(e, new Message(Messages.ERROR_INSERT_DB));
		} finally {
			log.debug("[SigitMgr::gestisciVerificaInvioImportTipo4] END");
		}

	}
	/*PROTECTED REGION END*/
}
