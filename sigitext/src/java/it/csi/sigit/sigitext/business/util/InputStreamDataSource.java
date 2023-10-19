//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it.csi.sigit.sigitext.business.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataSource;

public class InputStreamDataSource implements DataSource {
	private InputStream is;
	private String contentType;
	private String name;

	public InputStreamDataSource(InputStream is, String contentType) {
		this.is = is;
		this.contentType = contentType;
	}

	public InputStreamDataSource(InputStream is, String contentType, String name) {
		this.is = is;
		this.contentType = contentType;
		this.name = name;
	}

	public String getContentType() {
		return this.contentType;
	}

	public InputStream getInputStream() throws IOException {
		return this.is;
	}

	public String getName() {
		return this.name;
	}

	public OutputStream getOutputStream() throws IOException {
		throw new UnsupportedOperationException();
	}
}
