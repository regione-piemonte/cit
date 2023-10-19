/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package test;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.util.ValidationEventCollector;

class JAXB2ValidationEventCollector extends ValidationEventCollector {

    @Override
    public boolean handleEvent(ValidationEvent event) {
        super.handleEvent(event);
        return true;
    }

}