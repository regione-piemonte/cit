package it.csi.sigit.sigitext.business.be.manager;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import javax.xml.rpc.ServiceException;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
//import org.bouncycastle.cms.CMSException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.FiltroRicercaPfPg;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompGfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRAllegatoCompGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRImpRuoloPfpgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRIspezIspetDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllegatoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTComp4Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompGfCompletoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompGtCompletoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTControlloLibrettoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettIspezGfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettIspezGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAggiuntivaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImpiantoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTIspezione2018Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTIspezione2018Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLibrettoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappIspezGfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappIspezGfPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappIspezGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappIspezGtPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTTrattH2ODto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTTrattH2OPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitWrkConfigDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitWrkLogDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.DaoException;
import it.csi.sigit.sigitext.business.pdf.IspezioneBuilder;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.dto.Circuito;
import it.csi.sigit.sigitext.dto.DatiRapProvaWebGf;
import it.csi.sigit.sigitext.dto.DatiRapProvaWebGt;
import it.csi.sigit.sigitext.dto.FileBase64;
import it.csi.sigit.sigitext.dto.Modulo;
import it.csi.sigit.sigitext.dto.RapProvaWeb;
import it.csi.sigit.sigitext.dto.index.DettaglioDocumento;
import it.csi.sigit.sigitext.dto.sigitext.DatiRapProva;
import it.csi.sigit.sigitext.dto.sigitext.DettaglioAllegato;
import it.csi.sigit.sigitext.dto.sigitext.Documento;
import it.csi.sigit.sigitext.dto.sigitext.Esito;
import it.csi.sigit.sigitext.dto.sigitext.Metadati;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;
import it.doqui.index.ecmengine.client.webservices.dto.OperationContext;

public class RapProvaManager {
	
	protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE + ".RapProvaManager==>");
	
	private DbIspezioneMgr dbIspezioneMgr;
	private DbServiceImp dbServiceImp;	
	private IspezioneBuilder ispezioneBuilder;
	private SigitextManager sigitextManager;	
	private ServiceManager serviceManager;
	
	private static final String CODICEIMPIANTO_NON_ASSOCIATO= "Nessun codice impianto non associato all'ispezione";
	private static final BigDecimal STATO_LIBRETTO_CONSOLIDATO= new BigDecimal(2);
	private static final BigDecimal STATO_RAPPROVA_CONSOLIDATO= new BigDecimal(1);	

	private static final BigDecimal TIPO_DOCUMENTO_GT = new BigDecimal(8);
	private static final BigDecimal TIPO_DOCUMENTO_GF = new BigDecimal(9);

	private static final List<Integer> RUOLI_CHECK_RESPONSABILE = Arrays.asList(Constants.ID_RUOLO_PROPRIETARIO,
			Constants.ID_RUOLO_OCCUPANTE, Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO,
			Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE, Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE,
			Constants.ID_RUOLO_AMMINISTRATORE);
	private static final List<String> RUOLI_GET_PDF_RAPPROVA = Arrays.asList(Constants.RUOLO_SUPER, Constants.RUOLO_ISPETTORE);

	private static final String FOLDER_TEMPLATE = "%s.%s.%.0fISPEZIONI";
	private static final String FILENAME_TEMPLATE = "%s_%.0f_%3$tY_%3$tm_%3$td_%4$.0f.%5$s";

	private static final Date _2016_12_31 = new Date(2016, 12, 31);
	
	private IndexServiceImp serviceIndex;

	public IndexServiceImp getServiceIndex() {
		return serviceIndex;
	}

	public void setServiceIndex(IndexServiceImp serviceIndex) {
		this.serviceIndex = serviceIndex;
	}

	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public SigitextManager getSigitextManager() {
		return sigitextManager;
	}

	public void setSigitextManager(SigitextManager sigitextManager) {
		this.sigitextManager = sigitextManager;
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
	
    public IspezioneBuilder getIspezioneBuilder() {
		return ispezioneBuilder;
	}

	public void setIspezioneBuilder(IspezioneBuilder ispezioneBuilder) {
		this.ispezioneBuilder = ispezioneBuilder;
	}

	//2) se per il codiceImpianto identificato al punto precedente, esiste almeno una versione del libretto in stato "2" ("Consolidato") 
	//sulla SIGIT_T_LIBRETTO.fkStato; in caso contrario emette il messaggio "Per compilare Rapporti di Efficienza Energetica e' necessario eseguire un consolidamento del libretto".	
	public boolean checkVersioneLibrettoConsolidato(List<SigitTLibrettoDto> listSigitTLibrettoDto){
		 
		if(listSigitTLibrettoDto!=null) {
			for(SigitTLibrettoDto sigitTLibrettoDto : listSigitTLibrettoDto) {			
				if(STATO_LIBRETTO_CONSOLIDATO.equals(sigitTLibrettoDto.getFkStato())){
					return true;
				}			
			}
		}		
		return false;
		
	}
	
	//4) Il sistema controlla (per il codiceImpianto identificato) se risulta caricato correttamente almeno un componente GT o GF della scheda 4, 
	//ossia sia valorizzata la SIGIT_T_COMP4.dtControlloweb, in corrispondenza del idComponente GT o GF
    //in caso contrario emette il messaggio "Per compilare Rapporto di Prova e' necessario eseguire un consolidamento del libretto"
	public boolean checkScheda4(List<SigitTComp4Dto> listSigitTComp4Dto){
	
		for (SigitTComp4Dto sigitTComp4Dto : listSigitTComp4Dto) {
			if(("GT".equalsIgnoreCase(sigitTComp4Dto.getIdTipoComponente()) || "GF".equalsIgnoreCase(sigitTComp4Dto.getIdTipoComponente())) &&
					sigitTComp4Dto.getDtControlloweb()!=null) {
				return true;
			}
		}
	
		return false;
	}
	
    //5) Il sistema verifica (per il codiceImpianto identificato) se esiste un responsabile impianto attivo alla SYSDATE 
	//(record su SIGIT_RIMP_RUOLO_PFPG con fkRuolo in (4,5,10,11,12,13) and dataFine is null) in caso contrario emettere il messaggio 
	//"Per compilare Rapporto di Prova e' necessario avere un responsabile attivo alla data odierna"
	public boolean checkResponsabileImpiantoAttivo(List<SigitRImpRuoloPfpgDto> listSigitRImpRuoloPfpgDto){
		
		for (SigitRImpRuoloPfpgDto sigitRImpRuoloPfpgDto : listSigitRImpRuoloPfpgDto) {
			if(sigitRImpRuoloPfpgDto.getDataFine()==null && 
					(
						(new BigDecimal(4).compareTo(sigitRImpRuoloPfpgDto.getFkRuolo())==0) ||
						(new BigDecimal(5).compareTo(sigitRImpRuoloPfpgDto.getFkRuolo())==0) ||
						(new BigDecimal(10).compareTo(sigitRImpRuoloPfpgDto.getFkRuolo())==0) ||
						(new BigDecimal(11).compareTo(sigitRImpRuoloPfpgDto.getFkRuolo())==0) ||
						(new BigDecimal(12).compareTo(sigitRImpRuoloPfpgDto.getFkRuolo())==0) ||
						(new BigDecimal(13).compareTo(sigitRImpRuoloPfpgDto.getFkRuolo())==0)
					)){				
				return true;
			}
		}
		return false;
	}

	//Servizio che permette di procedere con l'applicazione di una serie di controlli che abilitano l'inserimento di un rapporto di prova.
	public String getControlliRapProva(BigDecimal codiceImpianto, BigDecimal idIspezione2018)  throws DaoException, SigitextException, ServiceException{
		
		try {
			logger.debug("getControlliRapProva - START");
			
			if(codiceImpianto==null || BigDecimal.ZERO.equals(codiceImpianto) || idIspezione2018==null || BigDecimal.ZERO.equals(idIspezione2018)) {
				throw new SigitextException(CODICEIMPIANTO_NON_ASSOCIATO);
				
			}
			SigitTIspezione2018Pk sigitTIspezione2018Pk = new SigitTIspezione2018Pk();
			sigitTIspezione2018Pk.setIdIspezione2018(idIspezione2018.intValue());			
			SigitTIspezione2018Dto sigitTIspezione2018Dto = dbIspezioneMgr.getSigitTIspezione2018Dao().findByPrimaryKey(sigitTIspezione2018Pk);
			
		    //1) se e' stato associato un codice impianto all'ispezione (se no mettere messaggio di errore), 
			//ossia SIGIT_TISPEZIONE_2018.codiceImpianto != 0, per l'idIspezione_2018 di interesse.
			if(sigitTIspezione2018Dto==null || sigitTIspezione2018Dto.getCodiceImpianto()==null || BigDecimal.ZERO.compareTo(sigitTIspezione2018Dto.getCodiceImpianto())==0) {
				throw new SigitextException(CODICEIMPIANTO_NON_ASSOCIATO);				
			}

		    //2) se per il codiceImpianto identificato al punto precedente, esiste almeno una versione del libretto in stato "2" ("Consolidato") 
			//sulla SIGIT_T_LIBRETTO.fkStato; in caso contrario emette il messaggio "Per compilare Rapporti di Efficienza Energetica e' necessario eseguire un consolidamento del libretto".
			List<SigitTLibrettoDto> listSigitTLibrettoDto = dbServiceImp.getLibrettoByCodImpianto(codiceImpianto.intValue());
			if(!checkVersioneLibrettoConsolidato(listSigitTLibrettoDto)) {
				throw new SigitextException("Per compilare Rapporti di Efficienza Energetica e' necessario eseguire un consolidamento del libretto");	
			}
			
		    //3) Il sistema controlla (per il codiceImpianto identificato) se risultano verificate le seguenti schede del libretto, ossia:
	    	//SIGIT_T_CONTROLLO_LIBRETTO.flgL1Controlloweb = 1
	    	//SIGIT_T_CONTROLLO_LIBRETTO.flgL5Controlloweb = 1
	    	//SIGIT_T_CONTROLLO_LIBRETTO.flgL6Controlloweb = 1
	    	//SIGIT_T_CONTROLLO_LIBRETTO.flgL7Controlloweb = 1
	    	//in caso contrario emette il messaggio "Per compilare Rapporto di Prova e' necessario eseguire un consolidamento del libretto"
			SigitTControlloLibrettoDto sigitTControlloLibrettoDto = dbServiceImp.findControlloLibretto(codiceImpianto.toString());
			if(sigitTControlloLibrettoDto==null  
					|| STATO_RAPPROVA_CONSOLIDATO.compareTo(sigitTControlloLibrettoDto.getFlgL1Controlloweb())!=0
					|| STATO_RAPPROVA_CONSOLIDATO.compareTo(sigitTControlloLibrettoDto.getFlgL5Controlloweb())!=0
					|| STATO_RAPPROVA_CONSOLIDATO.compareTo(sigitTControlloLibrettoDto.getFlgL6Controlloweb())!=0
					|| STATO_RAPPROVA_CONSOLIDATO.compareTo(sigitTControlloLibrettoDto.getFlgL7Controlloweb())!=0) {
				
				throw new SigitextException("Per compilare Rapporto di Prova e' necessario eseguire un consolidamento del libretto");
				
			}
				
		    //4) Il sistema controlla (per il codiceImpianto identificato) se risulta caricato correttamente almeno un componente GT o GF della scheda 4, 
			//ossia sia valorizzata la SIGIT_T_COMP4.dtControlloweb, in corrispondenza del idComponente GT o GF
		    //in caso contrario emette il messaggio "Per compilare Rapporto di Prova e' necessario eseguire un consolidamento del libretto"
			List<SigitTComp4Dto> listSigitTComp4Dto = dbServiceImp.cercaTComp4NonControllateByCodImp(codiceImpianto.toString());			
			if(!checkScheda4(listSigitTComp4Dto)) {
				throw new SigitextException("Per compilare Rapporto di Prova e' necessario eseguire un consolidamento del libretto");	
			}						

		    //5) Il sistema verifica (per il codiceImpianto identificato) se esiste un responsabile impianto attivo alla SYSDATE 
			//(record su SIGIT_RIMP_RUOLO_PFPG con fkRuolo in (4,5,10,11,12,13) and dataFine is null) in caso contrario emettere il messaggio 
			//"Per compilare Rapporto di Prova e' necessario avere un responsabile attivo alla data odierna"
			List<SigitRImpRuoloPfpgDto> listSigitRImpRuoloPfpgDto = dbServiceImp.findSigitRImpRuoloPfpgByCodiceImpianto(codiceImpianto.intValue());
			if(!checkResponsabileImpiantoAttivo(listSigitRImpRuoloPfpgDto)) {
				throw new SigitextException("Per compilare Rapporto di Prova e' necessario avere un responsabile attivo alla data odierna");
			}

		   	//6) Il sistema verifica (per il codiceImpianto identificato) che il campo SIGIT_TIMPIANTO.flgTipoImpianto non sia null. 
			//Se null emettere il messaggio di errore "prima di procedere e' necessario eseguire un aggiornamento dei dati di ubicazione dell'impianto".
			SigitTImpiantoPk sigitTImpiantoPk = new SigitTImpiantoPk();
			sigitTImpiantoPk.setCodiceImpianto(codiceImpianto);
			SigitTImpiantoDto sigitTImpiantoDto = dbIspezioneMgr.getSigitTImpiantoDao().findByPrimaryKey(sigitTImpiantoPk);
			if(sigitTImpiantoDto==null || sigitTImpiantoDto.getFlgTipoImpianto()==null || "".equals(sigitTImpiantoDto.getFlgTipoImpianto().trim())) {
				throw new SigitextException("Prima di procedere e' necessario eseguire un aggiornamento dei dati di ubicazione dell'impianto");
			}
			
			//7) Il sistema verifica (per idIspezione_2018 di interesse) se esiste un record sulla SIGIT_RISPEZISPET, 
			//ossia se esiste un ispettore primario associato alla ispezione; in caso contrario emettere il messaggio 
			//"Attenzione: non e' possibile inserire un rapporto di prova senza un ispettore primario associato".
			List<SigitRIspezIspetDto> listSigitRIspezIspetDto = dbIspezioneMgr.getSigitRIspezIspetByIdIspezione2018(idIspezione2018);
			if(listSigitRIspezIspetDto==null || listSigitRIspezIspetDto.size()==0) {
				throw new SigitextException("Attenzione: non e' possibile inserire un rapporto di prova senza un ispettore primario associato");
			}
						
			logger.debug("getControlliRapProva - END");
		}catch(Exception e) {						
			logger.error(getStackTraceAsString(e));
			throw e;
		}
		
		//Se tutti i controlli risultano positivi, il sistema restituisce OK e procede.
		return "OK";
	}
	
	public List<DatiRapProva> getRapProva(BigDecimal codiceImpianto, BigDecimal idIspezione2018, final String ordinamento) throws DaoException {	
		
		logger.debug("getRapProva - START");
		
		if(idIspezione2018==null) {
			return new ArrayList<>(); 
		}
		
		if(codiceImpianto==null) {
			SigitTIspezione2018Pk sigitTIspezione2018Pk = new SigitTIspezione2018Pk();
			sigitTIspezione2018Pk.setIdIspezione2018(idIspezione2018.intValue());
			SigitTIspezione2018Dto sigitTIspezione2018Dto = dbIspezioneMgr.getSigitTIspezione2018Dao().findByPrimaryKey(sigitTIspezione2018Pk);
			if(sigitTIspezione2018Dto!=null) {
				codiceImpianto = sigitTIspezione2018Dto.getCodiceImpianto();
			}
		}
		
		List<SigitVRicercaAllegatiDto> listSigitVRicercaAllegatiDto = dbIspezioneMgr.getSigitVRicercaAllegatiByCodImpianto(codiceImpianto);
		final List<SigitRIspezIspetDto> listSigitRIspezIspetDto = dbIspezioneMgr.getSigitRIspezIspetByIdIspezione2018(idIspezione2018);
		List<DatiRapProva> listDatiRapProva = new ArrayList<>();
		
		if(listSigitVRicercaAllegatiDto != null) {						
																							
			listSigitVRicercaAllegatiDto.removeIf(new Predicate<SigitVRicercaAllegatiDto>(){

				@Override
				public boolean test(SigitVRicercaAllegatiDto sigitVRicercaAllegatiDto) {
					
					if(sigitVRicercaAllegatiDto.getFkTipoDocumento()!=null && sigitVRicercaAllegatiDto.getDesTipoDocumento()!=null) {
						if(( new BigDecimal(8).equals(sigitVRicercaAllegatiDto.getFkTipoDocumento()) && "Rapporto Prova GT".equalsIgnoreCase(sigitVRicercaAllegatiDto.getDesTipoDocumento()) ) || 
						   ( new BigDecimal(9).equals(sigitVRicercaAllegatiDto.getFkTipoDocumento()) && "Rapporto Prova GF".equalsIgnoreCase(sigitVRicercaAllegatiDto.getDesTipoDocumento()) )) {
																			
							if(listSigitRIspezIspetDto!=null) {
								for (SigitRIspezIspetDto sigitRIspezIspetDto : listSigitRIspezIspetDto) {
							
									if(sigitRIspezIspetDto.getIdIspezIspet()!=null) {										
									
										if(sigitVRicercaAllegatiDto.getFkIspezIspet()==null) {
											return true;
										}
										if(sigitRIspezIspetDto.getIdIspezIspet().compareTo(sigitVRicercaAllegatiDto.getFkIspezIspet())==0) {										
											return false;										
										}
									
									}
								}								
							}
						}
					}
					return true;
				}				
			});
				
		}								
											
		Collections.sort(listSigitVRicercaAllegatiDto, new Comparator<SigitVRicercaAllegatiDto>() {
			@Override
			public int compare(SigitVRicercaAllegatiDto arg0, SigitVRicercaAllegatiDto arg1) {
				switch (ordinamento) {
					case "statoRapprova":
					default:
						return arg0.getFkStatoRapp().compareTo(arg1.getFkStatoRapp());
					case "dataControlloAsc":
						return arg0.getDataControllo().compareTo(arg1.getDataControllo());
					case "dataControlloDesc":
						return arg1.getDataControllo().compareTo(arg0.getDataControllo());
					case "tipoRapprova":
						return arg0.getFkTipoDocumento().compareTo(arg1.getFkTipoDocumento());
				}
			}
			
		});
						
		for(SigitVRicercaAllegatiDto sigitVRicercaAllegatiDto: listSigitVRicercaAllegatiDto) {
			DatiRapProva datiRapProva = new DatiRapProva();
			datiRapProva.setIdAllegato(sigitVRicercaAllegatiDto.getIdAllegato());
			datiRapProva.setDesStatoRapp(sigitVRicercaAllegatiDto.getDesStatoRapp()); 
			datiRapProva.setDesTipoDocumento(sigitVRicercaAllegatiDto.getDesTipoDocumento());
			if(sigitVRicercaAllegatiDto.getDataControllo()!=null) {
				datiRapProva.setDataControllo(sigitVRicercaAllegatiDto.getDataControllo().getTime());			
			}
			datiRapProva.setFkStatoRapp(sigitVRicercaAllegatiDto.getFkStatoRapp());
			datiRapProva.setElencoApparecchiature(sigitVRicercaAllegatiDto.getElencoApparecchiature());
			datiRapProva.setFkTipoDocumento(sigitVRicercaAllegatiDto.getFkTipoDocumento());
			listDatiRapProva.add(datiRapProva);
		}
					
		logger.debug("getRapProva - END");
		return listDatiRapProva;
		
	}
	
	public static String getStackTraceAsString(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        return stringWriter.toString();
    }

	private boolean checkControlloWeb(SigitTAllegatoDto allegato, List<SigitTDettIspezGtDto> dettIspezGtList,
			List<SigitTDettIspezGfDto> dettIspezGfList) {
		boolean checkControlloWeb = allegato.getAbcdfControlloweb() != null;

		for (SigitTDettIspezGtDto dettIspezGt : dettIspezGtList) {
			if (dettIspezGt.getControlloWeb() == null) {
				checkControlloWeb = false;
			}
		}

		for (SigitTDettIspezGfDto dettIspezGf : dettIspezGfList) {
			if (dettIspezGf.getControlloWeb() == null) {
				checkControlloWeb = false;
			}
		}

		return checkControlloWeb;
	}

	private DettaglioAllegato allegatoToDettaglioAllegato(BigDecimal codiceImpianto, SigitTAllegatoDto allegato, SigitRIspezIspetDto ispezIspet) {
		DettaglioAllegato dettAllegato = new DettaglioAllegato();
		dettAllegato.setIdIspezione2018(ispezIspet.getIdIspezione2018().intValue());
		dettAllegato.setIdAllegato(allegato.getIdAllegato().intValue());
		dettAllegato.setCodiceImpianto(codiceImpianto.toString());
		dettAllegato.setDataControllo(String.format("%1$td/%1$tm/%1$tY", allegato.getDataControllo()));

		return dettAllegato;
	}

	private Metadati buildMetadati(SigitTAllegatoDto allegato, SigitTImpiantoDto impianto) {
		Metadati metadati = new Metadati();
		metadati.setCodiceImpianto(impianto.getCodiceImpianto().toString());
		metadati.setCodIstatComune(impianto.getIstatComune());
		metadati.setCodIstatProvincia(impianto.getIstatComune().substring(0, 2));
		metadati.setDataRapporto(String.format("%tF", allegato.getDataControllo())); // TODO: vengono davvero usati?
		metadati.setIdAllegato(allegato.getIdAllegato().toString()); // TODO: vengono davvero usati?

		return metadati;
	}

	private boolean checkImpiantoNonConformeDlgs1022014(SigitTAllegatoDto allegato, SigitTImpiantoDto impianto) throws Exception {
		List<SigitTDocAggiuntivaDto> docAggiuntivaList = dbServiceImp.getSigitTDocAggiuntivaDao().findByCodImp(impianto.getCodiceImpianto().toString());
		boolean deroga = false;

		for (SigitTDocAggiuntivaDto docAggiuntiva : docAggiuntivaList) {
			if (new BigDecimal(Constants.ID_TIPO_DOC_DEROGA).equals(docAggiuntiva.getFkTipoDocagg()) && docAggiuntiva.getDataDelete() == null) {
				deroga = true;
			}
		}

		return Constants.TIPO_IMPIANTO_CENTRALIZZATO.equals(impianto.getFlgTipoImpianto())
				&& allegato.getDataControllo().after(_2016_12_31)
				&& BigDecimal.ZERO.equals(impianto.getFlgContabilizzazione())
				&& !deroga;
	}

	private Esito inviaRapProva(BigDecimal idAllegato, BigDecimal codiceImpianto, UtenteLoggato utenteLoggato, Boolean isAllegatoGT, Boolean isUploadScansione) throws Exception {
		SigitTImpiantoDto impianto = dbServiceImp.getSigitTImpiantoDao().findByPrimaryKey(new SigitTImpiantoPk(codiceImpianto));

		if (impianto.getFlgTipoImpianto() == null) {
			throw new Exception("Prima di procedere è necessario eseguire un aggiornamento dei dati di ubicazione dell'impianto");
		}

		SigitTAllegatoDto allegato = dbServiceImp.getSigitTAllegatoDao().findByPrimaryKey(new SigitTAllegatoPk(idAllegato));

		if (allegato == null) {
			throw new Exception("Allegato inesistente");
		}

		if (!BigDecimal.ZERO.equals(allegato.getFkStatoRapp())) {
			throw new Exception("S040"); // TODO: S040 ovvero? "Stato allegato non coerente: "+stato
		}

		List<SigitTDettIspezGtDto> dettIspezGtList = dbServiceImp.getSigitTDettIspezGtDao().findByFkAllegato(idAllegato);
		List<SigitTDettIspezGfDto> dettIspezGfList = dbServiceImp.getSigitTDettIspezGfDao().findByIdAllegato(idAllegato);

		if (!checkControlloWeb(allegato, dettIspezGtList, dettIspezGfList)) {
			throw new Exception("Prima di inviare il Rapporto di prova occorre compilare tutti i campi obbligatori delle sezioni");
		}

		checkResponsabile(codiceImpianto, Instant.now().toEpochMilli());

		SigitTRappIspezGfPk rappIspezGfPk = new SigitTRappIspezGfPk();
		rappIspezGfPk.setIdAllegato(idAllegato);

		SigitTTrattH2ODto trattH2o = dbServiceImp.getSigitTTrattH2ODao().findByPrimaryKey(new SigitTTrattH2OPk(codiceImpianto));
		SigitTRappIspezGtDto rappIspezGt = dbServiceImp.getSigitTRappIspezGtDao().findByIdAllegato(idAllegato);
		SigitTRappIspezGfDto rappIspezGf = dbServiceImp.getSigitTRappIspezGfDao().findByPrimaryKey(rappIspezGfPk);

		if(!isUploadScansione) {
			// Controllo trattamento clima/H2O
			boolean climaNonRichiesto = (rappIspezGt != null && 
										 rappIspezGt.getS2fFlgTrattClimaNonRich() != null && 
										 rappIspezGt.getS2fFlgTrattClimaNonRich() == 1);
			boolean h2oNonRichiesto = (rappIspezGf != null && 
									   BigDecimal.ONE.equals(rappIspezGf.getS2eFlgTrattH2oNonRich()));

			if (trattH2o == null) {
				if (isAllegatoGT) {				
					if (!climaNonRichiesto) {
						throw new Exception("Impostare nella sezione 2 il trattamento clima/H2O a SI in assenza di trattamento sul libretto");
					}
				}
				else {
					if(!h2oNonRichiesto)
					{
						throw new Exception("Impostare nella sezione 2 il trattamento clima/H2O a SI in assenza di trattamento sul libretto");
					} 
				}
			} else {
				if(isAllegatoGT) {				
					boolean climaPresente = 
							BigDecimal.ONE.equals(trattH2o.getL23FlgTrattClimaAddolc()) ||
							BigDecimal.ONE.equals(trattH2o.getL23FlgTrattClimaAssente()) ||
							BigDecimal.ONE.equals(trattH2o.getL23FlgTrattClimaChimico()) ||
							BigDecimal.ONE.equals(trattH2o.getL23FlgTrattClimaFiltr());
					
					if (!climaPresente && !(climaNonRichiesto)) {
						throw new Exception("Impostare nella sezione 2 il trattamento clima/H2O a SI in assenza di trattamento sul libretto");
					}
				}
				else {
					boolean climaPresente = 
							BigDecimal.ONE.equals(trattH2o.getL23FlgTrattClimaAddolc()) ||
							BigDecimal.ONE.equals(trattH2o.getL23FlgTrattClimaAssente()) ||
							BigDecimal.ONE.equals(trattH2o.getL23FlgTrattClimaChimico()) ||
							BigDecimal.ONE.equals(trattH2o.getL23FlgTrattClimaFiltr());
					if (!climaPresente && !(h2oNonRichiesto)) {
						throw new Exception("Impostare nella sezione 2 il trattamento clima/H2O a SI in assenza di trattamento sul libretto");
					}
				}
			}
	
			// Controllo trattamento ACS
			boolean acsNonRichiesto = (rappIspezGt != null && 
									   rappIspezGt.getS2fFlgTrattAcsNonRich() != null && 
									   rappIspezGt.getS2fFlgTrattAcsNonRich() == 1);
			
			if (isAllegatoGT) {
				if (trattH2o == null) {
					if (!acsNonRichiesto) {
						throw new Exception("Impostare nella sezione 2 il trattamento ACS a SI in assenza di trattamento sul libretto");
					}
				} else {
					boolean acsPresente = 
						BigDecimal.ONE.equals(trattH2o.getL24FlgTrattAcsAddolc()) ||
						BigDecimal.ONE.equals(trattH2o.getL24FlgTrattAcsAssente()) ||
						BigDecimal.ONE.equals(trattH2o.getL24FlgTrattAcsChimico()) ||
						BigDecimal.ONE.equals(trattH2o.getL24FlgTrattAcsFiltr());
		
					if (!acsPresente && !acsNonRichiesto) {
						throw new Exception("Impostare nella sezione 2 il trattamento ACS a SI in assenza di trattamento sul libretto");
					}
				}
			}
		}

		if (allegato.getUidIndex() == null) {
			SigitRIspezIspetDto ispezIspet = dbIspezioneMgr.getSigitRIspezIspetDao().findByPrimaryKey(allegato.getFkIspezIspet());

			DettaglioAllegato dettAllegato = allegatoToDettaglioAllegato(codiceImpianto, allegato, ispezIspet);
			DettaglioDocumento dettDocumento = TIPO_DOCUMENTO_GT.equals(allegato.getFkTipoDocumento())
					? ispezioneBuilder.generaIspezioneGt(dettAllegato, false, false)
					: ispezioneBuilder.generaIspezioneGf(dettAllegato, false, false);

			String folder = String.format(FOLDER_TEMPLATE, impianto.getSiglaProvincia(), impianto.getIstatComune(), codiceImpianto);
			String filename = String.format(FILENAME_TEMPLATE, "RAPPROVA", codiceImpianto, allegato.getDataControllo(), allegato.getIdAllegato(), "pdf");
			Metadati metadati = buildMetadati(allegato, impianto);

			String uidIndex = serviceManager.indexUploadFileNew(filename, dettDocumento.getFile(), metadati, folder, true);

			allegato.setNomeAllegato(filename);
			allegato.setUidIndex(uidIndex);
		}
		

		allegato.setFkStatoRapp(BigDecimal.ONE);
		allegato.setDataUltMod(Timestamp.from(Instant.now()));
		allegato.setDataInvio(new java.sql.Date(Instant.now().toEpochMilli()));
		allegato.setUtenteUltMod(utenteLoggato.getPfLoggato().getCodiceFiscalePF());

		dbServiceImp.getSigitTAllegatoDao().update(allegato);

		boolean impiantoNonConformeDlgs1022014 = checkImpiantoNonConformeDlgs1022014(allegato, impianto);

		Esito esito = new Esito();
		esito.setEsito("OK");
		esito.setImpiantoNonConformeDlgs1022014(impiantoNonConformeDlgs1022014);

		return esito;
	}

	@Transactional
	public void deleteRapProva(BigDecimal idAllegato, BigDecimal idIspezione2018, UtenteLoggato utenteLoggato) throws Exception {
		SigitTIspezione2018Dto ispezione = dbServiceImp.getSigitTIspezione2018Dao().findByPrimaryKey(new SigitTIspezione2018Pk(idIspezione2018.intValue()));

		if (new BigDecimal(2).equals(ispezione.getFkStatoIspezione())) {
			throw new Exception("Ispezione in stato CONSOLIDATO");
		}

		SigitTAllegatoDto allegato = dbServiceImp.getSigitTAllegatoDao().findByPrimaryKey(new SigitTAllegatoPk(idAllegato));

		if (new BigDecimal(2).equals(allegato.getFkStatoRapp())) {
			throw new Exception("Allegato in stato RESPINTO");
		}

		dbServiceImp.getSigitTDettIspezGtDao().delete(idAllegato);
		dbServiceImp.getSigitTDettIspezGfDao().delete(idAllegato);
		dbServiceImp.getSigitTRappIspezGtDao().delete(idAllegato);
		dbServiceImp.getSigitTRappIspezGfDao().delete(idAllegato);
		dbServiceImp.getSigitRAllegatoCompGtDao().delete(idAllegato);
		dbServiceImp.getSigitRAllegatoCompGfDao().delete(idAllegato);
		dbServiceImp.getSigitTAllegatoDao().delete(new SigitTAllegatoPk(idAllegato));

		SigitWrkLogDto wrkLog = new SigitWrkLogDto();
		wrkLog.setCodiceFiscale(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
		wrkLog.setDataOperazione(Timestamp.from(Instant.now()));
		wrkLog.setIdRecord(String.format("id_allegato=%.0f", idAllegato));
		wrkLog.setTblImpattata("sigit_t_allegato");
		wrkLog.setTipoOperazione("DELETE");

		dbServiceImp.getSigitWrkLogDao().insert(wrkLog);
	}

	private DatiRapProva allegatoToDatiRapProva(SigitTAllegatoDto allegato, BigDecimal codiceImpianto) {
		DatiRapProva datiRapProva = new DatiRapProva();
		datiRapProva.setCodiceImpianto(codiceImpianto);
		datiRapProva.setDataControllo(allegato.getDataControllo().getTime());
		// datiRapProva.setDesStatoRapp();
		// datiRapProva.setDesTipoDocumento();
		datiRapProva.setElencoApparecchiature(allegato.getElencoApparecchiature());
		datiRapProva.setElencoCombustibili(allegato.getElencoCombustibili());
		datiRapProva.setFkIspezIspet(allegato.getFkIspezIspet());
		datiRapProva.setFkStatoRapp(allegato.getFkStatoRapp());
		datiRapProva.setFkTipoDocumento(allegato.getFkTipoDocumento());
		datiRapProva.setfOraArrivo(allegato.getFOraArrivo());
		datiRapProva.setIdAllegato(allegato.getIdAllegato());
		// datiRapProva.setIdIspezione2018();

		return datiRapProva;
	}

	private Modulo dettIspezGtToModulo(SigitTDettIspezGtDto dettIspezGt) {
		Modulo modulo = new Modulo();
		modulo.setS8aNModuloTermico(dettIspezGt.getS8aNModuloTermico());
		modulo.setS8bFumoMis1(dettIspezGt.getS8bFumoMis1());
		modulo.setS8bFumoMis2(dettIspezGt.getS8bFumoMis2());
		modulo.setS8bFumoMis3(dettIspezGt.getS8bFumoMis3());
		modulo.setS8cMarcaStrumMisura(dettIspezGt.getS8cMarcaStrumMisura());
		modulo.setS8cModelloStrumMisura (dettIspezGt.getS8cModelloStrumMisura());
		modulo.setS8cMatricolaStrumMisura(dettIspezGt.getS8cMatricolaStrumMisura());
		modulo.setS8dTempFluidoMandataC(dettIspezGt.getS8dTempFluidoMandataC());
		modulo.setS8dTempAriaC(dettIspezGt.getS8dTempAriaC());
		modulo.setS8dTempFumiC(dettIspezGt.getS8dTempFumiC());
		modulo.setS8dO2Perc(dettIspezGt.getS8dO2Perc());
		modulo.setS8dCo2Perc(dettIspezGt.getS8dCo2Perc());
		modulo.setS8dCoFumiSecchiPpm(dettIspezGt.getS8dCoFumiSecchiPpm());
		modulo.setS8dNoMgKwH(dettIspezGt.getS8dNoMgKwH());
		modulo.setS8eIndiceAria(dettIspezGt.getS8eIndiceAria());
		modulo.setS8eFumiSecchiNoAriaPpm(dettIspezGt.getS8eFumiSecchiNoAriaPpm());
		modulo.setS8eQsPerc(dettIspezGt.getS8eQsPerc());
		modulo.setS8eEtPerc(dettIspezGt.getS8eEtPerc());
		modulo.setS8eRendCombPerc(dettIspezGt.getS8eRendCombPerc());
		modulo.setS8eNoxMgKwH(dettIspezGt.getS8eNoxMgKwH());
		modulo.setS9aFlgMonossidoCarb(dettIspezGt.getS9aFlgMonossidoCarb());
		modulo.setS9bFlgFumosita(dettIspezGt.getS9bFlgFumosita());
		modulo.setS9cRendMinCombustPerc(dettIspezGt.getS9cRendMinCombustPerc());
		modulo.setS9cFlgRendCombustSuff(dettIspezGt.getS9cFlgRendCombustSuff());
		modulo.setS9dOssidiAzotoLimMgKwH(dettIspezGt.getS9dOssidiAzotoLimMgKwH());
		modulo.setS9dFlgOssidiAzoto(dettIspezGt.getS9dFlgOssidiAzoto());
		modulo.setS9eFlgRispettoNormativa(dettIspezGt.getS9eFlgRispettoNormativa());
		modulo.setS9eFlgNoRispetto7a(dettIspezGt.getS9eFlgNoRispetto7a());
		modulo.setS9eFlgNoRispetto7b(dettIspezGt.getS9eFlgNoRispetto7b());
		modulo.setS9eFlgNoRispetto9a(dettIspezGt.getS9eFlgNoRispetto9a());
		modulo.setS9eFlgNoRispetto9b(dettIspezGt.getS9eFlgNoRispetto9b());
		modulo.setS9eFlgNoRispetto9c(dettIspezGt.getS9eFlgNoRispetto9c());
		modulo.setS9eFlgNoRispetto9d(dettIspezGt.getS9eFlgNoRispetto9d());

		return modulo;
	}

	private DatiRapProvaWebGt rappIspezGtToDatiRapProvaWebGt(SigitTAllegatoDto allegato, SigitRAllegatoCompGtDto allegatoCompGt,
			SigitTRappIspezGtDto rappIspezGt, List<SigitTDettIspezGtDto> dettIspezGtList) {
		SigitTDettIspezGtDto firstDettIspezGt = dettIspezGtList.get(0);
		Long s1cDataRee = rappIspezGt.getS1cDataRee() != null ? rappIspezGt.getS1cDataRee().getTime() : null;
		Long s1eDtPrimaInstallazione = rappIspezGt.getS1eDtPrimaInstallazione() != null ? rappIspezGt.getS1eDtPrimaInstallazione().getTime() : null;
		Long s7aDataUltimaManut = firstDettIspezGt.getS7aDataUltimaManut() != null ? firstDettIspezGt.getS7aDataUltimaManut().getTime() : null;
		Long s7bDataRee = firstDettIspezGt.getS7bDataRee() != null ? firstDettIspezGt.getS7bDataRee().getTime() : null;
		List<Modulo> moduli = new ArrayList<>();

		for (SigitTDettIspezGtDto dettIspezGt : dettIspezGtList) {
			Modulo modulo = dettIspezGtToModulo(dettIspezGt);

			moduli.add(modulo);
		}

		DatiRapProvaWebGt datiRapProvaWebGt = new DatiRapProvaWebGt();
		datiRapProvaWebGt.setCodiceImpianto(allegatoCompGt.getCodiceImpianto().intValue());
		datiRapProvaWebGt.setControlloweb(firstDettIspezGt.getControlloWeb().getTime());
		datiRapProvaWebGt.setDataInstall(allegatoCompGt.getDataInstall().getTime());
		datiRapProvaWebGt.setFkTipoComponente(allegatoCompGt.getIdTipoComponente());
		datiRapProvaWebGt.setfOsservazioni(allegato.getFOsservazioni());
		datiRapProvaWebGt.setfPrescrizioni(allegato.getFPrescrizioni());
		datiRapProvaWebGt.setfRaccomandazioni(allegato.getFRaccomandazioni());
		datiRapProvaWebGt.setIdAllegato(allegato.getIdAllegato().intValue());
		// datiRapProvaWebGt.setIdDettIspezGt();
		datiRapProvaWebGt.setModuli(moduli);
		datiRapProvaWebGt.setProgressivo(allegatoCompGt.getProgressivo().intValue());
		datiRapProvaWebGt.setS1cFlgReeInviato(rappIspezGt.getS1cFlgReeInviato());
		datiRapProvaWebGt.setS1cFlgReeBollino(rappIspezGt.getS1cFlgReeBollino());
		datiRapProvaWebGt.setS1cSiglaBollino(rappIspezGt.getS1cSiglaBollino());
		datiRapProvaWebGt.setS1cNumBollino(rappIspezGt.getS1cNumBollino());
		datiRapProvaWebGt.setS1cDataRee(s1cDataRee);
		datiRapProvaWebGt.setS1eDtPrimaInstallazione(s1eDtPrimaInstallazione);
		datiRapProvaWebGt.setS1ePotFocolareKw(rappIspezGt.getS1ePotFocolareKw());
		datiRapProvaWebGt.setS1ePotUtileKw(rappIspezGt.getS1ePotUtileKw());
		datiRapProvaWebGt.setS1lDenomDelegato(rappIspezGt.getS1lDenomDelegato());
		datiRapProvaWebGt.setS1lFlgDelega(rappIspezGt.getS1lFlgDelega());
		datiRapProvaWebGt.setS2b1FlgTermoContab(rappIspezGt.getS2b1FlgTermoContab()); 
		datiRapProvaWebGt.setS2b2FlgUni10200(rappIspezGt.getS2b2FlgUni10200());
		datiRapProvaWebGt.setS2fFlgTrattClimaNonRich(rappIspezGt.getS2fFlgTrattClimaNonRich()); 
		datiRapProvaWebGt.setS2fFlgTrattAcsNonRich(rappIspezGt.getS2fFlgTrattAcsNonRich());
		datiRapProvaWebGt.setS3aFlgLocaleIntIdoneo(rappIspezGt.getS3aFlgLocaleIntIdoneo());
		datiRapProvaWebGt.setS3bFlgGenExtIdoneo(rappIspezGt.getS3bFlgGenExtIdoneo());
		datiRapProvaWebGt.setS3cFlgVentilazSuff(rappIspezGt.getS3cFlgVentilazSuff()); 
		datiRapProvaWebGt.setS3dFlgEvacFumiIdoneo(rappIspezGt.getS3dFlgEvacFumiIdoneo());
		datiRapProvaWebGt.setS3eFlgCartelliPresenti(rappIspezGt.getS3eFlgCartelliPresenti());
		datiRapProvaWebGt.setS3fFlgEstinzPresenti(rappIspezGt.getS3fFlgEstinzPresenti());
		datiRapProvaWebGt.setS3gFlgInterrGenPresenti(rappIspezGt.getS3gFlgInterrGenPresenti());
		datiRapProvaWebGt.setS3hFlgRubinPresente(rappIspezGt.getS3hFlgRubinPresente());
		datiRapProvaWebGt.setS3iFlgAssenzaPerdComb(rappIspezGt.getS3iFlgAssenzaPerdComb());
		datiRapProvaWebGt.setS3jFlgTempAmbFunz(rappIspezGt.getS3jFlgTempAmbFunz());
		datiRapProvaWebGt.setS3kFlgDm1121975(rappIspezGt.getS3kFlgDm1121975());    	    
		datiRapProvaWebGt.setS4aFlgLibImpPresente(rappIspezGt.getS4aFlgLibImpPresente());
		datiRapProvaWebGt.setS4bFlgLibCompilato(rappIspezGt.getS4bFlgLibCompilato());
		datiRapProvaWebGt.setS4cFlgConformitaPresente(rappIspezGt.getS4cFlgConformitaPresente());
		datiRapProvaWebGt.setS4dFlgLibUsoPresente(rappIspezGt.getS4dFlgLibUsoPresente());
		datiRapProvaWebGt.setS4eFlgPraticaVvfPresente(rappIspezGt.getS4eFlgPraticaVvfPresente());
		datiRapProvaWebGt.setS4fFlgPraticaInailPresente(rappIspezGt.getS4fFlgPraticaInailPresente());
		datiRapProvaWebGt.setS4gFlgDm121975(rappIspezGt.getS4gFlgDm121975());
		datiRapProvaWebGt.setS4gMatricolaDm1121975(rappIspezGt.getS4gMatricolaDm1121975());
		datiRapProvaWebGt.setS5aFlgAdozioneValvoleTerm(rappIspezGt.getS5aFlgAdozioneValvoleTerm());
		datiRapProvaWebGt.setS5aFlgIsolamenteRete(rappIspezGt.getS5aFlgIsolamenteRete());
		datiRapProvaWebGt.setS5aFlgAdozSistTrattamH2o(rappIspezGt.getS5aFlgAdozSistTrattam_h2o());
		datiRapProvaWebGt.setS5aFlgSostituzSistRegolaz(rappIspezGt.getS5aFlgSostituzSistRegolaz());
		datiRapProvaWebGt.setS5bFlgNoIntervConv(rappIspezGt.getS5bFlgNoIntervConv());
		datiRapProvaWebGt.setS5bFlgRelazDettaglio(rappIspezGt.getS5bFlgRelazDettaglio());
		datiRapProvaWebGt.setS5bFlgRelazDettaglioSucc(rappIspezGt.getS5bFlgRelazDettaglioSucc());
		datiRapProvaWebGt.setS5bFlgValutazNonEseguita(rappIspezGt.getS5bFlgValutazNonEseguita()); 
		datiRapProvaWebGt.setS5bMotivoRelazNonEseg(rappIspezGt.getS5bMotivoRelazNonEseg());
		datiRapProvaWebGt.setS5cFlgDimensCorretto(rappIspezGt.getS5cFlgDimensCorretto());
		datiRapProvaWebGt.setS5cFlgDimensNonCorretto(rappIspezGt.getS5cFlgDimensNonCorretto());
		datiRapProvaWebGt.setS5cFlgDimensNonControll(rappIspezGt.getS5cFlgDimensNonControll());
		datiRapProvaWebGt.setS5cFlgDimensRelazSucces(rappIspezGt.getS5cFlgDimensRelazSucces());
		datiRapProvaWebGt.setS6dFlgEvacuFumi(firstDettIspezGt.getS6dFlgEvacuFumi());
		datiRapProvaWebGt.setS6iFlgTipoB(firstDettIspezGt.getS6iFlgTipoB());
		datiRapProvaWebGt.setS6iFlgTipoC(firstDettIspezGt.getS6iFlgTipoC());
		datiRapProvaWebGt.setS6jFkClassDpr66096(firstDettIspezGt.getS6jFkClassDpr66096());
		datiRapProvaWebGt.setS6kPotTermFocolKw(firstDettIspezGt.getS6kPotTermFocolKw());
		datiRapProvaWebGt.setS6kBruciatoreDaKw(firstDettIspezGt.getS6kBruciatoreDaKw());
		datiRapProvaWebGt.setS6kBruciatoreAKw(firstDettIspezGt.getS6kBruciatoreAKw());
		datiRapProvaWebGt.setS6lPortataCombM3H(firstDettIspezGt.getS6lPortataCombM3H());
		datiRapProvaWebGt.setS6lPortataCombKgH(firstDettIspezGt.getS6lPortataCombKgH());
		datiRapProvaWebGt.setS6lPotTermFocolKw(firstDettIspezGt.getS6lPotTermFocolKw());
		datiRapProvaWebGt.setS7aFkFrequenzaManut(firstDettIspezGt.getS7aFkFrequenzaManut());
		datiRapProvaWebGt.setS7aFrequenzaManutAltro(firstDettIspezGt.getS7aFrequenzaManutAltro());
		datiRapProvaWebGt.setS7aFlgManutEffettuata(firstDettIspezGt.getS7aFlgManutEffettuata());
		datiRapProvaWebGt.setS7aDataUltimaManut(s7aDataUltimaManut);
		datiRapProvaWebGt.setS7bFlgReePresente(firstDettIspezGt.getS7bFlgReePresente());
		datiRapProvaWebGt.setS7bDataRee(s7bDataRee);
		datiRapProvaWebGt.setS7bFlgOsservazioni(firstDettIspezGt.getS7bFlgOsservazioni());
		datiRapProvaWebGt.setS7bFlgRaccomand(firstDettIspezGt.getS7bFlgRaccomand());
		datiRapProvaWebGt.setS7bFlgPrescr(firstDettIspezGt.getS7bFlgPrescr());

		return datiRapProvaWebGt;
	}

	private Circuito dettIspezGfToCircuito(SigitTDettIspezGfDto dettIspezGf) {
		Circuito circuito = new Circuito();
		circuito.setS8aNCircuito(dettIspezGf.getS8aNCircuito());
		circuito.setS8bFlgProveRaffrescamento(dettIspezGf.getS8bFlgProveRaffrescamento());
		circuito.setS8bFlgProveRiscaldamento(dettIspezGf.getS8bFlgProveRiscaldamento());
		circuito.setS8cFlgFiltriPuliti(dettIspezGf.getS8cFlgFiltriPuliti());
		circuito.setS8dFlgAssenzaPerditeGas(dettIspezGf.getS8dFlgAssenzaPerditeGas());
		circuito.setS8eMarcaStrumMisura(dettIspezGf.getS8eMarcaStrumMisura());
		circuito.setS8eModelloStrumMisura(dettIspezGf.getS8eModelloStrumMisura());
		circuito.setS8eMatricolaStrumMisura(dettIspezGf.getS8eMatricolaStrumMisura());
		circuito.setS8fPotAssorbitaKw(dettIspezGf.getS8fPotAssorbitaKw());
		circuito.setS8gFlgStrumentazioneFissa(dettIspezGf.getS8gFlgStrumentazioneFissa());
		circuito.setS8hOperatoreDenominazione(dettIspezGf.getS8hOperatoreDenominazione());
		circuito.setS8iOperatoreNumIscriz(dettIspezGf.getS8iOperatoreNumIscriz());
		circuito.setS8jSurriscaldamentoK(dettIspezGf.getS8jSurriscaldamentoK());
		circuito.setS8jSottoraffreddamentoK(dettIspezGf.getS8jSottoraffreddamentoK());
		circuito.setS8jTempCondensazioneC(dettIspezGf.getS8jTempCondensazioneC());
		circuito.setS8jTempEvaporazioneC(dettIspezGf.getS8jTempEvaporazioneC());
		circuito.setS8jTempSorgIngressoC(dettIspezGf.getS8jTempSorgIngressoC());
		circuito.setS8jTempSorgUscitaC(dettIspezGf.getS8jTempSorgUscitaC());
		circuito.setS8jTempIngressoFluidoC(dettIspezGf.getS8jTempIngressoFluidoC());
		circuito.setS8jTempUscitaFluidoC(dettIspezGf.getS8jTempUscitaFluidoC());
		circuito.setS9aFlgVerificaSuperata(dettIspezGf.getS9aFlgVerificaSuperata());
		circuito.setS9bFlgRispettoNormativa(dettIspezGf.getS9bFlgRispettoNormativa());
		circuito.setS9cFlgNoRispetto7a(dettIspezGf.getS9cFlgNoRispetto7a());
		circuito.setS9cFlgNoRispetto7b(dettIspezGf.getS9cFlgNoRispetto7b());
		circuito.setS9cFlgNoRispetto8d(dettIspezGf.getS9cFlgNoRispetto8d());
		circuito.setS9cFlgNoRispetto9a(dettIspezGf.getS9cFlgNoRispetto9a());

		return circuito;
	}

	private DatiRapProvaWebGf rappIspezGfToDatiRapProvaWebGf(SigitTAllegatoDto allegato, SigitRAllegatoCompGfDto allegatoCompGf,
			SigitTRappIspezGfDto rappIspezGf, List<SigitTDettIspezGfDto> dettIspezGfList) {
		SigitTDettIspezGfDto firstDettIspezGf = dettIspezGfList.get(0);
		Long s1cDataRee = rappIspezGf.getS1cDataRee() != null ? rappIspezGf.getS1cDataRee().getTime() : null;
		Long s1eDtPrimaInstallazione = rappIspezGf.getS1eDtPrimaInstallazione() != null ? rappIspezGf.getS1eDtPrimaInstallazione().getTime() : null;
		Long s7aDataUltimaManut = firstDettIspezGf.getS7aDataUltimaManut() != null ? firstDettIspezGf.getS7aDataUltimaManut().getTime() : null;
		Long s7cDataRee = firstDettIspezGf.getS7cDataRee() != null ? firstDettIspezGf.getS7cDataRee().getTime() : null;
		List<Circuito> circuiti = new ArrayList<>();

		for (SigitTDettIspezGfDto dettIspezGf : dettIspezGfList) {
			Circuito circuito = dettIspezGfToCircuito(dettIspezGf);

			circuiti.add(circuito);
		}

		DatiRapProvaWebGf datiRapProvaWebGf = new DatiRapProvaWebGf();
		datiRapProvaWebGf.setCodiceImpianto(allegatoCompGf.getCodiceImpianto().intValue());
		datiRapProvaWebGf.setDataInstall(allegatoCompGf.getDataInstall().getTime());
		datiRapProvaWebGf.setFkTipoComponente(allegatoCompGf.getIdTipoComponente());
		datiRapProvaWebGf.setfOsservazioni(allegato.getFOsservazioni());
		datiRapProvaWebGf.setfPrescrizioni(allegato.getFPrescrizioni());
		datiRapProvaWebGf.setfRaccomandazioni(allegato.getFRaccomandazioni());
		// datiRapProvaWebGf.setIdDettIspezGf();
		datiRapProvaWebGf.setCircuiti(circuiti);
		datiRapProvaWebGf.setProgressivo(allegatoCompGf.getProgressivo().intValue());
		datiRapProvaWebGf.setS1cFlgReeInviato(rappIspezGf.getS1cFlgReeInviato()); 
		datiRapProvaWebGf.setS1cFlgReeBollino(rappIspezGf.getS1cFlgReeBollino());
		datiRapProvaWebGf.setS1cFlgSiglaBollino(rappIspezGf.getS1cSiglaBollino());
		datiRapProvaWebGf.setS1cNumBollino(rappIspezGf.getS1cNumBollino());
		datiRapProvaWebGf.setS1cDataRee(s1cDataRee);
		datiRapProvaWebGf.setS1eDtPrimaInstallazione(s1eDtPrimaInstallazione);
		datiRapProvaWebGf.setS1ePotTermicaMaxKw(rappIspezGf.getS1ePotTermicaMaxKw());
		datiRapProvaWebGf.setS1lDenomDelegato(rappIspezGf.getS1lDenomDelegato());
		datiRapProvaWebGf.setS1lFlgDelega(rappIspezGf.getS1lFlgDelega());
		datiRapProvaWebGf.setS2eFlgTrattH2oNonRich(rappIspezGf.getS2eFlgTrattH2oNonRich());
		datiRapProvaWebGf.setS3aFlgLocaleIntIdoneo(rappIspezGf.getS3aFlgLocaleIntIdoneo());
		datiRapProvaWebGf.setS3bFlgLineeElettrIdonee(rappIspezGf.getS3bFlgLineeElettrIdonee());
		datiRapProvaWebGf.setS3cFlgVentilazAdeguate(rappIspezGf.getS3cFlgVentilazAdeguate());
		datiRapProvaWebGf.setS3dFlgCoibentazioniIdonee(rappIspezGf.getS3dFlgCoibentazioniIdonee());
		datiRapProvaWebGf.setS4aFlgLibImpPresente(rappIspezGf.getS4aFlgLibImpPresente());
		datiRapProvaWebGf.setS4bFlgLibCompilato(rappIspezGf.getS4bFlgLibCompilato());
		datiRapProvaWebGf.setS4cFlgConformitaPresente(rappIspezGf.getS4cFlgConformitaPresente());
		datiRapProvaWebGf.setS4dFlgLibUsoPresente(rappIspezGf.getS4dFlgLibUsoPresente());
		datiRapProvaWebGf.setS5aFlgSostituzMacchineReg(rappIspezGf.getS5aFlgSostituzMacchineReg());
		datiRapProvaWebGf.setS5aFlgSostituzSistemiReg(rappIspezGf.getS5aFlgSostituzSistemiReg());
		datiRapProvaWebGf.setS5aFlgIsolamReteDistrib(rappIspezGf.getS5aFlgIsolamReteDistrib());
		datiRapProvaWebGf.setS5aFlgIsolamCanaliDistrib(rappIspezGf.getS5aFlgIsolamCanaliDistrib());
		datiRapProvaWebGf.setS5bFlgNoIntervConv(rappIspezGf.getS5bFlgNoIntervConv());
		datiRapProvaWebGf.setS5bFlgRelazDettaglio(rappIspezGf.getS5bFlgRelazDettaglio());
		datiRapProvaWebGf.setS5bFlgRelazDettaglioSucc(rappIspezGf.getS5bFlgRelazDettaglioSucc());
		datiRapProvaWebGf.setS5bFlgValutazNonEseguita(rappIspezGf.getS5bFlgValutazNonEseguita());
		datiRapProvaWebGf.setS5bMotivoRelazNonEseg(rappIspezGf.getS5bMotivoRelazNonEseg());
		datiRapProvaWebGf.setS5cFlgDimensCorretto(rappIspezGf.getS5cFlgDimensCorretto());
		datiRapProvaWebGf.setS5cFlgDimensNonCorretto(rappIspezGf.getS5cFlgDimensNonCorretto());
		datiRapProvaWebGf.setS5cFlgDimensNonControll(rappIspezGf.getS5cFlgDimensNonControll());
		datiRapProvaWebGf.setS5cFlgDimensRelazSucces(rappIspezGf.getS5cFlgDimensRelazSucces());
		datiRapProvaWebGf.setS6hFlgInverter(firstDettIspezGf.getS6hFlgInverter());
		datiRapProvaWebGf.setS6nFlgFugaDiretta(firstDettIspezGf.getS6nFlgFugaDiretta());
		datiRapProvaWebGf.setS6nFlgFugaIndiretta(firstDettIspezGf.getS6nFlgFugaIndiretta());
		datiRapProvaWebGf.setS7aFkFrequenzaManut(firstDettIspezGf.getS7aFkFrequenzaManut());
		datiRapProvaWebGf.setS7aFrequenzaManutaltro(firstDettIspezGf.getS7aFrequenzaManutAltro());
		datiRapProvaWebGf.setS7aFlgManutEffettuata(firstDettIspezGf.getS7aFlgManutEffettuata());
		datiRapProvaWebGf.setS7aDataUltimaManut(s7aDataUltimaManut);
		datiRapProvaWebGf.setS7bFlgRegistroApparecc(firstDettIspezGf.getS7bFlgRegistroApparecc());
		datiRapProvaWebGf.setS7cFlgReePresente(firstDettIspezGf.getS7cFlgReePresente());
		datiRapProvaWebGf.setS7cDataRee(s7cDataRee);
		datiRapProvaWebGf.setS7cFlgOsservazioni(firstDettIspezGf.getS7cFlgOsservazioni());
		datiRapProvaWebGf.setS7cFlgRaccomand(firstDettIspezGf.getS7cFlgRaccomand());
		datiRapProvaWebGf.setS7cFlgPrescr(firstDettIspezGf.getS7cFlgPrescr());

		return datiRapProvaWebGf;
	}

	public RapProvaWeb getRapProvaWeb(BigDecimal idAllegato) throws Exception {
		SigitTAllegatoDto allegato = dbServiceImp.getSigitTAllegatoDao().findByPrimaryKey(new SigitTAllegatoPk(idAllegato));

		if (TIPO_DOCUMENTO_GT.equals(allegato.getFkTipoDocumento())) {
			CompFilter filter = new CompFilter();
			filter.setIdAllegato(idAllegato.intValue());
			List<SigitRAllegatoCompGtDto> allegatoCompGtList = dbServiceImp.getSigitRAllegatoCompGtDao().findByFilter(filter);

			SigitTRappIspezGtDto rappIspezGt = dbServiceImp.getSigitTRappIspezGtDao().findByIdAllegato(idAllegato);

			List<SigitTDettIspezGtDto> dettIspezGtList = dbServiceImp.getSigitTDettIspezGtDao().findByFkAllegato(idAllegato);

			if (allegatoCompGtList.isEmpty()) {
				throw new Exception("Errore: rapprova senza componenti");
			}

			if (allegatoCompGtList.size() > 1) {
				throw new Exception("Errore: rapprova con più componenti non supportati");
			}

			if (rappIspezGt == null || dettIspezGtList.isEmpty()) {
				throw new Exception("Errore: dati form assenti o mancanti");
			}

			DatiRapProva datiRapProva = allegatoToDatiRapProva(allegato, allegatoCompGtList.get(0).getCodiceImpianto());
			DatiRapProvaWebGt datiRapProvaWebGt = rappIspezGtToDatiRapProvaWebGt(allegato, allegatoCompGtList.get(0), rappIspezGt,
					dettIspezGtList);

			RapProvaWeb rapProvaWeb = new RapProvaWeb();
			rapProvaWeb.setDatiRapProva(datiRapProva);
			rapProvaWeb.setDatiRapProvaWebGt(datiRapProvaWebGt);

			return rapProvaWeb;
		}

		if (TIPO_DOCUMENTO_GF.equals(allegato.getFkTipoDocumento())) {
			CompFilter filter = new CompFilter();
			filter.setIdAllegato(idAllegato.intValue());
			List<SigitRAllegatoCompGfDto> allegatoCompGfList = dbServiceImp.getSigitRAllegatoCompGfDao().findByFilter(filter);

			SigitTRappIspezGfPk rappIspezGfPk = new SigitTRappIspezGfPk();
			rappIspezGfPk.setIdAllegato(idAllegato);
			SigitTRappIspezGfDto rappIspezGf = dbServiceImp.getSigitTRappIspezGfDao().findByPrimaryKey(rappIspezGfPk);

			List<SigitTDettIspezGfDto> dettIspezGfList = dbServiceImp.getSigitTDettIspezGfDao().findByIdAllegato(idAllegato);

			if (allegatoCompGfList.isEmpty()) {
				throw new Exception("Errore: rapprova senza componenti");
			}

			if (allegatoCompGfList.size() > 1) {
				throw new Exception("Errore: rapprova con più componenti non supportati");
			}

			if (rappIspezGf == null || dettIspezGfList.isEmpty()) {
				throw new Exception("Errore: dati form assenti o mancanti");
			}

			DatiRapProva datiRapProva = allegatoToDatiRapProva(allegato, allegatoCompGfList.get(0).getCodiceImpianto());
			DatiRapProvaWebGf datiRapProvaWebGf = rappIspezGfToDatiRapProvaWebGf(allegato, allegatoCompGfList.get(0), rappIspezGf, dettIspezGfList);

			RapProvaWeb rapProvaWeb = new RapProvaWeb();
			rapProvaWeb.setDatiRapProva(datiRapProva);
			rapProvaWeb.setDatiRapProvaWebGf(datiRapProvaWebGf);

			return rapProvaWeb;
		}

		throw new Exception("Errore: tipologia allegato non valida");
	}

	private void validateDatiRapProva(DatiRapProva datiRapProva) throws Exception {
		List<String> invalidFields = new ArrayList<>();

		if (datiRapProva == null) {
			throw new Exception("Oggetto DatiRapProva non presente");
		}

		if (datiRapProva.getCodiceImpianto() == null) {
			invalidFields.add("CodiceImpianto");
		}

		if (datiRapProva.getDataControllo() == null) {
			invalidFields.add("DataControllo");
		}

		if (datiRapProva.getElencoApparecchiature() == null) {
			invalidFields.add("ElencoApparecchiature");
		}

		if (TIPO_DOCUMENTO_GT.equals(datiRapProva.getFkTipoDocumento()) && datiRapProva.getElencoCombustibili() == null) {
			invalidFields.add("ElencoCombustibili");
		}

		if (datiRapProva.getFkIspezIspet() == null) {
			invalidFields.add("FkIspezIspet");
		}

		if (datiRapProva.getFkTipoDocumento() == null) {
			invalidFields.add("FkTipoDocumento");
		}

		if (datiRapProva.getfOraArrivo() == null) {
			invalidFields.add("fOraArrivo");
		}

		if (!invalidFields.isEmpty()) {
			String message = String.format("I seguenti campi sono obbligatori: %s", String.join(", ", invalidFields)); // TODO: analisi dice S006

			throw new Exception(message);
		}
	}

	private void checkResponsabile(BigDecimal codiceImpianto, Long inData) throws Exception {
		FiltroRicercaPfPg filter = new FiltroRicercaPfPg();
		filter.setInData(new java.sql.Date(inData));
		filter.setCodiceImpianto(codiceImpianto.toString());
		filter.setIdRuoloList(RUOLI_CHECK_RESPONSABILE);

		List<SigitRImpRuoloPfpgDto> impRuoloPfPgList = dbServiceImp.getSigitRImpRuoloPfpgDao().findAttiviByFilter(filter);

		if (impRuoloPfPgList.isEmpty()) {
			String message = String.format("Responsabile impianto non presente o non attivo in data %1$td/%1$tm/%1$tY", inData);
			throw new Exception(message);
		}
	}

	private SigitTAllegatoDto rapProvaWebToAllegato(RapProvaWeb rapProvaWeb) {
		DatiRapProva datiRapProva = rapProvaWeb.getDatiRapProva();

		String osservazioni = TIPO_DOCUMENTO_GT.equals(datiRapProva.getFkTipoDocumento())
				? rapProvaWeb.getDatiRapProvaWebGt().getfOsservazioni()
				: rapProvaWeb.getDatiRapProvaWebGf().getfOsservazioni();
		String raccomandazioni = TIPO_DOCUMENTO_GT.equals(datiRapProva.getFkTipoDocumento())
				? rapProvaWeb.getDatiRapProvaWebGt().getfRaccomandazioni()
				: rapProvaWeb.getDatiRapProvaWebGf().getfRaccomandazioni();
		String prescrizioni = TIPO_DOCUMENTO_GT.equals(datiRapProva.getFkTipoDocumento())
				? rapProvaWeb.getDatiRapProvaWebGt().getfPrescrizioni()
				: rapProvaWeb.getDatiRapProvaWebGf().getfPrescrizioni();
		java.sql.Date dataControllo = new java.sql.Date(datiRapProva.getDataControllo());

		SigitTAllegatoDto allegato = new SigitTAllegatoDto();
		allegato.setIdAllegato(datiRapProva.getIdAllegato());
		allegato.setFOsservazioni(osservazioni);
		allegato.setFRaccomandazioni(raccomandazioni);
		allegato.setFPrescrizioni(prescrizioni);
		allegato.setAbcdfControlloweb(Timestamp.from(Instant.now()));
		allegato.setFkStatoRapp(BigDecimal.ZERO);
		allegato.setFkTipoDocumento(datiRapProva.getFkTipoDocumento());
		allegato.setFkTipoManutenzione(0);
		allegato.setDataControllo(dataControllo);
		allegato.setFOraArrivo(datiRapProva.getfOraArrivo());
		allegato.setDataUltMod(Timestamp.from(Instant.now()));
		allegato.setUtenteUltMod(rapProvaWeb.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
		allegato.setCfRedattore(rapProvaWeb.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
		allegato.setFlgControlloBozza(BigDecimal.ZERO);
		allegato.setElencoApparecchiature(datiRapProva.getElencoApparecchiature());
		allegato.setElencoCombustibili(datiRapProva.getElencoCombustibili());
		allegato.setFkIspezIspet(datiRapProva.getFkIspezIspet());

		return allegato;
	}

	private SigitRAllegatoCompGtDto datiRapProvaWebGtToAllegatoCompGt(BigDecimal idAllegato,
			BigDecimal codiceImpianto, DatiRapProvaWebGt datiRapProvaWebGt) {
		SigitRAllegatoCompGtDto allegatoCompGt = new SigitRAllegatoCompGtDto();
		allegatoCompGt.setCodiceImpianto(codiceImpianto);
		allegatoCompGt.setDataInstall(new java.sql.Date(datiRapProvaWebGt.getDataInstall()));
		allegatoCompGt.setIdAllegato(idAllegato);
		allegatoCompGt.setIdTipoComponente(Constants.TIPO_COMPONENTE_GT);
		allegatoCompGt.setProgressivo(new BigDecimal(datiRapProvaWebGt.getProgressivo()));

		return allegatoCompGt;
	}

	private SigitRAllegatoCompGfDto datiRapProvaWebGfToAllegatoCompGf(BigDecimal idAllegato,
			BigDecimal codiceImpianto, DatiRapProvaWebGf datiRapProvaWebGf) {
		SigitRAllegatoCompGfDto allegatoCompGf = new SigitRAllegatoCompGfDto();
		allegatoCompGf.setCodiceImpianto(codiceImpianto);
		allegatoCompGf.setDataInstall(new java.sql.Date(datiRapProvaWebGf.getDataInstall()));
		allegatoCompGf.setIdAllegato(idAllegato);
		allegatoCompGf.setIdTipoComponente(Constants.TIPO_COMPONENTE_GF);
		allegatoCompGf.setProgressivo(new BigDecimal(datiRapProvaWebGf.getProgressivo()));

		return allegatoCompGf;
	}

	private SigitTRappIspezGtDto datiRapProvaWebGtToRappIspezGt(BigDecimal idAllegato, DatiRapProvaWebGt datiRapProvaWebGt, UtenteLoggato utenteLoggato) {
		java.sql.Date s1cDataRee = datiRapProvaWebGt.getS1cDataRee() != null
				? new java.sql.Date(datiRapProvaWebGt.getS1cDataRee())
				: null;
		java.sql.Date s1eDtPrimaInstallazione = datiRapProvaWebGt.getS1eDtPrimaInstallazione() != null
				? new java.sql.Date(datiRapProvaWebGt.getS1eDtPrimaInstallazione())
				: null;

		SigitTRappIspezGtPk rappIspezGtPk = new SigitTRappIspezGtPk();
		rappIspezGtPk.setIdAllegato(idAllegato);

		SigitTRappIspezGtDto rappIspezGt = new SigitTRappIspezGtDto();
		rappIspezGt.setSigitTRappIspezGtPk(rappIspezGtPk);
		rappIspezGt.setS1cFlgReeInviato(datiRapProvaWebGt.getS1cFlgReeInviato());
		rappIspezGt.setS1cFlgReeBollino(datiRapProvaWebGt.getS1cFlgReeBollino());
		rappIspezGt.setS1cSiglaBollino(datiRapProvaWebGt.getS1cSiglaBollino());
		rappIspezGt.setS1cNumBollino(datiRapProvaWebGt.getS1cNumBollino());
		rappIspezGt.setS1cDataRee(s1cDataRee);
		rappIspezGt.setS1eDtPrimaInstallazione(s1eDtPrimaInstallazione);
		rappIspezGt.setS1ePotFocolareKw(datiRapProvaWebGt.getS1ePotFocolareKw());
		rappIspezGt.setS1ePotUtileKw(datiRapProvaWebGt.getS1ePotUtileKw());
		rappIspezGt.setS1lDenomDelegato(datiRapProvaWebGt.getS1lDenomDelegato());
		rappIspezGt.setS1lFlgDelega(datiRapProvaWebGt.getS1lFlgDelega());
		rappIspezGt.setS2b1FlgTermoContab(datiRapProvaWebGt.getS2b1FlgTermoContab());
		rappIspezGt.setS2b2FlgUni10200(datiRapProvaWebGt.getS2b2FlgUni10200());
		rappIspezGt.setS2fFlgTrattClimaNonRich(datiRapProvaWebGt.getS2fFlgTrattClimaNonRich());
		rappIspezGt.setS2fFlgTrattAcsNonRich(datiRapProvaWebGt.getS2fFlgTrattAcsNonRich());
		rappIspezGt.setS3aFlgLocaleIntIdoneo(datiRapProvaWebGt.getS3aFlgLocaleIntIdoneo());
		rappIspezGt.setS3bFlgGenExtIdoneo(datiRapProvaWebGt.getS3bFlgGenExtIdoneo());
		rappIspezGt.setS3cFlgVentilazSuff(datiRapProvaWebGt.getS3cFlgVentilazSuff());
		rappIspezGt.setS3dFlgEvacFumiIdoneo(datiRapProvaWebGt.getS3dFlgEvacFumiIdoneo());
		rappIspezGt.setS3eFlgCartelliPresenti(datiRapProvaWebGt.getS3eFlgCartelliPresenti());
		rappIspezGt.setS3fFlgEstinzPresenti(datiRapProvaWebGt.getS3fFlgEstinzPresenti());
		rappIspezGt.setS3gFlgInterrGenPresenti(datiRapProvaWebGt.getS3gFlgInterrGenPresenti());
		rappIspezGt.setS3hFlgRubinPresente(datiRapProvaWebGt.getS3hFlgRubinPresente());
		rappIspezGt.setS3iFlgAssenzaPerdComb(datiRapProvaWebGt.getS3iFlgAssenzaPerdComb());
		rappIspezGt.setS3jFlgTempAmbFunz(datiRapProvaWebGt.getS3jFlgTempAmbFunz());
		rappIspezGt.setS3kFlgDm1121975(datiRapProvaWebGt.getS3kFlgDm1121975());
		rappIspezGt.setS4aFlgLibImpPresente(datiRapProvaWebGt.getS4aFlgLibImpPresente());
		rappIspezGt.setS4bFlgLibCompilato(datiRapProvaWebGt.getS4bFlgLibCompilato());
		rappIspezGt.setS4cFlgConformitaPresente(datiRapProvaWebGt.getS4cFlgConformitaPresente());
		rappIspezGt.setS4dFlgLibUsoPresente(datiRapProvaWebGt.getS4dFlgLibUsoPresente());
		rappIspezGt.setS4eFlgPraticaVvfPresente(datiRapProvaWebGt.getS4eFlgPraticaVvfPresente());
		rappIspezGt.setS4fFlgPraticaInailPresente(datiRapProvaWebGt.getS4fFlgPraticaInailPresente());
		rappIspezGt.setS4gFlgDm121975(datiRapProvaWebGt.getS4gFlgDm121975());
		rappIspezGt.setS4gMatricolaDm1121975(datiRapProvaWebGt.getS4gMatricolaDm1121975());
		rappIspezGt.setS5aFlgAdozioneValvoleTerm(datiRapProvaWebGt.getS5aFlgAdozioneValvoleTerm());
		rappIspezGt.setS5aFlgIsolamenteRete(datiRapProvaWebGt.getS5aFlgIsolamenteRete());
		rappIspezGt.setS5aFlgAdozSistTrattam_h2o(datiRapProvaWebGt.getS5aFlgAdozSistTrattamH2o());
		rappIspezGt.setS5aFlgSostituzSistRegolaz(datiRapProvaWebGt.getS5aFlgSostituzSistRegolaz());
		rappIspezGt.setS5bFlgNoIntervConv(datiRapProvaWebGt.getS5bFlgNoIntervConv());
		rappIspezGt.setS5bFlgRelazDettaglio(datiRapProvaWebGt.getS5bFlgRelazDettaglio());
		rappIspezGt.setS5bFlgRelazDettaglioSucc(datiRapProvaWebGt.getS5bFlgRelazDettaglioSucc());
		rappIspezGt.setS5bFlgValutazNonEseguita(datiRapProvaWebGt.getS5bFlgValutazNonEseguita());
		rappIspezGt.setS5bMotivoRelazNonEseg(datiRapProvaWebGt.getS5bMotivoRelazNonEseg());
		rappIspezGt.setS5cFlgDimensCorretto(datiRapProvaWebGt.getS5cFlgDimensCorretto());
		rappIspezGt.setS5cFlgDimensNonCorretto(datiRapProvaWebGt.getS5cFlgDimensNonCorretto());
		rappIspezGt.setS5cFlgDimensNonControll(datiRapProvaWebGt.getS5cFlgDimensNonControll());
		rappIspezGt.setS5cFlgDimensRelazSucces(datiRapProvaWebGt.getS5cFlgDimensRelazSucces());
		rappIspezGt.setDataUltMod(Timestamp.from(Instant.now()));
		rappIspezGt.setUtenteUltMod(utenteLoggato.getPfLoggato().getCodiceFiscalePF());

		return rappIspezGt;
	}

	private SigitTDettIspezGtDto datiRapProvaWebGtToDettIspezGt(BigDecimal idAllegato, BigDecimal codiceImpianto, DatiRapProvaWebGt datiRapProvaWebGt, Modulo modulo, UtenteLoggato utenteLoggato) {
		java.sql.Date s7aDataUltimaManut = datiRapProvaWebGt.getS7aDataUltimaManut() != null
				? new java.sql.Date(datiRapProvaWebGt.getS7aDataUltimaManut())
				: null;
		java.sql.Date s7bDataRee = datiRapProvaWebGt.getS7bDataRee() != null
				? new java.sql.Date(datiRapProvaWebGt.getS7bDataRee())
				: null;

		SigitTDettIspezGtDto dettIspezGt = new SigitTDettIspezGtDto();
		dettIspezGt.setFkAllegato(idAllegato);
		dettIspezGt.setFkTipoComponente(Constants.TIPO_COMPONENTE_GT);
		dettIspezGt.setCodiceImpianto(codiceImpianto);
		dettIspezGt.setProgressivo(new BigDecimal(datiRapProvaWebGt.getProgressivo()));
		dettIspezGt.setDataInstall(new java.sql.Date(datiRapProvaWebGt.getDataInstall()));
		dettIspezGt.setS6dFlgEvacuFumi(datiRapProvaWebGt.getS6dFlgEvacuFumi());
		dettIspezGt.setS6iFlgTipoB(datiRapProvaWebGt.getS6iFlgTipoB());
		dettIspezGt.setS6iFlgTipoC(datiRapProvaWebGt.getS6iFlgTipoC());
		dettIspezGt.setS6jFkClassDpr66096(datiRapProvaWebGt.getS6jFkClassDpr66096());
		dettIspezGt.setS6kPotTermFocolKw(datiRapProvaWebGt.getS6kPotTermFocolKw());
		dettIspezGt.setS6kBruciatoreDaKw(datiRapProvaWebGt.getS6kBruciatoreDaKw());
		dettIspezGt.setS6kBruciatoreAKw(datiRapProvaWebGt.getS6kBruciatoreAKw());
		dettIspezGt.setS6lPortataCombM3H(datiRapProvaWebGt.getS6lPortataCombM3H());
		dettIspezGt.setS6lPortataCombKgH(datiRapProvaWebGt.getS6lPortataCombKgH());
		dettIspezGt.setS6lPotTermFocolKw(datiRapProvaWebGt.getS6lPotTermFocolKw());
		dettIspezGt.setS7aFkFrequenzaManut(datiRapProvaWebGt.getS7aFkFrequenzaManut());
		dettIspezGt.setS7aFrequenzaManutAltro(datiRapProvaWebGt.getS7aFrequenzaManutAltro());
		dettIspezGt.setS7aFlgManutEffettuata(datiRapProvaWebGt.getS7aFlgManutEffettuata());
		dettIspezGt.setS7aDataUltimaManut(s7aDataUltimaManut);
		dettIspezGt.setS7bFlgReePresente(datiRapProvaWebGt.getS7bFlgReePresente());
		dettIspezGt.setS7bDataRee(s7bDataRee);
		dettIspezGt.setS7bFlgOsservazioni(datiRapProvaWebGt.getS7bFlgOsservazioni());
		dettIspezGt.setS7bFlgRaccomand(datiRapProvaWebGt.getS7bFlgRaccomand());
		dettIspezGt.setS7bFlgPrescr(datiRapProvaWebGt.getS7bFlgPrescr());
		dettIspezGt.setS8aNModuloTermico(modulo.getS8aNModuloTermico());
		dettIspezGt.setS8bFumoMis1(modulo.getS8bFumoMis1());
		dettIspezGt.setS8bFumoMis2(modulo.getS8bFumoMis2());
		dettIspezGt.setS8bFumoMis3(modulo.getS8bFumoMis3());
		dettIspezGt.setS8cMarcaStrumMisura(modulo.getS8cMarcaStrumMisura());
		dettIspezGt.setS8cModelloStrumMisura(modulo.getS8cModelloStrumMisura());
		dettIspezGt.setS8cMatricolaStrumMisura(modulo.getS8cMatricolaStrumMisura());
		dettIspezGt.setS8dTempFluidoMandataC(modulo.getS8dTempFluidoMandataC());
		dettIspezGt.setS8dTempAriaC(modulo.getS8dTempAriaC());
		dettIspezGt.setS8dTempFumiC(modulo.getS8dTempFumiC());
		dettIspezGt.setS8dO2Perc(modulo.getS8dO2Perc());
		dettIspezGt.setS8dCo2Perc(modulo.getS8dCo2Perc());
		dettIspezGt.setS8dCoFumiSecchiPpm(modulo.getS8dCoFumiSecchiPpm());
		dettIspezGt.setS8dNoMgKwH(modulo.getS8dNoMgKwH());
		dettIspezGt.setS8eIndiceAria(modulo.getS8eIndiceAria());
		dettIspezGt.setS8eFumiSecchiNoAriaPpm(modulo.getS8eFumiSecchiNoAriaPpm());
		dettIspezGt.setS8eQsPerc(modulo.getS8eQsPerc());
		dettIspezGt.setS8eEtPerc(modulo.getS8eEtPerc());
		dettIspezGt.setS8eRendCombPerc(modulo.getS8eRendCombPerc());
		dettIspezGt.setS8eNoxMgKwH(modulo.getS8eNoxMgKwH());
		dettIspezGt.setS9aFlgMonossidoCarb(modulo.getS9aFlgMonossidoCarb());
		/* COME ERA PRIMA
		if (modulo.getS8eFumiSecchiNoAriaPpm() != null
				&& modulo.getS8eFumiSecchiNoAriaPpm() != null
				&& modulo.getS8eFumiSecchiNoAriaPpm().compareTo(new BigDecimal(1000)) <= 0) {
			dettIspezGt.setS9aFlgMonossidoCarb("R");
		} else {
			dettIspezGt.setS9aFlgMonossidoCarb("I");
		} */
		dettIspezGt.setS9bFlgFumosita(modulo.getS9bFlgFumosita());
		dettIspezGt.setS9cRendMinCombustPerc(modulo.getS9cRendMinCombustPerc());
		dettIspezGt.setS9cFlgRendCombustSuff(modulo.getS9cFlgRendCombustSuff());
		dettIspezGt.setS9dOssidiAzotoLimMgKwH(modulo.getS9dOssidiAzotoLimMgKwH());
		dettIspezGt.setS9dFlgOssidiAzoto(modulo.getS9dFlgOssidiAzoto());
		dettIspezGt.setS9eFlgRispettoNormativa(modulo.getS9eFlgRispettoNormativa());
		dettIspezGt.setS9eFlgNoRispetto7a(modulo.getS9eFlgNoRispetto7a());
		dettIspezGt.setS9eFlgNoRispetto7b(modulo.getS9eFlgNoRispetto7b());
		dettIspezGt.setS9eFlgNoRispetto9a(modulo.getS9eFlgNoRispetto9a());
		dettIspezGt.setS9eFlgNoRispetto9b(modulo.getS9eFlgNoRispetto9b());
		dettIspezGt.setS9eFlgNoRispetto9c(modulo.getS9eFlgNoRispetto9c());
		dettIspezGt.setS9eFlgNoRispetto9d(modulo.getS9eFlgNoRispetto9d());
		dettIspezGt.setDataUltMod(Timestamp.from(Instant.now()));
		dettIspezGt.setUtenteUltMod(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
		dettIspezGt.setControlloWeb(Timestamp.from(Instant.now()));

		return dettIspezGt;
	}

	private SigitTRappIspezGfDto datiRapProvaWebGfToRappIspezGf(BigDecimal idAllegato, DatiRapProvaWebGf datiRapProvaWebGf, UtenteLoggato utenteLoggato) {
		java.sql.Date s1cDataRee = datiRapProvaWebGf.getS1cDataRee() != null
				? new java.sql.Date(datiRapProvaWebGf.getS1cDataRee())
				: null;
		java.sql.Date s1eDtPrimaInstallazione = datiRapProvaWebGf.getS1eDtPrimaInstallazione() != null
				? new java.sql.Date(datiRapProvaWebGf.getS1eDtPrimaInstallazione())
				: null;

		SigitTRappIspezGfPk rappIspezGfPk = new SigitTRappIspezGfPk();
		rappIspezGfPk.setIdAllegato(idAllegato);

		SigitTRappIspezGfDto rappIspezGf = new SigitTRappIspezGfDto();
		rappIspezGf.setSigitTRappIspezGfPk(rappIspezGfPk);
		rappIspezGf.setS1cFlgReeInviato(datiRapProvaWebGf.getS1cFlgReeInviato());
		rappIspezGf.setS1cFlgReeBollino(datiRapProvaWebGf.getS1cFlgReeBollino());
		rappIspezGf.setS1cSiglaBollino(datiRapProvaWebGf.getS1cSiglaBollino());
		rappIspezGf.setS1cNumBollino(datiRapProvaWebGf.getS1cNumBollino());
		rappIspezGf.setS1cDataRee(s1cDataRee);
		rappIspezGf.setS1eDtPrimaInstallazione(s1eDtPrimaInstallazione);
		rappIspezGf.setS1ePotTermicaMaxKw(datiRapProvaWebGf.getS1ePotTermicaMaxKw());
		rappIspezGf.setS1lDenomDelegato(datiRapProvaWebGf.getS1lDenomDelegato());
		rappIspezGf.setS1lFlgDelega(datiRapProvaWebGf.getS1lFlgDelega());
		rappIspezGf.setS2eFlgTrattH2oNonRich(datiRapProvaWebGf.getS2eFlgTrattH2oNonRich());
		rappIspezGf.setS3aFlgLocaleIntIdoneo(datiRapProvaWebGf.getS3aFlgLocaleIntIdoneo());
		rappIspezGf.setS3bFlgLineeElettrIdonee(datiRapProvaWebGf.getS3bFlgLineeElettrIdonee());
		rappIspezGf.setS3cFlgVentilazAdeguate(datiRapProvaWebGf.getS3cFlgVentilazAdeguate());
		rappIspezGf.setS3dFlgCoibentazioniIdonee(datiRapProvaWebGf.getS3dFlgCoibentazioniIdonee());
		rappIspezGf.setS4aFlgLibImpPresente(datiRapProvaWebGf.getS4aFlgLibImpPresente());
		rappIspezGf.setS4bFlgLibCompilato(datiRapProvaWebGf.getS4bFlgLibCompilato());
		rappIspezGf.setS4cFlgConformitaPresente(datiRapProvaWebGf.getS4cFlgConformitaPresente());
		rappIspezGf.setS4dFlgLibUsoPresente(datiRapProvaWebGf.getS4dFlgLibUsoPresente());
		rappIspezGf.setS5aFlgSostituzMacchineReg(datiRapProvaWebGf.getS5aFlgSostituzMacchineReg());
		rappIspezGf.setS5aFlgSostituzSistemiReg(datiRapProvaWebGf.getS5aFlgSostituzSistemiReg());
		rappIspezGf.setS5aFlgIsolamReteDistrib(datiRapProvaWebGf.getS5aFlgIsolamReteDistrib());
		rappIspezGf.setS5aFlgIsolamCanaliDistrib(datiRapProvaWebGf.getS5aFlgIsolamCanaliDistrib());
		rappIspezGf.setS5bFlgNoIntervConv(datiRapProvaWebGf.getS5bFlgNoIntervConv());
		rappIspezGf.setS5bFlgRelazDettaglio(datiRapProvaWebGf.getS5bFlgRelazDettaglio());
		rappIspezGf.setS5bFlgRelazDettaglioSucc(datiRapProvaWebGf.getS5bFlgRelazDettaglioSucc());
		rappIspezGf.setS5bFlgValutazNonEseguita(datiRapProvaWebGf.getS5bFlgValutazNonEseguita());
		rappIspezGf.setS5bMotivoRelazNonEseg(datiRapProvaWebGf.getS5bMotivoRelazNonEseg());
		rappIspezGf.setS5cFlgDimensCorretto(datiRapProvaWebGf.getS5cFlgDimensCorretto());
		rappIspezGf.setS5cFlgDimensNonCorretto(datiRapProvaWebGf.getS5cFlgDimensNonCorretto());
		rappIspezGf.setS5cFlgDimensNonControll(datiRapProvaWebGf.getS5cFlgDimensNonControll());
		rappIspezGf.setS5cFlgDimensRelazSucces(datiRapProvaWebGf.getS5cFlgDimensRelazSucces());
		rappIspezGf.setDataUltMod(Timestamp.from(Instant.now()));
		rappIspezGf.setUtenteUltMod(utenteLoggato.getPfLoggato().getCodiceFiscalePF());

		return rappIspezGf;
	}

	private SigitTDettIspezGfDto datiRapProvaWebGfToDettIspezGf(BigDecimal idAllegato, BigDecimal codiceImpianto, DatiRapProvaWebGf datiRapProvaWebGf, Circuito circuito, UtenteLoggato utenteLoggato) {
		java.sql.Date s7aDataUltimaManut = datiRapProvaWebGf.getS7aDataUltimaManut() != null
				? new java.sql.Date(datiRapProvaWebGf.getS7aDataUltimaManut())
				: null;
		java.sql.Date s7cDataRee = datiRapProvaWebGf.getS7cDataRee() != null
				? new java.sql.Date(datiRapProvaWebGf.getS7cDataRee())
				: null;

		SigitTDettIspezGfDto dettIspezGf = new SigitTDettIspezGfDto();
		dettIspezGf.setFkAllegato(idAllegato);
		dettIspezGf.setFkTipoComponente(Constants.TIPO_COMPONENTE_GF);
		dettIspezGf.setCodiceImpianto(codiceImpianto);
		dettIspezGf.setProgressivo(new BigDecimal(datiRapProvaWebGf.getProgressivo()));
		dettIspezGf.setDataInstall(new java.sql.Date(datiRapProvaWebGf.getDataInstall()));
		dettIspezGf.setS6hFlgInverter(datiRapProvaWebGf.getS6hFlgInverter());
		dettIspezGf.setS6nFlgFugaDiretta(datiRapProvaWebGf.getS6nFlgFugaDiretta());
		dettIspezGf.setS6nFlgFugaIndiretta(datiRapProvaWebGf.getS6nFlgFugaIndiretta());
		dettIspezGf.setS7aFkFrequenzaManut(datiRapProvaWebGf.getS7aFkFrequenzaManut());
		dettIspezGf.setS7aFrequenzaManutAltro(datiRapProvaWebGf.getS7aFrequenzaManutaltro());
		dettIspezGf.setS7aFlgManutEffettuata(datiRapProvaWebGf.getS7aFlgManutEffettuata());
		dettIspezGf.setS7aDataUltimaManut(s7aDataUltimaManut);
		dettIspezGf.setS7bFlgRegistroApparecc(datiRapProvaWebGf.getS7bFlgRegistroApparecc());
		dettIspezGf.setS7cFlgReePresente(datiRapProvaWebGf.getS7cFlgReePresente());
		dettIspezGf.setS7cDataRee(s7cDataRee);
		dettIspezGf.setS7cFlgOsservazioni(datiRapProvaWebGf.getS7cFlgOsservazioni());
		dettIspezGf.setS7cFlgRaccomand(datiRapProvaWebGf.getS7cFlgRaccomand());
		dettIspezGf.setS7cFlgPrescr(datiRapProvaWebGf.getS7cFlgPrescr());
		dettIspezGf.setS8aNCircuito(circuito.getS8aNCircuito());
		dettIspezGf.setS8bFlgProveRaffrescamento(circuito.getS8bFlgProveRaffrescamento());
		dettIspezGf.setS8bFlgProveRiscaldamento(circuito.getS8bFlgProveRiscaldamento());
		dettIspezGf.setS8cFlgFiltriPuliti(circuito.getS8cFlgFiltriPuliti());
		dettIspezGf.setS8dFlgAssenzaPerditeGas(circuito.getS8dFlgAssenzaPerditeGas());
		dettIspezGf.setS8eMarcaStrumMisura(circuito.getS8eMarcaStrumMisura());
		dettIspezGf.setS8eModelloStrumMisura(circuito.getS8eModelloStrumMisura());
		dettIspezGf.setS8eMatricolaStrumMisura(circuito.getS8eMatricolaStrumMisura());
		dettIspezGf.setS8fPotAssorbitaKw(circuito.getS8fPotAssorbitaKw());
		dettIspezGf.setS8gFlgStrumentazioneFissa(circuito.getS8gFlgStrumentazioneFissa());
		dettIspezGf.setS8hOperatoreDenominazione(circuito.getS8hOperatoreDenominazione());
		dettIspezGf.setS8iOperatoreNumIscriz(circuito.getS8iOperatoreNumIscriz());
		dettIspezGf.setS8jSurriscaldamentoK(circuito.getS8jSurriscaldamentoK()); 
		dettIspezGf.setS8jSottoraffreddamentoK(circuito.getS8jSottoraffreddamentoK());
		dettIspezGf.setS8jTempCondensazioneC(circuito.getS8jTempCondensazioneC());
		dettIspezGf.setS8jTempEvaporazioneC(circuito.getS8jTempEvaporazioneC());
		dettIspezGf.setS8jTempSorgIngressoC(circuito.getS8jTempSorgIngressoC());
		dettIspezGf.setS8jTempSorgUscitaC(circuito.getS8jTempSorgUscitaC());
		dettIspezGf.setS8jTempIngressoFluidoC(circuito.getS8jTempIngressoFluidoC());
		dettIspezGf.setS8jTempUscitaFluidoC(circuito.getS8jTempUscitaFluidoC());
		dettIspezGf.setS9aFlgVerificaSuperata(circuito.getS9aFlgVerificaSuperata());
		dettIspezGf.setS9bFlgRispettoNormativa(circuito.getS9bFlgRispettoNormativa());
		dettIspezGf.setS9cFlgNoRispetto7a(circuito.getS9cFlgNoRispetto7a());
		dettIspezGf.setS9cFlgNoRispetto7b(circuito.getS9cFlgNoRispetto7b());
		dettIspezGf.setS9cFlgNoRispetto8d(circuito.getS9cFlgNoRispetto8d());
		dettIspezGf.setS9cFlgNoRispetto9a(circuito.getS9cFlgNoRispetto9a());
		dettIspezGf.setDataUltMod(Timestamp.from(Instant.now()));
		dettIspezGf.setUtenteUltMod(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
		dettIspezGf.setControlloWeb(Timestamp.from(Instant.now()));

		return dettIspezGf;
	}

	@Transactional(rollbackFor = Exception.class)
	public Esito setRapProvaWeb(RapProvaWeb rapProvaWeb) throws Exception {
		Boolean isAllegatoGT;
		Boolean isUploadScansione = false;

		DatiRapProva datiRapProva = rapProvaWeb.getDatiRapProva();

		validateDatiRapProva(datiRapProva);
		checkResponsabile(datiRapProva.getCodiceImpianto(), datiRapProva.getDataControllo());

		SigitTAllegatoDto allegato = rapProvaWebToAllegato(rapProvaWeb);
		

		if (allegato.getIdAllegato() != null) {
			dbServiceImp.getSigitTAllegatoDao().update(allegato);
		} else {
			dbServiceImp.getSigitTAllegatoDao().insert(allegato);

			if (rapProvaWeb.getDatiRapProvaWebGt() != null) {
				SigitRAllegatoCompGtDto allegatoCompGt = datiRapProvaWebGtToAllegatoCompGt(allegato.getIdAllegato(),
						datiRapProva.getCodiceImpianto(), rapProvaWeb.getDatiRapProvaWebGt());
	
				dbServiceImp.getSigitRAllegatoCompGtDao().insert(allegatoCompGt);
			} else {
				SigitRAllegatoCompGfDto allegatoCompGf = datiRapProvaWebGfToAllegatoCompGf(allegato.getIdAllegato(),
						datiRapProva.getCodiceImpianto(), rapProvaWeb.getDatiRapProvaWebGf());

				dbServiceImp.getSigitRAllegatoCompGfDao().insert(allegatoCompGf);
			}
		}

		if (rapProvaWeb.getDatiRapProvaWebGt() != null) {
			isAllegatoGT = true;
			
			DatiRapProvaWebGt datiRapProvaWebGt = rapProvaWeb.getDatiRapProvaWebGt();

			SigitTRappIspezGtDto rappIspezGt = datiRapProvaWebGtToRappIspezGt(allegato.getIdAllegato(), datiRapProvaWebGt, rapProvaWeb.getUtenteLoggato());

			dbServiceImp.getSigitTRappIspezGtDao().delete(allegato.getIdAllegato());
			dbServiceImp.getSigitTRappIspezGtDao().insert(rappIspezGt);

			dbServiceImp.getSigitTDettIspezGtDao().delete(allegato.getIdAllegato());

			for (Modulo modulo : datiRapProvaWebGt.getModuli()) {
				SigitTDettIspezGtDto dettIspezGt = datiRapProvaWebGtToDettIspezGt(allegato.getIdAllegato(),
						datiRapProva.getCodiceImpianto(), datiRapProvaWebGt, modulo, rapProvaWeb.getUtenteLoggato());

				dbServiceImp.getSigitTDettIspezGtDao().insert(dettIspezGt);
			}
		} else {
			isAllegatoGT = false;
			
			DatiRapProvaWebGf datiRapProvaWebGf = rapProvaWeb.getDatiRapProvaWebGf();

			SigitTRappIspezGfDto rappIspezGf = datiRapProvaWebGfToRappIspezGf(allegato.getIdAllegato(), datiRapProvaWebGf, rapProvaWeb.getUtenteLoggato());

			dbServiceImp.getSigitTRappIspezGfDao().delete(allegato.getIdAllegato());
			dbServiceImp.getSigitTRappIspezGfDao().insert(rappIspezGf);

			dbServiceImp.getSigitTDettIspezGfDao().delete(allegato.getIdAllegato());

			for (Circuito circuito : datiRapProvaWebGf.getCircuiti()) {
				SigitTDettIspezGfDto dettIspezGf = datiRapProvaWebGfToDettIspezGf(allegato.getIdAllegato(),
						datiRapProva.getCodiceImpianto(), datiRapProvaWebGf, circuito, rapProvaWeb.getUtenteLoggato());

				dbServiceImp.getSigitTDettIspezGfDao().insert(dettIspezGf);
			}
		}
		
		return inviaRapProva(allegato.getIdAllegato(), datiRapProva.getCodiceImpianto(), rapProvaWeb.getUtenteLoggato(), isAllegatoGT, isUploadScansione);

	}

	private void checkDimensioneFile(byte[] bytes) throws Exception {
		List<SigitWrkConfigDto> configList = dbServiceImp.getSigitWrkConfigDao().findByChiaveConfig(Constants.MAX_MB_DOC);

		if (!configList.isEmpty()) {
			BigDecimal max = configList.get(0).getValoreConfigNum();

			if (max != null && bytes.length / 1000000 > max.intValue()) {
				throw new Exception(String.format("Il file supera la dimensione massima di %.0f MB", max));
			}
		}
	}

	@Transactional
	public Esito setScansioneRapProva(RapProvaWeb rapProvaWeb) throws Exception {
		Boolean isAllegatoGT;
		Boolean isUploadScansione = true;
		
		DatiRapProva datiRapProva = rapProvaWeb.getDatiRapProva();

		validateDatiRapProva(datiRapProva);
		checkResponsabile(datiRapProva.getCodiceImpianto(), datiRapProva.getDataControllo());

		SigitTAllegatoDto allegato = rapProvaWebToAllegato(rapProvaWeb);

		dbServiceImp.getSigitTAllegatoDao().insert(allegato);

		if (rapProvaWeb.getDatiRapProvaWebGt() != null) {
			SigitRAllegatoCompGtDto allegatoCompGt = datiRapProvaWebGtToAllegatoCompGt(allegato.getIdAllegato(),
					datiRapProva.getCodiceImpianto(), rapProvaWeb.getDatiRapProvaWebGt());

			dbServiceImp.getSigitRAllegatoCompGtDao().insert(allegatoCompGt);
		} else {
			SigitRAllegatoCompGfDto allegatoCompGf = datiRapProvaWebGfToAllegatoCompGf(allegato.getIdAllegato(),
					datiRapProva.getCodiceImpianto(), rapProvaWeb.getDatiRapProvaWebGf());

			dbServiceImp.getSigitRAllegatoCompGfDao().insert(allegatoCompGf);
		}
		

		if (rapProvaWeb.getDatiRapProvaWebGt() != null) {
			isAllegatoGT = true;
			
			DatiRapProvaWebGt datiRapProvaWebGt = rapProvaWeb.getDatiRapProvaWebGt();

			SigitTRappIspezGtDto rappIspezGt = datiRapProvaWebGtToRappIspezGt(allegato.getIdAllegato(), datiRapProvaWebGt, rapProvaWeb.getUtenteLoggato());

			dbServiceImp.getSigitTRappIspezGtDao().insert(rappIspezGt);

			CompFilter filter = new CompFilter(datiRapProva.getCodiceImpianto().intValue(), datiRapProvaWebGt.getProgressivo().toString());
			List<SigitTCompGtCompletoDto> compGtList = dbServiceImp.getSigitTCompGtDao().ricercaComponentiByFiltro(filter);
			int nModuli = compGtList.get(0).getNModuli() != null && compGtList.get(0).getNModuli().intValue() != 0
					? compGtList.get(0).getNModuli().intValue()
					: 1;

			for (int i = 0; i < nModuli; i++) {
				Modulo modulo = new Modulo();
				modulo.setS8aNModuloTermico(Integer.toString(i + 1));

				SigitTDettIspezGtDto dettIspezGt = datiRapProvaWebGtToDettIspezGt(allegato.getIdAllegato(),
						datiRapProva.getCodiceImpianto(), datiRapProvaWebGt, modulo, rapProvaWeb.getUtenteLoggato());

				dbServiceImp.getSigitTDettIspezGtDao().insert(dettIspezGt);
			}
		} else {
			isAllegatoGT = false;
			
			DatiRapProvaWebGf datiRapProvaWebGf = rapProvaWeb.getDatiRapProvaWebGf();

			SigitTRappIspezGfDto rappIspezGf = datiRapProvaWebGfToRappIspezGf(allegato.getIdAllegato(), datiRapProvaWebGf, rapProvaWeb.getUtenteLoggato());

			dbServiceImp.getSigitTRappIspezGfDao().insert(rappIspezGf);

			CompFilter filter = new CompFilter(datiRapProva.getCodiceImpianto().intValue(), datiRapProvaWebGf.getProgressivo().toString());
			List<SigitTCompGfCompletoDto> compGfList = dbServiceImp.getSigitTCompGfDao().ricercaComponentiCompletoByFiltro(filter);
			int nCircuiti = compGfList.get(0).getNCircuiti() != null && compGfList.get(0).getNCircuiti().intValue() != 0
					? compGfList.get(0).getNCircuiti().intValue()
					: 1;

			for (int i = 0; i < nCircuiti; i++) {
				Circuito circuito = new Circuito();
				circuito.setS8aNCircuito(Integer.toString(i + 1));

				SigitTDettIspezGfDto dettIspezGf = datiRapProvaWebGfToDettIspezGf(allegato.getIdAllegato(),
						datiRapProva.getCodiceImpianto(), datiRapProvaWebGf, circuito, rapProvaWeb.getUtenteLoggato());

				dbServiceImp.getSigitTDettIspezGfDao().insert(dettIspezGf);
			}
		}

		SigitTImpiantoDto impianto = dbServiceImp.getSigitTImpiantoDao().findByPrimaryKey(new SigitTImpiantoPk(datiRapProva.getCodiceImpianto()));

		String estensione = StringUtils.getFilenameExtension(rapProvaWeb.getDocName());
		String folder = String.format(FOLDER_TEMPLATE, impianto.getSiglaProvincia(), impianto.getIstatComune(), datiRapProva.getCodiceImpianto());
		String filename = String.format(FILENAME_TEMPLATE, "RAPPROVA", datiRapProva.getCodiceImpianto(), datiRapProva.getDataControllo(),
				allegato.getIdAllegato(), estensione);
		byte[] bytes = Base64.decodeBase64(rapProvaWeb.getDocBase64());

		if (!Constants.ESTENSIONI_SCANSIONE_RAPPROVA.contains(estensione.toLowerCase())) {
			throw new Exception("Estensione del file non consentita");
		}

		checkDimensioneFile(bytes);

		Metadati metadati = buildMetadati(allegato, impianto);

		String uidIndex = serviceManager.indexUploadFileNew(filename, bytes, metadati, folder, true);

		allegato.setNomeAllegato(filename);
		allegato.setUidIndex(uidIndex);

		dbServiceImp.getSigitTAllegatoDao().update(allegato);

		return inviaRapProva(allegato.getIdAllegato(), datiRapProva.getCodiceImpianto(), rapProvaWeb.getUtenteLoggato(), isAllegatoGT, isUploadScansione);
	}

	public FileBase64 getPDFRapProva(Boolean firmato, BigDecimal idAllegato, UtenteLoggato utenteLoggato) throws Exception {
		if (!RUOLI_GET_PDF_RAPPROVA.contains(utenteLoggato.getRuoloLoggato().getRuolo())) {
			throw new Exception("Utente non abilitato");
		}

		SigitTAllegatoDto allegato = dbServiceImp.getSigitTAllegatoDao().findByPrimaryKey(new SigitTAllegatoPk(idAllegato));

		if (BigDecimal.ZERO.equals(allegato.getFkStatoRapp())) {
			throw new Exception("S041"); // TODO: S041 sarebbe a dire? "Stato allegato non coerente"?
		}

		String uidIndex = Boolean.TRUE.equals(firmato) ? allegato.getUidIndexFirmato() : allegato.getUidIndex();
		Documento doc = serviceManager.getDocumentoByUid(uidIndex);
		String base64 = Base64.encodeBase64String(doc.getDoc());

		FileBase64 file = new FileBase64();
		file.setBase64(base64);
		file.setName(doc.getNome());

		return file;
	}
	
	protected OperationContext indexGetOperationContext(String user) {
		String header = "!!!!indexGetOperationContext==>.";
		logger.debug(header + "inizio!!");

		OperationContext ctx = new OperationContext();
		ctx.setUsername(user);
		ctx.setPassword(Constants.INDEX_PSW);
		ctx.setNomeFisico(Constants.INDEX_UTENTE);
		ctx.setFruitore(Constants.INDEX_FRUITORE);
		ctx.setRepository(Constants.INDEX_REPOSITORY);
		logger.debug(header + "fine");

		return ctx;
	}

	@Transactional
	public Esito updatePDFFirmatoRapProva(RapProvaWeb rapProvaWeb) throws Exception {
		DatiRapProva datiRapProva = rapProvaWeb.getDatiRapProva();
		SigitTAllegatoDto allegato = dbServiceImp.getSigitTAllegatoDao().findByPrimaryKey(new SigitTAllegatoPk(datiRapProva.getIdAllegato()));

		if (!BigDecimal.ONE.equals(allegato.getFkStatoRapp())) {
			throw new Exception("Rapprova non in stato INVIATO");
		}

		SigitTImpiantoDto impianto = dbServiceImp.getSigitTImpiantoDao().findByPrimaryKey(new SigitTImpiantoPk(datiRapProva.getCodiceImpianto()));

		String estensione = StringUtils.getFilenameExtension(rapProvaWeb.getDocName());
		String folder = String.format(FOLDER_TEMPLATE, impianto.getSiglaProvincia(), impianto.getIstatComune(), datiRapProva.getCodiceImpianto());
		String filename = String.format(FILENAME_TEMPLATE, "RAPFIRMA", datiRapProva.getCodiceImpianto(), allegato.getDataControllo(),
				allegato.getIdAllegato(), estensione);
		byte[] bytes = Base64.decodeBase64(rapProvaWeb.getDocBase64());

		if (!Constants.ESTENSIONI_RAPPROVA_FIRMATO.contains(estensione.toLowerCase())) {
			throw new Exception("Formato file non accettato");
		}

		checkDimensioneFile(bytes);

		Metadati metadati = buildMetadati(allegato, impianto);

		String uidIndex = serviceManager.indexUploadFileNew(filename, bytes, metadati, folder, true);

		allegato.setDataUltMod(Timestamp.from(Instant.now()));
		allegato.setUtenteUltMod(rapProvaWeb.getUtenteLoggato().getPfLoggato().getCodiceFiscalePF());
		allegato.setNomeAllegatoFirmato(filename);
		allegato.setUidIndexFirmato(uidIndex);

		dbServiceImp.getSigitTAllegatoDao().update(allegato);

		Esito esito = new Esito();
		esito.setEsito("OK");

		return esito;
	}
}
