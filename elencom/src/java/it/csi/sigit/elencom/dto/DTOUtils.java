package it.csi.sigit.elencom.dto;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * classe di utilita' varia per operare sugli oggetti DTO.
 */
public class DTOUtils {

	/**
	 * singleton
	 */
	private static DTOUtils instance;

	static {
		// creazione del singleton
		instance = new DTOUtils();
	}

	/**
	 * singleton instance
	 */
	public static DTOUtils getInstance() {
		return instance;
	}

	/**
	 * Restituisce una copia dell'array passato in input (vengono 
	 * mantenuti i riferimenti agli elementi originali.
	 * @param srcArr l'array di input
	 * @param compType la classe degli elementi (deve coincidere con 
	 * il componenttype dell'array - viene passato esplicitamente per 
	 * gestire il caso array di zero elementi).
	 * @return
	 */
	public static Object[] arrayCopyOf(Object[] srcArr, Class compType) {
		if (srcArr == null) {
			return null;
		} else {
			Object[] destArr = (Object[]) Array.newInstance(compType, srcArr.length);
			System.arraycopy(srcArr, 0, destArr, 0, srcArr.length - 0);
			return destArr;
		}
	}

	/**
	 * Effettua una verifica di uguaglianza in profondita' tra i due
	 * oggetti in input
	 * @param o1
	 * @param o2
	 */
	public boolean deepEquals(Object o1, Object o2) {
		if ((o1 == null) != (o2 == null)) {
			// se uno solo dei due oggetti e' nullo allora non 
			// possono essere uguali
			return false;
		} else if (List.class.isAssignableFrom(o1.getClass())) {
			// se sono array effettuo la verifica specifica
			return deepEqualsArray(o1, o2);
		} else if (!(o1.getClass().equals(o2.getClass()))) {
			// se i due oggetti non sono della stessa classe
			// non possono essere uguali
			return false;
			// else: stesso tipo e nessuno dei due nullo
		} else if (isSimpleType(o1)) {
			// se sono tipi semplici utilizzo la funzione equals prevista
			// per quei tipi
			return o1.equals(o2);
		} else {
			// se sono oggetti complessi effettuo la verifica specifica
			return deepEqualsBean(o1, o2);
		}
	}

	/**
	 * @param o l'oggetto di cui serve testare il tipo
	 * @return true se l'oggetto in input e' un tipo smeplice
	 * (Integer|Long|Float|Dlouble|String|Byte|Boolean)
	 */
	private boolean isSimpleType(Object o) {
		return o instanceof Integer || o instanceof Long || o instanceof Float || o instanceof Double
				|| o instanceof String || o instanceof Byte || o instanceof Boolean;
	}

	/**
	 * verifica di uguaglianza specifica per bean
	 * @param o1
	 * @param o2
	 */
	private boolean deepEqualsBean(Object o1, Object o2) {
		BeanInfo bi;
		try {
			// l'accesso agli oggetti avviene mediante introspection
			bi = Introspector.getBeanInfo(o1.getClass());
		} catch (IntrospectionException e) { //NOSONAR  Reason:dubbia classificazione severity
			throw new IllegalArgumentException("errore in lettura campi di " + o1.getClass() + ":" + e);
		}
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();
		for (int i = 0; i < pds.length; i++) {
			PropertyDescriptor currPD = pds[i];
			if (!deepEqualsPropertyVal(currPD, o1, o2))
				return false;
		}
		return true;
	}

	/**
	 * verifica se il valore di una property e' identico per due oggetti
	 * @param pd il property descriptor della property in questione (o1 e o2
	 * devono essere della stessa classe e pd deve essere un valiudo property 
	 * descriptor di quella classe.
	 * @param o1
	 * @param o2
	 * @return true se il valore e' identico o se la property e' read-only 
	 * (logica mantenuta da versione precedente)  
	 */
	private boolean deepEqualsPropertyVal(PropertyDescriptor pd, Object o1, Object o2) {
		// ottengo il metodo di lettura della property corrente dai metadati
		Method getter = pd.getReadMethod();
		// ottengo il metodo di scrittura della property corrente dai metadati
		Method setter = pd.getWriteMethod();
		if (getter != null && setter != null) {
			// se la property non e' read only..
			try {
				// valore della property nell'oggetto 1
				Object v1 = getter.invoke(o1, new Object[]{});
				// valore della property nell'oggetto 2
				Object v2 = getter.invoke(o2, new Object[]{});
				// richiamo ricorsivamente la verifica sui due valori
				return deepEquals(v1, v2);
			} catch (IllegalAccessException e) { //NOSONAR  Reason:dubbia classificazione severity
				throw new IllegalArgumentException("errore in lettura campi di " + o1.getClass() + ":" + e);
			} catch (InvocationTargetException e) { //NOSONAR  Reason:dubbia classificazione severity
				throw new IllegalArgumentException("errore in lettura campi di " + o1.getClass() + ":" + e);
			}
		} else {
			return true; // le property read only vengono ignorate nel computo => true fittizio
		}
	}

	/**
	 * metodo di verifica di uguaglianza profonda, specifico per oggetti di
	 * tipo array
	 * @param o1
	 * @param o2
	 */
	private boolean deepEqualsArray(Object o1, Object o2) {
		List l1 = (List) o1;
		List l2 = (List) o2;
		if (l1.size() != l2.size()) {
			// se le due collezioni non hanno lo stesso numero di elementi
			// non possono essere uguali, percio' non proseguo la verifica
			// sugli elementi
			return false;
		} else {
			// se le due collezioni hanno lo stesso numero di elementi proseguo
			// la verifica sui singoli elementi
			for (int i = 0; i < l1.size(); i++) {
				// oggetto i-esimo della prima collezione
				Object curr1 = l1.get(i);
				// oggetto i-esimo della seconda collezione
				Object curr2 = l2.get(i);
				// effettuo la verifica sulla coppia di elementi, sempre tramite
				// il metodo deepEquals
				if (!deepEquals(curr1, curr2))
					return false; // al primo diverso mi fermo
			}
			return true;
		}
	}

	/**
	 * Effettua un clone ricorsivo delle strutture dati in input.
	 * Il clone viene fatto tramite serializzazione in memory e successiva deserializzazione.
	 */
	public static Object deepClone(Object orig) throws CloneNotSupportedException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(orig);
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			Object clone = ois.readObject();
			return clone;
		} catch (IOException e) { //NOSONAR  Reason:dubbia classificazione severity
			throw new CloneNotSupportedException();
		} catch (ClassNotFoundException e) { //NOSONAR  Reason:dubbia classificazione severity
			throw new CloneNotSupportedException();
		}
	}
}
