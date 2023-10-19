/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.util;

import it.csi.sigit.sigitext.dto.sigitext.UDTPositiveInteger;
import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.XmlCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
//import  org.apache.xmlbeans.XmlObject

/**
 * Utility di conversione
 *
 * @author
 */
public class ConvertUtil extends GenericUtil {
	/**
	 * Formato data standard
	 */
	public static final String FORMAT_DATE_STANDARD = "dd/MM/yyyy";

	/**
	 * Formato data standard
	 */
	public static final String FORMAT_DATE_STANDARD_COMPLETA = "dd/MM/yyyy HH:mm";

	/**
	 * Formato data con underscore
	 */
	public static final String FORMAT_DATE_UNDERSCORE = "dd_MM_yyyy";
	/**
	 * Formattatore data
	 */
	private static final SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_STANDARD);
	/**
	 * Formattatore data
	 */
	private static final SimpleDateFormat sdfCompl = new SimpleDateFormat(FORMAT_DATE_STANDARD_COMPLETA);
	/**
	 * Lista dei formati decimali
	 */
	private static Hashtable<Integer, String> dicimalFormats = new Hashtable<Integer, String>();

	/**
	 * Converte una data in stringa
	 *
	 * @param dt Data da convertire
	 * @return Data convertita
	 */
	public static String convertToString(java.util.Date dt) {
		String converted = null;

		if (dt != null) {
			converted = sdf.format(dt);
		}
		return converted;
	}

	public static String convertToStringCompleta(java.util.Date dt) {
		String converted = null;

		if (dt != null) {
			converted = sdfCompl.format(dt);
		}
		return converted;
	}

	/**
	 * Converte una data in stringa
	 *
	 * @param dt Data da convertire
	 * @return Data convertita
	 */
	public static String convertToString(Calendar dt) {
		String converted = null;

		if (dt != null) {
			converted = sdf.format(dt.getTime());
		}
		return converted;
	}

	/**
	 * Converte un {@link Number} in stringa
	 *
	 * @param i {@link Number} da convertire
	 * @return {@link Number} convertito
	 */
	public static String convertToString(Number i) {
		String converted = null;

		if (i != null) {
			converted = i.toString();
			// Se il numero ha la virgola, si sostituisce l'eventuale punto con
			// la virgola
			converted = converted.replace(".", ",");
		}
		return converted;
	}

	/**
	 * Converte un {@link Integer} in stringa
	 *
	 * @param i {@link Integer} da convertire
	 * @return {@link Integer} convertito
	 */
	public static String convertToString(Integer i) {
		String converted = null;

		if (i != null) {
			converted = i.toString();
		}
		return converted;
	}

	/**
	 * Converte un {@link BigDecimal} in stringa
	 *
	 * @param number   Numero da convertire
	 * @param decimali Decimali da visualizzare
	 * @return Numero convertito
	 */
	public static String convertToString(BigDecimal number, int decimali) {
		DecimalFormat formatter = null;
		String format = null;
		String stringValue = null;

		if (number != null) {
			format = getNumberFormat(decimali);
			formatter = new DecimalFormat(format);
			stringValue = formatter.format(number.doubleValue());
		}
		return stringValue;
	}

	/**
	 * Converte un {@link BigDecimal} in stringa
	 *
	 * @param number Numero da convertire
	 * @return Numero convertito
	 */
	/*public static String convertToString(BigDecimal num) {
		return convertToString(num, null);
	}*/
	public static String convertToString(BigDecimal num, String pattern) {
		if (num != null) {
			DecimalFormat df = null;
			if (pattern == null) {
				df = new DecimalFormat();
			} else {
				df = new DecimalFormat(pattern);
			}
			return df.format(num.doubleValue());
		} else {
			return "";
		}
	}

	/**
	 * Converte un {@link BigDecimal} in stringa
	 *
	 * @param number   Numero da convertire
	 * @param decimali Decimali da visualizzare
	 * @return Numero convertito
	 */
	public static String convertToString(Double number, int decimali) {
		DecimalFormat formatter = null;
		String format = null;
		String stringValue = null;

		if (number != null) {
			format = getNumberFormat(decimali);
			formatter = new DecimalFormat(format);
			stringValue = formatter.format(number.doubleValue());
		}
		return stringValue;
	}

	/**
	 * Restituisce il formato numerico richiesto
	 *
	 * @param decimali Decimali da visualizzare
	 * @return Formato numerico
	 */
	private static String getNumberFormat(int decimali) {
		String format = null;
		String decimal = null;
		int decimaliCount;

		format = dicimalFormats.get(decimali);
		if (format == null) {
			format = "#,##0";
			decimal = "";
			for (decimaliCount = 0; decimaliCount < decimali; decimaliCount++) {
				decimal += "0";
			}
			if (decimal.length() > 0) {
				format += ("." + decimal);
			}
			dicimalFormats.put(decimali, format);
		}
		return format;
	}

	/**
	 * Converte una stringa in un {@link BigInteger}
	 *
	 * @param s Stringa da convertire
	 * @return Stringa convertita
	 */

	public static BigInteger convertToBigInteger(BigDecimal b) {
		BigInteger converted = null;
		if (b != null) {
				converted = b.toBigInteger();
		}
		return converted;
	}

	public static Integer convertToInteger(BigDecimal i) {
		Integer converted = null;

		if (i != null) {
			converted = i.intValue();
		}
		return converted;
	}

	/**
	 * Converte una stringa in un {@link Integer}
	 *
	 * @param s Stringa da convertire
	 * @return Stringa convertita
	 */
	public static Integer convertToInteger(String s) {
		Integer converted = null;

		if (s != null) {
			try {
				converted = new Integer(s);
			} catch (Exception e) {
				log.error("Errore durante la conversione di '" + s + "' in Integer: " + s, e);
			}
		}
		return converted;
	}

	/**
	 * Converte un {@link BigDecimal} in un {@link Integer}
	 *
	 * @param i {@link BigDecimal} da convertire
	 * @return Stringa convertita
	 */
	public static Integer convertToInteger(BigInteger i) {
		Integer converted = null;

		if (i != null) {
			converted = i.intValue();
		}
		return converted;
	}

	/**
	 * Converte un {@link String} in un {@link Boolean}
	 *
	 * @param s {@link String} da convertire
	 * @return {@link String} convertito
	 */
	public static Boolean convertToBoolean(String s) {
		if (s == null || s.length() == 0) {
			return null;
		} else {
			try {
				if (s.equalsIgnoreCase(Constants.SI)) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				return null;
			}
		}
	}

	public static Boolean convertToBoolean(BigDecimal s) {
		if (s == null) {
			return null;
		} else {
			try {
				if (s.intValue() == Constants.SI_1) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * Converte un {@link BigDecimal} in un {@link boolean}
	 *
	 * @param s {@link BigDecimal} da convertire
	 * @return {@link BigDecimal} convertito
	 */
	public static boolean convertToBooleanAllways(BigDecimal s) {
		if (s == null) {
			return false;
		} else {
			try {
				if (s.intValue() == Constants.SI_1) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * Converte un {@link BigDecimal} in un {@link boolean}
	 *
	 * @param s {@link BigDecimal} da convertire
	 * @return {@link BigDecimal} convertito
	 */
	public static boolean convertToBooleanAllways(Boolean s) {
		if (s == null) {
			return false;
		} else {
			try {
				return s;
			} catch (Exception e) {
				return false;
			}
		}
	}

	public static XmlCalendar convertToXmlCalendar(Calendar cal) {
		if (cal == null)
			return null;

		String dataS = convertToString(cal.getTime(), "yyyy-MM-dd");

		XmlCalendar xd = new XmlCalendar(dataS);
		return xd;
	}

	public static XmlCalendar convertToXmlCalendar(Timestamp timestamp) {

		Date data = new Date(timestamp.getTime());
		return convertToXmlCalendar(data);

	}

	public static XmlCalendar convertToXmlCalendar(Date data) {
		if (data == null)
			return null;
		String dataS = convertToString(data, "yyyy-MM-dd");
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(data);
			GregorianCalendar grc = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
			XMLGregorianCalendar gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(grc);
			gc.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
		} catch (DatatypeConfigurationException e) {
		}
		XmlCalendar xd = new XmlCalendar(dataS);
		return xd;
	}

	/**
	 * Converte una data in stringa
	 *
	 * @param dt     Data da convertire
	 * @param format Formato da utilizzare
	 * @return Data convertita
	 */
	public static String convertToString(java.util.Date dt, String format) {
		SimpleDateFormat sdf = null;
		String converted = null;

		if (dt != null) {
			sdf = new SimpleDateFormat(format);
			converted = sdf.format(dt);
		}
		return converted;
	}

	/**
	 * Converte un {@link Number} in un {@link BigDecimal}
	 *
	 * @param i {@link Number} da convertire
	 * @return {@link Number} convertito
	 */
	public static BigDecimal convertToBigDecimal(Number i) {
		BigDecimal b = null;

		if (i != null) {
			b = convertToBigDecimal(i.toString());
		}
		return b;
	}

	/**
	 * Converte un {@link Boolean} in un {@link BigDecimal}
	 *
	 * @param i {@link Boolean} da convertire
	 * @return {@link BigDecimal} convertito
	 */
	public static BigDecimal convertToBigDecimal(Boolean i) {
		BigDecimal b = null;

		if (i != null) {

			b = i ? new BigDecimal(Constants.SI_1) : new BigDecimal(Constants.NO_0);

		}
		return b;
	}

	public static BigDecimal getBigDecimalValid(BigDecimal bd) {

		return (bd != null) ? bd : new BigDecimal(0);
	}

	/**
	 * Converte una stringa in {@link BigDecimal}. Accetta anche numeri con la
	 * virgola come separatore dei decimali. Non sono ammessi separatori di
	 * migliaia
	 *
	 * @param s Valore da convertire
	 * @return {@link BigDecimal} che rappresenta il valore
	 */
	public static BigDecimal convertToBigDecimal(String s) {
		BigDecimal number = null;

		if (StringUtils.isNotBlank(s)) {
			try {
				// Si converte l'eventuale virgola in punto
				number = new BigDecimal(s.replaceAll(",", "."));
			} catch (Exception e) {
				log.error("Errore durante la conversione di '" + s + "' in BigDecimal: " + s, e);
			}
		}
		return number;
	}

	public static XmlCalendar convertDateToXmlCalendar(java.util.Date data) {
		if (data == null)
			return null;
		return convertToXmlCalendar(new Date(data.getTime()));
	}

	public static String convertToStringOrEmpty(Number i) {
		String converted;

		converted = convertToString(i);
		if (converted == null) {
			converted = "";
		}

		return converted;
	}

	public static String convertToStringOrEmpty(Date i) {
		String converted;

		converted = convertToString(i);
		if (converted == null) {
			converted = "";
		}

		return converted;
	}

	public static String convertToStringOrEmpty(Timestamp i) {
		String converted;

		converted = convertToString(i);
		if (converted == null) {
			converted = "";
		}

		return converted;
	}

	/**
	 * Converte una data in stringa
	 *
	 * @param dt Data da convertire
	 * @return Data convertita
	 */
	public static Date convertToDate(Calendar dt) {
		Date converted = null;

		if (dt != null) {
			converted = new Date(dt.getTimeInMillis());
		}
		return converted;
	}

	/**
	 * Converte una stringa in data
	 *
	 * @param s Stringa da convertire
	 * @return Stringa convertita
	 * @throws Exception Stringa non valida
	 */
	public static java.util.Date convertToDate(String s) throws Exception {
		java.util.Date converted = null;

		if (StringUtils.isNotBlank(s)) {
			try {
				converted = sdf.parse(s);
			} catch (ParseException e) {
				throw new Exception("Errore nella parsificazioen della data " + s, e);
			}
		}
		return converted;
	}

	public static BigInteger convertToBigInteger(int b) {

		return new BigInteger(convertToString(b));
	}

	public static BigInteger convertToBigInteger(String s) {
		BigInteger converted = null;

		if (StringUtils.isNotBlank(s)) {
			try {
				converted = new BigInteger(s);
			} catch (Exception e) {
				log.error("Errore durante la conversione di '" + s + "' in BigInteger: " + s, e);
			}
		}
		return converted;
	}

	public static int getYear(String value) throws Exception {
		return getYear(convertToDate(value));
	}

	/**
	 * Restituisce l'anno di una data
	 *
	 * @param date Data da cui estrarre l'anno
	 * @return Anno della data
	 */
	public static int getYear(java.util.Date date) {
		GregorianCalendar calendar = null;

		calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * Converte una stringa in data SQL
	 *
	 * @param s Stringa da convertire
	 * @return Stringa convertita
	 */
	public static Date convertToSqlDate(String s) {
		Date converted = null;

		if (StringUtils.isNotBlank(s)) {
			try {
				converted = new Date(sdf.parse(s).getTime());
			} catch (ParseException e) {
				log.debug("Stringa da convertire in sql.Date: " + s);
			}
		}
		return converted;
	}

	/**
	 * Converte una stringa in data SQL
	 *
	 * @param s Stringa da convertire
	 * @return Stringa convertita
	 */
	public static Date convertToSqlDate(java.util.Date s) {
		Date converted = null;

		if (isNotNullOrEmpty(s)) {
			converted = new Date(s.getTime());
		}
		return converted;
	}

	public static String formattaNominativo(String nome, String cognome) {
		String value = "";
		boolean flg = false;
		if (nome != null) {
			value = nome;
			flg = true;
		}

		if (flg) {
			value = value + " " + cognome;
		} else {
			value = cognome;
		}

		return value;
	}

	public static String getStringByList(List listOb, String separator) {
		String out = "";
		if (listOb != null) {
			for (int i = 0; i < listOb.size(); i++) {
				out += listOb.get(i) + (i == (listOb.size() - 1) ? "" : separator);
			}
		}
		return out;
	}

	public static String getStringByList(List listOb) {
		return getStringByList(listOb, ", ");
	}

	public static String formattaSiglaBollino(BigDecimal numeroBollino) {

		return formattaSiglaBollino(Constants.SIGLA_BOLLINO_RP, numeroBollino);
	}

	public static String formattaSiglaBollino(String siglaBollino, BigDecimal numeroBollino) {
		String value = "";
		if (siglaBollino != null && numeroBollino != null)
			value = siglaBollino + "-" + numeroBollino;
		return value;
	}

	public static String getStringByConcat(String separator, String... stringToConcat) {
		String risultato = null;
		if (separator == null) {
			//APPLICAZIONE SEPARATORE DI DEFAULT
			separator = " ";
		}
		for (String stringa : stringToConcat) {
			if (!GenericUtil.isNullOrEmpty(stringa)) {
				if (risultato == null) {
					//PRIMA ITERAZIONE
					risultato = stringa;
				} else {
					risultato += (separator + stringa);
				}
			}
		}
		if (risultato == null) {
			return "";
		}
		return risultato;
	}

	public static Boolean getNumberAsBoolean(BigDecimal b) {
		if (b == null)
			return Boolean.FALSE;
		return !BigDecimal.ZERO.equals(b);
	}

	public static UDTPositiveInteger convertToUDTPositiveInteger(BigDecimal big) {

		return (big != null) ? new UDTPositiveInteger(big.intValue()) : null;
	}
}
