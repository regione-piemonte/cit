/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service.impl;

import it.csi.citpwa.business.service.ValidationService;
import it.csi.citpwa.model.DatiImpiantoModel;
import it.csi.citpwa.model.sigitext.*;
import it.csi.citpwa.util.Constants;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidationServiceImp implements ValidationService {

	private static final char[] carattere = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4',
			'5', '6', '7', '8', '9' };
	private static final int[] valore_pari = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private static final int[] valore_dispari = { 1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24, 23, 1, 0, 5, 7, 9, 13, 15, 17, 19, 21 };

	private static final char[] carattere_di_controllo = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	@Override
	public Esito validaInserisciImpianto(DatiImpiantoModel datiImpianto, UtenteLoggato utenteLoggato) {
		Esito esito = new Esito();
		esito.setEsito(Constants.OK);
		StringBuilder descEsito = new StringBuilder();

		if (!isNotNullOrEmpty(datiImpianto.getDataVar())) {
			esito.setEsito(Constants.KO);
			descEsito.append("Data variazione non valida");
			descEsito.append("\n");
		}

		if (!isNotNullOrEmpty(datiImpianto.getMotivazione())) {
			esito.setEsito(Constants.KO);
			descEsito.append("Motivazione non valida");
			descEsito.append("\n");
		}

		if (!isNotNullOrEmpty(datiImpianto.getStato())) {
			esito.setEsito(Constants.KO);
			descEsito.append("Stato impianto non valido");
			descEsito.append("\n");
		}

		if (!isNotNullOrEmpty(datiImpianto.getStato())) {
			esito.setEsito(Constants.KO);
			descEsito.append("Stato impianto non valido");
			descEsito.append("\n");
		}

		if (!isNotNullOrEmpty(datiImpianto.getFlgContabilizzazione())) {
			datiImpianto.setFlgContabilizzazione(false);
		}

		if (!isNotNullOrEmpty(datiImpianto.getFlgApparevvUiExt())) {
			datiImpianto.setFlgApparevvUiExt(false);
		}

		if (!isNotNullOrEmpty(datiImpianto.getStradario())) {
			datiImpianto.setStradario(false);
		}

		if (!isNotNullOrEmpty(datiImpianto.getPod()) || !checkPOD(datiImpianto.getPod())) {
			esito.setEsito(Constants.KO);
			descEsito.append("POD non valido");
			descEsito.append("\n");
		} else {
			datiImpianto.setPod(datiImpianto.getPod().toUpperCase());
		}

		if (!isNotNullOrEmpty(datiImpianto.getFlgNoPdr())) {
			datiImpianto.setFlgNoPdr(false);
		}

		if (!isNotNullOrEmpty(datiImpianto.getFlgNoPdr())) {
			if (!isNotNullOrEmpty(datiImpianto.getPdr()) || !checkPDR(datiImpianto.getPdr())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Pdr non valido");
				descEsito.append("\n");
			} else {
				datiImpianto.setPdr(datiImpianto.getPdr().toUpperCase());
			}
		}

		if (datiImpianto.getStradario().equals(true)) {
			if (!isNotNullOrEmpty(datiImpianto.getIndirizzoNonTrovato())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Indirizzo inserito non valido");
				descEsito.append("\n");
			}
			if (!isNotNullOrEmpty(datiImpianto.getCivico())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Civico non valido");
				descEsito.append("\n");
			}

			if (!isNotNullOrEmpty(datiImpianto.getComune())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Comune non valido");
				descEsito.append("\n");
			}

			if (!isNotNullOrEmpty(datiImpianto.getProvincia())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Provincia non valida");
				descEsito.append("\n");
			}
		} else {
			if (!isNotNullOrEmpty(datiImpianto.getIndirizzoSitad())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Indirizzo selezionato non valido - sitad");
				descEsito.append("\n");
			}
			if (!isNotNullOrEmpty(datiImpianto.getComune())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Indirizzo selezionato non valido - comune");
				descEsito.append("\n");
			}
			if (!isNotNullOrEmpty(datiImpianto.getProvincia())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Indirizzo selezionato non valido - provincia");
				descEsito.append("\n");
			}
			if (!isNotNullOrEmpty(datiImpianto.getSiglaProv())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Indirizzo selezionato non valido - siglaProv");
				descEsito.append("\n");
			}
			if (!isNotNullOrEmpty(datiImpianto.getCivico())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Indirizzo selezionato non valido - civico");
				descEsito.append("\n");
			}
		}
		if (Constants.RUOLO_VALIDATORE.equals(utenteLoggato.getRuoloLoggato().getRuolo()) || Constants.RUOLO_ISPETTORE.equals(utenteLoggato.getRuoloLoggato().getRuolo())) {
			if (utenteLoggato.getRuoloLoggato().getIstatAbilitazione().length() > 2) {
				String istatProv = getCodIstatProvByIstatAbilitazione(utenteLoggato.getRuoloLoggato().getIstatAbilitazione());
				String istatProvImp = datiImpianto.getIstatComune();
				if (!istatProvImp.startsWith(istatProv)) {
					esito.setEsito(Constants.KO);
					descEsito.append("Utente non abilitato alla provincia indicata - ").append(datiImpianto.getProvincia()).append(" - ").append(datiImpianto.getSiglaProv());
					descEsito.append("\n");
				}
			}

			if (utenteLoggato.getRuoloLoggato().getIstatAbilitazione().length() > 5) {
				String istatProv = getCodIstatComuneByIstatAbilitazione(utenteLoggato.getRuoloLoggato().getIstatAbilitazione());
				String istatProvImp = datiImpianto.getIstatComune();
				if (!istatProvImp.startsWith(istatProv)) {
					esito.setEsito(Constants.KO);
					descEsito.append("Utente non abilitato al comune indicato - ").append(datiImpianto.getComune());
					descEsito.append("\n");
				}
			}
		}
		esito.setDescrizioneEsito(descEsito.toString());
		return esito;
	}

	private boolean checkPDR(String pdr) {
		return isStringValid(pdr.toUpperCase(), Constants.PDR);
	}

	private boolean checkPOD(String pod) {
		return isStringValid(pod.toUpperCase(), Constants.POD);
	}

	public static boolean isStringValid(String string, String regex) {
		Pattern pattern = null;
		Matcher matcher = null;
		boolean isValid;

		isValid = false;
		if (string != null) {

			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(string);
			isValid = matcher.matches();
		}

		return isValid;
	}

	@Override
	public Boolean isStatoPGValido(UtenteLoggato utenteLoggato) {
		if (utenteLoggato.getRuoloLoggato() != null) {
			if (utenteLoggato.getRuoloLoggato().getRuolo().equals(Constants.RUOLO_3RESPONSABILE) || utenteLoggato.getRuoloLoggato().getRuolo().equals(Constants.RUOLO_IMPRESA)
					|| utenteLoggato.getRuoloLoggato().getRuolo().equals(Constants.RUOLO_DISTRIBUTORE) || utenteLoggato.getRuoloLoggato().getRuolo().equals(Constants.RUOLO_CAT)) {
				return utenteLoggato.getRuoloLoggato().getIdStato() != Constants.ID_STATO_IMPRESA_SOSPESA && utenteLoggato.getRuoloLoggato().getIdStato() != Constants.ID_STATO_IMPRESA_RADIATA;
			} else {
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean isAbilitatoInserisciImpianto(UtenteLoggato utenteLoggato) {
		if (utenteLoggato.getRuoloLoggato() != null) {
			return !utenteLoggato.getRuoloLoggato().getRuolo().equals(Constants.RUOLO_3RESPONSABILE) && !utenteLoggato.getRuoloLoggato().getRuolo().equals(Constants.RUOLO_CONSULTATORE)
					&& !utenteLoggato.getRuoloLoggato().getRuolo().equals(Constants.RUOLO_PROPRIETARIO) && !utenteLoggato.getRuoloLoggato().getRuolo().equals(Constants.RUOLO_PROPRIETARIO_IMPRESA);
		} else {
			return false;
		}
	}

	@Override
	public Boolean validateRicercaImpianto(UtenteLoggato utenteLoggato, ImpiantoFiltro impiantoFiltro) {
		boolean result = utenteLoggato.getRuoloLoggato() != null;
		switch (utenteLoggato.getRuoloLoggato().getRuolo()) {
			case Constants.RUOLO_3RESPONSABILE:
				result = impiantoFiltro.getCf3Responsabile().equals(utenteLoggato.getRuoloLoggato().getPiva());
				break;
			case Constants.RUOLO_RESPONSABILE:
				result = impiantoFiltro.getCfResponsabile().equals(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
				break;
			case Constants.RUOLO_RESPONSABILE_IMPRESA:
				result = impiantoFiltro.getCfResponsabile().equals(utenteLoggato.getRuoloLoggato().getPiva());
				break;
			case Constants.RUOLO_PROPRIETARIO:
				result = impiantoFiltro.getCfProprietario().equals(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
				break;
			case Constants.RUOLO_PROPRIETARIO_IMPRESA:
				result = impiantoFiltro.getCfProprietario().equals(utenteLoggato.getRuoloLoggato().getPiva());
				break;
			case Constants.RUOLO_DISTRIBUTORE:
			case Constants.RUOLO_CAT:
				result = false;
				break;
			default:
				break;
		}
		return result;
	}

	@Override
	public boolean isNotNullOrEmpty(String s) {
		return s != null && s.trim().length() > 0;
	}

	@Override
	public boolean isNotNullOrEmpty(Integer s) {
		return s != null;
	}

	@Override
	public boolean isNotNullOrEmpty(Object s) {
		return s != null;
	}

	@Override
	public DatiImpianto mapDatiImpianto(DatiImpiantoModel datiImpianto) {
		DatiImpianto dati = new DatiImpianto();
		dati.setCodiceImpianto(datiImpianto.getCodiceImpianto());
		dati.setCivico(datiImpianto.getCivico());
		dati.setComune(datiImpianto.getComune());
		dati.setCoordX(datiImpianto.getCoordX());
		dati.setIndirizzoNonTrovato(datiImpianto.getIndirizzoNonTrovato());
		dati.setIndirizzoSitad(datiImpianto.getIndirizzoSitad());
		dati.setDataVar(datiImpianto.getDataVar());
		dati.setCoordY(datiImpianto.getCoordY());
		dati.setFlgNoPdr(datiImpianto.getFlgNoPdr().equals(true) ? 1 : 0);
		dati.setFlgApparevvUiExt(datiImpianto.getFlgApparevvUiExt().equals(true) ? 1 : 0);
		dati.setFlgContabilizzazione(datiImpianto.getFlgContabilizzazione().equals(true) ? 1 : 0);
		dati.setFlgVisuProprietario(datiImpianto.getFlgVisuProprietario().equals(true) ? 1 : 0);
		dati.setPdr(datiImpianto.getPdr());
		dati.setPod(datiImpianto.getPod());
		dati.setProvincia(datiImpianto.getProvincia());
		dati.setStato(datiImpianto.getStato());
		dati.setTipoImpianto(datiImpianto.getTipoImpianto());
		dati.setStradario(datiImpianto.getStradario().equals(true) ? 1 : 0);
		dati.setMotivazione(datiImpianto.getMotivazione());
		dati.setSiglaProv(datiImpianto.getSiglaProv());
		dati.setIstatComune(datiImpianto.getIstatComune());
		dati.setFlgMedioimpianto(datiImpianto.getFlgMedioImpiantoCivile().equals(true) ? 1 : 0);
		return dati;
	}

	@Override
	public Esito validaNuovoResponsabileProprietario(Persona responsabile) {
		Esito esito = new Esito();
		esito.setEsito(Constants.OK);
		StringBuilder descEsito = new StringBuilder();
		boolean isResp = responsabile.getFlgResp();
		if (isResp && !isNotNullOrEmpty(responsabile.getTitolo())) {
			esito.setEsito(Constants.KO);
			descEsito.append("Titolo non valido");
			descEsito.append("\n");
		}

		if (!isNotNullOrEmpty(responsabile.getTipo())) {
			esito.setEsito(Constants.KO);
			descEsito.append("Tipo responsabile non valido");
			descEsito.append("\n");
		}

		if (!isNotNullOrEmpty(responsabile.getCodiceFiscale())) {
			esito.setEsito(Constants.KO);
			descEsito.append("Codice fiscale/P.Iva non valido");
			descEsito.append("\n");
		} else {
			if (responsabile.getCodiceFiscale().length() == Constants.PARTITA_IVA_LEN) {
				if (!controlloPIVA(responsabile.getCodiceFiscale())) {
					esito.setEsito(Constants.KO);
					descEsito.append("P.IVA formalmente errata");
					descEsito.append("\n");
				}
			} else {
				if (!controlloCf(responsabile.getCodiceFiscale())) {
					esito.setEsito(Constants.KO);
					descEsito.append("Codice fiscale formalmente errato");
					descEsito.append("\n");
				}
			}
		}

		if (!isNotNullOrEmpty(responsabile.getCognomeDenominazione())) {
			esito.setEsito(Constants.KO);
			descEsito.append("Cognome/Denominazione non valido");
			descEsito.append("\n");
		}

		if (isNotNullOrEmpty(responsabile.getResidenzaEstera()) && responsabile.getResidenzaEstera() == 1) {
			if (!isNotNullOrEmpty(responsabile.getIndirizzoEstero())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Indirizzo estero non valido");
				descEsito.append("\n");
			}
			if (!isNotNullOrEmpty(responsabile.getStatoEstero())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Stato estero non valido");
				descEsito.append("\n");
			}
			if (!isNotNullOrEmpty(responsabile.getCapEstero())) {
				esito.setEsito(Constants.KO);
				descEsito.append("CAP estero non valido");
				descEsito.append("\n");
			}
			if (!isNotNullOrEmpty(responsabile.getCittaEstero())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Citta estera non valida");
				descEsito.append("\n");
			}
		} else {

			if (!isNotNullOrEmpty(responsabile.getComune())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Indirizzo selezionato non valido - comune");
				descEsito.append("\n");
			}
			if (!isNotNullOrEmpty(responsabile.getProvincia())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Indirizzo selezionato non valido - provincia");
				descEsito.append("\n");
			}
			if (!isNotNullOrEmpty(responsabile.getProvincia())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Indirizzo selezionato non valido - siglaProv");
				descEsito.append("\n");
			}
			if (!isNotNullOrEmpty(responsabile.getCivico())) {
				esito.setEsito(Constants.KO);
				descEsito.append("Indirizzo selezionato non valido - civico");
				descEsito.append("\n");
			}

			if (!isNotNullOrEmpty(responsabile.getIndirizzoNonTrovato())) {
				if (!isNotNullOrEmpty(responsabile.getIndirizzoSitad())) {
					esito.setEsito(Constants.KO);
					descEsito.append("Indirizzo selezionato non valido - sitad");
					descEsito.append("\n");
				}
			}
		}

		if (isDataFutura(responsabile.getDataInizioResp())) {
			esito.setEsito(Constants.KO);
			descEsito.append("Impossibile inserire una data futura");
			descEsito.append("\n");
		}

		esito.setDescrizioneEsito(descEsito.toString());
		return esito;
	}

	@Override
	public XMLGregorianCalendar convertToDate(String datestr, String format) throws ParseException, DatatypeConfigurationException {
		if (datestr != null) {
			DateFormat formatter = new SimpleDateFormat(format);
			Date date = formatter.parse(datestr);
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(date);
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} else
			return null;
	}

	private boolean controlloPIVA(String partitaIva) {
		boolean ok = false;
		int somma = 0;
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
		return ok;
	}

	private boolean controlloCf(String codFiscale) {
		char caratt;
		boolean ok = false;
		int controllo = -1;
		int resto;
		int sumPari = 0;
		int sumDispari = 0;
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
							sumPari = sumPari + valore_pari[row - 1];
						} else {
							sumDispari = sumDispari + valore_dispari[row - 1];
						}
						break;
					}
				}
				if (row > 36) {
					return false;
				}
			}

			resto = (sumPari + sumDispari) - ((sumPari + sumDispari) / 26) * 26;
			caratt = codFiscale.charAt(0);

			for (int row = 1; row <= 36; row++) {
				if (carattere[row - 1] == caratt) {
					controllo = valore_pari[row - 1];
					break;
				}
			}

			if (controllo == resto)
				ok = true;

			restoTwo = resto;

			if (ok) {
				if (carattere_di_controllo[restoTwo] == codiceFiscale.charAt(15))
					ok = true;
				else
					ok = false;
			}
		}
		return ok;
	}

	public String getCodIstatProvByIstatAbilitazione(String istatAbilitazione) {
		String cod = null;
		if (isNotNullOrEmpty(istatAbilitazione)) {
			cod = istatAbilitazione.substring(2, 5);
		}
		return cod;
	}

	public String getCodIstatComuneByIstatAbilitazione(String istatAbilitazione) {
		String cod = null;
		if (isNotNullOrEmpty(istatAbilitazione)) {
			cod = istatAbilitazione.substring(2);
		}
		return cod;
	}

	protected boolean isDataFutura(Date dateToCheck) {
		return dateToCheck.getTime() > System.currentTimeMillis();
	}
}
