import { AfterContentChecked, ChangeDetectorRef, Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { log } from 'console';
import { Subject } from 'rxjs';
import { filter, takeUntil } from 'rxjs/operators';
import { BackService } from 'src/app/services/back.service';
import { MessageService } from 'src/app/services/message.service';
import { SharedService } from 'src/app/services/shared.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { TitleService } from 'src/app/services/title.service';
@Component({
  selector: 'app-impianto',
  templateUrl: './impianto.component.html',
  styleUrls: ['./impianto.component.scss']
})
export class ImpiantoComponent implements OnInit, OnDestroy, AfterContentChecked {

  title: string = "";
  subtitle: string = "";
  backTitile: string = "";
  route: string = "";
  queryParams: any = null;
  titoloMessaggio: string = "";
  descrzioneMessaggio: string = "";
  tipomessaggio: number = 0;
  showMessaggio: boolean = false;
  $destroy = new Subject();
  showImpDrops: boolean = false;
  isRicercaImpianto: boolean = false;

  constructor(
    readonly titoloService: TitleService,
    readonly backService: BackService,
    readonly messageService: MessageService,
    readonly spinnerService: SpinnerService,
    private sharedService: SharedService,
    private cdref: ChangeDetectorRef,
    private router: Router,
    private aRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const url = this.router.url;
    
    this.isRicercaImpianto = url.includes('impianto/ricerca-impianti');

    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        const url = event.urlAfterRedirects;
        this.isRicercaImpianto = url.includes('impianto/ricerca-impianti');
      });

    console.log("this.isRicercaImpianto: " + this.isRicercaImpianto);

    const idImpianto = url.split("/")[3];
    if(url.includes("dettaglio-impianto") && !this.sharedService.datiPrecompilati) {
      this.router.navigate([`/impianto/dettaglio-impianto/${idImpianto}`]);
    }
    this.sharedService.forceChangeContent.pipe(takeUntil(this.$destroy)).subscribe(() => {
      this.doChange();
    })
    this.aRoute.url.pipe().subscribe(() => {
      this.showImpDrops = false;
      const url = this.router.url;
      const idImpianto = url.split("/")[3];
      if(url.toString().indexOf('dettaglio-impianto') > -1) {
        this.showImpDrops = !url.toString().endsWith('dettaglio-impianto/' + idImpianto);
      }
    });
    this.aRoute.params.pipe(takeUntil(this.$destroy)).subscribe(params => {
      const idImpiantoDP: number = +this.sharedService.getCodiceImpiantoFromDatiPrecompilati();
      const idImpianto: number = +params['id_impianto'];
      if(!idImpiantoDP || !idImpianto) {
        return;
      }
      if(idImpianto != idImpiantoDP) {
        this.router.navigate(['/citpwa/impianto/ricerca-impianti']);
      }
    });
  }

  ngAfterContentChecked() {
    this.doChange();
  }

  doChange() {
    this.title = this.titoloService.getTitle();
    this.subtitle = this.titoloService.getsubtitle();
    this.backTitile = this.backService.getBack();
    this.route = this.backService.getRoute();
    this.queryParams = this.backService.getQueryParams();
    this.titoloMessaggio = this.messageService.getTitolo();
    this.descrzioneMessaggio = this.messageService.getDescrizione();
    this.tipomessaggio = this.messageService.getType();
    this.showMessaggio = this.messageService.getShowMessaggio();
    if(!this.router.url.includes('/scheda') && !this.router.url.includes('/documenti')) {
      this.cdref.detectChanges();
    }
  }

  ngOnDestroy(): void {
      this.$destroy.next();
      this.sharedService.datiPrecompilati = null;
      localStorage.removeItem("datiPrecompilati");
  }

}
