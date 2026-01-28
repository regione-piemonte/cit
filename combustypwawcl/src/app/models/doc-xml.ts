import { Byte } from "@angular/compiler/src/util";

export class docXML {
    nome_file: string;
    descrizione: string;
    data_upload: string;
    uid_index: string;
    file: Uint8Array;

    constructor(nomeFile: string, descrizione: string, dataUpload: string, uidIndex: string, file: Uint8Array) {
        this.nome_file = nomeFile
        this.descrizione = descrizione
        this.data_upload = dataUpload
        this.uid_index = uidIndex
        this.file = file
    }

}