import { Location } from '@angular/common';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ConfirmDialog } from '../../../common/components/confirm-dialog/confirm-dialog.component';
import { IncarichiSoggettiDelegati } from '../../../models/accreditamento/incarichi-soggetti-delegati';
import { DatiImpresa } from '../../../models/dati-impresa';
import { UtenteLoggato } from '../../../models/utente-loggato';
import { AccreditamentoService } from '../../../services/accreditamento.service';
import { SharedService } from '../../../services/shared.service';

@Component({
  selector: 'commonwcl-nuovo-incarico',
  templateUrl: './nuovo-incarico.component.html',
  styleUrls: ['./nuovo-incarico.component.scss']
})
export class NuovoIncaricoComponent implements OnInit {

  @Input() apiUrl: any;
  @Input() impresa: DatiImpresa;
  @Input() codiceFiscalePF: string;

  @Output() onMessage = new EventEmitter<any>();

  partnerSelected: any = "";
  listaPossibiliDelegati: IncarichiSoggettiDelegati[] = [];

  constructor(
    private accreditamentoService: AccreditamentoService,
    private location: Location,
    private sharedService: SharedService,
    public dialog: MatDialog,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.accreditamentoService.init(this.apiUrl);
    this.accreditamentoService.getIncarichiSoggettiDelegati().subscribe((data: any) => {
      this.listaPossibiliDelegati = data;
    });
  }

  goBack() {
    this.router.navigate(['/accreditamento']);
  }

  aggiungi() {
    //mostra modale
    this.dialog.open(ConfirmDialog, {
      data: {
        titolo: 'Conferma aggiunta',
        premessa: "Attenzione: ",
        descrizione: 'Sei sicuro di voler aggiungere questo incarico?'
      }
    }).afterClosed().subscribe((result) => {
      if (result) {
        //aggiungi incarico

        let utenteLoggato: UtenteLoggato = this.sharedService.getUtenteLoggato();
        this.accreditamentoService.setIncaricoSoggettoDelegato(utenteLoggato.pfLoggato.codiceFiscalePF, this.impresa.id_persona_giuridica, this.partnerSelected).subscribe((data: any) => {
          this.onMessage.emit({ titolo: "Incarico aggiunto", descrizione: "Incarico aggiunto con successo", type: 4 });
          // this.router.navigate(['/accreditamento']);
          // this.location.back();
        }, (error) => {
          let titolo = "Impossibile aggiungere l'incarico";
          let descrizioni = "Impossibile aggiungere l'incarico. Riprovare in seguito o contattare il supporto";
          if (error?.error && error?.error) {
            if (JSON.parse(error.error).descrizioneEsito === "S128") {
              titolo = "Incarico già presente";
              descrizioni = "Esiste già un incarico attivo tra Soggetto Incaricato selezionato ed Impresa";
            }
          }
          this.onMessage.emit({ titolo: titolo, descrizione: descrizioni, type: 1 });
          console.log("Errore aggiunta incarico");
          // this.location.back();
          //show error message
        });
      }
    });
  }
}
