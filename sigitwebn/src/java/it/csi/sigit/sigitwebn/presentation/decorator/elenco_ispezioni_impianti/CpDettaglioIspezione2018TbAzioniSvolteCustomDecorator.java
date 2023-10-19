package it.csi.sigit.sigitwebn.presentation.decorator.elenco_ispezioni_impianti;

/*PROTECTED REGION ID(R-1209795126) ENABLED START*/
import it.csi.sigit.sigitwebn.util.GenericUtil;
import org.apache.log4j.Logger;
import it.csi.sigit.sigitwebn.dto.azioni.Azione;
import it.csi.sigit.sigitwebn.util.Constants;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDettaglioIspezione2018TbAzioniSvolteCustomDecorator extends TableDecorator {

	public CpDettaglioIspezione2018TbAzioniSvolteCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R2040989959) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);

	public String getNomeDoc() {
		log.debug("[CpDettaglioIspezione2018TbAzioniSvolteCustomDecorator::getNomeDoc] CUSTOMIZZAZIONE COLONNA");
		Azione azione = (Azione) this.getCurrentRowObject();

		if (log.isDebugEnabled())
			GenericUtil.stampa(azione, true, 3);

		String link = "";
		if (azione.getIdDocAzione() != null) {
			link = "<a id=\"id_linkable_cell\" href=\"/sigitwebn/base/elenco_ispezioni_impianti/cpDettaglioIspezione2018!handleTbAzioniSvolte_CLICKED.do?idRiga="
					+ azione.getIdDocAzione() + "&amp;idColonna=" + azione.getIdAzione() + "\"><span class=\"pdf\">"
					+ azione.getNomeDoc() + "</span></a>";
		}

		log.debug("[CpDettaglioIspezione2018TbAzioniSvolteCustomDecorator::getNomeDoc] link: " + link);

		return link;

	}

	/*PROTECTED REGION END*/

}
