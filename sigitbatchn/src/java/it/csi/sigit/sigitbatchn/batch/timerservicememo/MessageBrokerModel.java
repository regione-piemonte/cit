package it.csi.sigit.sigitbatchn.batch.timerservicememo;

import org.json.JSONObject;

public class MessageBrokerModel {
	private String uuid;
	private String expireAt;
	private MessageBrokerPayload payload;

	public MessageBrokerModel(String uuid, String expireAt, MessageBrokerPayload payload) {
		this.uuid = uuid;
		this.expireAt = expireAt;
		this.payload = payload;
	}

	public MessageBrokerModel() {
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(String expireAt) {
		this.expireAt = expireAt;
	}

	public MessageBrokerPayload getPayload() {
		return payload;
	}

	public void setPayload(MessageBrokerPayload payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "MessageBrokerModel{" + "uuid='" + uuid + '\'' + ", expireAt='" + expireAt + '\'' + ", payload=" + payload + '}';
	}

	public JSONObject toJsonObject() {
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("uuid", uuid);
			jsonObject.put("expire_at", expireAt);
			jsonObject.put("payload", payload.toJsonObject());
			return jsonObject;
		} catch (Exception e) {
			return new JSONObject();
		}
	}
}
