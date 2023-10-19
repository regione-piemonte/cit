import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { tipiDocDesc } from 'src/app/enums/tipo-doc-enum';
import { CodiceDescrizione } from 'src/app/models/codice-descrizione';
import { ControlloDisponibileModel } from 'src/app/models/controllo-disponibile';
import { ControlloModel } from 'src/app/models/controllo-model';
import { DatoControlloModel } from 'src/app/models/dato-controllo-model';
import { Esito } from 'src/app/models/esito';
import { ManutFormModel } from 'src/app/models/manut-form-model';
import { OnlineCheckModel } from 'src/app/models/online-check-model';
import { OperazioneControlloModel } from 'src/app/models/operazione-controllo-model';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { ControlloService } from 'src/app/services/controllo.service';
import { LocalStorageServiceService } from 'src/app/services/local-storage-service.service';
import { MessageService } from 'src/app/services/message.service';
import { ResultService } from 'src/app/services/result.service';
import { TitleService } from 'src/app/services/title.service';
import { ESITO_OPERAZIONI, FORMAT, OPERAZIONI, STATO_RAPP, TIPO_INTERVENTO } from 'src/app/utils/constants';
import { v4 as uuidv4 } from 'uuid';

@Component({
  selector: 'app-aggiungi-manutenzione',
  templateUrl: './aggiungi-manutenzione.component.html',
  styleUrls: ['./aggiungi-manutenzione.component.scss']
})
export class AggiungiManutenzioneComponent implements OnInit {

  success = false;
  offline = false;
  insertForm: FormGroup;
  interventi: CodiceDescrizione[] = [];
  controllo: ControlloDisponibileModel;
  utente: UtenteLoggato;


  codiceImpianto: string = "";
  constructor(
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private readonly controlloService: ControlloService,
    private authenticationService: AuthenticationService,
    private router: Router,
    private readonly titleService: TitleService,
    private readonly backService: BackService,
    private readonly messageService: MessageService,
    private resultService: ResultService,
    private datePipe: DatePipe,
    private readonly localStorageService: LocalStorageServiceService) {

    this.codiceImpianto = this.route.snapshot.parent.paramMap.get('id_impianto');
    this.insertForm = this.fb.group({
      dataControllo: [{ value: "", disabled: true }],
      tipoControllo: [{ value: "", disabled: true }],
      tipoComponente: [{ value: "", disabled: true }],
      tipoIntervento: ["", [Validators.required]],
      osservazioni: [""],
      raccomandazioni: [""],
      prescrizioni: [""],
      dataIntervento: ["", [Validators.required]],
      nomeCognome: ["", [Validators.required]],
      oraArrivo: [""],
      oraPartenza: [""]
    });

    this.utente = authenticationService.getCurrentUserFromSession();
  }

  ngOnInit(): void {
    this.controllo = this.resultService.getResultControlloDisponibile();
    this.interventi = [new CodiceDescrizione(TIPO_INTERVENTO.PULIZIA.toLocaleString(), "Pulizia"),
    new CodiceDescrizione(TIPO_INTERVENTO.CONTROLLO_COMBUSTIONE.toLocaleString(), "Controllo combustione"),
    new CodiceDescrizione(TIPO_INTERVENTO.ALTRO.toLocaleString(), "Altro")];
    if (this.controllo) {
      this.insertForm.controls.dataControllo.setValue(new Date(this.controllo.dataControllo));
      this.insertForm.controls.tipoControllo.setValue(tipiDocDesc.get(this.controllo.tipoControllo));
      this.insertForm.controls.tipoComponente.setValue(this.controllo.tipoComponente);
      this.titleService.setTitle("Aggiungi manutenzione");
      this.backService.setBackTitle("Annulla e torna indietro");
      this.backService.setRoute("/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli/cerca-controlli");
    } else
      this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli/cerca-controlli"]);

    this.controlloService.getOnlineSubject().subscribe((elem) => {
      this.offline = !elem;
    });
  }

  salvaEInvia() {
    if (this.insertForm.valid) {
      let values = this.insertForm.value;
      let manut = new ManutFormModel();
      manut.oraArrivo = values.oraArrivo;
      manut.oraPartenza = values.oraPartenza;
      manut.nomeCognomeTecnico = values.nomeCognome;
      manut.osservazioni = values.osservazioni;
      manut.prescrizioni = values.prescrizioni;
      manut.raccomandazioni = values.raccomandazioni;
      manut.prossimoInterventoEntro = values.dataIntervento ? this.datePipe.transform(values.dataIntervento, FORMAT) : "";
      manut.dataControllo = this.controllo.dataControllo;
      manut.tipoControllo = this.controllo.tipoControllo;
      manut.tipoComponente = this.controllo.tipoComponente;
      manut.tipoIntervento = values.tipoIntervento;
      manut.progressivo = this.controllo.progressivo;
      manut.codiceFiscale = this.controllo.cfPIvaImpresa;
      manut.siglaRea = this.controllo.siglaReaImpresa;
      manut.numeroRea = this.controllo.numeroReaImpresa;

      let controllo = new ControlloModel();
      controllo.dataControllo = this.controllo.dataControllo;
      controllo.desTipoDocumento = tipiDocDesc.get(this.controllo.tipoControllo);
      controllo.fkStatoRapp = STATO_RAPP.IN_ATTESA_DI_INVIO;
      controllo.elencoApparecchiatura = this.controllo.nomeComponente;
      controllo.fInterventoEntro = manut.prossimoInterventoEntro;
      controllo.fkTipoDocumento = Number(this.controllo.tipoControllo);
      let dato = new DatoControlloModel();
      dato.controlloModel = controllo;
      dato.fkStatoPrec = STATO_RAPP.BOZZA_LOCALE;
      dato.manut = manut;
      let operazione = this.createOperazioneOffline();
      this.controlloService.inviaManutenzione(this.codiceImpianto, manut.tipoControllo, manut, operazione).subscribe(elem => {
        this.router.navigate(["impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli", { success: true }]);
      }, error => {
        if (error instanceof OnlineCheckModel) {
          dato.tempIdControllo = operazione.idOperazione;
          this.localStorageService.addBozzeLocali(dato,this.codiceImpianto);
          this.router.navigate(["impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli"]);
        } else {
          this.messageService.setType(2);
          this.messageService.setTitolo("Errore invio controllo");
          let errore: Esito = error.error as Esito;
          this.messageService.setDescrizione(errore.descrizioneEsito);
          this.messageService.showMessaggioM();
        }
      });
    } else {
      this.insertForm.markAllAsTouched();
      this.messageService.setType(2);
      this.messageService.setTitolo("Dati controllo mancanti");
      this.messageService.setDescrizione("Compilare tutti i campi e riprovare");
      this.messageService.showMessaggioM();
    }
  }

  getByValue(map, searchValue) {
    for (let [key, value] of map.entries()) {
      if (value === searchValue)
        return key;
    }
  }

  createOperazioneOffline() {
    let operazione = new OperazioneControlloModel();
    operazione.codiceImpianto = this.codiceImpianto;
    let uuid = uuidv4();
    operazione.idOperazione = uuid;
    operazione.dataControllo = this.controllo.dataControllo;
    operazione.dataInserimento = this.datePipe.transform(new Date(), FORMAT);
    operazione.dataInvioOnline = undefined;
    operazione.descrizioneOperazione = OPERAZIONI.INVIO;
    operazione.utente = this.utente;
    operazione.esito = ESITO_OPERAZIONI.PENDING;
    return operazione;
  }

  myFilter = (d: Date | null): boolean => {
    if (this.controllo && this.controllo.dataControllo)
      return d > new Date(this.controllo.dataControllo);
    else
      return true;
  }
}
