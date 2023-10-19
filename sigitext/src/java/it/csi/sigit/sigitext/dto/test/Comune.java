package it.csi.sigit.sigitext.dto.test;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Objects;

public class Comune   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer codice = null;
  private String nome = null;

  /**
   * il codice identificativo del comune
   **/
  

  @JsonProperty("codice") 
 
  public Integer getCodice() {
    return codice;
  }
  public void setCodice(Integer codice) {
    this.codice = codice;
  }

  /**
   * il nome comune del comune
   **/
  

  @JsonProperty("nome") 
 
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Comune comune = (Comune) o;
    return Objects.equals(codice, comune.codice) &&
        Objects.equals(nome, comune.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codice, nome);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Comune {\n");
    
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
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

