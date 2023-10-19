/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch.importmassivodistributori;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestisce gli import corretti
 * 
 */
public class Importati {
	
	/**
	 * Lista dei rapporto controllo inviati
	 */
	private List<Rapporto> rapportoControlloList = null;

	/**
	 * Id del manutentore associato all'impianto
	 */
	private Integer idManutentore = null;
	/**
	 * Mail del manutentore associato all'impianto
	 */
	private String mailManutentore = null;
	/**
	 * Codice dell'impianto per cui si sono riscontrati errori
	 */
	private Integer codiceImpianto = null;
	
	/**
	 * Restituisce l'Id del manutentore associato all'impianto
	 * 
	 * @return Id del manutentore associato all'impianto
	 */
	public Integer getIdManutentore() {
		return idManutentore;
	}

	
	/**
	 * Imposta l'Id del manutentore associato all'impianto
	 * 
	 * @param idManutentore Id del manutentore associato all'impianto
	 */
	public void setIdManutentore(Integer idManutentore) {
		this.idManutentore = idManutentore;
	}

	/**
	 * Restituisce la mail del manutentore associato all'impianto
	 * 
	 * @return Mail del manutentore associato all'impianto
	 */
	public String getMailManutentore() {
		return mailManutentore;
	}

	/**
	 * Imposta la mail del manutentore associato all'impianto
	 * 
	 * @param mailManutentore Mail del manutentore associato all'impianto
	 */
	public void setMailManutentore(String mailManutentore) {
		this.mailManutentore = mailManutentore;
	}

	/**
	 * Imposta il codice dell'impianto per cui si sono riscontrati errori
	 * 
	 * @param codiceImpianto Codice dell'impianto per cui si sono riscontrati
	 *            errori
	 */
	public void setCodiceImpianto(Integer codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}

	/**
	 * Restituisce il codice dell'impianto per cui si sono riscontrati errori
	 * 
	 * @return Codice dell'impianto per cui si sono riscontrati errori
	 */
	public Integer getCodiceImpianto() {
		return codiceImpianto;
	}

	/**
	 * Imposta la lista dei rapporto controllo inviati
	 * 
	 * @param rapportoControlloList Lista dei  rapporto controllo inviati
	 */
	public void setRapportoControlloList(List<Rapporto> rapportoControlloList) {
		this.rapportoControlloList = rapportoControlloList;
	}

	/**
	 * Restituisce la lista dei rapporto controllo inviati
	 * 
	 * @return Lista dei rapporto controllo inviati
	 */
	public List<Rapporto> getRapportoControlloList() {
		return rapportoControlloList;
	}

	/**
	 * Aggiunge un errore alla lista dei rapporto controllo inviati
	 * 
	 * @param rapportoControllo rapportoControllo da aggiungere
	 */
	public void addRapportoControllo(Rapporto rapportoControllo) {
		if(rapportoControlloList == null) {
			rapportoControlloList = new ArrayList<Rapporto>();
		}
		rapportoControlloList.add(rapportoControllo);
	}

	/**
	 * Pulisce la lista dei rapporto controllo inviati
	 */
	public void cleanRapportoControlloList() {
		rapportoControlloList = new ArrayList<Rapporto>();
	}
}
