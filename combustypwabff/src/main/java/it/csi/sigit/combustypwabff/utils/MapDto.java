package it.csi.sigit.combustypwabff.utils;

import it.csi.sigit.combustypwabff.bff.dto.*;
import it.csi.sigit.combustypwabff.model.sigitext.SigitextDatiImpresa;
import it.csi.sigit.combustypwabff.model.locsi.LoccsiFeatureModel;
import it.csi.sigit.combustypwabff.model.sigitext.SigitextImpiantoFiltro;

public class MapDto {

    public static UtenteLoggato mapCurrentUserToUtenteLoggato(UserInfo currentUser) {
        UtenteLoggato utenteLoggato = new UtenteLoggato();
        utenteLoggato.setPfLoggato(new PFLoggato());
        utenteLoggato.setRuoloLoggato(new RuoloLoggato());
        utenteLoggato.getPfLoggato().setCodiceFiscalePF(currentUser.getCodFisc());
        utenteLoggato.getPfLoggato().setCognomePF(currentUser.getCognome());
        utenteLoggato.getPfLoggato().setNomePF(currentUser.getNome());
        utenteLoggato.getRuoloLoggato().setRuolo(currentUser.getRuolo());
        return utenteLoggato;
    }

    public static UtenteLoggato mapParamToUtenteLoggato(UserInfo currentUser, String ruolo, String piva, String codiceFiscalePF) {
        UtenteLoggato utenteLoggato = new UtenteLoggato();
        utenteLoggato.setPfLoggato(new PFLoggato());
        utenteLoggato.setRuoloLoggato(new RuoloLoggato());
        utenteLoggato.getPfLoggato().setCodiceFiscalePF(codiceFiscalePF);
        utenteLoggato.getPfLoggato().setCognomePF(currentUser.getCognome());
        utenteLoggato.getPfLoggato().setNomePF(currentUser.getNome());
        utenteLoggato.getRuoloLoggato().setRuolo(ruolo);
        utenteLoggato.getRuoloLoggato().setPiva(piva);
        return utenteLoggato;
    }


    public static FeatureModel maploccsifeatureModelToFeatureModel(LoccsiFeatureModel loccsiFeatureModel) {
        FeatureModel featureModel = new FeatureModel();
        featureModel.setId(loccsiFeatureModel.getId());
        featureModel.setType(loccsiFeatureModel.getType());
        GeometryModel geometryModel = new GeometryModel();
        geometryModel.setType(loccsiFeatureModel.getGeometry().getType());
        geometryModel.setCoordinates(loccsiFeatureModel.getGeometry().getCoordinates());
        featureModel.setGeometry(geometryModel);
        PropertiesModel propertiesModel = new PropertiesModel();
        propertiesModel.setCodiceIstat(loccsiFeatureModel.getProperties().getCodiceIstat());
        propertiesModel.setLocalita(loccsiFeatureModel.getProperties().getLocalita());
        propertiesModel.setCap(loccsiFeatureModel.getProperties().getCap());
        propertiesModel.setComune(loccsiFeatureModel.getProperties().getComune());
        propertiesModel.setLoccsiLabel(loccsiFeatureModel.getProperties().getLoccsiLabel());
        propertiesModel.setCivicoNum(loccsiFeatureModel.getProperties().getCivicoNum());
        propertiesModel.setNomeVia(loccsiFeatureModel.getProperties().getNomeVia());
        propertiesModel.setCivicoSub(loccsiFeatureModel.getProperties().getCivicoSub());
        propertiesModel.setTipoVia(loccsiFeatureModel.getProperties().getTipoVia());
        propertiesModel.setPv(loccsiFeatureModel.getProperties().getPv());
        propertiesModel.setToponimo(loccsiFeatureModel.getProperties().getToponimo());
        propertiesModel.setPreposizione(loccsiFeatureModel.getProperties().getPreposizione());
        propertiesModel.setDescProvincia(loccsiFeatureModel.getProperties().getDescProvincia());
        propertiesModel.setSiglaProvincia(loccsiFeatureModel.getProperties().getSiglaProvincia());
        propertiesModel.setCircoscrizione(loccsiFeatureModel.getProperties().getCircoscrizione());
        featureModel.setProperties(propertiesModel);

        return featureModel;
    }

    public static SigitextDatiImpresa mapDatiImpresaToSigitExtDatiImpresa(DatiImpresa datiImpresa) {
        return SigitextDatiImpresa.builder()
                .id_persona_giuridica(datiImpresa.getIdPersonaGiuridica())
                .denominazione(datiImpresa.getDenominazione())
                .codice_fiscale(datiImpresa.getCodiceFiscale())
                .indirizzo_sitad(datiImpresa.getIndirizzoSitad())
                .stradario(datiImpresa.getStradario())
                .indirizzo_non_trovato(datiImpresa.getIndirizzoNonTrovato())
                .sigla_prov(datiImpresa.getSiglaProv())
                .istat_comune(datiImpresa.getIstatComune())
                .comune(datiImpresa.getComune())
                .provincia(datiImpresa.getProvincia())
                .civico(datiImpresa.getCivico())
                .cap(datiImpresa.getCap())
                .email(datiImpresa.getEmail())
                .data_inizio_attivita(datiImpresa.getDataInizioAttivita())
                .data_cessazione(datiImpresa.getDataCessazione())
                .sigla_rea(datiImpresa.getSiglaRea())
                .numero_rea(datiImpresa.getNumeroRea())
                .flg_amministratore(datiImpresa.getFlgAmministratore())
                .data_ult_mod(datiImpresa.getDataUltMod())
                .utente_ult_mod(datiImpresa.getUtenteUltMod())
                .flg_terzo_responsabile(datiImpresa.getFlgTerzoResponsabile())
                .flg_distributore(datiImpresa.getFlgDistributore())
                .flg_cat(datiImpresa.getFlgCat())
                .flg_indirizzo_estero(datiImpresa.getFlgIndirizzoEstero())
                .stato_estero(datiImpresa.getStatoEstero())
                .indirizzo_estero(datiImpresa.getIndirizzoEstero())
                .cap_estero(datiImpresa.getCapEstero())
                .fk_stato_pg(datiImpresa.getFkStatoPg())
                .dt_agg_dichiarazione(datiImpresa.getDtAggDichiarazione())
                .flg_dm37_letterac(datiImpresa.getFlgDm37Letterac())
                .flg_dm37_letterad(datiImpresa.getFlgDm37Letterad())
                .flg_dm37_letterae(datiImpresa.getFlgDm37Letterae())
                .flg_fgas(datiImpresa.getFlgFgas())
                .flg_conduttore(datiImpresa.getFlgConduttore())
                .flg_sogg_incaricato(datiImpresa.getFlgSoggIncaricato())
                .data_fine_legame(datiImpresa.getDataFineLegame())
                .flg_delega (datiImpresa.getFlgDelega())
                .delega_sogg_incaricato(datiImpresa.getDelegaSoggIncaricato())
                .pec(datiImpresa.getPec())
                .telefono(datiImpresa.getTelefono())
                .token(datiImpresa.getToken())
                .dt_creazione_token(datiImpresa.getDtCreazioneToken())
                .dt_scadenza_token(datiImpresa.getDtScadenzaToken())
                .citta_estero(datiImpresa.getCittaEstero())
                .desStato(datiImpresa.getDesStato())
                .build();
    }

    public static SigitextImpiantoFiltro mapParamToImpiantoFiltro(String cf3Resp, String cfImpresa, String cfProprietario, String cfResponsabile, String civico, String codiceImpianto, String descComune, String fkStato, String flagVisuProprietario, String idComune, String indirizzo, String istatComune, String numeroRea, String pdr, String pod, String siglaProvincia, String siglaRea, Float x, Float y, Float distanza, UtenteLoggato utenteLoggato) {
        SigitextImpiantoFiltro impiantoFiltro = new SigitextImpiantoFiltro();
        String ruolo = utenteLoggato.getRuoloLoggato().getRuolo();

        if (ruolo.equals(Constants.RUOLO_3RESPONSABILE))
            impiantoFiltro.setCf3Responsabile(utenteLoggato.getRuoloLoggato().getPiva());
        else
            impiantoFiltro.setCf3Responsabile(cf3Resp);
        impiantoFiltro.setCfImpresa(cfImpresa);

        if (ruolo.equals(Constants.RUOLO_PROPRIETARIO)) {
            impiantoFiltro.setCfProprietario(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
            impiantoFiltro.setFlagVisuProprietario(true);
        } else if (ruolo.equals(Constants.RUOLO_PROPRIETARIO_IMPRESA)) {
            impiantoFiltro.setCfProprietario(utenteLoggato.getRuoloLoggato().getPiva());
            impiantoFiltro.setFlagVisuProprietario(true);
        } else
            impiantoFiltro.setCfProprietario(cfProprietario);

        if (ruolo.equals(Constants.RUOLO_RESPONSABILE))
            impiantoFiltro.setCfResponsabile(utenteLoggato.getPfLoggato().getCodiceFiscalePF());
        else if (ruolo.equals(Constants.RUOLO_RESPONSABILE_IMPRESA))
            impiantoFiltro.setCfResponsabile(utenteLoggato.getRuoloLoggato().getPiva());
        else
            impiantoFiltro.setCfResponsabile(cfResponsabile);

        impiantoFiltro.setCivico(civico);
        impiantoFiltro.setCodiceImpianto(codiceImpianto != null ? Integer.parseInt(codiceImpianto) : null);
        impiantoFiltro.setDescComune(descComune);
        impiantoFiltro.setFkStato(fkStato != null ? Integer.parseInt(fkStato) : null);
        impiantoFiltro.setFlagVisuProprietario(flagVisuProprietario != null ? Boolean.parseBoolean(flagVisuProprietario) : null);
        impiantoFiltro.setIdComune(idComune);
        impiantoFiltro.setIndirizzo(indirizzo);
        impiantoFiltro.setIstatComune(istatComune);
        impiantoFiltro.setNumeroRea(numeroRea != null ? Integer.parseInt(numeroRea) : null);
        impiantoFiltro.setPdr(pdr);
        impiantoFiltro.setPod(pod);
        impiantoFiltro.setSiglaProvincia(siglaProvincia);
        impiantoFiltro.setSiglaRea(siglaRea);
        impiantoFiltro.setX(x);
        impiantoFiltro.setY(y);
        impiantoFiltro.setDistanza(distanza);

        return impiantoFiltro;
    }

}
