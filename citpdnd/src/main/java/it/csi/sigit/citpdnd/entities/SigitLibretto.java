package it.csi.sigit.citpdnd.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "sigit_t_libretto")
public class SigitLibretto extends PanacheEntityBase {

    @Id
    @Column(name = "id_libretto", nullable = false)
    private BigDecimal idLibretto;

    @Column(name = "codice_impianto", nullable = false)
    private BigDecimal codiceImpianto;

    @Column(name = "fk_stato", nullable = false)
    private BigDecimal fkStato;

    @Column(name = "fk_motivo_consolid")
    private BigDecimal fkMotivoConsolid;

    @Column(name = "fk_tipo_documento", nullable = false)
    private BigDecimal fkTipoDocumento;

    @Column(name = "data_consolidamento")
    private Date dataConsolidamento;

    @Column(name = "file_index", length = 100)
    private String fileIndex;

    @Column(name = "uid_index", length = 50)
    private String uidIndex;

    @Column(name = "cf_redattore", length = 16)
    private String cfRedattore;

    @Column(name = "flg_controllo_bozza", nullable = false)
    private BigDecimal flgControlloBozza;

    @Column(name = "data_ult_mod", nullable = false)
    private Timestamp dataUltMod;

    @Column(name = "utente_ult_mod", length = 16)
    private String utenteUltMod;


}