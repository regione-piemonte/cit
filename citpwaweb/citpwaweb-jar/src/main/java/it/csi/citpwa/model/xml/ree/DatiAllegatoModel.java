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

public class DatiAllegatoModel {

	protected DatiIdentificativiModel datiIdentificativi;
	protected DocumentazioneTecnicaModel documentazioneTecnica;
	protected TrattamentoAcquaModel trattamentoAcqua;
	protected ControlloImpiantoModel controlloImpianto;
	protected CheckListModel checkList;
	protected DatiTecnicoModel datiTecnico;
	protected AllegatoModel allegato;

	public DatiAllegatoModel() {
	}

	public DatiAllegatoModel(DatiIdentificativiModel datiIdentificativi, DocumentazioneTecnicaModel documentazioneTecnica, TrattamentoAcquaModel trattamentoAcqua, ControlloImpiantoModel controlloImpianto, CheckListModel checkList, DatiTecnicoModel datiTecnico, AllegatoModel allegato) {
		this.datiIdentificativi = datiIdentificativi;
		this.documentazioneTecnica = documentazioneTecnica;
		this.trattamentoAcqua = trattamentoAcqua;
		this.controlloImpianto = controlloImpianto;
		this.checkList = checkList;
		this.datiTecnico = datiTecnico;
		this.allegato = allegato;
	}

	public DatiIdentificativiModel getDatiIdentificativi() {
		return datiIdentificativi;
	}

	public void setDatiIdentificativi(DatiIdentificativiModel value) {
		this.datiIdentificativi = value;
	}

	public DocumentazioneTecnicaModel getDocumentazioneTecnica() {
		return documentazioneTecnica;
	}

	public void setDocumentazioneTecnica(DocumentazioneTecnicaModel value) {
		this.documentazioneTecnica = value;
	}

	public TrattamentoAcquaModel getTrattamentoAcqua() {
		return trattamentoAcqua;
	}

	public void setTrattamentoAcqua(TrattamentoAcquaModel value) {
		this.trattamentoAcqua = value;
	}

	public ControlloImpiantoModel getControlloImpianto() {
		return controlloImpianto;
	}

	public void setControlloImpianto(ControlloImpiantoModel value) {
		this.controlloImpianto = value;
	}

	public CheckListModel getCheckList() {
		return checkList;
	}

	public void setCheckList(CheckListModel value) {
		this.checkList = value;
	}

	public DatiTecnicoModel getDatiTecnico() {
		return datiTecnico;
	}

	public void setDatiTecnico(DatiTecnicoModel value) {
		this.datiTecnico = value;
	}

	public AllegatoModel getAllegato() {
		return allegato;
	}

	public void setAllegato(AllegatoModel value) {
		this.allegato = value;
	}

	@Override
	public String toString() {
		return "DatiAllegatoModel{" + "datiIdentificativiModel=" + datiIdentificativi + ", documentazioneTecnicaModel=" + documentazioneTecnica + ", trattamentoAcquaModel=" + trattamentoAcqua
				+ ", controlloImpianto=" + controlloImpianto + ", checkList=" + checkList + ", datiTecnicoModel=" + datiTecnico + ", allegatoII=" + allegato + '}';
	}
}
