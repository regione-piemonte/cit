package it.csi.sigit.citpdnd.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sigit_l_accesso")
public class SigitAccesso extends PanacheEntityBase {

    @EmbeddedId
    private SigitAccessoPk id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cognome", length = 100)
    private String cognome;

    @Column(name = "ruolo", length = 100)
    private String ruolo;

}