export class UserInfo {
    nome: string;
    cognome: string;
    codFisc: string;
    idEnte: number;
    idRuolo: number;
    descRuolo: string;

    constructor(nome:string,cognome:string,codFisc:string,idEnte:number,idRuolo:number,descRuolo:string){
        this.nome=nome;
        this.cognome=cognome;
        this.codFisc=codFisc;
        this.idEnte=idEnte;
        this.idRuolo=idRuolo;
        this.descRuolo=descRuolo;
    }
}
