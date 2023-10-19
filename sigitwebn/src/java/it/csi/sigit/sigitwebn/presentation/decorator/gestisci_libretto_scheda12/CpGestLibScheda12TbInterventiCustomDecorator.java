package it.csi.sigit.sigitwebn.presentation.decorator.gestisci_libretto_scheda12;

/*PROTECTED REGION ID(R155145432) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.sigit.sigitwebn.dto.libretto.Scheda12;
import it.csi.sigit.sigitwebn.util.Constants;

import java.util.StringTokenizer;

import org.apache.log4j.Logger;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpGestLibScheda12TbInterventiCustomDecorator extends TableDecorator {

	public CpGestLibScheda12TbInterventiCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R1953024917) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);

	public String getElencoComponenti() {
		Scheda12 elenoComp = (Scheda12) this.getCurrentRowObject();

		StringBuffer ret = new StringBuffer();

		StringTokenizer tok = new StringTokenizer(elenoComp.getElencoComponenti(), ",");

		String componente = null;
		int i = 0;
		while (tok.hasMoreTokens()) {

			componente = tok.nextToken();

			log.debug("------");
			log.debug("Stampo il token: *" + componente + "*");
			log.debug("------");

			if (i != 0) {
				ret.append(", ");
			}

			ret.append(formattaComponente(elenoComp.getIdAllegato(), componente.trim()));

			i++;
		}

		log.debug("------");
		log.debug("Stampo le componenti formattate: *" + ret + "*");
		log.debug("------");

		return ret.toString();

	}

	private String formattaComponente(Integer idAllegato, String componente) {
		String link = null;
		///sigitwebn/base/gestisci_libretto_scheda12/cpGestLibScheda12TbInterventi!handleTbInterventi_CLICKED.do?idRiga=AC-1&amp;idColonna=ripristina

		//<a href="javascript://csi/" id="id_linkable_cell" onclick="updateAjaxCallback('p_wpScheda12', '/sigitwebn/base/gestisci_libretto_scheda12/cpGestLibScheda12!handleTbInterventi_CLICKED.do?idColonna=elencoComponenti', '', 'cpGestLibScheda12'); return false;">GT-2, GT-3</a>

		//<a href=\"javascript://csi/\" id=\"id_linkable_cell\" onclick="updateAjaxCallback('p_wpScheda12', '/sigitwebn/base/gestisci_libretto_scheda12/cpGestLibScheda12!handleTbInterventi_CLICKED.do?idColonna=elencoComponenti', '', 'cpGestLibScheda12'); return false;\">GT-2, GT-3</a>

		link = "<a id=\"id_linkable_cell\" href=\"/sigitwebn/base/gestisci_libretto_scheda12/cpGestLibScheda12!handleTbInterventi_CLICKED.do?idRiga="
				+ idAllegato + "&amp;idColonna=" + componente + "\">" + componente + "</a>";

		/*
		link = "<a id=\"id_linkable_cell\" href=\"javascript://csi/\"  onclick=\"updateAjaxCallback('p_wpScheda12', '/sigitwebn/base/gestisci_libretto_scheda12/cpGestLibScheda12!handleTbInterventi_CLICKED.do?idRiga="
				+ componente + "&amp;idColonna=componenti\"', '', 'cpGestLibScheda12'); return false;\">" + componente + "</a>";
		*/

		return link;
	}
	/*PROTECTED REGION END*/

}
