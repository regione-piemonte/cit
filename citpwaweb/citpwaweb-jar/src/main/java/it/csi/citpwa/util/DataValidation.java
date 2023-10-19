/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */
package it.csi.citpwa.util;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {

	public static boolean validateEmail(String email) {
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(email);
		return m.find();
	}

	public static boolean validateString(String data) {
		Pattern p = Pattern.compile("/^[A-Za-z]+$/");
		Matcher m = p.matcher(data);
		return m.find();
	}

	public static boolean validateCf(String cf) {
		cf = cf!=null?cf.toUpperCase(Locale.ROOT):null;
		Pattern p = Pattern.compile("^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$");
		Matcher m = p.matcher(cf);
		return m.find();
	}

	public static boolean validateNumber(String phoneNumber) {
		Pattern p = Pattern.compile("[+-]?([0-9]*[.])?[0-9]+");
		Matcher m = p.matcher(phoneNumber);
		return m.find();
	}

	public static boolean validatePiva(String cfpiva) {
		Pattern p = Pattern.compile("^[0-9]{11}$");
		Matcher m = p.matcher(cfpiva);
		return m.find();
	}
}
