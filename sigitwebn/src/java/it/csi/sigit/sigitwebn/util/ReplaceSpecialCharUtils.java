package it.csi.sigit.sigitwebn.util;

public class ReplaceSpecialCharUtils {

	/*TODO $ non effettua replace se non escape*/	
	private static final String REGEX_ELENCO_CARATTERI_AMMESSI = "[^\\ A-Za-z0-9אטילעש\\-_+\\/.,:;!\"&()=?'°@]";

		public static String sanitize(String input) {
			if (input == null) {
	            return null;
	        }
			input = input.replaceAll(REGEX_ELENCO_CARATTERI_AMMESSI, ""); 
	        return 	input;
		}
}
