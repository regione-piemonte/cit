package it.csi.sigit.sigitext.dto.test;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Objects;

public class GetSportsFilter   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private StringCrit nome = null;
  private BooleanCrit diSquadra = null;
  private StringCrit tipologiaSvolgimento = null;
  private StringCrit praticabileIn = null;

  /**
   **/
  

  @JsonProperty("nome") 
 
  public StringCrit getNome() {
    return nome;
  }
  public void setNome(StringCrit nome) {
    this.nome = nome;
  }

  /**
   **/
  

  @JsonProperty("diSquadra") 
 
  public BooleanCrit getDiSquadra() {
    return diSquadra;
  }
  public void setDiSquadra(BooleanCrit diSquadra) {
    this.diSquadra = diSquadra;
  }

  /**
   **/
  

  @JsonProperty("tipologiaSvolgimento") 
 
  public StringCrit getTipologiaSvolgimento() {
    return tipologiaSvolgimento;
  }
  public void setTipologiaSvolgimento(StringCrit tipologiaSvolgimento) {
    this.tipologiaSvolgimento = tipologiaSvolgimento;
  }

  /**
   **/
  

  @JsonProperty("praticabileIn") 
 
  public StringCrit getPraticabileIn() {
    return praticabileIn;
  }
  public void setPraticabileIn(StringCrit praticabileIn) {
    this.praticabileIn = praticabileIn;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetSportsFilter getSportsFilter = (GetSportsFilter) o;
    return Objects.equals(nome, getSportsFilter.nome) &&
        Objects.equals(diSquadra, getSportsFilter.diSquadra) &&
        Objects.equals(tipologiaSvolgimento, getSportsFilter.tipologiaSvolgimento) &&
        Objects.equals(praticabileIn, getSportsFilter.praticabileIn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, diSquadra, tipologiaSvolgimento, praticabileIn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetSportsFilter {\n");
    
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    diSquadra: ").append(toIndentedString(diSquadra)).append("\n");
    sb.append("    tipologiaSvolgimento: ").append(toIndentedString(tipologiaSvolgimento)).append("\n");
    sb.append("    praticabileIn: ").append(toIndentedString(praticabileIn)).append("\n");
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

