package it.csi.sigit.sigitext.dto.test;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImpiantoSportivo   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String codice = null;
  private String nome = null;
  private Comune comune = null;
  private List<Sport> sportPraticabili = new ArrayList<Sport>();

  /**
   **/
  

  @JsonProperty("codice") 
 
  public String getCodice() {
    return codice;
  }
  public void setCodice(String codice) {
    this.codice = codice;
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
  

  @JsonProperty("comune") 
 
  public Comune getComune() {
    return comune;
  }
  public void setComune(Comune comune) {
    this.comune = comune;
  }

  /**
   **/
  

  @JsonProperty("sportPraticabili") 
 
  public List<Sport> getSportPraticabili() {
    return sportPraticabili;
  }
  public void setSportPraticabili(List<Sport> sportPraticabili) {
    this.sportPraticabili = sportPraticabili;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImpiantoSportivo impiantoSportivo = (ImpiantoSportivo) o;
    return Objects.equals(codice, impiantoSportivo.codice) &&
        Objects.equals(nome, impiantoSportivo.nome) &&
        Objects.equals(comune, impiantoSportivo.comune) &&
        Objects.equals(sportPraticabili, impiantoSportivo.sportPraticabili);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codice, nome, comune, sportPraticabili);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImpiantoSportivo {\n");
    
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    comune: ").append(toIndentedString(comune)).append("\n");
    sb.append("    sportPraticabili: ").append(toIndentedString(sportPraticabili)).append("\n");
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

