package it.csi.sigit.citpdnd.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public class Impianto   {
  private BigDecimal codice = null;
  private String stato = null;
  private String ubicazione = null;
  private String tipoImpianto = null;
  private String categoria = null;
  private BigDecimal volumeRisc = null;
  private BigDecimal volumeRaff = null;
  private BigDecimal potAcs = null;
  private BigDecimal potClimaInv = null;
  private BigDecimal potClimaEst = null;

  /**
   **/
  
  @JsonProperty("codice")
  public BigDecimal getCodice() {
    return codice;
  }
  public void setCodice(BigDecimal codice) {
    this.codice = codice;
  }

  /**
   **/
  
  @JsonProperty("stato")
  public String getStato() {
    return stato;
  }
  public void setStato(String stato) {
    this.stato = stato;
  }

  /**
   **/
  
  @JsonProperty("ubicazione")
  public String getUbicazione() {
    return ubicazione;
  }
  public void setUbicazione(String ubicazione) {
    this.ubicazione = ubicazione;
  }

  /**
   **/
  
  @JsonProperty("tipoImpianto")
  public String getTipoImpianto() {
    return tipoImpianto;
  }
  public void setTipoImpianto(String tipoImpianto) {
    this.tipoImpianto = tipoImpianto;
  }

  /**
   **/
  
  @JsonProperty("categoria")
  public String getCategoria() {
    return categoria;
  }
  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  /**
   **/
  
  @JsonProperty("volumeRisc")
  public BigDecimal getVolumeRisc() {
    return volumeRisc;
  }
  public void setVolumeRisc(BigDecimal volumeRisc) {
    this.volumeRisc = volumeRisc;
  }

  /**
   **/
  
  @JsonProperty("volumeRaff")
  public BigDecimal getVolumeRaff() {
    return volumeRaff;
  }
  public void setVolumeRaff(BigDecimal volumeRaff) {
    this.volumeRaff = volumeRaff;
  }

  /**
   **/
  
  @JsonProperty("potAcs")
  public BigDecimal getPotAcs() {
    return potAcs;
  }
  public void setPotAcs(BigDecimal potAcs) {
    this.potAcs = potAcs;
  }

  /**
   **/
  
  @JsonProperty("potClimaInv")
  public BigDecimal getPotClimaInv() {
    return potClimaInv;
  }
  public void setPotClimaInv(BigDecimal potClimaInv) {
    this.potClimaInv = potClimaInv;
  }

  /**
   **/
  
  @JsonProperty("potClimaEst")
  public BigDecimal getPotClimaEst() {
    return potClimaEst;
  }
  public void setPotClimaEst(BigDecimal potClimaEst) {
    this.potClimaEst = potClimaEst;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Impianto impianto = (Impianto) o;
    return Objects.equals(codice, impianto.codice) &&
        Objects.equals(stato, impianto.stato) &&
        Objects.equals(ubicazione, impianto.ubicazione) &&
        Objects.equals(tipoImpianto, impianto.tipoImpianto) &&
        Objects.equals(categoria, impianto.categoria) &&
        Objects.equals(volumeRisc, impianto.volumeRisc) &&
        Objects.equals(volumeRaff, impianto.volumeRaff) &&
        Objects.equals(potAcs, impianto.potAcs) &&
        Objects.equals(potClimaInv, impianto.potClimaInv) &&
        Objects.equals(potClimaEst, impianto.potClimaEst);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codice, stato, ubicazione, tipoImpianto, categoria, volumeRisc, volumeRaff, potAcs, potClimaInv, potClimaEst);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Impianto {\n");
    
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    stato: ").append(toIndentedString(stato)).append("\n");
    sb.append("    ubicazione: ").append(toIndentedString(ubicazione)).append("\n");
    sb.append("    tipoImpianto: ").append(toIndentedString(tipoImpianto)).append("\n");
    sb.append("    categoria: ").append(toIndentedString(categoria)).append("\n");
    sb.append("    volumeRisc: ").append(toIndentedString(volumeRisc)).append("\n");
    sb.append("    volumeRaff: ").append(toIndentedString(volumeRaff)).append("\n");
    sb.append("    potAcs: ").append(toIndentedString(potAcs)).append("\n");
    sb.append("    potClimaInv: ").append(toIndentedString(potClimaInv)).append("\n");
    sb.append("    potClimaEst: ").append(toIndentedString(potClimaEst)).append("\n");
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
