package it.csi.citpwa.business.service;

import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.sigitext.DatiAffidamento;
import it.csi.citpwa.model.sigitext.RequestTerzoResponsabile;
import it.csi.citpwa.model.sigitext.ResponseGetDettaglioNomina;
import it.csi.citpwa.model.sigitext.UtenteLoggato;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface INominaTerzoResponsabileService {
	
	ResponseGetDettaglioNomina getDettaglioNomina(Integer idContratto, Integer codiceImpianto) throws SvistaException, IOException;
	
	String deleteAffidamento(String codiceFiscale, Integer idPersonaGiuridica, Integer codiceImpianto, DatiAffidamento datiAffidamento) throws SvistaException, IOException;
	
	List<Map<Integer, String>> getTipoCessazione() throws SvistaException, IOException;
	
	List<Map<Integer, String>> getTipoAutodichiarazione() throws SvistaException, IOException;
	
	String setCessazione(RequestTerzoResponsabile requestTerzoResponsabile) throws SvistaException, IOException;
	
	String setProroga(RequestTerzoResponsabile requestTerzoResponsabile) throws SvistaException, IOException;
	
	String setSubentrosuImpianto(String codiceFiscale, Integer idPersona, Integer codiceImpianto, String desRuolo, UtenteLoggato utenteLoggato) throws SvistaException, IOException;
	
	String verifyContrattoTerzoResponsabile(RequestTerzoResponsabile requestVerifyContratto) throws SvistaException, IOException;
	
	String setNuovoTerzoResp(Integer codiceImpianto, RequestTerzoResponsabile request) throws SvistaException, IOException;
}
