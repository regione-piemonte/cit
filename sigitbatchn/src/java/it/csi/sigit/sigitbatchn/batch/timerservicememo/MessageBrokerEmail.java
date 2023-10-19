package it.csi.sigit.sigitbatchn.batch.timerservicememo;

import org.json.JSONException;
import org.json.JSONObject;

public class MessageBrokerEmail {
	private String subject;
	private String body;

	private String template;

	public MessageBrokerEmail() {
	}

	public MessageBrokerEmail(String subject, String body) {
		this.subject = subject;
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	@Override
	public String toString() {
		return "MessageBrokerEmail{" + "subject='" + subject + '\'' + ", body='" + body + '\'' + ", template='" + template + '\'' + '}';
	}

	public JSONObject toJsonObject() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("subject", subject);
		jsonObject.put("body", body);
		jsonObject.put("template_id",template);
		return jsonObject;
	}
}
