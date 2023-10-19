package it.csi.sigit.sigitwebn.presentation.decorator.gestisci_verifica;

/*PROTECTED REGION ID(R1692124533) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import org.apache.log4j.Logger;

import it.csi.sigit.sigitwebn.dto.azioni.Azione;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.GenericUtil;

/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDettaglioVerificaTbAzioniCustomDecorator extends TableDecorator {

	public CpDettaglioVerificaTbAzioniCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R984792946) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);

	public String getNomeDoc() {
		log.debug("[CpDettaglioVerificaTbAzioniCustomDecorator::getNomeDoc] CUSTOMIZZAZIONE COLONNA");
		Azione azione = (Azione) this.getCurrentRowObject();

		if (log.isDebugEnabled())
			GenericUtil.stampa(azione, true, 3);

		//		String link = "<a href=\"javascript://csi/\" id=\"id_linkable_cell\" onclick=\"updateAjaxCallback('p_wpAzioni', '/sigitwebn/base/gestisci_verifica/cpDettaglioVerifica!handleTbAzioni_CLICKED.do?idRiga="
		//				+ azione.getIdDocAzione() + "&amp;idColonna=" + azione.getIdAzione()
		//				+ "', '', 'cpDettaglioVerifica'); return false;\">" + azione.getNomeDoc() + "</a>";

		//		String link = "<a id=\"id_linkable_cell\" href=\"/sigitwebn/base/gestisci_verifica/cpDettaglioVerifica!handleTbAzioni_CLICKED.do?idRiga="
		//				+ azione.getIdDocAzione() + "&amp;idColonna=" + azione.getIdAzione() + "\"><span class=\"pdf\">"
		//				+ azione.getNomeDoc() + "XXX</span></a>";

		String link = "";
		if (azione.getIdDocAzione() != null) {
			link = "<a id=\"id_linkable_cell\" href=\"/sigitwebn/base/gestisci_verifica/cpDettaglioVerifica!handleTbAzioni_CLICKED.do?idRiga="
					+ azione.getIdDocAzione() + "&amp;idColonna=" + azione.getIdAzione() + "\"><span class=\"pdf\">"
					+ azione.getNomeDoc() + "</span></a>";
		}

		//http://tst-appweb.reteunitaria.piemonte.it/sigitwebn/base/gestisci_verifica/cpDettaglioVerifica.do

		String fink = "<a id=\"id_linkable_cell\" href=\"/sigitwebn/base/gestisci_libretto_scheda12/cpGestLibScheda12!handleTbInterventi_CLICKED.do?idRiga=123\">"
				+ 123 + "</a>";

		//String fink = "<a id="id_linkable_cell" href="/siceebo/base/ricercaAce/cpRisultatoAce!handleTblRisultatoAce_CLICKED.do?idRiga=2013 102547 0010&amp;idColonna=flgModulo"><span class="pdf">Modulo A.P.E.</span></a>

		log.debug("[CpDettaglioVerificaTbAzioniCustomDecorator::getNomeDoc] link: " + link);

		return link;

	}
	/*PROTECTED REGION END*/

}
