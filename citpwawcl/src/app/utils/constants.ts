export const IMAGESURL = "assets/images/";
export const ICONSURL = "assets/icons/";

export const STRINGHE = {
    PAGINA_INIZIALE: {
        PREVIEW1: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim",
        PREVIEW2: "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa",
        PREVIEW3: "qui dolorem eum fugiat, quo voluptas nulla pariatur? [33] At vero eos et accusamus et iusto odio dignissimos ducimus"
    }
}

export const STATO_IMPIANTO = {
    ATTIVO: "1",

}

export const STATO_RUOLO = {
    SOSPESO: 3,
    RADIATO: 4
}

export const RUOLI = {
    RUOLO_RESPONSABILE: "RESPONSABILE",
    RUOLO_PROPRIETARIO: "PROPRIETARIO",
    RUOLO_RESPONSABILE_IMPRESA: "RESPONSABILE IMPRESA/ENTE",
    RUOLO_PROPRIETARIO_IMPRESA: "PROPRIETARIO IMPRESA/ENTE",
    RUOLO_ISPETTORE: "ISPETTORE",
    RUOLO_CARICATORE: "CARICATORE",
    RUOLO_IMPRESA: "IMPRESA",
    RUOLO_3RESPONSABILE: "3RESPONSABILE",
    RUOLO_DISTRIBUTORE: "DISTRIBUTORE",
    RUOLO_CAT: "SOGG. DELEGATO",
    CAT_RUOLO_PREFISSO: "SOGG. DELEGATO per ",
    RUOLO_SUPER: "SUPERUSER",
    RUOLO_VALIDATORE: "VALIDATORE",
    RUOLO_CONSULTATORE: "CONSULTATORE"
}

export const LOCCSI = {
    CIVICI: "FULL",
    STRADE: "STRADE",
    COMUNI: "COMUNI"
}

export const ID_PROPRIETARIO_PROPRIETARIO = '15';
export const ID_PROPRIETARIO_PROPRIETARIO_IMPRESA = '16';

export const OPERAZIONE_COMP = {
    RIPRISTINA: 1,
    MODIFICA: 2,
    SOSTITUISCI: 3,
    DISMETTI: 4,
    RIATTIVA: 5,
    INSERISCI: 0
}

export const ORDINAMENTO = {
    STATO_DEL_CONTROLLO: "fk_stato_rapp",
    DATA_CONTROLLO_MENO_RECENTE: "data_controllo",
    DATA_CONTROLLO_PIU_RECENTE: "data_controllo DESC",
    TIPOLOGIA_DI_CONTROLLO: "fk_tipo_documento"
}

export const TIPO_INTERVENTO = {
    PULIZIA: 1,
    CONTROLLO_COMBUSTIONE: 2,
    ALTRO: 3
}

export const STATO_RAPP = {
    BOZZA: 0,
    INVIATO: 1,
    RESPINTO: 2,
    IN_ATTESA_DI_INVIO: 3,
    IN_ATTESA_DI_MODIFICA: 4,
    IN_ATTESA_DI_ELIMINAZIONE: 5,
    BOZZA_LOCALE: -1
}

export const OPERAZIONI = {
    INVIO: "INVIO",
    CANCELLAZIONE: "CANCELLAZIONE",
    MODIFICA: "MODIFICA"
}

export const ESITO_OPERAZIONI = {
    PENDING: "IN ATTESA",
    SUCCESSO: "SUCCESSO",
    FALLITO: "FALLITO"
}

export const TRATT_ACQUA = {
    DESC_ASSENTE: "ASSENTE",
    DESC_FILTRAZIONE: "FILTRAZIONE",
    DESC_ADDOLCIMENTO: "ADDOLCIMENTO",
    DESC_CONDIZ_CHIMICO: "CONDIZ. CHIMICO"
}

export const TIPI_COMP = {
    GT: "GT",
    GF: "GF",
    SC: "SC",
    CG: "CG"
}

export const KO_PG = "ko_pg";

export const OK = "ok";
export const KO = "ko";

export const UM = {
    MG_K_WH: "mg/kWh",
    MG_NM_3: "mg/Nm3"
}

export const FORMAT = "MM/dd/yyyy";
export const DISPLAY_FORMAT = "dd/MM/yyyy";

export const MESSAGGIO_DECIMALE = "Ammette massimo {interi} interi e {decimali} decimali";

export const ACCREDITATO = "A";