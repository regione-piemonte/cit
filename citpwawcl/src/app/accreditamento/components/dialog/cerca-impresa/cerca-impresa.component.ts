import { ChangeDetectorRef, Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { AccreditamentoService } from '@sigit/common-lib';
import { DatiImpresa } from '@sigit/common-lib/lib/models/dati-impresa';
import { Subject } from 'rxjs';
import { RicercaPgDialogComponent } from 'src/app/dettaglio-comp/components/ricerca-pg-dialog/ricerca-pg-dialog.component';
import { BackService } from 'src/app/services/back.service';
import { MessageService } from 'src/app/services/message.service';
import { SharedService } from 'src/app/services/shared.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { SvistaService } from 'src/app/services/svista.service';
import { TitleService } from 'src/app/services/title.service';
import { ICONSURL } from 'src/app/utils/constants';
import { validateAlphanumeric, validateCFPIVA } from 'src/app/validators/custom.validator';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-cerca-impresa',
  templateUrl: './cerca-impresa.component.html',
  styleUrls: ['./cerca-impresa.component.scss']
})
export class CercaImpresaComponent implements OnInit {

  title: string = "";
  subtitle: string = "";
  backTitile: string = "";
  route: string = "";
  titoloMessaggio: string = "";
  descrzioneMessaggio: string = "";
  tipomessaggio: number = 0;
  showMessaggio: boolean = false;
  $destroy = new Subject();
  showImpDrops: boolean = false;

  searchForm: FormGroup;
  closeGrigio: string = ICONSURL + "close-grigio.png";
  titoloErrore = "";
  descrizioneErrore = "";
  imprese: DatiImpresa[] = [];

  searched: boolean;

  redirectURL: string;
  queryParam: any;
  fromUrl: string;

  constructor(
    @Inject(MAT_DIALOG_DATA) public data,
    public dialogRef: MatDialogRef<RicercaPgDialogComponent>,
    readonly titoloService: TitleService,
    readonly backService: BackService,
    readonly messageService: MessageService,
    readonly spinnerService: SpinnerService,
    private svistaService: SvistaService,
    readonly sharedService: SharedService,
    @Inject(AccreditamentoService) private accreditamentoService: AccreditamentoService,
    private cdref: ChangeDetectorRef,
    private router: Router,
    private fb: FormBuilder,
    private aRoute: ActivatedRoute
  ) {
    this.accreditamentoService.init(environment.apiUrl);
    this.searchForm = fb.group({
      cf: ["", validateCFPIVA],
      siglaRea: ["", validateAlphanumeric],
      numeroRea: ["", Validators.pattern("[0-9]+")]
    });
    if (!data.redirectUrl) {
      console.log("redirectUrl non presente!!");
    } else {
      this.redirectURL = data.redirectUrl;
      this.queryParam = data.queryParam;
    }
    if(data.fromUrl) {
      this.fromUrl = data.fromUrl;
    }
  }

  ngOnInit(): void {
    // this.init();
    this.titoloService.setTitle("Cerca impresa");
    this.route = "/";
    this.backTitile = "Torna alla home"
    this.backService.setBackTitle(this.backTitile);
    this.backService.setRoute("/");
    this.svistaService.saveComuniEstesiToLocalStorage();
  }

  closeDialog() {
    this.dialogRef.close();
  }

  private checkImpresaFilter(i: DatiImpresa): boolean {
    return !this.data.checkImpresa || (i.flg_terzo_responsabile === 1 || i.flg_distributore === 1 || i.flg_cat === 1 || i.flg_dm37_letterac === 1 || i.flg_dm37_letterad === 1 || i.flg_dm37_letterae === 1 || i.flg_fgas === 1 || i.flg_conduttore === 1);
  }

  cercaPerCF() {
    this.imprese = [];
    this.accreditamentoService.getDatiImpresa(this.searchForm.controls.cf.value, null, null).subscribe((elem: DatiImpresa[]) => {
      this.searched = true;
      this.imprese = elem.filter(i => this.checkImpresaFilter(i));
    });
  }

  cercaPerREA() {
    this.imprese = [];
    this.accreditamentoService.getDatiImpresa(undefined, this.searchForm.controls.siglaRea.value, this.searchForm.controls.numeroRea.value).subscribe((elem: DatiImpresa[]) => {
      this.searched = true;
      this.imprese = elem.filter(i => this.checkImpresaFilter(i));
    }, error => {
      this.setErrorStatus(error);
    });
  }

  setErrorStatus(error: any) {
    this.searched = true;
    if (error.status === 404) {
      this.imprese = [];
    }
  }

  inserisciComponente(event: any) {
    console.log(event);
  }

  goToGestioneDati(impresa: DatiImpresa) {

    this.sharedService.setImpresaSelected(impresa);
    this.router.navigateByUrl(this.fromUrl, { skipLocationChange: true }).then(() => {
      this.router.navigate([this.redirectURL],
        {
          queryParams: this.queryParam,
          state: {
            impresa: impresa
          },
        }
      );
    });

    // }
    this.closeDialog();
  }

  calcRowSpan(testo: string) {
    if (testo.length < 25) {
      return 1;
    } else if (testo.length < 50) {
      return 2;
    }
    return 3;
  }
}
