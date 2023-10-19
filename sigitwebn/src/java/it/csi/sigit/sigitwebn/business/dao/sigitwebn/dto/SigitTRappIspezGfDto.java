package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTRappIspezGfDao.
 * @generated
 */
public class SigitTRappIspezGfDto extends SigitTRappIspezGfPk {

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
	 * store della proprieta' associata alla colonna S1E_POT_TERMICA_MAX_KW
	 * @generated
	 */
	protected java.math.BigDecimal s1ePotTermicaMaxKw;

	/**
	 * Imposta il valore della proprieta' s1ePotTermicaMaxKw associata alla
	 * colonna S1E_POT_TERMICA_MAX_KW.
	 * @generated
	 */
	public void setS1ePotTermicaMaxKw(java.math.BigDecimal val) {

		s1ePotTermicaMaxKw = val;

	}

	/**
	 * Legge il valore della proprieta' s1ePotTermicaMaxKw associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS1ePotTermicaMaxKw() {

		return s1ePotTermicaMaxKw;

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
	 * store della proprieta' associata alla colonna S2E_FLG_TRATT_H2O_NON_RICH
	 * @generated
	 */
	protected java.math.BigDecimal s2eFlgTrattH2oNonRich;

	/**
	 * Imposta il valore della proprieta' s2eFlgTrattH2oNonRich associata alla
	 * colonna S2E_FLG_TRATT_H2O_NON_RICH.
	 * @generated
	 */
	public void setS2eFlgTrattH2oNonRich(java.math.BigDecimal val) {

		s2eFlgTrattH2oNonRich = val;

	}

	/**
	 * Legge il valore della proprieta' s2eFlgTrattH2oNonRich associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS2eFlgTrattH2oNonRich() {

		return s2eFlgTrattH2oNonRich;

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
	 * store della proprieta' associata alla colonna S3B_FLG_LINEE_ELETTR_IDONEE
	 * @generated
	 */
	protected java.math.BigDecimal s3bFlgLineeElettrIdonee;

	/**
	 * Imposta il valore della proprieta' s3bFlgLineeElettrIdonee associata alla
	 * colonna S3B_FLG_LINEE_ELETTR_IDONEE.
	 * @generated
	 */
	public void setS3bFlgLineeElettrIdonee(java.math.BigDecimal val) {

		s3bFlgLineeElettrIdonee = val;

	}

	/**
	 * Legge il valore della proprieta' s3bFlgLineeElettrIdonee associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS3bFlgLineeElettrIdonee() {

		return s3bFlgLineeElettrIdonee;

	}

	/**
	 * store della proprieta' associata alla colonna S3C_FLG_VENTILAZ_ADEGUATE
	 * @generated
	 */
	protected java.math.BigDecimal s3cFlgVentilazAdeguate;

	/**
	 * Imposta il valore della proprieta' s3cFlgVentilazAdeguate associata alla
	 * colonna S3C_FLG_VENTILAZ_ADEGUATE.
	 * @generated
	 */
	public void setS3cFlgVentilazAdeguate(java.math.BigDecimal val) {

		s3cFlgVentilazAdeguate = val;

	}

	/**
	 * Legge il valore della proprieta' s3cFlgVentilazAdeguate associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS3cFlgVentilazAdeguate() {

		return s3cFlgVentilazAdeguate;

	}

	/**
	 * store della proprieta' associata alla colonna S3D_FLG_COIBENTAZIONI_IDONEE
	 * @generated
	 */
	protected java.math.BigDecimal s3dFlgCoibentazioniIdonee;

	/**
	 * Imposta il valore della proprieta' s3dFlgCoibentazioniIdonee associata alla
	 * colonna S3D_FLG_COIBENTAZIONI_IDONEE.
	 * @generated
	 */
	public void setS3dFlgCoibentazioniIdonee(java.math.BigDecimal val) {

		s3dFlgCoibentazioniIdonee = val;

	}

	/**
	 * Legge il valore della proprieta' s3dFlgCoibentazioniIdonee associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS3dFlgCoibentazioniIdonee() {

		return s3dFlgCoibentazioniIdonee;

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
	 * store della proprieta' associata alla colonna S5A_FLG_SOSTITUZ_MACCHINE_REG
	 * @generated
	 */
	protected java.math.BigDecimal s5aFlgSostituzMacchineReg;

	/**
	 * Imposta il valore della proprieta' s5aFlgSostituzMacchineReg associata alla
	 * colonna S5A_FLG_SOSTITUZ_MACCHINE_REG.
	 * @generated
	 */
	public void setS5aFlgSostituzMacchineReg(java.math.BigDecimal val) {

		s5aFlgSostituzMacchineReg = val;

	}

	/**
	 * Legge il valore della proprieta' s5aFlgSostituzMacchineReg associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS5aFlgSostituzMacchineReg() {

		return s5aFlgSostituzMacchineReg;

	}

	/**
	 * store della proprieta' associata alla colonna S5A_FLG_SOSTITUZ_SISTEMI_REG
	 * @generated
	 */
	protected java.math.BigDecimal s5aFlgSostituzSistemiReg;

	/**
	 * Imposta il valore della proprieta' s5aFlgSostituzSistemiReg associata alla
	 * colonna S5A_FLG_SOSTITUZ_SISTEMI_REG.
	 * @generated
	 */
	public void setS5aFlgSostituzSistemiReg(java.math.BigDecimal val) {

		s5aFlgSostituzSistemiReg = val;

	}

	/**
	 * Legge il valore della proprieta' s5aFlgSostituzSistemiReg associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS5aFlgSostituzSistemiReg() {

		return s5aFlgSostituzSistemiReg;

	}

	/**
	 * store della proprieta' associata alla colonna S5A_FLG_ISOLAM_RETE_DISTRIB
	 * @generated
	 */
	protected java.math.BigDecimal s5aFlgIsolamReteDistrib;

	/**
	 * Imposta il valore della proprieta' s5aFlgIsolamReteDistrib associata alla
	 * colonna S5A_FLG_ISOLAM_RETE_DISTRIB.
	 * @generated
	 */
	public void setS5aFlgIsolamReteDistrib(java.math.BigDecimal val) {

		s5aFlgIsolamReteDistrib = val;

	}

	/**
	 * Legge il valore della proprieta' s5aFlgIsolamReteDistrib associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS5aFlgIsolamReteDistrib() {

		return s5aFlgIsolamReteDistrib;

	}

	/**
	 * store della proprieta' associata alla colonna S5A_FLG_ISOLAM_CANALI_DISTRIB
	 * @generated
	 */
	protected java.math.BigDecimal s5aFlgIsolamCanaliDistrib;

	/**
	 * Imposta il valore della proprieta' s5aFlgIsolamCanaliDistrib associata alla
	 * colonna S5A_FLG_ISOLAM_CANALI_DISTRIB.
	 * @generated
	 */
	public void setS5aFlgIsolamCanaliDistrib(java.math.BigDecimal val) {

		s5aFlgIsolamCanaliDistrib = val;

	}

	/**
	 * Legge il valore della proprieta' s5aFlgIsolamCanaliDistrib associata alla
	 * @generated
	 */
	public java.math.BigDecimal getS5aFlgIsolamCanaliDistrib() {

		return s5aFlgIsolamCanaliDistrib;

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
	 * Crea una istanza di SigitTRappIspezGfPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTRappIspezGfPk
	 * @generated
	 */
	public SigitTRappIspezGfPk createPk() {
		return new SigitTRappIspezGfPk(idAllegato);
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
