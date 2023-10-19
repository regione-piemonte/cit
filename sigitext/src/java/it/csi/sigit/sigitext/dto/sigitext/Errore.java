package it.csi.sigit.sigitext.dto.sigitext;

import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

public class Errore {
	private String status;
	private String code;
	private String title;
	private List<String> links;

	public Errore(String status, String code, String title, List<String> links) {
		this.status = status;
		this.code = code;
		this.title = title;
		this.links = links;
	}

	public Errore(String status, String code, String title) {
		this.status = status;
		this.code = code;
		this.title = title;
	}

	public Errore(int status, String code, String title) {
		this.status = String.valueOf(status);
		this.code = code;
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}
}
