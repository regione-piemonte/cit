
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action;

/**
 * Implementazione del comando JumpExtCommnad.
 */
public class JumpExtCommand implements ICommand {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per poter essere inserita in sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	String locationCode;

	String staticUrl;

	String runtimeUrlProviderAppaData;

	boolean binaryStream;

	/**
	 * @param locationCode codice univoco identificativo della location a cui saltare.
	 * e' referenziato nel result di struts
	 * @param staticUrl se il comandoprevede il salto ad un url fisso, questo e' contenuto
	 * in tale parametro
	 * @param runtimeUrlProviderAppData nome dell'ApplicationData che contiene il valore dell'url a cui
	 * saltare (in caso di url dinamicamente determinato)
	 * @param binaryStream se impostato a true indica che l'url a cui si comanda il salto produrra'
	 * uno stream binario. Alcune cartuccie potrebbero sfruttare questa informazione per ottimizzare
	 * il comportamento.
	 */
	public JumpExtCommand(String locationCode, String staticUrl, String runtimeUrlProviderAppaData,
			boolean binaryStream) {
		this.locationCode = locationCode;
		this.staticUrl = staticUrl;
		this.runtimeUrlProviderAppaData = runtimeUrlProviderAppaData;
		this.binaryStream = binaryStream;
	}

	/**
	 * costruttore di default
	 */
	public JumpExtCommand() {
		/// costruttore intenzionalmente vuoto
	}
	/**
	 * Esecuzione del comando JumpExtCommand. L'esecuzione si concretizza con la restituzione
	 * al workflow di struts del result GO_TO_EX_<codice della location>.
	 * sara' poi il result (di tipo redirect) a ridirigere il flusso all'url corretto.
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException {
		// clear page scoped appdata
		strutsAction.clearPageScopedAppData(null);
		return "GO_TO_EX_" + locationCode;
	}

	/**
	 * codice della location a cui saltare
	 */
	public String getLocationCode() {
		return locationCode;
	}

	/**
	 * codice della location a cui saltare
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	/**
	 * url statico a cui saltare
	 */
	public String getStaticUrl() {
		return staticUrl;
	}

	/**
	 * url statico a cui saltare
	 */
	public void setStaticUrl(String staticUrl) {
		this.staticUrl = staticUrl;
	}

	/**
	 * nome dell'appdata contnenente l'url a cui saltare
	 */
	public String getRuntimeUrlProviderAppaData() {
		return runtimeUrlProviderAppaData;
	}

	/**
	 * nome dell'appdata contnenente l'url a cui saltare
	 */
	public void setRuntimeUrlProviderAppaData(String runtimeUrlProviderAppaData) {
		this.runtimeUrlProviderAppaData = runtimeUrlProviderAppaData;
	}

	/**
	 * l'url a cui saltare produrra' uno stream binario?
	 */
	public boolean isBinaryStream() {
		return binaryStream;
	}

	/**
	 * l'url a cui saltare produrra' uno stream binario?
	 */
	public void setBinaryStream(boolean binaryStream) {
		this.binaryStream = binaryStream;
	}
};
