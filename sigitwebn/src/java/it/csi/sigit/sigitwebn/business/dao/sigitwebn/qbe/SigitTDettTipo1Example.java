package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTDettTipo1Dto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTDettTipo1Example extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idDettTipo1;

	/**
	 * @generated
	 */
	public void setIdDettTipo1(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idDettTipo1 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdDettTipo1() {
		return idDettTipo1;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eNModuloTermico;

	/**
	 * @generated
	 */
	public void setENModuloTermico(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eNModuloTermico = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getENModuloTermico() {
		return eNModuloTermico;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk ePotTermFocolKw;

	/**
	 * @generated
	 */
	public void setEPotTermFocolKw(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		ePotTermFocolKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEPotTermFocolKw() {
		return ePotTermFocolKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eFlgClimaInverno;

	/**
	 * @generated
	 */
	public void setEFlgClimaInverno(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eFlgClimaInverno = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEFlgClimaInverno() {
		return eFlgClimaInverno;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eFlgProduzAcs;

	/**
	 * @generated
	 */
	public void setEFlgProduzAcs(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eFlgProduzAcs = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEFlgProduzAcs() {
		return eFlgProduzAcs;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eFlgDisposComando;

	/**
	 * @generated
	 */
	public void setEFlgDisposComando(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eFlgDisposComando = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEFlgDisposComando() {
		return eFlgDisposComando;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eFlgDisposSicurezza;

	/**
	 * @generated
	 */
	public void setEFlgDisposSicurezza(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eFlgDisposSicurezza = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEFlgDisposSicurezza() {
		return eFlgDisposSicurezza;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eFlgValvolaSicurezza;

	/**
	 * @generated
	 */
	public void setEFlgValvolaSicurezza(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eFlgValvolaSicurezza = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEFlgValvolaSicurezza() {
		return eFlgValvolaSicurezza;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eFlgScambiatoreFumi;

	/**
	 * @generated
	 */
	public void setEFlgScambiatoreFumi(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eFlgScambiatoreFumi = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEFlgScambiatoreFumi() {
		return eFlgScambiatoreFumi;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eFlgRiflusso;

	/**
	 * @generated
	 */
	public void setEFlgRiflusso(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eFlgRiflusso = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEFlgRiflusso() {
		return eFlgRiflusso;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eFlgUni103891;

	/**
	 * @generated
	 */
	public void setEFlgUni103891(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eFlgUni103891 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEFlgUni103891() {
		return eFlgUni103891;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eFlgEvacuFumi;

	/**
	 * @generated
	 */
	public void setEFlgEvacuFumi(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eFlgEvacuFumi = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEFlgEvacuFumi() {
		return eFlgEvacuFumi;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eDeprCanaleFumoPa;

	/**
	 * @generated
	 */
	public void setEDeprCanaleFumoPa(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eDeprCanaleFumoPa = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEDeprCanaleFumoPa() {
		return eDeprCanaleFumoPa;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eTempFumiC;

	/**
	 * @generated
	 */
	public void setETempFumiC(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eTempFumiC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getETempFumiC() {
		return eTempFumiC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eTempAriaC;

	/**
	 * @generated
	 */
	public void setETempAriaC(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eTempAriaC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getETempAriaC() {
		return eTempAriaC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eO2Perc;

	/**
	 * @generated
	 */
	public void setEO2Perc(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eO2Perc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEO2Perc() {
		return eO2Perc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eCo2Perc;

	/**
	 * @generated
	 */
	public void setECo2Perc(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eCo2Perc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getECo2Perc() {
		return eCo2Perc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eCoCorrettoPpm;

	/**
	 * @generated
	 */
	public void setECoCorrettoPpm(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eCoCorrettoPpm = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getECoCorrettoPpm() {
		return eCoCorrettoPpm;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eRendCombPerc;

	/**
	 * @generated
	 */
	public void setERendCombPerc(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eRendCombPerc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getERendCombPerc() {
		return eRendCombPerc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eRendMinLeggePerc;

	/**
	 * @generated
	 */
	public void setERendMinLeggePerc(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eRendMinLeggePerc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getERendMinLeggePerc() {
		return eRendMinLeggePerc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eNoxPpm;

	/**
	 * @generated
	 */
	public void setENoxPpm(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eNoxPpm = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getENoxPpm() {
		return eNoxPpm;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk l111PortataCombustibile;

	/**
	 * @generated
	 */
	public void setL111PortataCombustibile(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		l111PortataCombustibile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getL111PortataCombustibile() {
		return l111PortataCombustibile;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk l111CoNoAriaPpm;

	/**
	 * @generated
	 */
	public void setL111CoNoAriaPpm(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		l111CoNoAriaPpm = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getL111CoNoAriaPpm() {
		return l111CoNoAriaPpm;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk l111FlgRispettaBacharach;

	/**
	 * @generated
	 */
	public void setL111FlgRispettaBacharach(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		l111FlgRispettaBacharach = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getL111FlgRispettaBacharach() {
		return l111FlgRispettaBacharach;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk l111FlgCoMin1000;

	/**
	 * @generated
	 */
	public void setL111FlgCoMin1000(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		l111FlgCoMin1000 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getL111FlgCoMin1000() {
		return l111FlgCoMin1000;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk l111FlgRendMagRendMin;

	/**
	 * @generated
	 */
	public void setL111FlgRendMagRendMin(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		l111FlgRendMagRendMin = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getL111FlgRendMagRendMin() {
		return l111FlgRendMagRendMin;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk l111PortataCombustibileUm;

	/**
	 * @generated
	 */
	public void setL111PortataCombustibileUm(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		l111PortataCombustibileUm = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getL111PortataCombustibileUm() {
		return l111PortataCombustibileUm;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk l111AltroRiferimento;

	/**
	 * @generated
	 */
	public void setL111AltroRiferimento(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		l111AltroRiferimento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getL111AltroRiferimento() {
		return l111AltroRiferimento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eBacharachMin;

	/**
	 * @generated
	 */
	public void setEBacharachMin(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eBacharachMin = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEBacharachMin() {
		return eBacharachMin;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eBacharachMed;

	/**
	 * @generated
	 */
	public void setEBacharachMed(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eBacharachMed = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEBacharachMed() {
		return eBacharachMed;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eBacharachMax;

	/**
	 * @generated
	 */
	public void setEBacharachMax(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eBacharachMax = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEBacharachMax() {
		return eBacharachMax;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eControlloweb;

	/**
	 * @generated
	 */
	public void setEControlloweb(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eControlloweb = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEControlloweb() {
		return eControlloweb;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eNoxMgKwh;

	/**
	 * @generated
	 */
	public void setENoxMgKwh(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eNoxMgKwh = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getENoxMgKwh() {
		return eNoxMgKwh;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk e1bFlgCucina;

	/**
	 * @generated
	 */
	public void setE1bFlgCucina(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		e1bFlgCucina = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getE1bFlgCucina() {
		return e1bFlgCucina;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk e1bFlgUni103892;

	/**
	 * @generated
	 */
	public void setE1bFlgUni103892(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		e1bFlgUni103892 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getE1bFlgUni103892() {
		return e1bFlgUni103892;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk e1bParticolatoMgAlM3;

	/**
	 * @generated
	 */
	public void setE1bParticolatoMgAlM3(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		e1bParticolatoMgAlM3 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getE1bParticolatoMgAlM3() {
		return e1bParticolatoMgAlM3;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk eNoxMgNm3;

	/**
	 * @generated
	 */
	public void setENoxMgNm3(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		eNoxMgNm3 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getENoxMgNm3() {
		return eNoxMgNm3;
	}

}
