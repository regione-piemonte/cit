import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subject } from 'rxjs';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { MessageService } from 'src/app/services/message.service';
import { SharedService } from 'src/app/services/shared.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { SvistaService } from 'src/app/services/svista.service';
import { TitleService } from 'src/app/services/title.service';
import { environment } from 'src/environments/environment';

@Component({
    selector: 'app-impresa',
    templateUrl: './impresa.component.html',
    styleUrls: ['./impresa.component.scss']
})
export class ImpresaComponent implements OnInit {

    title: string = "";
    subtitle: string = "";
    backTitile: string = "";
    route: string = "ruoli";
    titoloMessaggio: string = "";
    descrzioneMessaggio: string = "";
    tipomessaggio: number = 0;
    showMessaggio: boolean = false;
    $destroy = new Subject();
    showImpDrops: boolean = false;

    impresa: any = {};
    onlyView: boolean = false;
    apiUrl = environment.apiUrl;
    codiceFiscalePF: string = null;
    ruolo : any;

    constructor(
        readonly titoloService: TitleService,
        readonly backService: BackService,
        readonly messageService: MessageService,
        readonly spinnerService: SpinnerService,
        readonly authService: AuthenticationService,
        private sharedService: SharedService,
        private router: Router,
        private svistaService: SvistaService,
        private aRoute: ActivatedRoute
    ) {
        if(this.router.getCurrentNavigation().extras == null || this.router.getCurrentNavigation().extras.state == null){
            this.router.navigate(['/accreditamento']);
        }
        let data = this.router.getCurrentNavigation().extras.state;
        if (data['impresa']) {
            this.impresa = data['impresa'] ? data['impresa'] : {};
            this.onlyView = data['onlyView'] ? data['onlyView'] : false;
            this.codiceFiscalePF = data['codiceFiscalePF'] ? data['codiceFiscalePF'] : null;
        }else{
            this.impresa = {};
            this.onlyView = false;
            this.codiceFiscalePF = data['codiceFiscalePF'] ? data['codiceFiscalePF'] : null;
        }
    }

    ngOnInit(): void {
        if (this.impresa) {
            this.title = "Dettaglio impresa";
        } else {
            this.title = "Nuova impresa";
        }
        this.ruolo = this.authService.getCurrentUserFromSession().ruoloLoggato;
        this.titoloService.setTitle(this.title);
        // this.route = "/accreditamento";
        this.backTitile = "Torna Indietro"
        this.backService.setBackTitle(this.backTitile);
        // this.backService.setRoute(this.route);
        this.svistaService.saveComuniEstesiToLocalStorage();
    }

    ngAfterContentChecked() {
        this.doChange();
    }

    doChange() {
        this.title = this.titoloService.getTitle();
        this.subtitle = this.titoloService.getsubtitle();
        this.backTitile = this.backService.getBack();
        this.route = this.backService.getRoute();
        this.titoloMessaggio = this.messageService.getTitolo();
        this.descrzioneMessaggio = this.messageService.getDescrizione();
        this.tipomessaggio = this.messageService.getType();
        this.showMessaggio = this.messageService.getShowMessaggio();
    }

    ngOnDestroy(): void {
        this.$destroy.next();
        this.sharedService.datiPrecompilati = null;
    }

    onMessage(event: any) {
        this.messageService.setTitolo(event.titolo);
        this.messageService.setDescrizione(event.descrizione);
        this.messageService.showMessaggioM();
        this.messageService.setType(event.type);
      }
}
