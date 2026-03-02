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
@Table(name = "sigit_wrk_config")
public class SigitWrkConfig  extends PanacheEntityBase {

    @Id
    @Column(name = "id_config", nullable = false)
    private BigDecimal idConfig;

    @Column(name = "chiave_config", nullable = false, length = 50)
    private String chiave;

    @Column(name = "valore_config_num")
    private BigDecimal valoreNumerico;

    @Column(name = "valore_config_char", length = 100)
    private String valoreTestuale;

    @Column(name = "valore_flag", length = 1)
    private String valoreFlag;

}
