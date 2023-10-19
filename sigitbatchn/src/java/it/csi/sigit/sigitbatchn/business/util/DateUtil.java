/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
/*
 * 
 */
package it.csi.sigit.sigitbatchn.business.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.xmlbeans.XmlCalendar;

/**
 * The Class DateUtil.
 */
public class DateUtil {

	public static Date getDataCorrente(){
		return new Date() ;
	}
	
	public static String getDataCorrenteFormat(){
		return ConvertUtil.convertToString(new Date());
	}
	
	public static String getDataCorrenteFormat(String pattern){
		return ConvertUtil.convertToString(new Date(), pattern);
	}
	
	public static String getDataCorrenteCompletaFormat(){
		return ConvertUtil.convertToStringCompleta(new Date());
	}
	
	public static java.sql.Timestamp getSqlDataCorrente(){
		return new java.sql.Timestamp(System.currentTimeMillis());
	}

	public static java.sql.Date getSqlCurrentDate(){
		return new java.sql.Date(System.currentTimeMillis());
	}

	public static java.sql.Date getSqlDate(Calendar c){
		return new java.sql.Date(c.getTimeInMillis());
	}

	public static boolean checkValideDate(String date) {
		if (GenericUtil.isNotNullOrEmpty(date)) {
			if (date.matches(Constants.DATA))
				return true;
			else return false;
		}
		
		return false;
	}
	
	public static boolean checkDateOrder(String dataPrec, String dataSucc,
			boolean canBeEqual) {
		try {
			if (GenericUtil.isNullOrEmpty(dataPrec) || GenericUtil.isNullOrEmpty(dataSucc)) {
				return false;
			}
			java.util.Date dataInizio = ConvertUtil.convertToDate(dataPrec);
			java.util.Date dataFine = ConvertUtil.convertToDate(dataSucc);
			int confronto = dataInizio.compareTo(dataFine);
			if (confronto > 0 || (!canBeEqual && confronto == 0)) {
				return false;
			}

		} catch (ParseException parseEx) {
			return false;
		}
		catch (Exception parseEx) {
			return false;
		}
		return true;
	}
	
	public static boolean checkDateOrder(String dataPrec, String dataSucc,
			boolean canBeEqual, String pattern) {
		try {
			if (GenericUtil.isNullOrEmpty(dataPrec) || GenericUtil.isNullOrEmpty(dataSucc)) {
				return false;
			}
			java.util.Date dataInizio = ConvertUtil.convertToDate(dataPrec, pattern);
			java.util.Date dataFine = ConvertUtil.convertToDate(dataSucc, pattern);
			int confronto = dataInizio.compareTo(dataFine);
			if (confronto > 0 || (!canBeEqual && confronto == 0)) {
				return false;
			}

		} catch (ParseException parseEx) {
			return false;
		}
		catch (Exception parseEx) {
			return false;
		}
		return true;
	}

	public static boolean checkDateOrderIsPresents(String dataPrec, String dataSucc,
			boolean canBeEqual) {
		try {
			if (GenericUtil.isNullOrEmpty(dataPrec) || GenericUtil.isNullOrEmpty(dataSucc)) {
				return true;
			}
			java.util.Date dataInizio = ConvertUtil.convertToDate(dataPrec);
			java.util.Date dataFine = ConvertUtil.convertToDate(dataSucc);
			int confronto = dataInizio.compareTo(dataFine);
			if (confronto > 0 || (!canBeEqual && confronto == 0)) {
				return false;
			}

		} catch (ParseException parseEx) {
			return false;
		}
		catch (Exception parseEx) {
			return false;
		}
		return true;
	}

	
	public static boolean checkDateEqual(String dataPrec, String dataSucc) {
		try {
			if (GenericUtil.isNullOrEmpty(dataPrec) || GenericUtil.isNullOrEmpty(dataSucc)) {
				return false;
			}
			java.util.Date dataInizio = ConvertUtil.convertToDate(dataPrec);
			java.util.Date dataFine = ConvertUtil.convertToDate(dataSucc);
			int confronto = dataInizio.compareTo(dataFine);
			if (confronto != 0) 
			{
				return false;
			}

		} catch (ParseException parseEx) {
			return false;
		}
		catch (Exception parseEx) {
			return false;
		}
		return true;
	}
	
	public static Calendar getCalendar(Date date)
	{
		if(date==null)
			return null;
		Calendar c = new XmlCalendar(ConvertUtil.convertToString(date,"yyyy-MM-dd"));
		c.setTime(date);
		return c;
	}
	
	
}
