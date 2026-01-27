import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Persona } from 'src/app/models/persona';


@Component({
  selector: 'app-ricerca-pg-result',
  templateUrl: './ricerca-pg-result.component.html',
  styleUrls: ['./ricerca-pg-result.component.scss']
})
export class RicercaPgResultComponent implements OnInit {

  @Input()
  persone: Persona[];
  @Output() inserisciComponente = new EventEmitter<Persona>();

  constructor() {
    //Not Implemented
   }

  ngOnInit(): void {
    //Not Implemented
  }

  inserisci(persona: Persona) {
    this.inserisciComponente.emit(persona);
  }
}
