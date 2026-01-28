package it.csi.citpwa.business.service;

import it.csi.citpwa.model.*;
import it.csi.citpwa.model.sigitext.DownloadFileExcelRequest;
import it.csi.citpwa.model.sigitext.StatoIspezione;
import it.csi.citpwa.model.sigitext.UtenteLoggato;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface IIspezioneService {
    List<IspezioneDetail> getIspezioni(IspezioneDetail ispezioneDetail) throws Exception;

    IspezioneDetail getIspezione(Integer id) throws Exception;

    String downloadCopertinaIspezione(Integer idIspezione2018, UtenteLoggato utenteLoggato);

    String downloadLetteraAvviso(Integer idIspezione2018, UtenteLoggato utenteLoggato);

    String downloadLetteraAvviso180Gg(Integer idIspezione2018, UtenteLoggato utenteLoggato);

    String downloadFileExcel(DownloadFileExcelRequest downloadFileExcelRequest, UtenteLoggato utenteLoggato) throws Exception;

    List<StatoIspezione>  getStatoIspezione() throws Exception;

    String setIspezione(IspezioneDetail ispezioneDetail, UtenteLoggato utenteLoggato) throws Exception;

    String assegna(IspezioneDetail ispezioneDetail, UtenteLoggato utenteLoggato)  throws Exception;

    String concludi(IspezioneDetail ispezioneDetail, UtenteLoggato utenteLoggato) throws Exception;

    String assegnaImpianto(IspezioneDetail ispezioneDetail, UtenteLoggato user) throws Exception;

    String annulla(BigDecimal id, UtenteLoggato user) throws Exception;

    String setIspezioneMassiva(IspezioneMassiva ispezioneMassiva, UtenteLoggatoModel user) throws Exception;

    Object getAzione(Integer idIspezione2018, UtenteLoggato utenteLoggato) throws IOException;

    Object setAzione(DatiAzione datiAzione) throws IOException;

    Object getIspettore() throws IOException ;
}
