package it.csi.citpwa.business.service.impl;

import it.csi.citpwa.business.service.ICitService;
import it.csi.citpwa.business.service.INominaTerzoResponsabileService;
import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.sigitext.DatiAffidamento;
import it.csi.citpwa.model.sigitext.RequestTerzoResponsabile;
import it.csi.citpwa.model.sigitext.ResponseGetDettaglioNomina;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.citpwa.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class NominaTerzoResponsabileServiceImp implements INominaTerzoResponsabileService {
	
	@Autowired
	private ICitService citService;
	
	
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);
	
	@Override
	public ResponseGetDettaglioNomina getDettaglioNomina(Integer idContratto, Integer codiceImpianto) throws SvistaException, IOException  {
		try {
			return citService.getDettaglioNomina(idContratto, codiceImpianto);
		} catch (NotFoundException e) {
			log.error(Constants.NOMINA_TERZO_RESPONSABILE_LOG + "setDocumento - error: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.NOMINA_TERZO_RESPONSABILE_LOG + "setDocumento - error: ", e);
			throw e;
		}
	}
	
	@Override
	public List<Map<Integer, String>> getTipoCessazione() throws SvistaException, IOException {
		try {
			return citService.getTipoCessazione();
		} catch (NotFoundException e) {
			log.error(Constants.NOMINA_TERZO_RESPONSABILE_LOG + "getTipoCessazione - error: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.NOMINA_TERZO_RESPONSABILE_LOG + "getTipoCessazione - error: ", e);
			throw e;
		}
	}
	
	@Override
	public List<Map<Integer, String>> getTipoAutodichiarazione() throws SvistaException, IOException {
		try {
			return citService.getTipoAutodichiarazione();
		} catch (NotFoundException e) {
			log.error(Constants.NOMINA_TERZO_RESPONSABILE_LOG + "getTipoCessazione - error: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.NOMINA_TERZO_RESPONSABILE_LOG + "getTipoCessazione - error: ", e);
			throw e;
		}
	}
	
	@Override
	public String setCessazione(RequestTerzoResponsabile requestTerzoResponsabile) throws SvistaException, IOException {
		try {
			return citService.setCessazione(requestTerzoResponsabile);
		} catch (NotFoundException e) {
			log.error(Constants.NOMINA_TERZO_RESPONSABILE_LOG + "setCessazione - error: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.NOMINA_TERZO_RESPONSABILE_LOG + "setCessazione - error: ", e);
			throw e;
		}
	}
	
	@Override
	public String setProroga(RequestTerzoResponsabile requestTerzoResponsabile) throws SvistaException, IOException {
		try {
			return citService.setProroga(requestTerzoResponsabile);
		} catch (NotFoundException e) {
			log.error(Constants.NOMINA_TERZO_RESPONSABILE_LOG + "setProroga - error: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.NOMINA_TERZO_RESPONSABILE_LOG + "setProroga - error: ", e);
			throw e;
		}
	}
	
	@Override
	public String setSubentrosuImpianto(String codiceFiscale, Integer idPersona, Integer codiceImpianto, String desRuolo, UtenteLoggato utenteLoggato) throws SvistaException, IOException {
		try {
			return citService.setSubentrosuImpianto(codiceFiscale, idPersona, codiceImpianto, desRuolo, utenteLoggato);
		} catch (NotFoundException e) {
			log.error(Constants.NOMINA_TERZO_RESPONSABILE_LOG + "setSubentrosuImpianto - error: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.NOMINA_TERZO_RESPONSABILE_LOG + "setSubentrosuImpianto - error: ", e);
			throw e;
		}
	}
	
	@Override
	public String verifyContrattoTerzoResponsabile(RequestTerzoResponsabile requestVerifyContratto) throws SvistaException, IOException {
		try {
			return citService.verifyContrattoTerzoResponsabile(requestVerifyContratto);
		} catch (NotFoundException e) {
			log.error(Constants.NOMINA_TERZO_RESPONSABILE_LOG + "verifyContrattoTerzoResponsabile - error: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.NOMINA_TERZO_RESPONSABILE_LOG + "verifyContrattoTerzoResponsabile - error: ", e);
			throw e;
		}
	}
	
	@Override
	public String setNuovoTerzoResp(Integer codiceImpianto, RequestTerzoResponsabile request) throws SvistaException, IOException {
		try {
			return citService.setNuovoTerzoResp(codiceImpianto, request);
		} catch (NotFoundException e) {
			log.error(Constants.NOMINA_TERZO_RESPONSABILE_LOG + "verifyContrattoTerzoResponsabile - error: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.NOMINA_TERZO_RESPONSABILE_LOG + "verifyContrattoTerzoResponsabile - error: ", e);
			throw e;
		}
	}
	
	@Override
	public String deleteAffidamento(String codiceFiscale, Integer idPersonaGiuridica, Integer codiceImpianto, DatiAffidamento datiAffidamento) throws SvistaException, IOException {
		try {
			return citService.deleteAffidamento(codiceFiscale, idPersonaGiuridica, codiceImpianto, datiAffidamento);
		} catch (NotFoundException e) {
			log.error(Constants.DOCUMENTO_LOG + "deleteAffidamento - error: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.DOCUMENTO_LOG + "deleteAffidamento - error: ", e);
			throw e;
		}
	}
}
