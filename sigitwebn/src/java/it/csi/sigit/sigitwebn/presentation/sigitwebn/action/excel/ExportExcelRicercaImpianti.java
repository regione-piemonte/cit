package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.excel;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTIspezione2018DaoException;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.dto.BaseSessionAwareDTO;
import it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicImpianto;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.BaseAction;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.CommandExecutionException;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ICommand;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ExportExcelRicercaImpianti extends BaseAction<BaseSessionAwareDTO> {

	private BaseSessionAwareDTO model;
	private String contentDisposition;
	private String contentType;
	private InputStream inputStream;
	private DbMgr dbMgr;
	private SigitMgr sigitMgr;

	@Override
	public String execute() throws DbManagerException, SigitTIspezione2018DaoException {
		String contentType = "application/download";
		String contentDisp = "attachment;filename=export.xlsx";
		try {
			ArrayList<RisultatoRicImpianto> ris= (ArrayList<RisultatoRicImpianto>) session.get("appDatarisultatoRicercaImpianti");
			LOG.debug("RIS: "+ ris);
			File exportTemplateTempFile = File.createTempFile("export_ricerca_impianti", ".xlsx");
			FileUtils.copyInputStreamToFile(ServletActionContext.getServletContext().getResourceAsStream("/xlsx/export_template.xlsx"), exportTemplateTempFile);
			FileInputStream inputStream = new FileInputStream(exportTemplateTempFile);

			String[] headers = {"codice impianto","comune","indirizzo","responsabile","stato"};
			String[] fields = {"codiceImpianto","descComune","indirizzo","denomResponsabile","statoImpianto"};
			sigitMgr.createExportXls(inputStream,fields,headers,ris,exportTemplateTempFile);
			setContentDisposition(contentDisp);
			setContentType(contentType);
			setInputStream(new FileInputStream(exportTemplateTempFile));
			return "downloadFile";
		} catch (IOException e) {
			LOG.error("Errore export excel:", e);
		} catch (Exception e) {
			LOG.error("Errore export excel: ", e);
		}

		return "KO";
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

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
