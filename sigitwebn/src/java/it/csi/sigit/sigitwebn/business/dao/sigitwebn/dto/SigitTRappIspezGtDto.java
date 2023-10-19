package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTRappIspezGtDao.
 * @generated
 */
public class SigitTRappIspezGtDto extends SigitTRappIspezGtPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna S1C_FLG_REE_INVIATO
	 * @generated
	 */
	protected java.math.BigDecimal s1cFlgReeInviato;

	/**
	 * Imposta il valore della proprieta' s1cFlgReeInviato associata alla
	 * colonna S1C_FLG_REE_INVIATO.
	 * @generated
	 */
	public void setS1cFlgReeInviato(java.math.BigDecimal val) {

		s1cFlgReeInviato = val;

	}

	/**
	 * Legge il valore della proprieta' s1cFlgReeInviato associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS1cFlgReeInviato() {

		return s1cFlgReeInviato;

	}

	/**
	 * store della proprieta' associata alla colonna S1C_FLG_REE_BOLLINO
	 * @generated
	 */
	protected java.math.BigDecimal s1cFlgReeBollino;

	/**
	 * Imposta il valore della proprieta' s1cFlgReeBollino associata alla
	 * colonna S1C_FLG_REE_BOLLINO.
	 * @generated
	 */
	public void setS1cFlgReeBollino(java.math.BigDecimal val) {

		s1cFlgReeBollino = val;

	}

	/**
	 * Legge il valore della proprieta' s1cFlgReeBollino associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS1cFlgReeBollino() {

		return s1cFlgReeBollino;

	}

	/**
	 * store della proprieta' associata alla colonna S1C_SIGLA_BOLLINO
	 * @generated
	 */
	protected String s1cSiglaBollino;

	/**
	 * Imposta il valore della proprieta' s1cSiglaBollino associata alla
	 * colonna S1C_SIGLA_BOLLINO.
	 * @generated
	 */
	public void setS1cSiglaBollino(String val) {

		s1cSiglaBollino = val;

	}

	/**
	 * Legge il valore della proprieta' s1cSiglaBollino associata alla
	 * @generated
	 */
	public String getS1cSiglaBollino() {

		return s1cSiglaBollino;

	}

	/**
	 * store della proprieta' associata alla colonna S1C_NUM_BOLLINO
	 * @generated
	 */
	protected java.math.BigDecimal s1cNumBollino;

	/**
	 * Imposta il valore della proprieta' s1cNumBollino associata alla
	 * colonna S1C_NUM_BOLLINO.
	 * @generated
	 */
	public void setS1cNumBollino(java.math.BigDecimal val) {

		s1cNumBollino = val;

	}

	/**
	 * Legge il valore della proprieta' s1cNumBollino associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS1cNumBollino() {

		return s1cNumBollino;

	}

	/**
	 * store della proprieta' associata alla colonna S1E_DT_PRIMA_INSTALLAZIONE
	 * @generated
	 */
	protected java.sql.Date s1eDtPrimaInstallazione;

	/**
	 * Imposta il valore della proprieta' s1eDtPrimaInstallazione associata alla
	 * colonna S1E_DT_PRIMA_INSTALLAZIONE.
	 * @generated
	 */
	public void setS1eDtPrimaInstallazione(java.sql.Date val) {

		if (val != null) {
			s1eDtPrimaInstallazione = new java.sql.Date(val.getTime());
		} else {
			s1eDtPrimaInstallazione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' s1eDtPrimaInstallazione associata alla
	 * @generated
	 */
	public java.sql.Date getS1eDtPrimaInstallazione() {

		if (s1eDtPrimaInstallazione != null) {
			return new java.sql.Date(s1eDtPrimaInstallazione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna S1E_POT_FOCOLARE_KW
	 * @generated
	 */
	protected java.math.BigDecimal s1ePotFocolareKw;

	/**
	 * Imposta il valore della proprieta' s1ePotFocolareKw associata alla
	 * colonna S1E_POT_FOCOLARE_KW.
	 * @generated
	 */
	public void setS1ePotFocolareKw(java.math.BigDecimal val) {

		s1ePotFocolareKw = val;

	}

	/**
	 * Legge il valore della proprieta' s1ePotFocolareKw associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS1ePotFocolareKw() {

		return s1ePotFocolareKw;

	}

	/**
	 * store della proprieta' associata alla colonna S1E_POT_UTILE_KW
	 * @generated
	 */
	protected java.math.BigDecimal s1ePotUtileKw;

	/**
	 * Imposta il valore della proprieta' s1ePotUtileKw associata alla
	 * colonna S1E_POT_UTILE_KW.
	 * @generated
	 */
	public void setS1ePotUtileKw(java.math.BigDecimal val) {

		s1ePotUtileKw = val;

	}

	/**
	 * Legge il valore della proprieta' s1ePotUtileKw associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS1ePotUtileKw() {

		return s1ePotUtileKw;

	}

	/**
	 * store della proprieta' associata alla colonna S1L_DENOM_DELEGATO
	 * @generated
	 */
	protected String s1lDenomDelegato;

	/**
	 * Imposta il valore della proprieta' s1lDenomDelegato associata alla
	 * colonna S1L_DENOM_DELEGATO.
	 * @generated
	 */
	public void setS1lDenomDelegato(String val) {

		s1lDenomDelegato = val;

	}

	/**
	 * Legge il valore della proprieta' s1lDenomDelegato associata alla
	 * @generated
	 */
	public String getS1lDenomDelegato() {

		return s1lDenomDelegato;

	}

	/**
	 * store della proprieta' associata alla colonna S1L_FLG_DELEGA
	 * @generated
	 */
	protected java.math.BigDecimal s1lFlgDelega;

	/**
	 * Imposta il valore della proprieta' s1lFlgDelega associata alla
	 * colonna S1L_FLG_DELEGA.
	 * @generated
	 */
	public void setS1lFlgDelega(java.math.BigDecimal val) {

		s1lFlgDelega = val;

	}

	/**
	 * Legge il valore della proprieta' s1lFlgDelega associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS1lFlgDelega() {

		return s1lFlgDelega;

	}

	/**
	 * store della proprieta' associata alla colonna S2B1_FLG_TERMO_CONTAB
	 * @generated
	 */
	protected java.math.BigDecimal s2b1FlgTermoContab;

	/**
	 * Imposta il valore della proprieta' s2b1FlgTermoContab associata alla
	 * colonna S2B1_FLG_TERMO_CONTAB.
	 * @generated
	 */
	public void setS2b1FlgTermoContab(java.math.BigDecimal val) {

		s2b1FlgTermoContab = val;

	}

	/**
	 * Legge il valore della proprieta' s2b1FlgTermoContab associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS2b1FlgTermoContab() {

		return s2b1FlgTermoContab;

	}

	/**
	 * store della proprieta' associata alla colonna S2B2_FLG_UNI_10200
	 * @generated
	 */
	protected java.math.BigDecimal s2b2FlgUni10200;

	/**
	 * Imposta il valore della proprieta' s2b2FlgUni10200 associata alla
	 * colonna S2B2_FLG_UNI_10200.
	 * @generated
	 */
	public void setS2b2FlgUni10200(java.math.BigDecimal val) {

		s2b2FlgUni10200 = val;

	}

	/**
	 * Legge il valore della proprieta' s2b2FlgUni10200 associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS2b2FlgUni10200() {

		return s2b2FlgUni10200;

	}

	/**
	 * store della proprieta' associata alla colonna S2F_FLG_TRATT_CLIMA_NON_RICH
	 * @generated
	 */
	protected java.math.BigDecimal s2fFlgTrattClimaNonRich;

	/**
	 * Imposta il valore della proprieta' s2fFlgTrattClimaNonRich associata alla
	 * colonna S2F_FLG_TRATT_CLIMA_NON_RICH.
	 * @generated
	 */
	public void setS2fFlgTrattClimaNonRich(java.math.BigDecimal val) {

		s2fFlgTrattClimaNonRich = val;

	}

	/**
	 * Legge il valore della proprieta' s2fFlgTrattClimaNonRich associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS2fFlgTrattClimaNonRich() {

		return s2fFlgTrattClimaNonRich;

	}

	/**
	 * store della proprieta' associata alla colonna S2F_FLG_TRATT_ACS_NON_RICH
	 * @generated
	 */
	protected java.math.BigDecimal s2fFlgTrattAcsNonRich;

	/**
	 * Imposta il valore della proprieta' s2fFlgTrattAcsNonRich associata alla
	 * colonna S2F_FLG_TRATT_ACS_NON_RICH.
	 * @generated
	 */
	public void setS2fFlgTrattAcsNonRich(java.math.BigDecimal val) {

		s2fFlgTrattAcsNonRich = val;

	}

	/**
	 * Legge il valore della proprieta' s2fFlgTrattAcsNonRich associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS2fFlgTrattAcsNonRich() {

		return s2fFlgTrattAcsNonRich;

	}

	/**
	 * store della proprieta' associata alla colonna S3A_FLG_LOCALE_INT_IDONEO
	 * @generated
	 */
	protected java.math.BigDecimal s3aFlgLocaleIntIdoneo;

	/**
	 * Imposta il valore della proprieta' s3aFlgLocaleIntIdoneo associata alla
	 * colonna S3A_FLG_LOCALE_INT_IDONEO.
	 * @generated
	 */
	public void setS3aFlgLocaleIntIdoneo(java.math.BigDecimal val) {

		s3aFlgLocaleIntIdoneo = val;

	}

	/**
	 * Legge il valore della proprieta' s3aFlgLocaleIntIdoneo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS3aFlgLocaleIntIdoneo() {

		return s3aFlgLocaleIntIdoneo;

	}

	/**
	 * store della proprieta' associata alla colonna S3B_FLG_GEN_EXT_IDONEO
	 * @generated
	 */
	protected java.math.BigDecimal s3bFlgGenExtIdoneo;

	/**
	 * Imposta il valore della proprieta' s3bFlgGenExtIdoneo associata alla
	 * colonna S3B_FLG_GEN_EXT_IDONEO.
	 * @generated
	 */
	public void setS3bFlgGenExtIdoneo(java.math.BigDecimal val) {

		s3bFlgGenExtIdoneo = val;

	}

	/**
	 * Legge il valore della proprieta' s3bFlgGenExtIdoneo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS3bFlgGenExtIdoneo() {

		return s3bFlgGenExtIdoneo;

	}

	/**
	 * store della proprieta' associata alla colonna S3C_FLG_VENTILAZ_SUFF
	 * @generated
	 */
	protected java.math.BigDecimal s3cFlgVentilazSuff;

	/**
	 * Imposta il valore della proprieta' s3cFlgVentilazSuff associata alla
	 * colonna S3C_FLG_VENTILAZ_SUFF.
	 * @generated
	 */
	public void setS3cFlgVentilazSuff(java.math.BigDecimal val) {

		s3cFlgVentilazSuff = val;

	}

	/**
	 * Legge il valore della proprieta' s3cFlgVentilazSuff associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS3cFlgVentilazSuff() {

		return s3cFlgVentilazSuff;

	}

	/**
	 * store della proprieta' associata alla colonna S3D_FLG_EVAC_FUMI_IDONEO
	 * @generated
	 */
	protected java.math.BigDecimal s3dFlgEvacFumiIdoneo;

	/**
	 * Imposta il valore della proprieta' s3dFlgEvacFumiIdoneo associata alla
	 * colonna S3D_FLG_EVAC_FUMI_IDONEO.
	 * @generated
	 */
	public void setS3dFlgEvacFumiIdoneo(java.math.BigDecimal val) {

		s3dFlgEvacFumiIdoneo = val;

	}

	/**
	 * Legge il valore della proprieta' s3dFlgEvacFumiIdoneo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS3dFlgEvacFumiIdoneo() {

		return s3dFlgEvacFumiIdoneo;

	}

	/**
	 * store della proprieta' associata alla colonna S3E_FLG_CARTELLI_PRESENTI
	 * @generated
	 */
	protected java.math.BigDecimal s3eFlgCartelliPresenti;

	/**
	 * Imposta il valore della proprieta' s3eFlgCartelliPresenti associata alla
	 * colonna S3E_FLG_CARTELLI_PRESENTI.
	 * @generated
	 */
	public void setS3eFlgCartelliPresenti(java.math.BigDecimal val) {

		s3eFlgCartelliPresenti = val;

	}

	/**
	 * Legge il valore della proprieta' s3eFlgCartelliPresenti associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS3eFlgCartelliPresenti() {

		return s3eFlgCartelliPresenti;

	}

	/**
	 * store della proprieta' associata alla colonna S3F_FLG_ESTINZ_PRESENTI
	 * @generated
	 */
	protected java.math.BigDecimal s3fFlgEstinzPresenti;

	/**
	 * Imposta il valore della proprieta' s3fFlgEstinzPresenti associata alla
	 * colonna S3F_FLG_ESTINZ_PRESENTI.
	 * @generated
	 */
	public void setS3fFlgEstinzPresenti(java.math.BigDecimal val) {

		s3fFlgEstinzPresenti = val;

	}

	/**
	 * Legge il valore della proprieta' s3fFlgEstinzPresenti associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS3fFlgEstinzPresenti() {

		return s3fFlgEstinzPresenti;

	}

	/**
	 * store della proprieta' associata alla colonna S3G_FLG_INTERR_GEN_PRESENTI
	 * @generated
	 */
	protected java.math.BigDecimal s3gFlgInterrGenPresenti;

	/**
	 * Imposta il valore della proprieta' s3gFlgInterrGenPresenti associata alla
	 * colonna S3G_FLG_INTERR_GEN_PRESENTI.
	 * @generated
	 */
	public void setS3gFlgInterrGenPresenti(java.math.BigDecimal val) {

		s3gFlgInterrGenPresenti = val;

	}

	/**
	 * Legge il valore della proprieta' s3gFlgInterrGenPresenti associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS3gFlgInterrGenPresenti() {

		return s3gFlgInterrGenPresenti;

	}

	/**
	 * store della proprieta' associata alla colonna S3H_FLG_RUBIN_PRESENTE
	 * @generated
	 */
	protected java.math.BigDecimal s3hFlgRubinPresente;

	/**
	 * Imposta il valore della proprieta' s3hFlgRubinPresente associata alla
	 * colonna S3H_FLG_RUBIN_PRESENTE.
	 * @generated
	 */
	public void setS3hFlgRubinPresente(java.math.BigDecimal val) {

		s3hFlgRubinPresente = val;

	}

	/**
	 * Legge il valore della proprieta' s3hFlgRubinPresente associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS3hFlgRubinPresente() {

		return s3hFlgRubinPresente;

	}

	/**
	 * store della proprieta' associata alla colonna S3I_FLG_ASSENZA_PERD_COMB
	 * @generated
	 */
	protected java.math.BigDecimal s3iFlgAssenzaPerdComb;

	/**
	 * Imposta il valore della proprieta' s3iFlgAssenzaPerdComb associata alla
	 * colonna S3I_FLG_ASSENZA_PERD_COMB.
	 * @generated
	 */
	public void setS3iFlgAssenzaPerdComb(java.math.BigDecimal val) {

		s3iFlgAssenzaPerdComb = val;

	}

	/**
	 * Legge il valore della proprieta' s3iFlgAssenzaPerdComb associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS3iFlgAssenzaPerdComb() {

		return s3iFlgAssenzaPerdComb;

	}

	/**
	 * store della proprieta' associata alla colonna S3J_FLG_TEMP_AMB_FUNZ
	 * @generated
	 */
	protected java.math.BigDecimal s3jFlgTempAmbFunz;

	/**
	 * Imposta il valore della proprieta' s3jFlgTempAmbFunz associata alla
	 * colonna S3J_FLG_TEMP_AMB_FUNZ.
	 * @generated
	 */
	public void setS3jFlgTempAmbFunz(java.math.BigDecimal val) {

		s3jFlgTempAmbFunz = val;

	}

	/**
	 * Legge il valore della proprieta' s3jFlgTempAmbFunz associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS3jFlgTempAmbFunz() {

		return s3jFlgTempAmbFunz;

	}

	/**
	 * store della proprieta' associata alla colonna S3K_FLG_DM_1_12_1975
	 * @generated
	 */
	protected java.math.BigDecimal s3kFlgDm1121975;

	/**
	 * Imposta il valore della proprieta' s3kFlgDm1121975 associata alla
	 * colonna S3K_FLG_DM_1_12_1975.
	 * @generated
	 */
	public void setS3kFlgDm1121975(java.math.BigDecimal val) {

		s3kFlgDm1121975 = val;

	}

	/**
	 * Legge il valore della proprieta' s3kFlgDm1121975 associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS3kFlgDm1121975() {

		return s3kFlgDm1121975;

	}

	/**
	 * store della proprieta' associata alla colonna S4A_FLG_LIB_IMP_PRESENTE
	 * @generated
	 */
	protected java.math.BigDecimal s4aFlgLibImpPresente;

	/**
	 * Imposta il valore della proprieta' s4aFlgLibImpPresente associata alla
	 * colonna S4A_FLG_LIB_IMP_PRESENTE.
	 * @generated
	 */
	public void setS4aFlgLibImpPresente(java.math.BigDecimal val) {

		s4aFlgLibImpPresente = val;

	}

	/**
	 * Legge il valore della proprieta' s4aFlgLibImpPresente associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS4aFlgLibImpPresente() {

		return s4aFlgLibImpPresente;

	}

	/**
	 * store della proprieta' associata alla colonna S4B_FLG_LIB_COMPILATO
	 * @generated
	 */
	protected java.math.BigDecimal s4bFlgLibCompilato;

	/**
	 * Imposta il valore della proprieta' s4bFlgLibCompilato associata alla
	 * colonna S4B_FLG_LIB_COMPILATO.
	 * @generated
	 */
	public void setS4bFlgLibCompilato(java.math.BigDecimal val) {

		s4bFlgLibCompilato = val;

	}

	/**
	 * Legge il valore della proprieta' s4bFlgLibCompilato associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS4bFlgLibCompilato() {

		return s4bFlgLibCompilato;

	}

	/**
	 * store della proprieta' associata alla colonna S4C_FLG_CONFORMITA_PRESENTE
	 * @generated
	 */
	protected java.math.BigDecimal s4cFlgConformitaPresente;

	/**
	 * Imposta il valore della proprieta' s4cFlgConformitaPresente associata alla
	 * colonna S4C_FLG_CONFORMITA_PRESENTE.
	 * @generated
	 */
	public void setS4cFlgConformitaPresente(java.math.BigDecimal val) {

		s4cFlgConformitaPresente = val;

	}

	/**
	 * Legge il valore della proprieta' s4cFlgConformitaPresente associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS4cFlgConformitaPresente() {

		return s4cFlgConformitaPresente;

	}

	/**
	 * store della proprieta' associata alla colonna S4D_FLG_LIB_USO_PRESENTE
	 * @generated
	 */
	protected java.math.BigDecimal s4dFlgLibUsoPresente;

	/**
	 * Imposta il valore della proprieta' s4dFlgLibUsoPresente associata alla
	 * colonna S4D_FLG_LIB_USO_PRESENTE.
	 * @generated
	 */
	public void setS4dFlgLibUsoPresente(java.math.BigDecimal val) {

		s4dFlgLibUsoPresente = val;

	}

	/**
	 * Legge il valore della proprieta' s4dFlgLibUsoPresente associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS4dFlgLibUsoPresente() {

		return s4dFlgLibUsoPresente;

	}

	/**
	 * store della proprieta' associata alla colonna S4E_FLG_PRATICA_VVF_PRESENTE
	 * @generated
	 */
	protected java.math.BigDecimal s4eFlgPraticaVvfPresente;

	/**
	 * Imposta il valore della proprieta' s4eFlgPraticaVvfPresente associata alla
	 * colonna S4E_FLG_PRATICA_VVF_PRESENTE.
	 * @generated
	 */
	public void setS4eFlgPraticaVvfPresente(java.math.BigDecimal val) {

		s4eFlgPraticaVvfPresente = val;

	}

	/**
	 * Legge il valore della proprieta' s4eFlgPraticaVvfPresente associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS4eFlgPraticaVvfPresente() {

		return s4eFlgPraticaVvfPresente;

	}

	/**
	 * store della proprieta' associata alla colonna S4F_FLG_PRATICA_INAIL_PRESENTE
	 * @generated
	 */
	protected java.math.BigDecimal s4fFlgPraticaInailPresente;

	/**
	 * Imposta il valore della proprieta' s4fFlgPraticaInailPresente associata alla
	 * colonna S4F_FLG_PRATICA_INAIL_PRESENTE.
	 * @generated
	 */
	public void setS4fFlgPraticaInailPresente(java.math.BigDecimal val) {

		s4fFlgPraticaInailPresente = val;

	}

	/**
	 * Legge il valore della proprieta' s4fFlgPraticaInailPresente associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS4fFlgPraticaInailPresente() {

		return s4fFlgPraticaInailPresente;

	}

	/**
	 * store della proprieta' associata alla colonna S4G_FLG_DM12_1975
	 * @generated
	 */
	protected java.math.BigDecimal s4gFlgDm121975;

	/**
	 * Imposta il valore della proprieta' s4gFlgDm121975 associata alla
	 * colonna S4G_FLG_DM12_1975.
	 * @generated
	 */
	public void setS4gFlgDm121975(java.math.BigDecimal val) {

		s4gFlgDm121975 = val;

	}

	/**
	 * Legge il valore della proprieta' s4gFlgDm121975 associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS4gFlgDm121975() {

		return s4gFlgDm121975;

	}

	/**
	 * store della proprieta' associata alla colonna S4G_MATRICOLA_DM_1_12_1975
	 * @generated
	 */
	protected String s4gMatricolaDm1121975;

	/**
	 * Imposta il valore della proprieta' s4gMatricolaDm1121975 associata alla
	 * colonna S4G_MATRICOLA_DM_1_12_1975.
	 * @generated
	 */
	public void setS4gMatricolaDm1121975(String val) {

		s4gMatricolaDm1121975 = val;

	}

	/**
	 * Legge il valore della proprieta' s4gMatricolaDm1121975 associata alla
	 * @generated
	 */
	public String getS4gMatricolaDm1121975() {

		return s4gMatricolaDm1121975;

	}

	/**
	 * store della proprieta' associata alla colonna S5A_FLG_ADOZIONE_VALVOLE_TERM
	 * @generated
	 */
	protected java.math.BigDecimal s5aFlgAdozioneValvoleTerm;

	/**
	 * Imposta il valore della proprieta' s5aFlgAdozioneValvoleTerm associata alla
	 * colonna S5A_FLG_ADOZIONE_VALVOLE_TERM.
	 * @generated
	 */
	public void setS5aFlgAdozioneValvoleTerm(java.math.BigDecimal val) {

		s5aFlgAdozioneValvoleTerm = val;

	}

	/**
	 * Legge il valore della proprieta' s5aFlgAdozioneValvoleTerm associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS5aFlgAdozioneValvoleTerm() {

		return s5aFlgAdozioneValvoleTerm;

	}

	/**
	 * store della proprieta' associata alla colonna S5A_FLG_ISOLAMENTE_RETE
	 * @generated
	 */
	protected java.math.BigDecimal s5aFlgIsolamenteRete;

	/**
	 * Imposta il valore della proprieta' s5aFlgIsolamenteRete associata alla
	 * colonna S5A_FLG_ISOLAMENTE_RETE.
	 * @generated
	 */
	public void setS5aFlgIsolamenteRete(java.math.BigDecimal val) {

		s5aFlgIsolamenteRete = val;

	}

	/**
	 * Legge il valore della proprieta' s5aFlgIsolamenteRete associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS5aFlgIsolamenteRete() {

		return s5aFlgIsolamenteRete;

	}

	/**
	 * store della proprieta' associata alla colonna S5A_FLG_ADOZ_SIST_TRATTAM_H2O
	 * @generated
	 */
	protected java.math.BigDecimal s5aFlgAdozSistTrattamH2o;

	/**
	 * Imposta il valore della proprieta' s5aFlgAdozSistTrattamH2o associata alla
	 * colonna S5A_FLG_ADOZ_SIST_TRATTAM_H2O.
	 * @generated
	 */
	public void setS5aFlgAdozSistTrattamH2o(java.math.BigDecimal val) {

		s5aFlgAdozSistTrattamH2o = val;

	}

	/**
	 * Legge il valore della proprieta' s5aFlgAdozSistTrattamH2o associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS5aFlgAdozSistTrattamH2o() {

		return s5aFlgAdozSistTrattamH2o;

	}

	/**
	 * store della proprieta' associata alla colonna S5A_FLG_SOSTITUZ_SIST_REGOLAZ
	 * @generated
	 */
	protected java.math.BigDecimal s5aFlgSostituzSistRegolaz;

	/**
	 * Imposta il valore della proprieta' s5aFlgSostituzSistRegolaz associata alla
	 * colonna S5A_FLG_SOSTITUZ_SIST_REGOLAZ.
	 * @generated
	 */
	public void setS5aFlgSostituzSistRegolaz(java.math.BigDecimal val) {

		s5aFlgSostituzSistRegolaz = val;

	}

	/**
	 * Legge il valore della proprieta' s5aFlgSostituzSistRegolaz associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS5aFlgSostituzSistRegolaz() {

		return s5aFlgSostituzSistRegolaz;

	}

	/**
	 * store della proprieta' associata alla colonna S5B_FLG_NO_INTERV_CONV
	 * @generated
	 */
	protected java.math.BigDecimal s5bFlgNoIntervConv;

	/**
	 * Imposta il valore della proprieta' s5bFlgNoIntervConv associata alla
	 * colonna S5B_FLG_NO_INTERV_CONV.
	 * @generated
	 */
	public void setS5bFlgNoIntervConv(java.math.BigDecimal val) {

		s5bFlgNoIntervConv = val;

	}

	/**
	 * Legge il valore della proprieta' s5bFlgNoIntervConv associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS5bFlgNoIntervConv() {

		return s5bFlgNoIntervConv;

	}

	/**
	 * store della proprieta' associata alla colonna S5B_FLG_RELAZ_DETTAGLIO
	 * @generated
	 */
	protected java.math.BigDecimal s5bFlgRelazDettaglio;

	/**
	 * Imposta il valore della proprieta' s5bFlgRelazDettaglio associata alla
	 * colonna S5B_FLG_RELAZ_DETTAGLIO.
	 * @generated
	 */
	public void setS5bFlgRelazDettaglio(java.math.BigDecimal val) {

		s5bFlgRelazDettaglio = val;

	}

	/**
	 * Legge il valore della proprieta' s5bFlgRelazDettaglio associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS5bFlgRelazDettaglio() {

		return s5bFlgRelazDettaglio;

	}

	/**
	 * store della proprieta' associata alla colonna S5B_FLG_RELAZ_DETTAGLIO_SUCC
	 * @generated
	 */
	protected java.math.BigDecimal s5bFlgRelazDettaglioSucc;

	/**
	 * Imposta il valore della proprieta' s5bFlgRelazDettaglioSucc associata alla
	 * colonna S5B_FLG_RELAZ_DETTAGLIO_SUCC.
	 * @generated
	 */
	public void setS5bFlgRelazDettaglioSucc(java.math.BigDecimal val) {

		s5bFlgRelazDettaglioSucc = val;

	}

	/**
	 * Legge il valore della proprieta' s5bFlgRelazDettaglioSucc associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS5bFlgRelazDettaglioSucc() {

		return s5bFlgRelazDettaglioSucc;

	}

	/**
	 * store della proprieta' associata alla colonna S5B_FLG_VALUTAZ_NON_ESEGUITA
	 * @generated
	 */
	protected java.math.BigDecimal s5bFlgValutazNonEseguita;

	/**
	 * Imposta il valore della proprieta' s5bFlgValutazNonEseguita associata alla
	 * colonna S5B_FLG_VALUTAZ_NON_ESEGUITA.
	 * @generated
	 */
	public void setS5bFlgValutazNonEseguita(java.math.BigDecimal val) {

		s5bFlgValutazNonEseguita = val;

	}

	/**
	 * Legge il valore della proprieta' s5bFlgValutazNonEseguita associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS5bFlgValutazNonEseguita() {

		return s5bFlgValutazNonEseguita;

	}

	/**
	 * store della proprieta' associata alla colonna S5B_MOTIVO_RELAZ_NON_ESEG
	 * @generated
	 */
	protected String s5bMotivoRelazNonEseg;

	/**
	 * Imposta il valore della proprieta' s5bMotivoRelazNonEseg associata alla
	 * colonna S5B_MOTIVO_RELAZ_NON_ESEG.
	 * @generated
	 */
	public void setS5bMotivoRelazNonEseg(String val) {

		s5bMotivoRelazNonEseg = val;

	}

	/**
	 * Legge il valore della proprieta' s5bMotivoRelazNonEseg associata alla
	 * @generated
	 */
	public String getS5bMotivoRelazNonEseg() {

		return s5bMotivoRelazNonEseg;

	}

	/**
	 * store della proprieta' associata alla colonna S5C_FLG_DIMENS_CORRETTO
	 * @generated
	 */
	protected java.math.BigDecimal s5cFlgDimensCorretto;

	/**
	 * Imposta il valore della proprieta' s5cFlgDimensCorretto associata alla
	 * colonna S5C_FLG_DIMENS_CORRETTO.
	 * @generated
	 */
	public void setS5cFlgDimensCorretto(java.math.BigDecimal val) {

		s5cFlgDimensCorretto = val;

	}

	/**
	 * Legge il valore della proprieta' s5cFlgDimensCorretto associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS5cFlgDimensCorretto() {

		return s5cFlgDimensCorretto;

	}

	/**
	 * store della proprieta' associata alla colonna S5C_FLG_DIMENS_NON_CONTROLL
	 * @generated
	 */
	protected java.math.BigDecimal s5cFlgDimensNonControll;

	/**
	 * Imposta il valore della proprieta' s5cFlgDimensNonControll associata alla
	 * colonna S5C_FLG_DIMENS_NON_CONTROLL.
	 * @generated
	 */
	public void setS5cFlgDimensNonControll(java.math.BigDecimal val) {

		s5cFlgDimensNonControll = val;

	}

	/**
	 * Legge il valore della proprieta' s5cFlgDimensNonControll associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS5cFlgDimensNonControll() {

		return s5cFlgDimensNonControll;

	}

	/**
	 * store della proprieta' associata alla colonna S5C_FLG_DIMENS_RELAZ_SUCCES
	 * @generated
	 */
	protected java.math.BigDecimal s5cFlgDimensRelazSucces;

	/**
	 * Imposta il valore della proprieta' s5cFlgDimensRelazSucces associata alla
	 * colonna S5C_FLG_DIMENS_RELAZ_SUCCES.
	 * @generated
	 */
	public void setS5cFlgDimensRelazSucces(java.math.BigDecimal val) {

		s5cFlgDimensRelazSucces = val;

	}

	/**
	 * Legge il valore della proprieta' s5cFlgDimensRelazSucces associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS5cFlgDimensRelazSucces() {

		return s5cFlgDimensRelazSucces;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_ULT_MOD
	 * @generated
	 */
	protected java.sql.Timestamp dataUltMod;

	/**
	 * Imposta il valore della proprieta' dataUltMod associata alla
	 * colonna DATA_ULT_MOD.
	 * @generated
	 */
	public void setDataUltMod(java.sql.Timestamp val) {

		if (val != null) {
			dataUltMod = new java.sql.Timestamp(val.getTime());
		} else {
			dataUltMod = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataUltMod associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataUltMod() {

		if (dataUltMod != null) {
			return new java.sql.Timestamp(dataUltMod.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna UTENTE_ULT_MOD
	 * @generated
	 */
	protected String utenteUltMod;

	/**
	 * Imposta il valore della proprieta' utenteUltMod associata alla
	 * colonna UTENTE_ULT_MOD.
	 * @generated
	 */
	public void setUtenteUltMod(String val) {

		utenteUltMod = val;

	}

	/**
	 * Legge il valore della proprieta' utenteUltMod associata alla
	 * @generated
	 */
	public String getUtenteUltMod() {

		return utenteUltMod;

	}

	/**
	 * store della proprieta' associata alla colonna S1C_DATA_REE
	 * @generated
	 */
	protected java.sql.Date s1cDataRee;

	/**
	 * Imposta il valore della proprieta' s1cDataRee associata alla
	 * colonna S1C_DATA_REE.
	 * @generated
	 */
	public void setS1cDataRee(java.sql.Date val) {

		if (val != null) {
			s1cDataRee = new java.sql.Date(val.getTime());
		} else {
			s1cDataRee = null;
		}

	}

	/**
	 * Legge il valore della proprieta' s1cDataRee associata alla
	 * @generated
	 */
	public java.sql.Date getS1cDataRee() {

		if (s1cDataRee != null) {
			return new java.sql.Date(s1cDataRee.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna S5C_FLG_DIMENS_NON_CORRETTO
	 * @generated
	 */
	protected java.math.BigDecimal s5cFlgDimensNonCorretto;

	/**
	 * Imposta il valore della proprieta' s5cFlgDimensNonCorretto associata alla
	 * colonna S5C_FLG_DIMENS_NON_CORRETTO.
	 * @generated
	 */
	public void setS5cFlgDimensNonCorretto(java.math.BigDecimal val) {

		s5cFlgDimensNonCorretto = val;

	}

	/**
	 * Legge il valore della proprieta' s5cFlgDimensNonCorretto associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS5cFlgDimensNonCorretto() {

		return s5cFlgDimensNonCorretto;

	}

	/**
	 * Crea una istanza di SigitTRappIspezGtPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTRappIspezGtPk
	 * @generated
	 */
	public SigitTRappIspezGtPk createPk() {
		return new SigitTRappIspezGtPk(idAllegato);
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
