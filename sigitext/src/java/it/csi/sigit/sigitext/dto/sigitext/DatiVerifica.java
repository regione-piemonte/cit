package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;
import java.util.Date;

public class DatiVerifica implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idVerifica;
    private int fkTipoVerifica;
    private String desTipoVerifica;
    private int fkAllegato;
    private Integer fkDatoDistrib;
    private String codiceImpianto;
    private String cfUtenteCaricamento;
    private String denomUtenteCaricamento;
    private Date dtCaricamento;
    private String siglaRee;
    private String numeroRee;
    private Date dtSveglia;
    private String noteSveglia;
    private String note;
    
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
	public Integer getFkDatoDistrib() {
		return fkDatoDistrib;
	}
	public void setFkDatoDistrib(Integer fkDatoDistrib) {
		this.fkDatoDistrib = fkDatoDistrib;
	}
	public String getCodiceImpianto() {
		return codiceImpianto;
	}
	public void setCodiceImpianto(String codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
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
	public Date getDtCaricamento() {
		return dtCaricamento;
	}
	public void setDtCaricamento(Date dtCaricamento) {
		this.dtCaricamento = dtCaricamento;
	}
	public String getSiglaRee() {
		return siglaRee;
	}
	public void setSiglaRee(String siglaRee) {
		this.siglaRee = siglaRee;
	}
	public String getNumeroRee() {
		return numeroRee;
	}
	public void setNumeroRee(String numeroRee) {
		this.numeroRee = numeroRee;
	}
	public Date getDtSveglia() {
		return dtSveglia;
	}
	public void setDtSveglia(Date dtSveglia) {
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
		return "DatiVerifica [idVerifica=" + idVerifica + ", fkTipoVerifica=" + fkTipoVerifica + ", desTipoVerifica="
				+ desTipoVerifica + ", fkAllegato=" + fkAllegato + ", fkDatoDistrib=" + fkDatoDistrib
				+ ", codiceImpianto=" + codiceImpianto + ", cfUtenteCaricamento=" + cfUtenteCaricamento
				+ ", denomUtenteCaricamento=" + denomUtenteCaricamento + ", dtCaricamento=" + dtCaricamento
				+ ", siglaRee=" + siglaRee + ", numeroRee=" + numeroRee + ", dtSveglia=" + dtSveglia + ", noteSveglia="
				+ noteSveglia + ", note=" + note + "]";
	}

    
}
