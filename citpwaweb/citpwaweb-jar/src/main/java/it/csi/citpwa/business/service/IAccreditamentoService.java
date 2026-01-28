package it.csi.citpwa.business.service;

import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.sigitext.*;

import java.io.IOException;
import java.util.List;

public interface IAccreditamentoService {
	
	Accreditamento getDatiAccreditamento(String codiceFiscalePF) throws IOException;
	String setDatiPersonaliUtente(String codiceFiscalePF, Persona persona) throws IOException;
	List<DatiImpresa> getDatiImpresa(String codiceFiscale, String siglaRea, Integer numeroRea) throws IOException;
	String setDelega(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersona) throws IOException;
	String deleteDelega(UtenteLoggato utenteLoggato, Integer idPersona) throws IOException;
	String deleteDelegaConfirm(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersona) throws IOException;
	List<IncarichiSoggettiDelegatiResponse> getIncarichiSoggettiDelegati() throws IOException;
	String setIncaricoSoggettoDelegato(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) throws IOException;
	String deleteIncaricoSoggettoDelegato(String codiceFiscalePF, Integer idPersonaGiuridica, Integer idPersonaGiuridicaCat) throws IOException;
	String sendEmailProva(String emailAddress) throws IOException;
	String setImpresaAssociata(String operation, String codiceFiscalePF, DatiImpresa datiImpresa) throws IOException;
    List<DatiIncarico> getElencoIncarichi(Integer idPersonaGiuridica) throws SvistaException, IOException ;
	List<DatiDelega> getElencoDeleghe(Integer idPersonaGiuridica) throws SvistaException, IOException ;
	String getDatiTokenImpresa(Integer idPersonaGiuridica) throws SigitExtException, IOException;
	String generateTokenImpresa(Integer idPersonaGiuridica) throws SigitExtException, IOException;
}
