/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
/*
 * 
 */
package it.csi.sigit.sigitbatchn.business.util;


//import it.csi.sigit.sigitwebn.dto.common.CodeDescription;

import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public static String getStringValid(String s) {
		return StringUtils.trimToEmpty(s);
	}
	
	public static BigDecimal getBigDecimalValid(BigDecimal bd) {
		
		return (bd != null)?bd:new BigDecimal(0);
	}
	

	public static String getStringSql(String s) {
		return StringUtils.trimToNull(s);
	}
	
	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNotNullOrEmpty(String s) {
		return s != null && s.trim().length() > 0;
	}
	
	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNotNullOrEmpty(Integer s) {
		return s != null;
	}

	/**
	 * Checks if is not null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is not null or empty
	 */
	public static boolean isNotNullOrEmpty(Object s) {
		return s != null;
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
	
	/**
	 * Check valide number.
	 *
	 * @param num the num
	 * @return true, if successful
	 */
	/*
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
	*/
	/**
	 * Check valide four number.
	 * 
	 * @param num
	 *            the num
	 * @return true, if successful
	 */
	public static boolean checkValideFourNumber(String num) {
		if (!isNullOrEmpty(num)) {
			if (num.matches("^[0-9]{4}"))
				return true;
			else
				return false;
		}

		return false;
	}
	
	/**
	 * Check valide four number.
	 * 
	 * @param num
	 *            the num
	 * @return true, if successful
	 */
	public static boolean checkValideNumber(String num) {
		if (!isNullOrEmpty(num)) {
			if (num.matches("^[0-9]*"))
				return true;
			else
				return false;
		}

		return false;
	}
	
	/**
	 * Check valide  number.
	 * 
	 * @param num
	 *            the num
	 * @return true, if successful
	 */
	public static boolean checkValideMaxLenghtNumber(String num, int lenght) {
		if (!isNullOrEmpty(num)) {
			String exp = "^[0-9]{0,"+lenght+"}";
			//log.debug("STAMPO LA EXP (checkValideLenghtNumber): "+exp);
			if (num.matches(exp))
				return true;
			else
				return false;
		}

		return false;
	}
	
	/**
	 * Check valide number.
	 * 
	 * @param num
	 *            the num
	 * @return true, if successful
	 */
	public static boolean checkValideLenghtNumber(String num, int lenght) {
		if (!isNullOrEmpty(num)) {
			String exp = "^[0-9]{"+lenght+"}";
			//log.debug("STAMPO LA EXP (checkValideLenghtNumber): "+exp);
			if (num.matches(exp))
				return true;
			else
				return false;
		}

		return false;
	}
	
	
	/**
	 * Check valide email.
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	public static boolean checkValideEmail(String email) {
		if (!isNullOrEmpty(email)) {
			if (email
					.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*([,;]\\s*\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)*")) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	/**
	 * Check numero multiplo
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	public static boolean checkNumeroMultiplo(Integer quantita, Integer multiplo) {
		
		if (isNotNullOrEmpty(quantita) &&
				isNotNullOrEmpty(multiplo))
		{
			int c = quantita % multiplo;
			if (c == 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		return false;
	}
	
	public static boolean iniziaPer(String nome, String prefisso)
	{
		boolean isIniziaPer = false;
		if (isNotNullOrEmpty(nome) && isNotNullOrEmpty(prefisso) &&
				nome.toLowerCase().startsWith(prefisso.toLowerCase()))
		{
			isIniziaPer = true;
		}
			
		return isIniziaPer;
	}
	
	/**
	 * Verifica se un valore identifica una check spuntata
	 * 
	 * @param value Valore della check
	 * @return True se la check è spuntata, false altrimenti
	 */
	public static boolean isChecked(String value) {
		return (value != null) && (value.equals(Constants.TRUE));
	}
	
	
	/**
	 * Valida un codice fiscale
	 * 
	 * @param codiceFiscale Codice fiscale da validare
	 * @throws Exception Codice fiscale non valido
	 */
	public static void validateCodiceFiscale(String codiceFiscale) throws Exception {
		validateCodiceFiscaleLength(codiceFiscale);
		validateCodiceFiscaleFormat(codiceFiscale);
	}

	/**
	 * Valida la lunghezza di un codice fiscale
	 * 
	 * @param codiceFiscale Codice fiscale da validare
	 * @throws Exception Lunghezza del codice fiscale non valida
	 */
	public static void validateCodiceFiscaleLength(String codiceFiscale) throws Exception {
		if((codiceFiscale != null) && (codiceFiscale.length() != Constants.CODICE_FISCALE_LEN)) {
			throw new Exception("Lunghezza del codice fiscale non valida.");
		}
	}

	/**
	 * Valida il formato di un codice fiscale
	 * 
	 * @param codiceFiscale Codice fiscale da validare
	 * @throws Exception Formato del codice fiscale non valido
	 */
	public static void validateCodiceFiscaleFormat(String codiceFiscale) throws Exception {
		if(!isStringValid(codiceFiscale, Constants.CODICE_FISCALE)) {
			throw new Exception("Formato del codice fiscale non valido.");
		}
	}

	/**
	 * Valida una partita IVA
	 * 
	 * @param partitaIva Partita IVA da validare
	 * @throws Exception Partita IVA non valido
	 */
	public static void validatePartitaIva(String partitaIva) throws Exception {
		validatePartitaIvaLength(partitaIva);
		validatePartitaIvaFormat(partitaIva);
		verifyNoDummyPartitaIva(partitaIva);
	}

	/**
	 * Valida la lunghezza di una partita IVA
	 * 
	 * @param partitaIva Partita IVA
	 * @throws Exception Lunghezza della partita IVA non valida
	 */
	public static void validatePartitaIvaLength(String partitaIva) throws Exception {
		if((partitaIva != null) && (partitaIva.length() != Constants.PARTITA_IVA_LEN)) {
			throw new Exception("Lunghezza della partita IVA non valida.");
		}
	}

	/**
	 * Valida il formato di una partita IVA
	 * 
	 * @param partitaIva Partita IVA
	 * @throws Exception Formato della partita IVA non valido
	 */
	public static void validatePartitaIvaFormat(String partitaIva) throws Exception {
		if(!isStringValid(partitaIva, Constants.PARTITA_IVA)) {
			throw new Exception("Il formato della partita IVA non è valido");
		}
	}
	
	/**
	 * Valida il formato di un CAP
	 * 
	 * @param cap CAP
	 * @throws Exception Formato del CAP non valido
	 */
	public static void validateCAPFormat(String cap) throws Exception {
		if(!isStringValid(cap, Constants.CAP)) {
			throw new Exception("Il formato del CAP non è valido");
		}
	}
	
	/**
	 * Verifica che la partita IVA non sia farlocca
	 * 
	 * @param partitaIva Partita IVA da verificare
	 * @throws Exception Partita IVA farlocca
	 */
	public static void verifyNoDummyPartitaIva(String partitaIva) throws Exception {
		if(Constants.PARTITA_IVA_DUMMY.equals(partitaIva)) {
			throw new Exception("Partita IVA non valida.");
		}
	}
	
	/**
	 * Verifica se una stringa è valida rispetto ad una espressione regolare
	 * 
	 * @param string La stringa da verificare
	 * @param regex L'espressione regolare
	 * @return True se la stringa è valida, false altrimenti
	 */
	public static boolean isStringValid(String string, String regex) {
		Pattern pattern = null;
		Matcher matcher = null;
		boolean isValid;

		isValid = false;
		if(string != null) {
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(string);
			isValid = matcher.matches();
		}
		return isValid;
	}
	
//	public static String getDescriptionByCod(String cod, ArrayList<CodeDescription> codDescriptionList)
//	{
//		String desc = null;
//		if (GenericUtil.isNotNullOrEmpty(cod))
//		{
//			for (CodeDescription codeDescription : codDescriptionList) {
//				if (cod.equalsIgnoreCase(codeDescription.getCode()))
//				{
//					desc = codeDescription.getDescription();
//					break;
//				}
//			}
//		}
//		return desc;
//	}

	
	/**
	 * Recupera l'input stream associato ad un file contenuto nel class path
	 * 
	 * @param fileName Nome del file
	 * @return Input stream associato al file
	 */
	public static InputStream getFileInClassPath(String fileName) {
		return GenericUtil.class.getClassLoader().getResourceAsStream(fileName);
	}
	
	public static URL getURLFileInClassPath(String fileName) {
		
		return GenericUtil.class.getClassLoader().getResource(fileName);
	}
	
	public static String getStringaParametro(String text, String value) {
		return text = text.replaceFirst(Constants.VALUE_PLACEHOLDER, value);
		
	}
	
	public static String getStringaTxtToHtml(String html) {
		return html.replace(Constants.VALUE_ENTER_HTML, Constants.VALUE_ENTER_TXT);
		
	}
	
	public static String getStackTrace(Exception e) {
		StringWriter exception = new StringWriter();
		e.printStackTrace(new PrintWriter(exception));
		return exception.toString();
	}
	
}