import { SyncTask } from "./sync-task";
import { UtenteLoggato } from "./utente-loggato";

export class OperazioneControlloModel {
    idOperazione:string;
    dataInserimento: string;
    operazione: string;
    dataInvioOnline: string;
    dataControllo: string;
    codiceImpianto: string;
    descrizioneOperazione: string;
    utente: UtenteLoggato;
    esito: string;
    descEsito: string;
    task: SyncTask;
}