package it.csi.sigit.combustypwabff.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class DocXmlExt {
   private String nomeFile = null;
   private String descrizione = null;
   private String dataUpload = null;
   private String uidIndex = null;
   private byte[] file = null;

   @JsonProperty("nome_file")
   public String getNomeFile() {
      return this.nomeFile;
   }

   public void setNomeFile(String nomeFile) {
      this.nomeFile = nomeFile;
   }

   @JsonProperty("descrizione")
   public String getDescrizione() {
      return this.descrizione;
   }

   public void setDescrizione(String descrizione) {
      this.descrizione = descrizione;
   }

   @JsonProperty("data_upload")
   public String getDataUpload() {
      return this.dataUpload;
   }

   public void setDataUpload(String dataUpload) {
      this.dataUpload = dataUpload;
   }

   @JsonProperty("uid_index")
   public String getUidIndex() {
      return this.uidIndex;
   }

   public void setUidIndex(String uidIndex) {
      this.uidIndex = uidIndex;
   }

   @JsonProperty("file")
   public byte[] getFile() {
      return this.file;
   }

   public void setFile(byte[] file) {
      this.file = file;
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         DocXmlExt docXml = (DocXmlExt) o;
         return Objects.equals(this.nomeFile, docXml.nomeFile) && Objects.equals(this.descrizione, docXml.descrizione) && Objects.equals(this.dataUpload, docXml.dataUpload) && Objects.equals(this.uidIndex, docXml.uidIndex) && Objects.equals(this.file, docXml.file);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.nomeFile, this.descrizione, this.dataUpload, this.uidIndex, this.file});
   }

   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class DocXmlExt {\n");
      sb.append("    nomeFile: ").append(this.toIndentedString(this.nomeFile)).append("\n");
      sb.append("    descrizione: ").append(this.toIndentedString(this.descrizione)).append("\n");
      sb.append("    dataUpload: ").append(this.toIndentedString(this.dataUpload)).append("\n");
      sb.append("    uidIndex: ").append(this.toIndentedString(this.uidIndex)).append("\n");
      sb.append("    file: ").append(this.toIndentedString(this.file)).append("\n");
      sb.append("}");
      return sb.toString();
   }

   private String toIndentedString(Object o) {
      return o == null ? "null" : o.toString().replace("\n", "\n    ");
   }
}
