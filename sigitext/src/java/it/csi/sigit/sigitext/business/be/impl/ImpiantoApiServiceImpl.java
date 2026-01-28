package it.csi.sigit.sigitext.business.be.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.log4j.Logger;

import it.csi.csi.wrapper.CSIException;
import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.ImpiantoApi;
import it.csi.sigit.sigitext.business.be.manager.DbServiceImp;
import it.csi.sigit.sigitext.business.be.manager.SigitextManager;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDatoDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDatoDistribPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDistribByIdPersonaGiuridicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLogDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLogDistribPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.MvOdVistaDettaglioImpiantiDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDatoDistribDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTImportDistribDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTLogDistribDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.GenericUtil;
import it.csi.sigit.sigitext.business.util.exceptions.ValidationManagerException;
import it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione;
import it.csi.sigit.sigitext.dto.sigitext.ConsumoPodPdr;
import it.csi.sigit.sigitext.dto.sigitext.DatiFornitura;
import it.csi.sigit.sigitext.dto.sigitext.DatiImpianto;
import it.csi.sigit.sigitext.dto.sigitext.DownloadFileExcelRequest;
import it.csi.sigit.sigitext.dto.sigitext.Esito;
import it.csi.sigit.sigitext.dto.sigitext.Impianto;
import it.csi.sigit.sigitext.dto.sigitext.ImpiantoFiltro;
import it.csi.sigit.sigitext.dto.sigitext.ImportDatiDistributore;
import it.csi.sigit.sigitext.dto.sigitext.ListaImpiantiGeo;
import it.csi.sigit.sigitext.dto.sigitext.LogDatiFornitura;
import it.csi.sigit.sigitext.dto.sigitext.Persona;
import it.csi.sigit.sigitext.dto.sigitext.RespPropModel;
import it.csi.sigit.sigitext.dto.sigitext.SetImpiantoModel;
import it.csi.sigit.sigitext.dto.sigitext.SubentroComponente;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;
import it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

public class ImpiantoApiServiceImpl implements ImpiantoApi {
	
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	
	private DbServiceImp dbServiceImp;
	
	public DbServiceImp getDbServiceImp() {
		return dbServiceImp;
	}
	
	@Override
	public Response getImpiantiByFiltroJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String cf3Responsabile, String cfImpresa, String cfProprietario, String cfResponsabile, String civico, String codiceImpianto, String descComune, String fkStato, String flagVisuProprietario, String idComune, String indirizzo, String istatComune, String numeroRea, String pdr, String pod, String siglaProvincia, String siglaRea, Float x, Float y, Float distanza, String tokenJWT) {
		try {
			ImpiantoFiltro impiantoFiltro = mapParamToImpiantoFiltro(cf3Responsabile, cfImpresa, cfProprietario, cfResponsabile, civico, codiceImpianto, descComune, fkStato, flagVisuProprietario, idComune, indirizzo, istatComune, numeroRea, pdr, pod, siglaProvincia, siglaRea, x, y, distanza);
			Impianto[] impiantoArray = getImplSigitextManager().getImpiantiByFiltroJWT(impiantoFiltro, tokenJWT);
			return Response.ok(impiantoArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getImpiantiGeoByFiltroJWT(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, String cf3Responsabile, String cfImpresa, String cfProprietario,
			String cfResponsabile, String civico, String codiceImpianto, String descComune, String fkStato,
			String flagVisuProprietario, String idComune, String indirizzo, String istatComune, String numeroRea,
			String pdr, String pod, String siglaProvincia, String siglaRea, Float x, Float y, Float distanza,
			String tokenJWT) {
		try {
			ImpiantoFiltro impiantoFiltro = mapParamToImpiantoFiltro(cf3Responsabile, cfImpresa, cfProprietario, cfResponsabile, civico, codiceImpianto, descComune, fkStato, flagVisuProprietario, idComune, indirizzo, istatComune, numeroRea, pdr, pod, siglaProvincia, siglaRea, x, y, distanza);
			ListaImpiantiGeo listaImpiantiGeo = getImplSigitextManager().getImpiantiGeoByFiltroJWT(impiantoFiltro, tokenJWT);
			return Response.ok(listaImpiantiGeo.getFeatureCollection()).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getImpiantiGeoByFiltroDuplicatiResponsabileJWT(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, String cf3Responsabile, String cfImpresa, String cfProprietario,
			String cfResponsabile, String civico, String codiceImpianto, String descComune, String fkStato,
			String flagVisuProprietario, String idComune, String indirizzo, String istatComune, String numeroRea,
			String pdr, String pod, String siglaProvincia, String siglaRea, Float x, Float y, Float distanza,
			String tokenJWT) {
		try {
			ImpiantoFiltro impiantoFiltro = mapParamToImpiantoFiltro(cf3Responsabile, cfImpresa, cfProprietario, cfResponsabile, civico, codiceImpianto, descComune, fkStato, flagVisuProprietario, idComune, indirizzo, istatComune, numeroRea, pdr, pod, siglaProvincia, siglaRea, x, y, distanza);
			ListaImpiantiGeo listaImpiantiGeo = getImplSigitextManager().getImpiantiGeoByFiltroDuplicatiResponsabileJWT(impiantoFiltro, tokenJWT);
			return Response.ok(listaImpiantiGeo.getFeatureCollection()).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	
	private ImpiantoFiltro mapParamToImpiantoFiltro(String cf3Responsabile, String cfImpresa, String cfProprietario, String cfResponsabile, String civico, String codiceImpianto, String descComune, String fkStato, String flagVisuProprietario, String idComune, String indirizzo, String istatComune, String numeroRea, String pdr, String pod, String siglaProvincia, String siglaRea, Float x, Float y, Float distanza) {
		ImpiantoFiltro impiantoFiltro = new ImpiantoFiltro();
		impiantoFiltro.setCf3Responsabile(cf3Responsabile);
		impiantoFiltro.setCfImpresa(cfImpresa);
		impiantoFiltro.setCfProprietario(cfProprietario);
		impiantoFiltro.setCfResponsabile(cfResponsabile);
		impiantoFiltro.setCivico(civico);
		impiantoFiltro.setCodiceImpianto(GenericUtil.isNotNullOrEmpty(codiceImpianto) ? Integer.parseInt(codiceImpianto) : null);
		impiantoFiltro.setDescComune(descComune);
		impiantoFiltro.setFkStato(GenericUtil.isNotNullOrEmpty(fkStato) ? Integer.parseInt(fkStato) : null);
		impiantoFiltro.setFlagVisuProprietario(GenericUtil.isNotNullOrEmpty(flagVisuProprietario) ? Boolean.parseBoolean(flagVisuProprietario) : null);
		impiantoFiltro.setIdComune(idComune);
		impiantoFiltro.setIndirizzo(indirizzo);
		impiantoFiltro.setIstatComune(istatComune);
		impiantoFiltro.setNumeroRea(GenericUtil.isNotNullOrEmpty(numeroRea) ? Integer.parseInt(numeroRea) : null);
		impiantoFiltro.setPdr(pdr);
		impiantoFiltro.setPod(pod);
		impiantoFiltro.setSiglaProvincia(siglaProvincia);
		impiantoFiltro.setSiglaRea(siglaRea);
		impiantoFiltro.setX(x);
		impiantoFiltro.setY(y);
		impiantoFiltro.setDistanza(distanza);
		System.out.println(impiantoFiltro);
		return impiantoFiltro;
	}

	@Override
	public Response getImpiantiGeoByFiltroMaxNumRecords(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		try {
			Integer maxNumImpianti = getImplSigitextManager().getMaxNumImpiantiResults();
			return Response.ok(maxNumImpianti).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getCombustyImpiantiGeoByFiltroMaxNumRecords(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		try {
			Integer maxNumImpianti = getImplSigitextManager().getCombustyMaxNumImpiantiResults();
			return Response.ok(maxNumImpianti).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getImpiantoByCodiceJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, Integer codiceImpianto, String tokenJWT) {
		try {
			Impianto[] impiantoArray = getImplSigitextManager().getImpiantoByCodiceJWT(codiceImpianto, tokenJWT);
			return Response.ok(impiantoArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getImpiantoByPODJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String pod, String tokenJWT) {
		try {
			Impianto[] impiantoArray = getImplSigitextManager().getImpiantoByPODJWT(pod, tokenJWT);
			return Response.ok(impiantoArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getImpiantoByPDRJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String pdr, String tokenJWT) {
		try {
			Impianto[] impiantoArray = getImplSigitextManager().getImpiantoByPDRJWT(pdr, tokenJWT);
			return Response.ok(impiantoArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getImpiantoByIndirizzoJWT(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String indirizzo, Integer civico, String istat, String tokenJWT) {
		try {
			Impianto[] impiantoArray = getImplSigitextManager().getImpiantoByIndirizzoJWT(indirizzo, civico, istat, tokenJWT);
			return Response.ok(impiantoArray).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getStatoImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			CodiceDescrizione[] statiImpianto = getImplSigitextManager().getStatiImpianto();
			return Response.ok(statiImpianto).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response setImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, SetImpiantoModel setImpiantoModel, Integer responsabilita) {
		try {
			Esito esito = getImplSigitextManager().salvaImpianto(setImpiantoModel.getUtenteLoggato(), setImpiantoModel.getDatiImpianto(), responsabilita);
			return Response.ok(esito).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", e.getMessage())).build();
		}
	}

	@Override
	public Response setModificaImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, SetImpiantoModel setImpiantoModel) {
		try {
			Esito esito = getImplSigitextManager().updateImpianto(setImpiantoModel.getUtenteLoggato(), setImpiantoModel.getDatiImpianto());
			return Response.ok(esito).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", "Errore inserimento del nuovo impianto")).build();
		}
	}

	@Override
	public Response getRespProp(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, int tipo, String cf,String siglaRea, String numeroRea) {
		try {
			Persona[] persona = getImplSigitextManager().getRespProp(tipo, cf,siglaRea,numeroRea);
			return Response.ok(persona).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", "Errore inserimento del nuovo impianto")).build();
		}
	}

	@Override
	public Response setNuovoRespProp(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, RespPropModel respPropModel) {
		try {
			Esito esito = getImplSigitextManager().salvaResponsabile(respPropModel);
			return Response.ok(esito).build();
		} catch (ValidationManagerException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito("KO", e.getMsg().getText())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", "Errore inserimento responsabile/proprietario")).build();
		}
	}

	private SigitextManager getImplSigitextManager() {
		return (SigitextManager) SpringApplicationContextHelper.getBean("sigitextManager");
	}

	@Override
	public Response getConsumiByPodPdrJWT(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, String podPdr, String tokenJWT) {
		
		try {
			ConsumoPodPdr[] consumiPodPdrArray = getImplSigitextManager().getConsumiByPodPdrJWT(podPdr,
					tokenJWT);
			return Response.ok(consumiPodPdrArray).build();

		} catch (SigitextException e) {
			return Response.status(Response.Status.UNAUTHORIZED)
					.entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}
	
	@Override
	public Response getComuniPGJWT(String jwt) throws SigitExtDaoException {
		try {
			return Response.ok(getImplSigitextManager().getComuniPGJWT(jwt)).build();
		} catch (SigitExtDaoException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", "Errore consolida libretto")).build();
		}
	}
	
	@Override
	public Response getManutentoriJWT(String denominazione, String comune, String jwt)
			throws SigitExtDaoException {
		try {
			return Response.ok(getImplSigitextManager().getManutentoriJWT(denominazione, comune, jwt)).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (SigitExcessiveResultsException e) {
			return Response.status(507 /* HTTP STATUS: INSUFFICIENT_STORAGE */).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", "Errore consolida libretto")).build();
		}
	}

	@Override
	public Response getCopertinaIspezioneJWT(Integer idIspezione, String jwt) {
		try {
			return Response.ok(getImplSigitextManager().getCopertinaIspezioneJWT(idIspezione, jwt)).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", "Errore consolida libretto")).build();
		}
	}

	@Override
	public Response getLetteraAvvisoJWT(Integer idIspezione, String jwt) {
		try {
			return Response.ok(getImplSigitextManager().getLetteraAvvisoJWT(idIspezione, jwt)).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", "Errore consolida libretto")).build();
		}
	}

	@Override
	public Response getLetteraAvviso180GgJWT(Integer idIspezione, String jwt) {
		try {
			return Response.ok(getImplSigitextManager().getLetteraAvviso180GgJWT(idIspezione, jwt)).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", "Errore consolida libretto")).build();
		}
	}

	@Override
	public Response getFileExcelJWT(DownloadFileExcelRequest downloadFileExcelRequest, String jwt) {
		try {
			return Response.ok(getImplSigitextManager().getFileExcelJWT(downloadFileExcelRequest.getIds(), jwt)).build();
		} catch (SigitextException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito("KO", "Errore consolida libretto")).build();
		}
	}

	@Override
	public Response getComponentiGeoportaleJWT(String coords, String tipoComponente, String tokenJWT) {
		try {
			return Response.ok(getImplSigitextManager().getComponentiGeoportaleJWT(coords, tipoComponente, tokenJWT)).build();
		} catch (MvOdVistaDettaglioImpiantiDaoException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response verifyIndirizzoImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, DatiImpianto datiImpianto, Boolean checkContrattoInEssere) {
		try {
			String response = getImplSigitextManager().verifyIndirizzoImpianto(datiImpianto, checkContrattoInEssere);
			return Response.ok(response).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getElencoStoricoResponsabiliImpianto(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest, String codiceImpianto) {
		try {
			List<Persona> response = getImplSigitextManager().getElencoStoricoResponsabiliImpianto(codiceImpianto);
			return Response.ok(response).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response setSubentroComponente(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, String codiceImpianto, String idPersonaGiuridica, Boolean sendMail,
			SubentroComponente subentro) {
		try {
			String esito = getImplSigitextManager().setSubentroComponente(codiceImpianto, idPersonaGiuridica, sendMail, subentro);
			return Response.ok(new Esito(esito, null)).build();
		} catch (CSIException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

	@Override
	public Response getDettaglioDatiDistributoreJson(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest, UtenteLoggato utenteloggato, Integer idPersonaGiuridica, Integer idImportDistrib, Integer numeroRecords,
			Integer idDatoDistrib, String ordinamento, String filter) throws SigitTImportDistribDaoException, SigitTDatoDistribDaoException, SigitTLogDistribDaoException {
		try {
			LOG.info("[getDettaglioDatiDistributoreJson] START");
			LOG.info("[getDettaglioDatiDistributoreJson] Chiamata ricevuta con idPersonaGiuridica = " + idPersonaGiuridica);
			List<ImportDatiDistributore> importDatiDistribList = new ArrayList<>();
			//TODO Aggiungere filtro MaxRecord estratti
			List<SigitTImportDistribByIdPersonaGiuridicaDto> sigitTimportDistribList = getDbServiceImp().getSigitTImportDistribDao().findByIdPersonaGiuridica(idPersonaGiuridica);
			
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
				
				//Dati fornitura
				SigitTDatoDistribPk sigitTDatoDistribPk = new SigitTDatoDistribPk();
				sigitTDatoDistribPk.setIdDatoDistrib(sigitTimportDistribList.get(i).getIdIdImportDistrib());
				List<SigitTDatoDistribDto> sigitTdatoDistribList = getDbServiceImp().getSigitTDatoDistribDao().findDatiFornitoreByIdImportDistrib(sigitTDatoDistribPk);
					
				List<DatiFornitura> datiFornituraList = new ArrayList<>();
				
				for(int j = 0; j < sigitTdatoDistribList.size(); j++) {
					
					DatiFornitura datiFornitura = new DatiFornitura();
					
					datiFornitura.setId_dato_distrib(sigitTdatoDistribList.get(j).getIdDatoDistrib());
					datiFornitura.setFk_import_distrib(sigitTdatoDistribList.get(j).getFkImportDistrib());
					
					if (sigitTdatoDistribList.get(j).getFkCombustibile() != null)
					datiFornitura.setFk_combustibile(sigitTdatoDistribList.get(j).getFkCombustibile().intValue());
					//TODO Passare ottenere il valore da be o fe?
					//datiFornitura.setDes_combustibile(sigitTdatoDistribList.get(j).getFkCombustibile().intValue());
					
					if (sigitTdatoDistribList.get(j).getFkUnitaMisura() != null)
					datiFornitura.setFk_unita_misura(Integer.parseInt(sigitTdatoDistribList.get(j).getFkUnitaMisura()));
					//TODO Passare ottenere il valore da be o fe?
					//datiFornitura.setDes_unita_misura(sigitTdatoDistribList.get(j).getFkUnitaMisura());
					
					datiFornitura.setFlg_pf_pg(sigitTdatoDistribList.get(j).getFlgPfPg());
					datiFornitura.setCognome_denom(sigitTdatoDistribList.get(j).getCognomeDenom());
					datiFornitura.setNome(sigitTdatoDistribList.get(j).getNome());
					datiFornitura.setCf_piva(sigitTdatoDistribList.get(j).getCfPiva());

	                if (sigitTdatoDistribList.get(j).getAnnoRif() != null)
					datiFornitura.setAnno_rif(sigitTdatoDistribList.get(j).getAnnoRif().toString());
					
	                if (sigitTdatoDistribList.get(j).getNrMesiFattur() != null)			
	                datiFornitura.setNr_mesi_fattur(sigitTdatoDistribList.get(j).getNrMesiFattur().intValue());
					
	                datiFornitura.setDug(sigitTdatoDistribList.get(j).getDug());
					datiFornitura.setIndirizzo(sigitTdatoDistribList.get(j).getIndirizzo());
					datiFornitura.setCivico(sigitTdatoDistribList.get(j).getCivico());
					datiFornitura.setCap(sigitTdatoDistribList.get(j).getCap());
					datiFornitura.setIstat_comune(sigitTdatoDistribList.get(j).getIstatComune());
					datiFornitura.setDes_comune("");
					
				    if (sigitTdatoDistribList.get(j).getConsumoAnno() != null)						              
					datiFornitura.setConsumo_anno(sigitTdatoDistribList.get(j).getConsumoAnno().toString());
					
				    datiFornitura.setFlg_pf_pg_fatt(sigitTdatoDistribList.get(j).getFlgPfPgFatt());
					datiFornitura.setCognome_denom_fatt(sigitTdatoDistribList.get(j).getCognomeDenomFatt());
					datiFornitura.setNome_fatt(sigitTdatoDistribList.get(j).getNomeFatt());
					datiFornitura.setCf_piva_fatt(sigitTdatoDistribList.get(j).getCfPivaFatt());
					datiFornitura.setDug_fatt(sigitTdatoDistribList.get(j).getDugFatt());
					datiFornitura.setIndirizzo_fatt(sigitTdatoDistribList.get(j).getIndirizzoFatt());
					datiFornitura.setCivico_fatt(sigitTdatoDistribList.get(j).getCivicoFatt());
					datiFornitura.setCap_fatt(sigitTdatoDistribList.get(j).getCapFatt());
					datiFornitura.setIstat_comune_fatt(sigitTdatoDistribList.get(j).getIstatComuneFatt());
					datiFornitura.setCodice_impianto(sigitTdatoDistribList.get(j).getCodiceImpianto());
					
					//log dati fornitura
					SigitTLogDistribPk sigitTLogDistribPk = new SigitTLogDistribPk();
					sigitTLogDistribPk.setIdLogDistrib(sigitTdatoDistribList.get(j).getIdDatoDistrib());
					List<SigitTLogDistribDto> sigitTlogDistribList = getDbServiceImp().getSigitTLogDistribDao().findByPrimaryKey(sigitTLogDistribPk);
						
					List<LogDatiFornitura> logFornituraList = new ArrayList<>();
					for(int k = 0; k < sigitTlogDistribList.size(); k++) {
						LogDatiFornitura logDatiFornitura = new LogDatiFornitura();
						
						logDatiFornitura.setId_log_distrib(sigitTlogDistribList.get(k).getIdLogDistrib());
						logDatiFornitura.setFk_import_distrib(sigitTlogDistribList.get(k).getFkImportDistrib());
						logDatiFornitura.setMsg_errore(sigitTlogDistribList.get(k).getMsgErrore());
						
						logFornituraList.add(logDatiFornitura);
					}
					datiFornitura.setLogDatiFornitura(logFornituraList);
					
					datiFornituraList.add(datiFornitura);
				}
				
				newImportDatiDistrib.setDatiFornitura(datiFornituraList);
				
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
			LOG.info("[getDettaglioDatiDistributoreJson] END");
			return Response.ok(importDatiDistribList).build();
		}
		catch (SigitTImportDistribDaoException | SigitTDatoDistribDaoException | SigitTLogDistribDaoException e) {
		    LOG.error("[getDettaglioDatiDistributoreJson] Errore generico", e);
			return Response.status(Response.Status.BAD_REQUEST).entity(new Esito(Constants.ERRORE_GESTITO, e.getMessage())).build();
		} catch (Exception e) {
			LOG.error("[getDettaglioDatiDistributoreJson] Errore generico", e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Esito(Constants.ERRORE_GENERICO, e.getMessage())).build();
		}
	}

}
