package it.csi.sigit.sigitwebn.presentation.decorator.gestisci_accertamento;

/*PROTECTED REGION ID(R-1375919034) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import org.apache.log4j.Logger;

import it.csi.sigit.sigitwebn.dto.azioni.Azione;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.GenericUtil;

/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDettaglioAccertamentoTbAzioniCustomDecorator extends TableDecorator {

	public CpDettaglioAccertamentoTbAzioniCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R1200594563) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);

	public String getNomeDoc() {
		log.debug("[CpDettaglioAccertamentoTbAzioniCustomDecorator::getNomeDoc] CUSTOMIZZAZIONE COLONNA");
		Azione azione = (Azione) this.getCurrentRowObject();

		if (log.isDebugEnabled())
			GenericUtil.stampa(azione, true, 3);

		String link = "";
		if (azione.getIdDocAzione() != null) {
			link = "<a id=\"id_linkable_cell\" href=\"/sigitwebn/base/gestisci_accertamento/cpDettaglioAccertamento!handleTbAzioni_CLICKED.do?idRiga="
					+ azione.getIdDocAzione() + "&amp;idColonna=" + azione.getIdAzione() + "\"><span class=\"pdf\">"
					+ azione.getNomeDoc() + "</span></a>";
		}

		log.debug("[CpDettaglioAccertamentoTbAzioniCustomDecorator::getNomeDoc] link: " + link);

		return link;

	}

	/*PROTECTED REGION END*/

}
