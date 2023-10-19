package it.csi.citpwa.model.sigitext;

import java.util.Arrays;

public class PdfControllo {
	private byte[] file;
	private String name;
	private String mimeType;

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
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

	public PdfControllo(byte[] file, String name, String mimeType) {
		this.file = file;
		this.name = name;
		this.mimeType = mimeType;
	}

	public PdfControllo() {
	}

	@Override
	public String toString() {
		return "PdfControllo{" + "file=" + Arrays.toString(file) + ", name='" + name + '\'' + ", mimeType='" + mimeType + '\'' + '}';
	}
}
