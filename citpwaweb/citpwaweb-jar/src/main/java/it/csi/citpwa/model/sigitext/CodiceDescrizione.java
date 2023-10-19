
package it.csi.citpwa.model.sigitext;

////{PROTECTED REGION ID(R1775863642) ENABLED START////}
/**
 * Inserire qui la documentazione della classe CodiceDescrizione.
 * Consigli:
 * <ul>
 * <li> Descrivere il "concetto" rappresentato dall'entita' (qual'e' l'oggetto
 *      del dominio del servizio rappresentato)
 * <li> Se necessario indicare se questo concetto e' mantenuto sugli archivi di
 *      una particolare applicazione
 * <li> Se l'oggetto ha un particolare ciclo di vita (stati, es. creato, da approvare, 
 *      approvato, respinto, annullato.....) si puo' decidere di descrivere
 *      la state machine qui o nella documentazione dell'interfaccia del servizio
 *      che manipola quest'oggetto
 * </ul>
 * @generated
 */
////{PROTECTED REGION END////}
public class CodiceDescrizione implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private String codice = null;

	/**
	 * Imposta il valore della property [codice]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodice(String val) {
		codice = val;
	}

	////{PROTECTED REGION ID(R-1803280915) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codice. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessita'
	 *          di corrispondenza con una particolare codifica, che puo' essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public String getCodice() {
		return codice;
	}

	/**
	 * @generated
	 */
	private String descrizione = null;

	/**
	 * Imposta il valore della property [descrizione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDescrizione(String val) {
		descrizione = val;
	}

	////{PROTECTED REGION ID(R552452533) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo descrizione. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessita'
	 *          di corrispondenza con una particolare codifica, che puo' essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public String getDescrizione() {
		return descrizione;
	}

	@Override
	public String toString() {
		return "CodiceDescrizione{" + "codice='" + codice + '\'' + ", descrizione='" + descrizione + '\'' + '}';
	}

	/*PROTECTED REGION ID(R322791279) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
