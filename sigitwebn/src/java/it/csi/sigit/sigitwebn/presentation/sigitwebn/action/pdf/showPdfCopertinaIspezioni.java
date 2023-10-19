package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.pdf;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTIspezione2018DaoException;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.dto.BaseSessionAwareDTO;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaFisica;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.BaseAction;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.CommandExecutionException;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ICommand;
import it.csi.sigit.sigitwebn.util.Constants;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class showPdfCopertinaIspezioni extends BaseAction<BaseSessionAwareDTO> {

	private BaseSessionAwareDTO model;
	private String contentDisposition;
	private String contentType;
	private InputStream inputStream;
	private final String COPERTINA_PATH = "C:/Repo/CSI/sigit/sigit_sigitwebn/src/web/sigitwebn/docx/";
	private DbMgr dbMgr;

	@Override
	public String execute() throws DbManagerException, SigitTIspezione2018DaoException {
		LOG.info("Creazione copertina ispezione");
		String contentType = "application/download";
		String contentDisp = "attachment;filename=copertinaIspezione.docx";
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Integer idIspezioneCorrente = 0;
		try {
			idIspezioneCorrente = (Integer) session.get("appDataidIspezioneSelezionato");
			SigitTIspezione2018Dto ispezioneCorrente = getDbMgr().getSigitTIspezione2018Dao().findByPrimaryKey(new SigitTIspezione2018Pk(idIspezioneCorrente));
			XWPFDocument doc;
			if (ispezioneCorrente != null) {
				SigitRIspezIspetDto rIspezIspetDto = getDbMgr().cercaUltimoRIspezIspetByIdIspezione(ispezioneCorrente.getIdIspezione2018().toString());
				PersonaFisica personaFisica = null;
				if(rIspezIspetDto!=null && rIspezIspetDto.getFkPersonaFisica()!=null)
					personaFisica = getDbMgr().cercaPersonaFisicaById(rIspezIspetDto.getFkPersonaFisica().intValue());
				SigitVRicercaImpiantiDto ricercaImpianto = getDbMgr().cercaImpiantoByCodImpianto(ispezioneCorrente.getCodiceImpianto());
				File copertinaTempFile = File.createTempFile("copertina-ispezione.docx", ".docx");
				FileUtils.copyInputStreamToFile(ServletActionContext.getServletContext().getResourceAsStream("/docx/copertinaIspezione.docx"), copertinaTempFile);
				try (InputStream in = new FileInputStream(copertinaTempFile)) {
					doc = new XWPFDocument(in);
					for (XWPFTable tbl : doc.getTables()) {
						for (XWPFTableRow row : tbl.getRows()) {
							for (XWPFTableCell cell : row.getTableCells()) {
								for (XWPFParagraph p : cell.getParagraphs()) {
									XWPFRun run = null;
									String text = p.getText();
										if (text != null) {
											text = text.trim();
											LOG.info(text);
											switch (text) {
												case Constants.COPERTINA_PLACEHOLDER_COMUNE:
													LOG.info("case comune");
													text = ricercaImpianto.getDenominazioneComune();
													addText(text,p);
													break;
												case Constants.COPERTINA_PLACEHOLDER_APERTA_AL:
													LOG.info("case aperto al");
													text = ispezioneCorrente.getDtCreazione() != null ? formatter.format(ispezioneCorrente.getDtCreazione()):"";
													run = addText(text,p);
													run.setFontSize(12);
													run.setBold(true);
													break;
												case Constants.COPERTINA_PLACEHOLDER_CHIUSA_AL:
													LOG.info("case chiuso al");
													text = ispezioneCorrente.getDtConclusione() != null ? formatter.format(ispezioneCorrente.getDtConclusione()) : "";
													run = addText(text,p);
													run.setFontSize(12);
													run.setBold(true);
													break;
												case Constants.COPERTINA_PLACEHOLDER_DESCRIZIONE:
													LOG.info("case descrizione");
													text = "Codice impianto: " + ispezioneCorrente.getCodiceImpianto() + "\n Ubicazione: " + ricercaImpianto.getIndirizzoUnitaImmob() + " "
																	+ ricercaImpianto.getCivico() + " " + ricercaImpianto.getDenominazioneComune() + " " + ricercaImpianto.getSiglaProvincia();
													addText(text,p);
													break;
												case Constants.COPERTINA_PLACEHOLDER_ASSEGNATARIO:
													LOG.info("case assegnatario");
													text = personaFisica!=null?text.replace(Constants.COPERTINA_PLACEHOLDER_ASSEGNATARIO,
															personaFisica.getNome() + " " + personaFisica.getCognome() + " " + personaFisica.getCodiceFiscale()):
															text.replace(Constants.COPERTINA_PLACEHOLDER_ASSEGNATARIO,"");
													addText(text,p);
													break;

												case Constants.COPERTINA_PLACEHOLDER_N_PRATICA:
													LOG.info("case n pratica");
													text = ispezioneCorrente.getCodiceImpianto() + "_" + ispezioneCorrente.getIdIspezione2018() + "_" + ricercaImpianto.getSiglaProvincia();
													run = addText(text,p);
													run.setFontSize(20);
													run.setBold(true);
													break;
											}
										}
									}

							}
						}
					}
				}

				try (FileOutputStream out = new FileOutputStream(copertinaTempFile)) {
					doc.write(out);
				}

				setContentDisposition(contentDisp);
				setContentType(contentType);
				setInputStream(new FileInputStream(copertinaTempFile));
				LOG.debug("Finisco compilazione copertina");
				return "downloadFile";
			}
		} catch (IOException e) {
			LOG.error("Errore creazione copertina ispezione #:" + idIspezioneCorrente, e);
		} catch (Exception e) {
			LOG.error("Errore creazione copertina ispezione: ", e);
		}

		return "KO";
	}

	private XWPFRun addText(String text,XWPFParagraph p){
		for(XWPFRun run: p.getRuns()){
			//Setto i run esistenti a vuoto perchè non è possibile eliminarne il testo
			run.setText("",0);
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
