package it.csi.sigit.elencom.presentation.elencom.security;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import flexjson.JSONDeserializer;
import flexjson.locators.TypeLocator;
import it.csi.sigit.elencom.presentation.elencom.action.*;

public class ConstraintFactory {
	private static JSONDeserializer<UISecConstraint> deser = new JSONDeserializer<UISecConstraint>();
	private static final String RESOURCE_BASE = "/it/csi/sigit/elencom/presentation/elencom/action";

	static final ConstraintFactory INSTANCE = new ConstraintFactory();

	static final Map<String, UISecConstraint> ctrCache = new HashMap<String, UISecConstraint>();

	public static ConstraintFactory getInstance() {
		return INSTANCE;
	}

	static {
		// INIT....

	}

	private static String makeKey(String moduleName, String cpName, String widgetName, String constrainedBehavior) {
		return moduleName + "/" + cpName + "/" + widgetName + "/" + constrainedBehavior;
	}

	public UISecConstraint buildCtrStructure_internal(String moduleName, String cpName, String widgetName,
			String constrainedBehavior) throws CommandExecutionException {
		String key = makeKey(moduleName, cpName, widgetName, constrainedBehavior);
		UISecConstraint ctr = ctrCache.get(key);
		if (ctr != null) {
			return ctr;
		} else {
			String resource = RESOURCE_BASE;

			resource = resource + "/" + moduleName + "/constraints/" + cpName + "/" + widgetName + "_"
					+ constrainedBehavior + "_constraints.json";

			InputStream is = getClass().getResourceAsStream(resource);
			if (is != null) {
				InputStreamReader isReader = new InputStreamReader(is);
				try {
					ctr = deser.deserialize(isReader);
				} catch (Exception e) {
					throw new CommandExecutionException(
							"Errore nella lettura della struttura di constraints, key=" + key + ", risorsa:" + resource,
							e);
				}
				ctrCache.put(key, ctr);
				return ctr;
			} else {
				throw new CommandExecutionException("Errore nella lettura della struttura di comandi, key=" + key
						+ ", risorsa:" + resource + " non trovata");
			}
		}
	}
}
