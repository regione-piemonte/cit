import { Component, EventEmitter, Inject, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AccreditamentoService, DatiDelega, DatiImpresa, DatiIncarico } from '@sigit/common-lib';
import { Subject } from 'rxjs';
import { RuoloLoggato } from 'src/app/models/ruolo-loggato';
import { BackService } from 'src/app/services/back.service';
import { MessageService } from 'src/app/services/message.service';
import { TitleService } from 'src/app/services/title.service';
import { environment } from 'src/environments/environment';
import { AuthenticationService } from '../../../../services/authentication.service';

@Component({
    selector: 'app-elenco-imprese',
    templateUrl: './elenco-imprese.component.html',
})
export class ElencoImpresaComponent implements OnInit, OnChanges {

    title: string = "";
    subtitle: string = "";
    backTitile: string = "";
    route: string = "ruoli";
    titoloMessaggio: string = "";
    descrzioneMessaggio: string = "";
    tipomessaggio: number = 0;
    showMessaggio: boolean = false;
    $destroy = new Subject();
    apiUrl = environment.apiUrl;
    impresa: DatiImpresa;
    deleghe: DatiDelega[] = [];
    incarichi: DatiIncarico[] = [];
    ruolo: RuoloLoggato;

    onMessage = new EventEmitter<any>();

    constructor(private router: Router,
        @Inject(AccreditamentoService) private accreditamentoService: AccreditamentoService,
        readonly messageService: MessageService,
        private titoloService: TitleService,
        private backService: BackService,
        private authService: AuthenticationService,
        private activatedRoute: ActivatedRoute) {
        this.accreditamentoService.init(this.apiUrl);
        this.activatedRoute.params.subscribe((params) => {
            this.loadData();
        });
    }

    ngOnInit(): void {
        this.ruolo = this.authService.getCurrentUserFromSession().ruoloLoggato;
        window.scrollTo(0, 0);
    }

    ngOnChanges(changes: SimpleChanges): void {
        this.loadData();
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


    loadData() {
        let data = this.router.getCurrentNavigation()?.extras?.state;
        if (!data) {
            this.router.navigate(['/']);
        }
        if (data?.['impresa']) {
            this.impresa = data['impresa'];
            this.loadElenchi();
        }
        this.onMessage.subscribe((event) => {
            console.log("event " + event);
        });
    }
    loadElenchi(event?: any) {
        this.accreditamentoService.getElencoDeleghe(this.impresa.id_persona_giuridica).subscribe((deleghe) => {
            this.deleghe = deleghe;
        });
        this.accreditamentoService.getElencoIncarichi(this.impresa.id_persona_giuridica).subscribe((incarichi) => {
            this.incarichi = incarichi;
        });
    }


}
