/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service;

import it.csi.citpwa.exception.ValidationErrorException;
import it.csi.citpwa.model.DatiCGModel;
import it.csi.citpwa.model.DatiGFModel;
import it.csi.citpwa.model.DatiGTModel;
import it.csi.citpwa.model.DatiSCModel;
import it.csi.citpwa.model.sigitext.*;

import java.util.List;

public interface IComponentService {
	public List<DatiGTModel> getGT(UtenteLoggato user, String codiceImpianto, Integer progressivo) throws Exception;

	public List<DatiGFModel> getGF(UtenteLoggato user, String codiceImpianto, Integer progressivo) throws Exception;

	public List<DatiSCModel> getSC(UtenteLoggato user, String codiceImpianto, Integer progressivo) throws Exception;

	public List<DatiCGModel> getCG(UtenteLoggato user, String codiceImpianto, Integer progressivo) throws Exception;

	public CodiceDescrizione[] getMarcaCIT() throws Exception;

	public CodiceDescrizione[] getCombustibileCIT() throws Exception;

	public CodiceDescrizione[] getFluidoCIT() throws Exception;

	public CodiceDescrizione[] getTipologiaGT() throws Exception;

	public CodiceDescrizione[] getTipologiaGF() throws Exception;


	public CodiceDescrizione[] getFonteCIT() throws Exception;

	public CodiceDescrizione[] getTipoCannaFumaria() throws Exception;

	public Esito updateGT(String codiceImpianto, List<DatiGT> datiGT, UtenteLoggato user,Integer idImpresaSelez) throws Exception;

	public Esito updateGF(String codiceImpianto, List<DatiGF> datiGF, UtenteLoggato user,Integer idImpresaSelez) throws Exception;

	public Esito updateSC(String codiceImpianto, List<DatiSC> datiSC, UtenteLoggato user,Integer idImpresaSelez) throws Exception;

	public Esito updateCG(String codiceImpianto, List<DatiCG> datiCG, UtenteLoggato user,Integer idImpresaSelez) throws Exception;

	public Esito chekDismettiSostituisci(String dataMinima, String dataMassima, String dataDismiss) throws Exception;

	public Esito delComponente(String codiceImpianto, String tipo, Integer progressivo, UtenteLoggato user) throws Exception;
}
