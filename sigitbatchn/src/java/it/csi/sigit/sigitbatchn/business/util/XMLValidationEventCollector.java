/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.util;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.util.ValidationEventCollector;

public class XMLValidationEventCollector extends ValidationEventCollector {

    @Override
    public boolean handleEvent(ValidationEvent event) {
        super.handleEvent(event);
        return true;
    }

}