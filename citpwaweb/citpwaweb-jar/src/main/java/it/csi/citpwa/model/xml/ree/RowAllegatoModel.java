/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.2 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.09.29 alle 03:15:24 PM CEST 
//

package it.csi.citpwa.model.xml.ree;

import java.math.BigInteger;

public class RowAllegatoModel {

	protected BigInteger num;
	protected TabFumiModel tabFumi;

	protected ControlloVerificaEnergeticaModel controlloVerificaEnergetica;

	//tipo1B
	protected TabCombustibileModel tabCombustibile;

	public RowAllegatoModel() {
	}

	public RowAllegatoModel(BigInteger num, TabFumiModel tabFumi, ControlloVerificaEnergeticaModel controlloVerificaEnergetica, TabCombustibileModel tabCombustibile) {
		this.num = num;
		this.tabFumi = tabFumi;
		this.controlloVerificaEnergetica = controlloVerificaEnergetica;
		this.tabCombustibile = tabCombustibile;
	}

	public BigInteger getNum() {
		return num;
	}

	public void setNum(BigInteger value) {
		this.num = value;
	}

	public TabFumiModel getTabFumi() {
		return tabFumi;
	}

	public void setTabFumi(TabFumiModel value) {
		this.tabFumi = value;
	}

	public ControlloVerificaEnergeticaModel getControlloVerificaEnergetica() {
		return controlloVerificaEnergetica;
	}

	public void setControlloVerificaEnergetica(ControlloVerificaEnergeticaModel value) {
		this.controlloVerificaEnergetica = value;
	}

	public TabCombustibileModel getTabCombustibile() {
		return tabCombustibile;
	}

	public void setTabCombustibile(TabCombustibileModel tabCombustibile) {
		this.tabCombustibile = tabCombustibile;
	}

	@Override
	public String toString() {
		return "RowAllegatoModel{" + "numGT=" + num + ", tabFumi=" + tabFumi + ", controlloVerificaEnergetica=" + controlloVerificaEnergetica + ", tabCombustibile=" + tabCombustibile + '}';
	}
}
