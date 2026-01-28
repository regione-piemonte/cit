package it.csi.sigit.sigitext.dto.sigitext;

public class AzioneIns implements java.io.Serializable{
	
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	private Azione datiAzione;
    private UtenteLoggato utenteLoggato;
    private DocumentoPwa documentoPwa;
	public Azione getDatiAzione() {
		return datiAzione;
	}
	public void setDatiAzione(Azione datiAzione) {
		this.datiAzione = datiAzione;
	}
	public UtenteLoggato getUtenteLoggato() {
		return utenteLoggato;
	}
	public void setUtenteLoggato(UtenteLoggato utenteLoggato) {
		this.utenteLoggato = utenteLoggato;
	}
	public DocumentoPwa getDocumentoPwa() {
		return documentoPwa;
	}
	public void setDocumentoPwa(DocumentoPwa documentoPwa) {
		this.documentoPwa = documentoPwa;
	}
    
    
}
