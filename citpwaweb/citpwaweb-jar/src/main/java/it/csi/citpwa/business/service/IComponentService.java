/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service;

import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.DatiCGModel;
import it.csi.citpwa.model.DatiGFModel;
import it.csi.citpwa.model.DatiGTModel;
import it.csi.citpwa.model.DatiSCModel;
import it.csi.citpwa.model.sigitext.*;

import java.util.List;

public interface IComponentService {
	public List<DatiGTModel> getGT(UtenteLoggato user, String codiceImpianto, Integer progressivo) throws SvistaException;

	public List<DatiGFModel> getGF(UtenteLoggato user, String codiceImpianto, Integer progressivo) throws SvistaException;

	public List<DatiSCModel> getSC(UtenteLoggato user, String codiceImpianto, Integer progressivo) throws SvistaException;

	public List<DatiCGModel> getCG(UtenteLoggato user, String codiceImpianto, Integer progressivo) throws SvistaException;

	public CodiceDescrizione[] getMarcaCIT() throws SvistaException;

	public CodiceDescrizione[] getCombustibileCIT() throws SvistaException;

	public CodiceDescrizione[] getClassDpr66096CIT() throws SvistaException;

	public CodiceDescrizione[] getFrequenzaManutCIT() throws SvistaException;

	public CodiceDescrizione[] getFluidoCIT() throws SvistaException;

	public CodiceDescrizione[] getTipologiaGT() throws SvistaException;

	public CodiceDescrizione[] getTipologiaGF() throws SvistaException;


	public CodiceDescrizione[] getFonteCIT() throws SvistaException;

	public CodiceDescrizione[] getTipoCannaFumaria() throws SvistaException;

	public Esito updateGT(String codiceImpianto, List<DatiGT> datiGT, UtenteLoggato user,Integer idImpresaSelez) throws SvistaException;

	public Esito updateGF(String codiceImpianto, List<DatiGF> datiGF, UtenteLoggato user,Integer idImpresaSelez) throws SvistaException;

	public Esito updateSC(String codiceImpianto, List<DatiSC> datiSC, UtenteLoggato user,Integer idImpresaSelez) throws SvistaException;

	public Esito updateCG(String codiceImpianto, List<DatiCG> datiCG, UtenteLoggato user,Integer idImpresaSelez) throws SvistaException;

	public Esito chekDismettiSostituisci(String dataMinima, String dataMassima, String dataDismiss) throws SvistaException;

	public Esito delComponente(String codiceImpianto, String tipo, Integer progressivo, UtenteLoggato user) throws SvistaException;
}
