/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.presentation.decorator.gestisci_libretto_scheda13;
import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;
/*PROTECTED REGION ID(R1086908826) ENABLED START*/
/// inserire qui eventuali import aggiuntive
/*PROTECTED REGION END*/

public class TbRisultatiRicercaRapportoLinkableColDecorator implements DisplaytagColumnDecorator {

	public TbRisultatiRicercaRapportoLinkableColDecorator() {
		super();

	}

	public Object decorate(Object arg0, PageContext arg1, MediaTypeEnum arg2) throws DecoratorException {
		Object res = arg0;
		/*PROTECTED REGION ID(R-173123359) ENABLED START*/
		/// Questo spazio e' destinato alla definizione del Decorator.
		/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
		/// http://displaytag.sourceforge.net/1.2 
		//res =  "<b>" + arg0 + "</b>";
		/*PROTECTED REGION END*/
		return res;
	}

}
