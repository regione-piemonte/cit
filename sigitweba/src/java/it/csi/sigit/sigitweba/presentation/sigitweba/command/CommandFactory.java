package it.csi.sigit.sigitweba.presentation.sigitweba.command;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import flexjson.JSONDeserializer;
import flexjson.locators.TypeLocator;
import it.csi.sigit.sigitweba.presentation.sigitweba.action.*;

public class CommandFactory {
	private static JSONDeserializer<ICommand> deser = new JSONDeserializer<ICommand>();
	private static final String RESOURCE_BASE = "/it/csi/sigit/sigitweba/presentation/sigitweba/action";

	static final CommandFactory INSTANCE = new CommandFactory();

	static final Map<String, ICommand> cmdCache = new HashMap<String, ICommand>();

	public static CommandFactory getInstance() {
		return INSTANCE;
	}

	static {
		// INIT....

	}

	private static String makeKey(String moduleName, String cpName, String methodName) {
		return (moduleName == null ? "global" : moduleName) + "/" + cpName + "/" + methodName;
	}

	public ICommand buildCmdStructure_internal(String moduleName, String cpName, String methodName)
			throws CommandExecutionException {
		String key = makeKey(moduleName, cpName, methodName);
		ICommand cmd = cmdCache.get(key);
		if (cmd != null) {
			return cmd;
		} else {
			String resource = RESOURCE_BASE;
			if (moduleName == null) {
				resource = resource + "/commands/" + cpName + "/" + methodName + "_cmds.json";
			} else {
				resource = resource + "/" + moduleName + "/commands/" + cpName + "/" + methodName + "_cmds.json";
			}

			InputStream is = getClass().getResourceAsStream(resource);
			if (is != null) {
				InputStreamReader isReader = new InputStreamReader(is);
				try {
					cmd = deser.deserialize(isReader);
				} catch (Exception e) {
					throw new CommandExecutionException(
							"Errore nella lettura della struttura di comandi, key=" + key + ", risorsa:" + resource, e);
				}
				cmdCache.put(key, cmd);
				return cmd;
			} else {
				throw new CommandExecutionException("Errore nella lettura della struttura di comandi, key=" + key
						+ ", risorsa:" + resource + " non trovata");
			}
		}
	}
}
