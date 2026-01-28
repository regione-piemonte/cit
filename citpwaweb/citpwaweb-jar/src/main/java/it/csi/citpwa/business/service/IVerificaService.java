package it.csi.citpwa.business.service;

import it.csi.citpwa.model.DatiAzione;
import it.csi.citpwa.model.IspezioneMassiva;
import it.csi.citpwa.model.UtenteLoggatoModel;
import it.csi.citpwa.model.sigitext.RicercaDatiVerifica;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.citpwa.model.sigitext.Verifica;

import java.io.IOException;

public interface IVerificaService {


    Object getTipoVerifica() throws IOException;

    Object getVerifica(Integer idVerifica) throws IOException;

    String setVerifica(Verifica verifica, UtenteLoggatoModel utenteLoggato) throws IOException;

    Object getVerifiche(RicercaDatiVerifica ricercaDatiVerifica) throws IOException;

    String deleteVerifica(Integer idVerifica) throws IOException;

    Object getDistributore(Long idDatoDistrib) throws IOException ;

    Object getControllo(String siglaRee, Long numeroRee)  throws IOException ;

    Object getAssegnatario() throws IOException ;

    Object getSiglaRee() throws IOException ;

    Object getAzione(Integer idVerifica, UtenteLoggato utenteLoggato) throws IOException;

    Object setAzione(DatiAzione datiAzione) throws IOException;

    String setIspezioneMassiva(IspezioneMassiva ispezioneMassiva, UtenteLoggatoModel user) throws IOException, Exception;
}
