package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTIspezione2018DaoException;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.dto.BaseSessionAwareDTO;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.BaseAction;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.CommandExecutionException;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ICommand;
import it.csi.sigit.sigitwebn.util.*;

public class ShowPdfLetteraAvviso extends BaseAction<BaseSessionAwareDTO> {

	private BaseSessionAwareDTO model;
	private String contentDisposition;
	private String contentType;
	private InputStream inputStream;
	private DbMgr dbMgr;
	private ServiziMgr serviziMgr;

	@Override
	public String execute() throws DbManagerException, SigitTIspezione2018DaoException {
		LOG.debug("Creazione avviso arpa");
		String contentType = "application/download";
		String contentDisp = "attachment;filename=letteraAvviso.docx";
		Integer idIspezioneCorrente = 0;
		try {
			idIspezioneCorrente = (Integer) session.get("appDataidIspezioneSelezionato");
			UtenteLoggato utente = (UtenteLoggato)session.get(Constants.SESSIONE_VAR_UTENTE_LOGGATO);
			it.csi.sigit.sigitext.dto.sigitext.Documento letteraAvvisoTempFile = getServiziMgr().downloadLetteraAvviso(idIspezioneCorrente, utente.getCodiceFiscale(), ConvertUtil.convertToString(utente.getRuolo().getIdPersonaGiuridica()));		
			File file = new File("letteraAvviso");
			FileUtils.writeByteArrayToFile(new File("letteraAvviso"), letteraAvvisoTempFile.getDoc());
			
			setContentDisposition(contentDisp);
			setContentType(contentType);
			setInputStream(new FileInputStream(file));
			LOG.debug("Finisco lettera");
			return "downloadFile";
		} catch (IOException e) {
			LOG.error("Errore creazione lettera avviso ispezione #:" + idIspezioneCorrente, e);
		} catch (Exception e) {
			LOG.error("Errore creazione lettera avviso ispezione: ", e);
		}

		return "KO";
	}
	
	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}
	
	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	private static String aggiungiSpazi(String inputString, int lunghezzaRigaWord) {
		if (inputString == null) {
			StringBuilder sb = new StringBuilder("");
			for (int i = 0; i < lunghezzaRigaWord; i++) {
				sb.append(" ");
			}
			sb.append("\t\t\t\t\t\t");
			return sb.toString();
		}

		if (inputString.length() >= lunghezzaRigaWord) {
			return inputString;
		} else {
			StringBuilder sb = new StringBuilder(inputString);
			int spaziDaAggiungere = lunghezzaRigaWord - inputString.length();
			for (int i = 0; i < spaziDaAggiungere; i++) {
				sb.append(" ");
			}
			sb.append("\t\t\t\t\t\t");
			return sb.toString();
		}
	}

	private XWPFRun addText(String text, XWPFParagraph p) {
		for (XWPFRun run : p.getRuns()) {
			// Setto i run esistenti a vuoto perchè non è possibile eliminarne il testo
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
