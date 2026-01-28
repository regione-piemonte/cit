package it.csi.sigit.combustypwabff.model.sigitext;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SigitextDatiImpresa {

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

}
