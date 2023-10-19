package it.csi.sigit.sigitweba.business;

import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;

import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;

import it.csi.csi.pfh.FHResult;
import it.csi.csi.pfh.FunctHandler;
import it.csi.csi.util.Param;
import it.csi.csi.wrapper.CSIException;

public class IridePDCache implements FunctHandler {

	/**
	 * mantiene i dati della cache
	 */
	static Map<Iride2CallKey, Iride2CallValue> cache = new HashMap<Iride2CallKey, Iride2CallValue>();

	/**
	 * TTL = 1h
	 */
	static final long TTL = 60 * 60 * 1000; // TTL = 1h

	/**
	 * Gestisce il meccanismo di cache al momento dell'invocazione.
	 * Solo i metodi per cui il risultato di <code>mustCache()</code> &egrave; true
	 * sono gestiti con il meccanismo di cache.
	 * Se il metodo &egrave; gestito in cache:
	 * <ol>
	 * <li>viene ricercata nella cache l'eventuale presenza del valore di una chiamata precedente
	 *     con gli stessi parametri</li>
	 * <li>se &egrave; presente il valore e questo non &egrave; troppo vecchio, esso viene inserito nel 
	 * contesto come valore da restituire e viene istruita la PD in modo da non effettuare la chiamata
	 * effettuva al servizio
	 * <li>se non &egrave; presente il valore allora il giro normale prosegue e, nella catena di risposta
	 *     il valore ottenuto dal servizio viene inserito in cache, per le future invocazioni</li> 
	 * </ol>
	 * 
	 */
	public FHResult doOnInvokeSynch(String methodName, Param[] params, FHResult prevres, Hashtable bag,
			boolean inPreChain) throws CSIException {
		if (mustCache(methodName)) {

			Iride2CallKey call = new Iride2CallKey(methodName, params);
			if (inPreChain) {
				Iride2CallValue cachedResult = cache.get(call);
				if (cachedResult != null) {
					if ((System.currentTimeMillis() - cachedResult.birthTime) < TTL) {
						prevres.setResult(cachedResult.result);
						prevres.setSkipInvoke(true);
					} else
						cache.remove(call);
				}
				// else continue and call PA...
			}

			else { // post chain
				if (prevres.getException() == null) {
					// metti in cache il risultato
					Iride2CallValue newVal = new Iride2CallValue(System.currentTimeMillis(), prevres.getResult());
					cache.put(call, newVal);
				}
			}
		}
		return prevres;
	}

	/**
	 * attualmente i metodi gestiti dal meccanismo di cache sono solo i seguenti:
	 * <ul>
	 * <li>isPersonaInRuolo</li>
	 * <li>isPersonaAutorizzataInUseCase</li>
	 * <li>findActorsForPersonaInApplication</li>
	 * <li>findRuoliForPersonaInUseCase</li>
	 * </ul>
	 */
	private boolean mustCache(String methodName) {
		if ("isPersonaInRuolo".equals(methodName) || "isPersonaAutorizzataInUseCase".equals(methodName)
				|| "findActorsForPersonaInApplication".equals(methodName)
				|| "findRuoliForPersonaInUseCase".equals(methodName))
			return true;
		else
			return false;

	}

	/**
	 * Valore degli elementi della cache. Descrive l'output dell'invocazione
	 * (funziona per i soli metodi gestiti).
	 * E' corredata da un indicatore di istante di inserimento in cache, per verificarne
	 * l'anzianit&agrave;
	 */
	class Iride2CallValue {
		public long birthTime;
		public Param result;

		public Iride2CallValue(long bt, Param p) {
			birthTime = bt;
			result = p;
		}
	}

	/**
	 * Chiave degli elementi della cache. Descrive l'input dell'invocazione
	 * (funziona per i soli metodi gestiti).
	 * E' corredata da un indicatore di istante di inserimento in cache
	 */
	class Iride2CallKey {
		public String paramsKey;

		public Iride2CallKey(String methodName, Param[] params) {
			paramsKey += methodName + ":";
			Object id = (params[0].getValue()); // identita (csi o ws)
			paramsKey += getIdentitaCodFiscaleValue(id);
			if (isParamUseCase(params[1])) {
				paramsKey += ",UC:" + getUseCaseIdValue(params[1].getValue());
			} else if (isParamActor(params[1])) {
				paramsKey += ",ACT:" + getActorIdValue(params[1].getValue());
			} else if (isParamRole(params[1])) {
				paramsKey += ",ROL:" + getRuoloCodiceDominioValue(params[1].getValue()) + "-"
						+ getRuoloCodiceRuoloValue(params[1].getValue());
			}
		}

		/**
		 * 
		 * @param p
		 * @return true se il parametro e' uno UseCase (csi o ws)
		 */
		private boolean isParamUseCase(Param p) {
			return p.getType().getName().endsWith("UseCase");
		}

		/**
		 * 
		 * @param p
		 * @return true se il parametro e' un Actor (csi o ws)
		 */
		private boolean isParamActor(Param p) {
			return p.getType().getName().endsWith("Actor");
		}

		/**
		 * 
		 * @param p
		 * @return true se il parametro e' un Role (csi o ws)
		 */
		private boolean isParamRole(Param p) {
			return p.getType().getName().endsWith("Ruolo");
		}

		/**
		 * 
		 * @return il valore della property codFiscale di un oggetto di tipo identita (csi o ws)
		 */
		private Object getIdentitaCodFiscaleValue(Object identita) {
			if (identita instanceof it.csi.iride2.policy.entity.Identita) {
				return ((it.csi.iride2.policy.entity.Identita) identita).getCodFiscale();
			} else {
				return ((it.csi.iride2.policy.base.nmsf.stub.base.entity.Identita) identita).getCodFiscale();
			}
		}

		/**
		 * 
		 * @return il valore della property id di un oggetto di tipo use case (csi o ws)
		 */
		private Object getUseCaseIdValue(Object usecase) {
			if (usecase instanceof it.csi.iride2.policy.entity.UseCase) {
				return ((it.csi.iride2.policy.entity.UseCase) usecase).getId();
			} else {
				return ((it.csi.iride2.policy.base.nmsf.stub.base.entity.UseCase) usecase).getId();
			}
		}

		/**
		 * 
		 * @return il valore della property id di un oggetto di tipo actor (csi o ws)
		 */
		private Object getActorIdValue(Object actor) {
			if (actor instanceof it.csi.iride2.policy.entity.Actor) {
				return ((it.csi.iride2.policy.entity.Actor) actor).getId();
			} else {
				return ((it.csi.iride2.policy.base.nmsf.stub.base.entity.Actor) actor).getId();
			}
		}

		/**
		 * 
		 * @return il valore della property codiceRuolo di un oggetto di tipo ruolo (csi o ws)
		 */
		private Object getRuoloCodiceRuoloValue(Object ruolo) {
			if (ruolo instanceof it.csi.iride2.iridefed.entity.Ruolo) {
				return ((it.csi.iride2.iridefed.entity.Ruolo) ruolo).getCodiceRuolo();
			} else {
				return ((it.csi.iride2.policy.base.nmsf.stub.iridefed.entity.Ruolo) ruolo).getCodiceRuolo();
			}
		}

		/**
		 * 
		 * @return il valore della property codiceDominio di un oggetto di tipo ruolo (csi o ws)
		 */
		private Object getRuoloCodiceDominioValue(Object ruolo) {
			if (ruolo instanceof it.csi.iride2.iridefed.entity.Ruolo) {
				return ((it.csi.iride2.iridefed.entity.Ruolo) ruolo).getCodiceDominio();
			} else {
				return ((it.csi.iride2.policy.base.nmsf.stub.iridefed.entity.Ruolo) ruolo).getCodiceDominio();
			}
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Iride2CallKey) {
				Iride2CallKey other = (Iride2CallKey) obj;
				return paramsKey.equals(other.paramsKey);
			} else
				return false;
		}

		@Override
		public int hashCode() {

			return paramsKey.hashCode();
		}

		@Override
		public String toString() {
			return paramsKey;
		}

	}
}
