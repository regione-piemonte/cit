package it.csi.sigit.citpdnd.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "vista_ricerca_impianti")
public class VistaRicercaImpianti extends PanacheEntityBase {

    @Id
    @Column(name = "codice_impianto")
    private BigDecimal codiceImpianto;

    @ManyToOne
    @JoinColumn(name = "fk_stato")
    private SigitStatoImp statoImp;

    @Column(name = "indirizzo_unita_immob")
    private String indirizzoUnitaImmob;

    @Column(name = "civico")
    private String civico;

    @Column(name = "istat_comune")
    private String istatComune;

    @Column(name = "denominazione_comune")
    private String denominazioneComune;

    @Column(name = "sigla_provincia")
    private String siglaProvincia;

    @Column(name = "flg_tipo_impianto")
    private String flgTipoImpianto;

    @ManyToOne
    @JoinColumn(name = "l1_2_fk_categoria")
    private SigitCategoria categoria;

    @Column(name = "l1_3_pot_h2o_kw")
    private BigDecimal potAcs;

    @Column(name = "l1_3_pot_clima_inv_kw")
    private BigDecimal potClimaInv;

    @Column(name = "l1_3_pot_clima_est_kw")
    private BigDecimal potClimaEst;

}