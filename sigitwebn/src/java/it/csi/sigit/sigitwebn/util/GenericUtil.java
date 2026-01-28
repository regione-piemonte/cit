/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
/*
 * 
 */
package it.csi.sigit.sigitwebn.util;


import it.csi.custom.component.tree.base.TreeNode;
import it.csi.custom.component.tree.base.TreeNodeBase;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTComp4Dto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVCompCgDettDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVCompGfDettDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVCompGtDettDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVCompScDettDto;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.dto.BaseSessionAwareDTO;
import it.csi.sigit.sigitwebn.dto.ExecResults;
import it.csi.sigit.sigitwebn.dto.accesso.AbilitazioniRuoloFunz;
import it.csi.sigit.sigitwebn.dto.accesso.Ruolo;
import it.csi.sigit.sigitwebn.dto.common.CodeDescription;
import it.csi.sigit.sigitwebn.dto.common.IdDescription;
import it.csi.sigit.sigitwebn.dto.documentazione.Documento;
import it.csi.sigit.sigitwebn.dto.impianto.Impianto;
import it.csi.sigit.sigitwebn.dto.impianto.LogicaVisualizzazione;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteCS;
import it.csi.sigit.sigitwebn.dto.libretto.LibrettoDett;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.util.enumutil.IndiceFumositaEnum;
import it.csi.sigit.sigitwebn.util.enumutil.ModalitaEvacuazioneEnum;
import it.csi.sigit.sigitwebn.util.enumutil.NaturaleForzataEnum;
import it.csi.sigit.sigitwebn.util.enumutil.O2CO2Enum;
import it.csi.sigit.sigitwebn.util.enumutil.PortataCombustibileEnum;
import it.csi.sigit.sigitwebn.util.enumutil.PositivoNegativoEnum;
import it.csi.sigit.sigitwebn.util.enumutil.PresenteAssenteEnum;
import it.csi.sigit.sigitwebn.util.enumutil.RegolareIrregolareEnum;
import it.csi.sigit.sigitwebn.util.enumutil.SiNoEnum;
import it.csi.sigit.sigitwebn.util.enumutil.SufficienteNonSufficiente;
import it.csi.sigit.sigitwebn.util.enumutil.TipoSubentroEnum;
import it.csi.sigit.sigitwebn.util.enumutil.UnitaMisuraNox;
import it.csi.sigit.sigitwebn.util.mail.ResultInvioMail;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;


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
			log.debug("Errore stampa: ", e);
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
			log.debug(e);
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
			log.debug("Errore callGetMethods()", e);
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
				log.debug("Errore isNumero()", ex);
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

	public static String getStringValid(Integer s) {
		return getStringValid(ConvertUtil.convertToString(s));
	}

	public static String getStringValid(BigDecimal s) {
		
		return getStringValid(ConvertUtil.convertToString(s));
		
	}
	
	public static String getStringValid(java.util.Date s) {
		
		return getStringValid(ConvertUtil.convertToString(s));
		
	}
	
	public static BigDecimal getBigDecimalValid(BigDecimal bd) {
		
		return (bd != null)?bd:new BigDecimal(0);
	}
	
	public static boolean isBigDecimalPositive(BigDecimal bd) {
		
		return (bd != null)?(bd.doubleValue() > 0):false;
	}

	public static boolean isDecimalNumber(String num){
		try{
				num = num.replace(",", ".");
				Double.parseDouble(num);
				return true;
			}catch(Exception e){
				return false;
		}
	}
	
	public static boolean isDecimalPositiveNumber(String num){
		try{
				double d = Double.parseDouble(num);
				return d > 0;
			}catch(Exception e){
				return false;
		}
	}
	
	public static boolean isDecimalNumber(String num, boolean replaceActive){
		try{
				Double.parseDouble(replaceActive ? num.replace(',', '.') : num);
				return true;
			}catch(Exception e){
				return false;
		}
	}
	
	/**
	 * metodo che controlla se una stringa e' convertibile in numero decimale. Nel caso in cui sia maxInteri che maxDecimal fossero settati, viene controllato
	 * il rispetto dei due limiti. Nel caso in cui solo maxInteri fosse settato, viene controllata semplicemente la lunghezza della stringa (nel caso ci fosse un limite 
	 * al numero di caratteri)
	 * @param num
	 * @param maxInteri
	 * @param maxDecimal
	 * @return
	 */
	public static boolean isNumeroDecimaleValido(String num, Integer maxInteri, Integer maxDecimal, boolean checkPositive)
	{
		//controlla se e' convertibile in double positivo o in semplice double
		boolean ret = checkPositive ? isDecimalPositiveNumber(num) : isDecimalNumber(num);

		String prefisso = checkPositive ? "" : "-?";
		if (maxInteri != null && maxDecimal != null) {
			return num.matches(prefisso + "\\d{1,"+maxInteri+"}(\\.\\d{1,"+maxDecimal+"})?");
		}
		
		if (maxInteri != null) {
			return num.matches(prefisso + "\\d{1,"+maxInteri+"}");
		}
		
		if (maxDecimal != null) {
			return num.matches(prefisso + "\\d*(\\.?\\d{1,"+maxDecimal+"})?");
		}
		
		if (maxInteri == null && maxDecimal == null) {
			//controlla solo se si tratta di un numero positivo
			return num.matches(prefisso + "\\d*(\\.?\\d{1,})?");
		}
		
		return ret;
	}
	
	public static boolean isNumeroDecimaleValido(String num, Integer maxInteri, Integer maxDecimal, boolean checkPositive, Integer maxLength) {
		boolean check = isNumeroDecimaleValido(num, maxInteri, maxDecimal, checkPositive);
		if (check && maxLength != null) {
			check = num.length() <= maxLength.intValue();
		}
		return check;
	}

	public static boolean isNumeroDecimaleValidoMaxDec(String num, int maxDecimal)
	{
		boolean ret = isDecimalNumber(num);
		num = num.replace(",", ".");
		int posPunto = num.indexOf(".");
		
		//System.out.println("posPunto: "+posPunto);
		
		if (ret)
		{
			if (posPunto > 0)
			{
				// son presenti decimali
				
				String dec = num.substring(posPunto+1);
				//System.out.println("dec: "+dec);
				
				if (dec.length() > maxDecimal)
				{
					ret = false;
				}
			}
			
		}
		return ret;
	}

	public static String getSubstring(String s, int maxLenght) {
		
		String ret = null;
		if (s != null)
		{
			if (s.length() > maxLenght)
			{
				ret = StringUtils.substring(s, 0, maxLenght);
			}
			else
			{
				ret = s;
			}
		}
		return ret;
	}

	
	public static String getStringSql(String s) {
		return StringUtils.trimToNull(s);
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
	 * Check valide four number.
	 * 
	 * @param num
	 *            the num
	 * @return true, if successful
	 */
	public static boolean checkValideNumberTrim(String num) {
		if (!isNullOrEmpty(num)) {
			if (num.trim().matches("^[0-9]*"))
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
	
	/**
	 * Verifica se un valore identifica una check spuntata
	 * 
	 * @param value Valore della check
	 * @return True se la check e' spuntata, false altrimenti
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
			throw new Exception("Il formato della partita IVA non e' valido");
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
			throw new Exception("Il formato del CAP non e' valido");
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
	 * Verifica se una stringa e' valida rispetto ad una espressione regolare
	 * 
	 * @param string La stringa da verificare
	 * @param regex L'espressione regolare
	 * @return True se la stringa e' valida, false altrimenti
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
	
	public static String getDescriptionByCod(Integer cod, ArrayList<CodeDescription> codDescriptionList)
	{
		String codS = null;
		if (GenericUtil.isNotNullOrEmpty(cod))
		{
			codS = ConvertUtil.convertToString(cod);
			
		}
		return getDescriptionByCod(codS, codDescriptionList);
	}
	
	public static String getDescriptionByCod(String cod, ArrayList<CodeDescription> codDescriptionList)
	{
		String desc = null;
		if (GenericUtil.isNotNullOrEmpty(cod))
		{
			for (CodeDescription codeDescription : codDescriptionList) {
				if (cod.equalsIgnoreCase(codeDescription.getCode()))
				{
					desc = codeDescription.getDescription();
					break;
				}
			}
		}
		return desc;
	}

	public static String getCodByDescription(String description, ArrayList<CodeDescription> codDescriptionList)
	{
		String cod = null;
		if (GenericUtil.isNotNullOrEmpty(description))
		{
			for (CodeDescription codeDescription : codDescriptionList) {
				if (description.equalsIgnoreCase(codeDescription.getDescription()))
				{
					cod = codeDescription.getCode();
					break;
				}
			}
		}
		return cod;
	}
	
	public static String getCodIstatProvByCodIstatComune(String codIstatComune)
	{
		String cod = null;
		if (GenericUtil.isNotNullOrEmpty(codIstatComune))
		{
			cod = codIstatComune.substring(0,3);
		}
		return cod;
	}
	
	public static String getCodIstatProvByIstatAbilitazione(String istatAbilitazione)
	{
		String cod = null;
		if (GenericUtil.isNotNullOrEmpty(istatAbilitazione))
		{
			cod = istatAbilitazione.substring(2,5);
		}
		return cod;
	}
	
	public static String getCodIstatComuneByIstatAbilitazione(String istatAbilitazione)
	{
		String cod = null;
		if (GenericUtil.isNotNullOrEmpty(istatAbilitazione))
		{
			cod = istatAbilitazione.substring(2);
		}
		return cod;
	}
	
	public static LogicaVisualizzazione setLogicaVisualizzazione(Impianto impianto)
	{
		LogicaVisualizzazione logica = new LogicaVisualizzazione();
		logica.setCaso(Constants.COD_CASO_B);

		//ELIMINATI - verificare se c'e' ne sono altri
//		logica.setIsBotVisLibrettoVisibile(GenericUtil
//				.isNotNullOrEmpty(impianto.getLibDataRilascio()));
//
//		logica.setIsBotConsLibrettoVisibile(impianto.getLibIsModifica()
//				.equalsIgnoreCase(Constants.LABEL_SI));
//
//		logica.setIsBotElimLibrettoVisibile(impianto.getLibIsModifica()
//				.equalsIgnoreCase(Constants.LABEL_SI));
//
//		logica.setIsBotRappControlloVisibile(impianto
//				.getLibIsModifica()
//				.equalsIgnoreCase(Constants.LABEL_SI));

		return logica;
	}
	
	/*
	public static ArrayList<String> getElencoCombustibiliCompGt(List<SigitVCompGtDettDto> listaApparecchiatureDto)
	{
		ArrayList<String> elencoCombustibili = new ArrayList<String>();
		
		for (SigitVCompGtDettDto dto : listaApparecchiatureDto) {
			elencoCombustibili.add(dto.getDesCombustibile());
			
		}
		
		return elencoCombustibili;
	}
	*/
	
	/*
	public static ArrayList<Integer> getElencoCombustibiliCompGf(List<SigitVCompGfDettDto> listaApparecchiatureDto)
	{
		ArrayList<Integer> elencoCombustibili = new ArrayList<Integer>();
		
		for (SigitVCompGfDettDto dto : listaApparecchiatureDto) {
			elencoCombustibili.add(ConvertUtil.convertToInteger(dto.getFkCombustibile()));
			
		}
		
		return elencoCombustibili;
	}
	*/
	
	/*
	public static ArrayList<Integer> getElencoCombustibiliCompSc(List<SigitVCompScDettDto> listaApparecchiatureDto)
	{
		ArrayList<Integer> elencoCombustibili = new ArrayList<Integer>();
		
		for (SigitVCompScDettDto dto : listaApparecchiatureDto) {
			elencoCombustibili.add(ConvertUtil.convertToInteger(dto.getFkCombustibile()));
			
		}
		
		return elencoCombustibili;
	}
	*/
	
	/*
	public static ArrayList<Integer> getElencoCombustibiliCompCg(List<SigitVCompCgDettDto> listaApparecchiatureDto)
	{
		ArrayList<Integer> elencoCombustibili = new ArrayList<Integer>();
		
		for (SigitVCompCgDettDto dto : listaApparecchiatureDto) {
			elencoCombustibili.add(ConvertUtil.convertToInteger(dto.getFkCombustibile()));
			
		}
		
		return elencoCombustibili;
	}
	*/
	
	public static ArrayList<String> eliminaCampoVuoto(ArrayList<String> elenco)
	{
		log.debug("Stampo l'elenco prima: "+elenco);
		if (elenco != null)
		{
			log.debug("ELIMINO L'ELEMENTO");
			elenco.remove(null);
			elenco.remove("");
		}
		log.debug("Stampo l'elenco dopo: "+elenco);

		return elenco;
	}


	public static String getPrimoToken(String codice) {
		
		StringTokenizer st = new StringTokenizer(codice,Constants.INTERVAL_SEP_HASH);
		
		return st.nextToken();
	}

	public static String getSecondoToken(String codice) {
		
		StringTokenizer st = new StringTokenizer(codice,Constants.INTERVAL_SEP_HASH);
		
		st.nextToken();
		
		return st.nextToken();
	}
	
	public static String getIdRComp4Manut(String manutProgressivo) {
		
		StringTokenizer st = new StringTokenizer(manutProgressivo,Constants.INTERVAL_SEP_HASH);
		
		String idManut4 = st.nextToken();
		//System.out.println("idManut4: "+idManut4);
		
		return idManut4;
	}

	public static String getFkManutentore(String manutProgressivo) {
		
		StringTokenizer st = new StringTokenizer(manutProgressivo,Constants.INTERVAL_SEP_HASH);
		
		// questo e' idManut4
		st.nextToken();
		//System.out.println("idManut4: "+idManut4);
		
		String manut = st.nextToken();
		//System.out.println("manut: "+manut);
		
		return manut;
	}
	
	public static String getProgressivo(String manutProgressivo) {
		StringTokenizer st = new StringTokenizer(manutProgressivo,Constants.INTERVAL_SEP_HASH);
		
		//idManut4
		st.nextToken();
		//System.out.println("idManut4: "+idManut4);
		
		//manut
		st.nextToken();
		//System.out.println("manut: "+manut);
		
		String prog = st.nextToken();
		//System.out.println("prog: "+prog);	
		
		log.debug("TokenProgressivo: "+prog);
		
		return prog;
	}
	
	public static ArrayList<String> recuperaProgressivo(ArrayList<String> manutProgressivoList)
	{
		ArrayList<String> manutProgressivoNewList = new ArrayList<String>();
		
		log.debug("manutProgressivoList: "+manutProgressivoList);
		
		for (String manutProgressivo : manutProgressivoList) {
			log.debug("manutProgressivo: "+manutProgressivo);

			manutProgressivoNewList.add(getProgressivo(manutProgressivo));
			
		}
		
		return manutProgressivoNewList;
	}

	public static ArrayList<String> recuperaComp4Manut(ArrayList<String> manutProgressivoList)
	{
		ArrayList<String> manutProgressivoNewList = new ArrayList<String>();
		
		log.debug("Creo la lista di IdRComp4Manut: "+manutProgressivoList);
		
		for (String manutProgressivo : manutProgressivoList) {
			
			log.debug("Aggiungo l'idRComp4Manut: "+manutProgressivo);
			
			manutProgressivoNewList.add(getIdRComp4Manut(manutProgressivo));
			
		}
		
		return manutProgressivoNewList;
	}

	public static String getIdTipoAllegatoByIdTipoManut(int idTipoManut)
	{
		String idTipoAllegato = null;
		if(Constants.MANUTENZIONE_GT == idTipoManut)
		{
			idTipoAllegato = Constants.TIPO_COMPONENTE_GT;
		}
		
		if(Constants.MANUTENZIONE_GF == idTipoManut)
		{
			idTipoAllegato = Constants.TIPO_COMPONENTE_GF;
		}
		
		if(Constants.MANUTENZIONE_SC == idTipoManut)
		{
			idTipoAllegato = Constants.TIPO_COMPONENTE_SC;
		}
		
		if(Constants.MANUTENZIONE_CG == idTipoManut)
		{
			idTipoAllegato = Constants.TIPO_COMPONENTE_CG;
		}	
	
		return idTipoAllegato;
	}
	
	public static LogicaVisualizzazione getLogicaVisualizzazioneSubentro()
	{
		LogicaVisualizzazione logica = new LogicaVisualizzazione();
		logica.setCaso(Constants.COD_CASO_E);

		logica.setIsImpiantoIndConfermato(true);
		
		//ELIMINATI - verificare se c'e' ne sono altri
//		logica.setIsBotVisLibrettoVisibile(GenericUtil
//				.isNotNullOrEmpty(impianto.getLibDataRilascio()));
//
//		logica.setIsBotConsLibrettoVisibile(impianto.getLibIsModifica()
//				.equalsIgnoreCase(Constants.LABEL_SI));
//
//		logica.setIsBotElimLibrettoVisibile(impianto.getLibIsModifica()
//				.equalsIgnoreCase(Constants.LABEL_SI));
//
//		logica.setIsBotRappControlloVisibile(impianto
//				.getLibIsModifica()
//				.equalsIgnoreCase(Constants.LABEL_SI));

		return logica;
	}
	
	/**
	 * Recupera l'input stream associato ad un file contenuto nel class path
	 * 
	 * @param fileName Nome del file
	 * @return Input stream associato al file
	 */
	public static InputStream getFileInClassPath(String fileName) {
		return GenericUtil.class.getClassLoader().getResourceAsStream(fileName);
	}
	
	public static ArrayList<CodeDescription> getComboIndiceFumosita() {
		return getComboValues(IndiceFumositaEnum.class.getName());
	}
	
	public static ArrayList<CodeDescription> getComboModalitaEvacuazione() {
		return getComboValues(ModalitaEvacuazioneEnum.class.getName());
	}
	
	public static ArrayList<CodeDescription> getComboO2Co2() {
		return getComboValues(O2CO2Enum.class.getName());
	}
	
	public static ArrayList<CodeDescription> getComboRegolareIrregolare() {
		return getComboValues(RegolareIrregolareEnum.class.getName());
	}
	
	public static ArrayList<CodeDescription> getComboSufficienteNonSufficiente() {
		return getComboValues(SufficienteNonSufficiente.class.getName());
	}
	
	
	
	public static ArrayList<CodeDescription> getComboSiNo()
	{
		return getComboValues (SiNoEnum.class.getName());
	}

	public static ArrayList<CodeDescription> getComboUnitaMisuraNox()
	{
		return getComboValues (UnitaMisuraNox.class.getName());
	}

	public static ArrayList<CodeDescription> getComboPresenteAssente()
	{
		return getComboValues(PresenteAssenteEnum.class.getName());
	}
	
	public static ArrayList<CodeDescription> getComboPortataCombustibile()
	{
		return getComboValues(PortataCombustibileEnum.class.getName());
	}
	
	public static ArrayList<IdDescription> getComboPositivoNegativo()
	{
		return getComboIdValues(PositivoNegativoEnum.class.getName());
	}

	public static ArrayList<IdDescription> getComboIdPresenteAssente()
	{
		return getComboIdValues(PresenteAssenteEnum.class.getName());
	}

	public static ArrayList<CodeDescription> getComboNaturaleForzata()
	{
		return getComboValues(NaturaleForzataEnum.class.getName());
	}
	
	public static ArrayList<CodeDescription> getComboTipoImpianto()
	{
		CodeDescription codDes = new CodeDescription();
		
		ArrayList<CodeDescription> comboTipoImpianto = new ArrayList<CodeDescription>();
		
		codDes.setCode(Constants.COD_TIPO_IMPIANTO_AUTONOMO);
		codDes.setDescription(Constants.DESC_TIPO_IMPIANTO_AUTONOMO);
		comboTipoImpianto.add(codDes);
		
		codDes = new CodeDescription();
		codDes.setCode(Constants.COD_TIPO_IMPIANTO_CENTRALIZZATO);
		codDes.setDescription(Constants.DESC_TIPO_IMPIANTO_CENTRALIZZATO);
		comboTipoImpianto.add(codDes);
		
		return comboTipoImpianto;
	}
	
	public static ArrayList<CodeDescription> getComboRuoliImpresa()
	{
		CodeDescription codDes = new CodeDescription();
		
		ArrayList<CodeDescription> comboRuoli = new ArrayList<CodeDescription>();
				
		codDes = new CodeDescription();
		codDes.setCode(Constants.RUOLO_IMPRESA);
		codDes.setDescription(Constants.RUOLO_IMPRESA);
		comboRuoli.add(codDes);
		
		codDes = new CodeDescription();
		codDes.setCode(Constants.RUOLO_3RESPONSABILE);
		codDes.setDescription(Constants.RUOLO_3RESPONSABILE);
		comboRuoli.add(codDes);
		
		codDes = new CodeDescription();
		codDes.setCode(Constants.RUOLO_DISTRIBUTORE);
		codDes.setDescription(Constants.RUOLO_DISTRIBUTORE);
		comboRuoli.add(codDes);
		
		codDes = new CodeDescription();
		codDes.setCode(Constants.RUOLO_AMMINISTRATORE);
		codDes.setDescription(Constants.LABEL_ALTRA_IMPRESA);
		comboRuoli.add(codDes);
		
		codDes = new CodeDescription();
		codDes.setCode(Constants.RUOLO_CAT);
		codDes.setDescription(Constants.RUOLO_CAT);
		comboRuoli.add(codDes);
		
		return comboRuoli;
	}
	
	public static ArrayList<CodeDescription> getComboTipoInstallazione()
	{
		CodeDescription codDes = new CodeDescription();
		
		ArrayList<CodeDescription> combo = new ArrayList<CodeDescription>();
		
		codDes.setCode(ConvertUtil.convertToString(Constants.ID_TIPO_INST_INSTALLATO));
		codDes.setDescription(Constants.DESC_TIPO_INST_INSTALLATO);
		combo.add(codDes);
		
		codDes = new CodeDescription();
		codDes.setCode(ConvertUtil.convertToString(Constants.ID_TIPO_INST_INDIPENDENTE));
		codDes.setDescription(Constants.DESC_TIPO_INST_INDIPENDENTE);
		combo.add(codDes);
		
		return combo;
	}
	
	public static String gestisciTreeClick(String clickedNodeId, TreeNode root)
	{
		final String ONTREECLICK_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA1_EXTRA = //NOSONAR  Reason:EIAS
				"SCHEDA1_EXTRA"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA1 = //NOSONAR  Reason:EIAS
				"SCHEDA1"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA2 = //NOSONAR  Reason:EIAS
				"SCHEDA2"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA3 = //NOSONAR  Reason:EIAS
				"SCHEDA3"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_1 = //NOSONAR  Reason:EIAS
				"SCHEDA4_1"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_2 = //NOSONAR  Reason:EIAS
				"SCHEDA4_2"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_3 = //NOSONAR  Reason:EIAS
				"SCHEDA4_3"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_4= //NOSONAR  Reason:EIAS
				"SCHEDA4_4"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_5 = //NOSONAR  Reason:EIAS
				"SCHEDA4_5"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_6 = //NOSONAR  Reason:EIAS
				"SCHEDA4_6"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_7 = //NOSONAR  Reason:EIAS
				"SCHEDA4_7"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_8 = //NOSONAR  Reason:EIAS
				"SCHEDA4_8"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA5_1SR = //NOSONAR  Reason:EIAS
				"SCHEDA5_1SR"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA5_1VR = //NOSONAR  Reason:EIAS
				"SCHEDA5_1VR"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA5_2 = //NOSONAR  Reason:EIAS
				"SCHEDA5_2"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA6_4 = //NOSONAR  Reason:EIAS
				"SCHEDA6_4"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA6 = //NOSONAR  Reason:EIAS
				"SCHEDA6"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA7 = //NOSONAR  Reason:EIAS
				"SCHEDA7"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA8 = //NOSONAR  Reason:EIAS
				"SCHEDA8"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_1 = //NOSONAR  Reason:EIAS
				"SCHEDA9_1"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_2 = //NOSONAR  Reason:EIAS
				"SCHEDA9_2"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_3 = //NOSONAR  Reason:EIAS
				"SCHEDA9_3"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_4 = //NOSONAR  Reason:EIAS
				"SCHEDA9_4"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_5 = //NOSONAR  Reason:EIAS
				"SCHEDA9_5"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_6 = //NOSONAR  Reason:EIAS
				"SCHEDA9_6"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA10 = //NOSONAR  Reason:EIAS
				"SCHEDA10"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA12 = //NOSONAR  Reason:EIAS
				"SCHEDA12"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA13 = //NOSONAR  Reason:EIAS
				"SCHEDA13"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA14_1 = //NOSONAR  Reason:EIAS
				"SCHEDA14_1"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA14_2 = //NOSONAR  Reason:EIAS
				"SCHEDA14_2"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA14_3 = //NOSONAR  Reason:EIAS
				"SCHEDA14_3"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA14_4 = //NOSONAR  Reason:EIAS
				"SCHEDA14_4"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA15 = //NOSONAR  Reason:EIAS
				"SCHEDA15"; //NOSONAR  Reason:EIAS
		String ret = null;

		// verifico quale nodo e' stato cliccato (clickedNodeId)

		// recupero il nodo corrispondente all'ID
		TreeNode clickedNode = root.getChildren(clickedNodeId);

		log.debug("HO PREMUTO il NODO: CLICKED NODE: " + clickedNodeId + " ("
				+ (clickedNode != null ? clickedNode.getDescription() : "") + ")");

		if (clickedNodeId.equals("F-scheda1")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA1;
		} else if (clickedNodeId.equals("F-scheda1_0")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA1_EXTRA;
		} else if (clickedNodeId.equals("F-scheda2")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA2;
		} else if (clickedNodeId.equals("F-scheda3")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA3;
		} else if (clickedNodeId.equals("F-scheda4_1")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA4_1;
		} else if (clickedNodeId.equals("F-scheda4_2")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA4_2;
		} else if (clickedNodeId.equals("F-scheda4_3")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA4_3;
		} else if (clickedNodeId.equals("F-scheda4_4")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA4_4;
		} else if (clickedNodeId.equals("F-scheda4_5")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA4_5;
		} else if (clickedNodeId.equals("F-scheda4_6")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA4_6;
		} else if (clickedNodeId.equals("F-scheda4_7")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA4_7;
		} else if (clickedNodeId.equals("F-scheda4_8")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA4_8;
		} else if (clickedNodeId.equals("F-scheda5_1SR")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA5_1SR;
		} else if (clickedNodeId.equals("F-scheda5_1VR")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA5_1VR;
		} else if (clickedNodeId.equals("F-scheda5_2")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA5_2;
		} else if (clickedNodeId.equals("F-scheda6")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA6;
		} else if (clickedNodeId.equals("F-scheda6_4")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA6_4;
		} else if (clickedNodeId.equals("F-scheda7")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA7;
		}	else if (clickedNodeId.equals("F-scheda8")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA8;
		} else if (clickedNodeId.equals("F-scheda9_1")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA9_1;
		} else if (clickedNodeId.equals("F-scheda9_2")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA9_2;
		} else if (clickedNodeId.equals("F-scheda9_3")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA9_3;
		} else if (clickedNodeId.equals("F-scheda9_4")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA9_4;
		} else if (clickedNodeId.equals("F-scheda9_5")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA9_5;
		} else if (clickedNodeId.equals("F-scheda9_6")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA9_6;
		} else if (clickedNodeId.equals("F-scheda10_1")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA10;
		} else if (clickedNodeId.equals("F-scheda12")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA12;
		} else if (clickedNodeId.equals("F-scheda13")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA13;
		} else if (clickedNodeId.equals("F-scheda14_1")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA14_1;
		} else if (clickedNodeId.equals("F-scheda14_2")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA14_2;
		} else if (clickedNodeId.equals("F-scheda14_3")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA14_3;
		} else if (clickedNodeId.equals("F-scheda14_4")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA14_4;
		} else if (clickedNodeId.equals("F-scheda15")) {
			// impostazione del result code 
			ret = ONTREECLICK_OUTCOME_CODE__SCHEDA15;
		} else {
			ret = ONTREECLICK_OUTCOME_CODE__OK;

		}
		
		log.debug("Vado nella pagina: "+ret);
		
		return ret;
	}
	
	public static void gestisciMessaggioSessione(BaseSessionAwareDTO baseDTO, ExecResults result)
	{
		
		log.debug("####Entro in gestisciMessaggioSessione");
		Message msg = (Message) baseDTO.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);
		
		log.debug("msg: "+msg);
		
		if (msg != null) {
			if (msg.getType() == Message.ERROR)
			{
				log.debug("Ho settato sul result (error): "+msg.getText());
				result.getGlobalErrors().add(msg.getText());
				log.debug("Ho settato sul result (error-getGlobalErrors): "+result.getGlobalErrors());
			}
			else
			{
				log.debug("Ho settato sul result (msg): "+msg.getText());
				result.getGlobalMessages().add(msg.getText());
				log.debug("Ho settato sul result (error-getGlobalMessages): "+result.getGlobalMessages());
			}
			
			baseDTO.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
		}
		log.debug("####Esco in gestisciMessaggioSessione");
	}
	
	public static String gestisciTreeIndietro(String paginaChiamante)
	{
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_IMPIANTO = //NOSONAR  Reason:EIAS
				"RIS_RIC_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_AVZ_IMPIANTI = //NOSONAR  Reason:EIAS
				"RIS_RIC_AVZ_IMPIANTI"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__GEST_IMPIANTO = //NOSONAR  Reason:EIAS
				"GEST_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__GEST_IMPIANTO_RESP = //NOSONAR  Reason:EIAS
				"GEST_IMPIANTO_RESP"; //NOSONAR  Reason:EIAS
		String ret = null;
		
		
		if (Constants.PAG_GEST_IMPIANTI.equals(paginaChiamante))
			ret = TORNAPAGINACHIAMANTE_OUTCOME_CODE__GEST_IMPIANTO;
		else if (Constants.PAG_RIS_RIC_AVZ_IMPIANTI.equals(paginaChiamante))
			ret = TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_AVZ_IMPIANTI;
		else if (Constants.PAG_RIS_RIC_IMPIANTI.equals(paginaChiamante))
			ret = TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_IMPIANTO;
		else if (Constants.PAG_GEST_IMPIANTI_RESP.equals(paginaChiamante))
			ret = TORNAPAGINACHIAMANTE_OUTCOME_CODE__GEST_IMPIANTO_RESP;
		else
			ret = TORNAPAGINACHIAMANTE_OUTCOME_CODE__OK;
		
		return ret;
	}
	
	public static TreeNode gestisciTreeLibretto()
	{
		TreeNode root = new TreeNodeBase("root", "root", false);
		//TreeNode root = new TreeNodeBase("root", "root", false, "root", true);
		//root.setExpanded(true);

		// Aggiungo la cartella "Libretto"
		String librettoNodeId = "lib";
		TreeNodeBase libNode = new TreeNodeBase(librettoNodeId, "Libretto", false);
		libNode.setOpened(true);
		root.getChildren().add(libNode);

		/////////////////////////////////////////////////////
		// SCHEDA 1

		
		
		
		// Aggiungo la cartella "Scheda1"
		String schedaNodeId = "S-scheda1";

		TreeNodeBase schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 1", false);
		schedaNode.setOpened(true);

		root.getChildren(librettoNodeId).getChildren().add(schedaNode);

		// Aggiungo la sottoscheda (foglio)
		TreeNodeBase sottoSchedaNode = new TreeNodeBase("F-scheda1", "1 Scheda identificativa impianto", true);

		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda1_0", "1 Dati aggiuntivi", true);

		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		/////////////////////////////////////////////////////
		// SCHEDA 2
		// Aggiungo la cartella "Scheda2"
		schedaNodeId = "S-scheda2";

		schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 2", false);
		schedaNode.setOpened(true);

		root.getChildren(librettoNodeId).getChildren().add(schedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda2", "2 Trattamento acqua", true);
		sottoSchedaNode.setOpened(true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// SCHEDA 3
		// Aggiungo la cartella "Scheda3"
		schedaNodeId = "S-scheda3";

		schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 3", false);
		schedaNode.setOpened(true);

		root.getChildren(librettoNodeId).getChildren().add(schedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda3", "3 Nomina terzo responsabile impianto termico", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// SCHEDA 4
		// Aggiungo la cartella "Scheda4"
		schedaNodeId = "S-scheda4";

		schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 4", false);
		schedaNode.setOpened(true);

		root.getChildren(librettoNodeId).getChildren().add(schedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda4_1", "4.1 Gruppi termici o caldaie (GT)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda4_2", "4.2 Bruciatori (BR)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda4_3", "4.3 Recuperatori / Condensatori lato fumi (RC)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda4_4", "4.4 Macchine frigorifere / Pompe di calore (GF)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda4_5", "4.5 Scambiatori di calore (SC)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda4_6", "4.6 Cogeneratori / Trigeneratori (CG)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda4_7", "4.7 Campi solari termici (CS)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda4_8", "4.8 Altri generatori (AG)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// SCHEDA 5
		// Aggiungo la cartella "Scheda5"
		schedaNodeId = "S-scheda5";

		schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 5", false);
		schedaNode.setOpened(true);

		root.getChildren(librettoNodeId).getChildren().add(schedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda5_1SR", "5.1 Sistemi di regolazione (SR)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda5_1VR", "5.1 Valvole di regolazione (VR)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda5_2", "5 Sistemi di regolazione e contabilizzazione", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// SCHEDA 6
		// Aggiungo la cartella "Scheda6"
		schedaNodeId = "S-scheda6";

		schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 6", false);
		schedaNode.setOpened(true);

		root.getChildren(librettoNodeId).getChildren().add(schedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda6", "6 Sistemi di distribuzione", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda6_4",
				"6.4 Pompe di circolazione (se non incorporate nel generatore) (PO)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// SCHEDA 7
		// Aggiungo la cartella "Scheda7"
		schedaNodeId = "S-scheda7";

		schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 7", false);
		schedaNode.setOpened(true);

		root.getChildren(librettoNodeId).getChildren().add(schedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda7", "7 Sistema di emissione", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// SCHEDA 8
		// Aggiungo la cartella "Scheda8"
		schedaNodeId = "S-scheda8";

		schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 8", false);
		schedaNode.setOpened(true);

		root.getChildren(librettoNodeId).getChildren().add(schedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda8", "8.1 Sistema di accumulo (AC)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// SCHEDA 9
		// Aggiungo la cartella "Scheda9"
		schedaNodeId = "S-scheda9";

		schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 9", false);
		schedaNode.setOpened(true);

		root.getChildren(librettoNodeId).getChildren().add(schedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda9_1", "9.1 Torri evaporative (TE)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda9_2", "9.2 Raffreddatori di liquido (RV)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda9_3", "9.3 Scambiatori di calore intermedi (SCX)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda9_4",
				"9.4 Circuiti interrati a condensazione / espansione diretta (CI)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda9_5", "9.5 Unita' di trattamento aria (UT)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda9_6", "9.6 Recuperatori di calore (aria ambiente) (RC)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// SCHEDA 10
		// Aggiungo la cartella "Scheda10"
		schedaNodeId = "S-scheda10";

		schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 10", false);
		schedaNode.setOpened(true);

		root.getChildren(librettoNodeId).getChildren().add(schedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda10_1",
				"10.1 Impianto di ventilazione meccanica controllata (VM)", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		/*
		// SCHEDA 11
		// Aggiungo la cartella "Scheda11"
		schedaNodeId = "S-scheda11";
		
		schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 11", false);
		schedaNode.setOpened(true);
		
		root.getChildren(librettoNodeId).getChildren().add(schedaNode);
		
		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda11_1", "11.1 Gruppi termici", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
		
		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda11_2", "11.2 Macchine frigo / Pompe di calore", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
		
		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda11_3",
				"11.3 Scambiatori calore sottostazione teleriscaldamento / teleraffrescamento", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
		
		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda11_4", "11.4 Cogeneratori / Trigeneratori", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
		*/

		// SCHEDA 12
		// Aggiungo la cartella "Scheda12"
		schedaNodeId = "S-scheda12";

		schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 12 e Scheda 11", false);
		schedaNode.setOpened(true);

		root.getChildren(librettoNodeId).getChildren().add(schedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda12", "12 Interventi di controllo efficienza energetica",
				true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// SCHEDA 13
		// Aggiungo la cartella "Scheda13"
		schedaNodeId = "S-scheda13";

		schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 13", false);
		schedaNode.setOpened(true);

		root.getChildren(librettoNodeId).getChildren().add(schedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda13",
				"13 Risultati ispezioni periodiche a cura ente competente", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		/////////////////////////////////////////////////////
		// SCHEDA 14
		// Aggiungo la cartella "Scheda14"

		schedaNodeId = "S-scheda14";
		schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 14", false);
		schedaNode.setOpened(true);

		root.getChildren(librettoNodeId).getChildren().add(schedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda14_1", "14.1 Consumo di combustibile", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda14_2", "14.2 Consumo di energia elettrica", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda14_3",
				"14.3 Consumo di acqua di reintegro nel circuito dell'impianto termico", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda14_4",
				"14.4 Consumo di prodotti chimici per il trattamento acqua del circuito dell'impianto termico",
				true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);
		
		// SCHEDA 15
		// Aggiungo la cartella "Scheda15"
		schedaNodeId = "S-scheda15";

		schedaNode = new TreeNodeBase(schedaNodeId, "Scheda 15", false);
		schedaNode.setOpened(true);

		root.getChildren(librettoNodeId).getChildren().add(schedaNode);

		// Aggiungo la sottoscheda (foglio)
		sottoSchedaNode = new TreeNodeBase("F-scheda15",
				"15 Interventi di manutenzione", true);
		root.getChildren(schedaNodeId).getChildren().add(sottoSchedaNode);

		return root;
	}
	
	public static String gestisciTreeReeIndietro(String paginaChiamante)
	{
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__ELENCO_ALLEGATI_IMPIANTO = //NOSONAR  Reason:EIAS
				"ELENCO_ALLEGATI_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RISULTATO_RICERCA_ALLEGATI = //NOSONAR  Reason:EIAS
				"RISULTATO_RICERCA_ALLEGATI"; //NOSONAR  Reason:EIAS
		String ret = null;
		
		if (Constants.ARRIVO_DA_IMPIANTO.equals(paginaChiamante))
			ret = TORNAPAGINACHIAMANTE_OUTCOME_CODE__ELENCO_ALLEGATI_IMPIANTO;
		else if (Constants.ARRIVO_DA_ALLEGATI.equals(paginaChiamante))
			ret = TORNAPAGINACHIAMANTE_OUTCOME_CODE__RISULTATO_RICERCA_ALLEGATI;
		
		return ret;
	}
	
	public static String getStringaTxtToHtml(String html) {
		return html.replace(Constants.VALUE_ENTER_HTML, Constants.VALUE_ENTER_TXT);
		
	}
	
	public static String getMsgFormatterHtml(ResultInvioMail resultInvioMail, String messaggio)
	{
		StringBuffer msg = new StringBuffer();
		if (messaggio != null)
		{
			msg.append(messaggio);
		}
		
		msg.append(Constants.VALUE_ENTER_HTML);
//		StringBuffer msg = new StringBuffer(Messages.INFO_ALLEGATO_RESPINTO_CORRETTAMENTE
//				+ "<br>");
		
		// INIZIO PROVA
		/*
		if (resultInvioMail == null)
		{
			resultInvioMail = new ResultInvioMail();
		}
		
		resultInvioMail.addDestinatarioOK("beppe@libero.it");
		resultInvioMail.addDestinatarioOK("beppeto@libero.it");

		resultInvioMail.addDestinatarioKO("beppeto@pippo.libero.it");
		resultInvioMail.addDestinatarioKO("beppeto@.tilibero.it");
		*/
		// FINE PROVA

		if (GenericUtil.isNotNullOrEmpty(resultInvioMail)) 
		{

			
			if (resultInvioMail.getFormatDestinatariOK() != null) {
				
				msg.append(new Message(Messages.INFO_INDIRIZZI_MAIL_OK, resultInvioMail.getFormatDestinatariOK()).getText());
//				msg.append(Messages.INFO_INDIRIZZI_MAIL_OK);
//				msg.append(resultInvioMail.getFormatDestinatariOK());
			}

			

			if (resultInvioMail.getFormatDestinatariKO() != null) {
				msg.append(Constants.VALUE_ENTER_HTML);
				msg.append(new Message(Messages.INFO_INDIRIZZI_MAIL_KO, resultInvioMail.getFormatDestinatariKO()).getText());

//				msg.append(Messages.INFO_INDIRIZZI_MAIL_KO);
//				msg.append(resultInvioMail.getFormatDestinatariKO());
			}

		} 
		else
		{
			msg.append(Messages.INFO_NESSUNA_MAIL_INVIATA);
		}
		
		return msg.toString();
	}
	
	public static Integer getByteToMb(Integer mb)
	{
		return mb * Constants.MB_IN_BYTE;
	}
	
	public static boolean checkIsNotInteger(String s) {
	    try { 
	    	String temp = s.replaceAll("[.]","");
	    	
	        Integer.parseInt(temp); 
	    } catch(NumberFormatException e) { 
	        return true; 
	    } catch(NullPointerException e) {
	        return true;
	    }
	    return false;
	}
	
	public static boolean checkIsValidYear(String s) {
		if(Pattern.compile("^(19|20)[0-9][0-9]").matcher(s).find()) {
		       // The string is not valid.
		       return false;
		   }

		   // The string is valid.
		   return true;
	}
	
	public static boolean isUtenteAbilModLibWeb(UtenteLoggato utente)
	{
		boolean ret = false;
		
		String descrizioneRuolo = utente.getRuolo().getDescRuolo();

		if (!descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_CONSULTATORE) &&
			!descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO) &&
			!descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO_IMPRESA)) {
			ret = true;
		}
		return ret;
	}
	
	public static String getTipoComponente(String descComponente) {
		
		StringTokenizer st = new StringTokenizer(descComponente,Constants.INTERVAL_SEP);
		
		// questo e' il tipo componente
		String comp = st.nextToken();
		
		return comp;
	}
	
	public static Integer getProgrComponente(String descComponente) {
		
		StringTokenizer st = new StringTokenizer(descComponente,Constants.INTERVAL_SEP);
		
		// questo e' il tipo componente
		st.nextToken();
		
		// questo e' il progressivo componente
		String comp = st.nextToken();
		
		return ConvertUtil.convertToInteger(comp);
	}

	// Questometodo viene richiamato dall'MDD (DeclarativeUIConstraints), quindi non bisogna toglierlo!
	public static boolean isUtenteAutorLibWebScheda3(UtenteLoggato utente) {

		boolean ret = false;

		String descrizioneRuolo = utente.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_3RESPONSABILE) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE) || 
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)) 
		{
			ret = true;
		}

		return ret;
	}

	// Questometodo viene richiamato dall'MDD (DeclarativeUIConstraints), quindi non bisogna toglierlo!
	public static boolean isUtenteAutorLibWebScheda4(UtenteLoggato utente) {

		boolean ret = false;

		String descrizioneRuolo = utente.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_IMPRESA) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) 
		{
			ret = true;
		}

		return ret;
	}

	// Questometodo viene richiamato dall'MDD (DeclarativeUIConstraints), quindi non bisogna toglierlo!
	public static boolean isUtenteAutorLibWebScheda5_1(UtenteLoggato utente) {

		boolean ret = false;

		String descrizioneRuolo = utente.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_IMPRESA) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) 
		{
			ret = true;
		}

		return ret;
	}
	
	public static boolean isUtenteAutorLibWebScheda5(UtenteLoggato utente) {

		boolean ret = false;

		String descrizioneRuolo = utente.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_IMPRESA) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) 
		{
			ret = true;
		}

		return ret;
	}

	// Questometodo viene richiamato dall'MDD (DeclarativeUIConstraints), quindi non bisogna toglierlo!
	public static boolean isUtenteAutorLibWebScheda6_4(UtenteLoggato utente) {

		boolean ret = false;

		String descrizioneRuolo = utente.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_IMPRESA) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) 
		{
			ret = true;
		}

		return ret;
	}
	
	public static boolean isUtenteAutorLibWebScheda6(UtenteLoggato utente) {

		boolean ret = false;

		String descrizioneRuolo = utente.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_IMPRESA) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) 
		{
			ret = true;
		}

		return ret;
	}
	
	public static boolean isUtenteAutorLibWebScheda7(UtenteLoggato utente) {

		boolean ret = false;

		String descrizioneRuolo = utente.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_IMPRESA) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) 
		{
			ret = true;
		}

		return ret;
	}

	// Questometodo viene richiamato dall'MDD (DeclarativeUIConstraints), quindi non bisogna toglierlo!
	public static boolean isUtenteAutorLibWebScheda8(UtenteLoggato utente) {

		boolean ret = false;

		String descrizioneRuolo = utente.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_IMPRESA) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) 
		{
			ret = true;
		}

		return ret;
	}
	
	/**
	 * controlla che un utente matchi o meno un particolare ruolo
	 * @param utente
	 * @param roles: lista di ruoli
	 * @param mandatoryRoles: flag per attivare i ruoli obbligatori
	 * @param includeRole: indica se la lista dei ruoli in input deve matchare o no il ruolo utente
	 * @return
	 */
	public static boolean checkValidRole (UtenteLoggato utente, List<String> roles, boolean mandatoryRoles, boolean includeRole) {
		String descrizioneRuolo = utente.getRuolo().getDescRuolo();
		
		if (roles == null || roles.isEmpty()) {
			return !mandatoryRoles;
		} else {
			if (includeRole) {
				return roles.contains(descrizioneRuolo);
			} else {
				return !roles.contains(descrizioneRuolo);
			}
		}
	}

	// Questometodo viene richiamato dall'MDD (DeclarativeUIConstraints), quindi non bisogna toglierlo!
	public static boolean isUtenteAutorLibWebScheda9(UtenteLoggato utente) {

		boolean ret = false;

		String descrizioneRuolo = utente.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_IMPRESA) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) 
		{
			ret = true;
		}

		return ret;
	}

	// Questometodo viene richiamato dall'MDD (DeclarativeUIConstraints), quindi non bisogna toglierlo!
	public static boolean isUtenteAutorLibWebScheda10(UtenteLoggato utente) {

		boolean ret = false;

		String descrizioneRuolo = utente.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_IMPRESA) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) 
		{
			ret = true;
		}

		return ret;
	}

	// Questometodo viene richiamato dall'MDD (DeclarativeUIConstraints), quindi non bisogna toglierlo!
	public static boolean isUtenteAutorLibWebScheda15(UtenteLoggato utente) {

		boolean ret = false;

		String descrizioneRuolo = utente.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_IMPRESA) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER) ||
				descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) 
		{
			ret = true;
		}

		return ret;
	}

	public static String getMinMedMaxFormat(String min, String med, String max) {
		
		return getStringSpazioValid(min) + Constants.INTERVAL_SEP_SLASH + getStringSpazioValid(med) + Constants.INTERVAL_SEP_SLASH + getStringSpazioValid(max);
	}

	public static String getMinMaxFormat(String min, String max) {
		
		return getStringSpazioValid(min) + Constants.INTERVAL_SEP_SLASH + getStringSpazioValid(max);
	}

	public static String getMinMaxFormat(BigDecimal min, BigDecimal max) {
		
		return getStringSpazioValid(ConvertUtil.convertToString(min)) + Constants.INTERVAL_SEP_SLASH + getStringSpazioValid(ConvertUtil.convertToString(max));
	}

	public static String getMinMedMaxFormat(BigDecimal min, BigDecimal med, BigDecimal max) {
		
		return getStringSpazioValid(ConvertUtil.convertToString(min)) + Constants.INTERVAL_SEP_SLASH + getStringSpazioValid(ConvertUtil.convertToString(med)) + Constants.INTERVAL_SEP_SLASH + getStringSpazioValid(ConvertUtil.convertToString(max));
	}

	public static String getStringSpazioValid(String s) {
		
		if (isNotNullOrEmpty(s))
		{
			return s;
		}
		else
		{
			return "&emsp;";
		}
		
	}
	
	public static String getDescFlgModFunzionamento(String idMod) {
		String desc = null;
		if (Constants.FLG_RAFFREDDAMENTO.equals(idMod))
		{
			desc = Constants.DESC_FLG_RAFFREDDAMENTO;
		}
		else if (Constants.FLG_RISCALDAMENTO.equals(idMod))
		{
			desc = Constants.DESC_FLG_RISCALDAMENTO;
		}
		
		return desc;
	}
	
	/**
	 * metodo che data una enum permette di costruire un array di CodeDescription. L'enum deve avere un attributo "descrizione" ed opzionalmente un attributo "codice" 
	 * per la costruzione della coppia code/description (in assenza dell'attributo "codice" verra' usato il name dell'enum) 
	 * @param enumName
	 * @return
	 */
	public static ArrayList<CodeDescription> getComboValues (String enumName ) {
		ArrayList<CodeDescription> comboValues = new ArrayList<CodeDescription>();
		
		Class<Enum> c;
		try {
			c = (Class<Enum>)Class.forName(enumName);
			Method getCodiceMethod = null;
			Method getDescrizioneMethod = null;
			try {
				getDescrizioneMethod = c.getDeclaredMethod("getDescrizione");
				getCodiceMethod = c.getDeclaredMethod("getCodice");
			} catch (Exception e1) {
				if (getCodiceMethod == null && getDescrizioneMethod == null) {
					return null;
				}
			}
			for (Enum e : c.getEnumConstants()) {
				CodeDescription comboValue = new CodeDescription();
				Object oDescrizione = getDescrizioneMethod.invoke(e);
				Object oCodice = e.name();
				if (getCodiceMethod != null) {
					oCodice = getCodiceMethod.invoke(e);
				}
				comboValue.setCode(oCodice.toString());
				comboValue.setDescription(oDescrizione.toString());
				comboValues.add(comboValue);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			return null;
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
			return null;
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
			return null;
		}
		
		return comboValues;
		
	}

	/**
	 * metodo che data una enum permette di costruire un array di CodeDescription. L'enum deve avere un attributo "descrizione" ed opzionalmente un attributo "codice" 
	 * per la costruzione della coppia code/description (in assenza dell'attributo "codice" verra' usato il name dell'enum) 
	 * @param enumName
	 * @return
	 */
	public static ArrayList<IdDescription> getComboIdValues (String enumName ) {
		ArrayList<IdDescription> comboValues = new ArrayList<IdDescription>();
		Class<Enum> c;
		try {
			c = (Class<Enum>)Class.forName(enumName);
			Method getCodiceMethod = null;
			Method getDescrizioneMethod = null;
			try {
				getDescrizioneMethod = c.getDeclaredMethod("getDescrizione");
				getCodiceMethod = c.getDeclaredMethod("getId");

			} catch (Exception e1) {
				if (getCodiceMethod == null && getDescrizioneMethod == null) {
					return null;
				}
			}
			for (Enum e : c.getEnumConstants()) {
				IdDescription comboValue = new IdDescription();
				Object oDescrizione = getDescrizioneMethod.invoke(e);
				Object oCodice = e.name();
				if (getCodiceMethod != null) {
					oCodice = getCodiceMethod.invoke(e);
				}
				comboValue.setId((Integer)oCodice);
				comboValue.setDescription(oDescrizione.toString());
				comboValues.add(comboValue);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			return null;
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
			return null;
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
			return null;
		}
		
		return comboValues;
		
	}
	
	public static StringBuffer gestisciDescrizione(StringBuffer sb, String desc)
	{
		if (sb == null)
		{
			sb = new StringBuffer();
		}
		else
		{
			sb.append(", ");
		}
		
		sb.append(desc);
		
		return sb;
	}

	/**
	 * Normalizza una stringa trasformandola nella corrispettiva stringa tutta
	 * in maiuscolo
	 * 
	 * @param s
	 *            Stringa da normalizzare
	 * @return Stringa normalizzata
	 */
	public static String normalizeString(String s) {
		return (s == null ? null : s.toUpperCase());
	}
	
	public static String getDescSezioneEComp(String tipoComp, String nProgressivo) {
		
		return getDescSezioneComp(tipoComp, ConvertUtil.convertToBigDecimal(nProgressivo), Constants.LABEL_SEZIONE_E);
	}
	
	public static String getDescSezioneRPComp(String tipoComp, String nProgressivo) {
		
		return getDescSezioneComp(tipoComp, ConvertUtil.convertToBigDecimal(nProgressivo), Constants.LABEL_SEZIONE_RP_DET);
	}
	
	public static String getDescSezioneComp(String tipoComp, BigDecimal nProgressivo, String prefisso) {
		String desc = null;
		
		desc = prefisso + " - " + tipoComp + "-" + nProgressivo;
		
		return desc;
	}

	public static String getDescSezioneComp(String tipoComp, BigInteger nProgressivo) {
		String desc = null;
		
		desc = tipoComp + Constants.INTERVAL_SEP + nProgressivo;
		
		return desc;
	}
	
	
	

	public static Documento getDocumentoById(Integer idDocumentoSelez, ArrayList<Documento> documentiList)
	{
		Documento doc = null;
		
		if (idDocumentoSelez != null && documentiList != null && documentiList.size() > 0)
		{
			for (Documento documento : documentiList) {
				if (idDocumentoSelez.intValue() == documento.getIdDocumento().intValue())
				{
					doc = documento;
					break;
				}
			}
		}
		
		return doc;
	}
	
	public static Documento getDocumentoById(String idLibrettoSelez, ArrayList<LibrettoDett> librettiList)
	{
		Documento doc = null;
		
		if (idLibrettoSelez != null && librettiList != null && librettiList.size() > 0)
		{
			for (LibrettoDett libretto : librettiList) {
				
				log.debug("Cerco il libretto idLibrettoSelez: "+idLibrettoSelez);
				log.debug("Confronto con "+libretto.getIdLibretto()+" - ris: "+idLibrettoSelez.equals(ConvertUtil.convertToString(libretto.getIdLibretto())));
				
				if (idLibrettoSelez.equals(ConvertUtil.convertToString(libretto.getIdLibretto())))
				{
					doc = new Documento();
					doc.setNomeDocOrig(ReplaceSpecialCharUtils.sanitize(libretto.getNomeDocumento()));
					doc.setUidIndex(ReplaceSpecialCharUtils.sanitize(libretto.getUid()));
					break;
				}
			}
		}
		
		return doc;
	}
	
	public static boolean isObjPopulate(Object obj) {
		//METODO CHE CONTROLLA SE C'E' ALMENO UN ATTRIBUTO DELL'OGGETTO IN INPUT SETTATO
		//QUESTO METODO PUO' ESSERE USATO PER VERIFICARE SE UN FORM DI RICERCA E' STATO POPOLATO
		if (obj == null) {
			return false;
		} 
		
		Method[] methods = obj.getClass().getDeclaredMethods();
		if (methods == null) {
			return false;
		}
		
		for (Method method : methods) {
			if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
				try {
					Object fieldValue = method.invoke(obj);
					if (fieldValue instanceof String) {
						if (!StringUtils.isEmpty((String) fieldValue)) {
							return true;
						}
					} else if (fieldValue instanceof Boolean) {
						if ((Boolean) fieldValue != null && (Boolean) fieldValue) {
							return true;
						}
					} else if (fieldValue != null) {
						return true;
					}
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}
		}
		
		return false;
	}
	
	public static String getDescComponentiNonComp(List<SigitTComp4Dto> compNonControllate) {
		StringBuffer desc = null;
		
		for (SigitTComp4Dto dto : compNonControllate) {
			
			if (desc == null)
			{
				desc = new StringBuffer();
			}
			else
			{
				desc.append(", ");
			}
			
			desc.append(dto.getIdTipoComponente() + Constants.INTERVAL_SEP + dto.getProgressivo());
		}
		
		return desc!=null?desc.toString():"";
	}
	
	public static boolean isUtenteAbilitatoModRee(UtenteLoggato utenteLoggato)
	{
		String descrizioneRuolo = utenteLoggato.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equals(Constants.RUOLO_SUPER)
				|| descrizioneRuolo.equals(Constants.RUOLO_IMPRESA)
				|| descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)) {
			
			return true;
		} else {
			
			return false;
		}
		
	}
	
	public static boolean isUtenteAbilitatoRapProva (UtenteLoggato utenteLoggato)
	{
		
		log.debug("GenericUtil.isUtenteAbilitatoRapProva? : "+ utenteLoggato.getCodiceFiscale());
		
		String descrizioneRuolo = utenteLoggato.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)
				|| descrizioneRuolo.equals(Constants.RUOLO_SUPER)) {
			
			log.debug("GenericUtil.isUtenteAbilitatoRapProva? - POSSO");
			return true;
		} else {
			
			log.debug("GenericUtil.isUtenteAbilitatoRapProva? - NON POSSO");
			return false;
		}
	}

	public static boolean isUtenteAbilitatoVisualizzaRapProva (UtenteLoggato utenteLoggato)
	{

		log.debug("GenericUtil.isUtenteAbilitatoRapProva? : "+ utenteLoggato.getCodiceFiscale());

		String descrizioneRuolo = utenteLoggato.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)
				|| descrizioneRuolo.equals(Constants.RUOLO_SUPER) ||
				descrizioneRuolo.equals(Constants.RUOLO_CONSULTATORE)) {

			log.debug("GenericUtil.isUtenteAbilitatoRapProva? - POSSO");
			return true;
		} else {

			log.debug("GenericUtil.isUtenteAbilitatoRapProva? - NON POSSO");
			return false;
		}
	}
	
	public static boolean isUtenteAbilitatoRicercaVerificheAccertamentiIspezioniSanzioni (UtenteLoggato utenteLoggato) 
	{
		log.debug("GenericUtil.isUtenteAbilitatoRicercaVerificheAccertamentiIspezioniSanzioni? : "+ utenteLoggato.getCodiceFiscale());

		Ruolo ruolo = utenteLoggato.getRuolo();
		
		String descrizioneRuolo = ruolo.getDescRuolo();

		if (descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)
				|| descrizioneRuolo.equals(Constants.RUOLO_SUPER)
				|| descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)
				|| (descrizioneRuolo.equals(Constants.RUOLO_CONSULTATORE))) {
			//|| (descrizioneRuolo.equals(Constants.RUOLO_CONSULTATORE) && ruolo.getIstatAbilitazione().length() == 2)) { // E' stato chiesto da Mary di eliminare la limitazione sull'Istat
			
			log.debug("GenericUtil.isUtenteAbilitatoRicercaVerificheAccertamentiIspezioniSanzioni? - POSSO");
			return true;
		} else {
			log.debug("GenericUtil.isUtenteAbilitatoRicercaVerificheAccertamentiIspezioniSanzioni? - NON POSSO");
			return false;
		}
	}
	
	public static String getModelloModolAllegato(String idTipoDocumento){
		String value = "";
		if(Constants.ALLEGATO_TIPO_1.equalsIgnoreCase(idTipoDocumento)){
			value = Constants.CODICE_MODULO_MODOL_ALLEGATO_II;
		}else if(Constants.ALLEGATO_TIPO_2.equalsIgnoreCase(idTipoDocumento)){
			value = Constants.CODICE_MODULO_MODOL_ALLEGATO_III;
		}else if(Constants.ALLEGATO_TIPO_3.equalsIgnoreCase(idTipoDocumento)){
			value = Constants.CODICE_MODULO_MODOL_ALLEGATO_IV;
		}else if(Constants.ALLEGATO_TIPO_4.equalsIgnoreCase(idTipoDocumento)){
			value = Constants.CODICE_MODULO_MODOL_ALLEGATO_V;
		}
		return value;
	}

	public static boolean isDocCancellabile(Integer idDocSelez, ArrayList<Documento> documenti){
		boolean isCancellabile = false;
		
		for (Documento documento : documenti) {
			if (idDocSelez.intValue() == documento.getIdDocumento().intValue())
			{
				isCancellabile = documento.getDescStatoDocumento().equalsIgnoreCase(Constants.DESC_STATO_DOC_ATTIVO);
			}
		}
		
		return isCancellabile;
	}
	
	public static String getToponimo(String indirizzoCompleto) {
		
		StringTokenizer st = new StringTokenizer(indirizzoCompleto,Constants.INTERVAL_BLANK);
		
		// questo e' il toponimo
		String toponimo = st.nextToken();
		
		return toponimo;
	}
	
	public static String getIndirizzo(String indirizzoCompleto) {

		StringTokenizer st = new StringTokenizer(indirizzoCompleto,Constants.INTERVAL_BLANK);

		// questo e' il toponimo
		st.nextToken();

		// questo e' l'indirizzo vero e proprio
		StringBuffer indirizzo = null;

		while(st.hasMoreTokens()) {
			
			if (indirizzo == null)
			{
				indirizzo = new StringBuffer();
			}
			else
			{
				indirizzo.append(Constants.INTERVAL_BLANK);
			}
			
			indirizzo.append(st.nextToken());
		}

		return indirizzo.toString();
	}
	
	public static boolean isIndirizzoCompleto(String indirizzoCompleto) {
		
		StringTokenizer st = new StringTokenizer(indirizzoCompleto,Constants.INTERVAL_BLANK);
		
		int numToken = st.countTokens();
		
		if (numToken > 1)
		{
			// L'indirizzo e' composto da almento 2 parti, si spera toponimo + indirizzo
			return true;
		}
		else
		{
			// L'indirizzo NON e' composto da almento 2 parti, dovrebbe essere almeno toponimo + indirizzo
			return false;
		}
		
	}

	public static ArrayList<IdDescription> getComboTipoSubentro()
	{
		return getComboIdValues(TipoSubentroEnum.class.getName());
	}

	public static boolean getCheckSi(BigDecimal valoreCampo)
	{
		return new BigDecimal(Constants.SI_1).equals(valoreCampo);
	}

	public static boolean getCheckNo(BigDecimal valoreCampo)
	{
		return new BigDecimal(Constants.NO_0).equals(valoreCampo);
	}

	public static boolean getCheckNc(BigDecimal valoreCampo)
	{
		return new BigDecimal(Constants.NC_2).equals(valoreCampo);
	}

	public static boolean getCheck(String fk, int chiave)
	{
		if (fk != null)
		{
			return getCheck(ConvertUtil.convertToInteger(fk), chiave);
		}
		else
			return false;
		
	}

	public static boolean getCheck(Integer fk, int chiave)
	{
		if (fk != null)
		{
			return fk == chiave;
		}
		else
			return false;
		
	}

	public static boolean getCheck(String fk, String chiave)
	{
		if (fk != null)
		{
			return fk.equalsIgnoreCase(chiave);
		}
		else
			return false;
		
	}

	public static String getDataCompleta() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
		return sdf.format(new Date());
	}
	
	public static String capitalizeToLowerCase(String str) {
		
		if (str == null) {
			return null;
		}
		
		return StringUtils.capitalize(str.toLowerCase());
	}
	
	public static String aggiungiCodIstatPiemonteAIstatAbilitazione(String istatAbilitazione) {
		int istatAbilitazioneLength = istatAbilitazione.length();
		if (istatAbilitazioneLength == 3 || istatAbilitazioneLength == 6) {
			istatAbilitazione = "01" + istatAbilitazione;
		}
		
		return istatAbilitazione;
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
	
	public static boolean isRuoloAbilitatoAccessoImpianti(UtenteLoggato utente) {
		
		AbilitazioniRuoloFunz abilitazioniRuoloFunz = utente.getAbilitazioniRuoloFunz();

		if (abilitazioniRuoloFunz != null && abilitazioniRuoloFunz.getFlgImpianto()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isRuoloAbilitatoAccessoRicercaImpiantiAvanzata(UtenteLoggato utente) {
		
		AbilitazioniRuoloFunz abilitazioniRuoloFunz = utente.getAbilitazioniRuoloFunz();
		if (abilitazioniRuoloFunz != null && abilitazioniRuoloFunz.getFlgRicercaAvanzataImpianto()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isRuoloAbilitatoAccessoRicercaAllegati(UtenteLoggato utente) {
		
		AbilitazioniRuoloFunz abilitazioniRuoloFunz = utente.getAbilitazioniRuoloFunz();

		if (abilitazioniRuoloFunz != null && abilitazioniRuoloFunz.getFlgAllegato()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isRuoloAbilitatoAccessoSubentro(UtenteLoggato utente) {
		
		AbilitazioniRuoloFunz abilitazioniRuoloFunz = utente.getAbilitazioniRuoloFunz();

		if (abilitazioniRuoloFunz != null && abilitazioniRuoloFunz.getFlgSubentro()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isRuoloAbilitatoAccessoDelega(UtenteLoggato utente) {
		
		AbilitazioniRuoloFunz abilitazioniRuoloFunz = utente.getAbilitazioniRuoloFunz();

		if (abilitazioniRuoloFunz != null && abilitazioniRuoloFunz.getFlgDelega()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isRuoloAbilitatoAccessoNomina3Responsabile(UtenteLoggato utente) {
		
		AbilitazioniRuoloFunz abilitazioniRuoloFunz = utente.getAbilitazioniRuoloFunz();
		if (abilitazioniRuoloFunz != null && abilitazioniRuoloFunz.getFlg3responsabile()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isRuoloAbilitatoAccessoImportMassivoAllegato(UtenteLoggato utente) {
		
		AbilitazioniRuoloFunz abilitazioniRuoloFunz = utente.getAbilitazioniRuoloFunz();
		if (abilitazioniRuoloFunz != null && abilitazioniRuoloFunz.getFlgImportMassAllegato()) {
			return true;
		} else {
			return false;
		}
	} 
	
	public static boolean isRuoloAbilitatoAccessoDatiDistributore(UtenteLoggato utente) {
		
		AbilitazioniRuoloFunz abilitazioniRuoloFunz = utente.getAbilitazioniRuoloFunz();
		Ruolo ruolo = utente.getRuolo();
		String descrizioneRuolo = ruolo.getDescRuolo();
		
		if ((abilitazioniRuoloFunz != null && abilitazioniRuoloFunz.getFlgDistributore())
				|| (descrizioneRuolo.equals(Constants.RUOLO_CONSULTATORE) && ruolo.getIstatAbilitazione().length() == 2)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isRuoloAbilitatoAccessoIncaricoCat(UtenteLoggato utente) {
		
		AbilitazioniRuoloFunz abilitazioniRuoloFunz = utente.getAbilitazioniRuoloFunz();
		if (abilitazioniRuoloFunz != null && abilitazioniRuoloFunz.getFlgIncaricoCat()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isRuoloAbilitatoAccessoDatiImpresa(UtenteLoggato utente) {
		
		AbilitazioniRuoloFunz abilitazioniRuoloFunz = utente.getAbilitazioniRuoloFunz();
		if (abilitazioniRuoloFunz != null && abilitazioniRuoloFunz.getFlgImpresa()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isRuoloAbilitatoAccessoLibrettoWEB(UtenteLoggato utente) {
		
        String[] ruoliAmmessi = {
                Constants.RUOLO_IMPRESA, 
                Constants.RUOLO_RESPONSABILE, 
                Constants.RUOLO_RESPONSABILE_IMPRESA,
                Constants.RUOLO_PROPRIETARIO, 
                Constants.RUOLO_PROPRIETARIO_IMPRESA,
                Constants.RUOLO_3RESPONSABILE,
                Constants.RUOLO_SUPER,
                Constants.RUOLO_VALIDATORE,
                Constants.RUOLO_ISPETTORE,
                Constants.RUOLO_CONSULTATORE
                };
        
        return checkValidRole(utente, Arrays.asList(ruoliAmmessi) , true, true); 
	}
	
	public static boolean isRuoloAbilitatoAccessoReeWEB(UtenteLoggato utente) {
		
        String[] ruoliAmmessi = {
                Constants.RUOLO_IMPRESA,
                Constants.RUOLO_SUPER,
                Constants.RUOLO_VALIDATORE
                };
        
        return checkValidRole(utente, Arrays.asList(ruoliAmmessi) , true, true); 
	}
	
	public static boolean isRuoloAbilitatoAccessoDocumentazioneReeWEB(UtenteLoggato utente) {
		
        String[] ruoliAmmessi = {
                Constants.RUOLO_IMPRESA,
                Constants.RUOLO_SUPER,
                Constants.RUOLO_VALIDATORE,
                Constants.RUOLO_ISPETTORE,
                Constants.RUOLO_CONSULTATORE
                };
        
        return checkValidRole(utente, Arrays.asList(ruoliAmmessi) , true, true); 
	}
	
	public static boolean isRuoloAbilitatoAccessoRicercaSveglie(UtenteLoggato utente) {
		
        String[] ruoliAmmessi = {
        		Constants.RUOLO_SUPER, 
        		Constants.RUOLO_VALIDATORE, 
        		Constants.RUOLO_ISPETTORE
                };
        
        return checkValidRole(utente, Arrays.asList(ruoliAmmessi) , true, true); 
	}
	
	public static boolean isRuoloAbilitatoInserimentoAzioneSvegliaIspezioneSanzione(UtenteLoggato utente) {
		
        String[] ruoliAmmessi = {
        		Constants.RUOLO_SUPER, 
        		Constants.RUOLO_VALIDATORE, 
        		Constants.RUOLO_ISPETTORE
                };
        
        return checkValidRole(utente, Arrays.asList(ruoliAmmessi) , true, true); 
	}
	
	public static boolean isRuoloAbilitatoAccessoBackOffice(UtenteLoggato utente) {
		
        return checkValidRole(utente, Arrays.asList(Constants.RUOLO_SUPER) , true, true); 
	}
	
	public static boolean isRuoloAbilitatoAccessoGeneraToken(UtenteLoggato utente) {
		
        return checkValidRole(utente, Arrays.asList(Constants.RUOLO_SUPER, Constants.RUOLO_IMPRESA) , true, true) 
        		&& !ConvertUtil.convertToBooleanAllways(utente.getRuolo().getIsCat()); 
	}
	
	public static void redirectToPage(String page) throws IOException {
		
		HttpServletRequest request = ServletActionContext.getRequest();

		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.sendRedirect(request.getContextPath() + "/" + page);
	}
	
	public static void redirectToNotAllowedPage() throws IOException {
		redirectToPage("base/notAllowed.do");
	}
	
}