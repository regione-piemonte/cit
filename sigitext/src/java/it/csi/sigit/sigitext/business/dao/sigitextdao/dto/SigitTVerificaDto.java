package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

/**
 * Data transfer object relativo al DAO SigitTVerificaDao.
 * @generated
 */
public class SigitTVerificaDto extends SigitTVerificaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_VERIFICA
	 * @generated
	 */
	protected Integer fkTipoVerifica;

	/**
	 * Imposta il valore della proprieta' fkTipoVerifica associata alla
	 * colonna FK_TIPO_VERIFICA.
	 * @generated
	 */
	public void setFkTipoVerifica(Integer val) {

		fkTipoVerifica = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoVerifica associata alla
	 * @generated
	 */
	public Integer getFkTipoVerifica() {

		return fkTipoVerifica;

	}

	/**
	 * store della proprieta' associata alla colonna FK_ALLEGATO
	 * @generated
	 */
	protected java.math.BigDecimal fkAllegato;

	/**
	 * Imposta il valore della proprieta' fkAllegato associata alla
	 * colonna FK_ALLEGATO.
	 * @generated
	 */
	public void setFkAllegato(java.math.BigDecimal val) {

		fkAllegato = val;

	}

	/**
	 * Legge il valore della proprieta' fkAllegato associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkAllegato() {

		return fkAllegato;

	}

	/**
	 * store della proprieta' associata alla colonna FK_DATO_DISTRIB
	 * @generated
	 */
	protected Integer fkDatoDistrib;

	/**
	 * Imposta il valore della proprieta' fkDatoDistrib associata alla
	 * colonna FK_DATO_DISTRIB.
	 * @generated
	 */
	public void setFkDatoDistrib(Integer val) {

		fkDatoDistrib = val;

	}

	/**
	 * Legge il valore della proprieta' fkDatoDistrib associata alla
	 * @generated
	 */
	public Integer getFkDatoDistrib() {

		return fkDatoDistrib;

	}

	/**
	 * store della proprieta' associata alla colonna CODICE_IMPIANTO
	 * @generated
	 */
	protected java.math.BigDecimal codiceImpianto;

	/**
	 * Imposta il valore della proprieta' codiceImpianto associata alla
	 * colonna CODICE_IMPIANTO.
	 * @generated
	 */
	public void setCodiceImpianto(java.math.BigDecimal val) {

		codiceImpianto = val;

	}

	/**
	 * Legge il valore della proprieta' codiceImpianto associata alla
	 * @generated
	 */
	public java.math.BigDecimal getCodiceImpianto() {

		return codiceImpianto;

	}

	/**
	 * store della proprieta' associata alla colonna CF_UTENTE_CARICAMENTO
	 * @generated
	 */
	protected String cfUtenteCaricamento;

	/**
	 * Imposta il valore della proprieta' cfUtenteCaricamento associata alla
	 * colonna CF_UTENTE_CARICAMENTO.
	 * @generated
	 */
	public void setCfUtenteCaricamento(String val) {

		cfUtenteCaricamento = val;

	}

	/**
	 * Legge il valore della proprieta' cfUtenteCaricamento associata alla
	 * @generated
	 */
	public String getCfUtenteCaricamento() {

		return cfUtenteCaricamento;

	}

	/**
	 * store della proprieta' associata alla colonna DENOM_UTENTE_CARICAMENTO
	 * @generated
	 */
	protected String denomUtenteCaricamento;

	/**
	 * Imposta il valore della proprieta' denomUtenteCaricamento associata alla
	 * colonna DENOM_UTENTE_CARICAMENTO.
	 * @generated
	 */
	public void setDenomUtenteCaricamento(String val) {

		denomUtenteCaricamento = val;

	}

	/**
	 * Legge il valore della proprieta' denomUtenteCaricamento associata alla
	 * @generated
	 */
	public String getDenomUtenteCaricamento() {

		return denomUtenteCaricamento;

	}

	/**
	 * store della proprieta' associata alla colonna DT_CARICAMENTO
	 * @generated
	 */
	protected java.sql.Date dtCaricamento;

	/**
	 * Imposta il valore della proprieta' dtCaricamento associata alla
	 * colonna DT_CARICAMENTO.
	 * @generated
	 */
	public void setDtCaricamento(java.sql.Date val) {

		if (val != null) {
			dtCaricamento = new java.sql.Date(val.getTime());
		} else {
			dtCaricamento = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtCaricamento associata alla
	 * @generated
	 */
	public java.sql.Date getDtCaricamento() {

		if (dtCaricamento != null) {
			return new java.sql.Date(dtCaricamento.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna SIGLA_BOLLINO
	 * @generated
	 */
	protected String siglaBollino;

	/**
	 * Imposta il valore della proprieta' siglaBollino associata alla
	 * colonna SIGLA_BOLLINO.
	 * @generated
	 */
	public void setSiglaBollino(String val) {

		siglaBollino = val;

	}

	/**
	 * Legge il valore della proprieta' siglaBollino associata alla
	 * @generated
	 */
	public String getSiglaBollino() {

		return siglaBollino;

	}

	/**
	 * store della proprieta' associata alla colonna NUMERO_BOLLINO
	 * @generated
	 */
	protected java.math.BigDecimal numeroBollino;

	/**
	 * Imposta il valore della proprieta' numeroBollino associata alla
	 * colonna NUMERO_BOLLINO.
	 * @generated
	 */
	public void setNumeroBollino(java.math.BigDecimal val) {

		numeroBollino = val;

	}

	/**
	 * Legge il valore della proprieta' numeroBollino associata alla
	 * @generated
	 */
	public java.math.BigDecimal getNumeroBollino() {

		return numeroBollino;

	}

	/**
	 * store della proprieta' associata alla colonna DT_SVEGLIA
	 * @generated
	 */
	protected java.sql.Date dtSveglia;

	/**
	 * Imposta il valore della proprieta' dtSveglia associata alla
	 * colonna DT_SVEGLIA.
	 * @generated
	 */
	public void setDtSveglia(java.sql.Date val) {

		if (val != null) {
			dtSveglia = new java.sql.Date(val.getTime());
		} else {
			dtSveglia = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtSveglia associata alla
	 * @generated
	 */
	public java.sql.Date getDtSveglia() {

		if (dtSveglia != null) {
			return new java.sql.Date(dtSveglia.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna NOTE_SVEGLIA
	 * @generated
	 */
	protected String noteSveglia;

	/**
	 * Imposta il valore della proprieta' noteSveglia associata alla
	 * colonna NOTE_SVEGLIA.
	 * @generated
	 */
	public void setNoteSveglia(String val) {

		noteSveglia = val;

	}

	/**
	 * Legge il valore della proprieta' noteSveglia associata alla
	 * @generated
	 */
	public String getNoteSveglia() {

		return noteSveglia;

	}

	/**
	 * store della proprieta' associata alla colonna NOTE
	 * @generated
	 */
	protected String note;

	/**
	 * Imposta il valore della proprieta' note associata alla
	 * colonna NOTE.
	 * @generated
	 */
	public void setNote(String val) {

		note = val;

	}

	/**
	 * Legge il valore della proprieta' note associata alla
	 * @generated
	 */
	public String getNote() {

		return note;

	}

	/**
	 * Crea una istanza di SigitTVerificaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTVerificaPk
	 * @generated
	 */
	public SigitTVerificaPk createPk() {
		return new SigitTVerificaPk(idVerifica);
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
