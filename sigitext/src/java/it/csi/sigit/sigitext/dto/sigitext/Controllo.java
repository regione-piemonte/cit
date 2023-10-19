package it.csi.sigit.sigitext.dto.sigitext;

import java.util.Date;

public class Controllo {
	private Integer idAllegato;
	private Integer fkStatoRapp;
	private String desStatoRapp;
	private Integer fkEspezIspet;
	private Integer fkTipoDocumento;
	private String desTipoDocumento;
	private String fkSiglaBollino;
	private Integer fkNumeroBollino;
	private Date dataControllo;
	private Integer bFlgLibrettoUso;
	private Integer bFlgDichiarConform;
	private Integer bFlgLibImp;
	private Integer bFlgLibCompldi;
	private String fOsservazioni;
	private String fRaccomandazioni;
	private String fPrescrizioni;
	private Integer fFlgPuoFunzionare;
	private Date fInterventoEntro;
	private String fOraArrivo;
	private String fOraPartenza;
	private String fDenominazTecnico;
	private Integer fFlgFirmaTecnico;
	private Integer fFlgFirmaResponsabile;
	private Date dataInvio;
	private Date dataRespinta;
	private String nomeAllegato;
	private String aPotenzaTermicaNominaleMax;
	private Date dataUltMod;
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
	private Date dtInvioMemo;
	private String mailInvioMemo;
	private String uidIndexFirmato;
	private String nomeAllegatoFirmato;

	public Controllo() {
	}

	public Controllo(Integer idAllegato, Integer fkStatoRapp, String desStatoRapp, Integer fkEspezIspet, Integer fkTipoDocumento, String desTipoDocumento, String fkSiglaBollino, Integer fkNumeroBollino, Date dataControllo, Integer bFlgLibrettoUso, Integer bFlgDichiarConform, Integer bFlgLibImp, Integer bFlgLibCompldi, String fOsservazioni, String fRaccomandazioni, String fPrescrizioni, Integer fFlgPuoFunzionare, Date fInterventoEntro, String fOraArrivo, String fOraPartenza, String fDenominazTecnico, Integer fFlgFirmaTecnico, Integer fFlgFirmaResponsabile, Date dataInvio, Date dataRespinta, String nomeAllegato, String aPotenzaTermicaNominaleMax, Date dataUltMod, String utenteUltMod, String elencoCombustibili, String elencoApparecchiatura, Integer fkPgCat, String altroDescr, String desRuolo, String ruoloFunz, Integer idPersonaGiuridica, String pgDenominazione, String pgCodiceFiscale, Integer pgFkStatoPg, String pgSiglaRea, Integer codiceImpianto, String comuneImpianto, String siglaProvImpianto, String indirizzoUnitaImmob, String civicoUnitaImmob, Integer flgControlloBozza, String uidIndex, Integer idTipoManutenzione, String descTipoManutenzione, Date dtInvioMemo, String mailInvioMemo, String uidIndexFirmato, String nomeAllegatoFirmato) {
		this.idAllegato = idAllegato;
		this.fkStatoRapp = fkStatoRapp;
		this.desStatoRapp = desStatoRapp;
		this.fkEspezIspet = fkEspezIspet;
		this.fkTipoDocumento = fkTipoDocumento;
		this.desTipoDocumento = desTipoDocumento;
		this.fkSiglaBollino = fkSiglaBollino;
		this.fkNumeroBollino = fkNumeroBollino;
		this.dataControllo = dataControllo;
		this.bFlgLibrettoUso = bFlgLibrettoUso;
		this.bFlgDichiarConform = bFlgDichiarConform;
		this.bFlgLibImp = bFlgLibImp;
		this.bFlgLibCompldi = bFlgLibCompldi;
		this.fOsservazioni = fOsservazioni;
		this.fRaccomandazioni = fRaccomandazioni;
		this.fPrescrizioni = fPrescrizioni;
		this.fFlgPuoFunzionare = fFlgPuoFunzionare;
		this.fInterventoEntro = fInterventoEntro;
		this.fOraArrivo = fOraArrivo;
		this.fOraPartenza = fOraPartenza;
		this.fDenominazTecnico = fDenominazTecnico;
		this.fFlgFirmaTecnico = fFlgFirmaTecnico;
		this.fFlgFirmaResponsabile = fFlgFirmaResponsabile;
		this.dataInvio = dataInvio;
		this.dataRespinta = dataRespinta;
		this.nomeAllegato = nomeAllegato;
		this.aPotenzaTermicaNominaleMax = aPotenzaTermicaNominaleMax;
		this.dataUltMod = dataUltMod;
		this.utenteUltMod = utenteUltMod;
		this.elencoCombustibili = elencoCombustibili;
		this.elencoApparecchiatura = elencoApparecchiatura;
		this.fkPgCat = fkPgCat;
		this.altroDescr = altroDescr;
		this.desRuolo = desRuolo;
		this.ruoloFunz = ruoloFunz;
		this.idPersonaGiuridica = idPersonaGiuridica;
		this.pgDenominazione = pgDenominazione;
		this.pgCodiceFiscale = pgCodiceFiscale;
		this.pgFkStatoPg = pgFkStatoPg;
		this.pgSiglaRea = pgSiglaRea;
		this.codiceImpianto = codiceImpianto;
		this.comuneImpianto = comuneImpianto;
		this.siglaProvImpianto = siglaProvImpianto;
		this.indirizzoUnitaImmob = indirizzoUnitaImmob;
		this.civicoUnitaImmob = civicoUnitaImmob;
		this.flgControlloBozza = flgControlloBozza;
		this.uidIndex = uidIndex;
		this.idTipoManutenzione = idTipoManutenzione;
		this.descTipoManutenzione = descTipoManutenzione;
		this.dtInvioMemo = dtInvioMemo;
		this.mailInvioMemo = mailInvioMemo;
		this.uidIndexFirmato = uidIndexFirmato;
		this.nomeAllegatoFirmato = nomeAllegatoFirmato;
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

	public Date getDataControllo() {
		return dataControllo;
	}

	public void setDataControllo(Date dataControllo) {
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

	public Date getfInterventoEntro() {
		return fInterventoEntro;
	}

	public void setfInterventoEntro(Date fInterventoEntro) {
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

	public Date getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}

	public Date getDataRespinta() {
		return dataRespinta;
	}

	public void setDataRespinta(Date dataRespinta) {
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

	public Date getDataUltMod() {
		return dataUltMod;
	}

	public void setDataUltMod(Date dataUltMod) {
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

	public Date getDtInvioMemo() {
		return dtInvioMemo;
	}

	public void setDtInvioMemo(Date dtInvioMemo) {
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
		return "Controllo{" + "idAllegato=" + idAllegato + ", fkStatoRapp=" + fkStatoRapp + ", desStatoRapp='" + desStatoRapp + '\'' + ", fkEspezIspet=" + fkEspezIspet + ", fkTipoDocumento="
				+ fkTipoDocumento + ", desTipoDocumento='" + desTipoDocumento + '\'' + ", fkSiglaBollino=" + fkSiglaBollino + ", fkNumeroBollino=" + fkNumeroBollino + ", dataControllo="
				+ dataControllo + ", bFlgLibrettoUso=" + bFlgLibrettoUso + ", bFlgDichiarConform=" + bFlgDichiarConform + ", bFlgLibImp=" + bFlgLibImp + ", bFlgLibCompldi=" + bFlgLibCompldi
				+ ", fOsservazioni='" + fOsservazioni + '\'' + ", fRaccomandazioni='" + fRaccomandazioni + '\'' + ", fPrescrizioni='" + fPrescrizioni + '\'' + ", fFlgPuoFunzionare="
				+ fFlgPuoFunzionare + ", fInterventoEntro=" + fInterventoEntro + ", fOraArrivo='" + fOraArrivo + '\'' + ", fOraPartenza='" + fOraPartenza + '\'' + ", fDenominazTecnico='"
				+ fDenominazTecnico + '\'' + ", fFlgFirmaTecnico=" + fFlgFirmaTecnico + ", fFlgFirmaResponsabile=" + fFlgFirmaResponsabile + ", dataInvio=" + dataInvio + ", dataRespinta="
				+ dataRespinta + ", nomeAllegato='" + nomeAllegato + '\'' + ", aPotenzaTermicaNominaleMax='" + aPotenzaTermicaNominaleMax + '\'' + ", dataUltMod=" + dataUltMod + ", utenteUltMod='"
				+ utenteUltMod + '\'' + ", elencoCombustibili='" + elencoCombustibili + '\'' + ", elencoApparecchiatura='" + elencoApparecchiatura + '\'' + ", fkPgCat=" + fkPgCat + ", altroDescr='"
				+ altroDescr + '\'' + ", desRuolo='" + desRuolo + '\'' + ", ruoloFunz='" + ruoloFunz + '\'' + ", idPersonaGiuridica=" + idPersonaGiuridica + ", pgDenominazione='" + pgDenominazione
				+ '\'' + ", pgCodiceFiscale='" + pgCodiceFiscale + '\'' + ", pgFkStatoPg=" + pgFkStatoPg + ", pgSiglaRea='" + pgSiglaRea + '\'' + ", codiceImpianto=" + codiceImpianto
				+ ", comuneImpianto='" + comuneImpianto + '\'' + ", siglaProvImpianto='" + siglaProvImpianto + '\'' + ", indirizzoUnitaImmob='" + indirizzoUnitaImmob + '\'' + ", civicoUnitaImmob='"
				+ civicoUnitaImmob + '\'' + ", flgControlloBozza=" + flgControlloBozza + ", uidIndex='" + uidIndex + '\'' + ", idTipoManutenzione=" + idTipoManutenzione + ", descTipoManutenzione='"
				+ descTipoManutenzione + '\'' + ", dtInvioMemo=" + dtInvioMemo + ", mailInvioMemo='" + mailInvioMemo + '\'' + ", uidIndexFirmato='" + uidIndexFirmato + '\'' + ", nomeAllegatoFirmato='"
				+ nomeAllegatoFirmato + '\'' + '}';
	}
}
