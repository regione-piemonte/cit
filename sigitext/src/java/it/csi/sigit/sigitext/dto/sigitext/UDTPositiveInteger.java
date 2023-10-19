package it.csi.sigit.sigitext.dto.sigitext;

/*PROTECTED REGION ID(R2122688485) ENABLED START*/
//inserire qui eventuali import aggiuntivi

/*PROTECTED REGION END*/
/**
 * Implementazione dello user defined type [PositiveInteger].
 * <ul>
 * <li>tipo scalare base: INT</li>
 * <li>modificatori:
 *   <ul>
 *	 </ul>
 * </li>
 * </ul>
 * @generated
 */
public class UDTPositiveInteger implements java.io.Serializable, Comparable {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 */
	public UDTPositiveInteger() {
		super();
	}

	/**
	 * Costruttore per valore del DTO.
	 */
	public UDTPositiveInteger(Integer v) {
		super();
		_value = v;
	}

	private Integer _value;

	public Integer getValue() {
		return _value;
	}

	public void setValue(Integer s) {
		_value = s;
	}

	/**
	 * implementazione del confronto di uguaglianza tra due istanze
	 * di UDTPositiveInteger. 
	 */
	public boolean equals(Object other) {
		// un oggetto nullo e' distinto da tutti gli altri
		if (other == null)
			return false;
		// un oggetto di tipo differente non puo' essere uguale
		if (!(other instanceof UDTPositiveInteger))
			return false;
		UDTPositiveInteger otherSpecific = (UDTPositiveInteger) other;
		// un valore nullo non e' uguale ad un valore non nullo
		if ((_value == null && otherSpecific.getValue() != null)
				|| (_value != null && otherSpecific.getValue() == null))
			return false;
		// valori entrambi non nulli: posso confrontare
		/*PROTECTED REGION ID(R622403834) ENABLED START*/
		// TODO inserire qui la logica specifica di confronto e rimuovere l'eccezione UnsupportedOperationException
		//return _value.equals(otherSpecific.getValue());
		throw new UnsupportedOperationException("Metodo UDTPositiveInteger.equals() non implementato");
		/*PROTECTED REGION END*/
	}

	/**
	 * implementazione della comparazione quantitativa tra due istanze
	 * di UDTPositiveInteger. 
	 */
	public int compareTo(Object other) {
		// un oggetto nullo e' distinto da tutti gli altri e per convenzione li precede
		if (other == null)
			return +1;
		// un oggetto di tipo differente non puo' essere confrontato
		if (!(other instanceof UDTPositiveInteger))
			throw new IllegalArgumentException("impossibile confrontare un UDTPositiveInteger con " + other.getClass());
		UDTPositiveInteger otherSpecific = (UDTPositiveInteger) other;
		// un valore nullo precede un valore non nullo
		if (_value == null && otherSpecific.getValue() != null)
			return -1;
		if (_value != null && otherSpecific.getValue() == null)
			return +1;
		// due valori nulli sono uguali
		if (_value == null && otherSpecific.getValue() == null)
			return 0;
		// valori entrambi non nulli: posso confrontare
		/*PROTECTED REGION ID(R-1856537277) ENABLED START*/
		// TODO: inserire qui la logica specifica di confronto e rimuovere l'eccezione UnsupportedOperationException
		//return _value.compareTo(otherSpecific.getValue());		
		throw new UnsupportedOperationException("Metodo UDTPositiveInteger.compareTo() non implementato");
		/*PROTECTED REGION END*/
	}

	public int hashCode() {
		return _value == null ? 0 : _value.hashCode();
	}

	public String toString() {
		/*PROTECTED REGION ID(R-631874991) ENABLED START*/
		// TODO: inserire qui la logica specifica di rappresentazione a stringa
		//return "" + _value;
		if (_value == null)
			return "";

		return _value.toString();
		/*PROTECTED REGION END*/

	}

	/*PROTECTED REGION ID(R-1128134767) ENABLED START*/
	// inserire qui eventuali metodi aggiuntivi 
	/*PROTECTED REGION END*/

}
