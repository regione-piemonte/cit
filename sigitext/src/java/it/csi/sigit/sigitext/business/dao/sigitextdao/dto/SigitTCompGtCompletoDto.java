package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

public class SigitTCompGtCompletoDto extends SigitTCompGtPk {

	private static final long serialVersionUID = 1L;

	protected java.math.BigDecimal fkFluido;

	public void setFkFluido(java.math.BigDecimal val) {

		fkFluido = val;

	}

	public java.math.BigDecimal getFkFluido() {

		return fkFluido;

	}

	protected java.math.BigDecimal fkDettaglioGt;

	public void setFkDettaglioGt(java.math.BigDecimal val) {

		fkDettaglioGt = val;

	}

	public java.math.BigDecimal getFkDettaglioGt() {

		return fkDettaglioGt;

	}

	protected java.math.BigDecimal rendimentoPerc;

	public void setRendimentoPerc(java.math.BigDecimal val) {

		rendimentoPerc = val;

	}

	public java.math.BigDecimal getRendimentoPerc() {

		return rendimentoPerc;

	}

	protected java.math.BigDecimal nModuli;

	public void setNModuli(java.math.BigDecimal val) {

		nModuli = val;

	}

	public java.math.BigDecimal getNModuli() {

		return nModuli;

	}

	protected java.sql.Date dataDismiss;

	public void setDataDismiss(java.sql.Date val) {

		if (val != null) {
			dataDismiss = new java.sql.Date(val.getTime());
		} else {
			dataDismiss = null;
		}

	}

	public java.sql.Date getDataDismiss() {

		if (dataDismiss != null) {
			return new java.sql.Date(dataDismiss.getTime());
		} else {
			return null;
		}

	}

	protected java.math.BigDecimal flgDismissione;

	public void setFlgDismissione(java.math.BigDecimal val) {

		flgDismissione = val;

	}

	public java.math.BigDecimal getFlgDismissione() {

		return flgDismissione;

	}

	protected java.sql.Timestamp dataUltMod;

	public void setDataUltMod(java.sql.Timestamp val) {

		if (val != null) {
			dataUltMod = new java.sql.Timestamp(val.getTime());
		} else {
			dataUltMod = null;
		}

	}

	public java.sql.Timestamp getDataUltMod() {

		if (dataUltMod != null) {
			return new java.sql.Timestamp(dataUltMod.getTime());
		} else {
			return null;
		}

	}

	protected String utenteUltMod;

	public void setUtenteUltMod(String val) {

		utenteUltMod = val;

	}

	/**
	 * Legge il valore della proprieta' utenteUltMod associata alla
	 *
	 * @generated
	 */
	public String getUtenteUltMod() {

		return utenteUltMod;

	}

	/**
	 * store della proprieta' associata alla colonna FK_MARCA
	 *
	 * @generated
	 */
	protected java.math.BigDecimal fkMarca;

	/**
	 * Imposta il valore della proprieta' fkMarca associata alla
	 * colonna FK_MARCA.
	 *
	 * @generated
	 */
	public void setFkMarca(java.math.BigDecimal val) {

		fkMarca = val;

	}

	/**
	 * Legge il valore della proprieta' fkMarca associata alla
	 *
	 * @generated
	 */
	public java.math.BigDecimal getFkMarca() {

		return fkMarca;

	}

	protected String descMarca;
	protected String descFluido;
	protected String descDettaglioGt;
	protected String descCombustibile;

	public String getDescMarca() {
		return descMarca;
	}

	public void setDescMarca(String descMarca) {
		this.descMarca = descMarca;
	}

	public String getDescFluido() {
		return descFluido;
	}

	public void setDescFluido(String descFluido) {
		this.descFluido = descFluido;
	}

	public String getDescDettaglioGt() {
		return descDettaglioGt;
	}

	public void setDescDettaglioGt(String descDettaglioGt) {
		this.descDettaglioGt = descDettaglioGt;
	}

	public String getDescCombustibile() {
		return descCombustibile;
	}

	public void setDescCombustibile(String descCombustibile) {
		this.descCombustibile = descCombustibile;
	}

	/**
	 * store della proprieta' associata alla colonna FK_COMBUSTIBILE
	 *
	 * @generated
	 */
	protected java.math.BigDecimal fkCombustibile;

	/**
	 * Imposta il valore della proprieta' fkCombustibile associata alla
	 * colonna FK_COMBUSTIBILE.
	 *
	 * @generated
	 */
	public void setFkCombustibile(java.math.BigDecimal val) {

		fkCombustibile = val;

	}

	/**
	 * Legge il valore della proprieta' fkCombustibile associata alla
	 *
	 * @generated
	 */
	public java.math.BigDecimal getFkCombustibile() {

		return fkCombustibile;

	}

	/**
	 * store della proprieta' associata alla colonna MATRICOLA
	 *
	 * @generated
	 */
	protected String matricola;

	/**
	 * Imposta il valore della proprieta' matricola associata alla
	 * colonna MATRICOLA.
	 *
	 * @generated
	 */
	public void setMatricola(String val) {

		matricola = val;

	}

	/**
	 * Legge il valore della proprieta' matricola associata alla
	 *
	 * @generated
	 */
	public String getMatricola() {

		return matricola;

	}

	/**
	 * store della proprieta' associata alla colonna MODELLO
	 *
	 * @generated
	 */
	protected String modello;

	/**
	 * Imposta il valore della proprieta' modello associata alla
	 * colonna MODELLO.
	 *
	 * @generated
	 */
	public void setModello(String val) {

		modello = val;

	}

	/**
	 * Legge il valore della proprieta' modello associata alla
	 *
	 * @generated
	 */
	public String getModello() {

		return modello;

	}

	/**
	 * store della proprieta' associata alla colonna POTENZA_TERMICA_KW
	 *
	 * @generated
	 */
	protected java.math.BigDecimal potenzaTermicaKw;

	/**
	 * Imposta il valore della proprieta' potenzaTermicaKw associata alla
	 * colonna POTENZA_TERMICA_KW.
	 *
	 * @generated
	 */
	public void setPotenzaTermicaKw(java.math.BigDecimal val) {

		potenzaTermicaKw = val;

	}

	/**
	 * Legge il valore della proprieta' potenzaTermicaKw associata alla
	 *
	 * @generated
	 */
	public java.math.BigDecimal getPotenzaTermicaKw() {

		return potenzaTermicaKw;

	}

	/**
	 * store della proprieta' associata alla colonna NOTE
	 *
	 * @generated
	 */
	protected String note;

	/**
	 * Imposta il valore della proprieta' note associata alla
	 * colonna NOTE.
	 *
	 * @generated
	 */
	public void setNote(String val) {

		note = val;

	}

	/**
	 * Legge il valore della proprieta' note associata alla
	 *
	 * @generated
	 */
	public String getNote() {

		return note;

	}

	/**
	 * store della proprieta' associata alla colonna TEMPO_MANUT_ANNI
	 *
	 * @generated
	 */
	protected java.math.BigDecimal tempoManutAnni;

	/**
	 * Imposta il valore della proprieta' tempoManutAnni associata alla
	 * colonna TEMPO_MANUT_ANNI.
	 *
	 * @generated
	 */
	public void setTempoManutAnni(java.math.BigDecimal val) {

		tempoManutAnni = val;

	}

	/**
	 * Legge il valore della proprieta' tempoManutAnni associata alla
	 *
	 * @generated
	 */
	public java.math.BigDecimal getTempoManutAnni() {

		return tempoManutAnni;

	}

	/**
	 * store della proprieta' associata alla colonna MEDI_IMP_ORE_OPERATIVE
	 *
	 * @generated
	 */
	protected java.math.BigDecimal mediImpOreOperative;

	/**
	 * Imposta il valore della proprieta' mediImpOreOperative associata alla
	 * colonna MEDI_IMP_ORE_OPERATIVE.
	 *
	 * @generated
	 */
	public void setMediImpOreOperative(java.math.BigDecimal val) {

		mediImpOreOperative = val;

	}

	/**
	 * Legge il valore della proprieta' mediImpOreOperative associata alla
	 *
	 * @generated
	 */
	public java.math.BigDecimal getMediImpOreOperative() {

		return mediImpOreOperative;

	}

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_CANNA_FUMARIA
	 *
	 * @generated
	 */
	protected java.math.BigDecimal idTipoCannaFumaria;

	/**
	 * Imposta il valore della proprieta' idTipoCannaFumaria associata alla
	 * colonna ID_TIPO_CANNA_FUMARIA.
	 *
	 * @generated
	 */
	public void setIdTipoCannaFumaria(java.math.BigDecimal val) {

		idTipoCannaFumaria = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoCannaFumaria associata alla
	 *
	 * @generated
	 */
	public java.math.BigDecimal getIdTipoCannaFumaria() {

		return idTipoCannaFumaria;

	}

	private String cf;

	private String siglaRea;

	private String numeroRea;

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getSiglaRea() {
		return siglaRea;
	}

	public void setSiglaRea(String siglaRea) {
		this.siglaRea = siglaRea;
	}

	public String getNumeroRea() {
		return numeroRea;
	}

	public void setNumeroRea(String numeroRea) {
		this.numeroRea = numeroRea;
	}

	/**
	 * Crea una istanza di SigitTCompGtPk a partire dal valore dei campi chiave del DTO
	 *
	 * @return SigitTCompGtPk
	 * @generated
	 */
	public SigitTCompGtPk createPk() {
		return new SigitTCompGtPk(idTipoComponente, progressivo, dataInstall, codiceImpianto);
	}

	/**
	 * la semantica dell'equals del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 *
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

	@Override
	public String toString() {
		return "SigitTCompGtCompletoDto{" + "fkFluido=" + fkFluido + ", fkDettaglioGt=" + fkDettaglioGt + ", rendimentoPerc=" + rendimentoPerc + ", nModuli=" + nModuli + ", dataDismiss=" + dataDismiss
				+ ", flgDismissione=" + flgDismissione + ", dataUltMod=" + dataUltMod + ", utenteUltMod='" + utenteUltMod + '\'' + ", fkMarca=" + fkMarca + ", descMarca='" + descMarca + '\''
				+ ", descFluido='" + descFluido + '\'' + ", descDettaglioGt='" + descDettaglioGt + '\'' + ", descCombustibile='" + descCombustibile + '\'' + ", fkCombustibile=" + fkCombustibile
				+ ", matricola='" + matricola + '\'' + ", modello='" + modello + '\'' + ", potenzaTermicaKw=" + potenzaTermicaKw + ", note='" + note + '\'' + ", tempoManutAnni=" + tempoManutAnni
				+ ", mediImpOreOperative=" + mediImpOreOperative + ", idTipoCannaFumaria=" + idTipoCannaFumaria + "} " + super.toString();
	}
}
