package it.csi.sigit.sigitext.dto;

public class Assegnatario {

	private Integer idRuoloPa;
	private Integer idPersonaFisica;
	private String nome;
	private String cognome;
	private String codicefiscale;
	private String desRuoloPa;
	private String istatAbilitazione;
	private Long dataFine;		
	
	public Long getDataFine() {
		return dataFine;
	}
	public void setDataFine(Long dataFine) {
		this.dataFine = dataFine;
	}
	public Integer getIdRuoloPa() {
		return idRuoloPa;
	}
	public void setIdRuoloPa(Integer idRuoloPa) {
		this.idRuoloPa = idRuoloPa;
	}
	public Integer getIdPersonaFisica() {
		return idPersonaFisica;
	}
	public void setIdPersonaFisica(Integer idPersonaFisica) {
		this.idPersonaFisica = idPersonaFisica;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodicefiscale() {
		return codicefiscale;
	}
	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}
	public String getDesRuoloPa() {
		return desRuoloPa;
	}
	public void setDesRuoloPa(String desRuoloPa) {
		this.desRuoloPa = desRuoloPa;
	}
	public String getIstatAbilitazione() {
		return istatAbilitazione;
	}
	public void setIstatAbilitazione(String istatAbilitazione) {
		this.istatAbilitazione = istatAbilitazione;
	}
	@Override
	public String toString() {
		return "Assegnatario [idRuoloPa=" + idRuoloPa + ", idPersonaFisica=" + idPersonaFisica + ", nome=" + nome
				+ ", cognome=" + cognome + ", codicefiscale=" + codicefiscale + ", desRuoloPa=" + desRuoloPa
				+ ", istatAbilitazione=" + istatAbilitazione + "]";
	}
	
	
}
