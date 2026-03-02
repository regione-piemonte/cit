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
@Table(name = "sigit_t_unita_immobiliare")
public class SigitUnitaImmobiliare extends PanacheEntityBase {

    @Id
    @Column(name = "id_unita_imm")
    private BigDecimal idUnitaImm;

    @Column(name = "codice_impianto")
    private BigDecimal codiceImpianto;

    @Column(name = "flg_principale")
    private BigDecimal flgPrincipale;

    @Column(name = "l1_2_vol_risc_m3")
    private BigDecimal volRisc;

    @Column(name = "l1_2_vol_raff_m3")
    private BigDecimal volRaff;

}