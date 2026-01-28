package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;
import java.math.BigDecimal;

public class DatiDistributore implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idDatoDistri;
	 private BigDecimal fkStatoDistrib;
	 private BigDecimal fkTipoContratto;
	 private String desTipoContrattoDistrib;
	 private BigDecimal idImportDistrib;
	 private String fkCategoriaUtil;
	 private String desCategoriaUtil;
	 private BigDecimal fkCombustibile;
	 private String desCombustibile;
	 private String codiceAssenzaCatast;
	 private String desAssenzaCatast;
	 private BigDecimal fkUnitaMisura;
	 private String desUnitaMisura;
	 private String flgPfPg;
	 private String cognomeDenom;
	 private String nome;
	 private String cfPiva;
	 private String annoRif;
	 private BigDecimal nrMesiFattur;
	 private String dug;
	 private String indirizzo;
	 private String civico;
	 private String cap;
	 private String istatComune;
	 private String podPdr;
	 private String consumoAnno;
	 private String consumoMensile;
	 private String meseRiferimento;
	 private String consumoGiornaliero;
	 private Long giornoRiferimento;
	 private String volumetria;
	 private String flgPfPgFatt;
	 private String cognomeDenomFatt;
	 private String nomeFatt;
	 private String cfPivaFatt;
	 private String dugFatt;
	 private String indirizzoFatt;
	 private String civicoFatt;
	 private String capFatt;
	 private String istatComuneFatt;
	 
	public BigDecimal getIdDatoDistri() {
		return idDatoDistri;
	}
	public void setIdDatoDistri(BigDecimal idDatoDistri) {
		this.idDatoDistri = idDatoDistri;
	}
	public BigDecimal getFkStatoDistrib() {
		return fkStatoDistrib;
	}
	public void setFkStatoDistrib(BigDecimal fkStatoDistrib) {
		this.fkStatoDistrib = fkStatoDistrib;
	}
	public BigDecimal getFkTipoContratto() {
		return fkTipoContratto;
	}
	public void setFkTipoContratto(BigDecimal fkTipoContratto) {
		this.fkTipoContratto = fkTipoContratto;
	}
	public String getDesTipoContrattoDistrib() {
		return desTipoContrattoDistrib;
	}
	public void setDesTipoContrattoDistrib(String desTipoContrattoDistrib) {
		this.desTipoContrattoDistrib = desTipoContrattoDistrib;
	}
	public BigDecimal getIdImportDistrib() {
		return idImportDistrib;
	}
	public void setIdImportDistrib(BigDecimal idImportDistrib) {
		this.idImportDistrib = idImportDistrib;
	}
	public String getFkCategoriaUtil() {
		return fkCategoriaUtil;
	}
	public void setFkCategoriaUtil(String fkCategoriaUtil) {
		this.fkCategoriaUtil = fkCategoriaUtil;
	}
	public String getDesCategoriaUtil() {
		return desCategoriaUtil;
	}
	public void setDesCategoriaUtil(String desCategoriaUtil) {
		this.desCategoriaUtil = desCategoriaUtil;
	}
	public BigDecimal getFkCombustibile() {
		return fkCombustibile;
	}
	public void setFkCombustibile(BigDecimal fkCombustibile) {
		this.fkCombustibile = fkCombustibile;
	}
	public String getDesCombustibile() {
		return desCombustibile;
	}
	public void setDesCombustibile(String desCombustibile) {
		this.desCombustibile = desCombustibile;
	}
	public String getCodiceAssenzaCatast() {
		return codiceAssenzaCatast;
	}
	public void setCodiceAssenzaCatast(String codiceAssenzaCatast) {
		this.codiceAssenzaCatast = codiceAssenzaCatast;
	}
	public String getDesAssenzaCatast() {
		return desAssenzaCatast;
	}
	public void setDesAssenzaCatast(String desAssenzaCatast) {
		this.desAssenzaCatast = desAssenzaCatast;
	}
	public BigDecimal getFkUnitaMisura() {
		return fkUnitaMisura;
	}
	public void setFkUnitaMisura(BigDecimal fkUnitaMisura) {
		this.fkUnitaMisura = fkUnitaMisura;
	}
	public String getDesUnitaMisura() {
		return desUnitaMisura;
	}
	public void setDesUnitaMisura(String desUnitaMisura) {
		this.desUnitaMisura = desUnitaMisura;
	}
	public String getFlgPfPg() {
		return flgPfPg;
	}
	public void setFlgPfPg(String flgPfPg) {
		this.flgPfPg = flgPfPg;
	}
	public String getCognomeDenom() {
		return cognomeDenom;
	}
	public void setCognomeDenom(String cognomeDenom) {
		this.cognomeDenom = cognomeDenom;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCfPiva() {
		return cfPiva;
	}
	public void setCfPiva(String cfPiva) {
		this.cfPiva = cfPiva;
	}
	public String getAnnoRif() {
		return annoRif;
	}
	public void setAnnoRif(String annoRif) {
		this.annoRif = annoRif;
	}
	public BigDecimal getNrMesiFattur() {
		return nrMesiFattur;
	}
	public void setNrMesiFattur(BigDecimal nrMesiFattur) {
		this.nrMesiFattur = nrMesiFattur;
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
	public String getIstatComune() {
		return istatComune;
	}
	public void setIstatComune(String istatComune) {
		this.istatComune = istatComune;
	}
	public String getPodPdr() {
		return podPdr;
	}
	public void setPodPdr(String podPdr) {
		this.podPdr = podPdr;
	}
	public String getConsumoAnno() {
		return consumoAnno;
	}
	public void setConsumoAnno(String consumoAnno) {
		this.consumoAnno = consumoAnno;
	}
	public String getConsumoMensile() {
		return consumoMensile;
	}
	public void setConsumoMensile(String consumoMensile) {
		this.consumoMensile = consumoMensile;
	}
	public String getMeseRiferimento() {
		return meseRiferimento;
	}
	public void setMeseRiferimento(String meseRiferimento) {
		this.meseRiferimento = meseRiferimento;
	}
	public String getConsumoGiornaliero() {
		return consumoGiornaliero;
	}
	public void setConsumoGiornaliero(String consumoGiornaliero) {
		this.consumoGiornaliero = consumoGiornaliero;
	}
	public Long getGiornoRiferimento() {
		return giornoRiferimento;
	}
	public void setGiornoRiferimento(Long giornoRiferimento) {
		this.giornoRiferimento = giornoRiferimento;
	}
	public String getVolumetria() {
		return volumetria;
	}
	public void setVolumetria(String volumetria) {
		this.volumetria = volumetria;
	}
	public String getFlgPfPgFatt() {
		return flgPfPgFatt;
	}
	public void setFlgPfPgFatt(String flgPfPgFatt) {
		this.flgPfPgFatt = flgPfPgFatt;
	}
	public String getCognomeDenomFatt() {
		return cognomeDenomFatt;
	}
	public void setCognomeDenomFatt(String cognomeDenomFatt) {
		this.cognomeDenomFatt = cognomeDenomFatt;
	}
	public String getNomeFatt() {
		return nomeFatt;
	}
	public void setNomeFatt(String nomeFatt) {
		this.nomeFatt = nomeFatt;
	}
	public String getCfPivaFatt() {
		return cfPivaFatt;
	}
	public void setCfPivaFatt(String cfPivaFatt) {
		this.cfPivaFatt = cfPivaFatt;
	}
	public String getDugFatt() {
		return dugFatt;
	}
	public void setDugFatt(String dugFatt) {
		this.dugFatt = dugFatt;
	}
	public String getIndirizzoFatt() {
		return indirizzoFatt;
	}
	public void setIndirizzoFatt(String indirizzoFatt) {
		this.indirizzoFatt = indirizzoFatt;
	}
	public String getCivicoFatt() {
		return civicoFatt;
	}
	public void setCivicoFatt(String civicoFatt) {
		this.civicoFatt = civicoFatt;
	}
	public String getCapFatt() {
		return capFatt;
	}
	public void setCapFatt(String capFatt) {
		this.capFatt = capFatt;
	}
	public String getIstatComuneFatt() {
		return istatComuneFatt;
	}
	public void setIstatComuneFatt(String istatComuneFatt) {
		this.istatComuneFatt = istatComuneFatt;
	}
	@Override
	public String toString() {
		return "DatiDistributore [idDatoDistri=" + idDatoDistri + ", fkStatoDistrib=" + fkStatoDistrib
				+ ", fkTipoContratto=" + fkTipoContratto + ", desTipoContrattoDistrib=" + desTipoContrattoDistrib
				+ ", idImportDistrib=" + idImportDistrib + ", fkCategoriaUtil=" + fkCategoriaUtil
				+ ", desCategoriaUtil=" + desCategoriaUtil + ", fkCombustibile=" + fkCombustibile + ", desCombustibile="
				+ desCombustibile + ", codiceAssenzaCatast=" + codiceAssenzaCatast + ", desAssenzaCatast="
				+ desAssenzaCatast + ", fkUnitaMisura=" + fkUnitaMisura + ", desUnitaMisura=" + desUnitaMisura
				+ ", flgPfPg=" + flgPfPg + ", cognomeDenom=" + cognomeDenom + ", nome=" + nome + ", cfPiva=" + cfPiva
				+ ", annoRif=" + annoRif + ", nrMesiFattur=" + nrMesiFattur + ", dug=" + dug + ", indirizzo="
				+ indirizzo + ", civico=" + civico + ", cap=" + cap + ", istatComune=" + istatComune + ", podPdr="
				+ podPdr + ", consumoAnno=" + consumoAnno + ", consumoMensile=" + consumoMensile + ", meseRiferimento="
				+ meseRiferimento + ", consumoGiornaliero=" + consumoGiornaliero + ", giornoRiferimento="
				+ giornoRiferimento + ", volumetria=" + volumetria + ", flgPfPgFatt=" + flgPfPgFatt
				+ ", cognomeDenomFatt=" + cognomeDenomFatt + ", nomeFatt=" + nomeFatt + ", cfPivaFatt=" + cfPivaFatt
				+ ", dugFatt=" + dugFatt + ", indirizzoFatt=" + indirizzoFatt + ", civicoFatt=" + civicoFatt
				+ ", capFatt=" + capFatt + ", istatComuneFatt=" + istatComuneFatt + "]";
	}
	 
	 

}
