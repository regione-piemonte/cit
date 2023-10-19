/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
/*
 * 
 */
package it.csi.sigit.sigitweba.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * The Class DateUtil.
 */
public class DateUtil {

	public static java.sql.Timestamp getSqlDataCorrente(){
		return new java.sql.Timestamp(System.currentTimeMillis()) ;
	}

	public static java.sql.Date getSqlDate(){
		return new java.sql.Date(System.currentTimeMillis()) ;
	}

	public static String getString(java.sql.Date dataStr) {
		return getString(dataStr,null);
	}

	public static String getString(java.sql.Date dataStr, String pattern) {
		if(dataStr==null)
			return null;
		if(pattern==null)
			pattern = Constants.DATE_FORMAT;
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(dataStr);
	}

	public static Date getDate(String dataCorso) throws ParseException {
		if(dataCorso==null)
			return null;
		DateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
		return new Date(df.parse(dataCorso).getTime());
	}
}
