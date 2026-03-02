package it.csi.sigit.citpdnd.dao;

import it.csi.sigit.citpdnd.entities.SigitAccesso;
import it.csi.sigit.citpdnd.entities.SigitAccessoPk;
import it.csi.sigit.citpdnd.utils.Constants;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AuditDao {

    @Transactional
    public void insertAccesso(String servizio) {

        SigitAccesso sigitAccesso = new SigitAccesso();

        sigitAccesso.setId(new SigitAccessoPk("PDND"));
        sigitAccesso.setRuolo(usingSubstringMethod(servizio));

        SigitAccesso.persist(sigitAccesso);
    }

    static String usingSubstringMethod(String text) {
        if (text.length() <= Constants.MAX_MESSAGE_LENGHT) {
            return text;
        } else {
            return text.substring(0, Constants.MAX_MESSAGE_LENGHT);
        }
    }
}
