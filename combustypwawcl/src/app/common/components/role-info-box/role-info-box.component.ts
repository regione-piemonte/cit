import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { PFLoggato } from 'src/app/models/pf-loggato';
import { RuoloLoggato } from 'src/app/models/ruolo-loggato';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { RUOLI } from 'src/app/utils/constants';

@Component({
  selector: 'app-role-info-box',
  templateUrl: './role-info-box.component.html',
  styleUrls: ['./role-info-box.component.scss']
})
export class RoleInfoBoxComponent implements OnInit {
  @Output() onPanelToggle = new EventEmitter<boolean>();

  utenteLoggato: UtenteLoggato;
  impresaBool = false;
  ruoloPaBool = false;
  responsabileProprietarioBool = false;
  isOpened: boolean;

  constructor(private authService: AuthenticationService) {
    this.utenteLoggato = new UtenteLoggato(new PFLoggato("", "", ""), new RuoloLoggato(null, null, null, null, null, null, null, null, null, null, null));
  }

  ngOnInit() {
    this.utenteLoggato = this.authService.getCurrentUserFromSession();

    if (this.utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_IMPRESA
      || this.utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_PROPRIETARIO_IMPRESA
      || this.utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_RESPONSABILE_IMPRESA
      || this.utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_3RESPONSABILE
      || this.utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_DISTRIBUTORE) {
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

  togglePanel() {
    this.isOpened = !this.isOpened;
    this.onPanelToggle.emit(this.isOpened);
  }
}
