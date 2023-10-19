package it.csi.sigit.sigitext.dto.test;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Provincia   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer codice = null;
  private String nome = null;
  private List<Comune> comuni = new ArrayList<Comune>();

  /**
   * il codice identificativo della provincia
   **/
  

  @JsonProperty("codice") 
 
  public Integer getCodice() {
    return codice;
  }
  public void setCodice(Integer codice) {
    this.codice = codice;
  }

  /**
   * il nome comune della provincia
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
  

  @JsonProperty("comuni") 
 
  public List<Comune> getComuni() {
    return comuni;
  }
  public void setComuni(List<Comune> comuni) {
    this.comuni = comuni;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Provincia provincia = (Provincia) o;
    return Objects.equals(codice, provincia.codice) &&
        Objects.equals(nome, provincia.nome) &&
        Objects.equals(comuni, provincia.comuni);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codice, nome, comuni);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Provincia {\n");
    
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    comuni: ").append(toIndentedString(comuni)).append("\n");
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

