/*
 * ******************************************************************************
 *  SPDX-License-Identifier: EUPL-1.2
 *  Copyright Regione Piemonte - 2021
 * *****************************************************************************
 */
package it.csi.citpwa.business.service;

import java.util.List;

import it.csi.citpwa.model.ComuneEstesoModel;

public interface ISvistaService {

	public List<ComuneEstesoModel> getComuniEstesiDaSessionContext();

}
