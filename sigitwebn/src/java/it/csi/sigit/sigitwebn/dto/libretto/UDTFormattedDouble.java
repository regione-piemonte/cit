package it.csi.sigit.sigitwebn.dto.libretto;

/*PROTECTED REGION ID(R-1922035263) ENABLED START*/
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.text.DecimalFormat;
/*PROTECTED REGION END*/
/**
 * Implementazione dello user defined type [FormattedDouble].
 * <ul>
 * <li>tipo scalare base: DOUBLE</li>
 * <li>modificatori:
 *   <ul>
 *     <li>1</li>
 *	 </ul>
 * </li>
 * </ul>
 * @generated
 */
public class UDTFormattedDouble implements java.io.Serializable, Comparable {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 */
	public UDTFormattedDouble() {
		super();
	}

	/**
	 * Costruttore per valore del DTO.
	 */
	public UDTFormattedDouble(java.lang.Double v) {
		super();
		_value = v;
	}

	private java.lang.Double _value;

	public java.lang.Double getValue() {
		return _value;
	}

	public void setValue(java.lang.Double s) {
		_value = s;
	}

	/**
	 * implementazione del confronto di uguaglianza tra due istanze
	 * di UDTFormattedDouble. 
	 */
	public boolean equals(Object other) {
		// un oggetto nullo e' distinto da tutti gli altri
		if (other == null)
			return false;
		// un oggetto di tipo differente non puo' essere uguale
		if (!(other instanceof UDTFormattedDouble))
			return false;
		UDTFormattedDouble otherSpecific = (UDTFormattedDouble) other;
		// un valore nullo non e' uguale ad un valore non nullo
		if ((_value == null && otherSpecific.getValue() != null)
				|| (_value != null && otherSpecific.getValue() == null))
			return false;
		// valori entrambi non nulli: posso confrontare
		/*PROTECTED REGION ID(R1818186066) ENABLED START*/
		// TODO inserire qui la logica specifica di confronto e rimuovere l'eccezione UnsupportedOperationException
		//return _value.equals(otherSpecific.getValue());
		throw new UnsupportedOperationException("Metodo UDTFormattedDouble.equals() non implementato");
		/*PROTECTED REGION END*/
	}

	/**
	 * implementazione della comparazione quantitativa tra due istanze
	 * di UDTFormattedDouble. 
	 */
	public int compareTo(Object other) {
		// un oggetto nullo e' distinto da tutti gli altri e per convenzione li precede
		if (other == null)
			return +1;
		// un oggetto di tipo differente non puo' essere confrontato
		if (!(other instanceof UDTFormattedDouble))
			throw new IllegalArgumentException("impossibile confrontare un UDTFormattedDouble con " + other.getClass());
		UDTFormattedDouble otherSpecific = (UDTFormattedDouble) other;
		// un valore nullo precede un valore non nullo
		if (_value == null && otherSpecific.getValue() != null)
			return -1;
		if (_value != null && otherSpecific.getValue() == null)
			return +1;
		// due valori nulli sono uguali
		if (_value == null && otherSpecific.getValue() == null)
			return 0;
		// valori entrambi non nulli: posso confrontare
		/*PROTECTED REGION ID(R-766816789) ENABLED START*/
		// TODO: inserire qui la logica specifica di confronto e rimuovere l'eccezione UnsupportedOperationException
		//return _value.compareTo(otherSpecific.getValue());		
		throw new UnsupportedOperationException("Metodo UDTFormattedDouble.compareTo() non implementato");
		/*PROTECTED REGION END*/
	}

	public int hashCode() {
		return _value == null ? 0 : _value.hashCode();
	}

	public String toString() {
		/*PROTECTED REGION ID(R-1879193351) ENABLED START*/
		if (_value == null)
			return "";

		return _value.toString();
		/*PROTECTED REGION END*/

	}

	/*PROTECTED REGION ID(R-1267250379) ENABLED START*/
	// inserire qui eventuali metodi aggiuntivi 
	public static DecimalFormat createFormat() {

		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
		otherSymbols.setDecimalSeparator('.');
		java.text.DecimalFormat df = new java.text.DecimalFormat("###.##", otherSymbols);
		return df;
	}

	public static boolean isEmpty(UDTFormattedDouble obj) {
		return obj == null || obj.getValue() == null;
	}
	/*PROTECTED REGION END*/

}
