/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitweba.business.manager;

import java.text.ParseException;
import java.util.Date;

import it.csi.sigit.sigitweba.business.manager.util.Message;
import it.csi.sigit.sigitweba.business.manager.util.ServiceException;
import it.csi.sigit.sigitweba.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitweba.dto.ExecResults;
import it.csi.sigit.sigitweba.dto.accreditamento_tns.Formazione;
import it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaFisica;
import it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaGiuridica;
import it.csi.sigit.sigitweba.util.Constants;
import it.csi.sigit.sigitweba.util.ConstantsField;
import it.csi.sigit.sigitweba.util.ConvertUtil;
import it.csi.sigit.sigitweba.util.DateUtil;
import it.csi.sigit.sigitweba.util.GenericUtil;
import it.csi.sigit.sigitweba.util.Messages;

public class ValidationMgr {
	
	
	
//	public ValidationMgr() {
//		
//	}
//
//	private void addMissingRequiredFieldError(String fname, ExecResults r) {
//		r.getFldErrors().put("" + fname, Messages.ERROR_CAMPO_ABBIGATORIO);
//	}
//
//	private void addFormatRequiredNumberFieldError(String fname, ExecResults r) {
//		r.getFldErrors().put("" + fname,  Messages.ERROR_SOLO_NUMERICI);
//	}
//	
//	private void addFormatRequiredFieldError(String fname, String error, ExecResults r) {
//		r.getFldErrors().put("" + fname, error);
//	}
//	
//	private void addGlobalErrors(String error, ExecResults r) {
//		r.getGlobalErrors().add(error);
//	}
//	
//	private void addGlobalMessages(String error, ExecResults r) {
//		r.getGlobalMessages().add(error);
//	}
//	
	
	/**
	 * Validazione formale di {@link AltriEdifici}
	 * 
	 * @param altriEdifici Altri edifici da validare
	 * @throws ValidationManagerException Validazione fallita
	 */
	public void validazioneFormaleAcceditamento(PersonaFisica personaFisica, ExecResults result) throws ValidationManagerException {
		ValidationManagerException ex = null;
			
			//Message message = new Message(Messages.ERROR_CAMPO_ABBIGATORIO);
			//message.replacePlaceholder("");
			ex = new ValidationManagerException();
			
			//GenericUtil.stampa(personaFisica, true, 3);
			
			if (ConvertUtil.convertToBooleanAllways(personaFisica.getFlgIndirizzoEst()))
			{
				if (GenericUtil.isNonNullOrEmpty(personaFisica.getEstStato()) ||
						GenericUtil.isNonNullOrEmpty(personaFisica.getEstCitta()) ||
						GenericUtil.isNonNullOrEmpty(personaFisica.getEstIndirizzo()))
				{
					if (GenericUtil.isNullOrEmpty(personaFisica.getEstStato())) {
						ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_PERSONA_F_EST_STATO);
					}
					
					if (GenericUtil.isNullOrEmpty(personaFisica.getEstCitta())) {
						ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_PERSONA_F_EST_CITTA);
					}
					
					if (GenericUtil.isNullOrEmpty(personaFisica.getEstIndirizzo())) {
						ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_PERSONA_F_EST_INDIRIZZO);
					}
				}
			}
			else
			{
				if (GenericUtil.isNonNullOrEmpty(personaFisica.getIdProvinciaSelez()) ||
					GenericUtil.isNonNullOrEmpty(personaFisica.getIdComuneSelez()) ||
					GenericUtil.isNonNullOrEmpty(personaFisica.getIndirizzo()) ||
					GenericUtil.isNonNullOrEmpty(personaFisica.getIdIndirizzoSel()))
			
				{
					//if (GenericUtil.isNonNullOrEmpty(personaFisica.getIdProvinciaSelez())) {
					
					
	//				ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_PERSONA_F_ID_PROV_SELEZ);
					
					if (GenericUtil.isNullOrEmpty(personaFisica.getIdProvinciaSelez())) {
						ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_PERSONA_F_ID_PROV_SELEZ);
					}
					
					if (GenericUtil.isNullOrEmpty(personaFisica.getIdComuneSelez())) {
						ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_PERSONA_F_ID_COM_SELEZ);
					}
					
					if (!personaFisica.getFlgEseguitaRicerca()) {
						ex.addField(ConstantsField.ACCREDITAMENTO_PERSONA_F_INDIRIZZO, Messages.ERROR_CERCA_INDIRIZZO);
					}
				
					// if(GenericUtil.isNonNullOrEmpty(personaFisica.getIdIndirizzoSel()) && !personaFisica.getIdIndirizzoSel().matches("\\d*"))
					if(GenericUtil.isNonNullOrEmpty(personaFisica.getIdIndirizzoSel()) && !personaFisica.getIdIndirizzoSel().equals(Constants.INDIRIZZO_CARICATO_PWA) && !personaFisica.getIdIndirizzoSel().matches("\\d*"))
					{
						ex.addField(ConstantsField.ACCREDITAMENTO_PERSONA_F_INDIRIZZO, Messages.ERROR_INDIRIZZO_NON_VALIDO);
					}
					
					if(GenericUtil.isNullOrEmpty(personaFisica.getIndirizzoNonTrovato()))
					{
						if(GenericUtil.isNullOrEmpty(personaFisica.getIdIndirizzoSel()) && GenericUtil.isNullOrEmpty(personaFisica.getIndirizzo()))
						{
							ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_PERSONA_F_INDIRIZZO);
							ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_PERSONA_F_ID_IND_SELEZ);
						}
						else
						{
							if(GenericUtil.isNullOrEmpty(personaFisica.getIdIndirizzoSel()))
							{
								if (GenericUtil.isNullOrEmpty(personaFisica.getIndirizzo())) {
									ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_PERSONA_F_INDIRIZZO);
								}
								else if(personaFisica.getIndirizzo().length()<3)
								{
									ex.addField(ConstantsField.ACCREDITAMENTO_PERSONA_F_INDIRIZZO, Messages.ERROR_INSERIRE_INDIRIZZO_LUNGO);
								}
							}
						}
					}
				}
				
				if(GenericUtil.isNonNullOrEmpty(personaFisica.getIdIndirizzoSel()) && GenericUtil.isNonNullOrEmpty(personaFisica.getIndirizzoNonTrovato()))
				{
					ex.addField(ConstantsField.ACCREDITAMENTO_PERSONA_F_IND_NON_TROVATO, Messages.ERROR_INDIRIZZO_MULTIPLO);
				}
			}
			
			if (GenericUtil.isNonNullOrEmpty(personaFisica.getEmail())) {
				if(!GenericUtil.checkValidEmail(personaFisica.getEmail()))
				{
					ex.addField(ConstantsField.ACCREDITAMENTO_PERSONA_F_EMAIL,Messages.ERROR_EMAIL_FORMAT);
				}
				else
					personaFisica.setEmail(personaFisica.getEmail().toUpperCase());
			}

			if (personaFisica.getFlgGDPR() == null || !personaFisica.getFlgGDPR()) {
				ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_PERSONA_F_GDPR);
			}
			
			if (ex.getFieldList().size() > 0)
			{
					//ex.setMsg(message);
					throw ex;
			}
			
			if(GenericUtil.isNonNullOrEmpty(personaFisica.getCap()))
			{
				checkNumeroIntero(personaFisica.getCap(), ConstantsField.ACCREDITAMENTO_PERSONA_F_CAP);
			}
			
		
	}
	
	/**
	 * Verifica se un numero e' in formato intero. CHK9
	 * 
	 * @param numeroDaVerificare Numero da verificare
	 * @param numberField Campo associato al nome
	 * @return Numero convertito in intero
	 * @throws ValidationManagerException Il numero non e' informato intero
	 */
	protected void checkNumeroIntero(String numeroDaVerificare, String numberField) throws ValidationManagerException {
		ValidationManagerException ex = null;

		
				if (!GenericUtil.checkValideNumber(numeroDaVerificare))
				{
					ex = new ValidationManagerException();
					ex.addField(numberField, Messages.ERROR_SOLO_NUMERICI);
					throw ex;
				}
		
	}

	public void checkEmail(String emailField, String email, ServiziMgr mgr) throws ValidationManagerException {
		ValidationManagerException ex = null;
		
		if (!GenericUtil.checkValidEmail(email))
		{
			ex = new ValidationManagerException(new Message(Messages.ERROR_EMAIL_FORMAT));
			ex.addField(emailField);
			throw ex;
		}
		else
		{
			try {
				mgr.sendMail(email);
			} catch (ServiceException e) {
				ex = new ValidationManagerException(new Message(e.getMessage()));
//				ex.addField(emailField);
				throw ex;
			}
		}
		
	}

	public void verificaRicercaIndirizzoPersonaFisica(PersonaFisica pf) throws ValidationManagerException
	{
		checkRicercaIndirizzo(pf.getIdComuneSelez(), pf.getIdProvinciaSelez(), 
				ConstantsField.ACCREDITAMENTO_PERSONA_F_ID_COM_SELEZ, ConstantsField.ACCREDITAMENTO_PERSONA_F_ID_PROV_SELEZ);
		
		if(GenericUtil.isNullOrEmpty(pf.getIndirizzo())) {
			ValidationManagerException ex = new ValidationManagerException(new Message(Messages.ERROR_INSERIRE_INDIRIZZO));
			ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_PERSONA_F_INDIRIZZO);
			throw ex;
		}

		if(pf.getIndirizzo().length()<3) {
			ValidationManagerException ex = new ValidationManagerException(new Message(Messages.ERROR_INSERIRE_INDIRIZZO_LUNGO));
			ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_PERSONA_F_INDIRIZZO);
			throw ex;
		}
		
	}
	
	/**
	 * Verifica se oltre all'indirizzo e' stato selezionato anche il comune
	 * 
	 * @param indirizzo Indirizzo
	 * @param idComune Comune
	 * @param fieldProvincia Il campo della provincia
	 * @param fieldIndirizzo Il campo dell'indirizzo
	 * @param fieldComune Il campo del comune
	 */
	private void checkRicercaIndirizzo(String idComune, String idProvincia, String fieldComune, String fieldProvincia) throws ValidationManagerException {
		if(GenericUtil.isNullOrEmpty(idProvincia)) {
			ValidationManagerException ex = new ValidationManagerException(new Message(Messages.ERROR_SELEZIONARE_PROVINCIA));
			ex.addFieldRequired(fieldProvincia);
			throw ex;
		}

		if(GenericUtil.isNullOrEmpty(idComune)) {
			ValidationManagerException ex = new ValidationManagerException(new Message(Messages.ERROR_SELEZIONARE_COMUNE));
			// ex.addField(fieldIndirizzo);
			ex.addFieldRequired(fieldComune);
			throw ex;
		}

	}
	
	public void checkFormatoData(String dataStr) throws ValidationManagerException
	{
		try {
			DateUtil.getDate(dataStr);
		} catch (ParseException e) {
			ValidationManagerException ex = new ValidationManagerException(new Message(Messages.ERROR_FORMATO_DATA_ERRATO));
			ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_FORMAZIONE_DATA);
			throw ex;
		}
	}

	public void validazioneFormazione(Formazione formazione) throws ValidationManagerException {
		
		if(GenericUtil.isNullOrEmpty(formazione.getDataCorso()))
		{
			ValidationManagerException ex = new ValidationManagerException();
			ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_FORMAZIONE_DATA);
			throw ex;
		}
		try {
			if(DateUtil.getDate(formazione.getDataCorso()).after(new Date()))
			{
				ValidationManagerException ex = new ValidationManagerException();
				ex.addField(ConstantsField.ACCREDITAMENTO_FORMAZIONE_DATA,Messages.ERROR_DATA_FUTURA);
				throw ex;
			}
		} catch (ParseException e) {//non dovrebbe verificarsi, la data e' stata controllata sopra
		}
		checkFormatoData(formazione.getDataCorso());
	}
	
	public void validazioneNuovaImpresa(PersonaGiuridica pg) throws ValidationManagerException
	{
		ValidationManagerException ex = new ValidationManagerException();
		
		if (GenericUtil.isNullOrEmpty(pg.getSiglaRea()) && (pg.getFlgDm37LetteraC() || pg.getFlgDm37LetteraD() || pg.getFlgDm37LetteraE() || pg.getFlgFGas() || pg.getFlgConduttore() || pg.getFlg3Responsabile() || pg.getFlgDistributore() || pg.getFlgCat())) {
			ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_SIGLA_REA);
		}

		if (GenericUtil.isNullOrEmpty(pg.getNumeroRea()) && (pg.getFlgDm37LetteraC() || pg.getFlgDm37LetteraD() || pg.getFlgDm37LetteraE() || pg.getFlgFGas() || pg.getFlgConduttore() || pg.getFlg3Responsabile() || pg.getFlgDistributore() || pg.getFlgCat())) {
			ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_NUMERO_REA);
		}

		if (GenericUtil.isNullOrEmpty(pg.getDenominazione())) {
			ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_DENOMINAZIONE);
		}

		if (GenericUtil.isNullOrEmpty(pg.getCodiceFiscale())) {
			ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_CODICE_FISCALE);
		}
		else if(!(pg.getCodiceFiscale().length()==11 || pg.getCodiceFiscale().length()==16))
		{
			ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_F_CODICE_FISCALE, Messages.ERROR_LUNGHEZZA_CODICE_FISCALE);
		}

		if (GenericUtil.isNullOrEmpty(pg.getDataInizioAttivita())) {
			ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_DATA_INIZIO_ATTIVITA);
		}
		else
		{
			try
			{
				checkFormatoData(pg.getDataInizioAttivita());
				try {
					if(DateUtil.getDate(pg.getDataInizioAttivita()).after(new Date()))
					{
						ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_F_DATA_INIZIO_ATTIVITA, Messages.ERROR_DATA_FUTURA);
					}
				} catch (ParseException e) {//non dovrebbe verificarsi, la data e' stata controllata sopra
				}
			} catch (ValidationManagerException e) {
				ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_F_DATA_INIZIO_ATTIVITA, Messages.ERROR_FORMATO_DATA_ERRATO);
			}
		}

		if (GenericUtil.isNonNullOrEmpty(pg.getDataCessazione())) {
			try
			{
				checkFormatoData(pg.getDataCessazione());
				//check con data inizio attivita'
				if(GenericUtil.isNonNullOrEmpty(pg.getDataInizioAttivita()) && 
						DateUtil.getDate(pg.getDataCessazione()).before(DateUtil.getDate(pg.getDataInizioAttivita())))
				{
					ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_F_DATA_CESSAZIONE, Messages.ERROR_DATA_CESSAZIONE);
				}
				else 
					try {
							if(DateUtil.getDate(pg.getDataCessazione()).after(new Date()))
							{
								ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_F_DATA_CESSAZIONE, Messages.ERROR_DATA_FUTURA);
							}
						} catch (ParseException e) {//non dovrebbe verificarsi, la data e' stata controllata sopra
					}
			} catch (ValidationManagerException e) {
				ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_F_DATA_CESSAZIONE, Messages.ERROR_FORMATO_DATA_ERRATO);
			} catch (ParseException e) {//ingorato perche' viene lanciato da DateUtil che viene chiamato quando la data e' stata gia' validata
			}
		}

		if (pg.getFlgIndirizzoEst())
		{
			// Indirizzo ESTERO
			if (GenericUtil.isNullOrEmpty(pg.getEstStato())) {
				ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_EST_STATO);
			}
			
			if (GenericUtil.isNullOrEmpty(pg.getEstCitta())) {
				ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_EST_CITTA);
			}

			if (GenericUtil.isNullOrEmpty(pg.getEstIndirizzo())) {
				ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_EST_INDIRIZZO);
			}
		}
		else
		{
			// Indirizzo NAZIONALE
			if (GenericUtil.isNullOrEmpty(pg.getIdProvinciaSelez())) {
				ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_ID_PROV_SELEZ);
			}

			if (GenericUtil.isNullOrEmpty(pg.getIdComuneSelez())) {
				ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_ID_COM_SELEZ);
			}


			if (!pg.getFlgEseguitaRicerca()) {
				ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_F_INDIRIZZO, Messages.ERROR_CERCA_INDIRIZZO);
			}

			if(GenericUtil.isNullOrEmpty(pg.getIndirizzoNonTrovato()))
			{
				if(GenericUtil.isNullOrEmpty(pg.getIdIndirizzoSel()) && GenericUtil.isNullOrEmpty(pg.getIndirizzo()))
				{
					ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_INDIRIZZO);
					ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_ID_IND_SELEZ);
				}
				else
				{
					if(GenericUtil.isNullOrEmpty(pg.getIdIndirizzoSel()))
					{
						if (GenericUtil.isNullOrEmpty(pg.getIndirizzo())) {
							ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_INDIRIZZO);
						}
						else if(pg.getIndirizzo().length()<3)
						{
							ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_F_INDIRIZZO, Messages.ERROR_INSERIRE_INDIRIZZO_LUNGO);
						}
					}
				}
			}
			
			if(GenericUtil.isNonNullOrEmpty(pg.getIdIndirizzoSel()) && GenericUtil.isNonNullOrEmpty(pg.getIndirizzoNonTrovato()))
			{
				ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_F_IND_NON_TROVATO, Messages.ERROR_INDIRIZZO_MULTIPLO);
			}
		}
		
		
		if (GenericUtil.isNullOrEmpty(pg.getEmail())) {
			ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_EMAIL);
		}
		else if(!GenericUtil.checkValidEmail(pg.getEmail()))
		{
			ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_F_EMAIL,Messages.ERROR_EMAIL_FORMAT);
		}

		if(GenericUtil.isNonNullOrEmpty(pg.getPec()) && !GenericUtil.checkValidEmail(pg.getPec())){
			ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_F_PEC,Messages.ERROR_EMAIL_FORMAT);
		}

		if(GenericUtil.isNonNullOrEmpty(pg.getTelefono()) && !GenericUtil.checkValideNumber(pg.getTelefono())){
			ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_F_TELEFONO,Messages.ERROR_SOLO_NUMERICI);
		}

//		if(pg.getCodiceFiscale()!=null && pg.getCodiceFiscale().length()==16)
//		{
//			if(!GenericUtil.checkValidCF(pg.getCodiceFiscale()))
//			{
//				ex.addField(ConstantsField.DITAMENTO_IMPRESA_F_CODICE_FISCALE, Messages.ERROR_CODICE_FISCALE_FORMAT);
//			}
//		}
//
//		if((pg.getFlgAmministratore() || pg.getFlgDm37LetteraC() || pg.getFlg3Responsabile() || pg.getFlgDistributore()) && GenericUtil.isNullOrEmpty(pg.getRuolo()))
//		{ACCRE
//			ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_RUOLO);
//		}
//
//		if ((pg.getFlgAmministratore() || pg.getFlgDm37LetteraC() || pg.getFlg3Responsabile()) && GenericUtil.isNullOrEmpty(pg.getTipoDm()))
//		{
//			ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_TIPO_DM);
//		}
//		
//		
//		if(!pg.getFlgAmministratore() && !pg.getFlgManutentore() && !pg.getFlgInstallatore() && !pg.getFlg3Responsabile() && pg.getFlgDistributore())
//		{
//			// Non devo fare niente, ha selezionato solo flgDistributore
//		}
//		else if(GenericUtil.isNullOrEmpty(pg.getTipoDm()))
//		{
//			ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_TIPO_DM);
//		}
		
//		if(!pg.getFlgAmministratore() && !pg.getFlgDm37LetteraC() && !pg.getFlg3Responsabile() && !pg.getFlgDistributore() && !pg.getFlgCat())
//		{
//			ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_FLAG_AMMINISTRATORE, Messages.ERROR_FLAG_MAN_INS_AMM);
//			ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_FLAG_MANUTENTORE, Messages.ERROR_FLAG_MAN_INS_AMM);
//			ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_FLAG_INSTALLATORE, Messages.ERROR_FLAG_MAN_INS_AMM);
//			ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_FLAG_3RESPONSABILE, Messages.ERROR_FLAG_MAN_INS_AMM);
//			ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_FLAG_DISTRIBUTORE, Messages.ERROR_FLAG_MAN_INS_AMM);
//			ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_FLAG_CAT, Messages.ERROR_FLAG_MAN_INS_AMM);
//		}
		
		if(!pg.getFlgAmministratore() && !pg.getFlgSoggIncaricato()) {
			ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_FLAG_AMMINISTRATORE, Messages.ERROR_FLG_AMM_SOGG_DEL);
			ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_FLAG_SOGG_INCARICATO, Messages.ERROR_FLG_AMM_SOGG_DEL);
		}
		
		if(pg.getFlgSoggIncaricato() && GenericUtil.isNullOrEmpty(pg.getDelegaSoggIncaricato())) {
			ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_FLAG_DELEGA_SOGG_INCARICATO, Messages.ERROR_DELEGA_SOGG_DEL);
		}
		
		if(GenericUtil.isNonNullOrEmpty(pg.getDelegaSoggIncaricato()) && pg.getDelegaSoggIncaricato().length() > 200) {
			ex.addField(ConstantsField.ACCREDITAMENTO_IMPRESA_FLAG_DELEGA_SOGG_INCARICATO, Messages.ERROR_LUNGHEZZA_DELEGA_SOGG_DEL);
		}
		
		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}
		
		checkCodiceFiscalePartitaIva(pg.getCodiceFiscale(), ConstantsField.ACCREDITAMENTO_IMPRESA_F_CODICE_FISCALE);

		if(GenericUtil.isNonNullOrEmpty(pg.getCap()))
		{
			checkNumeroIntero(pg.getCap(), ConstantsField.ACCREDITAMENTO_IMPRESA_F_CAP);
		}
		
	}
	
	private void checkCodiceFiscalePartitaIva(String codiceFiscale, String codiceFiscaleField) throws ValidationManagerException {
//		ValidationManagerException ex = null;
		
		if (GenericUtil.isNonNullOrEmpty(codiceFiscale))
		{
			
			if (codiceFiscale.length() == Constants.PARTITA_IVA_LEN)
			{
				controlloPIVA(codiceFiscale, codiceFiscaleField);
			}
			else
			{
				controlloCf(codiceFiscale, codiceFiscaleField);
			}
			
			
//			if(codiceFiscale.length() > Constants.CODICE_FISCALE_LEN) {
//				ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_CODICE_FISCALE));
//				ex.addField(codiceFiscaleField);
//				throw ex;
//			}
			
			
		}
	}
	

	private void controlloCf(String codFiscale, String codiceFiscaleField) throws ValidationManagerException{
		ValidationManagerException ex = null;
		char caratt;
		boolean ok = false;
		int controllo = -1;
		int resto;
		int sum_pari = 0;
		int sum_dispari = 0;
		// per l'ulteriore controllo del carattere finale
		int restoTwo = 0;
		String codiceFiscale = null;

		if ((codFiscale != null) && (codFiscale.length() == 16)) {
			codiceFiscale = codFiscale.toUpperCase();
			codFiscale = codFiscale.toUpperCase();
			for (int i = 1; i <= 15; i++) {
				int row;
				caratt = codFiscale.charAt(0);
				codFiscale = codFiscale.substring(1);

				for (row = 1; row <= 36; row++) {
					if (carattere[row - 1] == caratt) {
						if ((i / 2) * 2 == i) {
							sum_pari = sum_pari + valore_pari[row - 1];
							break;
						} else {
							sum_dispari = sum_dispari + valore_dispari[row - 1];
							break;
						}
					}
				}
				// Occorre controllare se l'utente ha inserito caratteri non
				// alfanumerici,
				// perche' in alcuni casi, con probabilita' minima ma non nulla,
				// il metodo
				// potrebbe non restituire il messaggio di errore
				if (row > 36) {
					// Il carattere non corrisponde a nessun valore salvato
					// nell'array
					// 'carattere', per cui viene creato il messaggio di errore
					// e si
					// forza l'uscita dal metodo, per non eseguire altro codice
					// a questo
					// punto inutile
					ex = new ValidationManagerException(new Message(Messages.ERROR_CODICE_FISCALE_FORMAT));
					ex.addField(codiceFiscaleField);
					throw ex;
				}
			}

			resto = (sum_pari + sum_dispari) - ((sum_pari + sum_dispari) / 26)
					* 26;
			caratt = codFiscale.charAt(0);

			for (int row = 1; row <= 36; row++) {
				if (carattere[row - 1] == caratt) {
					controllo = valore_pari[row - 1];
					break;
				}
			}
			/**
			 * ci sono alcuni casi in cui fare affidamemto al controllo di
			 * seguito non e' sufficiente per il corretto controllo del codice
			 * fiscale allora aggiungo io un controllo utilizzando il carattere
			 * di controllo finale del codice fiscale
			 */
			if (controllo == resto)
				ok = true;

			/**
			 * a questo punto visto che questo controllo non e' molto preciso
			 * vado a fare il controllo dell'ultimo carattere ma fuori allora
			 * devo prendere il resto che e' stato trovato precedentemente
			 */
			restoTwo = resto;

			if (ok) {
				/**
				 * agginta di francesca in data 17/01/2006 perche' non funziona il
				 * controllo sopra per il codice fiscale: mrlmfsc97s20c351 faccio
				 * l'ulteriore controllo del carattere finale di controllo
				 */
				
				if (carattere_di_controllo[restoTwo] == codiceFiscale.charAt(15))
					ok = true;
				else
					ok = false;
			}
		}

		if (!ok) {
			ex = new ValidationManagerException(new Message(Messages.ERROR_CODICE_FISCALE_FORMAT));
			ex.addField(codiceFiscaleField);
			throw ex;
		}
	}
	
	
	private void controlloPIVA(String partitaIva, String partitaIvaField) throws ValidationManagerException {
		boolean ok = false;
		int somma = 0;
		ValidationManagerException ex = null;
		if (validateCurrency(partitaIva, partitaIvaField) == null)
			return;

		if ((partitaIva != null) && (partitaIva.length() == 11)) {
			for (int i = 0; i <= 8; i += 2) {
				somma += partitaIva.charAt(i) - '0';
			}

			for (int i = 1; i <= 9; i += 2) {
				int temp = (partitaIva.charAt(i) - '0') * 2;
				if (temp > 9)
					temp -= 9;
				somma += temp;
			}

			if ((10 - somma % 10) % 10 == partitaIva.charAt(10) - '0') {
				ok = true;
			}
		}

		if (!ok)
		{
			ex = new ValidationManagerException(new Message(Messages.ERROR_PARTITA_IVA));
			ex.addField(partitaIvaField);
			throw ex;
		}
	}
	
	public void validazioneIndirizzoImpresa(PersonaGiuridica pg) throws ValidationManagerException
	{
		checkRicercaIndirizzo(pg.getIdComuneSelez(), pg.getIdProvinciaSelez(), 
				ConstantsField.ACCREDITAMENTO_IMPRESA_F_ID_COM_SELEZ, ConstantsField.ACCREDITAMENTO_IMPRESA_F_ID_PROV_SELEZ);
		
		if(GenericUtil.isNullOrEmpty(pg.getIndirizzo())) {
			ValidationManagerException ex = new ValidationManagerException(new Message(Messages.ERROR_INSERIRE_INDIRIZZO));
			ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_INDIRIZZO);
			throw ex;
		}

		if(pg.getIndirizzo().length()<3) {
			ValidationManagerException ex = new ValidationManagerException(new Message(Messages.ERROR_INSERIRE_INDIRIZZO_LUNGO));
			ex.addFieldRequired(ConstantsField.ACCREDITAMENTO_IMPRESA_F_INDIRIZZO);
			throw ex;
		}
	}
	
	public Double validateCurrency(String field, String partitaIvaField) throws ValidationManagerException{
		ValidationManagerException ex = null;
		if (field == null || field.length() == 0)
			return null;
		try {
			double value = Double.parseDouble(field);
			return new Double(value);
		} catch (NumberFormatException nfEx) {
			ex = new ValidationManagerException(new Message(Messages.ERROR_SOLO_NUMERICI));
			ex.addField(partitaIvaField);
			throw ex;
		}
	}
	
	/**
	 * @param per il controllo del codice fiscale
	 */
	
	private static char carattere[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
		'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
		'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
		'8', '9' };
	
	private static int valore_pari[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
		12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 0, 1, 2, 3,
		4, 5, 6, 7, 8, 9 };
	private static int valore_dispari[] = { 1, 0, 5, 7, 9, 13, 15, 17, 19, 21,
		2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24, 23, 1, 0, 5,
		7, 9, 13, 15, 17, 19, 21 };

	private static final char carattere_di_controllo[] = { 'A', 'B', 'C', 'D',
		'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
		'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
}

