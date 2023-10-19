package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.pdf;

import it.csi.jsf.htmpl.samples.Persona;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTIspezione2018DaoException;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.dto.BaseSessionAwareDTO;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaFisica;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica;
import it.csi.sigit.sigitwebn.dto.back_office.Abilitazione;
import it.csi.sigit.sigitwebn.dto.impianto.Impianto;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.DettaglioTerzoResponsabile;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.BaseAction;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.CommandExecutionException;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ICommand;
import it.csi.sigit.sigitwebn.util.Constants;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class showPdfLetteraAvviso extends BaseAction<BaseSessionAwareDTO> {

	private BaseSessionAwareDTO model;
	private String contentDisposition;
	private String contentType;
	private InputStream inputStream;
	private DbMgr dbMgr;

	@Override
	public String execute() throws DbManagerException, SigitTIspezione2018DaoException {
		LOG.debug("Creazione avviso arpa");
		String contentType = "application/download";
		String contentDisp = "attachment;filename=letteraAvviso.docx";
		Integer idIspezioneCorrente = 0;
		ArrayList<String> listCodImpianti = new ArrayList<String>();
		PersonaFisica respPf = null;
		PersonaGiuridica respPg = null;
		PersonaGiuridica terzoResp = null;
		try {
			idIspezioneCorrente = (Integer) session.get("appDataidIspezioneSelezionato");
			SigitTIspezione2018Dto ispezioneCorrente = getDbMgr().getSigitTIspezione2018Dao().findByPrimaryKey(new SigitTIspezione2018Pk(idIspezioneCorrente));

			listCodImpianti.add(ispezioneCorrente.getCodiceImpianto().toString());
			List<SigitExtIspezioniConCodImpiantoDto> listIspezioniCodImpianto = getDbMgr().cercaIspezioniDettConCodImpianto(listCodImpianti);

			for(SigitExtIspezioniConCodImpiantoDto extIspezioniConCodImpiantoDto:listIspezioniCodImpianto){
				LOG.debug("################# "+extIspezioniConCodImpiantoDto);
				if(extIspezioniConCodImpiantoDto.getRuolo()!= null && extIspezioniConCodImpiantoDto.getRuolo().equals(Constants.RUOLO_RESPONSABILE)){
					respPf= dbMgr.cercaPersonaFisicaById(extIspezioniConCodImpiantoDto.getIdResponsabile().intValue());
				}

				if(extIspezioniConCodImpiantoDto.getRuolo()!= null && extIspezioniConCodImpiantoDto.getRuolo().equals("Terzo Responsabile")){
					terzoResp = dbMgr.cercaPersonaGiuridicaById(extIspezioniConCodImpiantoDto.getIdResponsabile().intValue());
				}

				if(extIspezioniConCodImpiantoDto.getRuolo()!= null && extIspezioniConCodImpiantoDto.getRuolo().equals(Constants.RUOLO_RESPONSABILE_IMPRESA)){
					respPg = dbMgr.cercaPersonaGiuridicaById(extIspezioniConCodImpiantoDto.getIdResponsabile().intValue());
				}
			}
			String mailPv = getDbMgr().cercaIndirizzoMailAbilitazioneValidatore(ispezioneCorrente.getIstatProvCompetenza(),Constants.ID_RUOLO_PA_VALIDATORE);
			SigitRPfRuoloPaDto dto = new SigitRPfRuoloPaDto();
			dto.setIdRuoloPa(Constants.ID_RUOLO_PA_VALIDATORE);
			String descProvincia = "";
			if(ispezioneCorrente.getIstatProvCompetenza()!=null) {
				dto.setIstatAbilitazione("01"+ispezioneCorrente.getIstatProvCompetenza());
				List<SigitRPfRuoloPaDto> ruoliPa = getDbMgr().getSigitRPfRuoloPaDao().findAllByIstatValidatore(dto);
				if(ruoliPa != null && !ruoliPa.isEmpty())
					descProvincia = ruoliPa.get(0).getDescAbilitazione();
			}

			SigitVRicercaImpiantiDto ricercaImpianto = getDbMgr().cercaImpiantoByCodImpianto(ispezioneCorrente.getCodiceImpianto());

//			compilazione documento
			XWPFDocument doc;
			File letteraAvvisoTempFile = File.createTempFile("lettera-avviso.docx", ".docx");
			FileUtils.copyInputStreamToFile(ServletActionContext.getServletContext().getResourceAsStream("/docx/Lettera_Avviso_modello.docx"), letteraAvvisoTempFile);
			try (InputStream in = new FileInputStream(letteraAvvisoTempFile)) {
				doc = new XWPFDocument(in);
				for (XWPFParagraph p : doc.getParagraphs()) {
					String text = p.getText();
					if (text != null && !text.isEmpty()) {
						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_ORA_ISPEZIONE)) {
							text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_ORA_ISPEZIONE, "________");
						}

						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_DATI_TERZO_RESP)) {
							text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_DATI_TERZO_RESP, terzoResp != null && terzoResp.getDenominazione() != null ?
									terzoResp.getDenominazione() : "________");
						}

						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_VIA_TERZO_RESP)) {
							if(terzoResp!=null){
								StringBuilder indirizzo= new StringBuilder();
								LOG.debug("terzo resp indirizzo: "+terzoResp.getIndirizzo());
								LOG.debug("terzo resp indirizzo non trovato: "+terzoResp.getIndirizzoNonTrovato());
								if (terzoResp.getIndirizzo() != null) {
									indirizzo.append(terzoResp.getIndirizzo());
								}else{
									indirizzo.append(terzoResp.getIndirizzoNonTrovato());
								}
								indirizzo.append("").append(terzoResp.getCivico()).append(", ")
										.append(terzoResp.getComune()).append(" ").append(terzoResp.getProvincia());
								text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_VIA_TERZO_RESP, indirizzo);
							}else
								text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_VIA_TERZO_RESP, "________");
						}

						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_CAP_TERZO_RESP)) {
							text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_CAP_TERZO_RESP, terzoResp != null &&  terzoResp.getCap()!=null ?
									terzoResp.getCap() : "________");
						}

						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_EMAIL_TERZO_RESP)) {
							text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_EMAIL_TERZO_RESP, terzoResp != null && terzoResp.getEmail()!=null ?
									terzoResp.getEmail() : "________");
						}

						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_DATI_RESP)) {
							if(respPf!=null) {
								text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_DATI_RESP, respPf.getDenominazione());
							}else if(respPg != null){
								text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_DATI_RESP, respPg.getDenominazione());
							}else{
								text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_DATI_RESP, "________");
							}
						}

						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_VIA_RESP)) {
							if(respPf!=null) {
								StringBuilder indirizzo= new StringBuilder();
								LOG.debug("resppf indirizzo: "+respPf.getIndirizzo());
								LOG.debug("resppf indirizzo non trovato: "+respPf.getIndirizzoNonTrovato());
								if (respPf.getIndirizzo() != null) {
									indirizzo.append(respPf.getIndirizzo());
								}else{
									indirizzo.append(respPf.getIndirizzoNonTrovato());
								}
								indirizzo.append("").append(respPf.getCivico()).append(", ")
										.append(respPf.getComune()).append(" ").append(respPf.getProvincia());
								text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_VIA_RESP,indirizzo);
							}else if(respPg != null){
								StringBuilder indirizzo= new StringBuilder();
								LOG.debug("resppg indirizzo: "+respPg.getIndirizzo());
								LOG.debug("resppg indirizzo non trovato: "+respPg.getIndirizzoNonTrovato());
								if (respPg.getIndirizzo() != null) {
									indirizzo.append(respPg.getIndirizzo());
								}else{
									indirizzo.append(respPg.getIndirizzoNonTrovato());
								}
								indirizzo.append("").append(respPg.getCivico()).append(", ")
										.append(respPg.getComune()).append(" ").append(respPg.getProvincia());
								text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_VIA_RESP,indirizzo);
							}else{
								text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_VIA_RESP, "________");
							}
						}
						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_CAP_RESP)) {
							if(respPf!=null) {
								text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_CAP_RESP, respPf.getCap() != null ? respPf.getCap() : "________");
							}else if(respPg != null){
								text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_CAP_RESP, respPg.getCap() != null ? respPg.getCap() : "________");
							}else{
								text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_CAP_RESP, "________");
							}
						}
						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_EMAIL_RESP)) {
							if(respPf!=null) {
								text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_EMAIL_RESP,respPf.getEmail()!=null ? respPf.getEmail() : "________");
							}else if(respPg != null){
								text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_EMAIL_RESP,respPg.getEmail()!=null ? respPg.getEmail() : "________");
							}else{
								text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_EMAIL_RESP, "________");
							}
						}

						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_DATA_ISPEZIONE)) {
							text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_DATA_ISPEZIONE, "________");
						}

						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_CODICE_IMPIANTO)) {
							text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_CODICE_IMPIANTO, ricercaImpianto!=null?ricercaImpianto.getCodiceImpianto().toString():"________");
						}

						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_ANNO_GAU)) {
							text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_ANNO_GAU,""+ispezioneCorrente.getCodiceImpianto() + "_" + ispezioneCorrente.getIdIspezione2018() + "_" + ricercaImpianto.getSiglaProvincia());
						}

						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_INDIRIZZO_IMPIANTO)) {
							text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_INDIRIZZO_IMPIANTO, ricercaImpianto!=null?ricercaImpianto.getIndirizzoUnitaImmob()+" "+ricercaImpianto.getCivico()+", "+ricercaImpianto.getDenominazioneComune()+" "+ricercaImpianto.getSiglaProvincia():"________");
						}

						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_DATI_PC)) {
							text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_DATI_PC, descProvincia!=null?descProvincia:"");
						}

						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_VIA_PC)) {
							text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_VIA_PC, "________");
						}

						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_CAP_PC)) {
							text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_CAP_PC, "________");
						}

						if (text.contains(Constants.LETTERA_AVVISO_PLACEHOLDER_EMAIL_PC)) {
							text = text.replace(Constants.LETTERA_AVVISO_PLACEHOLDER_EMAIL_PC,mailPv != null ? mailPv : "________");
						}

						if (text.toLowerCase(Locale.ROOT).contains("oggetto:")) {
							for(XWPFRun run:p.getRuns()){
								String runtext = run.getText(0);
								run.setBold(true);
								run.setText(runtext,0);
							}
						}

						addText(text, p);
					}
				}
			}

			try (FileOutputStream out = new FileOutputStream(letteraAvvisoTempFile)) {
				doc.write(out);
			}

			setContentDisposition(contentDisp);
			setContentType(contentType);
			setInputStream(new FileInputStream(letteraAvvisoTempFile));
			LOG.debug("Finisco lettera");
			return "downloadFile";
		} catch (IOException e) {
			LOG.error("Errore creazione lettera avviso ispezione #:" + idIspezioneCorrente, e);
		} catch (Exception e) {
			LOG.error("Errore creazione lettera avviso ispezione: ", e);
		}

		return "KO";
	}

	private XWPFRun addText(String text, XWPFParagraph p) {
		for (XWPFRun run : p.getRuns()) {
			//Setto i run esistenti a vuoto perchè non è possibile eliminarne il testo
			run.setText("", 0);
		}
		p.getRuns().get(0).setText(text);
		return p.getRuns().get(0);
	}

	@Override
	public Class modelClass() {
		return getClass();
	}

	@Override
	public BaseSessionAwareDTO getModel() {
		return this.model;
	}

	@Override
	public void setModel(BaseSessionAwareDTO baseSessionAwareDTO) {
		this.model = baseSessionAwareDTO;
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
	protected ICommand initCommand(String moduleName, String panelName, String widgName, String eventName) {
		return null;
	}

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {

	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
