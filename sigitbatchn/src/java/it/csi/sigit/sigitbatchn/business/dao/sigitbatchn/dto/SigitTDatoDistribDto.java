package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTDatoDistribDao.
 * @generated
 */
public class SigitTDatoDistribDto extends SigitTDatoDistribPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_CONTRATTO
	 * @generated
	 */
	protected Integer fkTipoContratto;

	/**
	 * Imposta il valore della proprieta' fkTipoContratto associata alla
	 * colonna FK_TIPO_CONTRATTO.
	 * @generated
	 */
	public void setFkTipoContratto(Integer val) {

		fkTipoContratto = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoContratto associata alla
	 * @generated
	 */
	public Integer getFkTipoContratto() {

		return fkTipoContratto;

	}

	/**
	 * store della proprieta' associata alla colonna FK_IMPORT_DISTRIB
	 * @generated
	 */
	protected Integer fkImportDistrib;

	/**
	 * Imposta il valore della proprieta' fkImportDistrib associata alla
	 * colonna FK_IMPORT_DISTRIB.
	 * @generated
	 */
	public void setFkImportDistrib(Integer val) {

		fkImportDistrib = val;

	}

	/**
	 * Legge il valore della proprieta' fkImportDistrib associata alla
	 * @generated
	 */
	public Integer getFkImportDistrib() {

		return fkImportDistrib;

	}

	/**
	 * store della proprieta' associata alla colonna FK_CATEGORIA_UTIL
	 * @generated
	 */
	protected String fkCategoriaUtil;

	/**
	 * Imposta il valore della proprieta' fkCategoriaUtil associata alla
	 * colonna FK_CATEGORIA_UTIL.
	 * @generated
	 */
	public void setFkCategoriaUtil(String val) {

		fkCategoriaUtil = val;

	}

	/**
	 * Legge il valore della proprieta' fkCategoriaUtil associata alla
	 * @generated
	 */
	public String getFkCategoriaUtil() {

		return fkCategoriaUtil;

	}

	/**
	 * store della proprieta' associata alla colonna FK_COMBUSTIBILE
	 * @generated
	 */
	protected java.math.BigDecimal fkCombustibile;

	/**
	 * Imposta il valore della proprieta' fkCombustibile associata alla
	 * colonna FK_COMBUSTIBILE.
	 * @generated
	 */
	public void setFkCombustibile(java.math.BigDecimal val) {

		fkCombustibile = val;

	}

	/**
	 * Legge il valore della proprieta' fkCombustibile associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkCombustibile() {

		return fkCombustibile;

	}

	/**
	 * store della proprieta' associata alla colonna CODICE_ASSENZA_CATAST
	 * @generated
	 */
	protected Integer codiceAssenzaCatast;

	/**
	 * Imposta il valore della proprieta' codiceAssenzaCatast associata alla
	 * colonna CODICE_ASSENZA_CATAST.
	 * @generated
	 */
	public void setCodiceAssenzaCatast(Integer val) {

		codiceAssenzaCatast = val;

	}

	/**
	 * Legge il valore della proprieta' codiceAssenzaCatast associata alla
	 * @generated
	 */
	public Integer getCodiceAssenzaCatast() {

		return codiceAssenzaCatast;

	}

	/**
	 * store della proprieta' associata alla colonna FK_UNITA_MISURA
	 * @generated
	 */
	protected String fkUnitaMisura;

	/**
	 * Imposta il valore della proprieta' fkUnitaMisura associata alla
	 * colonna FK_UNITA_MISURA.
	 * @generated
	 */
	public void setFkUnitaMisura(String val) {

		fkUnitaMisura = val;

	}

	/**
	 * Legge il valore della proprieta' fkUnitaMisura associata alla
	 * @generated
	 */
	public String getFkUnitaMisura() {

		return fkUnitaMisura;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_PF_PG
	 * @generated
	 */
	protected String flgPfPg;

	/**
	 * Imposta il valore della proprieta' flgPfPg associata alla
	 * colonna FLG_PF_PG.
	 * @generated
	 */
	public void setFlgPfPg(String val) {

		flgPfPg = val;

	}

	/**
	 * Legge il valore della proprieta' flgPfPg associata alla
	 * @generated
	 */
	public String getFlgPfPg() {

		return flgPfPg;

	}

	/**
	 * store della proprieta' associata alla colonna COGNOME_DENOM
	 * @generated
	 */
	protected String cognomeDenom;

	/**
	 * Imposta il valore della proprieta' cognomeDenom associata alla
	 * colonna COGNOME_DENOM.
	 * @generated
	 */
	public void setCognomeDenom(String val) {

		cognomeDenom = val;

	}

	/**
	 * Legge il valore della proprieta' cognomeDenom associata alla
	 * @generated
	 */
	public String getCognomeDenom() {

		return cognomeDenom;

	}

	/**
	 * store della proprieta' associata alla colonna NOME
	 * @generated
	 */
	protected String nome;

	/**
	 * Imposta il valore della proprieta' nome associata alla
	 * colonna NOME.
	 * @generated
	 */
	public void setNome(String val) {

		nome = val;

	}

	/**
	 * Legge il valore della proprieta' nome associata alla
	 * @generated
	 */
	public String getNome() {

		return nome;

	}

	/**
	 * store della proprieta' associata alla colonna CF_PIVA
	 * @generated
	 */
	protected String cfPiva;

	/**
	 * Imposta il valore della proprieta' cfPiva associata alla
	 * colonna CF_PIVA.
	 * @generated
	 */
	public void setCfPiva(String val) {

		cfPiva = val;

	}

	/**
	 * Legge il valore della proprieta' cfPiva associata alla
	 * @generated
	 */
	public String getCfPiva() {

		return cfPiva;

	}

	/**
	 * store della proprieta' associata alla colonna ANNO_RIF
	 * @generated
	 */
	protected java.math.BigDecimal annoRif;

	/**
	 * Imposta il valore della proprieta' annoRif associata alla
	 * colonna ANNO_RIF.
	 * @generated
	 */
	public void setAnnoRif(java.math.BigDecimal val) {

		annoRif = val;

	}

	/**
	 * Legge il valore della proprieta' annoRif associata alla
	 * @generated
	 */
	public java.math.BigDecimal getAnnoRif() {

		return annoRif;

	}

	/**
	 * store della proprieta' associata alla colonna NR_MESI_FATTUR
	 * @generated
	 */
	protected java.math.BigDecimal nrMesiFattur;

	/**
	 * Imposta il valore della proprieta' nrMesiFattur associata alla
	 * colonna NR_MESI_FATTUR.
	 * @generated
	 */
	public void setNrMesiFattur(java.math.BigDecimal val) {

		nrMesiFattur = val;

	}

	/**
	 * Legge il valore della proprieta' nrMesiFattur associata alla
	 * @generated
	 */
	public java.math.BigDecimal getNrMesiFattur() {

		return nrMesiFattur;

	}

	/**
	 * store della proprieta' associata alla colonna DUG
	 * @generated
	 */
	protected String dug;

	/**
	 * Imposta il valore della proprieta' dug associata alla
	 * colonna DUG.
	 * @generated
	 */
	public void setDug(String val) {

		dug = val;

	}

	/**
	 * Legge il valore della proprieta' dug associata alla
	 * @generated
	 */
	public String getDug() {

		return dug;

	}

	/**
	 * store della proprieta' associata alla colonna INDIRIZZO
	 * @generated
	 */
	protected String indirizzo;

	/**
	 * Imposta il valore della proprieta' indirizzo associata alla
	 * colonna INDIRIZZO.
	 * @generated
	 */
	public void setIndirizzo(String val) {

		indirizzo = val;

	}

	/**
	 * Legge il valore della proprieta' indirizzo associata alla
	 * @generated
	 */
	public String getIndirizzo() {

		return indirizzo;

	}

	/**
	 * store della proprieta' associata alla colonna CIVICO
	 * @generated
	 */
	protected String civico;

	/**
	 * Imposta il valore della proprieta' civico associata alla
	 * colonna CIVICO.
	 * @generated
	 */
	public void setCivico(String val) {

		civico = val;

	}

	/**
	 * Legge il valore della proprieta' civico associata alla
	 * @generated
	 */
	public String getCivico() {

		return civico;

	}

	/**
	 * store della proprieta' associata alla colonna CAP
	 * @generated
	 */
	protected String cap;

	/**
	 * Imposta il valore della proprieta' cap associata alla
	 * colonna CAP.
	 * @generated
	 */
	public void setCap(String val) {

		cap = val;

	}

	/**
	 * Legge il valore della proprieta' cap associata alla
	 * @generated
	 */
	public String getCap() {

		return cap;

	}

	/**
	 * store della proprieta' associata alla colonna ISTAT_COMUNE
	 * @generated
	 */
	protected String istatComune;

	/**
	 * Imposta il valore della proprieta' istatComune associata alla
	 * colonna ISTAT_COMUNE.
	 * @generated
	 */
	public void setIstatComune(String val) {

		istatComune = val;

	}

	/**
	 * Legge il valore della proprieta' istatComune associata alla
	 * @generated
	 */
	public String getIstatComune() {

		return istatComune;

	}

	/**
	 * store della proprieta' associata alla colonna POD_PDR
	 * @generated
	 */
	protected String podPdr;

	/**
	 * Imposta il valore della proprieta' podPdr associata alla
	 * colonna POD_PDR.
	 * @generated
	 */
	public void setPodPdr(String val) {

		podPdr = val;

	}

	/**
	 * Legge il valore della proprieta' podPdr associata alla
	 * @generated
	 */
	public String getPodPdr() {

		return podPdr;

	}

	/**
	 * store della proprieta' associata alla colonna CONSUMO_ANNO
	 * @generated
	 */
	protected java.math.BigDecimal consumoAnno;

	/**
	 * Imposta il valore della proprieta' consumoAnno associata alla
	 * colonna CONSUMO_ANNO.
	 * @generated
	 */
	public void setConsumoAnno(java.math.BigDecimal val) {

		consumoAnno = val;

	}

	/**
	 * Legge il valore della proprieta' consumoAnno associata alla
	 * @generated
	 */
	public java.math.BigDecimal getConsumoAnno() {

		return consumoAnno;

	}

	/**
	 * store della proprieta' associata alla colonna CONSUMO_MENSILE
	 * @generated
	 */
	protected java.math.BigDecimal consumoMensile;

	/**
	 * Imposta il valore della proprieta' consumoMensile associata alla
	 * colonna CONSUMO_MENSILE.
	 * @generated
	 */
	public void setConsumoMensile(java.math.BigDecimal val) {

		consumoMensile = val;

	}

	/**
	 * Legge il valore della proprieta' consumoMensile associata alla
	 * @generated
	 */
	public java.math.BigDecimal getConsumoMensile() {

		return consumoMensile;

	}

	/**
	 * store della proprieta' associata alla colonna MESE_RIFERIMENTO
	 * @generated
	 */
	protected java.math.BigDecimal meseRiferimento;

	/**
	 * Imposta il valore della proprieta' meseRiferimento associata alla
	 * colonna MESE_RIFERIMENTO.
	 * @generated
	 */
	public void setMeseRiferimento(java.math.BigDecimal val) {

		meseRiferimento = val;

	}

	/**
	 * Legge il valore della proprieta' meseRiferimento associata alla
	 * @generated
	 */
	public java.math.BigDecimal getMeseRiferimento() {

		return meseRiferimento;

	}

	/**
	 * store della proprieta' associata alla colonna CONSUMO_GIORNALIERO
	 * @generated
	 */
	protected java.math.BigDecimal consumoGiornaliero;

	/**
	 * Imposta il valore della proprieta' consumoGiornaliero associata alla
	 * colonna CONSUMO_GIORNALIERO.
	 * @generated
	 */
	public void setConsumoGiornaliero(java.math.BigDecimal val) {

		consumoGiornaliero = val;

	}

	/**
	 * Legge il valore della proprieta' consumoGiornaliero associata alla
	 * @generated
	 */
	public java.math.BigDecimal getConsumoGiornaliero() {

		return consumoGiornaliero;

	}

	/**
	 * store della proprieta' associata alla colonna GIORNO_RIFERIMENTO
	 * @generated
	 */
	protected java.sql.Date giornoRiferimento;

	/**
	 * Imposta il valore della proprieta' giornoRiferimento associata alla
	 * colonna GIORNO_RIFERIMENTO.
	 * @generated
	 */
	public void setGiornoRiferimento(java.sql.Date val) {

		if (val != null) {
			giornoRiferimento = new java.sql.Date(val.getTime());
		} else {
			giornoRiferimento = null;
		}

	}

	/**
	 * Legge il valore della proprieta' giornoRiferimento associata alla
	 * @generated
	 */
	public java.sql.Date getGiornoRiferimento() {

		if (giornoRiferimento != null) {
			return new java.sql.Date(giornoRiferimento.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna VOLUMETRIA
	 * @generated
	 */
	protected java.math.BigDecimal volumetria;

	/**
	 * Imposta il valore della proprieta' volumetria associata alla
	 * colonna VOLUMETRIA.
	 * @generated
	 */
	public void setVolumetria(java.math.BigDecimal val) {

		volumetria = val;

	}

	/**
	 * Legge il valore della proprieta' volumetria associata alla
	 * @generated
	 */
	public java.math.BigDecimal getVolumetria() {

		return volumetria;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_PF_PG_FATT
	 * @generated
	 */
	protected String flgPfPgFatt;

	/**
	 * Imposta il valore della proprieta' flgPfPgFatt associata alla
	 * colonna FLG_PF_PG_FATT.
	 * @generated
	 */
	public void setFlgPfPgFatt(String val) {

		flgPfPgFatt = val;

	}

	/**
	 * Legge il valore della proprieta' flgPfPgFatt associata alla
	 * @generated
	 */
	public String getFlgPfPgFatt() {

		return flgPfPgFatt;

	}

	/**
	 * store della proprieta' associata alla colonna COGNOME_DENOM_FATT
	 * @generated
	 */
	protected String cognomeDenomFatt;

	/**
	 * Imposta il valore della proprieta' cognomeDenomFatt associata alla
	 * colonna COGNOME_DENOM_FATT.
	 * @generated
	 */
	public void setCognomeDenomFatt(String val) {

		cognomeDenomFatt = val;

	}

	/**
	 * Legge il valore della proprieta' cognomeDenomFatt associata alla
	 * @generated
	 */
	public String getCognomeDenomFatt() {

		return cognomeDenomFatt;

	}

	/**
	 * store della proprieta' associata alla colonna NOME_FATT
	 * @generated
	 */
	protected String nomeFatt;

	/**
	 * Imposta il valore della proprieta' nomeFatt associata alla
	 * colonna NOME_FATT.
	 * @generated
	 */
	public void setNomeFatt(String val) {

		nomeFatt = val;

	}

	/**
	 * Legge il valore della proprieta' nomeFatt associata alla
	 * @generated
	 */
	public String getNomeFatt() {

		return nomeFatt;

	}

	/**
	 * store della proprieta' associata alla colonna CF_PIVA_FATT
	 * @generated
	 */
	protected String cfPivaFatt;

	/**
	 * Imposta il valore della proprieta' cfPivaFatt associata alla
	 * colonna CF_PIVA_FATT.
	 * @generated
	 */
	public void setCfPivaFatt(String val) {

		cfPivaFatt = val;

	}

	/**
	 * Legge il valore della proprieta' cfPivaFatt associata alla
	 * @generated
	 */
	public String getCfPivaFatt() {

		return cfPivaFatt;

	}

	/**
	 * store della proprieta' associata alla colonna DUG_FATT
	 * @generated
	 */
	protected String dugFatt;

	/**
	 * Imposta il valore della proprieta' dugFatt associata alla
	 * colonna DUG_FATT.
	 * @generated
	 */
	public void setDugFatt(String val) {

		dugFatt = val;

	}

	/**
	 * Legge il valore della proprieta' dugFatt associata alla
	 * @generated
	 */
	public String getDugFatt() {

		return dugFatt;

	}

	/**
	 * store della proprieta' associata alla colonna INDIRIZZO_FATT
	 * @generated
	 */
	protected String indirizzoFatt;

	/**
	 * Imposta il valore della proprieta' indirizzoFatt associata alla
	 * colonna INDIRIZZO_FATT.
	 * @generated
	 */
	public void setIndirizzoFatt(String val) {

		indirizzoFatt = val;

	}

	/**
	 * Legge il valore della proprieta' indirizzoFatt associata alla
	 * @generated
	 */
	public String getIndirizzoFatt() {

		return indirizzoFatt;

	}

	/**
	 * store della proprieta' associata alla colonna CIVICO_FATT
	 * @generated
	 */
	protected String civicoFatt;

	/**
	 * Imposta il valore della proprieta' civicoFatt associata alla
	 * colonna CIVICO_FATT.
	 * @generated
	 */
	public void setCivicoFatt(String val) {

		civicoFatt = val;

	}

	/**
	 * Legge il valore della proprieta' civicoFatt associata alla
	 * @generated
	 */
	public String getCivicoFatt() {

		return civicoFatt;

	}

	/**
	 * store della proprieta' associata alla colonna CAP_FATT
	 * @generated
	 */
	protected String capFatt;

	/**
	 * Imposta il valore della proprieta' capFatt associata alla
	 * colonna CAP_FATT.
	 * @generated
	 */
	public void setCapFatt(String val) {

		capFatt = val;

	}

	/**
	 * Legge il valore della proprieta' capFatt associata alla
	 * @generated
	 */
	public String getCapFatt() {

		return capFatt;

	}

	/**
	 * store della proprieta' associata alla colonna ISTAT_COMUNE_FATT
	 * @generated
	 */
	protected String istatComuneFatt;

	/**
	 * Imposta il valore della proprieta' istatComuneFatt associata alla
	 * colonna ISTAT_COMUNE_FATT.
	 * @generated
	 */
	public void setIstatComuneFatt(String val) {

		istatComuneFatt = val;

	}

	/**
	 * Legge il valore della proprieta' istatComuneFatt associata alla
	 * @generated
	 */
	public String getIstatComuneFatt() {

		return istatComuneFatt;

	}

	/**
	 * Crea una istanza di SigitTDatoDistribPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTDatoDistribPk
	 * @generated
	 */
	public SigitTDatoDistribPk createPk() {
		return new SigitTDatoDistribPk(idDatoDistrib);
	}

	/**
	 * la semantica dell'equals del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * @param other l'oggetto con cui effettuare il confronto
	 * @return true se i due oggetti sono semanticamente da considerarsi uguali
	 */
	public boolean equals(Object other) {
		return super.equals(other);
	}

	/**
	 * la semantica dell'hashCode del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * 
	 * @return int
	 */
	public int hashCode() {
		return super.hashCode();
	}

}
