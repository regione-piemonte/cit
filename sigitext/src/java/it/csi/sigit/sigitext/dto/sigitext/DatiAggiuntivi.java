package it.csi.sigit.sigitext.dto.sigitext;

public class DatiAggiuntivi implements java.io.Serializable {
	
	static final long serialVersionUID = 1L;
	private String sezione;
	private String foglio;
	private String particella;
	private String subalterno;
	private String pod_elettrico;
	private String pdr_gas;


	public String getSezione() {
		return sezione;
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	public String getFoglio() {
		return foglio;
	}

	public void setFoglio(String foglio) {
		this.foglio = foglio;
	}

	public String getParticella() {
		return particella;
	}

	public void setParticella(String particella) {
		this.particella = particella;
	}

	public String getSubalterno() {
		return subalterno;
	}

	public void setSubalterno(String subalterno) {
		this.subalterno = subalterno;
	}

	public String getPod_elettrico() {
		return pod_elettrico;
	}

	public void setPod_elettrico(String pod_elettrico) {
		this.pod_elettrico = pod_elettrico;
	}

	public String getPdr_gas() {
		return pdr_gas;
	}

	public void setPdr_gas(String pdr_gas) {
		this.pdr_gas = pdr_gas;
	}
	
	

}
