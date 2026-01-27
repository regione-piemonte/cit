import { DatePipe } from '@angular/common';
import { Component, HostListener, OnInit } from '@angular/core';
import { FormBuilder, FormControl } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { CercaImpresaComponent } from 'src/app/accreditamento/components/dialog/cerca-impresa/cerca-impresa.component';
import { DettaglioNomina } from 'src/app/models/dettaglio-nomina';
import { BackService } from 'src/app/services/back.service';
import { MessageService } from 'src/app/services/message.service';
import { NominaTerzoResponsabileService } from 'src/app/services/nomina.service';
import { SharedService } from 'src/app/services/shared.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { TitleService } from 'src/app/services/title.service';
import { DISPLAY_FORMAT, RUOLI } from 'src/app/utils/constants';
import { AuthenticationService } from '../../../services/authentication.service';

@Component({
    selector: 'app-dettaglio-nomina',
    templateUrl: './dettaglio-nomina.component.html',
    styleUrls: ['./dettaglio-nomina.component.scss']
})
export class DettaglioNominaComponent implements OnInit {

    datiPrecompilati: any;
    nomina;
    dettaglioNomina: DettaglioNomina;
    id_contratto: any;
    codice_impianto: any;
    voidCtrl: FormControl;

    titoloMessaggio;
    descrzioneMessaggio;
    tipomessaggio;
    showMessaggio: boolean = false;
    tipoCessazioni = [];

    rowLongMobile = 1;

    dataValiditaContrattoDal: any;
    dataUltimaNominaDal: any;


    constructor(
        private titleService: TitleService,
        private backService: BackService,
        private router: Router,
        private activatedRoute: ActivatedRoute,
        private sharedService: SharedService,
        private authenticationService: AuthenticationService,
        private nominaService: NominaTerzoResponsabileService,
        readonly spinnerService: SpinnerService,
        private dialog: MatDialog,
        private messageService: MessageService,
        private datepipe: DatePipe,
        private fb: FormBuilder
    ) {
        this.titleService.setTitle("Dettaglio Nomina Terzo Responsabile");
        this.backService.setBackTitle("Torna a Elenco Storico Terza Responsabilità");
        this.backService.setRoute(null);
        this.voidCtrl = new FormControl();
        this.nominaService.getTipoCessazione().subscribe((data) => {
            console.log(data);
            this.tipoCessazioni = data;
        });
        this.activatedRoute.queryParams.subscribe(params => {
            this.id_contratto = params.idContratto;
            this.dataValiditaContrattoDal = params.dataValiditaContrattoDal;
            this.dataUltimaNominaDal = params.dataUltimaNominaDal;
            let libretto = this.sharedService.getLibrettoXmlNow();
            this.codice_impianto = libretto?.MOD?.Richiesta?.datiPrecompilati?.codice_impianto;
            if (Array.isArray(libretto?.MOD?.Richiesta?.datiPrecompilati?.sezNomine?.rowNomine)) {
                libretto?.MOD?.Richiesta?.datiPrecompilati?.sezNomine?.rowNomine.filter((nomina) => {
                    if (nomina.L3idContratto == this.id_contratto) {
                        this.nomina = nomina;
                    }
                });
            } else {
                this.nomina = libretto?.MOD?.Richiesta?.datiPrecompilati?.sezNomine?.rowNomine;
            }
            console.log("nomina: " + this.nomina)

            this.nominaService.getDettaglioNomina(this.id_contratto, this.codice_impianto).subscribe((data) => {
                console.log(data);
                this.dettaglioNomina = data;
            });
        });
    }

    ngOnInit(): void {
        // Initialization code goes here
        this.rowLongMobile = (window.innerWidth < 768) ? 2 : 1;
    }

    @HostListener('window:resize', ['$event'])
    onResize(event?) {
        this.rowLongMobile = (event.target.innerWidth < 768) ? 2 : 1;
    }

    addAffidamento() {
        this.dialog.open(CercaImpresaComponent, {
            width: "90%",
            height: '90%',
            maxWidth: "500px",
            data: {
                fromUrl: this.router.url,
                redirectUrl: '/nomina/seleziona-affidamento',
                checkImpresa: true,
                queryParam: {
                    codiceImpianto: this.codice_impianto,
                    idContratto: this.id_contratto,
                    affidamentoOccasionale: true,
                    cf: this.dettaglioNomina.datiImpresa[0].codice_fiscale,
                    returnUrl: 'impianto/dettaglio-impianto/' + this.codice_impianto
                }
            }
        }).afterClosed().subscribe();
    }



    visualizzaDocumentiContratto() {
        this.router.navigate(['../documenti-contratto'], {
            queryParams: {
                idContratto: this.id_contratto
            },
            relativeTo: this.activatedRoute
        });
    }

    cessazione() {
        this.router.navigate(['/nomina/cessazione'], {
            relativeTo: this.activatedRoute, queryParams: {
                id_contratto: this.id_contratto,
                codice_impianto: this.codice_impianto,
                nomina: JSON.stringify(this.nomina)
            }
        });
    }

    proroga() {
        this.router.navigate(['/nomina/proroga'], {
            relativeTo: this.activatedRoute, queryParams: {
                id_contratto: this.id_contratto,
                codice_impianto: this.codice_impianto,
                nomina: JSON.stringify(this.nomina)
            }
        });
    }

    deleteAffidamento(affidamento, index) {
        console.log(affidamento);
        let utenteLoggato = this.authenticationService.getCurrentUserFromSession();
        let cf = utenteLoggato.pfLoggato.codiceFiscalePF;
        let idPersonaGiuridica = this.dettaglioNomina.datiImpresa[0]?.id_persona_giuridica;
        if (!idPersonaGiuridica) {
            this.messageService.setTitolo("Errore");
            this.messageService.setDescrizione("Bisogna selezionare un ruolo per poter eliminare la delega");
            this.messageService.showMessaggioM();
            this.messageService.setType(2);
        }
        this.nominaService.deleteAffidamento(cf, idPersonaGiuridica, this.codice_impianto, affidamento).subscribe((data) => {
            this.messageService.setTitolo("Operazione completata");
            this.messageService.setDescrizione("La delega è stato eliminata con successo");
            this.messageService.showMessaggioM();
            this.messageService.setType(4);
            this.dettaglioNomina?.datiAffidamento?.splice(index, 1);
        }, (error) => {
            this.messageService.setTitolo("Operazione non riuscita");
            this.messageService.setDescrizione("Impossibile eliminare la delega");
            this.messageService.showMessaggioM();
            this.messageService.setType(2);
        });
    }

    getDate(data: string | any) {
        if (data)
            return this.datepipe.transform(data.split("[")[0], DISPLAY_FORMAT);
        else
            return "-";
    }

    getTipoCessazione(id: string) {
        if (this.tipoCessazioni) {
            for (let element of this.tipoCessazioni) {
                if (Object.keys(element)[0] == id) {
                    return element[id];
                }
            }
        }
        return "";
    }

    getAutodichiarazioni(code: string): string {
      return this.dettaglioNomina?.autodichiarazione
        .filter((e) => e.flgNominaCessa === code)
        .map((e) => e.desAutodichiarazione)
        .join(', ');
    }

    isDatiAffidamentoVisible(): boolean {
      const dataCessazione = this.dettaglioNomina?.datiContratto[0]?.data_cessazione;

      if (dataCessazione) {
        const iso = dataCessazione.replace('[UTC]', '');

        try {
          const date = new Date(iso);

          return date > new Date();
        } catch (e) {
          return false;
        }
      }

      return true;
    }

    isAddDeleteAffidamentoVisible(): boolean {
      const user = this.authenticationService.getCurrentUserFromSession();
      return [RUOLI.RUOLO_3RESPONSABILE, RUOLI.RUOLO_RESPONSABILE_IMPRESA]
          .includes(user?.ruoloLoggato?.ruolo);
    }

    isCessazioneVisible(): boolean {
      const user = this.authenticationService.getCurrentUserFromSession();
      return [RUOLI.RUOLO_3RESPONSABILE, RUOLI.RUOLO_RESPONSABILE, RUOLI.RUOLO_RESPONSABILE_IMPRESA, RUOLI.RUOLO_SUPER, RUOLI.RUOLO_VALIDATORE]
          .includes(user?.ruoloLoggato?.ruolo) && !this.dettaglioNomina?.datiContratto[0]?.data_cessazione;
    }

    isProrogaVisible(): boolean {
      const user = this.authenticationService.getCurrentUserFromSession();
      
      if(this.dataValiditaContrattoDal.localeCompare(this.dataUltimaNominaDal)==0){              
        return [RUOLI.RUOLO_3RESPONSABILE, RUOLI.RUOLO_RESPONSABILE_IMPRESA, RUOLI.RUOLO_SUPER, RUOLI.RUOLO_VALIDATORE]
          .includes(user?.ruoloLoggato?.ruolo);      
      }else{
        return false;
      }
    }
}
