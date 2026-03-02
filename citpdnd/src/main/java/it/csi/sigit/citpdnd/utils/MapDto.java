package it.csi.sigit.citpdnd.utils;

import it.csi.sigit.citpdnd.api.dto.Impianto;
import it.csi.sigit.citpdnd.entities.SigitUnitaImmobiliare;
import it.csi.sigit.citpdnd.entities.VistaRicercaImpianti;

public class MapDto {

    private MapDto() {
        
    }

    public static Impianto mapImpiantoToImpiantoDto(VistaRicercaImpianti impianto, SigitUnitaImmobiliare unitaImmobiliare) {

        Impianto dto = new Impianto();

        dto.setCodice(impianto.getCodiceImpianto());
        dto.setStato(impianto.getStatoImp().getDesStato());
        dto.setUbicazione(impianto.getIndirizzoUnitaImmob()
                + " " + impianto.getCivico()
                + ", " + impianto.getDenominazioneComune()
                + " (" + impianto.getSiglaProvincia() + ")");
        dto.setTipoImpianto(impianto.getFlgTipoImpianto());
        if (impianto.getCategoria() != null)
            dto.setCategoria(impianto.getCategoria().getDesCategoria());
        dto.setVolumeRisc(unitaImmobiliare.getVolRisc());
        dto.setVolumeRaff(unitaImmobiliare.getVolRaff());
        dto.setPotAcs(impianto.getPotAcs());
        dto.setPotClimaInv(impianto.getPotClimaInv());
        dto.setPotClimaEst(impianto.getPotClimaEst());

        return dto;
    }

}
