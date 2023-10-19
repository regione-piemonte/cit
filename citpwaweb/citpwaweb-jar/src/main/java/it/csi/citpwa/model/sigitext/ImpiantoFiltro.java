
package it.csi.citpwa.model.sigitext;


/**
 * Inserire qui la documentazione della classe ImpiantoFiltro.
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

public class ImpiantoFiltro {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */

	private Float x;
	private Float y;
	private Float distanza;

	public Float getX() {
		return x;
	}

	public void setX(Float x) {
		this.x = x;
	}

	public Float getY() {
		return y;
	}

	public void setY(Float y) {
		this.y = y;
	}

	public Float getDistanza() {
		return distanza;
	}

	public void setDistanza(Float distanza) {
		this.distanza = distanza;
	}

	private Integer codiceImpianto = null;

	/**
	 * Imposta il valore della property [codiceImpianto]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodiceImpianto(Integer val) {
		codiceImpianto = val;
	}
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
	
	public Integer getCodiceImpianto() {
		return codiceImpianto;
	}

	/**
	 * @generated
	 */
	private String siglaProvincia = null;

	/**
	 * Imposta il valore della property [siglaProvincia]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setSiglaProvincia(String val) {
		siglaProvincia = val;
	}

	
	/**
	 * Inserire qui la documentazione dell'attributo siglaProvincia. 
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
	
	public String getSiglaProvincia() {
		return siglaProvincia;
	}

	/**
	 * @generated
	 */
	private String idComune = null;

	/**
	 * Imposta il valore della property [idComune]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIdComune(String val) {
		idComune = val;
	}

	
	/**
	 * Inserire qui la documentazione dell'attributo idComune. 
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
	
	public String getIdComune() {
		return idComune;
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
	
	public String getDescComune() {
		return descComune;
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
	
	public String getCivico() {
		return civico;
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
	
	public String getCfResponsabile() {
		return cfResponsabile;
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
	
	public String getCf3Responsabile() {
		return cf3Responsabile;
	}

	/**
	 * @generated
	 */
	private String cfProprietario = null;

	/**
	 * Imposta il valore della property [cfProprietario]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCfProprietario(String val) {
		cfProprietario = val;
	}

	
	/**
	 * Inserire qui la documentazione dell'attributo cfProprietario. 
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
	
	public String getCfProprietario() {
		return cfProprietario;
	}

	/**
	 * @generated
	 */
	private String siglaRea = null;

	/**
	 * Imposta il valore della property [siglaRea]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setSiglaRea(String val) {
		siglaRea = val;
	}

	
	/**
	 * Inserire qui la documentazione dell'attributo siglaRea. 
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
	
	public String getSiglaRea() {
		return siglaRea;
	}

	/**
	 * @generated
	 */
	private Integer numeroRea = null;

	/**
	 * Imposta il valore della property [numeroRea]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setNumeroRea(Integer val) {
		numeroRea = val;
	}

	
	/**
	 * Inserire qui la documentazione dell'attributo numeroRea. 
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
	
	public Integer getNumeroRea() {
		return numeroRea;
	}

	/**
	 * @generated
	 */
	private String cfImpresa = null;

	/**
	 * Imposta il valore della property [cfImpresa]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCfImpresa(String val) {
		cfImpresa = val;
	}

	
	/**
	 * Inserire qui la documentazione dell'attributo cfImpresa. 
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
	
	public String getCfImpresa() {
		return cfImpresa;
	}

	/**
	 * @generated
	 */
	private String pod = null;

	/**
	 * Imposta il valore della property [pod]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPod(String val) {
		pod = val;
	}

	
	/**
	 * Inserire qui la documentazione dell'attributo pod. 
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
	
	public String getPod() {
		return pod;
	}

	/**
	 * @generated
	 */
	private String pdr = null;

	/**
	 * Imposta il valore della property [pdr]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPdr(String val) {
		pdr = val;
	}

	
	/**
	 * Inserire qui la documentazione dell'attributo pdr. 
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
	
	public String getPdr() {
		return pdr;
	}

	/**
	 * @generated
	 */
	private Integer fkStato = null;

	/**
	 * Imposta il valore della property [fkStato]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setFkStato(Integer val) {
		fkStato = val;
	}

	
	/**
	 * Inserire qui la documentazione dell'attributo fkStato. 
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
	
	public Integer getFkStato() {
		return fkStato;
	}

	/**
	 * @generated
	 */
	private String istatComune = null;

	/**
	 * Imposta il valore della property [istatComune]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIstatComune(String val) {
		istatComune = val;
	}
	
	/**
	 * Inserire qui la documentazione dell'attributo istatComune. 
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
	public String getIstatComune() {
		return istatComune;
	}

	/**
	 * @generated
	 */
	private Boolean flagVisuProprietario = null;

	/**
	 * Imposta il valore della property [flagVisuProprietario]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setFlagVisuProprietario(Boolean val) {
		flagVisuProprietario = val;
	}
	
	/**
	 * Inserire qui la documentazione dell'attributo flagVisuProprietario. 
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
	public Boolean getFlagVisuProprietario() {
		return flagVisuProprietario;
	}

	public ImpiantoFiltro(Float x, Float y, Float distanza, Integer codiceImpianto, String siglaProvincia, String idComune, String descComune, String indirizzo, String civico, String cfResponsabile, String cf3Responsabile, String cfProprietario, String siglaRea, Integer numeroRea, String cfImpresa, String pod, String pdr, Integer fkStato, String istatComune, Boolean flagVisuProprietario) {
		this.x = x;
		this.y = y;
		this.distanza = distanza;
		this.codiceImpianto = codiceImpianto;
		this.siglaProvincia = siglaProvincia;
		this.idComune = idComune;
		this.descComune = descComune;
		this.indirizzo = indirizzo;
		this.civico = civico;
		this.cfResponsabile = cfResponsabile;
		this.cf3Responsabile = cf3Responsabile;
		this.cfProprietario = cfProprietario;
		this.siglaRea = siglaRea;
		this.numeroRea = numeroRea;
		this.cfImpresa = cfImpresa;
		this.pod = pod;
		this.pdr = pdr;
		this.fkStato = fkStato;
		this.istatComune = istatComune;
		this.flagVisuProprietario = flagVisuProprietario;
	}

	public ImpiantoFiltro() {
	}

	@Override
	public String toString() {
		return "ImpiantoFiltro{" + "x=" + x + ", y=" + y + ", distanza=" + distanza + ", codiceImpianto=" + codiceImpianto + ", siglaProvincia='" + siglaProvincia + '\'' + ", idComune='" + idComune
				+ '\'' + ", descComune='" + descComune + '\'' + ", indirizzo='" + indirizzo + '\'' + ", civico='" + civico + '\'' + ", cfResponsabile='" + cfResponsabile + '\'' + ", cf3Responsabile='"
				+ cf3Responsabile + '\'' + ", cfProprietario='" + cfProprietario + '\'' + ", siglaRea='" + siglaRea + '\'' + ", numeroRea=" + numeroRea + ", cfImpresa='" + cfImpresa + '\'' + ", pod='"
				+ pod + '\'' + ", pdr='" + pdr + '\'' + ", fkStato=" + fkStato + ", istatComune='" + istatComune + '\'' + ", flagVisuProprietario=" + flagVisuProprietario + '}';
	}
}
