package it.csi.sigit.sigitext.business.be.manager;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;
import org.jboss.resteasy.spi.BadRequestException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTAllegatoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRIspezIspetDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAbilitazioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAccertamentoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAccertamentoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllegatoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImpiantoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTIspezione2018Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTIspezione2018Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaFisicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaFisicaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTUnitaImmobiliareDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTVerificaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTVerificaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.DaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTIspezione2018DaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTUnitaImmobiliareDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.GenericUtil;
import it.csi.sigit.sigitext.business.util.IndirizzoUtils;
import it.csi.sigit.sigitext.dto.sigitext.AssegnaIspezione;
import it.csi.sigit.sigitext.dto.sigitext.Ispezione;
import it.csi.sigit.sigitext.dto.sigitext.PFLoggato;
import it.csi.sigit.sigitext.dto.sigitext.Persona;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

public class IspezioneManager{

	
	protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE + ".IspezioneManager==>");


	public IspezioneManager() {
	}

	private DbIspezioneMgr dbIspezioneMgr;
	
	private ServiceManager serviceManager;		
	
	private SigitextManager sigitextManager;
	
	private DbServiceImp dbServiceImp;	
	
	private DbVerificaMgr dbVerificaMgr;
			
	public DbVerificaMgr getDbVerificaMgr() {
		return dbVerificaMgr;
	}
	public void setDbVerificaMgr(DbVerificaMgr dbVerificaMgr) {
		this.dbVerificaMgr = dbVerificaMgr;
	}
	public SigitextManager getSigitextManager() {
		return sigitextManager;
	}
	public void setSigitextManager(SigitextManager sigitextManager) {
		this.sigitextManager = sigitextManager;
	}
	public ServiceManager getServiceManager() {
		return serviceManager;
	}
	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}
	public DbIspezioneMgr getDbIspezioneMgr() {
		return dbIspezioneMgr;
	}
	public void setDbIspezioneMgr(DbIspezioneMgr dbIspezioneMgr) {
		this.dbIspezioneMgr = dbIspezioneMgr;
	}
	public DbServiceImp getDbServiceImp() {
		return dbServiceImp;
	}

	public void setDbServiceImp(DbServiceImp dbServiceImp) {
		this.dbServiceImp = dbServiceImp;
	}
	
	@Transactional
	public void assegnaIspezione(BigDecimal idIspezione2018,
			AssegnaIspezione assegnaIspezione) throws DaoException, SigitextException, ServiceException {
		try {
			logger.debug("assegnaIspezione - START");
			List<SigitRIspezIspetDto> listSigitRIspezIspetDto = dbIspezioneMgr.getSigitRIspezIspetByIdIspezione2018(idIspezione2018);
			
			//Il sistema verifica che non sia stato selezionato l'ispettore già assegnatario dell'ispezione; ossia verifica che SIGIT_R_ISPEZ_ISPET.fk_persona_fisica 
			//(per quel id_ispezione_2018 passato in input) non sia uguale a PERSONA.idPersona passato in input; eventualmente emettere opportuno messaggio di errore.
			
			if(assegnaIspezione.getUtenteLoggato()!=null && assegnaIspezione.getUtenteLoggato().getPfLoggato()!=null) {
				Persona persona = sigitextManager.getDettaglioPersonaFisica(assegnaIspezione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
				assegnaIspezione.getUtenteLoggato().getPfLoggato().setNomePF(persona.getNome());
				assegnaIspezione.getUtenteLoggato().getPfLoggato().setCognomePF(persona.getCognomeDenominazione());
				logger.debug("persona "+persona);
			}
			
			if(assegnaIspezione.getPersona()!=null) {
				Persona persona = sigitextManager.getDettaglioPersonaFisica(assegnaIspezione.getPersona().getCodiceFiscale());
				assegnaIspezione.setPersona(persona);
				logger.debug("persona "+persona);
			}
			
			
			BigDecimal fkPersonaFisica = null;
			String denominazioneAssegnatarioPrecedente="";
			if (listSigitRIspezIspetDto != null && !listSigitRIspezIspetDto.isEmpty()) {
				
				SigitRIspezIspetDto sigitRIspezIspetDto = listSigitRIspezIspetDto.get(0);
				for (SigitRIspezIspetDto sigitRIspezIspetDtoAsseg : listSigitRIspezIspetDto) {
					if(sigitRIspezIspetDtoAsseg.getDataFine() ==null || sigitRIspezIspetDtoAsseg.getIdIspezIspet().compareTo(sigitRIspezIspetDto.getIdIspezIspet())>0) {
						sigitRIspezIspetDto = sigitRIspezIspetDtoAsseg;
					}
				}
				
				
				if (assegnaIspezione != null && assegnaIspezione.getPersona() != null && new BigDecimal(assegnaIspezione.getPersona().getIdPersona())
							.equals(sigitRIspezIspetDto.getFkPersonaFisica())) {
						logger.info("L'ispezione e' gia' assegnata all'ispettore selezionato");
						throw new BadRequestException("L'ispezione e' gia' assegnata all'ispettore selezionato");					
				}
				
				//Aggiorna la SIGIT_R_ISPEZ_ISPET.data_fine = SYSDATE all'assegnatario precedente (se presente) per l'ispezione di interesse.
				sigitRIspezIspetDto.setDataFine(new Date((new java.util.Date().getTime())));
				dbIspezioneMgr.updateSigitRIspezIspet(sigitRIspezIspetDto);				
				fkPersonaFisica = sigitRIspezIspetDto.getFkPersonaFisica();
				SigitTPersonaFisicaPk sigitTPersonaFisicaPk = new SigitTPersonaFisicaPk();
				sigitTPersonaFisicaPk.setIdPersonaFisica(fkPersonaFisica);
				SigitTPersonaFisicaDto sigitTPersonaFisicaDto = dbServiceImp.getSigitTPersonaFisicaDao().findByPrimaryKey(sigitTPersonaFisicaPk);
				denominazioneAssegnatarioPrecedente = sigitTPersonaFisicaDto.getNome()+" "+
						sigitTPersonaFisicaDto.getCognome()+" "+sigitTPersonaFisicaDto.getCodiceFiscale();
				logger.debug("updateSigitRIspezIspet");
			}			
			
			if (assegnaIspezione != null && assegnaIspezione.getPersona() != null
					&& assegnaIspezione.getUtenteLoggato() != null && idIspezione2018!=null) {
				SigitRIspezIspetDto sigitRIspezIspetDto = new SigitRIspezIspetDto();
	
				sigitRIspezIspetDto.setIdIspezione2018(idIspezione2018);
				sigitRIspezIspetDto.setFkRuolo(new BigDecimal(2));
				sigitRIspezIspetDto.setDataInizio(new Date(new java.util.Date().getTime()));
				sigitRIspezIspetDto.setFkPersonaFisica(new BigDecimal(assegnaIspezione.getPersona().getIdPersona()));
				sigitRIspezIspetDto.setDataUltMod(new Timestamp(new java.util.Date().getTime()));
				sigitRIspezIspetDto
						.setUtenteUltMod(assegnaIspezione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
	
				//procede con la creazione del record su SIGIT_R_ISPEZ_ISPET
				Integer fkIspezIspet = dbIspezioneMgr.insertSigitRIspezIspet(sigitRIspezIspetDto);
				logger.debug("fkIspezIspet: "+fkIspezIspet);
							
				SigitTIspezione2018Pk sigitTIspezione2018Pk = new SigitTIspezione2018Pk(); 			
				sigitTIspezione2018Pk.setIdIspezione2018(idIspezione2018.intValue());
				SigitTIspezione2018Dto sigitTIspezione2018Dto = dbIspezioneMgr.getSigitTIspezione2018Dao().findByPrimaryKey(sigitTIspezione2018Pk);
				
				//Se esistono rapporti di prova in stato BOZZA associati all'ispezione, ossia recupera sulla VISTA_RICERCA_ALLEGATI l'elenco dei rapprova filtrando per il parametro "codice_impianto", 
				//con fk_stato_rapp = 0 (BOZZA) aggiornare SIGIT_T_ALLEGATO.fk_ispez_ispet con il nuovo id
				List<SigitVRicercaAllegatiDto> listSigitVRicercaAllegatiDto = dbIspezioneMgr.getSigitVRicercaAllegatiByCodImpianto(sigitTIspezione2018Dto.getCodiceImpianto());
				
				if (listSigitVRicercaAllegatiDto != null && !listSigitVRicercaAllegatiDto.isEmpty()) {
					for (SigitVRicercaAllegatiDto sigitVRicercaAllegatiDto : listSigitVRicercaAllegatiDto) {
	
						if(BigDecimal.ZERO.equals(sigitVRicercaAllegatiDto.getFkStatoRapp())) {
													
							SigitTAllegatoDao sigitTAllegatoDao = dbIspezioneMgr.getSigitTAllegatoDao();
							
							SigitTAllegatoPk sigitTAllegatoPk = new SigitTAllegatoPk();
							sigitTAllegatoPk.setIdAllegato(sigitVRicercaAllegatiDto.getIdAllegato());
							
							SigitTAllegatoDto sigitTAllegatoDto = sigitTAllegatoDao.findByPrimaryKey(sigitTAllegatoPk);						
							sigitTAllegatoDto.setFkIspezIspet(new BigDecimal(fkIspezIspet));
							dbIspezioneMgr.getSigitTAllegatoDao().update(sigitTAllegatoDto);						
							
						}
						
					}
				}			
				
				SigitTAzioneDto sigitTAzioneDto = new SigitTAzioneDto();			
				sigitTAzioneDto.setDtAzione(new Date(new java.util.Date().getTime()));
				sigitTAzioneDto.setFkTipoAzione(3);
				sigitTAzioneDto.setFkVerifica(0);
				sigitTAzioneDto.setFkAccertamento(0);
				sigitTAzioneDto.setFkIspezione2018(idIspezione2018.intValue());
				sigitTAzioneDto.setFkSanzione(0);
				String descrizioneAzione="";
				if(fkPersonaFisica == null) {
					descrizioneAzione = "Variazione utente assegnatario "+assegnaIspezione.getPersona().getNome()+" "+
							assegnaIspezione.getPersona().getCognomeDenominazione()+" "+assegnaIspezione.getPersona().getCodiceFiscale();
				}else {
					descrizioneAzione = "Variazione utente assegnatario da "+denominazioneAssegnatarioPrecedente+" a "+assegnaIspezione.getPersona().getNome()+" "+
							assegnaIspezione.getPersona().getCognomeDenominazione()+" "+assegnaIspezione.getPersona().getCodiceFiscale();
				}
					
				sigitTAzioneDto.setDescrizioneAzione(descrizioneAzione); 									
				sigitTAzioneDto.setCfUtenteAzione(assegnaIspezione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
				sigitTAzioneDto.setDenomUtenteAzione(assegnaIspezione.getUtenteLoggato().getPfLoggato().getCognomePF()+" "+assegnaIspezione.getUtenteLoggato().getPfLoggato().getNomePF());
				dbIspezioneMgr.getSigitTAzioneDao().insert(sigitTAzioneDto);
				
				logger.debug(descrizioneAzione);
				
				String oggetto = "notifica assegnazione ispezione "+idIspezione2018;
				String textHtml = assegnaIspezione.getUtenteLoggato().getPfLoggato().getNomePF()+" "
					    + assegnaIspezione.getUtenteLoggato().getPfLoggato().getCognomePF() +" "+ assegnaIspezione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF()+" ti ha assegnato l'ispezione "+
					    idIspezione2018;
			    //Il sistema invia anche notifica mail alla persona a cui viene assegnata l'ispezione (PERSONA.email):
			    //OGGETTO: notifica assegnazione ispezione xx
				serviceManager.sendMail(assegnaIspezione.getPersona().getEmail(), oggetto, textHtml, textHtml);
			}
							
			logger.debug("assegnaIspezione - END");
		}catch(BadRequestException e) {			
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error(getStackTraceAsString(e));
			throw e;		
		}catch(Exception e) {			
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error(getStackTraceAsString(e));
			throw e;
		}
	}
		
	//Il servizio permette di procedere con l'associazione dell'ispezione di interesse ad un impianto censito a sistema, previa applicazione di opportuni controlli
	//Parametri in input
	//id_ispezione_2018 di tipo Int (Obbligatorio)
	//codice_impianto di tipo Int (Obbligatorio)
	//UTENTELOGGATO Oggetto descritto nella sezione Oggetti del documento (Obbligatorio)
	//Parametri in output
	//esito di tipo Stringa OK , KO
	//descrizioneEsito di tipo Stringa
	@Transactional
	public void assegnaImpiantoIspezione(BigDecimal idIspezione2018, BigDecimal codiceImpianto, UtenteLoggato utenteLoggato) throws SigitextException, SigitTIspezione2018DaoException {
		
		try {
			logger.debug("assegnaImpiantoIspezione - START");
			
			if(utenteLoggato!=null && utenteLoggato.getPfLoggato()!=null) {
				Persona persona = sigitextManager.getDettaglioPersonaFisica(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
				
				utenteLoggato.getPfLoggato().setCognomePF(persona.getCognomeDenominazione());
				utenteLoggato.getPfLoggato().setNomePF(persona.getNome());
			}
		
			//Il sistema aggiorna sulla SIGIT_T_ISPEZIONE_2018, per il SIGIT_T_ISPEZIONE_2018.id_ispezione_2018 = id_ispezione_2018 in input, i seguenti campi come segue:
			SigitTIspezione2018Dto sigitTIspezione2018Dto = dbIspezioneMgr.getDettaglioIspezione(idIspezione2018.intValue());
			sigitTIspezione2018Dto.setCodiceImpianto(codiceImpianto);
			
			SigitTImpiantoDto sigitTImpiantoDto = getDbServiceImp().cercaImpiantoDtoById(codiceImpianto.toString());
			sigitTIspezione2018Dto.setIstatComuneCompetenza(sigitTImpiantoDto.getIstatComune());
			if(sigitTImpiantoDto.getIstatComune()!=null && sigitTImpiantoDto.getIstatComune().length()>3) {
				sigitTIspezione2018Dto.setIstatProvCompetenza(sigitTImpiantoDto.getIstatComune().substring(0, 3));
			}
			
			logger.debug("sigitTIspezione2018Dto: "+sigitTIspezione2018Dto);
			
			getDbServiceImp().getSigitTIspezione2018Dao().update(sigitTIspezione2018Dto );
	
			//registra l'azione eseguita su SIGIT_T_AZIONE impostando: 
			SigitTAzioneDto sigitTAzioneDto = new SigitTAzioneDto();
			sigitTAzioneDto.setDtAzione(new Date(new java.util.Date().getTime()));
			sigitTAzioneDto.setFkTipoAzione(3);
			sigitTAzioneDto.setFkVerifica(0);
			sigitTAzioneDto.setFkSanzione(0);
			sigitTAzioneDto.setFkAccertamento(0);
			sigitTAzioneDto.setFkIspezione2018(idIspezione2018.intValue());
			if(codiceImpianto!=null) {
				sigitTAzioneDto.setDescrizioneAzione("valorizzato codice impianto "+codiceImpianto.toString());
			}
			if(utenteLoggato!=null && utenteLoggato.getPfLoggato()!=null) {
				sigitTAzioneDto.setCfUtenteAzione(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
				sigitTAzioneDto.setDenomUtenteAzione(utenteLoggato.getPfLoggato().getCognomePF() + " " + utenteLoggato.getPfLoggato().getNomePF());
			}
			
			
			logger.debug("sigitTAzioneDto: "+sigitTAzioneDto);
			
			dbIspezioneMgr.getSigitTAzioneDao().insert(sigitTAzioneDto);
			
			logger.debug("assegnaImpiantoIspezione - END");
		}catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error(getStackTraceAsString(e));
			throw e;
		}
		
	}
	
	//Il servizio permette di procedere con la chiusura e conclusione dell'ispezione di interesse, previa applicazione di opportuni controlli
	@Transactional
	public void concludiIspezione(Ispezione ispezione) throws SigitextException, DaoException, ServiceException {
		
		try {
			logger.debug("concludiIspezione - START");	
			
			if(ispezione.getUtenteLoggato()!=null && ispezione.getUtenteLoggato().getPfLoggato()!=null) {
				Persona persona = sigitextManager.getDettaglioPersonaFisica(ispezione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
				
				ispezione.getUtenteLoggato().getPfLoggato().setCognomePF(persona.getCognomeDenominazione());
				ispezione.getUtenteLoggato().getPfLoggato().setNomePF(persona.getNome());
			}
							
			//Il sistema verifica: 
			//il codice impianto sia stato valorizzato, ossia SIGIT_T_ISPEZIONE_2018.codice_impianto != 0
			if(ispezione != null && ispezione.getDatiIspezione() != null && ispezione.getDatiIspezione().getIdIspezione2018()!=null) {
				
				SigitTIspezione2018Dto sigitTIspezione2018Dto = dbIspezioneMgr.getDettaglioIspezione(ispezione.getDatiIspezione().getIdIspezione2018().intValue());
				
				if(sigitTIspezione2018Dto!=null && BigDecimal.ZERO.equals(sigitTIspezione2018Dto.getCodiceImpianto())) {
					throw new SigitextException("Codice impianto non valido");
				}
				BigDecimal codiceImpianto = sigitTIspezione2018Dto.getCodiceImpianto();
				BigDecimal fkStatoIspezione = sigitTIspezione2018Dto.getFkStatoIspezione();
				ispezione.getDatiIspezione().setFkAccertamento(sigitTIspezione2018Dto.getFkAccertamento());
				ispezione.getDatiIspezione().setFkVerifica(sigitTIspezione2018Dto.getFkVerifica());
				
				ispezione.getDatiIspezione().setCodiceImpianto(codiceImpianto);				
													
				//per DATIISPEZIONE.id_ispezione_2018 in input, vi sia un record sulla SIGIT_R_ISPEZ_ISPET (ossia via sia un assegnatario della ispezione); in caso contrario emettere messaggio di errore "Attenzione: non è possibile concludere l'ispezione senza un ispettore primario associato"
				List<SigitRIspezIspetDto> listSigitRIspezIspetDto = dbIspezioneMgr.getSigitRIspezIspetByIdIspezione2018(ispezione.getDatiIspezione().getIdIspezione2018());
				if(listSigitRIspezIspetDto == null || listSigitRIspezIspetDto.isEmpty()) {
					throw new SigitextException("Attenzione: non e' possibile concludere l'ispezione senza un ispettore primario associato");
				}
		
				//ci sono rapporti di prova in stato BOZZA associati all'ispezione; ossia recupera sulla VISTA_RICERCA_ALLEGATI l'elenco dei rapprova filtrando per il parametro "codice_impianto", con fk_stato_rapp = 0 (BOZZA) se presenti emettere messaggio di errore
				List<SigitVRicercaAllegatiDto> listSigitVRicercaAllegatiDto = dbIspezioneMgr.getSigitVRicercaAllegatiByCodImpianto(codiceImpianto);
				if(listSigitVRicercaAllegatiDto != null && !listSigitVRicercaAllegatiDto.isEmpty()) {
					for (SigitVRicercaAllegatiDto sigitVRicercaAllegatiDto : listSigitVRicercaAllegatiDto) {
						if(sigitVRicercaAllegatiDto.getFkStatoRapp() != null && sigitVRicercaAllegatiDto.getFkStatoRapp().equals(BigDecimal.ZERO)) {
							
							throw new SigitextException("Attenzione: non è possibile concludere l'ispezione in presenza di rapporti di prova in stato BOZZA");
						}
					}
				}
					   
				//se DATIISPEZIONE.fk_stato_ispezione = 2 (CONCLUSO) o 3 (ANNULLATO) emettere messaggio di errore "Attenzione: impossibile completare l'operazione se stato ispezione = CONCLUSO o ANNULLATO".
				if(new BigDecimal(2).equals(fkStatoIspezione)) {
					throw new SigitextException("Attenzione: impossibile completare l'operazione se stato ispezione CONCLUSO");
				}
				
				if(new BigDecimal(3).equals(fkStatoIspezione)) {
					throw new SigitextException("Attenzione: impossibile completare l'operazione se stato ispezione ANNULLATO");
				}
	
			    //se DATISPEZIONE.fk_stato_ispezione = 1 (BOZZA) il sistema prosegue nel salvataggio descritto in seguito
				if(new BigDecimal(1).compareTo(fkStatoIspezione)==0) {
					
					//Se tutti i controlli hanno esito positivo, il sistema:
					//Aggiorna l'ispezione (DATIISPEZIONE.id_ispezione_2018) su DB nel seguente modo:
					sigitTIspezione2018Dto.setFlgEsito(ispezione.getDatiIspezione().getFlgEsito());
					sigitTIspezione2018Dto.setEnteCompetente(ispezione.getDatiIspezione().getEnteCompetente());
					sigitTIspezione2018Dto.setNote(ispezione.getDatiIspezione().getNote());
					sigitTIspezione2018Dto.setDtConclusione(new Timestamp(new java.util.Date().getTime()));			
					sigitTIspezione2018Dto.setFkStatoIspezione(new BigDecimal(2));
					sigitTIspezione2018Dto.setDtSveglia(null);
					sigitTIspezione2018Dto.setNoteSveglia("");
					dbIspezioneMgr.getSigitTIspezione2018Dao().update(sigitTIspezione2018Dto);
									
					//Il sistema registra l'azione eseguita procedendo con la creazione del record su SIGIT_T_AZIONE:
					SigitTAzioneDto sigitTAzioneDto = new SigitTAzioneDto();
					sigitTAzioneDto.setDtAzione(new Date(new java.util.Date().getTime()));
					if(sigitTIspezione2018Dto.getFkVerifica()!=0) {					
						sigitTAzioneDto.setFkTipoAzione(3);						
						sigitTAzioneDto.setFkVerifica(0);
						sigitTAzioneDto.setFkAccertamento(0);
					}
					if(sigitTIspezione2018Dto.getFkAccertamento()!=0) {
						sigitTAzioneDto.setFkTipoAzione(2);						
						sigitTAzioneDto.setFkVerifica(0);
						sigitTAzioneDto.setFkAccertamento(0);
					}					
					sigitTAzioneDto.setFkIspezione2018(ispezione.getDatiIspezione().getIdIspezione2018().intValue());
					sigitTAzioneDto.setFkSanzione(0);
					sigitTAzioneDto.setDescrizioneAzione("Ispezione conclusa da "+ispezione.getUtenteLoggato().getPfLoggato().getNomePF()+" "+ 
							ispezione.getUtenteLoggato().getPfLoggato().getCognomePF() + " "+ ispezione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
					sigitTAzioneDto.setCfUtenteAzione(ispezione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
					sigitTAzioneDto.setDenomUtenteAzione(ispezione.getUtenteLoggato().getPfLoggato().getCognomePF()+ " "+ispezione.getUtenteLoggato().getPfLoggato().getNomePF());
					dbIspezioneMgr.getSigitTAzioneDao().insert(sigitTAzioneDto);
								
				
			
				    //Aggiorna la tabella SIGIT_R_ISPEZ_ISPET (DATIISPEZIONE.id_ispezione_2018) andando a impostare la data_fine = SYSDATE per l'ispettore attivo (data_fine = null) associato.		
					for(SigitRIspezIspetDto sigitRIspezIspetDto : listSigitRIspezIspetDto) {
						sigitRIspezIspetDto.setDataFine(new Date(new java.util.Date().getTime()));
						dbIspezioneMgr.updateSigitRIspezIspet(sigitRIspezIspetDto);
					}		 		
					
			//	    	    4) Partendo dalla versione più aggiornata, creare una nuova versione consolidata del libretto (SIGIT_T_LIBRETTO) andando a popolare opportunamente la scheda 13. 
					//Operativamente occorre esegue il consolidamento del libretto (Algoritmo A019_10 Consolida Libretto) 
					//impostando il campo il campo SIGIT_T_LIBRETTO.fk_motivo_consolid = 9 ("Consolidamento per caricamento nuova ispezione")
					getServiceManager().consolidaLibretto(ispezione.getDatiIspezione().getCodiceImpianto().intValue(), null, Constants.CONSOLIDAMENTO_PER_NUOVA_ISPEZIONE, null, ispezione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
					
					String associataA = ispezione.getDatiIspezione().getFkAccertamento()!=null && ispezione.getDatiIspezione().getFkAccertamento()!=0?
							"accertamento "+ispezione.getDatiIspezione().getFkAccertamento():ispezione.getDatiIspezione().getFkVerifica()!=null && ispezione.getDatiIspezione().getFkVerifica()!=0?
							"verifica "+ispezione.getDatiIspezione().getFkVerifica():"";		
					List<SigitTPersonaFisicaDto> listSigitTPersonaFisicaDto = dbIspezioneMgr.getSigitTPersonaFisicaDao().findByCodiceFiscale(ispezione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
					
					String ubicazioneImpianto = "";
					List<SigitTUnitaImmobiliareDto> listSigitTUnitaImmobiliareDto = dbIspezioneMgr.getSigitTUnitaImmobiliareDao().findByCodiceImpianto(codiceImpianto.intValue());
					if(listSigitTUnitaImmobiliareDto!=null && !listSigitTUnitaImmobiliareDto.isEmpty()) {
						ubicazioneImpianto = listSigitTUnitaImmobiliareDto.get(0).getIndirizzoSitad()+" "+listSigitTUnitaImmobiliareDto.get(0).getCivico();
					}
					
					SigitTImpiantoPk sigitTImpiantoPk = new SigitTImpiantoPk();
					sigitTImpiantoPk.setCodiceImpianto(sigitTIspezione2018Dto.getCodiceImpianto());
					SigitTImpiantoDto sigitTImpiantoDto = dbIspezioneMgr.getSigitTImpiantoDao().findByPrimaryKey(sigitTImpiantoPk);
					
					ubicazioneImpianto+=", "+sigitTImpiantoDto.getDenominazioneComune()+" ("+sigitTImpiantoDto.getSiglaProvincia()+")";
										
					String oggetto = "notifica conclusione ispezione "+ispezione.getDatiIspezione().getIdIspezione2018().intValue()+" associata a "+associataA;
					String testoHtml = "L'ispezione in oggetto si e' conclusa<BR>"+"Codice impianto="+codiceImpianto+"<BR>"+"Ubicazione impianto="+ubicazioneImpianto+"<BR>";
					SigitTPersonaFisicaDto sigitTPersonaFisicaDto = listSigitTPersonaFisicaDto.get(0);
					if(sigitTPersonaFisicaDto!=null) {
						String email = sigitTPersonaFisicaDto.getEmail();
						
						serviceManager.sendMail(email, oggetto, testoHtml, GenericUtil.getStringaTxtToHtml(testoHtml));
					}
					
					SigitTAbilitazioneDto sigitTAbilitazioneDtoSearch = new SigitTAbilitazioneDto();
					sigitTAbilitazioneDtoSearch.setIdRuoloPa(2);
					sigitTAbilitazioneDtoSearch.setIstatAbilitazione("01"+sigitTIspezione2018Dto.getIstatProvCompetenza());
					List<SigitTAbilitazioneDto> listSigitTAbilitazioneDto = dbIspezioneMgr.getSigitTAbilitazioneDao().findByExample(sigitTAbilitazioneDtoSearch);
					
					if (listSigitTAbilitazioneDto != null) {
						for (SigitTAbilitazioneDto sigitTAbilitazioneDto : listSigitTAbilitazioneDto) {
							serviceManager.sendMail(sigitTAbilitazioneDto.getMailComunicazione(), oggetto, testoHtml, GenericUtil.getStringaTxtToHtml(testoHtml));
						}
					}
					
					if(sigitTIspezione2018Dto!=null) {
						if(sigitTIspezione2018Dto.getFkAccertamento()!=null && BigDecimal.ZERO.compareTo(new BigDecimal(sigitTIspezione2018Dto.getFkAccertamento()))!=0) {				
							
							sigitTAzioneDto = new SigitTAzioneDto();
							sigitTAzioneDto.setDtAzione(new Date(new java.util.Date().getTime()));
							sigitTAzioneDto.setFkTipoAzione(2);
							sigitTAzioneDto.setFkVerifica(0);
							sigitTAzioneDto.setFkAccertamento(sigitTIspezione2018Dto.getFkAccertamento());	
							sigitTAzioneDto.setFkIspezione2018(sigitTIspezione2018Dto.getIdIspezione2018());
							sigitTAzioneDto.setFkSanzione(0);
							sigitTAzioneDto.setDescrizioneAzione("L'ispezione "+sigitTIspezione2018Dto.getIdIspezione2018()+" associata e' stata conclusa");
							sigitTAzioneDto.setCfUtenteAzione(ispezione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
							sigitTAzioneDto.setDenomUtenteAzione(ispezione.getUtenteLoggato().getPfLoggato().getCognomePF()+ " "+ispezione.getUtenteLoggato().getPfLoggato().getNomePF());
							dbIspezioneMgr.getSigitTAzioneDao().insert(sigitTAzioneDto);
							
						}
						if(sigitTIspezione2018Dto.getFkVerifica()!=null && !BigDecimal.ZERO.equals(new BigDecimal(sigitTIspezione2018Dto.getFkVerifica()))) {
							
							sigitTAzioneDto = new SigitTAzioneDto();
							sigitTAzioneDto.setDtAzione(new Date(new java.util.Date().getTime())); 
							sigitTAzioneDto.setFkTipoAzione(1);
							sigitTAzioneDto.setFkVerifica(sigitTIspezione2018Dto.getFkVerifica());
							sigitTAzioneDto.setFkAccertamento(0);
							sigitTAzioneDto.setFkIspezione2018(sigitTIspezione2018Dto.getIdIspezione2018());
							sigitTAzioneDto.setFkSanzione(0);
							sigitTAzioneDto.setDescrizioneAzione("L'ispezione "+sigitTIspezione2018Dto.getIdIspezione2018()+" associata e' stata conclusa"); 						
							sigitTAzioneDto.setCfUtenteAzione(ispezione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
							sigitTAzioneDto.setDenomUtenteAzione(ispezione.getUtenteLoggato().getPfLoggato().getCognomePF()+ " "+ispezione.getUtenteLoggato().getPfLoggato().getNomePF());
							dbIspezioneMgr.getSigitTAzioneDao().insert(sigitTAzioneDto);
							
						}
					}
				}
	
			}
										    				  	
			logger.debug("concludiIspezione - END");
		}catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error(getStackTraceAsString(e));
			throw e;
		}
	}
	
	//Il servizio permette di procedere con l'inserimento iniziale o modifica dei dati relativi ad una ispezione, in funzione della verifica, 
	//ed eventuale accertamento, precedentemente definiti a sistema.
	@Transactional
	public BigDecimal setIspezione(BigDecimal idVerifica, BigDecimal idAccertamento, Ispezione ispezione) throws SigitextException, DaoException, ServiceException {
		
		try {
		
			logger.debug("setIspezione - START");
		
			Persona persona = new Persona();
			
			if(ispezione!=null && ispezione.getDatiIspezione()!=null) {
				
				if(ispezione.getUtenteLoggato()!=null && ispezione.getUtenteLoggato().getPfLoggato()!=null) {
					persona = sigitextManager.getDettaglioPersonaFisica(ispezione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
				}
						
				SigitTIspezione2018Dto sigitTIspezione2018Dto = new SigitTIspezione2018Dto();
	
				//inserimento
				if(ispezione.getDatiIspezione().getIdIspezione2018()==null) {
	
					
					sigitTIspezione2018Dto.setFkStatoIspezione(new BigDecimal("1"));
				    //Usare decodifica presente su SIGIT_D_STATO_ISPEZIONE (BOZZA)
													
					//FkVerifica
					if(idVerifica!=null && idAccertamento==null) {					
						 sigitTIspezione2018Dto.setFkVerifica(idVerifica.intValue());	
						 ispezione.getDatiIspezione().setFkVerifica(idVerifica.intValue());
					}else {
						 sigitTIspezione2018Dto.setFkVerifica(0);
					}
					
					BigDecimal codiceImpianto = BigDecimal.ZERO;
					if(idVerifica!=null) {
						//codice impianto verifica
						SigitTVerificaPk sigitTVerificaPk = new SigitTVerificaPk();
						sigitTVerificaPk.setIdVerifica(idVerifica.intValue());
						SigitTVerificaDto sigitTVerificaDto = getDbServiceImp().getSigitTVerificaDao().findByPrimaryKey(sigitTVerificaPk);
						if(sigitTVerificaDto!=null && sigitTVerificaDto.getCodiceImpianto()!=null && !sigitTVerificaDto.getCodiceImpianto().equals(BigDecimal.ZERO)) {
							codiceImpianto = sigitTVerificaDto.getCodiceImpianto(); 
						}				
					}
					
					if(idAccertamento!=null) {
						sigitTIspezione2018Dto.setFkAccertamento(idAccertamento.intValue());			
						 ispezione.getDatiIspezione().setFkAccertamento(idAccertamento.intValue());
						
						//codice impianto accertamento
						if(codiceImpianto.equals(BigDecimal.ZERO)) {						
							SigitTAccertamentoDto sigitTAccertamentoDto = getDbVerificaMgr().getAccertamentoById(idAccertamento.intValue());
							if(sigitTAccertamentoDto!=null && sigitTAccertamentoDto.getCodiceImpianto()!=null && !sigitTAccertamentoDto.getCodiceImpianto().equals(BigDecimal.ZERO)) {
								codiceImpianto = sigitTAccertamentoDto.getCodiceImpianto();
							}
						}					 
					}else {
						 sigitTIspezione2018Dto.setFkAccertamento(0);
					}				
					sigitTIspezione2018Dto.setCodiceImpianto(codiceImpianto);
					
					ispezione.getDatiIspezione().setCodiceImpianto(codiceImpianto);
					
				    sigitTIspezione2018Dto.setDtCreazione(new Timestamp(new java.util.Date().getTime()));			    	
				    sigitTIspezione2018Dto.setFlgIspPagamento(ispezione.getDatiIspezione().getFlgIspPagamento());
				    sigitTIspezione2018Dto.setIstatProvCompetenza(ispezione.getDatiIspezione().getIstatProvCompetenza());
				    sigitTIspezione2018Dto.setIstatComuneCompetenza(ispezione.getDatiIspezione().getIstatComuneCompetenza());
				    sigitTIspezione2018Dto.setNote(ispezione.getDatiIspezione().getNote());
				    SigitTIspezione2018Pk sigitTIspezione2018Pk = getDbServiceImp().getSigitTIspezione2018Dao().insert(sigitTIspezione2018Dto);
				    
				    ispezione.getDatiIspezione().setIdIspezione2018(new BigDecimal(sigitTIspezione2018Pk.getIdIspezione2018()));
				    
				    //inserimento SigitRIspezIspetDto
				    SigitRIspezIspetDto sigitRIspezIspetDto = new SigitRIspezIspetDto(); 
				    sigitRIspezIspetDto.setFkRuolo(new BigDecimal(2));
				    sigitRIspezIspetDto.setDataInizio(new Date(new java.util.Date().getTime()));
				    
				    
				    sigitRIspezIspetDto.setFkPersonaFisica(new BigDecimal(persona.getIdPersona()));			    	
				    
				    sigitRIspezIspetDto.setDataUltMod(new Timestamp(new java.util.Date().getTime()));
				    sigitRIspezIspetDto.setUtenteUltMod(persona.getCodiceFiscale());
				    
				    if(sigitTIspezione2018Pk!=null) {
				    	sigitRIspezIspetDto.setIdIspezione2018(new BigDecimal(sigitTIspezione2018Pk.getIdIspezione2018()));
				    }
				    
				    dbIspezioneMgr.insertSigitRIspezIspet(sigitRIspezIspetDto);	
				    
				    SigitTAbilitazioneDto sigitTAbilitazioneDto = new SigitTAbilitazioneDto();
				    sigitTAbilitazioneDto.setIdRuoloPa(2);
				    sigitTAbilitazioneDto.setIstatAbilitazione("01");
				    List<SigitTAbilitazioneDto> listSigitTAbilitazioneDto = dbIspezioneMgr.getSigitTAbilitazioneDao().findByExample(sigitTAbilitazioneDto);
				    
				    SigitTImpiantoPk sigitTImpiantoPk = new SigitTImpiantoPk();
				    sigitTImpiantoPk.setCodiceImpianto(ispezione.getDatiIspezione().getCodiceImpianto());
				    SigitTImpiantoDto sigitTImpiantoDto = dbIspezioneMgr.getSigitTImpiantoDao().findByPrimaryKey(sigitTImpiantoPk);
				    
				    if(listSigitTAbilitazioneDto!=null && !listSigitTAbilitazioneDto.isEmpty()) {
				    	//REGIONE
					    sendSetIspezioneMail(ispezione, sigitTIspezione2018Dto, listSigitTAbilitazioneDto.get(0), sigitTImpiantoDto);
				    }
				    
				    sigitTAbilitazioneDto = new SigitTAbilitazioneDto();
				    sigitTAbilitazioneDto.setIdRuoloPa(2);
				    sigitTAbilitazioneDto.setIstatAbilitazione("01"+sigitTIspezione2018Dto.getIstatProvCompetenza());
				    listSigitTAbilitazioneDto = dbIspezioneMgr.getSigitTAbilitazioneDao().findByExample(sigitTAbilitazioneDto);
				    
				    if(listSigitTAbilitazioneDto!=null && !listSigitTAbilitazioneDto.isEmpty()) {
				    	for (SigitTAbilitazioneDto sigitTAbilitazioneDtoProvincia : listSigitTAbilitazioneDto) {
				    		 sendSetIspezioneMail(ispezione, sigitTIspezione2018Dto, sigitTAbilitazioneDtoProvincia, sigitTImpiantoDto);
				    	}
				    }
				    	    
				}else {
					//aggiornamento				
					if(ispezione != null && ispezione.getDatiIspezione() != null && ispezione.getDatiIspezione().getIdIspezione2018() != null) {
						SigitTIspezione2018Pk sigitTIspezione2018Pk = new SigitTIspezione2018Pk();
						sigitTIspezione2018Pk.setIdIspezione2018(ispezione.getDatiIspezione().getIdIspezione2018().intValue());
						
						sigitTIspezione2018Dto = dbIspezioneMgr.getSigitTIspezione2018Dao().findByPrimaryKey(sigitTIspezione2018Pk);
						
						ispezione.getDatiIspezione().setCodiceImpianto(sigitTIspezione2018Dto.getCodiceImpianto());
						
			    	    if(ispezione.getDatiIspezione().getDtSveglia()!=null) {
			    	    	sigitTIspezione2018Dto.setDtSveglia(new Timestamp(ispezione.getDatiIspezione().getDtSveglia()));
			    	    }else {
			    	    	sigitTIspezione2018Dto.setDtSveglia(null);
			    	    }
			    	    sigitTIspezione2018Dto.setNoteSveglia(ispezione.getDatiIspezione().getNoteSveglia());
			    	    sigitTIspezione2018Dto.setNote(ispezione.getDatiIspezione().getNote());
			    	    
			    	    sigitTIspezione2018Dto.setCfIspettoreSecondario(ispezione.getDatiIspezione().getCfIspettoreSecondario());
			    	    sigitTIspezione2018Dto.setFlgIspPagamento(ispezione.getDatiIspezione().getFlgIspPagamento());

			    	    dbIspezioneMgr.getSigitTIspezione2018Dao().update(sigitTIspezione2018Dto);
					}
					
				}
				
			}
			
			logger.debug("setIspezione - END");
			
			return ispezione.getDatiIspezione().getIdIspezione2018();
		
		}catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error(getStackTraceAsString(e));
			throw e;
		}
	}
	private void sendSetIspezioneMail(Ispezione ispezione, SigitTIspezione2018Dto sigitTIspezione2018Dto,
			SigitTAbilitazioneDto sigitTAbilitazioneDto, SigitTImpiantoDto sigitTImpiantoDto)
			throws ServiceException, SigitTUnitaImmobiliareDaoException {
		
		
		String indirizzoImpianto = null;
		if(sigitTImpiantoDto.getCodiceImpianto()!=null) {
			List<SigitTUnitaImmobiliareDto> listSigitTUnitaImmobiliareDto = dbIspezioneMgr.getSigitTUnitaImmobiliareDao().findByCodiceImpianto(sigitTImpiantoDto.getCodiceImpianto().intValue());
			if(listSigitTUnitaImmobiliareDto!=null && !listSigitTUnitaImmobiliareDto.isEmpty()) {
				indirizzoImpianto = listSigitTUnitaImmobiliareDto.get(0).getIndirizzoSitad();
			}
		}
		
		String indirizzo = IndirizzoUtils.formattaIndirizzo(indirizzoImpianto, null, sigitTImpiantoDto.getDenominazioneComune(), sigitTImpiantoDto.getSiglaProvincia());
		StringBuilder corpoEmail = new StringBuilder();
		if(ispezione.getDatiIspezione().getFkVerifica()!=null && ispezione.getDatiIspezione().getFkVerifica()!=0) {
			corpoEmail.append("Dalla verifica "+ispezione.getDatiIspezione().getFkVerifica());
		}
		
		if(ispezione.getDatiIspezione().getFkAccertamento()!=null && ispezione.getDatiIspezione().getFkAccertamento()!=0) {
			corpoEmail.append("Dall'accertamento "+ispezione.getDatiIspezione().getFkAccertamento());
		}
		corpoEmail.append("  e' stata richiesta una nuova ispezione.<BR>");
		corpoEmail.append("Descrizione dell'ispezione<BR>");
		corpoEmail.append("Ispezione numero: "+ispezione.getDatiIspezione().getIdIspezione2018()+"<BR>"); 
		corpoEmail.append("Data creazione: "+new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date())+"<BR>"); 
		corpoEmail.append("Stato: BOZZA<BR>");
		corpoEmail.append("Codice impianto: "+sigitTImpiantoDto.getCodiceImpianto()+"<BR>"); 
		corpoEmail.append("Localizzazione: "+indirizzo+"<BR>"); 
		corpoEmail.append("Note: "+sigitTIspezione2018Dto.getNote());
		
		
		serviceManager.sendMail(sigitTAbilitazioneDto.getMailComunicazione(),
				"CIT - richiesta nuova ispezione "+ispezione.getDatiIspezione().getIdIspezione2018()+" su impianto con localizzazione : "+indirizzo,
						corpoEmail.toString(), GenericUtil.getStringaTxtToHtml(corpoEmail.toString())); 
	}
	
	//Il servizio permette di procedere con l'annullamento dell'ispezione di interesse, previa applicazione di opportuni controlli
	@Transactional
	public void annullaIspezione(Ispezione ispezione) throws Exception {
		
		try {

			logger.debug("annullaIspezione - START");	
			
			PFLoggato pFLoggato = new PFLoggato();
			if(ispezione.getUtenteLoggato()!=null && ispezione.getUtenteLoggato().getPfLoggato()!=null) {
				Persona persona = sigitextManager.getDettaglioPersonaFisica(ispezione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
				
				ispezione.getUtenteLoggato().getPfLoggato().setCognomePF(persona.getCognomeDenominazione());
				ispezione.getUtenteLoggato().getPfLoggato().setNomePF(persona.getNome());
				
				pFLoggato = ispezione.getUtenteLoggato().getPfLoggato();
			}
			
			if(ispezione!=null && ispezione.getDatiIspezione()!=null && ispezione.getDatiIspezione().getIdIspezione2018()!=null) {
				
				SigitTIspezione2018Pk sigitTIspezione2018Pk = new SigitTIspezione2018Pk();
				sigitTIspezione2018Pk.setIdIspezione2018(ispezione.getDatiIspezione().getIdIspezione2018().intValue());
				SigitTIspezione2018Dto sigitTIspezione2018Dto = dbIspezioneMgr.getSigitTIspezione2018Dao().findByPrimaryKey(sigitTIspezione2018Pk);
				
				BigDecimal codiceImpianto = sigitTIspezione2018Dto.getCodiceImpianto();
				if(codiceImpianto==null) {
					codiceImpianto = BigDecimal.ZERO;
				}
				List<SigitVRicercaAllegatiDto> listSigitVRicercaAllegatiDto = dbIspezioneMgr.getSigitVRicercaAllegatiDao().findRapportiProvaByCodiceImpianto(codiceImpianto.intValue());
				
				if(listSigitVRicercaAllegatiDto!=null) {
					for (SigitVRicercaAllegatiDto sigitVRicercaAllegatiDto : listSigitVRicercaAllegatiDto) {
					
						if(sigitVRicercaAllegatiDto.getFkStatoRapp().compareTo(BigDecimal.ZERO)==0 &&
								(new BigDecimal(8).compareTo(sigitVRicercaAllegatiDto.getFkTipoDocumento())==0 ||
								 new BigDecimal(9).compareTo(sigitVRicercaAllegatiDto.getFkTipoDocumento())==0)){
							
							
							dbServiceImp.getSigitTDettIspezGtDao().delete(sigitVRicercaAllegatiDto.getIdAllegato());
							dbServiceImp.getSigitTRappIspezGtDao().delete(sigitVRicercaAllegatiDto.getIdAllegato());
							dbServiceImp.getSigitTDettIspezGfDao().delete(sigitVRicercaAllegatiDto.getIdAllegato());
							dbServiceImp.getSigitTRappIspezGfDao().delete(sigitVRicercaAllegatiDto.getIdAllegato());
							dbServiceImp.getSigitRAllegatoCompGtDao().delete(sigitVRicercaAllegatiDto.getIdAllegato());
							dbServiceImp.getSigitRAllegatoCompGfDao().delete(sigitVRicercaAllegatiDto.getIdAllegato());
							dbServiceImp.getSigitRAllegatoCompScDao().delete(sigitVRicercaAllegatiDto.getIdAllegato());
							dbServiceImp.getSigitRAllegatoCompCgDao().delete(sigitVRicercaAllegatiDto.getIdAllegato());
							
							List<SigitTImportDto> importList = dbServiceImp.getSigitTImportDao().findByIdAllegato(sigitVRicercaAllegatiDto.getIdAllegato());
							if (importList != null && importList.size() > 0)
							{
								Integer idImport = importList.get(0).getIdImport();								
								dbServiceImp.getSigitTImpXmlDao().delete(new BigDecimal(idImport));
								SigitTImportPk sigitTImportPk = new SigitTImportPk();
								sigitTImportPk.setIdImport(idImport);
								dbServiceImp.getSigitTImportDao().delete(sigitTImportPk);
							}							
							
							dbServiceImp.getSigitTImpXmlDao().delete(sigitVRicercaAllegatiDto.getIdAllegato());
							dbServiceImp.getSigitTAllTxtDao().delete(sigitVRicercaAllegatiDto.getIdAllegato());
							dbServiceImp.getSigitTDocAllegatoDao().delete(sigitVRicercaAllegatiDto.getIdAllegato());							
							
							
							SigitTAllegatoPk sigitTAllegatoPk = new SigitTAllegatoPk();
							sigitTAllegatoPk.setIdAllegato(sigitVRicercaAllegatiDto.getIdAllegato());						
							SigitTAllegatoDto sigitTAllegatoDto = dbIspezioneMgr.getSigitTAllegatoDao().findByPrimaryKey(sigitTAllegatoPk);
							if(sigitTAllegatoDto!=null) {
								dbIspezioneMgr.getSigitTAllegatoDao().delete(sigitTAllegatoPk);
							}
						}
						
						if(sigitVRicercaAllegatiDto.getFkStatoRapp().compareTo(BigDecimal.ONE) == 0 &&
								(new BigDecimal(8).compareTo(sigitVRicercaAllegatiDto.getFkTipoDocumento())==0 ||
								 new BigDecimal(9).compareTo(sigitVRicercaAllegatiDto.getFkTipoDocumento())==0)){
							SigitTAllegatoPk sigitTAllegatoPk = new SigitTAllegatoPk();
							sigitTAllegatoPk.setIdAllegato(sigitVRicercaAllegatiDto.getIdAllegato());						
							SigitTAllegatoDto sigitTAllegatoDto = dbIspezioneMgr.getSigitTAllegatoDao().findByPrimaryKey(sigitTAllegatoPk);
							if(sigitTAllegatoDto!=null && sigitTAllegatoDto.getFkStatoRapp().equals(new BigDecimal(1))) {							
								sigitTAllegatoDto.setFkStatoRapp(new BigDecimal(2));
								dbIspezioneMgr.getSigitTAllegatoDao().update(sigitTAllegatoDto);
							}
						}				
					}
				}
												
				BigDecimal fkStatoIspezione = sigitTIspezione2018Dto.getFkStatoIspezione();
				
				if(sigitTIspezione2018Dto != null) {			
					sigitTIspezione2018Dto.setFkStatoIspezione(new BigDecimal("3"));
					sigitTIspezione2018Dto.setDtSveglia(null);
					sigitTIspezione2018Dto.setNoteSveglia(null);
					dbIspezioneMgr.getSigitTIspezione2018Dao().update(sigitTIspezione2018Dto);
				}
				
				//Il sistema registra l'azione eseguita procedendo con la creazione del record su SIGIT_T_AZIONE:
				SigitTAzioneDto sigitTAzioneDto = new SigitTAzioneDto();
				sigitTAzioneDto.setDtAzione(new Date(new java.util.Date().getTime()));
				sigitTAzioneDto.setFkTipoAzione(3);
				sigitTAzioneDto.setFkVerifica(0);
				sigitTAzioneDto.setFkAccertamento(0);
				sigitTAzioneDto.setFkIspezione2018(ispezione.getDatiIspezione().getIdIspezione2018().intValue());
				sigitTAzioneDto.setFkSanzione(0);
				sigitTAzioneDto.setDescrizioneAzione("Ispezione annullata da "+pFLoggato.getNomePF()+" "+ 
						pFLoggato.getCognomePF() + " "+ pFLoggato.getCodiceFiscalePF());
				sigitTAzioneDto.setCfUtenteAzione(pFLoggato.getCodiceFiscalePF());
				sigitTAzioneDto.setDenomUtenteAzione(pFLoggato.getCognomePF()+ " "+pFLoggato.getNomePF());
				dbIspezioneMgr.getSigitTAzioneDao().insert(sigitTAzioneDto);		
		
				if(sigitTIspezione2018Dto != null && new BigDecimal(2).compareTo(fkStatoIspezione) == 0) {
					
					String codiceFiscale = "";
					String associataA = "";
					if(sigitTIspezione2018Dto.getFkAccertamento()!=null && sigitTIspezione2018Dto.getFkAccertamento() != 0) {
						SigitTAccertamentoPk sigitTAccertamentoPk = new SigitTAccertamentoPk();
						sigitTAccertamentoPk.setIdAccertamento(sigitTIspezione2018Dto.getFkAccertamento());
						SigitTAccertamentoDto sigitTAccertamentoDto = dbIspezioneMgr.getSigitTAccertamentoDao().findByPrimaryKey(sigitTAccertamentoPk);
						codiceFiscale = sigitTAccertamentoDto.getCfUtenteAssegn();
						associataA="accertamento "+sigitTIspezione2018Dto.getFkAccertamento();
					}
					
					if(sigitTIspezione2018Dto.getFkVerifica()!=null && sigitTIspezione2018Dto.getFkVerifica() != 0) {
						SigitTVerificaPk sigitTVerificaPk = new SigitTVerificaPk();
						sigitTVerificaPk.setIdVerifica(sigitTIspezione2018Dto.getFkVerifica());
						SigitTVerificaDto sigitTVerificaDto = dbIspezioneMgr.getSigitTVerificaDao().findByPrimaryKey(sigitTVerificaPk);
						codiceFiscale = sigitTVerificaDto.getCfUtenteCaricamento();
						associataA="verifica "+sigitTIspezione2018Dto.getFkVerifica();
					}
					
					
					
					if(fkStatoIspezione.compareTo(new BigDecimal(2))==0) {
						
						getServiceManager().consolidaLibretto(codiceImpianto.intValue(), null, Constants.CONSOLIDAMENTO_PER_ANNULLAMENTO_ISPEZIONE, null, ispezione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
					
																	
						List<SigitTPersonaFisicaDto> listSigitTPersonaFisicaDto = dbIspezioneMgr.getSigitTPersonaFisicaDao().findByCodiceFiscale(codiceFiscale);
						
						
						String oggetto = "notifica annullamento ispezione " + ispezione.getDatiIspezione().getIdIspezione2018().intValue() + " associata a " + associataA;
						String corpo = "L'ispezione in oggetto e' stata annullata";
						SigitTPersonaFisicaDto sigitTPersonaFisicaDto = listSigitTPersonaFisicaDto.get(0);
						if(sigitTPersonaFisicaDto!=null) {
							String email = sigitTPersonaFisicaDto.getEmail();
							
							serviceManager.sendMail(email, oggetto, corpo, corpo);
						}
						
						SigitTAbilitazioneDto sigitTAbilitazioneDtoSearch = new SigitTAbilitazioneDto();
						sigitTAbilitazioneDtoSearch.setIdRuoloPa(2);
						sigitTAbilitazioneDtoSearch.setIstatAbilitazione("01"+sigitTIspezione2018Dto.getIstatProvCompetenza());
						List<SigitTAbilitazioneDto> listSigitTAbilitazioneDto = dbIspezioneMgr.getSigitTAbilitazioneDao().findByExample(sigitTAbilitazioneDtoSearch);
						
						if (listSigitTAbilitazioneDto != null) {
							for (SigitTAbilitazioneDto sigitTAbilitazioneDto : listSigitTAbilitazioneDto) {
								serviceManager.sendMail(sigitTAbilitazioneDto.getMailComunicazione(), oggetto,
										corpo, corpo);
							}
						}
					
					}
					
				}
		
				if(sigitTIspezione2018Dto!=null) {
					if(sigitTIspezione2018Dto.getFkAccertamento()!=null && !BigDecimal.ZERO.equals(new BigDecimal(sigitTIspezione2018Dto.getFkAccertamento()))) {				
						
						sigitTAzioneDto = new SigitTAzioneDto();
						sigitTAzioneDto.setDtAzione(new Date(new java.util.Date().getTime()));
						sigitTAzioneDto.setFkTipoAzione(2);
						sigitTAzioneDto.setFkVerifica(0);
						sigitTAzioneDto.setFkAccertamento(sigitTIspezione2018Dto.getFkAccertamento());	
						sigitTAzioneDto.setFkIspezione2018(sigitTIspezione2018Dto.getIdIspezione2018());
						sigitTAzioneDto.setFkSanzione(0);
						sigitTAzioneDto.setDescrizioneAzione("L'ispezione "+sigitTIspezione2018Dto.getIdIspezione2018()+" associata e' stata annullata");
						sigitTAzioneDto.setCfUtenteAzione(ispezione.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
						sigitTAzioneDto.setDenomUtenteAzione(pFLoggato.getCognomePF()+ " "+pFLoggato.getNomePF());
						dbIspezioneMgr.getSigitTAzioneDao().insert(sigitTAzioneDto);
						
					}
					if(sigitTIspezione2018Dto.getFkVerifica()!=null && !BigDecimal.ZERO.equals(new BigDecimal(sigitTIspezione2018Dto.getFkVerifica()))) {
						
						sigitTAzioneDto = new SigitTAzioneDto();
						sigitTAzioneDto.setDtAzione(new Date(new java.util.Date().getTime()));
						sigitTAzioneDto.setFkTipoAzione(1);
						sigitTAzioneDto.setFkVerifica(sigitTIspezione2018Dto.getFkVerifica());
						sigitTAzioneDto.setFkAccertamento(0);
						sigitTAzioneDto.setFkIspezione2018(sigitTIspezione2018Dto.getIdIspezione2018());
						sigitTAzioneDto.setFkSanzione(0);
						sigitTAzioneDto.setDescrizioneAzione("L'ispezione "+sigitTIspezione2018Dto.getIdIspezione2018()+" associata e' stata annullata"); 						
						sigitTAzioneDto.setCfUtenteAzione(pFLoggato.getCodiceFiscalePF());
						sigitTAzioneDto.setDenomUtenteAzione(pFLoggato.getCognomePF()+ " "+pFLoggato.getNomePF());
						dbIspezioneMgr.getSigitTAzioneDao().insert(sigitTAzioneDto);
						
					}
				}
			}
			logger.debug("annullaIspezione - END");
		}catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error(getStackTraceAsString(e));
			throw e;
		}			
		
	}
	
	public static String getStackTraceAsString(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        return stringWriter.toString();
    }
		
	
}
