package it.csi.sigit.sigitext.dto.test;

import org.codehaus.jackson.annotate.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class CorsoSeguito   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String codice = null;
  private String nome = null;
  private BigDecimal voto = null;
  private Date dataConseguimento = null;

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
  

  @JsonProperty("voto") 
 
  public BigDecimal getVoto() {
    return voto;
  }
  public void setVoto(BigDecimal voto) {
    this.voto = voto;
  }

  /**
   **/
  

  @JsonProperty("dataConseguimento") 
 
  public Date getDataConseguimento() {
    return dataConseguimento;
  }
  public void setDataConseguimento(Date dataConseguimento) {
    this.dataConseguimento = dataConseguimento;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CorsoSeguito corsoSeguito = (CorsoSeguito) o;
    return Objects.equals(codice, corsoSeguito.codice) &&
        Objects.equals(nome, corsoSeguito.nome) &&
        Objects.equals(voto, corsoSeguito.voto) &&
        Objects.equals(dataConseguimento, corsoSeguito.dataConseguimento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codice, nome, voto, dataConseguimento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CorsoSeguito {\n");
    
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    voto: ").append(toIndentedString(voto)).append("\n");
    sb.append("    dataConseguimento: ").append(toIndentedString(dataConseguimento)).append("\n");
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

