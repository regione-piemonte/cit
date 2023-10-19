package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

/**
 * Data transfer object relativo al DAO SigitVAllegatiComponentiDao.
 * @generated
 */
public class SigitVAllegatiComponentiDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_ALLEGATO
	 * @generated
	 */
	protected java.math.BigDecimal idAllegato;

	/**
	 * Imposta il valore della proprieta' idAllegato associata alla
	 * colonna ID_ALLEGATO.
	 * @generated
	 */
	public void setIdAllegato(java.math.BigDecimal val) {

		idAllegato = val;

	}

	/**
	 * Legge il valore della proprieta' idAllegato associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdAllegato() {

		return idAllegato;

	}

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_COMPONENTE
	 * @generated
	 */
	protected String idTipoComponente;

	/**
	 * Imposta il valore della proprieta' idTipoComponente associata alla
	 * colonna ID_TIPO_COMPONENTE.
	 * @generated
	 */
	public void setIdTipoComponente(String val) {

		idTipoComponente = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoComponente associata alla
	 * @generated
	 */
	public String getIdTipoComponente() {

		return idTipoComponente;

	}

	/**
	 * store della proprieta' associata alla colonna PROGRESSIVO
	 * @generated
	 */
	protected java.math.BigDecimal progressivo;

	/**
	 * Imposta il valore della proprieta' progressivo associata alla
	 * colonna PROGRESSIVO.
	 * @generated
	 */
	public void setProgressivo(java.math.BigDecimal val) {

		progressivo = val;

	}

	/**
	 * Legge il valore della proprieta' progressivo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getProgressivo() {

		return progressivo;

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
	 * store della proprieta' associata alla colonna DATA_INSTALL
	 * @generated
	 */
	protected java.sql.Date dataInstall;

	/**
	 * Imposta il valore della proprieta' dataInstall associata alla
	 * colonna DATA_INSTALL.
	 * @generated
	 */
	public void setDataInstall(java.sql.Date val) {

		if (val != null) {
			dataInstall = new java.sql.Date(val.getTime());
		} else {
			dataInstall = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInstall associata alla
	 * @generated
	 */
	public java.sql.Date getDataInstall() {

		if (dataInstall != null) {
			return new java.sql.Date(dataInstall.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna FK_IMP_RUOLO_PFPG
	 * @generated
	 */
	protected java.math.BigDecimal fkImpRuoloPfpg;

	/**
	 * Imposta il valore della proprieta' fkImpRuoloPfpg associata alla
	 * colonna FK_IMP_RUOLO_PFPG.
	 * @generated
	 */
	public void setFkImpRuoloPfpg(java.math.BigDecimal val) {

		fkImpRuoloPfpg = val;

	}

	/**
	 * Legge il valore della proprieta' fkImpRuoloPfpg associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkImpRuoloPfpg() {

		return fkImpRuoloPfpg;

	}

	/**
	 * store della proprieta' associata alla colonna FK_CONTRATTO
	 * @generated
	 */
	protected java.math.BigDecimal fkContratto;

	/**
	 * Imposta il valore della proprieta' fkContratto associata alla
	 * colonna FK_CONTRATTO.
	 * @generated
	 */
	public void setFkContratto(java.math.BigDecimal val) {

		fkContratto = val;

	}

	/**
	 * Legge il valore della proprieta' fkContratto associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkContratto() {

		return fkContratto;

	}

	/**
	 * store della proprieta' associata alla colonna FK_STATO_RAPP
	 * @generated
	 */
	protected java.math.BigDecimal fkStatoRapp;

	/**
	 * Imposta il valore della proprieta' fkStatoRapp associata alla
	 * colonna FK_STATO_RAPP.
	 * @generated
	 */
	public void setFkStatoRapp(java.math.BigDecimal val) {

		fkStatoRapp = val;

	}

	/**
	 * Legge il valore della proprieta' fkStatoRapp associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkStatoRapp() {

		return fkStatoRapp;

	}

	/**
	 * store della proprieta' associata alla colonna DES_STATO_RAPP
	 * @generated
	 */
	protected String desStatoRapp;

	/**
	 * Imposta il valore della proprieta' desStatoRapp associata alla
	 * colonna DES_STATO_RAPP.
	 * @generated
	 */
	public void setDesStatoRapp(String val) {

		desStatoRapp = val;

	}

	/**
	 * Legge il valore della proprieta' desStatoRapp associata alla
	 * @generated
	 */
	public String getDesStatoRapp() {

		return desStatoRapp;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_CONTROLLO
	 * @generated
	 */
	protected java.sql.Date dataControllo;

	/**
	 * Imposta il valore della proprieta' dataControllo associata alla
	 * colonna DATA_CONTROLLO.
	 * @generated
	 */
	public void setDataControllo(java.sql.Date val) {

		if (val != null) {
			dataControllo = new java.sql.Date(val.getTime());
		} else {
			dataControllo = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataControllo associata alla
	 * @generated
	 */
	public java.sql.Date getDataControllo() {

		if (dataControllo != null) {
			return new java.sql.Date(dataControllo.getTime());
		} else {
			return null;
		}

	}

}
