import { Component, OnInit } from '@angular/core';
import { PFLoggato } from 'src/app/models/pf-loggato';
import { RuoloLoggato } from 'src/app/models/ruolo-loggato';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { RUOLI } from 'src/app/utils/constants';

@Component({
  selector: 'app-role-header',
  templateUrl: './role-header.component.html',
  styleUrls: ['./role-header.component.scss']
})
export class RoleHeaderComponent implements OnInit {

  utenteLoggato: UtenteLoggato;
  impresaBool: boolean = false;
  ruoloPaBool: boolean = false;
  responsabileProprietarioBool: boolean = false;

  constructor(private authService: AuthenticationService) { this.utenteLoggato = new UtenteLoggato(new PFLoggato("", "", ""), new RuoloLoggato(null, null, null, null, null, null, null, null, null, null, null)) }

  ngOnInit(): void {

    this.utenteLoggato = this.authService.getCurrentUserFromSession();
    if (this.utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_IMPRESA
      || this.utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_PROPRIETARIO_IMPRESA
      || this.utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_RESPONSABILE_IMPRESA
      || this.utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_3RESPONSABILE) {
      this.impresaBool = true;
    }
    if (this.utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_PROPRIETARIO
      || this.utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_RESPONSABILE) {
      this.responsabileProprietarioBool = true;
    }

    if (this.utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_ISPETTORE
      || this.utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_VALIDATORE
      || this.utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_SUPER
      || this.utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_CONSULTATORE) {
      this.ruoloPaBool = true;
    }
  }
}
