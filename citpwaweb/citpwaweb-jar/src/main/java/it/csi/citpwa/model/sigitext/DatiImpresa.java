package it.csi.citpwa.model.sigitext;

import java.io.Serializable;
import java.util.Date;

public class DatiImpresa implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer id_persona_giuridica;
	private String denominazione;
	private String codice_fiscale;
	private String indirizzo_sitad;
	private Integer stradario;
	private String indirizzo_non_trovato;
	private String sigla_prov;
	private String istat_comune;
	private String comune;
	private String provincia;
	private String civico;
	private String cap;
	private String email;
	private Date data_inizio_attivita;
	private Date data_cessazione;
	private String sigla_rea;
	private Integer numero_rea;
	private Integer flg_amministratore;
	private Date data_ult_mod;
	private String utente_ult_mod;
	private Integer flg_terzo_responsabile;
	private Integer flg_distributore;
	private Integer flg_cat;
	private Integer flg_indirizzo_estero;
	private String stato_estero;
	private String indirizzo_estero;
	private String cap_estero;
	private Integer fk_stato_pg;
	private Date dt_agg_dichiarazione;
	private Integer flg_dm37_letterac;
	private Integer flg_dm37_letterad;
	private Integer flg_dm37_letterae;
	private Integer flg_fgas;
	private Integer flg_conduttore;
	private Integer flg_sogg_incaricato;
	private Date data_fine_legame;
	private Integer flg_delega ;
	private String delega_sogg_incaricato;
	private String pec;
	private String telefono;
	private String token;
	private Date dt_creazione_token;
	private Date dt_scadenza_token;
	private String citta_estero;
	private String desStato;
	
	public String getDesStato() {
		return desStato;
	}
	public void setDesStato(String desStato) {
		this.desStato = desStato;
	}
	public Integer getId_persona_giuridica() {
		return id_persona_giuridica;
	}
	public void setId_persona_giuridica(Integer id_persona_giuridica) {
		this.id_persona_giuridica = id_persona_giuridica;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public String getCodice_fiscale() {
		return codice_fiscale;
	}
	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}
	public String getIndirizzo_sitad() {
		return indirizzo_sitad;
	}
	public void setIndirizzo_sitad(String indirizzo_sitad) {
		this.indirizzo_sitad = indirizzo_sitad;
	}
	public Integer getStradario() {
		return stradario;
	}
	public void setStradario(Integer stradario) {
		this.stradario = stradario;
	}
	public String getIndirizzo_non_trovato() {
		return indirizzo_non_trovato;
	}
	public void setIndirizzo_non_trovato(String indirizzo_non_trovato) {
		this.indirizzo_non_trovato = indirizzo_non_trovato;
	}
	public String getSigla_prov() {
		return sigla_prov;
	}
	public void setSigla_prov(String sigla_prov) {
		this.sigla_prov = sigla_prov;
	}
	public String getIstat_comune() {
		return istat_comune;
	}
	public void setIstat_comune(String istat_comune) {
		this.istat_comune = istat_comune;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCivico() {
		return civico;
	}
	public void setCivico(String civico) {
		this.civico = civico;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getData_inizio_attivita() {
		return data_inizio_attivita;
	}
	public void setData_inizio_attivita(Date data_inizio_attivita) {
		this.data_inizio_attivita = data_inizio_attivita;
	}
	public Date getData_cessazione() {
		return data_cessazione;
	}
	public void setData_cessazione(Date data_cessazione) {
		this.data_cessazione = data_cessazione;
	}
	public String getSigla_rea() {
		return sigla_rea;
	}
	public void setSigla_rea(String sigla_rea) {
		this.sigla_rea = sigla_rea;
	}
	public Integer getNumero_rea() {
		return numero_rea;
	}
	public void setNumero_rea(Integer numero_rea) {
		this.numero_rea = numero_rea;
	}
	public Integer getFlg_amministratore() {
		return flg_amministratore;
	}
	public void setFlg_amministratore(Integer flg_amministratore) {
		this.flg_amministratore = flg_amministratore;
	}
	public Date getData_ult_mod() {
		return data_ult_mod;
	}
	public void setData_ult_mod(Date data_ult_mod) {
		this.data_ult_mod = data_ult_mod;
	}
	public String getUtente_ult_mod() {
		return utente_ult_mod;
	}
	public void setUtente_ult_mod(String utente_ult_mod) {
		this.utente_ult_mod = utente_ult_mod;
	}
	public Integer getFlg_terzo_responsabile() {
		return flg_terzo_responsabile;
	}
	public void setFlg_terzo_responsabile(Integer flg_terzo_responsabile) {
		this.flg_terzo_responsabile = flg_terzo_responsabile;
	}
	public Integer getFlg_distributore() {
		return flg_distributore;
	}
	public void setFlg_distributore(Integer flg_distributore) {
		this.flg_distributore = flg_distributore;
	}
	public Integer getFlg_cat() {
		return flg_cat;
	}
	public void setFlg_cat(Integer flg_cat) {
		this.flg_cat = flg_cat;
	}
	public Integer getFlg_indirizzo_estero() {
		return flg_indirizzo_estero;
	}
	public void setFlg_indirizzo_estero(Integer flg_indirizzo_estero) {
		this.flg_indirizzo_estero = flg_indirizzo_estero;
	}
	public String getStato_estero() {
		return stato_estero;
	}
	public void setStato_estero(String stato_estero) {
		this.stato_estero = stato_estero;
	}
	public String getIndirizzo_estero() {
		return indirizzo_estero;
	}
	public void setIndirizzo_estero(String indirizzo_estero) {
		this.indirizzo_estero = indirizzo_estero;
	}
	public String getCap_estero() {
		return cap_estero;
	}
	public void setCap_estero(String cap_estero) {
		this.cap_estero = cap_estero;
	}
	public Integer getFk_stato_pg() {
		return fk_stato_pg;
	}
	public void setFk_stato_pg(Integer fk_stato_pg) {
		this.fk_stato_pg = fk_stato_pg;
	}
	public Date getDt_agg_dichiarazione() {
		return dt_agg_dichiarazione;
	}
	public void setDt_agg_dichiarazione(Date dt_agg_dichiarazione) {
		this.dt_agg_dichiarazione = dt_agg_dichiarazione;
	}
	public Integer getFlg_dm37_letterac() {
		return flg_dm37_letterac;
	}
	public void setFlg_dm37_letterac(Integer flg_dm37_letterac) {
		this.flg_dm37_letterac = flg_dm37_letterac;
	}
	public Integer getFlg_dm37_letterad() {
		return flg_dm37_letterad;
	}
	public void setFlg_dm37_letterad(Integer flg_dm37_letterad) {
		this.flg_dm37_letterad = flg_dm37_letterad;
	}
	public Integer getFlg_dm37_letterae() {
		return flg_dm37_letterae;
	}
	public void setFlg_dm37_letterae(Integer flg_dm37_letterae) {
		this.flg_dm37_letterae = flg_dm37_letterae;
	}
	public Integer getFlg_fgas() {
		return flg_fgas;
	}
	public void setFlg_fgas(Integer flg_fgas) {
		this.flg_fgas = flg_fgas;
	}
	public Integer getFlg_conduttore() {
		return flg_conduttore;
	}
	public void setFlg_conduttore(Integer flg_conduttore) {
		this.flg_conduttore = flg_conduttore;
	}
	public Integer getFlg_sogg_incaricato() {
		return flg_sogg_incaricato;
	}
	public void setFlg_sogg_incaricato(Integer flg_sogg_incaricato) {
		this.flg_sogg_incaricato = flg_sogg_incaricato;
	}
	public Date getData_fine_legame() {
		return data_fine_legame;
	}
	public void setData_fine_legame(Date data_fine_legame) {
		this.data_fine_legame = data_fine_legame;
	}
	public Integer getFlg_delega() {
		return flg_delega;
	}
	public void setFlg_delega(Integer flg_delega) {
		this.flg_delega = flg_delega;
	}
	public String getDelega_sogg_incaricato() {
		return delega_sogg_incaricato;
	}
	public void setDelega_sogg_incaricato(String delega_sogg_incaricato) {
		this.delega_sogg_incaricato = delega_sogg_incaricato;
	}
	public String getPec() {
		return pec;
	}
	public void setPec(String pec) {
		this.pec = pec;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getDt_creazione_token() {
		return dt_creazione_token;
	}
	public void setDt_creazione_token(Date dt_creazione_token) {
		this.dt_creazione_token = dt_creazione_token;
	}
	public Date getDt_scadenza_token() {
		return dt_scadenza_token;
	}
	public void setDt_scadenza_token(Date dt_scadenza_token) {
		this.dt_scadenza_token = dt_scadenza_token;
	}
	public String getCitta_estero() {
		return citta_estero;
	}
	public void setCitta_estero(String citta_estero) {
		this.citta_estero = citta_estero;
	}
	
	
	
	
	
}
