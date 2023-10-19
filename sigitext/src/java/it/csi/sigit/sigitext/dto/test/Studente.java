package it.csi.sigit.sigitext.dto.test;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class Studente   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer matricola = null;
  private String nome = null;
  private String cognome = null;
  private Date dataNascita = null;
  private Indirizzo indirizzoResidenza = null;
  private Indirizzo indirizzoDomicilio = null;

  /**
   **/
  

  @JsonProperty("matricola") 
 
  public Integer getMatricola() {
    return matricola;
  }
  public void setMatricola(Integer matricola) {
    this.matricola = matricola;
  }

  /**
   **/
  

  @JsonProperty("nome") 
 
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   **/
  

  @JsonProperty("cognome") 
 
  public String getCognome() {
    return cognome;
  }
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   **/
  

  @JsonProperty("dataNascita") 
 
  public Date getDataNascita() {
    return dataNascita;
  }
  public void setDataNascita(Date dataNascita) {
    this.dataNascita = dataNascita;
  }

  /**
   **/
  

  @JsonProperty("indirizzoResidenza") 
 
  public Indirizzo getIndirizzoResidenza() {
    return indirizzoResidenza;
  }
  public void setIndirizzoResidenza(Indirizzo indirizzoResidenza) {
    this.indirizzoResidenza = indirizzoResidenza;
  }

  /**
   **/
  

  @JsonProperty("indirizzoDomicilio") 
 
  public Indirizzo getIndirizzoDomicilio() {
    return indirizzoDomicilio;
  }
  public void setIndirizzoDomicilio(Indirizzo indirizzoDomicilio) {
    this.indirizzoDomicilio = indirizzoDomicilio;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Studente studente = (Studente) o;
    return Objects.equals(matricola, studente.matricola) &&
        Objects.equals(nome, studente.nome) &&
        Objects.equals(cognome, studente.cognome) &&
        Objects.equals(dataNascita, studente.dataNascita) &&
        Objects.equals(indirizzoResidenza, studente.indirizzoResidenza) &&
        Objects.equals(indirizzoDomicilio, studente.indirizzoDomicilio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(matricola, nome, cognome, dataNascita, indirizzoResidenza, indirizzoDomicilio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Studente {\n");
    
    sb.append("    matricola: ").append(toIndentedString(matricola)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    dataNascita: ").append(toIndentedString(dataNascita)).append("\n");
    sb.append("    indirizzoResidenza: ").append(toIndentedString(indirizzoResidenza)).append("\n");
    sb.append("    indirizzoDomicilio: ").append(toIndentedString(indirizzoDomicilio)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

