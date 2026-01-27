import { DatiImpresa } from '@sigit/common-lib';
import { Autodichiarazione } from './dati-autodichiarazione';
import { DatiContratto } from './dati-contratto';
import { DatiImpianto } from './dati-impianto';
import { UtenteLoggato } from './utente-loggato';

export class RequestTerzoResponsabile{
    datiImpianto: DatiImpianto;
    utenteLoggato: UtenteLoggato;
    datiContratto: DatiContratto;
    autodichiarazioni: Autodichiarazione[];
    datiImpresa?: DatiImpresa;
}
