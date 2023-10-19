//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.2 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.10.06 alle 11:47:51 AM CEST 
//


package it.csi.citpwa.model.xml.ree;

import it.csi.citpwa.model.xsd.controllo1B.RowCombustibile;
import it.csi.citpwa.util.ObjectConverter;

import java.math.BigDecimal;
import java.math.BigInteger;

public class RowCombustibileModel {

    public static ObjectConverter<RowCombustibile, RowCombustibileModel> tipo1BDtoToModel = new ObjectConverter<>(u -> {
        RowCombustibileModel model = new RowCombustibileModel();
        model.setUnitaMisura(u.getAEUnitaMisura());
        model.setEsercizio(u.getAEEsercizio());
        model.setConsumoAnnuo(u.getAEConsumoAnnuo());
        return model;
    });

    public static ObjectConverter<RowCombustibileModel, RowCombustibile> tipo1BModelToDto = new ObjectConverter<>(u -> {
        RowCombustibile dto = new RowCombustibile();
        dto.setAEUnitaMisura(u.getUnitaMisura());
        dto.setAEEsercizio(u.getEsercizio());
        dto.setAEConsumoAnnuo(u.getConsumoAnnuo());
        return dto;
    });

    protected int unitaMisura;
    protected BigInteger esercizio;
    protected BigDecimal consumoAnnuo;

    public RowCombustibileModel() {
    }

    public RowCombustibileModel(int unitaMisura, BigInteger esercizio, BigDecimal consumoAnnuo) {
        this.unitaMisura = unitaMisura;
        this.esercizio = esercizio;
        this.consumoAnnuo = consumoAnnuo;
    }

    public int getUnitaMisura() {
        return unitaMisura;
    }

    public void setUnitaMisura(int unitaMisura) {
        this.unitaMisura = unitaMisura;
    }

    public BigInteger getEsercizio() {
        return esercizio;
    }

    public void setEsercizio(BigInteger esercizio) {
        this.esercizio = esercizio;
    }

    public BigDecimal getConsumoAnnuo() {
        return consumoAnnuo;
    }

    public void setConsumoAnnuo(BigDecimal consumoAnnuo) {
        this.consumoAnnuo = consumoAnnuo;
    }

    @Override
    public String toString() {
        return "RowCombustibileModel{" + "unitaMisura=" + unitaMisura + ", esercizio=" + esercizio + ", consumoAnnuo=" + consumoAnnuo + '}';
    }
}
