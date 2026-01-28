package it.csi.sigit.sigitext.business.be.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.DistributoreApi;
import it.csi.sigit.sigitext.business.be.manager.DbServiceImp;
import it.csi.sigit.sigitext.business.be.manager.DistributoreManager;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.ImportDistribFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDatoDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDatoDistribPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDistribByIdPersonaGiuridicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDistribPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLogDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLogDistribPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDatoDistribDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTImportDistribDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTLogDistribDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.dto.sigitext.DatiFornitura;
import it.csi.sigit.sigitext.dto.sigitext.DocXml;
import it.csi.sigit.sigitext.dto.sigitext.Esito;
import it.csi.sigit.sigitext.dto.sigitext.ImportDatiDistributore;
import it.csi.sigit.sigitext.dto.sigitext.LogDatiFornitura;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

public class DistributoreApiServiceImpl implements DistributoreApi {
	
	private DbServiceImp dbServiceImp;
	
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	
	protected NamedParameterJdbcTemplate jdbcTemplate;
	
	public DbServiceImp getDbServiceImp() {
		return dbServiceImp;
	}

	private DistributoreManager getImplDistributoreManager() {
		return (DistributoreManager) SpringApplicationContextHelper.getBean("distributoreManager");
	}

	@Override
	public Response uploadXMLDistributoreJWT(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, String userCf, Integer idPersonaGiuridica, boolean sostituzione, Integer idImportDistrib,
			String jwt, DocXml docXml) {

		try {
			getImplDistributoreManager().uploadXmlDistributoreJWT(userCf, idPersonaGiuridica, sostituzione, idImportDistrib, docXml, jwt);
			return Response.ok(new Esito(Constants.OK, "")).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
    }

	@Override
	public Response preUploadXMLDistributoreJWT(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, String userCf, Integer idPersonaGiuridica, Boolean sostituzione,
			Integer idImportDistrib, String jwt, DocXml docXml) {

		try {
			ImportDistribFilter dataFile = getImplDistributoreManager().preUploadXmlDistributoreJWT(userCf, idPersonaGiuridica, sostituzione, idImportDistrib, docXml, jwt);
			return Response.ok(dataFile).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response postUploadXMLDistributoreJWT(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, Integer idImport, String uidIndex) {

		try {
			getImplDistributoreManager().postUploadXmlDistributoreJWT(idImport, uidIndex);
			return Response.ok(new Esito(Constants.OK, "")).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response annullaAcquisizioneDatoDistributore(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, String codiceFiscale, Integer idImportDistrib) throws SigitTImportDistribDaoException {

		try {
			SigitTImportDistribPk pk = new SigitTImportDistribPk();
			pk.setIdImportDistrib(idImportDistrib);
			
			SigitTImportDistribDto sigitTImportDistrib = getImplDistributoreManager().findByPrimaryKeyByIdImportDistrib(pk);
			
			Timestamp dataInizioElab = sigitTImportDistrib.getDataInizioElab();
	        LocalDateTime dateTime = dataInizioElab.toLocalDateTime();
	        LocalDateTime dateTimePlusOneYear = dateTime.plusYears(1);
	        Timestamp dataInizioElabPlusOne = Timestamp.valueOf(dateTimePlusOneYear);
	        
	        Timestamp sysdate = new Timestamp(System.currentTimeMillis());
			
			if(dataInizioElabPlusOne.before(sysdate)) 
			{
				return Response.status(Response.Status.OK).entity(new Esito(Constants.ERRORE_GESTITO, 
						"Non e' possibile procedere con l'annullamento in quanto il caricamento del "
						+ "dato di partenza e' avvenuto da piu' di un anno")).build();
			} 
			else 
			{
				sigitTImportDistrib.setFkStatoDistrib(5);
				sigitTImportDistrib.setDataAnnullamento(sysdate);
				sigitTImportDistrib.setDataUltMod(sysdate);
				sigitTImportDistrib.setUtenteUltMod(codiceFiscale);
				sigitTImportDistrib.setUtenteCaricamento(codiceFiscale);
				
				getImplDistributoreManager().updateColumnsAnnullaImport(sigitTImportDistrib);
			}
		} 
		catch (SigitTImportDistribDaoException e) {
				LOG.error("errore in annullaAcquisizioneDatoDistributore, SigitTImportDistribDaoException: ", e);
				return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
			} 
		catch (Exception e) {
				LOG.error("errore in annullaAcquisizioneDatoDistributore, Generic Exception: ", e);
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
			}
		
		return Response.ok(new Esito(Constants.OK, "")).build();
	}

	@Override
	public Response setDatiDistributoreSemplificatoJson(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, Integer idPersonaGiuridica, String piva, String cf,
			ImportDatiDistributore importDatiDistributore) {
		
		LOG.info("Start setDatiDistributoreSemplificatoJson");
		LOG.info("idPersonaGiuridica: " +  idPersonaGiuridica);
		LOG.info("piva: " +  piva);
		LOG.info("cf: " +  cf);

		try {
				// Controllo se esiste almeno un dato fornitura
				List<DatiFornitura> forniture = importDatiDistributore.getDatiFornitura();
				if (forniture == null || forniture.isEmpty()) {
				    return Response.status(Response.Status.OK)
				        .entity(new Esito(Constants.ERRORE_GENERICO, "Dati fornitura assenti"))
				        .build();
				}
			
				DatiFornitura datoForn = forniture.get(0);
				
				// MAPPING IN SIGIT_T_IMPORT_DISTRIB_DTO
				SigitTImportDistribDto sigitTimportDistribDto = new SigitTImportDistribDto();
				
				sigitTimportDistribDto.setIdImportDistrib(null); //Autonumerante
				
				if (idPersonaGiuridica != null) {
					sigitTimportDistribDto.setFkPersonaGiuridica(BigDecimal.valueOf(idPersonaGiuridica));}
				
				sigitTimportDistribDto.setFkStatoDistrib(importDatiDistributore.getFk_stato_distrib());

				String dataInizioElabStr = importDatiDistributore.getData_inizio_elab();
				if (dataInizioElabStr != null && !dataInizioElabStr.isEmpty()) {
				    LocalDateTime dataInizioElabLdt = LocalDateTime.parse(dataInizioElabStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
				    sigitTimportDistribDto.setDataInizioElab(Timestamp.valueOf(dataInizioElabLdt));
				}
				
				String dataFineElabStr = importDatiDistributore.getData_fine_elab();
				if (dataFineElabStr != null && !dataFineElabStr.isEmpty()) {
				    LocalDateTime dataFineElabLdt = LocalDateTime.parse(dataFineElabStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
				    sigitTimportDistribDto.setDataFineElab(Timestamp.valueOf(dataFineElabLdt));
				}
				
				sigitTimportDistribDto.setDataAnnullamento(null);
				
				sigitTimportDistribDto.setNomeFileImport("caricamento manuale fornitura " + importDatiDistributore.getDatiFornitura().get(0).getCf_piva());
				
				sigitTimportDistribDto.setUidIndex(null);

				String annoStr = importDatiDistributore.getAnno_riferimento();
				if (annoStr != null && !annoStr.trim().isEmpty()) {
				    BigDecimal annoBD = new BigDecimal(annoStr.trim());
				    sigitTimportDistribDto.setAnnoRiferimento(annoBD);
				}
				
				sigitTimportDistribDto.setDataInvioMailDistrib(null);
				
				String dataInvioMailAssistenzaStr = importDatiDistributore.getData_invio_mail_assistenza();
				if (dataInvioMailAssistenzaStr != null && !dataInvioMailAssistenzaStr.isEmpty()) {
				    LocalDateTime dataInvioMailAssistenzaLdt = LocalDateTime.parse(dataInvioMailAssistenzaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
				    sigitTimportDistribDto.setDataInvioMailAssistenza(Timestamp.valueOf(dataInvioMailAssistenzaLdt));
				}
				
				sigitTimportDistribDto.setTotRecordElaborati(new BigDecimal(1));
				
				sigitTimportDistribDto.setTotRecordScartati(new BigDecimal(0));
				
				String dataUltModStr = importDatiDistributore.getData_ult_mod();
				if (dataUltModStr != null && !dataUltModStr.isEmpty()) {
				    LocalDateTime dataUltModLdt = LocalDateTime.parse(dataUltModStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
				    sigitTimportDistribDto.setDataUltMod(Timestamp.valueOf(dataUltModLdt));
				}
				
				sigitTimportDistribDto.setUtenteUltMod(cf);
				sigitTimportDistribDto.setUtenteCaricamento(cf);
				
				// INSERT IN SIGIT_T_IMPORT_DISTRIB
				SigitTImportDistribPk sigitTImportDistribPk = getImplDistributoreManager().InsertSigitTImportDistribDto(sigitTimportDistribDto);
				
				// MAPPING IN SIGIT_T_DATI_DISTRIB_DTO
				SigitTDatoDistribDto sigitTDatoDistribDto = new SigitTDatoDistribDto();
				
				//Autonumerante 
				sigitTDatoDistribDto.setIdDatoDistrib(null); 
				
				sigitTDatoDistribDto.setFkTipoContratto(datoForn.getFk_tipo_contratto());
				
				//Copia del valore autonumerante sopra, deve essere lo stesso dell'importDistrib
				/*String sql = "SELECT MAX(ID_IMPORT_DISTRIB) FROM SIGIT_T_IMPORT_DISTRIB WHERE FK_PERSONA_GIURIDICA = :ID_PERSONA_GIURIDICA";
				MapSqlParameterSource params = new MapSqlParameterSource();
				params.addValue("ID_PERSONA_GIURIDICA", idPersonaGiuridica);
				Integer idImportDistrib = jdbcTemplate.queryForObject(sql, params, Integer.class);*/
				
				sigitTDatoDistribDto.setFkImportDistrib(sigitTImportDistribPk.getIdImportDistrib());								

				sigitTDatoDistribDto.setFkCategoriaUtil(datoForn.getFk_categoria_util());
				
				Integer fkCombustibileInt = datoForn.getFk_combustibile();
				if (fkCombustibileInt != null) {
				    sigitTDatoDistribDto.setFkCombustibile(BigDecimal.valueOf(fkCombustibileInt));
				}
				
				sigitTDatoDistribDto.setCodiceAssenzaCatast(null);
				
				Integer fkUnitaMisuraInt = datoForn.getFk_unita_misura();
				if (fkUnitaMisuraInt != null) {
				    sigitTDatoDistribDto.setFkUnitaMisura(fkUnitaMisuraInt.toString());
				}
				
				sigitTDatoDistribDto.setFlgPfPg(datoForn.getFlg_pf_pg());
				
				sigitTDatoDistribDto.setCognomeDenom(datoForn.getCognome_denom());
				
				sigitTDatoDistribDto.setNome(datoForn.getNome());
				
				sigitTDatoDistribDto.setCfPiva(datoForn.getCf_piva());
				
				String annoRifStr = datoForn.getAnno_rif();
				if (annoRifStr != null && !annoRifStr.trim().isEmpty()) {
				        BigDecimal annoRif = new BigDecimal(annoRifStr.trim());
				        sigitTDatoDistribDto.setAnnoRif(annoRif);
				    }
				
				sigitTDatoDistribDto.setNrMesiFattur(new BigDecimal(12));
				
				sigitTDatoDistribDto.setDug(datoForn.getDug());
				
				sigitTDatoDistribDto.setIndirizzo(datoForn.getIndirizzo());
				
				sigitTDatoDistribDto.setCivico(datoForn.getCivico());
				
				sigitTDatoDistribDto.setCap(datoForn.getCap());
				
				sigitTDatoDistribDto.setIstatComune(datoForn.getIstat_comune());
				
				sigitTDatoDistribDto.setPodPdr(null);
				
				String consumoAnnoStr = datoForn.getConsumo_anno();
				if (consumoAnnoStr != null && !consumoAnnoStr.trim().isEmpty()) {
				        BigDecimal consumoAnno = new BigDecimal(consumoAnnoStr.trim());
				        sigitTDatoDistribDto.setConsumoAnno(consumoAnno);
				    }
				
				sigitTDatoDistribDto.setConsumoMensile(null);
				
				sigitTDatoDistribDto.setMeseRiferimento(null);
				
				sigitTDatoDistribDto.setConsumoGiornaliero(null);
				
				sigitTDatoDistribDto.setGiornoRiferimento(null);
				
				sigitTDatoDistribDto.setVolumetria(null);
						
				sigitTDatoDistribDto.setFlgPfPgFatt(datoForn.getFlg_pf_pg_fatt());
				
				sigitTDatoDistribDto.setCognomeDenomFatt(datoForn.getCognome_denom_fatt());
				
				sigitTDatoDistribDto.setNomeFatt(datoForn.getNome_fatt());
				
				sigitTDatoDistribDto.setCfPivaFatt(datoForn.getCf_piva_fatt());
				
				sigitTDatoDistribDto.setDugFatt(datoForn.getDug_fatt());
				
				sigitTDatoDistribDto.setIndirizzoFatt(datoForn.getIndirizzo_fatt());
				
				sigitTDatoDistribDto.setCivicoFatt(datoForn.getCivico_fatt());
				
				sigitTDatoDistribDto.setCapFatt(datoForn.getCap_fatt());
				
				sigitTDatoDistribDto.setIstatComuneFatt(datoForn.getIstat_comune_fatt());
				
				sigitTDatoDistribDto.setCodiceImpianto(datoForn.getCodice_impianto());
				
				// INSERT IN SIGIT_T_DATO_DISTRIB
				getImplDistributoreManager().InsertSigitTDatoDistribDto(sigitTDatoDistribDto);
				LOG.info("End setDatiDistributoreSemplificatoJson");
			}
		catch (Exception e) 
			{
				LOG.error("Errore durante l'importazione dati distributore: ", e);
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
			}
		return Response.ok(new Esito(Constants.OK, "")).build();
	}

	/**
	 *  //Il metodo mappa un estrazione, partendo dalla sigitTimportDistribList nella classe importDatiDistribList
		//Passo 1: Ottiene i record dalla tabella sigitTimportDistrib usando come chiave fkImportDistrib
		//Passo 2: Per ogni risultato mappa in importDatiDistribList
		//Passo 3: Per ogni record estratto si cercano i DatiFornitura nella tabella sigitDdatoDistrib usando come chiave fkImportDistrib
		//Passo 4: Per ogni risultato mappa in importDatiDistribList.DatiFornitura[]  
		//Passo 5: Per ogni record estratto si cercano i LogDistrib nella tabella sigitTLogDistrib usando come chiave idDatoDistrib
		//Passo 6: Per ogni risultato mappa in importDatiDistribList.DatiFornitura[].LogDatiFornitura[] 
		//Passo 7: Ritorna i risultati come json
	**/
	@Override
	public Response getDettaglioDatiDistributoreJson(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, Integer idPersonaGiuridica, String anno, String mese,
			String tipoCaricamento, String statoFile)
			throws SigitTImportDistribDaoException, SigitTDatoDistribDaoException, SigitTLogDistribDaoException {
		
			LOG.info("START getDettaglioDatiDistributoreJson");
		try {
			
			List<ImportDatiDistributore> importDatiDistribList = new ArrayList<>();
			//TODO Aggiungere filtro MaxRecord estratti
			//List<SigitTImportDistribByIdPersonaGiuridicaDto> sigitTimportDistribList = getDbServiceImp().getSigitTImportDistribDao().findByIdPersonaGiuridica(idPersonaGiuridica);
			LOG.debug("anno: " + anno);
			LOG.debug("mese: " + mese );
			LOG.debug("tipoCaricamento: " + tipoCaricamento );
			LOG.debug("statoFile: " + statoFile );
			List<SigitTImportDistribByIdPersonaGiuridicaDto> sigitTimportDistribList = getImplDistributoreManager().getImportDitrib(idPersonaGiuridica, anno, mese, tipoCaricamento, statoFile);
			LOG.info("sigitTimportDistribList found! size = " + sigitTimportDistribList.size());
			
			for(int i = 0; i < sigitTimportDistribList.size(); i++)
			{
				//Import dati distributore
				ImportDatiDistributore newImportDatiDistrib = new ImportDatiDistributore();
				
				newImportDatiDistrib.setId_import_distrib(sigitTimportDistribList.get(i).getIdIdImportDistrib());
				newImportDatiDistrib.setFk_persona_giuridica(sigitTimportDistribList.get(i).getFkPersonaGiuridica());
				newImportDatiDistrib.setFk_stato_distrib(sigitTimportDistribList.get(i).getFkStatoDistrib());
				newImportDatiDistrib.setDes_stato_distrib(sigitTimportDistribList.get(i).getSdDesStatoDistrib());
	
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
				Timestamp tsIdDataInizioElab = sigitTimportDistribList.get(i).getIdDataInizioElab();
				if (tsIdDataInizioElab != null) {
				    newImportDatiDistrib.setData_inizio_elab(sdf.format(tsIdDataInizioElab));
				}
				
				Timestamp tsIdDataFineElab = sigitTimportDistribList.get(i).getIdDataFineElab();
				if (tsIdDataFineElab != null) {
				    newImportDatiDistrib.setData_fine_elab(sdf.format(tsIdDataFineElab));
				}
				
				Timestamp tsIdDataAnnullamento = sigitTimportDistribList.get(i).getIdDataAnnullamento();
				if (tsIdDataAnnullamento != null) {
				    newImportDatiDistrib.setData_annullamento(sdf.format(tsIdDataAnnullamento));
				}
				
				newImportDatiDistrib.setNome_file_import(sigitTimportDistribList.get(i).getIdNomeFileImport());
				newImportDatiDistrib.setUid_index(sigitTimportDistribList.get(i).getUidIndex());
				
				if(sigitTimportDistribList.get(i).getIdAnnoRiferimento() != null)
				newImportDatiDistrib.setAnno_riferimento(sigitTimportDistribList.get(i).getIdAnnoRiferimento().toString());
				
				newImportDatiDistrib.setData_invio_mail_distrib(sigitTimportDistribList.get(i).getDataInvioMailDistrib());
				newImportDatiDistrib.setData_invio_mail_assistenza(sigitTimportDistribList.get(i).getDataInvioMailAssistenza());
				
				if(sigitTimportDistribList.get(i).getIdTotRecordElaborati() != null)
				newImportDatiDistrib.setTot_record_elaborati(sigitTimportDistribList.get(i).getIdTotRecordElaborati().intValue());
				
				if(sigitTimportDistribList.get(i).getIdTotRecordScartati() != null)
				newImportDatiDistrib.setTot_record_scartati(sigitTimportDistribList.get(i).getIdTotRecordScartati().intValue());
				
				newImportDatiDistrib.setData_ult_mod(sigitTimportDistribList.get(i).getDataUltMod());
				newImportDatiDistrib.setUtente_ult_mod(sigitTimportDistribList.get(i).getUtenteUltMod());
				newImportDatiDistrib.setUtente_caricamento(sigitTimportDistribList.get(i).getUtenteCaricamento());
				
//				//Dati fornitura
//				SigitTDatoDistribPk sigitTDatoDistribPk = new SigitTDatoDistribPk();
//				sigitTDatoDistribPk.setIdDatoDistrib(sigitTimportDistribList.get(i).getIdIdImportDistrib());
//				List<SigitTDatoDistribDto> sigitTdatoDistribList = getImplDistributoreManager().getDatoDistribList(sigitTDatoDistribPk);
//					
//				List<DatiFornitura> datiFornituraList = new ArrayList<>();
//				
//				if(sigitTdatoDistribList != null) {
//					
//					for(int j = 0; j < sigitTdatoDistribList.size(); j++) {
//						
//						DatiFornitura datiFornitura = new DatiFornitura();
//						
//						datiFornitura.setId_dato_distrib(sigitTdatoDistribList.get(j).getIdDatoDistrib());
//						datiFornitura.setFk_import_distrib(sigitTdatoDistribList.get(j).getFkImportDistrib());
//						
//						if (sigitTdatoDistribList.get(j).getFkCombustibile() != null)
//						datiFornitura.setFk_combustibile(sigitTdatoDistribList.get(j).getFkCombustibile().intValue());
//						//TODO Passare ottenere il valore da be o fe?
//						//datiFornitura.setDes_combustibile(sigitTdatoDistribList.get(j).getFkCombustibile().intValue());
//						
//						if (sigitTdatoDistribList.get(j).getFkUnitaMisura() != null)
//						datiFornitura.setFk_unita_misura(Integer.parseInt(sigitTdatoDistribList.get(j).getFkUnitaMisura()));
//						//TODO Passare ottenere il valore da be o fe?
//						//datiFornitura.setDes_unita_misura(sigitTdatoDistribList.get(j).getFkUnitaMisura());
//						
//						datiFornitura.setFlg_pf_pg(sigitTdatoDistribList.get(j).getFlgPfPg());
//						datiFornitura.setCognome_denom(sigitTdatoDistribList.get(j).getCognomeDenom());
//						datiFornitura.setNome(sigitTdatoDistribList.get(j).getNome());
//						datiFornitura.setCf_piva(sigitTdatoDistribList.get(j).getCfPiva());
//	
//		                if (sigitTdatoDistribList.get(j).getAnnoRif() != null)
//						datiFornitura.setAnno_rif(sigitTdatoDistribList.get(j).getAnnoRif().toString());
//						
//		                if (sigitTdatoDistribList.get(j).getNrMesiFattur() != null)			
//		                datiFornitura.setNr_mesi_fattur(sigitTdatoDistribList.get(j).getNrMesiFattur().intValue());
//						
//		                datiFornitura.setDug(sigitTdatoDistribList.get(j).getDug());
//						datiFornitura.setIndirizzo(sigitTdatoDistribList.get(j).getIndirizzo());
//						datiFornitura.setCivico(sigitTdatoDistribList.get(j).getCivico());
//						datiFornitura.setCap(sigitTdatoDistribList.get(j).getCap());
//						datiFornitura.setIstat_comune(sigitTdatoDistribList.get(j).getIstatComune());
//						datiFornitura.setDes_comune("");
//						
//					    if (sigitTdatoDistribList.get(j).getConsumoAnno() != null)						              
//						datiFornitura.setConsumo_anno(sigitTdatoDistribList.get(j).getConsumoAnno().toString());
//						
//					    datiFornitura.setFlg_pf_pg_fatt(sigitTdatoDistribList.get(j).getFlgPfPgFatt());
//						datiFornitura.setCognome_denom_fatt(sigitTdatoDistribList.get(j).getCognomeDenomFatt());
//						datiFornitura.setNome_fatt(sigitTdatoDistribList.get(j).getNomeFatt());
//						datiFornitura.setCf_piva_fatt(sigitTdatoDistribList.get(j).getCfPivaFatt());
//						datiFornitura.setDug_fatt(sigitTdatoDistribList.get(j).getDugFatt());
//						datiFornitura.setIndirizzo_fatt(sigitTdatoDistribList.get(j).getIndirizzoFatt());
//						datiFornitura.setCivico_fatt(sigitTdatoDistribList.get(j).getCivicoFatt());
//						datiFornitura.setCap_fatt(sigitTdatoDistribList.get(j).getCapFatt());
//						datiFornitura.setIstat_comune_fatt(sigitTdatoDistribList.get(j).getIstatComuneFatt());
//						datiFornitura.setCodice_impianto(sigitTdatoDistribList.get(j).getCodiceImpianto());
//					
//						//log dati fornitura
//						SigitTLogDistribPk sigitTLogDistribPk = new SigitTLogDistribPk();
//						List<SigitTLogDistribDto> sigitTlogDistribList;
//						
//						if(sigitTdatoDistribList.get(j).getIdDatoDistrib() != null && j == 0) {
//							
//							sigitTLogDistribPk.setIdLogDistrib(sigitTdatoDistribList.get(j).getIdDatoDistrib());						
//							sigitTlogDistribList = getImplDistributoreManager().getLogDistribList(sigitTdatoDistribList.get(j).getFkImportDistrib());
//							
//							// rimuovere ciclo, passare id_import_distrib dalla sigit_t_import_distrib
//							List<LogDatiFornitura> logFornituraList = new ArrayList<>();
//							if(sigitTlogDistribList != null) {
//								for(int k = 0; k < sigitTlogDistribList.size(); k++) {
//									LogDatiFornitura logDatiFornitura = new LogDatiFornitura();
//									
//									logDatiFornitura.setId_log_distrib(sigitTlogDistribList.get(k).getIdLogDistrib());
//									logDatiFornitura.setFk_import_distrib(sigitTlogDistribList.get(k).getFkImportDistrib());
//									logDatiFornitura.setMsg_errore(sigitTlogDistribList.get(k).getMsgErrore());
//									
//									logFornituraList.add(logDatiFornitura);
//								}
//								datiFornitura.setLogDatiFornitura(logFornituraList);
//							}
//						}
//					
//					datiFornituraList.add(datiFornitura);
//					}
//				}
//				else {
//					//Dato distrib tutto a null
//					DatiFornitura datiFornitura = new DatiFornitura();
//					
//					datiFornitura.setId_dato_distrib(null);
//					datiFornitura.setFk_import_distrib(null);
//					datiFornitura.setFk_combustibile(null);
//					datiFornitura.setFk_unita_misura(null);
//					datiFornitura.setFlg_pf_pg("");
//					datiFornitura.setCognome_denom("");
//					datiFornitura.setNome("");
//					datiFornitura.setCf_piva("");
//					datiFornitura.setAnno_rif("");	
//	                datiFornitura.setNr_mesi_fattur(null);
//	                datiFornitura.setDug("");
//					datiFornitura.setIndirizzo("");
//					datiFornitura.setCivico("");
//					datiFornitura.setCap("");
//					datiFornitura.setIstat_comune("");
//					datiFornitura.setDes_comune("");					              
//					datiFornitura.setConsumo_anno("");
//				    datiFornitura.setFlg_pf_pg_fatt("");
//					datiFornitura.setCognome_denom_fatt("");
//					datiFornitura.setNome_fatt("");
//					datiFornitura.setCf_piva_fatt("");
//					datiFornitura.setDug_fatt("");
//					datiFornitura.setIndirizzo_fatt("");
//					datiFornitura.setCivico_fatt("");
//					datiFornitura.setCap_fatt("");
//					datiFornitura.setIstat_comune_fatt("");
//					datiFornitura.setCodice_impianto(null);
//					
//					//Ricerca di log distrib comunque
//					SigitTLogDistribPk sigitTLogDistribPk = new SigitTLogDistribPk();
//					List<SigitTLogDistribDto> sigitTlogDistribList;
//					sigitTLogDistribPk.setIdLogDistrib(sigitTimportDistribList.get(i).getIdIdImportDistrib());						
//					sigitTlogDistribList = getImplDistributoreManager().getLogDistribList(sigitTLogDistribPk.getIdLogDistrib());
//					
//					List<LogDatiFornitura> logFornituraList = new ArrayList<>();
//					if(sigitTlogDistribList != null) {
//						for(int k = 0; k < sigitTlogDistribList.size(); k++) {
//							LogDatiFornitura logDatiFornitura = new LogDatiFornitura();
//							
//							logDatiFornitura.setId_log_distrib(sigitTlogDistribList.get(k).getIdLogDistrib());
//							logDatiFornitura.setFk_import_distrib(sigitTlogDistribList.get(k).getFkImportDistrib());
//							logDatiFornitura.setMsg_errore(sigitTlogDistribList.get(k).getMsgErrore());
//							
//							logFornituraList.add(logDatiFornitura);
//						}
//						datiFornitura.setLogDatiFornitura(logFornituraList);
//					}
//					datiFornituraList.add(datiFornitura);
//				}
//				
//				newImportDatiDistrib.setDatiFornitura(datiFornituraList);
				
				//Tipo Caricamento
				if(sigitTimportDistribList.get(i).getUidIndex() != null && 
				   "caricamento manuale".equalsIgnoreCase(sigitTimportDistribList.get(i).getIdNomeFileImport()) == false) 
				{
					newImportDatiDistrib.setTipo_caricamento("Import XML");
				}
				else {
					newImportDatiDistrib.setTipo_caricamento("Manuale");
				}
				
				//Fine
				importDatiDistribList.add(newImportDatiDistrib);
			}
			
			LOG.info("END getDettaglioDatiDistributoreJson");
			return Response.ok(importDatiDistribList).build();
		}
		catch (SigitTImportDistribDaoException e) {
			LOG.error("Errore in getDettaglioDatiDistributoreJson: ", e);
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			LOG.error("Errore generico in getDettaglioDatiDistributoreJson: ", e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override public Response getDettaglioDatiImportJson(SecurityContext securityContext,HttpHeaders httpHeaders,HttpServletRequest httpRequest,Integer idImportDistrib) throws SigitTDatoDistribDaoException,SigitTLogDistribDaoException{// TODO Auto-generated method stub

		try {
			LOG.info("START getDettaglioDatiImportJson");
			LOG.info("idImportDistrib: " + idImportDistrib);
			DatiFornitura datiFornitura = new DatiFornitura();
			
			SigitTDatoDistribPk sigitTDatoDistribPk = new SigitTDatoDistribPk();
			sigitTDatoDistribPk.setIdDatoDistrib(idImportDistrib);
			SigitTDatoDistribDto sigitTdatoDistrib = getImplDistributoreManager().getDatoDistrib(sigitTDatoDistribPk);
			
			if(sigitTdatoDistrib != null) {
			
				datiFornitura.setId_dato_distrib(sigitTdatoDistrib.getIdDatoDistrib());
				datiFornitura.setFk_import_distrib(sigitTdatoDistrib.getFkImportDistrib());
				
				if (sigitTdatoDistrib.getFkCombustibile() != null)
				datiFornitura.setFk_combustibile(sigitTdatoDistrib.getFkCombustibile().intValue());
				//TODO Passare ottenere il valore da be o fe?
				//datiFornitura.setDes_combustibile(sigitTdatoDistrib.getFkCombustibile().intValue());
				
				if (sigitTdatoDistrib.getFkUnitaMisura() != null)
				datiFornitura.setFk_unita_misura(Integer.parseInt(sigitTdatoDistrib.getFkUnitaMisura()));
				//TODO Passare ottenere il valore da be o fe?
				//datiFornitura.setDes_unita_misura(sigitTdatoDistrib.getFkUnitaMisura());
				
				datiFornitura.setFlg_pf_pg(sigitTdatoDistrib.getFlgPfPg());
				datiFornitura.setCognome_denom(sigitTdatoDistrib.getCognomeDenom());
				datiFornitura.setNome(sigitTdatoDistrib.getNome());
				datiFornitura.setCf_piva(sigitTdatoDistrib.getCfPiva());
		
		        if (sigitTdatoDistrib.getAnnoRif() != null)
				datiFornitura.setAnno_rif(sigitTdatoDistrib.getAnnoRif().toString());
				
		        if (sigitTdatoDistrib.getNrMesiFattur() != null)			
		        datiFornitura.setNr_mesi_fattur(sigitTdatoDistrib.getNrMesiFattur().intValue());
				
		        datiFornitura.setDug(sigitTdatoDistrib.getDug());
				datiFornitura.setIndirizzo(sigitTdatoDistrib.getIndirizzo());
				datiFornitura.setCivico(sigitTdatoDistrib.getCivico());
				datiFornitura.setCap(sigitTdatoDistrib.getCap());
				datiFornitura.setIstat_comune(sigitTdatoDistrib.getIstatComune());
				datiFornitura.setDes_comune("");
				
			    if (sigitTdatoDistrib.getConsumoAnno() != null)						              
				datiFornitura.setConsumo_anno(sigitTdatoDistrib.getConsumoAnno().toString());
				
			    datiFornitura.setFlg_pf_pg_fatt(sigitTdatoDistrib.getFlgPfPgFatt());
				datiFornitura.setCognome_denom_fatt(sigitTdatoDistrib.getCognomeDenomFatt());
				datiFornitura.setNome_fatt(sigitTdatoDistrib.getNomeFatt());
				datiFornitura.setCf_piva_fatt(sigitTdatoDistrib.getCfPivaFatt());
				datiFornitura.setDug_fatt(sigitTdatoDistrib.getDugFatt());
				datiFornitura.setIndirizzo_fatt(sigitTdatoDistrib.getIndirizzoFatt());
				datiFornitura.setCivico_fatt(sigitTdatoDistrib.getCivicoFatt());
				datiFornitura.setCap_fatt(sigitTdatoDistrib.getCapFatt());
				datiFornitura.setIstat_comune_fatt(sigitTdatoDistrib.getIstatComuneFatt());
				datiFornitura.setCodice_impianto(sigitTdatoDistrib.getCodiceImpianto());
			
				LOG.info("START ricerca log dati fornitura");
				
				//log dati fornitura
				SigitTLogDistribPk sigitTLogDistribPk = new SigitTLogDistribPk();
				List<SigitTLogDistribDto> sigitTlogDistribList;
				
				if(sigitTdatoDistrib.getIdDatoDistrib() != null) {
					
					sigitTLogDistribPk.setIdLogDistrib(sigitTdatoDistrib.getIdDatoDistrib());						
					sigitTlogDistribList = getImplDistributoreManager().getLogDistribList(sigitTdatoDistrib.getFkImportDistrib());
					
					// rimuovere ciclo, passare id_import_distrib dalla sigit_t_import_distrib
					List<LogDatiFornitura> logFornituraList = new ArrayList<>();
					if(sigitTlogDistribList != null) {
						for(int k = 0; k < sigitTlogDistribList.size(); k++) {
							LogDatiFornitura logDatiFornitura = new LogDatiFornitura();
							
							logDatiFornitura.setId_log_distrib(sigitTlogDistribList.get(k).getIdLogDistrib());
							logDatiFornitura.setFk_import_distrib(sigitTlogDistribList.get(k).getFkImportDistrib());
							logDatiFornitura.setMsg_errore(sigitTlogDistribList.get(k).getMsgErrore());
							
							logFornituraList.add(logDatiFornitura);
						}
						LOG.info("END ricerca log dati fornitura");
						LOG.info("logFornituraList.size" + logFornituraList.size());
						datiFornitura.setLogDatiFornitura(logFornituraList);
					}
				}
			}
			LOG.info("END getDettaglioDatiImportJson");
			return Response.ok(datiFornitura).build();
		}
		catch (SigitTDatoDistribDaoException | SigitTLogDistribDaoException e) {
			LOG.error("Errore in getDettaglioDatiImportJson: ", e);
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			LOG.error("Errore generico in getDettaglioDatiImportJson: ", e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
		
	}

}
