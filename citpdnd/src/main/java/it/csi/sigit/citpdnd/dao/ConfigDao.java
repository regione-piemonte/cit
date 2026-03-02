package it.csi.sigit.citpdnd.dao;

import it.csi.sigit.citpdnd.entities.SigitWrkConfig;
import it.csi.sigit.citpdnd.exception.CitpdndException;
import it.csi.sigit.citpdnd.utils.Constants;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Optional;

@ApplicationScoped
public class ConfigDao {

    protected static final Logger log = Logger.getLogger(Constants.APPLICATION_NAME);
    private static final String MAX_RISULTATI_PDND = "MAX_RISULTATI_PDND";

    private SigitWrkConfig getConfigByChiave (String chiave) throws CitpdndException {

        Optional<SigitWrkConfig> sigitWrkConfig = SigitWrkConfig.find("chiave = ?1", chiave).singleResultOptional();

        if (sigitWrkConfig.isPresent()) {
            return sigitWrkConfig.get();
        } else {
            log.error("ConfigDao.getConfigByChiave - Parametro configurazione non trovato.");
            throw new CitpdndException("04", Constants.ERROR_MESSAGE_CODE_04);
        }
    }

    public BigDecimal getMaxRisultati() {

        try {
            return getConfigByChiave(MAX_RISULTATI_PDND).getValoreNumerico();
        } catch (CitpdndException e) {
            return new BigDecimal(500);
        }
    }
}
