package it.csi.sigit.sigitext.dto.test;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PianoStudi   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer codice = null;
  private String nomePiano = null;
  private List<CorsoSeguito> corsiSeguiti = new ArrayList<CorsoSeguito>();

  /**
   **/
  

  @JsonProperty("codice") 
 
  public Integer getCodice() {
    return codice;
  }
  public void setCodice(Integer codice) {
    this.codice = codice;
  }

  /**
   **/
  

  @JsonProperty("nomePiano") 
 
  public String getNomePiano() {
    return nomePiano;
  }
  public void setNomePiano(String nomePiano) {
    this.nomePiano = nomePiano;
  }

  /**
   **/
  

  @JsonProperty("corsiSeguiti") 
 
  public List<CorsoSeguito> getCorsiSeguiti() {
    return corsiSeguiti;
  }
  public void setCorsiSeguiti(List<CorsoSeguito> corsiSeguiti) {
    this.corsiSeguiti = corsiSeguiti;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PianoStudi pianoStudi = (PianoStudi) o;
    return Objects.equals(codice, pianoStudi.codice) &&
        Objects.equals(nomePiano, pianoStudi.nomePiano) &&
        Objects.equals(corsiSeguiti, pianoStudi.corsiSeguiti);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codice, nomePiano, corsiSeguiti);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PianoStudi {\n");
    
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    nomePiano: ").append(toIndentedString(nomePiano)).append("\n");
    sb.append("    corsiSeguiti: ").append(toIndentedString(corsiSeguiti)).append("\n");
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

