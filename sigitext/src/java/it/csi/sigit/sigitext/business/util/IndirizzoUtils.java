package it.csi.sigit.sigitext.business.util;

import java.util.ArrayList;
import java.util.List;

public class IndirizzoUtils {
	public static String formattaIndirizzo(String indirizzo, String civico, String comune, String provincia) {
		List<String> viaParts = new ArrayList<>();

		if (indirizzo != null) {
			viaParts.add(indirizzo);
		}

		if (civico != null) {
			viaParts.add(civico);
		}

		List<String> comuneParts = new ArrayList<>();

		if (comune != null) {
			comuneParts.add(comune);
		}

		if (provincia != null) {
			comuneParts.add("(" + provincia + ")");
		}

		List<String> indirizzoParts = new ArrayList<>();

		if (viaParts.size() > 0) {
			indirizzoParts.add(String.join(" ", viaParts));
		}

		if (comuneParts.size() > 0) {
			indirizzoParts.add(String.join(" ", comuneParts));
		}

		return indirizzoParts.size() > 0 ? String.join(", ", indirizzoParts) : "-";
	}
}
