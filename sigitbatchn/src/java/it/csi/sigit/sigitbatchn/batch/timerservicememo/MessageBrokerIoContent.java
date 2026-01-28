package it.csi.sigit.sigitbatchn.batch.timerservicememo;

import org.json.JSONException;
import org.json.JSONObject;

public class MessageBrokerIoContent {
	
	private String subject;
	private String markdown;
	private String due_date;
	
	public MessageBrokerIoContent() {

	}

	public MessageBrokerIoContent(String subject, String markdown, String due_date) {
		super();
		this.subject = subject;
		this.markdown = markdown;
		this.due_date = due_date;
	}

	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getMarkdown() {
		return markdown;
	}


	public void setMarkdown(String markdown) {
		this.markdown = markdown;
	}


	public String getDue_date() {
		return due_date;
	}


	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	@Override
	public String toString() {
		return "MessageBrokerIoContent [subject=" + subject + ", markdown=" + markdown + ", due_date=" + due_date + "]";
	}

	public JSONObject toJsonObject() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("subject", subject);
		jsonObject.put("markdown", markdown);
		jsonObject.put("due_date", due_date);
		return jsonObject;
	}
}
