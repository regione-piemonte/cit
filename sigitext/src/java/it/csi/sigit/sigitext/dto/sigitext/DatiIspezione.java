package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;
import java.math.BigDecimal;

public class DatiIspezione implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private BigDecimal idIspezione2018;
    private BigDecimal fkStatoIspezione;   
    private String desStatoIspezione;
    private Integer fkAccertamento;
    private Integer fkVerifica;
    private BigDecimal codiceImpianto;
    private BigDecimal idIspezIspet;
    private String cfUtenteAssegn;
    private String denomUtenteAssegn;
    private String cfIspettoreSecondario;
    private String enteCompetente;
    private BigDecimal flgEsito;
    private Long dtSveglia;
    private String noteSveglia;
    private String note;
    private String istatProvCompetenza;
    private BigDecimal flgAccSostitutivo;
    private Long dtCreazione;
    private Long dtConclusione;
    private BigDecimal flgIspPagamento;
    private String istatComuneCompetenza;    
    
    private String civico;
    private String indirizzoSitad;
    private String indirizzoNonTrovato;
    
    private Long dtCreazioneDa;
    private Long dtConclusioneDa;
    private Long dtCreazioneA;
    private Long dtConclusioneA;      
    
    private Boolean nonAssegnato;
    private String denominazioneComune;        
    
	public BigDecimal getIdIspezIspet() {
		return idIspezIspet;
	}
	public void setIdIspezIspet(BigDecimal idIspezIspet) {
		this.idIspezIspet = idIspezIspet;
	}
	public String getDenominazioneComune() {
		return denominazioneComune;
	}
	public void setDenominazioneComune(String denominazioneComune) {
		this.denominazioneComune = denominazioneComune;
	}
	public String getCivico() {
		return civico;
	}
	public void setCivico(String civico) {
		this.civico = civico;
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
	public BigDecimal getIdIspezione2018() {
		return idIspezione2018;
	}
	public void setIdIspezione2018(BigDecimal idIspezione2018) {
		this.idIspezione2018 = idIspezione2018;
	}
	public BigDecimal getFkStatoIspezione() {
		return fkStatoIspezione;
	}
	public void setFkStatoIspezione(BigDecimal fkStatoIspezione) {
		this.fkStatoIspezione = fkStatoIspezione;
	}
	public String getDesStatoIspezione() {
		return desStatoIspezione;
	}
	public void setDesStatoIspezione(String desStatoIspezione) {
		this.desStatoIspezione = desStatoIspezione;
	}
	public Integer getFkAccertamento() {
		return fkAccertamento;
	}
	public void setFkAccertamento(Integer fkAccertamento) {
		this.fkAccertamento = fkAccertamento;
	}
	public Integer getFkVerifica() {
		return fkVerifica;
	}
	public void setFkVerifica(Integer fkVerifica) {
		this.fkVerifica = fkVerifica;
	}
	public BigDecimal getCodiceImpianto() {
		return codiceImpianto;
	}
	public void setCodiceImpianto(BigDecimal codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}
	public String getCfUtenteAssegn() {
		return cfUtenteAssegn;
	}
	public void setCfUtenteAssegn(String cfUtenteAssegn) {
		this.cfUtenteAssegn = cfUtenteAssegn;
	}
	public String getDenomUtenteAssegn() {
		return denomUtenteAssegn;
	}
	public void setDenomUtenteAssegn(String denomUtenteAssegn) {
		this.denomUtenteAssegn = denomUtenteAssegn;
	}
	public String getCfIspettoreSecondario() {
		return cfIspettoreSecondario;
	}
	public void setCfIspettoreSecondario(String cfIspettoreSecondario) {
		this.cfIspettoreSecondario = cfIspettoreSecondario;
	}
	public String getEnteCompetente() {
		return enteCompetente;
	}
	public void setEnteCompetente(String enteCompetente) {
		this.enteCompetente = enteCompetente;
	}
	public BigDecimal getFlgEsito() {
		return flgEsito;
	}
	public void setFlgEsito(BigDecimal flgEsito) {
		this.flgEsito = flgEsito;
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
	public String getIstatProvCompetenza() {
		return istatProvCompetenza;
	}
	public void setIstatProvCompetenza(String istatProvCompetenza) {
		this.istatProvCompetenza = istatProvCompetenza;
	}
	public BigDecimal getFlgAccSostitutivo() {
		return flgAccSostitutivo;
	}
	public void setFlgAccSostitutivo(BigDecimal flgAccSostitutivo) {
		this.flgAccSostitutivo = flgAccSostitutivo;
	}
	public Long getDtCreazione() {
		return dtCreazione;
	}
	public void setDtCreazione(Long dtCreazione) {
		this.dtCreazione = dtCreazione;
	}
	public Long getDtConclusione() {
		return dtConclusione;
	}
	public void setDtConclusione(Long dtConclusione) {
		this.dtConclusione = dtConclusione;
	}
	public BigDecimal getFlgIspPagamento() {
		return flgIspPagamento;
	}
	public void setFlgIspPagamento(BigDecimal flgIspPagamento) {
		this.flgIspPagamento = flgIspPagamento;
	}
	public String getIstatComuneCompetenza() {
		return istatComuneCompetenza;
	}
	public void setIstatComuneCompetenza(String istatComuneCompetenza) {
		this.istatComuneCompetenza = istatComuneCompetenza;
	}		
	public Long getDtCreazioneDa() {
		return dtCreazioneDa;
	}
	public void setDtCreazioneDa(Long dtCreazioneDa) {
		this.dtCreazioneDa = dtCreazioneDa;
	}
	public Long getDtConclusioneDa() {
		return dtConclusioneDa;
	}
	public void setDtConclusioneDa(Long dtConclusioneDa) {
		this.dtConclusioneDa = dtConclusioneDa;
	}
	public Long getDtCreazioneA() {
		return dtCreazioneA;
	}
	public void setDtCreazioneA(Long dtCreazioneA) {
		this.dtCreazioneA = dtCreazioneA;
	}
	public Long getDtConclusioneA() {
		return dtConclusioneA;
	}
	public void setDtConclusioneA(Long dtConclusioneA) {
		this.dtConclusioneA = dtConclusioneA;
	}
		
	public Boolean getNonAssegnato() {
		return nonAssegnato;
	}
	public void setNonAssegnato(Boolean nonAssegnato) {
		this.nonAssegnato = nonAssegnato;
	}

	@Override
	public String toString() {
		return "DatiIspezione [idIspezione2018=" + idIspezione2018 + ", fkStatoIspezione=" + fkStatoIspezione
				+ ", desStatoIspezione=" + desStatoIspezione + ", fkAccertamento=" + fkAccertamento + ", fkVerifica="
				+ fkVerifica + ", codiceImpianto=" + codiceImpianto + ", cfUtenteAssegn=" + cfUtenteAssegn
				+ ", denomUtenteAssegn=" + denomUtenteAssegn + ", cfIspettoreSecondario=" + cfIspettoreSecondario
				+ ", enteCompetente=" + enteCompetente + ", flgEsito=" + flgEsito + ", dtSveglia=" + dtSveglia
				+ ", noteSveglia=" + noteSveglia + ", note=" + note + ", istatProvCompetenza=" + istatProvCompetenza
				+ ", flgAccSostitutivo=" + flgAccSostitutivo + ", dtCreazione=" + dtCreazione + ", dtConclusione="
				+ dtConclusione + ", flgIspPagamento=" + flgIspPagamento + ", istatComuneCompetenza="
				+ istatComuneCompetenza + "]";
	}
    
	public boolean vuoto(){
		return this.idIspezione2018 == null &&
		this.fkStatoIspezione == null &&
	    this.desStatoIspezione == null &&
		this.fkAccertamento == null &&
		this.fkVerifica == null &&
		this.codiceImpianto == null &&
		this.cfUtenteAssegn == null &&
		this.denomUtenteAssegn == null &&
		this.cfIspettoreSecondario == null &&
		this.enteCompetente == null &&
		this.flgEsito == null &&
		this.dtSveglia == null &&
		this.noteSveglia == null &&
		this.note == null &&
		this.istatProvCompetenza == null &&
		this.flgAccSostitutivo == null &&
		this.dtCreazione == null &&
		this.dtConclusione == null &&
		this.flgIspPagamento == null &&
		this.istatComuneCompetenza == null && 
		this.dtCreazioneDa == null &&
		this.dtConclusioneDa == null &&
		this.dtCreazioneA == null &&
		this.dtConclusioneA == null &&	    
		this.nonAssegnato == null;
		
	}
	
	
    

}
