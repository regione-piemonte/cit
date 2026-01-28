package it.csi.citpwa.model.sigitext;

import java.util.Date;
import java.util.List;

public class Scheda1 implements java.io.Serializable {
	
	static final long serialVersionUID = 1L;
	
	private int l1_2_flg_singola_unita;
	private String l1_2_fk_categoria;
	private Float l1_2_vol_risc_m3;
	private Float l1_2_vol_raff_m3;
	private Float l1_3_pot_h2o_kw;
	private Float l1_3_pot_clima_inv_kw;
	private Float l1_3_pot_clima_est_kw;
	private String l1_3_altro;
	private int l1_4_flg_h2o;
	private int l1_4_flg_aria;
	private String l1_4_altro;
	private int l1_5_flg_generatore;
	private int l1_5_flg_pompa;
	private int l1_5_flg_frigo;
	private int l1_5_flg_telerisc;
	private int l1_5_flg_teleraffr;
	private int l1_5_flg_cogeneratore;
	private String l1_5_altro;
	private int l1_5_sup_pannelli_sol_m2;
	private String l1_5_altro_integrazione;
	private Float l1_5_altro_integr_pot_kw;
	private int l1_5_flg_altro_clima_inv;
	private int l1_5_flg_altro_clima_estate;
	private int l1_5_flg_altro_acs;
	private String l1_5_altro_desc;
	private List<DatiAggiuntivi> datiAggiuntivi;
	private int fkTipoIntervento;
	private Date dataIntervento;
	
	public int getFkTipoIntervento() {
		return fkTipoIntervento;
	}
	
	public void setFkTipoIntervento(int fkTipoIntervento) {
		this.fkTipoIntervento = fkTipoIntervento;
	}
	
	public Date getDataIntervento() {
		return dataIntervento;
	}
	
	public void setDataIntervento(Date dataIntervento) {
		this.dataIntervento = dataIntervento;
	}
	
	public int getL1_2_flg_singola_unita() {
		return l1_2_flg_singola_unita;
	}
	
	public void setL1_2_flg_singola_unita(int l1_2_flg_singola_unita) {
		this.l1_2_flg_singola_unita = l1_2_flg_singola_unita;
	}
	
	public String getL1_2_fk_categoria() {
		return l1_2_fk_categoria;
	}
	
	public void setL1_2_fk_categoria(String l1_2_fk_categoria) {
		this.l1_2_fk_categoria = l1_2_fk_categoria;
	}
	
	public Float getL1_2_vol_risc_m3() {
		return l1_2_vol_risc_m3;
	}
	
	public void setL1_2_vol_risc_m3(Float l1_2_vol_risc_m3) {
		this.l1_2_vol_risc_m3 = l1_2_vol_risc_m3;
	}
	
	public Float getL1_2_vol_raff_m3() {
		return l1_2_vol_raff_m3;
	}
	
	public void setL1_2_vol_raff_m3(Float l1_2_vol_raff_m3) {
		this.l1_2_vol_raff_m3 = l1_2_vol_raff_m3;
	}
	
	public Float getL1_3_pot_h2o_kw() {
		return l1_3_pot_h2o_kw;
	}
	
	public void setL1_3_pot_h2o_kw(Float l1_3_pot_h2o_kw) {
		this.l1_3_pot_h2o_kw = l1_3_pot_h2o_kw;
	}
	
	public Float getL1_3_pot_clima_inv_kw() {
		return l1_3_pot_clima_inv_kw;
	}
	
	public void setL1_3_pot_clima_inv_kw(Float l1_3_pot_clima_inv_kw) {
		this.l1_3_pot_clima_inv_kw = l1_3_pot_clima_inv_kw;
	}
	
	public Float getL1_3_pot_clima_est_kw() {
		return l1_3_pot_clima_est_kw;
	}
	
	public void setL1_3_pot_clima_est_kw(Float l1_3_pot_clima_est_kw) {
		this.l1_3_pot_clima_est_kw = l1_3_pot_clima_est_kw;
	}
	
	public String getL1_3_altro() {
		return l1_3_altro;
	}
	
	public void setL1_3_altro(String l1_3_altro) {
		this.l1_3_altro = l1_3_altro;
	}
	
	public int getL1_4_flg_h2o() {
		return l1_4_flg_h2o;
	}
	
	public void setL1_4_flg_h2o(int l1_4_flg_h2o) {
		this.l1_4_flg_h2o = l1_4_flg_h2o;
	}
	
	public int getL1_4_flg_aria() {
		return l1_4_flg_aria;
	}
	
	public void setL1_4_flg_aria(int l1_4_flg_aria) {
		this.l1_4_flg_aria = l1_4_flg_aria;
	}
	
	public String getL1_4_altro() {
		return l1_4_altro;
	}
	
	public void setL1_4_altro(String l1_4_altro) {
		this.l1_4_altro = l1_4_altro;
	}
	
	public int getL1_5_flg_generatore() {
		return l1_5_flg_generatore;
	}
	
	public void setL1_5_flg_generatore(int l1_5_flg_generatore) {
		this.l1_5_flg_generatore = l1_5_flg_generatore;
	}
	
	public int getL1_5_flg_pompa() {
		return l1_5_flg_pompa;
	}
	
	public void setL1_5_flg_pompa(int l1_5_flg_pompa) {
		this.l1_5_flg_pompa = l1_5_flg_pompa;
	}
	
	public int getL1_5_flg_frigo() {
		return l1_5_flg_frigo;
	}
	
	public void setL1_5_flg_frigo(int l1_5_flg_frigo) {
		this.l1_5_flg_frigo = l1_5_flg_frigo;
	}
	
	public int getL1_5_flg_telerisc() {
		return l1_5_flg_telerisc;
	}
	
	public void setL1_5_flg_telerisc(int l1_5_flg_telerisc) {
		this.l1_5_flg_telerisc = l1_5_flg_telerisc;
	}
	
	public int getL1_5_flg_teleraffr() {
		return l1_5_flg_teleraffr;
	}
	
	public void setL1_5_flg_teleraffr(int l1_5_flg_teleraffr) {
		this.l1_5_flg_teleraffr = l1_5_flg_teleraffr;
	}
	
	public int getL1_5_flg_cogeneratore() {
		return l1_5_flg_cogeneratore;
	}
	
	public void setL1_5_flg_cogeneratore(int l1_5_flg_cogeneratore) {
		this.l1_5_flg_cogeneratore = l1_5_flg_cogeneratore;
	}
	
	public String getL1_5_altro() {
		return l1_5_altro;
	}
	
	public void setL1_5_altro(String l1_5_altro) {
		this.l1_5_altro = l1_5_altro;
	}
	
	public int getL1_5_sup_pannelli_sol_m2() {
		return l1_5_sup_pannelli_sol_m2;
	}
	
	public void setL1_5_sup_pannelli_sol_m2(int l1_5_sup_pannelli_sol_m2) {
		this.l1_5_sup_pannelli_sol_m2 = l1_5_sup_pannelli_sol_m2;
	}
	
	public String getL1_5_altro_integrazione() {
		return l1_5_altro_integrazione;
	}
	
	public void setL1_5_altro_integrazione(String l1_5_altro_integrazione) {
		this.l1_5_altro_integrazione = l1_5_altro_integrazione;
	}
	
	public Float getL1_5_altro_integr_pot_kw() {
		return l1_5_altro_integr_pot_kw;
	}
	
	public void setL1_5_altro_integr_pot_kw(Float l1_5_altro_integr_pot_kw) {
		this.l1_5_altro_integr_pot_kw = l1_5_altro_integr_pot_kw;
	}
	
	public int getL1_5_flg_altro_clima_inv() {
		return l1_5_flg_altro_clima_inv;
	}
	
	public void setL1_5_flg_altro_clima_inv(int l1_5_flg_altro_clima_inv) {
		this.l1_5_flg_altro_clima_inv = l1_5_flg_altro_clima_inv;
	}
	
	public int getL1_5_flg_altro_clima_estate() {
		return l1_5_flg_altro_clima_estate;
	}
	
	public void setL1_5_flg_altro_clima_estate(int l1_5_flg_altro_clima_estate) {
		this.l1_5_flg_altro_clima_estate = l1_5_flg_altro_clima_estate;
	}
	
	public int getL1_5_flg_altro_acs() {
		return l1_5_flg_altro_acs;
	}
	
	public void setL1_5_flg_altro_acs(int l1_5_flg_altro_acs) {
		this.l1_5_flg_altro_acs = l1_5_flg_altro_acs;
	}
	
	public String getL1_5_altro_desc() {
		return l1_5_altro_desc;
	}
	
	public void setL1_5_altro_desc(String l1_5_altro_desc) {
		this.l1_5_altro_desc = l1_5_altro_desc;
	}
	
	public List<DatiAggiuntivi> getDatiAggiuntivi() {
		return datiAggiuntivi;
	}
	
	public void setDatiAggiuntivi(List<DatiAggiuntivi> datiAggiuntivi) {
		this.datiAggiuntivi = datiAggiuntivi;
	}
	
	
	
}
