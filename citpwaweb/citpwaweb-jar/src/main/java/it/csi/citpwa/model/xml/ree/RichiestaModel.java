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

public class RichiestaModel {

	protected DatiManutentoreModel datiManutentore;
	protected DatiIntestazioneModel datiIntestazione;
	protected DatiAllegatoModel datiAllegato;

	public RichiestaModel() {
	}

	public RichiestaModel(DatiManutentoreModel datiManutentore, DatiIntestazioneModel datiIntestazione, DatiAllegatoModel datiAllegato) {
		this.datiManutentore = datiManutentore;
		this.datiIntestazione = datiIntestazione;
		this.datiAllegato = datiAllegato;
	}

	public DatiManutentoreModel getDatiManutentore() {
		return datiManutentore;
	}

	public void setDatiManutentore(DatiManutentoreModel value) {
		this.datiManutentore = value;
	}

	public DatiIntestazioneModel getDatiIntestazione() {
		return datiIntestazione;
	}

	public void setDatiIntestazione(DatiIntestazioneModel value) {
		this.datiIntestazione = value;
	}

	public DatiAllegatoModel getDatiAllegato() {
		return datiAllegato;
	}

	public void setDatiAllegato(DatiAllegatoModel value) {
		this.datiAllegato = value;
	}

	@Override
	public String toString() {
		return "RichiestaModel{" + "datiManutentoreModel=" + datiManutentore + ", datiIntestazioneModel=" + datiIntestazione + ", datiAllegatoModel=" + datiAllegato + '}';
	}
}
