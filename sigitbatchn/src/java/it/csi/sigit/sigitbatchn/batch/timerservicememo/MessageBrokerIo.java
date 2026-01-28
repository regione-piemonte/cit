package it.csi.sigit.sigitbatchn.batch.timerservicememo;

import org.json.JSONException;
import org.json.JSONObject;

public class MessageBrokerIo {
	
	private Integer time_to_live;
	private MessageBrokerIoContent content;

	public MessageBrokerIo() {

	}

	public MessageBrokerIo(Integer time_to_live, MessageBrokerIoContent content) {
		super();
		this.time_to_live = time_to_live;
		this.content = content;
	}

	public Integer getTime_to_live() {
		return time_to_live;
	}


	public void setTime_to_live(Integer time_to_live) {
		this.time_to_live = time_to_live;
	}


	public MessageBrokerIoContent getContent() {
		return content;
	}


	public void setContent(MessageBrokerIoContent content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "MessageBrokerIo [time_to_live=" + time_to_live + ", content=" + content + "]";
	}

	public JSONObject toJsonObject() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("time_to_live", time_to_live);
		jsonObject.put("content", content.toJsonObject());
		return jsonObject;
	}
}
