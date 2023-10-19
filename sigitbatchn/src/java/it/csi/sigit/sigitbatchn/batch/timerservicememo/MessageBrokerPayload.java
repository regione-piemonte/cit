package it.csi.sigit.sigitbatchn.batch.timerservicememo;

import org.json.JSONException;
import org.json.JSONObject;

public class MessageBrokerPayload {
	private String id;
	private String bulkId;
	private String userId;
	private String tag;
	private Boolean trusted;
	private MessageBrokerEmail email;
	private MessageBrokerMex mex;

	public MessageBrokerPayload() {
	}

	public MessageBrokerPayload(String id, String bulkId, String userId, String tag, Boolean trusted, MessageBrokerEmail email, MessageBrokerMex mex) {
		this.id = id;
		this.bulkId = bulkId;
		this.userId = userId;
		this.tag = tag;
		this.trusted = trusted;
		this.email = email;
		this.mex = mex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBulkId() {
		return bulkId;
	}

	public void setBulkId(String bulkId) {
		this.bulkId = bulkId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Boolean getTrusted() {
		return trusted;
	}

	public void setTrusted(Boolean trusted) {
		this.trusted = trusted;
	}

	public MessageBrokerEmail getEmail() {
		return email;
	}

	public void setEmail(MessageBrokerEmail email) {
		this.email = email;
	}

	public MessageBrokerMex getMex() {
		return mex;
	}

	public void setMex(MessageBrokerMex mex) {
		this.mex = mex;
	}

	@Override
	public String toString() {
		return "MessageBrokerPayload{" + "id='" + id + '\'' + ", bulkId='" + bulkId + '\'' + ", userId='" + userId + '\'' + ", tag='" + tag + '\'' + ", trusted=" + trusted + ", email=" + email
				+ ", mex=" + mex + '}';
	}

	public JSONObject toJsonObject() throws JSONException {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", id);
			jsonObject.put("bulk_id", bulkId);
			jsonObject.put("user_id", userId);
			jsonObject.put("tag", tag);
			jsonObject.put("trusted", trusted);
			jsonObject.put("email", email.toJsonObject());
			jsonObject.put("mex", mex.toJsonObject());
			return jsonObject;
	}
}
