/*
 * ******************************************************************************
 *  SPDX-License-Identifier: EUPL-1.2
 *  Copyright Regione Piemonte - 2021
 * *****************************************************************************
 */
package it.csi.citpwa.business.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.csi.citpwa.model.loccsi.LoccsiModel;
import org.codehaus.jettison.json.JSONException;

import javax.xml.rpc.ServiceException;

public interface ILoccsiService {
	public LoccsiModel[] getLOCCSICoordinates(String indirizzo) throws ServiceException, JSONException, JsonProcessingException;
}
