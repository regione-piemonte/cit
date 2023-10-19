/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitweba.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitDDmDto;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitDRuoloAccredDto;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitRPfPgDelegaByCodiceFiscalePFDto;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitRPfPgDelegaDto;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitTFormazioneDto;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitTPersonaFisicaDto;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitTStoricoVarStatoPgDto;
import it.csi.sigit.sigitweba.business.ws.service.svista.client.Comune;
import it.csi.sigit.sigitweba.business.ws.service.svista.client.Provincia;
import it.csi.sigit.sigitweba.dto.accreditamento_tns.Formazione;
import it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaFisica;
import it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaGiuridica;
import it.csi.sigit.sigitweba.dto.common.CodeDescription;
import it.csi.sitad.tpnm.entity.Via;


/**
 * Mappa DTO con gli oggetti GUI e viceversa
 * 
 */
public class MapDto {
	/**
	 * Logger da utilizzare
	 */
	private static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".util");
	
	/**
	 * Carica una lista di {@link CodeDescription} per le Provincie, mettendo in cima alla lista le province del Piemonte
	 * 
	 * @param p
	 *            Lista delle Provincie da caricare
	 * @return Lista di {@link CodeDescription}
	 */
	public static ArrayList<CodeDescription> mapSiglaProvince(Provincia[] p) {
		ArrayList<CodeDescription> resultPiemonte = new ArrayList<CodeDescription>();
		ArrayList<CodeDescription> resultAltri = new ArrayList<CodeDescription>();
		if (p != null) {
			for (Provincia obj : p) {
//				if(Constants.COD_ISTAT_PIEMONTE.equals(obj.getRegioneProvincia().getIstatRegione()))
				if(Constants.COD_ID_PIEMONTE == obj.getIdRegione())
					resultPiemonte.add(mapToSiglaCodeDescription(obj));
				else
					resultAltri.add(mapToSiglaCodeDescription(obj));
			}
		}
		Collections.sort(resultPiemonte, ComparatorUtil.compare());
		if(resultAltri.size()>0)
		{
			Collections.sort(resultAltri, ComparatorUtil.compare());
			resultPiemonte.addAll(resultAltri);
		}
		return resultPiemonte;
	}
	
	public static ArrayList<CodeDescription> mapComuni(Comune[] c) {
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		if (c != null) {
			for (Comune obj : c) {
//				if (obj.getDataStop() == null)
					result.add(mapToCodeDescription(obj));
			}
		}
		Collections.sort(result, ComparatorUtil.compare());
		return result;
	}

	public static ArrayList<CodeDescription> mapRuoliAccred(List<SigitDRuoloAccredDto> c) {
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		if (c != null) {
			for (SigitDRuoloAccredDto obj : c) {
				result.add(mapToCodeDescription(obj));
			}
		}
		Collections.sort(result, ComparatorUtil.compare());
		return result;
	}

	public static ArrayList<CodeDescription> mapTipiDm(List<SigitDDmDto> c) {
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		if (c != null) {
			for (SigitDDmDto obj : c) {
				result.add(mapToCodeDescription(obj));
			}
		}
		Collections.sort(result, ComparatorUtil.compare());
		return result;
	}
	
	/**
	 * Carica un {@link CodeDescription} con una Provincia
	 * 
	 * @param obj
	 *            Provincia da caricare
	 * @return {@link CodeDescription} caricato
	 */
	private static CodeDescription mapToSiglaCodeDescription(Provincia obj) {
		CodeDescription cd = new CodeDescription();
//		cd.setCode(normalizeString(obj.getSiglaProvincia()));
//		cd.setDescription(normalizeString(obj.getDescProvincia()));
		cd.setCode(normalizeString(obj.getSigla()));
		cd.setDescription(normalizeString(obj.getNome()));
		return cd;
	}
	
	private static CodeDescription mapToCodeDescription(Comune obj) {
		CodeDescription cd = new CodeDescription();
//		cd.setCode(obj.getIstatComune());
//		cd.setDescription(obj.getDescComune());
		cd.setCode(obj.getCodIstat());
		cd.setDescription(obj.getNome());
		return cd;
	}

	private static CodeDescription mapToCodeDescription(SigitDRuoloAccredDto obj) {
		CodeDescription cd = new CodeDescription();
		cd.setCode(obj.getIdRuoloAccred().toString());
		cd.setDescription(obj.getDesRuoloAccred());
		return cd;
	}

	private static CodeDescription mapToCodeDescription(SigitDDmDto obj) {
		CodeDescription cd = new CodeDescription();
		cd.setCode(obj.getTipoDm372008());
		cd.setDescription(obj.getDesTipoDm372008());
		return cd;
	}
	
	public static PersonaFisica mapToPersonaFisica(SigitTPersonaFisicaDto obj) {
		PersonaFisica pf = new PersonaFisica();
		try
		{
			PropertyUtils.copyProperties(pf, obj);
		}catch (Exception e) {
			log.error("Errore mappando l'oggetto PF: " + e.getMessage());
		}
		pf.setIdPersona(ConvertUtil.convertToString(obj.getIdPersonaFisica()));
		pf.setDenominazione(obj.getCognome() + " " + obj.getNome());
		
		pf.setFlgIndirizzoEst(ConvertUtil.getNumberAsBoolean(obj.getFlgIndirizzoEstero()));
		if (pf.getFlgIndirizzoEst())
		{
			// ha indirizzo estero
			pf.setEstStato(obj.getStatoEstero());
			pf.setEstCitta(obj.getCittaEstero());
			pf.setEstIndirizzo(obj.getIndirizzoEstero());
			pf.setEstCap(obj.getCapEstero());
		}
		else
		{
			// ha indirizzo nazionale
			pf.setIdProvinciaSelez(obj.getSiglaProv());
			pf.setIdComuneSelez(obj.getIstatComune());
			pf.setIndirizzo(obj.getIndirizzoSitad());
			
			if (GenericUtil.isNullOrEmpty(obj.getFkL2())) {
				pf.setIdIndirizzoSel(Constants.INDIRIZZO_CARICATO_PWA);
			}
			else
			{
				pf.setIdIndirizzoSel(GenericUtil.getStringOrNull(obj.getFkL2()));
			}
			
		}
		
		pf.setFlgMailNewsletter(ConvertUtil.getNumberAsBoolean(obj.getFlgNewsletter()));
		pf.setFlgGDPR(ConvertUtil.getNumberAsBoolean(obj.getFlgGdpr()));
		
		return pf;
	}
	
	public static SigitTPersonaFisicaDto mapToSigitTPersonaFisicaDto(PersonaFisica pf, String cfUtMod) {
		SigitTPersonaFisicaDto obj = new SigitTPersonaFisicaDto();
		
		log.debug("Stampo pf");
		GenericUtil.stampa(pf, true, 3);
		try
		{
			PropertyUtils.copyProperties(obj, pf);//mappatura campi con lo stesso nome
			
		}catch (Exception e) {
			log.error("Errore mappando l'oggetto PF: " + e.getMessage());
		}
		
		obj.setIdPersonaFisica(ConvertUtil.convertToBigDecimal(pf.getIdPersona()));
		
		if (ConvertUtil.convertToBooleanAllways(pf.getFlgIndirizzoEst()))
		{
			obj.setFlgIndirizzoEstero(GenericUtil.getBooleanAsNumber(true));
			
			// ha indirizzo estero
			obj.setStatoEstero(pf.getEstStato());
			obj.setCittaEstero(pf.getEstCitta());
			obj.setIndirizzoEstero(pf.getEstIndirizzo());
			obj.setCapEstero(pf.getEstCap());
			
			obj.setSiglaProv(null);
			obj.setIstatComune(null);
			obj.setProvincia(null);
			obj.setComune(null);
			obj.setFkL2(null);
			obj.setIndirizzoSitad(null);
			obj.setIndirizzoNonTrovato(null);
			obj.setCap(null);
		}
		else
		{
			
			obj.setFlgIndirizzoEstero(GenericUtil.getBooleanAsNumber(false));

			// ha indirizzo nazionale
			obj.setSiglaProv(pf.getIdProvinciaSelez());
			obj.setIstatComune(pf.getIdComuneSelez());
			
			if(pf.getIdIndirizzoSel() != null && !pf.getIdIndirizzoSel().equals(Constants.INDIRIZZO_CARICATO_PWA))
			{
				obj.setFkL2(ConvertUtil.convertToBigDecimal(pf.getIdIndirizzoSel()));
			}

			obj.setIndirizzoSitad(pf.getIndirizzo());
			
			if(GenericUtil.isNullOrEmpty(pf.getIndirizzoNonTrovato()))
				obj.setIndirizzoNonTrovato(null);
			
			obj.setStatoEstero(null);
			obj.setCittaEstero(null);
			obj.setIndirizzoEstero(null);
			obj.setCapEstero(null);
		}
		
		// Se l'indirizzo mail e' vuoto lo imposto a null
		obj.setEmail(GenericUtil.getStringSql(obj.getEmail()));

		obj.setFlgNewsletter(ConvertUtil.getBooleanAsNumber(pf.getFlgMailNewsletter()));
		obj.setFlgGdpr(ConvertUtil.getBooleanAsNumber(pf.getFlgGDPR()));
		
		obj.setUtenteUltMod(cfUtMod);
		obj.setDataUltMod(DateUtil.getSqlDataCorrente());
		
		log.debug("Stampo obj");
		GenericUtil.stampa(obj, true, 3);

		return obj;
	}
	
	
	/**
	 * Normalizza una stringa trasformandola nella corrispettiva stringa tutta
	 * in maiuscolo
	 * 
	 * @param s
	 *            Stringa da normalizzare
	 * @return Stringa normalizzata
	 */
	private static String normalizeString(String s) {
		return (s == null ? null : s.toUpperCase());
	}
	
	/**
	 * Restituisce un oggetto di tipo CodeDescription a partire da una Via
	 * 
	 * @param via
	 *            Via del servizio di Toponomastica
	 * @return CodeDescription con idL2 e nome della via
	 */
	public static CodeDescription mapToCodeDescription(Via dto) {
		CodeDescription obj = new CodeDescription();
		obj.setCode(ConvertUtil.convertToString(dto.getIdL2()));
//		StringBuffer indirizzo = new StringBuffer();
//		indirizzo.append(dto.getIndirizzo().getTipoVia());
//		indirizzo.append(" ");
//		indirizzo.append(dto.getIndirizzo().getNomeVia());
		obj.setDescription(costruisciDescVia(dto));
		return obj;
	}
	
	public static String costruisciDescVia(Via via)
	{
		StringBuffer indirizzo = new StringBuffer();
		indirizzo.append(via.getIndirizzo().getTipoVia());
		indirizzo.append(" ");
		indirizzo.append(via.getIndirizzo().getNomeVia().getNome_via());
		
		
		//via.getLocalita().getComune().getToponimo()
		log.debug("---> Localita.getComune().getToponimo() oggetto "+via.getLocalita().getComune().getToponimo());
		
		if (!via.getLocalita().getNome().equalsIgnoreCase(via.getLocalita().getComune().getToponimo()))
		{
			// new Beppe - devo aggiungere la localita (es a Villanova d'Asti per il nome via: Buttigliera ritorna 3 vie valide uguali ma con localita' diversa {STAZIONE - SAVI - VILLANOVA D'ASTI})
			indirizzo.append(" Loc. ");
			indirizzo.append(via.getLocalita().getNome());
		}
		
		
		// new Beppe - devo aggiungere che se una via non e' in stato 'V' allora aggiungo nella descrizione 'DEPRECATO'
		if (!via.getStatoVia().equals(Constants.COD_STATO_VIA_VALIDA))
		{
			indirizzo.append(" (");
			indirizzo.append(Constants.DESC_STATO_VIA_DEPRECATO);
			indirizzo.append(")");
		}
		
		return indirizzo.toString();
	}
	
	public static ArrayList<Formazione> mapToFormazione(List<SigitTFormazioneDto> input)
	{
		ArrayList<Formazione> output = new ArrayList<Formazione>();
		if(input==null || input.isEmpty())
			return new ArrayList<Formazione>();
		for (SigitTFormazioneDto formDto : input) {
			Formazione form = new Formazione();
			form.setIdPersonaFisica(GenericUtil.getStringOrNull(formDto.getIdPersonaFisica()));
			form.setDescCorso(formDto.getDesCorso());
			form.setDataCorso(DateUtil.getString(formDto.getDataCorso()));
			output.add(form);
		}
		return output;
	}

	public static SigitTFormazioneDto mapToSigitTFormazioneDTO(Formazione input) throws ParseException
	{
		SigitTFormazioneDto output = new SigitTFormazioneDto();
		output.setDataCorso(DateUtil.getDate(input.getDataCorso()));
		output.setDesCorso(input.getDescCorso());
		output.setIdPersonaFisica(new BigDecimal(input.getIdPersonaFisica()));
		return output;
	}

	public static ArrayList<PersonaGiuridica> mapListToPersonaGiuridica(List<SigitRPfPgDelegaByCodiceFiscalePFDto> list)
	{
		ArrayList<PersonaGiuridica> output = new ArrayList<PersonaGiuridica>();
		if(list==null || list.isEmpty())
			return new ArrayList<PersonaGiuridica>();
		for (SigitRPfPgDelegaByCodiceFiscalePFDto dto : list) {
			PersonaGiuridica pg= new PersonaGiuridica();
			pg.setIdPersonaGiuridica(GenericUtil.getStringOrNull(dto.getAIdPersonaGiuridica()));
			pg.setIdPersonaFisica(GenericUtil.getStringOrNull(dto.getAIdPersonaFisica()));
			pg.setDenominazione(dto.getBDenominazione());
			pg.setCodiceFiscale(dto.getBCodiceFiscale());

			pg.setTelefono(GenericUtil.getStringOrNull(dto.getBTelefono()));
			pg.setPec(GenericUtil.getStringOrNull(dto.getBPec()));

			pg.setIdStatoPg(dto.getBFkStatoPg());
			pg.setIdStatoPgOld(dto.getBFkStatoPg());
			pg.setDescStatoPg(dto.getDDesStatoPg());
			
			pg.setFlgIndirizzoEst(ConvertUtil.getNumberAsBoolean(dto.getBFlgIndirizzoEstero()));
			
			if (pg.getFlgIndirizzoEst())
			{
				pg.setEstStato(dto.getBStatoEstero());
				pg.setEstCitta(dto.getBCittaEstero());
				pg.setEstIndirizzo(dto.getBIndirizzoEstero());
				pg.setEstCap(dto.getBCapEstero());
			}
			else
			{
				pg.setIndirizzo(dto.getBIndirizzoSitad());
				pg.setDescIndirizzoSel(dto.getBIndirizzoSitad()); 

				if (GenericUtil.isNonNullOrEmpty(GenericUtil.getStringOrNull(dto.getBFkL2()))) {
					pg.setIdIndirizzoSel(GenericUtil.getStringOrNull(dto.getBFkL2()));
				}
				else if (GenericUtil.isNonNullOrEmpty(dto.getBIndirizzoSitad()))
				{
					pg.setIdIndirizzoSel(Constants.INDIRIZZO_CARICATO_PWA);
				}

				pg.setIndirizzoNonTrovato(dto.getBIndirizzoNonTrovato());
				pg.setIdProvinciaSelez(dto.getBSiglaProv());
				pg.setProvincia(dto.getBProvincia());
				pg.setIdComuneSelez(dto.getBIstatComune());
				pg.setComune(dto.getBComune());
				pg.setCap(dto.getBCap());
			}
			
			// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
			pg.setCivico(dto.getBCivico());
			
			
			pg.setEmail(dto.getBEmail());
			pg.setDataInizioAttivita(DateUtil.getString(dto.getBDataInizioAttivita()));
			pg.setDataCessazione(DateUtil.getString(dto.getBDataCessazione()));
			pg.setSiglaRea(dto.getBSiglaRea());
			pg.setNumeroRea(GenericUtil.getStringOrNull(dto.getBNumeroRea()));
			if(GenericUtil.isNonNullOrEmpty(pg.getSiglaRea()) && GenericUtil.isNonNullOrEmpty(pg.getNumeroRea()))
			{
				pg.setCodiceRea(pg.getSiglaRea()+"-"+pg.getNumeroRea());
			}
			pg.setFlgDelega(dto.getAFlgDelega());
			pg.setFlgAmministratore(GenericUtil.getNumberAsBoolean(dto.getBFlgAmministratore()));
//			pg.setFlgInstallatore(GenericUtil.getNumberAsBoolean(dto.getBFlgInstallatore()));
//			pg.setFlgManutentore(GenericUtil.getNumberAsBoolean(dto.getBFlgManutentore()));
			pg.setFlg3Responsabile(GenericUtil.getNumberAsBoolean(dto.getBFlgTerzoResponsabile()));
			pg.setFlgDistributore(GenericUtil.getNumberAsBoolean(dto.getBFlgDistributore()));
			pg.setFlgCat(GenericUtil.getNumberAsBoolean(dto.getBFlgCat()));
			pg.setFlgDm37LetteraC(ConvertUtil.getNumberAsBoolean(dto.getBFlgDm37Letterac()));
			pg.setFlgDm37LetteraD(ConvertUtil.getNumberAsBoolean(dto.getBFlgDm37Letterad()));
			pg.setFlgDm37LetteraE(ConvertUtil.getNumberAsBoolean(dto.getBFlgDm37Letterae()));
			pg.setFlgFGas(ConvertUtil.getNumberAsBoolean(dto.getBFlgFgas()));
			pg.setFlgConduttore(ConvertUtil.getNumberAsBoolean(dto.getBFlgConduttore()));
			pg.setFlgSoggIncaricato(ConvertUtil.getNumberAsBoolean(dto.getBFlgSoggIncaricato()));
			pg.setDelegaSoggIncaricato(dto.getBDelegaSoggIncaricato());
			pg.setFlgAltraImpresa(pg.getFlgAmministratore() || pg.getFlgSoggIncaricato());
			pg.setRuolo(GenericUtil.getStringOrNull(dto.getRuoloAccred()));
			pg.setTipoDm(dto.getTipoDm());
			pg.setDataFine(DateUtil.getString(dto.getADataFine()));
			pg.setDataInizio(DateUtil.getString(dto.getADataInizio()));
			
			pg.setDescFlgAmministratore(pg.getFlgAmministratore() ? Constants.SI : Constants.NO);
//			pg.setDescFlgInstallatore(pg.getFlgInstallatore() ? Constants.SI : Constants.NO);
//			pg.setDescFlgManutentore(pg.getFlgManutentore() ? Constants.SI : Constants.NO);
			pg.setDescFlg3Responsabile(pg.getFlg3Responsabile() ? Constants.SI : Constants.NO);
			pg.setDescFlgDistributore(pg.getFlgDistributore() ? Constants.SI : Constants.NO);
			pg.setDescFlgCat(pg.getFlgCat() ? Constants.SI : Constants.NO);
			pg.setDescFlgDm37LetteraC(pg.getFlgDm37LetteraC() ? Constants.SI : Constants.NO);
			pg.setDescFlgDm37LetteraD(pg.getFlgDm37LetteraD() ? Constants.SI : Constants.NO);
			pg.setDescFlgDm37LetteraE(pg.getFlgDm37LetteraE() ? Constants.SI : Constants.NO);
			pg.setDescFlgFGas(pg.getFlgFGas() ? Constants.SI : Constants.NO);
			pg.setDescFlgConduttore(pg.getFlgConduttore() ? Constants.SI : Constants.NO);
			pg.setDescFlgSoggIncaricato(pg.getFlgSoggIncaricato() ? Constants.SI : Constants.NO);
			pg.setDescFlgAltraImpresa(pg.getFlgAltraImpresa() ? Constants.SI : Constants.NO);
			
			if(Constants.FLAG_ACCREDITAMENTO.equals(pg.getFlgDelega()))
				pg.setDescFlgDelega(Constants.DESC_FLAG_ACCREDITAMENTO);
			if(Constants.FLAG_DELEGA.equals(pg.getFlgDelega()))
				pg.setDescFlgDelega(Constants.DESC_FLAG_DELEGA);
			
			output.add(pg);
		}
		return output;
	}
	
	public static SigitRPfPgDelegaDto getSigitPfPgDelega(PersonaGiuridica input)
	{
		SigitRPfPgDelegaDto output = new SigitRPfPgDelegaDto();
		output.setFkRuoloAccred(ConvertUtil.convertToBigDecimal(input.getRuolo()));
		if (GenericUtil.isNonNullOrEmpty(input.getTipoDm()))
		{
			output.setFkTipoDm(input.getTipoDm());
		}
		output.setIdPersonaGiuridica(ConvertUtil.convertToBigDecimal(input.getIdPersonaGiuridica()));
		output.setIdPersonaFisica(ConvertUtil.convertToBigDecimal(input.getIdPersonaFisica()));
		output.setFlgDelega(input.getFlgDelega());
		try {
			output.setDataInizio(DateUtil.getDate(input.getDataInizio()));
		} catch (ParseException e) {
		}
		try {
			output.setDataFine(DateUtil.getDate(input.getDataFine()));
		} catch (ParseException e) {
		}
		return output;
	}

	public static SigitTStoricoVarStatoPgDto getSigitTStoricoVarStatoPg(PersonaGiuridica input, String cfUtenteMod, boolean isInsert)
	{
		SigitTStoricoVarStatoPgDto output = new SigitTStoricoVarStatoPgDto();
		output.setDtEvento(DateUtil.getSqlDataCorrente());
		output.setIdPersonaGiuridica(ConvertUtil.convertToBigDecimal(input.getIdPersonaGiuridica()));
		
		if (isInsert)
		{
			output.setMotivo(Constants.DESC_MOTIVO_ATTIVAZIONE);
			output.setDtInizioVariazione(ConvertUtil.convertToSqlDate(input.getDataInizioAttivita()));
		}
		else
		{
			output.setMotivo(Constants.DESC_MOTIVO_CESSAZIONE);
			output.setDtInizioVariazione(ConvertUtil.convertToSqlDate(input.getDataCessazione()));
			output.setStatoPgDa(input.getIdStatoPgOld());
		}
			
		output.setStatoPgA(input.getIdStatoPg());
		output.setUtenteUltMod(cfUtenteMod);
		output.setDataUltMod(DateUtil.getSqlDataCorrente());
		return output;
	}

	
	
	public static SigitTPersonaGiuridicaDto getSigitTPersonaGiuridica(PersonaGiuridica vo, SigitTPersonaGiuridicaDto dto)
	{
		if (dto == null)
		{
			// Vuol dire che sono in inserimento
			dto = new SigitTPersonaGiuridicaDto();
		}
//		else
//		{
//			// Vuol dire che sono in modifica
//			dto.setIdPersonaGiuridica(ConvertUtil.convertToBigDecimal(vo.getIdPersonaGiuridica()));
//		}
		
		dto.setDenominazione(SecurityUtil.sanitize(vo.getDenominazione()));
		dto.setCodiceFiscale(vo.getCodiceFiscale().toUpperCase());
		
		dto.setFlgIndirizzoEstero(ConvertUtil.getBooleanAsNumber(vo.getFlgIndirizzoEst()));
		
		if (vo.getFlgIndirizzoEst())
		{
			dto.setStatoEstero(StringEscapeUtils.escapeHtml(vo.getEstStato()));
			dto.setCittaEstero(StringEscapeUtils.escapeHtml(vo.getEstCitta()));
			dto.setIndirizzoEstero(StringEscapeUtils.escapeHtml(vo.getEstIndirizzo()));
			dto.setCapEstero(StringEscapeUtils.escapeHtml(vo.getEstCap()));
		}
		else
		{
			
			if (GenericUtil.isNullOrEmpty(vo.getIdIndirizzoSel()) && !vo.getIdIndirizzoSel().equals(Constants.INDIRIZZO_CARICATO_PWA))
			{
				dto.setFkL2(ConvertUtil.convertToBigDecimal(vo.getIdIndirizzoSel()));
			}
					
			dto.setIndirizzoSitad(vo.getDescIndirizzoSel());
			dto.setIndirizzoNonTrovato(StringEscapeUtils.escapeHtml(GenericUtil.getStringUpperSql(vo.getIndirizzoNonTrovato())));
			dto.setSiglaProv(vo.getIdProvinciaSelez());
			dto.setIstatComune(vo.getIdComuneSelez());
			dto.setComune(vo.getComune());
			dto.setProvincia(vo.getProvincia());
			dto.setCap(vo.getCap());
			
		}

		// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
		dto.setCivico(StringEscapeUtils.escapeHtml(vo.getCivico()));

		dto.setEmail(StringEscapeUtils.escapeHtml(GenericUtil.getStringSql(vo.getEmail())));
		dto.setPec(StringEscapeUtils.escapeHtml(vo.getPec()));
		dto.setTelefono(StringEscapeUtils.escapeHtml(vo.getTelefono()));

		try {
			dto.setDataInizioAttivita(DateUtil.getDate(vo.getDataInizioAttivita()));
		} catch (ParseException e) {
		}
		try {
			dto.setDataCessazione(DateUtil.getDate(vo.getDataCessazione()));
		} catch (ParseException e) {
		}
		
		if (GenericUtil.isNonNullOrEmpty(vo.getSiglaRea())) {		
			dto.setSiglaRea(vo.getSiglaRea());
		}
		
		if (GenericUtil.isNonNullOrEmpty(vo.getNumeroRea())) {			
			dto.setNumeroRea(new BigDecimal(vo.getNumeroRea()));
		}
		
//		dto.setFlgInstallatore(GenericUtil.getBooleanAsNumber(vo.getFlgInstallatore()));
//		dto.setFlgManutentore(GenericUtil.getBooleanAsNumber(vo.getFlgManutentore()));
		dto.setFlgAmministratore(GenericUtil.getBooleanAsNumber(vo.getFlgAmministratore()));
		dto.setFlgTerzoResponsabile(GenericUtil.getBooleanAsNumber(vo.getFlg3Responsabile()));
		dto.setFlgDistributore(GenericUtil.getBooleanAsNumber(vo.getFlgDistributore()));
//		dto.setFlgCat(GenericUtil.getBooleanAsNumber(vo.getFlgCat()));
		dto.setFlgDm37Letterac(ConvertUtil.getBooleanAsNumber(vo.getFlgDm37LetteraC()));
		dto.setFlgDm37Letterad(ConvertUtil.getBooleanAsNumber(vo.getFlgDm37LetteraD()));
		dto.setFlgDm37Letterae(ConvertUtil.getBooleanAsNumber(vo.getFlgDm37LetteraE()));
		dto.setFlgFgas(ConvertUtil.getBooleanAsNumber(vo.getFlgFGas()));
		dto.setFlgConduttore(ConvertUtil.getBooleanAsNumber(vo.getFlgConduttore()));
		dto.setFlgSoggIncaricato(ConvertUtil.getBooleanAsNumber(vo.getFlgSoggIncaricato()));
		dto.setDelegaSoggIncaricato(vo.getDelegaSoggIncaricato());
		
		dto.setFkStatoPg(vo.getIdStatoPg());

		return dto;
	}
	
	public static ArrayList<PersonaGiuridica> getListPersonaGiuridica(List<SigitTPersonaGiuridicaDto> input)
	{
		ArrayList<PersonaGiuridica> output = new ArrayList<PersonaGiuridica>();
		for (SigitTPersonaGiuridicaDto dto : input) {
			output.add(getPersonaGiuridica(dto));
		}
		return output;
	}
	
	public static PersonaGiuridica getPersonaGiuridica(SigitTPersonaGiuridicaDto dto)
	{
		PersonaGiuridica pg= new PersonaGiuridica();
		pg.setIdPersonaGiuridica(GenericUtil.getStringOrNull(dto.getIdPersonaGiuridica()));
		pg.setDenominazione(dto.getDenominazione());
		pg.setCodiceFiscale(dto.getCodiceFiscale());
		pg.setIdProvinciaSelez(dto.getSiglaProv());
		pg.setProvincia(dto.getProvincia());
		pg.setIdComuneSelez(dto.getIstatComune());
		pg.setComune(dto.getComune());
		pg.setIdIndirizzoSel(GenericUtil.getStringOrNull(dto.getFkL2()));
		pg.setIndirizzo(dto.getIndirizzoSitad());
		pg.setIndirizzoNonTrovato(dto.getIndirizzoNonTrovato());
		pg.setCivico(dto.getCivico());
		pg.setCap(dto.getCap());
		pg.setEmail(dto.getEmail());
		pg.setPec(dto.getPec());
		pg.setTelefono(dto.getTelefono());
		pg.setDataInizioAttivita(DateUtil.getString(dto.getDataInizioAttivita()));
		pg.setDataCessazione(DateUtil.getString(dto.getDataCessazione()));
		pg.setSiglaRea(dto.getSiglaRea());
		pg.setNumeroRea(GenericUtil.getStringOrNull(dto.getNumeroRea()));
		pg.setCodiceRea(pg.getSiglaRea()+pg.getNumeroRea());
		pg.setFlgAmministratore(GenericUtil.getNumberAsBoolean(dto.getFlgAmministratore()));
//		pg.setFlgInstallatore(GenericUtil.getNumberAsBoolean(dto.getFlgInstallatore()));
//		pg.setFlgManutentore(GenericUtil.getNumberAsBoolean(dto.getFlgManutentore()));
		pg.setFlg3Responsabile(ConvertUtil.getNumberAsBoolean(dto.getFlgTerzoResponsabile()));
		pg.setFlgDistributore(ConvertUtil.getNumberAsBoolean(dto.getFlgDistributore()));
		pg.setFlgCat(ConvertUtil.getNumberAsBoolean(dto.getFlgCat()));
		pg.setFlgDm37LetteraC(ConvertUtil.getNumberAsBoolean(dto.getFlgDm37Letterac()));
		pg.setFlgDm37LetteraD(ConvertUtil.getNumberAsBoolean(dto.getFlgDm37Letterad()));
		pg.setFlgDm37LetteraE(ConvertUtil.getNumberAsBoolean(dto.getFlgDm37Letterae()));
		pg.setFlgFGas(ConvertUtil.getNumberAsBoolean(dto.getFlgFgas()));
		pg.setFlgConduttore(ConvertUtil.getNumberAsBoolean(dto.getFlgConduttore()));
		pg.setFlgSoggIncaricato(ConvertUtil.getNumberAsBoolean(dto.getFlgSoggIncaricato()));
		pg.setDelegaSoggIncaricato(dto.getDelegaSoggIncaricato());
		pg.setFlgAltraImpresa(pg.getFlgAmministratore() || pg.getFlgSoggIncaricato());
		
		pg.setDescFlgAmministratore(pg.getFlgAmministratore() ? Constants.SI : Constants.NO);
//		pg.setDescFlgInstallatore(pg.getFlgInstallatore() ? Constants.SI : Constants.NO);
//		pg.setDescFlgManutentore(pg.getFlgManutentore() ? Constants.SI : Constants.NO);
		pg.setDescFlg3Responsabile(pg.getFlg3Responsabile() ? Constants.SI : Constants.NO);
		pg.setDescFlgDistributore(pg.getFlgDistributore() ? Constants.SI : Constants.NO);
		pg.setDescFlgCat(pg.getFlgCat() ? Constants.SI : Constants.NO);
		pg.setDescFlgDm37LetteraC(pg.getFlgDm37LetteraC() ? Constants.SI : Constants.NO);
		pg.setDescFlgDm37LetteraD(pg.getFlgDm37LetteraD() ? Constants.SI : Constants.NO);
		pg.setDescFlgDm37LetteraE(pg.getFlgDm37LetteraE() ? Constants.SI : Constants.NO);
		pg.setDescFlgFGas(pg.getFlgFGas() ? Constants.SI : Constants.NO);
		pg.setDescFlgConduttore(pg.getFlgConduttore() ? Constants.SI : Constants.NO);
		pg.setDescFlgSoggIncaricato(pg.getFlgSoggIncaricato() ? Constants.SI : Constants.NO);
		pg.setDescFlgAltraImpresa(pg.getFlgAltraImpresa() ? Constants.SI : Constants.NO);
		
		return pg;
	}
}

