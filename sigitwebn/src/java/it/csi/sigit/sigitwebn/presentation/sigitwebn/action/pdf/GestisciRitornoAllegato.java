/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.pdf;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVTotImpiantoDto;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.pdf.ModuloBuilder;
import it.csi.sigit.sigitwebn.dto.BaseSessionAwareDTO;
import it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato;
import it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicManutentore;
import it.csi.sigit.sigitwebn.dto.index.DettaglioAllegatoIndex;
import it.csi.sigit.sigitwebn.dto.index.DettaglioDocumento;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.BaseAction;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.CommandExecutionException;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ICommand;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.Validator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestisciRitornoAllegato extends BaseAction<BaseSessionAwareDTO> {

	
	private static final long serialVersionUID = 1L;
	private BaseSessionAwareDTO model;
	
	private ServiziMgr serviziMgr;


	@Override
	public String execute()
	{
		String ret = null;
		LOG.debug("GestisciRitornoAllegato");
		try
		{

			String allegatoSezione = (String)session.get(Constants.SESSIONE_VAR_ALLEGATO_SEZIONE);
			DettaglioAllegato dettaglio = (DettaglioAllegato)session.get(Constants.SESSIONE_VAR_DETT_ALLEGATO);

			LOG.debug("allegatoSezione: " + allegatoSezione);
			

			// forse non riesco a capire se GT-1...GT-2..ecc

			
			if(Constants.ALLEGATO_TIPO_1.equalsIgnoreCase(dettaglio.getIdTipoAllegato()) || Constants.ALLEGATO_TIPO_1B.equalsIgnoreCase(dettaglio.getIdTipoAllegato()))
			{
				ret = "gestReeDocumenti";
				if (allegatoSezione.equals("SEZIONE_ABCDF"))
				{
					ret = "gestReeTipo1";
				}
				else if (allegatoSezione.equals("SEZIONE_E"))
				{
					ret = "gestReeTipo1Dett";
				}
			}
			else if(Constants.ALLEGATO_TIPO_2.equalsIgnoreCase(dettaglio.getIdTipoAllegato()))
			{
				ret = "gestReeDocumenti";
				if (allegatoSezione.equals("SEZIONE_ABCDF"))
				{
					ret = "gestReeTipo2";
				}
				else if (allegatoSezione.equals("SEZIONE_E"))
				{
					ret = "gestReeTipo2Dett";
				}
			}
			else if(Constants.ALLEGATO_TIPO_3.equalsIgnoreCase(dettaglio.getIdTipoAllegato()))
			{
				ret = "gestReeDocumenti";
				if (allegatoSezione.equals("SEZIONE_ABCDF"))
				{
					ret = "gestReeTipo3";
				}
				else if (allegatoSezione.equals("SEZIONE_E"))
				{
					ret = "gestReeTipo3Dett";
				}
			}
			else if(Constants.ALLEGATO_TIPO_4.equalsIgnoreCase(dettaglio.getIdTipoAllegato()))
			{
				ret = "gestReeDocumenti";
				if (allegatoSezione.equals("SEZIONE_ABCDF"))
				{
					ret = "gestReeTipo4";
				}
				else if (allegatoSezione.equals("SEZIONE_E"))
				{
					ret = "gestReeTipo4Dett";
				}
			}
			else if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equalsIgnoreCase(dettaglio.getIdTipoAllegato())) {
				ret = "gestRapProvaGenerale";
				if (allegatoSezione.equals(Constants.LABEL_SEZIONE_RP_GEN))
				{
					ret = "gestRapProvaTipo1";
				}
				else if (allegatoSezione.equals(Constants.LABEL_SEZIONE_RP_DET))
				{
					ret = "gestRapProvaTipo1Dett";
				}
			}
			else if (Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equalsIgnoreCase(dettaglio.getIdTipoAllegato())) {
				ret = "gestRapProvaGenerale";
				if (allegatoSezione.equals(Constants.LABEL_SEZIONE_RP_GEN))
				{
					ret = "gestRapProvaTipo2";
				}
				else if (allegatoSezione.equals(Constants.LABEL_SEZIONE_RP_DET))
				{
					ret = "gestRapProvaTipo2Dett";
				}
			}
				

		}
		catch (Exception ex)
		{
			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_RECUPERO_SERVIZIO, Message.ERROR));

			LOG.error(ex);
		}
		
		LOG.debug("ret GestisciRitornoAllegato: " + ret);

		
		return ret;
	}
	

	@SuppressWarnings("rawtypes")
	public Class modelClass() {
		return getClass();
	}

	public BaseSessionAwareDTO getModel() {
		return this.model;
	}

	public void setModel(BaseSessionAwareDTO t) {
		this.model = t;
	}

	@Override
	protected void dumpModel(boolean pre) {
		
	}

	@Override
	protected void doBeforeEventCommand() throws CommandExecutionException {
		
	}

	@Override
	protected void doAfterEventCommand() throws CommandExecutionException {
	}

	@Override
	protected ICommand initCommand(String moduleName, String panelName,
			String widgName, String eventName) {
		return null;
	}

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {
		
	}
	
	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}


	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}
}
