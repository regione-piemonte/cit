/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
/*
 * 
 */
package it.csi.sigit.sigitweba.util;


import it.csi.sigit.sigitweba.dto.common.CodeDescription;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


/**
 * The Class GenericUtil.
 */
public class GenericUtil {

	/** The Constant BEGIN. */
	static final int BEGIN = 1;

	/** The Constant END. */
	static final int END = 2;

	/** The Constant VALUE. */
	static final int VALUE = 3;

	/** The Constant TEST. */
	static final int TEST = 4;

	/** The Constant SIMPLE. */
	static final int SIMPLE = 5;
	
	

	/** The log. */
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);

	/**
	 * Stampa.
	 * 
	 * @param o
	 *            the o
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 * @param testName
	 *            the test name
	 */
	public static void stampa(Object o, boolean useLog4j, int depth,
			String testName) {
		try {
			if (useLog4j) {
				log.debug(testName + " BEGIN");
			} else {
				System.out.println(testName + " BEGIN");
			}
			if (o != null) {
				if (o.getClass().isArray()) {
					Object[] a = (Object[]) o;
					stampa(a, useLog4j, depth);
				} else {
					stampa(o, useLog4j, depth);
				}
			}
			if (useLog4j) {
				log.debug(testName + " END");
			} else {
				System.out.println(testName + " END");
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * Stampa.
	 * 
	 * @param o
	 *            the o
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 */
	public static void stampa(Object o, boolean useLog4j, int depth) {

		try {
			if (o == null) {
				print(o, null, useLog4j, depth, BEGIN);
			} else {
				if (o instanceof String) {
					print(o, o, useLog4j, depth, SIMPLE);
				} else {
					print(o, null, useLog4j, depth, BEGIN);
					callGetMethods(o, useLog4j, depth + 1);
					print(o, null, useLog4j, depth, END);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * Prints the.
	 * 
	 * @param o
	 *            the o
	 * @param value
	 *            the value
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 * @param type
	 *            the type
	 * @throws Exception
	 *             the exception
	 */
	private static void print(Object o, Object value, boolean useLog4j,
			int depth, int type) throws Exception {

		StringBuffer tab = new StringBuffer();
		for (int i = 0; i < depth; i++) {
			tab.append("\t");
		}
		if (o != null) {
			String className = o.getClass().getName();
			switch (type) {
			case BEGIN:
				tab.append(className);
				tab.append(" BEGIN");
				break;
			case END:
				tab.append(className);
				tab.append(" END");
				break;
			case VALUE:
				tab.append(((Method) o).getName());
				tab.append(" == ");
				tab.append(value);
				break;
			case SIMPLE:
				tab.append(o);
				tab.append(" == ");
				tab.append(value);
				break;
			default:

			}
		} else if (type == TEST) {
			tab.append("");
		} else {
			tab.append("Oggetto nullo!!");
		}

		if (useLog4j) {
			log.debug(tab);
		} else {
			System.out.println(tab);
		}

	}

	/**
	 * Call get methods.
	 * 
	 * @param o
	 *            the o
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 */
	private static void callGetMethods(Object o, boolean useLog4j, int depth) {
		try {
			Method[] meth = o.getClass().getDeclaredMethods();
			for (int i = 0; i < meth.length; i++) {
				Method thisM = meth[i];
				if (thisM.getName().startsWith("get")) {
					if (!thisM.getName().equals("get")) {
						Object result = thisM.invoke(o, new Object[] {});
						if (result != null && result.getClass().isArray()) {
							Object[] a = (Object[]) result;
							stampa(a, useLog4j, depth);
						} else {
							print(thisM, result, useLog4j, depth, VALUE);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * Stampa.
	 * 
	 * @param o
	 *            the o
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 * @throws Exception
	 *             the exception
	 */
	public static void stampa(Object[] o, boolean useLog4j, int depth)
			throws Exception {
		String className = o.getClass().getSimpleName();
		for (int i = 0; i < o.length; i++) {
			stampa(o[i], false, depth);
		}

		if (o.length == 0) {
			System.out.println(className + " vuoto");
		}

	}


	/**
	 * Checks if is numero.
	 * 
	 * @param numero
	 *            the numero
	 * @return true, if is numero
	 */
	public static boolean isNumero(String numero) {

		boolean isValido = false;

		if (StringUtils.isNotEmpty(numero)) {
			try {
				new Integer(numero).intValue();
				isValido = true;
			} catch (Exception ex) {
				log.error(ex);
			}
		}

		return isValido;

	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}

	/**
	 * Checks if is not null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNonNullOrEmpty(String s) {
		return s != null && s.trim().length() > 0;
	}
	
	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Integer s) {
		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Double s) {
		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Boolean s) {
		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Object s) {
		return s == null;
	}

	public static boolean isNullOrEmpty(List<?> s) {
		if (s != null) {
			return s.isEmpty();
		}

		return s == null;
	}
	
	public static String getStringUpperSql(String s) {
		if (StringUtils.isNotBlank(s))
		{
			return StringUtils.trim(s).toUpperCase();
		}
		else
		{
			return null;
		}
	}
	
	public static String getStringSql(String s) {
		return StringUtils.trimToNull(s);
	}
	
	/**
	 * Check valide number.
	 *
	 * @param num the num
	 * @return true, if successful
	 */
	public static boolean checkValideNumber(String num) {
		if (!isNullOrEmpty(num)) {
			if (num.matches("^[+]?\\d*$")) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}
	
	/**
	 * Check valid email.
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	public static boolean checkValidEmail(String email) {
		String mailExp = "(^$)|(^[A-Za-z0-9!#$%*/?|^{}`~&+=_.-]+@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,}$)";
//		String mailExp = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*([,;]\\s*\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)*";
		if (!isNullOrEmpty(email)) {
			return email.matches(mailExp);
		}
		return false;
	}

	public static boolean checkValidCF(String cf) {
		String REGEX_CF = "(^$)|(^[A-Za-z]{6}[0-9A-Za-z]{2}[A-Za-z][0-9A-Za-z]{2}[A-Za-z][0-9A-Za-z]{3}[A-Za-z]$)";
		if (!isNullOrEmpty(cf)) {
			return cf.matches(REGEX_CF);
		}
		return false;
	}
	
	public static String getDescriptionByCode(String code, ArrayList<CodeDescription> codDescriptionList) {
		String desc = null;
		if (GenericUtil.isNonNullOrEmpty(code)) {
			for (CodeDescription codeDescription : codDescriptionList) {
				if (code.equalsIgnoreCase(codeDescription.getCode())) {
					desc = codeDescription.getDescription();
					break;
				}
			}
		}
		return desc;
	}
	
	public static String getStringOrNull(Object o)
	{
		if(o!=null)
			return o.toString();
		return null;
	}
	
	public static BigDecimal getBooleanAsNumber(Boolean b)
	{
		return  b ? new BigDecimal(Constants.SI_1) : new BigDecimal(Constants.NO_0);
	}

	public static Boolean getNumberAsBoolean(BigDecimal b)
	{
		if(b==null)
			return Boolean.FALSE;
		return  !BigDecimal.ZERO.equals(b);
	}
	
	public static void stampaParametriRequest(HttpServletRequest httpReq)
	{
		log.debug("###############");
		log.debug("stampaParametriRequest getHeaderNames");
		Enumeration<String> names = httpReq.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            Object value = httpReq.getHeader(name);
            log.debug("Attributo: "+name+" --> "+value);
        }
		log.debug("###############");

	}

}