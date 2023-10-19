package it.csi.sigit.sigitwebn.presentation.decorator.gestisci_sanzioni;

/*PROTECTED REGION ID(R-948347244) ENABLED START*/
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import org.apache.log4j.Logger;
import it.csi.sigit.sigitwebn.dto.azioni.Azione;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDettaglioSanzioneTbAzioniSvolteCustomDecorator extends TableDecorator {

	public CpDettaglioSanzioneTbAzioniSvolteCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R1741821009) ENABLED START*/

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);

	public String getNomeDoc() {
		log.debug("[CpDettaglioSanzioneTbAzioniSvolteCustomDecorator::getNomeDoc] CUSTOMIZZAZIONE COLONNA");
		Azione azione = (Azione) this.getCurrentRowObject();

		if (log.isDebugEnabled())
			GenericUtil.stampa(azione, true, 3);

		String link = "";
		if (azione.getIdDocAzione() != null) {
			link = "<a id=\"id_linkable_cell\" href=\"/sigitwebn/base/gestisci_sanzioni/cpDettaglioSanzione!handleTbAzioniSvolte_CLICKED.do?idRiga="
					+ azione.getIdDocAzione() + "&amp;idColonna=" + azione.getIdAzione() + "\"><span class=\"pdf\">"
					+ azione.getNomeDoc() + "</span></a>";
		}

		log.debug("[CpDettaglioAccertamentoTbAzioniCustomDecorator::getNomeDoc] link: " + link);

		return link;

	}

	/*PROTECTED REGION END*/

}
