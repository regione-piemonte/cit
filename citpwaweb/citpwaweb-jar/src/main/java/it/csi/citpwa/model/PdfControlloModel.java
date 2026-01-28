package it.csi.citpwa.model;

import it.csi.citpwa.model.sigitext.PdfControllo;
import it.csi.citpwa.util.ObjectConverter;
import org.apache.commons.codec.binary.Base64;

public class PdfControlloModel {

	public static ObjectConverter<PdfControllo,PdfControlloModel> dtoToModel = new ObjectConverter<>(u->{
		PdfControlloModel pdfControlloModel = new PdfControlloModel();
		pdfControlloModel.setName(u.getName());
		pdfControlloModel.setMimeType(u.getMimeType());
		String file = Base64.encodeBase64String(u.getFile());
		pdfControlloModel.setFile(file);
		return pdfControlloModel;
	});
	private String file;
	private String name;
	private String mimeType;

	public void setFile(String file) {
		this.file = file;
	}

	public String getFile() {
		return file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public PdfControlloModel(String file, String name, String mimeType) {
		this.file = file;
		this.name = name;
		this.mimeType = mimeType;
	}

	public PdfControlloModel() {
	}

	@Override
	public String toString() {
		return "PdfControllo{" + "file=" + file + ", name='" + name + '\'' + ", mimeType='" + mimeType + '\'' + '}';
	}
}
