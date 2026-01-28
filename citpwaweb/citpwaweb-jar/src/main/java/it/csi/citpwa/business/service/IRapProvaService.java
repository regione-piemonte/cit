package it.csi.citpwa.business.service;

import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.DatiRapProva;
import it.csi.citpwa.model.sigitext.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface IRapProvaService {

    public List<DatiRapProva> getRapProva(DatiRapProva datiRapProva, String ordinamento) throws SvistaException, IOException;

    void setRapProva(RapportoDiProva rapportoDiProva) throws SigitExtException, IOException;

    void inviaRapProva(Boolean conferma, BigDecimal idAllegato, BigDecimal codiceImpianto, UtenteLoggato user) throws SigitExtException, IOException  ;

    void deleteRapProva(Boolean conferma, BigDecimal idAllegato, BigDecimal idIspezione2018, UtenteLoggato user) throws SigitExtException, IOException  ;

    RapProvaWeb getRapProvaWeb(BigDecimal idAllegato, BigDecimal fkTipoDocumento) throws SigitExtException, IOException  ;

    Esito setRapProvaWeb(RapProvaWeb rapProvaWeb) throws SigitExtException, IOException  ;

    FileBase64 getPDFRapProva(Boolean firmato, BigDecimal idAllegato, UtenteLoggato user) throws SigitExtException, IOException;

    Esito updatePDFFirmatoRapProva(RapProvaWeb rapProvaWeb) throws SigitExtException, IOException;

    Esito setScansioneRapProva(RapProvaWeb rapProvaWeb) throws SigitExtException, IOException;
}
