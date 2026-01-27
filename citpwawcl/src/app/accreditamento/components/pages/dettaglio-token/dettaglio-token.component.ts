import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { ActivatedRoute, Router } from '@angular/router';
import { Subject } from 'rxjs';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { MessageService } from 'src/app/services/message.service';
import { SharedService } from 'src/app/services/shared.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { TitleService } from 'src/app/services/title.service';

@Component({
  selector: 'app-dettaglio-token',
  templateUrl: './dettaglio-token.component.html',
  styleUrls: ['./dettaglio-token.component.scss']
})
export class DettaglioTokenComponent implements OnInit {


title: string = "Dettaglio token";
subtitle: string = "";
backTitile: string = "";
route: string = "ruoli";
titoloMessaggio: string = "";
descrzioneMessaggio: string = "";
tipomessaggio: number = 0;
showMessaggio: boolean = false;
ruolo : any;
apiUrl = environment.apiUrl;


constructor(readonly titoloService: TitleService,
        readonly backService: BackService,
        readonly messageService: MessageService,
        readonly spinnerService: SpinnerService,
        readonly authService: AuthenticationService,
        private sharedService: SharedService,
        private router: Router,
        private aRoute: ActivatedRoute) { }

ngOnInit(): void {
  this.ruolo = this.authService.getCurrentUserFromSession().ruoloLoggato;
  this.backTitile = "Torna Indietro"
}


doChange() {
    this.titoloMessaggio = this.messageService.getTitolo();
    this.descrzioneMessaggio = this.messageService.getDescrizione();
    this.tipomessaggio = this.messageService.getType();
    this.showMessaggio = this.messageService.getShowMessaggio();
}

onMessage(event: any) {
    this.messageService.setTitolo(event.titolo);
    this.messageService.setDescrizione(event.descrizione);
    this.messageService.showMessaggioM();
    this.messageService.setType(event.type);
  }

ngAfterContentChecked() {
  this.doChange();
}

}