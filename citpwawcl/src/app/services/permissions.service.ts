import { Injectable } from '@angular/core';
import { RUOLI } from '../utils/constants';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class PermissionsService {
  constructor(private readonly authService: AuthenticationService) { }

  isNuovoImpiantoEnabled(): boolean {
    let utenteLoggato = this.authService.getCurrentUserFromSession();
    let ruolo = utenteLoggato.ruoloLoggato.ruolo;
    return !(ruolo === RUOLI.RUOLO_CONSULTATORE
      || ruolo === RUOLI.RUOLO_3RESPONSABILE
      || ruolo === RUOLI.RUOLO_PROPRIETARIO
      || ruolo === RUOLI.RUOLO_PROPRIETARIO_IMPRESA);
  }

  isRicercaImpiantoEnabled(): boolean {
    let utenteLoggato = this.authService.getCurrentUserFromSession();
    let ruolo = utenteLoggato.ruoloLoggato.ruolo;
    return ruolo && ruolo != "";
  }
}
