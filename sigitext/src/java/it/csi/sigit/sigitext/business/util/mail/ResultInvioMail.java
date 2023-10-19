/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.util.mail;

import java.util.ArrayList;

public class ResultInvioMail {

	private ArrayList<String> destinatariOK = new ArrayList<String>();
	private ArrayList<String> destinatariKO = new ArrayList<String>();

	public ArrayList<String> getDestinatariOK() {
		return destinatariOK;
	}

	public void setDestinatariOK(ArrayList<String> destinatariOK) {
		this.destinatariOK = destinatariOK;
	}

	public ArrayList<String> getDestinatariKO() {
		return destinatariKO;
	}

	public void setDestinatariKO(ArrayList<String> destinatariKO) {
		this.destinatariKO = destinatariKO;
	}
	
	public void addDestinatarioOK(String destinatarioOK)
	{
		destinatariOK.add(destinatarioOK);
	}
	
	public void addDestinatarioKO(String destinatarioKO)
	{
		destinatariKO.add(destinatarioKO);
	}
	
	public String getFormatDestinatariOK()
	{
		StringBuffer destinatariResult = null;

		if (destinatariOK != null && !destinatariOK.isEmpty())
		{
			
			for (String destinatarioResult : destinatariOK) {
				if (destinatariResult == null)
				{
					destinatariResult = new StringBuffer();
				}
				else
				{
					destinatariResult.append(", ");
				}
				
				destinatariResult.append(destinatarioResult);
			}
		}
		
		return destinatariResult!=null?destinatariResult.toString():null;
	}
	
	public String getFormatDestinatariKO()
	{
		StringBuffer destinatariResult = null;

		if (destinatariKO != null && !destinatariKO.isEmpty())
		{
			
			for (String destinatarioResult : destinatariKO) {
				if (destinatariResult == null)
				{
					destinatariResult = new StringBuffer();
				}
				else
				{
					destinatariResult.append(", ");
				}
				
				destinatariResult.append(destinatarioResult);
			}
		}
		
		return destinatariResult!=null?destinatariResult.toString():null;
	}
	
	public boolean isPresentsOK()
	{
		boolean result = false;
		
		if (destinatariOK != null && !destinatariOK.isEmpty())
		{
			result = true;
		}
		return result;
	}
	
	public boolean isPresentsKO()
	{
		boolean result = false;
		
		if (destinatariKO != null && !destinatariKO.isEmpty())
		{
			result = true;
		}
		return result;
	}
	
	
}
