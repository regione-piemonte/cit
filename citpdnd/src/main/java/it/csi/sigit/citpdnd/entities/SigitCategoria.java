package it.csi.sigit.citpdnd.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sigit_d_categoria")
public class SigitCategoria extends PanacheEntityBase {

    @Id
    @Column(name = "id_categoria", nullable = false, length = 10)
    private String idCategoria;

    @Column(name = "des_categoria", length = 200)
    private String desCategoria;
}