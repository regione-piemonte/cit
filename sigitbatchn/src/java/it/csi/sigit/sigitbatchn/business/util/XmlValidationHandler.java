/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.util;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.apache.log4j.Logger;



public class XmlValidationHandler implements ValidationEventHandler {

	/** The log. */
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);
	
    public boolean handleEvent(ValidationEvent event) {
    	log.error("\nEVENT");
        log.error("SEVERITY:  " + event.getSeverity());
        log.error("MESSAGE:  " + event.getMessage());
        log.error("LINKED EXCEPTION:  " + event.getLinkedException());
        log.error("LOCATOR");
        log.error("    LINE NUMBER:  " + event.getLocator().getLineNumber());
        log.error("    COLUMN NUMBER:  " + event.getLocator().getColumnNumber());
        log.error("    OFFSET:  " + event.getLocator().getOffset());
        log.error("    OBJECT:  " + event.getLocator().getObject());
        log.error("    NODE:  " + event.getLocator().getNode());
        log.error("    URL:  " + event.getLocator().getURL());
        return true;
    }

}
