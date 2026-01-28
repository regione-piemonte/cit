package it.csi.citpwa.business.service.impl;

import it.csi.citpwa.business.service.IAccreditamentoService;
import it.csi.citpwa.business.service.ICitService;
import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.sigitext.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AccreditamentoServiceImp implements IAccreditamentoService {



	@Autowired
	private ICitService citService;
	
	
	@Override
	public Accreditamento getDatiAccreditamento(String codiceFiscalePF) throws IOException {
		return citService.getDatiAccreditamento(codiceFiscalePF);
	}
	
	@Override
	public String setDatiPersonaliUtente(String codiceFiscalePF, Persona persona) throws IOException {
		return citService.setDatiPersonaliUtente(codiceFiscalePF, persona);
	}
	
	@Override
	public List<DatiImpresa> getDatiImpresa(String codiceFiscale, String siglaRea, Integer numeroRea) throws IOException {
		return citService.getDatiImpresa(codiceFiscale, siglaRea, numeroRea);
	}
	
	@Override
	public String setDelega(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersona) throws IOException {
		return citService.setDelega(codiceFiscalePF, idPersonaGiuridica, idPersona);
	}
	
	@Override
	public String deleteDelega(UtenteLoggato utenteLoggato, Integer idPersona) throws IOException {
		return citService.deleteDelega(utenteLoggato, idPersona);
	}
	
	@Override
	public String deleteDelegaConfirm(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersona) throws IOException {
		return citService.deleteDelegaConfirm(codiceFiscalePF, idPersonaGiuridica, idPersona);
	}
	
	@Override
	public List<IncarichiSoggettiDelegatiResponse> getIncarichiSoggettiDelegati() throws IOException {
		return citService.getIncarichiSoggettiDelegati();
	}
	
	@Override
	public String setIncaricoSoggettoDelegato(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) throws IOException {
		return citService.setIncaricoSoggettoDelegato(codiceFiscalePF, idPersonaGiuridica, idPersonaGiuridicaCat);
	}
	
	@Override
	public String deleteIncaricoSoggettoDelegato(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) throws IOException {
		return citService.deleteIncaricoSoggettoDelegato(codiceFiscalePF, idPersonaGiuridica, idPersonaGiuridicaCat);
	}
	
	@Override
	public String sendEmailProva(String emailAddress) throws IOException {
		return citService.sendEmailProva(emailAddress);
	}
	
	@Override
	public String setImpresaAssociata(String operation, String codiceFiscalePF, DatiImpresa datiImpresa) throws IOException{
		return citService.setImpresaAssociata(operation, codiceFiscalePF, datiImpresa);
	}

	@Override
	public List<DatiIncarico> getElencoIncarichi(Integer idPersonaGiuridica) throws SvistaException, IOException {
		return citService.getElencoIncarichi(idPersonaGiuridica);
	}

	@Override
	public List<DatiDelega> getElencoDeleghe(Integer idPersonaGiuridica) throws SvistaException, IOException {
		return citService.getElencoDeleghe(idPersonaGiuridica);
	}

	@Override
	public String getDatiTokenImpresa(Integer idPersonaGiuridica) throws SigitExtException, IOException {
		return citService.getDatiTokenImpresa(idPersonaGiuridica);
	}

	@Override
	public String generateTokenImpresa(Integer idPersonaGiuridica) throws SigitExtException, IOException {
		return citService.generateTokenImpresa(idPersonaGiuridica);
	}
}
