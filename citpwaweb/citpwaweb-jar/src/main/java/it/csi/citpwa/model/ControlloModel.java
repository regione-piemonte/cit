package it.csi.citpwa.model;

import it.csi.citpwa.model.sigitext.Controllo;
import it.csi.citpwa.util.Constants;
import it.csi.citpwa.util.ObjectConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ControlloModel {
	private Integer idAllegato;
	private Integer fkStatoRapp;
	private String desStatoRapp;
	private Integer fkEspezIspet;
	private Integer fkTipoDocumento;
	private String desTipoDocumento;
	private String fkSiglaBollino;
	private Integer fkNumeroBollino;
	private String dataControllo;
	private Integer bFlgLibrettoUso;
	private Integer bFlgDichiarConform;
	private Integer bFlgLibImp;
	private Integer bFlgLibCompldi;
	private String fOsservazioni;
	private String fRaccomandazioni;
	private String fPrescrizioni;
	private Integer fFlgPuoFunzionare;
	private String fInterventoEntro;
	private String fOraArrivo;
	private String fOraPartenza;
	private String fDenominazTecnico;
	private Integer fFlgFirmaTecnico;
	private Integer fFlgFirmaResponsabile;
	private String dataInvio;
	private String dataRespinta;
	private String nomeAllegato;
	private String aPotenzaTermicaNominaleMax;
	private String dataUltMod;
	private String utenteUltMod;
	private String elencoCombustibili;
	private String elencoApparecchiatura;
	private Integer fkPgCat;
	private String altroDescr;
	private String desRuolo;
	private String ruoloFunz;
	private Integer idPersonaGiuridica;
	private String pgDenominazione;
	private String pgCodiceFiscale;
	private Integer pgFkStatoPg;
	private String pgSiglaRea;
	private Integer codiceImpianto;
	private String comuneImpianto;
	private String siglaProvImpianto;
	private String indirizzoUnitaImmob;
	private String civicoUnitaImmob;
	private Integer flgControlloBozza;
	private String uidIndex;
	private Integer idTipoManutenzione;
	private String descTipoManutenzione;
	private String dtInvioMemo;
	private String mailInvioMemo;
	private String uidIndexFirmato;
	private String nomeAllegatoFirmato;

	public static ObjectConverter<Controllo, ControlloModel> dtoToModel = new ObjectConverter<>(u -> {
		ControlloModel model = new ControlloModel();
		SimpleDateFormat format = new SimpleDateFormat(Constants.FORMAT);
		model.setIdAllegato(u.getIdAllegato());
		model.setFkStatoRapp(u.getFkStatoRapp());
		model.setDesStatoRapp(u.getDesStatoRapp());
		model.setFkEspezIspet(u.getFkEspezIspet());
		model.setFkTipoDocumento(u.getFkTipoDocumento());
		model.setDesTipoDocumento(u.getDesTipoDocumento());
		model.setFkSiglaBollino(u.getFkSiglaBollino());
		model.setFkNumeroBollino(u.getFkNumeroBollino());
		model.setDataControllo(u.getDataControllo() != null ? format.format(u.getDataControllo()) : null);
		model.setbFlgLibrettoUso(u.getbFlgLibrettoUso());
		model.setbFlgDichiarConform(u.getbFlgDichiarConform());
		model.setbFlgLibImp(u.getbFlgLibImp());
		model.setbFlgLibCompldi(u.getbFlgLibCompldi());
		model.setfOsservazioni(u.getfOsservazioni());
		model.setfRaccomandazioni(u.getfRaccomandazioni());
		model.setfPrescrizioni(u.getfPrescrizioni());
		model.setfFlgPuoFunzionare(u.getfFlgPuoFunzionare());
		model.setfInterventoEntro(u.getfInterventoEntro() != null ? format.format(u.getfInterventoEntro()) : null);
		model.setfOraArrivo(u.getfOraArrivo());
		model.setfOraPartenza(u.getfOraPartenza());
		model.setfDenominazTecnico(u.getfDenominazTecnico());
		model.setfFlgFirmaTecnico(u.getfFlgFirmaTecnico());
		model.setfFlgFirmaResponsabile(u.getfFlgFirmaResponsabile());
		model.setDataInvio(u.getDataInvio() != null ? format.format(u.getDataInvio()) : null);
		model.setDataRespinta(u.getDataRespinta() != null ? format.format(u.getDataRespinta()) : null);
		model.setNomeAllegato(u.getNomeAllegato());
		model.setaPotenzaTermicaNominaleMax(u.getaPotenzaTermicaNominaleMax());
		model.setDataUltMod(u.getDataUltMod() != null ? format.format(u.getDataUltMod()) : null);
		model.setUtenteUltMod(u.getUtenteUltMod());
		model.setElencoCombustibili(u.getElencoCombustibili());
		model.setElencoApparecchiatura(u.getElencoApparecchiatura());
		model.setFkPgCat(u.getFkPgCat());
		model.setAltroDescr(u.getAltroDescr());
		model.setDesRuolo(u.getDesRuolo());
		model.setRuoloFunz(u.getRuoloFunz());
		model.setIdPersonaGiuridica(u.getIdPersonaGiuridica());
		model.setPgDenominazione(u.getPgDenominazione());
		model.setPgCodiceFiscale(u.getPgCodiceFiscale());
		model.setPgFkStatoPg(u.getPgFkStatoPg());
		model.setPgSiglaRea(u.getPgSiglaRea());
		model.setCodiceImpianto(u.getCodiceImpianto());
		model.setComuneImpianto(u.getComuneImpianto());
		model.setSiglaProvImpianto(u.getSiglaProvImpianto());
		model.setIndirizzoUnitaImmob(u.getIndirizzoUnitaImmob());
		model.setCivicoUnitaImmob(u.getCivicoUnitaImmob());
		model.setFlgControlloBozza(u.getFlgControlloBozza());
		model.setUidIndex(u.getUidIndex());
		model.setIdTipoManutenzione(u.getIdTipoManutenzione());
		model.setDescTipoManutenzione(u.getDescTipoManutenzione());
		model.setDtInvioMemo(u.getDtInvioMemo() != null ? format.format(u.getDtInvioMemo()) : null);
		model.setMailInvioMemo(u.getMailInvioMemo());
		model.setUidIndexFirmato(u.getUidIndexFirmato());
		model.setNomeAllegatoFirmato(u.getNomeAllegatoFirmato());
		return model;
	});

	public static ObjectConverter<ControlloModel, Controllo> modelToDto = new ObjectConverter<>(u -> {
		Controllo dto = new Controllo();
		SimpleDateFormat format = new SimpleDateFormat(Constants.FORMAT);
		dto.setIdAllegato(u.getIdAllegato());
		dto.setFkStatoRapp(u.getFkStatoRapp());
		dto.setDesStatoRapp(u.getDesStatoRapp());
		dto.setFkEspezIspet(u.getFkEspezIspet());
		dto.setFkTipoDocumento(u.getFkTipoDocumento());
		dto.setDesTipoDocumento(u.getDesTipoDocumento());
		dto.setFkSiglaBollino(u.getFkSiglaBollino());
		dto.setFkNumeroBollino(u.getFkNumeroBollino());
		try {
			dto.setDataControllo(u.getDataControllo() != null ? format.parse(u.getDataControllo()) : null);
		} catch (ParseException e) {
			dto.setDataControllo(null);
		}
		dto.setbFlgLibrettoUso(u.getbFlgLibrettoUso());
		dto.setbFlgDichiarConform(u.getbFlgDichiarConform());
		dto.setbFlgLibImp(u.getbFlgLibImp());
		dto.setbFlgLibCompldi(u.getbFlgLibCompldi());
		dto.setfOsservazioni(u.getfOsservazioni());
		dto.setfRaccomandazioni(u.getfRaccomandazioni());
		dto.setfPrescrizioni(u.getfPrescrizioni());
		dto.setfFlgPuoFunzionare(u.getfFlgPuoFunzionare());
		try {
			dto.setfInterventoEntro(u.getfInterventoEntro() != null ? format.parse(u.getfInterventoEntro()) : null);
		} catch (ParseException e) {
			dto.setfInterventoEntro(null);
		}
		dto.setfOraArrivo(u.getfOraArrivo());
		dto.setfOraPartenza(u.getfOraPartenza());
		dto.setfDenominazTecnico(u.getfDenominazTecnico());
		dto.setfFlgFirmaTecnico(u.getfFlgFirmaTecnico());
		dto.setfFlgFirmaResponsabile(u.getfFlgFirmaResponsabile());
		try {
			dto.setDataInvio(u.getDataInvio() != null ? format.parse(u.getDataInvio()) : null);
		} catch (ParseException e) {
			dto.setDataInvio(null);
		}
		try{
		dto.setDataRespinta(u.getDataRespinta() != null ? format.parse(u.getDataRespinta()) : null);
		} catch (ParseException e) {
			dto.setDataRespinta(null);
		}
		dto.setNomeAllegato(u.getNomeAllegato());
		dto.setaPotenzaTermicaNominaleMax(u.getaPotenzaTermicaNominaleMax());
		try{
		dto.setDataUltMod(u.getDataUltMod() != null ? format.parse(u.getDataUltMod()) : null);
		} catch (ParseException e) {
			dto.setDataUltMod(null);
		}
		dto.setUtenteUltMod(u.getUtenteUltMod());
		dto.setElencoCombustibili(u.getElencoCombustibili());
		dto.setElencoApparecchiatura(u.getElencoApparecchiatura());
		dto.setFkPgCat(u.getFkPgCat());
		dto.setAltroDescr(u.getAltroDescr());
		dto.setDesRuolo(u.getDesRuolo());
		dto.setRuoloFunz(u.getRuoloFunz());
		dto.setIdPersonaGiuridica(u.getIdPersonaGiuridica());
		dto.setPgDenominazione(u.getPgDenominazione());
		dto.setPgCodiceFiscale(u.getPgCodiceFiscale());
		dto.setPgFkStatoPg(u.getPgFkStatoPg());
		dto.setPgSiglaRea(u.getPgSiglaRea());
		dto.setCodiceImpianto(u.getCodiceImpianto());
		dto.setComuneImpianto(u.getComuneImpianto());
		dto.setSiglaProvImpianto(u.getSiglaProvImpianto());
		dto.setIndirizzoUnitaImmob(u.getIndirizzoUnitaImmob());
		dto.setCivicoUnitaImmob(u.getCivicoUnitaImmob());
		dto.setFlgControlloBozza(u.getFlgControlloBozza());
		dto.setUidIndex(u.getUidIndex());
		dto.setIdTipoManutenzione(u.getIdTipoManutenzione());
		dto.setDescTipoManutenzione(u.getDescTipoManutenzione());
		try {
			dto.setDtInvioMemo(u.getDtInvioMemo() != null ? format.parse(u.getDtInvioMemo()) : null);
		} catch (ParseException e) {
			dto.setDtInvioMemo(null);
		}
		dto.setMailInvioMemo(u.getMailInvioMemo());
		dto.setUidIndexFirmato(u.getUidIndexFirmato());
		dto.setNomeAllegatoFirmato(u.getNomeAllegatoFirmato());
		return dto;
	});

	public ControlloModel() {
		//Not implemented
	}

	public Integer getIdAllegato() {
		return idAllegato;
	}

	public void setIdAllegato(Integer idAllegato) {
		this.idAllegato = idAllegato;
	}

	public Integer getFkStatoRapp() {
		return fkStatoRapp;
	}

	public void setFkStatoRapp(Integer fkStatoRapp) {
		this.fkStatoRapp = fkStatoRapp;
	}

	public String getDesStatoRapp() {
		return desStatoRapp;
	}

	public void setDesStatoRapp(String desStatoRapp) {
		this.desStatoRapp = desStatoRapp;
	}

	public Integer getFkEspezIspet() {
		return fkEspezIspet;
	}

	public void setFkEspezIspet(Integer fkEspezIspet) {
		this.fkEspezIspet = fkEspezIspet;
	}

	public Integer getFkTipoDocumento() {
		return fkTipoDocumento;
	}

	public void setFkTipoDocumento(Integer fkTipoDocumento) {
		this.fkTipoDocumento = fkTipoDocumento;
	}

	public String getDesTipoDocumento() {
		return desTipoDocumento;
	}

	public void setDesTipoDocumento(String desTipoDocumento) {
		this.desTipoDocumento = desTipoDocumento;
	}

	public String getFkSiglaBollino() {
		return fkSiglaBollino;
	}

	public void setFkSiglaBollino(String fkSiglaBollino) {
		this.fkSiglaBollino = fkSiglaBollino;
	}

	public Integer getFkNumeroBollino() {
		return fkNumeroBollino;
	}

	public void setFkNumeroBollino(Integer fkNumeroBollino) {
		this.fkNumeroBollino = fkNumeroBollino;
	}

	public String getDataControllo() {
		return dataControllo;
	}

	public void setDataControllo(String dataControllo) {
		this.dataControllo = dataControllo;
	}

	public Integer getbFlgLibrettoUso() {
		return bFlgLibrettoUso;
	}

	public void setbFlgLibrettoUso(Integer bFlgLibrettoUso) {
		this.bFlgLibrettoUso = bFlgLibrettoUso;
	}

	public Integer getbFlgDichiarConform() {
		return bFlgDichiarConform;
	}

	public void setbFlgDichiarConform(Integer bFlgDichiarConform) {
		this.bFlgDichiarConform = bFlgDichiarConform;
	}

	public Integer getbFlgLibImp() {
		return bFlgLibImp;
	}

	public void setbFlgLibImp(Integer bFlgLibImp) {
		this.bFlgLibImp = bFlgLibImp;
	}

	public Integer getbFlgLibCompldi() {
		return bFlgLibCompldi;
	}

	public void setbFlgLibCompldi(Integer bFlgLibCompldi) {
		this.bFlgLibCompldi = bFlgLibCompldi;
	}

	public String getfOsservazioni() {
		return fOsservazioni;
	}

	public void setfOsservazioni(String fOsservazioni) {
		this.fOsservazioni = fOsservazioni;
	}

	public String getfRaccomandazioni() {
		return fRaccomandazioni;
	}

	public void setfRaccomandazioni(String fRaccomandazioni) {
		this.fRaccomandazioni = fRaccomandazioni;
	}

	public String getfPrescrizioni() {
		return fPrescrizioni;
	}

	public void setfPrescrizioni(String fPrescrizioni) {
		this.fPrescrizioni = fPrescrizioni;
	}

	public Integer getfFlgPuoFunzionare() {
		return fFlgPuoFunzionare;
	}

	public void setfFlgPuoFunzionare(Integer fFlgPuoFunzionare) {
		this.fFlgPuoFunzionare = fFlgPuoFunzionare;
	}

	public String getfInterventoEntro() {
		return fInterventoEntro;
	}

	public void setfInterventoEntro(String fInterventoEntro) {
		this.fInterventoEntro = fInterventoEntro;
	}

	public String getfOraArrivo() {
		return fOraArrivo;
	}

	public void setfOraArrivo(String fOraArrivo) {
		this.fOraArrivo = fOraArrivo;
	}

	public String getfOraPartenza() {
		return fOraPartenza;
	}

	public void setfOraPartenza(String fOraPartenza) {
		this.fOraPartenza = fOraPartenza;
	}

	public String getfDenominazTecnico() {
		return fDenominazTecnico;
	}

	public void setfDenominazTecnico(String fDenominazTecnico) {
		this.fDenominazTecnico = fDenominazTecnico;
	}

	public Integer getfFlgFirmaTecnico() {
		return fFlgFirmaTecnico;
	}

	public void setfFlgFirmaTecnico(Integer fFlgFirmaTecnico) {
		this.fFlgFirmaTecnico = fFlgFirmaTecnico;
	}

	public Integer getfFlgFirmaResponsabile() {
		return fFlgFirmaResponsabile;
	}

	public void setfFlgFirmaResponsabile(Integer fFlgFirmaResponsabile) {
		this.fFlgFirmaResponsabile = fFlgFirmaResponsabile;
	}

	public String getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(String dataInvio) {
		this.dataInvio = dataInvio;
	}

	public String getDataRespinta() {
		return dataRespinta;
	}

	public void setDataRespinta(String dataRespinta) {
		this.dataRespinta = dataRespinta;
	}

	public String getNomeAllegato() {
		return nomeAllegato;
	}

	public void setNomeAllegato(String nomeAllegato) {
		this.nomeAllegato = nomeAllegato;
	}

	public String getaPotenzaTermicaNominaleMax() {
		return aPotenzaTermicaNominaleMax;
	}

	public void setaPotenzaTermicaNominaleMax(String aPotenzaTermicaNominaleMax) {
		this.aPotenzaTermicaNominaleMax = aPotenzaTermicaNominaleMax;
	}

	public String getDataUltMod() {
		return dataUltMod;
	}

	public void setDataUltMod(String dataUltMod) {
		this.dataUltMod = dataUltMod;
	}

	public String getUtenteUltMod() {
		return utenteUltMod;
	}

	public void setUtenteUltMod(String utenteUltMod) {
		this.utenteUltMod = utenteUltMod;
	}

	public String getElencoCombustibili() {
		return elencoCombustibili;
	}

	public void setElencoCombustibili(String elencoCombustibili) {
		this.elencoCombustibili = elencoCombustibili;
	}

	public String getElencoApparecchiatura() {
		return elencoApparecchiatura;
	}

	public void setElencoApparecchiatura(String elencoApparecchiatura) {
		this.elencoApparecchiatura = elencoApparecchiatura;
	}

	public Integer getFkPgCat() {
		return fkPgCat;
	}

	public void setFkPgCat(Integer fkPgCat) {
		this.fkPgCat = fkPgCat;
	}

	public String getAltroDescr() {
		return altroDescr;
	}

	public void setAltroDescr(String altroDescr) {
		this.altroDescr = altroDescr;
	}

	public String getDesRuolo() {
		return desRuolo;
	}

	public void setDesRuolo(String desRuolo) {
		this.desRuolo = desRuolo;
	}

	public String getRuoloFunz() {
		return ruoloFunz;
	}

	public void setRuoloFunz(String ruoloFunz) {
		this.ruoloFunz = ruoloFunz;
	}

	public Integer getIdPersonaGiuridica() {
		return idPersonaGiuridica;
	}

	public void setIdPersonaGiuridica(Integer idPersonaGiuridica) {
		this.idPersonaGiuridica = idPersonaGiuridica;
	}

	public String getPgDenominazione() {
		return pgDenominazione;
	}

	public void setPgDenominazione(String pgDenominazione) {
		this.pgDenominazione = pgDenominazione;
	}

	public String getPgCodiceFiscale() {
		return pgCodiceFiscale;
	}

	public void setPgCodiceFiscale(String pgCodiceFiscale) {
		this.pgCodiceFiscale = pgCodiceFiscale;
	}

	public Integer getPgFkStatoPg() {
		return pgFkStatoPg;
	}

	public void setPgFkStatoPg(Integer pgFkStatoPg) {
		this.pgFkStatoPg = pgFkStatoPg;
	}

	public String getPgSiglaRea() {
		return pgSiglaRea;
	}

	public void setPgSiglaRea(String pgSiglaRea) {
		this.pgSiglaRea = pgSiglaRea;
	}

	public Integer getCodiceImpianto() {
		return codiceImpianto;
	}

	public void setCodiceImpianto(Integer codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}

	public String getComuneImpianto() {
		return comuneImpianto;
	}

	public void setComuneImpianto(String comuneImpianto) {
		this.comuneImpianto = comuneImpianto;
	}

	public String getSiglaProvImpianto() {
		return siglaProvImpianto;
	}

	public void setSiglaProvImpianto(String siglaProvImpianto) {
		this.siglaProvImpianto = siglaProvImpianto;
	}

	public String getIndirizzoUnitaImmob() {
		return indirizzoUnitaImmob;
	}

	public void setIndirizzoUnitaImmob(String indirizzoUnitaImmob) {
		this.indirizzoUnitaImmob = indirizzoUnitaImmob;
	}

	public String getCivicoUnitaImmob() {
		return civicoUnitaImmob;
	}

	public void setCivicoUnitaImmob(String civicoUnitaImmob) {
		this.civicoUnitaImmob = civicoUnitaImmob;
	}

	public Integer getFlgControlloBozza() {
		return flgControlloBozza;
	}

	public void setFlgControlloBozza(Integer flgControlloBozza) {
		this.flgControlloBozza = flgControlloBozza;
	}

	public String getUidIndex() {
		return uidIndex;
	}

	public void setUidIndex(String uidIndex) {
		this.uidIndex = uidIndex;
	}

	public Integer getIdTipoManutenzione() {
		return idTipoManutenzione;
	}

	public void setIdTipoManutenzione(Integer idTipoManutenzione) {
		this.idTipoManutenzione = idTipoManutenzione;
	}

	public String getDescTipoManutenzione() {
		return descTipoManutenzione;
	}

	public void setDescTipoManutenzione(String descTipoManutenzione) {
		this.descTipoManutenzione = descTipoManutenzione;
	}

	public String getDtInvioMemo() {
		return dtInvioMemo;
	}

	public void setDtInvioMemo(String dtInvioMemo) {
		this.dtInvioMemo = dtInvioMemo;
	}

	public String getMailInvioMemo() {
		return mailInvioMemo;
	}

	public void setMailInvioMemo(String mailInvioMemo) {
		this.mailInvioMemo = mailInvioMemo;
	}

	public String getUidIndexFirmato() {
		return uidIndexFirmato;
	}

	public void setUidIndexFirmato(String uidIndexFirmato) {
		this.uidIndexFirmato = uidIndexFirmato;
	}

	public String getNomeAllegatoFirmato() {
		return nomeAllegatoFirmato;
	}

	public void setNomeAllegatoFirmato(String nomeAllegatoFirmato) {
		this.nomeAllegatoFirmato = nomeAllegatoFirmato;
	}

	@Override
	public String toString() {
		return "ControlloModel{" + "idAllegato=" + idAllegato + ", fkStatoRapp=" + fkStatoRapp + ", desStatoRapp='" + desStatoRapp + '\'' + ", fkEspezIspet=" + fkEspezIspet + ", fkTipoDocumento="
				+ fkTipoDocumento + ", desTipoDocumento='" + desTipoDocumento + '\'' + ", fkSiglaBollino=" + fkSiglaBollino + ", fkNumeroBollino=" + fkNumeroBollino + ", dataControllo='"
				+ dataControllo + '\'' + ", bFlgLibrettoUso=" + bFlgLibrettoUso + ", bFlgDichiarConform=" + bFlgDichiarConform + ", bFlgLibImp=" + bFlgLibImp + ", bFlgLibCompldi=" + bFlgLibCompldi
				+ ", fOsservazioni='" + fOsservazioni + '\'' + ", fRaccomandazioni='" + fRaccomandazioni + '\'' + ", fPrescrizioni='" + fPrescrizioni + '\'' + ", fFlgPuoFunzionare="
				+ fFlgPuoFunzionare + ", fInterventoEntro='" + fInterventoEntro + '\'' + ", fOraArrivo='" + fOraArrivo + '\'' + ", fOraPartenza='" + fOraPartenza + '\'' + ", fDenominazTecnico='"
				+ fDenominazTecnico + '\'' + ", fFlgFirmaTecnico=" + fFlgFirmaTecnico + ", fFlgFirmaResponsabile=" + fFlgFirmaResponsabile + ", dataInvio='" + dataInvio + '\'' + ", dataRespinta='"
				+ dataRespinta + '\'' + ", nomeAllegato='" + nomeAllegato + '\'' + ", aPotenzaTermicaNominaleMax='" + aPotenzaTermicaNominaleMax + '\'' + ", dataUltMod='" + dataUltMod + '\''
				+ ", utenteUltMod='" + utenteUltMod + '\'' + ", elencoCombustibili='" + elencoCombustibili + '\'' + ", elencoApparecchiatura='" + elencoApparecchiatura + '\'' + ", fkPgCat=" + fkPgCat
				+ ", altroDescr='" + altroDescr + '\'' + ", desRuolo='" + desRuolo + '\'' + ", ruoloFunz='" + ruoloFunz + '\'' + ", idPersonaGiuridica=" + idPersonaGiuridica + ", pgDenominazione='"
				+ pgDenominazione + '\'' + ", pgCodiceFiscale='" + pgCodiceFiscale + '\'' + ", pgFkStatoPg=" + pgFkStatoPg + ", pgSiglaRea='" + pgSiglaRea + '\'' + ", codiceImpianto=" + codiceImpianto
				+ ", comuneImpianto='" + comuneImpianto + '\'' + ", siglaProvImpianto='" + siglaProvImpianto + '\'' + ", indirizzoUnitaImmob='" + indirizzoUnitaImmob + '\'' + ", civicoUnitaImmob='"
				+ civicoUnitaImmob + '\'' + ", flgControlloBozza=" + flgControlloBozza + ", uidIndex='" + uidIndex + '\'' + ", idTipoManutenzione=" + idTipoManutenzione + ", descTipoManutenzione='"
				+ descTipoManutenzione + '\'' + ", dtInvioMemo='" + dtInvioMemo + '\'' + ", mailInvioMemo='" + mailInvioMemo + '\'' + ", uidIndexFirmato='" + uidIndexFirmato + '\''
				+ ", nomeAllegatoFirmato='" + nomeAllegatoFirmato + '\'' + '}';
	}
}
