package it.csi.sigit.sigitext.dto.test;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Objects;

public class Indirizzo   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer codComune = null;
  private Integer codProvincia = null;
  private Integer codRegione = null;
  private String via = null;
  private String civico = null;

  /**
   **/
  

  @JsonProperty("codComune") 
 
  public Integer getCodComune() {
    return codComune;
  }
  public void setCodComune(Integer codComune) {
    this.codComune = codComune;
  }

  /**
   **/
  

  @JsonProperty("codProvincia") 
 
  public Integer getCodProvincia() {
    return codProvincia;
  }
  public void setCodProvincia(Integer codProvincia) {
    this.codProvincia = codProvincia;
  }

  /**
   **/
  

  @JsonProperty("codRegione") 
 
  public Integer getCodRegione() {
    return codRegione;
  }
  public void setCodRegione(Integer codRegione) {
    this.codRegione = codRegione;
  }

  /**
   **/
  

  @JsonProperty("via") 
 
  public String getVia() {
    return via;
  }
  public void setVia(String via) {
    this.via = via;
  }

  /**
   **/
  

  @JsonProperty("civico") 
 
  public String getCivico() {
    return civico;
  }
  public void setCivico(String civico) {
    this.civico = civico;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Indirizzo indirizzo = (Indirizzo) o;
    return Objects.equals(codComune, indirizzo.codComune) &&
        Objects.equals(codProvincia, indirizzo.codProvincia) &&
        Objects.equals(codRegione, indirizzo.codRegione) &&
        Objects.equals(via, indirizzo.via) &&
        Objects.equals(civico, indirizzo.civico);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codComune, codProvincia, codRegione, via, civico);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Indirizzo {\n");
    
    sb.append("    codComune: ").append(toIndentedString(codComune)).append("\n");
    sb.append("    codProvincia: ").append(toIndentedString(codProvincia)).append("\n");
    sb.append("    codRegione: ").append(toIndentedString(codRegione)).append("\n");
    sb.append("    via: ").append(toIndentedString(via)).append("\n");
    sb.append("    civico: ").append(toIndentedString(civico)).append("\n");
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

