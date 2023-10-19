package it.csi.sigit.sigitbatchn.batch.timerservicememo;

import org.json.JSONException;
import org.json.JSONObject;

public class MessageBrokerMex {
	private String title;
	private String body;
	private String callToAction;

	public MessageBrokerMex() {
	}

	public MessageBrokerMex(String title, String body, String callToAction) {
		this.title = title;
		this.body = body;
		this.callToAction = callToAction;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCallToAction() {
		return callToAction;
	}

	public void setCallToAction(String callToAction) {
		this.callToAction = callToAction;
	}

	@Override
	public String toString() {
		return "MessageBrokerMex{" + "title='" + title + '\'' + ", body='" + body + '\'' + ", callToAction='" + callToAction + '\'' + '}';
	}

	public JSONObject toJsonObject() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("title", title);
		jsonObject.put("body", body);
		jsonObject.put("call_to_action", callToAction);
		return jsonObject;
	}
}
