/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch.timerservicememo;

import it.csi.sigit.sigitbatchn.batch.AbstractBatch;
import it.csi.sigit.sigitbatchn.batch.BatchConf;
import it.csi.sigit.sigitbatchn.batch.BatchException;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.manager.DbMgr;
import it.csi.sigit.sigitbatchn.business.manager.NotifyMgr;
import it.csi.sigit.sigitbatchn.business.manager.ServiziMgr;
import it.csi.sigit.sigitbatchn.business.manager.SigitbatchMgr;
import it.csi.sigit.sigitbatchn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitbatchn.business.util.Constants;
import it.csi.sigit.sigitbatchn.business.util.ConvertUtil;
import it.csi.sigit.sigitbatchn.business.util.GenericUtil;
import it.csi.sigit.sigitbatchn.business.util.InputAllegatiComp;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Thread.sleep;

/**
 * Batch per recuperare le informazioni dei distributori
 */
public class TimerServiceMemoBatch extends AbstractBatch {
	/**
	 * Nome della classe
	 */
	private final static String CLASS_NAME = TimerServiceMemoBatch.class.getSimpleName();

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business");

	private final String PROPERTIES_RESOURCE = "/META-INF/sigitbatchn.properties";

	/**
	 * Manager business
	 */
	private SigitbatchMgr sigitbatchMgr = null;
	private NotifyMgr notifyMgr = null;

	/**
	 * {@inheritDoc}
	 */
	public void execute() throws BatchException {
		final String METHOD_NAME = "execute";
		TimerServiceMemoConf conf = null;
		SigitbatchMgr sigitbatchMgr = getSigitbatchMgr();
		ServiziMgr serviziMgr = sigitbatchMgr.getServiziMgr();
		DbMgr dbMgr = sigitbatchMgr.getDbMgr();
		NotifyMgr notifyMgr = getNotifyMgr();

		log.debug("[TimerServiceMemoBatch::execute] BEGIN");

		try {
			// Procedura “MEMO Sveglie PA”
			if (!dbMgr.cercaConfigValueFlg(Constants.CONFIG_KEY_CIT_MEMO_SVEGLIA_PA_ATTIVO)) {
				insertWrkLogMemo("CIT_MEMO_SVEGLIA_PA_ATTIVO non attivato");
			} else {
				inviaSveglieUtentiAttivi();
				inviaSveglieUtentiNonAttivi();
				insertWrkLogMemo("Procedura MEMO_SVEGLIA_PA conclusa");
			}

			//Procedura “MEMO scadenza Responsabile Impianto”
			if (!dbMgr.cercaConfigValueFlg(Constants.CONFIG_KEY_CIT_MEMO_SCADENZA_RI_ATTIVO)) {
				insertWrkLogMemo("CIT_MEMO_SCADENZA_RI_ATTIVO non attivato");
			} else {
				inviaSvegliaResponsabiliImpianti();
				insertWrkLogMemo("Procedura CIT_MEMO_SCADENZA_RI_ATTIVO conclusa");
			}

			//Procedura “MEMO scadenza Responsabile Impianto Piemonte Tu”
			if (!dbMgr.cercaConfigValueFlg(Constants.CONFIG_KEY_CIT_MEMO_SCADENZA_PT_ATTIVO)) {
				insertWrkLogMemoPtu("CIT_MEMO_SCADENZA_PT_ATTIVO non attivato", "");
			} else {
				inviaSvegliaResponsabiliImpiantiPT();
				insertWrkLogMemoPtu("Procedura CIT_MEMO_SCADENZA_PT_ATTIVO conclusa", "");
			}

		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			throw new BatchException("Esecuzione del batch fallita", e);
		}

		log.debug("[TimerServiceMemoBatch::execute] END");
	}

	/**
	 * Restituisce il gestore dei servizi
	 *
	 * @return Gestore dei servizi common
	 */

	public SigitbatchMgr getSigitbatchMgr() {
		return sigitbatchMgr;
	}

	/**
	 * Imposta il gestore dei servizi
	 *
	 * @param commonSigitMgr Gestore dei servizi common
	 */

	public void setSigitbatchMgr(SigitbatchMgr sigitbatchMgr) {
		this.sigitbatchMgr = sigitbatchMgr;
	}

	public NotifyMgr getNotifyMgr() {
		return notifyMgr;
	}

	public void setNotifyMgr(NotifyMgr notifyMgr) {
		this.notifyMgr = notifyMgr;
	}

	/*
	private void testaInvioMail(SigitTImportDto sigitTImportDto)
	{
		try {
			getSigitbatchMgr().gestisciInvioMailImportOK(sigitTImportDto, null, null);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	*/

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getMailObject(BatchConf conf) throws BatchException {
		return conf.getOggettoMail();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getMailBody(BatchConf conf) throws BatchException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Inserisce sulla tabella SIGIT_WRK_LOG_MEMO un log
	 *
	 * @param description
	 * @return LogMemo
	 * @throws DbManagerException
	 */
	private SigitWrkLogMemoPk insertWrkLogMemo(String description) throws DbManagerException {
		SigitWrkLogMemoDto wrkLogMemo = new SigitWrkLogMemoDto();
		wrkLogMemo.setDtLogMemo(ConvertUtil.convertDateToTimestamp(new Date()));
		wrkLogMemo.setDescLogMemo(description);
		return getSigitbatchMgr().getDbMgr().insertWrkLogMemo(wrkLogMemo);
	}

	private SigitWrkLogMemoTuPk insertWrkLogMemoPtu(String note, String description) throws DbManagerException {
		SigitWrkLogMemoTuDto wrkLogMemo = new SigitWrkLogMemoTuDto();
		wrkLogMemo.setDtLogMemoPtu(ConvertUtil.convertDateToTimestamp(new Date()));
		wrkLogMemo.setNoteLogMemoPtu(note);
		wrkLogMemo.setMessaggioLogMemoPtu(description);
		return getSigitbatchMgr().getDbMgr().insertWrkLogMemoTU(wrkLogMemo);
	}

	private SigitWrkLogMemoPk insertWrkLogMemo(Exception e) throws DbManagerException {
		String errorMessage = GenericUtil.getStackTrace(e);
		log.error(errorMessage);
		e.printStackTrace();
		if (errorMessage.length() > 1000) {
			errorMessage = errorMessage.substring(0, 999);
		}
		return insertWrkLogMemo(errorMessage);
	}

	private SigitWrkLogMemoTuPk insertWrkLogMemoPtu(Exception e) throws DbManagerException {
		String errorMessage = GenericUtil.getStackTrace(e);
		log.error(errorMessage);
		e.printStackTrace();
		if (errorMessage.length() > 1000) {
			errorMessage = errorMessage.substring(0, 999);
		}
		return insertWrkLogMemoPtu("", errorMessage);
	}

	private void insertWrkLogMemo(List<String> errors) throws DbManagerException {
		for (String error : errors) {
			insertWrkLogMemo(error);
		}
	}

	/**
	 * Invia sveglie agli utenti attivi
	 *
	 * @throws DbManagerException
	 */
	private void inviaSveglieUtentiAttivi() throws DbManagerException {
		SigitbatchMgr sigitBatchMgr = getSigitbatchMgr();
		ServiziMgr serviziMgr = sigitBatchMgr.getServiziMgr();
		DbMgr dbMgr = sigitBatchMgr.getDbMgr();

		try {
			List<SigitRPfRuoloPaDto> idUtentiPaAttivi = dbMgr.findIdUtentiPAAttivi();
			for (SigitRPfRuoloPaDto idUtente : idUtentiPaAttivi) {
				SigitTPersonaFisicaDto personaFisica = dbMgr.cercaTPersonaFisicaById(ConvertUtil.convertToInteger(idUtente.getIdPersonaFisica()));

				try {
					String codiceFiscale = personaFisica.getCodiceFiscale();
					List<SigitTVerificaDto> sveglieVerifiche = dbMgr.findVerificheByCodiceFiscale(codiceFiscale);
					List<SigitTAccertamentoDto> sveglieAccertamento = dbMgr.findAccertamentiByCodiceFiscale(codiceFiscale);
					List<SigitTIspezione2018ByCodiceFiscaleDto> sveglieIspezione2018 = dbMgr.findIspezioni2018ByCodiceFiscale(codiceFiscale);
					List<SigitTSanzioneDto> sveglieSanzioni = dbMgr.findSanzioniByCodiceFiscale(codiceFiscale);
					if (!sveglieVerifiche.isEmpty() || !sveglieAccertamento.isEmpty() || !sveglieIspezione2018.isEmpty() || !sveglieSanzioni.isEmpty()) {
						if (!sigitBatchMgr.invioSvegliaUtenteAttivo(personaFisica.getEmail(), codiceFiscale, sveglieVerifiche, sveglieAccertamento, sveglieIspezione2018, sveglieSanzioni)) {
							throw new Exception("Sveglia di utente " + codiceFiscale + " non inviata.");
						}
					}
				} catch (Exception e) {
					insertWrkLogMemo(e);
				}
			}
		} catch (Exception e) {
			insertWrkLogMemo(e);
		}
	}

	/**
	 * Invia sveglie agli utenti non attivi
	 *
	 * @throws DbManagerException
	 */
	private void inviaSveglieUtentiNonAttivi() throws DbManagerException {
		SigitbatchMgr sigitBatchMgr = getSigitbatchMgr();
		ServiziMgr serviziMgr = sigitBatchMgr.getServiziMgr();
		DbMgr dbMgr = sigitBatchMgr.getDbMgr();

		try {
			List<SigitTVerificaByUtentiNonAttiviDto> sveglieVerifiche = dbMgr.findVerificheByUtentiNonAttivi();
			if (!sveglieVerifiche.isEmpty()) {
				List<String> errors = sigitBatchMgr.invioSveglieUtentiNonAttivi("CIT: MEMO Sveglie VERIFICHE utenti non più attivi", "VERIFICA", sveglieVerifiche);
				insertWrkLogMemo(errors);
			}
		} catch (Exception e) {
			insertWrkLogMemo(e);
		}

		try {
			List<SigitTAccertamentoByUtentiNonAttiviDto> sveglieAccertamento = dbMgr.findAccertamentiByUtentiNonAttivi();
			if (!sveglieAccertamento.isEmpty()) {
				List<String> errors = sigitBatchMgr.invioSveglieUtentiNonAttivi("CIT: MEMO Sveglie ACCERTAMENTI utenti non più attivi", "ACCERTAMENTO", sveglieAccertamento);
				insertWrkLogMemo(errors);
			}
		} catch (Exception e) {
			insertWrkLogMemo(e);
		}

		try {
			List<SigitTIspezione2018ByUtentiNonAttiviDto> sveglieIspezione2018 = dbMgr.findIspezioni2018ByUtentiNonAttivi();
			if (!sveglieIspezione2018.isEmpty()) {
				List<String> errors = sigitBatchMgr.invioSveglieUtentiNonAttivi("CIT: MEMO Sveglie ISPEZIONI utenti non più attivi", "ISPEZIONE", sveglieIspezione2018);
				insertWrkLogMemo(errors);
			}
		} catch (Exception e) {
			insertWrkLogMemo(e);
		}

		try {
			List<SigitTSanzioneAccertamentiByUtentiNonAttiviDto> sveglieSanzioniAccertamenti = dbMgr.findSanzioniAccertamentiByUtentiNonAttivi();
			if (!sveglieSanzioniAccertamenti.isEmpty()) {
				List<String> errors = sigitBatchMgr.invioSveglieUtentiNonAttivi("CIT: MEMO Sveglie SANZIONI (ACCERTAMENTI) di utenti non più attivi", "SANZIONE", sveglieSanzioniAccertamenti);
				insertWrkLogMemo(errors);
			}
		} catch (Exception e) {
			insertWrkLogMemo(e);
		}

		try {
			List<SigitTSanzioneIspezione2018ByUtentiNonAttiviDto> sveglieSanzioniIspezioni2018 = dbMgr.findSanzioniIspezione2018ByUtentiNonAttivi();
			if (!sveglieSanzioniIspezioni2018.isEmpty()) {
				List<String> errors = sigitBatchMgr.invioSveglieUtentiNonAttivi("CIT: MEMO Sveglie SANZIONI (ISPEZIONI) di utenti non più attivi", "SANZIONE", sveglieSanzioniIspezioni2018);
				insertWrkLogMemo(errors);
			}
		} catch (Exception e) {
			insertWrkLogMemo(e);
		}
	}

	/**
	 * Invia sveglie ai responsabili di impianti
	 *
	 * @throws DbManagerException
	 */
	private void inviaSvegliaResponsabiliImpianti() throws DbManagerException {
		SigitbatchMgr sigitBatchMgr = getSigitbatchMgr();
		ServiziMgr serviziMgr = sigitBatchMgr.getServiziMgr();
		DbMgr dbMgr = sigitBatchMgr.getDbMgr();
		try {
			List<SigitVRicercaAllegatiDto> impiantiConInterventiDaNotificare = dbMgr.findAllegatiInviatiByDaysInterval(30);

			for (SigitVRicercaAllegatiDto impianto : impiantiConInterventiDaNotificare) {
				BigDecimal codImpianto = impianto.getCodiceImpianto();
				InputAllegatiComp allegatiComp = new InputAllegatiComp();
				allegatiComp.setCodiceImpianto(ConvertUtil.convertToInteger(codImpianto));
				allegatiComp.setIdAllegato(ConvertUtil.convertToInteger(impianto.getIdAllegato()));

				String elencoCompAttivi = sigitBatchMgr.getElencoCompAttivi(allegatiComp, ConvertUtil.convertToString(impianto.getFkTipoDocumento()));

				if (StringUtils.isNotEmpty(elencoCompAttivi)) {
					try {
						List<SigitRImpRuoloPfpgDto> responsabili = dbMgr.findResponsabileImpiantoAttivoByCodImpianto(ConvertUtil.convertToInteger(codImpianto));
						List<SigitVRicerca3ResponsabileDto> responsabiliTerzi = dbMgr.findResponsabile3AttivoByCodImpianto(ConvertUtil.convertToInteger(codImpianto));
						List<String> emailsSveglia = new ArrayList<String>();
						for (SigitRImpRuoloPfpgDto responsabile : responsabili) {
							String email = null;
							BigDecimal responsabileFkPersonaFisica = responsabile.getFkPersonaFisica();
							BigDecimal responsabileFkPersonaGiuridica = responsabile.getFkPersonaGiuridica();

							if (responsabileFkPersonaFisica != null) {
								SigitTPersonaFisicaDto personaFisica = dbMgr.cercaTPersonaFisicaById(ConvertUtil.convertToInteger(responsabileFkPersonaFisica));
								email = personaFisica.getEmail();
							} else if (responsabileFkPersonaGiuridica != null) {
								SigitTPersonaGiuridicaDto personaGiuridica = dbMgr.cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(responsabileFkPersonaGiuridica));
								email = personaGiuridica.getEmail();
							}

							emailsSveglia.add(email);
						}

						for (SigitVRicerca3ResponsabileDto responsabileTerzo : responsabiliTerzi) {
							SigitTPersonaGiuridicaDto personaGiuridica = dbMgr.cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(responsabileTerzo.getFkPg3Resp()));
							emailsSveglia.add(personaGiuridica.getEmail());
						}

						List<String> errors = sigitBatchMgr.invioSvegliaInterventiImpianto(emailsSveglia, impianto, elencoCompAttivi);
						insertWrkLogMemo(errors);
					} catch (Exception e) {
						insertWrkLogMemo(e);
					}
				} else {
					SigitTAllegatoDto sigitTAllegatoDto = dbMgr.cercaAllegatoById(impianto.getIdAllegato());
					sigitTAllegatoDto.setDtInvioMemo(ConvertUtil.convertDateToTimestamp(new Date()));
					dbMgr.getSigitTAllegatoDao().update(sigitTAllegatoDto);
				}
			}

		} catch (Exception e) {
			insertWrkLogMemo(e);
		}
	}

	private void inviaSvegliaResponsabiliImpiantiPT() throws DbManagerException {
		SigitbatchMgr sigitBatchMgr = getSigitbatchMgr();
		DbMgr dbMgr = sigitBatchMgr.getDbMgr();
		Integer limitCount = dbMgr.cercaConfigValueNumerico(Constants.CIT_MEMO_SCADENZA_PT_LIMITE);
		Integer limit = limitCount;
		try {
			SigitWrkLogMemoTuPk log1 = insertWrkLogMemoPtu("Componenti con manutentore una Persona Giuridica o indirizzo mail non valido", "");
			List<SigitVRicercaAllegatiDto> impiantiConInterventiDaNotificare = dbMgr.findAllegatiInviatiByDaysIntervalPTU(30);
			List<JSONObject> listaNotificheDaAggiungere = new ArrayList<JSONObject>();
			SigitWrkLogMemoTuPk log2 = null;
			UUID uniqueUUID = null;
			log2 = insertWrkLogMemoPtu("Avvio procedura", "");
			uniqueUUID = UUID.randomUUID();
			for (SigitVRicercaAllegatiDto impianto : impiantiConInterventiDaNotificare) {
				if (limit > 0) {
					BigDecimal codImpianto = impianto.getCodiceImpianto();
					InputAllegatiComp allegatiComp = new InputAllegatiComp();
					allegatiComp.setCodiceImpianto(ConvertUtil.convertToInteger(codImpianto));
					allegatiComp.setIdAllegato(ConvertUtil.convertToInteger(impianto.getIdAllegato()));
					String elencoCompAttivi = sigitBatchMgr.getElencoCompAttivi(allegatiComp, ConvertUtil.convertToString(impianto.getFkTipoDocumento()));
					SigitTAllegatoDto allegatoDto = dbMgr.cercaAllegatoById(impianto.getIdAllegato());
					BigDecimal idLogPtu = log1.getIdLogMemoPtu();
					if (StringUtils.isNotEmpty(elencoCompAttivi)) {
						try {
							List<SigitRImpRuoloPfpgDto> responsabili = dbMgr.findResponsabileImpiantoAttivoByCodImpianto(ConvertUtil.convertToInteger(codImpianto));
							if (responsabili != null && responsabili.size() > 0) {
								SigitRImpRuoloPfpgDto responsabile = responsabili.get(0);
								BigDecimal responsabileFkPersonaFisica = responsabile.getFkPersonaFisica();
								if (responsabileFkPersonaFisica != null) {
									SigitTPersonaFisicaDto personaFisica = dbMgr.cercaTPersonaFisicaById(ConvertUtil.convertToInteger(responsabileFkPersonaFisica));
									idLogPtu = log2.getIdLogMemoPtu();
									listaNotificheDaAggiungere.add(creaOggettoNotifica(impianto, allegatoDto, uniqueUUID, personaFisica).toJsonObject());
									limit--;
								}
							}
							if (allegatoDto != null) {
								allegatoDto.setIdLogMemoPtu(idLogPtu);
								dbMgr.getSigitTAllegatoDao().update(allegatoDto);
							}
						} catch (Exception e) {
							insertWrkLogMemoPtu(e);
						}
					}
				} else {
					SigitWrkLogMemoTuDto log2dto = dbMgr.getSigitWrkLogMemoTuDao().findByPrimaryKey(log2);
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("array", listaNotificheDaAggiungere);
					JSONArray jArray = jsonObject.getJSONArray("array");
					log2dto.setMessaggioLogMemoPtu(jArray.toString());
					dbMgr.getSigitWrkLogMemoTuDao().update(log2dto);
					String esito = notifyMgr.sendMessages(jArray.toString());
					log2dto.setEsitoLogMemoPtu(esito);
					dbMgr.getSigitWrkLogMemoTuDao().update(log2dto);
					limit = limitCount;
					listaNotificheDaAggiungere.clear();
					log2 = insertWrkLogMemoPtu("Avvio procedura", "");
					uniqueUUID = UUID.randomUUID();
				}
			}
			if (listaNotificheDaAggiungere.size() > 0) {
				SigitWrkLogMemoTuDto log2dto = dbMgr.getSigitWrkLogMemoTuDao().findByPrimaryKey(log2);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("array", listaNotificheDaAggiungere);
				JSONArray jArray = jsonObject.getJSONArray("array");
				log2dto.setMessaggioLogMemoPtu(jArray.toString());
				dbMgr.getSigitWrkLogMemoTuDao().update(log2dto);
				String esito = notifyMgr.sendMessages(jArray.toString());
				log2dto.setEsitoLogMemoPtu(esito);
				dbMgr.getSigitWrkLogMemoTuDao().update(log2dto);
			}
		} catch (Exception e) {
			insertWrkLogMemoPtu(e);
		}

	}

	private MessageBrokerModel creaOggettoNotifica(SigitVRicercaAllegatiDto impianto, SigitTAllegatoDto allegatoDto, UUID uniqueUUID, SigitTPersonaFisicaDto personaFisicaDto) {
		MessageBrokerModel messageBrokerModel = new MessageBrokerModel();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ITALY);
		Date expireAt = DateUtils.addDays(allegatoDto.getFInterventoEntro(), 30);
		messageBrokerModel.setUuid(UUID.randomUUID().toString());
		messageBrokerModel.setExpireAt(format.format(expireAt));
		MessageBrokerPayload payload = new MessageBrokerPayload();
		payload.setId(messageBrokerModel.getUuid());
		payload.setBulkId(uniqueUUID.toString());
		payload.setUserId(personaFisicaDto.getCodiceFiscale());
		payload.setTag(Constants.TAG_NOTIFY_ENERGIA);

		MessageBrokerEmail email = new MessageBrokerEmail();
		email.setSubject("Catasto Impianti Termici: Scadenza intervento di manutenzione sull'impianto " + impianto.getCodiceImpianto());
		StringBuffer testoHtml = new StringBuffer();
		testoHtml.append("Con la presente si informa che per l'impianto ");
		testoHtml.append(ConvertUtil.convertToString(impianto.getCodiceImpianto()));
		testoHtml.append("<BR>Ubicato in ");
		testoHtml.append(impianto.getIndirizzoUnitaImmob());
		testoHtml.append(", ");
		testoHtml.append(impianto.getCivicoUnitaImmob());
		testoHtml.append(" ");
		testoHtml.append(impianto.getComuneImpianto());
		testoHtml.append(" ");
		testoHtml.append(impianto.getSiglaProvImpianto());
		testoHtml.append("<BR>in base a quanto dichiarato dal manutentore nel corso dell'ultimo controllo");
		testoHtml.append("<BR>data controllo: ");
		testoHtml.append(ConvertUtil.convertToString(impianto.getDataControllo()));
		testoHtml.append(" tipo controllo: ");
		testoHtml.append(impianto.getDesTipoManutenzione());
		testoHtml.append("<BR>si raccomanda un intervento per le apparecchiature ");
		testoHtml.append(impianto.getElencoApparecchiature());
		testoHtml.append("<BR>entro ");
		testoHtml.append(ConvertUtil.convertToString(impianto.getFInterventoEntro()));
		testoHtml.append("<BR><BR>Nel caso in cui l'intervento sulle apparecchiature sia gia' stato eseguito, "
				+ "si prega di non considerare questo messaggio. ");
		email.setBody(testoHtml.toString());
		email.setTemplate("energiapt-cit-template.html");

		MessageBrokerMex mex = new MessageBrokerMex();
		mex.setTitle("Catasto Impianti Termici: Scadenza intervento di manutenzione sull'impianto " + impianto.getCodiceImpianto());

		testoHtml = new StringBuffer();

		testoHtml.append("In base a quanto dichiarato dal tuo manutentore, il controllo di manutenzione o il rapporto di efficienza energetica eseguito sulle apparecchiature " + impianto.getElencoApparecchiature());
		testoHtml.append(" ");
		testoHtml.append("dell'impianto " + impianto.getCodiceImpianto() + " sito in via ");
		testoHtml.append(impianto.getIndirizzoUnitaImmob());
		testoHtml.append(", ");
		testoHtml.append(impianto.getCivicoUnitaImmob());
		testoHtml.append(" ");
		testoHtml.append(impianto.getComuneImpianto());
		testoHtml.append(", deve essere rinnovato.");
		testoHtml.append(" ");
		testoHtml.append("Nel caso in cui l'intervento sulle apparecchiature sia gia' stato eseguito, ");
		testoHtml.append("si prega di non considerare questo messaggio. ");
		mex.setBody(testoHtml.toString());
		mex.setCallToAction(getProperties().getProperty(Constants.CITPWA_URL));
		payload.setEmail(email);
		payload.setMex(mex);
		messageBrokerModel.setPayload(payload);
		return messageBrokerModel;
	}

	protected Properties getProperties() {
		InputStream is = getClass().getResourceAsStream(PROPERTIES_RESOURCE);
		if (is != null) {
			try {
				Properties properties = new Properties();
				properties.load(is);

				return properties;
			} catch (Exception e) {
				throw new IllegalArgumentException("errore nella parsificazione della configurazione delle PROPERTIES");
			}
		}
		throw new IllegalArgumentException("configurazione delle PROPERTIES non trovata");
	}
}
