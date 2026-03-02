package it.csi.sigit.citpdnd.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import it.csi.sigit.citpdnd.api.dto.Impianto;
import java.util.ArrayList;
import java.util.List;
import jakarta.validation.constraints.*;

public class ListaImpianti extends ArrayList<Impianto>  {


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListaImpianti listaImpianti = (ListaImpianti) o;
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListaImpianti {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
