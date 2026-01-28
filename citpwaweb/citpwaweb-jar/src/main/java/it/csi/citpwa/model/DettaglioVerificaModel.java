package it.csi.citpwa.model;

import it.csi.citpwa.model.sigitext.DatiImpianto;
import it.csi.citpwa.model.sigitext.DatiVerifica;

import java.io.Serializable;
import java.util.Date;

public class DettaglioVerificaModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long codiceImpianto;
    private String stato;
    private Date dataVar;
    private String motivazione;
    private String tipoImpianto;
    private Integer flgApparevvUiExt;
    private Integer flgContabilizzazione;
    private Integer stradario;
    private String indirizzoSitad;
    private String indirizzoNonTrovato;
    private String comune;
    private String civico;
    private String provincia;
    private String pod;
    private String pdr;
    private Integer flgNoPdr;
    private Integer flgVisuProprietario;
    private Double coordX;
    private Double coordY;
    private String siglaProv;
    private String istatComune;
    private Integer flgMedioimpianto;
    private int idVerifica;
    private int fkTipoVerifica;
    private String desTipoVerifica;
    private int fkAllegato;
    private int fkDatoDistrib;
    private String cfUtenteCaricamento;
    private String denomUtenteCaricamento;
    private Long dtCaricamento;
    private String siglaBollino;
    private Integer numeroBollino;
    private Long dtSveglia;
    private String noteSveglia;
    private String note;

    public Long getCodiceImpianto() {
        return codiceImpianto;
    }

    public void setCodiceImpianto(Long codiceImpianto) {
        this.codiceImpianto = codiceImpianto;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Date getDataVar() {
        return dataVar;
    }

    public void setDataVar(Date dataVar) {
        this.dataVar = dataVar;
    }

    public String getMotivazione() {
        return motivazione;
    }

    public void setMotivazione(String motivazione) {
        this.motivazione = motivazione;
    }

    public String getTipoImpianto() {
        return tipoImpianto;
    }

    public void setTipoImpianto(String tipoImpianto) {
        this.tipoImpianto = tipoImpianto;
    }

    public Integer getFlgApparevvUiExt() {
        return flgApparevvUiExt;
    }

    public void setFlgApparevvUiExt(Integer flgApparevvUiExt) {
        this.flgApparevvUiExt = flgApparevvUiExt;
    }

    public Integer getFlgContabilizzazione() {
        return flgContabilizzazione;
    }

    public void setFlgContabilizzazione(Integer flgContabilizzazione) {
        this.flgContabilizzazione = flgContabilizzazione;
    }

    public Integer getStradario() {
        return stradario;
    }

    public void setStradario(Integer stradario) {
        this.stradario = stradario;
    }

    public String getIndirizzoSitad() {
        return indirizzoSitad;
    }

    public void setIndirizzoSitad(String indirizzoSitad) {
        this.indirizzoSitad = indirizzoSitad;
    }

    public String getIndirizzoNonTrovato() {
        return indirizzoNonTrovato;
    }

    public void setIndirizzoNonTrovato(String indirizzoNonTrovato) {
        this.indirizzoNonTrovato = indirizzoNonTrovato;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public String getPdr() {
        return pdr;
    }

    public void setPdr(String pdr) {
        this.pdr = pdr;
    }

    public Integer getFlgNoPdr() {
        return flgNoPdr;
    }

    public void setFlgNoPdr(Integer flgNoPdr) {
        this.flgNoPdr = flgNoPdr;
    }

    public Integer getFlgVisuProprietario() {
        return flgVisuProprietario;
    }

    public void setFlgVisuProprietario(Integer flgVisuProprietario) {
        this.flgVisuProprietario = flgVisuProprietario;
    }

    public Double getCoordX() {
        return coordX;
    }

    public void setCoordX(Double coordX) {
        this.coordX = coordX;
    }

    public Double getCoordY() {
        return coordY;
    }

    public void setCoordY(Double coordY) {
        this.coordY = coordY;
    }

    public String getSiglaProv() {
        return siglaProv;
    }

    public void setSiglaProv(String siglaProv) {
        this.siglaProv = siglaProv;
    }

    public String getIstatComune() {
        return istatComune;
    }

    public void setIstatComune(String istatComune) {
        this.istatComune = istatComune;
    }

    public Integer getFlgMedioimpianto() {
        return flgMedioimpianto;
    }

    public void setFlgMedioimpianto(Integer flgMedioimpianto) {
        this.flgMedioimpianto = flgMedioimpianto;
    }

    public int getIdVerifica() {
        return idVerifica;
    }

    public void setIdVerifica(int idVerifica) {
        this.idVerifica = idVerifica;
    }

    public int getFkTipoVerifica() {
        return fkTipoVerifica;
    }

    public void setFkTipoVerifica(int fkTipoVerifica) {
        this.fkTipoVerifica = fkTipoVerifica;
    }

    public String getDesTipoVerifica() {
        return desTipoVerifica;
    }

    public void setDesTipoVerifica(String desTipoVerifica) {
        this.desTipoVerifica = desTipoVerifica;
    }

    public int getFkAllegato() {
        return fkAllegato;
    }

    public void setFkAllegato(int fkAllegato) {
        this.fkAllegato = fkAllegato;
    }

    public int getFkDatoDistrib() {
        return fkDatoDistrib;
    }

    public void setFkDatoDistrib(int fkDatoDistrib) {
        this.fkDatoDistrib = fkDatoDistrib;
    }

    public String getCfUtenteCaricamento() {
        return cfUtenteCaricamento;
    }

    public void setCfUtenteCaricamento(String cfUtenteCaricamento) {
        this.cfUtenteCaricamento = cfUtenteCaricamento;
    }

    public String getDenomUtenteCaricamento() {
        return denomUtenteCaricamento;
    }

    public void setDenomUtenteCaricamento(String denomUtenteCaricamento) {
        this.denomUtenteCaricamento = denomUtenteCaricamento;
    }

    public Long getDtCaricamento() {
        return dtCaricamento;
    }

    public void setDtCaricamento(Long dtCaricamento) {
        this.dtCaricamento = dtCaricamento;
    }

    public String getSiglaBollino() {
        return siglaBollino;
    }

    public void setSiglaBollino(String siglaBollino) {
        this.siglaBollino = siglaBollino;
    }

    public Integer getNumeroBollino() {
        return numeroBollino;
    }

    public void setNumeroBollino(Integer numeroBollino) {
        this.numeroBollino = numeroBollino;
    }

    public Long getDtSveglia() {
        return dtSveglia;
    }

    public void setDtSveglia(Long dtSveglia) {
        this.dtSveglia = dtSveglia;
    }

    public String getNoteSveglia() {
        return noteSveglia;
    }

    public void setNoteSveglia(String noteSveglia) {
        this.noteSveglia = noteSveglia;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "DettaglioVerificaModel{" +
                "codiceImpianto='" + codiceImpianto + '\'' +
                ", stato='" + stato + '\'' +
                ", dataVar=" + dataVar +
                ", motivazione='" + motivazione + '\'' +
                ", tipoImpianto='" + tipoImpianto + '\'' +
                ", flgApparevvUiExt=" + flgApparevvUiExt +
                ", flgContabilizzazione=" + flgContabilizzazione +
                ", stradario=" + stradario +
                ", indirizzoSitad='" + indirizzoSitad + '\'' +
                ", indirizzoNonTrovato='" + indirizzoNonTrovato + '\'' +
                ", comune='" + comune + '\'' +
                ", civico='" + civico + '\'' +
                ", provincia='" + provincia + '\'' +
                ", pod='" + pod + '\'' +
                ", pdr='" + pdr + '\'' +
                ", flgNoPdr=" + flgNoPdr +
                ", flgVisuProprietario=" + flgVisuProprietario +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                ", siglaProv='" + siglaProv + '\'' +
                ", istatComune='" + istatComune + '\'' +
                ", flgMedioimpianto=" + flgMedioimpianto +
                ", idVerifica=" + idVerifica +
                ", fkTipoVerifica=" + fkTipoVerifica +
                ", desTipoVerifica='" + desTipoVerifica + '\'' +
                ", fkAllegato=" + fkAllegato +
                ", fkDatoDistrib=" + fkDatoDistrib +
                ", cfUtenteCaricamento='" + cfUtenteCaricamento + '\'' +
                ", denomUtenteCaricamento='" + denomUtenteCaricamento + '\'' +
                ", dtCaricamento=" + dtCaricamento +
                ", siglaBollino='" + siglaBollino + '\'' +
                ", numeroBollino='" + numeroBollino + '\'' +
                ", dtSveglia=" + dtSveglia +
                ", noteSveglia='" + noteSveglia + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
