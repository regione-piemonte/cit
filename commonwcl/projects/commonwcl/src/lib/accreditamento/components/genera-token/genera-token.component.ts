import { Component, EventEmitter, HostListener, Input, OnInit, Output } from '@angular/core';
import { DatiToken } from '../../../models/dati-token';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AccreditamentoService } from '../../../services/accreditamento.service';
import { DatiImpresa } from '../../../models/dati-impresa';
import { Router } from '@angular/router';
import { ICONSURL } from '../../../utils/constants';

@Component({
  selector: 'commonwcl-genera-token',
  templateUrl: './genera-token.component.html',
  styleUrls: ['./genera-token.component.scss']
})
export class GeneraTokenComponent implements OnInit {
  @Input() apiUrl: string;
  @Output() onMessage = new EventEmitter<any>();

  datiToken: DatiToken;
  datiTokenForm: FormGroup;
  impresa: DatiImpresa;
  pgRed: string = ICONSURL + "impresa_red.svg";
  colBreakpoint1: number;

  constructor(private fb: FormBuilder,  private accreditamentoService: AccreditamentoService, private router: Router){
    this.createFormGroup();

    const navigation = this.router.getCurrentNavigation();
    const state = navigation?.extras.state as { impresa: any };
    this.impresa = state.impresa;

    this.prepareView();
  }

   createFormGroup() {
      this.datiTokenForm = this.fb.group({
        denominazione: [{ value: "", disabled: true }, [Validators.required]],
        codiceRea: [{ value: "", disabled: true }, [Validators.required]],
        codiceFiscale: [{ value: "", disabled: true }, [Validators.required]],
        token: [{ value: "", disabled: true }, [Validators.required]],
        dtCreazioneToken: [{ value: "", disabled: true }, [Validators.required]],
        dtScadenzaToken: [{ value: "", disabled: true }, [Validators.required]]
      });
  }

  ngOnInit(): void {
    this.accreditamentoService.init(this.apiUrl);

    if (this.impresa?.id_persona_giuridica != undefined) {
        this.accreditamentoService
          .getDatiTokenImpresa(this.impresa.id_persona_giuridica)
          .subscribe((token: any) => {
           this.datiToken = new DatiToken(
          token.id_persona_giuridica,
          token.denominazione,
          token.codice_fiscale,
          token.sigla_rea,
          token.numero_rea,
          token.token,
          token.dt_creazione_token,
          token.dt_scadenza_token
        );
            this.patchFormGroupValue();
          });
      }
  }

  prepareView() {
      this.colBreakpoint1 = (window.innerWidth < 768) ? 12 : 6;
      //this.rowSpanHigh = window.innerWidth < 768 ? 4 : 2;
      window.scrollTo(0, 0);
  }

  @HostListener('window:resize', ['$event'])
    onResize(event?) {
        this.prepareView();
  }

  patchFormGroupValue() {
    if (!this.datiToken) return;

  function formatDate(isoDate: string): string {
    if (!isoDate) return "";
    const onlyDate = isoDate.split("T")[0];
    const [year, month, day] = onlyDate.split("-");
    return `${day}-${month}-${year}`;
  }

    this.datiTokenForm.patchValue({
      denominazione: this.datiToken.denominazione,
      codiceRea: this.datiToken.siglaRea + "-" + this.datiToken.numeroRea,
      codiceFiscale: this.datiToken.codiceFiscale,
      token: this.datiToken.token,
      dtCreazioneToken: formatDate(this.datiToken.dtCreazioneToken),
      dtScadenzaToken: formatDate(this.datiToken.dtScadenzaToken)
    });
  }

  annulla() {
    this.router.navigate(['accreditamento/gestione-dati']);
  }

  salvaToken() {
    if (this.impresa.id_persona_giuridica != undefined) {
      this.accreditamentoService
        .generateTokenImpresa(this.impresa.id_persona_giuridica)
        .subscribe(
          (data) => {
            this.onMessage.emit({
              titolo: "Successo",
              descrizione: "Il token è stato generato con successo.",
              type: 4,
              reload: false
            });

            this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
              this.router.navigate(
                ['accreditamento/genera-token'],
                { state: { impresa: this.impresa } }
              );
            });
          },
          (error) => {
            this.onMessage.emit({
              titolo: "Errore",
              descrizione: "Errore nella generazione del token.",
              type: 2
            });
            console.log("Errore");
            console.log(error);
          }
        );
    }
  }


}
