import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dettaglio',
  templateUrl: './dettaglio.component.html',
  styleUrls: ['./dettaglio.component.scss']
})
export class DettaglioComponent implements OnInit {

  codiceImpianto: string;

  constructor() {
  }

  ngOnInit(): void {
  }

}
