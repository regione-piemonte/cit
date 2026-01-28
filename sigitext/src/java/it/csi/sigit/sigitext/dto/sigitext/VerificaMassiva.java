package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;

public class VerificaMassiva implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 312905151144443979L;
	
	private Verifica verifica;
	
	private UtenteLoggatoModel utenteLoggatoModel;

	public Verifica getVerifica() {
		return verifica;
	}

	public void setVerifica(Verifica verifica) {
		this.verifica = verifica;
	}

	public UtenteLoggatoModel getUtenteLoggatoModel() {
		return utenteLoggatoModel;
	}

	public void setUtenteLoggatoModel(UtenteLoggatoModel utenteLoggatoModel) {
		this.utenteLoggatoModel = utenteLoggatoModel;
	}
	
	

}
