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

export const STATO_DATI_DOCUMENTO_IMPIANTO = {
    ATTIVO: 'ATTIVO',
    CANCELLATO: 'CANCELLATO',
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

export const TIPO_VERIFICA_IMPIANTO_ID = 1;
export const TIPO_VERIFICA_REE_ID = 2;
export const TIPO_VERIFICA_RELAZIONE_ESIMENTE_ID = 3;
export const TIPO_VERIFICA_DATO_DISTRIBUTORE_ID = 4;
export const TIPO_VERIFICA_SEGNALAZIONE_ID = 5;
export const TIPO_VERIFICA_DECADENZA_3_RESPONSABILE_ID = 6;
export const TIPO_VERIFICA_ALTRO_ID = 7;

export const RUOLO_PA_CONSULTATORE_ID = 1;
export const RUOLO_PA_ISPETTORE_ID = 2;
export const RUOLO_PA_VALIDATORE_ID = 4;

export const PROVINCE_PIEMONTESI = ['TO', 'CN', 'AT', 'AL', 'VC', 'NO', 'BI', 'VB'];

export const STATO_ISPEZIONE_BOZZA_ID = 1;
export const STATO_ISPEZIONE_CONSOLIDATO_ID = 2;
export const STATO_ISPEZIONE_ANNULLATO_ID = 3;

export const WORD_MIME_TYPE = 'application/vnd.openxmlformats-officedocument.wordprocessingml.document';
export const EXCEL_MIME_TYPE = 'application/vnd.ms-excel';

export const TITOLI = [
  { id: 10, desc: 'Proprietario' },
  { id: 11, desc: 'Occupante' },
  { id: 12, desc: 'Amministratore di condominio' },
  { id: 4, desc: 'Proprietario' },
  { id: 5, desc: 'Occupante' },
  { id: 13, desc: 'Amministratore di condominio' }
];

// COSTANTI PER STYLESHEET CONDIVISO IN QUANTO IL COMPONENTE E' UTILIZZATO IN PIU' PAGINE E LO STYLE.SCSS NON VIENE CONDIVISO

export const ANIMATION_DO_FADE = `
.fade-out {
    animation: fadeOut 1s ease-in-out;
}

@keyframes fadeOut {
    from {
      opacity: 1;
    }
    to {
      opacity: 0;
    }
}
`


export const MAT_GRID_STYLE =
`
.card-padding {
    padding: 0px 8.3%;
    margin-right: 3.3%;
}

.card-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill,minmax(260px,1fr));
    grid-gap: 45px;
    max-width: 1200px;
}`
