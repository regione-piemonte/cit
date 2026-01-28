package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;
import java.util.List;

public class DatiFornitura implements Serializable {
	
	private Integer id_dato_distrib;
	private Integer fk_tipo_contratto;
	private Integer fk_import_distrib;
	private String fk_categoria_util;
	private Integer fk_combustibile;
	private String des_combustibile;
	private Integer fk_unita_misura;
	private String des_unita_misura;
	private String flg_pf_pg;
	private String cognome_denom;
	private String nome;
	private String cf_piva;
	private String anno_rif;
	private Integer nr_mesi_fattur;
	private String dug;
	private String indirizzo;
	private String civico;
	private String cap;
	private String istat_comune;
	private String des_comune;
	private String consumo_anno;
  
	private String flg_pf_pg_fatt;
	private String cognome_denom_fatt;
	private String nome_fatt;
	private String cf_piva_fatt;
	private String dug_fatt;
	private String indirizzo_fatt;
	private String civico_fatt;
	private String cap_fatt;
	private String istat_comune_fatt;

	private Integer codice_impianto;

	private List<LogDatiFornitura> logDatiFornitura;

	public Integer getId_dato_distrib() {
		return id_dato_distrib;
	}

	public void setId_dato_distrib(Integer id_dato_distrib) {
		this.id_dato_distrib = id_dato_distrib;
	}

	public Integer getFk_import_distrib() {
		return fk_import_distrib;
	}

	public void setFk_import_distrib(Integer fk_import_distrib) {
		this.fk_import_distrib = fk_import_distrib;
	}

	public Integer getFk_combustibile() {
		return fk_combustibile;
	}

	public void setFk_combustibile(Integer fk_combustibile) {
		this.fk_combustibile = fk_combustibile;
	}

	public String getDes_combustibile() {
		return des_combustibile;
	}

	public void setDes_combustibile(String des_combustibile) {
		this.des_combustibile = des_combustibile;
	}

	public Integer getFk_unita_misura() {
		return fk_unita_misura;
	}

	public void setFk_unita_misura(Integer fk_unita_misura) {
		this.fk_unita_misura = fk_unita_misura;
	}

	public String getDes_unita_misura() {
		return des_unita_misura;
	}

	public void setDes_unita_misura(String des_unita_misura) {
		this.des_unita_misura = des_unita_misura;
	}

	public String getFlg_pf_pg() {
		return flg_pf_pg;
	}

	public void setFlg_pf_pg(String flg_pf_pg) {
		this.flg_pf_pg = flg_pf_pg;
	}

	public String getCognome_denom() {
		return cognome_denom;
	}

	public void setCognome_denom(String cognome_denom) {
		this.cognome_denom = cognome_denom;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCf_piva() {
		return cf_piva;
	}

	public void setCf_piva(String cf_piva) {
		this.cf_piva = cf_piva;
	}

	public String getAnno_rif() {
		return anno_rif;
	}

	public void setAnno_rif(String anno_rif) {
		this.anno_rif = anno_rif;
	}

	public Integer getNr_mesi_fattur() {
		return nr_mesi_fattur;
	}

	public void setNr_mesi_fattur(Integer nr_mesi_fattur) {
		this.nr_mesi_fattur = nr_mesi_fattur;
	}

	public String getDug() {
		return dug;
	}

	public void setDug(String dug) {
		this.dug = dug;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
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

	public String getIstat_comune() {
		return istat_comune;
	}

	public void setIstat_comune(String istat_comune) {
		this.istat_comune = istat_comune;
	}

	public String getDes_comune() {
		return des_comune;
	}

	public void setDes_comune(String des_comune) {
		this.des_comune = des_comune;
	}

	public String getConsumo_anno() {
		return consumo_anno;
	}

	public void setConsumo_anno(String consumo_anno) {
		this.consumo_anno = consumo_anno;
	}

	public String getFlg_pf_pg_fatt() {
		return flg_pf_pg_fatt;
	}

	public void setFlg_pf_pg_fatt(String flg_pf_pg_fatt) {
		this.flg_pf_pg_fatt = flg_pf_pg_fatt;
	}

	public String getCognome_denom_fatt() {
		return cognome_denom_fatt;
	}

	public void setCognome_denom_fatt(String cognome_denom_fatt) {
		this.cognome_denom_fatt = cognome_denom_fatt;
	}

	public String getNome_fatt() {
		return nome_fatt;
	}

	public void setNome_fatt(String nome_fatt) {
		this.nome_fatt = nome_fatt;
	}

	public String getCf_piva_fatt() {
		return cf_piva_fatt;
	}

	public void setCf_piva_fatt(String cf_piva_fatt) {
		this.cf_piva_fatt = cf_piva_fatt;
	}

	public String getDug_fatt() {
		return dug_fatt;
	}

	public void setDug_fatt(String dug_fatt) {
		this.dug_fatt = dug_fatt;
	}

	public String getIndirizzo_fatt() {
		return indirizzo_fatt;
	}

	public void setIndirizzo_fatt(String indirizzo_fatt) {
		this.indirizzo_fatt = indirizzo_fatt;
	}

	public String getCivico_fatt() {
		return civico_fatt;
	}

	public void setCivico_fatt(String civico_fatt) {
		this.civico_fatt = civico_fatt;
	}

	public String getCap_fatt() {
		return cap_fatt;
	}

	public void setCap_fatt(String cap_fatt) {
		this.cap_fatt = cap_fatt;
	}

	public String getIstat_comune_fatt() {
		return istat_comune_fatt;
	}

	public void setIstat_comune_fatt(String istat_comune_fatt) {
		this.istat_comune_fatt = istat_comune_fatt;
	}

	public Integer getCodice_impianto() {
		return codice_impianto;
	}

	public void setCodice_impianto(Integer codice_impianto) {
		this.codice_impianto = codice_impianto;
	}

	public List<LogDatiFornitura> getLogDatiFornitura() {
		return logDatiFornitura;
	}

	public void setLogDatiFornitura(List<LogDatiFornitura> logDatiFornitura) {
		this.logDatiFornitura = logDatiFornitura;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Integer getFk_tipo_contratto() {
		return fk_tipo_contratto;
	}

	public void setFk_tipo_contratto(Integer fk_tipo_contratto) {
		this.fk_tipo_contratto = fk_tipo_contratto;
	}

	public String getFk_categoria_util() {
		return fk_categoria_util;
	}

	public void setFk_categoria_util(String fk_categoria_util) {
		this.fk_categoria_util = fk_categoria_util;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	o	flg_pf_pg di tipo String (PF = Persona Fisica, PG = Persona Giuridica)
//	o	codice_impianto di tipo Int
//	o	fk_stato di tipo Int
//	o	des_stato di tipo String
//
//	o	id_dato_distrib di tipo Int
//	o	fk_stato_distrib di tipo Int (da SIGIT_T_IMPORT_DISTRIB)
//	o	fk_tipo_contratto di tipo Int
//	o	des_tipo_contratto_distrib di tipo String (decodifica su SIGIT_D_TIPO_CONTRATTO_DISTRIB)
//	o	id_import_distrib di tipo Int
//	o	fk_categoria_util di tipo String
//	o	des_categoria_util di tipo String (decodifica su SIGIT_D_CATEGORIA_UTIL)
//	o	fk_combustibile di tipo Int
//	o	des_combustibile di tipo String (decodifica su SIGIT_D_COMBUSTIBILE)
//	o	codice_assenza_catast di tipo String
//	o	des_assenza_catast di tipo String (decodifica su SIGIT_D_ASSENZA_CATAST)
//	o	fk_unita_misura di tipo Int
//	o	des_unita_misura di tipo String (decodifica su SIGIT_D_UNITA_MISURA)
//	o	cognome_denom di tipo String
//	o	nome di tipo String
//	o	cf_piva di tipo String
//	o	anno_rif di tipo String
//	o	nr_mesi_fattur di tipo Int
//	o	dug di tipo String
//	o	indirizzo di tipo String
//	o	civico di tipo String
//	o	cap di tipo String
//	o	istat_comune di tipo String
//	o	des_comune di tipo String
//	o	pod_pdr di tipo String
//	o	consumo_anno di tipoString
//	o	consumo_mensile di tipo String
//	o	mese_riferimento di tipo String
//	o	consumo_giornaliero di tipo String
//	o	giorno_riferimento di tipo Date
//	o	volumetria di tipo String
//	o	flg_pf_pg_fatt di tipo String
//	o	cognome_denom_fatt di tipo String
//	o	nome_fatt di tipo String
//	o	cf_piva_fatt di tipo String
//	o	dug_fatt di tipo String
//	o	indirizzo_fatt di tipo String
//	o	civico_fatt di tipo String
//	o	cap_fatt di tipo String
//	o	istat_comune_fatt di tipo String
//	o	des_comune_fatt di tipo String
}
