/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.elencom.business.manager;
import it.csi.sigit.elencom.business.dao.elencom.dao.MvOdVistaDettaglioImpiantiDao;
import it.csi.sigit.elencom.business.dao.elencom.dao.MvOdVistaDettaglioImpiantiDao;
import it.csi.sigit.elencom.business.dao.elencom.dao.SigitTFormazioneDao;
import it.csi.sigit.elencom.business.dao.elencom.dao.SigitTPersonaGiuridicaDao;
import it.csi.sigit.elencom.business.dao.elencom.dto.MvOdVistaDettaglioImpiantiDto;
import it.csi.sigit.elencom.business.dao.elencom.dto.OdVistaDettaglioImpiantiDto;
import it.csi.sigit.elencom.business.dao.elencom.dto.SigitTFormazioneDto;
import it.csi.sigit.elencom.business.dao.elencom.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.elencom.business.dao.elencom.exceptions.MvOdVistaDettaglioImpiantiDaoException;
import it.csi.sigit.elencom.dto.common.DettaglioGeograficoPortale;
import it.csi.sigit.elencom.dto.ricercamanutentoretns.CodiceDescrizione;
import it.csi.sigit.elencom.dto.ricercamanutentoretns.Corso;
import it.csi.sigit.elencom.dto.ricercamanutentoretns.FiltroManutentore;
import it.csi.sigit.elencom.dto.ricercamanutentoretns.Manutentore;
import it.csi.sigit.elencom.util.Constants;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class ElencoManager implements  java.io.Serializable{

	private static final long serialVersionUID = -6404701382886955444L;

	protected static final Logger log = Logger
	.getLogger(Constants.APPLICATION_CODE + ".ElencoManager==>");
	
	private SigitTPersonaGiuridicaDao sigitTPersonaGiuridica;
	private SigitTFormazioneDao sigitTFormazione;
	private MvOdVistaDettaglioImpiantiDao mvVistaDettaglioImpiantiDao;
	
	public ArrayList<CodiceDescrizione> getListaProvince ()throws Exception
	{
		String header = "getListaProvince==>.";
		log.debug(header+"inizio 2 ");
		ArrayList<CodiceDescrizione>  lista  = new ArrayList<CodiceDescrizione>();
		
		try{
			List<SigitTPersonaGiuridicaDto> listaPro =	getSigitTPersonaGiuridica().findProvince("");
			for (int i = 0; i < listaPro.size(); i++) {
				SigitTPersonaGiuridicaDto dto = new SigitTPersonaGiuridicaDto();
				dto = listaPro.get(i);
				if(dto!=null)
				{
					CodiceDescrizione cod = new CodiceDescrizione();
					cod.setCodice(dto.getSiglaProv());
					cod.setDescrizione(dto.getProvincia());
					lista.add(cod);
				}
			}
		log.debug(header+"fine");
		}	
		catch (Exception ex)
		{
			log.error(header+"errore= ", ex);
		}
		return lista;
	}
	
	public ArrayList<CodiceDescrizione> getListaComuni (String input)throws Exception
	{
		String header = "getListaComuni==>.";
		log.debug(header+"inizio  ");
		log.debug(header+"input =  "+input);
		ArrayList<CodiceDescrizione>  lista  = new ArrayList<CodiceDescrizione>();
		try{
			log.debug(header+"vado sul getComuneDao()");
			List<SigitTPersonaGiuridicaDto> listaCo =	getSigitTPersonaGiuridica().findComuni(input);
			log.debug(header+"listaCo not null");
			for (int i = 0; i < listaCo.size(); i++) {
				SigitTPersonaGiuridicaDto dto = new SigitTPersonaGiuridicaDto();
				dto = listaCo.get(i);
				if(dto!=null)
				{
					CodiceDescrizione cod = new CodiceDescrizione();
					cod.setCodice(dto.getIstatComune());
					cod.setDescrizione(dto.getComune());
					log.debug(header+"cod.getCodice() = "+cod.getCodice());
					log.debug(header+"cod.getDescrizione() = "+cod.getDescrizione());
					lista.add(cod);
				}
			}
			log.debug(header+"fine");
		}	
		catch (Exception ex)
		{
			log.error(header+"errore= ", ex);
		}
		return lista;
	}
	
	public ArrayList<Manutentore> getListaManutentori (FiltroManutentore filtroManutentore)throws Exception
	{
		String header = "getListaManutentori==>.";
		log.debug(header+"inizio  ");
		log.debug(header+"input.getDenominazione() =  "+filtroManutentore.getDenominazione());
		log.debug(header+"input.getComune() =  "+filtroManutentore.getComune());
		log.debug(header+"input.getProvincia() =  "+filtroManutentore.getProvincia());
		ArrayList<Manutentore>  lista  = new ArrayList<Manutentore>();
		try{
			log.debug(header+"vado sul getManutentoreDao()");
			SigitTPersonaGiuridicaDto filtroDto = new SigitTPersonaGiuridicaDto();
			filtroDto.setSiglaProv(filtroManutentore.getProvincia());
			filtroDto.setIstatComune(filtroManutentore.getComune());
			filtroDto.setDenominazione(filtroManutentore.getDenominazione());
			List<SigitTPersonaGiuridicaDto> listaManu = getSigitTPersonaGiuridica().findPersonaGiuridica(filtroDto);
			if(listaManu == null )
			{
				log.debug(header+"listaManu  null");
			}
			else
			{
				log.debug(header+"listaManu not null");
				log.debug(header+"listaManu.size() =  "+listaManu.size());
			}
			for (int i = 0; i < listaManu.size(); i++) {
				SigitTPersonaGiuridicaDto dto = new SigitTPersonaGiuridicaDto();
				dto = listaManu.get(i);
				if(dto!=null)
				{
					Manutentore manu = new Manutentore();
					manu.setIdManutentore(String.valueOf(dto.getIdPersonaGiuridica().intValue()));
					manu.setProvincia(dto.getProvincia());
					manu.setComune(dto.getComune());
					manu.setDenominazione(dto.getDenominazione());
					manu.setCivico(dto.getCivico());
					manu.setIndirizzo(StringUtils.isEmpty(dto.getIndirizzoNonTrovato()) ? dto.getIndirizzoSitad() : dto.getIndirizzoNonTrovato());
					//manu.setFlgInstallatore(dto.getFlgInstallatore()!=null && dto.getFlgInstallatore().equals(BigDecimal.ZERO) ? Constants.NO : Constants.SI);
					manu.setFlgManutentore(dto.getFlgDm37Letterac()!=null && dto.getFlgDm37Letterac().equals(BigDecimal.ZERO) ? Constants.NO : Constants.SI);
					manu.setFlgTerzoResponsabile(dto.getFlgTerzoResponsabile()!=null && dto.getFlgTerzoResponsabile().equals(BigDecimal.ZERO) ? Constants.NO : Constants.SI);
//					log.debug(header+"manu.getIdManutentore() = "+manu.getIdManutentore());
//					log.debug(header+"manu.getDenominazione() = "+manu.getDenominazione());
//					log.debug(header+"manu.getCivico() = "+manu.getCivico());
//					log.debug(header+"manu.getIndirizzo() = "+manu.getIndirizzo());
//					log.debug(header+"manu.getProvincia()= "+manu.getProvincia());
//					log.debug(header+"manu.getComune() = "+manu.getComune());
					manu.setUbicazione(manu.getIndirizzo()+" "+ manu.getCivico()+", " + manu.getComune()+" (" + manu.getProvincia()+")");
					lista.add(manu);
				}
			}
//			log.debug(header+"lista.size() = "+lista.size());
//			log.debug(header+"fine");
		}	
		catch (Exception ex)
		{
			log.error(header+"errore= ", ex);
		}
		return lista;
	}
	
	public ArrayList<Corso> getListaCorsi(Integer idPersonaGiuridica) throws Exception
	{
		log.debug("getListaCorsi di " + idPersonaGiuridica);
		ArrayList<Corso> lista = new ArrayList<Corso>();
		try
		{
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				List<SigitTFormazioneDto> listaCorsi = getSigitTFormazione().findFormazionePG(idPersonaGiuridica);
				if(listaCorsi!=null)
				{
					log.debug("Corsi trovati :" + listaCorsi.size());
					for (int i = 0; i < listaCorsi.size(); i++) {
						SigitTFormazioneDto dto = new SigitTFormazioneDto();
						dto = listaCorsi.get(i);
						if(dto!=null)
						{
							Corso corso = new Corso();
							corso.setDataCorso(sdf.format(dto.getDataCorso()));
							corso.setDescrizione(dto.getDesCorso());
							lista.add(corso);
						}
					}
				}
				else
					log.debug("Nessun corso trovato");
		}	
		catch (Exception ex)
		{
			log.error("errore: ", ex);
			throw ex;
		}
		finally{
			log.debug("getListaCorsi : END");
		}
		return lista;
	}

	
	String urlHome = null;
	
	public String getUrlHome() {
		return urlHome;
	}

	public void setUrlHome(String urlHome) {
		this.urlHome = urlHome;
	}

	public SigitTPersonaGiuridicaDao getSigitTPersonaGiuridica() {
		return sigitTPersonaGiuridica;
	}

	public void setSigitTPersonaGiuridica(
			SigitTPersonaGiuridicaDao sigitTPersonaGiuridica) {
		this.sigitTPersonaGiuridica = sigitTPersonaGiuridica;
	}

	public SigitTFormazioneDao getSigitTFormazione() {
		return sigitTFormazione;
	}

	public void setSigitTFormazione(SigitTFormazioneDao sigitTFormazione) {
		this.sigitTFormazione = sigitTFormazione;
	}

	public MvOdVistaDettaglioImpiantiDao getMvVistaDettaglioImpiantiDao() {
		return mvVistaDettaglioImpiantiDao;
	}

	public void setMvVistaDettaglioImpiantiDao(MvOdVistaDettaglioImpiantiDao mvVistaDettaglioImpiantiDao) {
		this.mvVistaDettaglioImpiantiDao = mvVistaDettaglioImpiantiDao;
	}

	public ArrayList<DettaglioGeograficoPortale> getDettaglioGeoportale(String coordinate, String coordinate1, String appDataWMSComp) throws MvOdVistaDettaglioImpiantiDaoException {
		MvOdVistaDettaglioImpiantiDto filter = new MvOdVistaDettaglioImpiantiDto();
		filter.setCoordXLongDd(new BigDecimal(coordinate));
		filter.setCoordYLatDd(new BigDecimal(coordinate1));
		filter.setTipoComponente(appDataWMSComp);
		List<MvOdVistaDettaglioImpiantiDto> odVistaDettaglioImpiantiDtoArrayList = getMvVistaDettaglioImpiantiDao().findFindByFilter(filter);
		return odVistaDettaglioImpiantiDtoArrayList!=null? mapToDettagliogeografico(odVistaDettaglioImpiantiDtoArrayList):null;
	}

	private ArrayList<DettaglioGeograficoPortale> mapToDettagliogeografico(List<MvOdVistaDettaglioImpiantiDto> odVistaDettaglioImpiantiDtoArrayList) {
		ArrayList<DettaglioGeograficoPortale> dettaglioGeograficoPortales = new ArrayList<>();
		for(MvOdVistaDettaglioImpiantiDto odVistaDettaglioImpiantiDto:odVistaDettaglioImpiantiDtoArrayList){
			String ubicazione =
					(odVistaDettaglioImpiantiDto.getIndirizzoUnitaImmob() != null ? odVistaDettaglioImpiantiDto.getIndirizzoUnitaImmob() : "") + " " + (odVistaDettaglioImpiantiDto.getCivico() != null ? odVistaDettaglioImpiantiDto.getCivico() : "") + ", " + (odVistaDettaglioImpiantiDto.getDenominazioneComune() != null ? odVistaDettaglioImpiantiDto.getDenominazioneComune() :
							"") + " (" + (odVistaDettaglioImpiantiDto.getDenominazioneProvincia() != null ? odVistaDettaglioImpiantiDto.getDenominazioneProvincia() : "") + ")";

			DettaglioGeograficoPortale dettaglioGeograficoPortale = new DettaglioGeograficoPortale();
			dettaglioGeograficoPortale.setVolRiscM3(odVistaDettaglioImpiantiDto.getL12VolRiscM3()!=null?
					odVistaDettaglioImpiantiDto.getL12VolRiscM3().toString():"");
			dettaglioGeograficoPortale.setVolRaffM3(odVistaDettaglioImpiantiDto.getL12VolRaffM3()!=null?
					odVistaDettaglioImpiantiDto.getL12VolRaffM3().toString():"");
			dettaglioGeograficoPortale.setComponente(odVistaDettaglioImpiantiDto.getTipoComponente()!=null?
					odVistaDettaglioImpiantiDto.getTipoComponente()+"-"+odVistaDettaglioImpiantiDto.getProgressivo(): "");
			dettaglioGeograficoPortale.setPotClimaInv(odVistaDettaglioImpiantiDto.getL13PotClimaInvKw()!=null?
					odVistaDettaglioImpiantiDto.getL13PotClimaInvKw().toString():"");
			dettaglioGeograficoPortale.setPotClimaEst(odVistaDettaglioImpiantiDto.getL13PotClimaEstKw()!=null?
					odVistaDettaglioImpiantiDto.getL13PotClimaEstKw().toString():"");
			dettaglioGeograficoPortale.setImpianto(odVistaDettaglioImpiantiDto.getCodiceImpianto()!=null?
					odVistaDettaglioImpiantiDto.getCodiceImpianto().toString():"");
			dettaglioGeograficoPortale.setUbicazione(ubicazione);
			dettaglioGeograficoPortales.add(dettaglioGeograficoPortale);
		}
		return dettaglioGeograficoPortales;
	}
}
