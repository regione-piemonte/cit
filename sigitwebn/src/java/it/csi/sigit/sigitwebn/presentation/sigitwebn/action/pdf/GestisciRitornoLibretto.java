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

public class GestisciRitornoLibretto extends BaseAction<BaseSessionAwareDTO> {

	
	private static final long serialVersionUID = 1L;
	private BaseSessionAwareDTO model;
	
	private ServiziMgr serviziMgr;


	@Override
	public String execute()
	{
		String ret = null;
		LOG.debug("GestisciRitornoLibretto");
		try
		{

			String librettoScheda = (String)session.get(Constants.SESSIONE_VAR_LIBRETTO_SCHEDA);;
			LOG.debug("librettoScheda: " + librettoScheda);
			
			if (librettoScheda.equals("SCHEDA1_EXTRA"))
			{
				ret = "gestLibScheda1_extra";
			}
			else if (librettoScheda.equals("SCHEDA1"))
			{
				ret = "gestLibScheda1";
			}
			else if (librettoScheda.equals("SCHEDA2"))
			{
				ret = "gestLibScheda1";
			}
			else if (librettoScheda.equals("SCHEDA3"))
			{
				ret = "gestLibScheda3";
			}
			else if (librettoScheda.equals("SCHEDA4_1"))
			{
				ret = "gestLibScheda4_1";
			}
			else if (librettoScheda.equals("SCHEDA4_2"))
			{
				ret = "gestLibScheda4_2";
			}
			else if (librettoScheda.equals("SCHEDA4_3"))
			{
				ret = "gestLibScheda4_3";
			}
			else if (librettoScheda.equals("SCHEDA4_4"))
			{
				ret = "gestLibScheda4_4";
			}
			else if (librettoScheda.equals("SCHEDA4_5"))
			{
				ret = "gestLibScheda4_5";
			}
			else if (librettoScheda.equals("SCHEDA4_6"))
			{
				ret = "gestLibScheda4_6";
			}
			else if (librettoScheda.equals("SCHEDA4_7"))
			{
				ret = "gestLibScheda4_7";
			}
			else if (librettoScheda.equals("SCHEDA4_8"))
			{
				ret = "gestLibScheda4_8";
			}
			else if (librettoScheda.equals("SCHEDA5_1SR"))
			{
				ret = "gestLibScheda5_1SR";
			}
			else if (librettoScheda.equals("SCHEDA5_1VR"))
			{
				ret = "gestLibScheda5_1VR";
			}
			else if (librettoScheda.equals("SCHEDA5_2"))
			{
				ret = "gestLibScheda5_2";
			}
			else if (librettoScheda.equals("SCHEDA6_4"))
			{
				ret = "gestLibScheda6_4";
			}
			else if (librettoScheda.equals("SCHEDA6"))
			{
				ret = "gestLibScheda6";
			}
			else if (librettoScheda.equals("SCHEDA7"))
			{
				ret = "gestLibScheda7";
			}
			else if (librettoScheda.equals("SCHEDA8"))
			{
				ret = "gestLibScheda8";
			}
			else if (librettoScheda.equals("SCHEDA9_1"))
			{
				ret = "gestLibScheda9_1";
			}
			else if (librettoScheda.equals("SCHEDA9_2"))
			{
				ret = "gestLibScheda9_2";
			}
			else if (librettoScheda.equals("SCHEDA9_3"))
			{
				ret = "gestLibScheda9_3";
			}
			else if (librettoScheda.equals("SCHEDA9_4"))
			{
				ret = "gestLibScheda9_4";
			}
			else if (librettoScheda.equals("SCHEDA9_5"))
			{
				ret = "gestLibScheda9_5";
			}
			else if (librettoScheda.equals("SCHEDA9_6"))
			{
				ret = "gestLibScheda9_6";
			}
			else if (librettoScheda.equals("SCHEDA10"))
			{
				ret = "gestLibScheda10";
			}
			else if (librettoScheda.equals("SCHEDA12"))
			{
				ret = "gestLibScheda12";
			}
			else if (librettoScheda.equals("SCHEDA13"))
			{
				ret = "gestLibScheda13";
			}
			else if (librettoScheda.equals("SCHEDA14_1"))
			{
				ret = "gestLibScheda14_1";
			}
			else if (librettoScheda.equals("SCHEDA14_2"))
			{
				ret = "gestLibScheda14_2";
			}
			else if (librettoScheda.equals("SCHEDA14_3"))
			{
				ret = "gestLibScheda14_3";
			}
			else if (librettoScheda.equals("SCHEDA14_4"))
			{
				ret = "gestLibScheda14_4";
			}
			else if (librettoScheda.equals("SCHEDA15"))
			{
				ret = "gestLibScheda15";
			}

		}
		catch (Exception ex)
		{
			session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_RECUPERO_SERVIZIO, Message.ERROR));

			LOG.error(ex);
			ret = "KO";
		}
		
		LOG.debug("ret: " + ret);

		
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
