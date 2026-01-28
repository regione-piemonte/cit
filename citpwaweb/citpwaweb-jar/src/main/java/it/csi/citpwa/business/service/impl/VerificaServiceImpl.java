package it.csi.citpwa.business.service.impl;

import it.csi.citpwa.business.service.ICitService;
import it.csi.citpwa.business.service.IIspezioneService;
import it.csi.citpwa.business.service.IVerificaService;
import it.csi.citpwa.model.DatiAzione;
import it.csi.citpwa.model.IspezioneMassiva;
import it.csi.citpwa.model.UtenteLoggatoModel;
import it.csi.citpwa.model.sigitext.RicercaDatiVerifica;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.citpwa.model.sigitext.Verifica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class VerificaServiceImpl implements IVerificaService {

    @Autowired
    ICitService citService;

    @Autowired
    IIspezioneService ispezioneService;

    @Override
    public Object getTipoVerifica() throws IOException {
        return citService.getTipoVerifica();
    }

    @Override
    public Object getVerifica(Integer idVerifica) throws IOException {
        return citService.getVerifica(idVerifica);
    }

    @Override
    public String setVerifica(Verifica verifica, UtenteLoggatoModel utenteLoggato)  throws IOException {
        return citService.setVerifica(verifica, utenteLoggato);
    }

    @Override
    public Object getVerifiche(RicercaDatiVerifica ricercaDatiVerifica) throws IOException {
        return citService.getVerifiche(ricercaDatiVerifica);
    }

    @Override
    public String deleteVerifica(Integer idVerifica)  throws IOException {
        return citService.deleteVerifica(idVerifica);
    }

    @Override
    public Object getDistributore(Long idDatoDistrib) throws IOException  {
        return citService.getDistributore(idDatoDistrib);
    }

    @Override
    public Object getControllo(String siglaRee, Long numeroRee) throws IOException  {
        return citService.getControllo(siglaRee, numeroRee);
    }

    @Override
    public Object getAssegnatario() throws IOException  {
        return citService.getAssegnatario();
    }

    @Override
    public Object getSiglaRee() throws IOException  {
        return citService.getSiglaRee();
    }

    @Override
    public Object getAzione(Integer idVerifica, UtenteLoggato utenteLoggato) throws IOException {
        return citService.getAzione(idVerifica, utenteLoggato);
    }

    @Override
    public Object setAzione(DatiAzione datiAzione) throws IOException {
        return citService.setAzione(datiAzione);
    }

    @Override
    public String setIspezioneMassiva(IspezioneMassiva ispezioneMassiva, UtenteLoggatoModel user) throws Exception {
        return ispezioneService.setIspezioneMassiva(ispezioneMassiva, user);
    }
}
