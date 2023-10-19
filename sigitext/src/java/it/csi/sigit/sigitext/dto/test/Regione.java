package it.csi.sigit.sigitext.dto.test;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Regione   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer codice = null;
  private String nome = null;
  private List<Provincia> provincie = new ArrayList<Provincia>();

  /**
   * il codice identificativo della regione
   **/
  

  @JsonProperty("codice") 
 
  public Integer getCodice() {
    return codice;
  }
  public void setCodice(Integer codice) {
    this.codice = codice;
  }

  /**
   * il nome comune della regione
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
  

  @JsonProperty("provincie") 
 
  public List<Provincia> getProvincie() {
    return provincie;
  }
  public void setProvincie(List<Provincia> provincie) {
    this.provincie = provincie;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Regione regione = (Regione) o;
    return Objects.equals(codice, regione.codice) &&
        Objects.equals(nome, regione.nome) &&
        Objects.equals(provincie, regione.provincie);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codice, nome, provincie);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Regione {\n");
    
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    provincie: ").append(toIndentedString(provincie)).append("\n");
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

