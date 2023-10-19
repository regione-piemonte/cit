package it.csi.sigit.sigitwebn.presentation.decorator.gestisci_libretto_scheda13;

/*PROTECTED REGION ID(R-1990524947) ENABLED START*/

import org.displaytag.decorator.TableDecorator;
import org.apache.log4j.Logger;

import it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018;
import it.csi.sigit.sigitwebn.util.Constants;

/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpGestLibScheda13TbRisultatiRicercaCustomDecorator extends TableDecorator {

	public CpGestLibScheda13TbRisultatiRicercaCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R-802277398) ENABLED START*/
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);

	public String getRapportoLinkable() {
		log.debug("[CpGestLibScheda13TbRisultatiRicercaCustomDecorator::getRapportoLinkable] CUSTOMIZZAZIONE COLONNA");
		Ispezione2018 ispezione = (Ispezione2018) this.getCurrentRowObject();
		String link = "";
		//si risale alla stringa indicata nell'ispezione
		if (ispezione.getRapportiId() != null && !ispezione.getRapportiId().isEmpty()) {
			for (int i = 0; i < ispezione.getRapportiId().size(); i++) {
				String rappProva = ispezione.getRapportiDesc().get(i);
				//				link += "<a id=\"id_linkable_cell\" href=\"/sigitwebn/base/main/generaRappProvaNOW.do\"><span class=\"pdf\">"
				//						+ rappProva + "</span></a>";
				//				if (i < ispezione.getRapportiId().size() - 1) {
				//					link += "<br/>";
				//				}

				link += "<a id=\"id_linkable_cell\" href=\"/sigitwebn/base/gestisci_libretto_scheda13/cpGestLibScheda13!handleBtnHidden_CLICKED.do?idRiga="
						+ ispezione.getRapportiId().get(i) + "\"><span class=\"pdf\">" + rappProva + "</span></a>";
				if (i < ispezione.getRapportiId().size() - 1) {
					link += "<br/>";
				}
			}
		}

		log.debug("[CpGestLibScheda13TbRisultatiRicercaCustomDecorator::getRapportoLinkable] link: " + link);

		return link;

	}

	/*PROTECTED REGION END*/

}
