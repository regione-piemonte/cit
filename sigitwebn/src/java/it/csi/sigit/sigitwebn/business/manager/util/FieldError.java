/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.manager.util;

public class FieldError {

	String field = "";
	String messageField = "";
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getMessageField() {
		return messageField;
	}
	public void setMessageField(String messageField) {
		this.messageField = messageField;
	}
}
