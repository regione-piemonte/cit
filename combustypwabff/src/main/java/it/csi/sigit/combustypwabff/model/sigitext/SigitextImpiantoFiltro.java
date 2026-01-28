package it.csi.sigit.combustypwabff.model.sigitext;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SigitextImpiantoFiltro {

    private Float x;
    private Float y;
    private Float distanza;
    private Integer codiceImpianto = null;
    private String siglaProvincia = null;
    private String idComune = null;
    private String descComune = null;
    private String indirizzo = null;
    private String civico = null;
    private String cfResponsabile = null;
    private String cf3Responsabile = null;
    private String cfProprietario = null;
    private String siglaRea = null;
    private Integer numeroRea = null;
    private String cfImpresa = null;
    private String pod = null;
    private String pdr = null;
    private Integer fkStato = null;
    private String istatComune = null;
    private Boolean flagVisuProprietario = null;

}
