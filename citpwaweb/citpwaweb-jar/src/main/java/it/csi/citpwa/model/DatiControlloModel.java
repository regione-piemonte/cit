/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model;

import it.csi.citpwa.model.sigitext.CodiceDescrizione;

import java.util.ArrayList;
import java.util.List;

public class DatiControlloModel {
	private List<DatoControlloModel> controlli;
	private List<DatiGTModel> datiGT;
	private List<DatiGFModel> datiGF;
	private List<DatiSCModel> datiSC;
	private List<DatiCGModel> datiCG;
	private List<CodiceDescrizione> stelle;
	private List<CodiceDescrizione> apparecchiature;
	private List<CodiceDescrizione> ariaCombustibile;
	private List<CodiceDescrizione> controlloAria;
	private List<CodiceDescrizione> unitaMisura;
	private List<CodiceDescrizione> fluido;

	public DatiControlloModel() {
	}

	public DatiControlloModel(List<DatoControlloModel> controlli, List<DatiGTModel> datiGT, List<DatiGFModel> datiGF, List<DatiSCModel> datiSC, List<DatiCGModel> datiCG, List<CodiceDescrizione> stelle, List<CodiceDescrizione> apparecchiature, List<CodiceDescrizione> ariaCombustibile, List<CodiceDescrizione> controlloAria, List<CodiceDescrizione> unitaMisura, List<CodiceDescrizione> fluido) {
		this.controlli = controlli;
		this.datiGT = datiGT;
		this.datiGF = datiGF;
		this.datiSC = datiSC;
		this.datiCG = datiCG;
		this.stelle = stelle;
		this.apparecchiature = apparecchiature;
		this.ariaCombustibile = ariaCombustibile;
		this.controlloAria = controlloAria;
		this.unitaMisura = unitaMisura;
		this.fluido = fluido;
	}

	public void addControllo(DatoControlloModel controllo) {
		if (this.controlli == null)
			this.controlli = new ArrayList<>();
		this.controlli.add(controllo);
	}

	public List<DatoControlloModel> getControlli() {
		return controlli;
	}

	public void setControlli(List<DatoControlloModel> controlli) {
		this.controlli = controlli;
	}

	public List<DatiGTModel> getDatiGT() {
		return datiGT;
	}

	public void setDatiGT(List<DatiGTModel> datiGT) {
		this.datiGT = datiGT;
	}

	public List<DatiGFModel> getDatiGF() {
		return datiGF;
	}

	public void setDatiGF(List<DatiGFModel> datiGF) {
		this.datiGF = datiGF;
	}

	public List<DatiSCModel> getDatiSC() {
		return datiSC;
	}

	public void setDatiSC(List<DatiSCModel> datiSC) {
		this.datiSC = datiSC;
	}

	public List<DatiCGModel> getDatiCG() {
		return datiCG;
	}

	public void setDatiCG(List<DatiCGModel> datiCG) {
		this.datiCG = datiCG;
	}

	public List<CodiceDescrizione> getStelle() {
		return stelle;
	}

	public void setStelle(List<CodiceDescrizione> stelle) {
		this.stelle = stelle;
	}

	public List<CodiceDescrizione> getApparecchiature() {
		return apparecchiature;
	}

	public void setApparecchiature(List<CodiceDescrizione> apparecchiature) {
		this.apparecchiature = apparecchiature;
	}

	public List<CodiceDescrizione> getAriaCombustibile() {
		return ariaCombustibile;
	}

	public void setAriaCombustibile(List<CodiceDescrizione> ariaCombustibile) {
		this.ariaCombustibile = ariaCombustibile;
	}

	public List<CodiceDescrizione> getControlloAria() {
		return controlloAria;
	}

	public void setControlloAria(List<CodiceDescrizione> controlloAria) {
		this.controlloAria = controlloAria;
	}

	public List<CodiceDescrizione> getUnitaMisura() {
		return unitaMisura;
	}

	public void setUnitaMisura(List<CodiceDescrizione> unitaMisura) {
		this.unitaMisura = unitaMisura;
	}

	public List<CodiceDescrizione> getFluido() {
		return fluido;
	}

	public void setFluido(List<CodiceDescrizione> fluido) {
		this.fluido = fluido;
	}

	@Override
	public String toString() {
		return "DatiControlloModel{" + "controlli=" + controlli + ", datiGT=" + datiGT + ", datiGF=" + datiGF + ", datiSC=" + datiSC + ", datiCG=" + datiCG + ", stelle=" + stelle
				+ ", apparecchiature=" + apparecchiature + ", ariaCombustibile=" + ariaCombustibile + ", controlloAria=" + controlloAria + ", unitaMisura=" + unitaMisura + ", fluido=" + fluido + '}';
	}
}
