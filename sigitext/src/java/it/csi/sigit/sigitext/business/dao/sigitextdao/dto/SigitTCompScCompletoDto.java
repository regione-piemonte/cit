package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

/**
 * Data transfer object relativo al DAO SigitTCompScDao.
 *
 * @generated
 */
public class SigitTCompScCompletoDto extends SigitTCompScPk {

	private static final long serialVersionUID = 1L;
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

	public String getUtenteUltMod() {

		return utenteUltMod;

	}

	protected java.math.BigDecimal fkMarca;

	public void setFkMarca(java.math.BigDecimal val) {

		fkMarca = val;

	}

	public java.math.BigDecimal getFkMarca() {

		return fkMarca;

	}

	protected String matricola;

	public void setMatricola(String val) {

		matricola = val;

	}

	public String getMatricola() {

		return matricola;

	}

	protected String modello;

	public void setModello(String val) {

		modello = val;

	}

	public String getModello() {

		return modello;

	}

	protected java.math.BigDecimal potenzaTermicaKw;

	public void setPotenzaTermicaKw(java.math.BigDecimal val) {

		potenzaTermicaKw = val;

	}

	public java.math.BigDecimal getPotenzaTermicaKw() {

		return potenzaTermicaKw;

	}

	protected String nomeProprietario;

	public void setNomeProprietario(String val) {

		nomeProprietario = val;

	}

	public String getNomeProprietario() {

		return nomeProprietario;

	}

	protected String cfProprietario;

	public void setCfProprietario(String val) {

		cfProprietario = val;

	}

	public String getCfProprietario() {

		return cfProprietario;

	}

	protected String note;

	public void setNote(String val) {

		note = val;

	}

	public String getNote() {

		return note;

	}

	protected java.math.BigDecimal tempoManutAnni;

	public void setTempoManutAnni(java.math.BigDecimal val) {

		tempoManutAnni = val;

	}

	public java.math.BigDecimal getTempoManutAnni() {

		return tempoManutAnni;

	}

	private String desMarca;

	public String getDesMarca() {
		return desMarca;
	}

	public void setDesMarca(String desMarca) {
		this.desMarca = desMarca;
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

	public SigitTCompScPk createPk() {
		return new SigitTCompScPk(idTipoComponente, progressivo, dataInstall, codiceImpianto);
	}

	public boolean equals(Object other) {
		return super.equals(other);
	}

	public int hashCode() {
		return super.hashCode();
	}

}
