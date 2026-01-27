export class Documento {
    doc: Uint8Array | number[] | string | string[]| null;
    uid: string | null;
    nome: string | null;
    dimensione: number | null;
    dataUpload: Date | null;
    mimeType: string | null;
    encoding: string | null;
    isPdfStatico: boolean | null;
    tipoDocumento: string | null;
    descrizione: string | null;
}


export class TipoDocumento {
    idTipoDoc: number | null;
    description: string | null;
}