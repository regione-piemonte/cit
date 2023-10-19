package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTDettIspezGtDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTDettIspezGtExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idDettIspezGt;

	/**
	 * @generated
	 */
	public void setIdDettIspezGt(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idDettIspezGt = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdDettIspezGt() {
		return idDettIspezGt;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkAllegato;

	/**
	 * @generated
	 */
	public void setFkAllegato(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkAllegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkAllegato() {
		return fkAllegato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkTipoComponente;

	/**
	 * @generated
	 */
	public void setFkTipoComponente(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkTipoComponente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkTipoComponente() {
		return fkTipoComponente;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk progressivo;

	/**
	 * @generated
	 */
	public void setProgressivo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		progressivo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getProgressivo() {
		return progressivo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk codiceImpianto;

	/**
	 * @generated
	 */
	public void setCodiceImpianto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		codiceImpianto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCodiceImpianto() {
		return codiceImpianto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataInstall;

	/**
	 * @generated
	 */
	public void setDataInstall(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataInstall = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataInstall() {
		return dataInstall;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s6dFlgEvacuFumi;

	/**
	 * @generated
	 */
	public void setS6dFlgEvacuFumi(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s6dFlgEvacuFumi = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS6dFlgEvacuFumi() {
		return s6dFlgEvacuFumi;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s6iFlgTipoB;

	/**
	 * @generated
	 */
	public void setS6iFlgTipoB(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s6iFlgTipoB = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS6iFlgTipoB() {
		return s6iFlgTipoB;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s6iFlgTipoC;

	/**
	 * @generated
	 */
	public void setS6iFlgTipoC(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s6iFlgTipoC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS6iFlgTipoC() {
		return s6iFlgTipoC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s6jFkClassDpr66096;

	/**
	 * @generated
	 */
	public void setS6jFkClassDpr66096(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s6jFkClassDpr66096 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS6jFkClassDpr66096() {
		return s6jFkClassDpr66096;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s6kPotTermFocolKw;

	/**
	 * @generated
	 */
	public void setS6kPotTermFocolKw(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s6kPotTermFocolKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS6kPotTermFocolKw() {
		return s6kPotTermFocolKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s6kBruciatoreDaKw;

	/**
	 * @generated
	 */
	public void setS6kBruciatoreDaKw(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s6kBruciatoreDaKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS6kBruciatoreDaKw() {
		return s6kBruciatoreDaKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s6kBruciatoreAKw;

	/**
	 * @generated
	 */
	public void setS6kBruciatoreAKw(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s6kBruciatoreAKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS6kBruciatoreAKw() {
		return s6kBruciatoreAKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s6lPortataCombM3H;

	/**
	 * @generated
	 */
	public void setS6lPortataCombM3H(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s6lPortataCombM3H = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS6lPortataCombM3H() {
		return s6lPortataCombM3H;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s6lPortataCombKgH;

	/**
	 * @generated
	 */
	public void setS6lPortataCombKgH(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s6lPortataCombKgH = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS6lPortataCombKgH() {
		return s6lPortataCombKgH;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s6lPotTermFocolKw;

	/**
	 * @generated
	 */
	public void setS6lPotTermFocolKw(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s6lPotTermFocolKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS6lPotTermFocolKw() {
		return s6lPotTermFocolKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7aFlgManutEffettuata;

	/**
	 * @generated
	 */
	public void setS7aFlgManutEffettuata(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7aFlgManutEffettuata = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7aFlgManutEffettuata() {
		return s7aFlgManutEffettuata;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7aDataUltimaManut;

	/**
	 * @generated
	 */
	public void setS7aDataUltimaManut(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7aDataUltimaManut = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7aDataUltimaManut() {
		return s7aDataUltimaManut;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7bFlgReePresente;

	/**
	 * @generated
	 */
	public void setS7bFlgReePresente(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7bFlgReePresente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7bFlgReePresente() {
		return s7bFlgReePresente;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7bDataRee;

	/**
	 * @generated
	 */
	public void setS7bDataRee(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7bDataRee = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7bDataRee() {
		return s7bDataRee;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7bFlgOsservazioni;

	/**
	 * @generated
	 */
	public void setS7bFlgOsservazioni(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7bFlgOsservazioni = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7bFlgOsservazioni() {
		return s7bFlgOsservazioni;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7bFlgRaccomand;

	/**
	 * @generated
	 */
	public void setS7bFlgRaccomand(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7bFlgRaccomand = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7bFlgRaccomand() {
		return s7bFlgRaccomand;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7bFlgPrescr;

	/**
	 * @generated
	 */
	public void setS7bFlgPrescr(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7bFlgPrescr = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7bFlgPrescr() {
		return s7bFlgPrescr;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8aNModuloTermico;

	/**
	 * @generated
	 */
	public void setS8aNModuloTermico(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8aNModuloTermico = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8aNModuloTermico() {
		return s8aNModuloTermico;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8bFumoMis1;

	/**
	 * @generated
	 */
	public void setS8bFumoMis1(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8bFumoMis1 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8bFumoMis1() {
		return s8bFumoMis1;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8bFumoMis2;

	/**
	 * @generated
	 */
	public void setS8bFumoMis2(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8bFumoMis2 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8bFumoMis2() {
		return s8bFumoMis2;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8bFumoMis3;

	/**
	 * @generated
	 */
	public void setS8bFumoMis3(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8bFumoMis3 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8bFumoMis3() {
		return s8bFumoMis3;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8cMarcaStrumMisura;

	/**
	 * @generated
	 */
	public void setS8cMarcaStrumMisura(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8cMarcaStrumMisura = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8cMarcaStrumMisura() {
		return s8cMarcaStrumMisura;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8cModelloStrumMisura;

	/**
	 * @generated
	 */
	public void setS8cModelloStrumMisura(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8cModelloStrumMisura = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8cModelloStrumMisura() {
		return s8cModelloStrumMisura;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8cMatricolaStrumMisura;

	/**
	 * @generated
	 */
	public void setS8cMatricolaStrumMisura(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8cMatricolaStrumMisura = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8cMatricolaStrumMisura() {
		return s8cMatricolaStrumMisura;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8dTempFluidoMandataC;

	/**
	 * @generated
	 */
	public void setS8dTempFluidoMandataC(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8dTempFluidoMandataC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8dTempFluidoMandataC() {
		return s8dTempFluidoMandataC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8dTempAriaC;

	/**
	 * @generated
	 */
	public void setS8dTempAriaC(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8dTempAriaC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8dTempAriaC() {
		return s8dTempAriaC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8dTempFumiC;

	/**
	 * @generated
	 */
	public void setS8dTempFumiC(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8dTempFumiC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8dTempFumiC() {
		return s8dTempFumiC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8dO2Perc;

	/**
	 * @generated
	 */
	public void setS8dO2Perc(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8dO2Perc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8dO2Perc() {
		return s8dO2Perc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8dCo2Perc;

	/**
	 * @generated
	 */
	public void setS8dCo2Perc(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8dCo2Perc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8dCo2Perc() {
		return s8dCo2Perc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8dCoFumiSecchiPpm;

	/**
	 * @generated
	 */
	public void setS8dCoFumiSecchiPpm(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8dCoFumiSecchiPpm = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8dCoFumiSecchiPpm() {
		return s8dCoFumiSecchiPpm;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8dNoMgKwH;

	/**
	 * @generated
	 */
	public void setS8dNoMgKwH(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8dNoMgKwH = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8dNoMgKwH() {
		return s8dNoMgKwH;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8eIndiceAria;

	/**
	 * @generated
	 */
	public void setS8eIndiceAria(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8eIndiceAria = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8eIndiceAria() {
		return s8eIndiceAria;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8eFumiSecchiNoAriaPpm;

	/**
	 * @generated
	 */
	public void setS8eFumiSecchiNoAriaPpm(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8eFumiSecchiNoAriaPpm = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8eFumiSecchiNoAriaPpm() {
		return s8eFumiSecchiNoAriaPpm;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8eQsPerc;

	/**
	 * @generated
	 */
	public void setS8eQsPerc(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8eQsPerc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8eQsPerc() {
		return s8eQsPerc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8eEtPerc;

	/**
	 * @generated
	 */
	public void setS8eEtPerc(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8eEtPerc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8eEtPerc() {
		return s8eEtPerc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8eRendCombPerc;

	/**
	 * @generated
	 */
	public void setS8eRendCombPerc(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8eRendCombPerc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8eRendCombPerc() {
		return s8eRendCombPerc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s8eNoxMgKwH;

	/**
	 * @generated
	 */
	public void setS8eNoxMgKwH(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s8eNoxMgKwH = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS8eNoxMgKwH() {
		return s8eNoxMgKwH;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9aFlgMonossidoCarb;

	/**
	 * @generated
	 */
	public void setS9aFlgMonossidoCarb(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9aFlgMonossidoCarb = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9aFlgMonossidoCarb() {
		return s9aFlgMonossidoCarb;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9bFlgFumosita;

	/**
	 * @generated
	 */
	public void setS9bFlgFumosita(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9bFlgFumosita = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9bFlgFumosita() {
		return s9bFlgFumosita;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9cRendMinCombustPerc;

	/**
	 * @generated
	 */
	public void setS9cRendMinCombustPerc(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9cRendMinCombustPerc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9cRendMinCombustPerc() {
		return s9cRendMinCombustPerc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9cFlgRendCombustSuff;

	/**
	 * @generated
	 */
	public void setS9cFlgRendCombustSuff(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9cFlgRendCombustSuff = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9cFlgRendCombustSuff() {
		return s9cFlgRendCombustSuff;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9dOssidiAzotoLimMgKwH;

	/**
	 * @generated
	 */
	public void setS9dOssidiAzotoLimMgKwH(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9dOssidiAzotoLimMgKwH = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9dOssidiAzotoLimMgKwH() {
		return s9dOssidiAzotoLimMgKwH;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9dFlgOssidiAzoto;

	/**
	 * @generated
	 */
	public void setS9dFlgOssidiAzoto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9dFlgOssidiAzoto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9dFlgOssidiAzoto() {
		return s9dFlgOssidiAzoto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9eFlgRispettoNormativa;

	/**
	 * @generated
	 */
	public void setS9eFlgRispettoNormativa(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9eFlgRispettoNormativa = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9eFlgRispettoNormativa() {
		return s9eFlgRispettoNormativa;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9eFlgNoRispetto7a;

	/**
	 * @generated
	 */
	public void setS9eFlgNoRispetto7a(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9eFlgNoRispetto7a = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9eFlgNoRispetto7a() {
		return s9eFlgNoRispetto7a;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9eFlgNoRispetto7b;

	/**
	 * @generated
	 */
	public void setS9eFlgNoRispetto7b(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9eFlgNoRispetto7b = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9eFlgNoRispetto7b() {
		return s9eFlgNoRispetto7b;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9eFlgNoRispetto9a;

	/**
	 * @generated
	 */
	public void setS9eFlgNoRispetto9a(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9eFlgNoRispetto9a = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9eFlgNoRispetto9a() {
		return s9eFlgNoRispetto9a;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9eFlgNoRispetto9b;

	/**
	 * @generated
	 */
	public void setS9eFlgNoRispetto9b(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9eFlgNoRispetto9b = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9eFlgNoRispetto9b() {
		return s9eFlgNoRispetto9b;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9eFlgNoRispetto9c;

	/**
	 * @generated
	 */
	public void setS9eFlgNoRispetto9c(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9eFlgNoRispetto9c = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9eFlgNoRispetto9c() {
		return s9eFlgNoRispetto9c;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s9eFlgNoRispetto9d;

	/**
	 * @generated
	 */
	public void setS9eFlgNoRispetto9d(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s9eFlgNoRispetto9d = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS9eFlgNoRispetto9d() {
		return s9eFlgNoRispetto9d;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataUltMod;

	/**
	 * @generated
	 */
	public void setDataUltMod(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataUltMod = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataUltMod() {
		return dataUltMod;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk utenteUltMod;

	/**
	 * @generated
	 */
	public void setUtenteUltMod(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		utenteUltMod = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getUtenteUltMod() {
		return utenteUltMod;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk controlloweb;

	/**
	 * @generated
	 */
	public void setControlloweb(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		controlloweb = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getControlloweb() {
		return controlloweb;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7aFrequenzaManutAltro;

	/**
	 * @generated
	 */
	public void setS7aFrequenzaManutAltro(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7aFrequenzaManutAltro = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7aFrequenzaManutAltro() {
		return s7aFrequenzaManutAltro;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s7aFkFrequenzaManut;

	/**
	 * @generated
	 */
	public void setS7aFkFrequenzaManut(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s7aFkFrequenzaManut = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS7aFkFrequenzaManut() {
		return s7aFkFrequenzaManut;
	}

}
