package it.csi.citpwa.model.sigitext;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class SigitTLibretto {

    protected BigDecimal idLibretto;
    protected BigDecimal fkStato;
    protected BigDecimal fkMotivoConsolid;
    protected BigDecimal fkTipoDocumento;
    protected Date dataConsolidamento;
    protected String fileIndex;
    protected String uidIndex;
    protected String cfRedattore;
    protected BigDecimal flgControlloBozza;
    protected Timestamp dataUltMod;
    protected String utenteUltMod;
    protected BigDecimal codiceImpianto;

    public SigitTLibretto() {}

    public SigitTLibretto(final BigDecimal idLibretto) {
        this.setIdLibretto(idLibretto);
    }

    public BigDecimal getIdLibretto() {
        return idLibretto;
    }

    public void setIdLibretto(BigDecimal idLibretto) {
        this.idLibretto = idLibretto;
    }

    public BigDecimal getFkStato() {
        return fkStato;
    }

    public void setFkStato(BigDecimal fkStato) {
        this.fkStato = fkStato;
    }

    public BigDecimal getFkMotivoConsolid() {
        return fkMotivoConsolid;
    }

    public void setFkMotivoConsolid(BigDecimal fkMotivoConsolid) {
        this.fkMotivoConsolid = fkMotivoConsolid;
    }

    public BigDecimal getFkTipoDocumento() {
        return fkTipoDocumento;
    }

    public void setFkTipoDocumento(BigDecimal fkTipoDocumento) {
        this.fkTipoDocumento = fkTipoDocumento;
    }

    public Date getDataConsolidamento() {
        if (dataConsolidamento != null) {
            return new Date(dataConsolidamento.getTime());
        } else {
            return null;
        }
    }

    public void setDataConsolidamento(Date dataConsolidamento) {
        if (dataConsolidamento != null) {
            this.dataConsolidamento = new Date(dataConsolidamento.getTime());
        } else {
            this.dataConsolidamento = null;
        }
    }

    public String getFileIndex() {
        return fileIndex;
    }

    public void setFileIndex(String fileIndex) {
        this.fileIndex = fileIndex;
    }

    public String getUidIndex() {
        return uidIndex;
    }

    public void setUidIndex(String uidIndex) {
        this.uidIndex = uidIndex;
    }

    public String getCfRedattore() {
        return cfRedattore;
    }

    public void setCfRedattore(String cfRedattore) {
        this.cfRedattore = cfRedattore;
    }

    public BigDecimal getFlgControlloBozza() {
        return flgControlloBozza;
    }

    public void setFlgControlloBozza(BigDecimal flgControlloBozza) {
        this.flgControlloBozza = flgControlloBozza;
    }

    public Timestamp getDataUltMod() {
        if (dataUltMod != null) {
            return new Timestamp(dataUltMod.getTime());
        } else {
            return null;
        }
    }

    public void setDataUltMod(Timestamp dataUltMod) {
        if (dataUltMod != null) {
            this.dataUltMod = new Timestamp(dataUltMod.getTime());
        } else {
            this.dataUltMod = null;
        }
    }

    public String getUtenteUltMod() {
        return utenteUltMod;
    }

    public void setUtenteUltMod(String utenteUltMod) {
        this.utenteUltMod = utenteUltMod;
    }

    public BigDecimal getCodiceImpianto() {
        return codiceImpianto;
    }

    public void setCodiceImpianto(BigDecimal codiceImpianto) {
        this.codiceImpianto = codiceImpianto;
    }

}
