package it.csi.sigit.citpdnd.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Embeddable
public class SigitAccessoPk {

    @Column(name = "dt_accesso", nullable = false)
    private Timestamp dtAccesso;

    @Column(name = "codice_fiscale", nullable = false, length = 16)
    private String codiceFiscale;

    public SigitAccessoPk(String codiceFiscale) {
        this.dtAccesso = new Timestamp(System.currentTimeMillis());
        this.codiceFiscale = codiceFiscale;
    }
}
