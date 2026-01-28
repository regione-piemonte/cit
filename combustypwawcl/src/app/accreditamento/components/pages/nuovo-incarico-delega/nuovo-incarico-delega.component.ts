import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subject } from 'rxjs';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { MessageService } from 'src/app/services/message.service';
import { SharedService } from 'src/app/services/shared.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { TitleService } from 'src/app/services/title.service';
import { environment } from 'src/environments/environment';

@Component({
    selector: 'app-incarico-delega',
    templateUrl: './nuovo-incarico-delega.component.html',
    styleUrls: ['./nuovo-incarico-delega.component.scss']
})
export class NuovoIncaricoDelegaComponent implements OnInit {

    nuovoIncaricoTitle = "Aggiungi Incarico Soggetto Delegato";
    nuovaDelegaTitle = "Aggiungi Delegati";
    template: string = "incarico";

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
    codiceFiscalePF: string = "";
    ruolo : any;

    constructor(
        readonly titoloService: TitleService,
        readonly backService: BackService,
        readonly messageService: MessageService,
        readonly spinnerService: SpinnerService,
        private sharedService: SharedService,
        private authService: AuthenticationService,
        private router: Router,
        private location: Location,
        private aRoute: ActivatedRoute
    ) {
        let data = this.router.getCurrentNavigation().extras.state;
        if (data && data['impresa']) {
            this.impresa = data['impresa'] ? data['impresa'] : {};
            this.codiceFiscalePF = data['codiceFiscalePF'];
        }else{
            this.router.navigate(['/accreditamento']);
        }
        if (this.router.url.includes('nuovo-incarico')) {
            this.title = this.nuovoIncaricoTitle;
            this.template = "incarico";
        } else if (this.router.url.includes('nuova-delega')) {
            this.title = this.nuovaDelegaTitle;
            this.template = "delega";
        }
    }

    ngOnInit(): void {
        this.ruolo = this.authService.getCurrentUserFromSession().ruoloLoggato;
        this.titoloService.setTitle(this.title);
        // this.route = "/accreditamento";
        this.backTitile = "Torna indietro"
        this.backService.setBackTitle(this.backTitile);
        // this.backService.setRoute(this.route);
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
        this.location.back();
    }
}
