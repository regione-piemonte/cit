
package it.csi.sigit.sigitext.dto.sigitext;

////{PROTECTED REGION ID(R-1039499481) ENABLED START////}

import java.util.Arrays;

/**
 * Inserire qui la documentazione della classe Impianto.
 * Consigli:
 * <ul>
 * <li> Descrivere il "concetto" rappresentato dall'entita' (qual'&egrave; l'oggetto
 *      del dominio del servizio rappresentato)
 * <li> Se necessario indicare se questo concetto &egrave; mantenuto sugli archivi di
 *      una particolare applicazione
 * <li> Se l'oggetto ha un particolare ciclo di vita (stati, es. creato, da approvare, 
 *      approvato, respinto, annullato.....) si pu&ograve; decidere di descrivere
 *      la state machine qui o nella documentazione dell'interfaccia del servizio
 *      che manipola quest'oggetto
 * </ul>
 * @generated
 */
////{PROTECTED REGION END////}
public class Impianto implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private Integer codiceImpianto = null;

	/**
	 * Imposta il valore della property [codiceImpianto]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodiceImpianto(Integer val) {
		codiceImpianto = val;
	}

	////{PROTECTED REGION ID(R-1423187681) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codiceImpianto. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public Integer getCodiceImpianto() {
		return codiceImpianto;
	}

	/**
	 * @generated
	 */
	private String stato = null;

	/**
	 * Imposta il valore della property [stato]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setStato(String val) {
		stato = val;
	}

	////{PROTECTED REGION ID(R-188439084) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo stato. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public String getStato() {
		return stato;
	}

	/**
	 * @generated
	 */
	private String dtAssegnazione = null;

	/**
	 * Imposta il valore della property [dtAssegnazione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDtAssegnazione(String val) {
		dtAssegnazione = val;
	}

	////{PROTECTED REGION ID(R-2038874536) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dtAssegnazione. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public String getDtAssegnazione() {
		return dtAssegnazione;
	}

	/**
	 * @generated
	 */
	private String dtDismissione = null;

	/**
	 * Imposta il valore della property [dtDismissione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDtDismissione(String val) {
		dtDismissione = val;
	}

	////{PROTECTED REGION ID(R-2023653264) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dtDismissione. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public String getDtDismissione() {
		return dtDismissione;
	}

	/**
	 * @generated
	 */
	private String motivoDisimissione = null;

	/**
	 * Imposta il valore della property [motivoDisimissione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setMotivoDisimissione(String val) {
		motivoDisimissione = val;
	}

	////{PROTECTED REGION ID(R-1795009781) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo motivoDisimissione. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public String getMotivoDisimissione() {
		return motivoDisimissione;
	}

	/**
	 * @generated
	 */
	private String indirizzo = null;

	/**
	 * Imposta il valore della property [indirizzo]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIndirizzo(String val) {
		indirizzo = val;
	}

	////{PROTECTED REGION ID(R1709930023) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo indirizzo. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * @generated
	 */
	private String civico = null;

	/**
	 * Imposta il valore della property [civico]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCivico(String val) {
		civico = val;
	}

	////{PROTECTED REGION ID(R-2014254676) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo civico. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public String getCivico() {
		return civico;
	}

	/**
	 * @generated
	 */
	private String descComune = null;

	/**
	 * Imposta il valore della property [descComune]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDescComune(String val) {
		descComune = val;
	}

	////{PROTECTED REGION ID(R-460112861) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo descComune. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public String getDescComune() {
		return descComune;
	}

	/**
	 * @generated
	 */
	private String siglaProv = null;

	/**
	 * Imposta il valore della property [siglaProv]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setSiglaProv(String val) {
		siglaProv = val;
	}

	////{PROTECTED REGION ID(R-871883960) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo siglaProv. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public String getSiglaProv() {
		return siglaProv;
	}

	/**
	 * @generated
	 */
	private String denomResponsabile = null;

	/**
	 * Imposta il valore della property [denomResponsabile]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDenomResponsabile(String val) {
		denomResponsabile = val;
	}

	////{PROTECTED REGION ID(R-1641933887) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo denomResponsabile. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public String getDenomResponsabile() {
		return denomResponsabile;
	}

	/**
	 * @generated
	 */
	private String cfResponsabile = null;

	/**
	 * Imposta il valore della property [cfResponsabile]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCfResponsabile(String val) {
		cfResponsabile = val;
	}

	////{PROTECTED REGION ID(R-1291246425) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo cfResponsabile. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public String getCfResponsabile() {
		return cfResponsabile;
	}

	/**
	 * @generated
	 */
	private String denom3Responsabile = null;

	/**
	 * Imposta il valore della property [denom3Responsabile]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDenom3Responsabile(String val) {
		denom3Responsabile = val;
	}

	////{PROTECTED REGION ID(R2092580908) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo denom3Responsabile. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public String getDenom3Responsabile() {
		return denom3Responsabile;
	}

	/**
	 * @generated
	 */
	private String cf3Responsabile = null;

	/**
	 * Imposta il valore della property [cf3Responsabile]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCf3Responsabile(String val) {
		cf3Responsabile = val;
	}

	////{PROTECTED REGION ID(R78990342) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo cf3Responsabile. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public String getCf3Responsabile() {
		return cf3Responsabile;
	}

	/**
	 * @generated
	 */
	private RifCatastale[] rifCatastali = null;

	/**
	 * Imposta il valore della property [rifCatastali]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setRifCatastali(RifCatastale[] val) {
		if (val == null) {
			rifCatastali = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			rifCatastali = new RifCatastale[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				rifCatastali[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	////{PROTECTED REGION ID(R-66796662) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo rifCatastali. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public RifCatastale[] getRifCatastali() {
		if (rifCatastali == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			RifCatastale[] copy = new RifCatastale[rifCatastali.length];
			for (int i = 0; i < rifCatastali.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = rifCatastali[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}

	/**
	 * @generated
	 */
	private String dtUltAggLibretto = null;

	/**
	 * Imposta il valore della property [dtUltAggLibretto]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDtUltAggLibretto(String val) {
		dtUltAggLibretto = val;
	}

	////{PROTECTED REGION ID(R-503512974) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dtUltAggLibretto. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public String getDtUltAggLibretto() {
		return dtUltAggLibretto;
	}

	/**
	 * @generated
	 */
	private String uidIndexLibretto = null;

	/**
	 * Imposta il valore della property [uidIndexLibretto]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setUidIndexLibretto(String val) {
		uidIndexLibretto = val;
	}

	////{PROTECTED REGION ID(R-1117313760) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo uidIndexLibretto. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public String getUidIndexLibretto() {
		return uidIndexLibretto;
	}

	/**
	 * @generated
	 */
	private RappControllo[] rappControllo = null;

	/**
	 * Imposta il valore della property [rappControllo]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setRappControllo(RappControllo[] val) {
		if (val == null) {
			rappControllo = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			rappControllo = new RappControllo[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				rappControllo[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	////{PROTECTED REGION ID(R1388546090) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo rappControllo. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public RappControllo[] getRappControllo() {
		if (rappControllo == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			RappControllo[] copy = new RappControllo[rappControllo.length];
			for (int i = 0; i < rappControllo.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = rappControllo[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}

	@Override
	public String toString() {
		return "Impianto{" + "codiceImpianto=" + codiceImpianto + ", stato='" + stato + '\'' + ", dtAssegnazione='" + dtAssegnazione + '\'' + ", dtDismissione='" + dtDismissione + '\''
				+ ", motivoDisimissione='" + motivoDisimissione + '\'' + ", indirizzo='" + indirizzo + '\'' + ", civico='" + civico + '\'' + ", descComune='" + descComune + '\'' + ", siglaProv='"
				+ siglaProv + '\'' + ", denomResponsabile='" + denomResponsabile + '\'' + ", cfResponsabile='" + cfResponsabile + '\'' + ", denom3Responsabile='" + denom3Responsabile + '\''
				+ ", cf3Responsabile='" + cf3Responsabile + '\'' + ", rifCatastali=" + Arrays.toString(rifCatastali) + ", dtUltAggLibretto='" + dtUltAggLibretto + '\'' + ", uidIndexLibretto='"
				+ uidIndexLibretto + '\'' + ", rappControllo=" + Arrays.toString(rappControllo) + '}';
	}
}
