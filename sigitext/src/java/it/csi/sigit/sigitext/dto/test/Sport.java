package it.csi.sigit.sigitext.dto.test;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sport   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String codice = null;
  private String nome = null;
  private Boolean diSquadra = null;
  private List<TipologiaSvolgimentoSport> tipologiaSvolgimento = new ArrayList<TipologiaSvolgimentoSport>();

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
  

  @JsonProperty("diSquadra") 
 
  public Boolean isDiSquadra() {
    return diSquadra;
  }
  public void setDiSquadra(Boolean diSquadra) {
    this.diSquadra = diSquadra;
  }

  /**
   **/
  

  @JsonProperty("tipologiaSvolgimento") 
 
  public List<TipologiaSvolgimentoSport> getTipologiaSvolgimento() {
    return tipologiaSvolgimento;
  }
  public void setTipologiaSvolgimento(List<TipologiaSvolgimentoSport> tipologiaSvolgimento) {
    this.tipologiaSvolgimento = tipologiaSvolgimento;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sport sport = (Sport) o;
    return Objects.equals(codice, sport.codice) &&
        Objects.equals(nome, sport.nome) &&
        Objects.equals(diSquadra, sport.diSquadra) &&
        Objects.equals(tipologiaSvolgimento, sport.tipologiaSvolgimento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codice, nome, diSquadra, tipologiaSvolgimento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sport {\n");
    
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    diSquadra: ").append(toIndentedString(diSquadra)).append("\n");
    sb.append("    tipologiaSvolgimento: ").append(toIndentedString(tipologiaSvolgimento)).append("\n");
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

