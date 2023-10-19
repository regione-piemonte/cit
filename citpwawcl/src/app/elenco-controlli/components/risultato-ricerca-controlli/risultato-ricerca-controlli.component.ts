import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { tipiDocDesc, TipoDoc } from 'src/app/enums/tipo-doc-enum';
import { ControlloDisponibileModel } from 'src/app/models/controllo-disponibile';
import { ResultService } from 'src/app/services/result.service';

@Component({
  selector: 'app-risultato-ricerca-controlli',
  templateUrl: './risultato-ricerca-controlli.component.html',
  styleUrls: ['./risultato-ricerca-controlli.component.scss']
})
export class RisultatoRicercaControlliComponent implements OnInit {

  @Input()
  result: ControlloDisponibileModel[];

  @Output() closeSearch = new EventEmitter<boolean>();

  tipiDoc = tipiDocDesc;
  codiceImpianto: string;

  constructor(private router: Router, private route: ActivatedRoute, private resultService: ResultService) {
    this.codiceImpianto = this.route.snapshot.parent.paramMap.get('id_impianto');
  }

  ngOnInit(): void {
    if (!this.result) {
      this.closeSearch.emit(false);
    }
  }

  nuovaRicerca() {
    this.closeSearch.emit(false);
  }

  apriNuovoControllo(elem: ControlloDisponibileModel) {
    this.resultService.setResultControlloDisponibile(elem);
    switch (elem.tipoControllo) {
      case TipoDoc.REE_1:
        this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli/aggiungi-ree-tipo1"]);
        break;
      case TipoDoc.REE_1B:
        this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli/aggiungi-ree-tipo1B"]);
        break;
      case TipoDoc.REE_2:
        this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli/aggiungi-ree-tipo2"]);
        break;
      case TipoDoc.REE_3:
        this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli/aggiungi-ree-tipo3"]);
        break;
      case TipoDoc.REE_4:
        this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli/aggiungi-ree-tipo4"]);
        break;
      case TipoDoc.MANUT_GT:
      case TipoDoc.MANUT_GF:
      case TipoDoc.MANUT_SC:
      case TipoDoc.MANUT_CG:
        this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli/aggiungi-manutenzione"]);
        break;
    }
  }
}
