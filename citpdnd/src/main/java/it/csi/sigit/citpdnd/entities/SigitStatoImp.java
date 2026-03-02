package it.csi.sigit.citpdnd.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "sigit_d_stato_imp")
public class SigitStatoImp extends PanacheEntityBase {

    @Id
    @Column(name = "id_stato")
    private BigDecimal idStato;

    @Column(name = "des_stato", length = 100)
    private String desStato;

}