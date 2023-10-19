package it.csi.sigit.sigitwebn.presentation.decorator.elenco_ispezioni_impianti;

/*PROTECTED REGION ID(R131599518) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import org.apache.log4j.Logger;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDettaglioIspezione2018TbRapportiProvaCustomDecorator extends TableDecorator {

	public CpDettaglioIspezione2018TbRapportiProvaCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R-415712037) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);

	public String getLabelFileFirmato() {
		log.debug(
				"[CpDettaglioIspezione2018TbRapportiProvaCustomDecorator::getLabelFileFirmato] CUSTOMIZZAZIONE COLONNA");
		DettaglioAllegato allegato = (DettaglioAllegato) this.getCurrentRowObject();

		if (log.isDebugEnabled())
			GenericUtil.stampa(allegato, true, 3);

		String link = "";
		if (allegato.getLabelFileFirmato() != null) {
			link = "<a id=\"id_rapp_prova_firmato_linkable_cell\" href=\"/sigitwebn/base/elenco_ispezioni_impianti/cpDettaglioIspezione2018!handleTbRapportiProva_CLICKED.do?idRiga="
					+ allegato.getIdAllegato() + "\"><span class=\"pdf\">" + allegato.getLabelFileFirmato()
					+ "</span></a>";
		}

		log.debug("[CpDettaglioIspezione2018TbRapportiProvaCustomDecorator::getLabelFileFirmato] link: " + link);

		return link;

	}
	/*PROTECTED REGION END*/

}
