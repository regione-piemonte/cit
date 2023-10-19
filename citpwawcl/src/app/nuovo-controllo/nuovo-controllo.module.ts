import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { CommonCompModule } from '../common/common.module';
import { AggiungiManutenzioneComponent } from './components/pages/aggiungi-manutenzione/aggiungi-manutenzione.component';
import { DettaglioTipo1BComponent } from './components/pages/dettaglio-tipo1-b/dettaglio-tipo1-b.component';
import { DettaglioTipo1Component } from './components/pages/dettaglio-tipo1/dettaglio-tipo1.component';
import { DettaglioTipo2Component } from './components/pages/dettaglio-tipo2/dettaglio-tipo2.component';
import { DettaglioTipo3Component } from './components/pages/dettaglio-tipo3/dettaglio-tipo3.component';
import { DettaglioTipo4Component } from './components/pages/dettaglio-tipo4/dettaglio-tipo4.component';
import { ValidatorDirectiveDirective } from './directives/validator-directive.directive';



@NgModule({
  declarations: [
    AggiungiManutenzioneComponent,
    DettaglioTipo1Component,
    DettaglioTipo1BComponent,
    DettaglioTipo2Component,
    DettaglioTipo3Component,
    DettaglioTipo4Component,
    ValidatorDirectiveDirective
  ],
  imports: [
    CommonCompModule,
    CommonModule
  ]
})
export class NuovoControlloModule { }
