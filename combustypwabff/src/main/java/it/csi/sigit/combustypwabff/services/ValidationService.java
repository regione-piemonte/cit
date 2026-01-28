package it.csi.sigit.combustypwabff.services;

import it.csi.sigit.combustypwabff.bff.dto.UtenteLoggato;
import it.csi.sigit.combustypwabff.model.sigitext.SigitextImpiantoFiltro;
import it.csi.sigit.combustypwabff.utils.Constants;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ValidationService {

    public Boolean validateRicercaImpianto(UtenteLoggato utenteLoggato, SigitextImpiantoFiltro impiantoFiltro) {
        boolean result = utenteLoggato.getRuoloLoggato() != null;
        switch (utenteLoggato.getRuoloLoggato().getRuolo()) {
            case Constants.RUOLO_3RESPONSABILE:
                result = impiantoFiltro.getCf3Responsabile().equals(utenteLoggato.getRuoloLoggato().getPiva());
                break;
            case Constants.RUOLO_RESPONSABILE:
                result = impiantoFiltro.getCfResponsabile().equals(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
                break;
            case Constants.RUOLO_RESPONSABILE_IMPRESA:
                result = impiantoFiltro.getCfResponsabile().equals(utenteLoggato.getRuoloLoggato().getPiva());
                break;
            case Constants.RUOLO_PROPRIETARIO:
                result = impiantoFiltro.getCfProprietario().equals(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
                break;
            case Constants.RUOLO_PROPRIETARIO_IMPRESA:
                result = impiantoFiltro.getCfProprietario().equals(utenteLoggato.getRuoloLoggato().getPiva());
                break;
            case Constants.RUOLO_DISTRIBUTORE:
                result = true;
                break;
            case Constants.RUOLO_CAT:
                result = false;
                break;
            default:
                break;
        }
        return result;
    }

}
